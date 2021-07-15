package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisvideomedia.KinesisVideoMediaClient
import software.amazon.awssdk.services.kinesisvideomedia.model._


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


    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisVideoMediaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
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


}
