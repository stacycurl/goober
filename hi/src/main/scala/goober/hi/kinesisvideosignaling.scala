package goober.hi

import goober.free.kinesisvideosignaling.KinesisVideoSignalingIO
import software.amazon.awssdk.services.kinesisvideosignaling.model._


object kinesisvideosignaling {
  import goober.free.{kinesisvideosignaling ⇒ free}

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

    def getIceServerConfigRequest(
      channelARN: Option[String] = None,
      clientId: Option[String] = None,
      service: Option[String] = None,
      username: Option[String] = None
    ): GetIceServerConfigRequest =
      GetIceServerConfigRequest
        .builder
        .ifSome(channelARN)(_.channelARN(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(service)(_.service(_))
        .ifSome(username)(_.username(_))
        .build

    def getIceServerConfigResponse(
      iceServerList: Option[List[IceServer]] = None
    ): GetIceServerConfigResponse =
      GetIceServerConfigResponse
        .builder
        .ifSome(iceServerList)(_.iceServerList(_))
        .build

    def iceServer(
      uris: Option[List[Uri]] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      ttl: Option[Int] = None
    ): IceServer =
      IceServer
        .builder
        .ifSome(uris)(_.uris(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(ttl)(_.ttl(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidClientException(
      message: Option[String] = None
    ): InvalidClientException =
      InvalidClientException
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

    def sendAlexaOfferToMasterRequest(
      channelARN: Option[String] = None,
      senderClientId: Option[String] = None,
      messagePayload: Option[String] = None
    ): SendAlexaOfferToMasterRequest =
      SendAlexaOfferToMasterRequest
        .builder
        .ifSome(channelARN)(_.channelARN(_))
        .ifSome(senderClientId)(_.senderClientId(_))
        .ifSome(messagePayload)(_.messagePayload(_))
        .build

    def sendAlexaOfferToMasterResponse(
      answer: Option[String] = None
    ): SendAlexaOfferToMasterResponse =
      SendAlexaOfferToMasterResponse
        .builder
        .ifSome(answer)(_.answer(_))
        .build

    def sessionExpiredException(
      message: Option[String] = None
    ): SessionExpiredException =
      SessionExpiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
