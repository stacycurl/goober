package goober.hi

import goober.free.applicationautoscaling.ApplicationAutoScalingIO
import software.amazon.awssdk.services.applicationautoscaling.model._


object applicationautoscaling {
  import goober.free.{applicationautoscaling ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def alarm(
      alarmName: Option[String] = None,
      alarmARN: Option[String] = None
    ): Alarm =
      Alarm
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmARN)(_.alarmARN(_))
        .build

    def concurrentUpdateException(
      message: Option[String] = None
    ): ConcurrentUpdateException =
      ConcurrentUpdateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def customizedMetricSpecification(
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      dimensions: Option[List[MetricDimension]] = None,
      statistic: Option[String] = None,
      unit: Option[String] = None
    ): CustomizedMetricSpecification =
      CustomizedMetricSpecification
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(unit)(_.unit(_))
        .build

    def deleteScalingPolicyRequest(
      policyName: Option[String] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None
    ): DeleteScalingPolicyRequest =
      DeleteScalingPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .build

    def deleteScalingPolicyResponse(

    ): DeleteScalingPolicyResponse =
      DeleteScalingPolicyResponse
        .builder

        .build

    def deleteScheduledActionRequest(
      serviceNamespace: Option[String] = None,
      scheduledActionName: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None
    ): DeleteScheduledActionRequest =
      DeleteScheduledActionRequest
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .build

    def deleteScheduledActionResponse(

    ): DeleteScheduledActionResponse =
      DeleteScheduledActionResponse
        .builder

        .build

    def deregisterScalableTargetRequest(
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None
    ): DeregisterScalableTargetRequest =
      DeregisterScalableTargetRequest
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .build

    def deregisterScalableTargetResponse(

    ): DeregisterScalableTargetResponse =
      DeregisterScalableTargetResponse
        .builder

        .build

