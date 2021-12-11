package goober.hi

import goober.free.emr.EmrIO
import software.amazon.awssdk.services.emr.model._


object emr {
  import goober.free.{emr ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addInstanceFleetInput(
      clusterId: Option[String] = None,
      instanceFleet: Option[InstanceFleetConfig] = None
    ): AddInstanceFleetInput =
      AddInstanceFleetInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceFleet)(_.instanceFleet(_))
        .build

    def addInstanceFleetOutput(
      clusterId: Option[String] = None,
      instanceFleetId: Option[String] = None,
      clusterArn: Option[String] = None
    ): AddInstanceFleetOutput =
      AddInstanceFleetOutput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceFleetId)(_.instanceFleetId(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def addInstanceGroupsInput(
      instanceGroups: Option[List[InstanceGroupConfig]] = None,
      jobFlowId: Option[String] = None
    ): AddInstanceGroupsInput =
      AddInstanceGroupsInput
        .builder
        .ifSome(instanceGroups)(_.instanceGroups(_))
        .ifSome(jobFlowId)(_.jobFlowId(_))
        .build

    def addInstanceGroupsOutput(
      jobFlowId: Option[String] = None,
      instanceGroupIds: Option[List[XmlStringMaxLen256]] = None,
      clusterArn: Option[String] = None
    ): AddInstanceGroupsOutput =
      AddInstanceGroupsOutput
        .builder
        .ifSome(jobFlowId)(_.jobFlowId(_))
        .ifSome(instanceGroupIds)(_.instanceGroupIds(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def addJobFlowStepsInput(
      jobFlowId: Option[String] = None,
      steps: Option[List[StepConfig]] = None
    ): AddJobFlowStepsInput =
      AddJobFlowStepsInput
        .builder
        .ifSome(jobFlowId)(_.jobFlowId(_))
        .ifSome(steps)(_.steps(_))
        .build

    def addJobFlowStepsOutput(
      stepIds: Option[List[XmlStringMaxLen256]] = None
    ): AddJobFlowStepsOutput =
      AddJobFlowStepsOutput
        .builder
        .ifSome(stepIds)(_.stepIds(_))
        .build

    def addTagsInput(
      resourceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsInput =
      AddTagsInput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsOutput(

    ): AddTagsOutput =
      AddTagsOutput
        .builder

        .build

    def application(
      name: Option[String] = None,
      version: Option[String] = None,
      args: Option[List[String]] = None,
      additionalInfo: Option[StringMap] = None
    ): Application =
      Application
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(args)(_.args(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .build

    def autoScalingPolicy(
      constraints: Option[ScalingConstraints] = None,
      rules: Option[List[ScalingRule]] = None
    ): AutoScalingPolicy =
      AutoScalingPolicy
        .builder
        .ifSome(constraints)(_.constraints(_))
        .ifSome(rules)(_.rules(_))
        .build

    def autoScalingPolicyDescription(
      status: Option[AutoScalingPolicyStatus] = None,
      constraints: Option[ScalingConstraints] = None,
      rules: Option[List[ScalingRule]] = None
    ): AutoScalingPolicyDescription =
      AutoScalingPolicyDescription
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(constraints)(_.constraints(_))
        .ifSome(rules)(_.rules(_))
        .build

    def autoScalingPolicyStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): AutoScalingPolicyStateChangeReason =
      AutoScalingPolicyStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def autoScalingPolicyStatus(
      state: Option[String] = None,
      stateChangeReason: Option[AutoScalingPolicyStateChangeReason] = None
    ): AutoScalingPolicyStatus =
      AutoScalingPolicyStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .build

    def blockPublicAccessConfiguration(
      blockPublicSecurityGroupRules: Option[Boolean] = None,
      permittedPublicSecurityGroupRuleRanges: Option[List[PortRange]] = None
    ): BlockPublicAccessConfiguration =
      BlockPublicAccessConfiguration
        .builder
        .ifSome(blockPublicSecurityGroupRules)(_.blockPublicSecurityGroupRules(_))
        .ifSome(permittedPublicSecurityGroupRuleRanges)(_.permittedPublicSecurityGroupRuleRanges(_))
        .build

    def blockPublicAccessConfigurationMetadata(
      creationDateTime: Option[Date] = None,
      createdByArn: Option[String] = None
    ): BlockPublicAccessConfigurationMetadata =
      BlockPublicAccessConfigurationMetadata
        .builder
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(createdByArn)(_.createdByArn(_))
        .build

    def bootstrapActionConfig(
      name: Option[String] = None,
      scriptBootstrapAction: Option[ScriptBootstrapActionConfig] = None
    ): BootstrapActionConfig =
      BootstrapActionConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scriptBootstrapAction)(_.scriptBootstrapAction(_))
        .build

    def bootstrapActionDetail(
      bootstrapActionConfig: Option[BootstrapActionConfig] = None
    ): BootstrapActionDetail =
      BootstrapActionDetail
        .builder
        .ifSome(bootstrapActionConfig)(_.bootstrapActionConfig(_))
        .build

    def cancelStepsInfo(
      stepId: Option[String] = None,
      status: Option[String] = None,
      reason: Option[String] = None
    ): CancelStepsInfo =
      CancelStepsInfo
        .builder
        .ifSome(stepId)(_.stepId(_))
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .build

    def cancelStepsInput(
      clusterId: Option[String] = None,
      stepIds: Option[List[XmlStringMaxLen256]] = None,
      stepCancellationOption: Option[String] = None
    ): CancelStepsInput =
      CancelStepsInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(stepIds)(_.stepIds(_))
        .ifSome(stepCancellationOption)(_.stepCancellationOption(_))
        .build

    def cancelStepsOutput(
      cancelStepsInfoList: Option[List[CancelStepsInfo]] = None
    ): CancelStepsOutput =
      CancelStepsOutput
        .builder
        .ifSome(cancelStepsInfoList)(_.cancelStepsInfoList(_))
        .build

    def cloudWatchAlarmDefinition(
      comparisonOperator: Option[String] = None,
      evaluationPeriods: Option[Int] = None,
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      period: Option[Int] = None,
      statistic: Option[String] = None,
      threshold: Option[NonNegativeDouble] = None,
      unit: Option[String] = None,
      dimensions: Option[List[MetricDimension]] = None
    ): CloudWatchAlarmDefinition =
      CloudWatchAlarmDefinition
        .builder
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(period)(_.period(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(dimensions)(_.dimensions(_))
        .build

    def cluster(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[ClusterStatus] = None,
      ec2InstanceAttributes: Option[Ec2InstanceAttributes] = None,
      instanceCollectionType: Option[String] = None,
      logUri: Option[String] = None,
      logEncryptionKmsKeyId: Option[String] = None,
      requestedAmiVersion: Option[String] = None,
      runningAmiVersion: Option[String] = None,
      releaseLabel: Option[String] = None,
      autoTerminate: Option[Boolean] = None,
      terminationProtected: Option[Boolean] = None,
      visibleToAllUsers: Option[Boolean] = None,
      applications: Option[List[Application]] = None,
      tags: Option[List[Tag]] = None,
      serviceRole: Option[String] = None,
      normalizedInstanceHours: Option[Int] = None,
      masterPublicDnsName: Option[String] = None,
      configurations: Option[List[Configuration]] = None,
      securityConfiguration: Option[String] = None,
      autoScalingRole: Option[String] = None,
      scaleDownBehavior: Option[String] = None,
      customAmiId: Option[String] = None,
      ebsRootVolumeSize: Option[Int] = None,
      repoUpgradeOnBoot: Option[String] = None,
      kerberosAttributes: Option[KerberosAttributes] = None,
      clusterArn: Option[String] = None,
      outpostArn: Option[String] = None,
      stepConcurrencyLevel: Option[Int] = None,
      placementGroups: Option[List[PlacementGroupConfig]] = None
    ): Cluster =
      Cluster
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(ec2InstanceAttributes)(_.ec2InstanceAttributes(_))
        .ifSome(instanceCollectionType)(_.instanceCollectionType(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(logEncryptionKmsKeyId)(_.logEncryptionKmsKeyId(_))
        .ifSome(requestedAmiVersion)(_.requestedAmiVersion(_))
        .ifSome(runningAmiVersion)(_.runningAmiVersion(_))
        .ifSome(releaseLabel)(_.releaseLabel(_))
        .ifSome(autoTerminate)(_.autoTerminate(_))
        .ifSome(terminationProtected)(_.terminationProtected(_))
        .ifSome(visibleToAllUsers)(_.visibleToAllUsers(_))
        .ifSome(applications)(_.applications(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(normalizedInstanceHours)(_.normalizedInstanceHours(_))
        .ifSome(masterPublicDnsName)(_.masterPublicDnsName(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(autoScalingRole)(_.autoScalingRole(_))
        .ifSome(scaleDownBehavior)(_.scaleDownBehavior(_))
        .ifSome(customAmiId)(_.customAmiId(_))
        .ifSome(ebsRootVolumeSize)(_.ebsRootVolumeSize(_))
        .ifSome(repoUpgradeOnBoot)(_.repoUpgradeOnBoot(_))
        .ifSome(kerberosAttributes)(_.kerberosAttributes(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(stepConcurrencyLevel)(_.stepConcurrencyLevel(_))
        .ifSome(placementGroups)(_.placementGroups(_))
        .build

    def clusterStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): ClusterStateChangeReason =
      ClusterStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def clusterStatus(
      state: Option[String] = None,
      stateChangeReason: Option[ClusterStateChangeReason] = None,
      timeline: Option[ClusterTimeline] = None
    ): ClusterStatus =
      ClusterStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(timeline)(_.timeline(_))
        .build

    def clusterSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[ClusterStatus] = None,
      normalizedInstanceHours: Option[Int] = None,
      clusterArn: Option[String] = None,
      outpostArn: Option[String] = None
    ): ClusterSummary =
      ClusterSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(normalizedInstanceHours)(_.normalizedInstanceHours(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .build

    def clusterTimeline(
      creationDateTime: Option[Date] = None,
      readyDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None
    ): ClusterTimeline =
      ClusterTimeline
        .builder
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(readyDateTime)(_.readyDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .build

    def command(
      name: Option[String] = None,
      scriptPath: Option[String] = None,
      args: Option[List[String]] = None
    ): Command =
      Command
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scriptPath)(_.scriptPath(_))
        .ifSome(args)(_.args(_))
        .build

    def computeLimits(
      unitType: Option[String] = None,
      minimumCapacityUnits: Option[Int] = None,
      maximumCapacityUnits: Option[Int] = None,
      maximumOnDemandCapacityUnits: Option[Int] = None,
      maximumCoreCapacityUnits: Option[Int] = None
    ): ComputeLimits =
      ComputeLimits
        .builder
        .ifSome(unitType)(_.unitType(_))
        .ifSome(minimumCapacityUnits)(_.minimumCapacityUnits(_))
        .ifSome(maximumCapacityUnits)(_.maximumCapacityUnits(_))
        .ifSome(maximumOnDemandCapacityUnits)(_.maximumOnDemandCapacityUnits(_))
        .ifSome(maximumCoreCapacityUnits)(_.maximumCoreCapacityUnits(_))
        .build

    def configuration(
      classification: Option[String] = None,
      configurations: Option[List[Configuration]] = None,
      properties: Option[StringMap] = None
    ): Configuration =
      Configuration
        .builder
        .ifSome(classification)(_.classification(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(properties)(_.properties(_))
        .build

    def createSecurityConfigurationInput(
      name: Option[String] = None,
      securityConfiguration: Option[String] = None
    ): CreateSecurityConfigurationInput =
      CreateSecurityConfigurationInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .build

    def createSecurityConfigurationOutput(
      name: Option[String] = None,
      creationDateTime: Option[Date] = None
    ): CreateSecurityConfigurationOutput =
      CreateSecurityConfigurationOutput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def createStudioInput(
      name: Option[String] = None,
      description: Option[String] = None,
      authMode: Option[String] = None,
      vpcId: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      serviceRole: Option[String] = None,
      userRole: Option[String] = None,
      workspaceSecurityGroupId: Option[String] = None,
      engineSecurityGroupId: Option[String] = None,
      defaultS3Location: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateStudioInput =
      CreateStudioInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(authMode)(_.authMode(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(userRole)(_.userRole(_))
        .ifSome(workspaceSecurityGroupId)(_.workspaceSecurityGroupId(_))
        .ifSome(engineSecurityGroupId)(_.engineSecurityGroupId(_))
        .ifSome(defaultS3Location)(_.defaultS3Location(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStudioOutput(
      studioId: Option[String] = None,
      url: Option[String] = None
    ): CreateStudioOutput =
      CreateStudioOutput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(url)(_.url(_))
        .build

    def createStudioSessionMappingInput(
      studioId: Option[String] = None,
      identityId: Option[String] = None,
      identityName: Option[String] = None,
      identityType: Option[String] = None,
      sessionPolicyArn: Option[String] = None
    ): CreateStudioSessionMappingInput =
      CreateStudioSessionMappingInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityName)(_.identityName(_))
        .ifSome(identityType)(_.identityType(_))
        .ifSome(sessionPolicyArn)(_.sessionPolicyArn(_))
        .build

    def deleteSecurityConfigurationInput(
      name: Option[String] = None
    ): DeleteSecurityConfigurationInput =
      DeleteSecurityConfigurationInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteSecurityConfigurationOutput(

    ): DeleteSecurityConfigurationOutput =
      DeleteSecurityConfigurationOutput
        .builder

        .build

    def deleteStudioInput(
      studioId: Option[String] = None
    ): DeleteStudioInput =
      DeleteStudioInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteStudioSessionMappingInput(
      studioId: Option[String] = None,
      identityId: Option[String] = None,
      identityName: Option[String] = None,
      identityType: Option[String] = None
    ): DeleteStudioSessionMappingInput =
      DeleteStudioSessionMappingInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityName)(_.identityName(_))
        .ifSome(identityType)(_.identityType(_))
        .build

    def describeClusterInput(
      clusterId: Option[String] = None
    ): DescribeClusterInput =
      DescribeClusterInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def describeClusterOutput(
      cluster: Option[Cluster] = None
    ): DescribeClusterOutput =
      DescribeClusterOutput
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def describeJobFlowsInput(
      createdAfter: Option[Date] = None,
      createdBefore: Option[Date] = None,
      jobFlowIds: Option[List[XmlString]] = None,
      jobFlowStates: Option[List[JobFlowExecutionState]] = None
    ): DescribeJobFlowsInput =
      DescribeJobFlowsInput
        .builder
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(jobFlowIds)(_.jobFlowIds(_))
        .ifSome(jobFlowStates)(_.jobFlowStates(_))
        .build

    def describeJobFlowsOutput(
      jobFlows: Option[List[JobFlowDetail]] = None
    ): DescribeJobFlowsOutput =
      DescribeJobFlowsOutput
        .builder
        .ifSome(jobFlows)(_.jobFlows(_))
        .build

    def describeNotebookExecutionInput(
      notebookExecutionId: Option[String] = None
    ): DescribeNotebookExecutionInput =
      DescribeNotebookExecutionInput
        .builder
        .ifSome(notebookExecutionId)(_.notebookExecutionId(_))
        .build

    def describeNotebookExecutionOutput(
      notebookExecution: Option[NotebookExecution] = None
    ): DescribeNotebookExecutionOutput =
      DescribeNotebookExecutionOutput
        .builder
        .ifSome(notebookExecution)(_.notebookExecution(_))
        .build

    def describeSecurityConfigurationInput(
      name: Option[String] = None
    ): DescribeSecurityConfigurationInput =
      DescribeSecurityConfigurationInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeSecurityConfigurationOutput(
      name: Option[String] = None,
      securityConfiguration: Option[String] = None,
      creationDateTime: Option[Date] = None
    ): DescribeSecurityConfigurationOutput =
      DescribeSecurityConfigurationOutput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def describeStepInput(
      clusterId: Option[String] = None,
      stepId: Option[String] = None
    ): DescribeStepInput =
      DescribeStepInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(stepId)(_.stepId(_))
        .build

    def describeStepOutput(
      step: Option[Step] = None
    ): DescribeStepOutput =
      DescribeStepOutput
        .builder
        .ifSome(step)(_.step(_))
        .build

    def describeStudioInput(
      studioId: Option[String] = None
    ): DescribeStudioInput =
      DescribeStudioInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .build

    def describeStudioOutput(
      studio: Option[Studio] = None
    ): DescribeStudioOutput =
      DescribeStudioOutput
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def ebsBlockDevice(
      volumeSpecification: Option[VolumeSpecification] = None,
      device: Option[String] = None
    ): EbsBlockDevice =
      EbsBlockDevice
        .builder
        .ifSome(volumeSpecification)(_.volumeSpecification(_))
        .ifSome(device)(_.device(_))
        .build

    def ebsBlockDeviceConfig(
      volumeSpecification: Option[VolumeSpecification] = None,
      volumesPerInstance: Option[Int] = None
    ): EbsBlockDeviceConfig =
      EbsBlockDeviceConfig
        .builder
        .ifSome(volumeSpecification)(_.volumeSpecification(_))
        .ifSome(volumesPerInstance)(_.volumesPerInstance(_))
        .build

    def ebsConfiguration(
      ebsBlockDeviceConfigs: Option[List[EbsBlockDeviceConfig]] = None,
      ebsOptimized: Option[Boolean] = None
    ): EbsConfiguration =
      EbsConfiguration
        .builder
        .ifSome(ebsBlockDeviceConfigs)(_.ebsBlockDeviceConfigs(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .build

    def ebsVolume(
      device: Option[String] = None,
      volumeId: Option[String] = None
    ): EbsVolume =
      EbsVolume
        .builder
        .ifSome(device)(_.device(_))
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def ec2InstanceAttributes(
      ec2KeyName: Option[String] = None,
      ec2SubnetId: Option[String] = None,
      requestedEc2SubnetIds: Option[List[XmlStringMaxLen256]] = None,
      ec2AvailabilityZone: Option[String] = None,
      requestedEc2AvailabilityZones: Option[List[XmlStringMaxLen256]] = None,
      iamInstanceProfile: Option[String] = None,
      emrManagedMasterSecurityGroup: Option[String] = None,
      emrManagedSlaveSecurityGroup: Option[String] = None,
      serviceAccessSecurityGroup: Option[String] = None,
      additionalMasterSecurityGroups: Option[List[String]] = None,
      additionalSlaveSecurityGroups: Option[List[String]] = None
    ): Ec2InstanceAttributes =
      Ec2InstanceAttributes
        .builder
        .ifSome(ec2KeyName)(_.ec2KeyName(_))
        .ifSome(ec2SubnetId)(_.ec2SubnetId(_))
        .ifSome(requestedEc2SubnetIds)(_.requestedEc2SubnetIds(_))
        .ifSome(ec2AvailabilityZone)(_.ec2AvailabilityZone(_))
        .ifSome(requestedEc2AvailabilityZones)(_.requestedEc2AvailabilityZones(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(emrManagedMasterSecurityGroup)(_.emrManagedMasterSecurityGroup(_))
        .ifSome(emrManagedSlaveSecurityGroup)(_.emrManagedSlaveSecurityGroup(_))
        .ifSome(serviceAccessSecurityGroup)(_.serviceAccessSecurityGroup(_))
        .ifSome(additionalMasterSecurityGroups)(_.additionalMasterSecurityGroups(_))
        .ifSome(additionalSlaveSecurityGroups)(_.additionalSlaveSecurityGroups(_))
        .build

    def executionEngineConfig(
      id: Option[String] = None,
      `type`: Option[String] = None,
      masterInstanceSecurityGroupId: Option[String] = None
    ): ExecutionEngineConfig =
      ExecutionEngineConfig
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(masterInstanceSecurityGroupId)(_.masterInstanceSecurityGroupId(_))
        .build

    def failureDetails(
      reason: Option[String] = None,
      message: Option[String] = None,
      logFile: Option[String] = None
    ): FailureDetails =
      FailureDetails
        .builder
        .ifSome(reason)(_.reason(_))
        .ifSome(message)(_.message(_))
        .ifSome(logFile)(_.logFile(_))
        .build

    def getBlockPublicAccessConfigurationInput(

    ): GetBlockPublicAccessConfigurationInput =
      GetBlockPublicAccessConfigurationInput
        .builder

        .build

    def getBlockPublicAccessConfigurationOutput(
      blockPublicAccessConfiguration: Option[BlockPublicAccessConfiguration] = None,
      blockPublicAccessConfigurationMetadata: Option[BlockPublicAccessConfigurationMetadata] = None
    ): GetBlockPublicAccessConfigurationOutput =
      GetBlockPublicAccessConfigurationOutput
        .builder
        .ifSome(blockPublicAccessConfiguration)(_.blockPublicAccessConfiguration(_))
        .ifSome(blockPublicAccessConfigurationMetadata)(_.blockPublicAccessConfigurationMetadata(_))
        .build

    def getManagedScalingPolicyInput(
      clusterId: Option[String] = None
    ): GetManagedScalingPolicyInput =
      GetManagedScalingPolicyInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def getManagedScalingPolicyOutput(
      managedScalingPolicy: Option[ManagedScalingPolicy] = None
    ): GetManagedScalingPolicyOutput =
      GetManagedScalingPolicyOutput
        .builder
        .ifSome(managedScalingPolicy)(_.managedScalingPolicy(_))
        .build

    def getStudioSessionMappingInput(
      studioId: Option[String] = None,
      identityId: Option[String] = None,
      identityName: Option[String] = None,
      identityType: Option[String] = None
    ): GetStudioSessionMappingInput =
      GetStudioSessionMappingInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityName)(_.identityName(_))
        .ifSome(identityType)(_.identityType(_))
        .build

    def getStudioSessionMappingOutput(
      sessionMapping: Option[SessionMappingDetail] = None
    ): GetStudioSessionMappingOutput =
      GetStudioSessionMappingOutput
        .builder
        .ifSome(sessionMapping)(_.sessionMapping(_))
        .build

    def hadoopJarStepConfig(
      properties: Option[List[KeyValue]] = None,
      jar: Option[String] = None,
      mainClass: Option[String] = None,
      args: Option[List[XmlString]] = None
    ): HadoopJarStepConfig =
      HadoopJarStepConfig
        .builder
        .ifSome(properties)(_.properties(_))
        .ifSome(jar)(_.jar(_))
        .ifSome(mainClass)(_.mainClass(_))
        .ifSome(args)(_.args(_))
        .build

    def hadoopStepConfig(
      jar: Option[String] = None,
      properties: Option[StringMap] = None,
      mainClass: Option[String] = None,
      args: Option[List[String]] = None
    ): HadoopStepConfig =
      HadoopStepConfig
        .builder
        .ifSome(jar)(_.jar(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(mainClass)(_.mainClass(_))
        .ifSome(args)(_.args(_))
        .build

    def instance(
      id: Option[String] = None,
      ec2InstanceId: Option[String] = None,
      publicDnsName: Option[String] = None,
      publicIpAddress: Option[String] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None,
      status: Option[InstanceStatus] = None,
      instanceGroupId: Option[String] = None,
      instanceFleetId: Option[String] = None,
      market: Option[String] = None,
      instanceType: Option[String] = None,
      ebsVolumes: Option[List[EbsVolume]] = None
    ): Instance =
      Instance
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ec2InstanceId)(_.ec2InstanceId(_))
        .ifSome(publicDnsName)(_.publicDnsName(_))
        .ifSome(publicIpAddress)(_.publicIpAddress(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(status)(_.status(_))
        .ifSome(instanceGroupId)(_.instanceGroupId(_))
        .ifSome(instanceFleetId)(_.instanceFleetId(_))
        .ifSome(market)(_.market(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(ebsVolumes)(_.ebsVolumes(_))
        .build

    def instanceFleet(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[InstanceFleetStatus] = None,
      instanceFleetType: Option[String] = None,
      targetOnDemandCapacity: Option[Int] = None,
      targetSpotCapacity: Option[Int] = None,
      provisionedOnDemandCapacity: Option[Int] = None,
      provisionedSpotCapacity: Option[Int] = None,
      instanceTypeSpecifications: Option[List[InstanceTypeSpecification]] = None,
      launchSpecifications: Option[InstanceFleetProvisioningSpecifications] = None
    ): InstanceFleet =
      InstanceFleet
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(instanceFleetType)(_.instanceFleetType(_))
        .ifSome(targetOnDemandCapacity)(_.targetOnDemandCapacity(_))
        .ifSome(targetSpotCapacity)(_.targetSpotCapacity(_))
        .ifSome(provisionedOnDemandCapacity)(_.provisionedOnDemandCapacity(_))
        .ifSome(provisionedSpotCapacity)(_.provisionedSpotCapacity(_))
        .ifSome(instanceTypeSpecifications)(_.instanceTypeSpecifications(_))
        .ifSome(launchSpecifications)(_.launchSpecifications(_))
        .build

    def instanceFleetConfig(
      name: Option[String] = None,
      instanceFleetType: Option[String] = None,
      targetOnDemandCapacity: Option[Int] = None,
      targetSpotCapacity: Option[Int] = None,
      instanceTypeConfigs: Option[List[InstanceTypeConfig]] = None,
      launchSpecifications: Option[InstanceFleetProvisioningSpecifications] = None
    ): InstanceFleetConfig =
      InstanceFleetConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(instanceFleetType)(_.instanceFleetType(_))
        .ifSome(targetOnDemandCapacity)(_.targetOnDemandCapacity(_))
        .ifSome(targetSpotCapacity)(_.targetSpotCapacity(_))
        .ifSome(instanceTypeConfigs)(_.instanceTypeConfigs(_))
        .ifSome(launchSpecifications)(_.launchSpecifications(_))
        .build

    def instanceFleetModifyConfig(
      instanceFleetId: Option[String] = None,
      targetOnDemandCapacity: Option[Int] = None,
      targetSpotCapacity: Option[Int] = None
    ): InstanceFleetModifyConfig =
      InstanceFleetModifyConfig
        .builder
        .ifSome(instanceFleetId)(_.instanceFleetId(_))
        .ifSome(targetOnDemandCapacity)(_.targetOnDemandCapacity(_))
        .ifSome(targetSpotCapacity)(_.targetSpotCapacity(_))
        .build

    def instanceFleetProvisioningSpecifications(
      spotSpecification: Option[SpotProvisioningSpecification] = None,
      onDemandSpecification: Option[OnDemandProvisioningSpecification] = None
    ): InstanceFleetProvisioningSpecifications =
      InstanceFleetProvisioningSpecifications
        .builder
        .ifSome(spotSpecification)(_.spotSpecification(_))
        .ifSome(onDemandSpecification)(_.onDemandSpecification(_))
        .build

    def instanceFleetStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): InstanceFleetStateChangeReason =
      InstanceFleetStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def instanceFleetStatus(
      state: Option[String] = None,
      stateChangeReason: Option[InstanceFleetStateChangeReason] = None,
      timeline: Option[InstanceFleetTimeline] = None
    ): InstanceFleetStatus =
      InstanceFleetStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(timeline)(_.timeline(_))
        .build

    def instanceFleetTimeline(
      creationDateTime: Option[Date] = None,
      readyDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None
    ): InstanceFleetTimeline =
      InstanceFleetTimeline
        .builder
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(readyDateTime)(_.readyDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .build

    def instanceGroup(
      id: Option[String] = None,
      name: Option[String] = None,
      market: Option[String] = None,
      instanceGroupType: Option[String] = None,
      bidPrice: Option[String] = None,
      instanceType: Option[String] = None,
      requestedInstanceCount: Option[Int] = None,
      runningInstanceCount: Option[Int] = None,
      status: Option[InstanceGroupStatus] = None,
      configurations: Option[List[Configuration]] = None,
      configurationsVersion: Option[Long] = None,
      lastSuccessfullyAppliedConfigurations: Option[List[Configuration]] = None,
      lastSuccessfullyAppliedConfigurationsVersion: Option[Long] = None,
      ebsBlockDevices: Option[List[EbsBlockDevice]] = None,
      ebsOptimized: Option[Boolean] = None,
      shrinkPolicy: Option[ShrinkPolicy] = None,
      autoScalingPolicy: Option[AutoScalingPolicyDescription] = None
    ): InstanceGroup =
      InstanceGroup
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(market)(_.market(_))
        .ifSome(instanceGroupType)(_.instanceGroupType(_))
        .ifSome(bidPrice)(_.bidPrice(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(requestedInstanceCount)(_.requestedInstanceCount(_))
        .ifSome(runningInstanceCount)(_.runningInstanceCount(_))
        .ifSome(status)(_.status(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(configurationsVersion)(_.configurationsVersion(_))
        .ifSome(lastSuccessfullyAppliedConfigurations)(_.lastSuccessfullyAppliedConfigurations(_))
        .ifSome(lastSuccessfullyAppliedConfigurationsVersion)(_.lastSuccessfullyAppliedConfigurationsVersion(_))
        .ifSome(ebsBlockDevices)(_.ebsBlockDevices(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(shrinkPolicy)(_.shrinkPolicy(_))
        .ifSome(autoScalingPolicy)(_.autoScalingPolicy(_))
        .build

    def instanceGroupConfig(
      name: Option[String] = None,
      market: Option[String] = None,
      instanceRole: Option[String] = None,
      bidPrice: Option[String] = None,
      instanceType: Option[String] = None,
      instanceCount: Option[Int] = None,
      configurations: Option[List[Configuration]] = None,
      ebsConfiguration: Option[EbsConfiguration] = None,
      autoScalingPolicy: Option[AutoScalingPolicy] = None
    ): InstanceGroupConfig =
      InstanceGroupConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(market)(_.market(_))
        .ifSome(instanceRole)(_.instanceRole(_))
        .ifSome(bidPrice)(_.bidPrice(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(ebsConfiguration)(_.ebsConfiguration(_))
        .ifSome(autoScalingPolicy)(_.autoScalingPolicy(_))
        .build

    def instanceGroupDetail(
      instanceGroupId: Option[String] = None,
      name: Option[String] = None,
      market: Option[String] = None,
      instanceRole: Option[String] = None,
      bidPrice: Option[String] = None,
      instanceType: Option[String] = None,
      instanceRequestCount: Option[Int] = None,
      instanceRunningCount: Option[Int] = None,
      state: Option[String] = None,
      lastStateChangeReason: Option[String] = None,
      creationDateTime: Option[Date] = None,
      startDateTime: Option[Date] = None,
      readyDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None
    ): InstanceGroupDetail =
      InstanceGroupDetail
        .builder
        .ifSome(instanceGroupId)(_.instanceGroupId(_))
        .ifSome(name)(_.name(_))
        .ifSome(market)(_.market(_))
        .ifSome(instanceRole)(_.instanceRole(_))
        .ifSome(bidPrice)(_.bidPrice(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceRequestCount)(_.instanceRequestCount(_))
        .ifSome(instanceRunningCount)(_.instanceRunningCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(lastStateChangeReason)(_.lastStateChangeReason(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(startDateTime)(_.startDateTime(_))
        .ifSome(readyDateTime)(_.readyDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .build

    def instanceGroupModifyConfig(
      instanceGroupId: Option[String] = None,
      instanceCount: Option[Int] = None,
      eC2InstanceIdsToTerminate: Option[List[InstanceId]] = None,
      shrinkPolicy: Option[ShrinkPolicy] = None,
      configurations: Option[List[Configuration]] = None
    ): InstanceGroupModifyConfig =
      InstanceGroupModifyConfig
        .builder
        .ifSome(instanceGroupId)(_.instanceGroupId(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(eC2InstanceIdsToTerminate)(_.eC2InstanceIdsToTerminate(_))
        .ifSome(shrinkPolicy)(_.shrinkPolicy(_))
        .ifSome(configurations)(_.configurations(_))
        .build

    def instanceGroupStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): InstanceGroupStateChangeReason =
      InstanceGroupStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def instanceGroupStatus(
      state: Option[String] = None,
      stateChangeReason: Option[InstanceGroupStateChangeReason] = None,
      timeline: Option[InstanceGroupTimeline] = None
    ): InstanceGroupStatus =
      InstanceGroupStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(timeline)(_.timeline(_))
        .build

    def instanceGroupTimeline(
      creationDateTime: Option[Date] = None,
      readyDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None
    ): InstanceGroupTimeline =
      InstanceGroupTimeline
        .builder
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(readyDateTime)(_.readyDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .build

    def instanceResizePolicy(
      instancesToTerminate: Option[List[InstanceId]] = None,
      instancesToProtect: Option[List[InstanceId]] = None,
      instanceTerminationTimeout: Option[Int] = None
    ): InstanceResizePolicy =
      InstanceResizePolicy
        .builder
        .ifSome(instancesToTerminate)(_.instancesToTerminate(_))
        .ifSome(instancesToProtect)(_.instancesToProtect(_))
        .ifSome(instanceTerminationTimeout)(_.instanceTerminationTimeout(_))
        .build

    def instanceStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): InstanceStateChangeReason =
      InstanceStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def instanceStatus(
      state: Option[String] = None,
      stateChangeReason: Option[InstanceStateChangeReason] = None,
      timeline: Option[InstanceTimeline] = None
    ): InstanceStatus =
      InstanceStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(timeline)(_.timeline(_))
        .build

    def instanceTimeline(
      creationDateTime: Option[Date] = None,
      readyDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None
    ): InstanceTimeline =
      InstanceTimeline
        .builder
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(readyDateTime)(_.readyDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .build

    def instanceTypeConfig(
      instanceType: Option[String] = None,
      weightedCapacity: Option[Int] = None,
      bidPrice: Option[String] = None,
      bidPriceAsPercentageOfOnDemandPrice: Option[NonNegativeDouble] = None,
      ebsConfiguration: Option[EbsConfiguration] = None,
      configurations: Option[List[Configuration]] = None
    ): InstanceTypeConfig =
      InstanceTypeConfig
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .ifSome(bidPrice)(_.bidPrice(_))
        .ifSome(bidPriceAsPercentageOfOnDemandPrice)(_.bidPriceAsPercentageOfOnDemandPrice(_))
        .ifSome(ebsConfiguration)(_.ebsConfiguration(_))
        .ifSome(configurations)(_.configurations(_))
        .build

    def instanceTypeSpecification(
      instanceType: Option[String] = None,
      weightedCapacity: Option[Int] = None,
      bidPrice: Option[String] = None,
      bidPriceAsPercentageOfOnDemandPrice: Option[NonNegativeDouble] = None,
      configurations: Option[List[Configuration]] = None,
      ebsBlockDevices: Option[List[EbsBlockDevice]] = None,
      ebsOptimized: Option[Boolean] = None
    ): InstanceTypeSpecification =
      InstanceTypeSpecification
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .ifSome(bidPrice)(_.bidPrice(_))
        .ifSome(bidPriceAsPercentageOfOnDemandPrice)(_.bidPriceAsPercentageOfOnDemandPrice(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(ebsBlockDevices)(_.ebsBlockDevices(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .build

    def internalServerError(

    ): InternalServerError =
      InternalServerError
        .builder

        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def jobFlowDetail(
      jobFlowId: Option[String] = None,
      name: Option[String] = None,
      logUri: Option[String] = None,
      logEncryptionKmsKeyId: Option[String] = None,
      amiVersion: Option[String] = None,
      executionStatusDetail: Option[JobFlowExecutionStatusDetail] = None,
      instances: Option[JobFlowInstancesDetail] = None,
      steps: Option[List[StepDetail]] = None,
      bootstrapActions: Option[List[BootstrapActionDetail]] = None,
      supportedProducts: Option[List[XmlStringMaxLen256]] = None,
      visibleToAllUsers: Option[Boolean] = None,
      jobFlowRole: Option[String] = None,
      serviceRole: Option[String] = None,
      autoScalingRole: Option[String] = None,
      scaleDownBehavior: Option[String] = None
    ): JobFlowDetail =
      JobFlowDetail
        .builder
        .ifSome(jobFlowId)(_.jobFlowId(_))
        .ifSome(name)(_.name(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(logEncryptionKmsKeyId)(_.logEncryptionKmsKeyId(_))
        .ifSome(amiVersion)(_.amiVersion(_))
        .ifSome(executionStatusDetail)(_.executionStatusDetail(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(steps)(_.steps(_))
        .ifSome(bootstrapActions)(_.bootstrapActions(_))
        .ifSome(supportedProducts)(_.supportedProducts(_))
        .ifSome(visibleToAllUsers)(_.visibleToAllUsers(_))
        .ifSome(jobFlowRole)(_.jobFlowRole(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(autoScalingRole)(_.autoScalingRole(_))
        .ifSome(scaleDownBehavior)(_.scaleDownBehavior(_))
        .build

    def jobFlowExecutionStatusDetail(
      state: Option[String] = None,
      creationDateTime: Option[Date] = None,
      startDateTime: Option[Date] = None,
      readyDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None,
      lastStateChangeReason: Option[String] = None
    ): JobFlowExecutionStatusDetail =
      JobFlowExecutionStatusDetail
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(startDateTime)(_.startDateTime(_))
        .ifSome(readyDateTime)(_.readyDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .ifSome(lastStateChangeReason)(_.lastStateChangeReason(_))
        .build

    def jobFlowInstancesConfig(
      masterInstanceType: Option[String] = None,
      slaveInstanceType: Option[String] = None,
      instanceCount: Option[Int] = None,
      instanceGroups: Option[List[InstanceGroupConfig]] = None,
      instanceFleets: Option[List[InstanceFleetConfig]] = None,
      ec2KeyName: Option[String] = None,
      placement: Option[PlacementType] = None,
      keepJobFlowAliveWhenNoSteps: Option[Boolean] = None,
      terminationProtected: Option[Boolean] = None,
      hadoopVersion: Option[String] = None,
      ec2SubnetId: Option[String] = None,
      ec2SubnetIds: Option[List[XmlStringMaxLen256]] = None,
      emrManagedMasterSecurityGroup: Option[String] = None,
      emrManagedSlaveSecurityGroup: Option[String] = None,
      serviceAccessSecurityGroup: Option[String] = None,
      additionalMasterSecurityGroups: Option[List[XmlStringMaxLen256]] = None,
      additionalSlaveSecurityGroups: Option[List[XmlStringMaxLen256]] = None
    ): JobFlowInstancesConfig =
      JobFlowInstancesConfig
        .builder
        .ifSome(masterInstanceType)(_.masterInstanceType(_))
        .ifSome(slaveInstanceType)(_.slaveInstanceType(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(instanceGroups)(_.instanceGroups(_))
        .ifSome(instanceFleets)(_.instanceFleets(_))
        .ifSome(ec2KeyName)(_.ec2KeyName(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(keepJobFlowAliveWhenNoSteps)(_.keepJobFlowAliveWhenNoSteps(_))
        .ifSome(terminationProtected)(_.terminationProtected(_))
        .ifSome(hadoopVersion)(_.hadoopVersion(_))
        .ifSome(ec2SubnetId)(_.ec2SubnetId(_))
        .ifSome(ec2SubnetIds)(_.ec2SubnetIds(_))
        .ifSome(emrManagedMasterSecurityGroup)(_.emrManagedMasterSecurityGroup(_))
        .ifSome(emrManagedSlaveSecurityGroup)(_.emrManagedSlaveSecurityGroup(_))
        .ifSome(serviceAccessSecurityGroup)(_.serviceAccessSecurityGroup(_))
        .ifSome(additionalMasterSecurityGroups)(_.additionalMasterSecurityGroups(_))
        .ifSome(additionalSlaveSecurityGroups)(_.additionalSlaveSecurityGroups(_))
        .build

    def jobFlowInstancesDetail(
      masterInstanceType: Option[String] = None,
      masterPublicDnsName: Option[String] = None,
      masterInstanceId: Option[String] = None,
      slaveInstanceType: Option[String] = None,
      instanceCount: Option[Int] = None,
      instanceGroups: Option[List[InstanceGroupDetail]] = None,
      normalizedInstanceHours: Option[Int] = None,
      ec2KeyName: Option[String] = None,
      ec2SubnetId: Option[String] = None,
      placement: Option[PlacementType] = None,
      keepJobFlowAliveWhenNoSteps: Option[Boolean] = None,
      terminationProtected: Option[Boolean] = None,
      hadoopVersion: Option[String] = None
    ): JobFlowInstancesDetail =
      JobFlowInstancesDetail
        .builder
        .ifSome(masterInstanceType)(_.masterInstanceType(_))
        .ifSome(masterPublicDnsName)(_.masterPublicDnsName(_))
        .ifSome(masterInstanceId)(_.masterInstanceId(_))
        .ifSome(slaveInstanceType)(_.slaveInstanceType(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(instanceGroups)(_.instanceGroups(_))
        .ifSome(normalizedInstanceHours)(_.normalizedInstanceHours(_))
        .ifSome(ec2KeyName)(_.ec2KeyName(_))
        .ifSome(ec2SubnetId)(_.ec2SubnetId(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(keepJobFlowAliveWhenNoSteps)(_.keepJobFlowAliveWhenNoSteps(_))
        .ifSome(terminationProtected)(_.terminationProtected(_))
        .ifSome(hadoopVersion)(_.hadoopVersion(_))
        .build

    def kerberosAttributes(
      realm: Option[String] = None,
      kdcAdminPassword: Option[String] = None,
      crossRealmTrustPrincipalPassword: Option[String] = None,
      aDDomainJoinUser: Option[String] = None,
      aDDomainJoinPassword: Option[String] = None
    ): KerberosAttributes =
      KerberosAttributes
        .builder
        .ifSome(realm)(_.realm(_))
        .ifSome(kdcAdminPassword)(_.kdcAdminPassword(_))
        .ifSome(crossRealmTrustPrincipalPassword)(_.crossRealmTrustPrincipalPassword(_))
        .ifSome(aDDomainJoinUser)(_.aDDomainJoinUser(_))
        .ifSome(aDDomainJoinPassword)(_.aDDomainJoinPassword(_))
        .build

    def keyValue(
      key: Option[String] = None,
      value: Option[String] = None
    ): KeyValue =
      KeyValue
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def listBootstrapActionsInput(
      clusterId: Option[String] = None,
      marker: Option[String] = None
    ): ListBootstrapActionsInput =
      ListBootstrapActionsInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listBootstrapActionsOutput(
      bootstrapActions: Option[List[Command]] = None,
      marker: Option[String] = None
    ): ListBootstrapActionsOutput =
      ListBootstrapActionsOutput
        .builder
        .ifSome(bootstrapActions)(_.bootstrapActions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listClustersInput(
      createdAfter: Option[Date] = None,
      createdBefore: Option[Date] = None,
      clusterStates: Option[List[ClusterState]] = None,
      marker: Option[String] = None
    ): ListClustersInput =
      ListClustersInput
        .builder
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(clusterStates)(_.clusterStates(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listClustersOutput(
      clusters: Option[List[ClusterSummary]] = None,
      marker: Option[String] = None
    ): ListClustersOutput =
      ListClustersOutput
        .builder
        .ifSome(clusters)(_.clusters(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstanceFleetsInput(
      clusterId: Option[String] = None,
      marker: Option[String] = None
    ): ListInstanceFleetsInput =
      ListInstanceFleetsInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstanceFleetsOutput(
      instanceFleets: Option[List[InstanceFleet]] = None,
      marker: Option[String] = None
    ): ListInstanceFleetsOutput =
      ListInstanceFleetsOutput
        .builder
        .ifSome(instanceFleets)(_.instanceFleets(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstanceGroupsInput(
      clusterId: Option[String] = None,
      marker: Option[String] = None
    ): ListInstanceGroupsInput =
      ListInstanceGroupsInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstanceGroupsOutput(
      instanceGroups: Option[List[InstanceGroup]] = None,
      marker: Option[String] = None
    ): ListInstanceGroupsOutput =
      ListInstanceGroupsOutput
        .builder
        .ifSome(instanceGroups)(_.instanceGroups(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstancesInput(
      clusterId: Option[String] = None,
      instanceGroupId: Option[String] = None,
      instanceGroupTypes: Option[List[InstanceGroupType]] = None,
      instanceFleetId: Option[String] = None,
      instanceFleetType: Option[String] = None,
      instanceStates: Option[List[InstanceState]] = None,
      marker: Option[String] = None
    ): ListInstancesInput =
      ListInstancesInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceGroupId)(_.instanceGroupId(_))
        .ifSome(instanceGroupTypes)(_.instanceGroupTypes(_))
        .ifSome(instanceFleetId)(_.instanceFleetId(_))
        .ifSome(instanceFleetType)(_.instanceFleetType(_))
        .ifSome(instanceStates)(_.instanceStates(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstancesOutput(
      instances: Option[List[Instance]] = None,
      marker: Option[String] = None
    ): ListInstancesOutput =
      ListInstancesOutput
        .builder
        .ifSome(instances)(_.instances(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listNotebookExecutionsInput(
      editorId: Option[String] = None,
      status: Option[String] = None,
      from: Option[Date] = None,
      to: Option[Date] = None,
      marker: Option[String] = None
    ): ListNotebookExecutionsInput =
      ListNotebookExecutionsInput
        .builder
        .ifSome(editorId)(_.editorId(_))
        .ifSome(status)(_.status(_))
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listNotebookExecutionsOutput(
      notebookExecutions: Option[List[NotebookExecutionSummary]] = None,
      marker: Option[String] = None
    ): ListNotebookExecutionsOutput =
      ListNotebookExecutionsOutput
        .builder
        .ifSome(notebookExecutions)(_.notebookExecutions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listSecurityConfigurationsInput(
      marker: Option[String] = None
    ): ListSecurityConfigurationsInput =
      ListSecurityConfigurationsInput
        .builder
        .ifSome(marker)(_.marker(_))
        .build

    def listSecurityConfigurationsOutput(
      securityConfigurations: Option[List[SecurityConfigurationSummary]] = None,
      marker: Option[String] = None
    ): ListSecurityConfigurationsOutput =
      ListSecurityConfigurationsOutput
        .builder
        .ifSome(securityConfigurations)(_.securityConfigurations(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listStepsInput(
      clusterId: Option[String] = None,
      stepStates: Option[List[StepState]] = None,
      stepIds: Option[List[XmlString]] = None,
      marker: Option[String] = None
    ): ListStepsInput =
      ListStepsInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(stepStates)(_.stepStates(_))
        .ifSome(stepIds)(_.stepIds(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listStepsOutput(
      steps: Option[List[StepSummary]] = None,
      marker: Option[String] = None
    ): ListStepsOutput =
      ListStepsOutput
        .builder
        .ifSome(steps)(_.steps(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listStudioSessionMappingsInput(
      studioId: Option[String] = None,
      identityType: Option[String] = None,
      marker: Option[String] = None
    ): ListStudioSessionMappingsInput =
      ListStudioSessionMappingsInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(identityType)(_.identityType(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listStudioSessionMappingsOutput(
      sessionMappings: Option[List[SessionMappingSummary]] = None,
      marker: Option[String] = None
    ): ListStudioSessionMappingsOutput =
      ListStudioSessionMappingsOutput
        .builder
        .ifSome(sessionMappings)(_.sessionMappings(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listStudiosInput(
      marker: Option[String] = None
    ): ListStudiosInput =
      ListStudiosInput
        .builder
        .ifSome(marker)(_.marker(_))
        .build

    def listStudiosOutput(
      studios: Option[List[StudioSummary]] = None,
      marker: Option[String] = None
    ): ListStudiosOutput =
      ListStudiosOutput
        .builder
        .ifSome(studios)(_.studios(_))
        .ifSome(marker)(_.marker(_))
        .build

    def managedScalingPolicy(
      computeLimits: Option[ComputeLimits] = None
    ): ManagedScalingPolicy =
      ManagedScalingPolicy
        .builder
        .ifSome(computeLimits)(_.computeLimits(_))
        .build

    def metricDimension(
      key: Option[String] = None,
      value: Option[String] = None
    ): MetricDimension =
      MetricDimension
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def modifyClusterInput(
      clusterId: Option[String] = None,
      stepConcurrencyLevel: Option[Int] = None
    ): ModifyClusterInput =
      ModifyClusterInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(stepConcurrencyLevel)(_.stepConcurrencyLevel(_))
        .build

    def modifyClusterOutput(
      stepConcurrencyLevel: Option[Int] = None
    ): ModifyClusterOutput =
      ModifyClusterOutput
        .builder
        .ifSome(stepConcurrencyLevel)(_.stepConcurrencyLevel(_))
        .build

    def modifyInstanceFleetInput(
      clusterId: Option[String] = None,
      instanceFleet: Option[InstanceFleetModifyConfig] = None
    ): ModifyInstanceFleetInput =
      ModifyInstanceFleetInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceFleet)(_.instanceFleet(_))
        .build

    def modifyInstanceGroupsInput(
      clusterId: Option[String] = None,
      instanceGroups: Option[List[InstanceGroupModifyConfig]] = None
    ): ModifyInstanceGroupsInput =
      ModifyInstanceGroupsInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceGroups)(_.instanceGroups(_))
        .build

    def notebookExecution(
      notebookExecutionId: Option[String] = None,
      editorId: Option[String] = None,
      executionEngine: Option[ExecutionEngineConfig] = None,
      notebookExecutionName: Option[String] = None,
      notebookParams: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[Date] = None,
      endTime: Option[Date] = None,
      arn: Option[String] = None,
      outputNotebookURI: Option[String] = None,
      lastStateChangeReason: Option[String] = None,
      notebookInstanceSecurityGroupId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): NotebookExecution =
      NotebookExecution
        .builder
        .ifSome(notebookExecutionId)(_.notebookExecutionId(_))
        .ifSome(editorId)(_.editorId(_))
        .ifSome(executionEngine)(_.executionEngine(_))
        .ifSome(notebookExecutionName)(_.notebookExecutionName(_))
        .ifSome(notebookParams)(_.notebookParams(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(outputNotebookURI)(_.outputNotebookURI(_))
        .ifSome(lastStateChangeReason)(_.lastStateChangeReason(_))
        .ifSome(notebookInstanceSecurityGroupId)(_.notebookInstanceSecurityGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def notebookExecutionSummary(
      notebookExecutionId: Option[String] = None,
      editorId: Option[String] = None,
      notebookExecutionName: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[Date] = None,
      endTime: Option[Date] = None
    ): NotebookExecutionSummary =
      NotebookExecutionSummary
        .builder
        .ifSome(notebookExecutionId)(_.notebookExecutionId(_))
        .ifSome(editorId)(_.editorId(_))
        .ifSome(notebookExecutionName)(_.notebookExecutionName(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def onDemandCapacityReservationOptions(
      usageStrategy: Option[String] = None,
      capacityReservationPreference: Option[String] = None,
      capacityReservationResourceGroupArn: Option[String] = None
    ): OnDemandCapacityReservationOptions =
      OnDemandCapacityReservationOptions
        .builder
        .ifSome(usageStrategy)(_.usageStrategy(_))
        .ifSome(capacityReservationPreference)(_.capacityReservationPreference(_))
        .ifSome(capacityReservationResourceGroupArn)(_.capacityReservationResourceGroupArn(_))
        .build

    def onDemandProvisioningSpecification(
      allocationStrategy: Option[String] = None,
      capacityReservationOptions: Option[OnDemandCapacityReservationOptions] = None
    ): OnDemandProvisioningSpecification =
      OnDemandProvisioningSpecification
        .builder
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .ifSome(capacityReservationOptions)(_.capacityReservationOptions(_))
        .build

    def placementGroupConfig(
      instanceRole: Option[String] = None,
      placementStrategy: Option[String] = None
    ): PlacementGroupConfig =
      PlacementGroupConfig
        .builder
        .ifSome(instanceRole)(_.instanceRole(_))
        .ifSome(placementStrategy)(_.placementStrategy(_))
        .build

    def placementType(
      availabilityZone: Option[String] = None,
      availabilityZones: Option[List[XmlStringMaxLen256]] = None
    ): PlacementType =
      PlacementType
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def portRange(
      minRange: Option[Int] = None,
      maxRange: Option[Int] = None
    ): PortRange =
      PortRange
        .builder
        .ifSome(minRange)(_.minRange(_))
        .ifSome(maxRange)(_.maxRange(_))
        .build

    def putAutoScalingPolicyInput(
      clusterId: Option[String] = None,
      instanceGroupId: Option[String] = None,
      autoScalingPolicy: Option[AutoScalingPolicy] = None
    ): PutAutoScalingPolicyInput =
      PutAutoScalingPolicyInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceGroupId)(_.instanceGroupId(_))
        .ifSome(autoScalingPolicy)(_.autoScalingPolicy(_))
        .build

    def putAutoScalingPolicyOutput(
      clusterId: Option[String] = None,
      instanceGroupId: Option[String] = None,
      autoScalingPolicy: Option[AutoScalingPolicyDescription] = None,
      clusterArn: Option[String] = None
    ): PutAutoScalingPolicyOutput =
      PutAutoScalingPolicyOutput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceGroupId)(_.instanceGroupId(_))
        .ifSome(autoScalingPolicy)(_.autoScalingPolicy(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def putBlockPublicAccessConfigurationInput(
      blockPublicAccessConfiguration: Option[BlockPublicAccessConfiguration] = None
    ): PutBlockPublicAccessConfigurationInput =
      PutBlockPublicAccessConfigurationInput
        .builder
        .ifSome(blockPublicAccessConfiguration)(_.blockPublicAccessConfiguration(_))
        .build

    def putBlockPublicAccessConfigurationOutput(

    ): PutBlockPublicAccessConfigurationOutput =
      PutBlockPublicAccessConfigurationOutput
        .builder

        .build

    def putManagedScalingPolicyInput(
      clusterId: Option[String] = None,
      managedScalingPolicy: Option[ManagedScalingPolicy] = None
    ): PutManagedScalingPolicyInput =
      PutManagedScalingPolicyInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(managedScalingPolicy)(_.managedScalingPolicy(_))
        .build

    def putManagedScalingPolicyOutput(

    ): PutManagedScalingPolicyOutput =
      PutManagedScalingPolicyOutput
        .builder

        .build

    def removeAutoScalingPolicyInput(
      clusterId: Option[String] = None,
      instanceGroupId: Option[String] = None
    ): RemoveAutoScalingPolicyInput =
      RemoveAutoScalingPolicyInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(instanceGroupId)(_.instanceGroupId(_))
        .build

    def removeAutoScalingPolicyOutput(

    ): RemoveAutoScalingPolicyOutput =
      RemoveAutoScalingPolicyOutput
        .builder

        .build

    def removeManagedScalingPolicyInput(
      clusterId: Option[String] = None
    ): RemoveManagedScalingPolicyInput =
      RemoveManagedScalingPolicyInput
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def removeManagedScalingPolicyOutput(

    ): RemoveManagedScalingPolicyOutput =
      RemoveManagedScalingPolicyOutput
        .builder

        .build

    def removeTagsInput(
      resourceId: Option[String] = None,
      tagKeys: Option[List[String]] = None
    ): RemoveTagsInput =
      RemoveTagsInput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def removeTagsOutput(

    ): RemoveTagsOutput =
      RemoveTagsOutput
        .builder

        .build

    def runJobFlowInput(
      name: Option[String] = None,
      logUri: Option[String] = None,
      logEncryptionKmsKeyId: Option[String] = None,
      additionalInfo: Option[String] = None,
      amiVersion: Option[String] = None,
      releaseLabel: Option[String] = None,
      instances: Option[JobFlowInstancesConfig] = None,
      steps: Option[List[StepConfig]] = None,
      bootstrapActions: Option[List[BootstrapActionConfig]] = None,
      supportedProducts: Option[List[XmlStringMaxLen256]] = None,
      newSupportedProducts: Option[List[SupportedProductConfig]] = None,
      applications: Option[List[Application]] = None,
      configurations: Option[List[Configuration]] = None,
      visibleToAllUsers: Option[Boolean] = None,
      jobFlowRole: Option[String] = None,
      serviceRole: Option[String] = None,
      tags: Option[List[Tag]] = None,
      securityConfiguration: Option[String] = None,
      autoScalingRole: Option[String] = None,
      scaleDownBehavior: Option[String] = None,
      customAmiId: Option[String] = None,
      ebsRootVolumeSize: Option[Int] = None,
      repoUpgradeOnBoot: Option[String] = None,
      kerberosAttributes: Option[KerberosAttributes] = None,
      stepConcurrencyLevel: Option[Int] = None,
      managedScalingPolicy: Option[ManagedScalingPolicy] = None,
      placementGroupConfigs: Option[List[PlacementGroupConfig]] = None
    ): RunJobFlowInput =
      RunJobFlowInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(logEncryptionKmsKeyId)(_.logEncryptionKmsKeyId(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .ifSome(amiVersion)(_.amiVersion(_))
        .ifSome(releaseLabel)(_.releaseLabel(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(steps)(_.steps(_))
        .ifSome(bootstrapActions)(_.bootstrapActions(_))
        .ifSome(supportedProducts)(_.supportedProducts(_))
        .ifSome(newSupportedProducts)(_.newSupportedProducts(_))
        .ifSome(applications)(_.applications(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(visibleToAllUsers)(_.visibleToAllUsers(_))
        .ifSome(jobFlowRole)(_.jobFlowRole(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(autoScalingRole)(_.autoScalingRole(_))
        .ifSome(scaleDownBehavior)(_.scaleDownBehavior(_))
        .ifSome(customAmiId)(_.customAmiId(_))
        .ifSome(ebsRootVolumeSize)(_.ebsRootVolumeSize(_))
        .ifSome(repoUpgradeOnBoot)(_.repoUpgradeOnBoot(_))
        .ifSome(kerberosAttributes)(_.kerberosAttributes(_))
        .ifSome(stepConcurrencyLevel)(_.stepConcurrencyLevel(_))
        .ifSome(managedScalingPolicy)(_.managedScalingPolicy(_))
        .ifSome(placementGroupConfigs)(_.placementGroupConfigs(_))
        .build

    def runJobFlowOutput(
      jobFlowId: Option[String] = None,
      clusterArn: Option[String] = None
    ): RunJobFlowOutput =
      RunJobFlowOutput
        .builder
        .ifSome(jobFlowId)(_.jobFlowId(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def scalingAction(
      market: Option[String] = None,
      simpleScalingPolicyConfiguration: Option[SimpleScalingPolicyConfiguration] = None
    ): ScalingAction =
      ScalingAction
        .builder
        .ifSome(market)(_.market(_))
        .ifSome(simpleScalingPolicyConfiguration)(_.simpleScalingPolicyConfiguration(_))
        .build

    def scalingConstraints(
      minCapacity: Option[Int] = None,
      maxCapacity: Option[Int] = None
    ): ScalingConstraints =
      ScalingConstraints
        .builder
        .ifSome(minCapacity)(_.minCapacity(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .build

    def scalingRule(
      name: Option[String] = None,
      description: Option[String] = None,
      action: Option[ScalingAction] = None,
      trigger: Option[ScalingTrigger] = None
    ): ScalingRule =
      ScalingRule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(action)(_.action(_))
        .ifSome(trigger)(_.trigger(_))
        .build

    def scalingTrigger(
      cloudWatchAlarmDefinition: Option[CloudWatchAlarmDefinition] = None
    ): ScalingTrigger =
      ScalingTrigger
        .builder
        .ifSome(cloudWatchAlarmDefinition)(_.cloudWatchAlarmDefinition(_))
        .build

    def scriptBootstrapActionConfig(
      path: Option[String] = None,
      args: Option[List[XmlString]] = None
    ): ScriptBootstrapActionConfig =
      ScriptBootstrapActionConfig
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(args)(_.args(_))
        .build

    def securityConfigurationSummary(
      name: Option[String] = None,
      creationDateTime: Option[Date] = None
    ): SecurityConfigurationSummary =
      SecurityConfigurationSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def sessionMappingDetail(
      studioId: Option[String] = None,
      identityId: Option[String] = None,
      identityName: Option[String] = None,
      identityType: Option[String] = None,
      sessionPolicyArn: Option[String] = None,
      creationTime: Option[Date] = None,
      lastModifiedTime: Option[Date] = None
    ): SessionMappingDetail =
      SessionMappingDetail
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityName)(_.identityName(_))
        .ifSome(identityType)(_.identityType(_))
        .ifSome(sessionPolicyArn)(_.sessionPolicyArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def sessionMappingSummary(
      studioId: Option[String] = None,
      identityId: Option[String] = None,
      identityName: Option[String] = None,
      identityType: Option[String] = None,
      sessionPolicyArn: Option[String] = None,
      creationTime: Option[Date] = None
    ): SessionMappingSummary =
      SessionMappingSummary
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityName)(_.identityName(_))
        .ifSome(identityType)(_.identityType(_))
        .ifSome(sessionPolicyArn)(_.sessionPolicyArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def setTerminationProtectionInput(
      jobFlowIds: Option[List[XmlString]] = None,
      terminationProtected: Option[Boolean] = None
    ): SetTerminationProtectionInput =
      SetTerminationProtectionInput
        .builder
        .ifSome(jobFlowIds)(_.jobFlowIds(_))
        .ifSome(terminationProtected)(_.terminationProtected(_))
        .build

    def setVisibleToAllUsersInput(
      jobFlowIds: Option[List[XmlString]] = None,
      visibleToAllUsers: Option[Boolean] = None
    ): SetVisibleToAllUsersInput =
      SetVisibleToAllUsersInput
        .builder
        .ifSome(jobFlowIds)(_.jobFlowIds(_))
        .ifSome(visibleToAllUsers)(_.visibleToAllUsers(_))
        .build

    def shrinkPolicy(
      decommissionTimeout: Option[Int] = None,
      instanceResizePolicy: Option[InstanceResizePolicy] = None
    ): ShrinkPolicy =
      ShrinkPolicy
        .builder
        .ifSome(decommissionTimeout)(_.decommissionTimeout(_))
        .ifSome(instanceResizePolicy)(_.instanceResizePolicy(_))
        .build

    def simpleScalingPolicyConfiguration(
      adjustmentType: Option[String] = None,
      scalingAdjustment: Option[Int] = None,
      coolDown: Option[Int] = None
    ): SimpleScalingPolicyConfiguration =
      SimpleScalingPolicyConfiguration
        .builder
        .ifSome(adjustmentType)(_.adjustmentType(_))
        .ifSome(scalingAdjustment)(_.scalingAdjustment(_))
        .ifSome(coolDown)(_.coolDown(_))
        .build

    def spotProvisioningSpecification(
      timeoutDurationMinutes: Option[Int] = None,
      timeoutAction: Option[String] = None,
      blockDurationMinutes: Option[Int] = None,
      allocationStrategy: Option[String] = None
    ): SpotProvisioningSpecification =
      SpotProvisioningSpecification
        .builder
        .ifSome(timeoutDurationMinutes)(_.timeoutDurationMinutes(_))
        .ifSome(timeoutAction)(_.timeoutAction(_))
        .ifSome(blockDurationMinutes)(_.blockDurationMinutes(_))
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .build

    def startNotebookExecutionInput(
      editorId: Option[String] = None,
      relativePath: Option[String] = None,
      notebookExecutionName: Option[String] = None,
      notebookParams: Option[String] = None,
      executionEngine: Option[ExecutionEngineConfig] = None,
      serviceRole: Option[String] = None,
      notebookInstanceSecurityGroupId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): StartNotebookExecutionInput =
      StartNotebookExecutionInput
        .builder
        .ifSome(editorId)(_.editorId(_))
        .ifSome(relativePath)(_.relativePath(_))
        .ifSome(notebookExecutionName)(_.notebookExecutionName(_))
        .ifSome(notebookParams)(_.notebookParams(_))
        .ifSome(executionEngine)(_.executionEngine(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(notebookInstanceSecurityGroupId)(_.notebookInstanceSecurityGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startNotebookExecutionOutput(
      notebookExecutionId: Option[String] = None
    ): StartNotebookExecutionOutput =
      StartNotebookExecutionOutput
        .builder
        .ifSome(notebookExecutionId)(_.notebookExecutionId(_))
        .build

    def step(
      id: Option[String] = None,
      name: Option[String] = None,
      config: Option[HadoopStepConfig] = None,
      actionOnFailure: Option[String] = None,
      status: Option[StepStatus] = None
    ): Step =
      Step
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(config)(_.config(_))
        .ifSome(actionOnFailure)(_.actionOnFailure(_))
        .ifSome(status)(_.status(_))
        .build

    def stepConfig(
      name: Option[String] = None,
      actionOnFailure: Option[String] = None,
      hadoopJarStep: Option[HadoopJarStepConfig] = None
    ): StepConfig =
      StepConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(actionOnFailure)(_.actionOnFailure(_))
        .ifSome(hadoopJarStep)(_.hadoopJarStep(_))
        .build

    def stepDetail(
      stepConfig: Option[StepConfig] = None,
      executionStatusDetail: Option[StepExecutionStatusDetail] = None
    ): StepDetail =
      StepDetail
        .builder
        .ifSome(stepConfig)(_.stepConfig(_))
        .ifSome(executionStatusDetail)(_.executionStatusDetail(_))
        .build

    def stepExecutionStatusDetail(
      state: Option[String] = None,
      creationDateTime: Option[Date] = None,
      startDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None,
      lastStateChangeReason: Option[String] = None
    ): StepExecutionStatusDetail =
      StepExecutionStatusDetail
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(startDateTime)(_.startDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .ifSome(lastStateChangeReason)(_.lastStateChangeReason(_))
        .build

    def stepStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): StepStateChangeReason =
      StepStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def stepStatus(
      state: Option[String] = None,
      stateChangeReason: Option[StepStateChangeReason] = None,
      failureDetails: Option[FailureDetails] = None,
      timeline: Option[StepTimeline] = None
    ): StepStatus =
      StepStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .ifSome(timeline)(_.timeline(_))
        .build

    def stepSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      config: Option[HadoopStepConfig] = None,
      actionOnFailure: Option[String] = None,
      status: Option[StepStatus] = None
    ): StepSummary =
      StepSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(config)(_.config(_))
        .ifSome(actionOnFailure)(_.actionOnFailure(_))
        .ifSome(status)(_.status(_))
        .build

    def stepTimeline(
      creationDateTime: Option[Date] = None,
      startDateTime: Option[Date] = None,
      endDateTime: Option[Date] = None
    ): StepTimeline =
      StepTimeline
        .builder
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(startDateTime)(_.startDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .build

    def stopNotebookExecutionInput(
      notebookExecutionId: Option[String] = None
    ): StopNotebookExecutionInput =
      StopNotebookExecutionInput
        .builder
        .ifSome(notebookExecutionId)(_.notebookExecutionId(_))
        .build

    def studio(
      studioId: Option[String] = None,
      studioArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      authMode: Option[String] = None,
      vpcId: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      serviceRole: Option[String] = None,
      userRole: Option[String] = None,
      workspaceSecurityGroupId: Option[String] = None,
      engineSecurityGroupId: Option[String] = None,
      url: Option[String] = None,
      creationTime: Option[Date] = None,
      defaultS3Location: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): Studio =
      Studio
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(studioArn)(_.studioArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(authMode)(_.authMode(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(userRole)(_.userRole(_))
        .ifSome(workspaceSecurityGroupId)(_.workspaceSecurityGroupId(_))
        .ifSome(engineSecurityGroupId)(_.engineSecurityGroupId(_))
        .ifSome(url)(_.url(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(defaultS3Location)(_.defaultS3Location(_))
        .ifSome(tags)(_.tags(_))
        .build

    def studioSummary(
      studioId: Option[String] = None,
      name: Option[String] = None,
      vpcId: Option[String] = None,
      description: Option[String] = None,
      url: Option[String] = None,
      creationTime: Option[Date] = None
    ): StudioSummary =
      StudioSummary
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(name)(_.name(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(description)(_.description(_))
        .ifSome(url)(_.url(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def supportedProductConfig(
      name: Option[String] = None,
      args: Option[List[XmlString]] = None
    ): SupportedProductConfig =
      SupportedProductConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(args)(_.args(_))
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

    def terminateJobFlowsInput(
      jobFlowIds: Option[List[XmlString]] = None
    ): TerminateJobFlowsInput =
      TerminateJobFlowsInput
        .builder
        .ifSome(jobFlowIds)(_.jobFlowIds(_))
        .build

    def updateStudioInput(
      studioId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      defaultS3Location: Option[String] = None
    ): UpdateStudioInput =
      UpdateStudioInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(defaultS3Location)(_.defaultS3Location(_))
        .build

    def updateStudioSessionMappingInput(
      studioId: Option[String] = None,
      identityId: Option[String] = None,
      identityName: Option[String] = None,
      identityType: Option[String] = None,
      sessionPolicyArn: Option[String] = None
    ): UpdateStudioSessionMappingInput =
      UpdateStudioSessionMappingInput
        .builder
        .ifSome(studioId)(_.studioId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityName)(_.identityName(_))
        .ifSome(identityType)(_.identityType(_))
        .ifSome(sessionPolicyArn)(_.sessionPolicyArn(_))
        .build

    def volumeSpecification(
      volumeType: Option[String] = None,
      iops: Option[Int] = None,
      sizeInGB: Option[Int] = None
    ): VolumeSpecification =
      VolumeSpecification
        .builder
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(sizeInGB)(_.sizeInGB(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
