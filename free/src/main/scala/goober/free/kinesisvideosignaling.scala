package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisvideosignaling.KinesisVideoSignalingClient
import software.amazon.awssdk.services.kinesisvideosignaling.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object kinesisvideosignaling { module =>

  // Free monad over KinesisVideoSignalingOp
  type KinesisVideoSignalingIO[A] = FF[KinesisVideoSignalingOp, A]

  sealed trait KinesisVideoSignalingOp[A] {
    def visit[F[_]](visitor: KinesisVideoSignalingOp.Visitor[F]): F[A]
  }

  object KinesisVideoSignalingOp {
    // Given a KinesisVideoSignalingClient we can embed a KinesisVideoSignalingIO program in any algebra that understands embedding.
    implicit val KinesisVideoSignalingOpEmbeddable: Embeddable[KinesisVideoSignalingOp, KinesisVideoSignalingClient] = new Embeddable[KinesisVideoSignalingOp, KinesisVideoSignalingClient] {
      def embed[A](client: KinesisVideoSignalingClient, io: KinesisVideoSignalingIO[A]): Embedded[A] = Embedded.KinesisVideoSignaling(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KinesisVideoSignalingOp.Visitor[Kleisli[M, KinesisVideoSignalingClient, *]] {
        def getIceServerConfig(
          request: GetIceServerConfigRequest
        ): Kleisli[M, KinesisVideoSignalingClient, GetIceServerConfigResponse] =
          primitive(_.getIceServerConfig(request))

        def sendAlexaOfferToMaster(
          request: SendAlexaOfferToMasterRequest
        ): Kleisli[M, KinesisVideoSignalingClient, SendAlexaOfferToMasterResponse] =
          primitive(_.sendAlexaOfferToMaster(request))

        def primitive[A](
          f: KinesisVideoSignalingClient => A
        ): Kleisli[M, KinesisVideoSignalingClient, A]
      }
    }

    trait Visitor[F[_]] extends (KinesisVideoSignalingOp ~> F) {
      final def apply[A](op: KinesisVideoSignalingOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def getIceServerConfig(
        request: GetIceServerConfigRequest
      ): F[GetIceServerConfigResponse]

      def sendAlexaOfferToMaster(
        request: SendAlexaOfferToMasterRequest
      ): F[SendAlexaOfferToMasterResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisVideoSignalingOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GetIceServerConfigOp(
      request: GetIceServerConfigRequest
    ) extends KinesisVideoSignalingOp[GetIceServerConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIceServerConfigResponse] =
        visitor.getIceServerConfig(request)
    }

    final case class SendAlexaOfferToMasterOp(
      request: SendAlexaOfferToMasterRequest
    ) extends KinesisVideoSignalingOp[SendAlexaOfferToMasterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendAlexaOfferToMasterResponse] =
        visitor.sendAlexaOfferToMaster(request)
    }
  }

  import KinesisVideoSignalingOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KinesisVideoSignalingOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def getIceServerConfig(
    request: GetIceServerConfigRequest
  ): KinesisVideoSignalingIO[GetIceServerConfigResponse] =
    FF.liftF(GetIceServerConfigOp(request))

  def sendAlexaOfferToMaster(
    request: SendAlexaOfferToMasterRequest
  ): KinesisVideoSignalingIO[SendAlexaOfferToMasterResponse] =
    FF.liftF(SendAlexaOfferToMasterOp(request))
}
