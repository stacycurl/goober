package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sesv2.SesV2Client
import software.amazon.awssdk.services.sesv2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object sesv2 { module =>

  // Free monad over SesV2Op
  type SesV2IO[A] = FF[SesV2Op, A]

  sealed trait SesV2Op[A] {
    def visit[F[_]](visitor: SesV2Op.Visitor[F]): F[A]
  }

  object SesV2Op {
    // Given a SesV2Client we can embed a SesV2IO program in any algebra that understands embedding.
    implicit val SesV2OpEmbeddable: Embeddable[SesV2Op, SesV2Client] = new Embeddable[SesV2Op, SesV2Client] {
      def embed[A](client: SesV2Client, io: SesV2IO[A]): Embedded[A] = Embedded.SesV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SesV2Op.Visitor[Kleisli[M, SesV2Client, *]] {
        def createConfigurationSet(
          request: CreateConfigurationSetRequest
        ): Kleisli[M, SesV2Client, CreateConfigurationSetResponse] =
          primitive(_.createConfigurationSet(request))

        def createConfigurationSetEventDestination(
          request: CreateConfigurationSetEventDestinationRequest
        ): Kleisli[M, SesV2Client, CreateConfigurationSetEventDestinationResponse] =
          primitive(_.createConfigurationSetEventDestination(request))

        def createContact(
          request: CreateContactRequest
        ): Kleisli[M, SesV2Client, CreateContactResponse] =
          primitive(_.createContact(request))

        def createContactList(
          request: CreateContactListRequest
        ): Kleisli[M, SesV2Client, CreateContactListResponse] =
          primitive(_.createContactList(request))

        def createCustomVerificationEmailTemplate(
          request: CreateCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesV2Client, CreateCustomVerificationEmailTemplateResponse] =
          primitive(_.createCustomVerificationEmailTemplate(request))

        def createDedicatedIpPool(
          request: CreateDedicatedIpPoolRequest
        ): Kleisli[M, SesV2Client, CreateDedicatedIpPoolResponse] =
          primitive(_.createDedicatedIpPool(request))

        def createDeliverabilityTestReport(
          request: CreateDeliverabilityTestReportRequest
        ): Kleisli[M, SesV2Client, CreateDeliverabilityTestReportResponse] =
          primitive(_.createDeliverabilityTestReport(request))

        def createEmailIdentity(
          request: CreateEmailIdentityRequest
        ): Kleisli[M, SesV2Client, CreateEmailIdentityResponse] =
          primitive(_.createEmailIdentity(request))

        def createEmailIdentityPolicy(
          request: CreateEmailIdentityPolicyRequest
        ): Kleisli[M, SesV2Client, CreateEmailIdentityPolicyResponse] =
          primitive(_.createEmailIdentityPolicy(request))

        def createEmailTemplate(
          request: CreateEmailTemplateRequest
        ): Kleisli[M, SesV2Client, CreateEmailTemplateResponse] =
          primitive(_.createEmailTemplate(request))

        def createImportJob(
          request: CreateImportJobRequest
        ): Kleisli[M, SesV2Client, CreateImportJobResponse] =
          primitive(_.createImportJob(request))

        def deleteConfigurationSet(
          request: DeleteConfigurationSetRequest
        ): Kleisli[M, SesV2Client, DeleteConfigurationSetResponse] =
          primitive(_.deleteConfigurationSet(request))

        def deleteConfigurationSetEventDestination(
          request: DeleteConfigurationSetEventDestinationRequest
        ): Kleisli[M, SesV2Client, DeleteConfigurationSetEventDestinationResponse] =
          primitive(_.deleteConfigurationSetEventDestination(request))

        def deleteContact(
          request: DeleteContactRequest
        ): Kleisli[M, SesV2Client, DeleteContactResponse] =
          primitive(_.deleteContact(request))

        def deleteContactList(
          request: DeleteContactListRequest
        ): Kleisli[M, SesV2Client, DeleteContactListResponse] =
          primitive(_.deleteContactList(request))

        def deleteCustomVerificationEmailTemplate(
          request: DeleteCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesV2Client, DeleteCustomVerificationEmailTemplateResponse] =
          primitive(_.deleteCustomVerificationEmailTemplate(request))

        def deleteDedicatedIpPool(
          request: DeleteDedicatedIpPoolRequest
        ): Kleisli[M, SesV2Client, DeleteDedicatedIpPoolResponse] =
          primitive(_.deleteDedicatedIpPool(request))

        def deleteEmailIdentity(
          request: DeleteEmailIdentityRequest
        ): Kleisli[M, SesV2Client, DeleteEmailIdentityResponse] =
          primitive(_.deleteEmailIdentity(request))

        def deleteEmailIdentityPolicy(
          request: DeleteEmailIdentityPolicyRequest
        ): Kleisli[M, SesV2Client, DeleteEmailIdentityPolicyResponse] =
          primitive(_.deleteEmailIdentityPolicy(request))

        def deleteEmailTemplate(
          request: DeleteEmailTemplateRequest
        ): Kleisli[M, SesV2Client, DeleteEmailTemplateResponse] =
          primitive(_.deleteEmailTemplate(request))

        def deleteSuppressedDestination(
          request: DeleteSuppressedDestinationRequest
        ): Kleisli[M, SesV2Client, DeleteSuppressedDestinationResponse] =
          primitive(_.deleteSuppressedDestination(request))

        def getAccount(
          request: GetAccountRequest
        ): Kleisli[M, SesV2Client, GetAccountResponse] =
          primitive(_.getAccount(request))

        def getBlacklistReports(
          request: GetBlacklistReportsRequest
        ): Kleisli[M, SesV2Client, GetBlacklistReportsResponse] =
          primitive(_.getBlacklistReports(request))

        def getConfigurationSet(
          request: GetConfigurationSetRequest
        ): Kleisli[M, SesV2Client, GetConfigurationSetResponse] =
          primitive(_.getConfigurationSet(request))

        def getConfigurationSetEventDestinations(
          request: GetConfigurationSetEventDestinationsRequest
        ): Kleisli[M, SesV2Client, GetConfigurationSetEventDestinationsResponse] =
          primitive(_.getConfigurationSetEventDestinations(request))

        def getContact(
          request: GetContactRequest
        ): Kleisli[M, SesV2Client, GetContactResponse] =
          primitive(_.getContact(request))

        def getContactList(
          request: GetContactListRequest
        ): Kleisli[M, SesV2Client, GetContactListResponse] =
          primitive(_.getContactList(request))

        def getCustomVerificationEmailTemplate(
          request: GetCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesV2Client, GetCustomVerificationEmailTemplateResponse] =
          primitive(_.getCustomVerificationEmailTemplate(request))

        def getDedicatedIp(
          request: GetDedicatedIpRequest
        ): Kleisli[M, SesV2Client, GetDedicatedIpResponse] =
          primitive(_.getDedicatedIp(request))

        def getDedicatedIps(
          request: GetDedicatedIpsRequest
        ): Kleisli[M, SesV2Client, GetDedicatedIpsResponse] =
          primitive(_.getDedicatedIps(request))

        def getDeliverabilityDashboardOptions(
          request: GetDeliverabilityDashboardOptionsRequest
        ): Kleisli[M, SesV2Client, GetDeliverabilityDashboardOptionsResponse] =
          primitive(_.getDeliverabilityDashboardOptions(request))

        def getDeliverabilityTestReport(
          request: GetDeliverabilityTestReportRequest
        ): Kleisli[M, SesV2Client, GetDeliverabilityTestReportResponse] =
          primitive(_.getDeliverabilityTestReport(request))

        def getDomainDeliverabilityCampaign(
          request: GetDomainDeliverabilityCampaignRequest
        ): Kleisli[M, SesV2Client, GetDomainDeliverabilityCampaignResponse] =
          primitive(_.getDomainDeliverabilityCampaign(request))

        def getDomainStatisticsReport(
          request: GetDomainStatisticsReportRequest
        ): Kleisli[M, SesV2Client, GetDomainStatisticsReportResponse] =
          primitive(_.getDomainStatisticsReport(request))

        def getEmailIdentity(
          request: GetEmailIdentityRequest
        ): Kleisli[M, SesV2Client, GetEmailIdentityResponse] =
          primitive(_.getEmailIdentity(request))

        def getEmailIdentityPolicies(
          request: GetEmailIdentityPoliciesRequest
        ): Kleisli[M, SesV2Client, GetEmailIdentityPoliciesResponse] =
          primitive(_.getEmailIdentityPolicies(request))

        def getEmailTemplate(
          request: GetEmailTemplateRequest
        ): Kleisli[M, SesV2Client, GetEmailTemplateResponse] =
          primitive(_.getEmailTemplate(request))

        def getImportJob(
          request: GetImportJobRequest
        ): Kleisli[M, SesV2Client, GetImportJobResponse] =
          primitive(_.getImportJob(request))

        def getSuppressedDestination(
          request: GetSuppressedDestinationRequest
        ): Kleisli[M, SesV2Client, GetSuppressedDestinationResponse] =
          primitive(_.getSuppressedDestination(request))

        def listConfigurationSets(
          request: ListConfigurationSetsRequest
        ): Kleisli[M, SesV2Client, ListConfigurationSetsResponse] =
          primitive(_.listConfigurationSets(request))

        def listContactLists(
          request: ListContactListsRequest
        ): Kleisli[M, SesV2Client, ListContactListsResponse] =
          primitive(_.listContactLists(request))

        def listContacts(
          request: ListContactsRequest
        ): Kleisli[M, SesV2Client, ListContactsResponse] =
          primitive(_.listContacts(request))

        def listCustomVerificationEmailTemplates(
          request: ListCustomVerificationEmailTemplatesRequest
        ): Kleisli[M, SesV2Client, ListCustomVerificationEmailTemplatesResponse] =
          primitive(_.listCustomVerificationEmailTemplates(request))

        def listDedicatedIpPools(
          request: ListDedicatedIpPoolsRequest
        ): Kleisli[M, SesV2Client, ListDedicatedIpPoolsResponse] =
          primitive(_.listDedicatedIpPools(request))

        def listDeliverabilityTestReports(
          request: ListDeliverabilityTestReportsRequest
        ): Kleisli[M, SesV2Client, ListDeliverabilityTestReportsResponse] =
          primitive(_.listDeliverabilityTestReports(request))

        def listDomainDeliverabilityCampaigns(
          request: ListDomainDeliverabilityCampaignsRequest
        ): Kleisli[M, SesV2Client, ListDomainDeliverabilityCampaignsResponse] =
          primitive(_.listDomainDeliverabilityCampaigns(request))

        def listEmailIdentities(
          request: ListEmailIdentitiesRequest
        ): Kleisli[M, SesV2Client, ListEmailIdentitiesResponse] =
          primitive(_.listEmailIdentities(request))

        def listEmailTemplates(
          request: ListEmailTemplatesRequest
        ): Kleisli[M, SesV2Client, ListEmailTemplatesResponse] =
          primitive(_.listEmailTemplates(request))

        def listImportJobs(
          request: ListImportJobsRequest
        ): Kleisli[M, SesV2Client, ListImportJobsResponse] =
          primitive(_.listImportJobs(request))

        def listSuppressedDestinations(
          request: ListSuppressedDestinationsRequest
        ): Kleisli[M, SesV2Client, ListSuppressedDestinationsResponse] =
          primitive(_.listSuppressedDestinations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SesV2Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putAccountDedicatedIpWarmupAttributes(
          request: PutAccountDedicatedIpWarmupAttributesRequest
        ): Kleisli[M, SesV2Client, PutAccountDedicatedIpWarmupAttributesResponse] =
          primitive(_.putAccountDedicatedIpWarmupAttributes(request))

        def putAccountDetails(
          request: PutAccountDetailsRequest
        ): Kleisli[M, SesV2Client, PutAccountDetailsResponse] =
          primitive(_.putAccountDetails(request))

        def putAccountSendingAttributes(
          request: PutAccountSendingAttributesRequest
        ): Kleisli[M, SesV2Client, PutAccountSendingAttributesResponse] =
          primitive(_.putAccountSendingAttributes(request))

        def putAccountSuppressionAttributes(
          request: PutAccountSuppressionAttributesRequest
        ): Kleisli[M, SesV2Client, PutAccountSuppressionAttributesResponse] =
          primitive(_.putAccountSuppressionAttributes(request))

        def putConfigurationSetDeliveryOptions(
          request: PutConfigurationSetDeliveryOptionsRequest
        ): Kleisli[M, SesV2Client, PutConfigurationSetDeliveryOptionsResponse] =
          primitive(_.putConfigurationSetDeliveryOptions(request))

        def putConfigurationSetReputationOptions(
          request: PutConfigurationSetReputationOptionsRequest
        ): Kleisli[M, SesV2Client, PutConfigurationSetReputationOptionsResponse] =
          primitive(_.putConfigurationSetReputationOptions(request))

        def putConfigurationSetSendingOptions(
          request: PutConfigurationSetSendingOptionsRequest
        ): Kleisli[M, SesV2Client, PutConfigurationSetSendingOptionsResponse] =
          primitive(_.putConfigurationSetSendingOptions(request))

        def putConfigurationSetSuppressionOptions(
          request: PutConfigurationSetSuppressionOptionsRequest
        ): Kleisli[M, SesV2Client, PutConfigurationSetSuppressionOptionsResponse] =
          primitive(_.putConfigurationSetSuppressionOptions(request))

        def putConfigurationSetTrackingOptions(
          request: PutConfigurationSetTrackingOptionsRequest
        ): Kleisli[M, SesV2Client, PutConfigurationSetTrackingOptionsResponse] =
          primitive(_.putConfigurationSetTrackingOptions(request))

        def putDedicatedIpInPool(
          request: PutDedicatedIpInPoolRequest
        ): Kleisli[M, SesV2Client, PutDedicatedIpInPoolResponse] =
          primitive(_.putDedicatedIpInPool(request))

        def putDedicatedIpWarmupAttributes(
          request: PutDedicatedIpWarmupAttributesRequest
        ): Kleisli[M, SesV2Client, PutDedicatedIpWarmupAttributesResponse] =
          primitive(_.putDedicatedIpWarmupAttributes(request))

        def putDeliverabilityDashboardOption(
          request: PutDeliverabilityDashboardOptionRequest
        ): Kleisli[M, SesV2Client, PutDeliverabilityDashboardOptionResponse] =
          primitive(_.putDeliverabilityDashboardOption(request))

        def putEmailIdentityConfigurationSetAttributes(
          request: PutEmailIdentityConfigurationSetAttributesRequest
        ): Kleisli[M, SesV2Client, PutEmailIdentityConfigurationSetAttributesResponse] =
          primitive(_.putEmailIdentityConfigurationSetAttributes(request))

        def putEmailIdentityDkimAttributes(
          request: PutEmailIdentityDkimAttributesRequest
        ): Kleisli[M, SesV2Client, PutEmailIdentityDkimAttributesResponse] =
          primitive(_.putEmailIdentityDkimAttributes(request))

        def putEmailIdentityDkimSigningAttributes(
          request: PutEmailIdentityDkimSigningAttributesRequest
        ): Kleisli[M, SesV2Client, PutEmailIdentityDkimSigningAttributesResponse] =
          primitive(_.putEmailIdentityDkimSigningAttributes(request))

        def putEmailIdentityFeedbackAttributes(
          request: PutEmailIdentityFeedbackAttributesRequest
        ): Kleisli[M, SesV2Client, PutEmailIdentityFeedbackAttributesResponse] =
          primitive(_.putEmailIdentityFeedbackAttributes(request))

        def putEmailIdentityMailFromAttributes(
          request: PutEmailIdentityMailFromAttributesRequest
        ): Kleisli[M, SesV2Client, PutEmailIdentityMailFromAttributesResponse] =
          primitive(_.putEmailIdentityMailFromAttributes(request))

        def putSuppressedDestination(
          request: PutSuppressedDestinationRequest
        ): Kleisli[M, SesV2Client, PutSuppressedDestinationResponse] =
          primitive(_.putSuppressedDestination(request))

        def sendBulkEmail(
          request: SendBulkEmailRequest
        ): Kleisli[M, SesV2Client, SendBulkEmailResponse] =
          primitive(_.sendBulkEmail(request))

        def sendCustomVerificationEmail(
          request: SendCustomVerificationEmailRequest
        ): Kleisli[M, SesV2Client, SendCustomVerificationEmailResponse] =
          primitive(_.sendCustomVerificationEmail(request))

        def sendEmail(
          request: SendEmailRequest
        ): Kleisli[M, SesV2Client, SendEmailResponse] =
          primitive(_.sendEmail(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SesV2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testRenderEmailTemplate(
          request: TestRenderEmailTemplateRequest
        ): Kleisli[M, SesV2Client, TestRenderEmailTemplateResponse] =
          primitive(_.testRenderEmailTemplate(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SesV2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateConfigurationSetEventDestination(
          request: UpdateConfigurationSetEventDestinationRequest
        ): Kleisli[M, SesV2Client, UpdateConfigurationSetEventDestinationResponse] =
          primitive(_.updateConfigurationSetEventDestination(request))

        def updateContact(
          request: UpdateContactRequest
        ): Kleisli[M, SesV2Client, UpdateContactResponse] =
          primitive(_.updateContact(request))

        def updateContactList(
          request: UpdateContactListRequest
        ): Kleisli[M, SesV2Client, UpdateContactListResponse] =
          primitive(_.updateContactList(request))

        def updateCustomVerificationEmailTemplate(
          request: UpdateCustomVerificationEmailTemplateRequest
        ): Kleisli[M, SesV2Client, UpdateCustomVerificationEmailTemplateResponse] =
          primitive(_.updateCustomVerificationEmailTemplate(request))

        def updateEmailIdentityPolicy(
          request: UpdateEmailIdentityPolicyRequest
        ): Kleisli[M, SesV2Client, UpdateEmailIdentityPolicyResponse] =
          primitive(_.updateEmailIdentityPolicy(request))

        def updateEmailTemplate(
          request: UpdateEmailTemplateRequest
        ): Kleisli[M, SesV2Client, UpdateEmailTemplateResponse] =
          primitive(_.updateEmailTemplate(request))

        def primitive[A](
          f: SesV2Client => A
        ): Kleisli[M, SesV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (SesV2Op ~> F) {
      final def apply[A](op: SesV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createConfigurationSet(
        request: CreateConfigurationSetRequest
      ): F[CreateConfigurationSetResponse]

      def createConfigurationSetEventDestination(
        request: CreateConfigurationSetEventDestinationRequest
      ): F[CreateConfigurationSetEventDestinationResponse]

      def createContact(
        request: CreateContactRequest
      ): F[CreateContactResponse]

      def createContactList(
        request: CreateContactListRequest
      ): F[CreateContactListResponse]

      def createCustomVerificationEmailTemplate(
        request: CreateCustomVerificationEmailTemplateRequest
      ): F[CreateCustomVerificationEmailTemplateResponse]

      def createDedicatedIpPool(
        request: CreateDedicatedIpPoolRequest
      ): F[CreateDedicatedIpPoolResponse]

      def createDeliverabilityTestReport(
        request: CreateDeliverabilityTestReportRequest
      ): F[CreateDeliverabilityTestReportResponse]

      def createEmailIdentity(
        request: CreateEmailIdentityRequest
      ): F[CreateEmailIdentityResponse]

      def createEmailIdentityPolicy(
        request: CreateEmailIdentityPolicyRequest
      ): F[CreateEmailIdentityPolicyResponse]

      def createEmailTemplate(
        request: CreateEmailTemplateRequest
      ): F[CreateEmailTemplateResponse]

      def createImportJob(
        request: CreateImportJobRequest
      ): F[CreateImportJobResponse]

      def deleteConfigurationSet(
        request: DeleteConfigurationSetRequest
      ): F[DeleteConfigurationSetResponse]

      def deleteConfigurationSetEventDestination(
        request: DeleteConfigurationSetEventDestinationRequest
      ): F[DeleteConfigurationSetEventDestinationResponse]

      def deleteContact(
        request: DeleteContactRequest
      ): F[DeleteContactResponse]

      def deleteContactList(
        request: DeleteContactListRequest
      ): F[DeleteContactListResponse]

      def deleteCustomVerificationEmailTemplate(
        request: DeleteCustomVerificationEmailTemplateRequest
      ): F[DeleteCustomVerificationEmailTemplateResponse]

      def deleteDedicatedIpPool(
        request: DeleteDedicatedIpPoolRequest
      ): F[DeleteDedicatedIpPoolResponse]

      def deleteEmailIdentity(
        request: DeleteEmailIdentityRequest
      ): F[DeleteEmailIdentityResponse]

      def deleteEmailIdentityPolicy(
        request: DeleteEmailIdentityPolicyRequest
      ): F[DeleteEmailIdentityPolicyResponse]

      def deleteEmailTemplate(
        request: DeleteEmailTemplateRequest
      ): F[DeleteEmailTemplateResponse]

      def deleteSuppressedDestination(
        request: DeleteSuppressedDestinationRequest
      ): F[DeleteSuppressedDestinationResponse]

      def getAccount(
        request: GetAccountRequest
      ): F[GetAccountResponse]

      def getBlacklistReports(
        request: GetBlacklistReportsRequest
      ): F[GetBlacklistReportsResponse]

      def getConfigurationSet(
        request: GetConfigurationSetRequest
      ): F[GetConfigurationSetResponse]

      def getConfigurationSetEventDestinations(
        request: GetConfigurationSetEventDestinationsRequest
      ): F[GetConfigurationSetEventDestinationsResponse]

      def getContact(
        request: GetContactRequest
      ): F[GetContactResponse]

      def getContactList(
        request: GetContactListRequest
      ): F[GetContactListResponse]

      def getCustomVerificationEmailTemplate(
        request: GetCustomVerificationEmailTemplateRequest
      ): F[GetCustomVerificationEmailTemplateResponse]

      def getDedicatedIp(
        request: GetDedicatedIpRequest
      ): F[GetDedicatedIpResponse]

      def getDedicatedIps(
        request: GetDedicatedIpsRequest
      ): F[GetDedicatedIpsResponse]

      def getDeliverabilityDashboardOptions(
        request: GetDeliverabilityDashboardOptionsRequest
      ): F[GetDeliverabilityDashboardOptionsResponse]

      def getDeliverabilityTestReport(
        request: GetDeliverabilityTestReportRequest
      ): F[GetDeliverabilityTestReportResponse]

      def getDomainDeliverabilityCampaign(
        request: GetDomainDeliverabilityCampaignRequest
      ): F[GetDomainDeliverabilityCampaignResponse]

      def getDomainStatisticsReport(
        request: GetDomainStatisticsReportRequest
      ): F[GetDomainStatisticsReportResponse]

      def getEmailIdentity(
        request: GetEmailIdentityRequest
      ): F[GetEmailIdentityResponse]

      def getEmailIdentityPolicies(
        request: GetEmailIdentityPoliciesRequest
      ): F[GetEmailIdentityPoliciesResponse]

      def getEmailTemplate(
        request: GetEmailTemplateRequest
      ): F[GetEmailTemplateResponse]

      def getImportJob(
        request: GetImportJobRequest
      ): F[GetImportJobResponse]

      def getSuppressedDestination(
        request: GetSuppressedDestinationRequest
      ): F[GetSuppressedDestinationResponse]

      def listConfigurationSets(
        request: ListConfigurationSetsRequest
      ): F[ListConfigurationSetsResponse]

      def listContactLists(
        request: ListContactListsRequest
      ): F[ListContactListsResponse]

      def listContacts(
        request: ListContactsRequest
      ): F[ListContactsResponse]

      def listCustomVerificationEmailTemplates(
        request: ListCustomVerificationEmailTemplatesRequest
      ): F[ListCustomVerificationEmailTemplatesResponse]

      def listDedicatedIpPools(
        request: ListDedicatedIpPoolsRequest
      ): F[ListDedicatedIpPoolsResponse]

      def listDeliverabilityTestReports(
        request: ListDeliverabilityTestReportsRequest
      ): F[ListDeliverabilityTestReportsResponse]

      def listDomainDeliverabilityCampaigns(
        request: ListDomainDeliverabilityCampaignsRequest
      ): F[ListDomainDeliverabilityCampaignsResponse]

      def listEmailIdentities(
        request: ListEmailIdentitiesRequest
      ): F[ListEmailIdentitiesResponse]

      def listEmailTemplates(
        request: ListEmailTemplatesRequest
      ): F[ListEmailTemplatesResponse]

      def listImportJobs(
        request: ListImportJobsRequest
      ): F[ListImportJobsResponse]

      def listSuppressedDestinations(
        request: ListSuppressedDestinationsRequest
      ): F[ListSuppressedDestinationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putAccountDedicatedIpWarmupAttributes(
        request: PutAccountDedicatedIpWarmupAttributesRequest
      ): F[PutAccountDedicatedIpWarmupAttributesResponse]

      def putAccountDetails(
        request: PutAccountDetailsRequest
      ): F[PutAccountDetailsResponse]

      def putAccountSendingAttributes(
        request: PutAccountSendingAttributesRequest
      ): F[PutAccountSendingAttributesResponse]

      def putAccountSuppressionAttributes(
        request: PutAccountSuppressionAttributesRequest
      ): F[PutAccountSuppressionAttributesResponse]

      def putConfigurationSetDeliveryOptions(
        request: PutConfigurationSetDeliveryOptionsRequest
      ): F[PutConfigurationSetDeliveryOptionsResponse]

      def putConfigurationSetReputationOptions(
        request: PutConfigurationSetReputationOptionsRequest
      ): F[PutConfigurationSetReputationOptionsResponse]

      def putConfigurationSetSendingOptions(
        request: PutConfigurationSetSendingOptionsRequest
      ): F[PutConfigurationSetSendingOptionsResponse]

      def putConfigurationSetSuppressionOptions(
        request: PutConfigurationSetSuppressionOptionsRequest
      ): F[PutConfigurationSetSuppressionOptionsResponse]

      def putConfigurationSetTrackingOptions(
        request: PutConfigurationSetTrackingOptionsRequest
      ): F[PutConfigurationSetTrackingOptionsResponse]

      def putDedicatedIpInPool(
        request: PutDedicatedIpInPoolRequest
      ): F[PutDedicatedIpInPoolResponse]

      def putDedicatedIpWarmupAttributes(
        request: PutDedicatedIpWarmupAttributesRequest
      ): F[PutDedicatedIpWarmupAttributesResponse]

      def putDeliverabilityDashboardOption(
        request: PutDeliverabilityDashboardOptionRequest
      ): F[PutDeliverabilityDashboardOptionResponse]

      def putEmailIdentityConfigurationSetAttributes(
        request: PutEmailIdentityConfigurationSetAttributesRequest
      ): F[PutEmailIdentityConfigurationSetAttributesResponse]

      def putEmailIdentityDkimAttributes(
        request: PutEmailIdentityDkimAttributesRequest
      ): F[PutEmailIdentityDkimAttributesResponse]

      def putEmailIdentityDkimSigningAttributes(
        request: PutEmailIdentityDkimSigningAttributesRequest
      ): F[PutEmailIdentityDkimSigningAttributesResponse]

      def putEmailIdentityFeedbackAttributes(
        request: PutEmailIdentityFeedbackAttributesRequest
      ): F[PutEmailIdentityFeedbackAttributesResponse]

      def putEmailIdentityMailFromAttributes(
        request: PutEmailIdentityMailFromAttributesRequest
      ): F[PutEmailIdentityMailFromAttributesResponse]

      def putSuppressedDestination(
        request: PutSuppressedDestinationRequest
      ): F[PutSuppressedDestinationResponse]

      def sendBulkEmail(
        request: SendBulkEmailRequest
      ): F[SendBulkEmailResponse]

      def sendCustomVerificationEmail(
        request: SendCustomVerificationEmailRequest
      ): F[SendCustomVerificationEmailResponse]

      def sendEmail(
        request: SendEmailRequest
      ): F[SendEmailResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testRenderEmailTemplate(
        request: TestRenderEmailTemplateRequest
      ): F[TestRenderEmailTemplateResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateConfigurationSetEventDestination(
        request: UpdateConfigurationSetEventDestinationRequest
      ): F[UpdateConfigurationSetEventDestinationResponse]

      def updateContact(
        request: UpdateContactRequest
      ): F[UpdateContactResponse]

      def updateContactList(
        request: UpdateContactListRequest
      ): F[UpdateContactListResponse]

      def updateCustomVerificationEmailTemplate(
        request: UpdateCustomVerificationEmailTemplateRequest
      ): F[UpdateCustomVerificationEmailTemplateResponse]

      def updateEmailIdentityPolicy(
        request: UpdateEmailIdentityPolicyRequest
      ): F[UpdateEmailIdentityPolicyResponse]

      def updateEmailTemplate(
        request: UpdateEmailTemplateRequest
      ): F[UpdateEmailTemplateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SesV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateConfigurationSetOp(
      request: CreateConfigurationSetRequest
    ) extends SesV2Op[CreateConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetResponse] =
        visitor.createConfigurationSet(request)
    }

    final case class CreateConfigurationSetEventDestinationOp(
      request: CreateConfigurationSetEventDestinationRequest
    ) extends SesV2Op[CreateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetEventDestinationResponse] =
        visitor.createConfigurationSetEventDestination(request)
    }

    final case class CreateContactOp(
      request: CreateContactRequest
    ) extends SesV2Op[CreateContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContactResponse] =
        visitor.createContact(request)
    }

    final case class CreateContactListOp(
      request: CreateContactListRequest
    ) extends SesV2Op[CreateContactListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContactListResponse] =
        visitor.createContactList(request)
    }

    final case class CreateCustomVerificationEmailTemplateOp(
      request: CreateCustomVerificationEmailTemplateRequest
    ) extends SesV2Op[CreateCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomVerificationEmailTemplateResponse] =
        visitor.createCustomVerificationEmailTemplate(request)
    }

    final case class CreateDedicatedIpPoolOp(
      request: CreateDedicatedIpPoolRequest
    ) extends SesV2Op[CreateDedicatedIpPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDedicatedIpPoolResponse] =
        visitor.createDedicatedIpPool(request)
    }

    final case class CreateDeliverabilityTestReportOp(
      request: CreateDeliverabilityTestReportRequest
    ) extends SesV2Op[CreateDeliverabilityTestReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeliverabilityTestReportResponse] =
        visitor.createDeliverabilityTestReport(request)
    }

    final case class CreateEmailIdentityOp(
      request: CreateEmailIdentityRequest
    ) extends SesV2Op[CreateEmailIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEmailIdentityResponse] =
        visitor.createEmailIdentity(request)
    }

    final case class CreateEmailIdentityPolicyOp(
      request: CreateEmailIdentityPolicyRequest
    ) extends SesV2Op[CreateEmailIdentityPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEmailIdentityPolicyResponse] =
        visitor.createEmailIdentityPolicy(request)
    }

    final case class CreateEmailTemplateOp(
      request: CreateEmailTemplateRequest
    ) extends SesV2Op[CreateEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEmailTemplateResponse] =
        visitor.createEmailTemplate(request)
    }

    final case class CreateImportJobOp(
      request: CreateImportJobRequest
    ) extends SesV2Op[CreateImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImportJobResponse] =
        visitor.createImportJob(request)
    }

    final case class DeleteConfigurationSetOp(
      request: DeleteConfigurationSetRequest
    ) extends SesV2Op[DeleteConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetResponse] =
        visitor.deleteConfigurationSet(request)
    }

    final case class DeleteConfigurationSetEventDestinationOp(
      request: DeleteConfigurationSetEventDestinationRequest
    ) extends SesV2Op[DeleteConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetEventDestinationResponse] =
        visitor.deleteConfigurationSetEventDestination(request)
    }

    final case class DeleteContactOp(
      request: DeleteContactRequest
    ) extends SesV2Op[DeleteContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContactResponse] =
        visitor.deleteContact(request)
    }

    final case class DeleteContactListOp(
      request: DeleteContactListRequest
    ) extends SesV2Op[DeleteContactListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContactListResponse] =
        visitor.deleteContactList(request)
    }

    final case class DeleteCustomVerificationEmailTemplateOp(
      request: DeleteCustomVerificationEmailTemplateRequest
    ) extends SesV2Op[DeleteCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomVerificationEmailTemplateResponse] =
        visitor.deleteCustomVerificationEmailTemplate(request)
    }

    final case class DeleteDedicatedIpPoolOp(
      request: DeleteDedicatedIpPoolRequest
    ) extends SesV2Op[DeleteDedicatedIpPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDedicatedIpPoolResponse] =
        visitor.deleteDedicatedIpPool(request)
    }

    final case class DeleteEmailIdentityOp(
      request: DeleteEmailIdentityRequest
    ) extends SesV2Op[DeleteEmailIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEmailIdentityResponse] =
        visitor.deleteEmailIdentity(request)
    }

    final case class DeleteEmailIdentityPolicyOp(
      request: DeleteEmailIdentityPolicyRequest
    ) extends SesV2Op[DeleteEmailIdentityPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEmailIdentityPolicyResponse] =
        visitor.deleteEmailIdentityPolicy(request)
    }

    final case class DeleteEmailTemplateOp(
      request: DeleteEmailTemplateRequest
    ) extends SesV2Op[DeleteEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEmailTemplateResponse] =
        visitor.deleteEmailTemplate(request)
    }

    final case class DeleteSuppressedDestinationOp(
      request: DeleteSuppressedDestinationRequest
    ) extends SesV2Op[DeleteSuppressedDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSuppressedDestinationResponse] =
        visitor.deleteSuppressedDestination(request)
    }

    final case class GetAccountOp(
      request: GetAccountRequest
    ) extends SesV2Op[GetAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountResponse] =
        visitor.getAccount(request)
    }

    final case class GetBlacklistReportsOp(
      request: GetBlacklistReportsRequest
    ) extends SesV2Op[GetBlacklistReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBlacklistReportsResponse] =
        visitor.getBlacklistReports(request)
    }

    final case class GetConfigurationSetOp(
      request: GetConfigurationSetRequest
    ) extends SesV2Op[GetConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigurationSetResponse] =
        visitor.getConfigurationSet(request)
    }

    final case class GetConfigurationSetEventDestinationsOp(
      request: GetConfigurationSetEventDestinationsRequest
    ) extends SesV2Op[GetConfigurationSetEventDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigurationSetEventDestinationsResponse] =
        visitor.getConfigurationSetEventDestinations(request)
    }

    final case class GetContactOp(
      request: GetContactRequest
    ) extends SesV2Op[GetContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactResponse] =
        visitor.getContact(request)
    }

    final case class GetContactListOp(
      request: GetContactListRequest
    ) extends SesV2Op[GetContactListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactListResponse] =
        visitor.getContactList(request)
    }

    final case class GetCustomVerificationEmailTemplateOp(
      request: GetCustomVerificationEmailTemplateRequest
    ) extends SesV2Op[GetCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCustomVerificationEmailTemplateResponse] =
        visitor.getCustomVerificationEmailTemplate(request)
    }

    final case class GetDedicatedIpOp(
      request: GetDedicatedIpRequest
    ) extends SesV2Op[GetDedicatedIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDedicatedIpResponse] =
        visitor.getDedicatedIp(request)
    }

    final case class GetDedicatedIpsOp(
      request: GetDedicatedIpsRequest
    ) extends SesV2Op[GetDedicatedIpsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDedicatedIpsResponse] =
        visitor.getDedicatedIps(request)
    }

    final case class GetDeliverabilityDashboardOptionsOp(
      request: GetDeliverabilityDashboardOptionsRequest
    ) extends SesV2Op[GetDeliverabilityDashboardOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeliverabilityDashboardOptionsResponse] =
        visitor.getDeliverabilityDashboardOptions(request)
    }

    final case class GetDeliverabilityTestReportOp(
      request: GetDeliverabilityTestReportRequest
    ) extends SesV2Op[GetDeliverabilityTestReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeliverabilityTestReportResponse] =
        visitor.getDeliverabilityTestReport(request)
    }

    final case class GetDomainDeliverabilityCampaignOp(
      request: GetDomainDeliverabilityCampaignRequest
    ) extends SesV2Op[GetDomainDeliverabilityCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainDeliverabilityCampaignResponse] =
        visitor.getDomainDeliverabilityCampaign(request)
    }

    final case class GetDomainStatisticsReportOp(
      request: GetDomainStatisticsReportRequest
    ) extends SesV2Op[GetDomainStatisticsReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainStatisticsReportResponse] =
        visitor.getDomainStatisticsReport(request)
    }

    final case class GetEmailIdentityOp(
      request: GetEmailIdentityRequest
    ) extends SesV2Op[GetEmailIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEmailIdentityResponse] =
        visitor.getEmailIdentity(request)
    }

    final case class GetEmailIdentityPoliciesOp(
      request: GetEmailIdentityPoliciesRequest
    ) extends SesV2Op[GetEmailIdentityPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEmailIdentityPoliciesResponse] =
        visitor.getEmailIdentityPolicies(request)
    }

    final case class GetEmailTemplateOp(
      request: GetEmailTemplateRequest
    ) extends SesV2Op[GetEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEmailTemplateResponse] =
        visitor.getEmailTemplate(request)
    }

    final case class GetImportJobOp(
      request: GetImportJobRequest
    ) extends SesV2Op[GetImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImportJobResponse] =
        visitor.getImportJob(request)
    }

    final case class GetSuppressedDestinationOp(
      request: GetSuppressedDestinationRequest
    ) extends SesV2Op[GetSuppressedDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSuppressedDestinationResponse] =
        visitor.getSuppressedDestination(request)
    }

    final case class ListConfigurationSetsOp(
      request: ListConfigurationSetsRequest
    ) extends SesV2Op[ListConfigurationSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationSetsResponse] =
        visitor.listConfigurationSets(request)
    }

    final case class ListContactListsOp(
      request: ListContactListsRequest
    ) extends SesV2Op[ListContactListsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContactListsResponse] =
        visitor.listContactLists(request)
    }

    final case class ListContactsOp(
      request: ListContactsRequest
    ) extends SesV2Op[ListContactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContactsResponse] =
        visitor.listContacts(request)
    }

    final case class ListCustomVerificationEmailTemplatesOp(
      request: ListCustomVerificationEmailTemplatesRequest
    ) extends SesV2Op[ListCustomVerificationEmailTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomVerificationEmailTemplatesResponse] =
        visitor.listCustomVerificationEmailTemplates(request)
    }

    final case class ListDedicatedIpPoolsOp(
      request: ListDedicatedIpPoolsRequest
    ) extends SesV2Op[ListDedicatedIpPoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDedicatedIpPoolsResponse] =
        visitor.listDedicatedIpPools(request)
    }

    final case class ListDeliverabilityTestReportsOp(
      request: ListDeliverabilityTestReportsRequest
    ) extends SesV2Op[ListDeliverabilityTestReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeliverabilityTestReportsResponse] =
        visitor.listDeliverabilityTestReports(request)
    }

    final case class ListDomainDeliverabilityCampaignsOp(
      request: ListDomainDeliverabilityCampaignsRequest
    ) extends SesV2Op[ListDomainDeliverabilityCampaignsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainDeliverabilityCampaignsResponse] =
        visitor.listDomainDeliverabilityCampaigns(request)
    }

    final case class ListEmailIdentitiesOp(
      request: ListEmailIdentitiesRequest
    ) extends SesV2Op[ListEmailIdentitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEmailIdentitiesResponse] =
        visitor.listEmailIdentities(request)
    }

    final case class ListEmailTemplatesOp(
      request: ListEmailTemplatesRequest
    ) extends SesV2Op[ListEmailTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEmailTemplatesResponse] =
        visitor.listEmailTemplates(request)
    }

    final case class ListImportJobsOp(
      request: ListImportJobsRequest
    ) extends SesV2Op[ListImportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImportJobsResponse] =
        visitor.listImportJobs(request)
    }

    final case class ListSuppressedDestinationsOp(
      request: ListSuppressedDestinationsRequest
    ) extends SesV2Op[ListSuppressedDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSuppressedDestinationsResponse] =
        visitor.listSuppressedDestinations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SesV2Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutAccountDedicatedIpWarmupAttributesOp(
      request: PutAccountDedicatedIpWarmupAttributesRequest
    ) extends SesV2Op[PutAccountDedicatedIpWarmupAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountDedicatedIpWarmupAttributesResponse] =
        visitor.putAccountDedicatedIpWarmupAttributes(request)
    }

    final case class PutAccountDetailsOp(
      request: PutAccountDetailsRequest
    ) extends SesV2Op[PutAccountDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountDetailsResponse] =
        visitor.putAccountDetails(request)
    }

    final case class PutAccountSendingAttributesOp(
      request: PutAccountSendingAttributesRequest
    ) extends SesV2Op[PutAccountSendingAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountSendingAttributesResponse] =
        visitor.putAccountSendingAttributes(request)
    }

    final case class PutAccountSuppressionAttributesOp(
      request: PutAccountSuppressionAttributesRequest
    ) extends SesV2Op[PutAccountSuppressionAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountSuppressionAttributesResponse] =
        visitor.putAccountSuppressionAttributes(request)
    }

    final case class PutConfigurationSetDeliveryOptionsOp(
      request: PutConfigurationSetDeliveryOptionsRequest
    ) extends SesV2Op[PutConfigurationSetDeliveryOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetDeliveryOptionsResponse] =
        visitor.putConfigurationSetDeliveryOptions(request)
    }

    final case class PutConfigurationSetReputationOptionsOp(
      request: PutConfigurationSetReputationOptionsRequest
    ) extends SesV2Op[PutConfigurationSetReputationOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetReputationOptionsResponse] =
        visitor.putConfigurationSetReputationOptions(request)
    }

    final case class PutConfigurationSetSendingOptionsOp(
      request: PutConfigurationSetSendingOptionsRequest
    ) extends SesV2Op[PutConfigurationSetSendingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetSendingOptionsResponse] =
        visitor.putConfigurationSetSendingOptions(request)
    }

    final case class PutConfigurationSetSuppressionOptionsOp(
      request: PutConfigurationSetSuppressionOptionsRequest
    ) extends SesV2Op[PutConfigurationSetSuppressionOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetSuppressionOptionsResponse] =
        visitor.putConfigurationSetSuppressionOptions(request)
    }

    final case class PutConfigurationSetTrackingOptionsOp(
      request: PutConfigurationSetTrackingOptionsRequest
    ) extends SesV2Op[PutConfigurationSetTrackingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetTrackingOptionsResponse] =
        visitor.putConfigurationSetTrackingOptions(request)
    }

    final case class PutDedicatedIpInPoolOp(
      request: PutDedicatedIpInPoolRequest
    ) extends SesV2Op[PutDedicatedIpInPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDedicatedIpInPoolResponse] =
        visitor.putDedicatedIpInPool(request)
    }

    final case class PutDedicatedIpWarmupAttributesOp(
      request: PutDedicatedIpWarmupAttributesRequest
    ) extends SesV2Op[PutDedicatedIpWarmupAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDedicatedIpWarmupAttributesResponse] =
        visitor.putDedicatedIpWarmupAttributes(request)
    }

    final case class PutDeliverabilityDashboardOptionOp(
      request: PutDeliverabilityDashboardOptionRequest
    ) extends SesV2Op[PutDeliverabilityDashboardOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDeliverabilityDashboardOptionResponse] =
        visitor.putDeliverabilityDashboardOption(request)
    }

    final case class PutEmailIdentityConfigurationSetAttributesOp(
      request: PutEmailIdentityConfigurationSetAttributesRequest
    ) extends SesV2Op[PutEmailIdentityConfigurationSetAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityConfigurationSetAttributesResponse] =
        visitor.putEmailIdentityConfigurationSetAttributes(request)
    }

    final case class PutEmailIdentityDkimAttributesOp(
      request: PutEmailIdentityDkimAttributesRequest
    ) extends SesV2Op[PutEmailIdentityDkimAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityDkimAttributesResponse] =
        visitor.putEmailIdentityDkimAttributes(request)
    }

    final case class PutEmailIdentityDkimSigningAttributesOp(
      request: PutEmailIdentityDkimSigningAttributesRequest
    ) extends SesV2Op[PutEmailIdentityDkimSigningAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityDkimSigningAttributesResponse] =
        visitor.putEmailIdentityDkimSigningAttributes(request)
    }

    final case class PutEmailIdentityFeedbackAttributesOp(
      request: PutEmailIdentityFeedbackAttributesRequest
    ) extends SesV2Op[PutEmailIdentityFeedbackAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityFeedbackAttributesResponse] =
        visitor.putEmailIdentityFeedbackAttributes(request)
    }

    final case class PutEmailIdentityMailFromAttributesOp(
      request: PutEmailIdentityMailFromAttributesRequest
    ) extends SesV2Op[PutEmailIdentityMailFromAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityMailFromAttributesResponse] =
        visitor.putEmailIdentityMailFromAttributes(request)
    }

    final case class PutSuppressedDestinationOp(
      request: PutSuppressedDestinationRequest
    ) extends SesV2Op[PutSuppressedDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSuppressedDestinationResponse] =
        visitor.putSuppressedDestination(request)
    }

    final case class SendBulkEmailOp(
      request: SendBulkEmailRequest
    ) extends SesV2Op[SendBulkEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendBulkEmailResponse] =
        visitor.sendBulkEmail(request)
    }

    final case class SendCustomVerificationEmailOp(
      request: SendCustomVerificationEmailRequest
    ) extends SesV2Op[SendCustomVerificationEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendCustomVerificationEmailResponse] =
        visitor.sendCustomVerificationEmail(request)
    }

    final case class SendEmailOp(
      request: SendEmailRequest
    ) extends SesV2Op[SendEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendEmailResponse] =
        visitor.sendEmail(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SesV2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestRenderEmailTemplateOp(
      request: TestRenderEmailTemplateRequest
    ) extends SesV2Op[TestRenderEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestRenderEmailTemplateResponse] =
        visitor.testRenderEmailTemplate(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SesV2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateConfigurationSetEventDestinationOp(
      request: UpdateConfigurationSetEventDestinationRequest
    ) extends SesV2Op[UpdateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationSetEventDestinationResponse] =
        visitor.updateConfigurationSetEventDestination(request)
    }

    final case class UpdateContactOp(
      request: UpdateContactRequest
    ) extends SesV2Op[UpdateContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactResponse] =
        visitor.updateContact(request)
    }

    final case class UpdateContactListOp(
      request: UpdateContactListRequest
    ) extends SesV2Op[UpdateContactListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactListResponse] =
        visitor.updateContactList(request)
    }

    final case class UpdateCustomVerificationEmailTemplateOp(
      request: UpdateCustomVerificationEmailTemplateRequest
    ) extends SesV2Op[UpdateCustomVerificationEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCustomVerificationEmailTemplateResponse] =
        visitor.updateCustomVerificationEmailTemplate(request)
    }

    final case class UpdateEmailIdentityPolicyOp(
      request: UpdateEmailIdentityPolicyRequest
    ) extends SesV2Op[UpdateEmailIdentityPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEmailIdentityPolicyResponse] =
        visitor.updateEmailIdentityPolicy(request)
    }

    final case class UpdateEmailTemplateOp(
      request: UpdateEmailTemplateRequest
    ) extends SesV2Op[UpdateEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEmailTemplateResponse] =
        visitor.updateEmailTemplate(request)
    }
  }

  import SesV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SesV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createConfigurationSet(
    request: CreateConfigurationSetRequest
  ): SesV2IO[CreateConfigurationSetResponse] =
    FF.liftF(CreateConfigurationSetOp(request))

  def createConfigurationSetEventDestination(
    request: CreateConfigurationSetEventDestinationRequest
  ): SesV2IO[CreateConfigurationSetEventDestinationResponse] =
    FF.liftF(CreateConfigurationSetEventDestinationOp(request))

  def createContact(
    request: CreateContactRequest
  ): SesV2IO[CreateContactResponse] =
    FF.liftF(CreateContactOp(request))

  def createContactList(
    request: CreateContactListRequest
  ): SesV2IO[CreateContactListResponse] =
    FF.liftF(CreateContactListOp(request))

  def createCustomVerificationEmailTemplate(
    request: CreateCustomVerificationEmailTemplateRequest
  ): SesV2IO[CreateCustomVerificationEmailTemplateResponse] =
    FF.liftF(CreateCustomVerificationEmailTemplateOp(request))

  def createDedicatedIpPool(
    request: CreateDedicatedIpPoolRequest
  ): SesV2IO[CreateDedicatedIpPoolResponse] =
    FF.liftF(CreateDedicatedIpPoolOp(request))

  def createDeliverabilityTestReport(
    request: CreateDeliverabilityTestReportRequest
  ): SesV2IO[CreateDeliverabilityTestReportResponse] =
    FF.liftF(CreateDeliverabilityTestReportOp(request))

  def createEmailIdentity(
    request: CreateEmailIdentityRequest
  ): SesV2IO[CreateEmailIdentityResponse] =
    FF.liftF(CreateEmailIdentityOp(request))

  def createEmailIdentityPolicy(
    request: CreateEmailIdentityPolicyRequest
  ): SesV2IO[CreateEmailIdentityPolicyResponse] =
    FF.liftF(CreateEmailIdentityPolicyOp(request))

  def createEmailTemplate(
    request: CreateEmailTemplateRequest
  ): SesV2IO[CreateEmailTemplateResponse] =
    FF.liftF(CreateEmailTemplateOp(request))

  def createImportJob(
    request: CreateImportJobRequest
  ): SesV2IO[CreateImportJobResponse] =
    FF.liftF(CreateImportJobOp(request))

  def deleteConfigurationSet(
    request: DeleteConfigurationSetRequest
  ): SesV2IO[DeleteConfigurationSetResponse] =
    FF.liftF(DeleteConfigurationSetOp(request))

  def deleteConfigurationSetEventDestination(
    request: DeleteConfigurationSetEventDestinationRequest
  ): SesV2IO[DeleteConfigurationSetEventDestinationResponse] =
    FF.liftF(DeleteConfigurationSetEventDestinationOp(request))

  def deleteContact(
    request: DeleteContactRequest
  ): SesV2IO[DeleteContactResponse] =
    FF.liftF(DeleteContactOp(request))

  def deleteContactList(
    request: DeleteContactListRequest
  ): SesV2IO[DeleteContactListResponse] =
    FF.liftF(DeleteContactListOp(request))

  def deleteCustomVerificationEmailTemplate(
    request: DeleteCustomVerificationEmailTemplateRequest
  ): SesV2IO[DeleteCustomVerificationEmailTemplateResponse] =
    FF.liftF(DeleteCustomVerificationEmailTemplateOp(request))

  def deleteDedicatedIpPool(
    request: DeleteDedicatedIpPoolRequest
  ): SesV2IO[DeleteDedicatedIpPoolResponse] =
    FF.liftF(DeleteDedicatedIpPoolOp(request))

  def deleteEmailIdentity(
    request: DeleteEmailIdentityRequest
  ): SesV2IO[DeleteEmailIdentityResponse] =
    FF.liftF(DeleteEmailIdentityOp(request))

  def deleteEmailIdentityPolicy(
    request: DeleteEmailIdentityPolicyRequest
  ): SesV2IO[DeleteEmailIdentityPolicyResponse] =
    FF.liftF(DeleteEmailIdentityPolicyOp(request))

  def deleteEmailTemplate(
    request: DeleteEmailTemplateRequest
  ): SesV2IO[DeleteEmailTemplateResponse] =
    FF.liftF(DeleteEmailTemplateOp(request))

  def deleteSuppressedDestination(
    request: DeleteSuppressedDestinationRequest
  ): SesV2IO[DeleteSuppressedDestinationResponse] =
    FF.liftF(DeleteSuppressedDestinationOp(request))

  def getAccount(
    request: GetAccountRequest
  ): SesV2IO[GetAccountResponse] =
    FF.liftF(GetAccountOp(request))

  def getBlacklistReports(
    request: GetBlacklistReportsRequest
  ): SesV2IO[GetBlacklistReportsResponse] =
    FF.liftF(GetBlacklistReportsOp(request))

  def getConfigurationSet(
    request: GetConfigurationSetRequest
  ): SesV2IO[GetConfigurationSetResponse] =
    FF.liftF(GetConfigurationSetOp(request))

  def getConfigurationSetEventDestinations(
    request: GetConfigurationSetEventDestinationsRequest
  ): SesV2IO[GetConfigurationSetEventDestinationsResponse] =
    FF.liftF(GetConfigurationSetEventDestinationsOp(request))

  def getContact(
    request: GetContactRequest
  ): SesV2IO[GetContactResponse] =
    FF.liftF(GetContactOp(request))

  def getContactList(
    request: GetContactListRequest
  ): SesV2IO[GetContactListResponse] =
    FF.liftF(GetContactListOp(request))

  def getCustomVerificationEmailTemplate(
    request: GetCustomVerificationEmailTemplateRequest
  ): SesV2IO[GetCustomVerificationEmailTemplateResponse] =
    FF.liftF(GetCustomVerificationEmailTemplateOp(request))

  def getDedicatedIp(
    request: GetDedicatedIpRequest
  ): SesV2IO[GetDedicatedIpResponse] =
    FF.liftF(GetDedicatedIpOp(request))

  def getDedicatedIps(
    request: GetDedicatedIpsRequest
  ): SesV2IO[GetDedicatedIpsResponse] =
    FF.liftF(GetDedicatedIpsOp(request))

  def getDeliverabilityDashboardOptions(
    request: GetDeliverabilityDashboardOptionsRequest
  ): SesV2IO[GetDeliverabilityDashboardOptionsResponse] =
    FF.liftF(GetDeliverabilityDashboardOptionsOp(request))

  def getDeliverabilityTestReport(
    request: GetDeliverabilityTestReportRequest
  ): SesV2IO[GetDeliverabilityTestReportResponse] =
    FF.liftF(GetDeliverabilityTestReportOp(request))

  def getDomainDeliverabilityCampaign(
    request: GetDomainDeliverabilityCampaignRequest
  ): SesV2IO[GetDomainDeliverabilityCampaignResponse] =
    FF.liftF(GetDomainDeliverabilityCampaignOp(request))

  def getDomainStatisticsReport(
    request: GetDomainStatisticsReportRequest
  ): SesV2IO[GetDomainStatisticsReportResponse] =
    FF.liftF(GetDomainStatisticsReportOp(request))

  def getEmailIdentity(
    request: GetEmailIdentityRequest
  ): SesV2IO[GetEmailIdentityResponse] =
    FF.liftF(GetEmailIdentityOp(request))

  def getEmailIdentityPolicies(
    request: GetEmailIdentityPoliciesRequest
  ): SesV2IO[GetEmailIdentityPoliciesResponse] =
    FF.liftF(GetEmailIdentityPoliciesOp(request))

  def getEmailTemplate(
    request: GetEmailTemplateRequest
  ): SesV2IO[GetEmailTemplateResponse] =
    FF.liftF(GetEmailTemplateOp(request))

  def getImportJob(
    request: GetImportJobRequest
  ): SesV2IO[GetImportJobResponse] =
    FF.liftF(GetImportJobOp(request))

  def getSuppressedDestination(
    request: GetSuppressedDestinationRequest
  ): SesV2IO[GetSuppressedDestinationResponse] =
    FF.liftF(GetSuppressedDestinationOp(request))

  def listConfigurationSets(
    request: ListConfigurationSetsRequest
  ): SesV2IO[ListConfigurationSetsResponse] =
    FF.liftF(ListConfigurationSetsOp(request))

  def listContactLists(
    request: ListContactListsRequest
  ): SesV2IO[ListContactListsResponse] =
    FF.liftF(ListContactListsOp(request))

  def listContacts(
    request: ListContactsRequest
  ): SesV2IO[ListContactsResponse] =
    FF.liftF(ListContactsOp(request))

  def listCustomVerificationEmailTemplates(
    request: ListCustomVerificationEmailTemplatesRequest
  ): SesV2IO[ListCustomVerificationEmailTemplatesResponse] =
    FF.liftF(ListCustomVerificationEmailTemplatesOp(request))

  def listDedicatedIpPools(
    request: ListDedicatedIpPoolsRequest
  ): SesV2IO[ListDedicatedIpPoolsResponse] =
    FF.liftF(ListDedicatedIpPoolsOp(request))

  def listDeliverabilityTestReports(
    request: ListDeliverabilityTestReportsRequest
  ): SesV2IO[ListDeliverabilityTestReportsResponse] =
    FF.liftF(ListDeliverabilityTestReportsOp(request))

  def listDomainDeliverabilityCampaigns(
    request: ListDomainDeliverabilityCampaignsRequest
  ): SesV2IO[ListDomainDeliverabilityCampaignsResponse] =
    FF.liftF(ListDomainDeliverabilityCampaignsOp(request))

  def listEmailIdentities(
    request: ListEmailIdentitiesRequest
  ): SesV2IO[ListEmailIdentitiesResponse] =
    FF.liftF(ListEmailIdentitiesOp(request))

  def listEmailTemplates(
    request: ListEmailTemplatesRequest
  ): SesV2IO[ListEmailTemplatesResponse] =
    FF.liftF(ListEmailTemplatesOp(request))

  def listImportJobs(
    request: ListImportJobsRequest
  ): SesV2IO[ListImportJobsResponse] =
    FF.liftF(ListImportJobsOp(request))

  def listSuppressedDestinations(
    request: ListSuppressedDestinationsRequest
  ): SesV2IO[ListSuppressedDestinationsResponse] =
    FF.liftF(ListSuppressedDestinationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SesV2IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putAccountDedicatedIpWarmupAttributes(
    request: PutAccountDedicatedIpWarmupAttributesRequest
  ): SesV2IO[PutAccountDedicatedIpWarmupAttributesResponse] =
    FF.liftF(PutAccountDedicatedIpWarmupAttributesOp(request))

  def putAccountDetails(
    request: PutAccountDetailsRequest
  ): SesV2IO[PutAccountDetailsResponse] =
    FF.liftF(PutAccountDetailsOp(request))

  def putAccountSendingAttributes(
    request: PutAccountSendingAttributesRequest
  ): SesV2IO[PutAccountSendingAttributesResponse] =
    FF.liftF(PutAccountSendingAttributesOp(request))

  def putAccountSuppressionAttributes(
    request: PutAccountSuppressionAttributesRequest
  ): SesV2IO[PutAccountSuppressionAttributesResponse] =
    FF.liftF(PutAccountSuppressionAttributesOp(request))

  def putConfigurationSetDeliveryOptions(
    request: PutConfigurationSetDeliveryOptionsRequest
  ): SesV2IO[PutConfigurationSetDeliveryOptionsResponse] =
    FF.liftF(PutConfigurationSetDeliveryOptionsOp(request))

  def putConfigurationSetReputationOptions(
    request: PutConfigurationSetReputationOptionsRequest
  ): SesV2IO[PutConfigurationSetReputationOptionsResponse] =
    FF.liftF(PutConfigurationSetReputationOptionsOp(request))

  def putConfigurationSetSendingOptions(
    request: PutConfigurationSetSendingOptionsRequest
  ): SesV2IO[PutConfigurationSetSendingOptionsResponse] =
    FF.liftF(PutConfigurationSetSendingOptionsOp(request))

  def putConfigurationSetSuppressionOptions(
    request: PutConfigurationSetSuppressionOptionsRequest
  ): SesV2IO[PutConfigurationSetSuppressionOptionsResponse] =
    FF.liftF(PutConfigurationSetSuppressionOptionsOp(request))

  def putConfigurationSetTrackingOptions(
    request: PutConfigurationSetTrackingOptionsRequest
  ): SesV2IO[PutConfigurationSetTrackingOptionsResponse] =
    FF.liftF(PutConfigurationSetTrackingOptionsOp(request))

  def putDedicatedIpInPool(
    request: PutDedicatedIpInPoolRequest
  ): SesV2IO[PutDedicatedIpInPoolResponse] =
    FF.liftF(PutDedicatedIpInPoolOp(request))

  def putDedicatedIpWarmupAttributes(
    request: PutDedicatedIpWarmupAttributesRequest
  ): SesV2IO[PutDedicatedIpWarmupAttributesResponse] =
    FF.liftF(PutDedicatedIpWarmupAttributesOp(request))

  def putDeliverabilityDashboardOption(
    request: PutDeliverabilityDashboardOptionRequest
  ): SesV2IO[PutDeliverabilityDashboardOptionResponse] =
    FF.liftF(PutDeliverabilityDashboardOptionOp(request))

  def putEmailIdentityConfigurationSetAttributes(
    request: PutEmailIdentityConfigurationSetAttributesRequest
  ): SesV2IO[PutEmailIdentityConfigurationSetAttributesResponse] =
    FF.liftF(PutEmailIdentityConfigurationSetAttributesOp(request))

  def putEmailIdentityDkimAttributes(
    request: PutEmailIdentityDkimAttributesRequest
  ): SesV2IO[PutEmailIdentityDkimAttributesResponse] =
    FF.liftF(PutEmailIdentityDkimAttributesOp(request))

  def putEmailIdentityDkimSigningAttributes(
    request: PutEmailIdentityDkimSigningAttributesRequest
  ): SesV2IO[PutEmailIdentityDkimSigningAttributesResponse] =
    FF.liftF(PutEmailIdentityDkimSigningAttributesOp(request))

  def putEmailIdentityFeedbackAttributes(
    request: PutEmailIdentityFeedbackAttributesRequest
  ): SesV2IO[PutEmailIdentityFeedbackAttributesResponse] =
    FF.liftF(PutEmailIdentityFeedbackAttributesOp(request))

  def putEmailIdentityMailFromAttributes(
    request: PutEmailIdentityMailFromAttributesRequest
  ): SesV2IO[PutEmailIdentityMailFromAttributesResponse] =
    FF.liftF(PutEmailIdentityMailFromAttributesOp(request))

  def putSuppressedDestination(
    request: PutSuppressedDestinationRequest
  ): SesV2IO[PutSuppressedDestinationResponse] =
    FF.liftF(PutSuppressedDestinationOp(request))

  def sendBulkEmail(
    request: SendBulkEmailRequest
  ): SesV2IO[SendBulkEmailResponse] =
    FF.liftF(SendBulkEmailOp(request))

  def sendCustomVerificationEmail(
    request: SendCustomVerificationEmailRequest
  ): SesV2IO[SendCustomVerificationEmailResponse] =
    FF.liftF(SendCustomVerificationEmailOp(request))

  def sendEmail(
    request: SendEmailRequest
  ): SesV2IO[SendEmailResponse] =
    FF.liftF(SendEmailOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SesV2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testRenderEmailTemplate(
    request: TestRenderEmailTemplateRequest
  ): SesV2IO[TestRenderEmailTemplateResponse] =
    FF.liftF(TestRenderEmailTemplateOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SesV2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateConfigurationSetEventDestination(
    request: UpdateConfigurationSetEventDestinationRequest
  ): SesV2IO[UpdateConfigurationSetEventDestinationResponse] =
    FF.liftF(UpdateConfigurationSetEventDestinationOp(request))

  def updateContact(
    request: UpdateContactRequest
  ): SesV2IO[UpdateContactResponse] =
    FF.liftF(UpdateContactOp(request))

  def updateContactList(
    request: UpdateContactListRequest
  ): SesV2IO[UpdateContactListResponse] =
    FF.liftF(UpdateContactListOp(request))

  def updateCustomVerificationEmailTemplate(
    request: UpdateCustomVerificationEmailTemplateRequest
  ): SesV2IO[UpdateCustomVerificationEmailTemplateResponse] =
    FF.liftF(UpdateCustomVerificationEmailTemplateOp(request))

  def updateEmailIdentityPolicy(
    request: UpdateEmailIdentityPolicyRequest
  ): SesV2IO[UpdateEmailIdentityPolicyResponse] =
    FF.liftF(UpdateEmailIdentityPolicyOp(request))

  def updateEmailTemplate(
    request: UpdateEmailTemplateRequest
  ): SesV2IO[UpdateEmailTemplateResponse] =
    FF.liftF(UpdateEmailTemplateOp(request))
}
