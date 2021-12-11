package goober.hi

import goober.free.batch.BatchIO
import software.amazon.awssdk.services.batch.model._


object batch {
  import goober.free.{batch ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def arrayProperties(
      size: Option[Int] = None
    ): ArrayProperties =
      ArrayProperties
        .builder
        .ifSome(size)(_.size(_))
        .build

    def arrayPropertiesDetail(
      statusSummary: Option[ArrayJobStatusSummary] = None,
      size: Option[Int] = None,
      index: Option[Int] = None
    ): ArrayPropertiesDetail =
      ArrayPropertiesDetail
        .builder
        .ifSome(statusSummary)(_.statusSummary(_))
        .ifSome(size)(_.size(_))
        .ifSome(index)(_.index(_))
        .build

    def arrayPropertiesSummary(
      size: Option[Int] = None,
      index: Option[Int] = None
    ): ArrayPropertiesSummary =
      ArrayPropertiesSummary
        .builder
        .ifSome(size)(_.size(_))
        .ifSome(index)(_.index(_))
        .build

    def attemptContainerDetail(
      containerInstanceArn: Option[String] = None,
      taskArn: Option[String] = None,
      exitCode: Option[Int] = None,
      reason: Option[String] = None,
      logStreamName: Option[String] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None
    ): AttemptContainerDetail =
      AttemptContainerDetail
        .builder
        .ifSome(containerInstanceArn)(_.containerInstanceArn(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(exitCode)(_.exitCode(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .build

    def attemptDetail(
      container: Option[AttemptContainerDetail] = None,
      startedAt: Option[Long] = None,
      stoppedAt: Option[Long] = None,
      statusReason: Option[String] = None
    ): AttemptDetail =
      AttemptDetail
        .builder
        .ifSome(container)(_.container(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(stoppedAt)(_.stoppedAt(_))
        .ifSome(statusReason)(_.statusReason(_))
        .build

    def cancelJobRequest(
      jobId: Option[String] = None,
      reason: Option[String] = None
    ): CancelJobRequest =
      CancelJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(reason)(_.reason(_))
        .build

    def cancelJobResponse(

    ): CancelJobResponse =
      CancelJobResponse
        .builder

        .build

    def clientException(
      message: Option[String] = None
    ): ClientException =
      ClientException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def computeEnvironmentDetail(
      computeEnvironmentName: Option[String] = None,
      computeEnvironmentArn: Option[String] = None,
      ecsClusterArn: Option[String] = None,
      tags: Option[TagrisTagsMap] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      computeResources: Option[ComputeResource] = None,
      serviceRole: Option[String] = None
    ): ComputeEnvironmentDetail =
      ComputeEnvironmentDetail
        .builder
        .ifSome(computeEnvironmentName)(_.computeEnvironmentName(_))
        .ifSome(computeEnvironmentArn)(_.computeEnvironmentArn(_))
        .ifSome(ecsClusterArn)(_.ecsClusterArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(computeResources)(_.computeResources(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .build

    def computeEnvironmentOrder(
      order: Option[Int] = None,
      computeEnvironment: Option[String] = None
    ): ComputeEnvironmentOrder =
      ComputeEnvironmentOrder
        .builder
        .ifSome(order)(_.order(_))
        .ifSome(computeEnvironment)(_.computeEnvironment(_))
        .build

    def computeResource(
      `type`: Option[String] = None,
      allocationStrategy: Option[String] = None,
      minvCpus: Option[Int] = None,
      maxvCpus: Option[Int] = None,
      desiredvCpus: Option[Int] = None,
      instanceTypes: Option[List[String]] = None,
      imageId: Option[String] = None,
      subnets: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None,
      ec2KeyPair: Option[String] = None,
      instanceRole: Option[String] = None,
      tags: Option[TagsMap] = None,
      placementGroup: Option[String] = None,
      bidPercentage: Option[Int] = None,
      spotIamFleetRole: Option[String] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      ec2Configuration: Option[List[Ec2Configuration]] = None
    ): ComputeResource =
      ComputeResource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .ifSome(minvCpus)(_.minvCpus(_))
        .ifSome(maxvCpus)(_.maxvCpus(_))
        .ifSome(desiredvCpus)(_.desiredvCpus(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(ec2KeyPair)(_.ec2KeyPair(_))
        .ifSome(instanceRole)(_.instanceRole(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(placementGroup)(_.placementGroup(_))
        .ifSome(bidPercentage)(_.bidPercentage(_))
        .ifSome(spotIamFleetRole)(_.spotIamFleetRole(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(ec2Configuration)(_.ec2Configuration(_))
        .build

    def computeResourceUpdate(
      minvCpus: Option[Int] = None,
      maxvCpus: Option[Int] = None,
      desiredvCpus: Option[Int] = None,
      subnets: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None
    ): ComputeResourceUpdate =
      ComputeResourceUpdate
        .builder
        .ifSome(minvCpus)(_.minvCpus(_))
        .ifSome(maxvCpus)(_.maxvCpus(_))
        .ifSome(desiredvCpus)(_.desiredvCpus(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def containerDetail(
      image: Option[String] = None,
      vcpus: Option[Int] = None,
      memory: Option[Int] = None,
      command: Option[List[String]] = None,
      jobRoleArn: Option[String] = None,
      executionRoleArn: Option[String] = None,
      volumes: Option[List[Volume]] = None,
      environment: Option[List[KeyValuePair]] = None,
      mountPoints: Option[List[MountPoint]] = None,
      readonlyRootFilesystem: Option[Boolean] = None,
      ulimits: Option[List[Ulimit]] = None,
      privileged: Option[Boolean] = None,
      user: Option[String] = None,
      exitCode: Option[Int] = None,
      reason: Option[String] = None,
      containerInstanceArn: Option[String] = None,
      taskArn: Option[String] = None,
      logStreamName: Option[String] = None,
      instanceType: Option[String] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None,
      resourceRequirements: Option[List[ResourceRequirement]] = None,
      linuxParameters: Option[LinuxParameters] = None,
      logConfiguration: Option[LogConfiguration] = None,
      secrets: Option[List[Secret]] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      fargatePlatformConfiguration: Option[FargatePlatformConfiguration] = None
    ): ContainerDetail =
      ContainerDetail
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(vcpus)(_.vcpus(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(command)(_.command(_))
        .ifSome(jobRoleArn)(_.jobRoleArn(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(volumes)(_.volumes(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(mountPoints)(_.mountPoints(_))
        .ifSome(readonlyRootFilesystem)(_.readonlyRootFilesystem(_))
        .ifSome(ulimits)(_.ulimits(_))
        .ifSome(privileged)(_.privileged(_))
        .ifSome(user)(_.user(_))
        .ifSome(exitCode)(_.exitCode(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(containerInstanceArn)(_.containerInstanceArn(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(resourceRequirements)(_.resourceRequirements(_))
        .ifSome(linuxParameters)(_.linuxParameters(_))
        .ifSome(logConfiguration)(_.logConfiguration(_))
        .ifSome(secrets)(_.secrets(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(fargatePlatformConfiguration)(_.fargatePlatformConfiguration(_))
        .build

    def containerOverrides(
      vcpus: Option[Int] = None,
      memory: Option[Int] = None,
      command: Option[List[String]] = None,
      instanceType: Option[String] = None,
      environment: Option[List[KeyValuePair]] = None,
      resourceRequirements: Option[List[ResourceRequirement]] = None
    ): ContainerOverrides =
      ContainerOverrides
        .builder
        .ifSome(vcpus)(_.vcpus(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(command)(_.command(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(resourceRequirements)(_.resourceRequirements(_))
        .build

    def containerProperties(
      image: Option[String] = None,
      vcpus: Option[Int] = None,
      memory: Option[Int] = None,
      command: Option[List[String]] = None,
      jobRoleArn: Option[String] = None,
      executionRoleArn: Option[String] = None,
      volumes: Option[List[Volume]] = None,
      environment: Option[List[KeyValuePair]] = None,
      mountPoints: Option[List[MountPoint]] = None,
      readonlyRootFilesystem: Option[Boolean] = None,
      privileged: Option[Boolean] = None,
      ulimits: Option[List[Ulimit]] = None,
      user: Option[String] = None,
      instanceType: Option[String] = None,
      resourceRequirements: Option[List[ResourceRequirement]] = None,
      linuxParameters: Option[LinuxParameters] = None,
      logConfiguration: Option[LogConfiguration] = None,
      secrets: Option[List[Secret]] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      fargatePlatformConfiguration: Option[FargatePlatformConfiguration] = None
    ): ContainerProperties =
      ContainerProperties
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(vcpus)(_.vcpus(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(command)(_.command(_))
        .ifSome(jobRoleArn)(_.jobRoleArn(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(volumes)(_.volumes(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(mountPoints)(_.mountPoints(_))
        .ifSome(readonlyRootFilesystem)(_.readonlyRootFilesystem(_))
        .ifSome(privileged)(_.privileged(_))
        .ifSome(ulimits)(_.ulimits(_))
        .ifSome(user)(_.user(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(resourceRequirements)(_.resourceRequirements(_))
        .ifSome(linuxParameters)(_.linuxParameters(_))
        .ifSome(logConfiguration)(_.logConfiguration(_))
        .ifSome(secrets)(_.secrets(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(fargatePlatformConfiguration)(_.fargatePlatformConfiguration(_))
        .build

    def containerSummary(
      exitCode: Option[Int] = None,
      reason: Option[String] = None
    ): ContainerSummary =
      ContainerSummary
        .builder
        .ifSome(exitCode)(_.exitCode(_))
        .ifSome(reason)(_.reason(_))
        .build

    def createComputeEnvironmentRequest(
      computeEnvironmentName: Option[String] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      computeResources: Option[ComputeResource] = None,
      serviceRole: Option[String] = None,
      tags: Option[TagrisTagsMap] = None
    ): CreateComputeEnvironmentRequest =
      CreateComputeEnvironmentRequest
        .builder
        .ifSome(computeEnvironmentName)(_.computeEnvironmentName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(computeResources)(_.computeResources(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createComputeEnvironmentResponse(
      computeEnvironmentName: Option[String] = None,
      computeEnvironmentArn: Option[String] = None
    ): CreateComputeEnvironmentResponse =
      CreateComputeEnvironmentResponse
        .builder
        .ifSome(computeEnvironmentName)(_.computeEnvironmentName(_))
        .ifSome(computeEnvironmentArn)(_.computeEnvironmentArn(_))
        .build

    def createJobQueueRequest(
      jobQueueName: Option[String] = None,
      state: Option[String] = None,
      priority: Option[Int] = None,
      computeEnvironmentOrder: Option[List[ComputeEnvironmentOrder]] = None,
      tags: Option[TagrisTagsMap] = None
    ): CreateJobQueueRequest =
      CreateJobQueueRequest
        .builder
        .ifSome(jobQueueName)(_.jobQueueName(_))
        .ifSome(state)(_.state(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(computeEnvironmentOrder)(_.computeEnvironmentOrder(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createJobQueueResponse(
      jobQueueName: Option[String] = None,
      jobQueueArn: Option[String] = None
    ): CreateJobQueueResponse =
      CreateJobQueueResponse
        .builder
        .ifSome(jobQueueName)(_.jobQueueName(_))
        .ifSome(jobQueueArn)(_.jobQueueArn(_))
        .build

    def deleteComputeEnvironmentRequest(
      computeEnvironment: Option[String] = None
    ): DeleteComputeEnvironmentRequest =
      DeleteComputeEnvironmentRequest
        .builder
        .ifSome(computeEnvironment)(_.computeEnvironment(_))
        .build

    def deleteComputeEnvironmentResponse(

    ): DeleteComputeEnvironmentResponse =
      DeleteComputeEnvironmentResponse
        .builder

        .build

    def deleteJobQueueRequest(
      jobQueue: Option[String] = None
    ): DeleteJobQueueRequest =
      DeleteJobQueueRequest
        .builder
        .ifSome(jobQueue)(_.jobQueue(_))
        .build

    def deleteJobQueueResponse(

    ): DeleteJobQueueResponse =
      DeleteJobQueueResponse
        .builder

        .build

    def deregisterJobDefinitionRequest(
      jobDefinition: Option[String] = None
    ): DeregisterJobDefinitionRequest =
      DeregisterJobDefinitionRequest
        .builder
        .ifSome(jobDefinition)(_.jobDefinition(_))
        .build

    def deregisterJobDefinitionResponse(

    ): DeregisterJobDefinitionResponse =
      DeregisterJobDefinitionResponse
        .builder

        .build

    def describeComputeEnvironmentsRequest(
      computeEnvironments: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeComputeEnvironmentsRequest =
      DescribeComputeEnvironmentsRequest
        .builder
        .ifSome(computeEnvironments)(_.computeEnvironments(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeComputeEnvironmentsResponse(
      computeEnvironments: Option[List[ComputeEnvironmentDetail]] = None,
      nextToken: Option[String] = None
    ): DescribeComputeEnvironmentsResponse =
      DescribeComputeEnvironmentsResponse
        .builder
        .ifSome(computeEnvironments)(_.computeEnvironments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobDefinitionsRequest(
      jobDefinitions: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      jobDefinitionName: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeJobDefinitionsRequest =
      DescribeJobDefinitionsRequest
        .builder
        .ifSome(jobDefinitions)(_.jobDefinitions(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobDefinitionsResponse(
      jobDefinitions: Option[List[JobDefinition]] = None,
      nextToken: Option[String] = None
    ): DescribeJobDefinitionsResponse =
      DescribeJobDefinitionsResponse
        .builder
        .ifSome(jobDefinitions)(_.jobDefinitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobQueuesRequest(
      jobQueues: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeJobQueuesRequest =
      DescribeJobQueuesRequest
        .builder
        .ifSome(jobQueues)(_.jobQueues(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobQueuesResponse(
      jobQueues: Option[List[JobQueueDetail]] = None,
      nextToken: Option[String] = None
    ): DescribeJobQueuesResponse =
      DescribeJobQueuesResponse
        .builder
        .ifSome(jobQueues)(_.jobQueues(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobsRequest(
      jobs: Option[List[String]] = None
    ): DescribeJobsRequest =
      DescribeJobsRequest
        .builder
        .ifSome(jobs)(_.jobs(_))
        .build

    def describeJobsResponse(
      jobs: Option[List[JobDetail]] = None
    ): DescribeJobsResponse =
      DescribeJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
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

    def ec2Configuration(
      imageType: Option[String] = None,
      imageIdOverride: Option[String] = None
    ): Ec2Configuration =
      Ec2Configuration
        .builder
        .ifSome(imageType)(_.imageType(_))
        .ifSome(imageIdOverride)(_.imageIdOverride(_))
        .build

    def evaluateOnExit(
      onStatusReason: Option[String] = None,
      onReason: Option[String] = None,
      onExitCode: Option[String] = None,
      action: Option[String] = None
    ): EvaluateOnExit =
      EvaluateOnExit
        .builder
        .ifSome(onStatusReason)(_.onStatusReason(_))
        .ifSome(onReason)(_.onReason(_))
        .ifSome(onExitCode)(_.onExitCode(_))
        .ifSome(action)(_.action(_))
        .build

    def fargatePlatformConfiguration(
      platformVersion: Option[String] = None
    ): FargatePlatformConfiguration =
      FargatePlatformConfiguration
        .builder
        .ifSome(platformVersion)(_.platformVersion(_))
        .build

    def host(
      sourcePath: Option[String] = None
    ): Host =
      Host
        .builder
        .ifSome(sourcePath)(_.sourcePath(_))
        .build

    def jobDefinition(
      jobDefinitionName: Option[String] = None,
      jobDefinitionArn: Option[String] = None,
      revision: Option[Int] = None,
      status: Option[String] = None,
      `type`: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      retryStrategy: Option[RetryStrategy] = None,
      containerProperties: Option[ContainerProperties] = None,
      timeout: Option[JobTimeout] = None,
      nodeProperties: Option[NodeProperties] = None,
      tags: Option[TagrisTagsMap] = None,
      propagateTags: Option[Boolean] = None,
      platformCapabilities: Option[List[PlatformCapability]] = None
    ): JobDefinition =
      JobDefinition
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(status)(_.status(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .ifSome(containerProperties)(_.containerProperties(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(nodeProperties)(_.nodeProperties(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(platformCapabilities)(_.platformCapabilities(_))
        .build

    def jobDependency(
      jobId: Option[String] = None,
      `type`: Option[String] = None
    ): JobDependency =
      JobDependency
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def jobDetail(
      jobArn: Option[String] = None,
      jobName: Option[String] = None,
      jobId: Option[String] = None,
      jobQueue: Option[String] = None,
      status: Option[String] = None,
      attempts: Option[List[AttemptDetail]] = None,
      statusReason: Option[String] = None,
      createdAt: Option[Long] = None,
      retryStrategy: Option[RetryStrategy] = None,
      startedAt: Option[Long] = None,
      stoppedAt: Option[Long] = None,
      dependsOn: Option[List[JobDependency]] = None,
      jobDefinition: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      container: Option[ContainerDetail] = None,
      nodeDetails: Option[NodeDetails] = None,
      nodeProperties: Option[NodeProperties] = None,
      arrayProperties: Option[ArrayPropertiesDetail] = None,
      timeout: Option[JobTimeout] = None,
      tags: Option[TagrisTagsMap] = None,
      propagateTags: Option[Boolean] = None,
      platformCapabilities: Option[List[PlatformCapability]] = None
    ): JobDetail =
      JobDetail
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobQueue)(_.jobQueue(_))
        .ifSome(status)(_.status(_))
        .ifSome(attempts)(_.attempts(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(stoppedAt)(_.stoppedAt(_))
        .ifSome(dependsOn)(_.dependsOn(_))
        .ifSome(jobDefinition)(_.jobDefinition(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(container)(_.container(_))
        .ifSome(nodeDetails)(_.nodeDetails(_))
        .ifSome(nodeProperties)(_.nodeProperties(_))
        .ifSome(arrayProperties)(_.arrayProperties(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(platformCapabilities)(_.platformCapabilities(_))
        .build

    def jobQueueDetail(
      jobQueueName: Option[String] = None,
      jobQueueArn: Option[String] = None,
      state: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      priority: Option[Int] = None,
      computeEnvironmentOrder: Option[List[ComputeEnvironmentOrder]] = None,
      tags: Option[TagrisTagsMap] = None
    ): JobQueueDetail =
      JobQueueDetail
        .builder
        .ifSome(jobQueueName)(_.jobQueueName(_))
        .ifSome(jobQueueArn)(_.jobQueueArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(computeEnvironmentOrder)(_.computeEnvironmentOrder(_))
        .ifSome(tags)(_.tags(_))
        .build

    def jobSummary(
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      createdAt: Option[Long] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      startedAt: Option[Long] = None,
      stoppedAt: Option[Long] = None,
      container: Option[ContainerSummary] = None,
      arrayProperties: Option[ArrayPropertiesSummary] = None,
      nodeProperties: Option[NodePropertiesSummary] = None
    ): JobSummary =
      JobSummary
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(stoppedAt)(_.stoppedAt(_))
        .ifSome(container)(_.container(_))
        .ifSome(arrayProperties)(_.arrayProperties(_))
        .ifSome(nodeProperties)(_.nodeProperties(_))
        .build

    def jobTimeout(
      attemptDurationSeconds: Option[Int] = None
    ): JobTimeout =
      JobTimeout
        .builder
        .ifSome(attemptDurationSeconds)(_.attemptDurationSeconds(_))
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

    def linuxParameters(
      devices: Option[List[Device]] = None,
      initProcessEnabled: Option[Boolean] = None,
      sharedMemorySize: Option[Int] = None,
      tmpfs: Option[List[Tmpfs]] = None,
      maxSwap: Option[Int] = None,
      swappiness: Option[Int] = None
    ): LinuxParameters =
      LinuxParameters
        .builder
        .ifSome(devices)(_.devices(_))
        .ifSome(initProcessEnabled)(_.initProcessEnabled(_))
        .ifSome(sharedMemorySize)(_.sharedMemorySize(_))
        .ifSome(tmpfs)(_.tmpfs(_))
        .ifSome(maxSwap)(_.maxSwap(_))
        .ifSome(swappiness)(_.swappiness(_))
        .build

    def listJobsRequest(
      jobQueue: Option[String] = None,
      arrayJobId: Option[String] = None,
      multiNodeJobId: Option[String] = None,
      jobStatus: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(jobQueue)(_.jobQueue(_))
        .ifSome(arrayJobId)(_.arrayJobId(_))
        .ifSome(multiNodeJobId)(_.multiNodeJobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsResponse(
      jobSummaryList: Option[List[JobSummary]] = None,
      nextToken: Option[String] = None
    ): ListJobsResponse =
      ListJobsResponse
        .builder
        .ifSome(jobSummaryList)(_.jobSummaryList(_))
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
      tags: Option[TagrisTagsMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
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

    def mountPoint(
      containerPath: Option[String] = None,
      readOnly: Option[Boolean] = None,
      sourceVolume: Option[String] = None
    ): MountPoint =
      MountPoint
        .builder
        .ifSome(containerPath)(_.containerPath(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(sourceVolume)(_.sourceVolume(_))
        .build

    def networkConfiguration(
      assignPublicIp: Option[String] = None
    ): NetworkConfiguration =
      NetworkConfiguration
        .builder
        .ifSome(assignPublicIp)(_.assignPublicIp(_))
        .build

    def networkInterface(
      attachmentId: Option[String] = None,
      ipv6Address: Option[String] = None,
      privateIpv4Address: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(ipv6Address)(_.ipv6Address(_))
        .ifSome(privateIpv4Address)(_.privateIpv4Address(_))
        .build

    def nodeDetails(
      nodeIndex: Option[Int] = None,
      isMainNode: Option[Boolean] = None
    ): NodeDetails =
      NodeDetails
        .builder
        .ifSome(nodeIndex)(_.nodeIndex(_))
        .ifSome(isMainNode)(_.isMainNode(_))
        .build

    def nodeOverrides(
      numNodes: Option[Int] = None,
      nodePropertyOverrides: Option[List[NodePropertyOverride]] = None
    ): NodeOverrides =
      NodeOverrides
        .builder
        .ifSome(numNodes)(_.numNodes(_))
        .ifSome(nodePropertyOverrides)(_.nodePropertyOverrides(_))
        .build

    def nodeProperties(
      numNodes: Option[Int] = None,
      mainNode: Option[Int] = None,
      nodeRangeProperties: Option[List[NodeRangeProperty]] = None
    ): NodeProperties =
      NodeProperties
        .builder
        .ifSome(numNodes)(_.numNodes(_))
        .ifSome(mainNode)(_.mainNode(_))
        .ifSome(nodeRangeProperties)(_.nodeRangeProperties(_))
        .build

    def nodePropertiesSummary(
      isMainNode: Option[Boolean] = None,
      numNodes: Option[Int] = None,
      nodeIndex: Option[Int] = None
    ): NodePropertiesSummary =
      NodePropertiesSummary
        .builder
        .ifSome(isMainNode)(_.isMainNode(_))
        .ifSome(numNodes)(_.numNodes(_))
        .ifSome(nodeIndex)(_.nodeIndex(_))
        .build

    def nodePropertyOverride(
      targetNodes: Option[String] = None,
      containerOverrides: Option[ContainerOverrides] = None
    ): NodePropertyOverride =
      NodePropertyOverride
        .builder
        .ifSome(targetNodes)(_.targetNodes(_))
        .ifSome(containerOverrides)(_.containerOverrides(_))
        .build

    def nodeRangeProperty(
      targetNodes: Option[String] = None,
      container: Option[ContainerProperties] = None
    ): NodeRangeProperty =
      NodeRangeProperty
        .builder
        .ifSome(targetNodes)(_.targetNodes(_))
        .ifSome(container)(_.container(_))
        .build

    def registerJobDefinitionRequest(
      jobDefinitionName: Option[String] = None,
      `type`: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      containerProperties: Option[ContainerProperties] = None,
      nodeProperties: Option[NodeProperties] = None,
      retryStrategy: Option[RetryStrategy] = None,
      propagateTags: Option[Boolean] = None,
      timeout: Option[JobTimeout] = None,
      tags: Option[TagrisTagsMap] = None,
      platformCapabilities: Option[List[PlatformCapability]] = None
    ): RegisterJobDefinitionRequest =
      RegisterJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(containerProperties)(_.containerProperties(_))
        .ifSome(nodeProperties)(_.nodeProperties(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(platformCapabilities)(_.platformCapabilities(_))
        .build

    def registerJobDefinitionResponse(
      jobDefinitionName: Option[String] = None,
      jobDefinitionArn: Option[String] = None,
      revision: Option[Int] = None
    ): RegisterJobDefinitionResponse =
      RegisterJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .ifSome(revision)(_.revision(_))
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

    def retryStrategy(
      attempts: Option[Int] = None,
      evaluateOnExit: Option[List[EvaluateOnExit]] = None
    ): RetryStrategy =
      RetryStrategy
        .builder
        .ifSome(attempts)(_.attempts(_))
        .ifSome(evaluateOnExit)(_.evaluateOnExit(_))
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

    def submitJobRequest(
      jobName: Option[String] = None,
      jobQueue: Option[String] = None,
      arrayProperties: Option[ArrayProperties] = None,
      dependsOn: Option[List[JobDependency]] = None,
      jobDefinition: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      containerOverrides: Option[ContainerOverrides] = None,
      nodeOverrides: Option[NodeOverrides] = None,
      retryStrategy: Option[RetryStrategy] = None,
      propagateTags: Option[Boolean] = None,
      timeout: Option[JobTimeout] = None,
      tags: Option[TagrisTagsMap] = None
    ): SubmitJobRequest =
      SubmitJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobQueue)(_.jobQueue(_))
        .ifSome(arrayProperties)(_.arrayProperties(_))
        .ifSome(dependsOn)(_.dependsOn(_))
        .ifSome(jobDefinition)(_.jobDefinition(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(containerOverrides)(_.containerOverrides(_))
        .ifSome(nodeOverrides)(_.nodeOverrides(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .ifSome(propagateTags)(_.propagateTags(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(tags)(_.tags(_))
        .build

    def submitJobResponse(
      jobArn: Option[String] = None,
      jobName: Option[String] = None,
      jobId: Option[String] = None
    ): SubmitJobResponse =
      SubmitJobResponse
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagrisTagsMap] = None
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

    def terminateJobRequest(
      jobId: Option[String] = None,
      reason: Option[String] = None
    ): TerminateJobRequest =
      TerminateJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(reason)(_.reason(_))
        .build

    def terminateJobResponse(

    ): TerminateJobResponse =
      TerminateJobResponse
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
      hardLimit: Option[Int] = None,
      name: Option[String] = None,
      softLimit: Option[Int] = None
    ): Ulimit =
      Ulimit
        .builder
        .ifSome(hardLimit)(_.hardLimit(_))
        .ifSome(name)(_.name(_))
        .ifSome(softLimit)(_.softLimit(_))
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

    def updateComputeEnvironmentRequest(
      computeEnvironment: Option[String] = None,
      state: Option[String] = None,
      computeResources: Option[ComputeResourceUpdate] = None,
      serviceRole: Option[String] = None
    ): UpdateComputeEnvironmentRequest =
      UpdateComputeEnvironmentRequest
        .builder
        .ifSome(computeEnvironment)(_.computeEnvironment(_))
        .ifSome(state)(_.state(_))
        .ifSome(computeResources)(_.computeResources(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .build

    def updateComputeEnvironmentResponse(
      computeEnvironmentName: Option[String] = None,
      computeEnvironmentArn: Option[String] = None
    ): UpdateComputeEnvironmentResponse =
      UpdateComputeEnvironmentResponse
        .builder
        .ifSome(computeEnvironmentName)(_.computeEnvironmentName(_))
        .ifSome(computeEnvironmentArn)(_.computeEnvironmentArn(_))
        .build

    def updateJobQueueRequest(
      jobQueue: Option[String] = None,
      state: Option[String] = None,
      priority: Option[Int] = None,
      computeEnvironmentOrder: Option[List[ComputeEnvironmentOrder]] = None
    ): UpdateJobQueueRequest =
      UpdateJobQueueRequest
        .builder
        .ifSome(jobQueue)(_.jobQueue(_))
        .ifSome(state)(_.state(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(computeEnvironmentOrder)(_.computeEnvironmentOrder(_))
        .build

    def updateJobQueueResponse(
      jobQueueName: Option[String] = None,
      jobQueueArn: Option[String] = None
    ): UpdateJobQueueResponse =
      UpdateJobQueueResponse
        .builder
        .ifSome(jobQueueName)(_.jobQueueName(_))
        .ifSome(jobQueueArn)(_.jobQueueArn(_))
        .build

    def volume(
      host: Option[Host] = None,
      name: Option[String] = None,
      efsVolumeConfiguration: Option[EFSVolumeConfiguration] = None
    ): Volume =
      Volume
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(name)(_.name(_))
        .ifSome(efsVolumeConfiguration)(_.efsVolumeConfiguration(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
