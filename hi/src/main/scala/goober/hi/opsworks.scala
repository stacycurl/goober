package goober.hi

import goober.free.opsworks.OpsWorksIO
import software.amazon.awssdk.services.opsworks.model._


object opsworks {
  import goober.free.{opsworks ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def agentVersion(
      version: Option[String] = None,
      configurationManager: Option[StackConfigurationManager] = None
    ): AgentVersion =
      AgentVersion
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(configurationManager)(_.configurationManager(_))
        .build

    def app(
      appId: Option[String] = None,
      stackId: Option[String] = None,
      shortname: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      dataSources: Option[List[DataSource]] = None,
      `type`: Option[String] = None,
      appSource: Option[Source] = None,
      domains: Option[List[String]] = None,
      enableSsl: Option[Boolean] = None,
      sslConfiguration: Option[SslConfiguration] = None,
      attributes: Option[AppAttributes] = None,
      createdAt: Option[String] = None,
      environment: Option[List[EnvironmentVariable]] = None
    ): App =
      App
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(shortname)(_.shortname(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(appSource)(_.appSource(_))
        .ifSome(domains)(_.domains(_))
        .ifSome(enableSsl)(_.enableSsl(_))
        .ifSome(sslConfiguration)(_.sslConfiguration(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(environment)(_.environment(_))
        .build

    def assignInstanceRequest(
      instanceId: Option[String] = None,
      layerIds: Option[List[String]] = None
    ): AssignInstanceRequest =
      AssignInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(layerIds)(_.layerIds(_))
        .build

    def assignVolumeRequest(
      volumeId: Option[String] = None,
      instanceId: Option[String] = None
    ): AssignVolumeRequest =
      AssignVolumeRequest
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def associateElasticIpRequest(
      elasticIp: Option[String] = None,
      instanceId: Option[String] = None
    ): AssociateElasticIpRequest =
      AssociateElasticIpRequest
        .builder
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def attachElasticLoadBalancerRequest(
      elasticLoadBalancerName: Option[String] = None,
      layerId: Option[String] = None
    ): AttachElasticLoadBalancerRequest =
      AttachElasticLoadBalancerRequest
        .builder
        .ifSome(elasticLoadBalancerName)(_.elasticLoadBalancerName(_))
        .ifSome(layerId)(_.layerId(_))
        .build

    def autoScalingThresholds(
      instanceCount: Option[Int] = None,
      thresholdsWaitTime: Option[Int] = None,
      ignoreMetricsTime: Option[Int] = None,
      cpuThreshold: Option[Double] = None,
      memoryThreshold: Option[Double] = None,
      loadThreshold: Option[Double] = None,
      alarms: Option[List[String]] = None
    ): AutoScalingThresholds =
      AutoScalingThresholds
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(thresholdsWaitTime)(_.thresholdsWaitTime(_))
        .ifSome(ignoreMetricsTime)(_.ignoreMetricsTime(_))
        .ifSome(cpuThreshold)(_.cpuThreshold(_))
        .ifSome(memoryThreshold)(_.memoryThreshold(_))
        .ifSome(loadThreshold)(_.loadThreshold(_))
        .ifSome(alarms)(_.alarms(_))
        .build

    def blockDeviceMapping(
      deviceName: Option[String] = None,
      noDevice: Option[String] = None,
      virtualName: Option[String] = None,
      ebs: Option[EbsBlockDevice] = None
    ): BlockDeviceMapping =
      BlockDeviceMapping
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(noDevice)(_.noDevice(_))
        .ifSome(virtualName)(_.virtualName(_))
        .ifSome(ebs)(_.ebs(_))
        .build

    def chefConfiguration(
      manageBerkshelf: Option[Boolean] = None,
      berkshelfVersion: Option[String] = None
    ): ChefConfiguration =
      ChefConfiguration
        .builder
        .ifSome(manageBerkshelf)(_.manageBerkshelf(_))
        .ifSome(berkshelfVersion)(_.berkshelfVersion(_))
        .build

    def cloneStackRequest(
      sourceStackId: Option[String] = None,
      name: Option[String] = None,
      region: Option[String] = None,
      vpcId: Option[String] = None,
      attributes: Option[StackAttributes] = None,
      serviceRoleArn: Option[String] = None,
      defaultInstanceProfileArn: Option[String] = None,
      defaultOs: Option[String] = None,
      hostnameTheme: Option[String] = None,
      defaultAvailabilityZone: Option[String] = None,
      defaultSubnetId: Option[String] = None,
      customJson: Option[String] = None,
      configurationManager: Option[StackConfigurationManager] = None,
      chefConfiguration: Option[ChefConfiguration] = None,
      useCustomCookbooks: Option[Boolean] = None,
      useOpsworksSecurityGroups: Option[Boolean] = None,
      customCookbooksSource: Option[Source] = None,
      defaultSshKeyName: Option[String] = None,
      clonePermissions: Option[Boolean] = None,
      cloneAppIds: Option[List[String]] = None,
      defaultRootDeviceType: Option[String] = None,
      agentVersion: Option[String] = None
    ): CloneStackRequest =
      CloneStackRequest
        .builder
        .ifSome(sourceStackId)(_.sourceStackId(_))
        .ifSome(name)(_.name(_))
        .ifSome(region)(_.region(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(defaultInstanceProfileArn)(_.defaultInstanceProfileArn(_))
        .ifSome(defaultOs)(_.defaultOs(_))
        .ifSome(hostnameTheme)(_.hostnameTheme(_))
        .ifSome(defaultAvailabilityZone)(_.defaultAvailabilityZone(_))
        .ifSome(defaultSubnetId)(_.defaultSubnetId(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(configurationManager)(_.configurationManager(_))
        .ifSome(chefConfiguration)(_.chefConfiguration(_))
        .ifSome(useCustomCookbooks)(_.useCustomCookbooks(_))
        .ifSome(useOpsworksSecurityGroups)(_.useOpsworksSecurityGroups(_))
        .ifSome(customCookbooksSource)(_.customCookbooksSource(_))
        .ifSome(defaultSshKeyName)(_.defaultSshKeyName(_))
        .ifSome(clonePermissions)(_.clonePermissions(_))
        .ifSome(cloneAppIds)(_.cloneAppIds(_))
        .ifSome(defaultRootDeviceType)(_.defaultRootDeviceType(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .build

    def cloudWatchLogsConfiguration(
      enabled: Option[Boolean] = None,
      logStreams: Option[List[CloudWatchLogsLogStream]] = None
    ): CloudWatchLogsConfiguration =
      CloudWatchLogsConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(logStreams)(_.logStreams(_))
        .build

    def cloudWatchLogsLogStream(
      logGroupName: Option[String] = None,
      datetimeFormat: Option[String] = None,
      timeZone: Option[String] = None,
      file: Option[String] = None,
      fileFingerprintLines: Option[String] = None,
      multiLineStartPattern: Option[String] = None,
      initialPosition: Option[String] = None,
      encoding: Option[String] = None,
      bufferDuration: Option[Int] = None,
      batchCount: Option[Int] = None,
      batchSize: Option[Int] = None
    ): CloudWatchLogsLogStream =
      CloudWatchLogsLogStream
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(datetimeFormat)(_.datetimeFormat(_))
        .ifSome(timeZone)(_.timeZone(_))
        .ifSome(file)(_.file(_))
        .ifSome(fileFingerprintLines)(_.fileFingerprintLines(_))
        .ifSome(multiLineStartPattern)(_.multiLineStartPattern(_))
        .ifSome(initialPosition)(_.initialPosition(_))
        .ifSome(encoding)(_.encoding(_))
        .ifSome(bufferDuration)(_.bufferDuration(_))
        .ifSome(batchCount)(_.batchCount(_))
        .ifSome(batchSize)(_.batchSize(_))
        .build

    def command(
      commandId: Option[String] = None,
      instanceId: Option[String] = None,
      deploymentId: Option[String] = None,
      createdAt: Option[String] = None,
      acknowledgedAt: Option[String] = None,
      completedAt: Option[String] = None,
      status: Option[String] = None,
      exitCode: Option[Int] = None,
      logUrl: Option[String] = None,
      `type`: Option[String] = None
    ): Command =
      Command
        .builder
        .ifSome(commandId)(_.commandId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(acknowledgedAt)(_.acknowledgedAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(exitCode)(_.exitCode(_))
        .ifSome(logUrl)(_.logUrl(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createAppRequest(
      stackId: Option[String] = None,
      shortname: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      dataSources: Option[List[DataSource]] = None,
      `type`: Option[String] = None,
      appSource: Option[Source] = None,
      domains: Option[List[String]] = None,
      enableSsl: Option[Boolean] = None,
      sslConfiguration: Option[SslConfiguration] = None,
      attributes: Option[AppAttributes] = None,
      environment: Option[List[EnvironmentVariable]] = None
    ): CreateAppRequest =
      CreateAppRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(shortname)(_.shortname(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(appSource)(_.appSource(_))
        .ifSome(domains)(_.domains(_))
        .ifSome(enableSsl)(_.enableSsl(_))
        .ifSome(sslConfiguration)(_.sslConfiguration(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(environment)(_.environment(_))
        .build

    def createDeploymentRequest(
      stackId: Option[String] = None,
      appId: Option[String] = None,
      instanceIds: Option[List[String]] = None,
      layerIds: Option[List[String]] = None,
      command: Option[DeploymentCommand] = None,
      comment: Option[String] = None,
      customJson: Option[String] = None
    ): CreateDeploymentRequest =
      CreateDeploymentRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(appId)(_.appId(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(layerIds)(_.layerIds(_))
        .ifSome(command)(_.command(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(customJson)(_.customJson(_))
        .build

    def createInstanceRequest(
      stackId: Option[String] = None,
      layerIds: Option[List[String]] = None,
      instanceType: Option[String] = None,
      autoScalingType: Option[String] = None,
      hostname: Option[String] = None,
      os: Option[String] = None,
      amiId: Option[String] = None,
      sshKeyName: Option[String] = None,
      availabilityZone: Option[String] = None,
      virtualizationType: Option[String] = None,
      subnetId: Option[String] = None,
      architecture: Option[String] = None,
      rootDeviceType: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      installUpdatesOnBoot: Option[Boolean] = None,
      ebsOptimized: Option[Boolean] = None,
      agentVersion: Option[String] = None,
      tenancy: Option[String] = None
    ): CreateInstanceRequest =
      CreateInstanceRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(layerIds)(_.layerIds(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(autoScalingType)(_.autoScalingType(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(os)(_.os(_))
        .ifSome(amiId)(_.amiId(_))
        .ifSome(sshKeyName)(_.sshKeyName(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(virtualizationType)(_.virtualizationType(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(rootDeviceType)(_.rootDeviceType(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(installUpdatesOnBoot)(_.installUpdatesOnBoot(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .ifSome(tenancy)(_.tenancy(_))
        .build

    def createLayerRequest(
      stackId: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      shortname: Option[String] = None,
      attributes: Option[LayerAttributes] = None,
      cloudWatchLogsConfiguration: Option[CloudWatchLogsConfiguration] = None,
      customInstanceProfileArn: Option[String] = None,
      customJson: Option[String] = None,
      customSecurityGroupIds: Option[List[String]] = None,
      packages: Option[List[String]] = None,
      volumeConfigurations: Option[List[VolumeConfiguration]] = None,
      enableAutoHealing: Option[Boolean] = None,
      autoAssignElasticIps: Option[Boolean] = None,
      autoAssignPublicIps: Option[Boolean] = None,
      customRecipes: Option[Recipes] = None,
      installUpdatesOnBoot: Option[Boolean] = None,
      useEbsOptimizedInstances: Option[Boolean] = None,
      lifecycleEventConfiguration: Option[LifecycleEventConfiguration] = None
    ): CreateLayerRequest =
      CreateLayerRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(shortname)(_.shortname(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(cloudWatchLogsConfiguration)(_.cloudWatchLogsConfiguration(_))
        .ifSome(customInstanceProfileArn)(_.customInstanceProfileArn(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(customSecurityGroupIds)(_.customSecurityGroupIds(_))
        .ifSome(packages)(_.packages(_))
        .ifSome(volumeConfigurations)(_.volumeConfigurations(_))
        .ifSome(enableAutoHealing)(_.enableAutoHealing(_))
        .ifSome(autoAssignElasticIps)(_.autoAssignElasticIps(_))
        .ifSome(autoAssignPublicIps)(_.autoAssignPublicIps(_))
        .ifSome(customRecipes)(_.customRecipes(_))
        .ifSome(installUpdatesOnBoot)(_.installUpdatesOnBoot(_))
        .ifSome(useEbsOptimizedInstances)(_.useEbsOptimizedInstances(_))
        .ifSome(lifecycleEventConfiguration)(_.lifecycleEventConfiguration(_))
        .build

    def createStackRequest(
      name: Option[String] = None,
      region: Option[String] = None,
      vpcId: Option[String] = None,
      attributes: Option[StackAttributes] = None,
      serviceRoleArn: Option[String] = None,
      defaultInstanceProfileArn: Option[String] = None,
      defaultOs: Option[String] = None,
      hostnameTheme: Option[String] = None,
      defaultAvailabilityZone: Option[String] = None,
      defaultSubnetId: Option[String] = None,
      customJson: Option[String] = None,
      configurationManager: Option[StackConfigurationManager] = None,
      chefConfiguration: Option[ChefConfiguration] = None,
      useCustomCookbooks: Option[Boolean] = None,
      useOpsworksSecurityGroups: Option[Boolean] = None,
      customCookbooksSource: Option[Source] = None,
      defaultSshKeyName: Option[String] = None,
      defaultRootDeviceType: Option[String] = None,
      agentVersion: Option[String] = None
    ): CreateStackRequest =
      CreateStackRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(region)(_.region(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(defaultInstanceProfileArn)(_.defaultInstanceProfileArn(_))
        .ifSome(defaultOs)(_.defaultOs(_))
        .ifSome(hostnameTheme)(_.hostnameTheme(_))
        .ifSome(defaultAvailabilityZone)(_.defaultAvailabilityZone(_))
        .ifSome(defaultSubnetId)(_.defaultSubnetId(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(configurationManager)(_.configurationManager(_))
        .ifSome(chefConfiguration)(_.chefConfiguration(_))
        .ifSome(useCustomCookbooks)(_.useCustomCookbooks(_))
        .ifSome(useOpsworksSecurityGroups)(_.useOpsworksSecurityGroups(_))
        .ifSome(customCookbooksSource)(_.customCookbooksSource(_))
        .ifSome(defaultSshKeyName)(_.defaultSshKeyName(_))
        .ifSome(defaultRootDeviceType)(_.defaultRootDeviceType(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .build

    def createUserProfileRequest(
      iamUserArn: Option[String] = None,
      sshUsername: Option[String] = None,
      sshPublicKey: Option[String] = None,
      allowSelfManagement: Option[Boolean] = None
    ): CreateUserProfileRequest =
      CreateUserProfileRequest
        .builder
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(sshUsername)(_.sshUsername(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .ifSome(allowSelfManagement)(_.allowSelfManagement(_))
        .build

    def dataSource(
      `type`: Option[String] = None,
      arn: Option[String] = None,
      databaseName: Option[String] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(databaseName)(_.databaseName(_))
        .build

    def deleteAppRequest(
      appId: Option[String] = None
    ): DeleteAppRequest =
      DeleteAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def deleteInstanceRequest(
      instanceId: Option[String] = None,
      deleteElasticIp: Option[Boolean] = None,
      deleteVolumes: Option[Boolean] = None
    ): DeleteInstanceRequest =
      DeleteInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(deleteElasticIp)(_.deleteElasticIp(_))
        .ifSome(deleteVolumes)(_.deleteVolumes(_))
        .build

    def deleteLayerRequest(
      layerId: Option[String] = None
    ): DeleteLayerRequest =
      DeleteLayerRequest
        .builder
        .ifSome(layerId)(_.layerId(_))
        .build

    def deleteStackRequest(
      stackId: Option[String] = None
    ): DeleteStackRequest =
      DeleteStackRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def deleteUserProfileRequest(
      iamUserArn: Option[String] = None
    ): DeleteUserProfileRequest =
      DeleteUserProfileRequest
        .builder
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .build

    def deployment(
      deploymentId: Option[String] = None,
      stackId: Option[String] = None,
      appId: Option[String] = None,
      createdAt: Option[String] = None,
      completedAt: Option[String] = None,
      duration: Option[Int] = None,
      iamUserArn: Option[String] = None,
      comment: Option[String] = None,
      command: Option[DeploymentCommand] = None,
      status: Option[String] = None,
      customJson: Option[String] = None,
      instanceIds: Option[List[String]] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(appId)(_.appId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(command)(_.command(_))
        .ifSome(status)(_.status(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def deploymentCommand(
      name: Option[String] = None,
      args: Option[DeploymentCommandArgs] = None
    ): DeploymentCommand =
      DeploymentCommand
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(args)(_.args(_))
        .build

    def deregisterEcsClusterRequest(
      ecsClusterArn: Option[String] = None
    ): DeregisterEcsClusterRequest =
      DeregisterEcsClusterRequest
        .builder
        .ifSome(ecsClusterArn)(_.ecsClusterArn(_))
        .build

    def deregisterElasticIpRequest(
      elasticIp: Option[String] = None
    ): DeregisterElasticIpRequest =
      DeregisterElasticIpRequest
        .builder
        .ifSome(elasticIp)(_.elasticIp(_))
        .build

    def deregisterInstanceRequest(
      instanceId: Option[String] = None
    ): DeregisterInstanceRequest =
      DeregisterInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def deregisterRdsDbInstanceRequest(
      rdsDbInstanceArn: Option[String] = None
    ): DeregisterRdsDbInstanceRequest =
      DeregisterRdsDbInstanceRequest
        .builder
        .ifSome(rdsDbInstanceArn)(_.rdsDbInstanceArn(_))
        .build

    def deregisterVolumeRequest(
      volumeId: Option[String] = None
    ): DeregisterVolumeRequest =
      DeregisterVolumeRequest
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def describeAgentVersionsRequest(
      stackId: Option[String] = None,
      configurationManager: Option[StackConfigurationManager] = None
    ): DescribeAgentVersionsRequest =
      DescribeAgentVersionsRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(configurationManager)(_.configurationManager(_))
        .build

    def describeAppsRequest(
      stackId: Option[String] = None,
      appIds: Option[List[String]] = None
    ): DescribeAppsRequest =
      DescribeAppsRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(appIds)(_.appIds(_))
        .build

    def describeCommandsRequest(
      deploymentId: Option[String] = None,
      instanceId: Option[String] = None,
      commandIds: Option[List[String]] = None
    ): DescribeCommandsRequest =
      DescribeCommandsRequest
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(commandIds)(_.commandIds(_))
        .build

    def describeDeploymentsRequest(
      stackId: Option[String] = None,
      appId: Option[String] = None,
      deploymentIds: Option[List[String]] = None
    ): DescribeDeploymentsRequest =
      DescribeDeploymentsRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(appId)(_.appId(_))
        .ifSome(deploymentIds)(_.deploymentIds(_))
        .build

    def describeEcsClustersRequest(
      ecsClusterArns: Option[List[String]] = None,
      stackId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeEcsClustersRequest =
      DescribeEcsClustersRequest
        .builder
        .ifSome(ecsClusterArns)(_.ecsClusterArns(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeElasticIpsRequest(
      instanceId: Option[String] = None,
      stackId: Option[String] = None,
      ips: Option[List[String]] = None
    ): DescribeElasticIpsRequest =
      DescribeElasticIpsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(ips)(_.ips(_))
        .build

    def describeElasticLoadBalancersRequest(
      stackId: Option[String] = None,
      layerIds: Option[List[String]] = None
    ): DescribeElasticLoadBalancersRequest =
      DescribeElasticLoadBalancersRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(layerIds)(_.layerIds(_))
        .build

    def describeInstancesRequest(
      stackId: Option[String] = None,
      layerId: Option[String] = None,
      instanceIds: Option[List[String]] = None
    ): DescribeInstancesRequest =
      DescribeInstancesRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(layerId)(_.layerId(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def describeLayersRequest(
      stackId: Option[String] = None,
      layerIds: Option[List[String]] = None
    ): DescribeLayersRequest =
      DescribeLayersRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(layerIds)(_.layerIds(_))
        .build

    def describeLoadBasedAutoScalingRequest(
      layerIds: Option[List[String]] = None
    ): DescribeLoadBasedAutoScalingRequest =
      DescribeLoadBasedAutoScalingRequest
        .builder
        .ifSome(layerIds)(_.layerIds(_))
        .build

    def describeOperatingSystemsResponse(
      operatingSystems: Option[List[OperatingSystem]] = None
    ): DescribeOperatingSystemsResponse =
      DescribeOperatingSystemsResponse
        .builder
        .ifSome(operatingSystems)(_.operatingSystems(_))
        .build

    def describePermissionsRequest(
      iamUserArn: Option[String] = None,
      stackId: Option[String] = None
    ): DescribePermissionsRequest =
      DescribePermissionsRequest
        .builder
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def describeRaidArraysRequest(
      instanceId: Option[String] = None,
      stackId: Option[String] = None,
      raidArrayIds: Option[List[String]] = None
    ): DescribeRaidArraysRequest =
      DescribeRaidArraysRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(raidArrayIds)(_.raidArrayIds(_))
        .build

    def describeRdsDbInstancesRequest(
      stackId: Option[String] = None,
      rdsDbInstanceArns: Option[List[String]] = None
    ): DescribeRdsDbInstancesRequest =
      DescribeRdsDbInstancesRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(rdsDbInstanceArns)(_.rdsDbInstanceArns(_))
        .build

    def describeServiceErrorsRequest(
      stackId: Option[String] = None,
      instanceId: Option[String] = None,
      serviceErrorIds: Option[List[String]] = None
    ): DescribeServiceErrorsRequest =
      DescribeServiceErrorsRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(serviceErrorIds)(_.serviceErrorIds(_))
        .build

    def describeStackProvisioningParametersRequest(
      stackId: Option[String] = None
    ): DescribeStackProvisioningParametersRequest =
      DescribeStackProvisioningParametersRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def describeStackSummaryRequest(
      stackId: Option[String] = None
    ): DescribeStackSummaryRequest =
      DescribeStackSummaryRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def describeStacksRequest(
      stackIds: Option[List[String]] = None
    ): DescribeStacksRequest =
      DescribeStacksRequest
        .builder
        .ifSome(stackIds)(_.stackIds(_))
        .build

    def describeTimeBasedAutoScalingRequest(
      instanceIds: Option[List[String]] = None
    ): DescribeTimeBasedAutoScalingRequest =
      DescribeTimeBasedAutoScalingRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def describeUserProfilesRequest(
      iamUserArns: Option[List[String]] = None
    ): DescribeUserProfilesRequest =
      DescribeUserProfilesRequest
        .builder
        .ifSome(iamUserArns)(_.iamUserArns(_))
        .build

    def describeVolumesRequest(
      instanceId: Option[String] = None,
      stackId: Option[String] = None,
      raidArrayId: Option[String] = None,
      volumeIds: Option[List[String]] = None
    ): DescribeVolumesRequest =
      DescribeVolumesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(raidArrayId)(_.raidArrayId(_))
        .ifSome(volumeIds)(_.volumeIds(_))
        .build

    def detachElasticLoadBalancerRequest(
      elasticLoadBalancerName: Option[String] = None,
      layerId: Option[String] = None
    ): DetachElasticLoadBalancerRequest =
      DetachElasticLoadBalancerRequest
        .builder
        .ifSome(elasticLoadBalancerName)(_.elasticLoadBalancerName(_))
        .ifSome(layerId)(_.layerId(_))
        .build

    def disassociateElasticIpRequest(
      elasticIp: Option[String] = None
    ): DisassociateElasticIpRequest =
      DisassociateElasticIpRequest
        .builder
        .ifSome(elasticIp)(_.elasticIp(_))
        .build

    def ebsBlockDevice(
      snapshotId: Option[String] = None,
      iops: Option[Int] = None,
      volumeSize: Option[Int] = None,
      volumeType: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None
    ): EbsBlockDevice =
      EbsBlockDevice
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .build

    def ecsCluster(
      ecsClusterArn: Option[String] = None,
      ecsClusterName: Option[String] = None,
      stackId: Option[String] = None,
      registeredAt: Option[String] = None
    ): EcsCluster =
      EcsCluster
        .builder
        .ifSome(ecsClusterArn)(_.ecsClusterArn(_))
        .ifSome(ecsClusterName)(_.ecsClusterName(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(registeredAt)(_.registeredAt(_))
        .build

    def elasticIp(
      ip: Option[String] = None,
      name: Option[String] = None,
      domain: Option[String] = None,
      region: Option[String] = None,
      instanceId: Option[String] = None
    ): ElasticIp =
      ElasticIp
        .builder
        .ifSome(ip)(_.ip(_))
        .ifSome(name)(_.name(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(region)(_.region(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def elasticLoadBalancer(
      elasticLoadBalancerName: Option[String] = None,
      region: Option[String] = None,
      dnsName: Option[String] = None,
      stackId: Option[String] = None,
      layerId: Option[String] = None,
      vpcId: Option[String] = None,
      availabilityZones: Option[List[String]] = None,
      subnetIds: Option[List[String]] = None,
      ec2InstanceIds: Option[List[String]] = None
    ): ElasticLoadBalancer =
      ElasticLoadBalancer
        .builder
        .ifSome(elasticLoadBalancerName)(_.elasticLoadBalancerName(_))
        .ifSome(region)(_.region(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(layerId)(_.layerId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(ec2InstanceIds)(_.ec2InstanceIds(_))
        .build

    def environmentVariable(
      key: Option[String] = None,
      value: Option[String] = None,
      secure: Option[Boolean] = None
    ): EnvironmentVariable =
      EnvironmentVariable
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(secure)(_.secure(_))
        .build

    def getHostnameSuggestionRequest(
      layerId: Option[String] = None
    ): GetHostnameSuggestionRequest =
      GetHostnameSuggestionRequest
        .builder
        .ifSome(layerId)(_.layerId(_))
        .build

    def grantAccessRequest(
      instanceId: Option[String] = None,
      validForInMinutes: Option[Int] = None
    ): GrantAccessRequest =
      GrantAccessRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(validForInMinutes)(_.validForInMinutes(_))
        .build

    def instance(
      agentVersion: Option[String] = None,
      amiId: Option[String] = None,
      architecture: Option[String] = None,
      arn: Option[String] = None,
      autoScalingType: Option[String] = None,
      availabilityZone: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      createdAt: Option[String] = None,
      ebsOptimized: Option[Boolean] = None,
      ec2InstanceId: Option[String] = None,
      ecsClusterArn: Option[String] = None,
      ecsContainerInstanceArn: Option[String] = None,
      elasticIp: Option[String] = None,
      hostname: Option[String] = None,
      infrastructureClass: Option[String] = None,
      installUpdatesOnBoot: Option[Boolean] = None,
      instanceId: Option[String] = None,
      instanceProfileArn: Option[String] = None,
      instanceType: Option[String] = None,
      lastServiceErrorId: Option[String] = None,
      layerIds: Option[List[String]] = None,
      os: Option[String] = None,
      platform: Option[String] = None,
      privateDns: Option[String] = None,
      privateIp: Option[String] = None,
      publicDns: Option[String] = None,
      publicIp: Option[String] = None,
      registeredBy: Option[String] = None,
      reportedAgentVersion: Option[String] = None,
      reportedOs: Option[ReportedOs] = None,
      rootDeviceType: Option[String] = None,
      rootDeviceVolumeId: Option[String] = None,
      securityGroupIds: Option[List[String]] = None,
      sshHostDsaKeyFingerprint: Option[String] = None,
      sshHostRsaKeyFingerprint: Option[String] = None,
      sshKeyName: Option[String] = None,
      stackId: Option[String] = None,
      status: Option[String] = None,
      subnetId: Option[String] = None,
      tenancy: Option[String] = None,
      virtualizationType: Option[String] = None
    ): Instance =
      Instance
        .builder
        .ifSome(agentVersion)(_.agentVersion(_))
        .ifSome(amiId)(_.amiId(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(autoScalingType)(_.autoScalingType(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(ec2InstanceId)(_.ec2InstanceId(_))
        .ifSome(ecsClusterArn)(_.ecsClusterArn(_))
        .ifSome(ecsContainerInstanceArn)(_.ecsContainerInstanceArn(_))
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(infrastructureClass)(_.infrastructureClass(_))
        .ifSome(installUpdatesOnBoot)(_.installUpdatesOnBoot(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceProfileArn)(_.instanceProfileArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(lastServiceErrorId)(_.lastServiceErrorId(_))
        .ifSome(layerIds)(_.layerIds(_))
        .ifSome(os)(_.os(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(privateDns)(_.privateDns(_))
        .ifSome(privateIp)(_.privateIp(_))
        .ifSome(publicDns)(_.publicDns(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(registeredBy)(_.registeredBy(_))
        .ifSome(reportedAgentVersion)(_.reportedAgentVersion(_))
        .ifSome(reportedOs)(_.reportedOs(_))
        .ifSome(rootDeviceType)(_.rootDeviceType(_))
        .ifSome(rootDeviceVolumeId)(_.rootDeviceVolumeId(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(sshHostDsaKeyFingerprint)(_.sshHostDsaKeyFingerprint(_))
        .ifSome(sshHostRsaKeyFingerprint)(_.sshHostRsaKeyFingerprint(_))
        .ifSome(sshKeyName)(_.sshKeyName(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(status)(_.status(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(virtualizationType)(_.virtualizationType(_))
        .build

    def instanceIdentity(
      document: Option[String] = None,
      signature: Option[String] = None
    ): InstanceIdentity =
      InstanceIdentity
        .builder
        .ifSome(document)(_.document(_))
        .ifSome(signature)(_.signature(_))
        .build

    def instancesCount(
      assigning: Option[Int] = None,
      booting: Option[Int] = None,
      connectionLost: Option[Int] = None,
      deregistering: Option[Int] = None,
      online: Option[Int] = None,
      pending: Option[Int] = None,
      rebooting: Option[Int] = None,
      registered: Option[Int] = None,
      registering: Option[Int] = None,
      requested: Option[Int] = None,
      runningSetup: Option[Int] = None,
      setupFailed: Option[Int] = None,
      shuttingDown: Option[Int] = None,
      startFailed: Option[Int] = None,
      stopFailed: Option[Int] = None,
      stopped: Option[Int] = None,
      stopping: Option[Int] = None,
      terminated: Option[Int] = None,
      terminating: Option[Int] = None,
      unassigning: Option[Int] = None
    ): InstancesCount =
      InstancesCount
        .builder
        .ifSome(assigning)(_.assigning(_))
        .ifSome(booting)(_.booting(_))
        .ifSome(connectionLost)(_.connectionLost(_))
        .ifSome(deregistering)(_.deregistering(_))
        .ifSome(online)(_.online(_))
        .ifSome(pending)(_.pending(_))
        .ifSome(rebooting)(_.rebooting(_))
        .ifSome(registered)(_.registered(_))
        .ifSome(registering)(_.registering(_))
        .ifSome(requested)(_.requested(_))
        .ifSome(runningSetup)(_.runningSetup(_))
        .ifSome(setupFailed)(_.setupFailed(_))
        .ifSome(shuttingDown)(_.shuttingDown(_))
        .ifSome(startFailed)(_.startFailed(_))
        .ifSome(stopFailed)(_.stopFailed(_))
        .ifSome(stopped)(_.stopped(_))
        .ifSome(stopping)(_.stopping(_))
        .ifSome(terminated)(_.terminated(_))
        .ifSome(terminating)(_.terminating(_))
        .ifSome(unassigning)(_.unassigning(_))
        .build

    def layer(
      arn: Option[String] = None,
      stackId: Option[String] = None,
      layerId: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      shortname: Option[String] = None,
      attributes: Option[LayerAttributes] = None,
      cloudWatchLogsConfiguration: Option[CloudWatchLogsConfiguration] = None,
      customInstanceProfileArn: Option[String] = None,
      customJson: Option[String] = None,
      customSecurityGroupIds: Option[List[String]] = None,
      defaultSecurityGroupNames: Option[List[String]] = None,
      packages: Option[List[String]] = None,
      volumeConfigurations: Option[List[VolumeConfiguration]] = None,
      enableAutoHealing: Option[Boolean] = None,
      autoAssignElasticIps: Option[Boolean] = None,
      autoAssignPublicIps: Option[Boolean] = None,
      defaultRecipes: Option[Recipes] = None,
      customRecipes: Option[Recipes] = None,
      createdAt: Option[String] = None,
      installUpdatesOnBoot: Option[Boolean] = None,
      useEbsOptimizedInstances: Option[Boolean] = None,
      lifecycleEventConfiguration: Option[LifecycleEventConfiguration] = None
    ): Layer =
      Layer
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(layerId)(_.layerId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(shortname)(_.shortname(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(cloudWatchLogsConfiguration)(_.cloudWatchLogsConfiguration(_))
        .ifSome(customInstanceProfileArn)(_.customInstanceProfileArn(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(customSecurityGroupIds)(_.customSecurityGroupIds(_))
        .ifSome(defaultSecurityGroupNames)(_.defaultSecurityGroupNames(_))
        .ifSome(packages)(_.packages(_))
        .ifSome(volumeConfigurations)(_.volumeConfigurations(_))
        .ifSome(enableAutoHealing)(_.enableAutoHealing(_))
        .ifSome(autoAssignElasticIps)(_.autoAssignElasticIps(_))
        .ifSome(autoAssignPublicIps)(_.autoAssignPublicIps(_))
        .ifSome(defaultRecipes)(_.defaultRecipes(_))
        .ifSome(customRecipes)(_.customRecipes(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(installUpdatesOnBoot)(_.installUpdatesOnBoot(_))
        .ifSome(useEbsOptimizedInstances)(_.useEbsOptimizedInstances(_))
        .ifSome(lifecycleEventConfiguration)(_.lifecycleEventConfiguration(_))
        .build

    def lifecycleEventConfiguration(
      shutdown: Option[ShutdownEventConfiguration] = None
    ): LifecycleEventConfiguration =
      LifecycleEventConfiguration
        .builder
        .ifSome(shutdown)(_.shutdown(_))
        .build

    def listTagsRequest(
      resourceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loadBasedAutoScalingConfiguration(
      layerId: Option[String] = None,
      enable: Option[Boolean] = None,
      upScaling: Option[AutoScalingThresholds] = None,
      downScaling: Option[AutoScalingThresholds] = None
    ): LoadBasedAutoScalingConfiguration =
      LoadBasedAutoScalingConfiguration
        .builder
        .ifSome(layerId)(_.layerId(_))
        .ifSome(enable)(_.enable(_))
        .ifSome(upScaling)(_.upScaling(_))
        .ifSome(downScaling)(_.downScaling(_))
        .build

    def operatingSystem(
      name: Option[String] = None,
      id: Option[String] = None,
      `type`: Option[String] = None,
      configurationManagers: Option[List[OperatingSystemConfigurationManager]] = None,
      reportedName: Option[String] = None,
      reportedVersion: Option[String] = None,
      supported: Option[Boolean] = None
    ): OperatingSystem =
      OperatingSystem
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(configurationManagers)(_.configurationManagers(_))
        .ifSome(reportedName)(_.reportedName(_))
        .ifSome(reportedVersion)(_.reportedVersion(_))
        .ifSome(supported)(_.supported(_))
        .build

    def operatingSystemConfigurationManager(
      name: Option[String] = None,
      version: Option[String] = None
    ): OperatingSystemConfigurationManager =
      OperatingSystemConfigurationManager
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def permission(
      stackId: Option[String] = None,
      iamUserArn: Option[String] = None,
      allowSsh: Option[Boolean] = None,
      allowSudo: Option[Boolean] = None,
      level: Option[String] = None
    ): Permission =
      Permission
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(allowSsh)(_.allowSsh(_))
        .ifSome(allowSudo)(_.allowSudo(_))
        .ifSome(level)(_.level(_))
        .build

    def raidArray(
      raidArrayId: Option[String] = None,
      instanceId: Option[String] = None,
      name: Option[String] = None,
      raidLevel: Option[Int] = None,
      numberOfDisks: Option[Int] = None,
      size: Option[Int] = None,
      device: Option[String] = None,
      mountPoint: Option[String] = None,
      availabilityZone: Option[String] = None,
      createdAt: Option[String] = None,
      stackId: Option[String] = None,
      volumeType: Option[String] = None,
      iops: Option[Int] = None
    ): RaidArray =
      RaidArray
        .builder
        .ifSome(raidArrayId)(_.raidArrayId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(raidLevel)(_.raidLevel(_))
        .ifSome(numberOfDisks)(_.numberOfDisks(_))
        .ifSome(size)(_.size(_))
        .ifSome(device)(_.device(_))
        .ifSome(mountPoint)(_.mountPoint(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(iops)(_.iops(_))
        .build

    def rdsDbInstance(
      rdsDbInstanceArn: Option[String] = None,
      dbInstanceIdentifier: Option[String] = None,
      dbUser: Option[String] = None,
      dbPassword: Option[String] = None,
      region: Option[String] = None,
      address: Option[String] = None,
      engine: Option[String] = None,
      stackId: Option[String] = None,
      missingOnRds: Option[Boolean] = None
    ): RdsDbInstance =
      RdsDbInstance
        .builder
        .ifSome(rdsDbInstanceArn)(_.rdsDbInstanceArn(_))
        .ifSome(dbInstanceIdentifier)(_.dbInstanceIdentifier(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(dbPassword)(_.dbPassword(_))
        .ifSome(region)(_.region(_))
        .ifSome(address)(_.address(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(missingOnRds)(_.missingOnRds(_))
        .build

    def rebootInstanceRequest(
      instanceId: Option[String] = None
    ): RebootInstanceRequest =
      RebootInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def recipes(
      setup: Option[List[String]] = None,
      configure: Option[List[String]] = None,
      deploy: Option[List[String]] = None,
      undeploy: Option[List[String]] = None,
      shutdown: Option[List[String]] = None
    ): Recipes =
      Recipes
        .builder
        .ifSome(setup)(_.setup(_))
        .ifSome(configure)(_.configure(_))
        .ifSome(deploy)(_.deploy(_))
        .ifSome(undeploy)(_.undeploy(_))
        .ifSome(shutdown)(_.shutdown(_))
        .build

    def registerEcsClusterRequest(
      ecsClusterArn: Option[String] = None,
      stackId: Option[String] = None
    ): RegisterEcsClusterRequest =
      RegisterEcsClusterRequest
        .builder
        .ifSome(ecsClusterArn)(_.ecsClusterArn(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def registerElasticIpRequest(
      elasticIp: Option[String] = None,
      stackId: Option[String] = None
    ): RegisterElasticIpRequest =
      RegisterElasticIpRequest
        .builder
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def registerInstanceRequest(
      stackId: Option[String] = None,
      hostname: Option[String] = None,
      publicIp: Option[String] = None,
      privateIp: Option[String] = None,
      rsaPublicKey: Option[String] = None,
      rsaPublicKeyFingerprint: Option[String] = None,
      instanceIdentity: Option[InstanceIdentity] = None
    ): RegisterInstanceRequest =
      RegisterInstanceRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(privateIp)(_.privateIp(_))
        .ifSome(rsaPublicKey)(_.rsaPublicKey(_))
        .ifSome(rsaPublicKeyFingerprint)(_.rsaPublicKeyFingerprint(_))
        .ifSome(instanceIdentity)(_.instanceIdentity(_))
        .build

    def registerRdsDbInstanceRequest(
      stackId: Option[String] = None,
      rdsDbInstanceArn: Option[String] = None,
      dbUser: Option[String] = None,
      dbPassword: Option[String] = None
    ): RegisterRdsDbInstanceRequest =
      RegisterRdsDbInstanceRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(rdsDbInstanceArn)(_.rdsDbInstanceArn(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(dbPassword)(_.dbPassword(_))
        .build

    def registerVolumeRequest(
      ec2VolumeId: Option[String] = None,
      stackId: Option[String] = None
    ): RegisterVolumeRequest =
      RegisterVolumeRequest
        .builder
        .ifSome(ec2VolumeId)(_.ec2VolumeId(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def reportedOs(
      family: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None
    ): ReportedOs =
      ReportedOs
        .builder
        .ifSome(family)(_.family(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def selfUserProfile(
      iamUserArn: Option[String] = None,
      name: Option[String] = None,
      sshUsername: Option[String] = None,
      sshPublicKey: Option[String] = None
    ): SelfUserProfile =
      SelfUserProfile
        .builder
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(sshUsername)(_.sshUsername(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .build

    def serviceError(
      serviceErrorId: Option[String] = None,
      stackId: Option[String] = None,
      instanceId: Option[String] = None,
      `type`: Option[String] = None,
      message: Option[String] = None,
      createdAt: Option[String] = None
    ): ServiceError =
      ServiceError
        .builder
        .ifSome(serviceErrorId)(_.serviceErrorId(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def setLoadBasedAutoScalingRequest(
      layerId: Option[String] = None,
      enable: Option[Boolean] = None,
      upScaling: Option[AutoScalingThresholds] = None,
      downScaling: Option[AutoScalingThresholds] = None
    ): SetLoadBasedAutoScalingRequest =
      SetLoadBasedAutoScalingRequest
        .builder
        .ifSome(layerId)(_.layerId(_))
        .ifSome(enable)(_.enable(_))
        .ifSome(upScaling)(_.upScaling(_))
        .ifSome(downScaling)(_.downScaling(_))
        .build

    def setPermissionRequest(
      stackId: Option[String] = None,
      iamUserArn: Option[String] = None,
      allowSsh: Option[Boolean] = None,
      allowSudo: Option[Boolean] = None,
      level: Option[String] = None
    ): SetPermissionRequest =
      SetPermissionRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(allowSsh)(_.allowSsh(_))
        .ifSome(allowSudo)(_.allowSudo(_))
        .ifSome(level)(_.level(_))
        .build

    def setTimeBasedAutoScalingRequest(
      instanceId: Option[String] = None,
      autoScalingSchedule: Option[WeeklyAutoScalingSchedule] = None
    ): SetTimeBasedAutoScalingRequest =
      SetTimeBasedAutoScalingRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(autoScalingSchedule)(_.autoScalingSchedule(_))
        .build

    def shutdownEventConfiguration(
      executionTimeout: Option[Int] = None,
      delayUntilElbConnectionsDrained: Option[Boolean] = None
    ): ShutdownEventConfiguration =
      ShutdownEventConfiguration
        .builder
        .ifSome(executionTimeout)(_.executionTimeout(_))
        .ifSome(delayUntilElbConnectionsDrained)(_.delayUntilElbConnectionsDrained(_))
        .build

    def source(
      `type`: Option[String] = None,
      url: Option[String] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      sshKey: Option[String] = None,
      revision: Option[String] = None
    ): Source =
      Source
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(url)(_.url(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(sshKey)(_.sshKey(_))
        .ifSome(revision)(_.revision(_))
        .build

    def sslConfiguration(
      certificate: Option[String] = None,
      privateKey: Option[String] = None,
      chain: Option[String] = None
    ): SslConfiguration =
      SslConfiguration
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(chain)(_.chain(_))
        .build

    def stack(
      stackId: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      region: Option[String] = None,
      vpcId: Option[String] = None,
      attributes: Option[StackAttributes] = None,
      serviceRoleArn: Option[String] = None,
      defaultInstanceProfileArn: Option[String] = None,
      defaultOs: Option[String] = None,
      hostnameTheme: Option[String] = None,
      defaultAvailabilityZone: Option[String] = None,
      defaultSubnetId: Option[String] = None,
      customJson: Option[String] = None,
      configurationManager: Option[StackConfigurationManager] = None,
      chefConfiguration: Option[ChefConfiguration] = None,
      useCustomCookbooks: Option[Boolean] = None,
      useOpsworksSecurityGroups: Option[Boolean] = None,
      customCookbooksSource: Option[Source] = None,
      defaultSshKeyName: Option[String] = None,
      createdAt: Option[String] = None,
      defaultRootDeviceType: Option[String] = None,
      agentVersion: Option[String] = None
    ): Stack =
      Stack
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(region)(_.region(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(defaultInstanceProfileArn)(_.defaultInstanceProfileArn(_))
        .ifSome(defaultOs)(_.defaultOs(_))
        .ifSome(hostnameTheme)(_.hostnameTheme(_))
        .ifSome(defaultAvailabilityZone)(_.defaultAvailabilityZone(_))
        .ifSome(defaultSubnetId)(_.defaultSubnetId(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(configurationManager)(_.configurationManager(_))
        .ifSome(chefConfiguration)(_.chefConfiguration(_))
        .ifSome(useCustomCookbooks)(_.useCustomCookbooks(_))
        .ifSome(useOpsworksSecurityGroups)(_.useOpsworksSecurityGroups(_))
        .ifSome(customCookbooksSource)(_.customCookbooksSource(_))
        .ifSome(defaultSshKeyName)(_.defaultSshKeyName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(defaultRootDeviceType)(_.defaultRootDeviceType(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .build

    def stackConfigurationManager(
      name: Option[String] = None,
      version: Option[String] = None
    ): StackConfigurationManager =
      StackConfigurationManager
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def stackSummary(
      stackId: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      layersCount: Option[Int] = None,
      appsCount: Option[Int] = None,
      instancesCount: Option[InstancesCount] = None
    ): StackSummary =
      StackSummary
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(layersCount)(_.layersCount(_))
        .ifSome(appsCount)(_.appsCount(_))
        .ifSome(instancesCount)(_.instancesCount(_))
        .build

    def startInstanceRequest(
      instanceId: Option[String] = None
    ): StartInstanceRequest =
      StartInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def startStackRequest(
      stackId: Option[String] = None
    ): StartStackRequest =
      StartStackRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def stopInstanceRequest(
      instanceId: Option[String] = None,
      force: Option[Boolean] = None
    ): StopInstanceRequest =
      StopInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(force)(_.force(_))
        .build

    def stopStackRequest(
      stackId: Option[String] = None
    ): StopStackRequest =
      StopStackRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def temporaryCredential(
      username: Option[String] = None,
      password: Option[String] = None,
      validForInMinutes: Option[Int] = None,
      instanceId: Option[String] = None
    ): TemporaryCredential =
      TemporaryCredential
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(validForInMinutes)(_.validForInMinutes(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def timeBasedAutoScalingConfiguration(
      instanceId: Option[String] = None,
      autoScalingSchedule: Option[WeeklyAutoScalingSchedule] = None
    ): TimeBasedAutoScalingConfiguration =
      TimeBasedAutoScalingConfiguration
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(autoScalingSchedule)(_.autoScalingSchedule(_))
        .build

    def unassignInstanceRequest(
      instanceId: Option[String] = None
    ): UnassignInstanceRequest =
      UnassignInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def unassignVolumeRequest(
      volumeId: Option[String] = None
    ): UnassignVolumeRequest =
      UnassignVolumeRequest
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAppRequest(
      appId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      dataSources: Option[List[DataSource]] = None,
      `type`: Option[String] = None,
      appSource: Option[Source] = None,
      domains: Option[List[String]] = None,
      enableSsl: Option[Boolean] = None,
      sslConfiguration: Option[SslConfiguration] = None,
      attributes: Option[AppAttributes] = None,
      environment: Option[List[EnvironmentVariable]] = None
    ): UpdateAppRequest =
      UpdateAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(appSource)(_.appSource(_))
        .ifSome(domains)(_.domains(_))
        .ifSome(enableSsl)(_.enableSsl(_))
        .ifSome(sslConfiguration)(_.sslConfiguration(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(environment)(_.environment(_))
        .build

    def updateElasticIpRequest(
      elasticIp: Option[String] = None,
      name: Option[String] = None
    ): UpdateElasticIpRequest =
      UpdateElasticIpRequest
        .builder
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(name)(_.name(_))
        .build

    def updateInstanceRequest(
      instanceId: Option[String] = None,
      layerIds: Option[List[String]] = None,
      instanceType: Option[String] = None,
      autoScalingType: Option[String] = None,
      hostname: Option[String] = None,
      os: Option[String] = None,
      amiId: Option[String] = None,
      sshKeyName: Option[String] = None,
      architecture: Option[String] = None,
      installUpdatesOnBoot: Option[Boolean] = None,
      ebsOptimized: Option[Boolean] = None,
      agentVersion: Option[String] = None
    ): UpdateInstanceRequest =
      UpdateInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(layerIds)(_.layerIds(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(autoScalingType)(_.autoScalingType(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(os)(_.os(_))
        .ifSome(amiId)(_.amiId(_))
        .ifSome(sshKeyName)(_.sshKeyName(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(installUpdatesOnBoot)(_.installUpdatesOnBoot(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .build

    def updateLayerRequest(
      layerId: Option[String] = None,
      name: Option[String] = None,
      shortname: Option[String] = None,
      attributes: Option[LayerAttributes] = None,
      cloudWatchLogsConfiguration: Option[CloudWatchLogsConfiguration] = None,
      customInstanceProfileArn: Option[String] = None,
      customJson: Option[String] = None,
      customSecurityGroupIds: Option[List[String]] = None,
      packages: Option[List[String]] = None,
      volumeConfigurations: Option[List[VolumeConfiguration]] = None,
      enableAutoHealing: Option[Boolean] = None,
      autoAssignElasticIps: Option[Boolean] = None,
      autoAssignPublicIps: Option[Boolean] = None,
      customRecipes: Option[Recipes] = None,
      installUpdatesOnBoot: Option[Boolean] = None,
      useEbsOptimizedInstances: Option[Boolean] = None,
      lifecycleEventConfiguration: Option[LifecycleEventConfiguration] = None
    ): UpdateLayerRequest =
      UpdateLayerRequest
        .builder
        .ifSome(layerId)(_.layerId(_))
        .ifSome(name)(_.name(_))
        .ifSome(shortname)(_.shortname(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(cloudWatchLogsConfiguration)(_.cloudWatchLogsConfiguration(_))
        .ifSome(customInstanceProfileArn)(_.customInstanceProfileArn(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(customSecurityGroupIds)(_.customSecurityGroupIds(_))
        .ifSome(packages)(_.packages(_))
        .ifSome(volumeConfigurations)(_.volumeConfigurations(_))
        .ifSome(enableAutoHealing)(_.enableAutoHealing(_))
        .ifSome(autoAssignElasticIps)(_.autoAssignElasticIps(_))
        .ifSome(autoAssignPublicIps)(_.autoAssignPublicIps(_))
        .ifSome(customRecipes)(_.customRecipes(_))
        .ifSome(installUpdatesOnBoot)(_.installUpdatesOnBoot(_))
        .ifSome(useEbsOptimizedInstances)(_.useEbsOptimizedInstances(_))
        .ifSome(lifecycleEventConfiguration)(_.lifecycleEventConfiguration(_))
        .build

    def updateMyUserProfileRequest(
      sshPublicKey: Option[String] = None
    ): UpdateMyUserProfileRequest =
      UpdateMyUserProfileRequest
        .builder
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .build

    def updateRdsDbInstanceRequest(
      rdsDbInstanceArn: Option[String] = None,
      dbUser: Option[String] = None,
      dbPassword: Option[String] = None
    ): UpdateRdsDbInstanceRequest =
      UpdateRdsDbInstanceRequest
        .builder
        .ifSome(rdsDbInstanceArn)(_.rdsDbInstanceArn(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(dbPassword)(_.dbPassword(_))
        .build

    def updateStackRequest(
      stackId: Option[String] = None,
      name: Option[String] = None,
      attributes: Option[StackAttributes] = None,
      serviceRoleArn: Option[String] = None,
      defaultInstanceProfileArn: Option[String] = None,
      defaultOs: Option[String] = None,
      hostnameTheme: Option[String] = None,
      defaultAvailabilityZone: Option[String] = None,
      defaultSubnetId: Option[String] = None,
      customJson: Option[String] = None,
      configurationManager: Option[StackConfigurationManager] = None,
      chefConfiguration: Option[ChefConfiguration] = None,
      useCustomCookbooks: Option[Boolean] = None,
      customCookbooksSource: Option[Source] = None,
      defaultSshKeyName: Option[String] = None,
      defaultRootDeviceType: Option[String] = None,
      useOpsworksSecurityGroups: Option[Boolean] = None,
      agentVersion: Option[String] = None
    ): UpdateStackRequest =
      UpdateStackRequest
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(defaultInstanceProfileArn)(_.defaultInstanceProfileArn(_))
        .ifSome(defaultOs)(_.defaultOs(_))
        .ifSome(hostnameTheme)(_.hostnameTheme(_))
        .ifSome(defaultAvailabilityZone)(_.defaultAvailabilityZone(_))
        .ifSome(defaultSubnetId)(_.defaultSubnetId(_))
        .ifSome(customJson)(_.customJson(_))
        .ifSome(configurationManager)(_.configurationManager(_))
        .ifSome(chefConfiguration)(_.chefConfiguration(_))
        .ifSome(useCustomCookbooks)(_.useCustomCookbooks(_))
        .ifSome(customCookbooksSource)(_.customCookbooksSource(_))
        .ifSome(defaultSshKeyName)(_.defaultSshKeyName(_))
        .ifSome(defaultRootDeviceType)(_.defaultRootDeviceType(_))
        .ifSome(useOpsworksSecurityGroups)(_.useOpsworksSecurityGroups(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .build

    def updateUserProfileRequest(
      iamUserArn: Option[String] = None,
      sshUsername: Option[String] = None,
      sshPublicKey: Option[String] = None,
      allowSelfManagement: Option[Boolean] = None
    ): UpdateUserProfileRequest =
      UpdateUserProfileRequest
        .builder
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(sshUsername)(_.sshUsername(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .ifSome(allowSelfManagement)(_.allowSelfManagement(_))
        .build

    def updateVolumeRequest(
      volumeId: Option[String] = None,
      name: Option[String] = None,
      mountPoint: Option[String] = None
    ): UpdateVolumeRequest =
      UpdateVolumeRequest
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(name)(_.name(_))
        .ifSome(mountPoint)(_.mountPoint(_))
        .build

    def userProfile(
      iamUserArn: Option[String] = None,
      name: Option[String] = None,
      sshUsername: Option[String] = None,
      sshPublicKey: Option[String] = None,
      allowSelfManagement: Option[Boolean] = None
    ): UserProfile =
      UserProfile
        .builder
        .ifSome(iamUserArn)(_.iamUserArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(sshUsername)(_.sshUsername(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .ifSome(allowSelfManagement)(_.allowSelfManagement(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def volume(
      volumeId: Option[String] = None,
      ec2VolumeId: Option[String] = None,
      name: Option[String] = None,
      raidArrayId: Option[String] = None,
      instanceId: Option[String] = None,
      status: Option[String] = None,
      size: Option[Int] = None,
      device: Option[String] = None,
      mountPoint: Option[String] = None,
      region: Option[String] = None,
      availabilityZone: Option[String] = None,
      volumeType: Option[String] = None,
      iops: Option[Int] = None,
      encrypted: Option[Boolean] = None
    ): Volume =
      Volume
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(ec2VolumeId)(_.ec2VolumeId(_))
        .ifSome(name)(_.name(_))
        .ifSome(raidArrayId)(_.raidArrayId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(status)(_.status(_))
        .ifSome(size)(_.size(_))
        .ifSome(device)(_.device(_))
        .ifSome(mountPoint)(_.mountPoint(_))
        .ifSome(region)(_.region(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(encrypted)(_.encrypted(_))
        .build

    def volumeConfiguration(
      mountPoint: Option[String] = None,
      raidLevel: Option[Int] = None,
      numberOfDisks: Option[Int] = None,
      size: Option[Int] = None,
      volumeType: Option[String] = None,
      iops: Option[Int] = None,
      encrypted: Option[Boolean] = None
    ): VolumeConfiguration =
      VolumeConfiguration
        .builder
        .ifSome(mountPoint)(_.mountPoint(_))
        .ifSome(raidLevel)(_.raidLevel(_))
        .ifSome(numberOfDisks)(_.numberOfDisks(_))
        .ifSome(size)(_.size(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(encrypted)(_.encrypted(_))
        .build

    def weeklyAutoScalingSchedule(
      monday: Option[DailyAutoScalingSchedule] = None,
      tuesday: Option[DailyAutoScalingSchedule] = None,
      wednesday: Option[DailyAutoScalingSchedule] = None,
      thursday: Option[DailyAutoScalingSchedule] = None,
      friday: Option[DailyAutoScalingSchedule] = None,
      saturday: Option[DailyAutoScalingSchedule] = None,
      sunday: Option[DailyAutoScalingSchedule] = None
    ): WeeklyAutoScalingSchedule =
      WeeklyAutoScalingSchedule
        .builder
        .ifSome(monday)(_.monday(_))
        .ifSome(tuesday)(_.tuesday(_))
        .ifSome(wednesday)(_.wednesday(_))
        .ifSome(thursday)(_.thursday(_))
        .ifSome(friday)(_.friday(_))
        .ifSome(saturday)(_.saturday(_))
        .ifSome(sunday)(_.sunday(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
