package goober.hi

import goober.free.directory.DirectoryIO
import software.amazon.awssdk.services.directory.model._


object directory {
  import goober.free.{directory ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptSharedDirectoryRequest(
      sharedDirectoryId: Option[String] = None
    ): AcceptSharedDirectoryRequest =
      AcceptSharedDirectoryRequest
        .builder
        .ifSome(sharedDirectoryId)(_.sharedDirectoryId(_))
        .build

    def accessDeniedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def addIpRoutesRequest(
      directoryId: Option[String] = None,
      ipRoutes: Option[List[IpRoute]] = None,
      updateSecurityGroupForDirectoryControllers: Option[Boolean] = None
    ): AddIpRoutesRequest =
      AddIpRoutesRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(ipRoutes)(_.ipRoutes(_))
        .ifSome(updateSecurityGroupForDirectoryControllers)(_.updateSecurityGroupForDirectoryControllers(_))
        .build

    def addRegionRequest(
      directoryId: Option[String] = None,
      regionName: Option[String] = None,
      vPCSettings: Option[DirectoryVpcSettings] = None
    ): AddRegionRequest =
      AddRegionRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(vPCSettings)(_.vPCSettings(_))
        .build

    def addTagsToResourceRequest(
      resourceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsToResourceRequest =
      AddTagsToResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def attribute(
      name: Option[String] = None,
      value: Option[String] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def authenticationFailedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): AuthenticationFailedException =
      AuthenticationFailedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def cancelSchemaExtensionRequest(
      directoryId: Option[String] = None,
      schemaExtensionId: Option[String] = None
    ): CancelSchemaExtensionRequest =
      CancelSchemaExtensionRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(schemaExtensionId)(_.schemaExtensionId(_))
        .build

    def certificate(
      certificateId: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      commonName: Option[String] = None,
      registeredDateTime: Option[CertificateRegisteredDateTime] = None,
      expiryDateTime: Option[CertificateExpiryDateTime] = None,
      `type`: Option[String] = None,
      clientCertAuthSettings: Option[ClientCertAuthSettings] = None
    ): Certificate =
      Certificate
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(commonName)(_.commonName(_))
        .ifSome(registeredDateTime)(_.registeredDateTime(_))
        .ifSome(expiryDateTime)(_.expiryDateTime(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(clientCertAuthSettings)(_.clientCertAuthSettings(_))
        .build

    def certificateAlreadyExistsException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): CertificateAlreadyExistsException =
      CertificateAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def certificateDoesNotExistException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): CertificateDoesNotExistException =
      CertificateDoesNotExistException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def certificateInUseException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): CertificateInUseException =
      CertificateInUseException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def certificateInfo(
      certificateId: Option[String] = None,
      commonName: Option[String] = None,
      state: Option[String] = None,
      expiryDateTime: Option[CertificateExpiryDateTime] = None,
      `type`: Option[String] = None
    ): CertificateInfo =
      CertificateInfo
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(commonName)(_.commonName(_))
        .ifSome(state)(_.state(_))
        .ifSome(expiryDateTime)(_.expiryDateTime(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def certificateLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): CertificateLimitExceededException =
      CertificateLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def clientCertAuthSettings(
      oCSPUrl: Option[String] = None
    ): ClientCertAuthSettings =
      ClientCertAuthSettings
        .builder
        .ifSome(oCSPUrl)(_.oCSPUrl(_))
        .build

    def clientException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ClientException =
      ClientException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def computer(
      computerId: Option[String] = None,
      computerName: Option[String] = None,
      computerAttributes: Option[List[Attribute]] = None
    ): Computer =
      Computer
        .builder
        .ifSome(computerId)(_.computerId(_))
        .ifSome(computerName)(_.computerName(_))
        .ifSome(computerAttributes)(_.computerAttributes(_))
        .build

    def conditionalForwarder(
      remoteDomainName: Option[String] = None,
      dnsIpAddrs: Option[List[IpAddr]] = None,
      replicationScope: Option[String] = None
    ): ConditionalForwarder =
      ConditionalForwarder
        .builder
        .ifSome(remoteDomainName)(_.remoteDomainName(_))
        .ifSome(dnsIpAddrs)(_.dnsIpAddrs(_))
        .ifSome(replicationScope)(_.replicationScope(_))
        .build

    def connectDirectoryRequest(
      name: Option[String] = None,
      shortName: Option[String] = None,
      password: Option[String] = None,
      description: Option[String] = None,
      size: Option[String] = None,
      connectSettings: Option[DirectoryConnectSettings] = None,
      tags: Option[List[Tag]] = None
    ): ConnectDirectoryRequest =
      ConnectDirectoryRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(shortName)(_.shortName(_))
        .ifSome(password)(_.password(_))
        .ifSome(description)(_.description(_))
        .ifSome(size)(_.size(_))
        .ifSome(connectSettings)(_.connectSettings(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAliasRequest(
      directoryId: Option[String] = None,
      alias: Option[String] = None
    ): CreateAliasRequest =
      CreateAliasRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(alias)(_.alias(_))
        .build

    def createComputerRequest(
      directoryId: Option[String] = None,
      computerName: Option[String] = None,
      password: Option[String] = None,
      organizationalUnitDistinguishedName: Option[String] = None,
      computerAttributes: Option[List[Attribute]] = None
    ): CreateComputerRequest =
      CreateComputerRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(computerName)(_.computerName(_))
        .ifSome(password)(_.password(_))
        .ifSome(organizationalUnitDistinguishedName)(_.organizationalUnitDistinguishedName(_))
        .ifSome(computerAttributes)(_.computerAttributes(_))
        .build

    def createConditionalForwarderRequest(
      directoryId: Option[String] = None,
      remoteDomainName: Option[String] = None,
      dnsIpAddrs: Option[List[IpAddr]] = None
    ): CreateConditionalForwarderRequest =
      CreateConditionalForwarderRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(remoteDomainName)(_.remoteDomainName(_))
        .ifSome(dnsIpAddrs)(_.dnsIpAddrs(_))
        .build

    def createDirectoryRequest(
      name: Option[String] = None,
      shortName: Option[String] = None,
      password: Option[String] = None,
      description: Option[String] = None,
      size: Option[String] = None,
      vpcSettings: Option[DirectoryVpcSettings] = None,
      tags: Option[List[Tag]] = None
    ): CreateDirectoryRequest =
      CreateDirectoryRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(shortName)(_.shortName(_))
        .ifSome(password)(_.password(_))
        .ifSome(description)(_.description(_))
        .ifSome(size)(_.size(_))
        .ifSome(vpcSettings)(_.vpcSettings(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLogSubscriptionRequest(
      directoryId: Option[String] = None,
      logGroupName: Option[String] = None
    ): CreateLogSubscriptionRequest =
      CreateLogSubscriptionRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def createMicrosoftADRequest(
      name: Option[String] = None,
      shortName: Option[String] = None,
      password: Option[String] = None,
      description: Option[String] = None,
      vpcSettings: Option[DirectoryVpcSettings] = None,
      edition: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateMicrosoftADRequest =
      CreateMicrosoftADRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(shortName)(_.shortName(_))
        .ifSome(password)(_.password(_))
        .ifSome(description)(_.description(_))
        .ifSome(vpcSettings)(_.vpcSettings(_))
        .ifSome(edition)(_.edition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSnapshotRequest(
      directoryId: Option[String] = None,
      name: Option[String] = None
    ): CreateSnapshotRequest =
      CreateSnapshotRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(name)(_.name(_))
        .build

    def createTrustRequest(
      directoryId: Option[String] = None,
      remoteDomainName: Option[String] = None,
      trustPassword: Option[String] = None,
      trustDirection: Option[String] = None,
      trustType: Option[String] = None,
      conditionalForwarderIpAddrs: Option[List[IpAddr]] = None,
      selectiveAuth: Option[String] = None
    ): CreateTrustRequest =
      CreateTrustRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(remoteDomainName)(_.remoteDomainName(_))
        .ifSome(trustPassword)(_.trustPassword(_))
        .ifSome(trustDirection)(_.trustDirection(_))
        .ifSome(trustType)(_.trustType(_))
        .ifSome(conditionalForwarderIpAddrs)(_.conditionalForwarderIpAddrs(_))
        .ifSome(selectiveAuth)(_.selectiveAuth(_))
        .build

    def deleteConditionalForwarderRequest(
      directoryId: Option[String] = None,
      remoteDomainName: Option[String] = None
    ): DeleteConditionalForwarderRequest =
      DeleteConditionalForwarderRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(remoteDomainName)(_.remoteDomainName(_))
        .build

    def deleteDirectoryRequest(
      directoryId: Option[String] = None
    ): DeleteDirectoryRequest =
      DeleteDirectoryRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def deleteLogSubscriptionRequest(
      directoryId: Option[String] = None
    ): DeleteLogSubscriptionRequest =
      DeleteLogSubscriptionRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def deleteSnapshotRequest(
      snapshotId: Option[String] = None
    ): DeleteSnapshotRequest =
      DeleteSnapshotRequest
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .build

    def deleteTrustRequest(
      trustId: Option[String] = None,
      deleteAssociatedConditionalForwarder: Option[Boolean] = None
    ): DeleteTrustRequest =
      DeleteTrustRequest
        .builder
        .ifSome(trustId)(_.trustId(_))
        .ifSome(deleteAssociatedConditionalForwarder)(_.deleteAssociatedConditionalForwarder(_))
        .build

    def deregisterCertificateRequest(
      directoryId: Option[String] = None,
      certificateId: Option[String] = None
    ): DeregisterCertificateRequest =
      DeregisterCertificateRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def deregisterEventTopicRequest(
      directoryId: Option[String] = None,
      topicName: Option[String] = None
    ): DeregisterEventTopicRequest =
      DeregisterEventTopicRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(topicName)(_.topicName(_))
        .build

    def describeCertificateRequest(
      directoryId: Option[String] = None,
      certificateId: Option[String] = None
    ): DescribeCertificateRequest =
      DescribeCertificateRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def describeConditionalForwardersRequest(
      directoryId: Option[String] = None,
      remoteDomainNames: Option[List[RemoteDomainName]] = None
    ): DescribeConditionalForwardersRequest =
      DescribeConditionalForwardersRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(remoteDomainNames)(_.remoteDomainNames(_))
        .build

    def describeDirectoriesRequest(
      directoryIds: Option[List[DirectoryId]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeDirectoriesRequest =
      DescribeDirectoriesRequest
        .builder
        .ifSome(directoryIds)(_.directoryIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeDomainControllersRequest(
      directoryId: Option[String] = None,
      domainControllerIds: Option[List[DomainControllerId]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeDomainControllersRequest =
      DescribeDomainControllersRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(domainControllerIds)(_.domainControllerIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeEventTopicsRequest(
      directoryId: Option[String] = None,
      topicNames: Option[List[TopicName]] = None
    ): DescribeEventTopicsRequest =
      DescribeEventTopicsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(topicNames)(_.topicNames(_))
        .build

    def describeLDAPSSettingsRequest(
      directoryId: Option[String] = None,
      `type`: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeLDAPSSettingsRequest =
      DescribeLDAPSSettingsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeRegionsRequest(
      directoryId: Option[String] = None,
      regionName: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeRegionsRequest =
      DescribeRegionsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSharedDirectoriesRequest(
      ownerDirectoryId: Option[String] = None,
      sharedDirectoryIds: Option[List[DirectoryId]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeSharedDirectoriesRequest =
      DescribeSharedDirectoriesRequest
        .builder
        .ifSome(ownerDirectoryId)(_.ownerDirectoryId(_))
        .ifSome(sharedDirectoryIds)(_.sharedDirectoryIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeSnapshotsRequest(
      directoryId: Option[String] = None,
      snapshotIds: Option[List[SnapshotId]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeSnapshotsRequest =
      DescribeSnapshotsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(snapshotIds)(_.snapshotIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeTrustsRequest(
      directoryId: Option[String] = None,
      trustIds: Option[List[TrustId]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeTrustsRequest =
      DescribeTrustsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(trustIds)(_.trustIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def directoryAlreadyInRegionException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DirectoryAlreadyInRegionException =
      DirectoryAlreadyInRegionException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def directoryAlreadySharedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DirectoryAlreadySharedException =
      DirectoryAlreadySharedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def directoryConnectSettings(
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      customerDnsIps: Option[List[IpAddr]] = None,
      customerUserName: Option[String] = None
    ): DirectoryConnectSettings =
      DirectoryConnectSettings
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(customerDnsIps)(_.customerDnsIps(_))
        .ifSome(customerUserName)(_.customerUserName(_))
        .build

    def directoryConnectSettingsDescription(
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      customerUserName: Option[String] = None,
      securityGroupId: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None,
      connectIps: Option[List[IpAddr]] = None
    ): DirectoryConnectSettingsDescription =
      DirectoryConnectSettingsDescription
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(customerUserName)(_.customerUserName(_))
        .ifSome(securityGroupId)(_.securityGroupId(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(connectIps)(_.connectIps(_))
        .build

    def directoryDescription(
      directoryId: Option[String] = None,
      name: Option[String] = None,
      shortName: Option[String] = None,
      size: Option[String] = None,
      edition: Option[String] = None,
      alias: Option[String] = None,
      accessUrl: Option[String] = None,
      description: Option[String] = None,
      dnsIpAddrs: Option[List[IpAddr]] = None,
      stage: Option[String] = None,
      shareStatus: Option[String] = None,
      shareMethod: Option[String] = None,
      shareNotes: Option[String] = None,
      launchTime: Option[LaunchTime] = None,
      stageLastUpdatedDateTime: Option[LastUpdatedDateTime] = None,
      `type`: Option[String] = None,
      vpcSettings: Option[DirectoryVpcSettingsDescription] = None,
      connectSettings: Option[DirectoryConnectSettingsDescription] = None,
      radiusSettings: Option[RadiusSettings] = None,
      radiusStatus: Option[String] = None,
      stageReason: Option[String] = None,
      ssoEnabled: Option[Boolean] = None,
      desiredNumberOfDomainControllers: Option[Int] = None,
      ownerDirectoryDescription: Option[OwnerDirectoryDescription] = None,
      regionsInfo: Option[RegionsInfo] = None
    ): DirectoryDescription =
      DirectoryDescription
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(name)(_.name(_))
        .ifSome(shortName)(_.shortName(_))
        .ifSome(size)(_.size(_))
        .ifSome(edition)(_.edition(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(accessUrl)(_.accessUrl(_))
        .ifSome(description)(_.description(_))
        .ifSome(dnsIpAddrs)(_.dnsIpAddrs(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(shareStatus)(_.shareStatus(_))
        .ifSome(shareMethod)(_.shareMethod(_))
        .ifSome(shareNotes)(_.shareNotes(_))
        .ifSome(launchTime)(_.launchTime(_))
        .ifSome(stageLastUpdatedDateTime)(_.stageLastUpdatedDateTime(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vpcSettings)(_.vpcSettings(_))
        .ifSome(connectSettings)(_.connectSettings(_))
        .ifSome(radiusSettings)(_.radiusSettings(_))
        .ifSome(radiusStatus)(_.radiusStatus(_))
        .ifSome(stageReason)(_.stageReason(_))
        .ifSome(ssoEnabled)(_.ssoEnabled(_))
        .ifSome(desiredNumberOfDomainControllers)(_.desiredNumberOfDomainControllers(_))
        .ifSome(ownerDirectoryDescription)(_.ownerDirectoryDescription(_))
        .ifSome(regionsInfo)(_.regionsInfo(_))
        .build

    def directoryDoesNotExistException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DirectoryDoesNotExistException =
      DirectoryDoesNotExistException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def directoryLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DirectoryLimitExceededException =
      DirectoryLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def directoryLimits(
      cloudOnlyDirectoriesLimit: Option[Int] = None,
      cloudOnlyDirectoriesCurrentCount: Option[Int] = None,
      cloudOnlyDirectoriesLimitReached: Option[Boolean] = None,
      cloudOnlyMicrosoftADLimit: Option[Int] = None,
      cloudOnlyMicrosoftADCurrentCount: Option[Int] = None,
      cloudOnlyMicrosoftADLimitReached: Option[Boolean] = None,
      connectedDirectoriesLimit: Option[Int] = None,
      connectedDirectoriesCurrentCount: Option[Int] = None,
      connectedDirectoriesLimitReached: Option[Boolean] = None
    ): DirectoryLimits =
      DirectoryLimits
        .builder
        .ifSome(cloudOnlyDirectoriesLimit)(_.cloudOnlyDirectoriesLimit(_))
        .ifSome(cloudOnlyDirectoriesCurrentCount)(_.cloudOnlyDirectoriesCurrentCount(_))
        .ifSome(cloudOnlyDirectoriesLimitReached)(_.cloudOnlyDirectoriesLimitReached(_))
        .ifSome(cloudOnlyMicrosoftADLimit)(_.cloudOnlyMicrosoftADLimit(_))
        .ifSome(cloudOnlyMicrosoftADCurrentCount)(_.cloudOnlyMicrosoftADCurrentCount(_))
        .ifSome(cloudOnlyMicrosoftADLimitReached)(_.cloudOnlyMicrosoftADLimitReached(_))
        .ifSome(connectedDirectoriesLimit)(_.connectedDirectoriesLimit(_))
        .ifSome(connectedDirectoriesCurrentCount)(_.connectedDirectoriesCurrentCount(_))
        .ifSome(connectedDirectoriesLimitReached)(_.connectedDirectoriesLimitReached(_))
        .build

    def directoryNotSharedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DirectoryNotSharedException =
      DirectoryNotSharedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def directoryUnavailableException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DirectoryUnavailableException =
      DirectoryUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def directoryVpcSettings(
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None
    ): DirectoryVpcSettings =
      DirectoryVpcSettings
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def directoryVpcSettingsDescription(
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupId: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None
    ): DirectoryVpcSettingsDescription =
      DirectoryVpcSettingsDescription
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupId)(_.securityGroupId(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def disableClientAuthenticationRequest(
      directoryId: Option[String] = None,
      `type`: Option[String] = None
    ): DisableClientAuthenticationRequest =
      DisableClientAuthenticationRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def disableLDAPSRequest(
      directoryId: Option[String] = None,
      `type`: Option[String] = None
    ): DisableLDAPSRequest =
      DisableLDAPSRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def disableRadiusRequest(
      directoryId: Option[String] = None
    ): DisableRadiusRequest =
      DisableRadiusRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def disableSsoRequest(
      directoryId: Option[String] = None,
      userName: Option[String] = None,
      password: Option[String] = None
    ): DisableSsoRequest =
      DisableSsoRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .build

    def domainController(
      directoryId: Option[String] = None,
      domainControllerId: Option[String] = None,
      dnsIpAddr: Option[String] = None,
      vpcId: Option[String] = None,
      subnetId: Option[String] = None,
      availabilityZone: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      launchTime: Option[LaunchTime] = None,
      statusLastUpdatedDateTime: Option[LastUpdatedDateTime] = None
    ): DomainController =
      DomainController
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(domainControllerId)(_.domainControllerId(_))
        .ifSome(dnsIpAddr)(_.dnsIpAddr(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(launchTime)(_.launchTime(_))
        .ifSome(statusLastUpdatedDateTime)(_.statusLastUpdatedDateTime(_))
        .build

    def domainControllerLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DomainControllerLimitExceededException =
      DomainControllerLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def enableClientAuthenticationRequest(
      directoryId: Option[String] = None,
      `type`: Option[String] = None
    ): EnableClientAuthenticationRequest =
      EnableClientAuthenticationRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def enableLDAPSRequest(
      directoryId: Option[String] = None,
      `type`: Option[String] = None
    ): EnableLDAPSRequest =
      EnableLDAPSRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def enableRadiusRequest(
      directoryId: Option[String] = None,
      radiusSettings: Option[RadiusSettings] = None
    ): EnableRadiusRequest =
      EnableRadiusRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(radiusSettings)(_.radiusSettings(_))
        .build

    def enableSsoRequest(
      directoryId: Option[String] = None,
      userName: Option[String] = None,
      password: Option[String] = None
    ): EnableSsoRequest =
      EnableSsoRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .build

    def entityAlreadyExistsException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): EntityAlreadyExistsException =
      EntityAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def entityDoesNotExistException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): EntityDoesNotExistException =
      EntityDoesNotExistException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def eventTopic(
      directoryId: Option[String] = None,
      topicName: Option[String] = None,
      topicArn: Option[String] = None,
      createdDateTime: Option[CreatedDateTime] = None,
      status: Option[String] = None
    ): EventTopic =
      EventTopic
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(topicName)(_.topicName(_))
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(createdDateTime)(_.createdDateTime(_))
        .ifSome(status)(_.status(_))
        .build

    def getDirectoryLimitsRequest(

    ): GetDirectoryLimitsRequest =
      GetDirectoryLimitsRequest
        .builder

        .build

    def getSnapshotLimitsRequest(
      directoryId: Option[String] = None
    ): GetSnapshotLimitsRequest =
      GetSnapshotLimitsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def insufficientPermissionsException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InsufficientPermissionsException =
      InsufficientPermissionsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidCertificateException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidCertificateException =
      InvalidCertificateException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidClientAuthStatusException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidClientAuthStatusException =
      InvalidClientAuthStatusException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidLDAPSStatusException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidLDAPSStatusException =
      InvalidLDAPSStatusException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidParameterException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidPasswordException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidPasswordException =
      InvalidPasswordException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidTargetException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidTargetException =
      InvalidTargetException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def ipRoute(
      cidrIp: Option[String] = None,
      description: Option[String] = None
    ): IpRoute =
      IpRoute
        .builder
        .ifSome(cidrIp)(_.cidrIp(_))
        .ifSome(description)(_.description(_))
        .build

    def ipRouteInfo(
      directoryId: Option[String] = None,
      cidrIp: Option[String] = None,
      ipRouteStatusMsg: Option[String] = None,
      addedDateTime: Option[AddedDateTime] = None,
      ipRouteStatusReason: Option[String] = None,
      description: Option[String] = None
    ): IpRouteInfo =
      IpRouteInfo
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(cidrIp)(_.cidrIp(_))
        .ifSome(ipRouteStatusMsg)(_.ipRouteStatusMsg(_))
        .ifSome(addedDateTime)(_.addedDateTime(_))
        .ifSome(ipRouteStatusReason)(_.ipRouteStatusReason(_))
        .ifSome(description)(_.description(_))
        .build

    def ipRouteLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): IpRouteLimitExceededException =
      IpRouteLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def lDAPSSettingInfo(
      lDAPSStatus: Option[String] = None,
      lDAPSStatusReason: Option[String] = None,
      lastUpdatedDateTime: Option[LastUpdatedDateTime] = None
    ): LDAPSSettingInfo =
      LDAPSSettingInfo
        .builder
        .ifSome(lDAPSStatus)(_.lDAPSStatus(_))
        .ifSome(lDAPSStatusReason)(_.lDAPSStatusReason(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def listCertificatesRequest(
      directoryId: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListCertificatesRequest =
      ListCertificatesRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listIpRoutesRequest(
      directoryId: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListIpRoutesRequest =
      ListIpRoutesRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listLogSubscriptionsRequest(
      directoryId: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListLogSubscriptionsRequest =
      ListLogSubscriptionsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listSchemaExtensionsRequest(
      directoryId: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListSchemaExtensionsRequest =
      ListSchemaExtensionsRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTagsForResourceRequest(
      resourceId: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def logSubscription(
      directoryId: Option[String] = None,
      logGroupName: Option[String] = None,
      subscriptionCreatedDateTime: Option[SubscriptionCreatedDateTime] = None
    ): LogSubscription =
      LogSubscription
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(subscriptionCreatedDateTime)(_.subscriptionCreatedDateTime(_))
        .build

    def noAvailableCertificateException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): NoAvailableCertificateException =
      NoAvailableCertificateException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def organizationsException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): OrganizationsException =
      OrganizationsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def ownerDirectoryDescription(
      directoryId: Option[String] = None,
      accountId: Option[String] = None,
      dnsIpAddrs: Option[List[IpAddr]] = None,
      vpcSettings: Option[DirectoryVpcSettingsDescription] = None,
      radiusSettings: Option[RadiusSettings] = None,
      radiusStatus: Option[String] = None
    ): OwnerDirectoryDescription =
      OwnerDirectoryDescription
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(dnsIpAddrs)(_.dnsIpAddrs(_))
        .ifSome(vpcSettings)(_.vpcSettings(_))
        .ifSome(radiusSettings)(_.radiusSettings(_))
        .ifSome(radiusStatus)(_.radiusStatus(_))
        .build

    def radiusSettings(
      radiusServers: Option[List[Server]] = None,
      radiusPort: Option[Int] = None,
      radiusTimeout: Option[Int] = None,
      radiusRetries: Option[Int] = None,
      sharedSecret: Option[String] = None,
      authenticationProtocol: Option[String] = None,
      displayLabel: Option[String] = None,
      useSameUsername: Option[Boolean] = None
    ): RadiusSettings =
      RadiusSettings
        .builder
        .ifSome(radiusServers)(_.radiusServers(_))
        .ifSome(radiusPort)(_.radiusPort(_))
        .ifSome(radiusTimeout)(_.radiusTimeout(_))
        .ifSome(radiusRetries)(_.radiusRetries(_))
        .ifSome(sharedSecret)(_.sharedSecret(_))
        .ifSome(authenticationProtocol)(_.authenticationProtocol(_))
        .ifSome(displayLabel)(_.displayLabel(_))
        .ifSome(useSameUsername)(_.useSameUsername(_))
        .build

    def regionDescription(
      directoryId: Option[String] = None,
      regionName: Option[String] = None,
      regionType: Option[String] = None,
      status: Option[String] = None,
      vpcSettings: Option[DirectoryVpcSettings] = None,
      desiredNumberOfDomainControllers: Option[Int] = None,
      launchTime: Option[LaunchTime] = None,
      statusLastUpdatedDateTime: Option[StateLastUpdatedDateTime] = None,
      lastUpdatedDateTime: Option[LastUpdatedDateTime] = None
    ): RegionDescription =
      RegionDescription
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(regionType)(_.regionType(_))
        .ifSome(status)(_.status(_))
        .ifSome(vpcSettings)(_.vpcSettings(_))
        .ifSome(desiredNumberOfDomainControllers)(_.desiredNumberOfDomainControllers(_))
        .ifSome(launchTime)(_.launchTime(_))
        .ifSome(statusLastUpdatedDateTime)(_.statusLastUpdatedDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def regionLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): RegionLimitExceededException =
      RegionLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def regionsInfo(
      primaryRegion: Option[String] = None,
      additionalRegions: Option[List[RegionName]] = None
    ): RegionsInfo =
      RegionsInfo
        .builder
        .ifSome(primaryRegion)(_.primaryRegion(_))
        .ifSome(additionalRegions)(_.additionalRegions(_))
        .build

    def registerCertificateRequest(
      directoryId: Option[String] = None,
      certificateData: Option[String] = None,
      `type`: Option[String] = None,
      clientCertAuthSettings: Option[ClientCertAuthSettings] = None
    ): RegisterCertificateRequest =
      RegisterCertificateRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(certificateData)(_.certificateData(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(clientCertAuthSettings)(_.clientCertAuthSettings(_))
        .build

    def registerEventTopicRequest(
      directoryId: Option[String] = None,
      topicName: Option[String] = None
    ): RegisterEventTopicRequest =
      RegisterEventTopicRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(topicName)(_.topicName(_))
        .build

    def rejectSharedDirectoryRequest(
      sharedDirectoryId: Option[String] = None
    ): RejectSharedDirectoryRequest =
      RejectSharedDirectoryRequest
        .builder
        .ifSome(sharedDirectoryId)(_.sharedDirectoryId(_))
        .build

    def removeIpRoutesRequest(
      directoryId: Option[String] = None,
      cidrIps: Option[List[CidrIp]] = None
    ): RemoveIpRoutesRequest =
      RemoveIpRoutesRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(cidrIps)(_.cidrIps(_))
        .build

    def removeRegionRequest(
      directoryId: Option[String] = None
    ): RemoveRegionRequest =
      RemoveRegionRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def removeTagsFromResourceRequest(
      resourceId: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): RemoveTagsFromResourceRequest =
      RemoveTagsFromResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def resetUserPasswordRequest(
      directoryId: Option[String] = None,
      userName: Option[String] = None,
      newPassword: Option[String] = None
    ): ResetUserPasswordRequest =
      ResetUserPasswordRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(newPassword)(_.newPassword(_))
        .build

    def restoreFromSnapshotRequest(
      snapshotId: Option[String] = None
    ): RestoreFromSnapshotRequest =
      RestoreFromSnapshotRequest
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .build

    def schemaExtensionInfo(
      directoryId: Option[String] = None,
      schemaExtensionId: Option[String] = None,
      description: Option[String] = None,
      schemaExtensionStatus: Option[String] = None,
      schemaExtensionStatusReason: Option[String] = None,
      startDateTime: Option[StartDateTime] = None,
      endDateTime: Option[EndDateTime] = None
    ): SchemaExtensionInfo =
      SchemaExtensionInfo
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(schemaExtensionId)(_.schemaExtensionId(_))
        .ifSome(description)(_.description(_))
        .ifSome(schemaExtensionStatus)(_.schemaExtensionStatus(_))
        .ifSome(schemaExtensionStatusReason)(_.schemaExtensionStatusReason(_))
        .ifSome(startDateTime)(_.startDateTime(_))
        .ifSome(endDateTime)(_.endDateTime(_))
        .build

    def serviceException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ServiceException =
      ServiceException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def shareDirectoryRequest(
      directoryId: Option[String] = None,
      shareNotes: Option[String] = None,
      shareTarget: Option[ShareTarget] = None,
      shareMethod: Option[String] = None
    ): ShareDirectoryRequest =
      ShareDirectoryRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(shareNotes)(_.shareNotes(_))
        .ifSome(shareTarget)(_.shareTarget(_))
        .ifSome(shareMethod)(_.shareMethod(_))
        .build

    def shareLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ShareLimitExceededException =
      ShareLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def shareTarget(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): ShareTarget =
      ShareTarget
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def sharedDirectory(
      ownerAccountId: Option[String] = None,
      ownerDirectoryId: Option[String] = None,
      shareMethod: Option[String] = None,
      sharedAccountId: Option[String] = None,
      sharedDirectoryId: Option[String] = None,
      shareStatus: Option[String] = None,
      shareNotes: Option[String] = None,
      createdDateTime: Option[CreatedDateTime] = None,
      lastUpdatedDateTime: Option[LastUpdatedDateTime] = None
    ): SharedDirectory =
      SharedDirectory
        .builder
        .ifSome(ownerAccountId)(_.ownerAccountId(_))
        .ifSome(ownerDirectoryId)(_.ownerDirectoryId(_))
        .ifSome(shareMethod)(_.shareMethod(_))
        .ifSome(sharedAccountId)(_.sharedAccountId(_))
        .ifSome(sharedDirectoryId)(_.sharedDirectoryId(_))
        .ifSome(shareStatus)(_.shareStatus(_))
        .ifSome(shareNotes)(_.shareNotes(_))
        .ifSome(createdDateTime)(_.createdDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def snapshot(
      directoryId: Option[String] = None,
      snapshotId: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[StartTime] = None
    ): Snapshot =
      Snapshot
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def snapshotLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): SnapshotLimitExceededException =
      SnapshotLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def snapshotLimits(
      manualSnapshotsLimit: Option[Int] = None,
      manualSnapshotsCurrentCount: Option[Int] = None,
      manualSnapshotsLimitReached: Option[Boolean] = None
    ): SnapshotLimits =
      SnapshotLimits
        .builder
        .ifSome(manualSnapshotsLimit)(_.manualSnapshotsLimit(_))
        .ifSome(manualSnapshotsCurrentCount)(_.manualSnapshotsCurrentCount(_))
        .ifSome(manualSnapshotsLimitReached)(_.manualSnapshotsLimitReached(_))
        .build

    def startSchemaExtensionRequest(
      directoryId: Option[String] = None,
      createSnapshotBeforeSchemaExtension: Option[Boolean] = None,
      ldifContent: Option[String] = None,
      description: Option[String] = None
    ): StartSchemaExtensionRequest =
      StartSchemaExtensionRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(createSnapshotBeforeSchemaExtension)(_.createSnapshotBeforeSchemaExtension(_))
        .ifSome(ldifContent)(_.ldifContent(_))
        .ifSome(description)(_.description(_))
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

    def tagLimitExceededException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): TagLimitExceededException =
      TagLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def trust(
      directoryId: Option[String] = None,
      trustId: Option[String] = None,
      remoteDomainName: Option[String] = None,
      trustType: Option[String] = None,
      trustDirection: Option[String] = None,
      trustState: Option[String] = None,
      createdDateTime: Option[CreatedDateTime] = None,
      lastUpdatedDateTime: Option[LastUpdatedDateTime] = None,
      stateLastUpdatedDateTime: Option[StateLastUpdatedDateTime] = None,
      trustStateReason: Option[String] = None,
      selectiveAuth: Option[String] = None
    ): Trust =
      Trust
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(trustId)(_.trustId(_))
        .ifSome(remoteDomainName)(_.remoteDomainName(_))
        .ifSome(trustType)(_.trustType(_))
        .ifSome(trustDirection)(_.trustDirection(_))
        .ifSome(trustState)(_.trustState(_))
        .ifSome(createdDateTime)(_.createdDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(stateLastUpdatedDateTime)(_.stateLastUpdatedDateTime(_))
        .ifSome(trustStateReason)(_.trustStateReason(_))
        .ifSome(selectiveAuth)(_.selectiveAuth(_))
        .build

    def unshareDirectoryRequest(
      directoryId: Option[String] = None,
      unshareTarget: Option[UnshareTarget] = None
    ): UnshareDirectoryRequest =
      UnshareDirectoryRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(unshareTarget)(_.unshareTarget(_))
        .build

    def unshareTarget(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): UnshareTarget =
      UnshareTarget
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateConditionalForwarderRequest(
      directoryId: Option[String] = None,
      remoteDomainName: Option[String] = None,
      dnsIpAddrs: Option[List[IpAddr]] = None
    ): UpdateConditionalForwarderRequest =
      UpdateConditionalForwarderRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(remoteDomainName)(_.remoteDomainName(_))
        .ifSome(dnsIpAddrs)(_.dnsIpAddrs(_))
        .build

    def updateNumberOfDomainControllersRequest(
      directoryId: Option[String] = None,
      desiredNumber: Option[Int] = None
    ): UpdateNumberOfDomainControllersRequest =
      UpdateNumberOfDomainControllersRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(desiredNumber)(_.desiredNumber(_))
        .build

    def updateRadiusRequest(
      directoryId: Option[String] = None,
      radiusSettings: Option[RadiusSettings] = None
    ): UpdateRadiusRequest =
      UpdateRadiusRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(radiusSettings)(_.radiusSettings(_))
        .build

    def updateTrustRequest(
      trustId: Option[String] = None,
      selectiveAuth: Option[String] = None
    ): UpdateTrustRequest =
      UpdateTrustRequest
        .builder
        .ifSome(trustId)(_.trustId(_))
        .ifSome(selectiveAuth)(_.selectiveAuth(_))
        .build

    def userDoesNotExistException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): UserDoesNotExistException =
      UserDoesNotExistException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def verifyTrustRequest(
      trustId: Option[String] = None
    ): VerifyTrustRequest =
      VerifyTrustRequest
        .builder
        .ifSome(trustId)(_.trustId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
