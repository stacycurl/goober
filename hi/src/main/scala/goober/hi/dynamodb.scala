package goober.hi

import goober.free.dynamodb.DynamoDbIO
import software.amazon.awssdk.services.dynamodb.model._


object dynamodb {
  import goober.free.{dynamodb ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // BatchExecuteStatementRequest
    // BatchGetItemRequest
    // BatchWriteItemRequest
    // CreateBackupRequest
    // CreateGlobalTableRequest
    // CreateTableRequest
    // DeleteBackupRequest
    // DeleteItemRequest
    // DeleteTableRequest
    // DescribeBackupRequest
    // DescribeContinuousBackupsRequest
    // DescribeContributorInsightsRequest
    // DescribeEndpointsRequest
    // DescribeExportRequest
    // DescribeGlobalTableRequest
    // DescribeGlobalTableSettingsRequest
    // DescribeKinesisStreamingDestinationRequest
    // DescribeLimitsRequest
    // DescribeTableReplicaAutoScalingRequest
    // DescribeTableRequest
    // DescribeTimeToLiveRequest
    // DisableKinesisStreamingDestinationRequest
    // EnableKinesisStreamingDestinationRequest
    // ExecuteStatementRequest
    // ExecuteTransactionRequest
    // ExportTableToPointInTimeRequest
    // GetItemRequest
    // ListBackupsRequest
    // ListContributorInsightsRequest
    // ListExportsRequest
    // ListGlobalTablesRequest
    // ListTablesRequest
    // ListTagsOfResourceRequest
    // PutItemRequest
    // QueryRequest
    // RestoreTableFromBackupRequest
    // RestoreTableToPointInTimeRequest
    // ScanRequest
    // TagResourceRequest
    // TransactGetItemsRequest
    // TransactWriteItemsRequest
    // UntagResourceRequest
    // UpdateContinuousBackupsRequest
    // UpdateContributorInsightsRequest
    // UpdateGlobalTableRequest
    // UpdateGlobalTableSettingsRequest
    // UpdateItemRequest
    // UpdateTableReplicaAutoScalingRequest
    // UpdateTableRequest
    // UpdateTimeToLiveRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
