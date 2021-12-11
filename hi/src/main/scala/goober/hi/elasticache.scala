package goober.hi

import goober.free.elasticache.ElastiCacheIO
import software.amazon.awssdk.services.elasticache.model._


object elasticache {
  import goober.free.{elasticache ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aPICallRateForCustomerExceededFault(

    ): APICallRateForCustomerExceededFault =
      APICallRateForCustomerExceededFault
        .builder

        .build

    def addTagsToResourceMessage(
      resourceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsToResourceMessage =
      AddTagsToResourceMessage
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def allowedNodeTypeModificationsMessage(
      scaleUpModifications: Option[List[String]] = None,
      scaleDownModifications: Option[List[String]] = None
    ): AllowedNodeTypeModificationsMessage =
      AllowedNodeTypeModificationsMessage
        .builder
        .ifSome(scaleUpModifications)(_.scaleUpModifications(_))
        .ifSome(scaleDownModifications)(_.scaleDownModifications(_))
        .build

    def authentication(
      `type`: Option[String] = None,
      passwordCount: Option[Int] = None
    ): Authentication =
      Authentication
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(passwordCount)(_.passwordCount(_))
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

    def authorizeCacheSecurityGroupIngressMessage(
      cacheSecurityGroupName: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): AuthorizeCacheSecurityGroupIngressMessage =
      AuthorizeCacheSecurityGroupIngressMessage
        .builder
        .ifSome(cacheSecurityGroupName)(_.cacheSecurityGroupName(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
        .build

    def availabilityZone(
      name: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(name)(_.name(_))
        .build

    def batchApplyUpdateActionMessage(
      replicationGroupIds: Option[List[String]] = None,
      cacheClusterIds: Option[List[String]] = None,
      serviceUpdateName: Option[String] = None
    ): BatchApplyUpdateActionMessage =
      BatchApplyUpdateActionMessage
        .builder
        .ifSome(replicationGroupIds)(_.replicationGroupIds(_))
        .ifSome(cacheClusterIds)(_.cacheClusterIds(_))
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .build

    def batchStopUpdateActionMessage(
      replicationGroupIds: Option[List[String]] = None,
      cacheClusterIds: Option[List[String]] = None,
      serviceUpdateName: Option[String] = None
    ): BatchStopUpdateActionMessage =
      BatchStopUpdateActionMessage
        .builder
        .ifSome(replicationGroupIds)(_.replicationGroupIds(_))
        .ifSome(cacheClusterIds)(_.cacheClusterIds(_))
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .build

    def cacheCluster(
      cacheClusterId: Option[String] = None,
      configurationEndpoint: Option[Endpoint] = None,
      clientDownloadLandingPage: Option[String] = None,
      cacheNodeType: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      cacheClusterStatus: Option[String] = None,
      numCacheNodes: Option[Int] = None,
      preferredAvailabilityZone: Option[String] = None,
      preferredOutpostArn: Option[String] = None,
      cacheClusterCreateTime: Option[TStamp] = None,
      preferredMaintenanceWindow: Option[String] = None,
      pendingModifiedValues: Option[PendingModifiedValues] = None,
      notificationConfiguration: Option[NotificationConfiguration] = None,
      cacheSecurityGroups: Option[List[CacheSecurityGroupMembership]] = None,
      cacheParameterGroup: Option[CacheParameterGroupStatus] = None,
      cacheSubnetGroupName: Option[String] = None,
      cacheNodes: Option[List[CacheNode]] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      securityGroups: Option[List[SecurityGroupMembership]] = None,
      replicationGroupId: Option[String] = None,
      snapshotRetentionLimit: Option[Int] = None,
      snapshotWindow: Option[String] = None,
      authTokenEnabled: Option[Boolean] = None,
      authTokenLastModifiedDate: Option[TStamp] = None,
      transitEncryptionEnabled: Option[Boolean] = None,
      atRestEncryptionEnabled: Option[Boolean] = None,
      aRN: Option[String] = None,
      replicationGroupLogDeliveryEnabled: Option[Boolean] = None,
      logDeliveryConfigurations: Option[List[LogDeliveryConfiguration]] = None
    ): CacheCluster =
      CacheCluster
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(configurationEndpoint)(_.configurationEndpoint(_))
        .ifSome(clientDownloadLandingPage)(_.clientDownloadLandingPage(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(cacheClusterStatus)(_.cacheClusterStatus(_))
        .ifSome(numCacheNodes)(_.numCacheNodes(_))
        .ifSome(preferredAvailabilityZone)(_.preferredAvailabilityZone(_))
        .ifSome(preferredOutpostArn)(_.preferredOutpostArn(_))
        .ifSome(cacheClusterCreateTime)(_.cacheClusterCreateTime(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .ifSome(cacheSecurityGroups)(_.cacheSecurityGroups(_))
        .ifSome(cacheParameterGroup)(_.cacheParameterGroup(_))
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(cacheNodes)(_.cacheNodes(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(snapshotRetentionLimit)(_.snapshotRetentionLimit(_))
        .ifSome(snapshotWindow)(_.snapshotWindow(_))
        .ifSome(authTokenEnabled)(_.authTokenEnabled(_))
        .ifSome(authTokenLastModifiedDate)(_.authTokenLastModifiedDate(_))
        .ifSome(transitEncryptionEnabled)(_.transitEncryptionEnabled(_))
        .ifSome(atRestEncryptionEnabled)(_.atRestEncryptionEnabled(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(replicationGroupLogDeliveryEnabled)(_.replicationGroupLogDeliveryEnabled(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def cacheClusterAlreadyExistsFault(

    ): CacheClusterAlreadyExistsFault =
      CacheClusterAlreadyExistsFault
        .builder

        .build

    def cacheClusterMessage(
      marker: Option[String] = None,
      cacheClusters: Option[List[CacheCluster]] = None
    ): CacheClusterMessage =
      CacheClusterMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(cacheClusters)(_.cacheClusters(_))
        .build

    def cacheClusterNotFoundFault(

    ): CacheClusterNotFoundFault =
      CacheClusterNotFoundFault
        .builder

        .build

    def cacheEngineVersion(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      cacheParameterGroupFamily: Option[String] = None,
      cacheEngineDescription: Option[String] = None,
      cacheEngineVersionDescription: Option[String] = None
    ): CacheEngineVersion =
      CacheEngineVersion
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(cacheParameterGroupFamily)(_.cacheParameterGroupFamily(_))
        .ifSome(cacheEngineDescription)(_.cacheEngineDescription(_))
        .ifSome(cacheEngineVersionDescription)(_.cacheEngineVersionDescription(_))
        .build

    def cacheEngineVersionMessage(
      marker: Option[String] = None,
      cacheEngineVersions: Option[List[CacheEngineVersion]] = None
    ): CacheEngineVersionMessage =
      CacheEngineVersionMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(cacheEngineVersions)(_.cacheEngineVersions(_))
        .build

    def cacheNode(
      cacheNodeId: Option[String] = None,
      cacheNodeStatus: Option[String] = None,
      cacheNodeCreateTime: Option[TStamp] = None,
      endpoint: Option[Endpoint] = None,
      parameterGroupStatus: Option[String] = None,
      sourceCacheNodeId: Option[String] = None,
      customerAvailabilityZone: Option[String] = None,
      customerOutpostArn: Option[String] = None
    ): CacheNode =
      CacheNode
        .builder
        .ifSome(cacheNodeId)(_.cacheNodeId(_))
        .ifSome(cacheNodeStatus)(_.cacheNodeStatus(_))
        .ifSome(cacheNodeCreateTime)(_.cacheNodeCreateTime(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(parameterGroupStatus)(_.parameterGroupStatus(_))
        .ifSome(sourceCacheNodeId)(_.sourceCacheNodeId(_))
        .ifSome(customerAvailabilityZone)(_.customerAvailabilityZone(_))
        .ifSome(customerOutpostArn)(_.customerOutpostArn(_))
        .build

    def cacheNodeTypeSpecificParameter(
      parameterName: Option[String] = None,
      description: Option[String] = None,
      source: Option[String] = None,
      dataType: Option[String] = None,
      allowedValues: Option[String] = None,
      isModifiable: Option[Boolean] = None,
      minimumEngineVersion: Option[String] = None,
      cacheNodeTypeSpecificValues: Option[List[CacheNodeTypeSpecificValue]] = None,
      changeType: Option[String] = None
    ): CacheNodeTypeSpecificParameter =
      CacheNodeTypeSpecificParameter
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(minimumEngineVersion)(_.minimumEngineVersion(_))
        .ifSome(cacheNodeTypeSpecificValues)(_.cacheNodeTypeSpecificValues(_))
        .ifSome(changeType)(_.changeType(_))
        .build

    def cacheNodeTypeSpecificValue(
      cacheNodeType: Option[String] = None,
      value: Option[String] = None
    ): CacheNodeTypeSpecificValue =
      CacheNodeTypeSpecificValue
        .builder
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(value)(_.value(_))
        .build

    def cacheNodeUpdateStatus(
      cacheNodeId: Option[String] = None,
      nodeUpdateStatus: Option[String] = None,
      nodeDeletionDate: Option[TStamp] = None,
      nodeUpdateStartDate: Option[TStamp] = None,
      nodeUpdateEndDate: Option[TStamp] = None,
      nodeUpdateInitiatedBy: Option[String] = None,
      nodeUpdateInitiatedDate: Option[TStamp] = None,
      nodeUpdateStatusModifiedDate: Option[TStamp] = None
    ): CacheNodeUpdateStatus =
      CacheNodeUpdateStatus
        .builder
        .ifSome(cacheNodeId)(_.cacheNodeId(_))
        .ifSome(nodeUpdateStatus)(_.nodeUpdateStatus(_))
        .ifSome(nodeDeletionDate)(_.nodeDeletionDate(_))
        .ifSome(nodeUpdateStartDate)(_.nodeUpdateStartDate(_))
        .ifSome(nodeUpdateEndDate)(_.nodeUpdateEndDate(_))
        .ifSome(nodeUpdateInitiatedBy)(_.nodeUpdateInitiatedBy(_))
        .ifSome(nodeUpdateInitiatedDate)(_.nodeUpdateInitiatedDate(_))
        .ifSome(nodeUpdateStatusModifiedDate)(_.nodeUpdateStatusModifiedDate(_))
        .build

    def cacheParameterGroup(
      cacheParameterGroupName: Option[String] = None,
      cacheParameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      isGlobal: Option[Boolean] = None,
      aRN: Option[String] = None
    ): CacheParameterGroup =
      CacheParameterGroup
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(cacheParameterGroupFamily)(_.cacheParameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(isGlobal)(_.isGlobal(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def cacheParameterGroupAlreadyExistsFault(

    ): CacheParameterGroupAlreadyExistsFault =
      CacheParameterGroupAlreadyExistsFault
        .builder

        .build

    def cacheParameterGroupDetails(
      marker: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      cacheNodeTypeSpecificParameters: Option[List[CacheNodeTypeSpecificParameter]] = None
    ): CacheParameterGroupDetails =
      CacheParameterGroupDetails
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(cacheNodeTypeSpecificParameters)(_.cacheNodeTypeSpecificParameters(_))
        .build

    def cacheParameterGroupNameMessage(
      cacheParameterGroupName: Option[String] = None
    ): CacheParameterGroupNameMessage =
      CacheParameterGroupNameMessage
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .build

    def cacheParameterGroupNotFoundFault(

    ): CacheParameterGroupNotFoundFault =
      CacheParameterGroupNotFoundFault
        .builder

        .build

    def cacheParameterGroupQuotaExceededFault(

    ): CacheParameterGroupQuotaExceededFault =
      CacheParameterGroupQuotaExceededFault
        .builder

        .build

    def cacheParameterGroupStatus(
      cacheParameterGroupName: Option[String] = None,
      parameterApplyStatus: Option[String] = None,
      cacheNodeIdsToReboot: Option[List[String]] = None
    ): CacheParameterGroupStatus =
      CacheParameterGroupStatus
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .ifSome(cacheNodeIdsToReboot)(_.cacheNodeIdsToReboot(_))
        .build

    def cacheParameterGroupsMessage(
      marker: Option[String] = None,
      cacheParameterGroups: Option[List[CacheParameterGroup]] = None
    ): CacheParameterGroupsMessage =
      CacheParameterGroupsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(cacheParameterGroups)(_.cacheParameterGroups(_))
        .build

    def cacheSecurityGroup(
      ownerId: Option[String] = None,
      cacheSecurityGroupName: Option[String] = None,
      description: Option[String] = None,
      eC2SecurityGroups: Option[List[EC2SecurityGroup]] = None,
      aRN: Option[String] = None
    ): CacheSecurityGroup =
      CacheSecurityGroup
        .builder
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(cacheSecurityGroupName)(_.cacheSecurityGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(eC2SecurityGroups)(_.eC2SecurityGroups(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def cacheSecurityGroupAlreadyExistsFault(

    ): CacheSecurityGroupAlreadyExistsFault =
      CacheSecurityGroupAlreadyExistsFault
        .builder

        .build

    def cacheSecurityGroupMembership(
      cacheSecurityGroupName: Option[String] = None,
      status: Option[String] = None
    ): CacheSecurityGroupMembership =
      CacheSecurityGroupMembership
        .builder
        .ifSome(cacheSecurityGroupName)(_.cacheSecurityGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def cacheSecurityGroupMessage(
      marker: Option[String] = None,
      cacheSecurityGroups: Option[List[CacheSecurityGroup]] = None
    ): CacheSecurityGroupMessage =
      CacheSecurityGroupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(cacheSecurityGroups)(_.cacheSecurityGroups(_))
        .build

    def cacheSecurityGroupNotFoundFault(

    ): CacheSecurityGroupNotFoundFault =
      CacheSecurityGroupNotFoundFault
        .builder

        .build

    def cacheSecurityGroupQuotaExceededFault(

    ): CacheSecurityGroupQuotaExceededFault =
      CacheSecurityGroupQuotaExceededFault
        .builder

        .build

    def cacheSubnetGroup(
      cacheSubnetGroupName: Option[String] = None,
      cacheSubnetGroupDescription: Option[String] = None,
      vpcId: Option[String] = None,
      subnets: Option[List[Subnet]] = None,
      aRN: Option[String] = None
    ): CacheSubnetGroup =
      CacheSubnetGroup
        .builder
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(cacheSubnetGroupDescription)(_.cacheSubnetGroupDescription(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def cacheSubnetGroupAlreadyExistsFault(

    ): CacheSubnetGroupAlreadyExistsFault =
      CacheSubnetGroupAlreadyExistsFault
        .builder

        .build

    def cacheSubnetGroupInUse(

    ): CacheSubnetGroupInUse =
      CacheSubnetGroupInUse
        .builder

        .build

    def cacheSubnetGroupMessage(
      marker: Option[String] = None,
      cacheSubnetGroups: Option[List[CacheSubnetGroup]] = None
    ): CacheSubnetGroupMessage =
      CacheSubnetGroupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(cacheSubnetGroups)(_.cacheSubnetGroups(_))
        .build

    def cacheSubnetGroupNotFoundFault(

    ): CacheSubnetGroupNotFoundFault =
      CacheSubnetGroupNotFoundFault
        .builder

        .build

    def cacheSubnetGroupQuotaExceededFault(

    ): CacheSubnetGroupQuotaExceededFault =
      CacheSubnetGroupQuotaExceededFault
        .builder

        .build

    def cacheSubnetQuotaExceededFault(

    ): CacheSubnetQuotaExceededFault =
      CacheSubnetQuotaExceededFault
        .builder

        .build

    def cloudWatchLogsDestinationDetails(
      logGroup: Option[String] = None
    ): CloudWatchLogsDestinationDetails =
      CloudWatchLogsDestinationDetails
        .builder
        .ifSome(logGroup)(_.logGroup(_))
        .build

    def clusterQuotaForCustomerExceededFault(

    ): ClusterQuotaForCustomerExceededFault =
      ClusterQuotaForCustomerExceededFault
        .builder

        .build

    def completeMigrationMessage(
      replicationGroupId: Option[String] = None,
      force: Option[Boolean] = None
    ): CompleteMigrationMessage =
      CompleteMigrationMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(force)(_.force(_))
        .build

    def completeMigrationResponse(
      replicationGroup: Option[ReplicationGroup] = None
    ): CompleteMigrationResponse =
      CompleteMigrationResponse
        .builder
        .ifSome(replicationGroup)(_.replicationGroup(_))
        .build

    def configureShard(
      nodeGroupId: Option[String] = None,
      newReplicaCount: Option[Int] = None,
      preferredAvailabilityZones: Option[List[String]] = None,
      preferredOutpostArns: Option[List[String]] = None
    ): ConfigureShard =
      ConfigureShard
        .builder
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .ifSome(newReplicaCount)(_.newReplicaCount(_))
        .ifSome(preferredAvailabilityZones)(_.preferredAvailabilityZones(_))
        .ifSome(preferredOutpostArns)(_.preferredOutpostArns(_))
        .build

    def copySnapshotMessage(
      sourceSnapshotName: Option[String] = None,
      targetSnapshotName: Option[String] = None,
      targetBucket: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CopySnapshotMessage =
      CopySnapshotMessage
        .builder
        .ifSome(sourceSnapshotName)(_.sourceSnapshotName(_))
        .ifSome(targetSnapshotName)(_.targetSnapshotName(_))
        .ifSome(targetBucket)(_.targetBucket(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCacheClusterMessage(
      cacheClusterId: Option[String] = None,
      replicationGroupId: Option[String] = None,
      aZMode: Option[String] = None,
      preferredAvailabilityZone: Option[String] = None,
      preferredAvailabilityZones: Option[List[String]] = None,
      numCacheNodes: Option[Int] = None,
      cacheNodeType: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      cacheParameterGroupName: Option[String] = None,
      cacheSubnetGroupName: Option[String] = None,
      cacheSecurityGroupNames: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None,
      snapshotArns: Option[List[String]] = None,
      snapshotName: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      port: Option[Int] = None,
      notificationTopicArn: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      snapshotRetentionLimit: Option[Int] = None,
      snapshotWindow: Option[String] = None,
      authToken: Option[String] = None,
      outpostMode: Option[String] = None,
      preferredOutpostArn: Option[String] = None,
      preferredOutpostArns: Option[List[String]] = None,
      logDeliveryConfigurations: Option[List[LogDeliveryConfigurationRequest]] = None
    ): CreateCacheClusterMessage =
      CreateCacheClusterMessage
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(aZMode)(_.aZMode(_))
        .ifSome(preferredAvailabilityZone)(_.preferredAvailabilityZone(_))
        .ifSome(preferredAvailabilityZones)(_.preferredAvailabilityZones(_))
        .ifSome(numCacheNodes)(_.numCacheNodes(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(cacheSecurityGroupNames)(_.cacheSecurityGroupNames(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(snapshotArns)(_.snapshotArns(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(port)(_.port(_))
        .ifSome(notificationTopicArn)(_.notificationTopicArn(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(snapshotRetentionLimit)(_.snapshotRetentionLimit(_))
        .ifSome(snapshotWindow)(_.snapshotWindow(_))
        .ifSome(authToken)(_.authToken(_))
        .ifSome(outpostMode)(_.outpostMode(_))
        .ifSome(preferredOutpostArn)(_.preferredOutpostArn(_))
        .ifSome(preferredOutpostArns)(_.preferredOutpostArns(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def createCacheParameterGroupMessage(
      cacheParameterGroupName: Option[String] = None,
      cacheParameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateCacheParameterGroupMessage =
      CreateCacheParameterGroupMessage
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(cacheParameterGroupFamily)(_.cacheParameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCacheSecurityGroupMessage(
      cacheSecurityGroupName: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateCacheSecurityGroupMessage =
      CreateCacheSecurityGroupMessage
        .builder
        .ifSome(cacheSecurityGroupName)(_.cacheSecurityGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCacheSubnetGroupMessage(
      cacheSubnetGroupName: Option[String] = None,
      cacheSubnetGroupDescription: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None
    ): CreateCacheSubnetGroupMessage =
      CreateCacheSubnetGroupMessage
        .builder
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(cacheSubnetGroupDescription)(_.cacheSubnetGroupDescription(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGlobalReplicationGroupMessage(
      globalReplicationGroupIdSuffix: Option[String] = None,
      globalReplicationGroupDescription: Option[String] = None,
      primaryReplicationGroupId: Option[String] = None
    ): CreateGlobalReplicationGroupMessage =
      CreateGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupIdSuffix)(_.globalReplicationGroupIdSuffix(_))
        .ifSome(globalReplicationGroupDescription)(_.globalReplicationGroupDescription(_))
        .ifSome(primaryReplicationGroupId)(_.primaryReplicationGroupId(_))
        .build

    def createReplicationGroupMessage(
      replicationGroupId: Option[String] = None,
      replicationGroupDescription: Option[String] = None,
      globalReplicationGroupId: Option[String] = None,
      primaryClusterId: Option[String] = None,
      automaticFailoverEnabled: Option[Boolean] = None,
      multiAZEnabled: Option[Boolean] = None,
      numCacheClusters: Option[Int] = None,
      preferredCacheClusterAZs: Option[List[String]] = None,
      numNodeGroups: Option[Int] = None,
      replicasPerNodeGroup: Option[Int] = None,
      nodeGroupConfiguration: Option[List[NodeGroupConfiguration]] = None,
      cacheNodeType: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      cacheParameterGroupName: Option[String] = None,
      cacheSubnetGroupName: Option[String] = None,
      cacheSecurityGroupNames: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None,
      snapshotArns: Option[List[String]] = None,
      snapshotName: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      port: Option[Int] = None,
      notificationTopicArn: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      snapshotRetentionLimit: Option[Int] = None,
      snapshotWindow: Option[String] = None,
      authToken: Option[String] = None,
      transitEncryptionEnabled: Option[Boolean] = None,
      atRestEncryptionEnabled: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      userGroupIds: Option[List[UserGroupId]] = None,
      logDeliveryConfigurations: Option[List[LogDeliveryConfigurationRequest]] = None
    ): CreateReplicationGroupMessage =
      CreateReplicationGroupMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(replicationGroupDescription)(_.replicationGroupDescription(_))
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(primaryClusterId)(_.primaryClusterId(_))
        .ifSome(automaticFailoverEnabled)(_.automaticFailoverEnabled(_))
        .ifSome(multiAZEnabled)(_.multiAZEnabled(_))
        .ifSome(numCacheClusters)(_.numCacheClusters(_))
        .ifSome(preferredCacheClusterAZs)(_.preferredCacheClusterAZs(_))
        .ifSome(numNodeGroups)(_.numNodeGroups(_))
        .ifSome(replicasPerNodeGroup)(_.replicasPerNodeGroup(_))
        .ifSome(nodeGroupConfiguration)(_.nodeGroupConfiguration(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(cacheSecurityGroupNames)(_.cacheSecurityGroupNames(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(snapshotArns)(_.snapshotArns(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(port)(_.port(_))
        .ifSome(notificationTopicArn)(_.notificationTopicArn(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(snapshotRetentionLimit)(_.snapshotRetentionLimit(_))
        .ifSome(snapshotWindow)(_.snapshotWindow(_))
        .ifSome(authToken)(_.authToken(_))
        .ifSome(transitEncryptionEnabled)(_.transitEncryptionEnabled(_))
        .ifSome(atRestEncryptionEnabled)(_.atRestEncryptionEnabled(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(userGroupIds)(_.userGroupIds(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def createSnapshotMessage(
      replicationGroupId: Option[String] = None,
      cacheClusterId: Option[String] = None,
      snapshotName: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateSnapshotMessage =
      CreateSnapshotMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUserGroupMessage(
      userGroupId: Option[String] = None,
      engine: Option[String] = None,
      userIds: Option[List[UserId]] = None,
      tags: Option[List[Tag]] = None
    ): CreateUserGroupMessage =
      CreateUserGroupMessage
        .builder
        .ifSome(userGroupId)(_.userGroupId(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUserMessage(
      userId: Option[String] = None,
      userName: Option[String] = None,
      engine: Option[String] = None,
      passwords: Option[List[String]] = None,
      accessString: Option[String] = None,
      noPasswordRequired: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateUserMessage =
      CreateUserMessage
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(passwords)(_.passwords(_))
        .ifSome(accessString)(_.accessString(_))
        .ifSome(noPasswordRequired)(_.noPasswordRequired(_))
        .ifSome(tags)(_.tags(_))
        .build

    def customerNodeEndpoint(
      address: Option[String] = None,
      port: Option[Int] = None
    ): CustomerNodeEndpoint =
      CustomerNodeEndpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(port)(_.port(_))
        .build

    def decreaseNodeGroupsInGlobalReplicationGroupMessage(
      globalReplicationGroupId: Option[String] = None,
      nodeGroupCount: Option[Int] = None,
      globalNodeGroupsToRemove: Option[List[String]] = None,
      globalNodeGroupsToRetain: Option[List[String]] = None,
      applyImmediately: Option[Boolean] = None
    ): DecreaseNodeGroupsInGlobalReplicationGroupMessage =
      DecreaseNodeGroupsInGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(nodeGroupCount)(_.nodeGroupCount(_))
        .ifSome(globalNodeGroupsToRemove)(_.globalNodeGroupsToRemove(_))
        .ifSome(globalNodeGroupsToRetain)(_.globalNodeGroupsToRetain(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def decreaseReplicaCountMessage(
      replicationGroupId: Option[String] = None,
      newReplicaCount: Option[Int] = None,
      replicaConfiguration: Option[List[ConfigureShard]] = None,
      replicasToRemove: Option[List[String]] = None,
      applyImmediately: Option[Boolean] = None
    ): DecreaseReplicaCountMessage =
      DecreaseReplicaCountMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(newReplicaCount)(_.newReplicaCount(_))
        .ifSome(replicaConfiguration)(_.replicaConfiguration(_))
        .ifSome(replicasToRemove)(_.replicasToRemove(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def defaultUserAssociatedToUserGroupFault(

    ): DefaultUserAssociatedToUserGroupFault =
      DefaultUserAssociatedToUserGroupFault
        .builder

        .build

    def defaultUserRequired(

    ): DefaultUserRequired =
      DefaultUserRequired
        .builder

        .build

    def deleteCacheClusterMessage(
      cacheClusterId: Option[String] = None,
      finalSnapshotIdentifier: Option[String] = None
    ): DeleteCacheClusterMessage =
      DeleteCacheClusterMessage
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(finalSnapshotIdentifier)(_.finalSnapshotIdentifier(_))
        .build

    def deleteCacheParameterGroupMessage(
      cacheParameterGroupName: Option[String] = None
    ): DeleteCacheParameterGroupMessage =
      DeleteCacheParameterGroupMessage
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .build

    def deleteCacheSecurityGroupMessage(
      cacheSecurityGroupName: Option[String] = None
    ): DeleteCacheSecurityGroupMessage =
      DeleteCacheSecurityGroupMessage
        .builder
        .ifSome(cacheSecurityGroupName)(_.cacheSecurityGroupName(_))
        .build

    def deleteCacheSubnetGroupMessage(
      cacheSubnetGroupName: Option[String] = None
    ): DeleteCacheSubnetGroupMessage =
      DeleteCacheSubnetGroupMessage
        .builder
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .build

    def deleteGlobalReplicationGroupMessage(
      globalReplicationGroupId: Option[String] = None,
      retainPrimaryReplicationGroup: Option[Boolean] = None
    ): DeleteGlobalReplicationGroupMessage =
      DeleteGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(retainPrimaryReplicationGroup)(_.retainPrimaryReplicationGroup(_))
        .build

    def deleteReplicationGroupMessage(
      replicationGroupId: Option[String] = None,
      retainPrimaryCluster: Option[Boolean] = None,
      finalSnapshotIdentifier: Option[String] = None
    ): DeleteReplicationGroupMessage =
      DeleteReplicationGroupMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(retainPrimaryCluster)(_.retainPrimaryCluster(_))
        .ifSome(finalSnapshotIdentifier)(_.finalSnapshotIdentifier(_))
        .build

    def deleteSnapshotMessage(
      snapshotName: Option[String] = None
    ): DeleteSnapshotMessage =
      DeleteSnapshotMessage
        .builder
        .ifSome(snapshotName)(_.snapshotName(_))
        .build

    def deleteUserGroupMessage(
      userGroupId: Option[String] = None
    ): DeleteUserGroupMessage =
      DeleteUserGroupMessage
        .builder
        .ifSome(userGroupId)(_.userGroupId(_))
        .build

    def deleteUserMessage(
      userId: Option[String] = None
    ): DeleteUserMessage =
      DeleteUserMessage
        .builder
        .ifSome(userId)(_.userId(_))
        .build

    def describeCacheClustersMessage(
      cacheClusterId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      showCacheNodeInfo: Option[Boolean] = None,
      showCacheClustersNotInReplicationGroups: Option[Boolean] = None
    ): DescribeCacheClustersMessage =
      DescribeCacheClustersMessage
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(showCacheNodeInfo)(_.showCacheNodeInfo(_))
        .ifSome(showCacheClustersNotInReplicationGroups)(_.showCacheClustersNotInReplicationGroups(_))
        .build

    def describeCacheEngineVersionsMessage(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      cacheParameterGroupFamily: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      defaultOnly: Option[Boolean] = None
    ): DescribeCacheEngineVersionsMessage =
      DescribeCacheEngineVersionsMessage
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(cacheParameterGroupFamily)(_.cacheParameterGroupFamily(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(defaultOnly)(_.defaultOnly(_))
        .build

    def describeCacheParameterGroupsMessage(
      cacheParameterGroupName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCacheParameterGroupsMessage =
      DescribeCacheParameterGroupsMessage
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCacheParametersMessage(
      cacheParameterGroupName: Option[String] = None,
      source: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCacheParametersMessage =
      DescribeCacheParametersMessage
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(source)(_.source(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCacheSecurityGroupsMessage(
      cacheSecurityGroupName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCacheSecurityGroupsMessage =
      DescribeCacheSecurityGroupsMessage
        .builder
        .ifSome(cacheSecurityGroupName)(_.cacheSecurityGroupName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCacheSubnetGroupsMessage(
      cacheSubnetGroupName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCacheSubnetGroupsMessage =
      DescribeCacheSubnetGroupsMessage
        .builder
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEngineDefaultParametersMessage(
      cacheParameterGroupFamily: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEngineDefaultParametersMessage =
      DescribeEngineDefaultParametersMessage
        .builder
        .ifSome(cacheParameterGroupFamily)(_.cacheParameterGroupFamily(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
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

    def describeGlobalReplicationGroupsMessage(
      globalReplicationGroupId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      showMemberInfo: Option[Boolean] = None
    ): DescribeGlobalReplicationGroupsMessage =
      DescribeGlobalReplicationGroupsMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(showMemberInfo)(_.showMemberInfo(_))
        .build

    def describeReplicationGroupsMessage(
      replicationGroupId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReplicationGroupsMessage =
      DescribeReplicationGroupsMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReservedCacheNodesMessage(
      reservedCacheNodeId: Option[String] = None,
      reservedCacheNodesOfferingId: Option[String] = None,
      cacheNodeType: Option[String] = None,
      duration: Option[String] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReservedCacheNodesMessage =
      DescribeReservedCacheNodesMessage
        .builder
        .ifSome(reservedCacheNodeId)(_.reservedCacheNodeId(_))
        .ifSome(reservedCacheNodesOfferingId)(_.reservedCacheNodesOfferingId(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReservedCacheNodesOfferingsMessage(
      reservedCacheNodesOfferingId: Option[String] = None,
      cacheNodeType: Option[String] = None,
      duration: Option[String] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReservedCacheNodesOfferingsMessage =
      DescribeReservedCacheNodesOfferingsMessage
        .builder
        .ifSome(reservedCacheNodesOfferingId)(_.reservedCacheNodesOfferingId(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeServiceUpdatesMessage(
      serviceUpdateName: Option[String] = None,
      serviceUpdateStatus: Option[List[ServiceUpdateStatus]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeServiceUpdatesMessage =
      DescribeServiceUpdatesMessage
        .builder
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .ifSome(serviceUpdateStatus)(_.serviceUpdateStatus(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeSnapshotsListMessage(
      marker: Option[String] = None,
      snapshots: Option[List[Snapshot]] = None
    ): DescribeSnapshotsListMessage =
      DescribeSnapshotsListMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(snapshots)(_.snapshots(_))
        .build

    def describeSnapshotsMessage(
      replicationGroupId: Option[String] = None,
      cacheClusterId: Option[String] = None,
      snapshotName: Option[String] = None,
      snapshotSource: Option[String] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None,
      showNodeGroupConfig: Option[Boolean] = None
    ): DescribeSnapshotsMessage =
      DescribeSnapshotsMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .ifSome(snapshotSource)(_.snapshotSource(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(showNodeGroupConfig)(_.showNodeGroupConfig(_))
        .build

    def describeUpdateActionsMessage(
      serviceUpdateName: Option[String] = None,
      replicationGroupIds: Option[List[String]] = None,
      cacheClusterIds: Option[List[String]] = None,
      engine: Option[String] = None,
      serviceUpdateStatus: Option[List[ServiceUpdateStatus]] = None,
      serviceUpdateTimeRange: Option[TimeRangeFilter] = None,
      updateActionStatus: Option[List[UpdateActionStatus]] = None,
      showNodeLevelUpdateStatus: Option[Boolean] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeUpdateActionsMessage =
      DescribeUpdateActionsMessage
        .builder
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .ifSome(replicationGroupIds)(_.replicationGroupIds(_))
        .ifSome(cacheClusterIds)(_.cacheClusterIds(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(serviceUpdateStatus)(_.serviceUpdateStatus(_))
        .ifSome(serviceUpdateTimeRange)(_.serviceUpdateTimeRange(_))
        .ifSome(updateActionStatus)(_.updateActionStatus(_))
        .ifSome(showNodeLevelUpdateStatus)(_.showNodeLevelUpdateStatus(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeUserGroupsMessage(
      userGroupId: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeUserGroupsMessage =
      DescribeUserGroupsMessage
        .builder
        .ifSome(userGroupId)(_.userGroupId(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeUsersMessage(
      engine: Option[String] = None,
      userId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeUsersMessage =
      DescribeUsersMessage
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def destinationDetails(
      cloudWatchLogsDetails: Option[CloudWatchLogsDestinationDetails] = None,
      kinesisFirehoseDetails: Option[KinesisFirehoseDestinationDetails] = None
    ): DestinationDetails =
      DestinationDetails
        .builder
        .ifSome(cloudWatchLogsDetails)(_.cloudWatchLogsDetails(_))
        .ifSome(kinesisFirehoseDetails)(_.kinesisFirehoseDetails(_))
        .build

    def disassociateGlobalReplicationGroupMessage(
      globalReplicationGroupId: Option[String] = None,
      replicationGroupId: Option[String] = None,
      replicationGroupRegion: Option[String] = None
    ): DisassociateGlobalReplicationGroupMessage =
      DisassociateGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(replicationGroupRegion)(_.replicationGroupRegion(_))
        .build

    def duplicateUserNameFault(

    ): DuplicateUserNameFault =
      DuplicateUserNameFault
        .builder

        .build

    def eC2SecurityGroup(
      status: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): EC2SecurityGroup =
      EC2SecurityGroup
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
        .build

    def endpoint(
      address: Option[String] = None,
      port: Option[Int] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(port)(_.port(_))
        .build

    def engineDefaults(
      cacheParameterGroupFamily: Option[String] = None,
      marker: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      cacheNodeTypeSpecificParameters: Option[List[CacheNodeTypeSpecificParameter]] = None
    ): EngineDefaults =
      EngineDefaults
        .builder
        .ifSome(cacheParameterGroupFamily)(_.cacheParameterGroupFamily(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(cacheNodeTypeSpecificParameters)(_.cacheNodeTypeSpecificParameters(_))
        .build

    def event(
      sourceIdentifier: Option[String] = None,
      sourceType: Option[String] = None,
      message: Option[String] = None,
      date: Option[TStamp] = None
    ): Event =
      Event
        .builder
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(message)(_.message(_))
        .ifSome(date)(_.date(_))
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

    def failoverGlobalReplicationGroupMessage(
      globalReplicationGroupId: Option[String] = None,
      primaryRegion: Option[String] = None,
      primaryReplicationGroupId: Option[String] = None
    ): FailoverGlobalReplicationGroupMessage =
      FailoverGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(primaryRegion)(_.primaryRegion(_))
        .ifSome(primaryReplicationGroupId)(_.primaryReplicationGroupId(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def globalNodeGroup(
      globalNodeGroupId: Option[String] = None,
      slots: Option[String] = None
    ): GlobalNodeGroup =
      GlobalNodeGroup
        .builder
        .ifSome(globalNodeGroupId)(_.globalNodeGroupId(_))
        .ifSome(slots)(_.slots(_))
        .build

    def globalReplicationGroup(
      globalReplicationGroupId: Option[String] = None,
      globalReplicationGroupDescription: Option[String] = None,
      status: Option[String] = None,
      cacheNodeType: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      members: Option[List[GlobalReplicationGroupMember]] = None,
      clusterEnabled: Option[Boolean] = None,
      globalNodeGroups: Option[List[GlobalNodeGroup]] = None,
      authTokenEnabled: Option[Boolean] = None,
      transitEncryptionEnabled: Option[Boolean] = None,
      atRestEncryptionEnabled: Option[Boolean] = None,
      aRN: Option[String] = None
    ): GlobalReplicationGroup =
      GlobalReplicationGroup
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(globalReplicationGroupDescription)(_.globalReplicationGroupDescription(_))
        .ifSome(status)(_.status(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(members)(_.members(_))
        .ifSome(clusterEnabled)(_.clusterEnabled(_))
        .ifSome(globalNodeGroups)(_.globalNodeGroups(_))
        .ifSome(authTokenEnabled)(_.authTokenEnabled(_))
        .ifSome(transitEncryptionEnabled)(_.transitEncryptionEnabled(_))
        .ifSome(atRestEncryptionEnabled)(_.atRestEncryptionEnabled(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def globalReplicationGroupAlreadyExistsFault(

    ): GlobalReplicationGroupAlreadyExistsFault =
      GlobalReplicationGroupAlreadyExistsFault
        .builder

        .build

    def globalReplicationGroupInfo(
      globalReplicationGroupId: Option[String] = None,
      globalReplicationGroupMemberRole: Option[String] = None
    ): GlobalReplicationGroupInfo =
      GlobalReplicationGroupInfo
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(globalReplicationGroupMemberRole)(_.globalReplicationGroupMemberRole(_))
        .build

    def globalReplicationGroupMember(
      replicationGroupId: Option[String] = None,
      replicationGroupRegion: Option[String] = None,
      role: Option[String] = None,
      automaticFailover: Option[String] = None,
      status: Option[String] = None
    ): GlobalReplicationGroupMember =
      GlobalReplicationGroupMember
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(replicationGroupRegion)(_.replicationGroupRegion(_))
        .ifSome(role)(_.role(_))
        .ifSome(automaticFailover)(_.automaticFailover(_))
        .ifSome(status)(_.status(_))
        .build

    def globalReplicationGroupNotFoundFault(

    ): GlobalReplicationGroupNotFoundFault =
      GlobalReplicationGroupNotFoundFault
        .builder

        .build

    def increaseNodeGroupsInGlobalReplicationGroupMessage(
      globalReplicationGroupId: Option[String] = None,
      nodeGroupCount: Option[Int] = None,
      regionalConfigurations: Option[List[RegionalConfiguration]] = None,
      applyImmediately: Option[Boolean] = None
    ): IncreaseNodeGroupsInGlobalReplicationGroupMessage =
      IncreaseNodeGroupsInGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(nodeGroupCount)(_.nodeGroupCount(_))
        .ifSome(regionalConfigurations)(_.regionalConfigurations(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def increaseReplicaCountMessage(
      replicationGroupId: Option[String] = None,
      newReplicaCount: Option[Int] = None,
      replicaConfiguration: Option[List[ConfigureShard]] = None,
      applyImmediately: Option[Boolean] = None
    ): IncreaseReplicaCountMessage =
      IncreaseReplicaCountMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(newReplicaCount)(_.newReplicaCount(_))
        .ifSome(replicaConfiguration)(_.replicaConfiguration(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def insufficientCacheClusterCapacityFault(

    ): InsufficientCacheClusterCapacityFault =
      InsufficientCacheClusterCapacityFault
        .builder

        .build

    def invalidARNFault(

    ): InvalidARNFault =
      InvalidARNFault
        .builder

        .build

    def invalidCacheClusterStateFault(

    ): InvalidCacheClusterStateFault =
      InvalidCacheClusterStateFault
        .builder

        .build

    def invalidCacheParameterGroupStateFault(

    ): InvalidCacheParameterGroupStateFault =
      InvalidCacheParameterGroupStateFault
        .builder

        .build

    def invalidCacheSecurityGroupStateFault(

    ): InvalidCacheSecurityGroupStateFault =
      InvalidCacheSecurityGroupStateFault
        .builder

        .build

    def invalidGlobalReplicationGroupStateFault(

    ): InvalidGlobalReplicationGroupStateFault =
      InvalidGlobalReplicationGroupStateFault
        .builder

        .build

    def invalidKMSKeyFault(

    ): InvalidKMSKeyFault =
      InvalidKMSKeyFault
        .builder

        .build

    def invalidParameterCombinationException(
      message: Option[String] = None
    ): InvalidParameterCombinationException =
      InvalidParameterCombinationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterValueException(
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidReplicationGroupStateFault(

    ): InvalidReplicationGroupStateFault =
      InvalidReplicationGroupStateFault
        .builder

        .build

    def invalidSnapshotStateFault(

    ): InvalidSnapshotStateFault =
      InvalidSnapshotStateFault
        .builder

        .build

    def invalidSubnet(

    ): InvalidSubnet =
      InvalidSubnet
        .builder

        .build

    def invalidUserGroupStateFault(

    ): InvalidUserGroupStateFault =
      InvalidUserGroupStateFault
        .builder

        .build

    def invalidUserStateFault(

    ): InvalidUserStateFault =
      InvalidUserStateFault
        .builder

        .build

    def invalidVPCNetworkStateFault(

    ): InvalidVPCNetworkStateFault =
      InvalidVPCNetworkStateFault
        .builder

        .build

    def kinesisFirehoseDestinationDetails(
      deliveryStream: Option[String] = None
    ): KinesisFirehoseDestinationDetails =
      KinesisFirehoseDestinationDetails
        .builder
        .ifSome(deliveryStream)(_.deliveryStream(_))
        .build

    def listAllowedNodeTypeModificationsMessage(
      cacheClusterId: Option[String] = None,
      replicationGroupId: Option[String] = None
    ): ListAllowedNodeTypeModificationsMessage =
      ListAllowedNodeTypeModificationsMessage
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .build

    def listTagsForResourceMessage(
      resourceName: Option[String] = None
    ): ListTagsForResourceMessage =
      ListTagsForResourceMessage
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def logDeliveryConfiguration(
      logType: Option[String] = None,
      destinationType: Option[String] = None,
      destinationDetails: Option[DestinationDetails] = None,
      logFormat: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None
    ): LogDeliveryConfiguration =
      LogDeliveryConfiguration
        .builder
        .ifSome(logType)(_.logType(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(destinationDetails)(_.destinationDetails(_))
        .ifSome(logFormat)(_.logFormat(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .build

    def logDeliveryConfigurationRequest(
      logType: Option[String] = None,
      destinationType: Option[String] = None,
      destinationDetails: Option[DestinationDetails] = None,
      logFormat: Option[String] = None,
      enabled: Option[Boolean] = None
    ): LogDeliveryConfigurationRequest =
      LogDeliveryConfigurationRequest
        .builder
        .ifSome(logType)(_.logType(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(destinationDetails)(_.destinationDetails(_))
        .ifSome(logFormat)(_.logFormat(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def modifyCacheClusterMessage(
      cacheClusterId: Option[String] = None,
      numCacheNodes: Option[Int] = None,
      cacheNodeIdsToRemove: Option[List[String]] = None,
      aZMode: Option[String] = None,
      newAvailabilityZones: Option[List[String]] = None,
      cacheSecurityGroupNames: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None,
      preferredMaintenanceWindow: Option[String] = None,
      notificationTopicArn: Option[String] = None,
      cacheParameterGroupName: Option[String] = None,
      notificationTopicStatus: Option[String] = None,
      applyImmediately: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      snapshotRetentionLimit: Option[Int] = None,
      snapshotWindow: Option[String] = None,
      cacheNodeType: Option[String] = None,
      authToken: Option[String] = None,
      authTokenUpdateStrategy: Option[String] = None,
      logDeliveryConfigurations: Option[List[LogDeliveryConfigurationRequest]] = None
    ): ModifyCacheClusterMessage =
      ModifyCacheClusterMessage
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(numCacheNodes)(_.numCacheNodes(_))
        .ifSome(cacheNodeIdsToRemove)(_.cacheNodeIdsToRemove(_))
        .ifSome(aZMode)(_.aZMode(_))
        .ifSome(newAvailabilityZones)(_.newAvailabilityZones(_))
        .ifSome(cacheSecurityGroupNames)(_.cacheSecurityGroupNames(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(notificationTopicArn)(_.notificationTopicArn(_))
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(notificationTopicStatus)(_.notificationTopicStatus(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(snapshotRetentionLimit)(_.snapshotRetentionLimit(_))
        .ifSome(snapshotWindow)(_.snapshotWindow(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(authToken)(_.authToken(_))
        .ifSome(authTokenUpdateStrategy)(_.authTokenUpdateStrategy(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def modifyCacheParameterGroupMessage(
      cacheParameterGroupName: Option[String] = None,
      parameterNameValues: Option[List[ParameterNameValue]] = None
    ): ModifyCacheParameterGroupMessage =
      ModifyCacheParameterGroupMessage
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(parameterNameValues)(_.parameterNameValues(_))
        .build

    def modifyCacheSubnetGroupMessage(
      cacheSubnetGroupName: Option[String] = None,
      cacheSubnetGroupDescription: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): ModifyCacheSubnetGroupMessage =
      ModifyCacheSubnetGroupMessage
        .builder
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(cacheSubnetGroupDescription)(_.cacheSubnetGroupDescription(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def modifyGlobalReplicationGroupMessage(
      globalReplicationGroupId: Option[String] = None,
      applyImmediately: Option[Boolean] = None,
      cacheNodeType: Option[String] = None,
      engineVersion: Option[String] = None,
      cacheParameterGroupName: Option[String] = None,
      globalReplicationGroupDescription: Option[String] = None,
      automaticFailoverEnabled: Option[Boolean] = None
    ): ModifyGlobalReplicationGroupMessage =
      ModifyGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(globalReplicationGroupDescription)(_.globalReplicationGroupDescription(_))
        .ifSome(automaticFailoverEnabled)(_.automaticFailoverEnabled(_))
        .build

    def modifyReplicationGroupMessage(
      replicationGroupId: Option[String] = None,
      replicationGroupDescription: Option[String] = None,
      primaryClusterId: Option[String] = None,
      snapshottingClusterId: Option[String] = None,
      automaticFailoverEnabled: Option[Boolean] = None,
      multiAZEnabled: Option[Boolean] = None,
      nodeGroupId: Option[String] = None,
      cacheSecurityGroupNames: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None,
      preferredMaintenanceWindow: Option[String] = None,
      notificationTopicArn: Option[String] = None,
      cacheParameterGroupName: Option[String] = None,
      notificationTopicStatus: Option[String] = None,
      applyImmediately: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      snapshotRetentionLimit: Option[Int] = None,
      snapshotWindow: Option[String] = None,
      cacheNodeType: Option[String] = None,
      authToken: Option[String] = None,
      authTokenUpdateStrategy: Option[String] = None,
      userGroupIdsToAdd: Option[List[UserGroupId]] = None,
      userGroupIdsToRemove: Option[List[UserGroupId]] = None,
      removeUserGroups: Option[Boolean] = None,
      logDeliveryConfigurations: Option[List[LogDeliveryConfigurationRequest]] = None
    ): ModifyReplicationGroupMessage =
      ModifyReplicationGroupMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(replicationGroupDescription)(_.replicationGroupDescription(_))
        .ifSome(primaryClusterId)(_.primaryClusterId(_))
        .ifSome(snapshottingClusterId)(_.snapshottingClusterId(_))
        .ifSome(automaticFailoverEnabled)(_.automaticFailoverEnabled(_))
        .ifSome(multiAZEnabled)(_.multiAZEnabled(_))
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .ifSome(cacheSecurityGroupNames)(_.cacheSecurityGroupNames(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(notificationTopicArn)(_.notificationTopicArn(_))
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(notificationTopicStatus)(_.notificationTopicStatus(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(snapshotRetentionLimit)(_.snapshotRetentionLimit(_))
        .ifSome(snapshotWindow)(_.snapshotWindow(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(authToken)(_.authToken(_))
        .ifSome(authTokenUpdateStrategy)(_.authTokenUpdateStrategy(_))
        .ifSome(userGroupIdsToAdd)(_.userGroupIdsToAdd(_))
        .ifSome(userGroupIdsToRemove)(_.userGroupIdsToRemove(_))
        .ifSome(removeUserGroups)(_.removeUserGroups(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def modifyReplicationGroupShardConfigurationMessage(
      replicationGroupId: Option[String] = None,
      nodeGroupCount: Option[Int] = None,
      applyImmediately: Option[Boolean] = None,
      reshardingConfiguration: Option[List[ReshardingConfiguration]] = None,
      nodeGroupsToRemove: Option[List[AllowedNodeGroupId]] = None,
      nodeGroupsToRetain: Option[List[AllowedNodeGroupId]] = None
    ): ModifyReplicationGroupShardConfigurationMessage =
      ModifyReplicationGroupShardConfigurationMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(nodeGroupCount)(_.nodeGroupCount(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(reshardingConfiguration)(_.reshardingConfiguration(_))
        .ifSome(nodeGroupsToRemove)(_.nodeGroupsToRemove(_))
        .ifSome(nodeGroupsToRetain)(_.nodeGroupsToRetain(_))
        .build

    def modifyUserGroupMessage(
      userGroupId: Option[String] = None,
      userIdsToAdd: Option[List[UserId]] = None,
      userIdsToRemove: Option[List[UserId]] = None
    ): ModifyUserGroupMessage =
      ModifyUserGroupMessage
        .builder
        .ifSome(userGroupId)(_.userGroupId(_))
        .ifSome(userIdsToAdd)(_.userIdsToAdd(_))
        .ifSome(userIdsToRemove)(_.userIdsToRemove(_))
        .build

    def modifyUserMessage(
      userId: Option[String] = None,
      accessString: Option[String] = None,
      appendAccessString: Option[String] = None,
      passwords: Option[List[String]] = None,
      noPasswordRequired: Option[Boolean] = None
    ): ModifyUserMessage =
      ModifyUserMessage
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(accessString)(_.accessString(_))
        .ifSome(appendAccessString)(_.appendAccessString(_))
        .ifSome(passwords)(_.passwords(_))
        .ifSome(noPasswordRequired)(_.noPasswordRequired(_))
        .build

    def noOperationFault(

    ): NoOperationFault =
      NoOperationFault
        .builder

        .build

    def nodeGroup(
      nodeGroupId: Option[String] = None,
      status: Option[String] = None,
      primaryEndpoint: Option[Endpoint] = None,
      readerEndpoint: Option[Endpoint] = None,
      slots: Option[String] = None,
      nodeGroupMembers: Option[List[NodeGroupMember]] = None
    ): NodeGroup =
      NodeGroup
        .builder
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .ifSome(status)(_.status(_))
        .ifSome(primaryEndpoint)(_.primaryEndpoint(_))
        .ifSome(readerEndpoint)(_.readerEndpoint(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(nodeGroupMembers)(_.nodeGroupMembers(_))
        .build

    def nodeGroupConfiguration(
      nodeGroupId: Option[String] = None,
      slots: Option[String] = None,
      replicaCount: Option[Int] = None,
      primaryAvailabilityZone: Option[String] = None,
      replicaAvailabilityZones: Option[List[String]] = None,
      primaryOutpostArn: Option[String] = None,
      replicaOutpostArns: Option[List[String]] = None
    ): NodeGroupConfiguration =
      NodeGroupConfiguration
        .builder
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .ifSome(slots)(_.slots(_))
        .ifSome(replicaCount)(_.replicaCount(_))
        .ifSome(primaryAvailabilityZone)(_.primaryAvailabilityZone(_))
        .ifSome(replicaAvailabilityZones)(_.replicaAvailabilityZones(_))
        .ifSome(primaryOutpostArn)(_.primaryOutpostArn(_))
        .ifSome(replicaOutpostArns)(_.replicaOutpostArns(_))
        .build

    def nodeGroupMember(
      cacheClusterId: Option[String] = None,
      cacheNodeId: Option[String] = None,
      readEndpoint: Option[Endpoint] = None,
      preferredAvailabilityZone: Option[String] = None,
      preferredOutpostArn: Option[String] = None,
      currentRole: Option[String] = None
    ): NodeGroupMember =
      NodeGroupMember
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(cacheNodeId)(_.cacheNodeId(_))
        .ifSome(readEndpoint)(_.readEndpoint(_))
        .ifSome(preferredAvailabilityZone)(_.preferredAvailabilityZone(_))
        .ifSome(preferredOutpostArn)(_.preferredOutpostArn(_))
        .ifSome(currentRole)(_.currentRole(_))
        .build

    def nodeGroupMemberUpdateStatus(
      cacheClusterId: Option[String] = None,
      cacheNodeId: Option[String] = None,
      nodeUpdateStatus: Option[String] = None,
      nodeDeletionDate: Option[TStamp] = None,
      nodeUpdateStartDate: Option[TStamp] = None,
      nodeUpdateEndDate: Option[TStamp] = None,
      nodeUpdateInitiatedBy: Option[String] = None,
      nodeUpdateInitiatedDate: Option[TStamp] = None,
      nodeUpdateStatusModifiedDate: Option[TStamp] = None
    ): NodeGroupMemberUpdateStatus =
      NodeGroupMemberUpdateStatus
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(cacheNodeId)(_.cacheNodeId(_))
        .ifSome(nodeUpdateStatus)(_.nodeUpdateStatus(_))
        .ifSome(nodeDeletionDate)(_.nodeDeletionDate(_))
        .ifSome(nodeUpdateStartDate)(_.nodeUpdateStartDate(_))
        .ifSome(nodeUpdateEndDate)(_.nodeUpdateEndDate(_))
        .ifSome(nodeUpdateInitiatedBy)(_.nodeUpdateInitiatedBy(_))
        .ifSome(nodeUpdateInitiatedDate)(_.nodeUpdateInitiatedDate(_))
        .ifSome(nodeUpdateStatusModifiedDate)(_.nodeUpdateStatusModifiedDate(_))
        .build

    def nodeGroupNotFoundFault(

    ): NodeGroupNotFoundFault =
      NodeGroupNotFoundFault
        .builder

        .build

    def nodeGroupUpdateStatus(
      nodeGroupId: Option[String] = None,
      nodeGroupMemberUpdateStatus: Option[List[NodeGroupMemberUpdateStatus]] = None
    ): NodeGroupUpdateStatus =
      NodeGroupUpdateStatus
        .builder
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .ifSome(nodeGroupMemberUpdateStatus)(_.nodeGroupMemberUpdateStatus(_))
        .build

    def nodeGroupsPerReplicationGroupQuotaExceededFault(

    ): NodeGroupsPerReplicationGroupQuotaExceededFault =
      NodeGroupsPerReplicationGroupQuotaExceededFault
        .builder

        .build

    def nodeQuotaForClusterExceededFault(

    ): NodeQuotaForClusterExceededFault =
      NodeQuotaForClusterExceededFault
        .builder

        .build

    def nodeQuotaForCustomerExceededFault(

    ): NodeQuotaForCustomerExceededFault =
      NodeQuotaForCustomerExceededFault
        .builder

        .build

    def nodeSnapshot(
      cacheClusterId: Option[String] = None,
      nodeGroupId: Option[String] = None,
      cacheNodeId: Option[String] = None,
      nodeGroupConfiguration: Option[NodeGroupConfiguration] = None,
      cacheSize: Option[String] = None,
      cacheNodeCreateTime: Option[TStamp] = None,
      snapshotCreateTime: Option[TStamp] = None
    ): NodeSnapshot =
      NodeSnapshot
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .ifSome(cacheNodeId)(_.cacheNodeId(_))
        .ifSome(nodeGroupConfiguration)(_.nodeGroupConfiguration(_))
        .ifSome(cacheSize)(_.cacheSize(_))
        .ifSome(cacheNodeCreateTime)(_.cacheNodeCreateTime(_))
        .ifSome(snapshotCreateTime)(_.snapshotCreateTime(_))
        .build

    def notificationConfiguration(
      topicArn: Option[String] = None,
      topicStatus: Option[String] = None
    ): NotificationConfiguration =
      NotificationConfiguration
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(topicStatus)(_.topicStatus(_))
        .build

    def parameter(
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None,
      description: Option[String] = None,
      source: Option[String] = None,
      dataType: Option[String] = None,
      allowedValues: Option[String] = None,
      isModifiable: Option[Boolean] = None,
      minimumEngineVersion: Option[String] = None,
      changeType: Option[String] = None
    ): Parameter =
      Parameter
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(minimumEngineVersion)(_.minimumEngineVersion(_))
        .ifSome(changeType)(_.changeType(_))
        .build

    def parameterNameValue(
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None
    ): ParameterNameValue =
      ParameterNameValue
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .build

    def pendingLogDeliveryConfiguration(
      logType: Option[String] = None,
      destinationType: Option[String] = None,
      destinationDetails: Option[DestinationDetails] = None,
      logFormat: Option[String] = None
    ): PendingLogDeliveryConfiguration =
      PendingLogDeliveryConfiguration
        .builder
        .ifSome(logType)(_.logType(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(destinationDetails)(_.destinationDetails(_))
        .ifSome(logFormat)(_.logFormat(_))
        .build

    def pendingModifiedValues(
      numCacheNodes: Option[Int] = None,
      cacheNodeIdsToRemove: Option[List[String]] = None,
      engineVersion: Option[String] = None,
      cacheNodeType: Option[String] = None,
      authTokenStatus: Option[String] = None,
      logDeliveryConfigurations: Option[List[PendingLogDeliveryConfiguration]] = None
    ): PendingModifiedValues =
      PendingModifiedValues
        .builder
        .ifSome(numCacheNodes)(_.numCacheNodes(_))
        .ifSome(cacheNodeIdsToRemove)(_.cacheNodeIdsToRemove(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(authTokenStatus)(_.authTokenStatus(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def processedUpdateAction(
      replicationGroupId: Option[String] = None,
      cacheClusterId: Option[String] = None,
      serviceUpdateName: Option[String] = None,
      updateActionStatus: Option[String] = None
    ): ProcessedUpdateAction =
      ProcessedUpdateAction
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .ifSome(updateActionStatus)(_.updateActionStatus(_))
        .build

    def purchaseReservedCacheNodesOfferingMessage(
      reservedCacheNodesOfferingId: Option[String] = None,
      reservedCacheNodeId: Option[String] = None,
      cacheNodeCount: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): PurchaseReservedCacheNodesOfferingMessage =
      PurchaseReservedCacheNodesOfferingMessage
        .builder
        .ifSome(reservedCacheNodesOfferingId)(_.reservedCacheNodesOfferingId(_))
        .ifSome(reservedCacheNodeId)(_.reservedCacheNodeId(_))
        .ifSome(cacheNodeCount)(_.cacheNodeCount(_))
        .ifSome(tags)(_.tags(_))
        .build

    def rebalanceSlotsInGlobalReplicationGroupMessage(
      globalReplicationGroupId: Option[String] = None,
      applyImmediately: Option[Boolean] = None
    ): RebalanceSlotsInGlobalReplicationGroupMessage =
      RebalanceSlotsInGlobalReplicationGroupMessage
        .builder
        .ifSome(globalReplicationGroupId)(_.globalReplicationGroupId(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def rebootCacheClusterMessage(
      cacheClusterId: Option[String] = None,
      cacheNodeIdsToReboot: Option[List[String]] = None
    ): RebootCacheClusterMessage =
      RebootCacheClusterMessage
        .builder
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(cacheNodeIdsToReboot)(_.cacheNodeIdsToReboot(_))
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

    def regionalConfiguration(
      replicationGroupId: Option[String] = None,
      replicationGroupRegion: Option[String] = None,
      reshardingConfiguration: Option[List[ReshardingConfiguration]] = None
    ): RegionalConfiguration =
      RegionalConfiguration
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(replicationGroupRegion)(_.replicationGroupRegion(_))
        .ifSome(reshardingConfiguration)(_.reshardingConfiguration(_))
        .build

    def removeTagsFromResourceMessage(
      resourceName: Option[String] = None,
      tagKeys: Option[List[String]] = None
    ): RemoveTagsFromResourceMessage =
      RemoveTagsFromResourceMessage
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def replicationGroup(
      replicationGroupId: Option[String] = None,
      description: Option[String] = None,
      globalReplicationGroupInfo: Option[GlobalReplicationGroupInfo] = None,
      status: Option[String] = None,
      pendingModifiedValues: Option[ReplicationGroupPendingModifiedValues] = None,
      memberClusters: Option[List[String]] = None,
      nodeGroups: Option[List[NodeGroup]] = None,
      snapshottingClusterId: Option[String] = None,
      automaticFailover: Option[String] = None,
      multiAZ: Option[String] = None,
      configurationEndpoint: Option[Endpoint] = None,
      snapshotRetentionLimit: Option[Int] = None,
      snapshotWindow: Option[String] = None,
      clusterEnabled: Option[Boolean] = None,
      cacheNodeType: Option[String] = None,
      authTokenEnabled: Option[Boolean] = None,
      authTokenLastModifiedDate: Option[TStamp] = None,
      transitEncryptionEnabled: Option[Boolean] = None,
      atRestEncryptionEnabled: Option[Boolean] = None,
      memberClustersOutpostArns: Option[List[String]] = None,
      kmsKeyId: Option[String] = None,
      aRN: Option[String] = None,
      userGroupIds: Option[List[UserGroupId]] = None,
      logDeliveryConfigurations: Option[List[LogDeliveryConfiguration]] = None
    ): ReplicationGroup =
      ReplicationGroup
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(description)(_.description(_))
        .ifSome(globalReplicationGroupInfo)(_.globalReplicationGroupInfo(_))
        .ifSome(status)(_.status(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(memberClusters)(_.memberClusters(_))
        .ifSome(nodeGroups)(_.nodeGroups(_))
        .ifSome(snapshottingClusterId)(_.snapshottingClusterId(_))
        .ifSome(automaticFailover)(_.automaticFailover(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(configurationEndpoint)(_.configurationEndpoint(_))
        .ifSome(snapshotRetentionLimit)(_.snapshotRetentionLimit(_))
        .ifSome(snapshotWindow)(_.snapshotWindow(_))
        .ifSome(clusterEnabled)(_.clusterEnabled(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(authTokenEnabled)(_.authTokenEnabled(_))
        .ifSome(authTokenLastModifiedDate)(_.authTokenLastModifiedDate(_))
        .ifSome(transitEncryptionEnabled)(_.transitEncryptionEnabled(_))
        .ifSome(atRestEncryptionEnabled)(_.atRestEncryptionEnabled(_))
        .ifSome(memberClustersOutpostArns)(_.memberClustersOutpostArns(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(userGroupIds)(_.userGroupIds(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def replicationGroupAlreadyExistsFault(

    ): ReplicationGroupAlreadyExistsFault =
      ReplicationGroupAlreadyExistsFault
        .builder

        .build

    def replicationGroupAlreadyUnderMigrationFault(

    ): ReplicationGroupAlreadyUnderMigrationFault =
      ReplicationGroupAlreadyUnderMigrationFault
        .builder

        .build

    def replicationGroupMessage(
      marker: Option[String] = None,
      replicationGroups: Option[List[ReplicationGroup]] = None
    ): ReplicationGroupMessage =
      ReplicationGroupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(replicationGroups)(_.replicationGroups(_))
        .build

    def replicationGroupNotFoundFault(

    ): ReplicationGroupNotFoundFault =
      ReplicationGroupNotFoundFault
        .builder

        .build

    def replicationGroupNotUnderMigrationFault(

    ): ReplicationGroupNotUnderMigrationFault =
      ReplicationGroupNotUnderMigrationFault
        .builder

        .build

    def replicationGroupPendingModifiedValues(
      primaryClusterId: Option[String] = None,
      automaticFailoverStatus: Option[String] = None,
      resharding: Option[ReshardingStatus] = None,
      authTokenStatus: Option[String] = None,
      userGroups: Option[UserGroupsUpdateStatus] = None,
      logDeliveryConfigurations: Option[List[PendingLogDeliveryConfiguration]] = None
    ): ReplicationGroupPendingModifiedValues =
      ReplicationGroupPendingModifiedValues
        .builder
        .ifSome(primaryClusterId)(_.primaryClusterId(_))
        .ifSome(automaticFailoverStatus)(_.automaticFailoverStatus(_))
        .ifSome(resharding)(_.resharding(_))
        .ifSome(authTokenStatus)(_.authTokenStatus(_))
        .ifSome(userGroups)(_.userGroups(_))
        .ifSome(logDeliveryConfigurations)(_.logDeliveryConfigurations(_))
        .build

    def reservedCacheNode(
      reservedCacheNodeId: Option[String] = None,
      reservedCacheNodesOfferingId: Option[String] = None,
      cacheNodeType: Option[String] = None,
      startTime: Option[TStamp] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      cacheNodeCount: Option[Int] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      state: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None,
      reservationARN: Option[String] = None
    ): ReservedCacheNode =
      ReservedCacheNode
        .builder
        .ifSome(reservedCacheNodeId)(_.reservedCacheNodeId(_))
        .ifSome(reservedCacheNodesOfferingId)(_.reservedCacheNodesOfferingId(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(cacheNodeCount)(_.cacheNodeCount(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(state)(_.state(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .ifSome(reservationARN)(_.reservationARN(_))
        .build

    def reservedCacheNodeAlreadyExistsFault(

    ): ReservedCacheNodeAlreadyExistsFault =
      ReservedCacheNodeAlreadyExistsFault
        .builder

        .build

    def reservedCacheNodeMessage(
      marker: Option[String] = None,
      reservedCacheNodes: Option[List[ReservedCacheNode]] = None
    ): ReservedCacheNodeMessage =
      ReservedCacheNodeMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(reservedCacheNodes)(_.reservedCacheNodes(_))
        .build

    def reservedCacheNodeNotFoundFault(

    ): ReservedCacheNodeNotFoundFault =
      ReservedCacheNodeNotFoundFault
        .builder

        .build

    def reservedCacheNodeQuotaExceededFault(

    ): ReservedCacheNodeQuotaExceededFault =
      ReservedCacheNodeQuotaExceededFault
        .builder

        .build

    def reservedCacheNodesOffering(
      reservedCacheNodesOfferingId: Option[String] = None,
      cacheNodeType: Option[String] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None
    ): ReservedCacheNodesOffering =
      ReservedCacheNodesOffering
        .builder
        .ifSome(reservedCacheNodesOfferingId)(_.reservedCacheNodesOfferingId(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .build

    def reservedCacheNodesOfferingMessage(
      marker: Option[String] = None,
      reservedCacheNodesOfferings: Option[List[ReservedCacheNodesOffering]] = None
    ): ReservedCacheNodesOfferingMessage =
      ReservedCacheNodesOfferingMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(reservedCacheNodesOfferings)(_.reservedCacheNodesOfferings(_))
        .build

    def reservedCacheNodesOfferingNotFoundFault(

    ): ReservedCacheNodesOfferingNotFoundFault =
      ReservedCacheNodesOfferingNotFoundFault
        .builder

        .build

    def resetCacheParameterGroupMessage(
      cacheParameterGroupName: Option[String] = None,
      resetAllParameters: Option[Boolean] = None,
      parameterNameValues: Option[List[ParameterNameValue]] = None
    ): ResetCacheParameterGroupMessage =
      ResetCacheParameterGroupMessage
        .builder
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(resetAllParameters)(_.resetAllParameters(_))
        .ifSome(parameterNameValues)(_.parameterNameValues(_))
        .build

    def reshardingConfiguration(
      nodeGroupId: Option[String] = None,
      preferredAvailabilityZones: Option[List[String]] = None
    ): ReshardingConfiguration =
      ReshardingConfiguration
        .builder
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .ifSome(preferredAvailabilityZones)(_.preferredAvailabilityZones(_))
        .build

    def reshardingStatus(
      slotMigration: Option[SlotMigration] = None
    ): ReshardingStatus =
      ReshardingStatus
        .builder
        .ifSome(slotMigration)(_.slotMigration(_))
        .build

    def revokeCacheSecurityGroupIngressMessage(
      cacheSecurityGroupName: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): RevokeCacheSecurityGroupIngressMessage =
      RevokeCacheSecurityGroupIngressMessage
        .builder
        .ifSome(cacheSecurityGroupName)(_.cacheSecurityGroupName(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
        .build

    def securityGroupMembership(
      securityGroupId: Option[String] = None,
      status: Option[String] = None
    ): SecurityGroupMembership =
      SecurityGroupMembership
        .builder
        .ifSome(securityGroupId)(_.securityGroupId(_))
        .ifSome(status)(_.status(_))
        .build

    def serviceLinkedRoleNotFoundFault(

    ): ServiceLinkedRoleNotFoundFault =
      ServiceLinkedRoleNotFoundFault
        .builder

        .build

    def serviceUpdate(
      serviceUpdateName: Option[String] = None,
      serviceUpdateReleaseDate: Option[TStamp] = None,
      serviceUpdateEndDate: Option[TStamp] = None,
      serviceUpdateSeverity: Option[String] = None,
      serviceUpdateRecommendedApplyByDate: Option[TStamp] = None,
      serviceUpdateStatus: Option[String] = None,
      serviceUpdateDescription: Option[String] = None,
      serviceUpdateType: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      autoUpdateAfterRecommendedApplyByDate: Option[Boolean] = None,
      estimatedUpdateTime: Option[String] = None
    ): ServiceUpdate =
      ServiceUpdate
        .builder
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .ifSome(serviceUpdateReleaseDate)(_.serviceUpdateReleaseDate(_))
        .ifSome(serviceUpdateEndDate)(_.serviceUpdateEndDate(_))
        .ifSome(serviceUpdateSeverity)(_.serviceUpdateSeverity(_))
        .ifSome(serviceUpdateRecommendedApplyByDate)(_.serviceUpdateRecommendedApplyByDate(_))
        .ifSome(serviceUpdateStatus)(_.serviceUpdateStatus(_))
        .ifSome(serviceUpdateDescription)(_.serviceUpdateDescription(_))
        .ifSome(serviceUpdateType)(_.serviceUpdateType(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(autoUpdateAfterRecommendedApplyByDate)(_.autoUpdateAfterRecommendedApplyByDate(_))
        .ifSome(estimatedUpdateTime)(_.estimatedUpdateTime(_))
        .build

    def serviceUpdateNotFoundFault(

    ): ServiceUpdateNotFoundFault =
      ServiceUpdateNotFoundFault
        .builder

        .build

    def serviceUpdatesMessage(
      marker: Option[String] = None,
      serviceUpdates: Option[List[ServiceUpdate]] = None
    ): ServiceUpdatesMessage =
      ServiceUpdatesMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(serviceUpdates)(_.serviceUpdates(_))
        .build

    def slotMigration(
      progressPercentage: Option[Double] = None
    ): SlotMigration =
      SlotMigration
        .builder
        .ifSome(progressPercentage)(_.progressPercentage(_))
        .build

    def snapshot(
      snapshotName: Option[String] = None,
      replicationGroupId: Option[String] = None,
      replicationGroupDescription: Option[String] = None,
      cacheClusterId: Option[String] = None,
      snapshotStatus: Option[String] = None,
      snapshotSource: Option[String] = None,
      cacheNodeType: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      numCacheNodes: Option[Int] = None,
      preferredAvailabilityZone: Option[String] = None,
      preferredOutpostArn: Option[String] = None,
      cacheClusterCreateTime: Option[TStamp] = None,
      preferredMaintenanceWindow: Option[String] = None,
      topicArn: Option[String] = None,
      port: Option[Int] = None,
      cacheParameterGroupName: Option[String] = None,
      cacheSubnetGroupName: Option[String] = None,
      vpcId: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      snapshotRetentionLimit: Option[Int] = None,
      snapshotWindow: Option[String] = None,
      numNodeGroups: Option[Int] = None,
      automaticFailover: Option[String] = None,
      nodeSnapshots: Option[List[NodeSnapshot]] = None,
      kmsKeyId: Option[String] = None,
      aRN: Option[String] = None
    ): Snapshot =
      Snapshot
        .builder
        .ifSome(snapshotName)(_.snapshotName(_))
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(replicationGroupDescription)(_.replicationGroupDescription(_))
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(snapshotStatus)(_.snapshotStatus(_))
        .ifSome(snapshotSource)(_.snapshotSource(_))
        .ifSome(cacheNodeType)(_.cacheNodeType(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(numCacheNodes)(_.numCacheNodes(_))
        .ifSome(preferredAvailabilityZone)(_.preferredAvailabilityZone(_))
        .ifSome(preferredOutpostArn)(_.preferredOutpostArn(_))
        .ifSome(cacheClusterCreateTime)(_.cacheClusterCreateTime(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(port)(_.port(_))
        .ifSome(cacheParameterGroupName)(_.cacheParameterGroupName(_))
        .ifSome(cacheSubnetGroupName)(_.cacheSubnetGroupName(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(snapshotRetentionLimit)(_.snapshotRetentionLimit(_))
        .ifSome(snapshotWindow)(_.snapshotWindow(_))
        .ifSome(numNodeGroups)(_.numNodeGroups(_))
        .ifSome(automaticFailover)(_.automaticFailover(_))
        .ifSome(nodeSnapshots)(_.nodeSnapshots(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def snapshotAlreadyExistsFault(

    ): SnapshotAlreadyExistsFault =
      SnapshotAlreadyExistsFault
        .builder

        .build

    def snapshotFeatureNotSupportedFault(

    ): SnapshotFeatureNotSupportedFault =
      SnapshotFeatureNotSupportedFault
        .builder

        .build

    def snapshotNotFoundFault(

    ): SnapshotNotFoundFault =
      SnapshotNotFoundFault
        .builder

        .build

    def snapshotQuotaExceededFault(

    ): SnapshotQuotaExceededFault =
      SnapshotQuotaExceededFault
        .builder

        .build

    def startMigrationMessage(
      replicationGroupId: Option[String] = None,
      customerNodeEndpointList: Option[List[CustomerNodeEndpoint]] = None
    ): StartMigrationMessage =
      StartMigrationMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(customerNodeEndpointList)(_.customerNodeEndpointList(_))
        .build

    def startMigrationResponse(
      replicationGroup: Option[ReplicationGroup] = None
    ): StartMigrationResponse =
      StartMigrationResponse
        .builder
        .ifSome(replicationGroup)(_.replicationGroup(_))
        .build

    def subnet(
      subnetIdentifier: Option[String] = None,
      subnetAvailabilityZone: Option[AvailabilityZone] = None,
      subnetOutpost: Option[SubnetOutpost] = None
    ): Subnet =
      Subnet
        .builder
        .ifSome(subnetIdentifier)(_.subnetIdentifier(_))
        .ifSome(subnetAvailabilityZone)(_.subnetAvailabilityZone(_))
        .ifSome(subnetOutpost)(_.subnetOutpost(_))
        .build

    def subnetInUse(

    ): SubnetInUse =
      SubnetInUse
        .builder

        .build

    def subnetNotAllowedFault(

    ): SubnetNotAllowedFault =
      SubnetNotAllowedFault
        .builder

        .build

    def subnetOutpost(
      subnetOutpostArn: Option[String] = None
    ): SubnetOutpost =
      SubnetOutpost
        .builder
        .ifSome(subnetOutpostArn)(_.subnetOutpostArn(_))
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

    def tagListMessage(
      tagList: Option[List[Tag]] = None
    ): TagListMessage =
      TagListMessage
        .builder
        .ifSome(tagList)(_.tagList(_))
        .build

    def tagNotFoundFault(

    ): TagNotFoundFault =
      TagNotFoundFault
        .builder

        .build

    def tagQuotaPerResourceExceeded(

    ): TagQuotaPerResourceExceeded =
      TagQuotaPerResourceExceeded
        .builder

        .build

    def testFailoverMessage(
      replicationGroupId: Option[String] = None,
      nodeGroupId: Option[String] = None
    ): TestFailoverMessage =
      TestFailoverMessage
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(nodeGroupId)(_.nodeGroupId(_))
        .build

    def testFailoverNotAvailableFault(

    ): TestFailoverNotAvailableFault =
      TestFailoverNotAvailableFault
        .builder

        .build

    def timeRangeFilter(
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None
    ): TimeRangeFilter =
      TimeRangeFilter
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def unprocessedUpdateAction(
      replicationGroupId: Option[String] = None,
      cacheClusterId: Option[String] = None,
      serviceUpdateName: Option[String] = None,
      errorType: Option[String] = None,
      errorMessage: Option[String] = None
    ): UnprocessedUpdateAction =
      UnprocessedUpdateAction
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .ifSome(errorType)(_.errorType(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def updateAction(
      replicationGroupId: Option[String] = None,
      cacheClusterId: Option[String] = None,
      serviceUpdateName: Option[String] = None,
      serviceUpdateReleaseDate: Option[TStamp] = None,
      serviceUpdateSeverity: Option[String] = None,
      serviceUpdateStatus: Option[String] = None,
      serviceUpdateRecommendedApplyByDate: Option[TStamp] = None,
      serviceUpdateType: Option[String] = None,
      updateActionAvailableDate: Option[TStamp] = None,
      updateActionStatus: Option[String] = None,
      nodesUpdated: Option[String] = None,
      updateActionStatusModifiedDate: Option[TStamp] = None,
      slaMet: Option[String] = None,
      nodeGroupUpdateStatus: Option[List[NodeGroupUpdateStatus]] = None,
      cacheNodeUpdateStatus: Option[List[CacheNodeUpdateStatus]] = None,
      estimatedUpdateTime: Option[String] = None,
      engine: Option[String] = None
    ): UpdateAction =
      UpdateAction
        .builder
        .ifSome(replicationGroupId)(_.replicationGroupId(_))
        .ifSome(cacheClusterId)(_.cacheClusterId(_))
        .ifSome(serviceUpdateName)(_.serviceUpdateName(_))
        .ifSome(serviceUpdateReleaseDate)(_.serviceUpdateReleaseDate(_))
        .ifSome(serviceUpdateSeverity)(_.serviceUpdateSeverity(_))
        .ifSome(serviceUpdateStatus)(_.serviceUpdateStatus(_))
        .ifSome(serviceUpdateRecommendedApplyByDate)(_.serviceUpdateRecommendedApplyByDate(_))
        .ifSome(serviceUpdateType)(_.serviceUpdateType(_))
        .ifSome(updateActionAvailableDate)(_.updateActionAvailableDate(_))
        .ifSome(updateActionStatus)(_.updateActionStatus(_))
        .ifSome(nodesUpdated)(_.nodesUpdated(_))
        .ifSome(updateActionStatusModifiedDate)(_.updateActionStatusModifiedDate(_))
        .ifSome(slaMet)(_.slaMet(_))
        .ifSome(nodeGroupUpdateStatus)(_.nodeGroupUpdateStatus(_))
        .ifSome(cacheNodeUpdateStatus)(_.cacheNodeUpdateStatus(_))
        .ifSome(estimatedUpdateTime)(_.estimatedUpdateTime(_))
        .ifSome(engine)(_.engine(_))
        .build

    def updateActionResultsMessage(
      processedUpdateActions: Option[List[ProcessedUpdateAction]] = None,
      unprocessedUpdateActions: Option[List[UnprocessedUpdateAction]] = None
    ): UpdateActionResultsMessage =
      UpdateActionResultsMessage
        .builder
        .ifSome(processedUpdateActions)(_.processedUpdateActions(_))
        .ifSome(unprocessedUpdateActions)(_.unprocessedUpdateActions(_))
        .build

    def updateActionsMessage(
      marker: Option[String] = None,
      updateActions: Option[List[UpdateAction]] = None
    ): UpdateActionsMessage =
      UpdateActionsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(updateActions)(_.updateActions(_))
        .build

    def user(
      userId: Option[String] = None,
      userName: Option[String] = None,
      status: Option[String] = None,
      engine: Option[String] = None,
      accessString: Option[String] = None,
      userGroupIds: Option[List[UserGroupId]] = None,
      authentication: Option[Authentication] = None,
      aRN: Option[String] = None
    ): User =
      User
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(status)(_.status(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(accessString)(_.accessString(_))
        .ifSome(userGroupIds)(_.userGroupIds(_))
        .ifSome(authentication)(_.authentication(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def userAlreadyExistsFault(

    ): UserAlreadyExistsFault =
      UserAlreadyExistsFault
        .builder

        .build

    def userGroup(
      userGroupId: Option[String] = None,
      status: Option[String] = None,
      engine: Option[String] = None,
      userIds: Option[List[UserId]] = None,
      pendingChanges: Option[UserGroupPendingChanges] = None,
      replicationGroups: Option[List[String]] = None,
      aRN: Option[String] = None
    ): UserGroup =
      UserGroup
        .builder
        .ifSome(userGroupId)(_.userGroupId(_))
        .ifSome(status)(_.status(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(pendingChanges)(_.pendingChanges(_))
        .ifSome(replicationGroups)(_.replicationGroups(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def userGroupAlreadyExistsFault(

    ): UserGroupAlreadyExistsFault =
      UserGroupAlreadyExistsFault
        .builder

        .build

    def userGroupNotFoundFault(

    ): UserGroupNotFoundFault =
      UserGroupNotFoundFault
        .builder

        .build

    def userGroupPendingChanges(
      userIdsToRemove: Option[List[UserId]] = None,
      userIdsToAdd: Option[List[UserId]] = None
    ): UserGroupPendingChanges =
      UserGroupPendingChanges
        .builder
        .ifSome(userIdsToRemove)(_.userIdsToRemove(_))
        .ifSome(userIdsToAdd)(_.userIdsToAdd(_))
        .build

    def userGroupQuotaExceededFault(

    ): UserGroupQuotaExceededFault =
      UserGroupQuotaExceededFault
        .builder

        .build

    def userGroupsUpdateStatus(
      userGroupIdsToAdd: Option[List[UserGroupId]] = None,
      userGroupIdsToRemove: Option[List[UserGroupId]] = None
    ): UserGroupsUpdateStatus =
      UserGroupsUpdateStatus
        .builder
        .ifSome(userGroupIdsToAdd)(_.userGroupIdsToAdd(_))
        .ifSome(userGroupIdsToRemove)(_.userGroupIdsToRemove(_))
        .build

    def userNotFoundFault(

    ): UserNotFoundFault =
      UserNotFoundFault
        .builder

        .build

    def userQuotaExceededFault(

    ): UserQuotaExceededFault =
      UserQuotaExceededFault
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
