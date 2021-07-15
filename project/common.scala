import java.io.PrintWriter

import scala.collection.immutable.{List, Nil}
import scala.reflect.ClassTag


object common {
  import syntax._

  object Client {
    implicit val clientOrdering: Ordering[Client] =
      Ordering.String.on[Client](_.name)

    trait Companion {
      def discover: List[Client]

      def customs: List[String] =
        custom.keySet.toList.sorted

      def customModel(className: String): Option[String] =
        custom.get(className).map(_.model)

      def customModule(className: String): Option[String] =
        custom.get(className).map(_.module)

      def customClientModule(className: String): Option[String] =
        custom.get(className).map(_.clientModule)

      private val custom: Map[String, Custom] = Map(
        simpleNameOf[software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient] → Custom("dynamodb", "dynamodbstreams", "dynamodb.streams"),
        simpleNameOf[software.amazon.awssdk.services.waf.regional.WafRegionalClient] → Custom("waf", "wafregional", "waf.regional")
      )

      private def simpleNameOf[A: ClassTag]: String =
        implicitly[ClassTag[A]].runtimeClass.getSimpleName

      private case class Custom(model: String, module: String, clientModule: String)
    }

    def ioImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.ioImports))

    def opImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.opImports))

    def clientImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.clientImports))
  }

  trait Client {
    def companion: Client.Companion

    def module: String

    lazy val io: String =
      s"${name}IO"

    lazy val op: String =
      s"${name}Op"

    lazy val modelImports: Imports =
      Imports.create(s"software.amazon.awssdk.services.${modelPackage}.model._")

    lazy val clientImports: Imports =
      Imports.create(fullName)

    lazy val opImports: Imports =
      Imports.create(s"goober.free.$module.$op")

    lazy val ioImports: Imports =
      Imports.create(s"goober.free.$module.$io")

    def kleisliType(`type`: String): String =
      s"Kleisli[M, $simpleName, ${`type`}]"

    lazy val name: String =
      simpleName
        .stripSuffix("Client")

    def fullName: String

    def simpleName: String

    def modelPackage: String

    def methods: ServiceMethods
  }

  case class ServiceMethods(client: Client, values: List[ServiceMethod]) {
    def filter: ServiceMethods = copy(
      values = values.filterNot(_.isExcluded)
        .groupBy(_.name)
        .flatMap(ServiceMethod.choosePreferred)
        .toList
        .sortBy(_.name)
    )

    def smartConstructors: List[Free.SmartConstructor] =
      values.map(Free.SmartConstructor(client, _))

    def visitorMethods: List[Free.Companion.Visitor.Method] =
      values.map(Free.Companion.Visitor.Method)

    def kleisliVisitors: List[Free.Companion.Visitor.KleisliVisitor.Method] =
      values.map(Free.Companion.Visitor.KleisliVisitor.Method(client, _))

    def implementations: List[Free.Companion.Implementation] =
      values.map(Free.Companion.Implementation(client, _))
  }

  object ServiceMethod {
    def choosePreferred(values: (String, List[ServiceMethod])): Option[ServiceMethod] = {
      val sorted = values._2.sortBy(_.getParameterTypes)(
        Ordering.Implicits.seqDerivedOrdering[List, Type](
          indexOfOrdering(preferredTypes)
        )
      )
      //println(s"${values._1}: $sorted")
      sorted.headOption
    }

    private def indexOfOrdering[A](list: List[A]): Ordering[A] = Ordering.Int.on[A](a ⇒ {
      val result = list.indexOf(a)

      if (result == -1) Int.MaxValue else result
    })

    lazy val excludedNames: Set[String] = Set("utilities")

    lazy val excludedTypes: Set[Type] = Set(
      classOf[java.util.function.Consumer[_]],
      classOf[software.amazon.awssdk.core.ResponseBytes[_]],
      classOf[software.amazon.awssdk.core.ResponseInputStream[_]],
      classOf[software.amazon.awssdk.core.sync.ResponseTransformer[_, _]]
    ).map(Type.fromClass)

    private lazy val preferredTypes: List[Type] = List(
      classOf[software.amazon.awssdk.core.sync.RequestBody],
      classOf[java.nio.file.Path]
    ).map(Type.fromClass)
  }

  trait ServiceMethod {
    def isExcluded: Boolean = {
      name.endsWith("Paginator")               ||
        name.endsWith("Torrent")               ||
        ServiceMethod.excludedNames.contains(name)           ||
        ServiceMethod.excludedTypes.contains(returnType) ||
//        getFullParameterTypes.isEmpty          ||
        getParameterTypes.exists(ServiceMethod.excludedTypes.contains)
    }

    def asRequest: String

    def name: String

    def returnType: Type

    final def parametersString: String = parameters.mkString(",\n  ")
    def parameters: List[String]

    final def parameterNamesString: String = parameterNames.mkString(", ")
    def parameterNames: List[String]

    def getParameterTypes: List[Type]
  }

  object Type {
    implicit val typeOrdering: Ordering[Type] =
      Ordering[String].on[Type](_.value)

    def fromClass(clazz: Class[_]): Type =
      new Type(clazz.getName)
  }

  case class Type(value: String) {
    def matches(other: Type): Boolean =
      other        == this ||
      other.simple == this ||
      other        == simple ||
      other.simple == simple

    def simple: Type =
      if (!value.contains(".")) this else Type(value.split("\\.").last)

    override def toString: String = value
  }

  case class Hi(client: Client, methods: List[ServiceMethod]) extends Generator {
    // println(s"Created client: ${client.name} ${client.module}")

    def this(client: Client) =
      this(client, client.methods.filter.values)

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
         |    // ${methods.map(_.asRequest.indentBy("  ")).mkString("\n    // ")}
         |
         |  }
         |
         |  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
         |}
         |""".stripMargin
  }

  object Hi {
    private val directory = "/hi/src/main/scala/goober/hi"
  }

  case class HiModel(clazz: Class[_]) {

  }

  case class Free(
    client: Client,
    companion: Free.Companion,
    smartConstructors: Free.SmartConstructors
  ) extends Generator {

    def this(client: Client) =
      this(client, new Free.Companion(client), new Free.SmartConstructors(client))

    def interpreterValue: String =
      s"""lazy val ${client.name}Interpreter: ${client.op} ~> Kleisli[M, ${client.simpleName}, *] = new ${client.name}Interpreter {
         |  def primitive[A](f: ${client.simpleName} ⇒ A): Kleisli[M, ${client.simpleName}, A] = interpreter.primitive(f)
         |}""".stripMargin

    def interpreterTrait: String =
      s"""trait ${client.name}Interpreter extends ${client.op}.Visitor.KleisliVisitor[M] {
         |  def embed[A](e: Embedded[A]): Kleisli[M, ${client.simpleName}, A] = interpreter.embed(e)
         |}""".stripMargin

    def embeddedClass: String =
      s"final case class ${client.name}[A](client: ${client.simpleName}, io: ${client.io}[A]) extends Embedded[A]"

    def embeddedCase: String =
      s"case Embedded.${client.name}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ${client.simpleName}, *]](${client.name}Interpreter).run(client))"

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
        this(client, new Companion.Visitor(client), new Companion.Implementations(client))

      def imports: Imports =
        visitor.imports

      override def toString: String =
        s"""object ${client.op} {
           |  // Given a ${client.simpleName} we can embed a ${client.io} program in any algebra that understands embedding.
           |  implicit val ${client.op}Embeddable: Embeddable[${client.op}, ${client.simpleName}] = new Embeddable[${client.op}, ${client.simpleName}] {
           |    def embed[A](client: ${client.simpleName}, io: ${client.io}[A]): Embedded[A] = Embedded.${client.name}(client, io)
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
          this(client, new Visitor.KleisliVisitor(client), client.methods.visitorMethods)

        def imports: Imports = Imports.flatten(
          ifUsed(Type("java.nio.file.Path")),
          ifUsed(Type("software.amazon.awssdk.core.sync.RequestBody"))
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

        private def ifUsed(parameterType: Type): Option[String] =
          if (methods.exists(_.hasParameterType(parameterType))) Some(parameterType.value) else None
      }

      object Visitor {
        case class KleisliVisitor(client: Client, methods: List[KleisliVisitor.Method]) {
          def this(client: Client) =
            this(client, client.methods.kleisliVisitors)

          override def toString: String =
            s"""trait KleisliVisitor[M[_]] extends ${client.op}.Visitor[Kleisli[M, ${client.simpleName}, *]] {
               |  ${methods.map(_.indentBy("  ")).mkString("\n\n  ")}
               |
               |  def primitive[A](
               |    f: ${client.simpleName} => A
               |  ): ${client.kleisliType("A")}
               |}""".stripMargin
        }

        object KleisliVisitor {
          case class Method(client: Client, method: ServiceMethod) {
            override def toString: String =
              s"""def ${method.name}(
                 |  ${method.parametersString}
                 |): ${client.kleisliType(method.returnType.value)} =
                 |  primitive(_.${method.name}(${method.parameterNamesString}))""".stripMargin
          }
        }

        case class Method(method: ServiceMethod) {
          def hasParameterType(parameterType: Type): Boolean =
            method.getParameterTypes.exists(_.matches(parameterType))

          override def toString: String =
            s"""def ${method.name}(
               |  ${method.parametersString}
               |): F[${method.returnType}]""".stripMargin
        }
      }

      case class Implementations(client: Client, values: List[Implementation]) {
        def this(client: Client) =
          this(client, client.methods.implementations)

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

      case class Implementation(client: Client, method: ServiceMethod) {
        override def toString: String =
          s"""final case class ${method.name.capitalize}Op(
             |  ${method.parametersString}
             |) extends ${client.op}[${method.returnType}] {
             |  def visit[F[_]](visitor: Visitor[F]): F[${method.returnType}] =
             |    visitor.${method.name}(${method.parameterNamesString})
             |}""".stripMargin
      }
    }

    case class SmartConstructors(client: Client, constructors: List[SmartConstructor]) {
      def this(client: Client) =
        this(client, client.methods.smartConstructors)

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

    case class SmartConstructor(client: Client, method: ServiceMethod) {
      override def toString: String =
        s"""def ${method.name}(
           |  ${method.parametersString}
           |): ${client.io}[${method.returnType}] =
           |  FF.liftF(${method.name.capitalize}Op(${method.parameterNamesString}))""".stripMargin
    }

  }


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
        s"final case class ${client.name}[A](client: ${client.simpleName}, io: ${client.io}[A]) extends Embedded[A]"
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
        s"""lazy val ${client.name}Interpreter: ${client.op} ~> Kleisli[M, ${client.simpleName}, *] = new ${client.name}Interpreter {
           |  def primitive[A](f: ${client.simpleName} ⇒ A): Kleisli[M, ${client.simpleName}, A] = interpreter.primitive(f)
           |}""".stripMargin

      private def interpreterTrait(client: Client): String =
        s"""trait ${client.name}Interpreter extends ${client.op}.Visitor.KleisliVisitor[M] {
           |  def embed[A](e: Embedded[A]): Kleisli[M, ${client.simpleName}, A] = interpreter.embed(e)
           |}""".stripMargin

      private def embeddedCase(client: Client): String =
        s"case Embedded.${client.name}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ${client.simpleName}, *]](${client.name}Interpreter).run(client))"
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

  case class Generators(values: List[Generator]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.flatten(ScalaFiles(values.flatMap(_.scalaFiles.values)))
  }

  trait Generator {
    def scalaFiles: ScalaFiles
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
      // println(s"Writing to $directory/$name ...")
      val pw = new PrintWriter(s"$directory/${name}")
      pw.write(contents.getLines.map(_.trimTrailing).mkString("\n"))
      pw.close()
    }
  }

}
