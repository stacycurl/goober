package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisvideoarchivedmedia.KinesisVideoArchivedMediaClient
import software.amazon.awssdk.services.kinesisvideoarchivedmedia.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

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
        def getClip(
          request: GetClipRequest,
          path: Path
        ): Kleisli[M, KinesisVideoArchivedMediaClient, GetClipResponse] =
          primitive(_.getClip(request, path))

        def getDASHStreamingSessionURL(
          request: GetDashStreamingSessionUrlRequest
        ): Kleisli[M, KinesisVideoArchivedMediaClient, GetDashStreamingSessionUrlResponse] =
          primitive(_.getDASHStreamingSessionURL(request))

        def getHLSStreamingSessionURL(
          request: GetHlsStreamingSessionUrlRequest
        ): Kleisli[M, KinesisVideoArchivedMediaClient, GetHlsStreamingSessionUrlResponse] =
          primitive(_.getHLSStreamingSessionURL(request))

        def getMediaForFragmentList(
          request: GetMediaForFragmentListRequest,
          path: Path
        ): Kleisli[M, KinesisVideoArchivedMediaClient, GetMediaForFragmentListResponse] =
          primitive(_.getMediaForFragmentList(request, path))

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

      def getClip(
        request: GetClipRequest,
        path: Path
      ): F[GetClipResponse]

      def getDASHStreamingSessionURL(
        request: GetDashStreamingSessionUrlRequest
      ): F[GetDashStreamingSessionUrlResponse]

      def getHLSStreamingSessionURL(
        request: GetHlsStreamingSessionUrlRequest
      ): F[GetHlsStreamingSessionUrlResponse]

      def getMediaForFragmentList(
        request: GetMediaForFragmentListRequest,
        path: Path
      ): F[GetMediaForFragmentListResponse]

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

    final case class GetClipOp(
      request: GetClipRequest,
      path: Path
    ) extends KinesisVideoArchivedMediaOp[GetClipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetClipResponse] =
        visitor.getClip(request, path)
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

    final case class GetMediaForFragmentListOp(
      request: GetMediaForFragmentListRequest,
      path: Path
    ) extends KinesisVideoArchivedMediaOp[GetMediaForFragmentListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMediaForFragmentListResponse] =
        visitor.getMediaForFragmentList(request, path)
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

  def getClip(
    request: GetClipRequest,
    path: Path
  ): KinesisVideoArchivedMediaIO[GetClipResponse] =
    FF.liftF(GetClipOp(request, path))

  def getDASHStreamingSessionURL(
    request: GetDashStreamingSessionUrlRequest
  ): KinesisVideoArchivedMediaIO[GetDashStreamingSessionUrlResponse] =
    FF.liftF(GetDASHStreamingSessionURLOp(request))

  def getHLSStreamingSessionURL(
    request: GetHlsStreamingSessionUrlRequest
  ): KinesisVideoArchivedMediaIO[GetHlsStreamingSessionUrlResponse] =
    FF.liftF(GetHLSStreamingSessionURLOp(request))

  def getMediaForFragmentList(
    request: GetMediaForFragmentListRequest,
    path: Path
  ): KinesisVideoArchivedMediaIO[GetMediaForFragmentListResponse] =
    FF.liftF(GetMediaForFragmentListOp(request, path))

  def listFragments(
    request: ListFragmentsRequest
  ): KinesisVideoArchivedMediaIO[ListFragmentsResponse] =
    FF.liftF(ListFragmentsOp(request))
}
