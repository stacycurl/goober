package goober.hi

import goober.free.dynamodbstreams.DynamoDbStreamsIO
import software.amazon.awssdk.services.dynamodb.model._


object dynamodbstreams {
  import goober.free.{dynamodbstreams ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // DescribeStreamRequest
    // GetRecordsRequest
    // GetShardIteratorRequest
    // ListStreamsRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
