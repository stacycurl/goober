package goober.hi

import goober.free.lookoutmetrics.LookoutMetricsIO
import software.amazon.awssdk.services.lookoutmetrics.model._


object lookoutmetrics {
  import goober.free.{lookoutmetrics ⇒ free}

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

    def action(
      sNSConfiguration: Option[SNSConfiguration] = None,
      lambdaConfiguration: Option[LambdaConfiguration] = None
    ): Action =
      Action
        .builder
        .ifSome(sNSConfiguration)(_.sNSConfiguration(_))
        .ifSome(lambdaConfiguration)(_.lambdaConfiguration(_))
        .build

    def activateAnomalyDetectorRequest(
      anomalyDetectorArn: Option[String] = None
    ): ActivateAnomalyDetectorRequest =
      ActivateAnomalyDetectorRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .build

    def activateAnomalyDetectorResponse(

    ): ActivateAnomalyDetectorResponse =
      ActivateAnomalyDetectorResponse
        .builder

        .build

    def alert(
      action: Option[Action] = None,
      alertDescription: Option[String] = None,
      alertArn: Option[String] = None,
      anomalyDetectorArn: Option[String] = None,
      alertName: Option[String] = None,
      alertSensitivityThreshold: Option[Int] = None,
      alertType: Option[String] = None,
      alertStatus: Option[String] = None,
      lastModificationTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None
    ): Alert =
      Alert
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(alertDescription)(_.alertDescription(_))
        .ifSome(alertArn)(_.alertArn(_))
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(alertName)(_.alertName(_))
        .ifSome(alertSensitivityThreshold)(_.alertSensitivityThreshold(_))
        .ifSome(alertType)(_.alertType(_))
        .ifSome(alertStatus)(_.alertStatus(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def alertSummary(
      alertArn: Option[String] = None,
      anomalyDetectorArn: Option[String] = None,
      alertName: Option[String] = None,
      alertSensitivityThreshold: Option[Int] = None,
      alertType: Option[String] = None,
      alertStatus: Option[String] = None,
      lastModificationTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None,
      tags: Option[TagMap] = None
    ): AlertSummary =
      AlertSummary
        .builder
        .ifSome(alertArn)(_.alertArn(_))
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(alertName)(_.alertName(_))
        .ifSome(alertSensitivityThreshold)(_.alertSensitivityThreshold(_))
        .ifSome(alertType)(_.alertType(_))
        .ifSome(alertStatus)(_.alertStatus(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def anomalyDetectorConfig(
      anomalyDetectorFrequency: Option[String] = None
    ): AnomalyDetectorConfig =
      AnomalyDetectorConfig
        .builder
        .ifSome(anomalyDetectorFrequency)(_.anomalyDetectorFrequency(_))
        .build

    def anomalyDetectorConfigSummary(
      anomalyDetectorFrequency: Option[String] = None
    ): AnomalyDetectorConfigSummary =
      AnomalyDetectorConfigSummary
        .builder
        .ifSome(anomalyDetectorFrequency)(_.anomalyDetectorFrequency(_))
        .build

    def anomalyDetectorSummary(
      anomalyDetectorArn: Option[String] = None,
      anomalyDetectorName: Option[String] = None,
      anomalyDetectorDescription: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None,
      status: Option[String] = None,
      tags: Option[TagMap] = None
    ): AnomalyDetectorSummary =
      AnomalyDetectorSummary
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(anomalyDetectorName)(_.anomalyDetectorName(_))
        .ifSome(anomalyDetectorDescription)(_.anomalyDetectorDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def anomalyGroup(
      startTime: Option[String] = None,
      endTime: Option[String] = None,
      anomalyGroupId: Option[String] = None,
      anomalyGroupScore: Option[Score] = None,
      primaryMetricName: Option[String] = None,
      metricLevelImpactList: Option[List[MetricLevelImpact]] = None
    ): AnomalyGroup =
      AnomalyGroup
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(anomalyGroupId)(_.anomalyGroupId(_))
        .ifSome(anomalyGroupScore)(_.anomalyGroupScore(_))
        .ifSome(primaryMetricName)(_.primaryMetricName(_))
        .ifSome(metricLevelImpactList)(_.metricLevelImpactList(_))
        .build

    def anomalyGroupStatistics(
      evaluationStartDate: Option[String] = None,
      totalCount: Option[Int] = None,
      itemizedMetricStatsList: Option[List[ItemizedMetricStats]] = None
    ): AnomalyGroupStatistics =
      AnomalyGroupStatistics
        .builder
        .ifSome(evaluationStartDate)(_.evaluationStartDate(_))
        .ifSome(totalCount)(_.totalCount(_))
        .ifSome(itemizedMetricStatsList)(_.itemizedMetricStatsList(_))
        .build

    def anomalyGroupSummary(
      startTime: Option[String] = None,
      endTime: Option[String] = None,
      anomalyGroupId: Option[String] = None,
      anomalyGroupScore: Option[Score] = None,
      primaryMetricName: Option[String] = None
    ): AnomalyGroupSummary =
      AnomalyGroupSummary
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(anomalyGroupId)(_.anomalyGroupId(_))
        .ifSome(anomalyGroupScore)(_.anomalyGroupScore(_))
        .ifSome(primaryMetricName)(_.primaryMetricName(_))
        .build

    def anomalyGroupTimeSeries(
      anomalyGroupId: Option[String] = None,
      timeSeriesId: Option[String] = None
    ): AnomalyGroupTimeSeries =
      AnomalyGroupTimeSeries
        .builder
        .ifSome(anomalyGroupId)(_.anomalyGroupId(_))
        .ifSome(timeSeriesId)(_.timeSeriesId(_))
        .build

    def anomalyGroupTimeSeriesFeedback(
      anomalyGroupId: Option[String] = None,
      timeSeriesId: Option[String] = None,
      isAnomaly: Option[Boolean] = None
    ): AnomalyGroupTimeSeriesFeedback =
      AnomalyGroupTimeSeriesFeedback
        .builder
        .ifSome(anomalyGroupId)(_.anomalyGroupId(_))
        .ifSome(timeSeriesId)(_.timeSeriesId(_))
        .ifSome(isAnomaly)(_.isAnomaly(_))
        .build

    def appFlowConfig(
      roleArn: Option[String] = None,
      flowName: Option[String] = None
    ): AppFlowConfig =
      AppFlowConfig
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(flowName)(_.flowName(_))
        .build

    def backTestAnomalyDetectorRequest(
      anomalyDetectorArn: Option[String] = None
    ): BackTestAnomalyDetectorRequest =
      BackTestAnomalyDetectorRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .build

    def backTestAnomalyDetectorResponse(

    ): BackTestAnomalyDetectorResponse =
      BackTestAnomalyDetectorResponse
        .builder

        .build

    def cloudWatchConfig(
      roleArn: Option[String] = None
    ): CloudWatchConfig =
      CloudWatchConfig
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def conflictException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def contributionMatrix(
      dimensionContributionList: Option[List[DimensionContribution]] = None
    ): ContributionMatrix =
      ContributionMatrix
        .builder
        .ifSome(dimensionContributionList)(_.dimensionContributionList(_))
        .build

    def createAlertRequest(
      alertName: Option[String] = None,
      alertSensitivityThreshold: Option[Int] = None,
      alertDescription: Option[String] = None,
      anomalyDetectorArn: Option[String] = None,
      action: Option[Action] = None,
      tags: Option[TagMap] = None
    ): CreateAlertRequest =
      CreateAlertRequest
        .builder
        .ifSome(alertName)(_.alertName(_))
        .ifSome(alertSensitivityThreshold)(_.alertSensitivityThreshold(_))
        .ifSome(alertDescription)(_.alertDescription(_))
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(action)(_.action(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAlertResponse(
      alertArn: Option[String] = None
    ): CreateAlertResponse =
      CreateAlertResponse
        .builder
        .ifSome(alertArn)(_.alertArn(_))
        .build

    def createAnomalyDetectorRequest(
      anomalyDetectorName: Option[String] = None,
      anomalyDetectorDescription: Option[String] = None,
      anomalyDetectorConfig: Option[AnomalyDetectorConfig] = None,
      kmsKeyArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateAnomalyDetectorRequest =
      CreateAnomalyDetectorRequest
        .builder
        .ifSome(anomalyDetectorName)(_.anomalyDetectorName(_))
        .ifSome(anomalyDetectorDescription)(_.anomalyDetectorDescription(_))
        .ifSome(anomalyDetectorConfig)(_.anomalyDetectorConfig(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAnomalyDetectorResponse(
      anomalyDetectorArn: Option[String] = None
    ): CreateAnomalyDetectorResponse =
      CreateAnomalyDetectorResponse
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .build

    def createMetricSetRequest(
      anomalyDetectorArn: Option[String] = None,
      metricSetName: Option[String] = None,
      metricSetDescription: Option[String] = None,
      metricList: Option[List[Metric]] = None,
      offset: Option[Int] = None,
      timestampColumn: Option[TimestampColumn] = None,
      dimensionList: Option[List[ColumnName]] = None,
      metricSetFrequency: Option[String] = None,
      metricSource: Option[MetricSource] = None,
      timezone: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateMetricSetRequest =
      CreateMetricSetRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(metricSetName)(_.metricSetName(_))
        .ifSome(metricSetDescription)(_.metricSetDescription(_))
        .ifSome(metricList)(_.metricList(_))
        .ifSome(offset)(_.offset(_))
        .ifSome(timestampColumn)(_.timestampColumn(_))
        .ifSome(dimensionList)(_.dimensionList(_))
        .ifSome(metricSetFrequency)(_.metricSetFrequency(_))
        .ifSome(metricSource)(_.metricSource(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMetricSetResponse(
      metricSetArn: Option[String] = None
    ): CreateMetricSetResponse =
      CreateMetricSetResponse
        .builder
        .ifSome(metricSetArn)(_.metricSetArn(_))
        .build

    def csvFormatDescriptor(
      fileCompression: Option[String] = None,
      charset: Option[String] = None,
      containsHeader: Option[Boolean] = None,
      delimiter: Option[String] = None,
      headerList: Option[List[ColumnName]] = None,
      quoteSymbol: Option[String] = None
    ): CsvFormatDescriptor =
      CsvFormatDescriptor
        .builder
        .ifSome(fileCompression)(_.fileCompression(_))
        .ifSome(charset)(_.charset(_))
        .ifSome(containsHeader)(_.containsHeader(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(headerList)(_.headerList(_))
        .ifSome(quoteSymbol)(_.quoteSymbol(_))
        .build

    def deleteAlertRequest(
      alertArn: Option[String] = None
    ): DeleteAlertRequest =
      DeleteAlertRequest
        .builder
        .ifSome(alertArn)(_.alertArn(_))
        .build

    def deleteAlertResponse(

    ): DeleteAlertResponse =
      DeleteAlertResponse
        .builder

        .build

    def deleteAnomalyDetectorRequest(
      anomalyDetectorArn: Option[String] = None
    ): DeleteAnomalyDetectorRequest =
      DeleteAnomalyDetectorRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .build

    def deleteAnomalyDetectorResponse(

    ): DeleteAnomalyDetectorResponse =
      DeleteAnomalyDetectorResponse
        .builder

        .build

    def describeAlertRequest(
      alertArn: Option[String] = None
    ): DescribeAlertRequest =
      DescribeAlertRequest
        .builder
        .ifSome(alertArn)(_.alertArn(_))
        .build

    def describeAlertResponse(
      alert: Option[Alert] = None
    ): DescribeAlertResponse =
      DescribeAlertResponse
        .builder
        .ifSome(alert)(_.alert(_))
        .build

    def describeAnomalyDetectionExecutionsRequest(
      anomalyDetectorArn: Option[String] = None,
      timestamp: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAnomalyDetectionExecutionsRequest =
      DescribeAnomalyDetectionExecutionsRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAnomalyDetectionExecutionsResponse(
      executionList: Option[List[ExecutionStatus]] = None,
      nextToken: Option[String] = None
    ): DescribeAnomalyDetectionExecutionsResponse =
      DescribeAnomalyDetectionExecutionsResponse
        .builder
        .ifSome(executionList)(_.executionList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAnomalyDetectorRequest(
      anomalyDetectorArn: Option[String] = None
    ): DescribeAnomalyDetectorRequest =
      DescribeAnomalyDetectorRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .build

    def describeAnomalyDetectorResponse(
      anomalyDetectorArn: Option[String] = None,
      anomalyDetectorName: Option[String] = None,
      anomalyDetectorDescription: Option[String] = None,
      anomalyDetectorConfig: Option[AnomalyDetectorConfigSummary] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): DescribeAnomalyDetectorResponse =
      DescribeAnomalyDetectorResponse
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(anomalyDetectorName)(_.anomalyDetectorName(_))
        .ifSome(anomalyDetectorDescription)(_.anomalyDetectorDescription(_))
        .ifSome(anomalyDetectorConfig)(_.anomalyDetectorConfig(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def describeMetricSetRequest(
      metricSetArn: Option[String] = None
    ): DescribeMetricSetRequest =
      DescribeMetricSetRequest
        .builder
        .ifSome(metricSetArn)(_.metricSetArn(_))
        .build

    def describeMetricSetResponse(
      metricSetArn: Option[String] = None,
      anomalyDetectorArn: Option[String] = None,
      metricSetName: Option[String] = None,
      metricSetDescription: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None,
      offset: Option[Int] = None,
      metricList: Option[List[Metric]] = None,
      timestampColumn: Option[TimestampColumn] = None,
      dimensionList: Option[List[ColumnName]] = None,
      metricSetFrequency: Option[String] = None,
      timezone: Option[String] = None,
      metricSource: Option[MetricSource] = None
    ): DescribeMetricSetResponse =
      DescribeMetricSetResponse
        .builder
        .ifSome(metricSetArn)(_.metricSetArn(_))
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(metricSetName)(_.metricSetName(_))
        .ifSome(metricSetDescription)(_.metricSetDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .ifSome(offset)(_.offset(_))
        .ifSome(metricList)(_.metricList(_))
        .ifSome(timestampColumn)(_.timestampColumn(_))
        .ifSome(dimensionList)(_.dimensionList(_))
        .ifSome(metricSetFrequency)(_.metricSetFrequency(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(metricSource)(_.metricSource(_))
        .build

    def dimensionContribution(
      dimensionName: Option[String] = None,
      dimensionValueContributionList: Option[List[DimensionValueContribution]] = None
    ): DimensionContribution =
      DimensionContribution
        .builder
        .ifSome(dimensionName)(_.dimensionName(_))
        .ifSome(dimensionValueContributionList)(_.dimensionValueContributionList(_))
        .build

    def dimensionNameValue(
      dimensionName: Option[String] = None,
      dimensionValue: Option[String] = None
    ): DimensionNameValue =
      DimensionNameValue
        .builder
        .ifSome(dimensionName)(_.dimensionName(_))
        .ifSome(dimensionValue)(_.dimensionValue(_))
        .build

    def dimensionValueContribution(
      dimensionValue: Option[String] = None,
      contributionScore: Option[Score] = None
    ): DimensionValueContribution =
      DimensionValueContribution
        .builder
        .ifSome(dimensionValue)(_.dimensionValue(_))
        .ifSome(contributionScore)(_.contributionScore(_))
        .build

    def executionStatus(
      timestamp: Option[String] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None
    ): ExecutionStatus =
      ExecutionStatus
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def fileFormatDescriptor(
      csvFormatDescriptor: Option[CsvFormatDescriptor] = None,
      jsonFormatDescriptor: Option[JsonFormatDescriptor] = None
    ): FileFormatDescriptor =
      FileFormatDescriptor
        .builder
        .ifSome(csvFormatDescriptor)(_.csvFormatDescriptor(_))
        .ifSome(jsonFormatDescriptor)(_.jsonFormatDescriptor(_))
        .build

    def getAnomalyGroupRequest(
      anomalyGroupId: Option[String] = None,
      anomalyDetectorArn: Option[String] = None
    ): GetAnomalyGroupRequest =
      GetAnomalyGroupRequest
        .builder
        .ifSome(anomalyGroupId)(_.anomalyGroupId(_))
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .build

    def getAnomalyGroupResponse(
      anomalyGroup: Option[AnomalyGroup] = None
    ): GetAnomalyGroupResponse =
      GetAnomalyGroupResponse
        .builder
        .ifSome(anomalyGroup)(_.anomalyGroup(_))
        .build

    def getFeedbackRequest(
      anomalyDetectorArn: Option[String] = None,
      anomalyGroupTimeSeriesFeedback: Option[AnomalyGroupTimeSeries] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetFeedbackRequest =
      GetFeedbackRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(anomalyGroupTimeSeriesFeedback)(_.anomalyGroupTimeSeriesFeedback(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getFeedbackResponse(
      anomalyGroupTimeSeriesFeedback: Option[List[TimeSeriesFeedback]] = None,
      nextToken: Option[String] = None
    ): GetFeedbackResponse =
      GetFeedbackResponse
        .builder
        .ifSome(anomalyGroupTimeSeriesFeedback)(_.anomalyGroupTimeSeriesFeedback(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSampleDataRequest(
      s3SourceConfig: Option[SampleDataS3SourceConfig] = None
    ): GetSampleDataRequest =
      GetSampleDataRequest
        .builder
        .ifSome(s3SourceConfig)(_.s3SourceConfig(_))
        .build

    def getSampleDataResponse(
      headerValues: Option[List[HeaderValue]] = None,
      sampleRows: Option[List[SampleRow]] = None
    ): GetSampleDataResponse =
      GetSampleDataResponse
        .builder
        .ifSome(headerValues)(_.headerValues(_))
        .ifSome(sampleRows)(_.sampleRows(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def itemizedMetricStats(
      metricName: Option[String] = None,
      occurrenceCount: Option[Int] = None
    ): ItemizedMetricStats =
      ItemizedMetricStats
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(occurrenceCount)(_.occurrenceCount(_))
        .build

    def jsonFormatDescriptor(
      fileCompression: Option[String] = None,
      charset: Option[String] = None
    ): JsonFormatDescriptor =
      JsonFormatDescriptor
        .builder
        .ifSome(fileCompression)(_.fileCompression(_))
        .ifSome(charset)(_.charset(_))
        .build

    def lambdaConfiguration(
      roleArn: Option[String] = None,
      lambdaArn: Option[String] = None
    ): LambdaConfiguration =
      LambdaConfiguration
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(lambdaArn)(_.lambdaArn(_))
        .build

    def listAlertsRequest(
      anomalyDetectorArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAlertsRequest =
      ListAlertsRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAlertsResponse(
      alertSummaryList: Option[List[AlertSummary]] = None,
      nextToken: Option[String] = None
    ): ListAlertsResponse =
      ListAlertsResponse
        .builder
        .ifSome(alertSummaryList)(_.alertSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnomalyDetectorsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAnomalyDetectorsRequest =
      ListAnomalyDetectorsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnomalyDetectorsResponse(
      anomalyDetectorSummaryList: Option[List[AnomalyDetectorSummary]] = None,
      nextToken: Option[String] = None
    ): ListAnomalyDetectorsResponse =
      ListAnomalyDetectorsResponse
        .builder
        .ifSome(anomalyDetectorSummaryList)(_.anomalyDetectorSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnomalyGroupSummariesRequest(
      anomalyDetectorArn: Option[String] = None,
      sensitivityThreshold: Option[Int] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAnomalyGroupSummariesRequest =
      ListAnomalyGroupSummariesRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(sensitivityThreshold)(_.sensitivityThreshold(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnomalyGroupSummariesResponse(
      anomalyGroupSummaryList: Option[List[AnomalyGroupSummary]] = None,
      anomalyGroupStatistics: Option[AnomalyGroupStatistics] = None,
      nextToken: Option[String] = None
    ): ListAnomalyGroupSummariesResponse =
      ListAnomalyGroupSummariesResponse
        .builder
        .ifSome(anomalyGroupSummaryList)(_.anomalyGroupSummaryList(_))
        .ifSome(anomalyGroupStatistics)(_.anomalyGroupStatistics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnomalyGroupTimeSeriesRequest(
      anomalyDetectorArn: Option[String] = None,
      anomalyGroupId: Option[String] = None,
      metricName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAnomalyGroupTimeSeriesRequest =
      ListAnomalyGroupTimeSeriesRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(anomalyGroupId)(_.anomalyGroupId(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnomalyGroupTimeSeriesResponse(
      anomalyGroupId: Option[String] = None,
      metricName: Option[String] = None,
      timestampList: Option[List[TimestampString]] = None,
      nextToken: Option[String] = None,
      timeSeriesList: Option[List[TimeSeries]] = None
    ): ListAnomalyGroupTimeSeriesResponse =
      ListAnomalyGroupTimeSeriesResponse
        .builder
        .ifSome(anomalyGroupId)(_.anomalyGroupId(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(timestampList)(_.timestampList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(timeSeriesList)(_.timeSeriesList(_))
        .build

    def listMetricSetsRequest(
      anomalyDetectorArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMetricSetsRequest =
      ListMetricSetsRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMetricSetsResponse(
      metricSetSummaryList: Option[List[MetricSetSummary]] = None,
      nextToken: Option[String] = None
    ): ListMetricSetsResponse =
      ListMetricSetsResponse
        .builder
        .ifSome(metricSetSummaryList)(_.metricSetSummaryList(_))
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
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def metric(
      metricName: Option[String] = None,
      aggregationFunction: Option[String] = None,
      namespace: Option[String] = None
    ): Metric =
      Metric
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(aggregationFunction)(_.aggregationFunction(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def metricLevelImpact(
      metricName: Option[String] = None,
      numTimeSeries: Option[Int] = None,
      contributionMatrix: Option[ContributionMatrix] = None
    ): MetricLevelImpact =
      MetricLevelImpact
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(numTimeSeries)(_.numTimeSeries(_))
        .ifSome(contributionMatrix)(_.contributionMatrix(_))
        .build

    def metricSetSummary(
      metricSetArn: Option[String] = None,
      anomalyDetectorArn: Option[String] = None,
      metricSetDescription: Option[String] = None,
      metricSetName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None,
      tags: Option[TagMap] = None
    ): MetricSetSummary =
      MetricSetSummary
        .builder
        .ifSome(metricSetArn)(_.metricSetArn(_))
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(metricSetDescription)(_.metricSetDescription(_))
        .ifSome(metricSetName)(_.metricSetName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def metricSource(
      s3SourceConfig: Option[S3SourceConfig] = None,
      appFlowConfig: Option[AppFlowConfig] = None,
      cloudWatchConfig: Option[CloudWatchConfig] = None,
      rDSSourceConfig: Option[RDSSourceConfig] = None,
      redshiftSourceConfig: Option[RedshiftSourceConfig] = None
    ): MetricSource =
      MetricSource
        .builder
        .ifSome(s3SourceConfig)(_.s3SourceConfig(_))
        .ifSome(appFlowConfig)(_.appFlowConfig(_))
        .ifSome(cloudWatchConfig)(_.cloudWatchConfig(_))
        .ifSome(rDSSourceConfig)(_.rDSSourceConfig(_))
        .ifSome(redshiftSourceConfig)(_.redshiftSourceConfig(_))
        .build

    def putFeedbackRequest(
      anomalyDetectorArn: Option[String] = None,
      anomalyGroupTimeSeriesFeedback: Option[AnomalyGroupTimeSeriesFeedback] = None
    ): PutFeedbackRequest =
      PutFeedbackRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(anomalyGroupTimeSeriesFeedback)(_.anomalyGroupTimeSeriesFeedback(_))
        .build

    def putFeedbackResponse(

    ): PutFeedbackResponse =
      PutFeedbackResponse
        .builder

        .build

    def rDSSourceConfig(
      dBInstanceIdentifier: Option[String] = None,
      databaseHost: Option[String] = None,
      databasePort: Option[Int] = None,
      secretManagerArn: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      roleArn: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None
    ): RDSSourceConfig =
      RDSSourceConfig
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(databaseHost)(_.databaseHost(_))
        .ifSome(databasePort)(_.databasePort(_))
        .ifSome(secretManagerArn)(_.secretManagerArn(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .build

    def redshiftSourceConfig(
      clusterIdentifier: Option[String] = None,
      databaseHost: Option[String] = None,
      databasePort: Option[Int] = None,
      secretManagerArn: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      roleArn: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None
    ): RedshiftSourceConfig =
      RedshiftSourceConfig
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(databaseHost)(_.databaseHost(_))
        .ifSome(databasePort)(_.databasePort(_))
        .ifSome(secretManagerArn)(_.secretManagerArn(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def s3SourceConfig(
      roleArn: Option[String] = None,
      templatedPathList: Option[List[TemplatedPath]] = None,
      historicalDataPathList: Option[List[HistoricalDataPath]] = None,
      fileFormatDescriptor: Option[FileFormatDescriptor] = None
    ): S3SourceConfig =
      S3SourceConfig
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(templatedPathList)(_.templatedPathList(_))
        .ifSome(historicalDataPathList)(_.historicalDataPathList(_))
        .ifSome(fileFormatDescriptor)(_.fileFormatDescriptor(_))
        .build

    def sNSConfiguration(
      roleArn: Option[String] = None,
      snsTopicArn: Option[String] = None
    ): SNSConfiguration =
      SNSConfiguration
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .build

    def sampleDataS3SourceConfig(
      roleArn: Option[String] = None,
      templatedPathList: Option[List[TemplatedPath]] = None,
      historicalDataPathList: Option[List[HistoricalDataPath]] = None,
      fileFormatDescriptor: Option[FileFormatDescriptor] = None
    ): SampleDataS3SourceConfig =
      SampleDataS3SourceConfig
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(templatedPathList)(_.templatedPathList(_))
        .ifSome(historicalDataPathList)(_.historicalDataPathList(_))
        .ifSome(fileFormatDescriptor)(_.fileFormatDescriptor(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
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

    def timeSeries(
      timeSeriesId: Option[String] = None,
      dimensionList: Option[List[DimensionNameValue]] = None,
      metricValueList: Option[List[MetricValue]] = None
    ): TimeSeries =
      TimeSeries
        .builder
        .ifSome(timeSeriesId)(_.timeSeriesId(_))
        .ifSome(dimensionList)(_.dimensionList(_))
        .ifSome(metricValueList)(_.metricValueList(_))
        .build

    def timeSeriesFeedback(
      timeSeriesId: Option[String] = None,
      isAnomaly: Option[Boolean] = None
    ): TimeSeriesFeedback =
      TimeSeriesFeedback
        .builder
        .ifSome(timeSeriesId)(_.timeSeriesId(_))
        .ifSome(isAnomaly)(_.isAnomaly(_))
        .build

    def timestampColumn(
      columnName: Option[String] = None,
      columnFormat: Option[String] = None
    ): TimestampColumn =
      TimestampColumn
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(columnFormat)(_.columnFormat(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
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

    def updateAnomalyDetectorRequest(
      anomalyDetectorArn: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      anomalyDetectorDescription: Option[String] = None,
      anomalyDetectorConfig: Option[AnomalyDetectorConfig] = None
    ): UpdateAnomalyDetectorRequest =
      UpdateAnomalyDetectorRequest
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(anomalyDetectorDescription)(_.anomalyDetectorDescription(_))
        .ifSome(anomalyDetectorConfig)(_.anomalyDetectorConfig(_))
        .build

    def updateAnomalyDetectorResponse(
      anomalyDetectorArn: Option[String] = None
    ): UpdateAnomalyDetectorResponse =
      UpdateAnomalyDetectorResponse
        .builder
        .ifSome(anomalyDetectorArn)(_.anomalyDetectorArn(_))
        .build

    def updateMetricSetRequest(
      metricSetArn: Option[String] = None,
      metricSetDescription: Option[String] = None,
      metricList: Option[List[Metric]] = None,
      offset: Option[Int] = None,
      timestampColumn: Option[TimestampColumn] = None,
      dimensionList: Option[List[ColumnName]] = None,
      metricSetFrequency: Option[String] = None,
      metricSource: Option[MetricSource] = None
    ): UpdateMetricSetRequest =
      UpdateMetricSetRequest
        .builder
        .ifSome(metricSetArn)(_.metricSetArn(_))
        .ifSome(metricSetDescription)(_.metricSetDescription(_))
        .ifSome(metricList)(_.metricList(_))
        .ifSome(offset)(_.offset(_))
        .ifSome(timestampColumn)(_.timestampColumn(_))
        .ifSome(dimensionList)(_.dimensionList(_))
        .ifSome(metricSetFrequency)(_.metricSetFrequency(_))
        .ifSome(metricSource)(_.metricSource(_))
        .build

    def updateMetricSetResponse(
      metricSetArn: Option[String] = None
    ): UpdateMetricSetResponse =
      UpdateMetricSetResponse
        .builder
        .ifSome(metricSetArn)(_.metricSetArn(_))
        .build

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None,
      fields: Option[List[ValidationExceptionField]] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(fields)(_.fields(_))
        .build

    def validationExceptionField(
      name: Option[String] = None,
      message: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(message)(_.message(_))
        .build

    def vpcConfiguration(
      subnetIdList: Option[List[SubnetId]] = None,
      securityGroupIdList: Option[List[SecurityGroupId]] = None
    ): VpcConfiguration =
      VpcConfiguration
        .builder
        .ifSome(subnetIdList)(_.subnetIdList(_))
        .ifSome(securityGroupIdList)(_.securityGroupIdList(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
