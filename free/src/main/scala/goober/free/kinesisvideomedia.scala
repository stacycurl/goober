package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisvideomedia.KinesisVideoMediaClient
import software.amazon.awssdk.services.kinesisvideomedia.model._
import java.nio.file.Path


object kinesisvideomedia { module =>

  // Free monad over KinesisVideoMediaOp
  type KinesisVideoMediaIO[A] = FF[KinesisVideoMediaOp, A]

  sealed trait KinesisVideoMediaOp[A] {
    def visit[F[_]](visitor: KinesisVideoMediaOp.Visitor[F]): F[A]
  }

  object KinesisVideoMediaOp {
    // Given a KinesisVideoMediaClient we can embed a KinesisVideoMediaIO program in any algebra that understands embedding.
    implicit val KinesisVideoMediaOpEmbeddable: Embeddable[KinesisVideoMediaOp, KinesisVideoMediaClient] = new Embeddable[KinesisVideoMediaOp, KinesisVideoMediaClient] {
      def embed[A](client: KinesisVideoMediaClient, io: KinesisVideoMediaIO[A]): Embedded[A] = Embedded.KinesisVideoMedia(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KinesisVideoMediaOp.Visitor[Kleisli[M, KinesisVideoMediaClient, *]] {
        def getMedia(
          request: GetMediaRequest,
          path: Path
        ): Kleisli[M, KinesisVideoMediaClient, GetMediaResponse] =
          primitive(_.getMedia(request, path))

        def primitive[A](
          f: KinesisVideoMediaClient => A
        ): Kleisli[M, KinesisVideoMediaClient, A]
      }
    }

    trait Visitor[F[_]] extends (KinesisVideoMediaOp ~> F) {
      final def apply[A](op: KinesisVideoMediaOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def getMedia(
        request: GetMediaRequest,
        path: Path
      ): F[GetMediaResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisVideoMediaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GetMediaOp(
      request: GetMediaRequest,
      path: Path
    ) extends KinesisVideoMediaOp[GetMediaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMediaResponse] =
        visitor.getMedia(request, path)
    }
  }

  import KinesisVideoMediaOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KinesisVideoMediaOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def getMedia(
    request: GetMediaRequest,
    path: Path
  ): KinesisVideoMediaIO[GetMediaResponse] =
    FF.liftF(GetMediaOp(request, path))
}
