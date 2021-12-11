package goober.hi

import goober.free.applicationinsights.ApplicationInsightsIO
import software.amazon.awssdk.services.applicationinsights.model._


object applicationinsights {
  import goober.free.{applicationinsights ⇒ free}

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

    def applicationComponent(
      componentName: Option[String] = None,
      componentRemarks: Option[String] = None,
      resourceType: Option[String] = None,
      osType: Option[String] = None,
      tier: Option[String] = None,
      monitor: Option[Boolean] = None,
      detectedWorkload: Option[DetectedWorkload] = None
    ): ApplicationComponent =
      ApplicationComponent
        .builder
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentRemarks)(_.componentRemarks(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(osType)(_.osType(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(monitor)(_.monitor(_))
        .ifSome(detectedWorkload)(_.detectedWorkload(_))
        .build

    def applicationInfo(
      resourceGroupName: Option[String] = None,
      lifeCycle: Option[String] = None,
      opsItemSNSTopicArn: Option[String] = None,
      opsCenterEnabled: Option[Boolean] = None,
      cWEMonitorEnabled: Option[Boolean] = None,
      remarks: Option[String] = None
    ): ApplicationInfo =
      ApplicationInfo
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(lifeCycle)(_.lifeCycle(_))
        .ifSome(opsItemSNSTopicArn)(_.opsItemSNSTopicArn(_))
        .ifSome(opsCenterEnabled)(_.opsCenterEnabled(_))
        .ifSome(cWEMonitorEnabled)(_.cWEMonitorEnabled(_))
        .ifSome(remarks)(_.remarks(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def configurationEvent(
      monitoredResourceARN: Option[String] = None,
      eventStatus: Option[String] = None,
      eventResourceType: Option[String] = None,
      eventTime: Option[ConfigurationEventTime] = None,
      eventDetail: Option[String] = None,
      eventResourceName: Option[String] = None
    ): ConfigurationEvent =
      ConfigurationEvent
        .builder
        .ifSome(monitoredResourceARN)(_.monitoredResourceARN(_))
        .ifSome(eventStatus)(_.eventStatus(_))
        .ifSome(eventResourceType)(_.eventResourceType(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(eventDetail)(_.eventDetail(_))
        .ifSome(eventResourceName)(_.eventResourceName(_))
        .build

    def createApplicationRequest(
      resourceGroupName: Option[String] = None,
      opsCenterEnabled: Option[Boolean] = None,
      cWEMonitorEnabled: Option[Boolean] = None,
      opsItemSNSTopicArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(opsCenterEnabled)(_.opsCenterEnabled(_))
        .ifSome(cWEMonitorEnabled)(_.cWEMonitorEnabled(_))
        .ifSome(opsItemSNSTopicArn)(_.opsItemSNSTopicArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createApplicationResponse(
      applicationInfo: Option[ApplicationInfo] = None
    ): CreateApplicationResponse =
      CreateApplicationResponse
        .builder
        .ifSome(applicationInfo)(_.applicationInfo(_))
        .build

    def createComponentRequest(
      resourceGroupName: Option[String] = None,
      componentName: Option[String] = None,
      resourceList: Option[List[ResourceARN]] = None
    ): CreateComponentRequest =
      CreateComponentRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(resourceList)(_.resourceList(_))
        .build

    def createComponentResponse(

    ): CreateComponentResponse =
      CreateComponentResponse
        .builder

        .build

    def createLogPatternRequest(
      resourceGroupName: Option[String] = None,
      patternSetName: Option[String] = None,
      patternName: Option[String] = None,
      pattern: Option[String] = None,
      rank: Option[Int] = None
    ): CreateLogPatternRequest =
      CreateLogPatternRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(patternSetName)(_.patternSetName(_))
        .ifSome(patternName)(_.patternName(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(rank)(_.rank(_))
        .build

    def createLogPatternResponse(
      logPattern: Option[LogPattern] = None,
      resourceGroupName: Option[String] = None
    ): CreateLogPatternResponse =
      CreateLogPatternResponse
        .builder
        .ifSome(logPattern)(_.logPattern(_))
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .build

    def deleteApplicationRequest(
      resourceGroupName: Option[String] = None
    ): DeleteApplicationRequest =
      DeleteApplicationRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .build

    def deleteApplicationResponse(

    ): DeleteApplicationResponse =
      DeleteApplicationResponse
        .builder

        .build

    def deleteComponentRequest(
      resourceGroupName: Option[String] = None,
      componentName: Option[String] = None
    ): DeleteComponentRequest =
      DeleteComponentRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(componentName)(_.componentName(_))
        .build

    def deleteComponentResponse(

    ): DeleteComponentResponse =
      DeleteComponentResponse
        .builder

        .build

    def deleteLogPatternRequest(
      resourceGroupName: Option[String] = None,
      patternSetName: Option[String] = None,
      patternName: Option[String] = None
    ): DeleteLogPatternRequest =
      DeleteLogPatternRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(patternSetName)(_.patternSetName(_))
        .ifSome(patternName)(_.patternName(_))
        .build

    def deleteLogPatternResponse(

    ): DeleteLogPatternResponse =
      DeleteLogPatternResponse
        .builder

        .build

    def describeApplicationRequest(
      resourceGroupName: Option[String] = None
    ): DescribeApplicationRequest =
      DescribeApplicationRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .build

    def describeApplicationResponse(
      applicationInfo: Option[ApplicationInfo] = None
    ): DescribeApplicationResponse =
      DescribeApplicationResponse
        .builder
        .ifSome(applicationInfo)(_.applicationInfo(_))
        .build

    def describeComponentConfigurationRecommendationRequest(
      resourceGroupName: Option[String] = None,
      componentName: Option[String] = None,
      tier: Option[String] = None
    ): DescribeComponentConfigurationRecommendationRequest =
      DescribeComponentConfigurationRecommendationRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(tier)(_.tier(_))
        .build

    def describeComponentConfigurationRecommendationResponse(
      componentConfiguration: Option[String] = None
    ): DescribeComponentConfigurationRecommendationResponse =
      DescribeComponentConfigurationRecommendationResponse
        .builder
        .ifSome(componentConfiguration)(_.componentConfiguration(_))
        .build

    def describeComponentConfigurationRequest(
      resourceGroupName: Option[String] = None,
      componentName: Option[String] = None
    ): DescribeComponentConfigurationRequest =
      DescribeComponentConfigurationRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(componentName)(_.componentName(_))
        .build

    def describeComponentConfigurationResponse(
      monitor: Option[Boolean] = None,
      tier: Option[String] = None,
      componentConfiguration: Option[String] = None
    ): DescribeComponentConfigurationResponse =
      DescribeComponentConfigurationResponse
        .builder
        .ifSome(monitor)(_.monitor(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(componentConfiguration)(_.componentConfiguration(_))
        .build

    def describeComponentRequest(
      resourceGroupName: Option[String] = None,
      componentName: Option[String] = None
    ): DescribeComponentRequest =
      DescribeComponentRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(componentName)(_.componentName(_))
        .build

    def describeComponentResponse(
      applicationComponent: Option[ApplicationComponent] = None,
      resourceList: Option[List[ResourceARN]] = None
    ): DescribeComponentResponse =
      DescribeComponentResponse
        .builder
        .ifSome(applicationComponent)(_.applicationComponent(_))
        .ifSome(resourceList)(_.resourceList(_))
        .build

    def describeLogPatternRequest(
      resourceGroupName: Option[String] = None,
      patternSetName: Option[String] = None,
      patternName: Option[String] = None
    ): DescribeLogPatternRequest =
      DescribeLogPatternRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(patternSetName)(_.patternSetName(_))
        .ifSome(patternName)(_.patternName(_))
        .build

    def describeLogPatternResponse(
      resourceGroupName: Option[String] = None,
      logPattern: Option[LogPattern] = None
    ): DescribeLogPatternResponse =
      DescribeLogPatternResponse
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(logPattern)(_.logPattern(_))
        .build

    def describeObservationRequest(
      observationId: Option[String] = None
    ): DescribeObservationRequest =
      DescribeObservationRequest
        .builder
        .ifSome(observationId)(_.observationId(_))
        .build

    def describeObservationResponse(
      observation: Option[Observation] = None
    ): DescribeObservationResponse =
      DescribeObservationResponse
        .builder
        .ifSome(observation)(_.observation(_))
        .build

    def describeProblemObservationsRequest(
      problemId: Option[String] = None
    ): DescribeProblemObservationsRequest =
      DescribeProblemObservationsRequest
        .builder
        .ifSome(problemId)(_.problemId(_))
        .build

    def describeProblemObservationsResponse(
      relatedObservations: Option[RelatedObservations] = None
    ): DescribeProblemObservationsResponse =
      DescribeProblemObservationsResponse
        .builder
        .ifSome(relatedObservations)(_.relatedObservations(_))
        .build

    def describeProblemRequest(
      problemId: Option[String] = None
    ): DescribeProblemRequest =
      DescribeProblemRequest
        .builder
        .ifSome(problemId)(_.problemId(_))
        .build

    def describeProblemResponse(
      problem: Option[Problem] = None
    ): DescribeProblemResponse =
      DescribeProblemResponse
        .builder
        .ifSome(problem)(_.problem(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApplicationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListApplicationsRequest =
      ListApplicationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationsResponse(
      applicationInfoList: Option[List[ApplicationInfo]] = None,
      nextToken: Option[String] = None
    ): ListApplicationsResponse =
      ListApplicationsResponse
        .builder
        .ifSome(applicationInfoList)(_.applicationInfoList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentsRequest(
      resourceGroupName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListComponentsRequest =
      ListComponentsRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentsResponse(
      applicationComponentList: Option[List[ApplicationComponent]] = None,
      nextToken: Option[String] = None
    ): ListComponentsResponse =
      ListComponentsResponse
        .builder
        .ifSome(applicationComponentList)(_.applicationComponentList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationHistoryRequest(
      resourceGroupName: Option[String] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None,
      eventStatus: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationHistoryRequest =
      ListConfigurationHistoryRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(eventStatus)(_.eventStatus(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationHistoryResponse(
      eventList: Option[List[ConfigurationEvent]] = None,
      nextToken: Option[String] = None
    ): ListConfigurationHistoryResponse =
      ListConfigurationHistoryResponse
        .builder
        .ifSome(eventList)(_.eventList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLogPatternSetsRequest(
      resourceGroupName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListLogPatternSetsRequest =
      ListLogPatternSetsRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLogPatternSetsResponse(
      resourceGroupName: Option[String] = None,
      logPatternSets: Option[List[LogPatternSetName]] = None,
      nextToken: Option[String] = None
    ): ListLogPatternSetsResponse =
      ListLogPatternSetsResponse
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(logPatternSets)(_.logPatternSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLogPatternsRequest(
      resourceGroupName: Option[String] = None,
      patternSetName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListLogPatternsRequest =
      ListLogPatternsRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(patternSetName)(_.patternSetName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLogPatternsResponse(
      resourceGroupName: Option[String] = None,
      logPatterns: Option[List[LogPattern]] = None,
      nextToken: Option[String] = None
    ): ListLogPatternsResponse =
      ListLogPatternsResponse
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(logPatterns)(_.logPatterns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProblemsRequest(
      resourceGroupName: Option[String] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListProblemsRequest =
      ListProblemsRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProblemsResponse(
      problemList: Option[List[Problem]] = None,
      nextToken: Option[String] = None
    ): ListProblemsResponse =
      ListProblemsResponse
        .builder
        .ifSome(problemList)(_.problemList(_))
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
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def logPattern(
      patternSetName: Option[String] = None,
      patternName: Option[String] = None,
      pattern: Option[String] = None,
      rank: Option[Int] = None
    ): LogPattern =
      LogPattern
        .builder
        .ifSome(patternSetName)(_.patternSetName(_))
        .ifSome(patternName)(_.patternName(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(rank)(_.rank(_))
        .build

    def observation(
      id: Option[String] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None,
      sourceType: Option[String] = None,
      sourceARN: Option[String] = None,
      logGroup: Option[String] = None,
      lineTime: Option[LineTime] = None,
      logText: Option[String] = None,
      logFilter: Option[String] = None,
      metricNamespace: Option[String] = None,
      metricName: Option[String] = None,
      unit: Option[String] = None,
      value: Option[Value] = None,
      cloudWatchEventId: Option[String] = None,
      cloudWatchEventSource: Option[String] = None,
      cloudWatchEventDetailType: Option[String] = None,
      healthEventArn: Option[String] = None,
      healthService: Option[String] = None,
      healthEventTypeCode: Option[String] = None,
      healthEventTypeCategory: Option[String] = None,
      healthEventDescription: Option[String] = None,
      codeDeployDeploymentId: Option[String] = None,
      codeDeployDeploymentGroup: Option[String] = None,
      codeDeployState: Option[String] = None,
      codeDeployApplication: Option[String] = None,
      codeDeployInstanceGroupId: Option[String] = None,
      ec2State: Option[String] = None,
      rdsEventCategories: Option[String] = None,
      rdsEventMessage: Option[String] = None,
      s3EventName: Option[String] = None,
      statesExecutionArn: Option[String] = None,
      statesArn: Option[String] = None,
      statesStatus: Option[String] = None,
      statesInput: Option[String] = None,
      ebsEvent: Option[String] = None,
      ebsResult: Option[String] = None,
      ebsCause: Option[String] = None,
      ebsRequestId: Option[String] = None,
      xRayFaultPercent: Option[Int] = None,
      xRayThrottlePercent: Option[Int] = None,
      xRayErrorPercent: Option[Int] = None,
      xRayRequestCount: Option[Int] = None,
      xRayRequestAverageLatency: Option[XRayRequestAverageLatency] = None,
      xRayNodeName: Option[String] = None,
      xRayNodeType: Option[String] = None
    ): Observation =
      Observation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceARN)(_.sourceARN(_))
        .ifSome(logGroup)(_.logGroup(_))
        .ifSome(lineTime)(_.lineTime(_))
        .ifSome(logText)(_.logText(_))
        .ifSome(logFilter)(_.logFilter(_))
        .ifSome(metricNamespace)(_.metricNamespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(value)(_.value(_))
        .ifSome(cloudWatchEventId)(_.cloudWatchEventId(_))
        .ifSome(cloudWatchEventSource)(_.cloudWatchEventSource(_))
        .ifSome(cloudWatchEventDetailType)(_.cloudWatchEventDetailType(_))
        .ifSome(healthEventArn)(_.healthEventArn(_))
        .ifSome(healthService)(_.healthService(_))
        .ifSome(healthEventTypeCode)(_.healthEventTypeCode(_))
        .ifSome(healthEventTypeCategory)(_.healthEventTypeCategory(_))
        .ifSome(healthEventDescription)(_.healthEventDescription(_))
        .ifSome(codeDeployDeploymentId)(_.codeDeployDeploymentId(_))
        .ifSome(codeDeployDeploymentGroup)(_.codeDeployDeploymentGroup(_))
        .ifSome(codeDeployState)(_.codeDeployState(_))
        .ifSome(codeDeployApplication)(_.codeDeployApplication(_))
        .ifSome(codeDeployInstanceGroupId)(_.codeDeployInstanceGroupId(_))
        .ifSome(ec2State)(_.ec2State(_))
        .ifSome(rdsEventCategories)(_.rdsEventCategories(_))
        .ifSome(rdsEventMessage)(_.rdsEventMessage(_))
        .ifSome(s3EventName)(_.s3EventName(_))
        .ifSome(statesExecutionArn)(_.statesExecutionArn(_))
        .ifSome(statesArn)(_.statesArn(_))
        .ifSome(statesStatus)(_.statesStatus(_))
        .ifSome(statesInput)(_.statesInput(_))
        .ifSome(ebsEvent)(_.ebsEvent(_))
        .ifSome(ebsResult)(_.ebsResult(_))
        .ifSome(ebsCause)(_.ebsCause(_))
        .ifSome(ebsRequestId)(_.ebsRequestId(_))
        .ifSome(xRayFaultPercent)(_.xRayFaultPercent(_))
        .ifSome(xRayThrottlePercent)(_.xRayThrottlePercent(_))
        .ifSome(xRayErrorPercent)(_.xRayErrorPercent(_))
        .ifSome(xRayRequestCount)(_.xRayRequestCount(_))
        .ifSome(xRayRequestAverageLatency)(_.xRayRequestAverageLatency(_))
        .ifSome(xRayNodeName)(_.xRayNodeName(_))
        .ifSome(xRayNodeType)(_.xRayNodeType(_))
        .build

    def problem(
      id: Option[String] = None,
      title: Option[String] = None,
      insights: Option[String] = None,
      status: Option[String] = None,
      affectedResource: Option[String] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None,
      severityLevel: Option[String] = None,
      resourceGroupName: Option[String] = None,
      feedback: Option[Feedback] = None
    ): Problem =
      Problem
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(title)(_.title(_))
        .ifSome(insights)(_.insights(_))
        .ifSome(status)(_.status(_))
        .ifSome(affectedResource)(_.affectedResource(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(severityLevel)(_.severityLevel(_))
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(feedback)(_.feedback(_))
        .build

    def relatedObservations(
      observationList: Option[List[Observation]] = None
    ): RelatedObservations =
      RelatedObservations
        .builder
        .ifSome(observationList)(_.observationList(_))
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

    def tagsAlreadyExistException(
      message: Option[String] = None
    ): TagsAlreadyExistException =
      TagsAlreadyExistException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateApplicationRequest(
      resourceGroupName: Option[String] = None,
      opsCenterEnabled: Option[Boolean] = None,
      cWEMonitorEnabled: Option[Boolean] = None,
      opsItemSNSTopicArn: Option[String] = None,
      removeSNSTopic: Option[Boolean] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(opsCenterEnabled)(_.opsCenterEnabled(_))
        .ifSome(cWEMonitorEnabled)(_.cWEMonitorEnabled(_))
        .ifSome(opsItemSNSTopicArn)(_.opsItemSNSTopicArn(_))
        .ifSome(removeSNSTopic)(_.removeSNSTopic(_))
        .build

    def updateApplicationResponse(
      applicationInfo: Option[ApplicationInfo] = None
    ): UpdateApplicationResponse =
      UpdateApplicationResponse
        .builder
        .ifSome(applicationInfo)(_.applicationInfo(_))
        .build

    def updateComponentConfigurationRequest(
      resourceGroupName: Option[String] = None,
      componentName: Option[String] = None,
      monitor: Option[Boolean] = None,
      tier: Option[String] = None,
      componentConfiguration: Option[String] = None
    ): UpdateComponentConfigurationRequest =
      UpdateComponentConfigurationRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(monitor)(_.monitor(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(componentConfiguration)(_.componentConfiguration(_))
        .build

    def updateComponentConfigurationResponse(

    ): UpdateComponentConfigurationResponse =
      UpdateComponentConfigurationResponse
        .builder

        .build

    def updateComponentRequest(
      resourceGroupName: Option[String] = None,
      componentName: Option[String] = None,
      newComponentName: Option[String] = None,
      resourceList: Option[List[ResourceARN]] = None
    ): UpdateComponentRequest =
      UpdateComponentRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(newComponentName)(_.newComponentName(_))
        .ifSome(resourceList)(_.resourceList(_))
        .build

    def updateComponentResponse(

    ): UpdateComponentResponse =
      UpdateComponentResponse
        .builder

        .build

    def updateLogPatternRequest(
      resourceGroupName: Option[String] = None,
      patternSetName: Option[String] = None,
      patternName: Option[String] = None,
      pattern: Option[String] = None,
      rank: Option[Int] = None
    ): UpdateLogPatternRequest =
      UpdateLogPatternRequest
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(patternSetName)(_.patternSetName(_))
        .ifSome(patternName)(_.patternName(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(rank)(_.rank(_))
        .build

    def updateLogPatternResponse(
      resourceGroupName: Option[String] = None,
      logPattern: Option[LogPattern] = None
    ): UpdateLogPatternResponse =
      UpdateLogPatternResponse
        .builder
        .ifSome(resourceGroupName)(_.resourceGroupName(_))
        .ifSome(logPattern)(_.logPattern(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
