package goober.hi

import goober.free.storagegateway.StorageGatewayIO
import software.amazon.awssdk.services.storagegateway.model._


object storagegateway {
  import goober.free.{storagegateway ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activateGatewayInput(
      activationKey: Option[String] = None,
      gatewayName: Option[String] = None,
      gatewayTimezone: Option[String] = None,
      gatewayRegion: Option[String] = None,
      gatewayType: Option[String] = None,
      tapeDriveType: Option[String] = None,
      mediumChangerType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ActivateGatewayInput =
      ActivateGatewayInput
        .builder
        .ifSome(activationKey)(_.activationKey(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .ifSome(gatewayTimezone)(_.gatewayTimezone(_))
        .ifSome(gatewayRegion)(_.gatewayRegion(_))
        .ifSome(gatewayType)(_.gatewayType(_))
        .ifSome(tapeDriveType)(_.tapeDriveType(_))
        .ifSome(mediumChangerType)(_.mediumChangerType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def activateGatewayOutput(
      gatewayARN: Option[String] = None
    ): ActivateGatewayOutput =
      ActivateGatewayOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def addCacheInput(
      gatewayARN: Option[String] = None,
      diskIds: Option[List[DiskId]] = None
    ): AddCacheInput =
      AddCacheInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(diskIds)(_.diskIds(_))
        .build

    def addCacheOutput(
      gatewayARN: Option[String] = None
    ): AddCacheOutput =
      AddCacheOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def addTagsToResourceInput(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsToResourceInput =
      AddTagsToResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsToResourceOutput(
      resourceARN: Option[String] = None
    ): AddTagsToResourceOutput =
      AddTagsToResourceOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def addUploadBufferInput(
      gatewayARN: Option[String] = None,
      diskIds: Option[List[DiskId]] = None
    ): AddUploadBufferInput =
      AddUploadBufferInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(diskIds)(_.diskIds(_))
        .build

    def addUploadBufferOutput(
      gatewayARN: Option[String] = None
    ): AddUploadBufferOutput =
      AddUploadBufferOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def addWorkingStorageInput(
      gatewayARN: Option[String] = None,
      diskIds: Option[List[DiskId]] = None
    ): AddWorkingStorageInput =
      AddWorkingStorageInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(diskIds)(_.diskIds(_))
        .build

    def addWorkingStorageOutput(
      gatewayARN: Option[String] = None
    ): AddWorkingStorageOutput =
      AddWorkingStorageOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def assignTapePoolInput(
      tapeARN: Option[String] = None,
      poolId: Option[String] = None,
      bypassGovernanceRetention: Option[Boolean] = None
    ): AssignTapePoolInput =
      AssignTapePoolInput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(poolId)(_.poolId(_))
        .ifSome(bypassGovernanceRetention)(_.bypassGovernanceRetention(_))
        .build

    def assignTapePoolOutput(
      tapeARN: Option[String] = None
    ): AssignTapePoolOutput =
      AssignTapePoolOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def associateFileSystemInput(
      userName: Option[String] = None,
      password: Option[String] = None,
      clientToken: Option[String] = None,
      gatewayARN: Option[String] = None,
      locationARN: Option[String] = None,
      tags: Option[List[Tag]] = None,
      auditDestinationARN: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None
    ): AssociateFileSystemInput =
      AssociateFileSystemInput
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(locationARN)(_.locationARN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(auditDestinationARN)(_.auditDestinationARN(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .build

    def associateFileSystemOutput(
      fileSystemAssociationARN: Option[String] = None
    ): AssociateFileSystemOutput =
      AssociateFileSystemOutput
        .builder
        .ifSome(fileSystemAssociationARN)(_.fileSystemAssociationARN(_))
        .build

    def attachVolumeInput(
      gatewayARN: Option[String] = None,
      targetName: Option[String] = None,
      volumeARN: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      diskId: Option[String] = None
    ): AttachVolumeInput =
      AttachVolumeInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(targetName)(_.targetName(_))
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(diskId)(_.diskId(_))
        .build

    def attachVolumeOutput(
      volumeARN: Option[String] = None,
      targetARN: Option[String] = None
    ): AttachVolumeOutput =
      AttachVolumeOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(targetARN)(_.targetARN(_))
        .build

    def automaticTapeCreationPolicyInfo(
      automaticTapeCreationRules: Option[List[AutomaticTapeCreationRule]] = None,
      gatewayARN: Option[String] = None
    ): AutomaticTapeCreationPolicyInfo =
      AutomaticTapeCreationPolicyInfo
        .builder
        .ifSome(automaticTapeCreationRules)(_.automaticTapeCreationRules(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def automaticTapeCreationRule(
      tapeBarcodePrefix: Option[String] = None,
      poolId: Option[String] = None,
      tapeSizeInBytes: Option[TapeSize] = None,
      minimumNumTapes: Option[Int] = None,
      worm: Option[Boolean] = None
    ): AutomaticTapeCreationRule =
      AutomaticTapeCreationRule
        .builder
        .ifSome(tapeBarcodePrefix)(_.tapeBarcodePrefix(_))
        .ifSome(poolId)(_.poolId(_))
        .ifSome(tapeSizeInBytes)(_.tapeSizeInBytes(_))
        .ifSome(minimumNumTapes)(_.minimumNumTapes(_))
        .ifSome(worm)(_.worm(_))
        .build

    def bandwidthRateLimitInterval(
      startHourOfDay: Option[Int] = None,
      startMinuteOfHour: Option[Int] = None,
      endHourOfDay: Option[Int] = None,
      endMinuteOfHour: Option[Int] = None,
      daysOfWeek: Option[List[DayOfWeek]] = None,
      averageUploadRateLimitInBitsPerSec: Option[BandwidthUploadRateLimit] = None,
      averageDownloadRateLimitInBitsPerSec: Option[BandwidthDownloadRateLimit] = None
    ): BandwidthRateLimitInterval =
      BandwidthRateLimitInterval
        .builder
        .ifSome(startHourOfDay)(_.startHourOfDay(_))
        .ifSome(startMinuteOfHour)(_.startMinuteOfHour(_))
        .ifSome(endHourOfDay)(_.endHourOfDay(_))
        .ifSome(endMinuteOfHour)(_.endMinuteOfHour(_))
        .ifSome(daysOfWeek)(_.daysOfWeek(_))
        .ifSome(averageUploadRateLimitInBitsPerSec)(_.averageUploadRateLimitInBitsPerSec(_))
        .ifSome(averageDownloadRateLimitInBitsPerSec)(_.averageDownloadRateLimitInBitsPerSec(_))
        .build

    def cacheAttributes(
      cacheStaleTimeoutInSeconds: Option[Int] = None
    ): CacheAttributes =
      CacheAttributes
        .builder
        .ifSome(cacheStaleTimeoutInSeconds)(_.cacheStaleTimeoutInSeconds(_))
        .build

    def cachediSCSIVolume(
      volumeARN: Option[String] = None,
      volumeId: Option[String] = None,
      volumeType: Option[String] = None,
      volumeStatus: Option[String] = None,
      volumeAttachmentStatus: Option[String] = None,
      volumeSizeInBytes: Option[long] = None,
      volumeProgress: Option[DoubleObject] = None,
      sourceSnapshotId: Option[String] = None,
      volumeiSCSIAttributes: Option[VolumeiSCSIAttributes] = None,
      createdDate: Option[CreatedDate] = None,
      volumeUsedInBytes: Option[VolumeUsedInBytes] = None,
      kMSKey: Option[String] = None,
      targetName: Option[String] = None
    ): CachediSCSIVolume =
      CachediSCSIVolume
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(volumeStatus)(_.volumeStatus(_))
        .ifSome(volumeAttachmentStatus)(_.volumeAttachmentStatus(_))
        .ifSome(volumeSizeInBytes)(_.volumeSizeInBytes(_))
        .ifSome(volumeProgress)(_.volumeProgress(_))
        .ifSome(sourceSnapshotId)(_.sourceSnapshotId(_))
        .ifSome(volumeiSCSIAttributes)(_.volumeiSCSIAttributes(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(volumeUsedInBytes)(_.volumeUsedInBytes(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(targetName)(_.targetName(_))
        .build

    def cancelArchivalInput(
      gatewayARN: Option[String] = None,
      tapeARN: Option[String] = None
    ): CancelArchivalInput =
      CancelArchivalInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def cancelArchivalOutput(
      tapeARN: Option[String] = None
    ): CancelArchivalOutput =
      CancelArchivalOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def cancelRetrievalInput(
      gatewayARN: Option[String] = None,
      tapeARN: Option[String] = None
    ): CancelRetrievalInput =
      CancelRetrievalInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def cancelRetrievalOutput(
      tapeARN: Option[String] = None
    ): CancelRetrievalOutput =
      CancelRetrievalOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def chapInfo(
      targetARN: Option[String] = None,
      secretToAuthenticateInitiator: Option[String] = None,
      initiatorName: Option[String] = None,
      secretToAuthenticateTarget: Option[String] = None
    ): ChapInfo =
      ChapInfo
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .ifSome(secretToAuthenticateInitiator)(_.secretToAuthenticateInitiator(_))
        .ifSome(initiatorName)(_.initiatorName(_))
        .ifSome(secretToAuthenticateTarget)(_.secretToAuthenticateTarget(_))
        .build

    def createCachediSCSIVolumeInput(
      gatewayARN: Option[String] = None,
      volumeSizeInBytes: Option[long] = None,
      snapshotId: Option[String] = None,
      targetName: Option[String] = None,
      sourceVolumeARN: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      clientToken: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateCachediSCSIVolumeInput =
      CreateCachediSCSIVolumeInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(volumeSizeInBytes)(_.volumeSizeInBytes(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(targetName)(_.targetName(_))
        .ifSome(sourceVolumeARN)(_.sourceVolumeARN(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCachediSCSIVolumeOutput(
      volumeARN: Option[String] = None,
      targetARN: Option[String] = None
    ): CreateCachediSCSIVolumeOutput =
      CreateCachediSCSIVolumeOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(targetARN)(_.targetARN(_))
        .build

    def createNFSFileShareInput(
      clientToken: Option[String] = None,
      nFSFileShareDefaults: Option[NFSFileShareDefaults] = None,
      gatewayARN: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      role: Option[String] = None,
      locationARN: Option[String] = None,
      defaultStorageClass: Option[String] = None,
      objectACL: Option[String] = None,
      clientList: Option[List[IPV4AddressCIDR]] = None,
      squash: Option[String] = None,
      readOnly: Option[Boolean] = None,
      guessMIMETypeEnabled: Option[Boolean] = None,
      requesterPays: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      fileShareName: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None,
      notificationPolicy: Option[String] = None
    ): CreateNFSFileShareInput =
      CreateNFSFileShareInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(nFSFileShareDefaults)(_.nFSFileShareDefaults(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(role)(_.role(_))
        .ifSome(locationARN)(_.locationARN(_))
        .ifSome(defaultStorageClass)(_.defaultStorageClass(_))
        .ifSome(objectACL)(_.objectACL(_))
        .ifSome(clientList)(_.clientList(_))
        .ifSome(squash)(_.squash(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(guessMIMETypeEnabled)(_.guessMIMETypeEnabled(_))
        .ifSome(requesterPays)(_.requesterPays(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileShareName)(_.fileShareName(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .ifSome(notificationPolicy)(_.notificationPolicy(_))
        .build

    def createNFSFileShareOutput(
      fileShareARN: Option[String] = None
    ): CreateNFSFileShareOutput =
      CreateNFSFileShareOutput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .build

    def createSMBFileShareInput(
      clientToken: Option[String] = None,
      gatewayARN: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      role: Option[String] = None,
      locationARN: Option[String] = None,
      defaultStorageClass: Option[String] = None,
      objectACL: Option[String] = None,
      readOnly: Option[Boolean] = None,
      guessMIMETypeEnabled: Option[Boolean] = None,
      requesterPays: Option[Boolean] = None,
      sMBACLEnabled: Option[Boolean] = None,
      accessBasedEnumeration: Option[Boolean] = None,
      adminUserList: Option[List[UserListUser]] = None,
      validUserList: Option[List[UserListUser]] = None,
      invalidUserList: Option[List[UserListUser]] = None,
      auditDestinationARN: Option[String] = None,
      authentication: Option[String] = None,
      caseSensitivity: Option[String] = None,
      tags: Option[List[Tag]] = None,
      fileShareName: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None,
      notificationPolicy: Option[String] = None
    ): CreateSMBFileShareInput =
      CreateSMBFileShareInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(role)(_.role(_))
        .ifSome(locationARN)(_.locationARN(_))
        .ifSome(defaultStorageClass)(_.defaultStorageClass(_))
        .ifSome(objectACL)(_.objectACL(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(guessMIMETypeEnabled)(_.guessMIMETypeEnabled(_))
        .ifSome(requesterPays)(_.requesterPays(_))
        .ifSome(sMBACLEnabled)(_.sMBACLEnabled(_))
        .ifSome(accessBasedEnumeration)(_.accessBasedEnumeration(_))
        .ifSome(adminUserList)(_.adminUserList(_))
        .ifSome(validUserList)(_.validUserList(_))
        .ifSome(invalidUserList)(_.invalidUserList(_))
        .ifSome(auditDestinationARN)(_.auditDestinationARN(_))
        .ifSome(authentication)(_.authentication(_))
        .ifSome(caseSensitivity)(_.caseSensitivity(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileShareName)(_.fileShareName(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .ifSome(notificationPolicy)(_.notificationPolicy(_))
        .build

    def createSMBFileShareOutput(
      fileShareARN: Option[String] = None
    ): CreateSMBFileShareOutput =
      CreateSMBFileShareOutput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .build

    def createSnapshotFromVolumeRecoveryPointInput(
      volumeARN: Option[String] = None,
      snapshotDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateSnapshotFromVolumeRecoveryPointInput =
      CreateSnapshotFromVolumeRecoveryPointInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(snapshotDescription)(_.snapshotDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSnapshotFromVolumeRecoveryPointOutput(
      snapshotId: Option[String] = None,
      volumeARN: Option[String] = None,
      volumeRecoveryPointTime: Option[String] = None
    ): CreateSnapshotFromVolumeRecoveryPointOutput =
      CreateSnapshotFromVolumeRecoveryPointOutput
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(volumeRecoveryPointTime)(_.volumeRecoveryPointTime(_))
        .build

    def createSnapshotInput(
      volumeARN: Option[String] = None,
      snapshotDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateSnapshotInput =
      CreateSnapshotInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(snapshotDescription)(_.snapshotDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSnapshotOutput(
      volumeARN: Option[String] = None,
      snapshotId: Option[String] = None
    ): CreateSnapshotOutput =
      CreateSnapshotOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .build

    def createStorediSCSIVolumeInput(
      gatewayARN: Option[String] = None,
      diskId: Option[String] = None,
      snapshotId: Option[String] = None,
      preserveExistingData: Option[Boolean] = None,
      targetName: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateStorediSCSIVolumeInput =
      CreateStorediSCSIVolumeInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(diskId)(_.diskId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(preserveExistingData)(_.preserveExistingData(_))
        .ifSome(targetName)(_.targetName(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStorediSCSIVolumeOutput(
      volumeARN: Option[String] = None,
      volumeSizeInBytes: Option[long] = None,
      targetARN: Option[String] = None
    ): CreateStorediSCSIVolumeOutput =
      CreateStorediSCSIVolumeOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(volumeSizeInBytes)(_.volumeSizeInBytes(_))
        .ifSome(targetARN)(_.targetARN(_))
        .build

    def createTapePoolInput(
      poolName: Option[String] = None,
      storageClass: Option[String] = None,
      retentionLockType: Option[String] = None,
      retentionLockTimeInDays: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): CreateTapePoolInput =
      CreateTapePoolInput
        .builder
        .ifSome(poolName)(_.poolName(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(retentionLockType)(_.retentionLockType(_))
        .ifSome(retentionLockTimeInDays)(_.retentionLockTimeInDays(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTapePoolOutput(
      poolARN: Option[String] = None
    ): CreateTapePoolOutput =
      CreateTapePoolOutput
        .builder
        .ifSome(poolARN)(_.poolARN(_))
        .build

    def createTapeWithBarcodeInput(
      gatewayARN: Option[String] = None,
      tapeSizeInBytes: Option[TapeSize] = None,
      tapeBarcode: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      poolId: Option[String] = None,
      worm: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateTapeWithBarcodeInput =
      CreateTapeWithBarcodeInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tapeSizeInBytes)(_.tapeSizeInBytes(_))
        .ifSome(tapeBarcode)(_.tapeBarcode(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(poolId)(_.poolId(_))
        .ifSome(worm)(_.worm(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTapeWithBarcodeOutput(
      tapeARN: Option[String] = None
    ): CreateTapeWithBarcodeOutput =
      CreateTapeWithBarcodeOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def createTapesInput(
      gatewayARN: Option[String] = None,
      tapeSizeInBytes: Option[TapeSize] = None,
      clientToken: Option[String] = None,
      numTapesToCreate: Option[Int] = None,
      tapeBarcodePrefix: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      poolId: Option[String] = None,
      worm: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateTapesInput =
      CreateTapesInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tapeSizeInBytes)(_.tapeSizeInBytes(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(numTapesToCreate)(_.numTapesToCreate(_))
        .ifSome(tapeBarcodePrefix)(_.tapeBarcodePrefix(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(poolId)(_.poolId(_))
        .ifSome(worm)(_.worm(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTapesOutput(
      tapeARNs: Option[List[TapeARN]] = None
    ): CreateTapesOutput =
      CreateTapesOutput
        .builder
        .ifSome(tapeARNs)(_.tapeARNs(_))
        .build

    def deleteAutomaticTapeCreationPolicyInput(
      gatewayARN: Option[String] = None
    ): DeleteAutomaticTapeCreationPolicyInput =
      DeleteAutomaticTapeCreationPolicyInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def deleteAutomaticTapeCreationPolicyOutput(
      gatewayARN: Option[String] = None
    ): DeleteAutomaticTapeCreationPolicyOutput =
      DeleteAutomaticTapeCreationPolicyOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def deleteBandwidthRateLimitInput(
      gatewayARN: Option[String] = None,
      bandwidthType: Option[String] = None
    ): DeleteBandwidthRateLimitInput =
      DeleteBandwidthRateLimitInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(bandwidthType)(_.bandwidthType(_))
        .build

    def deleteBandwidthRateLimitOutput(
      gatewayARN: Option[String] = None
    ): DeleteBandwidthRateLimitOutput =
      DeleteBandwidthRateLimitOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def deleteChapCredentialsInput(
      targetARN: Option[String] = None,
      initiatorName: Option[String] = None
    ): DeleteChapCredentialsInput =
      DeleteChapCredentialsInput
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .ifSome(initiatorName)(_.initiatorName(_))
        .build

    def deleteChapCredentialsOutput(
      targetARN: Option[String] = None,
      initiatorName: Option[String] = None
    ): DeleteChapCredentialsOutput =
      DeleteChapCredentialsOutput
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .ifSome(initiatorName)(_.initiatorName(_))
        .build

    def deleteFileShareInput(
      fileShareARN: Option[String] = None,
      forceDelete: Option[Boolean] = None
    ): DeleteFileShareInput =
      DeleteFileShareInput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(forceDelete)(_.forceDelete(_))
        .build

    def deleteFileShareOutput(
      fileShareARN: Option[String] = None
    ): DeleteFileShareOutput =
      DeleteFileShareOutput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .build

    def deleteGatewayInput(
      gatewayARN: Option[String] = None
    ): DeleteGatewayInput =
      DeleteGatewayInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def deleteGatewayOutput(
      gatewayARN: Option[String] = None
    ): DeleteGatewayOutput =
      DeleteGatewayOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def deleteSnapshotScheduleInput(
      volumeARN: Option[String] = None
    ): DeleteSnapshotScheduleInput =
      DeleteSnapshotScheduleInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def deleteSnapshotScheduleOutput(
      volumeARN: Option[String] = None
    ): DeleteSnapshotScheduleOutput =
      DeleteSnapshotScheduleOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def deleteTapeArchiveInput(
      tapeARN: Option[String] = None,
      bypassGovernanceRetention: Option[Boolean] = None
    ): DeleteTapeArchiveInput =
      DeleteTapeArchiveInput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(bypassGovernanceRetention)(_.bypassGovernanceRetention(_))
        .build

    def deleteTapeArchiveOutput(
      tapeARN: Option[String] = None
    ): DeleteTapeArchiveOutput =
      DeleteTapeArchiveOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def deleteTapeInput(
      gatewayARN: Option[String] = None,
      tapeARN: Option[String] = None,
      bypassGovernanceRetention: Option[Boolean] = None
    ): DeleteTapeInput =
      DeleteTapeInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(bypassGovernanceRetention)(_.bypassGovernanceRetention(_))
        .build

    def deleteTapeOutput(
      tapeARN: Option[String] = None
    ): DeleteTapeOutput =
      DeleteTapeOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def deleteTapePoolInput(
      poolARN: Option[String] = None
    ): DeleteTapePoolInput =
      DeleteTapePoolInput
        .builder
        .ifSome(poolARN)(_.poolARN(_))
        .build

    def deleteTapePoolOutput(
      poolARN: Option[String] = None
    ): DeleteTapePoolOutput =
      DeleteTapePoolOutput
        .builder
        .ifSome(poolARN)(_.poolARN(_))
        .build

    def deleteVolumeInput(
      volumeARN: Option[String] = None
    ): DeleteVolumeInput =
      DeleteVolumeInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def deleteVolumeOutput(
      volumeARN: Option[String] = None
    ): DeleteVolumeOutput =
      DeleteVolumeOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def describeAvailabilityMonitorTestInput(
      gatewayARN: Option[String] = None
    ): DescribeAvailabilityMonitorTestInput =
      DescribeAvailabilityMonitorTestInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeAvailabilityMonitorTestOutput(
      gatewayARN: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[Time] = None
    ): DescribeAvailabilityMonitorTestOutput =
      DescribeAvailabilityMonitorTestOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def describeBandwidthRateLimitInput(
      gatewayARN: Option[String] = None
    ): DescribeBandwidthRateLimitInput =
      DescribeBandwidthRateLimitInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeBandwidthRateLimitOutput(
      gatewayARN: Option[String] = None,
      averageUploadRateLimitInBitsPerSec: Option[BandwidthUploadRateLimit] = None,
      averageDownloadRateLimitInBitsPerSec: Option[BandwidthDownloadRateLimit] = None
    ): DescribeBandwidthRateLimitOutput =
      DescribeBandwidthRateLimitOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(averageUploadRateLimitInBitsPerSec)(_.averageUploadRateLimitInBitsPerSec(_))
        .ifSome(averageDownloadRateLimitInBitsPerSec)(_.averageDownloadRateLimitInBitsPerSec(_))
        .build

    def describeBandwidthRateLimitScheduleInput(
      gatewayARN: Option[String] = None
    ): DescribeBandwidthRateLimitScheduleInput =
      DescribeBandwidthRateLimitScheduleInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeBandwidthRateLimitScheduleOutput(
      gatewayARN: Option[String] = None,
      bandwidthRateLimitIntervals: Option[List[BandwidthRateLimitInterval]] = None
    ): DescribeBandwidthRateLimitScheduleOutput =
      DescribeBandwidthRateLimitScheduleOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(bandwidthRateLimitIntervals)(_.bandwidthRateLimitIntervals(_))
        .build

    def describeCacheInput(
      gatewayARN: Option[String] = None
    ): DescribeCacheInput =
      DescribeCacheInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeCacheOutput(
      gatewayARN: Option[String] = None,
      diskIds: Option[List[DiskId]] = None,
      cacheAllocatedInBytes: Option[long] = None,
      cacheUsedPercentage: Option[double] = None,
      cacheDirtyPercentage: Option[double] = None,
      cacheHitPercentage: Option[double] = None,
      cacheMissPercentage: Option[double] = None
    ): DescribeCacheOutput =
      DescribeCacheOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(diskIds)(_.diskIds(_))
        .ifSome(cacheAllocatedInBytes)(_.cacheAllocatedInBytes(_))
        .ifSome(cacheUsedPercentage)(_.cacheUsedPercentage(_))
        .ifSome(cacheDirtyPercentage)(_.cacheDirtyPercentage(_))
        .ifSome(cacheHitPercentage)(_.cacheHitPercentage(_))
        .ifSome(cacheMissPercentage)(_.cacheMissPercentage(_))
        .build

    def describeCachediSCSIVolumesInput(
      volumeARNs: Option[List[VolumeARN]] = None
    ): DescribeCachediSCSIVolumesInput =
      DescribeCachediSCSIVolumesInput
        .builder
        .ifSome(volumeARNs)(_.volumeARNs(_))
        .build

    def describeCachediSCSIVolumesOutput(
      cachediSCSIVolumes: Option[List[CachediSCSIVolume]] = None
    ): DescribeCachediSCSIVolumesOutput =
      DescribeCachediSCSIVolumesOutput
        .builder
        .ifSome(cachediSCSIVolumes)(_.cachediSCSIVolumes(_))
        .build

    def describeChapCredentialsInput(
      targetARN: Option[String] = None
    ): DescribeChapCredentialsInput =
      DescribeChapCredentialsInput
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .build

    def describeChapCredentialsOutput(
      chapCredentials: Option[List[ChapInfo]] = None
    ): DescribeChapCredentialsOutput =
      DescribeChapCredentialsOutput
        .builder
        .ifSome(chapCredentials)(_.chapCredentials(_))
        .build

    def describeFileSystemAssociationsInput(
      fileSystemAssociationARNList: Option[List[FileSystemAssociationARN]] = None
    ): DescribeFileSystemAssociationsInput =
      DescribeFileSystemAssociationsInput
        .builder
        .ifSome(fileSystemAssociationARNList)(_.fileSystemAssociationARNList(_))
        .build

    def describeFileSystemAssociationsOutput(
      fileSystemAssociationInfoList: Option[List[FileSystemAssociationInfo]] = None
    ): DescribeFileSystemAssociationsOutput =
      DescribeFileSystemAssociationsOutput
        .builder
        .ifSome(fileSystemAssociationInfoList)(_.fileSystemAssociationInfoList(_))
        .build

    def describeGatewayInformationInput(
      gatewayARN: Option[String] = None
    ): DescribeGatewayInformationInput =
      DescribeGatewayInformationInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeGatewayInformationOutput(
      gatewayARN: Option[String] = None,
      gatewayId: Option[String] = None,
      gatewayName: Option[String] = None,
      gatewayTimezone: Option[String] = None,
      gatewayState: Option[String] = None,
      gatewayNetworkInterfaces: Option[List[NetworkInterface]] = None,
      gatewayType: Option[String] = None,
      nextUpdateAvailabilityDate: Option[String] = None,
      lastSoftwareUpdate: Option[String] = None,
      ec2InstanceId: Option[String] = None,
      ec2InstanceRegion: Option[String] = None,
      tags: Option[List[Tag]] = None,
      vPCEndpoint: Option[String] = None,
      cloudWatchLogGroupARN: Option[String] = None,
      hostEnvironment: Option[String] = None,
      endpointType: Option[String] = None,
      softwareUpdatesEndDate: Option[String] = None,
      deprecationDate: Option[String] = None
    ): DescribeGatewayInformationOutput =
      DescribeGatewayInformationOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .ifSome(gatewayTimezone)(_.gatewayTimezone(_))
        .ifSome(gatewayState)(_.gatewayState(_))
        .ifSome(gatewayNetworkInterfaces)(_.gatewayNetworkInterfaces(_))
        .ifSome(gatewayType)(_.gatewayType(_))
        .ifSome(nextUpdateAvailabilityDate)(_.nextUpdateAvailabilityDate(_))
        .ifSome(lastSoftwareUpdate)(_.lastSoftwareUpdate(_))
        .ifSome(ec2InstanceId)(_.ec2InstanceId(_))
        .ifSome(ec2InstanceRegion)(_.ec2InstanceRegion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vPCEndpoint)(_.vPCEndpoint(_))
        .ifSome(cloudWatchLogGroupARN)(_.cloudWatchLogGroupARN(_))
        .ifSome(hostEnvironment)(_.hostEnvironment(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(softwareUpdatesEndDate)(_.softwareUpdatesEndDate(_))
        .ifSome(deprecationDate)(_.deprecationDate(_))
        .build

    def describeMaintenanceStartTimeInput(
      gatewayARN: Option[String] = None
    ): DescribeMaintenanceStartTimeInput =
      DescribeMaintenanceStartTimeInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeMaintenanceStartTimeOutput(
      gatewayARN: Option[String] = None,
      hourOfDay: Option[Int] = None,
      minuteOfHour: Option[Int] = None,
      dayOfWeek: Option[Int] = None,
      dayOfMonth: Option[Int] = None,
      timezone: Option[String] = None
    ): DescribeMaintenanceStartTimeOutput =
      DescribeMaintenanceStartTimeOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(hourOfDay)(_.hourOfDay(_))
        .ifSome(minuteOfHour)(_.minuteOfHour(_))
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .ifSome(dayOfMonth)(_.dayOfMonth(_))
        .ifSome(timezone)(_.timezone(_))
        .build

    def describeNFSFileSharesInput(
      fileShareARNList: Option[List[FileShareARN]] = None
    ): DescribeNFSFileSharesInput =
      DescribeNFSFileSharesInput
        .builder
        .ifSome(fileShareARNList)(_.fileShareARNList(_))
        .build

    def describeNFSFileSharesOutput(
      nFSFileShareInfoList: Option[List[NFSFileShareInfo]] = None
    ): DescribeNFSFileSharesOutput =
      DescribeNFSFileSharesOutput
        .builder
        .ifSome(nFSFileShareInfoList)(_.nFSFileShareInfoList(_))
        .build

    def describeSMBFileSharesInput(
      fileShareARNList: Option[List[FileShareARN]] = None
    ): DescribeSMBFileSharesInput =
      DescribeSMBFileSharesInput
        .builder
        .ifSome(fileShareARNList)(_.fileShareARNList(_))
        .build

    def describeSMBFileSharesOutput(
      sMBFileShareInfoList: Option[List[SMBFileShareInfo]] = None
    ): DescribeSMBFileSharesOutput =
      DescribeSMBFileSharesOutput
        .builder
        .ifSome(sMBFileShareInfoList)(_.sMBFileShareInfoList(_))
        .build

    def describeSMBSettingsInput(
      gatewayARN: Option[String] = None
    ): DescribeSMBSettingsInput =
      DescribeSMBSettingsInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeSMBSettingsOutput(
      gatewayARN: Option[String] = None,
      domainName: Option[String] = None,
      activeDirectoryStatus: Option[String] = None,
      sMBGuestPasswordSet: Option[Boolean] = None,
      sMBSecurityStrategy: Option[String] = None,
      fileSharesVisible: Option[Boolean] = None
    ): DescribeSMBSettingsOutput =
      DescribeSMBSettingsOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(activeDirectoryStatus)(_.activeDirectoryStatus(_))
        .ifSome(sMBGuestPasswordSet)(_.sMBGuestPasswordSet(_))
        .ifSome(sMBSecurityStrategy)(_.sMBSecurityStrategy(_))
        .ifSome(fileSharesVisible)(_.fileSharesVisible(_))
        .build

    def describeSnapshotScheduleInput(
      volumeARN: Option[String] = None
    ): DescribeSnapshotScheduleInput =
      DescribeSnapshotScheduleInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def describeSnapshotScheduleOutput(
      volumeARN: Option[String] = None,
      startAt: Option[Int] = None,
      recurrenceInHours: Option[Int] = None,
      description: Option[String] = None,
      timezone: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): DescribeSnapshotScheduleOutput =
      DescribeSnapshotScheduleOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(startAt)(_.startAt(_))
        .ifSome(recurrenceInHours)(_.recurrenceInHours(_))
        .ifSome(description)(_.description(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeStorediSCSIVolumesInput(
      volumeARNs: Option[List[VolumeARN]] = None
    ): DescribeStorediSCSIVolumesInput =
      DescribeStorediSCSIVolumesInput
        .builder
        .ifSome(volumeARNs)(_.volumeARNs(_))
        .build

    def describeStorediSCSIVolumesOutput(
      storediSCSIVolumes: Option[List[StorediSCSIVolume]] = None
    ): DescribeStorediSCSIVolumesOutput =
      DescribeStorediSCSIVolumesOutput
        .builder
        .ifSome(storediSCSIVolumes)(_.storediSCSIVolumes(_))
        .build

    def describeTapeArchivesInput(
      tapeARNs: Option[List[TapeARN]] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeTapeArchivesInput =
      DescribeTapeArchivesInput
        .builder
        .ifSome(tapeARNs)(_.tapeARNs(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeTapeArchivesOutput(
      tapeArchives: Option[List[TapeArchive]] = None,
      marker: Option[String] = None
    ): DescribeTapeArchivesOutput =
      DescribeTapeArchivesOutput
        .builder
        .ifSome(tapeArchives)(_.tapeArchives(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeTapeRecoveryPointsInput(
      gatewayARN: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeTapeRecoveryPointsInput =
      DescribeTapeRecoveryPointsInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeTapeRecoveryPointsOutput(
      gatewayARN: Option[String] = None,
      tapeRecoveryPointInfos: Option[List[TapeRecoveryPointInfo]] = None,
      marker: Option[String] = None
    ): DescribeTapeRecoveryPointsOutput =
      DescribeTapeRecoveryPointsOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tapeRecoveryPointInfos)(_.tapeRecoveryPointInfos(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeTapesInput(
      gatewayARN: Option[String] = None,
      tapeARNs: Option[List[TapeARN]] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeTapesInput =
      DescribeTapesInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tapeARNs)(_.tapeARNs(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeTapesOutput(
      tapes: Option[List[Tape]] = None,
      marker: Option[String] = None
    ): DescribeTapesOutput =
      DescribeTapesOutput
        .builder
        .ifSome(tapes)(_.tapes(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeUploadBufferInput(
      gatewayARN: Option[String] = None
    ): DescribeUploadBufferInput =
      DescribeUploadBufferInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeUploadBufferOutput(
      gatewayARN: Option[String] = None,
      diskIds: Option[List[DiskId]] = None,
      uploadBufferUsedInBytes: Option[long] = None,
      uploadBufferAllocatedInBytes: Option[long] = None
    ): DescribeUploadBufferOutput =
      DescribeUploadBufferOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(diskIds)(_.diskIds(_))
        .ifSome(uploadBufferUsedInBytes)(_.uploadBufferUsedInBytes(_))
        .ifSome(uploadBufferAllocatedInBytes)(_.uploadBufferAllocatedInBytes(_))
        .build

    def describeVTLDevicesInput(
      gatewayARN: Option[String] = None,
      vTLDeviceARNs: Option[List[VTLDeviceARN]] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeVTLDevicesInput =
      DescribeVTLDevicesInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(vTLDeviceARNs)(_.vTLDeviceARNs(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeVTLDevicesOutput(
      gatewayARN: Option[String] = None,
      vTLDevices: Option[List[VTLDevice]] = None,
      marker: Option[String] = None
    ): DescribeVTLDevicesOutput =
      DescribeVTLDevicesOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(vTLDevices)(_.vTLDevices(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeWorkingStorageInput(
      gatewayARN: Option[String] = None
    ): DescribeWorkingStorageInput =
      DescribeWorkingStorageInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def describeWorkingStorageOutput(
      gatewayARN: Option[String] = None,
      diskIds: Option[List[DiskId]] = None,
      workingStorageUsedInBytes: Option[long] = None,
      workingStorageAllocatedInBytes: Option[long] = None
    ): DescribeWorkingStorageOutput =
      DescribeWorkingStorageOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(diskIds)(_.diskIds(_))
        .ifSome(workingStorageUsedInBytes)(_.workingStorageUsedInBytes(_))
        .ifSome(workingStorageAllocatedInBytes)(_.workingStorageAllocatedInBytes(_))
        .build

    def detachVolumeInput(
      volumeARN: Option[String] = None,
      forceDetach: Option[Boolean] = None
    ): DetachVolumeInput =
      DetachVolumeInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(forceDetach)(_.forceDetach(_))
        .build

    def detachVolumeOutput(
      volumeARN: Option[String] = None
    ): DetachVolumeOutput =
      DetachVolumeOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def deviceiSCSIAttributes(
      targetARN: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      networkInterfacePort: Option[Int] = None,
      chapEnabled: Option[Boolean] = None
    ): DeviceiSCSIAttributes =
      DeviceiSCSIAttributes
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(networkInterfacePort)(_.networkInterfacePort(_))
        .ifSome(chapEnabled)(_.chapEnabled(_))
        .build

    def disableGatewayInput(
      gatewayARN: Option[String] = None
    ): DisableGatewayInput =
      DisableGatewayInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def disableGatewayOutput(
      gatewayARN: Option[String] = None
    ): DisableGatewayOutput =
      DisableGatewayOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def disassociateFileSystemInput(
      fileSystemAssociationARN: Option[String] = None,
      forceDelete: Option[Boolean] = None
    ): DisassociateFileSystemInput =
      DisassociateFileSystemInput
        .builder
        .ifSome(fileSystemAssociationARN)(_.fileSystemAssociationARN(_))
        .ifSome(forceDelete)(_.forceDelete(_))
        .build

    def disassociateFileSystemOutput(
      fileSystemAssociationARN: Option[String] = None
    ): DisassociateFileSystemOutput =
      DisassociateFileSystemOutput
        .builder
        .ifSome(fileSystemAssociationARN)(_.fileSystemAssociationARN(_))
        .build

    def disk(
      diskId: Option[String] = None,
      diskPath: Option[String] = None,
      diskNode: Option[String] = None,
      diskStatus: Option[String] = None,
      diskSizeInBytes: Option[long] = None,
      diskAllocationType: Option[String] = None,
      diskAllocationResource: Option[String] = None,
      diskAttributeList: Option[List[DiskAttribute]] = None
    ): Disk =
      Disk
        .builder
        .ifSome(diskId)(_.diskId(_))
        .ifSome(diskPath)(_.diskPath(_))
        .ifSome(diskNode)(_.diskNode(_))
        .ifSome(diskStatus)(_.diskStatus(_))
        .ifSome(diskSizeInBytes)(_.diskSizeInBytes(_))
        .ifSome(diskAllocationType)(_.diskAllocationType(_))
        .ifSome(diskAllocationResource)(_.diskAllocationResource(_))
        .ifSome(diskAttributeList)(_.diskAttributeList(_))
        .build

    def fileShareInfo(
      fileShareType: Option[String] = None,
      fileShareARN: Option[String] = None,
      fileShareId: Option[String] = None,
      fileShareStatus: Option[String] = None,
      gatewayARN: Option[String] = None
    ): FileShareInfo =
      FileShareInfo
        .builder
        .ifSome(fileShareType)(_.fileShareType(_))
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(fileShareId)(_.fileShareId(_))
        .ifSome(fileShareStatus)(_.fileShareStatus(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def fileSystemAssociationInfo(
      fileSystemAssociationARN: Option[String] = None,
      locationARN: Option[String] = None,
      fileSystemAssociationStatus: Option[String] = None,
      auditDestinationARN: Option[String] = None,
      gatewayARN: Option[String] = None,
      tags: Option[List[Tag]] = None,
      cacheAttributes: Option[CacheAttributes] = None
    ): FileSystemAssociationInfo =
      FileSystemAssociationInfo
        .builder
        .ifSome(fileSystemAssociationARN)(_.fileSystemAssociationARN(_))
        .ifSome(locationARN)(_.locationARN(_))
        .ifSome(fileSystemAssociationStatus)(_.fileSystemAssociationStatus(_))
        .ifSome(auditDestinationARN)(_.auditDestinationARN(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .build

    def fileSystemAssociationSummary(
      fileSystemAssociationId: Option[String] = None,
      fileSystemAssociationARN: Option[String] = None,
      fileSystemAssociationStatus: Option[String] = None,
      gatewayARN: Option[String] = None
    ): FileSystemAssociationSummary =
      FileSystemAssociationSummary
        .builder
        .ifSome(fileSystemAssociationId)(_.fileSystemAssociationId(_))
        .ifSome(fileSystemAssociationARN)(_.fileSystemAssociationARN(_))
        .ifSome(fileSystemAssociationStatus)(_.fileSystemAssociationStatus(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def gatewayInfo(
      gatewayId: Option[String] = None,
      gatewayARN: Option[String] = None,
      gatewayType: Option[String] = None,
      gatewayOperationalState: Option[String] = None,
      gatewayName: Option[String] = None,
      ec2InstanceId: Option[String] = None,
      ec2InstanceRegion: Option[String] = None
    ): GatewayInfo =
      GatewayInfo
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(gatewayType)(_.gatewayType(_))
        .ifSome(gatewayOperationalState)(_.gatewayOperationalState(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .ifSome(ec2InstanceId)(_.ec2InstanceId(_))
        .ifSome(ec2InstanceRegion)(_.ec2InstanceRegion(_))
        .build

    def internalServerError(
      message: Option[String] = None,
      error: Option[StorageGatewayError] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(error)(_.error(_))
        .build

    def invalidGatewayRequestException(
      message: Option[String] = None,
      error: Option[StorageGatewayError] = None
    ): InvalidGatewayRequestException =
      InvalidGatewayRequestException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(error)(_.error(_))
        .build

    def joinDomainInput(
      gatewayARN: Option[String] = None,
      domainName: Option[String] = None,
      organizationalUnit: Option[String] = None,
      domainControllers: Option[List[Host]] = None,
      timeoutInSeconds: Option[Int] = None,
      userName: Option[String] = None,
      password: Option[String] = None
    ): JoinDomainInput =
      JoinDomainInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(organizationalUnit)(_.organizationalUnit(_))
        .ifSome(domainControllers)(_.domainControllers(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .build

    def joinDomainOutput(
      gatewayARN: Option[String] = None,
      activeDirectoryStatus: Option[String] = None
    ): JoinDomainOutput =
      JoinDomainOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(activeDirectoryStatus)(_.activeDirectoryStatus(_))
        .build

    def listAutomaticTapeCreationPoliciesInput(
      gatewayARN: Option[String] = None
    ): ListAutomaticTapeCreationPoliciesInput =
      ListAutomaticTapeCreationPoliciesInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def listAutomaticTapeCreationPoliciesOutput(
      automaticTapeCreationPolicyInfos: Option[List[AutomaticTapeCreationPolicyInfo]] = None
    ): ListAutomaticTapeCreationPoliciesOutput =
      ListAutomaticTapeCreationPoliciesOutput
        .builder
        .ifSome(automaticTapeCreationPolicyInfos)(_.automaticTapeCreationPolicyInfos(_))
        .build

    def listFileSharesInput(
      gatewayARN: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): ListFileSharesInput =
      ListFileSharesInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listFileSharesOutput(
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      fileShareInfoList: Option[List[FileShareInfo]] = None
    ): ListFileSharesOutput =
      ListFileSharesOutput
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(fileShareInfoList)(_.fileShareInfoList(_))
        .build

    def listFileSystemAssociationsInput(
      gatewayARN: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): ListFileSystemAssociationsInput =
      ListFileSystemAssociationsInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listFileSystemAssociationsOutput(
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      fileSystemAssociationSummaryList: Option[List[FileSystemAssociationSummary]] = None
    ): ListFileSystemAssociationsOutput =
      ListFileSystemAssociationsOutput
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(fileSystemAssociationSummaryList)(_.fileSystemAssociationSummaryList(_))
        .build

    def listGatewaysInput(
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): ListGatewaysInput =
      ListGatewaysInput
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listGatewaysOutput(
      gateways: Option[List[GatewayInfo]] = None,
      marker: Option[String] = None
    ): ListGatewaysOutput =
      ListGatewaysOutput
        .builder
        .ifSome(gateways)(_.gateways(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listLocalDisksInput(
      gatewayARN: Option[String] = None
    ): ListLocalDisksInput =
      ListLocalDisksInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def listLocalDisksOutput(
      gatewayARN: Option[String] = None,
      disks: Option[List[Disk]] = None
    ): ListLocalDisksOutput =
      ListLocalDisksOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(disks)(_.disks(_))
        .build

    def listTagsForResourceInput(
      resourceARN: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTagsForResourceOutput(
      resourceARN: Option[String] = None,
      marker: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listTapePoolsInput(
      poolARNs: Option[List[PoolARN]] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): ListTapePoolsInput =
      ListTapePoolsInput
        .builder
        .ifSome(poolARNs)(_.poolARNs(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTapePoolsOutput(
      poolInfos: Option[List[PoolInfo]] = None,
      marker: Option[String] = None
    ): ListTapePoolsOutput =
      ListTapePoolsOutput
        .builder
        .ifSome(poolInfos)(_.poolInfos(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listTapesInput(
      tapeARNs: Option[List[TapeARN]] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): ListTapesInput =
      ListTapesInput
        .builder
        .ifSome(tapeARNs)(_.tapeARNs(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTapesOutput(
      tapeInfos: Option[List[TapeInfo]] = None,
      marker: Option[String] = None
    ): ListTapesOutput =
      ListTapesOutput
        .builder
        .ifSome(tapeInfos)(_.tapeInfos(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listVolumeInitiatorsInput(
      volumeARN: Option[String] = None
    ): ListVolumeInitiatorsInput =
      ListVolumeInitiatorsInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def listVolumeInitiatorsOutput(
      initiators: Option[List[Initiator]] = None
    ): ListVolumeInitiatorsOutput =
      ListVolumeInitiatorsOutput
        .builder
        .ifSome(initiators)(_.initiators(_))
        .build

    def listVolumeRecoveryPointsInput(
      gatewayARN: Option[String] = None
    ): ListVolumeRecoveryPointsInput =
      ListVolumeRecoveryPointsInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def listVolumeRecoveryPointsOutput(
      gatewayARN: Option[String] = None,
      volumeRecoveryPointInfos: Option[List[VolumeRecoveryPointInfo]] = None
    ): ListVolumeRecoveryPointsOutput =
      ListVolumeRecoveryPointsOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(volumeRecoveryPointInfos)(_.volumeRecoveryPointInfos(_))
        .build

    def listVolumesInput(
      gatewayARN: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): ListVolumesInput =
      ListVolumesInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listVolumesOutput(
      gatewayARN: Option[String] = None,
      marker: Option[String] = None,
      volumeInfos: Option[List[VolumeInfo]] = None
    ): ListVolumesOutput =
      ListVolumesOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(volumeInfos)(_.volumeInfos(_))
        .build

    def nFSFileShareDefaults(
      fileMode: Option[String] = None,
      directoryMode: Option[String] = None,
      groupId: Option[PermissionId] = None,
      ownerId: Option[PermissionId] = None
    ): NFSFileShareDefaults =
      NFSFileShareDefaults
        .builder
        .ifSome(fileMode)(_.fileMode(_))
        .ifSome(directoryMode)(_.directoryMode(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .build

    def nFSFileShareInfo(
      nFSFileShareDefaults: Option[NFSFileShareDefaults] = None,
      fileShareARN: Option[String] = None,
      fileShareId: Option[String] = None,
      fileShareStatus: Option[String] = None,
      gatewayARN: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      path: Option[String] = None,
      role: Option[String] = None,
      locationARN: Option[String] = None,
      defaultStorageClass: Option[String] = None,
      objectACL: Option[String] = None,
      clientList: Option[List[IPV4AddressCIDR]] = None,
      squash: Option[String] = None,
      readOnly: Option[Boolean] = None,
      guessMIMETypeEnabled: Option[Boolean] = None,
      requesterPays: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      fileShareName: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None,
      notificationPolicy: Option[String] = None
    ): NFSFileShareInfo =
      NFSFileShareInfo
        .builder
        .ifSome(nFSFileShareDefaults)(_.nFSFileShareDefaults(_))
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(fileShareId)(_.fileShareId(_))
        .ifSome(fileShareStatus)(_.fileShareStatus(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(path)(_.path(_))
        .ifSome(role)(_.role(_))
        .ifSome(locationARN)(_.locationARN(_))
        .ifSome(defaultStorageClass)(_.defaultStorageClass(_))
        .ifSome(objectACL)(_.objectACL(_))
        .ifSome(clientList)(_.clientList(_))
        .ifSome(squash)(_.squash(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(guessMIMETypeEnabled)(_.guessMIMETypeEnabled(_))
        .ifSome(requesterPays)(_.requesterPays(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileShareName)(_.fileShareName(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .ifSome(notificationPolicy)(_.notificationPolicy(_))
        .build

    def networkInterface(
      ipv4Address: Option[String] = None,
      macAddress: Option[String] = None,
      ipv6Address: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(ipv4Address)(_.ipv4Address(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(ipv6Address)(_.ipv6Address(_))
        .build

    def notifyWhenUploadedInput(
      fileShareARN: Option[String] = None
    ): NotifyWhenUploadedInput =
      NotifyWhenUploadedInput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .build

    def notifyWhenUploadedOutput(
      fileShareARN: Option[String] = None,
      notificationId: Option[String] = None
    ): NotifyWhenUploadedOutput =
      NotifyWhenUploadedOutput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(notificationId)(_.notificationId(_))
        .build

    def poolInfo(
      poolARN: Option[String] = None,
      poolName: Option[String] = None,
      storageClass: Option[String] = None,
      retentionLockType: Option[String] = None,
      retentionLockTimeInDays: Option[Int] = None,
      poolStatus: Option[String] = None
    ): PoolInfo =
      PoolInfo
        .builder
        .ifSome(poolARN)(_.poolARN(_))
        .ifSome(poolName)(_.poolName(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(retentionLockType)(_.retentionLockType(_))
        .ifSome(retentionLockTimeInDays)(_.retentionLockTimeInDays(_))
        .ifSome(poolStatus)(_.poolStatus(_))
        .build

    def refreshCacheInput(
      fileShareARN: Option[String] = None,
      folderList: Option[List[Folder]] = None,
      recursive: Option[Boolean] = None
    ): RefreshCacheInput =
      RefreshCacheInput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(folderList)(_.folderList(_))
        .ifSome(recursive)(_.recursive(_))
        .build

    def refreshCacheOutput(
      fileShareARN: Option[String] = None,
      notificationId: Option[String] = None
    ): RefreshCacheOutput =
      RefreshCacheOutput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(notificationId)(_.notificationId(_))
        .build

    def removeTagsFromResourceInput(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): RemoveTagsFromResourceInput =
      RemoveTagsFromResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def removeTagsFromResourceOutput(
      resourceARN: Option[String] = None
    ): RemoveTagsFromResourceOutput =
      RemoveTagsFromResourceOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def resetCacheInput(
      gatewayARN: Option[String] = None
    ): ResetCacheInput =
      ResetCacheInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def resetCacheOutput(
      gatewayARN: Option[String] = None
    ): ResetCacheOutput =
      ResetCacheOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def retrieveTapeArchiveInput(
      tapeARN: Option[String] = None,
      gatewayARN: Option[String] = None
    ): RetrieveTapeArchiveInput =
      RetrieveTapeArchiveInput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def retrieveTapeArchiveOutput(
      tapeARN: Option[String] = None
    ): RetrieveTapeArchiveOutput =
      RetrieveTapeArchiveOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def retrieveTapeRecoveryPointInput(
      tapeARN: Option[String] = None,
      gatewayARN: Option[String] = None
    ): RetrieveTapeRecoveryPointInput =
      RetrieveTapeRecoveryPointInput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def retrieveTapeRecoveryPointOutput(
      tapeARN: Option[String] = None
    ): RetrieveTapeRecoveryPointOutput =
      RetrieveTapeRecoveryPointOutput
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .build

    def sMBFileShareInfo(
      fileShareARN: Option[String] = None,
      fileShareId: Option[String] = None,
      fileShareStatus: Option[String] = None,
      gatewayARN: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      path: Option[String] = None,
      role: Option[String] = None,
      locationARN: Option[String] = None,
      defaultStorageClass: Option[String] = None,
      objectACL: Option[String] = None,
      readOnly: Option[Boolean] = None,
      guessMIMETypeEnabled: Option[Boolean] = None,
      requesterPays: Option[Boolean] = None,
      sMBACLEnabled: Option[Boolean] = None,
      accessBasedEnumeration: Option[Boolean] = None,
      adminUserList: Option[List[UserListUser]] = None,
      validUserList: Option[List[UserListUser]] = None,
      invalidUserList: Option[List[UserListUser]] = None,
      auditDestinationARN: Option[String] = None,
      authentication: Option[String] = None,
      caseSensitivity: Option[String] = None,
      tags: Option[List[Tag]] = None,
      fileShareName: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None,
      notificationPolicy: Option[String] = None
    ): SMBFileShareInfo =
      SMBFileShareInfo
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(fileShareId)(_.fileShareId(_))
        .ifSome(fileShareStatus)(_.fileShareStatus(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(path)(_.path(_))
        .ifSome(role)(_.role(_))
        .ifSome(locationARN)(_.locationARN(_))
        .ifSome(defaultStorageClass)(_.defaultStorageClass(_))
        .ifSome(objectACL)(_.objectACL(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(guessMIMETypeEnabled)(_.guessMIMETypeEnabled(_))
        .ifSome(requesterPays)(_.requesterPays(_))
        .ifSome(sMBACLEnabled)(_.sMBACLEnabled(_))
        .ifSome(accessBasedEnumeration)(_.accessBasedEnumeration(_))
        .ifSome(adminUserList)(_.adminUserList(_))
        .ifSome(validUserList)(_.validUserList(_))
        .ifSome(invalidUserList)(_.invalidUserList(_))
        .ifSome(auditDestinationARN)(_.auditDestinationARN(_))
        .ifSome(authentication)(_.authentication(_))
        .ifSome(caseSensitivity)(_.caseSensitivity(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileShareName)(_.fileShareName(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .ifSome(notificationPolicy)(_.notificationPolicy(_))
        .build

    def serviceUnavailableError(
      message: Option[String] = None,
      error: Option[StorageGatewayError] = None
    ): ServiceUnavailableError =
      ServiceUnavailableError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(error)(_.error(_))
        .build

    def setLocalConsolePasswordInput(
      gatewayARN: Option[String] = None,
      localConsolePassword: Option[String] = None
    ): SetLocalConsolePasswordInput =
      SetLocalConsolePasswordInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(localConsolePassword)(_.localConsolePassword(_))
        .build

    def setLocalConsolePasswordOutput(
      gatewayARN: Option[String] = None
    ): SetLocalConsolePasswordOutput =
      SetLocalConsolePasswordOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def setSMBGuestPasswordInput(
      gatewayARN: Option[String] = None,
      password: Option[String] = None
    ): SetSMBGuestPasswordInput =
      SetSMBGuestPasswordInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(password)(_.password(_))
        .build

    def setSMBGuestPasswordOutput(
      gatewayARN: Option[String] = None
    ): SetSMBGuestPasswordOutput =
      SetSMBGuestPasswordOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def shutdownGatewayInput(
      gatewayARN: Option[String] = None
    ): ShutdownGatewayInput =
      ShutdownGatewayInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def shutdownGatewayOutput(
      gatewayARN: Option[String] = None
    ): ShutdownGatewayOutput =
      ShutdownGatewayOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def startAvailabilityMonitorTestInput(
      gatewayARN: Option[String] = None
    ): StartAvailabilityMonitorTestInput =
      StartAvailabilityMonitorTestInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def startAvailabilityMonitorTestOutput(
      gatewayARN: Option[String] = None
    ): StartAvailabilityMonitorTestOutput =
      StartAvailabilityMonitorTestOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def startGatewayInput(
      gatewayARN: Option[String] = None
    ): StartGatewayInput =
      StartGatewayInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def startGatewayOutput(
      gatewayARN: Option[String] = None
    ): StartGatewayOutput =
      StartGatewayOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def storageGatewayError(
      errorCode: Option[String] = None,
      errorDetails: Option[errorDetails] = None
    ): StorageGatewayError =
      StorageGatewayError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .build

    def storediSCSIVolume(
      volumeARN: Option[String] = None,
      volumeId: Option[String] = None,
      volumeType: Option[String] = None,
      volumeStatus: Option[String] = None,
      volumeAttachmentStatus: Option[String] = None,
      volumeSizeInBytes: Option[long] = None,
      volumeProgress: Option[DoubleObject] = None,
      volumeDiskId: Option[String] = None,
      sourceSnapshotId: Option[String] = None,
      preservedExistingData: Option[Boolean] = None,
      volumeiSCSIAttributes: Option[VolumeiSCSIAttributes] = None,
      createdDate: Option[CreatedDate] = None,
      volumeUsedInBytes: Option[VolumeUsedInBytes] = None,
      kMSKey: Option[String] = None,
      targetName: Option[String] = None
    ): StorediSCSIVolume =
      StorediSCSIVolume
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(volumeStatus)(_.volumeStatus(_))
        .ifSome(volumeAttachmentStatus)(_.volumeAttachmentStatus(_))
        .ifSome(volumeSizeInBytes)(_.volumeSizeInBytes(_))
        .ifSome(volumeProgress)(_.volumeProgress(_))
        .ifSome(volumeDiskId)(_.volumeDiskId(_))
        .ifSome(sourceSnapshotId)(_.sourceSnapshotId(_))
        .ifSome(preservedExistingData)(_.preservedExistingData(_))
        .ifSome(volumeiSCSIAttributes)(_.volumeiSCSIAttributes(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(volumeUsedInBytes)(_.volumeUsedInBytes(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(targetName)(_.targetName(_))
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

    def tape(
      tapeARN: Option[String] = None,
      tapeBarcode: Option[String] = None,
      tapeCreatedDate: Option[Time] = None,
      tapeSizeInBytes: Option[TapeSize] = None,
      tapeStatus: Option[String] = None,
      vTLDevice: Option[String] = None,
      progress: Option[DoubleObject] = None,
      tapeUsedInBytes: Option[TapeUsage] = None,
      kMSKey: Option[String] = None,
      poolId: Option[String] = None,
      worm: Option[Boolean] = None,
      retentionStartDate: Option[Time] = None,
      poolEntryDate: Option[Time] = None
    ): Tape =
      Tape
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(tapeBarcode)(_.tapeBarcode(_))
        .ifSome(tapeCreatedDate)(_.tapeCreatedDate(_))
        .ifSome(tapeSizeInBytes)(_.tapeSizeInBytes(_))
        .ifSome(tapeStatus)(_.tapeStatus(_))
        .ifSome(vTLDevice)(_.vTLDevice(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(tapeUsedInBytes)(_.tapeUsedInBytes(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(poolId)(_.poolId(_))
        .ifSome(worm)(_.worm(_))
        .ifSome(retentionStartDate)(_.retentionStartDate(_))
        .ifSome(poolEntryDate)(_.poolEntryDate(_))
        .build

    def tapeArchive(
      tapeARN: Option[String] = None,
      tapeBarcode: Option[String] = None,
      tapeCreatedDate: Option[Time] = None,
      tapeSizeInBytes: Option[TapeSize] = None,
      completionTime: Option[Time] = None,
      retrievedTo: Option[String] = None,
      tapeStatus: Option[String] = None,
      tapeUsedInBytes: Option[TapeUsage] = None,
      kMSKey: Option[String] = None,
      poolId: Option[String] = None,
      worm: Option[Boolean] = None,
      retentionStartDate: Option[Time] = None,
      poolEntryDate: Option[Time] = None
    ): TapeArchive =
      TapeArchive
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(tapeBarcode)(_.tapeBarcode(_))
        .ifSome(tapeCreatedDate)(_.tapeCreatedDate(_))
        .ifSome(tapeSizeInBytes)(_.tapeSizeInBytes(_))
        .ifSome(completionTime)(_.completionTime(_))
        .ifSome(retrievedTo)(_.retrievedTo(_))
        .ifSome(tapeStatus)(_.tapeStatus(_))
        .ifSome(tapeUsedInBytes)(_.tapeUsedInBytes(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(poolId)(_.poolId(_))
        .ifSome(worm)(_.worm(_))
        .ifSome(retentionStartDate)(_.retentionStartDate(_))
        .ifSome(poolEntryDate)(_.poolEntryDate(_))
        .build

    def tapeInfo(
      tapeARN: Option[String] = None,
      tapeBarcode: Option[String] = None,
      tapeSizeInBytes: Option[TapeSize] = None,
      tapeStatus: Option[String] = None,
      gatewayARN: Option[String] = None,
      poolId: Option[String] = None,
      retentionStartDate: Option[Time] = None,
      poolEntryDate: Option[Time] = None
    ): TapeInfo =
      TapeInfo
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(tapeBarcode)(_.tapeBarcode(_))
        .ifSome(tapeSizeInBytes)(_.tapeSizeInBytes(_))
        .ifSome(tapeStatus)(_.tapeStatus(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(poolId)(_.poolId(_))
        .ifSome(retentionStartDate)(_.retentionStartDate(_))
        .ifSome(poolEntryDate)(_.poolEntryDate(_))
        .build

    def tapeRecoveryPointInfo(
      tapeARN: Option[String] = None,
      tapeRecoveryPointTime: Option[Time] = None,
      tapeSizeInBytes: Option[TapeSize] = None,
      tapeStatus: Option[String] = None
    ): TapeRecoveryPointInfo =
      TapeRecoveryPointInfo
        .builder
        .ifSome(tapeARN)(_.tapeARN(_))
        .ifSome(tapeRecoveryPointTime)(_.tapeRecoveryPointTime(_))
        .ifSome(tapeSizeInBytes)(_.tapeSizeInBytes(_))
        .ifSome(tapeStatus)(_.tapeStatus(_))
        .build

    def updateAutomaticTapeCreationPolicyInput(
      automaticTapeCreationRules: Option[List[AutomaticTapeCreationRule]] = None,
      gatewayARN: Option[String] = None
    ): UpdateAutomaticTapeCreationPolicyInput =
      UpdateAutomaticTapeCreationPolicyInput
        .builder
        .ifSome(automaticTapeCreationRules)(_.automaticTapeCreationRules(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateAutomaticTapeCreationPolicyOutput(
      gatewayARN: Option[String] = None
    ): UpdateAutomaticTapeCreationPolicyOutput =
      UpdateAutomaticTapeCreationPolicyOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateBandwidthRateLimitInput(
      gatewayARN: Option[String] = None,
      averageUploadRateLimitInBitsPerSec: Option[BandwidthUploadRateLimit] = None,
      averageDownloadRateLimitInBitsPerSec: Option[BandwidthDownloadRateLimit] = None
    ): UpdateBandwidthRateLimitInput =
      UpdateBandwidthRateLimitInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(averageUploadRateLimitInBitsPerSec)(_.averageUploadRateLimitInBitsPerSec(_))
        .ifSome(averageDownloadRateLimitInBitsPerSec)(_.averageDownloadRateLimitInBitsPerSec(_))
        .build

    def updateBandwidthRateLimitOutput(
      gatewayARN: Option[String] = None
    ): UpdateBandwidthRateLimitOutput =
      UpdateBandwidthRateLimitOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateBandwidthRateLimitScheduleInput(
      gatewayARN: Option[String] = None,
      bandwidthRateLimitIntervals: Option[List[BandwidthRateLimitInterval]] = None
    ): UpdateBandwidthRateLimitScheduleInput =
      UpdateBandwidthRateLimitScheduleInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(bandwidthRateLimitIntervals)(_.bandwidthRateLimitIntervals(_))
        .build

    def updateBandwidthRateLimitScheduleOutput(
      gatewayARN: Option[String] = None
    ): UpdateBandwidthRateLimitScheduleOutput =
      UpdateBandwidthRateLimitScheduleOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateChapCredentialsInput(
      targetARN: Option[String] = None,
      secretToAuthenticateInitiator: Option[String] = None,
      initiatorName: Option[String] = None,
      secretToAuthenticateTarget: Option[String] = None
    ): UpdateChapCredentialsInput =
      UpdateChapCredentialsInput
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .ifSome(secretToAuthenticateInitiator)(_.secretToAuthenticateInitiator(_))
        .ifSome(initiatorName)(_.initiatorName(_))
        .ifSome(secretToAuthenticateTarget)(_.secretToAuthenticateTarget(_))
        .build

    def updateChapCredentialsOutput(
      targetARN: Option[String] = None,
      initiatorName: Option[String] = None
    ): UpdateChapCredentialsOutput =
      UpdateChapCredentialsOutput
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .ifSome(initiatorName)(_.initiatorName(_))
        .build

    def updateFileSystemAssociationInput(
      fileSystemAssociationARN: Option[String] = None,
      userName: Option[String] = None,
      password: Option[String] = None,
      auditDestinationARN: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None
    ): UpdateFileSystemAssociationInput =
      UpdateFileSystemAssociationInput
        .builder
        .ifSome(fileSystemAssociationARN)(_.fileSystemAssociationARN(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .ifSome(auditDestinationARN)(_.auditDestinationARN(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .build

    def updateFileSystemAssociationOutput(
      fileSystemAssociationARN: Option[String] = None
    ): UpdateFileSystemAssociationOutput =
      UpdateFileSystemAssociationOutput
        .builder
        .ifSome(fileSystemAssociationARN)(_.fileSystemAssociationARN(_))
        .build

    def updateGatewayInformationInput(
      gatewayARN: Option[String] = None,
      gatewayName: Option[String] = None,
      gatewayTimezone: Option[String] = None,
      cloudWatchLogGroupARN: Option[String] = None
    ): UpdateGatewayInformationInput =
      UpdateGatewayInformationInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .ifSome(gatewayTimezone)(_.gatewayTimezone(_))
        .ifSome(cloudWatchLogGroupARN)(_.cloudWatchLogGroupARN(_))
        .build

    def updateGatewayInformationOutput(
      gatewayARN: Option[String] = None,
      gatewayName: Option[String] = None
    ): UpdateGatewayInformationOutput =
      UpdateGatewayInformationOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .build

    def updateGatewaySoftwareNowInput(
      gatewayARN: Option[String] = None
    ): UpdateGatewaySoftwareNowInput =
      UpdateGatewaySoftwareNowInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateGatewaySoftwareNowOutput(
      gatewayARN: Option[String] = None
    ): UpdateGatewaySoftwareNowOutput =
      UpdateGatewaySoftwareNowOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateMaintenanceStartTimeInput(
      gatewayARN: Option[String] = None,
      hourOfDay: Option[Int] = None,
      minuteOfHour: Option[Int] = None,
      dayOfWeek: Option[Int] = None,
      dayOfMonth: Option[Int] = None
    ): UpdateMaintenanceStartTimeInput =
      UpdateMaintenanceStartTimeInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(hourOfDay)(_.hourOfDay(_))
        .ifSome(minuteOfHour)(_.minuteOfHour(_))
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .ifSome(dayOfMonth)(_.dayOfMonth(_))
        .build

    def updateMaintenanceStartTimeOutput(
      gatewayARN: Option[String] = None
    ): UpdateMaintenanceStartTimeOutput =
      UpdateMaintenanceStartTimeOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateNFSFileShareInput(
      fileShareARN: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      nFSFileShareDefaults: Option[NFSFileShareDefaults] = None,
      defaultStorageClass: Option[String] = None,
      objectACL: Option[String] = None,
      clientList: Option[List[IPV4AddressCIDR]] = None,
      squash: Option[String] = None,
      readOnly: Option[Boolean] = None,
      guessMIMETypeEnabled: Option[Boolean] = None,
      requesterPays: Option[Boolean] = None,
      fileShareName: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None,
      notificationPolicy: Option[String] = None
    ): UpdateNFSFileShareInput =
      UpdateNFSFileShareInput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(nFSFileShareDefaults)(_.nFSFileShareDefaults(_))
        .ifSome(defaultStorageClass)(_.defaultStorageClass(_))
        .ifSome(objectACL)(_.objectACL(_))
        .ifSome(clientList)(_.clientList(_))
        .ifSome(squash)(_.squash(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(guessMIMETypeEnabled)(_.guessMIMETypeEnabled(_))
        .ifSome(requesterPays)(_.requesterPays(_))
        .ifSome(fileShareName)(_.fileShareName(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .ifSome(notificationPolicy)(_.notificationPolicy(_))
        .build

    def updateNFSFileShareOutput(
      fileShareARN: Option[String] = None
    ): UpdateNFSFileShareOutput =
      UpdateNFSFileShareOutput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .build

    def updateSMBFileShareInput(
      fileShareARN: Option[String] = None,
      kMSEncrypted: Option[Boolean] = None,
      kMSKey: Option[String] = None,
      defaultStorageClass: Option[String] = None,
      objectACL: Option[String] = None,
      readOnly: Option[Boolean] = None,
      guessMIMETypeEnabled: Option[Boolean] = None,
      requesterPays: Option[Boolean] = None,
      sMBACLEnabled: Option[Boolean] = None,
      accessBasedEnumeration: Option[Boolean] = None,
      adminUserList: Option[List[UserListUser]] = None,
      validUserList: Option[List[UserListUser]] = None,
      invalidUserList: Option[List[UserListUser]] = None,
      auditDestinationARN: Option[String] = None,
      caseSensitivity: Option[String] = None,
      fileShareName: Option[String] = None,
      cacheAttributes: Option[CacheAttributes] = None,
      notificationPolicy: Option[String] = None
    ): UpdateSMBFileShareInput =
      UpdateSMBFileShareInput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .ifSome(kMSEncrypted)(_.kMSEncrypted(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(defaultStorageClass)(_.defaultStorageClass(_))
        .ifSome(objectACL)(_.objectACL(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(guessMIMETypeEnabled)(_.guessMIMETypeEnabled(_))
        .ifSome(requesterPays)(_.requesterPays(_))
        .ifSome(sMBACLEnabled)(_.sMBACLEnabled(_))
        .ifSome(accessBasedEnumeration)(_.accessBasedEnumeration(_))
        .ifSome(adminUserList)(_.adminUserList(_))
        .ifSome(validUserList)(_.validUserList(_))
        .ifSome(invalidUserList)(_.invalidUserList(_))
        .ifSome(auditDestinationARN)(_.auditDestinationARN(_))
        .ifSome(caseSensitivity)(_.caseSensitivity(_))
        .ifSome(fileShareName)(_.fileShareName(_))
        .ifSome(cacheAttributes)(_.cacheAttributes(_))
        .ifSome(notificationPolicy)(_.notificationPolicy(_))
        .build

    def updateSMBFileShareOutput(
      fileShareARN: Option[String] = None
    ): UpdateSMBFileShareOutput =
      UpdateSMBFileShareOutput
        .builder
        .ifSome(fileShareARN)(_.fileShareARN(_))
        .build

    def updateSMBFileShareVisibilityInput(
      gatewayARN: Option[String] = None,
      fileSharesVisible: Option[Boolean] = None
    ): UpdateSMBFileShareVisibilityInput =
      UpdateSMBFileShareVisibilityInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(fileSharesVisible)(_.fileSharesVisible(_))
        .build

    def updateSMBFileShareVisibilityOutput(
      gatewayARN: Option[String] = None
    ): UpdateSMBFileShareVisibilityOutput =
      UpdateSMBFileShareVisibilityOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateSMBSecurityStrategyInput(
      gatewayARN: Option[String] = None,
      sMBSecurityStrategy: Option[String] = None
    ): UpdateSMBSecurityStrategyInput =
      UpdateSMBSecurityStrategyInput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(sMBSecurityStrategy)(_.sMBSecurityStrategy(_))
        .build

    def updateSMBSecurityStrategyOutput(
      gatewayARN: Option[String] = None
    ): UpdateSMBSecurityStrategyOutput =
      UpdateSMBSecurityStrategyOutput
        .builder
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .build

    def updateSnapshotScheduleInput(
      volumeARN: Option[String] = None,
      startAt: Option[Int] = None,
      recurrenceInHours: Option[Int] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): UpdateSnapshotScheduleInput =
      UpdateSnapshotScheduleInput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(startAt)(_.startAt(_))
        .ifSome(recurrenceInHours)(_.recurrenceInHours(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateSnapshotScheduleOutput(
      volumeARN: Option[String] = None
    ): UpdateSnapshotScheduleOutput =
      UpdateSnapshotScheduleOutput
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .build

    def updateVTLDeviceTypeInput(
      vTLDeviceARN: Option[String] = None,
      deviceType: Option[String] = None
    ): UpdateVTLDeviceTypeInput =
      UpdateVTLDeviceTypeInput
        .builder
        .ifSome(vTLDeviceARN)(_.vTLDeviceARN(_))
        .ifSome(deviceType)(_.deviceType(_))
        .build

    def updateVTLDeviceTypeOutput(
      vTLDeviceARN: Option[String] = None
    ): UpdateVTLDeviceTypeOutput =
      UpdateVTLDeviceTypeOutput
        .builder
        .ifSome(vTLDeviceARN)(_.vTLDeviceARN(_))
        .build

    def vTLDevice(
      vTLDeviceARN: Option[String] = None,
      vTLDeviceType: Option[String] = None,
      vTLDeviceVendor: Option[String] = None,
      vTLDeviceProductIdentifier: Option[String] = None,
      deviceiSCSIAttributes: Option[DeviceiSCSIAttributes] = None
    ): VTLDevice =
      VTLDevice
        .builder
        .ifSome(vTLDeviceARN)(_.vTLDeviceARN(_))
        .ifSome(vTLDeviceType)(_.vTLDeviceType(_))
        .ifSome(vTLDeviceVendor)(_.vTLDeviceVendor(_))
        .ifSome(vTLDeviceProductIdentifier)(_.vTLDeviceProductIdentifier(_))
        .ifSome(deviceiSCSIAttributes)(_.deviceiSCSIAttributes(_))
        .build

    def volumeInfo(
      volumeARN: Option[String] = None,
      volumeId: Option[String] = None,
      gatewayARN: Option[String] = None,
      gatewayId: Option[String] = None,
      volumeType: Option[String] = None,
      volumeSizeInBytes: Option[long] = None,
      volumeAttachmentStatus: Option[String] = None
    ): VolumeInfo =
      VolumeInfo
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(gatewayARN)(_.gatewayARN(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(volumeSizeInBytes)(_.volumeSizeInBytes(_))
        .ifSome(volumeAttachmentStatus)(_.volumeAttachmentStatus(_))
        .build

    def volumeRecoveryPointInfo(
      volumeARN: Option[String] = None,
      volumeSizeInBytes: Option[long] = None,
      volumeUsageInBytes: Option[long] = None,
      volumeRecoveryPointTime: Option[String] = None
    ): VolumeRecoveryPointInfo =
      VolumeRecoveryPointInfo
        .builder
        .ifSome(volumeARN)(_.volumeARN(_))
        .ifSome(volumeSizeInBytes)(_.volumeSizeInBytes(_))
        .ifSome(volumeUsageInBytes)(_.volumeUsageInBytes(_))
        .ifSome(volumeRecoveryPointTime)(_.volumeRecoveryPointTime(_))
        .build

    def volumeiSCSIAttributes(
      targetARN: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      networkInterfacePort: Option[Int] = None,
      lunNumber: Option[Int] = None,
      chapEnabled: Option[Boolean] = None
    ): VolumeiSCSIAttributes =
      VolumeiSCSIAttributes
        .builder
        .ifSome(targetARN)(_.targetARN(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(networkInterfacePort)(_.networkInterfacePort(_))
        .ifSome(lunNumber)(_.lunNumber(_))
        .ifSome(chapEnabled)(_.chapEnabled(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
