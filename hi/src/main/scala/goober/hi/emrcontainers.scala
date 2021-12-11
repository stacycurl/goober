package goober.hi

import goober.free.emrcontainers.EmrContainersIO
import software.amazon.awssdk.services.emrcontainers.model._


object emrcontainers {
  import goober.free.{emrcontainers ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def cancelJobRunRequest(
      id: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): CancelJobRunRequest =
      CancelJobRunRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def cancelJobRunResponse(
      id: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): CancelJobRunResponse =
      CancelJobRunResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def cloudWatchMonitoringConfiguration(
      logGroupName: Option[String] = None,
      logStreamNamePrefix: Option[String] = None
    ): CloudWatchMonitoringConfiguration =
      CloudWatchMonitoringConfiguration
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamNamePrefix)(_.logStreamNamePrefix(_))
        .build

    def configuration(
      classification: Option[String] = None,
      properties: Option[SensitivePropertiesMap] = None,
      configurations: Option[List[Configuration]] = None
    ): Configuration =
      Configuration
        .builder
        .ifSome(classification)(_.classification(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(configurations)(_.configurations(_))
        .build

    def configurationOverrides(
      applicationConfiguration: Option[List[Configuration]] = None,
      monitoringConfiguration: Option[MonitoringConfiguration] = None
    ): ConfigurationOverrides =
      ConfigurationOverrides
        .builder
        .ifSome(applicationConfiguration)(_.applicationConfiguration(_))
        .ifSome(monitoringConfiguration)(_.monitoringConfiguration(_))
        .build

    def containerInfo(
      eksInfo: Option[EksInfo] = None
    ): ContainerInfo =
      ContainerInfo
        .builder
        .ifSome(eksInfo)(_.eksInfo(_))
        .build

    def containerProvider(
      `type`: Option[String] = None,
      id: Option[String] = None,
      info: Option[ContainerInfo] = None
    ): ContainerProvider =
      ContainerProvider
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(info)(_.info(_))
        .build

    def createManagedEndpointRequest(
      name: Option[String] = None,
      virtualClusterId: Option[String] = None,
      `type`: Option[String] = None,
      releaseLabel: Option[String] = None,
      executionRoleArn: Option[String] = None,
      certificateArn: Option[String] = None,
      configurationOverrides: Option[ConfigurationOverrides] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateManagedEndpointRequest =
      CreateManagedEndpointRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(releaseLabel)(_.releaseLabel(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(configurationOverrides)(_.configurationOverrides(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createManagedEndpointResponse(
      id: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): CreateManagedEndpointResponse =
      CreateManagedEndpointResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def createVirtualClusterRequest(
      name: Option[String] = None,
      containerProvider: Option[ContainerProvider] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateVirtualClusterRequest =
      CreateVirtualClusterRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(containerProvider)(_.containerProvider(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVirtualClusterResponse(
      id: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None
    ): CreateVirtualClusterResponse =
      CreateVirtualClusterResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def deleteManagedEndpointRequest(
      id: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): DeleteManagedEndpointRequest =
      DeleteManagedEndpointRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def deleteManagedEndpointResponse(
      id: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): DeleteManagedEndpointResponse =
      DeleteManagedEndpointResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def deleteVirtualClusterRequest(
      id: Option[String] = None
    ): DeleteVirtualClusterRequest =
      DeleteVirtualClusterRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteVirtualClusterResponse(
      id: Option[String] = None
    ): DeleteVirtualClusterResponse =
      DeleteVirtualClusterResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeJobRunRequest(
      id: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): DescribeJobRunRequest =
      DescribeJobRunRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def describeJobRunResponse(
      jobRun: Option[JobRun] = None
    ): DescribeJobRunResponse =
      DescribeJobRunResponse
        .builder
        .ifSome(jobRun)(_.jobRun(_))
        .build

    def describeManagedEndpointRequest(
      id: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): DescribeManagedEndpointRequest =
      DescribeManagedEndpointRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def describeManagedEndpointResponse(
      endpoint: Option[Endpoint] = None
    ): DescribeManagedEndpointResponse =
      DescribeManagedEndpointResponse
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def describeVirtualClusterRequest(
      id: Option[String] = None
    ): DescribeVirtualClusterRequest =
      DescribeVirtualClusterRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeVirtualClusterResponse(
      virtualCluster: Option[VirtualCluster] = None
    ): DescribeVirtualClusterResponse =
      DescribeVirtualClusterResponse
        .builder
        .ifSome(virtualCluster)(_.virtualCluster(_))
        .build

    def eksInfo(
      namespace: Option[String] = None
    ): EksInfo =
      EksInfo
        .builder
        .ifSome(namespace)(_.namespace(_))
        .build

    def endpoint(
      id: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      virtualClusterId: Option[String] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      releaseLabel: Option[String] = None,
      executionRoleArn: Option[String] = None,
      certificateArn: Option[String] = None,
      configurationOverrides: Option[ConfigurationOverrides] = None,
      serverUrl: Option[String] = None,
      createdAt: Option[Date] = None,
      securityGroup: Option[String] = None,
      subnetIds: Option[List[String256]] = None,
      tags: Option[TagMap] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(releaseLabel)(_.releaseLabel(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(configurationOverrides)(_.configurationOverrides(_))
        .ifSome(serverUrl)(_.serverUrl(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(securityGroup)(_.securityGroup(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jobDriver(
      sparkSubmitJobDriver: Option[SparkSubmitJobDriver] = None
    ): JobDriver =
      JobDriver
        .builder
        .ifSome(sparkSubmitJobDriver)(_.sparkSubmitJobDriver(_))
        .build

    def jobRun(
      id: Option[String] = None,
      name: Option[String] = None,
      virtualClusterId: Option[String] = None,
      arn: Option[String] = None,
      state: Option[String] = None,
      clientToken: Option[String] = None,
      executionRoleArn: Option[String] = None,
      releaseLabel: Option[String] = None,
      configurationOverrides: Option[ConfigurationOverrides] = None,
      jobDriver: Option[JobDriver] = None,
      createdAt: Option[Date] = None,
      createdBy: Option[String] = None,
      finishedAt: Option[Date] = None,
      stateDetails: Option[String] = None,
      failureReason: Option[String] = None,
      tags: Option[TagMap] = None
    ): JobRun =
      JobRun
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(state)(_.state(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(releaseLabel)(_.releaseLabel(_))
        .ifSome(configurationOverrides)(_.configurationOverrides(_))
        .ifSome(jobDriver)(_.jobDriver(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(stateDetails)(_.stateDetails(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listJobRunsRequest(
      virtualClusterId: Option[String] = None,
      createdBefore: Option[Date] = None,
      createdAfter: Option[Date] = None,
      name: Option[String] = None,
      states: Option[List[JobRunState]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJobRunsRequest =
      ListJobRunsRequest
        .builder
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(name)(_.name(_))
        .ifSome(states)(_.states(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobRunsResponse(
      jobRuns: Option[List[JobRun]] = None,
      nextToken: Option[String] = None
    ): ListJobRunsResponse =
      ListJobRunsResponse
        .builder
        .ifSome(jobRuns)(_.jobRuns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listManagedEndpointsRequest(
      virtualClusterId: Option[String] = None,
      createdBefore: Option[Date] = None,
      createdAfter: Option[Date] = None,
      types: Option[List[EndpointType]] = None,
      states: Option[List[EndpointState]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListManagedEndpointsRequest =
      ListManagedEndpointsRequest
        .builder
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(types)(_.types(_))
        .ifSome(states)(_.states(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listManagedEndpointsResponse(
      endpoints: Option[List[Endpoint]] = None,
      nextToken: Option[String] = None
    ): ListManagedEndpointsResponse =
      ListManagedEndpointsResponse
        .builder
        .ifSome(endpoints)(_.endpoints(_))
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
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listVirtualClustersRequest(
      containerProviderId: Option[String] = None,
      containerProviderType: Option[String] = None,
      createdAfter: Option[Date] = None,
      createdBefore: Option[Date] = None,
      states: Option[List[VirtualClusterState]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListVirtualClustersRequest =
      ListVirtualClustersRequest
        .builder
        .ifSome(containerProviderId)(_.containerProviderId(_))
        .ifSome(containerProviderType)(_.containerProviderType(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(states)(_.states(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVirtualClustersResponse(
      virtualClusters: Option[List[VirtualCluster]] = None,
      nextToken: Option[String] = None
    ): ListVirtualClustersResponse =
      ListVirtualClustersResponse
        .builder
        .ifSome(virtualClusters)(_.virtualClusters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def monitoringConfiguration(
      persistentAppUI: Option[String] = None,
      cloudWatchMonitoringConfiguration: Option[CloudWatchMonitoringConfiguration] = None,
      s3MonitoringConfiguration: Option[S3MonitoringConfiguration] = None
    ): MonitoringConfiguration =
      MonitoringConfiguration
        .builder
        .ifSome(persistentAppUI)(_.persistentAppUI(_))
        .ifSome(cloudWatchMonitoringConfiguration)(_.cloudWatchMonitoringConfiguration(_))
        .ifSome(s3MonitoringConfiguration)(_.s3MonitoringConfiguration(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3MonitoringConfiguration(
      logUri: Option[String] = None
    ): S3MonitoringConfiguration =
      S3MonitoringConfiguration
        .builder
        .ifSome(logUri)(_.logUri(_))
        .build

    def sparkSubmitJobDriver(
      entryPoint: Option[String] = None,
      entryPointArguments: Option[List[EntryPointArgument]] = None,
      sparkSubmitParameters: Option[String] = None
    ): SparkSubmitJobDriver =
      SparkSubmitJobDriver
        .builder
        .ifSome(entryPoint)(_.entryPoint(_))
        .ifSome(entryPointArguments)(_.entryPointArguments(_))
        .ifSome(sparkSubmitParameters)(_.sparkSubmitParameters(_))
        .build

    def startJobRunRequest(
      name: Option[String] = None,
      virtualClusterId: Option[String] = None,
      clientToken: Option[String] = None,
      executionRoleArn: Option[String] = None,
      releaseLabel: Option[String] = None,
      jobDriver: Option[JobDriver] = None,
      configurationOverrides: Option[ConfigurationOverrides] = None,
      tags: Option[TagMap] = None
    ): StartJobRunRequest =
      StartJobRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(releaseLabel)(_.releaseLabel(_))
        .ifSome(jobDriver)(_.jobDriver(_))
        .ifSome(configurationOverrides)(_.configurationOverrides(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startJobRunResponse(
      id: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      virtualClusterId: Option[String] = None
    ): StartJobRunResponse =
      StartJobRunResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(virtualClusterId)(_.virtualClusterId(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
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

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String128]] = None
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

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def virtualCluster(
      id: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      state: Option[String] = None,
      containerProvider: Option[ContainerProvider] = None,
      createdAt: Option[Date] = None,
      tags: Option[TagMap] = None
    ): VirtualCluster =
      VirtualCluster
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(state)(_.state(_))
        .ifSome(containerProvider)(_.containerProvider(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(tags)(_.tags(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
