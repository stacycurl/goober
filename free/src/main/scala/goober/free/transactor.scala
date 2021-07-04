package goober.free

import scala.language.higherKinds

import java.util.concurrent.Executors
import cats.data.Kleisli
import cats.effect.{Async, Blocker, Bracket, ContextShift, Resource}
import cats.{Applicative, Defer, Endo, ~>}
import goober.free.s3.S3Op
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
        connect = resource,
        interpreter = interpreter
      )

      private lazy val blocker: Blocker = optBlocker.getOrElse(defaultBlocker)

      private lazy val interpreter: Interpreter[M] = optInterpreterFn match {
        case None => KleisliInterpreter[M](blocker).S3Interpreter
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
