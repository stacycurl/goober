import java.io.PrintWriter
import java.lang.{reflect ⇒ R}
import sbt.Def.task
import sbt.{Def, Task, TaskKey, taskKey}

import scala.reflect.ClassTag

object goober {
  object free {
    object generator {
      val generate: TaskKey[Unit] = taskKey[Unit]("generate")

      val generateTask: Def.Initialize[Task[Unit]] = task {
        Modules.create(
          Module.create[software.amazon.awssdk.services.athena.AthenaClient](
            Names("athena", "AthenaClient", "AthenaIO", "AthenaOp"),
            "software.amazon.awssdk.services.athena.AthenaClient",
            "software.amazon.awssdk.services.athena.model._"
          ),
          Module.create[software.amazon.awssdk.services.s3.S3Client](
            Names("s3", "S3Client", "S3IO", "S3Op"),
            "java.nio.file.Path",
            "software.amazon.awssdk.core.sync.RequestBody",
            "software.amazon.awssdk.services.s3.S3Client",
            "software.amazon.awssdk.services.s3.model._"
          ),
          Module.create[software.amazon.awssdk.services.ec2.Ec2Client](
            Names("ec2", "Ec2Client", "EC2IO", "EC2Op"),
            "java.nio.file.Path",
            "software.amazon.awssdk.core.sync.RequestBody",
            "software.amazon.awssdk.services.ec2.Ec2Client",
            "software.amazon.awssdk.services.ec2.model._"
          )
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
      def writeTo(directory: String): Unit =
        values.foreach(_.writeTo(directory))
    }

    object Module {
      def create[Env: ClassTag](names: Names, imports: String*): Module =
        create(names, imports.toList, methodsIn[Env])

      def create(names: Names, imports: List[String], methods: List[R.Method]): Module =
        new Module(names, imports, Companion.create(names, methods), SmartConstructors.create(names, methods))

      private def methodsIn[A: ClassTag]: List[R.Method] =
        methodsIn(implicitly[ClassTag[A]].runtimeClass)

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

      private val excludedNames: Set[String] = Set("utilities")

      private val excludedTypes: Set[Class[_]] = Set(
        classOf[java.util.function.Consumer[_]],
        classOf[software.amazon.awssdk.core.ResponseBytes[_]],
        classOf[software.amazon.awssdk.core.ResponseInputStream[_]],
        classOf[software.amazon.awssdk.core.sync.ResponseTransformer[_, _]]
      )

      private val preferredTypes: List[Class[_]] = List(
        classOf[software.amazon.awssdk.core.sync.RequestBody],
        classOf[java.nio.file.Path]
      )
    }

    case class Module(
      names: Names,
      imports: List[String],
      companion: Companion,
      smartConstructors: SmartConstructors
    ) {

      def writeTo(directory: String): Unit = {
        val pw = new PrintWriter(s"$directory/${names.module}.scala")
        pw.write(toString.getLines.map(_.trimTrailing).mkString("\n"))
        pw.close()
      }

      override def toString: String =
        s"""package goober.free
           |
           |import scala.language.higherKinds
           |
           |import cats.free.{Free => FF}
           |import cats.~>
           |import cats.data.Kleisli
           |${imports.mkString("import ", "\nimport ", "")}
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
           |  // Given a ${names.env} we can embed a ${names.io} program in any algebra that understands embedding.
           |  implicit val ${names.op}Embeddable: Embeddable[${names.op}, ${names.env}] = new Embeddable[${names.op}, ${names.env}] {
           |    def embed[A](client: ${names.env}, io: ${names.io}[A]): Embedded[A] = Embedded.${names.embedded}(client, io)
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
        s"""trait KleisliVisitor[M[_]] extends ${names.op}.Visitor[Kleisli[M, ${names.env}, *]] {
           |  ${methods.map(_.indentBy("  ")).mkString("\n\n  ")}
           |
           |  def primitive[A](
           |    f: ${names.env} => A
           |  ): ${names.kleisliType("A")}
           |}""".stripMargin
    }

    case class KleisliVisitorMethod(names: Names, method: R.Method) {
      override def toString: String =
        s"""def ${method.getName}(
           |  ${method.getParameterTypes.toList.map(parameter).mkString(",\n  ")}
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
           |  ${method.getParameterTypes.toList.map(parameter).mkString(",\n  ")}
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
        s"""final case class ${method.getName.capitalize}(
           |  ${method.getParameterTypes.toList.map(parameter).mkString(",\n  ")}
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
           |  ${method.getParameterTypes.toList.map(parameter).mkString(",\n  ")}
           |): ${names.io}[${method.getReturnType.getSimpleName}] =
           |  FF.liftF(${method.getName.capitalize}(${parameterNames(method)}))""".stripMargin
    }

    case class Names(module: String, env: String, io: String, op: String) {
      def embedded: String = module.capitalize

      def kleisliType(`type`: String): String = s"Kleisli[M, ${env}, ${`type`}]"
    }

    private def parameterNames(method: R.Method): String =
      method.getParameterTypes.toList.map(parameterName).mkString(", ")

    private def parameter(clazz: Class[_]): String =
      s"${parameterName(clazz)}: ${clazz.getSimpleName}"

    private def parameterName(clazz: Class[_]): String =
      if (clazz.getSimpleName.endsWith("Request")) "request" else parameterNames.getOrElse(clazz, "DUNNO")

    private val parameterNames: Map[Class[_], String] = Map(
      classOf[software.amazon.awssdk.core.sync.RequestBody] → "body",
      classOf[java.nio.file.Path] → "path"
    )
  }
}


