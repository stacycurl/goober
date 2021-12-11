package goober.hi

import goober.free.networkmanager.NetworkManagerIO
import software.amazon.awssdk.services.networkmanager.model._


object networkmanager {
  import goober.free.{networkmanager ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aWSLocation(
      zone: Option[String] = None,
      subnetArn: Option[String] = None
    ): AWSLocation =
      AWSLocation
        .builder
        .ifSome(zone)(_.zone(_))
        .ifSome(subnetArn)(_.subnetArn(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associateCustomerGatewayRequest(
      customerGatewayArn: Option[String] = None,
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None
    ): AssociateCustomerGatewayRequest =
      AssociateCustomerGatewayRequest
        .builder
        .ifSome(customerGatewayArn)(_.customerGatewayArn(_))
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .build

    def associateCustomerGatewayResponse(
      customerGatewayAssociation: Option[CustomerGatewayAssociation] = None
    ): AssociateCustomerGatewayResponse =
      AssociateCustomerGatewayResponse
        .builder
        .ifSome(customerGatewayAssociation)(_.customerGatewayAssociation(_))
        .build

    def associateLinkRequest(
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None
    ): AssociateLinkRequest =
      AssociateLinkRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .build

    def associateLinkResponse(
      linkAssociation: Option[LinkAssociation] = None
    ): AssociateLinkResponse =
      AssociateLinkResponse
        .builder
        .ifSome(linkAssociation)(_.linkAssociation(_))
        .build

    def associateTransitGatewayConnectPeerRequest(
      globalNetworkId: Option[String] = None,
      transitGatewayConnectPeerArn: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None
    ): AssociateTransitGatewayConnectPeerRequest =
      AssociateTransitGatewayConnectPeerRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(transitGatewayConnectPeerArn)(_.transitGatewayConnectPeerArn(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .build

    def associateTransitGatewayConnectPeerResponse(
      transitGatewayConnectPeerAssociation: Option[TransitGatewayConnectPeerAssociation] = None
    ): AssociateTransitGatewayConnectPeerResponse =
      AssociateTransitGatewayConnectPeerResponse
        .builder
        .ifSome(transitGatewayConnectPeerAssociation)(_.transitGatewayConnectPeerAssociation(_))
        .build

    def bandwidth(
      uploadSpeed: Option[Int] = None,
      downloadSpeed: Option[Int] = None
    ): Bandwidth =
      Bandwidth
        .builder
        .ifSome(uploadSpeed)(_.uploadSpeed(_))
        .ifSome(downloadSpeed)(_.downloadSpeed(_))
        .build

    def conflictException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def connection(
      connectionId: Option[String] = None,
      connectionArn: Option[String] = None,
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      connectedDeviceId: Option[String] = None,
      linkId: Option[String] = None,
      connectedLinkId: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[DateTime] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): Connection =
      Connection
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(connectedDeviceId)(_.connectedDeviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(connectedLinkId)(_.connectedLinkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConnectionRequest(
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      connectedDeviceId: Option[String] = None,
      linkId: Option[String] = None,
      connectedLinkId: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateConnectionRequest =
      CreateConnectionRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(connectedDeviceId)(_.connectedDeviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(connectedLinkId)(_.connectedLinkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConnectionResponse(
      connection: Option[Connection] = None
    ): CreateConnectionResponse =
      CreateConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def createDeviceRequest(
      globalNetworkId: Option[String] = None,
      aWSLocation: Option[AWSLocation] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      vendor: Option[String] = None,
      model: Option[String] = None,
      serialNumber: Option[String] = None,
      location: Option[Location] = None,
      siteId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDeviceRequest =
      CreateDeviceRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(aWSLocation)(_.aWSLocation(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vendor)(_.vendor(_))
        .ifSome(model)(_.model(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(location)(_.location(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeviceResponse(
      device: Option[Device] = None
    ): CreateDeviceResponse =
      CreateDeviceResponse
        .builder
        .ifSome(device)(_.device(_))
        .build

    def createGlobalNetworkRequest(
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateGlobalNetworkRequest =
      CreateGlobalNetworkRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGlobalNetworkResponse(
      globalNetwork: Option[GlobalNetwork] = None
    ): CreateGlobalNetworkResponse =
      CreateGlobalNetworkResponse
        .builder
        .ifSome(globalNetwork)(_.globalNetwork(_))
        .build

    def createLinkRequest(
      globalNetworkId: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      bandwidth: Option[Bandwidth] = None,
      provider: Option[String] = None,
      siteId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateLinkRequest =
      CreateLinkRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLinkResponse(
      link: Option[Link] = None
    ): CreateLinkResponse =
      CreateLinkResponse
        .builder
        .ifSome(link)(_.link(_))
        .build

    def createSiteRequest(
      globalNetworkId: Option[String] = None,
      description: Option[String] = None,
      location: Option[Location] = None,
      tags: Option[List[Tag]] = None
    ): CreateSiteRequest =
      CreateSiteRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(location)(_.location(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSiteResponse(
      site: Option[Site] = None
    ): CreateSiteResponse =
      CreateSiteResponse
        .builder
        .ifSome(site)(_.site(_))
        .build

    def customerGatewayAssociation(
      customerGatewayArn: Option[String] = None,
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None,
      state: Option[String] = None
    ): CustomerGatewayAssociation =
      CustomerGatewayAssociation
        .builder
        .ifSome(customerGatewayArn)(_.customerGatewayArn(_))
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(state)(_.state(_))
        .build

    def deleteConnectionRequest(
      globalNetworkId: Option[String] = None,
      connectionId: Option[String] = None
    ): DeleteConnectionRequest =
      DeleteConnectionRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def deleteConnectionResponse(
      connection: Option[Connection] = None
    ): DeleteConnectionResponse =
      DeleteConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def deleteDeviceRequest(
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None
    ): DeleteDeviceRequest =
      DeleteDeviceRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def deleteDeviceResponse(
      device: Option[Device] = None
    ): DeleteDeviceResponse =
      DeleteDeviceResponse
        .builder
        .ifSome(device)(_.device(_))
        .build

    def deleteGlobalNetworkRequest(
      globalNetworkId: Option[String] = None
    ): DeleteGlobalNetworkRequest =
      DeleteGlobalNetworkRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .build

    def deleteGlobalNetworkResponse(
      globalNetwork: Option[GlobalNetwork] = None
    ): DeleteGlobalNetworkResponse =
      DeleteGlobalNetworkResponse
        .builder
        .ifSome(globalNetwork)(_.globalNetwork(_))
        .build

    def deleteLinkRequest(
      globalNetworkId: Option[String] = None,
      linkId: Option[String] = None
    ): DeleteLinkRequest =
      DeleteLinkRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(linkId)(_.linkId(_))
        .build

    def deleteLinkResponse(
      link: Option[Link] = None
    ): DeleteLinkResponse =
      DeleteLinkResponse
        .builder
        .ifSome(link)(_.link(_))
        .build

    def deleteSiteRequest(
      globalNetworkId: Option[String] = None,
      siteId: Option[String] = None
    ): DeleteSiteRequest =
      DeleteSiteRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(siteId)(_.siteId(_))
        .build

    def deleteSiteResponse(
      site: Option[Site] = None
    ): DeleteSiteResponse =
      DeleteSiteResponse
        .builder
        .ifSome(site)(_.site(_))
        .build

    def deregisterTransitGatewayRequest(
      globalNetworkId: Option[String] = None,
      transitGatewayArn: Option[String] = None
    ): DeregisterTransitGatewayRequest =
      DeregisterTransitGatewayRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(transitGatewayArn)(_.transitGatewayArn(_))
        .build

    def deregisterTransitGatewayResponse(
      transitGatewayRegistration: Option[TransitGatewayRegistration] = None
    ): DeregisterTransitGatewayResponse =
      DeregisterTransitGatewayResponse
        .builder
        .ifSome(transitGatewayRegistration)(_.transitGatewayRegistration(_))
        .build

    def describeGlobalNetworksRequest(
      globalNetworkIds: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeGlobalNetworksRequest =
      DescribeGlobalNetworksRequest
        .builder
        .ifSome(globalNetworkIds)(_.globalNetworkIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGlobalNetworksResponse(
      globalNetworks: Option[List[GlobalNetwork]] = None,
      nextToken: Option[String] = None
    ): DescribeGlobalNetworksResponse =
      DescribeGlobalNetworksResponse
        .builder
        .ifSome(globalNetworks)(_.globalNetworks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def device(
      deviceId: Option[String] = None,
      deviceArn: Option[String] = None,
      globalNetworkId: Option[String] = None,
      aWSLocation: Option[AWSLocation] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      vendor: Option[String] = None,
      model: Option[String] = None,
      serialNumber: Option[String] = None,
      location: Option[Location] = None,
      siteId: Option[String] = None,
      createdAt: Option[DateTime] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): Device =
      Device
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(aWSLocation)(_.aWSLocation(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vendor)(_.vendor(_))
        .ifSome(model)(_.model(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(location)(_.location(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def disassociateCustomerGatewayRequest(
      globalNetworkId: Option[String] = None,
      customerGatewayArn: Option[String] = None
    ): DisassociateCustomerGatewayRequest =
      DisassociateCustomerGatewayRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(customerGatewayArn)(_.customerGatewayArn(_))
        .build

    def disassociateCustomerGatewayResponse(
      customerGatewayAssociation: Option[CustomerGatewayAssociation] = None
    ): DisassociateCustomerGatewayResponse =
      DisassociateCustomerGatewayResponse
        .builder
        .ifSome(customerGatewayAssociation)(_.customerGatewayAssociation(_))
        .build

    def disassociateLinkRequest(
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None
    ): DisassociateLinkRequest =
      DisassociateLinkRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .build

    def disassociateLinkResponse(
      linkAssociation: Option[LinkAssociation] = None
    ): DisassociateLinkResponse =
      DisassociateLinkResponse
        .builder
        .ifSome(linkAssociation)(_.linkAssociation(_))
        .build

    def disassociateTransitGatewayConnectPeerRequest(
      globalNetworkId: Option[String] = None,
      transitGatewayConnectPeerArn: Option[String] = None
    ): DisassociateTransitGatewayConnectPeerRequest =
      DisassociateTransitGatewayConnectPeerRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(transitGatewayConnectPeerArn)(_.transitGatewayConnectPeerArn(_))
        .build

    def disassociateTransitGatewayConnectPeerResponse(
      transitGatewayConnectPeerAssociation: Option[TransitGatewayConnectPeerAssociation] = None
    ): DisassociateTransitGatewayConnectPeerResponse =
      DisassociateTransitGatewayConnectPeerResponse
        .builder
        .ifSome(transitGatewayConnectPeerAssociation)(_.transitGatewayConnectPeerAssociation(_))
        .build

    def getConnectionsRequest(
      globalNetworkId: Option[String] = None,
      connectionIds: Option[List[String]] = None,
      deviceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetConnectionsRequest =
      GetConnectionsRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(connectionIds)(_.connectionIds(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getConnectionsResponse(
      connections: Option[List[Connection]] = None,
      nextToken: Option[String] = None
    ): GetConnectionsResponse =
      GetConnectionsResponse
        .builder
        .ifSome(connections)(_.connections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCustomerGatewayAssociationsRequest(
      globalNetworkId: Option[String] = None,
      customerGatewayArns: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetCustomerGatewayAssociationsRequest =
      GetCustomerGatewayAssociationsRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(customerGatewayArns)(_.customerGatewayArns(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCustomerGatewayAssociationsResponse(
      customerGatewayAssociations: Option[List[CustomerGatewayAssociation]] = None,
      nextToken: Option[String] = None
    ): GetCustomerGatewayAssociationsResponse =
      GetCustomerGatewayAssociationsResponse
        .builder
        .ifSome(customerGatewayAssociations)(_.customerGatewayAssociations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDevicesRequest(
      globalNetworkId: Option[String] = None,
      deviceIds: Option[List[String]] = None,
      siteId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetDevicesRequest =
      GetDevicesRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceIds)(_.deviceIds(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDevicesResponse(
      devices: Option[List[Device]] = None,
      nextToken: Option[String] = None
    ): GetDevicesResponse =
      GetDevicesResponse
        .builder
        .ifSome(devices)(_.devices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getLinkAssociationsRequest(
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetLinkAssociationsRequest =
      GetLinkAssociationsRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getLinkAssociationsResponse(
      linkAssociations: Option[List[LinkAssociation]] = None,
      nextToken: Option[String] = None
    ): GetLinkAssociationsResponse =
      GetLinkAssociationsResponse
        .builder
        .ifSome(linkAssociations)(_.linkAssociations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getLinksRequest(
      globalNetworkId: Option[String] = None,
      linkIds: Option[List[String]] = None,
      siteId: Option[String] = None,
      `type`: Option[String] = None,
      provider: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetLinksRequest =
      GetLinksRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(linkIds)(_.linkIds(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getLinksResponse(
      links: Option[List[Link]] = None,
      nextToken: Option[String] = None
    ): GetLinksResponse =
      GetLinksResponse
        .builder
        .ifSome(links)(_.links(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSitesRequest(
      globalNetworkId: Option[String] = None,
      siteIds: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetSitesRequest =
      GetSitesRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(siteIds)(_.siteIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSitesResponse(
      sites: Option[List[Site]] = None,
      nextToken: Option[String] = None
    ): GetSitesResponse =
      GetSitesResponse
        .builder
        .ifSome(sites)(_.sites(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayConnectPeerAssociationsRequest(
      globalNetworkId: Option[String] = None,
      transitGatewayConnectPeerArns: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayConnectPeerAssociationsRequest =
      GetTransitGatewayConnectPeerAssociationsRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(transitGatewayConnectPeerArns)(_.transitGatewayConnectPeerArns(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayConnectPeerAssociationsResponse(
      transitGatewayConnectPeerAssociations: Option[List[TransitGatewayConnectPeerAssociation]] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayConnectPeerAssociationsResponse =
      GetTransitGatewayConnectPeerAssociationsResponse
        .builder
        .ifSome(transitGatewayConnectPeerAssociations)(_.transitGatewayConnectPeerAssociations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayRegistrationsRequest(
      globalNetworkId: Option[String] = None,
      transitGatewayArns: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayRegistrationsRequest =
      GetTransitGatewayRegistrationsRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(transitGatewayArns)(_.transitGatewayArns(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayRegistrationsResponse(
      transitGatewayRegistrations: Option[List[TransitGatewayRegistration]] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayRegistrationsResponse =
      GetTransitGatewayRegistrationsResponse
        .builder
        .ifSome(transitGatewayRegistrations)(_.transitGatewayRegistrations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def globalNetwork(
      globalNetworkId: Option[String] = None,
      globalNetworkArn: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[DateTime] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): GlobalNetwork =
      GlobalNetwork
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(globalNetworkArn)(_.globalNetworkArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def link(
      linkId: Option[String] = None,
      linkArn: Option[String] = None,
      globalNetworkId: Option[String] = None,
      siteId: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      bandwidth: Option[Bandwidth] = None,
      provider: Option[String] = None,
      createdAt: Option[DateTime] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): Link =
      Link
        .builder
        .ifSome(linkId)(_.linkId(_))
        .ifSome(linkArn)(_.linkArn(_))
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def linkAssociation(
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None,
      linkAssociationState: Option[String] = None
    ): LinkAssociation =
      LinkAssociation
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(linkAssociationState)(_.linkAssociationState(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tagList: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tagList)(_.tagList(_))
        .build

    def location(
      address: Option[String] = None,
      latitude: Option[String] = None,
      longitude: Option[String] = None
    ): Location =
      Location
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(latitude)(_.latitude(_))
        .ifSome(longitude)(_.longitude(_))
        .build

    def registerTransitGatewayRequest(
      globalNetworkId: Option[String] = None,
      transitGatewayArn: Option[String] = None
    ): RegisterTransitGatewayRequest =
      RegisterTransitGatewayRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(transitGatewayArn)(_.transitGatewayArn(_))
        .build

    def registerTransitGatewayResponse(
      transitGatewayRegistration: Option[TransitGatewayRegistration] = None
    ): RegisterTransitGatewayResponse =
      RegisterTransitGatewayResponse
        .builder
        .ifSome(transitGatewayRegistration)(_.transitGatewayRegistration(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      limitCode: Option[String] = None,
      serviceCode: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(limitCode)(_.limitCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def site(
      siteId: Option[String] = None,
      siteArn: Option[String] = None,
      globalNetworkId: Option[String] = None,
      description: Option[String] = None,
      location: Option[Location] = None,
      createdAt: Option[DateTime] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): Site =
      Site
        .builder
        .ifSome(siteId)(_.siteId(_))
        .ifSome(siteArn)(_.siteArn(_))
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(location)(_.location(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
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
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def throttlingException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def transitGatewayConnectPeerAssociation(
      transitGatewayConnectPeerArn: Option[String] = None,
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      linkId: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayConnectPeerAssociation =
      TransitGatewayConnectPeerAssociation
        .builder
        .ifSome(transitGatewayConnectPeerArn)(_.transitGatewayConnectPeerArn(_))
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayRegistration(
      globalNetworkId: Option[String] = None,
      transitGatewayArn: Option[String] = None,
      state: Option[TransitGatewayRegistrationStateReason] = None
    ): TransitGatewayRegistration =
      TransitGatewayRegistration
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(transitGatewayArn)(_.transitGatewayArn(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayRegistrationStateReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): TransitGatewayRegistrationStateReason =
      TransitGatewayRegistrationStateReason
        .builder
        .ifSome(code)(_.code(_))
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

    def updateConnectionRequest(
      globalNetworkId: Option[String] = None,
      connectionId: Option[String] = None,
      linkId: Option[String] = None,
      connectedLinkId: Option[String] = None,
      description: Option[String] = None
    ): UpdateConnectionRequest =
      UpdateConnectionRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(connectedLinkId)(_.connectedLinkId(_))
        .ifSome(description)(_.description(_))
        .build

    def updateConnectionResponse(
      connection: Option[Connection] = None
    ): UpdateConnectionResponse =
      UpdateConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def updateDeviceRequest(
      globalNetworkId: Option[String] = None,
      deviceId: Option[String] = None,
      aWSLocation: Option[AWSLocation] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      vendor: Option[String] = None,
      model: Option[String] = None,
      serialNumber: Option[String] = None,
      location: Option[Location] = None,
      siteId: Option[String] = None
    ): UpdateDeviceRequest =
      UpdateDeviceRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(aWSLocation)(_.aWSLocation(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vendor)(_.vendor(_))
        .ifSome(model)(_.model(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(location)(_.location(_))
        .ifSome(siteId)(_.siteId(_))
        .build

    def updateDeviceResponse(
      device: Option[Device] = None
    ): UpdateDeviceResponse =
      UpdateDeviceResponse
        .builder
        .ifSome(device)(_.device(_))
        .build

    def updateGlobalNetworkRequest(
      globalNetworkId: Option[String] = None,
      description: Option[String] = None
    ): UpdateGlobalNetworkRequest =
      UpdateGlobalNetworkRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(description)(_.description(_))
        .build

    def updateGlobalNetworkResponse(
      globalNetwork: Option[GlobalNetwork] = None
    ): UpdateGlobalNetworkResponse =
      UpdateGlobalNetworkResponse
        .builder
        .ifSome(globalNetwork)(_.globalNetwork(_))
        .build

    def updateLinkRequest(
      globalNetworkId: Option[String] = None,
      linkId: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      bandwidth: Option[Bandwidth] = None,
      provider: Option[String] = None
    ): UpdateLinkRequest =
      UpdateLinkRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(linkId)(_.linkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(provider)(_.provider(_))
        .build

    def updateLinkResponse(
      link: Option[Link] = None
    ): UpdateLinkResponse =
      UpdateLinkResponse
        .builder
        .ifSome(link)(_.link(_))
        .build

    def updateSiteRequest(
      globalNetworkId: Option[String] = None,
      siteId: Option[String] = None,
      description: Option[String] = None,
      location: Option[Location] = None
    ): UpdateSiteRequest =
      UpdateSiteRequest
        .builder
        .ifSome(globalNetworkId)(_.globalNetworkId(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(description)(_.description(_))
        .ifSome(location)(_.location(_))
        .build

    def updateSiteResponse(
      site: Option[Site] = None
    ): UpdateSiteResponse =
      UpdateSiteResponse
        .builder
        .ifSome(site)(_.site(_))
        .build

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None,
      fields: Option[List[ValidationExceptionField]] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(fields)(_.fields(_))
        .build

    def validationExceptionField(
      name: Option[String] = None,
      message: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
