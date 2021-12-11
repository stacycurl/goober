package goober.hi

import goober.free.xray.XRayIO
import software.amazon.awssdk.services.xray.model._


object xray {
  import goober.free.{xray ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def alias(
      name: Option[String] = None,
      names: Option[List[String]] = None,
      `type`: Option[String] = None
    ): Alias =
      Alias
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(names)(_.names(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def annotationValue(
      numberValue: Option[NullableDouble] = None,
      booleanValue: Option[Boolean] = None,
      stringValue: Option[String] = None
    ): AnnotationValue =
      AnnotationValue
        .builder
        .ifSome(numberValue)(_.numberValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .ifSome(stringValue)(_.stringValue(_))
        .build

    def anomalousService(
      serviceId: Option[ServiceId] = None
    ): AnomalousService =
      AnomalousService
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .build

    def availabilityZoneDetail(
      name: Option[String] = None
    ): AvailabilityZoneDetail =
      AvailabilityZoneDetail
        .builder
        .ifSome(name)(_.name(_))
        .build

    def backendConnectionErrors(
      timeoutCount: Option[Int] = None,
      connectionRefusedCount: Option[Int] = None,
      hTTPCode4XXCount: Option[Int] = None,
      hTTPCode5XXCount: Option[Int] = None,
      unknownHostCount: Option[Int] = None,
      otherCount: Option[Int] = None
    ): BackendConnectionErrors =
      BackendConnectionErrors
        .builder
        .ifSome(timeoutCount)(_.timeoutCount(_))
        .ifSome(connectionRefusedCount)(_.connectionRefusedCount(_))
        .ifSome(hTTPCode4XXCount)(_.hTTPCode4XXCount(_))
        .ifSome(hTTPCode5XXCount)(_.hTTPCode5XXCount(_))
        .ifSome(unknownHostCount)(_.unknownHostCount(_))
        .ifSome(otherCount)(_.otherCount(_))
        .build

    def batchGetTracesRequest(
      traceIds: Option[List[TraceId]] = None,
      nextToken: Option[String] = None
    ): BatchGetTracesRequest =
      BatchGetTracesRequest
        .builder
        .ifSome(traceIds)(_.traceIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def createGroupRequest(
      groupName: Option[String] = None,
      filterExpression: Option[String] = None,
      insightsConfiguration: Option[InsightsConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): CreateGroupRequest =
      CreateGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(insightsConfiguration)(_.insightsConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSamplingRuleRequest(
      samplingRule: Option[SamplingRule] = None,
      tags: Option[List[Tag]] = None
    ): CreateSamplingRuleRequest =
      CreateSamplingRuleRequest
        .builder
        .ifSome(samplingRule)(_.samplingRule(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteGroupRequest(
      groupName: Option[String] = None,
      groupARN: Option[String] = None
    ): DeleteGroupRequest =
      DeleteGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupARN)(_.groupARN(_))
        .build

    def deleteSamplingRuleRequest(
      ruleName: Option[String] = None,
      ruleARN: Option[String] = None
    ): DeleteSamplingRuleRequest =
      DeleteSamplingRuleRequest
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(ruleARN)(_.ruleARN(_))
        .build

    def edge(
      referenceId: Option[Int] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      summaryStatistics: Option[EdgeStatistics] = None,
      responseTimeHistogram: Option[List[HistogramEntry]] = None,
      aliases: Option[List[Alias]] = None
    ): Edge =
      Edge
        .builder
        .ifSome(referenceId)(_.referenceId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(summaryStatistics)(_.summaryStatistics(_))
        .ifSome(responseTimeHistogram)(_.responseTimeHistogram(_))
        .ifSome(aliases)(_.aliases(_))
        .build

    def edgeStatistics(
      okCount: Option[NullableLong] = None,
      errorStatistics: Option[ErrorStatistics] = None,
      faultStatistics: Option[FaultStatistics] = None,
      totalCount: Option[NullableLong] = None,
      totalResponseTime: Option[NullableDouble] = None
    ): EdgeStatistics =
      EdgeStatistics
        .builder
        .ifSome(okCount)(_.okCount(_))
        .ifSome(errorStatistics)(_.errorStatistics(_))
        .ifSome(faultStatistics)(_.faultStatistics(_))
        .ifSome(totalCount)(_.totalCount(_))
        .ifSome(totalResponseTime)(_.totalResponseTime(_))
        .build

    def encryptionConfig(
      keyId: Option[String] = None,
      status: Option[String] = None,
      `type`: Option[String] = None
    ): EncryptionConfig =
      EncryptionConfig
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(status)(_.status(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def errorRootCause(
      services: Option[List[ErrorRootCauseService]] = None,
      clientImpacting: Option[Boolean] = None
    ): ErrorRootCause =
      ErrorRootCause
        .builder
        .ifSome(services)(_.services(_))
        .ifSome(clientImpacting)(_.clientImpacting(_))
        .build

    def errorRootCauseEntity(
      name: Option[String] = None,
      exceptions: Option[List[RootCauseException]] = None,
      remote: Option[Boolean] = None
    ): ErrorRootCauseEntity =
      ErrorRootCauseEntity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(exceptions)(_.exceptions(_))
        .ifSome(remote)(_.remote(_))
        .build

    def errorRootCauseService(
      name: Option[String] = None,
      names: Option[List[String]] = None,
      `type`: Option[String] = None,
      accountId: Option[String] = None,
      entityPath: Option[List[ErrorRootCauseEntity]] = None,
      inferred: Option[Boolean] = None
    ): ErrorRootCauseService =
      ErrorRootCauseService
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(names)(_.names(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(entityPath)(_.entityPath(_))
        .ifSome(inferred)(_.inferred(_))
        .build

    def errorStatistics(
      throttleCount: Option[NullableLong] = None,
      otherCount: Option[NullableLong] = None,
      totalCount: Option[NullableLong] = None
    ): ErrorStatistics =
      ErrorStatistics
        .builder
        .ifSome(throttleCount)(_.throttleCount(_))
        .ifSome(otherCount)(_.otherCount(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def faultRootCause(
      services: Option[List[FaultRootCauseService]] = None,
      clientImpacting: Option[Boolean] = None
    ): FaultRootCause =
      FaultRootCause
        .builder
        .ifSome(services)(_.services(_))
        .ifSome(clientImpacting)(_.clientImpacting(_))
        .build

    def faultRootCauseEntity(
      name: Option[String] = None,
      exceptions: Option[List[RootCauseException]] = None,
      remote: Option[Boolean] = None
    ): FaultRootCauseEntity =
      FaultRootCauseEntity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(exceptions)(_.exceptions(_))
        .ifSome(remote)(_.remote(_))
        .build

    def faultRootCauseService(
      name: Option[String] = None,
      names: Option[List[String]] = None,
      `type`: Option[String] = None,
      accountId: Option[String] = None,
      entityPath: Option[List[FaultRootCauseEntity]] = None,
      inferred: Option[Boolean] = None
    ): FaultRootCauseService =
      FaultRootCauseService
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(names)(_.names(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(entityPath)(_.entityPath(_))
        .ifSome(inferred)(_.inferred(_))
        .build

    def faultStatistics(
      otherCount: Option[NullableLong] = None,
      totalCount: Option[NullableLong] = None
    ): FaultStatistics =
      FaultStatistics
        .builder
        .ifSome(otherCount)(_.otherCount(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def forecastStatistics(
      faultCountHigh: Option[NullableLong] = None,
      faultCountLow: Option[NullableLong] = None
    ): ForecastStatistics =
      ForecastStatistics
        .builder
        .ifSome(faultCountHigh)(_.faultCountHigh(_))
        .ifSome(faultCountLow)(_.faultCountLow(_))
        .build

    def getEncryptionConfigRequest(

    ): GetEncryptionConfigRequest =
      GetEncryptionConfigRequest
        .builder

        .build

    def getGroupRequest(
      groupName: Option[String] = None,
      groupARN: Option[String] = None
    ): GetGroupRequest =
      GetGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupARN)(_.groupARN(_))
        .build

    def getGroupsRequest(
      nextToken: Option[String] = None
    ): GetGroupsRequest =
      GetGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getInsightEventsRequest(
      insightId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetInsightEventsRequest =
      GetInsightEventsRequest
        .builder
        .ifSome(insightId)(_.insightId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getInsightImpactGraphRequest(
      insightId: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      nextToken: Option[String] = None
    ): GetInsightImpactGraphRequest =
      GetInsightImpactGraphRequest
        .builder
        .ifSome(insightId)(_.insightId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getInsightRequest(
      insightId: Option[String] = None
    ): GetInsightRequest =
      GetInsightRequest
        .builder
        .ifSome(insightId)(_.insightId(_))
        .build

    def getInsightSummariesRequest(
      states: Option[List[InsightState]] = None,
      groupARN: Option[String] = None,
      groupName: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetInsightSummariesRequest =
      GetInsightSummariesRequest
        .builder
        .ifSome(states)(_.states(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSamplingRulesRequest(
      nextToken: Option[String] = None
    ): GetSamplingRulesRequest =
      GetSamplingRulesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSamplingStatisticSummariesRequest(
      nextToken: Option[String] = None
    ): GetSamplingStatisticSummariesRequest =
      GetSamplingStatisticSummariesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSamplingTargetsRequest(
      samplingStatisticsDocuments: Option[List[SamplingStatisticsDocument]] = None
    ): GetSamplingTargetsRequest =
      GetSamplingTargetsRequest
        .builder
        .ifSome(samplingStatisticsDocuments)(_.samplingStatisticsDocuments(_))
        .build

    def getServiceGraphRequest(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      groupName: Option[String] = None,
      groupARN: Option[String] = None,
      nextToken: Option[String] = None
    ): GetServiceGraphRequest =
      GetServiceGraphRequest
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTimeSeriesServiceStatisticsRequest(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      groupName: Option[String] = None,
      groupARN: Option[String] = None,
      entitySelectorExpression: Option[String] = None,
      period: Option[Int] = None,
      forecastStatistics: Option[Boolean] = None,
      nextToken: Option[String] = None
    ): GetTimeSeriesServiceStatisticsRequest =
      GetTimeSeriesServiceStatisticsRequest
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(entitySelectorExpression)(_.entitySelectorExpression(_))
        .ifSome(period)(_.period(_))
        .ifSome(forecastStatistics)(_.forecastStatistics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTraceGraphRequest(
      traceIds: Option[List[TraceId]] = None,
      nextToken: Option[String] = None
    ): GetTraceGraphRequest =
      GetTraceGraphRequest
        .builder
        .ifSome(traceIds)(_.traceIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTraceSummariesRequest(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      timeRangeType: Option[String] = None,
      sampling: Option[Boolean] = None,
      samplingStrategy: Option[SamplingStrategy] = None,
      filterExpression: Option[String] = None,
      nextToken: Option[String] = None
    ): GetTraceSummariesRequest =
      GetTraceSummariesRequest
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(timeRangeType)(_.timeRangeType(_))
        .ifSome(sampling)(_.sampling(_))
        .ifSome(samplingStrategy)(_.samplingStrategy(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def group(
      groupName: Option[String] = None,
      groupARN: Option[String] = None,
      filterExpression: Option[String] = None,
      insightsConfiguration: Option[InsightsConfiguration] = None
    ): Group =
      Group
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(insightsConfiguration)(_.insightsConfiguration(_))
        .build

    def groupSummary(
      groupName: Option[String] = None,
      groupARN: Option[String] = None,
      filterExpression: Option[String] = None,
      insightsConfiguration: Option[InsightsConfiguration] = None
    ): GroupSummary =
      GroupSummary
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(insightsConfiguration)(_.insightsConfiguration(_))
        .build

    def histogramEntry(
      value: Option[Double] = None,
      count: Option[Int] = None
    ): HistogramEntry =
      HistogramEntry
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(count)(_.count(_))
        .build

    def http(
      httpURL: Option[String] = None,
      httpStatus: Option[Int] = None,
      httpMethod: Option[String] = None,
      userAgent: Option[String] = None,
      clientIp: Option[String] = None
    ): Http =
      Http
        .builder
        .ifSome(httpURL)(_.httpURL(_))
        .ifSome(httpStatus)(_.httpStatus(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(userAgent)(_.userAgent(_))
        .ifSome(clientIp)(_.clientIp(_))
        .build

    def insight(
      insightId: Option[String] = None,
      groupARN: Option[String] = None,
      groupName: Option[String] = None,
      rootCauseServiceId: Option[ServiceId] = None,
      categories: Option[List[InsightCategory]] = None,
      state: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      summary: Option[String] = None,
      clientRequestImpactStatistics: Option[RequestImpactStatistics] = None,
      rootCauseServiceRequestImpactStatistics: Option[RequestImpactStatistics] = None,
      topAnomalousServices: Option[List[AnomalousService]] = None
    ): Insight =
      Insight
        .builder
        .ifSome(insightId)(_.insightId(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(rootCauseServiceId)(_.rootCauseServiceId(_))
        .ifSome(categories)(_.categories(_))
        .ifSome(state)(_.state(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(clientRequestImpactStatistics)(_.clientRequestImpactStatistics(_))
        .ifSome(rootCauseServiceRequestImpactStatistics)(_.rootCauseServiceRequestImpactStatistics(_))
        .ifSome(topAnomalousServices)(_.topAnomalousServices(_))
        .build

    def insightEvent(
      summary: Option[String] = None,
      eventTime: Option[Timestamp] = None,
      clientRequestImpactStatistics: Option[RequestImpactStatistics] = None,
      rootCauseServiceRequestImpactStatistics: Option[RequestImpactStatistics] = None,
      topAnomalousServices: Option[List[AnomalousService]] = None
    ): InsightEvent =
      InsightEvent
        .builder
        .ifSome(summary)(_.summary(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(clientRequestImpactStatistics)(_.clientRequestImpactStatistics(_))
        .ifSome(rootCauseServiceRequestImpactStatistics)(_.rootCauseServiceRequestImpactStatistics(_))
        .ifSome(topAnomalousServices)(_.topAnomalousServices(_))
        .build

    def insightImpactGraphEdge(
      referenceId: Option[Int] = None
    ): InsightImpactGraphEdge =
      InsightImpactGraphEdge
        .builder
        .ifSome(referenceId)(_.referenceId(_))
        .build

    def insightImpactGraphService(
      referenceId: Option[Int] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      names: Option[List[String]] = None,
      accountId: Option[String] = None,
      edges: Option[List[InsightImpactGraphEdge]] = None
    ): InsightImpactGraphService =
      InsightImpactGraphService
        .builder
        .ifSome(referenceId)(_.referenceId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(names)(_.names(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(edges)(_.edges(_))
        .build

    def insightSummary(
      insightId: Option[String] = None,
      groupARN: Option[String] = None,
      groupName: Option[String] = None,
      rootCauseServiceId: Option[ServiceId] = None,
      categories: Option[List[InsightCategory]] = None,
      state: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      summary: Option[String] = None,
      clientRequestImpactStatistics: Option[RequestImpactStatistics] = None,
      rootCauseServiceRequestImpactStatistics: Option[RequestImpactStatistics] = None,
      topAnomalousServices: Option[List[AnomalousService]] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): InsightSummary =
      InsightSummary
        .builder
        .ifSome(insightId)(_.insightId(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(rootCauseServiceId)(_.rootCauseServiceId(_))
        .ifSome(categories)(_.categories(_))
        .ifSome(state)(_.state(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(clientRequestImpactStatistics)(_.clientRequestImpactStatistics(_))
        .ifSome(rootCauseServiceRequestImpactStatistics)(_.rootCauseServiceRequestImpactStatistics(_))
        .ifSome(topAnomalousServices)(_.topAnomalousServices(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def insightsConfiguration(
      insightsEnabled: Option[Boolean] = None,
      notificationsEnabled: Option[Boolean] = None
    ): InsightsConfiguration =
      InsightsConfiguration
        .builder
        .ifSome(insightsEnabled)(_.insightsEnabled(_))
        .ifSome(notificationsEnabled)(_.notificationsEnabled(_))
        .build

    def instanceIdDetail(
      id: Option[String] = None
    ): InstanceIdDetail =
      InstanceIdDetail
        .builder
        .ifSome(id)(_.id(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def putEncryptionConfigRequest(
      keyId: Option[String] = None,
      `type`: Option[String] = None
    ): PutEncryptionConfigRequest =
      PutEncryptionConfigRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def putTelemetryRecordsRequest(
      telemetryRecords: Option[List[TelemetryRecord]] = None,
      eC2InstanceId: Option[String] = None,
      hostname: Option[String] = None,
      resourceARN: Option[String] = None
    ): PutTelemetryRecordsRequest =
      PutTelemetryRecordsRequest
        .builder
        .ifSome(telemetryRecords)(_.telemetryRecords(_))
        .ifSome(eC2InstanceId)(_.eC2InstanceId(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def putTraceSegmentsRequest(
      traceSegmentDocuments: Option[List[TraceSegmentDocument]] = None
    ): PutTraceSegmentsRequest =
      PutTraceSegmentsRequest
        .builder
        .ifSome(traceSegmentDocuments)(_.traceSegmentDocuments(_))
        .build

    def requestImpactStatistics(
      faultCount: Option[NullableLong] = None,
      okCount: Option[NullableLong] = None,
      totalCount: Option[NullableLong] = None
    ): RequestImpactStatistics =
      RequestImpactStatistics
        .builder
        .ifSome(faultCount)(_.faultCount(_))
        .ifSome(okCount)(_.okCount(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def resourceARNDetail(
      aRN: Option[String] = None
    ): ResourceARNDetail =
      ResourceARNDetail
        .builder
        .ifSome(aRN)(_.aRN(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def responseTimeRootCause(
      services: Option[List[ResponseTimeRootCauseService]] = None,
      clientImpacting: Option[Boolean] = None
    ): ResponseTimeRootCause =
      ResponseTimeRootCause
        .builder
        .ifSome(services)(_.services(_))
        .ifSome(clientImpacting)(_.clientImpacting(_))
        .build

    def responseTimeRootCauseEntity(
      name: Option[String] = None,
      coverage: Option[NullableDouble] = None,
      remote: Option[Boolean] = None
    ): ResponseTimeRootCauseEntity =
      ResponseTimeRootCauseEntity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(coverage)(_.coverage(_))
        .ifSome(remote)(_.remote(_))
        .build

    def responseTimeRootCauseService(
      name: Option[String] = None,
      names: Option[List[String]] = None,
      `type`: Option[String] = None,
      accountId: Option[String] = None,
      entityPath: Option[List[ResponseTimeRootCauseEntity]] = None,
      inferred: Option[Boolean] = None
    ): ResponseTimeRootCauseService =
      ResponseTimeRootCauseService
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(names)(_.names(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(entityPath)(_.entityPath(_))
        .ifSome(inferred)(_.inferred(_))
        .build

    def rootCauseException(
      name: Option[String] = None,
      message: Option[String] = None
    ): RootCauseException =
      RootCauseException
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(message)(_.message(_))
        .build

    def ruleLimitExceededException(
      message: Option[String] = None
    ): RuleLimitExceededException =
      RuleLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def samplingRule(
      ruleName: Option[String] = None,
      ruleARN: Option[String] = None,
      resourceARN: Option[String] = None,
      priority: Option[Int] = None,
      fixedRate: Option[FixedRate] = None,
      reservoirSize: Option[Int] = None,
      serviceName: Option[String] = None,
      serviceType: Option[String] = None,
      host: Option[String] = None,
      hTTPMethod: Option[String] = None,
      uRLPath: Option[String] = None,
      version: Option[Int] = None,
      attributes: Option[AttributeMap] = None
    ): SamplingRule =
      SamplingRule
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(ruleARN)(_.ruleARN(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(fixedRate)(_.fixedRate(_))
        .ifSome(reservoirSize)(_.reservoirSize(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(host)(_.host(_))
        .ifSome(hTTPMethod)(_.hTTPMethod(_))
        .ifSome(uRLPath)(_.uRLPath(_))
        .ifSome(version)(_.version(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def samplingRuleRecord(
      samplingRule: Option[SamplingRule] = None,
      createdAt: Option[Timestamp] = None,
      modifiedAt: Option[Timestamp] = None
    ): SamplingRuleRecord =
      SamplingRuleRecord
        .builder
        .ifSome(samplingRule)(_.samplingRule(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(modifiedAt)(_.modifiedAt(_))
        .build

    def samplingRuleUpdate(
      ruleName: Option[String] = None,
      ruleARN: Option[String] = None,
      resourceARN: Option[String] = None,
      priority: Option[Int] = None,
      fixedRate: Option[NullableDouble] = None,
      reservoirSize: Option[Int] = None,
      host: Option[String] = None,
      serviceName: Option[String] = None,
      serviceType: Option[String] = None,
      hTTPMethod: Option[String] = None,
      uRLPath: Option[String] = None,
      attributes: Option[AttributeMap] = None
    ): SamplingRuleUpdate =
      SamplingRuleUpdate
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(ruleARN)(_.ruleARN(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(fixedRate)(_.fixedRate(_))
        .ifSome(reservoirSize)(_.reservoirSize(_))
        .ifSome(host)(_.host(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(hTTPMethod)(_.hTTPMethod(_))
        .ifSome(uRLPath)(_.uRLPath(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def samplingStatisticSummary(
      ruleName: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      requestCount: Option[Int] = None,
      borrowCount: Option[Int] = None,
      sampledCount: Option[Int] = None
    ): SamplingStatisticSummary =
      SamplingStatisticSummary
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(requestCount)(_.requestCount(_))
        .ifSome(borrowCount)(_.borrowCount(_))
        .ifSome(sampledCount)(_.sampledCount(_))
        .build

    def samplingStatisticsDocument(
      ruleName: Option[String] = None,
      clientID: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      requestCount: Option[Int] = None,
      sampledCount: Option[Int] = None,
      borrowCount: Option[Int] = None
    ): SamplingStatisticsDocument =
      SamplingStatisticsDocument
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(clientID)(_.clientID(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(requestCount)(_.requestCount(_))
        .ifSome(sampledCount)(_.sampledCount(_))
        .ifSome(borrowCount)(_.borrowCount(_))
        .build

    def samplingStrategy(
      name: Option[String] = None,
      value: Option[NullableDouble] = None
    ): SamplingStrategy =
      SamplingStrategy
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def samplingTargetDocument(
      ruleName: Option[String] = None,
      fixedRate: Option[Double] = None,
      reservoirQuota: Option[Int] = None,
      reservoirQuotaTTL: Option[Timestamp] = None,
      interval: Option[Int] = None
    ): SamplingTargetDocument =
      SamplingTargetDocument
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(fixedRate)(_.fixedRate(_))
        .ifSome(reservoirQuota)(_.reservoirQuota(_))
        .ifSome(reservoirQuotaTTL)(_.reservoirQuotaTTL(_))
        .ifSome(interval)(_.interval(_))
        .build

    def segment(
      id: Option[String] = None,
      document: Option[String] = None
    ): Segment =
      Segment
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(document)(_.document(_))
        .build

    def service(
      referenceId: Option[Int] = None,
      name: Option[String] = None,
      names: Option[List[String]] = None,
      root: Option[Boolean] = None,
      accountId: Option[String] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      edges: Option[List[Edge]] = None,
      summaryStatistics: Option[ServiceStatistics] = None,
      durationHistogram: Option[List[HistogramEntry]] = None,
      responseTimeHistogram: Option[List[HistogramEntry]] = None
    ): Service =
      Service
        .builder
        .ifSome(referenceId)(_.referenceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(names)(_.names(_))
        .ifSome(root)(_.root(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(edges)(_.edges(_))
        .ifSome(summaryStatistics)(_.summaryStatistics(_))
        .ifSome(durationHistogram)(_.durationHistogram(_))
        .ifSome(responseTimeHistogram)(_.responseTimeHistogram(_))
        .build

    def serviceId(
      name: Option[String] = None,
      names: Option[List[String]] = None,
      accountId: Option[String] = None,
      `type`: Option[String] = None
    ): ServiceId =
      ServiceId
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(names)(_.names(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def serviceStatistics(
      okCount: Option[NullableLong] = None,
      errorStatistics: Option[ErrorStatistics] = None,
      faultStatistics: Option[FaultStatistics] = None,
      totalCount: Option[NullableLong] = None,
      totalResponseTime: Option[NullableDouble] = None
    ): ServiceStatistics =
      ServiceStatistics
        .builder
        .ifSome(okCount)(_.okCount(_))
        .ifSome(errorStatistics)(_.errorStatistics(_))
        .ifSome(faultStatistics)(_.faultStatistics(_))
        .ifSome(totalCount)(_.totalCount(_))
        .ifSome(totalResponseTime)(_.totalResponseTime(_))
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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def telemetryRecord(
      timestamp: Option[Timestamp] = None,
      segmentsReceivedCount: Option[Int] = None,
      segmentsSentCount: Option[Int] = None,
      segmentsSpilloverCount: Option[Int] = None,
      segmentsRejectedCount: Option[Int] = None,
      backendConnectionErrors: Option[BackendConnectionErrors] = None
    ): TelemetryRecord =
      TelemetryRecord
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(segmentsReceivedCount)(_.segmentsReceivedCount(_))
        .ifSome(segmentsSentCount)(_.segmentsSentCount(_))
        .ifSome(segmentsSpilloverCount)(_.segmentsSpilloverCount(_))
        .ifSome(segmentsRejectedCount)(_.segmentsRejectedCount(_))
        .ifSome(backendConnectionErrors)(_.backendConnectionErrors(_))
        .build

    def throttledException(
      message: Option[String] = None
    ): ThrottledException =
      ThrottledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timeSeriesServiceStatistics(
      timestamp: Option[Timestamp] = None,
      edgeSummaryStatistics: Option[EdgeStatistics] = None,
      serviceSummaryStatistics: Option[ServiceStatistics] = None,
      serviceForecastStatistics: Option[ForecastStatistics] = None,
      responseTimeHistogram: Option[List[HistogramEntry]] = None
    ): TimeSeriesServiceStatistics =
      TimeSeriesServiceStatistics
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(edgeSummaryStatistics)(_.edgeSummaryStatistics(_))
        .ifSome(serviceSummaryStatistics)(_.serviceSummaryStatistics(_))
        .ifSome(serviceForecastStatistics)(_.serviceForecastStatistics(_))
        .ifSome(responseTimeHistogram)(_.responseTimeHistogram(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def trace(
      id: Option[String] = None,
      duration: Option[NullableDouble] = None,
      limitExceeded: Option[Boolean] = None,
      segments: Option[List[Segment]] = None
    ): Trace =
      Trace
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(limitExceeded)(_.limitExceeded(_))
        .ifSome(segments)(_.segments(_))
        .build

    def traceSummary(
      id: Option[String] = None,
      duration: Option[NullableDouble] = None,
      responseTime: Option[NullableDouble] = None,
      hasFault: Option[Boolean] = None,
      hasError: Option[Boolean] = None,
      hasThrottle: Option[Boolean] = None,
      isPartial: Option[Boolean] = None,
      http: Option[Http] = None,
      annotations: Option[Annotations] = None,
      users: Option[List[TraceUser]] = None,
      serviceIds: Option[List[ServiceId]] = None,
      resourceARNs: Option[List[ResourceARNDetail]] = None,
      instanceIds: Option[List[InstanceIdDetail]] = None,
      availabilityZones: Option[List[AvailabilityZoneDetail]] = None,
      entryPoint: Option[ServiceId] = None,
      faultRootCauses: Option[List[FaultRootCause]] = None,
      errorRootCauses: Option[List[ErrorRootCause]] = None,
      responseTimeRootCauses: Option[List[ResponseTimeRootCause]] = None,
      revision: Option[Int] = None,
      matchedEventTime: Option[Timestamp] = None
    ): TraceSummary =
      TraceSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(responseTime)(_.responseTime(_))
        .ifSome(hasFault)(_.hasFault(_))
        .ifSome(hasError)(_.hasError(_))
        .ifSome(hasThrottle)(_.hasThrottle(_))
        .ifSome(isPartial)(_.isPartial(_))
        .ifSome(http)(_.http(_))
        .ifSome(annotations)(_.annotations(_))
        .ifSome(users)(_.users(_))
        .ifSome(serviceIds)(_.serviceIds(_))
        .ifSome(resourceARNs)(_.resourceARNs(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(entryPoint)(_.entryPoint(_))
        .ifSome(faultRootCauses)(_.faultRootCauses(_))
        .ifSome(errorRootCauses)(_.errorRootCauses(_))
        .ifSome(responseTimeRootCauses)(_.responseTimeRootCauses(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(matchedEventTime)(_.matchedEventTime(_))
        .build

    def traceUser(
      userName: Option[String] = None,
      serviceIds: Option[List[ServiceId]] = None
    ): TraceUser =
      TraceUser
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serviceIds)(_.serviceIds(_))
        .build

    def unprocessedStatistics(
      ruleName: Option[String] = None,
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): UnprocessedStatistics =
      UnprocessedStatistics
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def unprocessedTraceSegment(
      id: Option[String] = None,
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): UnprocessedTraceSegment =
      UnprocessedTraceSegment
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(errorCode)(_.errorCode(_))
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

    def updateGroupRequest(
      groupName: Option[String] = None,
      groupARN: Option[String] = None,
      filterExpression: Option[String] = None,
      insightsConfiguration: Option[InsightsConfiguration] = None
    ): UpdateGroupRequest =
      UpdateGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupARN)(_.groupARN(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(insightsConfiguration)(_.insightsConfiguration(_))
        .build

    def updateSamplingRuleRequest(
      samplingRuleUpdate: Option[SamplingRuleUpdate] = None
    ): UpdateSamplingRuleRequest =
      UpdateSamplingRuleRequest
        .builder
        .ifSome(samplingRuleUpdate)(_.samplingRuleUpdate(_))
        .build

    def valueWithServiceIds(
      annotationValue: Option[AnnotationValue] = None,
      serviceIds: Option[List[ServiceId]] = None
    ): ValueWithServiceIds =
      ValueWithServiceIds
        .builder
        .ifSome(annotationValue)(_.annotationValue(_))
        .ifSome(serviceIds)(_.serviceIds(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
