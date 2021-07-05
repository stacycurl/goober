package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.connectcontactlens.ConnectContactLensClient
import software.amazon.awssdk.services.connectcontactlens.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object connectcontactlens { module =>

  // Free monad over ConnectContactLensOp
  type ConnectContactLensIO[A] = FF[ConnectContactLensOp, A]

  sealed trait ConnectContactLensOp[A] {
    def visit[F[_]](visitor: ConnectContactLensOp.Visitor[F]): F[A]
  }

  object ConnectContactLensOp {
    // Given a ConnectContactLensClient we can embed a ConnectContactLensIO program in any algebra that understands embedding.
    implicit val ConnectContactLensOpEmbeddable: Embeddable[ConnectContactLensOp, ConnectContactLensClient] = new Embeddable[ConnectContactLensOp, ConnectContactLensClient] {
      def embed[A](client: ConnectContactLensClient, io: ConnectContactLensIO[A]): Embedded[A] = Embedded.ConnectContactLens(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ConnectContactLensOp.Visitor[Kleisli[M, ConnectContactLensClient, *]] {
        def listRealtimeContactAnalysisSegments(
          request: ListRealtimeContactAnalysisSegmentsRequest
        ): Kleisli[M, ConnectContactLensClient, ListRealtimeContactAnalysisSegmentsResponse] =
          primitive(_.listRealtimeContactAnalysisSegments(request))

        def primitive[A](
          f: ConnectContactLensClient => A
        ): Kleisli[M, ConnectContactLensClient, A]
      }
    }

    trait Visitor[F[_]] extends (ConnectContactLensOp ~> F) {
      final def apply[A](op: ConnectContactLensOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def listRealtimeContactAnalysisSegments(
        request: ListRealtimeContactAnalysisSegmentsRequest
      ): F[ListRealtimeContactAnalysisSegmentsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ConnectContactLensOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ListRealtimeContactAnalysisSegmentsOp(
      request: ListRealtimeContactAnalysisSegmentsRequest
    ) extends ConnectContactLensOp[ListRealtimeContactAnalysisSegmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRealtimeContactAnalysisSegmentsResponse] =
        visitor.listRealtimeContactAnalysisSegments(request)
    }
  }

  import ConnectContactLensOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ConnectContactLensOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def listRealtimeContactAnalysisSegments(
    request: ListRealtimeContactAnalysisSegmentsRequest
  ): ConnectContactLensIO[ListRealtimeContactAnalysisSegmentsResponse] =
    FF.liftF(ListRealtimeContactAnalysisSegmentsOp(request))
}
