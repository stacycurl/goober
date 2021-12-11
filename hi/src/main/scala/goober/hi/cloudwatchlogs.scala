package goober.hi

import goober.free.cloudwatchlogs.CloudWatchLogsIO
import software.amazon.awssdk.services.cloudwatchlogs.model._


object cloudwatchlogs {
  import goober.free.{cloudwatchlogs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateKmsKeyRequest(
      logGroupName: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): AssociateKmsKeyRequest =
      AssociateKmsKeyRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def cancelExportTaskRequest(
      taskId: Option[String] = None
    ): CancelExportTaskRequest =
      CancelExportTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def createExportTaskRequest(
      taskName: Option[String] = None,
      logGroupName: Option[String] = None,
      logStreamNamePrefix: Option[String] = None,
      from: Option[Timestamp] = None,
      to: Option[Timestamp] = None,
      destination: Option[String] = None,
      destinationPrefix: Option[String] = None
    ): CreateExportTaskRequest =
      CreateExportTaskRequest
        .builder
        .ifSome(taskName)(_.taskName(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamNamePrefix)(_.logStreamNamePrefix(_))
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationPrefix)(_.destinationPrefix(_))
        .build

    def createExportTaskResponse(
      taskId: Option[String] = None
    ): CreateExportTaskResponse =
      CreateExportTaskResponse
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def createLogGroupRequest(
      logGroupName: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateLogGroupRequest =
      CreateLogGroupRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLogStreamRequest(
      logGroupName: Option[String] = None,
      logStreamName: Option[String] = None
    ): CreateLogStreamRequest =
      CreateLogStreamRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .build

    def dataAlreadyAcceptedException(
      expectedSequenceToken: Option[String] = None
    ): DataAlreadyAcceptedException =
      DataAlreadyAcceptedException
        .builder
        .ifSome(expectedSequenceToken)(_.expectedSequenceToken(_))
        .build

    def deleteDestinationRequest(
      destinationName: Option[String] = None
    ): DeleteDestinationRequest =
      DeleteDestinationRequest
        .builder
        .ifSome(destinationName)(_.destinationName(_))
        .build

    def deleteLogGroupRequest(
      logGroupName: Option[String] = None
    ): DeleteLogGroupRequest =
      DeleteLogGroupRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def deleteLogStreamRequest(
      logGroupName: Option[String] = None,
      logStreamName: Option[String] = None
    ): DeleteLogStreamRequest =
      DeleteLogStreamRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .build

    def deleteMetricFilterRequest(
      logGroupName: Option[String] = None,
      filterName: Option[String] = None
    ): DeleteMetricFilterRequest =
      DeleteMetricFilterRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(filterName)(_.filterName(_))
        .build

    def deleteQueryDefinitionRequest(
      queryDefinitionId: Option[String] = None
    ): DeleteQueryDefinitionRequest =
      DeleteQueryDefinitionRequest
        .builder
        .ifSome(queryDefinitionId)(_.queryDefinitionId(_))
        .build

    def deleteQueryDefinitionResponse(
      success: Option[Boolean] = None
    ): DeleteQueryDefinitionResponse =
      DeleteQueryDefinitionResponse
        .builder
        .ifSome(success)(_.success(_))
        .build

    def deleteResourcePolicyRequest(
      policyName: Option[String] = None
    ): DeleteResourcePolicyRequest =
      DeleteResourcePolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteRetentionPolicyRequest(
      logGroupName: Option[String] = None
    ): DeleteRetentionPolicyRequest =
      DeleteRetentionPolicyRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def deleteSubscriptionFilterRequest(
      logGroupName: Option[String] = None,
      filterName: Option[String] = None
    ): DeleteSubscriptionFilterRequest =
      DeleteSubscriptionFilterRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(filterName)(_.filterName(_))
        .build

    def describeDestinationsRequest(
      destinationNamePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeDestinationsRequest =
      DescribeDestinationsRequest
        .builder
        .ifSome(destinationNamePrefix)(_.destinationNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeDestinationsResponse(
      destinations: Option[List[Destination]] = None,
      nextToken: Option[String] = None
    ): DescribeDestinationsResponse =
      DescribeDestinationsResponse
        .builder
        .ifSome(destinations)(_.destinations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeExportTasksRequest(
      taskId: Option[String] = None,
      statusCode: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeExportTasksRequest =
      DescribeExportTasksRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeExportTasksResponse(
      exportTasks: Option[List[ExportTask]] = None,
      nextToken: Option[String] = None
    ): DescribeExportTasksResponse =
      DescribeExportTasksResponse
        .builder
        .ifSome(exportTasks)(_.exportTasks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLogGroupsRequest(
      logGroupNamePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeLogGroupsRequest =
      DescribeLogGroupsRequest
        .builder
        .ifSome(logGroupNamePrefix)(_.logGroupNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeLogGroupsResponse(
      logGroups: Option[List[LogGroup]] = None,
      nextToken: Option[String] = None
    ): DescribeLogGroupsResponse =
      DescribeLogGroupsResponse
        .builder
        .ifSome(logGroups)(_.logGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLogStreamsRequest(
      logGroupName: Option[String] = None,
      logStreamNamePrefix: Option[String] = None,
      orderBy: Option[String] = None,
      descending: Option[Boolean] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeLogStreamsRequest =
      DescribeLogStreamsRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamNamePrefix)(_.logStreamNamePrefix(_))
        .ifSome(orderBy)(_.orderBy(_))
        .ifSome(descending)(_.descending(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeLogStreamsResponse(
      logStreams: Option[List[LogStream]] = None,
      nextToken: Option[String] = None
    ): DescribeLogStreamsResponse =
      DescribeLogStreamsResponse
        .builder
        .ifSome(logStreams)(_.logStreams(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMetricFiltersRequest(
      logGroupName: Option[String] = None,
      filterNamePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None,
      metricName: Option[String] = None,
      metricNamespace: Option[String] = None
    ): DescribeMetricFiltersRequest =
      DescribeMetricFiltersRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(filterNamePrefix)(_.filterNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricNamespace)(_.metricNamespace(_))
        .build

    def describeMetricFiltersResponse(
      metricFilters: Option[List[MetricFilter]] = None,
      nextToken: Option[String] = None
    ): DescribeMetricFiltersResponse =
      DescribeMetricFiltersResponse
        .builder
        .ifSome(metricFilters)(_.metricFilters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeQueriesRequest(
      logGroupName: Option[String] = None,
      status: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeQueriesRequest =
      DescribeQueriesRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeQueriesResponse(
      queries: Option[List[QueryInfo]] = None,
      nextToken: Option[String] = None
    ): DescribeQueriesResponse =
      DescribeQueriesResponse
        .builder
        .ifSome(queries)(_.queries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeQueryDefinitionsRequest(
      queryDefinitionNamePrefix: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeQueryDefinitionsRequest =
      DescribeQueryDefinitionsRequest
        .builder
        .ifSome(queryDefinitionNamePrefix)(_.queryDefinitionNamePrefix(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeQueryDefinitionsResponse(
      queryDefinitions: Option[List[QueryDefinition]] = None,
      nextToken: Option[String] = None
    ): DescribeQueryDefinitionsResponse =
      DescribeQueryDefinitionsResponse
        .builder
        .ifSome(queryDefinitions)(_.queryDefinitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeResourcePoliciesRequest(
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeResourcePoliciesRequest =
      DescribeResourcePoliciesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeResourcePoliciesResponse(
      resourcePolicies: Option[List[ResourcePolicy]] = None,
      nextToken: Option[String] = None
    ): DescribeResourcePoliciesResponse =
      DescribeResourcePoliciesResponse
        .builder
        .ifSome(resourcePolicies)(_.resourcePolicies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSubscriptionFiltersRequest(
      logGroupName: Option[String] = None,
      filterNamePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeSubscriptionFiltersRequest =
      DescribeSubscriptionFiltersRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(filterNamePrefix)(_.filterNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeSubscriptionFiltersResponse(
      subscriptionFilters: Option[List[SubscriptionFilter]] = None,
      nextToken: Option[String] = None
    ): DescribeSubscriptionFiltersResponse =
      DescribeSubscriptionFiltersResponse
        .builder
        .ifSome(subscriptionFilters)(_.subscriptionFilters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def destination(
      destinationName: Option[String] = None,
      targetArn: Option[String] = None,
      roleArn: Option[String] = None,
      accessPolicy: Option[String] = None,
      arn: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): Destination =
      Destination
        .builder
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(accessPolicy)(_.accessPolicy(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def disassociateKmsKeyRequest(
      logGroupName: Option[String] = None
    ): DisassociateKmsKeyRequest =
      DisassociateKmsKeyRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def exportTask(
      taskId: Option[String] = None,
      taskName: Option[String] = None,
      logGroupName: Option[String] = None,
      from: Option[Timestamp] = None,
      to: Option[Timestamp] = None,
      destination: Option[String] = None,
      destinationPrefix: Option[String] = None,
      status: Option[ExportTaskStatus] = None,
      executionInfo: Option[ExportTaskExecutionInfo] = None
    ): ExportTask =
      ExportTask
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(taskName)(_.taskName(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationPrefix)(_.destinationPrefix(_))
        .ifSome(status)(_.status(_))
        .ifSome(executionInfo)(_.executionInfo(_))
        .build

    def exportTaskExecutionInfo(
      creationTime: Option[Timestamp] = None,
      completionTime: Option[Timestamp] = None
    ): ExportTaskExecutionInfo =
      ExportTaskExecutionInfo
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(completionTime)(_.completionTime(_))
        .build

    def exportTaskStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): ExportTaskStatus =
      ExportTaskStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def filterLogEventsRequest(
      logGroupName: Option[String] = None,
      logStreamNames: Option[List[LogStreamName]] = None,
      logStreamNamePrefix: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      filterPattern: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None,
      interleaved: Option[Boolean] = None
    ): FilterLogEventsRequest =
      FilterLogEventsRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamNames)(_.logStreamNames(_))
        .ifSome(logStreamNamePrefix)(_.logStreamNamePrefix(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(filterPattern)(_.filterPattern(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(interleaved)(_.interleaved(_))
        .build

    def filterLogEventsResponse(
      events: Option[List[FilteredLogEvent]] = None,
      searchedLogStreams: Option[List[SearchedLogStream]] = None,
      nextToken: Option[String] = None
    ): FilterLogEventsResponse =
      FilterLogEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(searchedLogStreams)(_.searchedLogStreams(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def filteredLogEvent(
      logStreamName: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      message: Option[String] = None,
      ingestionTime: Option[Timestamp] = None,
      eventId: Option[String] = None
    ): FilteredLogEvent =
      FilteredLogEvent
        .builder
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(message)(_.message(_))
        .ifSome(ingestionTime)(_.ingestionTime(_))
        .ifSome(eventId)(_.eventId(_))
        .build

    def getLogEventsRequest(
      logGroupName: Option[String] = None,
      logStreamName: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None,
      startFromHead: Option[Boolean] = None
    ): GetLogEventsRequest =
      GetLogEventsRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(startFromHead)(_.startFromHead(_))
        .build

    def getLogEventsResponse(
      events: Option[List[OutputLogEvent]] = None,
      nextForwardToken: Option[String] = None,
      nextBackwardToken: Option[String] = None
    ): GetLogEventsResponse =
      GetLogEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextForwardToken)(_.nextForwardToken(_))
        .ifSome(nextBackwardToken)(_.nextBackwardToken(_))
        .build

    def getLogGroupFieldsRequest(
      logGroupName: Option[String] = None,
      time: Option[Timestamp] = None
    ): GetLogGroupFieldsRequest =
      GetLogGroupFieldsRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(time)(_.time(_))
        .build

    def getLogGroupFieldsResponse(
      logGroupFields: Option[List[LogGroupField]] = None
    ): GetLogGroupFieldsResponse =
      GetLogGroupFieldsResponse
        .builder
        .ifSome(logGroupFields)(_.logGroupFields(_))
        .build

    def getLogRecordRequest(
      logRecordPointer: Option[String] = None
    ): GetLogRecordRequest =
      GetLogRecordRequest
        .builder
        .ifSome(logRecordPointer)(_.logRecordPointer(_))
        .build

    def getLogRecordResponse(
      logRecord: Option[LogRecord] = None
    ): GetLogRecordResponse =
      GetLogRecordResponse
        .builder
        .ifSome(logRecord)(_.logRecord(_))
        .build

    def getQueryResultsRequest(
      queryId: Option[String] = None
    ): GetQueryResultsRequest =
      GetQueryResultsRequest
        .builder
        .ifSome(queryId)(_.queryId(_))
        .build

    def getQueryResultsResponse(
      results: Option[List[ResultRows]] = None,
      statistics: Option[QueryStatistics] = None,
      status: Option[String] = None
    ): GetQueryResultsResponse =
      GetQueryResultsResponse
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(statistics)(_.statistics(_))
        .ifSome(status)(_.status(_))
        .build

    def inputLogEvent(
      timestamp: Option[Timestamp] = None,
      message: Option[String] = None
    ): InputLogEvent =
      InputLogEvent
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidOperationException(

    ): InvalidOperationException =
      InvalidOperationException
        .builder

        .build

    def invalidParameterException(

    ): InvalidParameterException =
      InvalidParameterException
        .builder

        .build

    def invalidSequenceTokenException(
      expectedSequenceToken: Option[String] = None
    ): InvalidSequenceTokenException =
      InvalidSequenceTokenException
        .builder
        .ifSome(expectedSequenceToken)(_.expectedSequenceToken(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listTagsLogGroupRequest(
      logGroupName: Option[String] = None
    ): ListTagsLogGroupRequest =
      ListTagsLogGroupRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def listTagsLogGroupResponse(
      tags: Option[Tags] = None
    ): ListTagsLogGroupResponse =
      ListTagsLogGroupResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def logGroup(
      logGroupName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      retentionInDays: Option[Int] = None,
      metricFilterCount: Option[Int] = None,
      arn: Option[String] = None,
      storedBytes: Option[StoredBytes] = None,
      kmsKeyId: Option[String] = None
    ): LogGroup =
      LogGroup
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(retentionInDays)(_.retentionInDays(_))
        .ifSome(metricFilterCount)(_.metricFilterCount(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(storedBytes)(_.storedBytes(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def logGroupField(
      name: Option[String] = None,
      percent: Option[Int] = None
    ): LogGroupField =
      LogGroupField
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(percent)(_.percent(_))
        .build

    def logStream(
      logStreamName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      firstEventTimestamp: Option[Timestamp] = None,
      lastEventTimestamp: Option[Timestamp] = None,
      lastIngestionTime: Option[Timestamp] = None,
      uploadSequenceToken: Option[String] = None,
      arn: Option[String] = None,
      storedBytes: Option[StoredBytes] = None
    ): LogStream =
      LogStream
        .builder
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(firstEventTimestamp)(_.firstEventTimestamp(_))
        .ifSome(lastEventTimestamp)(_.lastEventTimestamp(_))
        .ifSome(lastIngestionTime)(_.lastIngestionTime(_))
        .ifSome(uploadSequenceToken)(_.uploadSequenceToken(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(storedBytes)(_.storedBytes(_))
        .build

    def malformedQueryException(
      queryCompileError: Option[QueryCompileError] = None
    ): MalformedQueryException =
      MalformedQueryException
        .builder
        .ifSome(queryCompileError)(_.queryCompileError(_))
        .build

    def metricFilter(
      filterName: Option[String] = None,
      filterPattern: Option[String] = None,
      metricTransformations: Option[List[MetricTransformation]] = None,
      creationTime: Option[Timestamp] = None,
      logGroupName: Option[String] = None
    ): MetricFilter =
      MetricFilter
        .builder
        .ifSome(filterName)(_.filterName(_))
        .ifSome(filterPattern)(_.filterPattern(_))
        .ifSome(metricTransformations)(_.metricTransformations(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def metricFilterMatchRecord(
      eventNumber: Option[EventNumber] = None,
      eventMessage: Option[String] = None,
      extractedValues: Option[ExtractedValues] = None
    ): MetricFilterMatchRecord =
      MetricFilterMatchRecord
        .builder
        .ifSome(eventNumber)(_.eventNumber(_))
        .ifSome(eventMessage)(_.eventMessage(_))
        .ifSome(extractedValues)(_.extractedValues(_))
        .build

    def metricTransformation(
      metricName: Option[String] = None,
      metricNamespace: Option[String] = None,
      metricValue: Option[String] = None,
      defaultValue: Option[DefaultValue] = None,
      dimensions: Option[Dimensions] = None,
      unit: Option[String] = None
    ): MetricTransformation =
      MetricTransformation
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricNamespace)(_.metricNamespace(_))
        .ifSome(metricValue)(_.metricValue(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(unit)(_.unit(_))
        .build

    def operationAbortedException(

    ): OperationAbortedException =
      OperationAbortedException
        .builder

        .build

    def outputLogEvent(
      timestamp: Option[Timestamp] = None,
      message: Option[String] = None,
      ingestionTime: Option[Timestamp] = None
    ): OutputLogEvent =
      OutputLogEvent
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(message)(_.message(_))
        .ifSome(ingestionTime)(_.ingestionTime(_))
        .build

    def putDestinationPolicyRequest(
      destinationName: Option[String] = None,
      accessPolicy: Option[String] = None
    ): PutDestinationPolicyRequest =
      PutDestinationPolicyRequest
        .builder
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(accessPolicy)(_.accessPolicy(_))
        .build

    def putDestinationRequest(
      destinationName: Option[String] = None,
      targetArn: Option[String] = None,
      roleArn: Option[String] = None
    ): PutDestinationRequest =
      PutDestinationRequest
        .builder
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def putDestinationResponse(
      destination: Option[Destination] = None
    ): PutDestinationResponse =
      PutDestinationResponse
        .builder
        .ifSome(destination)(_.destination(_))
        .build

    def putLogEventsRequest(
      logGroupName: Option[String] = None,
      logStreamName: Option[String] = None,
      logEvents: Option[List[InputLogEvent]] = None,
      sequenceToken: Option[String] = None
    ): PutLogEventsRequest =
      PutLogEventsRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(logEvents)(_.logEvents(_))
        .ifSome(sequenceToken)(_.sequenceToken(_))
        .build

    def putLogEventsResponse(
      nextSequenceToken: Option[String] = None,
      rejectedLogEventsInfo: Option[RejectedLogEventsInfo] = None
    ): PutLogEventsResponse =
      PutLogEventsResponse
        .builder
        .ifSome(nextSequenceToken)(_.nextSequenceToken(_))
        .ifSome(rejectedLogEventsInfo)(_.rejectedLogEventsInfo(_))
        .build

    def putMetricFilterRequest(
      logGroupName: Option[String] = None,
      filterName: Option[String] = None,
      filterPattern: Option[String] = None,
      metricTransformations: Option[List[MetricTransformation]] = None
    ): PutMetricFilterRequest =
      PutMetricFilterRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(filterName)(_.filterName(_))
        .ifSome(filterPattern)(_.filterPattern(_))
        .ifSome(metricTransformations)(_.metricTransformations(_))
        .build

    def putQueryDefinitionRequest(
      name: Option[String] = None,
      queryDefinitionId: Option[String] = None,
      logGroupNames: Option[List[LogGroupName]] = None,
      queryString: Option[String] = None
    ): PutQueryDefinitionRequest =
      PutQueryDefinitionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(queryDefinitionId)(_.queryDefinitionId(_))
        .ifSome(logGroupNames)(_.logGroupNames(_))
        .ifSome(queryString)(_.queryString(_))
        .build

    def putQueryDefinitionResponse(
      queryDefinitionId: Option[String] = None
    ): PutQueryDefinitionResponse =
      PutQueryDefinitionResponse
        .builder
        .ifSome(queryDefinitionId)(_.queryDefinitionId(_))
        .build

    def putResourcePolicyRequest(
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): PutResourcePolicyRequest =
      PutResourcePolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def putResourcePolicyResponse(
      resourcePolicy: Option[ResourcePolicy] = None
    ): PutResourcePolicyResponse =
      PutResourcePolicyResponse
        .builder
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .build

    def putRetentionPolicyRequest(
      logGroupName: Option[String] = None,
      retentionInDays: Option[Int] = None
    ): PutRetentionPolicyRequest =
      PutRetentionPolicyRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(retentionInDays)(_.retentionInDays(_))
        .build

    def putSubscriptionFilterRequest(
      logGroupName: Option[String] = None,
      filterName: Option[String] = None,
      filterPattern: Option[String] = None,
      destinationArn: Option[String] = None,
      roleArn: Option[String] = None,
      distribution: Option[String] = None
    ): PutSubscriptionFilterRequest =
      PutSubscriptionFilterRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(filterName)(_.filterName(_))
        .ifSome(filterPattern)(_.filterPattern(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(distribution)(_.distribution(_))
        .build

    def queryCompileError(
      location: Option[QueryCompileErrorLocation] = None,
      message: Option[String] = None
    ): QueryCompileError =
      QueryCompileError
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(message)(_.message(_))
        .build

    def queryCompileErrorLocation(
      startCharOffset: Option[Int] = None,
      endCharOffset: Option[Int] = None
    ): QueryCompileErrorLocation =
      QueryCompileErrorLocation
        .builder
        .ifSome(startCharOffset)(_.startCharOffset(_))
        .ifSome(endCharOffset)(_.endCharOffset(_))
        .build

    def queryDefinition(
      queryDefinitionId: Option[String] = None,
      name: Option[String] = None,
      queryString: Option[String] = None,
      lastModified: Option[Timestamp] = None,
      logGroupNames: Option[List[LogGroupName]] = None
    ): QueryDefinition =
      QueryDefinition
        .builder
        .ifSome(queryDefinitionId)(_.queryDefinitionId(_))
        .ifSome(name)(_.name(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(logGroupNames)(_.logGroupNames(_))
        .build

    def queryInfo(
      queryId: Option[String] = None,
      queryString: Option[String] = None,
      status: Option[String] = None,
      createTime: Option[Timestamp] = None,
      logGroupName: Option[String] = None
    ): QueryInfo =
      QueryInfo
        .builder
        .ifSome(queryId)(_.queryId(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(status)(_.status(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def queryStatistics(
      recordsMatched: Option[StatsValue] = None,
      recordsScanned: Option[StatsValue] = None,
      bytesScanned: Option[StatsValue] = None
    ): QueryStatistics =
      QueryStatistics
        .builder
        .ifSome(recordsMatched)(_.recordsMatched(_))
        .ifSome(recordsScanned)(_.recordsScanned(_))
        .ifSome(bytesScanned)(_.bytesScanned(_))
        .build

    def rejectedLogEventsInfo(
      tooNewLogEventStartIndex: Option[Int] = None,
      tooOldLogEventEndIndex: Option[Int] = None,
      expiredLogEventEndIndex: Option[Int] = None
    ): RejectedLogEventsInfo =
      RejectedLogEventsInfo
        .builder
        .ifSome(tooNewLogEventStartIndex)(_.tooNewLogEventStartIndex(_))
        .ifSome(tooOldLogEventEndIndex)(_.tooOldLogEventEndIndex(_))
        .ifSome(expiredLogEventEndIndex)(_.expiredLogEventEndIndex(_))
        .build

    def resourceAlreadyExistsException(

    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def resourcePolicy(
      policyName: Option[String] = None,
      policyDocument: Option[String] = None,
      lastUpdatedTime: Option[Timestamp] = None
    ): ResourcePolicy =
      ResourcePolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def resultField(
      field: Option[String] = None,
      value: Option[String] = None
    ): ResultField =
      ResultField
        .builder
        .ifSome(field)(_.field(_))
        .ifSome(value)(_.value(_))
        .build

    def searchedLogStream(
      logStreamName: Option[String] = None,
      searchedCompletely: Option[Boolean] = None
    ): SearchedLogStream =
      SearchedLogStream
        .builder
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(searchedCompletely)(_.searchedCompletely(_))
        .build

    def serviceUnavailableException(

    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder

        .build

    def startQueryRequest(
      logGroupName: Option[String] = None,
      logGroupNames: Option[List[LogGroupName]] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      queryString: Option[String] = None,
      limit: Option[Int] = None
    ): StartQueryRequest =
      StartQueryRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logGroupNames)(_.logGroupNames(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(limit)(_.limit(_))
        .build

    def startQueryResponse(
      queryId: Option[String] = None
    ): StartQueryResponse =
      StartQueryResponse
        .builder
        .ifSome(queryId)(_.queryId(_))
        .build

    def stopQueryRequest(
      queryId: Option[String] = None
    ): StopQueryRequest =
      StopQueryRequest
        .builder
        .ifSome(queryId)(_.queryId(_))
        .build

    def stopQueryResponse(
      success: Option[Boolean] = None
    ): StopQueryResponse =
      StopQueryResponse
        .builder
        .ifSome(success)(_.success(_))
        .build

    def subscriptionFilter(
      filterName: Option[String] = None,
      logGroupName: Option[String] = None,
      filterPattern: Option[String] = None,
      destinationArn: Option[String] = None,
      roleArn: Option[String] = None,
      distribution: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): SubscriptionFilter =
      SubscriptionFilter
        .builder
        .ifSome(filterName)(_.filterName(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(filterPattern)(_.filterPattern(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(distribution)(_.distribution(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def tagLogGroupRequest(
      logGroupName: Option[String] = None,
      tags: Option[Tags] = None
    ): TagLogGroupRequest =
      TagLogGroupRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def testMetricFilterRequest(
      filterPattern: Option[String] = None,
      logEventMessages: Option[List[EventMessage]] = None
    ): TestMetricFilterRequest =
      TestMetricFilterRequest
        .builder
        .ifSome(filterPattern)(_.filterPattern(_))
        .ifSome(logEventMessages)(_.logEventMessages(_))
        .build

    def testMetricFilterResponse(
      matches: Option[List[MetricFilterMatchRecord]] = None
    ): TestMetricFilterResponse =
      TestMetricFilterResponse
        .builder
        .ifSome(matches)(_.matches(_))
        .build

    def unrecognizedClientException(

    ): UnrecognizedClientException =
      UnrecognizedClientException
        .builder

        .build

    def untagLogGroupRequest(
      logGroupName: Option[String] = None,
      tags: Option[List[TagKey]] = None
    ): UntagLogGroupRequest =
      UntagLogGroupRequest
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(tags)(_.tags(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
