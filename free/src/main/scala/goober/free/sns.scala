package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sns.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object sns { module =>

  // Free monad over SnsOp
  type SnsIO[A] = FF[SnsOp, A]

  sealed trait SnsOp[A] {
    def visit[F[_]](visitor: SnsOp.Visitor[F]): F[A]
  }

  object SnsOp {
    // Given a SnsClient we can embed a SnsIO program in any algebra that understands embedding.
    implicit val SnsOpEmbeddable: Embeddable[SnsOp, SnsClient] = new Embeddable[SnsOp, SnsClient] {
      def embed[A](client: SnsClient, io: SnsIO[A]): Embedded[A] = Embedded.Sns(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SnsOp.Visitor[Kleisli[M, SnsClient, *]] {
        def addPermission(
          request: AddPermissionRequest
        ): Kleisli[M, SnsClient, AddPermissionResponse] =
          primitive(_.addPermission(request))

        def checkIfPhoneNumberIsOptedOut(
          request: CheckIfPhoneNumberIsOptedOutRequest
        ): Kleisli[M, SnsClient, CheckIfPhoneNumberIsOptedOutResponse] =
          primitive(_.checkIfPhoneNumberIsOptedOut(request))

        def confirmSubscription(
          request: ConfirmSubscriptionRequest
        ): Kleisli[M, SnsClient, ConfirmSubscriptionResponse] =
          primitive(_.confirmSubscription(request))

        def createPlatformApplication(
          request: CreatePlatformApplicationRequest
        ): Kleisli[M, SnsClient, CreatePlatformApplicationResponse] =
          primitive(_.createPlatformApplication(request))

        def createPlatformEndpoint(
          request: CreatePlatformEndpointRequest
        ): Kleisli[M, SnsClient, CreatePlatformEndpointResponse] =
          primitive(_.createPlatformEndpoint(request))

        def createSMSSandboxPhoneNumber(
          request: CreateSmsSandboxPhoneNumberRequest
        ): Kleisli[M, SnsClient, CreateSmsSandboxPhoneNumberResponse] =
          primitive(_.createSMSSandboxPhoneNumber(request))

        def createTopic(
          request: CreateTopicRequest
        ): Kleisli[M, SnsClient, CreateTopicResponse] =
          primitive(_.createTopic(request))

        def deleteEndpoint(
          request: DeleteEndpointRequest
        ): Kleisli[M, SnsClient, DeleteEndpointResponse] =
          primitive(_.deleteEndpoint(request))

        def deletePlatformApplication(
          request: DeletePlatformApplicationRequest
        ): Kleisli[M, SnsClient, DeletePlatformApplicationResponse] =
          primitive(_.deletePlatformApplication(request))

        def deleteSMSSandboxPhoneNumber(
          request: DeleteSmsSandboxPhoneNumberRequest
        ): Kleisli[M, SnsClient, DeleteSmsSandboxPhoneNumberResponse] =
          primitive(_.deleteSMSSandboxPhoneNumber(request))

        def deleteTopic(
          request: DeleteTopicRequest
        ): Kleisli[M, SnsClient, DeleteTopicResponse] =
          primitive(_.deleteTopic(request))

        def getEndpointAttributes(
          request: GetEndpointAttributesRequest
        ): Kleisli[M, SnsClient, GetEndpointAttributesResponse] =
          primitive(_.getEndpointAttributes(request))

        def getPlatformApplicationAttributes(
          request: GetPlatformApplicationAttributesRequest
        ): Kleisli[M, SnsClient, GetPlatformApplicationAttributesResponse] =
          primitive(_.getPlatformApplicationAttributes(request))

        def getSMSAttributes(
          request: GetSmsAttributesRequest
        ): Kleisli[M, SnsClient, GetSmsAttributesResponse] =
          primitive(_.getSMSAttributes(request))

        def getSMSSandboxAccountStatus(
          request: GetSmsSandboxAccountStatusRequest
        ): Kleisli[M, SnsClient, GetSmsSandboxAccountStatusResponse] =
          primitive(_.getSMSSandboxAccountStatus(request))

        def getSubscriptionAttributes(
          request: GetSubscriptionAttributesRequest
        ): Kleisli[M, SnsClient, GetSubscriptionAttributesResponse] =
          primitive(_.getSubscriptionAttributes(request))

        def getTopicAttributes(
          request: GetTopicAttributesRequest
        ): Kleisli[M, SnsClient, GetTopicAttributesResponse] =
          primitive(_.getTopicAttributes(request))

        def listEndpointsByPlatformApplication(
          request: ListEndpointsByPlatformApplicationRequest
        ): Kleisli[M, SnsClient, ListEndpointsByPlatformApplicationResponse] =
          primitive(_.listEndpointsByPlatformApplication(request))

        def listOriginationNumbers(
          request: ListOriginationNumbersRequest
        ): Kleisli[M, SnsClient, ListOriginationNumbersResponse] =
          primitive(_.listOriginationNumbers(request))

        def listPhoneNumbersOptedOut(
          request: ListPhoneNumbersOptedOutRequest
        ): Kleisli[M, SnsClient, ListPhoneNumbersOptedOutResponse] =
          primitive(_.listPhoneNumbersOptedOut(request))

        def listPlatformApplications(
          request: ListPlatformApplicationsRequest
        ): Kleisli[M, SnsClient, ListPlatformApplicationsResponse] =
          primitive(_.listPlatformApplications(request))

        def listSMSSandboxPhoneNumbers(
          request: ListSmsSandboxPhoneNumbersRequest
        ): Kleisli[M, SnsClient, ListSmsSandboxPhoneNumbersResponse] =
          primitive(_.listSMSSandboxPhoneNumbers(request))

        def listSubscriptions(
          request: ListSubscriptionsRequest
        ): Kleisli[M, SnsClient, ListSubscriptionsResponse] =
          primitive(_.listSubscriptions(request))

        def listSubscriptionsByTopic(
          request: ListSubscriptionsByTopicRequest
        ): Kleisli[M, SnsClient, ListSubscriptionsByTopicResponse] =
          primitive(_.listSubscriptionsByTopic(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SnsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTopics(
          request: ListTopicsRequest
        ): Kleisli[M, SnsClient, ListTopicsResponse] =
          primitive(_.listTopics(request))

        def optInPhoneNumber(
          request: OptInPhoneNumberRequest
        ): Kleisli[M, SnsClient, OptInPhoneNumberResponse] =
          primitive(_.optInPhoneNumber(request))

        def publish(
          request: PublishRequest
        ): Kleisli[M, SnsClient, PublishResponse] =
          primitive(_.publish(request))

        def removePermission(
          request: RemovePermissionRequest
        ): Kleisli[M, SnsClient, RemovePermissionResponse] =
          primitive(_.removePermission(request))

        def setEndpointAttributes(
          request: SetEndpointAttributesRequest
        ): Kleisli[M, SnsClient, SetEndpointAttributesResponse] =
          primitive(_.setEndpointAttributes(request))

        def setPlatformApplicationAttributes(
          request: SetPlatformApplicationAttributesRequest
        ): Kleisli[M, SnsClient, SetPlatformApplicationAttributesResponse] =
          primitive(_.setPlatformApplicationAttributes(request))

        def setSMSAttributes(
          request: SetSmsAttributesRequest
        ): Kleisli[M, SnsClient, SetSmsAttributesResponse] =
          primitive(_.setSMSAttributes(request))

        def setSubscriptionAttributes(
          request: SetSubscriptionAttributesRequest
        ): Kleisli[M, SnsClient, SetSubscriptionAttributesResponse] =
          primitive(_.setSubscriptionAttributes(request))

        def setTopicAttributes(
          request: SetTopicAttributesRequest
        ): Kleisli[M, SnsClient, SetTopicAttributesResponse] =
          primitive(_.setTopicAttributes(request))

        def subscribe(
          request: SubscribeRequest
        ): Kleisli[M, SnsClient, SubscribeResponse] =
          primitive(_.subscribe(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SnsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def unsubscribe(
          request: UnsubscribeRequest
        ): Kleisli[M, SnsClient, UnsubscribeResponse] =
          primitive(_.unsubscribe(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SnsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def verifySMSSandboxPhoneNumber(
          request: VerifySmsSandboxPhoneNumberRequest
        ): Kleisli[M, SnsClient, VerifySmsSandboxPhoneNumberResponse] =
          primitive(_.verifySMSSandboxPhoneNumber(request))

        def primitive[A](
          f: SnsClient => A
        ): Kleisli[M, SnsClient, A]
      }
    }

    trait Visitor[F[_]] extends (SnsOp ~> F) {
      final def apply[A](op: SnsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addPermission(
        request: AddPermissionRequest
      ): F[AddPermissionResponse]

      def checkIfPhoneNumberIsOptedOut(
        request: CheckIfPhoneNumberIsOptedOutRequest
      ): F[CheckIfPhoneNumberIsOptedOutResponse]

      def confirmSubscription(
        request: ConfirmSubscriptionRequest
      ): F[ConfirmSubscriptionResponse]

      def createPlatformApplication(
        request: CreatePlatformApplicationRequest
      ): F[CreatePlatformApplicationResponse]

      def createPlatformEndpoint(
        request: CreatePlatformEndpointRequest
      ): F[CreatePlatformEndpointResponse]

      def createSMSSandboxPhoneNumber(
        request: CreateSmsSandboxPhoneNumberRequest
      ): F[CreateSmsSandboxPhoneNumberResponse]

      def createTopic(
        request: CreateTopicRequest
      ): F[CreateTopicResponse]

      def deleteEndpoint(
        request: DeleteEndpointRequest
      ): F[DeleteEndpointResponse]

      def deletePlatformApplication(
        request: DeletePlatformApplicationRequest
      ): F[DeletePlatformApplicationResponse]

      def deleteSMSSandboxPhoneNumber(
        request: DeleteSmsSandboxPhoneNumberRequest
      ): F[DeleteSmsSandboxPhoneNumberResponse]

      def deleteTopic(
        request: DeleteTopicRequest
      ): F[DeleteTopicResponse]

      def getEndpointAttributes(
        request: GetEndpointAttributesRequest
      ): F[GetEndpointAttributesResponse]

      def getPlatformApplicationAttributes(
        request: GetPlatformApplicationAttributesRequest
      ): F[GetPlatformApplicationAttributesResponse]

      def getSMSAttributes(
        request: GetSmsAttributesRequest
      ): F[GetSmsAttributesResponse]

      def getSMSSandboxAccountStatus(
        request: GetSmsSandboxAccountStatusRequest
      ): F[GetSmsSandboxAccountStatusResponse]

      def getSubscriptionAttributes(
        request: GetSubscriptionAttributesRequest
      ): F[GetSubscriptionAttributesResponse]

      def getTopicAttributes(
        request: GetTopicAttributesRequest
      ): F[GetTopicAttributesResponse]

      def listEndpointsByPlatformApplication(
        request: ListEndpointsByPlatformApplicationRequest
      ): F[ListEndpointsByPlatformApplicationResponse]

      def listOriginationNumbers(
        request: ListOriginationNumbersRequest
      ): F[ListOriginationNumbersResponse]

      def listPhoneNumbersOptedOut(
        request: ListPhoneNumbersOptedOutRequest
      ): F[ListPhoneNumbersOptedOutResponse]

      def listPlatformApplications(
        request: ListPlatformApplicationsRequest
      ): F[ListPlatformApplicationsResponse]

      def listSMSSandboxPhoneNumbers(
        request: ListSmsSandboxPhoneNumbersRequest
      ): F[ListSmsSandboxPhoneNumbersResponse]

      def listSubscriptions(
        request: ListSubscriptionsRequest
      ): F[ListSubscriptionsResponse]

      def listSubscriptionsByTopic(
        request: ListSubscriptionsByTopicRequest
      ): F[ListSubscriptionsByTopicResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTopics(
        request: ListTopicsRequest
      ): F[ListTopicsResponse]

      def optInPhoneNumber(
        request: OptInPhoneNumberRequest
      ): F[OptInPhoneNumberResponse]

      def publish(
        request: PublishRequest
      ): F[PublishResponse]

      def removePermission(
        request: RemovePermissionRequest
      ): F[RemovePermissionResponse]

      def setEndpointAttributes(
        request: SetEndpointAttributesRequest
      ): F[SetEndpointAttributesResponse]

      def setPlatformApplicationAttributes(
        request: SetPlatformApplicationAttributesRequest
      ): F[SetPlatformApplicationAttributesResponse]

      def setSMSAttributes(
        request: SetSmsAttributesRequest
      ): F[SetSmsAttributesResponse]

      def setSubscriptionAttributes(
        request: SetSubscriptionAttributesRequest
      ): F[SetSubscriptionAttributesResponse]

      def setTopicAttributes(
        request: SetTopicAttributesRequest
      ): F[SetTopicAttributesResponse]

      def subscribe(
        request: SubscribeRequest
      ): F[SubscribeResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def unsubscribe(
        request: UnsubscribeRequest
      ): F[UnsubscribeResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def verifySMSSandboxPhoneNumber(
        request: VerifySmsSandboxPhoneNumberRequest
      ): F[VerifySmsSandboxPhoneNumberResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SnsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddPermissionOp(
      request: AddPermissionRequest
    ) extends SnsOp[AddPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddPermissionResponse] =
        visitor.addPermission(request)
    }

    final case class CheckIfPhoneNumberIsOptedOutOp(
      request: CheckIfPhoneNumberIsOptedOutRequest
    ) extends SnsOp[CheckIfPhoneNumberIsOptedOutResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckIfPhoneNumberIsOptedOutResponse] =
        visitor.checkIfPhoneNumberIsOptedOut(request)
    }

    final case class ConfirmSubscriptionOp(
      request: ConfirmSubscriptionRequest
    ) extends SnsOp[ConfirmSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmSubscriptionResponse] =
        visitor.confirmSubscription(request)
    }

    final case class CreatePlatformApplicationOp(
      request: CreatePlatformApplicationRequest
    ) extends SnsOp[CreatePlatformApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlatformApplicationResponse] =
        visitor.createPlatformApplication(request)
    }

    final case class CreatePlatformEndpointOp(
      request: CreatePlatformEndpointRequest
    ) extends SnsOp[CreatePlatformEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlatformEndpointResponse] =
        visitor.createPlatformEndpoint(request)
    }

    final case class CreateSMSSandboxPhoneNumberOp(
      request: CreateSmsSandboxPhoneNumberRequest
    ) extends SnsOp[CreateSmsSandboxPhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSmsSandboxPhoneNumberResponse] =
        visitor.createSMSSandboxPhoneNumber(request)
    }

    final case class CreateTopicOp(
      request: CreateTopicRequest
    ) extends SnsOp[CreateTopicResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTopicResponse] =
        visitor.createTopic(request)
    }

    final case class DeleteEndpointOp(
      request: DeleteEndpointRequest
    ) extends SnsOp[DeleteEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointResponse] =
        visitor.deleteEndpoint(request)
    }

    final case class DeletePlatformApplicationOp(
      request: DeletePlatformApplicationRequest
    ) extends SnsOp[DeletePlatformApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePlatformApplicationResponse] =
        visitor.deletePlatformApplication(request)
    }

    final case class DeleteSMSSandboxPhoneNumberOp(
      request: DeleteSmsSandboxPhoneNumberRequest
    ) extends SnsOp[DeleteSmsSandboxPhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSmsSandboxPhoneNumberResponse] =
        visitor.deleteSMSSandboxPhoneNumber(request)
    }

    final case class DeleteTopicOp(
      request: DeleteTopicRequest
    ) extends SnsOp[DeleteTopicResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTopicResponse] =
        visitor.deleteTopic(request)
    }

    final case class GetEndpointAttributesOp(
      request: GetEndpointAttributesRequest
    ) extends SnsOp[GetEndpointAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEndpointAttributesResponse] =
        visitor.getEndpointAttributes(request)
    }

    final case class GetPlatformApplicationAttributesOp(
      request: GetPlatformApplicationAttributesRequest
    ) extends SnsOp[GetPlatformApplicationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPlatformApplicationAttributesResponse] =
        visitor.getPlatformApplicationAttributes(request)
    }

    final case class GetSMSAttributesOp(
      request: GetSmsAttributesRequest
    ) extends SnsOp[GetSmsAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSmsAttributesResponse] =
        visitor.getSMSAttributes(request)
    }

    final case class GetSMSSandboxAccountStatusOp(
      request: GetSmsSandboxAccountStatusRequest
    ) extends SnsOp[GetSmsSandboxAccountStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSmsSandboxAccountStatusResponse] =
        visitor.getSMSSandboxAccountStatus(request)
    }

    final case class GetSubscriptionAttributesOp(
      request: GetSubscriptionAttributesRequest
    ) extends SnsOp[GetSubscriptionAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSubscriptionAttributesResponse] =
        visitor.getSubscriptionAttributes(request)
    }

    final case class GetTopicAttributesOp(
      request: GetTopicAttributesRequest
    ) extends SnsOp[GetTopicAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTopicAttributesResponse] =
        visitor.getTopicAttributes(request)
    }

    final case class ListEndpointsByPlatformApplicationOp(
      request: ListEndpointsByPlatformApplicationRequest
    ) extends SnsOp[ListEndpointsByPlatformApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEndpointsByPlatformApplicationResponse] =
        visitor.listEndpointsByPlatformApplication(request)
    }

    final case class ListOriginationNumbersOp(
      request: ListOriginationNumbersRequest
    ) extends SnsOp[ListOriginationNumbersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOriginationNumbersResponse] =
        visitor.listOriginationNumbers(request)
    }

    final case class ListPhoneNumbersOptedOutOp(
      request: ListPhoneNumbersOptedOutRequest
    ) extends SnsOp[ListPhoneNumbersOptedOutResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPhoneNumbersOptedOutResponse] =
        visitor.listPhoneNumbersOptedOut(request)
    }

    final case class ListPlatformApplicationsOp(
      request: ListPlatformApplicationsRequest
    ) extends SnsOp[ListPlatformApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPlatformApplicationsResponse] =
        visitor.listPlatformApplications(request)
    }

    final case class ListSMSSandboxPhoneNumbersOp(
      request: ListSmsSandboxPhoneNumbersRequest
    ) extends SnsOp[ListSmsSandboxPhoneNumbersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSmsSandboxPhoneNumbersResponse] =
        visitor.listSMSSandboxPhoneNumbers(request)
    }

    final case class ListSubscriptionsOp(
      request: ListSubscriptionsRequest
    ) extends SnsOp[ListSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSubscriptionsResponse] =
        visitor.listSubscriptions(request)
    }

    final case class ListSubscriptionsByTopicOp(
      request: ListSubscriptionsByTopicRequest
    ) extends SnsOp[ListSubscriptionsByTopicResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSubscriptionsByTopicResponse] =
        visitor.listSubscriptionsByTopic(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SnsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTopicsOp(
      request: ListTopicsRequest
    ) extends SnsOp[ListTopicsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTopicsResponse] =
        visitor.listTopics(request)
    }

    final case class OptInPhoneNumberOp(
      request: OptInPhoneNumberRequest
    ) extends SnsOp[OptInPhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[OptInPhoneNumberResponse] =
        visitor.optInPhoneNumber(request)
    }

    final case class PublishOp(
      request: PublishRequest
    ) extends SnsOp[PublishResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishResponse] =
        visitor.publish(request)
    }

    final case class RemovePermissionOp(
      request: RemovePermissionRequest
    ) extends SnsOp[RemovePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemovePermissionResponse] =
        visitor.removePermission(request)
    }

    final case class SetEndpointAttributesOp(
      request: SetEndpointAttributesRequest
    ) extends SnsOp[SetEndpointAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetEndpointAttributesResponse] =
        visitor.setEndpointAttributes(request)
    }

    final case class SetPlatformApplicationAttributesOp(
      request: SetPlatformApplicationAttributesRequest
    ) extends SnsOp[SetPlatformApplicationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetPlatformApplicationAttributesResponse] =
        visitor.setPlatformApplicationAttributes(request)
    }

    final case class SetSMSAttributesOp(
      request: SetSmsAttributesRequest
    ) extends SnsOp[SetSmsAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetSmsAttributesResponse] =
        visitor.setSMSAttributes(request)
    }

    final case class SetSubscriptionAttributesOp(
      request: SetSubscriptionAttributesRequest
    ) extends SnsOp[SetSubscriptionAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetSubscriptionAttributesResponse] =
        visitor.setSubscriptionAttributes(request)
    }

    final case class SetTopicAttributesOp(
      request: SetTopicAttributesRequest
    ) extends SnsOp[SetTopicAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetTopicAttributesResponse] =
        visitor.setTopicAttributes(request)
    }

    final case class SubscribeOp(
      request: SubscribeRequest
    ) extends SnsOp[SubscribeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubscribeResponse] =
        visitor.subscribe(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SnsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UnsubscribeOp(
      request: UnsubscribeRequest
    ) extends SnsOp[UnsubscribeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnsubscribeResponse] =
        visitor.unsubscribe(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SnsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class VerifySMSSandboxPhoneNumberOp(
      request: VerifySmsSandboxPhoneNumberRequest
    ) extends SnsOp[VerifySmsSandboxPhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifySmsSandboxPhoneNumberResponse] =
        visitor.verifySMSSandboxPhoneNumber(request)
    }
  }

  import SnsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SnsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addPermission(
    request: AddPermissionRequest
  ): SnsIO[AddPermissionResponse] =
    FF.liftF(AddPermissionOp(request))

  def checkIfPhoneNumberIsOptedOut(
    request: CheckIfPhoneNumberIsOptedOutRequest
  ): SnsIO[CheckIfPhoneNumberIsOptedOutResponse] =
    FF.liftF(CheckIfPhoneNumberIsOptedOutOp(request))

  def confirmSubscription(
    request: ConfirmSubscriptionRequest
  ): SnsIO[ConfirmSubscriptionResponse] =
    FF.liftF(ConfirmSubscriptionOp(request))

  def createPlatformApplication(
    request: CreatePlatformApplicationRequest
  ): SnsIO[CreatePlatformApplicationResponse] =
    FF.liftF(CreatePlatformApplicationOp(request))

  def createPlatformEndpoint(
    request: CreatePlatformEndpointRequest
  ): SnsIO[CreatePlatformEndpointResponse] =
    FF.liftF(CreatePlatformEndpointOp(request))

  def createSMSSandboxPhoneNumber(
    request: CreateSmsSandboxPhoneNumberRequest
  ): SnsIO[CreateSmsSandboxPhoneNumberResponse] =
    FF.liftF(CreateSMSSandboxPhoneNumberOp(request))

  def createTopic(
    request: CreateTopicRequest
  ): SnsIO[CreateTopicResponse] =
    FF.liftF(CreateTopicOp(request))

  def deleteEndpoint(
    request: DeleteEndpointRequest
  ): SnsIO[DeleteEndpointResponse] =
    FF.liftF(DeleteEndpointOp(request))

  def deletePlatformApplication(
    request: DeletePlatformApplicationRequest
  ): SnsIO[DeletePlatformApplicationResponse] =
    FF.liftF(DeletePlatformApplicationOp(request))

  def deleteSMSSandboxPhoneNumber(
    request: DeleteSmsSandboxPhoneNumberRequest
  ): SnsIO[DeleteSmsSandboxPhoneNumberResponse] =
    FF.liftF(DeleteSMSSandboxPhoneNumberOp(request))

  def deleteTopic(
    request: DeleteTopicRequest
  ): SnsIO[DeleteTopicResponse] =
    FF.liftF(DeleteTopicOp(request))

  def getEndpointAttributes(
    request: GetEndpointAttributesRequest
  ): SnsIO[GetEndpointAttributesResponse] =
    FF.liftF(GetEndpointAttributesOp(request))

  def getPlatformApplicationAttributes(
    request: GetPlatformApplicationAttributesRequest
  ): SnsIO[GetPlatformApplicationAttributesResponse] =
    FF.liftF(GetPlatformApplicationAttributesOp(request))

  def getSMSAttributes(
    request: GetSmsAttributesRequest
  ): SnsIO[GetSmsAttributesResponse] =
    FF.liftF(GetSMSAttributesOp(request))

  def getSMSSandboxAccountStatus(
    request: GetSmsSandboxAccountStatusRequest
  ): SnsIO[GetSmsSandboxAccountStatusResponse] =
    FF.liftF(GetSMSSandboxAccountStatusOp(request))

  def getSubscriptionAttributes(
    request: GetSubscriptionAttributesRequest
  ): SnsIO[GetSubscriptionAttributesResponse] =
    FF.liftF(GetSubscriptionAttributesOp(request))

  def getTopicAttributes(
    request: GetTopicAttributesRequest
  ): SnsIO[GetTopicAttributesResponse] =
    FF.liftF(GetTopicAttributesOp(request))

  def listEndpointsByPlatformApplication(
    request: ListEndpointsByPlatformApplicationRequest
  ): SnsIO[ListEndpointsByPlatformApplicationResponse] =
    FF.liftF(ListEndpointsByPlatformApplicationOp(request))

  def listOriginationNumbers(
    request: ListOriginationNumbersRequest
  ): SnsIO[ListOriginationNumbersResponse] =
    FF.liftF(ListOriginationNumbersOp(request))

  def listPhoneNumbersOptedOut(
    request: ListPhoneNumbersOptedOutRequest
  ): SnsIO[ListPhoneNumbersOptedOutResponse] =
    FF.liftF(ListPhoneNumbersOptedOutOp(request))

  def listPlatformApplications(
    request: ListPlatformApplicationsRequest
  ): SnsIO[ListPlatformApplicationsResponse] =
    FF.liftF(ListPlatformApplicationsOp(request))

  def listSMSSandboxPhoneNumbers(
    request: ListSmsSandboxPhoneNumbersRequest
  ): SnsIO[ListSmsSandboxPhoneNumbersResponse] =
    FF.liftF(ListSMSSandboxPhoneNumbersOp(request))

  def listSubscriptions(
    request: ListSubscriptionsRequest
  ): SnsIO[ListSubscriptionsResponse] =
    FF.liftF(ListSubscriptionsOp(request))

  def listSubscriptionsByTopic(
    request: ListSubscriptionsByTopicRequest
  ): SnsIO[ListSubscriptionsByTopicResponse] =
    FF.liftF(ListSubscriptionsByTopicOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SnsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTopics(
    request: ListTopicsRequest
  ): SnsIO[ListTopicsResponse] =
    FF.liftF(ListTopicsOp(request))

  def optInPhoneNumber(
    request: OptInPhoneNumberRequest
  ): SnsIO[OptInPhoneNumberResponse] =
    FF.liftF(OptInPhoneNumberOp(request))

  def publish(
    request: PublishRequest
  ): SnsIO[PublishResponse] =
    FF.liftF(PublishOp(request))

  def removePermission(
    request: RemovePermissionRequest
  ): SnsIO[RemovePermissionResponse] =
    FF.liftF(RemovePermissionOp(request))

  def setEndpointAttributes(
    request: SetEndpointAttributesRequest
  ): SnsIO[SetEndpointAttributesResponse] =
    FF.liftF(SetEndpointAttributesOp(request))

  def setPlatformApplicationAttributes(
    request: SetPlatformApplicationAttributesRequest
  ): SnsIO[SetPlatformApplicationAttributesResponse] =
    FF.liftF(SetPlatformApplicationAttributesOp(request))

  def setSMSAttributes(
    request: SetSmsAttributesRequest
  ): SnsIO[SetSmsAttributesResponse] =
    FF.liftF(SetSMSAttributesOp(request))

  def setSubscriptionAttributes(
    request: SetSubscriptionAttributesRequest
  ): SnsIO[SetSubscriptionAttributesResponse] =
    FF.liftF(SetSubscriptionAttributesOp(request))

  def setTopicAttributes(
    request: SetTopicAttributesRequest
  ): SnsIO[SetTopicAttributesResponse] =
    FF.liftF(SetTopicAttributesOp(request))

  def subscribe(
    request: SubscribeRequest
  ): SnsIO[SubscribeResponse] =
    FF.liftF(SubscribeOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SnsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def unsubscribe(
    request: UnsubscribeRequest
  ): SnsIO[UnsubscribeResponse] =
    FF.liftF(UnsubscribeOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SnsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def verifySMSSandboxPhoneNumber(
    request: VerifySmsSandboxPhoneNumberRequest
  ): SnsIO[VerifySmsSandboxPhoneNumberResponse] =
    FF.liftF(VerifySMSSandboxPhoneNumberOp(request))
}
