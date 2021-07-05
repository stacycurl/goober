import java.io.PrintWriter
import java.lang.reflect.Parameter
import java.lang.{reflect ⇒ R}
import goober.free.Module
import org.reflections.Reflections
import sbt.Def.task
import sbt.{Def, Task, TaskKey, taskKey}

import scala.collection.JavaConverters._
import scala.reflect.ClassTag

object goober {
  object free {
    object generator {
      val generate: TaskKey[Unit] = taskKey[Unit]("generate")

      val generateTask: Def.Initialize[Task[Unit]] = task {
        val reflections =
          new Reflections("software.amazon.awssdk.services")

        val subTypes: List[Class[_]] =
          reflections
            .getSubTypesOf(classOf[software.amazon.awssdk.core.SdkClient])
            .asScala
            .toList
            .filter(_.isInterface)
            .filterNot(_.getSimpleName.endsWith("AsyncClient"))
            .sortBy(_.getSimpleName)

        Modules.create(
          subTypes.map(Module.create): _*
        ).writeTo("./free/src/main/scala/goober/free")
      }
    }

    implicit class StringSyntax(private val self: String) extends AnyVal {
      def getLines: List[String] =
        self.split("\n", -1).toList

      def trimTrailing: String =
        self.replaceAll("\\s+$", "")
    }

    implicit class AnySyntax[A](private val self: A) extends AnyVal {
      def indentBy(by: String): String =
        self.toString.getLines.mkString(s"\n$by")
    }

    object Modules {
      def create(values: Module*): Modules =
        new Modules(values.toList)
    }

    case class Modules(values: List[Module]) {
      def ioImports: Imports =
        Imports(values.map(_.names.ioImport))

      def clientImports =
        Imports(values.map(_.names.clientImport))

      def opImports: Imports =
        Imports(values.map(_.names.opImport))

      def writeTo(directory: String): Unit = {
        values.foreach(_.fileContents.writeTo(directory))
        Embedded(this).fileContents.writeTo(directory)
        KleisliInterpreter(this).fileContents.writeTo(directory)
      }
    }

    object Module {
      def create[Client: ClassTag]: Module =
        create(implicitly[ClassTag[Client]].runtimeClass)

      def create(clazz: Class[_]): Module = {
        val module =
          customModules.getOrElse(clazz, parentPackage(clazz))

        val name =
          clazz.getSimpleName.stripSuffix("Client")

        create(
          clazz,
          Names(
            module = module,
            clientImport = clazz.getName,
            client = clazz.getSimpleName,
            io = s"${name}IO",
            op = s"${name}Op"
          )
        )
      }

      def create(clazz: Class[_], names: Names): Module =
        create(names, importsFor(clazz), methodsIn(clazz))

      def create(names: Names, imports: Imports, methods: List[R.Method]): Module =
        Module(names, imports, Companion.create(names, methods), SmartConstructors.create(names, methods))

      private def importsFor(clazz: Class[_]): Imports = Imports.create(
        clazz.getName,
        s"software.amazon.awssdk.services.${customModelPackages.getOrElse(clazz, parentPackage(clazz))}.model._",
        "java.nio.file.Path",
        "software.amazon.awssdk.core.sync.RequestBody"
      )

      def parentPackage(clazz: Class[_]): String =
        clazz.getPackage.getName.split("\\.").last

      private lazy val customModelPackages: Map[Class[_], String] = Map(
        classOf[software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient] → "dynamodb",
        classOf[software.amazon.awssdk.services.waf.regional.WafRegionalClient] → "waf"
      )

      private lazy val customModules: Map[Class[_], String] = Map(
        classOf[software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient] → "dynamodbstreams",
        classOf[software.amazon.awssdk.services.waf.regional.WafRegionalClient] → "wafregional"
      )

      private def methodsIn(clazz: Class[_]): List[R.Method] = {
        clazz.getDeclaredMethods.toList
          .filterNot(isExcluded)
          .filterNot(isStatic)
          .groupBy(_.getName)
          .flatMap(choosePreferred)
          .toList
          .sortBy(_.getName)
      }

      private def isExcluded(method: R.Method): Boolean = {
        method.getName.endsWith("Paginator")           ||
        method.getName.endsWith("Torrent")             ||
          excludedNames.contains(method.getName)       ||
          excludedTypes.contains(method.getReturnType) ||
          method.getParameterTypes.isEmpty             ||
          method.getParameterTypes.exists(excludedTypes.contains)
      }

