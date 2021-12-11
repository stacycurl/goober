package goober.hi

import goober.free.workspaces.WorkSpacesIO
import software.amazon.awssdk.services.workspaces.model._


object workspaces {
  import goober.free.{workspaces ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountModification(
      modificationState: Option[String] = None,
      dedicatedTenancySupport: Option[String] = None,
      dedicatedTenancyManagementCidrRange: Option[String] = None,
      startTime: Option[Timestamp] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): AccountModification =
      AccountModification
        .builder
        .ifSome(modificationState)(_.modificationState(_))
        .ifSome(dedicatedTenancySupport)(_.dedicatedTenancySupport(_))
        .ifSome(dedicatedTenancyManagementCidrRange)(_.dedicatedTenancyManagementCidrRange(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def associateConnectionAliasRequest(
      aliasId: Option[String] = None,
      resourceId: Option[String] = None
    ): AssociateConnectionAliasRequest =
      AssociateConnectionAliasRequest
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def associateIpGroupsRequest(
      directoryId: Option[String] = None,
      groupIds: Option[List[IpGroupId]] = None
    ): AssociateIpGroupsRequest =
      AssociateIpGroupsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(groupIds)(_.groupIds(_))
        .build

    def authorizeIpRulesRequest(
      groupId: Option[String] = None,
      userRules: Option[List[IpRuleItem]] = None
    ): AuthorizeIpRulesRequest =
      AuthorizeIpRulesRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(userRules)(_.userRules(_))
        .build

    def clientProperties(
      reconnectEnabled: Option[String] = None
    ): ClientProperties =
      ClientProperties
        .builder
        .ifSome(reconnectEnabled)(_.reconnectEnabled(_))
        .build

    def computeType(
      name: Option[String] = None
    ): ComputeType =
      ComputeType
        .builder
        .ifSome(name)(_.name(_))
        .build

    def connectionAlias(
      connectionString: Option[String] = None,
      aliasId: Option[String] = None,
      state: Option[String] = None,
      ownerAccountId: Option[String] = None,
      associations: Option[List[ConnectionAliasAssociation]] = None
    ): ConnectionAlias =
      ConnectionAlias
        .builder
        .ifSome(connectionString)(_.connectionString(_))
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(state)(_.state(_))
        .ifSome(ownerAccountId)(_.ownerAccountId(_))
        .ifSome(associations)(_.associations(_))
        .build

    def connectionAliasAssociation(
      associationStatus: Option[String] = None,
      associatedAccountId: Option[String] = None,
      resourceId: Option[String] = None,
      connectionIdentifier: Option[String] = None
    ): ConnectionAliasAssociation =
      ConnectionAliasAssociation
        .builder
        .ifSome(associationStatus)(_.associationStatus(_))
        .ifSome(associatedAccountId)(_.associatedAccountId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(connectionIdentifier)(_.connectionIdentifier(_))
        .build

    def connectionAliasPermission(
      sharedAccountId: Option[String] = None,
      allowAssociation: Option[Boolean] = None
    ): ConnectionAliasPermission =
      ConnectionAliasPermission
        .builder
        .ifSome(sharedAccountId)(_.sharedAccountId(_))
        .ifSome(allowAssociation)(_.allowAssociation(_))
        .build

    def copyWorkspaceImageRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      sourceImageId: Option[String] = None,
      sourceRegion: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CopyWorkspaceImageRequest =
      CopyWorkspaceImageRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(sourceImageId)(_.sourceImageId(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConnectionAliasRequest(
      connectionString: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateConnectionAliasRequest =
      CreateConnectionAliasRequest
        .builder
        .ifSome(connectionString)(_.connectionString(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createIpGroupRequest(
      groupName: Option[String] = None,
      groupDesc: Option[String] = None,
      userRules: Option[List[IpRuleItem]] = None,
      tags: Option[List[Tag]] = None
    ): CreateIpGroupRequest =
      CreateIpGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupDesc)(_.groupDesc(_))
        .ifSome(userRules)(_.userRules(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTagsRequest(
      resourceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateTagsRequest =
      CreateTagsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorkspaceBundleRequest(
      bundleName: Option[String] = None,
      bundleDescription: Option[String] = None,
      imageId: Option[String] = None,
      computeType: Option[ComputeType] = None,
      userStorage: Option[UserStorage] = None,
      rootStorage: Option[RootStorage] = None,
      tags: Option[List[Tag]] = None
    ): CreateWorkspaceBundleRequest =
      CreateWorkspaceBundleRequest
        .builder
        .ifSome(bundleName)(_.bundleName(_))
        .ifSome(bundleDescription)(_.bundleDescription(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(computeType)(_.computeType(_))
        .ifSome(userStorage)(_.userStorage(_))
        .ifSome(rootStorage)(_.rootStorage(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorkspacesRequest(
      workspaces: Option[List[WorkspaceRequest]] = None
    ): CreateWorkspacesRequest =
      CreateWorkspacesRequest
        .builder
        .ifSome(workspaces)(_.workspaces(_))
        .build

    def defaultWorkspaceCreationProperties(
      enableWorkDocs: Option[Boolean] = None,
      enableInternetAccess: Option[Boolean] = None,
      defaultOu: Option[String] = None,
      customSecurityGroupId: Option[String] = None,
      userEnabledAsLocalAdministrator: Option[Boolean] = None,
      enableMaintenanceMode: Option[Boolean] = None
    ): DefaultWorkspaceCreationProperties =
      DefaultWorkspaceCreationProperties
        .builder
        .ifSome(enableWorkDocs)(_.enableWorkDocs(_))
        .ifSome(enableInternetAccess)(_.enableInternetAccess(_))
        .ifSome(defaultOu)(_.defaultOu(_))
        .ifSome(customSecurityGroupId)(_.customSecurityGroupId(_))
        .ifSome(userEnabledAsLocalAdministrator)(_.userEnabledAsLocalAdministrator(_))
        .ifSome(enableMaintenanceMode)(_.enableMaintenanceMode(_))
        .build

    def deleteConnectionAliasRequest(
      aliasId: Option[String] = None
    ): DeleteConnectionAliasRequest =
      DeleteConnectionAliasRequest
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .build

    def deleteIpGroupRequest(
      groupId: Option[String] = None
    ): DeleteIpGroupRequest =
      DeleteIpGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def deleteTagsRequest(
      resourceId: Option[String] = None,
      tagKeys: Option[List[NonEmptyString]] = None
    ): DeleteTagsRequest =
      DeleteTagsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def deleteWorkspaceBundleRequest(
      bundleId: Option[String] = None
    ): DeleteWorkspaceBundleRequest =
      DeleteWorkspaceBundleRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .build

    def deleteWorkspaceImageRequest(
      imageId: Option[String] = None
    ): DeleteWorkspaceImageRequest =
      DeleteWorkspaceImageRequest
        .builder
        .ifSome(imageId)(_.imageId(_))
        .build

    def deregisterWorkspaceDirectoryRequest(
      directoryId: Option[String] = None
    ): DeregisterWorkspaceDirectoryRequest =
      DeregisterWorkspaceDirectoryRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def describeAccountModificationsRequest(
      nextToken: Option[String] = None
    ): DescribeAccountModificationsRequest =
      DescribeAccountModificationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAccountRequest(

    ): DescribeAccountRequest =
      DescribeAccountRequest
        .builder

        .build

    def describeClientPropertiesRequest(
      resourceIds: Option[List[NonEmptyString]] = None
    ): DescribeClientPropertiesRequest =
      DescribeClientPropertiesRequest
        .builder
        .ifSome(resourceIds)(_.resourceIds(_))
        .build

    def describeConnectionAliasPermissionsRequest(
      aliasId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeConnectionAliasPermissionsRequest =
      DescribeConnectionAliasPermissionsRequest
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeConnectionAliasesRequest(
      aliasIds: Option[List[ConnectionAliasId]] = None,
      resourceId: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeConnectionAliasesRequest =
      DescribeConnectionAliasesRequest
        .builder
        .ifSome(aliasIds)(_.aliasIds(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeIpGroupsRequest(
      groupIds: Option[List[IpGroupId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeIpGroupsRequest =
      DescribeIpGroupsRequest
        .builder
        .ifSome(groupIds)(_.groupIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeTagsRequest(
      resourceId: Option[String] = None
    ): DescribeTagsRequest =
      DescribeTagsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def describeWorkspaceBundlesRequest(
      bundleIds: Option[List[BundleId]] = None,
      owner: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeWorkspaceBundlesRequest =
      DescribeWorkspaceBundlesRequest
        .builder
        .ifSome(bundleIds)(_.bundleIds(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeWorkspaceDirectoriesRequest(
      directoryIds: Option[List[DirectoryId]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeWorkspaceDirectoriesRequest =
      DescribeWorkspaceDirectoriesRequest
        .builder
        .ifSome(directoryIds)(_.directoryIds(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeWorkspaceImagePermissionsRequest(
      imageId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeWorkspaceImagePermissionsRequest =
      DescribeWorkspaceImagePermissionsRequest
        .builder
        .ifSome(imageId)(_.imageId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeWorkspaceImagesRequest(
      imageIds: Option[List[WorkspaceImageId]] = None,
      imageType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeWorkspaceImagesRequest =
      DescribeWorkspaceImagesRequest
        .builder
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(imageType)(_.imageType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeWorkspaceSnapshotsRequest(
      workspaceId: Option[String] = None
    ): DescribeWorkspaceSnapshotsRequest =
      DescribeWorkspaceSnapshotsRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def describeWorkspacesConnectionStatusRequest(
      workspaceIds: Option[List[WorkspaceId]] = None,
      nextToken: Option[String] = None
    ): DescribeWorkspacesConnectionStatusRequest =
      DescribeWorkspacesConnectionStatusRequest
        .builder
        .ifSome(workspaceIds)(_.workspaceIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeWorkspacesRequest(
      workspaceIds: Option[List[WorkspaceId]] = None,
      directoryId: Option[String] = None,
      userName: Option[String] = None,
      bundleId: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeWorkspacesRequest =
      DescribeWorkspacesRequest
        .builder
        .ifSome(workspaceIds)(_.workspaceIds(_))
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def disassociateConnectionAliasRequest(
      aliasId: Option[String] = None
    ): DisassociateConnectionAliasRequest =
      DisassociateConnectionAliasRequest
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .build

    def disassociateIpGroupsRequest(
      directoryId: Option[String] = None,
      groupIds: Option[List[IpGroupId]] = None
    ): DisassociateIpGroupsRequest =
      DisassociateIpGroupsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(groupIds)(_.groupIds(_))
        .build

    def failedCreateWorkspaceRequest(
      workspaceRequest: Option[WorkspaceRequest] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailedCreateWorkspaceRequest =
      FailedCreateWorkspaceRequest
        .builder
        .ifSome(workspaceRequest)(_.workspaceRequest(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def failedWorkspaceChangeRequest(
      workspaceId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailedWorkspaceChangeRequest =
      FailedWorkspaceChangeRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def imagePermission(
      sharedAccountId: Option[String] = None
    ): ImagePermission =
      ImagePermission
        .builder
        .ifSome(sharedAccountId)(_.sharedAccountId(_))
        .build

    def importWorkspaceImageRequest(
      ec2ImageId: Option[String] = None,
      ingestionProcess: Option[String] = None,
      imageName: Option[String] = None,
      imageDescription: Option[String] = None,
      tags: Option[List[Tag]] = None,
      applications: Option[List[Application]] = None
    ): ImportWorkspaceImageRequest =
      ImportWorkspaceImageRequest
        .builder
        .ifSome(ec2ImageId)(_.ec2ImageId(_))
        .ifSome(ingestionProcess)(_.ingestionProcess(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageDescription)(_.imageDescription(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(applications)(_.applications(_))
        .build

    def invalidParameterValuesException(
      message: Option[String] = None
    ): InvalidParameterValuesException =
      InvalidParameterValuesException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResourceStateException(
      message: Option[String] = None
    ): InvalidResourceStateException =
      InvalidResourceStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ipRuleItem(
      ipRule: Option[String] = None,
      ruleDesc: Option[String] = None
    ): IpRuleItem =
      IpRuleItem
        .builder
        .ifSome(ipRule)(_.ipRule(_))
        .ifSome(ruleDesc)(_.ruleDesc(_))
        .build

    def listAvailableManagementCidrRangesRequest(
      managementCidrRangeConstraint: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAvailableManagementCidrRangesRequest =
      ListAvailableManagementCidrRangesRequest
        .builder
        .ifSome(managementCidrRangeConstraint)(_.managementCidrRangeConstraint(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def migrateWorkspaceRequest(
      sourceWorkspaceId: Option[String] = None,
      bundleId: Option[String] = None
    ): MigrateWorkspaceRequest =
      MigrateWorkspaceRequest
        .builder
        .ifSome(sourceWorkspaceId)(_.sourceWorkspaceId(_))
        .ifSome(bundleId)(_.bundleId(_))
        .build

    def modificationState(
      resource: Option[String] = None,
      state: Option[String] = None
    ): ModificationState =
      ModificationState
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(state)(_.state(_))
        .build

    def modifyAccountRequest(
      dedicatedTenancySupport: Option[String] = None,
      dedicatedTenancyManagementCidrRange: Option[String] = None
    ): ModifyAccountRequest =
      ModifyAccountRequest
        .builder
        .ifSome(dedicatedTenancySupport)(_.dedicatedTenancySupport(_))
        .ifSome(dedicatedTenancyManagementCidrRange)(_.dedicatedTenancyManagementCidrRange(_))
        .build

    def modifyClientPropertiesRequest(
      resourceId: Option[String] = None,
      clientProperties: Option[ClientProperties] = None
    ): ModifyClientPropertiesRequest =
      ModifyClientPropertiesRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(clientProperties)(_.clientProperties(_))
        .build

    def modifySelfservicePermissionsRequest(
      resourceId: Option[String] = None,
      selfservicePermissions: Option[SelfservicePermissions] = None
    ): ModifySelfservicePermissionsRequest =
      ModifySelfservicePermissionsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(selfservicePermissions)(_.selfservicePermissions(_))
        .build

    def modifyWorkspaceAccessPropertiesRequest(
      resourceId: Option[String] = None,
      workspaceAccessProperties: Option[WorkspaceAccessProperties] = None
    ): ModifyWorkspaceAccessPropertiesRequest =
      ModifyWorkspaceAccessPropertiesRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(workspaceAccessProperties)(_.workspaceAccessProperties(_))
        .build

    def modifyWorkspaceCreationPropertiesRequest(
      resourceId: Option[String] = None,
      workspaceCreationProperties: Option[WorkspaceCreationProperties] = None
    ): ModifyWorkspaceCreationPropertiesRequest =
      ModifyWorkspaceCreationPropertiesRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(workspaceCreationProperties)(_.workspaceCreationProperties(_))
        .build

    def modifyWorkspacePropertiesRequest(
      workspaceId: Option[String] = None,
      workspaceProperties: Option[WorkspaceProperties] = None
    ): ModifyWorkspacePropertiesRequest =
      ModifyWorkspacePropertiesRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .ifSome(workspaceProperties)(_.workspaceProperties(_))
        .build

    def modifyWorkspaceStateRequest(
      workspaceId: Option[String] = None,
      workspaceState: Option[String] = None
    ): ModifyWorkspaceStateRequest =
      ModifyWorkspaceStateRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .ifSome(workspaceState)(_.workspaceState(_))
        .build

    def operatingSystem(
      `type`: Option[String] = None
    ): OperatingSystem =
      OperatingSystem
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def operationInProgressException(
      message: Option[String] = None
    ): OperationInProgressException =
      OperationInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def operationNotSupportedException(
      message: Option[String] = None
    ): OperationNotSupportedException =
      OperationNotSupportedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def rebootRequest(
      workspaceId: Option[String] = None
    ): RebootRequest =
      RebootRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def rebootWorkspacesRequest(
      rebootWorkspaceRequests: Option[List[RebootRequest]] = None
    ): RebootWorkspacesRequest =
      RebootWorkspacesRequest
        .builder
        .ifSome(rebootWorkspaceRequests)(_.rebootWorkspaceRequests(_))
        .build

    def rebuildRequest(
      workspaceId: Option[String] = None
    ): RebuildRequest =
      RebuildRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def rebuildWorkspacesRequest(
      rebuildWorkspaceRequests: Option[List[RebuildRequest]] = None
    ): RebuildWorkspacesRequest =
      RebuildWorkspacesRequest
        .builder
        .ifSome(rebuildWorkspaceRequests)(_.rebuildWorkspaceRequests(_))
        .build

    def registerWorkspaceDirectoryRequest(
      directoryId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      enableWorkDocs: Option[Boolean] = None,
      enableSelfService: Option[Boolean] = None,
      tenancy: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): RegisterWorkspaceDirectoryRequest =
      RegisterWorkspaceDirectoryRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(enableWorkDocs)(_.enableWorkDocs(_))
        .ifSome(enableSelfService)(_.enableSelfService(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceAssociatedException(
      message: Option[String] = None
    ): ResourceAssociatedException =
      ResourceAssociatedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceCreationFailedException(
      message: Option[String] = None
    ): ResourceCreationFailedException =
      ResourceCreationFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceLimitExceededException(
      message: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def resourceUnavailableException(
      message: Option[String] = None,
      resourceId: Option[String] = None
    ): ResourceUnavailableException =
      ResourceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def restoreWorkspaceRequest(
      workspaceId: Option[String] = None
    ): RestoreWorkspaceRequest =
      RestoreWorkspaceRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def revokeIpRulesRequest(
      groupId: Option[String] = None,
      userRules: Option[List[IpRule]] = None
    ): RevokeIpRulesRequest =
      RevokeIpRulesRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(userRules)(_.userRules(_))
        .build

    def rootStorage(
      capacity: Option[String] = None
    ): RootStorage =
      RootStorage
        .builder
        .ifSome(capacity)(_.capacity(_))
        .build

    def selfservicePermissions(
      restartWorkspace: Option[String] = None,
      increaseVolumeSize: Option[String] = None,
      changeComputeType: Option[String] = None,
      switchRunningMode: Option[String] = None,
      rebuildWorkspace: Option[String] = None
    ): SelfservicePermissions =
      SelfservicePermissions
        .builder
        .ifSome(restartWorkspace)(_.restartWorkspace(_))
        .ifSome(increaseVolumeSize)(_.increaseVolumeSize(_))
        .ifSome(changeComputeType)(_.changeComputeType(_))
        .ifSome(switchRunningMode)(_.switchRunningMode(_))
        .ifSome(rebuildWorkspace)(_.rebuildWorkspace(_))
        .build

    def snapshot(
      snapshotTime: Option[Timestamp] = None
    ): Snapshot =
      Snapshot
        .builder
        .ifSome(snapshotTime)(_.snapshotTime(_))
        .build

    def startRequest(
      workspaceId: Option[String] = None
    ): StartRequest =
      StartRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def startWorkspacesRequest(
      startWorkspaceRequests: Option[List[StartRequest]] = None
    ): StartWorkspacesRequest =
      StartWorkspacesRequest
        .builder
        .ifSome(startWorkspaceRequests)(_.startWorkspaceRequests(_))
        .build

    def stopRequest(
      workspaceId: Option[String] = None
    ): StopRequest =
      StopRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def stopWorkspacesRequest(
      stopWorkspaceRequests: Option[List[StopRequest]] = None
    ): StopWorkspacesRequest =
      StopWorkspacesRequest
        .builder
        .ifSome(stopWorkspaceRequests)(_.stopWorkspaceRequests(_))
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

    def terminateRequest(
      workspaceId: Option[String] = None
    ): TerminateRequest =
      TerminateRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def terminateWorkspacesRequest(
      terminateWorkspaceRequests: Option[List[TerminateRequest]] = None
    ): TerminateWorkspacesRequest =
      TerminateWorkspacesRequest
        .builder
        .ifSome(terminateWorkspaceRequests)(_.terminateWorkspaceRequests(_))
        .build

    def unsupportedNetworkConfigurationException(
      message: Option[String] = None
    ): UnsupportedNetworkConfigurationException =
      UnsupportedNetworkConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedWorkspaceConfigurationException(
      message: Option[String] = None
    ): UnsupportedWorkspaceConfigurationException =
      UnsupportedWorkspaceConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateConnectionAliasPermissionRequest(
      aliasId: Option[String] = None,
      connectionAliasPermission: Option[ConnectionAliasPermission] = None
    ): UpdateConnectionAliasPermissionRequest =
      UpdateConnectionAliasPermissionRequest
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(connectionAliasPermission)(_.connectionAliasPermission(_))
        .build

    def updateRulesOfIpGroupRequest(
      groupId: Option[String] = None,
      userRules: Option[List[IpRuleItem]] = None
    ): UpdateRulesOfIpGroupRequest =
      UpdateRulesOfIpGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(userRules)(_.userRules(_))
        .build

    def updateWorkspaceBundleRequest(
      bundleId: Option[String] = None,
      imageId: Option[String] = None
    ): UpdateWorkspaceBundleRequest =
      UpdateWorkspaceBundleRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(imageId)(_.imageId(_))
        .build

    def updateWorkspaceImagePermissionRequest(
      imageId: Option[String] = None,
      allowCopyImage: Option[Boolean] = None,
      sharedAccountId: Option[String] = None
    ): UpdateWorkspaceImagePermissionRequest =
      UpdateWorkspaceImagePermissionRequest
        .builder
        .ifSome(imageId)(_.imageId(_))
        .ifSome(allowCopyImage)(_.allowCopyImage(_))
        .ifSome(sharedAccountId)(_.sharedAccountId(_))
        .build

    def userStorage(
      capacity: Option[String] = None
    ): UserStorage =
      UserStorage
        .builder
        .ifSome(capacity)(_.capacity(_))
        .build

    def workspace(
      workspaceId: Option[String] = None,
      directoryId: Option[String] = None,
      userName: Option[String] = None,
      ipAddress: Option[String] = None,
      state: Option[String] = None,
      bundleId: Option[String] = None,
      subnetId: Option[String] = None,
      errorMessage: Option[String] = None,
      errorCode: Option[String] = None,
      computerName: Option[String] = None,
      volumeEncryptionKey: Option[String] = None,
      userVolumeEncryptionEnabled: Option[Boolean] = None,
      rootVolumeEncryptionEnabled: Option[Boolean] = None,
      workspaceProperties: Option[WorkspaceProperties] = None,
      modificationStates: Option[List[ModificationState]] = None
    ): Workspace =
      Workspace
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(state)(_.state(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(computerName)(_.computerName(_))
        .ifSome(volumeEncryptionKey)(_.volumeEncryptionKey(_))
        .ifSome(userVolumeEncryptionEnabled)(_.userVolumeEncryptionEnabled(_))
        .ifSome(rootVolumeEncryptionEnabled)(_.rootVolumeEncryptionEnabled(_))
        .ifSome(workspaceProperties)(_.workspaceProperties(_))
        .ifSome(modificationStates)(_.modificationStates(_))
        .build

    def workspaceAccessProperties(
      deviceTypeWindows: Option[String] = None,
      deviceTypeOsx: Option[String] = None,
      deviceTypeWeb: Option[String] = None,
      deviceTypeIos: Option[String] = None,
      deviceTypeAndroid: Option[String] = None,
      deviceTypeChromeOs: Option[String] = None,
      deviceTypeZeroClient: Option[String] = None,
      deviceTypeLinux: Option[String] = None
    ): WorkspaceAccessProperties =
      WorkspaceAccessProperties
        .builder
        .ifSome(deviceTypeWindows)(_.deviceTypeWindows(_))
        .ifSome(deviceTypeOsx)(_.deviceTypeOsx(_))
        .ifSome(deviceTypeWeb)(_.deviceTypeWeb(_))
        .ifSome(deviceTypeIos)(_.deviceTypeIos(_))
        .ifSome(deviceTypeAndroid)(_.deviceTypeAndroid(_))
        .ifSome(deviceTypeChromeOs)(_.deviceTypeChromeOs(_))
        .ifSome(deviceTypeZeroClient)(_.deviceTypeZeroClient(_))
        .ifSome(deviceTypeLinux)(_.deviceTypeLinux(_))
        .build

    def workspaceBundle(
      bundleId: Option[String] = None,
      name: Option[String] = None,
      owner: Option[String] = None,
      description: Option[String] = None,
      imageId: Option[String] = None,
      rootStorage: Option[RootStorage] = None,
      userStorage: Option[UserStorage] = None,
      computeType: Option[ComputeType] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None
    ): WorkspaceBundle =
      WorkspaceBundle
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(description)(_.description(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(rootStorage)(_.rootStorage(_))
        .ifSome(userStorage)(_.userStorage(_))
        .ifSome(computeType)(_.computeType(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def workspaceConnectionStatus(
      workspaceId: Option[String] = None,
      connectionState: Option[String] = None,
      connectionStateCheckTimestamp: Option[Timestamp] = None,
      lastKnownUserConnectionTimestamp: Option[Timestamp] = None
    ): WorkspaceConnectionStatus =
      WorkspaceConnectionStatus
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(connectionStateCheckTimestamp)(_.connectionStateCheckTimestamp(_))
        .ifSome(lastKnownUserConnectionTimestamp)(_.lastKnownUserConnectionTimestamp(_))
        .build

    def workspaceCreationProperties(
      enableWorkDocs: Option[Boolean] = None,
      enableInternetAccess: Option[Boolean] = None,
      defaultOu: Option[String] = None,
      customSecurityGroupId: Option[String] = None,
      userEnabledAsLocalAdministrator: Option[Boolean] = None,
      enableMaintenanceMode: Option[Boolean] = None
    ): WorkspaceCreationProperties =
      WorkspaceCreationProperties
        .builder
        .ifSome(enableWorkDocs)(_.enableWorkDocs(_))
        .ifSome(enableInternetAccess)(_.enableInternetAccess(_))
        .ifSome(defaultOu)(_.defaultOu(_))
        .ifSome(customSecurityGroupId)(_.customSecurityGroupId(_))
        .ifSome(userEnabledAsLocalAdministrator)(_.userEnabledAsLocalAdministrator(_))
        .ifSome(enableMaintenanceMode)(_.enableMaintenanceMode(_))
        .build

    def workspaceDirectory(
      directoryId: Option[String] = None,
      alias: Option[String] = None,
      directoryName: Option[String] = None,
      registrationCode: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      dnsIpAddresses: Option[List[IpAddress]] = None,
      customerUserName: Option[String] = None,
      iamRoleId: Option[String] = None,
      directoryType: Option[String] = None,
      workspaceSecurityGroupId: Option[String] = None,
      state: Option[String] = None,
      workspaceCreationProperties: Option[DefaultWorkspaceCreationProperties] = None,
      ipGroupIds: Option[List[IpGroupId]] = None,
      workspaceAccessProperties: Option[WorkspaceAccessProperties] = None,
      tenancy: Option[String] = None,
      selfservicePermissions: Option[SelfservicePermissions] = None
    ): WorkspaceDirectory =
      WorkspaceDirectory
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(directoryName)(_.directoryName(_))
        .ifSome(registrationCode)(_.registrationCode(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(dnsIpAddresses)(_.dnsIpAddresses(_))
        .ifSome(customerUserName)(_.customerUserName(_))
        .ifSome(iamRoleId)(_.iamRoleId(_))
        .ifSome(directoryType)(_.directoryType(_))
        .ifSome(workspaceSecurityGroupId)(_.workspaceSecurityGroupId(_))
        .ifSome(state)(_.state(_))
        .ifSome(workspaceCreationProperties)(_.workspaceCreationProperties(_))
        .ifSome(ipGroupIds)(_.ipGroupIds(_))
        .ifSome(workspaceAccessProperties)(_.workspaceAccessProperties(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(selfservicePermissions)(_.selfservicePermissions(_))
        .build

    def workspaceImage(
      imageId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      operatingSystem: Option[OperatingSystem] = None,
      state: Option[String] = None,
      requiredTenancy: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      created: Option[Timestamp] = None,
      ownerAccountId: Option[String] = None
    ): WorkspaceImage =
      WorkspaceImage
        .builder
        .ifSome(imageId)(_.imageId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(state)(_.state(_))
        .ifSome(requiredTenancy)(_.requiredTenancy(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(created)(_.created(_))
        .ifSome(ownerAccountId)(_.ownerAccountId(_))
        .build

    def workspaceProperties(
      runningMode: Option[String] = None,
      runningModeAutoStopTimeoutInMinutes: Option[Int] = None,
      rootVolumeSizeGib: Option[Int] = None,
      userVolumeSizeGib: Option[Int] = None,
      computeTypeName: Option[String] = None
    ): WorkspaceProperties =
      WorkspaceProperties
        .builder
        .ifSome(runningMode)(_.runningMode(_))
        .ifSome(runningModeAutoStopTimeoutInMinutes)(_.runningModeAutoStopTimeoutInMinutes(_))
        .ifSome(rootVolumeSizeGib)(_.rootVolumeSizeGib(_))
        .ifSome(userVolumeSizeGib)(_.userVolumeSizeGib(_))
        .ifSome(computeTypeName)(_.computeTypeName(_))
        .build

    def workspaceRequest(
      directoryId: Option[String] = None,
      userName: Option[String] = None,
      bundleId: Option[String] = None,
      volumeEncryptionKey: Option[String] = None,
      userVolumeEncryptionEnabled: Option[Boolean] = None,
      rootVolumeEncryptionEnabled: Option[Boolean] = None,
      workspaceProperties: Option[WorkspaceProperties] = None,
      tags: Option[List[Tag]] = None
    ): WorkspaceRequest =
      WorkspaceRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(volumeEncryptionKey)(_.volumeEncryptionKey(_))
        .ifSome(userVolumeEncryptionEnabled)(_.userVolumeEncryptionEnabled(_))
        .ifSome(rootVolumeEncryptionEnabled)(_.rootVolumeEncryptionEnabled(_))
        .ifSome(workspaceProperties)(_.workspaceProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def workspacesDefaultRoleNotFoundException(
      message: Option[String] = None
    ): WorkspacesDefaultRoleNotFoundException =
      WorkspacesDefaultRoleNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def workspacesIpGroup(
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      groupDesc: Option[String] = None,
      userRules: Option[List[IpRuleItem]] = None
    ): WorkspacesIpGroup =
      WorkspacesIpGroup
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupDesc)(_.groupDesc(_))
        .ifSome(userRules)(_.userRules(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
