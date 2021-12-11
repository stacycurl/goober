package goober.hi

import goober.free.workmailmessageflow.WorkMailMessageFlowIO
import software.amazon.awssdk.services.workmailmessageflow.model._


object workmailmessageflow {
  import goober.free.{workmailmessageflow ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def getRawMessageContentRequest(
      messageId: Option[String] = None
    ): GetRawMessageContentRequest =
      GetRawMessageContentRequest
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def getRawMessageContentResponse(
      messageContent: Option[messageContentBlob] = None
    ): GetRawMessageContentResponse =
      GetRawMessageContentResponse
        .builder
        .ifSome(messageContent)(_.messageContent(_))
        .build

    def invalidContentLocation(
      message: Option[String] = None
    ): InvalidContentLocation =
      InvalidContentLocation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def messageFrozen(
      message: Option[String] = None
    ): MessageFrozen =
      MessageFrozen
        .builder
        .ifSome(message)(_.message(_))
        .build

    def messageRejected(
      message: Option[String] = None
    ): MessageRejected =
      MessageRejected
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putRawMessageContentRequest(
      messageId: Option[String] = None,
      content: Option[RawMessageContent] = None
    ): PutRawMessageContentRequest =
      PutRawMessageContentRequest
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(content)(_.content(_))
        .build

    def putRawMessageContentResponse(

    ): PutRawMessageContentResponse =
      PutRawMessageContentResponse
        .builder

        .build

    def rawMessageContent(
      s3Reference: Option[S3Reference] = None
    ): RawMessageContent =
      RawMessageContent
        .builder
        .ifSome(s3Reference)(_.s3Reference(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3Reference(
      bucket: Option[String] = None,
      key: Option[String] = None,
      objectVersion: Option[String] = None
    ): S3Reference =
      S3Reference
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(objectVersion)(_.objectVersion(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
