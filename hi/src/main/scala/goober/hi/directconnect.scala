package goober.hi

import goober.free.directconnect.DirectConnectIO
import software.amazon.awssdk.services.directconnect.model._


object directconnect {
  import goober.free.{directconnect ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptDirectConnectGatewayAssociationProposalRequest(
      directConnectGatewayId: Option[String] = None,
      proposalId: Option[String] = None,
      associatedGatewayOwnerAccount: Option[String] = None,
      overrideAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None
    ): AcceptDirectConnectGatewayAssociationProposalRequest =
      AcceptDirectConnectGatewayAssociationProposalRequest
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(proposalId)(_.proposalId(_))
        .ifSome(associatedGatewayOwnerAccount)(_.associatedGatewayOwnerAccount(_))
        .ifSome(overrideAllowedPrefixesToDirectConnectGateway)(_.overrideAllowedPrefixesToDirectConnectGateway(_))
        .build

    def allocateConnectionOnInterconnectRequest(
      bandwidth: Option[String] = None,
      connectionName: Option[String] = None,
      ownerAccount: Option[String] = None,
      interconnectId: Option[String] = None,
      vlan: Option[Int] = None
    ): AllocateConnectionOnInterconnectRequest =
      AllocateConnectionOnInterconnectRequest
        .builder
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(interconnectId)(_.interconnectId(_))
        .ifSome(vlan)(_.vlan(_))
        .build

    def allocateHostedConnectionRequest(
      connectionId: Option[String] = None,
      ownerAccount: Option[String] = None,
      bandwidth: Option[String] = None,
      connectionName: Option[String] = None,
      vlan: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): AllocateHostedConnectionRequest =
      AllocateHostedConnectionRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(tags)(_.tags(_))
        .build

    def allocatePrivateVirtualInterfaceRequest(
      connectionId: Option[String] = None,
      ownerAccount: Option[String] = None,
      newPrivateVirtualInterfaceAllocation: Option[NewPrivateVirtualInterfaceAllocation] = None
    ): AllocatePrivateVirtualInterfaceRequest =
      AllocatePrivateVirtualInterfaceRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(newPrivateVirtualInterfaceAllocation)(_.newPrivateVirtualInterfaceAllocation(_))
        .build

    def allocatePublicVirtualInterfaceRequest(
      connectionId: Option[String] = None,
      ownerAccount: Option[String] = None,
      newPublicVirtualInterfaceAllocation: Option[NewPublicVirtualInterfaceAllocation] = None
    ): AllocatePublicVirtualInterfaceRequest =
      AllocatePublicVirtualInterfaceRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(newPublicVirtualInterfaceAllocation)(_.newPublicVirtualInterfaceAllocation(_))
        .build

    def allocateTransitVirtualInterfaceRequest(
      connectionId: Option[String] = None,
      ownerAccount: Option[String] = None,
      newTransitVirtualInterfaceAllocation: Option[NewTransitVirtualInterfaceAllocation] = None
    ): AllocateTransitVirtualInterfaceRequest =
      AllocateTransitVirtualInterfaceRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(newTransitVirtualInterfaceAllocation)(_.newTransitVirtualInterfaceAllocation(_))
        .build

    def associateConnectionWithLagRequest(
      connectionId: Option[String] = None,
      lagId: Option[String] = None
    ): AssociateConnectionWithLagRequest =
      AssociateConnectionWithLagRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(lagId)(_.lagId(_))
        .build

    def associateHostedConnectionRequest(
      connectionId: Option[String] = None,
      parentConnectionId: Option[String] = None
    ): AssociateHostedConnectionRequest =
      AssociateHostedConnectionRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(parentConnectionId)(_.parentConnectionId(_))
        .build

    def associateMacSecKeyRequest(
      connectionId: Option[String] = None,
      secretARN: Option[String] = None,
      ckn: Option[String] = None,
      cak: Option[String] = None
    ): AssociateMacSecKeyRequest =
      AssociateMacSecKeyRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(secretARN)(_.secretARN(_))
        .ifSome(ckn)(_.ckn(_))
        .ifSome(cak)(_.cak(_))
        .build

    def associateMacSecKeyResponse(
      connectionId: Option[String] = None,
      macSecKeys: Option[List[MacSecKey]] = None
    ): AssociateMacSecKeyResponse =
      AssociateMacSecKeyResponse
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(macSecKeys)(_.macSecKeys(_))
        .build

    def associateVirtualInterfaceRequest(
      virtualInterfaceId: Option[String] = None,
      connectionId: Option[String] = None
    ): AssociateVirtualInterfaceRequest =
      AssociateVirtualInterfaceRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def associatedGateway(
      id: Option[String] = None,
      `type`: Option[String] = None,
      ownerAccount: Option[String] = None,
      region: Option[String] = None
    ): AssociatedGateway =
      AssociatedGateway
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(region)(_.region(_))
        .build

    def bGPPeer(
      bgpPeerId: Option[String] = None,
      asn: Option[Int] = None,
      authKey: Option[String] = None,
      addressFamily: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None,
      bgpPeerState: Option[String] = None,
      bgpStatus: Option[String] = None,
      awsDeviceV2: Option[String] = None
    ): BGPPeer =
      BGPPeer
        .builder
        .ifSome(bgpPeerId)(_.bgpPeerId(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(bgpPeerState)(_.bgpPeerState(_))
        .ifSome(bgpStatus)(_.bgpStatus(_))
        .ifSome(awsDeviceV2)(_.awsDeviceV2(_))
        .build

    def confirmConnectionRequest(
      connectionId: Option[String] = None
    ): ConfirmConnectionRequest =
      ConfirmConnectionRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def confirmConnectionResponse(
      connectionState: Option[String] = None
    ): ConfirmConnectionResponse =
      ConfirmConnectionResponse
        .builder
        .ifSome(connectionState)(_.connectionState(_))
        .build

    def confirmPrivateVirtualInterfaceRequest(
      virtualInterfaceId: Option[String] = None,
      virtualGatewayId: Option[String] = None,
      directConnectGatewayId: Option[String] = None
    ): ConfirmPrivateVirtualInterfaceRequest =
      ConfirmPrivateVirtualInterfaceRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .build

    def confirmPrivateVirtualInterfaceResponse(
      virtualInterfaceState: Option[String] = None
    ): ConfirmPrivateVirtualInterfaceResponse =
      ConfirmPrivateVirtualInterfaceResponse
        .builder
        .ifSome(virtualInterfaceState)(_.virtualInterfaceState(_))
        .build

    def confirmPublicVirtualInterfaceRequest(
      virtualInterfaceId: Option[String] = None
    ): ConfirmPublicVirtualInterfaceRequest =
      ConfirmPublicVirtualInterfaceRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .build

    def confirmPublicVirtualInterfaceResponse(
      virtualInterfaceState: Option[String] = None
    ): ConfirmPublicVirtualInterfaceResponse =
      ConfirmPublicVirtualInterfaceResponse
        .builder
        .ifSome(virtualInterfaceState)(_.virtualInterfaceState(_))
        .build

    def confirmTransitVirtualInterfaceRequest(
      virtualInterfaceId: Option[String] = None,
      directConnectGatewayId: Option[String] = None
    ): ConfirmTransitVirtualInterfaceRequest =
      ConfirmTransitVirtualInterfaceRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .build

    def confirmTransitVirtualInterfaceResponse(
      virtualInterfaceState: Option[String] = None
    ): ConfirmTransitVirtualInterfaceResponse =
      ConfirmTransitVirtualInterfaceResponse
        .builder
        .ifSome(virtualInterfaceState)(_.virtualInterfaceState(_))
        .build

    def connection(
      ownerAccount: Option[String] = None,
      connectionId: Option[String] = None,
      connectionName: Option[String] = None,
      connectionState: Option[String] = None,
      region: Option[String] = None,
      location: Option[String] = None,
      bandwidth: Option[String] = None,
      vlan: Option[Int] = None,
      partnerName: Option[String] = None,
      loaIssueTime: Option[LoaIssueTime] = None,
      lagId: Option[String] = None,
      awsDevice: Option[String] = None,
      jumboFrameCapable: Option[Boolean] = None,
      awsDeviceV2: Option[String] = None,
      hasLogicalRedundancy: Option[String] = None,
      tags: Option[List[Tag]] = None,
      providerName: Option[String] = None,
      macSecCapable: Option[Boolean] = None,
      portEncryptionStatus: Option[String] = None,
      encryptionMode: Option[String] = None,
      macSecKeys: Option[List[MacSecKey]] = None
    ): Connection =
      Connection
        .builder
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(region)(_.region(_))
        .ifSome(location)(_.location(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(partnerName)(_.partnerName(_))
        .ifSome(loaIssueTime)(_.loaIssueTime(_))
        .ifSome(lagId)(_.lagId(_))
        .ifSome(awsDevice)(_.awsDevice(_))
        .ifSome(jumboFrameCapable)(_.jumboFrameCapable(_))
        .ifSome(awsDeviceV2)(_.awsDeviceV2(_))
        .ifSome(hasLogicalRedundancy)(_.hasLogicalRedundancy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(macSecCapable)(_.macSecCapable(_))
        .ifSome(portEncryptionStatus)(_.portEncryptionStatus(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(macSecKeys)(_.macSecKeys(_))
        .build

    def connections(
      connections: Option[List[Connection]] = None
    ): Connections =
      Connections
        .builder
        .ifSome(connections)(_.connections(_))
        .build

    def createBGPPeerRequest(
      virtualInterfaceId: Option[String] = None,
      newBGPPeer: Option[NewBGPPeer] = None
    ): CreateBGPPeerRequest =
      CreateBGPPeerRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(newBGPPeer)(_.newBGPPeer(_))
        .build

    def createBGPPeerResponse(
      virtualInterface: Option[VirtualInterface] = None
    ): CreateBGPPeerResponse =
      CreateBGPPeerResponse
        .builder
        .ifSome(virtualInterface)(_.virtualInterface(_))
        .build

    def createConnectionRequest(
      location: Option[String] = None,
      bandwidth: Option[String] = None,
      connectionName: Option[String] = None,
      lagId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      providerName: Option[String] = None,
      requestMACSec: Option[Boolean] = None
    ): CreateConnectionRequest =
      CreateConnectionRequest
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(lagId)(_.lagId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(requestMACSec)(_.requestMACSec(_))
        .build

    def createDirectConnectGatewayAssociationProposalRequest(
      directConnectGatewayId: Option[String] = None,
      directConnectGatewayOwnerAccount: Option[String] = None,
      gatewayId: Option[String] = None,
      addAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None,
      removeAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None
    ): CreateDirectConnectGatewayAssociationProposalRequest =
      CreateDirectConnectGatewayAssociationProposalRequest
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(directConnectGatewayOwnerAccount)(_.directConnectGatewayOwnerAccount(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(addAllowedPrefixesToDirectConnectGateway)(_.addAllowedPrefixesToDirectConnectGateway(_))
        .ifSome(removeAllowedPrefixesToDirectConnectGateway)(_.removeAllowedPrefixesToDirectConnectGateway(_))
        .build

    def createDirectConnectGatewayAssociationRequest(
      directConnectGatewayId: Option[String] = None,
      gatewayId: Option[String] = None,
      addAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None,
      virtualGatewayId: Option[String] = None
    ): CreateDirectConnectGatewayAssociationRequest =
      CreateDirectConnectGatewayAssociationRequest
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(addAllowedPrefixesToDirectConnectGateway)(_.addAllowedPrefixesToDirectConnectGateway(_))
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .build

    def createDirectConnectGatewayRequest(
      directConnectGatewayName: Option[String] = None,
      amazonSideAsn: Option[LongAsn] = None
    ): CreateDirectConnectGatewayRequest =
      CreateDirectConnectGatewayRequest
        .builder
        .ifSome(directConnectGatewayName)(_.directConnectGatewayName(_))
        .ifSome(amazonSideAsn)(_.amazonSideAsn(_))
        .build

    def createInterconnectRequest(
      interconnectName: Option[String] = None,
      bandwidth: Option[String] = None,
      location: Option[String] = None,
      lagId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      providerName: Option[String] = None
    ): CreateInterconnectRequest =
      CreateInterconnectRequest
        .builder
        .ifSome(interconnectName)(_.interconnectName(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(location)(_.location(_))
        .ifSome(lagId)(_.lagId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(providerName)(_.providerName(_))
        .build

    def createLagRequest(
      numberOfConnections: Option[Int] = None,
      location: Option[String] = None,
      connectionsBandwidth: Option[String] = None,
      lagName: Option[String] = None,
      connectionId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      childConnectionTags: Option[List[Tag]] = None,
      providerName: Option[String] = None,
      requestMACSec: Option[Boolean] = None
    ): CreateLagRequest =
      CreateLagRequest
        .builder
        .ifSome(numberOfConnections)(_.numberOfConnections(_))
        .ifSome(location)(_.location(_))
        .ifSome(connectionsBandwidth)(_.connectionsBandwidth(_))
        .ifSome(lagName)(_.lagName(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(childConnectionTags)(_.childConnectionTags(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(requestMACSec)(_.requestMACSec(_))
        .build

    def createPrivateVirtualInterfaceRequest(
      connectionId: Option[String] = None,
      newPrivateVirtualInterface: Option[NewPrivateVirtualInterface] = None
    ): CreatePrivateVirtualInterfaceRequest =
      CreatePrivateVirtualInterfaceRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(newPrivateVirtualInterface)(_.newPrivateVirtualInterface(_))
        .build

    def createPublicVirtualInterfaceRequest(
      connectionId: Option[String] = None,
      newPublicVirtualInterface: Option[NewPublicVirtualInterface] = None
    ): CreatePublicVirtualInterfaceRequest =
      CreatePublicVirtualInterfaceRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(newPublicVirtualInterface)(_.newPublicVirtualInterface(_))
        .build

    def createTransitVirtualInterfaceRequest(
      connectionId: Option[String] = None,
      newTransitVirtualInterface: Option[NewTransitVirtualInterface] = None
    ): CreateTransitVirtualInterfaceRequest =
      CreateTransitVirtualInterfaceRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(newTransitVirtualInterface)(_.newTransitVirtualInterface(_))
        .build

    def deleteBGPPeerRequest(
      virtualInterfaceId: Option[String] = None,
      asn: Option[Int] = None,
      customerAddress: Option[String] = None,
      bgpPeerId: Option[String] = None
    ): DeleteBGPPeerRequest =
      DeleteBGPPeerRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(bgpPeerId)(_.bgpPeerId(_))
        .build

    def deleteBGPPeerResponse(
      virtualInterface: Option[VirtualInterface] = None
    ): DeleteBGPPeerResponse =
      DeleteBGPPeerResponse
        .builder
        .ifSome(virtualInterface)(_.virtualInterface(_))
        .build

    def deleteConnectionRequest(
      connectionId: Option[String] = None
    ): DeleteConnectionRequest =
      DeleteConnectionRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def deleteDirectConnectGatewayAssociationProposalRequest(
      proposalId: Option[String] = None
    ): DeleteDirectConnectGatewayAssociationProposalRequest =
      DeleteDirectConnectGatewayAssociationProposalRequest
        .builder
        .ifSome(proposalId)(_.proposalId(_))
        .build

    def deleteDirectConnectGatewayAssociationRequest(
      associationId: Option[String] = None,
      directConnectGatewayId: Option[String] = None,
      virtualGatewayId: Option[String] = None
    ): DeleteDirectConnectGatewayAssociationRequest =
      DeleteDirectConnectGatewayAssociationRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .build

    def deleteDirectConnectGatewayRequest(
      directConnectGatewayId: Option[String] = None
    ): DeleteDirectConnectGatewayRequest =
      DeleteDirectConnectGatewayRequest
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .build

    def deleteInterconnectRequest(
      interconnectId: Option[String] = None
    ): DeleteInterconnectRequest =
      DeleteInterconnectRequest
        .builder
        .ifSome(interconnectId)(_.interconnectId(_))
        .build

    def deleteInterconnectResponse(
      interconnectState: Option[String] = None
    ): DeleteInterconnectResponse =
      DeleteInterconnectResponse
        .builder
        .ifSome(interconnectState)(_.interconnectState(_))
        .build

    def deleteLagRequest(
      lagId: Option[String] = None
    ): DeleteLagRequest =
      DeleteLagRequest
        .builder
        .ifSome(lagId)(_.lagId(_))
        .build

    def deleteVirtualInterfaceRequest(
      virtualInterfaceId: Option[String] = None
    ): DeleteVirtualInterfaceRequest =
      DeleteVirtualInterfaceRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .build

    def deleteVirtualInterfaceResponse(
      virtualInterfaceState: Option[String] = None
    ): DeleteVirtualInterfaceResponse =
      DeleteVirtualInterfaceResponse
        .builder
        .ifSome(virtualInterfaceState)(_.virtualInterfaceState(_))
        .build

    def describeConnectionLoaRequest(
      connectionId: Option[String] = None,
      providerName: Option[String] = None,
      loaContentType: Option[String] = None
    ): DescribeConnectionLoaRequest =
      DescribeConnectionLoaRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(loaContentType)(_.loaContentType(_))
        .build

    def describeConnectionLoaResponse(
      loa: Option[Loa] = None
    ): DescribeConnectionLoaResponse =
      DescribeConnectionLoaResponse
        .builder
        .ifSome(loa)(_.loa(_))
        .build

    def describeConnectionsOnInterconnectRequest(
      interconnectId: Option[String] = None
    ): DescribeConnectionsOnInterconnectRequest =
      DescribeConnectionsOnInterconnectRequest
        .builder
        .ifSome(interconnectId)(_.interconnectId(_))
        .build

    def describeConnectionsRequest(
      connectionId: Option[String] = None
    ): DescribeConnectionsRequest =
      DescribeConnectionsRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def describeDirectConnectGatewayAssociationProposalsRequest(
      directConnectGatewayId: Option[String] = None,
      proposalId: Option[String] = None,
      associatedGatewayId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDirectConnectGatewayAssociationProposalsRequest =
      DescribeDirectConnectGatewayAssociationProposalsRequest
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(proposalId)(_.proposalId(_))
        .ifSome(associatedGatewayId)(_.associatedGatewayId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDirectConnectGatewayAssociationsRequest(
      associationId: Option[String] = None,
      associatedGatewayId: Option[String] = None,
      directConnectGatewayId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      virtualGatewayId: Option[String] = None
    ): DescribeDirectConnectGatewayAssociationsRequest =
      DescribeDirectConnectGatewayAssociationsRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(associatedGatewayId)(_.associatedGatewayId(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .build

    def describeDirectConnectGatewayAttachmentsRequest(
      directConnectGatewayId: Option[String] = None,
      virtualInterfaceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDirectConnectGatewayAttachmentsRequest =
      DescribeDirectConnectGatewayAttachmentsRequest
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDirectConnectGatewaysRequest(
      directConnectGatewayId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDirectConnectGatewaysRequest =
      DescribeDirectConnectGatewaysRequest
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeHostedConnectionsRequest(
      connectionId: Option[String] = None
    ): DescribeHostedConnectionsRequest =
      DescribeHostedConnectionsRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def describeInterconnectLoaRequest(
      interconnectId: Option[String] = None,
      providerName: Option[String] = None,
      loaContentType: Option[String] = None
    ): DescribeInterconnectLoaRequest =
      DescribeInterconnectLoaRequest
        .builder
        .ifSome(interconnectId)(_.interconnectId(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(loaContentType)(_.loaContentType(_))
        .build

    def describeInterconnectLoaResponse(
      loa: Option[Loa] = None
    ): DescribeInterconnectLoaResponse =
      DescribeInterconnectLoaResponse
        .builder
        .ifSome(loa)(_.loa(_))
        .build

    def describeInterconnectsRequest(
      interconnectId: Option[String] = None
    ): DescribeInterconnectsRequest =
      DescribeInterconnectsRequest
        .builder
        .ifSome(interconnectId)(_.interconnectId(_))
        .build

    def describeLagsRequest(
      lagId: Option[String] = None
    ): DescribeLagsRequest =
      DescribeLagsRequest
        .builder
        .ifSome(lagId)(_.lagId(_))
        .build

    def describeLoaRequest(
      connectionId: Option[String] = None,
      providerName: Option[String] = None,
      loaContentType: Option[String] = None
    ): DescribeLoaRequest =
      DescribeLoaRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(loaContentType)(_.loaContentType(_))
        .build

    def describeTagsRequest(
      resourceArns: Option[List[ResourceArn]] = None
    ): DescribeTagsRequest =
      DescribeTagsRequest
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .build

    def describeTagsResponse(
      resourceTags: Option[List[ResourceTag]] = None
    ): DescribeTagsResponse =
      DescribeTagsResponse
        .builder
        .ifSome(resourceTags)(_.resourceTags(_))
        .build

    def describeVirtualInterfacesRequest(
      connectionId: Option[String] = None,
      virtualInterfaceId: Option[String] = None
    ): DescribeVirtualInterfacesRequest =
      DescribeVirtualInterfacesRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .build

    def directConnectClientException(
      message: Option[String] = None
    ): DirectConnectClientException =
      DirectConnectClientException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def directConnectGateway(
      directConnectGatewayId: Option[String] = None,
      directConnectGatewayName: Option[String] = None,
      amazonSideAsn: Option[LongAsn] = None,
      ownerAccount: Option[String] = None,
      directConnectGatewayState: Option[String] = None,
      stateChangeError: Option[String] = None
    ): DirectConnectGateway =
      DirectConnectGateway
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(directConnectGatewayName)(_.directConnectGatewayName(_))
        .ifSome(amazonSideAsn)(_.amazonSideAsn(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(directConnectGatewayState)(_.directConnectGatewayState(_))
        .ifSome(stateChangeError)(_.stateChangeError(_))
        .build

    def directConnectGatewayAssociation(
      directConnectGatewayId: Option[String] = None,
      directConnectGatewayOwnerAccount: Option[String] = None,
      associationState: Option[String] = None,
      stateChangeError: Option[String] = None,
      associatedGateway: Option[AssociatedGateway] = None,
      associationId: Option[String] = None,
      allowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None,
      virtualGatewayId: Option[String] = None,
      virtualGatewayRegion: Option[String] = None,
      virtualGatewayOwnerAccount: Option[String] = None
    ): DirectConnectGatewayAssociation =
      DirectConnectGatewayAssociation
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(directConnectGatewayOwnerAccount)(_.directConnectGatewayOwnerAccount(_))
        .ifSome(associationState)(_.associationState(_))
        .ifSome(stateChangeError)(_.stateChangeError(_))
        .ifSome(associatedGateway)(_.associatedGateway(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(allowedPrefixesToDirectConnectGateway)(_.allowedPrefixesToDirectConnectGateway(_))
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .ifSome(virtualGatewayRegion)(_.virtualGatewayRegion(_))
        .ifSome(virtualGatewayOwnerAccount)(_.virtualGatewayOwnerAccount(_))
        .build

    def directConnectGatewayAssociationProposal(
      proposalId: Option[String] = None,
      directConnectGatewayId: Option[String] = None,
      directConnectGatewayOwnerAccount: Option[String] = None,
      proposalState: Option[String] = None,
      associatedGateway: Option[AssociatedGateway] = None,
      existingAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None,
      requestedAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None
    ): DirectConnectGatewayAssociationProposal =
      DirectConnectGatewayAssociationProposal
        .builder
        .ifSome(proposalId)(_.proposalId(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(directConnectGatewayOwnerAccount)(_.directConnectGatewayOwnerAccount(_))
        .ifSome(proposalState)(_.proposalState(_))
        .ifSome(associatedGateway)(_.associatedGateway(_))
        .ifSome(existingAllowedPrefixesToDirectConnectGateway)(_.existingAllowedPrefixesToDirectConnectGateway(_))
        .ifSome(requestedAllowedPrefixesToDirectConnectGateway)(_.requestedAllowedPrefixesToDirectConnectGateway(_))
        .build

    def directConnectGatewayAttachment(
      directConnectGatewayId: Option[String] = None,
      virtualInterfaceId: Option[String] = None,
      virtualInterfaceRegion: Option[String] = None,
      virtualInterfaceOwnerAccount: Option[String] = None,
      attachmentState: Option[String] = None,
      attachmentType: Option[String] = None,
      stateChangeError: Option[String] = None
    ): DirectConnectGatewayAttachment =
      DirectConnectGatewayAttachment
        .builder
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(virtualInterfaceRegion)(_.virtualInterfaceRegion(_))
        .ifSome(virtualInterfaceOwnerAccount)(_.virtualInterfaceOwnerAccount(_))
        .ifSome(attachmentState)(_.attachmentState(_))
        .ifSome(attachmentType)(_.attachmentType(_))
        .ifSome(stateChangeError)(_.stateChangeError(_))
        .build

    def directConnectServerException(
      message: Option[String] = None
    ): DirectConnectServerException =
      DirectConnectServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def disassociateConnectionFromLagRequest(
      connectionId: Option[String] = None,
      lagId: Option[String] = None
    ): DisassociateConnectionFromLagRequest =
      DisassociateConnectionFromLagRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(lagId)(_.lagId(_))
        .build

    def disassociateMacSecKeyRequest(
      connectionId: Option[String] = None,
      secretARN: Option[String] = None
    ): DisassociateMacSecKeyRequest =
      DisassociateMacSecKeyRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(secretARN)(_.secretARN(_))
        .build

    def disassociateMacSecKeyResponse(
      connectionId: Option[String] = None,
      macSecKeys: Option[List[MacSecKey]] = None
    ): DisassociateMacSecKeyResponse =
      DisassociateMacSecKeyResponse
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(macSecKeys)(_.macSecKeys(_))
        .build

    def duplicateTagKeysException(

    ): DuplicateTagKeysException =
      DuplicateTagKeysException
        .builder

        .build

    def interconnect(
      interconnectId: Option[String] = None,
      interconnectName: Option[String] = None,
      interconnectState: Option[String] = None,
      region: Option[String] = None,
      location: Option[String] = None,
      bandwidth: Option[String] = None,
      loaIssueTime: Option[LoaIssueTime] = None,
      lagId: Option[String] = None,
      awsDevice: Option[String] = None,
      jumboFrameCapable: Option[Boolean] = None,
      awsDeviceV2: Option[String] = None,
      hasLogicalRedundancy: Option[String] = None,
      tags: Option[List[Tag]] = None,
      providerName: Option[String] = None
    ): Interconnect =
      Interconnect
        .builder
        .ifSome(interconnectId)(_.interconnectId(_))
        .ifSome(interconnectName)(_.interconnectName(_))
        .ifSome(interconnectState)(_.interconnectState(_))
        .ifSome(region)(_.region(_))
        .ifSome(location)(_.location(_))
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(loaIssueTime)(_.loaIssueTime(_))
        .ifSome(lagId)(_.lagId(_))
        .ifSome(awsDevice)(_.awsDevice(_))
        .ifSome(jumboFrameCapable)(_.jumboFrameCapable(_))
        .ifSome(awsDeviceV2)(_.awsDeviceV2(_))
        .ifSome(hasLogicalRedundancy)(_.hasLogicalRedundancy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(providerName)(_.providerName(_))
        .build

    def interconnects(
      interconnects: Option[List[Interconnect]] = None
    ): Interconnects =
      Interconnects
        .builder
        .ifSome(interconnects)(_.interconnects(_))
        .build

    def lag(
      connectionsBandwidth: Option[String] = None,
      numberOfConnections: Option[Int] = None,
      lagId: Option[String] = None,
      ownerAccount: Option[String] = None,
      lagName: Option[String] = None,
      lagState: Option[String] = None,
      location: Option[String] = None,
      region: Option[String] = None,
      minimumLinks: Option[Int] = None,
      awsDevice: Option[String] = None,
      awsDeviceV2: Option[String] = None,
      connections: Option[List[Connection]] = None,
      allowsHostedConnections: Option[Boolean] = None,
      jumboFrameCapable: Option[Boolean] = None,
      hasLogicalRedundancy: Option[String] = None,
      tags: Option[List[Tag]] = None,
      providerName: Option[String] = None,
      macSecCapable: Option[Boolean] = None,
      encryptionMode: Option[String] = None,
      macSecKeys: Option[List[MacSecKey]] = None
    ): Lag =
      Lag
        .builder
        .ifSome(connectionsBandwidth)(_.connectionsBandwidth(_))
        .ifSome(numberOfConnections)(_.numberOfConnections(_))
        .ifSome(lagId)(_.lagId(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(lagName)(_.lagName(_))
        .ifSome(lagState)(_.lagState(_))
        .ifSome(location)(_.location(_))
        .ifSome(region)(_.region(_))
        .ifSome(minimumLinks)(_.minimumLinks(_))
        .ifSome(awsDevice)(_.awsDevice(_))
        .ifSome(awsDeviceV2)(_.awsDeviceV2(_))
        .ifSome(connections)(_.connections(_))
        .ifSome(allowsHostedConnections)(_.allowsHostedConnections(_))
        .ifSome(jumboFrameCapable)(_.jumboFrameCapable(_))
        .ifSome(hasLogicalRedundancy)(_.hasLogicalRedundancy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(macSecCapable)(_.macSecCapable(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(macSecKeys)(_.macSecKeys(_))
        .build

    def lags(
      lags: Option[List[Lag]] = None
    ): Lags =
      Lags
        .builder
        .ifSome(lags)(_.lags(_))
        .build

    def listVirtualInterfaceTestHistoryRequest(
      testId: Option[String] = None,
      virtualInterfaceId: Option[String] = None,
      bgpPeers: Option[List[BGPPeerId]] = None,
      status: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListVirtualInterfaceTestHistoryRequest =
      ListVirtualInterfaceTestHistoryRequest
        .builder
        .ifSome(testId)(_.testId(_))
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(bgpPeers)(_.bgpPeers(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVirtualInterfaceTestHistoryResponse(
      virtualInterfaceTestHistory: Option[List[VirtualInterfaceTestHistory]] = None,
      nextToken: Option[String] = None
    ): ListVirtualInterfaceTestHistoryResponse =
      ListVirtualInterfaceTestHistoryResponse
        .builder
        .ifSome(virtualInterfaceTestHistory)(_.virtualInterfaceTestHistory(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loa(
      loaContent: Option[LoaContent] = None,
      loaContentType: Option[String] = None
    ): Loa =
      Loa
        .builder
        .ifSome(loaContent)(_.loaContent(_))
        .ifSome(loaContentType)(_.loaContentType(_))
        .build

    def location(
      locationCode: Option[String] = None,
      locationName: Option[String] = None,
      region: Option[String] = None,
      availablePortSpeeds: Option[List[PortSpeed]] = None,
      availableProviders: Option[List[ProviderName]] = None,
      availableMacSecPortSpeeds: Option[List[PortSpeed]] = None
    ): Location =
      Location
        .builder
        .ifSome(locationCode)(_.locationCode(_))
        .ifSome(locationName)(_.locationName(_))
        .ifSome(region)(_.region(_))
        .ifSome(availablePortSpeeds)(_.availablePortSpeeds(_))
        .ifSome(availableProviders)(_.availableProviders(_))
        .ifSome(availableMacSecPortSpeeds)(_.availableMacSecPortSpeeds(_))
        .build

    def locations(
      locations: Option[List[Location]] = None
    ): Locations =
      Locations
        .builder
        .ifSome(locations)(_.locations(_))
        .build

    def macSecKey(
      secretARN: Option[String] = None,
      ckn: Option[String] = None,
      state: Option[String] = None,
      startOn: Option[String] = None
    ): MacSecKey =
      MacSecKey
        .builder
        .ifSome(secretARN)(_.secretARN(_))
        .ifSome(ckn)(_.ckn(_))
        .ifSome(state)(_.state(_))
        .ifSome(startOn)(_.startOn(_))
        .build

    def newBGPPeer(
      asn: Option[Int] = None,
      authKey: Option[String] = None,
      addressFamily: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None
    ): NewBGPPeer =
      NewBGPPeer
        .builder
        .ifSome(asn)(_.asn(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .build

    def newPrivateVirtualInterface(
      virtualInterfaceName: Option[String] = None,
      vlan: Option[Int] = None,
      asn: Option[Int] = None,
      mtu: Option[Int] = None,
      authKey: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None,
      addressFamily: Option[String] = None,
      virtualGatewayId: Option[String] = None,
      directConnectGatewayId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): NewPrivateVirtualInterface =
      NewPrivateVirtualInterface
        .builder
        .ifSome(virtualInterfaceName)(_.virtualInterfaceName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(mtu)(_.mtu(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def newPrivateVirtualInterfaceAllocation(
      virtualInterfaceName: Option[String] = None,
      vlan: Option[Int] = None,
      asn: Option[Int] = None,
      mtu: Option[Int] = None,
      authKey: Option[String] = None,
      amazonAddress: Option[String] = None,
      addressFamily: Option[String] = None,
      customerAddress: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): NewPrivateVirtualInterfaceAllocation =
      NewPrivateVirtualInterfaceAllocation
        .builder
        .ifSome(virtualInterfaceName)(_.virtualInterfaceName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(mtu)(_.mtu(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(tags)(_.tags(_))
        .build

    def newPublicVirtualInterface(
      virtualInterfaceName: Option[String] = None,
      vlan: Option[Int] = None,
      asn: Option[Int] = None,
      authKey: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None,
      addressFamily: Option[String] = None,
      routeFilterPrefixes: Option[List[RouteFilterPrefix]] = None,
      tags: Option[List[Tag]] = None
    ): NewPublicVirtualInterface =
      NewPublicVirtualInterface
        .builder
        .ifSome(virtualInterfaceName)(_.virtualInterfaceName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(routeFilterPrefixes)(_.routeFilterPrefixes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def newPublicVirtualInterfaceAllocation(
      virtualInterfaceName: Option[String] = None,
      vlan: Option[Int] = None,
      asn: Option[Int] = None,
      authKey: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None,
      addressFamily: Option[String] = None,
      routeFilterPrefixes: Option[List[RouteFilterPrefix]] = None,
      tags: Option[List[Tag]] = None
    ): NewPublicVirtualInterfaceAllocation =
      NewPublicVirtualInterfaceAllocation
        .builder
        .ifSome(virtualInterfaceName)(_.virtualInterfaceName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(routeFilterPrefixes)(_.routeFilterPrefixes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def newTransitVirtualInterface(
      virtualInterfaceName: Option[String] = None,
      vlan: Option[Int] = None,
      asn: Option[Int] = None,
      mtu: Option[Int] = None,
      authKey: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None,
      addressFamily: Option[String] = None,
      directConnectGatewayId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): NewTransitVirtualInterface =
      NewTransitVirtualInterface
        .builder
        .ifSome(virtualInterfaceName)(_.virtualInterfaceName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(mtu)(_.mtu(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def newTransitVirtualInterfaceAllocation(
      virtualInterfaceName: Option[String] = None,
      vlan: Option[Int] = None,
      asn: Option[Int] = None,
      mtu: Option[Int] = None,
      authKey: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None,
      addressFamily: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): NewTransitVirtualInterfaceAllocation =
      NewTransitVirtualInterfaceAllocation
        .builder
        .ifSome(virtualInterfaceName)(_.virtualInterfaceName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(mtu)(_.mtu(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceTag(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ResourceTag =
      ResourceTag
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def routeFilterPrefix(
      cidr: Option[String] = None
    ): RouteFilterPrefix =
      RouteFilterPrefix
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def startBgpFailoverTestRequest(
      virtualInterfaceId: Option[String] = None,
      bgpPeers: Option[List[BGPPeerId]] = None,
      testDurationInMinutes: Option[Int] = None
    ): StartBgpFailoverTestRequest =
      StartBgpFailoverTestRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(bgpPeers)(_.bgpPeers(_))
        .ifSome(testDurationInMinutes)(_.testDurationInMinutes(_))
        .build

    def startBgpFailoverTestResponse(
      virtualInterfaceTest: Option[VirtualInterfaceTestHistory] = None
    ): StartBgpFailoverTestResponse =
      StartBgpFailoverTestResponse
        .builder
        .ifSome(virtualInterfaceTest)(_.virtualInterfaceTest(_))
        .build

    def stopBgpFailoverTestRequest(
      virtualInterfaceId: Option[String] = None
    ): StopBgpFailoverTestRequest =
      StopBgpFailoverTestRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .build

    def stopBgpFailoverTestResponse(
      virtualInterfaceTest: Option[VirtualInterfaceTestHistory] = None
    ): StopBgpFailoverTestResponse =
      StopBgpFailoverTestResponse
        .builder
        .ifSome(virtualInterfaceTest)(_.virtualInterfaceTest(_))
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

    def tooManyTagsException(

    ): TooManyTagsException =
      TooManyTagsException
        .builder

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
      connectionId: Option[String] = None,
      connectionName: Option[String] = None,
      encryptionMode: Option[String] = None
    ): UpdateConnectionRequest =
      UpdateConnectionRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .build

    def updateDirectConnectGatewayAssociationRequest(
      associationId: Option[String] = None,
      addAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None,
      removeAllowedPrefixesToDirectConnectGateway: Option[List[RouteFilterPrefix]] = None
    ): UpdateDirectConnectGatewayAssociationRequest =
      UpdateDirectConnectGatewayAssociationRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(addAllowedPrefixesToDirectConnectGateway)(_.addAllowedPrefixesToDirectConnectGateway(_))
        .ifSome(removeAllowedPrefixesToDirectConnectGateway)(_.removeAllowedPrefixesToDirectConnectGateway(_))
        .build

    def updateLagRequest(
      lagId: Option[String] = None,
      lagName: Option[String] = None,
      minimumLinks: Option[Int] = None,
      encryptionMode: Option[String] = None
    ): UpdateLagRequest =
      UpdateLagRequest
        .builder
        .ifSome(lagId)(_.lagId(_))
        .ifSome(lagName)(_.lagName(_))
        .ifSome(minimumLinks)(_.minimumLinks(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .build

    def updateVirtualInterfaceAttributesRequest(
      virtualInterfaceId: Option[String] = None,
      mtu: Option[Int] = None
    ): UpdateVirtualInterfaceAttributesRequest =
      UpdateVirtualInterfaceAttributesRequest
        .builder
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(mtu)(_.mtu(_))
        .build

    def virtualGateway(
      virtualGatewayId: Option[String] = None,
      virtualGatewayState: Option[String] = None
    ): VirtualGateway =
      VirtualGateway
        .builder
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .ifSome(virtualGatewayState)(_.virtualGatewayState(_))
        .build

    def virtualGateways(
      virtualGateways: Option[List[VirtualGateway]] = None
    ): VirtualGateways =
      VirtualGateways
        .builder
        .ifSome(virtualGateways)(_.virtualGateways(_))
        .build

    def virtualInterface(
      ownerAccount: Option[String] = None,
      virtualInterfaceId: Option[String] = None,
      location: Option[String] = None,
      connectionId: Option[String] = None,
      virtualInterfaceType: Option[String] = None,
      virtualInterfaceName: Option[String] = None,
      vlan: Option[Int] = None,
      asn: Option[Int] = None,
      amazonSideAsn: Option[LongAsn] = None,
      authKey: Option[String] = None,
      amazonAddress: Option[String] = None,
      customerAddress: Option[String] = None,
      addressFamily: Option[String] = None,
      virtualInterfaceState: Option[String] = None,
      customerRouterConfig: Option[String] = None,
      mtu: Option[Int] = None,
      jumboFrameCapable: Option[Boolean] = None,
      virtualGatewayId: Option[String] = None,
      directConnectGatewayId: Option[String] = None,
      routeFilterPrefixes: Option[List[RouteFilterPrefix]] = None,
      bgpPeers: Option[List[BGPPeer]] = None,
      region: Option[String] = None,
      awsDeviceV2: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): VirtualInterface =
      VirtualInterface
        .builder
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(location)(_.location(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(virtualInterfaceType)(_.virtualInterfaceType(_))
        .ifSome(virtualInterfaceName)(_.virtualInterfaceName(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(asn)(_.asn(_))
        .ifSome(amazonSideAsn)(_.amazonSideAsn(_))
        .ifSome(authKey)(_.authKey(_))
        .ifSome(amazonAddress)(_.amazonAddress(_))
        .ifSome(customerAddress)(_.customerAddress(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(virtualInterfaceState)(_.virtualInterfaceState(_))
        .ifSome(customerRouterConfig)(_.customerRouterConfig(_))
        .ifSome(mtu)(_.mtu(_))
        .ifSome(jumboFrameCapable)(_.jumboFrameCapable(_))
        .ifSome(virtualGatewayId)(_.virtualGatewayId(_))
        .ifSome(directConnectGatewayId)(_.directConnectGatewayId(_))
        .ifSome(routeFilterPrefixes)(_.routeFilterPrefixes(_))
        .ifSome(bgpPeers)(_.bgpPeers(_))
        .ifSome(region)(_.region(_))
        .ifSome(awsDeviceV2)(_.awsDeviceV2(_))
        .ifSome(tags)(_.tags(_))
        .build

    def virtualInterfaceTestHistory(
      testId: Option[String] = None,
      virtualInterfaceId: Option[String] = None,
      bgpPeers: Option[List[BGPPeerId]] = None,
      status: Option[String] = None,
      ownerAccount: Option[String] = None,
      testDurationInMinutes: Option[Int] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None
    ): VirtualInterfaceTestHistory =
      VirtualInterfaceTestHistory
        .builder
        .ifSome(testId)(_.testId(_))
        .ifSome(virtualInterfaceId)(_.virtualInterfaceId(_))
        .ifSome(bgpPeers)(_.bgpPeers(_))
        .ifSome(status)(_.status(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(testDurationInMinutes)(_.testDurationInMinutes(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def virtualInterfaces(
      virtualInterfaces: Option[List[VirtualInterface]] = None
    ): VirtualInterfaces =
      VirtualInterfaces
        .builder
        .ifSome(virtualInterfaces)(_.virtualInterfaces(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