      private def isStatic(method: R.Method): Boolean =
        R.Modifier.isStatic(method.getModifiers)

      private def choosePreferred(values: (String, List[R.Method])): Option[R.Method] = {
        val sorted = values._2.sortBy(_.getParameterTypes.toList)(
          Ordering.Implicits.seqDerivedOrdering[List, Class[_]](
            indexOfOrdering(preferredTypes)
          )
        )
        // println(s"${values._1}: $sorted")
        sorted.headOption
      }

      private def indexOfOrdering[A](list: List[A]): Ordering[A] = Ordering.Int.on[A](a ⇒ {
        val result = list.indexOf(a)

        if (result == -1) Int.MaxValue else result
      })

      private lazy val excludedNames: Set[String] = Set("utilities")

      private lazy val excludedTypes: Set[Class[_]] = Set(
        classOf[java.util.function.Consumer[_]],
        classOf[software.amazon.awssdk.core.ResponseBytes[_]],
        classOf[software.amazon.awssdk.core.ResponseInputStream[_]],
        classOf[software.amazon.awssdk.core.sync.ResponseTransformer[_, _]]
      )

      private lazy val preferredTypes: List[Class[_]] = List(
        classOf[software.amazon.awssdk.core.sync.RequestBody],
        classOf[java.nio.file.Path]
      )
    }

    case class Module(
      names: Names,
      imports: Imports,
      companion: Companion,
      smartConstructors: SmartConstructors
    ) {
      def interpreterValue: String =
        s"""lazy val ${names.embedded}Interpreter: ${names.op} ~> Kleisli[M, ${names.client}, *] = new ${names.embedded}Interpreter {
           |  def primitive[A](f: ${names.client} ⇒ A): Kleisli[M, ${names.client}, A] = interpreter.primitive(f)
           |}""".stripMargin

      def interpreterTrait: String =
        s"""trait ${names.embedded}Interpreter extends ${names.op}.Visitor.KleisliVisitor[M] {
           |  def embed[A](e: Embedded[A]): Kleisli[M, ${names.client}, A] = interpreter.embed(e)
           |}""".stripMargin

      def embeddedClass: String =
        s"final case class ${names.embedded}[A](client: ${names.client}, io: ${names.io}[A]) extends Embedded[A]"

      def embeddedCase: String =
        s"case Embedded.${names.embedded}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ${names.client}, *]](${names.embedded}Interpreter).run(client))"

      def fileContents: FileContents =
        FileContents(s"${names.module}.scala", toString)

      override def toString: String =
        s"""package goober.free
           |
           |import scala.language.higherKinds
           |
           |import cats.free.{Free => FF}
           |import cats.~>
           |import cats.data.Kleisli
           |$imports
           |
           |object ${names.module} { module =>
           |
           |  // Free monad over ${names.op}
           |  type ${names.io}[A] = FF[${names.op}, A]
           |
           |  sealed trait ${names.op}[A] {
           |    def visit[F[_]](visitor: ${names.op}.Visitor[F]): F[A]
           |  }
           |
           |  ${companion.indentBy("  ")}
           |
           |  ${smartConstructors.indentBy("  ")}
           |}
           |""".stripMargin
    }

    object Companion {
      def create(names: Names, methods: List[R.Method]): Companion =
        new Companion(names, Visitor.create(names, methods), Implementations.create(names, methods))
    }

    case class Companion(
      names: Names,
      visitor: Visitor,
      implementations: Implementations
    ) {

      override def toString: String =
        s"""object ${names.op} {
           |  // Given a ${names.client} we can embed a ${names.io} program in any algebra that understands embedding.
           |  implicit val ${names.op}Embeddable: Embeddable[${names.op}, ${names.client}] = new Embeddable[${names.op}, ${names.client}] {
           |    def embed[A](client: ${names.client}, io: ${names.io}[A]): Embedded[A] = Embedded.${names.embedded}(client, io)
           |  }
           |
           |  ${visitor.indentBy("  ")}
           |
           |  ${implementations.indentBy("  ")}
           |}""".stripMargin
    }

    object KleisliVisitor {
      def create(names: Names, methods: List[R.Method]): KleisliVisitor =
        new KleisliVisitor(names, methods.map(KleisliVisitorMethod(names, _)))
    }

