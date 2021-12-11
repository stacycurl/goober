package goober.hi

import goober.free.lexruntimev2.LexRuntimeV2IO
import software.amazon.awssdk.services.lexruntimev2.model._


object lexruntimev2 {
  import goober.free.{lexruntimev2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def activeContext(
      name: Option[String] = None,
      timeToLive: Option[ActiveContextTimeToLive] = None,
      contextAttributes: Option[ActiveContextParametersMap] = None
    ): ActiveContext =
      ActiveContext
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(timeToLive)(_.timeToLive(_))
        .ifSome(contextAttributes)(_.contextAttributes(_))
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

    def audioInputEvent(
      audioChunk: Option[AudioChunk] = None,
      contentType: Option[String] = None,
      eventId: Option[String] = None,
      clientTimestampMillis: Option[EpochMillis] = None
    ): AudioInputEvent =
      AudioInputEvent
        .builder
        .ifSome(audioChunk)(_.audioChunk(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(clientTimestampMillis)(_.clientTimestampMillis(_))
        .build

    def audioResponseEvent(
      audioChunk: Option[AudioChunk] = None,
      contentType: Option[String] = None,
      eventId: Option[String] = None
    ): AudioResponseEvent =
      AudioResponseEvent
        .builder
        .ifSome(audioChunk)(_.audioChunk(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(eventId)(_.eventId(_))
        .build

    def badGatewayException(
      message: Option[String] = None
    ): BadGatewayException =
      BadGatewayException
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

    def confidenceScore(
      score: Option[Double] = None
    ): ConfidenceScore =
      ConfidenceScore
        .builder
        .ifSome(score)(_.score(_))
        .build

    def configurationEvent(
      requestAttributes: Option[StringMap] = None,
      responseContentType: Option[String] = None,
      sessionState: Option[SessionState] = None,
      welcomeMessages: Option[List[Message]] = None,
      disablePlayback: Option[Boolean] = None,
      eventId: Option[String] = None,
      clientTimestampMillis: Option[EpochMillis] = None
    ): ConfigurationEvent =
      ConfigurationEvent
        .builder
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(responseContentType)(_.responseContentType(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(welcomeMessages)(_.welcomeMessages(_))
        .ifSome(disablePlayback)(_.disablePlayback(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(clientTimestampMillis)(_.clientTimestampMillis(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dTMFInputEvent(
      inputCharacter: Option[String] = None,
      eventId: Option[String] = None,
      clientTimestampMillis: Option[EpochMillis] = None
    ): DTMFInputEvent =
      DTMFInputEvent
        .builder
        .ifSome(inputCharacter)(_.inputCharacter(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(clientTimestampMillis)(_.clientTimestampMillis(_))
        .build

    def deleteSessionRequest(
      botId: Option[String] = None,
      botAliasId: Option[String] = None,
      localeId: Option[String] = None,
      sessionId: Option[String] = None
    ): DeleteSessionRequest =
      DeleteSessionRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def deleteSessionResponse(
      botId: Option[String] = None,
      botAliasId: Option[String] = None,
      localeId: Option[String] = None,
      sessionId: Option[String] = None
    ): DeleteSessionResponse =
      DeleteSessionResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(localeId)(_.localeId(_))
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
      slotToElicit: Option[String] = None
    ): DialogAction =
      DialogAction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(slotToElicit)(_.slotToElicit(_))
        .build

    def disconnectionEvent(
      eventId: Option[String] = None,
      clientTimestampMillis: Option[EpochMillis] = None
    ): DisconnectionEvent =
      DisconnectionEvent
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(clientTimestampMillis)(_.clientTimestampMillis(_))
        .build

    def getSessionRequest(
      botId: Option[String] = None,
      botAliasId: Option[String] = None,
      localeId: Option[String] = None,
      sessionId: Option[String] = None
    ): GetSessionRequest =
      GetSessionRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def getSessionResponse(
      sessionId: Option[String] = None,
      messages: Option[List[Message]] = None,
      interpretations: Option[List[Interpretation]] = None,
      sessionState: Option[SessionState] = None
    ): GetSessionResponse =
      GetSessionResponse
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(messages)(_.messages(_))
        .ifSome(interpretations)(_.interpretations(_))
        .ifSome(sessionState)(_.sessionState(_))
        .build

    def heartbeatEvent(
      eventId: Option[String] = None
    ): HeartbeatEvent =
      HeartbeatEvent
        .builder
        .ifSome(eventId)(_.eventId(_))
        .build

    def imageResponseCard(
      title: Option[String] = None,
      subtitle: Option[String] = None,
      imageUrl: Option[String] = None,
      buttons: Option[List[Button]] = None
    ): ImageResponseCard =
      ImageResponseCard
        .builder
        .ifSome(title)(_.title(_))
        .ifSome(subtitle)(_.subtitle(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(buttons)(_.buttons(_))
        .build

    def intent(
      name: Option[String] = None,
      slots: Option[Slots] = None,
      state: Option[String] = None,
      confirmationState: Option[String] = None
    ): Intent =
      Intent
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(state)(_.state(_))
        .ifSome(confirmationState)(_.confirmationState(_))
        .build

    def intentResultEvent(
      inputMode: Option[String] = None,
      interpretations: Option[List[Interpretation]] = None,
      sessionState: Option[SessionState] = None,
      requestAttributes: Option[StringMap] = None,
      sessionId: Option[String] = None,
      eventId: Option[String] = None
    ): IntentResultEvent =
      IntentResultEvent
        .builder
        .ifSome(inputMode)(_.inputMode(_))
        .ifSome(interpretations)(_.interpretations(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(eventId)(_.eventId(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def interpretation(
      nluConfidence: Option[ConfidenceScore] = None,
      sentimentResponse: Option[SentimentResponse] = None,
      intent: Option[Intent] = None
    ): Interpretation =
      Interpretation
        .builder
        .ifSome(nluConfidence)(_.nluConfidence(_))
        .ifSome(sentimentResponse)(_.sentimentResponse(_))
        .ifSome(intent)(_.intent(_))
        .build

    def message(
      content: Option[String] = None,
      contentType: Option[String] = None,
      imageResponseCard: Option[ImageResponseCard] = None
    ): Message =
      Message
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(imageResponseCard)(_.imageResponseCard(_))
        .build

    def playbackCompletionEvent(
      eventId: Option[String] = None,
      clientTimestampMillis: Option[EpochMillis] = None
    ): PlaybackCompletionEvent =
      PlaybackCompletionEvent
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(clientTimestampMillis)(_.clientTimestampMillis(_))
        .build

    def playbackInterruptionEvent(
      eventReason: Option[String] = None,
      causedByEventId: Option[String] = None,
      eventId: Option[String] = None
    ): PlaybackInterruptionEvent =
      PlaybackInterruptionEvent
        .builder
        .ifSome(eventReason)(_.eventReason(_))
        .ifSome(causedByEventId)(_.causedByEventId(_))
        .ifSome(eventId)(_.eventId(_))
        .build

    def putSessionRequest(
      botId: Option[String] = None,
      botAliasId: Option[String] = None,
      localeId: Option[String] = None,
      sessionId: Option[String] = None,
      messages: Option[List[Message]] = None,
      sessionState: Option[SessionState] = None,
      requestAttributes: Option[StringMap] = None,
      responseContentType: Option[String] = None
    ): PutSessionRequest =
      PutSessionRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(messages)(_.messages(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(responseContentType)(_.responseContentType(_))
        .build

    def putSessionResponse(
      contentType: Option[String] = None,
      messages: Option[String] = None,
      sessionState: Option[String] = None,
      requestAttributes: Option[String] = None,
      sessionId: Option[String] = None,
      audioStream: Option[BlobStream] = None
    ): PutSessionResponse =
      PutSessionResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(messages)(_.messages(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(audioStream)(_.audioStream(_))
        .build

    def recognizeTextRequest(
      botId: Option[String] = None,
      botAliasId: Option[String] = None,
      localeId: Option[String] = None,
      sessionId: Option[String] = None,
      text: Option[String] = None,
      sessionState: Option[SessionState] = None,
      requestAttributes: Option[StringMap] = None
    ): RecognizeTextRequest =
      RecognizeTextRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(text)(_.text(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .build

    def recognizeTextResponse(
      messages: Option[List[Message]] = None,
      sessionState: Option[SessionState] = None,
      interpretations: Option[List[Interpretation]] = None,
      requestAttributes: Option[StringMap] = None,
      sessionId: Option[String] = None
    ): RecognizeTextResponse =
      RecognizeTextResponse
        .builder
        .ifSome(messages)(_.messages(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(interpretations)(_.interpretations(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def recognizeUtteranceRequest(
      botId: Option[String] = None,
      botAliasId: Option[String] = None,
      localeId: Option[String] = None,
      sessionId: Option[String] = None,
      sessionState: Option[String] = None,
      requestAttributes: Option[String] = None,
      requestContentType: Option[String] = None,
      responseContentType: Option[String] = None,
      inputStream: Option[BlobStream] = None
    ): RecognizeUtteranceRequest =
      RecognizeUtteranceRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(requestContentType)(_.requestContentType(_))
        .ifSome(responseContentType)(_.responseContentType(_))
        .ifSome(inputStream)(_.inputStream(_))
        .build

    def recognizeUtteranceResponse(
      inputMode: Option[String] = None,
      contentType: Option[String] = None,
      messages: Option[String] = None,
      interpretations: Option[String] = None,
      sessionState: Option[String] = None,
      requestAttributes: Option[String] = None,
      sessionId: Option[String] = None,
      inputTranscript: Option[String] = None,
      audioStream: Option[BlobStream] = None
    ): RecognizeUtteranceResponse =
      RecognizeUtteranceResponse
        .builder
        .ifSome(inputMode)(_.inputMode(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(messages)(_.messages(_))
        .ifSome(interpretations)(_.interpretations(_))
        .ifSome(sessionState)(_.sessionState(_))
        .ifSome(requestAttributes)(_.requestAttributes(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(inputTranscript)(_.inputTranscript(_))
        .ifSome(audioStream)(_.audioStream(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sentimentResponse(
      sentiment: Option[String] = None,
      sentimentScore: Option[SentimentScore] = None
    ): SentimentResponse =
      SentimentResponse
        .builder
        .ifSome(sentiment)(_.sentiment(_))
        .ifSome(sentimentScore)(_.sentimentScore(_))
        .build

    def sentimentScore(
      positive: Option[Double] = None,
      negative: Option[Double] = None,
      neutral: Option[Double] = None,
      mixed: Option[Double] = None
    ): SentimentScore =
      SentimentScore
        .builder
        .ifSome(positive)(_.positive(_))
        .ifSome(negative)(_.negative(_))
        .ifSome(neutral)(_.neutral(_))
        .ifSome(mixed)(_.mixed(_))
        .build

    def sessionState(
      dialogAction: Option[DialogAction] = None,
      intent: Option[Intent] = None,
      activeContexts: Option[List[ActiveContext]] = None,
      sessionAttributes: Option[StringMap] = None,
      originatingRequestId: Option[String] = None
    ): SessionState =
      SessionState
        .builder
        .ifSome(dialogAction)(_.dialogAction(_))
        .ifSome(intent)(_.intent(_))
        .ifSome(activeContexts)(_.activeContexts(_))
        .ifSome(sessionAttributes)(_.sessionAttributes(_))
        .ifSome(originatingRequestId)(_.originatingRequestId(_))
        .build

    def slot(
      value: Option[Value] = None,
      shape: Option[String] = None,
      values: Option[List[Slot]] = None
    ): Slot =
      Slot
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(shape)(_.shape(_))
        .ifSome(values)(_.values(_))
        .build

    def startConversationRequest(
      botId: Option[String] = None,
      botAliasId: Option[String] = None,
      localeId: Option[String] = None,
      sessionId: Option[String] = None,
      conversationMode: Option[String] = None,
      requestEventStream: Option[StartConversationRequestEventStream] = None
    ): StartConversationRequest =
      StartConversationRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(conversationMode)(_.conversationMode(_))
        .ifSome(requestEventStream)(_.requestEventStream(_))
        .build

    def startConversationRequestEventStream(
      configurationEvent: Option[ConfigurationEvent] = None,
      audioInputEvent: Option[AudioInputEvent] = None,
      dTMFInputEvent: Option[DTMFInputEvent] = None,
      textInputEvent: Option[TextInputEvent] = None,
      playbackCompletionEvent: Option[PlaybackCompletionEvent] = None,
      disconnectionEvent: Option[DisconnectionEvent] = None
    ): StartConversationRequestEventStream =
      StartConversationRequestEventStream
        .builder
        .ifSome(configurationEvent)(_.configurationEvent(_))
        .ifSome(audioInputEvent)(_.audioInputEvent(_))
        .ifSome(dTMFInputEvent)(_.dTMFInputEvent(_))
        .ifSome(textInputEvent)(_.textInputEvent(_))
        .ifSome(playbackCompletionEvent)(_.playbackCompletionEvent(_))
        .ifSome(disconnectionEvent)(_.disconnectionEvent(_))
        .build

    def startConversationResponse(
      responseEventStream: Option[StartConversationResponseEventStream] = None
    ): StartConversationResponse =
      StartConversationResponse
        .builder
        .ifSome(responseEventStream)(_.responseEventStream(_))
        .build

    def startConversationResponseEventStream(
      playbackInterruptionEvent: Option[PlaybackInterruptionEvent] = None,
      transcriptEvent: Option[TranscriptEvent] = None,
      intentResultEvent: Option[IntentResultEvent] = None,
      textResponseEvent: Option[TextResponseEvent] = None,
      audioResponseEvent: Option[AudioResponseEvent] = None,
      heartbeatEvent: Option[HeartbeatEvent] = None,
      accessDeniedException: Option[AccessDeniedException] = None,
      resourceNotFoundException: Option[ResourceNotFoundException] = None,
      validationException: Option[ValidationException] = None,
      throttlingException: Option[ThrottlingException] = None,
      internalServerException: Option[InternalServerException] = None,
      conflictException: Option[ConflictException] = None,
      dependencyFailedException: Option[DependencyFailedException] = None,
      badGatewayException: Option[BadGatewayException] = None
    ): StartConversationResponseEventStream =
      StartConversationResponseEventStream
        .builder
        .ifSome(playbackInterruptionEvent)(_.playbackInterruptionEvent(_))
        .ifSome(transcriptEvent)(_.transcriptEvent(_))
        .ifSome(intentResultEvent)(_.intentResultEvent(_))
        .ifSome(textResponseEvent)(_.textResponseEvent(_))
        .ifSome(audioResponseEvent)(_.audioResponseEvent(_))
        .ifSome(heartbeatEvent)(_.heartbeatEvent(_))
        .ifSome(accessDeniedException)(_.accessDeniedException(_))
        .ifSome(resourceNotFoundException)(_.resourceNotFoundException(_))
        .ifSome(validationException)(_.validationException(_))
        .ifSome(throttlingException)(_.throttlingException(_))
        .ifSome(internalServerException)(_.internalServerException(_))
        .ifSome(conflictException)(_.conflictException(_))
        .ifSome(dependencyFailedException)(_.dependencyFailedException(_))
        .ifSome(badGatewayException)(_.badGatewayException(_))
        .build

    def textInputEvent(
      text: Option[String] = None,
      eventId: Option[String] = None,
      clientTimestampMillis: Option[EpochMillis] = None
    ): TextInputEvent =
      TextInputEvent
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(clientTimestampMillis)(_.clientTimestampMillis(_))
        .build

    def textResponseEvent(
      messages: Option[List[Message]] = None,
      eventId: Option[String] = None
    ): TextResponseEvent =
      TextResponseEvent
        .builder
        .ifSome(messages)(_.messages(_))
        .ifSome(eventId)(_.eventId(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transcriptEvent(
      transcript: Option[String] = None,
      eventId: Option[String] = None
    ): TranscriptEvent =
      TranscriptEvent
        .builder
        .ifSome(transcript)(_.transcript(_))
        .ifSome(eventId)(_.eventId(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def value(
      originalValue: Option[String] = None,
      interpretedValue: Option[String] = None,
      resolvedValues: Option[List[NonEmptyString]] = None
    ): Value =
      Value
        .builder
        .ifSome(originalValue)(_.originalValue(_))
        .ifSome(interpretedValue)(_.interpretedValue(_))
        .ifSome(resolvedValues)(_.resolvedValues(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
