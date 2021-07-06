package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model._


object sqs { module =>

  // Free monad over SqsOp
  type SqsIO[A] = FF[SqsOp, A]

  sealed trait SqsOp[A] {
    def visit[F[_]](visitor: SqsOp.Visitor[F]): F[A]
  }

  object SqsOp {
    // Given a SqsClient we can embed a SqsIO program in any algebra that understands embedding.
    implicit val SqsOpEmbeddable: Embeddable[SqsOp, SqsClient] = new Embeddable[SqsOp, SqsClient] {
      def embed[A](client: SqsClient, io: SqsIO[A]): Embedded[A] = Embedded.Sqs(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SqsOp.Visitor[Kleisli[M, SqsClient, *]] {
        def addPermission(
          request: AddPermissionRequest
        ): Kleisli[M, SqsClient, AddPermissionResponse] =
          primitive(_.addPermission(request))

        def changeMessageVisibility(
          request: ChangeMessageVisibilityRequest
        ): Kleisli[M, SqsClient, ChangeMessageVisibilityResponse] =
          primitive(_.changeMessageVisibility(request))

        def changeMessageVisibilityBatch(
          request: ChangeMessageVisibilityBatchRequest
        ): Kleisli[M, SqsClient, ChangeMessageVisibilityBatchResponse] =
          primitive(_.changeMessageVisibilityBatch(request))

        def createQueue(
          request: CreateQueueRequest
        ): Kleisli[M, SqsClient, CreateQueueResponse] =
          primitive(_.createQueue(request))

        def deleteMessage(
          request: DeleteMessageRequest
        ): Kleisli[M, SqsClient, DeleteMessageResponse] =
          primitive(_.deleteMessage(request))

        def deleteMessageBatch(
          request: DeleteMessageBatchRequest
        ): Kleisli[M, SqsClient, DeleteMessageBatchResponse] =
          primitive(_.deleteMessageBatch(request))

        def deleteQueue(
          request: DeleteQueueRequest
        ): Kleisli[M, SqsClient, DeleteQueueResponse] =
          primitive(_.deleteQueue(request))

        def getQueueAttributes(
          request: GetQueueAttributesRequest
        ): Kleisli[M, SqsClient, GetQueueAttributesResponse] =
          primitive(_.getQueueAttributes(request))

        def getQueueUrl(
          request: GetQueueUrlRequest
        ): Kleisli[M, SqsClient, GetQueueUrlResponse] =
          primitive(_.getQueueUrl(request))

        def listDeadLetterSourceQueues(
          request: ListDeadLetterSourceQueuesRequest
        ): Kleisli[M, SqsClient, ListDeadLetterSourceQueuesResponse] =
          primitive(_.listDeadLetterSourceQueues(request))

        def listQueueTags(
          request: ListQueueTagsRequest
        ): Kleisli[M, SqsClient, ListQueueTagsResponse] =
          primitive(_.listQueueTags(request))

        def listQueues(
          request: ListQueuesRequest
        ): Kleisli[M, SqsClient, ListQueuesResponse] =
          primitive(_.listQueues(request))

        def purgeQueue(
          request: PurgeQueueRequest
        ): Kleisli[M, SqsClient, PurgeQueueResponse] =
          primitive(_.purgeQueue(request))

        def receiveMessage(
          request: ReceiveMessageRequest
        ): Kleisli[M, SqsClient, ReceiveMessageResponse] =
          primitive(_.receiveMessage(request))

        def removePermission(
          request: RemovePermissionRequest
        ): Kleisli[M, SqsClient, RemovePermissionResponse] =
          primitive(_.removePermission(request))

        def sendMessage(
          request: SendMessageRequest
        ): Kleisli[M, SqsClient, SendMessageResponse] =
          primitive(_.sendMessage(request))

        def sendMessageBatch(
          request: SendMessageBatchRequest
        ): Kleisli[M, SqsClient, SendMessageBatchResponse] =
          primitive(_.sendMessageBatch(request))

        def setQueueAttributes(
          request: SetQueueAttributesRequest
        ): Kleisli[M, SqsClient, SetQueueAttributesResponse] =
          primitive(_.setQueueAttributes(request))

        def tagQueue(
          request: TagQueueRequest
        ): Kleisli[M, SqsClient, TagQueueResponse] =
          primitive(_.tagQueue(request))

        def untagQueue(
          request: UntagQueueRequest
        ): Kleisli[M, SqsClient, UntagQueueResponse] =
          primitive(_.untagQueue(request))

        def primitive[A](
          f: SqsClient => A
        ): Kleisli[M, SqsClient, A]
      }
    }

    trait Visitor[F[_]] extends (SqsOp ~> F) {
      final def apply[A](op: SqsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addPermission(
        request: AddPermissionRequest
      ): F[AddPermissionResponse]

      def changeMessageVisibility(
        request: ChangeMessageVisibilityRequest
      ): F[ChangeMessageVisibilityResponse]

      def changeMessageVisibilityBatch(
        request: ChangeMessageVisibilityBatchRequest
      ): F[ChangeMessageVisibilityBatchResponse]

      def createQueue(
        request: CreateQueueRequest
      ): F[CreateQueueResponse]

      def deleteMessage(
        request: DeleteMessageRequest
      ): F[DeleteMessageResponse]

      def deleteMessageBatch(
        request: DeleteMessageBatchRequest
      ): F[DeleteMessageBatchResponse]

      def deleteQueue(
        request: DeleteQueueRequest
      ): F[DeleteQueueResponse]

      def getQueueAttributes(
        request: GetQueueAttributesRequest
      ): F[GetQueueAttributesResponse]

      def getQueueUrl(
        request: GetQueueUrlRequest
      ): F[GetQueueUrlResponse]

      def listDeadLetterSourceQueues(
        request: ListDeadLetterSourceQueuesRequest
      ): F[ListDeadLetterSourceQueuesResponse]

      def listQueueTags(
        request: ListQueueTagsRequest
      ): F[ListQueueTagsResponse]

      def listQueues(
        request: ListQueuesRequest
      ): F[ListQueuesResponse]

      def purgeQueue(
        request: PurgeQueueRequest
      ): F[PurgeQueueResponse]

      def receiveMessage(
        request: ReceiveMessageRequest
      ): F[ReceiveMessageResponse]

      def removePermission(
        request: RemovePermissionRequest
      ): F[RemovePermissionResponse]

      def sendMessage(
        request: SendMessageRequest
      ): F[SendMessageResponse]

      def sendMessageBatch(
        request: SendMessageBatchRequest
      ): F[SendMessageBatchResponse]

      def setQueueAttributes(
        request: SetQueueAttributesRequest
      ): F[SetQueueAttributesResponse]

      def tagQueue(
        request: TagQueueRequest
      ): F[TagQueueResponse]

      def untagQueue(
        request: UntagQueueRequest
      ): F[UntagQueueResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SqsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddPermissionOp(
      request: AddPermissionRequest
    ) extends SqsOp[AddPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddPermissionResponse] =
        visitor.addPermission(request)
    }

    final case class ChangeMessageVisibilityOp(
      request: ChangeMessageVisibilityRequest
    ) extends SqsOp[ChangeMessageVisibilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ChangeMessageVisibilityResponse] =
        visitor.changeMessageVisibility(request)
    }

    final case class ChangeMessageVisibilityBatchOp(
      request: ChangeMessageVisibilityBatchRequest
    ) extends SqsOp[ChangeMessageVisibilityBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ChangeMessageVisibilityBatchResponse] =
        visitor.changeMessageVisibilityBatch(request)
    }

    final case class CreateQueueOp(
      request: CreateQueueRequest
    ) extends SqsOp[CreateQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQueueResponse] =
        visitor.createQueue(request)
    }

