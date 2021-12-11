package goober.hi

import goober.free.swf.SwfIO
import software.amazon.awssdk.services.swf.model._


object swf {
  import goober.free.{swf ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activityTask(
      taskToken: Option[String] = None,
      activityId: Option[String] = None,
      startedEventId: Option[EventId] = None,
      workflowExecution: Option[WorkflowExecution] = None,
      activityType: Option[ActivityType] = None,
      input: Option[String] = None
    ): ActivityTask =
      ActivityTask
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(activityId)(_.activityId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(activityType)(_.activityType(_))
        .ifSome(input)(_.input(_))
        .build

    def activityTaskCancelRequestedEventAttributes(
      decisionTaskCompletedEventId: Option[EventId] = None,
      activityId: Option[String] = None
    ): ActivityTaskCancelRequestedEventAttributes =
      ActivityTaskCancelRequestedEventAttributes
        .builder
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(activityId)(_.activityId(_))
        .build

    def activityTaskCanceledEventAttributes(
      details: Option[String] = None,
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None,
      latestCancelRequestedEventId: Option[EventId] = None
    ): ActivityTaskCanceledEventAttributes =
      ActivityTaskCanceledEventAttributes
        .builder
        .ifSome(details)(_.details(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(latestCancelRequestedEventId)(_.latestCancelRequestedEventId(_))
        .build

    def activityTaskCompletedEventAttributes(
      result: Option[String] = None,
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): ActivityTaskCompletedEventAttributes =
      ActivityTaskCompletedEventAttributes
        .builder
        .ifSome(result)(_.result(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def activityTaskFailedEventAttributes(
      reason: Option[String] = None,
      details: Option[String] = None,
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): ActivityTaskFailedEventAttributes =
      ActivityTaskFailedEventAttributes
        .builder
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def activityTaskScheduledEventAttributes(
      activityType: Option[ActivityType] = None,
      activityId: Option[String] = None,
      input: Option[String] = None,
      control: Option[String] = None,
      scheduleToStartTimeout: Option[String] = None,
      scheduleToCloseTimeout: Option[String] = None,
      startToCloseTimeout: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      heartbeatTimeout: Option[String] = None
    ): ActivityTaskScheduledEventAttributes =
      ActivityTaskScheduledEventAttributes
        .builder
        .ifSome(activityType)(_.activityType(_))
        .ifSome(activityId)(_.activityId(_))
        .ifSome(input)(_.input(_))
        .ifSome(control)(_.control(_))
        .ifSome(scheduleToStartTimeout)(_.scheduleToStartTimeout(_))
        .ifSome(scheduleToCloseTimeout)(_.scheduleToCloseTimeout(_))
        .ifSome(startToCloseTimeout)(_.startToCloseTimeout(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(heartbeatTimeout)(_.heartbeatTimeout(_))
        .build

    def activityTaskStartedEventAttributes(
      identity: Option[String] = None,
      scheduledEventId: Option[EventId] = None
    ): ActivityTaskStartedEventAttributes =
      ActivityTaskStartedEventAttributes
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .build

    def activityTaskStatus(
      cancelRequested: Option[Boolean] = None
    ): ActivityTaskStatus =
      ActivityTaskStatus
        .builder
        .ifSome(cancelRequested)(_.cancelRequested(_))
        .build

    def activityTaskTimedOutEventAttributes(
      timeoutType: Option[String] = None,
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None,
      details: Option[String] = None
    ): ActivityTaskTimedOutEventAttributes =
      ActivityTaskTimedOutEventAttributes
        .builder
        .ifSome(timeoutType)(_.timeoutType(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(details)(_.details(_))
        .build

    def activityType(
      name: Option[String] = None,
      version: Option[String] = None
    ): ActivityType =
      ActivityType
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def activityTypeConfiguration(
      defaultTaskStartToCloseTimeout: Option[String] = None,
      defaultTaskHeartbeatTimeout: Option[String] = None,
      defaultTaskList: Option[TaskList] = None,
      defaultTaskPriority: Option[String] = None,
      defaultTaskScheduleToStartTimeout: Option[String] = None,
      defaultTaskScheduleToCloseTimeout: Option[String] = None
    ): ActivityTypeConfiguration =
      ActivityTypeConfiguration
        .builder
        .ifSome(defaultTaskStartToCloseTimeout)(_.defaultTaskStartToCloseTimeout(_))
        .ifSome(defaultTaskHeartbeatTimeout)(_.defaultTaskHeartbeatTimeout(_))
        .ifSome(defaultTaskList)(_.defaultTaskList(_))
        .ifSome(defaultTaskPriority)(_.defaultTaskPriority(_))
        .ifSome(defaultTaskScheduleToStartTimeout)(_.defaultTaskScheduleToStartTimeout(_))
        .ifSome(defaultTaskScheduleToCloseTimeout)(_.defaultTaskScheduleToCloseTimeout(_))
        .build

    def activityTypeDetail(
      typeInfo: Option[ActivityTypeInfo] = None,
      configuration: Option[ActivityTypeConfiguration] = None
    ): ActivityTypeDetail =
      ActivityTypeDetail
        .builder
        .ifSome(typeInfo)(_.typeInfo(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def activityTypeInfo(
      activityType: Option[ActivityType] = None,
      status: Option[String] = None,
      description: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      deprecationDate: Option[Timestamp] = None
    ): ActivityTypeInfo =
      ActivityTypeInfo
        .builder
        .ifSome(activityType)(_.activityType(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(deprecationDate)(_.deprecationDate(_))
        .build

    def activityTypeInfos(
      typeInfos: Option[List[ActivityTypeInfo]] = None,
      nextPageToken: Option[String] = None
    ): ActivityTypeInfos =
      ActivityTypeInfos
        .builder
        .ifSome(typeInfos)(_.typeInfos(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def cancelTimerDecisionAttributes(
      timerId: Option[String] = None
    ): CancelTimerDecisionAttributes =
      CancelTimerDecisionAttributes
        .builder
        .ifSome(timerId)(_.timerId(_))
        .build

    def cancelTimerFailedEventAttributes(
      timerId: Option[String] = None,
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): CancelTimerFailedEventAttributes =
      CancelTimerFailedEventAttributes
        .builder
        .ifSome(timerId)(_.timerId(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def cancelWorkflowExecutionDecisionAttributes(
      details: Option[String] = None
    ): CancelWorkflowExecutionDecisionAttributes =
      CancelWorkflowExecutionDecisionAttributes
        .builder
        .ifSome(details)(_.details(_))
        .build

    def cancelWorkflowExecutionFailedEventAttributes(
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): CancelWorkflowExecutionFailedEventAttributes =
      CancelWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def childWorkflowExecutionCanceledEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      details: Option[String] = None,
      initiatedEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): ChildWorkflowExecutionCanceledEventAttributes =
      ChildWorkflowExecutionCanceledEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(details)(_.details(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def childWorkflowExecutionCompletedEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      result: Option[String] = None,
      initiatedEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): ChildWorkflowExecutionCompletedEventAttributes =
      ChildWorkflowExecutionCompletedEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(result)(_.result(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def childWorkflowExecutionFailedEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      reason: Option[String] = None,
      details: Option[String] = None,
      initiatedEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): ChildWorkflowExecutionFailedEventAttributes =
      ChildWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def childWorkflowExecutionStartedEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      initiatedEventId: Option[EventId] = None
    ): ChildWorkflowExecutionStartedEventAttributes =
      ChildWorkflowExecutionStartedEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .build

    def childWorkflowExecutionTerminatedEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      initiatedEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): ChildWorkflowExecutionTerminatedEventAttributes =
      ChildWorkflowExecutionTerminatedEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def childWorkflowExecutionTimedOutEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      timeoutType: Option[String] = None,
      initiatedEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): ChildWorkflowExecutionTimedOutEventAttributes =
      ChildWorkflowExecutionTimedOutEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(timeoutType)(_.timeoutType(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def closeStatusFilter(
      status: Option[String] = None
    ): CloseStatusFilter =
      CloseStatusFilter
        .builder
        .ifSome(status)(_.status(_))
        .build

    def completeWorkflowExecutionDecisionAttributes(
      result: Option[String] = None
    ): CompleteWorkflowExecutionDecisionAttributes =
      CompleteWorkflowExecutionDecisionAttributes
        .builder
        .ifSome(result)(_.result(_))
        .build

    def completeWorkflowExecutionFailedEventAttributes(
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): CompleteWorkflowExecutionFailedEventAttributes =
      CompleteWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def continueAsNewWorkflowExecutionDecisionAttributes(
      input: Option[String] = None,
      executionStartToCloseTimeout: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      taskStartToCloseTimeout: Option[String] = None,
      childPolicy: Option[String] = None,
      tagList: Option[List[Tag]] = None,
      workflowTypeVersion: Option[String] = None,
      lambdaRole: Option[String] = None
    ): ContinueAsNewWorkflowExecutionDecisionAttributes =
      ContinueAsNewWorkflowExecutionDecisionAttributes
        .builder
        .ifSome(input)(_.input(_))
        .ifSome(executionStartToCloseTimeout)(_.executionStartToCloseTimeout(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(taskStartToCloseTimeout)(_.taskStartToCloseTimeout(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(workflowTypeVersion)(_.workflowTypeVersion(_))
        .ifSome(lambdaRole)(_.lambdaRole(_))
        .build

    def continueAsNewWorkflowExecutionFailedEventAttributes(
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): ContinueAsNewWorkflowExecutionFailedEventAttributes =
      ContinueAsNewWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def countClosedWorkflowExecutionsInput(
      domain: Option[String] = None,
      startTimeFilter: Option[ExecutionTimeFilter] = None,
      closeTimeFilter: Option[ExecutionTimeFilter] = None,
      executionFilter: Option[WorkflowExecutionFilter] = None,
      typeFilter: Option[WorkflowTypeFilter] = None,
      tagFilter: Option[TagFilter] = None,
      closeStatusFilter: Option[CloseStatusFilter] = None
    ): CountClosedWorkflowExecutionsInput =
      CountClosedWorkflowExecutionsInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(startTimeFilter)(_.startTimeFilter(_))
        .ifSome(closeTimeFilter)(_.closeTimeFilter(_))
        .ifSome(executionFilter)(_.executionFilter(_))
        .ifSome(typeFilter)(_.typeFilter(_))
        .ifSome(tagFilter)(_.tagFilter(_))
        .ifSome(closeStatusFilter)(_.closeStatusFilter(_))
        .build

    def countOpenWorkflowExecutionsInput(
      domain: Option[String] = None,
      startTimeFilter: Option[ExecutionTimeFilter] = None,
      typeFilter: Option[WorkflowTypeFilter] = None,
      tagFilter: Option[TagFilter] = None,
      executionFilter: Option[WorkflowExecutionFilter] = None
    ): CountOpenWorkflowExecutionsInput =
      CountOpenWorkflowExecutionsInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(startTimeFilter)(_.startTimeFilter(_))
        .ifSome(typeFilter)(_.typeFilter(_))
        .ifSome(tagFilter)(_.tagFilter(_))
        .ifSome(executionFilter)(_.executionFilter(_))
        .build

    def countPendingActivityTasksInput(
      domain: Option[String] = None,
      taskList: Option[TaskList] = None
    ): CountPendingActivityTasksInput =
      CountPendingActivityTasksInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(taskList)(_.taskList(_))
        .build

    def countPendingDecisionTasksInput(
      domain: Option[String] = None,
      taskList: Option[TaskList] = None
    ): CountPendingDecisionTasksInput =
      CountPendingDecisionTasksInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(taskList)(_.taskList(_))
        .build

    def decision(
      decisionType: Option[String] = None,
      scheduleActivityTaskDecisionAttributes: Option[ScheduleActivityTaskDecisionAttributes] = None,
      requestCancelActivityTaskDecisionAttributes: Option[RequestCancelActivityTaskDecisionAttributes] = None,
      completeWorkflowExecutionDecisionAttributes: Option[CompleteWorkflowExecutionDecisionAttributes] = None,
      failWorkflowExecutionDecisionAttributes: Option[FailWorkflowExecutionDecisionAttributes] = None,
      cancelWorkflowExecutionDecisionAttributes: Option[CancelWorkflowExecutionDecisionAttributes] = None,
      continueAsNewWorkflowExecutionDecisionAttributes: Option[ContinueAsNewWorkflowExecutionDecisionAttributes] = None,
      recordMarkerDecisionAttributes: Option[RecordMarkerDecisionAttributes] = None,
      startTimerDecisionAttributes: Option[StartTimerDecisionAttributes] = None,
      cancelTimerDecisionAttributes: Option[CancelTimerDecisionAttributes] = None,
      signalExternalWorkflowExecutionDecisionAttributes: Option[SignalExternalWorkflowExecutionDecisionAttributes] = None,
      requestCancelExternalWorkflowExecutionDecisionAttributes: Option[RequestCancelExternalWorkflowExecutionDecisionAttributes] = None,
      startChildWorkflowExecutionDecisionAttributes: Option[StartChildWorkflowExecutionDecisionAttributes] = None,
      scheduleLambdaFunctionDecisionAttributes: Option[ScheduleLambdaFunctionDecisionAttributes] = None
    ): Decision =
      Decision
        .builder
        .ifSome(decisionType)(_.decisionType(_))
        .ifSome(scheduleActivityTaskDecisionAttributes)(_.scheduleActivityTaskDecisionAttributes(_))
        .ifSome(requestCancelActivityTaskDecisionAttributes)(_.requestCancelActivityTaskDecisionAttributes(_))
        .ifSome(completeWorkflowExecutionDecisionAttributes)(_.completeWorkflowExecutionDecisionAttributes(_))
        .ifSome(failWorkflowExecutionDecisionAttributes)(_.failWorkflowExecutionDecisionAttributes(_))
        .ifSome(cancelWorkflowExecutionDecisionAttributes)(_.cancelWorkflowExecutionDecisionAttributes(_))
        .ifSome(continueAsNewWorkflowExecutionDecisionAttributes)(_.continueAsNewWorkflowExecutionDecisionAttributes(_))
        .ifSome(recordMarkerDecisionAttributes)(_.recordMarkerDecisionAttributes(_))
        .ifSome(startTimerDecisionAttributes)(_.startTimerDecisionAttributes(_))
        .ifSome(cancelTimerDecisionAttributes)(_.cancelTimerDecisionAttributes(_))
        .ifSome(signalExternalWorkflowExecutionDecisionAttributes)(_.signalExternalWorkflowExecutionDecisionAttributes(_))
        .ifSome(requestCancelExternalWorkflowExecutionDecisionAttributes)(_.requestCancelExternalWorkflowExecutionDecisionAttributes(_))
        .ifSome(startChildWorkflowExecutionDecisionAttributes)(_.startChildWorkflowExecutionDecisionAttributes(_))
        .ifSome(scheduleLambdaFunctionDecisionAttributes)(_.scheduleLambdaFunctionDecisionAttributes(_))
        .build

    def decisionTask(
      taskToken: Option[String] = None,
      startedEventId: Option[EventId] = None,
      workflowExecution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      events: Option[List[HistoryEvent]] = None,
      nextPageToken: Option[String] = None,
      previousStartedEventId: Option[EventId] = None
    ): DecisionTask =
      DecisionTask
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(events)(_.events(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(previousStartedEventId)(_.previousStartedEventId(_))
        .build

    def decisionTaskCompletedEventAttributes(
      executionContext: Option[String] = None,
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): DecisionTaskCompletedEventAttributes =
      DecisionTaskCompletedEventAttributes
        .builder
        .ifSome(executionContext)(_.executionContext(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def decisionTaskScheduledEventAttributes(
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      startToCloseTimeout: Option[String] = None
    ): DecisionTaskScheduledEventAttributes =
      DecisionTaskScheduledEventAttributes
        .builder
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(startToCloseTimeout)(_.startToCloseTimeout(_))
        .build

    def decisionTaskStartedEventAttributes(
      identity: Option[String] = None,
      scheduledEventId: Option[EventId] = None
    ): DecisionTaskStartedEventAttributes =
      DecisionTaskStartedEventAttributes
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .build

    def decisionTaskTimedOutEventAttributes(
      timeoutType: Option[String] = None,
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None
    ): DecisionTaskTimedOutEventAttributes =
      DecisionTaskTimedOutEventAttributes
        .builder
        .ifSome(timeoutType)(_.timeoutType(_))
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def defaultUndefinedFault(
      message: Option[String] = None
    ): DefaultUndefinedFault =
      DefaultUndefinedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deprecateActivityTypeInput(
      domain: Option[String] = None,
      activityType: Option[ActivityType] = None
    ): DeprecateActivityTypeInput =
      DeprecateActivityTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(activityType)(_.activityType(_))
        .build

    def deprecateDomainInput(
      name: Option[String] = None
    ): DeprecateDomainInput =
      DeprecateDomainInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deprecateWorkflowTypeInput(
      domain: Option[String] = None,
      workflowType: Option[WorkflowType] = None
    ): DeprecateWorkflowTypeInput =
      DeprecateWorkflowTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(workflowType)(_.workflowType(_))
        .build

    def describeActivityTypeInput(
      domain: Option[String] = None,
      activityType: Option[ActivityType] = None
    ): DescribeActivityTypeInput =
      DescribeActivityTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(activityType)(_.activityType(_))
        .build

    def describeDomainInput(
      name: Option[String] = None
    ): DescribeDomainInput =
      DescribeDomainInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeWorkflowExecutionInput(
      domain: Option[String] = None,
      execution: Option[WorkflowExecution] = None
    ): DescribeWorkflowExecutionInput =
      DescribeWorkflowExecutionInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(execution)(_.execution(_))
        .build

    def describeWorkflowTypeInput(
      domain: Option[String] = None,
      workflowType: Option[WorkflowType] = None
    ): DescribeWorkflowTypeInput =
      DescribeWorkflowTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(workflowType)(_.workflowType(_))
        .build

    def domainAlreadyExistsFault(
      message: Option[String] = None
    ): DomainAlreadyExistsFault =
      DomainAlreadyExistsFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def domainConfiguration(
      workflowExecutionRetentionPeriodInDays: Option[String] = None
    ): DomainConfiguration =
      DomainConfiguration
        .builder
        .ifSome(workflowExecutionRetentionPeriodInDays)(_.workflowExecutionRetentionPeriodInDays(_))
        .build

    def domainDeprecatedFault(
      message: Option[String] = None
    ): DomainDeprecatedFault =
      DomainDeprecatedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def domainDetail(
      domainInfo: Option[DomainInfo] = None,
      configuration: Option[DomainConfiguration] = None
    ): DomainDetail =
      DomainDetail
        .builder
        .ifSome(domainInfo)(_.domainInfo(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def domainInfo(
      name: Option[String] = None,
      status: Option[String] = None,
      description: Option[String] = None,
      arn: Option[String] = None
    ): DomainInfo =
      DomainInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .ifSome(arn)(_.arn(_))
        .build

    def domainInfos(
      domainInfos: Option[List[DomainInfo]] = None,
      nextPageToken: Option[String] = None
    ): DomainInfos =
      DomainInfos
        .builder
        .ifSome(domainInfos)(_.domainInfos(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def executionTimeFilter(
      oldestDate: Option[Timestamp] = None,
      latestDate: Option[Timestamp] = None
    ): ExecutionTimeFilter =
      ExecutionTimeFilter
        .builder
        .ifSome(oldestDate)(_.oldestDate(_))
        .ifSome(latestDate)(_.latestDate(_))
        .build

    def externalWorkflowExecutionCancelRequestedEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      initiatedEventId: Option[EventId] = None
    ): ExternalWorkflowExecutionCancelRequestedEventAttributes =
      ExternalWorkflowExecutionCancelRequestedEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .build

    def externalWorkflowExecutionSignaledEventAttributes(
      workflowExecution: Option[WorkflowExecution] = None,
      initiatedEventId: Option[EventId] = None
    ): ExternalWorkflowExecutionSignaledEventAttributes =
      ExternalWorkflowExecutionSignaledEventAttributes
        .builder
        .ifSome(workflowExecution)(_.workflowExecution(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .build

    def failWorkflowExecutionDecisionAttributes(
      reason: Option[String] = None,
      details: Option[String] = None
    ): FailWorkflowExecutionDecisionAttributes =
      FailWorkflowExecutionDecisionAttributes
        .builder
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .build

    def failWorkflowExecutionFailedEventAttributes(
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): FailWorkflowExecutionFailedEventAttributes =
      FailWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def getWorkflowExecutionHistoryInput(
      domain: Option[String] = None,
      execution: Option[WorkflowExecution] = None,
      nextPageToken: Option[String] = None,
      maximumPageSize: Option[Int] = None,
      reverseOrder: Option[Boolean] = None
    ): GetWorkflowExecutionHistoryInput =
      GetWorkflowExecutionHistoryInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(execution)(_.execution(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maximumPageSize)(_.maximumPageSize(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .build

    def history(
      events: Option[List[HistoryEvent]] = None,
      nextPageToken: Option[String] = None
    ): History =
      History
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def historyEvent(
      eventTimestamp: Option[Timestamp] = None,
      eventType: Option[String] = None,
      eventId: Option[EventId] = None,
      workflowExecutionStartedEventAttributes: Option[WorkflowExecutionStartedEventAttributes] = None,
      workflowExecutionCompletedEventAttributes: Option[WorkflowExecutionCompletedEventAttributes] = None,
      completeWorkflowExecutionFailedEventAttributes: Option[CompleteWorkflowExecutionFailedEventAttributes] = None,
      workflowExecutionFailedEventAttributes: Option[WorkflowExecutionFailedEventAttributes] = None,
      failWorkflowExecutionFailedEventAttributes: Option[FailWorkflowExecutionFailedEventAttributes] = None,
      workflowExecutionTimedOutEventAttributes: Option[WorkflowExecutionTimedOutEventAttributes] = None,
      workflowExecutionCanceledEventAttributes: Option[WorkflowExecutionCanceledEventAttributes] = None,
      cancelWorkflowExecutionFailedEventAttributes: Option[CancelWorkflowExecutionFailedEventAttributes] = None,
      workflowExecutionContinuedAsNewEventAttributes: Option[WorkflowExecutionContinuedAsNewEventAttributes] = None,
      continueAsNewWorkflowExecutionFailedEventAttributes: Option[ContinueAsNewWorkflowExecutionFailedEventAttributes] = None,
      workflowExecutionTerminatedEventAttributes: Option[WorkflowExecutionTerminatedEventAttributes] = None,
      workflowExecutionCancelRequestedEventAttributes: Option[WorkflowExecutionCancelRequestedEventAttributes] = None,
      decisionTaskScheduledEventAttributes: Option[DecisionTaskScheduledEventAttributes] = None,
      decisionTaskStartedEventAttributes: Option[DecisionTaskStartedEventAttributes] = None,
      decisionTaskCompletedEventAttributes: Option[DecisionTaskCompletedEventAttributes] = None,
      decisionTaskTimedOutEventAttributes: Option[DecisionTaskTimedOutEventAttributes] = None,
      activityTaskScheduledEventAttributes: Option[ActivityTaskScheduledEventAttributes] = None,
      activityTaskStartedEventAttributes: Option[ActivityTaskStartedEventAttributes] = None,
      activityTaskCompletedEventAttributes: Option[ActivityTaskCompletedEventAttributes] = None,
      activityTaskFailedEventAttributes: Option[ActivityTaskFailedEventAttributes] = None,
      activityTaskTimedOutEventAttributes: Option[ActivityTaskTimedOutEventAttributes] = None,
      activityTaskCanceledEventAttributes: Option[ActivityTaskCanceledEventAttributes] = None,
      activityTaskCancelRequestedEventAttributes: Option[ActivityTaskCancelRequestedEventAttributes] = None,
      workflowExecutionSignaledEventAttributes: Option[WorkflowExecutionSignaledEventAttributes] = None,
      markerRecordedEventAttributes: Option[MarkerRecordedEventAttributes] = None,
      recordMarkerFailedEventAttributes: Option[RecordMarkerFailedEventAttributes] = None,
      timerStartedEventAttributes: Option[TimerStartedEventAttributes] = None,
      timerFiredEventAttributes: Option[TimerFiredEventAttributes] = None,
      timerCanceledEventAttributes: Option[TimerCanceledEventAttributes] = None,
      startChildWorkflowExecutionInitiatedEventAttributes: Option[StartChildWorkflowExecutionInitiatedEventAttributes] = None,
      childWorkflowExecutionStartedEventAttributes: Option[ChildWorkflowExecutionStartedEventAttributes] = None,
      childWorkflowExecutionCompletedEventAttributes: Option[ChildWorkflowExecutionCompletedEventAttributes] = None,
      childWorkflowExecutionFailedEventAttributes: Option[ChildWorkflowExecutionFailedEventAttributes] = None,
      childWorkflowExecutionTimedOutEventAttributes: Option[ChildWorkflowExecutionTimedOutEventAttributes] = None,
      childWorkflowExecutionCanceledEventAttributes: Option[ChildWorkflowExecutionCanceledEventAttributes] = None,
      childWorkflowExecutionTerminatedEventAttributes: Option[ChildWorkflowExecutionTerminatedEventAttributes] = None,
      signalExternalWorkflowExecutionInitiatedEventAttributes: Option[SignalExternalWorkflowExecutionInitiatedEventAttributes] = None,
      externalWorkflowExecutionSignaledEventAttributes: Option[ExternalWorkflowExecutionSignaledEventAttributes] = None,
      signalExternalWorkflowExecutionFailedEventAttributes: Option[SignalExternalWorkflowExecutionFailedEventAttributes] = None,
      externalWorkflowExecutionCancelRequestedEventAttributes: Option[ExternalWorkflowExecutionCancelRequestedEventAttributes] = None,
      requestCancelExternalWorkflowExecutionInitiatedEventAttributes: Option[RequestCancelExternalWorkflowExecutionInitiatedEventAttributes] = None,
      requestCancelExternalWorkflowExecutionFailedEventAttributes: Option[RequestCancelExternalWorkflowExecutionFailedEventAttributes] = None,
      scheduleActivityTaskFailedEventAttributes: Option[ScheduleActivityTaskFailedEventAttributes] = None,
      requestCancelActivityTaskFailedEventAttributes: Option[RequestCancelActivityTaskFailedEventAttributes] = None,
      startTimerFailedEventAttributes: Option[StartTimerFailedEventAttributes] = None,
      cancelTimerFailedEventAttributes: Option[CancelTimerFailedEventAttributes] = None,
      startChildWorkflowExecutionFailedEventAttributes: Option[StartChildWorkflowExecutionFailedEventAttributes] = None,
      lambdaFunctionScheduledEventAttributes: Option[LambdaFunctionScheduledEventAttributes] = None,
      lambdaFunctionStartedEventAttributes: Option[LambdaFunctionStartedEventAttributes] = None,
      lambdaFunctionCompletedEventAttributes: Option[LambdaFunctionCompletedEventAttributes] = None,
      lambdaFunctionFailedEventAttributes: Option[LambdaFunctionFailedEventAttributes] = None,
      lambdaFunctionTimedOutEventAttributes: Option[LambdaFunctionTimedOutEventAttributes] = None,
      scheduleLambdaFunctionFailedEventAttributes: Option[ScheduleLambdaFunctionFailedEventAttributes] = None,
      startLambdaFunctionFailedEventAttributes: Option[StartLambdaFunctionFailedEventAttributes] = None
    ): HistoryEvent =
      HistoryEvent
        .builder
        .ifSome(eventTimestamp)(_.eventTimestamp(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(workflowExecutionStartedEventAttributes)(_.workflowExecutionStartedEventAttributes(_))
        .ifSome(workflowExecutionCompletedEventAttributes)(_.workflowExecutionCompletedEventAttributes(_))
        .ifSome(completeWorkflowExecutionFailedEventAttributes)(_.completeWorkflowExecutionFailedEventAttributes(_))
        .ifSome(workflowExecutionFailedEventAttributes)(_.workflowExecutionFailedEventAttributes(_))
        .ifSome(failWorkflowExecutionFailedEventAttributes)(_.failWorkflowExecutionFailedEventAttributes(_))
        .ifSome(workflowExecutionTimedOutEventAttributes)(_.workflowExecutionTimedOutEventAttributes(_))
        .ifSome(workflowExecutionCanceledEventAttributes)(_.workflowExecutionCanceledEventAttributes(_))
        .ifSome(cancelWorkflowExecutionFailedEventAttributes)(_.cancelWorkflowExecutionFailedEventAttributes(_))
        .ifSome(workflowExecutionContinuedAsNewEventAttributes)(_.workflowExecutionContinuedAsNewEventAttributes(_))
        .ifSome(continueAsNewWorkflowExecutionFailedEventAttributes)(_.continueAsNewWorkflowExecutionFailedEventAttributes(_))
        .ifSome(workflowExecutionTerminatedEventAttributes)(_.workflowExecutionTerminatedEventAttributes(_))
        .ifSome(workflowExecutionCancelRequestedEventAttributes)(_.workflowExecutionCancelRequestedEventAttributes(_))
        .ifSome(decisionTaskScheduledEventAttributes)(_.decisionTaskScheduledEventAttributes(_))
        .ifSome(decisionTaskStartedEventAttributes)(_.decisionTaskStartedEventAttributes(_))
        .ifSome(decisionTaskCompletedEventAttributes)(_.decisionTaskCompletedEventAttributes(_))
        .ifSome(decisionTaskTimedOutEventAttributes)(_.decisionTaskTimedOutEventAttributes(_))
        .ifSome(activityTaskScheduledEventAttributes)(_.activityTaskScheduledEventAttributes(_))
        .ifSome(activityTaskStartedEventAttributes)(_.activityTaskStartedEventAttributes(_))
        .ifSome(activityTaskCompletedEventAttributes)(_.activityTaskCompletedEventAttributes(_))
        .ifSome(activityTaskFailedEventAttributes)(_.activityTaskFailedEventAttributes(_))
        .ifSome(activityTaskTimedOutEventAttributes)(_.activityTaskTimedOutEventAttributes(_))
        .ifSome(activityTaskCanceledEventAttributes)(_.activityTaskCanceledEventAttributes(_))
        .ifSome(activityTaskCancelRequestedEventAttributes)(_.activityTaskCancelRequestedEventAttributes(_))
        .ifSome(workflowExecutionSignaledEventAttributes)(_.workflowExecutionSignaledEventAttributes(_))
        .ifSome(markerRecordedEventAttributes)(_.markerRecordedEventAttributes(_))
        .ifSome(recordMarkerFailedEventAttributes)(_.recordMarkerFailedEventAttributes(_))
        .ifSome(timerStartedEventAttributes)(_.timerStartedEventAttributes(_))
        .ifSome(timerFiredEventAttributes)(_.timerFiredEventAttributes(_))
        .ifSome(timerCanceledEventAttributes)(_.timerCanceledEventAttributes(_))
        .ifSome(startChildWorkflowExecutionInitiatedEventAttributes)(_.startChildWorkflowExecutionInitiatedEventAttributes(_))
        .ifSome(childWorkflowExecutionStartedEventAttributes)(_.childWorkflowExecutionStartedEventAttributes(_))
        .ifSome(childWorkflowExecutionCompletedEventAttributes)(_.childWorkflowExecutionCompletedEventAttributes(_))
        .ifSome(childWorkflowExecutionFailedEventAttributes)(_.childWorkflowExecutionFailedEventAttributes(_))
        .ifSome(childWorkflowExecutionTimedOutEventAttributes)(_.childWorkflowExecutionTimedOutEventAttributes(_))
        .ifSome(childWorkflowExecutionCanceledEventAttributes)(_.childWorkflowExecutionCanceledEventAttributes(_))
        .ifSome(childWorkflowExecutionTerminatedEventAttributes)(_.childWorkflowExecutionTerminatedEventAttributes(_))
        .ifSome(signalExternalWorkflowExecutionInitiatedEventAttributes)(_.signalExternalWorkflowExecutionInitiatedEventAttributes(_))
        .ifSome(externalWorkflowExecutionSignaledEventAttributes)(_.externalWorkflowExecutionSignaledEventAttributes(_))
        .ifSome(signalExternalWorkflowExecutionFailedEventAttributes)(_.signalExternalWorkflowExecutionFailedEventAttributes(_))
        .ifSome(externalWorkflowExecutionCancelRequestedEventAttributes)(_.externalWorkflowExecutionCancelRequestedEventAttributes(_))
        .ifSome(requestCancelExternalWorkflowExecutionInitiatedEventAttributes)(_.requestCancelExternalWorkflowExecutionInitiatedEventAttributes(_))
        .ifSome(requestCancelExternalWorkflowExecutionFailedEventAttributes)(_.requestCancelExternalWorkflowExecutionFailedEventAttributes(_))
        .ifSome(scheduleActivityTaskFailedEventAttributes)(_.scheduleActivityTaskFailedEventAttributes(_))
        .ifSome(requestCancelActivityTaskFailedEventAttributes)(_.requestCancelActivityTaskFailedEventAttributes(_))
        .ifSome(startTimerFailedEventAttributes)(_.startTimerFailedEventAttributes(_))
        .ifSome(cancelTimerFailedEventAttributes)(_.cancelTimerFailedEventAttributes(_))
        .ifSome(startChildWorkflowExecutionFailedEventAttributes)(_.startChildWorkflowExecutionFailedEventAttributes(_))
        .ifSome(lambdaFunctionScheduledEventAttributes)(_.lambdaFunctionScheduledEventAttributes(_))
        .ifSome(lambdaFunctionStartedEventAttributes)(_.lambdaFunctionStartedEventAttributes(_))
        .ifSome(lambdaFunctionCompletedEventAttributes)(_.lambdaFunctionCompletedEventAttributes(_))
        .ifSome(lambdaFunctionFailedEventAttributes)(_.lambdaFunctionFailedEventAttributes(_))
        .ifSome(lambdaFunctionTimedOutEventAttributes)(_.lambdaFunctionTimedOutEventAttributes(_))
        .ifSome(scheduleLambdaFunctionFailedEventAttributes)(_.scheduleLambdaFunctionFailedEventAttributes(_))
        .ifSome(startLambdaFunctionFailedEventAttributes)(_.startLambdaFunctionFailedEventAttributes(_))
        .build

    def lambdaFunctionCompletedEventAttributes(
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None,
      result: Option[String] = None
    ): LambdaFunctionCompletedEventAttributes =
      LambdaFunctionCompletedEventAttributes
        .builder
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(result)(_.result(_))
        .build

    def lambdaFunctionFailedEventAttributes(
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None,
      reason: Option[String] = None,
      details: Option[String] = None
    ): LambdaFunctionFailedEventAttributes =
      LambdaFunctionFailedEventAttributes
        .builder
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .build

    def lambdaFunctionScheduledEventAttributes(
      id: Option[String] = None,
      name: Option[String] = None,
      control: Option[String] = None,
      input: Option[String] = None,
      startToCloseTimeout: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): LambdaFunctionScheduledEventAttributes =
      LambdaFunctionScheduledEventAttributes
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(control)(_.control(_))
        .ifSome(input)(_.input(_))
        .ifSome(startToCloseTimeout)(_.startToCloseTimeout(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def lambdaFunctionStartedEventAttributes(
      scheduledEventId: Option[EventId] = None
    ): LambdaFunctionStartedEventAttributes =
      LambdaFunctionStartedEventAttributes
        .builder
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .build

    def lambdaFunctionTimedOutEventAttributes(
      scheduledEventId: Option[EventId] = None,
      startedEventId: Option[EventId] = None,
      timeoutType: Option[String] = None
    ): LambdaFunctionTimedOutEventAttributes =
      LambdaFunctionTimedOutEventAttributes
        .builder
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(timeoutType)(_.timeoutType(_))
        .build

    def limitExceededFault(
      message: Option[String] = None
    ): LimitExceededFault =
      LimitExceededFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listActivityTypesInput(
      domain: Option[String] = None,
      name: Option[String] = None,
      registrationStatus: Option[String] = None,
      nextPageToken: Option[String] = None,
      maximumPageSize: Option[Int] = None,
      reverseOrder: Option[Boolean] = None
    ): ListActivityTypesInput =
      ListActivityTypesInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(name)(_.name(_))
        .ifSome(registrationStatus)(_.registrationStatus(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maximumPageSize)(_.maximumPageSize(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .build

    def listClosedWorkflowExecutionsInput(
      domain: Option[String] = None,
      startTimeFilter: Option[ExecutionTimeFilter] = None,
      closeTimeFilter: Option[ExecutionTimeFilter] = None,
      executionFilter: Option[WorkflowExecutionFilter] = None,
      closeStatusFilter: Option[CloseStatusFilter] = None,
      typeFilter: Option[WorkflowTypeFilter] = None,
      tagFilter: Option[TagFilter] = None,
      nextPageToken: Option[String] = None,
      maximumPageSize: Option[Int] = None,
      reverseOrder: Option[Boolean] = None
    ): ListClosedWorkflowExecutionsInput =
      ListClosedWorkflowExecutionsInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(startTimeFilter)(_.startTimeFilter(_))
        .ifSome(closeTimeFilter)(_.closeTimeFilter(_))
        .ifSome(executionFilter)(_.executionFilter(_))
        .ifSome(closeStatusFilter)(_.closeStatusFilter(_))
        .ifSome(typeFilter)(_.typeFilter(_))
        .ifSome(tagFilter)(_.tagFilter(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maximumPageSize)(_.maximumPageSize(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .build

    def listDomainsInput(
      nextPageToken: Option[String] = None,
      registrationStatus: Option[String] = None,
      maximumPageSize: Option[Int] = None,
      reverseOrder: Option[Boolean] = None
    ): ListDomainsInput =
      ListDomainsInput
        .builder
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(registrationStatus)(_.registrationStatus(_))
        .ifSome(maximumPageSize)(_.maximumPageSize(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .build

    def listOpenWorkflowExecutionsInput(
      domain: Option[String] = None,
      startTimeFilter: Option[ExecutionTimeFilter] = None,
      typeFilter: Option[WorkflowTypeFilter] = None,
      tagFilter: Option[TagFilter] = None,
      nextPageToken: Option[String] = None,
      maximumPageSize: Option[Int] = None,
      reverseOrder: Option[Boolean] = None,
      executionFilter: Option[WorkflowExecutionFilter] = None
    ): ListOpenWorkflowExecutionsInput =
      ListOpenWorkflowExecutionsInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(startTimeFilter)(_.startTimeFilter(_))
        .ifSome(typeFilter)(_.typeFilter(_))
        .ifSome(tagFilter)(_.tagFilter(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maximumPageSize)(_.maximumPageSize(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .ifSome(executionFilter)(_.executionFilter(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[ResourceTag]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listWorkflowTypesInput(
      domain: Option[String] = None,
      name: Option[String] = None,
      registrationStatus: Option[String] = None,
      nextPageToken: Option[String] = None,
      maximumPageSize: Option[Int] = None,
      reverseOrder: Option[Boolean] = None
    ): ListWorkflowTypesInput =
      ListWorkflowTypesInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(name)(_.name(_))
        .ifSome(registrationStatus)(_.registrationStatus(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maximumPageSize)(_.maximumPageSize(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .build

    def markerRecordedEventAttributes(
      markerName: Option[String] = None,
      details: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): MarkerRecordedEventAttributes =
      MarkerRecordedEventAttributes
        .builder
        .ifSome(markerName)(_.markerName(_))
        .ifSome(details)(_.details(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def operationNotPermittedFault(
      message: Option[String] = None
    ): OperationNotPermittedFault =
      OperationNotPermittedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pendingTaskCount(
      count: Option[Int] = None,
      truncated: Option[Boolean] = None
    ): PendingTaskCount =
      PendingTaskCount
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def pollForActivityTaskInput(
      domain: Option[String] = None,
      taskList: Option[TaskList] = None,
      identity: Option[String] = None
    ): PollForActivityTaskInput =
      PollForActivityTaskInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(identity)(_.identity(_))
        .build

    def pollForDecisionTaskInput(
      domain: Option[String] = None,
      taskList: Option[TaskList] = None,
      identity: Option[String] = None,
      nextPageToken: Option[String] = None,
      maximumPageSize: Option[Int] = None,
      reverseOrder: Option[Boolean] = None
    ): PollForDecisionTaskInput =
      PollForDecisionTaskInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(identity)(_.identity(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maximumPageSize)(_.maximumPageSize(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .build

    def recordActivityTaskHeartbeatInput(
      taskToken: Option[String] = None,
      details: Option[String] = None
    ): RecordActivityTaskHeartbeatInput =
      RecordActivityTaskHeartbeatInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(details)(_.details(_))
        .build

    def recordMarkerDecisionAttributes(
      markerName: Option[String] = None,
      details: Option[String] = None
    ): RecordMarkerDecisionAttributes =
      RecordMarkerDecisionAttributes
        .builder
        .ifSome(markerName)(_.markerName(_))
        .ifSome(details)(_.details(_))
        .build

    def recordMarkerFailedEventAttributes(
      markerName: Option[String] = None,
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): RecordMarkerFailedEventAttributes =
      RecordMarkerFailedEventAttributes
        .builder
        .ifSome(markerName)(_.markerName(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def registerActivityTypeInput(
      domain: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      description: Option[String] = None,
      defaultTaskStartToCloseTimeout: Option[String] = None,
      defaultTaskHeartbeatTimeout: Option[String] = None,
      defaultTaskList: Option[TaskList] = None,
      defaultTaskPriority: Option[String] = None,
      defaultTaskScheduleToStartTimeout: Option[String] = None,
      defaultTaskScheduleToCloseTimeout: Option[String] = None
    ): RegisterActivityTypeInput =
      RegisterActivityTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultTaskStartToCloseTimeout)(_.defaultTaskStartToCloseTimeout(_))
        .ifSome(defaultTaskHeartbeatTimeout)(_.defaultTaskHeartbeatTimeout(_))
        .ifSome(defaultTaskList)(_.defaultTaskList(_))
        .ifSome(defaultTaskPriority)(_.defaultTaskPriority(_))
        .ifSome(defaultTaskScheduleToStartTimeout)(_.defaultTaskScheduleToStartTimeout(_))
        .ifSome(defaultTaskScheduleToCloseTimeout)(_.defaultTaskScheduleToCloseTimeout(_))
        .build

    def registerDomainInput(
      name: Option[String] = None,
      description: Option[String] = None,
      workflowExecutionRetentionPeriodInDays: Option[String] = None,
      tags: Option[List[ResourceTag]] = None
    ): RegisterDomainInput =
      RegisterDomainInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(workflowExecutionRetentionPeriodInDays)(_.workflowExecutionRetentionPeriodInDays(_))
        .ifSome(tags)(_.tags(_))
        .build

    def registerWorkflowTypeInput(
      domain: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      description: Option[String] = None,
      defaultTaskStartToCloseTimeout: Option[String] = None,
      defaultExecutionStartToCloseTimeout: Option[String] = None,
      defaultTaskList: Option[TaskList] = None,
      defaultTaskPriority: Option[String] = None,
      defaultChildPolicy: Option[String] = None,
      defaultLambdaRole: Option[String] = None
    ): RegisterWorkflowTypeInput =
      RegisterWorkflowTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultTaskStartToCloseTimeout)(_.defaultTaskStartToCloseTimeout(_))
        .ifSome(defaultExecutionStartToCloseTimeout)(_.defaultExecutionStartToCloseTimeout(_))
        .ifSome(defaultTaskList)(_.defaultTaskList(_))
        .ifSome(defaultTaskPriority)(_.defaultTaskPriority(_))
        .ifSome(defaultChildPolicy)(_.defaultChildPolicy(_))
        .ifSome(defaultLambdaRole)(_.defaultLambdaRole(_))
        .build

    def requestCancelActivityTaskDecisionAttributes(
      activityId: Option[String] = None
    ): RequestCancelActivityTaskDecisionAttributes =
      RequestCancelActivityTaskDecisionAttributes
        .builder
        .ifSome(activityId)(_.activityId(_))
        .build

    def requestCancelActivityTaskFailedEventAttributes(
      activityId: Option[String] = None,
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): RequestCancelActivityTaskFailedEventAttributes =
      RequestCancelActivityTaskFailedEventAttributes
        .builder
        .ifSome(activityId)(_.activityId(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def requestCancelExternalWorkflowExecutionDecisionAttributes(
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      control: Option[String] = None
    ): RequestCancelExternalWorkflowExecutionDecisionAttributes =
      RequestCancelExternalWorkflowExecutionDecisionAttributes
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(control)(_.control(_))
        .build

    def requestCancelExternalWorkflowExecutionFailedEventAttributes(
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      cause: Option[String] = None,
      initiatedEventId: Option[EventId] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      control: Option[String] = None
    ): RequestCancelExternalWorkflowExecutionFailedEventAttributes =
      RequestCancelExternalWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(control)(_.control(_))
        .build

    def requestCancelExternalWorkflowExecutionInitiatedEventAttributes(
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      control: Option[String] = None
    ): RequestCancelExternalWorkflowExecutionInitiatedEventAttributes =
      RequestCancelExternalWorkflowExecutionInitiatedEventAttributes
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(control)(_.control(_))
        .build

    def requestCancelWorkflowExecutionInput(
      domain: Option[String] = None,
      workflowId: Option[String] = None,
      runId: Option[String] = None
    ): RequestCancelWorkflowExecutionInput =
      RequestCancelWorkflowExecutionInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .build

    def resourceTag(
      key: Option[String] = None,
      value: Option[String] = None
    ): ResourceTag =
      ResourceTag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def respondActivityTaskCanceledInput(
      taskToken: Option[String] = None,
      details: Option[String] = None
    ): RespondActivityTaskCanceledInput =
      RespondActivityTaskCanceledInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(details)(_.details(_))
        .build

    def respondActivityTaskCompletedInput(
      taskToken: Option[String] = None,
      result: Option[String] = None
    ): RespondActivityTaskCompletedInput =
      RespondActivityTaskCompletedInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(result)(_.result(_))
        .build

    def respondActivityTaskFailedInput(
      taskToken: Option[String] = None,
      reason: Option[String] = None,
      details: Option[String] = None
    ): RespondActivityTaskFailedInput =
      RespondActivityTaskFailedInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .build

    def respondDecisionTaskCompletedInput(
      taskToken: Option[String] = None,
      decisions: Option[List[Decision]] = None,
      executionContext: Option[String] = None
    ): RespondDecisionTaskCompletedInput =
      RespondDecisionTaskCompletedInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(decisions)(_.decisions(_))
        .ifSome(executionContext)(_.executionContext(_))
        .build

    def run(
      runId: Option[String] = None
    ): Run =
      Run
        .builder
        .ifSome(runId)(_.runId(_))
        .build

    def scheduleActivityTaskDecisionAttributes(
      activityType: Option[ActivityType] = None,
      activityId: Option[String] = None,
      control: Option[String] = None,
      input: Option[String] = None,
      scheduleToCloseTimeout: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      scheduleToStartTimeout: Option[String] = None,
      startToCloseTimeout: Option[String] = None,
      heartbeatTimeout: Option[String] = None
    ): ScheduleActivityTaskDecisionAttributes =
      ScheduleActivityTaskDecisionAttributes
        .builder
        .ifSome(activityType)(_.activityType(_))
        .ifSome(activityId)(_.activityId(_))
        .ifSome(control)(_.control(_))
        .ifSome(input)(_.input(_))
        .ifSome(scheduleToCloseTimeout)(_.scheduleToCloseTimeout(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(scheduleToStartTimeout)(_.scheduleToStartTimeout(_))
        .ifSome(startToCloseTimeout)(_.startToCloseTimeout(_))
        .ifSome(heartbeatTimeout)(_.heartbeatTimeout(_))
        .build

    def scheduleActivityTaskFailedEventAttributes(
      activityType: Option[ActivityType] = None,
      activityId: Option[String] = None,
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): ScheduleActivityTaskFailedEventAttributes =
      ScheduleActivityTaskFailedEventAttributes
        .builder
        .ifSome(activityType)(_.activityType(_))
        .ifSome(activityId)(_.activityId(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def scheduleLambdaFunctionDecisionAttributes(
      id: Option[String] = None,
      name: Option[String] = None,
      control: Option[String] = None,
      input: Option[String] = None,
      startToCloseTimeout: Option[String] = None
    ): ScheduleLambdaFunctionDecisionAttributes =
      ScheduleLambdaFunctionDecisionAttributes
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(control)(_.control(_))
        .ifSome(input)(_.input(_))
        .ifSome(startToCloseTimeout)(_.startToCloseTimeout(_))
        .build

    def scheduleLambdaFunctionFailedEventAttributes(
      id: Option[String] = None,
      name: Option[String] = None,
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): ScheduleLambdaFunctionFailedEventAttributes =
      ScheduleLambdaFunctionFailedEventAttributes
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def signalExternalWorkflowExecutionDecisionAttributes(
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      signalName: Option[String] = None,
      input: Option[String] = None,
      control: Option[String] = None
    ): SignalExternalWorkflowExecutionDecisionAttributes =
      SignalExternalWorkflowExecutionDecisionAttributes
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(signalName)(_.signalName(_))
        .ifSome(input)(_.input(_))
        .ifSome(control)(_.control(_))
        .build

    def signalExternalWorkflowExecutionFailedEventAttributes(
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      cause: Option[String] = None,
      initiatedEventId: Option[EventId] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      control: Option[String] = None
    ): SignalExternalWorkflowExecutionFailedEventAttributes =
      SignalExternalWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(control)(_.control(_))
        .build

    def signalExternalWorkflowExecutionInitiatedEventAttributes(
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      signalName: Option[String] = None,
      input: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      control: Option[String] = None
    ): SignalExternalWorkflowExecutionInitiatedEventAttributes =
      SignalExternalWorkflowExecutionInitiatedEventAttributes
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(signalName)(_.signalName(_))
        .ifSome(input)(_.input(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(control)(_.control(_))
        .build

    def signalWorkflowExecutionInput(
      domain: Option[String] = None,
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      signalName: Option[String] = None,
      input: Option[String] = None
    ): SignalWorkflowExecutionInput =
      SignalWorkflowExecutionInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(signalName)(_.signalName(_))
        .ifSome(input)(_.input(_))
        .build

    def startChildWorkflowExecutionDecisionAttributes(
      workflowType: Option[WorkflowType] = None,
      workflowId: Option[String] = None,
      control: Option[String] = None,
      input: Option[String] = None,
      executionStartToCloseTimeout: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      taskStartToCloseTimeout: Option[String] = None,
      childPolicy: Option[String] = None,
      tagList: Option[List[Tag]] = None,
      lambdaRole: Option[String] = None
    ): StartChildWorkflowExecutionDecisionAttributes =
      StartChildWorkflowExecutionDecisionAttributes
        .builder
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(control)(_.control(_))
        .ifSome(input)(_.input(_))
        .ifSome(executionStartToCloseTimeout)(_.executionStartToCloseTimeout(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(taskStartToCloseTimeout)(_.taskStartToCloseTimeout(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(lambdaRole)(_.lambdaRole(_))
        .build

    def startChildWorkflowExecutionFailedEventAttributes(
      workflowType: Option[WorkflowType] = None,
      cause: Option[String] = None,
      workflowId: Option[String] = None,
      initiatedEventId: Option[EventId] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      control: Option[String] = None
    ): StartChildWorkflowExecutionFailedEventAttributes =
      StartChildWorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(initiatedEventId)(_.initiatedEventId(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(control)(_.control(_))
        .build

    def startChildWorkflowExecutionInitiatedEventAttributes(
      workflowId: Option[String] = None,
      workflowType: Option[WorkflowType] = None,
      control: Option[String] = None,
      input: Option[String] = None,
      executionStartToCloseTimeout: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      childPolicy: Option[String] = None,
      taskStartToCloseTimeout: Option[String] = None,
      tagList: Option[List[Tag]] = None,
      lambdaRole: Option[String] = None
    ): StartChildWorkflowExecutionInitiatedEventAttributes =
      StartChildWorkflowExecutionInitiatedEventAttributes
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(control)(_.control(_))
        .ifSome(input)(_.input(_))
        .ifSome(executionStartToCloseTimeout)(_.executionStartToCloseTimeout(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(taskStartToCloseTimeout)(_.taskStartToCloseTimeout(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(lambdaRole)(_.lambdaRole(_))
        .build

    def startLambdaFunctionFailedEventAttributes(
      scheduledEventId: Option[EventId] = None,
      cause: Option[String] = None,
      message: Option[String] = None
    ): StartLambdaFunctionFailedEventAttributes =
      StartLambdaFunctionFailedEventAttributes
        .builder
        .ifSome(scheduledEventId)(_.scheduledEventId(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(message)(_.message(_))
        .build

    def startTimerDecisionAttributes(
      timerId: Option[String] = None,
      control: Option[String] = None,
      startToFireTimeout: Option[String] = None
    ): StartTimerDecisionAttributes =
      StartTimerDecisionAttributes
        .builder
        .ifSome(timerId)(_.timerId(_))
        .ifSome(control)(_.control(_))
        .ifSome(startToFireTimeout)(_.startToFireTimeout(_))
        .build

    def startTimerFailedEventAttributes(
      timerId: Option[String] = None,
      cause: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): StartTimerFailedEventAttributes =
      StartTimerFailedEventAttributes
        .builder
        .ifSome(timerId)(_.timerId(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def startWorkflowExecutionInput(
      domain: Option[String] = None,
      workflowId: Option[String] = None,
      workflowType: Option[WorkflowType] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      input: Option[String] = None,
      executionStartToCloseTimeout: Option[String] = None,
      tagList: Option[List[Tag]] = None,
      taskStartToCloseTimeout: Option[String] = None,
      childPolicy: Option[String] = None,
      lambdaRole: Option[String] = None
    ): StartWorkflowExecutionInput =
      StartWorkflowExecutionInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(input)(_.input(_))
        .ifSome(executionStartToCloseTimeout)(_.executionStartToCloseTimeout(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(taskStartToCloseTimeout)(_.taskStartToCloseTimeout(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(lambdaRole)(_.lambdaRole(_))
        .build

    def tagFilter(
      tag: Option[String] = None
    ): TagFilter =
      TagFilter
        .builder
        .ifSome(tag)(_.tag(_))
        .build

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[List[ResourceTag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def taskList(
      name: Option[String] = None
    ): TaskList =
      TaskList
        .builder
        .ifSome(name)(_.name(_))
        .build

    def terminateWorkflowExecutionInput(
      domain: Option[String] = None,
      workflowId: Option[String] = None,
      runId: Option[String] = None,
      reason: Option[String] = None,
      details: Option[String] = None,
      childPolicy: Option[String] = None
    ): TerminateWorkflowExecutionInput =
      TerminateWorkflowExecutionInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .build

    def timerCanceledEventAttributes(
      timerId: Option[String] = None,
      startedEventId: Option[EventId] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): TimerCanceledEventAttributes =
      TimerCanceledEventAttributes
        .builder
        .ifSome(timerId)(_.timerId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def timerFiredEventAttributes(
      timerId: Option[String] = None,
      startedEventId: Option[EventId] = None
    ): TimerFiredEventAttributes =
      TimerFiredEventAttributes
        .builder
        .ifSome(timerId)(_.timerId(_))
        .ifSome(startedEventId)(_.startedEventId(_))
        .build

    def timerStartedEventAttributes(
      timerId: Option[String] = None,
      control: Option[String] = None,
      startToFireTimeout: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): TimerStartedEventAttributes =
      TimerStartedEventAttributes
        .builder
        .ifSome(timerId)(_.timerId(_))
        .ifSome(control)(_.control(_))
        .ifSome(startToFireTimeout)(_.startToFireTimeout(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def tooManyTagsFault(
      message: Option[String] = None
    ): TooManyTagsFault =
      TooManyTagsFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def typeAlreadyExistsFault(
      message: Option[String] = None
    ): TypeAlreadyExistsFault =
      TypeAlreadyExistsFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def typeDeprecatedFault(
      message: Option[String] = None
    ): TypeDeprecatedFault =
      TypeDeprecatedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def undeprecateActivityTypeInput(
      domain: Option[String] = None,
      activityType: Option[ActivityType] = None
    ): UndeprecateActivityTypeInput =
      UndeprecateActivityTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(activityType)(_.activityType(_))
        .build

    def undeprecateDomainInput(
      name: Option[String] = None
    ): UndeprecateDomainInput =
      UndeprecateDomainInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def undeprecateWorkflowTypeInput(
      domain: Option[String] = None,
      workflowType: Option[WorkflowType] = None
    ): UndeprecateWorkflowTypeInput =
      UndeprecateWorkflowTypeInput
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(workflowType)(_.workflowType(_))
        .build

    def unknownResourceFault(
      message: Option[String] = None
    ): UnknownResourceFault =
      UnknownResourceFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[ResourceTagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def workflowExecution(
      workflowId: Option[String] = None,
      runId: Option[String] = None
    ): WorkflowExecution =
      WorkflowExecution
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .ifSome(runId)(_.runId(_))
        .build

    def workflowExecutionAlreadyStartedFault(
      message: Option[String] = None
    ): WorkflowExecutionAlreadyStartedFault =
      WorkflowExecutionAlreadyStartedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def workflowExecutionCancelRequestedEventAttributes(
      externalWorkflowExecution: Option[WorkflowExecution] = None,
      externalInitiatedEventId: Option[EventId] = None,
      cause: Option[String] = None
    ): WorkflowExecutionCancelRequestedEventAttributes =
      WorkflowExecutionCancelRequestedEventAttributes
        .builder
        .ifSome(externalWorkflowExecution)(_.externalWorkflowExecution(_))
        .ifSome(externalInitiatedEventId)(_.externalInitiatedEventId(_))
        .ifSome(cause)(_.cause(_))
        .build

    def workflowExecutionCanceledEventAttributes(
      details: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): WorkflowExecutionCanceledEventAttributes =
      WorkflowExecutionCanceledEventAttributes
        .builder
        .ifSome(details)(_.details(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def workflowExecutionCompletedEventAttributes(
      result: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): WorkflowExecutionCompletedEventAttributes =
      WorkflowExecutionCompletedEventAttributes
        .builder
        .ifSome(result)(_.result(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def workflowExecutionConfiguration(
      taskStartToCloseTimeout: Option[String] = None,
      executionStartToCloseTimeout: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      childPolicy: Option[String] = None,
      lambdaRole: Option[String] = None
    ): WorkflowExecutionConfiguration =
      WorkflowExecutionConfiguration
        .builder
        .ifSome(taskStartToCloseTimeout)(_.taskStartToCloseTimeout(_))
        .ifSome(executionStartToCloseTimeout)(_.executionStartToCloseTimeout(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(lambdaRole)(_.lambdaRole(_))
        .build

    def workflowExecutionContinuedAsNewEventAttributes(
      input: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None,
      newExecutionRunId: Option[String] = None,
      executionStartToCloseTimeout: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      taskStartToCloseTimeout: Option[String] = None,
      childPolicy: Option[String] = None,
      tagList: Option[List[Tag]] = None,
      workflowType: Option[WorkflowType] = None,
      lambdaRole: Option[String] = None
    ): WorkflowExecutionContinuedAsNewEventAttributes =
      WorkflowExecutionContinuedAsNewEventAttributes
        .builder
        .ifSome(input)(_.input(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .ifSome(newExecutionRunId)(_.newExecutionRunId(_))
        .ifSome(executionStartToCloseTimeout)(_.executionStartToCloseTimeout(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(taskStartToCloseTimeout)(_.taskStartToCloseTimeout(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(lambdaRole)(_.lambdaRole(_))
        .build

    def workflowExecutionCount(
      count: Option[Int] = None,
      truncated: Option[Boolean] = None
    ): WorkflowExecutionCount =
      WorkflowExecutionCount
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def workflowExecutionDetail(
      executionInfo: Option[WorkflowExecutionInfo] = None,
      executionConfiguration: Option[WorkflowExecutionConfiguration] = None,
      openCounts: Option[WorkflowExecutionOpenCounts] = None,
      latestActivityTaskTimestamp: Option[Timestamp] = None,
      latestExecutionContext: Option[String] = None
    ): WorkflowExecutionDetail =
      WorkflowExecutionDetail
        .builder
        .ifSome(executionInfo)(_.executionInfo(_))
        .ifSome(executionConfiguration)(_.executionConfiguration(_))
        .ifSome(openCounts)(_.openCounts(_))
        .ifSome(latestActivityTaskTimestamp)(_.latestActivityTaskTimestamp(_))
        .ifSome(latestExecutionContext)(_.latestExecutionContext(_))
        .build

    def workflowExecutionFailedEventAttributes(
      reason: Option[String] = None,
      details: Option[String] = None,
      decisionTaskCompletedEventId: Option[EventId] = None
    ): WorkflowExecutionFailedEventAttributes =
      WorkflowExecutionFailedEventAttributes
        .builder
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .ifSome(decisionTaskCompletedEventId)(_.decisionTaskCompletedEventId(_))
        .build

    def workflowExecutionFilter(
      workflowId: Option[String] = None
    ): WorkflowExecutionFilter =
      WorkflowExecutionFilter
        .builder
        .ifSome(workflowId)(_.workflowId(_))
        .build

    def workflowExecutionInfo(
      execution: Option[WorkflowExecution] = None,
      workflowType: Option[WorkflowType] = None,
      startTimestamp: Option[Timestamp] = None,
      closeTimestamp: Option[Timestamp] = None,
      executionStatus: Option[String] = None,
      closeStatus: Option[String] = None,
      parent: Option[WorkflowExecution] = None,
      tagList: Option[List[Tag]] = None,
      cancelRequested: Option[Boolean] = None
    ): WorkflowExecutionInfo =
      WorkflowExecutionInfo
        .builder
        .ifSome(execution)(_.execution(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(closeTimestamp)(_.closeTimestamp(_))
        .ifSome(executionStatus)(_.executionStatus(_))
        .ifSome(closeStatus)(_.closeStatus(_))
        .ifSome(parent)(_.parent(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(cancelRequested)(_.cancelRequested(_))
        .build

    def workflowExecutionInfos(
      executionInfos: Option[List[WorkflowExecutionInfo]] = None,
      nextPageToken: Option[String] = None
    ): WorkflowExecutionInfos =
      WorkflowExecutionInfos
        .builder
        .ifSome(executionInfos)(_.executionInfos(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def workflowExecutionOpenCounts(
      openActivityTasks: Option[Int] = None,
      openDecisionTasks: Option[Int] = None,
      openTimers: Option[Int] = None,
      openChildWorkflowExecutions: Option[Int] = None,
      openLambdaFunctions: Option[Int] = None
    ): WorkflowExecutionOpenCounts =
      WorkflowExecutionOpenCounts
        .builder
        .ifSome(openActivityTasks)(_.openActivityTasks(_))
        .ifSome(openDecisionTasks)(_.openDecisionTasks(_))
        .ifSome(openTimers)(_.openTimers(_))
        .ifSome(openChildWorkflowExecutions)(_.openChildWorkflowExecutions(_))
        .ifSome(openLambdaFunctions)(_.openLambdaFunctions(_))
        .build

    def workflowExecutionSignaledEventAttributes(
      signalName: Option[String] = None,
      input: Option[String] = None,
      externalWorkflowExecution: Option[WorkflowExecution] = None,
      externalInitiatedEventId: Option[EventId] = None
    ): WorkflowExecutionSignaledEventAttributes =
      WorkflowExecutionSignaledEventAttributes
        .builder
        .ifSome(signalName)(_.signalName(_))
        .ifSome(input)(_.input(_))
        .ifSome(externalWorkflowExecution)(_.externalWorkflowExecution(_))
        .ifSome(externalInitiatedEventId)(_.externalInitiatedEventId(_))
        .build

    def workflowExecutionStartedEventAttributes(
      input: Option[String] = None,
      executionStartToCloseTimeout: Option[String] = None,
      taskStartToCloseTimeout: Option[String] = None,
      childPolicy: Option[String] = None,
      taskList: Option[TaskList] = None,
      taskPriority: Option[String] = None,
      workflowType: Option[WorkflowType] = None,
      tagList: Option[List[Tag]] = None,
      continuedExecutionRunId: Option[String] = None,
      parentWorkflowExecution: Option[WorkflowExecution] = None,
      parentInitiatedEventId: Option[EventId] = None,
      lambdaRole: Option[String] = None
    ): WorkflowExecutionStartedEventAttributes =
      WorkflowExecutionStartedEventAttributes
        .builder
        .ifSome(input)(_.input(_))
        .ifSome(executionStartToCloseTimeout)(_.executionStartToCloseTimeout(_))
        .ifSome(taskStartToCloseTimeout)(_.taskStartToCloseTimeout(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(taskList)(_.taskList(_))
        .ifSome(taskPriority)(_.taskPriority(_))
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(continuedExecutionRunId)(_.continuedExecutionRunId(_))
        .ifSome(parentWorkflowExecution)(_.parentWorkflowExecution(_))
        .ifSome(parentInitiatedEventId)(_.parentInitiatedEventId(_))
        .ifSome(lambdaRole)(_.lambdaRole(_))
        .build

    def workflowExecutionTerminatedEventAttributes(
      reason: Option[String] = None,
      details: Option[String] = None,
      childPolicy: Option[String] = None,
      cause: Option[String] = None
    ): WorkflowExecutionTerminatedEventAttributes =
      WorkflowExecutionTerminatedEventAttributes
        .builder
        .ifSome(reason)(_.reason(_))
        .ifSome(details)(_.details(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .ifSome(cause)(_.cause(_))
        .build

    def workflowExecutionTimedOutEventAttributes(
      timeoutType: Option[String] = None,
      childPolicy: Option[String] = None
    ): WorkflowExecutionTimedOutEventAttributes =
      WorkflowExecutionTimedOutEventAttributes
        .builder
        .ifSome(timeoutType)(_.timeoutType(_))
        .ifSome(childPolicy)(_.childPolicy(_))
        .build

    def workflowType(
      name: Option[String] = None,
      version: Option[String] = None
    ): WorkflowType =
      WorkflowType
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def workflowTypeConfiguration(
      defaultTaskStartToCloseTimeout: Option[String] = None,
      defaultExecutionStartToCloseTimeout: Option[String] = None,
      defaultTaskList: Option[TaskList] = None,
      defaultTaskPriority: Option[String] = None,
      defaultChildPolicy: Option[String] = None,
      defaultLambdaRole: Option[String] = None
    ): WorkflowTypeConfiguration =
      WorkflowTypeConfiguration
        .builder
        .ifSome(defaultTaskStartToCloseTimeout)(_.defaultTaskStartToCloseTimeout(_))
        .ifSome(defaultExecutionStartToCloseTimeout)(_.defaultExecutionStartToCloseTimeout(_))
        .ifSome(defaultTaskList)(_.defaultTaskList(_))
        .ifSome(defaultTaskPriority)(_.defaultTaskPriority(_))
        .ifSome(defaultChildPolicy)(_.defaultChildPolicy(_))
        .ifSome(defaultLambdaRole)(_.defaultLambdaRole(_))
        .build

    def workflowTypeDetail(
      typeInfo: Option[WorkflowTypeInfo] = None,
      configuration: Option[WorkflowTypeConfiguration] = None
    ): WorkflowTypeDetail =
      WorkflowTypeDetail
        .builder
        .ifSome(typeInfo)(_.typeInfo(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def workflowTypeFilter(
      name: Option[String] = None,
      version: Option[String] = None
    ): WorkflowTypeFilter =
      WorkflowTypeFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def workflowTypeInfo(
      workflowType: Option[WorkflowType] = None,
      status: Option[String] = None,
      description: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      deprecationDate: Option[Timestamp] = None
    ): WorkflowTypeInfo =
      WorkflowTypeInfo
        .builder
        .ifSome(workflowType)(_.workflowType(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(deprecationDate)(_.deprecationDate(_))
        .build

    def workflowTypeInfos(
      typeInfos: Option[List[WorkflowTypeInfo]] = None,
      nextPageToken: Option[String] = None
    ): WorkflowTypeInfos =
      WorkflowTypeInfos
        .builder
        .ifSome(typeInfos)(_.typeInfos(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
