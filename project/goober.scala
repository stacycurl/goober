import java.io.PrintWriter
import java.lang.reflect.Parameter
import java.lang.{reflect ⇒ R}
import goober.Free.Companion.Visitor.KleisliVisitor
import goober.Free.Companion.{Implementations, Visitor}
import goober.Free.{Companion, SmartConstructors}
import org.reflections.Reflections
import sbt.Def.task
import sbt.{Def, Task, TaskKey, taskKey}
import software.amazon.awssdk.core.SdkField

import scala.collection.JavaConverters._

object goober {
  object generator {
    val generate: TaskKey[Unit] = taskKey[Unit]("generate")

    val hi: Def.Initialize[Task[Unit]] = task {
      val clients =
        Client.discover

      Generators(
        clients.map(new Hi(_))
      ).scalaFiles.writeTo(".")
    }

    val free: Def.Initialize[Task[Unit]] = task {
      val clients =
        Client.discover

      Generators(
        Embedded(clients) :: KleisliInterpreter(clients) :: clients.map(new Free(_))
      ).scalaFiles.writeTo(".")
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

  case class Generators(values: List[Generator]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.flatten(ScalaFiles(values.flatMap(_.scalaFiles.values)))
  }

  trait Generator {
    def scalaFiles: ScalaFiles
  }

  case class Hi(client: Client, methods: List[Hi.Method]) extends Generator {
    def this(client: Client) =
      this(client, client.methods.parameterTypes.distinct.sorted.map(Hi.Method.create))

    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Hi.directory}/${client.module}.scala", toString))

    override def toString: String =
      s"""package goober.hi
         |
         |${client.ioImports + client.modelImports}
         |
         |
         |object ${client.module} {
         |  import goober.free.{${client.module} ⇒ free}
         |
         |  object model {
         |    import goober.hi.util.BuilderSyntax._
         |
         |    // Methods for constructing model classes, requests, etc.
         |    ${methods.map(_.indentBy("  ")).mkString("\n    ")}
         |
         |  }
         |
         |  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
         |}
         |""".stripMargin
  }

  object Hi {
    private val directory = "/hi/src/main/scala/goober/hi"

    object Method {
      def create(clazz: Class[_]): Method =
        new Method(clazz, Nil)
    }

    case class Method(clazz: Class[_], fields: List[Field]) {
      override def toString: String =
        s"""// ${clazz.getSimpleName}"""
    }

    case class Field(value: SdkField[_])
  }

  case class HiModel(clazz: Class[_]) {

  }

  case class Free(
    client: Client,
    companion: Free.Companion,
    smartConstructors: Free.SmartConstructors
  ) extends Generator {

    def this(client: Client) =
      this(client, new Companion(client), new SmartConstructors(client))

    def interpreterValue: String =
      s"""lazy val ${client.name}Interpreter: ${client.op} ~> Kleisli[M, $client, *] = new ${client.name}Interpreter {
         |  def primitive[A](f: $client ⇒ A): Kleisli[M, $client, A] = interpreter.primitive(f)
         |}""".stripMargin

    def interpreterTrait: String =
      s"""trait ${client.name}Interpreter extends ${client.op}.Visitor.KleisliVisitor[M] {
         |  def embed[A](e: Embedded[A]): Kleisli[M, $client, A] = interpreter.embed(e)
         |}""".stripMargin

    def embeddedClass: String =
      s"final case class ${client.name}[A](client: $client, io: ${client.io}[A]) extends Embedded[A]"

    def embeddedCase: String =
      s"case Embedded.${client.name}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, $client, *]](${client.name}Interpreter).run(client))"

    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Free.directory}/${client.module}.scala", toString))

    override def toString: String =
      s"""package goober.free
         |
         |import scala.language.higherKinds
         |
         |import cats.free.{Free => FF}
         |import cats.~>
         |import cats.data.Kleisli
         |${client.clientImports + client.modelImports + companion.imports}
         |
         |
         |object ${client.module} { module =>
         |
         |  // Free monad over ${client.op}
         |  type ${client.io}[A] = FF[${client.op}, A]
         |
         |  sealed trait ${client.op}[A] {
         |    def visit[F[_]](visitor: ${client.op}.Visitor[F]): F[A]
         |  }
         |
         |  ${companion.indentBy("  ")}
         |
         |  ${smartConstructors.indentBy("  ")}
         |}
         |""".stripMargin
  }

