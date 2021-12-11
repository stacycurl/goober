package goober.hi

import goober.free.redshift.RedshiftIO
import software.amazon.awssdk.services.redshift.model._


object redshift {
  import goober.free.{redshift ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptReservedNodeExchangeInputMessage(
      reservedNodeId: Option[String] = None,
      targetReservedNodeOfferingId: Option[String] = None
    ): AcceptReservedNodeExchangeInputMessage =
      AcceptReservedNodeExchangeInputMessage
        .builder
        .ifSome(reservedNodeId)(_.reservedNodeId(_))
        .ifSome(targetReservedNodeOfferingId)(_.targetReservedNodeOfferingId(_))
        .build

    def acceptReservedNodeExchangeOutputMessage(
      exchangedReservedNode: Option[ReservedNode] = None
    ): AcceptReservedNodeExchangeOutputMessage =
      AcceptReservedNodeExchangeOutputMessage
        .builder
        .ifSome(exchangedReservedNode)(_.exchangedReservedNode(_))
        .build

    def accessToClusterDeniedFault(

    ): AccessToClusterDeniedFault =
      AccessToClusterDeniedFault
        .builder

        .build

    def accessToSnapshotDeniedFault(

    ): AccessToSnapshotDeniedFault =
      AccessToSnapshotDeniedFault
        .builder

        .build

    def accountAttribute(
      attributeName: Option[String] = None,
      attributeValues: Option[List[AttributeValueTarget]] = None
    ): AccountAttribute =
      AccountAttribute
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValues)(_.attributeValues(_))
        .build

    def accountAttributeList(
      accountAttributes: Option[List[AccountAttribute]] = None
    ): AccountAttributeList =
      AccountAttributeList
        .builder
        .ifSome(accountAttributes)(_.accountAttributes(_))
        .build

    def accountWithRestoreAccess(
      accountId: Option[String] = None,
      accountAlias: Option[String] = None
    ): AccountWithRestoreAccess =
      AccountWithRestoreAccess
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(accountAlias)(_.accountAlias(_))
        .build

    def aquaConfiguration(
      aquaStatus: Option[String] = None,
      aquaConfigurationStatus: Option[String] = None
    ): AquaConfiguration =
      AquaConfiguration
        .builder
        .ifSome(aquaStatus)(_.aquaStatus(_))
        .ifSome(aquaConfigurationStatus)(_.aquaConfigurationStatus(_))
        .build

    def attributeValueTarget(
      attributeValue: Option[String] = None
    ): AttributeValueTarget =
      AttributeValueTarget
        .builder
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def authorizationAlreadyExistsFault(

    ): AuthorizationAlreadyExistsFault =
      AuthorizationAlreadyExistsFault
        .builder

        .build

    def authorizationNotFoundFault(

    ): AuthorizationNotFoundFault =
      AuthorizationNotFoundFault
        .builder

        .build

    def authorizationQuotaExceededFault(

    ): AuthorizationQuotaExceededFault =
      AuthorizationQuotaExceededFault
        .builder

        .build

