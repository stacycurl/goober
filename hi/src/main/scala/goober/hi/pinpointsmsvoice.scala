package goober.hi

import goober.free.pinpointsmsvoice.PinpointSmsVoiceIO
import software.amazon.awssdk.services.pinpointsmsvoice.model._


object pinpointsmsvoice {
  import goober.free.{pinpointsmsvoice ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def alreadyExistsException(
      message: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
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

    def callInstructionsMessageType(
      text: Option[String] = None
    ): CallInstructionsMessageType =
      CallInstructionsMessageType
        .builder
        .ifSome(text)(_.text(_))
        .build

    def cloudWatchLogsDestination(
      iamRoleArn: Option[String] = None,
      logGroupArn: Option[String] = None
    ): CloudWatchLogsDestination =
      CloudWatchLogsDestination
        .builder
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(logGroupArn)(_.logGroupArn(_))
        .build

    def createConfigurationSetEventDestinationRequest(
      configurationSetName: Option[String] = None,
      eventDestination: Option[EventDestinationDefinition] = None,
      eventDestinationName: Option[String] = None
    ): CreateConfigurationSetEventDestinationRequest =
      CreateConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestination)(_.eventDestination(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def createConfigurationSetEventDestinationResponse(

    ): CreateConfigurationSetEventDestinationResponse =
      CreateConfigurationSetEventDestinationResponse
        .builder

        .build

    def createConfigurationSetRequest(
      configurationSetName: Option[String] = None
    ): CreateConfigurationSetRequest =
      CreateConfigurationSetRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def createConfigurationSetResponse(

    ): CreateConfigurationSetResponse =
      CreateConfigurationSetResponse
        .builder

        .build

    def deleteConfigurationSetEventDestinationRequest(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None
    ): DeleteConfigurationSetEventDestinationRequest =
      DeleteConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def deleteConfigurationSetEventDestinationResponse(

    ): DeleteConfigurationSetEventDestinationResponse =
      DeleteConfigurationSetEventDestinationResponse
        .builder

        .build

    def deleteConfigurationSetRequest(
      configurationSetName: Option[String] = None
    ): DeleteConfigurationSetRequest =
      DeleteConfigurationSetRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def deleteConfigurationSetResponse(

    ): DeleteConfigurationSetResponse =
      DeleteConfigurationSetResponse
        .builder

        .build

    def eventDestination(
      cloudWatchLogsDestination: Option[CloudWatchLogsDestination] = None,
      enabled: Option[Boolean] = None,
      kinesisFirehoseDestination: Option[KinesisFirehoseDestination] = None,
      matchingEventTypes: Option[List[EventType]] = None,
      name: Option[String] = None,
      snsDestination: Option[SnsDestination] = None
    ): EventDestination =
      EventDestination
        .builder
        .ifSome(cloudWatchLogsDestination)(_.cloudWatchLogsDestination(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(kinesisFirehoseDestination)(_.kinesisFirehoseDestination(_))
        .ifSome(matchingEventTypes)(_.matchingEventTypes(_))
        .ifSome(name)(_.name(_))
        .ifSome(snsDestination)(_.snsDestination(_))
        .build

    def eventDestinationDefinition(
      cloudWatchLogsDestination: Option[CloudWatchLogsDestination] = None,
      enabled: Option[Boolean] = None,
      kinesisFirehoseDestination: Option[KinesisFirehoseDestination] = None,
      matchingEventTypes: Option[List[EventType]] = None,
      snsDestination: Option[SnsDestination] = None
    ): EventDestinationDefinition =
      EventDestinationDefinition
        .builder
        .ifSome(cloudWatchLogsDestination)(_.cloudWatchLogsDestination(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(kinesisFirehoseDestination)(_.kinesisFirehoseDestination(_))
        .ifSome(matchingEventTypes)(_.matchingEventTypes(_))
        .ifSome(snsDestination)(_.snsDestination(_))
        .build

    def getConfigurationSetEventDestinationsRequest(
      configurationSetName: Option[String] = None
    ): GetConfigurationSetEventDestinationsRequest =
      GetConfigurationSetEventDestinationsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def getConfigurationSetEventDestinationsResponse(
      eventDestinations: Option[List[EventDestination]] = None
    ): GetConfigurationSetEventDestinationsResponse =
      GetConfigurationSetEventDestinationsResponse
        .builder
        .ifSome(eventDestinations)(_.eventDestinations(_))
        .build

    def internalServiceErrorException(
      message: Option[String] = None
    ): InternalServiceErrorException =
      InternalServiceErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kinesisFirehoseDestination(
      deliveryStreamArn: Option[String] = None,
      iamRoleArn: Option[String] = None
    ): KinesisFirehoseDestination =
      KinesisFirehoseDestination
        .builder
        .ifSome(deliveryStreamArn)(_.deliveryStreamArn(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listConfigurationSetsRequest(
      nextToken: Option[String] = None,
      pageSize: Option[String] = None
    ): ListConfigurationSetsRequest =
      ListConfigurationSetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listConfigurationSetsResponse(
      configurationSets: Option[List[WordCharactersWithDelimiters]] = None,
      nextToken: Option[String] = None
    ): ListConfigurationSetsResponse =
      ListConfigurationSetsResponse
        .builder
        .ifSome(configurationSets)(_.configurationSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def plainTextMessageType(
      languageCode: Option[String] = None,
      text: Option[String] = None,
      voiceId: Option[String] = None
    ): PlainTextMessageType =
      PlainTextMessageType
        .builder
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(text)(_.text(_))
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def sSMLMessageType(
      languageCode: Option[String] = None,
      text: Option[String] = None,
      voiceId: Option[String] = None
    ): SSMLMessageType =
      SSMLMessageType
        .builder
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(text)(_.text(_))
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def sendVoiceMessageRequest(
      callerId: Option[String] = None,
      configurationSetName: Option[String] = None,
      content: Option[VoiceMessageContent] = None,
      destinationPhoneNumber: Option[String] = None,
      originationPhoneNumber: Option[String] = None
    ): SendVoiceMessageRequest =
      SendVoiceMessageRequest
        .builder
        .ifSome(callerId)(_.callerId(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(content)(_.content(_))
        .ifSome(destinationPhoneNumber)(_.destinationPhoneNumber(_))
        .ifSome(originationPhoneNumber)(_.originationPhoneNumber(_))
        .build

    def sendVoiceMessageResponse(
      messageId: Option[String] = None
    ): SendVoiceMessageResponse =
      SendVoiceMessageResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def snsDestination(
      topicArn: Option[String] = None
    ): SnsDestination =
      SnsDestination
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateConfigurationSetEventDestinationRequest(
      configurationSetName: Option[String] = None,
      eventDestination: Option[EventDestinationDefinition] = None,
      eventDestinationName: Option[String] = None
    ): UpdateConfigurationSetEventDestinationRequest =
      UpdateConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestination)(_.eventDestination(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def updateConfigurationSetEventDestinationResponse(

    ): UpdateConfigurationSetEventDestinationResponse =
      UpdateConfigurationSetEventDestinationResponse
        .builder

        .build

    def voiceMessageContent(
      callInstructionsMessage: Option[CallInstructionsMessageType] = None,
      plainTextMessage: Option[PlainTextMessageType] = None,
      sSMLMessage: Option[SSMLMessageType] = None
    ): VoiceMessageContent =
      VoiceMessageContent
        .builder
        .ifSome(callInstructionsMessage)(_.callInstructionsMessage(_))
        .ifSome(plainTextMessage)(_.plainTextMessage(_))
        .ifSome(sSMLMessage)(_.sSMLMessage(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
