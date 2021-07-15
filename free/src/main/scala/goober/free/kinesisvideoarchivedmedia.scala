package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisvideoarchivedmedia.KinesisVideoArchivedMediaClient
import software.amazon.awssdk.services.kinesisvideoarchivedmedia.model._


object kinesisvideoarchivedmedia { module =>

  // Free monad over KinesisVideoArchivedMediaOp
  type KinesisVideoArchivedMediaIO[A] = FF[KinesisVideoArchivedMediaOp, A]

  sealed trait KinesisVideoArchivedMediaOp[A] {
    def visit[F[_]](visitor: KinesisVideoArchivedMediaOp.Visitor[F]): F[A]
  }

  object KinesisVideoArchivedMediaOp {
    // Given a KinesisVideoArchivedMediaClient we can embed a KinesisVideoArchivedMediaIO program in any algebra that understands embedding.
    implicit val KinesisVideoArchivedMediaOpEmbeddable: Embeddable[KinesisVideoArchivedMediaOp, KinesisVideoArchivedMediaClient] = new Embeddable[KinesisVideoArchivedMediaOp, KinesisVideoArchivedMediaClient] {
      def embed[A](client: KinesisVideoArchivedMediaClient, io: KinesisVideoArchivedMediaIO[A]): Embedded[A] = Embedded.KinesisVideoArchivedMedia(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KinesisVideoArchivedMediaOp.Visitor[Kleisli[M, KinesisVideoArchivedMediaClient, *]] {
        def getDASHStreamingSessionURL(
          request: GetDashStreamingSessionUrlRequest
        ): Kleisli[M, KinesisVideoArchivedMediaClient, GetDashStreamingSessionUrlResponse] =
          primitive(_.getDASHStreamingSessionURL(request))

        def getHLSStreamingSessionURL(
          request: GetHlsStreamingSessionUrlRequest
        ): Kleisli[M, KinesisVideoArchivedMediaClient, GetHlsStreamingSessionUrlResponse] =
          primitive(_.getHLSStreamingSessionURL(request))

        def listFragments(
          request: ListFragmentsRequest
        ): Kleisli[M, KinesisVideoArchivedMediaClient, ListFragmentsResponse] =
          primitive(_.listFragments(request))

        def primitive[A](
          f: KinesisVideoArchivedMediaClient => A
        ): Kleisli[M, KinesisVideoArchivedMediaClient, A]
      }
    }

    trait Visitor[F[_]] extends (KinesisVideoArchivedMediaOp ~> F) {
      final def apply[A](op: KinesisVideoArchivedMediaOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def getDASHStreamingSessionURL(
        request: GetDashStreamingSessionUrlRequest
      ): F[GetDashStreamingSessionUrlResponse]

      def getHLSStreamingSessionURL(
        request: GetHlsStreamingSessionUrlRequest
      ): F[GetHlsStreamingSessionUrlResponse]

      def listFragments(
        request: ListFragmentsRequest
      ): F[ListFragmentsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisVideoArchivedMediaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GetDASHStreamingSessionURLOp(
      request: GetDashStreamingSessionUrlRequest
    ) extends KinesisVideoArchivedMediaOp[GetDashStreamingSessionUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDashStreamingSessionUrlResponse] =
        visitor.getDASHStreamingSessionURL(request)
    }

    final case class GetHLSStreamingSessionURLOp(
      request: GetHlsStreamingSessionUrlRequest
    ) extends KinesisVideoArchivedMediaOp[GetHlsStreamingSessionUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHlsStreamingSessionUrlResponse] =
        visitor.getHLSStreamingSessionURL(request)
    }

    final case class ListFragmentsOp(
      request: ListFragmentsRequest
    ) extends KinesisVideoArchivedMediaOp[ListFragmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFragmentsResponse] =
        visitor.listFragments(request)
    }
  }

  import KinesisVideoArchivedMediaOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KinesisVideoArchivedMediaOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def getDASHStreamingSessionURL(
    request: GetDashStreamingSessionUrlRequest
  ): KinesisVideoArchivedMediaIO[GetDashStreamingSessionUrlResponse] =
    FF.liftF(GetDASHStreamingSessionURLOp(request))

  def getHLSStreamingSessionURL(
    request: GetHlsStreamingSessionUrlRequest
  ): KinesisVideoArchivedMediaIO[GetHlsStreamingSessionUrlResponse] =
    FF.liftF(GetHLSStreamingSessionURLOp(request))

  def listFragments(
    request: ListFragmentsRequest
  ): KinesisVideoArchivedMediaIO[ListFragmentsResponse] =
    FF.liftF(ListFragmentsOp(request))
}
