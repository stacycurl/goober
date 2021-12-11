package goober.hi

import goober.free.elasticsearch.ElasticsearchIO
import software.amazon.awssdk.services.elasticsearch.model._


object elasticsearch {
  import goober.free.{elasticsearch ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptInboundCrossClusterSearchConnectionRequest(
      crossClusterSearchConnectionId: Option[String] = None
    ): AcceptInboundCrossClusterSearchConnectionRequest =
      AcceptInboundCrossClusterSearchConnectionRequest
        .builder
        .ifSome(crossClusterSearchConnectionId)(_.crossClusterSearchConnectionId(_))
        .build

    def acceptInboundCrossClusterSearchConnectionResponse(
      crossClusterSearchConnection: Option[InboundCrossClusterSearchConnection] = None
    ): AcceptInboundCrossClusterSearchConnectionResponse =
      AcceptInboundCrossClusterSearchConnectionResponse
        .builder
        .ifSome(crossClusterSearchConnection)(_.crossClusterSearchConnection(_))
        .build

    def accessDeniedException(

    ): AccessDeniedException =
      AccessDeniedException
        .builder

        .build

    def accessPoliciesStatus(
      options: Option[String] = None,
      status: Option[OptionStatus] = None
    ): AccessPoliciesStatus =
      AccessPoliciesStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def addTagsRequest(
      aRN: Option[String] = None,
      tagList: Option[List[Tag]] = None
    ): AddTagsRequest =
      AddTagsRequest
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def additionalLimit(
      limitName: Option[String] = None,
      limitValues: Option[List[LimitValue]] = None
    ): AdditionalLimit =
      AdditionalLimit
        .builder
        .ifSome(limitName)(_.limitName(_))
        .ifSome(limitValues)(_.limitValues(_))
        .build

    def advancedOptionsStatus(
      options: Option[AdvancedOptions] = None,
      status: Option[OptionStatus] = None
    ): AdvancedOptionsStatus =
      AdvancedOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def advancedSecurityOptions(
      enabled: Option[Boolean] = None,
      internalUserDatabaseEnabled: Option[Boolean] = None,
      sAMLOptions: Option[SAMLOptionsOutput] = None
    ): AdvancedSecurityOptions =
      AdvancedSecurityOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(internalUserDatabaseEnabled)(_.internalUserDatabaseEnabled(_))
        .ifSome(sAMLOptions)(_.sAMLOptions(_))
        .build

    def advancedSecurityOptionsInput(
      enabled: Option[Boolean] = None,
      internalUserDatabaseEnabled: Option[Boolean] = None,
      masterUserOptions: Option[MasterUserOptions] = None,
      sAMLOptions: Option[SAMLOptionsInput] = None
    ): AdvancedSecurityOptionsInput =
      AdvancedSecurityOptionsInput
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(internalUserDatabaseEnabled)(_.internalUserDatabaseEnabled(_))
        .ifSome(masterUserOptions)(_.masterUserOptions(_))
        .ifSome(sAMLOptions)(_.sAMLOptions(_))
        .build

    def advancedSecurityOptionsStatus(
      options: Option[AdvancedSecurityOptions] = None,
      status: Option[OptionStatus] = None
    ): AdvancedSecurityOptionsStatus =
      AdvancedSecurityOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def associatePackageRequest(
      packageID: Option[String] = None,
      domainName: Option[String] = None
    ): AssociatePackageRequest =
      AssociatePackageRequest
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def associatePackageResponse(
      domainPackageDetails: Option[DomainPackageDetails] = None
    ): AssociatePackageResponse =
      AssociatePackageResponse
        .builder
        .ifSome(domainPackageDetails)(_.domainPackageDetails(_))
        .build

    def autoTune(
      autoTuneType: Option[String] = None,
      autoTuneDetails: Option[AutoTuneDetails] = None
    ): AutoTune =
      AutoTune
        .builder
        .ifSome(autoTuneType)(_.autoTuneType(_))
        .ifSome(autoTuneDetails)(_.autoTuneDetails(_))
        .build

    def autoTuneDetails(
      scheduledAutoTuneDetails: Option[ScheduledAutoTuneDetails] = None
    ): AutoTuneDetails =
      AutoTuneDetails
        .builder
        .ifSome(scheduledAutoTuneDetails)(_.scheduledAutoTuneDetails(_))
        .build

    def autoTuneMaintenanceSchedule(
      startAt: Option[StartAt] = None,
      duration: Option[Duration] = None,
      cronExpressionForRecurrence: Option[String] = None
    ): AutoTuneMaintenanceSchedule =
      AutoTuneMaintenanceSchedule
        .builder
        .ifSome(startAt)(_.startAt(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(cronExpressionForRecurrence)(_.cronExpressionForRecurrence(_))
        .build

    def autoTuneOptions(
      desiredState: Option[String] = None,
      rollbackOnDisable: Option[String] = None,
      maintenanceSchedules: Option[List[AutoTuneMaintenanceSchedule]] = None
    ): AutoTuneOptions =
      AutoTuneOptions
        .builder
        .ifSome(desiredState)(_.desiredState(_))
        .ifSome(rollbackOnDisable)(_.rollbackOnDisable(_))
        .ifSome(maintenanceSchedules)(_.maintenanceSchedules(_))
        .build

    def autoTuneOptionsInput(
      desiredState: Option[String] = None,
      maintenanceSchedules: Option[List[AutoTuneMaintenanceSchedule]] = None
    ): AutoTuneOptionsInput =
      AutoTuneOptionsInput
        .builder
        .ifSome(desiredState)(_.desiredState(_))
        .ifSome(maintenanceSchedules)(_.maintenanceSchedules(_))
        .build

    def autoTuneOptionsOutput(
      state: Option[String] = None,
      errorMessage: Option[String] = None
    ): AutoTuneOptionsOutput =
      AutoTuneOptionsOutput
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def autoTuneOptionsStatus(
      options: Option[AutoTuneOptions] = None,
      status: Option[AutoTuneStatus] = None
    ): AutoTuneOptionsStatus =
      AutoTuneOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def autoTuneStatus(
      creationDate: Option[UpdateTimestamp] = None,
      updateDate: Option[UpdateTimestamp] = None,
      updateVersion: Option[Int] = None,
      state: Option[String] = None,
      errorMessage: Option[String] = None,
      pendingDeletion: Option[Boolean] = None
    ): AutoTuneStatus =
      AutoTuneStatus
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(updateDate)(_.updateDate(_))
        .ifSome(updateVersion)(_.updateVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(pendingDeletion)(_.pendingDeletion(_))
        .build

    def baseException(
      message: Option[String] = None
    ): BaseException =
      BaseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cancelElasticsearchServiceSoftwareUpdateRequest(
      domainName: Option[String] = None
    ): CancelElasticsearchServiceSoftwareUpdateRequest =
      CancelElasticsearchServiceSoftwareUpdateRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def cancelElasticsearchServiceSoftwareUpdateResponse(
      serviceSoftwareOptions: Option[ServiceSoftwareOptions] = None
    ): CancelElasticsearchServiceSoftwareUpdateResponse =
      CancelElasticsearchServiceSoftwareUpdateResponse
        .builder
        .ifSome(serviceSoftwareOptions)(_.serviceSoftwareOptions(_))
        .build

    def cognitoOptions(
      enabled: Option[Boolean] = None,
      userPoolId: Option[String] = None,
      identityPoolId: Option[String] = None,
      roleArn: Option[String] = None
    ): CognitoOptions =
      CognitoOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def cognitoOptionsStatus(
      options: Option[CognitoOptions] = None,
      status: Option[OptionStatus] = None
    ): CognitoOptionsStatus =
      CognitoOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def coldStorageOptions(
      enabled: Option[Boolean] = None
    ): ColdStorageOptions =
      ColdStorageOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def compatibleVersionsMap(
      sourceVersion: Option[String] = None,
      targetVersions: Option[List[ElasticsearchVersionString]] = None
    ): CompatibleVersionsMap =
      CompatibleVersionsMap
        .builder
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(targetVersions)(_.targetVersions(_))
        .build

    def conflictException(

    ): ConflictException =
      ConflictException
        .builder

        .build

    def createElasticsearchDomainRequest(
      domainName: Option[String] = None,
      elasticsearchVersion: Option[String] = None,
      elasticsearchClusterConfig: Option[ElasticsearchClusterConfig] = None,
      eBSOptions: Option[EBSOptions] = None,
      accessPolicies: Option[String] = None,
      snapshotOptions: Option[SnapshotOptions] = None,
      vPCOptions: Option[VPCOptions] = None,
      cognitoOptions: Option[CognitoOptions] = None,
      encryptionAtRestOptions: Option[EncryptionAtRestOptions] = None,
      nodeToNodeEncryptionOptions: Option[NodeToNodeEncryptionOptions] = None,
      advancedOptions: Option[AdvancedOptions] = None,
      logPublishingOptions: Option[LogPublishingOptions] = None,
      domainEndpointOptions: Option[DomainEndpointOptions] = None,
      advancedSecurityOptions: Option[AdvancedSecurityOptionsInput] = None,
      autoTuneOptions: Option[AutoTuneOptionsInput] = None,
      tagList: Option[List[Tag]] = None
    ): CreateElasticsearchDomainRequest =
      CreateElasticsearchDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(elasticsearchVersion)(_.elasticsearchVersion(_))
        .ifSome(elasticsearchClusterConfig)(_.elasticsearchClusterConfig(_))
        .ifSome(eBSOptions)(_.eBSOptions(_))
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .ifSome(snapshotOptions)(_.snapshotOptions(_))
        .ifSome(vPCOptions)(_.vPCOptions(_))
        .ifSome(cognitoOptions)(_.cognitoOptions(_))
        .ifSome(encryptionAtRestOptions)(_.encryptionAtRestOptions(_))
        .ifSome(nodeToNodeEncryptionOptions)(_.nodeToNodeEncryptionOptions(_))
        .ifSome(advancedOptions)(_.advancedOptions(_))
        .ifSome(logPublishingOptions)(_.logPublishingOptions(_))
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .ifSome(advancedSecurityOptions)(_.advancedSecurityOptions(_))
        .ifSome(autoTuneOptions)(_.autoTuneOptions(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def createElasticsearchDomainResponse(
      domainStatus: Option[ElasticsearchDomainStatus] = None
    ): CreateElasticsearchDomainResponse =
      CreateElasticsearchDomainResponse
        .builder
        .ifSome(domainStatus)(_.domainStatus(_))
        .build

    def createOutboundCrossClusterSearchConnectionRequest(
      sourceDomainInfo: Option[DomainInformation] = None,
      destinationDomainInfo: Option[DomainInformation] = None,
      connectionAlias: Option[String] = None
    ): CreateOutboundCrossClusterSearchConnectionRequest =
      CreateOutboundCrossClusterSearchConnectionRequest
        .builder
        .ifSome(sourceDomainInfo)(_.sourceDomainInfo(_))
        .ifSome(destinationDomainInfo)(_.destinationDomainInfo(_))
        .ifSome(connectionAlias)(_.connectionAlias(_))
        .build

    def createOutboundCrossClusterSearchConnectionResponse(
      sourceDomainInfo: Option[DomainInformation] = None,
      destinationDomainInfo: Option[DomainInformation] = None,
      connectionAlias: Option[String] = None,
      connectionStatus: Option[OutboundCrossClusterSearchConnectionStatus] = None,
      crossClusterSearchConnectionId: Option[String] = None
    ): CreateOutboundCrossClusterSearchConnectionResponse =
      CreateOutboundCrossClusterSearchConnectionResponse
        .builder
        .ifSome(sourceDomainInfo)(_.sourceDomainInfo(_))
        .ifSome(destinationDomainInfo)(_.destinationDomainInfo(_))
        .ifSome(connectionAlias)(_.connectionAlias(_))
        .ifSome(connectionStatus)(_.connectionStatus(_))
        .ifSome(crossClusterSearchConnectionId)(_.crossClusterSearchConnectionId(_))
        .build

    def createPackageRequest(
      packageName: Option[String] = None,
      packageType: Option[String] = None,
      packageDescription: Option[String] = None,
      packageSource: Option[PackageSource] = None
    ): CreatePackageRequest =
      CreatePackageRequest
        .builder
        .ifSome(packageName)(_.packageName(_))
        .ifSome(packageType)(_.packageType(_))
        .ifSome(packageDescription)(_.packageDescription(_))
        .ifSome(packageSource)(_.packageSource(_))
        .build

    def createPackageResponse(
      packageDetails: Option[PackageDetails] = None
    ): CreatePackageResponse =
      CreatePackageResponse
        .builder
        .ifSome(packageDetails)(_.packageDetails(_))
        .build

    def deleteElasticsearchDomainRequest(
      domainName: Option[String] = None
    ): DeleteElasticsearchDomainRequest =
      DeleteElasticsearchDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteElasticsearchDomainResponse(
      domainStatus: Option[ElasticsearchDomainStatus] = None
    ): DeleteElasticsearchDomainResponse =
      DeleteElasticsearchDomainResponse
        .builder
        .ifSome(domainStatus)(_.domainStatus(_))
        .build

    def deleteInboundCrossClusterSearchConnectionRequest(
      crossClusterSearchConnectionId: Option[String] = None
    ): DeleteInboundCrossClusterSearchConnectionRequest =
      DeleteInboundCrossClusterSearchConnectionRequest
        .builder
        .ifSome(crossClusterSearchConnectionId)(_.crossClusterSearchConnectionId(_))
        .build

    def deleteInboundCrossClusterSearchConnectionResponse(
      crossClusterSearchConnection: Option[InboundCrossClusterSearchConnection] = None
    ): DeleteInboundCrossClusterSearchConnectionResponse =
      DeleteInboundCrossClusterSearchConnectionResponse
        .builder
        .ifSome(crossClusterSearchConnection)(_.crossClusterSearchConnection(_))
        .build

    def deleteOutboundCrossClusterSearchConnectionRequest(
      crossClusterSearchConnectionId: Option[String] = None
    ): DeleteOutboundCrossClusterSearchConnectionRequest =
      DeleteOutboundCrossClusterSearchConnectionRequest
        .builder
        .ifSome(crossClusterSearchConnectionId)(_.crossClusterSearchConnectionId(_))
        .build

    def deleteOutboundCrossClusterSearchConnectionResponse(
      crossClusterSearchConnection: Option[OutboundCrossClusterSearchConnection] = None
    ): DeleteOutboundCrossClusterSearchConnectionResponse =
      DeleteOutboundCrossClusterSearchConnectionResponse
        .builder
        .ifSome(crossClusterSearchConnection)(_.crossClusterSearchConnection(_))
        .build

    def deletePackageRequest(
      packageID: Option[String] = None
    ): DeletePackageRequest =
      DeletePackageRequest
        .builder
        .ifSome(packageID)(_.packageID(_))
        .build

    def deletePackageResponse(
      packageDetails: Option[PackageDetails] = None
    ): DeletePackageResponse =
      DeletePackageResponse
        .builder
        .ifSome(packageDetails)(_.packageDetails(_))
        .build

    def describeDomainAutoTunesRequest(
      domainName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDomainAutoTunesRequest =
      DescribeDomainAutoTunesRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDomainAutoTunesResponse(
      autoTunes: Option[List[AutoTune]] = None,
      nextToken: Option[String] = None
    ): DescribeDomainAutoTunesResponse =
      DescribeDomainAutoTunesResponse
        .builder
        .ifSome(autoTunes)(_.autoTunes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeElasticsearchDomainConfigRequest(
      domainName: Option[String] = None
    ): DescribeElasticsearchDomainConfigRequest =
      DescribeElasticsearchDomainConfigRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def describeElasticsearchDomainConfigResponse(
      domainConfig: Option[ElasticsearchDomainConfig] = None
    ): DescribeElasticsearchDomainConfigResponse =
      DescribeElasticsearchDomainConfigResponse
        .builder
        .ifSome(domainConfig)(_.domainConfig(_))
        .build

    def describeElasticsearchDomainRequest(
      domainName: Option[String] = None
    ): DescribeElasticsearchDomainRequest =
      DescribeElasticsearchDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def describeElasticsearchDomainResponse(
      domainStatus: Option[ElasticsearchDomainStatus] = None
    ): DescribeElasticsearchDomainResponse =
      DescribeElasticsearchDomainResponse
        .builder
        .ifSome(domainStatus)(_.domainStatus(_))
        .build

    def describeElasticsearchDomainsRequest(
      domainNames: Option[List[DomainName]] = None
    ): DescribeElasticsearchDomainsRequest =
      DescribeElasticsearchDomainsRequest
        .builder
        .ifSome(domainNames)(_.domainNames(_))
        .build

    def describeElasticsearchDomainsResponse(
      domainStatusList: Option[List[ElasticsearchDomainStatus]] = None
    ): DescribeElasticsearchDomainsResponse =
      DescribeElasticsearchDomainsResponse
        .builder
        .ifSome(domainStatusList)(_.domainStatusList(_))
        .build

    def describeElasticsearchInstanceTypeLimitsRequest(
      domainName: Option[String] = None,
      instanceType: Option[String] = None,
      elasticsearchVersion: Option[String] = None
    ): DescribeElasticsearchInstanceTypeLimitsRequest =
      DescribeElasticsearchInstanceTypeLimitsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(elasticsearchVersion)(_.elasticsearchVersion(_))
        .build

    def describeElasticsearchInstanceTypeLimitsResponse(
      limitsByRole: Option[LimitsByRole] = None
    ): DescribeElasticsearchInstanceTypeLimitsResponse =
      DescribeElasticsearchInstanceTypeLimitsResponse
        .builder
        .ifSome(limitsByRole)(_.limitsByRole(_))
        .build

    def describeInboundCrossClusterSearchConnectionsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeInboundCrossClusterSearchConnectionsRequest =
      DescribeInboundCrossClusterSearchConnectionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInboundCrossClusterSearchConnectionsResponse(
      crossClusterSearchConnections: Option[List[InboundCrossClusterSearchConnection]] = None,
      nextToken: Option[String] = None
    ): DescribeInboundCrossClusterSearchConnectionsResponse =
      DescribeInboundCrossClusterSearchConnectionsResponse
        .builder
        .ifSome(crossClusterSearchConnections)(_.crossClusterSearchConnections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOutboundCrossClusterSearchConnectionsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeOutboundCrossClusterSearchConnectionsRequest =
      DescribeOutboundCrossClusterSearchConnectionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOutboundCrossClusterSearchConnectionsResponse(
      crossClusterSearchConnections: Option[List[OutboundCrossClusterSearchConnection]] = None,
      nextToken: Option[String] = None
    ): DescribeOutboundCrossClusterSearchConnectionsResponse =
      DescribeOutboundCrossClusterSearchConnectionsResponse
        .builder
        .ifSome(crossClusterSearchConnections)(_.crossClusterSearchConnections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePackagesFilter(
      name: Option[String] = None,
      value: Option[List[DescribePackagesFilterValue]] = None
    ): DescribePackagesFilter =
      DescribePackagesFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def describePackagesRequest(
      filters: Option[List[DescribePackagesFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribePackagesRequest =
      DescribePackagesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePackagesResponse(
      packageDetailsList: Option[List[PackageDetails]] = None,
      nextToken: Option[String] = None
    ): DescribePackagesResponse =
      DescribePackagesResponse
        .builder
        .ifSome(packageDetailsList)(_.packageDetailsList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeReservedElasticsearchInstanceOfferingsRequest(
      reservedElasticsearchInstanceOfferingId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeReservedElasticsearchInstanceOfferingsRequest =
      DescribeReservedElasticsearchInstanceOfferingsRequest
        .builder
        .ifSome(reservedElasticsearchInstanceOfferingId)(_.reservedElasticsearchInstanceOfferingId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeReservedElasticsearchInstanceOfferingsResponse(
      nextToken: Option[String] = None,
      reservedElasticsearchInstanceOfferings: Option[List[ReservedElasticsearchInstanceOffering]] = None
    ): DescribeReservedElasticsearchInstanceOfferingsResponse =
      DescribeReservedElasticsearchInstanceOfferingsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reservedElasticsearchInstanceOfferings)(_.reservedElasticsearchInstanceOfferings(_))
        .build

    def describeReservedElasticsearchInstancesRequest(
      reservedElasticsearchInstanceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeReservedElasticsearchInstancesRequest =
      DescribeReservedElasticsearchInstancesRequest
        .builder
        .ifSome(reservedElasticsearchInstanceId)(_.reservedElasticsearchInstanceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeReservedElasticsearchInstancesResponse(
      nextToken: Option[String] = None,
      reservedElasticsearchInstances: Option[List[ReservedElasticsearchInstance]] = None
    ): DescribeReservedElasticsearchInstancesResponse =
      DescribeReservedElasticsearchInstancesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reservedElasticsearchInstances)(_.reservedElasticsearchInstances(_))
        .build

    def disabledOperationException(

    ): DisabledOperationException =
      DisabledOperationException
        .builder

        .build

    def dissociatePackageRequest(
      packageID: Option[String] = None,
      domainName: Option[String] = None
    ): DissociatePackageRequest =
      DissociatePackageRequest
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def dissociatePackageResponse(
      domainPackageDetails: Option[DomainPackageDetails] = None
    ): DissociatePackageResponse =
      DissociatePackageResponse
        .builder
        .ifSome(domainPackageDetails)(_.domainPackageDetails(_))
        .build

    def domainEndpointOptions(
      enforceHTTPS: Option[Boolean] = None,
      tLSSecurityPolicy: Option[String] = None,
      customEndpointEnabled: Option[Boolean] = None,
      customEndpoint: Option[String] = None,
      customEndpointCertificateArn: Option[String] = None
    ): DomainEndpointOptions =
      DomainEndpointOptions
        .builder
        .ifSome(enforceHTTPS)(_.enforceHTTPS(_))
        .ifSome(tLSSecurityPolicy)(_.tLSSecurityPolicy(_))
        .ifSome(customEndpointEnabled)(_.customEndpointEnabled(_))
        .ifSome(customEndpoint)(_.customEndpoint(_))
        .ifSome(customEndpointCertificateArn)(_.customEndpointCertificateArn(_))
        .build

    def domainEndpointOptionsStatus(
      options: Option[DomainEndpointOptions] = None,
      status: Option[OptionStatus] = None
    ): DomainEndpointOptionsStatus =
      DomainEndpointOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def domainInfo(
      domainName: Option[String] = None
    ): DomainInfo =
      DomainInfo
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def domainInformation(
      ownerId: Option[String] = None,
      domainName: Option[String] = None,
      region: Option[String] = None
    ): DomainInformation =
      DomainInformation
        .builder
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(region)(_.region(_))
        .build

    def domainPackageDetails(
      packageID: Option[String] = None,
      packageName: Option[String] = None,
      packageType: Option[String] = None,
      lastUpdated: Option[LastUpdated] = None,
      domainName: Option[String] = None,
      domainPackageStatus: Option[String] = None,
      packageVersion: Option[String] = None,
      referencePath: Option[String] = None,
      errorDetails: Option[ErrorDetails] = None
    ): DomainPackageDetails =
      DomainPackageDetails
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(packageName)(_.packageName(_))
        .ifSome(packageType)(_.packageType(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainPackageStatus)(_.domainPackageStatus(_))
        .ifSome(packageVersion)(_.packageVersion(_))
        .ifSome(referencePath)(_.referencePath(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .build

    def duration(
      value: Option[DurationValue] = None,
      unit: Option[String] = None
    ): Duration =
      Duration
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(unit)(_.unit(_))
        .build

    def eBSOptions(
      eBSEnabled: Option[Boolean] = None,
      volumeType: Option[String] = None,
      volumeSize: Option[Int] = None,
      iops: Option[Int] = None
    ): EBSOptions =
      EBSOptions
        .builder
        .ifSome(eBSEnabled)(_.eBSEnabled(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(iops)(_.iops(_))
        .build

    def eBSOptionsStatus(
      options: Option[EBSOptions] = None,
      status: Option[OptionStatus] = None
    ): EBSOptionsStatus =
      EBSOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def elasticsearchClusterConfig(
      instanceType: Option[String] = None,
      instanceCount: Option[Int] = None,
      dedicatedMasterEnabled: Option[Boolean] = None,
      zoneAwarenessEnabled: Option[Boolean] = None,
      zoneAwarenessConfig: Option[ZoneAwarenessConfig] = None,
      dedicatedMasterType: Option[String] = None,
      dedicatedMasterCount: Option[Int] = None,
      warmEnabled: Option[Boolean] = None,
      warmType: Option[String] = None,
      warmCount: Option[Int] = None,
      coldStorageOptions: Option[ColdStorageOptions] = None
    ): ElasticsearchClusterConfig =
      ElasticsearchClusterConfig
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(dedicatedMasterEnabled)(_.dedicatedMasterEnabled(_))
        .ifSome(zoneAwarenessEnabled)(_.zoneAwarenessEnabled(_))
        .ifSome(zoneAwarenessConfig)(_.zoneAwarenessConfig(_))
        .ifSome(dedicatedMasterType)(_.dedicatedMasterType(_))
        .ifSome(dedicatedMasterCount)(_.dedicatedMasterCount(_))
        .ifSome(warmEnabled)(_.warmEnabled(_))
        .ifSome(warmType)(_.warmType(_))
        .ifSome(warmCount)(_.warmCount(_))
        .ifSome(coldStorageOptions)(_.coldStorageOptions(_))
        .build

    def elasticsearchClusterConfigStatus(
      options: Option[ElasticsearchClusterConfig] = None,
      status: Option[OptionStatus] = None
    ): ElasticsearchClusterConfigStatus =
      ElasticsearchClusterConfigStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def elasticsearchDomainConfig(
      elasticsearchVersion: Option[ElasticsearchVersionStatus] = None,
      elasticsearchClusterConfig: Option[ElasticsearchClusterConfigStatus] = None,
      eBSOptions: Option[EBSOptionsStatus] = None,
      accessPolicies: Option[AccessPoliciesStatus] = None,
      snapshotOptions: Option[SnapshotOptionsStatus] = None,
      vPCOptions: Option[VPCDerivedInfoStatus] = None,
      cognitoOptions: Option[CognitoOptionsStatus] = None,
      encryptionAtRestOptions: Option[EncryptionAtRestOptionsStatus] = None,
      nodeToNodeEncryptionOptions: Option[NodeToNodeEncryptionOptionsStatus] = None,
      advancedOptions: Option[AdvancedOptionsStatus] = None,
      logPublishingOptions: Option[LogPublishingOptionsStatus] = None,
      domainEndpointOptions: Option[DomainEndpointOptionsStatus] = None,
      advancedSecurityOptions: Option[AdvancedSecurityOptionsStatus] = None,
      autoTuneOptions: Option[AutoTuneOptionsStatus] = None
    ): ElasticsearchDomainConfig =
      ElasticsearchDomainConfig
        .builder
        .ifSome(elasticsearchVersion)(_.elasticsearchVersion(_))
        .ifSome(elasticsearchClusterConfig)(_.elasticsearchClusterConfig(_))
        .ifSome(eBSOptions)(_.eBSOptions(_))
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .ifSome(snapshotOptions)(_.snapshotOptions(_))
        .ifSome(vPCOptions)(_.vPCOptions(_))
        .ifSome(cognitoOptions)(_.cognitoOptions(_))
        .ifSome(encryptionAtRestOptions)(_.encryptionAtRestOptions(_))
        .ifSome(nodeToNodeEncryptionOptions)(_.nodeToNodeEncryptionOptions(_))
        .ifSome(advancedOptions)(_.advancedOptions(_))
        .ifSome(logPublishingOptions)(_.logPublishingOptions(_))
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .ifSome(advancedSecurityOptions)(_.advancedSecurityOptions(_))
        .ifSome(autoTuneOptions)(_.autoTuneOptions(_))
        .build

    def elasticsearchDomainStatus(
      domainId: Option[String] = None,
      domainName: Option[String] = None,
      aRN: Option[String] = None,
      created: Option[Boolean] = None,
      deleted: Option[Boolean] = None,
      endpoint: Option[String] = None,
      endpoints: Option[EndpointsMap] = None,
      processing: Option[Boolean] = None,
      upgradeProcessing: Option[Boolean] = None,
      elasticsearchVersion: Option[String] = None,
      elasticsearchClusterConfig: Option[ElasticsearchClusterConfig] = None,
      eBSOptions: Option[EBSOptions] = None,
      accessPolicies: Option[String] = None,
      snapshotOptions: Option[SnapshotOptions] = None,
      vPCOptions: Option[VPCDerivedInfo] = None,
      cognitoOptions: Option[CognitoOptions] = None,
      encryptionAtRestOptions: Option[EncryptionAtRestOptions] = None,
      nodeToNodeEncryptionOptions: Option[NodeToNodeEncryptionOptions] = None,
      advancedOptions: Option[AdvancedOptions] = None,
      logPublishingOptions: Option[LogPublishingOptions] = None,
      serviceSoftwareOptions: Option[ServiceSoftwareOptions] = None,
      domainEndpointOptions: Option[DomainEndpointOptions] = None,
      advancedSecurityOptions: Option[AdvancedSecurityOptions] = None,
      autoTuneOptions: Option[AutoTuneOptionsOutput] = None
    ): ElasticsearchDomainStatus =
      ElasticsearchDomainStatus
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(created)(_.created(_))
        .ifSome(deleted)(_.deleted(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(processing)(_.processing(_))
        .ifSome(upgradeProcessing)(_.upgradeProcessing(_))
        .ifSome(elasticsearchVersion)(_.elasticsearchVersion(_))
        .ifSome(elasticsearchClusterConfig)(_.elasticsearchClusterConfig(_))
        .ifSome(eBSOptions)(_.eBSOptions(_))
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .ifSome(snapshotOptions)(_.snapshotOptions(_))
        .ifSome(vPCOptions)(_.vPCOptions(_))
        .ifSome(cognitoOptions)(_.cognitoOptions(_))
        .ifSome(encryptionAtRestOptions)(_.encryptionAtRestOptions(_))
        .ifSome(nodeToNodeEncryptionOptions)(_.nodeToNodeEncryptionOptions(_))
        .ifSome(advancedOptions)(_.advancedOptions(_))
        .ifSome(logPublishingOptions)(_.logPublishingOptions(_))
        .ifSome(serviceSoftwareOptions)(_.serviceSoftwareOptions(_))
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .ifSome(advancedSecurityOptions)(_.advancedSecurityOptions(_))
        .ifSome(autoTuneOptions)(_.autoTuneOptions(_))
        .build

    def elasticsearchVersionStatus(
      options: Option[String] = None,
      status: Option[OptionStatus] = None
    ): ElasticsearchVersionStatus =
      ElasticsearchVersionStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def encryptionAtRestOptions(
      enabled: Option[Boolean] = None,
      kmsKeyId: Option[String] = None
    ): EncryptionAtRestOptions =
      EncryptionAtRestOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def encryptionAtRestOptionsStatus(
      options: Option[EncryptionAtRestOptions] = None,
      status: Option[OptionStatus] = None
    ): EncryptionAtRestOptionsStatus =
      EncryptionAtRestOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def errorDetails(
      errorType: Option[String] = None,
      errorMessage: Option[String] = None
    ): ErrorDetails =
      ErrorDetails
        .builder
        .ifSome(errorType)(_.errorType(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[NonEmptyString]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def getCompatibleElasticsearchVersionsRequest(
      domainName: Option[String] = None
    ): GetCompatibleElasticsearchVersionsRequest =
      GetCompatibleElasticsearchVersionsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getCompatibleElasticsearchVersionsResponse(
      compatibleElasticsearchVersions: Option[List[CompatibleVersionsMap]] = None
    ): GetCompatibleElasticsearchVersionsResponse =
      GetCompatibleElasticsearchVersionsResponse
        .builder
        .ifSome(compatibleElasticsearchVersions)(_.compatibleElasticsearchVersions(_))
        .build

    def getPackageVersionHistoryRequest(
      packageID: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetPackageVersionHistoryRequest =
      GetPackageVersionHistoryRequest
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getPackageVersionHistoryResponse(
      packageID: Option[String] = None,
      packageVersionHistoryList: Option[List[PackageVersionHistory]] = None,
      nextToken: Option[String] = None
    ): GetPackageVersionHistoryResponse =
      GetPackageVersionHistoryResponse
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(packageVersionHistoryList)(_.packageVersionHistoryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getUpgradeHistoryRequest(
      domainName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetUpgradeHistoryRequest =
      GetUpgradeHistoryRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getUpgradeHistoryResponse(
      upgradeHistories: Option[List[UpgradeHistory]] = None,
      nextToken: Option[String] = None
    ): GetUpgradeHistoryResponse =
      GetUpgradeHistoryResponse
        .builder
        .ifSome(upgradeHistories)(_.upgradeHistories(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getUpgradeStatusRequest(
      domainName: Option[String] = None
    ): GetUpgradeStatusRequest =
      GetUpgradeStatusRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getUpgradeStatusResponse(
      upgradeStep: Option[String] = None,
      stepStatus: Option[String] = None,
      upgradeName: Option[String] = None
    ): GetUpgradeStatusResponse =
      GetUpgradeStatusResponse
        .builder
        .ifSome(upgradeStep)(_.upgradeStep(_))
        .ifSome(stepStatus)(_.stepStatus(_))
        .ifSome(upgradeName)(_.upgradeName(_))
        .build

    def inboundCrossClusterSearchConnection(
      sourceDomainInfo: Option[DomainInformation] = None,
      destinationDomainInfo: Option[DomainInformation] = None,
      crossClusterSearchConnectionId: Option[String] = None,
      connectionStatus: Option[InboundCrossClusterSearchConnectionStatus] = None
    ): InboundCrossClusterSearchConnection =
      InboundCrossClusterSearchConnection
        .builder
        .ifSome(sourceDomainInfo)(_.sourceDomainInfo(_))
        .ifSome(destinationDomainInfo)(_.destinationDomainInfo(_))
        .ifSome(crossClusterSearchConnectionId)(_.crossClusterSearchConnectionId(_))
        .ifSome(connectionStatus)(_.connectionStatus(_))
        .build

    def inboundCrossClusterSearchConnectionStatus(
      statusCode: Option[String] = None,
      message: Option[String] = None
    ): InboundCrossClusterSearchConnectionStatus =
      InboundCrossClusterSearchConnectionStatus
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(message)(_.message(_))
        .build

    def instanceCountLimits(
      minimumInstanceCount: Option[Int] = None,
      maximumInstanceCount: Option[Int] = None
    ): InstanceCountLimits =
      InstanceCountLimits
        .builder
        .ifSome(minimumInstanceCount)(_.minimumInstanceCount(_))
        .ifSome(maximumInstanceCount)(_.maximumInstanceCount(_))
        .build

    def instanceLimits(
      instanceCountLimits: Option[InstanceCountLimits] = None
    ): InstanceLimits =
      InstanceLimits
        .builder
        .ifSome(instanceCountLimits)(_.instanceCountLimits(_))
        .build

    def internalException(

    ): InternalException =
      InternalException
        .builder

        .build

    def invalidPaginationTokenException(

    ): InvalidPaginationTokenException =
      InvalidPaginationTokenException
        .builder

        .build

    def invalidTypeException(

    ): InvalidTypeException =
      InvalidTypeException
        .builder

        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def limits(
      storageTypes: Option[List[StorageType]] = None,
      instanceLimits: Option[InstanceLimits] = None,
      additionalLimits: Option[List[AdditionalLimit]] = None
    ): Limits =
      Limits
        .builder
        .ifSome(storageTypes)(_.storageTypes(_))
        .ifSome(instanceLimits)(_.instanceLimits(_))
        .ifSome(additionalLimits)(_.additionalLimits(_))
        .build

    def listDomainNamesResponse(
      domainNames: Option[List[DomainInfo]] = None
    ): ListDomainNamesResponse =
      ListDomainNamesResponse
        .builder
        .ifSome(domainNames)(_.domainNames(_))
        .build

    def listDomainsForPackageRequest(
      packageID: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDomainsForPackageRequest =
      ListDomainsForPackageRequest
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDomainsForPackageResponse(
      domainPackageDetailsList: Option[List[DomainPackageDetails]] = None,
      nextToken: Option[String] = None
    ): ListDomainsForPackageResponse =
      ListDomainsForPackageResponse
        .builder
        .ifSome(domainPackageDetailsList)(_.domainPackageDetailsList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listElasticsearchInstanceTypesRequest(
      elasticsearchVersion: Option[String] = None,
      domainName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListElasticsearchInstanceTypesRequest =
      ListElasticsearchInstanceTypesRequest
        .builder
        .ifSome(elasticsearchVersion)(_.elasticsearchVersion(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listElasticsearchInstanceTypesResponse(
      elasticsearchInstanceTypes: Option[List[ESPartitionInstanceType]] = None,
      nextToken: Option[String] = None
    ): ListElasticsearchInstanceTypesResponse =
      ListElasticsearchInstanceTypesResponse
        .builder
        .ifSome(elasticsearchInstanceTypes)(_.elasticsearchInstanceTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listElasticsearchVersionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListElasticsearchVersionsRequest =
      ListElasticsearchVersionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listElasticsearchVersionsResponse(
      elasticsearchVersions: Option[List[ElasticsearchVersionString]] = None,
      nextToken: Option[String] = None
    ): ListElasticsearchVersionsResponse =
      ListElasticsearchVersionsResponse
        .builder
        .ifSome(elasticsearchVersions)(_.elasticsearchVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackagesForDomainRequest(
      domainName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPackagesForDomainRequest =
      ListPackagesForDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackagesForDomainResponse(
      domainPackageDetailsList: Option[List[DomainPackageDetails]] = None,
      nextToken: Option[String] = None
    ): ListPackagesForDomainResponse =
      ListPackagesForDomainResponse
        .builder
        .ifSome(domainPackageDetailsList)(_.domainPackageDetailsList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsRequest(
      aRN: Option[String] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(aRN)(_.aRN(_))
        .build

    def listTagsResponse(
      tagList: Option[List[Tag]] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(tagList)(_.tagList(_))
        .build

    def logPublishingOption(
      cloudWatchLogsLogGroupArn: Option[String] = None,
      enabled: Option[Boolean] = None
    ): LogPublishingOption =
      LogPublishingOption
        .builder
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def logPublishingOptionsStatus(
      options: Option[LogPublishingOptions] = None,
      status: Option[OptionStatus] = None
    ): LogPublishingOptionsStatus =
      LogPublishingOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def masterUserOptions(
      masterUserARN: Option[String] = None,
      masterUserName: Option[String] = None,
      masterUserPassword: Option[String] = None
    ): MasterUserOptions =
      MasterUserOptions
        .builder
        .ifSome(masterUserARN)(_.masterUserARN(_))
        .ifSome(masterUserName)(_.masterUserName(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .build

    def nodeToNodeEncryptionOptions(
      enabled: Option[Boolean] = None
    ): NodeToNodeEncryptionOptions =
      NodeToNodeEncryptionOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def nodeToNodeEncryptionOptionsStatus(
      options: Option[NodeToNodeEncryptionOptions] = None,
      status: Option[OptionStatus] = None
    ): NodeToNodeEncryptionOptionsStatus =
      NodeToNodeEncryptionOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def optionStatus(
      creationDate: Option[UpdateTimestamp] = None,
      updateDate: Option[UpdateTimestamp] = None,
      updateVersion: Option[Int] = None,
      state: Option[String] = None,
      pendingDeletion: Option[Boolean] = None
    ): OptionStatus =
      OptionStatus
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(updateDate)(_.updateDate(_))
        .ifSome(updateVersion)(_.updateVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(pendingDeletion)(_.pendingDeletion(_))
        .build

    def outboundCrossClusterSearchConnection(
      sourceDomainInfo: Option[DomainInformation] = None,
      destinationDomainInfo: Option[DomainInformation] = None,
      crossClusterSearchConnectionId: Option[String] = None,
      connectionAlias: Option[String] = None,
      connectionStatus: Option[OutboundCrossClusterSearchConnectionStatus] = None
    ): OutboundCrossClusterSearchConnection =
      OutboundCrossClusterSearchConnection
        .builder
        .ifSome(sourceDomainInfo)(_.sourceDomainInfo(_))
        .ifSome(destinationDomainInfo)(_.destinationDomainInfo(_))
        .ifSome(crossClusterSearchConnectionId)(_.crossClusterSearchConnectionId(_))
        .ifSome(connectionAlias)(_.connectionAlias(_))
        .ifSome(connectionStatus)(_.connectionStatus(_))
        .build

    def outboundCrossClusterSearchConnectionStatus(
      statusCode: Option[String] = None,
      message: Option[String] = None
    ): OutboundCrossClusterSearchConnectionStatus =
      OutboundCrossClusterSearchConnectionStatus
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(message)(_.message(_))
        .build

    def packageDetails(
      packageID: Option[String] = None,
      packageName: Option[String] = None,
      packageType: Option[String] = None,
      packageDescription: Option[String] = None,
      packageStatus: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      lastUpdatedAt: Option[LastUpdated] = None,
      availablePackageVersion: Option[String] = None,
      errorDetails: Option[ErrorDetails] = None
    ): PackageDetails =
      PackageDetails
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(packageName)(_.packageName(_))
        .ifSome(packageType)(_.packageType(_))
        .ifSome(packageDescription)(_.packageDescription(_))
        .ifSome(packageStatus)(_.packageStatus(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(availablePackageVersion)(_.availablePackageVersion(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .build

    def packageSource(
      s3BucketName: Option[String] = None,
      s3Key: Option[String] = None
    ): PackageSource =
      PackageSource
        .builder
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def packageVersionHistory(
      packageVersion: Option[String] = None,
      commitMessage: Option[String] = None,
      createdAt: Option[CreatedAt] = None
    ): PackageVersionHistory =
      PackageVersionHistory
        .builder
        .ifSome(packageVersion)(_.packageVersion(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def purchaseReservedElasticsearchInstanceOfferingRequest(
      reservedElasticsearchInstanceOfferingId: Option[String] = None,
      reservationName: Option[String] = None,
      instanceCount: Option[Int] = None
    ): PurchaseReservedElasticsearchInstanceOfferingRequest =
      PurchaseReservedElasticsearchInstanceOfferingRequest
        .builder
        .ifSome(reservedElasticsearchInstanceOfferingId)(_.reservedElasticsearchInstanceOfferingId(_))
        .ifSome(reservationName)(_.reservationName(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .build

    def purchaseReservedElasticsearchInstanceOfferingResponse(
      reservedElasticsearchInstanceId: Option[String] = None,
      reservationName: Option[String] = None
    ): PurchaseReservedElasticsearchInstanceOfferingResponse =
      PurchaseReservedElasticsearchInstanceOfferingResponse
        .builder
        .ifSome(reservedElasticsearchInstanceId)(_.reservedElasticsearchInstanceId(_))
        .ifSome(reservationName)(_.reservationName(_))
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

    def rejectInboundCrossClusterSearchConnectionRequest(
      crossClusterSearchConnectionId: Option[String] = None
    ): RejectInboundCrossClusterSearchConnectionRequest =
      RejectInboundCrossClusterSearchConnectionRequest
        .builder
        .ifSome(crossClusterSearchConnectionId)(_.crossClusterSearchConnectionId(_))
        .build

    def rejectInboundCrossClusterSearchConnectionResponse(
      crossClusterSearchConnection: Option[InboundCrossClusterSearchConnection] = None
    ): RejectInboundCrossClusterSearchConnectionResponse =
      RejectInboundCrossClusterSearchConnectionResponse
        .builder
        .ifSome(crossClusterSearchConnection)(_.crossClusterSearchConnection(_))
        .build

    def removeTagsRequest(
      aRN: Option[String] = None,
      tagKeys: Option[List[String]] = None
    ): RemoveTagsRequest =
      RemoveTagsRequest
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def reservedElasticsearchInstance(
      reservationName: Option[String] = None,
      reservedElasticsearchInstanceId: Option[String] = None,
      reservedElasticsearchInstanceOfferingId: Option[String] = None,
      elasticsearchInstanceType: Option[String] = None,
      startTime: Option[UpdateTimestamp] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      currencyCode: Option[String] = None,
      elasticsearchInstanceCount: Option[Int] = None,
      state: Option[String] = None,
      paymentOption: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None
    ): ReservedElasticsearchInstance =
      ReservedElasticsearchInstance
        .builder
        .ifSome(reservationName)(_.reservationName(_))
        .ifSome(reservedElasticsearchInstanceId)(_.reservedElasticsearchInstanceId(_))
        .ifSome(reservedElasticsearchInstanceOfferingId)(_.reservedElasticsearchInstanceOfferingId(_))
        .ifSome(elasticsearchInstanceType)(_.elasticsearchInstanceType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(elasticsearchInstanceCount)(_.elasticsearchInstanceCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .build

    def reservedElasticsearchInstanceOffering(
      reservedElasticsearchInstanceOfferingId: Option[String] = None,
      elasticsearchInstanceType: Option[String] = None,
      duration: Option[Int] = None,
      fixedPrice: Option[Double] = None,
      usagePrice: Option[Double] = None,
      currencyCode: Option[String] = None,
      paymentOption: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None
    ): ReservedElasticsearchInstanceOffering =
      ReservedElasticsearchInstanceOffering
        .builder
        .ifSome(reservedElasticsearchInstanceOfferingId)(_.reservedElasticsearchInstanceOfferingId(_))
        .ifSome(elasticsearchInstanceType)(_.elasticsearchInstanceType(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .build

    def resourceAlreadyExistsException(

    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def sAMLIdp(
      metadataContent: Option[String] = None,
      entityId: Option[String] = None
    ): SAMLIdp =
      SAMLIdp
        .builder
        .ifSome(metadataContent)(_.metadataContent(_))
        .ifSome(entityId)(_.entityId(_))
        .build

    def sAMLOptionsInput(
      enabled: Option[Boolean] = None,
      idp: Option[SAMLIdp] = None,
      masterUserName: Option[String] = None,
      masterBackendRole: Option[String] = None,
      subjectKey: Option[String] = None,
      rolesKey: Option[String] = None,
      sessionTimeoutMinutes: Option[Int] = None
    ): SAMLOptionsInput =
      SAMLOptionsInput
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(idp)(_.idp(_))
        .ifSome(masterUserName)(_.masterUserName(_))
        .ifSome(masterBackendRole)(_.masterBackendRole(_))
        .ifSome(subjectKey)(_.subjectKey(_))
        .ifSome(rolesKey)(_.rolesKey(_))
        .ifSome(sessionTimeoutMinutes)(_.sessionTimeoutMinutes(_))
        .build

    def sAMLOptionsOutput(
      enabled: Option[Boolean] = None,
      idp: Option[SAMLIdp] = None,
      subjectKey: Option[String] = None,
      rolesKey: Option[String] = None,
      sessionTimeoutMinutes: Option[Int] = None
    ): SAMLOptionsOutput =
      SAMLOptionsOutput
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(idp)(_.idp(_))
        .ifSome(subjectKey)(_.subjectKey(_))
        .ifSome(rolesKey)(_.rolesKey(_))
        .ifSome(sessionTimeoutMinutes)(_.sessionTimeoutMinutes(_))
        .build

    def scheduledAutoTuneDetails(
      date: Option[AutoTuneDate] = None,
      actionType: Option[String] = None,
      action: Option[String] = None,
      severity: Option[String] = None
    ): ScheduledAutoTuneDetails =
      ScheduledAutoTuneDetails
        .builder
        .ifSome(date)(_.date(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(action)(_.action(_))
        .ifSome(severity)(_.severity(_))
        .build

    def serviceSoftwareOptions(
      currentVersion: Option[String] = None,
      newVersion: Option[String] = None,
      updateAvailable: Option[Boolean] = None,
      cancellable: Option[Boolean] = None,
      updateStatus: Option[String] = None,
      description: Option[String] = None,
      automatedUpdateDate: Option[DeploymentCloseDateTimeStamp] = None,
      optionalDeployment: Option[Boolean] = None
    ): ServiceSoftwareOptions =
      ServiceSoftwareOptions
        .builder
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(newVersion)(_.newVersion(_))
        .ifSome(updateAvailable)(_.updateAvailable(_))
        .ifSome(cancellable)(_.cancellable(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .ifSome(description)(_.description(_))
        .ifSome(automatedUpdateDate)(_.automatedUpdateDate(_))
        .ifSome(optionalDeployment)(_.optionalDeployment(_))
        .build

    def snapshotOptions(
      automatedSnapshotStartHour: Option[Int] = None
    ): SnapshotOptions =
      SnapshotOptions
        .builder
        .ifSome(automatedSnapshotStartHour)(_.automatedSnapshotStartHour(_))
        .build

    def snapshotOptionsStatus(
      options: Option[SnapshotOptions] = None,
      status: Option[OptionStatus] = None
    ): SnapshotOptionsStatus =
      SnapshotOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def startElasticsearchServiceSoftwareUpdateRequest(
      domainName: Option[String] = None
    ): StartElasticsearchServiceSoftwareUpdateRequest =
      StartElasticsearchServiceSoftwareUpdateRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def startElasticsearchServiceSoftwareUpdateResponse(
      serviceSoftwareOptions: Option[ServiceSoftwareOptions] = None
    ): StartElasticsearchServiceSoftwareUpdateResponse =
      StartElasticsearchServiceSoftwareUpdateResponse
        .builder
        .ifSome(serviceSoftwareOptions)(_.serviceSoftwareOptions(_))
        .build

    def storageType(
      storageTypeName: Option[String] = None,
      storageSubTypeName: Option[String] = None,
      storageTypeLimits: Option[List[StorageTypeLimit]] = None
    ): StorageType =
      StorageType
        .builder
        .ifSome(storageTypeName)(_.storageTypeName(_))
        .ifSome(storageSubTypeName)(_.storageSubTypeName(_))
        .ifSome(storageTypeLimits)(_.storageTypeLimits(_))
        .build

    def storageTypeLimit(
      limitName: Option[String] = None,
      limitValues: Option[List[LimitValue]] = None
    ): StorageTypeLimit =
      StorageTypeLimit
        .builder
        .ifSome(limitName)(_.limitName(_))
        .ifSome(limitValues)(_.limitValues(_))
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

    def updateElasticsearchDomainConfigRequest(
      domainName: Option[String] = None,
      elasticsearchClusterConfig: Option[ElasticsearchClusterConfig] = None,
      eBSOptions: Option[EBSOptions] = None,
      snapshotOptions: Option[SnapshotOptions] = None,
      vPCOptions: Option[VPCOptions] = None,
      cognitoOptions: Option[CognitoOptions] = None,
      advancedOptions: Option[AdvancedOptions] = None,
      accessPolicies: Option[String] = None,
      logPublishingOptions: Option[LogPublishingOptions] = None,
      domainEndpointOptions: Option[DomainEndpointOptions] = None,
      advancedSecurityOptions: Option[AdvancedSecurityOptionsInput] = None,
      nodeToNodeEncryptionOptions: Option[NodeToNodeEncryptionOptions] = None,
      encryptionAtRestOptions: Option[EncryptionAtRestOptions] = None,
      autoTuneOptions: Option[AutoTuneOptions] = None
    ): UpdateElasticsearchDomainConfigRequest =
      UpdateElasticsearchDomainConfigRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(elasticsearchClusterConfig)(_.elasticsearchClusterConfig(_))
        .ifSome(eBSOptions)(_.eBSOptions(_))
        .ifSome(snapshotOptions)(_.snapshotOptions(_))
        .ifSome(vPCOptions)(_.vPCOptions(_))
        .ifSome(cognitoOptions)(_.cognitoOptions(_))
        .ifSome(advancedOptions)(_.advancedOptions(_))
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .ifSome(logPublishingOptions)(_.logPublishingOptions(_))
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .ifSome(advancedSecurityOptions)(_.advancedSecurityOptions(_))
        .ifSome(nodeToNodeEncryptionOptions)(_.nodeToNodeEncryptionOptions(_))
        .ifSome(encryptionAtRestOptions)(_.encryptionAtRestOptions(_))
        .ifSome(autoTuneOptions)(_.autoTuneOptions(_))
        .build

    def updateElasticsearchDomainConfigResponse(
      domainConfig: Option[ElasticsearchDomainConfig] = None
    ): UpdateElasticsearchDomainConfigResponse =
      UpdateElasticsearchDomainConfigResponse
        .builder
        .ifSome(domainConfig)(_.domainConfig(_))
        .build

    def updatePackageRequest(
      packageID: Option[String] = None,
      packageSource: Option[PackageSource] = None,
      packageDescription: Option[String] = None,
      commitMessage: Option[String] = None
    ): UpdatePackageRequest =
      UpdatePackageRequest
        .builder
        .ifSome(packageID)(_.packageID(_))
        .ifSome(packageSource)(_.packageSource(_))
        .ifSome(packageDescription)(_.packageDescription(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .build

    def updatePackageResponse(
      packageDetails: Option[PackageDetails] = None
    ): UpdatePackageResponse =
      UpdatePackageResponse
        .builder
        .ifSome(packageDetails)(_.packageDetails(_))
        .build

    def upgradeElasticsearchDomainRequest(
      domainName: Option[String] = None,
      targetVersion: Option[String] = None,
      performCheckOnly: Option[Boolean] = None
    ): UpgradeElasticsearchDomainRequest =
      UpgradeElasticsearchDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(targetVersion)(_.targetVersion(_))
        .ifSome(performCheckOnly)(_.performCheckOnly(_))
        .build

    def upgradeElasticsearchDomainResponse(
      domainName: Option[String] = None,
      targetVersion: Option[String] = None,
      performCheckOnly: Option[Boolean] = None
    ): UpgradeElasticsearchDomainResponse =
      UpgradeElasticsearchDomainResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(targetVersion)(_.targetVersion(_))
        .ifSome(performCheckOnly)(_.performCheckOnly(_))
        .build

    def upgradeHistory(
      upgradeName: Option[String] = None,
      startTimestamp: Option[StartTimestamp] = None,
      upgradeStatus: Option[String] = None,
      stepsList: Option[List[UpgradeStepItem]] = None
    ): UpgradeHistory =
      UpgradeHistory
        .builder
        .ifSome(upgradeName)(_.upgradeName(_))
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(upgradeStatus)(_.upgradeStatus(_))
        .ifSome(stepsList)(_.stepsList(_))
        .build

    def upgradeStepItem(
      upgradeStep: Option[String] = None,
      upgradeStepStatus: Option[String] = None,
      issues: Option[List[Issue]] = None,
      progressPercent: Option[Double] = None
    ): UpgradeStepItem =
      UpgradeStepItem
        .builder
        .ifSome(upgradeStep)(_.upgradeStep(_))
        .ifSome(upgradeStepStatus)(_.upgradeStepStatus(_))
        .ifSome(issues)(_.issues(_))
        .ifSome(progressPercent)(_.progressPercent(_))
        .build

    def vPCDerivedInfo(
      vPCId: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      availabilityZones: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None
    ): VPCDerivedInfo =
      VPCDerivedInfo
        .builder
        .ifSome(vPCId)(_.vPCId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def vPCDerivedInfoStatus(
      options: Option[VPCDerivedInfo] = None,
      status: Option[OptionStatus] = None
    ): VPCDerivedInfoStatus =
      VPCDerivedInfoStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def vPCOptions(
      subnetIds: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None
    ): VPCOptions =
      VPCOptions
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def validationException(

    ): ValidationException =
      ValidationException
        .builder

        .build

    def zoneAwarenessConfig(
      availabilityZoneCount: Option[Int] = None
    ): ZoneAwarenessConfig =
      ZoneAwarenessConfig
        .builder
        .ifSome(availabilityZoneCount)(_.availabilityZoneCount(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