  object Free {
    val directory = "/free/src/main/scala/goober/free"

    case class Companion(
      client: Client,
      visitor: Companion.Visitor,
      implementations: Companion.Implementations
    ) {

      def this(client: Client) =
        this(client, new Visitor(client), new Implementations(client))

      def imports: Imports =
        visitor.imports

      override def toString: String =
        s"""object ${client.op} {
           |  // Given a $client we can embed a ${client.io} program in any algebra that understands embedding.
           |  implicit val ${client.op}Embeddable: Embeddable[${client.op}, $client] = new Embeddable[${client.op}, $client] {
           |    def embed[A](client: $client, io: ${client.io}[A]): Embedded[A] = Embedded.${client.name}(client, io)
           |  }
           |
           |  ${visitor.indentBy("  ")}
           |
           |  ${implementations.indentBy("  ")}
           |}""".stripMargin
    }

    object Companion {
      case class Visitor(client: Client, kleisliVisitor: Visitor.KleisliVisitor, methods: List[Visitor.Method]) {
        def this(client: Client) =
          this(client, new KleisliVisitor(client), client.methods.map(Visitor.Method))

        def imports: Imports = Imports.flatten(
          ifUsed("java.nio.file.Path"),
          ifUsed("software.amazon.awssdk.core.sync.RequestBody")
        )

        override def toString: String =
          s"""object Visitor {
             |  ${kleisliVisitor.indentBy("  ")}
             |}
             |
             |trait Visitor[F[_]] extends (${client.op} ~> F) {
             |  final def apply[A](op: ${client.op}[A]): F[A] = op.visit(this)
             |
             |  def embed[A](
             |    e: Embedded[A]
             |  ): F[A]
             |
             |  ${methods.map(_.indentBy("  ")).mkString("\n  \n  ")}
             |}""".stripMargin

        private def ifUsed(parameterType: String): Option[String] =
          if (methods.exists(_.hasParameterType(parameterType))) Some(parameterType) else None
      }

      object Visitor {
        case class KleisliVisitor(client: Client, methods: List[KleisliVisitor.Method]) {
          def this(client: Client) =
            this(client, client.methods.map(KleisliVisitor.Method(client, _)))

          override def toString: String =
            s"""trait KleisliVisitor[M[_]] extends ${client.op}.Visitor[Kleisli[M, $client, *]] {
               |  ${methods.map(_.indentBy("  ")).mkString("\n\n  ")}
               |
               |  def primitive[A](
               |    f: $client => A
               |  ): ${client.kleisliType("A")}
               |}""".stripMargin
        }

        object KleisliVisitor {
          case class Method(client: Client, method: R.Method) {
            override def toString: String =
              s"""def ${method.getName}(
                 |  ${parametersOf(method)}
                 |): ${client.kleisliType(method.getReturnType.getSimpleName)} =
                 |  primitive(_.${method.getName}(${parameterNames(method)}))""".stripMargin
          }
        }

        case class Method(method: R.Method) {
          def hasParameterType(pparameterType: String): Boolean =
            method.getParameterTypes.exists(parameterClass ⇒ parameterClass.getName == pparameterType)

          override def toString: String =
            s"""def ${method.getName}(
               |  ${parametersOf(method)}
               |): F[${method.getReturnType.getSimpleName}]""".stripMargin
        }
      }

      case class Implementations(client: Client, values: List[Implementation]) {
        def this(client: Client) =
          this(client, client.methods.map(Implementation(client, _)))

        override def toString: String = {
          s"""final case class Embed[A](
             |  e: Embedded[A]
             |) extends ${client.op}[A] {
             |  def visit[F[_]](visitor: Visitor[F]) =
             |    visitor.embed(e)
             |}
             |
             |${values.map(_.toString).mkString("\n\n")}""".stripMargin
        }
      }

      case class Implementation(client: Client, method: R.Method) {
        override def toString: String =
          s"""final case class ${method.getName.capitalize}Op(
             |  ${parametersOf(method)}
             |) extends ${client.op}[${method.getReturnType.getSimpleName}] {
             |  def visit[F[_]](visitor: Visitor[F]): F[${method.getReturnType.getSimpleName}] =
             |    visitor.${method.getName}(${parameterNames(method)})
             |}""".stripMargin
      }
    }

