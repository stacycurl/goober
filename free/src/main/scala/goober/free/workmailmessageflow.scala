package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.workmailmessageflow.WorkMailMessageFlowClient
import software.amazon.awssdk.services.workmailmessageflow.model._


object workmailmessageflow { module =>

  // Free monad over WorkMailMessageFlowOp
  type WorkMailMessageFlowIO[A] = FF[WorkMailMessageFlowOp, A]

  sealed trait WorkMailMessageFlowOp[A] {
    def visit[F[_]](visitor: WorkMailMessageFlowOp.Visitor[F]): F[A]
  }

  object WorkMailMessageFlowOp {
    // Given a WorkMailMessageFlowClient we can embed a WorkMailMessageFlowIO program in any algebra that understands embedding.
    implicit val WorkMailMessageFlowOpEmbeddable: Embeddable[WorkMailMessageFlowOp, WorkMailMessageFlowClient] = new Embeddable[WorkMailMessageFlowOp, WorkMailMessageFlowClient] {
      def embed[A](client: WorkMailMessageFlowClient, io: WorkMailMessageFlowIO[A]): Embedded[A] = Embedded.WorkMailMessageFlow(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WorkMailMessageFlowOp.Visitor[Kleisli[M, WorkMailMessageFlowClient, *]] {
        def putRawMessageContent(
          request: PutRawMessageContentRequest
        ): Kleisli[M, WorkMailMessageFlowClient, PutRawMessageContentResponse] =
          primitive(_.putRawMessageContent(request))

        def primitive[A](
          f: WorkMailMessageFlowClient => A
        ): Kleisli[M, WorkMailMessageFlowClient, A]
      }
    }

    trait Visitor[F[_]] extends (WorkMailMessageFlowOp ~> F) {
      final def apply[A](op: WorkMailMessageFlowOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def putRawMessageContent(
        request: PutRawMessageContentRequest
      ): F[PutRawMessageContentResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends WorkMailMessageFlowOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class PutRawMessageContentOp(
      request: PutRawMessageContentRequest
    ) extends WorkMailMessageFlowOp[PutRawMessageContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRawMessageContentResponse] =
        visitor.putRawMessageContent(request)
    }
  }

  import WorkMailMessageFlowOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WorkMailMessageFlowOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def putRawMessageContent(
    request: PutRawMessageContentRequest
  ): WorkMailMessageFlowIO[PutRawMessageContentResponse] =
    FF.liftF(PutRawMessageContentOp(request))
}
