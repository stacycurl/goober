package goober.hi

import goober.free.sqs.SqsIO
import software.amazon.awssdk.services.sqs.model._


object sqs {
  import goober.free.{sqs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addPermissionRequest(
      queueUrl: Option[String] = None,
      label: Option[String] = None,
      aWSAccountIds: Option[List[String]] = None,
      actions: Option[List[String]] = None
    ): AddPermissionRequest =
      AddPermissionRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(label)(_.label(_))
        .ifSome(aWSAccountIds)(_.aWSAccountIds(_))
        .ifSome(actions)(_.actions(_))
        .build

    def batchEntryIdsNotDistinct(

    ): BatchEntryIdsNotDistinct =
      BatchEntryIdsNotDistinct
        .builder

        .build

    def batchRequestTooLong(

    ): BatchRequestTooLong =
      BatchRequestTooLong
        .builder

        .build

    def batchResultErrorEntry(
      id: Option[String] = None,
      senderFault: Option[Boolean] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): BatchResultErrorEntry =
      BatchResultErrorEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(senderFault)(_.senderFault(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def changeMessageVisibilityBatchRequest(
      queueUrl: Option[String] = None,
      entries: Option[List[ChangeMessageVisibilityBatchRequestEntry]] = None
    ): ChangeMessageVisibilityBatchRequest =
      ChangeMessageVisibilityBatchRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(entries)(_.entries(_))
        .build

    def changeMessageVisibilityBatchRequestEntry(
      id: Option[String] = None,
      receiptHandle: Option[String] = None,
      visibilityTimeout: Option[Int] = None
    ): ChangeMessageVisibilityBatchRequestEntry =
      ChangeMessageVisibilityBatchRequestEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(receiptHandle)(_.receiptHandle(_))
        .ifSome(visibilityTimeout)(_.visibilityTimeout(_))
        .build

    def changeMessageVisibilityBatchResultEntry(
      id: Option[String] = None
    ): ChangeMessageVisibilityBatchResultEntry =
      ChangeMessageVisibilityBatchResultEntry
        .builder
        .ifSome(id)(_.id(_))
        .build

    def changeMessageVisibilityRequest(
      queueUrl: Option[String] = None,
      receiptHandle: Option[String] = None,
      visibilityTimeout: Option[Int] = None
    ): ChangeMessageVisibilityRequest =
      ChangeMessageVisibilityRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(receiptHandle)(_.receiptHandle(_))
        .ifSome(visibilityTimeout)(_.visibilityTimeout(_))
        .build

    def createQueueRequest(
      queueName: Option[String] = None,
      attributes: Option[QueueAttributeMap] = None,
      tags: Option[TagMap] = None
    ): CreateQueueRequest =
      CreateQueueRequest
        .builder
        .ifSome(queueName)(_.queueName(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteMessageBatchRequest(
      queueUrl: Option[String] = None,
      entries: Option[List[DeleteMessageBatchRequestEntry]] = None
    ): DeleteMessageBatchRequest =
      DeleteMessageBatchRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(entries)(_.entries(_))
        .build

    def deleteMessageBatchRequestEntry(
      id: Option[String] = None,
      receiptHandle: Option[String] = None
    ): DeleteMessageBatchRequestEntry =
      DeleteMessageBatchRequestEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(receiptHandle)(_.receiptHandle(_))
        .build

    def deleteMessageBatchResultEntry(
      id: Option[String] = None
    ): DeleteMessageBatchResultEntry =
      DeleteMessageBatchResultEntry
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteMessageRequest(
      queueUrl: Option[String] = None,
      receiptHandle: Option[String] = None
    ): DeleteMessageRequest =
      DeleteMessageRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(receiptHandle)(_.receiptHandle(_))
        .build

    def deleteQueueRequest(
      queueUrl: Option[String] = None
    ): DeleteQueueRequest =
      DeleteQueueRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .build

    def emptyBatchRequest(

    ): EmptyBatchRequest =
      EmptyBatchRequest
        .builder

        .build

    def getQueueAttributesRequest(
      queueUrl: Option[String] = None,
      attributeNames: Option[List[QueueAttributeName]] = None
    ): GetQueueAttributesRequest =
      GetQueueAttributesRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def getQueueUrlRequest(
      queueName: Option[String] = None,
      queueOwnerAWSAccountId: Option[String] = None
    ): GetQueueUrlRequest =
      GetQueueUrlRequest
        .builder
        .ifSome(queueName)(_.queueName(_))
        .ifSome(queueOwnerAWSAccountId)(_.queueOwnerAWSAccountId(_))
        .build

    def invalidAttributeName(

    ): InvalidAttributeName =
      InvalidAttributeName
        .builder

        .build

    def invalidBatchEntryId(

    ): InvalidBatchEntryId =
      InvalidBatchEntryId
        .builder

        .build

    def invalidIdFormat(

    ): InvalidIdFormat =
      InvalidIdFormat
        .builder

        .build

    def invalidMessageContents(

    ): InvalidMessageContents =
      InvalidMessageContents
        .builder

        .build

    def listDeadLetterSourceQueuesRequest(
      queueUrl: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDeadLetterSourceQueuesRequest =
      ListDeadLetterSourceQueuesRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listQueueTagsRequest(
      queueUrl: Option[String] = None
    ): ListQueueTagsRequest =
      ListQueueTagsRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .build

    def listQueuesRequest(
      queueNamePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListQueuesRequest =
      ListQueuesRequest
        .builder
        .ifSome(queueNamePrefix)(_.queueNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def message(
      messageId: Option[String] = None,
      receiptHandle: Option[String] = None,
      mD5OfBody: Option[String] = None,
      body: Option[String] = None,
      attributes: Option[MessageSystemAttributeMap] = None,
      mD5OfMessageAttributes: Option[String] = None,
      messageAttributes: Option[MessageBodyAttributeMap] = None
    ): Message =
      Message
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(receiptHandle)(_.receiptHandle(_))
        .ifSome(mD5OfBody)(_.mD5OfBody(_))
        .ifSome(body)(_.body(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(mD5OfMessageAttributes)(_.mD5OfMessageAttributes(_))
        .ifSome(messageAttributes)(_.messageAttributes(_))
        .build

    def messageAttributeValue(
      stringValue: Option[String] = None,
      binaryValue: Option[Binary] = None,
      stringListValues: Option[List[String]] = None,
      binaryListValues: Option[List[Binary]] = None,
      dataType: Option[String] = None
    ): MessageAttributeValue =
      MessageAttributeValue
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(binaryValue)(_.binaryValue(_))
        .ifSome(stringListValues)(_.stringListValues(_))
        .ifSome(binaryListValues)(_.binaryListValues(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def messageNotInflight(

    ): MessageNotInflight =
      MessageNotInflight
        .builder

        .build

    def messageSystemAttributeValue(
      stringValue: Option[String] = None,
      binaryValue: Option[Binary] = None,
      stringListValues: Option[List[String]] = None,
      binaryListValues: Option[List[Binary]] = None,
      dataType: Option[String] = None
    ): MessageSystemAttributeValue =
      MessageSystemAttributeValue
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(binaryValue)(_.binaryValue(_))
        .ifSome(stringListValues)(_.stringListValues(_))
        .ifSome(binaryListValues)(_.binaryListValues(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def overLimit(

    ): OverLimit =
      OverLimit
        .builder

        .build

    def purgeQueueInProgress(

    ): PurgeQueueInProgress =
      PurgeQueueInProgress
        .builder

        .build

    def purgeQueueRequest(
      queueUrl: Option[String] = None
    ): PurgeQueueRequest =
      PurgeQueueRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .build

    def queueDeletedRecently(

    ): QueueDeletedRecently =
      QueueDeletedRecently
        .builder

        .build

    def queueDoesNotExist(

    ): QueueDoesNotExist =
      QueueDoesNotExist
        .builder

        .build

    def queueNameExists(

    ): QueueNameExists =
      QueueNameExists
        .builder

        .build

    def receiptHandleIsInvalid(

    ): ReceiptHandleIsInvalid =
      ReceiptHandleIsInvalid
        .builder

        .build

    def receiveMessageRequest(
      queueUrl: Option[String] = None,
      attributeNames: Option[List[QueueAttributeName]] = None,
      messageAttributeNames: Option[List[MessageAttributeName]] = None,
      maxNumberOfMessages: Option[Int] = None,
      visibilityTimeout: Option[Int] = None,
      waitTimeSeconds: Option[Int] = None,
      receiveRequestAttemptId: Option[String] = None
    ): ReceiveMessageRequest =
      ReceiveMessageRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .ifSome(messageAttributeNames)(_.messageAttributeNames(_))
        .ifSome(maxNumberOfMessages)(_.maxNumberOfMessages(_))
        .ifSome(visibilityTimeout)(_.visibilityTimeout(_))
        .ifSome(waitTimeSeconds)(_.waitTimeSeconds(_))
        .ifSome(receiveRequestAttemptId)(_.receiveRequestAttemptId(_))
        .build

    def removePermissionRequest(
      queueUrl: Option[String] = None,
      label: Option[String] = None
    ): RemovePermissionRequest =
      RemovePermissionRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(label)(_.label(_))
        .build

    def sendMessageBatchRequest(
      queueUrl: Option[String] = None,
      entries: Option[List[SendMessageBatchRequestEntry]] = None
    ): SendMessageBatchRequest =
      SendMessageBatchRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(entries)(_.entries(_))
        .build

    def sendMessageBatchRequestEntry(
      id: Option[String] = None,
      messageBody: Option[String] = None,
      delaySeconds: Option[Int] = None,
      messageAttributes: Option[MessageBodyAttributeMap] = None,
      messageSystemAttributes: Option[MessageBodySystemAttributeMap] = None,
      messageDeduplicationId: Option[String] = None,
      messageGroupId: Option[String] = None
    ): SendMessageBatchRequestEntry =
      SendMessageBatchRequestEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(messageBody)(_.messageBody(_))
        .ifSome(delaySeconds)(_.delaySeconds(_))
        .ifSome(messageAttributes)(_.messageAttributes(_))
        .ifSome(messageSystemAttributes)(_.messageSystemAttributes(_))
        .ifSome(messageDeduplicationId)(_.messageDeduplicationId(_))
        .ifSome(messageGroupId)(_.messageGroupId(_))
        .build

    def sendMessageBatchResultEntry(
      id: Option[String] = None,
      messageId: Option[String] = None,
      mD5OfMessageBody: Option[String] = None,
      mD5OfMessageAttributes: Option[String] = None,
      mD5OfMessageSystemAttributes: Option[String] = None,
      sequenceNumber: Option[String] = None
    ): SendMessageBatchResultEntry =
      SendMessageBatchResultEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(messageId)(_.messageId(_))
        .ifSome(mD5OfMessageBody)(_.mD5OfMessageBody(_))
        .ifSome(mD5OfMessageAttributes)(_.mD5OfMessageAttributes(_))
        .ifSome(mD5OfMessageSystemAttributes)(_.mD5OfMessageSystemAttributes(_))
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .build

    def sendMessageRequest(
      queueUrl: Option[String] = None,
      messageBody: Option[String] = None,
      delaySeconds: Option[Int] = None,
      messageAttributes: Option[MessageBodyAttributeMap] = None,
      messageSystemAttributes: Option[MessageBodySystemAttributeMap] = None,
      messageDeduplicationId: Option[String] = None,
      messageGroupId: Option[String] = None
    ): SendMessageRequest =
      SendMessageRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(messageBody)(_.messageBody(_))
        .ifSome(delaySeconds)(_.delaySeconds(_))
        .ifSome(messageAttributes)(_.messageAttributes(_))
        .ifSome(messageSystemAttributes)(_.messageSystemAttributes(_))
        .ifSome(messageDeduplicationId)(_.messageDeduplicationId(_))
        .ifSome(messageGroupId)(_.messageGroupId(_))
        .build

    def setQueueAttributesRequest(
      queueUrl: Option[String] = None,
      attributes: Option[QueueAttributeMap] = None
    ): SetQueueAttributesRequest =
      SetQueueAttributesRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def tagQueueRequest(
      queueUrl: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagQueueRequest =
      TagQueueRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tooManyEntriesInBatchRequest(

    ): TooManyEntriesInBatchRequest =
      TooManyEntriesInBatchRequest
        .builder

        .build

    def unsupportedOperation(

    ): UnsupportedOperation =
      UnsupportedOperation
        .builder

        .build

    def untagQueueRequest(
      queueUrl: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagQueueRequest =
      UntagQueueRequest
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
