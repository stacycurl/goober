package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesis.KinesisClient
import software.amazon.awssdk.services.kinesis.model._


object kinesis { module =>

  // Free monad over KinesisOp
  type KinesisIO[A] = FF[KinesisOp, A]

  sealed trait KinesisOp[A] {
    def visit[F[_]](visitor: KinesisOp.Visitor[F]): F[A]
  }

  object KinesisOp {
    // Given a KinesisClient we can embed a KinesisIO program in any algebra that understands embedding.
    implicit val KinesisOpEmbeddable: Embeddable[KinesisOp, KinesisClient] = new Embeddable[KinesisOp, KinesisClient] {
      def embed[A](client: KinesisClient, io: KinesisIO[A]): Embedded[A] = Embedded.Kinesis(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KinesisOp.Visitor[Kleisli[M, KinesisClient, *]] {
        def addTagsToStream(
          request: AddTagsToStreamRequest
        ): Kleisli[M, KinesisClient, AddTagsToStreamResponse] =
          primitive(_.addTagsToStream(request))

        def createStream(
          request: CreateStreamRequest
        ): Kleisli[M, KinesisClient, CreateStreamResponse] =
          primitive(_.createStream(request))

        def decreaseStreamRetentionPeriod(
          request: DecreaseStreamRetentionPeriodRequest
        ): Kleisli[M, KinesisClient, DecreaseStreamRetentionPeriodResponse] =
          primitive(_.decreaseStreamRetentionPeriod(request))

        def deleteStream(
          request: DeleteStreamRequest
        ): Kleisli[M, KinesisClient, DeleteStreamResponse] =
          primitive(_.deleteStream(request))

        def deregisterStreamConsumer(
          request: DeregisterStreamConsumerRequest
        ): Kleisli[M, KinesisClient, DeregisterStreamConsumerResponse] =
          primitive(_.deregisterStreamConsumer(request))

        def describeLimits(
          request: DescribeLimitsRequest
        ): Kleisli[M, KinesisClient, DescribeLimitsResponse] =
          primitive(_.describeLimits(request))

        def describeStream(
          request: DescribeStreamRequest
        ): Kleisli[M, KinesisClient, DescribeStreamResponse] =
          primitive(_.describeStream(request))

        def describeStreamConsumer(
          request: DescribeStreamConsumerRequest
        ): Kleisli[M, KinesisClient, DescribeStreamConsumerResponse] =
          primitive(_.describeStreamConsumer(request))

        def describeStreamSummary(
          request: DescribeStreamSummaryRequest
        ): Kleisli[M, KinesisClient, DescribeStreamSummaryResponse] =
          primitive(_.describeStreamSummary(request))

        def disableEnhancedMonitoring(
          request: DisableEnhancedMonitoringRequest
        ): Kleisli[M, KinesisClient, DisableEnhancedMonitoringResponse] =
          primitive(_.disableEnhancedMonitoring(request))

        def enableEnhancedMonitoring(
          request: EnableEnhancedMonitoringRequest
        ): Kleisli[M, KinesisClient, EnableEnhancedMonitoringResponse] =
          primitive(_.enableEnhancedMonitoring(request))

        def getRecords(
          request: GetRecordsRequest
        ): Kleisli[M, KinesisClient, GetRecordsResponse] =
          primitive(_.getRecords(request))

        def getShardIterator(
          request: GetShardIteratorRequest
        ): Kleisli[M, KinesisClient, GetShardIteratorResponse] =
          primitive(_.getShardIterator(request))

        def increaseStreamRetentionPeriod(
          request: IncreaseStreamRetentionPeriodRequest
        ): Kleisli[M, KinesisClient, IncreaseStreamRetentionPeriodResponse] =
          primitive(_.increaseStreamRetentionPeriod(request))

        def listShards(
          request: ListShardsRequest
        ): Kleisli[M, KinesisClient, ListShardsResponse] =
          primitive(_.listShards(request))

        def listStreamConsumers(
          request: ListStreamConsumersRequest
        ): Kleisli[M, KinesisClient, ListStreamConsumersResponse] =
          primitive(_.listStreamConsumers(request))

        def listStreams(
          request: ListStreamsRequest
        ): Kleisli[M, KinesisClient, ListStreamsResponse] =
          primitive(_.listStreams(request))

        def listTagsForStream(
          request: ListTagsForStreamRequest
        ): Kleisli[M, KinesisClient, ListTagsForStreamResponse] =
          primitive(_.listTagsForStream(request))

        def mergeShards(
          request: MergeShardsRequest
        ): Kleisli[M, KinesisClient, MergeShardsResponse] =
          primitive(_.mergeShards(request))

        def putRecord(
          request: PutRecordRequest
        ): Kleisli[M, KinesisClient, PutRecordResponse] =
          primitive(_.putRecord(request))

        def putRecords(
          request: PutRecordsRequest
        ): Kleisli[M, KinesisClient, PutRecordsResponse] =
          primitive(_.putRecords(request))

        def registerStreamConsumer(
          request: RegisterStreamConsumerRequest
        ): Kleisli[M, KinesisClient, RegisterStreamConsumerResponse] =
          primitive(_.registerStreamConsumer(request))

        def removeTagsFromStream(
          request: RemoveTagsFromStreamRequest
        ): Kleisli[M, KinesisClient, RemoveTagsFromStreamResponse] =
          primitive(_.removeTagsFromStream(request))

        def splitShard(
          request: SplitShardRequest
        ): Kleisli[M, KinesisClient, SplitShardResponse] =
          primitive(_.splitShard(request))

        def startStreamEncryption(
          request: StartStreamEncryptionRequest
        ): Kleisli[M, KinesisClient, StartStreamEncryptionResponse] =
          primitive(_.startStreamEncryption(request))

        def stopStreamEncryption(
          request: StopStreamEncryptionRequest
        ): Kleisli[M, KinesisClient, StopStreamEncryptionResponse] =
          primitive(_.stopStreamEncryption(request))

        def updateShardCount(
          request: UpdateShardCountRequest
        ): Kleisli[M, KinesisClient, UpdateShardCountResponse] =
          primitive(_.updateShardCount(request))

        def primitive[A](
          f: KinesisClient => A
        ): Kleisli[M, KinesisClient, A]
      }
    }

    trait Visitor[F[_]] extends (KinesisOp ~> F) {
      final def apply[A](op: KinesisOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTagsToStream(
        request: AddTagsToStreamRequest
      ): F[AddTagsToStreamResponse]

      def createStream(
        request: CreateStreamRequest
      ): F[CreateStreamResponse]

      def decreaseStreamRetentionPeriod(
        request: DecreaseStreamRetentionPeriodRequest
      ): F[DecreaseStreamRetentionPeriodResponse]

      def deleteStream(
        request: DeleteStreamRequest
      ): F[DeleteStreamResponse]

      def deregisterStreamConsumer(
        request: DeregisterStreamConsumerRequest
      ): F[DeregisterStreamConsumerResponse]

      def describeLimits(
        request: DescribeLimitsRequest
      ): F[DescribeLimitsResponse]

      def describeStream(
        request: DescribeStreamRequest
      ): F[DescribeStreamResponse]

      def describeStreamConsumer(
        request: DescribeStreamConsumerRequest
      ): F[DescribeStreamConsumerResponse]

      def describeStreamSummary(
        request: DescribeStreamSummaryRequest
      ): F[DescribeStreamSummaryResponse]

      def disableEnhancedMonitoring(
        request: DisableEnhancedMonitoringRequest
      ): F[DisableEnhancedMonitoringResponse]

      def enableEnhancedMonitoring(
        request: EnableEnhancedMonitoringRequest
      ): F[EnableEnhancedMonitoringResponse]

      def getRecords(
        request: GetRecordsRequest
      ): F[GetRecordsResponse]

      def getShardIterator(
        request: GetShardIteratorRequest
      ): F[GetShardIteratorResponse]

      def increaseStreamRetentionPeriod(
        request: IncreaseStreamRetentionPeriodRequest
      ): F[IncreaseStreamRetentionPeriodResponse]

      def listShards(
        request: ListShardsRequest
      ): F[ListShardsResponse]

      def listStreamConsumers(
        request: ListStreamConsumersRequest
      ): F[ListStreamConsumersResponse]

      def listStreams(
        request: ListStreamsRequest
      ): F[ListStreamsResponse]

      def listTagsForStream(
        request: ListTagsForStreamRequest
      ): F[ListTagsForStreamResponse]

      def mergeShards(
        request: MergeShardsRequest
      ): F[MergeShardsResponse]

      def putRecord(
        request: PutRecordRequest
      ): F[PutRecordResponse]

      def putRecords(
        request: PutRecordsRequest
      ): F[PutRecordsResponse]

      def registerStreamConsumer(
        request: RegisterStreamConsumerRequest
      ): F[RegisterStreamConsumerResponse]

      def removeTagsFromStream(
        request: RemoveTagsFromStreamRequest
      ): F[RemoveTagsFromStreamResponse]

      def splitShard(
        request: SplitShardRequest
      ): F[SplitShardResponse]

      def startStreamEncryption(
        request: StartStreamEncryptionRequest
      ): F[StartStreamEncryptionResponse]

      def stopStreamEncryption(
        request: StopStreamEncryptionRequest
      ): F[StopStreamEncryptionResponse]

      def updateShardCount(
        request: UpdateShardCountRequest
      ): F[UpdateShardCountResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsToStreamOp(
      request: AddTagsToStreamRequest
    ) extends KinesisOp[AddTagsToStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToStreamResponse] =
        visitor.addTagsToStream(request)
    }

    final case class CreateStreamOp(
      request: CreateStreamRequest
    ) extends KinesisOp[CreateStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamResponse] =
        visitor.createStream(request)
    }

    final case class DecreaseStreamRetentionPeriodOp(
      request: DecreaseStreamRetentionPeriodRequest
    ) extends KinesisOp[DecreaseStreamRetentionPeriodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DecreaseStreamRetentionPeriodResponse] =
        visitor.decreaseStreamRetentionPeriod(request)
    }

    final case class DeleteStreamOp(
      request: DeleteStreamRequest
    ) extends KinesisOp[DeleteStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamResponse] =
        visitor.deleteStream(request)
    }

