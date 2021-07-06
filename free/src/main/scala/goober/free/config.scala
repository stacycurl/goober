package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.config.ConfigClient
import software.amazon.awssdk.services.config.model._


object config { module =>

  // Free monad over ConfigOp
  type ConfigIO[A] = FF[ConfigOp, A]

  sealed trait ConfigOp[A] {
    def visit[F[_]](visitor: ConfigOp.Visitor[F]): F[A]
  }

  object ConfigOp {
    // Given a ConfigClient we can embed a ConfigIO program in any algebra that understands embedding.
    implicit val ConfigOpEmbeddable: Embeddable[ConfigOp, ConfigClient] = new Embeddable[ConfigOp, ConfigClient] {
      def embed[A](client: ConfigClient, io: ConfigIO[A]): Embedded[A] = Embedded.Config(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ConfigOp.Visitor[Kleisli[M, ConfigClient, *]] {
        def batchGetAggregateResourceConfig(
          request: BatchGetAggregateResourceConfigRequest
        ): Kleisli[M, ConfigClient, BatchGetAggregateResourceConfigResponse] =
          primitive(_.batchGetAggregateResourceConfig(request))

        def batchGetResourceConfig(
          request: BatchGetResourceConfigRequest
        ): Kleisli[M, ConfigClient, BatchGetResourceConfigResponse] =
          primitive(_.batchGetResourceConfig(request))

        def deleteAggregationAuthorization(
          request: DeleteAggregationAuthorizationRequest
        ): Kleisli[M, ConfigClient, DeleteAggregationAuthorizationResponse] =
          primitive(_.deleteAggregationAuthorization(request))

        def deleteConfigRule(
          request: DeleteConfigRuleRequest
        ): Kleisli[M, ConfigClient, DeleteConfigRuleResponse] =
          primitive(_.deleteConfigRule(request))

        def deleteConfigurationAggregator(
          request: DeleteConfigurationAggregatorRequest
        ): Kleisli[M, ConfigClient, DeleteConfigurationAggregatorResponse] =
          primitive(_.deleteConfigurationAggregator(request))

        def deleteConfigurationRecorder(
          request: DeleteConfigurationRecorderRequest
        ): Kleisli[M, ConfigClient, DeleteConfigurationRecorderResponse] =
          primitive(_.deleteConfigurationRecorder(request))

        def deleteConformancePack(
          request: DeleteConformancePackRequest
        ): Kleisli[M, ConfigClient, DeleteConformancePackResponse] =
          primitive(_.deleteConformancePack(request))

        def deleteDeliveryChannel(
          request: DeleteDeliveryChannelRequest
        ): Kleisli[M, ConfigClient, DeleteDeliveryChannelResponse] =
          primitive(_.deleteDeliveryChannel(request))

        def deleteEvaluationResults(
          request: DeleteEvaluationResultsRequest
        ): Kleisli[M, ConfigClient, DeleteEvaluationResultsResponse] =
          primitive(_.deleteEvaluationResults(request))

        def deleteOrganizationConfigRule(
          request: DeleteOrganizationConfigRuleRequest
        ): Kleisli[M, ConfigClient, DeleteOrganizationConfigRuleResponse] =
          primitive(_.deleteOrganizationConfigRule(request))

        def deleteOrganizationConformancePack(
          request: DeleteOrganizationConformancePackRequest
        ): Kleisli[M, ConfigClient, DeleteOrganizationConformancePackResponse] =
          primitive(_.deleteOrganizationConformancePack(request))

        def deletePendingAggregationRequest(
          request: DeletePendingAggregationRequestRequest
        ): Kleisli[M, ConfigClient, DeletePendingAggregationRequestResponse] =
          primitive(_.deletePendingAggregationRequest(request))

        def deleteRemediationConfiguration(
          request: DeleteRemediationConfigurationRequest
        ): Kleisli[M, ConfigClient, DeleteRemediationConfigurationResponse] =
          primitive(_.deleteRemediationConfiguration(request))

        def deleteRemediationExceptions(
          request: DeleteRemediationExceptionsRequest
        ): Kleisli[M, ConfigClient, DeleteRemediationExceptionsResponse] =
          primitive(_.deleteRemediationExceptions(request))

        def deleteResourceConfig(
          request: DeleteResourceConfigRequest
        ): Kleisli[M, ConfigClient, DeleteResourceConfigResponse] =
          primitive(_.deleteResourceConfig(request))

        def deleteRetentionConfiguration(
          request: DeleteRetentionConfigurationRequest
        ): Kleisli[M, ConfigClient, DeleteRetentionConfigurationResponse] =
          primitive(_.deleteRetentionConfiguration(request))

        def deleteStoredQuery(
          request: DeleteStoredQueryRequest
        ): Kleisli[M, ConfigClient, DeleteStoredQueryResponse] =
          primitive(_.deleteStoredQuery(request))

        def deliverConfigSnapshot(
          request: DeliverConfigSnapshotRequest
        ): Kleisli[M, ConfigClient, DeliverConfigSnapshotResponse] =
          primitive(_.deliverConfigSnapshot(request))

        def describeAggregateComplianceByConfigRules(
          request: DescribeAggregateComplianceByConfigRulesRequest
        ): Kleisli[M, ConfigClient, DescribeAggregateComplianceByConfigRulesResponse] =
          primitive(_.describeAggregateComplianceByConfigRules(request))

        def describeAggregateComplianceByConformancePacks(
          request: DescribeAggregateComplianceByConformancePacksRequest
        ): Kleisli[M, ConfigClient, DescribeAggregateComplianceByConformancePacksResponse] =
          primitive(_.describeAggregateComplianceByConformancePacks(request))

        def describeAggregationAuthorizations(
          request: DescribeAggregationAuthorizationsRequest
        ): Kleisli[M, ConfigClient, DescribeAggregationAuthorizationsResponse] =
          primitive(_.describeAggregationAuthorizations(request))

        def describeComplianceByConfigRule(
          request: DescribeComplianceByConfigRuleRequest
        ): Kleisli[M, ConfigClient, DescribeComplianceByConfigRuleResponse] =
          primitive(_.describeComplianceByConfigRule(request))

        def describeComplianceByResource(
          request: DescribeComplianceByResourceRequest
        ): Kleisli[M, ConfigClient, DescribeComplianceByResourceResponse] =
          primitive(_.describeComplianceByResource(request))

        def describeConfigRuleEvaluationStatus(
          request: DescribeConfigRuleEvaluationStatusRequest
        ): Kleisli[M, ConfigClient, DescribeConfigRuleEvaluationStatusResponse] =
          primitive(_.describeConfigRuleEvaluationStatus(request))

        def describeConfigRules(
          request: DescribeConfigRulesRequest
        ): Kleisli[M, ConfigClient, DescribeConfigRulesResponse] =
          primitive(_.describeConfigRules(request))

        def describeConfigurationAggregatorSourcesStatus(
          request: DescribeConfigurationAggregatorSourcesStatusRequest
        ): Kleisli[M, ConfigClient, DescribeConfigurationAggregatorSourcesStatusResponse] =
          primitive(_.describeConfigurationAggregatorSourcesStatus(request))

        def describeConfigurationAggregators(
          request: DescribeConfigurationAggregatorsRequest
        ): Kleisli[M, ConfigClient, DescribeConfigurationAggregatorsResponse] =
          primitive(_.describeConfigurationAggregators(request))

        def describeConfigurationRecorderStatus(
          request: DescribeConfigurationRecorderStatusRequest
        ): Kleisli[M, ConfigClient, DescribeConfigurationRecorderStatusResponse] =
          primitive(_.describeConfigurationRecorderStatus(request))

        def describeConfigurationRecorders(
          request: DescribeConfigurationRecordersRequest
        ): Kleisli[M, ConfigClient, DescribeConfigurationRecordersResponse] =
          primitive(_.describeConfigurationRecorders(request))

        def describeConformancePackCompliance(
          request: DescribeConformancePackComplianceRequest
        ): Kleisli[M, ConfigClient, DescribeConformancePackComplianceResponse] =
          primitive(_.describeConformancePackCompliance(request))

        def describeConformancePackStatus(
          request: DescribeConformancePackStatusRequest
        ): Kleisli[M, ConfigClient, DescribeConformancePackStatusResponse] =
          primitive(_.describeConformancePackStatus(request))

        def describeConformancePacks(
          request: DescribeConformancePacksRequest
        ): Kleisli[M, ConfigClient, DescribeConformancePacksResponse] =
          primitive(_.describeConformancePacks(request))

        def describeDeliveryChannelStatus(
          request: DescribeDeliveryChannelStatusRequest
        ): Kleisli[M, ConfigClient, DescribeDeliveryChannelStatusResponse] =
          primitive(_.describeDeliveryChannelStatus(request))

        def describeDeliveryChannels(
          request: DescribeDeliveryChannelsRequest
        ): Kleisli[M, ConfigClient, DescribeDeliveryChannelsResponse] =
          primitive(_.describeDeliveryChannels(request))

        def describeOrganizationConfigRuleStatuses(
          request: DescribeOrganizationConfigRuleStatusesRequest
        ): Kleisli[M, ConfigClient, DescribeOrganizationConfigRuleStatusesResponse] =
          primitive(_.describeOrganizationConfigRuleStatuses(request))

        def describeOrganizationConfigRules(
          request: DescribeOrganizationConfigRulesRequest
        ): Kleisli[M, ConfigClient, DescribeOrganizationConfigRulesResponse] =
          primitive(_.describeOrganizationConfigRules(request))

        def describeOrganizationConformancePackStatuses(
          request: DescribeOrganizationConformancePackStatusesRequest
        ): Kleisli[M, ConfigClient, DescribeOrganizationConformancePackStatusesResponse] =
          primitive(_.describeOrganizationConformancePackStatuses(request))

        def describeOrganizationConformancePacks(
          request: DescribeOrganizationConformancePacksRequest
        ): Kleisli[M, ConfigClient, DescribeOrganizationConformancePacksResponse] =
          primitive(_.describeOrganizationConformancePacks(request))

        def describePendingAggregationRequests(
          request: DescribePendingAggregationRequestsRequest
        ): Kleisli[M, ConfigClient, DescribePendingAggregationRequestsResponse] =
          primitive(_.describePendingAggregationRequests(request))

        def describeRemediationConfigurations(
          request: DescribeRemediationConfigurationsRequest
        ): Kleisli[M, ConfigClient, DescribeRemediationConfigurationsResponse] =
          primitive(_.describeRemediationConfigurations(request))

        def describeRemediationExceptions(
          request: DescribeRemediationExceptionsRequest
        ): Kleisli[M, ConfigClient, DescribeRemediationExceptionsResponse] =
          primitive(_.describeRemediationExceptions(request))

        def describeRemediationExecutionStatus(
          request: DescribeRemediationExecutionStatusRequest
        ): Kleisli[M, ConfigClient, DescribeRemediationExecutionStatusResponse] =
          primitive(_.describeRemediationExecutionStatus(request))

        def describeRetentionConfigurations(
          request: DescribeRetentionConfigurationsRequest
        ): Kleisli[M, ConfigClient, DescribeRetentionConfigurationsResponse] =
          primitive(_.describeRetentionConfigurations(request))

        def getAggregateComplianceDetailsByConfigRule(
          request: GetAggregateComplianceDetailsByConfigRuleRequest
        ): Kleisli[M, ConfigClient, GetAggregateComplianceDetailsByConfigRuleResponse] =
          primitive(_.getAggregateComplianceDetailsByConfigRule(request))

        def getAggregateConfigRuleComplianceSummary(
          request: GetAggregateConfigRuleComplianceSummaryRequest
        ): Kleisli[M, ConfigClient, GetAggregateConfigRuleComplianceSummaryResponse] =
          primitive(_.getAggregateConfigRuleComplianceSummary(request))

        def getAggregateConformancePackComplianceSummary(
          request: GetAggregateConformancePackComplianceSummaryRequest
        ): Kleisli[M, ConfigClient, GetAggregateConformancePackComplianceSummaryResponse] =
          primitive(_.getAggregateConformancePackComplianceSummary(request))

        def getAggregateDiscoveredResourceCounts(
          request: GetAggregateDiscoveredResourceCountsRequest
        ): Kleisli[M, ConfigClient, GetAggregateDiscoveredResourceCountsResponse] =
          primitive(_.getAggregateDiscoveredResourceCounts(request))

        def getAggregateResourceConfig(
          request: GetAggregateResourceConfigRequest
        ): Kleisli[M, ConfigClient, GetAggregateResourceConfigResponse] =
          primitive(_.getAggregateResourceConfig(request))

        def getComplianceDetailsByConfigRule(
          request: GetComplianceDetailsByConfigRuleRequest
        ): Kleisli[M, ConfigClient, GetComplianceDetailsByConfigRuleResponse] =
          primitive(_.getComplianceDetailsByConfigRule(request))

        def getComplianceDetailsByResource(
          request: GetComplianceDetailsByResourceRequest
        ): Kleisli[M, ConfigClient, GetComplianceDetailsByResourceResponse] =
          primitive(_.getComplianceDetailsByResource(request))

        def getComplianceSummaryByConfigRule(
          request: GetComplianceSummaryByConfigRuleRequest
        ): Kleisli[M, ConfigClient, GetComplianceSummaryByConfigRuleResponse] =
          primitive(_.getComplianceSummaryByConfigRule(request))

        def getComplianceSummaryByResourceType(
          request: GetComplianceSummaryByResourceTypeRequest
        ): Kleisli[M, ConfigClient, GetComplianceSummaryByResourceTypeResponse] =
          primitive(_.getComplianceSummaryByResourceType(request))

        def getConformancePackComplianceDetails(
          request: GetConformancePackComplianceDetailsRequest
        ): Kleisli[M, ConfigClient, GetConformancePackComplianceDetailsResponse] =
          primitive(_.getConformancePackComplianceDetails(request))

        def getConformancePackComplianceSummary(
          request: GetConformancePackComplianceSummaryRequest
        ): Kleisli[M, ConfigClient, GetConformancePackComplianceSummaryResponse] =
          primitive(_.getConformancePackComplianceSummary(request))

        def getDiscoveredResourceCounts(
          request: GetDiscoveredResourceCountsRequest
        ): Kleisli[M, ConfigClient, GetDiscoveredResourceCountsResponse] =
          primitive(_.getDiscoveredResourceCounts(request))

        def getOrganizationConfigRuleDetailedStatus(
          request: GetOrganizationConfigRuleDetailedStatusRequest
        ): Kleisli[M, ConfigClient, GetOrganizationConfigRuleDetailedStatusResponse] =
          primitive(_.getOrganizationConfigRuleDetailedStatus(request))

        def getOrganizationConformancePackDetailedStatus(
          request: GetOrganizationConformancePackDetailedStatusRequest
        ): Kleisli[M, ConfigClient, GetOrganizationConformancePackDetailedStatusResponse] =
          primitive(_.getOrganizationConformancePackDetailedStatus(request))

        def getResourceConfigHistory(
          request: GetResourceConfigHistoryRequest
        ): Kleisli[M, ConfigClient, GetResourceConfigHistoryResponse] =
          primitive(_.getResourceConfigHistory(request))

        def getStoredQuery(
          request: GetStoredQueryRequest
        ): Kleisli[M, ConfigClient, GetStoredQueryResponse] =
          primitive(_.getStoredQuery(request))

        def listAggregateDiscoveredResources(
          request: ListAggregateDiscoveredResourcesRequest
        ): Kleisli[M, ConfigClient, ListAggregateDiscoveredResourcesResponse] =
          primitive(_.listAggregateDiscoveredResources(request))

        def listDiscoveredResources(
          request: ListDiscoveredResourcesRequest
        ): Kleisli[M, ConfigClient, ListDiscoveredResourcesResponse] =
          primitive(_.listDiscoveredResources(request))

        def listStoredQueries(
          request: ListStoredQueriesRequest
        ): Kleisli[M, ConfigClient, ListStoredQueriesResponse] =
          primitive(_.listStoredQueries(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ConfigClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putAggregationAuthorization(
          request: PutAggregationAuthorizationRequest
        ): Kleisli[M, ConfigClient, PutAggregationAuthorizationResponse] =
          primitive(_.putAggregationAuthorization(request))

        def putConfigRule(
          request: PutConfigRuleRequest
        ): Kleisli[M, ConfigClient, PutConfigRuleResponse] =
          primitive(_.putConfigRule(request))

        def putConfigurationAggregator(
          request: PutConfigurationAggregatorRequest
        ): Kleisli[M, ConfigClient, PutConfigurationAggregatorResponse] =
          primitive(_.putConfigurationAggregator(request))

        def putConfigurationRecorder(
          request: PutConfigurationRecorderRequest
        ): Kleisli[M, ConfigClient, PutConfigurationRecorderResponse] =
          primitive(_.putConfigurationRecorder(request))

        def putConformancePack(
          request: PutConformancePackRequest
        ): Kleisli[M, ConfigClient, PutConformancePackResponse] =
          primitive(_.putConformancePack(request))

        def putDeliveryChannel(
          request: PutDeliveryChannelRequest
        ): Kleisli[M, ConfigClient, PutDeliveryChannelResponse] =
          primitive(_.putDeliveryChannel(request))

        def putEvaluations(
          request: PutEvaluationsRequest
        ): Kleisli[M, ConfigClient, PutEvaluationsResponse] =
          primitive(_.putEvaluations(request))

        def putExternalEvaluation(
          request: PutExternalEvaluationRequest
        ): Kleisli[M, ConfigClient, PutExternalEvaluationResponse] =
          primitive(_.putExternalEvaluation(request))

        def putOrganizationConfigRule(
          request: PutOrganizationConfigRuleRequest
        ): Kleisli[M, ConfigClient, PutOrganizationConfigRuleResponse] =
          primitive(_.putOrganizationConfigRule(request))

        def putOrganizationConformancePack(
          request: PutOrganizationConformancePackRequest
        ): Kleisli[M, ConfigClient, PutOrganizationConformancePackResponse] =
          primitive(_.putOrganizationConformancePack(request))

        def putRemediationConfigurations(
          request: PutRemediationConfigurationsRequest
        ): Kleisli[M, ConfigClient, PutRemediationConfigurationsResponse] =
          primitive(_.putRemediationConfigurations(request))

        def putRemediationExceptions(
          request: PutRemediationExceptionsRequest
        ): Kleisli[M, ConfigClient, PutRemediationExceptionsResponse] =
          primitive(_.putRemediationExceptions(request))

        def putResourceConfig(
          request: PutResourceConfigRequest
        ): Kleisli[M, ConfigClient, PutResourceConfigResponse] =
          primitive(_.putResourceConfig(request))

        def putRetentionConfiguration(
          request: PutRetentionConfigurationRequest
        ): Kleisli[M, ConfigClient, PutRetentionConfigurationResponse] =
          primitive(_.putRetentionConfiguration(request))

        def putStoredQuery(
          request: PutStoredQueryRequest
        ): Kleisli[M, ConfigClient, PutStoredQueryResponse] =
          primitive(_.putStoredQuery(request))

        def selectAggregateResourceConfig(
          request: SelectAggregateResourceConfigRequest
        ): Kleisli[M, ConfigClient, SelectAggregateResourceConfigResponse] =
          primitive(_.selectAggregateResourceConfig(request))

        def selectResourceConfig(
          request: SelectResourceConfigRequest
        ): Kleisli[M, ConfigClient, SelectResourceConfigResponse] =
          primitive(_.selectResourceConfig(request))

        def startConfigRulesEvaluation(
          request: StartConfigRulesEvaluationRequest
        ): Kleisli[M, ConfigClient, StartConfigRulesEvaluationResponse] =
          primitive(_.startConfigRulesEvaluation(request))

        def startConfigurationRecorder(
          request: StartConfigurationRecorderRequest
        ): Kleisli[M, ConfigClient, StartConfigurationRecorderResponse] =
          primitive(_.startConfigurationRecorder(request))

        def startRemediationExecution(
          request: StartRemediationExecutionRequest
        ): Kleisli[M, ConfigClient, StartRemediationExecutionResponse] =
          primitive(_.startRemediationExecution(request))

        def stopConfigurationRecorder(
          request: StopConfigurationRecorderRequest
        ): Kleisli[M, ConfigClient, StopConfigurationRecorderResponse] =
          primitive(_.stopConfigurationRecorder(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ConfigClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ConfigClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: ConfigClient => A
        ): Kleisli[M, ConfigClient, A]
      }
    }

    trait Visitor[F[_]] extends (ConfigOp ~> F) {
      final def apply[A](op: ConfigOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchGetAggregateResourceConfig(
        request: BatchGetAggregateResourceConfigRequest
      ): F[BatchGetAggregateResourceConfigResponse]

      def batchGetResourceConfig(
        request: BatchGetResourceConfigRequest
      ): F[BatchGetResourceConfigResponse]

      def deleteAggregationAuthorization(
        request: DeleteAggregationAuthorizationRequest
      ): F[DeleteAggregationAuthorizationResponse]

      def deleteConfigRule(
        request: DeleteConfigRuleRequest
      ): F[DeleteConfigRuleResponse]

      def deleteConfigurationAggregator(
        request: DeleteConfigurationAggregatorRequest
      ): F[DeleteConfigurationAggregatorResponse]

      def deleteConfigurationRecorder(
        request: DeleteConfigurationRecorderRequest
      ): F[DeleteConfigurationRecorderResponse]

      def deleteConformancePack(
        request: DeleteConformancePackRequest
      ): F[DeleteConformancePackResponse]

      def deleteDeliveryChannel(
        request: DeleteDeliveryChannelRequest
      ): F[DeleteDeliveryChannelResponse]

      def deleteEvaluationResults(
        request: DeleteEvaluationResultsRequest
      ): F[DeleteEvaluationResultsResponse]

      def deleteOrganizationConfigRule(
        request: DeleteOrganizationConfigRuleRequest
      ): F[DeleteOrganizationConfigRuleResponse]

      def deleteOrganizationConformancePack(
        request: DeleteOrganizationConformancePackRequest
      ): F[DeleteOrganizationConformancePackResponse]

      def deletePendingAggregationRequest(
        request: DeletePendingAggregationRequestRequest
      ): F[DeletePendingAggregationRequestResponse]

      def deleteRemediationConfiguration(
        request: DeleteRemediationConfigurationRequest
      ): F[DeleteRemediationConfigurationResponse]

      def deleteRemediationExceptions(
        request: DeleteRemediationExceptionsRequest
      ): F[DeleteRemediationExceptionsResponse]

      def deleteResourceConfig(
        request: DeleteResourceConfigRequest
      ): F[DeleteResourceConfigResponse]

      def deleteRetentionConfiguration(
        request: DeleteRetentionConfigurationRequest
      ): F[DeleteRetentionConfigurationResponse]

      def deleteStoredQuery(
        request: DeleteStoredQueryRequest
      ): F[DeleteStoredQueryResponse]

      def deliverConfigSnapshot(
        request: DeliverConfigSnapshotRequest
      ): F[DeliverConfigSnapshotResponse]

      def describeAggregateComplianceByConfigRules(
        request: DescribeAggregateComplianceByConfigRulesRequest
      ): F[DescribeAggregateComplianceByConfigRulesResponse]

      def describeAggregateComplianceByConformancePacks(
        request: DescribeAggregateComplianceByConformancePacksRequest
      ): F[DescribeAggregateComplianceByConformancePacksResponse]

      def describeAggregationAuthorizations(
        request: DescribeAggregationAuthorizationsRequest
      ): F[DescribeAggregationAuthorizationsResponse]

      def describeComplianceByConfigRule(
        request: DescribeComplianceByConfigRuleRequest
      ): F[DescribeComplianceByConfigRuleResponse]

      def describeComplianceByResource(
        request: DescribeComplianceByResourceRequest
      ): F[DescribeComplianceByResourceResponse]

      def describeConfigRuleEvaluationStatus(
        request: DescribeConfigRuleEvaluationStatusRequest
      ): F[DescribeConfigRuleEvaluationStatusResponse]

      def describeConfigRules(
        request: DescribeConfigRulesRequest
      ): F[DescribeConfigRulesResponse]

      def describeConfigurationAggregatorSourcesStatus(
        request: DescribeConfigurationAggregatorSourcesStatusRequest
      ): F[DescribeConfigurationAggregatorSourcesStatusResponse]

      def describeConfigurationAggregators(
        request: DescribeConfigurationAggregatorsRequest
      ): F[DescribeConfigurationAggregatorsResponse]

      def describeConfigurationRecorderStatus(
        request: DescribeConfigurationRecorderStatusRequest
      ): F[DescribeConfigurationRecorderStatusResponse]

      def describeConfigurationRecorders(
        request: DescribeConfigurationRecordersRequest
      ): F[DescribeConfigurationRecordersResponse]

      def describeConformancePackCompliance(
        request: DescribeConformancePackComplianceRequest
      ): F[DescribeConformancePackComplianceResponse]

      def describeConformancePackStatus(
        request: DescribeConformancePackStatusRequest
      ): F[DescribeConformancePackStatusResponse]

      def describeConformancePacks(
        request: DescribeConformancePacksRequest
      ): F[DescribeConformancePacksResponse]

      def describeDeliveryChannelStatus(
        request: DescribeDeliveryChannelStatusRequest
      ): F[DescribeDeliveryChannelStatusResponse]

      def describeDeliveryChannels(
        request: DescribeDeliveryChannelsRequest
      ): F[DescribeDeliveryChannelsResponse]

      def describeOrganizationConfigRuleStatuses(
        request: DescribeOrganizationConfigRuleStatusesRequest
      ): F[DescribeOrganizationConfigRuleStatusesResponse]

      def describeOrganizationConfigRules(
        request: DescribeOrganizationConfigRulesRequest
      ): F[DescribeOrganizationConfigRulesResponse]

      def describeOrganizationConformancePackStatuses(
        request: DescribeOrganizationConformancePackStatusesRequest
      ): F[DescribeOrganizationConformancePackStatusesResponse]

      def describeOrganizationConformancePacks(
        request: DescribeOrganizationConformancePacksRequest
      ): F[DescribeOrganizationConformancePacksResponse]

      def describePendingAggregationRequests(
        request: DescribePendingAggregationRequestsRequest
      ): F[DescribePendingAggregationRequestsResponse]

      def describeRemediationConfigurations(
        request: DescribeRemediationConfigurationsRequest
      ): F[DescribeRemediationConfigurationsResponse]

      def describeRemediationExceptions(
        request: DescribeRemediationExceptionsRequest
      ): F[DescribeRemediationExceptionsResponse]

      def describeRemediationExecutionStatus(
        request: DescribeRemediationExecutionStatusRequest
      ): F[DescribeRemediationExecutionStatusResponse]

      def describeRetentionConfigurations(
        request: DescribeRetentionConfigurationsRequest
      ): F[DescribeRetentionConfigurationsResponse]

      def getAggregateComplianceDetailsByConfigRule(
        request: GetAggregateComplianceDetailsByConfigRuleRequest
      ): F[GetAggregateComplianceDetailsByConfigRuleResponse]

      def getAggregateConfigRuleComplianceSummary(
        request: GetAggregateConfigRuleComplianceSummaryRequest
      ): F[GetAggregateConfigRuleComplianceSummaryResponse]

      def getAggregateConformancePackComplianceSummary(
        request: GetAggregateConformancePackComplianceSummaryRequest
      ): F[GetAggregateConformancePackComplianceSummaryResponse]

      def getAggregateDiscoveredResourceCounts(
        request: GetAggregateDiscoveredResourceCountsRequest
      ): F[GetAggregateDiscoveredResourceCountsResponse]

      def getAggregateResourceConfig(
        request: GetAggregateResourceConfigRequest
      ): F[GetAggregateResourceConfigResponse]

      def getComplianceDetailsByConfigRule(
        request: GetComplianceDetailsByConfigRuleRequest
      ): F[GetComplianceDetailsByConfigRuleResponse]

      def getComplianceDetailsByResource(
        request: GetComplianceDetailsByResourceRequest
      ): F[GetComplianceDetailsByResourceResponse]

      def getComplianceSummaryByConfigRule(
        request: GetComplianceSummaryByConfigRuleRequest
      ): F[GetComplianceSummaryByConfigRuleResponse]

      def getComplianceSummaryByResourceType(
        request: GetComplianceSummaryByResourceTypeRequest
      ): F[GetComplianceSummaryByResourceTypeResponse]

      def getConformancePackComplianceDetails(
        request: GetConformancePackComplianceDetailsRequest
      ): F[GetConformancePackComplianceDetailsResponse]

      def getConformancePackComplianceSummary(
        request: GetConformancePackComplianceSummaryRequest
      ): F[GetConformancePackComplianceSummaryResponse]

      def getDiscoveredResourceCounts(
        request: GetDiscoveredResourceCountsRequest
      ): F[GetDiscoveredResourceCountsResponse]

      def getOrganizationConfigRuleDetailedStatus(
        request: GetOrganizationConfigRuleDetailedStatusRequest
      ): F[GetOrganizationConfigRuleDetailedStatusResponse]

      def getOrganizationConformancePackDetailedStatus(
        request: GetOrganizationConformancePackDetailedStatusRequest
      ): F[GetOrganizationConformancePackDetailedStatusResponse]

      def getResourceConfigHistory(
        request: GetResourceConfigHistoryRequest
      ): F[GetResourceConfigHistoryResponse]

      def getStoredQuery(
        request: GetStoredQueryRequest
      ): F[GetStoredQueryResponse]

      def listAggregateDiscoveredResources(
        request: ListAggregateDiscoveredResourcesRequest
      ): F[ListAggregateDiscoveredResourcesResponse]

      def listDiscoveredResources(
        request: ListDiscoveredResourcesRequest
      ): F[ListDiscoveredResourcesResponse]

      def listStoredQueries(
        request: ListStoredQueriesRequest
      ): F[ListStoredQueriesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putAggregationAuthorization(
        request: PutAggregationAuthorizationRequest
      ): F[PutAggregationAuthorizationResponse]

      def putConfigRule(
        request: PutConfigRuleRequest
      ): F[PutConfigRuleResponse]

      def putConfigurationAggregator(
        request: PutConfigurationAggregatorRequest
      ): F[PutConfigurationAggregatorResponse]

      def putConfigurationRecorder(
        request: PutConfigurationRecorderRequest
      ): F[PutConfigurationRecorderResponse]

      def putConformancePack(
        request: PutConformancePackRequest
      ): F[PutConformancePackResponse]

      def putDeliveryChannel(
        request: PutDeliveryChannelRequest
      ): F[PutDeliveryChannelResponse]

      def putEvaluations(
        request: PutEvaluationsRequest
      ): F[PutEvaluationsResponse]

      def putExternalEvaluation(
        request: PutExternalEvaluationRequest
      ): F[PutExternalEvaluationResponse]

      def putOrganizationConfigRule(
        request: PutOrganizationConfigRuleRequest
      ): F[PutOrganizationConfigRuleResponse]

      def putOrganizationConformancePack(
        request: PutOrganizationConformancePackRequest
      ): F[PutOrganizationConformancePackResponse]

      def putRemediationConfigurations(
        request: PutRemediationConfigurationsRequest
      ): F[PutRemediationConfigurationsResponse]

      def putRemediationExceptions(
        request: PutRemediationExceptionsRequest
      ): F[PutRemediationExceptionsResponse]

      def putResourceConfig(
        request: PutResourceConfigRequest
      ): F[PutResourceConfigResponse]

      def putRetentionConfiguration(
        request: PutRetentionConfigurationRequest
      ): F[PutRetentionConfigurationResponse]

      def putStoredQuery(
        request: PutStoredQueryRequest
      ): F[PutStoredQueryResponse]

      def selectAggregateResourceConfig(
        request: SelectAggregateResourceConfigRequest
      ): F[SelectAggregateResourceConfigResponse]

      def selectResourceConfig(
        request: SelectResourceConfigRequest
      ): F[SelectResourceConfigResponse]

      def startConfigRulesEvaluation(
        request: StartConfigRulesEvaluationRequest
      ): F[StartConfigRulesEvaluationResponse]

      def startConfigurationRecorder(
        request: StartConfigurationRecorderRequest
      ): F[StartConfigurationRecorderResponse]

      def startRemediationExecution(
        request: StartRemediationExecutionRequest
      ): F[StartRemediationExecutionResponse]

      def stopConfigurationRecorder(
        request: StopConfigurationRecorderRequest
      ): F[StopConfigurationRecorderResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ConfigOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchGetAggregateResourceConfigOp(
      request: BatchGetAggregateResourceConfigRequest
    ) extends ConfigOp[BatchGetAggregateResourceConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetAggregateResourceConfigResponse] =
        visitor.batchGetAggregateResourceConfig(request)
    }

    final case class BatchGetResourceConfigOp(
      request: BatchGetResourceConfigRequest
    ) extends ConfigOp[BatchGetResourceConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetResourceConfigResponse] =
        visitor.batchGetResourceConfig(request)
    }

    final case class DeleteAggregationAuthorizationOp(
      request: DeleteAggregationAuthorizationRequest
    ) extends ConfigOp[DeleteAggregationAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAggregationAuthorizationResponse] =
        visitor.deleteAggregationAuthorization(request)
    }

    final case class DeleteConfigRuleOp(
      request: DeleteConfigRuleRequest
    ) extends ConfigOp[DeleteConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigRuleResponse] =
        visitor.deleteConfigRule(request)
    }

    final case class DeleteConfigurationAggregatorOp(
      request: DeleteConfigurationAggregatorRequest
    ) extends ConfigOp[DeleteConfigurationAggregatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationAggregatorResponse] =
        visitor.deleteConfigurationAggregator(request)
    }

    final case class DeleteConfigurationRecorderOp(
      request: DeleteConfigurationRecorderRequest
    ) extends ConfigOp[DeleteConfigurationRecorderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationRecorderResponse] =
        visitor.deleteConfigurationRecorder(request)
    }

    final case class DeleteConformancePackOp(
      request: DeleteConformancePackRequest
    ) extends ConfigOp[DeleteConformancePackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConformancePackResponse] =
        visitor.deleteConformancePack(request)
    }

    final case class DeleteDeliveryChannelOp(
      request: DeleteDeliveryChannelRequest
    ) extends ConfigOp[DeleteDeliveryChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeliveryChannelResponse] =
        visitor.deleteDeliveryChannel(request)
    }

