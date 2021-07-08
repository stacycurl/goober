import java.io.PrintWriter

import scala.collection.immutable.{List, Nil}


object common {
  import syntax._

  object GenClient {
    def ioImports(values: List[GenClient]): Imports =
      Imports.flatten(values.map(_.ioImports))

    def opImports(values: List[GenClient]): Imports =
      Imports.flatten(values.map(_.opImports))

    def clientImports(values: List[GenClient]): Imports =
      Imports.flatten(values.map(_.clientImports))
  }

  trait GenClient {
    def module: String

    def io: String =
      s"${name}IO"

    def op: String =
      s"${name}Op"

    def modelImports: Imports =
      Imports.create(s"software.amazon.awssdk.services.${modelPackage}.model._")

    def clientImports: Imports =
      Imports.create(fullName)

    def opImports: Imports =
      Imports.create(s"goober.free.$module.$op")

    def ioImports: Imports =
      Imports.create(s"goober.free.$module.$io")

    def kleisliType(`type`: String): String =
      s"Kleisli[M, $simpleName, ${`type`}]"

    def name: String =
      simpleName.stripSuffix("Client")

    def fullName: String

    def simpleName: String

    def modelPackage: String

    def methods: GenMethods
  }

  trait GenMethods {
    def smartConstructors: List[Free.SmartConstructor]

    def kleisliVisitors: List[Free.Companion.Visitor.KleisliVisitor.Method]

    def visitorMethods: List[Free.Companion.Visitor.Method]

    def implementations: List[Free.Companion.Implementation]
  }

  object GenMethod {
    def choosePreferred(values: (String, List[GenMethod])): Option[GenMethod] = {
      val sorted = values._2.sortBy(_.getFullParameterTypes)(
        Ordering.Implicits.seqDerivedOrdering[List, String](
          indexOfOrdering(preferredTypesNames)
        )
      )
      // println(s"${values._1}: $sorted")
      sorted.headOption
    }

    private def indexOfOrdering[A](list: List[A]): Ordering[A] = Ordering.Int.on[A](a ⇒ {
      val result = list.indexOf(a)

      if (result == -1) Int.MaxValue else result
    })

    lazy val excludedNames: Set[String] = Set("utilities")

    lazy val excludedTypeNames: Set[String] = Set(
      classOf[java.util.function.Consumer[_]],
      classOf[software.amazon.awssdk.core.ResponseBytes[_]],
      classOf[software.amazon.awssdk.core.ResponseInputStream[_]],
      classOf[software.amazon.awssdk.core.sync.ResponseTransformer[_, _]]
    ).map(_.getName)

    private lazy val preferredTypesNames = List(
      classOf[software.amazon.awssdk.core.sync.RequestBody],
      classOf[java.nio.file.Path]
    ).map(_.getName)
  }

  trait GenMethod {
    def isExcluded: Boolean = {
      name.endsWith("Paginator")               ||
        name.endsWith("Torrent")               ||
        GenMethod.excludedNames.contains(name)           ||
        GenMethod.excludedTypeNames.contains(returnType) ||
        getFullParameterTypes.isEmpty          ||
        getFullParameterTypes.exists(GenMethod.excludedTypeNames.contains)
    }

    def name: String

    def returnType: String

    final def parametersString: String = parameters.mkString(",\n  ")
    def parameters: List[String]

    final def parameterNamesString: String = parameterNames.mkString(", ")
    def parameterNames: List[String]

    def getFullParameterTypes: List[String]
  }

