package goober.hi

import goober.free.autoscalingplans.AutoScalingPlansIO
import software.amazon.awssdk.services.autoscalingplans.model._


object autoscalingplans {
  import goober.free.{autoscalingplans ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def applicationSource(
      cloudFormationStackARN: Option[String] = None,
      tagFilters: Option[List[TagFilter]] = None
    ): ApplicationSource =
      ApplicationSource
        .builder
        .ifSome(cloudFormationStackARN)(_.cloudFormationStackARN(_))
        .ifSome(tagFilters)(_.tagFilters(_))
        .build

    def concurrentUpdateException(
      message: Option[String] = None
    ): ConcurrentUpdateException =
      ConcurrentUpdateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createScalingPlanRequest(
      scalingPlanName: Option[String] = None,
      applicationSource: Option[ApplicationSource] = None,
      scalingInstructions: Option[List[ScalingInstruction]] = None
    ): CreateScalingPlanRequest =
      CreateScalingPlanRequest
        .builder
        .ifSome(scalingPlanName)(_.scalingPlanName(_))
        .ifSome(applicationSource)(_.applicationSource(_))
        .ifSome(scalingInstructions)(_.scalingInstructions(_))
        .build

    def createScalingPlanResponse(
      scalingPlanVersion: Option[ScalingPlanVersion] = None
    ): CreateScalingPlanResponse =
      CreateScalingPlanResponse
        .builder
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .build

    def customizedLoadMetricSpecification(
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      dimensions: Option[List[MetricDimension]] = None,
      statistic: Option[String] = None,
      unit: Option[String] = None
    ): CustomizedLoadMetricSpecification =
      CustomizedLoadMetricSpecification
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(unit)(_.unit(_))
        .build

    def customizedScalingMetricSpecification(
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      dimensions: Option[List[MetricDimension]] = None,
      statistic: Option[String] = None,
      unit: Option[String] = None
    ): CustomizedScalingMetricSpecification =
      CustomizedScalingMetricSpecification
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(unit)(_.unit(_))
        .build

    def datapoint(
      timestamp: Option[TimestampType] = None,
      value: Option[MetricScale] = None
    ): Datapoint =
      Datapoint
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(value)(_.value(_))
        .build

    def deleteScalingPlanRequest(
      scalingPlanName: Option[String] = None,
      scalingPlanVersion: Option[ScalingPlanVersion] = None
    ): DeleteScalingPlanRequest =
      DeleteScalingPlanRequest
        .builder
        .ifSome(scalingPlanName)(_.scalingPlanName(_))
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .build

    def deleteScalingPlanResponse(

    ): DeleteScalingPlanResponse =
      DeleteScalingPlanResponse
        .builder

        .build

    def describeScalingPlanResourcesRequest(
      scalingPlanName: Option[String] = None,
      scalingPlanVersion: Option[ScalingPlanVersion] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScalingPlanResourcesRequest =
      DescribeScalingPlanResourcesRequest
        .builder
        .ifSome(scalingPlanName)(_.scalingPlanName(_))
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalingPlanResourcesResponse(
      scalingPlanResources: Option[List[ScalingPlanResource]] = None,
      nextToken: Option[String] = None
    ): DescribeScalingPlanResourcesResponse =
      DescribeScalingPlanResourcesResponse
        .builder
        .ifSome(scalingPlanResources)(_.scalingPlanResources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalingPlansRequest(
      scalingPlanNames: Option[List[ScalingPlanName]] = None,
      scalingPlanVersion: Option[ScalingPlanVersion] = None,
      applicationSources: Option[List[ApplicationSource]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScalingPlansRequest =
      DescribeScalingPlansRequest
        .builder
        .ifSome(scalingPlanNames)(_.scalingPlanNames(_))
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .ifSome(applicationSources)(_.applicationSources(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalingPlansResponse(
      scalingPlans: Option[List[ScalingPlan]] = None,
      nextToken: Option[String] = None
    ): DescribeScalingPlansResponse =
      DescribeScalingPlansResponse
        .builder
        .ifSome(scalingPlans)(_.scalingPlans(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getScalingPlanResourceForecastDataRequest(
      scalingPlanName: Option[String] = None,
      scalingPlanVersion: Option[ScalingPlanVersion] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      forecastDataType: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None
    ): GetScalingPlanResourceForecastDataRequest =
      GetScalingPlanResourceForecastDataRequest
        .builder
        .ifSome(scalingPlanName)(_.scalingPlanName(_))
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(forecastDataType)(_.forecastDataType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def getScalingPlanResourceForecastDataResponse(
      datapoints: Option[List[Datapoint]] = None
    ): GetScalingPlanResourceForecastDataResponse =
      GetScalingPlanResourceForecastDataResponse
        .builder
        .ifSome(datapoints)(_.datapoints(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def metricDimension(
      name: Option[String] = None,
      value: Option[String] = None
    ): MetricDimension =
      MetricDimension
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def objectNotFoundException(
      message: Option[String] = None
    ): ObjectNotFoundException =
      ObjectNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def predefinedLoadMetricSpecification(
      predefinedLoadMetricType: Option[String] = None,
      resourceLabel: Option[String] = None
    ): PredefinedLoadMetricSpecification =
      PredefinedLoadMetricSpecification
        .builder
        .ifSome(predefinedLoadMetricType)(_.predefinedLoadMetricType(_))
        .ifSome(resourceLabel)(_.resourceLabel(_))
        .build

    def predefinedScalingMetricSpecification(
      predefinedScalingMetricType: Option[String] = None,
      resourceLabel: Option[String] = None
    ): PredefinedScalingMetricSpecification =
      PredefinedScalingMetricSpecification
        .builder
        .ifSome(predefinedScalingMetricType)(_.predefinedScalingMetricType(_))
        .ifSome(resourceLabel)(_.resourceLabel(_))
        .build

    def scalingInstruction(
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      minCapacity: Option[Int] = None,
      maxCapacity: Option[Int] = None,
      targetTrackingConfigurations: Option[List[TargetTrackingConfiguration]] = None,
      predefinedLoadMetricSpecification: Option[PredefinedLoadMetricSpecification] = None,
      customizedLoadMetricSpecification: Option[CustomizedLoadMetricSpecification] = None,
      scheduledActionBufferTime: Option[Int] = None,
      predictiveScalingMaxCapacityBehavior: Option[String] = None,
      predictiveScalingMaxCapacityBuffer: Option[Int] = None,
      predictiveScalingMode: Option[String] = None,
      scalingPolicyUpdateBehavior: Option[String] = None,
      disableDynamicScaling: Option[Boolean] = None
    ): ScalingInstruction =
      ScalingInstruction
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(minCapacity)(_.minCapacity(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(targetTrackingConfigurations)(_.targetTrackingConfigurations(_))
        .ifSome(predefinedLoadMetricSpecification)(_.predefinedLoadMetricSpecification(_))
        .ifSome(customizedLoadMetricSpecification)(_.customizedLoadMetricSpecification(_))
        .ifSome(scheduledActionBufferTime)(_.scheduledActionBufferTime(_))
        .ifSome(predictiveScalingMaxCapacityBehavior)(_.predictiveScalingMaxCapacityBehavior(_))
        .ifSome(predictiveScalingMaxCapacityBuffer)(_.predictiveScalingMaxCapacityBuffer(_))
        .ifSome(predictiveScalingMode)(_.predictiveScalingMode(_))
        .ifSome(scalingPolicyUpdateBehavior)(_.scalingPolicyUpdateBehavior(_))
        .ifSome(disableDynamicScaling)(_.disableDynamicScaling(_))
        .build

    def scalingPlan(
      scalingPlanName: Option[String] = None,
      scalingPlanVersion: Option[ScalingPlanVersion] = None,
      applicationSource: Option[ApplicationSource] = None,
      scalingInstructions: Option[List[ScalingInstruction]] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      statusStartTime: Option[TimestampType] = None,
      creationTime: Option[TimestampType] = None
    ): ScalingPlan =
      ScalingPlan
        .builder
        .ifSome(scalingPlanName)(_.scalingPlanName(_))
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .ifSome(applicationSource)(_.applicationSource(_))
        .ifSome(scalingInstructions)(_.scalingInstructions(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(statusStartTime)(_.statusStartTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def scalingPlanResource(
      scalingPlanName: Option[String] = None,
      scalingPlanVersion: Option[ScalingPlanVersion] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      scalingPolicies: Option[List[ScalingPolicy]] = None,
      scalingStatusCode: Option[String] = None,
      scalingStatusMessage: Option[String] = None
    ): ScalingPlanResource =
      ScalingPlanResource
        .builder
        .ifSome(scalingPlanName)(_.scalingPlanName(_))
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(scalingPolicies)(_.scalingPolicies(_))
        .ifSome(scalingStatusCode)(_.scalingStatusCode(_))
        .ifSome(scalingStatusMessage)(_.scalingStatusMessage(_))
        .build

    def scalingPolicy(
      policyName: Option[String] = None,
      policyType: Option[String] = None,
      targetTrackingConfiguration: Option[TargetTrackingConfiguration] = None
    ): ScalingPolicy =
      ScalingPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(targetTrackingConfiguration)(_.targetTrackingConfiguration(_))
        .build

    def tagFilter(
      key: Option[String] = None,
      values: Option[List[XmlStringMaxLen256]] = None
    ): TagFilter =
      TagFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def targetTrackingConfiguration(
      predefinedScalingMetricSpecification: Option[PredefinedScalingMetricSpecification] = None,
      customizedScalingMetricSpecification: Option[CustomizedScalingMetricSpecification] = None,
      targetValue: Option[MetricScale] = None,
      disableScaleIn: Option[Boolean] = None,
      scaleOutCooldown: Option[Int] = None,
      scaleInCooldown: Option[Int] = None,
      estimatedInstanceWarmup: Option[Int] = None
    ): TargetTrackingConfiguration =
      TargetTrackingConfiguration
        .builder
        .ifSome(predefinedScalingMetricSpecification)(_.predefinedScalingMetricSpecification(_))
        .ifSome(customizedScalingMetricSpecification)(_.customizedScalingMetricSpecification(_))
        .ifSome(targetValue)(_.targetValue(_))
        .ifSome(disableScaleIn)(_.disableScaleIn(_))
        .ifSome(scaleOutCooldown)(_.scaleOutCooldown(_))
        .ifSome(scaleInCooldown)(_.scaleInCooldown(_))
        .ifSome(estimatedInstanceWarmup)(_.estimatedInstanceWarmup(_))
        .build

    def updateScalingPlanRequest(
      scalingPlanName: Option[String] = None,
      scalingPlanVersion: Option[ScalingPlanVersion] = None,
      applicationSource: Option[ApplicationSource] = None,
      scalingInstructions: Option[List[ScalingInstruction]] = None
    ): UpdateScalingPlanRequest =
      UpdateScalingPlanRequest
        .builder
        .ifSome(scalingPlanName)(_.scalingPlanName(_))
        .ifSome(scalingPlanVersion)(_.scalingPlanVersion(_))
        .ifSome(applicationSource)(_.applicationSource(_))
        .ifSome(scalingInstructions)(_.scalingInstructions(_))
        .build

    def updateScalingPlanResponse(

    ): UpdateScalingPlanResponse =
      UpdateScalingPlanResponse
        .builder

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
