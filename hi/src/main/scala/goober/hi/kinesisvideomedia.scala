package goober.hi

import goober.free.kinesisvideomedia.KinesisVideoMediaIO
import software.amazon.awssdk.services.kinesisvideomedia.model._


object kinesisvideomedia {
  import goober.free.{kinesisvideomedia ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def clientLimitExceededException(
      message: Option[String] = None
    ): ClientLimitExceededException =
      ClientLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def connectionLimitExceededException(
      message: Option[String] = None
    ): ConnectionLimitExceededException =
      ConnectionLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getMediaInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      startSelector: Option[StartSelector] = None
    ): GetMediaInput =
      GetMediaInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(startSelector)(_.startSelector(_))
        .build

    def getMediaOutput(
      contentType: Option[String] = None,
      payload: Option[Payload] = None
    ): GetMediaOutput =
      GetMediaOutput
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(payload)(_.payload(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidEndpointException(
      message: Option[String] = None
    ): InvalidEndpointException =
      InvalidEndpointException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startSelector(
      startSelectorType: Option[String] = None,
      afterFragmentNumber: Option[String] = None,
      startTimestamp: Option[Timestamp] = None,
      continuationToken: Option[String] = None
    ): StartSelector =
      StartSelector
        .builder
        .ifSome(startSelectorType)(_.startSelectorType(_))
        .ifSome(afterFragmentNumber)(_.afterFragmentNumber(_))
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
