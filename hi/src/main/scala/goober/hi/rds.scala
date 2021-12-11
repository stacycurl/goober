package goober.hi

import goober.free.rds.RdsIO
import software.amazon.awssdk.services.rds.model._


object rds {
  import goober.free.{rds ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountAttributesMessage(
      accountQuotas: Option[List[AccountQuota]] = None
    ): AccountAttributesMessage =
      AccountAttributesMessage
        .builder
        .ifSome(accountQuotas)(_.accountQuotas(_))
        .build

    def accountQuota(
      accountQuotaName: Option[String] = None,
      used: Option[Long] = None,
      max: Option[Long] = None
    ): AccountQuota =
      AccountQuota
        .builder
        .ifSome(accountQuotaName)(_.accountQuotaName(_))
        .ifSome(used)(_.used(_))
        .ifSome(max)(_.max(_))
        .build

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

    def addRoleToDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None,
      roleArn: Option[String] = None,
      featureName: Option[String] = None
    ): AddRoleToDBInstanceMessage =
      AddRoleToDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
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

    def authorizeDBSecurityGroupIngressMessage(
      dBSecurityGroupName: Option[String] = None,
      cIDRIP: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupId: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): AuthorizeDBSecurityGroupIngressMessage =
      AuthorizeDBSecurityGroupIngressMessage
        .builder
        .ifSome(dBSecurityGroupName)(_.dBSecurityGroupName(_))
        .ifSome(cIDRIP)(_.cIDRIP(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupId)(_.eC2SecurityGroupId(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
        .build

    def availabilityZone(
      name: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(name)(_.name(_))
        .build

    def availableProcessorFeature(
      name: Option[String] = None,
      defaultValue: Option[String] = None,
      allowedValues: Option[String] = None
    ): AvailableProcessorFeature =
      AvailableProcessorFeature
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .build

    def backtrackDBClusterMessage(
      dBClusterIdentifier: Option[String] = None,
      backtrackTo: Option[TStamp] = None,
      force: Option[Boolean] = None,
      useEarliestTimeOnPointInTimeUnavailable: Option[Boolean] = None
    ): BacktrackDBClusterMessage =
      BacktrackDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(backtrackTo)(_.backtrackTo(_))
        .ifSome(force)(_.force(_))
        .ifSome(useEarliestTimeOnPointInTimeUnavailable)(_.useEarliestTimeOnPointInTimeUnavailable(_))
        .build

    def backupPolicyNotFoundFault(

    ): BackupPolicyNotFoundFault =
      BackupPolicyNotFoundFault
        .builder

        .build

    def cancelExportTaskMessage(
      exportTaskIdentifier: Option[String] = None
    ): CancelExportTaskMessage =
      CancelExportTaskMessage
        .builder
        .ifSome(exportTaskIdentifier)(_.exportTaskIdentifier(_))
        .build

    def certificate(
      certificateIdentifier: Option[String] = None,
      certificateType: Option[String] = None,
      thumbprint: Option[String] = None,
      validFrom: Option[TStamp] = None,
      validTill: Option[TStamp] = None,
      certificateArn: Option[String] = None,
      customerOverride: Option[Boolean] = None,
      customerOverrideValidTill: Option[TStamp] = None
    ): Certificate =
      Certificate
        .builder
        .ifSome(certificateIdentifier)(_.certificateIdentifier(_))
        .ifSome(certificateType)(_.certificateType(_))
        .ifSome(thumbprint)(_.thumbprint(_))
        .ifSome(validFrom)(_.validFrom(_))
        .ifSome(validTill)(_.validTill(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(customerOverride)(_.customerOverride(_))
        .ifSome(customerOverrideValidTill)(_.customerOverrideValidTill(_))
        .build

    def certificateMessage(
      certificates: Option[List[Certificate]] = None,
      marker: Option[String] = None
    ): CertificateMessage =
      CertificateMessage
        .builder
        .ifSome(certificates)(_.certificates(_))
        .ifSome(marker)(_.marker(_))
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

    def clusterPendingModifiedValues(
      pendingCloudwatchLogsExports: Option[PendingCloudwatchLogsExports] = None,
      dBClusterIdentifier: Option[String] = None,
      masterUserPassword: Option[String] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None,
      engineVersion: Option[String] = None
    ): ClusterPendingModifiedValues =
      ClusterPendingModifiedValues
        .builder
        .ifSome(pendingCloudwatchLogsExports)(_.pendingCloudwatchLogsExports(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .build

    def connectionPoolConfiguration(
      maxConnectionsPercent: Option[Int] = None,
      maxIdleConnectionsPercent: Option[Int] = None,
      connectionBorrowTimeout: Option[Int] = None,
      sessionPinningFilters: Option[List[String]] = None,
      initQuery: Option[String] = None
    ): ConnectionPoolConfiguration =
      ConnectionPoolConfiguration
        .builder
        .ifSome(maxConnectionsPercent)(_.maxConnectionsPercent(_))
        .ifSome(maxIdleConnectionsPercent)(_.maxIdleConnectionsPercent(_))
        .ifSome(connectionBorrowTimeout)(_.connectionBorrowTimeout(_))
        .ifSome(sessionPinningFilters)(_.sessionPinningFilters(_))
        .ifSome(initQuery)(_.initQuery(_))
        .build

    def connectionPoolConfigurationInfo(
      maxConnectionsPercent: Option[Int] = None,
      maxIdleConnectionsPercent: Option[Int] = None,
      connectionBorrowTimeout: Option[Int] = None,
      sessionPinningFilters: Option[List[String]] = None,
      initQuery: Option[String] = None
    ): ConnectionPoolConfigurationInfo =
      ConnectionPoolConfigurationInfo
        .builder
        .ifSome(maxConnectionsPercent)(_.maxConnectionsPercent(_))
        .ifSome(maxIdleConnectionsPercent)(_.maxIdleConnectionsPercent(_))
        .ifSome(connectionBorrowTimeout)(_.connectionBorrowTimeout(_))
        .ifSome(sessionPinningFilters)(_.sessionPinningFilters(_))
        .ifSome(initQuery)(_.initQuery(_))
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

    def copyDBSnapshotMessage(
      sourceDBSnapshotIdentifier: Option[String] = None,
      targetDBSnapshotIdentifier: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      copyTags: Option[Boolean] = None,
      preSignedUrl: Option[String] = None,
      optionGroupName: Option[String] = None,
      targetCustomAvailabilityZone: Option[String] = None
    ): CopyDBSnapshotMessage =
      CopyDBSnapshotMessage
        .builder
        .ifSome(sourceDBSnapshotIdentifier)(_.sourceDBSnapshotIdentifier(_))
        .ifSome(targetDBSnapshotIdentifier)(_.targetDBSnapshotIdentifier(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(copyTags)(_.copyTags(_))
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(targetCustomAvailabilityZone)(_.targetCustomAvailabilityZone(_))
        .build

    def copyOptionGroupMessage(
      sourceOptionGroupIdentifier: Option[String] = None,
      targetOptionGroupIdentifier: Option[String] = None,
      targetOptionGroupDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CopyOptionGroupMessage =
      CopyOptionGroupMessage
        .builder
        .ifSome(sourceOptionGroupIdentifier)(_.sourceOptionGroupIdentifier(_))
        .ifSome(targetOptionGroupIdentifier)(_.targetOptionGroupIdentifier(_))
        .ifSome(targetOptionGroupDescription)(_.targetOptionGroupDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCustomAvailabilityZoneMessage(
      customAvailabilityZoneName: Option[String] = None,
      existingVpnId: Option[String] = None,
      newVpnTunnelName: Option[String] = None,
      vpnTunnelOriginatorIP: Option[String] = None
    ): CreateCustomAvailabilityZoneMessage =
      CreateCustomAvailabilityZoneMessage
        .builder
        .ifSome(customAvailabilityZoneName)(_.customAvailabilityZoneName(_))
        .ifSome(existingVpnId)(_.existingVpnId(_))
        .ifSome(newVpnTunnelName)(_.newVpnTunnelName(_))
        .ifSome(vpnTunnelOriginatorIP)(_.vpnTunnelOriginatorIP(_))
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

    def createDBClusterMessage(
      availabilityZones: Option[List[String]] = None,
      backupRetentionPeriod: Option[Int] = None,
      characterSetName: Option[String] = None,
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
      backtrackWindow: Option[LongOptional] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      engineMode: Option[String] = None,
      scalingConfiguration: Option[ScalingConfiguration] = None,
      deletionProtection: Option[Boolean] = None,
      globalClusterIdentifier: Option[String] = None,
      enableHttpEndpoint: Option[Boolean] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      domain: Option[String] = None,
      domainIAMRoleName: Option[String] = None,
      enableGlobalWriteForwarding: Option[Boolean] = None
    ): CreateDBClusterMessage =
      CreateDBClusterMessage
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(characterSetName)(_.characterSetName(_))
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
        .ifSome(backtrackWindow)(_.backtrackWindow(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(engineMode)(_.engineMode(_))
        .ifSome(scalingConfiguration)(_.scalingConfiguration(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .ifSome(enableHttpEndpoint)(_.enableHttpEndpoint(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .ifSome(enableGlobalWriteForwarding)(_.enableGlobalWriteForwarding(_))
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
      ncharCharacterSetName: Option[String] = None,
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
      performanceInsightsRetentionPeriod: Option[Int] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      deletionProtection: Option[Boolean] = None,
      maxAllocatedStorage: Option[Int] = None,
      enableCustomerOwnedIp: Option[Boolean] = None
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
        .ifSome(ncharCharacterSetName)(_.ncharCharacterSetName(_))
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
        .ifSome(performanceInsightsRetentionPeriod)(_.performanceInsightsRetentionPeriod(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
        .ifSome(enableCustomerOwnedIp)(_.enableCustomerOwnedIp(_))
        .build

    def createDBInstanceReadReplicaMessage(
      dBInstanceIdentifier: Option[String] = None,
      sourceDBInstanceIdentifier: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      availabilityZone: Option[String] = None,
      port: Option[Int] = None,
      multiAZ: Option[Boolean] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      dBParameterGroupName: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      dBSubnetGroupName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      storageType: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      monitoringInterval: Option[Int] = None,
      monitoringRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      preSignedUrl: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enablePerformanceInsights: Option[Boolean] = None,
      performanceInsightsKMSKeyId: Option[String] = None,
      performanceInsightsRetentionPeriod: Option[Int] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      useDefaultProcessorFeatures: Option[Boolean] = None,
      deletionProtection: Option[Boolean] = None,
      domain: Option[String] = None,
      domainIAMRoleName: Option[String] = None,
      replicaMode: Option[String] = None,
      maxAllocatedStorage: Option[Int] = None
    ): CreateDBInstanceReadReplicaMessage =
      CreateDBInstanceReadReplicaMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(sourceDBInstanceIdentifier)(_.sourceDBInstanceIdentifier(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(port)(_.port(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(monitoringInterval)(_.monitoringInterval(_))
        .ifSome(monitoringRoleArn)(_.monitoringRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enablePerformanceInsights)(_.enablePerformanceInsights(_))
        .ifSome(performanceInsightsKMSKeyId)(_.performanceInsightsKMSKeyId(_))
        .ifSome(performanceInsightsRetentionPeriod)(_.performanceInsightsRetentionPeriod(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(useDefaultProcessorFeatures)(_.useDefaultProcessorFeatures(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .ifSome(replicaMode)(_.replicaMode(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
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

    def createDBProxyEndpointRequest(
      dBProxyName: Option[String] = None,
      dBProxyEndpointName: Option[String] = None,
      vpcSubnetIds: Option[List[String]] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      targetRole: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBProxyEndpointRequest =
      CreateDBProxyEndpointRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(dBProxyEndpointName)(_.dBProxyEndpointName(_))
        .ifSome(vpcSubnetIds)(_.vpcSubnetIds(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(targetRole)(_.targetRole(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBProxyEndpointResponse(
      dBProxyEndpoint: Option[DBProxyEndpoint] = None
    ): CreateDBProxyEndpointResponse =
      CreateDBProxyEndpointResponse
        .builder
        .ifSome(dBProxyEndpoint)(_.dBProxyEndpoint(_))
        .build

    def createDBProxyRequest(
      dBProxyName: Option[String] = None,
      engineFamily: Option[String] = None,
      auth: Option[List[UserAuthConfig]] = None,
      roleArn: Option[String] = None,
      vpcSubnetIds: Option[List[String]] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      requireTLS: Option[Boolean] = None,
      idleClientTimeout: Option[Int] = None,
      debugLogging: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBProxyRequest =
      CreateDBProxyRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(engineFamily)(_.engineFamily(_))
        .ifSome(auth)(_.auth(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(vpcSubnetIds)(_.vpcSubnetIds(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(requireTLS)(_.requireTLS(_))
        .ifSome(idleClientTimeout)(_.idleClientTimeout(_))
        .ifSome(debugLogging)(_.debugLogging(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBProxyResponse(
      dBProxy: Option[DBProxy] = None
    ): CreateDBProxyResponse =
      CreateDBProxyResponse
        .builder
        .ifSome(dBProxy)(_.dBProxy(_))
        .build

    def createDBSecurityGroupMessage(
      dBSecurityGroupName: Option[String] = None,
      dBSecurityGroupDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBSecurityGroupMessage =
      CreateDBSecurityGroupMessage
        .builder
        .ifSome(dBSecurityGroupName)(_.dBSecurityGroupName(_))
        .ifSome(dBSecurityGroupDescription)(_.dBSecurityGroupDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDBSnapshotMessage(
      dBSnapshotIdentifier: Option[String] = None,
      dBInstanceIdentifier: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDBSnapshotMessage =
      CreateDBSnapshotMessage
        .builder
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
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

    def createGlobalClusterMessage(
      globalClusterIdentifier: Option[String] = None,
      sourceDBClusterIdentifier: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      databaseName: Option[String] = None,
      storageEncrypted: Option[Boolean] = None
    ): CreateGlobalClusterMessage =
      CreateGlobalClusterMessage
        .builder
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .ifSome(sourceDBClusterIdentifier)(_.sourceDBClusterIdentifier(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .build

    def createOptionGroupMessage(
      optionGroupName: Option[String] = None,
      engineName: Option[String] = None,
      majorEngineVersion: Option[String] = None,
      optionGroupDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateOptionGroupMessage =
      CreateOptionGroupMessage
        .builder
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(engineName)(_.engineName(_))
        .ifSome(majorEngineVersion)(_.majorEngineVersion(_))
        .ifSome(optionGroupDescription)(_.optionGroupDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def customAvailabilityZone(
      customAvailabilityZoneId: Option[String] = None,
      customAvailabilityZoneName: Option[String] = None,
      customAvailabilityZoneStatus: Option[String] = None,
      vpnDetails: Option[VpnDetails] = None
    ): CustomAvailabilityZone =
      CustomAvailabilityZone
        .builder
        .ifSome(customAvailabilityZoneId)(_.customAvailabilityZoneId(_))
        .ifSome(customAvailabilityZoneName)(_.customAvailabilityZoneName(_))
        .ifSome(customAvailabilityZoneStatus)(_.customAvailabilityZoneStatus(_))
        .ifSome(vpnDetails)(_.vpnDetails(_))
        .build

    def customAvailabilityZoneAlreadyExistsFault(

    ): CustomAvailabilityZoneAlreadyExistsFault =
      CustomAvailabilityZoneAlreadyExistsFault
        .builder

        .build

    def customAvailabilityZoneMessage(
      marker: Option[String] = None,
      customAvailabilityZones: Option[List[CustomAvailabilityZone]] = None
    ): CustomAvailabilityZoneMessage =
      CustomAvailabilityZoneMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(customAvailabilityZones)(_.customAvailabilityZones(_))
        .build

    def customAvailabilityZoneNotFoundFault(

    ): CustomAvailabilityZoneNotFoundFault =
      CustomAvailabilityZoneNotFoundFault
        .builder

        .build

    def customAvailabilityZoneQuotaExceededFault(

    ): CustomAvailabilityZoneQuotaExceededFault =
      CustomAvailabilityZoneQuotaExceededFault
        .builder

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
      customEndpoints: Option[List[String]] = None,
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
      earliestBacktrackTime: Option[TStamp] = None,
      backtrackWindow: Option[LongOptional] = None,
      backtrackConsumedChangeRecords: Option[LongOptional] = None,
      enabledCloudwatchLogsExports: Option[List[String]] = None,
      capacity: Option[Int] = None,
      engineMode: Option[String] = None,
      scalingConfigurationInfo: Option[ScalingConfigurationInfo] = None,
      deletionProtection: Option[Boolean] = None,
      httpEndpointEnabled: Option[Boolean] = None,
      activityStreamMode: Option[String] = None,
      activityStreamStatus: Option[String] = None,
      activityStreamKmsKeyId: Option[String] = None,
      activityStreamKinesisStreamName: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      crossAccountClone: Option[Boolean] = None,
      domainMemberships: Option[List[DomainMembership]] = None,
      tagList: Option[List[Tag]] = None,
      globalWriteForwardingStatus: Option[String] = None,
      globalWriteForwardingRequested: Option[Boolean] = None,
      pendingModifiedValues: Option[ClusterPendingModifiedValues] = None
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
        .ifSome(customEndpoints)(_.customEndpoints(_))
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
        .ifSome(earliestBacktrackTime)(_.earliestBacktrackTime(_))
        .ifSome(backtrackWindow)(_.backtrackWindow(_))
        .ifSome(backtrackConsumedChangeRecords)(_.backtrackConsumedChangeRecords(_))
        .ifSome(enabledCloudwatchLogsExports)(_.enabledCloudwatchLogsExports(_))
        .ifSome(capacity)(_.capacity(_))
        .ifSome(engineMode)(_.engineMode(_))
        .ifSome(scalingConfigurationInfo)(_.scalingConfigurationInfo(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(httpEndpointEnabled)(_.httpEndpointEnabled(_))
        .ifSome(activityStreamMode)(_.activityStreamMode(_))
        .ifSome(activityStreamStatus)(_.activityStreamStatus(_))
        .ifSome(activityStreamKmsKeyId)(_.activityStreamKmsKeyId(_))
        .ifSome(activityStreamKinesisStreamName)(_.activityStreamKinesisStreamName(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(crossAccountClone)(_.crossAccountClone(_))
        .ifSome(domainMemberships)(_.domainMemberships(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(globalWriteForwardingStatus)(_.globalWriteForwardingStatus(_))
        .ifSome(globalWriteForwardingRequested)(_.globalWriteForwardingRequested(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .build

    def dBClusterAlreadyExistsFault(

    ): DBClusterAlreadyExistsFault =
      DBClusterAlreadyExistsFault
        .builder

        .build

    def dBClusterBacktrack(
      dBClusterIdentifier: Option[String] = None,
      backtrackIdentifier: Option[String] = None,
      backtrackTo: Option[TStamp] = None,
      backtrackedFrom: Option[TStamp] = None,
      backtrackRequestCreationTime: Option[TStamp] = None,
      status: Option[String] = None
    ): DBClusterBacktrack =
      DBClusterBacktrack
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(backtrackIdentifier)(_.backtrackIdentifier(_))
        .ifSome(backtrackTo)(_.backtrackTo(_))
        .ifSome(backtrackedFrom)(_.backtrackedFrom(_))
        .ifSome(backtrackRequestCreationTime)(_.backtrackRequestCreationTime(_))
        .ifSome(status)(_.status(_))
        .build

    def dBClusterBacktrackMessage(
      marker: Option[String] = None,
      dBClusterBacktracks: Option[List[DBClusterBacktrack]] = None
    ): DBClusterBacktrackMessage =
      DBClusterBacktrackMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBClusterBacktracks)(_.dBClusterBacktracks(_))
        .build

    def dBClusterBacktrackNotFoundFault(

    ): DBClusterBacktrackNotFoundFault =
      DBClusterBacktrackNotFoundFault
        .builder

        .build

    def dBClusterCapacityInfo(
      dBClusterIdentifier: Option[String] = None,
      pendingCapacity: Option[Int] = None,
      currentCapacity: Option[Int] = None,
      secondsBeforeTimeout: Option[Int] = None,
      timeoutAction: Option[String] = None
    ): DBClusterCapacityInfo =
      DBClusterCapacityInfo
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(pendingCapacity)(_.pendingCapacity(_))
        .ifSome(currentCapacity)(_.currentCapacity(_))
        .ifSome(secondsBeforeTimeout)(_.secondsBeforeTimeout(_))
        .ifSome(timeoutAction)(_.timeoutAction(_))
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
      engineMode: Option[String] = None,
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
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None,
      tagList: Option[List[Tag]] = None
    ): DBClusterSnapshot =
      DBClusterSnapshot
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(dBClusterSnapshotIdentifier)(_.dBClusterSnapshotIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(snapshotCreateTime)(_.snapshotCreateTime(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineMode)(_.engineMode(_))
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
        .ifSome(tagList)(_.tagList(_))
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
      supportedNcharCharacterSets: Option[List[CharacterSet]] = None,
      validUpgradeTarget: Option[List[UpgradeTarget]] = None,
      supportedTimezones: Option[List[Timezone]] = None,
      exportableLogTypes: Option[List[String]] = None,
      supportsLogExportsToCloudwatchLogs: Option[Boolean] = None,
      supportsReadReplica: Option[Boolean] = None,
      supportedEngineModes: Option[List[String]] = None,
      supportedFeatureNames: Option[List[String]] = None,
      status: Option[String] = None,
      supportsParallelQuery: Option[Boolean] = None,
      supportsGlobalDatabases: Option[Boolean] = None
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
        .ifSome(supportedNcharCharacterSets)(_.supportedNcharCharacterSets(_))
        .ifSome(validUpgradeTarget)(_.validUpgradeTarget(_))
        .ifSome(supportedTimezones)(_.supportedTimezones(_))
        .ifSome(exportableLogTypes)(_.exportableLogTypes(_))
        .ifSome(supportsLogExportsToCloudwatchLogs)(_.supportsLogExportsToCloudwatchLogs(_))
        .ifSome(supportsReadReplica)(_.supportsReadReplica(_))
        .ifSome(supportedEngineModes)(_.supportedEngineModes(_))
        .ifSome(supportedFeatureNames)(_.supportedFeatureNames(_))
        .ifSome(status)(_.status(_))
        .ifSome(supportsParallelQuery)(_.supportsParallelQuery(_))
        .ifSome(supportsGlobalDatabases)(_.supportsGlobalDatabases(_))
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
      replicaMode: Option[String] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupMemberships: Option[List[OptionGroupMembership]] = None,
      characterSetName: Option[String] = None,
      ncharCharacterSetName: Option[String] = None,
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
      performanceInsightsRetentionPeriod: Option[Int] = None,
      enabledCloudwatchLogsExports: Option[List[String]] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      deletionProtection: Option[Boolean] = None,
      associatedRoles: Option[List[DBInstanceRole]] = None,
      listenerEndpoint: Option[Endpoint] = None,
      maxAllocatedStorage: Option[Int] = None,
      tagList: Option[List[Tag]] = None,
      dBInstanceAutomatedBackupsReplications: Option[List[DBInstanceAutomatedBackupsReplication]] = None,
      customerOwnedIpEnabled: Option[Boolean] = None,
      awsBackupRecoveryPointArn: Option[String] = None
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
        .ifSome(replicaMode)(_.replicaMode(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupMemberships)(_.optionGroupMemberships(_))
        .ifSome(characterSetName)(_.characterSetName(_))
        .ifSome(ncharCharacterSetName)(_.ncharCharacterSetName(_))
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
        .ifSome(performanceInsightsRetentionPeriod)(_.performanceInsightsRetentionPeriod(_))
        .ifSome(enabledCloudwatchLogsExports)(_.enabledCloudwatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(associatedRoles)(_.associatedRoles(_))
        .ifSome(listenerEndpoint)(_.listenerEndpoint(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
        .ifSome(tagList)(_.tagList(_))
        .ifSome(dBInstanceAutomatedBackupsReplications)(_.dBInstanceAutomatedBackupsReplications(_))
        .ifSome(customerOwnedIpEnabled)(_.customerOwnedIpEnabled(_))
        .ifSome(awsBackupRecoveryPointArn)(_.awsBackupRecoveryPointArn(_))
        .build

    def dBInstanceAlreadyExistsFault(

    ): DBInstanceAlreadyExistsFault =
      DBInstanceAlreadyExistsFault
        .builder

        .build

    def dBInstanceAutomatedBackup(
      dBInstanceArn: Option[String] = None,
      dbiResourceId: Option[String] = None,
      region: Option[String] = None,
      dBInstanceIdentifier: Option[String] = None,
      restoreWindow: Option[RestoreWindow] = None,
      allocatedStorage: Option[Int] = None,
      status: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None,
      vpcId: Option[String] = None,
      instanceCreateTime: Option[TStamp] = None,
      masterUsername: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      encrypted: Option[Boolean] = None,
      storageType: Option[String] = None,
      kmsKeyId: Option[String] = None,
      timezone: Option[String] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None,
      backupRetentionPeriod: Option[Int] = None,
      dBInstanceAutomatedBackupsArn: Option[String] = None,
      dBInstanceAutomatedBackupsReplications: Option[List[DBInstanceAutomatedBackupsReplication]] = None
    ): DBInstanceAutomatedBackup =
      DBInstanceAutomatedBackup
        .builder
        .ifSome(dBInstanceArn)(_.dBInstanceArn(_))
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
        .ifSome(region)(_.region(_))
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(restoreWindow)(_.restoreWindow(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(status)(_.status(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(instanceCreateTime)(_.instanceCreateTime(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(dBInstanceAutomatedBackupsArn)(_.dBInstanceAutomatedBackupsArn(_))
        .ifSome(dBInstanceAutomatedBackupsReplications)(_.dBInstanceAutomatedBackupsReplications(_))
        .build

    def dBInstanceAutomatedBackupMessage(
      marker: Option[String] = None,
      dBInstanceAutomatedBackups: Option[List[DBInstanceAutomatedBackup]] = None
    ): DBInstanceAutomatedBackupMessage =
      DBInstanceAutomatedBackupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBInstanceAutomatedBackups)(_.dBInstanceAutomatedBackups(_))
        .build

    def dBInstanceAutomatedBackupNotFoundFault(

    ): DBInstanceAutomatedBackupNotFoundFault =
      DBInstanceAutomatedBackupNotFoundFault
        .builder

        .build

    def dBInstanceAutomatedBackupQuotaExceededFault(

    ): DBInstanceAutomatedBackupQuotaExceededFault =
      DBInstanceAutomatedBackupQuotaExceededFault
        .builder

        .build

    def dBInstanceAutomatedBackupsReplication(
      dBInstanceAutomatedBackupsArn: Option[String] = None
    ): DBInstanceAutomatedBackupsReplication =
      DBInstanceAutomatedBackupsReplication
        .builder
        .ifSome(dBInstanceAutomatedBackupsArn)(_.dBInstanceAutomatedBackupsArn(_))
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

    def dBInstanceRole(
      roleArn: Option[String] = None,
      featureName: Option[String] = None,
      status: Option[String] = None
    ): DBInstanceRole =
      DBInstanceRole
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(featureName)(_.featureName(_))
        .ifSome(status)(_.status(_))
        .build

    def dBInstanceRoleAlreadyExistsFault(

    ): DBInstanceRoleAlreadyExistsFault =
      DBInstanceRoleAlreadyExistsFault
        .builder

        .build

    def dBInstanceRoleNotFoundFault(

    ): DBInstanceRoleNotFoundFault =
      DBInstanceRoleNotFoundFault
        .builder

        .build

    def dBInstanceRoleQuotaExceededFault(

    ): DBInstanceRoleQuotaExceededFault =
      DBInstanceRoleQuotaExceededFault
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

    def dBLogFileNotFoundFault(

    ): DBLogFileNotFoundFault =
      DBLogFileNotFoundFault
        .builder

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

    def dBProxy(
      dBProxyName: Option[String] = None,
      dBProxyArn: Option[String] = None,
      status: Option[String] = None,
      engineFamily: Option[String] = None,
      vpcId: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      vpcSubnetIds: Option[List[String]] = None,
      auth: Option[List[UserAuthConfigInfo]] = None,
      roleArn: Option[String] = None,
      endpoint: Option[String] = None,
      requireTLS: Option[Boolean] = None,
      idleClientTimeout: Option[Int] = None,
      debugLogging: Option[Boolean] = None,
      createdDate: Option[TStamp] = None,
      updatedDate: Option[TStamp] = None
    ): DBProxy =
      DBProxy
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(dBProxyArn)(_.dBProxyArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(engineFamily)(_.engineFamily(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(vpcSubnetIds)(_.vpcSubnetIds(_))
        .ifSome(auth)(_.auth(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(requireTLS)(_.requireTLS(_))
        .ifSome(idleClientTimeout)(_.idleClientTimeout(_))
        .ifSome(debugLogging)(_.debugLogging(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(updatedDate)(_.updatedDate(_))
        .build

    def dBProxyAlreadyExistsFault(

    ): DBProxyAlreadyExistsFault =
      DBProxyAlreadyExistsFault
        .builder

        .build

    def dBProxyEndpoint(
      dBProxyEndpointName: Option[String] = None,
      dBProxyEndpointArn: Option[String] = None,
      dBProxyName: Option[String] = None,
      status: Option[String] = None,
      vpcId: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      vpcSubnetIds: Option[List[String]] = None,
      endpoint: Option[String] = None,
      createdDate: Option[TStamp] = None,
      targetRole: Option[String] = None,
      isDefault: Option[Boolean] = None
    ): DBProxyEndpoint =
      DBProxyEndpoint
        .builder
        .ifSome(dBProxyEndpointName)(_.dBProxyEndpointName(_))
        .ifSome(dBProxyEndpointArn)(_.dBProxyEndpointArn(_))
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(status)(_.status(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(vpcSubnetIds)(_.vpcSubnetIds(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(targetRole)(_.targetRole(_))
        .ifSome(isDefault)(_.isDefault(_))
        .build

    def dBProxyEndpointAlreadyExistsFault(

    ): DBProxyEndpointAlreadyExistsFault =
      DBProxyEndpointAlreadyExistsFault
        .builder

        .build

    def dBProxyEndpointNotFoundFault(

    ): DBProxyEndpointNotFoundFault =
      DBProxyEndpointNotFoundFault
        .builder

        .build

    def dBProxyEndpointQuotaExceededFault(

    ): DBProxyEndpointQuotaExceededFault =
      DBProxyEndpointQuotaExceededFault
        .builder

        .build

    def dBProxyNotFoundFault(

    ): DBProxyNotFoundFault =
      DBProxyNotFoundFault
        .builder

        .build

    def dBProxyQuotaExceededFault(

    ): DBProxyQuotaExceededFault =
      DBProxyQuotaExceededFault
        .builder

        .build

    def dBProxyTarget(
      targetArn: Option[String] = None,
      endpoint: Option[String] = None,
      trackedClusterId: Option[String] = None,
      rdsResourceId: Option[String] = None,
      port: Option[Int] = None,
      `type`: Option[String] = None,
      role: Option[String] = None,
      targetHealth: Option[TargetHealth] = None
    ): DBProxyTarget =
      DBProxyTarget
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(trackedClusterId)(_.trackedClusterId(_))
        .ifSome(rdsResourceId)(_.rdsResourceId(_))
        .ifSome(port)(_.port(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(role)(_.role(_))
        .ifSome(targetHealth)(_.targetHealth(_))
        .build

    def dBProxyTargetAlreadyRegisteredFault(

    ): DBProxyTargetAlreadyRegisteredFault =
      DBProxyTargetAlreadyRegisteredFault
        .builder

        .build

    def dBProxyTargetGroup(
      dBProxyName: Option[String] = None,
      targetGroupName: Option[String] = None,
      targetGroupArn: Option[String] = None,
      isDefault: Option[Boolean] = None,
      status: Option[String] = None,
      connectionPoolConfig: Option[ConnectionPoolConfigurationInfo] = None,
      createdDate: Option[TStamp] = None,
      updatedDate: Option[TStamp] = None
    ): DBProxyTargetGroup =
      DBProxyTargetGroup
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(targetGroupName)(_.targetGroupName(_))
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(isDefault)(_.isDefault(_))
        .ifSome(status)(_.status(_))
        .ifSome(connectionPoolConfig)(_.connectionPoolConfig(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(updatedDate)(_.updatedDate(_))
        .build

    def dBProxyTargetGroupNotFoundFault(

    ): DBProxyTargetGroupNotFoundFault =
      DBProxyTargetGroupNotFoundFault
        .builder

        .build

    def dBProxyTargetNotFoundFault(

    ): DBProxyTargetNotFoundFault =
      DBProxyTargetNotFoundFault
        .builder

        .build

    def dBSecurityGroup(
      ownerId: Option[String] = None,
      dBSecurityGroupName: Option[String] = None,
      dBSecurityGroupDescription: Option[String] = None,
      vpcId: Option[String] = None,
      eC2SecurityGroups: Option[List[EC2SecurityGroup]] = None,
      iPRanges: Option[List[IPRange]] = None,
      dBSecurityGroupArn: Option[String] = None
    ): DBSecurityGroup =
      DBSecurityGroup
        .builder
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(dBSecurityGroupName)(_.dBSecurityGroupName(_))
        .ifSome(dBSecurityGroupDescription)(_.dBSecurityGroupDescription(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(eC2SecurityGroups)(_.eC2SecurityGroups(_))
        .ifSome(iPRanges)(_.iPRanges(_))
        .ifSome(dBSecurityGroupArn)(_.dBSecurityGroupArn(_))
        .build

    def dBSecurityGroupAlreadyExistsFault(

    ): DBSecurityGroupAlreadyExistsFault =
      DBSecurityGroupAlreadyExistsFault
        .builder

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

    def dBSecurityGroupMessage(
      marker: Option[String] = None,
      dBSecurityGroups: Option[List[DBSecurityGroup]] = None
    ): DBSecurityGroupMessage =
      DBSecurityGroupMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBSecurityGroups)(_.dBSecurityGroups(_))
        .build

    def dBSecurityGroupNotFoundFault(

    ): DBSecurityGroupNotFoundFault =
      DBSecurityGroupNotFoundFault
        .builder

        .build

    def dBSecurityGroupNotSupportedFault(

    ): DBSecurityGroupNotSupportedFault =
      DBSecurityGroupNotSupportedFault
        .builder

        .build

    def dBSecurityGroupQuotaExceededFault(

    ): DBSecurityGroupQuotaExceededFault =
      DBSecurityGroupQuotaExceededFault
        .builder

        .build

    def dBSnapshot(
      dBSnapshotIdentifier: Option[String] = None,
      dBInstanceIdentifier: Option[String] = None,
      snapshotCreateTime: Option[TStamp] = None,
      engine: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      status: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None,
      vpcId: Option[String] = None,
      instanceCreateTime: Option[TStamp] = None,
      masterUsername: Option[String] = None,
      engineVersion: Option[String] = None,
      licenseModel: Option[String] = None,
      snapshotType: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      percentProgress: Option[Int] = None,
      sourceRegion: Option[String] = None,
      sourceDBSnapshotIdentifier: Option[String] = None,
      storageType: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      dBSnapshotArn: Option[String] = None,
      timezone: Option[String] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      dbiResourceId: Option[String] = None,
      tagList: Option[List[Tag]] = None
    ): DBSnapshot =
      DBSnapshot
        .builder
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(snapshotCreateTime)(_.snapshotCreateTime(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(status)(_.status(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(instanceCreateTime)(_.instanceCreateTime(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(percentProgress)(_.percentProgress(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(sourceDBSnapshotIdentifier)(_.sourceDBSnapshotIdentifier(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dBSnapshotArn)(_.dBSnapshotArn(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def dBSnapshotAlreadyExistsFault(

    ): DBSnapshotAlreadyExistsFault =
      DBSnapshotAlreadyExistsFault
        .builder

        .build

    def dBSnapshotAttribute(
      attributeName: Option[String] = None,
      attributeValues: Option[List[String]] = None
    ): DBSnapshotAttribute =
      DBSnapshotAttribute
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValues)(_.attributeValues(_))
        .build

    def dBSnapshotMessage(
      marker: Option[String] = None,
      dBSnapshots: Option[List[DBSnapshot]] = None
    ): DBSnapshotMessage =
      DBSnapshotMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(dBSnapshots)(_.dBSnapshots(_))
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

    def dBSubnetGroupNotAllowedFault(

    ): DBSubnetGroupNotAllowedFault =
      DBSubnetGroupNotAllowedFault
        .builder

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

    def deleteCustomAvailabilityZoneMessage(
      customAvailabilityZoneId: Option[String] = None
    ): DeleteCustomAvailabilityZoneMessage =
      DeleteCustomAvailabilityZoneMessage
        .builder
        .ifSome(customAvailabilityZoneId)(_.customAvailabilityZoneId(_))
        .build

    def deleteDBClusterEndpointMessage(
      dBClusterEndpointIdentifier: Option[String] = None
    ): DeleteDBClusterEndpointMessage =
      DeleteDBClusterEndpointMessage
        .builder
        .ifSome(dBClusterEndpointIdentifier)(_.dBClusterEndpointIdentifier(_))
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

    def deleteDBInstanceAutomatedBackupMessage(
      dbiResourceId: Option[String] = None,
      dBInstanceAutomatedBackupsArn: Option[String] = None
    ): DeleteDBInstanceAutomatedBackupMessage =
      DeleteDBInstanceAutomatedBackupMessage
        .builder
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
        .ifSome(dBInstanceAutomatedBackupsArn)(_.dBInstanceAutomatedBackupsArn(_))
        .build

    def deleteDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None,
      skipFinalSnapshot: Option[Boolean] = None,
      finalDBSnapshotIdentifier: Option[String] = None,
      deleteAutomatedBackups: Option[Boolean] = None
    ): DeleteDBInstanceMessage =
      DeleteDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(skipFinalSnapshot)(_.skipFinalSnapshot(_))
        .ifSome(finalDBSnapshotIdentifier)(_.finalDBSnapshotIdentifier(_))
        .ifSome(deleteAutomatedBackups)(_.deleteAutomatedBackups(_))
        .build

    def deleteDBParameterGroupMessage(
      dBParameterGroupName: Option[String] = None
    ): DeleteDBParameterGroupMessage =
      DeleteDBParameterGroupMessage
        .builder
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .build

    def deleteDBProxyEndpointRequest(
      dBProxyEndpointName: Option[String] = None
    ): DeleteDBProxyEndpointRequest =
      DeleteDBProxyEndpointRequest
        .builder
        .ifSome(dBProxyEndpointName)(_.dBProxyEndpointName(_))
        .build

    def deleteDBProxyEndpointResponse(
      dBProxyEndpoint: Option[DBProxyEndpoint] = None
    ): DeleteDBProxyEndpointResponse =
      DeleteDBProxyEndpointResponse
        .builder
        .ifSome(dBProxyEndpoint)(_.dBProxyEndpoint(_))
        .build

    def deleteDBProxyRequest(
      dBProxyName: Option[String] = None
    ): DeleteDBProxyRequest =
      DeleteDBProxyRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .build

    def deleteDBProxyResponse(
      dBProxy: Option[DBProxy] = None
    ): DeleteDBProxyResponse =
      DeleteDBProxyResponse
        .builder
        .ifSome(dBProxy)(_.dBProxy(_))
        .build

    def deleteDBSecurityGroupMessage(
      dBSecurityGroupName: Option[String] = None
    ): DeleteDBSecurityGroupMessage =
      DeleteDBSecurityGroupMessage
        .builder
        .ifSome(dBSecurityGroupName)(_.dBSecurityGroupName(_))
        .build

    def deleteDBSnapshotMessage(
      dBSnapshotIdentifier: Option[String] = None
    ): DeleteDBSnapshotMessage =
      DeleteDBSnapshotMessage
        .builder
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
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

    def deleteGlobalClusterMessage(
      globalClusterIdentifier: Option[String] = None
    ): DeleteGlobalClusterMessage =
      DeleteGlobalClusterMessage
        .builder
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .build

    def deleteInstallationMediaMessage(
      installationMediaId: Option[String] = None
    ): DeleteInstallationMediaMessage =
      DeleteInstallationMediaMessage
        .builder
        .ifSome(installationMediaId)(_.installationMediaId(_))
        .build

    def deleteOptionGroupMessage(
      optionGroupName: Option[String] = None
    ): DeleteOptionGroupMessage =
      DeleteOptionGroupMessage
        .builder
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .build

    def deregisterDBProxyTargetsRequest(
      dBProxyName: Option[String] = None,
      targetGroupName: Option[String] = None,
      dBInstanceIdentifiers: Option[List[String]] = None,
      dBClusterIdentifiers: Option[List[String]] = None
    ): DeregisterDBProxyTargetsRequest =
      DeregisterDBProxyTargetsRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(targetGroupName)(_.targetGroupName(_))
        .ifSome(dBInstanceIdentifiers)(_.dBInstanceIdentifiers(_))
        .ifSome(dBClusterIdentifiers)(_.dBClusterIdentifiers(_))
        .build

    def deregisterDBProxyTargetsResponse(

    ): DeregisterDBProxyTargetsResponse =
      DeregisterDBProxyTargetsResponse
        .builder

        .build

    def describeAccountAttributesMessage(

    ): DescribeAccountAttributesMessage =
      DescribeAccountAttributesMessage
        .builder

        .build

    def describeCertificatesMessage(
      certificateIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCertificatesMessage =
      DescribeCertificatesMessage
        .builder
        .ifSome(certificateIdentifier)(_.certificateIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCustomAvailabilityZonesMessage(
      customAvailabilityZoneId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCustomAvailabilityZonesMessage =
      DescribeCustomAvailabilityZonesMessage
        .builder
        .ifSome(customAvailabilityZoneId)(_.customAvailabilityZoneId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBClusterBacktracksMessage(
      dBClusterIdentifier: Option[String] = None,
      backtrackIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBClusterBacktracksMessage =
      DescribeDBClusterBacktracksMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(backtrackIdentifier)(_.backtrackIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
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
      marker: Option[String] = None,
      includeShared: Option[Boolean] = None
    ): DescribeDBClustersMessage =
      DescribeDBClustersMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(includeShared)(_.includeShared(_))
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
      listSupportedTimezones: Option[Boolean] = None,
      includeAll: Option[Boolean] = None
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
        .ifSome(includeAll)(_.includeAll(_))
        .build

    def describeDBInstanceAutomatedBackupsMessage(
      dbiResourceId: Option[String] = None,
      dBInstanceIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      dBInstanceAutomatedBackupsArn: Option[String] = None
    ): DescribeDBInstanceAutomatedBackupsMessage =
      DescribeDBInstanceAutomatedBackupsMessage
        .builder
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(dBInstanceAutomatedBackupsArn)(_.dBInstanceAutomatedBackupsArn(_))
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

    def describeDBLogFilesDetails(
      logFileName: Option[String] = None,
      lastWritten: Option[Long] = None,
      size: Option[Long] = None
    ): DescribeDBLogFilesDetails =
      DescribeDBLogFilesDetails
        .builder
        .ifSome(logFileName)(_.logFileName(_))
        .ifSome(lastWritten)(_.lastWritten(_))
        .ifSome(size)(_.size(_))
        .build

    def describeDBLogFilesMessage(
      dBInstanceIdentifier: Option[String] = None,
      filenameContains: Option[String] = None,
      fileLastWritten: Option[Long] = None,
      fileSize: Option[Long] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBLogFilesMessage =
      DescribeDBLogFilesMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(filenameContains)(_.filenameContains(_))
        .ifSome(fileLastWritten)(_.fileLastWritten(_))
        .ifSome(fileSize)(_.fileSize(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBLogFilesResponse(
      describeDBLogFiles: Option[List[DescribeDBLogFilesDetails]] = None,
      marker: Option[String] = None
    ): DescribeDBLogFilesResponse =
      DescribeDBLogFilesResponse
        .builder
        .ifSome(describeDBLogFiles)(_.describeDBLogFiles(_))
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

    def describeDBProxiesRequest(
      dBProxyName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeDBProxiesRequest =
      DescribeDBProxiesRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeDBProxiesResponse(
      dBProxies: Option[List[DBProxy]] = None,
      marker: Option[String] = None
    ): DescribeDBProxiesResponse =
      DescribeDBProxiesResponse
        .builder
        .ifSome(dBProxies)(_.dBProxies(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBProxyEndpointsRequest(
      dBProxyName: Option[String] = None,
      dBProxyEndpointName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeDBProxyEndpointsRequest =
      DescribeDBProxyEndpointsRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(dBProxyEndpointName)(_.dBProxyEndpointName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeDBProxyEndpointsResponse(
      dBProxyEndpoints: Option[List[DBProxyEndpoint]] = None,
      marker: Option[String] = None
    ): DescribeDBProxyEndpointsResponse =
      DescribeDBProxyEndpointsResponse
        .builder
        .ifSome(dBProxyEndpoints)(_.dBProxyEndpoints(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBProxyTargetGroupsRequest(
      dBProxyName: Option[String] = None,
      targetGroupName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeDBProxyTargetGroupsRequest =
      DescribeDBProxyTargetGroupsRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(targetGroupName)(_.targetGroupName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeDBProxyTargetGroupsResponse(
      targetGroups: Option[List[DBProxyTargetGroup]] = None,
      marker: Option[String] = None
    ): DescribeDBProxyTargetGroupsResponse =
      DescribeDBProxyTargetGroupsResponse
        .builder
        .ifSome(targetGroups)(_.targetGroups(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBProxyTargetsRequest(
      dBProxyName: Option[String] = None,
      targetGroupName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeDBProxyTargetsRequest =
      DescribeDBProxyTargetsRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(targetGroupName)(_.targetGroupName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeDBProxyTargetsResponse(
      targets: Option[List[DBProxyTarget]] = None,
      marker: Option[String] = None
    ): DescribeDBProxyTargetsResponse =
      DescribeDBProxyTargetsResponse
        .builder
        .ifSome(targets)(_.targets(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBSecurityGroupsMessage(
      dBSecurityGroupName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeDBSecurityGroupsMessage =
      DescribeDBSecurityGroupsMessage
        .builder
        .ifSome(dBSecurityGroupName)(_.dBSecurityGroupName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDBSnapshotAttributesMessage(
      dBSnapshotIdentifier: Option[String] = None
    ): DescribeDBSnapshotAttributesMessage =
      DescribeDBSnapshotAttributesMessage
        .builder
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
        .build

    def describeDBSnapshotsMessage(
      dBInstanceIdentifier: Option[String] = None,
      dBSnapshotIdentifier: Option[String] = None,
      snapshotType: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      includeShared: Option[Boolean] = None,
      includePublic: Option[Boolean] = None,
      dbiResourceId: Option[String] = None
    ): DescribeDBSnapshotsMessage =
      DescribeDBSnapshotsMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(includeShared)(_.includeShared(_))
        .ifSome(includePublic)(_.includePublic(_))
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
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

    def describeExportTasksMessage(
      exportTaskIdentifier: Option[String] = None,
      sourceArn: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribeExportTasksMessage =
      DescribeExportTasksMessage
        .builder
        .ifSome(exportTaskIdentifier)(_.exportTaskIdentifier(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describeGlobalClustersMessage(
      globalClusterIdentifier: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeGlobalClustersMessage =
      DescribeGlobalClustersMessage
        .builder
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeInstallationMediaMessage(
      installationMediaId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeInstallationMediaMessage =
      DescribeInstallationMediaMessage
        .builder
        .ifSome(installationMediaId)(_.installationMediaId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeOptionGroupOptionsMessage(
      engineName: Option[String] = None,
      majorEngineVersion: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeOptionGroupOptionsMessage =
      DescribeOptionGroupOptionsMessage
        .builder
        .ifSome(engineName)(_.engineName(_))
        .ifSome(majorEngineVersion)(_.majorEngineVersion(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeOptionGroupsMessage(
      optionGroupName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None,
      engineName: Option[String] = None,
      majorEngineVersion: Option[String] = None
    ): DescribeOptionGroupsMessage =
      DescribeOptionGroupsMessage
        .builder
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(engineName)(_.engineName(_))
        .ifSome(majorEngineVersion)(_.majorEngineVersion(_))
        .build

    def describeOrderableDBInstanceOptionsMessage(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      licenseModel: Option[String] = None,
      availabilityZoneGroup: Option[String] = None,
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
        .ifSome(availabilityZoneGroup)(_.availabilityZoneGroup(_))
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

    def describeReservedDBInstancesMessage(
      reservedDBInstanceId: Option[String] = None,
      reservedDBInstancesOfferingId: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      duration: Option[String] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      leaseId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReservedDBInstancesMessage =
      DescribeReservedDBInstancesMessage
        .builder
        .ifSome(reservedDBInstanceId)(_.reservedDBInstanceId(_))
        .ifSome(reservedDBInstancesOfferingId)(_.reservedDBInstancesOfferingId(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(leaseId)(_.leaseId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReservedDBInstancesOfferingsMessage(
      reservedDBInstancesOfferingId: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      duration: Option[String] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReservedDBInstancesOfferingsMessage =
      DescribeReservedDBInstancesOfferingsMessage
        .builder
        .ifSome(reservedDBInstancesOfferingId)(_.reservedDBInstancesOfferingId(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeSourceRegionsMessage(
      regionName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeSourceRegionsMessage =
      DescribeSourceRegionsMessage
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(filters)(_.filters(_))
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

    def downloadDBLogFilePortionDetails(
      logFileData: Option[String] = None,
      marker: Option[String] = None,
      additionalDataPending: Option[Boolean] = None
    ): DownloadDBLogFilePortionDetails =
      DownloadDBLogFilePortionDetails
        .builder
        .ifSome(logFileData)(_.logFileData(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(additionalDataPending)(_.additionalDataPending(_))
        .build

    def downloadDBLogFilePortionMessage(
      dBInstanceIdentifier: Option[String] = None,
      logFileName: Option[String] = None,
      marker: Option[String] = None,
      numberOfLines: Option[Int] = None
    ): DownloadDBLogFilePortionMessage =
      DownloadDBLogFilePortionMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(logFileName)(_.logFileName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(numberOfLines)(_.numberOfLines(_))
        .build

    def eC2SecurityGroup(
      status: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupId: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): EC2SecurityGroup =
      EC2SecurityGroup
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupId)(_.eC2SecurityGroupId(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
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

    def exportTask(
      exportTaskIdentifier: Option[String] = None,
      sourceArn: Option[String] = None,
      exportOnly: Option[List[String]] = None,
      snapshotTime: Option[TStamp] = None,
      taskStartTime: Option[TStamp] = None,
      taskEndTime: Option[TStamp] = None,
      s3Bucket: Option[String] = None,
      s3Prefix: Option[String] = None,
      iamRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      status: Option[String] = None,
      percentProgress: Option[Int] = None,
      totalExtractedDataInGB: Option[Int] = None,
      failureCause: Option[String] = None,
      warningMessage: Option[String] = None
    ): ExportTask =
      ExportTask
        .builder
        .ifSome(exportTaskIdentifier)(_.exportTaskIdentifier(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(exportOnly)(_.exportOnly(_))
        .ifSome(snapshotTime)(_.snapshotTime(_))
        .ifSome(taskStartTime)(_.taskStartTime(_))
        .ifSome(taskEndTime)(_.taskEndTime(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(status)(_.status(_))
        .ifSome(percentProgress)(_.percentProgress(_))
        .ifSome(totalExtractedDataInGB)(_.totalExtractedDataInGB(_))
        .ifSome(failureCause)(_.failureCause(_))
        .ifSome(warningMessage)(_.warningMessage(_))
        .build

    def exportTaskAlreadyExistsFault(

    ): ExportTaskAlreadyExistsFault =
      ExportTaskAlreadyExistsFault
        .builder

        .build

    def exportTaskNotFoundFault(

    ): ExportTaskNotFoundFault =
      ExportTaskNotFoundFault
        .builder

        .build

    def exportTasksMessage(
      marker: Option[String] = None,
      exportTasks: Option[List[ExportTask]] = None
    ): ExportTasksMessage =
      ExportTasksMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(exportTasks)(_.exportTasks(_))
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

    def failoverGlobalClusterMessage(
      globalClusterIdentifier: Option[String] = None,
      targetDbClusterIdentifier: Option[String] = None
    ): FailoverGlobalClusterMessage =
      FailoverGlobalClusterMessage
        .builder
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .ifSome(targetDbClusterIdentifier)(_.targetDbClusterIdentifier(_))
        .build

    def failoverState(
      status: Option[String] = None,
      fromDbClusterArn: Option[String] = None,
      toDbClusterArn: Option[String] = None
    ): FailoverState =
      FailoverState
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(fromDbClusterArn)(_.fromDbClusterArn(_))
        .ifSome(toDbClusterArn)(_.toDbClusterArn(_))
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

    def globalCluster(
      globalClusterIdentifier: Option[String] = None,
      globalClusterResourceId: Option[String] = None,
      globalClusterArn: Option[String] = None,
      status: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      databaseName: Option[String] = None,
      storageEncrypted: Option[Boolean] = None,
      deletionProtection: Option[Boolean] = None,
      globalClusterMembers: Option[List[GlobalClusterMember]] = None,
      failoverState: Option[FailoverState] = None
    ): GlobalCluster =
      GlobalCluster
        .builder
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .ifSome(globalClusterResourceId)(_.globalClusterResourceId(_))
        .ifSome(globalClusterArn)(_.globalClusterArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(globalClusterMembers)(_.globalClusterMembers(_))
        .ifSome(failoverState)(_.failoverState(_))
        .build

    def globalClusterAlreadyExistsFault(

    ): GlobalClusterAlreadyExistsFault =
      GlobalClusterAlreadyExistsFault
        .builder

        .build

    def globalClusterMember(
      dBClusterArn: Option[String] = None,
      readers: Option[List[String]] = None,
      isWriter: Option[Boolean] = None,
      globalWriteForwardingStatus: Option[String] = None
    ): GlobalClusterMember =
      GlobalClusterMember
        .builder
        .ifSome(dBClusterArn)(_.dBClusterArn(_))
        .ifSome(readers)(_.readers(_))
        .ifSome(isWriter)(_.isWriter(_))
        .ifSome(globalWriteForwardingStatus)(_.globalWriteForwardingStatus(_))
        .build

    def globalClusterNotFoundFault(

    ): GlobalClusterNotFoundFault =
      GlobalClusterNotFoundFault
        .builder

        .build

    def globalClusterQuotaExceededFault(

    ): GlobalClusterQuotaExceededFault =
      GlobalClusterQuotaExceededFault
        .builder

        .build

    def globalClustersMessage(
      marker: Option[String] = None,
      globalClusters: Option[List[GlobalCluster]] = None
    ): GlobalClustersMessage =
      GlobalClustersMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(globalClusters)(_.globalClusters(_))
        .build

    def iPRange(
      status: Option[String] = None,
      cIDRIP: Option[String] = None
    ): IPRange =
      IPRange
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(cIDRIP)(_.cIDRIP(_))
        .build

    def iamRoleMissingPermissionsFault(

    ): IamRoleMissingPermissionsFault =
      IamRoleMissingPermissionsFault
        .builder

        .build

    def iamRoleNotFoundFault(

    ): IamRoleNotFoundFault =
      IamRoleNotFoundFault
        .builder

        .build

    def importInstallationMediaMessage(
      customAvailabilityZoneId: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      engineInstallationMediaPath: Option[String] = None,
      oSInstallationMediaPath: Option[String] = None
    ): ImportInstallationMediaMessage =
      ImportInstallationMediaMessage
        .builder
        .ifSome(customAvailabilityZoneId)(_.customAvailabilityZoneId(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(engineInstallationMediaPath)(_.engineInstallationMediaPath(_))
        .ifSome(oSInstallationMediaPath)(_.oSInstallationMediaPath(_))
        .build

    def installationMedia(
      installationMediaId: Option[String] = None,
      customAvailabilityZoneId: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      engineInstallationMediaPath: Option[String] = None,
      oSInstallationMediaPath: Option[String] = None,
      status: Option[String] = None,
      failureCause: Option[InstallationMediaFailureCause] = None
    ): InstallationMedia =
      InstallationMedia
        .builder
        .ifSome(installationMediaId)(_.installationMediaId(_))
        .ifSome(customAvailabilityZoneId)(_.customAvailabilityZoneId(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(engineInstallationMediaPath)(_.engineInstallationMediaPath(_))
        .ifSome(oSInstallationMediaPath)(_.oSInstallationMediaPath(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureCause)(_.failureCause(_))
        .build

    def installationMediaAlreadyExistsFault(

    ): InstallationMediaAlreadyExistsFault =
      InstallationMediaAlreadyExistsFault
        .builder

        .build

    def installationMediaFailureCause(
      message: Option[String] = None
    ): InstallationMediaFailureCause =
      InstallationMediaFailureCause
        .builder
        .ifSome(message)(_.message(_))
        .build

    def installationMediaMessage(
      marker: Option[String] = None,
      installationMedia: Option[List[InstallationMedia]] = None
    ): InstallationMediaMessage =
      InstallationMediaMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(installationMedia)(_.installationMedia(_))
        .build

    def installationMediaNotFoundFault(

    ): InstallationMediaNotFoundFault =
      InstallationMediaNotFoundFault
        .builder

        .build

    def instanceQuotaExceededFault(

    ): InstanceQuotaExceededFault =
      InstanceQuotaExceededFault
        .builder

        .build

    def insufficientAvailableIPsInSubnetFault(

    ): InsufficientAvailableIPsInSubnetFault =
      InsufficientAvailableIPsInSubnetFault
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

    def invalidDBClusterCapacityFault(

    ): InvalidDBClusterCapacityFault =
      InvalidDBClusterCapacityFault
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

    def invalidDBInstanceAutomatedBackupStateFault(

    ): InvalidDBInstanceAutomatedBackupStateFault =
      InvalidDBInstanceAutomatedBackupStateFault
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

    def invalidDBProxyEndpointStateFault(

    ): InvalidDBProxyEndpointStateFault =
      InvalidDBProxyEndpointStateFault
        .builder

        .build

    def invalidDBProxyStateFault(

    ): InvalidDBProxyStateFault =
      InvalidDBProxyStateFault
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

    def invalidDBSubnetGroupFault(

    ): InvalidDBSubnetGroupFault =
      InvalidDBSubnetGroupFault
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

    def invalidExportOnlyFault(

    ): InvalidExportOnlyFault =
      InvalidExportOnlyFault
        .builder

        .build

    def invalidExportSourceStateFault(

    ): InvalidExportSourceStateFault =
      InvalidExportSourceStateFault
        .builder

        .build

    def invalidExportTaskStateFault(

    ): InvalidExportTaskStateFault =
      InvalidExportTaskStateFault
        .builder

        .build

    def invalidGlobalClusterStateFault(

    ): InvalidGlobalClusterStateFault =
      InvalidGlobalClusterStateFault
        .builder

        .build

    def invalidOptionGroupStateFault(

    ): InvalidOptionGroupStateFault =
      InvalidOptionGroupStateFault
        .builder

        .build

    def invalidRestoreFault(

    ): InvalidRestoreFault =
      InvalidRestoreFault
        .builder

        .build

    def invalidS3BucketFault(

    ): InvalidS3BucketFault =
      InvalidS3BucketFault
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

    def minimumEngineVersionPerAllowedValue(
      allowedValue: Option[String] = None,
      minimumEngineVersion: Option[String] = None
    ): MinimumEngineVersionPerAllowedValue =
      MinimumEngineVersionPerAllowedValue
        .builder
        .ifSome(allowedValue)(_.allowedValue(_))
        .ifSome(minimumEngineVersion)(_.minimumEngineVersion(_))
        .build

    def modifyCertificatesMessage(
      certificateIdentifier: Option[String] = None,
      removeCustomerOverride: Option[Boolean] = None
    ): ModifyCertificatesMessage =
      ModifyCertificatesMessage
        .builder
        .ifSome(certificateIdentifier)(_.certificateIdentifier(_))
        .ifSome(removeCustomerOverride)(_.removeCustomerOverride(_))
        .build

    def modifyCurrentDBClusterCapacityMessage(
      dBClusterIdentifier: Option[String] = None,
      capacity: Option[Int] = None,
      secondsBeforeTimeout: Option[Int] = None,
      timeoutAction: Option[String] = None
    ): ModifyCurrentDBClusterCapacityMessage =
      ModifyCurrentDBClusterCapacityMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(capacity)(_.capacity(_))
        .ifSome(secondsBeforeTimeout)(_.secondsBeforeTimeout(_))
        .ifSome(timeoutAction)(_.timeoutAction(_))
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
      backtrackWindow: Option[LongOptional] = None,
      cloudwatchLogsExportConfiguration: Option[CloudwatchLogsExportConfiguration] = None,
      engineVersion: Option[String] = None,
      allowMajorVersionUpgrade: Option[Boolean] = None,
      dBInstanceParameterGroupName: Option[String] = None,
      domain: Option[String] = None,
      domainIAMRoleName: Option[String] = None,
      scalingConfiguration: Option[ScalingConfiguration] = None,
      deletionProtection: Option[Boolean] = None,
      enableHttpEndpoint: Option[Boolean] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      enableGlobalWriteForwarding: Option[Boolean] = None
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
        .ifSome(backtrackWindow)(_.backtrackWindow(_))
        .ifSome(cloudwatchLogsExportConfiguration)(_.cloudwatchLogsExportConfiguration(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(allowMajorVersionUpgrade)(_.allowMajorVersionUpgrade(_))
        .ifSome(dBInstanceParameterGroupName)(_.dBInstanceParameterGroupName(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .ifSome(scalingConfiguration)(_.scalingConfiguration(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(enableHttpEndpoint)(_.enableHttpEndpoint(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(enableGlobalWriteForwarding)(_.enableGlobalWriteForwarding(_))
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
      performanceInsightsRetentionPeriod: Option[Int] = None,
      cloudwatchLogsExportConfiguration: Option[CloudwatchLogsExportConfiguration] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      useDefaultProcessorFeatures: Option[Boolean] = None,
      deletionProtection: Option[Boolean] = None,
      maxAllocatedStorage: Option[Int] = None,
      certificateRotationRestart: Option[Boolean] = None,
      replicaMode: Option[String] = None,
      enableCustomerOwnedIp: Option[Boolean] = None,
      awsBackupRecoveryPointArn: Option[String] = None
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
        .ifSome(performanceInsightsRetentionPeriod)(_.performanceInsightsRetentionPeriod(_))
        .ifSome(cloudwatchLogsExportConfiguration)(_.cloudwatchLogsExportConfiguration(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(useDefaultProcessorFeatures)(_.useDefaultProcessorFeatures(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
        .ifSome(certificateRotationRestart)(_.certificateRotationRestart(_))
        .ifSome(replicaMode)(_.replicaMode(_))
        .ifSome(enableCustomerOwnedIp)(_.enableCustomerOwnedIp(_))
        .ifSome(awsBackupRecoveryPointArn)(_.awsBackupRecoveryPointArn(_))
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

    def modifyDBProxyEndpointRequest(
      dBProxyEndpointName: Option[String] = None,
      newDBProxyEndpointName: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None
    ): ModifyDBProxyEndpointRequest =
      ModifyDBProxyEndpointRequest
        .builder
        .ifSome(dBProxyEndpointName)(_.dBProxyEndpointName(_))
        .ifSome(newDBProxyEndpointName)(_.newDBProxyEndpointName(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .build

    def modifyDBProxyEndpointResponse(
      dBProxyEndpoint: Option[DBProxyEndpoint] = None
    ): ModifyDBProxyEndpointResponse =
      ModifyDBProxyEndpointResponse
        .builder
        .ifSome(dBProxyEndpoint)(_.dBProxyEndpoint(_))
        .build

    def modifyDBProxyRequest(
      dBProxyName: Option[String] = None,
      newDBProxyName: Option[String] = None,
      auth: Option[List[UserAuthConfig]] = None,
      requireTLS: Option[Boolean] = None,
      idleClientTimeout: Option[Int] = None,
      debugLogging: Option[Boolean] = None,
      roleArn: Option[String] = None,
      securityGroups: Option[List[String]] = None
    ): ModifyDBProxyRequest =
      ModifyDBProxyRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(newDBProxyName)(_.newDBProxyName(_))
        .ifSome(auth)(_.auth(_))
        .ifSome(requireTLS)(_.requireTLS(_))
        .ifSome(idleClientTimeout)(_.idleClientTimeout(_))
        .ifSome(debugLogging)(_.debugLogging(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def modifyDBProxyResponse(
      dBProxy: Option[DBProxy] = None
    ): ModifyDBProxyResponse =
      ModifyDBProxyResponse
        .builder
        .ifSome(dBProxy)(_.dBProxy(_))
        .build

    def modifyDBProxyTargetGroupRequest(
      targetGroupName: Option[String] = None,
      dBProxyName: Option[String] = None,
      connectionPoolConfig: Option[ConnectionPoolConfiguration] = None,
      newName: Option[String] = None
    ): ModifyDBProxyTargetGroupRequest =
      ModifyDBProxyTargetGroupRequest
        .builder
        .ifSome(targetGroupName)(_.targetGroupName(_))
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(connectionPoolConfig)(_.connectionPoolConfig(_))
        .ifSome(newName)(_.newName(_))
        .build

    def modifyDBProxyTargetGroupResponse(
      dBProxyTargetGroup: Option[DBProxyTargetGroup] = None
    ): ModifyDBProxyTargetGroupResponse =
      ModifyDBProxyTargetGroupResponse
        .builder
        .ifSome(dBProxyTargetGroup)(_.dBProxyTargetGroup(_))
        .build

    def modifyDBSnapshotAttributeMessage(
      dBSnapshotIdentifier: Option[String] = None,
      attributeName: Option[String] = None,
      valuesToAdd: Option[List[String]] = None,
      valuesToRemove: Option[List[String]] = None
    ): ModifyDBSnapshotAttributeMessage =
      ModifyDBSnapshotAttributeMessage
        .builder
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(valuesToAdd)(_.valuesToAdd(_))
        .ifSome(valuesToRemove)(_.valuesToRemove(_))
        .build

    def modifyDBSnapshotMessage(
      dBSnapshotIdentifier: Option[String] = None,
      engineVersion: Option[String] = None,
      optionGroupName: Option[String] = None
    ): ModifyDBSnapshotMessage =
      ModifyDBSnapshotMessage
        .builder
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
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

    def modifyGlobalClusterMessage(
      globalClusterIdentifier: Option[String] = None,
      newGlobalClusterIdentifier: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      allowMajorVersionUpgrade: Option[Boolean] = None
    ): ModifyGlobalClusterMessage =
      ModifyGlobalClusterMessage
        .builder
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .ifSome(newGlobalClusterIdentifier)(_.newGlobalClusterIdentifier(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(allowMajorVersionUpgrade)(_.allowMajorVersionUpgrade(_))
        .build

    def modifyOptionGroupMessage(
      optionGroupName: Option[String] = None,
      optionsToInclude: Option[List[OptionConfiguration]] = None,
      optionsToRemove: Option[List[String]] = None,
      applyImmediately: Option[Boolean] = None
    ): ModifyOptionGroupMessage =
      ModifyOptionGroupMessage
        .builder
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(optionsToInclude)(_.optionsToInclude(_))
        .ifSome(optionsToRemove)(_.optionsToRemove(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def option(
      optionName: Option[String] = None,
      optionDescription: Option[String] = None,
      persistent: Option[Boolean] = None,
      permanent: Option[Boolean] = None,
      port: Option[Int] = None,
      optionVersion: Option[String] = None,
      optionSettings: Option[List[OptionSetting]] = None,
      dBSecurityGroupMemberships: Option[List[DBSecurityGroupMembership]] = None,
      vpcSecurityGroupMemberships: Option[List[VpcSecurityGroupMembership]] = None
    ): Option =
      Option
        .builder
        .ifSome(optionName)(_.optionName(_))
        .ifSome(optionDescription)(_.optionDescription(_))
        .ifSome(persistent)(_.persistent(_))
        .ifSome(permanent)(_.permanent(_))
        .ifSome(port)(_.port(_))
        .ifSome(optionVersion)(_.optionVersion(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .ifSome(dBSecurityGroupMemberships)(_.dBSecurityGroupMemberships(_))
        .ifSome(vpcSecurityGroupMemberships)(_.vpcSecurityGroupMemberships(_))
        .build

    def optionConfiguration(
      optionName: Option[String] = None,
      port: Option[Int] = None,
      optionVersion: Option[String] = None,
      dBSecurityGroupMemberships: Option[List[String]] = None,
      vpcSecurityGroupMemberships: Option[List[String]] = None,
      optionSettings: Option[List[OptionSetting]] = None
    ): OptionConfiguration =
      OptionConfiguration
        .builder
        .ifSome(optionName)(_.optionName(_))
        .ifSome(port)(_.port(_))
        .ifSome(optionVersion)(_.optionVersion(_))
        .ifSome(dBSecurityGroupMemberships)(_.dBSecurityGroupMemberships(_))
        .ifSome(vpcSecurityGroupMemberships)(_.vpcSecurityGroupMemberships(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .build

    def optionGroup(
      optionGroupName: Option[String] = None,
      optionGroupDescription: Option[String] = None,
      engineName: Option[String] = None,
      majorEngineVersion: Option[String] = None,
      options: Option[List[Option]] = None,
      allowsVpcAndNonVpcInstanceMemberships: Option[Boolean] = None,
      vpcId: Option[String] = None,
      optionGroupArn: Option[String] = None
    ): OptionGroup =
      OptionGroup
        .builder
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(optionGroupDescription)(_.optionGroupDescription(_))
        .ifSome(engineName)(_.engineName(_))
        .ifSome(majorEngineVersion)(_.majorEngineVersion(_))
        .ifSome(options)(_.options(_))
        .ifSome(allowsVpcAndNonVpcInstanceMemberships)(_.allowsVpcAndNonVpcInstanceMemberships(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(optionGroupArn)(_.optionGroupArn(_))
        .build

    def optionGroupAlreadyExistsFault(

    ): OptionGroupAlreadyExistsFault =
      OptionGroupAlreadyExistsFault
        .builder

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

    def optionGroupOption(
      name: Option[String] = None,
      description: Option[String] = None,
      engineName: Option[String] = None,
      majorEngineVersion: Option[String] = None,
      minimumRequiredMinorEngineVersion: Option[String] = None,
      portRequired: Option[Boolean] = None,
      defaultPort: Option[Int] = None,
      optionsDependedOn: Option[List[String]] = None,
      optionsConflictsWith: Option[List[String]] = None,
      persistent: Option[Boolean] = None,
      permanent: Option[Boolean] = None,
      requiresAutoMinorEngineVersionUpgrade: Option[Boolean] = None,
      vpcOnly: Option[Boolean] = None,
      supportsOptionVersionDowngrade: Option[Boolean] = None,
      optionGroupOptionSettings: Option[List[OptionGroupOptionSetting]] = None,
      optionGroupOptionVersions: Option[List[OptionVersion]] = None
    ): OptionGroupOption =
      OptionGroupOption
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(engineName)(_.engineName(_))
        .ifSome(majorEngineVersion)(_.majorEngineVersion(_))
        .ifSome(minimumRequiredMinorEngineVersion)(_.minimumRequiredMinorEngineVersion(_))
        .ifSome(portRequired)(_.portRequired(_))
        .ifSome(defaultPort)(_.defaultPort(_))
        .ifSome(optionsDependedOn)(_.optionsDependedOn(_))
        .ifSome(optionsConflictsWith)(_.optionsConflictsWith(_))
        .ifSome(persistent)(_.persistent(_))
        .ifSome(permanent)(_.permanent(_))
        .ifSome(requiresAutoMinorEngineVersionUpgrade)(_.requiresAutoMinorEngineVersionUpgrade(_))
        .ifSome(vpcOnly)(_.vpcOnly(_))
        .ifSome(supportsOptionVersionDowngrade)(_.supportsOptionVersionDowngrade(_))
        .ifSome(optionGroupOptionSettings)(_.optionGroupOptionSettings(_))
        .ifSome(optionGroupOptionVersions)(_.optionGroupOptionVersions(_))
        .build

    def optionGroupOptionSetting(
      settingName: Option[String] = None,
      settingDescription: Option[String] = None,
      defaultValue: Option[String] = None,
      applyType: Option[String] = None,
      allowedValues: Option[String] = None,
      isModifiable: Option[Boolean] = None,
      isRequired: Option[Boolean] = None,
      minimumEngineVersionPerAllowedValue: Option[List[MinimumEngineVersionPerAllowedValue]] = None
    ): OptionGroupOptionSetting =
      OptionGroupOptionSetting
        .builder
        .ifSome(settingName)(_.settingName(_))
        .ifSome(settingDescription)(_.settingDescription(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(applyType)(_.applyType(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(isRequired)(_.isRequired(_))
        .ifSome(minimumEngineVersionPerAllowedValue)(_.minimumEngineVersionPerAllowedValue(_))
        .build

    def optionGroupOptionsMessage(
      optionGroupOptions: Option[List[OptionGroupOption]] = None,
      marker: Option[String] = None
    ): OptionGroupOptionsMessage =
      OptionGroupOptionsMessage
        .builder
        .ifSome(optionGroupOptions)(_.optionGroupOptions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def optionGroupQuotaExceededFault(

    ): OptionGroupQuotaExceededFault =
      OptionGroupQuotaExceededFault
        .builder

        .build

    def optionGroups(
      optionGroupsList: Option[List[OptionGroup]] = None,
      marker: Option[String] = None
    ): OptionGroups =
      OptionGroups
        .builder
        .ifSome(optionGroupsList)(_.optionGroupsList(_))
        .ifSome(marker)(_.marker(_))
        .build

    def optionSetting(
      name: Option[String] = None,
      value: Option[String] = None,
      defaultValue: Option[String] = None,
      description: Option[String] = None,
      applyType: Option[String] = None,
      dataType: Option[String] = None,
      allowedValues: Option[String] = None,
      isModifiable: Option[Boolean] = None,
      isCollection: Option[Boolean] = None
    ): OptionSetting =
      OptionSetting
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(applyType)(_.applyType(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(isCollection)(_.isCollection(_))
        .build

    def optionVersion(
      version: Option[String] = None,
      isDefault: Option[Boolean] = None
    ): OptionVersion =
      OptionVersion
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(isDefault)(_.isDefault(_))
        .build

    def orderableDBInstanceOption(
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      licenseModel: Option[String] = None,
      availabilityZoneGroup: Option[String] = None,
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
      maxIopsPerGib: Option[DoubleOptional] = None,
      availableProcessorFeatures: Option[List[AvailableProcessorFeature]] = None,
      supportedEngineModes: Option[List[String]] = None,
      supportsStorageAutoscaling: Option[Boolean] = None,
      supportsKerberosAuthentication: Option[Boolean] = None,
      outpostCapable: Option[Boolean] = None,
      supportsGlobalDatabases: Option[Boolean] = None
    ): OrderableDBInstanceOption =
      OrderableDBInstanceOption
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(availabilityZoneGroup)(_.availabilityZoneGroup(_))
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
        .ifSome(availableProcessorFeatures)(_.availableProcessorFeatures(_))
        .ifSome(supportedEngineModes)(_.supportedEngineModes(_))
        .ifSome(supportsStorageAutoscaling)(_.supportsStorageAutoscaling(_))
        .ifSome(supportsKerberosAuthentication)(_.supportsKerberosAuthentication(_))
        .ifSome(outpostCapable)(_.outpostCapable(_))
        .ifSome(supportsGlobalDatabases)(_.supportsGlobalDatabases(_))
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

    def outpost(
      arn: Option[String] = None
    ): Outpost =
      Outpost
        .builder
        .ifSome(arn)(_.arn(_))
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
      applyMethod: Option[String] = None,
      supportedEngineModes: Option[List[String]] = None
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
        .ifSome(supportedEngineModes)(_.supportedEngineModes(_))
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
      pendingCloudwatchLogsExports: Option[PendingCloudwatchLogsExports] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None
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
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .build

    def pointInTimeRestoreNotEnabledFault(

    ): PointInTimeRestoreNotEnabledFault =
      PointInTimeRestoreNotEnabledFault
        .builder

        .build

    def processorFeature(
      name: Option[String] = None,
      value: Option[String] = None
    ): ProcessorFeature =
      ProcessorFeature
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def promoteReadReplicaDBClusterMessage(
      dBClusterIdentifier: Option[String] = None
    ): PromoteReadReplicaDBClusterMessage =
      PromoteReadReplicaDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .build

    def promoteReadReplicaMessage(
      dBInstanceIdentifier: Option[String] = None,
      backupRetentionPeriod: Option[Int] = None,
      preferredBackupWindow: Option[String] = None
    ): PromoteReadReplicaMessage =
      PromoteReadReplicaMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .build

    def provisionedIopsNotAvailableInAZFault(

    ): ProvisionedIopsNotAvailableInAZFault =
      ProvisionedIopsNotAvailableInAZFault
        .builder

        .build

    def purchaseReservedDBInstancesOfferingMessage(
      reservedDBInstancesOfferingId: Option[String] = None,
      reservedDBInstanceId: Option[String] = None,
      dBInstanceCount: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): PurchaseReservedDBInstancesOfferingMessage =
      PurchaseReservedDBInstancesOfferingMessage
        .builder
        .ifSome(reservedDBInstancesOfferingId)(_.reservedDBInstancesOfferingId(_))
        .ifSome(reservedDBInstanceId)(_.reservedDBInstanceId(_))
        .ifSome(dBInstanceCount)(_.dBInstanceCount(_))
        .ifSome(tags)(_.tags(_))
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

    def recurringCharge(
      recurringChargeAmount: Option[Double] = None,
      recurringChargeFrequency: Option[String] = None
    ): RecurringCharge =
      RecurringCharge
        .builder
        .ifSome(recurringChargeAmount)(_.recurringChargeAmount(_))
        .ifSome(recurringChargeFrequency)(_.recurringChargeFrequency(_))
        .build

    def registerDBProxyTargetsRequest(
      dBProxyName: Option[String] = None,
      targetGroupName: Option[String] = None,
      dBInstanceIdentifiers: Option[List[String]] = None,
      dBClusterIdentifiers: Option[List[String]] = None
    ): RegisterDBProxyTargetsRequest =
      RegisterDBProxyTargetsRequest
        .builder
        .ifSome(dBProxyName)(_.dBProxyName(_))
        .ifSome(targetGroupName)(_.targetGroupName(_))
        .ifSome(dBInstanceIdentifiers)(_.dBInstanceIdentifiers(_))
        .ifSome(dBClusterIdentifiers)(_.dBClusterIdentifiers(_))
        .build

    def registerDBProxyTargetsResponse(
      dBProxyTargets: Option[List[DBProxyTarget]] = None
    ): RegisterDBProxyTargetsResponse =
      RegisterDBProxyTargetsResponse
        .builder
        .ifSome(dBProxyTargets)(_.dBProxyTargets(_))
        .build

    def removeFromGlobalClusterMessage(
      globalClusterIdentifier: Option[String] = None,
      dbClusterIdentifier: Option[String] = None
    ): RemoveFromGlobalClusterMessage =
      RemoveFromGlobalClusterMessage
        .builder
        .ifSome(globalClusterIdentifier)(_.globalClusterIdentifier(_))
        .ifSome(dbClusterIdentifier)(_.dbClusterIdentifier(_))
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

    def removeRoleFromDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None,
      roleArn: Option[String] = None,
      featureName: Option[String] = None
    ): RemoveRoleFromDBInstanceMessage =
      RemoveRoleFromDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
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

    def reservedDBInstance(
      reservedDBInstanceId: Option[String] = None,
      reservedDBInstancesOfferingId: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      startTime: Option[TStamp] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      currencyCode: Option[String] = None,
      dBInstanceCount: Option[Int] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      state: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None,
      reservedDBInstanceArn: Option[String] = None,
      leaseId: Option[String] = None
    ): ReservedDBInstance =
      ReservedDBInstance
        .builder
        .ifSome(reservedDBInstanceId)(_.reservedDBInstanceId(_))
        .ifSome(reservedDBInstancesOfferingId)(_.reservedDBInstancesOfferingId(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(dBInstanceCount)(_.dBInstanceCount(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(state)(_.state(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .ifSome(reservedDBInstanceArn)(_.reservedDBInstanceArn(_))
        .ifSome(leaseId)(_.leaseId(_))
        .build

    def reservedDBInstanceAlreadyExistsFault(

    ): ReservedDBInstanceAlreadyExistsFault =
      ReservedDBInstanceAlreadyExistsFault
        .builder

        .build

    def reservedDBInstanceMessage(
      marker: Option[String] = None,
      reservedDBInstances: Option[List[ReservedDBInstance]] = None
    ): ReservedDBInstanceMessage =
      ReservedDBInstanceMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(reservedDBInstances)(_.reservedDBInstances(_))
        .build

    def reservedDBInstanceNotFoundFault(

    ): ReservedDBInstanceNotFoundFault =
      ReservedDBInstanceNotFoundFault
        .builder

        .build

    def reservedDBInstanceQuotaExceededFault(

    ): ReservedDBInstanceQuotaExceededFault =
      ReservedDBInstanceQuotaExceededFault
        .builder

        .build

    def reservedDBInstancesOffering(
      reservedDBInstancesOfferingId: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      currencyCode: Option[String] = None,
      productDescription: Option[String] = None,
      offeringType: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      recurringCharges: Option[List[RecurringCharge]] = None
    ): ReservedDBInstancesOffering =
      ReservedDBInstancesOffering
        .builder
        .ifSome(reservedDBInstancesOfferingId)(_.reservedDBInstancesOfferingId(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .build

    def reservedDBInstancesOfferingMessage(
      marker: Option[String] = None,
      reservedDBInstancesOfferings: Option[List[ReservedDBInstancesOffering]] = None
    ): ReservedDBInstancesOfferingMessage =
      ReservedDBInstancesOfferingMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(reservedDBInstancesOfferings)(_.reservedDBInstancesOfferings(_))
        .build

    def reservedDBInstancesOfferingNotFoundFault(

    ): ReservedDBInstancesOfferingNotFoundFault =
      ReservedDBInstancesOfferingNotFoundFault
        .builder

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

    def restoreDBClusterFromS3Message(
      availabilityZones: Option[List[String]] = None,
      backupRetentionPeriod: Option[Int] = None,
      characterSetName: Option[String] = None,
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
      tags: Option[List[Tag]] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      sourceEngine: Option[String] = None,
      sourceEngineVersion: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3Prefix: Option[String] = None,
      s3IngestionRoleArn: Option[String] = None,
      backtrackWindow: Option[LongOptional] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      deletionProtection: Option[Boolean] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      domain: Option[String] = None,
      domainIAMRoleName: Option[String] = None
    ): RestoreDBClusterFromS3Message =
      RestoreDBClusterFromS3Message
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(characterSetName)(_.characterSetName(_))
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
        .ifSome(tags)(_.tags(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(sourceEngine)(_.sourceEngine(_))
        .ifSome(sourceEngineVersion)(_.sourceEngineVersion(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(s3IngestionRoleArn)(_.s3IngestionRoleArn(_))
        .ifSome(backtrackWindow)(_.backtrackWindow(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
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
      backtrackWindow: Option[LongOptional] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      engineMode: Option[String] = None,
      scalingConfiguration: Option[ScalingConfiguration] = None,
      dBClusterParameterGroupName: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      domain: Option[String] = None,
      domainIAMRoleName: Option[String] = None
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
        .ifSome(backtrackWindow)(_.backtrackWindow(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(engineMode)(_.engineMode(_))
        .ifSome(scalingConfiguration)(_.scalingConfiguration(_))
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
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
      backtrackWindow: Option[LongOptional] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      dBClusterParameterGroupName: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      domain: Option[String] = None,
      domainIAMRoleName: Option[String] = None
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
        .ifSome(backtrackWindow)(_.backtrackWindow(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(dBClusterParameterGroupName)(_.dBClusterParameterGroupName(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .build

    def restoreDBInstanceFromDBSnapshotMessage(
      dBInstanceIdentifier: Option[String] = None,
      dBSnapshotIdentifier: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None,
      dBSubnetGroupName: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      publiclyAccessible: Option[Boolean] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      licenseModel: Option[String] = None,
      dBName: Option[String] = None,
      engine: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      storageType: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      tdeCredentialPassword: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      domain: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      domainIAMRoleName: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      useDefaultProcessorFeatures: Option[Boolean] = None,
      dBParameterGroupName: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      enableCustomerOwnedIp: Option[Boolean] = None
    ): RestoreDBInstanceFromDBSnapshotMessage =
      RestoreDBInstanceFromDBSnapshotMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(dBName)(_.dBName(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(tdeCredentialPassword)(_.tdeCredentialPassword(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(useDefaultProcessorFeatures)(_.useDefaultProcessorFeatures(_))
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(enableCustomerOwnedIp)(_.enableCustomerOwnedIp(_))
        .build

    def restoreDBInstanceFromS3Message(
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
      publiclyAccessible: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      storageType: Option[String] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      monitoringInterval: Option[Int] = None,
      monitoringRoleArn: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      sourceEngine: Option[String] = None,
      sourceEngineVersion: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3Prefix: Option[String] = None,
      s3IngestionRoleArn: Option[String] = None,
      enablePerformanceInsights: Option[Boolean] = None,
      performanceInsightsKMSKeyId: Option[String] = None,
      performanceInsightsRetentionPeriod: Option[Int] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      useDefaultProcessorFeatures: Option[Boolean] = None,
      deletionProtection: Option[Boolean] = None,
      maxAllocatedStorage: Option[Int] = None
    ): RestoreDBInstanceFromS3Message =
      RestoreDBInstanceFromS3Message
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
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(monitoringInterval)(_.monitoringInterval(_))
        .ifSome(monitoringRoleArn)(_.monitoringRoleArn(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(sourceEngine)(_.sourceEngine(_))
        .ifSome(sourceEngineVersion)(_.sourceEngineVersion(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(s3IngestionRoleArn)(_.s3IngestionRoleArn(_))
        .ifSome(enablePerformanceInsights)(_.enablePerformanceInsights(_))
        .ifSome(performanceInsightsKMSKeyId)(_.performanceInsightsKMSKeyId(_))
        .ifSome(performanceInsightsRetentionPeriod)(_.performanceInsightsRetentionPeriod(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(useDefaultProcessorFeatures)(_.useDefaultProcessorFeatures(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
        .build

    def restoreDBInstanceToPointInTimeMessage(
      sourceDBInstanceIdentifier: Option[String] = None,
      targetDBInstanceIdentifier: Option[String] = None,
      restoreTime: Option[TStamp] = None,
      useLatestRestorableTime: Option[Boolean] = None,
      dBInstanceClass: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None,
      dBSubnetGroupName: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      publiclyAccessible: Option[Boolean] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      licenseModel: Option[String] = None,
      dBName: Option[String] = None,
      engine: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      storageType: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      tdeCredentialPassword: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      domain: Option[String] = None,
      domainIAMRoleName: Option[String] = None,
      enableIAMDatabaseAuthentication: Option[Boolean] = None,
      enableCloudwatchLogsExports: Option[List[String]] = None,
      processorFeatures: Option[List[ProcessorFeature]] = None,
      useDefaultProcessorFeatures: Option[Boolean] = None,
      dBParameterGroupName: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      sourceDbiResourceId: Option[String] = None,
      maxAllocatedStorage: Option[Int] = None,
      sourceDBInstanceAutomatedBackupsArn: Option[String] = None,
      enableCustomerOwnedIp: Option[Boolean] = None
    ): RestoreDBInstanceToPointInTimeMessage =
      RestoreDBInstanceToPointInTimeMessage
        .builder
        .ifSome(sourceDBInstanceIdentifier)(_.sourceDBInstanceIdentifier(_))
        .ifSome(targetDBInstanceIdentifier)(_.targetDBInstanceIdentifier(_))
        .ifSome(restoreTime)(_.restoreTime(_))
        .ifSome(useLatestRestorableTime)(_.useLatestRestorableTime(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(dBSubnetGroupName)(_.dBSubnetGroupName(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(dBName)(_.dBName(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(tdeCredentialPassword)(_.tdeCredentialPassword(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(domainIAMRoleName)(_.domainIAMRoleName(_))
        .ifSome(enableIAMDatabaseAuthentication)(_.enableIAMDatabaseAuthentication(_))
        .ifSome(enableCloudwatchLogsExports)(_.enableCloudwatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(useDefaultProcessorFeatures)(_.useDefaultProcessorFeatures(_))
        .ifSome(dBParameterGroupName)(_.dBParameterGroupName(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(sourceDbiResourceId)(_.sourceDbiResourceId(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
        .ifSome(sourceDBInstanceAutomatedBackupsArn)(_.sourceDBInstanceAutomatedBackupsArn(_))
        .ifSome(enableCustomerOwnedIp)(_.enableCustomerOwnedIp(_))
        .build

    def restoreWindow(
      earliestTime: Option[TStamp] = None,
      latestTime: Option[TStamp] = None
    ): RestoreWindow =
      RestoreWindow
        .builder
        .ifSome(earliestTime)(_.earliestTime(_))
        .ifSome(latestTime)(_.latestTime(_))
        .build

    def revokeDBSecurityGroupIngressMessage(
      dBSecurityGroupName: Option[String] = None,
      cIDRIP: Option[String] = None,
      eC2SecurityGroupName: Option[String] = None,
      eC2SecurityGroupId: Option[String] = None,
      eC2SecurityGroupOwnerId: Option[String] = None
    ): RevokeDBSecurityGroupIngressMessage =
      RevokeDBSecurityGroupIngressMessage
        .builder
        .ifSome(dBSecurityGroupName)(_.dBSecurityGroupName(_))
        .ifSome(cIDRIP)(_.cIDRIP(_))
        .ifSome(eC2SecurityGroupName)(_.eC2SecurityGroupName(_))
        .ifSome(eC2SecurityGroupId)(_.eC2SecurityGroupId(_))
        .ifSome(eC2SecurityGroupOwnerId)(_.eC2SecurityGroupOwnerId(_))
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

    def scalingConfiguration(
      minCapacity: Option[Int] = None,
      maxCapacity: Option[Int] = None,
      autoPause: Option[Boolean] = None,
      secondsUntilAutoPause: Option[Int] = None,
      timeoutAction: Option[String] = None
    ): ScalingConfiguration =
      ScalingConfiguration
        .builder
        .ifSome(minCapacity)(_.minCapacity(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(autoPause)(_.autoPause(_))
        .ifSome(secondsUntilAutoPause)(_.secondsUntilAutoPause(_))
        .ifSome(timeoutAction)(_.timeoutAction(_))
        .build

    def scalingConfigurationInfo(
      minCapacity: Option[Int] = None,
      maxCapacity: Option[Int] = None,
      autoPause: Option[Boolean] = None,
      secondsUntilAutoPause: Option[Int] = None,
      timeoutAction: Option[String] = None
    ): ScalingConfigurationInfo =
      ScalingConfigurationInfo
        .builder
        .ifSome(minCapacity)(_.minCapacity(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(autoPause)(_.autoPause(_))
        .ifSome(secondsUntilAutoPause)(_.secondsUntilAutoPause(_))
        .ifSome(timeoutAction)(_.timeoutAction(_))
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

    def sourceRegion(
      regionName: Option[String] = None,
      endpoint: Option[String] = None,
      status: Option[String] = None,
      supportsDBInstanceAutomatedBackupsReplication: Option[Boolean] = None
    ): SourceRegion =
      SourceRegion
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(status)(_.status(_))
        .ifSome(supportsDBInstanceAutomatedBackupsReplication)(_.supportsDBInstanceAutomatedBackupsReplication(_))
        .build

    def sourceRegionMessage(
      marker: Option[String] = None,
      sourceRegions: Option[List[SourceRegion]] = None
    ): SourceRegionMessage =
      SourceRegionMessage
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(sourceRegions)(_.sourceRegions(_))
        .build

    def startActivityStreamRequest(
      resourceArn: Option[String] = None,
      mode: Option[String] = None,
      kmsKeyId: Option[String] = None,
      applyImmediately: Option[Boolean] = None
    ): StartActivityStreamRequest =
      StartActivityStreamRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def startActivityStreamResponse(
      kmsKeyId: Option[String] = None,
      kinesisStreamName: Option[String] = None,
      status: Option[String] = None,
      mode: Option[String] = None,
      applyImmediately: Option[Boolean] = None
    ): StartActivityStreamResponse =
      StartActivityStreamResponse
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(kinesisStreamName)(_.kinesisStreamName(_))
        .ifSome(status)(_.status(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def startDBClusterMessage(
      dBClusterIdentifier: Option[String] = None
    ): StartDBClusterMessage =
      StartDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .build

    def startDBInstanceAutomatedBackupsReplicationMessage(
      sourceDBInstanceArn: Option[String] = None,
      backupRetentionPeriod: Option[Int] = None,
      kmsKeyId: Option[String] = None,
      preSignedUrl: Option[String] = None
    ): StartDBInstanceAutomatedBackupsReplicationMessage =
      StartDBInstanceAutomatedBackupsReplicationMessage
        .builder
        .ifSome(sourceDBInstanceArn)(_.sourceDBInstanceArn(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .build

    def startDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None
    ): StartDBInstanceMessage =
      StartDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .build

    def startExportTaskMessage(
      exportTaskIdentifier: Option[String] = None,
      sourceArn: Option[String] = None,
      s3BucketName: Option[String] = None,
      iamRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      s3Prefix: Option[String] = None,
      exportOnly: Option[List[String]] = None
    ): StartExportTaskMessage =
      StartExportTaskMessage
        .builder
        .ifSome(exportTaskIdentifier)(_.exportTaskIdentifier(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(exportOnly)(_.exportOnly(_))
        .build

    def stopActivityStreamRequest(
      resourceArn: Option[String] = None,
      applyImmediately: Option[Boolean] = None
    ): StopActivityStreamRequest =
      StopActivityStreamRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .build

    def stopActivityStreamResponse(
      kmsKeyId: Option[String] = None,
      kinesisStreamName: Option[String] = None,
      status: Option[String] = None
    ): StopActivityStreamResponse =
      StopActivityStreamResponse
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(kinesisStreamName)(_.kinesisStreamName(_))
        .ifSome(status)(_.status(_))
        .build

    def stopDBClusterMessage(
      dBClusterIdentifier: Option[String] = None
    ): StopDBClusterMessage =
      StopDBClusterMessage
        .builder
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .build

    def stopDBInstanceAutomatedBackupsReplicationMessage(
      sourceDBInstanceArn: Option[String] = None
    ): StopDBInstanceAutomatedBackupsReplicationMessage =
      StopDBInstanceAutomatedBackupsReplicationMessage
        .builder
        .ifSome(sourceDBInstanceArn)(_.sourceDBInstanceArn(_))
        .build

    def stopDBInstanceMessage(
      dBInstanceIdentifier: Option[String] = None,
      dBSnapshotIdentifier: Option[String] = None
    ): StopDBInstanceMessage =
      StopDBInstanceMessage
        .builder
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(dBSnapshotIdentifier)(_.dBSnapshotIdentifier(_))
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
      subnetOutpost: Option[Outpost] = None,
      subnetStatus: Option[String] = None
    ): Subnet =
      Subnet
        .builder
        .ifSome(subnetIdentifier)(_.subnetIdentifier(_))
        .ifSome(subnetAvailabilityZone)(_.subnetAvailabilityZone(_))
        .ifSome(subnetOutpost)(_.subnetOutpost(_))
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

    def targetHealth(
      state: Option[String] = None,
      reason: Option[String] = None,
      description: Option[String] = None
    ): TargetHealth =
      TargetHealth
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(description)(_.description(_))
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
      isMajorVersionUpgrade: Option[Boolean] = None,
      supportedEngineModes: Option[List[String]] = None,
      supportsParallelQuery: Option[Boolean] = None,
      supportsGlobalDatabases: Option[Boolean] = None
    ): UpgradeTarget =
      UpgradeTarget
        .builder
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(autoUpgrade)(_.autoUpgrade(_))
        .ifSome(isMajorVersionUpgrade)(_.isMajorVersionUpgrade(_))
        .ifSome(supportedEngineModes)(_.supportedEngineModes(_))
        .ifSome(supportsParallelQuery)(_.supportsParallelQuery(_))
        .ifSome(supportsGlobalDatabases)(_.supportsGlobalDatabases(_))
        .build

    def userAuthConfig(
      description: Option[String] = None,
      userName: Option[String] = None,
      authScheme: Option[String] = None,
      secretArn: Option[String] = None,
      iAMAuth: Option[String] = None
    ): UserAuthConfig =
      UserAuthConfig
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(authScheme)(_.authScheme(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(iAMAuth)(_.iAMAuth(_))
        .build

    def userAuthConfigInfo(
      description: Option[String] = None,
      userName: Option[String] = None,
      authScheme: Option[String] = None,
      secretArn: Option[String] = None,
      iAMAuth: Option[String] = None
    ): UserAuthConfigInfo =
      UserAuthConfigInfo
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(authScheme)(_.authScheme(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(iAMAuth)(_.iAMAuth(_))
        .build

    def validDBInstanceModificationsMessage(
      storage: Option[List[ValidStorageOptions]] = None,
      validProcessorFeatures: Option[List[AvailableProcessorFeature]] = None
    ): ValidDBInstanceModificationsMessage =
      ValidDBInstanceModificationsMessage
        .builder
        .ifSome(storage)(_.storage(_))
        .ifSome(validProcessorFeatures)(_.validProcessorFeatures(_))
        .build

    def validStorageOptions(
      storageType: Option[String] = None,
      storageSize: Option[List[Range]] = None,
      provisionedIops: Option[List[Range]] = None,
      iopsToStorageRatio: Option[List[DoubleRange]] = None,
      supportsStorageAutoscaling: Option[Boolean] = None
    ): ValidStorageOptions =
      ValidStorageOptions
        .builder
        .ifSome(storageType)(_.storageType(_))
        .ifSome(storageSize)(_.storageSize(_))
        .ifSome(provisionedIops)(_.provisionedIops(_))
        .ifSome(iopsToStorageRatio)(_.iopsToStorageRatio(_))
        .ifSome(supportsStorageAutoscaling)(_.supportsStorageAutoscaling(_))
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

    def vpnDetails(
      vpnId: Option[String] = None,
      vpnTunnelOriginatorIP: Option[String] = None,
      vpnGatewayIp: Option[String] = None,
      vpnPSK: Option[String] = None,
      vpnName: Option[String] = None,
      vpnState: Option[String] = None
    ): VpnDetails =
      VpnDetails
        .builder
        .ifSome(vpnId)(_.vpnId(_))
        .ifSome(vpnTunnelOriginatorIP)(_.vpnTunnelOriginatorIP(_))
        .ifSome(vpnGatewayIp)(_.vpnGatewayIp(_))
        .ifSome(vpnPSK)(_.vpnPSK(_))
        .ifSome(vpnName)(_.vpnName(_))
        .ifSome(vpnState)(_.vpnState(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
