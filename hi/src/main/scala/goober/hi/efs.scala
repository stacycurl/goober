package goober.hi

import goober.free.efs.EfsIO
import software.amazon.awssdk.services.efs.model._


object efs {
  import goober.free.{efs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessPointAlreadyExists(
      errorCode: Option[String] = None,
      message: Option[String] = None,
      accessPointId: Option[String] = None
    ): AccessPointAlreadyExists =
      AccessPointAlreadyExists
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .ifSome(accessPointId)(_.accessPointId(_))
        .build

    def accessPointDescription(
      clientToken: Option[String] = None,
      name: Option[String] = None,
      tags: Option[List[Tag]] = None,
      accessPointId: Option[String] = None,
      accessPointArn: Option[String] = None,
      fileSystemId: Option[String] = None,
      posixUser: Option[PosixUser] = None,
      rootDirectory: Option[RootDirectory] = None,
      ownerId: Option[String] = None,
      lifeCycleState: Option[String] = None
    ): AccessPointDescription =
      AccessPointDescription
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(accessPointId)(_.accessPointId(_))
        .ifSome(accessPointArn)(_.accessPointArn(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(posixUser)(_.posixUser(_))
        .ifSome(rootDirectory)(_.rootDirectory(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(lifeCycleState)(_.lifeCycleState(_))
        .build

    def accessPointLimitExceeded(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): AccessPointLimitExceeded =
      AccessPointLimitExceeded
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def accessPointNotFound(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): AccessPointNotFound =
      AccessPointNotFound
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def availabilityZonesMismatch(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): AvailabilityZonesMismatch =
      AvailabilityZonesMismatch
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def backupPolicy(
      status: Option[String] = None
    ): BackupPolicy =
      BackupPolicy
        .builder
        .ifSome(status)(_.status(_))
        .build

    def backupPolicyDescription(
      backupPolicy: Option[BackupPolicy] = None
    ): BackupPolicyDescription =
      BackupPolicyDescription
        .builder
        .ifSome(backupPolicy)(_.backupPolicy(_))
        .build

    def badRequest(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): BadRequest =
      BadRequest
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def createAccessPointRequest(
      clientToken: Option[String] = None,
      tags: Option[List[Tag]] = None,
      fileSystemId: Option[String] = None,
      posixUser: Option[PosixUser] = None,
      rootDirectory: Option[RootDirectory] = None
    ): CreateAccessPointRequest =
      CreateAccessPointRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(posixUser)(_.posixUser(_))
        .ifSome(rootDirectory)(_.rootDirectory(_))
        .build

    def createFileSystemRequest(
      creationToken: Option[String] = None,
      performanceMode: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      throughputMode: Option[String] = None,
      provisionedThroughputInMibps: Option[ProvisionedThroughputInMibps] = None,
      availabilityZoneName: Option[String] = None,
      backup: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateFileSystemRequest =
      CreateFileSystemRequest
        .builder
        .ifSome(creationToken)(_.creationToken(_))
        .ifSome(performanceMode)(_.performanceMode(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(throughputMode)(_.throughputMode(_))
        .ifSome(provisionedThroughputInMibps)(_.provisionedThroughputInMibps(_))
        .ifSome(availabilityZoneName)(_.availabilityZoneName(_))
        .ifSome(backup)(_.backup(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMountTargetRequest(
      fileSystemId: Option[String] = None,
      subnetId: Option[String] = None,
      ipAddress: Option[String] = None,
      securityGroups: Option[List[SecurityGroup]] = None
    ): CreateMountTargetRequest =
      CreateMountTargetRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def createTagsRequest(
      fileSystemId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateTagsRequest =
      CreateTagsRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def creationInfo(
      ownerUid: Option[OwnerUid] = None,
      ownerGid: Option[OwnerGid] = None,
      permissions: Option[String] = None
    ): CreationInfo =
      CreationInfo
        .builder
        .ifSome(ownerUid)(_.ownerUid(_))
        .ifSome(ownerGid)(_.ownerGid(_))
        .ifSome(permissions)(_.permissions(_))
        .build

    def deleteAccessPointRequest(
      accessPointId: Option[String] = None
    ): DeleteAccessPointRequest =
      DeleteAccessPointRequest
        .builder
        .ifSome(accessPointId)(_.accessPointId(_))
        .build

    def deleteFileSystemPolicyRequest(
      fileSystemId: Option[String] = None
    ): DeleteFileSystemPolicyRequest =
      DeleteFileSystemPolicyRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def deleteFileSystemRequest(
      fileSystemId: Option[String] = None
    ): DeleteFileSystemRequest =
      DeleteFileSystemRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def deleteMountTargetRequest(
      mountTargetId: Option[String] = None
    ): DeleteMountTargetRequest =
      DeleteMountTargetRequest
        .builder
        .ifSome(mountTargetId)(_.mountTargetId(_))
        .build

    def deleteTagsRequest(
      fileSystemId: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): DeleteTagsRequest =
      DeleteTagsRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def dependencyTimeout(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): DependencyTimeout =
      DependencyTimeout
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def describeAccessPointsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      accessPointId: Option[String] = None,
      fileSystemId: Option[String] = None
    ): DescribeAccessPointsRequest =
      DescribeAccessPointsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(accessPointId)(_.accessPointId(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def describeAccessPointsResponse(
      accessPoints: Option[List[AccessPointDescription]] = None,
      nextToken: Option[String] = None
    ): DescribeAccessPointsResponse =
      DescribeAccessPointsResponse
        .builder
        .ifSome(accessPoints)(_.accessPoints(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAccountPreferencesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeAccountPreferencesRequest =
      DescribeAccountPreferencesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeAccountPreferencesResponse(
      resourceIdPreference: Option[ResourceIdPreference] = None,
      nextToken: Option[String] = None
    ): DescribeAccountPreferencesResponse =
      DescribeAccountPreferencesResponse
        .builder
        .ifSome(resourceIdPreference)(_.resourceIdPreference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBackupPolicyRequest(
      fileSystemId: Option[String] = None
    ): DescribeBackupPolicyRequest =
      DescribeBackupPolicyRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def describeFileSystemPolicyRequest(
      fileSystemId: Option[String] = None
    ): DescribeFileSystemPolicyRequest =
      DescribeFileSystemPolicyRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def describeFileSystemsRequest(
      maxItems: Option[Int] = None,
      marker: Option[String] = None,
      creationToken: Option[String] = None,
      fileSystemId: Option[String] = None
    ): DescribeFileSystemsRequest =
      DescribeFileSystemsRequest
        .builder
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(creationToken)(_.creationToken(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def describeFileSystemsResponse(
      marker: Option[String] = None,
      fileSystems: Option[List[FileSystemDescription]] = None,
      nextMarker: Option[String] = None
    ): DescribeFileSystemsResponse =
      DescribeFileSystemsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(fileSystems)(_.fileSystems(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeLifecycleConfigurationRequest(
      fileSystemId: Option[String] = None
    ): DescribeLifecycleConfigurationRequest =
      DescribeLifecycleConfigurationRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def describeMountTargetSecurityGroupsRequest(
      mountTargetId: Option[String] = None
    ): DescribeMountTargetSecurityGroupsRequest =
      DescribeMountTargetSecurityGroupsRequest
        .builder
        .ifSome(mountTargetId)(_.mountTargetId(_))
        .build

    def describeMountTargetSecurityGroupsResponse(
      securityGroups: Option[List[SecurityGroup]] = None
    ): DescribeMountTargetSecurityGroupsResponse =
      DescribeMountTargetSecurityGroupsResponse
        .builder
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def describeMountTargetsRequest(
      maxItems: Option[Int] = None,
      marker: Option[String] = None,
      fileSystemId: Option[String] = None,
      mountTargetId: Option[String] = None,
      accessPointId: Option[String] = None
    ): DescribeMountTargetsRequest =
      DescribeMountTargetsRequest
        .builder
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(mountTargetId)(_.mountTargetId(_))
        .ifSome(accessPointId)(_.accessPointId(_))
        .build

    def describeMountTargetsResponse(
      marker: Option[String] = None,
      mountTargets: Option[List[MountTargetDescription]] = None,
      nextMarker: Option[String] = None
    ): DescribeMountTargetsResponse =
      DescribeMountTargetsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(mountTargets)(_.mountTargets(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeTagsRequest(
      maxItems: Option[Int] = None,
      marker: Option[String] = None,
      fileSystemId: Option[String] = None
    ): DescribeTagsRequest =
      DescribeTagsRequest
        .builder
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def describeTagsResponse(
      marker: Option[String] = None,
      tags: Option[List[Tag]] = None,
      nextMarker: Option[String] = None
    ): DescribeTagsResponse =
      DescribeTagsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def fileSystemAlreadyExists(
      errorCode: Option[String] = None,
      message: Option[String] = None,
      fileSystemId: Option[String] = None
    ): FileSystemAlreadyExists =
      FileSystemAlreadyExists
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def fileSystemDescription(
      ownerId: Option[String] = None,
      creationToken: Option[String] = None,
      fileSystemId: Option[String] = None,
      fileSystemArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lifeCycleState: Option[String] = None,
      name: Option[String] = None,
      numberOfMountTargets: Option[Int] = None,
      sizeInBytes: Option[FileSystemSize] = None,
      performanceMode: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      throughputMode: Option[String] = None,
      provisionedThroughputInMibps: Option[ProvisionedThroughputInMibps] = None,
      availabilityZoneName: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): FileSystemDescription =
      FileSystemDescription
        .builder
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(creationToken)(_.creationToken(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(fileSystemArn)(_.fileSystemArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lifeCycleState)(_.lifeCycleState(_))
        .ifSome(name)(_.name(_))
        .ifSome(numberOfMountTargets)(_.numberOfMountTargets(_))
        .ifSome(sizeInBytes)(_.sizeInBytes(_))
        .ifSome(performanceMode)(_.performanceMode(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(throughputMode)(_.throughputMode(_))
        .ifSome(provisionedThroughputInMibps)(_.provisionedThroughputInMibps(_))
        .ifSome(availabilityZoneName)(_.availabilityZoneName(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def fileSystemInUse(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): FileSystemInUse =
      FileSystemInUse
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def fileSystemLimitExceeded(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): FileSystemLimitExceeded =
      FileSystemLimitExceeded
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def fileSystemNotFound(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): FileSystemNotFound =
      FileSystemNotFound
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def fileSystemPolicyDescription(
      fileSystemId: Option[String] = None,
      policy: Option[String] = None
    ): FileSystemPolicyDescription =
      FileSystemPolicyDescription
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(policy)(_.policy(_))
        .build

    def fileSystemSize(
      value: Option[FileSystemSizeValue] = None,
      timestamp: Option[Timestamp] = None,
      valueInIA: Option[FileSystemNullableSizeValue] = None,
      valueInStandard: Option[FileSystemNullableSizeValue] = None
    ): FileSystemSize =
      FileSystemSize
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(valueInIA)(_.valueInIA(_))
        .ifSome(valueInStandard)(_.valueInStandard(_))
        .build

    def incorrectFileSystemLifeCycleState(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): IncorrectFileSystemLifeCycleState =
      IncorrectFileSystemLifeCycleState
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def incorrectMountTargetState(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): IncorrectMountTargetState =
      IncorrectMountTargetState
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def insufficientThroughputCapacity(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): InsufficientThroughputCapacity =
      InsufficientThroughputCapacity
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def internalServerError(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidPolicyException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): InvalidPolicyException =
      InvalidPolicyException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def ipAddressInUse(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): IpAddressInUse =
      IpAddressInUse
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def lifecycleConfigurationDescription(
      lifecyclePolicies: Option[List[LifecyclePolicy]] = None
    ): LifecycleConfigurationDescription =
      LifecycleConfigurationDescription
        .builder
        .ifSome(lifecyclePolicies)(_.lifecyclePolicies(_))
        .build

    def lifecyclePolicy(
      transitionToIA: Option[String] = None
    ): LifecyclePolicy =
      LifecyclePolicy
        .builder
        .ifSome(transitionToIA)(_.transitionToIA(_))
        .build

    def listTagsForResourceRequest(
      resourceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def modifyMountTargetSecurityGroupsRequest(
      mountTargetId: Option[String] = None,
      securityGroups: Option[List[SecurityGroup]] = None
    ): ModifyMountTargetSecurityGroupsRequest =
      ModifyMountTargetSecurityGroupsRequest
        .builder
        .ifSome(mountTargetId)(_.mountTargetId(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def mountTargetConflict(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): MountTargetConflict =
      MountTargetConflict
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def mountTargetDescription(
      ownerId: Option[String] = None,
      mountTargetId: Option[String] = None,
      fileSystemId: Option[String] = None,
      subnetId: Option[String] = None,
      lifeCycleState: Option[String] = None,
      ipAddress: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      availabilityZoneName: Option[String] = None,
      vpcId: Option[String] = None
    ): MountTargetDescription =
      MountTargetDescription
        .builder
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(mountTargetId)(_.mountTargetId(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(lifeCycleState)(_.lifeCycleState(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(availabilityZoneName)(_.availabilityZoneName(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def mountTargetNotFound(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): MountTargetNotFound =
      MountTargetNotFound
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def networkInterfaceLimitExceeded(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): NetworkInterfaceLimitExceeded =
      NetworkInterfaceLimitExceeded
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def noFreeAddressesInSubnet(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): NoFreeAddressesInSubnet =
      NoFreeAddressesInSubnet
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def policyNotFound(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): PolicyNotFound =
      PolicyNotFound
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def posixUser(
      uid: Option[Uid] = None,
      gid: Option[Gid] = None,
      secondaryGids: Option[List[Gid]] = None
    ): PosixUser =
      PosixUser
        .builder
        .ifSome(uid)(_.uid(_))
        .ifSome(gid)(_.gid(_))
        .ifSome(secondaryGids)(_.secondaryGids(_))
        .build

    def putAccountPreferencesRequest(
      resourceIdType: Option[String] = None
    ): PutAccountPreferencesRequest =
      PutAccountPreferencesRequest
        .builder
        .ifSome(resourceIdType)(_.resourceIdType(_))
        .build

    def putAccountPreferencesResponse(
      resourceIdPreference: Option[ResourceIdPreference] = None
    ): PutAccountPreferencesResponse =
      PutAccountPreferencesResponse
        .builder
        .ifSome(resourceIdPreference)(_.resourceIdPreference(_))
        .build

    def putBackupPolicyRequest(
      fileSystemId: Option[String] = None,
      backupPolicy: Option[BackupPolicy] = None
    ): PutBackupPolicyRequest =
      PutBackupPolicyRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(backupPolicy)(_.backupPolicy(_))
        .build

    def putFileSystemPolicyRequest(
      fileSystemId: Option[String] = None,
      policy: Option[String] = None,
      bypassPolicyLockoutSafetyCheck: Option[Boolean] = None
    ): PutFileSystemPolicyRequest =
      PutFileSystemPolicyRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(bypassPolicyLockoutSafetyCheck)(_.bypassPolicyLockoutSafetyCheck(_))
        .build

    def putLifecycleConfigurationRequest(
      fileSystemId: Option[String] = None,
      lifecyclePolicies: Option[List[LifecyclePolicy]] = None
    ): PutLifecycleConfigurationRequest =
      PutLifecycleConfigurationRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(lifecyclePolicies)(_.lifecyclePolicies(_))
        .build

    def resourceIdPreference(
      resourceIdType: Option[String] = None,
      resources: Option[List[Resource]] = None
    ): ResourceIdPreference =
      ResourceIdPreference
        .builder
        .ifSome(resourceIdType)(_.resourceIdType(_))
        .ifSome(resources)(_.resources(_))
        .build

    def rootDirectory(
      path: Option[String] = None,
      creationInfo: Option[CreationInfo] = None
    ): RootDirectory =
      RootDirectory
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(creationInfo)(_.creationInfo(_))
        .build

    def securityGroupLimitExceeded(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): SecurityGroupLimitExceeded =
      SecurityGroupLimitExceeded
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def securityGroupNotFound(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): SecurityGroupNotFound =
      SecurityGroupNotFound
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def subnetNotFound(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): SubnetNotFound =
      SubnetNotFound
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
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
      resourceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def throughputLimitExceeded(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): ThroughputLimitExceeded =
      ThroughputLimitExceeded
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def tooManyRequests(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequests =
      TooManyRequests
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def unsupportedAvailabilityZone(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): UnsupportedAvailabilityZone =
      UnsupportedAvailabilityZone
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceId: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateFileSystemRequest(
      fileSystemId: Option[String] = None,
      throughputMode: Option[String] = None,
      provisionedThroughputInMibps: Option[ProvisionedThroughputInMibps] = None
    ): UpdateFileSystemRequest =
      UpdateFileSystemRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(throughputMode)(_.throughputMode(_))
        .ifSome(provisionedThroughputInMibps)(_.provisionedThroughputInMibps(_))
        .build

    def validationException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
