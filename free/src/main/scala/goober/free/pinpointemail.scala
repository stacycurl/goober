package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.pinpointemail.PinpointEmailClient
import software.amazon.awssdk.services.pinpointemail.model._


object pinpointemail { module =>

  // Free monad over PinpointEmailOp
  type PinpointEmailIO[A] = FF[PinpointEmailOp, A]

  sealed trait PinpointEmailOp[A] {
    def visit[F[_]](visitor: PinpointEmailOp.Visitor[F]): F[A]
  }

  object PinpointEmailOp {
    // Given a PinpointEmailClient we can embed a PinpointEmailIO program in any algebra that understands embedding.
    implicit val PinpointEmailOpEmbeddable: Embeddable[PinpointEmailOp, PinpointEmailClient] = new Embeddable[PinpointEmailOp, PinpointEmailClient] {
      def embed[A](client: PinpointEmailClient, io: PinpointEmailIO[A]): Embedded[A] = Embedded.PinpointEmail(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PinpointEmailOp.Visitor[Kleisli[M, PinpointEmailClient, *]] {
        def createConfigurationSet(
          request: CreateConfigurationSetRequest
        ): Kleisli[M, PinpointEmailClient, CreateConfigurationSetResponse] =
          primitive(_.createConfigurationSet(request))

        def createConfigurationSetEventDestination(
          request: CreateConfigurationSetEventDestinationRequest
        ): Kleisli[M, PinpointEmailClient, CreateConfigurationSetEventDestinationResponse] =
          primitive(_.createConfigurationSetEventDestination(request))

        def createDedicatedIpPool(
          request: CreateDedicatedIpPoolRequest
        ): Kleisli[M, PinpointEmailClient, CreateDedicatedIpPoolResponse] =
          primitive(_.createDedicatedIpPool(request))

        def createDeliverabilityTestReport(
          request: CreateDeliverabilityTestReportRequest
        ): Kleisli[M, PinpointEmailClient, CreateDeliverabilityTestReportResponse] =
          primitive(_.createDeliverabilityTestReport(request))

        def createEmailIdentity(
          request: CreateEmailIdentityRequest
        ): Kleisli[M, PinpointEmailClient, CreateEmailIdentityResponse] =
          primitive(_.createEmailIdentity(request))

        def deleteConfigurationSet(
          request: DeleteConfigurationSetRequest
        ): Kleisli[M, PinpointEmailClient, DeleteConfigurationSetResponse] =
          primitive(_.deleteConfigurationSet(request))

        def deleteConfigurationSetEventDestination(
          request: DeleteConfigurationSetEventDestinationRequest
        ): Kleisli[M, PinpointEmailClient, DeleteConfigurationSetEventDestinationResponse] =
          primitive(_.deleteConfigurationSetEventDestination(request))

        def deleteDedicatedIpPool(
          request: DeleteDedicatedIpPoolRequest
        ): Kleisli[M, PinpointEmailClient, DeleteDedicatedIpPoolResponse] =
          primitive(_.deleteDedicatedIpPool(request))

        def deleteEmailIdentity(
          request: DeleteEmailIdentityRequest
        ): Kleisli[M, PinpointEmailClient, DeleteEmailIdentityResponse] =
          primitive(_.deleteEmailIdentity(request))

        def getAccount(
          request: GetAccountRequest
        ): Kleisli[M, PinpointEmailClient, GetAccountResponse] =
          primitive(_.getAccount(request))

        def getBlacklistReports(
          request: GetBlacklistReportsRequest
        ): Kleisli[M, PinpointEmailClient, GetBlacklistReportsResponse] =
          primitive(_.getBlacklistReports(request))

        def getConfigurationSet(
          request: GetConfigurationSetRequest
        ): Kleisli[M, PinpointEmailClient, GetConfigurationSetResponse] =
          primitive(_.getConfigurationSet(request))

        def getConfigurationSetEventDestinations(
          request: GetConfigurationSetEventDestinationsRequest
        ): Kleisli[M, PinpointEmailClient, GetConfigurationSetEventDestinationsResponse] =
          primitive(_.getConfigurationSetEventDestinations(request))

        def getDedicatedIp(
          request: GetDedicatedIpRequest
        ): Kleisli[M, PinpointEmailClient, GetDedicatedIpResponse] =
          primitive(_.getDedicatedIp(request))

        def getDedicatedIps(
          request: GetDedicatedIpsRequest
        ): Kleisli[M, PinpointEmailClient, GetDedicatedIpsResponse] =
          primitive(_.getDedicatedIps(request))

        def getDeliverabilityDashboardOptions(
          request: GetDeliverabilityDashboardOptionsRequest
        ): Kleisli[M, PinpointEmailClient, GetDeliverabilityDashboardOptionsResponse] =
          primitive(_.getDeliverabilityDashboardOptions(request))

        def getDeliverabilityTestReport(
          request: GetDeliverabilityTestReportRequest
        ): Kleisli[M, PinpointEmailClient, GetDeliverabilityTestReportResponse] =
          primitive(_.getDeliverabilityTestReport(request))

        def getDomainDeliverabilityCampaign(
          request: GetDomainDeliverabilityCampaignRequest
        ): Kleisli[M, PinpointEmailClient, GetDomainDeliverabilityCampaignResponse] =
          primitive(_.getDomainDeliverabilityCampaign(request))

        def getDomainStatisticsReport(
          request: GetDomainStatisticsReportRequest
        ): Kleisli[M, PinpointEmailClient, GetDomainStatisticsReportResponse] =
          primitive(_.getDomainStatisticsReport(request))

        def getEmailIdentity(
          request: GetEmailIdentityRequest
        ): Kleisli[M, PinpointEmailClient, GetEmailIdentityResponse] =
          primitive(_.getEmailIdentity(request))

        def listConfigurationSets(
          request: ListConfigurationSetsRequest
        ): Kleisli[M, PinpointEmailClient, ListConfigurationSetsResponse] =
          primitive(_.listConfigurationSets(request))

        def listDedicatedIpPools(
          request: ListDedicatedIpPoolsRequest
        ): Kleisli[M, PinpointEmailClient, ListDedicatedIpPoolsResponse] =
          primitive(_.listDedicatedIpPools(request))

        def listDeliverabilityTestReports(
          request: ListDeliverabilityTestReportsRequest
        ): Kleisli[M, PinpointEmailClient, ListDeliverabilityTestReportsResponse] =
          primitive(_.listDeliverabilityTestReports(request))

        def listDomainDeliverabilityCampaigns(
          request: ListDomainDeliverabilityCampaignsRequest
        ): Kleisli[M, PinpointEmailClient, ListDomainDeliverabilityCampaignsResponse] =
          primitive(_.listDomainDeliverabilityCampaigns(request))

        def listEmailIdentities(
          request: ListEmailIdentitiesRequest
        ): Kleisli[M, PinpointEmailClient, ListEmailIdentitiesResponse] =
          primitive(_.listEmailIdentities(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, PinpointEmailClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putAccountDedicatedIpWarmupAttributes(
          request: PutAccountDedicatedIpWarmupAttributesRequest
        ): Kleisli[M, PinpointEmailClient, PutAccountDedicatedIpWarmupAttributesResponse] =
          primitive(_.putAccountDedicatedIpWarmupAttributes(request))

        def putAccountSendingAttributes(
          request: PutAccountSendingAttributesRequest
        ): Kleisli[M, PinpointEmailClient, PutAccountSendingAttributesResponse] =
          primitive(_.putAccountSendingAttributes(request))

        def putConfigurationSetDeliveryOptions(
          request: PutConfigurationSetDeliveryOptionsRequest
        ): Kleisli[M, PinpointEmailClient, PutConfigurationSetDeliveryOptionsResponse] =
          primitive(_.putConfigurationSetDeliveryOptions(request))

        def putConfigurationSetReputationOptions(
          request: PutConfigurationSetReputationOptionsRequest
        ): Kleisli[M, PinpointEmailClient, PutConfigurationSetReputationOptionsResponse] =
          primitive(_.putConfigurationSetReputationOptions(request))

        def putConfigurationSetSendingOptions(
          request: PutConfigurationSetSendingOptionsRequest
        ): Kleisli[M, PinpointEmailClient, PutConfigurationSetSendingOptionsResponse] =
          primitive(_.putConfigurationSetSendingOptions(request))

        def putConfigurationSetTrackingOptions(
          request: PutConfigurationSetTrackingOptionsRequest
        ): Kleisli[M, PinpointEmailClient, PutConfigurationSetTrackingOptionsResponse] =
          primitive(_.putConfigurationSetTrackingOptions(request))

        def putDedicatedIpInPool(
          request: PutDedicatedIpInPoolRequest
        ): Kleisli[M, PinpointEmailClient, PutDedicatedIpInPoolResponse] =
          primitive(_.putDedicatedIpInPool(request))

        def putDedicatedIpWarmupAttributes(
          request: PutDedicatedIpWarmupAttributesRequest
        ): Kleisli[M, PinpointEmailClient, PutDedicatedIpWarmupAttributesResponse] =
          primitive(_.putDedicatedIpWarmupAttributes(request))

        def putDeliverabilityDashboardOption(
          request: PutDeliverabilityDashboardOptionRequest
        ): Kleisli[M, PinpointEmailClient, PutDeliverabilityDashboardOptionResponse] =
          primitive(_.putDeliverabilityDashboardOption(request))

        def putEmailIdentityDkimAttributes(
          request: PutEmailIdentityDkimAttributesRequest
        ): Kleisli[M, PinpointEmailClient, PutEmailIdentityDkimAttributesResponse] =
          primitive(_.putEmailIdentityDkimAttributes(request))

        def putEmailIdentityFeedbackAttributes(
          request: PutEmailIdentityFeedbackAttributesRequest
        ): Kleisli[M, PinpointEmailClient, PutEmailIdentityFeedbackAttributesResponse] =
          primitive(_.putEmailIdentityFeedbackAttributes(request))

        def putEmailIdentityMailFromAttributes(
          request: PutEmailIdentityMailFromAttributesRequest
        ): Kleisli[M, PinpointEmailClient, PutEmailIdentityMailFromAttributesResponse] =
          primitive(_.putEmailIdentityMailFromAttributes(request))

        def sendEmail(
          request: SendEmailRequest
        ): Kleisli[M, PinpointEmailClient, SendEmailResponse] =
          primitive(_.sendEmail(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, PinpointEmailClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, PinpointEmailClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateConfigurationSetEventDestination(
          request: UpdateConfigurationSetEventDestinationRequest
        ): Kleisli[M, PinpointEmailClient, UpdateConfigurationSetEventDestinationResponse] =
          primitive(_.updateConfigurationSetEventDestination(request))

        def primitive[A](
          f: PinpointEmailClient => A
        ): Kleisli[M, PinpointEmailClient, A]
      }
    }

    trait Visitor[F[_]] extends (PinpointEmailOp ~> F) {
      final def apply[A](op: PinpointEmailOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createConfigurationSet(
        request: CreateConfigurationSetRequest
      ): F[CreateConfigurationSetResponse]

      def createConfigurationSetEventDestination(
        request: CreateConfigurationSetEventDestinationRequest
      ): F[CreateConfigurationSetEventDestinationResponse]

      def createDedicatedIpPool(
        request: CreateDedicatedIpPoolRequest
      ): F[CreateDedicatedIpPoolResponse]

      def createDeliverabilityTestReport(
        request: CreateDeliverabilityTestReportRequest
      ): F[CreateDeliverabilityTestReportResponse]

      def createEmailIdentity(
        request: CreateEmailIdentityRequest
      ): F[CreateEmailIdentityResponse]

      def deleteConfigurationSet(
        request: DeleteConfigurationSetRequest
      ): F[DeleteConfigurationSetResponse]

      def deleteConfigurationSetEventDestination(
        request: DeleteConfigurationSetEventDestinationRequest
      ): F[DeleteConfigurationSetEventDestinationResponse]

      def deleteDedicatedIpPool(
        request: DeleteDedicatedIpPoolRequest
      ): F[DeleteDedicatedIpPoolResponse]

      def deleteEmailIdentity(
        request: DeleteEmailIdentityRequest
      ): F[DeleteEmailIdentityResponse]

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

      def listConfigurationSets(
        request: ListConfigurationSetsRequest
      ): F[ListConfigurationSetsResponse]

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

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putAccountDedicatedIpWarmupAttributes(
        request: PutAccountDedicatedIpWarmupAttributesRequest
      ): F[PutAccountDedicatedIpWarmupAttributesResponse]

      def putAccountSendingAttributes(
        request: PutAccountSendingAttributesRequest
      ): F[PutAccountSendingAttributesResponse]

      def putConfigurationSetDeliveryOptions(
        request: PutConfigurationSetDeliveryOptionsRequest
      ): F[PutConfigurationSetDeliveryOptionsResponse]

      def putConfigurationSetReputationOptions(
        request: PutConfigurationSetReputationOptionsRequest
      ): F[PutConfigurationSetReputationOptionsResponse]

      def putConfigurationSetSendingOptions(
        request: PutConfigurationSetSendingOptionsRequest
      ): F[PutConfigurationSetSendingOptionsResponse]

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

      def putEmailIdentityDkimAttributes(
        request: PutEmailIdentityDkimAttributesRequest
      ): F[PutEmailIdentityDkimAttributesResponse]

      def putEmailIdentityFeedbackAttributes(
        request: PutEmailIdentityFeedbackAttributesRequest
      ): F[PutEmailIdentityFeedbackAttributesResponse]

      def putEmailIdentityMailFromAttributes(
        request: PutEmailIdentityMailFromAttributesRequest
      ): F[PutEmailIdentityMailFromAttributesResponse]

      def sendEmail(
        request: SendEmailRequest
      ): F[SendEmailResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateConfigurationSetEventDestination(
        request: UpdateConfigurationSetEventDestinationRequest
      ): F[UpdateConfigurationSetEventDestinationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PinpointEmailOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateConfigurationSetOp(
      request: CreateConfigurationSetRequest
    ) extends PinpointEmailOp[CreateConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetResponse] =
        visitor.createConfigurationSet(request)
    }

    final case class CreateConfigurationSetEventDestinationOp(
      request: CreateConfigurationSetEventDestinationRequest
    ) extends PinpointEmailOp[CreateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationSetEventDestinationResponse] =
        visitor.createConfigurationSetEventDestination(request)
    }

    final case class CreateDedicatedIpPoolOp(
      request: CreateDedicatedIpPoolRequest
    ) extends PinpointEmailOp[CreateDedicatedIpPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDedicatedIpPoolResponse] =
        visitor.createDedicatedIpPool(request)
    }

    final case class CreateDeliverabilityTestReportOp(
      request: CreateDeliverabilityTestReportRequest
    ) extends PinpointEmailOp[CreateDeliverabilityTestReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeliverabilityTestReportResponse] =
        visitor.createDeliverabilityTestReport(request)
    }

    final case class CreateEmailIdentityOp(
      request: CreateEmailIdentityRequest
    ) extends PinpointEmailOp[CreateEmailIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEmailIdentityResponse] =
        visitor.createEmailIdentity(request)
    }

    final case class DeleteConfigurationSetOp(
      request: DeleteConfigurationSetRequest
    ) extends PinpointEmailOp[DeleteConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetResponse] =
        visitor.deleteConfigurationSet(request)
    }

    final case class DeleteConfigurationSetEventDestinationOp(
      request: DeleteConfigurationSetEventDestinationRequest
    ) extends PinpointEmailOp[DeleteConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationSetEventDestinationResponse] =
        visitor.deleteConfigurationSetEventDestination(request)
    }

    final case class DeleteDedicatedIpPoolOp(
      request: DeleteDedicatedIpPoolRequest
    ) extends PinpointEmailOp[DeleteDedicatedIpPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDedicatedIpPoolResponse] =
        visitor.deleteDedicatedIpPool(request)
    }

    final case class DeleteEmailIdentityOp(
      request: DeleteEmailIdentityRequest
    ) extends PinpointEmailOp[DeleteEmailIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEmailIdentityResponse] =
        visitor.deleteEmailIdentity(request)
    }

