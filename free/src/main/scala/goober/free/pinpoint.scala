package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.pinpoint.PinpointClient
import software.amazon.awssdk.services.pinpoint.model._


object pinpoint { module =>

  // Free monad over PinpointOp
  type PinpointIO[A] = FF[PinpointOp, A]

  sealed trait PinpointOp[A] {
    def visit[F[_]](visitor: PinpointOp.Visitor[F]): F[A]
  }

  object PinpointOp {
    // Given a PinpointClient we can embed a PinpointIO program in any algebra that understands embedding.
    implicit val PinpointOpEmbeddable: Embeddable[PinpointOp, PinpointClient] = new Embeddable[PinpointOp, PinpointClient] {
      def embed[A](client: PinpointClient, io: PinpointIO[A]): Embedded[A] = Embedded.Pinpoint(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PinpointOp.Visitor[Kleisli[M, PinpointClient, *]] {
        def createApp(
          request: CreateAppRequest
        ): Kleisli[M, PinpointClient, CreateAppResponse] =
          primitive(_.createApp(request))

        def createCampaign(
          request: CreateCampaignRequest
        ): Kleisli[M, PinpointClient, CreateCampaignResponse] =
          primitive(_.createCampaign(request))

        def createEmailTemplate(
          request: CreateEmailTemplateRequest
        ): Kleisli[M, PinpointClient, CreateEmailTemplateResponse] =
          primitive(_.createEmailTemplate(request))

        def createExportJob(
          request: CreateExportJobRequest
        ): Kleisli[M, PinpointClient, CreateExportJobResponse] =
          primitive(_.createExportJob(request))

        def createImportJob(
          request: CreateImportJobRequest
        ): Kleisli[M, PinpointClient, CreateImportJobResponse] =
          primitive(_.createImportJob(request))

        def createJourney(
          request: CreateJourneyRequest
        ): Kleisli[M, PinpointClient, CreateJourneyResponse] =
          primitive(_.createJourney(request))

        def createPushTemplate(
          request: CreatePushTemplateRequest
        ): Kleisli[M, PinpointClient, CreatePushTemplateResponse] =
          primitive(_.createPushTemplate(request))

        def createRecommenderConfiguration(
          request: CreateRecommenderConfigurationRequest
        ): Kleisli[M, PinpointClient, CreateRecommenderConfigurationResponse] =
          primitive(_.createRecommenderConfiguration(request))

        def createSegment(
          request: CreateSegmentRequest
        ): Kleisli[M, PinpointClient, CreateSegmentResponse] =
          primitive(_.createSegment(request))

        def createSmsTemplate(
          request: CreateSmsTemplateRequest
        ): Kleisli[M, PinpointClient, CreateSmsTemplateResponse] =
          primitive(_.createSmsTemplate(request))

        def createVoiceTemplate(
          request: CreateVoiceTemplateRequest
        ): Kleisli[M, PinpointClient, CreateVoiceTemplateResponse] =
          primitive(_.createVoiceTemplate(request))

        def deleteAdmChannel(
          request: DeleteAdmChannelRequest
        ): Kleisli[M, PinpointClient, DeleteAdmChannelResponse] =
          primitive(_.deleteAdmChannel(request))

        def deleteApnsChannel(
          request: DeleteApnsChannelRequest
        ): Kleisli[M, PinpointClient, DeleteApnsChannelResponse] =
          primitive(_.deleteApnsChannel(request))

        def deleteApnsSandboxChannel(
          request: DeleteApnsSandboxChannelRequest
        ): Kleisli[M, PinpointClient, DeleteApnsSandboxChannelResponse] =
          primitive(_.deleteApnsSandboxChannel(request))

        def deleteApnsVoipChannel(
          request: DeleteApnsVoipChannelRequest
        ): Kleisli[M, PinpointClient, DeleteApnsVoipChannelResponse] =
          primitive(_.deleteApnsVoipChannel(request))

        def deleteApnsVoipSandboxChannel(
          request: DeleteApnsVoipSandboxChannelRequest
        ): Kleisli[M, PinpointClient, DeleteApnsVoipSandboxChannelResponse] =
          primitive(_.deleteApnsVoipSandboxChannel(request))

        def deleteApp(
          request: DeleteAppRequest
        ): Kleisli[M, PinpointClient, DeleteAppResponse] =
          primitive(_.deleteApp(request))

        def deleteBaiduChannel(
          request: DeleteBaiduChannelRequest
        ): Kleisli[M, PinpointClient, DeleteBaiduChannelResponse] =
          primitive(_.deleteBaiduChannel(request))

        def deleteCampaign(
          request: DeleteCampaignRequest
        ): Kleisli[M, PinpointClient, DeleteCampaignResponse] =
          primitive(_.deleteCampaign(request))

        def deleteEmailChannel(
          request: DeleteEmailChannelRequest
        ): Kleisli[M, PinpointClient, DeleteEmailChannelResponse] =
          primitive(_.deleteEmailChannel(request))

        def deleteEmailTemplate(
          request: DeleteEmailTemplateRequest
        ): Kleisli[M, PinpointClient, DeleteEmailTemplateResponse] =
          primitive(_.deleteEmailTemplate(request))

        def deleteEndpoint(
          request: DeleteEndpointRequest
        ): Kleisli[M, PinpointClient, DeleteEndpointResponse] =
          primitive(_.deleteEndpoint(request))

        def deleteEventStream(
          request: DeleteEventStreamRequest
        ): Kleisli[M, PinpointClient, DeleteEventStreamResponse] =
          primitive(_.deleteEventStream(request))

        def deleteGcmChannel(
          request: DeleteGcmChannelRequest
        ): Kleisli[M, PinpointClient, DeleteGcmChannelResponse] =
          primitive(_.deleteGcmChannel(request))

        def deleteJourney(
          request: DeleteJourneyRequest
        ): Kleisli[M, PinpointClient, DeleteJourneyResponse] =
          primitive(_.deleteJourney(request))

        def deletePushTemplate(
          request: DeletePushTemplateRequest
        ): Kleisli[M, PinpointClient, DeletePushTemplateResponse] =
          primitive(_.deletePushTemplate(request))

        def deleteRecommenderConfiguration(
          request: DeleteRecommenderConfigurationRequest
        ): Kleisli[M, PinpointClient, DeleteRecommenderConfigurationResponse] =
          primitive(_.deleteRecommenderConfiguration(request))

        def deleteSegment(
          request: DeleteSegmentRequest
        ): Kleisli[M, PinpointClient, DeleteSegmentResponse] =
          primitive(_.deleteSegment(request))

        def deleteSmsChannel(
          request: DeleteSmsChannelRequest
        ): Kleisli[M, PinpointClient, DeleteSmsChannelResponse] =
          primitive(_.deleteSmsChannel(request))

        def deleteSmsTemplate(
          request: DeleteSmsTemplateRequest
        ): Kleisli[M, PinpointClient, DeleteSmsTemplateResponse] =
          primitive(_.deleteSmsTemplate(request))

        def deleteUserEndpoints(
          request: DeleteUserEndpointsRequest
        ): Kleisli[M, PinpointClient, DeleteUserEndpointsResponse] =
          primitive(_.deleteUserEndpoints(request))

        def deleteVoiceChannel(
          request: DeleteVoiceChannelRequest
        ): Kleisli[M, PinpointClient, DeleteVoiceChannelResponse] =
          primitive(_.deleteVoiceChannel(request))

        def deleteVoiceTemplate(
          request: DeleteVoiceTemplateRequest
        ): Kleisli[M, PinpointClient, DeleteVoiceTemplateResponse] =
          primitive(_.deleteVoiceTemplate(request))

        def getAdmChannel(
          request: GetAdmChannelRequest
        ): Kleisli[M, PinpointClient, GetAdmChannelResponse] =
          primitive(_.getAdmChannel(request))

        def getApnsChannel(
          request: GetApnsChannelRequest
        ): Kleisli[M, PinpointClient, GetApnsChannelResponse] =
          primitive(_.getApnsChannel(request))

        def getApnsSandboxChannel(
          request: GetApnsSandboxChannelRequest
        ): Kleisli[M, PinpointClient, GetApnsSandboxChannelResponse] =
          primitive(_.getApnsSandboxChannel(request))

        def getApnsVoipChannel(
          request: GetApnsVoipChannelRequest
        ): Kleisli[M, PinpointClient, GetApnsVoipChannelResponse] =
          primitive(_.getApnsVoipChannel(request))

        def getApnsVoipSandboxChannel(
          request: GetApnsVoipSandboxChannelRequest
        ): Kleisli[M, PinpointClient, GetApnsVoipSandboxChannelResponse] =
          primitive(_.getApnsVoipSandboxChannel(request))

        def getApp(
          request: GetAppRequest
        ): Kleisli[M, PinpointClient, GetAppResponse] =
          primitive(_.getApp(request))

        def getApplicationDateRangeKpi(
          request: GetApplicationDateRangeKpiRequest
        ): Kleisli[M, PinpointClient, GetApplicationDateRangeKpiResponse] =
          primitive(_.getApplicationDateRangeKpi(request))

        def getApplicationSettings(
          request: GetApplicationSettingsRequest
        ): Kleisli[M, PinpointClient, GetApplicationSettingsResponse] =
          primitive(_.getApplicationSettings(request))

        def getApps(
          request: GetAppsRequest
        ): Kleisli[M, PinpointClient, GetAppsResponse] =
          primitive(_.getApps(request))

        def getBaiduChannel(
          request: GetBaiduChannelRequest
        ): Kleisli[M, PinpointClient, GetBaiduChannelResponse] =
          primitive(_.getBaiduChannel(request))

        def getCampaign(
          request: GetCampaignRequest
        ): Kleisli[M, PinpointClient, GetCampaignResponse] =
          primitive(_.getCampaign(request))

        def getCampaignActivities(
          request: GetCampaignActivitiesRequest
        ): Kleisli[M, PinpointClient, GetCampaignActivitiesResponse] =
          primitive(_.getCampaignActivities(request))

        def getCampaignDateRangeKpi(
          request: GetCampaignDateRangeKpiRequest
        ): Kleisli[M, PinpointClient, GetCampaignDateRangeKpiResponse] =
          primitive(_.getCampaignDateRangeKpi(request))

        def getCampaignVersion(
          request: GetCampaignVersionRequest
        ): Kleisli[M, PinpointClient, GetCampaignVersionResponse] =
          primitive(_.getCampaignVersion(request))

        def getCampaignVersions(
          request: GetCampaignVersionsRequest
        ): Kleisli[M, PinpointClient, GetCampaignVersionsResponse] =
          primitive(_.getCampaignVersions(request))

        def getCampaigns(
          request: GetCampaignsRequest
        ): Kleisli[M, PinpointClient, GetCampaignsResponse] =
          primitive(_.getCampaigns(request))

        def getChannels(
          request: GetChannelsRequest
        ): Kleisli[M, PinpointClient, GetChannelsResponse] =
          primitive(_.getChannels(request))

        def getEmailChannel(
          request: GetEmailChannelRequest
        ): Kleisli[M, PinpointClient, GetEmailChannelResponse] =
          primitive(_.getEmailChannel(request))

        def getEmailTemplate(
          request: GetEmailTemplateRequest
        ): Kleisli[M, PinpointClient, GetEmailTemplateResponse] =
          primitive(_.getEmailTemplate(request))

        def getEndpoint(
          request: GetEndpointRequest
        ): Kleisli[M, PinpointClient, GetEndpointResponse] =
          primitive(_.getEndpoint(request))

        def getEventStream(
          request: GetEventStreamRequest
        ): Kleisli[M, PinpointClient, GetEventStreamResponse] =
          primitive(_.getEventStream(request))

        def getExportJob(
          request: GetExportJobRequest
        ): Kleisli[M, PinpointClient, GetExportJobResponse] =
          primitive(_.getExportJob(request))

        def getExportJobs(
          request: GetExportJobsRequest
        ): Kleisli[M, PinpointClient, GetExportJobsResponse] =
          primitive(_.getExportJobs(request))

        def getGcmChannel(
          request: GetGcmChannelRequest
        ): Kleisli[M, PinpointClient, GetGcmChannelResponse] =
          primitive(_.getGcmChannel(request))

        def getImportJob(
          request: GetImportJobRequest
        ): Kleisli[M, PinpointClient, GetImportJobResponse] =
          primitive(_.getImportJob(request))

        def getImportJobs(
          request: GetImportJobsRequest
        ): Kleisli[M, PinpointClient, GetImportJobsResponse] =
          primitive(_.getImportJobs(request))

        def getJourney(
          request: GetJourneyRequest
        ): Kleisli[M, PinpointClient, GetJourneyResponse] =
          primitive(_.getJourney(request))

        def getJourneyDateRangeKpi(
          request: GetJourneyDateRangeKpiRequest
        ): Kleisli[M, PinpointClient, GetJourneyDateRangeKpiResponse] =
          primitive(_.getJourneyDateRangeKpi(request))

        def getJourneyExecutionActivityMetrics(
          request: GetJourneyExecutionActivityMetricsRequest
        ): Kleisli[M, PinpointClient, GetJourneyExecutionActivityMetricsResponse] =
          primitive(_.getJourneyExecutionActivityMetrics(request))

        def getJourneyExecutionMetrics(
          request: GetJourneyExecutionMetricsRequest
        ): Kleisli[M, PinpointClient, GetJourneyExecutionMetricsResponse] =
          primitive(_.getJourneyExecutionMetrics(request))

        def getPushTemplate(
          request: GetPushTemplateRequest
        ): Kleisli[M, PinpointClient, GetPushTemplateResponse] =
          primitive(_.getPushTemplate(request))

        def getRecommenderConfiguration(
          request: GetRecommenderConfigurationRequest
        ): Kleisli[M, PinpointClient, GetRecommenderConfigurationResponse] =
          primitive(_.getRecommenderConfiguration(request))

        def getRecommenderConfigurations(
          request: GetRecommenderConfigurationsRequest
        ): Kleisli[M, PinpointClient, GetRecommenderConfigurationsResponse] =
          primitive(_.getRecommenderConfigurations(request))

        def getSegment(
          request: GetSegmentRequest
        ): Kleisli[M, PinpointClient, GetSegmentResponse] =
          primitive(_.getSegment(request))

        def getSegmentExportJobs(
          request: GetSegmentExportJobsRequest
        ): Kleisli[M, PinpointClient, GetSegmentExportJobsResponse] =
          primitive(_.getSegmentExportJobs(request))

        def getSegmentImportJobs(
          request: GetSegmentImportJobsRequest
        ): Kleisli[M, PinpointClient, GetSegmentImportJobsResponse] =
          primitive(_.getSegmentImportJobs(request))

        def getSegmentVersion(
          request: GetSegmentVersionRequest
        ): Kleisli[M, PinpointClient, GetSegmentVersionResponse] =
          primitive(_.getSegmentVersion(request))

        def getSegmentVersions(
          request: GetSegmentVersionsRequest
        ): Kleisli[M, PinpointClient, GetSegmentVersionsResponse] =
          primitive(_.getSegmentVersions(request))

        def getSegments(
          request: GetSegmentsRequest
        ): Kleisli[M, PinpointClient, GetSegmentsResponse] =
          primitive(_.getSegments(request))

        def getSmsChannel(
          request: GetSmsChannelRequest
        ): Kleisli[M, PinpointClient, GetSmsChannelResponse] =
          primitive(_.getSmsChannel(request))

        def getSmsTemplate(
          request: GetSmsTemplateRequest
        ): Kleisli[M, PinpointClient, GetSmsTemplateResponse] =
          primitive(_.getSmsTemplate(request))

        def getUserEndpoints(
          request: GetUserEndpointsRequest
        ): Kleisli[M, PinpointClient, GetUserEndpointsResponse] =
          primitive(_.getUserEndpoints(request))

        def getVoiceChannel(
          request: GetVoiceChannelRequest
        ): Kleisli[M, PinpointClient, GetVoiceChannelResponse] =
          primitive(_.getVoiceChannel(request))

        def getVoiceTemplate(
          request: GetVoiceTemplateRequest
        ): Kleisli[M, PinpointClient, GetVoiceTemplateResponse] =
          primitive(_.getVoiceTemplate(request))

        def listJourneys(
          request: ListJourneysRequest
        ): Kleisli[M, PinpointClient, ListJourneysResponse] =
          primitive(_.listJourneys(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, PinpointClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTemplateVersions(
          request: ListTemplateVersionsRequest
        ): Kleisli[M, PinpointClient, ListTemplateVersionsResponse] =
          primitive(_.listTemplateVersions(request))

        def listTemplates(
          request: ListTemplatesRequest
        ): Kleisli[M, PinpointClient, ListTemplatesResponse] =
          primitive(_.listTemplates(request))

        def phoneNumberValidate(
          request: PhoneNumberValidateRequest
        ): Kleisli[M, PinpointClient, PhoneNumberValidateResponse] =
          primitive(_.phoneNumberValidate(request))

        def putEventStream(
          request: PutEventStreamRequest
        ): Kleisli[M, PinpointClient, PutEventStreamResponse] =
          primitive(_.putEventStream(request))

        def putEvents(
          request: PutEventsRequest
        ): Kleisli[M, PinpointClient, PutEventsResponse] =
          primitive(_.putEvents(request))

        def removeAttributes(
          request: RemoveAttributesRequest
        ): Kleisli[M, PinpointClient, RemoveAttributesResponse] =
          primitive(_.removeAttributes(request))

        def sendMessages(
          request: SendMessagesRequest
        ): Kleisli[M, PinpointClient, SendMessagesResponse] =
          primitive(_.sendMessages(request))

        def sendUsersMessages(
          request: SendUsersMessagesRequest
        ): Kleisli[M, PinpointClient, SendUsersMessagesResponse] =
          primitive(_.sendUsersMessages(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, PinpointClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, PinpointClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAdmChannel(
          request: UpdateAdmChannelRequest
        ): Kleisli[M, PinpointClient, UpdateAdmChannelResponse] =
          primitive(_.updateAdmChannel(request))

        def updateApnsChannel(
          request: UpdateApnsChannelRequest
        ): Kleisli[M, PinpointClient, UpdateApnsChannelResponse] =
          primitive(_.updateApnsChannel(request))

        def updateApnsSandboxChannel(
          request: UpdateApnsSandboxChannelRequest
        ): Kleisli[M, PinpointClient, UpdateApnsSandboxChannelResponse] =
          primitive(_.updateApnsSandboxChannel(request))

        def updateApnsVoipChannel(
          request: UpdateApnsVoipChannelRequest
        ): Kleisli[M, PinpointClient, UpdateApnsVoipChannelResponse] =
          primitive(_.updateApnsVoipChannel(request))

        def updateApnsVoipSandboxChannel(
          request: UpdateApnsVoipSandboxChannelRequest
        ): Kleisli[M, PinpointClient, UpdateApnsVoipSandboxChannelResponse] =
          primitive(_.updateApnsVoipSandboxChannel(request))

        def updateApplicationSettings(
          request: UpdateApplicationSettingsRequest
        ): Kleisli[M, PinpointClient, UpdateApplicationSettingsResponse] =
          primitive(_.updateApplicationSettings(request))

        def updateBaiduChannel(
          request: UpdateBaiduChannelRequest
        ): Kleisli[M, PinpointClient, UpdateBaiduChannelResponse] =
          primitive(_.updateBaiduChannel(request))

        def updateCampaign(
          request: UpdateCampaignRequest
        ): Kleisli[M, PinpointClient, UpdateCampaignResponse] =
          primitive(_.updateCampaign(request))

        def updateEmailChannel(
          request: UpdateEmailChannelRequest
        ): Kleisli[M, PinpointClient, UpdateEmailChannelResponse] =
          primitive(_.updateEmailChannel(request))

        def updateEmailTemplate(
          request: UpdateEmailTemplateRequest
        ): Kleisli[M, PinpointClient, UpdateEmailTemplateResponse] =
          primitive(_.updateEmailTemplate(request))

        def updateEndpoint(
          request: UpdateEndpointRequest
        ): Kleisli[M, PinpointClient, UpdateEndpointResponse] =
          primitive(_.updateEndpoint(request))

        def updateEndpointsBatch(
          request: UpdateEndpointsBatchRequest
        ): Kleisli[M, PinpointClient, UpdateEndpointsBatchResponse] =
          primitive(_.updateEndpointsBatch(request))

        def updateGcmChannel(
          request: UpdateGcmChannelRequest
        ): Kleisli[M, PinpointClient, UpdateGcmChannelResponse] =
          primitive(_.updateGcmChannel(request))

        def updateJourney(
          request: UpdateJourneyRequest
        ): Kleisli[M, PinpointClient, UpdateJourneyResponse] =
          primitive(_.updateJourney(request))

        def updateJourneyState(
          request: UpdateJourneyStateRequest
        ): Kleisli[M, PinpointClient, UpdateJourneyStateResponse] =
          primitive(_.updateJourneyState(request))

        def updatePushTemplate(
          request: UpdatePushTemplateRequest
        ): Kleisli[M, PinpointClient, UpdatePushTemplateResponse] =
          primitive(_.updatePushTemplate(request))

        def updateRecommenderConfiguration(
          request: UpdateRecommenderConfigurationRequest
        ): Kleisli[M, PinpointClient, UpdateRecommenderConfigurationResponse] =
          primitive(_.updateRecommenderConfiguration(request))

        def updateSegment(
          request: UpdateSegmentRequest
        ): Kleisli[M, PinpointClient, UpdateSegmentResponse] =
          primitive(_.updateSegment(request))

        def updateSmsChannel(
          request: UpdateSmsChannelRequest
        ): Kleisli[M, PinpointClient, UpdateSmsChannelResponse] =
          primitive(_.updateSmsChannel(request))

        def updateSmsTemplate(
          request: UpdateSmsTemplateRequest
        ): Kleisli[M, PinpointClient, UpdateSmsTemplateResponse] =
          primitive(_.updateSmsTemplate(request))

        def updateTemplateActiveVersion(
          request: UpdateTemplateActiveVersionRequest
        ): Kleisli[M, PinpointClient, UpdateTemplateActiveVersionResponse] =
          primitive(_.updateTemplateActiveVersion(request))

        def updateVoiceChannel(
          request: UpdateVoiceChannelRequest
        ): Kleisli[M, PinpointClient, UpdateVoiceChannelResponse] =
          primitive(_.updateVoiceChannel(request))

        def updateVoiceTemplate(
          request: UpdateVoiceTemplateRequest
        ): Kleisli[M, PinpointClient, UpdateVoiceTemplateResponse] =
          primitive(_.updateVoiceTemplate(request))

        def primitive[A](
          f: PinpointClient => A
        ): Kleisli[M, PinpointClient, A]
      }
    }

    trait Visitor[F[_]] extends (PinpointOp ~> F) {
      final def apply[A](op: PinpointOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApp(
        request: CreateAppRequest
      ): F[CreateAppResponse]

      def createCampaign(
        request: CreateCampaignRequest
      ): F[CreateCampaignResponse]

      def createEmailTemplate(
        request: CreateEmailTemplateRequest
      ): F[CreateEmailTemplateResponse]

      def createExportJob(
        request: CreateExportJobRequest
      ): F[CreateExportJobResponse]

      def createImportJob(
        request: CreateImportJobRequest
      ): F[CreateImportJobResponse]

      def createJourney(
        request: CreateJourneyRequest
      ): F[CreateJourneyResponse]

      def createPushTemplate(
        request: CreatePushTemplateRequest
      ): F[CreatePushTemplateResponse]

      def createRecommenderConfiguration(
        request: CreateRecommenderConfigurationRequest
      ): F[CreateRecommenderConfigurationResponse]

      def createSegment(
        request: CreateSegmentRequest
      ): F[CreateSegmentResponse]

      def createSmsTemplate(
        request: CreateSmsTemplateRequest
      ): F[CreateSmsTemplateResponse]

      def createVoiceTemplate(
        request: CreateVoiceTemplateRequest
      ): F[CreateVoiceTemplateResponse]

      def deleteAdmChannel(
        request: DeleteAdmChannelRequest
      ): F[DeleteAdmChannelResponse]

      def deleteApnsChannel(
        request: DeleteApnsChannelRequest
      ): F[DeleteApnsChannelResponse]

      def deleteApnsSandboxChannel(
        request: DeleteApnsSandboxChannelRequest
      ): F[DeleteApnsSandboxChannelResponse]

      def deleteApnsVoipChannel(
        request: DeleteApnsVoipChannelRequest
      ): F[DeleteApnsVoipChannelResponse]

      def deleteApnsVoipSandboxChannel(
        request: DeleteApnsVoipSandboxChannelRequest
      ): F[DeleteApnsVoipSandboxChannelResponse]

      def deleteApp(
        request: DeleteAppRequest
      ): F[DeleteAppResponse]

      def deleteBaiduChannel(
        request: DeleteBaiduChannelRequest
      ): F[DeleteBaiduChannelResponse]

      def deleteCampaign(
        request: DeleteCampaignRequest
      ): F[DeleteCampaignResponse]

      def deleteEmailChannel(
        request: DeleteEmailChannelRequest
      ): F[DeleteEmailChannelResponse]

      def deleteEmailTemplate(
        request: DeleteEmailTemplateRequest
      ): F[DeleteEmailTemplateResponse]

      def deleteEndpoint(
        request: DeleteEndpointRequest
      ): F[DeleteEndpointResponse]

      def deleteEventStream(
        request: DeleteEventStreamRequest
      ): F[DeleteEventStreamResponse]

      def deleteGcmChannel(
        request: DeleteGcmChannelRequest
      ): F[DeleteGcmChannelResponse]

      def deleteJourney(
        request: DeleteJourneyRequest
      ): F[DeleteJourneyResponse]

      def deletePushTemplate(
        request: DeletePushTemplateRequest
      ): F[DeletePushTemplateResponse]

      def deleteRecommenderConfiguration(
        request: DeleteRecommenderConfigurationRequest
      ): F[DeleteRecommenderConfigurationResponse]

      def deleteSegment(
        request: DeleteSegmentRequest
      ): F[DeleteSegmentResponse]

      def deleteSmsChannel(
        request: DeleteSmsChannelRequest
      ): F[DeleteSmsChannelResponse]

      def deleteSmsTemplate(
        request: DeleteSmsTemplateRequest
      ): F[DeleteSmsTemplateResponse]

      def deleteUserEndpoints(
        request: DeleteUserEndpointsRequest
      ): F[DeleteUserEndpointsResponse]

      def deleteVoiceChannel(
        request: DeleteVoiceChannelRequest
      ): F[DeleteVoiceChannelResponse]

      def deleteVoiceTemplate(
        request: DeleteVoiceTemplateRequest
      ): F[DeleteVoiceTemplateResponse]

      def getAdmChannel(
        request: GetAdmChannelRequest
      ): F[GetAdmChannelResponse]

      def getApnsChannel(
        request: GetApnsChannelRequest
      ): F[GetApnsChannelResponse]

      def getApnsSandboxChannel(
        request: GetApnsSandboxChannelRequest
      ): F[GetApnsSandboxChannelResponse]

      def getApnsVoipChannel(
        request: GetApnsVoipChannelRequest
      ): F[GetApnsVoipChannelResponse]

      def getApnsVoipSandboxChannel(
        request: GetApnsVoipSandboxChannelRequest
      ): F[GetApnsVoipSandboxChannelResponse]

      def getApp(
        request: GetAppRequest
      ): F[GetAppResponse]

      def getApplicationDateRangeKpi(
        request: GetApplicationDateRangeKpiRequest
      ): F[GetApplicationDateRangeKpiResponse]

      def getApplicationSettings(
        request: GetApplicationSettingsRequest
      ): F[GetApplicationSettingsResponse]

      def getApps(
        request: GetAppsRequest
      ): F[GetAppsResponse]

      def getBaiduChannel(
        request: GetBaiduChannelRequest
      ): F[GetBaiduChannelResponse]

      def getCampaign(
        request: GetCampaignRequest
      ): F[GetCampaignResponse]

      def getCampaignActivities(
        request: GetCampaignActivitiesRequest
      ): F[GetCampaignActivitiesResponse]

      def getCampaignDateRangeKpi(
        request: GetCampaignDateRangeKpiRequest
      ): F[GetCampaignDateRangeKpiResponse]

      def getCampaignVersion(
        request: GetCampaignVersionRequest
      ): F[GetCampaignVersionResponse]

      def getCampaignVersions(
        request: GetCampaignVersionsRequest
      ): F[GetCampaignVersionsResponse]

      def getCampaigns(
        request: GetCampaignsRequest
      ): F[GetCampaignsResponse]

      def getChannels(
        request: GetChannelsRequest
      ): F[GetChannelsResponse]

      def getEmailChannel(
        request: GetEmailChannelRequest
      ): F[GetEmailChannelResponse]

      def getEmailTemplate(
        request: GetEmailTemplateRequest
      ): F[GetEmailTemplateResponse]

      def getEndpoint(
        request: GetEndpointRequest
      ): F[GetEndpointResponse]

      def getEventStream(
        request: GetEventStreamRequest
      ): F[GetEventStreamResponse]

      def getExportJob(
        request: GetExportJobRequest
      ): F[GetExportJobResponse]

      def getExportJobs(
        request: GetExportJobsRequest
      ): F[GetExportJobsResponse]

      def getGcmChannel(
        request: GetGcmChannelRequest
      ): F[GetGcmChannelResponse]

      def getImportJob(
        request: GetImportJobRequest
      ): F[GetImportJobResponse]

      def getImportJobs(
        request: GetImportJobsRequest
      ): F[GetImportJobsResponse]

      def getJourney(
        request: GetJourneyRequest
      ): F[GetJourneyResponse]

      def getJourneyDateRangeKpi(
        request: GetJourneyDateRangeKpiRequest
      ): F[GetJourneyDateRangeKpiResponse]

      def getJourneyExecutionActivityMetrics(
        request: GetJourneyExecutionActivityMetricsRequest
      ): F[GetJourneyExecutionActivityMetricsResponse]

      def getJourneyExecutionMetrics(
        request: GetJourneyExecutionMetricsRequest
      ): F[GetJourneyExecutionMetricsResponse]

      def getPushTemplate(
        request: GetPushTemplateRequest
      ): F[GetPushTemplateResponse]

      def getRecommenderConfiguration(
        request: GetRecommenderConfigurationRequest
      ): F[GetRecommenderConfigurationResponse]

      def getRecommenderConfigurations(
        request: GetRecommenderConfigurationsRequest
      ): F[GetRecommenderConfigurationsResponse]

      def getSegment(
        request: GetSegmentRequest
      ): F[GetSegmentResponse]

      def getSegmentExportJobs(
        request: GetSegmentExportJobsRequest
      ): F[GetSegmentExportJobsResponse]

      def getSegmentImportJobs(
        request: GetSegmentImportJobsRequest
      ): F[GetSegmentImportJobsResponse]

      def getSegmentVersion(
        request: GetSegmentVersionRequest
      ): F[GetSegmentVersionResponse]

      def getSegmentVersions(
        request: GetSegmentVersionsRequest
      ): F[GetSegmentVersionsResponse]

      def getSegments(
        request: GetSegmentsRequest
      ): F[GetSegmentsResponse]

      def getSmsChannel(
        request: GetSmsChannelRequest
      ): F[GetSmsChannelResponse]

      def getSmsTemplate(
        request: GetSmsTemplateRequest
      ): F[GetSmsTemplateResponse]

      def getUserEndpoints(
        request: GetUserEndpointsRequest
      ): F[GetUserEndpointsResponse]

      def getVoiceChannel(
        request: GetVoiceChannelRequest
      ): F[GetVoiceChannelResponse]

      def getVoiceTemplate(
        request: GetVoiceTemplateRequest
      ): F[GetVoiceTemplateResponse]

      def listJourneys(
        request: ListJourneysRequest
      ): F[ListJourneysResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTemplateVersions(
        request: ListTemplateVersionsRequest
      ): F[ListTemplateVersionsResponse]

      def listTemplates(
        request: ListTemplatesRequest
      ): F[ListTemplatesResponse]

      def phoneNumberValidate(
        request: PhoneNumberValidateRequest
      ): F[PhoneNumberValidateResponse]

      def putEventStream(
        request: PutEventStreamRequest
      ): F[PutEventStreamResponse]

      def putEvents(
        request: PutEventsRequest
      ): F[PutEventsResponse]

      def removeAttributes(
        request: RemoveAttributesRequest
      ): F[RemoveAttributesResponse]

      def sendMessages(
        request: SendMessagesRequest
      ): F[SendMessagesResponse]

      def sendUsersMessages(
        request: SendUsersMessagesRequest
      ): F[SendUsersMessagesResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAdmChannel(
        request: UpdateAdmChannelRequest
      ): F[UpdateAdmChannelResponse]

      def updateApnsChannel(
        request: UpdateApnsChannelRequest
      ): F[UpdateApnsChannelResponse]

      def updateApnsSandboxChannel(
        request: UpdateApnsSandboxChannelRequest
      ): F[UpdateApnsSandboxChannelResponse]

      def updateApnsVoipChannel(
        request: UpdateApnsVoipChannelRequest
      ): F[UpdateApnsVoipChannelResponse]

      def updateApnsVoipSandboxChannel(
        request: UpdateApnsVoipSandboxChannelRequest
      ): F[UpdateApnsVoipSandboxChannelResponse]

      def updateApplicationSettings(
        request: UpdateApplicationSettingsRequest
      ): F[UpdateApplicationSettingsResponse]

      def updateBaiduChannel(
        request: UpdateBaiduChannelRequest
      ): F[UpdateBaiduChannelResponse]

      def updateCampaign(
        request: UpdateCampaignRequest
      ): F[UpdateCampaignResponse]

      def updateEmailChannel(
        request: UpdateEmailChannelRequest
      ): F[UpdateEmailChannelResponse]

      def updateEmailTemplate(
        request: UpdateEmailTemplateRequest
      ): F[UpdateEmailTemplateResponse]

      def updateEndpoint(
        request: UpdateEndpointRequest
      ): F[UpdateEndpointResponse]

      def updateEndpointsBatch(
        request: UpdateEndpointsBatchRequest
      ): F[UpdateEndpointsBatchResponse]

      def updateGcmChannel(
        request: UpdateGcmChannelRequest
      ): F[UpdateGcmChannelResponse]

      def updateJourney(
        request: UpdateJourneyRequest
      ): F[UpdateJourneyResponse]

      def updateJourneyState(
        request: UpdateJourneyStateRequest
      ): F[UpdateJourneyStateResponse]

      def updatePushTemplate(
        request: UpdatePushTemplateRequest
      ): F[UpdatePushTemplateResponse]

      def updateRecommenderConfiguration(
        request: UpdateRecommenderConfigurationRequest
      ): F[UpdateRecommenderConfigurationResponse]

      def updateSegment(
        request: UpdateSegmentRequest
      ): F[UpdateSegmentResponse]

      def updateSmsChannel(
        request: UpdateSmsChannelRequest
      ): F[UpdateSmsChannelResponse]

      def updateSmsTemplate(
        request: UpdateSmsTemplateRequest
      ): F[UpdateSmsTemplateResponse]

      def updateTemplateActiveVersion(
        request: UpdateTemplateActiveVersionRequest
      ): F[UpdateTemplateActiveVersionResponse]

      def updateVoiceChannel(
        request: UpdateVoiceChannelRequest
      ): F[UpdateVoiceChannelResponse]

      def updateVoiceTemplate(
        request: UpdateVoiceTemplateRequest
      ): F[UpdateVoiceTemplateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PinpointOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAppOp(
      request: CreateAppRequest
    ) extends PinpointOp[CreateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppResponse] =
        visitor.createApp(request)
    }

    final case class CreateCampaignOp(
      request: CreateCampaignRequest
    ) extends PinpointOp[CreateCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCampaignResponse] =
        visitor.createCampaign(request)
    }

    final case class CreateEmailTemplateOp(
      request: CreateEmailTemplateRequest
    ) extends PinpointOp[CreateEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEmailTemplateResponse] =
        visitor.createEmailTemplate(request)
    }

    final case class CreateExportJobOp(
      request: CreateExportJobRequest
    ) extends PinpointOp[CreateExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateExportJobResponse] =
        visitor.createExportJob(request)
    }

    final case class CreateImportJobOp(
      request: CreateImportJobRequest
    ) extends PinpointOp[CreateImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImportJobResponse] =
        visitor.createImportJob(request)
    }

    final case class CreateJourneyOp(
      request: CreateJourneyRequest
    ) extends PinpointOp[CreateJourneyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJourneyResponse] =
        visitor.createJourney(request)
    }

    final case class CreatePushTemplateOp(
      request: CreatePushTemplateRequest
    ) extends PinpointOp[CreatePushTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePushTemplateResponse] =
        visitor.createPushTemplate(request)
    }

    final case class CreateRecommenderConfigurationOp(
      request: CreateRecommenderConfigurationRequest
    ) extends PinpointOp[CreateRecommenderConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRecommenderConfigurationResponse] =
        visitor.createRecommenderConfiguration(request)
    }

    final case class CreateSegmentOp(
      request: CreateSegmentRequest
    ) extends PinpointOp[CreateSegmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSegmentResponse] =
        visitor.createSegment(request)
    }

    final case class CreateSmsTemplateOp(
      request: CreateSmsTemplateRequest
    ) extends PinpointOp[CreateSmsTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSmsTemplateResponse] =
        visitor.createSmsTemplate(request)
    }

