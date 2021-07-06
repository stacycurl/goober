package goober.hi

import goober.free.sqs.SqsIO
import software.amazon.awssdk.services.sqs.model._


object sqs {
  import goober.free.{sqs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AddPermissionRequest
    // ChangeMessageVisibilityBatchRequest
    // ChangeMessageVisibilityRequest
    // CreateQueueRequest
    // DeleteMessageBatchRequest
    // DeleteMessageRequest
    // DeleteQueueRequest
    // GetQueueAttributesRequest
    // GetQueueUrlRequest
    // ListDeadLetterSourceQueuesRequest
    // ListQueueTagsRequest
    // ListQueuesRequest
    // PurgeQueueRequest
    // ReceiveMessageRequest
    // RemovePermissionRequest
    // SendMessageBatchRequest
    // SendMessageRequest
    // SetQueueAttributesRequest
    // TagQueueRequest
    // UntagQueueRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
