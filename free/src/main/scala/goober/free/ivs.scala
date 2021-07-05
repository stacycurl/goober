package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ivs.IvsClient
import software.amazon.awssdk.services.ivs.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ivs { module =>

  // Free monad over IvsOp
  type IvsIO[A] = FF[IvsOp, A]

  sealed trait IvsOp[A] {
    def visit[F[_]](visitor: IvsOp.Visitor[F]): F[A]
  }

  object IvsOp {
    // Given a IvsClient we can embed a IvsIO program in any algebra that understands embedding.
    implicit val IvsOpEmbeddable: Embeddable[IvsOp, IvsClient] = new Embeddable[IvsOp, IvsClient] {
      def embed[A](client: IvsClient, io: IvsIO[A]): Embedded[A] = Embedded.Ivs(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IvsOp.Visitor[Kleisli[M, IvsClient, *]] {
        def batchGetChannel(
          request: BatchGetChannelRequest
        ): Kleisli[M, IvsClient, BatchGetChannelResponse] =
          primitive(_.batchGetChannel(request))

        def batchGetStreamKey(
          request: BatchGetStreamKeyRequest
        ): Kleisli[M, IvsClient, BatchGetStreamKeyResponse] =
          primitive(_.batchGetStreamKey(request))

        def createChannel(
          request: CreateChannelRequest
        ): Kleisli[M, IvsClient, CreateChannelResponse] =
          primitive(_.createChannel(request))

        def createRecordingConfiguration(
          request: CreateRecordingConfigurationRequest
        ): Kleisli[M, IvsClient, CreateRecordingConfigurationResponse] =
          primitive(_.createRecordingConfiguration(request))

        def createStreamKey(
          request: CreateStreamKeyRequest
        ): Kleisli[M, IvsClient, CreateStreamKeyResponse] =
          primitive(_.createStreamKey(request))

        def deleteChannel(
          request: DeleteChannelRequest
        ): Kleisli[M, IvsClient, DeleteChannelResponse] =
          primitive(_.deleteChannel(request))

        def deletePlaybackKeyPair(
          request: DeletePlaybackKeyPairRequest
        ): Kleisli[M, IvsClient, DeletePlaybackKeyPairResponse] =
          primitive(_.deletePlaybackKeyPair(request))

        def deleteRecordingConfiguration(
          request: DeleteRecordingConfigurationRequest
        ): Kleisli[M, IvsClient, DeleteRecordingConfigurationResponse] =
          primitive(_.deleteRecordingConfiguration(request))

        def deleteStreamKey(
          request: DeleteStreamKeyRequest
        ): Kleisli[M, IvsClient, DeleteStreamKeyResponse] =
          primitive(_.deleteStreamKey(request))

        def getChannel(
          request: GetChannelRequest
        ): Kleisli[M, IvsClient, GetChannelResponse] =
          primitive(_.getChannel(request))

        def getPlaybackKeyPair(
          request: GetPlaybackKeyPairRequest
        ): Kleisli[M, IvsClient, GetPlaybackKeyPairResponse] =
          primitive(_.getPlaybackKeyPair(request))

        def getRecordingConfiguration(
          request: GetRecordingConfigurationRequest
        ): Kleisli[M, IvsClient, GetRecordingConfigurationResponse] =
          primitive(_.getRecordingConfiguration(request))

        def getStream(
          request: GetStreamRequest
        ): Kleisli[M, IvsClient, GetStreamResponse] =
          primitive(_.getStream(request))

        def getStreamKey(
          request: GetStreamKeyRequest
        ): Kleisli[M, IvsClient, GetStreamKeyResponse] =
          primitive(_.getStreamKey(request))

        def importPlaybackKeyPair(
          request: ImportPlaybackKeyPairRequest
        ): Kleisli[M, IvsClient, ImportPlaybackKeyPairResponse] =
          primitive(_.importPlaybackKeyPair(request))

        def listChannels(
          request: ListChannelsRequest
        ): Kleisli[M, IvsClient, ListChannelsResponse] =
          primitive(_.listChannels(request))

        def listPlaybackKeyPairs(
          request: ListPlaybackKeyPairsRequest
        ): Kleisli[M, IvsClient, ListPlaybackKeyPairsResponse] =
          primitive(_.listPlaybackKeyPairs(request))

        def listRecordingConfigurations(
          request: ListRecordingConfigurationsRequest
        ): Kleisli[M, IvsClient, ListRecordingConfigurationsResponse] =
          primitive(_.listRecordingConfigurations(request))

        def listStreamKeys(
          request: ListStreamKeysRequest
        ): Kleisli[M, IvsClient, ListStreamKeysResponse] =
          primitive(_.listStreamKeys(request))

        def listStreams(
          request: ListStreamsRequest
        ): Kleisli[M, IvsClient, ListStreamsResponse] =
          primitive(_.listStreams(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IvsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putMetadata(
          request: PutMetadataRequest
        ): Kleisli[M, IvsClient, PutMetadataResponse] =
          primitive(_.putMetadata(request))

        def stopStream(
          request: StopStreamRequest
        ): Kleisli[M, IvsClient, StopStreamResponse] =
          primitive(_.stopStream(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IvsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IvsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateChannel(
          request: UpdateChannelRequest
        ): Kleisli[M, IvsClient, UpdateChannelResponse] =
          primitive(_.updateChannel(request))

        def primitive[A](
          f: IvsClient => A
        ): Kleisli[M, IvsClient, A]
      }
    }

    trait Visitor[F[_]] extends (IvsOp ~> F) {
      final def apply[A](op: IvsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchGetChannel(
        request: BatchGetChannelRequest
      ): F[BatchGetChannelResponse]

      def batchGetStreamKey(
        request: BatchGetStreamKeyRequest
      ): F[BatchGetStreamKeyResponse]

      def createChannel(
        request: CreateChannelRequest
      ): F[CreateChannelResponse]

      def createRecordingConfiguration(
        request: CreateRecordingConfigurationRequest
      ): F[CreateRecordingConfigurationResponse]

      def createStreamKey(
        request: CreateStreamKeyRequest
      ): F[CreateStreamKeyResponse]

      def deleteChannel(
        request: DeleteChannelRequest
      ): F[DeleteChannelResponse]

      def deletePlaybackKeyPair(
        request: DeletePlaybackKeyPairRequest
      ): F[DeletePlaybackKeyPairResponse]

      def deleteRecordingConfiguration(
        request: DeleteRecordingConfigurationRequest
      ): F[DeleteRecordingConfigurationResponse]

      def deleteStreamKey(
        request: DeleteStreamKeyRequest
      ): F[DeleteStreamKeyResponse]

      def getChannel(
        request: GetChannelRequest
      ): F[GetChannelResponse]

      def getPlaybackKeyPair(
        request: GetPlaybackKeyPairRequest
      ): F[GetPlaybackKeyPairResponse]

      def getRecordingConfiguration(
        request: GetRecordingConfigurationRequest
      ): F[GetRecordingConfigurationResponse]

      def getStream(
        request: GetStreamRequest
      ): F[GetStreamResponse]

      def getStreamKey(
        request: GetStreamKeyRequest
      ): F[GetStreamKeyResponse]

      def importPlaybackKeyPair(
        request: ImportPlaybackKeyPairRequest
      ): F[ImportPlaybackKeyPairResponse]

      def listChannels(
        request: ListChannelsRequest
      ): F[ListChannelsResponse]

      def listPlaybackKeyPairs(
        request: ListPlaybackKeyPairsRequest
      ): F[ListPlaybackKeyPairsResponse]

      def listRecordingConfigurations(
        request: ListRecordingConfigurationsRequest
      ): F[ListRecordingConfigurationsResponse]

      def listStreamKeys(
        request: ListStreamKeysRequest
      ): F[ListStreamKeysResponse]

      def listStreams(
        request: ListStreamsRequest
      ): F[ListStreamsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putMetadata(
        request: PutMetadataRequest
      ): F[PutMetadataResponse]

      def stopStream(
        request: StopStreamRequest
      ): F[StopStreamResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateChannel(
        request: UpdateChannelRequest
      ): F[UpdateChannelResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IvsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchGetChannelOp(
      request: BatchGetChannelRequest
    ) extends IvsOp[BatchGetChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetChannelResponse] =
        visitor.batchGetChannel(request)
    }

    final case class BatchGetStreamKeyOp(
      request: BatchGetStreamKeyRequest
    ) extends IvsOp[BatchGetStreamKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetStreamKeyResponse] =
        visitor.batchGetStreamKey(request)
    }

    final case class CreateChannelOp(
      request: CreateChannelRequest
    ) extends IvsOp[CreateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelResponse] =
        visitor.createChannel(request)
    }

    final case class CreateRecordingConfigurationOp(
      request: CreateRecordingConfigurationRequest
    ) extends IvsOp[CreateRecordingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRecordingConfigurationResponse] =
        visitor.createRecordingConfiguration(request)
    }

    final case class CreateStreamKeyOp(
      request: CreateStreamKeyRequest
    ) extends IvsOp[CreateStreamKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamKeyResponse] =
        visitor.createStreamKey(request)
    }

    final case class DeleteChannelOp(
      request: DeleteChannelRequest
    ) extends IvsOp[DeleteChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelResponse] =
        visitor.deleteChannel(request)
    }

    final case class DeletePlaybackKeyPairOp(
      request: DeletePlaybackKeyPairRequest
    ) extends IvsOp[DeletePlaybackKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePlaybackKeyPairResponse] =
        visitor.deletePlaybackKeyPair(request)
    }

    final case class DeleteRecordingConfigurationOp(
      request: DeleteRecordingConfigurationRequest
    ) extends IvsOp[DeleteRecordingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRecordingConfigurationResponse] =
        visitor.deleteRecordingConfiguration(request)
    }

    final case class DeleteStreamKeyOp(
      request: DeleteStreamKeyRequest
    ) extends IvsOp[DeleteStreamKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamKeyResponse] =
        visitor.deleteStreamKey(request)
    }

    final case class GetChannelOp(
      request: GetChannelRequest
    ) extends IvsOp[GetChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChannelResponse] =
        visitor.getChannel(request)
    }

    final case class GetPlaybackKeyPairOp(
      request: GetPlaybackKeyPairRequest
    ) extends IvsOp[GetPlaybackKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPlaybackKeyPairResponse] =
        visitor.getPlaybackKeyPair(request)
    }

    final case class GetRecordingConfigurationOp(
      request: GetRecordingConfigurationRequest
    ) extends IvsOp[GetRecordingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecordingConfigurationResponse] =
        visitor.getRecordingConfiguration(request)
    }

    final case class GetStreamOp(
      request: GetStreamRequest
    ) extends IvsOp[GetStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStreamResponse] =
        visitor.getStream(request)
    }

    final case class GetStreamKeyOp(
      request: GetStreamKeyRequest
    ) extends IvsOp[GetStreamKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStreamKeyResponse] =
        visitor.getStreamKey(request)
    }

    final case class ImportPlaybackKeyPairOp(
      request: ImportPlaybackKeyPairRequest
    ) extends IvsOp[ImportPlaybackKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportPlaybackKeyPairResponse] =
        visitor.importPlaybackKeyPair(request)
    }

    final case class ListChannelsOp(
      request: ListChannelsRequest
    ) extends IvsOp[ListChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelsResponse] =
        visitor.listChannels(request)
    }

    final case class ListPlaybackKeyPairsOp(
      request: ListPlaybackKeyPairsRequest
    ) extends IvsOp[ListPlaybackKeyPairsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPlaybackKeyPairsResponse] =
        visitor.listPlaybackKeyPairs(request)
    }

    final case class ListRecordingConfigurationsOp(
      request: ListRecordingConfigurationsRequest
    ) extends IvsOp[ListRecordingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecordingConfigurationsResponse] =
        visitor.listRecordingConfigurations(request)
    }

    final case class ListStreamKeysOp(
      request: ListStreamKeysRequest
    ) extends IvsOp[ListStreamKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamKeysResponse] =
        visitor.listStreamKeys(request)
    }

    final case class ListStreamsOp(
      request: ListStreamsRequest
    ) extends IvsOp[ListStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamsResponse] =
        visitor.listStreams(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IvsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutMetadataOp(
      request: PutMetadataRequest
    ) extends IvsOp[PutMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMetadataResponse] =
        visitor.putMetadata(request)
    }

    final case class StopStreamOp(
      request: StopStreamRequest
    ) extends IvsOp[StopStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopStreamResponse] =
        visitor.stopStream(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IvsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IvsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateChannelOp(
      request: UpdateChannelRequest
    ) extends IvsOp[UpdateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelResponse] =
        visitor.updateChannel(request)
    }
  }

  import IvsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IvsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchGetChannel(
    request: BatchGetChannelRequest
  ): IvsIO[BatchGetChannelResponse] =
    FF.liftF(BatchGetChannelOp(request))

  def batchGetStreamKey(
    request: BatchGetStreamKeyRequest
  ): IvsIO[BatchGetStreamKeyResponse] =
    FF.liftF(BatchGetStreamKeyOp(request))

  def createChannel(
    request: CreateChannelRequest
  ): IvsIO[CreateChannelResponse] =
    FF.liftF(CreateChannelOp(request))

  def createRecordingConfiguration(
    request: CreateRecordingConfigurationRequest
  ): IvsIO[CreateRecordingConfigurationResponse] =
    FF.liftF(CreateRecordingConfigurationOp(request))

  def createStreamKey(
    request: CreateStreamKeyRequest
  ): IvsIO[CreateStreamKeyResponse] =
    FF.liftF(CreateStreamKeyOp(request))

  def deleteChannel(
    request: DeleteChannelRequest
  ): IvsIO[DeleteChannelResponse] =
    FF.liftF(DeleteChannelOp(request))

  def deletePlaybackKeyPair(
    request: DeletePlaybackKeyPairRequest
  ): IvsIO[DeletePlaybackKeyPairResponse] =
    FF.liftF(DeletePlaybackKeyPairOp(request))

  def deleteRecordingConfiguration(
    request: DeleteRecordingConfigurationRequest
  ): IvsIO[DeleteRecordingConfigurationResponse] =
    FF.liftF(DeleteRecordingConfigurationOp(request))

  def deleteStreamKey(
    request: DeleteStreamKeyRequest
  ): IvsIO[DeleteStreamKeyResponse] =
    FF.liftF(DeleteStreamKeyOp(request))

  def getChannel(
    request: GetChannelRequest
  ): IvsIO[GetChannelResponse] =
    FF.liftF(GetChannelOp(request))

  def getPlaybackKeyPair(
    request: GetPlaybackKeyPairRequest
  ): IvsIO[GetPlaybackKeyPairResponse] =
    FF.liftF(GetPlaybackKeyPairOp(request))

  def getRecordingConfiguration(
    request: GetRecordingConfigurationRequest
  ): IvsIO[GetRecordingConfigurationResponse] =
    FF.liftF(GetRecordingConfigurationOp(request))

  def getStream(
    request: GetStreamRequest
  ): IvsIO[GetStreamResponse] =
    FF.liftF(GetStreamOp(request))

  def getStreamKey(
    request: GetStreamKeyRequest
  ): IvsIO[GetStreamKeyResponse] =
    FF.liftF(GetStreamKeyOp(request))

  def importPlaybackKeyPair(
    request: ImportPlaybackKeyPairRequest
  ): IvsIO[ImportPlaybackKeyPairResponse] =
    FF.liftF(ImportPlaybackKeyPairOp(request))

  def listChannels(
    request: ListChannelsRequest
  ): IvsIO[ListChannelsResponse] =
    FF.liftF(ListChannelsOp(request))

  def listPlaybackKeyPairs(
    request: ListPlaybackKeyPairsRequest
  ): IvsIO[ListPlaybackKeyPairsResponse] =
    FF.liftF(ListPlaybackKeyPairsOp(request))

  def listRecordingConfigurations(
    request: ListRecordingConfigurationsRequest
  ): IvsIO[ListRecordingConfigurationsResponse] =
    FF.liftF(ListRecordingConfigurationsOp(request))

  def listStreamKeys(
    request: ListStreamKeysRequest
  ): IvsIO[ListStreamKeysResponse] =
    FF.liftF(ListStreamKeysOp(request))

  def listStreams(
    request: ListStreamsRequest
  ): IvsIO[ListStreamsResponse] =
    FF.liftF(ListStreamsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IvsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putMetadata(
    request: PutMetadataRequest
  ): IvsIO[PutMetadataResponse] =
    FF.liftF(PutMetadataOp(request))

  def stopStream(
    request: StopStreamRequest
  ): IvsIO[StopStreamResponse] =
    FF.liftF(StopStreamOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IvsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IvsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateChannel(
    request: UpdateChannelRequest
  ): IvsIO[UpdateChannelResponse] =
    FF.liftF(UpdateChannelOp(request))
}
