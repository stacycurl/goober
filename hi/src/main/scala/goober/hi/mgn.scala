package goober.hi

import goober.free.mgn.MgnIO
import software.amazon.awssdk.services.mgn.model._


object mgn {
  import goober.free.{mgn ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      code: Option[String] = None,
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def cPU(
      cores: Option[PositiveInteger] = None,
      modelName: Option[String] = None
    ): CPU =
      CPU
        .builder
        .ifSome(cores)(_.cores(_))
        .ifSome(modelName)(_.modelName(_))
        .build

    def changeServerLifeCycleStateRequest(
      lifeCycle: Option[ChangeServerLifeCycleStateSourceServerLifecycle] = None,
      sourceServerID: Option[String] = None
    ): ChangeServerLifeCycleStateRequest =
      ChangeServerLifeCycleStateRequest
        .builder
        .ifSome(lifeCycle)(_.lifeCycle(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def changeServerLifeCycleStateSourceServerLifecycle(
      state: Option[String] = None
    ): ChangeServerLifeCycleStateSourceServerLifecycle =
      ChangeServerLifeCycleStateSourceServerLifecycle
        .builder
        .ifSome(state)(_.state(_))
        .build

    def conflictException(
      code: Option[String] = None,
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def createReplicationConfigurationTemplateRequest(
      associateDefaultSecurityGroup: Option[Boolean] = None,
      bandwidthThrottling: Option[PositiveInteger] = None,
      createPublicIP: Option[Boolean] = None,
      dataPlaneRouting: Option[String] = None,
      defaultLargeStagingDiskType: Option[String] = None,
      ebsEncryption: Option[String] = None,
      ebsEncryptionKeyArn: Option[String] = None,
      replicationServerInstanceType: Option[String] = None,
      replicationServersSecurityGroupsIDs: Option[List[SecurityGroupID]] = None,
      stagingAreaSubnetId: Option[String] = None,
      stagingAreaTags: Option[TagsMap] = None,
      tags: Option[TagsMap] = None,
      useDedicatedReplicationServer: Option[Boolean] = None
    ): CreateReplicationConfigurationTemplateRequest =
      CreateReplicationConfigurationTemplateRequest
        .builder
        .ifSome(associateDefaultSecurityGroup)(_.associateDefaultSecurityGroup(_))
        .ifSome(bandwidthThrottling)(_.bandwidthThrottling(_))
        .ifSome(createPublicIP)(_.createPublicIP(_))
        .ifSome(dataPlaneRouting)(_.dataPlaneRouting(_))
        .ifSome(defaultLargeStagingDiskType)(_.defaultLargeStagingDiskType(_))
        .ifSome(ebsEncryption)(_.ebsEncryption(_))
        .ifSome(ebsEncryptionKeyArn)(_.ebsEncryptionKeyArn(_))
        .ifSome(replicationServerInstanceType)(_.replicationServerInstanceType(_))
        .ifSome(replicationServersSecurityGroupsIDs)(_.replicationServersSecurityGroupsIDs(_))
        .ifSome(stagingAreaSubnetId)(_.stagingAreaSubnetId(_))
        .ifSome(stagingAreaTags)(_.stagingAreaTags(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(useDedicatedReplicationServer)(_.useDedicatedReplicationServer(_))
        .build

    def dataReplicationError(
      error: Option[String] = None,
      rawError: Option[String] = None
    ): DataReplicationError =
      DataReplicationError
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(rawError)(_.rawError(_))
        .build

    def dataReplicationInfo(
      dataReplicationError: Option[DataReplicationError] = None,
      dataReplicationInitiation: Option[DataReplicationInitiation] = None,
      dataReplicationState: Option[String] = None,
      etaDateTime: Option[String] = None,
      lagDuration: Option[String] = None,
      replicatedDisks: Option[List[DataReplicationInfoReplicatedDisk]] = None
    ): DataReplicationInfo =
      DataReplicationInfo
        .builder
        .ifSome(dataReplicationError)(_.dataReplicationError(_))
        .ifSome(dataReplicationInitiation)(_.dataReplicationInitiation(_))
        .ifSome(dataReplicationState)(_.dataReplicationState(_))
        .ifSome(etaDateTime)(_.etaDateTime(_))
        .ifSome(lagDuration)(_.lagDuration(_))
        .ifSome(replicatedDisks)(_.replicatedDisks(_))
        .build

    def dataReplicationInfoReplicatedDisk(
      backloggedStorageBytes: Option[PositiveInteger] = None,
      deviceName: Option[String] = None,
      replicatedStorageBytes: Option[PositiveInteger] = None,
      rescannedStorageBytes: Option[PositiveInteger] = None,
      totalStorageBytes: Option[PositiveInteger] = None
    ): DataReplicationInfoReplicatedDisk =
      DataReplicationInfoReplicatedDisk
        .builder
        .ifSome(backloggedStorageBytes)(_.backloggedStorageBytes(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(replicatedStorageBytes)(_.replicatedStorageBytes(_))
        .ifSome(rescannedStorageBytes)(_.rescannedStorageBytes(_))
        .ifSome(totalStorageBytes)(_.totalStorageBytes(_))
        .build

    def dataReplicationInitiation(
      nextAttemptDateTime: Option[String] = None,
      startDateTime: Option[String] = None,
      steps: Option[List[DataReplicationInitiationStep]] = None
    ): DataReplicationInitiation =
      DataReplicationInitiation
        .builder
        .ifSome(nextAttemptDateTime)(_.nextAttemptDateTime(_))
        .ifSome(startDateTime)(_.startDateTime(_))
        .ifSome(steps)(_.steps(_))
        .build

    def dataReplicationInitiationStep(
      name: Option[String] = None,
      status: Option[String] = None
    ): DataReplicationInitiationStep =
      DataReplicationInitiationStep
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteJobRequest(
      jobID: Option[String] = None
    ): DeleteJobRequest =
      DeleteJobRequest
        .builder
        .ifSome(jobID)(_.jobID(_))
        .build

    def deleteJobResponse(

    ): DeleteJobResponse =
      DeleteJobResponse
        .builder

        .build

    def deleteReplicationConfigurationTemplateRequest(
      replicationConfigurationTemplateID: Option[String] = None
    ): DeleteReplicationConfigurationTemplateRequest =
      DeleteReplicationConfigurationTemplateRequest
        .builder
        .ifSome(replicationConfigurationTemplateID)(_.replicationConfigurationTemplateID(_))
        .build

    def deleteReplicationConfigurationTemplateResponse(

    ): DeleteReplicationConfigurationTemplateResponse =
      DeleteReplicationConfigurationTemplateResponse
        .builder

        .build

    def deleteSourceServerRequest(
      sourceServerID: Option[String] = None
    ): DeleteSourceServerRequest =
      DeleteSourceServerRequest
        .builder
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def deleteSourceServerResponse(

    ): DeleteSourceServerResponse =
      DeleteSourceServerResponse
        .builder

        .build

    def describeJobLogItemsRequest(
      jobID: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeJobLogItemsRequest =
      DescribeJobLogItemsRequest
        .builder
        .ifSome(jobID)(_.jobID(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobLogItemsResponse(
      items: Option[List[JobLog]] = None,
      nextToken: Option[String] = None
    ): DescribeJobLogItemsResponse =
      DescribeJobLogItemsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobsRequest(
      filters: Option[DescribeJobsRequestFilters] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeJobsRequest =
      DescribeJobsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeJobsRequestFilters(
      fromDate: Option[String] = None,
      jobIDs: Option[List[JobID]] = None,
      toDate: Option[String] = None
    ): DescribeJobsRequestFilters =
      DescribeJobsRequestFilters
        .builder
        .ifSome(fromDate)(_.fromDate(_))
        .ifSome(jobIDs)(_.jobIDs(_))
        .ifSome(toDate)(_.toDate(_))
        .build

    def describeJobsResponse(
      items: Option[List[Job]] = None,
      nextToken: Option[String] = None
    ): DescribeJobsResponse =
      DescribeJobsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeReplicationConfigurationTemplatesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      replicationConfigurationTemplateIDs: Option[List[ReplicationConfigurationTemplateID]] = None
    ): DescribeReplicationConfigurationTemplatesRequest =
      DescribeReplicationConfigurationTemplatesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(replicationConfigurationTemplateIDs)(_.replicationConfigurationTemplateIDs(_))
        .build

    def describeReplicationConfigurationTemplatesResponse(
      items: Option[List[ReplicationConfigurationTemplate]] = None,
      nextToken: Option[String] = None
    ): DescribeReplicationConfigurationTemplatesResponse =
      DescribeReplicationConfigurationTemplatesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSourceServersRequest(
      filters: Option[DescribeSourceServersRequestFilters] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeSourceServersRequest =
      DescribeSourceServersRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSourceServersRequestFilters(
      isArchived: Option[Boolean] = None,
      sourceServerIDs: Option[List[SourceServerID]] = None
    ): DescribeSourceServersRequestFilters =
      DescribeSourceServersRequestFilters
        .builder
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(sourceServerIDs)(_.sourceServerIDs(_))
        .build

    def describeSourceServersResponse(
      items: Option[List[SourceServer]] = None,
      nextToken: Option[String] = None
    ): DescribeSourceServersResponse =
      DescribeSourceServersResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def disconnectFromServiceRequest(
      sourceServerID: Option[String] = None
    ): DisconnectFromServiceRequest =
      DisconnectFromServiceRequest
        .builder
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def disk(
      bytes: Option[PositiveInteger] = None,
      deviceName: Option[String] = None
    ): Disk =
      Disk
        .builder
        .ifSome(bytes)(_.bytes(_))
        .ifSome(deviceName)(_.deviceName(_))
        .build

    def finalizeCutoverRequest(
      sourceServerID: Option[String] = None
    ): FinalizeCutoverRequest =
      FinalizeCutoverRequest
        .builder
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def getLaunchConfigurationRequest(
      sourceServerID: Option[String] = None
    ): GetLaunchConfigurationRequest =
      GetLaunchConfigurationRequest
        .builder
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def getReplicationConfigurationRequest(
      sourceServerID: Option[String] = None
    ): GetReplicationConfigurationRequest =
      GetReplicationConfigurationRequest
        .builder
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def identificationHints(
      awsInstanceID: Option[String] = None,
      fqdn: Option[String] = None,
      hostname: Option[String] = None,
      vmWareUuid: Option[String] = None
    ): IdentificationHints =
      IdentificationHints
        .builder
        .ifSome(awsInstanceID)(_.awsInstanceID(_))
        .ifSome(fqdn)(_.fqdn(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(vmWareUuid)(_.vmWareUuid(_))
        .build

    def initializeServiceRequest(

    ): InitializeServiceRequest =
      InitializeServiceRequest
        .builder

        .build

    def initializeServiceResponse(

    ): InitializeServiceResponse =
      InitializeServiceResponse
        .builder

        .build

    def internalServerException(
      message: Option[String] = None,
      retryAfterSeconds: Option[PositiveInteger] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def job(
      arn: Option[String] = None,
      creationDateTime: Option[String] = None,
      endDateTime: Option[String] = None,
      initiatedBy: Option[String] = None,
      jobID: Option[String] = None,
      participatingServers: Option[List[ParticipatingServer]] = None,
      status: Option[String] = None,
      tags: Option[TagsMap] = None,
      `type`: Option[String] = None
    ): Job =
      Job
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .ifSome(initiatedBy)(_.initiatedBy(_))
        .ifSome(jobID)(_.jobID(_))
        .ifSome(participatingServers)(_.participatingServers(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def jobLog(
      event: Option[String] = None,
      eventData: Option[JobLogEventData] = None,
      logDateTime: Option[String] = None
    ): JobLog =
      JobLog
        .builder
        .ifSome(event)(_.event(_))
        .ifSome(eventData)(_.eventData(_))
        .ifSome(logDateTime)(_.logDateTime(_))
        .build

    def jobLogEventData(
      conversionServerID: Option[String] = None,
      rawError: Option[String] = None,
      sourceServerID: Option[String] = None,
      targetInstanceID: Option[String] = None
    ): JobLogEventData =
      JobLogEventData
        .builder
        .ifSome(conversionServerID)(_.conversionServerID(_))
        .ifSome(rawError)(_.rawError(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .ifSome(targetInstanceID)(_.targetInstanceID(_))
        .build

    def launchConfiguration(
      copyPrivateIp: Option[Boolean] = None,
      copyTags: Option[Boolean] = None,
      ec2LaunchTemplateID: Option[String] = None,
      launchDisposition: Option[String] = None,
      licensing: Option[Licensing] = None,
      name: Option[String] = None,
      sourceServerID: Option[String] = None,
      targetInstanceTypeRightSizingMethod: Option[String] = None
    ): LaunchConfiguration =
      LaunchConfiguration
        .builder
        .ifSome(copyPrivateIp)(_.copyPrivateIp(_))
        .ifSome(copyTags)(_.copyTags(_))
        .ifSome(ec2LaunchTemplateID)(_.ec2LaunchTemplateID(_))
        .ifSome(launchDisposition)(_.launchDisposition(_))
        .ifSome(licensing)(_.licensing(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .ifSome(targetInstanceTypeRightSizingMethod)(_.targetInstanceTypeRightSizingMethod(_))
        .build

    def launchedInstance(
      ec2InstanceID: Option[String] = None,
      firstBoot: Option[String] = None,
      jobID: Option[String] = None
    ): LaunchedInstance =
      LaunchedInstance
        .builder
        .ifSome(ec2InstanceID)(_.ec2InstanceID(_))
        .ifSome(firstBoot)(_.firstBoot(_))
        .ifSome(jobID)(_.jobID(_))
        .build

    def licensing(
      osByol: Option[Boolean] = None
    ): Licensing =
      Licensing
        .builder
        .ifSome(osByol)(_.osByol(_))
        .build

    def lifeCycle(
      addedToServiceDateTime: Option[String] = None,
      elapsedReplicationDuration: Option[String] = None,
      firstByteDateTime: Option[String] = None,
      lastCutover: Option[LifeCycleLastCutover] = None,
      lastSeenByServiceDateTime: Option[String] = None,
      lastTest: Option[LifeCycleLastTest] = None,
      state: Option[String] = None
    ): LifeCycle =
      LifeCycle
        .builder
        .ifSome(addedToServiceDateTime)(_.addedToServiceDateTime(_))
        .ifSome(elapsedReplicationDuration)(_.elapsedReplicationDuration(_))
        .ifSome(firstByteDateTime)(_.firstByteDateTime(_))
        .ifSome(lastCutover)(_.lastCutover(_))
        .ifSome(lastSeenByServiceDateTime)(_.lastSeenByServiceDateTime(_))
        .ifSome(lastTest)(_.lastTest(_))
        .ifSome(state)(_.state(_))
        .build

    def lifeCycleLastCutover(
      finalized: Option[LifeCycleLastCutoverFinalized] = None,
      initiated: Option[LifeCycleLastCutoverInitiated] = None,
      reverted: Option[LifeCycleLastCutoverReverted] = None
    ): LifeCycleLastCutover =
      LifeCycleLastCutover
        .builder
        .ifSome(finalized)(_.finalized(_))
        .ifSome(initiated)(_.initiated(_))
        .ifSome(reverted)(_.reverted(_))
        .build

    def lifeCycleLastCutoverFinalized(
      apiCallDateTime: Option[String] = None
    ): LifeCycleLastCutoverFinalized =
      LifeCycleLastCutoverFinalized
        .builder
        .ifSome(apiCallDateTime)(_.apiCallDateTime(_))
        .build

    def lifeCycleLastCutoverInitiated(
      apiCallDateTime: Option[String] = None,
      jobID: Option[String] = None
    ): LifeCycleLastCutoverInitiated =
      LifeCycleLastCutoverInitiated
        .builder
        .ifSome(apiCallDateTime)(_.apiCallDateTime(_))
        .ifSome(jobID)(_.jobID(_))
        .build

    def lifeCycleLastCutoverReverted(
      apiCallDateTime: Option[String] = None
    ): LifeCycleLastCutoverReverted =
      LifeCycleLastCutoverReverted
        .builder
        .ifSome(apiCallDateTime)(_.apiCallDateTime(_))
        .build

    def lifeCycleLastTest(
      finalized: Option[LifeCycleLastTestFinalized] = None,
      initiated: Option[LifeCycleLastTestInitiated] = None,
      reverted: Option[LifeCycleLastTestReverted] = None
    ): LifeCycleLastTest =
      LifeCycleLastTest
        .builder
        .ifSome(finalized)(_.finalized(_))
        .ifSome(initiated)(_.initiated(_))
        .ifSome(reverted)(_.reverted(_))
        .build

    def lifeCycleLastTestFinalized(
      apiCallDateTime: Option[String] = None
    ): LifeCycleLastTestFinalized =
      LifeCycleLastTestFinalized
        .builder
        .ifSome(apiCallDateTime)(_.apiCallDateTime(_))
        .build

    def lifeCycleLastTestInitiated(
      apiCallDateTime: Option[String] = None,
      jobID: Option[String] = None
    ): LifeCycleLastTestInitiated =
      LifeCycleLastTestInitiated
        .builder
        .ifSome(apiCallDateTime)(_.apiCallDateTime(_))
        .ifSome(jobID)(_.jobID(_))
        .build

    def lifeCycleLastTestReverted(
      apiCallDateTime: Option[String] = None
    ): LifeCycleLastTestReverted =
      LifeCycleLastTestReverted
        .builder
        .ifSome(apiCallDateTime)(_.apiCallDateTime(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagsMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def markAsArchivedRequest(
      sourceServerID: Option[String] = None
    ): MarkAsArchivedRequest =
      MarkAsArchivedRequest
        .builder
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def networkInterface(
      ips: Option[List[BoundedString]] = None,
      isPrimary: Option[Boolean] = None,
      macAddress: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(ips)(_.ips(_))
        .ifSome(isPrimary)(_.isPrimary(_))
        .ifSome(macAddress)(_.macAddress(_))
        .build

    def oS(
      fullString: Option[String] = None
    ): OS =
      OS
        .builder
        .ifSome(fullString)(_.fullString(_))
        .build

    def participatingServer(
      launchStatus: Option[String] = None,
      sourceServerID: Option[String] = None
    ): ParticipatingServer =
      ParticipatingServer
        .builder
        .ifSome(launchStatus)(_.launchStatus(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def replicationConfiguration(
      associateDefaultSecurityGroup: Option[Boolean] = None,
      bandwidthThrottling: Option[PositiveInteger] = None,
      createPublicIP: Option[Boolean] = None,
      dataPlaneRouting: Option[String] = None,
      defaultLargeStagingDiskType: Option[String] = None,
      ebsEncryption: Option[String] = None,
      ebsEncryptionKeyArn: Option[String] = None,
      name: Option[String] = None,
      replicatedDisks: Option[List[ReplicationConfigurationReplicatedDisk]] = None,
      replicationServerInstanceType: Option[String] = None,
      replicationServersSecurityGroupsIDs: Option[List[SecurityGroupID]] = None,
      sourceServerID: Option[String] = None,
      stagingAreaSubnetId: Option[String] = None,
      stagingAreaTags: Option[TagsMap] = None,
      useDedicatedReplicationServer: Option[Boolean] = None
    ): ReplicationConfiguration =
      ReplicationConfiguration
        .builder
        .ifSome(associateDefaultSecurityGroup)(_.associateDefaultSecurityGroup(_))
        .ifSome(bandwidthThrottling)(_.bandwidthThrottling(_))
        .ifSome(createPublicIP)(_.createPublicIP(_))
        .ifSome(dataPlaneRouting)(_.dataPlaneRouting(_))
        .ifSome(defaultLargeStagingDiskType)(_.defaultLargeStagingDiskType(_))
        .ifSome(ebsEncryption)(_.ebsEncryption(_))
        .ifSome(ebsEncryptionKeyArn)(_.ebsEncryptionKeyArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(replicatedDisks)(_.replicatedDisks(_))
        .ifSome(replicationServerInstanceType)(_.replicationServerInstanceType(_))
        .ifSome(replicationServersSecurityGroupsIDs)(_.replicationServersSecurityGroupsIDs(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .ifSome(stagingAreaSubnetId)(_.stagingAreaSubnetId(_))
        .ifSome(stagingAreaTags)(_.stagingAreaTags(_))
        .ifSome(useDedicatedReplicationServer)(_.useDedicatedReplicationServer(_))
        .build

    def replicationConfigurationReplicatedDisk(
      deviceName: Option[String] = None,
      iops: Option[PositiveInteger] = None,
      isBootDisk: Option[Boolean] = None,
      stagingDiskType: Option[String] = None
    ): ReplicationConfigurationReplicatedDisk =
      ReplicationConfigurationReplicatedDisk
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(isBootDisk)(_.isBootDisk(_))
        .ifSome(stagingDiskType)(_.stagingDiskType(_))
        .build

    def replicationConfigurationTemplate(
      arn: Option[String] = None,
      associateDefaultSecurityGroup: Option[Boolean] = None,
      bandwidthThrottling: Option[PositiveInteger] = None,
      createPublicIP: Option[Boolean] = None,
      dataPlaneRouting: Option[String] = None,
      defaultLargeStagingDiskType: Option[String] = None,
      ebsEncryption: Option[String] = None,
      ebsEncryptionKeyArn: Option[String] = None,
      replicationConfigurationTemplateID: Option[String] = None,
      replicationServerInstanceType: Option[String] = None,
      replicationServersSecurityGroupsIDs: Option[List[SecurityGroupID]] = None,
      stagingAreaSubnetId: Option[String] = None,
      stagingAreaTags: Option[TagsMap] = None,
      tags: Option[TagsMap] = None,
      useDedicatedReplicationServer: Option[Boolean] = None
    ): ReplicationConfigurationTemplate =
      ReplicationConfigurationTemplate
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(associateDefaultSecurityGroup)(_.associateDefaultSecurityGroup(_))
        .ifSome(bandwidthThrottling)(_.bandwidthThrottling(_))
        .ifSome(createPublicIP)(_.createPublicIP(_))
        .ifSome(dataPlaneRouting)(_.dataPlaneRouting(_))
        .ifSome(defaultLargeStagingDiskType)(_.defaultLargeStagingDiskType(_))
        .ifSome(ebsEncryption)(_.ebsEncryption(_))
        .ifSome(ebsEncryptionKeyArn)(_.ebsEncryptionKeyArn(_))
        .ifSome(replicationConfigurationTemplateID)(_.replicationConfigurationTemplateID(_))
        .ifSome(replicationServerInstanceType)(_.replicationServerInstanceType(_))
        .ifSome(replicationServersSecurityGroupsIDs)(_.replicationServersSecurityGroupsIDs(_))
        .ifSome(stagingAreaSubnetId)(_.stagingAreaSubnetId(_))
        .ifSome(stagingAreaTags)(_.stagingAreaTags(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(useDedicatedReplicationServer)(_.useDedicatedReplicationServer(_))
        .build

    def resourceNotFoundException(
      code: Option[String] = None,
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def retryDataReplicationRequest(
      sourceServerID: Option[String] = None
    ): RetryDataReplicationRequest =
      RetryDataReplicationRequest
        .builder
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .build

    def sourceProperties(
      cpus: Option[List[CPU]] = None,
      disks: Option[List[Disk]] = None,
      identificationHints: Option[IdentificationHints] = None,
      lastUpdatedDateTime: Option[String] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None,
      os: Option[OS] = None,
      ramBytes: Option[PositiveInteger] = None,
      recommendedInstanceType: Option[String] = None
    ): SourceProperties =
      SourceProperties
        .builder
        .ifSome(cpus)(_.cpus(_))
        .ifSome(disks)(_.disks(_))
        .ifSome(identificationHints)(_.identificationHints(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(os)(_.os(_))
        .ifSome(ramBytes)(_.ramBytes(_))
        .ifSome(recommendedInstanceType)(_.recommendedInstanceType(_))
        .build

    def sourceServer(
      arn: Option[String] = None,
      dataReplicationInfo: Option[DataReplicationInfo] = None,
      isArchived: Option[Boolean] = None,
      launchedInstance: Option[LaunchedInstance] = None,
      lifeCycle: Option[LifeCycle] = None,
      sourceProperties: Option[SourceProperties] = None,
      sourceServerID: Option[String] = None,
      tags: Option[TagsMap] = None
    ): SourceServer =
      SourceServer
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataReplicationInfo)(_.dataReplicationInfo(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(launchedInstance)(_.launchedInstance(_))
        .ifSome(lifeCycle)(_.lifeCycle(_))
        .ifSome(sourceProperties)(_.sourceProperties(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startCutoverRequest(
      sourceServerIDs: Option[List[SourceServerID]] = None,
      tags: Option[TagsMap] = None
    ): StartCutoverRequest =
      StartCutoverRequest
        .builder
        .ifSome(sourceServerIDs)(_.sourceServerIDs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startCutoverResponse(
      job: Option[Job] = None
    ): StartCutoverResponse =
      StartCutoverResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def startTestRequest(
      sourceServerIDs: Option[List[SourceServerID]] = None,
      tags: Option[TagsMap] = None
    ): StartTestRequest =
      StartTestRequest
        .builder
        .ifSome(sourceServerIDs)(_.sourceServerIDs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startTestResponse(
      job: Option[Job] = None
    ): StartTestResponse =
      StartTestResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagsMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def terminateTargetInstancesRequest(
      sourceServerIDs: Option[List[SourceServerID]] = None,
      tags: Option[TagsMap] = None
    ): TerminateTargetInstancesRequest =
      TerminateTargetInstancesRequest
        .builder
        .ifSome(sourceServerIDs)(_.sourceServerIDs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def terminateTargetInstancesResponse(
      job: Option[Job] = None
    ): TerminateTargetInstancesResponse =
      TerminateTargetInstancesResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      retryAfterSeconds: Option[String] = None,
      serviceCode: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def uninitializedAccountException(
      code: Option[String] = None,
      message: Option[String] = None
    ): UninitializedAccountException =
      UninitializedAccountException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
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

    def updateLaunchConfigurationRequest(
      copyPrivateIp: Option[Boolean] = None,
      copyTags: Option[Boolean] = None,
      launchDisposition: Option[String] = None,
      licensing: Option[Licensing] = None,
      name: Option[String] = None,
      sourceServerID: Option[String] = None,
      targetInstanceTypeRightSizingMethod: Option[String] = None
    ): UpdateLaunchConfigurationRequest =
      UpdateLaunchConfigurationRequest
        .builder
        .ifSome(copyPrivateIp)(_.copyPrivateIp(_))
        .ifSome(copyTags)(_.copyTags(_))
        .ifSome(launchDisposition)(_.launchDisposition(_))
        .ifSome(licensing)(_.licensing(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .ifSome(targetInstanceTypeRightSizingMethod)(_.targetInstanceTypeRightSizingMethod(_))
        .build

    def updateReplicationConfigurationRequest(
      associateDefaultSecurityGroup: Option[Boolean] = None,
      bandwidthThrottling: Option[PositiveInteger] = None,
      createPublicIP: Option[Boolean] = None,
      dataPlaneRouting: Option[String] = None,
      defaultLargeStagingDiskType: Option[String] = None,
      ebsEncryption: Option[String] = None,
      ebsEncryptionKeyArn: Option[String] = None,
      name: Option[String] = None,
      replicatedDisks: Option[List[ReplicationConfigurationReplicatedDisk]] = None,
      replicationServerInstanceType: Option[String] = None,
      replicationServersSecurityGroupsIDs: Option[List[SecurityGroupID]] = None,
      sourceServerID: Option[String] = None,
      stagingAreaSubnetId: Option[String] = None,
      stagingAreaTags: Option[TagsMap] = None,
      useDedicatedReplicationServer: Option[Boolean] = None
    ): UpdateReplicationConfigurationRequest =
      UpdateReplicationConfigurationRequest
        .builder
        .ifSome(associateDefaultSecurityGroup)(_.associateDefaultSecurityGroup(_))
        .ifSome(bandwidthThrottling)(_.bandwidthThrottling(_))
        .ifSome(createPublicIP)(_.createPublicIP(_))
        .ifSome(dataPlaneRouting)(_.dataPlaneRouting(_))
        .ifSome(defaultLargeStagingDiskType)(_.defaultLargeStagingDiskType(_))
        .ifSome(ebsEncryption)(_.ebsEncryption(_))
        .ifSome(ebsEncryptionKeyArn)(_.ebsEncryptionKeyArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(replicatedDisks)(_.replicatedDisks(_))
        .ifSome(replicationServerInstanceType)(_.replicationServerInstanceType(_))
        .ifSome(replicationServersSecurityGroupsIDs)(_.replicationServersSecurityGroupsIDs(_))
        .ifSome(sourceServerID)(_.sourceServerID(_))
        .ifSome(stagingAreaSubnetId)(_.stagingAreaSubnetId(_))
        .ifSome(stagingAreaTags)(_.stagingAreaTags(_))
        .ifSome(useDedicatedReplicationServer)(_.useDedicatedReplicationServer(_))
        .build

    def updateReplicationConfigurationTemplateRequest(
      arn: Option[String] = None,
      associateDefaultSecurityGroup: Option[Boolean] = None,
      bandwidthThrottling: Option[PositiveInteger] = None,
      createPublicIP: Option[Boolean] = None,
      dataPlaneRouting: Option[String] = None,
      defaultLargeStagingDiskType: Option[String] = None,
      ebsEncryption: Option[String] = None,
      ebsEncryptionKeyArn: Option[String] = None,
      replicationConfigurationTemplateID: Option[String] = None,
      replicationServerInstanceType: Option[String] = None,
      replicationServersSecurityGroupsIDs: Option[List[SecurityGroupID]] = None,
      stagingAreaSubnetId: Option[String] = None,
      stagingAreaTags: Option[TagsMap] = None,
      useDedicatedReplicationServer: Option[Boolean] = None
    ): UpdateReplicationConfigurationTemplateRequest =
      UpdateReplicationConfigurationTemplateRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(associateDefaultSecurityGroup)(_.associateDefaultSecurityGroup(_))
        .ifSome(bandwidthThrottling)(_.bandwidthThrottling(_))
        .ifSome(createPublicIP)(_.createPublicIP(_))
        .ifSome(dataPlaneRouting)(_.dataPlaneRouting(_))
        .ifSome(defaultLargeStagingDiskType)(_.defaultLargeStagingDiskType(_))
        .ifSome(ebsEncryption)(_.ebsEncryption(_))
        .ifSome(ebsEncryptionKeyArn)(_.ebsEncryptionKeyArn(_))
        .ifSome(replicationConfigurationTemplateID)(_.replicationConfigurationTemplateID(_))
        .ifSome(replicationServerInstanceType)(_.replicationServerInstanceType(_))
        .ifSome(replicationServersSecurityGroupsIDs)(_.replicationServersSecurityGroupsIDs(_))
        .ifSome(stagingAreaSubnetId)(_.stagingAreaSubnetId(_))
        .ifSome(stagingAreaTags)(_.stagingAreaTags(_))
        .ifSome(useDedicatedReplicationServer)(_.useDedicatedReplicationServer(_))
        .build

    def validationException(
      code: Option[String] = None,
      fieldList: Option[List[ValidationExceptionField]] = None,
      message: Option[String] = None,
      reason: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(fieldList)(_.fieldList(_))
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def validationExceptionField(
      message: Option[String] = None,
      name: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(name)(_.name(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
