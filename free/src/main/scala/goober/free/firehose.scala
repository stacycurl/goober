package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.firehose.FirehoseClient
import software.amazon.awssdk.services.firehose.model._


object firehose { module =>

  // Free monad over FirehoseOp
  type FirehoseIO[A] = FF[FirehoseOp, A]

  sealed trait FirehoseOp[A] {
    def visit[F[_]](visitor: FirehoseOp.Visitor[F]): F[A]
  }

  object FirehoseOp {
    // Given a FirehoseClient we can embed a FirehoseIO program in any algebra that understands embedding.
    implicit val FirehoseOpEmbeddable: Embeddable[FirehoseOp, FirehoseClient] = new Embeddable[FirehoseOp, FirehoseClient] {
      def embed[A](client: FirehoseClient, io: FirehoseIO[A]): Embedded[A] = Embedded.Firehose(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends FirehoseOp.Visitor[Kleisli[M, FirehoseClient, *]] {
        def createDeliveryStream(
          request: CreateDeliveryStreamRequest
        ): Kleisli[M, FirehoseClient, CreateDeliveryStreamResponse] =
          primitive(_.createDeliveryStream(request))

        def deleteDeliveryStream(
          request: DeleteDeliveryStreamRequest
        ): Kleisli[M, FirehoseClient, DeleteDeliveryStreamResponse] =
          primitive(_.deleteDeliveryStream(request))

        def describeDeliveryStream(
          request: DescribeDeliveryStreamRequest
        ): Kleisli[M, FirehoseClient, DescribeDeliveryStreamResponse] =
          primitive(_.describeDeliveryStream(request))

        def listDeliveryStreams(
          request: ListDeliveryStreamsRequest
        ): Kleisli[M, FirehoseClient, ListDeliveryStreamsResponse] =
          primitive(_.listDeliveryStreams(request))

        def listTagsForDeliveryStream(
          request: ListTagsForDeliveryStreamRequest
        ): Kleisli[M, FirehoseClient, ListTagsForDeliveryStreamResponse] =
          primitive(_.listTagsForDeliveryStream(request))

        def putRecord(
          request: PutRecordRequest
        ): Kleisli[M, FirehoseClient, PutRecordResponse] =
          primitive(_.putRecord(request))

        def putRecordBatch(
          request: PutRecordBatchRequest
        ): Kleisli[M, FirehoseClient, PutRecordBatchResponse] =
          primitive(_.putRecordBatch(request))

        def startDeliveryStreamEncryption(
          request: StartDeliveryStreamEncryptionRequest
        ): Kleisli[M, FirehoseClient, StartDeliveryStreamEncryptionResponse] =
          primitive(_.startDeliveryStreamEncryption(request))

        def stopDeliveryStreamEncryption(
          request: StopDeliveryStreamEncryptionRequest
        ): Kleisli[M, FirehoseClient, StopDeliveryStreamEncryptionResponse] =
          primitive(_.stopDeliveryStreamEncryption(request))

        def tagDeliveryStream(
          request: TagDeliveryStreamRequest
        ): Kleisli[M, FirehoseClient, TagDeliveryStreamResponse] =
          primitive(_.tagDeliveryStream(request))

        def untagDeliveryStream(
          request: UntagDeliveryStreamRequest
        ): Kleisli[M, FirehoseClient, UntagDeliveryStreamResponse] =
          primitive(_.untagDeliveryStream(request))

        def updateDestination(
          request: UpdateDestinationRequest
        ): Kleisli[M, FirehoseClient, UpdateDestinationResponse] =
          primitive(_.updateDestination(request))

        def primitive[A](
          f: FirehoseClient => A
        ): Kleisli[M, FirehoseClient, A]
      }
    }

    trait Visitor[F[_]] extends (FirehoseOp ~> F) {
      final def apply[A](op: FirehoseOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createDeliveryStream(
        request: CreateDeliveryStreamRequest
      ): F[CreateDeliveryStreamResponse]

      def deleteDeliveryStream(
        request: DeleteDeliveryStreamRequest
      ): F[DeleteDeliveryStreamResponse]

      def describeDeliveryStream(
        request: DescribeDeliveryStreamRequest
      ): F[DescribeDeliveryStreamResponse]

      def listDeliveryStreams(
        request: ListDeliveryStreamsRequest
      ): F[ListDeliveryStreamsResponse]

      def listTagsForDeliveryStream(
        request: ListTagsForDeliveryStreamRequest
      ): F[ListTagsForDeliveryStreamResponse]

      def putRecord(
        request: PutRecordRequest
      ): F[PutRecordResponse]

      def putRecordBatch(
        request: PutRecordBatchRequest
      ): F[PutRecordBatchResponse]

      def startDeliveryStreamEncryption(
        request: StartDeliveryStreamEncryptionRequest
      ): F[StartDeliveryStreamEncryptionResponse]

      def stopDeliveryStreamEncryption(
        request: StopDeliveryStreamEncryptionRequest
      ): F[StopDeliveryStreamEncryptionResponse]

      def tagDeliveryStream(
        request: TagDeliveryStreamRequest
      ): F[TagDeliveryStreamResponse]

      def untagDeliveryStream(
        request: UntagDeliveryStreamRequest
      ): F[UntagDeliveryStreamResponse]

      def updateDestination(
        request: UpdateDestinationRequest
      ): F[UpdateDestinationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends FirehoseOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateDeliveryStreamOp(
      request: CreateDeliveryStreamRequest
    ) extends FirehoseOp[CreateDeliveryStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeliveryStreamResponse] =
        visitor.createDeliveryStream(request)
    }

    final case class DeleteDeliveryStreamOp(
      request: DeleteDeliveryStreamRequest
    ) extends FirehoseOp[DeleteDeliveryStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeliveryStreamResponse] =
        visitor.deleteDeliveryStream(request)
    }

    final case class DescribeDeliveryStreamOp(
      request: DescribeDeliveryStreamRequest
    ) extends FirehoseOp[DescribeDeliveryStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeliveryStreamResponse] =
        visitor.describeDeliveryStream(request)
    }

    final case class ListDeliveryStreamsOp(
      request: ListDeliveryStreamsRequest
    ) extends FirehoseOp[ListDeliveryStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeliveryStreamsResponse] =
        visitor.listDeliveryStreams(request)
    }