  case class Hi(client: GenClient, methods: List[GenMethod]) extends Generator {
    def this(client: GenClient) =
      this(client, Nil)

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
         |    ${methods.map(_.name.indentBy("  ")).mkString("\n    ")}
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
    client: GenClient,
    companion: Free.Companion,
    smartConstructors: Free.SmartConstructors
  ) extends Generator {

    def this(client: GenClient) =
      this(client, new Free.Companion(client), new Free.SmartConstructors(client))

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
      client: GenClient,
      visitor: Companion.Visitor,
      implementations: Companion.Implementations
    ) {

      def this(client: GenClient) =
        this(client, new Companion.Visitor(client), new Companion.Implementations(client))

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
      case class Visitor(client: GenClient, kleisliVisitor: Visitor.KleisliVisitor, methods: List[Visitor.Method]) {
        def this(client: GenClient) =
          this(client, new Visitor.KleisliVisitor(client), client.methods.visitorMethods)

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
        case class KleisliVisitor(client: GenClient, methods: List[KleisliVisitor.Method]) {
          def this(client: GenClient) =
            this(client, client.methods.kleisliVisitors)

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
          case class Method(client: GenClient, method: GenMethod) {
            override def toString: String =
              s"""def ${method.name}(
                 |  ${method.parametersString}
                 |): ${client.kleisliType(method.returnType)} =
                 |  primitive(_.${method.name}(${method.parameterNamesString}))""".stripMargin
          }
        }

        case class Method(method: GenMethod) {
          def hasParameterType(parameterType: String): Boolean =
            method.getFullParameterTypes.contains(parameterType)

          override def toString: String =
            s"""def ${method.name}(
               |  ${method.parametersString}
               |): F[${method.returnType}]""".stripMargin
        }
      }

      case class Implementations(client: GenClient, values: List[Implementation]) {
        def this(client: GenClient) =
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

      case class Implementation(client: GenClient, method: GenMethod) {
        override def toString: String =
          s"""final case class ${method.name.capitalize}Op(
             |  ${method.parametersString}
             |) extends ${client.op}[${method.returnType}] {
             |  def visit[F[_]](visitor: Visitor[F]): F[${method.returnType}] =
             |    visitor.${method.name}(${method.parameterNamesString})
             |}""".stripMargin
      }
    }

    case class SmartConstructors(client: GenClient, constructors: List[SmartConstructor]) {
      def this(client: GenClient) =
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

    case class SmartConstructor(client: GenClient, method: GenMethod) {
      override def toString: String =
        s"""def ${method.name}(
           |  ${method.parametersString}
           |): ${client.io}[${method.returnType}] =
           |  FF.liftF(${method.name.capitalize}Op(${method.parameterNamesString}))""".stripMargin
    }

  }


  case class Embedded(clients: List[GenClient]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Free.directory}/embedded.scala", toString))

    override def toString: String =
      s"""package goober.free
         |
         |import scala.language.higherKinds
         |
         |import cats.free.Free
         |${GenClient.ioImports(clients) + GenClient.clientImports(clients)}
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

      private def embeddedClass(client: GenClient): String =
        s"final case class ${client.name}[A](client: $client, io: ${client.io}[A]) extends Embedded[A]"
  }


  case class KleisliInterpreter(clients: List[GenClient]) extends Generator {
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
         |${GenClient.opImports(clients) + GenClient.clientImports(clients)}
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

      private def interpreterValue(client: GenClient): String =
        s"""lazy val ${client.name}Interpreter: ${client.op} ~> Kleisli[M, $client, *] = new ${client.name}Interpreter {
           |  def primitive[A](f: $client ⇒ A): Kleisli[M, $client, A] = interpreter.primitive(f)
           |}""".stripMargin

      private def interpreterTrait(client: GenClient): String =
        s"""trait ${client.name}Interpreter extends ${client.op}.Visitor.KleisliVisitor[M] {
           |  def embed[A](e: Embedded[A]): Kleisli[M, $client, A] = interpreter.embed(e)
           |}""".stripMargin

      private def embeddedCase(client: GenClient): String =
        s"case Embedded.${client.name}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, $client, *]](${client.name}Interpreter).run(client))"
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
      val pw = new PrintWriter(s"$directory/${name}")
      pw.write(contents.getLines.map(_.trimTrailing).mkString("\n"))
      pw.close()
    }
  }

}
