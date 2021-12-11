package goober.hi

import goober.free.neptune.NeptuneIO
import software.amazon.awssdk.services.neptune.model._


object neptune {
  import goober.free.{neptune ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addRoleToDBClusterMessage(
      dBClusterIdentifier: Option[String] = None,
      roleArn: Option[String] = None,
      featureName: Option[String] = None
    ): AddRoleToDBClusterMessage =
      AddRoleToDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(featureName)(_.featureName(_))
        .build

    def addSourceIdentifierToSubscriptionMessage(
      subscriptionName: Option[String] = None,
      sourceIdentifier: Option[String] = None
    ): AddSourceIdentifierToSubscriptionMessage =
      AddSourceIdentifierToSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
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

    def applyPendingMaintenanceActionMessage(
      resourceIdentifier: Option[String] = None,
      applyAction: Option[String] = None,
      optInType: Option[String] = None
    ): ApplyPendingMaintenanceActionMessage =
      ApplyPendingMaintenanceActionMessage
        .builder
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(applyAction)(_.applyAction(_))
        .ifSome(optInType)(_.optInType(_))
        .build

    def authorizationNotFoundFault(

    ): AuthorizationNotFoundFault =
      AuthorizationNotFoundFault
        .builder

        .build

    def availabilityZone(
      name: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(name)(_.name(_))
        .build

    def certificateNotFoundFault(

    ): CertificateNotFoundFault =
      CertificateNotFoundFault
        .builder

        .build

    def characterSet(
      characterSetName: Option[String] = None,
      characterSetDescription: Option[String] = None
    ): CharacterSet =
      CharacterSet
        .builder
        .ifSome(characterSetName)(_.characterSetName(_))
        .ifSome(characterSetDescription)(_.characterSetDescription(_))
        .build

    def cloudwatchLogsExportConfiguration(
      enableLogTypes: Option[List[String]] = None,
      disableLogTypes: Option[List[String]] = None
    ): CloudwatchLogsExportConfiguration =
      CloudwatchLogsExportConfiguration
        .builder
        .ifSome(enableLogTypes)(_.enableLogTypes(_))
        .ifSome(disableLogTypes)(_.disableLogTypes(_))
        .build

    def copyDBClusterParameterGroupMessage(
      sourceDBClusterParameterGroupIdentifier: Option[String] = None,
      targetDBClusterParameterGroupIdentifier: Option[String] = None,
      targetDBClusterParameterGroupDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CopyDBClusterParameterGroupMessage =
      CopyDBClusterParameterGroupMessage
        .builder
        .ifSome(sourceDBClusterParameterGroupIdentifier)(_.sourceDBClusterParameterGroupIdentifier(_))
        .ifSome(targetDBClusterParameterGroupIdentifier)(_.targetDBClusterParameterGroupIdentifier(_))
        .ifSome(targetDBClusterParameterGroupDescription)(_.targetDBClusterParameterGroupDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def copyDBClusterSnapshotMessage(
      sourceDBClusterSnapshotIdentifier: Option[String] = None,
      targetDBClusterSnapshotIdentifier: Option[String] = None,
      kmsKeyId: Option[String] = None,
      preSignedUrl: Option[String] = None,
      copyTags: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CopyDBClusterSnapshotMessage =
      CopyDBClusterSnapshotMessage
        .builder
        .ifSome(sourceDBClusterSnapshotIdentifier)(_.sourceDBClusterSnapshotIdentifier(_))
        .ifSome(targetDBClusterSnapshotIdentifier)(_.targetDBClusterSnapshotIdentifier(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .ifSome(copyTags)(_.copyTags(_))
        .ifSome(tags)(_.tags(_))
        .build

    def copyDBParameterGroupMessage(
      sourceDBParameterGroupIdentifier: Option[String] = None,
      targetDBParameterGroupIdentifier: Option[String] = None,
      targetDBParameterGroupDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CopyDBParameterGroupMessage =
      CopyDBParameterGroupMessage
        .builder
        .ifSome(sourceDBParameterGroupIdentifier)(_.sourceDBParameterGroupIdentifier(_))
        .ifSome(targetDBParameterGroupIdentifier)(_.targetDBParameterGroupIdentifier(_))
        .ifSome(targetDBParameterGroupDescription)(_.targetDBParameterGroupDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBClusterEndpointMessage(
      dBClusterIdentifier: Option[String] = None,
      dBClusterEndpointIdentifier: Option[String] = None,
      endpointType: Option[String] = None,
      staticMembers: Option[List[String]] = None,
      excludedMembers: Option[List[String]] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBClusterEndpointMessage =
      CreateDBClusterEndpointMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(staticMembers)(_.staticMembers(_))
        .ifSome(excludedMembers)(_.excludedMembers(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBClusterEndpointOutput(
      dBClusterEndpointIdentifier: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      dBClusterEndpointResourceIdentifier: Option[String] = None,
      endpoint: Option[String] = None,
      status: Option[String] = None,
      endpointType: Option[String] = None,
      customEndpointType: Option[String] = None,
      staticMembers: Option[List[String]] = None,
      excludedMembers: Option[List[String]] = None,
      dBClusterEndpointArn: Option[String] = None
    ): CreateDBClusterEndpointOutput =
      CreateDBClusterEndpointOutput
        .builder
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterEndpointResourceIdentifier)(_.dBClusterEndpointResourceIdentifier(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(status)(_.status(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(customEndpointType)(_.customEndpointType(_))
        .ifSome(staticMembers)(_.staticMembers(_))
        .ifSome(excludedMembers)(_.excludedMembers(_))
        .ifSome(dBClusterEndpointArn)(_.dBClusterEndpointArn(_))
        .build

    def createDBClusterMessage(
      availabilityZones: Option[List[String]] = None,
      backupRetentionPeriod: Option[Int] = None,
      characterSetName: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      databaseName: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      dBClusterParameterGroupName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      dBSubnetGroupName: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      port: Option[Int] = None,
      masterUsername: Option[String] = None,
      masterUserPassword: Option[String] = None,
      optionGroupName: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      replicationSourceIdentifier: Option[String] = None,
      tags: Option[List[Tag]] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      preSignedUrl: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      deletionProtection: Option[Boolean] = None
    ): CreateDBClusterMessage =
      CreateDBClusterMessage
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(characterSetName)(_.characterSetName(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(port)(_.port(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(replicationSourceIdentifier)(_.replicationSourceIdentifier(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def createDBClusterParameterGroupMessage(
      dBClusterParameterGroupName: Option[String] = None,
      dBParameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBClusterParameterGroupMessage =
      CreateDBClusterParameterGroupMessage
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBClusterSnapshotMessage(
      dBClusterSnapshotIdentifier: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBClusterSnapshotMessage =
      CreateDBClusterSnapshotMessage
        .builder
        .ifSome(dBClusterSnapshotIdentifier)(_.dBClusterSnapshotIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBInstanceMessage(
      dBName: Option[String] = None,
      dBInstanceIdentifier: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      dBInstanceClass: Option[String] = None,
      engine: Option[String] = None,
      masterUsername: Option[String] = None,
      masterUserPassword: Option[String] = None,
      dBSecurityGroups: Option[List[String]] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      availabilityZone: Option[String] = None,
      dBSubnetGroupName: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      dBParameterGroupName: Option[String] = None,
      backupRetentionPeriod: Option[Int] = None,
      preferredBackupWindow: Option[String] = None,
      port: Option[Int] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      characterSetName: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      dBClusterIdentifier: Option[String] = None,
      storageType: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      tdeCredentialPassword: Option[String] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      domain: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      monitoringInterval: Option[Int] = None,
      monitoringRoleArn: Option[String] = None,
      domainIAMRoleName: Option[String] = None,
      promotionTier: Option[Int] = None,
      timezone: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enablePerformanceInsights: Option[Boolean] = None,
      performanceInsightsKMSKeyId: Option[String] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      deletionProtection: Option[Boolean] = None
    ): CreateDBInstanceMessage =
      CreateDBInstanceMessage
        .builder
        .ifSome(dBName)(_.dBName(_))
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(dBSecurityGroups)(_.dBSecurityGroups(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(port)(_.port(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(characterSetName)(_.characterSetName(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(tdeCredentialPassword)(_.tdeCredentialPassword(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(monitoringInterval)(_.monitoringInterval(_))
        .ifSome(monitoringRoleArn)(_.monitoringRoleArn(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .ifSome(promotionTier)(_.promotionTier(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enablePerformanceInsights)(_.enablePerformanceInsights(_))
        .ifSome(performanceInsightsKMSKeyId)(_.performanceInsightsKMSKeyId(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def createDBParameterGroupMessage(
      dBParameterGroupName: Option[String] = None,
      dBParameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBParameterGroupMessage =
      CreateDBParameterGroupMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBSubnetGroupMessage(
      dBSubnetGroupName: Option[String] = None,
      dBSubnetGroupDescription: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBSubnetGroupMessage =
      CreateDBSubnetGroupMessage
        .builder
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(dBSubnetGroupDescription)(_.dBSubnetGroupDescription(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEventSubscriptionMessage(
      subscriptionName: Option[String] = None,
      snsTopicArn: Option[String] = None,
      sourceType: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      sourceIds: Option[List[String]] = None,
      enabled: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateEventSubscriptionMessage =
      CreateEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(sourceIds)(_.sourceIds(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(tags)(_.tags(_))
        .build

    def dBCluster(
      allocatedStorage: Option[Int] = None,
      availabilityZones: Option[List[String]] = None,
      backupRetentionPeriod: Option[Int] = None,
      characterSetName: Option[String] = None,
      databaseName: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      dBClusterParameterGroup: Option[String] = None,
      dBSubnetGroup: Option[String] = None,
      status: Option[String] = None,
      percentProgress: Option[String] = None,
      earliestRestorableTime: Option[TStamp] = None,
      endpoint: Option[String] = None,
      readerEndpoint: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      latestRestorableTime: Option[TStamp] = None,
      port: Option[Int] = None,
      masterUsername: Option[String] = None,
      dBClusterOptionGroupMemberships: Option[List[DBClusterOptionGroupStatus]] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      replicationSourceIdentifier: Option[String] = None,
      readReplicaIdentifiers: Option[List[String]] = None,
      dBClusterMembers: Option[List[DBClusterMember]] = None,
      vpcSecurityGroups: Option[List[VpcSecurityGroupMembership]] = None,
      hostedZoneId: Option[String] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      dbClusterResourceId: Option[String] = None,
      dBClusterArn: Option[String] = None,
      associatedRoles: Option[List[DBClusterRole]] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None,
      cloneGroupId: Option[String] = None,
      clusterCreateTime: Option[TStamp] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      enabledCloudwatchLogsExports: Option[List[String]] = None,
      deletionProtection: Option[Boolean] = None,
      crossAccountClone: Option[Boolean] = None,
      automaticRestartTime: Option[TStamp] = None
    ): DBCluster =
      DBCluster
        .builder
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(characterSetName)(_.characterSetName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterParameterGroup)(_.dBClusterParameterGroup(_))
        .ifSome(dBSubnetGroup)(_.dBSubnetGroup(_))
        .ifSome(status)(_.status(_))
        .ifSome(percentProgress)(_.percentProgress(_))
        .ifSome(earliestRestorableTime)(_.earliestRestorableTime(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(readerEndpoint)(_.readerEndpoint(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(latestRestorableTime)(_.latestRestorableTime(_))
        .ifSome(port)(_.port(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(dBClusterOptionGroupMemberships)(_.dBClusterOptionGroupMemberships(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(replicationSourceIdentifier)(_.replicationSourceIdentifier(_))
        .ifSome(readReplicaIdentifiers)(_.readReplicaIdentifiers(_))
        .ifSome(dBClusterMembers)(_.dBClusterMembers(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dbClusterResourceId)(_.dbClusterResourceId(_))
        .ifSome(dBClusterArn)(_.dBClusterArn(_))
        .ifSome(associatedRoles)(_.associatedRoles(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .ifSome(cloneGroupId)(_.cloneGroupId(_))
        .ifSome(clusterCreateTime)(_.clusterCreateTime(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(enabledCloudwatchLogsExports)(_.enabledCloudwatchLogsExports(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(crossAccountClone)(_.crossAccountClone(_))
        .ifSome(automaticRestartTime)(_.automaticRestartTime(_))
        .build

    def dBClusterAlreadyExistsFault(

    ): DBClusterAlreadyExistsFault =
      DBClusterAlreadyExistsFault
        .builder

        .build

    def dBClusterEndpoint(
      dBClusterEndpointIdentifier: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      dBClusterEndpointResourceIdentifier: Option[String] = None,
      endpoint: Option[String] = None,
      status: Option[String] = None,
      endpointType: Option[String] = None,
      customEndpointType: Option[String] = None,
      staticMembers: Option[List[String]] = None,
      excludedMembers: Option[List[String]] = None,
      dBClusterEndpointArn: Option[String] = None
    ): DBClusterEndpoint =
      DBClusterEndpoint
        .builder
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterEndpointResourceIdentifier)(_.dBClusterEndpointResourceIdentifier(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(status)(_.status(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(customEndpointType)(_.customEndpointType(_))
        .ifSome(staticMembers)(_.staticMembers(_))
        .ifSome(excludedMembers)(_.excludedMembers(_))
        .ifSome(dBClusterEndpointArn)(_.dBClusterEndpointArn(_))
        .build

    def dBClusterEndpointAlreadyExistsFault(

    ): DBClusterEndpointAlreadyExistsFault =
      DBClusterEndpointAlreadyExistsFault
        .builder

        .build

    def dBClusterEndpointMessage(
      marker: Option[String] = None,
      dBClusterEndpoints: Option[List[DBClusterEndpoint]] = None
    ): DBClusterEndpointMessage =
      DBClusterEndpointMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBClusterEndpoints)(_.dBClusterEndpoints(_))
        .build

    def dBClusterEndpointNotFoundFault(

    ): DBClusterEndpointNotFoundFault =
      DBClusterEndpointNotFoundFault
        .builder

        .build

    def dBClusterEndpointQuotaExceededFault(

    ): DBClusterEndpointQuotaExceededFault =
      DBClusterEndpointQuotaExceededFault
        .builder

        .build

    def dBClusterMember(
      dBInstanceIdentifier: Option[String] = None,
      isClusterWriter: Option[Boolean] = None,
      dBClusterParameterGroupStatus: Option[String] = None,
      promotionTier: Option[Int] = None
    ): DBClusterMember =
      DBClusterMember
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(isClusterWriter)(_.isClusterWriter(_))
        .ifSome(dBClusterParameterGroupStatus)(_.dBClusterParameterGroupStatus(_))
        .ifSome(promotionTier)(_.promotionTier(_))
        .build

    def dBClusterMessage(
      marker: Option[String] = None,
      dBClusters: Option[List[DBCluster]] = None
    ): DBClusterMessage =
      DBClusterMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBClusters)(_.dBClusters(_))
        .build

    def dBClusterNotFoundFault(

    ): DBClusterNotFoundFault =
      DBClusterNotFoundFault
        .builder

        .build

    def dBClusterOptionGroupStatus(
      dBClusterOptionGroupName: Option[String] = None,
      status: Option[String] = None
    ): DBClusterOptionGroupStatus =
      DBClusterOptionGroupStatus
        .builder
        .ifSome(dBClusterOptionGroupName)(_.dBClusterOptionGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def dBClusterParameterGroup(
      dBClusterParameterGroupName: Option[String] = None,
      dBParameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      dBClusterParameterGroupArn: Option[String] = None
    ): DBClusterParameterGroup =
      DBClusterParameterGroup
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(dBClusterParameterGroupArn)(_.dBClusterParameterGroupArn(_))
        .build

    def dBClusterParameterGroupDetails(
      parameters: Option[List[Parameter]] = None,
      marker: Option[String] = None
    ): DBClusterParameterGroupDetails =
      DBClusterParameterGroupDetails
        .builder
        .ifSome(parameters)(_.parameters(_))
        .ifSome(marker)(_.marker(_))
        .build

    def dBClusterParameterGroupNameMessage(
      dBClusterParameterGroupName: Option[String] = None
    ): DBClusterParameterGroupNameMessage =
      DBClusterParameterGroupNameMessage
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .build

    def dBClusterParameterGroupNotFoundFault(

    ): DBClusterParameterGroupNotFoundFault =
      DBClusterParameterGroupNotFoundFault
        .builder

        .build

    def dBClusterParameterGroupsMessage(
      marker: Option[String] = None,
      dBClusterParameterGroups: Option[List[DBClusterParameterGroup]] = None
    ): DBClusterParameterGroupsMessage =
      DBClusterParameterGroupsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBClusterParameterGroups)(_.dBClusterParameterGroups(_))
        .build

    def dBClusterQuotaExceededFault(

    ): DBClusterQuotaExceededFault =
      DBClusterQuotaExceededFault
        .builder

        .build

    def dBClusterRole(
      roleArn: Option[String] = None,
      status: Option[String] = None,
      featureName: Option[String] = None
    ): DBClusterRole =
      DBClusterRole
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(featureName)(_.featureName(_))
        .build

    def dBClusterRoleAlreadyExistsFault(

    ): DBClusterRoleAlreadyExistsFault =
      DBClusterRoleAlreadyExistsFault
        .builder

        .build

    def dBClusterRoleNotFoundFault(

    ): DBClusterRoleNotFoundFault =
      DBClusterRoleNotFoundFault
        .builder

        .build

    def dBClusterRoleQuotaExceededFault(

    ): DBClusterRoleQuotaExceededFault =
      DBClusterRoleQuotaExceededFault
        .builder

        .build

    def dBClusterSnapshot(
      availabilityZones: Option[List[String]] = None,
      dBClusterSnapshotIdentifier: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      snapshotCreateTime: Option[TStamp] = None,
      engine: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      status: Option[String] = None,
      port: Option[Int] = None,
      vpcId: Option[String] = None,
      clusterCreateTime: Option[TStamp] = None,
      masterUsername: Option[String] = None,
      engineVersion: Option[String] = None,
      licenseModel: Option[String] = None,
      snapshotType: Option[String] = None,
      percentProgress: Option[Int] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      dBClusterSnapshotArn: Option[String] = None,
      sourceDBClusterSnapshotArn: Option[String] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None
    ): DBClusterSnapshot =
      DBClusterSnapshot
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(dBClusterSnapshotIdentifier)(_.dBClusterSnapshotIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(snapshotCreateTime)(_.snapshotCreateTime(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(status)(_.status(_))
        .ifSome(port)(_.port(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(clusterCreateTime)(_.clusterCreateTime(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(percentProgress)(_.percentProgress(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dBClusterSnapshotArn)(_.dBClusterSnapshotArn(_))
        .ifSome(sourceDBClusterSnapshotArn)(_.sourceDBClusterSnapshotArn(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .build

    def dBClusterSnapshotAlreadyExistsFault(

    ): DBClusterSnapshotAlreadyExistsFault =
      DBClusterSnapshotAlreadyExistsFault
        .builder

        .build

    def dBClusterSnapshotAttribute(
      attributeName: Option[String] = None,
      attributeValues: Option[List[String]] = None
    ): DBClusterSnapshotAttribute =
      DBClusterSnapshotAttribute
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValues)(_.attributeValues(_))
        .build

    def dBClusterSnapshotMessage(
      marker: Option[String] = None,
      dBClusterSnapshots: Option[List[DBClusterSnapshot]] = None
    ): DBClusterSnapshotMessage =
      DBClusterSnapshotMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBClusterSnapshots)(_.dBClusterSnapshots(_))
        .build

    def dBClusterSnapshotNotFoundFault(

    ): DBClusterSnapshotNotFoundFault =
      DBClusterSnapshotNotFoundFault
        .builder

        .build

    def dBEngineVersion(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      dBParameterGroupFamily: Option[String] = None,
      dBEngineDescription: Option[String] = None,
      dBEngineVersionDescription: Option[String] = None,
      defaultCharacterSet: Option[CharacterSet] = None,
      supportedCharacterSets: Option[List[CharacterSet]] = None,
      validUpgradeTarget: Option[List[UpgradeTarget]] = None,
      supportedTimezones: Option[List[Timezone]] = None,
      exportableLogTypes: Option[List[String]] = None,
      supportsLogExportsToCloudwatchLogs: Option[Boolean] = None,
      supportsReadReplica: Option[Boolean] = None
    ): DBEngineVersion =
      DBEngineVersion
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(dBEngineDescription)(_.dBEngineDescription(_))
        .ifSome(dBEngineVersionDescription)(_.dBEngineVersionDescription(_))
        .ifSome(defaultCharacterSet)(_.defaultCharacterSet(_))
        .ifSome(supportedCharacterSets)(_.supportedCharacterSets(_))
        .ifSome(validUpgradeTarget)(_.validUpgradeTarget(_))
        .ifSome(supportedTimezones)(_.supportedTimezones(_))
        .ifSome(exportableLogTypes)(_.exportableLogTypes(_))
        .ifSome(supportsLogExportsToCloudwatchLogs)(_.supportsLogExportsToCloudwatchLogs(_))
        .ifSome(supportsReadReplica)(_.supportsReadReplica(_))
        .build

    def dBEngineVersionMessage(
      marker: Option[String] = None,
      dBEngineVersions: Option[List[DBEngineVersion]] = None
    ): DBEngineVersionMessage =
      DBEngineVersionMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBEngineVersions)(_.dBEngineVersions(_))
        .build

    def dBInstance(
      dBInstanceIdentifier: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      engine: Option[String] = None,
      dBInstanceStatus: Option[String] = None,
      masterUsername: Option[String] = None,
      dBName: Option[String] = None,
      endpoint: Option[Endpoint] = None,
      allocatedStorage: Option[Int] = None,
      instanceCreateTime: Option[TStamp] = None,
      preferredBackupWindow: Option[String] = None,
      backupRetentionPeriod: Option[Int] = None,
      dBSecurityGroups: Option[List[DBSecurityGroupMembership]] = None,
      vpcSecurityGroups: Option[List[VpcSecurityGroupMembership]] = None,
      dBParameterGroups: Option[List[DBParameterGroupStatus]] = None,
      availabilityZone: Option[String] = None,
      dBSubnetGroup: Option[DBSubnetGroup] = None,
      preferredMaintenanceWindow: Option[String] = None,
      pendingModifiedValues: Option[PendingModifiedValues] = None,
      latestRestorableTime: Option[TStamp] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      readReplicaSourceDBInstanceIdentifier: Option[String] = None,
      readReplicaDBInstanceIdentifiers: Option[List[String]] = None,
      readReplicaDBClusterIdentifiers: Option[List[String]] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupMemberships: Option[List[OptionGroupMembership]] = None,
      characterSetName: Option[String] = None,
      secondaryAvailabilityZone: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      statusInfos: Option[List[DBInstanceStatusInfo]] = None,
      storageType: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      dbInstancePort: Option[Int] = None,
      dBClusterIdentifier: Option[String] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      dbiResourceId: Option[String] = None,
      cACertificateIdentifier: Option[String] = None,
      domainMemberships: Option[List[DomainMembership]] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      monitoringInterval: Option[Int] = None,
      enhancedMonitoringResourceArn: Option[String] = None,
      monitoringRoleArn: Option[String] = None,
      promotionTier: Option[Int] = None,
      dBInstanceArn: Option[String] = None,
      timezone: Option[String] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None,
      performanceInsightsEnabled: Option[Boolean] = None,
      performanceInsightsKMSKeyId: Option[String] = None,
      enabledCloudwatchLogsExports: Option[List[String]] = None,
      deletionProtection: Option[Boolean] = None
    ): DBInstance =
      DBInstance
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(dBInstanceStatus)(_.dBInstanceStatus(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(dBName)(_.dBName(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(instanceCreateTime)(_.instanceCreateTime(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(dBSecurityGroups)(_.dBSecurityGroups(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .ifSome(dBParameterGroups)(_.dBParameterGroups(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(dBSubnetGroup)(_.dBSubnetGroup(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(latestRestorableTime)(_.latestRestorableTime(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(readReplicaSourceDBInstanceIdentifier)(_.readReplicaSourceDBInstanceIdentifier(_))
        .ifSome(readReplicaDBInstanceIdentifiers)(_.readReplicaDBInstanceIdentifiers(_))
        .ifSome(readReplicaDBClusterIdentifiers)(_.readReplicaDBClusterIdentifiers(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupMemberships)(_.optionGroupMemberships(_))
        .ifSome(characterSetName)(_.characterSetName(_))
        .ifSome(secondaryAvailabilityZone)(_.secondaryAvailabilityZone(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(statusInfos)(_.statusInfos(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(dbInstancePort)(_.dbInstancePort(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
        .ifSome(cACertificateIdentifier)(_.cACertificateIdentifier(_))
        .ifSome(domainMemberships)(_.domainMemberships(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(monitoringInterval)(_.monitoringInterval(_))
        .ifSome(enhancedMonitoringResourceArn)(_.enhancedMonitoringResourceArn(_))
        .ifSome(monitoringRoleArn)(_.monitoringRoleArn(_))
        .ifSome(promotionTier)(_.promotionTier(_))
        .ifSome(dBInstanceArn)(_.dBInstanceArn(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .ifSome(performanceInsightsEnabled)(_.performanceInsightsEnabled(_))
        .ifSome(performanceInsightsKMSKeyId)(_.performanceInsightsKMSKeyId(_))
        .ifSome(enabledCloudwatchLogsExports)(_.enabledCloudwatchLogsExports(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def dBInstanceAlreadyExistsFault(

    ): DBInstanceAlreadyExistsFault =
      DBInstanceAlreadyExistsFault
        .builder

        .build

    def dBInstanceMessage(
      marker: Option[String] = None,
      dBInstances: Option[List[DBInstance]] = None
    ): DBInstanceMessage =
      DBInstanceMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBInstances)(_.dBInstances(_))
        .build

    def dBInstanceNotFoundFault(

    ): DBInstanceNotFoundFault =
      DBInstanceNotFoundFault
        .builder

        .build

    def dBInstanceStatusInfo(
      statusType: Option[String] = None,
      normal: Option[Boolean] = None,
      status: Option[String] = None,
      message: Option[String] = None
    ): DBInstanceStatusInfo =
      DBInstanceStatusInfo
        .builder
        .ifSome(statusType)(_.statusType(_))
        .ifSome(normal)(_.normal(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .build

    def dBParameterGroup(
      dBParameterGroupName: Option[String] = None,
      dBParameterGroupFamily: Option[String] = None,
      description: Option[String] = None,
      dBParameterGroupArn: Option[String] = None
    ): DBParameterGroup =
      DBParameterGroup
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(description)(_.description(_))
        .ifSome(dBParameterGroupArn)(_.dBParameterGroupArn(_))
        .build

    def dBParameterGroupAlreadyExistsFault(

    ): DBParameterGroupAlreadyExistsFault =
      DBParameterGroupAlreadyExistsFault
        .builder

        .build

    def dBParameterGroupDetails(
      parameters: Option[List[Parameter]] = None,
      marker: Option[String] = None
    ): DBParameterGroupDetails =
      DBParameterGroupDetails
        .builder
        .ifSome(parameters)(_.parameters(_))
        .ifSome(marker)(_.marker(_))
        .build

    def dBParameterGroupNameMessage(
      dBParameterGroupName: Option[String] = None
    ): DBParameterGroupNameMessage =
      DBParameterGroupNameMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .build

    def dBParameterGroupNotFoundFault(

    ): DBParameterGroupNotFoundFault =
      DBParameterGroupNotFoundFault
        .builder

        .build

    def dBParameterGroupQuotaExceededFault(

    ): DBParameterGroupQuotaExceededFault =
      DBParameterGroupQuotaExceededFault
        .builder

        .build

    def dBParameterGroupStatus(
      dBParameterGroupName: Option[String] = None,
      parameterApplyStatus: Option[String] = None
    ): DBParameterGroupStatus =
      DBParameterGroupStatus
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .build

    def dBParameterGroupsMessage(
      marker: Option[String] = None,
      dBParameterGroups: Option[List[DBParameterGroup]] = None
    ): DBParameterGroupsMessage =
      DBParameterGroupsMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBParameterGroups)(_.dBParameterGroups(_))
        .build

    def dBSecurityGroupMembership(
      dBSecurityGroupName: Option[String] = None,
      status: Option[String] = None
    ): DBSecurityGroupMembership =
      DBSecurityGroupMembership
        .builder
        .ifSome(dBSecurityGroupName)(_.dBSecurityGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def dBSecurityGroupNotFoundFault(

    ): DBSecurityGroupNotFoundFault =
      DBSecurityGroupNotFoundFault
        .builder

        .build

    def dBSnapshotAlreadyExistsFault(

    ): DBSnapshotAlreadyExistsFault =
      DBSnapshotAlreadyExistsFault
        .builder

        .build

    def dBSnapshotNotFoundFault(

    ): DBSnapshotNotFoundFault =
      DBSnapshotNotFoundFault
        .builder

        .build

    def dBSubnetGroup(
      dBSubnetGroupName: Option[String] = None,
      dBSubnetGroupDescription: Option[String] = None,
      vpcId: Option[String] = None,
      subnetGroupStatus: Option[String] = None,
      subnets: Option[List[Subnet]] = None,
      dBSubnetGroupArn: Option[String] = None
    ): DBSubnetGroup =
      DBSubnetGroup
        .builder
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(dBSubnetGroupDescription)(_.dBSubnetGroupDescription(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetGroupStatus)(_.subnetGroupStatus(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(dBSubnetGroupArn)(_.dBSubnetGroupArn(_))
        .build

    def dBSubnetGroupAlreadyExistsFault(

    ): DBSubnetGroupAlreadyExistsFault =
      DBSubnetGroupAlreadyExistsFault
        .builder

        .build

    def dBSubnetGroupDoesNotCoverEnoughAZs(

    ): DBSubnetGroupDoesNotCoverEnoughAZs =
      DBSubnetGroupDoesNotCoverEnoughAZs
        .builder

        .build

    def dBSubnetGroupMessage(
      marker: Option[String] = None,
      dBSubnetGroups: Option[List[DBSubnetGroup]] = None
    ): DBSubnetGroupMessage =
      DBSubnetGroupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBSubnetGroups)(_.dBSubnetGroups(_))
        .build

    def dBSubnetGroupNotFoundFault(

    ): DBSubnetGroupNotFoundFault =
      DBSubnetGroupNotFoundFault
        .builder

        .build

    def dBSubnetGroupQuotaExceededFault(

    ): DBSubnetGroupQuotaExceededFault =
      DBSubnetGroupQuotaExceededFault
        .builder

        .build

    def dBSubnetQuotaExceededFault(

    ): DBSubnetQuotaExceededFault =
      DBSubnetQuotaExceededFault
        .builder

        .build

    def dBUpgradeDependencyFailureFault(

    ): DBUpgradeDependencyFailureFault =
      DBUpgradeDependencyFailureFault
        .builder

        .build

    def deleteDBClusterEndpointMessage(
      dBClusterEndpointIdentifier: Option[String] = None
    ): DeleteDBClusterEndpointMessage =
      DeleteDBClusterEndpointMessage
        .builder
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .build

    def deleteDBClusterEndpointOutput(
      dBClusterEndpointIdentifier: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      dBClusterEndpointResourceIdentifier: Option[String] = None,
      endpoint: Option[String] = None,
      status: Option[String] = None,
      endpointType: Option[String] = None,
      customEndpointType: Option[String] = None,
      staticMembers: Option[List[String]] = None,
      excludedMembers: Option[List[String]] = None,
      dBClusterEndpointArn: Option[String] = None
    ): DeleteDBClusterEndpointOutput =
      DeleteDBClusterEndpointOutput
        .builder
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterEndpointResourceIdentifier)(_.dBClusterEndpointResourceIdentifier(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(status)(_.status(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(customEndpointType)(_.customEndpointType(_))
        .ifSome(staticMembers)(_.staticMembers(_))
        .ifSome(excludedMembers)(_.excludedMembers(_))
        .ifSome(dBClusterEndpointArn)(_.dBClusterEndpointArn(_))
        .build

    def deleteDBClusterMessage(
      dBClusterIdentifier: Option[String] = None,
      skipFinalSnapshot: Option[Boolean] = None,
      finalDBSnapshotIdentifier: Option[String] = None
    ): DeleteDBClusterMessage =
      DeleteDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(skipFinalSnapshot)(_.skipFinalSnapshot(_))
        .ifSome(finalDBSnapshotIdentifier)(_.finalDBSnapshotIdentifier(_))
        .build

    def deleteDBClusterParameterGroupMessage(
      dBClusterParameterGroupName: Option[String] = None
    ): DeleteDBClusterParameterGroupMessage =
      DeleteDBClusterParameterGroupMessage
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .build

    def deleteDBClusterSnapshotMessage(
      dBClusterSnapshotIdentifier: Option[String] = None
    ): DeleteDBClusterSnapshotMessage =
      DeleteDBClusterSnapshotMessage
        .builder
        .ifSome(dBClusterSnapshotIdentifier)(_.dBClusterSnapshotIdentifier(_))
        .build

    def deleteDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None,
      skipFinalSnapshot: Option[Boolean] = None,
      finalDBSnapshotIdentifier: Option[String] = None
    ): DeleteDBInstanceMessage =
      DeleteDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(skipFinalSnapshot)(_.skipFinalSnapshot(_))
        .ifSome(finalDBSnapshotIdentifier)(_.finalDBSnapshotIdentifier(_))
        .build

    def deleteDBParameterGroupMessage(
      dBParameterGroupName: Option[String] = None
    ): DeleteDBParameterGroupMessage =
      DeleteDBParameterGroupMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .build

    def deleteDBSubnetGroupMessage(
      dBSubnetGroupName: Option[String] = None
    ): DeleteDBSubnetGroupMessage =
      DeleteDBSubnetGroupMessage
        .builder
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .build

    def deleteEventSubscriptionMessage(
      subscriptionName: Option[String] = None
    ): DeleteEventSubscriptionMessage =
      DeleteEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .build

    def describeDBClusterEndpointsMessage(
      dBClusterIdentifier: Option[String] = None,
      dBClusterEndpointIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBClusterEndpointsMessage =
      DescribeDBClusterEndpointsMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBClusterParameterGroupsMessage(
      dBClusterParameterGroupName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBClusterParameterGroupsMessage =
      DescribeDBClusterParameterGroupsMessage
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBClusterParametersMessage(
      dBClusterParameterGroupName: Option[String] = None,
      source: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBClusterParametersMessage =
      DescribeDBClusterParametersMessage
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(source)(_.source(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBClusterSnapshotAttributesMessage(
      dBClusterSnapshotIdentifier: Option[String] = None
    ): DescribeDBClusterSnapshotAttributesMessage =
      DescribeDBClusterSnapshotAttributesMessage
        .builder
        .ifSome(dBClusterSnapshotIdentifier)(_.dBClusterSnapshotIdentifier(_))
        .build

    def describeDBClusterSnapshotsMessage(
      dBClusterIdentifier: Option[String] = None,
      dBClusterSnapshotIdentifier: Option[String] = None,
      snapshotType: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      includeShared: Option[Boolean] = None,
      includePublic: Option[Boolean] = None
    ): DescribeDBClusterSnapshotsMessage =
      DescribeDBClusterSnapshotsMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterSnapshotIdentifier)(_.dBClusterSnapshotIdentifier(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(includeShared)(_.includeShared(_))
        .ifSome(includePublic)(_.includePublic(_))
        .build

    def describeDBClustersMessage(
      dBClusterIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBClustersMessage =
      DescribeDBClustersMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBEngineVersionsMessage(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      dBParameterGroupFamily: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      defaultOnly: Option[Boolean] = None,
      listSupportedCharacterSets: Option[Boolean] = None,
      listSupportedTimezones: Option[Boolean] = None
    ): DescribeDBEngineVersionsMessage =
      DescribeDBEngineVersionsMessage
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(defaultOnly)(_.defaultOnly(_))
        .ifSome(listSupportedCharacterSets)(_.listSupportedCharacterSets(_))
        .ifSome(listSupportedTimezones)(_.listSupportedTimezones(_))
        .build

    def describeDBInstancesMessage(
      dBInstanceIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBInstancesMessage =
      DescribeDBInstancesMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBParameterGroupsMessage(
      dBParameterGroupName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBParameterGroupsMessage =
      DescribeDBParameterGroupsMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBParametersMessage(
      dBParameterGroupName: Option[String] = None,
      source: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBParametersMessage =
      DescribeDBParametersMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(source)(_.source(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBSubnetGroupsMessage(
      dBSubnetGroupName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBSubnetGroupsMessage =
      DescribeDBSubnetGroupsMessage
        .builder
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEngineDefaultClusterParametersMessage(
      dBParameterGroupFamily: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEngineDefaultClusterParametersMessage =
      DescribeEngineDefaultClusterParametersMessage
        .builder
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEngineDefaultParametersMessage(
      dBParameterGroupFamily: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEngineDefaultParametersMessage =
      DescribeEngineDefaultParametersMessage
        .builder
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEventCategoriesMessage(
      sourceType: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeEventCategoriesMessage =
      DescribeEventCategoriesMessage
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeEventSubscriptionsMessage(
      subscriptionName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEventSubscriptionsMessage =
      DescribeEventSubscriptionsMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEventsMessage(
      sourceIdentifier: Option[String] = None,
      sourceType: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      duration: Option[Int] = None,
      eventCategories: Option[List[String]] = None,
      filters: Option[List[Filter]] = None,
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
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeOrderableDBInstanceOptionsMessage(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      licenseModel: Option[String] = None,
      vpc: Option[Boolean] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeOrderableDBInstanceOptionsMessage =
      DescribeOrderableDBInstanceOptionsMessage
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(vpc)(_.vpc(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describePendingMaintenanceActionsMessage(
      resourceIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribePendingMaintenanceActionsMessage =
      DescribePendingMaintenanceActionsMessage
        .builder
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeValidDBInstanceModificationsMessage(
      dBInstanceIdentifier: Option[String] = None
    ): DescribeValidDBInstanceModificationsMessage =
      DescribeValidDBInstanceModificationsMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .build

    def domainMembership(
      domain: Option[String] = None,
      status: Option[String] = None,
      fQDN: Option[String] = None,
      iAMRoleName: Option[String] = None
    ): DomainMembership =
      DomainMembership
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(status)(_.status(_))
        .ifSome(fQDN)(_.fQDN(_))
        .ifSome(iAMRoleName)(_.iAMRoleName(_))
        .build

    def domainNotFoundFault(

    ): DomainNotFoundFault =
      DomainNotFoundFault
        .builder

        .build

    def doubleRange(
      from: Option[Double] = None,
      to: Option[Double] = None
    ): DoubleRange =
      DoubleRange
        .builder
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .build

    def endpoint(
      address: Option[String] = None,
      port: Option[Int] = None,
      hostedZoneId: Option[String] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(port)(_.port(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def engineDefaults(
      dBParameterGroupFamily: Option[String] = None,
      marker: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): EngineDefaults =
      EngineDefaults
        .builder
        .ifSome(dBParameterGroupFamily)(_.dBParameterGroupFamily(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def event(
      sourceIdentifier: Option[String] = None,
      sourceType: Option[String] = None,
      message: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      date: Option[TStamp] = None,
      sourceArn: Option[String] = None
    ): Event =
      Event
        .builder
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(message)(_.message(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(date)(_.date(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .build

    def eventCategoriesMap(
      sourceType: Option[String] = None,
      eventCategories: Option[List[String]] = None
    ): EventCategoriesMap =
      EventCategoriesMap
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .build

    def eventCategoriesMessage(
      eventCategoriesMapList: Option[List[EventCategoriesMap]] = None
    ): EventCategoriesMessage =
      EventCategoriesMessage
        .builder
        .ifSome(eventCategoriesMapList)(_.eventCategoriesMapList(_))
        .build

    def eventSubscription(
      customerAwsId: Option[String] = None,
      custSubscriptionId: Option[String] = None,
      snsTopicArn: Option[String] = None,
      status: Option[String] = None,
      subscriptionCreationTime: Option[String] = None,
      sourceType: Option[String] = None,
      sourceIdsList: Option[List[String]] = None,
      eventCategoriesList: Option[List[String]] = None,
      enabled: Option[Boolean] = None,
      eventSubscriptionArn: Option[String] = None
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
        .ifSome(enabled)(_.enabled(_))
        .ifSome(eventSubscriptionArn)(_.eventSubscriptionArn(_))
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

    def failoverDBClusterMessage(
      dBClusterIdentifier: Option[String] = None,
      targetDBInstanceIdentifier: Option[String] = None
    ): FailoverDBClusterMessage =
      FailoverDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(targetDBInstanceIdentifier)(_.targetDBInstanceIdentifier(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[String]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def instanceQuotaExceededFault(

    ): InstanceQuotaExceededFault =
      InstanceQuotaExceededFault
        .builder

        .build

    def insufficientDBClusterCapacityFault(

    ): InsufficientDBClusterCapacityFault =
      InsufficientDBClusterCapacityFault
        .builder

        .build

    def insufficientDBInstanceCapacityFault(

    ): InsufficientDBInstanceCapacityFault =
      InsufficientDBInstanceCapacityFault
        .builder

        .build

    def insufficientStorageClusterCapacityFault(

    ): InsufficientStorageClusterCapacityFault =
      InsufficientStorageClusterCapacityFault
        .builder

        .build

    def invalidDBClusterEndpointStateFault(

    ): InvalidDBClusterEndpointStateFault =
      InvalidDBClusterEndpointStateFault
        .builder

        .build

    def invalidDBClusterSnapshotStateFault(

    ): InvalidDBClusterSnapshotStateFault =
      InvalidDBClusterSnapshotStateFault
        .builder

        .build

    def invalidDBClusterStateFault(

    ): InvalidDBClusterStateFault =
      InvalidDBClusterStateFault
        .builder

        .build

    def invalidDBInstanceStateFault(

    ): InvalidDBInstanceStateFault =
      InvalidDBInstanceStateFault
        .builder

        .build

    def invalidDBParameterGroupStateFault(

    ): InvalidDBParameterGroupStateFault =
      InvalidDBParameterGroupStateFault
        .builder

        .build

    def invalidDBSecurityGroupStateFault(

    ): InvalidDBSecurityGroupStateFault =
      InvalidDBSecurityGroupStateFault
        .builder

        .build

    def invalidDBSnapshotStateFault(

    ): InvalidDBSnapshotStateFault =
      InvalidDBSnapshotStateFault
        .builder

        .build

    def invalidDBSubnetGroupStateFault(

    ): InvalidDBSubnetGroupStateFault =
      InvalidDBSubnetGroupStateFault
        .builder

        .build

    def invalidDBSubnetStateFault(

    ): InvalidDBSubnetStateFault =
      InvalidDBSubnetStateFault
        .builder

        .build

    def invalidEventSubscriptionStateFault(

    ): InvalidEventSubscriptionStateFault =
      InvalidEventSubscriptionStateFault
        .builder

        .build

    def invalidRestoreFault(

    ): InvalidRestoreFault =
      InvalidRestoreFault
        .builder

        .build

    def invalidSubnet(

    ): InvalidSubnet =
      InvalidSubnet
        .builder

        .build

    def invalidVPCNetworkStateFault(

    ): InvalidVPCNetworkStateFault =
      InvalidVPCNetworkStateFault
        .builder

        .build

    def kMSKeyNotAccessibleFault(

    ): KMSKeyNotAccessibleFault =
      KMSKeyNotAccessibleFault
        .builder

        .build

    def listTagsForResourceMessage(
      resourceName: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListTagsForResourceMessage =
      ListTagsForResourceMessage
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(filters)(_.filters(_))
        .build

    def modifyDBClusterEndpointMessage(
      dBClusterEndpointIdentifier: Option[String] = None,
      endpointType: Option[String] = None,
      staticMembers: Option[List[String]] = None,
      excludedMembers: Option[List[String]] = None
    ): ModifyDBClusterEndpointMessage =
      ModifyDBClusterEndpointMessage
        .builder
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(staticMembers)(_.staticMembers(_))
        .ifSome(excludedMembers)(_.excludedMembers(_))
        .build

    def modifyDBClusterEndpointOutput(
      dBClusterEndpointIdentifier: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      dBClusterEndpointResourceIdentifier: Option[String] = None,
      endpoint: Option[String] = None,
      status: Option[String] = None,
      endpointType: Option[String] = None,
      customEndpointType: Option[String] = None,
      staticMembers: Option[List[String]] = None,
      excludedMembers: Option[List[String]] = None,
      dBClusterEndpointArn: Option[String] = None
    ): ModifyDBClusterEndpointOutput =
      ModifyDBClusterEndpointOutput
        .builder
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBClusterEndpointResourceIdentifier)(_.dBClusterEndpointResourceIdentifier(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(status)(_.status(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(customEndpointType)(_.customEndpointType(_))
        .ifSome(staticMembers)(_.staticMembers(_))
        .ifSome(excludedMembers)(_.excludedMembers(_))
        .ifSome(dBClusterEndpointArn)(_.dBClusterEndpointArn(_))
        .build

    def modifyDBClusterMessage(
      dBClusterIdentifier: Option[String] = None,
      newDBClusterIdentifier: Option[String] = None,
      applyImmediately: Option[Boolean] = None,
      backupRetentionPeriod: Option[Int] = None,
      dBClusterParameterGroupName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      port: Option[Int] = None,
      masterUserPassword: Option[String] = None,
      optionGroupName: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      cloudwatchLogsExportConfiguration: Option[CloudwatchLogsExportConfiguration] = None,
      engineVersion: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      copyTagsToSnapshot: Option[Boolean] = None
    ): ModifyDBClusterMessage =
      ModifyDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(newDBClusterIdentifier)(_.newDBClusterIdentifier(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(port)(_.port(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(cloudwatchLogsExportConfiguration)(_.cloudwatchLogsExportConfiguration(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .build

    def modifyDBClusterParameterGroupMessage(
      dBClusterParameterGroupName: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): ModifyDBClusterParameterGroupMessage =
      ModifyDBClusterParameterGroupMessage
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def modifyDBClusterSnapshotAttributeMessage(
      dBClusterSnapshotIdentifier: Option[String] = None,
      attributeName: Option[String] = None,
      valuesToAdd: Option[List[String]] = None,
      valuesToRemove: Option[List[String]] = None
    ): ModifyDBClusterSnapshotAttributeMessage =
      ModifyDBClusterSnapshotAttributeMessage
        .builder
        .ifSome(dBClusterSnapshotIdentifier)(_.dBClusterSnapshotIdentifier(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(valuesToAdd)(_.valuesToAdd(_))
        .ifSome(valuesToRemove)(_.valuesToRemove(_))
        .build

    def modifyDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      dBInstanceClass: Option[String] = None,
      dBSubnetGroupName: Option[String] = None,
      dBSecurityGroups: Option[List[String]] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      applyImmediately: Option[Boolean] = None,
      masterUserPassword: Option[String] = None,
      dBParameterGroupName: Option[String] = None,
      backupRetentionPeriod: Option[Int] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      allowMajorVersionUpgrade: Option[Boolean] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      newDBInstanceIdentifier: Option[String] = None,
      storageType: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      tdeCredentialPassword: Option[String] = None,
      cACertificateIdentifier: Option[String] = None,
      domain: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      monitoringInterval: Option[Int] = None,
      dBPortNumber: Option[Int] = None,
      publiclyAccessible: Option[Boolean] = None,
      monitoringRoleArn: Option[String] = None,
      domainIAMRoleName: Option[String] = None,
      promotionTier: Option[Int] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enablePerformanceInsights: Option[Boolean] = None,
      performanceInsightsKMSKeyId: Option[String] = None,
      cloudwatchLogsExportConfiguration: Option[CloudwatchLogsExportConfiguration] = None,
      deletionProtection: Option[Boolean] = None
    ): ModifyDBInstanceMessage =
      ModifyDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(dBSecurityGroups)(_.dBSecurityGroups(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(allowMajorVersionUpgrade)(_.allowMajorVersionUpgrade(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(newDBInstanceIdentifier)(_.newDBInstanceIdentifier(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(tdeCredentialPassword)(_.tdeCredentialPassword(_))
        .ifSome(cACertificateIdentifier)(_.cACertificateIdentifier(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(monitoringInterval)(_.monitoringInterval(_))
        .ifSome(dBPortNumber)(_.dBPortNumber(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(monitoringRoleArn)(_.monitoringRoleArn(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .ifSome(promotionTier)(_.promotionTier(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enablePerformanceInsights)(_.enablePerformanceInsights(_))
        .ifSome(performanceInsightsKMSKeyId)(_.performanceInsightsKMSKeyId(_))
        .ifSome(cloudwatchLogsExportConfiguration)(_.cloudwatchLogsExportConfiguration(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def modifyDBParameterGroupMessage(
      dBParameterGroupName: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): ModifyDBParameterGroupMessage =
      ModifyDBParameterGroupMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def modifyDBSubnetGroupMessage(
      dBSubnetGroupName: Option[String] = None,
      dBSubnetGroupDescription: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): ModifyDBSubnetGroupMessage =
      ModifyDBSubnetGroupMessage
        .builder
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(dBSubnetGroupDescription)(_.dBSubnetGroupDescription(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def modifyEventSubscriptionMessage(
      subscriptionName: Option[String] = None,
      snsTopicArn: Option[String] = None,
      sourceType: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      enabled: Option[Boolean] = None
    ): ModifyEventSubscriptionMessage =
      ModifyEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def optionGroupMembership(
      optionGroupName: Option[String] = None,
      status: Option[String] = None
    ): OptionGroupMembership =
      OptionGroupMembership
        .builder
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def optionGroupNotFoundFault(

    ): OptionGroupNotFoundFault =
      OptionGroupNotFoundFault
        .builder

        .build

    def orderableDBInstanceOption(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      licenseModel: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None,
      multiAZCapable: Option[Boolean] = None,
      readReplicaCapable: Option[Boolean] = None,
      vpc: Option[Boolean] = None,
      supportsStorageEncryption: Option[Boolean] = None,
      storageType: Option[String] = None,
      supportsIops: Option[Boolean] = None,
      supportsEnhancedMonitoring: Option[Boolean] = None,
      supportsIAMDatabaseAuthentication: Option[Boolean] = None,
      supportsPerformanceInsights: Option[Boolean] = None,
      minStorageSize: Option[Int] = None,
      maxStorageSize: Option[Int] = None,
      minIopsPerDbInstance: Option[Int] = None,
      maxIopsPerDbInstance: Option[Int] = None,
      minIopsPerGib: Option[DoubleOptional] = None,
      maxIopsPerGib: Option[DoubleOptional] = None
    ): OrderableDBInstanceOption =
      OrderableDBInstanceOption
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(multiAZCapable)(_.multiAZCapable(_))
        .ifSome(readReplicaCapable)(_.readReplicaCapable(_))
        .ifSome(vpc)(_.vpc(_))
        .ifSome(supportsStorageEncryption)(_.supportsStorageEncryption(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(supportsIops)(_.supportsIops(_))
        .ifSome(supportsEnhancedMonitoring)(_.supportsEnhancedMonitoring(_))
        .ifSome(supportsIAMDatabaseAuthentication)(_.supportsIAMDatabaseAuthentication(_))
        .ifSome(supportsPerformanceInsights)(_.supportsPerformanceInsights(_))
        .ifSome(minStorageSize)(_.minStorageSize(_))
        .ifSome(maxStorageSize)(_.maxStorageSize(_))
        .ifSome(minIopsPerDbInstance)(_.minIopsPerDbInstance(_))
        .ifSome(maxIopsPerDbInstance)(_.maxIopsPerDbInstance(_))
        .ifSome(minIopsPerGib)(_.minIopsPerGib(_))
        .ifSome(maxIopsPerGib)(_.maxIopsPerGib(_))
        .build

    def orderableDBInstanceOptionsMessage(
      orderableDBInstanceOptions: Option[List[OrderableDBInstanceOption]] = None,
      marker: Option[String] = None
    ): OrderableDBInstanceOptionsMessage =
      OrderableDBInstanceOptionsMessage
        .builder
        .ifSome(orderableDBInstanceOptions)(_.orderableDBInstanceOptions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def parameter(
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None,
      description: Option[String] = None,
      source: Option[String] = None,
      applyType: Option[String] = None,
      dataType: Option[String] = None,
      allowedValues: Option[String] = None,
      isModifiable: Option[Boolean] = None,
      minimumEngineVersion: Option[String] = None,
      applyMethod: Option[String] = None
    ): Parameter =
      Parameter
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(applyType)(_.applyType(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(minimumEngineVersion)(_.minimumEngineVersion(_))
        .ifSome(applyMethod)(_.applyMethod(_))
        .build

    def pendingCloudwatchLogsExports(
      logTypesToEnable: Option[List[String]] = None,
      logTypesToDisable: Option[List[String]] = None
    ): PendingCloudwatchLogsExports =
      PendingCloudwatchLogsExports
        .builder
        .ifSome(logTypesToEnable)(_.logTypesToEnable(_))
        .ifSome(logTypesToDisable)(_.logTypesToDisable(_))
        .build

    def pendingMaintenanceAction(
      action: Option[String] = None,
      autoAppliedAfterDate: Option[TStamp] = None,
      forcedApplyDate: Option[TStamp] = None,
      optInStatus: Option[String] = None,
      currentApplyDate: Option[TStamp] = None,
      description: Option[String] = None
    ): PendingMaintenanceAction =
      PendingMaintenanceAction
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(autoAppliedAfterDate)(_.autoAppliedAfterDate(_))
        .ifSome(forcedApplyDate)(_.forcedApplyDate(_))
        .ifSome(optInStatus)(_.optInStatus(_))
        .ifSome(currentApplyDate)(_.currentApplyDate(_))
        .ifSome(description)(_.description(_))
        .build

    def pendingMaintenanceActionsMessage(
      pendingMaintenanceActions: Option[List[ResourcePendingMaintenanceActions]] = None,
      marker: Option[String] = None
    ): PendingMaintenanceActionsMessage =
      PendingMaintenanceActionsMessage
        .builder
        .ifSome(pendingMaintenanceActions)(_.pendingMaintenanceActions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def pendingModifiedValues(
      dBInstanceClass: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      masterUserPassword: Option[String] = None,
      port: Option[Int] = None,
      backupRetentionPeriod: Option[Int] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      dBInstanceIdentifier: Option[String] = None,
      storageType: Option[String] = None,
      cACertificateIdentifier: Option[String] = None,
      dBSubnetGroupName: Option[String] = None,
      pendingCloudwatchLogsExports: Option[PendingCloudwatchLogsExports] = None
    ): PendingModifiedValues =
      PendingModifiedValues
        .builder
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(port)(_.port(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(cACertificateIdentifier)(_.cACertificateIdentifier(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(pendingCloudwatchLogsExports)(_.pendingCloudwatchLogsExports(_))
        .build

    def promoteReadReplicaDBClusterMessage(
      dBClusterIdentifier: Option[String] = None
    ): PromoteReadReplicaDBClusterMessage =
      PromoteReadReplicaDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .build

    def provisionedIopsNotAvailableInAZFault(

    ): ProvisionedIopsNotAvailableInAZFault =
      ProvisionedIopsNotAvailableInAZFault
        .builder

        .build

    def range(
      from: Option[Int] = None,
      to: Option[Int] = None,
      step: Option[Int] = None
    ): Range =
      Range
        .builder
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .ifSome(step)(_.step(_))
        .build

    def rebootDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None,
      forceFailover: Option[Boolean] = None
    ): RebootDBInstanceMessage =
      RebootDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(forceFailover)(_.forceFailover(_))
        .build

    def removeRoleFromDBClusterMessage(
      dBClusterIdentifier: Option[String] = None,
      roleArn: Option[String] = None,
      featureName: Option[String] = None
    ): RemoveRoleFromDBClusterMessage =
      RemoveRoleFromDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(featureName)(_.featureName(_))
        .build

    def removeSourceIdentifierFromSubscriptionMessage(
      subscriptionName: Option[String] = None,
      sourceIdentifier: Option[String] = None
    ): RemoveSourceIdentifierFromSubscriptionMessage =
      RemoveSourceIdentifierFromSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
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

    def resetDBClusterParameterGroupMessage(
      dBClusterParameterGroupName: Option[String] = None,
      resetAllParameters: Option[Boolean] = None,
      parameters: Option[List[Parameter]] = None
    ): ResetDBClusterParameterGroupMessage =
      ResetDBClusterParameterGroupMessage
        .builder
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(resetAllParameters)(_.resetAllParameters(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def resetDBParameterGroupMessage(
      dBParameterGroupName: Option[String] = None,
      resetAllParameters: Option[Boolean] = None,
      parameters: Option[List[Parameter]] = None
    ): ResetDBParameterGroupMessage =
      ResetDBParameterGroupMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(resetAllParameters)(_.resetAllParameters(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def resourceNotFoundFault(

    ): ResourceNotFoundFault =
      ResourceNotFoundFault
        .builder

        .build

    def resourcePendingMaintenanceActions(
      resourceIdentifier: Option[String] = None,
      pendingMaintenanceActionDetails: Option[List[PendingMaintenanceAction]] = None
    ): ResourcePendingMaintenanceActions =
      ResourcePendingMaintenanceActions
        .builder
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(pendingMaintenanceActionDetails)(_.pendingMaintenanceActionDetails(_))
        .build

    def restoreDBClusterFromSnapshotMessage(
      availabilityZones: Option[List[String]] = None,
      dBClusterIdentifier: Option[String] = None,
      snapshotIdentifier: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      port: Option[Int] = None,
      dBSubnetGroupName: Option[String] = None,
      databaseName: Option[String] = None,
      optionGroupName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None,
      kmsKeyId: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      dBClusterParameterGroupName: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      copyTagsToSnapshot: Option[Boolean] = None
    ): RestoreDBClusterFromSnapshotMessage =
      RestoreDBClusterFromSnapshotMessage
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(snapshotIdentifier)(_.snapshotIdentifier(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(port)(_.port(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .build

    def restoreDBClusterToPointInTimeMessage(
      dBClusterIdentifier: Option[String] = None,
      restoreType: Option[String] = None,
      sourceDBClusterIdentifier: Option[String] = None,
      restoreToTime: Option[TStamp] = None,
      useLatestRestorableTime: Option[Boolean] = None,
      port: Option[Int] = None,
      dBSubnetGroupName: Option[String] = None,
      optionGroupName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None,
      kmsKeyId: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      dBClusterParameterGroupName: Option[String] = None,
      deletionProtection: Option[Boolean] = None
    ): RestoreDBClusterToPointInTimeMessage =
      RestoreDBClusterToPointInTimeMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(restoreType)(_.restoreType(_))
        .ifSome(sourceDBClusterIdentifier)(_.sourceDBClusterIdentifier(_))
        .ifSome(restoreToTime)(_.restoreToTime(_))
        .ifSome(useLatestRestorableTime)(_.useLatestRestorableTime(_))
        .ifSome(port)(_.port(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
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

    def sharedSnapshotQuotaExceededFault(

    ): SharedSnapshotQuotaExceededFault =
      SharedSnapshotQuotaExceededFault
        .builder

        .build

    def snapshotQuotaExceededFault(

    ): SnapshotQuotaExceededFault =
      SnapshotQuotaExceededFault
        .builder

        .build

    def sourceNotFoundFault(

    ): SourceNotFoundFault =
      SourceNotFoundFault
        .builder

        .build

    def startDBClusterMessage(
      dBClusterIdentifier: Option[String] = None
    ): StartDBClusterMessage =
      StartDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .build

    def stopDBClusterMessage(
      dBClusterIdentifier: Option[String] = None
    ): StopDBClusterMessage =
      StopDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .build

    def storageQuotaExceededFault(

    ): StorageQuotaExceededFault =
      StorageQuotaExceededFault
        .builder

        .build

    def storageTypeNotSupportedFault(

    ): StorageTypeNotSupportedFault =
      StorageTypeNotSupportedFault
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

    def subscriptionNotFoundFault(

    ): SubscriptionNotFoundFault =
      SubscriptionNotFoundFault
        .builder

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

    def timezone(
      timezoneName: Option[String] = None
    ): Timezone =
      Timezone
        .builder
        .ifSome(timezoneName)(_.timezoneName(_))
        .build

    def upgradeTarget(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      description: Option[String] = None,
      autoUpgrade: Option[Boolean] = None,
      isMajorVersionUpgrade: Option[Boolean] = None
    ): UpgradeTarget =
      UpgradeTarget
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(autoUpgrade)(_.autoUpgrade(_))
        .ifSome(isMajorVersionUpgrade)(_.isMajorVersionUpgrade(_))
        .build

    def validDBInstanceModificationsMessage(
      storage: Option[List[ValidStorageOptions]] = None
    ): ValidDBInstanceModificationsMessage =
      ValidDBInstanceModificationsMessage
        .builder
        .ifSome(storage)(_.storage(_))
        .build

    def validStorageOptions(
      storageType: Option[String] = None,
      storageSize: Option[List[Range]] = None,
      provisionedIops: Option[List[Range]] = None,
      iopsToStorageRatio: Option[List[DoubleRange]] = None
    ): ValidStorageOptions =
      ValidStorageOptions
        .builder
        .ifSome(storageType)(_.storageType(_))
        .ifSome(storageSize)(_.storageSize(_))
        .ifSome(provisionedIops)(_.provisionedIops(_))
        .ifSome(iopsToStorageRatio)(_.iopsToStorageRatio(_))
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
