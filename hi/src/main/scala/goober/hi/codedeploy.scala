package goober.hi

import goober.free.codedeploy.CodeDeployIO
import software.amazon.awssdk.services.codedeploy.model._


object codedeploy {
  import goober.free.{codedeploy ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addTagsToOnPremisesInstancesInput(
      tags: Option[List[Tag]] = None,
      instanceNames: Option[List[InstanceName]] = None
    ): AddTagsToOnPremisesInstancesInput =
      AddTagsToOnPremisesInstancesInput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(instanceNames)(_.instanceNames(_))
        .build

    def alarm(
      name: Option[String] = None
    ): Alarm =
      Alarm
        .builder
        .ifSome(name)(_.name(_))
        .build

    def alarmConfiguration(
      enabled: Option[Boolean] = None,
      ignorePollAlarmFailure: Option[Boolean] = None,
      alarms: Option[List[Alarm]] = None
    ): AlarmConfiguration =
      AlarmConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(ignorePollAlarmFailure)(_.ignorePollAlarmFailure(_))
        .ifSome(alarms)(_.alarms(_))
        .build

    def alarmsLimitExceededException(

    ): AlarmsLimitExceededException =
      AlarmsLimitExceededException
        .builder

        .build

    def appSpecContent(
      content: Option[String] = None,
      sha256: Option[String] = None
    ): AppSpecContent =
      AppSpecContent
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(sha256)(_.sha256(_))
        .build

    def applicationAlreadyExistsException(

    ): ApplicationAlreadyExistsException =
      ApplicationAlreadyExistsException
        .builder

        .build

    def applicationDoesNotExistException(

    ): ApplicationDoesNotExistException =
      ApplicationDoesNotExistException
        .builder

        .build

    def applicationInfo(
      applicationId: Option[String] = None,
      applicationName: Option[String] = None,
      createTime: Option[Timestamp] = None,
      linkedToGitHub: Option[Boolean] = None,
      gitHubAccountName: Option[String] = None,
      computePlatform: Option[String] = None
    ): ApplicationInfo =
      ApplicationInfo
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(linkedToGitHub)(_.linkedToGitHub(_))
        .ifSome(gitHubAccountName)(_.gitHubAccountName(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .build

    def applicationLimitExceededException(

    ): ApplicationLimitExceededException =
      ApplicationLimitExceededException
        .builder

        .build

    def applicationNameRequiredException(

    ): ApplicationNameRequiredException =
      ApplicationNameRequiredException
        .builder

        .build

    def arnNotSupportedException(

    ): ArnNotSupportedException =
      ArnNotSupportedException
        .builder

        .build

    def autoRollbackConfiguration(
      enabled: Option[Boolean] = None,
      events: Option[List[AutoRollbackEvent]] = None
    ): AutoRollbackConfiguration =
      AutoRollbackConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(events)(_.events(_))
        .build

    def autoScalingGroup(
      name: Option[String] = None,
      hook: Option[String] = None
    ): AutoScalingGroup =
      AutoScalingGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(hook)(_.hook(_))
        .build

    def batchGetApplicationRevisionsInput(
      applicationName: Option[String] = None,
      revisions: Option[List[RevisionLocation]] = None
    ): BatchGetApplicationRevisionsInput =
      BatchGetApplicationRevisionsInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(revisions)(_.revisions(_))
        .build

    def batchGetApplicationRevisionsOutput(
      applicationName: Option[String] = None,
      errorMessage: Option[String] = None,
      revisions: Option[List[RevisionInfo]] = None
    ): BatchGetApplicationRevisionsOutput =
      BatchGetApplicationRevisionsOutput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(revisions)(_.revisions(_))
        .build

    def batchGetApplicationsInput(
      applicationNames: Option[List[ApplicationName]] = None
    ): BatchGetApplicationsInput =
      BatchGetApplicationsInput
        .builder
        .ifSome(applicationNames)(_.applicationNames(_))
        .build

    def batchGetApplicationsOutput(
      applicationsInfo: Option[List[ApplicationInfo]] = None
    ): BatchGetApplicationsOutput =
      BatchGetApplicationsOutput
        .builder
        .ifSome(applicationsInfo)(_.applicationsInfo(_))
        .build

    def batchGetDeploymentGroupsInput(
      applicationName: Option[String] = None,
      deploymentGroupNames: Option[List[DeploymentGroupName]] = None
    ): BatchGetDeploymentGroupsInput =
      BatchGetDeploymentGroupsInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupNames)(_.deploymentGroupNames(_))
        .build

    def batchGetDeploymentGroupsOutput(
      deploymentGroupsInfo: Option[List[DeploymentGroupInfo]] = None,
      errorMessage: Option[String] = None
    ): BatchGetDeploymentGroupsOutput =
      BatchGetDeploymentGroupsOutput
        .builder
        .ifSome(deploymentGroupsInfo)(_.deploymentGroupsInfo(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchGetDeploymentInstancesInput(
      deploymentId: Option[String] = None,
      instanceIds: Option[List[InstanceId]] = None
    ): BatchGetDeploymentInstancesInput =
      BatchGetDeploymentInstancesInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def batchGetDeploymentInstancesOutput(
      instancesSummary: Option[List[InstanceSummary]] = None,
      errorMessage: Option[String] = None
    ): BatchGetDeploymentInstancesOutput =
      BatchGetDeploymentInstancesOutput
        .builder
        .ifSome(instancesSummary)(_.instancesSummary(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchGetDeploymentTargetsInput(
      deploymentId: Option[String] = None,
      targetIds: Option[List[TargetId]] = None
    ): BatchGetDeploymentTargetsInput =
      BatchGetDeploymentTargetsInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(targetIds)(_.targetIds(_))
        .build

    def batchGetDeploymentTargetsOutput(
      deploymentTargets: Option[List[DeploymentTarget]] = None
    ): BatchGetDeploymentTargetsOutput =
      BatchGetDeploymentTargetsOutput
        .builder
        .ifSome(deploymentTargets)(_.deploymentTargets(_))
        .build

    def batchGetDeploymentsInput(
      deploymentIds: Option[List[DeploymentId]] = None
    ): BatchGetDeploymentsInput =
      BatchGetDeploymentsInput
        .builder
        .ifSome(deploymentIds)(_.deploymentIds(_))
        .build

    def batchGetDeploymentsOutput(
      deploymentsInfo: Option[List[DeploymentInfo]] = None
    ): BatchGetDeploymentsOutput =
      BatchGetDeploymentsOutput
        .builder
        .ifSome(deploymentsInfo)(_.deploymentsInfo(_))
        .build

    def batchGetOnPremisesInstancesInput(
      instanceNames: Option[List[InstanceName]] = None
    ): BatchGetOnPremisesInstancesInput =
      BatchGetOnPremisesInstancesInput
        .builder
        .ifSome(instanceNames)(_.instanceNames(_))
        .build

    def batchGetOnPremisesInstancesOutput(
      instanceInfos: Option[List[InstanceInfo]] = None
    ): BatchGetOnPremisesInstancesOutput =
      BatchGetOnPremisesInstancesOutput
        .builder
        .ifSome(instanceInfos)(_.instanceInfos(_))
        .build

    def batchLimitExceededException(

    ): BatchLimitExceededException =
      BatchLimitExceededException
        .builder

        .build

    def blueGreenDeploymentConfiguration(
      terminateBlueInstancesOnDeploymentSuccess: Option[BlueInstanceTerminationOption] = None,
      deploymentReadyOption: Option[DeploymentReadyOption] = None,
      greenFleetProvisioningOption: Option[GreenFleetProvisioningOption] = None
    ): BlueGreenDeploymentConfiguration =
      BlueGreenDeploymentConfiguration
        .builder
        .ifSome(terminateBlueInstancesOnDeploymentSuccess)(_.terminateBlueInstancesOnDeploymentSuccess(_))
        .ifSome(deploymentReadyOption)(_.deploymentReadyOption(_))
        .ifSome(greenFleetProvisioningOption)(_.greenFleetProvisioningOption(_))
        .build

    def blueInstanceTerminationOption(
      action: Option[String] = None,
      terminationWaitTimeInMinutes: Option[Int] = None
    ): BlueInstanceTerminationOption =
      BlueInstanceTerminationOption
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(terminationWaitTimeInMinutes)(_.terminationWaitTimeInMinutes(_))
        .build

    def bucketNameFilterRequiredException(

    ): BucketNameFilterRequiredException =
      BucketNameFilterRequiredException
        .builder

        .build

    def cloudFormationTarget(
      deploymentId: Option[String] = None,
      targetId: Option[String] = None,
      lastUpdatedAt: Option[Time] = None,
      lifecycleEvents: Option[List[LifecycleEvent]] = None,
      status: Option[String] = None,
      resourceType: Option[String] = None,
      targetVersionWeight: Option[TrafficWeight] = None
    ): CloudFormationTarget =
      CloudFormationTarget
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(lifecycleEvents)(_.lifecycleEvents(_))
        .ifSome(status)(_.status(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(targetVersionWeight)(_.targetVersionWeight(_))
        .build

    def continueDeploymentInput(
      deploymentId: Option[String] = None,
      deploymentWaitType: Option[String] = None
    ): ContinueDeploymentInput =
      ContinueDeploymentInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentWaitType)(_.deploymentWaitType(_))
        .build

    def createApplicationInput(
      applicationName: Option[String] = None,
      computePlatform: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateApplicationInput =
      CreateApplicationInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createApplicationOutput(
      applicationId: Option[String] = None
    ): CreateApplicationOutput =
      CreateApplicationOutput
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def createDeploymentConfigInput(
      deploymentConfigName: Option[String] = None,
      minimumHealthyHosts: Option[MinimumHealthyHosts] = None,
      trafficRoutingConfig: Option[TrafficRoutingConfig] = None,
      computePlatform: Option[String] = None
    ): CreateDeploymentConfigInput =
      CreateDeploymentConfigInput
        .builder
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .ifSome(minimumHealthyHosts)(_.minimumHealthyHosts(_))
        .ifSome(trafficRoutingConfig)(_.trafficRoutingConfig(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .build

    def createDeploymentConfigOutput(
      deploymentConfigId: Option[String] = None
    ): CreateDeploymentConfigOutput =
      CreateDeploymentConfigOutput
        .builder
        .ifSome(deploymentConfigId)(_.deploymentConfigId(_))
        .build

    def createDeploymentGroupInput(
      applicationName: Option[String] = None,
      deploymentGroupName: Option[String] = None,
      deploymentConfigName: Option[String] = None,
      ec2TagFilters: Option[List[EC2TagFilter]] = None,
      onPremisesInstanceTagFilters: Option[List[TagFilter]] = None,
      autoScalingGroups: Option[List[AutoScalingGroupName]] = None,
      serviceRoleArn: Option[String] = None,
      triggerConfigurations: Option[List[TriggerConfig]] = None,
      alarmConfiguration: Option[AlarmConfiguration] = None,
      autoRollbackConfiguration: Option[AutoRollbackConfiguration] = None,
      outdatedInstancesStrategy: Option[String] = None,
      deploymentStyle: Option[DeploymentStyle] = None,
      blueGreenDeploymentConfiguration: Option[BlueGreenDeploymentConfiguration] = None,
      loadBalancerInfo: Option[LoadBalancerInfo] = None,
      ec2TagSet: Option[EC2TagSet] = None,
      ecsServices: Option[List[ECSService]] = None,
      onPremisesTagSet: Option[OnPremisesTagSet] = None,
      tags: Option[List[Tag]] = None
    ): CreateDeploymentGroupInput =
      CreateDeploymentGroupInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupName)(_.deploymentGroupName(_))
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .ifSome(ec2TagFilters)(_.ec2TagFilters(_))
        .ifSome(onPremisesInstanceTagFilters)(_.onPremisesInstanceTagFilters(_))
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(triggerConfigurations)(_.triggerConfigurations(_))
        .ifSome(alarmConfiguration)(_.alarmConfiguration(_))
        .ifSome(autoRollbackConfiguration)(_.autoRollbackConfiguration(_))
        .ifSome(outdatedInstancesStrategy)(_.outdatedInstancesStrategy(_))
        .ifSome(deploymentStyle)(_.deploymentStyle(_))
        .ifSome(blueGreenDeploymentConfiguration)(_.blueGreenDeploymentConfiguration(_))
        .ifSome(loadBalancerInfo)(_.loadBalancerInfo(_))
        .ifSome(ec2TagSet)(_.ec2TagSet(_))
        .ifSome(ecsServices)(_.ecsServices(_))
        .ifSome(onPremisesTagSet)(_.onPremisesTagSet(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeploymentGroupOutput(
      deploymentGroupId: Option[String] = None
    ): CreateDeploymentGroupOutput =
      CreateDeploymentGroupOutput
        .builder
        .ifSome(deploymentGroupId)(_.deploymentGroupId(_))
        .build

    def createDeploymentInput(
      applicationName: Option[String] = None,
      deploymentGroupName: Option[String] = None,
      revision: Option[RevisionLocation] = None,
      deploymentConfigName: Option[String] = None,
      description: Option[String] = None,
      ignoreApplicationStopFailures: Option[Boolean] = None,
      targetInstances: Option[TargetInstances] = None,
      autoRollbackConfiguration: Option[AutoRollbackConfiguration] = None,
      updateOutdatedInstancesOnly: Option[Boolean] = None,
      fileExistsBehavior: Option[String] = None
    ): CreateDeploymentInput =
      CreateDeploymentInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupName)(_.deploymentGroupName(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .ifSome(description)(_.description(_))
        .ifSome(ignoreApplicationStopFailures)(_.ignoreApplicationStopFailures(_))
        .ifSome(targetInstances)(_.targetInstances(_))
        .ifSome(autoRollbackConfiguration)(_.autoRollbackConfiguration(_))
        .ifSome(updateOutdatedInstancesOnly)(_.updateOutdatedInstancesOnly(_))
        .ifSome(fileExistsBehavior)(_.fileExistsBehavior(_))
        .build

    def createDeploymentOutput(
      deploymentId: Option[String] = None
    ): CreateDeploymentOutput =
      CreateDeploymentOutput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def deleteApplicationInput(
      applicationName: Option[String] = None
    ): DeleteApplicationInput =
      DeleteApplicationInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .build

    def deleteDeploymentConfigInput(
      deploymentConfigName: Option[String] = None
    ): DeleteDeploymentConfigInput =
      DeleteDeploymentConfigInput
        .builder
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .build

    def deleteDeploymentGroupInput(
      applicationName: Option[String] = None,
      deploymentGroupName: Option[String] = None
    ): DeleteDeploymentGroupInput =
      DeleteDeploymentGroupInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupName)(_.deploymentGroupName(_))
        .build

    def deleteDeploymentGroupOutput(
      hooksNotCleanedUp: Option[List[AutoScalingGroup]] = None
    ): DeleteDeploymentGroupOutput =
      DeleteDeploymentGroupOutput
        .builder
        .ifSome(hooksNotCleanedUp)(_.hooksNotCleanedUp(_))
        .build

    def deleteGitHubAccountTokenInput(
      tokenName: Option[String] = None
    ): DeleteGitHubAccountTokenInput =
      DeleteGitHubAccountTokenInput
        .builder
        .ifSome(tokenName)(_.tokenName(_))
        .build

    def deleteGitHubAccountTokenOutput(
      tokenName: Option[String] = None
    ): DeleteGitHubAccountTokenOutput =
      DeleteGitHubAccountTokenOutput
        .builder
        .ifSome(tokenName)(_.tokenName(_))
        .build

    def deleteResourcesByExternalIdInput(
      externalId: Option[String] = None
    ): DeleteResourcesByExternalIdInput =
      DeleteResourcesByExternalIdInput
        .builder
        .ifSome(externalId)(_.externalId(_))
        .build

    def deleteResourcesByExternalIdOutput(

    ): DeleteResourcesByExternalIdOutput =
      DeleteResourcesByExternalIdOutput
        .builder

        .build

    def deploymentAlreadyCompletedException(

    ): DeploymentAlreadyCompletedException =
      DeploymentAlreadyCompletedException
        .builder

        .build

    def deploymentAlreadyStartedException(

    ): DeploymentAlreadyStartedException =
      DeploymentAlreadyStartedException
        .builder

        .build

    def deploymentConfigAlreadyExistsException(

    ): DeploymentConfigAlreadyExistsException =
      DeploymentConfigAlreadyExistsException
        .builder

        .build

    def deploymentConfigDoesNotExistException(

    ): DeploymentConfigDoesNotExistException =
      DeploymentConfigDoesNotExistException
        .builder

        .build

    def deploymentConfigInUseException(

    ): DeploymentConfigInUseException =
      DeploymentConfigInUseException
        .builder

        .build

    def deploymentConfigInfo(
      deploymentConfigId: Option[String] = None,
      deploymentConfigName: Option[String] = None,
      minimumHealthyHosts: Option[MinimumHealthyHosts] = None,
      createTime: Option[Timestamp] = None,
      computePlatform: Option[String] = None,
      trafficRoutingConfig: Option[TrafficRoutingConfig] = None
    ): DeploymentConfigInfo =
      DeploymentConfigInfo
        .builder
        .ifSome(deploymentConfigId)(_.deploymentConfigId(_))
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .ifSome(minimumHealthyHosts)(_.minimumHealthyHosts(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .ifSome(trafficRoutingConfig)(_.trafficRoutingConfig(_))
        .build

    def deploymentConfigLimitExceededException(

    ): DeploymentConfigLimitExceededException =
      DeploymentConfigLimitExceededException
        .builder

        .build

    def deploymentConfigNameRequiredException(

    ): DeploymentConfigNameRequiredException =
      DeploymentConfigNameRequiredException
        .builder

        .build

    def deploymentDoesNotExistException(

    ): DeploymentDoesNotExistException =
      DeploymentDoesNotExistException
        .builder

        .build

    def deploymentGroupAlreadyExistsException(

    ): DeploymentGroupAlreadyExistsException =
      DeploymentGroupAlreadyExistsException
        .builder

        .build

    def deploymentGroupDoesNotExistException(

    ): DeploymentGroupDoesNotExistException =
      DeploymentGroupDoesNotExistException
        .builder

        .build

    def deploymentGroupInfo(
      applicationName: Option[String] = None,
      deploymentGroupId: Option[String] = None,
      deploymentGroupName: Option[String] = None,
      deploymentConfigName: Option[String] = None,
      ec2TagFilters: Option[List[EC2TagFilter]] = None,
      onPremisesInstanceTagFilters: Option[List[TagFilter]] = None,
      autoScalingGroups: Option[List[AutoScalingGroup]] = None,
      serviceRoleArn: Option[String] = None,
      targetRevision: Option[RevisionLocation] = None,
      triggerConfigurations: Option[List[TriggerConfig]] = None,
      alarmConfiguration: Option[AlarmConfiguration] = None,
      autoRollbackConfiguration: Option[AutoRollbackConfiguration] = None,
      deploymentStyle: Option[DeploymentStyle] = None,
      outdatedInstancesStrategy: Option[String] = None,
      blueGreenDeploymentConfiguration: Option[BlueGreenDeploymentConfiguration] = None,
      loadBalancerInfo: Option[LoadBalancerInfo] = None,
      lastSuccessfulDeployment: Option[LastDeploymentInfo] = None,
      lastAttemptedDeployment: Option[LastDeploymentInfo] = None,
      ec2TagSet: Option[EC2TagSet] = None,
      onPremisesTagSet: Option[OnPremisesTagSet] = None,
      computePlatform: Option[String] = None,
      ecsServices: Option[List[ECSService]] = None
    ): DeploymentGroupInfo =
      DeploymentGroupInfo
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupId)(_.deploymentGroupId(_))
        .ifSome(deploymentGroupName)(_.deploymentGroupName(_))
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .ifSome(ec2TagFilters)(_.ec2TagFilters(_))
        .ifSome(onPremisesInstanceTagFilters)(_.onPremisesInstanceTagFilters(_))
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(targetRevision)(_.targetRevision(_))
        .ifSome(triggerConfigurations)(_.triggerConfigurations(_))
        .ifSome(alarmConfiguration)(_.alarmConfiguration(_))
        .ifSome(autoRollbackConfiguration)(_.autoRollbackConfiguration(_))
        .ifSome(deploymentStyle)(_.deploymentStyle(_))
        .ifSome(outdatedInstancesStrategy)(_.outdatedInstancesStrategy(_))
        .ifSome(blueGreenDeploymentConfiguration)(_.blueGreenDeploymentConfiguration(_))
        .ifSome(loadBalancerInfo)(_.loadBalancerInfo(_))
        .ifSome(lastSuccessfulDeployment)(_.lastSuccessfulDeployment(_))
        .ifSome(lastAttemptedDeployment)(_.lastAttemptedDeployment(_))
        .ifSome(ec2TagSet)(_.ec2TagSet(_))
        .ifSome(onPremisesTagSet)(_.onPremisesTagSet(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .ifSome(ecsServices)(_.ecsServices(_))
        .build

    def deploymentGroupLimitExceededException(

    ): DeploymentGroupLimitExceededException =
      DeploymentGroupLimitExceededException
        .builder

        .build

    def deploymentGroupNameRequiredException(

    ): DeploymentGroupNameRequiredException =
      DeploymentGroupNameRequiredException
        .builder

        .build

    def deploymentIdRequiredException(

    ): DeploymentIdRequiredException =
      DeploymentIdRequiredException
        .builder

        .build

    def deploymentInfo(
      applicationName: Option[String] = None,
      deploymentGroupName: Option[String] = None,
      deploymentConfigName: Option[String] = None,
      deploymentId: Option[String] = None,
      previousRevision: Option[RevisionLocation] = None,
      revision: Option[RevisionLocation] = None,
      status: Option[String] = None,
      errorInformation: Option[ErrorInformation] = None,
      createTime: Option[Timestamp] = None,
      startTime: Option[Timestamp] = None,
      completeTime: Option[Timestamp] = None,
      deploymentOverview: Option[DeploymentOverview] = None,
      description: Option[String] = None,
      creator: Option[String] = None,
      ignoreApplicationStopFailures: Option[Boolean] = None,
      autoRollbackConfiguration: Option[AutoRollbackConfiguration] = None,
      updateOutdatedInstancesOnly: Option[Boolean] = None,
      rollbackInfo: Option[RollbackInfo] = None,
      deploymentStyle: Option[DeploymentStyle] = None,
      targetInstances: Option[TargetInstances] = None,
      instanceTerminationWaitTimeStarted: Option[Boolean] = None,
      blueGreenDeploymentConfiguration: Option[BlueGreenDeploymentConfiguration] = None,
      loadBalancerInfo: Option[LoadBalancerInfo] = None,
      additionalDeploymentStatusInfo: Option[String] = None,
      fileExistsBehavior: Option[String] = None,
      deploymentStatusMessages: Option[List[ErrorMessage]] = None,
      computePlatform: Option[String] = None,
      externalId: Option[String] = None,
      relatedDeployments: Option[RelatedDeployments] = None
    ): DeploymentInfo =
      DeploymentInfo
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupName)(_.deploymentGroupName(_))
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(previousRevision)(_.previousRevision(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorInformation)(_.errorInformation(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(completeTime)(_.completeTime(_))
        .ifSome(deploymentOverview)(_.deploymentOverview(_))
        .ifSome(description)(_.description(_))
        .ifSome(creator)(_.creator(_))
        .ifSome(ignoreApplicationStopFailures)(_.ignoreApplicationStopFailures(_))
        .ifSome(autoRollbackConfiguration)(_.autoRollbackConfiguration(_))
        .ifSome(updateOutdatedInstancesOnly)(_.updateOutdatedInstancesOnly(_))
        .ifSome(rollbackInfo)(_.rollbackInfo(_))
        .ifSome(deploymentStyle)(_.deploymentStyle(_))
        .ifSome(targetInstances)(_.targetInstances(_))
        .ifSome(instanceTerminationWaitTimeStarted)(_.instanceTerminationWaitTimeStarted(_))
        .ifSome(blueGreenDeploymentConfiguration)(_.blueGreenDeploymentConfiguration(_))
        .ifSome(loadBalancerInfo)(_.loadBalancerInfo(_))
        .ifSome(additionalDeploymentStatusInfo)(_.additionalDeploymentStatusInfo(_))
        .ifSome(fileExistsBehavior)(_.fileExistsBehavior(_))
        .ifSome(deploymentStatusMessages)(_.deploymentStatusMessages(_))
        .ifSome(computePlatform)(_.computePlatform(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(relatedDeployments)(_.relatedDeployments(_))
        .build

    def deploymentIsNotInReadyStateException(

    ): DeploymentIsNotInReadyStateException =
      DeploymentIsNotInReadyStateException
        .builder

        .build

    def deploymentLimitExceededException(

    ): DeploymentLimitExceededException =
      DeploymentLimitExceededException
        .builder

        .build

    def deploymentNotStartedException(

    ): DeploymentNotStartedException =
      DeploymentNotStartedException
        .builder

        .build

    def deploymentOverview(
      pending: Option[InstanceCount] = None,
      inProgress: Option[InstanceCount] = None,
      succeeded: Option[InstanceCount] = None,
      failed: Option[InstanceCount] = None,
      skipped: Option[InstanceCount] = None,
      ready: Option[InstanceCount] = None
    ): DeploymentOverview =
      DeploymentOverview
        .builder
        .ifSome(pending)(_.pending(_))
        .ifSome(inProgress)(_.inProgress(_))
        .ifSome(succeeded)(_.succeeded(_))
        .ifSome(failed)(_.failed(_))
        .ifSome(skipped)(_.skipped(_))
        .ifSome(ready)(_.ready(_))
        .build

    def deploymentReadyOption(
      actionOnTimeout: Option[String] = None,
      waitTimeInMinutes: Option[Int] = None
    ): DeploymentReadyOption =
      DeploymentReadyOption
        .builder
        .ifSome(actionOnTimeout)(_.actionOnTimeout(_))
        .ifSome(waitTimeInMinutes)(_.waitTimeInMinutes(_))
        .build

    def deploymentStyle(
      deploymentType: Option[String] = None,
      deploymentOption: Option[String] = None
    ): DeploymentStyle =
      DeploymentStyle
        .builder
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(deploymentOption)(_.deploymentOption(_))
        .build

    def deploymentTarget(
      deploymentTargetType: Option[String] = None,
      instanceTarget: Option[InstanceTarget] = None,
      lambdaTarget: Option[LambdaTarget] = None,
      ecsTarget: Option[ECSTarget] = None,
      cloudFormationTarget: Option[CloudFormationTarget] = None
    ): DeploymentTarget =
      DeploymentTarget
        .builder
        .ifSome(deploymentTargetType)(_.deploymentTargetType(_))
        .ifSome(instanceTarget)(_.instanceTarget(_))
        .ifSome(lambdaTarget)(_.lambdaTarget(_))
        .ifSome(ecsTarget)(_.ecsTarget(_))
        .ifSome(cloudFormationTarget)(_.cloudFormationTarget(_))
        .build

    def deploymentTargetDoesNotExistException(

    ): DeploymentTargetDoesNotExistException =
      DeploymentTargetDoesNotExistException
        .builder

        .build

    def deploymentTargetIdRequiredException(

    ): DeploymentTargetIdRequiredException =
      DeploymentTargetIdRequiredException
        .builder

        .build

    def deploymentTargetListSizeExceededException(

    ): DeploymentTargetListSizeExceededException =
      DeploymentTargetListSizeExceededException
        .builder

        .build

    def deregisterOnPremisesInstanceInput(
      instanceName: Option[String] = None
    ): DeregisterOnPremisesInstanceInput =
      DeregisterOnPremisesInstanceInput
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def descriptionTooLongException(

    ): DescriptionTooLongException =
      DescriptionTooLongException
        .builder

        .build

    def diagnostics(
      errorCode: Option[String] = None,
      scriptName: Option[String] = None,
      message: Option[String] = None,
      logTail: Option[String] = None
    ): Diagnostics =
      Diagnostics
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(scriptName)(_.scriptName(_))
        .ifSome(message)(_.message(_))
        .ifSome(logTail)(_.logTail(_))
        .build

    def eC2TagFilter(
      key: Option[String] = None,
      value: Option[String] = None,
      `type`: Option[String] = None
    ): EC2TagFilter =
      EC2TagFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def eC2TagSet(
      ec2TagSetList: Option[List[EC2TagFilterList]] = None
    ): EC2TagSet =
      EC2TagSet
        .builder
        .ifSome(ec2TagSetList)(_.ec2TagSetList(_))
        .build

    def eCSService(
      serviceName: Option[String] = None,
      clusterName: Option[String] = None
    ): ECSService =
      ECSService
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(clusterName)(_.clusterName(_))
        .build

    def eCSServiceMappingLimitExceededException(

    ): ECSServiceMappingLimitExceededException =
      ECSServiceMappingLimitExceededException
        .builder

        .build

    def eCSTarget(
      deploymentId: Option[String] = None,
      targetId: Option[String] = None,
      targetArn: Option[String] = None,
      lastUpdatedAt: Option[Time] = None,
      lifecycleEvents: Option[List[LifecycleEvent]] = None,
      status: Option[String] = None,
      taskSetsInfo: Option[List[ECSTaskSet]] = None
    ): ECSTarget =
      ECSTarget
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(lifecycleEvents)(_.lifecycleEvents(_))
        .ifSome(status)(_.status(_))
        .ifSome(taskSetsInfo)(_.taskSetsInfo(_))
        .build

    def eCSTaskSet(
      identifer: Option[String] = None,
      desiredCount: Option[ECSTaskSetCount] = None,
      pendingCount: Option[ECSTaskSetCount] = None,
      runningCount: Option[ECSTaskSetCount] = None,
      status: Option[String] = None,
      trafficWeight: Option[TrafficWeight] = None,
      targetGroup: Option[TargetGroupInfo] = None,
      taskSetLabel: Option[String] = None
    ): ECSTaskSet =
      ECSTaskSet
        .builder
        .ifSome(identifer)(_.identifer(_))
        .ifSome(desiredCount)(_.desiredCount(_))
        .ifSome(pendingCount)(_.pendingCount(_))
        .ifSome(runningCount)(_.runningCount(_))
        .ifSome(status)(_.status(_))
        .ifSome(trafficWeight)(_.trafficWeight(_))
        .ifSome(targetGroup)(_.targetGroup(_))
        .ifSome(taskSetLabel)(_.taskSetLabel(_))
        .build

    def eLBInfo(
      name: Option[String] = None
    ): ELBInfo =
      ELBInfo
        .builder
        .ifSome(name)(_.name(_))
        .build

    def errorInformation(
      code: Option[String] = None,
      message: Option[String] = None
    ): ErrorInformation =
      ErrorInformation
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def genericRevisionInfo(
      description: Option[String] = None,
      deploymentGroups: Option[List[DeploymentGroupName]] = None,
      firstUsedTime: Option[Timestamp] = None,
      lastUsedTime: Option[Timestamp] = None,
      registerTime: Option[Timestamp] = None
    ): GenericRevisionInfo =
      GenericRevisionInfo
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(deploymentGroups)(_.deploymentGroups(_))
        .ifSome(firstUsedTime)(_.firstUsedTime(_))
        .ifSome(lastUsedTime)(_.lastUsedTime(_))
        .ifSome(registerTime)(_.registerTime(_))
        .build

    def getApplicationInput(
      applicationName: Option[String] = None
    ): GetApplicationInput =
      GetApplicationInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .build

    def getApplicationOutput(
      application: Option[ApplicationInfo] = None
    ): GetApplicationOutput =
      GetApplicationOutput
        .builder
        .ifSome(application)(_.application(_))
        .build

    def getApplicationRevisionInput(
      applicationName: Option[String] = None,
      revision: Option[RevisionLocation] = None
    ): GetApplicationRevisionInput =
      GetApplicationRevisionInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(revision)(_.revision(_))
        .build

    def getApplicationRevisionOutput(
      applicationName: Option[String] = None,
      revision: Option[RevisionLocation] = None,
      revisionInfo: Option[GenericRevisionInfo] = None
    ): GetApplicationRevisionOutput =
      GetApplicationRevisionOutput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(revisionInfo)(_.revisionInfo(_))
        .build

    def getDeploymentConfigInput(
      deploymentConfigName: Option[String] = None
    ): GetDeploymentConfigInput =
      GetDeploymentConfigInput
        .builder
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .build

    def getDeploymentConfigOutput(
      deploymentConfigInfo: Option[DeploymentConfigInfo] = None
    ): GetDeploymentConfigOutput =
      GetDeploymentConfigOutput
        .builder
        .ifSome(deploymentConfigInfo)(_.deploymentConfigInfo(_))
        .build

    def getDeploymentGroupInput(
      applicationName: Option[String] = None,
      deploymentGroupName: Option[String] = None
    ): GetDeploymentGroupInput =
      GetDeploymentGroupInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupName)(_.deploymentGroupName(_))
        .build

    def getDeploymentGroupOutput(
      deploymentGroupInfo: Option[DeploymentGroupInfo] = None
    ): GetDeploymentGroupOutput =
      GetDeploymentGroupOutput
        .builder
        .ifSome(deploymentGroupInfo)(_.deploymentGroupInfo(_))
        .build

    def getDeploymentInput(
      deploymentId: Option[String] = None
    ): GetDeploymentInput =
      GetDeploymentInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def getDeploymentInstanceInput(
      deploymentId: Option[String] = None,
      instanceId: Option[String] = None
    ): GetDeploymentInstanceInput =
      GetDeploymentInstanceInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def getDeploymentInstanceOutput(
      instanceSummary: Option[InstanceSummary] = None
    ): GetDeploymentInstanceOutput =
      GetDeploymentInstanceOutput
        .builder
        .ifSome(instanceSummary)(_.instanceSummary(_))
        .build

    def getDeploymentOutput(
      deploymentInfo: Option[DeploymentInfo] = None
    ): GetDeploymentOutput =
      GetDeploymentOutput
        .builder
        .ifSome(deploymentInfo)(_.deploymentInfo(_))
        .build

    def getDeploymentTargetInput(
      deploymentId: Option[String] = None,
      targetId: Option[String] = None
    ): GetDeploymentTargetInput =
      GetDeploymentTargetInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(targetId)(_.targetId(_))
        .build

    def getDeploymentTargetOutput(
      deploymentTarget: Option[DeploymentTarget] = None
    ): GetDeploymentTargetOutput =
      GetDeploymentTargetOutput
        .builder
        .ifSome(deploymentTarget)(_.deploymentTarget(_))
        .build

    def getOnPremisesInstanceInput(
      instanceName: Option[String] = None
    ): GetOnPremisesInstanceInput =
      GetOnPremisesInstanceInput
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def getOnPremisesInstanceOutput(
      instanceInfo: Option[InstanceInfo] = None
    ): GetOnPremisesInstanceOutput =
      GetOnPremisesInstanceOutput
        .builder
        .ifSome(instanceInfo)(_.instanceInfo(_))
        .build

    def gitHubAccountTokenDoesNotExistException(

    ): GitHubAccountTokenDoesNotExistException =
      GitHubAccountTokenDoesNotExistException
        .builder

        .build

    def gitHubAccountTokenNameRequiredException(

    ): GitHubAccountTokenNameRequiredException =
      GitHubAccountTokenNameRequiredException
        .builder

        .build

    def gitHubLocation(
      repository: Option[String] = None,
      commitId: Option[String] = None
    ): GitHubLocation =
      GitHubLocation
        .builder
        .ifSome(repository)(_.repository(_))
        .ifSome(commitId)(_.commitId(_))
        .build

    def greenFleetProvisioningOption(
      action: Option[String] = None
    ): GreenFleetProvisioningOption =
      GreenFleetProvisioningOption
        .builder
        .ifSome(action)(_.action(_))
        .build

    def iamArnRequiredException(

    ): IamArnRequiredException =
      IamArnRequiredException
        .builder

        .build

    def iamSessionArnAlreadyRegisteredException(

    ): IamSessionArnAlreadyRegisteredException =
      IamSessionArnAlreadyRegisteredException
        .builder

        .build

    def iamUserArnAlreadyRegisteredException(

    ): IamUserArnAlreadyRegisteredException =
      IamUserArnAlreadyRegisteredException
        .builder

        .build

    def iamUserArnRequiredException(

    ): IamUserArnRequiredException =
      IamUserArnRequiredException
        .builder

        .build

    def instanceDoesNotExistException(

    ): InstanceDoesNotExistException =
      InstanceDoesNotExistException
        .builder

        .build

    def instanceIdRequiredException(

    ): InstanceIdRequiredException =
      InstanceIdRequiredException
        .builder

        .build

    def instanceInfo(
      instanceName: Option[String] = None,
      iamSessionArn: Option[String] = None,
      iamUserArn: Option[String] = None,
      instanceArn: Option[String] = None,
      registerTime: Option[Timestamp] = None,
      deregisterTime: Option[Timestamp] = None,
      tags: Option[List[Tag]] = None
    ): InstanceInfo =
      InstanceInfo
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(iamSessionArn)(_.iamSessionArn(_))
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(registerTime)(_.registerTime(_))
        .ifSome(deregisterTime)(_.deregisterTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def instanceLimitExceededException(

    ): InstanceLimitExceededException =
      InstanceLimitExceededException
        .builder

        .build

    def instanceNameAlreadyRegisteredException(

    ): InstanceNameAlreadyRegisteredException =
      InstanceNameAlreadyRegisteredException
        .builder

        .build

    def instanceNameRequiredException(

    ): InstanceNameRequiredException =
      InstanceNameRequiredException
        .builder

        .build

    def instanceNotRegisteredException(

    ): InstanceNotRegisteredException =
      InstanceNotRegisteredException
        .builder

        .build

    def instanceSummary(
      deploymentId: Option[String] = None,
      instanceId: Option[String] = None,
      status: Option[String] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      lifecycleEvents: Option[List[LifecycleEvent]] = None,
      instanceType: Option[String] = None
    ): InstanceSummary =
      InstanceSummary
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(lifecycleEvents)(_.lifecycleEvents(_))
        .ifSome(instanceType)(_.instanceType(_))
        .build

    def instanceTarget(
      deploymentId: Option[String] = None,
      targetId: Option[String] = None,
      targetArn: Option[String] = None,
      status: Option[String] = None,
      lastUpdatedAt: Option[Time] = None,
      lifecycleEvents: Option[List[LifecycleEvent]] = None,
      instanceLabel: Option[String] = None
    ): InstanceTarget =
      InstanceTarget
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(lifecycleEvents)(_.lifecycleEvents(_))
        .ifSome(instanceLabel)(_.instanceLabel(_))
        .build

    def invalidAlarmConfigException(

    ): InvalidAlarmConfigException =
      InvalidAlarmConfigException
        .builder

        .build

    def invalidApplicationNameException(

    ): InvalidApplicationNameException =
      InvalidApplicationNameException
        .builder

        .build

    def invalidArnException(

    ): InvalidArnException =
      InvalidArnException
        .builder

        .build

    def invalidAutoRollbackConfigException(

    ): InvalidAutoRollbackConfigException =
      InvalidAutoRollbackConfigException
        .builder

        .build

    def invalidAutoScalingGroupException(

    ): InvalidAutoScalingGroupException =
      InvalidAutoScalingGroupException
        .builder

        .build

    def invalidBlueGreenDeploymentConfigurationException(

    ): InvalidBlueGreenDeploymentConfigurationException =
      InvalidBlueGreenDeploymentConfigurationException
        .builder

        .build

    def invalidBucketNameFilterException(

    ): InvalidBucketNameFilterException =
      InvalidBucketNameFilterException
        .builder

        .build

    def invalidComputePlatformException(

    ): InvalidComputePlatformException =
      InvalidComputePlatformException
        .builder

        .build

    def invalidDeployedStateFilterException(

    ): InvalidDeployedStateFilterException =
      InvalidDeployedStateFilterException
        .builder

        .build

    def invalidDeploymentConfigNameException(

    ): InvalidDeploymentConfigNameException =
      InvalidDeploymentConfigNameException
        .builder

        .build

    def invalidDeploymentGroupNameException(

    ): InvalidDeploymentGroupNameException =
      InvalidDeploymentGroupNameException
        .builder

        .build

    def invalidDeploymentIdException(

    ): InvalidDeploymentIdException =
      InvalidDeploymentIdException
        .builder

        .build

    def invalidDeploymentInstanceTypeException(

    ): InvalidDeploymentInstanceTypeException =
      InvalidDeploymentInstanceTypeException
        .builder

        .build

    def invalidDeploymentStatusException(

    ): InvalidDeploymentStatusException =
      InvalidDeploymentStatusException
        .builder

        .build

    def invalidDeploymentStyleException(

    ): InvalidDeploymentStyleException =
      InvalidDeploymentStyleException
        .builder

        .build

    def invalidDeploymentTargetIdException(

    ): InvalidDeploymentTargetIdException =
      InvalidDeploymentTargetIdException
        .builder

        .build

    def invalidDeploymentWaitTypeException(

    ): InvalidDeploymentWaitTypeException =
      InvalidDeploymentWaitTypeException
        .builder

        .build

    def invalidEC2TagCombinationException(

    ): InvalidEC2TagCombinationException =
      InvalidEC2TagCombinationException
        .builder

        .build

    def invalidEC2TagException(

    ): InvalidEC2TagException =
      InvalidEC2TagException
        .builder

        .build

    def invalidECSServiceException(

    ): InvalidECSServiceException =
      InvalidECSServiceException
        .builder

        .build

    def invalidExternalIdException(

    ): InvalidExternalIdException =
      InvalidExternalIdException
        .builder

        .build

    def invalidFileExistsBehaviorException(

    ): InvalidFileExistsBehaviorException =
      InvalidFileExistsBehaviorException
        .builder

        .build

    def invalidGitHubAccountTokenException(

    ): InvalidGitHubAccountTokenException =
      InvalidGitHubAccountTokenException
        .builder

        .build

    def invalidGitHubAccountTokenNameException(

    ): InvalidGitHubAccountTokenNameException =
      InvalidGitHubAccountTokenNameException
        .builder

        .build

    def invalidIamSessionArnException(

    ): InvalidIamSessionArnException =
      InvalidIamSessionArnException
        .builder

        .build

    def invalidIamUserArnException(

    ): InvalidIamUserArnException =
      InvalidIamUserArnException
        .builder

        .build

    def invalidIgnoreApplicationStopFailuresValueException(

    ): InvalidIgnoreApplicationStopFailuresValueException =
      InvalidIgnoreApplicationStopFailuresValueException
        .builder

        .build

    def invalidInputException(

    ): InvalidInputException =
      InvalidInputException
        .builder

        .build

    def invalidInstanceIdException(

    ): InvalidInstanceIdException =
      InvalidInstanceIdException
        .builder

        .build

    def invalidInstanceNameException(

    ): InvalidInstanceNameException =
      InvalidInstanceNameException
        .builder

        .build

    def invalidInstanceStatusException(

    ): InvalidInstanceStatusException =
      InvalidInstanceStatusException
        .builder

        .build

    def invalidInstanceTypeException(

    ): InvalidInstanceTypeException =
      InvalidInstanceTypeException
        .builder

        .build

    def invalidKeyPrefixFilterException(

    ): InvalidKeyPrefixFilterException =
      InvalidKeyPrefixFilterException
        .builder

        .build

    def invalidLifecycleEventHookExecutionIdException(

    ): InvalidLifecycleEventHookExecutionIdException =
      InvalidLifecycleEventHookExecutionIdException
        .builder

        .build

    def invalidLifecycleEventHookExecutionStatusException(

    ): InvalidLifecycleEventHookExecutionStatusException =
      InvalidLifecycleEventHookExecutionStatusException
        .builder

        .build

    def invalidLoadBalancerInfoException(

    ): InvalidLoadBalancerInfoException =
      InvalidLoadBalancerInfoException
        .builder

        .build

    def invalidMinimumHealthyHostValueException(

    ): InvalidMinimumHealthyHostValueException =
      InvalidMinimumHealthyHostValueException
        .builder

        .build

    def invalidNextTokenException(

    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder

        .build

    def invalidOnPremisesTagCombinationException(

    ): InvalidOnPremisesTagCombinationException =
      InvalidOnPremisesTagCombinationException
        .builder

        .build

    def invalidOperationException(

    ): InvalidOperationException =
      InvalidOperationException
        .builder

        .build

    def invalidRegistrationStatusException(

    ): InvalidRegistrationStatusException =
      InvalidRegistrationStatusException
        .builder

        .build

    def invalidRevisionException(

    ): InvalidRevisionException =
      InvalidRevisionException
        .builder

        .build

    def invalidRoleException(

    ): InvalidRoleException =
      InvalidRoleException
        .builder

        .build

    def invalidSortByException(

    ): InvalidSortByException =
      InvalidSortByException
        .builder

        .build

    def invalidSortOrderException(

    ): InvalidSortOrderException =
      InvalidSortOrderException
        .builder

        .build

    def invalidTagException(

    ): InvalidTagException =
      InvalidTagException
        .builder

        .build

    def invalidTagFilterException(

    ): InvalidTagFilterException =
      InvalidTagFilterException
        .builder

        .build

    def invalidTagsToAddException(

    ): InvalidTagsToAddException =
      InvalidTagsToAddException
        .builder

        .build

    def invalidTargetException(

    ): InvalidTargetException =
      InvalidTargetException
        .builder

        .build

    def invalidTargetFilterNameException(

    ): InvalidTargetFilterNameException =
      InvalidTargetFilterNameException
        .builder

        .build

    def invalidTargetGroupPairException(

    ): InvalidTargetGroupPairException =
      InvalidTargetGroupPairException
        .builder

        .build

    def invalidTargetInstancesException(

    ): InvalidTargetInstancesException =
      InvalidTargetInstancesException
        .builder

        .build

    def invalidTimeRangeException(

    ): InvalidTimeRangeException =
      InvalidTimeRangeException
        .builder

        .build

    def invalidTrafficRoutingConfigurationException(

    ): InvalidTrafficRoutingConfigurationException =
      InvalidTrafficRoutingConfigurationException
        .builder

        .build

    def invalidTriggerConfigException(

    ): InvalidTriggerConfigException =
      InvalidTriggerConfigException
        .builder

        .build

    def invalidUpdateOutdatedInstancesOnlyValueException(

    ): InvalidUpdateOutdatedInstancesOnlyValueException =
      InvalidUpdateOutdatedInstancesOnlyValueException
        .builder

        .build

    def lambdaFunctionInfo(
      functionName: Option[String] = None,
      functionAlias: Option[String] = None,
      currentVersion: Option[String] = None,
      targetVersion: Option[String] = None,
      targetVersionWeight: Option[TrafficWeight] = None
    ): LambdaFunctionInfo =
      LambdaFunctionInfo
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(functionAlias)(_.functionAlias(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(targetVersion)(_.targetVersion(_))
        .ifSome(targetVersionWeight)(_.targetVersionWeight(_))
        .build

    def lambdaTarget(
      deploymentId: Option[String] = None,
      targetId: Option[String] = None,
      targetArn: Option[String] = None,
      status: Option[String] = None,
      lastUpdatedAt: Option[Time] = None,
      lifecycleEvents: Option[List[LifecycleEvent]] = None,
      lambdaFunctionInfo: Option[LambdaFunctionInfo] = None
    ): LambdaTarget =
      LambdaTarget
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(lifecycleEvents)(_.lifecycleEvents(_))
        .ifSome(lambdaFunctionInfo)(_.lambdaFunctionInfo(_))
        .build

    def lastDeploymentInfo(
      deploymentId: Option[String] = None,
      status: Option[String] = None,
      endTime: Option[Timestamp] = None,
      createTime: Option[Timestamp] = None
    ): LastDeploymentInfo =
      LastDeploymentInfo
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(status)(_.status(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(createTime)(_.createTime(_))
        .build

    def lifecycleEvent(
      lifecycleEventName: Option[String] = None,
      diagnostics: Option[Diagnostics] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      status: Option[String] = None
    ): LifecycleEvent =
      LifecycleEvent
        .builder
        .ifSome(lifecycleEventName)(_.lifecycleEventName(_))
        .ifSome(diagnostics)(_.diagnostics(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(status)(_.status(_))
        .build

    def lifecycleEventAlreadyCompletedException(

    ): LifecycleEventAlreadyCompletedException =
      LifecycleEventAlreadyCompletedException
        .builder

        .build

    def lifecycleHookLimitExceededException(

    ): LifecycleHookLimitExceededException =
      LifecycleHookLimitExceededException
        .builder

        .build

    def listApplicationRevisionsInput(
      applicationName: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      s3Bucket: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      deployed: Option[String] = None,
      nextToken: Option[String] = None
    ): ListApplicationRevisionsInput =
      ListApplicationRevisionsInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(deployed)(_.deployed(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationRevisionsOutput(
      revisions: Option[List[RevisionLocation]] = None,
      nextToken: Option[String] = None
    ): ListApplicationRevisionsOutput =
      ListApplicationRevisionsOutput
        .builder
        .ifSome(revisions)(_.revisions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationsInput(
      nextToken: Option[String] = None
    ): ListApplicationsInput =
      ListApplicationsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationsOutput(
      applications: Option[List[ApplicationName]] = None,
      nextToken: Option[String] = None
    ): ListApplicationsOutput =
      ListApplicationsOutput
        .builder
        .ifSome(applications)(_.applications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentConfigsInput(
      nextToken: Option[String] = None
    ): ListDeploymentConfigsInput =
      ListDeploymentConfigsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentConfigsOutput(
      deploymentConfigsList: Option[List[DeploymentConfigName]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentConfigsOutput =
      ListDeploymentConfigsOutput
        .builder
        .ifSome(deploymentConfigsList)(_.deploymentConfigsList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentGroupsInput(
      applicationName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListDeploymentGroupsInput =
      ListDeploymentGroupsInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentGroupsOutput(
      applicationName: Option[String] = None,
      deploymentGroups: Option[List[DeploymentGroupName]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentGroupsOutput =
      ListDeploymentGroupsOutput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroups)(_.deploymentGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentInstancesInput(
      deploymentId: Option[String] = None,
      nextToken: Option[String] = None,
      instanceStatusFilter: Option[List[InstanceStatus]] = None,
      instanceTypeFilter: Option[List[InstanceType]] = None
    ): ListDeploymentInstancesInput =
      ListDeploymentInstancesInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(instanceStatusFilter)(_.instanceStatusFilter(_))
        .ifSome(instanceTypeFilter)(_.instanceTypeFilter(_))
        .build

    def listDeploymentInstancesOutput(
      instancesList: Option[List[InstanceId]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentInstancesOutput =
      ListDeploymentInstancesOutput
        .builder
        .ifSome(instancesList)(_.instancesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentTargetsInput(
      deploymentId: Option[String] = None,
      nextToken: Option[String] = None,
      targetFilters: Option[TargetFilters] = None
    ): ListDeploymentTargetsInput =
      ListDeploymentTargetsInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(targetFilters)(_.targetFilters(_))
        .build

    def listDeploymentTargetsOutput(
      targetIds: Option[List[TargetId]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentTargetsOutput =
      ListDeploymentTargetsOutput
        .builder
        .ifSome(targetIds)(_.targetIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentsInput(
      applicationName: Option[String] = None,
      deploymentGroupName: Option[String] = None,
      externalId: Option[String] = None,
      includeOnlyStatuses: Option[List[DeploymentStatus]] = None,
      createTimeRange: Option[TimeRange] = None,
      nextToken: Option[String] = None
    ): ListDeploymentsInput =
      ListDeploymentsInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(deploymentGroupName)(_.deploymentGroupName(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(includeOnlyStatuses)(_.includeOnlyStatuses(_))
        .ifSome(createTimeRange)(_.createTimeRange(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentsOutput(
      deployments: Option[List[DeploymentId]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentsOutput =
      ListDeploymentsOutput
        .builder
        .ifSome(deployments)(_.deployments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGitHubAccountTokenNamesInput(
      nextToken: Option[String] = None
    ): ListGitHubAccountTokenNamesInput =
      ListGitHubAccountTokenNamesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGitHubAccountTokenNamesOutput(
      tokenNameList: Option[List[GitHubAccountTokenName]] = None,
      nextToken: Option[String] = None
    ): ListGitHubAccountTokenNamesOutput =
      ListGitHubAccountTokenNamesOutput
        .builder
        .ifSome(tokenNameList)(_.tokenNameList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOnPremisesInstancesInput(
      registrationStatus: Option[String] = None,
      tagFilters: Option[List[TagFilter]] = None,
      nextToken: Option[String] = None
    ): ListOnPremisesInstancesInput =
      ListOnPremisesInstancesInput
        .builder
        .ifSome(registrationStatus)(_.registrationStatus(_))
        .ifSome(tagFilters)(_.tagFilters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOnPremisesInstancesOutput(
      instanceNames: Option[List[InstanceName]] = None,
      nextToken: Option[String] = None
    ): ListOnPremisesInstancesOutput =
      ListOnPremisesInstancesOutput
        .builder
        .ifSome(instanceNames)(_.instanceNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loadBalancerInfo(
      elbInfoList: Option[List[ELBInfo]] = None,
      targetGroupInfoList: Option[List[TargetGroupInfo]] = None,
      targetGroupPairInfoList: Option[List[TargetGroupPairInfo]] = None
    ): LoadBalancerInfo =
      LoadBalancerInfo
        .builder
        .ifSome(elbInfoList)(_.elbInfoList(_))
        .ifSome(targetGroupInfoList)(_.targetGroupInfoList(_))
        .ifSome(targetGroupPairInfoList)(_.targetGroupPairInfoList(_))
        .build

    def minimumHealthyHosts(
      `type`: Option[String] = None,
      value: Option[Int] = None
    ): MinimumHealthyHosts =
      MinimumHealthyHosts
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def multipleIamArnsProvidedException(

    ): MultipleIamArnsProvidedException =
      MultipleIamArnsProvidedException
        .builder

        .build

    def onPremisesTagSet(
      onPremisesTagSetList: Option[List[TagFilterList]] = None
    ): OnPremisesTagSet =
      OnPremisesTagSet
        .builder
        .ifSome(onPremisesTagSetList)(_.onPremisesTagSetList(_))
        .build

    def operationNotSupportedException(

    ): OperationNotSupportedException =
      OperationNotSupportedException
        .builder

        .build

    def putLifecycleEventHookExecutionStatusInput(
      deploymentId: Option[String] = None,
      lifecycleEventHookExecutionId: Option[String] = None,
      status: Option[String] = None
    ): PutLifecycleEventHookExecutionStatusInput =
      PutLifecycleEventHookExecutionStatusInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(lifecycleEventHookExecutionId)(_.lifecycleEventHookExecutionId(_))
        .ifSome(status)(_.status(_))
        .build

    def putLifecycleEventHookExecutionStatusOutput(
      lifecycleEventHookExecutionId: Option[String] = None
    ): PutLifecycleEventHookExecutionStatusOutput =
      PutLifecycleEventHookExecutionStatusOutput
        .builder
        .ifSome(lifecycleEventHookExecutionId)(_.lifecycleEventHookExecutionId(_))
        .build

    def rawString(
      content: Option[String] = None,
      sha256: Option[String] = None
    ): RawString =
      RawString
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(sha256)(_.sha256(_))
        .build

    def registerApplicationRevisionInput(
      applicationName: Option[String] = None,
      description: Option[String] = None,
      revision: Option[RevisionLocation] = None
    ): RegisterApplicationRevisionInput =
      RegisterApplicationRevisionInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(description)(_.description(_))
        .ifSome(revision)(_.revision(_))
        .build

    def registerOnPremisesInstanceInput(
      instanceName: Option[String] = None,
      iamSessionArn: Option[String] = None,
      iamUserArn: Option[String] = None
    ): RegisterOnPremisesInstanceInput =
      RegisterOnPremisesInstanceInput
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(iamSessionArn)(_.iamSessionArn(_))
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .build

    def relatedDeployments(
      autoUpdateOutdatedInstancesRootDeploymentId: Option[String] = None,
      autoUpdateOutdatedInstancesDeploymentIds: Option[List[DeploymentId]] = None
    ): RelatedDeployments =
      RelatedDeployments
        .builder
        .ifSome(autoUpdateOutdatedInstancesRootDeploymentId)(_.autoUpdateOutdatedInstancesRootDeploymentId(_))
        .ifSome(autoUpdateOutdatedInstancesDeploymentIds)(_.autoUpdateOutdatedInstancesDeploymentIds(_))
        .build

    def removeTagsFromOnPremisesInstancesInput(
      tags: Option[List[Tag]] = None,
      instanceNames: Option[List[InstanceName]] = None
    ): RemoveTagsFromOnPremisesInstancesInput =
      RemoveTagsFromOnPremisesInstancesInput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(instanceNames)(_.instanceNames(_))
        .build

    def resourceArnRequiredException(

    ): ResourceArnRequiredException =
      ResourceArnRequiredException
        .builder

        .build

    def resourceValidationException(

    ): ResourceValidationException =
      ResourceValidationException
        .builder

        .build

    def revisionDoesNotExistException(

    ): RevisionDoesNotExistException =
      RevisionDoesNotExistException
        .builder

        .build

    def revisionInfo(
      revisionLocation: Option[RevisionLocation] = None,
      genericRevisionInfo: Option[GenericRevisionInfo] = None
    ): RevisionInfo =
      RevisionInfo
        .builder
        .ifSome(revisionLocation)(_.revisionLocation(_))
        .ifSome(genericRevisionInfo)(_.genericRevisionInfo(_))
        .build

    def revisionLocation(
      revisionType: Option[String] = None,
      s3Location: Option[S3Location] = None,
      gitHubLocation: Option[GitHubLocation] = None,
      string: Option[RawString] = None,
      appSpecContent: Option[AppSpecContent] = None
    ): RevisionLocation =
      RevisionLocation
        .builder
        .ifSome(revisionType)(_.revisionType(_))
        .ifSome(s3Location)(_.s3Location(_))
        .ifSome(gitHubLocation)(_.gitHubLocation(_))
        .ifSome(string)(_.string(_))
        .ifSome(appSpecContent)(_.appSpecContent(_))
        .build

    def revisionRequiredException(

    ): RevisionRequiredException =
      RevisionRequiredException
        .builder

        .build

    def roleRequiredException(

    ): RoleRequiredException =
      RoleRequiredException
        .builder

        .build

    def rollbackInfo(
      rollbackDeploymentId: Option[String] = None,
      rollbackTriggeringDeploymentId: Option[String] = None,
      rollbackMessage: Option[String] = None
    ): RollbackInfo =
      RollbackInfo
        .builder
        .ifSome(rollbackDeploymentId)(_.rollbackDeploymentId(_))
        .ifSome(rollbackTriggeringDeploymentId)(_.rollbackTriggeringDeploymentId(_))
        .ifSome(rollbackMessage)(_.rollbackMessage(_))
        .build

    def s3Location(
      bucket: Option[String] = None,
      key: Option[String] = None,
      bundleType: Option[String] = None,
      version: Option[String] = None,
      eTag: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(bundleType)(_.bundleType(_))
        .ifSome(version)(_.version(_))
        .ifSome(eTag)(_.eTag(_))
        .build

    def skipWaitTimeForInstanceTerminationInput(
      deploymentId: Option[String] = None
    ): SkipWaitTimeForInstanceTerminationInput =
      SkipWaitTimeForInstanceTerminationInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def stopDeploymentInput(
      deploymentId: Option[String] = None,
      autoRollbackEnabled: Option[Boolean] = None
    ): StopDeploymentInput =
      StopDeploymentInput
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(autoRollbackEnabled)(_.autoRollbackEnabled(_))
        .build

    def stopDeploymentOutput(
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): StopDeploymentOutput =
      StopDeploymentOutput
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
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

    def tagFilter(
      key: Option[String] = None,
      value: Option[String] = None,
      `type`: Option[String] = None
    ): TagFilter =
      TagFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def tagLimitExceededException(

    ): TagLimitExceededException =
      TagLimitExceededException
        .builder

        .build

    def tagRequiredException(

    ): TagRequiredException =
      TagRequiredException
        .builder

        .build

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def tagSetListLimitExceededException(

    ): TagSetListLimitExceededException =
      TagSetListLimitExceededException
        .builder

        .build

    def targetGroupInfo(
      name: Option[String] = None
    ): TargetGroupInfo =
      TargetGroupInfo
        .builder
        .ifSome(name)(_.name(_))
        .build

    def targetGroupPairInfo(
      targetGroups: Option[List[TargetGroupInfo]] = None,
      prodTrafficRoute: Option[TrafficRoute] = None,
      testTrafficRoute: Option[TrafficRoute] = None
    ): TargetGroupPairInfo =
      TargetGroupPairInfo
        .builder
        .ifSome(targetGroups)(_.targetGroups(_))
        .ifSome(prodTrafficRoute)(_.prodTrafficRoute(_))
        .ifSome(testTrafficRoute)(_.testTrafficRoute(_))
        .build

    def targetInstances(
      tagFilters: Option[List[EC2TagFilter]] = None,
      autoScalingGroups: Option[List[AutoScalingGroupName]] = None,
      ec2TagSet: Option[EC2TagSet] = None
    ): TargetInstances =
      TargetInstances
        .builder
        .ifSome(tagFilters)(_.tagFilters(_))
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(ec2TagSet)(_.ec2TagSet(_))
        .build

    def throttlingException(

    ): ThrottlingException =
      ThrottlingException
        .builder

        .build

    def timeBasedCanary(
      canaryPercentage: Option[Int] = None,
      canaryInterval: Option[Int] = None
    ): TimeBasedCanary =
      TimeBasedCanary
        .builder
        .ifSome(canaryPercentage)(_.canaryPercentage(_))
        .ifSome(canaryInterval)(_.canaryInterval(_))
        .build

    def timeBasedLinear(
      linearPercentage: Option[Int] = None,
      linearInterval: Option[Int] = None
    ): TimeBasedLinear =
      TimeBasedLinear
        .builder
        .ifSome(linearPercentage)(_.linearPercentage(_))
        .ifSome(linearInterval)(_.linearInterval(_))
        .build

    def timeRange(
      start: Option[Timestamp] = None,
      end: Option[Timestamp] = None
    ): TimeRange =
      TimeRange
        .builder
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .build

    def trafficRoute(
      listenerArns: Option[List[ListenerArn]] = None
    ): TrafficRoute =
      TrafficRoute
        .builder
        .ifSome(listenerArns)(_.listenerArns(_))
        .build

    def trafficRoutingConfig(
      `type`: Option[String] = None,
      timeBasedCanary: Option[TimeBasedCanary] = None,
      timeBasedLinear: Option[TimeBasedLinear] = None
    ): TrafficRoutingConfig =
      TrafficRoutingConfig
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(timeBasedCanary)(_.timeBasedCanary(_))
        .ifSome(timeBasedLinear)(_.timeBasedLinear(_))
        .build

    def triggerConfig(
      triggerName: Option[String] = None,
      triggerTargetArn: Option[String] = None,
      triggerEvents: Option[List[TriggerEventType]] = None
    ): TriggerConfig =
      TriggerConfig
        .builder
        .ifSome(triggerName)(_.triggerName(_))
        .ifSome(triggerTargetArn)(_.triggerTargetArn(_))
        .ifSome(triggerEvents)(_.triggerEvents(_))
        .build

    def triggerTargetsLimitExceededException(

    ): TriggerTargetsLimitExceededException =
      TriggerTargetsLimitExceededException
        .builder

        .build

    def unsupportedActionForDeploymentTypeException(

    ): UnsupportedActionForDeploymentTypeException =
      UnsupportedActionForDeploymentTypeException
        .builder

        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[Key]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateApplicationInput(
      applicationName: Option[String] = None,
      newApplicationName: Option[String] = None
    ): UpdateApplicationInput =
      UpdateApplicationInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(newApplicationName)(_.newApplicationName(_))
        .build

    def updateDeploymentGroupInput(
      applicationName: Option[String] = None,
      currentDeploymentGroupName: Option[String] = None,
      newDeploymentGroupName: Option[String] = None,
      deploymentConfigName: Option[String] = None,
      ec2TagFilters: Option[List[EC2TagFilter]] = None,
      onPremisesInstanceTagFilters: Option[List[TagFilter]] = None,
      autoScalingGroups: Option[List[AutoScalingGroupName]] = None,
      serviceRoleArn: Option[String] = None,
      triggerConfigurations: Option[List[TriggerConfig]] = None,
      alarmConfiguration: Option[AlarmConfiguration] = None,
      autoRollbackConfiguration: Option[AutoRollbackConfiguration] = None,
      outdatedInstancesStrategy: Option[String] = None,
      deploymentStyle: Option[DeploymentStyle] = None,
      blueGreenDeploymentConfiguration: Option[BlueGreenDeploymentConfiguration] = None,
      loadBalancerInfo: Option[LoadBalancerInfo] = None,
      ec2TagSet: Option[EC2TagSet] = None,
      ecsServices: Option[List[ECSService]] = None,
      onPremisesTagSet: Option[OnPremisesTagSet] = None
    ): UpdateDeploymentGroupInput =
      UpdateDeploymentGroupInput
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentDeploymentGroupName)(_.currentDeploymentGroupName(_))
        .ifSome(newDeploymentGroupName)(_.newDeploymentGroupName(_))
        .ifSome(deploymentConfigName)(_.deploymentConfigName(_))
        .ifSome(ec2TagFilters)(_.ec2TagFilters(_))
        .ifSome(onPremisesInstanceTagFilters)(_.onPremisesInstanceTagFilters(_))
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(triggerConfigurations)(_.triggerConfigurations(_))
        .ifSome(alarmConfiguration)(_.alarmConfiguration(_))
        .ifSome(autoRollbackConfiguration)(_.autoRollbackConfiguration(_))
        .ifSome(outdatedInstancesStrategy)(_.outdatedInstancesStrategy(_))
        .ifSome(deploymentStyle)(_.deploymentStyle(_))
        .ifSome(blueGreenDeploymentConfiguration)(_.blueGreenDeploymentConfiguration(_))
        .ifSome(loadBalancerInfo)(_.loadBalancerInfo(_))
        .ifSome(ec2TagSet)(_.ec2TagSet(_))
        .ifSome(ecsServices)(_.ecsServices(_))
        .ifSome(onPremisesTagSet)(_.onPremisesTagSet(_))
        .build

    def updateDeploymentGroupOutput(
      hooksNotCleanedUp: Option[List[AutoScalingGroup]] = None
    ): UpdateDeploymentGroupOutput =
      UpdateDeploymentGroupOutput
        .builder
        .ifSome(hooksNotCleanedUp)(_.hooksNotCleanedUp(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