    case class KleisliVisitor(names: Names, methods: List[KleisliVisitorMethod]) {
      override def toString: String =
        s"""trait KleisliVisitor[M[_]] extends ${names.op}.Visitor[Kleisli[M, ${names.client}, *]] {
           |  ${methods.map(_.indentBy("  ")).mkString("\n\n  ")}
           |
           |  def primitive[A](
           |    f: ${names.client} => A
           |  ): ${names.kleisliType("A")}
           |}""".stripMargin
    }

    case class KleisliVisitorMethod(names: Names, method: R.Method) {
      override def toString: String =
        s"""def ${method.getName}(
           |  ${parametersOf(method)}
           |): ${names.kleisliType(method.getReturnType.getSimpleName)} =
           |  primitive(_.${method.getName}(${parameterNames(method)}))""".stripMargin
    }

    object Visitor {
      def create(names: Names, methods: List[R.Method]): Visitor =
        new Visitor(names, KleisliVisitor.create(names, methods), methods.map(VMethod))
    }

    case class Visitor(names: Names, kleisliVisitor: KleisliVisitor, methods: List[VMethod]) {
      override def toString: String =
        s"""object Visitor {
           |  ${kleisliVisitor.indentBy("  ")}
           |}
           |
           |trait Visitor[F[_]] extends (${names.op} ~> F) {
           |  final def apply[A](op: ${names.op}[A]): F[A] = op.visit(this)
           |
           |  def embed[A](
           |    e: Embedded[A]
           |  ): F[A]
           |
           |  ${methods.map(_.indentBy("  ")).mkString("\n  \n  ")}
           |}""".stripMargin
    }

    case class VMethod(method: R.Method) {
      override def toString: String =
        s"""def ${method.getName}(
           |  ${parametersOf(method)}
           |): F[${method.getReturnType.getSimpleName}]""".stripMargin
    }

    object Implementations {
      def create(names: Names, methods: List[R.Method]): Implementations =
        new Implementations(names, methods.map(Implementation(names, _)))
    }

    case class Implementations(names: Names, values: List[Implementation]) {
      override def toString: String = {
        s"""final case class Embed[A](
           |  e: Embedded[A]
           |) extends ${names.op}[A] {
           |  def visit[F[_]](visitor: Visitor[F]) =
           |    visitor.embed(e)
           |}
           |
           |${values.map(_.toString).mkString("\n\n")}""".stripMargin
      }
    }

    case class Implementation(names: Names, method: R.Method) {
      override def toString: String =
        s"""final case class ${method.getName.capitalize}Op(
           |  ${parametersOf(method)}
           |) extends ${names.op}[${method.getReturnType.getSimpleName}] {
           |  def visit[F[_]](visitor: Visitor[F]): F[${method.getReturnType.getSimpleName}] =
           |    visitor.${method.getName}(${parameterNames(method)})
           |}""".stripMargin
    }

    object SmartConstructors {
      def create(names: Names, methods: List[R.Method]): SmartConstructors =
        new SmartConstructors(names, methods.map(SmartConstructor(names, _)))
    }

    case class SmartConstructors(names: Names, constructors: List[SmartConstructor]) {
      override def toString: String = {
        s"""import ${names.op}._
           |
           |def embed[F[_], J, A](
           |  j: J,
           |  fa: FF[F, A]
           |)(implicit
           |  ev: Embeddable[F, J]
           |): FF[${names.op}, A] =
           |  FF.liftF(Embed(ev.embed(j, fa)))
           |
           |${constructors.map(_.toString).mkString("\n\n")}""".stripMargin
      }
    }

    case class SmartConstructor(names: Names, method: R.Method) {
      override def toString: String =
        s"""def ${method.getName}(
           |  ${parametersOf(method)}
           |): ${names.io}[${method.getReturnType.getSimpleName}] =
           |  FF.liftF(${method.getName.capitalize}Op(${parameterNames(method)}))""".stripMargin
    }

    case class Names(module: String, clientImport: String, client: String, io: String, op: String) {
      def opImport: String = s"goober.free.$module.$op"

      def ioImport: String = s"goober.free.$module.$io"

      def embedded: String = client.stripSuffix("Client")

      def kleisliType(`type`: String): String = s"Kleisli[M, ${client}, ${`type`}]"
    }

    private def parametersOf(method: R.Method): String = {
      parameterNamesList(method).zip(method.getParameters.map(_.getType.getSimpleName)).map {
        case (name, clazz) ⇒ s"$name: $clazz"
      }.mkString(",\n  ")
    }