    final case class DeregisterStreamConsumerOp(
      request: DeregisterStreamConsumerRequest
    ) extends KinesisOp[DeregisterStreamConsumerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterStreamConsumerResponse] =
        visitor.deregisterStreamConsumer(request)
    }

    final case class DescribeLimitsOp(
      request: DescribeLimitsRequest
    ) extends KinesisOp[DescribeLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLimitsResponse] =
        visitor.describeLimits(request)
    }

    final case class DescribeStreamOp(
      request: DescribeStreamRequest
    ) extends KinesisOp[DescribeStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStreamResponse] =
        visitor.describeStream(request)
    }

    final case class DescribeStreamConsumerOp(
      request: DescribeStreamConsumerRequest
    ) extends KinesisOp[DescribeStreamConsumerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStreamConsumerResponse] =
        visitor.describeStreamConsumer(request)
    }

    final case class DescribeStreamSummaryOp(
      request: DescribeStreamSummaryRequest
    ) extends KinesisOp[DescribeStreamSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStreamSummaryResponse] =
        visitor.describeStreamSummary(request)
    }

    final case class DisableEnhancedMonitoringOp(
      request: DisableEnhancedMonitoringRequest
    ) extends KinesisOp[DisableEnhancedMonitoringResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableEnhancedMonitoringResponse] =
        visitor.disableEnhancedMonitoring(request)
    }

    final case class EnableEnhancedMonitoringOp(
      request: EnableEnhancedMonitoringRequest
    ) extends KinesisOp[EnableEnhancedMonitoringResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableEnhancedMonitoringResponse] =
        visitor.enableEnhancedMonitoring(request)
    }

    final case class GetRecordsOp(
      request: GetRecordsRequest
    ) extends KinesisOp[GetRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecordsResponse] =
        visitor.getRecords(request)
    }

    final case class GetShardIteratorOp(
      request: GetShardIteratorRequest
    ) extends KinesisOp[GetShardIteratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetShardIteratorResponse] =
        visitor.getShardIterator(request)
    }

    final case class IncreaseStreamRetentionPeriodOp(
      request: IncreaseStreamRetentionPeriodRequest
    ) extends KinesisOp[IncreaseStreamRetentionPeriodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IncreaseStreamRetentionPeriodResponse] =
        visitor.increaseStreamRetentionPeriod(request)
    }

    final case class ListShardsOp(
      request: ListShardsRequest
    ) extends KinesisOp[ListShardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListShardsResponse] =
        visitor.listShards(request)
    }

    final case class ListStreamConsumersOp(
      request: ListStreamConsumersRequest
    ) extends KinesisOp[ListStreamConsumersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamConsumersResponse] =
        visitor.listStreamConsumers(request)
    }

    final case class ListStreamsOp(
      request: ListStreamsRequest
    ) extends KinesisOp[ListStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamsResponse] =
        visitor.listStreams(request)
    }

    final case class ListTagsForStreamOp(
      request: ListTagsForStreamRequest
    ) extends KinesisOp[ListTagsForStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForStreamResponse] =
        visitor.listTagsForStream(request)
    }

    final case class MergeShardsOp(
      request: MergeShardsRequest
    ) extends KinesisOp[MergeShardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergeShardsResponse] =
        visitor.mergeShards(request)
    }

    final case class PutRecordOp(
      request: PutRecordRequest
    ) extends KinesisOp[PutRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRecordResponse] =
        visitor.putRecord(request)
    }

    final case class PutRecordsOp(
      request: PutRecordsRequest
    ) extends KinesisOp[PutRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRecordsResponse] =
        visitor.putRecords(request)
    }

    final case class RegisterStreamConsumerOp(
      request: RegisterStreamConsumerRequest
    ) extends KinesisOp[RegisterStreamConsumerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterStreamConsumerResponse] =
        visitor.registerStreamConsumer(request)
    }

    final case class RemoveTagsFromStreamOp(
      request: RemoveTagsFromStreamRequest
    ) extends KinesisOp[RemoveTagsFromStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromStreamResponse] =
        visitor.removeTagsFromStream(request)
    }

    final case class SplitShardOp(
      request: SplitShardRequest
    ) extends KinesisOp[SplitShardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SplitShardResponse] =
        visitor.splitShard(request)
    }

    final case class StartStreamEncryptionOp(
      request: StartStreamEncryptionRequest
    ) extends KinesisOp[StartStreamEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartStreamEncryptionResponse] =
        visitor.startStreamEncryption(request)
    }

    final case class StopStreamEncryptionOp(
      request: StopStreamEncryptionRequest
    ) extends KinesisOp[StopStreamEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopStreamEncryptionResponse] =
        visitor.stopStreamEncryption(request)
    }

    final case class UpdateShardCountOp(
      request: UpdateShardCountRequest
    ) extends KinesisOp[UpdateShardCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateShardCountResponse] =
        visitor.updateShardCount(request)
    }
  }

  import KinesisOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KinesisOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTagsToStream(
    request: AddTagsToStreamRequest
  ): KinesisIO[AddTagsToStreamResponse] =
    FF.liftF(AddTagsToStreamOp(request))

  def createStream(
    request: CreateStreamRequest
  ): KinesisIO[CreateStreamResponse] =
    FF.liftF(CreateStreamOp(request))

  def decreaseStreamRetentionPeriod(
    request: DecreaseStreamRetentionPeriodRequest
  ): KinesisIO[DecreaseStreamRetentionPeriodResponse] =
    FF.liftF(DecreaseStreamRetentionPeriodOp(request))

  def deleteStream(
    request: DeleteStreamRequest
  ): KinesisIO[DeleteStreamResponse] =
    FF.liftF(DeleteStreamOp(request))

  def deregisterStreamConsumer(
    request: DeregisterStreamConsumerRequest
  ): KinesisIO[DeregisterStreamConsumerResponse] =
    FF.liftF(DeregisterStreamConsumerOp(request))

  def describeLimits(
    request: DescribeLimitsRequest
  ): KinesisIO[DescribeLimitsResponse] =
    FF.liftF(DescribeLimitsOp(request))

  def describeStream(
    request: DescribeStreamRequest
  ): KinesisIO[DescribeStreamResponse] =
    FF.liftF(DescribeStreamOp(request))

  def describeStreamConsumer(
    request: DescribeStreamConsumerRequest
  ): KinesisIO[DescribeStreamConsumerResponse] =
    FF.liftF(DescribeStreamConsumerOp(request))

  def describeStreamSummary(
    request: DescribeStreamSummaryRequest
  ): KinesisIO[DescribeStreamSummaryResponse] =
    FF.liftF(DescribeStreamSummaryOp(request))

  def disableEnhancedMonitoring(
    request: DisableEnhancedMonitoringRequest
  ): KinesisIO[DisableEnhancedMonitoringResponse] =
    FF.liftF(DisableEnhancedMonitoringOp(request))

  def enableEnhancedMonitoring(
    request: EnableEnhancedMonitoringRequest
  ): KinesisIO[EnableEnhancedMonitoringResponse] =
    FF.liftF(EnableEnhancedMonitoringOp(request))

  def getRecords(
    request: GetRecordsRequest
  ): KinesisIO[GetRecordsResponse] =
    FF.liftF(GetRecordsOp(request))

  def getShardIterator(
    request: GetShardIteratorRequest
  ): KinesisIO[GetShardIteratorResponse] =
    FF.liftF(GetShardIteratorOp(request))

  def increaseStreamRetentionPeriod(
    request: IncreaseStreamRetentionPeriodRequest
  ): KinesisIO[IncreaseStreamRetentionPeriodResponse] =
    FF.liftF(IncreaseStreamRetentionPeriodOp(request))

  def listShards(
    request: ListShardsRequest
  ): KinesisIO[ListShardsResponse] =
    FF.liftF(ListShardsOp(request))

  def listStreamConsumers(
    request: ListStreamConsumersRequest
  ): KinesisIO[ListStreamConsumersResponse] =
    FF.liftF(ListStreamConsumersOp(request))

  def listStreams(
    request: ListStreamsRequest
  ): KinesisIO[ListStreamsResponse] =
    FF.liftF(ListStreamsOp(request))

  def listTagsForStream(
    request: ListTagsForStreamRequest
  ): KinesisIO[ListTagsForStreamResponse] =
    FF.liftF(ListTagsForStreamOp(request))

  def mergeShards(
    request: MergeShardsRequest
  ): KinesisIO[MergeShardsResponse] =
    FF.liftF(MergeShardsOp(request))

  def putRecord(
    request: PutRecordRequest
  ): KinesisIO[PutRecordResponse] =
    FF.liftF(PutRecordOp(request))

  def putRecords(
    request: PutRecordsRequest
  ): KinesisIO[PutRecordsResponse] =
    FF.liftF(PutRecordsOp(request))

  def registerStreamConsumer(
    request: RegisterStreamConsumerRequest
  ): KinesisIO[RegisterStreamConsumerResponse] =
    FF.liftF(RegisterStreamConsumerOp(request))

  def removeTagsFromStream(
    request: RemoveTagsFromStreamRequest
  ): KinesisIO[RemoveTagsFromStreamResponse] =
    FF.liftF(RemoveTagsFromStreamOp(request))

  def splitShard(
    request: SplitShardRequest
  ): KinesisIO[SplitShardResponse] =
    FF.liftF(SplitShardOp(request))

  def startStreamEncryption(
    request: StartStreamEncryptionRequest
  ): KinesisIO[StartStreamEncryptionResponse] =
    FF.liftF(StartStreamEncryptionOp(request))

  def stopStreamEncryption(
    request: StopStreamEncryptionRequest
  ): KinesisIO[StopStreamEncryptionResponse] =
    FF.liftF(StopStreamEncryptionOp(request))

  def updateShardCount(
    request: UpdateShardCountRequest
  ): KinesisIO[UpdateShardCountResponse] =
    FF.liftF(UpdateShardCountOp(request))
}
