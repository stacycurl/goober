package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ec2.Ec2Client
import software.amazon.awssdk.services.ec2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ec2 { module =>

  // Free monad over Ec2Op
  type Ec2IO[A] = FF[Ec2Op, A]

  sealed trait Ec2Op[A] {
    def visit[F[_]](visitor: Ec2Op.Visitor[F]): F[A]
  }

  object Ec2Op {
    // Given a Ec2Client we can embed a Ec2IO program in any algebra that understands embedding.
    implicit val Ec2OpEmbeddable: Embeddable[Ec2Op, Ec2Client] = new Embeddable[Ec2Op, Ec2Client] {
      def embed[A](client: Ec2Client, io: Ec2IO[A]): Embedded[A] = Embedded.Ec2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Ec2Op.Visitor[Kleisli[M, Ec2Client, *]] {
        def acceptReservedInstancesExchangeQuote(
          request: AcceptReservedInstancesExchangeQuoteRequest
        ): Kleisli[M, Ec2Client, AcceptReservedInstancesExchangeQuoteResponse] =
          primitive(_.acceptReservedInstancesExchangeQuote(request))

        def acceptTransitGatewayMulticastDomainAssociations(
          request: AcceptTransitGatewayMulticastDomainAssociationsRequest
        ): Kleisli[M, Ec2Client, AcceptTransitGatewayMulticastDomainAssociationsResponse] =
          primitive(_.acceptTransitGatewayMulticastDomainAssociations(request))

        def acceptTransitGatewayPeeringAttachment(
          request: AcceptTransitGatewayPeeringAttachmentRequest
        ): Kleisli[M, Ec2Client, AcceptTransitGatewayPeeringAttachmentResponse] =
          primitive(_.acceptTransitGatewayPeeringAttachment(request))

        def acceptTransitGatewayVpcAttachment(
          request: AcceptTransitGatewayVpcAttachmentRequest
        ): Kleisli[M, Ec2Client, AcceptTransitGatewayVpcAttachmentResponse] =
          primitive(_.acceptTransitGatewayVpcAttachment(request))

        def acceptVpcEndpointConnections(
          request: AcceptVpcEndpointConnectionsRequest
        ): Kleisli[M, Ec2Client, AcceptVpcEndpointConnectionsResponse] =
          primitive(_.acceptVpcEndpointConnections(request))

        def acceptVpcPeeringConnection(
          request: AcceptVpcPeeringConnectionRequest
        ): Kleisli[M, Ec2Client, AcceptVpcPeeringConnectionResponse] =
          primitive(_.acceptVpcPeeringConnection(request))

        def advertiseByoipCidr(
          request: AdvertiseByoipCidrRequest
        ): Kleisli[M, Ec2Client, AdvertiseByoipCidrResponse] =
          primitive(_.advertiseByoipCidr(request))

        def allocateAddress(
          request: AllocateAddressRequest
        ): Kleisli[M, Ec2Client, AllocateAddressResponse] =
          primitive(_.allocateAddress(request))

        def allocateHosts(
          request: AllocateHostsRequest
        ): Kleisli[M, Ec2Client, AllocateHostsResponse] =
          primitive(_.allocateHosts(request))

        def applySecurityGroupsToClientVpnTargetNetwork(
          request: ApplySecurityGroupsToClientVpnTargetNetworkRequest
        ): Kleisli[M, Ec2Client, ApplySecurityGroupsToClientVpnTargetNetworkResponse] =
          primitive(_.applySecurityGroupsToClientVpnTargetNetwork(request))

        def assignIpv6Addresses(
          request: AssignIpv6AddressesRequest
        ): Kleisli[M, Ec2Client, AssignIpv6AddressesResponse] =
          primitive(_.assignIpv6Addresses(request))

        def assignPrivateIpAddresses(
          request: AssignPrivateIpAddressesRequest
        ): Kleisli[M, Ec2Client, AssignPrivateIpAddressesResponse] =
          primitive(_.assignPrivateIpAddresses(request))

        def associateAddress(
          request: AssociateAddressRequest
        ): Kleisli[M, Ec2Client, AssociateAddressResponse] =
          primitive(_.associateAddress(request))

        def associateClientVpnTargetNetwork(
          request: AssociateClientVpnTargetNetworkRequest
        ): Kleisli[M, Ec2Client, AssociateClientVpnTargetNetworkResponse] =
          primitive(_.associateClientVpnTargetNetwork(request))

        def associateDhcpOptions(
          request: AssociateDhcpOptionsRequest
        ): Kleisli[M, Ec2Client, AssociateDhcpOptionsResponse] =
          primitive(_.associateDhcpOptions(request))

        def associateEnclaveCertificateIamRole(
          request: AssociateEnclaveCertificateIamRoleRequest
        ): Kleisli[M, Ec2Client, AssociateEnclaveCertificateIamRoleResponse] =
          primitive(_.associateEnclaveCertificateIamRole(request))

        def associateIamInstanceProfile(
          request: AssociateIamInstanceProfileRequest
        ): Kleisli[M, Ec2Client, AssociateIamInstanceProfileResponse] =
          primitive(_.associateIamInstanceProfile(request))

        def associateRouteTable(
          request: AssociateRouteTableRequest
        ): Kleisli[M, Ec2Client, AssociateRouteTableResponse] =
          primitive(_.associateRouteTable(request))

        def associateSubnetCidrBlock(
          request: AssociateSubnetCidrBlockRequest
        ): Kleisli[M, Ec2Client, AssociateSubnetCidrBlockResponse] =
          primitive(_.associateSubnetCidrBlock(request))

        def associateTransitGatewayMulticastDomain(
          request: AssociateTransitGatewayMulticastDomainRequest
        ): Kleisli[M, Ec2Client, AssociateTransitGatewayMulticastDomainResponse] =
          primitive(_.associateTransitGatewayMulticastDomain(request))

        def associateTransitGatewayRouteTable(
          request: AssociateTransitGatewayRouteTableRequest
        ): Kleisli[M, Ec2Client, AssociateTransitGatewayRouteTableResponse] =
          primitive(_.associateTransitGatewayRouteTable(request))

        def associateVpcCidrBlock(
          request: AssociateVpcCidrBlockRequest
        ): Kleisli[M, Ec2Client, AssociateVpcCidrBlockResponse] =
          primitive(_.associateVpcCidrBlock(request))

        def attachClassicLinkVpc(
          request: AttachClassicLinkVpcRequest
        ): Kleisli[M, Ec2Client, AttachClassicLinkVpcResponse] =
          primitive(_.attachClassicLinkVpc(request))

        def attachInternetGateway(
          request: AttachInternetGatewayRequest
        ): Kleisli[M, Ec2Client, AttachInternetGatewayResponse] =
          primitive(_.attachInternetGateway(request))

        def attachNetworkInterface(
          request: AttachNetworkInterfaceRequest
        ): Kleisli[M, Ec2Client, AttachNetworkInterfaceResponse] =
          primitive(_.attachNetworkInterface(request))

        def attachVolume(
          request: AttachVolumeRequest
        ): Kleisli[M, Ec2Client, AttachVolumeResponse] =
          primitive(_.attachVolume(request))

        def attachVpnGateway(
          request: AttachVpnGatewayRequest
        ): Kleisli[M, Ec2Client, AttachVpnGatewayResponse] =
          primitive(_.attachVpnGateway(request))

        def authorizeClientVpnIngress(
          request: AuthorizeClientVpnIngressRequest
        ): Kleisli[M, Ec2Client, AuthorizeClientVpnIngressResponse] =
          primitive(_.authorizeClientVpnIngress(request))

        def authorizeSecurityGroupEgress(
          request: AuthorizeSecurityGroupEgressRequest
        ): Kleisli[M, Ec2Client, AuthorizeSecurityGroupEgressResponse] =
          primitive(_.authorizeSecurityGroupEgress(request))

        def authorizeSecurityGroupIngress(
          request: AuthorizeSecurityGroupIngressRequest
        ): Kleisli[M, Ec2Client, AuthorizeSecurityGroupIngressResponse] =
          primitive(_.authorizeSecurityGroupIngress(request))

        def bundleInstance(
          request: BundleInstanceRequest
        ): Kleisli[M, Ec2Client, BundleInstanceResponse] =
          primitive(_.bundleInstance(request))

        def cancelBundleTask(
          request: CancelBundleTaskRequest
        ): Kleisli[M, Ec2Client, CancelBundleTaskResponse] =
          primitive(_.cancelBundleTask(request))

        def cancelCapacityReservation(
          request: CancelCapacityReservationRequest
        ): Kleisli[M, Ec2Client, CancelCapacityReservationResponse] =
          primitive(_.cancelCapacityReservation(request))

        def cancelConversionTask(
          request: CancelConversionTaskRequest
        ): Kleisli[M, Ec2Client, CancelConversionTaskResponse] =
          primitive(_.cancelConversionTask(request))

        def cancelExportTask(
          request: CancelExportTaskRequest
        ): Kleisli[M, Ec2Client, CancelExportTaskResponse] =
          primitive(_.cancelExportTask(request))

        def cancelImportTask(
          request: CancelImportTaskRequest
        ): Kleisli[M, Ec2Client, CancelImportTaskResponse] =
          primitive(_.cancelImportTask(request))

        def cancelReservedInstancesListing(
          request: CancelReservedInstancesListingRequest
        ): Kleisli[M, Ec2Client, CancelReservedInstancesListingResponse] =
          primitive(_.cancelReservedInstancesListing(request))

        def cancelSpotFleetRequests(
          request: CancelSpotFleetRequestsRequest
        ): Kleisli[M, Ec2Client, CancelSpotFleetRequestsResponse] =
          primitive(_.cancelSpotFleetRequests(request))

        def cancelSpotInstanceRequests(
          request: CancelSpotInstanceRequestsRequest
        ): Kleisli[M, Ec2Client, CancelSpotInstanceRequestsResponse] =
          primitive(_.cancelSpotInstanceRequests(request))

        def confirmProductInstance(
          request: ConfirmProductInstanceRequest
        ): Kleisli[M, Ec2Client, ConfirmProductInstanceResponse] =
          primitive(_.confirmProductInstance(request))

        def copyFpgaImage(
          request: CopyFpgaImageRequest
        ): Kleisli[M, Ec2Client, CopyFpgaImageResponse] =
          primitive(_.copyFpgaImage(request))

        def copyImage(
          request: CopyImageRequest
        ): Kleisli[M, Ec2Client, CopyImageResponse] =
          primitive(_.copyImage(request))

        def copySnapshot(
          request: CopySnapshotRequest
        ): Kleisli[M, Ec2Client, CopySnapshotResponse] =
          primitive(_.copySnapshot(request))

        def createCapacityReservation(
          request: CreateCapacityReservationRequest
        ): Kleisli[M, Ec2Client, CreateCapacityReservationResponse] =
          primitive(_.createCapacityReservation(request))

        def createCarrierGateway(
          request: CreateCarrierGatewayRequest
        ): Kleisli[M, Ec2Client, CreateCarrierGatewayResponse] =
          primitive(_.createCarrierGateway(request))

        def createClientVpnEndpoint(
          request: CreateClientVpnEndpointRequest
        ): Kleisli[M, Ec2Client, CreateClientVpnEndpointResponse] =
          primitive(_.createClientVpnEndpoint(request))

        def createClientVpnRoute(
          request: CreateClientVpnRouteRequest
        ): Kleisli[M, Ec2Client, CreateClientVpnRouteResponse] =
          primitive(_.createClientVpnRoute(request))

        def createCustomerGateway(
          request: CreateCustomerGatewayRequest
        ): Kleisli[M, Ec2Client, CreateCustomerGatewayResponse] =
          primitive(_.createCustomerGateway(request))

        def createDefaultSubnet(
          request: CreateDefaultSubnetRequest
        ): Kleisli[M, Ec2Client, CreateDefaultSubnetResponse] =
          primitive(_.createDefaultSubnet(request))

        def createDefaultVpc(
          request: CreateDefaultVpcRequest
        ): Kleisli[M, Ec2Client, CreateDefaultVpcResponse] =
          primitive(_.createDefaultVpc(request))

        def createDhcpOptions(
          request: CreateDhcpOptionsRequest
        ): Kleisli[M, Ec2Client, CreateDhcpOptionsResponse] =
          primitive(_.createDhcpOptions(request))

        def createEgressOnlyInternetGateway(
          request: CreateEgressOnlyInternetGatewayRequest
        ): Kleisli[M, Ec2Client, CreateEgressOnlyInternetGatewayResponse] =
          primitive(_.createEgressOnlyInternetGateway(request))

        def createFleet(
          request: CreateFleetRequest
        ): Kleisli[M, Ec2Client, CreateFleetResponse] =
          primitive(_.createFleet(request))

        def createFlowLogs(
          request: CreateFlowLogsRequest
        ): Kleisli[M, Ec2Client, CreateFlowLogsResponse] =
          primitive(_.createFlowLogs(request))

        def createFpgaImage(
          request: CreateFpgaImageRequest
        ): Kleisli[M, Ec2Client, CreateFpgaImageResponse] =
          primitive(_.createFpgaImage(request))

        def createImage(
          request: CreateImageRequest
        ): Kleisli[M, Ec2Client, CreateImageResponse] =
          primitive(_.createImage(request))

        def createInstanceExportTask(
          request: CreateInstanceExportTaskRequest
        ): Kleisli[M, Ec2Client, CreateInstanceExportTaskResponse] =
          primitive(_.createInstanceExportTask(request))

        def createInternetGateway(
          request: CreateInternetGatewayRequest
        ): Kleisli[M, Ec2Client, CreateInternetGatewayResponse] =
          primitive(_.createInternetGateway(request))

        def createKeyPair(
          request: CreateKeyPairRequest
        ): Kleisli[M, Ec2Client, CreateKeyPairResponse] =
          primitive(_.createKeyPair(request))

        def createLaunchTemplate(
          request: CreateLaunchTemplateRequest
        ): Kleisli[M, Ec2Client, CreateLaunchTemplateResponse] =
          primitive(_.createLaunchTemplate(request))

        def createLaunchTemplateVersion(
          request: CreateLaunchTemplateVersionRequest
        ): Kleisli[M, Ec2Client, CreateLaunchTemplateVersionResponse] =
          primitive(_.createLaunchTemplateVersion(request))

        def createLocalGatewayRoute(
          request: CreateLocalGatewayRouteRequest
        ): Kleisli[M, Ec2Client, CreateLocalGatewayRouteResponse] =
          primitive(_.createLocalGatewayRoute(request))

        def createLocalGatewayRouteTableVpcAssociation(
          request: CreateLocalGatewayRouteTableVpcAssociationRequest
        ): Kleisli[M, Ec2Client, CreateLocalGatewayRouteTableVpcAssociationResponse] =
          primitive(_.createLocalGatewayRouteTableVpcAssociation(request))

        def createManagedPrefixList(
          request: CreateManagedPrefixListRequest
        ): Kleisli[M, Ec2Client, CreateManagedPrefixListResponse] =
          primitive(_.createManagedPrefixList(request))

        def createNatGateway(
          request: CreateNatGatewayRequest
        ): Kleisli[M, Ec2Client, CreateNatGatewayResponse] =
          primitive(_.createNatGateway(request))

        def createNetworkAcl(
          request: CreateNetworkAclRequest
        ): Kleisli[M, Ec2Client, CreateNetworkAclResponse] =
          primitive(_.createNetworkAcl(request))

        def createNetworkAclEntry(
          request: CreateNetworkAclEntryRequest
        ): Kleisli[M, Ec2Client, CreateNetworkAclEntryResponse] =
          primitive(_.createNetworkAclEntry(request))

        def createNetworkInsightsPath(
          request: CreateNetworkInsightsPathRequest
        ): Kleisli[M, Ec2Client, CreateNetworkInsightsPathResponse] =
          primitive(_.createNetworkInsightsPath(request))

        def createNetworkInterface(
          request: CreateNetworkInterfaceRequest
        ): Kleisli[M, Ec2Client, CreateNetworkInterfaceResponse] =
          primitive(_.createNetworkInterface(request))

        def createNetworkInterfacePermission(
          request: CreateNetworkInterfacePermissionRequest
        ): Kleisli[M, Ec2Client, CreateNetworkInterfacePermissionResponse] =
          primitive(_.createNetworkInterfacePermission(request))

        def createPlacementGroup(
          request: CreatePlacementGroupRequest
        ): Kleisli[M, Ec2Client, CreatePlacementGroupResponse] =
          primitive(_.createPlacementGroup(request))

        def createReplaceRootVolumeTask(
          request: CreateReplaceRootVolumeTaskRequest
        ): Kleisli[M, Ec2Client, CreateReplaceRootVolumeTaskResponse] =
          primitive(_.createReplaceRootVolumeTask(request))

        def createReservedInstancesListing(
          request: CreateReservedInstancesListingRequest
        ): Kleisli[M, Ec2Client, CreateReservedInstancesListingResponse] =
          primitive(_.createReservedInstancesListing(request))

        def createRestoreImageTask(
          request: CreateRestoreImageTaskRequest
        ): Kleisli[M, Ec2Client, CreateRestoreImageTaskResponse] =
          primitive(_.createRestoreImageTask(request))

        def createRoute(
          request: CreateRouteRequest
        ): Kleisli[M, Ec2Client, CreateRouteResponse] =
          primitive(_.createRoute(request))

        def createRouteTable(
          request: CreateRouteTableRequest
        ): Kleisli[M, Ec2Client, CreateRouteTableResponse] =
          primitive(_.createRouteTable(request))

        def createSecurityGroup(
          request: CreateSecurityGroupRequest
        ): Kleisli[M, Ec2Client, CreateSecurityGroupResponse] =
          primitive(_.createSecurityGroup(request))

        def createSnapshot(
          request: CreateSnapshotRequest
        ): Kleisli[M, Ec2Client, CreateSnapshotResponse] =
          primitive(_.createSnapshot(request))

        def createSnapshots(
          request: CreateSnapshotsRequest
        ): Kleisli[M, Ec2Client, CreateSnapshotsResponse] =
          primitive(_.createSnapshots(request))

        def createSpotDatafeedSubscription(
          request: CreateSpotDatafeedSubscriptionRequest
        ): Kleisli[M, Ec2Client, CreateSpotDatafeedSubscriptionResponse] =
          primitive(_.createSpotDatafeedSubscription(request))

        def createStoreImageTask(
          request: CreateStoreImageTaskRequest
        ): Kleisli[M, Ec2Client, CreateStoreImageTaskResponse] =
          primitive(_.createStoreImageTask(request))

        def createSubnet(
          request: CreateSubnetRequest
        ): Kleisli[M, Ec2Client, CreateSubnetResponse] =
          primitive(_.createSubnet(request))

        def createTags(
          request: CreateTagsRequest
        ): Kleisli[M, Ec2Client, CreateTagsResponse] =
          primitive(_.createTags(request))

        def createTrafficMirrorFilter(
          request: CreateTrafficMirrorFilterRequest
        ): Kleisli[M, Ec2Client, CreateTrafficMirrorFilterResponse] =
          primitive(_.createTrafficMirrorFilter(request))

        def createTrafficMirrorFilterRule(
          request: CreateTrafficMirrorFilterRuleRequest
        ): Kleisli[M, Ec2Client, CreateTrafficMirrorFilterRuleResponse] =
          primitive(_.createTrafficMirrorFilterRule(request))

        def createTrafficMirrorSession(
          request: CreateTrafficMirrorSessionRequest
        ): Kleisli[M, Ec2Client, CreateTrafficMirrorSessionResponse] =
          primitive(_.createTrafficMirrorSession(request))

        def createTrafficMirrorTarget(
          request: CreateTrafficMirrorTargetRequest
        ): Kleisli[M, Ec2Client, CreateTrafficMirrorTargetResponse] =
          primitive(_.createTrafficMirrorTarget(request))

        def createTransitGateway(
          request: CreateTransitGatewayRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayResponse] =
          primitive(_.createTransitGateway(request))

        def createTransitGatewayConnect(
          request: CreateTransitGatewayConnectRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayConnectResponse] =
          primitive(_.createTransitGatewayConnect(request))

        def createTransitGatewayConnectPeer(
          request: CreateTransitGatewayConnectPeerRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayConnectPeerResponse] =
          primitive(_.createTransitGatewayConnectPeer(request))

        def createTransitGatewayMulticastDomain(
          request: CreateTransitGatewayMulticastDomainRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayMulticastDomainResponse] =
          primitive(_.createTransitGatewayMulticastDomain(request))

        def createTransitGatewayPeeringAttachment(
          request: CreateTransitGatewayPeeringAttachmentRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayPeeringAttachmentResponse] =
          primitive(_.createTransitGatewayPeeringAttachment(request))

        def createTransitGatewayPrefixListReference(
          request: CreateTransitGatewayPrefixListReferenceRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayPrefixListReferenceResponse] =
          primitive(_.createTransitGatewayPrefixListReference(request))

        def createTransitGatewayRoute(
          request: CreateTransitGatewayRouteRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayRouteResponse] =
          primitive(_.createTransitGatewayRoute(request))

        def createTransitGatewayRouteTable(
          request: CreateTransitGatewayRouteTableRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayRouteTableResponse] =
          primitive(_.createTransitGatewayRouteTable(request))

        def createTransitGatewayVpcAttachment(
          request: CreateTransitGatewayVpcAttachmentRequest
        ): Kleisli[M, Ec2Client, CreateTransitGatewayVpcAttachmentResponse] =
          primitive(_.createTransitGatewayVpcAttachment(request))

        def createVolume(
          request: CreateVolumeRequest
        ): Kleisli[M, Ec2Client, CreateVolumeResponse] =
          primitive(_.createVolume(request))

        def createVpc(
          request: CreateVpcRequest
        ): Kleisli[M, Ec2Client, CreateVpcResponse] =
          primitive(_.createVpc(request))

        def createVpcEndpoint(
          request: CreateVpcEndpointRequest
        ): Kleisli[M, Ec2Client, CreateVpcEndpointResponse] =
          primitive(_.createVpcEndpoint(request))

        def createVpcEndpointConnectionNotification(
          request: CreateVpcEndpointConnectionNotificationRequest
        ): Kleisli[M, Ec2Client, CreateVpcEndpointConnectionNotificationResponse] =
          primitive(_.createVpcEndpointConnectionNotification(request))

        def createVpcEndpointServiceConfiguration(
          request: CreateVpcEndpointServiceConfigurationRequest
        ): Kleisli[M, Ec2Client, CreateVpcEndpointServiceConfigurationResponse] =
          primitive(_.createVpcEndpointServiceConfiguration(request))

        def createVpcPeeringConnection(
          request: CreateVpcPeeringConnectionRequest
        ): Kleisli[M, Ec2Client, CreateVpcPeeringConnectionResponse] =
          primitive(_.createVpcPeeringConnection(request))

        def createVpnConnection(
          request: CreateVpnConnectionRequest
        ): Kleisli[M, Ec2Client, CreateVpnConnectionResponse] =
          primitive(_.createVpnConnection(request))

        def createVpnConnectionRoute(
          request: CreateVpnConnectionRouteRequest
        ): Kleisli[M, Ec2Client, CreateVpnConnectionRouteResponse] =
          primitive(_.createVpnConnectionRoute(request))

        def createVpnGateway(
          request: CreateVpnGatewayRequest
        ): Kleisli[M, Ec2Client, CreateVpnGatewayResponse] =
          primitive(_.createVpnGateway(request))

        def deleteCarrierGateway(
          request: DeleteCarrierGatewayRequest
        ): Kleisli[M, Ec2Client, DeleteCarrierGatewayResponse] =
          primitive(_.deleteCarrierGateway(request))

        def deleteClientVpnEndpoint(
          request: DeleteClientVpnEndpointRequest
        ): Kleisli[M, Ec2Client, DeleteClientVpnEndpointResponse] =
          primitive(_.deleteClientVpnEndpoint(request))

        def deleteClientVpnRoute(
          request: DeleteClientVpnRouteRequest
        ): Kleisli[M, Ec2Client, DeleteClientVpnRouteResponse] =
          primitive(_.deleteClientVpnRoute(request))

        def deleteCustomerGateway(
          request: DeleteCustomerGatewayRequest
        ): Kleisli[M, Ec2Client, DeleteCustomerGatewayResponse] =
          primitive(_.deleteCustomerGateway(request))

        def deleteDhcpOptions(
          request: DeleteDhcpOptionsRequest
        ): Kleisli[M, Ec2Client, DeleteDhcpOptionsResponse] =
          primitive(_.deleteDhcpOptions(request))

        def deleteEgressOnlyInternetGateway(
          request: DeleteEgressOnlyInternetGatewayRequest
        ): Kleisli[M, Ec2Client, DeleteEgressOnlyInternetGatewayResponse] =
          primitive(_.deleteEgressOnlyInternetGateway(request))

        def deleteFleets(
          request: DeleteFleetsRequest
        ): Kleisli[M, Ec2Client, DeleteFleetsResponse] =
          primitive(_.deleteFleets(request))

        def deleteFlowLogs(
          request: DeleteFlowLogsRequest
        ): Kleisli[M, Ec2Client, DeleteFlowLogsResponse] =
          primitive(_.deleteFlowLogs(request))

        def deleteFpgaImage(
          request: DeleteFpgaImageRequest
        ): Kleisli[M, Ec2Client, DeleteFpgaImageResponse] =
          primitive(_.deleteFpgaImage(request))

        def deleteInternetGateway(
          request: DeleteInternetGatewayRequest
        ): Kleisli[M, Ec2Client, DeleteInternetGatewayResponse] =
          primitive(_.deleteInternetGateway(request))

        def deleteKeyPair(
          request: DeleteKeyPairRequest
        ): Kleisli[M, Ec2Client, DeleteKeyPairResponse] =
          primitive(_.deleteKeyPair(request))

        def deleteLaunchTemplate(
          request: DeleteLaunchTemplateRequest
        ): Kleisli[M, Ec2Client, DeleteLaunchTemplateResponse] =
          primitive(_.deleteLaunchTemplate(request))

        def deleteLaunchTemplateVersions(
          request: DeleteLaunchTemplateVersionsRequest
        ): Kleisli[M, Ec2Client, DeleteLaunchTemplateVersionsResponse] =
          primitive(_.deleteLaunchTemplateVersions(request))

        def deleteLocalGatewayRoute(
          request: DeleteLocalGatewayRouteRequest
        ): Kleisli[M, Ec2Client, DeleteLocalGatewayRouteResponse] =
          primitive(_.deleteLocalGatewayRoute(request))

        def deleteLocalGatewayRouteTableVpcAssociation(
          request: DeleteLocalGatewayRouteTableVpcAssociationRequest
        ): Kleisli[M, Ec2Client, DeleteLocalGatewayRouteTableVpcAssociationResponse] =
          primitive(_.deleteLocalGatewayRouteTableVpcAssociation(request))

        def deleteManagedPrefixList(
          request: DeleteManagedPrefixListRequest
        ): Kleisli[M, Ec2Client, DeleteManagedPrefixListResponse] =
          primitive(_.deleteManagedPrefixList(request))

        def deleteNatGateway(
          request: DeleteNatGatewayRequest
        ): Kleisli[M, Ec2Client, DeleteNatGatewayResponse] =
          primitive(_.deleteNatGateway(request))

        def deleteNetworkAcl(
          request: DeleteNetworkAclRequest
        ): Kleisli[M, Ec2Client, DeleteNetworkAclResponse] =
          primitive(_.deleteNetworkAcl(request))

        def deleteNetworkAclEntry(
          request: DeleteNetworkAclEntryRequest
        ): Kleisli[M, Ec2Client, DeleteNetworkAclEntryResponse] =
          primitive(_.deleteNetworkAclEntry(request))

        def deleteNetworkInsightsAnalysis(
          request: DeleteNetworkInsightsAnalysisRequest
        ): Kleisli[M, Ec2Client, DeleteNetworkInsightsAnalysisResponse] =
          primitive(_.deleteNetworkInsightsAnalysis(request))

        def deleteNetworkInsightsPath(
          request: DeleteNetworkInsightsPathRequest
        ): Kleisli[M, Ec2Client, DeleteNetworkInsightsPathResponse] =
          primitive(_.deleteNetworkInsightsPath(request))

        def deleteNetworkInterface(
          request: DeleteNetworkInterfaceRequest
        ): Kleisli[M, Ec2Client, DeleteNetworkInterfaceResponse] =
          primitive(_.deleteNetworkInterface(request))

        def deleteNetworkInterfacePermission(
          request: DeleteNetworkInterfacePermissionRequest
        ): Kleisli[M, Ec2Client, DeleteNetworkInterfacePermissionResponse] =
          primitive(_.deleteNetworkInterfacePermission(request))

        def deletePlacementGroup(
          request: DeletePlacementGroupRequest
        ): Kleisli[M, Ec2Client, DeletePlacementGroupResponse] =
          primitive(_.deletePlacementGroup(request))

        def deleteQueuedReservedInstances(
          request: DeleteQueuedReservedInstancesRequest
        ): Kleisli[M, Ec2Client, DeleteQueuedReservedInstancesResponse] =
          primitive(_.deleteQueuedReservedInstances(request))

        def deleteRoute(
          request: DeleteRouteRequest
        ): Kleisli[M, Ec2Client, DeleteRouteResponse] =
          primitive(_.deleteRoute(request))

        def deleteRouteTable(
          request: DeleteRouteTableRequest
        ): Kleisli[M, Ec2Client, DeleteRouteTableResponse] =
          primitive(_.deleteRouteTable(request))

        def deleteSecurityGroup(
          request: DeleteSecurityGroupRequest
        ): Kleisli[M, Ec2Client, DeleteSecurityGroupResponse] =
          primitive(_.deleteSecurityGroup(request))

        def deleteSnapshot(
          request: DeleteSnapshotRequest
        ): Kleisli[M, Ec2Client, DeleteSnapshotResponse] =
          primitive(_.deleteSnapshot(request))

        def deleteSpotDatafeedSubscription(
          request: DeleteSpotDatafeedSubscriptionRequest
        ): Kleisli[M, Ec2Client, DeleteSpotDatafeedSubscriptionResponse] =
          primitive(_.deleteSpotDatafeedSubscription(request))

        def deleteSubnet(
          request: DeleteSubnetRequest
        ): Kleisli[M, Ec2Client, DeleteSubnetResponse] =
          primitive(_.deleteSubnet(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, Ec2Client, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def deleteTrafficMirrorFilter(
          request: DeleteTrafficMirrorFilterRequest
        ): Kleisli[M, Ec2Client, DeleteTrafficMirrorFilterResponse] =
          primitive(_.deleteTrafficMirrorFilter(request))

        def deleteTrafficMirrorFilterRule(
          request: DeleteTrafficMirrorFilterRuleRequest
        ): Kleisli[M, Ec2Client, DeleteTrafficMirrorFilterRuleResponse] =
          primitive(_.deleteTrafficMirrorFilterRule(request))

        def deleteTrafficMirrorSession(
          request: DeleteTrafficMirrorSessionRequest
        ): Kleisli[M, Ec2Client, DeleteTrafficMirrorSessionResponse] =
          primitive(_.deleteTrafficMirrorSession(request))

        def deleteTrafficMirrorTarget(
          request: DeleteTrafficMirrorTargetRequest
        ): Kleisli[M, Ec2Client, DeleteTrafficMirrorTargetResponse] =
          primitive(_.deleteTrafficMirrorTarget(request))

        def deleteTransitGateway(
          request: DeleteTransitGatewayRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayResponse] =
          primitive(_.deleteTransitGateway(request))

        def deleteTransitGatewayConnect(
          request: DeleteTransitGatewayConnectRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayConnectResponse] =
          primitive(_.deleteTransitGatewayConnect(request))

        def deleteTransitGatewayConnectPeer(
          request: DeleteTransitGatewayConnectPeerRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayConnectPeerResponse] =
          primitive(_.deleteTransitGatewayConnectPeer(request))

        def deleteTransitGatewayMulticastDomain(
          request: DeleteTransitGatewayMulticastDomainRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayMulticastDomainResponse] =
          primitive(_.deleteTransitGatewayMulticastDomain(request))

        def deleteTransitGatewayPeeringAttachment(
          request: DeleteTransitGatewayPeeringAttachmentRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayPeeringAttachmentResponse] =
          primitive(_.deleteTransitGatewayPeeringAttachment(request))

        def deleteTransitGatewayPrefixListReference(
          request: DeleteTransitGatewayPrefixListReferenceRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayPrefixListReferenceResponse] =
          primitive(_.deleteTransitGatewayPrefixListReference(request))

        def deleteTransitGatewayRoute(
          request: DeleteTransitGatewayRouteRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayRouteResponse] =
          primitive(_.deleteTransitGatewayRoute(request))

        def deleteTransitGatewayRouteTable(
          request: DeleteTransitGatewayRouteTableRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayRouteTableResponse] =
          primitive(_.deleteTransitGatewayRouteTable(request))

        def deleteTransitGatewayVpcAttachment(
          request: DeleteTransitGatewayVpcAttachmentRequest
        ): Kleisli[M, Ec2Client, DeleteTransitGatewayVpcAttachmentResponse] =
          primitive(_.deleteTransitGatewayVpcAttachment(request))

        def deleteVolume(
          request: DeleteVolumeRequest
        ): Kleisli[M, Ec2Client, DeleteVolumeResponse] =
          primitive(_.deleteVolume(request))

        def deleteVpc(
          request: DeleteVpcRequest
        ): Kleisli[M, Ec2Client, DeleteVpcResponse] =
          primitive(_.deleteVpc(request))

        def deleteVpcEndpointConnectionNotifications(
          request: DeleteVpcEndpointConnectionNotificationsRequest
        ): Kleisli[M, Ec2Client, DeleteVpcEndpointConnectionNotificationsResponse] =
          primitive(_.deleteVpcEndpointConnectionNotifications(request))

        def deleteVpcEndpointServiceConfigurations(
          request: DeleteVpcEndpointServiceConfigurationsRequest
        ): Kleisli[M, Ec2Client, DeleteVpcEndpointServiceConfigurationsResponse] =
          primitive(_.deleteVpcEndpointServiceConfigurations(request))

        def deleteVpcEndpoints(
          request: DeleteVpcEndpointsRequest
        ): Kleisli[M, Ec2Client, DeleteVpcEndpointsResponse] =
          primitive(_.deleteVpcEndpoints(request))

        def deleteVpcPeeringConnection(
          request: DeleteVpcPeeringConnectionRequest
        ): Kleisli[M, Ec2Client, DeleteVpcPeeringConnectionResponse] =
          primitive(_.deleteVpcPeeringConnection(request))

        def deleteVpnConnection(
          request: DeleteVpnConnectionRequest
        ): Kleisli[M, Ec2Client, DeleteVpnConnectionResponse] =
          primitive(_.deleteVpnConnection(request))

        def deleteVpnConnectionRoute(
          request: DeleteVpnConnectionRouteRequest
        ): Kleisli[M, Ec2Client, DeleteVpnConnectionRouteResponse] =
          primitive(_.deleteVpnConnectionRoute(request))

        def deleteVpnGateway(
          request: DeleteVpnGatewayRequest
        ): Kleisli[M, Ec2Client, DeleteVpnGatewayResponse] =
          primitive(_.deleteVpnGateway(request))

        def deprovisionByoipCidr(
          request: DeprovisionByoipCidrRequest
        ): Kleisli[M, Ec2Client, DeprovisionByoipCidrResponse] =
          primitive(_.deprovisionByoipCidr(request))

        def deregisterImage(
          request: DeregisterImageRequest
        ): Kleisli[M, Ec2Client, DeregisterImageResponse] =
          primitive(_.deregisterImage(request))

        def deregisterInstanceEventNotificationAttributes(
          request: DeregisterInstanceEventNotificationAttributesRequest
        ): Kleisli[M, Ec2Client, DeregisterInstanceEventNotificationAttributesResponse] =
          primitive(_.deregisterInstanceEventNotificationAttributes(request))

        def deregisterTransitGatewayMulticastGroupMembers(
          request: DeregisterTransitGatewayMulticastGroupMembersRequest
        ): Kleisli[M, Ec2Client, DeregisterTransitGatewayMulticastGroupMembersResponse] =
          primitive(_.deregisterTransitGatewayMulticastGroupMembers(request))

        def deregisterTransitGatewayMulticastGroupSources(
          request: DeregisterTransitGatewayMulticastGroupSourcesRequest
        ): Kleisli[M, Ec2Client, DeregisterTransitGatewayMulticastGroupSourcesResponse] =
          primitive(_.deregisterTransitGatewayMulticastGroupSources(request))

        def describeAccountAttributes(
          request: DescribeAccountAttributesRequest
        ): Kleisli[M, Ec2Client, DescribeAccountAttributesResponse] =
          primitive(_.describeAccountAttributes(request))

        def describeAddresses(
          request: DescribeAddressesRequest
        ): Kleisli[M, Ec2Client, DescribeAddressesResponse] =
          primitive(_.describeAddresses(request))

        def describeAddressesAttribute(
          request: DescribeAddressesAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeAddressesAttributeResponse] =
          primitive(_.describeAddressesAttribute(request))

        def describeAggregateIdFormat(
          request: DescribeAggregateIdFormatRequest
        ): Kleisli[M, Ec2Client, DescribeAggregateIdFormatResponse] =
          primitive(_.describeAggregateIdFormat(request))

        def describeAvailabilityZones(
          request: DescribeAvailabilityZonesRequest
        ): Kleisli[M, Ec2Client, DescribeAvailabilityZonesResponse] =
          primitive(_.describeAvailabilityZones(request))

        def describeBundleTasks(
          request: DescribeBundleTasksRequest
        ): Kleisli[M, Ec2Client, DescribeBundleTasksResponse] =
          primitive(_.describeBundleTasks(request))

        def describeByoipCidrs(
          request: DescribeByoipCidrsRequest
        ): Kleisli[M, Ec2Client, DescribeByoipCidrsResponse] =
          primitive(_.describeByoipCidrs(request))

        def describeCapacityReservations(
          request: DescribeCapacityReservationsRequest
        ): Kleisli[M, Ec2Client, DescribeCapacityReservationsResponse] =
          primitive(_.describeCapacityReservations(request))

        def describeCarrierGateways(
          request: DescribeCarrierGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeCarrierGatewaysResponse] =
          primitive(_.describeCarrierGateways(request))

        def describeClassicLinkInstances(
          request: DescribeClassicLinkInstancesRequest
        ): Kleisli[M, Ec2Client, DescribeClassicLinkInstancesResponse] =
          primitive(_.describeClassicLinkInstances(request))

        def describeClientVpnAuthorizationRules(
          request: DescribeClientVpnAuthorizationRulesRequest
        ): Kleisli[M, Ec2Client, DescribeClientVpnAuthorizationRulesResponse] =
          primitive(_.describeClientVpnAuthorizationRules(request))

        def describeClientVpnConnections(
          request: DescribeClientVpnConnectionsRequest
        ): Kleisli[M, Ec2Client, DescribeClientVpnConnectionsResponse] =
          primitive(_.describeClientVpnConnections(request))

        def describeClientVpnEndpoints(
          request: DescribeClientVpnEndpointsRequest
        ): Kleisli[M, Ec2Client, DescribeClientVpnEndpointsResponse] =
          primitive(_.describeClientVpnEndpoints(request))

        def describeClientVpnRoutes(
          request: DescribeClientVpnRoutesRequest
        ): Kleisli[M, Ec2Client, DescribeClientVpnRoutesResponse] =
          primitive(_.describeClientVpnRoutes(request))

        def describeClientVpnTargetNetworks(
          request: DescribeClientVpnTargetNetworksRequest
        ): Kleisli[M, Ec2Client, DescribeClientVpnTargetNetworksResponse] =
          primitive(_.describeClientVpnTargetNetworks(request))

        def describeCoipPools(
          request: DescribeCoipPoolsRequest
        ): Kleisli[M, Ec2Client, DescribeCoipPoolsResponse] =
          primitive(_.describeCoipPools(request))

        def describeConversionTasks(
          request: DescribeConversionTasksRequest
        ): Kleisli[M, Ec2Client, DescribeConversionTasksResponse] =
          primitive(_.describeConversionTasks(request))

        def describeCustomerGateways(
          request: DescribeCustomerGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeCustomerGatewaysResponse] =
          primitive(_.describeCustomerGateways(request))

        def describeDhcpOptions(
          request: DescribeDhcpOptionsRequest
        ): Kleisli[M, Ec2Client, DescribeDhcpOptionsResponse] =
          primitive(_.describeDhcpOptions(request))

        def describeEgressOnlyInternetGateways(
          request: DescribeEgressOnlyInternetGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeEgressOnlyInternetGatewaysResponse] =
          primitive(_.describeEgressOnlyInternetGateways(request))

        def describeElasticGpus(
          request: DescribeElasticGpusRequest
        ): Kleisli[M, Ec2Client, DescribeElasticGpusResponse] =
          primitive(_.describeElasticGpus(request))

        def describeExportImageTasks(
          request: DescribeExportImageTasksRequest
        ): Kleisli[M, Ec2Client, DescribeExportImageTasksResponse] =
          primitive(_.describeExportImageTasks(request))

        def describeExportTasks(
          request: DescribeExportTasksRequest
        ): Kleisli[M, Ec2Client, DescribeExportTasksResponse] =
          primitive(_.describeExportTasks(request))

        def describeFastSnapshotRestores(
          request: DescribeFastSnapshotRestoresRequest
        ): Kleisli[M, Ec2Client, DescribeFastSnapshotRestoresResponse] =
          primitive(_.describeFastSnapshotRestores(request))

        def describeFleetHistory(
          request: DescribeFleetHistoryRequest
        ): Kleisli[M, Ec2Client, DescribeFleetHistoryResponse] =
          primitive(_.describeFleetHistory(request))

        def describeFleetInstances(
          request: DescribeFleetInstancesRequest
        ): Kleisli[M, Ec2Client, DescribeFleetInstancesResponse] =
          primitive(_.describeFleetInstances(request))

        def describeFleets(
          request: DescribeFleetsRequest
        ): Kleisli[M, Ec2Client, DescribeFleetsResponse] =
          primitive(_.describeFleets(request))

        def describeFlowLogs(
          request: DescribeFlowLogsRequest
        ): Kleisli[M, Ec2Client, DescribeFlowLogsResponse] =
          primitive(_.describeFlowLogs(request))

        def describeFpgaImageAttribute(
          request: DescribeFpgaImageAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeFpgaImageAttributeResponse] =
          primitive(_.describeFpgaImageAttribute(request))

        def describeFpgaImages(
          request: DescribeFpgaImagesRequest
        ): Kleisli[M, Ec2Client, DescribeFpgaImagesResponse] =
          primitive(_.describeFpgaImages(request))

        def describeHostReservationOfferings(
          request: DescribeHostReservationOfferingsRequest
        ): Kleisli[M, Ec2Client, DescribeHostReservationOfferingsResponse] =
          primitive(_.describeHostReservationOfferings(request))

        def describeHostReservations(
          request: DescribeHostReservationsRequest
        ): Kleisli[M, Ec2Client, DescribeHostReservationsResponse] =
          primitive(_.describeHostReservations(request))

        def describeHosts(
          request: DescribeHostsRequest
        ): Kleisli[M, Ec2Client, DescribeHostsResponse] =
          primitive(_.describeHosts(request))

        def describeIamInstanceProfileAssociations(
          request: DescribeIamInstanceProfileAssociationsRequest
        ): Kleisli[M, Ec2Client, DescribeIamInstanceProfileAssociationsResponse] =
          primitive(_.describeIamInstanceProfileAssociations(request))

        def describeIdFormat(
          request: DescribeIdFormatRequest
        ): Kleisli[M, Ec2Client, DescribeIdFormatResponse] =
          primitive(_.describeIdFormat(request))

        def describeIdentityIdFormat(
          request: DescribeIdentityIdFormatRequest
        ): Kleisli[M, Ec2Client, DescribeIdentityIdFormatResponse] =
          primitive(_.describeIdentityIdFormat(request))

        def describeImageAttribute(
          request: DescribeImageAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeImageAttributeResponse] =
          primitive(_.describeImageAttribute(request))

        def describeImages(
          request: DescribeImagesRequest
        ): Kleisli[M, Ec2Client, DescribeImagesResponse] =
          primitive(_.describeImages(request))

        def describeImportImageTasks(
          request: DescribeImportImageTasksRequest
        ): Kleisli[M, Ec2Client, DescribeImportImageTasksResponse] =
          primitive(_.describeImportImageTasks(request))

        def describeImportSnapshotTasks(
          request: DescribeImportSnapshotTasksRequest
        ): Kleisli[M, Ec2Client, DescribeImportSnapshotTasksResponse] =
          primitive(_.describeImportSnapshotTasks(request))

        def describeInstanceAttribute(
          request: DescribeInstanceAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeInstanceAttributeResponse] =
          primitive(_.describeInstanceAttribute(request))

        def describeInstanceCreditSpecifications(
          request: DescribeInstanceCreditSpecificationsRequest
        ): Kleisli[M, Ec2Client, DescribeInstanceCreditSpecificationsResponse] =
          primitive(_.describeInstanceCreditSpecifications(request))

        def describeInstanceEventNotificationAttributes(
          request: DescribeInstanceEventNotificationAttributesRequest
        ): Kleisli[M, Ec2Client, DescribeInstanceEventNotificationAttributesResponse] =
          primitive(_.describeInstanceEventNotificationAttributes(request))

        def describeInstanceStatus(
          request: DescribeInstanceStatusRequest
        ): Kleisli[M, Ec2Client, DescribeInstanceStatusResponse] =
          primitive(_.describeInstanceStatus(request))

        def describeInstanceTypeOfferings(
          request: DescribeInstanceTypeOfferingsRequest
        ): Kleisli[M, Ec2Client, DescribeInstanceTypeOfferingsResponse] =
          primitive(_.describeInstanceTypeOfferings(request))

        def describeInstanceTypes(
          request: DescribeInstanceTypesRequest
        ): Kleisli[M, Ec2Client, DescribeInstanceTypesResponse] =
          primitive(_.describeInstanceTypes(request))

        def describeInstances(
          request: DescribeInstancesRequest
        ): Kleisli[M, Ec2Client, DescribeInstancesResponse] =
          primitive(_.describeInstances(request))

        def describeInternetGateways(
          request: DescribeInternetGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeInternetGatewaysResponse] =
          primitive(_.describeInternetGateways(request))

        def describeIpv6Pools(
          request: DescribeIpv6PoolsRequest
        ): Kleisli[M, Ec2Client, DescribeIpv6PoolsResponse] =
          primitive(_.describeIpv6Pools(request))

        def describeKeyPairs(
          request: DescribeKeyPairsRequest
        ): Kleisli[M, Ec2Client, DescribeKeyPairsResponse] =
          primitive(_.describeKeyPairs(request))

        def describeLaunchTemplateVersions(
          request: DescribeLaunchTemplateVersionsRequest
        ): Kleisli[M, Ec2Client, DescribeLaunchTemplateVersionsResponse] =
          primitive(_.describeLaunchTemplateVersions(request))

        def describeLaunchTemplates(
          request: DescribeLaunchTemplatesRequest
        ): Kleisli[M, Ec2Client, DescribeLaunchTemplatesResponse] =
          primitive(_.describeLaunchTemplates(request))

        def describeLocalGatewayRouteTableVirtualInterfaceGroupAssociations(
          request: DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsRequest
        ): Kleisli[M, Ec2Client, DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsResponse] =
          primitive(_.describeLocalGatewayRouteTableVirtualInterfaceGroupAssociations(request))

        def describeLocalGatewayRouteTableVpcAssociations(
          request: DescribeLocalGatewayRouteTableVpcAssociationsRequest
        ): Kleisli[M, Ec2Client, DescribeLocalGatewayRouteTableVpcAssociationsResponse] =
          primitive(_.describeLocalGatewayRouteTableVpcAssociations(request))

        def describeLocalGatewayRouteTables(
          request: DescribeLocalGatewayRouteTablesRequest
        ): Kleisli[M, Ec2Client, DescribeLocalGatewayRouteTablesResponse] =
          primitive(_.describeLocalGatewayRouteTables(request))

        def describeLocalGatewayVirtualInterfaceGroups(
          request: DescribeLocalGatewayVirtualInterfaceGroupsRequest
        ): Kleisli[M, Ec2Client, DescribeLocalGatewayVirtualInterfaceGroupsResponse] =
          primitive(_.describeLocalGatewayVirtualInterfaceGroups(request))

        def describeLocalGatewayVirtualInterfaces(
          request: DescribeLocalGatewayVirtualInterfacesRequest
        ): Kleisli[M, Ec2Client, DescribeLocalGatewayVirtualInterfacesResponse] =
          primitive(_.describeLocalGatewayVirtualInterfaces(request))

        def describeLocalGateways(
          request: DescribeLocalGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeLocalGatewaysResponse] =
          primitive(_.describeLocalGateways(request))

        def describeManagedPrefixLists(
          request: DescribeManagedPrefixListsRequest
        ): Kleisli[M, Ec2Client, DescribeManagedPrefixListsResponse] =
          primitive(_.describeManagedPrefixLists(request))

        def describeMovingAddresses(
          request: DescribeMovingAddressesRequest
        ): Kleisli[M, Ec2Client, DescribeMovingAddressesResponse] =
          primitive(_.describeMovingAddresses(request))

        def describeNatGateways(
          request: DescribeNatGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeNatGatewaysResponse] =
          primitive(_.describeNatGateways(request))

        def describeNetworkAcls(
          request: DescribeNetworkAclsRequest
        ): Kleisli[M, Ec2Client, DescribeNetworkAclsResponse] =
          primitive(_.describeNetworkAcls(request))

        def describeNetworkInsightsAnalyses(
          request: DescribeNetworkInsightsAnalysesRequest
        ): Kleisli[M, Ec2Client, DescribeNetworkInsightsAnalysesResponse] =
          primitive(_.describeNetworkInsightsAnalyses(request))

        def describeNetworkInsightsPaths(
          request: DescribeNetworkInsightsPathsRequest
        ): Kleisli[M, Ec2Client, DescribeNetworkInsightsPathsResponse] =
          primitive(_.describeNetworkInsightsPaths(request))

        def describeNetworkInterfaceAttribute(
          request: DescribeNetworkInterfaceAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeNetworkInterfaceAttributeResponse] =
          primitive(_.describeNetworkInterfaceAttribute(request))

        def describeNetworkInterfacePermissions(
          request: DescribeNetworkInterfacePermissionsRequest
        ): Kleisli[M, Ec2Client, DescribeNetworkInterfacePermissionsResponse] =
          primitive(_.describeNetworkInterfacePermissions(request))

        def describeNetworkInterfaces(
          request: DescribeNetworkInterfacesRequest
        ): Kleisli[M, Ec2Client, DescribeNetworkInterfacesResponse] =
          primitive(_.describeNetworkInterfaces(request))

        def describePlacementGroups(
          request: DescribePlacementGroupsRequest
        ): Kleisli[M, Ec2Client, DescribePlacementGroupsResponse] =
          primitive(_.describePlacementGroups(request))

        def describePrefixLists(
          request: DescribePrefixListsRequest
        ): Kleisli[M, Ec2Client, DescribePrefixListsResponse] =
          primitive(_.describePrefixLists(request))

        def describePrincipalIdFormat(
          request: DescribePrincipalIdFormatRequest
        ): Kleisli[M, Ec2Client, DescribePrincipalIdFormatResponse] =
          primitive(_.describePrincipalIdFormat(request))

        def describePublicIpv4Pools(
          request: DescribePublicIpv4PoolsRequest
        ): Kleisli[M, Ec2Client, DescribePublicIpv4PoolsResponse] =
          primitive(_.describePublicIpv4Pools(request))

        def describeRegions(
          request: DescribeRegionsRequest
        ): Kleisli[M, Ec2Client, DescribeRegionsResponse] =
          primitive(_.describeRegions(request))

        def describeReplaceRootVolumeTasks(
          request: DescribeReplaceRootVolumeTasksRequest
        ): Kleisli[M, Ec2Client, DescribeReplaceRootVolumeTasksResponse] =
          primitive(_.describeReplaceRootVolumeTasks(request))

        def describeReservedInstances(
          request: DescribeReservedInstancesRequest
        ): Kleisli[M, Ec2Client, DescribeReservedInstancesResponse] =
          primitive(_.describeReservedInstances(request))

        def describeReservedInstancesListings(
          request: DescribeReservedInstancesListingsRequest
        ): Kleisli[M, Ec2Client, DescribeReservedInstancesListingsResponse] =
          primitive(_.describeReservedInstancesListings(request))

        def describeReservedInstancesModifications(
          request: DescribeReservedInstancesModificationsRequest
        ): Kleisli[M, Ec2Client, DescribeReservedInstancesModificationsResponse] =
          primitive(_.describeReservedInstancesModifications(request))

        def describeReservedInstancesOfferings(
          request: DescribeReservedInstancesOfferingsRequest
        ): Kleisli[M, Ec2Client, DescribeReservedInstancesOfferingsResponse] =
          primitive(_.describeReservedInstancesOfferings(request))

        def describeRouteTables(
          request: DescribeRouteTablesRequest
        ): Kleisli[M, Ec2Client, DescribeRouteTablesResponse] =
          primitive(_.describeRouteTables(request))

        def describeScheduledInstanceAvailability(
          request: DescribeScheduledInstanceAvailabilityRequest
        ): Kleisli[M, Ec2Client, DescribeScheduledInstanceAvailabilityResponse] =
          primitive(_.describeScheduledInstanceAvailability(request))

        def describeScheduledInstances(
          request: DescribeScheduledInstancesRequest
        ): Kleisli[M, Ec2Client, DescribeScheduledInstancesResponse] =
          primitive(_.describeScheduledInstances(request))

        def describeSecurityGroupReferences(
          request: DescribeSecurityGroupReferencesRequest
        ): Kleisli[M, Ec2Client, DescribeSecurityGroupReferencesResponse] =
          primitive(_.describeSecurityGroupReferences(request))

        def describeSecurityGroups(
          request: DescribeSecurityGroupsRequest
        ): Kleisli[M, Ec2Client, DescribeSecurityGroupsResponse] =
          primitive(_.describeSecurityGroups(request))

        def describeSnapshotAttribute(
          request: DescribeSnapshotAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeSnapshotAttributeResponse] =
          primitive(_.describeSnapshotAttribute(request))

        def describeSnapshots(
          request: DescribeSnapshotsRequest
        ): Kleisli[M, Ec2Client, DescribeSnapshotsResponse] =
          primitive(_.describeSnapshots(request))

        def describeSpotDatafeedSubscription(
          request: DescribeSpotDatafeedSubscriptionRequest
        ): Kleisli[M, Ec2Client, DescribeSpotDatafeedSubscriptionResponse] =
          primitive(_.describeSpotDatafeedSubscription(request))

        def describeSpotFleetInstances(
          request: DescribeSpotFleetInstancesRequest
        ): Kleisli[M, Ec2Client, DescribeSpotFleetInstancesResponse] =
          primitive(_.describeSpotFleetInstances(request))

        def describeSpotFleetRequestHistory(
          request: DescribeSpotFleetRequestHistoryRequest
        ): Kleisli[M, Ec2Client, DescribeSpotFleetRequestHistoryResponse] =
          primitive(_.describeSpotFleetRequestHistory(request))

        def describeSpotFleetRequests(
          request: DescribeSpotFleetRequestsRequest
        ): Kleisli[M, Ec2Client, DescribeSpotFleetRequestsResponse] =
          primitive(_.describeSpotFleetRequests(request))

        def describeSpotInstanceRequests(
          request: DescribeSpotInstanceRequestsRequest
        ): Kleisli[M, Ec2Client, DescribeSpotInstanceRequestsResponse] =
          primitive(_.describeSpotInstanceRequests(request))

        def describeSpotPriceHistory(
          request: DescribeSpotPriceHistoryRequest
        ): Kleisli[M, Ec2Client, DescribeSpotPriceHistoryResponse] =
          primitive(_.describeSpotPriceHistory(request))

        def describeStaleSecurityGroups(
          request: DescribeStaleSecurityGroupsRequest
        ): Kleisli[M, Ec2Client, DescribeStaleSecurityGroupsResponse] =
          primitive(_.describeStaleSecurityGroups(request))

        def describeStoreImageTasks(
          request: DescribeStoreImageTasksRequest
        ): Kleisli[M, Ec2Client, DescribeStoreImageTasksResponse] =
          primitive(_.describeStoreImageTasks(request))

        def describeSubnets(
          request: DescribeSubnetsRequest
        ): Kleisli[M, Ec2Client, DescribeSubnetsResponse] =
          primitive(_.describeSubnets(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, Ec2Client, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def describeTrafficMirrorFilters(
          request: DescribeTrafficMirrorFiltersRequest
        ): Kleisli[M, Ec2Client, DescribeTrafficMirrorFiltersResponse] =
          primitive(_.describeTrafficMirrorFilters(request))

        def describeTrafficMirrorSessions(
          request: DescribeTrafficMirrorSessionsRequest
        ): Kleisli[M, Ec2Client, DescribeTrafficMirrorSessionsResponse] =
          primitive(_.describeTrafficMirrorSessions(request))

        def describeTrafficMirrorTargets(
          request: DescribeTrafficMirrorTargetsRequest
        ): Kleisli[M, Ec2Client, DescribeTrafficMirrorTargetsResponse] =
          primitive(_.describeTrafficMirrorTargets(request))

        def describeTransitGatewayAttachments(
          request: DescribeTransitGatewayAttachmentsRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewayAttachmentsResponse] =
          primitive(_.describeTransitGatewayAttachments(request))

        def describeTransitGatewayConnectPeers(
          request: DescribeTransitGatewayConnectPeersRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewayConnectPeersResponse] =
          primitive(_.describeTransitGatewayConnectPeers(request))

        def describeTransitGatewayConnects(
          request: DescribeTransitGatewayConnectsRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewayConnectsResponse] =
          primitive(_.describeTransitGatewayConnects(request))

        def describeTransitGatewayMulticastDomains(
          request: DescribeTransitGatewayMulticastDomainsRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewayMulticastDomainsResponse] =
          primitive(_.describeTransitGatewayMulticastDomains(request))

        def describeTransitGatewayPeeringAttachments(
          request: DescribeTransitGatewayPeeringAttachmentsRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewayPeeringAttachmentsResponse] =
          primitive(_.describeTransitGatewayPeeringAttachments(request))

        def describeTransitGatewayRouteTables(
          request: DescribeTransitGatewayRouteTablesRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewayRouteTablesResponse] =
          primitive(_.describeTransitGatewayRouteTables(request))

        def describeTransitGatewayVpcAttachments(
          request: DescribeTransitGatewayVpcAttachmentsRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewayVpcAttachmentsResponse] =
          primitive(_.describeTransitGatewayVpcAttachments(request))

        def describeTransitGateways(
          request: DescribeTransitGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeTransitGatewaysResponse] =
          primitive(_.describeTransitGateways(request))

        def describeVolumeAttribute(
          request: DescribeVolumeAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeVolumeAttributeResponse] =
          primitive(_.describeVolumeAttribute(request))

        def describeVolumeStatus(
          request: DescribeVolumeStatusRequest
        ): Kleisli[M, Ec2Client, DescribeVolumeStatusResponse] =
          primitive(_.describeVolumeStatus(request))

        def describeVolumes(
          request: DescribeVolumesRequest
        ): Kleisli[M, Ec2Client, DescribeVolumesResponse] =
          primitive(_.describeVolumes(request))

        def describeVolumesModifications(
          request: DescribeVolumesModificationsRequest
        ): Kleisli[M, Ec2Client, DescribeVolumesModificationsResponse] =
          primitive(_.describeVolumesModifications(request))

        def describeVpcAttribute(
          request: DescribeVpcAttributeRequest
        ): Kleisli[M, Ec2Client, DescribeVpcAttributeResponse] =
          primitive(_.describeVpcAttribute(request))

        def describeVpcClassicLink(
          request: DescribeVpcClassicLinkRequest
        ): Kleisli[M, Ec2Client, DescribeVpcClassicLinkResponse] =
          primitive(_.describeVpcClassicLink(request))

        def describeVpcClassicLinkDnsSupport(
          request: DescribeVpcClassicLinkDnsSupportRequest
        ): Kleisli[M, Ec2Client, DescribeVpcClassicLinkDnsSupportResponse] =
          primitive(_.describeVpcClassicLinkDnsSupport(request))

        def describeVpcEndpointConnectionNotifications(
          request: DescribeVpcEndpointConnectionNotificationsRequest
        ): Kleisli[M, Ec2Client, DescribeVpcEndpointConnectionNotificationsResponse] =
          primitive(_.describeVpcEndpointConnectionNotifications(request))

        def describeVpcEndpointConnections(
          request: DescribeVpcEndpointConnectionsRequest
        ): Kleisli[M, Ec2Client, DescribeVpcEndpointConnectionsResponse] =
          primitive(_.describeVpcEndpointConnections(request))

        def describeVpcEndpointServiceConfigurations(
          request: DescribeVpcEndpointServiceConfigurationsRequest
        ): Kleisli[M, Ec2Client, DescribeVpcEndpointServiceConfigurationsResponse] =
          primitive(_.describeVpcEndpointServiceConfigurations(request))

        def describeVpcEndpointServicePermissions(
          request: DescribeVpcEndpointServicePermissionsRequest
        ): Kleisli[M, Ec2Client, DescribeVpcEndpointServicePermissionsResponse] =
          primitive(_.describeVpcEndpointServicePermissions(request))

        def describeVpcEndpointServices(
          request: DescribeVpcEndpointServicesRequest
        ): Kleisli[M, Ec2Client, DescribeVpcEndpointServicesResponse] =
          primitive(_.describeVpcEndpointServices(request))

        def describeVpcEndpoints(
          request: DescribeVpcEndpointsRequest
        ): Kleisli[M, Ec2Client, DescribeVpcEndpointsResponse] =
          primitive(_.describeVpcEndpoints(request))

        def describeVpcPeeringConnections(
          request: DescribeVpcPeeringConnectionsRequest
        ): Kleisli[M, Ec2Client, DescribeVpcPeeringConnectionsResponse] =
          primitive(_.describeVpcPeeringConnections(request))

        def describeVpcs(
          request: DescribeVpcsRequest
        ): Kleisli[M, Ec2Client, DescribeVpcsResponse] =
          primitive(_.describeVpcs(request))

        def describeVpnConnections(
          request: DescribeVpnConnectionsRequest
        ): Kleisli[M, Ec2Client, DescribeVpnConnectionsResponse] =
          primitive(_.describeVpnConnections(request))

        def describeVpnGateways(
          request: DescribeVpnGatewaysRequest
        ): Kleisli[M, Ec2Client, DescribeVpnGatewaysResponse] =
          primitive(_.describeVpnGateways(request))

        def detachClassicLinkVpc(
          request: DetachClassicLinkVpcRequest
        ): Kleisli[M, Ec2Client, DetachClassicLinkVpcResponse] =
          primitive(_.detachClassicLinkVpc(request))

        def detachInternetGateway(
          request: DetachInternetGatewayRequest
        ): Kleisli[M, Ec2Client, DetachInternetGatewayResponse] =
          primitive(_.detachInternetGateway(request))

        def detachNetworkInterface(
          request: DetachNetworkInterfaceRequest
        ): Kleisli[M, Ec2Client, DetachNetworkInterfaceResponse] =
          primitive(_.detachNetworkInterface(request))

        def detachVolume(
          request: DetachVolumeRequest
        ): Kleisli[M, Ec2Client, DetachVolumeResponse] =
          primitive(_.detachVolume(request))

        def detachVpnGateway(
          request: DetachVpnGatewayRequest
        ): Kleisli[M, Ec2Client, DetachVpnGatewayResponse] =
          primitive(_.detachVpnGateway(request))

        def disableEbsEncryptionByDefault(
          request: DisableEbsEncryptionByDefaultRequest
        ): Kleisli[M, Ec2Client, DisableEbsEncryptionByDefaultResponse] =
          primitive(_.disableEbsEncryptionByDefault(request))

        def disableFastSnapshotRestores(
          request: DisableFastSnapshotRestoresRequest
        ): Kleisli[M, Ec2Client, DisableFastSnapshotRestoresResponse] =
          primitive(_.disableFastSnapshotRestores(request))

        def disableImageDeprecation(
          request: DisableImageDeprecationRequest
        ): Kleisli[M, Ec2Client, DisableImageDeprecationResponse] =
          primitive(_.disableImageDeprecation(request))

        def disableSerialConsoleAccess(
          request: DisableSerialConsoleAccessRequest
        ): Kleisli[M, Ec2Client, DisableSerialConsoleAccessResponse] =
          primitive(_.disableSerialConsoleAccess(request))

        def disableTransitGatewayRouteTablePropagation(
          request: DisableTransitGatewayRouteTablePropagationRequest
        ): Kleisli[M, Ec2Client, DisableTransitGatewayRouteTablePropagationResponse] =
          primitive(_.disableTransitGatewayRouteTablePropagation(request))

        def disableVgwRoutePropagation(
          request: DisableVgwRoutePropagationRequest
        ): Kleisli[M, Ec2Client, DisableVgwRoutePropagationResponse] =
          primitive(_.disableVgwRoutePropagation(request))

        def disableVpcClassicLink(
          request: DisableVpcClassicLinkRequest
        ): Kleisli[M, Ec2Client, DisableVpcClassicLinkResponse] =
          primitive(_.disableVpcClassicLink(request))

        def disableVpcClassicLinkDnsSupport(
          request: DisableVpcClassicLinkDnsSupportRequest
        ): Kleisli[M, Ec2Client, DisableVpcClassicLinkDnsSupportResponse] =
          primitive(_.disableVpcClassicLinkDnsSupport(request))

        def disassociateAddress(
          request: DisassociateAddressRequest
        ): Kleisli[M, Ec2Client, DisassociateAddressResponse] =
          primitive(_.disassociateAddress(request))

        def disassociateClientVpnTargetNetwork(
          request: DisassociateClientVpnTargetNetworkRequest
        ): Kleisli[M, Ec2Client, DisassociateClientVpnTargetNetworkResponse] =
          primitive(_.disassociateClientVpnTargetNetwork(request))

        def disassociateEnclaveCertificateIamRole(
          request: DisassociateEnclaveCertificateIamRoleRequest
        ): Kleisli[M, Ec2Client, DisassociateEnclaveCertificateIamRoleResponse] =
          primitive(_.disassociateEnclaveCertificateIamRole(request))

        def disassociateIamInstanceProfile(
          request: DisassociateIamInstanceProfileRequest
        ): Kleisli[M, Ec2Client, DisassociateIamInstanceProfileResponse] =
          primitive(_.disassociateIamInstanceProfile(request))

        def disassociateRouteTable(
          request: DisassociateRouteTableRequest
        ): Kleisli[M, Ec2Client, DisassociateRouteTableResponse] =
          primitive(_.disassociateRouteTable(request))

        def disassociateSubnetCidrBlock(
          request: DisassociateSubnetCidrBlockRequest
        ): Kleisli[M, Ec2Client, DisassociateSubnetCidrBlockResponse] =
          primitive(_.disassociateSubnetCidrBlock(request))

        def disassociateTransitGatewayMulticastDomain(
          request: DisassociateTransitGatewayMulticastDomainRequest
        ): Kleisli[M, Ec2Client, DisassociateTransitGatewayMulticastDomainResponse] =
          primitive(_.disassociateTransitGatewayMulticastDomain(request))

        def disassociateTransitGatewayRouteTable(
          request: DisassociateTransitGatewayRouteTableRequest
        ): Kleisli[M, Ec2Client, DisassociateTransitGatewayRouteTableResponse] =
          primitive(_.disassociateTransitGatewayRouteTable(request))

        def disassociateVpcCidrBlock(
          request: DisassociateVpcCidrBlockRequest
        ): Kleisli[M, Ec2Client, DisassociateVpcCidrBlockResponse] =
          primitive(_.disassociateVpcCidrBlock(request))

        def enableEbsEncryptionByDefault(
          request: EnableEbsEncryptionByDefaultRequest
        ): Kleisli[M, Ec2Client, EnableEbsEncryptionByDefaultResponse] =
          primitive(_.enableEbsEncryptionByDefault(request))

        def enableFastSnapshotRestores(
          request: EnableFastSnapshotRestoresRequest
        ): Kleisli[M, Ec2Client, EnableFastSnapshotRestoresResponse] =
          primitive(_.enableFastSnapshotRestores(request))

        def enableImageDeprecation(
          request: EnableImageDeprecationRequest
        ): Kleisli[M, Ec2Client, EnableImageDeprecationResponse] =
          primitive(_.enableImageDeprecation(request))

        def enableSerialConsoleAccess(
          request: EnableSerialConsoleAccessRequest
        ): Kleisli[M, Ec2Client, EnableSerialConsoleAccessResponse] =
          primitive(_.enableSerialConsoleAccess(request))

        def enableTransitGatewayRouteTablePropagation(
          request: EnableTransitGatewayRouteTablePropagationRequest
        ): Kleisli[M, Ec2Client, EnableTransitGatewayRouteTablePropagationResponse] =
          primitive(_.enableTransitGatewayRouteTablePropagation(request))

        def enableVgwRoutePropagation(
          request: EnableVgwRoutePropagationRequest
        ): Kleisli[M, Ec2Client, EnableVgwRoutePropagationResponse] =
          primitive(_.enableVgwRoutePropagation(request))

        def enableVolumeIO(
          request: EnableVolumeIoRequest
        ): Kleisli[M, Ec2Client, EnableVolumeIoResponse] =
          primitive(_.enableVolumeIO(request))

        def enableVpcClassicLink(
          request: EnableVpcClassicLinkRequest
        ): Kleisli[M, Ec2Client, EnableVpcClassicLinkResponse] =
          primitive(_.enableVpcClassicLink(request))

        def enableVpcClassicLinkDnsSupport(
          request: EnableVpcClassicLinkDnsSupportRequest
        ): Kleisli[M, Ec2Client, EnableVpcClassicLinkDnsSupportResponse] =
          primitive(_.enableVpcClassicLinkDnsSupport(request))

        def exportClientVpnClientCertificateRevocationList(
          request: ExportClientVpnClientCertificateRevocationListRequest
        ): Kleisli[M, Ec2Client, ExportClientVpnClientCertificateRevocationListResponse] =
          primitive(_.exportClientVpnClientCertificateRevocationList(request))

        def exportClientVpnClientConfiguration(
          request: ExportClientVpnClientConfigurationRequest
        ): Kleisli[M, Ec2Client, ExportClientVpnClientConfigurationResponse] =
          primitive(_.exportClientVpnClientConfiguration(request))

        def exportImage(
          request: ExportImageRequest
        ): Kleisli[M, Ec2Client, ExportImageResponse] =
          primitive(_.exportImage(request))

        def exportTransitGatewayRoutes(
          request: ExportTransitGatewayRoutesRequest
        ): Kleisli[M, Ec2Client, ExportTransitGatewayRoutesResponse] =
          primitive(_.exportTransitGatewayRoutes(request))

        def getAssociatedEnclaveCertificateIamRoles(
          request: GetAssociatedEnclaveCertificateIamRolesRequest
        ): Kleisli[M, Ec2Client, GetAssociatedEnclaveCertificateIamRolesResponse] =
          primitive(_.getAssociatedEnclaveCertificateIamRoles(request))

        def getAssociatedIpv6PoolCidrs(
          request: GetAssociatedIpv6PoolCidrsRequest
        ): Kleisli[M, Ec2Client, GetAssociatedIpv6PoolCidrsResponse] =
          primitive(_.getAssociatedIpv6PoolCidrs(request))

        def getCapacityReservationUsage(
          request: GetCapacityReservationUsageRequest
        ): Kleisli[M, Ec2Client, GetCapacityReservationUsageResponse] =
          primitive(_.getCapacityReservationUsage(request))

        def getCoipPoolUsage(
          request: GetCoipPoolUsageRequest
        ): Kleisli[M, Ec2Client, GetCoipPoolUsageResponse] =
          primitive(_.getCoipPoolUsage(request))

        def getConsoleOutput(
          request: GetConsoleOutputRequest
        ): Kleisli[M, Ec2Client, GetConsoleOutputResponse] =
          primitive(_.getConsoleOutput(request))

        def getConsoleScreenshot(
          request: GetConsoleScreenshotRequest
        ): Kleisli[M, Ec2Client, GetConsoleScreenshotResponse] =
          primitive(_.getConsoleScreenshot(request))

        def getDefaultCreditSpecification(
          request: GetDefaultCreditSpecificationRequest
        ): Kleisli[M, Ec2Client, GetDefaultCreditSpecificationResponse] =
          primitive(_.getDefaultCreditSpecification(request))

        def getEbsDefaultKmsKeyId(
          request: GetEbsDefaultKmsKeyIdRequest
        ): Kleisli[M, Ec2Client, GetEbsDefaultKmsKeyIdResponse] =
          primitive(_.getEbsDefaultKmsKeyId(request))

        def getEbsEncryptionByDefault(
          request: GetEbsEncryptionByDefaultRequest
        ): Kleisli[M, Ec2Client, GetEbsEncryptionByDefaultResponse] =
          primitive(_.getEbsEncryptionByDefault(request))

        def getFlowLogsIntegrationTemplate(
          request: GetFlowLogsIntegrationTemplateRequest
        ): Kleisli[M, Ec2Client, GetFlowLogsIntegrationTemplateResponse] =
          primitive(_.getFlowLogsIntegrationTemplate(request))

        def getGroupsForCapacityReservation(
          request: GetGroupsForCapacityReservationRequest
        ): Kleisli[M, Ec2Client, GetGroupsForCapacityReservationResponse] =
          primitive(_.getGroupsForCapacityReservation(request))

        def getHostReservationPurchasePreview(
          request: GetHostReservationPurchasePreviewRequest
        ): Kleisli[M, Ec2Client, GetHostReservationPurchasePreviewResponse] =
          primitive(_.getHostReservationPurchasePreview(request))

        def getLaunchTemplateData(
          request: GetLaunchTemplateDataRequest
        ): Kleisli[M, Ec2Client, GetLaunchTemplateDataResponse] =
          primitive(_.getLaunchTemplateData(request))

        def getManagedPrefixListAssociations(
          request: GetManagedPrefixListAssociationsRequest
        ): Kleisli[M, Ec2Client, GetManagedPrefixListAssociationsResponse] =
          primitive(_.getManagedPrefixListAssociations(request))

        def getManagedPrefixListEntries(
          request: GetManagedPrefixListEntriesRequest
        ): Kleisli[M, Ec2Client, GetManagedPrefixListEntriesResponse] =
          primitive(_.getManagedPrefixListEntries(request))

        def getPasswordData(
          request: GetPasswordDataRequest
        ): Kleisli[M, Ec2Client, GetPasswordDataResponse] =
          primitive(_.getPasswordData(request))

        def getReservedInstancesExchangeQuote(
          request: GetReservedInstancesExchangeQuoteRequest
        ): Kleisli[M, Ec2Client, GetReservedInstancesExchangeQuoteResponse] =
          primitive(_.getReservedInstancesExchangeQuote(request))

        def getSerialConsoleAccessStatus(
          request: GetSerialConsoleAccessStatusRequest
        ): Kleisli[M, Ec2Client, GetSerialConsoleAccessStatusResponse] =
          primitive(_.getSerialConsoleAccessStatus(request))

        def getTransitGatewayAttachmentPropagations(
          request: GetTransitGatewayAttachmentPropagationsRequest
        ): Kleisli[M, Ec2Client, GetTransitGatewayAttachmentPropagationsResponse] =
          primitive(_.getTransitGatewayAttachmentPropagations(request))

        def getTransitGatewayMulticastDomainAssociations(
          request: GetTransitGatewayMulticastDomainAssociationsRequest
        ): Kleisli[M, Ec2Client, GetTransitGatewayMulticastDomainAssociationsResponse] =
          primitive(_.getTransitGatewayMulticastDomainAssociations(request))

        def getTransitGatewayPrefixListReferences(
          request: GetTransitGatewayPrefixListReferencesRequest
        ): Kleisli[M, Ec2Client, GetTransitGatewayPrefixListReferencesResponse] =
          primitive(_.getTransitGatewayPrefixListReferences(request))

        def getTransitGatewayRouteTableAssociations(
          request: GetTransitGatewayRouteTableAssociationsRequest
        ): Kleisli[M, Ec2Client, GetTransitGatewayRouteTableAssociationsResponse] =
          primitive(_.getTransitGatewayRouteTableAssociations(request))

        def getTransitGatewayRouteTablePropagations(
          request: GetTransitGatewayRouteTablePropagationsRequest
        ): Kleisli[M, Ec2Client, GetTransitGatewayRouteTablePropagationsResponse] =
          primitive(_.getTransitGatewayRouteTablePropagations(request))

        def importClientVpnClientCertificateRevocationList(
          request: ImportClientVpnClientCertificateRevocationListRequest
        ): Kleisli[M, Ec2Client, ImportClientVpnClientCertificateRevocationListResponse] =
          primitive(_.importClientVpnClientCertificateRevocationList(request))

        def importImage(
          request: ImportImageRequest
        ): Kleisli[M, Ec2Client, ImportImageResponse] =
          primitive(_.importImage(request))

        def importInstance(
          request: ImportInstanceRequest
        ): Kleisli[M, Ec2Client, ImportInstanceResponse] =
          primitive(_.importInstance(request))

        def importKeyPair(
          request: ImportKeyPairRequest
        ): Kleisli[M, Ec2Client, ImportKeyPairResponse] =
          primitive(_.importKeyPair(request))

        def importSnapshot(
          request: ImportSnapshotRequest
        ): Kleisli[M, Ec2Client, ImportSnapshotResponse] =
          primitive(_.importSnapshot(request))

        def importVolume(
          request: ImportVolumeRequest
        ): Kleisli[M, Ec2Client, ImportVolumeResponse] =
          primitive(_.importVolume(request))

        def modifyAddressAttribute(
          request: ModifyAddressAttributeRequest
        ): Kleisli[M, Ec2Client, ModifyAddressAttributeResponse] =
          primitive(_.modifyAddressAttribute(request))

        def modifyAvailabilityZoneGroup(
          request: ModifyAvailabilityZoneGroupRequest
        ): Kleisli[M, Ec2Client, ModifyAvailabilityZoneGroupResponse] =
          primitive(_.modifyAvailabilityZoneGroup(request))

        def modifyCapacityReservation(
          request: ModifyCapacityReservationRequest
        ): Kleisli[M, Ec2Client, ModifyCapacityReservationResponse] =
          primitive(_.modifyCapacityReservation(request))

        def modifyClientVpnEndpoint(
          request: ModifyClientVpnEndpointRequest
        ): Kleisli[M, Ec2Client, ModifyClientVpnEndpointResponse] =
          primitive(_.modifyClientVpnEndpoint(request))

        def modifyDefaultCreditSpecification(
          request: ModifyDefaultCreditSpecificationRequest
        ): Kleisli[M, Ec2Client, ModifyDefaultCreditSpecificationResponse] =
          primitive(_.modifyDefaultCreditSpecification(request))

        def modifyEbsDefaultKmsKeyId(
          request: ModifyEbsDefaultKmsKeyIdRequest
        ): Kleisli[M, Ec2Client, ModifyEbsDefaultKmsKeyIdResponse] =
          primitive(_.modifyEbsDefaultKmsKeyId(request))

        def modifyFleet(
          request: ModifyFleetRequest
        ): Kleisli[M, Ec2Client, ModifyFleetResponse] =
          primitive(_.modifyFleet(request))

        def modifyFpgaImageAttribute(
          request: ModifyFpgaImageAttributeRequest
        ): Kleisli[M, Ec2Client, ModifyFpgaImageAttributeResponse] =
          primitive(_.modifyFpgaImageAttribute(request))

        def modifyHosts(
          request: ModifyHostsRequest
        ): Kleisli[M, Ec2Client, ModifyHostsResponse] =
          primitive(_.modifyHosts(request))

        def modifyIdFormat(
          request: ModifyIdFormatRequest
        ): Kleisli[M, Ec2Client, ModifyIdFormatResponse] =
          primitive(_.modifyIdFormat(request))

        def modifyIdentityIdFormat(
          request: ModifyIdentityIdFormatRequest
        ): Kleisli[M, Ec2Client, ModifyIdentityIdFormatResponse] =
          primitive(_.modifyIdentityIdFormat(request))

        def modifyImageAttribute(
          request: ModifyImageAttributeRequest
        ): Kleisli[M, Ec2Client, ModifyImageAttributeResponse] =
          primitive(_.modifyImageAttribute(request))

        def modifyInstanceAttribute(
          request: ModifyInstanceAttributeRequest
        ): Kleisli[M, Ec2Client, ModifyInstanceAttributeResponse] =
          primitive(_.modifyInstanceAttribute(request))

        def modifyInstanceCapacityReservationAttributes(
          request: ModifyInstanceCapacityReservationAttributesRequest
        ): Kleisli[M, Ec2Client, ModifyInstanceCapacityReservationAttributesResponse] =
          primitive(_.modifyInstanceCapacityReservationAttributes(request))

        def modifyInstanceCreditSpecification(
          request: ModifyInstanceCreditSpecificationRequest
        ): Kleisli[M, Ec2Client, ModifyInstanceCreditSpecificationResponse] =
          primitive(_.modifyInstanceCreditSpecification(request))

        def modifyInstanceEventStartTime(
          request: ModifyInstanceEventStartTimeRequest
        ): Kleisli[M, Ec2Client, ModifyInstanceEventStartTimeResponse] =
          primitive(_.modifyInstanceEventStartTime(request))

        def modifyInstanceMetadataOptions(
          request: ModifyInstanceMetadataOptionsRequest
        ): Kleisli[M, Ec2Client, ModifyInstanceMetadataOptionsResponse] =
          primitive(_.modifyInstanceMetadataOptions(request))

        def modifyInstancePlacement(
          request: ModifyInstancePlacementRequest
        ): Kleisli[M, Ec2Client, ModifyInstancePlacementResponse] =
          primitive(_.modifyInstancePlacement(request))

        def modifyLaunchTemplate(
          request: ModifyLaunchTemplateRequest
        ): Kleisli[M, Ec2Client, ModifyLaunchTemplateResponse] =
          primitive(_.modifyLaunchTemplate(request))

        def modifyManagedPrefixList(
          request: ModifyManagedPrefixListRequest
        ): Kleisli[M, Ec2Client, ModifyManagedPrefixListResponse] =
          primitive(_.modifyManagedPrefixList(request))

        def modifyNetworkInterfaceAttribute(
          request: ModifyNetworkInterfaceAttributeRequest
        ): Kleisli[M, Ec2Client, ModifyNetworkInterfaceAttributeResponse] =
          primitive(_.modifyNetworkInterfaceAttribute(request))

        def modifyReservedInstances(
          request: ModifyReservedInstancesRequest
        ): Kleisli[M, Ec2Client, ModifyReservedInstancesResponse] =
          primitive(_.modifyReservedInstances(request))

        def modifySnapshotAttribute(
          request: ModifySnapshotAttributeRequest
        ): Kleisli[M, Ec2Client, ModifySnapshotAttributeResponse] =
          primitive(_.modifySnapshotAttribute(request))

        def modifySpotFleetRequest(
          request: ModifySpotFleetRequestRequest
        ): Kleisli[M, Ec2Client, ModifySpotFleetRequestResponse] =
          primitive(_.modifySpotFleetRequest(request))

        def modifySubnetAttribute(
          request: ModifySubnetAttributeRequest
        ): Kleisli[M, Ec2Client, ModifySubnetAttributeResponse] =
          primitive(_.modifySubnetAttribute(request))

        def modifyTrafficMirrorFilterNetworkServices(
          request: ModifyTrafficMirrorFilterNetworkServicesRequest
        ): Kleisli[M, Ec2Client, ModifyTrafficMirrorFilterNetworkServicesResponse] =
          primitive(_.modifyTrafficMirrorFilterNetworkServices(request))

        def modifyTrafficMirrorFilterRule(
          request: ModifyTrafficMirrorFilterRuleRequest
        ): Kleisli[M, Ec2Client, ModifyTrafficMirrorFilterRuleResponse] =
          primitive(_.modifyTrafficMirrorFilterRule(request))

        def modifyTrafficMirrorSession(
          request: ModifyTrafficMirrorSessionRequest
        ): Kleisli[M, Ec2Client, ModifyTrafficMirrorSessionResponse] =
          primitive(_.modifyTrafficMirrorSession(request))

        def modifyTransitGateway(
          request: ModifyTransitGatewayRequest
        ): Kleisli[M, Ec2Client, ModifyTransitGatewayResponse] =
          primitive(_.modifyTransitGateway(request))

        def modifyTransitGatewayPrefixListReference(
          request: ModifyTransitGatewayPrefixListReferenceRequest
        ): Kleisli[M, Ec2Client, ModifyTransitGatewayPrefixListReferenceResponse] =
          primitive(_.modifyTransitGatewayPrefixListReference(request))

        def modifyTransitGatewayVpcAttachment(
          request: ModifyTransitGatewayVpcAttachmentRequest
        ): Kleisli[M, Ec2Client, ModifyTransitGatewayVpcAttachmentResponse] =
          primitive(_.modifyTransitGatewayVpcAttachment(request))

        def modifyVolume(
          request: ModifyVolumeRequest
        ): Kleisli[M, Ec2Client, ModifyVolumeResponse] =
          primitive(_.modifyVolume(request))

        def modifyVolumeAttribute(
          request: ModifyVolumeAttributeRequest
        ): Kleisli[M, Ec2Client, ModifyVolumeAttributeResponse] =
          primitive(_.modifyVolumeAttribute(request))

        def modifyVpcAttribute(
          request: ModifyVpcAttributeRequest
        ): Kleisli[M, Ec2Client, ModifyVpcAttributeResponse] =
          primitive(_.modifyVpcAttribute(request))

        def modifyVpcEndpoint(
          request: ModifyVpcEndpointRequest
        ): Kleisli[M, Ec2Client, ModifyVpcEndpointResponse] =
          primitive(_.modifyVpcEndpoint(request))

        def modifyVpcEndpointConnectionNotification(
          request: ModifyVpcEndpointConnectionNotificationRequest
        ): Kleisli[M, Ec2Client, ModifyVpcEndpointConnectionNotificationResponse] =
          primitive(_.modifyVpcEndpointConnectionNotification(request))

        def modifyVpcEndpointServiceConfiguration(
          request: ModifyVpcEndpointServiceConfigurationRequest
        ): Kleisli[M, Ec2Client, ModifyVpcEndpointServiceConfigurationResponse] =
          primitive(_.modifyVpcEndpointServiceConfiguration(request))

        def modifyVpcEndpointServicePermissions(
          request: ModifyVpcEndpointServicePermissionsRequest
        ): Kleisli[M, Ec2Client, ModifyVpcEndpointServicePermissionsResponse] =
          primitive(_.modifyVpcEndpointServicePermissions(request))

        def modifyVpcPeeringConnectionOptions(
          request: ModifyVpcPeeringConnectionOptionsRequest
        ): Kleisli[M, Ec2Client, ModifyVpcPeeringConnectionOptionsResponse] =
          primitive(_.modifyVpcPeeringConnectionOptions(request))

        def modifyVpcTenancy(
          request: ModifyVpcTenancyRequest
        ): Kleisli[M, Ec2Client, ModifyVpcTenancyResponse] =
          primitive(_.modifyVpcTenancy(request))

        def modifyVpnConnection(
          request: ModifyVpnConnectionRequest
        ): Kleisli[M, Ec2Client, ModifyVpnConnectionResponse] =
          primitive(_.modifyVpnConnection(request))

        def modifyVpnConnectionOptions(
          request: ModifyVpnConnectionOptionsRequest
        ): Kleisli[M, Ec2Client, ModifyVpnConnectionOptionsResponse] =
          primitive(_.modifyVpnConnectionOptions(request))

        def modifyVpnTunnelCertificate(
          request: ModifyVpnTunnelCertificateRequest
        ): Kleisli[M, Ec2Client, ModifyVpnTunnelCertificateResponse] =
          primitive(_.modifyVpnTunnelCertificate(request))

        def modifyVpnTunnelOptions(
          request: ModifyVpnTunnelOptionsRequest
        ): Kleisli[M, Ec2Client, ModifyVpnTunnelOptionsResponse] =
          primitive(_.modifyVpnTunnelOptions(request))

        def monitorInstances(
          request: MonitorInstancesRequest
        ): Kleisli[M, Ec2Client, MonitorInstancesResponse] =
          primitive(_.monitorInstances(request))

        def moveAddressToVpc(
          request: MoveAddressToVpcRequest
        ): Kleisli[M, Ec2Client, MoveAddressToVpcResponse] =
          primitive(_.moveAddressToVpc(request))

        def provisionByoipCidr(
          request: ProvisionByoipCidrRequest
        ): Kleisli[M, Ec2Client, ProvisionByoipCidrResponse] =
          primitive(_.provisionByoipCidr(request))

        def purchaseHostReservation(
          request: PurchaseHostReservationRequest
        ): Kleisli[M, Ec2Client, PurchaseHostReservationResponse] =
          primitive(_.purchaseHostReservation(request))

        def purchaseReservedInstancesOffering(
          request: PurchaseReservedInstancesOfferingRequest
        ): Kleisli[M, Ec2Client, PurchaseReservedInstancesOfferingResponse] =
          primitive(_.purchaseReservedInstancesOffering(request))

        def purchaseScheduledInstances(
          request: PurchaseScheduledInstancesRequest
        ): Kleisli[M, Ec2Client, PurchaseScheduledInstancesResponse] =
          primitive(_.purchaseScheduledInstances(request))

        def rebootInstances(
          request: RebootInstancesRequest
        ): Kleisli[M, Ec2Client, RebootInstancesResponse] =
          primitive(_.rebootInstances(request))

        def registerImage(
          request: RegisterImageRequest
        ): Kleisli[M, Ec2Client, RegisterImageResponse] =
          primitive(_.registerImage(request))

        def registerInstanceEventNotificationAttributes(
          request: RegisterInstanceEventNotificationAttributesRequest
        ): Kleisli[M, Ec2Client, RegisterInstanceEventNotificationAttributesResponse] =
          primitive(_.registerInstanceEventNotificationAttributes(request))

        def registerTransitGatewayMulticastGroupMembers(
          request: RegisterTransitGatewayMulticastGroupMembersRequest
        ): Kleisli[M, Ec2Client, RegisterTransitGatewayMulticastGroupMembersResponse] =
          primitive(_.registerTransitGatewayMulticastGroupMembers(request))

        def registerTransitGatewayMulticastGroupSources(
          request: RegisterTransitGatewayMulticastGroupSourcesRequest
        ): Kleisli[M, Ec2Client, RegisterTransitGatewayMulticastGroupSourcesResponse] =
          primitive(_.registerTransitGatewayMulticastGroupSources(request))

        def rejectTransitGatewayMulticastDomainAssociations(
          request: RejectTransitGatewayMulticastDomainAssociationsRequest
        ): Kleisli[M, Ec2Client, RejectTransitGatewayMulticastDomainAssociationsResponse] =
          primitive(_.rejectTransitGatewayMulticastDomainAssociations(request))

        def rejectTransitGatewayPeeringAttachment(
          request: RejectTransitGatewayPeeringAttachmentRequest
        ): Kleisli[M, Ec2Client, RejectTransitGatewayPeeringAttachmentResponse] =
          primitive(_.rejectTransitGatewayPeeringAttachment(request))

        def rejectTransitGatewayVpcAttachment(
          request: RejectTransitGatewayVpcAttachmentRequest
        ): Kleisli[M, Ec2Client, RejectTransitGatewayVpcAttachmentResponse] =
          primitive(_.rejectTransitGatewayVpcAttachment(request))

        def rejectVpcEndpointConnections(
          request: RejectVpcEndpointConnectionsRequest
        ): Kleisli[M, Ec2Client, RejectVpcEndpointConnectionsResponse] =
          primitive(_.rejectVpcEndpointConnections(request))

        def rejectVpcPeeringConnection(
          request: RejectVpcPeeringConnectionRequest
        ): Kleisli[M, Ec2Client, RejectVpcPeeringConnectionResponse] =
          primitive(_.rejectVpcPeeringConnection(request))

        def releaseAddress(
          request: ReleaseAddressRequest
        ): Kleisli[M, Ec2Client, ReleaseAddressResponse] =
          primitive(_.releaseAddress(request))

        def releaseHosts(
          request: ReleaseHostsRequest
        ): Kleisli[M, Ec2Client, ReleaseHostsResponse] =
          primitive(_.releaseHosts(request))

        def replaceIamInstanceProfileAssociation(
          request: ReplaceIamInstanceProfileAssociationRequest
        ): Kleisli[M, Ec2Client, ReplaceIamInstanceProfileAssociationResponse] =
          primitive(_.replaceIamInstanceProfileAssociation(request))

        def replaceNetworkAclAssociation(
          request: ReplaceNetworkAclAssociationRequest
        ): Kleisli[M, Ec2Client, ReplaceNetworkAclAssociationResponse] =
          primitive(_.replaceNetworkAclAssociation(request))

        def replaceNetworkAclEntry(
          request: ReplaceNetworkAclEntryRequest
        ): Kleisli[M, Ec2Client, ReplaceNetworkAclEntryResponse] =
          primitive(_.replaceNetworkAclEntry(request))

        def replaceRoute(
          request: ReplaceRouteRequest
        ): Kleisli[M, Ec2Client, ReplaceRouteResponse] =
          primitive(_.replaceRoute(request))

        def replaceRouteTableAssociation(
          request: ReplaceRouteTableAssociationRequest
        ): Kleisli[M, Ec2Client, ReplaceRouteTableAssociationResponse] =
          primitive(_.replaceRouteTableAssociation(request))

        def replaceTransitGatewayRoute(
          request: ReplaceTransitGatewayRouteRequest
        ): Kleisli[M, Ec2Client, ReplaceTransitGatewayRouteResponse] =
          primitive(_.replaceTransitGatewayRoute(request))

        def reportInstanceStatus(
          request: ReportInstanceStatusRequest
        ): Kleisli[M, Ec2Client, ReportInstanceStatusResponse] =
          primitive(_.reportInstanceStatus(request))

        def requestSpotFleet(
          request: RequestSpotFleetRequest
        ): Kleisli[M, Ec2Client, RequestSpotFleetResponse] =
          primitive(_.requestSpotFleet(request))

        def requestSpotInstances(
          request: RequestSpotInstancesRequest
        ): Kleisli[M, Ec2Client, RequestSpotInstancesResponse] =
          primitive(_.requestSpotInstances(request))

        def resetAddressAttribute(
          request: ResetAddressAttributeRequest
        ): Kleisli[M, Ec2Client, ResetAddressAttributeResponse] =
          primitive(_.resetAddressAttribute(request))

        def resetEbsDefaultKmsKeyId(
          request: ResetEbsDefaultKmsKeyIdRequest
        ): Kleisli[M, Ec2Client, ResetEbsDefaultKmsKeyIdResponse] =
          primitive(_.resetEbsDefaultKmsKeyId(request))

        def resetFpgaImageAttribute(
          request: ResetFpgaImageAttributeRequest
        ): Kleisli[M, Ec2Client, ResetFpgaImageAttributeResponse] =
          primitive(_.resetFpgaImageAttribute(request))

        def resetImageAttribute(
          request: ResetImageAttributeRequest
        ): Kleisli[M, Ec2Client, ResetImageAttributeResponse] =
          primitive(_.resetImageAttribute(request))

        def resetInstanceAttribute(
          request: ResetInstanceAttributeRequest
        ): Kleisli[M, Ec2Client, ResetInstanceAttributeResponse] =
          primitive(_.resetInstanceAttribute(request))

        def resetNetworkInterfaceAttribute(
          request: ResetNetworkInterfaceAttributeRequest
        ): Kleisli[M, Ec2Client, ResetNetworkInterfaceAttributeResponse] =
          primitive(_.resetNetworkInterfaceAttribute(request))

        def resetSnapshotAttribute(
          request: ResetSnapshotAttributeRequest
        ): Kleisli[M, Ec2Client, ResetSnapshotAttributeResponse] =
          primitive(_.resetSnapshotAttribute(request))

        def restoreAddressToClassic(
          request: RestoreAddressToClassicRequest
        ): Kleisli[M, Ec2Client, RestoreAddressToClassicResponse] =
          primitive(_.restoreAddressToClassic(request))

        def restoreManagedPrefixListVersion(
          request: RestoreManagedPrefixListVersionRequest
        ): Kleisli[M, Ec2Client, RestoreManagedPrefixListVersionResponse] =
          primitive(_.restoreManagedPrefixListVersion(request))

        def revokeClientVpnIngress(
          request: RevokeClientVpnIngressRequest
        ): Kleisli[M, Ec2Client, RevokeClientVpnIngressResponse] =
          primitive(_.revokeClientVpnIngress(request))

        def revokeSecurityGroupEgress(
          request: RevokeSecurityGroupEgressRequest
        ): Kleisli[M, Ec2Client, RevokeSecurityGroupEgressResponse] =
          primitive(_.revokeSecurityGroupEgress(request))

        def revokeSecurityGroupIngress(
          request: RevokeSecurityGroupIngressRequest
        ): Kleisli[M, Ec2Client, RevokeSecurityGroupIngressResponse] =
          primitive(_.revokeSecurityGroupIngress(request))

        def runInstances(
          request: RunInstancesRequest
        ): Kleisli[M, Ec2Client, RunInstancesResponse] =
          primitive(_.runInstances(request))

        def runScheduledInstances(
          request: RunScheduledInstancesRequest
        ): Kleisli[M, Ec2Client, RunScheduledInstancesResponse] =
          primitive(_.runScheduledInstances(request))

        def searchLocalGatewayRoutes(
          request: SearchLocalGatewayRoutesRequest
        ): Kleisli[M, Ec2Client, SearchLocalGatewayRoutesResponse] =
          primitive(_.searchLocalGatewayRoutes(request))

        def searchTransitGatewayMulticastGroups(
          request: SearchTransitGatewayMulticastGroupsRequest
        ): Kleisli[M, Ec2Client, SearchTransitGatewayMulticastGroupsResponse] =
          primitive(_.searchTransitGatewayMulticastGroups(request))

        def searchTransitGatewayRoutes(
          request: SearchTransitGatewayRoutesRequest
        ): Kleisli[M, Ec2Client, SearchTransitGatewayRoutesResponse] =
          primitive(_.searchTransitGatewayRoutes(request))

        def sendDiagnosticInterrupt(
          request: SendDiagnosticInterruptRequest
        ): Kleisli[M, Ec2Client, SendDiagnosticInterruptResponse] =
          primitive(_.sendDiagnosticInterrupt(request))

        def startInstances(
          request: StartInstancesRequest
        ): Kleisli[M, Ec2Client, StartInstancesResponse] =
          primitive(_.startInstances(request))

        def startNetworkInsightsAnalysis(
          request: StartNetworkInsightsAnalysisRequest
        ): Kleisli[M, Ec2Client, StartNetworkInsightsAnalysisResponse] =
          primitive(_.startNetworkInsightsAnalysis(request))

        def startVpcEndpointServicePrivateDnsVerification(
          request: StartVpcEndpointServicePrivateDnsVerificationRequest
        ): Kleisli[M, Ec2Client, StartVpcEndpointServicePrivateDnsVerificationResponse] =
          primitive(_.startVpcEndpointServicePrivateDnsVerification(request))

        def stopInstances(
          request: StopInstancesRequest
        ): Kleisli[M, Ec2Client, StopInstancesResponse] =
          primitive(_.stopInstances(request))

        def terminateClientVpnConnections(
          request: TerminateClientVpnConnectionsRequest
        ): Kleisli[M, Ec2Client, TerminateClientVpnConnectionsResponse] =
          primitive(_.terminateClientVpnConnections(request))

        def terminateInstances(
          request: TerminateInstancesRequest
        ): Kleisli[M, Ec2Client, TerminateInstancesResponse] =
          primitive(_.terminateInstances(request))

        def unassignIpv6Addresses(
          request: UnassignIpv6AddressesRequest
        ): Kleisli[M, Ec2Client, UnassignIpv6AddressesResponse] =
          primitive(_.unassignIpv6Addresses(request))

        def unassignPrivateIpAddresses(
          request: UnassignPrivateIpAddressesRequest
        ): Kleisli[M, Ec2Client, UnassignPrivateIpAddressesResponse] =
          primitive(_.unassignPrivateIpAddresses(request))

        def unmonitorInstances(
          request: UnmonitorInstancesRequest
        ): Kleisli[M, Ec2Client, UnmonitorInstancesResponse] =
          primitive(_.unmonitorInstances(request))

        def updateSecurityGroupRuleDescriptionsEgress(
          request: UpdateSecurityGroupRuleDescriptionsEgressRequest
        ): Kleisli[M, Ec2Client, UpdateSecurityGroupRuleDescriptionsEgressResponse] =
          primitive(_.updateSecurityGroupRuleDescriptionsEgress(request))

        def updateSecurityGroupRuleDescriptionsIngress(
          request: UpdateSecurityGroupRuleDescriptionsIngressRequest
        ): Kleisli[M, Ec2Client, UpdateSecurityGroupRuleDescriptionsIngressResponse] =
          primitive(_.updateSecurityGroupRuleDescriptionsIngress(request))

        def withdrawByoipCidr(
          request: WithdrawByoipCidrRequest
        ): Kleisli[M, Ec2Client, WithdrawByoipCidrResponse] =
          primitive(_.withdrawByoipCidr(request))

        def primitive[A](
          f: Ec2Client => A
        ): Kleisli[M, Ec2Client, A]
      }
    }

    trait Visitor[F[_]] extends (Ec2Op ~> F) {
      final def apply[A](op: Ec2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptReservedInstancesExchangeQuote(
        request: AcceptReservedInstancesExchangeQuoteRequest
      ): F[AcceptReservedInstancesExchangeQuoteResponse]

      def acceptTransitGatewayMulticastDomainAssociations(
        request: AcceptTransitGatewayMulticastDomainAssociationsRequest
      ): F[AcceptTransitGatewayMulticastDomainAssociationsResponse]

      def acceptTransitGatewayPeeringAttachment(
        request: AcceptTransitGatewayPeeringAttachmentRequest
      ): F[AcceptTransitGatewayPeeringAttachmentResponse]

      def acceptTransitGatewayVpcAttachment(
        request: AcceptTransitGatewayVpcAttachmentRequest
      ): F[AcceptTransitGatewayVpcAttachmentResponse]

      def acceptVpcEndpointConnections(
        request: AcceptVpcEndpointConnectionsRequest
      ): F[AcceptVpcEndpointConnectionsResponse]

      def acceptVpcPeeringConnection(
        request: AcceptVpcPeeringConnectionRequest
      ): F[AcceptVpcPeeringConnectionResponse]

      def advertiseByoipCidr(
        request: AdvertiseByoipCidrRequest
      ): F[AdvertiseByoipCidrResponse]

      def allocateAddress(
        request: AllocateAddressRequest
      ): F[AllocateAddressResponse]

      def allocateHosts(
        request: AllocateHostsRequest
      ): F[AllocateHostsResponse]

      def applySecurityGroupsToClientVpnTargetNetwork(
        request: ApplySecurityGroupsToClientVpnTargetNetworkRequest
      ): F[ApplySecurityGroupsToClientVpnTargetNetworkResponse]

      def assignIpv6Addresses(
        request: AssignIpv6AddressesRequest
      ): F[AssignIpv6AddressesResponse]

      def assignPrivateIpAddresses(
        request: AssignPrivateIpAddressesRequest
      ): F[AssignPrivateIpAddressesResponse]

      def associateAddress(
        request: AssociateAddressRequest
      ): F[AssociateAddressResponse]

      def associateClientVpnTargetNetwork(
        request: AssociateClientVpnTargetNetworkRequest
      ): F[AssociateClientVpnTargetNetworkResponse]

      def associateDhcpOptions(
        request: AssociateDhcpOptionsRequest
      ): F[AssociateDhcpOptionsResponse]

      def associateEnclaveCertificateIamRole(
        request: AssociateEnclaveCertificateIamRoleRequest
      ): F[AssociateEnclaveCertificateIamRoleResponse]

      def associateIamInstanceProfile(
        request: AssociateIamInstanceProfileRequest
      ): F[AssociateIamInstanceProfileResponse]

      def associateRouteTable(
        request: AssociateRouteTableRequest
      ): F[AssociateRouteTableResponse]

      def associateSubnetCidrBlock(
        request: AssociateSubnetCidrBlockRequest
      ): F[AssociateSubnetCidrBlockResponse]

      def associateTransitGatewayMulticastDomain(
        request: AssociateTransitGatewayMulticastDomainRequest
      ): F[AssociateTransitGatewayMulticastDomainResponse]

      def associateTransitGatewayRouteTable(
        request: AssociateTransitGatewayRouteTableRequest
      ): F[AssociateTransitGatewayRouteTableResponse]

      def associateVpcCidrBlock(
        request: AssociateVpcCidrBlockRequest
      ): F[AssociateVpcCidrBlockResponse]

      def attachClassicLinkVpc(
        request: AttachClassicLinkVpcRequest
      ): F[AttachClassicLinkVpcResponse]

      def attachInternetGateway(
        request: AttachInternetGatewayRequest
      ): F[AttachInternetGatewayResponse]

      def attachNetworkInterface(
        request: AttachNetworkInterfaceRequest
      ): F[AttachNetworkInterfaceResponse]

      def attachVolume(
        request: AttachVolumeRequest
      ): F[AttachVolumeResponse]

      def attachVpnGateway(
        request: AttachVpnGatewayRequest
      ): F[AttachVpnGatewayResponse]

      def authorizeClientVpnIngress(
        request: AuthorizeClientVpnIngressRequest
      ): F[AuthorizeClientVpnIngressResponse]

      def authorizeSecurityGroupEgress(
        request: AuthorizeSecurityGroupEgressRequest
      ): F[AuthorizeSecurityGroupEgressResponse]

      def authorizeSecurityGroupIngress(
        request: AuthorizeSecurityGroupIngressRequest
      ): F[AuthorizeSecurityGroupIngressResponse]

      def bundleInstance(
        request: BundleInstanceRequest
      ): F[BundleInstanceResponse]

      def cancelBundleTask(
        request: CancelBundleTaskRequest
      ): F[CancelBundleTaskResponse]

      def cancelCapacityReservation(
        request: CancelCapacityReservationRequest
      ): F[CancelCapacityReservationResponse]

      def cancelConversionTask(
        request: CancelConversionTaskRequest
      ): F[CancelConversionTaskResponse]

      def cancelExportTask(
        request: CancelExportTaskRequest
      ): F[CancelExportTaskResponse]

      def cancelImportTask(
        request: CancelImportTaskRequest
      ): F[CancelImportTaskResponse]

      def cancelReservedInstancesListing(
        request: CancelReservedInstancesListingRequest
      ): F[CancelReservedInstancesListingResponse]

      def cancelSpotFleetRequests(
        request: CancelSpotFleetRequestsRequest
      ): F[CancelSpotFleetRequestsResponse]

      def cancelSpotInstanceRequests(
        request: CancelSpotInstanceRequestsRequest
      ): F[CancelSpotInstanceRequestsResponse]

      def confirmProductInstance(
        request: ConfirmProductInstanceRequest
      ): F[ConfirmProductInstanceResponse]

      def copyFpgaImage(
        request: CopyFpgaImageRequest
      ): F[CopyFpgaImageResponse]

      def copyImage(
        request: CopyImageRequest
      ): F[CopyImageResponse]

      def copySnapshot(
        request: CopySnapshotRequest
      ): F[CopySnapshotResponse]

      def createCapacityReservation(
        request: CreateCapacityReservationRequest
      ): F[CreateCapacityReservationResponse]

      def createCarrierGateway(
        request: CreateCarrierGatewayRequest
      ): F[CreateCarrierGatewayResponse]

      def createClientVpnEndpoint(
        request: CreateClientVpnEndpointRequest
      ): F[CreateClientVpnEndpointResponse]

      def createClientVpnRoute(
        request: CreateClientVpnRouteRequest
      ): F[CreateClientVpnRouteResponse]

      def createCustomerGateway(
        request: CreateCustomerGatewayRequest
      ): F[CreateCustomerGatewayResponse]

      def createDefaultSubnet(
        request: CreateDefaultSubnetRequest
      ): F[CreateDefaultSubnetResponse]

      def createDefaultVpc(
        request: CreateDefaultVpcRequest
      ): F[CreateDefaultVpcResponse]

      def createDhcpOptions(
        request: CreateDhcpOptionsRequest
      ): F[CreateDhcpOptionsResponse]

      def createEgressOnlyInternetGateway(
        request: CreateEgressOnlyInternetGatewayRequest
      ): F[CreateEgressOnlyInternetGatewayResponse]

      def createFleet(
        request: CreateFleetRequest
      ): F[CreateFleetResponse]

      def createFlowLogs(
        request: CreateFlowLogsRequest
      ): F[CreateFlowLogsResponse]

      def createFpgaImage(
        request: CreateFpgaImageRequest
      ): F[CreateFpgaImageResponse]

      def createImage(
        request: CreateImageRequest
      ): F[CreateImageResponse]

      def createInstanceExportTask(
        request: CreateInstanceExportTaskRequest
      ): F[CreateInstanceExportTaskResponse]

      def createInternetGateway(
        request: CreateInternetGatewayRequest
      ): F[CreateInternetGatewayResponse]

      def createKeyPair(
        request: CreateKeyPairRequest
      ): F[CreateKeyPairResponse]

      def createLaunchTemplate(
        request: CreateLaunchTemplateRequest
      ): F[CreateLaunchTemplateResponse]

      def createLaunchTemplateVersion(
        request: CreateLaunchTemplateVersionRequest
      ): F[CreateLaunchTemplateVersionResponse]

      def createLocalGatewayRoute(
        request: CreateLocalGatewayRouteRequest
      ): F[CreateLocalGatewayRouteResponse]

      def createLocalGatewayRouteTableVpcAssociation(
        request: CreateLocalGatewayRouteTableVpcAssociationRequest
      ): F[CreateLocalGatewayRouteTableVpcAssociationResponse]

      def createManagedPrefixList(
        request: CreateManagedPrefixListRequest
      ): F[CreateManagedPrefixListResponse]

      def createNatGateway(
        request: CreateNatGatewayRequest
      ): F[CreateNatGatewayResponse]

      def createNetworkAcl(
        request: CreateNetworkAclRequest
      ): F[CreateNetworkAclResponse]

      def createNetworkAclEntry(
        request: CreateNetworkAclEntryRequest
      ): F[CreateNetworkAclEntryResponse]

      def createNetworkInsightsPath(
        request: CreateNetworkInsightsPathRequest
      ): F[CreateNetworkInsightsPathResponse]

      def createNetworkInterface(
        request: CreateNetworkInterfaceRequest
      ): F[CreateNetworkInterfaceResponse]

      def createNetworkInterfacePermission(
        request: CreateNetworkInterfacePermissionRequest
      ): F[CreateNetworkInterfacePermissionResponse]

      def createPlacementGroup(
        request: CreatePlacementGroupRequest
      ): F[CreatePlacementGroupResponse]

      def createReplaceRootVolumeTask(
        request: CreateReplaceRootVolumeTaskRequest
      ): F[CreateReplaceRootVolumeTaskResponse]

      def createReservedInstancesListing(
        request: CreateReservedInstancesListingRequest
      ): F[CreateReservedInstancesListingResponse]

      def createRestoreImageTask(
        request: CreateRestoreImageTaskRequest
      ): F[CreateRestoreImageTaskResponse]

      def createRoute(
        request: CreateRouteRequest
      ): F[CreateRouteResponse]

      def createRouteTable(
        request: CreateRouteTableRequest
      ): F[CreateRouteTableResponse]

      def createSecurityGroup(
        request: CreateSecurityGroupRequest
      ): F[CreateSecurityGroupResponse]

      def createSnapshot(
        request: CreateSnapshotRequest
      ): F[CreateSnapshotResponse]

      def createSnapshots(
        request: CreateSnapshotsRequest
      ): F[CreateSnapshotsResponse]

      def createSpotDatafeedSubscription(
        request: CreateSpotDatafeedSubscriptionRequest
      ): F[CreateSpotDatafeedSubscriptionResponse]

      def createStoreImageTask(
        request: CreateStoreImageTaskRequest
      ): F[CreateStoreImageTaskResponse]

      def createSubnet(
        request: CreateSubnetRequest
      ): F[CreateSubnetResponse]

      def createTags(
        request: CreateTagsRequest
      ): F[CreateTagsResponse]

      def createTrafficMirrorFilter(
        request: CreateTrafficMirrorFilterRequest
      ): F[CreateTrafficMirrorFilterResponse]

      def createTrafficMirrorFilterRule(
        request: CreateTrafficMirrorFilterRuleRequest
      ): F[CreateTrafficMirrorFilterRuleResponse]

      def createTrafficMirrorSession(
        request: CreateTrafficMirrorSessionRequest
      ): F[CreateTrafficMirrorSessionResponse]

      def createTrafficMirrorTarget(
        request: CreateTrafficMirrorTargetRequest
      ): F[CreateTrafficMirrorTargetResponse]

      def createTransitGateway(
        request: CreateTransitGatewayRequest
      ): F[CreateTransitGatewayResponse]

      def createTransitGatewayConnect(
        request: CreateTransitGatewayConnectRequest
      ): F[CreateTransitGatewayConnectResponse]

      def createTransitGatewayConnectPeer(
        request: CreateTransitGatewayConnectPeerRequest
      ): F[CreateTransitGatewayConnectPeerResponse]

      def createTransitGatewayMulticastDomain(
        request: CreateTransitGatewayMulticastDomainRequest
      ): F[CreateTransitGatewayMulticastDomainResponse]

      def createTransitGatewayPeeringAttachment(
        request: CreateTransitGatewayPeeringAttachmentRequest
      ): F[CreateTransitGatewayPeeringAttachmentResponse]

      def createTransitGatewayPrefixListReference(
        request: CreateTransitGatewayPrefixListReferenceRequest
      ): F[CreateTransitGatewayPrefixListReferenceResponse]

      def createTransitGatewayRoute(
        request: CreateTransitGatewayRouteRequest
      ): F[CreateTransitGatewayRouteResponse]

      def createTransitGatewayRouteTable(
        request: CreateTransitGatewayRouteTableRequest
      ): F[CreateTransitGatewayRouteTableResponse]

      def createTransitGatewayVpcAttachment(
        request: CreateTransitGatewayVpcAttachmentRequest
      ): F[CreateTransitGatewayVpcAttachmentResponse]

      def createVolume(
        request: CreateVolumeRequest
      ): F[CreateVolumeResponse]

      def createVpc(
        request: CreateVpcRequest
      ): F[CreateVpcResponse]

      def createVpcEndpoint(
        request: CreateVpcEndpointRequest
      ): F[CreateVpcEndpointResponse]

      def createVpcEndpointConnectionNotification(
        request: CreateVpcEndpointConnectionNotificationRequest
      ): F[CreateVpcEndpointConnectionNotificationResponse]

      def createVpcEndpointServiceConfiguration(
        request: CreateVpcEndpointServiceConfigurationRequest
      ): F[CreateVpcEndpointServiceConfigurationResponse]

      def createVpcPeeringConnection(
        request: CreateVpcPeeringConnectionRequest
      ): F[CreateVpcPeeringConnectionResponse]

      def createVpnConnection(
        request: CreateVpnConnectionRequest
      ): F[CreateVpnConnectionResponse]

      def createVpnConnectionRoute(
        request: CreateVpnConnectionRouteRequest
      ): F[CreateVpnConnectionRouteResponse]

      def createVpnGateway(
        request: CreateVpnGatewayRequest
      ): F[CreateVpnGatewayResponse]

      def deleteCarrierGateway(
        request: DeleteCarrierGatewayRequest
      ): F[DeleteCarrierGatewayResponse]

      def deleteClientVpnEndpoint(
        request: DeleteClientVpnEndpointRequest
      ): F[DeleteClientVpnEndpointResponse]

      def deleteClientVpnRoute(
        request: DeleteClientVpnRouteRequest
      ): F[DeleteClientVpnRouteResponse]

      def deleteCustomerGateway(
        request: DeleteCustomerGatewayRequest
      ): F[DeleteCustomerGatewayResponse]

      def deleteDhcpOptions(
        request: DeleteDhcpOptionsRequest
      ): F[DeleteDhcpOptionsResponse]

      def deleteEgressOnlyInternetGateway(
        request: DeleteEgressOnlyInternetGatewayRequest
      ): F[DeleteEgressOnlyInternetGatewayResponse]

      def deleteFleets(
        request: DeleteFleetsRequest
      ): F[DeleteFleetsResponse]

      def deleteFlowLogs(
        request: DeleteFlowLogsRequest
      ): F[DeleteFlowLogsResponse]

      def deleteFpgaImage(
        request: DeleteFpgaImageRequest
      ): F[DeleteFpgaImageResponse]

      def deleteInternetGateway(
        request: DeleteInternetGatewayRequest
      ): F[DeleteInternetGatewayResponse]

      def deleteKeyPair(
        request: DeleteKeyPairRequest
      ): F[DeleteKeyPairResponse]

      def deleteLaunchTemplate(
        request: DeleteLaunchTemplateRequest
      ): F[DeleteLaunchTemplateResponse]

      def deleteLaunchTemplateVersions(
        request: DeleteLaunchTemplateVersionsRequest
      ): F[DeleteLaunchTemplateVersionsResponse]

      def deleteLocalGatewayRoute(
        request: DeleteLocalGatewayRouteRequest
      ): F[DeleteLocalGatewayRouteResponse]

      def deleteLocalGatewayRouteTableVpcAssociation(
        request: DeleteLocalGatewayRouteTableVpcAssociationRequest
      ): F[DeleteLocalGatewayRouteTableVpcAssociationResponse]

      def deleteManagedPrefixList(
        request: DeleteManagedPrefixListRequest
      ): F[DeleteManagedPrefixListResponse]

      def deleteNatGateway(
        request: DeleteNatGatewayRequest
      ): F[DeleteNatGatewayResponse]

      def deleteNetworkAcl(
        request: DeleteNetworkAclRequest
      ): F[DeleteNetworkAclResponse]

      def deleteNetworkAclEntry(
        request: DeleteNetworkAclEntryRequest
      ): F[DeleteNetworkAclEntryResponse]

      def deleteNetworkInsightsAnalysis(
        request: DeleteNetworkInsightsAnalysisRequest
      ): F[DeleteNetworkInsightsAnalysisResponse]

      def deleteNetworkInsightsPath(
        request: DeleteNetworkInsightsPathRequest
      ): F[DeleteNetworkInsightsPathResponse]

      def deleteNetworkInterface(
        request: DeleteNetworkInterfaceRequest
      ): F[DeleteNetworkInterfaceResponse]

      def deleteNetworkInterfacePermission(
        request: DeleteNetworkInterfacePermissionRequest
      ): F[DeleteNetworkInterfacePermissionResponse]

      def deletePlacementGroup(
        request: DeletePlacementGroupRequest
      ): F[DeletePlacementGroupResponse]

      def deleteQueuedReservedInstances(
        request: DeleteQueuedReservedInstancesRequest
      ): F[DeleteQueuedReservedInstancesResponse]

      def deleteRoute(
        request: DeleteRouteRequest
      ): F[DeleteRouteResponse]

      def deleteRouteTable(
        request: DeleteRouteTableRequest
      ): F[DeleteRouteTableResponse]

      def deleteSecurityGroup(
        request: DeleteSecurityGroupRequest
      ): F[DeleteSecurityGroupResponse]

      def deleteSnapshot(
        request: DeleteSnapshotRequest
      ): F[DeleteSnapshotResponse]

      def deleteSpotDatafeedSubscription(
        request: DeleteSpotDatafeedSubscriptionRequest
      ): F[DeleteSpotDatafeedSubscriptionResponse]

      def deleteSubnet(
        request: DeleteSubnetRequest
      ): F[DeleteSubnetResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def deleteTrafficMirrorFilter(
        request: DeleteTrafficMirrorFilterRequest
      ): F[DeleteTrafficMirrorFilterResponse]

      def deleteTrafficMirrorFilterRule(
        request: DeleteTrafficMirrorFilterRuleRequest
      ): F[DeleteTrafficMirrorFilterRuleResponse]

      def deleteTrafficMirrorSession(
        request: DeleteTrafficMirrorSessionRequest
      ): F[DeleteTrafficMirrorSessionResponse]

      def deleteTrafficMirrorTarget(
        request: DeleteTrafficMirrorTargetRequest
      ): F[DeleteTrafficMirrorTargetResponse]

      def deleteTransitGateway(
        request: DeleteTransitGatewayRequest
      ): F[DeleteTransitGatewayResponse]

      def deleteTransitGatewayConnect(
        request: DeleteTransitGatewayConnectRequest
      ): F[DeleteTransitGatewayConnectResponse]

      def deleteTransitGatewayConnectPeer(
        request: DeleteTransitGatewayConnectPeerRequest
      ): F[DeleteTransitGatewayConnectPeerResponse]

      def deleteTransitGatewayMulticastDomain(
        request: DeleteTransitGatewayMulticastDomainRequest
      ): F[DeleteTransitGatewayMulticastDomainResponse]

      def deleteTransitGatewayPeeringAttachment(
        request: DeleteTransitGatewayPeeringAttachmentRequest
      ): F[DeleteTransitGatewayPeeringAttachmentResponse]

      def deleteTransitGatewayPrefixListReference(
        request: DeleteTransitGatewayPrefixListReferenceRequest
      ): F[DeleteTransitGatewayPrefixListReferenceResponse]

      def deleteTransitGatewayRoute(
        request: DeleteTransitGatewayRouteRequest
      ): F[DeleteTransitGatewayRouteResponse]

      def deleteTransitGatewayRouteTable(
        request: DeleteTransitGatewayRouteTableRequest
      ): F[DeleteTransitGatewayRouteTableResponse]

      def deleteTransitGatewayVpcAttachment(
        request: DeleteTransitGatewayVpcAttachmentRequest
      ): F[DeleteTransitGatewayVpcAttachmentResponse]

      def deleteVolume(
        request: DeleteVolumeRequest
      ): F[DeleteVolumeResponse]

      def deleteVpc(
        request: DeleteVpcRequest
      ): F[DeleteVpcResponse]

      def deleteVpcEndpointConnectionNotifications(
        request: DeleteVpcEndpointConnectionNotificationsRequest
      ): F[DeleteVpcEndpointConnectionNotificationsResponse]

      def deleteVpcEndpointServiceConfigurations(
        request: DeleteVpcEndpointServiceConfigurationsRequest
      ): F[DeleteVpcEndpointServiceConfigurationsResponse]

      def deleteVpcEndpoints(
        request: DeleteVpcEndpointsRequest
      ): F[DeleteVpcEndpointsResponse]

      def deleteVpcPeeringConnection(
        request: DeleteVpcPeeringConnectionRequest
      ): F[DeleteVpcPeeringConnectionResponse]

      def deleteVpnConnection(
        request: DeleteVpnConnectionRequest
      ): F[DeleteVpnConnectionResponse]

      def deleteVpnConnectionRoute(
        request: DeleteVpnConnectionRouteRequest
      ): F[DeleteVpnConnectionRouteResponse]

      def deleteVpnGateway(
        request: DeleteVpnGatewayRequest
      ): F[DeleteVpnGatewayResponse]

      def deprovisionByoipCidr(
        request: DeprovisionByoipCidrRequest
      ): F[DeprovisionByoipCidrResponse]

      def deregisterImage(
        request: DeregisterImageRequest
      ): F[DeregisterImageResponse]

      def deregisterInstanceEventNotificationAttributes(
        request: DeregisterInstanceEventNotificationAttributesRequest
      ): F[DeregisterInstanceEventNotificationAttributesResponse]

      def deregisterTransitGatewayMulticastGroupMembers(
        request: DeregisterTransitGatewayMulticastGroupMembersRequest
      ): F[DeregisterTransitGatewayMulticastGroupMembersResponse]

      def deregisterTransitGatewayMulticastGroupSources(
        request: DeregisterTransitGatewayMulticastGroupSourcesRequest
      ): F[DeregisterTransitGatewayMulticastGroupSourcesResponse]

      def describeAccountAttributes(
        request: DescribeAccountAttributesRequest
      ): F[DescribeAccountAttributesResponse]

      def describeAddresses(
        request: DescribeAddressesRequest
      ): F[DescribeAddressesResponse]

      def describeAddressesAttribute(
        request: DescribeAddressesAttributeRequest
      ): F[DescribeAddressesAttributeResponse]

      def describeAggregateIdFormat(
        request: DescribeAggregateIdFormatRequest
      ): F[DescribeAggregateIdFormatResponse]

      def describeAvailabilityZones(
        request: DescribeAvailabilityZonesRequest
      ): F[DescribeAvailabilityZonesResponse]

      def describeBundleTasks(
        request: DescribeBundleTasksRequest
      ): F[DescribeBundleTasksResponse]

      def describeByoipCidrs(
        request: DescribeByoipCidrsRequest
      ): F[DescribeByoipCidrsResponse]

      def describeCapacityReservations(
        request: DescribeCapacityReservationsRequest
      ): F[DescribeCapacityReservationsResponse]

      def describeCarrierGateways(
        request: DescribeCarrierGatewaysRequest
      ): F[DescribeCarrierGatewaysResponse]

      def describeClassicLinkInstances(
        request: DescribeClassicLinkInstancesRequest
      ): F[DescribeClassicLinkInstancesResponse]

      def describeClientVpnAuthorizationRules(
        request: DescribeClientVpnAuthorizationRulesRequest
      ): F[DescribeClientVpnAuthorizationRulesResponse]

      def describeClientVpnConnections(
        request: DescribeClientVpnConnectionsRequest
      ): F[DescribeClientVpnConnectionsResponse]

      def describeClientVpnEndpoints(
        request: DescribeClientVpnEndpointsRequest
      ): F[DescribeClientVpnEndpointsResponse]

      def describeClientVpnRoutes(
        request: DescribeClientVpnRoutesRequest
      ): F[DescribeClientVpnRoutesResponse]

      def describeClientVpnTargetNetworks(
        request: DescribeClientVpnTargetNetworksRequest
      ): F[DescribeClientVpnTargetNetworksResponse]

      def describeCoipPools(
        request: DescribeCoipPoolsRequest
      ): F[DescribeCoipPoolsResponse]

      def describeConversionTasks(
        request: DescribeConversionTasksRequest
      ): F[DescribeConversionTasksResponse]

      def describeCustomerGateways(
        request: DescribeCustomerGatewaysRequest
      ): F[DescribeCustomerGatewaysResponse]

      def describeDhcpOptions(
        request: DescribeDhcpOptionsRequest
      ): F[DescribeDhcpOptionsResponse]

      def describeEgressOnlyInternetGateways(
        request: DescribeEgressOnlyInternetGatewaysRequest
      ): F[DescribeEgressOnlyInternetGatewaysResponse]

      def describeElasticGpus(
        request: DescribeElasticGpusRequest
      ): F[DescribeElasticGpusResponse]

      def describeExportImageTasks(
        request: DescribeExportImageTasksRequest
      ): F[DescribeExportImageTasksResponse]

      def describeExportTasks(
        request: DescribeExportTasksRequest
      ): F[DescribeExportTasksResponse]

      def describeFastSnapshotRestores(
        request: DescribeFastSnapshotRestoresRequest
      ): F[DescribeFastSnapshotRestoresResponse]

      def describeFleetHistory(
        request: DescribeFleetHistoryRequest
      ): F[DescribeFleetHistoryResponse]

      def describeFleetInstances(
        request: DescribeFleetInstancesRequest
      ): F[DescribeFleetInstancesResponse]

      def describeFleets(
        request: DescribeFleetsRequest
      ): F[DescribeFleetsResponse]

      def describeFlowLogs(
        request: DescribeFlowLogsRequest
      ): F[DescribeFlowLogsResponse]

      def describeFpgaImageAttribute(
        request: DescribeFpgaImageAttributeRequest
      ): F[DescribeFpgaImageAttributeResponse]

      def describeFpgaImages(
        request: DescribeFpgaImagesRequest
      ): F[DescribeFpgaImagesResponse]

      def describeHostReservationOfferings(
        request: DescribeHostReservationOfferingsRequest
      ): F[DescribeHostReservationOfferingsResponse]

      def describeHostReservations(
        request: DescribeHostReservationsRequest
      ): F[DescribeHostReservationsResponse]

      def describeHosts(
        request: DescribeHostsRequest
      ): F[DescribeHostsResponse]

      def describeIamInstanceProfileAssociations(
        request: DescribeIamInstanceProfileAssociationsRequest
      ): F[DescribeIamInstanceProfileAssociationsResponse]

      def describeIdFormat(
        request: DescribeIdFormatRequest
      ): F[DescribeIdFormatResponse]

      def describeIdentityIdFormat(
        request: DescribeIdentityIdFormatRequest
      ): F[DescribeIdentityIdFormatResponse]

      def describeImageAttribute(
        request: DescribeImageAttributeRequest
      ): F[DescribeImageAttributeResponse]

      def describeImages(
        request: DescribeImagesRequest
      ): F[DescribeImagesResponse]

      def describeImportImageTasks(
        request: DescribeImportImageTasksRequest
      ): F[DescribeImportImageTasksResponse]

      def describeImportSnapshotTasks(
        request: DescribeImportSnapshotTasksRequest
      ): F[DescribeImportSnapshotTasksResponse]

      def describeInstanceAttribute(
        request: DescribeInstanceAttributeRequest
      ): F[DescribeInstanceAttributeResponse]

      def describeInstanceCreditSpecifications(
        request: DescribeInstanceCreditSpecificationsRequest
      ): F[DescribeInstanceCreditSpecificationsResponse]

      def describeInstanceEventNotificationAttributes(
        request: DescribeInstanceEventNotificationAttributesRequest
      ): F[DescribeInstanceEventNotificationAttributesResponse]

      def describeInstanceStatus(
        request: DescribeInstanceStatusRequest
      ): F[DescribeInstanceStatusResponse]

      def describeInstanceTypeOfferings(
        request: DescribeInstanceTypeOfferingsRequest
      ): F[DescribeInstanceTypeOfferingsResponse]

      def describeInstanceTypes(
        request: DescribeInstanceTypesRequest
      ): F[DescribeInstanceTypesResponse]

      def describeInstances(
        request: DescribeInstancesRequest
      ): F[DescribeInstancesResponse]

      def describeInternetGateways(
        request: DescribeInternetGatewaysRequest
      ): F[DescribeInternetGatewaysResponse]

      def describeIpv6Pools(
        request: DescribeIpv6PoolsRequest
      ): F[DescribeIpv6PoolsResponse]

      def describeKeyPairs(
        request: DescribeKeyPairsRequest
      ): F[DescribeKeyPairsResponse]

      def describeLaunchTemplateVersions(
        request: DescribeLaunchTemplateVersionsRequest
      ): F[DescribeLaunchTemplateVersionsResponse]

      def describeLaunchTemplates(
        request: DescribeLaunchTemplatesRequest
      ): F[DescribeLaunchTemplatesResponse]

      def describeLocalGatewayRouteTableVirtualInterfaceGroupAssociations(
        request: DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsRequest
      ): F[DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsResponse]

      def describeLocalGatewayRouteTableVpcAssociations(
        request: DescribeLocalGatewayRouteTableVpcAssociationsRequest
      ): F[DescribeLocalGatewayRouteTableVpcAssociationsResponse]

      def describeLocalGatewayRouteTables(
        request: DescribeLocalGatewayRouteTablesRequest
      ): F[DescribeLocalGatewayRouteTablesResponse]

      def describeLocalGatewayVirtualInterfaceGroups(
        request: DescribeLocalGatewayVirtualInterfaceGroupsRequest
      ): F[DescribeLocalGatewayVirtualInterfaceGroupsResponse]

      def describeLocalGatewayVirtualInterfaces(
        request: DescribeLocalGatewayVirtualInterfacesRequest
      ): F[DescribeLocalGatewayVirtualInterfacesResponse]

      def describeLocalGateways(
        request: DescribeLocalGatewaysRequest
      ): F[DescribeLocalGatewaysResponse]

      def describeManagedPrefixLists(
        request: DescribeManagedPrefixListsRequest
      ): F[DescribeManagedPrefixListsResponse]

      def describeMovingAddresses(
        request: DescribeMovingAddressesRequest
      ): F[DescribeMovingAddressesResponse]

      def describeNatGateways(
        request: DescribeNatGatewaysRequest
      ): F[DescribeNatGatewaysResponse]

      def describeNetworkAcls(
        request: DescribeNetworkAclsRequest
      ): F[DescribeNetworkAclsResponse]

      def describeNetworkInsightsAnalyses(
        request: DescribeNetworkInsightsAnalysesRequest
      ): F[DescribeNetworkInsightsAnalysesResponse]

      def describeNetworkInsightsPaths(
        request: DescribeNetworkInsightsPathsRequest
      ): F[DescribeNetworkInsightsPathsResponse]

      def describeNetworkInterfaceAttribute(
        request: DescribeNetworkInterfaceAttributeRequest
      ): F[DescribeNetworkInterfaceAttributeResponse]

      def describeNetworkInterfacePermissions(
        request: DescribeNetworkInterfacePermissionsRequest
      ): F[DescribeNetworkInterfacePermissionsResponse]

      def describeNetworkInterfaces(
        request: DescribeNetworkInterfacesRequest
      ): F[DescribeNetworkInterfacesResponse]

      def describePlacementGroups(
        request: DescribePlacementGroupsRequest
      ): F[DescribePlacementGroupsResponse]

      def describePrefixLists(
        request: DescribePrefixListsRequest
      ): F[DescribePrefixListsResponse]

      def describePrincipalIdFormat(
        request: DescribePrincipalIdFormatRequest
      ): F[DescribePrincipalIdFormatResponse]

      def describePublicIpv4Pools(
        request: DescribePublicIpv4PoolsRequest
      ): F[DescribePublicIpv4PoolsResponse]

      def describeRegions(
        request: DescribeRegionsRequest
      ): F[DescribeRegionsResponse]

      def describeReplaceRootVolumeTasks(
        request: DescribeReplaceRootVolumeTasksRequest
      ): F[DescribeReplaceRootVolumeTasksResponse]

      def describeReservedInstances(
        request: DescribeReservedInstancesRequest
      ): F[DescribeReservedInstancesResponse]

      def describeReservedInstancesListings(
        request: DescribeReservedInstancesListingsRequest
      ): F[DescribeReservedInstancesListingsResponse]

      def describeReservedInstancesModifications(
        request: DescribeReservedInstancesModificationsRequest
      ): F[DescribeReservedInstancesModificationsResponse]

      def describeReservedInstancesOfferings(
        request: DescribeReservedInstancesOfferingsRequest
      ): F[DescribeReservedInstancesOfferingsResponse]

      def describeRouteTables(
        request: DescribeRouteTablesRequest
      ): F[DescribeRouteTablesResponse]

      def describeScheduledInstanceAvailability(
        request: DescribeScheduledInstanceAvailabilityRequest
      ): F[DescribeScheduledInstanceAvailabilityResponse]

      def describeScheduledInstances(
        request: DescribeScheduledInstancesRequest
      ): F[DescribeScheduledInstancesResponse]

      def describeSecurityGroupReferences(
        request: DescribeSecurityGroupReferencesRequest
      ): F[DescribeSecurityGroupReferencesResponse]

      def describeSecurityGroups(
        request: DescribeSecurityGroupsRequest
      ): F[DescribeSecurityGroupsResponse]

      def describeSnapshotAttribute(
        request: DescribeSnapshotAttributeRequest
      ): F[DescribeSnapshotAttributeResponse]

      def describeSnapshots(
        request: DescribeSnapshotsRequest
      ): F[DescribeSnapshotsResponse]

      def describeSpotDatafeedSubscription(
        request: DescribeSpotDatafeedSubscriptionRequest
      ): F[DescribeSpotDatafeedSubscriptionResponse]

      def describeSpotFleetInstances(
        request: DescribeSpotFleetInstancesRequest
      ): F[DescribeSpotFleetInstancesResponse]

      def describeSpotFleetRequestHistory(
        request: DescribeSpotFleetRequestHistoryRequest
      ): F[DescribeSpotFleetRequestHistoryResponse]

      def describeSpotFleetRequests(
        request: DescribeSpotFleetRequestsRequest
      ): F[DescribeSpotFleetRequestsResponse]

      def describeSpotInstanceRequests(
        request: DescribeSpotInstanceRequestsRequest
      ): F[DescribeSpotInstanceRequestsResponse]

      def describeSpotPriceHistory(
        request: DescribeSpotPriceHistoryRequest
      ): F[DescribeSpotPriceHistoryResponse]

      def describeStaleSecurityGroups(
        request: DescribeStaleSecurityGroupsRequest
      ): F[DescribeStaleSecurityGroupsResponse]

      def describeStoreImageTasks(
        request: DescribeStoreImageTasksRequest
      ): F[DescribeStoreImageTasksResponse]

      def describeSubnets(
        request: DescribeSubnetsRequest
      ): F[DescribeSubnetsResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def describeTrafficMirrorFilters(
        request: DescribeTrafficMirrorFiltersRequest
      ): F[DescribeTrafficMirrorFiltersResponse]

      def describeTrafficMirrorSessions(
        request: DescribeTrafficMirrorSessionsRequest
      ): F[DescribeTrafficMirrorSessionsResponse]

      def describeTrafficMirrorTargets(
        request: DescribeTrafficMirrorTargetsRequest
      ): F[DescribeTrafficMirrorTargetsResponse]

      def describeTransitGatewayAttachments(
        request: DescribeTransitGatewayAttachmentsRequest
      ): F[DescribeTransitGatewayAttachmentsResponse]

      def describeTransitGatewayConnectPeers(
        request: DescribeTransitGatewayConnectPeersRequest
      ): F[DescribeTransitGatewayConnectPeersResponse]

      def describeTransitGatewayConnects(
        request: DescribeTransitGatewayConnectsRequest
      ): F[DescribeTransitGatewayConnectsResponse]

      def describeTransitGatewayMulticastDomains(
        request: DescribeTransitGatewayMulticastDomainsRequest
      ): F[DescribeTransitGatewayMulticastDomainsResponse]

      def describeTransitGatewayPeeringAttachments(
        request: DescribeTransitGatewayPeeringAttachmentsRequest
      ): F[DescribeTransitGatewayPeeringAttachmentsResponse]

      def describeTransitGatewayRouteTables(
        request: DescribeTransitGatewayRouteTablesRequest
      ): F[DescribeTransitGatewayRouteTablesResponse]

      def describeTransitGatewayVpcAttachments(
        request: DescribeTransitGatewayVpcAttachmentsRequest
      ): F[DescribeTransitGatewayVpcAttachmentsResponse]

      def describeTransitGateways(
        request: DescribeTransitGatewaysRequest
      ): F[DescribeTransitGatewaysResponse]

      def describeVolumeAttribute(
        request: DescribeVolumeAttributeRequest
      ): F[DescribeVolumeAttributeResponse]

      def describeVolumeStatus(
        request: DescribeVolumeStatusRequest
      ): F[DescribeVolumeStatusResponse]

      def describeVolumes(
        request: DescribeVolumesRequest
      ): F[DescribeVolumesResponse]

      def describeVolumesModifications(
        request: DescribeVolumesModificationsRequest
      ): F[DescribeVolumesModificationsResponse]

      def describeVpcAttribute(
        request: DescribeVpcAttributeRequest
      ): F[DescribeVpcAttributeResponse]

      def describeVpcClassicLink(
        request: DescribeVpcClassicLinkRequest
      ): F[DescribeVpcClassicLinkResponse]

      def describeVpcClassicLinkDnsSupport(
        request: DescribeVpcClassicLinkDnsSupportRequest
      ): F[DescribeVpcClassicLinkDnsSupportResponse]

      def describeVpcEndpointConnectionNotifications(
        request: DescribeVpcEndpointConnectionNotificationsRequest
      ): F[DescribeVpcEndpointConnectionNotificationsResponse]

      def describeVpcEndpointConnections(
        request: DescribeVpcEndpointConnectionsRequest
      ): F[DescribeVpcEndpointConnectionsResponse]

      def describeVpcEndpointServiceConfigurations(
        request: DescribeVpcEndpointServiceConfigurationsRequest
      ): F[DescribeVpcEndpointServiceConfigurationsResponse]

      def describeVpcEndpointServicePermissions(
        request: DescribeVpcEndpointServicePermissionsRequest
      ): F[DescribeVpcEndpointServicePermissionsResponse]

      def describeVpcEndpointServices(
        request: DescribeVpcEndpointServicesRequest
      ): F[DescribeVpcEndpointServicesResponse]

      def describeVpcEndpoints(
        request: DescribeVpcEndpointsRequest
      ): F[DescribeVpcEndpointsResponse]

      def describeVpcPeeringConnections(
        request: DescribeVpcPeeringConnectionsRequest
      ): F[DescribeVpcPeeringConnectionsResponse]

      def describeVpcs(
        request: DescribeVpcsRequest
      ): F[DescribeVpcsResponse]

      def describeVpnConnections(
        request: DescribeVpnConnectionsRequest
      ): F[DescribeVpnConnectionsResponse]

      def describeVpnGateways(
        request: DescribeVpnGatewaysRequest
      ): F[DescribeVpnGatewaysResponse]

      def detachClassicLinkVpc(
        request: DetachClassicLinkVpcRequest
      ): F[DetachClassicLinkVpcResponse]

      def detachInternetGateway(
        request: DetachInternetGatewayRequest
      ): F[DetachInternetGatewayResponse]

      def detachNetworkInterface(
        request: DetachNetworkInterfaceRequest
      ): F[DetachNetworkInterfaceResponse]

      def detachVolume(
        request: DetachVolumeRequest
      ): F[DetachVolumeResponse]

      def detachVpnGateway(
        request: DetachVpnGatewayRequest
      ): F[DetachVpnGatewayResponse]

      def disableEbsEncryptionByDefault(
        request: DisableEbsEncryptionByDefaultRequest
      ): F[DisableEbsEncryptionByDefaultResponse]

      def disableFastSnapshotRestores(
        request: DisableFastSnapshotRestoresRequest
      ): F[DisableFastSnapshotRestoresResponse]

      def disableImageDeprecation(
        request: DisableImageDeprecationRequest
      ): F[DisableImageDeprecationResponse]

      def disableSerialConsoleAccess(
        request: DisableSerialConsoleAccessRequest
      ): F[DisableSerialConsoleAccessResponse]

      def disableTransitGatewayRouteTablePropagation(
        request: DisableTransitGatewayRouteTablePropagationRequest
      ): F[DisableTransitGatewayRouteTablePropagationResponse]

      def disableVgwRoutePropagation(
        request: DisableVgwRoutePropagationRequest
      ): F[DisableVgwRoutePropagationResponse]

      def disableVpcClassicLink(
        request: DisableVpcClassicLinkRequest
      ): F[DisableVpcClassicLinkResponse]

      def disableVpcClassicLinkDnsSupport(
        request: DisableVpcClassicLinkDnsSupportRequest
      ): F[DisableVpcClassicLinkDnsSupportResponse]

      def disassociateAddress(
        request: DisassociateAddressRequest
      ): F[DisassociateAddressResponse]

      def disassociateClientVpnTargetNetwork(
        request: DisassociateClientVpnTargetNetworkRequest
      ): F[DisassociateClientVpnTargetNetworkResponse]

      def disassociateEnclaveCertificateIamRole(
        request: DisassociateEnclaveCertificateIamRoleRequest
      ): F[DisassociateEnclaveCertificateIamRoleResponse]

      def disassociateIamInstanceProfile(
        request: DisassociateIamInstanceProfileRequest
      ): F[DisassociateIamInstanceProfileResponse]

      def disassociateRouteTable(
        request: DisassociateRouteTableRequest
      ): F[DisassociateRouteTableResponse]

      def disassociateSubnetCidrBlock(
        request: DisassociateSubnetCidrBlockRequest
      ): F[DisassociateSubnetCidrBlockResponse]

      def disassociateTransitGatewayMulticastDomain(
        request: DisassociateTransitGatewayMulticastDomainRequest
      ): F[DisassociateTransitGatewayMulticastDomainResponse]

      def disassociateTransitGatewayRouteTable(
        request: DisassociateTransitGatewayRouteTableRequest
      ): F[DisassociateTransitGatewayRouteTableResponse]

      def disassociateVpcCidrBlock(
        request: DisassociateVpcCidrBlockRequest
      ): F[DisassociateVpcCidrBlockResponse]

      def enableEbsEncryptionByDefault(
        request: EnableEbsEncryptionByDefaultRequest
      ): F[EnableEbsEncryptionByDefaultResponse]

      def enableFastSnapshotRestores(
        request: EnableFastSnapshotRestoresRequest
      ): F[EnableFastSnapshotRestoresResponse]

      def enableImageDeprecation(
        request: EnableImageDeprecationRequest
      ): F[EnableImageDeprecationResponse]

      def enableSerialConsoleAccess(
        request: EnableSerialConsoleAccessRequest
      ): F[EnableSerialConsoleAccessResponse]

      def enableTransitGatewayRouteTablePropagation(
        request: EnableTransitGatewayRouteTablePropagationRequest
      ): F[EnableTransitGatewayRouteTablePropagationResponse]

      def enableVgwRoutePropagation(
        request: EnableVgwRoutePropagationRequest
      ): F[EnableVgwRoutePropagationResponse]

      def enableVolumeIO(
        request: EnableVolumeIoRequest
      ): F[EnableVolumeIoResponse]

      def enableVpcClassicLink(
        request: EnableVpcClassicLinkRequest
      ): F[EnableVpcClassicLinkResponse]

      def enableVpcClassicLinkDnsSupport(
        request: EnableVpcClassicLinkDnsSupportRequest
      ): F[EnableVpcClassicLinkDnsSupportResponse]

      def exportClientVpnClientCertificateRevocationList(
        request: ExportClientVpnClientCertificateRevocationListRequest
      ): F[ExportClientVpnClientCertificateRevocationListResponse]

      def exportClientVpnClientConfiguration(
        request: ExportClientVpnClientConfigurationRequest
      ): F[ExportClientVpnClientConfigurationResponse]

      def exportImage(
        request: ExportImageRequest
      ): F[ExportImageResponse]

      def exportTransitGatewayRoutes(
        request: ExportTransitGatewayRoutesRequest
      ): F[ExportTransitGatewayRoutesResponse]

      def getAssociatedEnclaveCertificateIamRoles(
        request: GetAssociatedEnclaveCertificateIamRolesRequest
      ): F[GetAssociatedEnclaveCertificateIamRolesResponse]

      def getAssociatedIpv6PoolCidrs(
        request: GetAssociatedIpv6PoolCidrsRequest
      ): F[GetAssociatedIpv6PoolCidrsResponse]

      def getCapacityReservationUsage(
        request: GetCapacityReservationUsageRequest
      ): F[GetCapacityReservationUsageResponse]

      def getCoipPoolUsage(
        request: GetCoipPoolUsageRequest
      ): F[GetCoipPoolUsageResponse]

      def getConsoleOutput(
        request: GetConsoleOutputRequest
      ): F[GetConsoleOutputResponse]

      def getConsoleScreenshot(
        request: GetConsoleScreenshotRequest
      ): F[GetConsoleScreenshotResponse]

      def getDefaultCreditSpecification(
        request: GetDefaultCreditSpecificationRequest
      ): F[GetDefaultCreditSpecificationResponse]

      def getEbsDefaultKmsKeyId(
        request: GetEbsDefaultKmsKeyIdRequest
      ): F[GetEbsDefaultKmsKeyIdResponse]

      def getEbsEncryptionByDefault(
        request: GetEbsEncryptionByDefaultRequest
      ): F[GetEbsEncryptionByDefaultResponse]

      def getFlowLogsIntegrationTemplate(
        request: GetFlowLogsIntegrationTemplateRequest
      ): F[GetFlowLogsIntegrationTemplateResponse]

      def getGroupsForCapacityReservation(
        request: GetGroupsForCapacityReservationRequest
      ): F[GetGroupsForCapacityReservationResponse]

      def getHostReservationPurchasePreview(
        request: GetHostReservationPurchasePreviewRequest
      ): F[GetHostReservationPurchasePreviewResponse]

      def getLaunchTemplateData(
        request: GetLaunchTemplateDataRequest
      ): F[GetLaunchTemplateDataResponse]

      def getManagedPrefixListAssociations(
        request: GetManagedPrefixListAssociationsRequest
      ): F[GetManagedPrefixListAssociationsResponse]

      def getManagedPrefixListEntries(
        request: GetManagedPrefixListEntriesRequest
      ): F[GetManagedPrefixListEntriesResponse]

      def getPasswordData(
        request: GetPasswordDataRequest
      ): F[GetPasswordDataResponse]

      def getReservedInstancesExchangeQuote(
        request: GetReservedInstancesExchangeQuoteRequest
      ): F[GetReservedInstancesExchangeQuoteResponse]

      def getSerialConsoleAccessStatus(
        request: GetSerialConsoleAccessStatusRequest
      ): F[GetSerialConsoleAccessStatusResponse]

      def getTransitGatewayAttachmentPropagations(
        request: GetTransitGatewayAttachmentPropagationsRequest
      ): F[GetTransitGatewayAttachmentPropagationsResponse]

      def getTransitGatewayMulticastDomainAssociations(
        request: GetTransitGatewayMulticastDomainAssociationsRequest
      ): F[GetTransitGatewayMulticastDomainAssociationsResponse]

      def getTransitGatewayPrefixListReferences(
        request: GetTransitGatewayPrefixListReferencesRequest
      ): F[GetTransitGatewayPrefixListReferencesResponse]

      def getTransitGatewayRouteTableAssociations(
        request: GetTransitGatewayRouteTableAssociationsRequest
      ): F[GetTransitGatewayRouteTableAssociationsResponse]

      def getTransitGatewayRouteTablePropagations(
        request: GetTransitGatewayRouteTablePropagationsRequest
      ): F[GetTransitGatewayRouteTablePropagationsResponse]

      def importClientVpnClientCertificateRevocationList(
        request: ImportClientVpnClientCertificateRevocationListRequest
      ): F[ImportClientVpnClientCertificateRevocationListResponse]

      def importImage(
        request: ImportImageRequest
      ): F[ImportImageResponse]

      def importInstance(
        request: ImportInstanceRequest
      ): F[ImportInstanceResponse]

      def importKeyPair(
        request: ImportKeyPairRequest
      ): F[ImportKeyPairResponse]

      def importSnapshot(
        request: ImportSnapshotRequest
      ): F[ImportSnapshotResponse]

      def importVolume(
        request: ImportVolumeRequest
      ): F[ImportVolumeResponse]

      def modifyAddressAttribute(
        request: ModifyAddressAttributeRequest
      ): F[ModifyAddressAttributeResponse]

      def modifyAvailabilityZoneGroup(
        request: ModifyAvailabilityZoneGroupRequest
      ): F[ModifyAvailabilityZoneGroupResponse]

      def modifyCapacityReservation(
        request: ModifyCapacityReservationRequest
      ): F[ModifyCapacityReservationResponse]

      def modifyClientVpnEndpoint(
        request: ModifyClientVpnEndpointRequest
      ): F[ModifyClientVpnEndpointResponse]

      def modifyDefaultCreditSpecification(
        request: ModifyDefaultCreditSpecificationRequest
      ): F[ModifyDefaultCreditSpecificationResponse]

      def modifyEbsDefaultKmsKeyId(
        request: ModifyEbsDefaultKmsKeyIdRequest
      ): F[ModifyEbsDefaultKmsKeyIdResponse]

      def modifyFleet(
        request: ModifyFleetRequest
      ): F[ModifyFleetResponse]

      def modifyFpgaImageAttribute(
        request: ModifyFpgaImageAttributeRequest
      ): F[ModifyFpgaImageAttributeResponse]

      def modifyHosts(
        request: ModifyHostsRequest
      ): F[ModifyHostsResponse]

      def modifyIdFormat(
        request: ModifyIdFormatRequest
      ): F[ModifyIdFormatResponse]

      def modifyIdentityIdFormat(
        request: ModifyIdentityIdFormatRequest
      ): F[ModifyIdentityIdFormatResponse]

      def modifyImageAttribute(
        request: ModifyImageAttributeRequest
      ): F[ModifyImageAttributeResponse]

      def modifyInstanceAttribute(
        request: ModifyInstanceAttributeRequest
      ): F[ModifyInstanceAttributeResponse]

      def modifyInstanceCapacityReservationAttributes(
        request: ModifyInstanceCapacityReservationAttributesRequest
      ): F[ModifyInstanceCapacityReservationAttributesResponse]

      def modifyInstanceCreditSpecification(
        request: ModifyInstanceCreditSpecificationRequest
      ): F[ModifyInstanceCreditSpecificationResponse]

      def modifyInstanceEventStartTime(
        request: ModifyInstanceEventStartTimeRequest
      ): F[ModifyInstanceEventStartTimeResponse]

      def modifyInstanceMetadataOptions(
        request: ModifyInstanceMetadataOptionsRequest
      ): F[ModifyInstanceMetadataOptionsResponse]

      def modifyInstancePlacement(
        request: ModifyInstancePlacementRequest
      ): F[ModifyInstancePlacementResponse]

      def modifyLaunchTemplate(
        request: ModifyLaunchTemplateRequest
      ): F[ModifyLaunchTemplateResponse]

      def modifyManagedPrefixList(
        request: ModifyManagedPrefixListRequest
      ): F[ModifyManagedPrefixListResponse]

      def modifyNetworkInterfaceAttribute(
        request: ModifyNetworkInterfaceAttributeRequest
      ): F[ModifyNetworkInterfaceAttributeResponse]

      def modifyReservedInstances(
        request: ModifyReservedInstancesRequest
      ): F[ModifyReservedInstancesResponse]

      def modifySnapshotAttribute(
        request: ModifySnapshotAttributeRequest
      ): F[ModifySnapshotAttributeResponse]

      def modifySpotFleetRequest(
        request: ModifySpotFleetRequestRequest
      ): F[ModifySpotFleetRequestResponse]

      def modifySubnetAttribute(
        request: ModifySubnetAttributeRequest
      ): F[ModifySubnetAttributeResponse]

      def modifyTrafficMirrorFilterNetworkServices(
        request: ModifyTrafficMirrorFilterNetworkServicesRequest
      ): F[ModifyTrafficMirrorFilterNetworkServicesResponse]

      def modifyTrafficMirrorFilterRule(
        request: ModifyTrafficMirrorFilterRuleRequest
      ): F[ModifyTrafficMirrorFilterRuleResponse]

      def modifyTrafficMirrorSession(
        request: ModifyTrafficMirrorSessionRequest
      ): F[ModifyTrafficMirrorSessionResponse]

      def modifyTransitGateway(
        request: ModifyTransitGatewayRequest
      ): F[ModifyTransitGatewayResponse]

      def modifyTransitGatewayPrefixListReference(
        request: ModifyTransitGatewayPrefixListReferenceRequest
      ): F[ModifyTransitGatewayPrefixListReferenceResponse]

      def modifyTransitGatewayVpcAttachment(
        request: ModifyTransitGatewayVpcAttachmentRequest
      ): F[ModifyTransitGatewayVpcAttachmentResponse]

      def modifyVolume(
        request: ModifyVolumeRequest
      ): F[ModifyVolumeResponse]

      def modifyVolumeAttribute(
        request: ModifyVolumeAttributeRequest
      ): F[ModifyVolumeAttributeResponse]

      def modifyVpcAttribute(
        request: ModifyVpcAttributeRequest
      ): F[ModifyVpcAttributeResponse]

      def modifyVpcEndpoint(
        request: ModifyVpcEndpointRequest
      ): F[ModifyVpcEndpointResponse]

      def modifyVpcEndpointConnectionNotification(
        request: ModifyVpcEndpointConnectionNotificationRequest
      ): F[ModifyVpcEndpointConnectionNotificationResponse]

      def modifyVpcEndpointServiceConfiguration(
        request: ModifyVpcEndpointServiceConfigurationRequest
      ): F[ModifyVpcEndpointServiceConfigurationResponse]

      def modifyVpcEndpointServicePermissions(
        request: ModifyVpcEndpointServicePermissionsRequest
      ): F[ModifyVpcEndpointServicePermissionsResponse]

      def modifyVpcPeeringConnectionOptions(
        request: ModifyVpcPeeringConnectionOptionsRequest
      ): F[ModifyVpcPeeringConnectionOptionsResponse]

      def modifyVpcTenancy(
        request: ModifyVpcTenancyRequest
      ): F[ModifyVpcTenancyResponse]

      def modifyVpnConnection(
        request: ModifyVpnConnectionRequest
      ): F[ModifyVpnConnectionResponse]

      def modifyVpnConnectionOptions(
        request: ModifyVpnConnectionOptionsRequest
      ): F[ModifyVpnConnectionOptionsResponse]

      def modifyVpnTunnelCertificate(
        request: ModifyVpnTunnelCertificateRequest
      ): F[ModifyVpnTunnelCertificateResponse]

      def modifyVpnTunnelOptions(
        request: ModifyVpnTunnelOptionsRequest
      ): F[ModifyVpnTunnelOptionsResponse]

      def monitorInstances(
        request: MonitorInstancesRequest
      ): F[MonitorInstancesResponse]

      def moveAddressToVpc(
        request: MoveAddressToVpcRequest
      ): F[MoveAddressToVpcResponse]

      def provisionByoipCidr(
        request: ProvisionByoipCidrRequest
      ): F[ProvisionByoipCidrResponse]

      def purchaseHostReservation(
        request: PurchaseHostReservationRequest
      ): F[PurchaseHostReservationResponse]

      def purchaseReservedInstancesOffering(
        request: PurchaseReservedInstancesOfferingRequest
      ): F[PurchaseReservedInstancesOfferingResponse]

      def purchaseScheduledInstances(
        request: PurchaseScheduledInstancesRequest
      ): F[PurchaseScheduledInstancesResponse]

      def rebootInstances(
        request: RebootInstancesRequest
      ): F[RebootInstancesResponse]

      def registerImage(
        request: RegisterImageRequest
      ): F[RegisterImageResponse]

      def registerInstanceEventNotificationAttributes(
        request: RegisterInstanceEventNotificationAttributesRequest
      ): F[RegisterInstanceEventNotificationAttributesResponse]

      def registerTransitGatewayMulticastGroupMembers(
        request: RegisterTransitGatewayMulticastGroupMembersRequest
      ): F[RegisterTransitGatewayMulticastGroupMembersResponse]

      def registerTransitGatewayMulticastGroupSources(
        request: RegisterTransitGatewayMulticastGroupSourcesRequest
      ): F[RegisterTransitGatewayMulticastGroupSourcesResponse]

      def rejectTransitGatewayMulticastDomainAssociations(
        request: RejectTransitGatewayMulticastDomainAssociationsRequest
      ): F[RejectTransitGatewayMulticastDomainAssociationsResponse]

      def rejectTransitGatewayPeeringAttachment(
        request: RejectTransitGatewayPeeringAttachmentRequest
      ): F[RejectTransitGatewayPeeringAttachmentResponse]

      def rejectTransitGatewayVpcAttachment(
        request: RejectTransitGatewayVpcAttachmentRequest
      ): F[RejectTransitGatewayVpcAttachmentResponse]

      def rejectVpcEndpointConnections(
        request: RejectVpcEndpointConnectionsRequest
      ): F[RejectVpcEndpointConnectionsResponse]

      def rejectVpcPeeringConnection(
        request: RejectVpcPeeringConnectionRequest
      ): F[RejectVpcPeeringConnectionResponse]

      def releaseAddress(
        request: ReleaseAddressRequest
      ): F[ReleaseAddressResponse]

      def releaseHosts(
        request: ReleaseHostsRequest
      ): F[ReleaseHostsResponse]

      def replaceIamInstanceProfileAssociation(
        request: ReplaceIamInstanceProfileAssociationRequest
      ): F[ReplaceIamInstanceProfileAssociationResponse]

      def replaceNetworkAclAssociation(
        request: ReplaceNetworkAclAssociationRequest
      ): F[ReplaceNetworkAclAssociationResponse]

      def replaceNetworkAclEntry(
        request: ReplaceNetworkAclEntryRequest
      ): F[ReplaceNetworkAclEntryResponse]

      def replaceRoute(
        request: ReplaceRouteRequest
      ): F[ReplaceRouteResponse]

      def replaceRouteTableAssociation(
        request: ReplaceRouteTableAssociationRequest
      ): F[ReplaceRouteTableAssociationResponse]

      def replaceTransitGatewayRoute(
        request: ReplaceTransitGatewayRouteRequest
      ): F[ReplaceTransitGatewayRouteResponse]

      def reportInstanceStatus(
        request: ReportInstanceStatusRequest
      ): F[ReportInstanceStatusResponse]

      def requestSpotFleet(
        request: RequestSpotFleetRequest
      ): F[RequestSpotFleetResponse]

      def requestSpotInstances(
        request: RequestSpotInstancesRequest
      ): F[RequestSpotInstancesResponse]

      def resetAddressAttribute(
        request: ResetAddressAttributeRequest
      ): F[ResetAddressAttributeResponse]

      def resetEbsDefaultKmsKeyId(
        request: ResetEbsDefaultKmsKeyIdRequest
      ): F[ResetEbsDefaultKmsKeyIdResponse]

      def resetFpgaImageAttribute(
        request: ResetFpgaImageAttributeRequest
      ): F[ResetFpgaImageAttributeResponse]

      def resetImageAttribute(
        request: ResetImageAttributeRequest
      ): F[ResetImageAttributeResponse]

      def resetInstanceAttribute(
        request: ResetInstanceAttributeRequest
      ): F[ResetInstanceAttributeResponse]

      def resetNetworkInterfaceAttribute(
        request: ResetNetworkInterfaceAttributeRequest
      ): F[ResetNetworkInterfaceAttributeResponse]

      def resetSnapshotAttribute(
        request: ResetSnapshotAttributeRequest
      ): F[ResetSnapshotAttributeResponse]

      def restoreAddressToClassic(
        request: RestoreAddressToClassicRequest
      ): F[RestoreAddressToClassicResponse]

      def restoreManagedPrefixListVersion(
        request: RestoreManagedPrefixListVersionRequest
      ): F[RestoreManagedPrefixListVersionResponse]

      def revokeClientVpnIngress(
        request: RevokeClientVpnIngressRequest
      ): F[RevokeClientVpnIngressResponse]

      def revokeSecurityGroupEgress(
        request: RevokeSecurityGroupEgressRequest
      ): F[RevokeSecurityGroupEgressResponse]

      def revokeSecurityGroupIngress(
        request: RevokeSecurityGroupIngressRequest
      ): F[RevokeSecurityGroupIngressResponse]

      def runInstances(
        request: RunInstancesRequest
      ): F[RunInstancesResponse]

      def runScheduledInstances(
        request: RunScheduledInstancesRequest
      ): F[RunScheduledInstancesResponse]

      def searchLocalGatewayRoutes(
        request: SearchLocalGatewayRoutesRequest
      ): F[SearchLocalGatewayRoutesResponse]

      def searchTransitGatewayMulticastGroups(
        request: SearchTransitGatewayMulticastGroupsRequest
      ): F[SearchTransitGatewayMulticastGroupsResponse]

      def searchTransitGatewayRoutes(
        request: SearchTransitGatewayRoutesRequest
      ): F[SearchTransitGatewayRoutesResponse]

      def sendDiagnosticInterrupt(
        request: SendDiagnosticInterruptRequest
      ): F[SendDiagnosticInterruptResponse]

      def startInstances(
        request: StartInstancesRequest
      ): F[StartInstancesResponse]

      def startNetworkInsightsAnalysis(
        request: StartNetworkInsightsAnalysisRequest
      ): F[StartNetworkInsightsAnalysisResponse]

      def startVpcEndpointServicePrivateDnsVerification(
        request: StartVpcEndpointServicePrivateDnsVerificationRequest
      ): F[StartVpcEndpointServicePrivateDnsVerificationResponse]

      def stopInstances(
        request: StopInstancesRequest
      ): F[StopInstancesResponse]

      def terminateClientVpnConnections(
        request: TerminateClientVpnConnectionsRequest
      ): F[TerminateClientVpnConnectionsResponse]

      def terminateInstances(
        request: TerminateInstancesRequest
      ): F[TerminateInstancesResponse]

      def unassignIpv6Addresses(
        request: UnassignIpv6AddressesRequest
      ): F[UnassignIpv6AddressesResponse]

      def unassignPrivateIpAddresses(
        request: UnassignPrivateIpAddressesRequest
      ): F[UnassignPrivateIpAddressesResponse]

      def unmonitorInstances(
        request: UnmonitorInstancesRequest
      ): F[UnmonitorInstancesResponse]

      def updateSecurityGroupRuleDescriptionsEgress(
        request: UpdateSecurityGroupRuleDescriptionsEgressRequest
      ): F[UpdateSecurityGroupRuleDescriptionsEgressResponse]

      def updateSecurityGroupRuleDescriptionsIngress(
        request: UpdateSecurityGroupRuleDescriptionsIngressRequest
      ): F[UpdateSecurityGroupRuleDescriptionsIngressResponse]

      def withdrawByoipCidr(
        request: WithdrawByoipCidrRequest
      ): F[WithdrawByoipCidrResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Ec2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptReservedInstancesExchangeQuote(
      request: AcceptReservedInstancesExchangeQuoteRequest
    ) extends Ec2Op[AcceptReservedInstancesExchangeQuoteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptReservedInstancesExchangeQuoteResponse] =
        visitor.acceptReservedInstancesExchangeQuote(request)
    }

    final case class AcceptTransitGatewayMulticastDomainAssociations(
      request: AcceptTransitGatewayMulticastDomainAssociationsRequest
    ) extends Ec2Op[AcceptTransitGatewayMulticastDomainAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptTransitGatewayMulticastDomainAssociationsResponse] =
        visitor.acceptTransitGatewayMulticastDomainAssociations(request)
    }

    final case class AcceptTransitGatewayPeeringAttachment(
      request: AcceptTransitGatewayPeeringAttachmentRequest
    ) extends Ec2Op[AcceptTransitGatewayPeeringAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptTransitGatewayPeeringAttachmentResponse] =
        visitor.acceptTransitGatewayPeeringAttachment(request)
    }

    final case class AcceptTransitGatewayVpcAttachment(
      request: AcceptTransitGatewayVpcAttachmentRequest
    ) extends Ec2Op[AcceptTransitGatewayVpcAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptTransitGatewayVpcAttachmentResponse] =
        visitor.acceptTransitGatewayVpcAttachment(request)
    }

    final case class AcceptVpcEndpointConnections(
      request: AcceptVpcEndpointConnectionsRequest
    ) extends Ec2Op[AcceptVpcEndpointConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptVpcEndpointConnectionsResponse] =
        visitor.acceptVpcEndpointConnections(request)
    }

    final case class AcceptVpcPeeringConnection(
      request: AcceptVpcPeeringConnectionRequest
    ) extends Ec2Op[AcceptVpcPeeringConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptVpcPeeringConnectionResponse] =
        visitor.acceptVpcPeeringConnection(request)
    }

    final case class AdvertiseByoipCidr(
      request: AdvertiseByoipCidrRequest
    ) extends Ec2Op[AdvertiseByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdvertiseByoipCidrResponse] =
        visitor.advertiseByoipCidr(request)
    }

    final case class AllocateAddress(
      request: AllocateAddressRequest
    ) extends Ec2Op[AllocateAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllocateAddressResponse] =
        visitor.allocateAddress(request)
    }

    final case class AllocateHosts(
      request: AllocateHostsRequest
    ) extends Ec2Op[AllocateHostsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllocateHostsResponse] =
        visitor.allocateHosts(request)
    }

    final case class ApplySecurityGroupsToClientVpnTargetNetwork(
      request: ApplySecurityGroupsToClientVpnTargetNetworkRequest
    ) extends Ec2Op[ApplySecurityGroupsToClientVpnTargetNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplySecurityGroupsToClientVpnTargetNetworkResponse] =
        visitor.applySecurityGroupsToClientVpnTargetNetwork(request)
    }

    final case class AssignIpv6Addresses(
      request: AssignIpv6AddressesRequest
    ) extends Ec2Op[AssignIpv6AddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssignIpv6AddressesResponse] =
        visitor.assignIpv6Addresses(request)
    }

    final case class AssignPrivateIpAddresses(
      request: AssignPrivateIpAddressesRequest
    ) extends Ec2Op[AssignPrivateIpAddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssignPrivateIpAddressesResponse] =
        visitor.assignPrivateIpAddresses(request)
    }

    final case class AssociateAddress(
      request: AssociateAddressRequest
    ) extends Ec2Op[AssociateAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateAddressResponse] =
        visitor.associateAddress(request)
    }

    final case class AssociateClientVpnTargetNetwork(
      request: AssociateClientVpnTargetNetworkRequest
    ) extends Ec2Op[AssociateClientVpnTargetNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateClientVpnTargetNetworkResponse] =
        visitor.associateClientVpnTargetNetwork(request)
    }

    final case class AssociateDhcpOptions(
      request: AssociateDhcpOptionsRequest
    ) extends Ec2Op[AssociateDhcpOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDhcpOptionsResponse] =
        visitor.associateDhcpOptions(request)
    }

    final case class AssociateEnclaveCertificateIamRole(
      request: AssociateEnclaveCertificateIamRoleRequest
    ) extends Ec2Op[AssociateEnclaveCertificateIamRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateEnclaveCertificateIamRoleResponse] =
        visitor.associateEnclaveCertificateIamRole(request)
    }

    final case class AssociateIamInstanceProfile(
      request: AssociateIamInstanceProfileRequest
    ) extends Ec2Op[AssociateIamInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateIamInstanceProfileResponse] =
        visitor.associateIamInstanceProfile(request)
    }

    final case class AssociateRouteTable(
      request: AssociateRouteTableRequest
    ) extends Ec2Op[AssociateRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateRouteTableResponse] =
        visitor.associateRouteTable(request)
    }

    final case class AssociateSubnetCidrBlock(
      request: AssociateSubnetCidrBlockRequest
    ) extends Ec2Op[AssociateSubnetCidrBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSubnetCidrBlockResponse] =
        visitor.associateSubnetCidrBlock(request)
    }

    final case class AssociateTransitGatewayMulticastDomain(
      request: AssociateTransitGatewayMulticastDomainRequest
    ) extends Ec2Op[AssociateTransitGatewayMulticastDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTransitGatewayMulticastDomainResponse] =
        visitor.associateTransitGatewayMulticastDomain(request)
    }

    final case class AssociateTransitGatewayRouteTable(
      request: AssociateTransitGatewayRouteTableRequest
    ) extends Ec2Op[AssociateTransitGatewayRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTransitGatewayRouteTableResponse] =
        visitor.associateTransitGatewayRouteTable(request)
    }

    final case class AssociateVpcCidrBlock(
      request: AssociateVpcCidrBlockRequest
    ) extends Ec2Op[AssociateVpcCidrBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateVpcCidrBlockResponse] =
        visitor.associateVpcCidrBlock(request)
    }

    final case class AttachClassicLinkVpc(
      request: AttachClassicLinkVpcRequest
    ) extends Ec2Op[AttachClassicLinkVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachClassicLinkVpcResponse] =
        visitor.attachClassicLinkVpc(request)
    }

    final case class AttachInternetGateway(
      request: AttachInternetGatewayRequest
    ) extends Ec2Op[AttachInternetGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachInternetGatewayResponse] =
        visitor.attachInternetGateway(request)
    }

    final case class AttachNetworkInterface(
      request: AttachNetworkInterfaceRequest
    ) extends Ec2Op[AttachNetworkInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachNetworkInterfaceResponse] =
        visitor.attachNetworkInterface(request)
    }

    final case class AttachVolume(
      request: AttachVolumeRequest
    ) extends Ec2Op[AttachVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachVolumeResponse] =
        visitor.attachVolume(request)
    }

    final case class AttachVpnGateway(
      request: AttachVpnGatewayRequest
    ) extends Ec2Op[AttachVpnGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachVpnGatewayResponse] =
        visitor.attachVpnGateway(request)
    }

    final case class AuthorizeClientVpnIngress(
      request: AuthorizeClientVpnIngressRequest
    ) extends Ec2Op[AuthorizeClientVpnIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeClientVpnIngressResponse] =
        visitor.authorizeClientVpnIngress(request)
    }

    final case class AuthorizeSecurityGroupEgress(
      request: AuthorizeSecurityGroupEgressRequest
    ) extends Ec2Op[AuthorizeSecurityGroupEgressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeSecurityGroupEgressResponse] =
        visitor.authorizeSecurityGroupEgress(request)
    }

    final case class AuthorizeSecurityGroupIngress(
      request: AuthorizeSecurityGroupIngressRequest
    ) extends Ec2Op[AuthorizeSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeSecurityGroupIngressResponse] =
        visitor.authorizeSecurityGroupIngress(request)
    }

    final case class BundleInstance(
      request: BundleInstanceRequest
    ) extends Ec2Op[BundleInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BundleInstanceResponse] =
        visitor.bundleInstance(request)
    }

    final case class CancelBundleTask(
      request: CancelBundleTaskRequest
    ) extends Ec2Op[CancelBundleTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelBundleTaskResponse] =
        visitor.cancelBundleTask(request)
    }

    final case class CancelCapacityReservation(
      request: CancelCapacityReservationRequest
    ) extends Ec2Op[CancelCapacityReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelCapacityReservationResponse] =
        visitor.cancelCapacityReservation(request)
    }

    final case class CancelConversionTask(
      request: CancelConversionTaskRequest
    ) extends Ec2Op[CancelConversionTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelConversionTaskResponse] =
        visitor.cancelConversionTask(request)
    }

    final case class CancelExportTask(
      request: CancelExportTaskRequest
    ) extends Ec2Op[CancelExportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelExportTaskResponse] =
        visitor.cancelExportTask(request)
    }

    final case class CancelImportTask(
      request: CancelImportTaskRequest
    ) extends Ec2Op[CancelImportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelImportTaskResponse] =
        visitor.cancelImportTask(request)
    }

    final case class CancelReservedInstancesListing(
      request: CancelReservedInstancesListingRequest
    ) extends Ec2Op[CancelReservedInstancesListingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelReservedInstancesListingResponse] =
        visitor.cancelReservedInstancesListing(request)
    }

    final case class CancelSpotFleetRequests(
      request: CancelSpotFleetRequestsRequest
    ) extends Ec2Op[CancelSpotFleetRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelSpotFleetRequestsResponse] =
        visitor.cancelSpotFleetRequests(request)
    }

    final case class CancelSpotInstanceRequests(
      request: CancelSpotInstanceRequestsRequest
    ) extends Ec2Op[CancelSpotInstanceRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelSpotInstanceRequestsResponse] =
        visitor.cancelSpotInstanceRequests(request)
    }

    final case class ConfirmProductInstance(
      request: ConfirmProductInstanceRequest
    ) extends Ec2Op[ConfirmProductInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmProductInstanceResponse] =
        visitor.confirmProductInstance(request)
    }

    final case class CopyFpgaImage(
      request: CopyFpgaImageRequest
    ) extends Ec2Op[CopyFpgaImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyFpgaImageResponse] =
        visitor.copyFpgaImage(request)
    }

    final case class CopyImage(
      request: CopyImageRequest
    ) extends Ec2Op[CopyImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyImageResponse] =
        visitor.copyImage(request)
    }

    final case class CopySnapshot(
      request: CopySnapshotRequest
    ) extends Ec2Op[CopySnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopySnapshotResponse] =
        visitor.copySnapshot(request)
    }

    final case class CreateCapacityReservation(
      request: CreateCapacityReservationRequest
    ) extends Ec2Op[CreateCapacityReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCapacityReservationResponse] =
        visitor.createCapacityReservation(request)
    }

    final case class CreateCarrierGateway(
      request: CreateCarrierGatewayRequest
    ) extends Ec2Op[CreateCarrierGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCarrierGatewayResponse] =
        visitor.createCarrierGateway(request)
    }

    final case class CreateClientVpnEndpoint(
      request: CreateClientVpnEndpointRequest
    ) extends Ec2Op[CreateClientVpnEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClientVpnEndpointResponse] =
        visitor.createClientVpnEndpoint(request)
    }

    final case class CreateClientVpnRoute(
      request: CreateClientVpnRouteRequest
    ) extends Ec2Op[CreateClientVpnRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClientVpnRouteResponse] =
        visitor.createClientVpnRoute(request)
    }

    final case class CreateCustomerGateway(
      request: CreateCustomerGatewayRequest
    ) extends Ec2Op[CreateCustomerGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomerGatewayResponse] =
        visitor.createCustomerGateway(request)
    }

    final case class CreateDefaultSubnet(
      request: CreateDefaultSubnetRequest
    ) extends Ec2Op[CreateDefaultSubnetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDefaultSubnetResponse] =
        visitor.createDefaultSubnet(request)
    }

    final case class CreateDefaultVpc(
      request: CreateDefaultVpcRequest
    ) extends Ec2Op[CreateDefaultVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDefaultVpcResponse] =
        visitor.createDefaultVpc(request)
    }

    final case class CreateDhcpOptions(
      request: CreateDhcpOptionsRequest
    ) extends Ec2Op[CreateDhcpOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDhcpOptionsResponse] =
        visitor.createDhcpOptions(request)
    }

    final case class CreateEgressOnlyInternetGateway(
      request: CreateEgressOnlyInternetGatewayRequest
    ) extends Ec2Op[CreateEgressOnlyInternetGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEgressOnlyInternetGatewayResponse] =
        visitor.createEgressOnlyInternetGateway(request)
    }

    final case class CreateFleet(
      request: CreateFleetRequest
    ) extends Ec2Op[CreateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFleetResponse] =
        visitor.createFleet(request)
    }

    final case class CreateFlowLogs(
      request: CreateFlowLogsRequest
    ) extends Ec2Op[CreateFlowLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFlowLogsResponse] =
        visitor.createFlowLogs(request)
    }

    final case class CreateFpgaImage(
      request: CreateFpgaImageRequest
    ) extends Ec2Op[CreateFpgaImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFpgaImageResponse] =
        visitor.createFpgaImage(request)
    }

    final case class CreateImage(
      request: CreateImageRequest
    ) extends Ec2Op[CreateImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImageResponse] =
        visitor.createImage(request)
    }

    final case class CreateInstanceExportTask(
      request: CreateInstanceExportTaskRequest
    ) extends Ec2Op[CreateInstanceExportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstanceExportTaskResponse] =
        visitor.createInstanceExportTask(request)
    }

    final case class CreateInternetGateway(
      request: CreateInternetGatewayRequest
    ) extends Ec2Op[CreateInternetGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInternetGatewayResponse] =
        visitor.createInternetGateway(request)
    }

    final case class CreateKeyPair(
      request: CreateKeyPairRequest
    ) extends Ec2Op[CreateKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateKeyPairResponse] =
        visitor.createKeyPair(request)
    }

    final case class CreateLaunchTemplate(
      request: CreateLaunchTemplateRequest
    ) extends Ec2Op[CreateLaunchTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLaunchTemplateResponse] =
        visitor.createLaunchTemplate(request)
    }

    final case class CreateLaunchTemplateVersion(
      request: CreateLaunchTemplateVersionRequest
    ) extends Ec2Op[CreateLaunchTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLaunchTemplateVersionResponse] =
        visitor.createLaunchTemplateVersion(request)
    }

    final case class CreateLocalGatewayRoute(
      request: CreateLocalGatewayRouteRequest
    ) extends Ec2Op[CreateLocalGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocalGatewayRouteResponse] =
        visitor.createLocalGatewayRoute(request)
    }

    final case class CreateLocalGatewayRouteTableVpcAssociation(
      request: CreateLocalGatewayRouteTableVpcAssociationRequest
    ) extends Ec2Op[CreateLocalGatewayRouteTableVpcAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocalGatewayRouteTableVpcAssociationResponse] =
        visitor.createLocalGatewayRouteTableVpcAssociation(request)
    }

    final case class CreateManagedPrefixList(
      request: CreateManagedPrefixListRequest
    ) extends Ec2Op[CreateManagedPrefixListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateManagedPrefixListResponse] =
        visitor.createManagedPrefixList(request)
    }

    final case class CreateNatGateway(
      request: CreateNatGatewayRequest
    ) extends Ec2Op[CreateNatGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNatGatewayResponse] =
        visitor.createNatGateway(request)
    }

    final case class CreateNetworkAcl(
      request: CreateNetworkAclRequest
    ) extends Ec2Op[CreateNetworkAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkAclResponse] =
        visitor.createNetworkAcl(request)
    }

    final case class CreateNetworkAclEntry(
      request: CreateNetworkAclEntryRequest
    ) extends Ec2Op[CreateNetworkAclEntryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkAclEntryResponse] =
        visitor.createNetworkAclEntry(request)
    }

    final case class CreateNetworkInsightsPath(
      request: CreateNetworkInsightsPathRequest
    ) extends Ec2Op[CreateNetworkInsightsPathResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkInsightsPathResponse] =
        visitor.createNetworkInsightsPath(request)
    }

    final case class CreateNetworkInterface(
      request: CreateNetworkInterfaceRequest
    ) extends Ec2Op[CreateNetworkInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkInterfaceResponse] =
        visitor.createNetworkInterface(request)
    }

    final case class CreateNetworkInterfacePermission(
      request: CreateNetworkInterfacePermissionRequest
    ) extends Ec2Op[CreateNetworkInterfacePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkInterfacePermissionResponse] =
        visitor.createNetworkInterfacePermission(request)
    }

    final case class CreatePlacementGroup(
      request: CreatePlacementGroupRequest
    ) extends Ec2Op[CreatePlacementGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlacementGroupResponse] =
        visitor.createPlacementGroup(request)
    }

    final case class CreateReplaceRootVolumeTask(
      request: CreateReplaceRootVolumeTaskRequest
    ) extends Ec2Op[CreateReplaceRootVolumeTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplaceRootVolumeTaskResponse] =
        visitor.createReplaceRootVolumeTask(request)
    }

    final case class CreateReservedInstancesListing(
      request: CreateReservedInstancesListingRequest
    ) extends Ec2Op[CreateReservedInstancesListingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReservedInstancesListingResponse] =
        visitor.createReservedInstancesListing(request)
    }

    final case class CreateRestoreImageTask(
      request: CreateRestoreImageTaskRequest
    ) extends Ec2Op[CreateRestoreImageTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRestoreImageTaskResponse] =
        visitor.createRestoreImageTask(request)
    }

    final case class CreateRoute(
      request: CreateRouteRequest
    ) extends Ec2Op[CreateRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRouteResponse] =
        visitor.createRoute(request)
    }

    final case class CreateRouteTable(
      request: CreateRouteTableRequest
    ) extends Ec2Op[CreateRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRouteTableResponse] =
        visitor.createRouteTable(request)
    }

    final case class CreateSecurityGroup(
      request: CreateSecurityGroupRequest
    ) extends Ec2Op[CreateSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSecurityGroupResponse] =
        visitor.createSecurityGroup(request)
    }

    final case class CreateSnapshot(
      request: CreateSnapshotRequest
    ) extends Ec2Op[CreateSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotResponse] =
        visitor.createSnapshot(request)
    }

    final case class CreateSnapshots(
      request: CreateSnapshotsRequest
    ) extends Ec2Op[CreateSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotsResponse] =
        visitor.createSnapshots(request)
    }

    final case class CreateSpotDatafeedSubscription(
      request: CreateSpotDatafeedSubscriptionRequest
    ) extends Ec2Op[CreateSpotDatafeedSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSpotDatafeedSubscriptionResponse] =
        visitor.createSpotDatafeedSubscription(request)
    }

    final case class CreateStoreImageTask(
      request: CreateStoreImageTaskRequest
    ) extends Ec2Op[CreateStoreImageTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStoreImageTaskResponse] =
        visitor.createStoreImageTask(request)
    }

    final case class CreateSubnet(
      request: CreateSubnetRequest
    ) extends Ec2Op[CreateSubnetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSubnetResponse] =
        visitor.createSubnet(request)
    }

    final case class CreateTags(
      request: CreateTagsRequest
    ) extends Ec2Op[CreateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTagsResponse] =
        visitor.createTags(request)
    }

    final case class CreateTrafficMirrorFilter(
      request: CreateTrafficMirrorFilterRequest
    ) extends Ec2Op[CreateTrafficMirrorFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrafficMirrorFilterResponse] =
        visitor.createTrafficMirrorFilter(request)
    }

    final case class CreateTrafficMirrorFilterRule(
      request: CreateTrafficMirrorFilterRuleRequest
    ) extends Ec2Op[CreateTrafficMirrorFilterRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrafficMirrorFilterRuleResponse] =
        visitor.createTrafficMirrorFilterRule(request)
    }

    final case class CreateTrafficMirrorSession(
      request: CreateTrafficMirrorSessionRequest
    ) extends Ec2Op[CreateTrafficMirrorSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrafficMirrorSessionResponse] =
        visitor.createTrafficMirrorSession(request)
    }

    final case class CreateTrafficMirrorTarget(
      request: CreateTrafficMirrorTargetRequest
    ) extends Ec2Op[CreateTrafficMirrorTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrafficMirrorTargetResponse] =
        visitor.createTrafficMirrorTarget(request)
    }

    final case class CreateTransitGateway(
      request: CreateTransitGatewayRequest
    ) extends Ec2Op[CreateTransitGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayResponse] =
        visitor.createTransitGateway(request)
    }

    final case class CreateTransitGatewayConnect(
      request: CreateTransitGatewayConnectRequest
    ) extends Ec2Op[CreateTransitGatewayConnectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayConnectResponse] =
        visitor.createTransitGatewayConnect(request)
    }

    final case class CreateTransitGatewayConnectPeer(
      request: CreateTransitGatewayConnectPeerRequest
    ) extends Ec2Op[CreateTransitGatewayConnectPeerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayConnectPeerResponse] =
        visitor.createTransitGatewayConnectPeer(request)
    }

    final case class CreateTransitGatewayMulticastDomain(
      request: CreateTransitGatewayMulticastDomainRequest
    ) extends Ec2Op[CreateTransitGatewayMulticastDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayMulticastDomainResponse] =
        visitor.createTransitGatewayMulticastDomain(request)
    }

    final case class CreateTransitGatewayPeeringAttachment(
      request: CreateTransitGatewayPeeringAttachmentRequest
    ) extends Ec2Op[CreateTransitGatewayPeeringAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayPeeringAttachmentResponse] =
        visitor.createTransitGatewayPeeringAttachment(request)
    }

    final case class CreateTransitGatewayPrefixListReference(
      request: CreateTransitGatewayPrefixListReferenceRequest
    ) extends Ec2Op[CreateTransitGatewayPrefixListReferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayPrefixListReferenceResponse] =
        visitor.createTransitGatewayPrefixListReference(request)
    }

    final case class CreateTransitGatewayRoute(
      request: CreateTransitGatewayRouteRequest
    ) extends Ec2Op[CreateTransitGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayRouteResponse] =
        visitor.createTransitGatewayRoute(request)
    }

    final case class CreateTransitGatewayRouteTable(
      request: CreateTransitGatewayRouteTableRequest
    ) extends Ec2Op[CreateTransitGatewayRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayRouteTableResponse] =
        visitor.createTransitGatewayRouteTable(request)
    }

    final case class CreateTransitGatewayVpcAttachment(
      request: CreateTransitGatewayVpcAttachmentRequest
    ) extends Ec2Op[CreateTransitGatewayVpcAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitGatewayVpcAttachmentResponse] =
        visitor.createTransitGatewayVpcAttachment(request)
    }

    final case class CreateVolume(
      request: CreateVolumeRequest
    ) extends Ec2Op[CreateVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVolumeResponse] =
        visitor.createVolume(request)
    }

    final case class CreateVpc(
      request: CreateVpcRequest
    ) extends Ec2Op[CreateVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcResponse] =
        visitor.createVpc(request)
    }

    final case class CreateVpcEndpoint(
      request: CreateVpcEndpointRequest
    ) extends Ec2Op[CreateVpcEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcEndpointResponse] =
        visitor.createVpcEndpoint(request)
    }

    final case class CreateVpcEndpointConnectionNotification(
      request: CreateVpcEndpointConnectionNotificationRequest
    ) extends Ec2Op[CreateVpcEndpointConnectionNotificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcEndpointConnectionNotificationResponse] =
        visitor.createVpcEndpointConnectionNotification(request)
    }

    final case class CreateVpcEndpointServiceConfiguration(
      request: CreateVpcEndpointServiceConfigurationRequest
    ) extends Ec2Op[CreateVpcEndpointServiceConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcEndpointServiceConfigurationResponse] =
        visitor.createVpcEndpointServiceConfiguration(request)
    }

    final case class CreateVpcPeeringConnection(
      request: CreateVpcPeeringConnectionRequest
    ) extends Ec2Op[CreateVpcPeeringConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcPeeringConnectionResponse] =
        visitor.createVpcPeeringConnection(request)
    }

    final case class CreateVpnConnection(
      request: CreateVpnConnectionRequest
    ) extends Ec2Op[CreateVpnConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpnConnectionResponse] =
        visitor.createVpnConnection(request)
    }

    final case class CreateVpnConnectionRoute(
      request: CreateVpnConnectionRouteRequest
    ) extends Ec2Op[CreateVpnConnectionRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpnConnectionRouteResponse] =
        visitor.createVpnConnectionRoute(request)
    }

    final case class CreateVpnGateway(
      request: CreateVpnGatewayRequest
    ) extends Ec2Op[CreateVpnGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpnGatewayResponse] =
        visitor.createVpnGateway(request)
    }

    final case class DeleteCarrierGateway(
      request: DeleteCarrierGatewayRequest
    ) extends Ec2Op[DeleteCarrierGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCarrierGatewayResponse] =
        visitor.deleteCarrierGateway(request)
    }

    final case class DeleteClientVpnEndpoint(
      request: DeleteClientVpnEndpointRequest
    ) extends Ec2Op[DeleteClientVpnEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClientVpnEndpointResponse] =
        visitor.deleteClientVpnEndpoint(request)
    }

    final case class DeleteClientVpnRoute(
      request: DeleteClientVpnRouteRequest
    ) extends Ec2Op[DeleteClientVpnRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClientVpnRouteResponse] =
        visitor.deleteClientVpnRoute(request)
    }

    final case class DeleteCustomerGateway(
      request: DeleteCustomerGatewayRequest
    ) extends Ec2Op[DeleteCustomerGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomerGatewayResponse] =
        visitor.deleteCustomerGateway(request)
    }

    final case class DeleteDhcpOptions(
      request: DeleteDhcpOptionsRequest
    ) extends Ec2Op[DeleteDhcpOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDhcpOptionsResponse] =
        visitor.deleteDhcpOptions(request)
    }

    final case class DeleteEgressOnlyInternetGateway(
      request: DeleteEgressOnlyInternetGatewayRequest
    ) extends Ec2Op[DeleteEgressOnlyInternetGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEgressOnlyInternetGatewayResponse] =
        visitor.deleteEgressOnlyInternetGateway(request)
    }

    final case class DeleteFleets(
      request: DeleteFleetsRequest
    ) extends Ec2Op[DeleteFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFleetsResponse] =
        visitor.deleteFleets(request)
    }

    final case class DeleteFlowLogs(
      request: DeleteFlowLogsRequest
    ) extends Ec2Op[DeleteFlowLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFlowLogsResponse] =
        visitor.deleteFlowLogs(request)
    }

    final case class DeleteFpgaImage(
      request: DeleteFpgaImageRequest
    ) extends Ec2Op[DeleteFpgaImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFpgaImageResponse] =
        visitor.deleteFpgaImage(request)
    }

    final case class DeleteInternetGateway(
      request: DeleteInternetGatewayRequest
    ) extends Ec2Op[DeleteInternetGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInternetGatewayResponse] =
        visitor.deleteInternetGateway(request)
    }

    final case class DeleteKeyPair(
      request: DeleteKeyPairRequest
    ) extends Ec2Op[DeleteKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteKeyPairResponse] =
        visitor.deleteKeyPair(request)
    }

    final case class DeleteLaunchTemplate(
      request: DeleteLaunchTemplateRequest
    ) extends Ec2Op[DeleteLaunchTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLaunchTemplateResponse] =
        visitor.deleteLaunchTemplate(request)
    }

    final case class DeleteLaunchTemplateVersions(
      request: DeleteLaunchTemplateVersionsRequest
    ) extends Ec2Op[DeleteLaunchTemplateVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLaunchTemplateVersionsResponse] =
        visitor.deleteLaunchTemplateVersions(request)
    }

    final case class DeleteLocalGatewayRoute(
      request: DeleteLocalGatewayRouteRequest
    ) extends Ec2Op[DeleteLocalGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLocalGatewayRouteResponse] =
        visitor.deleteLocalGatewayRoute(request)
    }

    final case class DeleteLocalGatewayRouteTableVpcAssociation(
      request: DeleteLocalGatewayRouteTableVpcAssociationRequest
    ) extends Ec2Op[DeleteLocalGatewayRouteTableVpcAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLocalGatewayRouteTableVpcAssociationResponse] =
        visitor.deleteLocalGatewayRouteTableVpcAssociation(request)
    }

    final case class DeleteManagedPrefixList(
      request: DeleteManagedPrefixListRequest
    ) extends Ec2Op[DeleteManagedPrefixListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteManagedPrefixListResponse] =
        visitor.deleteManagedPrefixList(request)
    }

    final case class DeleteNatGateway(
      request: DeleteNatGatewayRequest
    ) extends Ec2Op[DeleteNatGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNatGatewayResponse] =
        visitor.deleteNatGateway(request)
    }

    final case class DeleteNetworkAcl(
      request: DeleteNetworkAclRequest
    ) extends Ec2Op[DeleteNetworkAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkAclResponse] =
        visitor.deleteNetworkAcl(request)
    }

    final case class DeleteNetworkAclEntry(
      request: DeleteNetworkAclEntryRequest
    ) extends Ec2Op[DeleteNetworkAclEntryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkAclEntryResponse] =
        visitor.deleteNetworkAclEntry(request)
    }

    final case class DeleteNetworkInsightsAnalysis(
      request: DeleteNetworkInsightsAnalysisRequest
    ) extends Ec2Op[DeleteNetworkInsightsAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkInsightsAnalysisResponse] =
        visitor.deleteNetworkInsightsAnalysis(request)
    }

    final case class DeleteNetworkInsightsPath(
      request: DeleteNetworkInsightsPathRequest
    ) extends Ec2Op[DeleteNetworkInsightsPathResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkInsightsPathResponse] =
        visitor.deleteNetworkInsightsPath(request)
    }

    final case class DeleteNetworkInterface(
      request: DeleteNetworkInterfaceRequest
    ) extends Ec2Op[DeleteNetworkInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkInterfaceResponse] =
        visitor.deleteNetworkInterface(request)
    }

    final case class DeleteNetworkInterfacePermission(
      request: DeleteNetworkInterfacePermissionRequest
    ) extends Ec2Op[DeleteNetworkInterfacePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkInterfacePermissionResponse] =
        visitor.deleteNetworkInterfacePermission(request)
    }

    final case class DeletePlacementGroup(
      request: DeletePlacementGroupRequest
    ) extends Ec2Op[DeletePlacementGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePlacementGroupResponse] =
        visitor.deletePlacementGroup(request)
    }

    final case class DeleteQueuedReservedInstances(
      request: DeleteQueuedReservedInstancesRequest
    ) extends Ec2Op[DeleteQueuedReservedInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQueuedReservedInstancesResponse] =
        visitor.deleteQueuedReservedInstances(request)
    }

    final case class DeleteRoute(
      request: DeleteRouteRequest
    ) extends Ec2Op[DeleteRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteResponse] =
        visitor.deleteRoute(request)
    }

    final case class DeleteRouteTable(
      request: DeleteRouteTableRequest
    ) extends Ec2Op[DeleteRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteTableResponse] =
        visitor.deleteRouteTable(request)
    }

    final case class DeleteSecurityGroup(
      request: DeleteSecurityGroupRequest
    ) extends Ec2Op[DeleteSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSecurityGroupResponse] =
        visitor.deleteSecurityGroup(request)
    }

    final case class DeleteSnapshot(
      request: DeleteSnapshotRequest
    ) extends Ec2Op[DeleteSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSnapshotResponse] =
        visitor.deleteSnapshot(request)
    }

    final case class DeleteSpotDatafeedSubscription(
      request: DeleteSpotDatafeedSubscriptionRequest
    ) extends Ec2Op[DeleteSpotDatafeedSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSpotDatafeedSubscriptionResponse] =
        visitor.deleteSpotDatafeedSubscription(request)
    }

    final case class DeleteSubnet(
      request: DeleteSubnetRequest
    ) extends Ec2Op[DeleteSubnetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSubnetResponse] =
        visitor.deleteSubnet(request)
    }

    final case class DeleteTags(
      request: DeleteTagsRequest
    ) extends Ec2Op[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DeleteTrafficMirrorFilter(
      request: DeleteTrafficMirrorFilterRequest
    ) extends Ec2Op[DeleteTrafficMirrorFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrafficMirrorFilterResponse] =
        visitor.deleteTrafficMirrorFilter(request)
    }

    final case class DeleteTrafficMirrorFilterRule(
      request: DeleteTrafficMirrorFilterRuleRequest
    ) extends Ec2Op[DeleteTrafficMirrorFilterRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrafficMirrorFilterRuleResponse] =
        visitor.deleteTrafficMirrorFilterRule(request)
    }

    final case class DeleteTrafficMirrorSession(
      request: DeleteTrafficMirrorSessionRequest
    ) extends Ec2Op[DeleteTrafficMirrorSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrafficMirrorSessionResponse] =
        visitor.deleteTrafficMirrorSession(request)
    }

    final case class DeleteTrafficMirrorTarget(
      request: DeleteTrafficMirrorTargetRequest
    ) extends Ec2Op[DeleteTrafficMirrorTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrafficMirrorTargetResponse] =
        visitor.deleteTrafficMirrorTarget(request)
    }

    final case class DeleteTransitGateway(
      request: DeleteTransitGatewayRequest
    ) extends Ec2Op[DeleteTransitGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayResponse] =
        visitor.deleteTransitGateway(request)
    }

    final case class DeleteTransitGatewayConnect(
      request: DeleteTransitGatewayConnectRequest
    ) extends Ec2Op[DeleteTransitGatewayConnectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayConnectResponse] =
        visitor.deleteTransitGatewayConnect(request)
    }

    final case class DeleteTransitGatewayConnectPeer(
      request: DeleteTransitGatewayConnectPeerRequest
    ) extends Ec2Op[DeleteTransitGatewayConnectPeerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayConnectPeerResponse] =
        visitor.deleteTransitGatewayConnectPeer(request)
    }

    final case class DeleteTransitGatewayMulticastDomain(
      request: DeleteTransitGatewayMulticastDomainRequest
    ) extends Ec2Op[DeleteTransitGatewayMulticastDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayMulticastDomainResponse] =
        visitor.deleteTransitGatewayMulticastDomain(request)
    }

    final case class DeleteTransitGatewayPeeringAttachment(
      request: DeleteTransitGatewayPeeringAttachmentRequest
    ) extends Ec2Op[DeleteTransitGatewayPeeringAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayPeeringAttachmentResponse] =
        visitor.deleteTransitGatewayPeeringAttachment(request)
    }

    final case class DeleteTransitGatewayPrefixListReference(
      request: DeleteTransitGatewayPrefixListReferenceRequest
    ) extends Ec2Op[DeleteTransitGatewayPrefixListReferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayPrefixListReferenceResponse] =
        visitor.deleteTransitGatewayPrefixListReference(request)
    }

    final case class DeleteTransitGatewayRoute(
      request: DeleteTransitGatewayRouteRequest
    ) extends Ec2Op[DeleteTransitGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayRouteResponse] =
        visitor.deleteTransitGatewayRoute(request)
    }

    final case class DeleteTransitGatewayRouteTable(
      request: DeleteTransitGatewayRouteTableRequest
    ) extends Ec2Op[DeleteTransitGatewayRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayRouteTableResponse] =
        visitor.deleteTransitGatewayRouteTable(request)
    }

    final case class DeleteTransitGatewayVpcAttachment(
      request: DeleteTransitGatewayVpcAttachmentRequest
    ) extends Ec2Op[DeleteTransitGatewayVpcAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTransitGatewayVpcAttachmentResponse] =
        visitor.deleteTransitGatewayVpcAttachment(request)
    }

    final case class DeleteVolume(
      request: DeleteVolumeRequest
    ) extends Ec2Op[DeleteVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVolumeResponse] =
        visitor.deleteVolume(request)
    }

    final case class DeleteVpc(
      request: DeleteVpcRequest
    ) extends Ec2Op[DeleteVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcResponse] =
        visitor.deleteVpc(request)
    }

    final case class DeleteVpcEndpointConnectionNotifications(
      request: DeleteVpcEndpointConnectionNotificationsRequest
    ) extends Ec2Op[DeleteVpcEndpointConnectionNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcEndpointConnectionNotificationsResponse] =
        visitor.deleteVpcEndpointConnectionNotifications(request)
    }

    final case class DeleteVpcEndpointServiceConfigurations(
      request: DeleteVpcEndpointServiceConfigurationsRequest
    ) extends Ec2Op[DeleteVpcEndpointServiceConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcEndpointServiceConfigurationsResponse] =
        visitor.deleteVpcEndpointServiceConfigurations(request)
    }

    final case class DeleteVpcEndpoints(
      request: DeleteVpcEndpointsRequest
    ) extends Ec2Op[DeleteVpcEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcEndpointsResponse] =
        visitor.deleteVpcEndpoints(request)
    }

    final case class DeleteVpcPeeringConnection(
      request: DeleteVpcPeeringConnectionRequest
    ) extends Ec2Op[DeleteVpcPeeringConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcPeeringConnectionResponse] =
        visitor.deleteVpcPeeringConnection(request)
    }

    final case class DeleteVpnConnection(
      request: DeleteVpnConnectionRequest
    ) extends Ec2Op[DeleteVpnConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpnConnectionResponse] =
        visitor.deleteVpnConnection(request)
    }

    final case class DeleteVpnConnectionRoute(
      request: DeleteVpnConnectionRouteRequest
    ) extends Ec2Op[DeleteVpnConnectionRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpnConnectionRouteResponse] =
        visitor.deleteVpnConnectionRoute(request)
    }

    final case class DeleteVpnGateway(
      request: DeleteVpnGatewayRequest
    ) extends Ec2Op[DeleteVpnGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpnGatewayResponse] =
        visitor.deleteVpnGateway(request)
    }

    final case class DeprovisionByoipCidr(
      request: DeprovisionByoipCidrRequest
    ) extends Ec2Op[DeprovisionByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprovisionByoipCidrResponse] =
        visitor.deprovisionByoipCidr(request)
    }

    final case class DeregisterImage(
      request: DeregisterImageRequest
    ) extends Ec2Op[DeregisterImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterImageResponse] =
        visitor.deregisterImage(request)
    }

    final case class DeregisterInstanceEventNotificationAttributes(
      request: DeregisterInstanceEventNotificationAttributesRequest
    ) extends Ec2Op[DeregisterInstanceEventNotificationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterInstanceEventNotificationAttributesResponse] =
        visitor.deregisterInstanceEventNotificationAttributes(request)
    }

    final case class DeregisterTransitGatewayMulticastGroupMembers(
      request: DeregisterTransitGatewayMulticastGroupMembersRequest
    ) extends Ec2Op[DeregisterTransitGatewayMulticastGroupMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTransitGatewayMulticastGroupMembersResponse] =
        visitor.deregisterTransitGatewayMulticastGroupMembers(request)
    }

    final case class DeregisterTransitGatewayMulticastGroupSources(
      request: DeregisterTransitGatewayMulticastGroupSourcesRequest
    ) extends Ec2Op[DeregisterTransitGatewayMulticastGroupSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTransitGatewayMulticastGroupSourcesResponse] =
        visitor.deregisterTransitGatewayMulticastGroupSources(request)
    }

    final case class DescribeAccountAttributes(
      request: DescribeAccountAttributesRequest
    ) extends Ec2Op[DescribeAccountAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAttributesResponse] =
        visitor.describeAccountAttributes(request)
    }

    final case class DescribeAddresses(
      request: DescribeAddressesRequest
    ) extends Ec2Op[DescribeAddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAddressesResponse] =
        visitor.describeAddresses(request)
    }

    final case class DescribeAddressesAttribute(
      request: DescribeAddressesAttributeRequest
    ) extends Ec2Op[DescribeAddressesAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAddressesAttributeResponse] =
        visitor.describeAddressesAttribute(request)
    }

    final case class DescribeAggregateIdFormat(
      request: DescribeAggregateIdFormatRequest
    ) extends Ec2Op[DescribeAggregateIdFormatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAggregateIdFormatResponse] =
        visitor.describeAggregateIdFormat(request)
    }

    final case class DescribeAvailabilityZones(
      request: DescribeAvailabilityZonesRequest
    ) extends Ec2Op[DescribeAvailabilityZonesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAvailabilityZonesResponse] =
        visitor.describeAvailabilityZones(request)
    }

    final case class DescribeBundleTasks(
      request: DescribeBundleTasksRequest
    ) extends Ec2Op[DescribeBundleTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBundleTasksResponse] =
        visitor.describeBundleTasks(request)
    }

    final case class DescribeByoipCidrs(
      request: DescribeByoipCidrsRequest
    ) extends Ec2Op[DescribeByoipCidrsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeByoipCidrsResponse] =
        visitor.describeByoipCidrs(request)
    }

    final case class DescribeCapacityReservations(
      request: DescribeCapacityReservationsRequest
    ) extends Ec2Op[DescribeCapacityReservationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCapacityReservationsResponse] =
        visitor.describeCapacityReservations(request)
    }

    final case class DescribeCarrierGateways(
      request: DescribeCarrierGatewaysRequest
    ) extends Ec2Op[DescribeCarrierGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCarrierGatewaysResponse] =
        visitor.describeCarrierGateways(request)
    }

    final case class DescribeClassicLinkInstances(
      request: DescribeClassicLinkInstancesRequest
    ) extends Ec2Op[DescribeClassicLinkInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClassicLinkInstancesResponse] =
        visitor.describeClassicLinkInstances(request)
    }

    final case class DescribeClientVpnAuthorizationRules(
      request: DescribeClientVpnAuthorizationRulesRequest
    ) extends Ec2Op[DescribeClientVpnAuthorizationRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClientVpnAuthorizationRulesResponse] =
        visitor.describeClientVpnAuthorizationRules(request)
    }

    final case class DescribeClientVpnConnections(
      request: DescribeClientVpnConnectionsRequest
    ) extends Ec2Op[DescribeClientVpnConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClientVpnConnectionsResponse] =
        visitor.describeClientVpnConnections(request)
    }

    final case class DescribeClientVpnEndpoints(
      request: DescribeClientVpnEndpointsRequest
    ) extends Ec2Op[DescribeClientVpnEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClientVpnEndpointsResponse] =
        visitor.describeClientVpnEndpoints(request)
    }

    final case class DescribeClientVpnRoutes(
      request: DescribeClientVpnRoutesRequest
    ) extends Ec2Op[DescribeClientVpnRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClientVpnRoutesResponse] =
        visitor.describeClientVpnRoutes(request)
    }

    final case class DescribeClientVpnTargetNetworks(
      request: DescribeClientVpnTargetNetworksRequest
    ) extends Ec2Op[DescribeClientVpnTargetNetworksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClientVpnTargetNetworksResponse] =
        visitor.describeClientVpnTargetNetworks(request)
    }

    final case class DescribeCoipPools(
      request: DescribeCoipPoolsRequest
    ) extends Ec2Op[DescribeCoipPoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCoipPoolsResponse] =
        visitor.describeCoipPools(request)
    }

    final case class DescribeConversionTasks(
      request: DescribeConversionTasksRequest
    ) extends Ec2Op[DescribeConversionTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConversionTasksResponse] =
        visitor.describeConversionTasks(request)
    }

    final case class DescribeCustomerGateways(
      request: DescribeCustomerGatewaysRequest
    ) extends Ec2Op[DescribeCustomerGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomerGatewaysResponse] =
        visitor.describeCustomerGateways(request)
    }

    final case class DescribeDhcpOptions(
      request: DescribeDhcpOptionsRequest
    ) extends Ec2Op[DescribeDhcpOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDhcpOptionsResponse] =
        visitor.describeDhcpOptions(request)
    }

    final case class DescribeEgressOnlyInternetGateways(
      request: DescribeEgressOnlyInternetGatewaysRequest
    ) extends Ec2Op[DescribeEgressOnlyInternetGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEgressOnlyInternetGatewaysResponse] =
        visitor.describeEgressOnlyInternetGateways(request)
    }

    final case class DescribeElasticGpus(
      request: DescribeElasticGpusRequest
    ) extends Ec2Op[DescribeElasticGpusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeElasticGpusResponse] =
        visitor.describeElasticGpus(request)
    }

    final case class DescribeExportImageTasks(
      request: DescribeExportImageTasksRequest
    ) extends Ec2Op[DescribeExportImageTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExportImageTasksResponse] =
        visitor.describeExportImageTasks(request)
    }

    final case class DescribeExportTasks(
      request: DescribeExportTasksRequest
    ) extends Ec2Op[DescribeExportTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExportTasksResponse] =
        visitor.describeExportTasks(request)
    }

    final case class DescribeFastSnapshotRestores(
      request: DescribeFastSnapshotRestoresRequest
    ) extends Ec2Op[DescribeFastSnapshotRestoresResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFastSnapshotRestoresResponse] =
        visitor.describeFastSnapshotRestores(request)
    }

    final case class DescribeFleetHistory(
      request: DescribeFleetHistoryRequest
    ) extends Ec2Op[DescribeFleetHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetHistoryResponse] =
        visitor.describeFleetHistory(request)
    }

    final case class DescribeFleetInstances(
      request: DescribeFleetInstancesRequest
    ) extends Ec2Op[DescribeFleetInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetInstancesResponse] =
        visitor.describeFleetInstances(request)
    }

    final case class DescribeFleets(
      request: DescribeFleetsRequest
    ) extends Ec2Op[DescribeFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetsResponse] =
        visitor.describeFleets(request)
    }

    final case class DescribeFlowLogs(
      request: DescribeFlowLogsRequest
    ) extends Ec2Op[DescribeFlowLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFlowLogsResponse] =
        visitor.describeFlowLogs(request)
    }

    final case class DescribeFpgaImageAttribute(
      request: DescribeFpgaImageAttributeRequest
    ) extends Ec2Op[DescribeFpgaImageAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFpgaImageAttributeResponse] =
        visitor.describeFpgaImageAttribute(request)
    }

    final case class DescribeFpgaImages(
      request: DescribeFpgaImagesRequest
    ) extends Ec2Op[DescribeFpgaImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFpgaImagesResponse] =
        visitor.describeFpgaImages(request)
    }

    final case class DescribeHostReservationOfferings(
      request: DescribeHostReservationOfferingsRequest
    ) extends Ec2Op[DescribeHostReservationOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHostReservationOfferingsResponse] =
        visitor.describeHostReservationOfferings(request)
    }

    final case class DescribeHostReservations(
      request: DescribeHostReservationsRequest
    ) extends Ec2Op[DescribeHostReservationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHostReservationsResponse] =
        visitor.describeHostReservations(request)
    }

    final case class DescribeHosts(
      request: DescribeHostsRequest
    ) extends Ec2Op[DescribeHostsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHostsResponse] =
        visitor.describeHosts(request)
    }

    final case class DescribeIamInstanceProfileAssociations(
      request: DescribeIamInstanceProfileAssociationsRequest
    ) extends Ec2Op[DescribeIamInstanceProfileAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIamInstanceProfileAssociationsResponse] =
        visitor.describeIamInstanceProfileAssociations(request)
    }

    final case class DescribeIdFormat(
      request: DescribeIdFormatRequest
    ) extends Ec2Op[DescribeIdFormatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdFormatResponse] =
        visitor.describeIdFormat(request)
    }

    final case class DescribeIdentityIdFormat(
      request: DescribeIdentityIdFormatRequest
    ) extends Ec2Op[DescribeIdentityIdFormatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityIdFormatResponse] =
        visitor.describeIdentityIdFormat(request)
    }

    final case class DescribeImageAttribute(
      request: DescribeImageAttributeRequest
    ) extends Ec2Op[DescribeImageAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImageAttributeResponse] =
        visitor.describeImageAttribute(request)
    }

    final case class DescribeImages(
      request: DescribeImagesRequest
    ) extends Ec2Op[DescribeImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImagesResponse] =
        visitor.describeImages(request)
    }

    final case class DescribeImportImageTasks(
      request: DescribeImportImageTasksRequest
    ) extends Ec2Op[DescribeImportImageTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImportImageTasksResponse] =
        visitor.describeImportImageTasks(request)
    }

    final case class DescribeImportSnapshotTasks(
      request: DescribeImportSnapshotTasksRequest
    ) extends Ec2Op[DescribeImportSnapshotTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImportSnapshotTasksResponse] =
        visitor.describeImportSnapshotTasks(request)
    }

    final case class DescribeInstanceAttribute(
      request: DescribeInstanceAttributeRequest
    ) extends Ec2Op[DescribeInstanceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceAttributeResponse] =
        visitor.describeInstanceAttribute(request)
    }

    final case class DescribeInstanceCreditSpecifications(
      request: DescribeInstanceCreditSpecificationsRequest
    ) extends Ec2Op[DescribeInstanceCreditSpecificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceCreditSpecificationsResponse] =
        visitor.describeInstanceCreditSpecifications(request)
    }

    final case class DescribeInstanceEventNotificationAttributes(
      request: DescribeInstanceEventNotificationAttributesRequest
    ) extends Ec2Op[DescribeInstanceEventNotificationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceEventNotificationAttributesResponse] =
        visitor.describeInstanceEventNotificationAttributes(request)
    }

    final case class DescribeInstanceStatus(
      request: DescribeInstanceStatusRequest
    ) extends Ec2Op[DescribeInstanceStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceStatusResponse] =
        visitor.describeInstanceStatus(request)
    }

    final case class DescribeInstanceTypeOfferings(
      request: DescribeInstanceTypeOfferingsRequest
    ) extends Ec2Op[DescribeInstanceTypeOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceTypeOfferingsResponse] =
        visitor.describeInstanceTypeOfferings(request)
    }

    final case class DescribeInstanceTypes(
      request: DescribeInstanceTypesRequest
    ) extends Ec2Op[DescribeInstanceTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceTypesResponse] =
        visitor.describeInstanceTypes(request)
    }

    final case class DescribeInstances(
      request: DescribeInstancesRequest
    ) extends Ec2Op[DescribeInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstancesResponse] =
        visitor.describeInstances(request)
    }

    final case class DescribeInternetGateways(
      request: DescribeInternetGatewaysRequest
    ) extends Ec2Op[DescribeInternetGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInternetGatewaysResponse] =
        visitor.describeInternetGateways(request)
    }

    final case class DescribeIpv6Pools(
      request: DescribeIpv6PoolsRequest
    ) extends Ec2Op[DescribeIpv6PoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIpv6PoolsResponse] =
        visitor.describeIpv6Pools(request)
    }

    final case class DescribeKeyPairs(
      request: DescribeKeyPairsRequest
    ) extends Ec2Op[DescribeKeyPairsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeKeyPairsResponse] =
        visitor.describeKeyPairs(request)
    }

    final case class DescribeLaunchTemplateVersions(
      request: DescribeLaunchTemplateVersionsRequest
    ) extends Ec2Op[DescribeLaunchTemplateVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLaunchTemplateVersionsResponse] =
        visitor.describeLaunchTemplateVersions(request)
    }

    final case class DescribeLaunchTemplates(
      request: DescribeLaunchTemplatesRequest
    ) extends Ec2Op[DescribeLaunchTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLaunchTemplatesResponse] =
        visitor.describeLaunchTemplates(request)
    }

    final case class DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociations(
      request: DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsRequest
    ) extends Ec2Op[DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsResponse] =
        visitor.describeLocalGatewayRouteTableVirtualInterfaceGroupAssociations(request)
    }

    final case class DescribeLocalGatewayRouteTableVpcAssociations(
      request: DescribeLocalGatewayRouteTableVpcAssociationsRequest
    ) extends Ec2Op[DescribeLocalGatewayRouteTableVpcAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocalGatewayRouteTableVpcAssociationsResponse] =
        visitor.describeLocalGatewayRouteTableVpcAssociations(request)
    }

    final case class DescribeLocalGatewayRouteTables(
      request: DescribeLocalGatewayRouteTablesRequest
    ) extends Ec2Op[DescribeLocalGatewayRouteTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocalGatewayRouteTablesResponse] =
        visitor.describeLocalGatewayRouteTables(request)
    }

    final case class DescribeLocalGatewayVirtualInterfaceGroups(
      request: DescribeLocalGatewayVirtualInterfaceGroupsRequest
    ) extends Ec2Op[DescribeLocalGatewayVirtualInterfaceGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocalGatewayVirtualInterfaceGroupsResponse] =
        visitor.describeLocalGatewayVirtualInterfaceGroups(request)
    }

    final case class DescribeLocalGatewayVirtualInterfaces(
      request: DescribeLocalGatewayVirtualInterfacesRequest
    ) extends Ec2Op[DescribeLocalGatewayVirtualInterfacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocalGatewayVirtualInterfacesResponse] =
        visitor.describeLocalGatewayVirtualInterfaces(request)
    }

    final case class DescribeLocalGateways(
      request: DescribeLocalGatewaysRequest
    ) extends Ec2Op[DescribeLocalGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocalGatewaysResponse] =
        visitor.describeLocalGateways(request)
    }

    final case class DescribeManagedPrefixLists(
      request: DescribeManagedPrefixListsRequest
    ) extends Ec2Op[DescribeManagedPrefixListsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeManagedPrefixListsResponse] =
        visitor.describeManagedPrefixLists(request)
    }

    final case class DescribeMovingAddresses(
      request: DescribeMovingAddressesRequest
    ) extends Ec2Op[DescribeMovingAddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMovingAddressesResponse] =
        visitor.describeMovingAddresses(request)
    }

    final case class DescribeNatGateways(
      request: DescribeNatGatewaysRequest
    ) extends Ec2Op[DescribeNatGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNatGatewaysResponse] =
        visitor.describeNatGateways(request)
    }

    final case class DescribeNetworkAcls(
      request: DescribeNetworkAclsRequest
    ) extends Ec2Op[DescribeNetworkAclsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNetworkAclsResponse] =
        visitor.describeNetworkAcls(request)
    }

    final case class DescribeNetworkInsightsAnalyses(
      request: DescribeNetworkInsightsAnalysesRequest
    ) extends Ec2Op[DescribeNetworkInsightsAnalysesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNetworkInsightsAnalysesResponse] =
        visitor.describeNetworkInsightsAnalyses(request)
    }

    final case class DescribeNetworkInsightsPaths(
      request: DescribeNetworkInsightsPathsRequest
    ) extends Ec2Op[DescribeNetworkInsightsPathsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNetworkInsightsPathsResponse] =
        visitor.describeNetworkInsightsPaths(request)
    }

    final case class DescribeNetworkInterfaceAttribute(
      request: DescribeNetworkInterfaceAttributeRequest
    ) extends Ec2Op[DescribeNetworkInterfaceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNetworkInterfaceAttributeResponse] =
        visitor.describeNetworkInterfaceAttribute(request)
    }

    final case class DescribeNetworkInterfacePermissions(
      request: DescribeNetworkInterfacePermissionsRequest
    ) extends Ec2Op[DescribeNetworkInterfacePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNetworkInterfacePermissionsResponse] =
        visitor.describeNetworkInterfacePermissions(request)
    }

    final case class DescribeNetworkInterfaces(
      request: DescribeNetworkInterfacesRequest
    ) extends Ec2Op[DescribeNetworkInterfacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNetworkInterfacesResponse] =
        visitor.describeNetworkInterfaces(request)
    }

    final case class DescribePlacementGroups(
      request: DescribePlacementGroupsRequest
    ) extends Ec2Op[DescribePlacementGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePlacementGroupsResponse] =
        visitor.describePlacementGroups(request)
    }

    final case class DescribePrefixLists(
      request: DescribePrefixListsRequest
    ) extends Ec2Op[DescribePrefixListsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePrefixListsResponse] =
        visitor.describePrefixLists(request)
    }

    final case class DescribePrincipalIdFormat(
      request: DescribePrincipalIdFormatRequest
    ) extends Ec2Op[DescribePrincipalIdFormatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePrincipalIdFormatResponse] =
        visitor.describePrincipalIdFormat(request)
    }

    final case class DescribePublicIpv4Pools(
      request: DescribePublicIpv4PoolsRequest
    ) extends Ec2Op[DescribePublicIpv4PoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePublicIpv4PoolsResponse] =
        visitor.describePublicIpv4Pools(request)
    }

    final case class DescribeRegions(
      request: DescribeRegionsRequest
    ) extends Ec2Op[DescribeRegionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRegionsResponse] =
        visitor.describeRegions(request)
    }

    final case class DescribeReplaceRootVolumeTasks(
      request: DescribeReplaceRootVolumeTasksRequest
    ) extends Ec2Op[DescribeReplaceRootVolumeTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplaceRootVolumeTasksResponse] =
        visitor.describeReplaceRootVolumeTasks(request)
    }

    final case class DescribeReservedInstances(
      request: DescribeReservedInstancesRequest
    ) extends Ec2Op[DescribeReservedInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedInstancesResponse] =
        visitor.describeReservedInstances(request)
    }

    final case class DescribeReservedInstancesListings(
      request: DescribeReservedInstancesListingsRequest
    ) extends Ec2Op[DescribeReservedInstancesListingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedInstancesListingsResponse] =
        visitor.describeReservedInstancesListings(request)
    }

    final case class DescribeReservedInstancesModifications(
      request: DescribeReservedInstancesModificationsRequest
    ) extends Ec2Op[DescribeReservedInstancesModificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedInstancesModificationsResponse] =
        visitor.describeReservedInstancesModifications(request)
    }

    final case class DescribeReservedInstancesOfferings(
      request: DescribeReservedInstancesOfferingsRequest
    ) extends Ec2Op[DescribeReservedInstancesOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedInstancesOfferingsResponse] =
        visitor.describeReservedInstancesOfferings(request)
    }

    final case class DescribeRouteTables(
      request: DescribeRouteTablesRequest
    ) extends Ec2Op[DescribeRouteTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRouteTablesResponse] =
        visitor.describeRouteTables(request)
    }

    final case class DescribeScheduledInstanceAvailability(
      request: DescribeScheduledInstanceAvailabilityRequest
    ) extends Ec2Op[DescribeScheduledInstanceAvailabilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduledInstanceAvailabilityResponse] =
        visitor.describeScheduledInstanceAvailability(request)
    }

    final case class DescribeScheduledInstances(
      request: DescribeScheduledInstancesRequest
    ) extends Ec2Op[DescribeScheduledInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduledInstancesResponse] =
        visitor.describeScheduledInstances(request)
    }

    final case class DescribeSecurityGroupReferences(
      request: DescribeSecurityGroupReferencesRequest
    ) extends Ec2Op[DescribeSecurityGroupReferencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSecurityGroupReferencesResponse] =
        visitor.describeSecurityGroupReferences(request)
    }

    final case class DescribeSecurityGroups(
      request: DescribeSecurityGroupsRequest
    ) extends Ec2Op[DescribeSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSecurityGroupsResponse] =
        visitor.describeSecurityGroups(request)
    }

    final case class DescribeSnapshotAttribute(
      request: DescribeSnapshotAttributeRequest
    ) extends Ec2Op[DescribeSnapshotAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSnapshotAttributeResponse] =
        visitor.describeSnapshotAttribute(request)
    }

    final case class DescribeSnapshots(
      request: DescribeSnapshotsRequest
    ) extends Ec2Op[DescribeSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSnapshotsResponse] =
        visitor.describeSnapshots(request)
    }

    final case class DescribeSpotDatafeedSubscription(
      request: DescribeSpotDatafeedSubscriptionRequest
    ) extends Ec2Op[DescribeSpotDatafeedSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSpotDatafeedSubscriptionResponse] =
        visitor.describeSpotDatafeedSubscription(request)
    }

    final case class DescribeSpotFleetInstances(
      request: DescribeSpotFleetInstancesRequest
    ) extends Ec2Op[DescribeSpotFleetInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSpotFleetInstancesResponse] =
        visitor.describeSpotFleetInstances(request)
    }

    final case class DescribeSpotFleetRequestHistory(
      request: DescribeSpotFleetRequestHistoryRequest
    ) extends Ec2Op[DescribeSpotFleetRequestHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSpotFleetRequestHistoryResponse] =
        visitor.describeSpotFleetRequestHistory(request)
    }

    final case class DescribeSpotFleetRequests(
      request: DescribeSpotFleetRequestsRequest
    ) extends Ec2Op[DescribeSpotFleetRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSpotFleetRequestsResponse] =
        visitor.describeSpotFleetRequests(request)
    }

    final case class DescribeSpotInstanceRequests(
      request: DescribeSpotInstanceRequestsRequest
    ) extends Ec2Op[DescribeSpotInstanceRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSpotInstanceRequestsResponse] =
        visitor.describeSpotInstanceRequests(request)
    }

    final case class DescribeSpotPriceHistory(
      request: DescribeSpotPriceHistoryRequest
    ) extends Ec2Op[DescribeSpotPriceHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSpotPriceHistoryResponse] =
        visitor.describeSpotPriceHistory(request)
    }

    final case class DescribeStaleSecurityGroups(
      request: DescribeStaleSecurityGroupsRequest
    ) extends Ec2Op[DescribeStaleSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStaleSecurityGroupsResponse] =
        visitor.describeStaleSecurityGroups(request)
    }

    final case class DescribeStoreImageTasks(
      request: DescribeStoreImageTasksRequest
    ) extends Ec2Op[DescribeStoreImageTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStoreImageTasksResponse] =
        visitor.describeStoreImageTasks(request)
    }

    final case class DescribeSubnets(
      request: DescribeSubnetsRequest
    ) extends Ec2Op[DescribeSubnetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSubnetsResponse] =
        visitor.describeSubnets(request)
    }

    final case class DescribeTags(
      request: DescribeTagsRequest
    ) extends Ec2Op[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DescribeTrafficMirrorFilters(
      request: DescribeTrafficMirrorFiltersRequest
    ) extends Ec2Op[DescribeTrafficMirrorFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrafficMirrorFiltersResponse] =
        visitor.describeTrafficMirrorFilters(request)
    }

    final case class DescribeTrafficMirrorSessions(
      request: DescribeTrafficMirrorSessionsRequest
    ) extends Ec2Op[DescribeTrafficMirrorSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrafficMirrorSessionsResponse] =
        visitor.describeTrafficMirrorSessions(request)
    }

    final case class DescribeTrafficMirrorTargets(
      request: DescribeTrafficMirrorTargetsRequest
    ) extends Ec2Op[DescribeTrafficMirrorTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrafficMirrorTargetsResponse] =
        visitor.describeTrafficMirrorTargets(request)
    }

    final case class DescribeTransitGatewayAttachments(
      request: DescribeTransitGatewayAttachmentsRequest
    ) extends Ec2Op[DescribeTransitGatewayAttachmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewayAttachmentsResponse] =
        visitor.describeTransitGatewayAttachments(request)
    }

    final case class DescribeTransitGatewayConnectPeers(
      request: DescribeTransitGatewayConnectPeersRequest
    ) extends Ec2Op[DescribeTransitGatewayConnectPeersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewayConnectPeersResponse] =
        visitor.describeTransitGatewayConnectPeers(request)
    }

    final case class DescribeTransitGatewayConnects(
      request: DescribeTransitGatewayConnectsRequest
    ) extends Ec2Op[DescribeTransitGatewayConnectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewayConnectsResponse] =
        visitor.describeTransitGatewayConnects(request)
    }

    final case class DescribeTransitGatewayMulticastDomains(
      request: DescribeTransitGatewayMulticastDomainsRequest
    ) extends Ec2Op[DescribeTransitGatewayMulticastDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewayMulticastDomainsResponse] =
        visitor.describeTransitGatewayMulticastDomains(request)
    }

    final case class DescribeTransitGatewayPeeringAttachments(
      request: DescribeTransitGatewayPeeringAttachmentsRequest
    ) extends Ec2Op[DescribeTransitGatewayPeeringAttachmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewayPeeringAttachmentsResponse] =
        visitor.describeTransitGatewayPeeringAttachments(request)
    }

    final case class DescribeTransitGatewayRouteTables(
      request: DescribeTransitGatewayRouteTablesRequest
    ) extends Ec2Op[DescribeTransitGatewayRouteTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewayRouteTablesResponse] =
        visitor.describeTransitGatewayRouteTables(request)
    }

    final case class DescribeTransitGatewayVpcAttachments(
      request: DescribeTransitGatewayVpcAttachmentsRequest
    ) extends Ec2Op[DescribeTransitGatewayVpcAttachmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewayVpcAttachmentsResponse] =
        visitor.describeTransitGatewayVpcAttachments(request)
    }

    final case class DescribeTransitGateways(
      request: DescribeTransitGatewaysRequest
    ) extends Ec2Op[DescribeTransitGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransitGatewaysResponse] =
        visitor.describeTransitGateways(request)
    }

    final case class DescribeVolumeAttribute(
      request: DescribeVolumeAttributeRequest
    ) extends Ec2Op[DescribeVolumeAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVolumeAttributeResponse] =
        visitor.describeVolumeAttribute(request)
    }

    final case class DescribeVolumeStatus(
      request: DescribeVolumeStatusRequest
    ) extends Ec2Op[DescribeVolumeStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVolumeStatusResponse] =
        visitor.describeVolumeStatus(request)
    }

    final case class DescribeVolumes(
      request: DescribeVolumesRequest
    ) extends Ec2Op[DescribeVolumesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVolumesResponse] =
        visitor.describeVolumes(request)
    }

    final case class DescribeVolumesModifications(
      request: DescribeVolumesModificationsRequest
    ) extends Ec2Op[DescribeVolumesModificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVolumesModificationsResponse] =
        visitor.describeVolumesModifications(request)
    }

    final case class DescribeVpcAttribute(
      request: DescribeVpcAttributeRequest
    ) extends Ec2Op[DescribeVpcAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcAttributeResponse] =
        visitor.describeVpcAttribute(request)
    }

    final case class DescribeVpcClassicLink(
      request: DescribeVpcClassicLinkRequest
    ) extends Ec2Op[DescribeVpcClassicLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcClassicLinkResponse] =
        visitor.describeVpcClassicLink(request)
    }

    final case class DescribeVpcClassicLinkDnsSupport(
      request: DescribeVpcClassicLinkDnsSupportRequest
    ) extends Ec2Op[DescribeVpcClassicLinkDnsSupportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcClassicLinkDnsSupportResponse] =
        visitor.describeVpcClassicLinkDnsSupport(request)
    }

    final case class DescribeVpcEndpointConnectionNotifications(
      request: DescribeVpcEndpointConnectionNotificationsRequest
    ) extends Ec2Op[DescribeVpcEndpointConnectionNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcEndpointConnectionNotificationsResponse] =
        visitor.describeVpcEndpointConnectionNotifications(request)
    }

    final case class DescribeVpcEndpointConnections(
      request: DescribeVpcEndpointConnectionsRequest
    ) extends Ec2Op[DescribeVpcEndpointConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcEndpointConnectionsResponse] =
        visitor.describeVpcEndpointConnections(request)
    }

    final case class DescribeVpcEndpointServiceConfigurations(
      request: DescribeVpcEndpointServiceConfigurationsRequest
    ) extends Ec2Op[DescribeVpcEndpointServiceConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcEndpointServiceConfigurationsResponse] =
        visitor.describeVpcEndpointServiceConfigurations(request)
    }

    final case class DescribeVpcEndpointServicePermissions(
      request: DescribeVpcEndpointServicePermissionsRequest
    ) extends Ec2Op[DescribeVpcEndpointServicePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcEndpointServicePermissionsResponse] =
        visitor.describeVpcEndpointServicePermissions(request)
    }

    final case class DescribeVpcEndpointServices(
      request: DescribeVpcEndpointServicesRequest
    ) extends Ec2Op[DescribeVpcEndpointServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcEndpointServicesResponse] =
        visitor.describeVpcEndpointServices(request)
    }

    final case class DescribeVpcEndpoints(
      request: DescribeVpcEndpointsRequest
    ) extends Ec2Op[DescribeVpcEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcEndpointsResponse] =
        visitor.describeVpcEndpoints(request)
    }

    final case class DescribeVpcPeeringConnections(
      request: DescribeVpcPeeringConnectionsRequest
    ) extends Ec2Op[DescribeVpcPeeringConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcPeeringConnectionsResponse] =
        visitor.describeVpcPeeringConnections(request)
    }

    final case class DescribeVpcs(
      request: DescribeVpcsRequest
    ) extends Ec2Op[DescribeVpcsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcsResponse] =
        visitor.describeVpcs(request)
    }

    final case class DescribeVpnConnections(
      request: DescribeVpnConnectionsRequest
    ) extends Ec2Op[DescribeVpnConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpnConnectionsResponse] =
        visitor.describeVpnConnections(request)
    }

    final case class DescribeVpnGateways(
      request: DescribeVpnGatewaysRequest
    ) extends Ec2Op[DescribeVpnGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpnGatewaysResponse] =
        visitor.describeVpnGateways(request)
    }

    final case class DetachClassicLinkVpc(
      request: DetachClassicLinkVpcRequest
    ) extends Ec2Op[DetachClassicLinkVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachClassicLinkVpcResponse] =
        visitor.detachClassicLinkVpc(request)
    }

    final case class DetachInternetGateway(
      request: DetachInternetGatewayRequest
    ) extends Ec2Op[DetachInternetGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachInternetGatewayResponse] =
        visitor.detachInternetGateway(request)
    }

    final case class DetachNetworkInterface(
      request: DetachNetworkInterfaceRequest
    ) extends Ec2Op[DetachNetworkInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachNetworkInterfaceResponse] =
        visitor.detachNetworkInterface(request)
    }

    final case class DetachVolume(
      request: DetachVolumeRequest
    ) extends Ec2Op[DetachVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachVolumeResponse] =
        visitor.detachVolume(request)
    }

    final case class DetachVpnGateway(
      request: DetachVpnGatewayRequest
    ) extends Ec2Op[DetachVpnGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachVpnGatewayResponse] =
        visitor.detachVpnGateway(request)
    }

    final case class DisableEbsEncryptionByDefault(
      request: DisableEbsEncryptionByDefaultRequest
    ) extends Ec2Op[DisableEbsEncryptionByDefaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableEbsEncryptionByDefaultResponse] =
        visitor.disableEbsEncryptionByDefault(request)
    }

    final case class DisableFastSnapshotRestores(
      request: DisableFastSnapshotRestoresRequest
    ) extends Ec2Op[DisableFastSnapshotRestoresResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableFastSnapshotRestoresResponse] =
        visitor.disableFastSnapshotRestores(request)
    }

    final case class DisableImageDeprecation(
      request: DisableImageDeprecationRequest
    ) extends Ec2Op[DisableImageDeprecationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableImageDeprecationResponse] =
        visitor.disableImageDeprecation(request)
    }

    final case class DisableSerialConsoleAccess(
      request: DisableSerialConsoleAccessRequest
    ) extends Ec2Op[DisableSerialConsoleAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableSerialConsoleAccessResponse] =
        visitor.disableSerialConsoleAccess(request)
    }

    final case class DisableTransitGatewayRouteTablePropagation(
      request: DisableTransitGatewayRouteTablePropagationRequest
    ) extends Ec2Op[DisableTransitGatewayRouteTablePropagationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableTransitGatewayRouteTablePropagationResponse] =
        visitor.disableTransitGatewayRouteTablePropagation(request)
    }

    final case class DisableVgwRoutePropagation(
      request: DisableVgwRoutePropagationRequest
    ) extends Ec2Op[DisableVgwRoutePropagationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableVgwRoutePropagationResponse] =
        visitor.disableVgwRoutePropagation(request)
    }

    final case class DisableVpcClassicLink(
      request: DisableVpcClassicLinkRequest
    ) extends Ec2Op[DisableVpcClassicLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableVpcClassicLinkResponse] =
        visitor.disableVpcClassicLink(request)
    }

    final case class DisableVpcClassicLinkDnsSupport(
      request: DisableVpcClassicLinkDnsSupportRequest
    ) extends Ec2Op[DisableVpcClassicLinkDnsSupportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableVpcClassicLinkDnsSupportResponse] =
        visitor.disableVpcClassicLinkDnsSupport(request)
    }

    final case class DisassociateAddress(
      request: DisassociateAddressRequest
    ) extends Ec2Op[DisassociateAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateAddressResponse] =
        visitor.disassociateAddress(request)
    }

    final case class DisassociateClientVpnTargetNetwork(
      request: DisassociateClientVpnTargetNetworkRequest
    ) extends Ec2Op[DisassociateClientVpnTargetNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateClientVpnTargetNetworkResponse] =
        visitor.disassociateClientVpnTargetNetwork(request)
    }

    final case class DisassociateEnclaveCertificateIamRole(
      request: DisassociateEnclaveCertificateIamRoleRequest
    ) extends Ec2Op[DisassociateEnclaveCertificateIamRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateEnclaveCertificateIamRoleResponse] =
        visitor.disassociateEnclaveCertificateIamRole(request)
    }

    final case class DisassociateIamInstanceProfile(
      request: DisassociateIamInstanceProfileRequest
    ) extends Ec2Op[DisassociateIamInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateIamInstanceProfileResponse] =
        visitor.disassociateIamInstanceProfile(request)
    }

    final case class DisassociateRouteTable(
      request: DisassociateRouteTableRequest
    ) extends Ec2Op[DisassociateRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateRouteTableResponse] =
        visitor.disassociateRouteTable(request)
    }

    final case class DisassociateSubnetCidrBlock(
      request: DisassociateSubnetCidrBlockRequest
    ) extends Ec2Op[DisassociateSubnetCidrBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateSubnetCidrBlockResponse] =
        visitor.disassociateSubnetCidrBlock(request)
    }

    final case class DisassociateTransitGatewayMulticastDomain(
      request: DisassociateTransitGatewayMulticastDomainRequest
    ) extends Ec2Op[DisassociateTransitGatewayMulticastDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateTransitGatewayMulticastDomainResponse] =
        visitor.disassociateTransitGatewayMulticastDomain(request)
    }

    final case class DisassociateTransitGatewayRouteTable(
      request: DisassociateTransitGatewayRouteTableRequest
    ) extends Ec2Op[DisassociateTransitGatewayRouteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateTransitGatewayRouteTableResponse] =
        visitor.disassociateTransitGatewayRouteTable(request)
    }

    final case class DisassociateVpcCidrBlock(
      request: DisassociateVpcCidrBlockRequest
    ) extends Ec2Op[DisassociateVpcCidrBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateVpcCidrBlockResponse] =
        visitor.disassociateVpcCidrBlock(request)
    }

    final case class EnableEbsEncryptionByDefault(
      request: EnableEbsEncryptionByDefaultRequest
    ) extends Ec2Op[EnableEbsEncryptionByDefaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableEbsEncryptionByDefaultResponse] =
        visitor.enableEbsEncryptionByDefault(request)
    }

    final case class EnableFastSnapshotRestores(
      request: EnableFastSnapshotRestoresRequest
    ) extends Ec2Op[EnableFastSnapshotRestoresResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableFastSnapshotRestoresResponse] =
        visitor.enableFastSnapshotRestores(request)
    }

    final case class EnableImageDeprecation(
      request: EnableImageDeprecationRequest
    ) extends Ec2Op[EnableImageDeprecationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableImageDeprecationResponse] =
        visitor.enableImageDeprecation(request)
    }

    final case class EnableSerialConsoleAccess(
      request: EnableSerialConsoleAccessRequest
    ) extends Ec2Op[EnableSerialConsoleAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableSerialConsoleAccessResponse] =
        visitor.enableSerialConsoleAccess(request)
    }

    final case class EnableTransitGatewayRouteTablePropagation(
      request: EnableTransitGatewayRouteTablePropagationRequest
    ) extends Ec2Op[EnableTransitGatewayRouteTablePropagationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableTransitGatewayRouteTablePropagationResponse] =
        visitor.enableTransitGatewayRouteTablePropagation(request)
    }

    final case class EnableVgwRoutePropagation(
      request: EnableVgwRoutePropagationRequest
    ) extends Ec2Op[EnableVgwRoutePropagationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableVgwRoutePropagationResponse] =
        visitor.enableVgwRoutePropagation(request)
    }

    final case class EnableVolumeIO(
      request: EnableVolumeIoRequest
    ) extends Ec2Op[EnableVolumeIoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableVolumeIoResponse] =
        visitor.enableVolumeIO(request)
    }

    final case class EnableVpcClassicLink(
      request: EnableVpcClassicLinkRequest
    ) extends Ec2Op[EnableVpcClassicLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableVpcClassicLinkResponse] =
        visitor.enableVpcClassicLink(request)
    }

    final case class EnableVpcClassicLinkDnsSupport(
      request: EnableVpcClassicLinkDnsSupportRequest
    ) extends Ec2Op[EnableVpcClassicLinkDnsSupportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableVpcClassicLinkDnsSupportResponse] =
        visitor.enableVpcClassicLinkDnsSupport(request)
    }

    final case class ExportClientVpnClientCertificateRevocationList(
      request: ExportClientVpnClientCertificateRevocationListRequest
    ) extends Ec2Op[ExportClientVpnClientCertificateRevocationListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportClientVpnClientCertificateRevocationListResponse] =
        visitor.exportClientVpnClientCertificateRevocationList(request)
    }

    final case class ExportClientVpnClientConfiguration(
      request: ExportClientVpnClientConfigurationRequest
    ) extends Ec2Op[ExportClientVpnClientConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportClientVpnClientConfigurationResponse] =
        visitor.exportClientVpnClientConfiguration(request)
    }

    final case class ExportImage(
      request: ExportImageRequest
    ) extends Ec2Op[ExportImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportImageResponse] =
        visitor.exportImage(request)
    }

    final case class ExportTransitGatewayRoutes(
      request: ExportTransitGatewayRoutesRequest
    ) extends Ec2Op[ExportTransitGatewayRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportTransitGatewayRoutesResponse] =
        visitor.exportTransitGatewayRoutes(request)
    }

    final case class GetAssociatedEnclaveCertificateIamRoles(
      request: GetAssociatedEnclaveCertificateIamRolesRequest
    ) extends Ec2Op[GetAssociatedEnclaveCertificateIamRolesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssociatedEnclaveCertificateIamRolesResponse] =
        visitor.getAssociatedEnclaveCertificateIamRoles(request)
    }

    final case class GetAssociatedIpv6PoolCidrs(
      request: GetAssociatedIpv6PoolCidrsRequest
    ) extends Ec2Op[GetAssociatedIpv6PoolCidrsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssociatedIpv6PoolCidrsResponse] =
        visitor.getAssociatedIpv6PoolCidrs(request)
    }

    final case class GetCapacityReservationUsage(
      request: GetCapacityReservationUsageRequest
    ) extends Ec2Op[GetCapacityReservationUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCapacityReservationUsageResponse] =
        visitor.getCapacityReservationUsage(request)
    }

    final case class GetCoipPoolUsage(
      request: GetCoipPoolUsageRequest
    ) extends Ec2Op[GetCoipPoolUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCoipPoolUsageResponse] =
        visitor.getCoipPoolUsage(request)
    }

    final case class GetConsoleOutput(
      request: GetConsoleOutputRequest
    ) extends Ec2Op[GetConsoleOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConsoleOutputResponse] =
        visitor.getConsoleOutput(request)
    }

    final case class GetConsoleScreenshot(
      request: GetConsoleScreenshotRequest
    ) extends Ec2Op[GetConsoleScreenshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConsoleScreenshotResponse] =
        visitor.getConsoleScreenshot(request)
    }

    final case class GetDefaultCreditSpecification(
      request: GetDefaultCreditSpecificationRequest
    ) extends Ec2Op[GetDefaultCreditSpecificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDefaultCreditSpecificationResponse] =
        visitor.getDefaultCreditSpecification(request)
    }

    final case class GetEbsDefaultKmsKeyId(
      request: GetEbsDefaultKmsKeyIdRequest
    ) extends Ec2Op[GetEbsDefaultKmsKeyIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEbsDefaultKmsKeyIdResponse] =
        visitor.getEbsDefaultKmsKeyId(request)
    }

    final case class GetEbsEncryptionByDefault(
      request: GetEbsEncryptionByDefaultRequest
    ) extends Ec2Op[GetEbsEncryptionByDefaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEbsEncryptionByDefaultResponse] =
        visitor.getEbsEncryptionByDefault(request)
    }

    final case class GetFlowLogsIntegrationTemplate(
      request: GetFlowLogsIntegrationTemplateRequest
    ) extends Ec2Op[GetFlowLogsIntegrationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFlowLogsIntegrationTemplateResponse] =
        visitor.getFlowLogsIntegrationTemplate(request)
    }

    final case class GetGroupsForCapacityReservation(
      request: GetGroupsForCapacityReservationRequest
    ) extends Ec2Op[GetGroupsForCapacityReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupsForCapacityReservationResponse] =
        visitor.getGroupsForCapacityReservation(request)
    }

    final case class GetHostReservationPurchasePreview(
      request: GetHostReservationPurchasePreviewRequest
    ) extends Ec2Op[GetHostReservationPurchasePreviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHostReservationPurchasePreviewResponse] =
        visitor.getHostReservationPurchasePreview(request)
    }

    final case class GetLaunchTemplateData(
      request: GetLaunchTemplateDataRequest
    ) extends Ec2Op[GetLaunchTemplateDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLaunchTemplateDataResponse] =
        visitor.getLaunchTemplateData(request)
    }

    final case class GetManagedPrefixListAssociations(
      request: GetManagedPrefixListAssociationsRequest
    ) extends Ec2Op[GetManagedPrefixListAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetManagedPrefixListAssociationsResponse] =
        visitor.getManagedPrefixListAssociations(request)
    }

    final case class GetManagedPrefixListEntries(
      request: GetManagedPrefixListEntriesRequest
    ) extends Ec2Op[GetManagedPrefixListEntriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetManagedPrefixListEntriesResponse] =
        visitor.getManagedPrefixListEntries(request)
    }

    final case class GetPasswordData(
      request: GetPasswordDataRequest
    ) extends Ec2Op[GetPasswordDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPasswordDataResponse] =
        visitor.getPasswordData(request)
    }

    final case class GetReservedInstancesExchangeQuote(
      request: GetReservedInstancesExchangeQuoteRequest
    ) extends Ec2Op[GetReservedInstancesExchangeQuoteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReservedInstancesExchangeQuoteResponse] =
        visitor.getReservedInstancesExchangeQuote(request)
    }

    final case class GetSerialConsoleAccessStatus(
      request: GetSerialConsoleAccessStatusRequest
    ) extends Ec2Op[GetSerialConsoleAccessStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSerialConsoleAccessStatusResponse] =
        visitor.getSerialConsoleAccessStatus(request)
    }

    final case class GetTransitGatewayAttachmentPropagations(
      request: GetTransitGatewayAttachmentPropagationsRequest
    ) extends Ec2Op[GetTransitGatewayAttachmentPropagationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTransitGatewayAttachmentPropagationsResponse] =
        visitor.getTransitGatewayAttachmentPropagations(request)
    }

    final case class GetTransitGatewayMulticastDomainAssociations(
      request: GetTransitGatewayMulticastDomainAssociationsRequest
    ) extends Ec2Op[GetTransitGatewayMulticastDomainAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTransitGatewayMulticastDomainAssociationsResponse] =
        visitor.getTransitGatewayMulticastDomainAssociations(request)
    }

    final case class GetTransitGatewayPrefixListReferences(
      request: GetTransitGatewayPrefixListReferencesRequest
    ) extends Ec2Op[GetTransitGatewayPrefixListReferencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTransitGatewayPrefixListReferencesResponse] =
        visitor.getTransitGatewayPrefixListReferences(request)
    }

    final case class GetTransitGatewayRouteTableAssociations(
      request: GetTransitGatewayRouteTableAssociationsRequest
    ) extends Ec2Op[GetTransitGatewayRouteTableAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTransitGatewayRouteTableAssociationsResponse] =
        visitor.getTransitGatewayRouteTableAssociations(request)
    }

    final case class GetTransitGatewayRouteTablePropagations(
      request: GetTransitGatewayRouteTablePropagationsRequest
    ) extends Ec2Op[GetTransitGatewayRouteTablePropagationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTransitGatewayRouteTablePropagationsResponse] =
        visitor.getTransitGatewayRouteTablePropagations(request)
    }

    final case class ImportClientVpnClientCertificateRevocationList(
      request: ImportClientVpnClientCertificateRevocationListRequest
    ) extends Ec2Op[ImportClientVpnClientCertificateRevocationListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportClientVpnClientCertificateRevocationListResponse] =
        visitor.importClientVpnClientCertificateRevocationList(request)
    }

    final case class ImportImage(
      request: ImportImageRequest
    ) extends Ec2Op[ImportImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportImageResponse] =
        visitor.importImage(request)
    }

    final case class ImportInstance(
      request: ImportInstanceRequest
    ) extends Ec2Op[ImportInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportInstanceResponse] =
        visitor.importInstance(request)
    }

    final case class ImportKeyPair(
      request: ImportKeyPairRequest
    ) extends Ec2Op[ImportKeyPairResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportKeyPairResponse] =
        visitor.importKeyPair(request)
    }

    final case class ImportSnapshot(
      request: ImportSnapshotRequest
    ) extends Ec2Op[ImportSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportSnapshotResponse] =
        visitor.importSnapshot(request)
    }

    final case class ImportVolume(
      request: ImportVolumeRequest
    ) extends Ec2Op[ImportVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportVolumeResponse] =
        visitor.importVolume(request)
    }

    final case class ModifyAddressAttribute(
      request: ModifyAddressAttributeRequest
    ) extends Ec2Op[ModifyAddressAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyAddressAttributeResponse] =
        visitor.modifyAddressAttribute(request)
    }

    final case class ModifyAvailabilityZoneGroup(
      request: ModifyAvailabilityZoneGroupRequest
    ) extends Ec2Op[ModifyAvailabilityZoneGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyAvailabilityZoneGroupResponse] =
        visitor.modifyAvailabilityZoneGroup(request)
    }

    final case class ModifyCapacityReservation(
      request: ModifyCapacityReservationRequest
    ) extends Ec2Op[ModifyCapacityReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyCapacityReservationResponse] =
        visitor.modifyCapacityReservation(request)
    }

    final case class ModifyClientVpnEndpoint(
      request: ModifyClientVpnEndpointRequest
    ) extends Ec2Op[ModifyClientVpnEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClientVpnEndpointResponse] =
        visitor.modifyClientVpnEndpoint(request)
    }

    final case class ModifyDefaultCreditSpecification(
      request: ModifyDefaultCreditSpecificationRequest
    ) extends Ec2Op[ModifyDefaultCreditSpecificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDefaultCreditSpecificationResponse] =
        visitor.modifyDefaultCreditSpecification(request)
    }

    final case class ModifyEbsDefaultKmsKeyId(
      request: ModifyEbsDefaultKmsKeyIdRequest
    ) extends Ec2Op[ModifyEbsDefaultKmsKeyIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEbsDefaultKmsKeyIdResponse] =
        visitor.modifyEbsDefaultKmsKeyId(request)
    }

    final case class ModifyFleet(
      request: ModifyFleetRequest
    ) extends Ec2Op[ModifyFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyFleetResponse] =
        visitor.modifyFleet(request)
    }

    final case class ModifyFpgaImageAttribute(
      request: ModifyFpgaImageAttributeRequest
    ) extends Ec2Op[ModifyFpgaImageAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyFpgaImageAttributeResponse] =
        visitor.modifyFpgaImageAttribute(request)
    }

    final case class ModifyHosts(
      request: ModifyHostsRequest
    ) extends Ec2Op[ModifyHostsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyHostsResponse] =
        visitor.modifyHosts(request)
    }

    final case class ModifyIdFormat(
      request: ModifyIdFormatRequest
    ) extends Ec2Op[ModifyIdFormatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyIdFormatResponse] =
        visitor.modifyIdFormat(request)
    }

    final case class ModifyIdentityIdFormat(
      request: ModifyIdentityIdFormatRequest
    ) extends Ec2Op[ModifyIdentityIdFormatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyIdentityIdFormatResponse] =
        visitor.modifyIdentityIdFormat(request)
    }

    final case class ModifyImageAttribute(
      request: ModifyImageAttributeRequest
    ) extends Ec2Op[ModifyImageAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyImageAttributeResponse] =
        visitor.modifyImageAttribute(request)
    }

    final case class ModifyInstanceAttribute(
      request: ModifyInstanceAttributeRequest
    ) extends Ec2Op[ModifyInstanceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstanceAttributeResponse] =
        visitor.modifyInstanceAttribute(request)
    }

    final case class ModifyInstanceCapacityReservationAttributes(
      request: ModifyInstanceCapacityReservationAttributesRequest
    ) extends Ec2Op[ModifyInstanceCapacityReservationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstanceCapacityReservationAttributesResponse] =
        visitor.modifyInstanceCapacityReservationAttributes(request)
    }

    final case class ModifyInstanceCreditSpecification(
      request: ModifyInstanceCreditSpecificationRequest
    ) extends Ec2Op[ModifyInstanceCreditSpecificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstanceCreditSpecificationResponse] =
        visitor.modifyInstanceCreditSpecification(request)
    }

    final case class ModifyInstanceEventStartTime(
      request: ModifyInstanceEventStartTimeRequest
    ) extends Ec2Op[ModifyInstanceEventStartTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstanceEventStartTimeResponse] =
        visitor.modifyInstanceEventStartTime(request)
    }

    final case class ModifyInstanceMetadataOptions(
      request: ModifyInstanceMetadataOptionsRequest
    ) extends Ec2Op[ModifyInstanceMetadataOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstanceMetadataOptionsResponse] =
        visitor.modifyInstanceMetadataOptions(request)
    }

    final case class ModifyInstancePlacement(
      request: ModifyInstancePlacementRequest
    ) extends Ec2Op[ModifyInstancePlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstancePlacementResponse] =
        visitor.modifyInstancePlacement(request)
    }

    final case class ModifyLaunchTemplate(
      request: ModifyLaunchTemplateRequest
    ) extends Ec2Op[ModifyLaunchTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyLaunchTemplateResponse] =
        visitor.modifyLaunchTemplate(request)
    }

    final case class ModifyManagedPrefixList(
      request: ModifyManagedPrefixListRequest
    ) extends Ec2Op[ModifyManagedPrefixListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyManagedPrefixListResponse] =
        visitor.modifyManagedPrefixList(request)
    }

    final case class ModifyNetworkInterfaceAttribute(
      request: ModifyNetworkInterfaceAttributeRequest
    ) extends Ec2Op[ModifyNetworkInterfaceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyNetworkInterfaceAttributeResponse] =
        visitor.modifyNetworkInterfaceAttribute(request)
    }

    final case class ModifyReservedInstances(
      request: ModifyReservedInstancesRequest
    ) extends Ec2Op[ModifyReservedInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyReservedInstancesResponse] =
        visitor.modifyReservedInstances(request)
    }

    final case class ModifySnapshotAttribute(
      request: ModifySnapshotAttributeRequest
    ) extends Ec2Op[ModifySnapshotAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifySnapshotAttributeResponse] =
        visitor.modifySnapshotAttribute(request)
    }

    final case class ModifySpotFleetRequest(
      request: ModifySpotFleetRequestRequest
    ) extends Ec2Op[ModifySpotFleetRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifySpotFleetRequestResponse] =
        visitor.modifySpotFleetRequest(request)
    }

    final case class ModifySubnetAttribute(
      request: ModifySubnetAttributeRequest
    ) extends Ec2Op[ModifySubnetAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifySubnetAttributeResponse] =
        visitor.modifySubnetAttribute(request)
    }

    final case class ModifyTrafficMirrorFilterNetworkServices(
      request: ModifyTrafficMirrorFilterNetworkServicesRequest
    ) extends Ec2Op[ModifyTrafficMirrorFilterNetworkServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTrafficMirrorFilterNetworkServicesResponse] =
        visitor.modifyTrafficMirrorFilterNetworkServices(request)
    }

    final case class ModifyTrafficMirrorFilterRule(
      request: ModifyTrafficMirrorFilterRuleRequest
    ) extends Ec2Op[ModifyTrafficMirrorFilterRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTrafficMirrorFilterRuleResponse] =
        visitor.modifyTrafficMirrorFilterRule(request)
    }

    final case class ModifyTrafficMirrorSession(
      request: ModifyTrafficMirrorSessionRequest
    ) extends Ec2Op[ModifyTrafficMirrorSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTrafficMirrorSessionResponse] =
        visitor.modifyTrafficMirrorSession(request)
    }

    final case class ModifyTransitGateway(
      request: ModifyTransitGatewayRequest
    ) extends Ec2Op[ModifyTransitGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTransitGatewayResponse] =
        visitor.modifyTransitGateway(request)
    }

    final case class ModifyTransitGatewayPrefixListReference(
      request: ModifyTransitGatewayPrefixListReferenceRequest
    ) extends Ec2Op[ModifyTransitGatewayPrefixListReferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTransitGatewayPrefixListReferenceResponse] =
        visitor.modifyTransitGatewayPrefixListReference(request)
    }

    final case class ModifyTransitGatewayVpcAttachment(
      request: ModifyTransitGatewayVpcAttachmentRequest
    ) extends Ec2Op[ModifyTransitGatewayVpcAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTransitGatewayVpcAttachmentResponse] =
        visitor.modifyTransitGatewayVpcAttachment(request)
    }

    final case class ModifyVolume(
      request: ModifyVolumeRequest
    ) extends Ec2Op[ModifyVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVolumeResponse] =
        visitor.modifyVolume(request)
    }

    final case class ModifyVolumeAttribute(
      request: ModifyVolumeAttributeRequest
    ) extends Ec2Op[ModifyVolumeAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVolumeAttributeResponse] =
        visitor.modifyVolumeAttribute(request)
    }

    final case class ModifyVpcAttribute(
      request: ModifyVpcAttributeRequest
    ) extends Ec2Op[ModifyVpcAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpcAttributeResponse] =
        visitor.modifyVpcAttribute(request)
    }

    final case class ModifyVpcEndpoint(
      request: ModifyVpcEndpointRequest
    ) extends Ec2Op[ModifyVpcEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpcEndpointResponse] =
        visitor.modifyVpcEndpoint(request)
    }

    final case class ModifyVpcEndpointConnectionNotification(
      request: ModifyVpcEndpointConnectionNotificationRequest
    ) extends Ec2Op[ModifyVpcEndpointConnectionNotificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpcEndpointConnectionNotificationResponse] =
        visitor.modifyVpcEndpointConnectionNotification(request)
    }

    final case class ModifyVpcEndpointServiceConfiguration(
      request: ModifyVpcEndpointServiceConfigurationRequest
    ) extends Ec2Op[ModifyVpcEndpointServiceConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpcEndpointServiceConfigurationResponse] =
        visitor.modifyVpcEndpointServiceConfiguration(request)
    }

    final case class ModifyVpcEndpointServicePermissions(
      request: ModifyVpcEndpointServicePermissionsRequest
    ) extends Ec2Op[ModifyVpcEndpointServicePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpcEndpointServicePermissionsResponse] =
        visitor.modifyVpcEndpointServicePermissions(request)
    }

    final case class ModifyVpcPeeringConnectionOptions(
      request: ModifyVpcPeeringConnectionOptionsRequest
    ) extends Ec2Op[ModifyVpcPeeringConnectionOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpcPeeringConnectionOptionsResponse] =
        visitor.modifyVpcPeeringConnectionOptions(request)
    }

    final case class ModifyVpcTenancy(
      request: ModifyVpcTenancyRequest
    ) extends Ec2Op[ModifyVpcTenancyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpcTenancyResponse] =
        visitor.modifyVpcTenancy(request)
    }

    final case class ModifyVpnConnection(
      request: ModifyVpnConnectionRequest
    ) extends Ec2Op[ModifyVpnConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpnConnectionResponse] =
        visitor.modifyVpnConnection(request)
    }

    final case class ModifyVpnConnectionOptions(
      request: ModifyVpnConnectionOptionsRequest
    ) extends Ec2Op[ModifyVpnConnectionOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpnConnectionOptionsResponse] =
        visitor.modifyVpnConnectionOptions(request)
    }

    final case class ModifyVpnTunnelCertificate(
      request: ModifyVpnTunnelCertificateRequest
    ) extends Ec2Op[ModifyVpnTunnelCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpnTunnelCertificateResponse] =
        visitor.modifyVpnTunnelCertificate(request)
    }

    final case class ModifyVpnTunnelOptions(
      request: ModifyVpnTunnelOptionsRequest
    ) extends Ec2Op[ModifyVpnTunnelOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyVpnTunnelOptionsResponse] =
        visitor.modifyVpnTunnelOptions(request)
    }

    final case class MonitorInstances(
      request: MonitorInstancesRequest
    ) extends Ec2Op[MonitorInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MonitorInstancesResponse] =
        visitor.monitorInstances(request)
    }

    final case class MoveAddressToVpc(
      request: MoveAddressToVpcRequest
    ) extends Ec2Op[MoveAddressToVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MoveAddressToVpcResponse] =
        visitor.moveAddressToVpc(request)
    }

    final case class ProvisionByoipCidr(
      request: ProvisionByoipCidrRequest
    ) extends Ec2Op[ProvisionByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ProvisionByoipCidrResponse] =
        visitor.provisionByoipCidr(request)
    }

    final case class PurchaseHostReservation(
      request: PurchaseHostReservationRequest
    ) extends Ec2Op[PurchaseHostReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseHostReservationResponse] =
        visitor.purchaseHostReservation(request)
    }

    final case class PurchaseReservedInstancesOffering(
      request: PurchaseReservedInstancesOfferingRequest
    ) extends Ec2Op[PurchaseReservedInstancesOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseReservedInstancesOfferingResponse] =
        visitor.purchaseReservedInstancesOffering(request)
    }

    final case class PurchaseScheduledInstances(
      request: PurchaseScheduledInstancesRequest
    ) extends Ec2Op[PurchaseScheduledInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseScheduledInstancesResponse] =
        visitor.purchaseScheduledInstances(request)
    }

    final case class RebootInstances(
      request: RebootInstancesRequest
    ) extends Ec2Op[RebootInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootInstancesResponse] =
        visitor.rebootInstances(request)
    }

    final case class RegisterImage(
      request: RegisterImageRequest
    ) extends Ec2Op[RegisterImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterImageResponse] =
        visitor.registerImage(request)
    }

    final case class RegisterInstanceEventNotificationAttributes(
      request: RegisterInstanceEventNotificationAttributesRequest
    ) extends Ec2Op[RegisterInstanceEventNotificationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterInstanceEventNotificationAttributesResponse] =
        visitor.registerInstanceEventNotificationAttributes(request)
    }

    final case class RegisterTransitGatewayMulticastGroupMembers(
      request: RegisterTransitGatewayMulticastGroupMembersRequest
    ) extends Ec2Op[RegisterTransitGatewayMulticastGroupMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTransitGatewayMulticastGroupMembersResponse] =
        visitor.registerTransitGatewayMulticastGroupMembers(request)
    }

    final case class RegisterTransitGatewayMulticastGroupSources(
      request: RegisterTransitGatewayMulticastGroupSourcesRequest
    ) extends Ec2Op[RegisterTransitGatewayMulticastGroupSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTransitGatewayMulticastGroupSourcesResponse] =
        visitor.registerTransitGatewayMulticastGroupSources(request)
    }

    final case class RejectTransitGatewayMulticastDomainAssociations(
      request: RejectTransitGatewayMulticastDomainAssociationsRequest
    ) extends Ec2Op[RejectTransitGatewayMulticastDomainAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectTransitGatewayMulticastDomainAssociationsResponse] =
        visitor.rejectTransitGatewayMulticastDomainAssociations(request)
    }

    final case class RejectTransitGatewayPeeringAttachment(
      request: RejectTransitGatewayPeeringAttachmentRequest
    ) extends Ec2Op[RejectTransitGatewayPeeringAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectTransitGatewayPeeringAttachmentResponse] =
        visitor.rejectTransitGatewayPeeringAttachment(request)
    }

    final case class RejectTransitGatewayVpcAttachment(
      request: RejectTransitGatewayVpcAttachmentRequest
    ) extends Ec2Op[RejectTransitGatewayVpcAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectTransitGatewayVpcAttachmentResponse] =
        visitor.rejectTransitGatewayVpcAttachment(request)
    }

    final case class RejectVpcEndpointConnections(
      request: RejectVpcEndpointConnectionsRequest
    ) extends Ec2Op[RejectVpcEndpointConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectVpcEndpointConnectionsResponse] =
        visitor.rejectVpcEndpointConnections(request)
    }

    final case class RejectVpcPeeringConnection(
      request: RejectVpcPeeringConnectionRequest
    ) extends Ec2Op[RejectVpcPeeringConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectVpcPeeringConnectionResponse] =
        visitor.rejectVpcPeeringConnection(request)
    }

    final case class ReleaseAddress(
      request: ReleaseAddressRequest
    ) extends Ec2Op[ReleaseAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReleaseAddressResponse] =
        visitor.releaseAddress(request)
    }

    final case class ReleaseHosts(
      request: ReleaseHostsRequest
    ) extends Ec2Op[ReleaseHostsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReleaseHostsResponse] =
        visitor.releaseHosts(request)
    }

    final case class ReplaceIamInstanceProfileAssociation(
      request: ReplaceIamInstanceProfileAssociationRequest
    ) extends Ec2Op[ReplaceIamInstanceProfileAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplaceIamInstanceProfileAssociationResponse] =
        visitor.replaceIamInstanceProfileAssociation(request)
    }

    final case class ReplaceNetworkAclAssociation(
      request: ReplaceNetworkAclAssociationRequest
    ) extends Ec2Op[ReplaceNetworkAclAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplaceNetworkAclAssociationResponse] =
        visitor.replaceNetworkAclAssociation(request)
    }

    final case class ReplaceNetworkAclEntry(
      request: ReplaceNetworkAclEntryRequest
    ) extends Ec2Op[ReplaceNetworkAclEntryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplaceNetworkAclEntryResponse] =
        visitor.replaceNetworkAclEntry(request)
    }

    final case class ReplaceRoute(
      request: ReplaceRouteRequest
    ) extends Ec2Op[ReplaceRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplaceRouteResponse] =
        visitor.replaceRoute(request)
    }

    final case class ReplaceRouteTableAssociation(
      request: ReplaceRouteTableAssociationRequest
    ) extends Ec2Op[ReplaceRouteTableAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplaceRouteTableAssociationResponse] =
        visitor.replaceRouteTableAssociation(request)
    }

    final case class ReplaceTransitGatewayRoute(
      request: ReplaceTransitGatewayRouteRequest
    ) extends Ec2Op[ReplaceTransitGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplaceTransitGatewayRouteResponse] =
        visitor.replaceTransitGatewayRoute(request)
    }

    final case class ReportInstanceStatus(
      request: ReportInstanceStatusRequest
    ) extends Ec2Op[ReportInstanceStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReportInstanceStatusResponse] =
        visitor.reportInstanceStatus(request)
    }

    final case class RequestSpotFleet(
      request: RequestSpotFleetRequest
    ) extends Ec2Op[RequestSpotFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RequestSpotFleetResponse] =
        visitor.requestSpotFleet(request)
    }

    final case class RequestSpotInstances(
      request: RequestSpotInstancesRequest
    ) extends Ec2Op[RequestSpotInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RequestSpotInstancesResponse] =
        visitor.requestSpotInstances(request)
    }

    final case class ResetAddressAttribute(
      request: ResetAddressAttributeRequest
    ) extends Ec2Op[ResetAddressAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetAddressAttributeResponse] =
        visitor.resetAddressAttribute(request)
    }

    final case class ResetEbsDefaultKmsKeyId(
      request: ResetEbsDefaultKmsKeyIdRequest
    ) extends Ec2Op[ResetEbsDefaultKmsKeyIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetEbsDefaultKmsKeyIdResponse] =
        visitor.resetEbsDefaultKmsKeyId(request)
    }

    final case class ResetFpgaImageAttribute(
      request: ResetFpgaImageAttributeRequest
    ) extends Ec2Op[ResetFpgaImageAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetFpgaImageAttributeResponse] =
        visitor.resetFpgaImageAttribute(request)
    }

    final case class ResetImageAttribute(
      request: ResetImageAttributeRequest
    ) extends Ec2Op[ResetImageAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetImageAttributeResponse] =
        visitor.resetImageAttribute(request)
    }

    final case class ResetInstanceAttribute(
      request: ResetInstanceAttributeRequest
    ) extends Ec2Op[ResetInstanceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetInstanceAttributeResponse] =
        visitor.resetInstanceAttribute(request)
    }

    final case class ResetNetworkInterfaceAttribute(
      request: ResetNetworkInterfaceAttributeRequest
    ) extends Ec2Op[ResetNetworkInterfaceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetNetworkInterfaceAttributeResponse] =
        visitor.resetNetworkInterfaceAttribute(request)
    }

    final case class ResetSnapshotAttribute(
      request: ResetSnapshotAttributeRequest
    ) extends Ec2Op[ResetSnapshotAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetSnapshotAttributeResponse] =
        visitor.resetSnapshotAttribute(request)
    }

    final case class RestoreAddressToClassic(
      request: RestoreAddressToClassicRequest
    ) extends Ec2Op[RestoreAddressToClassicResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreAddressToClassicResponse] =
        visitor.restoreAddressToClassic(request)
    }

    final case class RestoreManagedPrefixListVersion(
      request: RestoreManagedPrefixListVersionRequest
    ) extends Ec2Op[RestoreManagedPrefixListVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreManagedPrefixListVersionResponse] =
        visitor.restoreManagedPrefixListVersion(request)
    }

    final case class RevokeClientVpnIngress(
      request: RevokeClientVpnIngressRequest
    ) extends Ec2Op[RevokeClientVpnIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeClientVpnIngressResponse] =
        visitor.revokeClientVpnIngress(request)
    }

    final case class RevokeSecurityGroupEgress(
      request: RevokeSecurityGroupEgressRequest
    ) extends Ec2Op[RevokeSecurityGroupEgressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeSecurityGroupEgressResponse] =
        visitor.revokeSecurityGroupEgress(request)
    }

    final case class RevokeSecurityGroupIngress(
      request: RevokeSecurityGroupIngressRequest
    ) extends Ec2Op[RevokeSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeSecurityGroupIngressResponse] =
        visitor.revokeSecurityGroupIngress(request)
    }

    final case class RunInstances(
      request: RunInstancesRequest
    ) extends Ec2Op[RunInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RunInstancesResponse] =
        visitor.runInstances(request)
    }

    final case class RunScheduledInstances(
      request: RunScheduledInstancesRequest
    ) extends Ec2Op[RunScheduledInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RunScheduledInstancesResponse] =
        visitor.runScheduledInstances(request)
    }

    final case class SearchLocalGatewayRoutes(
      request: SearchLocalGatewayRoutesRequest
    ) extends Ec2Op[SearchLocalGatewayRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchLocalGatewayRoutesResponse] =
        visitor.searchLocalGatewayRoutes(request)
    }

    final case class SearchTransitGatewayMulticastGroups(
      request: SearchTransitGatewayMulticastGroupsRequest
    ) extends Ec2Op[SearchTransitGatewayMulticastGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchTransitGatewayMulticastGroupsResponse] =
        visitor.searchTransitGatewayMulticastGroups(request)
    }

    final case class SearchTransitGatewayRoutes(
      request: SearchTransitGatewayRoutesRequest
    ) extends Ec2Op[SearchTransitGatewayRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchTransitGatewayRoutesResponse] =
        visitor.searchTransitGatewayRoutes(request)
    }

    final case class SendDiagnosticInterrupt(
      request: SendDiagnosticInterruptRequest
    ) extends Ec2Op[SendDiagnosticInterruptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendDiagnosticInterruptResponse] =
        visitor.sendDiagnosticInterrupt(request)
    }

    final case class StartInstances(
      request: StartInstancesRequest
    ) extends Ec2Op[StartInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartInstancesResponse] =
        visitor.startInstances(request)
    }

    final case class StartNetworkInsightsAnalysis(
      request: StartNetworkInsightsAnalysisRequest
    ) extends Ec2Op[StartNetworkInsightsAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartNetworkInsightsAnalysisResponse] =
        visitor.startNetworkInsightsAnalysis(request)
    }

    final case class StartVpcEndpointServicePrivateDnsVerification(
      request: StartVpcEndpointServicePrivateDnsVerificationRequest
    ) extends Ec2Op[StartVpcEndpointServicePrivateDnsVerificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartVpcEndpointServicePrivateDnsVerificationResponse] =
        visitor.startVpcEndpointServicePrivateDnsVerification(request)
    }

    final case class StopInstances(
      request: StopInstancesRequest
    ) extends Ec2Op[StopInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopInstancesResponse] =
        visitor.stopInstances(request)
    }

    final case class TerminateClientVpnConnections(
      request: TerminateClientVpnConnectionsRequest
    ) extends Ec2Op[TerminateClientVpnConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateClientVpnConnectionsResponse] =
        visitor.terminateClientVpnConnections(request)
    }

    final case class TerminateInstances(
      request: TerminateInstancesRequest
    ) extends Ec2Op[TerminateInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateInstancesResponse] =
        visitor.terminateInstances(request)
    }

    final case class UnassignIpv6Addresses(
      request: UnassignIpv6AddressesRequest
    ) extends Ec2Op[UnassignIpv6AddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnassignIpv6AddressesResponse] =
        visitor.unassignIpv6Addresses(request)
    }

    final case class UnassignPrivateIpAddresses(
      request: UnassignPrivateIpAddressesRequest
    ) extends Ec2Op[UnassignPrivateIpAddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnassignPrivateIpAddressesResponse] =
        visitor.unassignPrivateIpAddresses(request)
    }

    final case class UnmonitorInstances(
      request: UnmonitorInstancesRequest
    ) extends Ec2Op[UnmonitorInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnmonitorInstancesResponse] =
        visitor.unmonitorInstances(request)
    }

    final case class UpdateSecurityGroupRuleDescriptionsEgress(
      request: UpdateSecurityGroupRuleDescriptionsEgressRequest
    ) extends Ec2Op[UpdateSecurityGroupRuleDescriptionsEgressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSecurityGroupRuleDescriptionsEgressResponse] =
        visitor.updateSecurityGroupRuleDescriptionsEgress(request)
    }

    final case class UpdateSecurityGroupRuleDescriptionsIngress(
      request: UpdateSecurityGroupRuleDescriptionsIngressRequest
    ) extends Ec2Op[UpdateSecurityGroupRuleDescriptionsIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSecurityGroupRuleDescriptionsIngressResponse] =
        visitor.updateSecurityGroupRuleDescriptionsIngress(request)
    }

    final case class WithdrawByoipCidr(
      request: WithdrawByoipCidrRequest
    ) extends Ec2Op[WithdrawByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[WithdrawByoipCidrResponse] =
        visitor.withdrawByoipCidr(request)
    }
  }

  import Ec2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Ec2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptReservedInstancesExchangeQuote(
    request: AcceptReservedInstancesExchangeQuoteRequest
  ): Ec2IO[AcceptReservedInstancesExchangeQuoteResponse] =
    FF.liftF(AcceptReservedInstancesExchangeQuote(request))

  def acceptTransitGatewayMulticastDomainAssociations(
    request: AcceptTransitGatewayMulticastDomainAssociationsRequest
  ): Ec2IO[AcceptTransitGatewayMulticastDomainAssociationsResponse] =
    FF.liftF(AcceptTransitGatewayMulticastDomainAssociations(request))

  def acceptTransitGatewayPeeringAttachment(
    request: AcceptTransitGatewayPeeringAttachmentRequest
  ): Ec2IO[AcceptTransitGatewayPeeringAttachmentResponse] =
    FF.liftF(AcceptTransitGatewayPeeringAttachment(request))

  def acceptTransitGatewayVpcAttachment(
    request: AcceptTransitGatewayVpcAttachmentRequest
  ): Ec2IO[AcceptTransitGatewayVpcAttachmentResponse] =
    FF.liftF(AcceptTransitGatewayVpcAttachment(request))

  def acceptVpcEndpointConnections(
    request: AcceptVpcEndpointConnectionsRequest
  ): Ec2IO[AcceptVpcEndpointConnectionsResponse] =
    FF.liftF(AcceptVpcEndpointConnections(request))

  def acceptVpcPeeringConnection(
    request: AcceptVpcPeeringConnectionRequest
  ): Ec2IO[AcceptVpcPeeringConnectionResponse] =
    FF.liftF(AcceptVpcPeeringConnection(request))

  def advertiseByoipCidr(
    request: AdvertiseByoipCidrRequest
  ): Ec2IO[AdvertiseByoipCidrResponse] =
    FF.liftF(AdvertiseByoipCidr(request))

  def allocateAddress(
    request: AllocateAddressRequest
  ): Ec2IO[AllocateAddressResponse] =
    FF.liftF(AllocateAddress(request))

  def allocateHosts(
    request: AllocateHostsRequest
  ): Ec2IO[AllocateHostsResponse] =
    FF.liftF(AllocateHosts(request))

  def applySecurityGroupsToClientVpnTargetNetwork(
    request: ApplySecurityGroupsToClientVpnTargetNetworkRequest
  ): Ec2IO[ApplySecurityGroupsToClientVpnTargetNetworkResponse] =
    FF.liftF(ApplySecurityGroupsToClientVpnTargetNetwork(request))

  def assignIpv6Addresses(
    request: AssignIpv6AddressesRequest
  ): Ec2IO[AssignIpv6AddressesResponse] =
    FF.liftF(AssignIpv6Addresses(request))

  def assignPrivateIpAddresses(
    request: AssignPrivateIpAddressesRequest
  ): Ec2IO[AssignPrivateIpAddressesResponse] =
    FF.liftF(AssignPrivateIpAddresses(request))

  def associateAddress(
    request: AssociateAddressRequest
  ): Ec2IO[AssociateAddressResponse] =
    FF.liftF(AssociateAddress(request))

  def associateClientVpnTargetNetwork(
    request: AssociateClientVpnTargetNetworkRequest
  ): Ec2IO[AssociateClientVpnTargetNetworkResponse] =
    FF.liftF(AssociateClientVpnTargetNetwork(request))

  def associateDhcpOptions(
    request: AssociateDhcpOptionsRequest
  ): Ec2IO[AssociateDhcpOptionsResponse] =
    FF.liftF(AssociateDhcpOptions(request))

  def associateEnclaveCertificateIamRole(
    request: AssociateEnclaveCertificateIamRoleRequest
  ): Ec2IO[AssociateEnclaveCertificateIamRoleResponse] =
    FF.liftF(AssociateEnclaveCertificateIamRole(request))

  def associateIamInstanceProfile(
    request: AssociateIamInstanceProfileRequest
  ): Ec2IO[AssociateIamInstanceProfileResponse] =
    FF.liftF(AssociateIamInstanceProfile(request))

  def associateRouteTable(
    request: AssociateRouteTableRequest
  ): Ec2IO[AssociateRouteTableResponse] =
    FF.liftF(AssociateRouteTable(request))

  def associateSubnetCidrBlock(
    request: AssociateSubnetCidrBlockRequest
  ): Ec2IO[AssociateSubnetCidrBlockResponse] =
    FF.liftF(AssociateSubnetCidrBlock(request))

  def associateTransitGatewayMulticastDomain(
    request: AssociateTransitGatewayMulticastDomainRequest
  ): Ec2IO[AssociateTransitGatewayMulticastDomainResponse] =
    FF.liftF(AssociateTransitGatewayMulticastDomain(request))

  def associateTransitGatewayRouteTable(
    request: AssociateTransitGatewayRouteTableRequest
  ): Ec2IO[AssociateTransitGatewayRouteTableResponse] =
    FF.liftF(AssociateTransitGatewayRouteTable(request))

  def associateVpcCidrBlock(
    request: AssociateVpcCidrBlockRequest
  ): Ec2IO[AssociateVpcCidrBlockResponse] =
    FF.liftF(AssociateVpcCidrBlock(request))

  def attachClassicLinkVpc(
    request: AttachClassicLinkVpcRequest
  ): Ec2IO[AttachClassicLinkVpcResponse] =
    FF.liftF(AttachClassicLinkVpc(request))

  def attachInternetGateway(
    request: AttachInternetGatewayRequest
  ): Ec2IO[AttachInternetGatewayResponse] =
    FF.liftF(AttachInternetGateway(request))

  def attachNetworkInterface(
    request: AttachNetworkInterfaceRequest
  ): Ec2IO[AttachNetworkInterfaceResponse] =
    FF.liftF(AttachNetworkInterface(request))

  def attachVolume(
    request: AttachVolumeRequest
  ): Ec2IO[AttachVolumeResponse] =
    FF.liftF(AttachVolume(request))

  def attachVpnGateway(
    request: AttachVpnGatewayRequest
  ): Ec2IO[AttachVpnGatewayResponse] =
    FF.liftF(AttachVpnGateway(request))

  def authorizeClientVpnIngress(
    request: AuthorizeClientVpnIngressRequest
  ): Ec2IO[AuthorizeClientVpnIngressResponse] =
    FF.liftF(AuthorizeClientVpnIngress(request))

  def authorizeSecurityGroupEgress(
    request: AuthorizeSecurityGroupEgressRequest
  ): Ec2IO[AuthorizeSecurityGroupEgressResponse] =
    FF.liftF(AuthorizeSecurityGroupEgress(request))

  def authorizeSecurityGroupIngress(
    request: AuthorizeSecurityGroupIngressRequest
  ): Ec2IO[AuthorizeSecurityGroupIngressResponse] =
    FF.liftF(AuthorizeSecurityGroupIngress(request))

  def bundleInstance(
    request: BundleInstanceRequest
  ): Ec2IO[BundleInstanceResponse] =
    FF.liftF(BundleInstance(request))

  def cancelBundleTask(
    request: CancelBundleTaskRequest
  ): Ec2IO[CancelBundleTaskResponse] =
    FF.liftF(CancelBundleTask(request))

  def cancelCapacityReservation(
    request: CancelCapacityReservationRequest
  ): Ec2IO[CancelCapacityReservationResponse] =
    FF.liftF(CancelCapacityReservation(request))

  def cancelConversionTask(
    request: CancelConversionTaskRequest
  ): Ec2IO[CancelConversionTaskResponse] =
    FF.liftF(CancelConversionTask(request))

  def cancelExportTask(
    request: CancelExportTaskRequest
  ): Ec2IO[CancelExportTaskResponse] =
    FF.liftF(CancelExportTask(request))

  def cancelImportTask(
    request: CancelImportTaskRequest
  ): Ec2IO[CancelImportTaskResponse] =
    FF.liftF(CancelImportTask(request))

  def cancelReservedInstancesListing(
    request: CancelReservedInstancesListingRequest
  ): Ec2IO[CancelReservedInstancesListingResponse] =
    FF.liftF(CancelReservedInstancesListing(request))

  def cancelSpotFleetRequests(
    request: CancelSpotFleetRequestsRequest
  ): Ec2IO[CancelSpotFleetRequestsResponse] =
    FF.liftF(CancelSpotFleetRequests(request))

  def cancelSpotInstanceRequests(
    request: CancelSpotInstanceRequestsRequest
  ): Ec2IO[CancelSpotInstanceRequestsResponse] =
    FF.liftF(CancelSpotInstanceRequests(request))

  def confirmProductInstance(
    request: ConfirmProductInstanceRequest
  ): Ec2IO[ConfirmProductInstanceResponse] =
    FF.liftF(ConfirmProductInstance(request))

  def copyFpgaImage(
    request: CopyFpgaImageRequest
  ): Ec2IO[CopyFpgaImageResponse] =
    FF.liftF(CopyFpgaImage(request))

  def copyImage(
    request: CopyImageRequest
  ): Ec2IO[CopyImageResponse] =
    FF.liftF(CopyImage(request))

  def copySnapshot(
    request: CopySnapshotRequest
  ): Ec2IO[CopySnapshotResponse] =
    FF.liftF(CopySnapshot(request))

  def createCapacityReservation(
    request: CreateCapacityReservationRequest
  ): Ec2IO[CreateCapacityReservationResponse] =
    FF.liftF(CreateCapacityReservation(request))

  def createCarrierGateway(
    request: CreateCarrierGatewayRequest
  ): Ec2IO[CreateCarrierGatewayResponse] =
    FF.liftF(CreateCarrierGateway(request))

  def createClientVpnEndpoint(
    request: CreateClientVpnEndpointRequest
  ): Ec2IO[CreateClientVpnEndpointResponse] =
    FF.liftF(CreateClientVpnEndpoint(request))

  def createClientVpnRoute(
    request: CreateClientVpnRouteRequest
  ): Ec2IO[CreateClientVpnRouteResponse] =
    FF.liftF(CreateClientVpnRoute(request))

  def createCustomerGateway(
    request: CreateCustomerGatewayRequest
  ): Ec2IO[CreateCustomerGatewayResponse] =
    FF.liftF(CreateCustomerGateway(request))

  def createDefaultSubnet(
    request: CreateDefaultSubnetRequest
  ): Ec2IO[CreateDefaultSubnetResponse] =
    FF.liftF(CreateDefaultSubnet(request))

  def createDefaultVpc(
    request: CreateDefaultVpcRequest
  ): Ec2IO[CreateDefaultVpcResponse] =
    FF.liftF(CreateDefaultVpc(request))

  def createDhcpOptions(
    request: CreateDhcpOptionsRequest
  ): Ec2IO[CreateDhcpOptionsResponse] =
    FF.liftF(CreateDhcpOptions(request))

  def createEgressOnlyInternetGateway(
    request: CreateEgressOnlyInternetGatewayRequest
  ): Ec2IO[CreateEgressOnlyInternetGatewayResponse] =
    FF.liftF(CreateEgressOnlyInternetGateway(request))

  def createFleet(
    request: CreateFleetRequest
  ): Ec2IO[CreateFleetResponse] =
    FF.liftF(CreateFleet(request))

  def createFlowLogs(
    request: CreateFlowLogsRequest
  ): Ec2IO[CreateFlowLogsResponse] =
    FF.liftF(CreateFlowLogs(request))

  def createFpgaImage(
    request: CreateFpgaImageRequest
  ): Ec2IO[CreateFpgaImageResponse] =
    FF.liftF(CreateFpgaImage(request))

  def createImage(
    request: CreateImageRequest
  ): Ec2IO[CreateImageResponse] =
    FF.liftF(CreateImage(request))

  def createInstanceExportTask(
    request: CreateInstanceExportTaskRequest
  ): Ec2IO[CreateInstanceExportTaskResponse] =
    FF.liftF(CreateInstanceExportTask(request))

  def createInternetGateway(
    request: CreateInternetGatewayRequest
  ): Ec2IO[CreateInternetGatewayResponse] =
    FF.liftF(CreateInternetGateway(request))

  def createKeyPair(
    request: CreateKeyPairRequest
  ): Ec2IO[CreateKeyPairResponse] =
    FF.liftF(CreateKeyPair(request))

  def createLaunchTemplate(
    request: CreateLaunchTemplateRequest
  ): Ec2IO[CreateLaunchTemplateResponse] =
    FF.liftF(CreateLaunchTemplate(request))

  def createLaunchTemplateVersion(
    request: CreateLaunchTemplateVersionRequest
  ): Ec2IO[CreateLaunchTemplateVersionResponse] =
    FF.liftF(CreateLaunchTemplateVersion(request))

  def createLocalGatewayRoute(
    request: CreateLocalGatewayRouteRequest
  ): Ec2IO[CreateLocalGatewayRouteResponse] =
    FF.liftF(CreateLocalGatewayRoute(request))

  def createLocalGatewayRouteTableVpcAssociation(
    request: CreateLocalGatewayRouteTableVpcAssociationRequest
  ): Ec2IO[CreateLocalGatewayRouteTableVpcAssociationResponse] =
    FF.liftF(CreateLocalGatewayRouteTableVpcAssociation(request))

  def createManagedPrefixList(
    request: CreateManagedPrefixListRequest
  ): Ec2IO[CreateManagedPrefixListResponse] =
    FF.liftF(CreateManagedPrefixList(request))

  def createNatGateway(
    request: CreateNatGatewayRequest
  ): Ec2IO[CreateNatGatewayResponse] =
    FF.liftF(CreateNatGateway(request))

  def createNetworkAcl(
    request: CreateNetworkAclRequest
  ): Ec2IO[CreateNetworkAclResponse] =
    FF.liftF(CreateNetworkAcl(request))

  def createNetworkAclEntry(
    request: CreateNetworkAclEntryRequest
  ): Ec2IO[CreateNetworkAclEntryResponse] =
    FF.liftF(CreateNetworkAclEntry(request))

  def createNetworkInsightsPath(
    request: CreateNetworkInsightsPathRequest
  ): Ec2IO[CreateNetworkInsightsPathResponse] =
    FF.liftF(CreateNetworkInsightsPath(request))

  def createNetworkInterface(
    request: CreateNetworkInterfaceRequest
  ): Ec2IO[CreateNetworkInterfaceResponse] =
    FF.liftF(CreateNetworkInterface(request))

  def createNetworkInterfacePermission(
    request: CreateNetworkInterfacePermissionRequest
  ): Ec2IO[CreateNetworkInterfacePermissionResponse] =
    FF.liftF(CreateNetworkInterfacePermission(request))

  def createPlacementGroup(
    request: CreatePlacementGroupRequest
  ): Ec2IO[CreatePlacementGroupResponse] =
    FF.liftF(CreatePlacementGroup(request))

  def createReplaceRootVolumeTask(
    request: CreateReplaceRootVolumeTaskRequest
  ): Ec2IO[CreateReplaceRootVolumeTaskResponse] =
    FF.liftF(CreateReplaceRootVolumeTask(request))

  def createReservedInstancesListing(
    request: CreateReservedInstancesListingRequest
  ): Ec2IO[CreateReservedInstancesListingResponse] =
    FF.liftF(CreateReservedInstancesListing(request))

  def createRestoreImageTask(
    request: CreateRestoreImageTaskRequest
  ): Ec2IO[CreateRestoreImageTaskResponse] =
    FF.liftF(CreateRestoreImageTask(request))

  def createRoute(
    request: CreateRouteRequest
  ): Ec2IO[CreateRouteResponse] =
    FF.liftF(CreateRoute(request))

  def createRouteTable(
    request: CreateRouteTableRequest
  ): Ec2IO[CreateRouteTableResponse] =
    FF.liftF(CreateRouteTable(request))

  def createSecurityGroup(
    request: CreateSecurityGroupRequest
  ): Ec2IO[CreateSecurityGroupResponse] =
    FF.liftF(CreateSecurityGroup(request))

  def createSnapshot(
    request: CreateSnapshotRequest
  ): Ec2IO[CreateSnapshotResponse] =
    FF.liftF(CreateSnapshot(request))

  def createSnapshots(
    request: CreateSnapshotsRequest
  ): Ec2IO[CreateSnapshotsResponse] =
    FF.liftF(CreateSnapshots(request))

  def createSpotDatafeedSubscription(
    request: CreateSpotDatafeedSubscriptionRequest
  ): Ec2IO[CreateSpotDatafeedSubscriptionResponse] =
    FF.liftF(CreateSpotDatafeedSubscription(request))

  def createStoreImageTask(
    request: CreateStoreImageTaskRequest
  ): Ec2IO[CreateStoreImageTaskResponse] =
    FF.liftF(CreateStoreImageTask(request))

  def createSubnet(
    request: CreateSubnetRequest
  ): Ec2IO[CreateSubnetResponse] =
    FF.liftF(CreateSubnet(request))

  def createTags(
    request: CreateTagsRequest
  ): Ec2IO[CreateTagsResponse] =
    FF.liftF(CreateTags(request))

  def createTrafficMirrorFilter(
    request: CreateTrafficMirrorFilterRequest
  ): Ec2IO[CreateTrafficMirrorFilterResponse] =
    FF.liftF(CreateTrafficMirrorFilter(request))

  def createTrafficMirrorFilterRule(
    request: CreateTrafficMirrorFilterRuleRequest
  ): Ec2IO[CreateTrafficMirrorFilterRuleResponse] =
    FF.liftF(CreateTrafficMirrorFilterRule(request))

  def createTrafficMirrorSession(
    request: CreateTrafficMirrorSessionRequest
  ): Ec2IO[CreateTrafficMirrorSessionResponse] =
    FF.liftF(CreateTrafficMirrorSession(request))

  def createTrafficMirrorTarget(
    request: CreateTrafficMirrorTargetRequest
  ): Ec2IO[CreateTrafficMirrorTargetResponse] =
    FF.liftF(CreateTrafficMirrorTarget(request))

  def createTransitGateway(
    request: CreateTransitGatewayRequest
  ): Ec2IO[CreateTransitGatewayResponse] =
    FF.liftF(CreateTransitGateway(request))

  def createTransitGatewayConnect(
    request: CreateTransitGatewayConnectRequest
  ): Ec2IO[CreateTransitGatewayConnectResponse] =
    FF.liftF(CreateTransitGatewayConnect(request))

  def createTransitGatewayConnectPeer(
    request: CreateTransitGatewayConnectPeerRequest
  ): Ec2IO[CreateTransitGatewayConnectPeerResponse] =
    FF.liftF(CreateTransitGatewayConnectPeer(request))

  def createTransitGatewayMulticastDomain(
    request: CreateTransitGatewayMulticastDomainRequest
  ): Ec2IO[CreateTransitGatewayMulticastDomainResponse] =
    FF.liftF(CreateTransitGatewayMulticastDomain(request))

  def createTransitGatewayPeeringAttachment(
    request: CreateTransitGatewayPeeringAttachmentRequest
  ): Ec2IO[CreateTransitGatewayPeeringAttachmentResponse] =
    FF.liftF(CreateTransitGatewayPeeringAttachment(request))

  def createTransitGatewayPrefixListReference(
    request: CreateTransitGatewayPrefixListReferenceRequest
  ): Ec2IO[CreateTransitGatewayPrefixListReferenceResponse] =
    FF.liftF(CreateTransitGatewayPrefixListReference(request))

  def createTransitGatewayRoute(
    request: CreateTransitGatewayRouteRequest
  ): Ec2IO[CreateTransitGatewayRouteResponse] =
    FF.liftF(CreateTransitGatewayRoute(request))

  def createTransitGatewayRouteTable(
    request: CreateTransitGatewayRouteTableRequest
  ): Ec2IO[CreateTransitGatewayRouteTableResponse] =
    FF.liftF(CreateTransitGatewayRouteTable(request))

  def createTransitGatewayVpcAttachment(
    request: CreateTransitGatewayVpcAttachmentRequest
  ): Ec2IO[CreateTransitGatewayVpcAttachmentResponse] =
    FF.liftF(CreateTransitGatewayVpcAttachment(request))

  def createVolume(
    request: CreateVolumeRequest
  ): Ec2IO[CreateVolumeResponse] =
    FF.liftF(CreateVolume(request))

  def createVpc(
    request: CreateVpcRequest
  ): Ec2IO[CreateVpcResponse] =
    FF.liftF(CreateVpc(request))

  def createVpcEndpoint(
    request: CreateVpcEndpointRequest
  ): Ec2IO[CreateVpcEndpointResponse] =
    FF.liftF(CreateVpcEndpoint(request))

  def createVpcEndpointConnectionNotification(
    request: CreateVpcEndpointConnectionNotificationRequest
  ): Ec2IO[CreateVpcEndpointConnectionNotificationResponse] =
    FF.liftF(CreateVpcEndpointConnectionNotification(request))

  def createVpcEndpointServiceConfiguration(
    request: CreateVpcEndpointServiceConfigurationRequest
  ): Ec2IO[CreateVpcEndpointServiceConfigurationResponse] =
    FF.liftF(CreateVpcEndpointServiceConfiguration(request))

  def createVpcPeeringConnection(
    request: CreateVpcPeeringConnectionRequest
  ): Ec2IO[CreateVpcPeeringConnectionResponse] =
    FF.liftF(CreateVpcPeeringConnection(request))

  def createVpnConnection(
    request: CreateVpnConnectionRequest
  ): Ec2IO[CreateVpnConnectionResponse] =
    FF.liftF(CreateVpnConnection(request))

  def createVpnConnectionRoute(
    request: CreateVpnConnectionRouteRequest
  ): Ec2IO[CreateVpnConnectionRouteResponse] =
    FF.liftF(CreateVpnConnectionRoute(request))

  def createVpnGateway(
    request: CreateVpnGatewayRequest
  ): Ec2IO[CreateVpnGatewayResponse] =
    FF.liftF(CreateVpnGateway(request))

  def deleteCarrierGateway(
    request: DeleteCarrierGatewayRequest
  ): Ec2IO[DeleteCarrierGatewayResponse] =
    FF.liftF(DeleteCarrierGateway(request))

  def deleteClientVpnEndpoint(
    request: DeleteClientVpnEndpointRequest
  ): Ec2IO[DeleteClientVpnEndpointResponse] =
    FF.liftF(DeleteClientVpnEndpoint(request))

  def deleteClientVpnRoute(
    request: DeleteClientVpnRouteRequest
  ): Ec2IO[DeleteClientVpnRouteResponse] =
    FF.liftF(DeleteClientVpnRoute(request))

  def deleteCustomerGateway(
    request: DeleteCustomerGatewayRequest
  ): Ec2IO[DeleteCustomerGatewayResponse] =
    FF.liftF(DeleteCustomerGateway(request))

  def deleteDhcpOptions(
    request: DeleteDhcpOptionsRequest
  ): Ec2IO[DeleteDhcpOptionsResponse] =
    FF.liftF(DeleteDhcpOptions(request))

  def deleteEgressOnlyInternetGateway(
    request: DeleteEgressOnlyInternetGatewayRequest
  ): Ec2IO[DeleteEgressOnlyInternetGatewayResponse] =
    FF.liftF(DeleteEgressOnlyInternetGateway(request))

  def deleteFleets(
    request: DeleteFleetsRequest
  ): Ec2IO[DeleteFleetsResponse] =
    FF.liftF(DeleteFleets(request))

  def deleteFlowLogs(
    request: DeleteFlowLogsRequest
  ): Ec2IO[DeleteFlowLogsResponse] =
    FF.liftF(DeleteFlowLogs(request))

  def deleteFpgaImage(
    request: DeleteFpgaImageRequest
  ): Ec2IO[DeleteFpgaImageResponse] =
    FF.liftF(DeleteFpgaImage(request))

  def deleteInternetGateway(
    request: DeleteInternetGatewayRequest
  ): Ec2IO[DeleteInternetGatewayResponse] =
    FF.liftF(DeleteInternetGateway(request))

  def deleteKeyPair(
    request: DeleteKeyPairRequest
  ): Ec2IO[DeleteKeyPairResponse] =
    FF.liftF(DeleteKeyPair(request))

  def deleteLaunchTemplate(
    request: DeleteLaunchTemplateRequest
  ): Ec2IO[DeleteLaunchTemplateResponse] =
    FF.liftF(DeleteLaunchTemplate(request))

  def deleteLaunchTemplateVersions(
    request: DeleteLaunchTemplateVersionsRequest
  ): Ec2IO[DeleteLaunchTemplateVersionsResponse] =
    FF.liftF(DeleteLaunchTemplateVersions(request))

  def deleteLocalGatewayRoute(
    request: DeleteLocalGatewayRouteRequest
  ): Ec2IO[DeleteLocalGatewayRouteResponse] =
    FF.liftF(DeleteLocalGatewayRoute(request))

  def deleteLocalGatewayRouteTableVpcAssociation(
    request: DeleteLocalGatewayRouteTableVpcAssociationRequest
  ): Ec2IO[DeleteLocalGatewayRouteTableVpcAssociationResponse] =
    FF.liftF(DeleteLocalGatewayRouteTableVpcAssociation(request))

  def deleteManagedPrefixList(
    request: DeleteManagedPrefixListRequest
  ): Ec2IO[DeleteManagedPrefixListResponse] =
    FF.liftF(DeleteManagedPrefixList(request))

  def deleteNatGateway(
    request: DeleteNatGatewayRequest
  ): Ec2IO[DeleteNatGatewayResponse] =
    FF.liftF(DeleteNatGateway(request))

  def deleteNetworkAcl(
    request: DeleteNetworkAclRequest
  ): Ec2IO[DeleteNetworkAclResponse] =
    FF.liftF(DeleteNetworkAcl(request))

  def deleteNetworkAclEntry(
    request: DeleteNetworkAclEntryRequest
  ): Ec2IO[DeleteNetworkAclEntryResponse] =
    FF.liftF(DeleteNetworkAclEntry(request))

  def deleteNetworkInsightsAnalysis(
    request: DeleteNetworkInsightsAnalysisRequest
  ): Ec2IO[DeleteNetworkInsightsAnalysisResponse] =
    FF.liftF(DeleteNetworkInsightsAnalysis(request))

  def deleteNetworkInsightsPath(
    request: DeleteNetworkInsightsPathRequest
  ): Ec2IO[DeleteNetworkInsightsPathResponse] =
    FF.liftF(DeleteNetworkInsightsPath(request))

  def deleteNetworkInterface(
    request: DeleteNetworkInterfaceRequest
  ): Ec2IO[DeleteNetworkInterfaceResponse] =
    FF.liftF(DeleteNetworkInterface(request))

  def deleteNetworkInterfacePermission(
    request: DeleteNetworkInterfacePermissionRequest
  ): Ec2IO[DeleteNetworkInterfacePermissionResponse] =
    FF.liftF(DeleteNetworkInterfacePermission(request))

  def deletePlacementGroup(
    request: DeletePlacementGroupRequest
  ): Ec2IO[DeletePlacementGroupResponse] =
    FF.liftF(DeletePlacementGroup(request))

  def deleteQueuedReservedInstances(
    request: DeleteQueuedReservedInstancesRequest
  ): Ec2IO[DeleteQueuedReservedInstancesResponse] =
    FF.liftF(DeleteQueuedReservedInstances(request))

  def deleteRoute(
    request: DeleteRouteRequest
  ): Ec2IO[DeleteRouteResponse] =
    FF.liftF(DeleteRoute(request))

  def deleteRouteTable(
    request: DeleteRouteTableRequest
  ): Ec2IO[DeleteRouteTableResponse] =
    FF.liftF(DeleteRouteTable(request))

  def deleteSecurityGroup(
    request: DeleteSecurityGroupRequest
  ): Ec2IO[DeleteSecurityGroupResponse] =
    FF.liftF(DeleteSecurityGroup(request))

  def deleteSnapshot(
    request: DeleteSnapshotRequest
  ): Ec2IO[DeleteSnapshotResponse] =
    FF.liftF(DeleteSnapshot(request))

  def deleteSpotDatafeedSubscription(
    request: DeleteSpotDatafeedSubscriptionRequest
  ): Ec2IO[DeleteSpotDatafeedSubscriptionResponse] =
    FF.liftF(DeleteSpotDatafeedSubscription(request))

  def deleteSubnet(
    request: DeleteSubnetRequest
  ): Ec2IO[DeleteSubnetResponse] =
    FF.liftF(DeleteSubnet(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): Ec2IO[DeleteTagsResponse] =
    FF.liftF(DeleteTags(request))

  def deleteTrafficMirrorFilter(
    request: DeleteTrafficMirrorFilterRequest
  ): Ec2IO[DeleteTrafficMirrorFilterResponse] =
    FF.liftF(DeleteTrafficMirrorFilter(request))

  def deleteTrafficMirrorFilterRule(
    request: DeleteTrafficMirrorFilterRuleRequest
  ): Ec2IO[DeleteTrafficMirrorFilterRuleResponse] =
    FF.liftF(DeleteTrafficMirrorFilterRule(request))

  def deleteTrafficMirrorSession(
    request: DeleteTrafficMirrorSessionRequest
  ): Ec2IO[DeleteTrafficMirrorSessionResponse] =
    FF.liftF(DeleteTrafficMirrorSession(request))

  def deleteTrafficMirrorTarget(
    request: DeleteTrafficMirrorTargetRequest
  ): Ec2IO[DeleteTrafficMirrorTargetResponse] =
    FF.liftF(DeleteTrafficMirrorTarget(request))

  def deleteTransitGateway(
    request: DeleteTransitGatewayRequest
  ): Ec2IO[DeleteTransitGatewayResponse] =
    FF.liftF(DeleteTransitGateway(request))

  def deleteTransitGatewayConnect(
    request: DeleteTransitGatewayConnectRequest
  ): Ec2IO[DeleteTransitGatewayConnectResponse] =
    FF.liftF(DeleteTransitGatewayConnect(request))

  def deleteTransitGatewayConnectPeer(
    request: DeleteTransitGatewayConnectPeerRequest
  ): Ec2IO[DeleteTransitGatewayConnectPeerResponse] =
    FF.liftF(DeleteTransitGatewayConnectPeer(request))

  def deleteTransitGatewayMulticastDomain(
    request: DeleteTransitGatewayMulticastDomainRequest
  ): Ec2IO[DeleteTransitGatewayMulticastDomainResponse] =
    FF.liftF(DeleteTransitGatewayMulticastDomain(request))

  def deleteTransitGatewayPeeringAttachment(
    request: DeleteTransitGatewayPeeringAttachmentRequest
  ): Ec2IO[DeleteTransitGatewayPeeringAttachmentResponse] =
    FF.liftF(DeleteTransitGatewayPeeringAttachment(request))

  def deleteTransitGatewayPrefixListReference(
    request: DeleteTransitGatewayPrefixListReferenceRequest
  ): Ec2IO[DeleteTransitGatewayPrefixListReferenceResponse] =
    FF.liftF(DeleteTransitGatewayPrefixListReference(request))

  def deleteTransitGatewayRoute(
    request: DeleteTransitGatewayRouteRequest
  ): Ec2IO[DeleteTransitGatewayRouteResponse] =
    FF.liftF(DeleteTransitGatewayRoute(request))

  def deleteTransitGatewayRouteTable(
    request: DeleteTransitGatewayRouteTableRequest
  ): Ec2IO[DeleteTransitGatewayRouteTableResponse] =
    FF.liftF(DeleteTransitGatewayRouteTable(request))

  def deleteTransitGatewayVpcAttachment(
    request: DeleteTransitGatewayVpcAttachmentRequest
  ): Ec2IO[DeleteTransitGatewayVpcAttachmentResponse] =
    FF.liftF(DeleteTransitGatewayVpcAttachment(request))

  def deleteVolume(
    request: DeleteVolumeRequest
  ): Ec2IO[DeleteVolumeResponse] =
    FF.liftF(DeleteVolume(request))

  def deleteVpc(
    request: DeleteVpcRequest
  ): Ec2IO[DeleteVpcResponse] =
    FF.liftF(DeleteVpc(request))

  def deleteVpcEndpointConnectionNotifications(
    request: DeleteVpcEndpointConnectionNotificationsRequest
  ): Ec2IO[DeleteVpcEndpointConnectionNotificationsResponse] =
    FF.liftF(DeleteVpcEndpointConnectionNotifications(request))

  def deleteVpcEndpointServiceConfigurations(
    request: DeleteVpcEndpointServiceConfigurationsRequest
  ): Ec2IO[DeleteVpcEndpointServiceConfigurationsResponse] =
    FF.liftF(DeleteVpcEndpointServiceConfigurations(request))

  def deleteVpcEndpoints(
    request: DeleteVpcEndpointsRequest
  ): Ec2IO[DeleteVpcEndpointsResponse] =
    FF.liftF(DeleteVpcEndpoints(request))

  def deleteVpcPeeringConnection(
    request: DeleteVpcPeeringConnectionRequest
  ): Ec2IO[DeleteVpcPeeringConnectionResponse] =
    FF.liftF(DeleteVpcPeeringConnection(request))

  def deleteVpnConnection(
    request: DeleteVpnConnectionRequest
  ): Ec2IO[DeleteVpnConnectionResponse] =
    FF.liftF(DeleteVpnConnection(request))

  def deleteVpnConnectionRoute(
    request: DeleteVpnConnectionRouteRequest
  ): Ec2IO[DeleteVpnConnectionRouteResponse] =
    FF.liftF(DeleteVpnConnectionRoute(request))

  def deleteVpnGateway(
    request: DeleteVpnGatewayRequest
  ): Ec2IO[DeleteVpnGatewayResponse] =
    FF.liftF(DeleteVpnGateway(request))

  def deprovisionByoipCidr(
    request: DeprovisionByoipCidrRequest
  ): Ec2IO[DeprovisionByoipCidrResponse] =
    FF.liftF(DeprovisionByoipCidr(request))

  def deregisterImage(
    request: DeregisterImageRequest
  ): Ec2IO[DeregisterImageResponse] =
    FF.liftF(DeregisterImage(request))

  def deregisterInstanceEventNotificationAttributes(
    request: DeregisterInstanceEventNotificationAttributesRequest
  ): Ec2IO[DeregisterInstanceEventNotificationAttributesResponse] =
    FF.liftF(DeregisterInstanceEventNotificationAttributes(request))

  def deregisterTransitGatewayMulticastGroupMembers(
    request: DeregisterTransitGatewayMulticastGroupMembersRequest
  ): Ec2IO[DeregisterTransitGatewayMulticastGroupMembersResponse] =
    FF.liftF(DeregisterTransitGatewayMulticastGroupMembers(request))

  def deregisterTransitGatewayMulticastGroupSources(
    request: DeregisterTransitGatewayMulticastGroupSourcesRequest
  ): Ec2IO[DeregisterTransitGatewayMulticastGroupSourcesResponse] =
    FF.liftF(DeregisterTransitGatewayMulticastGroupSources(request))

  def describeAccountAttributes(
    request: DescribeAccountAttributesRequest
  ): Ec2IO[DescribeAccountAttributesResponse] =
    FF.liftF(DescribeAccountAttributes(request))

  def describeAddresses(
    request: DescribeAddressesRequest
  ): Ec2IO[DescribeAddressesResponse] =
    FF.liftF(DescribeAddresses(request))

  def describeAddressesAttribute(
    request: DescribeAddressesAttributeRequest
  ): Ec2IO[DescribeAddressesAttributeResponse] =
    FF.liftF(DescribeAddressesAttribute(request))

  def describeAggregateIdFormat(
    request: DescribeAggregateIdFormatRequest
  ): Ec2IO[DescribeAggregateIdFormatResponse] =
    FF.liftF(DescribeAggregateIdFormat(request))

  def describeAvailabilityZones(
    request: DescribeAvailabilityZonesRequest
  ): Ec2IO[DescribeAvailabilityZonesResponse] =
    FF.liftF(DescribeAvailabilityZones(request))

  def describeBundleTasks(
    request: DescribeBundleTasksRequest
  ): Ec2IO[DescribeBundleTasksResponse] =
    FF.liftF(DescribeBundleTasks(request))

  def describeByoipCidrs(
    request: DescribeByoipCidrsRequest
  ): Ec2IO[DescribeByoipCidrsResponse] =
    FF.liftF(DescribeByoipCidrs(request))

  def describeCapacityReservations(
    request: DescribeCapacityReservationsRequest
  ): Ec2IO[DescribeCapacityReservationsResponse] =
    FF.liftF(DescribeCapacityReservations(request))

  def describeCarrierGateways(
    request: DescribeCarrierGatewaysRequest
  ): Ec2IO[DescribeCarrierGatewaysResponse] =
    FF.liftF(DescribeCarrierGateways(request))

  def describeClassicLinkInstances(
    request: DescribeClassicLinkInstancesRequest
  ): Ec2IO[DescribeClassicLinkInstancesResponse] =
    FF.liftF(DescribeClassicLinkInstances(request))

  def describeClientVpnAuthorizationRules(
    request: DescribeClientVpnAuthorizationRulesRequest
  ): Ec2IO[DescribeClientVpnAuthorizationRulesResponse] =
    FF.liftF(DescribeClientVpnAuthorizationRules(request))

  def describeClientVpnConnections(
    request: DescribeClientVpnConnectionsRequest
  ): Ec2IO[DescribeClientVpnConnectionsResponse] =
    FF.liftF(DescribeClientVpnConnections(request))

  def describeClientVpnEndpoints(
    request: DescribeClientVpnEndpointsRequest
  ): Ec2IO[DescribeClientVpnEndpointsResponse] =
    FF.liftF(DescribeClientVpnEndpoints(request))

  def describeClientVpnRoutes(
    request: DescribeClientVpnRoutesRequest
  ): Ec2IO[DescribeClientVpnRoutesResponse] =
    FF.liftF(DescribeClientVpnRoutes(request))

  def describeClientVpnTargetNetworks(
    request: DescribeClientVpnTargetNetworksRequest
  ): Ec2IO[DescribeClientVpnTargetNetworksResponse] =
    FF.liftF(DescribeClientVpnTargetNetworks(request))

  def describeCoipPools(
    request: DescribeCoipPoolsRequest
  ): Ec2IO[DescribeCoipPoolsResponse] =
    FF.liftF(DescribeCoipPools(request))

  def describeConversionTasks(
    request: DescribeConversionTasksRequest
  ): Ec2IO[DescribeConversionTasksResponse] =
    FF.liftF(DescribeConversionTasks(request))

  def describeCustomerGateways(
    request: DescribeCustomerGatewaysRequest
  ): Ec2IO[DescribeCustomerGatewaysResponse] =
    FF.liftF(DescribeCustomerGateways(request))

  def describeDhcpOptions(
    request: DescribeDhcpOptionsRequest
  ): Ec2IO[DescribeDhcpOptionsResponse] =
    FF.liftF(DescribeDhcpOptions(request))

  def describeEgressOnlyInternetGateways(
    request: DescribeEgressOnlyInternetGatewaysRequest
  ): Ec2IO[DescribeEgressOnlyInternetGatewaysResponse] =
    FF.liftF(DescribeEgressOnlyInternetGateways(request))

  def describeElasticGpus(
    request: DescribeElasticGpusRequest
  ): Ec2IO[DescribeElasticGpusResponse] =
    FF.liftF(DescribeElasticGpus(request))

  def describeExportImageTasks(
    request: DescribeExportImageTasksRequest
  ): Ec2IO[DescribeExportImageTasksResponse] =
    FF.liftF(DescribeExportImageTasks(request))

  def describeExportTasks(
    request: DescribeExportTasksRequest
  ): Ec2IO[DescribeExportTasksResponse] =
    FF.liftF(DescribeExportTasks(request))

  def describeFastSnapshotRestores(
    request: DescribeFastSnapshotRestoresRequest
  ): Ec2IO[DescribeFastSnapshotRestoresResponse] =
    FF.liftF(DescribeFastSnapshotRestores(request))

  def describeFleetHistory(
    request: DescribeFleetHistoryRequest
  ): Ec2IO[DescribeFleetHistoryResponse] =
    FF.liftF(DescribeFleetHistory(request))

  def describeFleetInstances(
    request: DescribeFleetInstancesRequest
  ): Ec2IO[DescribeFleetInstancesResponse] =
    FF.liftF(DescribeFleetInstances(request))

  def describeFleets(
    request: DescribeFleetsRequest
  ): Ec2IO[DescribeFleetsResponse] =
    FF.liftF(DescribeFleets(request))

  def describeFlowLogs(
    request: DescribeFlowLogsRequest
  ): Ec2IO[DescribeFlowLogsResponse] =
    FF.liftF(DescribeFlowLogs(request))

  def describeFpgaImageAttribute(
    request: DescribeFpgaImageAttributeRequest
  ): Ec2IO[DescribeFpgaImageAttributeResponse] =
    FF.liftF(DescribeFpgaImageAttribute(request))

  def describeFpgaImages(
    request: DescribeFpgaImagesRequest
  ): Ec2IO[DescribeFpgaImagesResponse] =
    FF.liftF(DescribeFpgaImages(request))

  def describeHostReservationOfferings(
    request: DescribeHostReservationOfferingsRequest
  ): Ec2IO[DescribeHostReservationOfferingsResponse] =
    FF.liftF(DescribeHostReservationOfferings(request))

  def describeHostReservations(
    request: DescribeHostReservationsRequest
  ): Ec2IO[DescribeHostReservationsResponse] =
    FF.liftF(DescribeHostReservations(request))

  def describeHosts(
    request: DescribeHostsRequest
  ): Ec2IO[DescribeHostsResponse] =
    FF.liftF(DescribeHosts(request))

  def describeIamInstanceProfileAssociations(
    request: DescribeIamInstanceProfileAssociationsRequest
  ): Ec2IO[DescribeIamInstanceProfileAssociationsResponse] =
    FF.liftF(DescribeIamInstanceProfileAssociations(request))

  def describeIdFormat(
    request: DescribeIdFormatRequest
  ): Ec2IO[DescribeIdFormatResponse] =
    FF.liftF(DescribeIdFormat(request))

  def describeIdentityIdFormat(
    request: DescribeIdentityIdFormatRequest
  ): Ec2IO[DescribeIdentityIdFormatResponse] =
    FF.liftF(DescribeIdentityIdFormat(request))

  def describeImageAttribute(
    request: DescribeImageAttributeRequest
  ): Ec2IO[DescribeImageAttributeResponse] =
    FF.liftF(DescribeImageAttribute(request))

  def describeImages(
    request: DescribeImagesRequest
  ): Ec2IO[DescribeImagesResponse] =
    FF.liftF(DescribeImages(request))

  def describeImportImageTasks(
    request: DescribeImportImageTasksRequest
  ): Ec2IO[DescribeImportImageTasksResponse] =
    FF.liftF(DescribeImportImageTasks(request))

  def describeImportSnapshotTasks(
    request: DescribeImportSnapshotTasksRequest
  ): Ec2IO[DescribeImportSnapshotTasksResponse] =
    FF.liftF(DescribeImportSnapshotTasks(request))

  def describeInstanceAttribute(
    request: DescribeInstanceAttributeRequest
  ): Ec2IO[DescribeInstanceAttributeResponse] =
    FF.liftF(DescribeInstanceAttribute(request))

  def describeInstanceCreditSpecifications(
    request: DescribeInstanceCreditSpecificationsRequest
  ): Ec2IO[DescribeInstanceCreditSpecificationsResponse] =
    FF.liftF(DescribeInstanceCreditSpecifications(request))

  def describeInstanceEventNotificationAttributes(
    request: DescribeInstanceEventNotificationAttributesRequest
  ): Ec2IO[DescribeInstanceEventNotificationAttributesResponse] =
    FF.liftF(DescribeInstanceEventNotificationAttributes(request))

  def describeInstanceStatus(
    request: DescribeInstanceStatusRequest
  ): Ec2IO[DescribeInstanceStatusResponse] =
    FF.liftF(DescribeInstanceStatus(request))

  def describeInstanceTypeOfferings(
    request: DescribeInstanceTypeOfferingsRequest
  ): Ec2IO[DescribeInstanceTypeOfferingsResponse] =
    FF.liftF(DescribeInstanceTypeOfferings(request))

  def describeInstanceTypes(
    request: DescribeInstanceTypesRequest
  ): Ec2IO[DescribeInstanceTypesResponse] =
    FF.liftF(DescribeInstanceTypes(request))

  def describeInstances(
    request: DescribeInstancesRequest
  ): Ec2IO[DescribeInstancesResponse] =
    FF.liftF(DescribeInstances(request))

  def describeInternetGateways(
    request: DescribeInternetGatewaysRequest
  ): Ec2IO[DescribeInternetGatewaysResponse] =
    FF.liftF(DescribeInternetGateways(request))

  def describeIpv6Pools(
    request: DescribeIpv6PoolsRequest
  ): Ec2IO[DescribeIpv6PoolsResponse] =
    FF.liftF(DescribeIpv6Pools(request))

  def describeKeyPairs(
    request: DescribeKeyPairsRequest
  ): Ec2IO[DescribeKeyPairsResponse] =
    FF.liftF(DescribeKeyPairs(request))

  def describeLaunchTemplateVersions(
    request: DescribeLaunchTemplateVersionsRequest
  ): Ec2IO[DescribeLaunchTemplateVersionsResponse] =
    FF.liftF(DescribeLaunchTemplateVersions(request))

  def describeLaunchTemplates(
    request: DescribeLaunchTemplatesRequest
  ): Ec2IO[DescribeLaunchTemplatesResponse] =
    FF.liftF(DescribeLaunchTemplates(request))

  def describeLocalGatewayRouteTableVirtualInterfaceGroupAssociations(
    request: DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsRequest
  ): Ec2IO[DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsResponse] =
    FF.liftF(DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociations(request))

  def describeLocalGatewayRouteTableVpcAssociations(
    request: DescribeLocalGatewayRouteTableVpcAssociationsRequest
  ): Ec2IO[DescribeLocalGatewayRouteTableVpcAssociationsResponse] =
    FF.liftF(DescribeLocalGatewayRouteTableVpcAssociations(request))

  def describeLocalGatewayRouteTables(
    request: DescribeLocalGatewayRouteTablesRequest
  ): Ec2IO[DescribeLocalGatewayRouteTablesResponse] =
    FF.liftF(DescribeLocalGatewayRouteTables(request))

  def describeLocalGatewayVirtualInterfaceGroups(
    request: DescribeLocalGatewayVirtualInterfaceGroupsRequest
  ): Ec2IO[DescribeLocalGatewayVirtualInterfaceGroupsResponse] =
    FF.liftF(DescribeLocalGatewayVirtualInterfaceGroups(request))

  def describeLocalGatewayVirtualInterfaces(
    request: DescribeLocalGatewayVirtualInterfacesRequest
  ): Ec2IO[DescribeLocalGatewayVirtualInterfacesResponse] =
    FF.liftF(DescribeLocalGatewayVirtualInterfaces(request))

  def describeLocalGateways(
    request: DescribeLocalGatewaysRequest
  ): Ec2IO[DescribeLocalGatewaysResponse] =
    FF.liftF(DescribeLocalGateways(request))

  def describeManagedPrefixLists(
    request: DescribeManagedPrefixListsRequest
  ): Ec2IO[DescribeManagedPrefixListsResponse] =
    FF.liftF(DescribeManagedPrefixLists(request))

  def describeMovingAddresses(
    request: DescribeMovingAddressesRequest
  ): Ec2IO[DescribeMovingAddressesResponse] =
    FF.liftF(DescribeMovingAddresses(request))

  def describeNatGateways(
    request: DescribeNatGatewaysRequest
  ): Ec2IO[DescribeNatGatewaysResponse] =
    FF.liftF(DescribeNatGateways(request))

  def describeNetworkAcls(
    request: DescribeNetworkAclsRequest
  ): Ec2IO[DescribeNetworkAclsResponse] =
    FF.liftF(DescribeNetworkAcls(request))

  def describeNetworkInsightsAnalyses(
    request: DescribeNetworkInsightsAnalysesRequest
  ): Ec2IO[DescribeNetworkInsightsAnalysesResponse] =
    FF.liftF(DescribeNetworkInsightsAnalyses(request))

  def describeNetworkInsightsPaths(
    request: DescribeNetworkInsightsPathsRequest
  ): Ec2IO[DescribeNetworkInsightsPathsResponse] =
    FF.liftF(DescribeNetworkInsightsPaths(request))

  def describeNetworkInterfaceAttribute(
    request: DescribeNetworkInterfaceAttributeRequest
  ): Ec2IO[DescribeNetworkInterfaceAttributeResponse] =
    FF.liftF(DescribeNetworkInterfaceAttribute(request))

  def describeNetworkInterfacePermissions(
    request: DescribeNetworkInterfacePermissionsRequest
  ): Ec2IO[DescribeNetworkInterfacePermissionsResponse] =
    FF.liftF(DescribeNetworkInterfacePermissions(request))

  def describeNetworkInterfaces(
    request: DescribeNetworkInterfacesRequest
  ): Ec2IO[DescribeNetworkInterfacesResponse] =
    FF.liftF(DescribeNetworkInterfaces(request))

  def describePlacementGroups(
    request: DescribePlacementGroupsRequest
  ): Ec2IO[DescribePlacementGroupsResponse] =
    FF.liftF(DescribePlacementGroups(request))

  def describePrefixLists(
    request: DescribePrefixListsRequest
  ): Ec2IO[DescribePrefixListsResponse] =
    FF.liftF(DescribePrefixLists(request))

  def describePrincipalIdFormat(
    request: DescribePrincipalIdFormatRequest
  ): Ec2IO[DescribePrincipalIdFormatResponse] =
    FF.liftF(DescribePrincipalIdFormat(request))

  def describePublicIpv4Pools(
    request: DescribePublicIpv4PoolsRequest
  ): Ec2IO[DescribePublicIpv4PoolsResponse] =
    FF.liftF(DescribePublicIpv4Pools(request))

  def describeRegions(
    request: DescribeRegionsRequest
  ): Ec2IO[DescribeRegionsResponse] =
    FF.liftF(DescribeRegions(request))

  def describeReplaceRootVolumeTasks(
    request: DescribeReplaceRootVolumeTasksRequest
  ): Ec2IO[DescribeReplaceRootVolumeTasksResponse] =
    FF.liftF(DescribeReplaceRootVolumeTasks(request))

  def describeReservedInstances(
    request: DescribeReservedInstancesRequest
  ): Ec2IO[DescribeReservedInstancesResponse] =
    FF.liftF(DescribeReservedInstances(request))

  def describeReservedInstancesListings(
    request: DescribeReservedInstancesListingsRequest
  ): Ec2IO[DescribeReservedInstancesListingsResponse] =
    FF.liftF(DescribeReservedInstancesListings(request))

  def describeReservedInstancesModifications(
    request: DescribeReservedInstancesModificationsRequest
  ): Ec2IO[DescribeReservedInstancesModificationsResponse] =
    FF.liftF(DescribeReservedInstancesModifications(request))

  def describeReservedInstancesOfferings(
    request: DescribeReservedInstancesOfferingsRequest
  ): Ec2IO[DescribeReservedInstancesOfferingsResponse] =
    FF.liftF(DescribeReservedInstancesOfferings(request))

  def describeRouteTables(
    request: DescribeRouteTablesRequest
  ): Ec2IO[DescribeRouteTablesResponse] =
    FF.liftF(DescribeRouteTables(request))

  def describeScheduledInstanceAvailability(
    request: DescribeScheduledInstanceAvailabilityRequest
  ): Ec2IO[DescribeScheduledInstanceAvailabilityResponse] =
    FF.liftF(DescribeScheduledInstanceAvailability(request))

  def describeScheduledInstances(
    request: DescribeScheduledInstancesRequest
  ): Ec2IO[DescribeScheduledInstancesResponse] =
    FF.liftF(DescribeScheduledInstances(request))

  def describeSecurityGroupReferences(
    request: DescribeSecurityGroupReferencesRequest
  ): Ec2IO[DescribeSecurityGroupReferencesResponse] =
    FF.liftF(DescribeSecurityGroupReferences(request))

  def describeSecurityGroups(
    request: DescribeSecurityGroupsRequest
  ): Ec2IO[DescribeSecurityGroupsResponse] =
    FF.liftF(DescribeSecurityGroups(request))

  def describeSnapshotAttribute(
    request: DescribeSnapshotAttributeRequest
  ): Ec2IO[DescribeSnapshotAttributeResponse] =
    FF.liftF(DescribeSnapshotAttribute(request))

  def describeSnapshots(
    request: DescribeSnapshotsRequest
  ): Ec2IO[DescribeSnapshotsResponse] =
    FF.liftF(DescribeSnapshots(request))

  def describeSpotDatafeedSubscription(
    request: DescribeSpotDatafeedSubscriptionRequest
  ): Ec2IO[DescribeSpotDatafeedSubscriptionResponse] =
    FF.liftF(DescribeSpotDatafeedSubscription(request))

  def describeSpotFleetInstances(
    request: DescribeSpotFleetInstancesRequest
  ): Ec2IO[DescribeSpotFleetInstancesResponse] =
    FF.liftF(DescribeSpotFleetInstances(request))

  def describeSpotFleetRequestHistory(
    request: DescribeSpotFleetRequestHistoryRequest
  ): Ec2IO[DescribeSpotFleetRequestHistoryResponse] =
    FF.liftF(DescribeSpotFleetRequestHistory(request))

  def describeSpotFleetRequests(
    request: DescribeSpotFleetRequestsRequest
  ): Ec2IO[DescribeSpotFleetRequestsResponse] =
    FF.liftF(DescribeSpotFleetRequests(request))

  def describeSpotInstanceRequests(
    request: DescribeSpotInstanceRequestsRequest
  ): Ec2IO[DescribeSpotInstanceRequestsResponse] =
    FF.liftF(DescribeSpotInstanceRequests(request))

  def describeSpotPriceHistory(
    request: DescribeSpotPriceHistoryRequest
  ): Ec2IO[DescribeSpotPriceHistoryResponse] =
    FF.liftF(DescribeSpotPriceHistory(request))

  def describeStaleSecurityGroups(
    request: DescribeStaleSecurityGroupsRequest
  ): Ec2IO[DescribeStaleSecurityGroupsResponse] =
    FF.liftF(DescribeStaleSecurityGroups(request))

  def describeStoreImageTasks(
    request: DescribeStoreImageTasksRequest
  ): Ec2IO[DescribeStoreImageTasksResponse] =
    FF.liftF(DescribeStoreImageTasks(request))

  def describeSubnets(
    request: DescribeSubnetsRequest
  ): Ec2IO[DescribeSubnetsResponse] =
    FF.liftF(DescribeSubnets(request))

  def describeTags(
    request: DescribeTagsRequest
  ): Ec2IO[DescribeTagsResponse] =
    FF.liftF(DescribeTags(request))

  def describeTrafficMirrorFilters(
    request: DescribeTrafficMirrorFiltersRequest
  ): Ec2IO[DescribeTrafficMirrorFiltersResponse] =
    FF.liftF(DescribeTrafficMirrorFilters(request))

  def describeTrafficMirrorSessions(
    request: DescribeTrafficMirrorSessionsRequest
  ): Ec2IO[DescribeTrafficMirrorSessionsResponse] =
    FF.liftF(DescribeTrafficMirrorSessions(request))

  def describeTrafficMirrorTargets(
    request: DescribeTrafficMirrorTargetsRequest
  ): Ec2IO[DescribeTrafficMirrorTargetsResponse] =
    FF.liftF(DescribeTrafficMirrorTargets(request))

  def describeTransitGatewayAttachments(
    request: DescribeTransitGatewayAttachmentsRequest
  ): Ec2IO[DescribeTransitGatewayAttachmentsResponse] =
    FF.liftF(DescribeTransitGatewayAttachments(request))

  def describeTransitGatewayConnectPeers(
    request: DescribeTransitGatewayConnectPeersRequest
  ): Ec2IO[DescribeTransitGatewayConnectPeersResponse] =
    FF.liftF(DescribeTransitGatewayConnectPeers(request))

  def describeTransitGatewayConnects(
    request: DescribeTransitGatewayConnectsRequest
  ): Ec2IO[DescribeTransitGatewayConnectsResponse] =
    FF.liftF(DescribeTransitGatewayConnects(request))

  def describeTransitGatewayMulticastDomains(
    request: DescribeTransitGatewayMulticastDomainsRequest
  ): Ec2IO[DescribeTransitGatewayMulticastDomainsResponse] =
    FF.liftF(DescribeTransitGatewayMulticastDomains(request))

  def describeTransitGatewayPeeringAttachments(
    request: DescribeTransitGatewayPeeringAttachmentsRequest
  ): Ec2IO[DescribeTransitGatewayPeeringAttachmentsResponse] =
    FF.liftF(DescribeTransitGatewayPeeringAttachments(request))

  def describeTransitGatewayRouteTables(
    request: DescribeTransitGatewayRouteTablesRequest
  ): Ec2IO[DescribeTransitGatewayRouteTablesResponse] =
    FF.liftF(DescribeTransitGatewayRouteTables(request))

  def describeTransitGatewayVpcAttachments(
    request: DescribeTransitGatewayVpcAttachmentsRequest
  ): Ec2IO[DescribeTransitGatewayVpcAttachmentsResponse] =
    FF.liftF(DescribeTransitGatewayVpcAttachments(request))

  def describeTransitGateways(
    request: DescribeTransitGatewaysRequest
  ): Ec2IO[DescribeTransitGatewaysResponse] =
    FF.liftF(DescribeTransitGateways(request))

  def describeVolumeAttribute(
    request: DescribeVolumeAttributeRequest
  ): Ec2IO[DescribeVolumeAttributeResponse] =
    FF.liftF(DescribeVolumeAttribute(request))

  def describeVolumeStatus(
    request: DescribeVolumeStatusRequest
  ): Ec2IO[DescribeVolumeStatusResponse] =
    FF.liftF(DescribeVolumeStatus(request))

  def describeVolumes(
    request: DescribeVolumesRequest
  ): Ec2IO[DescribeVolumesResponse] =
    FF.liftF(DescribeVolumes(request))

  def describeVolumesModifications(
    request: DescribeVolumesModificationsRequest
  ): Ec2IO[DescribeVolumesModificationsResponse] =
    FF.liftF(DescribeVolumesModifications(request))

  def describeVpcAttribute(
    request: DescribeVpcAttributeRequest
  ): Ec2IO[DescribeVpcAttributeResponse] =
    FF.liftF(DescribeVpcAttribute(request))

  def describeVpcClassicLink(
    request: DescribeVpcClassicLinkRequest
  ): Ec2IO[DescribeVpcClassicLinkResponse] =
    FF.liftF(DescribeVpcClassicLink(request))

  def describeVpcClassicLinkDnsSupport(
    request: DescribeVpcClassicLinkDnsSupportRequest
  ): Ec2IO[DescribeVpcClassicLinkDnsSupportResponse] =
    FF.liftF(DescribeVpcClassicLinkDnsSupport(request))

  def describeVpcEndpointConnectionNotifications(
    request: DescribeVpcEndpointConnectionNotificationsRequest
  ): Ec2IO[DescribeVpcEndpointConnectionNotificationsResponse] =
    FF.liftF(DescribeVpcEndpointConnectionNotifications(request))

  def describeVpcEndpointConnections(
    request: DescribeVpcEndpointConnectionsRequest
  ): Ec2IO[DescribeVpcEndpointConnectionsResponse] =
    FF.liftF(DescribeVpcEndpointConnections(request))

  def describeVpcEndpointServiceConfigurations(
    request: DescribeVpcEndpointServiceConfigurationsRequest
  ): Ec2IO[DescribeVpcEndpointServiceConfigurationsResponse] =
    FF.liftF(DescribeVpcEndpointServiceConfigurations(request))

  def describeVpcEndpointServicePermissions(
    request: DescribeVpcEndpointServicePermissionsRequest
  ): Ec2IO[DescribeVpcEndpointServicePermissionsResponse] =
    FF.liftF(DescribeVpcEndpointServicePermissions(request))

  def describeVpcEndpointServices(
    request: DescribeVpcEndpointServicesRequest
  ): Ec2IO[DescribeVpcEndpointServicesResponse] =
    FF.liftF(DescribeVpcEndpointServices(request))

  def describeVpcEndpoints(
    request: DescribeVpcEndpointsRequest
  ): Ec2IO[DescribeVpcEndpointsResponse] =
    FF.liftF(DescribeVpcEndpoints(request))

  def describeVpcPeeringConnections(
    request: DescribeVpcPeeringConnectionsRequest
  ): Ec2IO[DescribeVpcPeeringConnectionsResponse] =
    FF.liftF(DescribeVpcPeeringConnections(request))

  def describeVpcs(
    request: DescribeVpcsRequest
  ): Ec2IO[DescribeVpcsResponse] =
    FF.liftF(DescribeVpcs(request))

  def describeVpnConnections(
    request: DescribeVpnConnectionsRequest
  ): Ec2IO[DescribeVpnConnectionsResponse] =
    FF.liftF(DescribeVpnConnections(request))

  def describeVpnGateways(
    request: DescribeVpnGatewaysRequest
  ): Ec2IO[DescribeVpnGatewaysResponse] =
    FF.liftF(DescribeVpnGateways(request))

  def detachClassicLinkVpc(
    request: DetachClassicLinkVpcRequest
  ): Ec2IO[DetachClassicLinkVpcResponse] =
    FF.liftF(DetachClassicLinkVpc(request))

  def detachInternetGateway(
    request: DetachInternetGatewayRequest
  ): Ec2IO[DetachInternetGatewayResponse] =
    FF.liftF(DetachInternetGateway(request))

  def detachNetworkInterface(
    request: DetachNetworkInterfaceRequest
  ): Ec2IO[DetachNetworkInterfaceResponse] =
    FF.liftF(DetachNetworkInterface(request))

  def detachVolume(
    request: DetachVolumeRequest
  ): Ec2IO[DetachVolumeResponse] =
    FF.liftF(DetachVolume(request))

  def detachVpnGateway(
    request: DetachVpnGatewayRequest
  ): Ec2IO[DetachVpnGatewayResponse] =
    FF.liftF(DetachVpnGateway(request))

  def disableEbsEncryptionByDefault(
    request: DisableEbsEncryptionByDefaultRequest
  ): Ec2IO[DisableEbsEncryptionByDefaultResponse] =
    FF.liftF(DisableEbsEncryptionByDefault(request))

  def disableFastSnapshotRestores(
    request: DisableFastSnapshotRestoresRequest
  ): Ec2IO[DisableFastSnapshotRestoresResponse] =
    FF.liftF(DisableFastSnapshotRestores(request))

  def disableImageDeprecation(
    request: DisableImageDeprecationRequest
  ): Ec2IO[DisableImageDeprecationResponse] =
    FF.liftF(DisableImageDeprecation(request))

  def disableSerialConsoleAccess(
    request: DisableSerialConsoleAccessRequest
  ): Ec2IO[DisableSerialConsoleAccessResponse] =
    FF.liftF(DisableSerialConsoleAccess(request))

  def disableTransitGatewayRouteTablePropagation(
    request: DisableTransitGatewayRouteTablePropagationRequest
  ): Ec2IO[DisableTransitGatewayRouteTablePropagationResponse] =
    FF.liftF(DisableTransitGatewayRouteTablePropagation(request))

  def disableVgwRoutePropagation(
    request: DisableVgwRoutePropagationRequest
  ): Ec2IO[DisableVgwRoutePropagationResponse] =
    FF.liftF(DisableVgwRoutePropagation(request))

  def disableVpcClassicLink(
    request: DisableVpcClassicLinkRequest
  ): Ec2IO[DisableVpcClassicLinkResponse] =
    FF.liftF(DisableVpcClassicLink(request))

  def disableVpcClassicLinkDnsSupport(
    request: DisableVpcClassicLinkDnsSupportRequest
  ): Ec2IO[DisableVpcClassicLinkDnsSupportResponse] =
    FF.liftF(DisableVpcClassicLinkDnsSupport(request))

  def disassociateAddress(
    request: DisassociateAddressRequest
  ): Ec2IO[DisassociateAddressResponse] =
    FF.liftF(DisassociateAddress(request))

  def disassociateClientVpnTargetNetwork(
    request: DisassociateClientVpnTargetNetworkRequest
  ): Ec2IO[DisassociateClientVpnTargetNetworkResponse] =
    FF.liftF(DisassociateClientVpnTargetNetwork(request))

  def disassociateEnclaveCertificateIamRole(
    request: DisassociateEnclaveCertificateIamRoleRequest
  ): Ec2IO[DisassociateEnclaveCertificateIamRoleResponse] =
    FF.liftF(DisassociateEnclaveCertificateIamRole(request))

  def disassociateIamInstanceProfile(
    request: DisassociateIamInstanceProfileRequest
  ): Ec2IO[DisassociateIamInstanceProfileResponse] =
    FF.liftF(DisassociateIamInstanceProfile(request))

  def disassociateRouteTable(
    request: DisassociateRouteTableRequest
  ): Ec2IO[DisassociateRouteTableResponse] =
    FF.liftF(DisassociateRouteTable(request))

  def disassociateSubnetCidrBlock(
    request: DisassociateSubnetCidrBlockRequest
  ): Ec2IO[DisassociateSubnetCidrBlockResponse] =
    FF.liftF(DisassociateSubnetCidrBlock(request))

  def disassociateTransitGatewayMulticastDomain(
    request: DisassociateTransitGatewayMulticastDomainRequest
  ): Ec2IO[DisassociateTransitGatewayMulticastDomainResponse] =
    FF.liftF(DisassociateTransitGatewayMulticastDomain(request))

  def disassociateTransitGatewayRouteTable(
    request: DisassociateTransitGatewayRouteTableRequest
  ): Ec2IO[DisassociateTransitGatewayRouteTableResponse] =
    FF.liftF(DisassociateTransitGatewayRouteTable(request))

  def disassociateVpcCidrBlock(
    request: DisassociateVpcCidrBlockRequest
  ): Ec2IO[DisassociateVpcCidrBlockResponse] =
    FF.liftF(DisassociateVpcCidrBlock(request))

  def enableEbsEncryptionByDefault(
    request: EnableEbsEncryptionByDefaultRequest
  ): Ec2IO[EnableEbsEncryptionByDefaultResponse] =
    FF.liftF(EnableEbsEncryptionByDefault(request))

  def enableFastSnapshotRestores(
    request: EnableFastSnapshotRestoresRequest
  ): Ec2IO[EnableFastSnapshotRestoresResponse] =
    FF.liftF(EnableFastSnapshotRestores(request))

  def enableImageDeprecation(
    request: EnableImageDeprecationRequest
  ): Ec2IO[EnableImageDeprecationResponse] =
    FF.liftF(EnableImageDeprecation(request))

  def enableSerialConsoleAccess(
    request: EnableSerialConsoleAccessRequest
  ): Ec2IO[EnableSerialConsoleAccessResponse] =
    FF.liftF(EnableSerialConsoleAccess(request))

  def enableTransitGatewayRouteTablePropagation(
    request: EnableTransitGatewayRouteTablePropagationRequest
  ): Ec2IO[EnableTransitGatewayRouteTablePropagationResponse] =
    FF.liftF(EnableTransitGatewayRouteTablePropagation(request))

  def enableVgwRoutePropagation(
    request: EnableVgwRoutePropagationRequest
  ): Ec2IO[EnableVgwRoutePropagationResponse] =
    FF.liftF(EnableVgwRoutePropagation(request))

  def enableVolumeIO(
    request: EnableVolumeIoRequest
  ): Ec2IO[EnableVolumeIoResponse] =
    FF.liftF(EnableVolumeIO(request))

  def enableVpcClassicLink(
    request: EnableVpcClassicLinkRequest
  ): Ec2IO[EnableVpcClassicLinkResponse] =
    FF.liftF(EnableVpcClassicLink(request))

  def enableVpcClassicLinkDnsSupport(
    request: EnableVpcClassicLinkDnsSupportRequest
  ): Ec2IO[EnableVpcClassicLinkDnsSupportResponse] =
    FF.liftF(EnableVpcClassicLinkDnsSupport(request))

  def exportClientVpnClientCertificateRevocationList(
    request: ExportClientVpnClientCertificateRevocationListRequest
  ): Ec2IO[ExportClientVpnClientCertificateRevocationListResponse] =
    FF.liftF(ExportClientVpnClientCertificateRevocationList(request))

  def exportClientVpnClientConfiguration(
    request: ExportClientVpnClientConfigurationRequest
  ): Ec2IO[ExportClientVpnClientConfigurationResponse] =
    FF.liftF(ExportClientVpnClientConfiguration(request))

  def exportImage(
    request: ExportImageRequest
  ): Ec2IO[ExportImageResponse] =
    FF.liftF(ExportImage(request))

  def exportTransitGatewayRoutes(
    request: ExportTransitGatewayRoutesRequest
  ): Ec2IO[ExportTransitGatewayRoutesResponse] =
    FF.liftF(ExportTransitGatewayRoutes(request))

  def getAssociatedEnclaveCertificateIamRoles(
    request: GetAssociatedEnclaveCertificateIamRolesRequest
  ): Ec2IO[GetAssociatedEnclaveCertificateIamRolesResponse] =
    FF.liftF(GetAssociatedEnclaveCertificateIamRoles(request))

  def getAssociatedIpv6PoolCidrs(
    request: GetAssociatedIpv6PoolCidrsRequest
  ): Ec2IO[GetAssociatedIpv6PoolCidrsResponse] =
    FF.liftF(GetAssociatedIpv6PoolCidrs(request))

  def getCapacityReservationUsage(
    request: GetCapacityReservationUsageRequest
  ): Ec2IO[GetCapacityReservationUsageResponse] =
    FF.liftF(GetCapacityReservationUsage(request))

  def getCoipPoolUsage(
    request: GetCoipPoolUsageRequest
  ): Ec2IO[GetCoipPoolUsageResponse] =
    FF.liftF(GetCoipPoolUsage(request))

  def getConsoleOutput(
    request: GetConsoleOutputRequest
  ): Ec2IO[GetConsoleOutputResponse] =
    FF.liftF(GetConsoleOutput(request))

  def getConsoleScreenshot(
    request: GetConsoleScreenshotRequest
  ): Ec2IO[GetConsoleScreenshotResponse] =
    FF.liftF(GetConsoleScreenshot(request))

  def getDefaultCreditSpecification(
    request: GetDefaultCreditSpecificationRequest
  ): Ec2IO[GetDefaultCreditSpecificationResponse] =
    FF.liftF(GetDefaultCreditSpecification(request))

  def getEbsDefaultKmsKeyId(
    request: GetEbsDefaultKmsKeyIdRequest
  ): Ec2IO[GetEbsDefaultKmsKeyIdResponse] =
    FF.liftF(GetEbsDefaultKmsKeyId(request))

  def getEbsEncryptionByDefault(
    request: GetEbsEncryptionByDefaultRequest
  ): Ec2IO[GetEbsEncryptionByDefaultResponse] =
    FF.liftF(GetEbsEncryptionByDefault(request))

  def getFlowLogsIntegrationTemplate(
    request: GetFlowLogsIntegrationTemplateRequest
  ): Ec2IO[GetFlowLogsIntegrationTemplateResponse] =
    FF.liftF(GetFlowLogsIntegrationTemplate(request))

  def getGroupsForCapacityReservation(
    request: GetGroupsForCapacityReservationRequest
  ): Ec2IO[GetGroupsForCapacityReservationResponse] =
    FF.liftF(GetGroupsForCapacityReservation(request))

  def getHostReservationPurchasePreview(
    request: GetHostReservationPurchasePreviewRequest
  ): Ec2IO[GetHostReservationPurchasePreviewResponse] =
    FF.liftF(GetHostReservationPurchasePreview(request))

  def getLaunchTemplateData(
    request: GetLaunchTemplateDataRequest
  ): Ec2IO[GetLaunchTemplateDataResponse] =
    FF.liftF(GetLaunchTemplateData(request))

  def getManagedPrefixListAssociations(
    request: GetManagedPrefixListAssociationsRequest
  ): Ec2IO[GetManagedPrefixListAssociationsResponse] =
    FF.liftF(GetManagedPrefixListAssociations(request))

  def getManagedPrefixListEntries(
    request: GetManagedPrefixListEntriesRequest
  ): Ec2IO[GetManagedPrefixListEntriesResponse] =
    FF.liftF(GetManagedPrefixListEntries(request))

  def getPasswordData(
    request: GetPasswordDataRequest
  ): Ec2IO[GetPasswordDataResponse] =
    FF.liftF(GetPasswordData(request))

  def getReservedInstancesExchangeQuote(
    request: GetReservedInstancesExchangeQuoteRequest
  ): Ec2IO[GetReservedInstancesExchangeQuoteResponse] =
    FF.liftF(GetReservedInstancesExchangeQuote(request))

  def getSerialConsoleAccessStatus(
    request: GetSerialConsoleAccessStatusRequest
  ): Ec2IO[GetSerialConsoleAccessStatusResponse] =
    FF.liftF(GetSerialConsoleAccessStatus(request))

  def getTransitGatewayAttachmentPropagations(
    request: GetTransitGatewayAttachmentPropagationsRequest
  ): Ec2IO[GetTransitGatewayAttachmentPropagationsResponse] =
    FF.liftF(GetTransitGatewayAttachmentPropagations(request))

  def getTransitGatewayMulticastDomainAssociations(
    request: GetTransitGatewayMulticastDomainAssociationsRequest
  ): Ec2IO[GetTransitGatewayMulticastDomainAssociationsResponse] =
    FF.liftF(GetTransitGatewayMulticastDomainAssociations(request))

  def getTransitGatewayPrefixListReferences(
    request: GetTransitGatewayPrefixListReferencesRequest
  ): Ec2IO[GetTransitGatewayPrefixListReferencesResponse] =
    FF.liftF(GetTransitGatewayPrefixListReferences(request))

  def getTransitGatewayRouteTableAssociations(
    request: GetTransitGatewayRouteTableAssociationsRequest
  ): Ec2IO[GetTransitGatewayRouteTableAssociationsResponse] =
    FF.liftF(GetTransitGatewayRouteTableAssociations(request))

  def getTransitGatewayRouteTablePropagations(
    request: GetTransitGatewayRouteTablePropagationsRequest
  ): Ec2IO[GetTransitGatewayRouteTablePropagationsResponse] =
    FF.liftF(GetTransitGatewayRouteTablePropagations(request))

  def importClientVpnClientCertificateRevocationList(
    request: ImportClientVpnClientCertificateRevocationListRequest
  ): Ec2IO[ImportClientVpnClientCertificateRevocationListResponse] =
    FF.liftF(ImportClientVpnClientCertificateRevocationList(request))

  def importImage(
    request: ImportImageRequest
  ): Ec2IO[ImportImageResponse] =
    FF.liftF(ImportImage(request))

  def importInstance(
    request: ImportInstanceRequest
  ): Ec2IO[ImportInstanceResponse] =
    FF.liftF(ImportInstance(request))

  def importKeyPair(
    request: ImportKeyPairRequest
  ): Ec2IO[ImportKeyPairResponse] =
    FF.liftF(ImportKeyPair(request))

  def importSnapshot(
    request: ImportSnapshotRequest
  ): Ec2IO[ImportSnapshotResponse] =
    FF.liftF(ImportSnapshot(request))

  def importVolume(
    request: ImportVolumeRequest
  ): Ec2IO[ImportVolumeResponse] =
    FF.liftF(ImportVolume(request))

  def modifyAddressAttribute(
    request: ModifyAddressAttributeRequest
  ): Ec2IO[ModifyAddressAttributeResponse] =
    FF.liftF(ModifyAddressAttribute(request))

  def modifyAvailabilityZoneGroup(
    request: ModifyAvailabilityZoneGroupRequest
  ): Ec2IO[ModifyAvailabilityZoneGroupResponse] =
    FF.liftF(ModifyAvailabilityZoneGroup(request))

  def modifyCapacityReservation(
    request: ModifyCapacityReservationRequest
  ): Ec2IO[ModifyCapacityReservationResponse] =
    FF.liftF(ModifyCapacityReservation(request))

  def modifyClientVpnEndpoint(
    request: ModifyClientVpnEndpointRequest
  ): Ec2IO[ModifyClientVpnEndpointResponse] =
    FF.liftF(ModifyClientVpnEndpoint(request))

  def modifyDefaultCreditSpecification(
    request: ModifyDefaultCreditSpecificationRequest
  ): Ec2IO[ModifyDefaultCreditSpecificationResponse] =
    FF.liftF(ModifyDefaultCreditSpecification(request))

  def modifyEbsDefaultKmsKeyId(
    request: ModifyEbsDefaultKmsKeyIdRequest
  ): Ec2IO[ModifyEbsDefaultKmsKeyIdResponse] =
    FF.liftF(ModifyEbsDefaultKmsKeyId(request))

  def modifyFleet(
    request: ModifyFleetRequest
  ): Ec2IO[ModifyFleetResponse] =
    FF.liftF(ModifyFleet(request))

  def modifyFpgaImageAttribute(
    request: ModifyFpgaImageAttributeRequest
  ): Ec2IO[ModifyFpgaImageAttributeResponse] =
    FF.liftF(ModifyFpgaImageAttribute(request))

  def modifyHosts(
    request: ModifyHostsRequest
  ): Ec2IO[ModifyHostsResponse] =
    FF.liftF(ModifyHosts(request))

  def modifyIdFormat(
    request: ModifyIdFormatRequest
  ): Ec2IO[ModifyIdFormatResponse] =
    FF.liftF(ModifyIdFormat(request))

  def modifyIdentityIdFormat(
    request: ModifyIdentityIdFormatRequest
  ): Ec2IO[ModifyIdentityIdFormatResponse] =
    FF.liftF(ModifyIdentityIdFormat(request))

  def modifyImageAttribute(
    request: ModifyImageAttributeRequest
  ): Ec2IO[ModifyImageAttributeResponse] =
    FF.liftF(ModifyImageAttribute(request))

  def modifyInstanceAttribute(
    request: ModifyInstanceAttributeRequest
  ): Ec2IO[ModifyInstanceAttributeResponse] =
    FF.liftF(ModifyInstanceAttribute(request))

  def modifyInstanceCapacityReservationAttributes(
    request: ModifyInstanceCapacityReservationAttributesRequest
  ): Ec2IO[ModifyInstanceCapacityReservationAttributesResponse] =
    FF.liftF(ModifyInstanceCapacityReservationAttributes(request))

  def modifyInstanceCreditSpecification(
    request: ModifyInstanceCreditSpecificationRequest
  ): Ec2IO[ModifyInstanceCreditSpecificationResponse] =
    FF.liftF(ModifyInstanceCreditSpecification(request))

  def modifyInstanceEventStartTime(
    request: ModifyInstanceEventStartTimeRequest
  ): Ec2IO[ModifyInstanceEventStartTimeResponse] =
    FF.liftF(ModifyInstanceEventStartTime(request))

  def modifyInstanceMetadataOptions(
    request: ModifyInstanceMetadataOptionsRequest
  ): Ec2IO[ModifyInstanceMetadataOptionsResponse] =
    FF.liftF(ModifyInstanceMetadataOptions(request))

  def modifyInstancePlacement(
    request: ModifyInstancePlacementRequest
  ): Ec2IO[ModifyInstancePlacementResponse] =
    FF.liftF(ModifyInstancePlacement(request))

  def modifyLaunchTemplate(
    request: ModifyLaunchTemplateRequest
  ): Ec2IO[ModifyLaunchTemplateResponse] =
    FF.liftF(ModifyLaunchTemplate(request))

  def modifyManagedPrefixList(
    request: ModifyManagedPrefixListRequest
  ): Ec2IO[ModifyManagedPrefixListResponse] =
    FF.liftF(ModifyManagedPrefixList(request))

  def modifyNetworkInterfaceAttribute(
    request: ModifyNetworkInterfaceAttributeRequest
  ): Ec2IO[ModifyNetworkInterfaceAttributeResponse] =
    FF.liftF(ModifyNetworkInterfaceAttribute(request))

  def modifyReservedInstances(
    request: ModifyReservedInstancesRequest
  ): Ec2IO[ModifyReservedInstancesResponse] =
    FF.liftF(ModifyReservedInstances(request))

  def modifySnapshotAttribute(
    request: ModifySnapshotAttributeRequest
  ): Ec2IO[ModifySnapshotAttributeResponse] =
    FF.liftF(ModifySnapshotAttribute(request))

  def modifySpotFleetRequest(
    request: ModifySpotFleetRequestRequest
  ): Ec2IO[ModifySpotFleetRequestResponse] =
    FF.liftF(ModifySpotFleetRequest(request))

  def modifySubnetAttribute(
    request: ModifySubnetAttributeRequest
  ): Ec2IO[ModifySubnetAttributeResponse] =
    FF.liftF(ModifySubnetAttribute(request))

  def modifyTrafficMirrorFilterNetworkServices(
    request: ModifyTrafficMirrorFilterNetworkServicesRequest
  ): Ec2IO[ModifyTrafficMirrorFilterNetworkServicesResponse] =
    FF.liftF(ModifyTrafficMirrorFilterNetworkServices(request))

  def modifyTrafficMirrorFilterRule(
    request: ModifyTrafficMirrorFilterRuleRequest
  ): Ec2IO[ModifyTrafficMirrorFilterRuleResponse] =
    FF.liftF(ModifyTrafficMirrorFilterRule(request))

  def modifyTrafficMirrorSession(
    request: ModifyTrafficMirrorSessionRequest
  ): Ec2IO[ModifyTrafficMirrorSessionResponse] =
    FF.liftF(ModifyTrafficMirrorSession(request))

  def modifyTransitGateway(
    request: ModifyTransitGatewayRequest
  ): Ec2IO[ModifyTransitGatewayResponse] =
    FF.liftF(ModifyTransitGateway(request))

  def modifyTransitGatewayPrefixListReference(
    request: ModifyTransitGatewayPrefixListReferenceRequest
  ): Ec2IO[ModifyTransitGatewayPrefixListReferenceResponse] =
    FF.liftF(ModifyTransitGatewayPrefixListReference(request))

  def modifyTransitGatewayVpcAttachment(
    request: ModifyTransitGatewayVpcAttachmentRequest
  ): Ec2IO[ModifyTransitGatewayVpcAttachmentResponse] =
    FF.liftF(ModifyTransitGatewayVpcAttachment(request))

  def modifyVolume(
    request: ModifyVolumeRequest
  ): Ec2IO[ModifyVolumeResponse] =
    FF.liftF(ModifyVolume(request))

  def modifyVolumeAttribute(
    request: ModifyVolumeAttributeRequest
  ): Ec2IO[ModifyVolumeAttributeResponse] =
    FF.liftF(ModifyVolumeAttribute(request))

  def modifyVpcAttribute(
    request: ModifyVpcAttributeRequest
  ): Ec2IO[ModifyVpcAttributeResponse] =
    FF.liftF(ModifyVpcAttribute(request))

  def modifyVpcEndpoint(
    request: ModifyVpcEndpointRequest
  ): Ec2IO[ModifyVpcEndpointResponse] =
    FF.liftF(ModifyVpcEndpoint(request))

  def modifyVpcEndpointConnectionNotification(
    request: ModifyVpcEndpointConnectionNotificationRequest
  ): Ec2IO[ModifyVpcEndpointConnectionNotificationResponse] =
    FF.liftF(ModifyVpcEndpointConnectionNotification(request))

  def modifyVpcEndpointServiceConfiguration(
    request: ModifyVpcEndpointServiceConfigurationRequest
  ): Ec2IO[ModifyVpcEndpointServiceConfigurationResponse] =
    FF.liftF(ModifyVpcEndpointServiceConfiguration(request))

  def modifyVpcEndpointServicePermissions(
    request: ModifyVpcEndpointServicePermissionsRequest
  ): Ec2IO[ModifyVpcEndpointServicePermissionsResponse] =
    FF.liftF(ModifyVpcEndpointServicePermissions(request))

  def modifyVpcPeeringConnectionOptions(
    request: ModifyVpcPeeringConnectionOptionsRequest
  ): Ec2IO[ModifyVpcPeeringConnectionOptionsResponse] =
    FF.liftF(ModifyVpcPeeringConnectionOptions(request))

  def modifyVpcTenancy(
    request: ModifyVpcTenancyRequest
  ): Ec2IO[ModifyVpcTenancyResponse] =
    FF.liftF(ModifyVpcTenancy(request))

  def modifyVpnConnection(
    request: ModifyVpnConnectionRequest
  ): Ec2IO[ModifyVpnConnectionResponse] =
    FF.liftF(ModifyVpnConnection(request))

  def modifyVpnConnectionOptions(
    request: ModifyVpnConnectionOptionsRequest
  ): Ec2IO[ModifyVpnConnectionOptionsResponse] =
    FF.liftF(ModifyVpnConnectionOptions(request))

  def modifyVpnTunnelCertificate(
    request: ModifyVpnTunnelCertificateRequest
  ): Ec2IO[ModifyVpnTunnelCertificateResponse] =
    FF.liftF(ModifyVpnTunnelCertificate(request))

  def modifyVpnTunnelOptions(
    request: ModifyVpnTunnelOptionsRequest
  ): Ec2IO[ModifyVpnTunnelOptionsResponse] =
    FF.liftF(ModifyVpnTunnelOptions(request))

  def monitorInstances(
    request: MonitorInstancesRequest
  ): Ec2IO[MonitorInstancesResponse] =
    FF.liftF(MonitorInstances(request))

  def moveAddressToVpc(
    request: MoveAddressToVpcRequest
  ): Ec2IO[MoveAddressToVpcResponse] =
    FF.liftF(MoveAddressToVpc(request))

  def provisionByoipCidr(
    request: ProvisionByoipCidrRequest
  ): Ec2IO[ProvisionByoipCidrResponse] =
    FF.liftF(ProvisionByoipCidr(request))

  def purchaseHostReservation(
    request: PurchaseHostReservationRequest
  ): Ec2IO[PurchaseHostReservationResponse] =
    FF.liftF(PurchaseHostReservation(request))

  def purchaseReservedInstancesOffering(
    request: PurchaseReservedInstancesOfferingRequest
  ): Ec2IO[PurchaseReservedInstancesOfferingResponse] =
    FF.liftF(PurchaseReservedInstancesOffering(request))

  def purchaseScheduledInstances(
    request: PurchaseScheduledInstancesRequest
  ): Ec2IO[PurchaseScheduledInstancesResponse] =
    FF.liftF(PurchaseScheduledInstances(request))

  def rebootInstances(
    request: RebootInstancesRequest
  ): Ec2IO[RebootInstancesResponse] =
    FF.liftF(RebootInstances(request))

  def registerImage(
    request: RegisterImageRequest
  ): Ec2IO[RegisterImageResponse] =
    FF.liftF(RegisterImage(request))

  def registerInstanceEventNotificationAttributes(
    request: RegisterInstanceEventNotificationAttributesRequest
  ): Ec2IO[RegisterInstanceEventNotificationAttributesResponse] =
    FF.liftF(RegisterInstanceEventNotificationAttributes(request))

  def registerTransitGatewayMulticastGroupMembers(
    request: RegisterTransitGatewayMulticastGroupMembersRequest
  ): Ec2IO[RegisterTransitGatewayMulticastGroupMembersResponse] =
    FF.liftF(RegisterTransitGatewayMulticastGroupMembers(request))

  def registerTransitGatewayMulticastGroupSources(
    request: RegisterTransitGatewayMulticastGroupSourcesRequest
  ): Ec2IO[RegisterTransitGatewayMulticastGroupSourcesResponse] =
    FF.liftF(RegisterTransitGatewayMulticastGroupSources(request))

  def rejectTransitGatewayMulticastDomainAssociations(
    request: RejectTransitGatewayMulticastDomainAssociationsRequest
  ): Ec2IO[RejectTransitGatewayMulticastDomainAssociationsResponse] =
    FF.liftF(RejectTransitGatewayMulticastDomainAssociations(request))

  def rejectTransitGatewayPeeringAttachment(
    request: RejectTransitGatewayPeeringAttachmentRequest
  ): Ec2IO[RejectTransitGatewayPeeringAttachmentResponse] =
    FF.liftF(RejectTransitGatewayPeeringAttachment(request))

  def rejectTransitGatewayVpcAttachment(
    request: RejectTransitGatewayVpcAttachmentRequest
  ): Ec2IO[RejectTransitGatewayVpcAttachmentResponse] =
    FF.liftF(RejectTransitGatewayVpcAttachment(request))

  def rejectVpcEndpointConnections(
    request: RejectVpcEndpointConnectionsRequest
  ): Ec2IO[RejectVpcEndpointConnectionsResponse] =
    FF.liftF(RejectVpcEndpointConnections(request))

  def rejectVpcPeeringConnection(
    request: RejectVpcPeeringConnectionRequest
  ): Ec2IO[RejectVpcPeeringConnectionResponse] =
    FF.liftF(RejectVpcPeeringConnection(request))

  def releaseAddress(
    request: ReleaseAddressRequest
  ): Ec2IO[ReleaseAddressResponse] =
    FF.liftF(ReleaseAddress(request))

  def releaseHosts(
    request: ReleaseHostsRequest
  ): Ec2IO[ReleaseHostsResponse] =
    FF.liftF(ReleaseHosts(request))

  def replaceIamInstanceProfileAssociation(
    request: ReplaceIamInstanceProfileAssociationRequest
  ): Ec2IO[ReplaceIamInstanceProfileAssociationResponse] =
    FF.liftF(ReplaceIamInstanceProfileAssociation(request))

  def replaceNetworkAclAssociation(
    request: ReplaceNetworkAclAssociationRequest
  ): Ec2IO[ReplaceNetworkAclAssociationResponse] =
    FF.liftF(ReplaceNetworkAclAssociation(request))

  def replaceNetworkAclEntry(
    request: ReplaceNetworkAclEntryRequest
  ): Ec2IO[ReplaceNetworkAclEntryResponse] =
    FF.liftF(ReplaceNetworkAclEntry(request))

  def replaceRoute(
    request: ReplaceRouteRequest
  ): Ec2IO[ReplaceRouteResponse] =
    FF.liftF(ReplaceRoute(request))

  def replaceRouteTableAssociation(
    request: ReplaceRouteTableAssociationRequest
  ): Ec2IO[ReplaceRouteTableAssociationResponse] =
    FF.liftF(ReplaceRouteTableAssociation(request))

  def replaceTransitGatewayRoute(
    request: ReplaceTransitGatewayRouteRequest
  ): Ec2IO[ReplaceTransitGatewayRouteResponse] =
    FF.liftF(ReplaceTransitGatewayRoute(request))

  def reportInstanceStatus(
    request: ReportInstanceStatusRequest
  ): Ec2IO[ReportInstanceStatusResponse] =
    FF.liftF(ReportInstanceStatus(request))

  def requestSpotFleet(
    request: RequestSpotFleetRequest
  ): Ec2IO[RequestSpotFleetResponse] =
    FF.liftF(RequestSpotFleet(request))

  def requestSpotInstances(
    request: RequestSpotInstancesRequest
  ): Ec2IO[RequestSpotInstancesResponse] =
    FF.liftF(RequestSpotInstances(request))

  def resetAddressAttribute(
    request: ResetAddressAttributeRequest
  ): Ec2IO[ResetAddressAttributeResponse] =
    FF.liftF(ResetAddressAttribute(request))

  def resetEbsDefaultKmsKeyId(
    request: ResetEbsDefaultKmsKeyIdRequest
  ): Ec2IO[ResetEbsDefaultKmsKeyIdResponse] =
    FF.liftF(ResetEbsDefaultKmsKeyId(request))

  def resetFpgaImageAttribute(
    request: ResetFpgaImageAttributeRequest
  ): Ec2IO[ResetFpgaImageAttributeResponse] =
    FF.liftF(ResetFpgaImageAttribute(request))

  def resetImageAttribute(
    request: ResetImageAttributeRequest
  ): Ec2IO[ResetImageAttributeResponse] =
    FF.liftF(ResetImageAttribute(request))

  def resetInstanceAttribute(
    request: ResetInstanceAttributeRequest
  ): Ec2IO[ResetInstanceAttributeResponse] =
    FF.liftF(ResetInstanceAttribute(request))

  def resetNetworkInterfaceAttribute(
    request: ResetNetworkInterfaceAttributeRequest
  ): Ec2IO[ResetNetworkInterfaceAttributeResponse] =
    FF.liftF(ResetNetworkInterfaceAttribute(request))

  def resetSnapshotAttribute(
    request: ResetSnapshotAttributeRequest
  ): Ec2IO[ResetSnapshotAttributeResponse] =
    FF.liftF(ResetSnapshotAttribute(request))

  def restoreAddressToClassic(
    request: RestoreAddressToClassicRequest
  ): Ec2IO[RestoreAddressToClassicResponse] =
    FF.liftF(RestoreAddressToClassic(request))

  def restoreManagedPrefixListVersion(
    request: RestoreManagedPrefixListVersionRequest
  ): Ec2IO[RestoreManagedPrefixListVersionResponse] =
    FF.liftF(RestoreManagedPrefixListVersion(request))

  def revokeClientVpnIngress(
    request: RevokeClientVpnIngressRequest
  ): Ec2IO[RevokeClientVpnIngressResponse] =
    FF.liftF(RevokeClientVpnIngress(request))

  def revokeSecurityGroupEgress(
    request: RevokeSecurityGroupEgressRequest
  ): Ec2IO[RevokeSecurityGroupEgressResponse] =
    FF.liftF(RevokeSecurityGroupEgress(request))

  def revokeSecurityGroupIngress(
    request: RevokeSecurityGroupIngressRequest
  ): Ec2IO[RevokeSecurityGroupIngressResponse] =
    FF.liftF(RevokeSecurityGroupIngress(request))

  def runInstances(
    request: RunInstancesRequest
  ): Ec2IO[RunInstancesResponse] =
    FF.liftF(RunInstances(request))

  def runScheduledInstances(
    request: RunScheduledInstancesRequest
  ): Ec2IO[RunScheduledInstancesResponse] =
    FF.liftF(RunScheduledInstances(request))

  def searchLocalGatewayRoutes(
    request: SearchLocalGatewayRoutesRequest
  ): Ec2IO[SearchLocalGatewayRoutesResponse] =
    FF.liftF(SearchLocalGatewayRoutes(request))

  def searchTransitGatewayMulticastGroups(
    request: SearchTransitGatewayMulticastGroupsRequest
  ): Ec2IO[SearchTransitGatewayMulticastGroupsResponse] =
    FF.liftF(SearchTransitGatewayMulticastGroups(request))

  def searchTransitGatewayRoutes(
    request: SearchTransitGatewayRoutesRequest
  ): Ec2IO[SearchTransitGatewayRoutesResponse] =
    FF.liftF(SearchTransitGatewayRoutes(request))

  def sendDiagnosticInterrupt(
    request: SendDiagnosticInterruptRequest
  ): Ec2IO[SendDiagnosticInterruptResponse] =
    FF.liftF(SendDiagnosticInterrupt(request))

  def startInstances(
    request: StartInstancesRequest
  ): Ec2IO[StartInstancesResponse] =
    FF.liftF(StartInstances(request))

  def startNetworkInsightsAnalysis(
    request: StartNetworkInsightsAnalysisRequest
  ): Ec2IO[StartNetworkInsightsAnalysisResponse] =
    FF.liftF(StartNetworkInsightsAnalysis(request))

  def startVpcEndpointServicePrivateDnsVerification(
    request: StartVpcEndpointServicePrivateDnsVerificationRequest
  ): Ec2IO[StartVpcEndpointServicePrivateDnsVerificationResponse] =
    FF.liftF(StartVpcEndpointServicePrivateDnsVerification(request))

  def stopInstances(
    request: StopInstancesRequest
  ): Ec2IO[StopInstancesResponse] =
    FF.liftF(StopInstances(request))

  def terminateClientVpnConnections(
    request: TerminateClientVpnConnectionsRequest
  ): Ec2IO[TerminateClientVpnConnectionsResponse] =
    FF.liftF(TerminateClientVpnConnections(request))

  def terminateInstances(
    request: TerminateInstancesRequest
  ): Ec2IO[TerminateInstancesResponse] =
    FF.liftF(TerminateInstances(request))

  def unassignIpv6Addresses(
    request: UnassignIpv6AddressesRequest
  ): Ec2IO[UnassignIpv6AddressesResponse] =
    FF.liftF(UnassignIpv6Addresses(request))

  def unassignPrivateIpAddresses(
    request: UnassignPrivateIpAddressesRequest
  ): Ec2IO[UnassignPrivateIpAddressesResponse] =
    FF.liftF(UnassignPrivateIpAddresses(request))

  def unmonitorInstances(
    request: UnmonitorInstancesRequest
  ): Ec2IO[UnmonitorInstancesResponse] =
    FF.liftF(UnmonitorInstances(request))

  def updateSecurityGroupRuleDescriptionsEgress(
    request: UpdateSecurityGroupRuleDescriptionsEgressRequest
  ): Ec2IO[UpdateSecurityGroupRuleDescriptionsEgressResponse] =
    FF.liftF(UpdateSecurityGroupRuleDescriptionsEgress(request))

  def updateSecurityGroupRuleDescriptionsIngress(
    request: UpdateSecurityGroupRuleDescriptionsIngressRequest
  ): Ec2IO[UpdateSecurityGroupRuleDescriptionsIngressResponse] =
    FF.liftF(UpdateSecurityGroupRuleDescriptionsIngress(request))

  def withdrawByoipCidr(
    request: WithdrawByoipCidrRequest
  ): Ec2IO[WithdrawByoipCidrResponse] =
    FF.liftF(WithdrawByoipCidr(request))
}