    final case class CreateVoiceTemplateOp(
      request: CreateVoiceTemplateRequest
    ) extends PinpointOp[CreateVoiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVoiceTemplateResponse] =
        visitor.createVoiceTemplate(request)
    }

    final case class DeleteAdmChannelOp(
      request: DeleteAdmChannelRequest
    ) extends PinpointOp[DeleteAdmChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAdmChannelResponse] =
        visitor.deleteAdmChannel(request)
    }

    final case class DeleteApnsChannelOp(
      request: DeleteApnsChannelRequest
    ) extends PinpointOp[DeleteApnsChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApnsChannelResponse] =
        visitor.deleteApnsChannel(request)
    }

    final case class DeleteApnsSandboxChannelOp(
      request: DeleteApnsSandboxChannelRequest
    ) extends PinpointOp[DeleteApnsSandboxChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApnsSandboxChannelResponse] =
        visitor.deleteApnsSandboxChannel(request)
    }

    final case class DeleteApnsVoipChannelOp(
      request: DeleteApnsVoipChannelRequest
    ) extends PinpointOp[DeleteApnsVoipChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApnsVoipChannelResponse] =
        visitor.deleteApnsVoipChannel(request)
    }

    final case class DeleteApnsVoipSandboxChannelOp(
      request: DeleteApnsVoipSandboxChannelRequest
    ) extends PinpointOp[DeleteApnsVoipSandboxChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApnsVoipSandboxChannelResponse] =
        visitor.deleteApnsVoipSandboxChannel(request)
    }

    final case class DeleteAppOp(
      request: DeleteAppRequest
    ) extends PinpointOp[DeleteAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppResponse] =
        visitor.deleteApp(request)
    }

    final case class DeleteBaiduChannelOp(
      request: DeleteBaiduChannelRequest
    ) extends PinpointOp[DeleteBaiduChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBaiduChannelResponse] =
        visitor.deleteBaiduChannel(request)
    }

    final case class DeleteCampaignOp(
      request: DeleteCampaignRequest
    ) extends PinpointOp[DeleteCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCampaignResponse] =
        visitor.deleteCampaign(request)
    }

    final case class DeleteEmailChannelOp(
      request: DeleteEmailChannelRequest
    ) extends PinpointOp[DeleteEmailChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEmailChannelResponse] =
        visitor.deleteEmailChannel(request)
    }

    final case class DeleteEmailTemplateOp(
      request: DeleteEmailTemplateRequest
    ) extends PinpointOp[DeleteEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEmailTemplateResponse] =
        visitor.deleteEmailTemplate(request)
    }

    final case class DeleteEndpointOp(
      request: DeleteEndpointRequest
    ) extends PinpointOp[DeleteEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointResponse] =
        visitor.deleteEndpoint(request)
    }

    final case class DeleteEventStreamOp(
      request: DeleteEventStreamRequest
    ) extends PinpointOp[DeleteEventStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventStreamResponse] =
        visitor.deleteEventStream(request)
    }

    final case class DeleteGcmChannelOp(
      request: DeleteGcmChannelRequest
    ) extends PinpointOp[DeleteGcmChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGcmChannelResponse] =
        visitor.deleteGcmChannel(request)
    }

    final case class DeleteJourneyOp(
      request: DeleteJourneyRequest
    ) extends PinpointOp[DeleteJourneyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJourneyResponse] =
        visitor.deleteJourney(request)
    }

    final case class DeletePushTemplateOp(
      request: DeletePushTemplateRequest
    ) extends PinpointOp[DeletePushTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePushTemplateResponse] =
        visitor.deletePushTemplate(request)
    }

    final case class DeleteRecommenderConfigurationOp(
      request: DeleteRecommenderConfigurationRequest
    ) extends PinpointOp[DeleteRecommenderConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRecommenderConfigurationResponse] =
        visitor.deleteRecommenderConfiguration(request)
    }

    final case class DeleteSegmentOp(
      request: DeleteSegmentRequest
    ) extends PinpointOp[DeleteSegmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSegmentResponse] =
        visitor.deleteSegment(request)
    }

    final case class DeleteSmsChannelOp(
      request: DeleteSmsChannelRequest
    ) extends PinpointOp[DeleteSmsChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSmsChannelResponse] =
        visitor.deleteSmsChannel(request)
    }

    final case class DeleteSmsTemplateOp(
      request: DeleteSmsTemplateRequest
    ) extends PinpointOp[DeleteSmsTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSmsTemplateResponse] =
        visitor.deleteSmsTemplate(request)
    }

    final case class DeleteUserEndpointsOp(
      request: DeleteUserEndpointsRequest
    ) extends PinpointOp[DeleteUserEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserEndpointsResponse] =
        visitor.deleteUserEndpoints(request)
    }

    final case class DeleteVoiceChannelOp(
      request: DeleteVoiceChannelRequest
    ) extends PinpointOp[DeleteVoiceChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceChannelResponse] =
        visitor.deleteVoiceChannel(request)
    }

    final case class DeleteVoiceTemplateOp(
      request: DeleteVoiceTemplateRequest
    ) extends PinpointOp[DeleteVoiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceTemplateResponse] =
        visitor.deleteVoiceTemplate(request)
    }

    final case class GetAdmChannelOp(
      request: GetAdmChannelRequest
    ) extends PinpointOp[GetAdmChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAdmChannelResponse] =
        visitor.getAdmChannel(request)
    }

    final case class GetApnsChannelOp(
      request: GetApnsChannelRequest
    ) extends PinpointOp[GetApnsChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApnsChannelResponse] =
        visitor.getApnsChannel(request)
    }

    final case class GetApnsSandboxChannelOp(
      request: GetApnsSandboxChannelRequest
    ) extends PinpointOp[GetApnsSandboxChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApnsSandboxChannelResponse] =
        visitor.getApnsSandboxChannel(request)
    }

    final case class GetApnsVoipChannelOp(
      request: GetApnsVoipChannelRequest
    ) extends PinpointOp[GetApnsVoipChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApnsVoipChannelResponse] =
        visitor.getApnsVoipChannel(request)
    }

    final case class GetApnsVoipSandboxChannelOp(
      request: GetApnsVoipSandboxChannelRequest
    ) extends PinpointOp[GetApnsVoipSandboxChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApnsVoipSandboxChannelResponse] =
        visitor.getApnsVoipSandboxChannel(request)
    }

    final case class GetAppOp(
      request: GetAppRequest
    ) extends PinpointOp[GetAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppResponse] =
        visitor.getApp(request)
    }

    final case class GetApplicationDateRangeKpiOp(
      request: GetApplicationDateRangeKpiRequest
    ) extends PinpointOp[GetApplicationDateRangeKpiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationDateRangeKpiResponse] =
        visitor.getApplicationDateRangeKpi(request)
    }

    final case class GetApplicationSettingsOp(
      request: GetApplicationSettingsRequest
    ) extends PinpointOp[GetApplicationSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationSettingsResponse] =
        visitor.getApplicationSettings(request)
    }

    final case class GetAppsOp(
      request: GetAppsRequest
    ) extends PinpointOp[GetAppsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppsResponse] =
        visitor.getApps(request)
    }

    final case class GetBaiduChannelOp(
      request: GetBaiduChannelRequest
    ) extends PinpointOp[GetBaiduChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBaiduChannelResponse] =
        visitor.getBaiduChannel(request)
    }

    final case class GetCampaignOp(
      request: GetCampaignRequest
    ) extends PinpointOp[GetCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCampaignResponse] =
        visitor.getCampaign(request)
    }

    final case class GetCampaignActivitiesOp(
      request: GetCampaignActivitiesRequest
    ) extends PinpointOp[GetCampaignActivitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCampaignActivitiesResponse] =
        visitor.getCampaignActivities(request)
    }

    final case class GetCampaignDateRangeKpiOp(
      request: GetCampaignDateRangeKpiRequest
    ) extends PinpointOp[GetCampaignDateRangeKpiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCampaignDateRangeKpiResponse] =
        visitor.getCampaignDateRangeKpi(request)
    }

    final case class GetCampaignVersionOp(
      request: GetCampaignVersionRequest
    ) extends PinpointOp[GetCampaignVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCampaignVersionResponse] =
        visitor.getCampaignVersion(request)
    }

    final case class GetCampaignVersionsOp(
      request: GetCampaignVersionsRequest
    ) extends PinpointOp[GetCampaignVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCampaignVersionsResponse] =
        visitor.getCampaignVersions(request)
    }

    final case class GetCampaignsOp(
      request: GetCampaignsRequest
    ) extends PinpointOp[GetCampaignsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCampaignsResponse] =
        visitor.getCampaigns(request)
    }

    final case class GetChannelsOp(
      request: GetChannelsRequest
    ) extends PinpointOp[GetChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChannelsResponse] =
        visitor.getChannels(request)
    }

    final case class GetEmailChannelOp(
      request: GetEmailChannelRequest
    ) extends PinpointOp[GetEmailChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEmailChannelResponse] =
        visitor.getEmailChannel(request)
    }

    final case class GetEmailTemplateOp(
      request: GetEmailTemplateRequest
    ) extends PinpointOp[GetEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEmailTemplateResponse] =
        visitor.getEmailTemplate(request)
    }

    final case class GetEndpointOp(
      request: GetEndpointRequest
    ) extends PinpointOp[GetEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEndpointResponse] =
        visitor.getEndpoint(request)
    }

    final case class GetEventStreamOp(
      request: GetEventStreamRequest
    ) extends PinpointOp[GetEventStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEventStreamResponse] =
        visitor.getEventStream(request)
    }

    final case class GetExportJobOp(
      request: GetExportJobRequest
    ) extends PinpointOp[GetExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExportJobResponse] =
        visitor.getExportJob(request)
    }

    final case class GetExportJobsOp(
      request: GetExportJobsRequest
    ) extends PinpointOp[GetExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExportJobsResponse] =
        visitor.getExportJobs(request)
    }

    final case class GetGcmChannelOp(
      request: GetGcmChannelRequest
    ) extends PinpointOp[GetGcmChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGcmChannelResponse] =
        visitor.getGcmChannel(request)
    }

    final case class GetImportJobOp(
      request: GetImportJobRequest
    ) extends PinpointOp[GetImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImportJobResponse] =
        visitor.getImportJob(request)
    }

    final case class GetImportJobsOp(
      request: GetImportJobsRequest
    ) extends PinpointOp[GetImportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImportJobsResponse] =
        visitor.getImportJobs(request)
    }

    final case class GetJourneyOp(
      request: GetJourneyRequest
    ) extends PinpointOp[GetJourneyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJourneyResponse] =
        visitor.getJourney(request)
    }

    final case class GetJourneyDateRangeKpiOp(
      request: GetJourneyDateRangeKpiRequest
    ) extends PinpointOp[GetJourneyDateRangeKpiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJourneyDateRangeKpiResponse] =
        visitor.getJourneyDateRangeKpi(request)
    }

    final case class GetJourneyExecutionActivityMetricsOp(
      request: GetJourneyExecutionActivityMetricsRequest
    ) extends PinpointOp[GetJourneyExecutionActivityMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJourneyExecutionActivityMetricsResponse] =
        visitor.getJourneyExecutionActivityMetrics(request)
    }

    final case class GetJourneyExecutionMetricsOp(
      request: GetJourneyExecutionMetricsRequest
    ) extends PinpointOp[GetJourneyExecutionMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJourneyExecutionMetricsResponse] =
        visitor.getJourneyExecutionMetrics(request)
    }

    final case class GetPushTemplateOp(
      request: GetPushTemplateRequest
    ) extends PinpointOp[GetPushTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPushTemplateResponse] =
        visitor.getPushTemplate(request)
    }

    final case class GetRecommenderConfigurationOp(
      request: GetRecommenderConfigurationRequest
    ) extends PinpointOp[GetRecommenderConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecommenderConfigurationResponse] =
        visitor.getRecommenderConfiguration(request)
    }

    final case class GetRecommenderConfigurationsOp(
      request: GetRecommenderConfigurationsRequest
    ) extends PinpointOp[GetRecommenderConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecommenderConfigurationsResponse] =
        visitor.getRecommenderConfigurations(request)
    }

    final case class GetSegmentOp(
      request: GetSegmentRequest
    ) extends PinpointOp[GetSegmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSegmentResponse] =
        visitor.getSegment(request)
    }

    final case class GetSegmentExportJobsOp(
      request: GetSegmentExportJobsRequest
    ) extends PinpointOp[GetSegmentExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSegmentExportJobsResponse] =
        visitor.getSegmentExportJobs(request)
    }

    final case class GetSegmentImportJobsOp(
      request: GetSegmentImportJobsRequest
    ) extends PinpointOp[GetSegmentImportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSegmentImportJobsResponse] =
        visitor.getSegmentImportJobs(request)
    }

    final case class GetSegmentVersionOp(
      request: GetSegmentVersionRequest
    ) extends PinpointOp[GetSegmentVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSegmentVersionResponse] =
        visitor.getSegmentVersion(request)
    }

    final case class GetSegmentVersionsOp(
      request: GetSegmentVersionsRequest
    ) extends PinpointOp[GetSegmentVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSegmentVersionsResponse] =
        visitor.getSegmentVersions(request)
    }

    final case class GetSegmentsOp(
      request: GetSegmentsRequest
    ) extends PinpointOp[GetSegmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSegmentsResponse] =
        visitor.getSegments(request)
    }

    final case class GetSmsChannelOp(
      request: GetSmsChannelRequest
    ) extends PinpointOp[GetSmsChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSmsChannelResponse] =
        visitor.getSmsChannel(request)
    }

    final case class GetSmsTemplateOp(
      request: GetSmsTemplateRequest
    ) extends PinpointOp[GetSmsTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSmsTemplateResponse] =
        visitor.getSmsTemplate(request)
    }

    final case class GetUserEndpointsOp(
      request: GetUserEndpointsRequest
    ) extends PinpointOp[GetUserEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserEndpointsResponse] =
        visitor.getUserEndpoints(request)
    }

    final case class GetVoiceChannelOp(
      request: GetVoiceChannelRequest
    ) extends PinpointOp[GetVoiceChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceChannelResponse] =
        visitor.getVoiceChannel(request)
    }

    final case class GetVoiceTemplateOp(
      request: GetVoiceTemplateRequest
    ) extends PinpointOp[GetVoiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceTemplateResponse] =
        visitor.getVoiceTemplate(request)
    }

    final case class ListJourneysOp(
      request: ListJourneysRequest
    ) extends PinpointOp[ListJourneysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJourneysResponse] =
        visitor.listJourneys(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends PinpointOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTemplateVersionsOp(
      request: ListTemplateVersionsRequest
    ) extends PinpointOp[ListTemplateVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTemplateVersionsResponse] =
        visitor.listTemplateVersions(request)
    }

    final case class ListTemplatesOp(
      request: ListTemplatesRequest
    ) extends PinpointOp[ListTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTemplatesResponse] =
        visitor.listTemplates(request)
    }

    final case class PhoneNumberValidateOp(
      request: PhoneNumberValidateRequest
    ) extends PinpointOp[PhoneNumberValidateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PhoneNumberValidateResponse] =
        visitor.phoneNumberValidate(request)
    }

    final case class PutEventStreamOp(
      request: PutEventStreamRequest
    ) extends PinpointOp[PutEventStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEventStreamResponse] =
        visitor.putEventStream(request)
    }

    final case class PutEventsOp(
      request: PutEventsRequest
    ) extends PinpointOp[PutEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEventsResponse] =
        visitor.putEvents(request)
    }

    final case class RemoveAttributesOp(
      request: RemoveAttributesRequest
    ) extends PinpointOp[RemoveAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveAttributesResponse] =
        visitor.removeAttributes(request)
    }

    final case class SendMessagesOp(
      request: SendMessagesRequest
    ) extends PinpointOp[SendMessagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendMessagesResponse] =
        visitor.sendMessages(request)
    }

    final case class SendUsersMessagesOp(
      request: SendUsersMessagesRequest
    ) extends PinpointOp[SendUsersMessagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendUsersMessagesResponse] =
        visitor.sendUsersMessages(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends PinpointOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends PinpointOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAdmChannelOp(
      request: UpdateAdmChannelRequest
    ) extends PinpointOp[UpdateAdmChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAdmChannelResponse] =
        visitor.updateAdmChannel(request)
    }

    final case class UpdateApnsChannelOp(
      request: UpdateApnsChannelRequest
    ) extends PinpointOp[UpdateApnsChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApnsChannelResponse] =
        visitor.updateApnsChannel(request)
    }

    final case class UpdateApnsSandboxChannelOp(
      request: UpdateApnsSandboxChannelRequest
    ) extends PinpointOp[UpdateApnsSandboxChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApnsSandboxChannelResponse] =
        visitor.updateApnsSandboxChannel(request)
    }

    final case class UpdateApnsVoipChannelOp(
      request: UpdateApnsVoipChannelRequest
    ) extends PinpointOp[UpdateApnsVoipChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApnsVoipChannelResponse] =
        visitor.updateApnsVoipChannel(request)
    }

    final case class UpdateApnsVoipSandboxChannelOp(
      request: UpdateApnsVoipSandboxChannelRequest
    ) extends PinpointOp[UpdateApnsVoipSandboxChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApnsVoipSandboxChannelResponse] =
        visitor.updateApnsVoipSandboxChannel(request)
    }

    final case class UpdateApplicationSettingsOp(
      request: UpdateApplicationSettingsRequest
    ) extends PinpointOp[UpdateApplicationSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationSettingsResponse] =
        visitor.updateApplicationSettings(request)
    }

    final case class UpdateBaiduChannelOp(
      request: UpdateBaiduChannelRequest
    ) extends PinpointOp[UpdateBaiduChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBaiduChannelResponse] =
        visitor.updateBaiduChannel(request)
    }

    final case class UpdateCampaignOp(
      request: UpdateCampaignRequest
    ) extends PinpointOp[UpdateCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCampaignResponse] =
        visitor.updateCampaign(request)
    }

    final case class UpdateEmailChannelOp(
      request: UpdateEmailChannelRequest
    ) extends PinpointOp[UpdateEmailChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEmailChannelResponse] =
        visitor.updateEmailChannel(request)
    }

    final case class UpdateEmailTemplateOp(
      request: UpdateEmailTemplateRequest
    ) extends PinpointOp[UpdateEmailTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEmailTemplateResponse] =
        visitor.updateEmailTemplate(request)
    }

    final case class UpdateEndpointOp(
      request: UpdateEndpointRequest
    ) extends PinpointOp[UpdateEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEndpointResponse] =
        visitor.updateEndpoint(request)
    }

    final case class UpdateEndpointsBatchOp(
      request: UpdateEndpointsBatchRequest
    ) extends PinpointOp[UpdateEndpointsBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEndpointsBatchResponse] =
        visitor.updateEndpointsBatch(request)
    }

    final case class UpdateGcmChannelOp(
      request: UpdateGcmChannelRequest
    ) extends PinpointOp[UpdateGcmChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGcmChannelResponse] =
        visitor.updateGcmChannel(request)
    }

    final case class UpdateJourneyOp(
      request: UpdateJourneyRequest
    ) extends PinpointOp[UpdateJourneyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJourneyResponse] =
        visitor.updateJourney(request)
    }

    final case class UpdateJourneyStateOp(
      request: UpdateJourneyStateRequest
    ) extends PinpointOp[UpdateJourneyStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJourneyStateResponse] =
        visitor.updateJourneyState(request)
    }

    final case class UpdatePushTemplateOp(
      request: UpdatePushTemplateRequest
    ) extends PinpointOp[UpdatePushTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePushTemplateResponse] =
        visitor.updatePushTemplate(request)
    }

    final case class UpdateRecommenderConfigurationOp(
      request: UpdateRecommenderConfigurationRequest
    ) extends PinpointOp[UpdateRecommenderConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRecommenderConfigurationResponse] =
        visitor.updateRecommenderConfiguration(request)
    }

    final case class UpdateSegmentOp(
      request: UpdateSegmentRequest
    ) extends PinpointOp[UpdateSegmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSegmentResponse] =
        visitor.updateSegment(request)
    }

    final case class UpdateSmsChannelOp(
      request: UpdateSmsChannelRequest
    ) extends PinpointOp[UpdateSmsChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSmsChannelResponse] =
        visitor.updateSmsChannel(request)
    }

    final case class UpdateSmsTemplateOp(
      request: UpdateSmsTemplateRequest
    ) extends PinpointOp[UpdateSmsTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSmsTemplateResponse] =
        visitor.updateSmsTemplate(request)
    }

    final case class UpdateTemplateActiveVersionOp(
      request: UpdateTemplateActiveVersionRequest
    ) extends PinpointOp[UpdateTemplateActiveVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTemplateActiveVersionResponse] =
        visitor.updateTemplateActiveVersion(request)
    }

    final case class UpdateVoiceChannelOp(
      request: UpdateVoiceChannelRequest
    ) extends PinpointOp[UpdateVoiceChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVoiceChannelResponse] =
        visitor.updateVoiceChannel(request)
    }

    final case class UpdateVoiceTemplateOp(
      request: UpdateVoiceTemplateRequest
    ) extends PinpointOp[UpdateVoiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVoiceTemplateResponse] =
        visitor.updateVoiceTemplate(request)
    }
  }

  import PinpointOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PinpointOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApp(
    request: CreateAppRequest
  ): PinpointIO[CreateAppResponse] =
    FF.liftF(CreateAppOp(request))

  def createCampaign(
    request: CreateCampaignRequest
  ): PinpointIO[CreateCampaignResponse] =
    FF.liftF(CreateCampaignOp(request))

  def createEmailTemplate(
    request: CreateEmailTemplateRequest
  ): PinpointIO[CreateEmailTemplateResponse] =
    FF.liftF(CreateEmailTemplateOp(request))

  def createExportJob(
    request: CreateExportJobRequest
  ): PinpointIO[CreateExportJobResponse] =
    FF.liftF(CreateExportJobOp(request))

  def createImportJob(
    request: CreateImportJobRequest
  ): PinpointIO[CreateImportJobResponse] =
    FF.liftF(CreateImportJobOp(request))

  def createJourney(
    request: CreateJourneyRequest
  ): PinpointIO[CreateJourneyResponse] =
    FF.liftF(CreateJourneyOp(request))

  def createPushTemplate(
    request: CreatePushTemplateRequest
  ): PinpointIO[CreatePushTemplateResponse] =
    FF.liftF(CreatePushTemplateOp(request))

  def createRecommenderConfiguration(
    request: CreateRecommenderConfigurationRequest
  ): PinpointIO[CreateRecommenderConfigurationResponse] =
    FF.liftF(CreateRecommenderConfigurationOp(request))

  def createSegment(
    request: CreateSegmentRequest
  ): PinpointIO[CreateSegmentResponse] =
    FF.liftF(CreateSegmentOp(request))

  def createSmsTemplate(
    request: CreateSmsTemplateRequest
  ): PinpointIO[CreateSmsTemplateResponse] =
    FF.liftF(CreateSmsTemplateOp(request))

  def createVoiceTemplate(
    request: CreateVoiceTemplateRequest
  ): PinpointIO[CreateVoiceTemplateResponse] =
    FF.liftF(CreateVoiceTemplateOp(request))

  def deleteAdmChannel(
    request: DeleteAdmChannelRequest
  ): PinpointIO[DeleteAdmChannelResponse] =
    FF.liftF(DeleteAdmChannelOp(request))

  def deleteApnsChannel(
    request: DeleteApnsChannelRequest
  ): PinpointIO[DeleteApnsChannelResponse] =
    FF.liftF(DeleteApnsChannelOp(request))

  def deleteApnsSandboxChannel(
    request: DeleteApnsSandboxChannelRequest
  ): PinpointIO[DeleteApnsSandboxChannelResponse] =
    FF.liftF(DeleteApnsSandboxChannelOp(request))

  def deleteApnsVoipChannel(
    request: DeleteApnsVoipChannelRequest
  ): PinpointIO[DeleteApnsVoipChannelResponse] =
    FF.liftF(DeleteApnsVoipChannelOp(request))

  def deleteApnsVoipSandboxChannel(
    request: DeleteApnsVoipSandboxChannelRequest
  ): PinpointIO[DeleteApnsVoipSandboxChannelResponse] =
    FF.liftF(DeleteApnsVoipSandboxChannelOp(request))

  def deleteApp(
    request: DeleteAppRequest
  ): PinpointIO[DeleteAppResponse] =
    FF.liftF(DeleteAppOp(request))

  def deleteBaiduChannel(
    request: DeleteBaiduChannelRequest
  ): PinpointIO[DeleteBaiduChannelResponse] =
    FF.liftF(DeleteBaiduChannelOp(request))

  def deleteCampaign(
    request: DeleteCampaignRequest
  ): PinpointIO[DeleteCampaignResponse] =
    FF.liftF(DeleteCampaignOp(request))

  def deleteEmailChannel(
    request: DeleteEmailChannelRequest
  ): PinpointIO[DeleteEmailChannelResponse] =
    FF.liftF(DeleteEmailChannelOp(request))

  def deleteEmailTemplate(
    request: DeleteEmailTemplateRequest
  ): PinpointIO[DeleteEmailTemplateResponse] =
    FF.liftF(DeleteEmailTemplateOp(request))

  def deleteEndpoint(
    request: DeleteEndpointRequest
  ): PinpointIO[DeleteEndpointResponse] =
    FF.liftF(DeleteEndpointOp(request))

  def deleteEventStream(
    request: DeleteEventStreamRequest
  ): PinpointIO[DeleteEventStreamResponse] =
    FF.liftF(DeleteEventStreamOp(request))

  def deleteGcmChannel(
    request: DeleteGcmChannelRequest
  ): PinpointIO[DeleteGcmChannelResponse] =
    FF.liftF(DeleteGcmChannelOp(request))

  def deleteJourney(
    request: DeleteJourneyRequest
  ): PinpointIO[DeleteJourneyResponse] =
    FF.liftF(DeleteJourneyOp(request))

  def deletePushTemplate(
    request: DeletePushTemplateRequest
  ): PinpointIO[DeletePushTemplateResponse] =
    FF.liftF(DeletePushTemplateOp(request))

  def deleteRecommenderConfiguration(
    request: DeleteRecommenderConfigurationRequest
  ): PinpointIO[DeleteRecommenderConfigurationResponse] =
    FF.liftF(DeleteRecommenderConfigurationOp(request))

  def deleteSegment(
    request: DeleteSegmentRequest
  ): PinpointIO[DeleteSegmentResponse] =
    FF.liftF(DeleteSegmentOp(request))

  def deleteSmsChannel(
    request: DeleteSmsChannelRequest
  ): PinpointIO[DeleteSmsChannelResponse] =
    FF.liftF(DeleteSmsChannelOp(request))

  def deleteSmsTemplate(
    request: DeleteSmsTemplateRequest
  ): PinpointIO[DeleteSmsTemplateResponse] =
    FF.liftF(DeleteSmsTemplateOp(request))

  def deleteUserEndpoints(
    request: DeleteUserEndpointsRequest
  ): PinpointIO[DeleteUserEndpointsResponse] =
    FF.liftF(DeleteUserEndpointsOp(request))

  def deleteVoiceChannel(
    request: DeleteVoiceChannelRequest
  ): PinpointIO[DeleteVoiceChannelResponse] =
    FF.liftF(DeleteVoiceChannelOp(request))

  def deleteVoiceTemplate(
    request: DeleteVoiceTemplateRequest
  ): PinpointIO[DeleteVoiceTemplateResponse] =
    FF.liftF(DeleteVoiceTemplateOp(request))

  def getAdmChannel(
    request: GetAdmChannelRequest
  ): PinpointIO[GetAdmChannelResponse] =
    FF.liftF(GetAdmChannelOp(request))

  def getApnsChannel(
    request: GetApnsChannelRequest
  ): PinpointIO[GetApnsChannelResponse] =
    FF.liftF(GetApnsChannelOp(request))

  def getApnsSandboxChannel(
    request: GetApnsSandboxChannelRequest
  ): PinpointIO[GetApnsSandboxChannelResponse] =
    FF.liftF(GetApnsSandboxChannelOp(request))

  def getApnsVoipChannel(
    request: GetApnsVoipChannelRequest
  ): PinpointIO[GetApnsVoipChannelResponse] =
    FF.liftF(GetApnsVoipChannelOp(request))

  def getApnsVoipSandboxChannel(
    request: GetApnsVoipSandboxChannelRequest
  ): PinpointIO[GetApnsVoipSandboxChannelResponse] =
    FF.liftF(GetApnsVoipSandboxChannelOp(request))

  def getApp(
    request: GetAppRequest
  ): PinpointIO[GetAppResponse] =
    FF.liftF(GetAppOp(request))

  def getApplicationDateRangeKpi(
    request: GetApplicationDateRangeKpiRequest
  ): PinpointIO[GetApplicationDateRangeKpiResponse] =
    FF.liftF(GetApplicationDateRangeKpiOp(request))

  def getApplicationSettings(
    request: GetApplicationSettingsRequest
  ): PinpointIO[GetApplicationSettingsResponse] =
    FF.liftF(GetApplicationSettingsOp(request))

  def getApps(
    request: GetAppsRequest
  ): PinpointIO[GetAppsResponse] =
    FF.liftF(GetAppsOp(request))

  def getBaiduChannel(
    request: GetBaiduChannelRequest
  ): PinpointIO[GetBaiduChannelResponse] =
    FF.liftF(GetBaiduChannelOp(request))

  def getCampaign(
    request: GetCampaignRequest
  ): PinpointIO[GetCampaignResponse] =
    FF.liftF(GetCampaignOp(request))

  def getCampaignActivities(
    request: GetCampaignActivitiesRequest
  ): PinpointIO[GetCampaignActivitiesResponse] =
    FF.liftF(GetCampaignActivitiesOp(request))

  def getCampaignDateRangeKpi(
    request: GetCampaignDateRangeKpiRequest
  ): PinpointIO[GetCampaignDateRangeKpiResponse] =
    FF.liftF(GetCampaignDateRangeKpiOp(request))

  def getCampaignVersion(
    request: GetCampaignVersionRequest
  ): PinpointIO[GetCampaignVersionResponse] =
    FF.liftF(GetCampaignVersionOp(request))

  def getCampaignVersions(
    request: GetCampaignVersionsRequest
  ): PinpointIO[GetCampaignVersionsResponse] =
    FF.liftF(GetCampaignVersionsOp(request))

  def getCampaigns(
    request: GetCampaignsRequest
  ): PinpointIO[GetCampaignsResponse] =
    FF.liftF(GetCampaignsOp(request))

  def getChannels(
    request: GetChannelsRequest
  ): PinpointIO[GetChannelsResponse] =
    FF.liftF(GetChannelsOp(request))

  def getEmailChannel(
    request: GetEmailChannelRequest
  ): PinpointIO[GetEmailChannelResponse] =
    FF.liftF(GetEmailChannelOp(request))

  def getEmailTemplate(
    request: GetEmailTemplateRequest
  ): PinpointIO[GetEmailTemplateResponse] =
    FF.liftF(GetEmailTemplateOp(request))

  def getEndpoint(
    request: GetEndpointRequest
  ): PinpointIO[GetEndpointResponse] =
    FF.liftF(GetEndpointOp(request))

  def getEventStream(
    request: GetEventStreamRequest
  ): PinpointIO[GetEventStreamResponse] =
    FF.liftF(GetEventStreamOp(request))

  def getExportJob(
    request: GetExportJobRequest
  ): PinpointIO[GetExportJobResponse] =
    FF.liftF(GetExportJobOp(request))

  def getExportJobs(
    request: GetExportJobsRequest
  ): PinpointIO[GetExportJobsResponse] =
    FF.liftF(GetExportJobsOp(request))

  def getGcmChannel(
    request: GetGcmChannelRequest
  ): PinpointIO[GetGcmChannelResponse] =
    FF.liftF(GetGcmChannelOp(request))

  def getImportJob(
    request: GetImportJobRequest
  ): PinpointIO[GetImportJobResponse] =
    FF.liftF(GetImportJobOp(request))

  def getImportJobs(
    request: GetImportJobsRequest
  ): PinpointIO[GetImportJobsResponse] =
    FF.liftF(GetImportJobsOp(request))

  def getJourney(
    request: GetJourneyRequest
  ): PinpointIO[GetJourneyResponse] =
    FF.liftF(GetJourneyOp(request))

  def getJourneyDateRangeKpi(
    request: GetJourneyDateRangeKpiRequest
  ): PinpointIO[GetJourneyDateRangeKpiResponse] =
    FF.liftF(GetJourneyDateRangeKpiOp(request))

  def getJourneyExecutionActivityMetrics(
    request: GetJourneyExecutionActivityMetricsRequest
  ): PinpointIO[GetJourneyExecutionActivityMetricsResponse] =
    FF.liftF(GetJourneyExecutionActivityMetricsOp(request))

  def getJourneyExecutionMetrics(
    request: GetJourneyExecutionMetricsRequest
  ): PinpointIO[GetJourneyExecutionMetricsResponse] =
    FF.liftF(GetJourneyExecutionMetricsOp(request))

  def getPushTemplate(
    request: GetPushTemplateRequest
  ): PinpointIO[GetPushTemplateResponse] =
    FF.liftF(GetPushTemplateOp(request))

  def getRecommenderConfiguration(
    request: GetRecommenderConfigurationRequest
  ): PinpointIO[GetRecommenderConfigurationResponse] =
    FF.liftF(GetRecommenderConfigurationOp(request))

  def getRecommenderConfigurations(
    request: GetRecommenderConfigurationsRequest
  ): PinpointIO[GetRecommenderConfigurationsResponse] =
    FF.liftF(GetRecommenderConfigurationsOp(request))

  def getSegment(
    request: GetSegmentRequest
  ): PinpointIO[GetSegmentResponse] =
    FF.liftF(GetSegmentOp(request))

  def getSegmentExportJobs(
    request: GetSegmentExportJobsRequest
  ): PinpointIO[GetSegmentExportJobsResponse] =
    FF.liftF(GetSegmentExportJobsOp(request))

  def getSegmentImportJobs(
    request: GetSegmentImportJobsRequest
  ): PinpointIO[GetSegmentImportJobsResponse] =
    FF.liftF(GetSegmentImportJobsOp(request))

  def getSegmentVersion(
    request: GetSegmentVersionRequest
  ): PinpointIO[GetSegmentVersionResponse] =
    FF.liftF(GetSegmentVersionOp(request))

  def getSegmentVersions(
    request: GetSegmentVersionsRequest
  ): PinpointIO[GetSegmentVersionsResponse] =
    FF.liftF(GetSegmentVersionsOp(request))

  def getSegments(
    request: GetSegmentsRequest
  ): PinpointIO[GetSegmentsResponse] =
    FF.liftF(GetSegmentsOp(request))

  def getSmsChannel(
    request: GetSmsChannelRequest
  ): PinpointIO[GetSmsChannelResponse] =
    FF.liftF(GetSmsChannelOp(request))

  def getSmsTemplate(
    request: GetSmsTemplateRequest
  ): PinpointIO[GetSmsTemplateResponse] =
    FF.liftF(GetSmsTemplateOp(request))

  def getUserEndpoints(
    request: GetUserEndpointsRequest
  ): PinpointIO[GetUserEndpointsResponse] =
    FF.liftF(GetUserEndpointsOp(request))

  def getVoiceChannel(
    request: GetVoiceChannelRequest
  ): PinpointIO[GetVoiceChannelResponse] =
    FF.liftF(GetVoiceChannelOp(request))

  def getVoiceTemplate(
    request: GetVoiceTemplateRequest
  ): PinpointIO[GetVoiceTemplateResponse] =
    FF.liftF(GetVoiceTemplateOp(request))

  def listJourneys(
    request: ListJourneysRequest
  ): PinpointIO[ListJourneysResponse] =
    FF.liftF(ListJourneysOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): PinpointIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTemplateVersions(
    request: ListTemplateVersionsRequest
  ): PinpointIO[ListTemplateVersionsResponse] =
    FF.liftF(ListTemplateVersionsOp(request))

  def listTemplates(
    request: ListTemplatesRequest
  ): PinpointIO[ListTemplatesResponse] =
    FF.liftF(ListTemplatesOp(request))

  def phoneNumberValidate(
    request: PhoneNumberValidateRequest
  ): PinpointIO[PhoneNumberValidateResponse] =
    FF.liftF(PhoneNumberValidateOp(request))

  def putEventStream(
    request: PutEventStreamRequest
  ): PinpointIO[PutEventStreamResponse] =
    FF.liftF(PutEventStreamOp(request))

  def putEvents(
    request: PutEventsRequest
  ): PinpointIO[PutEventsResponse] =
    FF.liftF(PutEventsOp(request))

  def removeAttributes(
    request: RemoveAttributesRequest
  ): PinpointIO[RemoveAttributesResponse] =
    FF.liftF(RemoveAttributesOp(request))

  def sendMessages(
    request: SendMessagesRequest
  ): PinpointIO[SendMessagesResponse] =
    FF.liftF(SendMessagesOp(request))

  def sendUsersMessages(
    request: SendUsersMessagesRequest
  ): PinpointIO[SendUsersMessagesResponse] =
    FF.liftF(SendUsersMessagesOp(request))

  def tagResource(
    request: TagResourceRequest
  ): PinpointIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): PinpointIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAdmChannel(
    request: UpdateAdmChannelRequest
  ): PinpointIO[UpdateAdmChannelResponse] =
    FF.liftF(UpdateAdmChannelOp(request))

  def updateApnsChannel(
    request: UpdateApnsChannelRequest
  ): PinpointIO[UpdateApnsChannelResponse] =
    FF.liftF(UpdateApnsChannelOp(request))

  def updateApnsSandboxChannel(
    request: UpdateApnsSandboxChannelRequest
  ): PinpointIO[UpdateApnsSandboxChannelResponse] =
    FF.liftF(UpdateApnsSandboxChannelOp(request))

  def updateApnsVoipChannel(
    request: UpdateApnsVoipChannelRequest
  ): PinpointIO[UpdateApnsVoipChannelResponse] =
    FF.liftF(UpdateApnsVoipChannelOp(request))

  def updateApnsVoipSandboxChannel(
    request: UpdateApnsVoipSandboxChannelRequest
  ): PinpointIO[UpdateApnsVoipSandboxChannelResponse] =
    FF.liftF(UpdateApnsVoipSandboxChannelOp(request))

  def updateApplicationSettings(
    request: UpdateApplicationSettingsRequest
  ): PinpointIO[UpdateApplicationSettingsResponse] =
    FF.liftF(UpdateApplicationSettingsOp(request))

  def updateBaiduChannel(
    request: UpdateBaiduChannelRequest
  ): PinpointIO[UpdateBaiduChannelResponse] =
    FF.liftF(UpdateBaiduChannelOp(request))

  def updateCampaign(
    request: UpdateCampaignRequest
  ): PinpointIO[UpdateCampaignResponse] =
    FF.liftF(UpdateCampaignOp(request))

  def updateEmailChannel(
    request: UpdateEmailChannelRequest
  ): PinpointIO[UpdateEmailChannelResponse] =
    FF.liftF(UpdateEmailChannelOp(request))

  def updateEmailTemplate(
    request: UpdateEmailTemplateRequest
  ): PinpointIO[UpdateEmailTemplateResponse] =
    FF.liftF(UpdateEmailTemplateOp(request))

  def updateEndpoint(
    request: UpdateEndpointRequest
  ): PinpointIO[UpdateEndpointResponse] =
    FF.liftF(UpdateEndpointOp(request))

  def updateEndpointsBatch(
    request: UpdateEndpointsBatchRequest
  ): PinpointIO[UpdateEndpointsBatchResponse] =
    FF.liftF(UpdateEndpointsBatchOp(request))

  def updateGcmChannel(
    request: UpdateGcmChannelRequest
  ): PinpointIO[UpdateGcmChannelResponse] =
    FF.liftF(UpdateGcmChannelOp(request))

  def updateJourney(
    request: UpdateJourneyRequest
  ): PinpointIO[UpdateJourneyResponse] =
    FF.liftF(UpdateJourneyOp(request))

  def updateJourneyState(
    request: UpdateJourneyStateRequest
  ): PinpointIO[UpdateJourneyStateResponse] =
    FF.liftF(UpdateJourneyStateOp(request))

  def updatePushTemplate(
    request: UpdatePushTemplateRequest
  ): PinpointIO[UpdatePushTemplateResponse] =
    FF.liftF(UpdatePushTemplateOp(request))

  def updateRecommenderConfiguration(
    request: UpdateRecommenderConfigurationRequest
  ): PinpointIO[UpdateRecommenderConfigurationResponse] =
    FF.liftF(UpdateRecommenderConfigurationOp(request))

  def updateSegment(
    request: UpdateSegmentRequest
  ): PinpointIO[UpdateSegmentResponse] =
    FF.liftF(UpdateSegmentOp(request))

  def updateSmsChannel(
    request: UpdateSmsChannelRequest
  ): PinpointIO[UpdateSmsChannelResponse] =
    FF.liftF(UpdateSmsChannelOp(request))

  def updateSmsTemplate(
    request: UpdateSmsTemplateRequest
  ): PinpointIO[UpdateSmsTemplateResponse] =
    FF.liftF(UpdateSmsTemplateOp(request))

  def updateTemplateActiveVersion(
    request: UpdateTemplateActiveVersionRequest
  ): PinpointIO[UpdateTemplateActiveVersionResponse] =
    FF.liftF(UpdateTemplateActiveVersionOp(request))

  def updateVoiceChannel(
    request: UpdateVoiceChannelRequest
  ): PinpointIO[UpdateVoiceChannelResponse] =
    FF.liftF(UpdateVoiceChannelOp(request))

  def updateVoiceTemplate(
    request: UpdateVoiceTemplateRequest
  ): PinpointIO[UpdateVoiceTemplateResponse] =
    FF.liftF(UpdateVoiceTemplateOp(request))
}
