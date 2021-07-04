package goober.free

import scala.language.higherKinds

import java.util.concurrent.Executors
import cats.data.Kleisli
import cats.effect.{Async, Blocker, Bracket, ContextShift, Resource}
import cats.{Applicative, Defer, Endo, ~>}
import goober.free.athena.AthenaOp
import goober.free.ec2.EC2Op
import goober.free.s3.S3Op
import software.amazon.awssdk.services.athena.AthenaClient
import software.amazon.awssdk.services.ec2.Ec2Client
import software.amazon.awssdk.services.s3.{S3Client, S3ClientBuilder}

import scala.concurrent.ExecutionContext

object transactor {
  type Interpreter[M[_]] = S3Op ~> Kleisli[M, S3Client, *]

  object Transactor {
    def apply[M[_]](
      connect: Resource[M, S3Client],
      interpreter: Interpreter[M],
    ): Transactor[M] =
      new Transactor[M](connect, interpreter) {}

    // An unbounded cached pool of daemon threads.
    private lazy val defaultBlocker: Blocker = Blocker.liftExecutionContext {
      ExecutionContext.fromExecutor(Executors.newCachedThreadPool((r: Runnable) => {
        val th = new Thread(r)
        th.setName(s"goober-fromDriverManager-pool-${th.getId}")
        th.setDaemon(true)
        th
      }))
    }

    case class from[M[_]](
      optBlocker: Option[Blocker] = None,
      optInterpreterFn: Option[Blocker => Interpreter[M]] = None
    )(implicit
      async: Async[M],
      cs: ContextShift[M]
    ) {

      def builder(builder: () => S3ClientBuilder): Transactor[M] = client(
        connect = () => builder().build()
      )

      def client(connect: () => S3Client): Transactor[M] = resource(
        resource = Resource.make(blocker.blockOn(async.delay(connect())))(s3Client => {
          blocker.blockOn(async.delay(s3Client.close()))
        })
      )

      def resource(resource: Resource[M, S3Client]): Transactor[M] = Transactor(
        connect     = resource,
        interpreter = interpreter
      )

      private lazy val blocker: Blocker = optBlocker.getOrElse(defaultBlocker)

      private lazy val interpreter: Interpreter[M] = optInterpreterFn match {
        case None     => KleisliInterpreter[M](blocker).S3Interpreter
        case Some(fn) => fn(blocker)
      }
    }
  }

  sealed abstract class Transactor[M[_]](
    connect: Resource[M, S3Client],
    interpreter: Interpreter[M]
  ) {
    def rawExec(implicit ev: Bracket[M, Throwable]): Kleisli[M, S3Client, *] ~> M = new (Kleisli[M, S3Client, *] ~> M) {
      def apply[A](k: Kleisli[M, S3Client, A]): M[A] = connect.use(k.run)
    }

    def modify(
      connect: Endo[Resource[M, S3Client]] = identity,
      interpreter: Endo[Interpreter[M]] = identity
    ): Transactor[M] = copy(
      connect = connect(this.connect),
      interpreter = interpreter(this.interpreter)
    )

    def copy(
      connect: Resource[M, S3Client] = connect,
      interpreter: Interpreter[M] = interpreter
    ): Transactor[M] = Transactor(
      connect,
      interpreter
    )

    def mapK[M0[_]](fk: M ~> M0)(implicit D: Defer[M0], A: Applicative[M0]): Transactor[M0] = Transactor[M0](
      connect.mapK(fk),
      interpreter.andThen[Kleisli[M0, S3Client, *]](new (Kleisli[M, S3Client, *] ~> Kleisli[M0, S3Client, *]) {
        def apply[A](k: Kleisli[M, S3Client, A]): Kleisli[M0, S3Client, A] = k.mapK(fk)
      })
    )
  }
}

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

  lazy val EC2Interpreter: EC2Op ~> Kleisli[M, Ec2Client, *] = new EC2Interpreter {
    def primitive[A](f: Ec2Client ⇒ A): Kleisli[M, Ec2Client, A] = interpreter.primitive(f)
  }

  lazy val S3Interpreter: S3Op ~> Kleisli[M, S3Client, *] = new S3Interpreter {
    def primitive[A](f: S3Client ⇒ A): Kleisli[M, S3Client, A] = interpreter.primitive(f)
  }

  trait AthenaInterpreter extends AthenaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AthenaClient, A] = interpreter.embed(e)
  }

  trait EC2Interpreter extends EC2Op.Visitor.KleisliVisitor[M] {
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
    case Embedded.Ec2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Ec2Client, *]](EC2Interpreter).run(client))
    case Embedded.S3(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, S3Client, *]](S3Interpreter).run(client))
  }

  val blocker: Blocker
  implicit val asyncM: Async[M]
  val contextShiftM: ContextShift[M]
}
