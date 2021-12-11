package goober.hi

import goober.free.datasync.DataSyncIO
import software.amazon.awssdk.services.datasync.model._


object datasync {
  import goober.free.{datasync ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def agentListEntry(
      agentArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None
    ): AgentListEntry =
      AgentListEntry
        .builder
        .ifSome(agentArn)(_.agentArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def cancelTaskExecutionRequest(
      taskExecutionArn: Option[String] = None
    ): CancelTaskExecutionRequest =
      CancelTaskExecutionRequest
        .builder
        .ifSome(taskExecutionArn)(_.taskExecutionArn(_))
        .build

    def cancelTaskExecutionResponse(

    ): CancelTaskExecutionResponse =
      CancelTaskExecutionResponse
        .builder

        .build

    def createAgentRequest(
      activationKey: Option[String] = None,
      agentName: Option[String] = None,
      tags: Option[List[TagListEntry]] = None,
      vpcEndpointId: Option[String] = None,
      subnetArns: Option[List[Ec2SubnetArn]] = None,
      securityGroupArns: Option[List[Ec2SecurityGroupArn]] = None
    ): CreateAgentRequest =
      CreateAgentRequest
        .builder
        .ifSome(activationKey)(_.activationKey(_))
        .ifSome(agentName)(_.agentName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(subnetArns)(_.subnetArns(_))
        .ifSome(securityGroupArns)(_.securityGroupArns(_))
        .build

    def createAgentResponse(
      agentArn: Option[String] = None
    ): CreateAgentResponse =
      CreateAgentResponse
        .builder
        .ifSome(agentArn)(_.agentArn(_))
        .build

    def createLocationEfsRequest(
      subdirectory: Option[String] = None,
      efsFilesystemArn: Option[String] = None,
      ec2Config: Option[Ec2Config] = None,
      tags: Option[List[TagListEntry]] = None
    ): CreateLocationEfsRequest =
      CreateLocationEfsRequest
        .builder
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(efsFilesystemArn)(_.efsFilesystemArn(_))
        .ifSome(ec2Config)(_.ec2Config(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLocationEfsResponse(
      locationArn: Option[String] = None
    ): CreateLocationEfsResponse =
      CreateLocationEfsResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def createLocationFsxWindowsRequest(
      subdirectory: Option[String] = None,
      fsxFilesystemArn: Option[String] = None,
      securityGroupArns: Option[List[Ec2SecurityGroupArn]] = None,
      tags: Option[List[TagListEntry]] = None,
      user: Option[String] = None,
      domain: Option[String] = None,
      password: Option[String] = None
    ): CreateLocationFsxWindowsRequest =
      CreateLocationFsxWindowsRequest
        .builder
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(fsxFilesystemArn)(_.fsxFilesystemArn(_))
        .ifSome(securityGroupArns)(_.securityGroupArns(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(user)(_.user(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(password)(_.password(_))
        .build

    def createLocationFsxWindowsResponse(
      locationArn: Option[String] = None
    ): CreateLocationFsxWindowsResponse =
      CreateLocationFsxWindowsResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def createLocationNfsRequest(
      subdirectory: Option[String] = None,
      serverHostname: Option[String] = None,
      onPremConfig: Option[OnPremConfig] = None,
      mountOptions: Option[NfsMountOptions] = None,
      tags: Option[List[TagListEntry]] = None
    ): CreateLocationNfsRequest =
      CreateLocationNfsRequest
        .builder
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(serverHostname)(_.serverHostname(_))
        .ifSome(onPremConfig)(_.onPremConfig(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLocationNfsResponse(
      locationArn: Option[String] = None
    ): CreateLocationNfsResponse =
      CreateLocationNfsResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def createLocationObjectStorageRequest(
      serverHostname: Option[String] = None,
      serverPort: Option[Int] = None,
      serverProtocol: Option[String] = None,
      subdirectory: Option[String] = None,
      bucketName: Option[String] = None,
      accessKey: Option[String] = None,
      secretKey: Option[String] = None,
      agentArns: Option[List[AgentArn]] = None,
      tags: Option[List[TagListEntry]] = None
    ): CreateLocationObjectStorageRequest =
      CreateLocationObjectStorageRequest
        .builder
        .ifSome(serverHostname)(_.serverHostname(_))
        .ifSome(serverPort)(_.serverPort(_))
        .ifSome(serverProtocol)(_.serverProtocol(_))
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(accessKey)(_.accessKey(_))
        .ifSome(secretKey)(_.secretKey(_))
        .ifSome(agentArns)(_.agentArns(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLocationObjectStorageResponse(
      locationArn: Option[String] = None
    ): CreateLocationObjectStorageResponse =
      CreateLocationObjectStorageResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def createLocationS3Request(
      subdirectory: Option[String] = None,
      s3BucketArn: Option[String] = None,
      s3StorageClass: Option[String] = None,
      s3Config: Option[S3Config] = None,
      agentArns: Option[List[AgentArn]] = None,
      tags: Option[List[TagListEntry]] = None
    ): CreateLocationS3Request =
      CreateLocationS3Request
        .builder
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(s3BucketArn)(_.s3BucketArn(_))
        .ifSome(s3StorageClass)(_.s3StorageClass(_))
        .ifSome(s3Config)(_.s3Config(_))
        .ifSome(agentArns)(_.agentArns(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLocationS3Response(
      locationArn: Option[String] = None
    ): CreateLocationS3Response =
      CreateLocationS3Response
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def createLocationSmbRequest(
      subdirectory: Option[String] = None,
      serverHostname: Option[String] = None,
      user: Option[String] = None,
      domain: Option[String] = None,
      password: Option[String] = None,
      agentArns: Option[List[AgentArn]] = None,
      mountOptions: Option[SmbMountOptions] = None,
      tags: Option[List[TagListEntry]] = None
    ): CreateLocationSmbRequest =
      CreateLocationSmbRequest
        .builder
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(serverHostname)(_.serverHostname(_))
        .ifSome(user)(_.user(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(password)(_.password(_))
        .ifSome(agentArns)(_.agentArns(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLocationSmbResponse(
      locationArn: Option[String] = None
    ): CreateLocationSmbResponse =
      CreateLocationSmbResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def createTaskRequest(
      sourceLocationArn: Option[String] = None,
      destinationLocationArn: Option[String] = None,
      cloudWatchLogGroupArn: Option[String] = None,
      name: Option[String] = None,
      options: Option[Options] = None,
      excludes: Option[List[FilterRule]] = None,
      schedule: Option[TaskSchedule] = None,
      tags: Option[List[TagListEntry]] = None
    ): CreateTaskRequest =
      CreateTaskRequest
        .builder
        .ifSome(sourceLocationArn)(_.sourceLocationArn(_))
        .ifSome(destinationLocationArn)(_.destinationLocationArn(_))
        .ifSome(cloudWatchLogGroupArn)(_.cloudWatchLogGroupArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(options)(_.options(_))
        .ifSome(excludes)(_.excludes(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTaskResponse(
      taskArn: Option[String] = None
    ): CreateTaskResponse =
      CreateTaskResponse
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .build

    def deleteAgentRequest(
      agentArn: Option[String] = None
    ): DeleteAgentRequest =
      DeleteAgentRequest
        .builder
        .ifSome(agentArn)(_.agentArn(_))
        .build

    def deleteAgentResponse(

    ): DeleteAgentResponse =
      DeleteAgentResponse
        .builder

        .build

    def deleteLocationRequest(
      locationArn: Option[String] = None
    ): DeleteLocationRequest =
      DeleteLocationRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def deleteLocationResponse(

    ): DeleteLocationResponse =
      DeleteLocationResponse
        .builder

        .build

    def deleteTaskRequest(
      taskArn: Option[String] = None
    ): DeleteTaskRequest =
      DeleteTaskRequest
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .build

    def deleteTaskResponse(

    ): DeleteTaskResponse =
      DeleteTaskResponse
        .builder

        .build

    def describeAgentRequest(
      agentArn: Option[String] = None
    ): DescribeAgentRequest =
      DescribeAgentRequest
        .builder
        .ifSome(agentArn)(_.agentArn(_))
        .build

    def describeAgentResponse(
      agentArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      lastConnectionTime: Option[Time] = None,
      creationTime: Option[Time] = None,
      endpointType: Option[String] = None,
      privateLinkConfig: Option[PrivateLinkConfig] = None
    ): DescribeAgentResponse =
      DescribeAgentResponse
        .builder
        .ifSome(agentArn)(_.agentArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastConnectionTime)(_.lastConnectionTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(privateLinkConfig)(_.privateLinkConfig(_))
        .build

    def describeLocationEfsRequest(
      locationArn: Option[String] = None
    ): DescribeLocationEfsRequest =
      DescribeLocationEfsRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def describeLocationEfsResponse(
      locationArn: Option[String] = None,
      locationUri: Option[String] = None,
      ec2Config: Option[Ec2Config] = None,
      creationTime: Option[Time] = None
    ): DescribeLocationEfsResponse =
      DescribeLocationEfsResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(ec2Config)(_.ec2Config(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeLocationFsxWindowsRequest(
      locationArn: Option[String] = None
    ): DescribeLocationFsxWindowsRequest =
      DescribeLocationFsxWindowsRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def describeLocationFsxWindowsResponse(
      locationArn: Option[String] = None,
      locationUri: Option[String] = None,
      securityGroupArns: Option[List[Ec2SecurityGroupArn]] = None,
      creationTime: Option[Time] = None,
      user: Option[String] = None,
      domain: Option[String] = None
    ): DescribeLocationFsxWindowsResponse =
      DescribeLocationFsxWindowsResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(securityGroupArns)(_.securityGroupArns(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(user)(_.user(_))
        .ifSome(domain)(_.domain(_))
        .build

    def describeLocationNfsRequest(
      locationArn: Option[String] = None
    ): DescribeLocationNfsRequest =
      DescribeLocationNfsRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def describeLocationNfsResponse(
      locationArn: Option[String] = None,
      locationUri: Option[String] = None,
      onPremConfig: Option[OnPremConfig] = None,
      mountOptions: Option[NfsMountOptions] = None,
      creationTime: Option[Time] = None
    ): DescribeLocationNfsResponse =
      DescribeLocationNfsResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(onPremConfig)(_.onPremConfig(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeLocationObjectStorageRequest(
      locationArn: Option[String] = None
    ): DescribeLocationObjectStorageRequest =
      DescribeLocationObjectStorageRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def describeLocationObjectStorageResponse(
      locationArn: Option[String] = None,
      locationUri: Option[String] = None,
      accessKey: Option[String] = None,
      serverPort: Option[Int] = None,
      serverProtocol: Option[String] = None,
      agentArns: Option[List[AgentArn]] = None,
      creationTime: Option[Time] = None
    ): DescribeLocationObjectStorageResponse =
      DescribeLocationObjectStorageResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(accessKey)(_.accessKey(_))
        .ifSome(serverPort)(_.serverPort(_))
        .ifSome(serverProtocol)(_.serverProtocol(_))
        .ifSome(agentArns)(_.agentArns(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeLocationS3Request(
      locationArn: Option[String] = None
    ): DescribeLocationS3Request =
      DescribeLocationS3Request
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def describeLocationS3Response(
      locationArn: Option[String] = None,
      locationUri: Option[String] = None,
      s3StorageClass: Option[String] = None,
      s3Config: Option[S3Config] = None,
      agentArns: Option[List[AgentArn]] = None,
      creationTime: Option[Time] = None
    ): DescribeLocationS3Response =
      DescribeLocationS3Response
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(s3StorageClass)(_.s3StorageClass(_))
        .ifSome(s3Config)(_.s3Config(_))
        .ifSome(agentArns)(_.agentArns(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeLocationSmbRequest(
      locationArn: Option[String] = None
    ): DescribeLocationSmbRequest =
      DescribeLocationSmbRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .build

    def describeLocationSmbResponse(
      locationArn: Option[String] = None,
      locationUri: Option[String] = None,
      agentArns: Option[List[AgentArn]] = None,
      user: Option[String] = None,
      domain: Option[String] = None,
      mountOptions: Option[SmbMountOptions] = None,
      creationTime: Option[Time] = None
    ): DescribeLocationSmbResponse =
      DescribeLocationSmbResponse
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(agentArns)(_.agentArns(_))
        .ifSome(user)(_.user(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeTaskExecutionRequest(
      taskExecutionArn: Option[String] = None
    ): DescribeTaskExecutionRequest =
      DescribeTaskExecutionRequest
        .builder
        .ifSome(taskExecutionArn)(_.taskExecutionArn(_))
        .build

    def describeTaskExecutionResponse(
      taskExecutionArn: Option[String] = None,
      status: Option[String] = None,
      options: Option[Options] = None,
      excludes: Option[List[FilterRule]] = None,
      includes: Option[List[FilterRule]] = None,
      startTime: Option[Time] = None,
      estimatedFilesToTransfer: Option[long] = None,
      estimatedBytesToTransfer: Option[long] = None,
      filesTransferred: Option[long] = None,
      bytesWritten: Option[long] = None,
      bytesTransferred: Option[long] = None,
      result: Option[TaskExecutionResultDetail] = None
    ): DescribeTaskExecutionResponse =
      DescribeTaskExecutionResponse
        .builder
        .ifSome(taskExecutionArn)(_.taskExecutionArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(options)(_.options(_))
        .ifSome(excludes)(_.excludes(_))
        .ifSome(includes)(_.includes(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(estimatedFilesToTransfer)(_.estimatedFilesToTransfer(_))
        .ifSome(estimatedBytesToTransfer)(_.estimatedBytesToTransfer(_))
        .ifSome(filesTransferred)(_.filesTransferred(_))
        .ifSome(bytesWritten)(_.bytesWritten(_))
        .ifSome(bytesTransferred)(_.bytesTransferred(_))
        .ifSome(result)(_.result(_))
        .build

    def describeTaskRequest(
      taskArn: Option[String] = None
    ): DescribeTaskRequest =
      DescribeTaskRequest
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .build

    def describeTaskResponse(
      taskArn: Option[String] = None,
      status: Option[String] = None,
      name: Option[String] = None,
      currentTaskExecutionArn: Option[String] = None,
      sourceLocationArn: Option[String] = None,
      destinationLocationArn: Option[String] = None,
      cloudWatchLogGroupArn: Option[String] = None,
      sourceNetworkInterfaceArns: Option[List[NetworkInterfaceArn]] = None,
      destinationNetworkInterfaceArns: Option[List[NetworkInterfaceArn]] = None,
      options: Option[Options] = None,
      excludes: Option[List[FilterRule]] = None,
      schedule: Option[TaskSchedule] = None,
      errorCode: Option[String] = None,
      errorDetail: Option[String] = None,
      creationTime: Option[Time] = None
    ): DescribeTaskResponse =
      DescribeTaskResponse
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(name)(_.name(_))
        .ifSome(currentTaskExecutionArn)(_.currentTaskExecutionArn(_))
        .ifSome(sourceLocationArn)(_.sourceLocationArn(_))
        .ifSome(destinationLocationArn)(_.destinationLocationArn(_))
        .ifSome(cloudWatchLogGroupArn)(_.cloudWatchLogGroupArn(_))
        .ifSome(sourceNetworkInterfaceArns)(_.sourceNetworkInterfaceArns(_))
        .ifSome(destinationNetworkInterfaceArns)(_.destinationNetworkInterfaceArns(_))
        .ifSome(options)(_.options(_))
        .ifSome(excludes)(_.excludes(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorDetail)(_.errorDetail(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def ec2Config(
      subnetArn: Option[String] = None,
      securityGroupArns: Option[List[Ec2SecurityGroupArn]] = None
    ): Ec2Config =
      Ec2Config
        .builder
        .ifSome(subnetArn)(_.subnetArn(_))
        .ifSome(securityGroupArns)(_.securityGroupArns(_))
        .build

    def filterRule(
      filterType: Option[String] = None,
      value: Option[String] = None
    ): FilterRule =
      FilterRule
        .builder
        .ifSome(filterType)(_.filterType(_))
        .ifSome(value)(_.value(_))
        .build

    def internalException(
      message: Option[String] = None,
      errorCode: Option[String] = None
    ): InternalException =
      InternalException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .build

    def invalidRequestException(
      message: Option[String] = None,
      errorCode: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .build

    def listAgentsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAgentsRequest =
      ListAgentsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAgentsResponse(
      agents: Option[List[AgentListEntry]] = None,
      nextToken: Option[String] = None
    ): ListAgentsResponse =
      ListAgentsResponse
        .builder
        .ifSome(agents)(_.agents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLocationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[LocationFilter]] = None
    ): ListLocationsRequest =
      ListLocationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listLocationsResponse(
      locations: Option[List[LocationListEntry]] = None,
      nextToken: Option[String] = None
    ): ListLocationsResponse =
      ListLocationsResponse
        .builder
        .ifSome(locations)(_.locations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[TagListEntry]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTaskExecutionsRequest(
      taskArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTaskExecutionsRequest =
      ListTaskExecutionsRequest
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTaskExecutionsResponse(
      taskExecutions: Option[List[TaskExecutionListEntry]] = None,
      nextToken: Option[String] = None
    ): ListTaskExecutionsResponse =
      ListTaskExecutionsResponse
        .builder
        .ifSome(taskExecutions)(_.taskExecutions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTasksRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[TaskFilter]] = None
    ): ListTasksRequest =
      ListTasksRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listTasksResponse(
      tasks: Option[List[TaskListEntry]] = None,
      nextToken: Option[String] = None
    ): ListTasksResponse =
      ListTasksResponse
        .builder
        .ifSome(tasks)(_.tasks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def locationFilter(
      name: Option[String] = None,
      values: Option[List[FilterAttributeValue]] = None,
      operator: Option[String] = None
    ): LocationFilter =
      LocationFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def locationListEntry(
      locationArn: Option[String] = None,
      locationUri: Option[String] = None
    ): LocationListEntry =
      LocationListEntry
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(locationUri)(_.locationUri(_))
        .build

    def nfsMountOptions(
      version: Option[String] = None
    ): NfsMountOptions =
      NfsMountOptions
        .builder
        .ifSome(version)(_.version(_))
        .build

    def onPremConfig(
      agentArns: Option[List[AgentArn]] = None
    ): OnPremConfig =
      OnPremConfig
        .builder
        .ifSome(agentArns)(_.agentArns(_))
        .build

    def options(
      verifyMode: Option[String] = None,
      overwriteMode: Option[String] = None,
      atime: Option[String] = None,
      mtime: Option[String] = None,
      uid: Option[String] = None,
      gid: Option[String] = None,
      preserveDeletedFiles: Option[String] = None,
      preserveDevices: Option[String] = None,
      posixPermissions: Option[String] = None,
      bytesPerSecond: Option[BytesPerSecond] = None,
      taskQueueing: Option[String] = None,
      logLevel: Option[String] = None,
      transferMode: Option[String] = None,
      securityDescriptorCopyFlags: Option[String] = None
    ): Options =
      Options
        .builder
        .ifSome(verifyMode)(_.verifyMode(_))
        .ifSome(overwriteMode)(_.overwriteMode(_))
        .ifSome(atime)(_.atime(_))
        .ifSome(mtime)(_.mtime(_))
        .ifSome(uid)(_.uid(_))
        .ifSome(gid)(_.gid(_))
        .ifSome(preserveDeletedFiles)(_.preserveDeletedFiles(_))
        .ifSome(preserveDevices)(_.preserveDevices(_))
        .ifSome(posixPermissions)(_.posixPermissions(_))
        .ifSome(bytesPerSecond)(_.bytesPerSecond(_))
        .ifSome(taskQueueing)(_.taskQueueing(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(transferMode)(_.transferMode(_))
        .ifSome(securityDescriptorCopyFlags)(_.securityDescriptorCopyFlags(_))
        .build

    def privateLinkConfig(
      vpcEndpointId: Option[String] = None,
      privateLinkEndpoint: Option[String] = None,
      subnetArns: Option[List[Ec2SubnetArn]] = None,
      securityGroupArns: Option[List[Ec2SecurityGroupArn]] = None
    ): PrivateLinkConfig =
      PrivateLinkConfig
        .builder
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(privateLinkEndpoint)(_.privateLinkEndpoint(_))
        .ifSome(subnetArns)(_.subnetArns(_))
        .ifSome(securityGroupArns)(_.securityGroupArns(_))
        .build

    def s3Config(
      bucketAccessRoleArn: Option[String] = None
    ): S3Config =
      S3Config
        .builder
        .ifSome(bucketAccessRoleArn)(_.bucketAccessRoleArn(_))
        .build

    def smbMountOptions(
      version: Option[String] = None
    ): SmbMountOptions =
      SmbMountOptions
        .builder
        .ifSome(version)(_.version(_))
        .build

    def startTaskExecutionRequest(
      taskArn: Option[String] = None,
      overrideOptions: Option[Options] = None,
      includes: Option[List[FilterRule]] = None
    ): StartTaskExecutionRequest =
      StartTaskExecutionRequest
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(overrideOptions)(_.overrideOptions(_))
        .ifSome(includes)(_.includes(_))
        .build

    def startTaskExecutionResponse(
      taskExecutionArn: Option[String] = None
    ): StartTaskExecutionResponse =
      StartTaskExecutionResponse
        .builder
        .ifSome(taskExecutionArn)(_.taskExecutionArn(_))
        .build

    def tagListEntry(
      key: Option[String] = None,
      value: Option[String] = None
    ): TagListEntry =
      TagListEntry
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[TagListEntry]] = None
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

    def taskExecutionListEntry(
      taskExecutionArn: Option[String] = None,
      status: Option[String] = None
    ): TaskExecutionListEntry =
      TaskExecutionListEntry
        .builder
        .ifSome(taskExecutionArn)(_.taskExecutionArn(_))
        .ifSome(status)(_.status(_))
        .build

    def taskExecutionResultDetail(
      prepareDuration: Option[Duration] = None,
      prepareStatus: Option[String] = None,
      totalDuration: Option[Duration] = None,
      transferDuration: Option[Duration] = None,
      transferStatus: Option[String] = None,
      verifyDuration: Option[Duration] = None,
      verifyStatus: Option[String] = None,
      errorCode: Option[String] = None,
      errorDetail: Option[String] = None
    ): TaskExecutionResultDetail =
      TaskExecutionResultDetail
        .builder
        .ifSome(prepareDuration)(_.prepareDuration(_))
        .ifSome(prepareStatus)(_.prepareStatus(_))
        .ifSome(totalDuration)(_.totalDuration(_))
        .ifSome(transferDuration)(_.transferDuration(_))
        .ifSome(transferStatus)(_.transferStatus(_))
        .ifSome(verifyDuration)(_.verifyDuration(_))
        .ifSome(verifyStatus)(_.verifyStatus(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorDetail)(_.errorDetail(_))
        .build

    def taskFilter(
      name: Option[String] = None,
      values: Option[List[FilterAttributeValue]] = None,
      operator: Option[String] = None
    ): TaskFilter =
      TaskFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def taskListEntry(
      taskArn: Option[String] = None,
      status: Option[String] = None,
      name: Option[String] = None
    ): TaskListEntry =
      TaskListEntry
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(name)(_.name(_))
        .build

    def taskSchedule(
      scheduleExpression: Option[String] = None
    ): TaskSchedule =
      TaskSchedule
        .builder
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      keys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(keys)(_.keys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateAgentRequest(
      agentArn: Option[String] = None,
      name: Option[String] = None
    ): UpdateAgentRequest =
      UpdateAgentRequest
        .builder
        .ifSome(agentArn)(_.agentArn(_))
        .ifSome(name)(_.name(_))
        .build

    def updateAgentResponse(

    ): UpdateAgentResponse =
      UpdateAgentResponse
        .builder

        .build

    def updateLocationNfsRequest(
      locationArn: Option[String] = None,
      subdirectory: Option[String] = None,
      onPremConfig: Option[OnPremConfig] = None,
      mountOptions: Option[NfsMountOptions] = None
    ): UpdateLocationNfsRequest =
      UpdateLocationNfsRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(onPremConfig)(_.onPremConfig(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .build

    def updateLocationNfsResponse(

    ): UpdateLocationNfsResponse =
      UpdateLocationNfsResponse
        .builder

        .build

    def updateLocationObjectStorageRequest(
      locationArn: Option[String] = None,
      serverPort: Option[Int] = None,
      serverProtocol: Option[String] = None,
      subdirectory: Option[String] = None,
      accessKey: Option[String] = None,
      secretKey: Option[String] = None,
      agentArns: Option[List[AgentArn]] = None
    ): UpdateLocationObjectStorageRequest =
      UpdateLocationObjectStorageRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(serverPort)(_.serverPort(_))
        .ifSome(serverProtocol)(_.serverProtocol(_))
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(accessKey)(_.accessKey(_))
        .ifSome(secretKey)(_.secretKey(_))
        .ifSome(agentArns)(_.agentArns(_))
        .build

    def updateLocationObjectStorageResponse(

    ): UpdateLocationObjectStorageResponse =
      UpdateLocationObjectStorageResponse
        .builder

        .build

    def updateLocationSmbRequest(
      locationArn: Option[String] = None,
      subdirectory: Option[String] = None,
      user: Option[String] = None,
      domain: Option[String] = None,
      password: Option[String] = None,
      agentArns: Option[List[AgentArn]] = None,
      mountOptions: Option[SmbMountOptions] = None
    ): UpdateLocationSmbRequest =
      UpdateLocationSmbRequest
        .builder
        .ifSome(locationArn)(_.locationArn(_))
        .ifSome(subdirectory)(_.subdirectory(_))
        .ifSome(user)(_.user(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(password)(_.password(_))
        .ifSome(agentArns)(_.agentArns(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .build

    def updateLocationSmbResponse(

    ): UpdateLocationSmbResponse =
      UpdateLocationSmbResponse
        .builder

        .build

    def updateTaskExecutionRequest(
      taskExecutionArn: Option[String] = None,
      options: Option[Options] = None
    ): UpdateTaskExecutionRequest =
      UpdateTaskExecutionRequest
        .builder
        .ifSome(taskExecutionArn)(_.taskExecutionArn(_))
        .ifSome(options)(_.options(_))
        .build

    def updateTaskExecutionResponse(

    ): UpdateTaskExecutionResponse =
      UpdateTaskExecutionResponse
        .builder

        .build

    def updateTaskRequest(
      taskArn: Option[String] = None,
      options: Option[Options] = None,
      excludes: Option[List[FilterRule]] = None,
      schedule: Option[TaskSchedule] = None,
      name: Option[String] = None,
      cloudWatchLogGroupArn: Option[String] = None
    ): UpdateTaskRequest =
      UpdateTaskRequest
        .builder
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(options)(_.options(_))
        .ifSome(excludes)(_.excludes(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(name)(_.name(_))
        .ifSome(cloudWatchLogGroupArn)(_.cloudWatchLogGroupArn(_))
        .build

    def updateTaskResponse(

    ): UpdateTaskResponse =
      UpdateTaskResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
