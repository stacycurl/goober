package goober.hi

import goober.free.cloudhsmv2.CloudHsmV2IO
import software.amazon.awssdk.services.cloudhsmv2.model._


object cloudhsmv2 {
  import goober.free.{cloudhsmv2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def backup(
      backupId: Option[String] = None,
      backupState: Option[String] = None,
      clusterId: Option[String] = None,
      createTimestamp: Option[Timestamp] = None,
      copyTimestamp: Option[Timestamp] = None,
      neverExpires: Option[Boolean] = None,
      sourceRegion: Option[String] = None,
      sourceBackup: Option[String] = None,
      sourceCluster: Option[String] = None,
      deleteTimestamp: Option[Timestamp] = None,
      tagList: Option[List[Tag]] = None
    ): Backup =
      Backup
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(backupState)(_.backupState(_))
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .ifSome(copyTimestamp)(_.copyTimestamp(_))
        .ifSome(neverExpires)(_.neverExpires(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(sourceBackup)(_.sourceBackup(_))
        .ifSome(sourceCluster)(_.sourceCluster(_))
        .ifSome(deleteTimestamp)(_.deleteTimestamp(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def backupRetentionPolicy(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): BackupRetentionPolicy =
      BackupRetentionPolicy
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def certificates(
      clusterCsr: Option[String] = None,
      hsmCertificate: Option[String] = None,
      awsHardwareCertificate: Option[String] = None,
      manufacturerHardwareCertificate: Option[String] = None,
      clusterCertificate: Option[String] = None
    ): Certificates =
      Certificates
        .builder
        .ifSome(clusterCsr)(_.clusterCsr(_))
        .ifSome(hsmCertificate)(_.hsmCertificate(_))
        .ifSome(awsHardwareCertificate)(_.awsHardwareCertificate(_))
        .ifSome(manufacturerHardwareCertificate)(_.manufacturerHardwareCertificate(_))
        .ifSome(clusterCertificate)(_.clusterCertificate(_))
        .build

    def cloudHsmAccessDeniedException(
      message: Option[String] = None
    ): CloudHsmAccessDeniedException =
      CloudHsmAccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmInternalFailureException(
      message: Option[String] = None
    ): CloudHsmInternalFailureException =
      CloudHsmInternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmInvalidRequestException(
      message: Option[String] = None
    ): CloudHsmInvalidRequestException =
      CloudHsmInvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmResourceNotFoundException(
      message: Option[String] = None
    ): CloudHsmResourceNotFoundException =
      CloudHsmResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmServiceException(
      message: Option[String] = None
    ): CloudHsmServiceException =
      CloudHsmServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmTagException(
      message: Option[String] = None
    ): CloudHsmTagException =
      CloudHsmTagException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cluster(
      backupPolicy: Option[String] = None,
      backupRetentionPolicy: Option[BackupRetentionPolicy] = None,
      clusterId: Option[String] = None,
      createTimestamp: Option[Timestamp] = None,
      hsms: Option[List[Hsm]] = None,
      hsmType: Option[String] = None,
      preCoPassword: Option[String] = None,
      securityGroup: Option[String] = None,
      sourceBackupId: Option[String] = None,
      state: Option[String] = None,
      stateMessage: Option[String] = None,
      subnetMapping: Option[ExternalSubnetMapping] = None,
      vpcId: Option[String] = None,
      certificates: Option[Certificates] = None,
      tagList: Option[List[Tag]] = None
    ): Cluster =
      Cluster
        .builder
        .ifSome(backupPolicy)(_.backupPolicy(_))
        .ifSome(backupRetentionPolicy)(_.backupRetentionPolicy(_))
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .ifSome(hsms)(_.hsms(_))
        .ifSome(hsmType)(_.hsmType(_))
        .ifSome(preCoPassword)(_.preCoPassword(_))
        .ifSome(securityGroup)(_.securityGroup(_))
        .ifSome(sourceBackupId)(_.sourceBackupId(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateMessage)(_.stateMessage(_))
        .ifSome(subnetMapping)(_.subnetMapping(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(certificates)(_.certificates(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def copyBackupToRegionRequest(
      destinationRegion: Option[String] = None,
      backupId: Option[String] = None,
      tagList: Option[List[Tag]] = None
    ): CopyBackupToRegionRequest =
      CopyBackupToRegionRequest
        .builder
        .ifSome(destinationRegion)(_.destinationRegion(_))
        .ifSome(backupId)(_.backupId(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def copyBackupToRegionResponse(
      destinationBackup: Option[DestinationBackup] = None
    ): CopyBackupToRegionResponse =
      CopyBackupToRegionResponse
        .builder
        .ifSome(destinationBackup)(_.destinationBackup(_))
        .build

    def createClusterRequest(
      backupRetentionPolicy: Option[BackupRetentionPolicy] = None,
      hsmType: Option[String] = None,
      sourceBackupId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      tagList: Option[List[Tag]] = None
    ): CreateClusterRequest =
      CreateClusterRequest
        .builder
        .ifSome(backupRetentionPolicy)(_.backupRetentionPolicy(_))
        .ifSome(hsmType)(_.hsmType(_))
        .ifSome(sourceBackupId)(_.sourceBackupId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def createClusterResponse(
      cluster: Option[Cluster] = None
    ): CreateClusterResponse =
      CreateClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def createHsmRequest(
      clusterId: Option[String] = None,
      availabilityZone: Option[String] = None,
      ipAddress: Option[String] = None
    ): CreateHsmRequest =
      CreateHsmRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .build

    def createHsmResponse(
      hsm: Option[Hsm] = None
    ): CreateHsmResponse =
      CreateHsmResponse
        .builder
        .ifSome(hsm)(_.hsm(_))
        .build

    def deleteBackupRequest(
      backupId: Option[String] = None
    ): DeleteBackupRequest =
      DeleteBackupRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .build

    def deleteBackupResponse(
      backup: Option[Backup] = None
    ): DeleteBackupResponse =
      DeleteBackupResponse
        .builder
        .ifSome(backup)(_.backup(_))
        .build

    def deleteClusterRequest(
      clusterId: Option[String] = None
    ): DeleteClusterRequest =
      DeleteClusterRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def deleteClusterResponse(
      cluster: Option[Cluster] = None
    ): DeleteClusterResponse =
      DeleteClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def deleteHsmRequest(
      clusterId: Option[String] = None,
      hsmId: Option[String] = None,
      eniId: Option[String] = None,
      eniIp: Option[String] = None
    ): DeleteHsmRequest =
      DeleteHsmRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(hsmId)(_.hsmId(_))
        .ifSome(eniId)(_.eniId(_))
        .ifSome(eniIp)(_.eniIp(_))
        .build

    def deleteHsmResponse(
      hsmId: Option[String] = None
    ): DeleteHsmResponse =
      DeleteHsmResponse
        .builder
        .ifSome(hsmId)(_.hsmId(_))
        .build

    def describeBackupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[Filters] = None,
      sortAscending: Option[Boolean] = None
    ): DescribeBackupsRequest =
      DescribeBackupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortAscending)(_.sortAscending(_))
        .build

    def describeBackupsResponse(
      backups: Option[List[Backup]] = None,
      nextToken: Option[String] = None
    ): DescribeBackupsResponse =
      DescribeBackupsResponse
        .builder
        .ifSome(backups)(_.backups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClustersRequest(
      filters: Option[Filters] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeClustersRequest =
      DescribeClustersRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeClustersResponse(
      clusters: Option[List[Cluster]] = None,
      nextToken: Option[String] = None
    ): DescribeClustersResponse =
      DescribeClustersResponse
        .builder
        .ifSome(clusters)(_.clusters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def destinationBackup(
      createTimestamp: Option[Timestamp] = None,
      sourceRegion: Option[String] = None,
      sourceBackup: Option[String] = None,
      sourceCluster: Option[String] = None
    ): DestinationBackup =
      DestinationBackup
        .builder
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(sourceBackup)(_.sourceBackup(_))
        .ifSome(sourceCluster)(_.sourceCluster(_))
        .build

    def hsm(
      availabilityZone: Option[String] = None,
      clusterId: Option[String] = None,
      subnetId: Option[String] = None,
      eniId: Option[String] = None,
      eniIp: Option[String] = None,
      hsmId: Option[String] = None,
      state: Option[String] = None,
      stateMessage: Option[String] = None
    ): Hsm =
      Hsm
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(eniId)(_.eniId(_))
        .ifSome(eniIp)(_.eniIp(_))
        .ifSome(hsmId)(_.hsmId(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateMessage)(_.stateMessage(_))
        .build

    def initializeClusterRequest(
      clusterId: Option[String] = None,
      signedCert: Option[String] = None,
      trustAnchor: Option[String] = None
    ): InitializeClusterRequest =
      InitializeClusterRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(signedCert)(_.signedCert(_))
        .ifSome(trustAnchor)(_.trustAnchor(_))
        .build

    def initializeClusterResponse(
      state: Option[String] = None,
      stateMessage: Option[String] = None
    ): InitializeClusterResponse =
      InitializeClusterResponse
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateMessage)(_.stateMessage(_))
        .build

    def listTagsRequest(
      resourceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsResponse(
      tagList: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(tagList)(_.tagList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def modifyBackupAttributesRequest(
      backupId: Option[String] = None,
      neverExpires: Option[Boolean] = None
    ): ModifyBackupAttributesRequest =
      ModifyBackupAttributesRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(neverExpires)(_.neverExpires(_))
        .build

    def modifyBackupAttributesResponse(
      backup: Option[Backup] = None
    ): ModifyBackupAttributesResponse =
      ModifyBackupAttributesResponse
        .builder
        .ifSome(backup)(_.backup(_))
        .build

    def modifyClusterRequest(
      backupRetentionPolicy: Option[BackupRetentionPolicy] = None,
      clusterId: Option[String] = None
    ): ModifyClusterRequest =
      ModifyClusterRequest
        .builder
        .ifSome(backupRetentionPolicy)(_.backupRetentionPolicy(_))
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def modifyClusterResponse(
      cluster: Option[Cluster] = None
    ): ModifyClusterResponse =
      ModifyClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def restoreBackupRequest(
      backupId: Option[String] = None
    ): RestoreBackupRequest =
      RestoreBackupRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .build

    def restoreBackupResponse(
      backup: Option[Backup] = None
    ): RestoreBackupResponse =
      RestoreBackupResponse
        .builder
        .ifSome(backup)(_.backup(_))
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
      tagList: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def untagResourceRequest(
      resourceId: Option[String] = None,
      tagKeyList: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagKeyList)(_.tagKeyList(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
