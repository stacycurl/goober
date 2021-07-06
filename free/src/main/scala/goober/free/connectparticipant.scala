package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.connectparticipant.ConnectParticipantClient
import software.amazon.awssdk.services.connectparticipant.model._


object connectparticipant { module =>

  // Free monad over ConnectParticipantOp
  type ConnectParticipantIO[A] = FF[ConnectParticipantOp, A]

  sealed trait ConnectParticipantOp[A] {
    def visit[F[_]](visitor: ConnectParticipantOp.Visitor[F]): F[A]
  }

  object ConnectParticipantOp {
    // Given a ConnectParticipantClient we can embed a ConnectParticipantIO program in any algebra that understands embedding.
    implicit val ConnectParticipantOpEmbeddable: Embeddable[ConnectParticipantOp, ConnectParticipantClient] = new Embeddable[ConnectParticipantOp, ConnectParticipantClient] {
      def embed[A](client: ConnectParticipantClient, io: ConnectParticipantIO[A]): Embedded[A] = Embedded.ConnectParticipant(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ConnectParticipantOp.Visitor[Kleisli[M, ConnectParticipantClient, *]] {
        def completeAttachmentUpload(
          request: CompleteAttachmentUploadRequest
        ): Kleisli[M, ConnectParticipantClient, CompleteAttachmentUploadResponse] =
          primitive(_.completeAttachmentUpload(request))

        def createParticipantConnection(
          request: CreateParticipantConnectionRequest
        ): Kleisli[M, ConnectParticipantClient, CreateParticipantConnectionResponse] =
          primitive(_.createParticipantConnection(request))

        def disconnectParticipant(
          request: DisconnectParticipantRequest
        ): Kleisli[M, ConnectParticipantClient, DisconnectParticipantResponse] =
          primitive(_.disconnectParticipant(request))

        def getAttachment(
          request: GetAttachmentRequest
        ): Kleisli[M, ConnectParticipantClient, GetAttachmentResponse] =
          primitive(_.getAttachment(request))

        def getTranscript(
          request: GetTranscriptRequest
        ): Kleisli[M, ConnectParticipantClient, GetTranscriptResponse] =
          primitive(_.getTranscript(request))

        def sendEvent(
          request: SendEventRequest
        ): Kleisli[M, ConnectParticipantClient, SendEventResponse] =
          primitive(_.sendEvent(request))

        def sendMessage(
          request: SendMessageRequest
        ): Kleisli[M, ConnectParticipantClient, SendMessageResponse] =
          primitive(_.sendMessage(request))

        def startAttachmentUpload(
          request: StartAttachmentUploadRequest
        ): Kleisli[M, ConnectParticipantClient, StartAttachmentUploadResponse] =
          primitive(_.startAttachmentUpload(request))

        def primitive[A](
          f: ConnectParticipantClient => A
        ): Kleisli[M, ConnectParticipantClient, A]
      }
    }

    trait Visitor[F[_]] extends (ConnectParticipantOp ~> F) {
      final def apply[A](op: ConnectParticipantOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def completeAttachmentUpload(
        request: CompleteAttachmentUploadRequest
      ): F[CompleteAttachmentUploadResponse]

      def createParticipantConnection(
        request: CreateParticipantConnectionRequest
      ): F[CreateParticipantConnectionResponse]

      def disconnectParticipant(
        request: DisconnectParticipantRequest
      ): F[DisconnectParticipantResponse]

      def getAttachment(
        request: GetAttachmentRequest
      ): F[GetAttachmentResponse]

      def getTranscript(
        request: GetTranscriptRequest
      ): F[GetTranscriptResponse]

      def sendEvent(
        request: SendEventRequest
      ): F[SendEventResponse]

      def sendMessage(
        request: SendMessageRequest
      ): F[SendMessageResponse]

      def startAttachmentUpload(
        request: StartAttachmentUploadRequest
      ): F[StartAttachmentUploadResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ConnectParticipantOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CompleteAttachmentUploadOp(
      request: CompleteAttachmentUploadRequest
    ) extends ConnectParticipantOp[CompleteAttachmentUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteAttachmentUploadResponse] =
        visitor.completeAttachmentUpload(request)
    }

    final case class CreateParticipantConnectionOp(
      request: CreateParticipantConnectionRequest
    ) extends ConnectParticipantOp[CreateParticipantConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateParticipantConnectionResponse] =
        visitor.createParticipantConnection(request)
    }

    final case class DisconnectParticipantOp(
      request: DisconnectParticipantRequest
    ) extends ConnectParticipantOp[DisconnectParticipantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisconnectParticipantResponse] =
        visitor.disconnectParticipant(request)
    }

    final case class GetAttachmentOp(
      request: GetAttachmentRequest
    ) extends ConnectParticipantOp[GetAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAttachmentResponse] =
        visitor.getAttachment(request)
    }

    final case class GetTranscriptOp(
      request: GetTranscriptRequest
    ) extends ConnectParticipantOp[GetTranscriptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTranscriptResponse] =
        visitor.getTranscript(request)
    }

    final case class SendEventOp(
      request: SendEventRequest
    ) extends ConnectParticipantOp[SendEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendEventResponse] =
        visitor.sendEvent(request)
    }

    final case class SendMessageOp(
      request: SendMessageRequest
    ) extends ConnectParticipantOp[SendMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendMessageResponse] =
        visitor.sendMessage(request)
    }

    final case class StartAttachmentUploadOp(
      request: StartAttachmentUploadRequest
    ) extends ConnectParticipantOp[StartAttachmentUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAttachmentUploadResponse] =
        visitor.startAttachmentUpload(request)
    }
  }

  import ConnectParticipantOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ConnectParticipantOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def completeAttachmentUpload(
    request: CompleteAttachmentUploadRequest
  ): ConnectParticipantIO[CompleteAttachmentUploadResponse] =
    FF.liftF(CompleteAttachmentUploadOp(request))

  def createParticipantConnection(
    request: CreateParticipantConnectionRequest
  ): ConnectParticipantIO[CreateParticipantConnectionResponse] =
    FF.liftF(CreateParticipantConnectionOp(request))

  def disconnectParticipant(
    request: DisconnectParticipantRequest
  ): ConnectParticipantIO[DisconnectParticipantResponse] =
    FF.liftF(DisconnectParticipantOp(request))

  def getAttachment(
    request: GetAttachmentRequest
  ): ConnectParticipantIO[GetAttachmentResponse] =
    FF.liftF(GetAttachmentOp(request))

  def getTranscript(
    request: GetTranscriptRequest
  ): ConnectParticipantIO[GetTranscriptResponse] =
    FF.liftF(GetTranscriptOp(request))

  def sendEvent(
    request: SendEventRequest
  ): ConnectParticipantIO[SendEventResponse] =
    FF.liftF(SendEventOp(request))

  def sendMessage(
    request: SendMessageRequest
  ): ConnectParticipantIO[SendMessageResponse] =
    FF.liftF(SendMessageOp(request))

  def startAttachmentUpload(
    request: StartAttachmentUploadRequest
  ): ConnectParticipantIO[StartAttachmentUploadResponse] =
    FF.liftF(StartAttachmentUploadOp(request))
}
