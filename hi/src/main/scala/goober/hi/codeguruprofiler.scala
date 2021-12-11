package goober.hi

import goober.free.codeguruprofiler.CodeGuruProfilerIO
import software.amazon.awssdk.services.codeguruprofiler.model._


object codeguruprofiler {
  import goober.free.{codeguruprofiler ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addNotificationChannelsRequest(
      channels: Option[List[Channel]] = None,
      profilingGroupName: Option[String] = None
    ): AddNotificationChannelsRequest =
      AddNotificationChannelsRequest
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def addNotificationChannelsResponse(
      notificationConfiguration: Option[NotificationConfiguration] = None
    ): AddNotificationChannelsResponse =
      AddNotificationChannelsResponse
        .builder
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .build

    def agentConfiguration(
      agentParameters: Option[AgentParameters] = None,
      periodInSeconds: Option[Int] = None,
      shouldProfile: Option[Boolean] = None
    ): AgentConfiguration =
      AgentConfiguration
        .builder
        .ifSome(agentParameters)(_.agentParameters(_))
        .ifSome(periodInSeconds)(_.periodInSeconds(_))
        .ifSome(shouldProfile)(_.shouldProfile(_))
        .build

    def agentOrchestrationConfig(
      profilingEnabled: Option[Boolean] = None
    ): AgentOrchestrationConfig =
      AgentOrchestrationConfig
        .builder
        .ifSome(profilingEnabled)(_.profilingEnabled(_))
        .build

    def aggregatedProfileTime(
      period: Option[String] = None,
      start: Option[Timestamp] = None
    ): AggregatedProfileTime =
      AggregatedProfileTime
        .builder
        .ifSome(period)(_.period(_))
        .ifSome(start)(_.start(_))
        .build

    def anomaly(
      instances: Option[List[AnomalyInstance]] = None,
      metric: Option[Metric] = None,
      reason: Option[String] = None
    ): Anomaly =
      Anomaly
        .builder
        .ifSome(instances)(_.instances(_))
        .ifSome(metric)(_.metric(_))
        .ifSome(reason)(_.reason(_))
        .build

    def anomalyInstance(
      endTime: Option[Timestamp] = None,
      id: Option[String] = None,
      startTime: Option[Timestamp] = None,
      userFeedback: Option[UserFeedback] = None
    ): AnomalyInstance =
      AnomalyInstance
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(id)(_.id(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(userFeedback)(_.userFeedback(_))
        .build

    def batchGetFrameMetricDataRequest(
      endTime: Option[Timestamp] = None,
      frameMetrics: Option[List[FrameMetric]] = None,
      period: Option[String] = None,
      profilingGroupName: Option[String] = None,
      startTime: Option[Timestamp] = None,
      targetResolution: Option[String] = None
    ): BatchGetFrameMetricDataRequest =
      BatchGetFrameMetricDataRequest
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(frameMetrics)(_.frameMetrics(_))
        .ifSome(period)(_.period(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(targetResolution)(_.targetResolution(_))
        .build

    def batchGetFrameMetricDataResponse(
      endTime: Option[Timestamp] = None,
      endTimes: Option[List[TimestampStructure]] = None,
      frameMetricData: Option[List[FrameMetricDatum]] = None,
      resolution: Option[String] = None,
      startTime: Option[Timestamp] = None,
      unprocessedEndTimes: Option[UnprocessedEndTimeMap] = None
    ): BatchGetFrameMetricDataResponse =
      BatchGetFrameMetricDataResponse
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(endTimes)(_.endTimes(_))
        .ifSome(frameMetricData)(_.frameMetricData(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(unprocessedEndTimes)(_.unprocessedEndTimes(_))
        .build

    def channel(
      eventPublishers: Option[List[EventPublisher]] = None,
      id: Option[String] = None,
      uri: Option[String] = None
    ): Channel =
      Channel
        .builder
        .ifSome(eventPublishers)(_.eventPublishers(_))
        .ifSome(id)(_.id(_))
        .ifSome(uri)(_.uri(_))
        .build

    def configureAgentRequest(
      fleetInstanceId: Option[String] = None,
      metadata: Option[Metadata] = None,
      profilingGroupName: Option[String] = None
    ): ConfigureAgentRequest =
      ConfigureAgentRequest
        .builder
        .ifSome(fleetInstanceId)(_.fleetInstanceId(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def configureAgentResponse(
      configuration: Option[AgentConfiguration] = None
    ): ConfigureAgentResponse =
      ConfigureAgentResponse
        .builder
        .ifSome(configuration)(_.configuration(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createProfilingGroupRequest(
      agentOrchestrationConfig: Option[AgentOrchestrationConfig] = None,
      clientToken: Option[String] = None,
      computePlatform: Option[String] = None,
      profilingGroupName: Option[String] = None,
      tags: Option[TagsMap] = None
    ): CreateProfilingGroupRequest =
      CreateProfilingGroupRequest
        .builder
        .ifSome(agentOrchestrationConfig)(_.agentOrchestrationConfig(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProfilingGroupResponse(
      profilingGroup: Option[ProfilingGroupDescription] = None
    ): CreateProfilingGroupResponse =
      CreateProfilingGroupResponse
        .builder
        .ifSome(profilingGroup)(_.profilingGroup(_))
        .build

    def deleteProfilingGroupRequest(
      profilingGroupName: Option[String] = None
    ): DeleteProfilingGroupRequest =
      DeleteProfilingGroupRequest
        .builder
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def deleteProfilingGroupResponse(

    ): DeleteProfilingGroupResponse =
      DeleteProfilingGroupResponse
        .builder

        .build

    def describeProfilingGroupRequest(
      profilingGroupName: Option[String] = None
    ): DescribeProfilingGroupRequest =
      DescribeProfilingGroupRequest
        .builder
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def describeProfilingGroupResponse(
      profilingGroup: Option[ProfilingGroupDescription] = None
    ): DescribeProfilingGroupResponse =
      DescribeProfilingGroupResponse
        .builder
        .ifSome(profilingGroup)(_.profilingGroup(_))
        .build

    def findingsReportSummary(
      id: Option[String] = None,
      profileEndTime: Option[Timestamp] = None,
      profileStartTime: Option[Timestamp] = None,
      profilingGroupName: Option[String] = None,
      totalNumberOfFindings: Option[Int] = None
    ): FindingsReportSummary =
      FindingsReportSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(profileEndTime)(_.profileEndTime(_))
        .ifSome(profileStartTime)(_.profileStartTime(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(totalNumberOfFindings)(_.totalNumberOfFindings(_))
        .build

    def frameMetric(
      frameName: Option[String] = None,
      threadStates: Option[List[String]] = None,
      `type`: Option[String] = None
    ): FrameMetric =
      FrameMetric
        .builder
        .ifSome(frameName)(_.frameName(_))
        .ifSome(threadStates)(_.threadStates(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def frameMetricDatum(
      frameMetric: Option[FrameMetric] = None,
      values: Option[List[FrameMetricValue]] = None
    ): FrameMetricDatum =
      FrameMetricDatum
        .builder
        .ifSome(frameMetric)(_.frameMetric(_))
        .ifSome(values)(_.values(_))
        .build

    def getFindingsReportAccountSummaryRequest(
      dailyReportsOnly: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetFindingsReportAccountSummaryRequest =
      GetFindingsReportAccountSummaryRequest
        .builder
        .ifSome(dailyReportsOnly)(_.dailyReportsOnly(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getFindingsReportAccountSummaryResponse(
      nextToken: Option[String] = None,
      reportSummaries: Option[List[FindingsReportSummary]] = None
    ): GetFindingsReportAccountSummaryResponse =
      GetFindingsReportAccountSummaryResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reportSummaries)(_.reportSummaries(_))
        .build

    def getNotificationConfigurationRequest(
      profilingGroupName: Option[String] = None
    ): GetNotificationConfigurationRequest =
      GetNotificationConfigurationRequest
        .builder
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def getNotificationConfigurationResponse(
      notificationConfiguration: Option[NotificationConfiguration] = None
    ): GetNotificationConfigurationResponse =
      GetNotificationConfigurationResponse
        .builder
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .build

    def getPolicyRequest(
      profilingGroupName: Option[String] = None
    ): GetPolicyRequest =
      GetPolicyRequest
        .builder
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def getPolicyResponse(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): GetPolicyResponse =
      GetPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getProfileRequest(
      accept: Option[String] = None,
      endTime: Option[Timestamp] = None,
      maxDepth: Option[Int] = None,
      period: Option[String] = None,
      profilingGroupName: Option[String] = None,
      startTime: Option[Timestamp] = None
    ): GetProfileRequest =
      GetProfileRequest
        .builder
        .ifSome(accept)(_.accept(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxDepth)(_.maxDepth(_))
        .ifSome(period)(_.period(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def getProfileResponse(
      contentEncoding: Option[String] = None,
      contentType: Option[String] = None,
      profile: Option[AggregatedProfile] = None
    ): GetProfileResponse =
      GetProfileResponse
        .builder
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(profile)(_.profile(_))
        .build

    def getRecommendationsRequest(
      endTime: Option[Timestamp] = None,
      locale: Option[String] = None,
      profilingGroupName: Option[String] = None,
      startTime: Option[Timestamp] = None
    ): GetRecommendationsRequest =
      GetRecommendationsRequest
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def getRecommendationsResponse(
      anomalies: Option[List[Anomaly]] = None,
      profileEndTime: Option[Timestamp] = None,
      profileStartTime: Option[Timestamp] = None,
      profilingGroupName: Option[String] = None,
      recommendations: Option[List[Recommendation]] = None
    ): GetRecommendationsResponse =
      GetRecommendationsResponse
        .builder
        .ifSome(anomalies)(_.anomalies(_))
        .ifSome(profileEndTime)(_.profileEndTime(_))
        .ifSome(profileStartTime)(_.profileStartTime(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(recommendations)(_.recommendations(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listFindingsReportsRequest(
      dailyReportsOnly: Option[Boolean] = None,
      endTime: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      profilingGroupName: Option[String] = None,
      startTime: Option[Timestamp] = None
    ): ListFindingsReportsRequest =
      ListFindingsReportsRequest
        .builder
        .ifSome(dailyReportsOnly)(_.dailyReportsOnly(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def listFindingsReportsResponse(
      findingsReportSummaries: Option[List[FindingsReportSummary]] = None,
      nextToken: Option[String] = None
    ): ListFindingsReportsResponse =
      ListFindingsReportsResponse
        .builder
        .ifSome(findingsReportSummaries)(_.findingsReportSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProfileTimesRequest(
      endTime: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      orderBy: Option[String] = None,
      period: Option[String] = None,
      profilingGroupName: Option[String] = None,
      startTime: Option[Timestamp] = None
    ): ListProfileTimesRequest =
      ListProfileTimesRequest
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(orderBy)(_.orderBy(_))
        .ifSome(period)(_.period(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def listProfileTimesResponse(
      nextToken: Option[String] = None,
      profileTimes: Option[List[ProfileTime]] = None
    ): ListProfileTimesResponse =
      ListProfileTimesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(profileTimes)(_.profileTimes(_))
        .build

    def listProfilingGroupsRequest(
      includeDescription: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListProfilingGroupsRequest =
      ListProfilingGroupsRequest
        .builder
        .ifSome(includeDescription)(_.includeDescription(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProfilingGroupsResponse(
      nextToken: Option[String] = None,
      profilingGroupNames: Option[List[ProfilingGroupName]] = None,
      profilingGroups: Option[List[ProfilingGroupDescription]] = None
    ): ListProfilingGroupsResponse =
      ListProfilingGroupsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(profilingGroupNames)(_.profilingGroupNames(_))
        .ifSome(profilingGroups)(_.profilingGroups(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagsMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def match(
      frameAddress: Option[String] = None,
      targetFramesIndex: Option[Int] = None,
      thresholdBreachValue: Option[Double] = None
    ): Match =
      Match
        .builder
        .ifSome(frameAddress)(_.frameAddress(_))
        .ifSome(targetFramesIndex)(_.targetFramesIndex(_))
        .ifSome(thresholdBreachValue)(_.thresholdBreachValue(_))
        .build

    def metric(
      frameName: Option[String] = None,
      threadStates: Option[List[String]] = None,
      `type`: Option[String] = None
    ): Metric =
      Metric
        .builder
        .ifSome(frameName)(_.frameName(_))
        .ifSome(threadStates)(_.threadStates(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def notificationConfiguration(
      channels: Option[List[Channel]] = None
    ): NotificationConfiguration =
      NotificationConfiguration
        .builder
        .ifSome(channels)(_.channels(_))
        .build

    def pattern(
      countersToAggregate: Option[List[String]] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      resolutionSteps: Option[String] = None,
      targetFrames: Option[List[TargetFrame]] = None,
      thresholdPercent: Option[Percentage] = None
    ): Pattern =
      Pattern
        .builder
        .ifSome(countersToAggregate)(_.countersToAggregate(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(resolutionSteps)(_.resolutionSteps(_))
        .ifSome(targetFrames)(_.targetFrames(_))
        .ifSome(thresholdPercent)(_.thresholdPercent(_))
        .build

    def postAgentProfileRequest(
      agentProfile: Option[AgentProfile] = None,
      contentType: Option[String] = None,
      profileToken: Option[String] = None,
      profilingGroupName: Option[String] = None
    ): PostAgentProfileRequest =
      PostAgentProfileRequest
        .builder
        .ifSome(agentProfile)(_.agentProfile(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(profileToken)(_.profileToken(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def postAgentProfileResponse(

    ): PostAgentProfileResponse =
      PostAgentProfileResponse
        .builder

        .build

    def profileTime(
      start: Option[Timestamp] = None
    ): ProfileTime =
      ProfileTime
        .builder
        .ifSome(start)(_.start(_))
        .build

    def profilingGroupDescription(
      agentOrchestrationConfig: Option[AgentOrchestrationConfig] = None,
      arn: Option[String] = None,
      computePlatform: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      name: Option[String] = None,
      profilingStatus: Option[ProfilingStatus] = None,
      tags: Option[TagsMap] = None,
      updatedAt: Option[Timestamp] = None
    ): ProfilingGroupDescription =
      ProfilingGroupDescription
        .builder
        .ifSome(agentOrchestrationConfig)(_.agentOrchestrationConfig(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(profilingStatus)(_.profilingStatus(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def profilingStatus(
      latestAgentOrchestratedAt: Option[Timestamp] = None,
      latestAgentProfileReportedAt: Option[Timestamp] = None,
      latestAggregatedProfile: Option[AggregatedProfileTime] = None
    ): ProfilingStatus =
      ProfilingStatus
        .builder
        .ifSome(latestAgentOrchestratedAt)(_.latestAgentOrchestratedAt(_))
        .ifSome(latestAgentProfileReportedAt)(_.latestAgentProfileReportedAt(_))
        .ifSome(latestAggregatedProfile)(_.latestAggregatedProfile(_))
        .build

    def putPermissionRequest(
      actionGroup: Option[String] = None,
      principals: Option[List[Principal]] = None,
      profilingGroupName: Option[String] = None,
      revisionId: Option[String] = None
    ): PutPermissionRequest =
      PutPermissionRequest
        .builder
        .ifSome(actionGroup)(_.actionGroup(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def putPermissionResponse(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): PutPermissionResponse =
      PutPermissionResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def recommendation(
      allMatchesCount: Option[Int] = None,
      allMatchesSum: Option[Double] = None,
      endTime: Option[Timestamp] = None,
      pattern: Option[Pattern] = None,
      startTime: Option[Timestamp] = None,
      topMatches: Option[List[Match]] = None
    ): Recommendation =
      Recommendation
        .builder
        .ifSome(allMatchesCount)(_.allMatchesCount(_))
        .ifSome(allMatchesSum)(_.allMatchesSum(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(topMatches)(_.topMatches(_))
        .build

    def removeNotificationChannelRequest(
      channelId: Option[String] = None,
      profilingGroupName: Option[String] = None
    ): RemoveNotificationChannelRequest =
      RemoveNotificationChannelRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def removeNotificationChannelResponse(
      notificationConfiguration: Option[NotificationConfiguration] = None
    ): RemoveNotificationChannelResponse =
      RemoveNotificationChannelResponse
        .builder
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .build

    def removePermissionRequest(
      actionGroup: Option[String] = None,
      profilingGroupName: Option[String] = None,
      revisionId: Option[String] = None
    ): RemovePermissionRequest =
      RemovePermissionRequest
        .builder
        .ifSome(actionGroup)(_.actionGroup(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def removePermissionResponse(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): RemovePermissionResponse =
      RemovePermissionResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def submitFeedbackRequest(
      anomalyInstanceId: Option[String] = None,
      comment: Option[String] = None,
      profilingGroupName: Option[String] = None,
      `type`: Option[String] = None
    ): SubmitFeedbackRequest =
      SubmitFeedbackRequest
        .builder
        .ifSome(anomalyInstanceId)(_.anomalyInstanceId(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def submitFeedbackResponse(

    ): SubmitFeedbackResponse =
      SubmitFeedbackResponse
        .builder

        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagsMap] = None
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

    def timestampStructure(
      value: Option[Timestamp] = None
    ): TimestampStructure =
      TimestampStructure
        .builder
        .ifSome(value)(_.value(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
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

    def updateProfilingGroupRequest(
      agentOrchestrationConfig: Option[AgentOrchestrationConfig] = None,
      profilingGroupName: Option[String] = None
    ): UpdateProfilingGroupRequest =
      UpdateProfilingGroupRequest
        .builder
        .ifSome(agentOrchestrationConfig)(_.agentOrchestrationConfig(_))
        .ifSome(profilingGroupName)(_.profilingGroupName(_))
        .build

    def updateProfilingGroupResponse(
      profilingGroup: Option[ProfilingGroupDescription] = None
    ): UpdateProfilingGroupResponse =
      UpdateProfilingGroupResponse
        .builder
        .ifSome(profilingGroup)(_.profilingGroup(_))
        .build

    def userFeedback(
      `type`: Option[String] = None
    ): UserFeedback =
      UserFeedback
        .builder
        .ifSome(`type`)(_.`type`(_))
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
