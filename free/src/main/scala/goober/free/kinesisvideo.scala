package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisvideo.KinesisVideoClient
import software.amazon.awssdk.services.kinesisvideo.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object kinesisvideo { module =>

  // Free monad over KinesisVideoOp
  type KinesisVideoIO[A] = FF[KinesisVideoOp, A]

  sealed trait KinesisVideoOp[A] {
    def visit[F[_]](visitor: KinesisVideoOp.Visitor[F]): F[A]
  }

  object KinesisVideoOp {
    // Given a KinesisVideoClient we can embed a KinesisVideoIO program in any algebra that understands embedding.
    implicit val KinesisVideoOpEmbeddable: Embeddable[KinesisVideoOp, KinesisVideoClient] = new Embeddable[KinesisVideoOp, KinesisVideoClient] {
      def embed[A](client: KinesisVideoClient, io: KinesisVideoIO[A]): Embedded[A] = Embedded.KinesisVideo(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KinesisVideoOp.Visitor[Kleisli[M, KinesisVideoClient, *]] {
        def createSignalingChannel(
          request: CreateSignalingChannelRequest
        ): Kleisli[M, KinesisVideoClient, CreateSignalingChannelResponse] =
          primitive(_.createSignalingChannel(request))

        def createStream(
          request: CreateStreamRequest
        ): Kleisli[M, KinesisVideoClient, CreateStreamResponse] =
          primitive(_.createStream(request))

        def deleteSignalingChannel(
          request: DeleteSignalingChannelRequest
        ): Kleisli[M, KinesisVideoClient, DeleteSignalingChannelResponse] =
          primitive(_.deleteSignalingChannel(request))

        def deleteStream(
          request: DeleteStreamRequest
        ): Kleisli[M, KinesisVideoClient, DeleteStreamResponse] =
          primitive(_.deleteStream(request))

        def describeSignalingChannel(
          request: DescribeSignalingChannelRequest
        ): Kleisli[M, KinesisVideoClient, DescribeSignalingChannelResponse] =
          primitive(_.describeSignalingChannel(request))

        def describeStream(
          request: DescribeStreamRequest
        ): Kleisli[M, KinesisVideoClient, DescribeStreamResponse] =
          primitive(_.describeStream(request))

        def getDataEndpoint(
          request: GetDataEndpointRequest
        ): Kleisli[M, KinesisVideoClient, GetDataEndpointResponse] =
          primitive(_.getDataEndpoint(request))

        def getSignalingChannelEndpoint(
          request: GetSignalingChannelEndpointRequest
        ): Kleisli[M, KinesisVideoClient, GetSignalingChannelEndpointResponse] =
          primitive(_.getSignalingChannelEndpoint(request))

        def listSignalingChannels(
          request: ListSignalingChannelsRequest
        ): Kleisli[M, KinesisVideoClient, ListSignalingChannelsResponse] =
          primitive(_.listSignalingChannels(request))

        def listStreams(
          request: ListStreamsRequest
        ): Kleisli[M, KinesisVideoClient, ListStreamsResponse] =
          primitive(_.listStreams(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, KinesisVideoClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTagsForStream(
          request: ListTagsForStreamRequest
        ): Kleisli[M, KinesisVideoClient, ListTagsForStreamResponse] =
          primitive(_.listTagsForStream(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, KinesisVideoClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def tagStream(
          request: TagStreamRequest
        ): Kleisli[M, KinesisVideoClient, TagStreamResponse] =
          primitive(_.tagStream(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, KinesisVideoClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def untagStream(
          request: UntagStreamRequest
        ): Kleisli[M, KinesisVideoClient, UntagStreamResponse] =
          primitive(_.untagStream(request))

        def updateDataRetention(
          request: UpdateDataRetentionRequest
        ): Kleisli[M, KinesisVideoClient, UpdateDataRetentionResponse] =
          primitive(_.updateDataRetention(request))

        def updateSignalingChannel(
          request: UpdateSignalingChannelRequest
        ): Kleisli[M, KinesisVideoClient, UpdateSignalingChannelResponse] =
          primitive(_.updateSignalingChannel(request))

        def updateStream(
          request: UpdateStreamRequest
        ): Kleisli[M, KinesisVideoClient, UpdateStreamResponse] =
          primitive(_.updateStream(request))

        def primitive[A](
          f: KinesisVideoClient => A
        ): Kleisli[M, KinesisVideoClient, A]
      }
    }

    trait Visitor[F[_]] extends (KinesisVideoOp ~> F) {
      final def apply[A](op: KinesisVideoOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createSignalingChannel(
        request: CreateSignalingChannelRequest
      ): F[CreateSignalingChannelResponse]

      def createStream(
        request: CreateStreamRequest
      ): F[CreateStreamResponse]

      def deleteSignalingChannel(
        request: DeleteSignalingChannelRequest
      ): F[DeleteSignalingChannelResponse]

      def deleteStream(
        request: DeleteStreamRequest
      ): F[DeleteStreamResponse]

      def describeSignalingChannel(
        request: DescribeSignalingChannelRequest
      ): F[DescribeSignalingChannelResponse]

      def describeStream(
        request: DescribeStreamRequest
      ): F[DescribeStreamResponse]

      def getDataEndpoint(
        request: GetDataEndpointRequest
      ): F[GetDataEndpointResponse]

      def getSignalingChannelEndpoint(
        request: GetSignalingChannelEndpointRequest
      ): F[GetSignalingChannelEndpointResponse]

      def listSignalingChannels(
        request: ListSignalingChannelsRequest
      ): F[ListSignalingChannelsResponse]

      def listStreams(
        request: ListStreamsRequest
      ): F[ListStreamsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTagsForStream(
        request: ListTagsForStreamRequest
      ): F[ListTagsForStreamResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def tagStream(
        request: TagStreamRequest
      ): F[TagStreamResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def untagStream(
        request: UntagStreamRequest
      ): F[UntagStreamResponse]

      def updateDataRetention(
        request: UpdateDataRetentionRequest
      ): F[UpdateDataRetentionResponse]

      def updateSignalingChannel(
        request: UpdateSignalingChannelRequest
      ): F[UpdateSignalingChannelResponse]

      def updateStream(
        request: UpdateStreamRequest
      ): F[UpdateStreamResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisVideoOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateSignalingChannelOp(
      request: CreateSignalingChannelRequest
    ) extends KinesisVideoOp[CreateSignalingChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSignalingChannelResponse] =
        visitor.createSignalingChannel(request)
    }

    final case class CreateStreamOp(
      request: CreateStreamRequest
    ) extends KinesisVideoOp[CreateStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamResponse] =
        visitor.createStream(request)
    }

    final case class DeleteSignalingChannelOp(
      request: DeleteSignalingChannelRequest
    ) extends KinesisVideoOp[DeleteSignalingChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSignalingChannelResponse] =
        visitor.deleteSignalingChannel(request)
    }

    final case class DeleteStreamOp(
      request: DeleteStreamRequest
    ) extends KinesisVideoOp[DeleteStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamResponse] =
        visitor.deleteStream(request)
    }

    final case class DescribeSignalingChannelOp(
      request: DescribeSignalingChannelRequest
    ) extends KinesisVideoOp[DescribeSignalingChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSignalingChannelResponse] =
        visitor.describeSignalingChannel(request)
    }

    final case class DescribeStreamOp(
      request: DescribeStreamRequest
    ) extends KinesisVideoOp[DescribeStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStreamResponse] =
        visitor.describeStream(request)
    }

    final case class GetDataEndpointOp(
      request: GetDataEndpointRequest
    ) extends KinesisVideoOp[GetDataEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataEndpointResponse] =
        visitor.getDataEndpoint(request)
    }

    final case class GetSignalingChannelEndpointOp(
      request: GetSignalingChannelEndpointRequest
    ) extends KinesisVideoOp[GetSignalingChannelEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSignalingChannelEndpointResponse] =
        visitor.getSignalingChannelEndpoint(request)
    }

    final case class ListSignalingChannelsOp(
      request: ListSignalingChannelsRequest
    ) extends KinesisVideoOp[ListSignalingChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSignalingChannelsResponse] =
        visitor.listSignalingChannels(request)
    }

    final case class ListStreamsOp(
      request: ListStreamsRequest
    ) extends KinesisVideoOp[ListStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamsResponse] =
        visitor.listStreams(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends KinesisVideoOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTagsForStreamOp(
      request: ListTagsForStreamRequest
    ) extends KinesisVideoOp[ListTagsForStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForStreamResponse] =
        visitor.listTagsForStream(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends KinesisVideoOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TagStreamOp(
      request: TagStreamRequest
    ) extends KinesisVideoOp[TagStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagStreamResponse] =
        visitor.tagStream(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends KinesisVideoOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UntagStreamOp(
      request: UntagStreamRequest
    ) extends KinesisVideoOp[UntagStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagStreamResponse] =
        visitor.untagStream(request)
    }

    final case class UpdateDataRetentionOp(
      request: UpdateDataRetentionRequest
    ) extends KinesisVideoOp[UpdateDataRetentionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataRetentionResponse] =
        visitor.updateDataRetention(request)
    }

    final case class UpdateSignalingChannelOp(
      request: UpdateSignalingChannelRequest
    ) extends KinesisVideoOp[UpdateSignalingChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSignalingChannelResponse] =
        visitor.updateSignalingChannel(request)
    }

    final case class UpdateStreamOp(
      request: UpdateStreamRequest
    ) extends KinesisVideoOp[UpdateStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStreamResponse] =
        visitor.updateStream(request)
    }
  }

  import KinesisVideoOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KinesisVideoOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createSignalingChannel(
    request: CreateSignalingChannelRequest
  ): KinesisVideoIO[CreateSignalingChannelResponse] =
    FF.liftF(CreateSignalingChannelOp(request))

  def createStream(
    request: CreateStreamRequest
  ): KinesisVideoIO[CreateStreamResponse] =
    FF.liftF(CreateStreamOp(request))

  def deleteSignalingChannel(
    request: DeleteSignalingChannelRequest
  ): KinesisVideoIO[DeleteSignalingChannelResponse] =
    FF.liftF(DeleteSignalingChannelOp(request))

  def deleteStream(
    request: DeleteStreamRequest
  ): KinesisVideoIO[DeleteStreamResponse] =
    FF.liftF(DeleteStreamOp(request))

  def describeSignalingChannel(
    request: DescribeSignalingChannelRequest
  ): KinesisVideoIO[DescribeSignalingChannelResponse] =
    FF.liftF(DescribeSignalingChannelOp(request))

  def describeStream(
    request: DescribeStreamRequest
  ): KinesisVideoIO[DescribeStreamResponse] =
    FF.liftF(DescribeStreamOp(request))

  def getDataEndpoint(
    request: GetDataEndpointRequest
  ): KinesisVideoIO[GetDataEndpointResponse] =
    FF.liftF(GetDataEndpointOp(request))

  def getSignalingChannelEndpoint(
    request: GetSignalingChannelEndpointRequest
  ): KinesisVideoIO[GetSignalingChannelEndpointResponse] =
    FF.liftF(GetSignalingChannelEndpointOp(request))

  def listSignalingChannels(
    request: ListSignalingChannelsRequest
  ): KinesisVideoIO[ListSignalingChannelsResponse] =
    FF.liftF(ListSignalingChannelsOp(request))

  def listStreams(
    request: ListStreamsRequest
  ): KinesisVideoIO[ListStreamsResponse] =
    FF.liftF(ListStreamsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): KinesisVideoIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTagsForStream(
    request: ListTagsForStreamRequest
  ): KinesisVideoIO[ListTagsForStreamResponse] =
    FF.liftF(ListTagsForStreamOp(request))

  def tagResource(
    request: TagResourceRequest
  ): KinesisVideoIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def tagStream(
    request: TagStreamRequest
  ): KinesisVideoIO[TagStreamResponse] =
    FF.liftF(TagStreamOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): KinesisVideoIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def untagStream(
    request: UntagStreamRequest
  ): KinesisVideoIO[UntagStreamResponse] =
    FF.liftF(UntagStreamOp(request))

  def updateDataRetention(
    request: UpdateDataRetentionRequest
  ): KinesisVideoIO[UpdateDataRetentionResponse] =
    FF.liftF(UpdateDataRetentionOp(request))

  def updateSignalingChannel(
    request: UpdateSignalingChannelRequest
  ): KinesisVideoIO[UpdateSignalingChannelResponse] =
    FF.liftF(UpdateSignalingChannelOp(request))

  def updateStream(
    request: UpdateStreamRequest
  ): KinesisVideoIO[UpdateStreamResponse] =
    FF.liftF(UpdateStreamOp(request))
}
