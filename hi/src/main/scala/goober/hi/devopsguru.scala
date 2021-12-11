package goober.hi

import goober.free.devopsguru.DevOpsGuruIO
import software.amazon.awssdk.services.devopsguru.model._


object devopsguru {
  import goober.free.{devopsguru ⇒ free}

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

    def addNotificationChannelRequest(
      config: Option[NotificationChannelConfig] = None
    ): AddNotificationChannelRequest =
      AddNotificationChannelRequest
        .builder
        .ifSome(config)(_.config(_))
        .build

    def addNotificationChannelResponse(
      id: Option[String] = None
    ): AddNotificationChannelResponse =
      AddNotificationChannelResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def anomalySourceDetails(
      cloudWatchMetrics: Option[List[CloudWatchMetricsDetail]] = None
    ): AnomalySourceDetails =
      AnomalySourceDetails
        .builder
        .ifSome(cloudWatchMetrics)(_.cloudWatchMetrics(_))
        .build

    def anomalyTimeRange(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): AnomalyTimeRange =
      AnomalyTimeRange
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def cloudFormationCollection(
      stackNames: Option[List[StackName]] = None
    ): CloudFormationCollection =
      CloudFormationCollection
        .builder
        .ifSome(stackNames)(_.stackNames(_))
        .build

    def cloudFormationCollectionFilter(
      stackNames: Option[List[StackName]] = None
    ): CloudFormationCollectionFilter =
      CloudFormationCollectionFilter
        .builder
        .ifSome(stackNames)(_.stackNames(_))
        .build

    def cloudFormationCostEstimationResourceCollectionFilter(
      stackNames: Option[List[StackName]] = None
    ): CloudFormationCostEstimationResourceCollectionFilter =
      CloudFormationCostEstimationResourceCollectionFilter
        .builder
        .ifSome(stackNames)(_.stackNames(_))
        .build

    def cloudFormationHealth(
      stackName: Option[String] = None,
      insight: Option[InsightHealth] = None
    ): CloudFormationHealth =
      CloudFormationHealth
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(insight)(_.insight(_))
        .build

