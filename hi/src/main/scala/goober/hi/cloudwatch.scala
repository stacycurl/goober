package goober.hi

import goober.free.cloudwatch.CloudWatchIO
import software.amazon.awssdk.services.cloudwatch.model._


object cloudwatch {
  import goober.free.{cloudwatch ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def alarmHistoryItem(
      alarmName: Option[String] = None,
      alarmType: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      historyItemType: Option[String] = None,
      historySummary: Option[String] = None,
      historyData: Option[String] = None
    ): AlarmHistoryItem =
      AlarmHistoryItem
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmType)(_.alarmType(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(historyItemType)(_.historyItemType(_))
        .ifSome(historySummary)(_.historySummary(_))
        .ifSome(historyData)(_.historyData(_))
        .build

    def anomalyDetector(
      namespace: Option[String] = None,
      metricName: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      stat: Option[String] = None,
      configuration: Option[AnomalyDetectorConfiguration] = None,
      stateValue: Option[String] = None
    ): AnomalyDetector =
      AnomalyDetector
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(stat)(_.stat(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(stateValue)(_.stateValue(_))
        .build

    def anomalyDetectorConfiguration(
      excludedTimeRanges: Option[List[Range]] = None,
      metricTimezone: Option[String] = None
    ): AnomalyDetectorConfiguration =
      AnomalyDetectorConfiguration
        .builder
        .ifSome(excludedTimeRanges)(_.excludedTimeRanges(_))
        .ifSome(metricTimezone)(_.metricTimezone(_))
        .build

    def compositeAlarm(
      actionsEnabled: Option[Boolean] = None,
      alarmActions: Option[List[ResourceName]] = None,
      alarmArn: Option[String] = None,
      alarmConfigurationUpdatedTimestamp: Option[Timestamp] = None,
      alarmDescription: Option[String] = None,
      alarmName: Option[String] = None,
      alarmRule: Option[String] = None,
      insufficientDataActions: Option[List[ResourceName]] = None,
      oKActions: Option[List[ResourceName]] = None,
      stateReason: Option[String] = None,
      stateReasonData: Option[String] = None,
      stateUpdatedTimestamp: Option[Timestamp] = None,
      stateValue: Option[String] = None
    ): CompositeAlarm =
      CompositeAlarm
        .builder
        .ifSome(actionsEnabled)(_.actionsEnabled(_))
        .ifSome(alarmActions)(_.alarmActions(_))
        .ifSome(alarmArn)(_.alarmArn(_))
        .ifSome(alarmConfigurationUpdatedTimestamp)(_.alarmConfigurationUpdatedTimestamp(_))
        .ifSome(alarmDescription)(_.alarmDescription(_))
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmRule)(_.alarmRule(_))
        .ifSome(insufficientDataActions)(_.insufficientDataActions(_))
        .ifSome(oKActions)(_.oKActions(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(stateReasonData)(_.stateReasonData(_))
        .ifSome(stateUpdatedTimestamp)(_.stateUpdatedTimestamp(_))
        .ifSome(stateValue)(_.stateValue(_))
        .build

    def concurrentModificationException(

    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder

        .build

    def dashboardEntry(
      dashboardName: Option[String] = None,
      dashboardArn: Option[String] = None,
      lastModified: Option[LastModified] = None,
      size: Option[Size] = None
    ): DashboardEntry =
      DashboardEntry
        .builder
        .ifSome(dashboardName)(_.dashboardName(_))
        .ifSome(dashboardArn)(_.dashboardArn(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(size)(_.size(_))
        .build

    def dashboardInvalidInputError(
      message: Option[String] = None,
      dashboardValidationMessages: Option[List[DashboardValidationMessage]] = None
    ): DashboardInvalidInputError =
      DashboardInvalidInputError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(dashboardValidationMessages)(_.dashboardValidationMessages(_))
        .build

    def dashboardNotFoundError(
      message: Option[String] = None
    ): DashboardNotFoundError =
      DashboardNotFoundError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dashboardValidationMessage(
      dataPath: Option[String] = None,
      message: Option[String] = None
    ): DashboardValidationMessage =
      DashboardValidationMessage
        .builder
        .ifSome(dataPath)(_.dataPath(_))
        .ifSome(message)(_.message(_))
        .build

    def datapoint(
      timestamp: Option[Timestamp] = None,
      sampleCount: Option[DatapointValue] = None,
      average: Option[DatapointValue] = None,
      sum: Option[DatapointValue] = None,
      minimum: Option[DatapointValue] = None,
      maximum: Option[DatapointValue] = None,
      unit: Option[String] = None,
      extendedStatistics: Option[DatapointValueMap] = None
    ): Datapoint =
      Datapoint
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(sampleCount)(_.sampleCount(_))
        .ifSome(average)(_.average(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(minimum)(_.minimum(_))
        .ifSome(maximum)(_.maximum(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(extendedStatistics)(_.extendedStatistics(_))
        .build

    def deleteAlarmsInput(
      alarmNames: Option[List[AlarmName]] = None
    ): DeleteAlarmsInput =
      DeleteAlarmsInput
        .builder
        .ifSome(alarmNames)(_.alarmNames(_))
        .build

    def deleteAnomalyDetectorInput(
      namespace: Option[String] = None,
      metricName: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      stat: Option[String] = None
    ): DeleteAnomalyDetectorInput =
      DeleteAnomalyDetectorInput
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(stat)(_.stat(_))
        .build

    def deleteAnomalyDetectorOutput(

    ): DeleteAnomalyDetectorOutput =
      DeleteAnomalyDetectorOutput
        .builder

        .build

    def deleteDashboardsInput(
      dashboardNames: Option[List[DashboardName]] = None
    ): DeleteDashboardsInput =
      DeleteDashboardsInput
        .builder
        .ifSome(dashboardNames)(_.dashboardNames(_))
        .build

    def deleteDashboardsOutput(

    ): DeleteDashboardsOutput =
      DeleteDashboardsOutput
        .builder

        .build

    def deleteInsightRulesInput(
      ruleNames: Option[List[InsightRuleName]] = None
    ): DeleteInsightRulesInput =
      DeleteInsightRulesInput
        .builder
        .ifSome(ruleNames)(_.ruleNames(_))
        .build

    def deleteInsightRulesOutput(
      failures: Option[List[PartialFailure]] = None
    ): DeleteInsightRulesOutput =
      DeleteInsightRulesOutput
        .builder
        .ifSome(failures)(_.failures(_))
        .build

    def deleteMetricStreamInput(
      name: Option[String] = None
    ): DeleteMetricStreamInput =
      DeleteMetricStreamInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteMetricStreamOutput(

    ): DeleteMetricStreamOutput =
      DeleteMetricStreamOutput
        .builder

        .build

    def describeAlarmHistoryInput(
      alarmName: Option[String] = None,
      alarmTypes: Option[List[AlarmType]] = None,
      historyItemType: Option[String] = None,
      startDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None,
      scanBy: Option[String] = None
    ): DescribeAlarmHistoryInput =
      DescribeAlarmHistoryInput
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmTypes)(_.alarmTypes(_))
        .ifSome(historyItemType)(_.historyItemType(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(scanBy)(_.scanBy(_))
        .build

    def describeAlarmHistoryOutput(
      alarmHistoryItems: Option[List[AlarmHistoryItem]] = None,
      nextToken: Option[String] = None
    ): DescribeAlarmHistoryOutput =
      DescribeAlarmHistoryOutput
        .builder
        .ifSome(alarmHistoryItems)(_.alarmHistoryItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAlarmsForMetricInput(
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      statistic: Option[String] = None,
      extendedStatistic: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      period: Option[Int] = None,
      unit: Option[String] = None
    ): DescribeAlarmsForMetricInput =
      DescribeAlarmsForMetricInput
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(extendedStatistic)(_.extendedStatistic(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(period)(_.period(_))
        .ifSome(unit)(_.unit(_))
        .build

    def describeAlarmsForMetricOutput(
      metricAlarms: Option[List[MetricAlarm]] = None
    ): DescribeAlarmsForMetricOutput =
      DescribeAlarmsForMetricOutput
        .builder
        .ifSome(metricAlarms)(_.metricAlarms(_))
        .build

    def describeAlarmsInput(
      alarmNames: Option[List[AlarmName]] = None,
      alarmNamePrefix: Option[String] = None,
      alarmTypes: Option[List[AlarmType]] = None,
      childrenOfAlarmName: Option[String] = None,
      parentsOfAlarmName: Option[String] = None,
      stateValue: Option[String] = None,
      actionPrefix: Option[String] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAlarmsInput =
      DescribeAlarmsInput
        .builder
        .ifSome(alarmNames)(_.alarmNames(_))
        .ifSome(alarmNamePrefix)(_.alarmNamePrefix(_))
        .ifSome(alarmTypes)(_.alarmTypes(_))
        .ifSome(childrenOfAlarmName)(_.childrenOfAlarmName(_))
        .ifSome(parentsOfAlarmName)(_.parentsOfAlarmName(_))
        .ifSome(stateValue)(_.stateValue(_))
        .ifSome(actionPrefix)(_.actionPrefix(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAlarmsOutput(
      compositeAlarms: Option[List[CompositeAlarm]] = None,
      metricAlarms: Option[List[MetricAlarm]] = None,
      nextToken: Option[String] = None
    ): DescribeAlarmsOutput =
      DescribeAlarmsOutput
        .builder
        .ifSome(compositeAlarms)(_.compositeAlarms(_))
        .ifSome(metricAlarms)(_.metricAlarms(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAnomalyDetectorsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      namespace: Option[String] = None,
      metricName: Option[String] = None,
      dimensions: Option[List[Dimension]] = None
    ): DescribeAnomalyDetectorsInput =
      DescribeAnomalyDetectorsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .build

    def describeAnomalyDetectorsOutput(
      anomalyDetectors: Option[List[AnomalyDetector]] = None,
      nextToken: Option[String] = None
    ): DescribeAnomalyDetectorsOutput =
      DescribeAnomalyDetectorsOutput
        .builder
        .ifSome(anomalyDetectors)(_.anomalyDetectors(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInsightRulesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeInsightRulesInput =
      DescribeInsightRulesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeInsightRulesOutput(
      nextToken: Option[String] = None,
      insightRules: Option[List[InsightRule]] = None
    ): DescribeInsightRulesOutput =
      DescribeInsightRulesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(insightRules)(_.insightRules(_))
        .build

    def dimension(
      name: Option[String] = None,
      value: Option[String] = None
    ): Dimension =
      Dimension
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def dimensionFilter(
      name: Option[String] = None,
      value: Option[String] = None
    ): DimensionFilter =
      DimensionFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def disableAlarmActionsInput(
      alarmNames: Option[List[AlarmName]] = None
    ): DisableAlarmActionsInput =
      DisableAlarmActionsInput
        .builder
        .ifSome(alarmNames)(_.alarmNames(_))
        .build

    def disableInsightRulesInput(
      ruleNames: Option[List[InsightRuleName]] = None
    ): DisableInsightRulesInput =
      DisableInsightRulesInput
        .builder
        .ifSome(ruleNames)(_.ruleNames(_))
        .build

    def disableInsightRulesOutput(
      failures: Option[List[PartialFailure]] = None
    ): DisableInsightRulesOutput =
      DisableInsightRulesOutput
        .builder
        .ifSome(failures)(_.failures(_))
        .build

    def enableAlarmActionsInput(
      alarmNames: Option[List[AlarmName]] = None
    ): EnableAlarmActionsInput =
      EnableAlarmActionsInput
        .builder
        .ifSome(alarmNames)(_.alarmNames(_))
        .build

    def enableInsightRulesInput(
      ruleNames: Option[List[InsightRuleName]] = None
    ): EnableInsightRulesInput =
      EnableInsightRulesInput
        .builder
        .ifSome(ruleNames)(_.ruleNames(_))
        .build

    def enableInsightRulesOutput(
      failures: Option[List[PartialFailure]] = None
    ): EnableInsightRulesOutput =
      EnableInsightRulesOutput
        .builder
        .ifSome(failures)(_.failures(_))
        .build

    def getDashboardInput(
      dashboardName: Option[String] = None
    ): GetDashboardInput =
      GetDashboardInput
        .builder
        .ifSome(dashboardName)(_.dashboardName(_))
        .build

    def getDashboardOutput(
      dashboardArn: Option[String] = None,
      dashboardBody: Option[String] = None,
      dashboardName: Option[String] = None
    ): GetDashboardOutput =
      GetDashboardOutput
        .builder
        .ifSome(dashboardArn)(_.dashboardArn(_))
        .ifSome(dashboardBody)(_.dashboardBody(_))
        .ifSome(dashboardName)(_.dashboardName(_))
        .build

    def getInsightRuleReportInput(
      ruleName: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      period: Option[Int] = None,
      maxContributorCount: Option[Int] = None,
      metrics: Option[List[InsightRuleMetricName]] = None,
      orderBy: Option[String] = None
    ): GetInsightRuleReportInput =
      GetInsightRuleReportInput
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(period)(_.period(_))
        .ifSome(maxContributorCount)(_.maxContributorCount(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def getInsightRuleReportOutput(
      keyLabels: Option[List[InsightRuleContributorKeyLabel]] = None,
      aggregationStatistic: Option[String] = None,
      aggregateValue: Option[InsightRuleUnboundDouble] = None,
      approximateUniqueCount: Option[InsightRuleUnboundLong] = None,
      contributors: Option[List[InsightRuleContributor]] = None,
      metricDatapoints: Option[List[InsightRuleMetricDatapoint]] = None
    ): GetInsightRuleReportOutput =
      GetInsightRuleReportOutput
        .builder
        .ifSome(keyLabels)(_.keyLabels(_))
        .ifSome(aggregationStatistic)(_.aggregationStatistic(_))
        .ifSome(aggregateValue)(_.aggregateValue(_))
        .ifSome(approximateUniqueCount)(_.approximateUniqueCount(_))
        .ifSome(contributors)(_.contributors(_))
        .ifSome(metricDatapoints)(_.metricDatapoints(_))
        .build

    def getMetricDataInput(
      metricDataQueries: Option[List[MetricDataQuery]] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      nextToken: Option[String] = None,
      scanBy: Option[String] = None,
      maxDatapoints: Option[Int] = None,
      labelOptions: Option[LabelOptions] = None
    ): GetMetricDataInput =
      GetMetricDataInput
        .builder
        .ifSome(metricDataQueries)(_.metricDataQueries(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(scanBy)(_.scanBy(_))
        .ifSome(maxDatapoints)(_.maxDatapoints(_))
        .ifSome(labelOptions)(_.labelOptions(_))
        .build

    def getMetricDataOutput(
      metricDataResults: Option[List[MetricDataResult]] = None,
      nextToken: Option[String] = None,
      messages: Option[List[MessageData]] = None
    ): GetMetricDataOutput =
      GetMetricDataOutput
        .builder
        .ifSome(metricDataResults)(_.metricDataResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(messages)(_.messages(_))
        .build

    def getMetricStatisticsInput(
      namespace: Option[String] = None,
      metricName: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      period: Option[Int] = None,
      statistics: Option[List[Statistic]] = None,
      extendedStatistics: Option[List[ExtendedStatistic]] = None,
      unit: Option[String] = None
    ): GetMetricStatisticsInput =
      GetMetricStatisticsInput
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(period)(_.period(_))
        .ifSome(statistics)(_.statistics(_))
        .ifSome(extendedStatistics)(_.extendedStatistics(_))
        .ifSome(unit)(_.unit(_))
        .build

    def getMetricStatisticsOutput(
      label: Option[String] = None,
      datapoints: Option[List[Datapoint]] = None
    ): GetMetricStatisticsOutput =
      GetMetricStatisticsOutput
        .builder
        .ifSome(label)(_.label(_))
        .ifSome(datapoints)(_.datapoints(_))
        .build

    def getMetricStreamInput(
      name: Option[String] = None
    ): GetMetricStreamInput =
      GetMetricStreamInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getMetricStreamOutput(
      arn: Option[String] = None,
      name: Option[String] = None,
      includeFilters: Option[List[MetricStreamFilter]] = None,
      excludeFilters: Option[List[MetricStreamFilter]] = None,
      firehoseArn: Option[String] = None,
      roleArn: Option[String] = None,
      state: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None,
      outputFormat: Option[String] = None
    ): GetMetricStreamOutput =
      GetMetricStreamOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(includeFilters)(_.includeFilters(_))
        .ifSome(excludeFilters)(_.excludeFilters(_))
        .ifSome(firehoseArn)(_.firehoseArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .build

    def getMetricWidgetImageInput(
      metricWidget: Option[String] = None,
      outputFormat: Option[String] = None
    ): GetMetricWidgetImageInput =
      GetMetricWidgetImageInput
        .builder
        .ifSome(metricWidget)(_.metricWidget(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .build

    def getMetricWidgetImageOutput(
      metricWidgetImage: Option[MetricWidgetImage] = None
    ): GetMetricWidgetImageOutput =
      GetMetricWidgetImageOutput
        .builder
        .ifSome(metricWidgetImage)(_.metricWidgetImage(_))
        .build

    def insightRule(
      name: Option[String] = None,
      state: Option[String] = None,
      schema: Option[String] = None,
      definition: Option[String] = None
    ): InsightRule =
      InsightRule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(definition)(_.definition(_))
        .build

    def insightRuleContributor(
      keys: Option[List[InsightRuleContributorKey]] = None,
      approximateAggregateValue: Option[InsightRuleUnboundDouble] = None,
      datapoints: Option[List[InsightRuleContributorDatapoint]] = None
    ): InsightRuleContributor =
      InsightRuleContributor
        .builder
        .ifSome(keys)(_.keys(_))
        .ifSome(approximateAggregateValue)(_.approximateAggregateValue(_))
        .ifSome(datapoints)(_.datapoints(_))
        .build

    def insightRuleContributorDatapoint(
      timestamp: Option[Timestamp] = None,
      approximateValue: Option[InsightRuleUnboundDouble] = None
    ): InsightRuleContributorDatapoint =
      InsightRuleContributorDatapoint
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(approximateValue)(_.approximateValue(_))
        .build

    def insightRuleMetricDatapoint(
      timestamp: Option[Timestamp] = None,
      uniqueContributors: Option[InsightRuleUnboundDouble] = None,
      maxContributorValue: Option[InsightRuleUnboundDouble] = None,
      sampleCount: Option[InsightRuleUnboundDouble] = None,
      average: Option[InsightRuleUnboundDouble] = None,
      sum: Option[InsightRuleUnboundDouble] = None,
      minimum: Option[InsightRuleUnboundDouble] = None,
      maximum: Option[InsightRuleUnboundDouble] = None
    ): InsightRuleMetricDatapoint =
      InsightRuleMetricDatapoint
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(uniqueContributors)(_.uniqueContributors(_))
        .ifSome(maxContributorValue)(_.maxContributorValue(_))
        .ifSome(sampleCount)(_.sampleCount(_))
        .ifSome(average)(_.average(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(minimum)(_.minimum(_))
        .ifSome(maximum)(_.maximum(_))
        .build

    def internalServiceFault(
      message: Option[String] = None
    ): InternalServiceFault =
      InternalServiceFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFormatFault(
      message: Option[String] = None
    ): InvalidFormatFault =
      InvalidFormatFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextToken(
      message: Option[String] = None
    ): InvalidNextToken =
      InvalidNextToken
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterCombinationException(
      message: Option[String] = None
    ): InvalidParameterCombinationException =
      InvalidParameterCombinationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterValueException(
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def labelOptions(
      timezone: Option[String] = None
    ): LabelOptions =
      LabelOptions
        .builder
        .ifSome(timezone)(_.timezone(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def limitExceededFault(
      message: Option[String] = None
    ): LimitExceededFault =
      LimitExceededFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDashboardsInput(
      dashboardNamePrefix: Option[String] = None,
      nextToken: Option[String] = None
    ): ListDashboardsInput =
      ListDashboardsInput
        .builder
        .ifSome(dashboardNamePrefix)(_.dashboardNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDashboardsOutput(
      dashboardEntries: Option[List[DashboardEntry]] = None,
      nextToken: Option[String] = None
    ): ListDashboardsOutput =
      ListDashboardsOutput
        .builder
        .ifSome(dashboardEntries)(_.dashboardEntries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMetricStreamsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMetricStreamsInput =
      ListMetricStreamsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMetricStreamsOutput(
      nextToken: Option[String] = None,
      entries: Option[List[MetricStreamEntry]] = None
    ): ListMetricStreamsOutput =
      ListMetricStreamsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(entries)(_.entries(_))
        .build

    def listMetricsInput(
      namespace: Option[String] = None,
      metricName: Option[String] = None,
      dimensions: Option[List[DimensionFilter]] = None,
      nextToken: Option[String] = None,
      recentlyActive: Option[String] = None
    ): ListMetricsInput =
      ListMetricsInput
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(recentlyActive)(_.recentlyActive(_))
        .build

    def listMetricsOutput(
      metrics: Option[List[Metric]] = None,
      nextToken: Option[String] = None
    ): ListMetricsOutput =
      ListMetricsOutput
        .builder
        .ifSome(metrics)(_.metrics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceARN: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def messageData(
      code: Option[String] = None,
      value: Option[String] = None
    ): MessageData =
      MessageData
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(value)(_.value(_))
        .build

    def metric(
      namespace: Option[String] = None,
      metricName: Option[String] = None,
      dimensions: Option[List[Dimension]] = None
    ): Metric =
      Metric
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .build

    def metricAlarm(
      alarmName: Option[String] = None,
      alarmArn: Option[String] = None,
      alarmDescription: Option[String] = None,
      alarmConfigurationUpdatedTimestamp: Option[Timestamp] = None,
      actionsEnabled: Option[Boolean] = None,
      oKActions: Option[List[ResourceName]] = None,
      alarmActions: Option[List[ResourceName]] = None,
      insufficientDataActions: Option[List[ResourceName]] = None,
      stateValue: Option[String] = None,
      stateReason: Option[String] = None,
      stateReasonData: Option[String] = None,
      stateUpdatedTimestamp: Option[Timestamp] = None,
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      statistic: Option[String] = None,
      extendedStatistic: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      period: Option[Int] = None,
      unit: Option[String] = None,
      evaluationPeriods: Option[Int] = None,
      datapointsToAlarm: Option[Int] = None,
      threshold: Option[Threshold] = None,
      comparisonOperator: Option[String] = None,
      treatMissingData: Option[String] = None,
      evaluateLowSampleCountPercentile: Option[String] = None,
      metrics: Option[List[MetricDataQuery]] = None,
      thresholdMetricId: Option[String] = None
    ): MetricAlarm =
      MetricAlarm
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmArn)(_.alarmArn(_))
        .ifSome(alarmDescription)(_.alarmDescription(_))
        .ifSome(alarmConfigurationUpdatedTimestamp)(_.alarmConfigurationUpdatedTimestamp(_))
        .ifSome(actionsEnabled)(_.actionsEnabled(_))
        .ifSome(oKActions)(_.oKActions(_))
        .ifSome(alarmActions)(_.alarmActions(_))
        .ifSome(insufficientDataActions)(_.insufficientDataActions(_))
        .ifSome(stateValue)(_.stateValue(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(stateReasonData)(_.stateReasonData(_))
        .ifSome(stateUpdatedTimestamp)(_.stateUpdatedTimestamp(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(extendedStatistic)(_.extendedStatistic(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(period)(_.period(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(datapointsToAlarm)(_.datapointsToAlarm(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(treatMissingData)(_.treatMissingData(_))
        .ifSome(evaluateLowSampleCountPercentile)(_.evaluateLowSampleCountPercentile(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(thresholdMetricId)(_.thresholdMetricId(_))
        .build

    def metricDataQuery(
      id: Option[String] = None,
      metricStat: Option[MetricStat] = None,
      expression: Option[String] = None,
      label: Option[String] = None,
      returnData: Option[Boolean] = None,
      period: Option[Int] = None
    ): MetricDataQuery =
      MetricDataQuery
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(metricStat)(_.metricStat(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(label)(_.label(_))
        .ifSome(returnData)(_.returnData(_))
        .ifSome(period)(_.period(_))
        .build

    def metricDatum(
      metricName: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      timestamp: Option[Timestamp] = None,
      value: Option[DatapointValue] = None,
      statisticValues: Option[StatisticSet] = None,
      values: Option[List[DatapointValue]] = None,
      counts: Option[List[DatapointValue]] = None,
      unit: Option[String] = None,
      storageResolution: Option[Int] = None
    ): MetricDatum =
      MetricDatum
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(value)(_.value(_))
        .ifSome(statisticValues)(_.statisticValues(_))
        .ifSome(values)(_.values(_))
        .ifSome(counts)(_.counts(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(storageResolution)(_.storageResolution(_))
        .build

    def metricStat(
      metric: Option[Metric] = None,
      period: Option[Int] = None,
      stat: Option[String] = None,
      unit: Option[String] = None
    ): MetricStat =
      MetricStat
        .builder
        .ifSome(metric)(_.metric(_))
        .ifSome(period)(_.period(_))
        .ifSome(stat)(_.stat(_))
        .ifSome(unit)(_.unit(_))
        .build

    def metricStreamEntry(
      arn: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None,
      name: Option[String] = None,
      firehoseArn: Option[String] = None,
      state: Option[String] = None,
      outputFormat: Option[String] = None
    ): MetricStreamEntry =
      MetricStreamEntry
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(firehoseArn)(_.firehoseArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .build

    def metricStreamFilter(
      namespace: Option[String] = None
    ): MetricStreamFilter =
      MetricStreamFilter
        .builder
        .ifSome(namespace)(_.namespace(_))
        .build

    def missingRequiredParameterException(
      message: Option[String] = None
    ): MissingRequiredParameterException =
      MissingRequiredParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def partialFailure(
      failureResource: Option[String] = None,
      exceptionType: Option[String] = None,
      failureCode: Option[String] = None,
      failureDescription: Option[String] = None
    ): PartialFailure =
      PartialFailure
        .builder
        .ifSome(failureResource)(_.failureResource(_))
        .ifSome(exceptionType)(_.exceptionType(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureDescription)(_.failureDescription(_))
        .build

    def putAnomalyDetectorInput(
      namespace: Option[String] = None,
      metricName: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      stat: Option[String] = None,
      configuration: Option[AnomalyDetectorConfiguration] = None
    ): PutAnomalyDetectorInput =
      PutAnomalyDetectorInput
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(stat)(_.stat(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def putAnomalyDetectorOutput(

    ): PutAnomalyDetectorOutput =
      PutAnomalyDetectorOutput
        .builder

        .build

    def putCompositeAlarmInput(
      actionsEnabled: Option[Boolean] = None,
      alarmActions: Option[List[ResourceName]] = None,
      alarmDescription: Option[String] = None,
      alarmName: Option[String] = None,
      alarmRule: Option[String] = None,
      insufficientDataActions: Option[List[ResourceName]] = None,
      oKActions: Option[List[ResourceName]] = None,
      tags: Option[List[Tag]] = None
    ): PutCompositeAlarmInput =
      PutCompositeAlarmInput
        .builder
        .ifSome(actionsEnabled)(_.actionsEnabled(_))
        .ifSome(alarmActions)(_.alarmActions(_))
        .ifSome(alarmDescription)(_.alarmDescription(_))
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmRule)(_.alarmRule(_))
        .ifSome(insufficientDataActions)(_.insufficientDataActions(_))
        .ifSome(oKActions)(_.oKActions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putDashboardInput(
      dashboardName: Option[String] = None,
      dashboardBody: Option[String] = None
    ): PutDashboardInput =
      PutDashboardInput
        .builder
        .ifSome(dashboardName)(_.dashboardName(_))
        .ifSome(dashboardBody)(_.dashboardBody(_))
        .build

    def putDashboardOutput(
      dashboardValidationMessages: Option[List[DashboardValidationMessage]] = None
    ): PutDashboardOutput =
      PutDashboardOutput
        .builder
        .ifSome(dashboardValidationMessages)(_.dashboardValidationMessages(_))
        .build

    def putInsightRuleInput(
      ruleName: Option[String] = None,
      ruleState: Option[String] = None,
      ruleDefinition: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutInsightRuleInput =
      PutInsightRuleInput
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(ruleState)(_.ruleState(_))
        .ifSome(ruleDefinition)(_.ruleDefinition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putInsightRuleOutput(

    ): PutInsightRuleOutput =
      PutInsightRuleOutput
        .builder

        .build

    def putMetricAlarmInput(
      alarmName: Option[String] = None,
      alarmDescription: Option[String] = None,
      actionsEnabled: Option[Boolean] = None,
      oKActions: Option[List[ResourceName]] = None,
      alarmActions: Option[List[ResourceName]] = None,
      insufficientDataActions: Option[List[ResourceName]] = None,
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      statistic: Option[String] = None,
      extendedStatistic: Option[String] = None,
      dimensions: Option[List[Dimension]] = None,
      period: Option[Int] = None,
      unit: Option[String] = None,
      evaluationPeriods: Option[Int] = None,
      datapointsToAlarm: Option[Int] = None,
      threshold: Option[Threshold] = None,
      comparisonOperator: Option[String] = None,
      treatMissingData: Option[String] = None,
      evaluateLowSampleCountPercentile: Option[String] = None,
      metrics: Option[List[MetricDataQuery]] = None,
      tags: Option[List[Tag]] = None,
      thresholdMetricId: Option[String] = None
    ): PutMetricAlarmInput =
      PutMetricAlarmInput
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmDescription)(_.alarmDescription(_))
        .ifSome(actionsEnabled)(_.actionsEnabled(_))
        .ifSome(oKActions)(_.oKActions(_))
        .ifSome(alarmActions)(_.alarmActions(_))
        .ifSome(insufficientDataActions)(_.insufficientDataActions(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(extendedStatistic)(_.extendedStatistic(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(period)(_.period(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(datapointsToAlarm)(_.datapointsToAlarm(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(treatMissingData)(_.treatMissingData(_))
        .ifSome(evaluateLowSampleCountPercentile)(_.evaluateLowSampleCountPercentile(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(thresholdMetricId)(_.thresholdMetricId(_))
        .build

    def putMetricDataInput(
      namespace: Option[String] = None,
      metricData: Option[List[MetricDatum]] = None
    ): PutMetricDataInput =
      PutMetricDataInput
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(metricData)(_.metricData(_))
        .build

    def putMetricStreamInput(
      name: Option[String] = None,
      includeFilters: Option[List[MetricStreamFilter]] = None,
      excludeFilters: Option[List[MetricStreamFilter]] = None,
      firehoseArn: Option[String] = None,
      roleArn: Option[String] = None,
      outputFormat: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutMetricStreamInput =
      PutMetricStreamInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(includeFilters)(_.includeFilters(_))
        .ifSome(excludeFilters)(_.excludeFilters(_))
        .ifSome(firehoseArn)(_.firehoseArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putMetricStreamOutput(
      arn: Option[String] = None
    ): PutMetricStreamOutput =
      PutMetricStreamOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def range(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): Range =
      Range
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def resourceNotFound(
      message: Option[String] = None
    ): ResourceNotFound =
      ResourceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def setAlarmStateInput(
      alarmName: Option[String] = None,
      stateValue: Option[String] = None,
      stateReason: Option[String] = None,
      stateReasonData: Option[String] = None
    ): SetAlarmStateInput =
      SetAlarmStateInput
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(stateValue)(_.stateValue(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(stateReasonData)(_.stateReasonData(_))
        .build

    def startMetricStreamsInput(
      names: Option[List[MetricStreamName]] = None
    ): StartMetricStreamsInput =
      StartMetricStreamsInput
        .builder
        .ifSome(names)(_.names(_))
        .build

    def startMetricStreamsOutput(

    ): StartMetricStreamsOutput =
      StartMetricStreamsOutput
        .builder

        .build

    def statisticSet(
      sampleCount: Option[DatapointValue] = None,
      sum: Option[DatapointValue] = None,
      minimum: Option[DatapointValue] = None,
      maximum: Option[DatapointValue] = None
    ): StatisticSet =
      StatisticSet
        .builder
        .ifSome(sampleCount)(_.sampleCount(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(minimum)(_.minimum(_))
        .ifSome(maximum)(_.maximum(_))
        .build

    def stopMetricStreamsInput(
      names: Option[List[MetricStreamName]] = None
    ): StopMetricStreamsInput =
      StopMetricStreamsInput
        .builder
        .ifSome(names)(_.names(_))
        .build

    def stopMetricStreamsOutput(

    ): StopMetricStreamsOutput =
      StopMetricStreamsOutput
        .builder

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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def untagResourceInput(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
