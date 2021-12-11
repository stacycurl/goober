package goober.hi

import goober.free.autoscaling.AutoScalingIO
import software.amazon.awssdk.services.autoscaling.model._


object autoscaling {
  import goober.free.{autoscaling ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activeInstanceRefreshNotFoundFault(
      message: Option[String] = None
    ): ActiveInstanceRefreshNotFoundFault =
      ActiveInstanceRefreshNotFoundFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def activitiesType(
      activities: Option[List[Activity]] = None,
      nextToken: Option[String] = None
    ): ActivitiesType =
      ActivitiesType
        .builder
        .ifSome(activities)(_.activities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def activity(
      activityId: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      description: Option[String] = None,
      cause: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      progress: Option[Int] = None,
      details: Option[String] = None,
      autoScalingGroupState: Option[String] = None,
      autoScalingGroupARN: Option[String] = None
    ): Activity =
      Activity
        .builder
        .ifSome(activityId)(_.activityId(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(cause)(_.cause(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(details)(_.details(_))
        .ifSome(autoScalingGroupState)(_.autoScalingGroupState(_))
        .ifSome(autoScalingGroupARN)(_.autoScalingGroupARN(_))
        .build

    def activityType(
      activity: Option[Activity] = None
    ): ActivityType =
      ActivityType
        .builder
        .ifSome(activity)(_.activity(_))
        .build

    def adjustmentType(
      adjustmentType: Option[String] = None
    ): AdjustmentType =
      AdjustmentType
        .builder
        .ifSome(adjustmentType)(_.adjustmentType(_))
        .build

    def alarm(
      alarmName: Option[String] = None,
      alarmARN: Option[String] = None
    ): Alarm =
      Alarm
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(alarmARN)(_.alarmARN(_))
        .build

    def alreadyExistsFault(
      message: Option[String] = None
    ): AlreadyExistsFault =
      AlreadyExistsFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def attachInstancesQuery(
      instanceIds: Option[List[XmlStringMaxLen19]] = None,
      autoScalingGroupName: Option[String] = None
    ): AttachInstancesQuery =
      AttachInstancesQuery
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .build

    def attachLoadBalancerTargetGroupsResultType(

    ): AttachLoadBalancerTargetGroupsResultType =
      AttachLoadBalancerTargetGroupsResultType
        .builder

        .build

    def attachLoadBalancerTargetGroupsType(
      autoScalingGroupName: Option[String] = None,
      targetGroupARNs: Option[List[XmlStringMaxLen511]] = None
    ): AttachLoadBalancerTargetGroupsType =
      AttachLoadBalancerTargetGroupsType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(targetGroupARNs)(_.targetGroupARNs(_))
        .build

    def attachLoadBalancersResultType(

    ): AttachLoadBalancersResultType =
      AttachLoadBalancersResultType
        .builder

        .build

    def attachLoadBalancersType(
      autoScalingGroupName: Option[String] = None,
      loadBalancerNames: Option[List[XmlStringMaxLen255]] = None
    ): AttachLoadBalancersType =
      AttachLoadBalancersType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .build

    def autoScalingGroup(
      autoScalingGroupName: Option[String] = None,
      autoScalingGroupARN: Option[String] = None,
      launchConfigurationName: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      mixedInstancesPolicy: Option[MixedInstancesPolicy] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      desiredCapacity: Option[Int] = None,
      predictedCapacity: Option[Int] = None,
      defaultCooldown: Option[Int] = None,
      availabilityZones: Option[List[XmlStringMaxLen255]] = None,
      loadBalancerNames: Option[List[XmlStringMaxLen255]] = None,
      targetGroupARNs: Option[List[XmlStringMaxLen511]] = None,
      healthCheckType: Option[String] = None,
      healthCheckGracePeriod: Option[Int] = None,
      instances: Option[List[Instance]] = None,
      createdTime: Option[TimestampType] = None,
      suspendedProcesses: Option[List[SuspendedProcess]] = None,
      placementGroup: Option[String] = None,
      vPCZoneIdentifier: Option[String] = None,
      enabledMetrics: Option[List[EnabledMetric]] = None,
      status: Option[String] = None,
      tags: Option[List[TagDescription]] = None,
      terminationPolicies: Option[List[XmlStringMaxLen1600]] = None,
      newInstancesProtectedFromScaleIn: Option[Boolean] = None,
      serviceLinkedRoleARN: Option[String] = None,
      maxInstanceLifetime: Option[Int] = None,
      capacityRebalance: Option[Boolean] = None,
      warmPoolConfiguration: Option[WarmPoolConfiguration] = None,
      warmPoolSize: Option[Int] = None
    ): AutoScalingGroup =
      AutoScalingGroup
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(autoScalingGroupARN)(_.autoScalingGroupARN(_))
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(mixedInstancesPolicy)(_.mixedInstancesPolicy(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(predictedCapacity)(_.predictedCapacity(_))
        .ifSome(defaultCooldown)(_.defaultCooldown(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .ifSome(targetGroupARNs)(_.targetGroupARNs(_))
        .ifSome(healthCheckType)(_.healthCheckType(_))
        .ifSome(healthCheckGracePeriod)(_.healthCheckGracePeriod(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(suspendedProcesses)(_.suspendedProcesses(_))
        .ifSome(placementGroup)(_.placementGroup(_))
        .ifSome(vPCZoneIdentifier)(_.vPCZoneIdentifier(_))
        .ifSome(enabledMetrics)(_.enabledMetrics(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(terminationPolicies)(_.terminationPolicies(_))
        .ifSome(newInstancesProtectedFromScaleIn)(_.newInstancesProtectedFromScaleIn(_))
        .ifSome(serviceLinkedRoleARN)(_.serviceLinkedRoleARN(_))
        .ifSome(maxInstanceLifetime)(_.maxInstanceLifetime(_))
        .ifSome(capacityRebalance)(_.capacityRebalance(_))
        .ifSome(warmPoolConfiguration)(_.warmPoolConfiguration(_))
        .ifSome(warmPoolSize)(_.warmPoolSize(_))
        .build

    def autoScalingGroupNamesType(
      autoScalingGroupNames: Option[List[XmlStringMaxLen255]] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): AutoScalingGroupNamesType =
      AutoScalingGroupNamesType
        .builder
        .ifSome(autoScalingGroupNames)(_.autoScalingGroupNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def autoScalingGroupsType(
      autoScalingGroups: Option[List[AutoScalingGroup]] = None,
      nextToken: Option[String] = None
    ): AutoScalingGroupsType =
      AutoScalingGroupsType
        .builder
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def autoScalingInstanceDetails(
      instanceId: Option[String] = None,
      instanceType: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      availabilityZone: Option[String] = None,
      lifecycleState: Option[String] = None,
      healthStatus: Option[String] = None,
      launchConfigurationName: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      protectedFromScaleIn: Option[Boolean] = None,
      weightedCapacity: Option[String] = None
    ): AutoScalingInstanceDetails =
      AutoScalingInstanceDetails
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(lifecycleState)(_.lifecycleState(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(protectedFromScaleIn)(_.protectedFromScaleIn(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .build

    def autoScalingInstancesType(
      autoScalingInstances: Option[List[AutoScalingInstanceDetails]] = None,
      nextToken: Option[String] = None
    ): AutoScalingInstancesType =
      AutoScalingInstancesType
        .builder
        .ifSome(autoScalingInstances)(_.autoScalingInstances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchDeleteScheduledActionAnswer(
      failedScheduledActions: Option[List[FailedScheduledUpdateGroupActionRequest]] = None
    ): BatchDeleteScheduledActionAnswer =
      BatchDeleteScheduledActionAnswer
        .builder
        .ifSome(failedScheduledActions)(_.failedScheduledActions(_))
        .build

    def batchDeleteScheduledActionType(
      autoScalingGroupName: Option[String] = None,
      scheduledActionNames: Option[List[XmlStringMaxLen255]] = None
    ): BatchDeleteScheduledActionType =
      BatchDeleteScheduledActionType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(scheduledActionNames)(_.scheduledActionNames(_))
        .build

    def batchPutScheduledUpdateGroupActionAnswer(
      failedScheduledUpdateGroupActions: Option[List[FailedScheduledUpdateGroupActionRequest]] = None
    ): BatchPutScheduledUpdateGroupActionAnswer =
      BatchPutScheduledUpdateGroupActionAnswer
        .builder
        .ifSome(failedScheduledUpdateGroupActions)(_.failedScheduledUpdateGroupActions(_))
        .build

    def batchPutScheduledUpdateGroupActionType(
      autoScalingGroupName: Option[String] = None,
      scheduledUpdateGroupActions: Option[List[ScheduledUpdateGroupActionRequest]] = None
    ): BatchPutScheduledUpdateGroupActionType =
      BatchPutScheduledUpdateGroupActionType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(scheduledUpdateGroupActions)(_.scheduledUpdateGroupActions(_))
        .build

    def blockDeviceMapping(
      virtualName: Option[String] = None,
      deviceName: Option[String] = None,
      ebs: Option[Ebs] = None,
      noDevice: Option[Boolean] = None
    ): BlockDeviceMapping =
      BlockDeviceMapping
        .builder
        .ifSome(virtualName)(_.virtualName(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(ebs)(_.ebs(_))
        .ifSome(noDevice)(_.noDevice(_))
        .build

    def cancelInstanceRefreshAnswer(
      instanceRefreshId: Option[String] = None
    ): CancelInstanceRefreshAnswer =
      CancelInstanceRefreshAnswer
        .builder
        .ifSome(instanceRefreshId)(_.instanceRefreshId(_))
        .build

    def cancelInstanceRefreshType(
      autoScalingGroupName: Option[String] = None
    ): CancelInstanceRefreshType =
      CancelInstanceRefreshType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .build

    def capacityForecast(
      timestamps: Option[List[TimestampType]] = None,
      values: Option[List[MetricScale]] = None
    ): CapacityForecast =
      CapacityForecast
        .builder
        .ifSome(timestamps)(_.timestamps(_))
        .ifSome(values)(_.values(_))
        .build

    def completeLifecycleActionAnswer(

    ): CompleteLifecycleActionAnswer =
      CompleteLifecycleActionAnswer
        .builder

        .build

    def completeLifecycleActionType(
      lifecycleHookName: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      lifecycleActionToken: Option[String] = None,
      lifecycleActionResult: Option[String] = None,
      instanceId: Option[String] = None
    ): CompleteLifecycleActionType =
      CompleteLifecycleActionType
        .builder
        .ifSome(lifecycleHookName)(_.lifecycleHookName(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(lifecycleActionToken)(_.lifecycleActionToken(_))
        .ifSome(lifecycleActionResult)(_.lifecycleActionResult(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def createAutoScalingGroupType(
      autoScalingGroupName: Option[String] = None,
      launchConfigurationName: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      mixedInstancesPolicy: Option[MixedInstancesPolicy] = None,
      instanceId: Option[String] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      desiredCapacity: Option[Int] = None,
      defaultCooldown: Option[Int] = None,
      availabilityZones: Option[List[XmlStringMaxLen255]] = None,
      loadBalancerNames: Option[List[XmlStringMaxLen255]] = None,
      targetGroupARNs: Option[List[XmlStringMaxLen511]] = None,
      healthCheckType: Option[String] = None,
      healthCheckGracePeriod: Option[Int] = None,
      placementGroup: Option[String] = None,
      vPCZoneIdentifier: Option[String] = None,
      terminationPolicies: Option[List[XmlStringMaxLen1600]] = None,
      newInstancesProtectedFromScaleIn: Option[Boolean] = None,
      capacityRebalance: Option[Boolean] = None,
      lifecycleHookSpecificationList: Option[List[LifecycleHookSpecification]] = None,
      tags: Option[List[Tag]] = None,
      serviceLinkedRoleARN: Option[String] = None,
      maxInstanceLifetime: Option[Int] = None
    ): CreateAutoScalingGroupType =
      CreateAutoScalingGroupType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(mixedInstancesPolicy)(_.mixedInstancesPolicy(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(defaultCooldown)(_.defaultCooldown(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .ifSome(targetGroupARNs)(_.targetGroupARNs(_))
        .ifSome(healthCheckType)(_.healthCheckType(_))
        .ifSome(healthCheckGracePeriod)(_.healthCheckGracePeriod(_))
        .ifSome(placementGroup)(_.placementGroup(_))
        .ifSome(vPCZoneIdentifier)(_.vPCZoneIdentifier(_))
        .ifSome(terminationPolicies)(_.terminationPolicies(_))
        .ifSome(newInstancesProtectedFromScaleIn)(_.newInstancesProtectedFromScaleIn(_))
        .ifSome(capacityRebalance)(_.capacityRebalance(_))
        .ifSome(lifecycleHookSpecificationList)(_.lifecycleHookSpecificationList(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(serviceLinkedRoleARN)(_.serviceLinkedRoleARN(_))
        .ifSome(maxInstanceLifetime)(_.maxInstanceLifetime(_))
        .build

    def createLaunchConfigurationType(
      launchConfigurationName: Option[String] = None,
      imageId: Option[String] = None,
      keyName: Option[String] = None,
      securityGroups: Option[List[XmlString]] = None,
      classicLinkVPCId: Option[String] = None,
      classicLinkVPCSecurityGroups: Option[List[XmlStringMaxLen255]] = None,
      userData: Option[String] = None,
      instanceId: Option[String] = None,
      instanceType: Option[String] = None,
      kernelId: Option[String] = None,
      ramdiskId: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      instanceMonitoring: Option[InstanceMonitoring] = None,
      spotPrice: Option[String] = None,
      iamInstanceProfile: Option[String] = None,
      ebsOptimized: Option[Boolean] = None,
      associatePublicIpAddress: Option[Boolean] = None,
      placementTenancy: Option[String] = None,
      metadataOptions: Option[InstanceMetadataOptions] = None
    ): CreateLaunchConfigurationType =
      CreateLaunchConfigurationType
        .builder
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(classicLinkVPCId)(_.classicLinkVPCId(_))
        .ifSome(classicLinkVPCSecurityGroups)(_.classicLinkVPCSecurityGroups(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(instanceMonitoring)(_.instanceMonitoring(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(placementTenancy)(_.placementTenancy(_))
        .ifSome(metadataOptions)(_.metadataOptions(_))
        .build

    def createOrUpdateTagsType(
      tags: Option[List[Tag]] = None
    ): CreateOrUpdateTagsType =
      CreateOrUpdateTagsType
        .builder
        .ifSome(tags)(_.tags(_))
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

    def deleteAutoScalingGroupType(
      autoScalingGroupName: Option[String] = None,
      forceDelete: Option[Boolean] = None
    ): DeleteAutoScalingGroupType =
      DeleteAutoScalingGroupType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(forceDelete)(_.forceDelete(_))
        .build

    def deleteLifecycleHookAnswer(

    ): DeleteLifecycleHookAnswer =
      DeleteLifecycleHookAnswer
        .builder

        .build

    def deleteLifecycleHookType(
      lifecycleHookName: Option[String] = None,
      autoScalingGroupName: Option[String] = None
    ): DeleteLifecycleHookType =
      DeleteLifecycleHookType
        .builder
        .ifSome(lifecycleHookName)(_.lifecycleHookName(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .build

    def deleteNotificationConfigurationType(
      autoScalingGroupName: Option[String] = None,
      topicARN: Option[String] = None
    ): DeleteNotificationConfigurationType =
      DeleteNotificationConfigurationType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(topicARN)(_.topicARN(_))
        .build

    def deletePolicyType(
      autoScalingGroupName: Option[String] = None,
      policyName: Option[String] = None
    ): DeletePolicyType =
      DeletePolicyType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteScheduledActionType(
      autoScalingGroupName: Option[String] = None,
      scheduledActionName: Option[String] = None
    ): DeleteScheduledActionType =
      DeleteScheduledActionType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .build

    def deleteTagsType(
      tags: Option[List[Tag]] = None
    ): DeleteTagsType =
      DeleteTagsType
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def deleteWarmPoolAnswer(

    ): DeleteWarmPoolAnswer =
      DeleteWarmPoolAnswer
        .builder

        .build

    def deleteWarmPoolType(
      autoScalingGroupName: Option[String] = None,
      forceDelete: Option[Boolean] = None
    ): DeleteWarmPoolType =
      DeleteWarmPoolType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(forceDelete)(_.forceDelete(_))
        .build

    def describeAccountLimitsAnswer(
      maxNumberOfAutoScalingGroups: Option[Int] = None,
      maxNumberOfLaunchConfigurations: Option[Int] = None,
      numberOfAutoScalingGroups: Option[Int] = None,
      numberOfLaunchConfigurations: Option[Int] = None
    ): DescribeAccountLimitsAnswer =
      DescribeAccountLimitsAnswer
        .builder
        .ifSome(maxNumberOfAutoScalingGroups)(_.maxNumberOfAutoScalingGroups(_))
        .ifSome(maxNumberOfLaunchConfigurations)(_.maxNumberOfLaunchConfigurations(_))
        .ifSome(numberOfAutoScalingGroups)(_.numberOfAutoScalingGroups(_))
        .ifSome(numberOfLaunchConfigurations)(_.numberOfLaunchConfigurations(_))
        .build

    def describeAdjustmentTypesAnswer(
      adjustmentTypes: Option[List[AdjustmentType]] = None
    ): DescribeAdjustmentTypesAnswer =
      DescribeAdjustmentTypesAnswer
        .builder
        .ifSome(adjustmentTypes)(_.adjustmentTypes(_))
        .build

    def describeAutoScalingInstancesType(
      instanceIds: Option[List[XmlStringMaxLen19]] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAutoScalingInstancesType =
      DescribeAutoScalingInstancesType
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAutoScalingNotificationTypesAnswer(
      autoScalingNotificationTypes: Option[List[XmlStringMaxLen255]] = None
    ): DescribeAutoScalingNotificationTypesAnswer =
      DescribeAutoScalingNotificationTypesAnswer
        .builder
        .ifSome(autoScalingNotificationTypes)(_.autoScalingNotificationTypes(_))
        .build

    def describeInstanceRefreshesAnswer(
      instanceRefreshes: Option[List[InstanceRefresh]] = None,
      nextToken: Option[String] = None
    ): DescribeInstanceRefreshesAnswer =
      DescribeInstanceRefreshesAnswer
        .builder
        .ifSome(instanceRefreshes)(_.instanceRefreshes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstanceRefreshesType(
      autoScalingGroupName: Option[String] = None,
      instanceRefreshIds: Option[List[XmlStringMaxLen255]] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeInstanceRefreshesType =
      DescribeInstanceRefreshesType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(instanceRefreshIds)(_.instanceRefreshIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeLifecycleHookTypesAnswer(
      lifecycleHookTypes: Option[List[XmlStringMaxLen255]] = None
    ): DescribeLifecycleHookTypesAnswer =
      DescribeLifecycleHookTypesAnswer
        .builder
        .ifSome(lifecycleHookTypes)(_.lifecycleHookTypes(_))
        .build

    def describeLifecycleHooksAnswer(
      lifecycleHooks: Option[List[LifecycleHook]] = None
    ): DescribeLifecycleHooksAnswer =
      DescribeLifecycleHooksAnswer
        .builder
        .ifSome(lifecycleHooks)(_.lifecycleHooks(_))
        .build

    def describeLifecycleHooksType(
      autoScalingGroupName: Option[String] = None,
      lifecycleHookNames: Option[List[AsciiStringMaxLen255]] = None
    ): DescribeLifecycleHooksType =
      DescribeLifecycleHooksType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(lifecycleHookNames)(_.lifecycleHookNames(_))
        .build

    def describeLoadBalancerTargetGroupsRequest(
      autoScalingGroupName: Option[String] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeLoadBalancerTargetGroupsRequest =
      DescribeLoadBalancerTargetGroupsRequest
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeLoadBalancerTargetGroupsResponse(
      loadBalancerTargetGroups: Option[List[LoadBalancerTargetGroupState]] = None,
      nextToken: Option[String] = None
    ): DescribeLoadBalancerTargetGroupsResponse =
      DescribeLoadBalancerTargetGroupsResponse
        .builder
        .ifSome(loadBalancerTargetGroups)(_.loadBalancerTargetGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLoadBalancersRequest(
      autoScalingGroupName: Option[String] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeLoadBalancersRequest =
      DescribeLoadBalancersRequest
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeLoadBalancersResponse(
      loadBalancers: Option[List[LoadBalancerState]] = None,
      nextToken: Option[String] = None
    ): DescribeLoadBalancersResponse =
      DescribeLoadBalancersResponse
        .builder
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMetricCollectionTypesAnswer(
      metrics: Option[List[MetricCollectionType]] = None,
      granularities: Option[List[MetricGranularityType]] = None
    ): DescribeMetricCollectionTypesAnswer =
      DescribeMetricCollectionTypesAnswer
        .builder
        .ifSome(metrics)(_.metrics(_))
        .ifSome(granularities)(_.granularities(_))
        .build

    def describeNotificationConfigurationsAnswer(
      notificationConfigurations: Option[List[NotificationConfiguration]] = None,
      nextToken: Option[String] = None
    ): DescribeNotificationConfigurationsAnswer =
      DescribeNotificationConfigurationsAnswer
        .builder
        .ifSome(notificationConfigurations)(_.notificationConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeNotificationConfigurationsType(
      autoScalingGroupNames: Option[List[XmlStringMaxLen255]] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeNotificationConfigurationsType =
      DescribeNotificationConfigurationsType
        .builder
        .ifSome(autoScalingGroupNames)(_.autoScalingGroupNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describePoliciesType(
      autoScalingGroupName: Option[String] = None,
      policyNames: Option[List[ResourceName]] = None,
      policyTypes: Option[List[XmlStringMaxLen64]] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribePoliciesType =
      DescribePoliciesType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(policyNames)(_.policyNames(_))
        .ifSome(policyTypes)(_.policyTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeScalingActivitiesType(
      activityIds: Option[List[XmlString]] = None,
      autoScalingGroupName: Option[String] = None,
      includeDeletedGroups: Option[Boolean] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScalingActivitiesType =
      DescribeScalingActivitiesType
        .builder
        .ifSome(activityIds)(_.activityIds(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(includeDeletedGroups)(_.includeDeletedGroups(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScheduledActionsType(
      autoScalingGroupName: Option[String] = None,
      scheduledActionNames: Option[List[XmlStringMaxLen255]] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeScheduledActionsType =
      DescribeScheduledActionsType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(scheduledActionNames)(_.scheduledActionNames(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeTagsType(
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeTagsType =
      DescribeTagsType
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeTerminationPolicyTypesAnswer(
      terminationPolicyTypes: Option[List[XmlStringMaxLen1600]] = None
    ): DescribeTerminationPolicyTypesAnswer =
      DescribeTerminationPolicyTypesAnswer
        .builder
        .ifSome(terminationPolicyTypes)(_.terminationPolicyTypes(_))
        .build

    def describeWarmPoolAnswer(
      warmPoolConfiguration: Option[WarmPoolConfiguration] = None,
      instances: Option[List[Instance]] = None,
      nextToken: Option[String] = None
    ): DescribeWarmPoolAnswer =
      DescribeWarmPoolAnswer
        .builder
        .ifSome(warmPoolConfiguration)(_.warmPoolConfiguration(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeWarmPoolType(
      autoScalingGroupName: Option[String] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeWarmPoolType =
      DescribeWarmPoolType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def detachInstancesAnswer(
      activities: Option[List[Activity]] = None
    ): DetachInstancesAnswer =
      DetachInstancesAnswer
        .builder
        .ifSome(activities)(_.activities(_))
        .build

    def detachInstancesQuery(
      instanceIds: Option[List[XmlStringMaxLen19]] = None,
      autoScalingGroupName: Option[String] = None,
      shouldDecrementDesiredCapacity: Option[Boolean] = None
    ): DetachInstancesQuery =
      DetachInstancesQuery
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(shouldDecrementDesiredCapacity)(_.shouldDecrementDesiredCapacity(_))
        .build

    def detachLoadBalancerTargetGroupsResultType(

    ): DetachLoadBalancerTargetGroupsResultType =
      DetachLoadBalancerTargetGroupsResultType
        .builder

        .build

    def detachLoadBalancerTargetGroupsType(
      autoScalingGroupName: Option[String] = None,
      targetGroupARNs: Option[List[XmlStringMaxLen511]] = None
    ): DetachLoadBalancerTargetGroupsType =
      DetachLoadBalancerTargetGroupsType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(targetGroupARNs)(_.targetGroupARNs(_))
        .build

    def detachLoadBalancersResultType(

    ): DetachLoadBalancersResultType =
      DetachLoadBalancersResultType
        .builder

        .build

    def detachLoadBalancersType(
      autoScalingGroupName: Option[String] = None,
      loadBalancerNames: Option[List[XmlStringMaxLen255]] = None
    ): DetachLoadBalancersType =
      DetachLoadBalancersType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .build

    def disableMetricsCollectionQuery(
      autoScalingGroupName: Option[String] = None,
      metrics: Option[List[XmlStringMaxLen255]] = None
    ): DisableMetricsCollectionQuery =
      DisableMetricsCollectionQuery
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def ebs(
      snapshotId: Option[String] = None,
      volumeSize: Option[Int] = None,
      volumeType: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None,
      iops: Option[Int] = None,
      encrypted: Option[Boolean] = None,
      throughput: Option[Int] = None
    ): Ebs =
      Ebs
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(throughput)(_.throughput(_))
        .build

    def enableMetricsCollectionQuery(
      autoScalingGroupName: Option[String] = None,
      metrics: Option[List[XmlStringMaxLen255]] = None,
      granularity: Option[String] = None
    ): EnableMetricsCollectionQuery =
      EnableMetricsCollectionQuery
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(granularity)(_.granularity(_))
        .build

    def enabledMetric(
      metric: Option[String] = None,
      granularity: Option[String] = None
    ): EnabledMetric =
      EnabledMetric
        .builder
        .ifSome(metric)(_.metric(_))
        .ifSome(granularity)(_.granularity(_))
        .build

    def enterStandbyAnswer(
      activities: Option[List[Activity]] = None
    ): EnterStandbyAnswer =
      EnterStandbyAnswer
        .builder
        .ifSome(activities)(_.activities(_))
        .build

    def enterStandbyQuery(
      instanceIds: Option[List[XmlStringMaxLen19]] = None,
      autoScalingGroupName: Option[String] = None,
      shouldDecrementDesiredCapacity: Option[Boolean] = None
    ): EnterStandbyQuery =
      EnterStandbyQuery
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(shouldDecrementDesiredCapacity)(_.shouldDecrementDesiredCapacity(_))
        .build

    def executePolicyType(
      autoScalingGroupName: Option[String] = None,
      policyName: Option[String] = None,
      honorCooldown: Option[Boolean] = None,
      metricValue: Option[MetricScale] = None,
      breachThreshold: Option[MetricScale] = None
    ): ExecutePolicyType =
      ExecutePolicyType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(honorCooldown)(_.honorCooldown(_))
        .ifSome(metricValue)(_.metricValue(_))
        .ifSome(breachThreshold)(_.breachThreshold(_))
        .build

    def exitStandbyAnswer(
      activities: Option[List[Activity]] = None
    ): ExitStandbyAnswer =
      ExitStandbyAnswer
        .builder
        .ifSome(activities)(_.activities(_))
        .build

    def exitStandbyQuery(
      instanceIds: Option[List[XmlStringMaxLen19]] = None,
      autoScalingGroupName: Option[String] = None
    ): ExitStandbyQuery =
      ExitStandbyQuery
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .build

    def failedScheduledUpdateGroupActionRequest(
      scheduledActionName: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailedScheduledUpdateGroupActionRequest =
      FailedScheduledUpdateGroupActionRequest
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[XmlString]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def getPredictiveScalingForecastAnswer(
      loadForecast: Option[List[LoadForecast]] = None,
      capacityForecast: Option[CapacityForecast] = None,
      updateTime: Option[TimestampType] = None
    ): GetPredictiveScalingForecastAnswer =
      GetPredictiveScalingForecastAnswer
        .builder
        .ifSome(loadForecast)(_.loadForecast(_))
        .ifSome(capacityForecast)(_.capacityForecast(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def getPredictiveScalingForecastType(
      autoScalingGroupName: Option[String] = None,
      policyName: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None
    ): GetPredictiveScalingForecastType =
      GetPredictiveScalingForecastType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def instance(
      instanceId: Option[String] = None,
      instanceType: Option[String] = None,
      availabilityZone: Option[String] = None,
      lifecycleState: Option[String] = None,
      healthStatus: Option[String] = None,
      launchConfigurationName: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      protectedFromScaleIn: Option[Boolean] = None,
      weightedCapacity: Option[String] = None
    ): Instance =
      Instance
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(lifecycleState)(_.lifecycleState(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(protectedFromScaleIn)(_.protectedFromScaleIn(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .build

    def instanceMetadataOptions(
      httpTokens: Option[String] = None,
      httpPutResponseHopLimit: Option[Int] = None,
      httpEndpoint: Option[String] = None
    ): InstanceMetadataOptions =
      InstanceMetadataOptions
        .builder
        .ifSome(httpTokens)(_.httpTokens(_))
        .ifSome(httpPutResponseHopLimit)(_.httpPutResponseHopLimit(_))
        .ifSome(httpEndpoint)(_.httpEndpoint(_))
        .build

    def instanceMonitoring(
      enabled: Option[Boolean] = None
    ): InstanceMonitoring =
      InstanceMonitoring
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def instanceRefresh(
      instanceRefreshId: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      percentageComplete: Option[Int] = None,
      instancesToUpdate: Option[Int] = None,
      progressDetails: Option[InstanceRefreshProgressDetails] = None
    ): InstanceRefresh =
      InstanceRefresh
        .builder
        .ifSome(instanceRefreshId)(_.instanceRefreshId(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(percentageComplete)(_.percentageComplete(_))
        .ifSome(instancesToUpdate)(_.instancesToUpdate(_))
        .ifSome(progressDetails)(_.progressDetails(_))
        .build

    def instanceRefreshInProgressFault(
      message: Option[String] = None
    ): InstanceRefreshInProgressFault =
      InstanceRefreshInProgressFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def instanceRefreshLivePoolProgress(
      percentageComplete: Option[Int] = None,
      instancesToUpdate: Option[Int] = None
    ): InstanceRefreshLivePoolProgress =
      InstanceRefreshLivePoolProgress
        .builder
        .ifSome(percentageComplete)(_.percentageComplete(_))
        .ifSome(instancesToUpdate)(_.instancesToUpdate(_))
        .build

    def instanceRefreshProgressDetails(
      livePoolProgress: Option[InstanceRefreshLivePoolProgress] = None,
      warmPoolProgress: Option[InstanceRefreshWarmPoolProgress] = None
    ): InstanceRefreshProgressDetails =
      InstanceRefreshProgressDetails
        .builder
        .ifSome(livePoolProgress)(_.livePoolProgress(_))
        .ifSome(warmPoolProgress)(_.warmPoolProgress(_))
        .build

    def instanceRefreshWarmPoolProgress(
      percentageComplete: Option[Int] = None,
      instancesToUpdate: Option[Int] = None
    ): InstanceRefreshWarmPoolProgress =
      InstanceRefreshWarmPoolProgress
        .builder
        .ifSome(percentageComplete)(_.percentageComplete(_))
        .ifSome(instancesToUpdate)(_.instancesToUpdate(_))
        .build

    def instancesDistribution(
      onDemandAllocationStrategy: Option[String] = None,
      onDemandBaseCapacity: Option[Int] = None,
      onDemandPercentageAboveBaseCapacity: Option[Int] = None,
      spotAllocationStrategy: Option[String] = None,
      spotInstancePools: Option[Int] = None,
      spotMaxPrice: Option[String] = None
    ): InstancesDistribution =
      InstancesDistribution
        .builder
        .ifSome(onDemandAllocationStrategy)(_.onDemandAllocationStrategy(_))
        .ifSome(onDemandBaseCapacity)(_.onDemandBaseCapacity(_))
        .ifSome(onDemandPercentageAboveBaseCapacity)(_.onDemandPercentageAboveBaseCapacity(_))
        .ifSome(spotAllocationStrategy)(_.spotAllocationStrategy(_))
        .ifSome(spotInstancePools)(_.spotInstancePools(_))
        .ifSome(spotMaxPrice)(_.spotMaxPrice(_))
        .build

    def invalidNextToken(
      message: Option[String] = None
    ): InvalidNextToken =
      InvalidNextToken
        .builder
        .ifSome(message)(_.message(_))
        .build

    def launchConfiguration(
      launchConfigurationName: Option[String] = None,
      launchConfigurationARN: Option[String] = None,
      imageId: Option[String] = None,
      keyName: Option[String] = None,
      securityGroups: Option[List[XmlString]] = None,
      classicLinkVPCId: Option[String] = None,
      classicLinkVPCSecurityGroups: Option[List[XmlStringMaxLen255]] = None,
      userData: Option[String] = None,
      instanceType: Option[String] = None,
      kernelId: Option[String] = None,
      ramdiskId: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      instanceMonitoring: Option[InstanceMonitoring] = None,
      spotPrice: Option[String] = None,
      iamInstanceProfile: Option[String] = None,
      createdTime: Option[TimestampType] = None,
      ebsOptimized: Option[Boolean] = None,
      associatePublicIpAddress: Option[Boolean] = None,
      placementTenancy: Option[String] = None,
      metadataOptions: Option[InstanceMetadataOptions] = None
    ): LaunchConfiguration =
      LaunchConfiguration
        .builder
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(launchConfigurationARN)(_.launchConfigurationARN(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(classicLinkVPCId)(_.classicLinkVPCId(_))
        .ifSome(classicLinkVPCSecurityGroups)(_.classicLinkVPCSecurityGroups(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(instanceMonitoring)(_.instanceMonitoring(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(placementTenancy)(_.placementTenancy(_))
        .ifSome(metadataOptions)(_.metadataOptions(_))
        .build

    def launchConfigurationNameType(
      launchConfigurationName: Option[String] = None
    ): LaunchConfigurationNameType =
      LaunchConfigurationNameType
        .builder
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .build

    def launchConfigurationNamesType(
      launchConfigurationNames: Option[List[XmlStringMaxLen255]] = None,
      nextToken: Option[String] = None,
      maxRecords: Option[Int] = None
    ): LaunchConfigurationNamesType =
      LaunchConfigurationNamesType
        .builder
        .ifSome(launchConfigurationNames)(_.launchConfigurationNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def launchConfigurationsType(
      launchConfigurations: Option[List[LaunchConfiguration]] = None,
      nextToken: Option[String] = None
    ): LaunchConfigurationsType =
      LaunchConfigurationsType
        .builder
        .ifSome(launchConfigurations)(_.launchConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def launchTemplate(
      launchTemplateSpecification: Option[LaunchTemplateSpecification] = None,
      overrides: Option[List[LaunchTemplateOverrides]] = None
    ): LaunchTemplate =
      LaunchTemplate
        .builder
        .ifSome(launchTemplateSpecification)(_.launchTemplateSpecification(_))
        .ifSome(overrides)(_.overrides(_))
        .build

    def launchTemplateOverrides(
      instanceType: Option[String] = None,
      weightedCapacity: Option[String] = None,
      launchTemplateSpecification: Option[LaunchTemplateSpecification] = None
    ): LaunchTemplateOverrides =
      LaunchTemplateOverrides
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .ifSome(launchTemplateSpecification)(_.launchTemplateSpecification(_))
        .build

    def launchTemplateSpecification(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      version: Option[String] = None
    ): LaunchTemplateSpecification =
      LaunchTemplateSpecification
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(version)(_.version(_))
        .build

    def lifecycleHook(
      lifecycleHookName: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      lifecycleTransition: Option[String] = None,
      notificationTargetARN: Option[String] = None,
      roleARN: Option[String] = None,
      notificationMetadata: Option[String] = None,
      heartbeatTimeout: Option[Int] = None,
      globalTimeout: Option[Int] = None,
      defaultResult: Option[String] = None
    ): LifecycleHook =
      LifecycleHook
        .builder
        .ifSome(lifecycleHookName)(_.lifecycleHookName(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(lifecycleTransition)(_.lifecycleTransition(_))
        .ifSome(notificationTargetARN)(_.notificationTargetARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(notificationMetadata)(_.notificationMetadata(_))
        .ifSome(heartbeatTimeout)(_.heartbeatTimeout(_))
        .ifSome(globalTimeout)(_.globalTimeout(_))
        .ifSome(defaultResult)(_.defaultResult(_))
        .build

    def lifecycleHookSpecification(
      lifecycleHookName: Option[String] = None,
      lifecycleTransition: Option[String] = None,
      notificationMetadata: Option[String] = None,
      heartbeatTimeout: Option[Int] = None,
      defaultResult: Option[String] = None,
      notificationTargetARN: Option[String] = None,
      roleARN: Option[String] = None
    ): LifecycleHookSpecification =
      LifecycleHookSpecification
        .builder
        .ifSome(lifecycleHookName)(_.lifecycleHookName(_))
        .ifSome(lifecycleTransition)(_.lifecycleTransition(_))
        .ifSome(notificationMetadata)(_.notificationMetadata(_))
        .ifSome(heartbeatTimeout)(_.heartbeatTimeout(_))
        .ifSome(defaultResult)(_.defaultResult(_))
        .ifSome(notificationTargetARN)(_.notificationTargetARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def limitExceededFault(
      message: Option[String] = None
    ): LimitExceededFault =
      LimitExceededFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def loadBalancerState(
      loadBalancerName: Option[String] = None,
      state: Option[String] = None
    ): LoadBalancerState =
      LoadBalancerState
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(state)(_.state(_))
        .build

    def loadBalancerTargetGroupState(
      loadBalancerTargetGroupARN: Option[String] = None,
      state: Option[String] = None
    ): LoadBalancerTargetGroupState =
      LoadBalancerTargetGroupState
        .builder
        .ifSome(loadBalancerTargetGroupARN)(_.loadBalancerTargetGroupARN(_))
        .ifSome(state)(_.state(_))
        .build

    def loadForecast(
      timestamps: Option[List[TimestampType]] = None,
      values: Option[List[MetricScale]] = None,
      metricSpecification: Option[PredictiveScalingMetricSpecification] = None
    ): LoadForecast =
      LoadForecast
        .builder
        .ifSome(timestamps)(_.timestamps(_))
        .ifSome(values)(_.values(_))
        .ifSome(metricSpecification)(_.metricSpecification(_))
        .build

    def metricCollectionType(
      metric: Option[String] = None
    ): MetricCollectionType =
      MetricCollectionType
        .builder
        .ifSome(metric)(_.metric(_))
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

    def metricGranularityType(
      granularity: Option[String] = None
    ): MetricGranularityType =
      MetricGranularityType
        .builder
        .ifSome(granularity)(_.granularity(_))
        .build

    def mixedInstancesPolicy(
      launchTemplate: Option[LaunchTemplate] = None,
      instancesDistribution: Option[InstancesDistribution] = None
    ): MixedInstancesPolicy =
      MixedInstancesPolicy
        .builder
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(instancesDistribution)(_.instancesDistribution(_))
        .build

    def notificationConfiguration(
      autoScalingGroupName: Option[String] = None,
      topicARN: Option[String] = None,
      notificationType: Option[String] = None
    ): NotificationConfiguration =
      NotificationConfiguration
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(topicARN)(_.topicARN(_))
        .ifSome(notificationType)(_.notificationType(_))
        .build

    def policiesType(
      scalingPolicies: Option[List[ScalingPolicy]] = None,
      nextToken: Option[String] = None
    ): PoliciesType =
      PoliciesType
        .builder
        .ifSome(scalingPolicies)(_.scalingPolicies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def policyARNType(
      policyARN: Option[String] = None,
      alarms: Option[List[Alarm]] = None
    ): PolicyARNType =
      PolicyARNType
        .builder
        .ifSome(policyARN)(_.policyARN(_))
        .ifSome(alarms)(_.alarms(_))
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

    def predictiveScalingConfiguration(
      metricSpecifications: Option[List[PredictiveScalingMetricSpecification]] = None,
      mode: Option[String] = None,
      schedulingBufferTime: Option[Int] = None,
      maxCapacityBreachBehavior: Option[String] = None,
      maxCapacityBuffer: Option[Int] = None
    ): PredictiveScalingConfiguration =
      PredictiveScalingConfiguration
        .builder
        .ifSome(metricSpecifications)(_.metricSpecifications(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(schedulingBufferTime)(_.schedulingBufferTime(_))
        .ifSome(maxCapacityBreachBehavior)(_.maxCapacityBreachBehavior(_))
        .ifSome(maxCapacityBuffer)(_.maxCapacityBuffer(_))
        .build

    def predictiveScalingMetricSpecification(
      targetValue: Option[MetricScale] = None,
      predefinedMetricPairSpecification: Option[PredictiveScalingPredefinedMetricPair] = None,
      predefinedScalingMetricSpecification: Option[PredictiveScalingPredefinedScalingMetric] = None,
      predefinedLoadMetricSpecification: Option[PredictiveScalingPredefinedLoadMetric] = None
    ): PredictiveScalingMetricSpecification =
      PredictiveScalingMetricSpecification
        .builder
        .ifSome(targetValue)(_.targetValue(_))
        .ifSome(predefinedMetricPairSpecification)(_.predefinedMetricPairSpecification(_))
        .ifSome(predefinedScalingMetricSpecification)(_.predefinedScalingMetricSpecification(_))
        .ifSome(predefinedLoadMetricSpecification)(_.predefinedLoadMetricSpecification(_))
        .build

    def predictiveScalingPredefinedLoadMetric(
      predefinedMetricType: Option[String] = None,
      resourceLabel: Option[String] = None
    ): PredictiveScalingPredefinedLoadMetric =
      PredictiveScalingPredefinedLoadMetric
        .builder
        .ifSome(predefinedMetricType)(_.predefinedMetricType(_))
        .ifSome(resourceLabel)(_.resourceLabel(_))
        .build

    def predictiveScalingPredefinedMetricPair(
      predefinedMetricType: Option[String] = None,
      resourceLabel: Option[String] = None
    ): PredictiveScalingPredefinedMetricPair =
      PredictiveScalingPredefinedMetricPair
        .builder
        .ifSome(predefinedMetricType)(_.predefinedMetricType(_))
        .ifSome(resourceLabel)(_.resourceLabel(_))
        .build

    def predictiveScalingPredefinedScalingMetric(
      predefinedMetricType: Option[String] = None,
      resourceLabel: Option[String] = None
    ): PredictiveScalingPredefinedScalingMetric =
      PredictiveScalingPredefinedScalingMetric
        .builder
        .ifSome(predefinedMetricType)(_.predefinedMetricType(_))
        .ifSome(resourceLabel)(_.resourceLabel(_))
        .build

    def processType(
      processName: Option[String] = None
    ): ProcessType =
      ProcessType
        .builder
        .ifSome(processName)(_.processName(_))
        .build

    def processesType(
      processes: Option[List[ProcessType]] = None
    ): ProcessesType =
      ProcessesType
        .builder
        .ifSome(processes)(_.processes(_))
        .build

    def putLifecycleHookAnswer(

    ): PutLifecycleHookAnswer =
      PutLifecycleHookAnswer
        .builder

        .build

    def putLifecycleHookType(
      lifecycleHookName: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      lifecycleTransition: Option[String] = None,
      roleARN: Option[String] = None,
      notificationTargetARN: Option[String] = None,
      notificationMetadata: Option[String] = None,
      heartbeatTimeout: Option[Int] = None,
      defaultResult: Option[String] = None
    ): PutLifecycleHookType =
      PutLifecycleHookType
        .builder
        .ifSome(lifecycleHookName)(_.lifecycleHookName(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(lifecycleTransition)(_.lifecycleTransition(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(notificationTargetARN)(_.notificationTargetARN(_))
        .ifSome(notificationMetadata)(_.notificationMetadata(_))
        .ifSome(heartbeatTimeout)(_.heartbeatTimeout(_))
        .ifSome(defaultResult)(_.defaultResult(_))
        .build

    def putNotificationConfigurationType(
      autoScalingGroupName: Option[String] = None,
      topicARN: Option[String] = None,
      notificationTypes: Option[List[XmlStringMaxLen255]] = None
    ): PutNotificationConfigurationType =
      PutNotificationConfigurationType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(topicARN)(_.topicARN(_))
        .ifSome(notificationTypes)(_.notificationTypes(_))
        .build

    def putScalingPolicyType(
      autoScalingGroupName: Option[String] = None,
      policyName: Option[String] = None,
      policyType: Option[String] = None,
      adjustmentType: Option[String] = None,
      minAdjustmentStep: Option[Int] = None,
      minAdjustmentMagnitude: Option[Int] = None,
      scalingAdjustment: Option[Int] = None,
      cooldown: Option[Int] = None,
      metricAggregationType: Option[String] = None,
      stepAdjustments: Option[List[StepAdjustment]] = None,
      estimatedInstanceWarmup: Option[Int] = None,
      targetTrackingConfiguration: Option[TargetTrackingConfiguration] = None,
      enabled: Option[Boolean] = None,
      predictiveScalingConfiguration: Option[PredictiveScalingConfiguration] = None
    ): PutScalingPolicyType =
      PutScalingPolicyType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(adjustmentType)(_.adjustmentType(_))
        .ifSome(minAdjustmentStep)(_.minAdjustmentStep(_))
        .ifSome(minAdjustmentMagnitude)(_.minAdjustmentMagnitude(_))
        .ifSome(scalingAdjustment)(_.scalingAdjustment(_))
        .ifSome(cooldown)(_.cooldown(_))
        .ifSome(metricAggregationType)(_.metricAggregationType(_))
        .ifSome(stepAdjustments)(_.stepAdjustments(_))
        .ifSome(estimatedInstanceWarmup)(_.estimatedInstanceWarmup(_))
        .ifSome(targetTrackingConfiguration)(_.targetTrackingConfiguration(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(predictiveScalingConfiguration)(_.predictiveScalingConfiguration(_))
        .build

    def putScheduledUpdateGroupActionType(
      autoScalingGroupName: Option[String] = None,
      scheduledActionName: Option[String] = None,
      time: Option[TimestampType] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      recurrence: Option[String] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      desiredCapacity: Option[Int] = None,
      timeZone: Option[String] = None
    ): PutScheduledUpdateGroupActionType =
      PutScheduledUpdateGroupActionType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(time)(_.time(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(recurrence)(_.recurrence(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(timeZone)(_.timeZone(_))
        .build

    def putWarmPoolAnswer(

    ): PutWarmPoolAnswer =
      PutWarmPoolAnswer
        .builder

        .build

    def putWarmPoolType(
      autoScalingGroupName: Option[String] = None,
      maxGroupPreparedCapacity: Option[Int] = None,
      minSize: Option[Int] = None,
      poolState: Option[String] = None
    ): PutWarmPoolType =
      PutWarmPoolType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(maxGroupPreparedCapacity)(_.maxGroupPreparedCapacity(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(poolState)(_.poolState(_))
        .build

    def recordLifecycleActionHeartbeatAnswer(

    ): RecordLifecycleActionHeartbeatAnswer =
      RecordLifecycleActionHeartbeatAnswer
        .builder

        .build

    def recordLifecycleActionHeartbeatType(
      lifecycleHookName: Option[String] = None,
      autoScalingGroupName: Option[String] = None,
      lifecycleActionToken: Option[String] = None,
      instanceId: Option[String] = None
    ): RecordLifecycleActionHeartbeatType =
      RecordLifecycleActionHeartbeatType
        .builder
        .ifSome(lifecycleHookName)(_.lifecycleHookName(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(lifecycleActionToken)(_.lifecycleActionToken(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def refreshPreferences(
      minHealthyPercentage: Option[Int] = None,
      instanceWarmup: Option[Int] = None,
      checkpointPercentages: Option[List[NonZeroIntPercent]] = None,
      checkpointDelay: Option[Int] = None
    ): RefreshPreferences =
      RefreshPreferences
        .builder
        .ifSome(minHealthyPercentage)(_.minHealthyPercentage(_))
        .ifSome(instanceWarmup)(_.instanceWarmup(_))
        .ifSome(checkpointPercentages)(_.checkpointPercentages(_))
        .ifSome(checkpointDelay)(_.checkpointDelay(_))
        .build

    def resourceContentionFault(
      message: Option[String] = None
    ): ResourceContentionFault =
      ResourceContentionFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceInUseFault(
      message: Option[String] = None
    ): ResourceInUseFault =
      ResourceInUseFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def scalingActivityInProgressFault(
      message: Option[String] = None
    ): ScalingActivityInProgressFault =
      ScalingActivityInProgressFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def scalingPolicy(
      autoScalingGroupName: Option[String] = None,
      policyName: Option[String] = None,
      policyARN: Option[String] = None,
      policyType: Option[String] = None,
      adjustmentType: Option[String] = None,
      minAdjustmentStep: Option[Int] = None,
      minAdjustmentMagnitude: Option[Int] = None,
      scalingAdjustment: Option[Int] = None,
      cooldown: Option[Int] = None,
      stepAdjustments: Option[List[StepAdjustment]] = None,
      metricAggregationType: Option[String] = None,
      estimatedInstanceWarmup: Option[Int] = None,
      alarms: Option[List[Alarm]] = None,
      targetTrackingConfiguration: Option[TargetTrackingConfiguration] = None,
      enabled: Option[Boolean] = None,
      predictiveScalingConfiguration: Option[PredictiveScalingConfiguration] = None
    ): ScalingPolicy =
      ScalingPolicy
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyARN)(_.policyARN(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(adjustmentType)(_.adjustmentType(_))
        .ifSome(minAdjustmentStep)(_.minAdjustmentStep(_))
        .ifSome(minAdjustmentMagnitude)(_.minAdjustmentMagnitude(_))
        .ifSome(scalingAdjustment)(_.scalingAdjustment(_))
        .ifSome(cooldown)(_.cooldown(_))
        .ifSome(stepAdjustments)(_.stepAdjustments(_))
        .ifSome(metricAggregationType)(_.metricAggregationType(_))
        .ifSome(estimatedInstanceWarmup)(_.estimatedInstanceWarmup(_))
        .ifSome(alarms)(_.alarms(_))
        .ifSome(targetTrackingConfiguration)(_.targetTrackingConfiguration(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(predictiveScalingConfiguration)(_.predictiveScalingConfiguration(_))
        .build

    def scalingProcessQuery(
      autoScalingGroupName: Option[String] = None,
      scalingProcesses: Option[List[XmlStringMaxLen255]] = None
    ): ScalingProcessQuery =
      ScalingProcessQuery
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(scalingProcesses)(_.scalingProcesses(_))
        .build

    def scheduledActionsType(
      scheduledUpdateGroupActions: Option[List[ScheduledUpdateGroupAction]] = None,
      nextToken: Option[String] = None
    ): ScheduledActionsType =
      ScheduledActionsType
        .builder
        .ifSome(scheduledUpdateGroupActions)(_.scheduledUpdateGroupActions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def scheduledUpdateGroupAction(
      autoScalingGroupName: Option[String] = None,
      scheduledActionName: Option[String] = None,
      scheduledActionARN: Option[String] = None,
      time: Option[TimestampType] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      recurrence: Option[String] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      desiredCapacity: Option[Int] = None,
      timeZone: Option[String] = None
    ): ScheduledUpdateGroupAction =
      ScheduledUpdateGroupAction
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(scheduledActionARN)(_.scheduledActionARN(_))
        .ifSome(time)(_.time(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(recurrence)(_.recurrence(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(timeZone)(_.timeZone(_))
        .build

    def scheduledUpdateGroupActionRequest(
      scheduledActionName: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      recurrence: Option[String] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      desiredCapacity: Option[Int] = None,
      timeZone: Option[String] = None
    ): ScheduledUpdateGroupActionRequest =
      ScheduledUpdateGroupActionRequest
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(recurrence)(_.recurrence(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(timeZone)(_.timeZone(_))
        .build

    def serviceLinkedRoleFailure(
      message: Option[String] = None
    ): ServiceLinkedRoleFailure =
      ServiceLinkedRoleFailure
        .builder
        .ifSome(message)(_.message(_))
        .build

    def setDesiredCapacityType(
      autoScalingGroupName: Option[String] = None,
      desiredCapacity: Option[Int] = None,
      honorCooldown: Option[Boolean] = None
    ): SetDesiredCapacityType =
      SetDesiredCapacityType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(honorCooldown)(_.honorCooldown(_))
        .build

    def setInstanceHealthQuery(
      instanceId: Option[String] = None,
      healthStatus: Option[String] = None,
      shouldRespectGracePeriod: Option[Boolean] = None
    ): SetInstanceHealthQuery =
      SetInstanceHealthQuery
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(shouldRespectGracePeriod)(_.shouldRespectGracePeriod(_))
        .build

    def setInstanceProtectionAnswer(

    ): SetInstanceProtectionAnswer =
      SetInstanceProtectionAnswer
        .builder

        .build

    def setInstanceProtectionQuery(
      instanceIds: Option[List[XmlStringMaxLen19]] = None,
      autoScalingGroupName: Option[String] = None,
      protectedFromScaleIn: Option[Boolean] = None
    ): SetInstanceProtectionQuery =
      SetInstanceProtectionQuery
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(protectedFromScaleIn)(_.protectedFromScaleIn(_))
        .build

    def startInstanceRefreshAnswer(
      instanceRefreshId: Option[String] = None
    ): StartInstanceRefreshAnswer =
      StartInstanceRefreshAnswer
        .builder
        .ifSome(instanceRefreshId)(_.instanceRefreshId(_))
        .build

    def startInstanceRefreshType(
      autoScalingGroupName: Option[String] = None,
      strategy: Option[String] = None,
      preferences: Option[RefreshPreferences] = None
    ): StartInstanceRefreshType =
      StartInstanceRefreshType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(strategy)(_.strategy(_))
        .ifSome(preferences)(_.preferences(_))
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

    def suspendedProcess(
      processName: Option[String] = None,
      suspensionReason: Option[String] = None
    ): SuspendedProcess =
      SuspendedProcess
        .builder
        .ifSome(processName)(_.processName(_))
        .ifSome(suspensionReason)(_.suspensionReason(_))
        .build

    def tag(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      key: Option[String] = None,
      value: Option[String] = None,
      propagateAtLaunch: Option[Boolean] = None
    ): Tag =
      Tag
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(propagateAtLaunch)(_.propagateAtLaunch(_))
        .build

    def tagDescription(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      key: Option[String] = None,
      value: Option[String] = None,
      propagateAtLaunch: Option[Boolean] = None
    ): TagDescription =
      TagDescription
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(propagateAtLaunch)(_.propagateAtLaunch(_))
        .build

    def tagsType(
      tags: Option[List[TagDescription]] = None,
      nextToken: Option[String] = None
    ): TagsType =
      TagsType
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def targetTrackingConfiguration(
      predefinedMetricSpecification: Option[PredefinedMetricSpecification] = None,
      customizedMetricSpecification: Option[CustomizedMetricSpecification] = None,
      targetValue: Option[MetricScale] = None,
      disableScaleIn: Option[Boolean] = None
    ): TargetTrackingConfiguration =
      TargetTrackingConfiguration
        .builder
        .ifSome(predefinedMetricSpecification)(_.predefinedMetricSpecification(_))
        .ifSome(customizedMetricSpecification)(_.customizedMetricSpecification(_))
        .ifSome(targetValue)(_.targetValue(_))
        .ifSome(disableScaleIn)(_.disableScaleIn(_))
        .build

    def terminateInstanceInAutoScalingGroupType(
      instanceId: Option[String] = None,
      shouldDecrementDesiredCapacity: Option[Boolean] = None
    ): TerminateInstanceInAutoScalingGroupType =
      TerminateInstanceInAutoScalingGroupType
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(shouldDecrementDesiredCapacity)(_.shouldDecrementDesiredCapacity(_))
        .build

    def updateAutoScalingGroupType(
      autoScalingGroupName: Option[String] = None,
      launchConfigurationName: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      mixedInstancesPolicy: Option[MixedInstancesPolicy] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      desiredCapacity: Option[Int] = None,
      defaultCooldown: Option[Int] = None,
      availabilityZones: Option[List[XmlStringMaxLen255]] = None,
      healthCheckType: Option[String] = None,
      healthCheckGracePeriod: Option[Int] = None,
      placementGroup: Option[String] = None,
      vPCZoneIdentifier: Option[String] = None,
      terminationPolicies: Option[List[XmlStringMaxLen1600]] = None,
      newInstancesProtectedFromScaleIn: Option[Boolean] = None,
      serviceLinkedRoleARN: Option[String] = None,
      maxInstanceLifetime: Option[Int] = None,
      capacityRebalance: Option[Boolean] = None
    ): UpdateAutoScalingGroupType =
      UpdateAutoScalingGroupType
        .builder
        .ifSome(autoScalingGroupName)(_.autoScalingGroupName(_))
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(mixedInstancesPolicy)(_.mixedInstancesPolicy(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(desiredCapacity)(_.desiredCapacity(_))
        .ifSome(defaultCooldown)(_.defaultCooldown(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(healthCheckType)(_.healthCheckType(_))
        .ifSome(healthCheckGracePeriod)(_.healthCheckGracePeriod(_))
        .ifSome(placementGroup)(_.placementGroup(_))
        .ifSome(vPCZoneIdentifier)(_.vPCZoneIdentifier(_))
        .ifSome(terminationPolicies)(_.terminationPolicies(_))
        .ifSome(newInstancesProtectedFromScaleIn)(_.newInstancesProtectedFromScaleIn(_))
        .ifSome(serviceLinkedRoleARN)(_.serviceLinkedRoleARN(_))
        .ifSome(maxInstanceLifetime)(_.maxInstanceLifetime(_))
        .ifSome(capacityRebalance)(_.capacityRebalance(_))
        .build

    def warmPoolConfiguration(
      maxGroupPreparedCapacity: Option[Int] = None,
      minSize: Option[Int] = None,
      poolState: Option[String] = None,
      status: Option[String] = None
    ): WarmPoolConfiguration =
      WarmPoolConfiguration
        .builder
        .ifSome(maxGroupPreparedCapacity)(_.maxGroupPreparedCapacity(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(poolState)(_.poolState(_))
        .ifSome(status)(_.status(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
