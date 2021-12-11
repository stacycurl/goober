package goober.hi

import goober.free.lexruntime.LexRuntimeIO
import software.amazon.awssdk.services.lexruntime.model._


object lexruntime {
  import goober.free.{lexruntime ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activeContext(
      name: Option[String] = None,
      timeToLive: Option[ActiveContextTimeToLive] = None,
      parameters: Option[ActiveContextParametersMap] = None
    ): ActiveContext =
      ActiveContext
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(timeToLive)(_.timeToLive(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def activeContextTimeToLive(
      timeToLiveInSeconds: Option[Int] = None,
      turnsToLive: Option[Int] = None
    ): ActiveContextTimeToLive =
      ActiveContextTimeToLive
        .builder
        .ifSome(timeToLiveInSeconds)(_.timeToLiveInSeconds(_))
        .ifSome(turnsToLive)(_.turnsToLive(_))
        .build

    def badGatewayException(
      message: Option[String] = None
    ): BadGatewayException =
      BadGatewayException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def button(
      text: Option[String] = None,
      value: Option[String] = None
    ): Button =
      Button
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(value)(_.value(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteSessionRequest(
      botName: Option[String] = None,
      botAlias: Option[String] = None,
      userId: Option[String] = None
    ): DeleteSessionRequest =
      DeleteSessionRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(userId)(_.userId(_))
        .build

    def deleteSessionResponse(
      botName: Option[String] = None,
      botAlias: Option[String] = None,
      userId: Option[String] = None,
      sessionId: Option[String] = None
    ): DeleteSessionResponse =
      DeleteSessionResponse
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def dependencyFailedException(
      message: Option[String] = None
    ): DependencyFailedException =
      DependencyFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dialogAction(
      `type`: Option[String] = None,
      intentName: Option[String] = None,
      slots: Option[StringMap] = None,
      slotToElicit: Option[String] = None,
      fulfillmentState: Option[String] = None,
      message: Option[String] = None,
      messageFormat: Option[String] = None
    ): DialogAction =
      DialogAction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(slotToElicit)(_.slotToElicit(_))
        .ifSome(fulfillmentState)(_.fulfillmentState(_))
        .ifSome(message)(_.message(_))
        .ifSome(messageFormat)(_.messageFormat(_))
        .build

    def genericAttachment(
      title: Option[String] = None,
      subTitle: Option[String] = None,
      attachmentLinkUrl: Option[String] = None,
      imageUrl: Option[String] = None,
      buttons: Option[List[Button]] = None
    ): GenericAttachment =
      GenericAttachment
        .builder
        .ifSome(title)(_.title(_))
        .ifSome(subTitle)(_.subTitle(_))
        .ifSome(attachmentLinkUrl)(_.attachmentLinkUrl(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(buttons)(_.buttons(_))
        .build

    def getSessionRequest(
      botName: Option[String] = None,
      botAlias: Option[String] = None,
      userId: Option[String] = None,
      checkpointLabelFilter: Option[String] = None
    ): GetSessionRequest =
      GetSessionRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(checkpointLabelFilter)(_.checkpointLabelFilter(_))
        .build

    def getSessionResponse(
      recentIntentSummaryView: Option[List[IntentSummary]] = None,
      sessionAttributes: Option[StringMap] = None,
      sessionId: Option[String] = None,
      dialogAction: Option[DialogAction] = None,
      activeContexts: Option[List[ActiveContext]] = None
    ): GetSessionResponse =
      GetSessionResponse
        .builder
        .ifSome(recentIntentSummaryView)(_.recentIntentSummaryView(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(dialogAction)(_.dialogAction(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .build

    def intentConfidence(
      score: Option[Double] = None
    ): IntentConfidence =
      IntentConfidence
        .builder
        .ifSome(score)(_.score(_))
        .build

    def intentSummary(
      intentName: Option[String] = None,
      checkpointLabel: Option[String] = None,
      slots: Option[StringMap] = None,
      confirmationStatus: Option[String] = None,
      dialogActionType: Option[String] = None,
      fulfillmentState: Option[String] = None,
      slotToElicit: Option[String] = None
    ): IntentSummary =
      IntentSummary
        .builder
        .ifSome(intentName)(_.intentName(_))
        .ifSome(checkpointLabel)(_.checkpointLabel(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(confirmationStatus)(_.confirmationStatus(_))
        .ifSome(dialogActionType)(_.dialogActionType(_))
        .ifSome(fulfillmentState)(_.fulfillmentState(_))
        .ifSome(slotToElicit)(_.slotToElicit(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      retryAfterSeconds: Option[String] = None,
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def loopDetectedException(
      message: Option[String] = None
    ): LoopDetectedException =
      LoopDetectedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notAcceptableException(
      message: Option[String] = None
    ): NotAcceptableException =
      NotAcceptableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def postContentRequest(
      botName: Option[String] = None,
      botAlias: Option[String] = None,
      userId: Option[String] = None,
      sessionAttributes: Option[String] = None,
      requestAttributes: Option[String] = None,
      contentType: Option[String] = None,
      accept: Option[String] = None,
      inputStream: Option[BlobStream] = None,
      activeContexts: Option[String] = None
    ): PostContentRequest =
      PostContentRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(accept)(_.accept(_))
        .ifSome(inputStream)(_.inputStream(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .build

    def postContentResponse(
      contentType: Option[String] = None,
      intentName: Option[String] = None,
      nluIntentConfidence: Option[String] = None,
      alternativeIntents: Option[String] = None,
      slots: Option[String] = None,
      sessionAttributes: Option[String] = None,
      sentimentResponse: Option[String] = None,
      message: Option[String] = None,
      encodedMessage: Option[String] = None,
      messageFormat: Option[String] = None,
      dialogState: Option[String] = None,
      slotToElicit: Option[String] = None,
      inputTranscript: Option[String] = None,
      encodedInputTranscript: Option[String] = None,
      audioStream: Option[BlobStream] = None,
      botVersion: Option[String] = None,
      sessionId: Option[String] = None,
      activeContexts: Option[String] = None
    ): PostContentResponse =
      PostContentResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(nluIntentConfidence)(_.nluIntentConfidence(_))
        .ifSome(alternativeIntents)(_.alternativeIntents(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(sentimentResponse)(_.sentimentResponse(_))
        .ifSome(message)(_.message(_))
        .ifSome(encodedMessage)(_.encodedMessage(_))
        .ifSome(messageFormat)(_.messageFormat(_))
        .ifSome(dialogState)(_.dialogState(_))
        .ifSome(slotToElicit)(_.slotToElicit(_))
        .ifSome(inputTranscript)(_.inputTranscript(_))
        .ifSome(encodedInputTranscript)(_.encodedInputTranscript(_))
        .ifSome(audioStream)(_.audioStream(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .build

    def postTextRequest(
      botName: Option[String] = None,
      botAlias: Option[String] = None,
      userId: Option[String] = None,
      sessionAttributes: Option[StringMap] = None,
      requestAttributes: Option[StringMap] = None,
      inputText: Option[String] = None,
      activeContexts: Option[List[ActiveContext]] = None
    ): PostTextRequest =
      PostTextRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(inputText)(_.inputText(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .build

    def postTextResponse(
      intentName: Option[String] = None,
      nluIntentConfidence: Option[IntentConfidence] = None,
      alternativeIntents: Option[List[PredictedIntent]] = None,
      slots: Option[StringMap] = None,
      sessionAttributes: Option[StringMap] = None,
      message: Option[String] = None,
      sentimentResponse: Option[SentimentResponse] = None,
      messageFormat: Option[String] = None,
      dialogState: Option[String] = None,
      slotToElicit: Option[String] = None,
      responseCard: Option[ResponseCard] = None,
      sessionId: Option[String] = None,
      botVersion: Option[String] = None,
      activeContexts: Option[List[ActiveContext]] = None
    ): PostTextResponse =
      PostTextResponse
        .builder
        .ifSome(intentName)(_.intentName(_))
        .ifSome(nluIntentConfidence)(_.nluIntentConfidence(_))
        .ifSome(alternativeIntents)(_.alternativeIntents(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(message)(_.message(_))
        .ifSome(sentimentResponse)(_.sentimentResponse(_))
        .ifSome(messageFormat)(_.messageFormat(_))
        .ifSome(dialogState)(_.dialogState(_))
        .ifSome(slotToElicit)(_.slotToElicit(_))
        .ifSome(responseCard)(_.responseCard(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .build

    def predictedIntent(
      intentName: Option[String] = None,
      nluIntentConfidence: Option[IntentConfidence] = None,
      slots: Option[StringMap] = None
    ): PredictedIntent =
      PredictedIntent
        .builder
        .ifSome(intentName)(_.intentName(_))
        .ifSome(nluIntentConfidence)(_.nluIntentConfidence(_))
        .ifSome(slots)(_.slots(_))
        .build

    def putSessionRequest(
      botName: Option[String] = None,
      botAlias: Option[String] = None,
      userId: Option[String] = None,
      sessionAttributes: Option[StringMap] = None,
      dialogAction: Option[DialogAction] = None,
      recentIntentSummaryView: Option[List[IntentSummary]] = None,
      accept: Option[String] = None,
      activeContexts: Option[List[ActiveContext]] = None
    ): PutSessionRequest =
      PutSessionRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(dialogAction)(_.dialogAction(_))
        .ifSome(recentIntentSummaryView)(_.recentIntentSummaryView(_))
        .ifSome(accept)(_.accept(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .build

    def putSessionResponse(
      contentType: Option[String] = None,
      intentName: Option[String] = None,
      slots: Option[String] = None,
      sessionAttributes: Option[String] = None,
      message: Option[String] = None,
      encodedMessage: Option[String] = None,
      messageFormat: Option[String] = None,
      dialogState: Option[String] = None,
      slotToElicit: Option[String] = None,
      audioStream: Option[BlobStream] = None,
      sessionId: Option[String] = None,
      activeContexts: Option[String] = None
    ): PutSessionResponse =
      PutSessionResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(message)(_.message(_))
        .ifSome(encodedMessage)(_.encodedMessage(_))
        .ifSome(messageFormat)(_.messageFormat(_))
        .ifSome(dialogState)(_.dialogState(_))
        .ifSome(slotToElicit)(_.slotToElicit(_))
        .ifSome(audioStream)(_.audioStream(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .build

    def requestTimeoutException(
      message: Option[String] = None
    ): RequestTimeoutException =
      RequestTimeoutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def responseCard(
      version: Option[String] = None,
      contentType: Option[String] = None,
      genericAttachments: Option[List[GenericAttachment]] = None
    ): ResponseCard =
      ResponseCard
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(genericAttachments)(_.genericAttachments(_))
        .build

    def sentimentResponse(
      sentimentLabel: Option[String] = None,
      sentimentScore: Option[String] = None
    ): SentimentResponse =
      SentimentResponse
        .builder
        .ifSome(sentimentLabel)(_.sentimentLabel(_))
        .ifSome(sentimentScore)(_.sentimentScore(_))
        .build

    def unsupportedMediaTypeException(
      message: Option[String] = None
    ): UnsupportedMediaTypeException =
      UnsupportedMediaTypeException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