    private def parameterNames(method: R.Method): String =
      parameterNamesList(method).mkString(", ")

    private def parameterNamesList(method: R.Method): List[String] = customParameterNames.getOrElse(
      s"${method.getDeclaringClass.getSimpleName}.${method.getName}",
      method.getParameters.toList.map(parameterName)
    )

    private def parameterName(parameter: Parameter): String =
      if (parameter.getType.getSimpleName.endsWith("Request")) "request" else {
        parameterNames.getOrElse(parameter.getType, parameter.getName)
      }

    private val customParameterNames: Map[String, List[String]] = Map(
      "LexRuntimeClient.postContent"          → List("request", "sourcePath", "destinationPath"),
      "LexRuntimeV2Client.recognizeUtterance" → List("request", "sourcePath", "destinationPath")
    )

    private val parameterNames: Map[Class[_], String] = Map(
      classOf[software.amazon.awssdk.core.sync.RequestBody] → "body",
      classOf[java.nio.file.Path] → "path"
    )

    case class Embedded(modules: Modules) {
      def fileContents: FileContents = FileContents("embedded.scala", toString)

      private def implementations: List[String] =
        modules.values.map(_.embeddedClass)


      override def toString: String =
        s"""package goober.free
           |
           |import scala.language.higherKinds
           |
           |import cats.free.Free
           |${modules.ioImports}
           |${modules.clientImports}
           |
           |
           |// A pair (J, Free[F, A]) with constructors that tie down J and F.
           |sealed trait Embedded[A]
           |
           |object Embedded {
           |  ${implementations.mkString("\n  ")}
           |}
           |
           |// Typeclass for embeddable pairs (J, F)
           |trait Embeddable[F[_], J] {
           |  def embed[A](j: J, fa: Free[F, A]): Embedded[A]
           |}
           |""".stripMargin
    }

    case class KleisliInterpreter(modules: Modules) {
      def fileContents: FileContents = FileContents("KleisliInterpreter.scala", toString)

      override def toString: String =
        s"""package goober.free
           |
           |import scala.language.higherKinds
           |
           |import cats.data.Kleisli
           |import cats.effect.{Async, Blocker, ContextShift}
           |import cats.~>
           |${modules.opImports}
           |${modules.clientImports}
           |
           |
           |object KleisliInterpreter {
           |  def apply[M[_]](b: Blocker)(implicit
           |    am: Async[M],
           |    cs: ContextShift[M]
           |  ): KleisliInterpreter[M] = new KleisliInterpreter[M] {
           |    val asyncM = am
           |    val contextShiftM = cs
           |    val blocker = b
           |  }
           |}
           |
           |trait KleisliInterpreter[M[_]] { interpreter =>
           |  ${modules.values.map(_.interpreterValue).mkString("\n\n").indentBy("  ")}
           |
           |  ${modules.values.map(_.interpreterTrait).mkString("\n\n").indentBy("  ")}
           |
           |
           |  def primitive[J, A](f: J => A): Kleisli[M, J, A] = Kleisli(a => {
           |    // primitive AWS methods throw exceptions and so do we when reading values
           |    // so catch any non-fatal exceptions and lift them into the effect
           |    blocker.blockOn[M, A](try {
           |      asyncM.delay(f(a))
           |    } catch {
           |      case scala.util.control.NonFatal(e) => asyncM.raiseError(e)
           |    })(contextShiftM)
           |  })
           |
           |  def embed[J, A](e: Embedded[A]): Kleisli[M, J, A] = e match {
           |    ${modules.values.map(_.embeddedCase).mkString("\n  ").indentBy("  ")}
           |  }
           |
           |  val blocker: Blocker
           |  implicit val asyncM: Async[M]
           |  val contextShiftM: ContextShift[M]
           |}
           |""".stripMargin
    }

    case class FileContents(name: String, contents: String) {
      def writeTo(directory: String): Unit = {
        val pw = new PrintWriter(s"$directory/${name}")
        pw.write(contents.getLines.map(_.trimTrailing).mkString("\n"))
        pw.close()
      }
    }

    object Imports {
      def create(values: String*): Imports =
        Imports(values.toList)
    }

    case class Imports(values: List[String]) {
      override def toString: String =
        values.mkString("import ", "\nimport ", "")
    }
  }
}


