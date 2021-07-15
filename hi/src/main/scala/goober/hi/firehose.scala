package goober.hi

import goober.free.firehose.FirehoseIO
import software.amazon.awssdk.services.firehose.model._


object firehose {
  import goober.free.{firehose ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CreateDeliveryStreamRequest
    // DeleteDeliveryStreamRequest
    // DescribeDeliveryStreamRequest
    // ListDeliveryStreamsRequest
    // ListTagsForDeliveryStreamRequest
    // PutRecordRequest
    // PutRecordBatchRequest
    // StartDeliveryStreamEncryptionRequest
    // StopDeliveryStreamEncryptionRequest
    // TagDeliveryStreamRequest
    // UntagDeliveryStreamRequest
    // UpdateDestinationRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
