package goober.hi

import goober.free.ioteventsdata.IotEventsDataIO
import software.amazon.awssdk.services.ioteventsdata.model._


object ioteventsdata {
  import goober.free.{ioteventsdata ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acknowledgeActionConfiguration(
      note: Option[String] = None
    ): AcknowledgeActionConfiguration =
      AcknowledgeActionConfiguration
        .builder
        .ifSome(note)(_.note(_))
        .build

    def acknowledgeAlarmActionRequest(
      requestId: Option[String] = None,
      alarmModelName: Option[String] = None,
      keyValue: Option[String] = None,
      note: Option[String] = None
    ): AcknowledgeAlarmActionRequest =
      AcknowledgeAlarmActionRequest
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(note)(_.note(_))
        .build

    def alarm(
      alarmModelName: Option[String] = None,
      alarmModelVersion: Option[String] = None,
      keyValue: Option[String] = None,
      alarmState: Option[AlarmState] = None,
      severity: Option[Int] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): Alarm =
      Alarm
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(alarmModelVersion)(_.alarmModelVersion(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(alarmState)(_.alarmState(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def alarmState(
      stateName: Option[String] = None,
      ruleEvaluation: Option[RuleEvaluation] = None,
      customerAction: Option[CustomerAction] = None,
      systemEvent: Option[SystemEvent] = None
    ): AlarmState =
      AlarmState
        .builder
        .ifSome(stateName)(_.stateName(_))
        .ifSome(ruleEvaluation)(_.ruleEvaluation(_))
        .ifSome(customerAction)(_.customerAction(_))
        .ifSome(systemEvent)(_.systemEvent(_))
        .build

    def alarmSummary(
      alarmModelName: Option[String] = None,
      alarmModelVersion: Option[String] = None,
      keyValue: Option[String] = None,
      stateName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): AlarmSummary =
      AlarmSummary
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(alarmModelVersion)(_.alarmModelVersion(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(stateName)(_.stateName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def batchAcknowledgeAlarmRequest(
      acknowledgeActionRequests: Option[List[AcknowledgeAlarmActionRequest]] = None
    ): BatchAcknowledgeAlarmRequest =
      BatchAcknowledgeAlarmRequest
        .builder
        .ifSome(acknowledgeActionRequests)(_.acknowledgeActionRequests(_))
        .build

    def batchAcknowledgeAlarmResponse(
      errorEntries: Option[List[BatchAlarmActionErrorEntry]] = None
    ): BatchAcknowledgeAlarmResponse =
      BatchAcknowledgeAlarmResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def batchAlarmActionErrorEntry(
      requestId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchAlarmActionErrorEntry =
      BatchAlarmActionErrorEntry
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchDisableAlarmRequest(
      disableActionRequests: Option[List[DisableAlarmActionRequest]] = None
    ): BatchDisableAlarmRequest =
      BatchDisableAlarmRequest
        .builder
        .ifSome(disableActionRequests)(_.disableActionRequests(_))
        .build

    def batchDisableAlarmResponse(
      errorEntries: Option[List[BatchAlarmActionErrorEntry]] = None
    ): BatchDisableAlarmResponse =
      BatchDisableAlarmResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def batchEnableAlarmRequest(
      enableActionRequests: Option[List[EnableAlarmActionRequest]] = None
    ): BatchEnableAlarmRequest =
      BatchEnableAlarmRequest
        .builder
        .ifSome(enableActionRequests)(_.enableActionRequests(_))
        .build

    def batchEnableAlarmResponse(
      errorEntries: Option[List[BatchAlarmActionErrorEntry]] = None
    ): BatchEnableAlarmResponse =
      BatchEnableAlarmResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def batchPutMessageErrorEntry(
      messageId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchPutMessageErrorEntry =
      BatchPutMessageErrorEntry
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchPutMessageRequest(
      messages: Option[List[Message]] = None
    ): BatchPutMessageRequest =
      BatchPutMessageRequest
        .builder
        .ifSome(messages)(_.messages(_))
        .build

    def batchPutMessageResponse(
      batchPutMessageErrorEntries: Option[List[BatchPutMessageErrorEntry]] = None
    ): BatchPutMessageResponse =
      BatchPutMessageResponse
        .builder
        .ifSome(batchPutMessageErrorEntries)(_.batchPutMessageErrorEntries(_))
        .build

    def batchResetAlarmRequest(
      resetActionRequests: Option[List[ResetAlarmActionRequest]] = None
    ): BatchResetAlarmRequest =
      BatchResetAlarmRequest
        .builder
        .ifSome(resetActionRequests)(_.resetActionRequests(_))
        .build

    def batchResetAlarmResponse(
      errorEntries: Option[List[BatchAlarmActionErrorEntry]] = None
    ): BatchResetAlarmResponse =
      BatchResetAlarmResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def batchSnoozeAlarmRequest(
      snoozeActionRequests: Option[List[SnoozeAlarmActionRequest]] = None
    ): BatchSnoozeAlarmRequest =
      BatchSnoozeAlarmRequest
        .builder
        .ifSome(snoozeActionRequests)(_.snoozeActionRequests(_))
        .build

    def batchSnoozeAlarmResponse(
      errorEntries: Option[List[BatchAlarmActionErrorEntry]] = None
    ): BatchSnoozeAlarmResponse =
      BatchSnoozeAlarmResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def batchUpdateDetectorErrorEntry(
      messageId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchUpdateDetectorErrorEntry =
      BatchUpdateDetectorErrorEntry
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchUpdateDetectorRequest(
      detectors: Option[List[UpdateDetectorRequest]] = None
    ): BatchUpdateDetectorRequest =
      BatchUpdateDetectorRequest
        .builder
        .ifSome(detectors)(_.detectors(_))
        .build

    def batchUpdateDetectorResponse(
      batchUpdateDetectorErrorEntries: Option[List[BatchUpdateDetectorErrorEntry]] = None
    ): BatchUpdateDetectorResponse =
      BatchUpdateDetectorResponse
        .builder
        .ifSome(batchUpdateDetectorErrorEntries)(_.batchUpdateDetectorErrorEntries(_))
        .build

    def customerAction(
      actionName: Option[String] = None,
      snoozeActionConfiguration: Option[SnoozeActionConfiguration] = None,
      enableActionConfiguration: Option[EnableActionConfiguration] = None,
      disableActionConfiguration: Option[DisableActionConfiguration] = None,
      acknowledgeActionConfiguration: Option[AcknowledgeActionConfiguration] = None,
      resetActionConfiguration: Option[ResetActionConfiguration] = None
    ): CustomerAction =
      CustomerAction
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(snoozeActionConfiguration)(_.snoozeActionConfiguration(_))
        .ifSome(enableActionConfiguration)(_.enableActionConfiguration(_))
        .ifSome(disableActionConfiguration)(_.disableActionConfiguration(_))
        .ifSome(acknowledgeActionConfiguration)(_.acknowledgeActionConfiguration(_))
        .ifSome(resetActionConfiguration)(_.resetActionConfiguration(_))
        .build

    def describeAlarmRequest(
      alarmModelName: Option[String] = None,
      keyValue: Option[String] = None
    ): DescribeAlarmRequest =
      DescribeAlarmRequest
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .build

    def describeAlarmResponse(
      alarm: Option[Alarm] = None
    ): DescribeAlarmResponse =
      DescribeAlarmResponse
        .builder
        .ifSome(alarm)(_.alarm(_))
        .build

    def describeDetectorRequest(
      detectorModelName: Option[String] = None,
      keyValue: Option[String] = None
    ): DescribeDetectorRequest =
      DescribeDetectorRequest
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .build

    def describeDetectorResponse(
      detector: Option[Detector] = None
    ): DescribeDetectorResponse =
      DescribeDetectorResponse
        .builder
        .ifSome(detector)(_.detector(_))
        .build

    def detector(
      detectorModelName: Option[String] = None,
      keyValue: Option[String] = None,
      detectorModelVersion: Option[String] = None,
      state: Option[DetectorState] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): Detector =
      Detector
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(detectorModelVersion)(_.detectorModelVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def detectorState(
      stateName: Option[String] = None,
      variables: Option[List[Variable]] = None,
      timers: Option[List[Timer]] = None
    ): DetectorState =
      DetectorState
        .builder
        .ifSome(stateName)(_.stateName(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(timers)(_.timers(_))
        .build

    def detectorStateDefinition(
      stateName: Option[String] = None,
      variables: Option[List[VariableDefinition]] = None,
      timers: Option[List[TimerDefinition]] = None
    ): DetectorStateDefinition =
      DetectorStateDefinition
        .builder
        .ifSome(stateName)(_.stateName(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(timers)(_.timers(_))
        .build

    def detectorStateSummary(
      stateName: Option[String] = None
    ): DetectorStateSummary =
      DetectorStateSummary
        .builder
        .ifSome(stateName)(_.stateName(_))
        .build

    def detectorSummary(
      detectorModelName: Option[String] = None,
      keyValue: Option[String] = None,
      detectorModelVersion: Option[String] = None,
      state: Option[DetectorStateSummary] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): DetectorSummary =
      DetectorSummary
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(detectorModelVersion)(_.detectorModelVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def disableActionConfiguration(
      note: Option[String] = None
    ): DisableActionConfiguration =
      DisableActionConfiguration
        .builder
        .ifSome(note)(_.note(_))
        .build

    def disableAlarmActionRequest(
      requestId: Option[String] = None,
      alarmModelName: Option[String] = None,
      keyValue: Option[String] = None,
      note: Option[String] = None
    ): DisableAlarmActionRequest =
      DisableAlarmActionRequest
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(note)(_.note(_))
        .build

    def enableActionConfiguration(
      note: Option[String] = None
    ): EnableActionConfiguration =
      EnableActionConfiguration
        .builder
        .ifSome(note)(_.note(_))
        .build

    def enableAlarmActionRequest(
      requestId: Option[String] = None,
      alarmModelName: Option[String] = None,
      keyValue: Option[String] = None,
      note: Option[String] = None
    ): EnableAlarmActionRequest =
      EnableAlarmActionRequest
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(note)(_.note(_))
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

    def listAlarmsRequest(
      alarmModelName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAlarmsRequest =
      ListAlarmsRequest
        .builder
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAlarmsResponse(
      alarmSummaries: Option[List[AlarmSummary]] = None,
      nextToken: Option[String] = None
    ): ListAlarmsResponse =
      ListAlarmsResponse
        .builder
        .ifSome(alarmSummaries)(_.alarmSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDetectorsRequest(
      detectorModelName: Option[String] = None,
      stateName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDetectorsRequest =
      ListDetectorsRequest
        .builder
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(stateName)(_.stateName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDetectorsResponse(
      detectorSummaries: Option[List[DetectorSummary]] = None,
      nextToken: Option[String] = None
    ): ListDetectorsResponse =
      ListDetectorsResponse
        .builder
        .ifSome(detectorSummaries)(_.detectorSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def message(
      messageId: Option[String] = None,
      inputName: Option[String] = None,
      payload: Option[Payload] = None,
      timestamp: Option[TimestampValue] = None
    ): Message =
      Message
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(inputName)(_.inputName(_))
        .ifSome(payload)(_.payload(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def resetActionConfiguration(
      note: Option[String] = None
    ): ResetActionConfiguration =
      ResetActionConfiguration
        .builder
        .ifSome(note)(_.note(_))
        .build

    def resetAlarmActionRequest(
      requestId: Option[String] = None,
      alarmModelName: Option[String] = None,
      keyValue: Option[String] = None,
      note: Option[String] = None
    ): ResetAlarmActionRequest =
      ResetAlarmActionRequest
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(note)(_.note(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ruleEvaluation(
      simpleRuleEvaluation: Option[SimpleRuleEvaluation] = None
    ): RuleEvaluation =
      RuleEvaluation
        .builder
        .ifSome(simpleRuleEvaluation)(_.simpleRuleEvaluation(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def simpleRuleEvaluation(
      inputPropertyValue: Option[String] = None,
      operator: Option[String] = None,
      thresholdValue: Option[String] = None
    ): SimpleRuleEvaluation =
      SimpleRuleEvaluation
        .builder
        .ifSome(inputPropertyValue)(_.inputPropertyValue(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(thresholdValue)(_.thresholdValue(_))
        .build

    def snoozeActionConfiguration(
      snoozeDuration: Option[Int] = None,
      note: Option[String] = None
    ): SnoozeActionConfiguration =
      SnoozeActionConfiguration
        .builder
        .ifSome(snoozeDuration)(_.snoozeDuration(_))
        .ifSome(note)(_.note(_))
        .build

    def snoozeAlarmActionRequest(
      requestId: Option[String] = None,
      alarmModelName: Option[String] = None,
      keyValue: Option[String] = None,
      note: Option[String] = None,
      snoozeDuration: Option[Int] = None
    ): SnoozeAlarmActionRequest =
      SnoozeAlarmActionRequest
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(alarmModelName)(_.alarmModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(note)(_.note(_))
        .ifSome(snoozeDuration)(_.snoozeDuration(_))
        .build

    def stateChangeConfiguration(
      triggerType: Option[String] = None
    ): StateChangeConfiguration =
      StateChangeConfiguration
        .builder
        .ifSome(triggerType)(_.triggerType(_))
        .build

    def systemEvent(
      eventType: Option[String] = None,
      stateChangeConfiguration: Option[StateChangeConfiguration] = None
    ): SystemEvent =
      SystemEvent
        .builder
        .ifSome(eventType)(_.eventType(_))
        .ifSome(stateChangeConfiguration)(_.stateChangeConfiguration(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timer(
      name: Option[String] = None,
      timestamp: Option[Timestamp] = None
    ): Timer =
      Timer
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def timerDefinition(
      name: Option[String] = None,
      seconds: Option[Int] = None
    ): TimerDefinition =
      TimerDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(seconds)(_.seconds(_))
        .build

    def timestampValue(
      timeInMillis: Option[EpochMilliTimestamp] = None
    ): TimestampValue =
      TimestampValue
        .builder
        .ifSome(timeInMillis)(_.timeInMillis(_))
        .build

    def updateDetectorRequest(
      messageId: Option[String] = None,
      detectorModelName: Option[String] = None,
      keyValue: Option[String] = None,
      state: Option[DetectorStateDefinition] = None
    ): UpdateDetectorRequest =
      UpdateDetectorRequest
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(detectorModelName)(_.detectorModelName(_))
        .ifSome(keyValue)(_.keyValue(_))
        .ifSome(state)(_.state(_))
        .build

    def variable(
      name: Option[String] = None,
      value: Option[String] = None
    ): Variable =
      Variable
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def variableDefinition(
      name: Option[String] = None,
      value: Option[String] = None
    ): VariableDefinition =
      VariableDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
