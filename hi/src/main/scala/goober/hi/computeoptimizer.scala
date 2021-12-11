package goober.hi

import goober.free.computeoptimizer.ComputeOptimizerIO
import software.amazon.awssdk.services.computeoptimizer.model._


object computeoptimizer {
  import goober.free.{computeoptimizer ⇒ free}

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

    def autoScalingGroupConfiguration(
      desiredCapacity: Option[Int] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      instanceType: Option[String] = None
    ): AutoScalingGroupConfiguration =
      AutoScalingGroupConfiguration
        .builder
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(instanceType)(_.instanceType(_))
        .build

    def autoScalingGroupRecommendation(
      accountId: Option[String] = None,
      autoScalingGroupArn: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      finding: Option[String] = None,
      utilizationMetrics: Option[List[UtilizationMetric]] = None,
      lookBackPeriodInDays: Option[LookBackPeriodInDays] = None,
      currentConfiguration: Option[AutoScalingGroupConfiguration] = None,
      recommendationOptions: Option[List[AutoScalingGroupRecommendationOption]] = None,
      lastRefreshTimestamp: Option[LastRefreshTimestamp] = None
    ): AutoScalingGroupRecommendation =
      AutoScalingGroupRecommendation
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(autoScalingGroupArn)(_.autoScalingGroupArn(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(finding)(_.finding(_))
        .ifSome(utilizationMetrics)(_.utilizationMetrics(_))
        .ifSome(lookBackPeriodInDays)(_.lookBackPeriodInDays(_))
        .ifSome(currentConfiguration)(_.currentConfiguration(_))
        .ifSome(recommendationOptions)(_.recommendationOptions(_))
        .ifSome(lastRefreshTimestamp)(_.lastRefreshTimestamp(_))
        .build

    def autoScalingGroupRecommendationOption(
      configuration: Option[AutoScalingGroupConfiguration] = None,
      projectedUtilizationMetrics: Option[List[UtilizationMetric]] = None,
      performanceRisk: Option[PerformanceRisk] = None,
      rank: Option[Int] = None
    ): AutoScalingGroupRecommendationOption =
      AutoScalingGroupRecommendationOption
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(projectedUtilizationMetrics)(_.projectedUtilizationMetrics(_))
        .ifSome(performanceRisk)(_.performanceRisk(_))
        .ifSome(rank)(_.rank(_))
        .build

    def describeRecommendationExportJobsRequest(
      jobIds: Option[List[JobId]] = None,
      filters: Option[List[JobFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeRecommendationExportJobsRequest =
      DescribeRecommendationExportJobsRequest
        .builder
        .ifSome(jobIds)(_.jobIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeRecommendationExportJobsResponse(
      recommendationExportJobs: Option[List[RecommendationExportJob]] = None,
      nextToken: Option[String] = None
    ): DescribeRecommendationExportJobsResponse =
      DescribeRecommendationExportJobsResponse
        .builder
        .ifSome(recommendationExportJobs)(_.recommendationExportJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def eBSFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): EBSFilter =
      EBSFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def eBSUtilizationMetric(
      name: Option[String] = None,
      statistic: Option[String] = None,
      value: Option[MetricValue] = None
    ): EBSUtilizationMetric =
      EBSUtilizationMetric
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(value)(_.value(_))
        .build

    def exportAutoScalingGroupRecommendationsRequest(
      accountIds: Option[List[AccountId]] = None,
      filters: Option[List[Filter]] = None,
      fieldsToExport: Option[List[ExportableAutoScalingGroupField]] = None,
      s3DestinationConfig: Option[S3DestinationConfig] = None,
      fileFormat: Option[String] = None,
      includeMemberAccounts: Option[Boolean] = None
    ): ExportAutoScalingGroupRecommendationsRequest =
      ExportAutoScalingGroupRecommendationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(fieldsToExport)(_.fieldsToExport(_))
        .ifSome(s3DestinationConfig)(_.s3DestinationConfig(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(includeMemberAccounts)(_.includeMemberAccounts(_))
        .build

    def exportAutoScalingGroupRecommendationsResponse(
      jobId: Option[String] = None,
      s3Destination: Option[S3Destination] = None
    ): ExportAutoScalingGroupRecommendationsResponse =
      ExportAutoScalingGroupRecommendationsResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .build

    def exportDestination(
      s3: Option[S3Destination] = None
    ): ExportDestination =
      ExportDestination
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def exportEBSVolumeRecommendationsRequest(
      accountIds: Option[List[AccountId]] = None,
      filters: Option[List[EBSFilter]] = None,
      fieldsToExport: Option[List[ExportableVolumeField]] = None,
      s3DestinationConfig: Option[S3DestinationConfig] = None,
      fileFormat: Option[String] = None,
      includeMemberAccounts: Option[Boolean] = None
    ): ExportEBSVolumeRecommendationsRequest =
      ExportEBSVolumeRecommendationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(fieldsToExport)(_.fieldsToExport(_))
        .ifSome(s3DestinationConfig)(_.s3DestinationConfig(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(includeMemberAccounts)(_.includeMemberAccounts(_))
        .build

    def exportEBSVolumeRecommendationsResponse(
      jobId: Option[String] = None,
      s3Destination: Option[S3Destination] = None
    ): ExportEBSVolumeRecommendationsResponse =
      ExportEBSVolumeRecommendationsResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .build

    def exportEC2InstanceRecommendationsRequest(
      accountIds: Option[List[AccountId]] = None,
      filters: Option[List[Filter]] = None,
      fieldsToExport: Option[List[ExportableInstanceField]] = None,
      s3DestinationConfig: Option[S3DestinationConfig] = None,
      fileFormat: Option[String] = None,
      includeMemberAccounts: Option[Boolean] = None
    ): ExportEC2InstanceRecommendationsRequest =
      ExportEC2InstanceRecommendationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(fieldsToExport)(_.fieldsToExport(_))
        .ifSome(s3DestinationConfig)(_.s3DestinationConfig(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(includeMemberAccounts)(_.includeMemberAccounts(_))
        .build

    def exportEC2InstanceRecommendationsResponse(
      jobId: Option[String] = None,
      s3Destination: Option[S3Destination] = None
    ): ExportEC2InstanceRecommendationsResponse =
      ExportEC2InstanceRecommendationsResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .build

    def exportLambdaFunctionRecommendationsRequest(
      accountIds: Option[List[AccountId]] = None,
      filters: Option[List[LambdaFunctionRecommendationFilter]] = None,
      fieldsToExport: Option[List[ExportableLambdaFunctionField]] = None,
      s3DestinationConfig: Option[S3DestinationConfig] = None,
      fileFormat: Option[String] = None,
      includeMemberAccounts: Option[Boolean] = None
    ): ExportLambdaFunctionRecommendationsRequest =
      ExportLambdaFunctionRecommendationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(fieldsToExport)(_.fieldsToExport(_))
        .ifSome(s3DestinationConfig)(_.s3DestinationConfig(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(includeMemberAccounts)(_.includeMemberAccounts(_))
        .build

    def exportLambdaFunctionRecommendationsResponse(
      jobId: Option[String] = None,
      s3Destination: Option[S3Destination] = None
    ): ExportLambdaFunctionRecommendationsResponse =
      ExportLambdaFunctionRecommendationsResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def getAutoScalingGroupRecommendationsRequest(
      accountIds: Option[List[AccountId]] = None,
      autoScalingGroupArns: Option[List[AutoScalingGroupArn]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): GetAutoScalingGroupRecommendationsRequest =
      GetAutoScalingGroupRecommendationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(autoScalingGroupArns)(_.autoScalingGroupArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def getAutoScalingGroupRecommendationsResponse(
      nextToken: Option[String] = None,
      autoScalingGroupRecommendations: Option[List[AutoScalingGroupRecommendation]] = None,
      errors: Option[List[GetRecommendationError]] = None
    ): GetAutoScalingGroupRecommendationsResponse =
      GetAutoScalingGroupRecommendationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(autoScalingGroupRecommendations)(_.autoScalingGroupRecommendations(_))
        .ifSome(errors)(_.errors(_))
        .build

    def getEBSVolumeRecommendationsRequest(
      volumeArns: Option[List[VolumeArn]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[EBSFilter]] = None,
      accountIds: Option[List[AccountId]] = None
    ): GetEBSVolumeRecommendationsRequest =
      GetEBSVolumeRecommendationsRequest
        .builder
        .ifSome(volumeArns)(_.volumeArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def getEBSVolumeRecommendationsResponse(
      nextToken: Option[String] = None,
      volumeRecommendations: Option[List[VolumeRecommendation]] = None,
      errors: Option[List[GetRecommendationError]] = None
    ): GetEBSVolumeRecommendationsResponse =
      GetEBSVolumeRecommendationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(volumeRecommendations)(_.volumeRecommendations(_))
        .ifSome(errors)(_.errors(_))
        .build

    def getEC2InstanceRecommendationsRequest(
      instanceArns: Option[List[InstanceArn]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None,
      accountIds: Option[List[AccountId]] = None
    ): GetEC2InstanceRecommendationsRequest =
      GetEC2InstanceRecommendationsRequest
        .builder
        .ifSome(instanceArns)(_.instanceArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def getEC2InstanceRecommendationsResponse(
      nextToken: Option[String] = None,
      instanceRecommendations: Option[List[InstanceRecommendation]] = None,
      errors: Option[List[GetRecommendationError]] = None
    ): GetEC2InstanceRecommendationsResponse =
      GetEC2InstanceRecommendationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(instanceRecommendations)(_.instanceRecommendations(_))
        .ifSome(errors)(_.errors(_))
        .build

    def getEC2RecommendationProjectedMetricsRequest(
      instanceArn: Option[String] = None,
      stat: Option[String] = None,
      period: Option[Int] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): GetEC2RecommendationProjectedMetricsRequest =
      GetEC2RecommendationProjectedMetricsRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(stat)(_.stat(_))
        .ifSome(period)(_.period(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def getEC2RecommendationProjectedMetricsResponse(
      recommendedOptionProjectedMetrics: Option[List[RecommendedOptionProjectedMetric]] = None
    ): GetEC2RecommendationProjectedMetricsResponse =
      GetEC2RecommendationProjectedMetricsResponse
        .builder
        .ifSome(recommendedOptionProjectedMetrics)(_.recommendedOptionProjectedMetrics(_))
        .build

    def getEnrollmentStatusRequest(

    ): GetEnrollmentStatusRequest =
      GetEnrollmentStatusRequest
        .builder

        .build

    def getEnrollmentStatusResponse(
      status: Option[String] = None,
      statusReason: Option[String] = None,
      memberAccountsEnrolled: Option[Boolean] = None
    ): GetEnrollmentStatusResponse =
      GetEnrollmentStatusResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(memberAccountsEnrolled)(_.memberAccountsEnrolled(_))
        .build

    def getLambdaFunctionRecommendationsRequest(
      functionArns: Option[List[FunctionArn]] = None,
      accountIds: Option[List[AccountId]] = None,
      filters: Option[List[LambdaFunctionRecommendationFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetLambdaFunctionRecommendationsRequest =
      GetLambdaFunctionRecommendationsRequest
        .builder
        .ifSome(functionArns)(_.functionArns(_))
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getLambdaFunctionRecommendationsResponse(
      nextToken: Option[String] = None,
      lambdaFunctionRecommendations: Option[List[LambdaFunctionRecommendation]] = None
    ): GetLambdaFunctionRecommendationsResponse =
      GetLambdaFunctionRecommendationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(lambdaFunctionRecommendations)(_.lambdaFunctionRecommendations(_))
        .build

    def getRecommendationError(
      identifier: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): GetRecommendationError =
      GetRecommendationError
        .builder
        .ifSome(identifier)(_.identifier(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def getRecommendationSummariesRequest(
      accountIds: Option[List[AccountId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetRecommendationSummariesRequest =
      GetRecommendationSummariesRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getRecommendationSummariesResponse(
      nextToken: Option[String] = None,
      recommendationSummaries: Option[List[RecommendationSummary]] = None
    ): GetRecommendationSummariesResponse =
      GetRecommendationSummariesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(recommendationSummaries)(_.recommendationSummaries(_))
        .build

    def instanceRecommendation(
      instanceArn: Option[String] = None,
      accountId: Option[String] = None,
      instanceName: Option[String] = None,
      currentInstanceType: Option[String] = None,
      finding: Option[String] = None,
      findingReasonCodes: Option[List[InstanceRecommendationFindingReasonCode]] = None,
      utilizationMetrics: Option[List[UtilizationMetric]] = None,
      lookBackPeriodInDays: Option[LookBackPeriodInDays] = None,
      recommendationOptions: Option[List[InstanceRecommendationOption]] = None,
      recommendationSources: Option[List[RecommendationSource]] = None,
      lastRefreshTimestamp: Option[LastRefreshTimestamp] = None
    ): InstanceRecommendation =
      InstanceRecommendation
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(currentInstanceType)(_.currentInstanceType(_))
        .ifSome(finding)(_.finding(_))
        .ifSome(findingReasonCodes)(_.findingReasonCodes(_))
        .ifSome(utilizationMetrics)(_.utilizationMetrics(_))
        .ifSome(lookBackPeriodInDays)(_.lookBackPeriodInDays(_))
        .ifSome(recommendationOptions)(_.recommendationOptions(_))
        .ifSome(recommendationSources)(_.recommendationSources(_))
        .ifSome(lastRefreshTimestamp)(_.lastRefreshTimestamp(_))
        .build

    def instanceRecommendationOption(
      instanceType: Option[String] = None,
      projectedUtilizationMetrics: Option[List[UtilizationMetric]] = None,
      platformDifferences: Option[List[PlatformDifference]] = None,
      performanceRisk: Option[PerformanceRisk] = None,
      rank: Option[Int] = None
    ): InstanceRecommendationOption =
      InstanceRecommendationOption
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(projectedUtilizationMetrics)(_.projectedUtilizationMetrics(_))
        .ifSome(platformDifferences)(_.platformDifferences(_))
        .ifSome(performanceRisk)(_.performanceRisk(_))
        .ifSome(rank)(_.rank(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
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

    def jobFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): JobFilter =
      JobFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def lambdaFunctionMemoryProjectedMetric(
      name: Option[String] = None,
      statistic: Option[String] = None,
      value: Option[MetricValue] = None
    ): LambdaFunctionMemoryProjectedMetric =
      LambdaFunctionMemoryProjectedMetric
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(value)(_.value(_))
        .build

    def lambdaFunctionMemoryRecommendationOption(
      rank: Option[Int] = None,
      memorySize: Option[Int] = None,
      projectedUtilizationMetrics: Option[List[LambdaFunctionMemoryProjectedMetric]] = None
    ): LambdaFunctionMemoryRecommendationOption =
      LambdaFunctionMemoryRecommendationOption
        .builder
        .ifSome(rank)(_.rank(_))
        .ifSome(memorySize)(_.memorySize(_))
        .ifSome(projectedUtilizationMetrics)(_.projectedUtilizationMetrics(_))
        .build

    def lambdaFunctionRecommendation(
      functionArn: Option[String] = None,
      functionVersion: Option[String] = None,
      accountId: Option[String] = None,
      currentMemorySize: Option[Int] = None,
      numberOfInvocations: Option[NumberOfInvocations] = None,
      utilizationMetrics: Option[List[LambdaFunctionUtilizationMetric]] = None,
      lookbackPeriodInDays: Option[LookBackPeriodInDays] = None,
      lastRefreshTimestamp: Option[LastRefreshTimestamp] = None,
      finding: Option[String] = None,
      findingReasonCodes: Option[List[LambdaFunctionRecommendationFindingReasonCode]] = None,
      memorySizeRecommendationOptions: Option[List[LambdaFunctionMemoryRecommendationOption]] = None
    ): LambdaFunctionRecommendation =
      LambdaFunctionRecommendation
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(currentMemorySize)(_.currentMemorySize(_))
        .ifSome(numberOfInvocations)(_.numberOfInvocations(_))
        .ifSome(utilizationMetrics)(_.utilizationMetrics(_))
        .ifSome(lookbackPeriodInDays)(_.lookbackPeriodInDays(_))
        .ifSome(lastRefreshTimestamp)(_.lastRefreshTimestamp(_))
        .ifSome(finding)(_.finding(_))
        .ifSome(findingReasonCodes)(_.findingReasonCodes(_))
        .ifSome(memorySizeRecommendationOptions)(_.memorySizeRecommendationOptions(_))
        .build

    def lambdaFunctionRecommendationFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): LambdaFunctionRecommendationFilter =
      LambdaFunctionRecommendationFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def lambdaFunctionUtilizationMetric(
      name: Option[String] = None,
      statistic: Option[String] = None,
      value: Option[MetricValue] = None
    ): LambdaFunctionUtilizationMetric =
      LambdaFunctionUtilizationMetric
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(value)(_.value(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def missingAuthenticationToken(
      message: Option[String] = None
    ): MissingAuthenticationToken =
      MissingAuthenticationToken
        .builder
        .ifSome(message)(_.message(_))
        .build

    def optInRequiredException(
      message: Option[String] = None
    ): OptInRequiredException =
      OptInRequiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def projectedMetric(
      name: Option[String] = None,
      timestamps: Option[List[Timestamp]] = None,
      values: Option[List[MetricValue]] = None
    ): ProjectedMetric =
      ProjectedMetric
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(timestamps)(_.timestamps(_))
        .ifSome(values)(_.values(_))
        .build

    def reasonCodeSummary(
      name: Option[String] = None,
      value: Option[SummaryValue] = None
    ): ReasonCodeSummary =
      ReasonCodeSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def recommendationExportJob(
      jobId: Option[String] = None,
      destination: Option[ExportDestination] = None,
      resourceType: Option[String] = None,
      status: Option[String] = None,
      creationTimestamp: Option[CreationTimestamp] = None,
      lastUpdatedTimestamp: Option[LastUpdatedTimestamp] = None,
      failureReason: Option[String] = None
    ): RecommendationExportJob =
      RecommendationExportJob
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def recommendationSource(
      recommendationSourceArn: Option[String] = None,
      recommendationSourceType: Option[String] = None
    ): RecommendationSource =
      RecommendationSource
        .builder
        .ifSome(recommendationSourceArn)(_.recommendationSourceArn(_))
        .ifSome(recommendationSourceType)(_.recommendationSourceType(_))
        .build

    def recommendationSummary(
      summaries: Option[List[Summary]] = None,
      recommendationResourceType: Option[String] = None,
      accountId: Option[String] = None
    ): RecommendationSummary =
      RecommendationSummary
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(recommendationResourceType)(_.recommendationResourceType(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def recommendedOptionProjectedMetric(
      recommendedInstanceType: Option[String] = None,
      rank: Option[Int] = None,
      projectedMetrics: Option[List[ProjectedMetric]] = None
    ): RecommendedOptionProjectedMetric =
      RecommendedOptionProjectedMetric
        .builder
        .ifSome(recommendedInstanceType)(_.recommendedInstanceType(_))
        .ifSome(rank)(_.rank(_))
        .ifSome(projectedMetrics)(_.projectedMetrics(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3Destination(
      bucket: Option[String] = None,
      key: Option[String] = None,
      metadataKey: Option[String] = None
    ): S3Destination =
      S3Destination
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(metadataKey)(_.metadataKey(_))
        .build

    def s3DestinationConfig(
      bucket: Option[String] = None,
      keyPrefix: Option[String] = None
    ): S3DestinationConfig =
      S3DestinationConfig
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyPrefix)(_.keyPrefix(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def summary(
      name: Option[String] = None,
      value: Option[SummaryValue] = None,
      reasonCodeSummaries: Option[List[ReasonCodeSummary]] = None
    ): Summary =
      Summary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(reasonCodeSummaries)(_.reasonCodeSummaries(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateEnrollmentStatusRequest(
      status: Option[String] = None,
      includeMemberAccounts: Option[Boolean] = None
    ): UpdateEnrollmentStatusRequest =
      UpdateEnrollmentStatusRequest
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(includeMemberAccounts)(_.includeMemberAccounts(_))
        .build

    def updateEnrollmentStatusResponse(
      status: Option[String] = None,
      statusReason: Option[String] = None
    ): UpdateEnrollmentStatusResponse =
      UpdateEnrollmentStatusResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .build

    def utilizationMetric(
      name: Option[String] = None,
      statistic: Option[String] = None,
      value: Option[MetricValue] = None
    ): UtilizationMetric =
      UtilizationMetric
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(value)(_.value(_))
        .build

    def volumeConfiguration(
      volumeType: Option[String] = None,
      volumeSize: Option[Int] = None,
      volumeBaselineIOPS: Option[Int] = None,
      volumeBurstIOPS: Option[Int] = None,
      volumeBaselineThroughput: Option[Int] = None,
      volumeBurstThroughput: Option[Int] = None
    ): VolumeConfiguration =
      VolumeConfiguration
        .builder
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeBaselineIOPS)(_.volumeBaselineIOPS(_))
        .ifSome(volumeBurstIOPS)(_.volumeBurstIOPS(_))
        .ifSome(volumeBaselineThroughput)(_.volumeBaselineThroughput(_))
        .ifSome(volumeBurstThroughput)(_.volumeBurstThroughput(_))
        .build

    def volumeRecommendation(
      volumeArn: Option[String] = None,
      accountId: Option[String] = None,
      currentConfiguration: Option[VolumeConfiguration] = None,
      finding: Option[String] = None,
      utilizationMetrics: Option[List[EBSUtilizationMetric]] = None,
      lookBackPeriodInDays: Option[LookBackPeriodInDays] = None,
      volumeRecommendationOptions: Option[List[VolumeRecommendationOption]] = None,
      lastRefreshTimestamp: Option[LastRefreshTimestamp] = None
    ): VolumeRecommendation =
      VolumeRecommendation
        .builder
        .ifSome(volumeArn)(_.volumeArn(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(currentConfiguration)(_.currentConfiguration(_))
        .ifSome(finding)(_.finding(_))
        .ifSome(utilizationMetrics)(_.utilizationMetrics(_))
        .ifSome(lookBackPeriodInDays)(_.lookBackPeriodInDays(_))
        .ifSome(volumeRecommendationOptions)(_.volumeRecommendationOptions(_))
        .ifSome(lastRefreshTimestamp)(_.lastRefreshTimestamp(_))
        .build

    def volumeRecommendationOption(
      configuration: Option[VolumeConfiguration] = None,
      performanceRisk: Option[PerformanceRisk] = None,
      rank: Option[Int] = None
    ): VolumeRecommendationOption =
      VolumeRecommendationOption
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(performanceRisk)(_.performanceRisk(_))
        .ifSome(rank)(_.rank(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
