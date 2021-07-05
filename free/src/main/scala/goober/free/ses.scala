package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.ses.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ses { module =>

  // Free monad over SesOp
  type SesIO[A] = FF[SesOp, A]

  sealed trait SesOp[A] {
    def visit[F[_]](visitor: SesOp.Visitor[F]): F[A]
  }

  object SesOp {
    // Given a SesClient we can embed a SesIO program in any algebra that understands embedding.
    implicit val SesOpEmbeddable: Embeddable[SesOp, SesClient] = new Embeddable[SesOp, SesClient] {
      def embed[A](client: SesClient, io: SesIO[A]): Embedded[A] = Embedded.Ses(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SesOp.Visitor[Kleisli[M, SesClient, *]] {
        def cloneReceiptRuleSet(
          request: CloneReceiptRuleSetRequest
        ): Kleisli[M, SesClient, CloneReceiptRuleSetResponse] =
          primitive(_.cloneReceiptRuleSet(request))

        def createConfigurationSet(
          request: CreateConfigurationSetRequest
        ): Kleisli[M, SesClient, CreateConfigurationSetResponse] =
          primitive(_.createConfigurationSet(request))

        def createConfigurationSetEventDestination(
          request: CreateConfigurationSetEventDestinationRequest
        ): Kleisli[M, SesClient, CreateConfigurationSetEventDestinationResponse] =
          primitive(_.createConfigurationSetEventDestination(request))

        def createConfigurationSetTrackingOptions(
          request: CreateConfigurationSetTrackingOptionsRequest
        ): Kleisli[M, SesClient, CreateConfigurationSetTrackingOptionsResponse] =
          primitive(_.createConfigurationSetTrackingOptions(request))

        def createCustomVerificationEmailTemplate(
          request: CreateCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesClient, CreateCustomVerificationEmailTemplateResponse] =
          primitive(_.createCustomVerificationEmailTemplate(request))

        def createReceiptFilter(
          request: CreateReceiptFilterRequest
        ): Kleisli[M, SesClient, CreateReceiptFilterResponse] =
          primitive(_.createReceiptFilter(request))

        def createReceiptRule(
          request: CreateReceiptRuleRequest
        ): Kleisli[M, SesClient, CreateReceiptRuleResponse] =
          primitive(_.createReceiptRule(request))

        def createReceiptRuleSet(
          request: CreateReceiptRuleSetRequest
        ): Kleisli[M, SesClient, CreateReceiptRuleSetResponse] =
          primitive(_.createReceiptRuleSet(request))

        def createTemplate(
          request: CreateTemplateRequest
        ): Kleisli[M, SesClient, CreateTemplateResponse] =
          primitive(_.createTemplate(request))

        def deleteConfigurationSet(
          request: DeleteConfigurationSetRequest
        ): Kleisli[M, SesClient, DeleteConfigurationSetResponse] =
          primitive(_.deleteConfigurationSet(request))

        def deleteConfigurationSetEventDestination(
          request: DeleteConfigurationSetEventDestinationRequest
        ): Kleisli[M, SesClient, DeleteConfigurationSetEventDestinationResponse] =
          primitive(_.deleteConfigurationSetEventDestination(request))

        def deleteConfigurationSetTrackingOptions(
          request: DeleteConfigurationSetTrackingOptionsRequest
        ): Kleisli[M, SesClient, DeleteConfigurationSetTrackingOptionsResponse] =
          primitive(_.deleteConfigurationSetTrackingOptions(request))

        def deleteCustomVerificationEmailTemplate(
          request: DeleteCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesClient, DeleteCustomVerificationEmailTemplateResponse] =
          primitive(_.deleteCustomVerificationEmailTemplate(request))

        def deleteIdentity(
          request: DeleteIdentityRequest
        ): Kleisli[M, SesClient, DeleteIdentityResponse] =
          primitive(_.deleteIdentity(request))

        def deleteIdentityPolicy(
          request: DeleteIdentityPolicyRequest
        ): Kleisli[M, SesClient, DeleteIdentityPolicyResponse] =
          primitive(_.deleteIdentityPolicy(request))

        def deleteReceiptFilter(
          request: DeleteReceiptFilterRequest
        ): Kleisli[M, SesClient, DeleteReceiptFilterResponse] =
          primitive(_.deleteReceiptFilter(request))

        def deleteReceiptRule(
          request: DeleteReceiptRuleRequest
        ): Kleisli[M, SesClient, DeleteReceiptRuleResponse] =
          primitive(_.deleteReceiptRule(request))

        def deleteReceiptRuleSet(
          request: DeleteReceiptRuleSetRequest
        ): Kleisli[M, SesClient, DeleteReceiptRuleSetResponse] =
          primitive(_.deleteReceiptRuleSet(request))

        def deleteTemplate(
          request: DeleteTemplateRequest
        ): Kleisli[M, SesClient, DeleteTemplateResponse] =
          primitive(_.deleteTemplate(request))

        def deleteVerifiedEmailAddress(
          request: DeleteVerifiedEmailAddressRequest
        ): Kleisli[M, SesClient, DeleteVerifiedEmailAddressResponse] =
          primitive(_.deleteVerifiedEmailAddress(request))

        def describeActiveReceiptRuleSet(
          request: DescribeActiveReceiptRuleSetRequest
        ): Kleisli[M, SesClient, DescribeActiveReceiptRuleSetResponse] =
          primitive(_.describeActiveReceiptRuleSet(request))

        def describeConfigurationSet(
          request: DescribeConfigurationSetRequest
        ): Kleisli[M, SesClient, DescribeConfigurationSetResponse] =
          primitive(_.describeConfigurationSet(request))

        def describeReceiptRule(
          request: DescribeReceiptRuleRequest
        ): Kleisli[M, SesClient, DescribeReceiptRuleResponse] =
          primitive(_.describeReceiptRule(request))

        def describeReceiptRuleSet(
          request: DescribeReceiptRuleSetRequest
        ): Kleisli[M, SesClient, DescribeReceiptRuleSetResponse] =
          primitive(_.describeReceiptRuleSet(request))

        def getAccountSendingEnabled(
          request: GetAccountSendingEnabledRequest
        ): Kleisli[M, SesClient, GetAccountSendingEnabledResponse] =
          primitive(_.getAccountSendingEnabled(request))

        def getCustomVerificationEmailTemplate(
          request: GetCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesClient, GetCustomVerificationEmailTemplateResponse] =
          primitive(_.getCustomVerificationEmailTemplate(request))

        def getIdentityDkimAttributes(
          request: GetIdentityDkimAttributesRequest
        ): Kleisli[M, SesClient, GetIdentityDkimAttributesResponse] =
          primitive(_.getIdentityDkimAttributes(request))

        def getIdentityMailFromDomainAttributes(
          request: GetIdentityMailFromDomainAttributesRequest
        ): Kleisli[M, SesClient, GetIdentityMailFromDomainAttributesResponse] =
          primitive(_.getIdentityMailFromDomainAttributes(request))

        def getIdentityNotificationAttributes(
          request: GetIdentityNotificationAttributesRequest
        ): Kleisli[M, SesClient, GetIdentityNotificationAttributesResponse] =
          primitive(_.getIdentityNotificationAttributes(request))

        def getIdentityPolicies(
          request: GetIdentityPoliciesRequest
        ): Kleisli[M, SesClient, GetIdentityPoliciesResponse] =
          primitive(_.getIdentityPolicies(request))

        def getIdentityVerificationAttributes(
          request: GetIdentityVerificationAttributesRequest
        ): Kleisli[M, SesClient, GetIdentityVerificationAttributesResponse] =
          primitive(_.getIdentityVerificationAttributes(request))

        def getSendQuota(
          request: GetSendQuotaRequest
        ): Kleisli[M, SesClient, GetSendQuotaResponse] =
          primitive(_.getSendQuota(request))

        def getSendStatistics(
          request: GetSendStatisticsRequest
        ): Kleisli[M, SesClient, GetSendStatisticsResponse] =
          primitive(_.getSendStatistics(request))

        def getTemplate(
          request: GetTemplateRequest
        ): Kleisli[M, SesClient, GetTemplateResponse] =
          primitive(_.getTemplate(request))

        def listConfigurationSets(
          request: ListConfigurationSetsRequest
        ): Kleisli[M, SesClient, ListConfigurationSetsResponse] =
          primitive(_.listConfigurationSets(request))

        def listCustomVerificationEmailTemplates(
          request: ListCustomVerificationEmailTemplatesRequest
        ): Kleisli[M, SesClient, ListCustomVerificationEmailTemplatesResponse] =
          primitive(_.listCustomVerificationEmailTemplates(request))

        def listIdentities(
          request: ListIdentitiesRequest
        ): Kleisli[M, SesClient, ListIdentitiesResponse] =
          primitive(_.listIdentities(request))

        def listIdentityPolicies(
          request: ListIdentityPoliciesRequest
        ): Kleisli[M, SesClient, ListIdentityPoliciesResponse] =
          primitive(_.listIdentityPolicies(request))

        def listReceiptFilters(
          request: ListReceiptFiltersRequest
        ): Kleisli[M, SesClient, ListReceiptFiltersResponse] =
          primitive(_.listReceiptFilters(request))

        def listReceiptRuleSets(
          request: ListReceiptRuleSetsRequest
        ): Kleisli[M, SesClient, ListReceiptRuleSetsResponse] =
          primitive(_.listReceiptRuleSets(request))

        def listTemplates(
          request: ListTemplatesRequest
        ): Kleisli[M, SesClient, ListTemplatesResponse] =
          primitive(_.listTemplates(request))

        def listVerifiedEmailAddresses(
          request: ListVerifiedEmailAddressesRequest
        ): Kleisli[M, SesClient, ListVerifiedEmailAddressesResponse] =
          primitive(_.listVerifiedEmailAddresses(request))

        def putConfigurationSetDeliveryOptions(
          request: PutConfigurationSetDeliveryOptionsRequest
        ): Kleisli[M, SesClient, PutConfigurationSetDeliveryOptionsResponse] =
          primitive(_.putConfigurationSetDeliveryOptions(request))

        def putIdentityPolicy(
          request: PutIdentityPolicyRequest
        ): Kleisli[M, SesClient, PutIdentityPolicyResponse] =
          primitive(_.putIdentityPolicy(request))

        def reorderReceiptRuleSet(
          request: ReorderReceiptRuleSetRequest
        ): Kleisli[M, SesClient, ReorderReceiptRuleSetResponse] =
          primitive(_.reorderReceiptRuleSet(request))

        def sendBounce(
          request: SendBounceRequest
        ): Kleisli[M, SesClient, SendBounceResponse] =
          primitive(_.sendBounce(request))

        def sendBulkTemplatedEmail(
          request: SendBulkTemplatedEmailRequest
        ): Kleisli[M, SesClient, SendBulkTemplatedEmailResponse] =
          primitive(_.sendBulkTemplatedEmail(request))

        def sendCustomVerificationEmail(
          request: SendCustomVerificationEmailRequest
        ): Kleisli[M, SesClient, SendCustomVerificationEmailResponse] =
          primitive(_.sendCustomVerificationEmail(request))

        def sendEmail(
          request: SendEmailRequest
        ): Kleisli[M, SesClient, SendEmailResponse] =
          primitive(_.sendEmail(request))

        def sendRawEmail(
          request: SendRawEmailRequest
        ): Kleisli[M, SesClient, SendRawEmailResponse] =
          primitive(_.sendRawEmail(request))

        def sendTemplatedEmail(
          request: SendTemplatedEmailRequest
        ): Kleisli[M, SesClient, SendTemplatedEmailResponse] =
          primitive(_.sendTemplatedEmail(request))

        def setActiveReceiptRuleSet(
          request: SetActiveReceiptRuleSetRequest
        ): Kleisli[M, SesClient, SetActiveReceiptRuleSetResponse] =
          primitive(_.setActiveReceiptRuleSet(request))

        def setIdentityDkimEnabled(
          request: SetIdentityDkimEnabledRequest
        ): Kleisli[M, SesClient, SetIdentityDkimEnabledResponse] =
          primitive(_.setIdentityDkimEnabled(request))

        def setIdentityFeedbackForwardingEnabled(
          request: SetIdentityFeedbackForwardingEnabledRequest
        ): Kleisli[M, SesClient, SetIdentityFeedbackForwardingEnabledResponse] =
          primitive(_.setIdentityFeedbackForwardingEnabled(request))

        def setIdentityHeadersInNotificationsEnabled(
          request: SetIdentityHeadersInNotificationsEnabledRequest
        ): Kleisli[M, SesClient, SetIdentityHeadersInNotificationsEnabledResponse] =
          primitive(_.setIdentityHeadersInNotificationsEnabled(request))

        def setIdentityMailFromDomain(
          request: SetIdentityMailFromDomainRequest
        ): Kleisli[M, SesClient, SetIdentityMailFromDomainResponse] =
          primitive(_.setIdentityMailFromDomain(request))

        def setIdentityNotificationTopic(
          request: SetIdentityNotificationTopicRequest
        ): Kleisli[M, SesClient, SetIdentityNotificationTopicResponse] =
          primitive(_.setIdentityNotificationTopic(request))

        def setReceiptRulePosition(
          request: SetReceiptRulePositionRequest
        ): Kleisli[M, SesClient, SetReceiptRulePositionResponse] =
          primitive(_.setReceiptRulePosition(request))

        def testRenderTemplate(
          request: TestRenderTemplateRequest
        ): Kleisli[M, SesClient, TestRenderTemplateResponse] =
          primitive(_.testRenderTemplate(request))

        def updateAccountSendingEnabled(
          request: UpdateAccountSendingEnabledRequest
        ): Kleisli[M, SesClient, UpdateAccountSendingEnabledResponse] =
          primitive(_.updateAccountSendingEnabled(request))

        def updateConfigurationSetEventDestination(
          request: UpdateConfigurationSetEventDestinationRequest
        ): Kleisli[M, SesClient, UpdateConfigurationSetEventDestinationResponse] =
          primitive(_.updateConfigurationSetEventDestination(request))

        def updateConfigurationSetReputationMetricsEnabled(
          request: UpdateConfigurationSetReputationMetricsEnabledRequest
        ): Kleisli[M, SesClient, UpdateConfigurationSetReputationMetricsEnabledResponse] =
          primitive(_.updateConfigurationSetReputationMetricsEnabled(request))

        def updateConfigurationSetSendingEnabled(
          request: UpdateConfigurationSetSendingEnabledRequest
        ): Kleisli[M, SesClient, UpdateConfigurationSetSendingEnabledResponse] =
          primitive(_.updateConfigurationSetSendingEnabled(request))

        def updateConfigurationSetTrackingOptions(
          request: UpdateConfigurationSetTrackingOptionsRequest
        ): Kleisli[M, SesClient, UpdateConfigurationSetTrackingOptionsResponse] =
          primitive(_.updateConfigurationSetTrackingOptions(request))

        def updateCustomVerificationEmailTemplate(
          request: UpdateCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesClient, UpdateCustomVerificationEmailTemplateResponse] =
          primitive(_.updateCustomVerificationEmailTemplate(request))

        def updateReceiptRule(
          request: UpdateReceiptRuleRequest
        ): Kleisli[M, SesClient, UpdateReceiptRuleResponse] =
          primitive(_.updateReceiptRule(request))

        def updateTemplate(
          request: UpdateTemplateRequest
        ): Kleisli[M, SesClient, UpdateTemplateResponse] =
          primitive(_.updateTemplate(request))

        def verifyDomainDkim(
          request: VerifyDomainDkimRequest
        ): Kleisli[M, SesClient, VerifyDomainDkimResponse] =
          primitive(_.verifyDomainDkim(request))

        def verifyDomainIdentity(
          request: VerifyDomainIdentityRequest
        ): Kleisli[M, SesClient, VerifyDomainIdentityResponse] =
          primitive(_.verifyDomainIdentity(request))

        def verifyEmailAddress(
          request: VerifyEmailAddressRequest
        ): Kleisli[M, SesClient, VerifyEmailAddressResponse] =
          primitive(_.verifyEmailAddress(request))

        def verifyEmailIdentity(
          request: VerifyEmailIdentityRequest
        ): Kleisli[M, SesClient, VerifyEmailIdentityResponse] =
          primitive(_.verifyEmailIdentity(request))

        def primitive[A](
          f: SesClient => A
        ): Kleisli[M, SesClient, A]
      }
    }

    trait Visitor[F[_]] extends (SesOp ~> F) {
      final def apply[A](op: SesOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cloneReceiptRuleSet(
        request: CloneReceiptRuleSetRequest
      ): F[CloneReceiptRuleSetResponse]

      def createConfigurationSet(
        request: CreateConfigurationSetRequest
      ): F[CreateConfigurationSetResponse]

      def createConfigurationSetEventDestination(
        request: CreateConfigurationSetEventDestinationRequest
      ): F[CreateConfigurationSetEventDestinationResponse]

      def createConfigurationSetTrackingOptions(
        request: CreateConfigurationSetTrackingOptionsRequest
      ): F[CreateConfigurationSetTrackingOptionsResponse]

      def createCustomVerificationEmailTemplate(
        request: CreateCustomVerificationEmailTemplateRequest
      ): F[CreateCustomVerificationEmailTemplateResponse]

      def createReceiptFilter(
        request: CreateReceiptFilterRequest
      ): F[CreateReceiptFilterResponse]

      def createReceiptRule(
        request: CreateReceiptRuleRequest
      ): F[CreateReceiptRuleResponse]

      def createReceiptRuleSet(
        request: CreateReceiptRuleSetRequest
      ): F[CreateReceiptRuleSetResponse]

      def createTemplate(
        request: CreateTemplateRequest
      ): F[CreateTemplateResponse]

      def deleteConfigurationSet(
        request: DeleteConfigurationSetRequest
      ): F[DeleteConfigurationSetResponse]

      def deleteConfigurationSetEventDestination(
        request: DeleteConfigurationSetEventDestinationRequest
      ): F[DeleteConfigurationSetEventDestinationResponse]

      def deleteConfigurationSetTrackingOptions(
        request: DeleteConfigurationSetTrackingOptionsRequest
      ): F[DeleteConfigurationSetTrackingOptionsResponse]

      def deleteCustomVerificationEmailTemplate(
        request: DeleteCustomVerificationEmailTemplateRequest
      ): F[DeleteCustomVerificationEmailTemplateResponse]

      def deleteIdentity(
        request: DeleteIdentityRequest
      ): F[DeleteIdentityResponse]

      def deleteIdentityPolicy(
        request: DeleteIdentityPolicyRequest
      ): F[DeleteIdentityPolicyResponse]

      def deleteReceiptFilter(
        request: DeleteReceiptFilterRequest
      ): F[DeleteReceiptFilterResponse]

      def deleteReceiptRule(
        request: DeleteReceiptRuleRequest
      ): F[DeleteReceiptRuleResponse]

      def deleteReceiptRuleSet(
        request: DeleteReceiptRuleSetRequest
      ): F[DeleteReceiptRuleSetResponse]

      def deleteTemplate(
        request: DeleteTemplateRequest
      ): F[DeleteTemplateResponse]

      def deleteVerifiedEmailAddress(
        request: DeleteVerifiedEmailAddressRequest
      ): F[DeleteVerifiedEmailAddressResponse]

      def describeActiveReceiptRuleSet(
        request: DescribeActiveReceiptRuleSetRequest
      ): F[DescribeActiveReceiptRuleSetResponse]

      def describeConfigurationSet(
        request: DescribeConfigurationSetRequest
      ): F[DescribeConfigurationSetResponse]

      def describeReceiptRule(
        request: DescribeReceiptRuleRequest
      ): F[DescribeReceiptRuleResponse]

      def describeReceiptRuleSet(
        request: DescribeReceiptRuleSetRequest
      ): F[DescribeReceiptRuleSetResponse]

      def getAccountSendingEnabled(
        request: GetAccountSendingEnabledRequest
      ): F[GetAccountSendingEnabledResponse]

      def getCustomVerificationEmailTemplate(
        request: GetCustomVerificationEmailTemplateRequest
      ): F[GetCustomVerificationEmailTemplateResponse]

      def getIdentityDkimAttributes(
        request: GetIdentityDkimAttributesRequest
      ): F[GetIdentityDkimAttributesResponse]

      def getIdentityMailFromDomainAttributes(
        request: GetIdentityMailFromDomainAttributesRequest
      ): F[GetIdentityMailFromDomainAttributesResponse]

      def getIdentityNotificationAttributes(
        request: GetIdentityNotificationAttributesRequest
      ): F[GetIdentityNotificationAttributesResponse]

      def getIdentityPolicies(
        request: GetIdentityPoliciesRequest
      ): F[GetIdentityPoliciesResponse]

      def getIdentityVerificationAttributes(
        request: GetIdentityVerificationAttributesRequest
      ): F[GetIdentityVerificationAttributesResponse]

      def getSendQuota(
        request: GetSendQuotaRequest
      ): F[GetSendQuotaResponse]

      def getSendStatistics(
        request: GetSendStatisticsRequest
      ): F[GetSendStatisticsResponse]

      def getTemplate(
        request: GetTemplateRequest
      ): F[GetTemplateResponse]

      def listConfigurationSets(
        request: ListConfigurationSetsRequest
      ): F[ListConfigurationSetsResponse]

      def listCustomVerificationEmailTemplates(
        request: ListCustomVerificationEmailTemplatesRequest
      ): F[ListCustomVerificationEmailTemplatesResponse]

      def listIdentities(
        request: ListIdentitiesRequest
      ): F[ListIdentitiesResponse]

      def listIdentityPolicies(
        request: ListIdentityPoliciesRequest
      ): F[ListIdentityPoliciesResponse]

      def listReceiptFilters(
        request: ListReceiptFiltersRequest
      ): F[ListReceiptFiltersResponse]

      def listReceiptRuleSets(
        request: ListReceiptRuleSetsRequest
      ): F[ListReceiptRuleSetsResponse]

      def listTemplates(
        request: ListTemplatesRequest
      ): F[ListTemplatesResponse]

      def listVerifiedEmailAddresses(
        request: ListVerifiedEmailAddressesRequest
      ): F[ListVerifiedEmailAddressesResponse]

      def putConfigurationSetDeliveryOptions(
        request: PutConfigurationSetDeliveryOptionsRequest
      ): F[PutConfigurationSetDeliveryOptionsResponse]

      def putIdentityPolicy(
        request: PutIdentityPolicyRequest
      ): F[PutIdentityPolicyResponse]

      def reorderReceiptRuleSet(
        request: ReorderReceiptRuleSetRequest
      ): F[ReorderReceiptRuleSetResponse]

      def sendBounce(
        request: SendBounceRequest
      ): F[SendBounceResponse]

      def sendBulkTemplatedEmail(
        request: SendBulkTemplatedEmailRequest
      ): F[SendBulkTemplatedEmailResponse]

      def sendCustomVerificationEmail(
        request: SendCustomVerificationEmailRequest
      ): F[SendCustomVerificationEmailResponse]

      def sendEmail(
        request: SendEmailRequest
      ): F[SendEmailResponse]

      def sendRawEmail(
        request: SendRawEmailRequest
      ): F[SendRawEmailResponse]

      def sendTemplatedEmail(
        request: SendTemplatedEmailRequest
      ): F[SendTemplatedEmailResponse]

      def setActiveReceiptRuleSet(
        request: SetActiveReceiptRuleSetRequest
      ): F[SetActiveReceiptRuleSetResponse]

      def setIdentityDkimEnabled(
        request: SetIdentityDkimEnabledRequest
      ): F[SetIdentityDkimEnabledResponse]

      def setIdentityFeedbackForwardingEnabled(
        request: SetIdentityFeedbackForwardingEnabledRequest
      ): F[SetIdentityFeedbackForwardingEnabledResponse]

      def setIdentityHeadersInNotificationsEnabled(
        request: SetIdentityHeadersInNotificationsEnabledRequest
      ): F[SetIdentityHeadersInNotificationsEnabledResponse]

      def setIdentityMailFromDomain(
        request: SetIdentityMailFromDomainRequest
      ): F[SetIdentityMailFromDomainResponse]

      def setIdentityNotificationTopic(
        request: SetIdentityNotificationTopicRequest
      ): F[SetIdentityNotificationTopicResponse]

      def setReceiptRulePosition(
        request: SetReceiptRulePositionRequest
      ): F[SetReceiptRulePositionResponse]

      def testRenderTemplate(
        request: TestRenderTemplateRequest
      ): F[TestRenderTemplateResponse]

      def updateAccountSendingEnabled(
        request: UpdateAccountSendingEnabledRequest
      ): F[UpdateAccountSendingEnabledResponse]

      def updateConfigurationSetEventDestination(
        request: UpdateConfigurationSetEventDestinationRequest
      ): F[UpdateConfigurationSetEventDestinationResponse]

      def updateConfigurationSetReputationMetricsEnabled(
        request: UpdateConfigurationSetReputationMetricsEnabledRequest
      ): F[UpdateConfigurationSetReputationMetricsEnabledResponse]

      def updateConfigurationSetSendingEnabled(
        request: UpdateConfigurationSetSendingEnabledRequest
      ): F[UpdateConfigurationSetSendingEnabledResponse]

      def updateConfigurationSetTrackingOptions(
        request: UpdateConfigurationSetTrackingOptionsRequest
      ): F[UpdateConfigurationSetTrackingOptionsResponse]

      def updateCustomVerificationEmailTemplate(
        request: UpdateCustomVerificationEmailTemplateRequest
      ): F[UpdateCustomVerificationEmailTemplateResponse]

      def updateReceiptRule(
        request: UpdateReceiptRuleRequest
      ): F[UpdateReceiptRuleResponse]

      def updateTemplate(
        request: UpdateTemplateRequest
      ): F[UpdateTemplateResponse]

      def verifyDomainDkim(
        request: VerifyDomainDkimRequest
      ): F[VerifyDomainDkimResponse]

      def verifyDomainIdentity(
        request: VerifyDomainIdentityRequest
      ): F[VerifyDomainIdentityResponse]

      def verifyEmailAddress(
        request: VerifyEmailAddressRequest
      ): F[VerifyEmailAddressResponse]

      def verifyEmailIdentity(
        request: VerifyEmailIdentityRequest
      ): F[VerifyEmailIdentityResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SesOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CloneReceiptRuleSetOp(
      request: CloneReceiptRuleSetRequest
    ) extends SesOp[CloneReceiptRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CloneReceiptRuleSetResponse] =
        visitor.cloneReceiptRuleSet(request)
    }

    final case class CreateConfigurationSetOp(
      request: CreateConfigurationSetRequest
    ) extends SesOp[CreateConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetResponse] =
        visitor.createConfigurationSet(request)
    }

    final case class CreateConfigurationSetEventDestinationOp(
      request: CreateConfigurationSetEventDestinationRequest
    ) extends SesOp[CreateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetEventDestinationResponse] =
        visitor.createConfigurationSetEventDestination(request)
    }

    final case class CreateConfigurationSetTrackingOptionsOp(
      request: CreateConfigurationSetTrackingOptionsRequest
    ) extends SesOp[CreateConfigurationSetTrackingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetTrackingOptionsResponse] =
        visitor.createConfigurationSetTrackingOptions(request)
    }

    final case class CreateCustomVerificationEmailTemplateOp(
      request: CreateCustomVerificationEmailTemplateRequest
    ) extends SesOp[CreateCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomVerificationEmailTemplateResponse] =
        visitor.createCustomVerificationEmailTemplate(request)
    }

    final case class CreateReceiptFilterOp(
      request: CreateReceiptFilterRequest
    ) extends SesOp[CreateReceiptFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReceiptFilterResponse] =
        visitor.createReceiptFilter(request)
    }

    final case class CreateReceiptRuleOp(
      request: CreateReceiptRuleRequest
    ) extends SesOp[CreateReceiptRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReceiptRuleResponse] =
        visitor.createReceiptRule(request)
    }

    final case class CreateReceiptRuleSetOp(
      request: CreateReceiptRuleSetRequest
    ) extends SesOp[CreateReceiptRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReceiptRuleSetResponse] =
        visitor.createReceiptRuleSet(request)
    }

    final case class CreateTemplateOp(
      request: CreateTemplateRequest
    ) extends SesOp[CreateTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTemplateResponse] =
        visitor.createTemplate(request)
    }

    final case class DeleteConfigurationSetOp(
      request: DeleteConfigurationSetRequest
    ) extends SesOp[DeleteConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetResponse] =
        visitor.deleteConfigurationSet(request)
    }

    final case class DeleteConfigurationSetEventDestinationOp(
      request: DeleteConfigurationSetEventDestinationRequest
    ) extends SesOp[DeleteConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetEventDestinationResponse] =
        visitor.deleteConfigurationSetEventDestination(request)
    }

    final case class DeleteConfigurationSetTrackingOptionsOp(
      request: DeleteConfigurationSetTrackingOptionsRequest
    ) extends SesOp[DeleteConfigurationSetTrackingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetTrackingOptionsResponse] =
        visitor.deleteConfigurationSetTrackingOptions(request)
    }

    final case class DeleteCustomVerificationEmailTemplateOp(
      request: DeleteCustomVerificationEmailTemplateRequest
    ) extends SesOp[DeleteCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomVerificationEmailTemplateResponse] =
        visitor.deleteCustomVerificationEmailTemplate(request)
    }

    final case class DeleteIdentityOp(
      request: DeleteIdentityRequest
    ) extends SesOp[DeleteIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIdentityResponse] =
        visitor.deleteIdentity(request)
    }

    final case class DeleteIdentityPolicyOp(
      request: DeleteIdentityPolicyRequest
    ) extends SesOp[DeleteIdentityPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIdentityPolicyResponse] =
        visitor.deleteIdentityPolicy(request)
    }

    final case class DeleteReceiptFilterOp(
      request: DeleteReceiptFilterRequest
    ) extends SesOp[DeleteReceiptFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReceiptFilterResponse] =
        visitor.deleteReceiptFilter(request)
    }

    final case class DeleteReceiptRuleOp(
      request: DeleteReceiptRuleRequest
    ) extends SesOp[DeleteReceiptRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReceiptRuleResponse] =
        visitor.deleteReceiptRule(request)
    }

    final case class DeleteReceiptRuleSetOp(
      request: DeleteReceiptRuleSetRequest
    ) extends SesOp[DeleteReceiptRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReceiptRuleSetResponse] =
        visitor.deleteReceiptRuleSet(request)
    }

    final case class DeleteTemplateOp(
      request: DeleteTemplateRequest
    ) extends SesOp[DeleteTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTemplateResponse] =
        visitor.deleteTemplate(request)
    }

    final case class DeleteVerifiedEmailAddressOp(
      request: DeleteVerifiedEmailAddressRequest
    ) extends SesOp[DeleteVerifiedEmailAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVerifiedEmailAddressResponse] =
        visitor.deleteVerifiedEmailAddress(request)
    }

    final case class DescribeActiveReceiptRuleSetOp(
      request: DescribeActiveReceiptRuleSetRequest
    ) extends SesOp[DescribeActiveReceiptRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeActiveReceiptRuleSetResponse] =
        visitor.describeActiveReceiptRuleSet(request)
    }

    final case class DescribeConfigurationSetOp(
      request: DescribeConfigurationSetRequest
    ) extends SesOp[DescribeConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationSetResponse] =
        visitor.describeConfigurationSet(request)
    }

    final case class DescribeReceiptRuleOp(
      request: DescribeReceiptRuleRequest
    ) extends SesOp[DescribeReceiptRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReceiptRuleResponse] =
        visitor.describeReceiptRule(request)
    }

    final case class DescribeReceiptRuleSetOp(
      request: DescribeReceiptRuleSetRequest
    ) extends SesOp[DescribeReceiptRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReceiptRuleSetResponse] =
        visitor.describeReceiptRuleSet(request)
    }

    final case class GetAccountSendingEnabledOp(
      request: GetAccountSendingEnabledRequest
    ) extends SesOp[GetAccountSendingEnabledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountSendingEnabledResponse] =
        visitor.getAccountSendingEnabled(request)
    }

    final case class GetCustomVerificationEmailTemplateOp(
      request: GetCustomVerificationEmailTemplateRequest
    ) extends SesOp[GetCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCustomVerificationEmailTemplateResponse] =
        visitor.getCustomVerificationEmailTemplate(request)
    }

    final case class GetIdentityDkimAttributesOp(
      request: GetIdentityDkimAttributesRequest
    ) extends SesOp[GetIdentityDkimAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityDkimAttributesResponse] =
        visitor.getIdentityDkimAttributes(request)
    }

    final case class GetIdentityMailFromDomainAttributesOp(
      request: GetIdentityMailFromDomainAttributesRequest
    ) extends SesOp[GetIdentityMailFromDomainAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityMailFromDomainAttributesResponse] =
        visitor.getIdentityMailFromDomainAttributes(request)
    }

    final case class GetIdentityNotificationAttributesOp(
      request: GetIdentityNotificationAttributesRequest
    ) extends SesOp[GetIdentityNotificationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityNotificationAttributesResponse] =
        visitor.getIdentityNotificationAttributes(request)
    }

    final case class GetIdentityPoliciesOp(
      request: GetIdentityPoliciesRequest
    ) extends SesOp[GetIdentityPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityPoliciesResponse] =
        visitor.getIdentityPolicies(request)
    }

    final case class GetIdentityVerificationAttributesOp(
      request: GetIdentityVerificationAttributesRequest
    ) extends SesOp[GetIdentityVerificationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityVerificationAttributesResponse] =
        visitor.getIdentityVerificationAttributes(request)
    }

    final case class GetSendQuotaOp(
      request: GetSendQuotaRequest
    ) extends SesOp[GetSendQuotaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSendQuotaResponse] =
        visitor.getSendQuota(request)
    }

    final case class GetSendStatisticsOp(
      request: GetSendStatisticsRequest
    ) extends SesOp[GetSendStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSendStatisticsResponse] =
        visitor.getSendStatistics(request)
    }

    final case class GetTemplateOp(
      request: GetTemplateRequest
    ) extends SesOp[GetTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTemplateResponse] =
        visitor.getTemplate(request)
    }

    final case class ListConfigurationSetsOp(
      request: ListConfigurationSetsRequest
    ) extends SesOp[ListConfigurationSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationSetsResponse] =
        visitor.listConfigurationSets(request)
    }

    final case class ListCustomVerificationEmailTemplatesOp(
      request: ListCustomVerificationEmailTemplatesRequest
    ) extends SesOp[ListCustomVerificationEmailTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomVerificationEmailTemplatesResponse] =
        visitor.listCustomVerificationEmailTemplates(request)
    }

    final case class ListIdentitiesOp(
      request: ListIdentitiesRequest
    ) extends SesOp[ListIdentitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIdentitiesResponse] =
        visitor.listIdentities(request)
    }

    final case class ListIdentityPoliciesOp(
      request: ListIdentityPoliciesRequest
    ) extends SesOp[ListIdentityPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIdentityPoliciesResponse] =
        visitor.listIdentityPolicies(request)
    }

    final case class ListReceiptFiltersOp(
      request: ListReceiptFiltersRequest
    ) extends SesOp[ListReceiptFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReceiptFiltersResponse] =
        visitor.listReceiptFilters(request)
    }

    final case class ListReceiptRuleSetsOp(
      request: ListReceiptRuleSetsRequest
    ) extends SesOp[ListReceiptRuleSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReceiptRuleSetsResponse] =
        visitor.listReceiptRuleSets(request)
    }

    final case class ListTemplatesOp(
      request: ListTemplatesRequest
    ) extends SesOp[ListTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTemplatesResponse] =
        visitor.listTemplates(request)
    }

    final case class ListVerifiedEmailAddressesOp(
      request: ListVerifiedEmailAddressesRequest
    ) extends SesOp[ListVerifiedEmailAddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVerifiedEmailAddressesResponse] =
        visitor.listVerifiedEmailAddresses(request)
    }

    final case class PutConfigurationSetDeliveryOptionsOp(
      request: PutConfigurationSetDeliveryOptionsRequest
    ) extends SesOp[PutConfigurationSetDeliveryOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetDeliveryOptionsResponse] =
        visitor.putConfigurationSetDeliveryOptions(request)
    }

    final case class PutIdentityPolicyOp(
      request: PutIdentityPolicyRequest
    ) extends SesOp[PutIdentityPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutIdentityPolicyResponse] =
        visitor.putIdentityPolicy(request)
    }

    final case class ReorderReceiptRuleSetOp(
      request: ReorderReceiptRuleSetRequest
    ) extends SesOp[ReorderReceiptRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReorderReceiptRuleSetResponse] =
        visitor.reorderReceiptRuleSet(request)
    }

    final case class SendBounceOp(
      request: SendBounceRequest
    ) extends SesOp[SendBounceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendBounceResponse] =
        visitor.sendBounce(request)
    }

    final case class SendBulkTemplatedEmailOp(
      request: SendBulkTemplatedEmailRequest
    ) extends SesOp[SendBulkTemplatedEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendBulkTemplatedEmailResponse] =
        visitor.sendBulkTemplatedEmail(request)
    }

    final case class SendCustomVerificationEmailOp(
      request: SendCustomVerificationEmailRequest
    ) extends SesOp[SendCustomVerificationEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendCustomVerificationEmailResponse] =
        visitor.sendCustomVerificationEmail(request)
    }

    final case class SendEmailOp(
      request: SendEmailRequest
    ) extends SesOp[SendEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendEmailResponse] =
        visitor.sendEmail(request)
    }

    final case class SendRawEmailOp(
      request: SendRawEmailRequest
    ) extends SesOp[SendRawEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendRawEmailResponse] =
        visitor.sendRawEmail(request)
    }

    final case class SendTemplatedEmailOp(
      request: SendTemplatedEmailRequest
    ) extends SesOp[SendTemplatedEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendTemplatedEmailResponse] =
        visitor.sendTemplatedEmail(request)
    }

    final case class SetActiveReceiptRuleSetOp(
      request: SetActiveReceiptRuleSetRequest
    ) extends SesOp[SetActiveReceiptRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetActiveReceiptRuleSetResponse] =
        visitor.setActiveReceiptRuleSet(request)
    }

    final case class SetIdentityDkimEnabledOp(
      request: SetIdentityDkimEnabledRequest
    ) extends SesOp[SetIdentityDkimEnabledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIdentityDkimEnabledResponse] =
        visitor.setIdentityDkimEnabled(request)
    }

    final case class SetIdentityFeedbackForwardingEnabledOp(
      request: SetIdentityFeedbackForwardingEnabledRequest
    ) extends SesOp[SetIdentityFeedbackForwardingEnabledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIdentityFeedbackForwardingEnabledResponse] =
        visitor.setIdentityFeedbackForwardingEnabled(request)
    }

    final case class SetIdentityHeadersInNotificationsEnabledOp(
      request: SetIdentityHeadersInNotificationsEnabledRequest
    ) extends SesOp[SetIdentityHeadersInNotificationsEnabledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIdentityHeadersInNotificationsEnabledResponse] =
        visitor.setIdentityHeadersInNotificationsEnabled(request)
    }

    final case class SetIdentityMailFromDomainOp(
      request: SetIdentityMailFromDomainRequest
    ) extends SesOp[SetIdentityMailFromDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIdentityMailFromDomainResponse] =
        visitor.setIdentityMailFromDomain(request)
    }

    final case class SetIdentityNotificationTopicOp(
      request: SetIdentityNotificationTopicRequest
    ) extends SesOp[SetIdentityNotificationTopicResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIdentityNotificationTopicResponse] =
        visitor.setIdentityNotificationTopic(request)
    }

    final case class SetReceiptRulePositionOp(
      request: SetReceiptRulePositionRequest
    ) extends SesOp[SetReceiptRulePositionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetReceiptRulePositionResponse] =
        visitor.setReceiptRulePosition(request)
    }

    final case class TestRenderTemplateOp(
      request: TestRenderTemplateRequest
    ) extends SesOp[TestRenderTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestRenderTemplateResponse] =
        visitor.testRenderTemplate(request)
    }

    final case class UpdateAccountSendingEnabledOp(
      request: UpdateAccountSendingEnabledRequest
    ) extends SesOp[UpdateAccountSendingEnabledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountSendingEnabledResponse] =
        visitor.updateAccountSendingEnabled(request)
    }

    final case class UpdateConfigurationSetEventDestinationOp(
      request: UpdateConfigurationSetEventDestinationRequest
    ) extends SesOp[UpdateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationSetEventDestinationResponse] =
        visitor.updateConfigurationSetEventDestination(request)
    }

    final case class UpdateConfigurationSetReputationMetricsEnabledOp(
      request: UpdateConfigurationSetReputationMetricsEnabledRequest
    ) extends SesOp[UpdateConfigurationSetReputationMetricsEnabledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationSetReputationMetricsEnabledResponse] =
        visitor.updateConfigurationSetReputationMetricsEnabled(request)
    }

    final case class UpdateConfigurationSetSendingEnabledOp(
      request: UpdateConfigurationSetSendingEnabledRequest
    ) extends SesOp[UpdateConfigurationSetSendingEnabledResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationSetSendingEnabledResponse] =
        visitor.updateConfigurationSetSendingEnabled(request)
    }

    final case class UpdateConfigurationSetTrackingOptionsOp(
      request: UpdateConfigurationSetTrackingOptionsRequest
    ) extends SesOp[UpdateConfigurationSetTrackingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationSetTrackingOptionsResponse] =
        visitor.updateConfigurationSetTrackingOptions(request)
    }

    final case class UpdateCustomVerificationEmailTemplateOp(
      request: UpdateCustomVerificationEmailTemplateRequest
    ) extends SesOp[UpdateCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCustomVerificationEmailTemplateResponse] =
        visitor.updateCustomVerificationEmailTemplate(request)
    }

    final case class UpdateReceiptRuleOp(
      request: UpdateReceiptRuleRequest
    ) extends SesOp[UpdateReceiptRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReceiptRuleResponse] =
        visitor.updateReceiptRule(request)
    }

    final case class UpdateTemplateOp(
      request: UpdateTemplateRequest
    ) extends SesOp[UpdateTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTemplateResponse] =
        visitor.updateTemplate(request)
    }

    final case class VerifyDomainDkimOp(
      request: VerifyDomainDkimRequest
    ) extends SesOp[VerifyDomainDkimResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifyDomainDkimResponse] =
        visitor.verifyDomainDkim(request)
    }

    final case class VerifyDomainIdentityOp(
      request: VerifyDomainIdentityRequest
    ) extends SesOp[VerifyDomainIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifyDomainIdentityResponse] =
        visitor.verifyDomainIdentity(request)
    }

    final case class VerifyEmailAddressOp(
      request: VerifyEmailAddressRequest
    ) extends SesOp[VerifyEmailAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifyEmailAddressResponse] =
        visitor.verifyEmailAddress(request)
    }

    final case class VerifyEmailIdentityOp(
      request: VerifyEmailIdentityRequest
    ) extends SesOp[VerifyEmailIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifyEmailIdentityResponse] =
        visitor.verifyEmailIdentity(request)
    }
  }

  import SesOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SesOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cloneReceiptRuleSet(
    request: CloneReceiptRuleSetRequest
  ): SesIO[CloneReceiptRuleSetResponse] =
    FF.liftF(CloneReceiptRuleSetOp(request))

  def createConfigurationSet(
    request: CreateConfigurationSetRequest
  ): SesIO[CreateConfigurationSetResponse] =
    FF.liftF(CreateConfigurationSetOp(request))

  def createConfigurationSetEventDestination(
    request: CreateConfigurationSetEventDestinationRequest
  ): SesIO[CreateConfigurationSetEventDestinationResponse] =
    FF.liftF(CreateConfigurationSetEventDestinationOp(request))

  def createConfigurationSetTrackingOptions(
    request: CreateConfigurationSetTrackingOptionsRequest
  ): SesIO[CreateConfigurationSetTrackingOptionsResponse] =
    FF.liftF(CreateConfigurationSetTrackingOptionsOp(request))

  def createCustomVerificationEmailTemplate(
    request: CreateCustomVerificationEmailTemplateRequest
  ): SesIO[CreateCustomVerificationEmailTemplateResponse] =
    FF.liftF(CreateCustomVerificationEmailTemplateOp(request))

  def createReceiptFilter(
    request: CreateReceiptFilterRequest
  ): SesIO[CreateReceiptFilterResponse] =
    FF.liftF(CreateReceiptFilterOp(request))

  def createReceiptRule(
    request: CreateReceiptRuleRequest
  ): SesIO[CreateReceiptRuleResponse] =
    FF.liftF(CreateReceiptRuleOp(request))

  def createReceiptRuleSet(
    request: CreateReceiptRuleSetRequest
  ): SesIO[CreateReceiptRuleSetResponse] =
    FF.liftF(CreateReceiptRuleSetOp(request))

  def createTemplate(
    request: CreateTemplateRequest
  ): SesIO[CreateTemplateResponse] =
    FF.liftF(CreateTemplateOp(request))

  def deleteConfigurationSet(
    request: DeleteConfigurationSetRequest
  ): SesIO[DeleteConfigurationSetResponse] =
    FF.liftF(DeleteConfigurationSetOp(request))

  def deleteConfigurationSetEventDestination(
    request: DeleteConfigurationSetEventDestinationRequest
  ): SesIO[DeleteConfigurationSetEventDestinationResponse] =
    FF.liftF(DeleteConfigurationSetEventDestinationOp(request))

  def deleteConfigurationSetTrackingOptions(
    request: DeleteConfigurationSetTrackingOptionsRequest
  ): SesIO[DeleteConfigurationSetTrackingOptionsResponse] =
    FF.liftF(DeleteConfigurationSetTrackingOptionsOp(request))

  def deleteCustomVerificationEmailTemplate(
    request: DeleteCustomVerificationEmailTemplateRequest
  ): SesIO[DeleteCustomVerificationEmailTemplateResponse] =
    FF.liftF(DeleteCustomVerificationEmailTemplateOp(request))

  def deleteIdentity(
    request: DeleteIdentityRequest
  ): SesIO[DeleteIdentityResponse] =
    FF.liftF(DeleteIdentityOp(request))

  def deleteIdentityPolicy(
    request: DeleteIdentityPolicyRequest
  ): SesIO[DeleteIdentityPolicyResponse] =
    FF.liftF(DeleteIdentityPolicyOp(request))

  def deleteReceiptFilter(
    request: DeleteReceiptFilterRequest
  ): SesIO[DeleteReceiptFilterResponse] =
    FF.liftF(DeleteReceiptFilterOp(request))

  def deleteReceiptRule(
    request: DeleteReceiptRuleRequest
  ): SesIO[DeleteReceiptRuleResponse] =
    FF.liftF(DeleteReceiptRuleOp(request))

  def deleteReceiptRuleSet(
    request: DeleteReceiptRuleSetRequest
  ): SesIO[DeleteReceiptRuleSetResponse] =
    FF.liftF(DeleteReceiptRuleSetOp(request))

  def deleteTemplate(
    request: DeleteTemplateRequest
  ): SesIO[DeleteTemplateResponse] =
    FF.liftF(DeleteTemplateOp(request))

  def deleteVerifiedEmailAddress(
    request: DeleteVerifiedEmailAddressRequest
  ): SesIO[DeleteVerifiedEmailAddressResponse] =
    FF.liftF(DeleteVerifiedEmailAddressOp(request))

  def describeActiveReceiptRuleSet(
    request: DescribeActiveReceiptRuleSetRequest
  ): SesIO[DescribeActiveReceiptRuleSetResponse] =
    FF.liftF(DescribeActiveReceiptRuleSetOp(request))

  def describeConfigurationSet(
    request: DescribeConfigurationSetRequest
  ): SesIO[DescribeConfigurationSetResponse] =
    FF.liftF(DescribeConfigurationSetOp(request))

  def describeReceiptRule(
    request: DescribeReceiptRuleRequest
  ): SesIO[DescribeReceiptRuleResponse] =
    FF.liftF(DescribeReceiptRuleOp(request))

  def describeReceiptRuleSet(
    request: DescribeReceiptRuleSetRequest
  ): SesIO[DescribeReceiptRuleSetResponse] =
    FF.liftF(DescribeReceiptRuleSetOp(request))

  def getAccountSendingEnabled(
    request: GetAccountSendingEnabledRequest
  ): SesIO[GetAccountSendingEnabledResponse] =
    FF.liftF(GetAccountSendingEnabledOp(request))

  def getCustomVerificationEmailTemplate(
    request: GetCustomVerificationEmailTemplateRequest
  ): SesIO[GetCustomVerificationEmailTemplateResponse] =
    FF.liftF(GetCustomVerificationEmailTemplateOp(request))

  def getIdentityDkimAttributes(
    request: GetIdentityDkimAttributesRequest
  ): SesIO[GetIdentityDkimAttributesResponse] =
    FF.liftF(GetIdentityDkimAttributesOp(request))

  def getIdentityMailFromDomainAttributes(
    request: GetIdentityMailFromDomainAttributesRequest
  ): SesIO[GetIdentityMailFromDomainAttributesResponse] =
    FF.liftF(GetIdentityMailFromDomainAttributesOp(request))

  def getIdentityNotificationAttributes(
    request: GetIdentityNotificationAttributesRequest
  ): SesIO[GetIdentityNotificationAttributesResponse] =
    FF.liftF(GetIdentityNotificationAttributesOp(request))

  def getIdentityPolicies(
    request: GetIdentityPoliciesRequest
  ): SesIO[GetIdentityPoliciesResponse] =
    FF.liftF(GetIdentityPoliciesOp(request))

  def getIdentityVerificationAttributes(
    request: GetIdentityVerificationAttributesRequest
  ): SesIO[GetIdentityVerificationAttributesResponse] =
    FF.liftF(GetIdentityVerificationAttributesOp(request))

  def getSendQuota(
    request: GetSendQuotaRequest
  ): SesIO[GetSendQuotaResponse] =
    FF.liftF(GetSendQuotaOp(request))

  def getSendStatistics(
    request: GetSendStatisticsRequest
  ): SesIO[GetSendStatisticsResponse] =
    FF.liftF(GetSendStatisticsOp(request))

  def getTemplate(
    request: GetTemplateRequest
  ): SesIO[GetTemplateResponse] =
    FF.liftF(GetTemplateOp(request))

  def listConfigurationSets(
    request: ListConfigurationSetsRequest
  ): SesIO[ListConfigurationSetsResponse] =
    FF.liftF(ListConfigurationSetsOp(request))

  def listCustomVerificationEmailTemplates(
    request: ListCustomVerificationEmailTemplatesRequest
  ): SesIO[ListCustomVerificationEmailTemplatesResponse] =
    FF.liftF(ListCustomVerificationEmailTemplatesOp(request))

  def listIdentities(
    request: ListIdentitiesRequest
  ): SesIO[ListIdentitiesResponse] =
    FF.liftF(ListIdentitiesOp(request))

  def listIdentityPolicies(
    request: ListIdentityPoliciesRequest
  ): SesIO[ListIdentityPoliciesResponse] =
    FF.liftF(ListIdentityPoliciesOp(request))

  def listReceiptFilters(
    request: ListReceiptFiltersRequest
  ): SesIO[ListReceiptFiltersResponse] =
    FF.liftF(ListReceiptFiltersOp(request))

  def listReceiptRuleSets(
    request: ListReceiptRuleSetsRequest
  ): SesIO[ListReceiptRuleSetsResponse] =
    FF.liftF(ListReceiptRuleSetsOp(request))

  def listTemplates(
    request: ListTemplatesRequest
  ): SesIO[ListTemplatesResponse] =
    FF.liftF(ListTemplatesOp(request))

  def listVerifiedEmailAddresses(
    request: ListVerifiedEmailAddressesRequest
  ): SesIO[ListVerifiedEmailAddressesResponse] =
    FF.liftF(ListVerifiedEmailAddressesOp(request))

  def putConfigurationSetDeliveryOptions(
    request: PutConfigurationSetDeliveryOptionsRequest
  ): SesIO[PutConfigurationSetDeliveryOptionsResponse] =
    FF.liftF(PutConfigurationSetDeliveryOptionsOp(request))

  def putIdentityPolicy(
    request: PutIdentityPolicyRequest
  ): SesIO[PutIdentityPolicyResponse] =
    FF.liftF(PutIdentityPolicyOp(request))

  def reorderReceiptRuleSet(
    request: ReorderReceiptRuleSetRequest
  ): SesIO[ReorderReceiptRuleSetResponse] =
    FF.liftF(ReorderReceiptRuleSetOp(request))

  def sendBounce(
    request: SendBounceRequest
  ): SesIO[SendBounceResponse] =
    FF.liftF(SendBounceOp(request))

  def sendBulkTemplatedEmail(
    request: SendBulkTemplatedEmailRequest
  ): SesIO[SendBulkTemplatedEmailResponse] =
    FF.liftF(SendBulkTemplatedEmailOp(request))

  def sendCustomVerificationEmail(
    request: SendCustomVerificationEmailRequest
  ): SesIO[SendCustomVerificationEmailResponse] =
    FF.liftF(SendCustomVerificationEmailOp(request))

  def sendEmail(
    request: SendEmailRequest
  ): SesIO[SendEmailResponse] =
    FF.liftF(SendEmailOp(request))

  def sendRawEmail(
    request: SendRawEmailRequest
  ): SesIO[SendRawEmailResponse] =
    FF.liftF(SendRawEmailOp(request))

  def sendTemplatedEmail(
    request: SendTemplatedEmailRequest
  ): SesIO[SendTemplatedEmailResponse] =
    FF.liftF(SendTemplatedEmailOp(request))

  def setActiveReceiptRuleSet(
    request: SetActiveReceiptRuleSetRequest
  ): SesIO[SetActiveReceiptRuleSetResponse] =
    FF.liftF(SetActiveReceiptRuleSetOp(request))

  def setIdentityDkimEnabled(
    request: SetIdentityDkimEnabledRequest
  ): SesIO[SetIdentityDkimEnabledResponse] =
    FF.liftF(SetIdentityDkimEnabledOp(request))

  def setIdentityFeedbackForwardingEnabled(
    request: SetIdentityFeedbackForwardingEnabledRequest
  ): SesIO[SetIdentityFeedbackForwardingEnabledResponse] =
    FF.liftF(SetIdentityFeedbackForwardingEnabledOp(request))

  def setIdentityHeadersInNotificationsEnabled(
    request: SetIdentityHeadersInNotificationsEnabledRequest
  ): SesIO[SetIdentityHeadersInNotificationsEnabledResponse] =
    FF.liftF(SetIdentityHeadersInNotificationsEnabledOp(request))

  def setIdentityMailFromDomain(
    request: SetIdentityMailFromDomainRequest
  ): SesIO[SetIdentityMailFromDomainResponse] =
    FF.liftF(SetIdentityMailFromDomainOp(request))

  def setIdentityNotificationTopic(
    request: SetIdentityNotificationTopicRequest
  ): SesIO[SetIdentityNotificationTopicResponse] =
    FF.liftF(SetIdentityNotificationTopicOp(request))

  def setReceiptRulePosition(
    request: SetReceiptRulePositionRequest
  ): SesIO[SetReceiptRulePositionResponse] =
    FF.liftF(SetReceiptRulePositionOp(request))

  def testRenderTemplate(
    request: TestRenderTemplateRequest
  ): SesIO[TestRenderTemplateResponse] =
    FF.liftF(TestRenderTemplateOp(request))

  def updateAccountSendingEnabled(
    request: UpdateAccountSendingEnabledRequest
  ): SesIO[UpdateAccountSendingEnabledResponse] =
    FF.liftF(UpdateAccountSendingEnabledOp(request))

  def updateConfigurationSetEventDestination(
    request: UpdateConfigurationSetEventDestinationRequest
  ): SesIO[UpdateConfigurationSetEventDestinationResponse] =
    FF.liftF(UpdateConfigurationSetEventDestinationOp(request))

  def updateConfigurationSetReputationMetricsEnabled(
    request: UpdateConfigurationSetReputationMetricsEnabledRequest
  ): SesIO[UpdateConfigurationSetReputationMetricsEnabledResponse] =
    FF.liftF(UpdateConfigurationSetReputationMetricsEnabledOp(request))

  def updateConfigurationSetSendingEnabled(
    request: UpdateConfigurationSetSendingEnabledRequest
  ): SesIO[UpdateConfigurationSetSendingEnabledResponse] =
    FF.liftF(UpdateConfigurationSetSendingEnabledOp(request))

  def updateConfigurationSetTrackingOptions(
    request: UpdateConfigurationSetTrackingOptionsRequest
  ): SesIO[UpdateConfigurationSetTrackingOptionsResponse] =
    FF.liftF(UpdateConfigurationSetTrackingOptionsOp(request))

  def updateCustomVerificationEmailTemplate(
    request: UpdateCustomVerificationEmailTemplateRequest
  ): SesIO[UpdateCustomVerificationEmailTemplateResponse] =
    FF.liftF(UpdateCustomVerificationEmailTemplateOp(request))

  def updateReceiptRule(
    request: UpdateReceiptRuleRequest
  ): SesIO[UpdateReceiptRuleResponse] =
    FF.liftF(UpdateReceiptRuleOp(request))

  def updateTemplate(
    request: UpdateTemplateRequest
  ): SesIO[UpdateTemplateResponse] =
    FF.liftF(UpdateTemplateOp(request))

  def verifyDomainDkim(
    request: VerifyDomainDkimRequest
  ): SesIO[VerifyDomainDkimResponse] =
    FF.liftF(VerifyDomainDkimOp(request))

  def verifyDomainIdentity(
    request: VerifyDomainIdentityRequest
  ): SesIO[VerifyDomainIdentityResponse] =
    FF.liftF(VerifyDomainIdentityOp(request))

  def verifyEmailAddress(
    request: VerifyEmailAddressRequest
  ): SesIO[VerifyEmailAddressResponse] =
    FF.liftF(VerifyEmailAddressOp(request))

  def verifyEmailIdentity(
    request: VerifyEmailIdentityRequest
  ): SesIO[VerifyEmailIdentityResponse] =
    FF.liftF(VerifyEmailIdentityOp(request))
}