    def cloudWatchMetricsDetail(
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      dimensions: Option[List[CloudWatchMetricsDimension]] = None,
      stat: Option[String] = None,
      unit: Option[String] = None,
      period: Option[Int] = None
    ): CloudWatchMetricsDetail =
      CloudWatchMetricsDetail
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(stat)(_.stat(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(period)(_.period(_))
        .build

    def cloudWatchMetricsDimension(
      name: Option[String] = None,
      value: Option[String] = None
    ): CloudWatchMetricsDimension =
      CloudWatchMetricsDimension
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
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

    def costEstimationResourceCollectionFilter(
      cloudFormation: Option[CloudFormationCostEstimationResourceCollectionFilter] = None
    ): CostEstimationResourceCollectionFilter =
      CostEstimationResourceCollectionFilter
        .builder
        .ifSome(cloudFormation)(_.cloudFormation(_))
        .build

    def costEstimationTimeRange(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): CostEstimationTimeRange =
      CostEstimationTimeRange
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def describeAccountHealthRequest(

    ): DescribeAccountHealthRequest =
      DescribeAccountHealthRequest
        .builder

        .build

    def describeAccountHealthResponse(
      openReactiveInsights: Option[Int] = None,
      openProactiveInsights: Option[Int] = None,
      metricsAnalyzed: Option[Int] = None,
      resourceHours: Option[ResourceHours] = None
    ): DescribeAccountHealthResponse =
      DescribeAccountHealthResponse
        .builder
        .ifSome(openReactiveInsights)(_.openReactiveInsights(_))
        .ifSome(openProactiveInsights)(_.openProactiveInsights(_))
        .ifSome(metricsAnalyzed)(_.metricsAnalyzed(_))
        .ifSome(resourceHours)(_.resourceHours(_))
        .build

    def describeAccountOverviewRequest(
      fromTime: Option[Timestamp] = None,
      toTime: Option[Timestamp] = None
    ): DescribeAccountOverviewRequest =
      DescribeAccountOverviewRequest
        .builder
        .ifSome(fromTime)(_.fromTime(_))
        .ifSome(toTime)(_.toTime(_))
        .build

    def describeAccountOverviewResponse(
      reactiveInsights: Option[Int] = None,
      proactiveInsights: Option[Int] = None,
      meanTimeToRecoverInMilliseconds: Option[MeanTimeToRecoverInMilliseconds] = None
    ): DescribeAccountOverviewResponse =
      DescribeAccountOverviewResponse
        .builder
        .ifSome(reactiveInsights)(_.reactiveInsights(_))
        .ifSome(proactiveInsights)(_.proactiveInsights(_))
        .ifSome(meanTimeToRecoverInMilliseconds)(_.meanTimeToRecoverInMilliseconds(_))
        .build

    def describeAnomalyRequest(
      id: Option[String] = None
    ): DescribeAnomalyRequest =
      DescribeAnomalyRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeAnomalyResponse(
      proactiveAnomaly: Option[ProactiveAnomaly] = None,
      reactiveAnomaly: Option[ReactiveAnomaly] = None
    ): DescribeAnomalyResponse =
      DescribeAnomalyResponse
        .builder
        .ifSome(proactiveAnomaly)(_.proactiveAnomaly(_))
        .ifSome(reactiveAnomaly)(_.reactiveAnomaly(_))
        .build

    def describeFeedbackRequest(
      insightId: Option[String] = None
    ): DescribeFeedbackRequest =
      DescribeFeedbackRequest
        .builder
        .ifSome(insightId)(_.insightId(_))
        .build

    def describeFeedbackResponse(
      insightFeedback: Option[InsightFeedback] = None
    ): DescribeFeedbackResponse =
      DescribeFeedbackResponse
        .builder
        .ifSome(insightFeedback)(_.insightFeedback(_))
        .build

    def describeInsightRequest(
      id: Option[String] = None
    ): DescribeInsightRequest =
      DescribeInsightRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeInsightResponse(
      proactiveInsight: Option[ProactiveInsight] = None,
      reactiveInsight: Option[ReactiveInsight] = None
    ): DescribeInsightResponse =
      DescribeInsightResponse
        .builder
        .ifSome(proactiveInsight)(_.proactiveInsight(_))
        .ifSome(reactiveInsight)(_.reactiveInsight(_))
        .build

    def describeResourceCollectionHealthRequest(
      resourceCollectionType: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeResourceCollectionHealthRequest =
      DescribeResourceCollectionHealthRequest
        .builder
        .ifSome(resourceCollectionType)(_.resourceCollectionType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeResourceCollectionHealthResponse(
      cloudFormation: Option[List[CloudFormationHealth]] = None,
      service: Option[List[ServiceHealth]] = None,
      nextToken: Option[String] = None
    ): DescribeResourceCollectionHealthResponse =
      DescribeResourceCollectionHealthResponse
        .builder
        .ifSome(cloudFormation)(_.cloudFormation(_))
        .ifSome(service)(_.service(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeServiceIntegrationRequest(

    ): DescribeServiceIntegrationRequest =
      DescribeServiceIntegrationRequest
        .builder

        .build

    def describeServiceIntegrationResponse(
      serviceIntegration: Option[ServiceIntegrationConfig] = None
    ): DescribeServiceIntegrationResponse =
      DescribeServiceIntegrationResponse
        .builder
        .ifSome(serviceIntegration)(_.serviceIntegration(_))
        .build

    def endTimeRange(
      fromTime: Option[Timestamp] = None,
      toTime: Option[Timestamp] = None
    ): EndTimeRange =
      EndTimeRange
        .builder
        .ifSome(fromTime)(_.fromTime(_))
        .ifSome(toTime)(_.toTime(_))
        .build

    def event(
      resourceCollection: Option[ResourceCollection] = None,
      id: Option[String] = None,
      time: Option[Timestamp] = None,
      eventSource: Option[String] = None,
      name: Option[String] = None,
      dataSource: Option[String] = None,
      eventClass: Option[String] = None,
      resources: Option[List[EventResource]] = None
    ): Event =
      Event
        .builder
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(id)(_.id(_))
        .ifSome(time)(_.time(_))
        .ifSome(eventSource)(_.eventSource(_))
        .ifSome(name)(_.name(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(eventClass)(_.eventClass(_))
        .ifSome(resources)(_.resources(_))
        .build

    def eventResource(
      `type`: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None
    ): EventResource =
      EventResource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def eventTimeRange(
      fromTime: Option[Timestamp] = None,
      toTime: Option[Timestamp] = None
    ): EventTimeRange =
      EventTimeRange
        .builder
        .ifSome(fromTime)(_.fromTime(_))
        .ifSome(toTime)(_.toTime(_))
        .build

    def getCostEstimationRequest(
      nextToken: Option[String] = None
    ): GetCostEstimationRequest =
      GetCostEstimationRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCostEstimationResponse(
      resourceCollection: Option[CostEstimationResourceCollectionFilter] = None,
      status: Option[String] = None,
      costs: Option[List[ServiceResourceCost]] = None,
      timeRange: Option[CostEstimationTimeRange] = None,
      totalCost: Option[Cost] = None,
      nextToken: Option[String] = None
    ): GetCostEstimationResponse =
      GetCostEstimationResponse
        .builder
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(status)(_.status(_))
        .ifSome(costs)(_.costs(_))
        .ifSome(timeRange)(_.timeRange(_))
        .ifSome(totalCost)(_.totalCost(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceCollectionRequest(
      resourceCollectionType: Option[String] = None,
      nextToken: Option[String] = None
    ): GetResourceCollectionRequest =
      GetResourceCollectionRequest
        .builder
        .ifSome(resourceCollectionType)(_.resourceCollectionType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceCollectionResponse(
      resourceCollection: Option[ResourceCollectionFilter] = None,
      nextToken: Option[String] = None
    ): GetResourceCollectionResponse =
      GetResourceCollectionResponse
        .builder
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def insightFeedback(
      id: Option[String] = None,
      feedback: Option[String] = None
    ): InsightFeedback =
      InsightFeedback
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(feedback)(_.feedback(_))
        .build

    def insightHealth(
      openProactiveInsights: Option[Int] = None,
      openReactiveInsights: Option[Int] = None,
      meanTimeToRecoverInMilliseconds: Option[MeanTimeToRecoverInMilliseconds] = None
    ): InsightHealth =
      InsightHealth
        .builder
        .ifSome(openProactiveInsights)(_.openProactiveInsights(_))
        .ifSome(openReactiveInsights)(_.openReactiveInsights(_))
        .ifSome(meanTimeToRecoverInMilliseconds)(_.meanTimeToRecoverInMilliseconds(_))
        .build

    def insightTimeRange(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): InsightTimeRange =
      InsightTimeRange
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def listAnomaliesForInsightRequest(
      insightId: Option[String] = None,
      startTimeRange: Option[StartTimeRange] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAnomaliesForInsightRequest =
      ListAnomaliesForInsightRequest
        .builder
        .ifSome(insightId)(_.insightId(_))
        .ifSome(startTimeRange)(_.startTimeRange(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnomaliesForInsightResponse(
      proactiveAnomalies: Option[List[ProactiveAnomalySummary]] = None,
      reactiveAnomalies: Option[List[ReactiveAnomalySummary]] = None,
      nextToken: Option[String] = None
    ): ListAnomaliesForInsightResponse =
      ListAnomaliesForInsightResponse
        .builder
        .ifSome(proactiveAnomalies)(_.proactiveAnomalies(_))
        .ifSome(reactiveAnomalies)(_.reactiveAnomalies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventsFilters(
      insightId: Option[String] = None,
      eventTimeRange: Option[EventTimeRange] = None,
      eventClass: Option[String] = None,
      eventSource: Option[String] = None,
      dataSource: Option[String] = None,
      resourceCollection: Option[ResourceCollection] = None
    ): ListEventsFilters =
      ListEventsFilters
        .builder
        .ifSome(insightId)(_.insightId(_))
        .ifSome(eventTimeRange)(_.eventTimeRange(_))
        .ifSome(eventClass)(_.eventClass(_))
        .ifSome(eventSource)(_.eventSource(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .build

    def listEventsRequest(
      filters: Option[ListEventsFilters] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEventsRequest =
      ListEventsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventsResponse(
      events: Option[List[Event]] = None,
      nextToken: Option[String] = None
    ): ListEventsResponse =
      ListEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInsightsAnyStatusFilter(
      `type`: Option[String] = None,
      startTimeRange: Option[StartTimeRange] = None
    ): ListInsightsAnyStatusFilter =
      ListInsightsAnyStatusFilter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(startTimeRange)(_.startTimeRange(_))
        .build

    def listInsightsClosedStatusFilter(
      `type`: Option[String] = None,
      endTimeRange: Option[EndTimeRange] = None
    ): ListInsightsClosedStatusFilter =
      ListInsightsClosedStatusFilter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(endTimeRange)(_.endTimeRange(_))
        .build

    def listInsightsOngoingStatusFilter(
      `type`: Option[String] = None
    ): ListInsightsOngoingStatusFilter =
      ListInsightsOngoingStatusFilter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def listInsightsRequest(
      statusFilter: Option[ListInsightsStatusFilter] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInsightsRequest =
      ListInsightsRequest
        .builder
        .ifSome(statusFilter)(_.statusFilter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInsightsResponse(
      proactiveInsights: Option[List[ProactiveInsightSummary]] = None,
      reactiveInsights: Option[List[ReactiveInsightSummary]] = None,
      nextToken: Option[String] = None
    ): ListInsightsResponse =
      ListInsightsResponse
        .builder
        .ifSome(proactiveInsights)(_.proactiveInsights(_))
        .ifSome(reactiveInsights)(_.reactiveInsights(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInsightsStatusFilter(
      ongoing: Option[ListInsightsOngoingStatusFilter] = None,
      closed: Option[ListInsightsClosedStatusFilter] = None,
      any: Option[ListInsightsAnyStatusFilter] = None
    ): ListInsightsStatusFilter =
      ListInsightsStatusFilter
        .builder
        .ifSome(ongoing)(_.ongoing(_))
        .ifSome(closed)(_.closed(_))
        .ifSome(any)(_.any(_))
        .build

    def listNotificationChannelsRequest(
      nextToken: Option[String] = None
    ): ListNotificationChannelsRequest =
      ListNotificationChannelsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNotificationChannelsResponse(
      channels: Option[List[NotificationChannel]] = None,
      nextToken: Option[String] = None
    ): ListNotificationChannelsResponse =
      ListNotificationChannelsResponse
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecommendationsRequest(
      insightId: Option[String] = None,
      nextToken: Option[String] = None,
      locale: Option[String] = None
    ): ListRecommendationsRequest =
      ListRecommendationsRequest
        .builder
        .ifSome(insightId)(_.insightId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(locale)(_.locale(_))
        .build

    def listRecommendationsResponse(
      recommendations: Option[List[Recommendation]] = None,
      nextToken: Option[String] = None
    ): ListRecommendationsResponse =
      ListRecommendationsResponse
        .builder
        .ifSome(recommendations)(_.recommendations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def notificationChannel(
      id: Option[String] = None,
      config: Option[NotificationChannelConfig] = None
    ): NotificationChannel =
      NotificationChannel
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(config)(_.config(_))
        .build

    def notificationChannelConfig(
      sns: Option[SnsChannelConfig] = None
    ): NotificationChannelConfig =
      NotificationChannelConfig
        .builder
        .ifSome(sns)(_.sns(_))
        .build

    def opsCenterIntegration(
      optInStatus: Option[String] = None
    ): OpsCenterIntegration =
      OpsCenterIntegration
        .builder
        .ifSome(optInStatus)(_.optInStatus(_))
        .build

    def opsCenterIntegrationConfig(
      optInStatus: Option[String] = None
    ): OpsCenterIntegrationConfig =
      OpsCenterIntegrationConfig
        .builder
        .ifSome(optInStatus)(_.optInStatus(_))
        .build

    def predictionTimeRange(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): PredictionTimeRange =
      PredictionTimeRange
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def proactiveAnomaly(
      id: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      updateTime: Option[Timestamp] = None,
      anomalyTimeRange: Option[AnomalyTimeRange] = None,
      predictionTimeRange: Option[PredictionTimeRange] = None,
      sourceDetails: Option[AnomalySourceDetails] = None,
      associatedInsightId: Option[String] = None,
      resourceCollection: Option[ResourceCollection] = None,
      limit: Option[AnomalyLimit] = None
    ): ProactiveAnomaly =
      ProactiveAnomaly
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateTime)(_.updateTime(_))
        .ifSome(anomalyTimeRange)(_.anomalyTimeRange(_))
        .ifSome(predictionTimeRange)(_.predictionTimeRange(_))
        .ifSome(sourceDetails)(_.sourceDetails(_))
        .ifSome(associatedInsightId)(_.associatedInsightId(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(limit)(_.limit(_))
        .build

    def proactiveAnomalySummary(
      id: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      updateTime: Option[Timestamp] = None,
      anomalyTimeRange: Option[AnomalyTimeRange] = None,
      predictionTimeRange: Option[PredictionTimeRange] = None,
      sourceDetails: Option[AnomalySourceDetails] = None,
      associatedInsightId: Option[String] = None,
      resourceCollection: Option[ResourceCollection] = None,
      limit: Option[AnomalyLimit] = None
    ): ProactiveAnomalySummary =
      ProactiveAnomalySummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateTime)(_.updateTime(_))
        .ifSome(anomalyTimeRange)(_.anomalyTimeRange(_))
        .ifSome(predictionTimeRange)(_.predictionTimeRange(_))
        .ifSome(sourceDetails)(_.sourceDetails(_))
        .ifSome(associatedInsightId)(_.associatedInsightId(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(limit)(_.limit(_))
        .build

    def proactiveInsight(
      id: Option[String] = None,
      name: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      insightTimeRange: Option[InsightTimeRange] = None,
      predictionTimeRange: Option[PredictionTimeRange] = None,
      resourceCollection: Option[ResourceCollection] = None,
      ssmOpsItemId: Option[String] = None
    ): ProactiveInsight =
      ProactiveInsight
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(insightTimeRange)(_.insightTimeRange(_))
        .ifSome(predictionTimeRange)(_.predictionTimeRange(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(ssmOpsItemId)(_.ssmOpsItemId(_))
        .build

    def proactiveInsightSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      insightTimeRange: Option[InsightTimeRange] = None,
      predictionTimeRange: Option[PredictionTimeRange] = None,
      resourceCollection: Option[ResourceCollection] = None,
      serviceCollection: Option[ServiceCollection] = None
    ): ProactiveInsightSummary =
      ProactiveInsightSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(insightTimeRange)(_.insightTimeRange(_))
        .ifSome(predictionTimeRange)(_.predictionTimeRange(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(serviceCollection)(_.serviceCollection(_))
        .build

    def putFeedbackRequest(
      insightFeedback: Option[InsightFeedback] = None
    ): PutFeedbackRequest =
      PutFeedbackRequest
        .builder
        .ifSome(insightFeedback)(_.insightFeedback(_))
        .build

    def putFeedbackResponse(

    ): PutFeedbackResponse =
      PutFeedbackResponse
        .builder

        .build

    def reactiveAnomaly(
      id: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      anomalyTimeRange: Option[AnomalyTimeRange] = None,
      sourceDetails: Option[AnomalySourceDetails] = None,
      associatedInsightId: Option[String] = None,
      resourceCollection: Option[ResourceCollection] = None
    ): ReactiveAnomaly =
      ReactiveAnomaly
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(anomalyTimeRange)(_.anomalyTimeRange(_))
        .ifSome(sourceDetails)(_.sourceDetails(_))
        .ifSome(associatedInsightId)(_.associatedInsightId(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .build

    def reactiveAnomalySummary(
      id: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      anomalyTimeRange: Option[AnomalyTimeRange] = None,
      sourceDetails: Option[AnomalySourceDetails] = None,
      associatedInsightId: Option[String] = None,
      resourceCollection: Option[ResourceCollection] = None
    ): ReactiveAnomalySummary =
      ReactiveAnomalySummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(anomalyTimeRange)(_.anomalyTimeRange(_))
        .ifSome(sourceDetails)(_.sourceDetails(_))
        .ifSome(associatedInsightId)(_.associatedInsightId(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .build

    def reactiveInsight(
      id: Option[String] = None,
      name: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      insightTimeRange: Option[InsightTimeRange] = None,
      resourceCollection: Option[ResourceCollection] = None,
      ssmOpsItemId: Option[String] = None
    ): ReactiveInsight =
      ReactiveInsight
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(insightTimeRange)(_.insightTimeRange(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(ssmOpsItemId)(_.ssmOpsItemId(_))
        .build

    def reactiveInsightSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      insightTimeRange: Option[InsightTimeRange] = None,
      resourceCollection: Option[ResourceCollection] = None,
      serviceCollection: Option[ServiceCollection] = None
    ): ReactiveInsightSummary =
      ReactiveInsightSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(insightTimeRange)(_.insightTimeRange(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(serviceCollection)(_.serviceCollection(_))
        .build

    def recommendation(
      description: Option[String] = None,
      link: Option[String] = None,
      name: Option[String] = None,
      reason: Option[String] = None,
      relatedEvents: Option[List[RecommendationRelatedEvent]] = None,
      relatedAnomalies: Option[List[RecommendationRelatedAnomaly]] = None
    ): Recommendation =
      Recommendation
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(link)(_.link(_))
        .ifSome(name)(_.name(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(relatedEvents)(_.relatedEvents(_))
        .ifSome(relatedAnomalies)(_.relatedAnomalies(_))
        .build

    def recommendationRelatedAnomaly(
      resources: Option[List[RecommendationRelatedAnomalyResource]] = None,
      sourceDetails: Option[List[RecommendationRelatedAnomalySourceDetail]] = None
    ): RecommendationRelatedAnomaly =
      RecommendationRelatedAnomaly
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(sourceDetails)(_.sourceDetails(_))
        .build

    def recommendationRelatedAnomalyResource(
      name: Option[String] = None,
      `type`: Option[String] = None
    ): RecommendationRelatedAnomalyResource =
      RecommendationRelatedAnomalyResource
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def recommendationRelatedAnomalySourceDetail(
      cloudWatchMetrics: Option[List[RecommendationRelatedCloudWatchMetricsSourceDetail]] = None
    ): RecommendationRelatedAnomalySourceDetail =
      RecommendationRelatedAnomalySourceDetail
        .builder
        .ifSome(cloudWatchMetrics)(_.cloudWatchMetrics(_))
        .build

    def recommendationRelatedCloudWatchMetricsSourceDetail(
      metricName: Option[String] = None,
      namespace: Option[String] = None
    ): RecommendationRelatedCloudWatchMetricsSourceDetail =
      RecommendationRelatedCloudWatchMetricsSourceDetail
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def recommendationRelatedEvent(
      name: Option[String] = None,
      resources: Option[List[RecommendationRelatedEventResource]] = None
    ): RecommendationRelatedEvent =
      RecommendationRelatedEvent
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resources)(_.resources(_))
        .build

    def recommendationRelatedEventResource(
      name: Option[String] = None,
      `type`: Option[String] = None
    ): RecommendationRelatedEventResource =
      RecommendationRelatedEventResource
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def removeNotificationChannelRequest(
      id: Option[String] = None
    ): RemoveNotificationChannelRequest =
      RemoveNotificationChannelRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def removeNotificationChannelResponse(

    ): RemoveNotificationChannelResponse =
      RemoveNotificationChannelResponse
        .builder

        .build

    def resourceCollection(
      cloudFormation: Option[CloudFormationCollection] = None
    ): ResourceCollection =
      ResourceCollection
        .builder
        .ifSome(cloudFormation)(_.cloudFormation(_))
        .build

    def resourceCollectionFilter(
      cloudFormation: Option[CloudFormationCollectionFilter] = None
    ): ResourceCollectionFilter =
      ResourceCollectionFilter
        .builder
        .ifSome(cloudFormation)(_.cloudFormation(_))
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

    def searchInsightsFilters(
      severities: Option[List[InsightSeverity]] = None,
      statuses: Option[List[InsightStatus]] = None,
      resourceCollection: Option[ResourceCollection] = None,
      serviceCollection: Option[ServiceCollection] = None
    ): SearchInsightsFilters =
      SearchInsightsFilters
        .builder
        .ifSome(severities)(_.severities(_))
        .ifSome(statuses)(_.statuses(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(serviceCollection)(_.serviceCollection(_))
        .build

    def searchInsightsRequest(
      startTimeRange: Option[StartTimeRange] = None,
      filters: Option[SearchInsightsFilters] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      `type`: Option[String] = None
    ): SearchInsightsRequest =
      SearchInsightsRequest
        .builder
        .ifSome(startTimeRange)(_.startTimeRange(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def searchInsightsResponse(
      proactiveInsights: Option[List[ProactiveInsightSummary]] = None,
      reactiveInsights: Option[List[ReactiveInsightSummary]] = None,
      nextToken: Option[String] = None
    ): SearchInsightsResponse =
      SearchInsightsResponse
        .builder
        .ifSome(proactiveInsights)(_.proactiveInsights(_))
        .ifSome(reactiveInsights)(_.reactiveInsights(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def serviceCollection(
      serviceNames: Option[List[ServiceName]] = None
    ): ServiceCollection =
      ServiceCollection
        .builder
        .ifSome(serviceNames)(_.serviceNames(_))
        .build

    def serviceHealth(
      serviceName: Option[String] = None,
      insight: Option[ServiceInsightHealth] = None
    ): ServiceHealth =
      ServiceHealth
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(insight)(_.insight(_))
        .build

    def serviceInsightHealth(
      openProactiveInsights: Option[Int] = None,
      openReactiveInsights: Option[Int] = None
    ): ServiceInsightHealth =
      ServiceInsightHealth
        .builder
        .ifSome(openProactiveInsights)(_.openProactiveInsights(_))
        .ifSome(openReactiveInsights)(_.openReactiveInsights(_))
        .build

    def serviceIntegrationConfig(
      opsCenter: Option[OpsCenterIntegration] = None
    ): ServiceIntegrationConfig =
      ServiceIntegrationConfig
        .builder
        .ifSome(opsCenter)(_.opsCenter(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceResourceCost(
      `type`: Option[String] = None,
      state: Option[String] = None,
      count: Option[Int] = None,
      unitCost: Option[Cost] = None,
      cost: Option[Cost] = None
    ): ServiceResourceCost =
      ServiceResourceCost
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(count)(_.count(_))
        .ifSome(unitCost)(_.unitCost(_))
        .ifSome(cost)(_.cost(_))
        .build

    def snsChannelConfig(
      topicArn: Option[String] = None
    ): SnsChannelConfig =
      SnsChannelConfig
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def startCostEstimationRequest(
      resourceCollection: Option[CostEstimationResourceCollectionFilter] = None,
      clientToken: Option[String] = None
    ): StartCostEstimationRequest =
      StartCostEstimationRequest
        .builder
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startCostEstimationResponse(

    ): StartCostEstimationResponse =
      StartCostEstimationResponse
        .builder

        .build

    def startTimeRange(
      fromTime: Option[Timestamp] = None,
      toTime: Option[Timestamp] = None
    ): StartTimeRange =
      StartTimeRange
        .builder
        .ifSome(fromTime)(_.fromTime(_))
        .ifSome(toTime)(_.toTime(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def updateCloudFormationCollectionFilter(
      stackNames: Option[List[StackName]] = None
    ): UpdateCloudFormationCollectionFilter =
      UpdateCloudFormationCollectionFilter
        .builder
        .ifSome(stackNames)(_.stackNames(_))
        .build

    def updateResourceCollectionFilter(
      cloudFormation: Option[UpdateCloudFormationCollectionFilter] = None
    ): UpdateResourceCollectionFilter =
      UpdateResourceCollectionFilter
        .builder
        .ifSome(cloudFormation)(_.cloudFormation(_))
        .build

    def updateResourceCollectionRequest(
      action: Option[String] = None,
      resourceCollection: Option[UpdateResourceCollectionFilter] = None
    ): UpdateResourceCollectionRequest =
      UpdateResourceCollectionRequest
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(resourceCollection)(_.resourceCollection(_))
        .build

    def updateResourceCollectionResponse(

    ): UpdateResourceCollectionResponse =
      UpdateResourceCollectionResponse
        .builder

        .build

    def updateServiceIntegrationConfig(
      opsCenter: Option[OpsCenterIntegrationConfig] = None
    ): UpdateServiceIntegrationConfig =
      UpdateServiceIntegrationConfig
        .builder
        .ifSome(opsCenter)(_.opsCenter(_))
        .build

    def updateServiceIntegrationRequest(
      serviceIntegration: Option[UpdateServiceIntegrationConfig] = None
    ): UpdateServiceIntegrationRequest =
      UpdateServiceIntegrationRequest
        .builder
        .ifSome(serviceIntegration)(_.serviceIntegration(_))
        .build

    def updateServiceIntegrationResponse(

    ): UpdateServiceIntegrationResponse =
      UpdateServiceIntegrationResponse
        .builder

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

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
