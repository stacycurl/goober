package goober.hi

import goober.free.iotevents.IotEventsIO
import software.amazon.awssdk.services.iotevents.model._


object iotevents {
  import goober.free.{iotevents ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acknowledgeFlow(
      enabled: Option[Boolean] = None
    ): AcknowledgeFlow =
      AcknowledgeFlow
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def action(
      setVariable: Option[SetVariableAction] = None,
      sns: Option[SNSTopicPublishAction] = None,
      iotTopicPublish: Option[IotTopicPublishAction] = None,
      setTimer: Option[SetTimerAction] = None,
      clearTimer: Option[ClearTimerAction] = None,
      resetTimer: Option[ResetTimerAction] = None,
      lambda: Option[LambdaAction] = None,
      iotEvents: Option[IotEventsAction] = None,
      sqs: Option[SqsAction] = None,
      firehose: Option[FirehoseAction] = None,
      dynamoDB: Option[DynamoDBAction] = None,
      dynamoDBv2: Option[DynamoDBv2Action] = None,
      iotSiteWise: Option[IotSiteWiseAction] = None
    ): Action =
      Action
        .builder
        .ifSome(setVariable)(_.setVariable(_))
        .ifSome(sns)(_.sns(_))
        .ifSome(iotTopicPublish)(_.iotTopicPublish(_))
        .ifSome(setTimer)(_.setTimer(_))
        .ifSome(clearTimer)(_.clearTimer(_))
        .ifSome(resetTimer)(_.resetTimer(_))
        .ifSome(lambda)(_.lambda(_))
        .ifSome(iotEvents)(_.iotEvents(_))
        .ifSome(sqs)(_.sqs(_))
        .ifSome(firehose)(_.firehose(_))
        .ifSome(dynamoDB)(_.dynamoDB(_))
        .ifSome(dynamoDBv2)(_.dynamoDBv2(_))
        .ifSome(iotSiteWise)(_.iotSiteWise(_))
        .build

    def alarmAction(
      sns: Option[SNSTopicPublishAction] = None,
      iotTopicPublish: Option[IotTopicPublishAction] = None,
      lambda: Option[LambdaAction] = None,
      iotEvents: Option[IotEventsAction] = None,
      sqs: Option[SqsAction] = None,
      firehose: Option[FirehoseAction] = None,
      dynamoDB: Option[DynamoDBAction] = None,
      dynamoDBv2: Option[DynamoDBv2Action] = None,
      iotSiteWise: Option[IotSiteWiseAction] = None
    ): AlarmAction =
      AlarmAction
        .builder
        .ifSome(sns)(_.sns(_))
        .ifSome(iotTopicPublish)(_.iotTopicPublish(_))
        .ifSome(lambda)(_.lambda(_))
        .ifSome(iotEvents)(_.iotEvents(_))
        .ifSome(sqs)(_.sqs(_))
        .ifSome(firehose)(_.firehose(_))
        .ifSome(dynamoDB)(_.dynamoDB(_))
        .ifSome(dynamoDBv2)(_.dynamoDBv2(_))
        .ifSome(iotSiteWise)(_.iotSiteWise(_))
        .build

    def alarmCapabilities(
      initializationConfiguration: Option[InitializationConfiguration] = None,
      acknowledgeFlow: Option[AcknowledgeFlow] = None
    ): AlarmCapabilities =
      AlarmCapabilities
        .builder
        .ifSome(initializationConfiguration)(_.initializationConfiguration(_))
        .ifSome(acknowledgeFlow)(_.acknowledgeFlow(_))
        .build

    def alarmEventActions(
      alarmActions: Option[List[AlarmAction]] = None
    ): AlarmEventActions =
      AlarmEventActions
        .builder
        .ifSome(alarmActions)(_.alarmActions(_))
        .build

    def alarmModelSummary(
      creationTime: Option[Timestamp] = None,
      alarmModelDescription: Option[String] = None,
      alarmModelName: Option[String] = None
    ): AlarmModelSummary =
      AlarmModelSummary
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(alarmModelDescription)(_.alarmModelDescription(_))
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .build

    def alarmModelVersionSummary(
      alarmModelName: Option[String] = None,
      alarmModelArn: Option[String] = None,
      alarmModelVersion: Option[String] = None,
      roleArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): AlarmModelVersionSummary =
      AlarmModelVersionSummary
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(alarmModelArn)(_.alarmModelArn(_))
        .ifSome(alarmModelVersion)(_.alarmModelVersion(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def alarmNotification(
      notificationActions: Option[List[NotificationAction]] = None
    ): AlarmNotification =
      AlarmNotification
        .builder
        .ifSome(notificationActions)(_.notificationActions(_))
        .build

    def alarmRule(
      simpleRule: Option[SimpleRule] = None
    ): AlarmRule =
      AlarmRule
        .builder
        .ifSome(simpleRule)(_.simpleRule(_))
        .build

    def analysisResultLocation(
      path: Option[String] = None
    ): AnalysisResultLocation =
      AnalysisResultLocation
        .builder
        .ifSome(path)(_.path(_))
        .build

    def assetPropertyTimestamp(
      timeInSeconds: Option[String] = None,
      offsetInNanos: Option[String] = None
    ): AssetPropertyTimestamp =
      AssetPropertyTimestamp
        .builder
        .ifSome(timeInSeconds)(_.timeInSeconds(_))
        .ifSome(offsetInNanos)(_.offsetInNanos(_))
        .build

    def assetPropertyValue(
      value: Option[AssetPropertyVariant] = None,
      timestamp: Option[AssetPropertyTimestamp] = None,
      quality: Option[String] = None
    ): AssetPropertyValue =
      AssetPropertyValue
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(quality)(_.quality(_))
        .build

    def assetPropertyVariant(
      stringValue: Option[String] = None,
      integerValue: Option[String] = None,
      doubleValue: Option[String] = None,
      booleanValue: Option[String] = None
    ): AssetPropertyVariant =
      AssetPropertyVariant
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(integerValue)(_.integerValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .build

    def attribute(
      jsonPath: Option[String] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(jsonPath)(_.jsonPath(_))
        .build

    def clearTimerAction(
      timerName: Option[String] = None
    ): ClearTimerAction =
      ClearTimerAction
        .builder
        .ifSome(timerName)(_.timerName(_))
        .build

    def createAlarmModelRequest(
      alarmModelName: Option[String] = None,
      alarmModelDescription: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      key: Option[String] = None,
      severity: Option[Int] = None,
      alarmRule: Option[AlarmRule] = None,
      alarmNotification: Option[AlarmNotification] = None,
      alarmEventActions: Option[AlarmEventActions] = None,
      alarmCapabilities: Option[AlarmCapabilities] = None
    ): CreateAlarmModelRequest =
      CreateAlarmModelRequest
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(alarmModelDescription)(_.alarmModelDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(key)(_.key(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(alarmRule)(_.alarmRule(_))
        .ifSome(alarmNotification)(_.alarmNotification(_))
        .ifSome(alarmEventActions)(_.alarmEventActions(_))
        .ifSome(alarmCapabilities)(_.alarmCapabilities(_))
        .build

    def createAlarmModelResponse(
      creationTime: Option[Timestamp] = None,
      alarmModelArn: Option[String] = None,
      alarmModelVersion: Option[String] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None
    ): CreateAlarmModelResponse =
      CreateAlarmModelResponse
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(alarmModelArn)(_.alarmModelArn(_))
        .ifSome(alarmModelVersion)(_.alarmModelVersion(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .build

    def createDetectorModelRequest(
      detectorModelName: Option[String] = None,
      detectorModelDefinition: Option[DetectorModelDefinition] = None,
      detectorModelDescription: Option[String] = None,
      key: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      evaluationMethod: Option[String] = None
    ): CreateDetectorModelRequest =
      CreateDetectorModelRequest
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(detectorModelDefinition)(_.detectorModelDefinition(_))
        .ifSome(detectorModelDescription)(_.detectorModelDescription(_))
        .ifSome(key)(_.key(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(evaluationMethod)(_.evaluationMethod(_))
        .build

    def createDetectorModelResponse(
      detectorModelConfiguration: Option[DetectorModelConfiguration] = None
    ): CreateDetectorModelResponse =
      CreateDetectorModelResponse
        .builder
        .ifSome(detectorModelConfiguration)(_.detectorModelConfiguration(_))
        .build

    def createInputRequest(
      inputName: Option[String] = None,
      inputDescription: Option[String] = None,
      inputDefinition: Option[InputDefinition] = None,
      tags: Option[List[Tag]] = None
    ): CreateInputRequest =
      CreateInputRequest
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(inputDescription)(_.inputDescription(_))
        .ifSome(inputDefinition)(_.inputDefinition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createInputResponse(
      inputConfiguration: Option[InputConfiguration] = None
    ): CreateInputResponse =
      CreateInputResponse
        .builder
        .ifSome(inputConfiguration)(_.inputConfiguration(_))
        .build

    def deleteAlarmModelRequest(
      alarmModelName: Option[String] = None
    ): DeleteAlarmModelRequest =
      DeleteAlarmModelRequest
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .build

    def deleteAlarmModelResponse(

    ): DeleteAlarmModelResponse =
      DeleteAlarmModelResponse
        .builder

        .build

    def deleteDetectorModelRequest(
      detectorModelName: Option[String] = None
    ): DeleteDetectorModelRequest =
      DeleteDetectorModelRequest
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .build

    def deleteDetectorModelResponse(

    ): DeleteDetectorModelResponse =
      DeleteDetectorModelResponse
        .builder

        .build

    def deleteInputRequest(
      inputName: Option[String] = None
    ): DeleteInputRequest =
      DeleteInputRequest
        .builder
        .ifSome(inputName)(_.inputName(_))
        .build

    def deleteInputResponse(

    ): DeleteInputResponse =
      DeleteInputResponse
        .builder

        .build

    def describeAlarmModelRequest(
      alarmModelName: Option[String] = None,
      alarmModelVersion: Option[String] = None
    ): DescribeAlarmModelRequest =
      DescribeAlarmModelRequest
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(alarmModelVersion)(_.alarmModelVersion(_))
        .build

    def describeAlarmModelResponse(
      creationTime: Option[Timestamp] = None,
      alarmModelArn: Option[String] = None,
      alarmModelVersion: Option[String] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      alarmModelName: Option[String] = None,
      alarmModelDescription: Option[String] = None,
      roleArn: Option[String] = None,
      key: Option[String] = None,
      severity: Option[Int] = None,
      alarmRule: Option[AlarmRule] = None,
      alarmNotification: Option[AlarmNotification] = None,
      alarmEventActions: Option[AlarmEventActions] = None,
      alarmCapabilities: Option[AlarmCapabilities] = None
    ): DescribeAlarmModelResponse =
      DescribeAlarmModelResponse
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(alarmModelArn)(_.alarmModelArn(_))
        .ifSome(alarmModelVersion)(_.alarmModelVersion(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(alarmModelDescription)(_.alarmModelDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(key)(_.key(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(alarmRule)(_.alarmRule(_))
        .ifSome(alarmNotification)(_.alarmNotification(_))
        .ifSome(alarmEventActions)(_.alarmEventActions(_))
        .ifSome(alarmCapabilities)(_.alarmCapabilities(_))
        .build

    def describeDetectorModelAnalysisRequest(
      analysisId: Option[String] = None
    ): DescribeDetectorModelAnalysisRequest =
      DescribeDetectorModelAnalysisRequest
        .builder
        .ifSome(analysisId)(_.analysisId(_))
        .build

    def describeDetectorModelAnalysisResponse(
      status: Option[String] = None
    ): DescribeDetectorModelAnalysisResponse =
      DescribeDetectorModelAnalysisResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def describeDetectorModelRequest(
      detectorModelName: Option[String] = None,
      detectorModelVersion: Option[String] = None
    ): DescribeDetectorModelRequest =
      DescribeDetectorModelRequest
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(detectorModelVersion)(_.detectorModelVersion(_))
        .build

    def describeDetectorModelResponse(
      detectorModel: Option[DetectorModel] = None
    ): DescribeDetectorModelResponse =
      DescribeDetectorModelResponse
        .builder
        .ifSome(detectorModel)(_.detectorModel(_))
        .build

    def describeInputRequest(
      inputName: Option[String] = None
    ): DescribeInputRequest =
      DescribeInputRequest
        .builder
        .ifSome(inputName)(_.inputName(_))
        .build

    def describeInputResponse(
      input: Option[Input] = None
    ): DescribeInputResponse =
      DescribeInputResponse
        .builder
        .ifSome(input)(_.input(_))
        .build

    def describeLoggingOptionsRequest(

    ): DescribeLoggingOptionsRequest =
      DescribeLoggingOptionsRequest
        .builder

        .build

    def describeLoggingOptionsResponse(
      loggingOptions: Option[LoggingOptions] = None
    ): DescribeLoggingOptionsResponse =
      DescribeLoggingOptionsResponse
        .builder
        .ifSome(loggingOptions)(_.loggingOptions(_))
        .build

    def detectorDebugOption(
      detectorModelName: Option[String] = None,
      keyValue: Option[String] = None
    ): DetectorDebugOption =
      DetectorDebugOption
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .build

    def detectorModel(
      detectorModelDefinition: Option[DetectorModelDefinition] = None,
      detectorModelConfiguration: Option[DetectorModelConfiguration] = None
    ): DetectorModel =
      DetectorModel
        .builder
        .ifSome(detectorModelDefinition)(_.detectorModelDefinition(_))
        .ifSome(detectorModelConfiguration)(_.detectorModelConfiguration(_))
        .build

    def detectorModelConfiguration(
      detectorModelName: Option[String] = None,
      detectorModelVersion: Option[String] = None,
      detectorModelDescription: Option[String] = None,
      detectorModelArn: Option[String] = None,
      roleArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None,
      key: Option[String] = None,
      evaluationMethod: Option[String] = None
    ): DetectorModelConfiguration =
      DetectorModelConfiguration
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(detectorModelVersion)(_.detectorModelVersion(_))
        .ifSome(detectorModelDescription)(_.detectorModelDescription(_))
        .ifSome(detectorModelArn)(_.detectorModelArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(key)(_.key(_))
        .ifSome(evaluationMethod)(_.evaluationMethod(_))
        .build

    def detectorModelDefinition(
      states: Option[List[State]] = None,
      initialStateName: Option[String] = None
    ): DetectorModelDefinition =
      DetectorModelDefinition
        .builder
        .ifSome(states)(_.states(_))
        .ifSome(initialStateName)(_.initialStateName(_))
        .build

    def detectorModelSummary(
      detectorModelName: Option[String] = None,
      detectorModelDescription: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): DetectorModelSummary =
      DetectorModelSummary
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(detectorModelDescription)(_.detectorModelDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def detectorModelVersionSummary(
      detectorModelName: Option[String] = None,
      detectorModelVersion: Option[String] = None,
      detectorModelArn: Option[String] = None,
      roleArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None,
      evaluationMethod: Option[String] = None
    ): DetectorModelVersionSummary =
      DetectorModelVersionSummary
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(detectorModelVersion)(_.detectorModelVersion(_))
        .ifSome(detectorModelArn)(_.detectorModelArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(evaluationMethod)(_.evaluationMethod(_))
        .build

    def dynamoDBAction(
      hashKeyType: Option[String] = None,
      hashKeyField: Option[String] = None,
      hashKeyValue: Option[String] = None,
      rangeKeyType: Option[String] = None,
      rangeKeyField: Option[String] = None,
      rangeKeyValue: Option[String] = None,
      operation: Option[String] = None,
      payloadField: Option[String] = None,
      tableName: Option[String] = None,
      payload: Option[Payload] = None
    ): DynamoDBAction =
      DynamoDBAction
        .builder
        .ifSome(hashKeyType)(_.hashKeyType(_))
        .ifSome(hashKeyField)(_.hashKeyField(_))
        .ifSome(hashKeyValue)(_.hashKeyValue(_))
        .ifSome(rangeKeyType)(_.rangeKeyType(_))
        .ifSome(rangeKeyField)(_.rangeKeyField(_))
        .ifSome(rangeKeyValue)(_.rangeKeyValue(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(payloadField)(_.payloadField(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(payload)(_.payload(_))
        .build

    def dynamoDBv2Action(
      tableName: Option[String] = None,
      payload: Option[Payload] = None
    ): DynamoDBv2Action =
      DynamoDBv2Action
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(payload)(_.payload(_))
        .build

    def emailConfiguration(
      from: Option[String] = None,
      content: Option[EmailContent] = None,
      recipients: Option[EmailRecipients] = None
    ): EmailConfiguration =
      EmailConfiguration
        .builder
        .ifSome(from)(_.from(_))
        .ifSome(content)(_.content(_))
        .ifSome(recipients)(_.recipients(_))
        .build

    def emailContent(
      subject: Option[String] = None,
      additionalMessage: Option[String] = None
    ): EmailContent =
      EmailContent
        .builder
        .ifSome(subject)(_.subject(_))
        .ifSome(additionalMessage)(_.additionalMessage(_))
        .build

    def emailRecipients(
      to: Option[List[RecipientDetail]] = None
    ): EmailRecipients =
      EmailRecipients
        .builder
        .ifSome(to)(_.to(_))
        .build

    def event(
      eventName: Option[String] = None,
      condition: Option[String] = None,
      actions: Option[List[Action]] = None
    ): Event =
      Event
        .builder
        .ifSome(eventName)(_.eventName(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(actions)(_.actions(_))
        .build

    def firehoseAction(
      deliveryStreamName: Option[String] = None,
      separator: Option[String] = None,
      payload: Option[Payload] = None
    ): FirehoseAction =
      FirehoseAction
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(separator)(_.separator(_))
        .ifSome(payload)(_.payload(_))
        .build

    def getDetectorModelAnalysisResultsRequest(
      analysisId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetDetectorModelAnalysisResultsRequest =
      GetDetectorModelAnalysisResultsRequest
        .builder
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getDetectorModelAnalysisResultsResponse(
      analysisResults: Option[List[AnalysisResult]] = None,
      nextToken: Option[String] = None
    ): GetDetectorModelAnalysisResultsResponse =
      GetDetectorModelAnalysisResultsResponse
        .builder
        .ifSome(analysisResults)(_.analysisResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def initializationConfiguration(
      disabledOnInitialization: Option[Boolean] = None
    ): InitializationConfiguration =
      InitializationConfiguration
        .builder
        .ifSome(disabledOnInitialization)(_.disabledOnInitialization(_))
        .build

    def input(
      inputConfiguration: Option[InputConfiguration] = None,
      inputDefinition: Option[InputDefinition] = None
    ): Input =
      Input
        .builder
        .ifSome(inputConfiguration)(_.inputConfiguration(_))
        .ifSome(inputDefinition)(_.inputDefinition(_))
        .build

    def inputConfiguration(
      inputName: Option[String] = None,
      inputDescription: Option[String] = None,
      inputArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None
    ): InputConfiguration =
      InputConfiguration
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(inputDescription)(_.inputDescription(_))
        .ifSome(inputArn)(_.inputArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .build

    def inputDefinition(
      attributes: Option[List[Attribute]] = None
    ): InputDefinition =
      InputDefinition
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def inputIdentifier(
      iotEventsInputIdentifier: Option[IotEventsInputIdentifier] = None,
      iotSiteWiseInputIdentifier: Option[IotSiteWiseInputIdentifier] = None
    ): InputIdentifier =
      InputIdentifier
        .builder
        .ifSome(iotEventsInputIdentifier)(_.iotEventsInputIdentifier(_))
        .ifSome(iotSiteWiseInputIdentifier)(_.iotSiteWiseInputIdentifier(_))
        .build

    def inputSummary(
      inputName: Option[String] = None,
      inputDescription: Option[String] = None,
      inputArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None
    ): InputSummary =
      InputSummary
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(inputDescription)(_.inputDescription(_))
        .ifSome(inputArn)(_.inputArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
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

    def iotEventsAction(
      inputName: Option[String] = None,
      payload: Option[Payload] = None
    ): IotEventsAction =
      IotEventsAction
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(payload)(_.payload(_))
        .build

    def iotEventsInputIdentifier(
      inputName: Option[String] = None
    ): IotEventsInputIdentifier =
      IotEventsInputIdentifier
        .builder
        .ifSome(inputName)(_.inputName(_))
        .build

    def iotSiteWiseAction(
      entryId: Option[String] = None,
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None,
      propertyValue: Option[AssetPropertyValue] = None
    ): IotSiteWiseAction =
      IotSiteWiseAction
        .builder
        .ifSome(entryId)(_.entryId(_))
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .ifSome(propertyValue)(_.propertyValue(_))
        .build

    def iotSiteWiseAssetModelPropertyIdentifier(
      assetModelId: Option[String] = None,
      propertyId: Option[String] = None
    ): IotSiteWiseAssetModelPropertyIdentifier =
      IotSiteWiseAssetModelPropertyIdentifier
        .builder
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .build

    def iotSiteWiseInputIdentifier(
      iotSiteWiseAssetModelPropertyIdentifier: Option[IotSiteWiseAssetModelPropertyIdentifier] = None
    ): IotSiteWiseInputIdentifier =
      IotSiteWiseInputIdentifier
        .builder
        .ifSome(iotSiteWiseAssetModelPropertyIdentifier)(_.iotSiteWiseAssetModelPropertyIdentifier(_))
        .build

    def iotTopicPublishAction(
      mqttTopic: Option[String] = None,
      payload: Option[Payload] = None
    ): IotTopicPublishAction =
      IotTopicPublishAction
        .builder
        .ifSome(mqttTopic)(_.mqttTopic(_))
        .ifSome(payload)(_.payload(_))
        .build

    def lambdaAction(
      functionArn: Option[String] = None,
      payload: Option[Payload] = None
    ): LambdaAction =
      LambdaAction
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(payload)(_.payload(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAlarmModelVersionsRequest(
      alarmModelName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAlarmModelVersionsRequest =
      ListAlarmModelVersionsRequest
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAlarmModelVersionsResponse(
      alarmModelVersionSummaries: Option[List[AlarmModelVersionSummary]] = None,
      nextToken: Option[String] = None
    ): ListAlarmModelVersionsResponse =
      ListAlarmModelVersionsResponse
        .builder
        .ifSome(alarmModelVersionSummaries)(_.alarmModelVersionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAlarmModelsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAlarmModelsRequest =
      ListAlarmModelsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAlarmModelsResponse(
      alarmModelSummaries: Option[List[AlarmModelSummary]] = None,
      nextToken: Option[String] = None
    ): ListAlarmModelsResponse =
      ListAlarmModelsResponse
        .builder
        .ifSome(alarmModelSummaries)(_.alarmModelSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDetectorModelVersionsRequest(
      detectorModelName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDetectorModelVersionsRequest =
      ListDetectorModelVersionsRequest
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDetectorModelVersionsResponse(
      detectorModelVersionSummaries: Option[List[DetectorModelVersionSummary]] = None,
      nextToken: Option[String] = None
    ): ListDetectorModelVersionsResponse =
      ListDetectorModelVersionsResponse
        .builder
        .ifSome(detectorModelVersionSummaries)(_.detectorModelVersionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDetectorModelsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDetectorModelsRequest =
      ListDetectorModelsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDetectorModelsResponse(
      detectorModelSummaries: Option[List[DetectorModelSummary]] = None,
      nextToken: Option[String] = None
    ): ListDetectorModelsResponse =
      ListDetectorModelsResponse
        .builder
        .ifSome(detectorModelSummaries)(_.detectorModelSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputRoutingsRequest(
      inputIdentifier: Option[InputIdentifier] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInputRoutingsRequest =
      ListInputRoutingsRequest
        .builder
        .ifSome(inputIdentifier)(_.inputIdentifier(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputRoutingsResponse(
      routedResources: Option[List[RoutedResource]] = None,
      nextToken: Option[String] = None
    ): ListInputRoutingsResponse =
      ListInputRoutingsResponse
        .builder
        .ifSome(routedResources)(_.routedResources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListInputsRequest =
      ListInputsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listInputsResponse(
      inputSummaries: Option[List[InputSummary]] = None,
      nextToken: Option[String] = None
    ): ListInputsResponse =
      ListInputsResponse
        .builder
        .ifSome(inputSummaries)(_.inputSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
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

    def loggingOptions(
      roleArn: Option[String] = None,
      level: Option[String] = None,
      enabled: Option[Boolean] = None,
      detectorDebugOptions: Option[List[DetectorDebugOption]] = None
    ): LoggingOptions =
      LoggingOptions
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(level)(_.level(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(detectorDebugOptions)(_.detectorDebugOptions(_))
        .build

    def notificationAction(
      action: Option[NotificationTargetActions] = None,
      smsConfigurations: Option[List[SMSConfiguration]] = None,
      emailConfigurations: Option[List[EmailConfiguration]] = None
    ): NotificationAction =
      NotificationAction
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(smsConfigurations)(_.smsConfigurations(_))
        .ifSome(emailConfigurations)(_.emailConfigurations(_))
        .build

    def notificationTargetActions(
      lambdaAction: Option[LambdaAction] = None
    ): NotificationTargetActions =
      NotificationTargetActions
        .builder
        .ifSome(lambdaAction)(_.lambdaAction(_))
        .build

    def onEnterLifecycle(
      events: Option[List[Event]] = None
    ): OnEnterLifecycle =
      OnEnterLifecycle
        .builder
        .ifSome(events)(_.events(_))
        .build

    def onExitLifecycle(
      events: Option[List[Event]] = None
    ): OnExitLifecycle =
      OnExitLifecycle
        .builder
        .ifSome(events)(_.events(_))
        .build

    def onInputLifecycle(
      events: Option[List[Event]] = None,
      transitionEvents: Option[List[TransitionEvent]] = None
    ): OnInputLifecycle =
      OnInputLifecycle
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(transitionEvents)(_.transitionEvents(_))
        .build

    def payload(
      contentExpression: Option[String] = None,
      `type`: Option[String] = None
    ): Payload =
      Payload
        .builder
        .ifSome(contentExpression)(_.contentExpression(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def putLoggingOptionsRequest(
      loggingOptions: Option[LoggingOptions] = None
    ): PutLoggingOptionsRequest =
      PutLoggingOptionsRequest
        .builder
        .ifSome(loggingOptions)(_.loggingOptions(_))
        .build

    def recipientDetail(
      ssoIdentity: Option[SSOIdentity] = None
    ): RecipientDetail =
      RecipientDetail
        .builder
        .ifSome(ssoIdentity)(_.ssoIdentity(_))
        .build

    def resetTimerAction(
      timerName: Option[String] = None
    ): ResetTimerAction =
      ResetTimerAction
        .builder
        .ifSome(timerName)(_.timerName(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceArn: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
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

    def routedResource(
      name: Option[String] = None,
      arn: Option[String] = None
    ): RoutedResource =
      RoutedResource
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def sMSConfiguration(
      senderId: Option[String] = None,
      additionalMessage: Option[String] = None,
      recipients: Option[List[RecipientDetail]] = None
    ): SMSConfiguration =
      SMSConfiguration
        .builder
        .ifSome(senderId)(_.senderId(_))
        .ifSome(additionalMessage)(_.additionalMessage(_))
        .ifSome(recipients)(_.recipients(_))
        .build

    def sNSTopicPublishAction(
      targetArn: Option[String] = None,
      payload: Option[Payload] = None
    ): SNSTopicPublishAction =
      SNSTopicPublishAction
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(payload)(_.payload(_))
        .build

    def sSOIdentity(
      identityStoreId: Option[String] = None,
      userId: Option[String] = None
    ): SSOIdentity =
      SSOIdentity
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def setTimerAction(
      timerName: Option[String] = None,
      seconds: Option[Int] = None,
      durationExpression: Option[String] = None
    ): SetTimerAction =
      SetTimerAction
        .builder
        .ifSome(timerName)(_.timerName(_))
        .ifSome(seconds)(_.seconds(_))
        .ifSome(durationExpression)(_.durationExpression(_))
        .build

    def setVariableAction(
      variableName: Option[String] = None,
      value: Option[String] = None
    ): SetVariableAction =
      SetVariableAction
        .builder
        .ifSome(variableName)(_.variableName(_))
        .ifSome(value)(_.value(_))
        .build

    def simpleRule(
      inputProperty: Option[String] = None,
      comparisonOperator: Option[String] = None,
      threshold: Option[String] = None
    ): SimpleRule =
      SimpleRule
        .builder
        .ifSome(inputProperty)(_.inputProperty(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(threshold)(_.threshold(_))
        .build

    def sqsAction(
      queueUrl: Option[String] = None,
      useBase64: Option[Boolean] = None,
      payload: Option[Payload] = None
    ): SqsAction =
      SqsAction
        .builder
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(useBase64)(_.useBase64(_))
        .ifSome(payload)(_.payload(_))
        .build

    def startDetectorModelAnalysisRequest(
      detectorModelDefinition: Option[DetectorModelDefinition] = None
    ): StartDetectorModelAnalysisRequest =
      StartDetectorModelAnalysisRequest
        .builder
        .ifSome(detectorModelDefinition)(_.detectorModelDefinition(_))
        .build

    def startDetectorModelAnalysisResponse(
      analysisId: Option[String] = None
    ): StartDetectorModelAnalysisResponse =
      StartDetectorModelAnalysisResponse
        .builder
        .ifSome(analysisId)(_.analysisId(_))
        .build

    def state(
      stateName: Option[String] = None,
      onInput: Option[OnInputLifecycle] = None,
      onEnter: Option[OnEnterLifecycle] = None,
      onExit: Option[OnExitLifecycle] = None
    ): State =
      State
        .builder
        .ifSome(stateName)(_.stateName(_))
        .ifSome(onInput)(_.onInput(_))
        .ifSome(onEnter)(_.onEnter(_))
        .ifSome(onExit)(_.onExit(_))
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

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transitionEvent(
      eventName: Option[String] = None,
      condition: Option[String] = None,
      actions: Option[List[Action]] = None,
      nextState: Option[String] = None
    ): TransitionEvent =
      TransitionEvent
        .builder
        .ifSome(eventName)(_.eventName(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(nextState)(_.nextState(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateAlarmModelRequest(
      alarmModelName: Option[String] = None,
      alarmModelDescription: Option[String] = None,
      roleArn: Option[String] = None,
      severity: Option[Int] = None,
      alarmRule: Option[AlarmRule] = None,
      alarmNotification: Option[AlarmNotification] = None,
      alarmEventActions: Option[AlarmEventActions] = None,
      alarmCapabilities: Option[AlarmCapabilities] = None
    ): UpdateAlarmModelRequest =
      UpdateAlarmModelRequest
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(alarmModelDescription)(_.alarmModelDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(alarmRule)(_.alarmRule(_))
        .ifSome(alarmNotification)(_.alarmNotification(_))
        .ifSome(alarmEventActions)(_.alarmEventActions(_))
        .ifSome(alarmCapabilities)(_.alarmCapabilities(_))
        .build

    def updateAlarmModelResponse(
      creationTime: Option[Timestamp] = None,
      alarmModelArn: Option[String] = None,
      alarmModelVersion: Option[String] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None
    ): UpdateAlarmModelResponse =
      UpdateAlarmModelResponse
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(alarmModelArn)(_.alarmModelArn(_))
        .ifSome(alarmModelVersion)(_.alarmModelVersion(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .build

    def updateDetectorModelRequest(
      detectorModelName: Option[String] = None,
      detectorModelDefinition: Option[DetectorModelDefinition] = None,
      detectorModelDescription: Option[String] = None,
      roleArn: Option[String] = None,
      evaluationMethod: Option[String] = None
    ): UpdateDetectorModelRequest =
      UpdateDetectorModelRequest
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(detectorModelDefinition)(_.detectorModelDefinition(_))
        .ifSome(detectorModelDescription)(_.detectorModelDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(evaluationMethod)(_.evaluationMethod(_))
        .build

    def updateDetectorModelResponse(
      detectorModelConfiguration: Option[DetectorModelConfiguration] = None
    ): UpdateDetectorModelResponse =
      UpdateDetectorModelResponse
        .builder
        .ifSome(detectorModelConfiguration)(_.detectorModelConfiguration(_))
        .build

    def updateInputRequest(
      inputName: Option[String] = None,
      inputDescription: Option[String] = None,
      inputDefinition: Option[InputDefinition] = None
    ): UpdateInputRequest =
      UpdateInputRequest
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(inputDescription)(_.inputDescription(_))
        .ifSome(inputDefinition)(_.inputDefinition(_))
        .build

    def updateInputResponse(
      inputConfiguration: Option[InputConfiguration] = None
    ): UpdateInputResponse =
      UpdateInputResponse
        .builder
        .ifSome(inputConfiguration)(_.inputConfiguration(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
