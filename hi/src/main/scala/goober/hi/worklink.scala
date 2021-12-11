package goober.hi

import goober.free.worklink.WorkLinkIO
import software.amazon.awssdk.services.worklink.model._


object worklink {
  import goober.free.{worklink ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateDomainRequest(
      fleetArn: Option[String] = None,
      domainName: Option[String] = None,
      displayName: Option[String] = None,
      acmCertificateArn: Option[String] = None
    ): AssociateDomainRequest =
      AssociateDomainRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(acmCertificateArn)(_.acmCertificateArn(_))
        .build

    def associateDomainResponse(

    ): AssociateDomainResponse =
      AssociateDomainResponse
        .builder

        .build

    def associateWebsiteAuthorizationProviderRequest(
      fleetArn: Option[String] = None,
      authorizationProviderType: Option[String] = None,
      domainName: Option[String] = None
    ): AssociateWebsiteAuthorizationProviderRequest =
      AssociateWebsiteAuthorizationProviderRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(authorizationProviderType)(_.authorizationProviderType(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def associateWebsiteAuthorizationProviderResponse(
      authorizationProviderId: Option[String] = None
    ): AssociateWebsiteAuthorizationProviderResponse =
      AssociateWebsiteAuthorizationProviderResponse
        .builder
        .ifSome(authorizationProviderId)(_.authorizationProviderId(_))
        .build

    def associateWebsiteCertificateAuthorityRequest(
      fleetArn: Option[String] = None,
      certificate: Option[String] = None,
      displayName: Option[String] = None
    ): AssociateWebsiteCertificateAuthorityRequest =
      AssociateWebsiteCertificateAuthorityRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def associateWebsiteCertificateAuthorityResponse(
      websiteCaId: Option[String] = None
    ): AssociateWebsiteCertificateAuthorityResponse =
      AssociateWebsiteCertificateAuthorityResponse
        .builder
        .ifSome(websiteCaId)(_.websiteCaId(_))
        .build

    def createFleetRequest(
      fleetName: Option[String] = None,
      displayName: Option[String] = None,
      optimizeForEndUserLocation: Option[Boolean] = None,
      tags: Option[TagMap] = None
    ): CreateFleetRequest =
      CreateFleetRequest
        .builder
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(optimizeForEndUserLocation)(_.optimizeForEndUserLocation(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFleetResponse(
      fleetArn: Option[String] = None
    ): CreateFleetResponse =
      CreateFleetResponse
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def deleteFleetRequest(
      fleetArn: Option[String] = None
    ): DeleteFleetRequest =
      DeleteFleetRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def deleteFleetResponse(

    ): DeleteFleetResponse =
      DeleteFleetResponse
        .builder

        .build

    def describeAuditStreamConfigurationRequest(
      fleetArn: Option[String] = None
    ): DescribeAuditStreamConfigurationRequest =
      DescribeAuditStreamConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def describeAuditStreamConfigurationResponse(
      auditStreamArn: Option[String] = None
    ): DescribeAuditStreamConfigurationResponse =
      DescribeAuditStreamConfigurationResponse
        .builder
        .ifSome(auditStreamArn)(_.auditStreamArn(_))
        .build

    def describeCompanyNetworkConfigurationRequest(
      fleetArn: Option[String] = None
    ): DescribeCompanyNetworkConfigurationRequest =
      DescribeCompanyNetworkConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def describeCompanyNetworkConfigurationResponse(
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): DescribeCompanyNetworkConfigurationResponse =
      DescribeCompanyNetworkConfigurationResponse
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def describeDevicePolicyConfigurationRequest(
      fleetArn: Option[String] = None
    ): DescribeDevicePolicyConfigurationRequest =
      DescribeDevicePolicyConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def describeDevicePolicyConfigurationResponse(
      deviceCaCertificate: Option[String] = None
    ): DescribeDevicePolicyConfigurationResponse =
      DescribeDevicePolicyConfigurationResponse
        .builder
        .ifSome(deviceCaCertificate)(_.deviceCaCertificate(_))
        .build

    def describeDeviceRequest(
      fleetArn: Option[String] = None,
      deviceId: Option[String] = None
    ): DescribeDeviceRequest =
      DescribeDeviceRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def describeDeviceResponse(
      status: Option[String] = None,
      model: Option[String] = None,
      manufacturer: Option[String] = None,
      operatingSystem: Option[String] = None,
      operatingSystemVersion: Option[String] = None,
      patchLevel: Option[String] = None,
      firstAccessedTime: Option[DateTime] = None,
      lastAccessedTime: Option[DateTime] = None,
      username: Option[String] = None
    ): DescribeDeviceResponse =
      DescribeDeviceResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(model)(_.model(_))
        .ifSome(manufacturer)(_.manufacturer(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(operatingSystemVersion)(_.operatingSystemVersion(_))
        .ifSome(patchLevel)(_.patchLevel(_))
        .ifSome(firstAccessedTime)(_.firstAccessedTime(_))
        .ifSome(lastAccessedTime)(_.lastAccessedTime(_))
        .ifSome(username)(_.username(_))
        .build

    def describeDomainRequest(
      fleetArn: Option[String] = None,
      domainName: Option[String] = None
    ): DescribeDomainRequest =
      DescribeDomainRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def describeDomainResponse(
      domainName: Option[String] = None,
      displayName: Option[String] = None,
      createdTime: Option[DateTime] = None,
      domainStatus: Option[String] = None,
      acmCertificateArn: Option[String] = None
    ): DescribeDomainResponse =
      DescribeDomainResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(domainStatus)(_.domainStatus(_))
        .ifSome(acmCertificateArn)(_.acmCertificateArn(_))
        .build

    def describeFleetMetadataRequest(
      fleetArn: Option[String] = None
    ): DescribeFleetMetadataRequest =
      DescribeFleetMetadataRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def describeFleetMetadataResponse(
      createdTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None,
      fleetName: Option[String] = None,
      displayName: Option[String] = None,
      optimizeForEndUserLocation: Option[Boolean] = None,
      companyCode: Option[String] = None,
      fleetStatus: Option[String] = None,
      tags: Option[TagMap] = None
    ): DescribeFleetMetadataResponse =
      DescribeFleetMetadataResponse
        .builder
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(optimizeForEndUserLocation)(_.optimizeForEndUserLocation(_))
        .ifSome(companyCode)(_.companyCode(_))
        .ifSome(fleetStatus)(_.fleetStatus(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeIdentityProviderConfigurationRequest(
      fleetArn: Option[String] = None
    ): DescribeIdentityProviderConfigurationRequest =
      DescribeIdentityProviderConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def describeIdentityProviderConfigurationResponse(
      identityProviderType: Option[String] = None,
      serviceProviderSamlMetadata: Option[String] = None,
      identityProviderSamlMetadata: Option[String] = None
    ): DescribeIdentityProviderConfigurationResponse =
      DescribeIdentityProviderConfigurationResponse
        .builder
        .ifSome(identityProviderType)(_.identityProviderType(_))
        .ifSome(serviceProviderSamlMetadata)(_.serviceProviderSamlMetadata(_))
        .ifSome(identityProviderSamlMetadata)(_.identityProviderSamlMetadata(_))
        .build

    def describeWebsiteCertificateAuthorityRequest(
      fleetArn: Option[String] = None,
      websiteCaId: Option[String] = None
    ): DescribeWebsiteCertificateAuthorityRequest =
      DescribeWebsiteCertificateAuthorityRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(websiteCaId)(_.websiteCaId(_))
        .build

    def describeWebsiteCertificateAuthorityResponse(
      certificate: Option[String] = None,
      createdTime: Option[DateTime] = None,
      displayName: Option[String] = None
    ): DescribeWebsiteCertificateAuthorityResponse =
      DescribeWebsiteCertificateAuthorityResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def deviceSummary(
      deviceId: Option[String] = None,
      deviceStatus: Option[String] = None
    ): DeviceSummary =
      DeviceSummary
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(deviceStatus)(_.deviceStatus(_))
        .build

    def disassociateDomainRequest(
      fleetArn: Option[String] = None,
      domainName: Option[String] = None
    ): DisassociateDomainRequest =
      DisassociateDomainRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def disassociateDomainResponse(

    ): DisassociateDomainResponse =
      DisassociateDomainResponse
        .builder

        .build

    def disassociateWebsiteAuthorizationProviderRequest(
      fleetArn: Option[String] = None,
      authorizationProviderId: Option[String] = None
    ): DisassociateWebsiteAuthorizationProviderRequest =
      DisassociateWebsiteAuthorizationProviderRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(authorizationProviderId)(_.authorizationProviderId(_))
        .build

    def disassociateWebsiteAuthorizationProviderResponse(

    ): DisassociateWebsiteAuthorizationProviderResponse =
      DisassociateWebsiteAuthorizationProviderResponse
        .builder

        .build

    def disassociateWebsiteCertificateAuthorityRequest(
      fleetArn: Option[String] = None,
      websiteCaId: Option[String] = None
    ): DisassociateWebsiteCertificateAuthorityRequest =
      DisassociateWebsiteCertificateAuthorityRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(websiteCaId)(_.websiteCaId(_))
        .build

    def disassociateWebsiteCertificateAuthorityResponse(

    ): DisassociateWebsiteCertificateAuthorityResponse =
      DisassociateWebsiteCertificateAuthorityResponse
        .builder

        .build

    def domainSummary(
      domainName: Option[String] = None,
      displayName: Option[String] = None,
      createdTime: Option[DateTime] = None,
      domainStatus: Option[String] = None
    ): DomainSummary =
      DomainSummary
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(domainStatus)(_.domainStatus(_))
        .build

    def fleetSummary(
      fleetArn: Option[String] = None,
      createdTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None,
      fleetName: Option[String] = None,
      displayName: Option[String] = None,
      companyCode: Option[String] = None,
      fleetStatus: Option[String] = None,
      tags: Option[TagMap] = None
    ): FleetSummary =
      FleetSummary
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(companyCode)(_.companyCode(_))
        .ifSome(fleetStatus)(_.fleetStatus(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDevicesRequest(
      fleetArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDevicesRequest =
      ListDevicesRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDevicesResponse(
      devices: Option[List[DeviceSummary]] = None,
      nextToken: Option[String] = None
    ): ListDevicesResponse =
      ListDevicesResponse
        .builder
        .ifSome(devices)(_.devices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDomainsRequest(
      fleetArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDomainsRequest =
      ListDomainsRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDomainsResponse(
      domains: Option[List[DomainSummary]] = None,
      nextToken: Option[String] = None
    ): ListDomainsResponse =
      ListDomainsResponse
        .builder
        .ifSome(domains)(_.domains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFleetsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFleetsRequest =
      ListFleetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFleetsResponse(
      fleetSummaryList: Option[List[FleetSummary]] = None,
      nextToken: Option[String] = None
    ): ListFleetsResponse =
      ListFleetsResponse
        .builder
        .ifSome(fleetSummaryList)(_.fleetSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listWebsiteAuthorizationProvidersRequest(
      fleetArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWebsiteAuthorizationProvidersRequest =
      ListWebsiteAuthorizationProvidersRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWebsiteAuthorizationProvidersResponse(
      websiteAuthorizationProviders: Option[List[WebsiteAuthorizationProviderSummary]] = None,
      nextToken: Option[String] = None
    ): ListWebsiteAuthorizationProvidersResponse =
      ListWebsiteAuthorizationProvidersResponse
        .builder
        .ifSome(websiteAuthorizationProviders)(_.websiteAuthorizationProviders(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWebsiteCertificateAuthoritiesRequest(
      fleetArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListWebsiteCertificateAuthoritiesRequest =
      ListWebsiteCertificateAuthoritiesRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWebsiteCertificateAuthoritiesResponse(
      websiteCertificateAuthorities: Option[List[WebsiteCaSummary]] = None,
      nextToken: Option[String] = None
    ): ListWebsiteCertificateAuthoritiesResponse =
      ListWebsiteCertificateAuthoritiesResponse
        .builder
        .ifSome(websiteCertificateAuthorities)(_.websiteCertificateAuthorities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def restoreDomainAccessRequest(
      fleetArn: Option[String] = None,
      domainName: Option[String] = None
    ): RestoreDomainAccessRequest =
      RestoreDomainAccessRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def restoreDomainAccessResponse(

    ): RestoreDomainAccessResponse =
      RestoreDomainAccessResponse
        .builder

        .build

    def revokeDomainAccessRequest(
      fleetArn: Option[String] = None,
      domainName: Option[String] = None
    ): RevokeDomainAccessRequest =
      RevokeDomainAccessRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def revokeDomainAccessResponse(

    ): RevokeDomainAccessResponse =
      RevokeDomainAccessResponse
        .builder

        .build

    def signOutUserRequest(
      fleetArn: Option[String] = None,
      username: Option[String] = None
    ): SignOutUserRequest =
      SignOutUserRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(username)(_.username(_))
        .build

    def signOutUserResponse(

    ): SignOutUserResponse =
      SignOutUserResponse
        .builder

        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateAuditStreamConfigurationRequest(
      fleetArn: Option[String] = None,
      auditStreamArn: Option[String] = None
    ): UpdateAuditStreamConfigurationRequest =
      UpdateAuditStreamConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(auditStreamArn)(_.auditStreamArn(_))
        .build

    def updateAuditStreamConfigurationResponse(

    ): UpdateAuditStreamConfigurationResponse =
      UpdateAuditStreamConfigurationResponse
        .builder

        .build

    def updateCompanyNetworkConfigurationRequest(
      fleetArn: Option[String] = None,
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): UpdateCompanyNetworkConfigurationRequest =
      UpdateCompanyNetworkConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def updateCompanyNetworkConfigurationResponse(

    ): UpdateCompanyNetworkConfigurationResponse =
      UpdateCompanyNetworkConfigurationResponse
        .builder

        .build

    def updateDevicePolicyConfigurationRequest(
      fleetArn: Option[String] = None,
      deviceCaCertificate: Option[String] = None
    ): UpdateDevicePolicyConfigurationRequest =
      UpdateDevicePolicyConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(deviceCaCertificate)(_.deviceCaCertificate(_))
        .build

    def updateDevicePolicyConfigurationResponse(

    ): UpdateDevicePolicyConfigurationResponse =
      UpdateDevicePolicyConfigurationResponse
        .builder

        .build

    def updateDomainMetadataRequest(
      fleetArn: Option[String] = None,
      domainName: Option[String] = None,
      displayName: Option[String] = None
    ): UpdateDomainMetadataRequest =
      UpdateDomainMetadataRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def updateDomainMetadataResponse(

    ): UpdateDomainMetadataResponse =
      UpdateDomainMetadataResponse
        .builder

        .build

    def updateFleetMetadataRequest(
      fleetArn: Option[String] = None,
      displayName: Option[String] = None,
      optimizeForEndUserLocation: Option[Boolean] = None
    ): UpdateFleetMetadataRequest =
      UpdateFleetMetadataRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(optimizeForEndUserLocation)(_.optimizeForEndUserLocation(_))
        .build

    def updateFleetMetadataResponse(

    ): UpdateFleetMetadataResponse =
      UpdateFleetMetadataResponse
        .builder

        .build

    def updateIdentityProviderConfigurationRequest(
      fleetArn: Option[String] = None,
      identityProviderType: Option[String] = None,
      identityProviderSamlMetadata: Option[String] = None
    ): UpdateIdentityProviderConfigurationRequest =
      UpdateIdentityProviderConfigurationRequest
        .builder
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(identityProviderType)(_.identityProviderType(_))
        .ifSome(identityProviderSamlMetadata)(_.identityProviderSamlMetadata(_))
        .build

    def updateIdentityProviderConfigurationResponse(

    ): UpdateIdentityProviderConfigurationResponse =
      UpdateIdentityProviderConfigurationResponse
        .builder

        .build

    def websiteAuthorizationProviderSummary(
      authorizationProviderId: Option[String] = None,
      authorizationProviderType: Option[String] = None,
      domainName: Option[String] = None,
      createdTime: Option[DateTime] = None
    ): WebsiteAuthorizationProviderSummary =
      WebsiteAuthorizationProviderSummary
        .builder
        .ifSome(authorizationProviderId)(_.authorizationProviderId(_))
        .ifSome(authorizationProviderType)(_.authorizationProviderType(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def websiteCaSummary(
      websiteCaId: Option[String] = None,
      createdTime: Option[DateTime] = None,
      displayName: Option[String] = None
    ): WebsiteCaSummary =
      WebsiteCaSummary
        .builder
        .ifSome(websiteCaId)(_.websiteCaId(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(displayName)(_.displayName(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
