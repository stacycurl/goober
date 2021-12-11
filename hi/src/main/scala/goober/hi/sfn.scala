package goober.hi

import goober.free.sfn.SfnIO
import software.amazon.awssdk.services.sfn.model._


object sfn {
  import goober.free.{sfn ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activityDoesNotExist(
      message: Option[String] = None
    ): ActivityDoesNotExist =
      ActivityDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def activityFailedEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): ActivityFailedEventDetails =
      ActivityFailedEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def activityLimitExceeded(
      message: Option[String] = None
    ): ActivityLimitExceeded =
      ActivityLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def activityListItem(
      activityArn: Option[String] = None,
      name: Option[String] = None,
      creationDate: Option[Timestamp] = None
    ): ActivityListItem =
      ActivityListItem
        .builder
        .ifSome(activityArn)(_.activityArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def activityScheduleFailedEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): ActivityScheduleFailedEventDetails =
      ActivityScheduleFailedEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def activityScheduledEventDetails(
      resource: Option[String] = None,
      input: Option[String] = None,
      inputDetails: Option[HistoryEventExecutionDataDetails] = None,
      timeoutInSeconds: Option[TimeoutInSeconds] = None,
      heartbeatInSeconds: Option[TimeoutInSeconds] = None
    ): ActivityScheduledEventDetails =
      ActivityScheduledEventDetails
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputDetails)(_.inputDetails(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(heartbeatInSeconds)(_.heartbeatInSeconds(_))
        .build

    def activityStartedEventDetails(
      workerName: Option[String] = None
    ): ActivityStartedEventDetails =
      ActivityStartedEventDetails
        .builder
        .ifSome(workerName)(_.workerName(_))
        .build

    def activitySucceededEventDetails(
      output: Option[String] = None,
      outputDetails: Option[HistoryEventExecutionDataDetails] = None
    ): ActivitySucceededEventDetails =
      ActivitySucceededEventDetails
        .builder
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .build

    def activityTimedOutEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): ActivityTimedOutEventDetails =
      ActivityTimedOutEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def activityWorkerLimitExceeded(
      message: Option[String] = None
    ): ActivityWorkerLimitExceeded =
      ActivityWorkerLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def billingDetails(
      billedMemoryUsedInMB: Option[BilledMemoryUsed] = None,
      billedDurationInMilliseconds: Option[BilledDuration] = None
    ): BillingDetails =
      BillingDetails
        .builder
        .ifSome(billedMemoryUsedInMB)(_.billedMemoryUsedInMB(_))
        .ifSome(billedDurationInMilliseconds)(_.billedDurationInMilliseconds(_))
        .build

    def cloudWatchEventsExecutionDataDetails(
      included: Option[Boolean] = None
    ): CloudWatchEventsExecutionDataDetails =
      CloudWatchEventsExecutionDataDetails
        .builder
        .ifSome(included)(_.included(_))
        .build

    def cloudWatchLogsLogGroup(
      logGroupArn: Option[String] = None
    ): CloudWatchLogsLogGroup =
      CloudWatchLogsLogGroup
        .builder
        .ifSome(logGroupArn)(_.logGroupArn(_))
        .build

    def createActivityInput(
      name: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateActivityInput =
      CreateActivityInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createActivityOutput(
      activityArn: Option[String] = None,
      creationDate: Option[Timestamp] = None
    ): CreateActivityOutput =
      CreateActivityOutput
        .builder
        .ifSome(activityArn)(_.activityArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def createStateMachineInput(
      name: Option[String] = None,
      definition: Option[String] = None,
      roleArn: Option[String] = None,
      `type`: Option[String] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None,
      tags: Option[List[Tag]] = None,
      tracingConfiguration: Option[TracingConfiguration] = None
    ): CreateStateMachineInput =
      CreateStateMachineInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(tracingConfiguration)(_.tracingConfiguration(_))
        .build

    def createStateMachineOutput(
      stateMachineArn: Option[String] = None,
      creationDate: Option[Timestamp] = None
    ): CreateStateMachineOutput =
      CreateStateMachineOutput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def deleteActivityInput(
      activityArn: Option[String] = None
    ): DeleteActivityInput =
      DeleteActivityInput
        .builder
        .ifSome(activityArn)(_.activityArn(_))
        .build

    def deleteActivityOutput(

    ): DeleteActivityOutput =
      DeleteActivityOutput
        .builder

        .build

    def deleteStateMachineInput(
      stateMachineArn: Option[String] = None
    ): DeleteStateMachineInput =
      DeleteStateMachineInput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .build

    def deleteStateMachineOutput(

    ): DeleteStateMachineOutput =
      DeleteStateMachineOutput
        .builder

        .build

    def describeActivityInput(
      activityArn: Option[String] = None
    ): DescribeActivityInput =
      DescribeActivityInput
        .builder
        .ifSome(activityArn)(_.activityArn(_))
        .build

    def describeActivityOutput(
      activityArn: Option[String] = None,
      name: Option[String] = None,
      creationDate: Option[Timestamp] = None
    ): DescribeActivityOutput =
      DescribeActivityOutput
        .builder
        .ifSome(activityArn)(_.activityArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def describeExecutionInput(
      executionArn: Option[String] = None
    ): DescribeExecutionInput =
      DescribeExecutionInput
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .build

    def describeExecutionOutput(
      executionArn: Option[String] = None,
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      startDate: Option[Timestamp] = None,
      stopDate: Option[Timestamp] = None,
      input: Option[String] = None,
      inputDetails: Option[CloudWatchEventsExecutionDataDetails] = None,
      output: Option[String] = None,
      outputDetails: Option[CloudWatchEventsExecutionDataDetails] = None,
      traceHeader: Option[String] = None
    ): DescribeExecutionOutput =
      DescribeExecutionOutput
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(stopDate)(_.stopDate(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputDetails)(_.inputDetails(_))
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .ifSome(traceHeader)(_.traceHeader(_))
        .build

    def describeStateMachineForExecutionInput(
      executionArn: Option[String] = None
    ): DescribeStateMachineForExecutionInput =
      DescribeStateMachineForExecutionInput
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .build

    def describeStateMachineForExecutionOutput(
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      definition: Option[String] = None,
      roleArn: Option[String] = None,
      updateDate: Option[Timestamp] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None,
      tracingConfiguration: Option[TracingConfiguration] = None
    ): DescribeStateMachineForExecutionOutput =
      DescribeStateMachineForExecutionOutput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(updateDate)(_.updateDate(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .ifSome(tracingConfiguration)(_.tracingConfiguration(_))
        .build

    def describeStateMachineInput(
      stateMachineArn: Option[String] = None
    ): DescribeStateMachineInput =
      DescribeStateMachineInput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .build

    def describeStateMachineOutput(
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      definition: Option[String] = None,
      roleArn: Option[String] = None,
      `type`: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None,
      tracingConfiguration: Option[TracingConfiguration] = None
    ): DescribeStateMachineOutput =
      DescribeStateMachineOutput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .ifSome(tracingConfiguration)(_.tracingConfiguration(_))
        .build

    def executionAbortedEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): ExecutionAbortedEventDetails =
      ExecutionAbortedEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def executionAlreadyExists(
      message: Option[String] = None
    ): ExecutionAlreadyExists =
      ExecutionAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def executionDoesNotExist(
      message: Option[String] = None
    ): ExecutionDoesNotExist =
      ExecutionDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def executionFailedEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): ExecutionFailedEventDetails =
      ExecutionFailedEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def executionLimitExceeded(
      message: Option[String] = None
    ): ExecutionLimitExceeded =
      ExecutionLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def executionListItem(
      executionArn: Option[String] = None,
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      startDate: Option[Timestamp] = None,
      stopDate: Option[Timestamp] = None
    ): ExecutionListItem =
      ExecutionListItem
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(stopDate)(_.stopDate(_))
        .build

    def executionStartedEventDetails(
      input: Option[String] = None,
      inputDetails: Option[HistoryEventExecutionDataDetails] = None,
      roleArn: Option[String] = None
    ): ExecutionStartedEventDetails =
      ExecutionStartedEventDetails
        .builder
        .ifSome(input)(_.input(_))
        .ifSome(inputDetails)(_.inputDetails(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def executionSucceededEventDetails(
      output: Option[String] = None,
      outputDetails: Option[HistoryEventExecutionDataDetails] = None
    ): ExecutionSucceededEventDetails =
      ExecutionSucceededEventDetails
        .builder
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .build

    def executionTimedOutEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): ExecutionTimedOutEventDetails =
      ExecutionTimedOutEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def getActivityTaskInput(
      activityArn: Option[String] = None,
      workerName: Option[String] = None
    ): GetActivityTaskInput =
      GetActivityTaskInput
        .builder
        .ifSome(activityArn)(_.activityArn(_))
        .ifSome(workerName)(_.workerName(_))
        .build

    def getActivityTaskOutput(
      taskToken: Option[String] = None,
      input: Option[String] = None
    ): GetActivityTaskOutput =
      GetActivityTaskOutput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(input)(_.input(_))
        .build

    def getExecutionHistoryInput(
      executionArn: Option[String] = None,
      maxResults: Option[Int] = None,
      reverseOrder: Option[Boolean] = None,
      nextToken: Option[String] = None,
      includeExecutionData: Option[Boolean] = None
    ): GetExecutionHistoryInput =
      GetExecutionHistoryInput
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(includeExecutionData)(_.includeExecutionData(_))
        .build

    def getExecutionHistoryOutput(
      events: Option[List[HistoryEvent]] = None,
      nextToken: Option[String] = None
    ): GetExecutionHistoryOutput =
      GetExecutionHistoryOutput
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def historyEvent(
      timestamp: Option[Timestamp] = None,
      `type`: Option[String] = None,
      id: Option[EventId] = None,
      previousEventId: Option[EventId] = None,
      activityFailedEventDetails: Option[ActivityFailedEventDetails] = None,
      activityScheduleFailedEventDetails: Option[ActivityScheduleFailedEventDetails] = None,
      activityScheduledEventDetails: Option[ActivityScheduledEventDetails] = None,
      activityStartedEventDetails: Option[ActivityStartedEventDetails] = None,
      activitySucceededEventDetails: Option[ActivitySucceededEventDetails] = None,
      activityTimedOutEventDetails: Option[ActivityTimedOutEventDetails] = None,
      taskFailedEventDetails: Option[TaskFailedEventDetails] = None,
      taskScheduledEventDetails: Option[TaskScheduledEventDetails] = None,
      taskStartFailedEventDetails: Option[TaskStartFailedEventDetails] = None,
      taskStartedEventDetails: Option[TaskStartedEventDetails] = None,
      taskSubmitFailedEventDetails: Option[TaskSubmitFailedEventDetails] = None,
      taskSubmittedEventDetails: Option[TaskSubmittedEventDetails] = None,
      taskSucceededEventDetails: Option[TaskSucceededEventDetails] = None,
      taskTimedOutEventDetails: Option[TaskTimedOutEventDetails] = None,
      executionFailedEventDetails: Option[ExecutionFailedEventDetails] = None,
      executionStartedEventDetails: Option[ExecutionStartedEventDetails] = None,
      executionSucceededEventDetails: Option[ExecutionSucceededEventDetails] = None,
      executionAbortedEventDetails: Option[ExecutionAbortedEventDetails] = None,
      executionTimedOutEventDetails: Option[ExecutionTimedOutEventDetails] = None,
      mapStateStartedEventDetails: Option[MapStateStartedEventDetails] = None,
      mapIterationStartedEventDetails: Option[MapIterationEventDetails] = None,
      mapIterationSucceededEventDetails: Option[MapIterationEventDetails] = None,
      mapIterationFailedEventDetails: Option[MapIterationEventDetails] = None,
      mapIterationAbortedEventDetails: Option[MapIterationEventDetails] = None,
      lambdaFunctionFailedEventDetails: Option[LambdaFunctionFailedEventDetails] = None,
      lambdaFunctionScheduleFailedEventDetails: Option[LambdaFunctionScheduleFailedEventDetails] = None,
      lambdaFunctionScheduledEventDetails: Option[LambdaFunctionScheduledEventDetails] = None,
      lambdaFunctionStartFailedEventDetails: Option[LambdaFunctionStartFailedEventDetails] = None,
      lambdaFunctionSucceededEventDetails: Option[LambdaFunctionSucceededEventDetails] = None,
      lambdaFunctionTimedOutEventDetails: Option[LambdaFunctionTimedOutEventDetails] = None,
      stateEnteredEventDetails: Option[StateEnteredEventDetails] = None,
      stateExitedEventDetails: Option[StateExitedEventDetails] = None
    ): HistoryEvent =
      HistoryEvent
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(previousEventId)(_.previousEventId(_))
        .ifSome(activityFailedEventDetails)(_.activityFailedEventDetails(_))
        .ifSome(activityScheduleFailedEventDetails)(_.activityScheduleFailedEventDetails(_))
        .ifSome(activityScheduledEventDetails)(_.activityScheduledEventDetails(_))
        .ifSome(activityStartedEventDetails)(_.activityStartedEventDetails(_))
        .ifSome(activitySucceededEventDetails)(_.activitySucceededEventDetails(_))
        .ifSome(activityTimedOutEventDetails)(_.activityTimedOutEventDetails(_))
        .ifSome(taskFailedEventDetails)(_.taskFailedEventDetails(_))
        .ifSome(taskScheduledEventDetails)(_.taskScheduledEventDetails(_))
        .ifSome(taskStartFailedEventDetails)(_.taskStartFailedEventDetails(_))
        .ifSome(taskStartedEventDetails)(_.taskStartedEventDetails(_))
        .ifSome(taskSubmitFailedEventDetails)(_.taskSubmitFailedEventDetails(_))
        .ifSome(taskSubmittedEventDetails)(_.taskSubmittedEventDetails(_))
        .ifSome(taskSucceededEventDetails)(_.taskSucceededEventDetails(_))
        .ifSome(taskTimedOutEventDetails)(_.taskTimedOutEventDetails(_))
        .ifSome(executionFailedEventDetails)(_.executionFailedEventDetails(_))
        .ifSome(executionStartedEventDetails)(_.executionStartedEventDetails(_))
        .ifSome(executionSucceededEventDetails)(_.executionSucceededEventDetails(_))
        .ifSome(executionAbortedEventDetails)(_.executionAbortedEventDetails(_))
        .ifSome(executionTimedOutEventDetails)(_.executionTimedOutEventDetails(_))
        .ifSome(mapStateStartedEventDetails)(_.mapStateStartedEventDetails(_))
        .ifSome(mapIterationStartedEventDetails)(_.mapIterationStartedEventDetails(_))
        .ifSome(mapIterationSucceededEventDetails)(_.mapIterationSucceededEventDetails(_))
        .ifSome(mapIterationFailedEventDetails)(_.mapIterationFailedEventDetails(_))
        .ifSome(mapIterationAbortedEventDetails)(_.mapIterationAbortedEventDetails(_))
        .ifSome(lambdaFunctionFailedEventDetails)(_.lambdaFunctionFailedEventDetails(_))
        .ifSome(lambdaFunctionScheduleFailedEventDetails)(_.lambdaFunctionScheduleFailedEventDetails(_))
        .ifSome(lambdaFunctionScheduledEventDetails)(_.lambdaFunctionScheduledEventDetails(_))
        .ifSome(lambdaFunctionStartFailedEventDetails)(_.lambdaFunctionStartFailedEventDetails(_))
        .ifSome(lambdaFunctionSucceededEventDetails)(_.lambdaFunctionSucceededEventDetails(_))
        .ifSome(lambdaFunctionTimedOutEventDetails)(_.lambdaFunctionTimedOutEventDetails(_))
        .ifSome(stateEnteredEventDetails)(_.stateEnteredEventDetails(_))
        .ifSome(stateExitedEventDetails)(_.stateExitedEventDetails(_))
        .build

    def historyEventExecutionDataDetails(
      truncated: Option[Boolean] = None
    ): HistoryEventExecutionDataDetails =
      HistoryEventExecutionDataDetails
        .builder
        .ifSome(truncated)(_.truncated(_))
        .build

    def invalidArn(
      message: Option[String] = None
    ): InvalidArn =
      InvalidArn
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDefinition(
      message: Option[String] = None
    ): InvalidDefinition =
      InvalidDefinition
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidExecutionInput(
      message: Option[String] = None
    ): InvalidExecutionInput =
      InvalidExecutionInput
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidLoggingConfiguration(
      message: Option[String] = None
    ): InvalidLoggingConfiguration =
      InvalidLoggingConfiguration
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidName(
      message: Option[String] = None
    ): InvalidName =
      InvalidName
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOutput(
      message: Option[String] = None
    ): InvalidOutput =
      InvalidOutput
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidToken(
      message: Option[String] = None
    ): InvalidToken =
      InvalidToken
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTracingConfiguration(
      message: Option[String] = None
    ): InvalidTracingConfiguration =
      InvalidTracingConfiguration
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lambdaFunctionFailedEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): LambdaFunctionFailedEventDetails =
      LambdaFunctionFailedEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def lambdaFunctionScheduleFailedEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): LambdaFunctionScheduleFailedEventDetails =
      LambdaFunctionScheduleFailedEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def lambdaFunctionScheduledEventDetails(
      resource: Option[String] = None,
      input: Option[String] = None,
      inputDetails: Option[HistoryEventExecutionDataDetails] = None,
      timeoutInSeconds: Option[TimeoutInSeconds] = None
    ): LambdaFunctionScheduledEventDetails =
      LambdaFunctionScheduledEventDetails
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputDetails)(_.inputDetails(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .build

    def lambdaFunctionStartFailedEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): LambdaFunctionStartFailedEventDetails =
      LambdaFunctionStartFailedEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def lambdaFunctionSucceededEventDetails(
      output: Option[String] = None,
      outputDetails: Option[HistoryEventExecutionDataDetails] = None
    ): LambdaFunctionSucceededEventDetails =
      LambdaFunctionSucceededEventDetails
        .builder
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .build

    def lambdaFunctionTimedOutEventDetails(
      error: Option[String] = None,
      cause: Option[String] = None
    ): LambdaFunctionTimedOutEventDetails =
      LambdaFunctionTimedOutEventDetails
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def listActivitiesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListActivitiesInput =
      ListActivitiesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listActivitiesOutput(
      activities: Option[List[ActivityListItem]] = None,
      nextToken: Option[String] = None
    ): ListActivitiesOutput =
      ListActivitiesOutput
        .builder
        .ifSome(activities)(_.activities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExecutionsInput(
      stateMachineArn: Option[String] = None,
      statusFilter: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListExecutionsInput =
      ListExecutionsInput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(statusFilter)(_.statusFilter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExecutionsOutput(
      executions: Option[List[ExecutionListItem]] = None,
      nextToken: Option[String] = None
    ): ListExecutionsOutput =
      ListExecutionsOutput
        .builder
        .ifSome(executions)(_.executions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStateMachinesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListStateMachinesInput =
      ListStateMachinesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStateMachinesOutput(
      stateMachines: Option[List[StateMachineListItem]] = None,
      nextToken: Option[String] = None
    ): ListStateMachinesOutput =
      ListStateMachinesOutput
        .builder
        .ifSome(stateMachines)(_.stateMachines(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def logDestination(
      cloudWatchLogsLogGroup: Option[CloudWatchLogsLogGroup] = None
    ): LogDestination =
      LogDestination
        .builder
        .ifSome(cloudWatchLogsLogGroup)(_.cloudWatchLogsLogGroup(_))
        .build

    def loggingConfiguration(
      level: Option[String] = None,
      includeExecutionData: Option[Boolean] = None,
      destinations: Option[List[LogDestination]] = None
    ): LoggingConfiguration =
      LoggingConfiguration
        .builder
        .ifSome(level)(_.level(_))
        .ifSome(includeExecutionData)(_.includeExecutionData(_))
        .ifSome(destinations)(_.destinations(_))
        .build

    def mapIterationEventDetails(
      name: Option[String] = None,
      index: Option[Int] = None
    ): MapIterationEventDetails =
      MapIterationEventDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(index)(_.index(_))
        .build

    def mapStateStartedEventDetails(
      length: Option[Int] = None
    ): MapStateStartedEventDetails =
      MapStateStartedEventDetails
        .builder
        .ifSome(length)(_.length(_))
        .build

    def missingRequiredParameter(
      message: Option[String] = None
    ): MissingRequiredParameter =
      MissingRequiredParameter
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFound(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceNotFound =
      ResourceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def sendTaskFailureInput(
      taskToken: Option[String] = None,
      error: Option[String] = None,
      cause: Option[String] = None
    ): SendTaskFailureInput =
      SendTaskFailureInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def sendTaskFailureOutput(

    ): SendTaskFailureOutput =
      SendTaskFailureOutput
        .builder

        .build

    def sendTaskHeartbeatInput(
      taskToken: Option[String] = None
    ): SendTaskHeartbeatInput =
      SendTaskHeartbeatInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .build

    def sendTaskHeartbeatOutput(

    ): SendTaskHeartbeatOutput =
      SendTaskHeartbeatOutput
        .builder

        .build

    def sendTaskSuccessInput(
      taskToken: Option[String] = None,
      output: Option[String] = None
    ): SendTaskSuccessInput =
      SendTaskSuccessInput
        .builder
        .ifSome(taskToken)(_.taskToken(_))
        .ifSome(output)(_.output(_))
        .build

    def sendTaskSuccessOutput(

    ): SendTaskSuccessOutput =
      SendTaskSuccessOutput
        .builder

        .build

    def startExecutionInput(
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      input: Option[String] = None,
      traceHeader: Option[String] = None
    ): StartExecutionInput =
      StartExecutionInput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(input)(_.input(_))
        .ifSome(traceHeader)(_.traceHeader(_))
        .build

    def startExecutionOutput(
      executionArn: Option[String] = None,
      startDate: Option[Timestamp] = None
    ): StartExecutionOutput =
      StartExecutionOutput
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .ifSome(startDate)(_.startDate(_))
        .build

    def startSyncExecutionInput(
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      input: Option[String] = None,
      traceHeader: Option[String] = None
    ): StartSyncExecutionInput =
      StartSyncExecutionInput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(input)(_.input(_))
        .ifSome(traceHeader)(_.traceHeader(_))
        .build

    def startSyncExecutionOutput(
      executionArn: Option[String] = None,
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      startDate: Option[Timestamp] = None,
      stopDate: Option[Timestamp] = None,
      status: Option[String] = None,
      error: Option[String] = None,
      cause: Option[String] = None,
      input: Option[String] = None,
      inputDetails: Option[CloudWatchEventsExecutionDataDetails] = None,
      output: Option[String] = None,
      outputDetails: Option[CloudWatchEventsExecutionDataDetails] = None,
      traceHeader: Option[String] = None,
      billingDetails: Option[BillingDetails] = None
    ): StartSyncExecutionOutput =
      StartSyncExecutionOutput
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(stopDate)(_.stopDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputDetails)(_.inputDetails(_))
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .ifSome(traceHeader)(_.traceHeader(_))
        .ifSome(billingDetails)(_.billingDetails(_))
        .build

    def stateEnteredEventDetails(
      name: Option[String] = None,
      input: Option[String] = None,
      inputDetails: Option[HistoryEventExecutionDataDetails] = None
    ): StateEnteredEventDetails =
      StateEnteredEventDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputDetails)(_.inputDetails(_))
        .build

    def stateExitedEventDetails(
      name: Option[String] = None,
      output: Option[String] = None,
      outputDetails: Option[HistoryEventExecutionDataDetails] = None
    ): StateExitedEventDetails =
      StateExitedEventDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .build

    def stateMachineAlreadyExists(
      message: Option[String] = None
    ): StateMachineAlreadyExists =
      StateMachineAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def stateMachineDeleting(
      message: Option[String] = None
    ): StateMachineDeleting =
      StateMachineDeleting
        .builder
        .ifSome(message)(_.message(_))
        .build

    def stateMachineDoesNotExist(
      message: Option[String] = None
    ): StateMachineDoesNotExist =
      StateMachineDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def stateMachineLimitExceeded(
      message: Option[String] = None
    ): StateMachineLimitExceeded =
      StateMachineLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def stateMachineListItem(
      stateMachineArn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      creationDate: Option[Timestamp] = None
    ): StateMachineListItem =
      StateMachineListItem
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def stateMachineTypeNotSupported(
      message: Option[String] = None
    ): StateMachineTypeNotSupported =
      StateMachineTypeNotSupported
        .builder
        .ifSome(message)(_.message(_))
        .build

    def stopExecutionInput(
      executionArn: Option[String] = None,
      error: Option[String] = None,
      cause: Option[String] = None
    ): StopExecutionInput =
      StopExecutionInput
        .builder
        .ifSome(executionArn)(_.executionArn(_))
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def stopExecutionOutput(
      stopDate: Option[Timestamp] = None
    ): StopExecutionOutput =
      StopExecutionOutput
        .builder
        .ifSome(stopDate)(_.stopDate(_))
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

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def taskDoesNotExist(
      message: Option[String] = None
    ): TaskDoesNotExist =
      TaskDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def taskFailedEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None,
      error: Option[String] = None,
      cause: Option[String] = None
    ): TaskFailedEventDetails =
      TaskFailedEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def taskScheduledEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None,
      region: Option[String] = None,
      parameters: Option[String] = None,
      timeoutInSeconds: Option[TimeoutInSeconds] = None,
      heartbeatInSeconds: Option[TimeoutInSeconds] = None
    ): TaskScheduledEventDetails =
      TaskScheduledEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(region)(_.region(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(heartbeatInSeconds)(_.heartbeatInSeconds(_))
        .build

    def taskStartFailedEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None,
      error: Option[String] = None,
      cause: Option[String] = None
    ): TaskStartFailedEventDetails =
      TaskStartFailedEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def taskStartedEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None
    ): TaskStartedEventDetails =
      TaskStartedEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .build

    def taskSubmitFailedEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None,
      error: Option[String] = None,
      cause: Option[String] = None
    ): TaskSubmitFailedEventDetails =
      TaskSubmitFailedEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def taskSubmittedEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None,
      output: Option[String] = None,
      outputDetails: Option[HistoryEventExecutionDataDetails] = None
    ): TaskSubmittedEventDetails =
      TaskSubmittedEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .build

    def taskSucceededEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None,
      output: Option[String] = None,
      outputDetails: Option[HistoryEventExecutionDataDetails] = None
    ): TaskSucceededEventDetails =
      TaskSucceededEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(output)(_.output(_))
        .ifSome(outputDetails)(_.outputDetails(_))
        .build

    def taskTimedOut(
      message: Option[String] = None
    ): TaskTimedOut =
      TaskTimedOut
        .builder
        .ifSome(message)(_.message(_))
        .build

    def taskTimedOutEventDetails(
      resourceType: Option[String] = None,
      resource: Option[String] = None,
      error: Option[String] = None,
      cause: Option[String] = None
    ): TaskTimedOutEventDetails =
      TaskTimedOutEventDetails
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(error)(_.error(_))
        .ifSome(cause)(_.cause(_))
        .build

    def tooManyTags(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TooManyTags =
      TooManyTags
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def tracingConfiguration(
      enabled: Option[Boolean] = None
    ): TracingConfiguration =
      TracingConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateStateMachineInput(
      stateMachineArn: Option[String] = None,
      definition: Option[String] = None,
      roleArn: Option[String] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None,
      tracingConfiguration: Option[TracingConfiguration] = None
    ): UpdateStateMachineInput =
      UpdateStateMachineInput
        .builder
        .ifSome(stateMachineArn)(_.stateMachineArn(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .ifSome(tracingConfiguration)(_.tracingConfiguration(_))
        .build

    def updateStateMachineOutput(
      updateDate: Option[Timestamp] = None
    ): UpdateStateMachineOutput =
      UpdateStateMachineOutput
        .builder
        .ifSome(updateDate)(_.updateDate(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
