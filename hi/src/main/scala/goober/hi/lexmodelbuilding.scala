package goober.hi

import goober.free.lexmodelbuilding.LexModelBuildingIO
import software.amazon.awssdk.services.lexmodelbuilding.model._


object lexmodelbuilding {
  import goober.free.{lexmodelbuilding ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def botAliasMetadata(
      name: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botName: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      checksum: Option[String] = None,
      conversationLogs: Option[ConversationLogsResponse] = None
    ): BotAliasMetadata =
      BotAliasMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(conversationLogs)(_.conversationLogs(_))
        .build

    def botChannelAssociation(
      name: Option[String] = None,
      description: Option[String] = None,
      botAlias: Option[String] = None,
      botName: Option[String] = None,
      createdDate: Option[Timestamp] = None,
      `type`: Option[String] = None,
      botConfiguration: Option[ChannelConfigurationMap] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None
    ): BotChannelAssociation =
      BotChannelAssociation
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(botConfiguration)(_.botConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def botMetadata(
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None
    ): BotMetadata =
      BotMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .build

    def builtinIntentMetadata(
      signature: Option[String] = None,
      supportedLocales: Option[List[Locale]] = None
    ): BuiltinIntentMetadata =
      BuiltinIntentMetadata
        .builder
        .ifSome(signature)(_.signature(_))
        .ifSome(supportedLocales)(_.supportedLocales(_))
        .build

    def builtinIntentSlot(
      name: Option[String] = None
    ): BuiltinIntentSlot =
      BuiltinIntentSlot
        .builder
        .ifSome(name)(_.name(_))
        .build

    def builtinSlotTypeMetadata(
      signature: Option[String] = None,
      supportedLocales: Option[List[Locale]] = None
    ): BuiltinSlotTypeMetadata =
      BuiltinSlotTypeMetadata
        .builder
        .ifSome(signature)(_.signature(_))
        .ifSome(supportedLocales)(_.supportedLocales(_))
        .build

    def codeHook(
      uri: Option[String] = None,
      messageVersion: Option[String] = None
    ): CodeHook =
      CodeHook
        .builder
        .ifSome(uri)(_.uri(_))
        .ifSome(messageVersion)(_.messageVersion(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conversationLogsRequest(
      logSettings: Option[List[LogSettingsRequest]] = None,
      iamRoleArn: Option[String] = None
    ): ConversationLogsRequest =
      ConversationLogsRequest
        .builder
        .ifSome(logSettings)(_.logSettings(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .build

    def conversationLogsResponse(
      logSettings: Option[List[LogSettingsResponse]] = None,
      iamRoleArn: Option[String] = None
    ): ConversationLogsResponse =
      ConversationLogsResponse
        .builder
        .ifSome(logSettings)(_.logSettings(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .build

    def createBotVersionRequest(
      name: Option[String] = None,
      checksum: Option[String] = None
    ): CreateBotVersionRequest =
      CreateBotVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(checksum)(_.checksum(_))
        .build

    def createBotVersionResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      intents: Option[List[Intent]] = None,
      clarificationPrompt: Option[Prompt] = None,
      abortStatement: Option[Statement] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      voiceId: Option[String] = None,
      checksum: Option[String] = None,
      version: Option[String] = None,
      locale: Option[String] = None,
      childDirected: Option[Boolean] = None,
      enableModelImprovements: Option[Boolean] = None,
      detectSentiment: Option[Boolean] = None
    ): CreateBotVersionResponse =
      CreateBotVersionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(intents)(_.intents(_))
        .ifSome(clarificationPrompt)(_.clarificationPrompt(_))
        .ifSome(abortStatement)(_.abortStatement(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(voiceId)(_.voiceId(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(version)(_.version(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(childDirected)(_.childDirected(_))
        .ifSome(enableModelImprovements)(_.enableModelImprovements(_))
        .ifSome(detectSentiment)(_.detectSentiment(_))
        .build

    def createIntentVersionRequest(
      name: Option[String] = None,
      checksum: Option[String] = None
    ): CreateIntentVersionRequest =
      CreateIntentVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(checksum)(_.checksum(_))
        .build

    def createIntentVersionResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      slots: Option[List[Slot]] = None,
      sampleUtterances: Option[List[Utterance]] = None,
      confirmationPrompt: Option[Prompt] = None,
      rejectionStatement: Option[Statement] = None,
      followUpPrompt: Option[FollowUpPrompt] = None,
      conclusionStatement: Option[Statement] = None,
      dialogCodeHook: Option[CodeHook] = None,
      fulfillmentActivity: Option[FulfillmentActivity] = None,
      parentIntentSignature: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None,
      checksum: Option[String] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None
    ): CreateIntentVersionResponse =
      CreateIntentVersionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(confirmationPrompt)(_.confirmationPrompt(_))
        .ifSome(rejectionStatement)(_.rejectionStatement(_))
        .ifSome(followUpPrompt)(_.followUpPrompt(_))
        .ifSome(conclusionStatement)(_.conclusionStatement(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentActivity)(_.fulfillmentActivity(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .build

    def createSlotTypeVersionRequest(
      name: Option[String] = None,
      checksum: Option[String] = None
    ): CreateSlotTypeVersionRequest =
      CreateSlotTypeVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(checksum)(_.checksum(_))
        .build

    def createSlotTypeVersionResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      enumerationValues: Option[List[EnumerationValue]] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None,
      checksum: Option[String] = None,
      valueSelectionStrategy: Option[String] = None,
      parentSlotTypeSignature: Option[String] = None,
      slotTypeConfigurations: Option[List[SlotTypeConfiguration]] = None
    ): CreateSlotTypeVersionResponse =
      CreateSlotTypeVersionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(enumerationValues)(_.enumerationValues(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(valueSelectionStrategy)(_.valueSelectionStrategy(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(slotTypeConfigurations)(_.slotTypeConfigurations(_))
        .build

    def deleteBotAliasRequest(
      name: Option[String] = None,
      botName: Option[String] = None
    ): DeleteBotAliasRequest =
      DeleteBotAliasRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(botName)(_.botName(_))
        .build

    def deleteBotChannelAssociationRequest(
      name: Option[String] = None,
      botName: Option[String] = None,
      botAlias: Option[String] = None
    ): DeleteBotChannelAssociationRequest =
      DeleteBotChannelAssociationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .build

    def deleteBotRequest(
      name: Option[String] = None
    ): DeleteBotRequest =
      DeleteBotRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteBotVersionRequest(
      name: Option[String] = None,
      version: Option[String] = None
    ): DeleteBotVersionRequest =
      DeleteBotVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteIntentRequest(
      name: Option[String] = None
    ): DeleteIntentRequest =
      DeleteIntentRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteIntentVersionRequest(
      name: Option[String] = None,
      version: Option[String] = None
    ): DeleteIntentVersionRequest =
      DeleteIntentVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteSlotTypeRequest(
      name: Option[String] = None
    ): DeleteSlotTypeRequest =
      DeleteSlotTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteSlotTypeVersionRequest(
      name: Option[String] = None,
      version: Option[String] = None
    ): DeleteSlotTypeVersionRequest =
      DeleteSlotTypeVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteUtterancesRequest(
      botName: Option[String] = None,
      userId: Option[String] = None
    ): DeleteUtterancesRequest =
      DeleteUtterancesRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(userId)(_.userId(_))
        .build

    def enumerationValue(
      value: Option[String] = None,
      synonyms: Option[List[Value]] = None
    ): EnumerationValue =
      EnumerationValue
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(synonyms)(_.synonyms(_))
        .build

    def followUpPrompt(
      prompt: Option[Prompt] = None,
      rejectionStatement: Option[Statement] = None
    ): FollowUpPrompt =
      FollowUpPrompt
        .builder
        .ifSome(prompt)(_.prompt(_))
        .ifSome(rejectionStatement)(_.rejectionStatement(_))
        .build

    def fulfillmentActivity(
      `type`: Option[String] = None,
      codeHook: Option[CodeHook] = None
    ): FulfillmentActivity =
      FulfillmentActivity
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(codeHook)(_.codeHook(_))
        .build

    def getBotAliasRequest(
      name: Option[String] = None,
      botName: Option[String] = None
    ): GetBotAliasRequest =
      GetBotAliasRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(botName)(_.botName(_))
        .build

    def getBotAliasResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botName: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      checksum: Option[String] = None,
      conversationLogs: Option[ConversationLogsResponse] = None
    ): GetBotAliasResponse =
      GetBotAliasResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(conversationLogs)(_.conversationLogs(_))
        .build

    def getBotAliasesRequest(
      botName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None
    ): GetBotAliasesRequest =
      GetBotAliasesRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def getBotAliasesResponse(
      botAliases: Option[List[BotAliasMetadata]] = None,
      nextToken: Option[String] = None
    ): GetBotAliasesResponse =
      GetBotAliasesResponse
        .builder
        .ifSome(botAliases)(_.botAliases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getBotChannelAssociationRequest(
      name: Option[String] = None,
      botName: Option[String] = None,
      botAlias: Option[String] = None
    ): GetBotChannelAssociationRequest =
      GetBotChannelAssociationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .build

    def getBotChannelAssociationResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      botAlias: Option[String] = None,
      botName: Option[String] = None,
      createdDate: Option[Timestamp] = None,
      `type`: Option[String] = None,
      botConfiguration: Option[ChannelConfigurationMap] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None
    ): GetBotChannelAssociationResponse =
      GetBotChannelAssociationResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(botConfiguration)(_.botConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def getBotChannelAssociationsRequest(
      botName: Option[String] = None,
      botAlias: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None
    ): GetBotChannelAssociationsRequest =
      GetBotChannelAssociationsRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botAlias)(_.botAlias(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def getBotChannelAssociationsResponse(
      botChannelAssociations: Option[List[BotChannelAssociation]] = None,
      nextToken: Option[String] = None
    ): GetBotChannelAssociationsResponse =
      GetBotChannelAssociationsResponse
        .builder
        .ifSome(botChannelAssociations)(_.botChannelAssociations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getBotRequest(
      name: Option[String] = None,
      versionOrAlias: Option[String] = None
    ): GetBotRequest =
      GetBotRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(versionOrAlias)(_.versionOrAlias(_))
        .build

    def getBotResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      intents: Option[List[Intent]] = None,
      enableModelImprovements: Option[Boolean] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      clarificationPrompt: Option[Prompt] = None,
      abortStatement: Option[Statement] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      voiceId: Option[String] = None,
      checksum: Option[String] = None,
      version: Option[String] = None,
      locale: Option[String] = None,
      childDirected: Option[Boolean] = None,
      detectSentiment: Option[Boolean] = None
    ): GetBotResponse =
      GetBotResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(intents)(_.intents(_))
        .ifSome(enableModelImprovements)(_.enableModelImprovements(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(clarificationPrompt)(_.clarificationPrompt(_))
        .ifSome(abortStatement)(_.abortStatement(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(voiceId)(_.voiceId(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(version)(_.version(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(childDirected)(_.childDirected(_))
        .ifSome(detectSentiment)(_.detectSentiment(_))
        .build

    def getBotVersionsRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetBotVersionsRequest =
      GetBotVersionsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getBotVersionsResponse(
      bots: Option[List[BotMetadata]] = None,
      nextToken: Option[String] = None
    ): GetBotVersionsResponse =
      GetBotVersionsResponse
        .builder
        .ifSome(bots)(_.bots(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getBotsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None
    ): GetBotsRequest =
      GetBotsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def getBotsResponse(
      bots: Option[List[BotMetadata]] = None,
      nextToken: Option[String] = None
    ): GetBotsResponse =
      GetBotsResponse
        .builder
        .ifSome(bots)(_.bots(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getBuiltinIntentRequest(
      signature: Option[String] = None
    ): GetBuiltinIntentRequest =
      GetBuiltinIntentRequest
        .builder
        .ifSome(signature)(_.signature(_))
        .build

    def getBuiltinIntentResponse(
      signature: Option[String] = None,
      supportedLocales: Option[List[Locale]] = None,
      slots: Option[List[BuiltinIntentSlot]] = None
    ): GetBuiltinIntentResponse =
      GetBuiltinIntentResponse
        .builder
        .ifSome(signature)(_.signature(_))
        .ifSome(supportedLocales)(_.supportedLocales(_))
        .ifSome(slots)(_.slots(_))
        .build

    def getBuiltinIntentsRequest(
      locale: Option[String] = None,
      signatureContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetBuiltinIntentsRequest =
      GetBuiltinIntentsRequest
        .builder
        .ifSome(locale)(_.locale(_))
        .ifSome(signatureContains)(_.signatureContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getBuiltinIntentsResponse(
      intents: Option[List[BuiltinIntentMetadata]] = None,
      nextToken: Option[String] = None
    ): GetBuiltinIntentsResponse =
      GetBuiltinIntentsResponse
        .builder
        .ifSome(intents)(_.intents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getBuiltinSlotTypesRequest(
      locale: Option[String] = None,
      signatureContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetBuiltinSlotTypesRequest =
      GetBuiltinSlotTypesRequest
        .builder
        .ifSome(locale)(_.locale(_))
        .ifSome(signatureContains)(_.signatureContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getBuiltinSlotTypesResponse(
      slotTypes: Option[List[BuiltinSlotTypeMetadata]] = None,
      nextToken: Option[String] = None
    ): GetBuiltinSlotTypesResponse =
      GetBuiltinSlotTypesResponse
        .builder
        .ifSome(slotTypes)(_.slotTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getExportRequest(
      name: Option[String] = None,
      version: Option[String] = None,
      resourceType: Option[String] = None,
      exportType: Option[String] = None
    ): GetExportRequest =
      GetExportRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(exportType)(_.exportType(_))
        .build

    def getExportResponse(
      name: Option[String] = None,
      version: Option[String] = None,
      resourceType: Option[String] = None,
      exportType: Option[String] = None,
      exportStatus: Option[String] = None,
      failureReason: Option[String] = None,
      url: Option[String] = None
    ): GetExportResponse =
      GetExportResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(exportType)(_.exportType(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(url)(_.url(_))
        .build

    def getImportRequest(
      importId: Option[String] = None
    ): GetImportRequest =
      GetImportRequest
        .builder
        .ifSome(importId)(_.importId(_))
        .build

    def getImportResponse(
      name: Option[String] = None,
      resourceType: Option[String] = None,
      mergeStrategy: Option[String] = None,
      importId: Option[String] = None,
      importStatus: Option[String] = None,
      failureReason: Option[List[String]] = None,
      createdDate: Option[Timestamp] = None
    ): GetImportResponse =
      GetImportResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(importId)(_.importId(_))
        .ifSome(importStatus)(_.importStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def getIntentRequest(
      name: Option[String] = None,
      version: Option[String] = None
    ): GetIntentRequest =
      GetIntentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def getIntentResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      slots: Option[List[Slot]] = None,
      sampleUtterances: Option[List[Utterance]] = None,
      confirmationPrompt: Option[Prompt] = None,
      rejectionStatement: Option[Statement] = None,
      followUpPrompt: Option[FollowUpPrompt] = None,
      conclusionStatement: Option[Statement] = None,
      dialogCodeHook: Option[CodeHook] = None,
      fulfillmentActivity: Option[FulfillmentActivity] = None,
      parentIntentSignature: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None,
      checksum: Option[String] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None
    ): GetIntentResponse =
      GetIntentResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(confirmationPrompt)(_.confirmationPrompt(_))
        .ifSome(rejectionStatement)(_.rejectionStatement(_))
        .ifSome(followUpPrompt)(_.followUpPrompt(_))
        .ifSome(conclusionStatement)(_.conclusionStatement(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentActivity)(_.fulfillmentActivity(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .build

    def getIntentVersionsRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetIntentVersionsRequest =
      GetIntentVersionsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getIntentVersionsResponse(
      intents: Option[List[IntentMetadata]] = None,
      nextToken: Option[String] = None
    ): GetIntentVersionsResponse =
      GetIntentVersionsResponse
        .builder
        .ifSome(intents)(_.intents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getIntentsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None
    ): GetIntentsRequest =
      GetIntentsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def getIntentsResponse(
      intents: Option[List[IntentMetadata]] = None,
      nextToken: Option[String] = None
    ): GetIntentsResponse =
      GetIntentsResponse
        .builder
        .ifSome(intents)(_.intents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSlotTypeRequest(
      name: Option[String] = None,
      version: Option[String] = None
    ): GetSlotTypeRequest =
      GetSlotTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def getSlotTypeResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      enumerationValues: Option[List[EnumerationValue]] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None,
      checksum: Option[String] = None,
      valueSelectionStrategy: Option[String] = None,
      parentSlotTypeSignature: Option[String] = None,
      slotTypeConfigurations: Option[List[SlotTypeConfiguration]] = None
    ): GetSlotTypeResponse =
      GetSlotTypeResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(enumerationValues)(_.enumerationValues(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(valueSelectionStrategy)(_.valueSelectionStrategy(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(slotTypeConfigurations)(_.slotTypeConfigurations(_))
        .build

    def getSlotTypeVersionsRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetSlotTypeVersionsRequest =
      GetSlotTypeVersionsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getSlotTypeVersionsResponse(
      slotTypes: Option[List[SlotTypeMetadata]] = None,
      nextToken: Option[String] = None
    ): GetSlotTypeVersionsResponse =
      GetSlotTypeVersionsResponse
        .builder
        .ifSome(slotTypes)(_.slotTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSlotTypesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None
    ): GetSlotTypesRequest =
      GetSlotTypesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def getSlotTypesResponse(
      slotTypes: Option[List[SlotTypeMetadata]] = None,
      nextToken: Option[String] = None
    ): GetSlotTypesResponse =
      GetSlotTypesResponse
        .builder
        .ifSome(slotTypes)(_.slotTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getUtterancesViewRequest(
      botName: Option[String] = None,
      botVersions: Option[List[Version]] = None,
      statusType: Option[String] = None
    ): GetUtterancesViewRequest =
      GetUtterancesViewRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botVersions)(_.botVersions(_))
        .ifSome(statusType)(_.statusType(_))
        .build

    def getUtterancesViewResponse(
      botName: Option[String] = None,
      utterances: Option[List[UtteranceList]] = None
    ): GetUtterancesViewResponse =
      GetUtterancesViewResponse
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(utterances)(_.utterances(_))
        .build

    def inputContext(
      name: Option[String] = None
    ): InputContext =
      InputContext
        .builder
        .ifSome(name)(_.name(_))
        .build

    def intent(
      intentName: Option[String] = None,
      intentVersion: Option[String] = None
    ): Intent =
      Intent
        .builder
        .ifSome(intentName)(_.intentName(_))
        .ifSome(intentVersion)(_.intentVersion(_))
        .build

    def intentMetadata(
      name: Option[String] = None,
      description: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None
    ): IntentMetadata =
      IntentMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kendraConfiguration(
      kendraIndex: Option[String] = None,
      queryFilterString: Option[String] = None,
      role: Option[String] = None
    ): KendraConfiguration =
      KendraConfiguration
        .builder
        .ifSome(kendraIndex)(_.kendraIndex(_))
        .ifSome(queryFilterString)(_.queryFilterString(_))
        .ifSome(role)(_.role(_))
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

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def logSettingsRequest(
      logType: Option[String] = None,
      destination: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      resourceArn: Option[String] = None
    ): LogSettingsRequest =
      LogSettingsRequest
        .builder
        .ifSome(logType)(_.logType(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def logSettingsResponse(
      logType: Option[String] = None,
      destination: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      resourceArn: Option[String] = None,
      resourcePrefix: Option[String] = None
    ): LogSettingsResponse =
      LogSettingsResponse
        .builder
        .ifSome(logType)(_.logType(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourcePrefix)(_.resourcePrefix(_))
        .build

    def message(
      contentType: Option[String] = None,
      content: Option[String] = None,
      groupNumber: Option[Int] = None
    ): Message =
      Message
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(content)(_.content(_))
        .ifSome(groupNumber)(_.groupNumber(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def outputContext(
      name: Option[String] = None,
      timeToLiveInSeconds: Option[Int] = None,
      turnsToLive: Option[Int] = None
    ): OutputContext =
      OutputContext
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(timeToLiveInSeconds)(_.timeToLiveInSeconds(_))
        .ifSome(turnsToLive)(_.turnsToLive(_))
        .build

    def preconditionFailedException(
      message: Option[String] = None
    ): PreconditionFailedException =
      PreconditionFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def prompt(
      messages: Option[List[Message]] = None,
      maxAttempts: Option[Int] = None,
      responseCard: Option[String] = None
    ): Prompt =
      Prompt
        .builder
        .ifSome(messages)(_.messages(_))
        .ifSome(maxAttempts)(_.maxAttempts(_))
        .ifSome(responseCard)(_.responseCard(_))
        .build

    def putBotAliasRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botName: Option[String] = None,
      checksum: Option[String] = None,
      conversationLogs: Option[ConversationLogsRequest] = None,
      tags: Option[List[Tag]] = None
    ): PutBotAliasRequest =
      PutBotAliasRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(conversationLogs)(_.conversationLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putBotAliasResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botName: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      checksum: Option[String] = None,
      conversationLogs: Option[ConversationLogsResponse] = None,
      tags: Option[List[Tag]] = None
    ): PutBotAliasResponse =
      PutBotAliasResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(conversationLogs)(_.conversationLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putBotRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      intents: Option[List[Intent]] = None,
      enableModelImprovements: Option[Boolean] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      clarificationPrompt: Option[Prompt] = None,
      abortStatement: Option[Statement] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      voiceId: Option[String] = None,
      checksum: Option[String] = None,
      processBehavior: Option[String] = None,
      locale: Option[String] = None,
      childDirected: Option[Boolean] = None,
      detectSentiment: Option[Boolean] = None,
      createVersion: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): PutBotRequest =
      PutBotRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(intents)(_.intents(_))
        .ifSome(enableModelImprovements)(_.enableModelImprovements(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(clarificationPrompt)(_.clarificationPrompt(_))
        .ifSome(abortStatement)(_.abortStatement(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(voiceId)(_.voiceId(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(processBehavior)(_.processBehavior(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(childDirected)(_.childDirected(_))
        .ifSome(detectSentiment)(_.detectSentiment(_))
        .ifSome(createVersion)(_.createVersion(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putBotResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      intents: Option[List[Intent]] = None,
      enableModelImprovements: Option[Boolean] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      clarificationPrompt: Option[Prompt] = None,
      abortStatement: Option[Statement] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      voiceId: Option[String] = None,
      checksum: Option[String] = None,
      version: Option[String] = None,
      locale: Option[String] = None,
      childDirected: Option[Boolean] = None,
      createVersion: Option[Boolean] = None,
      detectSentiment: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): PutBotResponse =
      PutBotResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(intents)(_.intents(_))
        .ifSome(enableModelImprovements)(_.enableModelImprovements(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(clarificationPrompt)(_.clarificationPrompt(_))
        .ifSome(abortStatement)(_.abortStatement(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(voiceId)(_.voiceId(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(version)(_.version(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(childDirected)(_.childDirected(_))
        .ifSome(createVersion)(_.createVersion(_))
        .ifSome(detectSentiment)(_.detectSentiment(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putIntentRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      slots: Option[List[Slot]] = None,
      sampleUtterances: Option[List[Utterance]] = None,
      confirmationPrompt: Option[Prompt] = None,
      rejectionStatement: Option[Statement] = None,
      followUpPrompt: Option[FollowUpPrompt] = None,
      conclusionStatement: Option[Statement] = None,
      dialogCodeHook: Option[CodeHook] = None,
      fulfillmentActivity: Option[FulfillmentActivity] = None,
      parentIntentSignature: Option[String] = None,
      checksum: Option[String] = None,
      createVersion: Option[Boolean] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None
    ): PutIntentRequest =
      PutIntentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(confirmationPrompt)(_.confirmationPrompt(_))
        .ifSome(rejectionStatement)(_.rejectionStatement(_))
        .ifSome(followUpPrompt)(_.followUpPrompt(_))
        .ifSome(conclusionStatement)(_.conclusionStatement(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentActivity)(_.fulfillmentActivity(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(createVersion)(_.createVersion(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .build

    def putIntentResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      slots: Option[List[Slot]] = None,
      sampleUtterances: Option[List[Utterance]] = None,
      confirmationPrompt: Option[Prompt] = None,
      rejectionStatement: Option[Statement] = None,
      followUpPrompt: Option[FollowUpPrompt] = None,
      conclusionStatement: Option[Statement] = None,
      dialogCodeHook: Option[CodeHook] = None,
      fulfillmentActivity: Option[FulfillmentActivity] = None,
      parentIntentSignature: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None,
      checksum: Option[String] = None,
      createVersion: Option[Boolean] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None
    ): PutIntentResponse =
      PutIntentResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(confirmationPrompt)(_.confirmationPrompt(_))
        .ifSome(rejectionStatement)(_.rejectionStatement(_))
        .ifSome(followUpPrompt)(_.followUpPrompt(_))
        .ifSome(conclusionStatement)(_.conclusionStatement(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentActivity)(_.fulfillmentActivity(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(createVersion)(_.createVersion(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .build

    def putSlotTypeRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      enumerationValues: Option[List[EnumerationValue]] = None,
      checksum: Option[String] = None,
      valueSelectionStrategy: Option[String] = None,
      createVersion: Option[Boolean] = None,
      parentSlotTypeSignature: Option[String] = None,
      slotTypeConfigurations: Option[List[SlotTypeConfiguration]] = None
    ): PutSlotTypeRequest =
      PutSlotTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(enumerationValues)(_.enumerationValues(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(valueSelectionStrategy)(_.valueSelectionStrategy(_))
        .ifSome(createVersion)(_.createVersion(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(slotTypeConfigurations)(_.slotTypeConfigurations(_))
        .build

    def putSlotTypeResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      enumerationValues: Option[List[EnumerationValue]] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None,
      checksum: Option[String] = None,
      valueSelectionStrategy: Option[String] = None,
      createVersion: Option[Boolean] = None,
      parentSlotTypeSignature: Option[String] = None,
      slotTypeConfigurations: Option[List[SlotTypeConfiguration]] = None
    ): PutSlotTypeResponse =
      PutSlotTypeResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(enumerationValues)(_.enumerationValues(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(valueSelectionStrategy)(_.valueSelectionStrategy(_))
        .ifSome(createVersion)(_.createVersion(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(slotTypeConfigurations)(_.slotTypeConfigurations(_))
        .build

    def resourceInUseException(
      referenceType: Option[String] = None,
      exampleReference: Option[ResourceReference] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(referenceType)(_.referenceType(_))
        .ifSome(exampleReference)(_.exampleReference(_))
        .build

    def resourceReference(
      name: Option[String] = None,
      version: Option[String] = None
    ): ResourceReference =
      ResourceReference
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def slot(
      name: Option[String] = None,
      description: Option[String] = None,
      slotConstraint: Option[String] = None,
      slotType: Option[String] = None,
      slotTypeVersion: Option[String] = None,
      valueElicitationPrompt: Option[Prompt] = None,
      priority: Option[Int] = None,
      sampleUtterances: Option[List[Utterance]] = None,
      responseCard: Option[String] = None,
      obfuscationSetting: Option[String] = None,
      defaultValueSpec: Option[SlotDefaultValueSpec] = None
    ): Slot =
      Slot
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotConstraint)(_.slotConstraint(_))
        .ifSome(slotType)(_.slotType(_))
        .ifSome(slotTypeVersion)(_.slotTypeVersion(_))
        .ifSome(valueElicitationPrompt)(_.valueElicitationPrompt(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(responseCard)(_.responseCard(_))
        .ifSome(obfuscationSetting)(_.obfuscationSetting(_))
        .ifSome(defaultValueSpec)(_.defaultValueSpec(_))
        .build

    def slotDefaultValue(
      defaultValue: Option[String] = None
    ): SlotDefaultValue =
      SlotDefaultValue
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def slotDefaultValueSpec(
      defaultValueList: Option[List[SlotDefaultValue]] = None
    ): SlotDefaultValueSpec =
      SlotDefaultValueSpec
        .builder
        .ifSome(defaultValueList)(_.defaultValueList(_))
        .build

    def slotTypeConfiguration(
      regexConfiguration: Option[SlotTypeRegexConfiguration] = None
    ): SlotTypeConfiguration =
      SlotTypeConfiguration
        .builder
        .ifSome(regexConfiguration)(_.regexConfiguration(_))
        .build

    def slotTypeMetadata(
      name: Option[String] = None,
      description: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None
    ): SlotTypeMetadata =
      SlotTypeMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .build

    def slotTypeRegexConfiguration(
      pattern: Option[String] = None
    ): SlotTypeRegexConfiguration =
      SlotTypeRegexConfiguration
        .builder
        .ifSome(pattern)(_.pattern(_))
        .build

    def startImportRequest(
      payload: Option[Blob] = None,
      resourceType: Option[String] = None,
      mergeStrategy: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): StartImportRequest =
      StartImportRequest
        .builder
        .ifSome(payload)(_.payload(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startImportResponse(
      name: Option[String] = None,
      resourceType: Option[String] = None,
      mergeStrategy: Option[String] = None,
      importId: Option[String] = None,
      importStatus: Option[String] = None,
      tags: Option[List[Tag]] = None,
      createdDate: Option[Timestamp] = None
    ): StartImportResponse =
      StartImportResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(importId)(_.importId(_))
        .ifSome(importStatus)(_.importStatus(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def statement(
      messages: Option[List[Message]] = None,
      responseCard: Option[String] = None
    ): Statement =
      Statement
        .builder
        .ifSome(messages)(_.messages(_))
        .ifSome(responseCard)(_.responseCard(_))
        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def utteranceData(
      utteranceString: Option[String] = None,
      count: Option[Int] = None,
      distinctUsers: Option[Int] = None,
      firstUtteredDate: Option[Timestamp] = None,
      lastUtteredDate: Option[Timestamp] = None
    ): UtteranceData =
      UtteranceData
        .builder
        .ifSome(utteranceString)(_.utteranceString(_))
        .ifSome(count)(_.count(_))
        .ifSome(distinctUsers)(_.distinctUsers(_))
        .ifSome(firstUtteredDate)(_.firstUtteredDate(_))
        .ifSome(lastUtteredDate)(_.lastUtteredDate(_))
        .build

    def utteranceList(
      botVersion: Option[String] = None,
      utterances: Option[List[UtteranceData]] = None
    ): UtteranceList =
      UtteranceList
        .builder
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(utterances)(_.utterances(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
