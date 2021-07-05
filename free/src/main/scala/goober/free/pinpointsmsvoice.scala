package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.pinpointsmsvoice.PinpointSmsVoiceClient
import software.amazon.awssdk.services.pinpointsmsvoice.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object pinpointsmsvoice { module =>

  // Free monad over PinpointSmsVoiceOp
  type PinpointSmsVoiceIO[A] = FF[PinpointSmsVoiceOp, A]

  sealed trait PinpointSmsVoiceOp[A] {
    def visit[F[_]](visitor: PinpointSmsVoiceOp.Visitor[F]): F[A]
  }

  object PinpointSmsVoiceOp {
    // Given a PinpointSmsVoiceClient we can embed a PinpointSmsVoiceIO program in any algebra that understands embedding.
    implicit val PinpointSmsVoiceOpEmbeddable: Embeddable[PinpointSmsVoiceOp, PinpointSmsVoiceClient] = new Embeddable[PinpointSmsVoiceOp, PinpointSmsVoiceClient] {
      def embed[A](client: PinpointSmsVoiceClient, io: PinpointSmsVoiceIO[A]): Embedded[A] = Embedded.PinpointSmsVoice(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PinpointSmsVoiceOp.Visitor[Kleisli[M, PinpointSmsVoiceClient, *]] {
        def createConfigurationSet(
          request: CreateConfigurationSetRequest
        ): Kleisli[M, PinpointSmsVoiceClient, CreateConfigurationSetResponse] =
          primitive(_.createConfigurationSet(request))

        def createConfigurationSetEventDestination(
          request: CreateConfigurationSetEventDestinationRequest
        ): Kleisli[M, PinpointSmsVoiceClient, CreateConfigurationSetEventDestinationResponse] =
          primitive(_.createConfigurationSetEventDestination(request))

        def deleteConfigurationSet(
          request: DeleteConfigurationSetRequest
        ): Kleisli[M, PinpointSmsVoiceClient, DeleteConfigurationSetResponse] =
          primitive(_.deleteConfigurationSet(request))

        def deleteConfigurationSetEventDestination(
          request: DeleteConfigurationSetEventDestinationRequest
        ): Kleisli[M, PinpointSmsVoiceClient, DeleteConfigurationSetEventDestinationResponse] =
          primitive(_.deleteConfigurationSetEventDestination(request))

        def getConfigurationSetEventDestinations(
          request: GetConfigurationSetEventDestinationsRequest
        ): Kleisli[M, PinpointSmsVoiceClient, GetConfigurationSetEventDestinationsResponse] =
          primitive(_.getConfigurationSetEventDestinations(request))

        def listConfigurationSets(
          request: ListConfigurationSetsRequest
        ): Kleisli[M, PinpointSmsVoiceClient, ListConfigurationSetsResponse] =
          primitive(_.listConfigurationSets(request))

        def sendVoiceMessage(
          request: SendVoiceMessageRequest
        ): Kleisli[M, PinpointSmsVoiceClient, SendVoiceMessageResponse] =
          primitive(_.sendVoiceMessage(request))

        def updateConfigurationSetEventDestination(
          request: UpdateConfigurationSetEventDestinationRequest
        ): Kleisli[M, PinpointSmsVoiceClient, UpdateConfigurationSetEventDestinationResponse] =
          primitive(_.updateConfigurationSetEventDestination(request))

        def primitive[A](
          f: PinpointSmsVoiceClient => A
        ): Kleisli[M, PinpointSmsVoiceClient, A]
      }
    }

    trait Visitor[F[_]] extends (PinpointSmsVoiceOp ~> F) {
      final def apply[A](op: PinpointSmsVoiceOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createConfigurationSet(
        request: CreateConfigurationSetRequest
      ): F[CreateConfigurationSetResponse]

      def createConfigurationSetEventDestination(
        request: CreateConfigurationSetEventDestinationRequest
      ): F[CreateConfigurationSetEventDestinationResponse]

      def deleteConfigurationSet(
        request: DeleteConfigurationSetRequest
      ): F[DeleteConfigurationSetResponse]

      def deleteConfigurationSetEventDestination(
        request: DeleteConfigurationSetEventDestinationRequest
      ): F[DeleteConfigurationSetEventDestinationResponse]

      def getConfigurationSetEventDestinations(
        request: GetConfigurationSetEventDestinationsRequest
      ): F[GetConfigurationSetEventDestinationsResponse]

      def listConfigurationSets(
        request: ListConfigurationSetsRequest
      ): F[ListConfigurationSetsResponse]

      def sendVoiceMessage(
        request: SendVoiceMessageRequest
      ): F[SendVoiceMessageResponse]

      def updateConfigurationSetEventDestination(
        request: UpdateConfigurationSetEventDestinationRequest
      ): F[UpdateConfigurationSetEventDestinationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PinpointSmsVoiceOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateConfigurationSetOp(
      request: CreateConfigurationSetRequest
    ) extends PinpointSmsVoiceOp[CreateConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetResponse] =
        visitor.createConfigurationSet(request)
    }

    final case class CreateConfigurationSetEventDestinationOp(
      request: CreateConfigurationSetEventDestinationRequest
    ) extends PinpointSmsVoiceOp[CreateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetEventDestinationResponse] =
        visitor.createConfigurationSetEventDestination(request)
    }

    final case class DeleteConfigurationSetOp(
      request: DeleteConfigurationSetRequest
    ) extends PinpointSmsVoiceOp[DeleteConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetResponse] =
        visitor.deleteConfigurationSet(request)
    }

    final case class DeleteConfigurationSetEventDestinationOp(
      request: DeleteConfigurationSetEventDestinationRequest
    ) extends PinpointSmsVoiceOp[DeleteConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetEventDestinationResponse] =
        visitor.deleteConfigurationSetEventDestination(request)
    }

    final case class GetConfigurationSetEventDestinationsOp(
      request: GetConfigurationSetEventDestinationsRequest
    ) extends PinpointSmsVoiceOp[GetConfigurationSetEventDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigurationSetEventDestinationsResponse] =
        visitor.getConfigurationSetEventDestinations(request)
    }

    final case class ListConfigurationSetsOp(
      request: ListConfigurationSetsRequest
    ) extends PinpointSmsVoiceOp[ListConfigurationSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationSetsResponse] =
        visitor.listConfigurationSets(request)
    }

    final case class SendVoiceMessageOp(
      request: SendVoiceMessageRequest
    ) extends PinpointSmsVoiceOp[SendVoiceMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendVoiceMessageResponse] =
        visitor.sendVoiceMessage(request)
    }

    final case class UpdateConfigurationSetEventDestinationOp(
      request: UpdateConfigurationSetEventDestinationRequest
    ) extends PinpointSmsVoiceOp[UpdateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationSetEventDestinationResponse] =
        visitor.updateConfigurationSetEventDestination(request)
    }
  }

  import PinpointSmsVoiceOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PinpointSmsVoiceOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createConfigurationSet(
    request: CreateConfigurationSetRequest
  ): PinpointSmsVoiceIO[CreateConfigurationSetResponse] =
    FF.liftF(CreateConfigurationSetOp(request))

  def createConfigurationSetEventDestination(
    request: CreateConfigurationSetEventDestinationRequest
  ): PinpointSmsVoiceIO[CreateConfigurationSetEventDestinationResponse] =
    FF.liftF(CreateConfigurationSetEventDestinationOp(request))

  def deleteConfigurationSet(
    request: DeleteConfigurationSetRequest
  ): PinpointSmsVoiceIO[DeleteConfigurationSetResponse] =
    FF.liftF(DeleteConfigurationSetOp(request))

  def deleteConfigurationSetEventDestination(
    request: DeleteConfigurationSetEventDestinationRequest
  ): PinpointSmsVoiceIO[DeleteConfigurationSetEventDestinationResponse] =
    FF.liftF(DeleteConfigurationSetEventDestinationOp(request))

  def getConfigurationSetEventDestinations(
    request: GetConfigurationSetEventDestinationsRequest
  ): PinpointSmsVoiceIO[GetConfigurationSetEventDestinationsResponse] =
    FF.liftF(GetConfigurationSetEventDestinationsOp(request))

  def listConfigurationSets(
    request: ListConfigurationSetsRequest
  ): PinpointSmsVoiceIO[ListConfigurationSetsResponse] =
    FF.liftF(ListConfigurationSetsOp(request))

  def sendVoiceMessage(
    request: SendVoiceMessageRequest
  ): PinpointSmsVoiceIO[SendVoiceMessageResponse] =
    FF.liftF(SendVoiceMessageOp(request))

  def updateConfigurationSetEventDestination(
    request: UpdateConfigurationSetEventDestinationRequest
  ): PinpointSmsVoiceIO[UpdateConfigurationSetEventDestinationResponse] =
    FF.liftF(UpdateConfigurationSetEventDestinationOp(request))
}
