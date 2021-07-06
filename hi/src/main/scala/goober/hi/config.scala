package goober.hi

import goober.free.config.ConfigIO
import software.amazon.awssdk.services.config.model._


object config {
  import goober.free.{config ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // BatchGetAggregateResourceConfigRequest
    // BatchGetResourceConfigRequest
    // DeleteAggregationAuthorizationRequest
    // DeleteConfigRuleRequest
    // DeleteConfigurationAggregatorRequest
    // DeleteConfigurationRecorderRequest
    // DeleteConformancePackRequest
    // DeleteDeliveryChannelRequest
    // DeleteEvaluationResultsRequest
    // DeleteOrganizationConfigRuleRequest
    // DeleteOrganizationConformancePackRequest
    // DeletePendingAggregationRequestRequest
    // DeleteRemediationConfigurationRequest
    // DeleteRemediationExceptionsRequest
    // DeleteResourceConfigRequest
    // DeleteRetentionConfigurationRequest
    // DeleteStoredQueryRequest
    // DeliverConfigSnapshotRequest
    // DescribeAggregateComplianceByConfigRulesRequest
    // DescribeAggregateComplianceByConformancePacksRequest
    // DescribeAggregationAuthorizationsRequest
    // DescribeComplianceByConfigRuleRequest
    // DescribeComplianceByResourceRequest
    // DescribeConfigRuleEvaluationStatusRequest
    // DescribeConfigRulesRequest
    // DescribeConfigurationAggregatorSourcesStatusRequest
    // DescribeConfigurationAggregatorsRequest
    // DescribeConfigurationRecorderStatusRequest
    // DescribeConfigurationRecordersRequest
    // DescribeConformancePackComplianceRequest
    // DescribeConformancePackStatusRequest
    // DescribeConformancePacksRequest
    // DescribeDeliveryChannelStatusRequest
    // DescribeDeliveryChannelsRequest
    // DescribeOrganizationConfigRuleStatusesRequest
    // DescribeOrganizationConfigRulesRequest
    // DescribeOrganizationConformancePackStatusesRequest
    // DescribeOrganizationConformancePacksRequest
    // DescribePendingAggregationRequestsRequest
    // DescribeRemediationConfigurationsRequest
    // DescribeRemediationExceptionsRequest
    // DescribeRemediationExecutionStatusRequest
    // DescribeRetentionConfigurationsRequest
    // GetAggregateComplianceDetailsByConfigRuleRequest
    // GetAggregateConfigRuleComplianceSummaryRequest
    // GetAggregateConformancePackComplianceSummaryRequest
    // GetAggregateDiscoveredResourceCountsRequest
    // GetAggregateResourceConfigRequest
    // GetComplianceDetailsByConfigRuleRequest
    // GetComplianceDetailsByResourceRequest
    // GetComplianceSummaryByConfigRuleRequest
    // GetComplianceSummaryByResourceTypeRequest
    // GetConformancePackComplianceDetailsRequest
    // GetConformancePackComplianceSummaryRequest
    // GetDiscoveredResourceCountsRequest
    // GetOrganizationConfigRuleDetailedStatusRequest
    // GetOrganizationConformancePackDetailedStatusRequest
    // GetResourceConfigHistoryRequest
    // GetStoredQueryRequest
    // ListAggregateDiscoveredResourcesRequest
    // ListDiscoveredResourcesRequest
    // ListStoredQueriesRequest
    // ListTagsForResourceRequest
    // PutAggregationAuthorizationRequest
    // PutConfigRuleRequest
    // PutConfigurationAggregatorRequest
    // PutConfigurationRecorderRequest
    // PutConformancePackRequest
    // PutDeliveryChannelRequest
    // PutEvaluationsRequest
    // PutExternalEvaluationRequest
    // PutOrganizationConfigRuleRequest
    // PutOrganizationConformancePackRequest
    // PutRemediationConfigurationsRequest
    // PutRemediationExceptionsRequest
    // PutResourceConfigRequest
    // PutRetentionConfigurationRequest
    // PutStoredQueryRequest
    // SelectAggregateResourceConfigRequest
    // SelectResourceConfigRequest
    // StartConfigRulesEvaluationRequest
    // StartConfigurationRecorderRequest
    // StartRemediationExecutionRequest
    // StopConfigurationRecorderRequest
    // TagResourceRequest
    // UntagResourceRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