    final case class GetAccountOp(
      request: GetAccountRequest
    ) extends PinpointEmailOp[GetAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountResponse] =
        visitor.getAccount(request)
    }

    final case class GetBlacklistReportsOp(
      request: GetBlacklistReportsRequest
    ) extends PinpointEmailOp[GetBlacklistReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBlacklistReportsResponse] =
        visitor.getBlacklistReports(request)
    }

    final case class GetConfigurationSetOp(
      request: GetConfigurationSetRequest
    ) extends PinpointEmailOp[GetConfigurationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigurationSetResponse] =
        visitor.getConfigurationSet(request)
    }

    final case class GetConfigurationSetEventDestinationsOp(
      request: GetConfigurationSetEventDestinationsRequest
    ) extends PinpointEmailOp[GetConfigurationSetEventDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigurationSetEventDestinationsResponse] =
        visitor.getConfigurationSetEventDestinations(request)
    }

    final case class GetDedicatedIpOp(
      request: GetDedicatedIpRequest
    ) extends PinpointEmailOp[GetDedicatedIpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDedicatedIpResponse] =
        visitor.getDedicatedIp(request)
    }

    final case class GetDedicatedIpsOp(
      request: GetDedicatedIpsRequest
    ) extends PinpointEmailOp[GetDedicatedIpsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDedicatedIpsResponse] =
        visitor.getDedicatedIps(request)
    }

    final case class GetDeliverabilityDashboardOptionsOp(
      request: GetDeliverabilityDashboardOptionsRequest
    ) extends PinpointEmailOp[GetDeliverabilityDashboardOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeliverabilityDashboardOptionsResponse] =
        visitor.getDeliverabilityDashboardOptions(request)
    }

    final case class GetDeliverabilityTestReportOp(
      request: GetDeliverabilityTestReportRequest
    ) extends PinpointEmailOp[GetDeliverabilityTestReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeliverabilityTestReportResponse] =
        visitor.getDeliverabilityTestReport(request)
    }

    final case class GetDomainDeliverabilityCampaignOp(
      request: GetDomainDeliverabilityCampaignRequest
    ) extends PinpointEmailOp[GetDomainDeliverabilityCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainDeliverabilityCampaignResponse] =
        visitor.getDomainDeliverabilityCampaign(request)
    }

    final case class GetDomainStatisticsReportOp(
      request: GetDomainStatisticsReportRequest
    ) extends PinpointEmailOp[GetDomainStatisticsReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainStatisticsReportResponse] =
        visitor.getDomainStatisticsReport(request)
    }

    final case class GetEmailIdentityOp(
      request: GetEmailIdentityRequest
    ) extends PinpointEmailOp[GetEmailIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEmailIdentityResponse] =
        visitor.getEmailIdentity(request)
    }

    final case class ListConfigurationSetsOp(
      request: ListConfigurationSetsRequest
    ) extends PinpointEmailOp[ListConfigurationSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationSetsResponse] =
        visitor.listConfigurationSets(request)
    }

    final case class ListDedicatedIpPoolsOp(
      request: ListDedicatedIpPoolsRequest
    ) extends PinpointEmailOp[ListDedicatedIpPoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDedicatedIpPoolsResponse] =
        visitor.listDedicatedIpPools(request)
    }

    final case class ListDeliverabilityTestReportsOp(
      request: ListDeliverabilityTestReportsRequest
    ) extends PinpointEmailOp[ListDeliverabilityTestReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeliverabilityTestReportsResponse] =
        visitor.listDeliverabilityTestReports(request)
    }

    final case class ListDomainDeliverabilityCampaignsOp(
      request: ListDomainDeliverabilityCampaignsRequest
    ) extends PinpointEmailOp[ListDomainDeliverabilityCampaignsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainDeliverabilityCampaignsResponse] =
        visitor.listDomainDeliverabilityCampaigns(request)
    }

    final case class ListEmailIdentitiesOp(
      request: ListEmailIdentitiesRequest
    ) extends PinpointEmailOp[ListEmailIdentitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEmailIdentitiesResponse] =
        visitor.listEmailIdentities(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends PinpointEmailOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutAccountDedicatedIpWarmupAttributesOp(
      request: PutAccountDedicatedIpWarmupAttributesRequest
    ) extends PinpointEmailOp[PutAccountDedicatedIpWarmupAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountDedicatedIpWarmupAttributesResponse] =
        visitor.putAccountDedicatedIpWarmupAttributes(request)
    }

    final case class PutAccountSendingAttributesOp(
      request: PutAccountSendingAttributesRequest
    ) extends PinpointEmailOp[PutAccountSendingAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountSendingAttributesResponse] =
        visitor.putAccountSendingAttributes(request)
    }

    final case class PutConfigurationSetDeliveryOptionsOp(
      request: PutConfigurationSetDeliveryOptionsRequest
    ) extends PinpointEmailOp[PutConfigurationSetDeliveryOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetDeliveryOptionsResponse] =
        visitor.putConfigurationSetDeliveryOptions(request)
    }

    final case class PutConfigurationSetReputationOptionsOp(
      request: PutConfigurationSetReputationOptionsRequest
    ) extends PinpointEmailOp[PutConfigurationSetReputationOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetReputationOptionsResponse] =
        visitor.putConfigurationSetReputationOptions(request)
    }

    final case class PutConfigurationSetSendingOptionsOp(
      request: PutConfigurationSetSendingOptionsRequest
    ) extends PinpointEmailOp[PutConfigurationSetSendingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetSendingOptionsResponse] =
        visitor.putConfigurationSetSendingOptions(request)
    }

    final case class PutConfigurationSetTrackingOptionsOp(
      request: PutConfigurationSetTrackingOptionsRequest
    ) extends PinpointEmailOp[PutConfigurationSetTrackingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationSetTrackingOptionsResponse] =
        visitor.putConfigurationSetTrackingOptions(request)
    }

    final case class PutDedicatedIpInPoolOp(
      request: PutDedicatedIpInPoolRequest
    ) extends PinpointEmailOp[PutDedicatedIpInPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDedicatedIpInPoolResponse] =
        visitor.putDedicatedIpInPool(request)
    }

    final case class PutDedicatedIpWarmupAttributesOp(
      request: PutDedicatedIpWarmupAttributesRequest
    ) extends PinpointEmailOp[PutDedicatedIpWarmupAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDedicatedIpWarmupAttributesResponse] =
        visitor.putDedicatedIpWarmupAttributes(request)
    }

    final case class PutDeliverabilityDashboardOptionOp(
      request: PutDeliverabilityDashboardOptionRequest
    ) extends PinpointEmailOp[PutDeliverabilityDashboardOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDeliverabilityDashboardOptionResponse] =
        visitor.putDeliverabilityDashboardOption(request)
    }

    final case class PutEmailIdentityDkimAttributesOp(
      request: PutEmailIdentityDkimAttributesRequest
    ) extends PinpointEmailOp[PutEmailIdentityDkimAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityDkimAttributesResponse] =
        visitor.putEmailIdentityDkimAttributes(request)
    }

    final case class PutEmailIdentityFeedbackAttributesOp(
      request: PutEmailIdentityFeedbackAttributesRequest
    ) extends PinpointEmailOp[PutEmailIdentityFeedbackAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityFeedbackAttributesResponse] =
        visitor.putEmailIdentityFeedbackAttributes(request)
    }

    final case class PutEmailIdentityMailFromAttributesOp(
      request: PutEmailIdentityMailFromAttributesRequest
    ) extends PinpointEmailOp[PutEmailIdentityMailFromAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEmailIdentityMailFromAttributesResponse] =
        visitor.putEmailIdentityMailFromAttributes(request)
    }

    final case class SendEmailOp(
      request: SendEmailRequest
    ) extends PinpointEmailOp[SendEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendEmailResponse] =
        visitor.sendEmail(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends PinpointEmailOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends PinpointEmailOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateConfigurationSetEventDestinationOp(
      request: UpdateConfigurationSetEventDestinationRequest
    ) extends PinpointEmailOp[UpdateConfigurationSetEventDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationSetEventDestinationResponse] =
        visitor.updateConfigurationSetEventDestination(request)
    }
  }

  import PinpointEmailOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PinpointEmailOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createConfigurationSet(
    request: CreateConfigurationSetRequest
  ): PinpointEmailIO[CreateConfigurationSetResponse] =
    FF.liftF(CreateConfigurationSetOp(request))

  def createConfigurationSetEventDestination(
    request: CreateConfigurationSetEventDestinationRequest
  ): PinpointEmailIO[CreateConfigurationSetEventDestinationResponse] =
    FF.liftF(CreateConfigurationSetEventDestinationOp(request))

  def createDedicatedIpPool(
    request: CreateDedicatedIpPoolRequest
  ): PinpointEmailIO[CreateDedicatedIpPoolResponse] =
    FF.liftF(CreateDedicatedIpPoolOp(request))

  def createDeliverabilityTestReport(
    request: CreateDeliverabilityTestReportRequest
  ): PinpointEmailIO[CreateDeliverabilityTestReportResponse] =
    FF.liftF(CreateDeliverabilityTestReportOp(request))

  def createEmailIdentity(
    request: CreateEmailIdentityRequest
  ): PinpointEmailIO[CreateEmailIdentityResponse] =
    FF.liftF(CreateEmailIdentityOp(request))

  def deleteConfigurationSet(
    request: DeleteConfigurationSetRequest
  ): PinpointEmailIO[DeleteConfigurationSetResponse] =
    FF.liftF(DeleteConfigurationSetOp(request))

  def deleteConfigurationSetEventDestination(
    request: DeleteConfigurationSetEventDestinationRequest
  ): PinpointEmailIO[DeleteConfigurationSetEventDestinationResponse] =
    FF.liftF(DeleteConfigurationSetEventDestinationOp(request))

  def deleteDedicatedIpPool(
    request: DeleteDedicatedIpPoolRequest
  ): PinpointEmailIO[DeleteDedicatedIpPoolResponse] =
    FF.liftF(DeleteDedicatedIpPoolOp(request))

  def deleteEmailIdentity(
    request: DeleteEmailIdentityRequest
  ): PinpointEmailIO[DeleteEmailIdentityResponse] =
    FF.liftF(DeleteEmailIdentityOp(request))

  def getAccount(
    request: GetAccountRequest
  ): PinpointEmailIO[GetAccountResponse] =
    FF.liftF(GetAccountOp(request))

  def getBlacklistReports(
    request: GetBlacklistReportsRequest
  ): PinpointEmailIO[GetBlacklistReportsResponse] =
    FF.liftF(GetBlacklistReportsOp(request))

  def getConfigurationSet(
    request: GetConfigurationSetRequest
  ): PinpointEmailIO[GetConfigurationSetResponse] =
    FF.liftF(GetConfigurationSetOp(request))

  def getConfigurationSetEventDestinations(
    request: GetConfigurationSetEventDestinationsRequest
  ): PinpointEmailIO[GetConfigurationSetEventDestinationsResponse] =
    FF.liftF(GetConfigurationSetEventDestinationsOp(request))

  def getDedicatedIp(
    request: GetDedicatedIpRequest
  ): PinpointEmailIO[GetDedicatedIpResponse] =
    FF.liftF(GetDedicatedIpOp(request))

  def getDedicatedIps(
    request: GetDedicatedIpsRequest
  ): PinpointEmailIO[GetDedicatedIpsResponse] =
    FF.liftF(GetDedicatedIpsOp(request))

  def getDeliverabilityDashboardOptions(
    request: GetDeliverabilityDashboardOptionsRequest
  ): PinpointEmailIO[GetDeliverabilityDashboardOptionsResponse] =
    FF.liftF(GetDeliverabilityDashboardOptionsOp(request))

  def getDeliverabilityTestReport(
    request: GetDeliverabilityTestReportRequest
  ): PinpointEmailIO[GetDeliverabilityTestReportResponse] =
    FF.liftF(GetDeliverabilityTestReportOp(request))

  def getDomainDeliverabilityCampaign(
    request: GetDomainDeliverabilityCampaignRequest
  ): PinpointEmailIO[GetDomainDeliverabilityCampaignResponse] =
    FF.liftF(GetDomainDeliverabilityCampaignOp(request))

  def getDomainStatisticsReport(
    request: GetDomainStatisticsReportRequest
  ): PinpointEmailIO[GetDomainStatisticsReportResponse] =
    FF.liftF(GetDomainStatisticsReportOp(request))

  def getEmailIdentity(
    request: GetEmailIdentityRequest
  ): PinpointEmailIO[GetEmailIdentityResponse] =
    FF.liftF(GetEmailIdentityOp(request))

  def listConfigurationSets(
    request: ListConfigurationSetsRequest
  ): PinpointEmailIO[ListConfigurationSetsResponse] =
    FF.liftF(ListConfigurationSetsOp(request))

  def listDedicatedIpPools(
    request: ListDedicatedIpPoolsRequest
  ): PinpointEmailIO[ListDedicatedIpPoolsResponse] =
    FF.liftF(ListDedicatedIpPoolsOp(request))

  def listDeliverabilityTestReports(
    request: ListDeliverabilityTestReportsRequest
  ): PinpointEmailIO[ListDeliverabilityTestReportsResponse] =
    FF.liftF(ListDeliverabilityTestReportsOp(request))

  def listDomainDeliverabilityCampaigns(
    request: ListDomainDeliverabilityCampaignsRequest
  ): PinpointEmailIO[ListDomainDeliverabilityCampaignsResponse] =
    FF.liftF(ListDomainDeliverabilityCampaignsOp(request))

  def listEmailIdentities(
    request: ListEmailIdentitiesRequest
  ): PinpointEmailIO[ListEmailIdentitiesResponse] =
    FF.liftF(ListEmailIdentitiesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): PinpointEmailIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putAccountDedicatedIpWarmupAttributes(
    request: PutAccountDedicatedIpWarmupAttributesRequest
  ): PinpointEmailIO[PutAccountDedicatedIpWarmupAttributesResponse] =
    FF.liftF(PutAccountDedicatedIpWarmupAttributesOp(request))

  def putAccountSendingAttributes(
    request: PutAccountSendingAttributesRequest
  ): PinpointEmailIO[PutAccountSendingAttributesResponse] =
    FF.liftF(PutAccountSendingAttributesOp(request))

  def putConfigurationSetDeliveryOptions(
    request: PutConfigurationSetDeliveryOptionsRequest
  ): PinpointEmailIO[PutConfigurationSetDeliveryOptionsResponse] =
    FF.liftF(PutConfigurationSetDeliveryOptionsOp(request))

  def putConfigurationSetReputationOptions(
    request: PutConfigurationSetReputationOptionsRequest
  ): PinpointEmailIO[PutConfigurationSetReputationOptionsResponse] =
    FF.liftF(PutConfigurationSetReputationOptionsOp(request))

  def putConfigurationSetSendingOptions(
    request: PutConfigurationSetSendingOptionsRequest
  ): PinpointEmailIO[PutConfigurationSetSendingOptionsResponse] =
    FF.liftF(PutConfigurationSetSendingOptionsOp(request))

  def putConfigurationSetTrackingOptions(
    request: PutConfigurationSetTrackingOptionsRequest
  ): PinpointEmailIO[PutConfigurationSetTrackingOptionsResponse] =
    FF.liftF(PutConfigurationSetTrackingOptionsOp(request))

  def putDedicatedIpInPool(
    request: PutDedicatedIpInPoolRequest
  ): PinpointEmailIO[PutDedicatedIpInPoolResponse] =
    FF.liftF(PutDedicatedIpInPoolOp(request))

  def putDedicatedIpWarmupAttributes(
    request: PutDedicatedIpWarmupAttributesRequest
  ): PinpointEmailIO[PutDedicatedIpWarmupAttributesResponse] =
    FF.liftF(PutDedicatedIpWarmupAttributesOp(request))

  def putDeliverabilityDashboardOption(
    request: PutDeliverabilityDashboardOptionRequest
  ): PinpointEmailIO[PutDeliverabilityDashboardOptionResponse] =
    FF.liftF(PutDeliverabilityDashboardOptionOp(request))

  def putEmailIdentityDkimAttributes(
    request: PutEmailIdentityDkimAttributesRequest
  ): PinpointEmailIO[PutEmailIdentityDkimAttributesResponse] =
    FF.liftF(PutEmailIdentityDkimAttributesOp(request))

  def putEmailIdentityFeedbackAttributes(
    request: PutEmailIdentityFeedbackAttributesRequest
  ): PinpointEmailIO[PutEmailIdentityFeedbackAttributesResponse] =
    FF.liftF(PutEmailIdentityFeedbackAttributesOp(request))

  def putEmailIdentityMailFromAttributes(
    request: PutEmailIdentityMailFromAttributesRequest
  ): PinpointEmailIO[PutEmailIdentityMailFromAttributesResponse] =
    FF.liftF(PutEmailIdentityMailFromAttributesOp(request))

  def sendEmail(
    request: SendEmailRequest
  ): PinpointEmailIO[SendEmailResponse] =
    FF.liftF(SendEmailOp(request))

  def tagResource(
    request: TagResourceRequest
  ): PinpointEmailIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): PinpointEmailIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateConfigurationSetEventDestination(
    request: UpdateConfigurationSetEventDestinationRequest
  ): PinpointEmailIO[UpdateConfigurationSetEventDestinationResponse] =
    FF.liftF(UpdateConfigurationSetEventDestinationOp(request))
}
