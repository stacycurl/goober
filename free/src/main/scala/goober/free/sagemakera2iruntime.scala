package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sagemakera2iruntime.SageMakerA2IRuntimeClient
import software.amazon.awssdk.services.sagemakera2iruntime.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object sagemakera2iruntime { module =>

  // Free monad over SageMakerA2IRuntimeOp
  type SageMakerA2IRuntimeIO[A] = FF[SageMakerA2IRuntimeOp, A]

  sealed trait SageMakerA2IRuntimeOp[A] {
    def visit[F[_]](visitor: SageMakerA2IRuntimeOp.Visitor[F]): F[A]
  }

  object SageMakerA2IRuntimeOp {
    // Given a SageMakerA2IRuntimeClient we can embed a SageMakerA2IRuntimeIO program in any algebra that understands embedding.
    implicit val SageMakerA2IRuntimeOpEmbeddable: Embeddable[SageMakerA2IRuntimeOp, SageMakerA2IRuntimeClient] = new Embeddable[SageMakerA2IRuntimeOp, SageMakerA2IRuntimeClient] {
      def embed[A](client: SageMakerA2IRuntimeClient, io: SageMakerA2IRuntimeIO[A]): Embedded[A] = Embedded.SageMakerA2IRuntime(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SageMakerA2IRuntimeOp.Visitor[Kleisli[M, SageMakerA2IRuntimeClient, *]] {
        def deleteHumanLoop(
          request: DeleteHumanLoopRequest
        ): Kleisli[M, SageMakerA2IRuntimeClient, DeleteHumanLoopResponse] =
          primitive(_.deleteHumanLoop(request))

        def describeHumanLoop(
          request: DescribeHumanLoopRequest
        ): Kleisli[M, SageMakerA2IRuntimeClient, DescribeHumanLoopResponse] =
          primitive(_.describeHumanLoop(request))

        def listHumanLoops(
          request: ListHumanLoopsRequest
        ): Kleisli[M, SageMakerA2IRuntimeClient, ListHumanLoopsResponse] =
          primitive(_.listHumanLoops(request))

        def startHumanLoop(
          request: StartHumanLoopRequest
        ): Kleisli[M, SageMakerA2IRuntimeClient, StartHumanLoopResponse] =
          primitive(_.startHumanLoop(request))

        def stopHumanLoop(
          request: StopHumanLoopRequest
        ): Kleisli[M, SageMakerA2IRuntimeClient, StopHumanLoopResponse] =
          primitive(_.stopHumanLoop(request))

        def primitive[A](
          f: SageMakerA2IRuntimeClient => A
        ): Kleisli[M, SageMakerA2IRuntimeClient, A]
      }
    }

    trait Visitor[F[_]] extends (SageMakerA2IRuntimeOp ~> F) {
      final def apply[A](op: SageMakerA2IRuntimeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteHumanLoop(
        request: DeleteHumanLoopRequest
      ): F[DeleteHumanLoopResponse]

      def describeHumanLoop(
        request: DescribeHumanLoopRequest
      ): F[DescribeHumanLoopResponse]

      def listHumanLoops(
        request: ListHumanLoopsRequest
      ): F[ListHumanLoopsResponse]

      def startHumanLoop(
        request: StartHumanLoopRequest
      ): F[StartHumanLoopResponse]

      def stopHumanLoop(
        request: StopHumanLoopRequest
      ): F[StopHumanLoopResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SageMakerA2IRuntimeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteHumanLoopOp(
      request: DeleteHumanLoopRequest
    ) extends SageMakerA2IRuntimeOp[DeleteHumanLoopResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHumanLoopResponse] =
        visitor.deleteHumanLoop(request)
    }

    final case class DescribeHumanLoopOp(
      request: DescribeHumanLoopRequest
    ) extends SageMakerA2IRuntimeOp[DescribeHumanLoopResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHumanLoopResponse] =
        visitor.describeHumanLoop(request)
    }

    final case class ListHumanLoopsOp(
      request: ListHumanLoopsRequest
    ) extends SageMakerA2IRuntimeOp[ListHumanLoopsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHumanLoopsResponse] =
        visitor.listHumanLoops(request)
    }

    final case class StartHumanLoopOp(
      request: StartHumanLoopRequest
    ) extends SageMakerA2IRuntimeOp[StartHumanLoopResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartHumanLoopResponse] =
        visitor.startHumanLoop(request)
    }

    final case class StopHumanLoopOp(
      request: StopHumanLoopRequest
    ) extends SageMakerA2IRuntimeOp[StopHumanLoopResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopHumanLoopResponse] =
        visitor.stopHumanLoop(request)
    }
  }

  import SageMakerA2IRuntimeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SageMakerA2IRuntimeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteHumanLoop(
    request: DeleteHumanLoopRequest
  ): SageMakerA2IRuntimeIO[DeleteHumanLoopResponse] =
    FF.liftF(DeleteHumanLoopOp(request))

  def describeHumanLoop(
    request: DescribeHumanLoopRequest
  ): SageMakerA2IRuntimeIO[DescribeHumanLoopResponse] =
    FF.liftF(DescribeHumanLoopOp(request))

  def listHumanLoops(
    request: ListHumanLoopsRequest
  ): SageMakerA2IRuntimeIO[ListHumanLoopsResponse] =
    FF.liftF(ListHumanLoopsOp(request))

  def startHumanLoop(
    request: StartHumanLoopRequest
  ): SageMakerA2IRuntimeIO[StartHumanLoopResponse] =
    FF.liftF(StartHumanLoopOp(request))

  def stopHumanLoop(
    request: StopHumanLoopRequest
  ): SageMakerA2IRuntimeIO[StopHumanLoopResponse] =
    FF.liftF(StopHumanLoopOp(request))
}
