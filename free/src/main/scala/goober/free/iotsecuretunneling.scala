package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotsecuretunneling.IoTSecureTunnelingClient
import software.amazon.awssdk.services.iotsecuretunneling.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object iotsecuretunneling { module =>

  // Free monad over IoTSecureTunnelingOp
  type IoTSecureTunnelingIO[A] = FF[IoTSecureTunnelingOp, A]

  sealed trait IoTSecureTunnelingOp[A] {
    def visit[F[_]](visitor: IoTSecureTunnelingOp.Visitor[F]): F[A]
  }

  object IoTSecureTunnelingOp {
    // Given a IoTSecureTunnelingClient we can embed a IoTSecureTunnelingIO program in any algebra that understands embedding.
    implicit val IoTSecureTunnelingOpEmbeddable: Embeddable[IoTSecureTunnelingOp, IoTSecureTunnelingClient] = new Embeddable[IoTSecureTunnelingOp, IoTSecureTunnelingClient] {
      def embed[A](client: IoTSecureTunnelingClient, io: IoTSecureTunnelingIO[A]): Embedded[A] = Embedded.IoTSecureTunneling(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IoTSecureTunnelingOp.Visitor[Kleisli[M, IoTSecureTunnelingClient, *]] {
        def closeTunnel(
          request: CloseTunnelRequest
        ): Kleisli[M, IoTSecureTunnelingClient, CloseTunnelResponse] =
          primitive(_.closeTunnel(request))

        def describeTunnel(
          request: DescribeTunnelRequest
        ): Kleisli[M, IoTSecureTunnelingClient, DescribeTunnelResponse] =
          primitive(_.describeTunnel(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IoTSecureTunnelingClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTunnels(
          request: ListTunnelsRequest
        ): Kleisli[M, IoTSecureTunnelingClient, ListTunnelsResponse] =
          primitive(_.listTunnels(request))

        def openTunnel(
          request: OpenTunnelRequest
        ): Kleisli[M, IoTSecureTunnelingClient, OpenTunnelResponse] =
          primitive(_.openTunnel(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IoTSecureTunnelingClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IoTSecureTunnelingClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: IoTSecureTunnelingClient => A
        ): Kleisli[M, IoTSecureTunnelingClient, A]
      }
    }

    trait Visitor[F[_]] extends (IoTSecureTunnelingOp ~> F) {
      final def apply[A](op: IoTSecureTunnelingOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def closeTunnel(
        request: CloseTunnelRequest
      ): F[CloseTunnelResponse]

      def describeTunnel(
        request: DescribeTunnelRequest
      ): F[DescribeTunnelResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTunnels(
        request: ListTunnelsRequest
      ): F[ListTunnelsResponse]

      def openTunnel(
        request: OpenTunnelRequest
      ): F[OpenTunnelResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IoTSecureTunnelingOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CloseTunnelOp(
      request: CloseTunnelRequest
    ) extends IoTSecureTunnelingOp[CloseTunnelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CloseTunnelResponse] =
        visitor.closeTunnel(request)
    }

    final case class DescribeTunnelOp(
      request: DescribeTunnelRequest
    ) extends IoTSecureTunnelingOp[DescribeTunnelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTunnelResponse] =
        visitor.describeTunnel(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IoTSecureTunnelingOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTunnelsOp(
      request: ListTunnelsRequest
    ) extends IoTSecureTunnelingOp[ListTunnelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTunnelsResponse] =
        visitor.listTunnels(request)
    }

    final case class OpenTunnelOp(
      request: OpenTunnelRequest
    ) extends IoTSecureTunnelingOp[OpenTunnelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[OpenTunnelResponse] =
        visitor.openTunnel(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IoTSecureTunnelingOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IoTSecureTunnelingOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import IoTSecureTunnelingOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IoTSecureTunnelingOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def closeTunnel(
    request: CloseTunnelRequest
  ): IoTSecureTunnelingIO[CloseTunnelResponse] =
    FF.liftF(CloseTunnelOp(request))

  def describeTunnel(
    request: DescribeTunnelRequest
  ): IoTSecureTunnelingIO[DescribeTunnelResponse] =
    FF.liftF(DescribeTunnelOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IoTSecureTunnelingIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTunnels(
    request: ListTunnelsRequest
  ): IoTSecureTunnelingIO[ListTunnelsResponse] =
    FF.liftF(ListTunnelsOp(request))

  def openTunnel(
    request: OpenTunnelRequest
  ): IoTSecureTunnelingIO[OpenTunnelResponse] =
    FF.liftF(OpenTunnelOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IoTSecureTunnelingIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IoTSecureTunnelingIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
