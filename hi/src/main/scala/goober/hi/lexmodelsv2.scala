package goober.hi

import goober.free.lexmodelsv2.LexModelsV2IO
import software.amazon.awssdk.services.lexmodelsv2.model._


object lexmodelsv2 {
  import goober.free.{lexmodelsv2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def audioLogDestination(
      s3Bucket: Option[S3BucketLogDestination] = None
    ): AudioLogDestination =
      AudioLogDestination
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .build

    def audioLogSetting(
      enabled: Option[Boolean] = None,
      destination: Option[AudioLogDestination] = None
    ): AudioLogSetting =
      AudioLogSetting
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(destination)(_.destination(_))
        .build

    def botAliasHistoryEvent(
      botVersion: Option[String] = None,
      startDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None
    ): BotAliasHistoryEvent =
      BotAliasHistoryEvent
        .builder
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .build

    def botAliasLocaleSettings(
      enabled: Option[Boolean] = None,
      codeHookSpecification: Option[CodeHookSpecification] = None
    ): BotAliasLocaleSettings =
      BotAliasLocaleSettings
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(codeHookSpecification)(_.codeHookSpecification(_))
        .build

    def botAliasSummary(
      botAliasId: Option[String] = None,
      botAliasName: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botAliasStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): BotAliasSummary =
      BotAliasSummary
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botAliasName)(_.botAliasName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botAliasStatus)(_.botAliasStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def botExportSpecification(
      botId: Option[String] = None,
      botVersion: Option[String] = None
    ): BotExportSpecification =
      BotExportSpecification
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .build

    def botFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      operator: Option[String] = None
    ): BotFilter =
      BotFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def botImportSpecification(
      botName: Option[String] = None,
      roleArn: Option[String] = None,
      dataPrivacy: Option[DataPrivacy] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      botTags: Option[TagMap] = None,
      testBotAliasTags: Option[TagMap] = None
    ): BotImportSpecification =
      BotImportSpecification
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPrivacy)(_.dataPrivacy(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(botTags)(_.botTags(_))
        .ifSome(testBotAliasTags)(_.testBotAliasTags(_))
        .build

    def botLocaleExportSpecification(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): BotLocaleExportSpecification =
      BotLocaleExportSpecification
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def botLocaleFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      operator: Option[String] = None
    ): BotLocaleFilter =
      BotLocaleFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def botLocaleHistoryEvent(
      event: Option[String] = None,
      eventDate: Option[Timestamp] = None
    ): BotLocaleHistoryEvent =
      BotLocaleHistoryEvent
        .builder
        .ifSome(event)(_.event(_))
        .ifSome(eventDate)(_.eventDate(_))
        .build

    def botLocaleImportSpecification(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      voiceSettings: Option[VoiceSettings] = None
    ): BotLocaleImportSpecification =
      BotLocaleImportSpecification
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(voiceSettings)(_.voiceSettings(_))
        .build

    def botLocaleSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): BotLocaleSortBy =
      BotLocaleSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def botLocaleSummary(
      localeId: Option[String] = None,
      localeName: Option[String] = None,
      description: Option[String] = None,
      botLocaleStatus: Option[String] = None,
      lastUpdatedDateTime: Option[Timestamp] = None,
      lastBuildSubmittedDateTime: Option[Timestamp] = None
    ): BotLocaleSummary =
      BotLocaleSummary
        .builder
        .ifSome(localeId)(_.localeId(_))
        .ifSome(localeName)(_.localeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botLocaleStatus)(_.botLocaleStatus(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(lastBuildSubmittedDateTime)(_.lastBuildSubmittedDateTime(_))
        .build

    def botSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): BotSortBy =
      BotSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def botSummary(
      botId: Option[String] = None,
      botName: Option[String] = None,
      description: Option[String] = None,
      botStatus: Option[String] = None,
      latestBotVersion: Option[String] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): BotSummary =
      BotSummary
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botStatus)(_.botStatus(_))
        .ifSome(latestBotVersion)(_.latestBotVersion(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def botVersionLocaleDetails(
      sourceBotVersion: Option[String] = None
    ): BotVersionLocaleDetails =
      BotVersionLocaleDetails
        .builder
        .ifSome(sourceBotVersion)(_.sourceBotVersion(_))
        .build

    def botVersionSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): BotVersionSortBy =
      BotVersionSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def botVersionSummary(
      botName: Option[String] = None,
      botVersion: Option[String] = None,
      description: Option[String] = None,
      botStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): BotVersionSummary =
      BotVersionSummary
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(botStatus)(_.botStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def buildBotLocaleRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): BuildBotLocaleRequest =
      BuildBotLocaleRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def buildBotLocaleResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      botLocaleStatus: Option[String] = None,
      lastBuildSubmittedDateTime: Option[Timestamp] = None
    ): BuildBotLocaleResponse =
      BuildBotLocaleResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(botLocaleStatus)(_.botLocaleStatus(_))
        .ifSome(lastBuildSubmittedDateTime)(_.lastBuildSubmittedDateTime(_))
        .build

    def builtInIntentSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): BuiltInIntentSortBy =
      BuiltInIntentSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def builtInIntentSummary(
      intentSignature: Option[String] = None,
      description: Option[String] = None
    ): BuiltInIntentSummary =
      BuiltInIntentSummary
        .builder
        .ifSome(intentSignature)(_.intentSignature(_))
        .ifSome(description)(_.description(_))
        .build

    def builtInSlotTypeSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): BuiltInSlotTypeSortBy =
      BuiltInSlotTypeSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def builtInSlotTypeSummary(
      slotTypeSignature: Option[String] = None,
      description: Option[String] = None
    ): BuiltInSlotTypeSummary =
      BuiltInSlotTypeSummary
        .builder
        .ifSome(slotTypeSignature)(_.slotTypeSignature(_))
        .ifSome(description)(_.description(_))
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

    def cloudWatchLogGroupLogDestination(
      cloudWatchLogGroupArn: Option[String] = None,
      logPrefix: Option[String] = None
    ): CloudWatchLogGroupLogDestination =
      CloudWatchLogGroupLogDestination
        .builder
        .ifSome(cloudWatchLogGroupArn)(_.cloudWatchLogGroupArn(_))
        .ifSome(logPrefix)(_.logPrefix(_))
        .build

    def codeHookSpecification(
      lambdaCodeHook: Option[LambdaCodeHook] = None
    ): CodeHookSpecification =
      CodeHookSpecification
        .builder
        .ifSome(lambdaCodeHook)(_.lambdaCodeHook(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conversationLogSettings(
      textLogSettings: Option[List[TextLogSetting]] = None,
      audioLogSettings: Option[List[AudioLogSetting]] = None
    ): ConversationLogSettings =
      ConversationLogSettings
        .builder
        .ifSome(textLogSettings)(_.textLogSettings(_))
        .ifSome(audioLogSettings)(_.audioLogSettings(_))
        .build

    def createBotAliasRequest(
      botAliasName: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botAliasLocaleSettings: Option[BotAliasLocaleSettingsMap] = None,
      conversationLogSettings: Option[ConversationLogSettings] = None,
      sentimentAnalysisSettings: Option[SentimentAnalysisSettings] = None,
      botId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateBotAliasRequest =
      CreateBotAliasRequest
        .builder
        .ifSome(botAliasName)(_.botAliasName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botAliasLocaleSettings)(_.botAliasLocaleSettings(_))
        .ifSome(conversationLogSettings)(_.conversationLogSettings(_))
        .ifSome(sentimentAnalysisSettings)(_.sentimentAnalysisSettings(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createBotAliasResponse(
      botAliasId: Option[String] = None,
      botAliasName: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botAliasLocaleSettings: Option[BotAliasLocaleSettingsMap] = None,
      conversationLogSettings: Option[ConversationLogSettings] = None,
      sentimentAnalysisSettings: Option[SentimentAnalysisSettings] = None,
      botAliasStatus: Option[String] = None,
      botId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      tags: Option[TagMap] = None
    ): CreateBotAliasResponse =
      CreateBotAliasResponse
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botAliasName)(_.botAliasName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botAliasLocaleSettings)(_.botAliasLocaleSettings(_))
        .ifSome(conversationLogSettings)(_.conversationLogSettings(_))
        .ifSome(sentimentAnalysisSettings)(_.sentimentAnalysisSettings(_))
        .ifSome(botAliasStatus)(_.botAliasStatus(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createBotLocaleRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      description: Option[String] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      voiceSettings: Option[VoiceSettings] = None
    ): CreateBotLocaleRequest =
      CreateBotLocaleRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(description)(_.description(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(voiceSettings)(_.voiceSettings(_))
        .build

    def createBotLocaleResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeName: Option[String] = None,
      localeId: Option[String] = None,
      description: Option[String] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      voiceSettings: Option[VoiceSettings] = None,
      botLocaleStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): CreateBotLocaleResponse =
      CreateBotLocaleResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeName)(_.localeName(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(description)(_.description(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(voiceSettings)(_.voiceSettings(_))
        .ifSome(botLocaleStatus)(_.botLocaleStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def createBotRequest(
      botName: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      dataPrivacy: Option[DataPrivacy] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      botTags: Option[TagMap] = None,
      testBotAliasTags: Option[TagMap] = None
    ): CreateBotRequest =
      CreateBotRequest
        .builder
        .ifSome(botName)(_.botName(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPrivacy)(_.dataPrivacy(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(botTags)(_.botTags(_))
        .ifSome(testBotAliasTags)(_.testBotAliasTags(_))
        .build

    def createBotResponse(
      botId: Option[String] = None,
      botName: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      dataPrivacy: Option[DataPrivacy] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      botStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      botTags: Option[TagMap] = None,
      testBotAliasTags: Option[TagMap] = None
    ): CreateBotResponse =
      CreateBotResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPrivacy)(_.dataPrivacy(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(botStatus)(_.botStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(botTags)(_.botTags(_))
        .ifSome(testBotAliasTags)(_.testBotAliasTags(_))
        .build

    def createBotVersionRequest(
      botId: Option[String] = None,
      description: Option[String] = None,
      botVersionLocaleSpecification: Option[BotVersionLocaleSpecification] = None
    ): CreateBotVersionRequest =
      CreateBotVersionRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersionLocaleSpecification)(_.botVersionLocaleSpecification(_))
        .build

    def createBotVersionResponse(
      botId: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botVersionLocaleSpecification: Option[BotVersionLocaleSpecification] = None,
      botStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): CreateBotVersionResponse =
      CreateBotVersionResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botVersionLocaleSpecification)(_.botVersionLocaleSpecification(_))
        .ifSome(botStatus)(_.botStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def createExportRequest(
      resourceSpecification: Option[ExportResourceSpecification] = None,
      fileFormat: Option[String] = None,
      filePassword: Option[String] = None
    ): CreateExportRequest =
      CreateExportRequest
        .builder
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(filePassword)(_.filePassword(_))
        .build

    def createExportResponse(
      exportId: Option[String] = None,
      resourceSpecification: Option[ExportResourceSpecification] = None,
      fileFormat: Option[String] = None,
      exportStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): CreateExportResponse =
      CreateExportResponse
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def createIntentRequest(
      intentName: Option[String] = None,
      description: Option[String] = None,
      parentIntentSignature: Option[String] = None,
      sampleUtterances: Option[List[SampleUtterance]] = None,
      dialogCodeHook: Option[DialogCodeHookSettings] = None,
      fulfillmentCodeHook: Option[FulfillmentCodeHookSettings] = None,
      intentConfirmationSetting: Option[IntentConfirmationSetting] = None,
      intentClosingSetting: Option[IntentClosingSetting] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): CreateIntentRequest =
      CreateIntentRequest
        .builder
        .ifSome(intentName)(_.intentName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentCodeHook)(_.fulfillmentCodeHook(_))
        .ifSome(intentConfirmationSetting)(_.intentConfirmationSetting(_))
        .ifSome(intentClosingSetting)(_.intentClosingSetting(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def createIntentResponse(
      intentId: Option[String] = None,
      intentName: Option[String] = None,
      description: Option[String] = None,
      parentIntentSignature: Option[String] = None,
      sampleUtterances: Option[List[SampleUtterance]] = None,
      dialogCodeHook: Option[DialogCodeHookSettings] = None,
      fulfillmentCodeHook: Option[FulfillmentCodeHookSettings] = None,
      intentConfirmationSetting: Option[IntentConfirmationSetting] = None,
      intentClosingSetting: Option[IntentClosingSetting] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): CreateIntentResponse =
      CreateIntentResponse
        .builder
        .ifSome(intentId)(_.intentId(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentCodeHook)(_.fulfillmentCodeHook(_))
        .ifSome(intentConfirmationSetting)(_.intentConfirmationSetting(_))
        .ifSome(intentClosingSetting)(_.intentClosingSetting(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def createResourcePolicyRequest(
      resourceArn: Option[String] = None,
      policy: Option[String] = None
    ): CreateResourcePolicyRequest =
      CreateResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def createResourcePolicyResponse(
      resourceArn: Option[String] = None,
      revisionId: Option[String] = None
    ): CreateResourcePolicyResponse =
      CreateResourcePolicyResponse
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def createResourcePolicyStatementRequest(
      resourceArn: Option[String] = None,
      statementId: Option[String] = None,
      effect: Option[String] = None,
      principal: Option[List[Principal]] = None,
      action: Option[List[Operation]] = None,
      condition: Option[ConditionMap] = None,
      expectedRevisionId: Option[String] = None
    ): CreateResourcePolicyStatementRequest =
      CreateResourcePolicyStatementRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(effect)(_.effect(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(action)(_.action(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(expectedRevisionId)(_.expectedRevisionId(_))
        .build

    def createResourcePolicyStatementResponse(
      resourceArn: Option[String] = None,
      revisionId: Option[String] = None
    ): CreateResourcePolicyStatementResponse =
      CreateResourcePolicyStatementResponse
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def createSlotRequest(
      slotName: Option[String] = None,
      description: Option[String] = None,
      slotTypeId: Option[String] = None,
      valueElicitationSetting: Option[SlotValueElicitationSetting] = None,
      obfuscationSetting: Option[ObfuscationSetting] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None,
      multipleValuesSetting: Option[MultipleValuesSetting] = None
    ): CreateSlotRequest =
      CreateSlotRequest
        .builder
        .ifSome(slotName)(_.slotName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(valueElicitationSetting)(_.valueElicitationSetting(_))
        .ifSome(obfuscationSetting)(_.obfuscationSetting(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .ifSome(multipleValuesSetting)(_.multipleValuesSetting(_))
        .build

    def createSlotResponse(
      slotId: Option[String] = None,
      slotName: Option[String] = None,
      description: Option[String] = None,
      slotTypeId: Option[String] = None,
      valueElicitationSetting: Option[SlotValueElicitationSetting] = None,
      obfuscationSetting: Option[ObfuscationSetting] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      multipleValuesSetting: Option[MultipleValuesSetting] = None
    ): CreateSlotResponse =
      CreateSlotResponse
        .builder
        .ifSome(slotId)(_.slotId(_))
        .ifSome(slotName)(_.slotName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(valueElicitationSetting)(_.valueElicitationSetting(_))
        .ifSome(obfuscationSetting)(_.obfuscationSetting(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(multipleValuesSetting)(_.multipleValuesSetting(_))
        .build

    def createSlotTypeRequest(
      slotTypeName: Option[String] = None,
      description: Option[String] = None,
      slotTypeValues: Option[List[SlotTypeValue]] = None,
      valueSelectionSetting: Option[SlotValueSelectionSetting] = None,
      parentSlotTypeSignature: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): CreateSlotTypeRequest =
      CreateSlotTypeRequest
        .builder
        .ifSome(slotTypeName)(_.slotTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeValues)(_.slotTypeValues(_))
        .ifSome(valueSelectionSetting)(_.valueSelectionSetting(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def createSlotTypeResponse(
      slotTypeId: Option[String] = None,
      slotTypeName: Option[String] = None,
      description: Option[String] = None,
      slotTypeValues: Option[List[SlotTypeValue]] = None,
      valueSelectionSetting: Option[SlotValueSelectionSetting] = None,
      parentSlotTypeSignature: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): CreateSlotTypeResponse =
      CreateSlotTypeResponse
        .builder
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(slotTypeName)(_.slotTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeValues)(_.slotTypeValues(_))
        .ifSome(valueSelectionSetting)(_.valueSelectionSetting(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def createUploadUrlRequest(

    ): CreateUploadUrlRequest =
      CreateUploadUrlRequest
        .builder

        .build

    def createUploadUrlResponse(
      importId: Option[String] = None,
      uploadUrl: Option[String] = None
    ): CreateUploadUrlResponse =
      CreateUploadUrlResponse
        .builder
        .ifSome(importId)(_.importId(_))
        .ifSome(uploadUrl)(_.uploadUrl(_))
        .build

    def customPayload(
      value: Option[String] = None
    ): CustomPayload =
      CustomPayload
        .builder
        .ifSome(value)(_.value(_))
        .build

    def dataPrivacy(
      childDirected: Option[Boolean] = None
    ): DataPrivacy =
      DataPrivacy
        .builder
        .ifSome(childDirected)(_.childDirected(_))
        .build

    def deleteBotAliasRequest(
      botAliasId: Option[String] = None,
      botId: Option[String] = None,
      skipResourceInUseCheck: Option[Boolean] = None
    ): DeleteBotAliasRequest =
      DeleteBotAliasRequest
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(skipResourceInUseCheck)(_.skipResourceInUseCheck(_))
        .build

    def deleteBotAliasResponse(
      botAliasId: Option[String] = None,
      botId: Option[String] = None,
      botAliasStatus: Option[String] = None
    ): DeleteBotAliasResponse =
      DeleteBotAliasResponse
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botAliasStatus)(_.botAliasStatus(_))
        .build

    def deleteBotLocaleRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): DeleteBotLocaleRequest =
      DeleteBotLocaleRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def deleteBotLocaleResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      botLocaleStatus: Option[String] = None
    ): DeleteBotLocaleResponse =
      DeleteBotLocaleResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(botLocaleStatus)(_.botLocaleStatus(_))
        .build

    def deleteBotRequest(
      botId: Option[String] = None,
      skipResourceInUseCheck: Option[Boolean] = None
    ): DeleteBotRequest =
      DeleteBotRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(skipResourceInUseCheck)(_.skipResourceInUseCheck(_))
        .build

    def deleteBotResponse(
      botId: Option[String] = None,
      botStatus: Option[String] = None
    ): DeleteBotResponse =
      DeleteBotResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botStatus)(_.botStatus(_))
        .build

    def deleteBotVersionRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      skipResourceInUseCheck: Option[Boolean] = None
    ): DeleteBotVersionRequest =
      DeleteBotVersionRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(skipResourceInUseCheck)(_.skipResourceInUseCheck(_))
        .build

    def deleteBotVersionResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      botStatus: Option[String] = None
    ): DeleteBotVersionResponse =
      DeleteBotVersionResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botStatus)(_.botStatus(_))
        .build

    def deleteExportRequest(
      exportId: Option[String] = None
    ): DeleteExportRequest =
      DeleteExportRequest
        .builder
        .ifSome(exportId)(_.exportId(_))
        .build

    def deleteExportResponse(
      exportId: Option[String] = None,
      exportStatus: Option[String] = None
    ): DeleteExportResponse =
      DeleteExportResponse
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .build

    def deleteImportRequest(
      importId: Option[String] = None
    ): DeleteImportRequest =
      DeleteImportRequest
        .builder
        .ifSome(importId)(_.importId(_))
        .build

    def deleteImportResponse(
      importId: Option[String] = None,
      importStatus: Option[String] = None
    ): DeleteImportResponse =
      DeleteImportResponse
        .builder
        .ifSome(importId)(_.importId(_))
        .ifSome(importStatus)(_.importStatus(_))
        .build

    def deleteIntentRequest(
      intentId: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): DeleteIntentRequest =
      DeleteIntentRequest
        .builder
        .ifSome(intentId)(_.intentId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def deleteResourcePolicyRequest(
      resourceArn: Option[String] = None,
      expectedRevisionId: Option[String] = None
    ): DeleteResourcePolicyRequest =
      DeleteResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(expectedRevisionId)(_.expectedRevisionId(_))
        .build

    def deleteResourcePolicyResponse(
      resourceArn: Option[String] = None,
      revisionId: Option[String] = None
    ): DeleteResourcePolicyResponse =
      DeleteResourcePolicyResponse
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def deleteResourcePolicyStatementRequest(
      resourceArn: Option[String] = None,
      statementId: Option[String] = None,
      expectedRevisionId: Option[String] = None
    ): DeleteResourcePolicyStatementRequest =
      DeleteResourcePolicyStatementRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(expectedRevisionId)(_.expectedRevisionId(_))
        .build

    def deleteResourcePolicyStatementResponse(
      resourceArn: Option[String] = None,
      revisionId: Option[String] = None
    ): DeleteResourcePolicyStatementResponse =
      DeleteResourcePolicyStatementResponse
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def deleteSlotRequest(
      slotId: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None
    ): DeleteSlotRequest =
      DeleteSlotRequest
        .builder
        .ifSome(slotId)(_.slotId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .build

    def deleteSlotTypeRequest(
      slotTypeId: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      skipResourceInUseCheck: Option[Boolean] = None
    ): DeleteSlotTypeRequest =
      DeleteSlotTypeRequest
        .builder
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(skipResourceInUseCheck)(_.skipResourceInUseCheck(_))
        .build

    def describeBotAliasRequest(
      botAliasId: Option[String] = None,
      botId: Option[String] = None
    ): DescribeBotAliasRequest =
      DescribeBotAliasRequest
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botId)(_.botId(_))
        .build

    def describeBotAliasResponse(
      botAliasId: Option[String] = None,
      botAliasName: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botAliasLocaleSettings: Option[BotAliasLocaleSettingsMap] = None,
      conversationLogSettings: Option[ConversationLogSettings] = None,
      sentimentAnalysisSettings: Option[SentimentAnalysisSettings] = None,
      botAliasHistoryEvents: Option[List[BotAliasHistoryEvent]] = None,
      botAliasStatus: Option[String] = None,
      botId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): DescribeBotAliasResponse =
      DescribeBotAliasResponse
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botAliasName)(_.botAliasName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botAliasLocaleSettings)(_.botAliasLocaleSettings(_))
        .ifSome(conversationLogSettings)(_.conversationLogSettings(_))
        .ifSome(sentimentAnalysisSettings)(_.sentimentAnalysisSettings(_))
        .ifSome(botAliasHistoryEvents)(_.botAliasHistoryEvents(_))
        .ifSome(botAliasStatus)(_.botAliasStatus(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def describeBotLocaleRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): DescribeBotLocaleRequest =
      DescribeBotLocaleRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def describeBotLocaleResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      localeName: Option[String] = None,
      description: Option[String] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      voiceSettings: Option[VoiceSettings] = None,
      intentsCount: Option[Int] = None,
      slotTypesCount: Option[Int] = None,
      botLocaleStatus: Option[String] = None,
      failureReasons: Option[List[FailureReason]] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None,
      lastBuildSubmittedDateTime: Option[Timestamp] = None,
      botLocaleHistoryEvents: Option[List[BotLocaleHistoryEvent]] = None
    ): DescribeBotLocaleResponse =
      DescribeBotLocaleResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(localeName)(_.localeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(voiceSettings)(_.voiceSettings(_))
        .ifSome(intentsCount)(_.intentsCount(_))
        .ifSome(slotTypesCount)(_.slotTypesCount(_))
        .ifSome(botLocaleStatus)(_.botLocaleStatus(_))
        .ifSome(failureReasons)(_.failureReasons(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(lastBuildSubmittedDateTime)(_.lastBuildSubmittedDateTime(_))
        .ifSome(botLocaleHistoryEvents)(_.botLocaleHistoryEvents(_))
        .build

    def describeBotRequest(
      botId: Option[String] = None
    ): DescribeBotRequest =
      DescribeBotRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .build

    def describeBotResponse(
      botId: Option[String] = None,
      botName: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      dataPrivacy: Option[DataPrivacy] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      botStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): DescribeBotResponse =
      DescribeBotResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPrivacy)(_.dataPrivacy(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(botStatus)(_.botStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def describeBotVersionRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None
    ): DescribeBotVersionRequest =
      DescribeBotVersionRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .build

    def describeBotVersionResponse(
      botId: Option[String] = None,
      botName: Option[String] = None,
      botVersion: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      dataPrivacy: Option[DataPrivacy] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      botStatus: Option[String] = None,
      failureReasons: Option[List[FailureReason]] = None,
      creationDateTime: Option[Timestamp] = None
    ): DescribeBotVersionResponse =
      DescribeBotVersionResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPrivacy)(_.dataPrivacy(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(botStatus)(_.botStatus(_))
        .ifSome(failureReasons)(_.failureReasons(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def describeExportRequest(
      exportId: Option[String] = None
    ): DescribeExportRequest =
      DescribeExportRequest
        .builder
        .ifSome(exportId)(_.exportId(_))
        .build

    def describeExportResponse(
      exportId: Option[String] = None,
      resourceSpecification: Option[ExportResourceSpecification] = None,
      fileFormat: Option[String] = None,
      exportStatus: Option[String] = None,
      failureReasons: Option[List[FailureReason]] = None,
      downloadUrl: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): DescribeExportResponse =
      DescribeExportResponse
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .ifSome(failureReasons)(_.failureReasons(_))
        .ifSome(downloadUrl)(_.downloadUrl(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def describeImportRequest(
      importId: Option[String] = None
    ): DescribeImportRequest =
      DescribeImportRequest
        .builder
        .ifSome(importId)(_.importId(_))
        .build

    def describeImportResponse(
      importId: Option[String] = None,
      resourceSpecification: Option[ImportResourceSpecification] = None,
      importedResourceId: Option[String] = None,
      importedResourceName: Option[String] = None,
      mergeStrategy: Option[String] = None,
      importStatus: Option[String] = None,
      failureReasons: Option[List[FailureReason]] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): DescribeImportResponse =
      DescribeImportResponse
        .builder
        .ifSome(importId)(_.importId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(importedResourceId)(_.importedResourceId(_))
        .ifSome(importedResourceName)(_.importedResourceName(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(importStatus)(_.importStatus(_))
        .ifSome(failureReasons)(_.failureReasons(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def describeIntentRequest(
      intentId: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): DescribeIntentRequest =
      DescribeIntentRequest
        .builder
        .ifSome(intentId)(_.intentId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def describeIntentResponse(
      intentId: Option[String] = None,
      intentName: Option[String] = None,
      description: Option[String] = None,
      parentIntentSignature: Option[String] = None,
      sampleUtterances: Option[List[SampleUtterance]] = None,
      dialogCodeHook: Option[DialogCodeHookSettings] = None,
      fulfillmentCodeHook: Option[FulfillmentCodeHookSettings] = None,
      slotPriorities: Option[List[SlotPriority]] = None,
      intentConfirmationSetting: Option[IntentConfirmationSetting] = None,
      intentClosingSetting: Option[IntentClosingSetting] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): DescribeIntentResponse =
      DescribeIntentResponse
        .builder
        .ifSome(intentId)(_.intentId(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentCodeHook)(_.fulfillmentCodeHook(_))
        .ifSome(slotPriorities)(_.slotPriorities(_))
        .ifSome(intentConfirmationSetting)(_.intentConfirmationSetting(_))
        .ifSome(intentClosingSetting)(_.intentClosingSetting(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def describeResourcePolicyRequest(
      resourceArn: Option[String] = None
    ): DescribeResourcePolicyRequest =
      DescribeResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeResourcePolicyResponse(
      resourceArn: Option[String] = None,
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): DescribeResourcePolicyResponse =
      DescribeResourcePolicyResponse
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def describeSlotRequest(
      slotId: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None
    ): DescribeSlotRequest =
      DescribeSlotRequest
        .builder
        .ifSome(slotId)(_.slotId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .build

    def describeSlotResponse(
      slotId: Option[String] = None,
      slotName: Option[String] = None,
      description: Option[String] = None,
      slotTypeId: Option[String] = None,
      valueElicitationSetting: Option[SlotValueElicitationSetting] = None,
      obfuscationSetting: Option[ObfuscationSetting] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None,
      multipleValuesSetting: Option[MultipleValuesSetting] = None
    ): DescribeSlotResponse =
      DescribeSlotResponse
        .builder
        .ifSome(slotId)(_.slotId(_))
        .ifSome(slotName)(_.slotName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(valueElicitationSetting)(_.valueElicitationSetting(_))
        .ifSome(obfuscationSetting)(_.obfuscationSetting(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(multipleValuesSetting)(_.multipleValuesSetting(_))
        .build

    def describeSlotTypeRequest(
      slotTypeId: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): DescribeSlotTypeRequest =
      DescribeSlotTypeRequest
        .builder
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def describeSlotTypeResponse(
      slotTypeId: Option[String] = None,
      slotTypeName: Option[String] = None,
      description: Option[String] = None,
      slotTypeValues: Option[List[SlotTypeValue]] = None,
      valueSelectionSetting: Option[SlotValueSelectionSetting] = None,
      parentSlotTypeSignature: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): DescribeSlotTypeResponse =
      DescribeSlotTypeResponse
        .builder
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(slotTypeName)(_.slotTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeValues)(_.slotTypeValues(_))
        .ifSome(valueSelectionSetting)(_.valueSelectionSetting(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def dialogCodeHookSettings(
      enabled: Option[Boolean] = None
    ): DialogCodeHookSettings =
      DialogCodeHookSettings
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def exportFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      operator: Option[String] = None
    ): ExportFilter =
      ExportFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def exportResourceSpecification(
      botExportSpecification: Option[BotExportSpecification] = None,
      botLocaleExportSpecification: Option[BotLocaleExportSpecification] = None
    ): ExportResourceSpecification =
      ExportResourceSpecification
        .builder
        .ifSome(botExportSpecification)(_.botExportSpecification(_))
        .ifSome(botLocaleExportSpecification)(_.botLocaleExportSpecification(_))
        .build

    def exportSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): ExportSortBy =
      ExportSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def exportSummary(
      exportId: Option[String] = None,
      resourceSpecification: Option[ExportResourceSpecification] = None,
      fileFormat: Option[String] = None,
      exportStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): ExportSummary =
      ExportSummary
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def fulfillmentCodeHookSettings(
      enabled: Option[Boolean] = None
    ): FulfillmentCodeHookSettings =
      FulfillmentCodeHookSettings
        .builder
        .ifSome(enabled)(_.enabled(_))
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

    def importFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      operator: Option[String] = None
    ): ImportFilter =
      ImportFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def importResourceSpecification(
      botImportSpecification: Option[BotImportSpecification] = None,
      botLocaleImportSpecification: Option[BotLocaleImportSpecification] = None
    ): ImportResourceSpecification =
      ImportResourceSpecification
        .builder
        .ifSome(botImportSpecification)(_.botImportSpecification(_))
        .ifSome(botLocaleImportSpecification)(_.botLocaleImportSpecification(_))
        .build

    def importSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): ImportSortBy =
      ImportSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def importSummary(
      importId: Option[String] = None,
      importedResourceId: Option[String] = None,
      importedResourceName: Option[String] = None,
      importStatus: Option[String] = None,
      mergeStrategy: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): ImportSummary =
      ImportSummary
        .builder
        .ifSome(importId)(_.importId(_))
        .ifSome(importedResourceId)(_.importedResourceId(_))
        .ifSome(importedResourceName)(_.importedResourceName(_))
        .ifSome(importStatus)(_.importStatus(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def inputContext(
      name: Option[String] = None
    ): InputContext =
      InputContext
        .builder
        .ifSome(name)(_.name(_))
        .build

    def intentClosingSetting(
      closingResponse: Option[ResponseSpecification] = None
    ): IntentClosingSetting =
      IntentClosingSetting
        .builder
        .ifSome(closingResponse)(_.closingResponse(_))
        .build

    def intentConfirmationSetting(
      promptSpecification: Option[PromptSpecification] = None,
      declinationResponse: Option[ResponseSpecification] = None
    ): IntentConfirmationSetting =
      IntentConfirmationSetting
        .builder
        .ifSome(promptSpecification)(_.promptSpecification(_))
        .ifSome(declinationResponse)(_.declinationResponse(_))
        .build

    def intentFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      operator: Option[String] = None
    ): IntentFilter =
      IntentFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def intentSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): IntentSortBy =
      IntentSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def intentSummary(
      intentId: Option[String] = None,
      intentName: Option[String] = None,
      description: Option[String] = None,
      parentIntentSignature: Option[String] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): IntentSummary =
      IntentSummary
        .builder
        .ifSome(intentId)(_.intentId(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kendraConfiguration(
      kendraIndex: Option[String] = None,
      queryFilterStringEnabled: Option[Boolean] = None,
      queryFilterString: Option[String] = None
    ): KendraConfiguration =
      KendraConfiguration
        .builder
        .ifSome(kendraIndex)(_.kendraIndex(_))
        .ifSome(queryFilterStringEnabled)(_.queryFilterStringEnabled(_))
        .ifSome(queryFilterString)(_.queryFilterString(_))
        .build

    def lambdaCodeHook(
      lambdaARN: Option[String] = None,
      codeHookInterfaceVersion: Option[String] = None
    ): LambdaCodeHook =
      LambdaCodeHook
        .builder
        .ifSome(lambdaARN)(_.lambdaARN(_))
        .ifSome(codeHookInterfaceVersion)(_.codeHookInterfaceVersion(_))
        .build

    def listBotAliasesRequest(
      botId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBotAliasesRequest =
      ListBotAliasesRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotAliasesResponse(
      botAliasSummaries: Option[List[BotAliasSummary]] = None,
      nextToken: Option[String] = None,
      botId: Option[String] = None
    ): ListBotAliasesResponse =
      ListBotAliasesResponse
        .builder
        .ifSome(botAliasSummaries)(_.botAliasSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(botId)(_.botId(_))
        .build

    def listBotLocalesRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      sortBy: Option[BotLocaleSortBy] = None,
      filters: Option[List[BotLocaleFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBotLocalesRequest =
      ListBotLocalesRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotLocalesResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      nextToken: Option[String] = None,
      botLocaleSummaries: Option[List[BotLocaleSummary]] = None
    ): ListBotLocalesResponse =
      ListBotLocalesResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(botLocaleSummaries)(_.botLocaleSummaries(_))
        .build

    def listBotVersionsRequest(
      botId: Option[String] = None,
      sortBy: Option[BotVersionSortBy] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBotVersionsRequest =
      ListBotVersionsRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotVersionsResponse(
      botId: Option[String] = None,
      botVersionSummaries: Option[List[BotVersionSummary]] = None,
      nextToken: Option[String] = None
    ): ListBotVersionsResponse =
      ListBotVersionsResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersionSummaries)(_.botVersionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotsRequest(
      sortBy: Option[BotSortBy] = None,
      filters: Option[List[BotFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBotsRequest =
      ListBotsRequest
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotsResponse(
      botSummaries: Option[List[BotSummary]] = None,
      nextToken: Option[String] = None
    ): ListBotsResponse =
      ListBotsResponse
        .builder
        .ifSome(botSummaries)(_.botSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuiltInIntentsRequest(
      localeId: Option[String] = None,
      sortBy: Option[BuiltInIntentSortBy] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBuiltInIntentsRequest =
      ListBuiltInIntentsRequest
        .builder
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuiltInIntentsResponse(
      builtInIntentSummaries: Option[List[BuiltInIntentSummary]] = None,
      nextToken: Option[String] = None,
      localeId: Option[String] = None
    ): ListBuiltInIntentsResponse =
      ListBuiltInIntentsResponse
        .builder
        .ifSome(builtInIntentSummaries)(_.builtInIntentSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def listBuiltInSlotTypesRequest(
      localeId: Option[String] = None,
      sortBy: Option[BuiltInSlotTypeSortBy] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBuiltInSlotTypesRequest =
      ListBuiltInSlotTypesRequest
        .builder
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuiltInSlotTypesResponse(
      builtInSlotTypeSummaries: Option[List[BuiltInSlotTypeSummary]] = None,
      nextToken: Option[String] = None,
      localeId: Option[String] = None
    ): ListBuiltInSlotTypesResponse =
      ListBuiltInSlotTypesResponse
        .builder
        .ifSome(builtInSlotTypeSummaries)(_.builtInSlotTypeSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def listExportsRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      sortBy: Option[ExportSortBy] = None,
      filters: Option[List[ExportFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListExportsRequest =
      ListExportsRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExportsResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      exportSummaries: Option[List[ExportSummary]] = None,
      nextToken: Option[String] = None
    ): ListExportsResponse =
      ListExportsResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(exportSummaries)(_.exportSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImportsRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      sortBy: Option[ImportSortBy] = None,
      filters: Option[List[ImportFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListImportsRequest =
      ListImportsRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImportsResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      importSummaries: Option[List[ImportSummary]] = None,
      nextToken: Option[String] = None
    ): ListImportsResponse =
      ListImportsResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(importSummaries)(_.importSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIntentsRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      sortBy: Option[IntentSortBy] = None,
      filters: Option[List[IntentFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListIntentsRequest =
      ListIntentsRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIntentsResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentSummaries: Option[List[IntentSummary]] = None,
      nextToken: Option[String] = None
    ): ListIntentsResponse =
      ListIntentsResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentSummaries)(_.intentSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSlotTypesRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      sortBy: Option[SlotTypeSortBy] = None,
      filters: Option[List[SlotTypeFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSlotTypesRequest =
      ListSlotTypesRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSlotTypesResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      slotTypeSummaries: Option[List[SlotTypeSummary]] = None,
      nextToken: Option[String] = None
    ): ListSlotTypesResponse =
      ListSlotTypesResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(slotTypeSummaries)(_.slotTypeSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSlotsRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None,
      sortBy: Option[SlotSortBy] = None,
      filters: Option[List[SlotFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSlotsRequest =
      ListSlotsRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSlotsResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None,
      slotSummaries: Option[List[SlotSummary]] = None,
      nextToken: Option[String] = None
    ): ListSlotsResponse =
      ListSlotsResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .ifSome(slotSummaries)(_.slotSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def message(
      plainTextMessage: Option[PlainTextMessage] = None,
      customPayload: Option[CustomPayload] = None,
      ssmlMessage: Option[SSMLMessage] = None,
      imageResponseCard: Option[ImageResponseCard] = None
    ): Message =
      Message
        .builder
        .ifSome(plainTextMessage)(_.plainTextMessage(_))
        .ifSome(customPayload)(_.customPayload(_))
        .ifSome(ssmlMessage)(_.ssmlMessage(_))
        .ifSome(imageResponseCard)(_.imageResponseCard(_))
        .build

    def messageGroup(
      message: Option[Message] = None,
      variations: Option[List[Message]] = None
    ): MessageGroup =
      MessageGroup
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(variations)(_.variations(_))
        .build

    def multipleValuesSetting(
      allowMultipleValues: Option[Boolean] = None
    ): MultipleValuesSetting =
      MultipleValuesSetting
        .builder
        .ifSome(allowMultipleValues)(_.allowMultipleValues(_))
        .build

    def obfuscationSetting(
      obfuscationSettingType: Option[String] = None
    ): ObfuscationSetting =
      ObfuscationSetting
        .builder
        .ifSome(obfuscationSettingType)(_.obfuscationSettingType(_))
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

    def plainTextMessage(
      value: Option[String] = None
    ): PlainTextMessage =
      PlainTextMessage
        .builder
        .ifSome(value)(_.value(_))
        .build

    def preconditionFailedException(
      message: Option[String] = None
    ): PreconditionFailedException =
      PreconditionFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def principal(
      service: Option[String] = None,
      arn: Option[String] = None
    ): Principal =
      Principal
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(arn)(_.arn(_))
        .build

    def promptSpecification(
      messageGroups: Option[List[MessageGroup]] = None,
      maxRetries: Option[Int] = None,
      allowInterrupt: Option[Boolean] = None
    ): PromptSpecification =
      PromptSpecification
        .builder
        .ifSome(messageGroups)(_.messageGroups(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(allowInterrupt)(_.allowInterrupt(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def responseSpecification(
      messageGroups: Option[List[MessageGroup]] = None,
      allowInterrupt: Option[Boolean] = None
    ): ResponseSpecification =
      ResponseSpecification
        .builder
        .ifSome(messageGroups)(_.messageGroups(_))
        .ifSome(allowInterrupt)(_.allowInterrupt(_))
        .build

    def s3BucketLogDestination(
      kmsKeyArn: Option[String] = None,
      s3BucketArn: Option[String] = None,
      logPrefix: Option[String] = None
    ): S3BucketLogDestination =
      S3BucketLogDestination
        .builder
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(s3BucketArn)(_.s3BucketArn(_))
        .ifSome(logPrefix)(_.logPrefix(_))
        .build

    def sSMLMessage(
      value: Option[String] = None
    ): SSMLMessage =
      SSMLMessage
        .builder
        .ifSome(value)(_.value(_))
        .build

    def sampleUtterance(
      utterance: Option[String] = None
    ): SampleUtterance =
      SampleUtterance
        .builder
        .ifSome(utterance)(_.utterance(_))
        .build

    def sampleValue(
      value: Option[String] = None
    ): SampleValue =
      SampleValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def sentimentAnalysisSettings(
      detectSentiment: Option[Boolean] = None
    ): SentimentAnalysisSettings =
      SentimentAnalysisSettings
        .builder
        .ifSome(detectSentiment)(_.detectSentiment(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def slotDefaultValue(
      defaultValue: Option[String] = None
    ): SlotDefaultValue =
      SlotDefaultValue
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def slotDefaultValueSpecification(
      defaultValueList: Option[List[SlotDefaultValue]] = None
    ): SlotDefaultValueSpecification =
      SlotDefaultValueSpecification
        .builder
        .ifSome(defaultValueList)(_.defaultValueList(_))
        .build

    def slotFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      operator: Option[String] = None
    ): SlotFilter =
      SlotFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def slotPriority(
      priority: Option[Int] = None,
      slotId: Option[String] = None
    ): SlotPriority =
      SlotPriority
        .builder
        .ifSome(priority)(_.priority(_))
        .ifSome(slotId)(_.slotId(_))
        .build

    def slotSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): SlotSortBy =
      SlotSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def slotSummary(
      slotId: Option[String] = None,
      slotName: Option[String] = None,
      description: Option[String] = None,
      slotConstraint: Option[String] = None,
      slotTypeId: Option[String] = None,
      valueElicitationPromptSpecification: Option[PromptSpecification] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): SlotSummary =
      SlotSummary
        .builder
        .ifSome(slotId)(_.slotId(_))
        .ifSome(slotName)(_.slotName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotConstraint)(_.slotConstraint(_))
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(valueElicitationPromptSpecification)(_.valueElicitationPromptSpecification(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def slotTypeFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      operator: Option[String] = None
    ): SlotTypeFilter =
      SlotTypeFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def slotTypeSortBy(
      attribute: Option[String] = None,
      order: Option[String] = None
    ): SlotTypeSortBy =
      SlotTypeSortBy
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(order)(_.order(_))
        .build

    def slotTypeSummary(
      slotTypeId: Option[String] = None,
      slotTypeName: Option[String] = None,
      description: Option[String] = None,
      parentSlotTypeSignature: Option[String] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): SlotTypeSummary =
      SlotTypeSummary
        .builder
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(slotTypeName)(_.slotTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def slotTypeValue(
      sampleValue: Option[SampleValue] = None,
      synonyms: Option[List[SampleValue]] = None
    ): SlotTypeValue =
      SlotTypeValue
        .builder
        .ifSome(sampleValue)(_.sampleValue(_))
        .ifSome(synonyms)(_.synonyms(_))
        .build

    def slotValueElicitationSetting(
      defaultValueSpecification: Option[SlotDefaultValueSpecification] = None,
      slotConstraint: Option[String] = None,
      promptSpecification: Option[PromptSpecification] = None,
      sampleUtterances: Option[List[SampleUtterance]] = None,
      waitAndContinueSpecification: Option[WaitAndContinueSpecification] = None
    ): SlotValueElicitationSetting =
      SlotValueElicitationSetting
        .builder
        .ifSome(defaultValueSpecification)(_.defaultValueSpecification(_))
        .ifSome(slotConstraint)(_.slotConstraint(_))
        .ifSome(promptSpecification)(_.promptSpecification(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(waitAndContinueSpecification)(_.waitAndContinueSpecification(_))
        .build

    def slotValueRegexFilter(
      pattern: Option[String] = None
    ): SlotValueRegexFilter =
      SlotValueRegexFilter
        .builder
        .ifSome(pattern)(_.pattern(_))
        .build

    def slotValueSelectionSetting(
      resolutionStrategy: Option[String] = None,
      regexFilter: Option[SlotValueRegexFilter] = None
    ): SlotValueSelectionSetting =
      SlotValueSelectionSetting
        .builder
        .ifSome(resolutionStrategy)(_.resolutionStrategy(_))
        .ifSome(regexFilter)(_.regexFilter(_))
        .build

    def startImportRequest(
      importId: Option[String] = None,
      resourceSpecification: Option[ImportResourceSpecification] = None,
      mergeStrategy: Option[String] = None,
      filePassword: Option[String] = None
    ): StartImportRequest =
      StartImportRequest
        .builder
        .ifSome(importId)(_.importId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(filePassword)(_.filePassword(_))
        .build

    def startImportResponse(
      importId: Option[String] = None,
      resourceSpecification: Option[ImportResourceSpecification] = None,
      mergeStrategy: Option[String] = None,
      importStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): StartImportResponse =
      StartImportResponse
        .builder
        .ifSome(importId)(_.importId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(importStatus)(_.importStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def stillWaitingResponseSpecification(
      messageGroups: Option[List[MessageGroup]] = None,
      frequencyInSeconds: Option[Int] = None,
      timeoutInSeconds: Option[Int] = None,
      allowInterrupt: Option[Boolean] = None
    ): StillWaitingResponseSpecification =
      StillWaitingResponseSpecification
        .builder
        .ifSome(messageGroups)(_.messageGroups(_))
        .ifSome(frequencyInSeconds)(_.frequencyInSeconds(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(allowInterrupt)(_.allowInterrupt(_))
        .build

    def tagResourceRequest(
      resourceARN: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def textLogDestination(
      cloudWatch: Option[CloudWatchLogGroupLogDestination] = None
    ): TextLogDestination =
      TextLogDestination
        .builder
        .ifSome(cloudWatch)(_.cloudWatch(_))
        .build

    def textLogSetting(
      enabled: Option[Boolean] = None,
      destination: Option[TextLogDestination] = None
    ): TextLogSetting =
      TextLogSetting
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(destination)(_.destination(_))
        .build

    def throttlingException(
      retryAfterSeconds: Option[Int] = None,
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateBotAliasRequest(
      botAliasId: Option[String] = None,
      botAliasName: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botAliasLocaleSettings: Option[BotAliasLocaleSettingsMap] = None,
      conversationLogSettings: Option[ConversationLogSettings] = None,
      sentimentAnalysisSettings: Option[SentimentAnalysisSettings] = None,
      botId: Option[String] = None
    ): UpdateBotAliasRequest =
      UpdateBotAliasRequest
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botAliasName)(_.botAliasName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botAliasLocaleSettings)(_.botAliasLocaleSettings(_))
        .ifSome(conversationLogSettings)(_.conversationLogSettings(_))
        .ifSome(sentimentAnalysisSettings)(_.sentimentAnalysisSettings(_))
        .ifSome(botId)(_.botId(_))
        .build

    def updateBotAliasResponse(
      botAliasId: Option[String] = None,
      botAliasName: Option[String] = None,
      description: Option[String] = None,
      botVersion: Option[String] = None,
      botAliasLocaleSettings: Option[BotAliasLocaleSettingsMap] = None,
      conversationLogSettings: Option[ConversationLogSettings] = None,
      sentimentAnalysisSettings: Option[SentimentAnalysisSettings] = None,
      botAliasStatus: Option[String] = None,
      botId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): UpdateBotAliasResponse =
      UpdateBotAliasResponse
        .builder
        .ifSome(botAliasId)(_.botAliasId(_))
        .ifSome(botAliasName)(_.botAliasName(_))
        .ifSome(description)(_.description(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(botAliasLocaleSettings)(_.botAliasLocaleSettings(_))
        .ifSome(conversationLogSettings)(_.conversationLogSettings(_))
        .ifSome(sentimentAnalysisSettings)(_.sentimentAnalysisSettings(_))
        .ifSome(botAliasStatus)(_.botAliasStatus(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def updateBotLocaleRequest(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      description: Option[String] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      voiceSettings: Option[VoiceSettings] = None
    ): UpdateBotLocaleRequest =
      UpdateBotLocaleRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(description)(_.description(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(voiceSettings)(_.voiceSettings(_))
        .build

    def updateBotLocaleResponse(
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      localeName: Option[String] = None,
      description: Option[String] = None,
      nluIntentConfidenceThreshold: Option[ConfidenceThreshold] = None,
      voiceSettings: Option[VoiceSettings] = None,
      botLocaleStatus: Option[String] = None,
      failureReasons: Option[List[FailureReason]] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): UpdateBotLocaleResponse =
      UpdateBotLocaleResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(localeName)(_.localeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(nluIntentConfidenceThreshold)(_.nluIntentConfidenceThreshold(_))
        .ifSome(voiceSettings)(_.voiceSettings(_))
        .ifSome(botLocaleStatus)(_.botLocaleStatus(_))
        .ifSome(failureReasons)(_.failureReasons(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def updateBotRequest(
      botId: Option[String] = None,
      botName: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      dataPrivacy: Option[DataPrivacy] = None,
      idleSessionTTLInSeconds: Option[Int] = None
    ): UpdateBotRequest =
      UpdateBotRequest
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPrivacy)(_.dataPrivacy(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .build

    def updateBotResponse(
      botId: Option[String] = None,
      botName: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      dataPrivacy: Option[DataPrivacy] = None,
      idleSessionTTLInSeconds: Option[Int] = None,
      botStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): UpdateBotResponse =
      UpdateBotResponse
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPrivacy)(_.dataPrivacy(_))
        .ifSome(idleSessionTTLInSeconds)(_.idleSessionTTLInSeconds(_))
        .ifSome(botStatus)(_.botStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def updateExportRequest(
      exportId: Option[String] = None,
      filePassword: Option[String] = None
    ): UpdateExportRequest =
      UpdateExportRequest
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(filePassword)(_.filePassword(_))
        .build

    def updateExportResponse(
      exportId: Option[String] = None,
      resourceSpecification: Option[ExportResourceSpecification] = None,
      fileFormat: Option[String] = None,
      exportStatus: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): UpdateExportResponse =
      UpdateExportResponse
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def updateIntentRequest(
      intentId: Option[String] = None,
      intentName: Option[String] = None,
      description: Option[String] = None,
      parentIntentSignature: Option[String] = None,
      sampleUtterances: Option[List[SampleUtterance]] = None,
      dialogCodeHook: Option[DialogCodeHookSettings] = None,
      fulfillmentCodeHook: Option[FulfillmentCodeHookSettings] = None,
      slotPriorities: Option[List[SlotPriority]] = None,
      intentConfirmationSetting: Option[IntentConfirmationSetting] = None,
      intentClosingSetting: Option[IntentClosingSetting] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): UpdateIntentRequest =
      UpdateIntentRequest
        .builder
        .ifSome(intentId)(_.intentId(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentCodeHook)(_.fulfillmentCodeHook(_))
        .ifSome(slotPriorities)(_.slotPriorities(_))
        .ifSome(intentConfirmationSetting)(_.intentConfirmationSetting(_))
        .ifSome(intentClosingSetting)(_.intentClosingSetting(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def updateIntentResponse(
      intentId: Option[String] = None,
      intentName: Option[String] = None,
      description: Option[String] = None,
      parentIntentSignature: Option[String] = None,
      sampleUtterances: Option[List[SampleUtterance]] = None,
      dialogCodeHook: Option[DialogCodeHookSettings] = None,
      fulfillmentCodeHook: Option[FulfillmentCodeHookSettings] = None,
      slotPriorities: Option[List[SlotPriority]] = None,
      intentConfirmationSetting: Option[IntentConfirmationSetting] = None,
      intentClosingSetting: Option[IntentClosingSetting] = None,
      inputContexts: Option[List[InputContext]] = None,
      outputContexts: Option[List[OutputContext]] = None,
      kendraConfiguration: Option[KendraConfiguration] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): UpdateIntentResponse =
      UpdateIntentResponse
        .builder
        .ifSome(intentId)(_.intentId(_))
        .ifSome(intentName)(_.intentName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parentIntentSignature)(_.parentIntentSignature(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(dialogCodeHook)(_.dialogCodeHook(_))
        .ifSome(fulfillmentCodeHook)(_.fulfillmentCodeHook(_))
        .ifSome(slotPriorities)(_.slotPriorities(_))
        .ifSome(intentConfirmationSetting)(_.intentConfirmationSetting(_))
        .ifSome(intentClosingSetting)(_.intentClosingSetting(_))
        .ifSome(inputContexts)(_.inputContexts(_))
        .ifSome(outputContexts)(_.outputContexts(_))
        .ifSome(kendraConfiguration)(_.kendraConfiguration(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def updateResourcePolicyRequest(
      resourceArn: Option[String] = None,
      policy: Option[String] = None,
      expectedRevisionId: Option[String] = None
    ): UpdateResourcePolicyRequest =
      UpdateResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(expectedRevisionId)(_.expectedRevisionId(_))
        .build

    def updateResourcePolicyResponse(
      resourceArn: Option[String] = None,
      revisionId: Option[String] = None
    ): UpdateResourcePolicyResponse =
      UpdateResourcePolicyResponse
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def updateSlotRequest(
      slotId: Option[String] = None,
      slotName: Option[String] = None,
      description: Option[String] = None,
      slotTypeId: Option[String] = None,
      valueElicitationSetting: Option[SlotValueElicitationSetting] = None,
      obfuscationSetting: Option[ObfuscationSetting] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None,
      multipleValuesSetting: Option[MultipleValuesSetting] = None
    ): UpdateSlotRequest =
      UpdateSlotRequest
        .builder
        .ifSome(slotId)(_.slotId(_))
        .ifSome(slotName)(_.slotName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(valueElicitationSetting)(_.valueElicitationSetting(_))
        .ifSome(obfuscationSetting)(_.obfuscationSetting(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .ifSome(multipleValuesSetting)(_.multipleValuesSetting(_))
        .build

    def updateSlotResponse(
      slotId: Option[String] = None,
      slotName: Option[String] = None,
      description: Option[String] = None,
      slotTypeId: Option[String] = None,
      valueElicitationSetting: Option[SlotValueElicitationSetting] = None,
      obfuscationSetting: Option[ObfuscationSetting] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      intentId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None,
      multipleValuesSetting: Option[MultipleValuesSetting] = None
    ): UpdateSlotResponse =
      UpdateSlotResponse
        .builder
        .ifSome(slotId)(_.slotId(_))
        .ifSome(slotName)(_.slotName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(valueElicitationSetting)(_.valueElicitationSetting(_))
        .ifSome(obfuscationSetting)(_.obfuscationSetting(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(intentId)(_.intentId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(multipleValuesSetting)(_.multipleValuesSetting(_))
        .build

    def updateSlotTypeRequest(
      slotTypeId: Option[String] = None,
      slotTypeName: Option[String] = None,
      description: Option[String] = None,
      slotTypeValues: Option[List[SlotTypeValue]] = None,
      valueSelectionSetting: Option[SlotValueSelectionSetting] = None,
      parentSlotTypeSignature: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None
    ): UpdateSlotTypeRequest =
      UpdateSlotTypeRequest
        .builder
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(slotTypeName)(_.slotTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeValues)(_.slotTypeValues(_))
        .ifSome(valueSelectionSetting)(_.valueSelectionSetting(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .build

    def updateSlotTypeResponse(
      slotTypeId: Option[String] = None,
      slotTypeName: Option[String] = None,
      description: Option[String] = None,
      slotTypeValues: Option[List[SlotTypeValue]] = None,
      valueSelectionSetting: Option[SlotValueSelectionSetting] = None,
      parentSlotTypeSignature: Option[String] = None,
      botId: Option[String] = None,
      botVersion: Option[String] = None,
      localeId: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      lastUpdatedDateTime: Option[Timestamp] = None
    ): UpdateSlotTypeResponse =
      UpdateSlotTypeResponse
        .builder
        .ifSome(slotTypeId)(_.slotTypeId(_))
        .ifSome(slotTypeName)(_.slotTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(slotTypeValues)(_.slotTypeValues(_))
        .ifSome(valueSelectionSetting)(_.valueSelectionSetting(_))
        .ifSome(parentSlotTypeSignature)(_.parentSlotTypeSignature(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(botVersion)(_.botVersion(_))
        .ifSome(localeId)(_.localeId(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def voiceSettings(
      voiceId: Option[String] = None
    ): VoiceSettings =
      VoiceSettings
        .builder
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def waitAndContinueSpecification(
      waitingResponse: Option[ResponseSpecification] = None,
      continueResponse: Option[ResponseSpecification] = None,
      stillWaitingResponse: Option[StillWaitingResponseSpecification] = None
    ): WaitAndContinueSpecification =
      WaitAndContinueSpecification
        .builder
        .ifSome(waitingResponse)(_.waitingResponse(_))
        .ifSome(continueResponse)(_.continueResponse(_))
        .ifSome(stillWaitingResponse)(_.stillWaitingResponse(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