    def authorizeClusterSecurityGroupIngressMessage(
      clusterSecurityGroupName: Option[String] = None,
      cIDRIP: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): AuthorizeClusterSecurityGroupIngressMessage =
      AuthorizeClusterSecurityGroupIngressMessage
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .ifSome(cIDRIP)(_.cIDRIP(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
        .build

    def authorizeEndpointAccessMessage(
      clusterIdentifier: Option[String] = None,
      account: Option[String] = None,
      vpcIds: Option[List[String]] = None
    ): AuthorizeEndpointAccessMessage =
      AuthorizeEndpointAccessMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(account)(_.account(_))
        .ifSome(vpcIds)(_.vpcIds(_))
        .build

    def authorizeSnapshotAccessMessage(
      snapshotIdentifier: Option[String] = None,
      snapshotClusterIdentifier: Option[String] = None,
      accountWithRestoreAccess: Option[String] = None
    ): AuthorizeSnapshotAccessMessage =
      AuthorizeSnapshotAccessMessage
        .builder
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(snapshotClusterIdentifier)(_.snapshotClusterIdentifier(_))
        .ifSome(accountWithRestoreAccess)(_.accountWithRestoreAccess(_))
        .build

    def availabilityZone(
      name: Option[String] = None,
      supportedPlatforms: Option[List[SupportedPlatform]] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(supportedPlatforms)(_.supportedPlatforms(_))
        .build

    def batchDeleteClusterSnapshotsRequest(
      identifiers: Option[List[DeleteClusterSnapshotMessage]] = None
    ): BatchDeleteClusterSnapshotsRequest =
      BatchDeleteClusterSnapshotsRequest
        .builder
        .ifSome(identifiers)(_.identifiers(_))
        .build

    def batchDeleteRequestSizeExceededFault(

    ): BatchDeleteRequestSizeExceededFault =
      BatchDeleteRequestSizeExceededFault
        .builder

        .build

    def batchModifyClusterSnapshotsLimitExceededFault(

    ): BatchModifyClusterSnapshotsLimitExceededFault =
      BatchModifyClusterSnapshotsLimitExceededFault
        .builder

        .build

    def batchModifyClusterSnapshotsMessage(
      snapshotIdentifierList: Option[List[String]] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      force: Option[Boolean] = None
    ): BatchModifyClusterSnapshotsMessage =
      BatchModifyClusterSnapshotsMessage
        .builder
        .ifSome(snapshotIdentifierList)(_.snapshotIdentifierList(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(force)(_.force(_))
        .build

    def batchModifyClusterSnapshotsOutputMessage(
      resources: Option[List[String]] = None,
      errors: Option[List[SnapshotErrorMessage]] = None
    ): BatchModifyClusterSnapshotsOutputMessage =
      BatchModifyClusterSnapshotsOutputMessage
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(errors)(_.errors(_))
        .build

    def bucketNotFoundFault(

    ): BucketNotFoundFault =
      BucketNotFoundFault
        .builder

        .build

    def cancelResizeMessage(
      clusterIdentifier: Option[String] = None
    ): CancelResizeMessage =
      CancelResizeMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def cluster(
      clusterIdentifier: Option[String] = None,
      nodeType: Option[String] = None,
      clusterStatus: Option[String] = None,
      clusterAvailabilityStatus: Option[String] = None,
      modifyStatus: Option[String] = None,
      masterUsername: Option[String] = None,
      dBName: Option[String] = None,
      endpoint: Option[Endpoint] = None,
      clusterCreateTime: Option[TStamp] = None,
      automatedSnapshotRetentionPeriod: Option[Int] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      clusterSecurityGroups: Option[List[ClusterSecurityGroupMembership]] = None,
      vpcSecurityGroups: Option[List[VpcSecurityGroupMembership]] = None,
      clusterParameterGroups: Option[List[ClusterParameterGroupStatus]] = None,
      clusterSubnetGroupName: Option[String] = None,
      vpcId: Option[String] = None,
      availabilityZone: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      pendingModifiedValues: Option[PendingModifiedValues] = None,
      clusterVersion: Option[String] = None,
      allowVersionUpgrade: Option[Boolean] = None,
      numberOfNodes: Option[Int] = None,
      publiclyAccessible: Option[Boolean] = None,
      encrypted: Option[Boolean] = None,
      restoreStatus: Option[RestoreStatus] = None,
      dataTransferProgress: Option[DataTransferProgress] = None,
      hsmStatus: Option[HsmStatus] = None,
      clusterSnapshotCopyStatus: Option[ClusterSnapshotCopyStatus] = None,
      clusterPublicKey: Option[String] = None,
      clusterNodes: Option[List[ClusterNode]] = None,
      elasticIpStatus: Option[ElasticIpStatus] = None,
      clusterRevisionNumber: Option[String] = None,
      tags: Option[List[Tag]] = None,
      kmsKeyId: Option[String] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      iamRoles: Option[List[ClusterIamRole]] = None,
      pendingActions: Option[List[String]] = None,
      maintenanceTrackName: Option[String] = None,
      elasticResizeNumberOfNodeOptions: Option[String] = None,
      deferredMaintenanceWindows: Option[List[DeferredMaintenanceWindow]] = None,
      snapshotScheduleIdentifier: Option[String] = None,
      snapshotScheduleState: Option[String] = None,
      expectedNextSnapshotScheduleTime: Option[TStamp] = None,
      expectedNextSnapshotScheduleTimeStatus: Option[String] = None,
      nextMaintenanceWindowStartTime: Option[TStamp] = None,
      resizeInfo: Option[ResizeInfo] = None,
      availabilityZoneRelocationStatus: Option[String] = None,
      clusterNamespaceArn: Option[String] = None,
      totalStorageCapacityInMegaBytes: Option[LongOptional] = None,
      aquaConfiguration: Option[AquaConfiguration] = None
    ): Cluster =
      Cluster
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(clusterStatus)(_.clusterStatus(_))
        .ifSome(clusterAvailabilityStatus)(_.clusterAvailabilityStatus(_))
        .ifSome(modifyStatus)(_.modifyStatus(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(dBName)(_.dBName(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(clusterCreateTime)(_.clusterCreateTime(_))
        .ifSome(automatedSnapshotRetentionPeriod)(_.automatedSnapshotRetentionPeriod(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(clusterSecurityGroups)(_.clusterSecurityGroups(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .ifSome(clusterParameterGroups)(_.clusterParameterGroups(_))
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(allowVersionUpgrade)(_.allowVersionUpgrade(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(restoreStatus)(_.restoreStatus(_))
        .ifSome(dataTransferProgress)(_.dataTransferProgress(_))
        .ifSome(hsmStatus)(_.hsmStatus(_))
        .ifSome(clusterSnapshotCopyStatus)(_.clusterSnapshotCopyStatus(_))
        .ifSome(clusterPublicKey)(_.clusterPublicKey(_))
        .ifSome(clusterNodes)(_.clusterNodes(_))
        .ifSome(elasticIpStatus)(_.elasticIpStatus(_))
        .ifSome(clusterRevisionNumber)(_.clusterRevisionNumber(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(iamRoles)(_.iamRoles(_))
        .ifSome(pendingActions)(_.pendingActions(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(elasticResizeNumberOfNodeOptions)(_.elasticResizeNumberOfNodeOptions(_))
        .ifSome(deferredMaintenanceWindows)(_.deferredMaintenanceWindows(_))
        .ifSome(snapshotScheduleIdentifier)(_.snapshotScheduleIdentifier(_))
        .ifSome(snapshotScheduleState)(_.snapshotScheduleState(_))
        .ifSome(expectedNextSnapshotScheduleTime)(_.expectedNextSnapshotScheduleTime(_))
        .ifSome(expectedNextSnapshotScheduleTimeStatus)(_.expectedNextSnapshotScheduleTimeStatus(_))
        .ifSome(nextMaintenanceWindowStartTime)(_.nextMaintenanceWindowStartTime(_))
        .ifSome(resizeInfo)(_.resizeInfo(_))
        .ifSome(availabilityZoneRelocationStatus)(_.availabilityZoneRelocationStatus(_))
        .ifSome(clusterNamespaceArn)(_.clusterNamespaceArn(_))
        .ifSome(totalStorageCapacityInMegaBytes)(_.totalStorageCapacityInMegaBytes(_))
        .ifSome(aquaConfiguration)(_.aquaConfiguration(_))
        .build

    def clusterAlreadyExistsFault(

    ): ClusterAlreadyExistsFault =
      ClusterAlreadyExistsFault
        .builder

        .build

    def clusterAssociatedToSchedule(
      clusterIdentifier: Option[String] = None,
      scheduleAssociationState: Option[String] = None
    ): ClusterAssociatedToSchedule =
      ClusterAssociatedToSchedule
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(scheduleAssociationState)(_.scheduleAssociationState(_))
        .build

    def clusterCredentials(
      dbUser: Option[String] = None,
      dbPassword: Option[String] = None,
      expiration: Option[TStamp] = None
    ): ClusterCredentials =
      ClusterCredentials
        .builder
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(dbPassword)(_.dbPassword(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def clusterDbRevision(
      clusterIdentifier: Option[String] = None,
      currentDatabaseRevision: Option[String] = None,
      databaseRevisionReleaseDate: Option[TStamp] = None,
      revisionTargets: Option[List[RevisionTarget]] = None
    ): ClusterDbRevision =
      ClusterDbRevision
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(currentDatabaseRevision)(_.currentDatabaseRevision(_))
        .ifSome(databaseRevisionReleaseDate)(_.databaseRevisionReleaseDate(_))
        .ifSome(revisionTargets)(_.revisionTargets(_))
        .build

    def clusterDbRevisionsMessage(
      marker: Option[String] = None,
      clusterDbRevisions: Option[List[ClusterDbRevision]] = None
    ): ClusterDbRevisionsMessage =
      ClusterDbRevisionsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(clusterDbRevisions)(_.clusterDbRevisions(_))
        .build

    def clusterIamRole(
      iamRoleArn: Option[String] = None,
      applyStatus: Option[String] = None
    ): ClusterIamRole =
      ClusterIamRole
        .builder
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(applyStatus)(_.applyStatus(_))
        .build

    def clusterNode(
      nodeRole: Option[String] = None,
      privateIPAddress: Option[String] = None,
      publicIPAddress: Option[String] = None
    ): ClusterNode =
      ClusterNode
        .builder
        .ifSome(nodeRole)(_.nodeRole(_))
        .ifSome(privateIPAddress)(_.privateIPAddress(_))
        .ifSome(publicIPAddress)(_.publicIPAddress(_))
        .build

    def clusterNotFoundFault(

    ): ClusterNotFoundFault =
      ClusterNotFoundFault
        .builder

        .build

    def clusterOnLatestRevisionFault(

    ): ClusterOnLatestRevisionFault =
      ClusterOnLatestRevisionFault
        .builder

        .build

    def clusterParameterGroup(
      parameterGroupName: Option[String] = None,
      parameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ClusterParameterGroup =
      ClusterParameterGroup
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(parameterGroupFamily)(_.parameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def clusterParameterGroupAlreadyExistsFault(

    ): ClusterParameterGroupAlreadyExistsFault =
      ClusterParameterGroupAlreadyExistsFault
        .builder

        .build

    def clusterParameterGroupDetails(
      parameters: Option[List[Parameter]] = None,
      marker: Option[String] = None
    ): ClusterParameterGroupDetails =
      ClusterParameterGroupDetails
        .builder
        .ifSome(parameters)(_.parameters(_))
        .ifSome(marker)(_.marker(_))
        .build

    def clusterParameterGroupNameMessage(
      parameterGroupName: Option[String] = None,
      parameterGroupStatus: Option[String] = None
    ): ClusterParameterGroupNameMessage =
      ClusterParameterGroupNameMessage
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(parameterGroupStatus)(_.parameterGroupStatus(_))
        .build

    def clusterParameterGroupNotFoundFault(

    ): ClusterParameterGroupNotFoundFault =
      ClusterParameterGroupNotFoundFault
        .builder

        .build

    def clusterParameterGroupQuotaExceededFault(

    ): ClusterParameterGroupQuotaExceededFault =
      ClusterParameterGroupQuotaExceededFault
        .builder

        .build

    def clusterParameterGroupStatus(
      parameterGroupName: Option[String] = None,
      parameterApplyStatus: Option[String] = None,
      clusterParameterStatusList: Option[List[ClusterParameterStatus]] = None
    ): ClusterParameterGroupStatus =
      ClusterParameterGroupStatus
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .ifSome(clusterParameterStatusList)(_.clusterParameterStatusList(_))
        .build

    def clusterParameterGroupsMessage(
      marker: Option[String] = None,
      parameterGroups: Option[List[ClusterParameterGroup]] = None
    ): ClusterParameterGroupsMessage =
      ClusterParameterGroupsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(parameterGroups)(_.parameterGroups(_))
        .build

    def clusterParameterStatus(
      parameterName: Option[String] = None,
      parameterApplyStatus: Option[String] = None,
      parameterApplyErrorDescription: Option[String] = None
    ): ClusterParameterStatus =
      ClusterParameterStatus
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .ifSome(parameterApplyErrorDescription)(_.parameterApplyErrorDescription(_))
        .build

    def clusterQuotaExceededFault(

    ): ClusterQuotaExceededFault =
      ClusterQuotaExceededFault
        .builder

        .build

    def clusterSecurityGroup(
      clusterSecurityGroupName: Option[String] = None,
      description: Option[String] = None,
      eC2SecurityGroups: Option[List[EC2SecurityGroup]] = None,
      iPRanges: Option[List[IPRange]] = None,
      tags: Option[List[Tag]] = None
    ): ClusterSecurityGroup =
      ClusterSecurityGroup
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(eC2SecurityGroups)(_.eC2SecurityGroups(_))
        .ifSome(iPRanges)(_.iPRanges(_))
        .ifSome(tags)(_.tags(_))
        .build

    def clusterSecurityGroupAlreadyExistsFault(

    ): ClusterSecurityGroupAlreadyExistsFault =
      ClusterSecurityGroupAlreadyExistsFault
        .builder

        .build

    def clusterSecurityGroupMembership(
      clusterSecurityGroupName: Option[String] = None,
      status: Option[String] = None
    ): ClusterSecurityGroupMembership =
      ClusterSecurityGroupMembership
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def clusterSecurityGroupMessage(
      marker: Option[String] = None,
      clusterSecurityGroups: Option[List[ClusterSecurityGroup]] = None
    ): ClusterSecurityGroupMessage =
      ClusterSecurityGroupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(clusterSecurityGroups)(_.clusterSecurityGroups(_))
        .build

    def clusterSecurityGroupNotFoundFault(

    ): ClusterSecurityGroupNotFoundFault =
      ClusterSecurityGroupNotFoundFault
        .builder

        .build

    def clusterSecurityGroupQuotaExceededFault(

    ): ClusterSecurityGroupQuotaExceededFault =
      ClusterSecurityGroupQuotaExceededFault
        .builder

        .build

    def clusterSnapshotAlreadyExistsFault(

    ): ClusterSnapshotAlreadyExistsFault =
      ClusterSnapshotAlreadyExistsFault
        .builder

        .build

    def clusterSnapshotCopyStatus(
      destinationRegion: Option[String] = None,
      retentionPeriod: Option[Long] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      snapshotCopyGrantName: Option[String] = None
    ): ClusterSnapshotCopyStatus =
      ClusterSnapshotCopyStatus
        .builder
        .ifSome(destinationRegion)(_.destinationRegion(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(snapshotCopyGrantName)(_.snapshotCopyGrantName(_))
        .build

    def clusterSnapshotNotFoundFault(

    ): ClusterSnapshotNotFoundFault =
      ClusterSnapshotNotFoundFault
        .builder

        .build

    def clusterSnapshotQuotaExceededFault(

    ): ClusterSnapshotQuotaExceededFault =
      ClusterSnapshotQuotaExceededFault
        .builder

        .build

    def clusterSubnetGroup(
      clusterSubnetGroupName: Option[String] = None,
      description: Option[String] = None,
      vpcId: Option[String] = None,
      subnetGroupStatus: Option[String] = None,
      subnets: Option[List[Subnet]] = None,
      tags: Option[List[Tag]] = None
    ): ClusterSubnetGroup =
      ClusterSubnetGroup
        .builder
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetGroupStatus)(_.subnetGroupStatus(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(tags)(_.tags(_))
        .build

    def clusterSubnetGroupAlreadyExistsFault(

    ): ClusterSubnetGroupAlreadyExistsFault =
      ClusterSubnetGroupAlreadyExistsFault
        .builder

        .build

    def clusterSubnetGroupMessage(
      marker: Option[String] = None,
      clusterSubnetGroups: Option[List[ClusterSubnetGroup]] = None
    ): ClusterSubnetGroupMessage =
      ClusterSubnetGroupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(clusterSubnetGroups)(_.clusterSubnetGroups(_))
        .build

    def clusterSubnetGroupNotFoundFault(

    ): ClusterSubnetGroupNotFoundFault =
      ClusterSubnetGroupNotFoundFault
        .builder

        .build

    def clusterSubnetGroupQuotaExceededFault(

    ): ClusterSubnetGroupQuotaExceededFault =
      ClusterSubnetGroupQuotaExceededFault
        .builder

        .build

    def clusterSubnetQuotaExceededFault(

    ): ClusterSubnetQuotaExceededFault =
      ClusterSubnetQuotaExceededFault
        .builder

        .build

    def clusterVersion(
      clusterVersion: Option[String] = None,
      clusterParameterGroupFamily: Option[String] = None,
      description: Option[String] = None
    ): ClusterVersion =
      ClusterVersion
        .builder
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(clusterParameterGroupFamily)(_.clusterParameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .build

    def clusterVersionsMessage(
      marker: Option[String] = None,
      clusterVersions: Option[List[ClusterVersion]] = None
    ): ClusterVersionsMessage =
      ClusterVersionsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(clusterVersions)(_.clusterVersions(_))
        .build

    def clustersMessage(
      marker: Option[String] = None,
      clusters: Option[List[Cluster]] = None
    ): ClustersMessage =
      ClustersMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(clusters)(_.clusters(_))
        .build

    def copyClusterSnapshotMessage(
      sourceSnapshotIdentifier: Option[String] = None,
      sourceSnapshotClusterIdentifier: Option[String] = None,
      targetSnapshotIdentifier: Option[String] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None
    ): CopyClusterSnapshotMessage =
      CopyClusterSnapshotMessage
        .builder
        .ifSome(sourceSnapshotIdentifier)(_.sourceSnapshotIdentifier(_))
        .ifSome(sourceSnapshotClusterIdentifier)(_.sourceSnapshotClusterIdentifier(_))
        .ifSome(targetSnapshotIdentifier)(_.targetSnapshotIdentifier(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .build

    def copyToRegionDisabledFault(

    ): CopyToRegionDisabledFault =
      CopyToRegionDisabledFault
        .builder

        .build

    def createClusterMessage(
      dBName: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      clusterType: Option[String] = None,
      nodeType: Option[String] = None,
      masterUsername: Option[String] = None,
      masterUserPassword: Option[String] = None,
      clusterSecurityGroups: Option[List[String]] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      clusterSubnetGroupName: Option[String] = None,
      availabilityZone: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      clusterParameterGroupName: Option[String] = None,
      automatedSnapshotRetentionPeriod: Option[Int] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      port: Option[Int] = None,
      clusterVersion: Option[String] = None,
      allowVersionUpgrade: Option[Boolean] = None,
      numberOfNodes: Option[Int] = None,
      publiclyAccessible: Option[Boolean] = None,
      encrypted: Option[Boolean] = None,
      hsmClientCertificateIdentifier: Option[String] = None,
      hsmConfigurationIdentifier: Option[String] = None,
      elasticIp: Option[String] = None,
      tags: Option[List[Tag]] = None,
      kmsKeyId: Option[String] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      additionalInfo: Option[String] = None,
      iamRoles: Option[List[String]] = None,
      maintenanceTrackName: Option[String] = None,
      snapshotScheduleIdentifier: Option[String] = None,
      availabilityZoneRelocation: Option[Boolean] = None,
      aquaConfigurationStatus: Option[String] = None
    ): CreateClusterMessage =
      CreateClusterMessage
        .builder
        .ifSome(dBName)(_.dBName(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(clusterType)(_.clusterType(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(clusterSecurityGroups)(_.clusterSecurityGroups(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(clusterParameterGroupName)(_.clusterParameterGroupName(_))
        .ifSome(automatedSnapshotRetentionPeriod)(_.automatedSnapshotRetentionPeriod(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(port)(_.port(_))
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(allowVersionUpgrade)(_.allowVersionUpgrade(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .ifSome(iamRoles)(_.iamRoles(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(snapshotScheduleIdentifier)(_.snapshotScheduleIdentifier(_))
        .ifSome(availabilityZoneRelocation)(_.availabilityZoneRelocation(_))
        .ifSome(aquaConfigurationStatus)(_.aquaConfigurationStatus(_))
        .build

    def createClusterParameterGroupMessage(
      parameterGroupName: Option[String] = None,
      parameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateClusterParameterGroupMessage =
      CreateClusterParameterGroupMessage
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(parameterGroupFamily)(_.parameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createClusterSecurityGroupMessage(
      clusterSecurityGroupName: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateClusterSecurityGroupMessage =
      CreateClusterSecurityGroupMessage
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createClusterSnapshotMessage(
      snapshotIdentifier: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): CreateClusterSnapshotMessage =
      CreateClusterSnapshotMessage
        .builder
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createClusterSubnetGroupMessage(
      clusterSubnetGroupName: Option[String] = None,
      description: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None
    ): CreateClusterSubnetGroupMessage =
      CreateClusterSubnetGroupMessage
        .builder
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEndpointAccessMessage(
      clusterIdentifier: Option[String] = None,
      resourceOwner: Option[String] = None,
      endpointName: Option[String] = None,
      subnetGroupName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None
    ): CreateEndpointAccessMessage =
      CreateEndpointAccessMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(subnetGroupName)(_.subnetGroupName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .build

    def createEventSubscriptionMessage(
      subscriptionName: Option[String] = None,
      snsTopicArn: Option[String] = None,
      sourceType: Option[String] = None,
      sourceIds: Option[List[String]] = None,
      eventCategories: Option[List[String]] = None,
      severity: Option[String] = None,
      enabled: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateEventSubscriptionMessage =
      CreateEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceIds)(_.sourceIds(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHsmClientCertificateMessage(
      hsmClientCertificateIdentifier: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateHsmClientCertificateMessage =
      CreateHsmClientCertificateMessage
        .builder
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHsmConfigurationMessage(
      hsmConfigurationIdentifier: Option[String] = None,
      description: Option[String] = None,
      hsmIpAddress: Option[String] = None,
      hsmPartitionName: Option[String] = None,
      hsmPartitionPassword: Option[String] = None,
      hsmServerPublicCertificate: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateHsmConfigurationMessage =
      CreateHsmConfigurationMessage
        .builder
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(description)(_.description(_))
        .ifSome(hsmIpAddress)(_.hsmIpAddress(_))
        .ifSome(hsmPartitionName)(_.hsmPartitionName(_))
        .ifSome(hsmPartitionPassword)(_.hsmPartitionPassword(_))
        .ifSome(hsmServerPublicCertificate)(_.hsmServerPublicCertificate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createScheduledActionMessage(
      scheduledActionName: Option[String] = None,
      targetAction: Option[ScheduledActionType] = None,
      schedule: Option[String] = None,
      iamRole: Option[String] = None,
      scheduledActionDescription: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      enable: Option[Boolean] = None
    ): CreateScheduledActionMessage =
      CreateScheduledActionMessage
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(targetAction)(_.targetAction(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(scheduledActionDescription)(_.scheduledActionDescription(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(enable)(_.enable(_))
        .build

    def createSnapshotCopyGrantMessage(
      snapshotCopyGrantName: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateSnapshotCopyGrantMessage =
      CreateSnapshotCopyGrantMessage
        .builder
        .ifSome(snapshotCopyGrantName)(_.snapshotCopyGrantName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSnapshotScheduleMessage(
      scheduleDefinitions: Option[List[String]] = None,
      scheduleIdentifier: Option[String] = None,
      scheduleDescription: Option[String] = None,
      tags: Option[List[Tag]] = None,
      nextInvocations: Option[Int] = None
    ): CreateSnapshotScheduleMessage =
      CreateSnapshotScheduleMessage
        .builder
        .ifSome(scheduleDefinitions)(_.scheduleDefinitions(_))
        .ifSome(scheduleIdentifier)(_.scheduleIdentifier(_))
        .ifSome(scheduleDescription)(_.scheduleDescription(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(nextInvocations)(_.nextInvocations(_))
        .build

    def createTagsMessage(
      resourceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateTagsMessage =
      CreateTagsMessage
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUsageLimitMessage(
      clusterIdentifier: Option[String] = None,
      featureType: Option[String] = None,
      limitType: Option[String] = None,
      amount: Option[Long] = None,
      period: Option[String] = None,
      breachAction: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateUsageLimitMessage =
      CreateUsageLimitMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(featureType)(_.featureType(_))
        .ifSome(limitType)(_.limitType(_))
        .ifSome(amount)(_.amount(_))
        .ifSome(period)(_.period(_))
        .ifSome(breachAction)(_.breachAction(_))
        .ifSome(tags)(_.tags(_))
        .build

    def customerStorageMessage(
      totalBackupSizeInMegaBytes: Option[Double] = None,
      totalProvisionedStorageInMegaBytes: Option[Double] = None
    ): CustomerStorageMessage =
      CustomerStorageMessage
        .builder
        .ifSome(totalBackupSizeInMegaBytes)(_.totalBackupSizeInMegaBytes(_))
        .ifSome(totalProvisionedStorageInMegaBytes)(_.totalProvisionedStorageInMegaBytes(_))
        .build

    def dataTransferProgress(
      status: Option[String] = None,
      currentRateInMegaBytesPerSecond: Option[DoubleOptional] = None,
      totalDataInMegaBytes: Option[Long] = None,
      dataTransferredInMegaBytes: Option[Long] = None,
      estimatedTimeToCompletionInSeconds: Option[LongOptional] = None,
      elapsedTimeInSeconds: Option[LongOptional] = None
    ): DataTransferProgress =
      DataTransferProgress
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(currentRateInMegaBytesPerSecond)(_.currentRateInMegaBytesPerSecond(_))
        .ifSome(totalDataInMegaBytes)(_.totalDataInMegaBytes(_))
        .ifSome(dataTransferredInMegaBytes)(_.dataTransferredInMegaBytes(_))
        .ifSome(estimatedTimeToCompletionInSeconds)(_.estimatedTimeToCompletionInSeconds(_))
        .ifSome(elapsedTimeInSeconds)(_.elapsedTimeInSeconds(_))
        .build

    def defaultClusterParameters(
      parameterGroupFamily: Option[String] = None,
      marker: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): DefaultClusterParameters =
      DefaultClusterParameters
        .builder
        .ifSome(parameterGroupFamily)(_.parameterGroupFamily(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def deferredMaintenanceWindow(
      deferMaintenanceIdentifier: Option[String] = None,
      deferMaintenanceStartTime: Option[TStamp] = None,
      deferMaintenanceEndTime: Option[TStamp] = None
    ): DeferredMaintenanceWindow =
      DeferredMaintenanceWindow
        .builder
        .ifSome(deferMaintenanceIdentifier)(_.deferMaintenanceIdentifier(_))
        .ifSome(deferMaintenanceStartTime)(_.deferMaintenanceStartTime(_))
        .ifSome(deferMaintenanceEndTime)(_.deferMaintenanceEndTime(_))
        .build

    def deleteClusterMessage(
      clusterIdentifier: Option[String] = None,
      skipFinalClusterSnapshot: Option[Boolean] = None,
      finalClusterSnapshotIdentifier: Option[String] = None,
      finalClusterSnapshotRetentionPeriod: Option[Int] = None
    ): DeleteClusterMessage =
      DeleteClusterMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(skipFinalClusterSnapshot)(_.skipFinalClusterSnapshot(_))
        .ifSome(finalClusterSnapshotIdentifier)(_.finalClusterSnapshotIdentifier(_))
        .ifSome(finalClusterSnapshotRetentionPeriod)(_.finalClusterSnapshotRetentionPeriod(_))
        .build

    def deleteClusterParameterGroupMessage(
      parameterGroupName: Option[String] = None
    ): DeleteClusterParameterGroupMessage =
      DeleteClusterParameterGroupMessage
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .build

    def deleteClusterSecurityGroupMessage(
      clusterSecurityGroupName: Option[String] = None
    ): DeleteClusterSecurityGroupMessage =
      DeleteClusterSecurityGroupMessage
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .build

    def deleteClusterSnapshotMessage(
      snapshotIdentifier: Option[String] = None,
      snapshotClusterIdentifier: Option[String] = None
    ): DeleteClusterSnapshotMessage =
      DeleteClusterSnapshotMessage
        .builder
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(snapshotClusterIdentifier)(_.snapshotClusterIdentifier(_))
        .build

    def deleteClusterSubnetGroupMessage(
      clusterSubnetGroupName: Option[String] = None
    ): DeleteClusterSubnetGroupMessage =
      DeleteClusterSubnetGroupMessage
        .builder
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .build

    def deleteEndpointAccessMessage(
      endpointName: Option[String] = None
    ): DeleteEndpointAccessMessage =
      DeleteEndpointAccessMessage
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .build

    def deleteEventSubscriptionMessage(
      subscriptionName: Option[String] = None
    ): DeleteEventSubscriptionMessage =
      DeleteEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .build

    def deleteHsmClientCertificateMessage(
      hsmClientCertificateIdentifier: Option[String] = None
    ): DeleteHsmClientCertificateMessage =
      DeleteHsmClientCertificateMessage
        .builder
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .build

    def deleteHsmConfigurationMessage(
      hsmConfigurationIdentifier: Option[String] = None
    ): DeleteHsmConfigurationMessage =
      DeleteHsmConfigurationMessage
        .builder
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .build

    def deleteScheduledActionMessage(
      scheduledActionName: Option[String] = None
    ): DeleteScheduledActionMessage =
      DeleteScheduledActionMessage
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .build

    def deleteSnapshotCopyGrantMessage(
      snapshotCopyGrantName: Option[String] = None
    ): DeleteSnapshotCopyGrantMessage =
      DeleteSnapshotCopyGrantMessage
        .builder
        .ifSome(snapshotCopyGrantName)(_.snapshotCopyGrantName(_))
        .build

    def deleteSnapshotScheduleMessage(
      scheduleIdentifier: Option[String] = None
    ): DeleteSnapshotScheduleMessage =
      DeleteSnapshotScheduleMessage
        .builder
        .ifSome(scheduleIdentifier)(_.scheduleIdentifier(_))
        .build

    def deleteTagsMessage(
      resourceName: Option[String] = None,
      tagKeys: Option[List[String]] = None
    ): DeleteTagsMessage =
      DeleteTagsMessage
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def deleteUsageLimitMessage(
      usageLimitId: Option[String] = None
    ): DeleteUsageLimitMessage =
      DeleteUsageLimitMessage
        .builder
        .ifSome(usageLimitId)(_.usageLimitId(_))
        .build

    def dependentServiceRequestThrottlingFault(

    ): DependentServiceRequestThrottlingFault =
      DependentServiceRequestThrottlingFault
        .builder

        .build

    def dependentServiceUnavailableFault(

    ): DependentServiceUnavailableFault =
      DependentServiceUnavailableFault
        .builder

        .build

    def describeAccountAttributesMessage(
      attributeNames: Option[List[String]] = None
    ): DescribeAccountAttributesMessage =
      DescribeAccountAttributesMessage
        .builder
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def describeClusterDbRevisionsMessage(
      clusterIdentifier: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeClusterDbRevisionsMessage =
      DescribeClusterDbRevisionsMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeClusterParameterGroupsMessage(
      parameterGroupName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeClusterParameterGroupsMessage =
      DescribeClusterParameterGroupsMessage
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeClusterParametersMessage(
      parameterGroupName: Option[String] = None,
      source: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeClusterParametersMessage =
      DescribeClusterParametersMessage
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(source)(_.source(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeClusterSecurityGroupsMessage(
      clusterSecurityGroupName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeClusterSecurityGroupsMessage =
      DescribeClusterSecurityGroupsMessage
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeClusterSnapshotsMessage(
      clusterIdentifier: Option[String] = None,
      snapshotIdentifier: Option[String] = None,
      snapshotType: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      ownerAccount: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None,
      clusterExists: Option[Boolean] = None,
      sortingEntities: Option[List[SnapshotSortingEntity]] = None
    ): DescribeClusterSnapshotsMessage =
      DescribeClusterSnapshotsMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .ifSome(clusterExists)(_.clusterExists(_))
        .ifSome(sortingEntities)(_.sortingEntities(_))
        .build

    def describeClusterSubnetGroupsMessage(
      clusterSubnetGroupName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeClusterSubnetGroupsMessage =
      DescribeClusterSubnetGroupsMessage
        .builder
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeClusterTracksMessage(
      maintenanceTrackName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeClusterTracksMessage =
      DescribeClusterTracksMessage
        .builder
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeClusterVersionsMessage(
      clusterVersion: Option[String] = None,
      clusterParameterGroupFamily: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeClusterVersionsMessage =
      DescribeClusterVersionsMessage
        .builder
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(clusterParameterGroupFamily)(_.clusterParameterGroupFamily(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeClustersMessage(
      clusterIdentifier: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeClustersMessage =
      DescribeClustersMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeDefaultClusterParametersMessage(
      parameterGroupFamily: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDefaultClusterParametersMessage =
      DescribeDefaultClusterParametersMessage
        .builder
        .ifSome(parameterGroupFamily)(_.parameterGroupFamily(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEndpointAccessMessage(
      clusterIdentifier: Option[String] = None,
      resourceOwner: Option[String] = None,
      endpointName: Option[String] = None,
      vpcId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEndpointAccessMessage =
      DescribeEndpointAccessMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEndpointAuthorizationMessage(
      clusterIdentifier: Option[String] = None,
      account: Option[String] = None,
      grantee: Option[Boolean] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEndpointAuthorizationMessage =
      DescribeEndpointAuthorizationMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(account)(_.account(_))
        .ifSome(grantee)(_.grantee(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEventCategoriesMessage(
      sourceType: Option[String] = None
    ): DescribeEventCategoriesMessage =
      DescribeEventCategoriesMessage
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .build

    def describeEventSubscriptionsMessage(
      subscriptionName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeEventSubscriptionsMessage =
      DescribeEventSubscriptionsMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeEventsMessage(
      sourceIdentifier: Option[String] = None,
      sourceType: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      duration: Option[Int] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEventsMessage =
      DescribeEventsMessage
        .builder
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeHsmClientCertificatesMessage(
      hsmClientCertificateIdentifier: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeHsmClientCertificatesMessage =
      DescribeHsmClientCertificatesMessage
        .builder
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeHsmConfigurationsMessage(
      hsmConfigurationIdentifier: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeHsmConfigurationsMessage =
      DescribeHsmConfigurationsMessage
        .builder
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeLoggingStatusMessage(
      clusterIdentifier: Option[String] = None
    ): DescribeLoggingStatusMessage =
      DescribeLoggingStatusMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def describeNodeConfigurationOptionsMessage(
      actionType: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      snapshotIdentifier: Option[String] = None,
      ownerAccount: Option[String] = None,
      filters: Option[List[NodeConfigurationOptionsFilter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeNodeConfigurationOptionsMessage =
      DescribeNodeConfigurationOptionsMessage
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeOrderableClusterOptionsMessage(
      clusterVersion: Option[String] = None,
      nodeType: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeOrderableClusterOptionsMessage =
      DescribeOrderableClusterOptionsMessage
        .builder
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describePartnersInputMessage(
      accountId: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      databaseName: Option[String] = None,
      partnerName: Option[String] = None
    ): DescribePartnersInputMessage =
      DescribePartnersInputMessage
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(partnerName)(_.partnerName(_))
        .build

    def describePartnersOutputMessage(
      partnerIntegrationInfoList: Option[List[PartnerIntegrationInfo]] = None
    ): DescribePartnersOutputMessage =
      DescribePartnersOutputMessage
        .builder
        .ifSome(partnerIntegrationInfoList)(_.partnerIntegrationInfoList(_))
        .build

    def describeReservedNodeOfferingsMessage(
      reservedNodeOfferingId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReservedNodeOfferingsMessage =
      DescribeReservedNodeOfferingsMessage
        .builder
        .ifSome(reservedNodeOfferingId)(_.reservedNodeOfferingId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReservedNodesMessage(
      reservedNodeId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReservedNodesMessage =
      DescribeReservedNodesMessage
        .builder
        .ifSome(reservedNodeId)(_.reservedNodeId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeResizeMessage(
      clusterIdentifier: Option[String] = None
    ): DescribeResizeMessage =
      DescribeResizeMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def describeScheduledActionsMessage(
      scheduledActionName: Option[String] = None,
      targetActionType: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      active: Option[Boolean] = None,
      filters: Option[List[ScheduledActionFilter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeScheduledActionsMessage =
      DescribeScheduledActionsMessage
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(targetActionType)(_.targetActionType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(active)(_.active(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeSnapshotCopyGrantsMessage(
      snapshotCopyGrantName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeSnapshotCopyGrantsMessage =
      DescribeSnapshotCopyGrantsMessage
        .builder
        .ifSome(snapshotCopyGrantName)(_.snapshotCopyGrantName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeSnapshotSchedulesMessage(
      clusterIdentifier: Option[String] = None,
      scheduleIdentifier: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeSnapshotSchedulesMessage =
      DescribeSnapshotSchedulesMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(scheduleIdentifier)(_.scheduleIdentifier(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeSnapshotSchedulesOutputMessage(
      snapshotSchedules: Option[List[SnapshotSchedule]] = None,
      marker: Option[String] = None
    ): DescribeSnapshotSchedulesOutputMessage =
      DescribeSnapshotSchedulesOutputMessage
        .builder
        .ifSome(snapshotSchedules)(_.snapshotSchedules(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeTableRestoreStatusMessage(
      clusterIdentifier: Option[String] = None,
      tableRestoreRequestId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeTableRestoreStatusMessage =
      DescribeTableRestoreStatusMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(tableRestoreRequestId)(_.tableRestoreRequestId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeTagsMessage(
      resourceName: Option[String] = None,
      resourceType: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeTagsMessage =
      DescribeTagsMessage
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def describeUsageLimitsMessage(
      usageLimitId: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      featureType: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      tagKeys: Option[List[String]] = None,
      tagValues: Option[List[String]] = None
    ): DescribeUsageLimitsMessage =
      DescribeUsageLimitsMessage
        .builder
        .ifSome(usageLimitId)(_.usageLimitId(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(featureType)(_.featureType(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def disableLoggingMessage(
      clusterIdentifier: Option[String] = None
    ): DisableLoggingMessage =
      DisableLoggingMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def disableSnapshotCopyMessage(
      clusterIdentifier: Option[String] = None
    ): DisableSnapshotCopyMessage =
      DisableSnapshotCopyMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def eC2SecurityGroup(
      status: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): EC2SecurityGroup =
      EC2SecurityGroup
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def elasticIpStatus(
      elasticIp: Option[String] = None,
      status: Option[String] = None
    ): ElasticIpStatus =
      ElasticIpStatus
        .builder
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(status)(_.status(_))
        .build

    def enableLoggingMessage(
      clusterIdentifier: Option[String] = None,
      bucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None
    ): EnableLoggingMessage =
      EnableLoggingMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .build

    def enableSnapshotCopyMessage(
      clusterIdentifier: Option[String] = None,
      destinationRegion: Option[String] = None,
      retentionPeriod: Option[Int] = None,
      snapshotCopyGrantName: Option[String] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None
    ): EnableSnapshotCopyMessage =
      EnableSnapshotCopyMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(destinationRegion)(_.destinationRegion(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(snapshotCopyGrantName)(_.snapshotCopyGrantName(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .build

    def endpoint(
      address: Option[String] = None,
      port: Option[Int] = None,
      vpcEndpoints: Option[List[VpcEndpoint]] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(port)(_.port(_))
        .ifSome(vpcEndpoints)(_.vpcEndpoints(_))
        .build

    def endpointAccess(
      clusterIdentifier: Option[String] = None,
      resourceOwner: Option[String] = None,
      subnetGroupName: Option[String] = None,
      endpointStatus: Option[String] = None,
      endpointName: Option[String] = None,
      endpointCreateTime: Option[TStamp] = None,
      port: Option[Int] = None,
      address: Option[String] = None,
      vpcSecurityGroups: Option[List[VpcSecurityGroupMembership]] = None,
      vpcEndpoint: Option[VpcEndpoint] = None
    ): EndpointAccess =
      EndpointAccess
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(subnetGroupName)(_.subnetGroupName(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(endpointCreateTime)(_.endpointCreateTime(_))
        .ifSome(port)(_.port(_))
        .ifSome(address)(_.address(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .ifSome(vpcEndpoint)(_.vpcEndpoint(_))
        .build

    def endpointAccessList(
      endpointAccessList: Option[List[EndpointAccess]] = None,
      marker: Option[String] = None
    ): EndpointAccessList =
      EndpointAccessList
        .builder
        .ifSome(endpointAccessList)(_.endpointAccessList(_))
        .ifSome(marker)(_.marker(_))
        .build

    def endpointAlreadyExistsFault(

    ): EndpointAlreadyExistsFault =
      EndpointAlreadyExistsFault
        .builder

        .build

    def endpointAuthorization(
      grantor: Option[String] = None,
      grantee: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      authorizeTime: Option[TStamp] = None,
      clusterStatus: Option[String] = None,
      status: Option[String] = None,
      allowedAllVPCs: Option[Boolean] = None,
      allowedVPCs: Option[List[String]] = None,
      endpointCount: Option[Int] = None
    ): EndpointAuthorization =
      EndpointAuthorization
        .builder
        .ifSome(grantor)(_.grantor(_))
        .ifSome(grantee)(_.grantee(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(authorizeTime)(_.authorizeTime(_))
        .ifSome(clusterStatus)(_.clusterStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(allowedAllVPCs)(_.allowedAllVPCs(_))
        .ifSome(allowedVPCs)(_.allowedVPCs(_))
        .ifSome(endpointCount)(_.endpointCount(_))
        .build

    def endpointAuthorizationAlreadyExistsFault(

    ): EndpointAuthorizationAlreadyExistsFault =
      EndpointAuthorizationAlreadyExistsFault
        .builder

        .build

    def endpointAuthorizationList(
      endpointAuthorizationList: Option[List[EndpointAuthorization]] = None,
      marker: Option[String] = None
    ): EndpointAuthorizationList =
      EndpointAuthorizationList
        .builder
        .ifSome(endpointAuthorizationList)(_.endpointAuthorizationList(_))
        .ifSome(marker)(_.marker(_))
        .build

    def endpointAuthorizationNotFoundFault(

    ): EndpointAuthorizationNotFoundFault =
      EndpointAuthorizationNotFoundFault
        .builder

        .build

    def endpointAuthorizationsPerClusterLimitExceededFault(

    ): EndpointAuthorizationsPerClusterLimitExceededFault =
      EndpointAuthorizationsPerClusterLimitExceededFault
        .builder

        .build

    def endpointNotFoundFault(

    ): EndpointNotFoundFault =
      EndpointNotFoundFault
        .builder

        .build

    def endpointsPerAuthorizationLimitExceededFault(

    ): EndpointsPerAuthorizationLimitExceededFault =
      EndpointsPerAuthorizationLimitExceededFault
        .builder

        .build

    def endpointsPerClusterLimitExceededFault(

    ): EndpointsPerClusterLimitExceededFault =
      EndpointsPerClusterLimitExceededFault
        .builder

        .build

    def event(
      sourceIdentifier: Option[String] = None,
      sourceType: Option[String] = None,
      message: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      severity: Option[String] = None,
      date: Option[TStamp] = None,
      eventId: Option[String] = None
    ): Event =
      Event
        .builder
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(message)(_.message(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(date)(_.date(_))
        .ifSome(eventId)(_.eventId(_))
        .build

    def eventCategoriesMap(
      sourceType: Option[String] = None,
      events: Option[List[EventInfoMap]] = None
    ): EventCategoriesMap =
      EventCategoriesMap
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(events)(_.events(_))
        .build

    def eventCategoriesMessage(
      eventCategoriesMapList: Option[List[EventCategoriesMap]] = None
    ): EventCategoriesMessage =
      EventCategoriesMessage
        .builder
        .ifSome(eventCategoriesMapList)(_.eventCategoriesMapList(_))
        .build

    def eventInfoMap(
      eventId: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      eventDescription: Option[String] = None,
      severity: Option[String] = None
    ): EventInfoMap =
      EventInfoMap
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(eventDescription)(_.eventDescription(_))
        .ifSome(severity)(_.severity(_))
        .build

    def eventSubscription(
      customerAwsId: Option[String] = None,
      custSubscriptionId: Option[String] = None,
      snsTopicArn: Option[String] = None,
      status: Option[String] = None,
      subscriptionCreationTime: Option[TStamp] = None,
      sourceType: Option[String] = None,
      sourceIdsList: Option[List[String]] = None,
      eventCategoriesList: Option[List[String]] = None,
      severity: Option[String] = None,
      enabled: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): EventSubscription =
      EventSubscription
        .builder
        .ifSome(customerAwsId)(_.customerAwsId(_))
        .ifSome(custSubscriptionId)(_.custSubscriptionId(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(subscriptionCreationTime)(_.subscriptionCreationTime(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceIdsList)(_.sourceIdsList(_))
        .ifSome(eventCategoriesList)(_.eventCategoriesList(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(tags)(_.tags(_))
        .build

    def eventSubscriptionQuotaExceededFault(

    ): EventSubscriptionQuotaExceededFault =
      EventSubscriptionQuotaExceededFault
        .builder

        .build

    def eventSubscriptionsMessage(
      marker: Option[String] = None,
      eventSubscriptionsList: Option[List[EventSubscription]] = None
    ): EventSubscriptionsMessage =
      EventSubscriptionsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(eventSubscriptionsList)(_.eventSubscriptionsList(_))
        .build

    def eventsMessage(
      marker: Option[String] = None,
      events: Option[List[Event]] = None
    ): EventsMessage =
      EventsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(events)(_.events(_))
        .build

    def getClusterCredentialsMessage(
      dbUser: Option[String] = None,
      dbName: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      durationSeconds: Option[Int] = None,
      autoCreate: Option[Boolean] = None,
      dbGroups: Option[List[String]] = None
    ): GetClusterCredentialsMessage =
      GetClusterCredentialsMessage
        .builder
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(dbName)(_.dbName(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(autoCreate)(_.autoCreate(_))
        .ifSome(dbGroups)(_.dbGroups(_))
        .build

    def getReservedNodeExchangeOfferingsInputMessage(
      reservedNodeId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): GetReservedNodeExchangeOfferingsInputMessage =
      GetReservedNodeExchangeOfferingsInputMessage
        .builder
        .ifSome(reservedNodeId)(_.reservedNodeId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getReservedNodeExchangeOfferingsOutputMessage(
      marker: Option[String] = None,
      reservedNodeOfferings: Option[List[ReservedNodeOffering]] = None
    ): GetReservedNodeExchangeOfferingsOutputMessage =
      GetReservedNodeExchangeOfferingsOutputMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(reservedNodeOfferings)(_.reservedNodeOfferings(_))
        .build

    def hsmClientCertificate(
      hsmClientCertificateIdentifier: Option[String] = None,
      hsmClientCertificatePublicKey: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): HsmClientCertificate =
      HsmClientCertificate
        .builder
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(hsmClientCertificatePublicKey)(_.hsmClientCertificatePublicKey(_))
        .ifSome(tags)(_.tags(_))
        .build

    def hsmClientCertificateAlreadyExistsFault(

    ): HsmClientCertificateAlreadyExistsFault =
      HsmClientCertificateAlreadyExistsFault
        .builder

        .build

    def hsmClientCertificateMessage(
      marker: Option[String] = None,
      hsmClientCertificates: Option[List[HsmClientCertificate]] = None
    ): HsmClientCertificateMessage =
      HsmClientCertificateMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(hsmClientCertificates)(_.hsmClientCertificates(_))
        .build

    def hsmClientCertificateNotFoundFault(

    ): HsmClientCertificateNotFoundFault =
      HsmClientCertificateNotFoundFault
        .builder

        .build

    def hsmClientCertificateQuotaExceededFault(

    ): HsmClientCertificateQuotaExceededFault =
      HsmClientCertificateQuotaExceededFault
        .builder

        .build

    def hsmConfiguration(
      hsmConfigurationIdentifier: Option[String] = None,
      description: Option[String] = None,
      hsmIpAddress: Option[String] = None,
      hsmPartitionName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): HsmConfiguration =
      HsmConfiguration
        .builder
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(description)(_.description(_))
        .ifSome(hsmIpAddress)(_.hsmIpAddress(_))
        .ifSome(hsmPartitionName)(_.hsmPartitionName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def hsmConfigurationAlreadyExistsFault(

    ): HsmConfigurationAlreadyExistsFault =
      HsmConfigurationAlreadyExistsFault
        .builder

        .build

    def hsmConfigurationMessage(
      marker: Option[String] = None,
      hsmConfigurations: Option[List[HsmConfiguration]] = None
    ): HsmConfigurationMessage =
      HsmConfigurationMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(hsmConfigurations)(_.hsmConfigurations(_))
        .build

    def hsmConfigurationNotFoundFault(

    ): HsmConfigurationNotFoundFault =
      HsmConfigurationNotFoundFault
        .builder

        .build

    def hsmConfigurationQuotaExceededFault(

    ): HsmConfigurationQuotaExceededFault =
      HsmConfigurationQuotaExceededFault
        .builder

        .build

    def hsmStatus(
      hsmClientCertificateIdentifier: Option[String] = None,
      hsmConfigurationIdentifier: Option[String] = None,
      status: Option[String] = None
    ): HsmStatus =
      HsmStatus
        .builder
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(status)(_.status(_))
        .build

    def iPRange(
      status: Option[String] = None,
      cIDRIP: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): IPRange =
      IPRange
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(cIDRIP)(_.cIDRIP(_))
        .ifSome(tags)(_.tags(_))
        .build

    def inProgressTableRestoreQuotaExceededFault(

    ): InProgressTableRestoreQuotaExceededFault =
      InProgressTableRestoreQuotaExceededFault
        .builder

        .build

    def incompatibleOrderableOptions(

    ): IncompatibleOrderableOptions =
      IncompatibleOrderableOptions
        .builder

        .build

    def insufficientClusterCapacityFault(

    ): InsufficientClusterCapacityFault =
      InsufficientClusterCapacityFault
        .builder

        .build

    def insufficientS3BucketPolicyFault(

    ): InsufficientS3BucketPolicyFault =
      InsufficientS3BucketPolicyFault
        .builder

        .build

    def invalidAuthorizationStateFault(

    ): InvalidAuthorizationStateFault =
      InvalidAuthorizationStateFault
        .builder

        .build

    def invalidClusterParameterGroupStateFault(

    ): InvalidClusterParameterGroupStateFault =
      InvalidClusterParameterGroupStateFault
        .builder

        .build

    def invalidClusterSecurityGroupStateFault(

    ): InvalidClusterSecurityGroupStateFault =
      InvalidClusterSecurityGroupStateFault
        .builder

        .build

    def invalidClusterSnapshotScheduleStateFault(

    ): InvalidClusterSnapshotScheduleStateFault =
      InvalidClusterSnapshotScheduleStateFault
        .builder

        .build

    def invalidClusterSnapshotStateFault(

    ): InvalidClusterSnapshotStateFault =
      InvalidClusterSnapshotStateFault
        .builder

        .build

    def invalidClusterStateFault(

    ): InvalidClusterStateFault =
      InvalidClusterStateFault
        .builder

        .build

    def invalidClusterSubnetGroupStateFault(

    ): InvalidClusterSubnetGroupStateFault =
      InvalidClusterSubnetGroupStateFault
        .builder

        .build

    def invalidClusterSubnetStateFault(

    ): InvalidClusterSubnetStateFault =
      InvalidClusterSubnetStateFault
        .builder

        .build

    def invalidClusterTrackFault(

    ): InvalidClusterTrackFault =
      InvalidClusterTrackFault
        .builder

        .build

    def invalidElasticIpFault(

    ): InvalidElasticIpFault =
      InvalidElasticIpFault
        .builder

        .build

    def invalidEndpointStateFault(

    ): InvalidEndpointStateFault =
      InvalidEndpointStateFault
        .builder

        .build

    def invalidHsmClientCertificateStateFault(

    ): InvalidHsmClientCertificateStateFault =
      InvalidHsmClientCertificateStateFault
        .builder

        .build

    def invalidHsmConfigurationStateFault(

    ): InvalidHsmConfigurationStateFault =
      InvalidHsmConfigurationStateFault
        .builder

        .build

    def invalidReservedNodeStateFault(

    ): InvalidReservedNodeStateFault =
      InvalidReservedNodeStateFault
        .builder

        .build

    def invalidRestoreFault(

    ): InvalidRestoreFault =
      InvalidRestoreFault
        .builder

        .build

    def invalidRetentionPeriodFault(

    ): InvalidRetentionPeriodFault =
      InvalidRetentionPeriodFault
        .builder

        .build

    def invalidS3BucketNameFault(

    ): InvalidS3BucketNameFault =
      InvalidS3BucketNameFault
        .builder

        .build

    def invalidS3KeyPrefixFault(

    ): InvalidS3KeyPrefixFault =
      InvalidS3KeyPrefixFault
        .builder

        .build

    def invalidScheduleFault(

    ): InvalidScheduleFault =
      InvalidScheduleFault
        .builder

        .build

    def invalidScheduledActionFault(

    ): InvalidScheduledActionFault =
      InvalidScheduledActionFault
        .builder

        .build

    def invalidSnapshotCopyGrantStateFault(

    ): InvalidSnapshotCopyGrantStateFault =
      InvalidSnapshotCopyGrantStateFault
        .builder

        .build

    def invalidSubnet(

    ): InvalidSubnet =
      InvalidSubnet
        .builder

        .build

    def invalidSubscriptionStateFault(

    ): InvalidSubscriptionStateFault =
      InvalidSubscriptionStateFault
        .builder

        .build

    def invalidTableRestoreArgumentFault(

    ): InvalidTableRestoreArgumentFault =
      InvalidTableRestoreArgumentFault
        .builder

        .build

    def invalidTagFault(

    ): InvalidTagFault =
      InvalidTagFault
        .builder

        .build

    def invalidUsageLimitFault(

    ): InvalidUsageLimitFault =
      InvalidUsageLimitFault
        .builder

        .build

    def invalidVPCNetworkStateFault(

    ): InvalidVPCNetworkStateFault =
      InvalidVPCNetworkStateFault
        .builder

        .build

    def limitExceededFault(

    ): LimitExceededFault =
      LimitExceededFault
        .builder

        .build

    def loggingStatus(
      loggingEnabled: Option[Boolean] = None,
      bucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      lastSuccessfulDeliveryTime: Option[TStamp] = None,
      lastFailureTime: Option[TStamp] = None,
      lastFailureMessage: Option[String] = None
    ): LoggingStatus =
      LoggingStatus
        .builder
        .ifSome(loggingEnabled)(_.loggingEnabled(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(lastSuccessfulDeliveryTime)(_.lastSuccessfulDeliveryTime(_))
        .ifSome(lastFailureTime)(_.lastFailureTime(_))
        .ifSome(lastFailureMessage)(_.lastFailureMessage(_))
        .build

    def maintenanceTrack(
      maintenanceTrackName: Option[String] = None,
      databaseVersion: Option[String] = None,
      updateTargets: Option[List[UpdateTarget]] = None
    ): MaintenanceTrack =
      MaintenanceTrack
        .builder
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(databaseVersion)(_.databaseVersion(_))
        .ifSome(updateTargets)(_.updateTargets(_))
        .build

    def modifyAquaInputMessage(
      clusterIdentifier: Option[String] = None,
      aquaConfigurationStatus: Option[String] = None
    ): ModifyAquaInputMessage =
      ModifyAquaInputMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(aquaConfigurationStatus)(_.aquaConfigurationStatus(_))
        .build

    def modifyAquaOutputMessage(
      aquaConfiguration: Option[AquaConfiguration] = None
    ): ModifyAquaOutputMessage =
      ModifyAquaOutputMessage
        .builder
        .ifSome(aquaConfiguration)(_.aquaConfiguration(_))
        .build

    def modifyClusterDbRevisionMessage(
      clusterIdentifier: Option[String] = None,
      revisionTarget: Option[String] = None
    ): ModifyClusterDbRevisionMessage =
      ModifyClusterDbRevisionMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(revisionTarget)(_.revisionTarget(_))
        .build

    def modifyClusterIamRolesMessage(
      clusterIdentifier: Option[String] = None,
      addIamRoles: Option[List[String]] = None,
      removeIamRoles: Option[List[String]] = None
    ): ModifyClusterIamRolesMessage =
      ModifyClusterIamRolesMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(addIamRoles)(_.addIamRoles(_))
        .ifSome(removeIamRoles)(_.removeIamRoles(_))
        .build

    def modifyClusterMaintenanceMessage(
      clusterIdentifier: Option[String] = None,
      deferMaintenance: Option[Boolean] = None,
      deferMaintenanceIdentifier: Option[String] = None,
      deferMaintenanceStartTime: Option[TStamp] = None,
      deferMaintenanceEndTime: Option[TStamp] = None,
      deferMaintenanceDuration: Option[Int] = None
    ): ModifyClusterMaintenanceMessage =
      ModifyClusterMaintenanceMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(deferMaintenance)(_.deferMaintenance(_))
        .ifSome(deferMaintenanceIdentifier)(_.deferMaintenanceIdentifier(_))
        .ifSome(deferMaintenanceStartTime)(_.deferMaintenanceStartTime(_))
        .ifSome(deferMaintenanceEndTime)(_.deferMaintenanceEndTime(_))
        .ifSome(deferMaintenanceDuration)(_.deferMaintenanceDuration(_))
        .build

    def modifyClusterMessage(
      clusterIdentifier: Option[String] = None,
      clusterType: Option[String] = None,
      nodeType: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      clusterSecurityGroups: Option[List[String]] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      masterUserPassword: Option[String] = None,
      clusterParameterGroupName: Option[String] = None,
      automatedSnapshotRetentionPeriod: Option[Int] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      preferredMaintenanceWindow: Option[String] = None,
      clusterVersion: Option[String] = None,
      allowVersionUpgrade: Option[Boolean] = None,
      hsmClientCertificateIdentifier: Option[String] = None,
      hsmConfigurationIdentifier: Option[String] = None,
      newClusterIdentifier: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      elasticIp: Option[String] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      maintenanceTrackName: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      availabilityZoneRelocation: Option[Boolean] = None,
      availabilityZone: Option[String] = None,
      port: Option[Int] = None
    ): ModifyClusterMessage =
      ModifyClusterMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(clusterType)(_.clusterType(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(clusterSecurityGroups)(_.clusterSecurityGroups(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(clusterParameterGroupName)(_.clusterParameterGroupName(_))
        .ifSome(automatedSnapshotRetentionPeriod)(_.automatedSnapshotRetentionPeriod(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(allowVersionUpgrade)(_.allowVersionUpgrade(_))
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(newClusterIdentifier)(_.newClusterIdentifier(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(availabilityZoneRelocation)(_.availabilityZoneRelocation(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(port)(_.port(_))
        .build

    def modifyClusterParameterGroupMessage(
      parameterGroupName: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): ModifyClusterParameterGroupMessage =
      ModifyClusterParameterGroupMessage
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def modifyClusterSnapshotMessage(
      snapshotIdentifier: Option[String] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      force: Option[Boolean] = None
    ): ModifyClusterSnapshotMessage =
      ModifyClusterSnapshotMessage
        .builder
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(force)(_.force(_))
        .build

    def modifyClusterSnapshotScheduleMessage(
      clusterIdentifier: Option[String] = None,
      scheduleIdentifier: Option[String] = None,
      disassociateSchedule: Option[Boolean] = None
    ): ModifyClusterSnapshotScheduleMessage =
      ModifyClusterSnapshotScheduleMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(scheduleIdentifier)(_.scheduleIdentifier(_))
        .ifSome(disassociateSchedule)(_.disassociateSchedule(_))
        .build

    def modifyClusterSubnetGroupMessage(
      clusterSubnetGroupName: Option[String] = None,
      description: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): ModifyClusterSubnetGroupMessage =
      ModifyClusterSubnetGroupMessage
        .builder
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def modifyEndpointAccessMessage(
      endpointName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None
    ): ModifyEndpointAccessMessage =
      ModifyEndpointAccessMessage
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .build

    def modifyEventSubscriptionMessage(
      subscriptionName: Option[String] = None,
      snsTopicArn: Option[String] = None,
      sourceType: Option[String] = None,
      sourceIds: Option[List[String]] = None,
      eventCategories: Option[List[String]] = None,
      severity: Option[String] = None,
      enabled: Option[Boolean] = None
    ): ModifyEventSubscriptionMessage =
      ModifyEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceIds)(_.sourceIds(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def modifyScheduledActionMessage(
      scheduledActionName: Option[String] = None,
      targetAction: Option[ScheduledActionType] = None,
      schedule: Option[String] = None,
      iamRole: Option[String] = None,
      scheduledActionDescription: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      enable: Option[Boolean] = None
    ): ModifyScheduledActionMessage =
      ModifyScheduledActionMessage
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(targetAction)(_.targetAction(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(scheduledActionDescription)(_.scheduledActionDescription(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(enable)(_.enable(_))
        .build

    def modifySnapshotCopyRetentionPeriodMessage(
      clusterIdentifier: Option[String] = None,
      retentionPeriod: Option[Int] = None,
      manual: Option[Boolean] = None
    ): ModifySnapshotCopyRetentionPeriodMessage =
      ModifySnapshotCopyRetentionPeriodMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(manual)(_.manual(_))
        .build

    def modifySnapshotScheduleMessage(
      scheduleIdentifier: Option[String] = None,
      scheduleDefinitions: Option[List[String]] = None
    ): ModifySnapshotScheduleMessage =
      ModifySnapshotScheduleMessage
        .builder
        .ifSome(scheduleIdentifier)(_.scheduleIdentifier(_))
        .ifSome(scheduleDefinitions)(_.scheduleDefinitions(_))
        .build

    def modifyUsageLimitMessage(
      usageLimitId: Option[String] = None,
      amount: Option[LongOptional] = None,
      breachAction: Option[String] = None
    ): ModifyUsageLimitMessage =
      ModifyUsageLimitMessage
        .builder
        .ifSome(usageLimitId)(_.usageLimitId(_))
        .ifSome(amount)(_.amount(_))
        .ifSome(breachAction)(_.breachAction(_))
        .build

    def networkInterface(
      networkInterfaceId: Option[String] = None,
      subnetId: Option[String] = None,
      privateIpAddress: Option[String] = None,
      availabilityZone: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .build

    def nodeConfigurationOption(
      nodeType: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      estimatedDiskUtilizationPercent: Option[DoubleOptional] = None,
      mode: Option[String] = None
    ): NodeConfigurationOption =
      NodeConfigurationOption
        .builder
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(estimatedDiskUtilizationPercent)(_.estimatedDiskUtilizationPercent(_))
        .ifSome(mode)(_.mode(_))
        .build

    def nodeConfigurationOptionsFilter(
      name: Option[String] = None,
      operator: Option[String] = None,
      values: Option[List[String]] = None
    ): NodeConfigurationOptionsFilter =
      NodeConfigurationOptionsFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(values)(_.values(_))
        .build

    def nodeConfigurationOptionsMessage(
      nodeConfigurationOptionList: Option[List[NodeConfigurationOption]] = None,
      marker: Option[String] = None
    ): NodeConfigurationOptionsMessage =
      NodeConfigurationOptionsMessage
        .builder
        .ifSome(nodeConfigurationOptionList)(_.nodeConfigurationOptionList(_))
        .ifSome(marker)(_.marker(_))
        .build

    def numberOfNodesPerClusterLimitExceededFault(

    ): NumberOfNodesPerClusterLimitExceededFault =
      NumberOfNodesPerClusterLimitExceededFault
        .builder

        .build

    def numberOfNodesQuotaExceededFault(

    ): NumberOfNodesQuotaExceededFault =
      NumberOfNodesQuotaExceededFault
        .builder

        .build

    def orderableClusterOption(
      clusterVersion: Option[String] = None,
      clusterType: Option[String] = None,
      nodeType: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None
    ): OrderableClusterOption =
      OrderableClusterOption
        .builder
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(clusterType)(_.clusterType(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def orderableClusterOptionsMessage(
      orderableClusterOptions: Option[List[OrderableClusterOption]] = None,
      marker: Option[String] = None
    ): OrderableClusterOptionsMessage =
      OrderableClusterOptionsMessage
        .builder
        .ifSome(orderableClusterOptions)(_.orderableClusterOptions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def parameter(
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None,
      description: Option[String] = None,
      source: Option[String] = None,
      dataType: Option[String] = None,
      allowedValues: Option[String] = None,
      applyType: Option[String] = None,
      isModifiable: Option[Boolean] = None,
      minimumEngineVersion: Option[String] = None
    ): Parameter =
      Parameter
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(applyType)(_.applyType(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(minimumEngineVersion)(_.minimumEngineVersion(_))
        .build

    def partnerIntegrationInfo(
      databaseName: Option[String] = None,
      partnerName: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      createdAt: Option[TStamp] = None,
      updatedAt: Option[TStamp] = None
    ): PartnerIntegrationInfo =
      PartnerIntegrationInfo
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(partnerName)(_.partnerName(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def partnerIntegrationInputMessage(
      accountId: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      databaseName: Option[String] = None,
      partnerName: Option[String] = None
    ): PartnerIntegrationInputMessage =
      PartnerIntegrationInputMessage
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(partnerName)(_.partnerName(_))
        .build

    def partnerIntegrationOutputMessage(
      databaseName: Option[String] = None,
      partnerName: Option[String] = None
    ): PartnerIntegrationOutputMessage =
      PartnerIntegrationOutputMessage
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(partnerName)(_.partnerName(_))
        .build

    def partnerNotFoundFault(

    ): PartnerNotFoundFault =
      PartnerNotFoundFault
        .builder

        .build

    def pauseClusterMessage(
      clusterIdentifier: Option[String] = None
    ): PauseClusterMessage =
      PauseClusterMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def pendingModifiedValues(
      masterUserPassword: Option[String] = None,
      nodeType: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      clusterType: Option[String] = None,
      clusterVersion: Option[String] = None,
      automatedSnapshotRetentionPeriod: Option[Int] = None,
      clusterIdentifier: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      maintenanceTrackName: Option[String] = None,
      encryptionType: Option[String] = None
    ): PendingModifiedValues =
      PendingModifiedValues
        .builder
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(clusterType)(_.clusterType(_))
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(automatedSnapshotRetentionPeriod)(_.automatedSnapshotRetentionPeriod(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .build

    def purchaseReservedNodeOfferingMessage(
      reservedNodeOfferingId: Option[String] = None,
      nodeCount: Option[Int] = None
    ): PurchaseReservedNodeOfferingMessage =
      PurchaseReservedNodeOfferingMessage
        .builder
        .ifSome(reservedNodeOfferingId)(_.reservedNodeOfferingId(_))
        .ifSome(nodeCount)(_.nodeCount(_))
        .build

    def rebootClusterMessage(
      clusterIdentifier: Option[String] = None
    ): RebootClusterMessage =
      RebootClusterMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def recurringCharge(
      recurringChargeAmount: Option[Double] = None,
      recurringChargeFrequency: Option[String] = None
    ): RecurringCharge =
      RecurringCharge
        .builder
        .ifSome(recurringChargeAmount)(_.recurringChargeAmount(_))
        .ifSome(recurringChargeFrequency)(_.recurringChargeFrequency(_))
        .build

    def reservedNode(
      reservedNodeId: Option[String] = None,
      reservedNodeOfferingId: Option[String] = None,
      nodeType: Option[String] = None,
      startTime: Option[TStamp] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      currencyCode: Option[String] = None,
      nodeCount: Option[Int] = None,
      state: Option[String] = None,
      offeringType: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None,
      reservedNodeOfferingType: Option[String] = None
    ): ReservedNode =
      ReservedNode
        .builder
        .ifSome(reservedNodeId)(_.reservedNodeId(_))
        .ifSome(reservedNodeOfferingId)(_.reservedNodeOfferingId(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(nodeCount)(_.nodeCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .ifSome(reservedNodeOfferingType)(_.reservedNodeOfferingType(_))
        .build

    def reservedNodeAlreadyExistsFault(

    ): ReservedNodeAlreadyExistsFault =
      ReservedNodeAlreadyExistsFault
        .builder

        .build

    def reservedNodeAlreadyMigratedFault(

    ): ReservedNodeAlreadyMigratedFault =
      ReservedNodeAlreadyMigratedFault
        .builder

        .build

    def reservedNodeNotFoundFault(

    ): ReservedNodeNotFoundFault =
      ReservedNodeNotFoundFault
        .builder

        .build

    def reservedNodeOffering(
      reservedNodeOfferingId: Option[String] = None,
      nodeType: Option[String] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      currencyCode: Option[String] = None,
      offeringType: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None,
      reservedNodeOfferingType: Option[String] = None
    ): ReservedNodeOffering =
      ReservedNodeOffering
        .builder
        .ifSome(reservedNodeOfferingId)(_.reservedNodeOfferingId(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .ifSome(reservedNodeOfferingType)(_.reservedNodeOfferingType(_))
        .build

    def reservedNodeOfferingNotFoundFault(

    ): ReservedNodeOfferingNotFoundFault =
      ReservedNodeOfferingNotFoundFault
        .builder

        .build

    def reservedNodeOfferingsMessage(
      marker: Option[String] = None,
      reservedNodeOfferings: Option[List[ReservedNodeOffering]] = None
    ): ReservedNodeOfferingsMessage =
      ReservedNodeOfferingsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(reservedNodeOfferings)(_.reservedNodeOfferings(_))
        .build

    def reservedNodeQuotaExceededFault(

    ): ReservedNodeQuotaExceededFault =
      ReservedNodeQuotaExceededFault
        .builder

        .build

    def reservedNodesMessage(
      marker: Option[String] = None,
      reservedNodes: Option[List[ReservedNode]] = None
    ): ReservedNodesMessage =
      ReservedNodesMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(reservedNodes)(_.reservedNodes(_))
        .build

    def resetClusterParameterGroupMessage(
      parameterGroupName: Option[String] = None,
      resetAllParameters: Option[Boolean] = None,
      parameters: Option[List[Parameter]] = None
    ): ResetClusterParameterGroupMessage =
      ResetClusterParameterGroupMessage
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(resetAllParameters)(_.resetAllParameters(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def resizeClusterMessage(
      clusterIdentifier: Option[String] = None,
      clusterType: Option[String] = None,
      nodeType: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      classic: Option[Boolean] = None
    ): ResizeClusterMessage =
      ResizeClusterMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(clusterType)(_.clusterType(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(classic)(_.classic(_))
        .build

    def resizeInfo(
      resizeType: Option[String] = None,
      allowCancelResize: Option[Boolean] = None
    ): ResizeInfo =
      ResizeInfo
        .builder
        .ifSome(resizeType)(_.resizeType(_))
        .ifSome(allowCancelResize)(_.allowCancelResize(_))
        .build

    def resizeNotFoundFault(

    ): ResizeNotFoundFault =
      ResizeNotFoundFault
        .builder

        .build

    def resizeProgressMessage(
      targetNodeType: Option[String] = None,
      targetNumberOfNodes: Option[Int] = None,
      targetClusterType: Option[String] = None,
      status: Option[String] = None,
      importTablesCompleted: Option[List[String]] = None,
      importTablesInProgress: Option[List[String]] = None,
      importTablesNotStarted: Option[List[String]] = None,
      avgResizeRateInMegaBytesPerSecond: Option[DoubleOptional] = None,
      totalResizeDataInMegaBytes: Option[LongOptional] = None,
      progressInMegaBytes: Option[LongOptional] = None,
      elapsedTimeInSeconds: Option[LongOptional] = None,
      estimatedTimeToCompletionInSeconds: Option[LongOptional] = None,
      resizeType: Option[String] = None,
      message: Option[String] = None,
      targetEncryptionType: Option[String] = None,
      dataTransferProgressPercent: Option[DoubleOptional] = None
    ): ResizeProgressMessage =
      ResizeProgressMessage
        .builder
        .ifSome(targetNodeType)(_.targetNodeType(_))
        .ifSome(targetNumberOfNodes)(_.targetNumberOfNodes(_))
        .ifSome(targetClusterType)(_.targetClusterType(_))
        .ifSome(status)(_.status(_))
        .ifSome(importTablesCompleted)(_.importTablesCompleted(_))
        .ifSome(importTablesInProgress)(_.importTablesInProgress(_))
        .ifSome(importTablesNotStarted)(_.importTablesNotStarted(_))
        .ifSome(avgResizeRateInMegaBytesPerSecond)(_.avgResizeRateInMegaBytesPerSecond(_))
        .ifSome(totalResizeDataInMegaBytes)(_.totalResizeDataInMegaBytes(_))
        .ifSome(progressInMegaBytes)(_.progressInMegaBytes(_))
        .ifSome(elapsedTimeInSeconds)(_.elapsedTimeInSeconds(_))
        .ifSome(estimatedTimeToCompletionInSeconds)(_.estimatedTimeToCompletionInSeconds(_))
        .ifSome(resizeType)(_.resizeType(_))
        .ifSome(message)(_.message(_))
        .ifSome(targetEncryptionType)(_.targetEncryptionType(_))
        .ifSome(dataTransferProgressPercent)(_.dataTransferProgressPercent(_))
        .build

    def resourceNotFoundFault(

    ): ResourceNotFoundFault =
      ResourceNotFoundFault
        .builder

        .build

    def restoreFromClusterSnapshotMessage(
      clusterIdentifier: Option[String] = None,
      snapshotIdentifier: Option[String] = None,
      snapshotClusterIdentifier: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None,
      allowVersionUpgrade: Option[Boolean] = None,
      clusterSubnetGroupName: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      ownerAccount: Option[String] = None,
      hsmClientCertificateIdentifier: Option[String] = None,
      hsmConfigurationIdentifier: Option[String] = None,
      elasticIp: Option[String] = None,
      clusterParameterGroupName: Option[String] = None,
      clusterSecurityGroups: Option[List[String]] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      preferredMaintenanceWindow: Option[String] = None,
      automatedSnapshotRetentionPeriod: Option[Int] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      kmsKeyId: Option[String] = None,
      nodeType: Option[String] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      additionalInfo: Option[String] = None,
      iamRoles: Option[List[String]] = None,
      maintenanceTrackName: Option[String] = None,
      snapshotScheduleIdentifier: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      availabilityZoneRelocation: Option[Boolean] = None,
      aquaConfigurationStatus: Option[String] = None
    ): RestoreFromClusterSnapshotMessage =
      RestoreFromClusterSnapshotMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(snapshotClusterIdentifier)(_.snapshotClusterIdentifier(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(allowVersionUpgrade)(_.allowVersionUpgrade(_))
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(clusterParameterGroupName)(_.clusterParameterGroupName(_))
        .ifSome(clusterSecurityGroups)(_.clusterSecurityGroups(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(automatedSnapshotRetentionPeriod)(_.automatedSnapshotRetentionPeriod(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .ifSome(iamRoles)(_.iamRoles(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(snapshotScheduleIdentifier)(_.snapshotScheduleIdentifier(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(availabilityZoneRelocation)(_.availabilityZoneRelocation(_))
        .ifSome(aquaConfigurationStatus)(_.aquaConfigurationStatus(_))
        .build

    def restoreStatus(
      status: Option[String] = None,
      currentRestoreRateInMegaBytesPerSecond: Option[Double] = None,
      snapshotSizeInMegaBytes: Option[Long] = None,
      progressInMegaBytes: Option[Long] = None,
      elapsedTimeInSeconds: Option[Long] = None,
      estimatedTimeToCompletionInSeconds: Option[Long] = None
    ): RestoreStatus =
      RestoreStatus
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(currentRestoreRateInMegaBytesPerSecond)(_.currentRestoreRateInMegaBytesPerSecond(_))
        .ifSome(snapshotSizeInMegaBytes)(_.snapshotSizeInMegaBytes(_))
        .ifSome(progressInMegaBytes)(_.progressInMegaBytes(_))
        .ifSome(elapsedTimeInSeconds)(_.elapsedTimeInSeconds(_))
        .ifSome(estimatedTimeToCompletionInSeconds)(_.estimatedTimeToCompletionInSeconds(_))
        .build

    def restoreTableFromClusterSnapshotMessage(
      clusterIdentifier: Option[String] = None,
      snapshotIdentifier: Option[String] = None,
      sourceDatabaseName: Option[String] = None,
      sourceSchemaName: Option[String] = None,
      sourceTableName: Option[String] = None,
      targetDatabaseName: Option[String] = None,
      targetSchemaName: Option[String] = None,
      newTableName: Option[String] = None,
      enableCaseSensitiveIdentifier: Option[Boolean] = None
    ): RestoreTableFromClusterSnapshotMessage =
      RestoreTableFromClusterSnapshotMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(sourceDatabaseName)(_.sourceDatabaseName(_))
        .ifSome(sourceSchemaName)(_.sourceSchemaName(_))
        .ifSome(sourceTableName)(_.sourceTableName(_))
        .ifSome(targetDatabaseName)(_.targetDatabaseName(_))
        .ifSome(targetSchemaName)(_.targetSchemaName(_))
        .ifSome(newTableName)(_.newTableName(_))
        .ifSome(enableCaseSensitiveIdentifier)(_.enableCaseSensitiveIdentifier(_))
        .build

    def resumeClusterMessage(
      clusterIdentifier: Option[String] = None
    ): ResumeClusterMessage =
      ResumeClusterMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def revisionTarget(
      databaseRevision: Option[String] = None,
      description: Option[String] = None,
      databaseRevisionReleaseDate: Option[TStamp] = None
    ): RevisionTarget =
      RevisionTarget
        .builder
        .ifSome(databaseRevision)(_.databaseRevision(_))
        .ifSome(description)(_.description(_))
        .ifSome(databaseRevisionReleaseDate)(_.databaseRevisionReleaseDate(_))
        .build

    def revokeClusterSecurityGroupIngressMessage(
      clusterSecurityGroupName: Option[String] = None,
      cIDRIP: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): RevokeClusterSecurityGroupIngressMessage =
      RevokeClusterSecurityGroupIngressMessage
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .ifSome(cIDRIP)(_.cIDRIP(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
        .build

    def revokeEndpointAccessMessage(
      clusterIdentifier: Option[String] = None,
      account: Option[String] = None,
      vpcIds: Option[List[String]] = None,
      force: Option[Boolean] = None
    ): RevokeEndpointAccessMessage =
      RevokeEndpointAccessMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(account)(_.account(_))
        .ifSome(vpcIds)(_.vpcIds(_))
        .ifSome(force)(_.force(_))
        .build

    def revokeSnapshotAccessMessage(
      snapshotIdentifier: Option[String] = None,
      snapshotClusterIdentifier: Option[String] = None,
      accountWithRestoreAccess: Option[String] = None
    ): RevokeSnapshotAccessMessage =
      RevokeSnapshotAccessMessage
        .builder
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(snapshotClusterIdentifier)(_.snapshotClusterIdentifier(_))
        .ifSome(accountWithRestoreAccess)(_.accountWithRestoreAccess(_))
        .build

    def rotateEncryptionKeyMessage(
      clusterIdentifier: Option[String] = None
    ): RotateEncryptionKeyMessage =
      RotateEncryptionKeyMessage
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def sNSInvalidTopicFault(

    ): SNSInvalidTopicFault =
      SNSInvalidTopicFault
        .builder

        .build

    def sNSNoAuthorizationFault(

    ): SNSNoAuthorizationFault =
      SNSNoAuthorizationFault
        .builder

        .build

    def sNSTopicArnNotFoundFault(

    ): SNSTopicArnNotFoundFault =
      SNSTopicArnNotFoundFault
        .builder

        .build

    def scheduleDefinitionTypeUnsupportedFault(

    ): ScheduleDefinitionTypeUnsupportedFault =
      ScheduleDefinitionTypeUnsupportedFault
        .builder

        .build

    def scheduledAction(
      scheduledActionName: Option[String] = None,
      targetAction: Option[ScheduledActionType] = None,
      schedule: Option[String] = None,
      iamRole: Option[String] = None,
      scheduledActionDescription: Option[String] = None,
      state: Option[String] = None,
      nextInvocations: Option[List[TStamp]] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None
    ): ScheduledAction =
      ScheduledAction
        .builder
        .ifSome(scheduledActionName)(_.scheduledActionName(_))
        .ifSome(targetAction)(_.targetAction(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(scheduledActionDescription)(_.scheduledActionDescription(_))
        .ifSome(state)(_.state(_))
        .ifSome(nextInvocations)(_.nextInvocations(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def scheduledActionAlreadyExistsFault(

    ): ScheduledActionAlreadyExistsFault =
      ScheduledActionAlreadyExistsFault
        .builder

        .build

    def scheduledActionFilter(
      name: Option[String] = None,
      values: Option[List[String]] = None
    ): ScheduledActionFilter =
      ScheduledActionFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def scheduledActionNotFoundFault(

    ): ScheduledActionNotFoundFault =
      ScheduledActionNotFoundFault
        .builder

        .build

    def scheduledActionQuotaExceededFault(

    ): ScheduledActionQuotaExceededFault =
      ScheduledActionQuotaExceededFault
        .builder

        .build

    def scheduledActionType(
      resizeCluster: Option[ResizeClusterMessage] = None,
      pauseCluster: Option[PauseClusterMessage] = None,
      resumeCluster: Option[ResumeClusterMessage] = None
    ): ScheduledActionType =
      ScheduledActionType
        .builder
        .ifSome(resizeCluster)(_.resizeCluster(_))
        .ifSome(pauseCluster)(_.pauseCluster(_))
        .ifSome(resumeCluster)(_.resumeCluster(_))
        .build

    def scheduledActionTypeUnsupportedFault(

    ): ScheduledActionTypeUnsupportedFault =
      ScheduledActionTypeUnsupportedFault
        .builder

        .build

    def scheduledActionsMessage(
      marker: Option[String] = None,
      scheduledActions: Option[List[ScheduledAction]] = None
    ): ScheduledActionsMessage =
      ScheduledActionsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(scheduledActions)(_.scheduledActions(_))
        .build

    def snapshot(
      snapshotIdentifier: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      snapshotCreateTime: Option[TStamp] = None,
      status: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None,
      clusterCreateTime: Option[TStamp] = None,
      masterUsername: Option[String] = None,
      clusterVersion: Option[String] = None,
      engineFullVersion: Option[String] = None,
      snapshotType: Option[String] = None,
      nodeType: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      dBName: Option[String] = None,
      vpcId: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      encryptedWithHSM: Option[Boolean] = None,
      accountsWithRestoreAccess: Option[List[AccountWithRestoreAccess]] = None,
      ownerAccount: Option[String] = None,
      totalBackupSizeInMegaBytes: Option[Double] = None,
      actualIncrementalBackupSizeInMegaBytes: Option[Double] = None,
      backupProgressInMegaBytes: Option[Double] = None,
      currentBackupRateInMegaBytesPerSecond: Option[Double] = None,
      estimatedSecondsToCompletion: Option[Long] = None,
      elapsedTimeInSeconds: Option[Long] = None,
      sourceRegion: Option[String] = None,
      tags: Option[List[Tag]] = None,
      restorableNodeTypes: Option[List[String]] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      maintenanceTrackName: Option[String] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      manualSnapshotRemainingDays: Option[Int] = None,
      snapshotRetentionStartTime: Option[TStamp] = None
    ): Snapshot =
      Snapshot
        .builder
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(snapshotCreateTime)(_.snapshotCreateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(clusterCreateTime)(_.clusterCreateTime(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(engineFullVersion)(_.engineFullVersion(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(dBName)(_.dBName(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(encryptedWithHSM)(_.encryptedWithHSM(_))
        .ifSome(accountsWithRestoreAccess)(_.accountsWithRestoreAccess(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(totalBackupSizeInMegaBytes)(_.totalBackupSizeInMegaBytes(_))
        .ifSome(actualIncrementalBackupSizeInMegaBytes)(_.actualIncrementalBackupSizeInMegaBytes(_))
        .ifSome(backupProgressInMegaBytes)(_.backupProgressInMegaBytes(_))
        .ifSome(currentBackupRateInMegaBytesPerSecond)(_.currentBackupRateInMegaBytesPerSecond(_))
        .ifSome(estimatedSecondsToCompletion)(_.estimatedSecondsToCompletion(_))
        .ifSome(elapsedTimeInSeconds)(_.elapsedTimeInSeconds(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(restorableNodeTypes)(_.restorableNodeTypes(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(manualSnapshotRemainingDays)(_.manualSnapshotRemainingDays(_))
        .ifSome(snapshotRetentionStartTime)(_.snapshotRetentionStartTime(_))
        .build

    def snapshotCopyAlreadyDisabledFault(

    ): SnapshotCopyAlreadyDisabledFault =
      SnapshotCopyAlreadyDisabledFault
        .builder

        .build

    def snapshotCopyAlreadyEnabledFault(

    ): SnapshotCopyAlreadyEnabledFault =
      SnapshotCopyAlreadyEnabledFault
        .builder

        .build

    def snapshotCopyDisabledFault(

    ): SnapshotCopyDisabledFault =
      SnapshotCopyDisabledFault
        .builder

        .build

    def snapshotCopyGrant(
      snapshotCopyGrantName: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): SnapshotCopyGrant =
      SnapshotCopyGrant
        .builder
        .ifSome(snapshotCopyGrantName)(_.snapshotCopyGrantName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def snapshotCopyGrantAlreadyExistsFault(

    ): SnapshotCopyGrantAlreadyExistsFault =
      SnapshotCopyGrantAlreadyExistsFault
        .builder

        .build

    def snapshotCopyGrantMessage(
      marker: Option[String] = None,
      snapshotCopyGrants: Option[List[SnapshotCopyGrant]] = None
    ): SnapshotCopyGrantMessage =
      SnapshotCopyGrantMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(snapshotCopyGrants)(_.snapshotCopyGrants(_))
        .build

    def snapshotCopyGrantNotFoundFault(

    ): SnapshotCopyGrantNotFoundFault =
      SnapshotCopyGrantNotFoundFault
        .builder

        .build

    def snapshotCopyGrantQuotaExceededFault(

    ): SnapshotCopyGrantQuotaExceededFault =
      SnapshotCopyGrantQuotaExceededFault
        .builder

        .build

    def snapshotErrorMessage(
      snapshotIdentifier: Option[String] = None,
      snapshotClusterIdentifier: Option[String] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None
    ): SnapshotErrorMessage =
      SnapshotErrorMessage
        .builder
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(snapshotClusterIdentifier)(_.snapshotClusterIdentifier(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def snapshotMessage(
      marker: Option[String] = None,
      snapshots: Option[List[Snapshot]] = None
    ): SnapshotMessage =
      SnapshotMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(snapshots)(_.snapshots(_))
        .build

    def snapshotSchedule(
      scheduleDefinitions: Option[List[String]] = None,
      scheduleIdentifier: Option[String] = None,
      scheduleDescription: Option[String] = None,
      tags: Option[List[Tag]] = None,
      nextInvocations: Option[List[TStamp]] = None,
      associatedClusterCount: Option[Int] = None,
      associatedClusters: Option[List[ClusterAssociatedToSchedule]] = None
    ): SnapshotSchedule =
      SnapshotSchedule
        .builder
        .ifSome(scheduleDefinitions)(_.scheduleDefinitions(_))
        .ifSome(scheduleIdentifier)(_.scheduleIdentifier(_))
        .ifSome(scheduleDescription)(_.scheduleDescription(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(nextInvocations)(_.nextInvocations(_))
        .ifSome(associatedClusterCount)(_.associatedClusterCount(_))
        .ifSome(associatedClusters)(_.associatedClusters(_))
        .build

    def snapshotScheduleAlreadyExistsFault(

    ): SnapshotScheduleAlreadyExistsFault =
      SnapshotScheduleAlreadyExistsFault
        .builder

        .build

    def snapshotScheduleNotFoundFault(

    ): SnapshotScheduleNotFoundFault =
      SnapshotScheduleNotFoundFault
        .builder

        .build

    def snapshotScheduleQuotaExceededFault(

    ): SnapshotScheduleQuotaExceededFault =
      SnapshotScheduleQuotaExceededFault
        .builder

        .build

    def snapshotScheduleUpdateInProgressFault(

    ): SnapshotScheduleUpdateInProgressFault =
      SnapshotScheduleUpdateInProgressFault
        .builder

        .build

    def snapshotSortingEntity(
      attribute: Option[String] = None,
      sortOrder: Option[String] = None
    ): SnapshotSortingEntity =
      SnapshotSortingEntity
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def sourceNotFoundFault(

    ): SourceNotFoundFault =
      SourceNotFoundFault
        .builder

        .build

    def subnet(
      subnetIdentifier: Option[String] = None,
      subnetAvailabilityZone: Option[AvailabilityZone] = None,
      subnetStatus: Option[String] = None
    ): Subnet =
      Subnet
        .builder
        .ifSome(subnetIdentifier)(_.subnetIdentifier(_))
        .ifSome(subnetAvailabilityZone)(_.subnetAvailabilityZone(_))
        .ifSome(subnetStatus)(_.subnetStatus(_))
        .build

    def subnetAlreadyInUse(

    ): SubnetAlreadyInUse =
      SubnetAlreadyInUse
        .builder

        .build

    def subscriptionAlreadyExistFault(

    ): SubscriptionAlreadyExistFault =
      SubscriptionAlreadyExistFault
        .builder

        .build

    def subscriptionCategoryNotFoundFault(

    ): SubscriptionCategoryNotFoundFault =
      SubscriptionCategoryNotFoundFault
        .builder

        .build

    def subscriptionEventIdNotFoundFault(

    ): SubscriptionEventIdNotFoundFault =
      SubscriptionEventIdNotFoundFault
        .builder

        .build

    def subscriptionNotFoundFault(

    ): SubscriptionNotFoundFault =
      SubscriptionNotFoundFault
        .builder

        .build

    def subscriptionSeverityNotFoundFault(

    ): SubscriptionSeverityNotFoundFault =
      SubscriptionSeverityNotFoundFault
        .builder

        .build

    def supportedOperation(
      operationName: Option[String] = None
    ): SupportedOperation =
      SupportedOperation
        .builder
        .ifSome(operationName)(_.operationName(_))
        .build

    def supportedPlatform(
      name: Option[String] = None
    ): SupportedPlatform =
      SupportedPlatform
        .builder
        .ifSome(name)(_.name(_))
        .build

    def tableLimitExceededFault(

    ): TableLimitExceededFault =
      TableLimitExceededFault
        .builder

        .build

    def tableRestoreNotFoundFault(

    ): TableRestoreNotFoundFault =
      TableRestoreNotFoundFault
        .builder

        .build

    def tableRestoreStatus(
      tableRestoreRequestId: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      requestTime: Option[TStamp] = None,
      progressInMegaBytes: Option[LongOptional] = None,
      totalDataInMegaBytes: Option[LongOptional] = None,
      clusterIdentifier: Option[String] = None,
      snapshotIdentifier: Option[String] = None,
      sourceDatabaseName: Option[String] = None,
      sourceSchemaName: Option[String] = None,
      sourceTableName: Option[String] = None,
      targetDatabaseName: Option[String] = None,
      targetSchemaName: Option[String] = None,
      newTableName: Option[String] = None
    ): TableRestoreStatus =
      TableRestoreStatus
        .builder
        .ifSome(tableRestoreRequestId)(_.tableRestoreRequestId(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(requestTime)(_.requestTime(_))
        .ifSome(progressInMegaBytes)(_.progressInMegaBytes(_))
        .ifSome(totalDataInMegaBytes)(_.totalDataInMegaBytes(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(sourceDatabaseName)(_.sourceDatabaseName(_))
        .ifSome(sourceSchemaName)(_.sourceSchemaName(_))
        .ifSome(sourceTableName)(_.sourceTableName(_))
        .ifSome(targetDatabaseName)(_.targetDatabaseName(_))
        .ifSome(targetSchemaName)(_.targetSchemaName(_))
        .ifSome(newTableName)(_.newTableName(_))
        .build

    def tableRestoreStatusMessage(
      tableRestoreStatusDetails: Option[List[TableRestoreStatus]] = None,
      marker: Option[String] = None
    ): TableRestoreStatusMessage =
      TableRestoreStatusMessage
        .builder
        .ifSome(tableRestoreStatusDetails)(_.tableRestoreStatusDetails(_))
        .ifSome(marker)(_.marker(_))
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

    def tagLimitExceededFault(

    ): TagLimitExceededFault =
      TagLimitExceededFault
        .builder

        .build

    def taggedResource(
      tag: Option[Tag] = None,
      resourceName: Option[String] = None,
      resourceType: Option[String] = None
    ): TaggedResource =
      TaggedResource
        .builder
        .ifSome(tag)(_.tag(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def taggedResourceListMessage(
      taggedResources: Option[List[TaggedResource]] = None,
      marker: Option[String] = None
    ): TaggedResourceListMessage =
      TaggedResourceListMessage
        .builder
        .ifSome(taggedResources)(_.taggedResources(_))
        .ifSome(marker)(_.marker(_))
        .build

    def trackListMessage(
      maintenanceTracks: Option[List[MaintenanceTrack]] = None,
      marker: Option[String] = None
    ): TrackListMessage =
      TrackListMessage
        .builder
        .ifSome(maintenanceTracks)(_.maintenanceTracks(_))
        .ifSome(marker)(_.marker(_))
        .build

    def unauthorizedOperation(

    ): UnauthorizedOperation =
      UnauthorizedOperation
        .builder

        .build

    def unauthorizedPartnerIntegrationFault(

    ): UnauthorizedPartnerIntegrationFault =
      UnauthorizedPartnerIntegrationFault
        .builder

        .build

    def unknownSnapshotCopyRegionFault(

    ): UnknownSnapshotCopyRegionFault =
      UnknownSnapshotCopyRegionFault
        .builder

        .build

    def unsupportedOperationFault(

    ): UnsupportedOperationFault =
      UnsupportedOperationFault
        .builder

        .build

    def unsupportedOptionFault(

    ): UnsupportedOptionFault =
      UnsupportedOptionFault
        .builder

        .build

    def updatePartnerStatusInputMessage(
      accountId: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      databaseName: Option[String] = None,
      partnerName: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): UpdatePartnerStatusInputMessage =
      UpdatePartnerStatusInputMessage
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(partnerName)(_.partnerName(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def updateTarget(
      maintenanceTrackName: Option[String] = None,
      databaseVersion: Option[String] = None,
      supportedOperations: Option[List[SupportedOperation]] = None
    ): UpdateTarget =
      UpdateTarget
        .builder
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(databaseVersion)(_.databaseVersion(_))
        .ifSome(supportedOperations)(_.supportedOperations(_))
        .build

    def usageLimit(
      usageLimitId: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      featureType: Option[String] = None,
      limitType: Option[String] = None,
      amount: Option[Long] = None,
      period: Option[String] = None,
      breachAction: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): UsageLimit =
      UsageLimit
        .builder
        .ifSome(usageLimitId)(_.usageLimitId(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(featureType)(_.featureType(_))
        .ifSome(limitType)(_.limitType(_))
        .ifSome(amount)(_.amount(_))
        .ifSome(period)(_.period(_))
        .ifSome(breachAction)(_.breachAction(_))
        .ifSome(tags)(_.tags(_))
        .build

    def usageLimitAlreadyExistsFault(

    ): UsageLimitAlreadyExistsFault =
      UsageLimitAlreadyExistsFault
        .builder

        .build

    def usageLimitList(
      usageLimits: Option[List[UsageLimit]] = None,
      marker: Option[String] = None
    ): UsageLimitList =
      UsageLimitList
        .builder
        .ifSome(usageLimits)(_.usageLimits(_))
        .ifSome(marker)(_.marker(_))
        .build

    def usageLimitNotFoundFault(

    ): UsageLimitNotFoundFault =
      UsageLimitNotFoundFault
        .builder

        .build

    def vpcEndpoint(
      vpcEndpointId: Option[String] = None,
      vpcId: Option[String] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None
    ): VpcEndpoint =
      VpcEndpoint
        .builder
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .build

    def vpcSecurityGroupMembership(
      vpcSecurityGroupId: Option[String] = None,
      status: Option[String] = None
    ): VpcSecurityGroupMembership =
      VpcSecurityGroupMembership
        .builder
        .ifSome(vpcSecurityGroupId)(_.vpcSecurityGroupId(_))
        .ifSome(status)(_.status(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