    final case class DeleteEvaluationResultsOp(
      request: DeleteEvaluationResultsRequest
    ) extends ConfigOp[DeleteEvaluationResultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEvaluationResultsResponse] =
        visitor.deleteEvaluationResults(request)
    }

    final case class DeleteOrganizationConfigRuleOp(
      request: DeleteOrganizationConfigRuleRequest
    ) extends ConfigOp[DeleteOrganizationConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOrganizationConfigRuleResponse] =
        visitor.deleteOrganizationConfigRule(request)
    }

    final case class DeleteOrganizationConformancePackOp(
      request: DeleteOrganizationConformancePackRequest
    ) extends ConfigOp[DeleteOrganizationConformancePackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOrganizationConformancePackResponse] =
        visitor.deleteOrganizationConformancePack(request)
    }

    final case class DeletePendingAggregationRequestOp(
      request: DeletePendingAggregationRequestRequest
    ) extends ConfigOp[DeletePendingAggregationRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePendingAggregationRequestResponse] =
        visitor.deletePendingAggregationRequest(request)
    }

    final case class DeleteRemediationConfigurationOp(
      request: DeleteRemediationConfigurationRequest
    ) extends ConfigOp[DeleteRemediationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRemediationConfigurationResponse] =
        visitor.deleteRemediationConfiguration(request)
    }

    final case class DeleteRemediationExceptionsOp(
      request: DeleteRemediationExceptionsRequest
    ) extends ConfigOp[DeleteRemediationExceptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRemediationExceptionsResponse] =
        visitor.deleteRemediationExceptions(request)
    }

    final case class DeleteResourceConfigOp(
      request: DeleteResourceConfigRequest
    ) extends ConfigOp[DeleteResourceConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceConfigResponse] =
        visitor.deleteResourceConfig(request)
    }

    final case class DeleteRetentionConfigurationOp(
      request: DeleteRetentionConfigurationRequest
    ) extends ConfigOp[DeleteRetentionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRetentionConfigurationResponse] =
        visitor.deleteRetentionConfiguration(request)
    }

    final case class DeleteStoredQueryOp(
      request: DeleteStoredQueryRequest
    ) extends ConfigOp[DeleteStoredQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStoredQueryResponse] =
        visitor.deleteStoredQuery(request)
    }

    final case class DeliverConfigSnapshotOp(
      request: DeliverConfigSnapshotRequest
    ) extends ConfigOp[DeliverConfigSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeliverConfigSnapshotResponse] =
        visitor.deliverConfigSnapshot(request)
    }

    final case class DescribeAggregateComplianceByConfigRulesOp(
      request: DescribeAggregateComplianceByConfigRulesRequest
    ) extends ConfigOp[DescribeAggregateComplianceByConfigRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAggregateComplianceByConfigRulesResponse] =
        visitor.describeAggregateComplianceByConfigRules(request)
    }

    final case class DescribeAggregateComplianceByConformancePacksOp(
      request: DescribeAggregateComplianceByConformancePacksRequest
    ) extends ConfigOp[DescribeAggregateComplianceByConformancePacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAggregateComplianceByConformancePacksResponse] =
        visitor.describeAggregateComplianceByConformancePacks(request)
    }

    final case class DescribeAggregationAuthorizationsOp(
      request: DescribeAggregationAuthorizationsRequest
    ) extends ConfigOp[DescribeAggregationAuthorizationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAggregationAuthorizationsResponse] =
        visitor.describeAggregationAuthorizations(request)
    }

    final case class DescribeComplianceByConfigRuleOp(
      request: DescribeComplianceByConfigRuleRequest
    ) extends ConfigOp[DescribeComplianceByConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeComplianceByConfigRuleResponse] =
        visitor.describeComplianceByConfigRule(request)
    }

    final case class DescribeComplianceByResourceOp(
      request: DescribeComplianceByResourceRequest
    ) extends ConfigOp[DescribeComplianceByResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeComplianceByResourceResponse] =
        visitor.describeComplianceByResource(request)
    }

    final case class DescribeConfigRuleEvaluationStatusOp(
      request: DescribeConfigRuleEvaluationStatusRequest
    ) extends ConfigOp[DescribeConfigRuleEvaluationStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigRuleEvaluationStatusResponse] =
        visitor.describeConfigRuleEvaluationStatus(request)
    }

    final case class DescribeConfigRulesOp(
      request: DescribeConfigRulesRequest
    ) extends ConfigOp[DescribeConfigRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigRulesResponse] =
        visitor.describeConfigRules(request)
    }

    final case class DescribeConfigurationAggregatorSourcesStatusOp(
      request: DescribeConfigurationAggregatorSourcesStatusRequest
    ) extends ConfigOp[DescribeConfigurationAggregatorSourcesStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationAggregatorSourcesStatusResponse] =
        visitor.describeConfigurationAggregatorSourcesStatus(request)
    }

    final case class DescribeConfigurationAggregatorsOp(
      request: DescribeConfigurationAggregatorsRequest
    ) extends ConfigOp[DescribeConfigurationAggregatorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationAggregatorsResponse] =
        visitor.describeConfigurationAggregators(request)
    }

    final case class DescribeConfigurationRecorderStatusOp(
      request: DescribeConfigurationRecorderStatusRequest
    ) extends ConfigOp[DescribeConfigurationRecorderStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationRecorderStatusResponse] =
        visitor.describeConfigurationRecorderStatus(request)
    }

    final case class DescribeConfigurationRecordersOp(
      request: DescribeConfigurationRecordersRequest
    ) extends ConfigOp[DescribeConfigurationRecordersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationRecordersResponse] =
        visitor.describeConfigurationRecorders(request)
    }

    final case class DescribeConformancePackComplianceOp(
      request: DescribeConformancePackComplianceRequest
    ) extends ConfigOp[DescribeConformancePackComplianceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConformancePackComplianceResponse] =
        visitor.describeConformancePackCompliance(request)
    }

    final case class DescribeConformancePackStatusOp(
      request: DescribeConformancePackStatusRequest
    ) extends ConfigOp[DescribeConformancePackStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConformancePackStatusResponse] =
        visitor.describeConformancePackStatus(request)
    }

    final case class DescribeConformancePacksOp(
      request: DescribeConformancePacksRequest
    ) extends ConfigOp[DescribeConformancePacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConformancePacksResponse] =
        visitor.describeConformancePacks(request)
    }

    final case class DescribeDeliveryChannelStatusOp(
      request: DescribeDeliveryChannelStatusRequest
    ) extends ConfigOp[DescribeDeliveryChannelStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeliveryChannelStatusResponse] =
        visitor.describeDeliveryChannelStatus(request)
    }

    final case class DescribeDeliveryChannelsOp(
      request: DescribeDeliveryChannelsRequest
    ) extends ConfigOp[DescribeDeliveryChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeliveryChannelsResponse] =
        visitor.describeDeliveryChannels(request)
    }

    final case class DescribeOrganizationConfigRuleStatusesOp(
      request: DescribeOrganizationConfigRuleStatusesRequest
    ) extends ConfigOp[DescribeOrganizationConfigRuleStatusesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationConfigRuleStatusesResponse] =
        visitor.describeOrganizationConfigRuleStatuses(request)
    }

    final case class DescribeOrganizationConfigRulesOp(
      request: DescribeOrganizationConfigRulesRequest
    ) extends ConfigOp[DescribeOrganizationConfigRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationConfigRulesResponse] =
        visitor.describeOrganizationConfigRules(request)
    }

    final case class DescribeOrganizationConformancePackStatusesOp(
      request: DescribeOrganizationConformancePackStatusesRequest
    ) extends ConfigOp[DescribeOrganizationConformancePackStatusesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationConformancePackStatusesResponse] =
        visitor.describeOrganizationConformancePackStatuses(request)
    }

    final case class DescribeOrganizationConformancePacksOp(
      request: DescribeOrganizationConformancePacksRequest
    ) extends ConfigOp[DescribeOrganizationConformancePacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationConformancePacksResponse] =
        visitor.describeOrganizationConformancePacks(request)
    }

    final case class DescribePendingAggregationRequestsOp(
      request: DescribePendingAggregationRequestsRequest
    ) extends ConfigOp[DescribePendingAggregationRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePendingAggregationRequestsResponse] =
        visitor.describePendingAggregationRequests(request)
    }

    final case class DescribeRemediationConfigurationsOp(
      request: DescribeRemediationConfigurationsRequest
    ) extends ConfigOp[DescribeRemediationConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRemediationConfigurationsResponse] =
        visitor.describeRemediationConfigurations(request)
    }

    final case class DescribeRemediationExceptionsOp(
      request: DescribeRemediationExceptionsRequest
    ) extends ConfigOp[DescribeRemediationExceptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRemediationExceptionsResponse] =
        visitor.describeRemediationExceptions(request)
    }

    final case class DescribeRemediationExecutionStatusOp(
      request: DescribeRemediationExecutionStatusRequest
    ) extends ConfigOp[DescribeRemediationExecutionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRemediationExecutionStatusResponse] =
        visitor.describeRemediationExecutionStatus(request)
    }

    final case class DescribeRetentionConfigurationsOp(
      request: DescribeRetentionConfigurationsRequest
    ) extends ConfigOp[DescribeRetentionConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRetentionConfigurationsResponse] =
        visitor.describeRetentionConfigurations(request)
    }

    final case class GetAggregateComplianceDetailsByConfigRuleOp(
      request: GetAggregateComplianceDetailsByConfigRuleRequest
    ) extends ConfigOp[GetAggregateComplianceDetailsByConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAggregateComplianceDetailsByConfigRuleResponse] =
        visitor.getAggregateComplianceDetailsByConfigRule(request)
    }

    final case class GetAggregateConfigRuleComplianceSummaryOp(
      request: GetAggregateConfigRuleComplianceSummaryRequest
    ) extends ConfigOp[GetAggregateConfigRuleComplianceSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAggregateConfigRuleComplianceSummaryResponse] =
        visitor.getAggregateConfigRuleComplianceSummary(request)
    }

    final case class GetAggregateConformancePackComplianceSummaryOp(
      request: GetAggregateConformancePackComplianceSummaryRequest
    ) extends ConfigOp[GetAggregateConformancePackComplianceSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAggregateConformancePackComplianceSummaryResponse] =
        visitor.getAggregateConformancePackComplianceSummary(request)
    }

    final case class GetAggregateDiscoveredResourceCountsOp(
      request: GetAggregateDiscoveredResourceCountsRequest
    ) extends ConfigOp[GetAggregateDiscoveredResourceCountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAggregateDiscoveredResourceCountsResponse] =
        visitor.getAggregateDiscoveredResourceCounts(request)
    }

    final case class GetAggregateResourceConfigOp(
      request: GetAggregateResourceConfigRequest
    ) extends ConfigOp[GetAggregateResourceConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAggregateResourceConfigResponse] =
        visitor.getAggregateResourceConfig(request)
    }

    final case class GetComplianceDetailsByConfigRuleOp(
      request: GetComplianceDetailsByConfigRuleRequest
    ) extends ConfigOp[GetComplianceDetailsByConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComplianceDetailsByConfigRuleResponse] =
        visitor.getComplianceDetailsByConfigRule(request)
    }

    final case class GetComplianceDetailsByResourceOp(
      request: GetComplianceDetailsByResourceRequest
    ) extends ConfigOp[GetComplianceDetailsByResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComplianceDetailsByResourceResponse] =
        visitor.getComplianceDetailsByResource(request)
    }

    final case class GetComplianceSummaryByConfigRuleOp(
      request: GetComplianceSummaryByConfigRuleRequest
    ) extends ConfigOp[GetComplianceSummaryByConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComplianceSummaryByConfigRuleResponse] =
        visitor.getComplianceSummaryByConfigRule(request)
    }

    final case class GetComplianceSummaryByResourceTypeOp(
      request: GetComplianceSummaryByResourceTypeRequest
    ) extends ConfigOp[GetComplianceSummaryByResourceTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComplianceSummaryByResourceTypeResponse] =
        visitor.getComplianceSummaryByResourceType(request)
    }

    final case class GetConformancePackComplianceDetailsOp(
      request: GetConformancePackComplianceDetailsRequest
    ) extends ConfigOp[GetConformancePackComplianceDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConformancePackComplianceDetailsResponse] =
        visitor.getConformancePackComplianceDetails(request)
    }

    final case class GetConformancePackComplianceSummaryOp(
      request: GetConformancePackComplianceSummaryRequest
    ) extends ConfigOp[GetConformancePackComplianceSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConformancePackComplianceSummaryResponse] =
        visitor.getConformancePackComplianceSummary(request)
    }

    final case class GetDiscoveredResourceCountsOp(
      request: GetDiscoveredResourceCountsRequest
    ) extends ConfigOp[GetDiscoveredResourceCountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDiscoveredResourceCountsResponse] =
        visitor.getDiscoveredResourceCounts(request)
    }

    final case class GetOrganizationConfigRuleDetailedStatusOp(
      request: GetOrganizationConfigRuleDetailedStatusRequest
    ) extends ConfigOp[GetOrganizationConfigRuleDetailedStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOrganizationConfigRuleDetailedStatusResponse] =
        visitor.getOrganizationConfigRuleDetailedStatus(request)
    }

    final case class GetOrganizationConformancePackDetailedStatusOp(
      request: GetOrganizationConformancePackDetailedStatusRequest
    ) extends ConfigOp[GetOrganizationConformancePackDetailedStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOrganizationConformancePackDetailedStatusResponse] =
        visitor.getOrganizationConformancePackDetailedStatus(request)
    }

    final case class GetResourceConfigHistoryOp(
      request: GetResourceConfigHistoryRequest
    ) extends ConfigOp[GetResourceConfigHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceConfigHistoryResponse] =
        visitor.getResourceConfigHistory(request)
    }

    final case class GetStoredQueryOp(
      request: GetStoredQueryRequest
    ) extends ConfigOp[GetStoredQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStoredQueryResponse] =
        visitor.getStoredQuery(request)
    }

    final case class ListAggregateDiscoveredResourcesOp(
      request: ListAggregateDiscoveredResourcesRequest
    ) extends ConfigOp[ListAggregateDiscoveredResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAggregateDiscoveredResourcesResponse] =
        visitor.listAggregateDiscoveredResources(request)
    }

    final case class ListDiscoveredResourcesOp(
      request: ListDiscoveredResourcesRequest
    ) extends ConfigOp[ListDiscoveredResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDiscoveredResourcesResponse] =
        visitor.listDiscoveredResources(request)
    }

    final case class ListStoredQueriesOp(
      request: ListStoredQueriesRequest
    ) extends ConfigOp[ListStoredQueriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStoredQueriesResponse] =
        visitor.listStoredQueries(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ConfigOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutAggregationAuthorizationOp(
      request: PutAggregationAuthorizationRequest
    ) extends ConfigOp[PutAggregationAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAggregationAuthorizationResponse] =
        visitor.putAggregationAuthorization(request)
    }

    final case class PutConfigRuleOp(
      request: PutConfigRuleRequest
    ) extends ConfigOp[PutConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigRuleResponse] =
        visitor.putConfigRule(request)
    }

    final case class PutConfigurationAggregatorOp(
      request: PutConfigurationAggregatorRequest
    ) extends ConfigOp[PutConfigurationAggregatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationAggregatorResponse] =
        visitor.putConfigurationAggregator(request)
    }

    final case class PutConfigurationRecorderOp(
      request: PutConfigurationRecorderRequest
    ) extends ConfigOp[PutConfigurationRecorderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConfigurationRecorderResponse] =
        visitor.putConfigurationRecorder(request)
    }

    final case class PutConformancePackOp(
      request: PutConformancePackRequest
    ) extends ConfigOp[PutConformancePackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConformancePackResponse] =
        visitor.putConformancePack(request)
    }

    final case class PutDeliveryChannelOp(
      request: PutDeliveryChannelRequest
    ) extends ConfigOp[PutDeliveryChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDeliveryChannelResponse] =
        visitor.putDeliveryChannel(request)
    }

    final case class PutEvaluationsOp(
      request: PutEvaluationsRequest
    ) extends ConfigOp[PutEvaluationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEvaluationsResponse] =
        visitor.putEvaluations(request)
    }

    final case class PutExternalEvaluationOp(
      request: PutExternalEvaluationRequest
    ) extends ConfigOp[PutExternalEvaluationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutExternalEvaluationResponse] =
        visitor.putExternalEvaluation(request)
    }

    final case class PutOrganizationConfigRuleOp(
      request: PutOrganizationConfigRuleRequest
    ) extends ConfigOp[PutOrganizationConfigRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutOrganizationConfigRuleResponse] =
        visitor.putOrganizationConfigRule(request)
    }

    final case class PutOrganizationConformancePackOp(
      request: PutOrganizationConformancePackRequest
    ) extends ConfigOp[PutOrganizationConformancePackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutOrganizationConformancePackResponse] =
        visitor.putOrganizationConformancePack(request)
    }

    final case class PutRemediationConfigurationsOp(
      request: PutRemediationConfigurationsRequest
    ) extends ConfigOp[PutRemediationConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRemediationConfigurationsResponse] =
        visitor.putRemediationConfigurations(request)
    }

    final case class PutRemediationExceptionsOp(
      request: PutRemediationExceptionsRequest
    ) extends ConfigOp[PutRemediationExceptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRemediationExceptionsResponse] =
        visitor.putRemediationExceptions(request)
    }

    final case class PutResourceConfigOp(
      request: PutResourceConfigRequest
    ) extends ConfigOp[PutResourceConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourceConfigResponse] =
        visitor.putResourceConfig(request)
    }

    final case class PutRetentionConfigurationOp(
      request: PutRetentionConfigurationRequest
    ) extends ConfigOp[PutRetentionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRetentionConfigurationResponse] =
        visitor.putRetentionConfiguration(request)
    }

    final case class PutStoredQueryOp(
      request: PutStoredQueryRequest
    ) extends ConfigOp[PutStoredQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutStoredQueryResponse] =
        visitor.putStoredQuery(request)
    }

    final case class SelectAggregateResourceConfigOp(
      request: SelectAggregateResourceConfigRequest
    ) extends ConfigOp[SelectAggregateResourceConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SelectAggregateResourceConfigResponse] =
        visitor.selectAggregateResourceConfig(request)
    }

    final case class SelectResourceConfigOp(
      request: SelectResourceConfigRequest
    ) extends ConfigOp[SelectResourceConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SelectResourceConfigResponse] =
        visitor.selectResourceConfig(request)
    }

    final case class StartConfigRulesEvaluationOp(
      request: StartConfigRulesEvaluationRequest
    ) extends ConfigOp[StartConfigRulesEvaluationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartConfigRulesEvaluationResponse] =
        visitor.startConfigRulesEvaluation(request)
    }

    final case class StartConfigurationRecorderOp(
      request: StartConfigurationRecorderRequest
    ) extends ConfigOp[StartConfigurationRecorderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartConfigurationRecorderResponse] =
        visitor.startConfigurationRecorder(request)
    }

    final case class StartRemediationExecutionOp(
      request: StartRemediationExecutionRequest
    ) extends ConfigOp[StartRemediationExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartRemediationExecutionResponse] =
        visitor.startRemediationExecution(request)
    }

    final case class StopConfigurationRecorderOp(
      request: StopConfigurationRecorderRequest
    ) extends ConfigOp[StopConfigurationRecorderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopConfigurationRecorderResponse] =
        visitor.stopConfigurationRecorder(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ConfigOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ConfigOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import ConfigOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ConfigOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchGetAggregateResourceConfig(
    request: BatchGetAggregateResourceConfigRequest
  ): ConfigIO[BatchGetAggregateResourceConfigResponse] =
    FF.liftF(BatchGetAggregateResourceConfigOp(request))

  def batchGetResourceConfig(
    request: BatchGetResourceConfigRequest
  ): ConfigIO[BatchGetResourceConfigResponse] =
    FF.liftF(BatchGetResourceConfigOp(request))

  def deleteAggregationAuthorization(
    request: DeleteAggregationAuthorizationRequest
  ): ConfigIO[DeleteAggregationAuthorizationResponse] =
    FF.liftF(DeleteAggregationAuthorizationOp(request))

  def deleteConfigRule(
    request: DeleteConfigRuleRequest
  ): ConfigIO[DeleteConfigRuleResponse] =
    FF.liftF(DeleteConfigRuleOp(request))

  def deleteConfigurationAggregator(
    request: DeleteConfigurationAggregatorRequest
  ): ConfigIO[DeleteConfigurationAggregatorResponse] =
    FF.liftF(DeleteConfigurationAggregatorOp(request))

  def deleteConfigurationRecorder(
    request: DeleteConfigurationRecorderRequest
  ): ConfigIO[DeleteConfigurationRecorderResponse] =
    FF.liftF(DeleteConfigurationRecorderOp(request))

  def deleteConformancePack(
    request: DeleteConformancePackRequest
  ): ConfigIO[DeleteConformancePackResponse] =
    FF.liftF(DeleteConformancePackOp(request))

  def deleteDeliveryChannel(
    request: DeleteDeliveryChannelRequest
  ): ConfigIO[DeleteDeliveryChannelResponse] =
    FF.liftF(DeleteDeliveryChannelOp(request))

  def deleteEvaluationResults(
    request: DeleteEvaluationResultsRequest
  ): ConfigIO[DeleteEvaluationResultsResponse] =
    FF.liftF(DeleteEvaluationResultsOp(request))

  def deleteOrganizationConfigRule(
    request: DeleteOrganizationConfigRuleRequest
  ): ConfigIO[DeleteOrganizationConfigRuleResponse] =
    FF.liftF(DeleteOrganizationConfigRuleOp(request))

  def deleteOrganizationConformancePack(
    request: DeleteOrganizationConformancePackRequest
  ): ConfigIO[DeleteOrganizationConformancePackResponse] =
    FF.liftF(DeleteOrganizationConformancePackOp(request))

  def deletePendingAggregationRequest(
    request: DeletePendingAggregationRequestRequest
  ): ConfigIO[DeletePendingAggregationRequestResponse] =
    FF.liftF(DeletePendingAggregationRequestOp(request))

  def deleteRemediationConfiguration(
    request: DeleteRemediationConfigurationRequest
  ): ConfigIO[DeleteRemediationConfigurationResponse] =
    FF.liftF(DeleteRemediationConfigurationOp(request))

  def deleteRemediationExceptions(
    request: DeleteRemediationExceptionsRequest
  ): ConfigIO[DeleteRemediationExceptionsResponse] =
    FF.liftF(DeleteRemediationExceptionsOp(request))

  def deleteResourceConfig(
    request: DeleteResourceConfigRequest
  ): ConfigIO[DeleteResourceConfigResponse] =
    FF.liftF(DeleteResourceConfigOp(request))

  def deleteRetentionConfiguration(
    request: DeleteRetentionConfigurationRequest
  ): ConfigIO[DeleteRetentionConfigurationResponse] =
    FF.liftF(DeleteRetentionConfigurationOp(request))

  def deleteStoredQuery(
    request: DeleteStoredQueryRequest
  ): ConfigIO[DeleteStoredQueryResponse] =
    FF.liftF(DeleteStoredQueryOp(request))

  def deliverConfigSnapshot(
    request: DeliverConfigSnapshotRequest
  ): ConfigIO[DeliverConfigSnapshotResponse] =
    FF.liftF(DeliverConfigSnapshotOp(request))

  def describeAggregateComplianceByConfigRules(
    request: DescribeAggregateComplianceByConfigRulesRequest
  ): ConfigIO[DescribeAggregateComplianceByConfigRulesResponse] =
    FF.liftF(DescribeAggregateComplianceByConfigRulesOp(request))

  def describeAggregateComplianceByConformancePacks(
    request: DescribeAggregateComplianceByConformancePacksRequest
  ): ConfigIO[DescribeAggregateComplianceByConformancePacksResponse] =
    FF.liftF(DescribeAggregateComplianceByConformancePacksOp(request))

  def describeAggregationAuthorizations(
    request: DescribeAggregationAuthorizationsRequest
  ): ConfigIO[DescribeAggregationAuthorizationsResponse] =
    FF.liftF(DescribeAggregationAuthorizationsOp(request))

  def describeComplianceByConfigRule(
    request: DescribeComplianceByConfigRuleRequest
  ): ConfigIO[DescribeComplianceByConfigRuleResponse] =
    FF.liftF(DescribeComplianceByConfigRuleOp(request))

  def describeComplianceByResource(
    request: DescribeComplianceByResourceRequest
  ): ConfigIO[DescribeComplianceByResourceResponse] =
    FF.liftF(DescribeComplianceByResourceOp(request))

  def describeConfigRuleEvaluationStatus(
    request: DescribeConfigRuleEvaluationStatusRequest
  ): ConfigIO[DescribeConfigRuleEvaluationStatusResponse] =
    FF.liftF(DescribeConfigRuleEvaluationStatusOp(request))

  def describeConfigRules(
    request: DescribeConfigRulesRequest
  ): ConfigIO[DescribeConfigRulesResponse] =
    FF.liftF(DescribeConfigRulesOp(request))

  def describeConfigurationAggregatorSourcesStatus(
    request: DescribeConfigurationAggregatorSourcesStatusRequest
  ): ConfigIO[DescribeConfigurationAggregatorSourcesStatusResponse] =
    FF.liftF(DescribeConfigurationAggregatorSourcesStatusOp(request))

  def describeConfigurationAggregators(
    request: DescribeConfigurationAggregatorsRequest
  ): ConfigIO[DescribeConfigurationAggregatorsResponse] =
    FF.liftF(DescribeConfigurationAggregatorsOp(request))

  def describeConfigurationRecorderStatus(
    request: DescribeConfigurationRecorderStatusRequest
  ): ConfigIO[DescribeConfigurationRecorderStatusResponse] =
    FF.liftF(DescribeConfigurationRecorderStatusOp(request))

  def describeConfigurationRecorders(
    request: DescribeConfigurationRecordersRequest
  ): ConfigIO[DescribeConfigurationRecordersResponse] =
    FF.liftF(DescribeConfigurationRecordersOp(request))

  def describeConformancePackCompliance(
    request: DescribeConformancePackComplianceRequest
  ): ConfigIO[DescribeConformancePackComplianceResponse] =
    FF.liftF(DescribeConformancePackComplianceOp(request))

  def describeConformancePackStatus(
    request: DescribeConformancePackStatusRequest
  ): ConfigIO[DescribeConformancePackStatusResponse] =
    FF.liftF(DescribeConformancePackStatusOp(request))

  def describeConformancePacks(
    request: DescribeConformancePacksRequest
  ): ConfigIO[DescribeConformancePacksResponse] =
    FF.liftF(DescribeConformancePacksOp(request))

  def describeDeliveryChannelStatus(
    request: DescribeDeliveryChannelStatusRequest
  ): ConfigIO[DescribeDeliveryChannelStatusResponse] =
    FF.liftF(DescribeDeliveryChannelStatusOp(request))

  def describeDeliveryChannels(
    request: DescribeDeliveryChannelsRequest
  ): ConfigIO[DescribeDeliveryChannelsResponse] =
    FF.liftF(DescribeDeliveryChannelsOp(request))

  def describeOrganizationConfigRuleStatuses(
    request: DescribeOrganizationConfigRuleStatusesRequest
  ): ConfigIO[DescribeOrganizationConfigRuleStatusesResponse] =
    FF.liftF(DescribeOrganizationConfigRuleStatusesOp(request))

  def describeOrganizationConfigRules(
    request: DescribeOrganizationConfigRulesRequest
  ): ConfigIO[DescribeOrganizationConfigRulesResponse] =
    FF.liftF(DescribeOrganizationConfigRulesOp(request))

  def describeOrganizationConformancePackStatuses(
    request: DescribeOrganizationConformancePackStatusesRequest
  ): ConfigIO[DescribeOrganizationConformancePackStatusesResponse] =
    FF.liftF(DescribeOrganizationConformancePackStatusesOp(request))

  def describeOrganizationConformancePacks(
    request: DescribeOrganizationConformancePacksRequest
  ): ConfigIO[DescribeOrganizationConformancePacksResponse] =
    FF.liftF(DescribeOrganizationConformancePacksOp(request))

  def describePendingAggregationRequests(
    request: DescribePendingAggregationRequestsRequest
  ): ConfigIO[DescribePendingAggregationRequestsResponse] =
    FF.liftF(DescribePendingAggregationRequestsOp(request))

  def describeRemediationConfigurations(
    request: DescribeRemediationConfigurationsRequest
  ): ConfigIO[DescribeRemediationConfigurationsResponse] =
    FF.liftF(DescribeRemediationConfigurationsOp(request))

  def describeRemediationExceptions(
    request: DescribeRemediationExceptionsRequest
  ): ConfigIO[DescribeRemediationExceptionsResponse] =
    FF.liftF(DescribeRemediationExceptionsOp(request))

  def describeRemediationExecutionStatus(
    request: DescribeRemediationExecutionStatusRequest
  ): ConfigIO[DescribeRemediationExecutionStatusResponse] =
    FF.liftF(DescribeRemediationExecutionStatusOp(request))

  def describeRetentionConfigurations(
    request: DescribeRetentionConfigurationsRequest
  ): ConfigIO[DescribeRetentionConfigurationsResponse] =
    FF.liftF(DescribeRetentionConfigurationsOp(request))

  def getAggregateComplianceDetailsByConfigRule(
    request: GetAggregateComplianceDetailsByConfigRuleRequest
  ): ConfigIO[GetAggregateComplianceDetailsByConfigRuleResponse] =
    FF.liftF(GetAggregateComplianceDetailsByConfigRuleOp(request))

  def getAggregateConfigRuleComplianceSummary(
    request: GetAggregateConfigRuleComplianceSummaryRequest
  ): ConfigIO[GetAggregateConfigRuleComplianceSummaryResponse] =
    FF.liftF(GetAggregateConfigRuleComplianceSummaryOp(request))

  def getAggregateConformancePackComplianceSummary(
    request: GetAggregateConformancePackComplianceSummaryRequest
  ): ConfigIO[GetAggregateConformancePackComplianceSummaryResponse] =
    FF.liftF(GetAggregateConformancePackComplianceSummaryOp(request))

  def getAggregateDiscoveredResourceCounts(
    request: GetAggregateDiscoveredResourceCountsRequest
  ): ConfigIO[GetAggregateDiscoveredResourceCountsResponse] =
    FF.liftF(GetAggregateDiscoveredResourceCountsOp(request))

  def getAggregateResourceConfig(
    request: GetAggregateResourceConfigRequest
  ): ConfigIO[GetAggregateResourceConfigResponse] =
    FF.liftF(GetAggregateResourceConfigOp(request))

  def getComplianceDetailsByConfigRule(
    request: GetComplianceDetailsByConfigRuleRequest
  ): ConfigIO[GetComplianceDetailsByConfigRuleResponse] =
    FF.liftF(GetComplianceDetailsByConfigRuleOp(request))

  def getComplianceDetailsByResource(
    request: GetComplianceDetailsByResourceRequest
  ): ConfigIO[GetComplianceDetailsByResourceResponse] =
    FF.liftF(GetComplianceDetailsByResourceOp(request))

  def getComplianceSummaryByConfigRule(
    request: GetComplianceSummaryByConfigRuleRequest
  ): ConfigIO[GetComplianceSummaryByConfigRuleResponse] =
    FF.liftF(GetComplianceSummaryByConfigRuleOp(request))

  def getComplianceSummaryByResourceType(
    request: GetComplianceSummaryByResourceTypeRequest
  ): ConfigIO[GetComplianceSummaryByResourceTypeResponse] =
    FF.liftF(GetComplianceSummaryByResourceTypeOp(request))

  def getConformancePackComplianceDetails(
    request: GetConformancePackComplianceDetailsRequest
  ): ConfigIO[GetConformancePackComplianceDetailsResponse] =
    FF.liftF(GetConformancePackComplianceDetailsOp(request))

  def getConformancePackComplianceSummary(
    request: GetConformancePackComplianceSummaryRequest
  ): ConfigIO[GetConformancePackComplianceSummaryResponse] =
    FF.liftF(GetConformancePackComplianceSummaryOp(request))

  def getDiscoveredResourceCounts(
    request: GetDiscoveredResourceCountsRequest
  ): ConfigIO[GetDiscoveredResourceCountsResponse] =
    FF.liftF(GetDiscoveredResourceCountsOp(request))

  def getOrganizationConfigRuleDetailedStatus(
    request: GetOrganizationConfigRuleDetailedStatusRequest
  ): ConfigIO[GetOrganizationConfigRuleDetailedStatusResponse] =
    FF.liftF(GetOrganizationConfigRuleDetailedStatusOp(request))

  def getOrganizationConformancePackDetailedStatus(
    request: GetOrganizationConformancePackDetailedStatusRequest
  ): ConfigIO[GetOrganizationConformancePackDetailedStatusResponse] =
    FF.liftF(GetOrganizationConformancePackDetailedStatusOp(request))

  def getResourceConfigHistory(
    request: GetResourceConfigHistoryRequest
  ): ConfigIO[GetResourceConfigHistoryResponse] =
    FF.liftF(GetResourceConfigHistoryOp(request))

  def getStoredQuery(
    request: GetStoredQueryRequest
  ): ConfigIO[GetStoredQueryResponse] =
    FF.liftF(GetStoredQueryOp(request))

  def listAggregateDiscoveredResources(
    request: ListAggregateDiscoveredResourcesRequest
  ): ConfigIO[ListAggregateDiscoveredResourcesResponse] =
    FF.liftF(ListAggregateDiscoveredResourcesOp(request))

  def listDiscoveredResources(
    request: ListDiscoveredResourcesRequest
  ): ConfigIO[ListDiscoveredResourcesResponse] =
    FF.liftF(ListDiscoveredResourcesOp(request))

  def listStoredQueries(
    request: ListStoredQueriesRequest
  ): ConfigIO[ListStoredQueriesResponse] =
    FF.liftF(ListStoredQueriesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ConfigIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putAggregationAuthorization(
    request: PutAggregationAuthorizationRequest
  ): ConfigIO[PutAggregationAuthorizationResponse] =
    FF.liftF(PutAggregationAuthorizationOp(request))

  def putConfigRule(
    request: PutConfigRuleRequest
  ): ConfigIO[PutConfigRuleResponse] =
    FF.liftF(PutConfigRuleOp(request))

  def putConfigurationAggregator(
    request: PutConfigurationAggregatorRequest
  ): ConfigIO[PutConfigurationAggregatorResponse] =
    FF.liftF(PutConfigurationAggregatorOp(request))

  def putConfigurationRecorder(
    request: PutConfigurationRecorderRequest
  ): ConfigIO[PutConfigurationRecorderResponse] =
    FF.liftF(PutConfigurationRecorderOp(request))

  def putConformancePack(
    request: PutConformancePackRequest
  ): ConfigIO[PutConformancePackResponse] =
    FF.liftF(PutConformancePackOp(request))

  def putDeliveryChannel(
    request: PutDeliveryChannelRequest
  ): ConfigIO[PutDeliveryChannelResponse] =
    FF.liftF(PutDeliveryChannelOp(request))

  def putEvaluations(
    request: PutEvaluationsRequest
  ): ConfigIO[PutEvaluationsResponse] =
    FF.liftF(PutEvaluationsOp(request))

  def putExternalEvaluation(
    request: PutExternalEvaluationRequest
  ): ConfigIO[PutExternalEvaluationResponse] =
    FF.liftF(PutExternalEvaluationOp(request))

  def putOrganizationConfigRule(
    request: PutOrganizationConfigRuleRequest
  ): ConfigIO[PutOrganizationConfigRuleResponse] =
    FF.liftF(PutOrganizationConfigRuleOp(request))

  def putOrganizationConformancePack(
    request: PutOrganizationConformancePackRequest
  ): ConfigIO[PutOrganizationConformancePackResponse] =
    FF.liftF(PutOrganizationConformancePackOp(request))

  def putRemediationConfigurations(
    request: PutRemediationConfigurationsRequest
  ): ConfigIO[PutRemediationConfigurationsResponse] =
    FF.liftF(PutRemediationConfigurationsOp(request))

  def putRemediationExceptions(
    request: PutRemediationExceptionsRequest
  ): ConfigIO[PutRemediationExceptionsResponse] =
    FF.liftF(PutRemediationExceptionsOp(request))

  def putResourceConfig(
    request: PutResourceConfigRequest
  ): ConfigIO[PutResourceConfigResponse] =
    FF.liftF(PutResourceConfigOp(request))

  def putRetentionConfiguration(
    request: PutRetentionConfigurationRequest
  ): ConfigIO[PutRetentionConfigurationResponse] =
    FF.liftF(PutRetentionConfigurationOp(request))

  def putStoredQuery(
    request: PutStoredQueryRequest
  ): ConfigIO[PutStoredQueryResponse] =
    FF.liftF(PutStoredQueryOp(request))

  def selectAggregateResourceConfig(
    request: SelectAggregateResourceConfigRequest
  ): ConfigIO[SelectAggregateResourceConfigResponse] =
    FF.liftF(SelectAggregateResourceConfigOp(request))

  def selectResourceConfig(
    request: SelectResourceConfigRequest
  ): ConfigIO[SelectResourceConfigResponse] =
    FF.liftF(SelectResourceConfigOp(request))

  def startConfigRulesEvaluation(
    request: StartConfigRulesEvaluationRequest
  ): ConfigIO[StartConfigRulesEvaluationResponse] =
    FF.liftF(StartConfigRulesEvaluationOp(request))

  def startConfigurationRecorder(
    request: StartConfigurationRecorderRequest
  ): ConfigIO[StartConfigurationRecorderResponse] =
    FF.liftF(StartConfigurationRecorderOp(request))

  def startRemediationExecution(
    request: StartRemediationExecutionRequest
  ): ConfigIO[StartRemediationExecutionResponse] =
    FF.liftF(StartRemediationExecutionOp(request))

  def stopConfigurationRecorder(
    request: StopConfigurationRecorderRequest
  ): ConfigIO[StopConfigurationRecorderResponse] =
    FF.liftF(StopConfigurationRecorderOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ConfigIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ConfigIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