    def describeScalableTargetsRequest(
      serviceNamespace: Option[String] = None,
      resourceIds: Option[List[ResourceIdMaxLen1600]] = None,
      scalableDimension: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScalableTargetsRequest =
      DescribeScalableTargetsRequest
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalableTargetsResponse(
      scalableTargets: Option[List[ScalableTarget]] = None,
      nextToken: Option[String] = None
    ): DescribeScalableTargetsResponse =
      DescribeScalableTargetsResponse
        .builder
        .ifSome(scalableTargets)(_.scalableTargets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalingActivitiesRequest(
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScalingActivitiesRequest =
      DescribeScalingActivitiesRequest
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalingActivitiesResponse(
      scalingActivities: Option[List[ScalingActivity]] = None,
      nextToken: Option[String] = None
    ): DescribeScalingActivitiesResponse =
      DescribeScalingActivitiesResponse
        .builder
        .ifSome(scalingActivities)(_.scalingActivities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalingPoliciesRequest(
      policyNames: Option[List[ResourceIdMaxLen1600]] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScalingPoliciesRequest =
      DescribeScalingPoliciesRequest
        .builder
        .ifSome(policyNames)(_.policyNames(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScalingPoliciesResponse(
      scalingPolicies: Option[List[ScalingPolicy]] = None,
      nextToken: Option[String] = None
    ): DescribeScalingPoliciesResponse =
      DescribeScalingPoliciesResponse
        .builder
        .ifSome(scalingPolicies)(_.scalingPolicies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScheduledActionsRequest(
      scheduledActionNames: Option[List[ResourceIdMaxLen1600]] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScheduledActionsRequest =
      DescribeScheduledActionsRequest
        .builder
        .ifSome(scheduledActionNames)(_.scheduledActionNames(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScheduledActionsResponse(
      scheduledActions: Option[List[ScheduledAction]] = None,
      nextToken: Option[String] = None
    ): DescribeScheduledActionsResponse =
      DescribeScheduledActionsResponse
        .builder
        .ifSome(scheduledActions)(_.scheduledActions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def failedResourceAccessException(
      message: Option[String] = None
    ): FailedResourceAccessException =
      FailedResourceAccessException
        .builder
        .ifSome(message)(_.message(_))
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

    def predefinedMetricSpecification(
      predefinedMetricType: Option[String] = None,
      resourceLabel: Option[String] = None
    ): PredefinedMetricSpecification =
      PredefinedMetricSpecification
        .builder
        .ifSome(predefinedMetricType)(_.predefinedMetricType(_))
        .ifSome(resourceLabel)(_.resourceLabel(_))
        .build

    def putScalingPolicyRequest(
      policyName: Option[String] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      policyType: Option[String] = None,
      stepScalingPolicyConfiguration: Option[StepScalingPolicyConfiguration] = None,
      targetTrackingScalingPolicyConfiguration: Option[TargetTrackingScalingPolicyConfiguration] = None
    ): PutScalingPolicyRequest =
      PutScalingPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(stepScalingPolicyConfiguration)(_.stepScalingPolicyConfiguration(_))
        .ifSome(targetTrackingScalingPolicyConfiguration)(_.targetTrackingScalingPolicyConfiguration(_))
        .build

    def putScalingPolicyResponse(
      policyARN: Option[String] = None,
      alarms: Option[List[Alarm]] = None
    ): PutScalingPolicyResponse =
      PutScalingPolicyResponse
        .builder
        .ifSome(policyARN)(_.policyARN(_))
        .ifSome(alarms)(_.alarms(_))
        .build

    def putScheduledActionRequest(
      serviceNamespace: Option[String] = None,
      schedule: Option[String] = None,
      timezone: Option[String] = None,
      scheduledActionName: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      scalableTargetAction: Option[ScalableTargetAction] = None
    ): PutScheduledActionRequest =
      PutScheduledActionRequest
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(scalableTargetAction)(_.scalableTargetAction(_))
        .build

    def putScheduledActionResponse(

    ): PutScheduledActionResponse =
      PutScheduledActionResponse
        .builder

        .build

    def registerScalableTargetRequest(
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      minCapacity: Option[Int] = None,
      maxCapacity: Option[Int] = None,
      roleARN: Option[String] = None,
      suspendedState: Option[SuspendedState] = None
    ): RegisterScalableTargetRequest =
      RegisterScalableTargetRequest
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(minCapacity)(_.minCapacity(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(suspendedState)(_.suspendedState(_))
        .build

    def registerScalableTargetResponse(

    ): RegisterScalableTargetResponse =
      RegisterScalableTargetResponse
        .builder

        .build

    def scalableTarget(
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      minCapacity: Option[Int] = None,
      maxCapacity: Option[Int] = None,
      roleARN: Option[String] = None,
      creationTime: Option[TimestampType] = None,
      suspendedState: Option[SuspendedState] = None
    ): ScalableTarget =
      ScalableTarget
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(minCapacity)(_.minCapacity(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(suspendedState)(_.suspendedState(_))
        .build

    def scalableTargetAction(
      minCapacity: Option[Int] = None,
      maxCapacity: Option[Int] = None
    ): ScalableTargetAction =
      ScalableTargetAction
        .builder
        .ifSome(minCapacity)(_.minCapacity(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .build

    def scalingActivity(
      activityId: Option[String] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      description: Option[String] = None,
      cause: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      details: Option[String] = None
    ): ScalingActivity =
      ScalingActivity
        .builder
        .ifSome(activityId)(_.activityId(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(description)(_.description(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(details)(_.details(_))
        .build

    def scalingPolicy(
      policyARN: Option[String] = None,
      policyName: Option[String] = None,
      serviceNamespace: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      policyType: Option[String] = None,
      stepScalingPolicyConfiguration: Option[StepScalingPolicyConfiguration] = None,
      targetTrackingScalingPolicyConfiguration: Option[TargetTrackingScalingPolicyConfiguration] = None,
      alarms: Option[List[Alarm]] = None,
      creationTime: Option[TimestampType] = None
    ): ScalingPolicy =
      ScalingPolicy
        .builder
        .ifSome(policyARN)(_.policyARN(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(stepScalingPolicyConfiguration)(_.stepScalingPolicyConfiguration(_))
        .ifSome(targetTrackingScalingPolicyConfiguration)(_.targetTrackingScalingPolicyConfiguration(_))
        .ifSome(alarms)(_.alarms(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def scheduledAction(
      scheduledActionName: Option[String] = None,
      scheduledActionARN: Option[String] = None,
      serviceNamespace: Option[String] = None,
      schedule: Option[String] = None,
      timezone: Option[String] = None,
      resourceId: Option[String] = None,
      scalableDimension: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      scalableTargetAction: Option[ScalableTargetAction] = None,
      creationTime: Option[TimestampType] = None
    ): ScheduledAction =
      ScheduledAction
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(scheduledActionARN)(_.scheduledActionARN(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(scalableDimension)(_.scalableDimension(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(scalableTargetAction)(_.scalableTargetAction(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def stepAdjustment(
      metricIntervalLowerBound: Option[MetricScale] = None,
      metricIntervalUpperBound: Option[MetricScale] = None,
      scalingAdjustment: Option[Int] = None
    ): StepAdjustment =
      StepAdjustment
        .builder
        .ifSome(metricIntervalLowerBound)(_.metricIntervalLowerBound(_))
        .ifSome(metricIntervalUpperBound)(_.metricIntervalUpperBound(_))
        .ifSome(scalingAdjustment)(_.scalingAdjustment(_))
        .build

    def stepScalingPolicyConfiguration(
      adjustmentType: Option[String] = None,
      stepAdjustments: Option[List[StepAdjustment]] = None,
      minAdjustmentMagnitude: Option[Int] = None,
      cooldown: Option[Int] = None,
      metricAggregationType: Option[String] = None
    ): StepScalingPolicyConfiguration =
      StepScalingPolicyConfiguration
        .builder
        .ifSome(adjustmentType)(_.adjustmentType(_))
        .ifSome(stepAdjustments)(_.stepAdjustments(_))
        .ifSome(minAdjustmentMagnitude)(_.minAdjustmentMagnitude(_))
        .ifSome(cooldown)(_.cooldown(_))
        .ifSome(metricAggregationType)(_.metricAggregationType(_))
        .build

    def suspendedState(
      dynamicScalingInSuspended: Option[Boolean] = None,
      dynamicScalingOutSuspended: Option[Boolean] = None,
      scheduledScalingSuspended: Option[Boolean] = None
    ): SuspendedState =
      SuspendedState
        .builder
        .ifSome(dynamicScalingInSuspended)(_.dynamicScalingInSuspended(_))
        .ifSome(dynamicScalingOutSuspended)(_.dynamicScalingOutSuspended(_))
        .ifSome(scheduledScalingSuspended)(_.scheduledScalingSuspended(_))
        .build

    def targetTrackingScalingPolicyConfiguration(
      targetValue: Option[MetricScale] = None,
      predefinedMetricSpecification: Option[PredefinedMetricSpecification] = None,
      customizedMetricSpecification: Option[CustomizedMetricSpecification] = None,
      scaleOutCooldown: Option[Int] = None,
      scaleInCooldown: Option[Int] = None,
      disableScaleIn: Option[Boolean] = None
    ): TargetTrackingScalingPolicyConfiguration =
      TargetTrackingScalingPolicyConfiguration
        .builder
        .ifSome(targetValue)(_.targetValue(_))
        .ifSome(predefinedMetricSpecification)(_.predefinedMetricSpecification(_))
        .ifSome(customizedMetricSpecification)(_.customizedMetricSpecification(_))
        .ifSome(scaleOutCooldown)(_.scaleOutCooldown(_))
        .ifSome(scaleInCooldown)(_.scaleInCooldown(_))
        .ifSome(disableScaleIn)(_.disableScaleIn(_))
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
