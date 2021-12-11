package goober.hi

import goober.free.ecs.EcsIO
import software.amazon.awssdk.services.ecs.model._


object ecs {
  import goober.free.{ecs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(

    ): AccessDeniedException =
      AccessDeniedException
        .builder

        .build

    def attachment(
      id: Option[String] = None,
      `type`: Option[String] = None,
      status: Option[String] = None,
      details: Option[List[KeyValuePair]] = None
    ): Attachment =
      Attachment
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .ifSome(details)(_.details(_))
        .build

    def attachmentStateChange(
      attachmentArn: Option[String] = None,
      status: Option[String] = None
    ): AttachmentStateChange =
      AttachmentStateChange
        .builder
        .ifSome(attachmentArn)(_.attachmentArn(_))
        .ifSome(status)(_.status(_))
        .build

    def attribute(
      name: Option[String] = None,
      value: Option[String] = None,
      targetType: Option[String] = None,
      targetId: Option[String] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(targetId)(_.targetId(_))
        .build

    def attributeLimitExceededException(

    ): AttributeLimitExceededException =
      AttributeLimitExceededException
        .builder

        .build

    def autoScalingGroupProvider(
      autoScalingGroupArn: Option[String] = None,
      managedScaling: Option[ManagedScaling] = None,
      managedTerminationProtection: Option[String] = None
    ): AutoScalingGroupProvider =
      AutoScalingGroupProvider
        .builder
        .ifSome(autoScalingGroupArn)(_.autoScalingGroupArn(_))
        .ifSome(managedScaling)(_.managedScaling(_))
        .ifSome(managedTerminationProtection)(_.managedTerminationProtection(_))
        .build

    def autoScalingGroupProviderUpdate(
      managedScaling: Option[ManagedScaling] = None,
      managedTerminationProtection: Option[String] = None
    ): AutoScalingGroupProviderUpdate =
      AutoScalingGroupProviderUpdate
        .builder
        .ifSome(managedScaling)(_.managedScaling(_))
        .ifSome(managedTerminationProtection)(_.managedTerminationProtection(_))
        .build

    def awsVpcConfiguration(
      subnets: Option[List[String]] = None,
      securityGroups: Option[List[String]] = None,
      assignPublicIp: Option[String] = None
    ): AwsVpcConfiguration =
      AwsVpcConfiguration
        .builder
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(assignPublicIp)(_.assignPublicIp(_))
        .build

    def blockedException(

    ): BlockedException =
      BlockedException
        .builder

        .build

    def capacityProvider(
      capacityProviderArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      autoScalingGroupProvider: Option[AutoScalingGroupProvider] = None,
      updateStatus: Option[String] = None,
      updateStatusReason: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CapacityProvider =
      CapacityProvider
        .builder
        .ifSome(capacityProviderArn)(_.capacityProviderArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(autoScalingGroupProvider)(_.autoScalingGroupProvider(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .ifSome(updateStatusReason)(_.updateStatusReason(_))
        .ifSome(tags)(_.tags(_))
        .build

    def capacityProviderStrategyItem(
      capacityProvider: Option[String] = None,
      weight: Option[Int] = None,
      base: Option[Int] = None
    ): CapacityProviderStrategyItem =
      CapacityProviderStrategyItem
        .builder
        .ifSome(capacityProvider)(_.capacityProvider(_))
        .ifSome(weight)(_.weight(_))
        .ifSome(base)(_.base(_))
        .build

    def clientException(
      message: Option[String] = None
    ): ClientException =
      ClientException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cluster(
      clusterArn: Option[String] = None,
      clusterName: Option[String] = None,
      configuration: Option[ClusterConfiguration] = None,
      status: Option[String] = None,
      registeredContainerInstancesCount: Option[Int] = None,
      runningTasksCount: Option[Int] = None,
      pendingTasksCount: Option[Int] = None,
      activeServicesCount: Option[Int] = None,
      statistics: Option[List[KeyValuePair]] = None,
      tags: Option[List[Tag]] = None,
      settings: Option[List[ClusterSetting]] = None,
      capacityProviders: Option[List[String]] = None,
      defaultCapacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      attachments: Option[List[Attachment]] = None,
      attachmentsStatus: Option[String] = None
    ): Cluster =
      Cluster
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(status)(_.status(_))
        .ifSome(registeredContainerInstancesCount)(_.registeredContainerInstancesCount(_))
        .ifSome(runningTasksCount)(_.runningTasksCount(_))
        .ifSome(pendingTasksCount)(_.pendingTasksCount(_))
        .ifSome(activeServicesCount)(_.activeServicesCount(_))
        .ifSome(statistics)(_.statistics(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(capacityProviders)(_.capacityProviders(_))
        .ifSome(defaultCapacityProviderStrategy)(_.defaultCapacityProviderStrategy(_))
        .ifSome(attachments)(_.attachments(_))
        .ifSome(attachmentsStatus)(_.attachmentsStatus(_))
        .build

    def clusterConfiguration(
      executeCommandConfiguration: Option[ExecuteCommandConfiguration] = None
    ): ClusterConfiguration =
      ClusterConfiguration
        .builder
        .ifSome(executeCommandConfiguration)(_.executeCommandConfiguration(_))
        .build

    def clusterContainsContainerInstancesException(

    ): ClusterContainsContainerInstancesException =
      ClusterContainsContainerInstancesException
        .builder

        .build

    def clusterContainsServicesException(

    ): ClusterContainsServicesException =
      ClusterContainsServicesException
        .builder

        .build

    def clusterContainsTasksException(

    ): ClusterContainsTasksException =
      ClusterContainsTasksException
        .builder

        .build

    def clusterNotFoundException(

    ): ClusterNotFoundException =
      ClusterNotFoundException
        .builder

        .build

    def clusterSetting(
      name: Option[String] = None,
      value: Option[String] = None
    ): ClusterSetting =
      ClusterSetting
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def container(
      containerArn: Option[String] = None,
      taskArn: Option[String] = None,
      name: Option[String] = None,
      image: Option[String] = None,
      imageDigest: Option[String] = None,
      runtimeId: Option[String] = None,
      lastStatus: Option[String] = None,
      exitCode: Option[Int] = None,
      reason: Option[String] = None,
      networkBindings: Option[List[NetworkBinding]] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None,
      healthStatus: Option[String] = None,
      managedAgents: Option[List[ManagedAgent]] = None,
      cpu: Option[String] = None,
      memory: Option[String] = None,
      memoryReservation: Option[String] = None,
      gpuIds: Option[List[String]] = None
    ): Container =
      Container
        .builder
        .ifSome(containerArn)(_.containerArn(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(image)(_.image(_))
        .ifSome(imageDigest)(_.imageDigest(_))
        .ifSome(runtimeId)(_.runtimeId(_))
        .ifSome(lastStatus)(_.lastStatus(_))
        .ifSome(exitCode)(_.exitCode(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(networkBindings)(_.networkBindings(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(managedAgents)(_.managedAgents(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(memoryReservation)(_.memoryReservation(_))
        .ifSome(gpuIds)(_.gpuIds(_))
        .build

    def containerDefinition(
      name: Option[String] = None,
      image: Option[String] = None,
      repositoryCredentials: Option[RepositoryCredentials] = None,
      cpu: Option[Int] = None,
      memory: Option[Int] = None,
      memoryReservation: Option[Int] = None,
      links: Option[List[String]] = None,
      portMappings: Option[List[PortMapping]] = None,
      essential: Option[Boolean] = None,
      entryPoint: Option[List[String]] = None,
      command: Option[List[String]] = None,
      environment: Option[List[KeyValuePair]] = None,
      environmentFiles: Option[List[EnvironmentFile]] = None,
      mountPoints: Option[List[MountPoint]] = None,
      volumesFrom: Option[List[VolumeFrom]] = None,
      linuxParameters: Option[LinuxParameters] = None,
      secrets: Option[List[Secret]] = None,
      dependsOn: Option[List[ContainerDependency]] = None,
      startTimeout: Option[Int] = None,
      stopTimeout: Option[Int] = None,
      hostname: Option[String] = None,
      user: Option[String] = None,
      workingDirectory: Option[String] = None,
      disableNetworking: Option[Boolean] = None,
      privileged: Option[Boolean] = None,
      readonlyRootFilesystem: Option[Boolean] = None,
      dnsServers: Option[List[String]] = None,
      dnsSearchDomains: Option[List[String]] = None,
      extraHosts: Option[List[HostEntry]] = None,
      dockerSecurityOptions: Option[List[String]] = None,
      interactive: Option[Boolean] = None,
      pseudoTerminal: Option[Boolean] = None,
      dockerLabels: Option[DockerLabelsMap] = None,
      ulimits: Option[List[Ulimit]] = None,
      logConfiguration: Option[LogConfiguration] = None,
      healthCheck: Option[HealthCheck] = None,
      systemControls: Option[List[SystemControl]] = None,
      resourceRequirements: Option[List[ResourceRequirement]] = None,
      firelensConfiguration: Option[FirelensConfiguration] = None
    ): ContainerDefinition =
      ContainerDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(image)(_.image(_))
        .ifSome(repositoryCredentials)(_.repositoryCredentials(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(memoryReservation)(_.memoryReservation(_))
        .ifSome(links)(_.links(_))
        .ifSome(portMappings)(_.portMappings(_))
        .ifSome(essential)(_.essential(_))
        .ifSome(entryPoint)(_.entryPoint(_))
        .ifSome(command)(_.command(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(environmentFiles)(_.environmentFiles(_))
        .ifSome(mountPoints)(_.mountPoints(_))
        .ifSome(volumesFrom)(_.volumesFrom(_))
        .ifSome(linuxParameters)(_.linuxParameters(_))
        .ifSome(secrets)(_.secrets(_))
        .ifSome(dependsOn)(_.dependsOn(_))
        .ifSome(startTimeout)(_.startTimeout(_))
        .ifSome(stopTimeout)(_.stopTimeout(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(user)(_.user(_))
        .ifSome(workingDirectory)(_.workingDirectory(_))
        .ifSome(disableNetworking)(_.disableNetworking(_))
        .ifSome(privileged)(_.privileged(_))
        .ifSome(readonlyRootFilesystem)(_.readonlyRootFilesystem(_))
        .ifSome(dnsServers)(_.dnsServers(_))
        .ifSome(dnsSearchDomains)(_.dnsSearchDomains(_))
        .ifSome(extraHosts)(_.extraHosts(_))
        .ifSome(dockerSecurityOptions)(_.dockerSecurityOptions(_))
        .ifSome(interactive)(_.interactive(_))
        .ifSome(pseudoTerminal)(_.pseudoTerminal(_))
        .ifSome(dockerLabels)(_.dockerLabels(_))
        .ifSome(ulimits)(_.ulimits(_))
        .ifSome(logConfiguration)(_.logConfiguration(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .ifSome(systemControls)(_.systemControls(_))
        .ifSome(resourceRequirements)(_.resourceRequirements(_))
        .ifSome(firelensConfiguration)(_.firelensConfiguration(_))
        .build

    def containerDependency(
      containerName: Option[String] = None,
      condition: Option[String] = None
    ): ContainerDependency =
      ContainerDependency
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(condition)(_.condition(_))
        .build

    def containerInstance(
      containerInstanceArn: Option[String] = None,
      ec2InstanceId: Option[String] = None,
      capacityProviderName: Option[String] = None,
      version: Option[Long] = None,
      versionInfo: Option[VersionInfo] = None,
      remainingResources: Option[List[Resource]] = None,
      registeredResources: Option[List[Resource]] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      agentConnected: Option[Boolean] = None,
      runningTasksCount: Option[Int] = None,
      pendingTasksCount: Option[Int] = None,
      agentUpdateStatus: Option[String] = None,
      attributes: Option[List[Attribute]] = None,
      registeredAt: Option[Timestamp] = None,
      attachments: Option[List[Attachment]] = None,
      tags: Option[List[Tag]] = None
    ): ContainerInstance =
      ContainerInstance
        .builder
        .ifSome(containerInstanceArn)(_.containerInstanceArn(_))
        .ifSome(ec2InstanceId)(_.ec2InstanceId(_))
        .ifSome(capacityProviderName)(_.capacityProviderName(_))
        .ifSome(version)(_.version(_))
        .ifSome(versionInfo)(_.versionInfo(_))
        .ifSome(remainingResources)(_.remainingResources(_))
        .ifSome(registeredResources)(_.registeredResources(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(agentConnected)(_.agentConnected(_))
        .ifSome(runningTasksCount)(_.runningTasksCount(_))
        .ifSome(pendingTasksCount)(_.pendingTasksCount(_))
        .ifSome(agentUpdateStatus)(_.agentUpdateStatus(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(registeredAt)(_.registeredAt(_))
        .ifSome(attachments)(_.attachments(_))
        .ifSome(tags)(_.tags(_))
        .build

    def containerOverride(
      name: Option[String] = None,
      command: Option[List[String]] = None,
      environment: Option[List[KeyValuePair]] = None,
      environmentFiles: Option[List[EnvironmentFile]] = None,
      cpu: Option[Int] = None,
      memory: Option[Int] = None,
      memoryReservation: Option[Int] = None,
      resourceRequirements: Option[List[ResourceRequirement]] = None
    ): ContainerOverride =
      ContainerOverride
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(command)(_.command(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(environmentFiles)(_.environmentFiles(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(memoryReservation)(_.memoryReservation(_))
        .ifSome(resourceRequirements)(_.resourceRequirements(_))
        .build

    def containerStateChange(
      containerName: Option[String] = None,
      imageDigest: Option[String] = None,
      runtimeId: Option[String] = None,
      exitCode: Option[Int] = None,
      networkBindings: Option[List[NetworkBinding]] = None,
      reason: Option[String] = None,
      status: Option[String] = None
    ): ContainerStateChange =
      ContainerStateChange
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(imageDigest)(_.imageDigest(_))
        .ifSome(runtimeId)(_.runtimeId(_))
        .ifSome(exitCode)(_.exitCode(_))
        .ifSome(networkBindings)(_.networkBindings(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(status)(_.status(_))
        .build

    def createCapacityProviderRequest(
      name: Option[String] = None,
      autoScalingGroupProvider: Option[AutoScalingGroupProvider] = None,
      tags: Option[List[Tag]] = None
    ): CreateCapacityProviderRequest =
      CreateCapacityProviderRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(autoScalingGroupProvider)(_.autoScalingGroupProvider(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCapacityProviderResponse(
      capacityProvider: Option[CapacityProvider] = None
    ): CreateCapacityProviderResponse =
      CreateCapacityProviderResponse
        .builder
        .ifSome(capacityProvider)(_.capacityProvider(_))
        .build

    def createClusterRequest(
      clusterName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      settings: Option[List[ClusterSetting]] = None,
      configuration: Option[ClusterConfiguration] = None,
      capacityProviders: Option[List[String]] = None,
      defaultCapacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None
    ): CreateClusterRequest =
      CreateClusterRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(capacityProviders)(_.capacityProviders(_))
        .ifSome(defaultCapacityProviderStrategy)(_.defaultCapacityProviderStrategy(_))
        .build

    def createClusterResponse(
      cluster: Option[Cluster] = None
    ): CreateClusterResponse =
      CreateClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def createServiceRequest(
      cluster: Option[String] = None,
      serviceName: Option[String] = None,
      taskDefinition: Option[String] = None,
      loadBalancers: Option[List[LoadBalancer]] = None,
      serviceRegistries: Option[List[ServiceRegistry]] = None,
      desiredCount: Option[Int] = None,
      clientToken: Option[String] = None,
      launchType: Option[String] = None,
      capacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      platformVersion: Option[String] = None,
      role: Option[String] = None,
      deploymentConfiguration: Option[DeploymentConfiguration] = None,
      placementConstraints: Option[List[PlacementConstraint]] = None,
      placementStrategy: Option[List[PlacementStrategy]] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      healthCheckGracePeriodSeconds: Option[Int] = None,
      schedulingStrategy: Option[String] = None,
      deploymentController: Option[DeploymentController] = None,
      tags: Option[List[Tag]] = None,
      enableECSManagedTags: Option[Boolean] = None,
      propagateTags: Option[String] = None,
      enableExecuteCommand: Option[Boolean] = None
    ): CreateServiceRequest =
      CreateServiceRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .ifSome(serviceRegistries)(_.serviceRegistries(_))
        .ifSome(desiredCount)(_.desiredCount(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(capacityProviderStrategy)(_.capacityProviderStrategy(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(role)(_.role(_))
        .ifSome(deploymentConfiguration)(_.deploymentConfiguration(_))
        .ifSome(placementConstraints)(_.placementConstraints(_))
        .ifSome(placementStrategy)(_.placementStrategy(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(healthCheckGracePeriodSeconds)(_.healthCheckGracePeriodSeconds(_))
        .ifSome(schedulingStrategy)(_.schedulingStrategy(_))
        .ifSome(deploymentController)(_.deploymentController(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(enableECSManagedTags)(_.enableECSManagedTags(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(enableExecuteCommand)(_.enableExecuteCommand(_))
        .build

    def createServiceResponse(
      service: Option[Service] = None
    ): CreateServiceResponse =
      CreateServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .build

    def createTaskSetRequest(
      service: Option[String] = None,
      cluster: Option[String] = None,
      externalId: Option[String] = None,
      taskDefinition: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      loadBalancers: Option[List[LoadBalancer]] = None,
      serviceRegistries: Option[List[ServiceRegistry]] = None,
      launchType: Option[String] = None,
      capacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      platformVersion: Option[String] = None,
      scale: Option[Scale] = None,
      clientToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateTaskSetRequest =
      CreateTaskSetRequest
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(cluster)(_.cluster(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .ifSome(serviceRegistries)(_.serviceRegistries(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(capacityProviderStrategy)(_.capacityProviderStrategy(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTaskSetResponse(
      taskSet: Option[TaskSet] = None
    ): CreateTaskSetResponse =
      CreateTaskSetResponse
        .builder
        .ifSome(taskSet)(_.taskSet(_))
        .build

    def deleteAccountSettingRequest(
      name: Option[String] = None,
      principalArn: Option[String] = None
    ): DeleteAccountSettingRequest =
      DeleteAccountSettingRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(principalArn)(_.principalArn(_))
        .build

    def deleteAccountSettingResponse(
      setting: Option[Setting] = None
    ): DeleteAccountSettingResponse =
      DeleteAccountSettingResponse
        .builder
        .ifSome(setting)(_.setting(_))
        .build

    def deleteAttributesRequest(
      cluster: Option[String] = None,
      attributes: Option[List[Attribute]] = None
    ): DeleteAttributesRequest =
      DeleteAttributesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def deleteAttributesResponse(
      attributes: Option[List[Attribute]] = None
    ): DeleteAttributesResponse =
      DeleteAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def deleteCapacityProviderRequest(
      capacityProvider: Option[String] = None
    ): DeleteCapacityProviderRequest =
      DeleteCapacityProviderRequest
        .builder
        .ifSome(capacityProvider)(_.capacityProvider(_))
        .build

    def deleteCapacityProviderResponse(
      capacityProvider: Option[CapacityProvider] = None
    ): DeleteCapacityProviderResponse =
      DeleteCapacityProviderResponse
        .builder
        .ifSome(capacityProvider)(_.capacityProvider(_))
        .build

    def deleteClusterRequest(
      cluster: Option[String] = None
    ): DeleteClusterRequest =
      DeleteClusterRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def deleteClusterResponse(
      cluster: Option[Cluster] = None
    ): DeleteClusterResponse =
      DeleteClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def deleteServiceRequest(
      cluster: Option[String] = None,
      service: Option[String] = None,
      force: Option[Boolean] = None
    ): DeleteServiceRequest =
      DeleteServiceRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(service)(_.service(_))
        .ifSome(force)(_.force(_))
        .build

    def deleteServiceResponse(
      service: Option[Service] = None
    ): DeleteServiceResponse =
      DeleteServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .build

    def deleteTaskSetRequest(
      cluster: Option[String] = None,
      service: Option[String] = None,
      taskSet: Option[String] = None,
      force: Option[Boolean] = None
    ): DeleteTaskSetRequest =
      DeleteTaskSetRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(service)(_.service(_))
        .ifSome(taskSet)(_.taskSet(_))
        .ifSome(force)(_.force(_))
        .build

    def deleteTaskSetResponse(
      taskSet: Option[TaskSet] = None
    ): DeleteTaskSetResponse =
      DeleteTaskSetResponse
        .builder
        .ifSome(taskSet)(_.taskSet(_))
        .build

    def deployment(
      id: Option[String] = None,
      status: Option[String] = None,
      taskDefinition: Option[String] = None,
      desiredCount: Option[Int] = None,
      pendingCount: Option[Int] = None,
      runningCount: Option[Int] = None,
      failedTasks: Option[Int] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      capacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      launchType: Option[String] = None,
      platformVersion: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      rolloutState: Option[String] = None,
      rolloutStateReason: Option[String] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(desiredCount)(_.desiredCount(_))
        .ifSome(pendingCount)(_.pendingCount(_))
        .ifSome(runningCount)(_.runningCount(_))
        .ifSome(failedTasks)(_.failedTasks(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(capacityProviderStrategy)(_.capacityProviderStrategy(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(rolloutState)(_.rolloutState(_))
        .ifSome(rolloutStateReason)(_.rolloutStateReason(_))
        .build

    def deploymentCircuitBreaker(
      enable: Option[Boolean] = None,
      rollback: Option[Boolean] = None
    ): DeploymentCircuitBreaker =
      DeploymentCircuitBreaker
        .builder
        .ifSome(enable)(_.enable(_))
        .ifSome(rollback)(_.rollback(_))
        .build

    def deploymentConfiguration(
      deploymentCircuitBreaker: Option[DeploymentCircuitBreaker] = None,
      maximumPercent: Option[Int] = None,
      minimumHealthyPercent: Option[Int] = None
    ): DeploymentConfiguration =
      DeploymentConfiguration
        .builder
        .ifSome(deploymentCircuitBreaker)(_.deploymentCircuitBreaker(_))
        .ifSome(maximumPercent)(_.maximumPercent(_))
        .ifSome(minimumHealthyPercent)(_.minimumHealthyPercent(_))
        .build

    def deploymentController(
      `type`: Option[String] = None
    ): DeploymentController =
      DeploymentController
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def deregisterContainerInstanceRequest(
      cluster: Option[String] = None,
      containerInstance: Option[String] = None,
      force: Option[Boolean] = None
    ): DeregisterContainerInstanceRequest =
      DeregisterContainerInstanceRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(containerInstance)(_.containerInstance(_))
        .ifSome(force)(_.force(_))
        .build

    def deregisterContainerInstanceResponse(
      containerInstance: Option[ContainerInstance] = None
    ): DeregisterContainerInstanceResponse =
      DeregisterContainerInstanceResponse
        .builder
        .ifSome(containerInstance)(_.containerInstance(_))
        .build

    def deregisterTaskDefinitionRequest(
      taskDefinition: Option[String] = None
    ): DeregisterTaskDefinitionRequest =
      DeregisterTaskDefinitionRequest
        .builder
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .build

    def deregisterTaskDefinitionResponse(
      taskDefinition: Option[TaskDefinition] = None
    ): DeregisterTaskDefinitionResponse =
      DeregisterTaskDefinitionResponse
        .builder
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .build

    def describeCapacityProvidersRequest(
      capacityProviders: Option[List[String]] = None,
      include: Option[List[CapacityProviderField]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeCapacityProvidersRequest =
      DescribeCapacityProvidersRequest
        .builder
        .ifSome(capacityProviders)(_.capacityProviders(_))
        .ifSome(include)(_.include(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeCapacityProvidersResponse(
      capacityProviders: Option[List[CapacityProvider]] = None,
      failures: Option[List[Failure]] = None,
      nextToken: Option[String] = None
    ): DescribeCapacityProvidersResponse =
      DescribeCapacityProvidersResponse
        .builder
        .ifSome(capacityProviders)(_.capacityProviders(_))
        .ifSome(failures)(_.failures(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClustersRequest(
      clusters: Option[List[String]] = None,
      include: Option[List[ClusterField]] = None
    ): DescribeClustersRequest =
      DescribeClustersRequest
        .builder
        .ifSome(clusters)(_.clusters(_))
        .ifSome(include)(_.include(_))
        .build

    def describeClustersResponse(
      clusters: Option[List[Cluster]] = None,
      failures: Option[List[Failure]] = None
    ): DescribeClustersResponse =
      DescribeClustersResponse
        .builder
        .ifSome(clusters)(_.clusters(_))
        .ifSome(failures)(_.failures(_))
        .build

    def describeContainerInstancesRequest(
      cluster: Option[String] = None,
      containerInstances: Option[List[String]] = None,
      include: Option[List[ContainerInstanceField]] = None
    ): DescribeContainerInstancesRequest =
      DescribeContainerInstancesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(containerInstances)(_.containerInstances(_))
        .ifSome(include)(_.include(_))
        .build

    def describeContainerInstancesResponse(
      containerInstances: Option[List[ContainerInstance]] = None,
      failures: Option[List[Failure]] = None
    ): DescribeContainerInstancesResponse =
      DescribeContainerInstancesResponse
        .builder
        .ifSome(containerInstances)(_.containerInstances(_))
        .ifSome(failures)(_.failures(_))
        .build

    def describeServicesRequest(
      cluster: Option[String] = None,
      services: Option[List[String]] = None,
      include: Option[List[ServiceField]] = None
    ): DescribeServicesRequest =
      DescribeServicesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(services)(_.services(_))
        .ifSome(include)(_.include(_))
        .build

    def describeServicesResponse(
      services: Option[List[Service]] = None,
      failures: Option[List[Failure]] = None
    ): DescribeServicesResponse =
      DescribeServicesResponse
        .builder
        .ifSome(services)(_.services(_))
        .ifSome(failures)(_.failures(_))
        .build

    def describeTaskDefinitionRequest(
      taskDefinition: Option[String] = None,
      include: Option[List[TaskDefinitionField]] = None
    ): DescribeTaskDefinitionRequest =
      DescribeTaskDefinitionRequest
        .builder
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(include)(_.include(_))
        .build

    def describeTaskDefinitionResponse(
      taskDefinition: Option[TaskDefinition] = None,
      tags: Option[List[Tag]] = None
    ): DescribeTaskDefinitionResponse =
      DescribeTaskDefinitionResponse
        .builder
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeTaskSetsRequest(
      cluster: Option[String] = None,
      service: Option[String] = None,
      taskSets: Option[List[String]] = None,
      include: Option[List[TaskSetField]] = None
    ): DescribeTaskSetsRequest =
      DescribeTaskSetsRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(service)(_.service(_))
        .ifSome(taskSets)(_.taskSets(_))
        .ifSome(include)(_.include(_))
        .build

    def describeTaskSetsResponse(
      taskSets: Option[List[TaskSet]] = None,
      failures: Option[List[Failure]] = None
    ): DescribeTaskSetsResponse =
      DescribeTaskSetsResponse
        .builder
        .ifSome(taskSets)(_.taskSets(_))
        .ifSome(failures)(_.failures(_))
        .build

    def describeTasksRequest(
      cluster: Option[String] = None,
      tasks: Option[List[String]] = None,
      include: Option[List[TaskField]] = None
    ): DescribeTasksRequest =
      DescribeTasksRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(tasks)(_.tasks(_))
        .ifSome(include)(_.include(_))
        .build

    def describeTasksResponse(
      tasks: Option[List[Task]] = None,
      failures: Option[List[Failure]] = None
    ): DescribeTasksResponse =
      DescribeTasksResponse
        .builder
        .ifSome(tasks)(_.tasks(_))
        .ifSome(failures)(_.failures(_))
        .build

    def device(
      hostPath: Option[String] = None,
      containerPath: Option[String] = None,
      permissions: Option[List[DeviceCgroupPermission]] = None
    ): Device =
      Device
        .builder
        .ifSome(hostPath)(_.hostPath(_))
        .ifSome(containerPath)(_.containerPath(_))
        .ifSome(permissions)(_.permissions(_))
        .build

    def discoverPollEndpointRequest(
      containerInstance: Option[String] = None,
      cluster: Option[String] = None
    ): DiscoverPollEndpointRequest =
      DiscoverPollEndpointRequest
        .builder
        .ifSome(containerInstance)(_.containerInstance(_))
        .ifSome(cluster)(_.cluster(_))
        .build

    def discoverPollEndpointResponse(
      endpoint: Option[String] = None,
      telemetryEndpoint: Option[String] = None
    ): DiscoverPollEndpointResponse =
      DiscoverPollEndpointResponse
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(telemetryEndpoint)(_.telemetryEndpoint(_))
        .build

    def dockerVolumeConfiguration(
      scope: Option[String] = None,
      autoprovision: Option[Boolean] = None,
      driver: Option[String] = None,
      driverOpts: Option[StringMap] = None,
      labels: Option[StringMap] = None
    ): DockerVolumeConfiguration =
      DockerVolumeConfiguration
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(autoprovision)(_.autoprovision(_))
        .ifSome(driver)(_.driver(_))
        .ifSome(driverOpts)(_.driverOpts(_))
        .ifSome(labels)(_.labels(_))
        .build

    def eFSAuthorizationConfig(
      accessPointId: Option[String] = None,
      iam: Option[String] = None
    ): EFSAuthorizationConfig =
      EFSAuthorizationConfig
        .builder
        .ifSome(accessPointId)(_.accessPointId(_))
        .ifSome(iam)(_.iam(_))
        .build

    def eFSVolumeConfiguration(
      fileSystemId: Option[String] = None,
      rootDirectory: Option[String] = None,
      transitEncryption: Option[String] = None,
      transitEncryptionPort: Option[Int] = None,
      authorizationConfig: Option[EFSAuthorizationConfig] = None
    ): EFSVolumeConfiguration =
      EFSVolumeConfiguration
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(rootDirectory)(_.rootDirectory(_))
        .ifSome(transitEncryption)(_.transitEncryption(_))
        .ifSome(transitEncryptionPort)(_.transitEncryptionPort(_))
        .ifSome(authorizationConfig)(_.authorizationConfig(_))
        .build

    def environmentFile(
      value: Option[String] = None,
      `type`: Option[String] = None
    ): EnvironmentFile =
      EnvironmentFile
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def ephemeralStorage(
      sizeInGiB: Option[Int] = None
    ): EphemeralStorage =
      EphemeralStorage
        .builder
        .ifSome(sizeInGiB)(_.sizeInGiB(_))
        .build

    def executeCommandConfiguration(
      kmsKeyId: Option[String] = None,
      logging: Option[String] = None,
      logConfiguration: Option[ExecuteCommandLogConfiguration] = None
    ): ExecuteCommandConfiguration =
      ExecuteCommandConfiguration
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(logConfiguration)(_.logConfiguration(_))
        .build

    def executeCommandLogConfiguration(
      cloudWatchLogGroupName: Option[String] = None,
      cloudWatchEncryptionEnabled: Option[Boolean] = None,
      s3BucketName: Option[String] = None,
      s3EncryptionEnabled: Option[Boolean] = None,
      s3KeyPrefix: Option[String] = None
    ): ExecuteCommandLogConfiguration =
      ExecuteCommandLogConfiguration
        .builder
        .ifSome(cloudWatchLogGroupName)(_.cloudWatchLogGroupName(_))
        .ifSome(cloudWatchEncryptionEnabled)(_.cloudWatchEncryptionEnabled(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3EncryptionEnabled)(_.s3EncryptionEnabled(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .build

    def executeCommandRequest(
      cluster: Option[String] = None,
      container: Option[String] = None,
      command: Option[String] = None,
      interactive: Option[Boolean] = None,
      task: Option[String] = None
    ): ExecuteCommandRequest =
      ExecuteCommandRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(container)(_.container(_))
        .ifSome(command)(_.command(_))
        .ifSome(interactive)(_.interactive(_))
        .ifSome(task)(_.task(_))
        .build

    def executeCommandResponse(
      clusterArn: Option[String] = None,
      containerArn: Option[String] = None,
      containerName: Option[String] = None,
      interactive: Option[Boolean] = None,
      session: Option[Session] = None,
      taskArn: Option[String] = None
    ): ExecuteCommandResponse =
      ExecuteCommandResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(containerArn)(_.containerArn(_))
        .ifSome(containerName)(_.containerName(_))
        .ifSome(interactive)(_.interactive(_))
        .ifSome(session)(_.session(_))
        .ifSome(taskArn)(_.taskArn(_))
        .build

    def fSxWindowsFileServerAuthorizationConfig(
      credentialsParameter: Option[String] = None,
      domain: Option[String] = None
    ): FSxWindowsFileServerAuthorizationConfig =
      FSxWindowsFileServerAuthorizationConfig
        .builder
        .ifSome(credentialsParameter)(_.credentialsParameter(_))
        .ifSome(domain)(_.domain(_))
        .build

    def fSxWindowsFileServerVolumeConfiguration(
      fileSystemId: Option[String] = None,
      rootDirectory: Option[String] = None,
      authorizationConfig: Option[FSxWindowsFileServerAuthorizationConfig] = None
    ): FSxWindowsFileServerVolumeConfiguration =
      FSxWindowsFileServerVolumeConfiguration
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(rootDirectory)(_.rootDirectory(_))
        .ifSome(authorizationConfig)(_.authorizationConfig(_))
        .build

    def failure(
      arn: Option[String] = None,
      reason: Option[String] = None,
      detail: Option[String] = None
    ): Failure =
      Failure
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(detail)(_.detail(_))
        .build

    def firelensConfiguration(
      `type`: Option[String] = None,
      options: Option[FirelensConfigurationOptionsMap] = None
    ): FirelensConfiguration =
      FirelensConfiguration
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(options)(_.options(_))
        .build

    def healthCheck(
      command: Option[List[String]] = None,
      interval: Option[Int] = None,
      timeout: Option[Int] = None,
      retries: Option[Int] = None,
      startPeriod: Option[Int] = None
    ): HealthCheck =
      HealthCheck
        .builder
        .ifSome(command)(_.command(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(retries)(_.retries(_))
        .ifSome(startPeriod)(_.startPeriod(_))
        .build

    def hostEntry(
      hostname: Option[String] = None,
      ipAddress: Option[String] = None
    ): HostEntry =
      HostEntry
        .builder
        .ifSome(hostname)(_.hostname(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .build

    def hostVolumeProperties(
      sourcePath: Option[String] = None
    ): HostVolumeProperties =
      HostVolumeProperties
        .builder
        .ifSome(sourcePath)(_.sourcePath(_))
        .build

    def inferenceAccelerator(
      deviceName: Option[String] = None,
      deviceType: Option[String] = None
    ): InferenceAccelerator =
      InferenceAccelerator
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceType)(_.deviceType(_))
        .build

    def inferenceAcceleratorOverride(
      deviceName: Option[String] = None,
      deviceType: Option[String] = None
    ): InferenceAcceleratorOverride =
      InferenceAcceleratorOverride
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceType)(_.deviceType(_))
        .build

    def invalidParameterException(

    ): InvalidParameterException =
      InvalidParameterException
        .builder

        .build

    def kernelCapabilities(
      add: Option[List[String]] = None,
      drop: Option[List[String]] = None
    ): KernelCapabilities =
      KernelCapabilities
        .builder
        .ifSome(add)(_.add(_))
        .ifSome(drop)(_.drop(_))
        .build

    def keyValuePair(
      name: Option[String] = None,
      value: Option[String] = None
    ): KeyValuePair =
      KeyValuePair
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def linuxParameters(
      capabilities: Option[KernelCapabilities] = None,
      devices: Option[List[Device]] = None,
      initProcessEnabled: Option[Boolean] = None,
      sharedMemorySize: Option[Int] = None,
      tmpfs: Option[List[Tmpfs]] = None,
      maxSwap: Option[Int] = None,
      swappiness: Option[Int] = None
    ): LinuxParameters =
      LinuxParameters
        .builder
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(devices)(_.devices(_))
        .ifSome(initProcessEnabled)(_.initProcessEnabled(_))
        .ifSome(sharedMemorySize)(_.sharedMemorySize(_))
        .ifSome(tmpfs)(_.tmpfs(_))
        .ifSome(maxSwap)(_.maxSwap(_))
        .ifSome(swappiness)(_.swappiness(_))
        .build

    def listAccountSettingsRequest(
      name: Option[String] = None,
      value: Option[String] = None,
      principalArn: Option[String] = None,
      effectiveSettings: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccountSettingsRequest =
      ListAccountSettingsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(principalArn)(_.principalArn(_))
        .ifSome(effectiveSettings)(_.effectiveSettings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAccountSettingsResponse(
      settings: Option[List[Setting]] = None,
      nextToken: Option[String] = None
    ): ListAccountSettingsResponse =
      ListAccountSettingsResponse
        .builder
        .ifSome(settings)(_.settings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAttributesRequest(
      cluster: Option[String] = None,
      targetType: Option[String] = None,
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAttributesRequest =
      ListAttributesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAttributesResponse(
      attributes: Option[List[Attribute]] = None,
      nextToken: Option[String] = None
    ): ListAttributesResponse =
      ListAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClustersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListClustersRequest =
      ListClustersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listClustersResponse(
      clusterArns: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListClustersResponse =
      ListClustersResponse
        .builder
        .ifSome(clusterArns)(_.clusterArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContainerInstancesRequest(
      cluster: Option[String] = None,
      filter: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      status: Option[String] = None
    ): ListContainerInstancesRequest =
      ListContainerInstancesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(status)(_.status(_))
        .build

    def listContainerInstancesResponse(
      containerInstanceArns: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListContainerInstancesResponse =
      ListContainerInstancesResponse
        .builder
        .ifSome(containerInstanceArns)(_.containerInstanceArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServicesRequest(
      cluster: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      launchType: Option[String] = None,
      schedulingStrategy: Option[String] = None
    ): ListServicesRequest =
      ListServicesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(schedulingStrategy)(_.schedulingStrategy(_))
        .build

    def listServicesResponse(
      serviceArns: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListServicesResponse =
      ListServicesResponse
        .builder
        .ifSome(serviceArns)(_.serviceArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listTaskDefinitionFamiliesRequest(
      familyPrefix: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTaskDefinitionFamiliesRequest =
      ListTaskDefinitionFamiliesRequest
        .builder
        .ifSome(familyPrefix)(_.familyPrefix(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTaskDefinitionFamiliesResponse(
      families: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListTaskDefinitionFamiliesResponse =
      ListTaskDefinitionFamiliesResponse
        .builder
        .ifSome(families)(_.families(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTaskDefinitionsRequest(
      familyPrefix: Option[String] = None,
      status: Option[String] = None,
      sort: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTaskDefinitionsRequest =
      ListTaskDefinitionsRequest
        .builder
        .ifSome(familyPrefix)(_.familyPrefix(_))
        .ifSome(status)(_.status(_))
        .ifSome(sort)(_.sort(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTaskDefinitionsResponse(
      taskDefinitionArns: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListTaskDefinitionsResponse =
      ListTaskDefinitionsResponse
        .builder
        .ifSome(taskDefinitionArns)(_.taskDefinitionArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTasksRequest(
      cluster: Option[String] = None,
      containerInstance: Option[String] = None,
      family: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      startedBy: Option[String] = None,
      serviceName: Option[String] = None,
      desiredStatus: Option[String] = None,
      launchType: Option[String] = None
    ): ListTasksRequest =
      ListTasksRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(containerInstance)(_.containerInstance(_))
        .ifSome(family)(_.family(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(startedBy)(_.startedBy(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(desiredStatus)(_.desiredStatus(_))
        .ifSome(launchType)(_.launchType(_))
        .build

    def listTasksResponse(
      taskArns: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListTasksResponse =
      ListTasksResponse
        .builder
        .ifSome(taskArns)(_.taskArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loadBalancer(
      targetGroupArn: Option[String] = None,
      loadBalancerName: Option[String] = None,
      containerName: Option[String] = None,
      containerPort: Option[Int] = None
    ): LoadBalancer =
      LoadBalancer
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(containerName)(_.containerName(_))
        .ifSome(containerPort)(_.containerPort(_))
        .build

    def logConfiguration(
      logDriver: Option[String] = None,
      options: Option[LogConfigurationOptionsMap] = None,
      secretOptions: Option[List[Secret]] = None
    ): LogConfiguration =
      LogConfiguration
        .builder
        .ifSome(logDriver)(_.logDriver(_))
        .ifSome(options)(_.options(_))
        .ifSome(secretOptions)(_.secretOptions(_))
        .build

    def managedAgent(
      lastStartedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      reason: Option[String] = None,
      lastStatus: Option[String] = None
    ): ManagedAgent =
      ManagedAgent
        .builder
        .ifSome(lastStartedAt)(_.lastStartedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(lastStatus)(_.lastStatus(_))
        .build

    def managedAgentStateChange(
      containerName: Option[String] = None,
      managedAgentName: Option[String] = None,
      status: Option[String] = None,
      reason: Option[String] = None
    ): ManagedAgentStateChange =
      ManagedAgentStateChange
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(managedAgentName)(_.managedAgentName(_))
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .build

    def managedScaling(
      status: Option[String] = None,
      targetCapacity: Option[Int] = None,
      minimumScalingStepSize: Option[Int] = None,
      maximumScalingStepSize: Option[Int] = None,
      instanceWarmupPeriod: Option[Int] = None
    ): ManagedScaling =
      ManagedScaling
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(targetCapacity)(_.targetCapacity(_))
        .ifSome(minimumScalingStepSize)(_.minimumScalingStepSize(_))
        .ifSome(maximumScalingStepSize)(_.maximumScalingStepSize(_))
        .ifSome(instanceWarmupPeriod)(_.instanceWarmupPeriod(_))
        .build

    def missingVersionException(

    ): MissingVersionException =
      MissingVersionException
        .builder

        .build

    def mountPoint(
      sourceVolume: Option[String] = None,
      containerPath: Option[String] = None,
      readOnly: Option[Boolean] = None
    ): MountPoint =
      MountPoint
        .builder
        .ifSome(sourceVolume)(_.sourceVolume(_))
        .ifSome(containerPath)(_.containerPath(_))
        .ifSome(readOnly)(_.readOnly(_))
        .build

    def networkBinding(
      bindIP: Option[String] = None,
      containerPort: Option[Int] = None,
      hostPort: Option[Int] = None,
      protocol: Option[String] = None
    ): NetworkBinding =
      NetworkBinding
        .builder
        .ifSome(bindIP)(_.bindIP(_))
        .ifSome(containerPort)(_.containerPort(_))
        .ifSome(hostPort)(_.hostPort(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def networkConfiguration(
      awsvpcConfiguration: Option[AwsVpcConfiguration] = None
    ): NetworkConfiguration =
      NetworkConfiguration
        .builder
        .ifSome(awsvpcConfiguration)(_.awsvpcConfiguration(_))
        .build

    def networkInterface(
      attachmentId: Option[String] = None,
      privateIpv4Address: Option[String] = None,
      ipv6Address: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(privateIpv4Address)(_.privateIpv4Address(_))
        .ifSome(ipv6Address)(_.ipv6Address(_))
        .build

    def noUpdateAvailableException(

    ): NoUpdateAvailableException =
      NoUpdateAvailableException
        .builder

        .build

    def placementConstraint(
      `type`: Option[String] = None,
      expression: Option[String] = None
    ): PlacementConstraint =
      PlacementConstraint
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(expression)(_.expression(_))
        .build

    def placementStrategy(
      `type`: Option[String] = None,
      field: Option[String] = None
    ): PlacementStrategy =
      PlacementStrategy
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(field)(_.field(_))
        .build

    def platformDevice(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): PlatformDevice =
      PlatformDevice
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def platformTaskDefinitionIncompatibilityException(

    ): PlatformTaskDefinitionIncompatibilityException =
      PlatformTaskDefinitionIncompatibilityException
        .builder

        .build

    def platformUnknownException(

    ): PlatformUnknownException =
      PlatformUnknownException
        .builder

        .build

    def portMapping(
      containerPort: Option[Int] = None,
      hostPort: Option[Int] = None,
      protocol: Option[String] = None
    ): PortMapping =
      PortMapping
        .builder
        .ifSome(containerPort)(_.containerPort(_))
        .ifSome(hostPort)(_.hostPort(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def proxyConfiguration(
      `type`: Option[String] = None,
      containerName: Option[String] = None,
      properties: Option[List[KeyValuePair]] = None
    ): ProxyConfiguration =
      ProxyConfiguration
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(containerName)(_.containerName(_))
        .ifSome(properties)(_.properties(_))
        .build

    def putAccountSettingDefaultRequest(
      name: Option[String] = None,
      value: Option[String] = None
    ): PutAccountSettingDefaultRequest =
      PutAccountSettingDefaultRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def putAccountSettingDefaultResponse(
      setting: Option[Setting] = None
    ): PutAccountSettingDefaultResponse =
      PutAccountSettingDefaultResponse
        .builder
        .ifSome(setting)(_.setting(_))
        .build

    def putAccountSettingRequest(
      name: Option[String] = None,
      value: Option[String] = None,
      principalArn: Option[String] = None
    ): PutAccountSettingRequest =
      PutAccountSettingRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(principalArn)(_.principalArn(_))
        .build

    def putAccountSettingResponse(
      setting: Option[Setting] = None
    ): PutAccountSettingResponse =
      PutAccountSettingResponse
        .builder
        .ifSome(setting)(_.setting(_))
        .build

    def putAttributesRequest(
      cluster: Option[String] = None,
      attributes: Option[List[Attribute]] = None
    ): PutAttributesRequest =
      PutAttributesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def putAttributesResponse(
      attributes: Option[List[Attribute]] = None
    ): PutAttributesResponse =
      PutAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def putClusterCapacityProvidersRequest(
      cluster: Option[String] = None,
      capacityProviders: Option[List[String]] = None,
      defaultCapacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None
    ): PutClusterCapacityProvidersRequest =
      PutClusterCapacityProvidersRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(capacityProviders)(_.capacityProviders(_))
        .ifSome(defaultCapacityProviderStrategy)(_.defaultCapacityProviderStrategy(_))
        .build

    def putClusterCapacityProvidersResponse(
      cluster: Option[Cluster] = None
    ): PutClusterCapacityProvidersResponse =
      PutClusterCapacityProvidersResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def registerContainerInstanceRequest(
      cluster: Option[String] = None,
      instanceIdentityDocument: Option[String] = None,
      instanceIdentityDocumentSignature: Option[String] = None,
      totalResources: Option[List[Resource]] = None,
      versionInfo: Option[VersionInfo] = None,
      containerInstanceArn: Option[String] = None,
      attributes: Option[List[Attribute]] = None,
      platformDevices: Option[List[PlatformDevice]] = None,
      tags: Option[List[Tag]] = None
    ): RegisterContainerInstanceRequest =
      RegisterContainerInstanceRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(instanceIdentityDocument)(_.instanceIdentityDocument(_))
        .ifSome(instanceIdentityDocumentSignature)(_.instanceIdentityDocumentSignature(_))
        .ifSome(totalResources)(_.totalResources(_))
        .ifSome(versionInfo)(_.versionInfo(_))
        .ifSome(containerInstanceArn)(_.containerInstanceArn(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(platformDevices)(_.platformDevices(_))
        .ifSome(tags)(_.tags(_))
        .build

    def registerContainerInstanceResponse(
      containerInstance: Option[ContainerInstance] = None
    ): RegisterContainerInstanceResponse =
      RegisterContainerInstanceResponse
        .builder
        .ifSome(containerInstance)(_.containerInstance(_))
        .build

    def registerTaskDefinitionRequest(
      family: Option[String] = None,
      taskRoleArn: Option[String] = None,
      executionRoleArn: Option[String] = None,
      networkMode: Option[String] = None,
      containerDefinitions: Option[List[ContainerDefinition]] = None,
      volumes: Option[List[Volume]] = None,
      placementConstraints: Option[List[TaskDefinitionPlacementConstraint]] = None,
      requiresCompatibilities: Option[List[Compatibility]] = None,
      cpu: Option[String] = None,
      memory: Option[String] = None,
      tags: Option[List[Tag]] = None,
      pidMode: Option[String] = None,
      ipcMode: Option[String] = None,
      proxyConfiguration: Option[ProxyConfiguration] = None,
      inferenceAccelerators: Option[List[InferenceAccelerator]] = None,
      ephemeralStorage: Option[EphemeralStorage] = None
    ): RegisterTaskDefinitionRequest =
      RegisterTaskDefinitionRequest
        .builder
        .ifSome(family)(_.family(_))
        .ifSome(taskRoleArn)(_.taskRoleArn(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(networkMode)(_.networkMode(_))
        .ifSome(containerDefinitions)(_.containerDefinitions(_))
        .ifSome(volumes)(_.volumes(_))
        .ifSome(placementConstraints)(_.placementConstraints(_))
        .ifSome(requiresCompatibilities)(_.requiresCompatibilities(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(pidMode)(_.pidMode(_))
        .ifSome(ipcMode)(_.ipcMode(_))
        .ifSome(proxyConfiguration)(_.proxyConfiguration(_))
        .ifSome(inferenceAccelerators)(_.inferenceAccelerators(_))
        .ifSome(ephemeralStorage)(_.ephemeralStorage(_))
        .build

    def registerTaskDefinitionResponse(
      taskDefinition: Option[TaskDefinition] = None,
      tags: Option[List[Tag]] = None
    ): RegisterTaskDefinitionResponse =
      RegisterTaskDefinitionResponse
        .builder
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def repositoryCredentials(
      credentialsParameter: Option[String] = None
    ): RepositoryCredentials =
      RepositoryCredentials
        .builder
        .ifSome(credentialsParameter)(_.credentialsParameter(_))
        .build

    def resource(
      name: Option[String] = None,
      `type`: Option[String] = None,
      doubleValue: Option[Double] = None,
      longValue: Option[Long] = None,
      integerValue: Option[Int] = None,
      stringSetValue: Option[List[String]] = None
    ): Resource =
      Resource
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(longValue)(_.longValue(_))
        .ifSome(integerValue)(_.integerValue(_))
        .ifSome(stringSetValue)(_.stringSetValue(_))
        .build

    def resourceInUseException(

    ): ResourceInUseException =
      ResourceInUseException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def resourceRequirement(
      value: Option[String] = None,
      `type`: Option[String] = None
    ): ResourceRequirement =
      ResourceRequirement
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def runTaskRequest(
      capacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      cluster: Option[String] = None,
      count: Option[Int] = None,
      enableECSManagedTags: Option[Boolean] = None,
      enableExecuteCommand: Option[Boolean] = None,
      group: Option[String] = None,
      launchType: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      overrides: Option[TaskOverride] = None,
      placementConstraints: Option[List[PlacementConstraint]] = None,
      placementStrategy: Option[List[PlacementStrategy]] = None,
      platformVersion: Option[String] = None,
      propagateTags: Option[String] = None,
      referenceId: Option[String] = None,
      startedBy: Option[String] = None,
      tags: Option[List[Tag]] = None,
      taskDefinition: Option[String] = None
    ): RunTaskRequest =
      RunTaskRequest
        .builder
        .ifSome(capacityProviderStrategy)(_.capacityProviderStrategy(_))
        .ifSome(cluster)(_.cluster(_))
        .ifSome(count)(_.count(_))
        .ifSome(enableECSManagedTags)(_.enableECSManagedTags(_))
        .ifSome(enableExecuteCommand)(_.enableExecuteCommand(_))
        .ifSome(group)(_.group(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(overrides)(_.overrides(_))
        .ifSome(placementConstraints)(_.placementConstraints(_))
        .ifSome(placementStrategy)(_.placementStrategy(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(referenceId)(_.referenceId(_))
        .ifSome(startedBy)(_.startedBy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .build

    def runTaskResponse(
      tasks: Option[List[Task]] = None,
      failures: Option[List[Failure]] = None
    ): RunTaskResponse =
      RunTaskResponse
        .builder
        .ifSome(tasks)(_.tasks(_))
        .ifSome(failures)(_.failures(_))
        .build

    def scale(
      value: Option[Double] = None,
      unit: Option[String] = None
    ): Scale =
      Scale
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(unit)(_.unit(_))
        .build

    def secret(
      name: Option[String] = None,
      valueFrom: Option[String] = None
    ): Secret =
      Secret
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(valueFrom)(_.valueFrom(_))
        .build

    def serverException(
      message: Option[String] = None
    ): ServerException =
      ServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def service(
      serviceArn: Option[String] = None,
      serviceName: Option[String] = None,
      clusterArn: Option[String] = None,
      loadBalancers: Option[List[LoadBalancer]] = None,
      serviceRegistries: Option[List[ServiceRegistry]] = None,
      status: Option[String] = None,
      desiredCount: Option[Int] = None,
      runningCount: Option[Int] = None,
      pendingCount: Option[Int] = None,
      launchType: Option[String] = None,
      capacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      platformVersion: Option[String] = None,
      taskDefinition: Option[String] = None,
      deploymentConfiguration: Option[DeploymentConfiguration] = None,
      taskSets: Option[List[TaskSet]] = None,
      deployments: Option[List[Deployment]] = None,
      roleArn: Option[String] = None,
      events: Option[List[ServiceEvent]] = None,
      createdAt: Option[Timestamp] = None,
      placementConstraints: Option[List[PlacementConstraint]] = None,
      placementStrategy: Option[List[PlacementStrategy]] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      healthCheckGracePeriodSeconds: Option[Int] = None,
      schedulingStrategy: Option[String] = None,
      deploymentController: Option[DeploymentController] = None,
      tags: Option[List[Tag]] = None,
      createdBy: Option[String] = None,
      enableECSManagedTags: Option[Boolean] = None,
      propagateTags: Option[String] = None,
      enableExecuteCommand: Option[Boolean] = None
    ): Service =
      Service
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .ifSome(serviceRegistries)(_.serviceRegistries(_))
        .ifSome(status)(_.status(_))
        .ifSome(desiredCount)(_.desiredCount(_))
        .ifSome(runningCount)(_.runningCount(_))
        .ifSome(pendingCount)(_.pendingCount(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(capacityProviderStrategy)(_.capacityProviderStrategy(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(deploymentConfiguration)(_.deploymentConfiguration(_))
        .ifSome(taskSets)(_.taskSets(_))
        .ifSome(deployments)(_.deployments(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(events)(_.events(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(placementConstraints)(_.placementConstraints(_))
        .ifSome(placementStrategy)(_.placementStrategy(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(healthCheckGracePeriodSeconds)(_.healthCheckGracePeriodSeconds(_))
        .ifSome(schedulingStrategy)(_.schedulingStrategy(_))
        .ifSome(deploymentController)(_.deploymentController(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(enableECSManagedTags)(_.enableECSManagedTags(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(enableExecuteCommand)(_.enableExecuteCommand(_))
        .build

    def serviceEvent(
      id: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      message: Option[String] = None
    ): ServiceEvent =
      ServiceEvent
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(message)(_.message(_))
        .build

    def serviceNotActiveException(

    ): ServiceNotActiveException =
      ServiceNotActiveException
        .builder

        .build

    def serviceNotFoundException(

    ): ServiceNotFoundException =
      ServiceNotFoundException
        .builder

        .build

    def serviceRegistry(
      registryArn: Option[String] = None,
      port: Option[Int] = None,
      containerName: Option[String] = None,
      containerPort: Option[Int] = None
    ): ServiceRegistry =
      ServiceRegistry
        .builder
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(port)(_.port(_))
        .ifSome(containerName)(_.containerName(_))
        .ifSome(containerPort)(_.containerPort(_))
        .build

    def session(
      sessionId: Option[String] = None,
      streamUrl: Option[String] = None,
      tokenValue: Option[String] = None
    ): Session =
      Session
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(streamUrl)(_.streamUrl(_))
        .ifSome(tokenValue)(_.tokenValue(_))
        .build

    def setting(
      name: Option[String] = None,
      value: Option[String] = None,
      principalArn: Option[String] = None
    ): Setting =
      Setting
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(principalArn)(_.principalArn(_))
        .build

    def startTaskRequest(
      cluster: Option[String] = None,
      containerInstances: Option[List[String]] = None,
      enableECSManagedTags: Option[Boolean] = None,
      enableExecuteCommand: Option[Boolean] = None,
      group: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      overrides: Option[TaskOverride] = None,
      propagateTags: Option[String] = None,
      referenceId: Option[String] = None,
      startedBy: Option[String] = None,
      tags: Option[List[Tag]] = None,
      taskDefinition: Option[String] = None
    ): StartTaskRequest =
      StartTaskRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(containerInstances)(_.containerInstances(_))
        .ifSome(enableECSManagedTags)(_.enableECSManagedTags(_))
        .ifSome(enableExecuteCommand)(_.enableExecuteCommand(_))
        .ifSome(group)(_.group(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(overrides)(_.overrides(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(referenceId)(_.referenceId(_))
        .ifSome(startedBy)(_.startedBy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .build

    def startTaskResponse(
      tasks: Option[List[Task]] = None,
      failures: Option[List[Failure]] = None
    ): StartTaskResponse =
      StartTaskResponse
        .builder
        .ifSome(tasks)(_.tasks(_))
        .ifSome(failures)(_.failures(_))
        .build

    def stopTaskRequest(
      cluster: Option[String] = None,
      task: Option[String] = None,
      reason: Option[String] = None
    ): StopTaskRequest =
      StopTaskRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(task)(_.task(_))
        .ifSome(reason)(_.reason(_))
        .build

    def stopTaskResponse(
      task: Option[Task] = None
    ): StopTaskResponse =
      StopTaskResponse
        .builder
        .ifSome(task)(_.task(_))
        .build

    def submitAttachmentStateChangesRequest(
      cluster: Option[String] = None,
      attachments: Option[List[AttachmentStateChange]] = None
    ): SubmitAttachmentStateChangesRequest =
      SubmitAttachmentStateChangesRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(attachments)(_.attachments(_))
        .build

    def submitAttachmentStateChangesResponse(
      acknowledgment: Option[String] = None
    ): SubmitAttachmentStateChangesResponse =
      SubmitAttachmentStateChangesResponse
        .builder
        .ifSome(acknowledgment)(_.acknowledgment(_))
        .build

    def submitContainerStateChangeRequest(
      cluster: Option[String] = None,
      task: Option[String] = None,
      containerName: Option[String] = None,
      runtimeId: Option[String] = None,
      status: Option[String] = None,
      exitCode: Option[Int] = None,
      reason: Option[String] = None,
      networkBindings: Option[List[NetworkBinding]] = None
    ): SubmitContainerStateChangeRequest =
      SubmitContainerStateChangeRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(task)(_.task(_))
        .ifSome(containerName)(_.containerName(_))
        .ifSome(runtimeId)(_.runtimeId(_))
        .ifSome(status)(_.status(_))
        .ifSome(exitCode)(_.exitCode(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(networkBindings)(_.networkBindings(_))
        .build

    def submitContainerStateChangeResponse(
      acknowledgment: Option[String] = None
    ): SubmitContainerStateChangeResponse =
      SubmitContainerStateChangeResponse
        .builder
        .ifSome(acknowledgment)(_.acknowledgment(_))
        .build

    def submitTaskStateChangeRequest(
      cluster: Option[String] = None,
      task: Option[String] = None,
      status: Option[String] = None,
      reason: Option[String] = None,
      containers: Option[List[ContainerStateChange]] = None,
      attachments: Option[List[AttachmentStateChange]] = None,
      managedAgents: Option[List[ManagedAgentStateChange]] = None,
      pullStartedAt: Option[Timestamp] = None,
      pullStoppedAt: Option[Timestamp] = None,
      executionStoppedAt: Option[Timestamp] = None
    ): SubmitTaskStateChangeRequest =
      SubmitTaskStateChangeRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(task)(_.task(_))
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(containers)(_.containers(_))
        .ifSome(attachments)(_.attachments(_))
        .ifSome(managedAgents)(_.managedAgents(_))
        .ifSome(pullStartedAt)(_.pullStartedAt(_))
        .ifSome(pullStoppedAt)(_.pullStoppedAt(_))
        .ifSome(executionStoppedAt)(_.executionStoppedAt(_))
        .build

    def submitTaskStateChangeResponse(
      acknowledgment: Option[String] = None
    ): SubmitTaskStateChangeResponse =
      SubmitTaskStateChangeResponse
        .builder
        .ifSome(acknowledgment)(_.acknowledgment(_))
        .build

    def systemControl(
      namespace: Option[String] = None,
      value: Option[String] = None
    ): SystemControl =
      SystemControl
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(value)(_.value(_))
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
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def targetNotConnectedException(

    ): TargetNotConnectedException =
      TargetNotConnectedException
        .builder

        .build

    def targetNotFoundException(

    ): TargetNotFoundException =
      TargetNotFoundException
        .builder

        .build

    def task(
      attachments: Option[List[Attachment]] = None,
      attributes: Option[List[Attribute]] = None,
      availabilityZone: Option[String] = None,
      capacityProviderName: Option[String] = None,
      clusterArn: Option[String] = None,
      connectivity: Option[String] = None,
      connectivityAt: Option[Timestamp] = None,
      containerInstanceArn: Option[String] = None,
      containers: Option[List[Container]] = None,
      cpu: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      desiredStatus: Option[String] = None,
      enableExecuteCommand: Option[Boolean] = None,
      executionStoppedAt: Option[Timestamp] = None,
      group: Option[String] = None,
      healthStatus: Option[String] = None,
      inferenceAccelerators: Option[List[InferenceAccelerator]] = None,
      lastStatus: Option[String] = None,
      launchType: Option[String] = None,
      memory: Option[String] = None,
      overrides: Option[TaskOverride] = None,
      platformVersion: Option[String] = None,
      pullStartedAt: Option[Timestamp] = None,
      pullStoppedAt: Option[Timestamp] = None,
      startedAt: Option[Timestamp] = None,
      startedBy: Option[String] = None,
      stopCode: Option[String] = None,
      stoppedAt: Option[Timestamp] = None,
      stoppedReason: Option[String] = None,
      stoppingAt: Option[Timestamp] = None,
      tags: Option[List[Tag]] = None,
      taskArn: Option[String] = None,
      taskDefinitionArn: Option[String] = None,
      version: Option[Long] = None,
      ephemeralStorage: Option[EphemeralStorage] = None
    ): Task =
      Task
        .builder
        .ifSome(attachments)(_.attachments(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(capacityProviderName)(_.capacityProviderName(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(connectivity)(_.connectivity(_))
        .ifSome(connectivityAt)(_.connectivityAt(_))
        .ifSome(containerInstanceArn)(_.containerInstanceArn(_))
        .ifSome(containers)(_.containers(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(desiredStatus)(_.desiredStatus(_))
        .ifSome(enableExecuteCommand)(_.enableExecuteCommand(_))
        .ifSome(executionStoppedAt)(_.executionStoppedAt(_))
        .ifSome(group)(_.group(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(inferenceAccelerators)(_.inferenceAccelerators(_))
        .ifSome(lastStatus)(_.lastStatus(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(overrides)(_.overrides(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(pullStartedAt)(_.pullStartedAt(_))
        .ifSome(pullStoppedAt)(_.pullStoppedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(startedBy)(_.startedBy(_))
        .ifSome(stopCode)(_.stopCode(_))
        .ifSome(stoppedAt)(_.stoppedAt(_))
        .ifSome(stoppedReason)(_.stoppedReason(_))
        .ifSome(stoppingAt)(_.stoppingAt(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(taskDefinitionArn)(_.taskDefinitionArn(_))
        .ifSome(version)(_.version(_))
        .ifSome(ephemeralStorage)(_.ephemeralStorage(_))
        .build

    def taskDefinition(
      taskDefinitionArn: Option[String] = None,
      containerDefinitions: Option[List[ContainerDefinition]] = None,
      family: Option[String] = None,
      taskRoleArn: Option[String] = None,
      executionRoleArn: Option[String] = None,
      networkMode: Option[String] = None,
      revision: Option[Int] = None,
      volumes: Option[List[Volume]] = None,
      status: Option[String] = None,
      requiresAttributes: Option[List[Attribute]] = None,
      placementConstraints: Option[List[TaskDefinitionPlacementConstraint]] = None,
      compatibilities: Option[List[Compatibility]] = None,
      requiresCompatibilities: Option[List[Compatibility]] = None,
      cpu: Option[String] = None,
      memory: Option[String] = None,
      inferenceAccelerators: Option[List[InferenceAccelerator]] = None,
      pidMode: Option[String] = None,
      ipcMode: Option[String] = None,
      proxyConfiguration: Option[ProxyConfiguration] = None,
      registeredAt: Option[Timestamp] = None,
      deregisteredAt: Option[Timestamp] = None,
      registeredBy: Option[String] = None,
      ephemeralStorage: Option[EphemeralStorage] = None
    ): TaskDefinition =
      TaskDefinition
        .builder
        .ifSome(taskDefinitionArn)(_.taskDefinitionArn(_))
        .ifSome(containerDefinitions)(_.containerDefinitions(_))
        .ifSome(family)(_.family(_))
        .ifSome(taskRoleArn)(_.taskRoleArn(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(networkMode)(_.networkMode(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(volumes)(_.volumes(_))
        .ifSome(status)(_.status(_))
        .ifSome(requiresAttributes)(_.requiresAttributes(_))
        .ifSome(placementConstraints)(_.placementConstraints(_))
        .ifSome(compatibilities)(_.compatibilities(_))
        .ifSome(requiresCompatibilities)(_.requiresCompatibilities(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(inferenceAccelerators)(_.inferenceAccelerators(_))
        .ifSome(pidMode)(_.pidMode(_))
        .ifSome(ipcMode)(_.ipcMode(_))
        .ifSome(proxyConfiguration)(_.proxyConfiguration(_))
        .ifSome(registeredAt)(_.registeredAt(_))
        .ifSome(deregisteredAt)(_.deregisteredAt(_))
        .ifSome(registeredBy)(_.registeredBy(_))
        .ifSome(ephemeralStorage)(_.ephemeralStorage(_))
        .build

    def taskDefinitionPlacementConstraint(
      `type`: Option[String] = None,
      expression: Option[String] = None
    ): TaskDefinitionPlacementConstraint =
      TaskDefinitionPlacementConstraint
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(expression)(_.expression(_))
        .build

    def taskOverride(
      containerOverrides: Option[List[ContainerOverride]] = None,
      cpu: Option[String] = None,
      inferenceAcceleratorOverrides: Option[List[InferenceAcceleratorOverride]] = None,
      executionRoleArn: Option[String] = None,
      memory: Option[String] = None,
      taskRoleArn: Option[String] = None,
      ephemeralStorage: Option[EphemeralStorage] = None
    ): TaskOverride =
      TaskOverride
        .builder
        .ifSome(containerOverrides)(_.containerOverrides(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(inferenceAcceleratorOverrides)(_.inferenceAcceleratorOverrides(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(taskRoleArn)(_.taskRoleArn(_))
        .ifSome(ephemeralStorage)(_.ephemeralStorage(_))
        .build

    def taskSet(
      id: Option[String] = None,
      taskSetArn: Option[String] = None,
      serviceArn: Option[String] = None,
      clusterArn: Option[String] = None,
      startedBy: Option[String] = None,
      externalId: Option[String] = None,
      status: Option[String] = None,
      taskDefinition: Option[String] = None,
      computedDesiredCount: Option[Int] = None,
      pendingCount: Option[Int] = None,
      runningCount: Option[Int] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      launchType: Option[String] = None,
      capacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      platformVersion: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      loadBalancers: Option[List[LoadBalancer]] = None,
      serviceRegistries: Option[List[ServiceRegistry]] = None,
      scale: Option[Scale] = None,
      stabilityStatus: Option[String] = None,
      stabilityStatusAt: Option[Timestamp] = None,
      tags: Option[List[Tag]] = None
    ): TaskSet =
      TaskSet
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(taskSetArn)(_.taskSetArn(_))
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(startedBy)(_.startedBy(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(status)(_.status(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(computedDesiredCount)(_.computedDesiredCount(_))
        .ifSome(pendingCount)(_.pendingCount(_))
        .ifSome(runningCount)(_.runningCount(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(capacityProviderStrategy)(_.capacityProviderStrategy(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .ifSome(serviceRegistries)(_.serviceRegistries(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(stabilityStatus)(_.stabilityStatus(_))
        .ifSome(stabilityStatusAt)(_.stabilityStatusAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def taskSetNotFoundException(

    ): TaskSetNotFoundException =
      TaskSetNotFoundException
        .builder

        .build

    def tmpfs(
      containerPath: Option[String] = None,
      size: Option[Int] = None,
      mountOptions: Option[List[String]] = None
    ): Tmpfs =
      Tmpfs
        .builder
        .ifSome(containerPath)(_.containerPath(_))
        .ifSome(size)(_.size(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .build

    def ulimit(
      name: Option[String] = None,
      softLimit: Option[Int] = None,
      hardLimit: Option[Int] = None
    ): Ulimit =
      Ulimit
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(softLimit)(_.softLimit(_))
        .ifSome(hardLimit)(_.hardLimit(_))
        .build

    def unsupportedFeatureException(

    ): UnsupportedFeatureException =
      UnsupportedFeatureException
        .builder

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

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateCapacityProviderRequest(
      name: Option[String] = None,
      autoScalingGroupProvider: Option[AutoScalingGroupProviderUpdate] = None
    ): UpdateCapacityProviderRequest =
      UpdateCapacityProviderRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(autoScalingGroupProvider)(_.autoScalingGroupProvider(_))
        .build

    def updateCapacityProviderResponse(
      capacityProvider: Option[CapacityProvider] = None
    ): UpdateCapacityProviderResponse =
      UpdateCapacityProviderResponse
        .builder
        .ifSome(capacityProvider)(_.capacityProvider(_))
        .build

    def updateClusterRequest(
      cluster: Option[String] = None,
      settings: Option[List[ClusterSetting]] = None,
      configuration: Option[ClusterConfiguration] = None
    ): UpdateClusterRequest =
      UpdateClusterRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def updateClusterResponse(
      cluster: Option[Cluster] = None
    ): UpdateClusterResponse =
      UpdateClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def updateClusterSettingsRequest(
      cluster: Option[String] = None,
      settings: Option[List[ClusterSetting]] = None
    ): UpdateClusterSettingsRequest =
      UpdateClusterSettingsRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(settings)(_.settings(_))
        .build

    def updateClusterSettingsResponse(
      cluster: Option[Cluster] = None
    ): UpdateClusterSettingsResponse =
      UpdateClusterSettingsResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def updateContainerAgentRequest(
      cluster: Option[String] = None,
      containerInstance: Option[String] = None
    ): UpdateContainerAgentRequest =
      UpdateContainerAgentRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(containerInstance)(_.containerInstance(_))
        .build

    def updateContainerAgentResponse(
      containerInstance: Option[ContainerInstance] = None
    ): UpdateContainerAgentResponse =
      UpdateContainerAgentResponse
        .builder
        .ifSome(containerInstance)(_.containerInstance(_))
        .build

    def updateContainerInstancesStateRequest(
      cluster: Option[String] = None,
      containerInstances: Option[List[String]] = None,
      status: Option[String] = None
    ): UpdateContainerInstancesStateRequest =
      UpdateContainerInstancesStateRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(containerInstances)(_.containerInstances(_))
        .ifSome(status)(_.status(_))
        .build

    def updateContainerInstancesStateResponse(
      containerInstances: Option[List[ContainerInstance]] = None,
      failures: Option[List[Failure]] = None
    ): UpdateContainerInstancesStateResponse =
      UpdateContainerInstancesStateResponse
        .builder
        .ifSome(containerInstances)(_.containerInstances(_))
        .ifSome(failures)(_.failures(_))
        .build

    def updateInProgressException(

    ): UpdateInProgressException =
      UpdateInProgressException
        .builder

        .build

    def updateServicePrimaryTaskSetRequest(
      cluster: Option[String] = None,
      service: Option[String] = None,
      primaryTaskSet: Option[String] = None
    ): UpdateServicePrimaryTaskSetRequest =
      UpdateServicePrimaryTaskSetRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(service)(_.service(_))
        .ifSome(primaryTaskSet)(_.primaryTaskSet(_))
        .build

    def updateServicePrimaryTaskSetResponse(
      taskSet: Option[TaskSet] = None
    ): UpdateServicePrimaryTaskSetResponse =
      UpdateServicePrimaryTaskSetResponse
        .builder
        .ifSome(taskSet)(_.taskSet(_))
        .build

    def updateServiceRequest(
      cluster: Option[String] = None,
      service: Option[String] = None,
      desiredCount: Option[Int] = None,
      taskDefinition: Option[String] = None,
      capacityProviderStrategy: Option[List[CapacityProviderStrategyItem]] = None,
      deploymentConfiguration: Option[DeploymentConfiguration] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      placementConstraints: Option[List[PlacementConstraint]] = None,
      placementStrategy: Option[List[PlacementStrategy]] = None,
      platformVersion: Option[String] = None,
      forceNewDeployment: Option[Boolean] = None,
      healthCheckGracePeriodSeconds: Option[Int] = None,
      enableExecuteCommand: Option[Boolean] = None
    ): UpdateServiceRequest =
      UpdateServiceRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(service)(_.service(_))
        .ifSome(desiredCount)(_.desiredCount(_))
        .ifSome(taskDefinition)(_.taskDefinition(_))
        .ifSome(capacityProviderStrategy)(_.capacityProviderStrategy(_))
        .ifSome(deploymentConfiguration)(_.deploymentConfiguration(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(placementConstraints)(_.placementConstraints(_))
        .ifSome(placementStrategy)(_.placementStrategy(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(forceNewDeployment)(_.forceNewDeployment(_))
        .ifSome(healthCheckGracePeriodSeconds)(_.healthCheckGracePeriodSeconds(_))
        .ifSome(enableExecuteCommand)(_.enableExecuteCommand(_))
        .build

    def updateServiceResponse(
      service: Option[Service] = None
    ): UpdateServiceResponse =
      UpdateServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .build

    def updateTaskSetRequest(
      cluster: Option[String] = None,
      service: Option[String] = None,
      taskSet: Option[String] = None,
      scale: Option[Scale] = None
    ): UpdateTaskSetRequest =
      UpdateTaskSetRequest
        .builder
        .ifSome(cluster)(_.cluster(_))
        .ifSome(service)(_.service(_))
        .ifSome(taskSet)(_.taskSet(_))
        .ifSome(scale)(_.scale(_))
        .build

    def updateTaskSetResponse(
      taskSet: Option[TaskSet] = None
    ): UpdateTaskSetResponse =
      UpdateTaskSetResponse
        .builder
        .ifSome(taskSet)(_.taskSet(_))
        .build

    def versionInfo(
      agentVersion: Option[String] = None,
      agentHash: Option[String] = None,
      dockerVersion: Option[String] = None
    ): VersionInfo =
      VersionInfo
        .builder
        .ifSome(agentVersion)(_.agentVersion(_))
        .ifSome(agentHash)(_.agentHash(_))
        .ifSome(dockerVersion)(_.dockerVersion(_))
        .build

    def volume(
      name: Option[String] = None,
      host: Option[HostVolumeProperties] = None,
      dockerVolumeConfiguration: Option[DockerVolumeConfiguration] = None,
      efsVolumeConfiguration: Option[EFSVolumeConfiguration] = None,
      fsxWindowsFileServerVolumeConfiguration: Option[FSxWindowsFileServerVolumeConfiguration] = None
    ): Volume =
      Volume
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(host)(_.host(_))
        .ifSome(dockerVolumeConfiguration)(_.dockerVolumeConfiguration(_))
        .ifSome(efsVolumeConfiguration)(_.efsVolumeConfiguration(_))
        .ifSome(fsxWindowsFileServerVolumeConfiguration)(_.fsxWindowsFileServerVolumeConfiguration(_))
        .build

    def volumeFrom(
      sourceContainer: Option[String] = None,
      readOnly: Option[Boolean] = None
    ): VolumeFrom =
      VolumeFrom
        .builder
        .ifSome(sourceContainer)(_.sourceContainer(_))
        .ifSome(readOnly)(_.readOnly(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
