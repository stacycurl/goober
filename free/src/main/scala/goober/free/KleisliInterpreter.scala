package goober.free

import scala.language.higherKinds

import cats.data.Kleisli
import cats.effect.{Async, Blocker, ContextShift}
import cats.~>
import goober.free.athena.AthenaOp
import goober.free.codebuild.CodeBuildOp
import goober.free.ec2.Ec2Op
import goober.free.s3.S3Op
import software.amazon.awssdk.services.athena.AthenaClient
import software.amazon.awssdk.services.codebuild.CodeBuildClient
import software.amazon.awssdk.services.ec2.Ec2Client
import software.amazon.awssdk.services.s3.S3Client


object KleisliInterpreter {
  def apply[M[_]](b: Blocker)(implicit
    am: Async[M],
    cs: ContextShift[M]
  ): KleisliInterpreter[M] = new KleisliInterpreter[M] {
    val asyncM = am
    val contextShiftM = cs
    val blocker = b
  }
}

trait KleisliInterpreter[M[_]] { interpreter =>
  lazy val AthenaInterpreter: AthenaOp ~> Kleisli[M, AthenaClient, *] = new AthenaInterpreter {
    def primitive[A](f: AthenaClient ⇒ A): Kleisli[M, AthenaClient, A] = interpreter.primitive(f)
  }

  lazy val CodeBuildInterpreter: CodeBuildOp ~> Kleisli[M, CodeBuildClient, *] = new CodeBuildInterpreter {
    def primitive[A](f: CodeBuildClient ⇒ A): Kleisli[M, CodeBuildClient, A] = interpreter.primitive(f)
  }

  lazy val Ec2Interpreter: Ec2Op ~> Kleisli[M, Ec2Client, *] = new Ec2Interpreter {
    def primitive[A](f: Ec2Client ⇒ A): Kleisli[M, Ec2Client, A] = interpreter.primitive(f)
  }

  lazy val S3Interpreter: S3Op ~> Kleisli[M, S3Client, *] = new S3Interpreter {
    def primitive[A](f: S3Client ⇒ A): Kleisli[M, S3Client, A] = interpreter.primitive(f)
  }

  trait AthenaInterpreter extends AthenaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AthenaClient, A] = interpreter.embed(e)
  }

  trait CodeBuildInterpreter extends CodeBuildOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeBuildClient, A] = interpreter.embed(e)
  }

  trait Ec2Interpreter extends Ec2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Ec2Client, A] = interpreter.embed(e)
  }

  trait S3Interpreter extends S3Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, S3Client, A] = interpreter.embed(e)
  }


  def primitive[J, A](f: J => A): Kleisli[M, J, A] = Kleisli(a => {
    // primitive AWS methods throw exceptions and so do we when reading values
    // so catch any non-fatal exceptions and lift them into the effect
    blocker.blockOn[M, A](try {
      asyncM.delay(f(a))
    } catch {
      case scala.util.control.NonFatal(e) => asyncM.raiseError(e)
    })(contextShiftM)
  })

  def embed[J, A](e: Embedded[A]): Kleisli[M, J, A] = e match {
    case Embedded.Athena(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AthenaClient, *]](AthenaInterpreter).run(client))
    case Embedded.CodeBuild(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeBuildClient, *]](CodeBuildInterpreter).run(client))
    case Embedded.Ec2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Ec2Client, *]](Ec2Interpreter).run(client))
    case Embedded.S3(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, S3Client, *]](S3Interpreter).run(client))
  }

  val blocker: Blocker
  implicit val asyncM: Async[M]
  val contextShiftM: ContextShift[M]
}
