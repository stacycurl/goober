package goober.hi

import goober.free.kinesis.KinesisIO
import software.amazon.awssdk.services.kinesis.model._


object kinesis {
  import goober.free.{kinesis ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AddTagsToStreamRequest
    // CreateStreamRequest
    // DecreaseStreamRetentionPeriodRequest
    // DeleteStreamRequest
    // DeregisterStreamConsumerRequest
    // DescribeLimitsRequest
    // DescribeStreamRequest
    // DescribeStreamConsumerRequest
    // DescribeStreamSummaryRequest
    // DisableEnhancedMonitoringRequest
    // EnableEnhancedMonitoringRequest
    // GetRecordsRequest
    // GetShardIteratorRequest
    // IncreaseStreamRetentionPeriodRequest
    // ListShardsRequest
    // ListStreamConsumersRequest
    // ListStreamsRequest
    // ListTagsForStreamRequest
    // MergeShardsRequest
    // PutRecordRequest
    // PutRecordsRequest
    // RegisterStreamConsumerRequest
    // RemoveTagsFromStreamRequest
    // SplitShardRequest
    // StartStreamEncryptionRequest
    // StopStreamEncryptionRequest
    // UpdateShardCountRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