    case class SmartConstructors(client: Client, constructors: List[SmartConstructor]) {
      def this(client: Client) =
        this(client, client.methods.map(SmartConstructor(client, _)))

      override def toString: String = {
        s"""import ${client.op}._
           |
           |def embed[F[_], J, A](
           |  j: J,
           |  fa: FF[F, A]
           |)(implicit
           |  ev: Embeddable[F, J]
           |): FF[${client.op}, A] =
           |  FF.liftF(Embed(ev.embed(j, fa)))
           |
           |${constructors.map(_.toString).mkString("\n\n")}""".stripMargin
      }
    }

    case class SmartConstructor(client: Client, method: R.Method) {
      override def toString: String =
        s"""def ${method.getName}(
           |  ${parametersOf(method)}
           |): ${client.io}[${method.getReturnType.getSimpleName}] =
           |  FF.liftF(${method.getName.capitalize}Op(${parameterNames(method)}))""".stripMargin
    }
  }

  private def parentPackage(clazz: Class[_]): String =
    clazz.getPackage.getName.split("\\.").last

  object Client {
    implicit val clientOrdering: Ordering[Client] =
      Ordering.String.on[Client](_.name)

    def discover: List[Client] = {
      new Reflections("software.amazon.awssdk.services")
        .getSubTypesOf(classOf[software.amazon.awssdk.core.SdkClient])
        .asScala
        .toList
        .flatMap(create)
        .sorted
    }

    def create(clazz: Class[_]): Option[Client] = {
      Option(clazz)
        .filter(_.isInterface)
        .filterNot(_.getSimpleName.endsWith("AsyncClient"))
        .map(new Client(_))
    }

    def methodsIn(clazz: Class[_]): Methods = Methods {
      clazz.getDeclaredMethods.toList
        .filterNot(isExcluded)
        .filterNot(isStatic)
        .groupBy(_.getName)
        .flatMap(choosePreferred)
        .toList
        .sortBy(_.getName)
    }

