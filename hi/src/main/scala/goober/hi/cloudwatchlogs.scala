package goober.hi

import goober.free.cloudwatchlogs.CloudWatchLogsIO
import software.amazon.awssdk.services.cloudwatchlogs.model._


object cloudwatchlogs {
  import goober.free.{cloudwatchlogs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AssociateKmsKeyRequest
    // CancelExportTaskRequest
    // CreateExportTaskRequest
    // CreateLogGroupRequest
    // CreateLogStreamRequest
    // DeleteDestinationRequest
    // DeleteLogGroupRequest
    // DeleteLogStreamRequest
    // DeleteMetricFilterRequest
    // DeleteQueryDefinitionRequest
    // DeleteResourcePolicyRequest
    // DeleteRetentionPolicyRequest
    // DeleteSubscriptionFilterRequest
    // DescribeDestinationsRequest
    // DescribeExportTasksRequest
    // DescribeLogGroupsRequest
    // DescribeLogStreamsRequest
    // DescribeMetricFiltersRequest
    // DescribeQueriesRequest
    // DescribeQueryDefinitionsRequest
    // DescribeResourcePoliciesRequest
    // DescribeSubscriptionFiltersRequest
    // DisassociateKmsKeyRequest
    // FilterLogEventsRequest
    // GetLogEventsRequest
    // GetLogGroupFieldsRequest
    // GetLogRecordRequest
    // GetQueryResultsRequest
    // ListTagsLogGroupRequest
    // PutDestinationRequest
    // PutDestinationPolicyRequest
    // PutLogEventsRequest
    // PutMetricFilterRequest
    // PutQueryDefinitionRequest
    // PutResourcePolicyRequest
    // PutRetentionPolicyRequest
    // PutSubscriptionFilterRequest
    // StartQueryRequest
    // StopQueryRequest
    // TagLogGroupRequest
    // TestMetricFilterRequest
    // UntagLogGroupRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
