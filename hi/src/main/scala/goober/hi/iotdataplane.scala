package goober.hi

import goober.free.iotdataplane.IotDataPlaneIO
import software.amazon.awssdk.services.iotdataplane.model._


object iotdataplane {
  import goober.free.{iotdataplane ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteThingShadowRequest(
      thingName: Option[String] = None,
      shadowName: Option[String] = None
    ): DeleteThingShadowRequest =
      DeleteThingShadowRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(shadowName)(_.shadowName(_))
        .build

    def deleteThingShadowResponse(
      payload: Option[JsonDocument] = None
    ): DeleteThingShadowResponse =
      DeleteThingShadowResponse
        .builder
        .ifSome(payload)(_.payload(_))
        .build

    def getThingShadowRequest(
      thingName: Option[String] = None,
      shadowName: Option[String] = None
    ): GetThingShadowRequest =
      GetThingShadowRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(shadowName)(_.shadowName(_))
        .build

    def getThingShadowResponse(
      payload: Option[JsonDocument] = None
    ): GetThingShadowResponse =
      GetThingShadowResponse
        .builder
        .ifSome(payload)(_.payload(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listNamedShadowsForThingRequest(
      thingName: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListNamedShadowsForThingRequest =
      ListNamedShadowsForThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listNamedShadowsForThingResponse(
      results: Option[List[ShadowName]] = None,
      nextToken: Option[String] = None,
      timestamp: Option[Timestamp] = None
    ): ListNamedShadowsForThingResponse =
      ListNamedShadowsForThingResponse
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def methodNotAllowedException(
      message: Option[String] = None
    ): MethodNotAllowedException =
      MethodNotAllowedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def publishRequest(
      topic: Option[String] = None,
      qos: Option[Int] = None,
      payload: Option[Payload] = None
    ): PublishRequest =
      PublishRequest
        .builder
        .ifSome(topic)(_.topic(_))
        .ifSome(qos)(_.qos(_))
        .ifSome(payload)(_.payload(_))
        .build

    def requestEntityTooLargeException(
      message: Option[String] = None
    ): RequestEntityTooLargeException =
      RequestEntityTooLargeException
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

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedDocumentEncodingException(
      message: Option[String] = None
    ): UnsupportedDocumentEncodingException =
      UnsupportedDocumentEncodingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateThingShadowRequest(
      thingName: Option[String] = None,
      shadowName: Option[String] = None,
      payload: Option[JsonDocument] = None
    ): UpdateThingShadowRequest =
      UpdateThingShadowRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(shadowName)(_.shadowName(_))
        .ifSome(payload)(_.payload(_))
        .build

    def updateThingShadowResponse(
      payload: Option[JsonDocument] = None
    ): UpdateThingShadowResponse =
      UpdateThingShadowResponse
        .builder
        .ifSome(payload)(_.payload(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