    final case class ListTagsForDeliveryStreamOp(
      request: ListTagsForDeliveryStreamRequest
    ) extends FirehoseOp[ListTagsForDeliveryStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForDeliveryStreamResponse] =
        visitor.listTagsForDeliveryStream(request)
    }

    final case class PutRecordOp(
      request: PutRecordRequest
    ) extends FirehoseOp[PutRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRecordResponse] =
        visitor.putRecord(request)
    }

    final case class PutRecordBatchOp(
      request: PutRecordBatchRequest
    ) extends FirehoseOp[PutRecordBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRecordBatchResponse] =
        visitor.putRecordBatch(request)
    }

    final case class StartDeliveryStreamEncryptionOp(
      request: StartDeliveryStreamEncryptionRequest
    ) extends FirehoseOp[StartDeliveryStreamEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDeliveryStreamEncryptionResponse] =
        visitor.startDeliveryStreamEncryption(request)
    }

    final case class StopDeliveryStreamEncryptionOp(
      request: StopDeliveryStreamEncryptionRequest
    ) extends FirehoseOp[StopDeliveryStreamEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDeliveryStreamEncryptionResponse] =
        visitor.stopDeliveryStreamEncryption(request)
    }

    final case class TagDeliveryStreamOp(
      request: TagDeliveryStreamRequest
    ) extends FirehoseOp[TagDeliveryStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagDeliveryStreamResponse] =
        visitor.tagDeliveryStream(request)
    }

    final case class UntagDeliveryStreamOp(
      request: UntagDeliveryStreamRequest
    ) extends FirehoseOp[UntagDeliveryStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagDeliveryStreamResponse] =
        visitor.untagDeliveryStream(request)
    }

    final case class UpdateDestinationOp(
      request: UpdateDestinationRequest
    ) extends FirehoseOp[UpdateDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDestinationResponse] =
        visitor.updateDestination(request)
    }
  }

  import FirehoseOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[FirehoseOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createDeliveryStream(
    request: CreateDeliveryStreamRequest
  ): FirehoseIO[CreateDeliveryStreamResponse] =
    FF.liftF(CreateDeliveryStreamOp(request))

  def deleteDeliveryStream(
    request: DeleteDeliveryStreamRequest
  ): FirehoseIO[DeleteDeliveryStreamResponse] =
    FF.liftF(DeleteDeliveryStreamOp(request))

  def describeDeliveryStream(
    request: DescribeDeliveryStreamRequest
  ): FirehoseIO[DescribeDeliveryStreamResponse] =
    FF.liftF(DescribeDeliveryStreamOp(request))

  def listDeliveryStreams(
    request: ListDeliveryStreamsRequest
  ): FirehoseIO[ListDeliveryStreamsResponse] =
    FF.liftF(ListDeliveryStreamsOp(request))

  def listTagsForDeliveryStream(
    request: ListTagsForDeliveryStreamRequest
  ): FirehoseIO[ListTagsForDeliveryStreamResponse] =
    FF.liftF(ListTagsForDeliveryStreamOp(request))

  def putRecord(
    request: PutRecordRequest
  ): FirehoseIO[PutRecordResponse] =
    FF.liftF(PutRecordOp(request))

  def putRecordBatch(
    request: PutRecordBatchRequest
  ): FirehoseIO[PutRecordBatchResponse] =
    FF.liftF(PutRecordBatchOp(request))

  def startDeliveryStreamEncryption(
    request: StartDeliveryStreamEncryptionRequest
  ): FirehoseIO[StartDeliveryStreamEncryptionResponse] =
    FF.liftF(StartDeliveryStreamEncryptionOp(request))

  def stopDeliveryStreamEncryption(
    request: StopDeliveryStreamEncryptionRequest
  ): FirehoseIO[StopDeliveryStreamEncryptionResponse] =
    FF.liftF(StopDeliveryStreamEncryptionOp(request))

  def tagDeliveryStream(
    request: TagDeliveryStreamRequest
  ): FirehoseIO[TagDeliveryStreamResponse] =
    FF.liftF(TagDeliveryStreamOp(request))

  def untagDeliveryStream(
    request: UntagDeliveryStreamRequest
  ): FirehoseIO[UntagDeliveryStreamResponse] =
    FF.liftF(UntagDeliveryStreamOp(request))

  def updateDestination(
    request: UpdateDestinationRequest
  ): FirehoseIO[UpdateDestinationResponse] =
    FF.liftF(UpdateDestinationOp(request))
}