    def ioImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.ioImports))

    def opImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.opImports))

    def clientImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.clientImports))

    private def isExcluded(method: R.Method): Boolean = {
      method.getName.endsWith("Paginator")           ||
        method.getName.endsWith("Torrent")           ||
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

    private val custom: Map[Class[_], Custom] = Map(
      classOf[software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient] → Custom("dynamodb", "dynamodbstreams"),
      classOf[software.amazon.awssdk.services.waf.regional.WafRegionalClient] → Custom("waf", "wafregional")
    )

    private case class Custom(model: String, module: String)
  }

  class Client(clazz: Class[_]) {
    val module: String =
      Client.custom.get(clazz).fold(parentPackage(clazz))(_.module)

    val name: String =
      clazz.getSimpleName.stripSuffix("Client")

    val io: String = s"${name}IO"

    val op: String = s"${name}Op"

    val modelImports: Imports =
      Imports.create(s"software.amazon.awssdk.services.${modelPackage}.model._")

    val clientImports: Imports =
      Imports.create(clazz.getName)

    val opImports: Imports =
      Imports.create(s"goober.free.$module.$op")

    val ioImports: Imports =
      Imports.create(s"goober.free.$module.$io")

    def kleisliType(`type`: String): String =
      s"Kleisli[M, $this, ${`type`}]"

    lazy val methods: Methods =
      Client.methodsIn(clazz)

    override val toString: String =
      clazz.getSimpleName

    private def modelPackage: String =
      Client.custom.get(clazz).fold(parentPackage(clazz))(_.model)
  }

  case class Methods(values: List[R.Method]) {
    def map[A](f: R.Method ⇒ A): List[A] =
      values.map(f)

    def parameterTypes: ParameterTypes =
      ParameterTypes(values.flatMap(_.getParameterTypes.toList))
  }

  case class ParameterTypes(values: List[Class[_]]) {
    def distinct: ParameterTypes =
      ParameterTypes(values.map(equalBy(_.getSimpleName)).distinct.map(_.a))

    def sorted: ParameterTypes =
      ParameterTypes(values.sortBy(_.getSimpleName))

    def map[A](f: Class[_] ⇒ A): List[A] =
      values.map(f)
  }

  private def equalBy[A, B](f: A ⇒ B)(a: A): EqualBy[A, B] = EqualBy(f(a))(a)
  case class EqualBy[A, B](b: B)(val a: A)

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

  case class Embedded(clients: List[Client]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Free.directory}/embedded.scala", toString))

    override def toString: String =
      s"""package goober.free
         |
         |import scala.language.higherKinds
         |
         |import cats.free.Free
         |${Client.ioImports(clients) + Client.clientImports(clients)}
         |
         |
         |// A pair (J, Free[F, A]) with constructors that tie down J and F.
         |sealed trait Embedded[A]
         |
         |object Embedded {
         |  ${clients.map(embeddedClass).mkString("\n  ")}
         |}
         |
         |// Typeclass for embeddable pairs (J, F)
         |trait Embeddable[F[_], J] {
         |  def embed[A](j: J, fa: Free[F, A]): Embedded[A]
         |}
         |""".stripMargin

    private def embeddedClass(client: Client): String =
      s"final case class ${client.name}[A](client: $client, io: ${client.io}[A]) extends Embedded[A]"
  }

  case class KleisliInterpreter(clients: List[Client]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Free.directory}/KleisliInterpreter.scala", toString))

    override def toString: String =
      s"""package goober.free
         |
         |import scala.language.higherKinds
         |
         |import cats.data.Kleisli
         |import cats.effect.{Async, Blocker, ContextShift}
         |import cats.~>
         |${Client.opImports(clients) + Client.clientImports(clients)}
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
         |  ${clients.map(interpreterValue).mkString("\n\n").indentBy("  ")}
         |
         |  ${clients.map(interpreterTrait).mkString("\n\n").indentBy("  ")}
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
         |    ${clients.map(embeddedCase).mkString("\n  ").indentBy("  ")}
         |  }
         |
         |  val blocker: Blocker
         |  implicit val asyncM: Async[M]
         |  val contextShiftM: ContextShift[M]
         |}
         |""".stripMargin

    private def interpreterValue(client: Client): String =
      s"""lazy val ${client.name}Interpreter: ${client.op} ~> Kleisli[M, $client, *] = new ${client.name}Interpreter {
         |  def primitive[A](f: $client ⇒ A): Kleisli[M, $client, A] = interpreter.primitive(f)
         |}""".stripMargin

    private def interpreterTrait(client: Client): String =
      s"""trait ${client.name}Interpreter extends ${client.op}.Visitor.KleisliVisitor[M] {
         |  def embed[A](e: Embedded[A]): Kleisli[M, $client, A] = interpreter.embed(e)
         |}""".stripMargin

    private def embeddedCase(client: Client): String =
      s"case Embedded.${client.name}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, $client, *]](${client.name}Interpreter).run(client))"
  }

  object ScalaFiles {
    def flatten(files: ScalaFiles*): ScalaFiles =
      new ScalaFiles(files.flatMap(_.values).toList)

    def create(files: ScalaFile*): ScalaFiles =
      new ScalaFiles(files.toList)
  }

  case class ScalaFiles(values: List[ScalaFile]) {
    def +(rhs: ScalaFiles): ScalaFiles =
      ScalaFiles(values ++ rhs.values)

    def writeTo(directory: String): Unit =
      values.foreach(_.writeTo(directory))
  }

  case class ScalaFile(name: String, contents: String) {
    def writeTo(directory: String): Unit = {
      val pw = new PrintWriter(s"$directory/${name}")
      pw.write(contents.getLines.map(_.trimTrailing).mkString("\n"))
      pw.close()
    }
  }

  object Imports {
    def create(values: String*): Imports =
      Imports(values.toList)

    def flatten(values: Option[String]*): Imports =
      Imports(values.toList.flatten)

    def flatten(values: List[Imports]): Imports =
      Imports(values.flatMap(_.values))
  }

  case class Imports(values: List[String]) {
    def +(rhs: Imports): Imports =
      Imports(values ++ rhs.values)

    override def toString: String =
      values.map(value ⇒ s"import $value").mkString("\n")
  }
}