    final case class DeleteMessageOp(
      request: DeleteMessageRequest
    ) extends SqsOp[DeleteMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMessageResponse] =
        visitor.deleteMessage(request)
    }

    final case class DeleteMessageBatchOp(
      request: DeleteMessageBatchRequest
    ) extends SqsOp[DeleteMessageBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMessageBatchResponse] =
        visitor.deleteMessageBatch(request)
    }

    final case class DeleteQueueOp(
      request: DeleteQueueRequest
    ) extends SqsOp[DeleteQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQueueResponse] =
        visitor.deleteQueue(request)
    }

    final case class GetQueueAttributesOp(
      request: GetQueueAttributesRequest
    ) extends SqsOp[GetQueueAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQueueAttributesResponse] =
        visitor.getQueueAttributes(request)
    }

    final case class GetQueueUrlOp(
      request: GetQueueUrlRequest
    ) extends SqsOp[GetQueueUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQueueUrlResponse] =
        visitor.getQueueUrl(request)
    }

    final case class ListDeadLetterSourceQueuesOp(
      request: ListDeadLetterSourceQueuesRequest
    ) extends SqsOp[ListDeadLetterSourceQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeadLetterSourceQueuesResponse] =
        visitor.listDeadLetterSourceQueues(request)
    }

    final case class ListQueueTagsOp(
      request: ListQueueTagsRequest
    ) extends SqsOp[ListQueueTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQueueTagsResponse] =
        visitor.listQueueTags(request)
    }

    final case class ListQueuesOp(
      request: ListQueuesRequest
    ) extends SqsOp[ListQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQueuesResponse] =
        visitor.listQueues(request)
    }

    final case class PurgeQueueOp(
      request: PurgeQueueRequest
    ) extends SqsOp[PurgeQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurgeQueueResponse] =
        visitor.purgeQueue(request)
    }

    final case class ReceiveMessageOp(
      request: ReceiveMessageRequest
    ) extends SqsOp[ReceiveMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReceiveMessageResponse] =
        visitor.receiveMessage(request)
    }

    final case class RemovePermissionOp(
      request: RemovePermissionRequest
    ) extends SqsOp[RemovePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemovePermissionResponse] =
        visitor.removePermission(request)
    }

    final case class SendMessageOp(
      request: SendMessageRequest
    ) extends SqsOp[SendMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendMessageResponse] =
        visitor.sendMessage(request)
    }

    final case class SendMessageBatchOp(
      request: SendMessageBatchRequest
    ) extends SqsOp[SendMessageBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendMessageBatchResponse] =
        visitor.sendMessageBatch(request)
    }

    final case class SetQueueAttributesOp(
      request: SetQueueAttributesRequest
    ) extends SqsOp[SetQueueAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetQueueAttributesResponse] =
        visitor.setQueueAttributes(request)
    }

    final case class TagQueueOp(
      request: TagQueueRequest
    ) extends SqsOp[TagQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagQueueResponse] =
        visitor.tagQueue(request)
    }

    final case class UntagQueueOp(
      request: UntagQueueRequest
    ) extends SqsOp[UntagQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagQueueResponse] =
        visitor.untagQueue(request)
    }
  }

  import SqsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SqsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addPermission(
    request: AddPermissionRequest
  ): SqsIO[AddPermissionResponse] =
    FF.liftF(AddPermissionOp(request))

  def changeMessageVisibility(
    request: ChangeMessageVisibilityRequest
  ): SqsIO[ChangeMessageVisibilityResponse] =
    FF.liftF(ChangeMessageVisibilityOp(request))

  def changeMessageVisibilityBatch(
    request: ChangeMessageVisibilityBatchRequest
  ): SqsIO[ChangeMessageVisibilityBatchResponse] =
    FF.liftF(ChangeMessageVisibilityBatchOp(request))

  def createQueue(
    request: CreateQueueRequest
  ): SqsIO[CreateQueueResponse] =
    FF.liftF(CreateQueueOp(request))

  def deleteMessage(
    request: DeleteMessageRequest
  ): SqsIO[DeleteMessageResponse] =
    FF.liftF(DeleteMessageOp(request))

  def deleteMessageBatch(
    request: DeleteMessageBatchRequest
  ): SqsIO[DeleteMessageBatchResponse] =
    FF.liftF(DeleteMessageBatchOp(request))

  def deleteQueue(
    request: DeleteQueueRequest
  ): SqsIO[DeleteQueueResponse] =
    FF.liftF(DeleteQueueOp(request))

  def getQueueAttributes(
    request: GetQueueAttributesRequest
  ): SqsIO[GetQueueAttributesResponse] =
    FF.liftF(GetQueueAttributesOp(request))

  def getQueueUrl(
    request: GetQueueUrlRequest
  ): SqsIO[GetQueueUrlResponse] =
    FF.liftF(GetQueueUrlOp(request))

  def listDeadLetterSourceQueues(
    request: ListDeadLetterSourceQueuesRequest
  ): SqsIO[ListDeadLetterSourceQueuesResponse] =
    FF.liftF(ListDeadLetterSourceQueuesOp(request))

  def listQueueTags(
    request: ListQueueTagsRequest
  ): SqsIO[ListQueueTagsResponse] =
    FF.liftF(ListQueueTagsOp(request))

  def listQueues(
    request: ListQueuesRequest
  ): SqsIO[ListQueuesResponse] =
    FF.liftF(ListQueuesOp(request))

  def purgeQueue(
    request: PurgeQueueRequest
  ): SqsIO[PurgeQueueResponse] =
    FF.liftF(PurgeQueueOp(request))

  def receiveMessage(
    request: ReceiveMessageRequest
  ): SqsIO[ReceiveMessageResponse] =
    FF.liftF(ReceiveMessageOp(request))

  def removePermission(
    request: RemovePermissionRequest
  ): SqsIO[RemovePermissionResponse] =
    FF.liftF(RemovePermissionOp(request))

  def sendMessage(
    request: SendMessageRequest
  ): SqsIO[SendMessageResponse] =
    FF.liftF(SendMessageOp(request))

  def sendMessageBatch(
    request: SendMessageBatchRequest
  ): SqsIO[SendMessageBatchResponse] =
    FF.liftF(SendMessageBatchOp(request))

  def setQueueAttributes(
    request: SetQueueAttributesRequest
  ): SqsIO[SetQueueAttributesResponse] =
    FF.liftF(SetQueueAttributesOp(request))

  def tagQueue(
    request: TagQueueRequest
  ): SqsIO[TagQueueResponse] =
    FF.liftF(TagQueueOp(request))

  def untagQueue(
    request: UntagQueueRequest
  ): SqsIO[UntagQueueResponse] =
    FF.liftF(UntagQueueOp(request))
}
