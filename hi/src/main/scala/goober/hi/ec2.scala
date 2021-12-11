package goober.hi

import goober.free.ec2.Ec2IO
import software.amazon.awssdk.services.ec2.model._


object ec2 {
  import goober.free.{ec2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptReservedInstancesExchangeQuoteRequest(
      reservedInstanceIds: Option[List[ReservationId]] = None,
      targetConfigurations: Option[List[TargetConfigurationRequest]] = None
    ): AcceptReservedInstancesExchangeQuoteRequest =
      AcceptReservedInstancesExchangeQuoteRequest
        .builder
        .ifSome(reservedInstanceIds)(_.reservedInstanceIds(_))
        .ifSome(targetConfigurations)(_.targetConfigurations(_))
        .build

    def acceptTransitGatewayMulticastDomainAssociationsRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): AcceptTransitGatewayMulticastDomainAssociationsRequest =
      AcceptTransitGatewayMulticastDomainAssociationsRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def acceptTransitGatewayPeeringAttachmentRequest(
      transitGatewayAttachmentId: Option[String] = None
    ): AcceptTransitGatewayPeeringAttachmentRequest =
      AcceptTransitGatewayPeeringAttachmentRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def acceptTransitGatewayVpcAttachmentRequest(
      transitGatewayAttachmentId: Option[String] = None
    ): AcceptTransitGatewayVpcAttachmentRequest =
      AcceptTransitGatewayVpcAttachmentRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def acceptVpcEndpointConnectionsRequest(
      serviceId: Option[String] = None,
      vpcEndpointIds: Option[List[VpcEndpointId]] = None
    ): AcceptVpcEndpointConnectionsRequest =
      AcceptVpcEndpointConnectionsRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(vpcEndpointIds)(_.vpcEndpointIds(_))
        .build

    def acceptVpcPeeringConnectionRequest(
      vpcPeeringConnectionId: Option[String] = None
    ): AcceptVpcPeeringConnectionRequest =
      AcceptVpcPeeringConnectionRequest
        .builder
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def accountAttribute(
      attributeName: Option[String] = None,
      attributeValues: Option[List[AccountAttributeValue]] = None
    ): AccountAttribute =
      AccountAttribute
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValues)(_.attributeValues(_))
        .build

    def accountAttributeValue(
      attributeValue: Option[String] = None
    ): AccountAttributeValue =
      AccountAttributeValue
        .builder
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def activeInstance(
      instanceId: Option[String] = None,
      instanceType: Option[String] = None,
      spotInstanceRequestId: Option[String] = None,
      instanceHealth: Option[String] = None
    ): ActiveInstance =
      ActiveInstance
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(spotInstanceRequestId)(_.spotInstanceRequestId(_))
        .ifSome(instanceHealth)(_.instanceHealth(_))
        .build

    def addPrefixListEntry(
      cidr: Option[String] = None,
      description: Option[String] = None
    ): AddPrefixListEntry =
      AddPrefixListEntry
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(description)(_.description(_))
        .build

    def address(
      instanceId: Option[String] = None,
      publicIp: Option[String] = None,
      allocationId: Option[String] = None,
      associationId: Option[String] = None,
      domain: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      networkInterfaceOwnerId: Option[String] = None,
      privateIpAddress: Option[String] = None,
      tags: Option[List[Tag]] = None,
      publicIpv4Pool: Option[String] = None,
      networkBorderGroup: Option[String] = None,
      customerOwnedIp: Option[String] = None,
      customerOwnedIpv4Pool: Option[String] = None,
      carrierIp: Option[String] = None
    ): Address =
      Address
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(networkInterfaceOwnerId)(_.networkInterfaceOwnerId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(publicIpv4Pool)(_.publicIpv4Pool(_))
        .ifSome(networkBorderGroup)(_.networkBorderGroup(_))
        .ifSome(customerOwnedIp)(_.customerOwnedIp(_))
        .ifSome(customerOwnedIpv4Pool)(_.customerOwnedIpv4Pool(_))
        .ifSome(carrierIp)(_.carrierIp(_))
        .build

    def addressAttribute(
      publicIp: Option[String] = None,
      allocationId: Option[String] = None,
      ptrRecord: Option[String] = None,
      ptrRecordUpdate: Option[PtrUpdateStatus] = None
    ): AddressAttribute =
      AddressAttribute
        .builder
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(ptrRecord)(_.ptrRecord(_))
        .ifSome(ptrRecordUpdate)(_.ptrRecordUpdate(_))
        .build

    def advertiseByoipCidrRequest(
      cidr: Option[String] = None
    ): AdvertiseByoipCidrRequest =
      AdvertiseByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def allocateAddressRequest(
      domain: Option[String] = None,
      address: Option[String] = None,
      publicIpv4Pool: Option[String] = None,
      networkBorderGroup: Option[String] = None,
      customerOwnedIpv4Pool: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): AllocateAddressRequest =
      AllocateAddressRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(address)(_.address(_))
        .ifSome(publicIpv4Pool)(_.publicIpv4Pool(_))
        .ifSome(networkBorderGroup)(_.networkBorderGroup(_))
        .ifSome(customerOwnedIpv4Pool)(_.customerOwnedIpv4Pool(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def allocateHostsRequest(
      autoPlacement: Option[String] = None,
      availabilityZone: Option[String] = None,
      clientToken: Option[String] = None,
      instanceType: Option[String] = None,
      instanceFamily: Option[String] = None,
      quantity: Option[Int] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      hostRecovery: Option[String] = None
    ): AllocateHostsRequest =
      AllocateHostsRequest
        .builder
        .ifSome(autoPlacement)(_.autoPlacement(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(hostRecovery)(_.hostRecovery(_))
        .build

    def allowedPrincipal(
      principalType: Option[String] = None,
      principal: Option[String] = None
    ): AllowedPrincipal =
      AllowedPrincipal
        .builder
        .ifSome(principalType)(_.principalType(_))
        .ifSome(principal)(_.principal(_))
        .build

    def alternatePathHint(
      componentId: Option[String] = None,
      componentArn: Option[String] = None
    ): AlternatePathHint =
      AlternatePathHint
        .builder
        .ifSome(componentId)(_.componentId(_))
        .ifSome(componentArn)(_.componentArn(_))
        .build

    def analysisAclRule(
      cidr: Option[String] = None,
      egress: Option[Boolean] = None,
      portRange: Option[PortRange] = None,
      protocol: Option[String] = None,
      ruleAction: Option[String] = None,
      ruleNumber: Option[Int] = None
    ): AnalysisAclRule =
      AnalysisAclRule
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(egress)(_.egress(_))
        .ifSome(portRange)(_.portRange(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .build

    def analysisComponent(
      id: Option[String] = None,
      arn: Option[String] = None
    ): AnalysisComponent =
      AnalysisComponent
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .build

    def analysisLoadBalancerListener(
      loadBalancerPort: Option[Int] = None,
      instancePort: Option[Int] = None
    ): AnalysisLoadBalancerListener =
      AnalysisLoadBalancerListener
        .builder
        .ifSome(loadBalancerPort)(_.loadBalancerPort(_))
        .ifSome(instancePort)(_.instancePort(_))
        .build

    def analysisLoadBalancerTarget(
      address: Option[String] = None,
      availabilityZone: Option[String] = None,
      instance: Option[AnalysisComponent] = None,
      port: Option[Int] = None
    ): AnalysisLoadBalancerTarget =
      AnalysisLoadBalancerTarget
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(instance)(_.instance(_))
        .ifSome(port)(_.port(_))
        .build

    def analysisPacketHeader(
      destinationAddresses: Option[List[IpAddress]] = None,
      destinationPortRanges: Option[List[PortRange]] = None,
      protocol: Option[String] = None,
      sourceAddresses: Option[List[IpAddress]] = None,
      sourcePortRanges: Option[List[PortRange]] = None
    ): AnalysisPacketHeader =
      AnalysisPacketHeader
        .builder
        .ifSome(destinationAddresses)(_.destinationAddresses(_))
        .ifSome(destinationPortRanges)(_.destinationPortRanges(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(sourceAddresses)(_.sourceAddresses(_))
        .ifSome(sourcePortRanges)(_.sourcePortRanges(_))
        .build

    def analysisRouteTableRoute(
      destinationCidr: Option[String] = None,
      destinationPrefixListId: Option[String] = None,
      egressOnlyInternetGatewayId: Option[String] = None,
      gatewayId: Option[String] = None,
      instanceId: Option[String] = None,
      natGatewayId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      origin: Option[String] = None,
      transitGatewayId: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): AnalysisRouteTableRoute =
      AnalysisRouteTableRoute
        .builder
        .ifSome(destinationCidr)(_.destinationCidr(_))
        .ifSome(destinationPrefixListId)(_.destinationPrefixListId(_))
        .ifSome(egressOnlyInternetGatewayId)(_.egressOnlyInternetGatewayId(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(natGatewayId)(_.natGatewayId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def analysisSecurityGroupRule(
      cidr: Option[String] = None,
      direction: Option[String] = None,
      securityGroupId: Option[String] = None,
      portRange: Option[PortRange] = None,
      prefixListId: Option[String] = None,
      protocol: Option[String] = None
    ): AnalysisSecurityGroupRule =
      AnalysisSecurityGroupRule
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(direction)(_.direction(_))
        .ifSome(securityGroupId)(_.securityGroupId(_))
        .ifSome(portRange)(_.portRange(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def applySecurityGroupsToClientVpnTargetNetworkRequest(
      clientVpnEndpointId: Option[String] = None,
      vpcId: Option[String] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): ApplySecurityGroupsToClientVpnTargetNetworkRequest =
      ApplySecurityGroupsToClientVpnTargetNetworkRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def assignIpv6AddressesRequest(
      ipv6AddressCount: Option[Int] = None,
      ipv6Addresses: Option[List[String]] = None,
      networkInterfaceId: Option[String] = None
    ): AssignIpv6AddressesRequest =
      AssignIpv6AddressesRequest
        .builder
        .ifSome(ipv6AddressCount)(_.ipv6AddressCount(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .build

    def assignPrivateIpAddressesRequest(
      allowReassignment: Option[Boolean] = None,
      networkInterfaceId: Option[String] = None,
      privateIpAddresses: Option[List[String]] = None,
      secondaryPrivateIpAddressCount: Option[Int] = None
    ): AssignPrivateIpAddressesRequest =
      AssignPrivateIpAddressesRequest
        .builder
        .ifSome(allowReassignment)(_.allowReassignment(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(secondaryPrivateIpAddressCount)(_.secondaryPrivateIpAddressCount(_))
        .build

    def assignedPrivateIpAddress(
      privateIpAddress: Option[String] = None
    ): AssignedPrivateIpAddress =
      AssignedPrivateIpAddress
        .builder
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def associateAddressRequest(
      allocationId: Option[String] = None,
      instanceId: Option[String] = None,
      publicIp: Option[String] = None,
      allowReassociation: Option[Boolean] = None,
      networkInterfaceId: Option[String] = None,
      privateIpAddress: Option[String] = None
    ): AssociateAddressRequest =
      AssociateAddressRequest
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(allowReassociation)(_.allowReassociation(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def associateClientVpnTargetNetworkRequest(
      clientVpnEndpointId: Option[String] = None,
      subnetId: Option[String] = None,
      clientToken: Option[String] = None
    ): AssociateClientVpnTargetNetworkRequest =
      AssociateClientVpnTargetNetworkRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def associateDhcpOptionsRequest(
      dhcpOptionsId: Option[String] = None,
      vpcId: Option[String] = None
    ): AssociateDhcpOptionsRequest =
      AssociateDhcpOptionsRequest
        .builder
        .ifSome(dhcpOptionsId)(_.dhcpOptionsId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def associateEnclaveCertificateIamRoleRequest(
      certificateArn: Option[String] = None,
      roleArn: Option[String] = None
    ): AssociateEnclaveCertificateIamRoleRequest =
      AssociateEnclaveCertificateIamRoleRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def associateIamInstanceProfileRequest(
      iamInstanceProfile: Option[IamInstanceProfileSpecification] = None,
      instanceId: Option[String] = None
    ): AssociateIamInstanceProfileRequest =
      AssociateIamInstanceProfileRequest
        .builder
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def associateRouteTableRequest(
      routeTableId: Option[String] = None,
      subnetId: Option[String] = None,
      gatewayId: Option[String] = None
    ): AssociateRouteTableRequest =
      AssociateRouteTableRequest
        .builder
        .ifSome(routeTableId)(_.routeTableId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .build

    def associateSubnetCidrBlockRequest(
      ipv6CidrBlock: Option[String] = None,
      subnetId: Option[String] = None
    ): AssociateSubnetCidrBlockRequest =
      AssociateSubnetCidrBlockRequest
        .builder
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def associateTransitGatewayMulticastDomainRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None
    ): AssociateTransitGatewayMulticastDomainRequest =
      AssociateTransitGatewayMulticastDomainRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def associateTransitGatewayRouteTableRequest(
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None
    ): AssociateTransitGatewayRouteTableRequest =
      AssociateTransitGatewayRouteTableRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def associateVpcCidrBlockRequest(
      amazonProvidedIpv6CidrBlock: Option[Boolean] = None,
      cidrBlock: Option[String] = None,
      vpcId: Option[String] = None,
      ipv6CidrBlockNetworkBorderGroup: Option[String] = None,
      ipv6Pool: Option[String] = None,
      ipv6CidrBlock: Option[String] = None
    ): AssociateVpcCidrBlockRequest =
      AssociateVpcCidrBlockRequest
        .builder
        .ifSome(amazonProvidedIpv6CidrBlock)(_.amazonProvidedIpv6CidrBlock(_))
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ipv6CidrBlockNetworkBorderGroup)(_.ipv6CidrBlockNetworkBorderGroup(_))
        .ifSome(ipv6Pool)(_.ipv6Pool(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .build

    def associatedRole(
      associatedRoleArn: Option[String] = None,
      certificateS3BucketName: Option[String] = None,
      certificateS3ObjectKey: Option[String] = None,
      encryptionKmsKeyId: Option[String] = None
    ): AssociatedRole =
      AssociatedRole
        .builder
        .ifSome(associatedRoleArn)(_.associatedRoleArn(_))
        .ifSome(certificateS3BucketName)(_.certificateS3BucketName(_))
        .ifSome(certificateS3ObjectKey)(_.certificateS3ObjectKey(_))
        .ifSome(encryptionKmsKeyId)(_.encryptionKmsKeyId(_))
        .build

    def associatedTargetNetwork(
      networkId: Option[String] = None,
      networkType: Option[String] = None
    ): AssociatedTargetNetwork =
      AssociatedTargetNetwork
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(networkType)(_.networkType(_))
        .build

    def associationStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): AssociationStatus =
      AssociationStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def athenaIntegration(
      integrationResultS3DestinationArn: Option[String] = None,
      partitionLoadFrequency: Option[String] = None,
      partitionStartDate: Option[MillisecondDateTime] = None,
      partitionEndDate: Option[MillisecondDateTime] = None
    ): AthenaIntegration =
      AthenaIntegration
        .builder
        .ifSome(integrationResultS3DestinationArn)(_.integrationResultS3DestinationArn(_))
        .ifSome(partitionLoadFrequency)(_.partitionLoadFrequency(_))
        .ifSome(partitionStartDate)(_.partitionStartDate(_))
        .ifSome(partitionEndDate)(_.partitionEndDate(_))
        .build

    def attachClassicLinkVpcRequest(
      groups: Option[List[String]] = None,
      instanceId: Option[String] = None,
      vpcId: Option[String] = None
    ): AttachClassicLinkVpcRequest =
      AttachClassicLinkVpcRequest
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def attachInternetGatewayRequest(
      internetGatewayId: Option[String] = None,
      vpcId: Option[String] = None
    ): AttachInternetGatewayRequest =
      AttachInternetGatewayRequest
        .builder
        .ifSome(internetGatewayId)(_.internetGatewayId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def attachNetworkInterfaceRequest(
      deviceIndex: Option[Int] = None,
      instanceId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      networkCardIndex: Option[Int] = None
    ): AttachNetworkInterfaceRequest =
      AttachNetworkInterfaceRequest
        .builder
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(networkCardIndex)(_.networkCardIndex(_))
        .build

    def attachVolumeRequest(
      device: Option[String] = None,
      instanceId: Option[String] = None,
      volumeId: Option[String] = None
    ): AttachVolumeRequest =
      AttachVolumeRequest
        .builder
        .ifSome(device)(_.device(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def attachVpnGatewayRequest(
      vpcId: Option[String] = None,
      vpnGatewayId: Option[String] = None
    ): AttachVpnGatewayRequest =
      AttachVpnGatewayRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpnGatewayId)(_.vpnGatewayId(_))
        .build

    def attributeBooleanValue(
      value: Option[Boolean] = None
    ): AttributeBooleanValue =
      AttributeBooleanValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def attributeValue(
      value: Option[String] = None
    ): AttributeValue =
      AttributeValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def authorizationRule(
      clientVpnEndpointId: Option[String] = None,
      description: Option[String] = None,
      groupId: Option[String] = None,
      accessAll: Option[Boolean] = None,
      destinationCidr: Option[String] = None,
      status: Option[ClientVpnAuthorizationRuleStatus] = None
    ): AuthorizationRule =
      AuthorizationRule
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(description)(_.description(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(accessAll)(_.accessAll(_))
        .ifSome(destinationCidr)(_.destinationCidr(_))
        .ifSome(status)(_.status(_))
        .build

    def authorizeClientVpnIngressRequest(
      clientVpnEndpointId: Option[String] = None,
      targetNetworkCidr: Option[String] = None,
      accessGroupId: Option[String] = None,
      authorizeAllGroups: Option[Boolean] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None
    ): AuthorizeClientVpnIngressRequest =
      AuthorizeClientVpnIngressRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(targetNetworkCidr)(_.targetNetworkCidr(_))
        .ifSome(accessGroupId)(_.accessGroupId(_))
        .ifSome(authorizeAllGroups)(_.authorizeAllGroups(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def authorizeSecurityGroupEgressRequest(
      groupId: Option[String] = None,
      ipPermissions: Option[List[IpPermission]] = None,
      cidrIp: Option[String] = None,
      fromPort: Option[Int] = None,
      ipProtocol: Option[String] = None,
      toPort: Option[Int] = None,
      sourceSecurityGroupName: Option[String] = None,
      sourceSecurityGroupOwnerId: Option[String] = None
    ): AuthorizeSecurityGroupEgressRequest =
      AuthorizeSecurityGroupEgressRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .ifSome(cidrIp)(_.cidrIp(_))
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(ipProtocol)(_.ipProtocol(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(sourceSecurityGroupName)(_.sourceSecurityGroupName(_))
        .ifSome(sourceSecurityGroupOwnerId)(_.sourceSecurityGroupOwnerId(_))
        .build

    def authorizeSecurityGroupIngressRequest(
      cidrIp: Option[String] = None,
      fromPort: Option[Int] = None,
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      ipPermissions: Option[List[IpPermission]] = None,
      ipProtocol: Option[String] = None,
      sourceSecurityGroupName: Option[String] = None,
      sourceSecurityGroupOwnerId: Option[String] = None,
      toPort: Option[Int] = None
    ): AuthorizeSecurityGroupIngressRequest =
      AuthorizeSecurityGroupIngressRequest
        .builder
        .ifSome(cidrIp)(_.cidrIp(_))
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .ifSome(ipProtocol)(_.ipProtocol(_))
        .ifSome(sourceSecurityGroupName)(_.sourceSecurityGroupName(_))
        .ifSome(sourceSecurityGroupOwnerId)(_.sourceSecurityGroupOwnerId(_))
        .ifSome(toPort)(_.toPort(_))
        .build

    def availabilityZone(
      state: Option[String] = None,
      optInStatus: Option[String] = None,
      messages: Option[List[AvailabilityZoneMessage]] = None,
      regionName: Option[String] = None,
      zoneName: Option[String] = None,
      zoneId: Option[String] = None,
      groupName: Option[String] = None,
      networkBorderGroup: Option[String] = None,
      zoneType: Option[String] = None,
      parentZoneName: Option[String] = None,
      parentZoneId: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(optInStatus)(_.optInStatus(_))
        .ifSome(messages)(_.messages(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(zoneName)(_.zoneName(_))
        .ifSome(zoneId)(_.zoneId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(networkBorderGroup)(_.networkBorderGroup(_))
        .ifSome(zoneType)(_.zoneType(_))
        .ifSome(parentZoneName)(_.parentZoneName(_))
        .ifSome(parentZoneId)(_.parentZoneId(_))
        .build

    def availabilityZoneMessage(
      message: Option[String] = None
    ): AvailabilityZoneMessage =
      AvailabilityZoneMessage
        .builder
        .ifSome(message)(_.message(_))
        .build

    def availableCapacity(
      availableInstanceCapacity: Option[List[InstanceCapacity]] = None,
      availableVCpus: Option[Int] = None
    ): AvailableCapacity =
      AvailableCapacity
        .builder
        .ifSome(availableInstanceCapacity)(_.availableInstanceCapacity(_))
        .ifSome(availableVCpus)(_.availableVCpus(_))
        .build

    def blobAttributeValue(
      value: Option[Blob] = None
    ): BlobAttributeValue =
      BlobAttributeValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def blockDeviceMapping(
      deviceName: Option[String] = None,
      virtualName: Option[String] = None,
      ebs: Option[EbsBlockDevice] = None,
      noDevice: Option[String] = None
    ): BlockDeviceMapping =
      BlockDeviceMapping
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(virtualName)(_.virtualName(_))
        .ifSome(ebs)(_.ebs(_))
        .ifSome(noDevice)(_.noDevice(_))
        .build

    def bundleInstanceRequest(
      instanceId: Option[String] = None,
      storage: Option[Storage] = None
    ): BundleInstanceRequest =
      BundleInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(storage)(_.storage(_))
        .build

    def bundleTask(
      bundleId: Option[String] = None,
      bundleTaskError: Option[BundleTaskError] = None,
      instanceId: Option[String] = None,
      progress: Option[String] = None,
      startTime: Option[DateTime] = None,
      state: Option[String] = None,
      storage: Option[Storage] = None,
      updateTime: Option[DateTime] = None
    ): BundleTask =
      BundleTask
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(bundleTaskError)(_.bundleTaskError(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(state)(_.state(_))
        .ifSome(storage)(_.storage(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def bundleTaskError(
      code: Option[String] = None,
      message: Option[String] = None
    ): BundleTaskError =
      BundleTaskError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def byoipCidr(
      cidr: Option[String] = None,
      description: Option[String] = None,
      statusMessage: Option[String] = None,
      state: Option[String] = None
    ): ByoipCidr =
      ByoipCidr
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(description)(_.description(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(state)(_.state(_))
        .build

    def cancelBundleTaskRequest(
      bundleId: Option[String] = None
    ): CancelBundleTaskRequest =
      CancelBundleTaskRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .build

    def cancelCapacityReservationRequest(
      capacityReservationId: Option[String] = None
    ): CancelCapacityReservationRequest =
      CancelCapacityReservationRequest
        .builder
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .build

    def cancelConversionRequest(
      conversionTaskId: Option[String] = None,
      reasonMessage: Option[String] = None
    ): CancelConversionRequest =
      CancelConversionRequest
        .builder
        .ifSome(conversionTaskId)(_.conversionTaskId(_))
        .ifSome(reasonMessage)(_.reasonMessage(_))
        .build

    def cancelExportTaskRequest(
      exportTaskId: Option[String] = None
    ): CancelExportTaskRequest =
      CancelExportTaskRequest
        .builder
        .ifSome(exportTaskId)(_.exportTaskId(_))
        .build

    def cancelImportTaskRequest(
      cancelReason: Option[String] = None,
      importTaskId: Option[String] = None
    ): CancelImportTaskRequest =
      CancelImportTaskRequest
        .builder
        .ifSome(cancelReason)(_.cancelReason(_))
        .ifSome(importTaskId)(_.importTaskId(_))
        .build

    def cancelReservedInstancesListingRequest(
      reservedInstancesListingId: Option[String] = None
    ): CancelReservedInstancesListingRequest =
      CancelReservedInstancesListingRequest
        .builder
        .ifSome(reservedInstancesListingId)(_.reservedInstancesListingId(_))
        .build

    def cancelSpotFleetRequestsError(
      code: Option[String] = None,
      message: Option[String] = None
    ): CancelSpotFleetRequestsError =
      CancelSpotFleetRequestsError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def cancelSpotFleetRequestsErrorItem(
      error: Option[CancelSpotFleetRequestsError] = None,
      spotFleetRequestId: Option[String] = None
    ): CancelSpotFleetRequestsErrorItem =
      CancelSpotFleetRequestsErrorItem
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .build

    def cancelSpotFleetRequestsRequest(
      spotFleetRequestIds: Option[List[SpotFleetRequestId]] = None,
      terminateInstances: Option[Boolean] = None
    ): CancelSpotFleetRequestsRequest =
      CancelSpotFleetRequestsRequest
        .builder
        .ifSome(spotFleetRequestIds)(_.spotFleetRequestIds(_))
        .ifSome(terminateInstances)(_.terminateInstances(_))
        .build

    def cancelSpotFleetRequestsResponse(
      successfulFleetRequests: Option[List[CancelSpotFleetRequestsSuccessItem]] = None,
      unsuccessfulFleetRequests: Option[List[CancelSpotFleetRequestsErrorItem]] = None
    ): CancelSpotFleetRequestsResponse =
      CancelSpotFleetRequestsResponse
        .builder
        .ifSome(successfulFleetRequests)(_.successfulFleetRequests(_))
        .ifSome(unsuccessfulFleetRequests)(_.unsuccessfulFleetRequests(_))
        .build

    def cancelSpotFleetRequestsSuccessItem(
      currentSpotFleetRequestState: Option[String] = None,
      previousSpotFleetRequestState: Option[String] = None,
      spotFleetRequestId: Option[String] = None
    ): CancelSpotFleetRequestsSuccessItem =
      CancelSpotFleetRequestsSuccessItem
        .builder
        .ifSome(currentSpotFleetRequestState)(_.currentSpotFleetRequestState(_))
        .ifSome(previousSpotFleetRequestState)(_.previousSpotFleetRequestState(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .build

    def cancelSpotInstanceRequestsRequest(
      spotInstanceRequestIds: Option[List[SpotInstanceRequestId]] = None
    ): CancelSpotInstanceRequestsRequest =
      CancelSpotInstanceRequestsRequest
        .builder
        .ifSome(spotInstanceRequestIds)(_.spotInstanceRequestIds(_))
        .build

    def cancelledSpotInstanceRequest(
      spotInstanceRequestId: Option[String] = None,
      state: Option[String] = None
    ): CancelledSpotInstanceRequest =
      CancelledSpotInstanceRequest
        .builder
        .ifSome(spotInstanceRequestId)(_.spotInstanceRequestId(_))
        .ifSome(state)(_.state(_))
        .build

    def capacityReservation(
      capacityReservationId: Option[String] = None,
      ownerId: Option[String] = None,
      capacityReservationArn: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      instanceType: Option[String] = None,
      instancePlatform: Option[String] = None,
      availabilityZone: Option[String] = None,
      tenancy: Option[String] = None,
      totalInstanceCount: Option[Int] = None,
      availableInstanceCount: Option[Int] = None,
      ebsOptimized: Option[Boolean] = None,
      ephemeralStorage: Option[Boolean] = None,
      state: Option[String] = None,
      startDate: Option[MillisecondDateTime] = None,
      endDate: Option[DateTime] = None,
      endDateType: Option[String] = None,
      instanceMatchCriteria: Option[String] = None,
      createDate: Option[DateTime] = None,
      tags: Option[List[Tag]] = None,
      outpostArn: Option[String] = None
    ): CapacityReservation =
      CapacityReservation
        .builder
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(capacityReservationArn)(_.capacityReservationArn(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instancePlatform)(_.instancePlatform(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(totalInstanceCount)(_.totalInstanceCount(_))
        .ifSome(availableInstanceCount)(_.availableInstanceCount(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(ephemeralStorage)(_.ephemeralStorage(_))
        .ifSome(state)(_.state(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(endDateType)(_.endDateType(_))
        .ifSome(instanceMatchCriteria)(_.instanceMatchCriteria(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .build

    def capacityReservationGroup(
      groupArn: Option[String] = None,
      ownerId: Option[String] = None
    ): CapacityReservationGroup =
      CapacityReservationGroup
        .builder
        .ifSome(groupArn)(_.groupArn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .build

    def capacityReservationOptions(
      usageStrategy: Option[String] = None
    ): CapacityReservationOptions =
      CapacityReservationOptions
        .builder
        .ifSome(usageStrategy)(_.usageStrategy(_))
        .build

    def capacityReservationOptionsRequest(
      usageStrategy: Option[String] = None
    ): CapacityReservationOptionsRequest =
      CapacityReservationOptionsRequest
        .builder
        .ifSome(usageStrategy)(_.usageStrategy(_))
        .build

    def capacityReservationSpecification(
      capacityReservationPreference: Option[String] = None,
      capacityReservationTarget: Option[CapacityReservationTarget] = None
    ): CapacityReservationSpecification =
      CapacityReservationSpecification
        .builder
        .ifSome(capacityReservationPreference)(_.capacityReservationPreference(_))
        .ifSome(capacityReservationTarget)(_.capacityReservationTarget(_))
        .build

    def capacityReservationSpecificationResponse(
      capacityReservationPreference: Option[String] = None,
      capacityReservationTarget: Option[CapacityReservationTargetResponse] = None
    ): CapacityReservationSpecificationResponse =
      CapacityReservationSpecificationResponse
        .builder
        .ifSome(capacityReservationPreference)(_.capacityReservationPreference(_))
        .ifSome(capacityReservationTarget)(_.capacityReservationTarget(_))
        .build

    def capacityReservationTarget(
      capacityReservationId: Option[String] = None,
      capacityReservationResourceGroupArn: Option[String] = None
    ): CapacityReservationTarget =
      CapacityReservationTarget
        .builder
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .ifSome(capacityReservationResourceGroupArn)(_.capacityReservationResourceGroupArn(_))
        .build

    def capacityReservationTargetResponse(
      capacityReservationId: Option[String] = None,
      capacityReservationResourceGroupArn: Option[String] = None
    ): CapacityReservationTargetResponse =
      CapacityReservationTargetResponse
        .builder
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .ifSome(capacityReservationResourceGroupArn)(_.capacityReservationResourceGroupArn(_))
        .build

    def carrierGateway(
      carrierGatewayId: Option[String] = None,
      vpcId: Option[String] = None,
      state: Option[String] = None,
      ownerId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CarrierGateway =
      CarrierGateway
        .builder
        .ifSome(carrierGatewayId)(_.carrierGatewayId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(state)(_.state(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def certificateAuthentication(
      clientRootCertificateChain: Option[String] = None
    ): CertificateAuthentication =
      CertificateAuthentication
        .builder
        .ifSome(clientRootCertificateChain)(_.clientRootCertificateChain(_))
        .build

    def certificateAuthenticationRequest(
      clientRootCertificateChainArn: Option[String] = None
    ): CertificateAuthenticationRequest =
      CertificateAuthenticationRequest
        .builder
        .ifSome(clientRootCertificateChainArn)(_.clientRootCertificateChainArn(_))
        .build

    def cidrAuthorizationContext(
      message: Option[String] = None,
      signature: Option[String] = None
    ): CidrAuthorizationContext =
      CidrAuthorizationContext
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(signature)(_.signature(_))
        .build

    def cidrBlock(
      cidrBlock: Option[String] = None
    ): CidrBlock =
      CidrBlock
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .build

    def classicLinkDnsSupport(
      classicLinkDnsSupported: Option[Boolean] = None,
      vpcId: Option[String] = None
    ): ClassicLinkDnsSupport =
      ClassicLinkDnsSupport
        .builder
        .ifSome(classicLinkDnsSupported)(_.classicLinkDnsSupported(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def classicLinkInstance(
      groups: Option[List[GroupIdentifier]] = None,
      instanceId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      vpcId: Option[String] = None
    ): ClassicLinkInstance =
      ClassicLinkInstance
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def classicLoadBalancer(
      name: Option[String] = None
    ): ClassicLoadBalancer =
      ClassicLoadBalancer
        .builder
        .ifSome(name)(_.name(_))
        .build

    def classicLoadBalancersConfig(
      classicLoadBalancers: Option[List[ClassicLoadBalancer]] = None
    ): ClassicLoadBalancersConfig =
      ClassicLoadBalancersConfig
        .builder
        .ifSome(classicLoadBalancers)(_.classicLoadBalancers(_))
        .build

    def clientCertificateRevocationListStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): ClientCertificateRevocationListStatus =
      ClientCertificateRevocationListStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def clientConnectOptions(
      enabled: Option[Boolean] = None,
      lambdaFunctionArn: Option[String] = None
    ): ClientConnectOptions =
      ClientConnectOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .build

    def clientConnectResponseOptions(
      enabled: Option[Boolean] = None,
      lambdaFunctionArn: Option[String] = None,
      status: Option[ClientVpnEndpointAttributeStatus] = None
    ): ClientConnectResponseOptions =
      ClientConnectResponseOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .ifSome(status)(_.status(_))
        .build

    def clientData(
      comment: Option[String] = None,
      uploadEnd: Option[DateTime] = None,
      uploadSize: Option[Double] = None,
      uploadStart: Option[DateTime] = None
    ): ClientData =
      ClientData
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(uploadEnd)(_.uploadEnd(_))
        .ifSome(uploadSize)(_.uploadSize(_))
        .ifSome(uploadStart)(_.uploadStart(_))
        .build

    def clientVpnAuthentication(
      `type`: Option[String] = None,
      activeDirectory: Option[DirectoryServiceAuthentication] = None,
      mutualAuthentication: Option[CertificateAuthentication] = None,
      federatedAuthentication: Option[FederatedAuthentication] = None
    ): ClientVpnAuthentication =
      ClientVpnAuthentication
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(activeDirectory)(_.activeDirectory(_))
        .ifSome(mutualAuthentication)(_.mutualAuthentication(_))
        .ifSome(federatedAuthentication)(_.federatedAuthentication(_))
        .build

    def clientVpnAuthenticationRequest(
      `type`: Option[String] = None,
      activeDirectory: Option[DirectoryServiceAuthenticationRequest] = None,
      mutualAuthentication: Option[CertificateAuthenticationRequest] = None,
      federatedAuthentication: Option[FederatedAuthenticationRequest] = None
    ): ClientVpnAuthenticationRequest =
      ClientVpnAuthenticationRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(activeDirectory)(_.activeDirectory(_))
        .ifSome(mutualAuthentication)(_.mutualAuthentication(_))
        .ifSome(federatedAuthentication)(_.federatedAuthentication(_))
        .build

    def clientVpnAuthorizationRuleStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): ClientVpnAuthorizationRuleStatus =
      ClientVpnAuthorizationRuleStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def clientVpnConnection(
      clientVpnEndpointId: Option[String] = None,
      timestamp: Option[String] = None,
      connectionId: Option[String] = None,
      username: Option[String] = None,
      connectionEstablishedTime: Option[String] = None,
      ingressBytes: Option[String] = None,
      egressBytes: Option[String] = None,
      ingressPackets: Option[String] = None,
      egressPackets: Option[String] = None,
      clientIp: Option[String] = None,
      commonName: Option[String] = None,
      status: Option[ClientVpnConnectionStatus] = None,
      connectionEndTime: Option[String] = None,
      postureComplianceStatuses: Option[List[String]] = None
    ): ClientVpnConnection =
      ClientVpnConnection
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(username)(_.username(_))
        .ifSome(connectionEstablishedTime)(_.connectionEstablishedTime(_))
        .ifSome(ingressBytes)(_.ingressBytes(_))
        .ifSome(egressBytes)(_.egressBytes(_))
        .ifSome(ingressPackets)(_.ingressPackets(_))
        .ifSome(egressPackets)(_.egressPackets(_))
        .ifSome(clientIp)(_.clientIp(_))
        .ifSome(commonName)(_.commonName(_))
        .ifSome(status)(_.status(_))
        .ifSome(connectionEndTime)(_.connectionEndTime(_))
        .ifSome(postureComplianceStatuses)(_.postureComplianceStatuses(_))
        .build

    def clientVpnConnectionStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): ClientVpnConnectionStatus =
      ClientVpnConnectionStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def clientVpnEndpoint(
      clientVpnEndpointId: Option[String] = None,
      description: Option[String] = None,
      status: Option[ClientVpnEndpointStatus] = None,
      creationTime: Option[String] = None,
      deletionTime: Option[String] = None,
      dnsName: Option[String] = None,
      clientCidrBlock: Option[String] = None,
      dnsServers: Option[List[String]] = None,
      splitTunnel: Option[Boolean] = None,
      vpnProtocol: Option[String] = None,
      transportProtocol: Option[String] = None,
      vpnPort: Option[Int] = None,
      associatedTargetNetworks: Option[List[AssociatedTargetNetwork]] = None,
      serverCertificateArn: Option[String] = None,
      authenticationOptions: Option[List[ClientVpnAuthentication]] = None,
      connectionLogOptions: Option[ConnectionLogResponseOptions] = None,
      tags: Option[List[Tag]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      vpcId: Option[String] = None,
      selfServicePortalUrl: Option[String] = None,
      clientConnectOptions: Option[ClientConnectResponseOptions] = None
    ): ClientVpnEndpoint =
      ClientVpnEndpoint
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(deletionTime)(_.deletionTime(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(clientCidrBlock)(_.clientCidrBlock(_))
        .ifSome(dnsServers)(_.dnsServers(_))
        .ifSome(splitTunnel)(_.splitTunnel(_))
        .ifSome(vpnProtocol)(_.vpnProtocol(_))
        .ifSome(transportProtocol)(_.transportProtocol(_))
        .ifSome(vpnPort)(_.vpnPort(_))
        .ifSome(associatedTargetNetworks)(_.associatedTargetNetworks(_))
        .ifSome(serverCertificateArn)(_.serverCertificateArn(_))
        .ifSome(authenticationOptions)(_.authenticationOptions(_))
        .ifSome(connectionLogOptions)(_.connectionLogOptions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(selfServicePortalUrl)(_.selfServicePortalUrl(_))
        .ifSome(clientConnectOptions)(_.clientConnectOptions(_))
        .build

    def clientVpnEndpointAttributeStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): ClientVpnEndpointAttributeStatus =
      ClientVpnEndpointAttributeStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def clientVpnEndpointStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): ClientVpnEndpointStatus =
      ClientVpnEndpointStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def clientVpnRoute(
      clientVpnEndpointId: Option[String] = None,
      destinationCidr: Option[String] = None,
      targetSubnet: Option[String] = None,
      `type`: Option[String] = None,
      origin: Option[String] = None,
      status: Option[ClientVpnRouteStatus] = None,
      description: Option[String] = None
    ): ClientVpnRoute =
      ClientVpnRoute
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(destinationCidr)(_.destinationCidr(_))
        .ifSome(targetSubnet)(_.targetSubnet(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .build

    def clientVpnRouteStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): ClientVpnRouteStatus =
      ClientVpnRouteStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def coipAddressUsage(
      allocationId: Option[String] = None,
      awsAccountId: Option[String] = None,
      awsService: Option[String] = None,
      coIp: Option[String] = None
    ): CoipAddressUsage =
      CoipAddressUsage
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(awsService)(_.awsService(_))
        .ifSome(coIp)(_.coIp(_))
        .build

    def coipPool(
      poolId: Option[String] = None,
      poolCidrs: Option[List[String]] = None,
      localGatewayRouteTableId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      poolArn: Option[String] = None
    ): CoipPool =
      CoipPool
        .builder
        .ifSome(poolId)(_.poolId(_))
        .ifSome(poolCidrs)(_.poolCidrs(_))
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(poolArn)(_.poolArn(_))
        .build

    def confirmProductInstanceRequest(
      instanceId: Option[String] = None,
      productCode: Option[String] = None
    ): ConfirmProductInstanceRequest =
      ConfirmProductInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(productCode)(_.productCode(_))
        .build

    def connectionLogOptions(
      enabled: Option[Boolean] = None,
      cloudwatchLogGroup: Option[String] = None,
      cloudwatchLogStream: Option[String] = None
    ): ConnectionLogOptions =
      ConnectionLogOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(cloudwatchLogGroup)(_.cloudwatchLogGroup(_))
        .ifSome(cloudwatchLogStream)(_.cloudwatchLogStream(_))
        .build

    def connectionLogResponseOptions(
      enabled: Option[Boolean] = None,
      cloudwatchLogGroup: Option[String] = None,
      cloudwatchLogStream: Option[String] = None
    ): ConnectionLogResponseOptions =
      ConnectionLogResponseOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(cloudwatchLogGroup)(_.cloudwatchLogGroup(_))
        .ifSome(cloudwatchLogStream)(_.cloudwatchLogStream(_))
        .build

    def connectionNotification(
      connectionNotificationId: Option[String] = None,
      serviceId: Option[String] = None,
      vpcEndpointId: Option[String] = None,
      connectionNotificationType: Option[String] = None,
      connectionNotificationArn: Option[String] = None,
      connectionEvents: Option[List[String]] = None,
      connectionNotificationState: Option[String] = None
    ): ConnectionNotification =
      ConnectionNotification
        .builder
        .ifSome(connectionNotificationId)(_.connectionNotificationId(_))
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(connectionNotificationType)(_.connectionNotificationType(_))
        .ifSome(connectionNotificationArn)(_.connectionNotificationArn(_))
        .ifSome(connectionEvents)(_.connectionEvents(_))
        .ifSome(connectionNotificationState)(_.connectionNotificationState(_))
        .build

    def conversionTask(
      conversionTaskId: Option[String] = None,
      expirationTime: Option[String] = None,
      importInstance: Option[ImportInstanceTaskDetails] = None,
      importVolume: Option[ImportVolumeTaskDetails] = None,
      state: Option[String] = None,
      statusMessage: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ConversionTask =
      ConversionTask
        .builder
        .ifSome(conversionTaskId)(_.conversionTaskId(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(importInstance)(_.importInstance(_))
        .ifSome(importVolume)(_.importVolume(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(tags)(_.tags(_))
        .build

    def copyFpgaImageRequest(
      sourceFpgaImageId: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      sourceRegion: Option[String] = None,
      clientToken: Option[String] = None
    ): CopyFpgaImageRequest =
      CopyFpgaImageRequest
        .builder
        .ifSome(sourceFpgaImageId)(_.sourceFpgaImageId(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def copyImageRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      name: Option[String] = None,
      sourceImageId: Option[String] = None,
      sourceRegion: Option[String] = None,
      destinationOutpostArn: Option[String] = None
    ): CopyImageRequest =
      CopyImageRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourceImageId)(_.sourceImageId(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(destinationOutpostArn)(_.destinationOutpostArn(_))
        .build

    def copySnapshotRequest(
      description: Option[String] = None,
      destinationOutpostArn: Option[String] = None,
      destinationRegion: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      presignedUrl: Option[String] = None,
      sourceRegion: Option[String] = None,
      sourceSnapshotId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CopySnapshotRequest =
      CopySnapshotRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(destinationOutpostArn)(_.destinationOutpostArn(_))
        .ifSome(destinationRegion)(_.destinationRegion(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(presignedUrl)(_.presignedUrl(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(sourceSnapshotId)(_.sourceSnapshotId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def cpuOptions(
      coreCount: Option[Int] = None,
      threadsPerCore: Option[Int] = None
    ): CpuOptions =
      CpuOptions
        .builder
        .ifSome(coreCount)(_.coreCount(_))
        .ifSome(threadsPerCore)(_.threadsPerCore(_))
        .build

    def cpuOptionsRequest(
      coreCount: Option[Int] = None,
      threadsPerCore: Option[Int] = None
    ): CpuOptionsRequest =
      CpuOptionsRequest
        .builder
        .ifSome(coreCount)(_.coreCount(_))
        .ifSome(threadsPerCore)(_.threadsPerCore(_))
        .build

    def createCapacityReservationRequest(
      clientToken: Option[String] = None,
      instanceType: Option[String] = None,
      instancePlatform: Option[String] = None,
      availabilityZone: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      tenancy: Option[String] = None,
      instanceCount: Option[Int] = None,
      ebsOptimized: Option[Boolean] = None,
      ephemeralStorage: Option[Boolean] = None,
      endDate: Option[DateTime] = None,
      endDateType: Option[String] = None,
      instanceMatchCriteria: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      outpostArn: Option[String] = None
    ): CreateCapacityReservationRequest =
      CreateCapacityReservationRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instancePlatform)(_.instancePlatform(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(ephemeralStorage)(_.ephemeralStorage(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(endDateType)(_.endDateType(_))
        .ifSome(instanceMatchCriteria)(_.instanceMatchCriteria(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .build

    def createCarrierGatewayRequest(
      vpcId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      clientToken: Option[String] = None
    ): CreateCarrierGatewayRequest =
      CreateCarrierGatewayRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createClientVpnEndpointRequest(
      clientCidrBlock: Option[String] = None,
      serverCertificateArn: Option[String] = None,
      authenticationOptions: Option[List[ClientVpnAuthenticationRequest]] = None,
      connectionLogOptions: Option[ConnectionLogOptions] = None,
      dnsServers: Option[List[String]] = None,
      transportProtocol: Option[String] = None,
      vpnPort: Option[Int] = None,
      description: Option[String] = None,
      splitTunnel: Option[Boolean] = None,
      clientToken: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      vpcId: Option[String] = None,
      selfServicePortal: Option[String] = None,
      clientConnectOptions: Option[ClientConnectOptions] = None
    ): CreateClientVpnEndpointRequest =
      CreateClientVpnEndpointRequest
        .builder
        .ifSome(clientCidrBlock)(_.clientCidrBlock(_))
        .ifSome(serverCertificateArn)(_.serverCertificateArn(_))
        .ifSome(authenticationOptions)(_.authenticationOptions(_))
        .ifSome(connectionLogOptions)(_.connectionLogOptions(_))
        .ifSome(dnsServers)(_.dnsServers(_))
        .ifSome(transportProtocol)(_.transportProtocol(_))
        .ifSome(vpnPort)(_.vpnPort(_))
        .ifSome(description)(_.description(_))
        .ifSome(splitTunnel)(_.splitTunnel(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(selfServicePortal)(_.selfServicePortal(_))
        .ifSome(clientConnectOptions)(_.clientConnectOptions(_))
        .build

    def createClientVpnRouteRequest(
      clientVpnEndpointId: Option[String] = None,
      destinationCidrBlock: Option[String] = None,
      targetVpcSubnetId: Option[String] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateClientVpnRouteRequest =
      CreateClientVpnRouteRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(targetVpcSubnetId)(_.targetVpcSubnetId(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createCustomerGatewayRequest(
      bgpAsn: Option[Int] = None,
      publicIp: Option[String] = None,
      certificateArn: Option[String] = None,
      `type`: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      deviceName: Option[String] = None
    ): CreateCustomerGatewayRequest =
      CreateCustomerGatewayRequest
        .builder
        .ifSome(bgpAsn)(_.bgpAsn(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(deviceName)(_.deviceName(_))
        .build

    def createDefaultSubnetRequest(
      availabilityZone: Option[String] = None
    ): CreateDefaultSubnetRequest =
      CreateDefaultSubnetRequest
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .build

    def createDefaultVpcRequest(

    ): CreateDefaultVpcRequest =
      CreateDefaultVpcRequest
        .builder

        .build

    def createDhcpOptionsRequest(
      dhcpConfigurations: Option[List[NewDhcpConfiguration]] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateDhcpOptionsRequest =
      CreateDhcpOptionsRequest
        .builder
        .ifSome(dhcpConfigurations)(_.dhcpConfigurations(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createEgressOnlyInternetGatewayRequest(
      clientToken: Option[String] = None,
      vpcId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateEgressOnlyInternetGatewayRequest =
      CreateEgressOnlyInternetGatewayRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createFleetError(
      launchTemplateAndOverrides: Option[LaunchTemplateAndOverridesResponse] = None,
      lifecycle: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): CreateFleetError =
      CreateFleetError
        .builder
        .ifSome(launchTemplateAndOverrides)(_.launchTemplateAndOverrides(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def createFleetInstance(
      launchTemplateAndOverrides: Option[LaunchTemplateAndOverridesResponse] = None,
      lifecycle: Option[String] = None,
      instanceIds: Option[List[InstanceId]] = None,
      instanceType: Option[String] = None,
      platform: Option[String] = None
    ): CreateFleetInstance =
      CreateFleetInstance
        .builder
        .ifSome(launchTemplateAndOverrides)(_.launchTemplateAndOverrides(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(platform)(_.platform(_))
        .build

    def createFleetRequest(
      clientToken: Option[String] = None,
      spotOptions: Option[SpotOptionsRequest] = None,
      onDemandOptions: Option[OnDemandOptionsRequest] = None,
      excessCapacityTerminationPolicy: Option[String] = None,
      launchTemplateConfigs: Option[List[FleetLaunchTemplateConfigRequest]] = None,
      targetCapacitySpecification: Option[TargetCapacitySpecificationRequest] = None,
      terminateInstancesWithExpiration: Option[Boolean] = None,
      `type`: Option[String] = None,
      validFrom: Option[DateTime] = None,
      validUntil: Option[DateTime] = None,
      replaceUnhealthyInstances: Option[Boolean] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateFleetRequest =
      CreateFleetRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(spotOptions)(_.spotOptions(_))
        .ifSome(onDemandOptions)(_.onDemandOptions(_))
        .ifSome(excessCapacityTerminationPolicy)(_.excessCapacityTerminationPolicy(_))
        .ifSome(launchTemplateConfigs)(_.launchTemplateConfigs(_))
        .ifSome(targetCapacitySpecification)(_.targetCapacitySpecification(_))
        .ifSome(terminateInstancesWithExpiration)(_.terminateInstancesWithExpiration(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(validFrom)(_.validFrom(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(replaceUnhealthyInstances)(_.replaceUnhealthyInstances(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createFlowLogsRequest(
      clientToken: Option[String] = None,
      deliverLogsPermissionArn: Option[String] = None,
      logGroupName: Option[String] = None,
      resourceIds: Option[List[FlowLogResourceId]] = None,
      resourceType: Option[String] = None,
      trafficType: Option[String] = None,
      logDestinationType: Option[String] = None,
      logDestination: Option[String] = None,
      logFormat: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      maxAggregationInterval: Option[Int] = None
    ): CreateFlowLogsRequest =
      CreateFlowLogsRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(deliverLogsPermissionArn)(_.deliverLogsPermissionArn(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(trafficType)(_.trafficType(_))
        .ifSome(logDestinationType)(_.logDestinationType(_))
        .ifSome(logDestination)(_.logDestination(_))
        .ifSome(logFormat)(_.logFormat(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(maxAggregationInterval)(_.maxAggregationInterval(_))
        .build

    def createFpgaImageRequest(
      inputStorageLocation: Option[StorageLocation] = None,
      logsStorageLocation: Option[StorageLocation] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      clientToken: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateFpgaImageRequest =
      CreateFpgaImageRequest
        .builder
        .ifSome(inputStorageLocation)(_.inputStorageLocation(_))
        .ifSome(logsStorageLocation)(_.logsStorageLocation(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createImageRequest(
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      description: Option[String] = None,
      instanceId: Option[String] = None,
      name: Option[String] = None,
      noReboot: Option[Boolean] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateImageRequest =
      CreateImageRequest
        .builder
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(description)(_.description(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(noReboot)(_.noReboot(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createInstanceExportTaskRequest(
      description: Option[String] = None,
      exportToS3Task: Option[ExportToS3TaskSpecification] = None,
      instanceId: Option[String] = None,
      targetEnvironment: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateInstanceExportTaskRequest =
      CreateInstanceExportTaskRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(exportToS3Task)(_.exportToS3Task(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(targetEnvironment)(_.targetEnvironment(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createInternetGatewayRequest(
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateInternetGatewayRequest =
      CreateInternetGatewayRequest
        .builder
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createKeyPairRequest(
      keyName: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateKeyPairRequest =
      CreateKeyPairRequest
        .builder
        .ifSome(keyName)(_.keyName(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createLaunchTemplateRequest(
      clientToken: Option[String] = None,
      launchTemplateName: Option[String] = None,
      versionDescription: Option[String] = None,
      launchTemplateData: Option[RequestLaunchTemplateData] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateLaunchTemplateRequest =
      CreateLaunchTemplateRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(launchTemplateData)(_.launchTemplateData(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createLaunchTemplateVersionRequest(
      clientToken: Option[String] = None,
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      sourceVersion: Option[String] = None,
      versionDescription: Option[String] = None,
      launchTemplateData: Option[RequestLaunchTemplateData] = None
    ): CreateLaunchTemplateVersionRequest =
      CreateLaunchTemplateVersionRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(launchTemplateData)(_.launchTemplateData(_))
        .build

    def createLocalGatewayRouteRequest(
      destinationCidrBlock: Option[String] = None,
      localGatewayRouteTableId: Option[String] = None,
      localGatewayVirtualInterfaceGroupId: Option[String] = None
    ): CreateLocalGatewayRouteRequest =
      CreateLocalGatewayRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(localGatewayVirtualInterfaceGroupId)(_.localGatewayVirtualInterfaceGroupId(_))
        .build

    def createLocalGatewayRouteTableVpcAssociationRequest(
      localGatewayRouteTableId: Option[String] = None,
      vpcId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateLocalGatewayRouteTableVpcAssociationRequest =
      CreateLocalGatewayRouteTableVpcAssociationRequest
        .builder
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createManagedPrefixListRequest(
      prefixListName: Option[String] = None,
      entries: Option[List[AddPrefixListEntry]] = None,
      maxEntries: Option[Int] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      addressFamily: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateManagedPrefixListRequest =
      CreateManagedPrefixListRequest
        .builder
        .ifSome(prefixListName)(_.prefixListName(_))
        .ifSome(entries)(_.entries(_))
        .ifSome(maxEntries)(_.maxEntries(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createNatGatewayRequest(
      allocationId: Option[String] = None,
      clientToken: Option[String] = None,
      subnetId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      connectivityType: Option[String] = None
    ): CreateNatGatewayRequest =
      CreateNatGatewayRequest
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(connectivityType)(_.connectivityType(_))
        .build

    def createNetworkAclEntryRequest(
      cidrBlock: Option[String] = None,
      egress: Option[Boolean] = None,
      icmpTypeCode: Option[IcmpTypeCode] = None,
      ipv6CidrBlock: Option[String] = None,
      networkAclId: Option[String] = None,
      portRange: Option[PortRange] = None,
      protocol: Option[String] = None,
      ruleAction: Option[String] = None,
      ruleNumber: Option[Int] = None
    ): CreateNetworkAclEntryRequest =
      CreateNetworkAclEntryRequest
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(egress)(_.egress(_))
        .ifSome(icmpTypeCode)(_.icmpTypeCode(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .ifSome(portRange)(_.portRange(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .build

    def createNetworkAclRequest(
      vpcId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateNetworkAclRequest =
      CreateNetworkAclRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createNetworkInsightsPathRequest(
      sourceIp: Option[String] = None,
      destinationIp: Option[String] = None,
      source: Option[String] = None,
      destination: Option[String] = None,
      protocol: Option[String] = None,
      destinationPort: Option[Int] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      clientToken: Option[String] = None
    ): CreateNetworkInsightsPathRequest =
      CreateNetworkInsightsPathRequest
        .builder
        .ifSome(sourceIp)(_.sourceIp(_))
        .ifSome(destinationIp)(_.destinationIp(_))
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(destinationPort)(_.destinationPort(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createNetworkInterfacePermissionRequest(
      networkInterfaceId: Option[String] = None,
      awsAccountId: Option[String] = None,
      awsService: Option[String] = None,
      permission: Option[String] = None
    ): CreateNetworkInterfacePermissionRequest =
      CreateNetworkInterfacePermissionRequest
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(awsService)(_.awsService(_))
        .ifSome(permission)(_.permission(_))
        .build

    def createNetworkInterfaceRequest(
      description: Option[String] = None,
      groups: Option[List[SecurityGroupId]] = None,
      ipv6AddressCount: Option[Int] = None,
      ipv6Addresses: Option[List[InstanceIpv6Address]] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[PrivateIpAddressSpecification]] = None,
      secondaryPrivateIpAddressCount: Option[Int] = None,
      interfaceType: Option[String] = None,
      subnetId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      clientToken: Option[String] = None
    ): CreateNetworkInterfaceRequest =
      CreateNetworkInterfaceRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(ipv6AddressCount)(_.ipv6AddressCount(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(secondaryPrivateIpAddressCount)(_.secondaryPrivateIpAddressCount(_))
        .ifSome(interfaceType)(_.interfaceType(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createPlacementGroupRequest(
      groupName: Option[String] = None,
      strategy: Option[String] = None,
      partitionCount: Option[Int] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreatePlacementGroupRequest =
      CreatePlacementGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(strategy)(_.strategy(_))
        .ifSome(partitionCount)(_.partitionCount(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createReplaceRootVolumeTaskRequest(
      instanceId: Option[String] = None,
      snapshotId: Option[String] = None,
      clientToken: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateReplaceRootVolumeTaskRequest =
      CreateReplaceRootVolumeTaskRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createReservedInstancesListingRequest(
      clientToken: Option[String] = None,
      instanceCount: Option[Int] = None,
      priceSchedules: Option[List[PriceScheduleSpecification]] = None,
      reservedInstancesId: Option[String] = None
    ): CreateReservedInstancesListingRequest =
      CreateReservedInstancesListingRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(priceSchedules)(_.priceSchedules(_))
        .ifSome(reservedInstancesId)(_.reservedInstancesId(_))
        .build

    def createRestoreImageTaskRequest(
      bucket: Option[String] = None,
      objectKey: Option[String] = None,
      name: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateRestoreImageTaskRequest =
      CreateRestoreImageTaskRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(objectKey)(_.objectKey(_))
        .ifSome(name)(_.name(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createRouteRequest(
      destinationCidrBlock: Option[String] = None,
      destinationIpv6CidrBlock: Option[String] = None,
      destinationPrefixListId: Option[String] = None,
      vpcEndpointId: Option[String] = None,
      egressOnlyInternetGatewayId: Option[String] = None,
      gatewayId: Option[String] = None,
      instanceId: Option[String] = None,
      natGatewayId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      localGatewayId: Option[String] = None,
      carrierGatewayId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      routeTableId: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): CreateRouteRequest =
      CreateRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(destinationIpv6CidrBlock)(_.destinationIpv6CidrBlock(_))
        .ifSome(destinationPrefixListId)(_.destinationPrefixListId(_))
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(egressOnlyInternetGatewayId)(_.egressOnlyInternetGatewayId(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(natGatewayId)(_.natGatewayId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(carrierGatewayId)(_.carrierGatewayId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def createRouteTableRequest(
      vpcId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateRouteTableRequest =
      CreateRouteTableRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createSecurityGroupRequest(
      description: Option[String] = None,
      groupName: Option[String] = None,
      vpcId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateSecurityGroupRequest =
      CreateSecurityGroupRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createSnapshotRequest(
      description: Option[String] = None,
      outpostArn: Option[String] = None,
      volumeId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateSnapshotRequest =
      CreateSnapshotRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createSnapshotsRequest(
      description: Option[String] = None,
      instanceSpecification: Option[InstanceSpecification] = None,
      outpostArn: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      copyTagsFromSource: Option[String] = None
    ): CreateSnapshotsRequest =
      CreateSnapshotsRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(instanceSpecification)(_.instanceSpecification(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(copyTagsFromSource)(_.copyTagsFromSource(_))
        .build

    def createSpotDatafeedSubscriptionRequest(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): CreateSpotDatafeedSubscriptionRequest =
      CreateSpotDatafeedSubscriptionRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def createStoreImageTaskRequest(
      imageId: Option[String] = None,
      bucket: Option[String] = None,
      s3ObjectTags: Option[List[S3ObjectTag]] = None
    ): CreateStoreImageTaskRequest =
      CreateStoreImageTaskRequest
        .builder
        .ifSome(imageId)(_.imageId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(s3ObjectTags)(_.s3ObjectTags(_))
        .build

    def createSubnetRequest(
      tagSpecifications: Option[List[TagSpecification]] = None,
      availabilityZone: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      cidrBlock: Option[String] = None,
      ipv6CidrBlock: Option[String] = None,
      outpostArn: Option[String] = None,
      vpcId: Option[String] = None
    ): CreateSubnetRequest =
      CreateSubnetRequest
        .builder
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def createTagsRequest(
      resources: Option[List[TaggableResourceId]] = None,
      tags: Option[List[Tag]] = None
    ): CreateTagsRequest =
      CreateTagsRequest
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTrafficMirrorFilterRequest(
      description: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      clientToken: Option[String] = None
    ): CreateTrafficMirrorFilterRequest =
      CreateTrafficMirrorFilterRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createTrafficMirrorFilterRuleRequest(
      trafficMirrorFilterId: Option[String] = None,
      trafficDirection: Option[String] = None,
      ruleNumber: Option[Int] = None,
      ruleAction: Option[String] = None,
      destinationPortRange: Option[TrafficMirrorPortRangeRequest] = None,
      sourcePortRange: Option[TrafficMirrorPortRangeRequest] = None,
      protocol: Option[Int] = None,
      destinationCidrBlock: Option[String] = None,
      sourceCidrBlock: Option[String] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateTrafficMirrorFilterRuleRequest =
      CreateTrafficMirrorFilterRuleRequest
        .builder
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .ifSome(trafficDirection)(_.trafficDirection(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(destinationPortRange)(_.destinationPortRange(_))
        .ifSome(sourcePortRange)(_.sourcePortRange(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(sourceCidrBlock)(_.sourceCidrBlock(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createTrafficMirrorSessionRequest(
      networkInterfaceId: Option[String] = None,
      trafficMirrorTargetId: Option[String] = None,
      trafficMirrorFilterId: Option[String] = None,
      packetLength: Option[Int] = None,
      sessionNumber: Option[Int] = None,
      virtualNetworkId: Option[Int] = None,
      description: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      clientToken: Option[String] = None
    ): CreateTrafficMirrorSessionRequest =
      CreateTrafficMirrorSessionRequest
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(trafficMirrorTargetId)(_.trafficMirrorTargetId(_))
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .ifSome(packetLength)(_.packetLength(_))
        .ifSome(sessionNumber)(_.sessionNumber(_))
        .ifSome(virtualNetworkId)(_.virtualNetworkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createTrafficMirrorTargetRequest(
      networkInterfaceId: Option[String] = None,
      networkLoadBalancerArn: Option[String] = None,
      description: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      clientToken: Option[String] = None
    ): CreateTrafficMirrorTargetRequest =
      CreateTrafficMirrorTargetRequest
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(networkLoadBalancerArn)(_.networkLoadBalancerArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createTransitGatewayConnectPeerRequest(
      transitGatewayAttachmentId: Option[String] = None,
      transitGatewayAddress: Option[String] = None,
      peerAddress: Option[String] = None,
      bgpOptions: Option[TransitGatewayConnectRequestBgpOptions] = None,
      insideCidrBlocks: Option[List[String]] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateTransitGatewayConnectPeerRequest =
      CreateTransitGatewayConnectPeerRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(transitGatewayAddress)(_.transitGatewayAddress(_))
        .ifSome(peerAddress)(_.peerAddress(_))
        .ifSome(bgpOptions)(_.bgpOptions(_))
        .ifSome(insideCidrBlocks)(_.insideCidrBlocks(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createTransitGatewayConnectRequest(
      transportTransitGatewayAttachmentId: Option[String] = None,
      options: Option[CreateTransitGatewayConnectRequestOptions] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateTransitGatewayConnectRequest =
      CreateTransitGatewayConnectRequest
        .builder
        .ifSome(transportTransitGatewayAttachmentId)(_.transportTransitGatewayAttachmentId(_))
        .ifSome(options)(_.options(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createTransitGatewayConnectRequestOptions(
      protocol: Option[String] = None
    ): CreateTransitGatewayConnectRequestOptions =
      CreateTransitGatewayConnectRequestOptions
        .builder
        .ifSome(protocol)(_.protocol(_))
        .build

    def createTransitGatewayMulticastDomainRequest(
      transitGatewayId: Option[String] = None,
      options: Option[CreateTransitGatewayMulticastDomainRequestOptions] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateTransitGatewayMulticastDomainRequest =
      CreateTransitGatewayMulticastDomainRequest
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(options)(_.options(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createTransitGatewayMulticastDomainRequestOptions(
      igmpv2Support: Option[String] = None,
      staticSourcesSupport: Option[String] = None,
      autoAcceptSharedAssociations: Option[String] = None
    ): CreateTransitGatewayMulticastDomainRequestOptions =
      CreateTransitGatewayMulticastDomainRequestOptions
        .builder
        .ifSome(igmpv2Support)(_.igmpv2Support(_))
        .ifSome(staticSourcesSupport)(_.staticSourcesSupport(_))
        .ifSome(autoAcceptSharedAssociations)(_.autoAcceptSharedAssociations(_))
        .build

    def createTransitGatewayPeeringAttachmentRequest(
      transitGatewayId: Option[String] = None,
      peerTransitGatewayId: Option[String] = None,
      peerAccountId: Option[String] = None,
      peerRegion: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateTransitGatewayPeeringAttachmentRequest =
      CreateTransitGatewayPeeringAttachmentRequest
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(peerTransitGatewayId)(_.peerTransitGatewayId(_))
        .ifSome(peerAccountId)(_.peerAccountId(_))
        .ifSome(peerRegion)(_.peerRegion(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createTransitGatewayPrefixListReferenceRequest(
      transitGatewayRouteTableId: Option[String] = None,
      prefixListId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      blackhole: Option[Boolean] = None
    ): CreateTransitGatewayPrefixListReferenceRequest =
      CreateTransitGatewayPrefixListReferenceRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(blackhole)(_.blackhole(_))
        .build

    def createTransitGatewayRequest(
      description: Option[String] = None,
      options: Option[TransitGatewayRequestOptions] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateTransitGatewayRequest =
      CreateTransitGatewayRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(options)(_.options(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createTransitGatewayRouteRequest(
      destinationCidrBlock: Option[String] = None,
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      blackhole: Option[Boolean] = None
    ): CreateTransitGatewayRouteRequest =
      CreateTransitGatewayRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(blackhole)(_.blackhole(_))
        .build

    def createTransitGatewayRouteTableRequest(
      transitGatewayId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateTransitGatewayRouteTableRequest =
      CreateTransitGatewayRouteTableRequest
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createTransitGatewayVpcAttachmentRequest(
      transitGatewayId: Option[String] = None,
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      options: Option[CreateTransitGatewayVpcAttachmentRequestOptions] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateTransitGatewayVpcAttachmentRequest =
      CreateTransitGatewayVpcAttachmentRequest
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(options)(_.options(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createTransitGatewayVpcAttachmentRequestOptions(
      dnsSupport: Option[String] = None,
      ipv6Support: Option[String] = None,
      applianceModeSupport: Option[String] = None
    ): CreateTransitGatewayVpcAttachmentRequestOptions =
      CreateTransitGatewayVpcAttachmentRequestOptions
        .builder
        .ifSome(dnsSupport)(_.dnsSupport(_))
        .ifSome(ipv6Support)(_.ipv6Support(_))
        .ifSome(applianceModeSupport)(_.applianceModeSupport(_))
        .build

    def createVolumePermission(
      group: Option[String] = None,
      userId: Option[String] = None
    ): CreateVolumePermission =
      CreateVolumePermission
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(userId)(_.userId(_))
        .build

    def createVolumePermissionModifications(
      add: Option[List[CreateVolumePermission]] = None,
      remove: Option[List[CreateVolumePermission]] = None
    ): CreateVolumePermissionModifications =
      CreateVolumePermissionModifications
        .builder
        .ifSome(add)(_.add(_))
        .ifSome(remove)(_.remove(_))
        .build

    def createVolumeRequest(
      availabilityZone: Option[String] = None,
      encrypted: Option[Boolean] = None,
      iops: Option[Int] = None,
      kmsKeyId: Option[String] = None,
      outpostArn: Option[String] = None,
      size: Option[Int] = None,
      snapshotId: Option[String] = None,
      volumeType: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      multiAttachEnabled: Option[Boolean] = None,
      throughput: Option[Int] = None
    ): CreateVolumeRequest =
      CreateVolumeRequest
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(size)(_.size(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(multiAttachEnabled)(_.multiAttachEnabled(_))
        .ifSome(throughput)(_.throughput(_))
        .build

    def createVpcEndpointConnectionNotificationRequest(
      serviceId: Option[String] = None,
      vpcEndpointId: Option[String] = None,
      connectionNotificationArn: Option[String] = None,
      connectionEvents: Option[List[String]] = None,
      clientToken: Option[String] = None
    ): CreateVpcEndpointConnectionNotificationRequest =
      CreateVpcEndpointConnectionNotificationRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(connectionNotificationArn)(_.connectionNotificationArn(_))
        .ifSome(connectionEvents)(_.connectionEvents(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createVpcEndpointRequest(
      vpcEndpointType: Option[String] = None,
      vpcId: Option[String] = None,
      serviceName: Option[String] = None,
      policyDocument: Option[String] = None,
      routeTableIds: Option[List[RouteTableId]] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      clientToken: Option[String] = None,
      privateDnsEnabled: Option[Boolean] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateVpcEndpointRequest =
      CreateVpcEndpointRequest
        .builder
        .ifSome(vpcEndpointType)(_.vpcEndpointType(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(routeTableIds)(_.routeTableIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(privateDnsEnabled)(_.privateDnsEnabled(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createVpcEndpointServiceConfigurationRequest(
      acceptanceRequired: Option[Boolean] = None,
      privateDnsName: Option[String] = None,
      networkLoadBalancerArns: Option[List[String]] = None,
      gatewayLoadBalancerArns: Option[List[String]] = None,
      clientToken: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateVpcEndpointServiceConfigurationRequest =
      CreateVpcEndpointServiceConfigurationRequest
        .builder
        .ifSome(acceptanceRequired)(_.acceptanceRequired(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(networkLoadBalancerArns)(_.networkLoadBalancerArns(_))
        .ifSome(gatewayLoadBalancerArns)(_.gatewayLoadBalancerArns(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createVpcPeeringConnectionRequest(
      peerOwnerId: Option[String] = None,
      peerVpcId: Option[String] = None,
      vpcId: Option[String] = None,
      peerRegion: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateVpcPeeringConnectionRequest =
      CreateVpcPeeringConnectionRequest
        .builder
        .ifSome(peerOwnerId)(_.peerOwnerId(_))
        .ifSome(peerVpcId)(_.peerVpcId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(peerRegion)(_.peerRegion(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createVpcRequest(
      cidrBlock: Option[String] = None,
      amazonProvidedIpv6CidrBlock: Option[Boolean] = None,
      ipv6Pool: Option[String] = None,
      ipv6CidrBlock: Option[String] = None,
      instanceTenancy: Option[String] = None,
      ipv6CidrBlockNetworkBorderGroup: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateVpcRequest =
      CreateVpcRequest
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(amazonProvidedIpv6CidrBlock)(_.amazonProvidedIpv6CidrBlock(_))
        .ifSome(ipv6Pool)(_.ipv6Pool(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(instanceTenancy)(_.instanceTenancy(_))
        .ifSome(ipv6CidrBlockNetworkBorderGroup)(_.ipv6CidrBlockNetworkBorderGroup(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createVpnConnectionRequest(
      customerGatewayId: Option[String] = None,
      `type`: Option[String] = None,
      vpnGatewayId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      options: Option[VpnConnectionOptionsSpecification] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): CreateVpnConnectionRequest =
      CreateVpnConnectionRequest
        .builder
        .ifSome(customerGatewayId)(_.customerGatewayId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vpnGatewayId)(_.vpnGatewayId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(options)(_.options(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def createVpnConnectionRouteRequest(
      destinationCidrBlock: Option[String] = None,
      vpnConnectionId: Option[String] = None
    ): CreateVpnConnectionRouteRequest =
      CreateVpnConnectionRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .build

    def createVpnGatewayRequest(
      availabilityZone: Option[String] = None,
      `type`: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      amazonSideAsn: Option[Long] = None
    ): CreateVpnGatewayRequest =
      CreateVpnGatewayRequest
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(amazonSideAsn)(_.amazonSideAsn(_))
        .build

    def creditSpecification(
      cpuCredits: Option[String] = None
    ): CreditSpecification =
      CreditSpecification
        .builder
        .ifSome(cpuCredits)(_.cpuCredits(_))
        .build

    def creditSpecificationRequest(
      cpuCredits: Option[String] = None
    ): CreditSpecificationRequest =
      CreditSpecificationRequest
        .builder
        .ifSome(cpuCredits)(_.cpuCredits(_))
        .build

    def customerGateway(
      bgpAsn: Option[String] = None,
      customerGatewayId: Option[String] = None,
      ipAddress: Option[String] = None,
      certificateArn: Option[String] = None,
      state: Option[String] = None,
      `type`: Option[String] = None,
      deviceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CustomerGateway =
      CustomerGateway
        .builder
        .ifSome(bgpAsn)(_.bgpAsn(_))
        .ifSome(customerGatewayId)(_.customerGatewayId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteCarrierGatewayRequest(
      carrierGatewayId: Option[String] = None
    ): DeleteCarrierGatewayRequest =
      DeleteCarrierGatewayRequest
        .builder
        .ifSome(carrierGatewayId)(_.carrierGatewayId(_))
        .build

    def deleteClientVpnEndpointRequest(
      clientVpnEndpointId: Option[String] = None
    ): DeleteClientVpnEndpointRequest =
      DeleteClientVpnEndpointRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .build

    def deleteClientVpnRouteRequest(
      clientVpnEndpointId: Option[String] = None,
      targetVpcSubnetId: Option[String] = None,
      destinationCidrBlock: Option[String] = None
    ): DeleteClientVpnRouteRequest =
      DeleteClientVpnRouteRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(targetVpcSubnetId)(_.targetVpcSubnetId(_))
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .build

    def deleteCustomerGatewayRequest(
      customerGatewayId: Option[String] = None
    ): DeleteCustomerGatewayRequest =
      DeleteCustomerGatewayRequest
        .builder
        .ifSome(customerGatewayId)(_.customerGatewayId(_))
        .build

    def deleteDhcpOptionsRequest(
      dhcpOptionsId: Option[String] = None
    ): DeleteDhcpOptionsRequest =
      DeleteDhcpOptionsRequest
        .builder
        .ifSome(dhcpOptionsId)(_.dhcpOptionsId(_))
        .build

    def deleteEgressOnlyInternetGatewayRequest(
      egressOnlyInternetGatewayId: Option[String] = None
    ): DeleteEgressOnlyInternetGatewayRequest =
      DeleteEgressOnlyInternetGatewayRequest
        .builder
        .ifSome(egressOnlyInternetGatewayId)(_.egressOnlyInternetGatewayId(_))
        .build

    def deleteFleetError(
      code: Option[String] = None,
      message: Option[String] = None
    ): DeleteFleetError =
      DeleteFleetError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def deleteFleetErrorItem(
      error: Option[DeleteFleetError] = None,
      fleetId: Option[String] = None
    ): DeleteFleetErrorItem =
      DeleteFleetErrorItem
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def deleteFleetSuccessItem(
      currentFleetState: Option[String] = None,
      previousFleetState: Option[String] = None,
      fleetId: Option[String] = None
    ): DeleteFleetSuccessItem =
      DeleteFleetSuccessItem
        .builder
        .ifSome(currentFleetState)(_.currentFleetState(_))
        .ifSome(previousFleetState)(_.previousFleetState(_))
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def deleteFleetsRequest(
      fleetIds: Option[List[FleetId]] = None,
      terminateInstances: Option[Boolean] = None
    ): DeleteFleetsRequest =
      DeleteFleetsRequest
        .builder
        .ifSome(fleetIds)(_.fleetIds(_))
        .ifSome(terminateInstances)(_.terminateInstances(_))
        .build

    def deleteFlowLogsRequest(
      flowLogIds: Option[List[VpcFlowLogId]] = None
    ): DeleteFlowLogsRequest =
      DeleteFlowLogsRequest
        .builder
        .ifSome(flowLogIds)(_.flowLogIds(_))
        .build

    def deleteFpgaImageRequest(
      fpgaImageId: Option[String] = None
    ): DeleteFpgaImageRequest =
      DeleteFpgaImageRequest
        .builder
        .ifSome(fpgaImageId)(_.fpgaImageId(_))
        .build

    def deleteInternetGatewayRequest(
      internetGatewayId: Option[String] = None
    ): DeleteInternetGatewayRequest =
      DeleteInternetGatewayRequest
        .builder
        .ifSome(internetGatewayId)(_.internetGatewayId(_))
        .build

    def deleteKeyPairRequest(
      keyName: Option[String] = None,
      keyPairId: Option[String] = None
    ): DeleteKeyPairRequest =
      DeleteKeyPairRequest
        .builder
        .ifSome(keyName)(_.keyName(_))
        .ifSome(keyPairId)(_.keyPairId(_))
        .build

    def deleteLaunchTemplateRequest(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None
    ): DeleteLaunchTemplateRequest =
      DeleteLaunchTemplateRequest
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .build

    def deleteLaunchTemplateVersionsRequest(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      versions: Option[List[String]] = None
    ): DeleteLaunchTemplateVersionsRequest =
      DeleteLaunchTemplateVersionsRequest
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(versions)(_.versions(_))
        .build

    def deleteLaunchTemplateVersionsResponseErrorItem(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      versionNumber: Option[Long] = None,
      responseError: Option[ResponseError] = None
    ): DeleteLaunchTemplateVersionsResponseErrorItem =
      DeleteLaunchTemplateVersionsResponseErrorItem
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(responseError)(_.responseError(_))
        .build

    def deleteLaunchTemplateVersionsResponseSuccessItem(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      versionNumber: Option[Long] = None
    ): DeleteLaunchTemplateVersionsResponseSuccessItem =
      DeleteLaunchTemplateVersionsResponseSuccessItem
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def deleteLocalGatewayRouteRequest(
      destinationCidrBlock: Option[String] = None,
      localGatewayRouteTableId: Option[String] = None
    ): DeleteLocalGatewayRouteRequest =
      DeleteLocalGatewayRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .build

    def deleteLocalGatewayRouteTableVpcAssociationRequest(
      localGatewayRouteTableVpcAssociationId: Option[String] = None
    ): DeleteLocalGatewayRouteTableVpcAssociationRequest =
      DeleteLocalGatewayRouteTableVpcAssociationRequest
        .builder
        .ifSome(localGatewayRouteTableVpcAssociationId)(_.localGatewayRouteTableVpcAssociationId(_))
        .build

    def deleteManagedPrefixListRequest(
      prefixListId: Option[String] = None
    ): DeleteManagedPrefixListRequest =
      DeleteManagedPrefixListRequest
        .builder
        .ifSome(prefixListId)(_.prefixListId(_))
        .build

    def deleteNatGatewayRequest(
      natGatewayId: Option[String] = None
    ): DeleteNatGatewayRequest =
      DeleteNatGatewayRequest
        .builder
        .ifSome(natGatewayId)(_.natGatewayId(_))
        .build

    def deleteNetworkAclEntryRequest(
      egress: Option[Boolean] = None,
      networkAclId: Option[String] = None,
      ruleNumber: Option[Int] = None
    ): DeleteNetworkAclEntryRequest =
      DeleteNetworkAclEntryRequest
        .builder
        .ifSome(egress)(_.egress(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .build

    def deleteNetworkAclRequest(
      networkAclId: Option[String] = None
    ): DeleteNetworkAclRequest =
      DeleteNetworkAclRequest
        .builder
        .ifSome(networkAclId)(_.networkAclId(_))
        .build

    def deleteNetworkInsightsAnalysisRequest(
      networkInsightsAnalysisId: Option[String] = None
    ): DeleteNetworkInsightsAnalysisRequest =
      DeleteNetworkInsightsAnalysisRequest
        .builder
        .ifSome(networkInsightsAnalysisId)(_.networkInsightsAnalysisId(_))
        .build

    def deleteNetworkInsightsPathRequest(
      networkInsightsPathId: Option[String] = None
    ): DeleteNetworkInsightsPathRequest =
      DeleteNetworkInsightsPathRequest
        .builder
        .ifSome(networkInsightsPathId)(_.networkInsightsPathId(_))
        .build

    def deleteNetworkInterfacePermissionRequest(
      networkInterfacePermissionId: Option[String] = None,
      force: Option[Boolean] = None
    ): DeleteNetworkInterfacePermissionRequest =
      DeleteNetworkInterfacePermissionRequest
        .builder
        .ifSome(networkInterfacePermissionId)(_.networkInterfacePermissionId(_))
        .ifSome(force)(_.force(_))
        .build

    def deleteNetworkInterfaceRequest(
      networkInterfaceId: Option[String] = None
    ): DeleteNetworkInterfaceRequest =
      DeleteNetworkInterfaceRequest
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .build

    def deletePlacementGroupRequest(
      groupName: Option[String] = None
    ): DeletePlacementGroupRequest =
      DeletePlacementGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .build

    def deleteQueuedReservedInstancesError(
      code: Option[String] = None,
      message: Option[String] = None
    ): DeleteQueuedReservedInstancesError =
      DeleteQueuedReservedInstancesError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def deleteQueuedReservedInstancesRequest(
      reservedInstancesIds: Option[List[ReservationId]] = None
    ): DeleteQueuedReservedInstancesRequest =
      DeleteQueuedReservedInstancesRequest
        .builder
        .ifSome(reservedInstancesIds)(_.reservedInstancesIds(_))
        .build

    def deleteRouteRequest(
      destinationCidrBlock: Option[String] = None,
      destinationIpv6CidrBlock: Option[String] = None,
      destinationPrefixListId: Option[String] = None,
      routeTableId: Option[String] = None
    ): DeleteRouteRequest =
      DeleteRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(destinationIpv6CidrBlock)(_.destinationIpv6CidrBlock(_))
        .ifSome(destinationPrefixListId)(_.destinationPrefixListId(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .build

    def deleteRouteTableRequest(
      routeTableId: Option[String] = None
    ): DeleteRouteTableRequest =
      DeleteRouteTableRequest
        .builder
        .ifSome(routeTableId)(_.routeTableId(_))
        .build

    def deleteSecurityGroupRequest(
      groupId: Option[String] = None,
      groupName: Option[String] = None
    ): DeleteSecurityGroupRequest =
      DeleteSecurityGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def deleteSnapshotRequest(
      snapshotId: Option[String] = None
    ): DeleteSnapshotRequest =
      DeleteSnapshotRequest
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .build

    def deleteSpotDatafeedSubscriptionRequest(

    ): DeleteSpotDatafeedSubscriptionRequest =
      DeleteSpotDatafeedSubscriptionRequest
        .builder

        .build

    def deleteSubnetRequest(
      subnetId: Option[String] = None
    ): DeleteSubnetRequest =
      DeleteSubnetRequest
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def deleteTagsRequest(
      resources: Option[List[TaggableResourceId]] = None,
      tags: Option[List[Tag]] = None
    ): DeleteTagsRequest =
      DeleteTagsRequest
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteTrafficMirrorFilterRequest(
      trafficMirrorFilterId: Option[String] = None
    ): DeleteTrafficMirrorFilterRequest =
      DeleteTrafficMirrorFilterRequest
        .builder
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .build

    def deleteTrafficMirrorFilterRuleRequest(
      trafficMirrorFilterRuleId: Option[String] = None
    ): DeleteTrafficMirrorFilterRuleRequest =
      DeleteTrafficMirrorFilterRuleRequest
        .builder
        .ifSome(trafficMirrorFilterRuleId)(_.trafficMirrorFilterRuleId(_))
        .build

    def deleteTrafficMirrorSessionRequest(
      trafficMirrorSessionId: Option[String] = None
    ): DeleteTrafficMirrorSessionRequest =
      DeleteTrafficMirrorSessionRequest
        .builder
        .ifSome(trafficMirrorSessionId)(_.trafficMirrorSessionId(_))
        .build

    def deleteTrafficMirrorTargetRequest(
      trafficMirrorTargetId: Option[String] = None
    ): DeleteTrafficMirrorTargetRequest =
      DeleteTrafficMirrorTargetRequest
        .builder
        .ifSome(trafficMirrorTargetId)(_.trafficMirrorTargetId(_))
        .build

    def deleteTransitGatewayConnectPeerRequest(
      transitGatewayConnectPeerId: Option[String] = None
    ): DeleteTransitGatewayConnectPeerRequest =
      DeleteTransitGatewayConnectPeerRequest
        .builder
        .ifSome(transitGatewayConnectPeerId)(_.transitGatewayConnectPeerId(_))
        .build

    def deleteTransitGatewayConnectRequest(
      transitGatewayAttachmentId: Option[String] = None
    ): DeleteTransitGatewayConnectRequest =
      DeleteTransitGatewayConnectRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def deleteTransitGatewayMulticastDomainRequest(
      transitGatewayMulticastDomainId: Option[String] = None
    ): DeleteTransitGatewayMulticastDomainRequest =
      DeleteTransitGatewayMulticastDomainRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .build

    def deleteTransitGatewayPeeringAttachmentRequest(
      transitGatewayAttachmentId: Option[String] = None
    ): DeleteTransitGatewayPeeringAttachmentRequest =
      DeleteTransitGatewayPeeringAttachmentRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def deleteTransitGatewayPrefixListReferenceRequest(
      transitGatewayRouteTableId: Option[String] = None,
      prefixListId: Option[String] = None
    ): DeleteTransitGatewayPrefixListReferenceRequest =
      DeleteTransitGatewayPrefixListReferenceRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .build

    def deleteTransitGatewayRequest(
      transitGatewayId: Option[String] = None
    ): DeleteTransitGatewayRequest =
      DeleteTransitGatewayRequest
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .build

    def deleteTransitGatewayRouteRequest(
      transitGatewayRouteTableId: Option[String] = None,
      destinationCidrBlock: Option[String] = None
    ): DeleteTransitGatewayRouteRequest =
      DeleteTransitGatewayRouteRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .build

    def deleteTransitGatewayRouteTableRequest(
      transitGatewayRouteTableId: Option[String] = None
    ): DeleteTransitGatewayRouteTableRequest =
      DeleteTransitGatewayRouteTableRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .build

    def deleteTransitGatewayVpcAttachmentRequest(
      transitGatewayAttachmentId: Option[String] = None
    ): DeleteTransitGatewayVpcAttachmentRequest =
      DeleteTransitGatewayVpcAttachmentRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def deleteVolumeRequest(
      volumeId: Option[String] = None
    ): DeleteVolumeRequest =
      DeleteVolumeRequest
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def deleteVpcEndpointConnectionNotificationsRequest(
      connectionNotificationIds: Option[List[ConnectionNotificationId]] = None
    ): DeleteVpcEndpointConnectionNotificationsRequest =
      DeleteVpcEndpointConnectionNotificationsRequest
        .builder
        .ifSome(connectionNotificationIds)(_.connectionNotificationIds(_))
        .build

    def deleteVpcEndpointServiceConfigurationsRequest(
      serviceIds: Option[List[VpcEndpointServiceId]] = None
    ): DeleteVpcEndpointServiceConfigurationsRequest =
      DeleteVpcEndpointServiceConfigurationsRequest
        .builder
        .ifSome(serviceIds)(_.serviceIds(_))
        .build

    def deleteVpcEndpointsRequest(
      vpcEndpointIds: Option[List[VpcEndpointId]] = None
    ): DeleteVpcEndpointsRequest =
      DeleteVpcEndpointsRequest
        .builder
        .ifSome(vpcEndpointIds)(_.vpcEndpointIds(_))
        .build

    def deleteVpcPeeringConnectionRequest(
      vpcPeeringConnectionId: Option[String] = None
    ): DeleteVpcPeeringConnectionRequest =
      DeleteVpcPeeringConnectionRequest
        .builder
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def deleteVpcRequest(
      vpcId: Option[String] = None
    ): DeleteVpcRequest =
      DeleteVpcRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def deleteVpnConnectionRequest(
      vpnConnectionId: Option[String] = None
    ): DeleteVpnConnectionRequest =
      DeleteVpnConnectionRequest
        .builder
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .build

    def deleteVpnConnectionRouteRequest(
      destinationCidrBlock: Option[String] = None,
      vpnConnectionId: Option[String] = None
    ): DeleteVpnConnectionRouteRequest =
      DeleteVpnConnectionRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .build

    def deleteVpnGatewayRequest(
      vpnGatewayId: Option[String] = None
    ): DeleteVpnGatewayRequest =
      DeleteVpnGatewayRequest
        .builder
        .ifSome(vpnGatewayId)(_.vpnGatewayId(_))
        .build

    def deprovisionByoipCidrRequest(
      cidr: Option[String] = None
    ): DeprovisionByoipCidrRequest =
      DeprovisionByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def deregisterImageRequest(
      imageId: Option[String] = None
    ): DeregisterImageRequest =
      DeregisterImageRequest
        .builder
        .ifSome(imageId)(_.imageId(_))
        .build

    def deregisterInstanceEventNotificationAttributesRequest(
      instanceTagAttribute: Option[DeregisterInstanceTagAttributeRequest] = None
    ): DeregisterInstanceEventNotificationAttributesRequest =
      DeregisterInstanceEventNotificationAttributesRequest
        .builder
        .ifSome(instanceTagAttribute)(_.instanceTagAttribute(_))
        .build

    def deregisterInstanceTagAttributeRequest(
      includeAllTagsOfInstance: Option[Boolean] = None,
      instanceTagKeys: Option[List[String]] = None
    ): DeregisterInstanceTagAttributeRequest =
      DeregisterInstanceTagAttributeRequest
        .builder
        .ifSome(includeAllTagsOfInstance)(_.includeAllTagsOfInstance(_))
        .ifSome(instanceTagKeys)(_.instanceTagKeys(_))
        .build

    def deregisterTransitGatewayMulticastGroupMembersRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      groupIpAddress: Option[String] = None,
      networkInterfaceIds: Option[List[NetworkInterfaceId]] = None
    ): DeregisterTransitGatewayMulticastGroupMembersRequest =
      DeregisterTransitGatewayMulticastGroupMembersRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .build

    def deregisterTransitGatewayMulticastGroupSourcesRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      groupIpAddress: Option[String] = None,
      networkInterfaceIds: Option[List[NetworkInterfaceId]] = None
    ): DeregisterTransitGatewayMulticastGroupSourcesRequest =
      DeregisterTransitGatewayMulticastGroupSourcesRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .build

    def describeAccountAttributesRequest(
      attributeNames: Option[List[AccountAttributeName]] = None
    ): DescribeAccountAttributesRequest =
      DescribeAccountAttributesRequest
        .builder
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def describeAddressesAttributeRequest(
      allocationIds: Option[List[AllocationId]] = None,
      attribute: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeAddressesAttributeRequest =
      DescribeAddressesAttributeRequest
        .builder
        .ifSome(allocationIds)(_.allocationIds(_))
        .ifSome(attribute)(_.attribute(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeAddressesRequest(
      filters: Option[List[Filter]] = None,
      publicIps: Option[List[String]] = None,
      allocationIds: Option[List[AllocationId]] = None
    ): DescribeAddressesRequest =
      DescribeAddressesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(publicIps)(_.publicIps(_))
        .ifSome(allocationIds)(_.allocationIds(_))
        .build

    def describeAggregateIdFormatRequest(

    ): DescribeAggregateIdFormatRequest =
      DescribeAggregateIdFormatRequest
        .builder

        .build

    def describeAvailabilityZonesRequest(
      filters: Option[List[Filter]] = None,
      zoneNames: Option[List[String]] = None,
      zoneIds: Option[List[String]] = None,
      allAvailabilityZones: Option[Boolean] = None
    ): DescribeAvailabilityZonesRequest =
      DescribeAvailabilityZonesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(zoneNames)(_.zoneNames(_))
        .ifSome(zoneIds)(_.zoneIds(_))
        .ifSome(allAvailabilityZones)(_.allAvailabilityZones(_))
        .build

    def describeBundleTasksRequest(
      bundleIds: Option[List[BundleId]] = None,
      filters: Option[List[Filter]] = None
    ): DescribeBundleTasksRequest =
      DescribeBundleTasksRequest
        .builder
        .ifSome(bundleIds)(_.bundleIds(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeByoipCidrsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeByoipCidrsRequest =
      DescribeByoipCidrsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeCapacityReservationsRequest(
      capacityReservationIds: Option[List[CapacityReservationId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): DescribeCapacityReservationsRequest =
      DescribeCapacityReservationsRequest
        .builder
        .ifSome(capacityReservationIds)(_.capacityReservationIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeCarrierGatewaysRequest(
      carrierGatewayIds: Option[List[CarrierGatewayId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeCarrierGatewaysRequest =
      DescribeCarrierGatewaysRequest
        .builder
        .ifSome(carrierGatewayIds)(_.carrierGatewayIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClassicLinkInstancesRequest(
      filters: Option[List[Filter]] = None,
      instanceIds: Option[List[InstanceId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeClassicLinkInstancesRequest =
      DescribeClassicLinkInstancesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClientVpnAuthorizationRulesRequest(
      clientVpnEndpointId: Option[String] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None
    ): DescribeClientVpnAuthorizationRulesRequest =
      DescribeClientVpnAuthorizationRulesRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeClientVpnConnectionsRequest(
      clientVpnEndpointId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeClientVpnConnectionsRequest =
      DescribeClientVpnConnectionsRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeClientVpnEndpointsRequest(
      clientVpnEndpointIds: Option[List[ClientVpnEndpointId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeClientVpnEndpointsRequest =
      DescribeClientVpnEndpointsRequest
        .builder
        .ifSome(clientVpnEndpointIds)(_.clientVpnEndpointIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeClientVpnRoutesRequest(
      clientVpnEndpointId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeClientVpnRoutesRequest =
      DescribeClientVpnRoutesRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClientVpnTargetNetworksRequest(
      clientVpnEndpointId: Option[String] = None,
      associationIds: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeClientVpnTargetNetworksRequest =
      DescribeClientVpnTargetNetworksRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(associationIds)(_.associationIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeCoipPoolsRequest(
      poolIds: Option[List[CoipPoolId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeCoipPoolsRequest =
      DescribeCoipPoolsRequest
        .builder
        .ifSome(poolIds)(_.poolIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConversionTasksRequest(
      conversionTaskIds: Option[List[ConversionTaskId]] = None
    ): DescribeConversionTasksRequest =
      DescribeConversionTasksRequest
        .builder
        .ifSome(conversionTaskIds)(_.conversionTaskIds(_))
        .build

    def describeCustomerGatewaysRequest(
      customerGatewayIds: Option[List[CustomerGatewayId]] = None,
      filters: Option[List[Filter]] = None
    ): DescribeCustomerGatewaysRequest =
      DescribeCustomerGatewaysRequest
        .builder
        .ifSome(customerGatewayIds)(_.customerGatewayIds(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeDhcpOptionsRequest(
      dhcpOptionsIds: Option[List[DhcpOptionsId]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeDhcpOptionsRequest =
      DescribeDhcpOptionsRequest
        .builder
        .ifSome(dhcpOptionsIds)(_.dhcpOptionsIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeEgressOnlyInternetGatewaysRequest(
      egressOnlyInternetGatewayIds: Option[List[EgressOnlyInternetGatewayId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeEgressOnlyInternetGatewaysRequest =
      DescribeEgressOnlyInternetGatewaysRequest
        .builder
        .ifSome(egressOnlyInternetGatewayIds)(_.egressOnlyInternetGatewayIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeElasticGpusRequest(
      elasticGpuIds: Option[List[ElasticGpuId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeElasticGpusRequest =
      DescribeElasticGpusRequest
        .builder
        .ifSome(elasticGpuIds)(_.elasticGpuIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeExportImageTasksRequest(
      filters: Option[List[Filter]] = None,
      exportImageTaskIds: Option[List[ExportImageTaskId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeExportImageTasksRequest =
      DescribeExportImageTasksRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(exportImageTaskIds)(_.exportImageTaskIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeExportTasksRequest(
      exportTaskIds: Option[List[ExportTaskId]] = None,
      filters: Option[List[Filter]] = None
    ): DescribeExportTasksRequest =
      DescribeExportTasksRequest
        .builder
        .ifSome(exportTaskIds)(_.exportTaskIds(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeFastSnapshotRestoreSuccessItem(
      snapshotId: Option[String] = None,
      availabilityZone: Option[String] = None,
      state: Option[String] = None,
      stateTransitionReason: Option[String] = None,
      ownerId: Option[String] = None,
      ownerAlias: Option[String] = None,
      enablingTime: Option[MillisecondDateTime] = None,
      optimizingTime: Option[MillisecondDateTime] = None,
      enabledTime: Option[MillisecondDateTime] = None,
      disablingTime: Option[MillisecondDateTime] = None,
      disabledTime: Option[MillisecondDateTime] = None
    ): DescribeFastSnapshotRestoreSuccessItem =
      DescribeFastSnapshotRestoreSuccessItem
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateTransitionReason)(_.stateTransitionReason(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(ownerAlias)(_.ownerAlias(_))
        .ifSome(enablingTime)(_.enablingTime(_))
        .ifSome(optimizingTime)(_.optimizingTime(_))
        .ifSome(enabledTime)(_.enabledTime(_))
        .ifSome(disablingTime)(_.disablingTime(_))
        .ifSome(disabledTime)(_.disabledTime(_))
        .build

    def describeFastSnapshotRestoresRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFastSnapshotRestoresRequest =
      DescribeFastSnapshotRestoresRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetError(
      launchTemplateAndOverrides: Option[LaunchTemplateAndOverridesResponse] = None,
      lifecycle: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): DescribeFleetError =
      DescribeFleetError
        .builder
        .ifSome(launchTemplateAndOverrides)(_.launchTemplateAndOverrides(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def describeFleetHistoryRequest(
      eventType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      fleetId: Option[String] = None,
      startTime: Option[DateTime] = None
    ): DescribeFleetHistoryRequest =
      DescribeFleetHistoryRequest
        .builder
        .ifSome(eventType)(_.eventType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def describeFleetInstancesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      fleetId: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeFleetInstancesRequest =
      DescribeFleetInstancesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeFleetsInstances(
      launchTemplateAndOverrides: Option[LaunchTemplateAndOverridesResponse] = None,
      lifecycle: Option[String] = None,
      instanceIds: Option[List[InstanceId]] = None,
      instanceType: Option[String] = None,
      platform: Option[String] = None
    ): DescribeFleetsInstances =
      DescribeFleetsInstances
        .builder
        .ifSome(launchTemplateAndOverrides)(_.launchTemplateAndOverrides(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(platform)(_.platform(_))
        .build

    def describeFleetsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      fleetIds: Option[List[FleetId]] = None,
      filters: Option[List[Filter]] = None
    ): DescribeFleetsRequest =
      DescribeFleetsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(fleetIds)(_.fleetIds(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeFlowLogsRequest(
      filter: Option[List[Filter]] = None,
      flowLogIds: Option[List[VpcFlowLogId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFlowLogsRequest =
      DescribeFlowLogsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(flowLogIds)(_.flowLogIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFpgaImageAttributeRequest(
      fpgaImageId: Option[String] = None,
      attribute: Option[String] = None
    ): DescribeFpgaImageAttributeRequest =
      DescribeFpgaImageAttributeRequest
        .builder
        .ifSome(fpgaImageId)(_.fpgaImageId(_))
        .ifSome(attribute)(_.attribute(_))
        .build

    def describeFpgaImagesRequest(
      fpgaImageIds: Option[List[FpgaImageId]] = None,
      owners: Option[List[String]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeFpgaImagesRequest =
      DescribeFpgaImagesRequest
        .builder
        .ifSome(fpgaImageIds)(_.fpgaImageIds(_))
        .ifSome(owners)(_.owners(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeHostReservationOfferingsRequest(
      filter: Option[List[Filter]] = None,
      maxDuration: Option[Int] = None,
      maxResults: Option[Int] = None,
      minDuration: Option[Int] = None,
      nextToken: Option[String] = None,
      offeringId: Option[String] = None
    ): DescribeHostReservationOfferingsRequest =
      DescribeHostReservationOfferingsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(maxDuration)(_.maxDuration(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(minDuration)(_.minDuration(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(offeringId)(_.offeringId(_))
        .build

    def describeHostReservationsRequest(
      filter: Option[List[Filter]] = None,
      hostReservationIdSet: Option[List[HostReservationId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeHostReservationsRequest =
      DescribeHostReservationsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(hostReservationIdSet)(_.hostReservationIdSet(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeHostsRequest(
      filter: Option[List[Filter]] = None,
      hostIds: Option[List[DedicatedHostId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeHostsRequest =
      DescribeHostsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(hostIds)(_.hostIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeIamInstanceProfileAssociationsRequest(
      associationIds: Option[List[IamInstanceProfileAssociationId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeIamInstanceProfileAssociationsRequest =
      DescribeIamInstanceProfileAssociationsRequest
        .builder
        .ifSome(associationIds)(_.associationIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeIdFormatRequest(
      resource: Option[String] = None
    ): DescribeIdFormatRequest =
      DescribeIdFormatRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .build

    def describeIdentityIdFormatRequest(
      principalArn: Option[String] = None,
      resource: Option[String] = None
    ): DescribeIdentityIdFormatRequest =
      DescribeIdentityIdFormatRequest
        .builder
        .ifSome(principalArn)(_.principalArn(_))
        .ifSome(resource)(_.resource(_))
        .build

    def describeImageAttributeRequest(
      attribute: Option[String] = None,
      imageId: Option[String] = None
    ): DescribeImageAttributeRequest =
      DescribeImageAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(imageId)(_.imageId(_))
        .build

    def describeImagesRequest(
      executableUsers: Option[List[String]] = None,
      filters: Option[List[Filter]] = None,
      imageIds: Option[List[ImageId]] = None,
      owners: Option[List[String]] = None,
      includeDeprecated: Option[Boolean] = None
    ): DescribeImagesRequest =
      DescribeImagesRequest
        .builder
        .ifSome(executableUsers)(_.executableUsers(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(owners)(_.owners(_))
        .ifSome(includeDeprecated)(_.includeDeprecated(_))
        .build

    def describeImportImageTasksRequest(
      filters: Option[List[Filter]] = None,
      importTaskIds: Option[List[ImportImageTaskId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeImportImageTasksRequest =
      DescribeImportImageTasksRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(importTaskIds)(_.importTaskIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImportSnapshotTasksRequest(
      filters: Option[List[Filter]] = None,
      importTaskIds: Option[List[ImportSnapshotTaskId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeImportSnapshotTasksRequest =
      DescribeImportSnapshotTasksRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(importTaskIds)(_.importTaskIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstanceAttributeRequest(
      attribute: Option[String] = None,
      instanceId: Option[String] = None
    ): DescribeInstanceAttributeRequest =
      DescribeInstanceAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def describeInstanceCreditSpecificationsRequest(
      filters: Option[List[Filter]] = None,
      instanceIds: Option[List[InstanceId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeInstanceCreditSpecificationsRequest =
      DescribeInstanceCreditSpecificationsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstanceEventNotificationAttributesRequest(

    ): DescribeInstanceEventNotificationAttributesRequest =
      DescribeInstanceEventNotificationAttributesRequest
        .builder

        .build

    def describeInstanceStatusRequest(
      filters: Option[List[Filter]] = None,
      instanceIds: Option[List[InstanceId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      includeAllInstances: Option[Boolean] = None
    ): DescribeInstanceStatusRequest =
      DescribeInstanceStatusRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(includeAllInstances)(_.includeAllInstances(_))
        .build

    def describeInstanceTypeOfferingsRequest(
      locationType: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeInstanceTypeOfferingsRequest =
      DescribeInstanceTypeOfferingsRequest
        .builder
        .ifSome(locationType)(_.locationType(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstanceTypesRequest(
      instanceTypes: Option[List[InstanceType]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeInstanceTypesRequest =
      DescribeInstanceTypesRequest
        .builder
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstancesRequest(
      filters: Option[List[Filter]] = None,
      instanceIds: Option[List[InstanceId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeInstancesRequest =
      DescribeInstancesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInternetGatewaysRequest(
      filters: Option[List[Filter]] = None,
      internetGatewayIds: Option[List[InternetGatewayId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeInternetGatewaysRequest =
      DescribeInternetGatewaysRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(internetGatewayIds)(_.internetGatewayIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeIpv6PoolsRequest(
      poolIds: Option[List[Ipv6PoolEc2Id]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): DescribeIpv6PoolsRequest =
      DescribeIpv6PoolsRequest
        .builder
        .ifSome(poolIds)(_.poolIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeKeyPairsRequest(
      filters: Option[List[Filter]] = None,
      keyNames: Option[List[KeyPairName]] = None,
      keyPairIds: Option[List[KeyPairId]] = None
    ): DescribeKeyPairsRequest =
      DescribeKeyPairsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(keyNames)(_.keyNames(_))
        .ifSome(keyPairIds)(_.keyPairIds(_))
        .build

    def describeLaunchTemplateVersionsRequest(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      versions: Option[List[String]] = None,
      minVersion: Option[String] = None,
      maxVersion: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): DescribeLaunchTemplateVersionsRequest =
      DescribeLaunchTemplateVersionsRequest
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(versions)(_.versions(_))
        .ifSome(minVersion)(_.minVersion(_))
        .ifSome(maxVersion)(_.maxVersion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeLaunchTemplatesRequest(
      launchTemplateIds: Option[List[LaunchTemplateId]] = None,
      launchTemplateNames: Option[List[LaunchTemplateName]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeLaunchTemplatesRequest =
      DescribeLaunchTemplatesRequest
        .builder
        .ifSome(launchTemplateIds)(_.launchTemplateIds(_))
        .ifSome(launchTemplateNames)(_.launchTemplateNames(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsRequest(
      localGatewayRouteTableVirtualInterfaceGroupAssociationIds: Option[List[LocalGatewayRouteTableVirtualInterfaceGroupAssociationId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsRequest =
      DescribeLocalGatewayRouteTableVirtualInterfaceGroupAssociationsRequest
        .builder
        .ifSome(localGatewayRouteTableVirtualInterfaceGroupAssociationIds)(_.localGatewayRouteTableVirtualInterfaceGroupAssociationIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLocalGatewayRouteTableVpcAssociationsRequest(
      localGatewayRouteTableVpcAssociationIds: Option[List[LocalGatewayRouteTableVpcAssociationId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeLocalGatewayRouteTableVpcAssociationsRequest =
      DescribeLocalGatewayRouteTableVpcAssociationsRequest
        .builder
        .ifSome(localGatewayRouteTableVpcAssociationIds)(_.localGatewayRouteTableVpcAssociationIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLocalGatewayRouteTablesRequest(
      localGatewayRouteTableIds: Option[List[LocalGatewayRoutetableId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeLocalGatewayRouteTablesRequest =
      DescribeLocalGatewayRouteTablesRequest
        .builder
        .ifSome(localGatewayRouteTableIds)(_.localGatewayRouteTableIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLocalGatewayVirtualInterfaceGroupsRequest(
      localGatewayVirtualInterfaceGroupIds: Option[List[LocalGatewayVirtualInterfaceGroupId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeLocalGatewayVirtualInterfaceGroupsRequest =
      DescribeLocalGatewayVirtualInterfaceGroupsRequest
        .builder
        .ifSome(localGatewayVirtualInterfaceGroupIds)(_.localGatewayVirtualInterfaceGroupIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLocalGatewayVirtualInterfacesRequest(
      localGatewayVirtualInterfaceIds: Option[List[LocalGatewayVirtualInterfaceId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeLocalGatewayVirtualInterfacesRequest =
      DescribeLocalGatewayVirtualInterfacesRequest
        .builder
        .ifSome(localGatewayVirtualInterfaceIds)(_.localGatewayVirtualInterfaceIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeLocalGatewaysRequest(
      localGatewayIds: Option[List[LocalGatewayId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeLocalGatewaysRequest =
      DescribeLocalGatewaysRequest
        .builder
        .ifSome(localGatewayIds)(_.localGatewayIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeManagedPrefixListsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      prefixListIds: Option[List[String]] = None
    ): DescribeManagedPrefixListsRequest =
      DescribeManagedPrefixListsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(prefixListIds)(_.prefixListIds(_))
        .build

    def describeMovingAddressesRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      publicIps: Option[List[String]] = None
    ): DescribeMovingAddressesRequest =
      DescribeMovingAddressesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(publicIps)(_.publicIps(_))
        .build

    def describeNatGatewaysRequest(
      filter: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      natGatewayIds: Option[List[NatGatewayId]] = None,
      nextToken: Option[String] = None
    ): DescribeNatGatewaysRequest =
      DescribeNatGatewaysRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(natGatewayIds)(_.natGatewayIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeNetworkAclsRequest(
      filters: Option[List[Filter]] = None,
      networkAclIds: Option[List[NetworkAclId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeNetworkAclsRequest =
      DescribeNetworkAclsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(networkAclIds)(_.networkAclIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeNetworkInsightsAnalysesRequest(
      networkInsightsAnalysisIds: Option[List[NetworkInsightsAnalysisId]] = None,
      networkInsightsPathId: Option[String] = None,
      analysisStartTime: Option[MillisecondDateTime] = None,
      analysisEndTime: Option[MillisecondDateTime] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeNetworkInsightsAnalysesRequest =
      DescribeNetworkInsightsAnalysesRequest
        .builder
        .ifSome(networkInsightsAnalysisIds)(_.networkInsightsAnalysisIds(_))
        .ifSome(networkInsightsPathId)(_.networkInsightsPathId(_))
        .ifSome(analysisStartTime)(_.analysisStartTime(_))
        .ifSome(analysisEndTime)(_.analysisEndTime(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeNetworkInsightsPathsRequest(
      networkInsightsPathIds: Option[List[NetworkInsightsPathId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeNetworkInsightsPathsRequest =
      DescribeNetworkInsightsPathsRequest
        .builder
        .ifSome(networkInsightsPathIds)(_.networkInsightsPathIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeNetworkInterfaceAttributeRequest(
      attribute: Option[String] = None,
      networkInterfaceId: Option[String] = None
    ): DescribeNetworkInterfaceAttributeRequest =
      DescribeNetworkInterfaceAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .build

    def describeNetworkInterfacePermissionsRequest(
      networkInterfacePermissionIds: Option[List[NetworkInterfacePermissionId]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeNetworkInterfacePermissionsRequest =
      DescribeNetworkInterfacePermissionsRequest
        .builder
        .ifSome(networkInterfacePermissionIds)(_.networkInterfacePermissionIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeNetworkInterfacesRequest(
      filters: Option[List[Filter]] = None,
      networkInterfaceIds: Option[List[NetworkInterfaceId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeNetworkInterfacesRequest =
      DescribeNetworkInterfacesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describePlacementGroupsRequest(
      filters: Option[List[Filter]] = None,
      groupNames: Option[List[PlacementGroupName]] = None,
      groupIds: Option[List[PlacementGroupId]] = None
    ): DescribePlacementGroupsRequest =
      DescribePlacementGroupsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(groupNames)(_.groupNames(_))
        .ifSome(groupIds)(_.groupIds(_))
        .build

    def describePrefixListsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      prefixListIds: Option[List[PrefixListResourceId]] = None
    ): DescribePrefixListsRequest =
      DescribePrefixListsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(prefixListIds)(_.prefixListIds(_))
        .build

    def describePrincipalIdFormatRequest(
      resources: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribePrincipalIdFormatRequest =
      DescribePrincipalIdFormatRequest
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePublicIpv4PoolsRequest(
      poolIds: Option[List[Ipv4PoolEc2Id]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): DescribePublicIpv4PoolsRequest =
      DescribePublicIpv4PoolsRequest
        .builder
        .ifSome(poolIds)(_.poolIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeRegionsRequest(
      filters: Option[List[Filter]] = None,
      regionNames: Option[List[String]] = None,
      allRegions: Option[Boolean] = None
    ): DescribeRegionsRequest =
      DescribeRegionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(regionNames)(_.regionNames(_))
        .ifSome(allRegions)(_.allRegions(_))
        .build

    def describeReplaceRootVolumeTasksRequest(
      replaceRootVolumeTaskIds: Option[List[ReplaceRootVolumeTaskId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeReplaceRootVolumeTasksRequest =
      DescribeReplaceRootVolumeTasksRequest
        .builder
        .ifSome(replaceRootVolumeTaskIds)(_.replaceRootVolumeTaskIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeReservedInstancesListingsRequest(
      filters: Option[List[Filter]] = None,
      reservedInstancesId: Option[String] = None,
      reservedInstancesListingId: Option[String] = None
    ): DescribeReservedInstancesListingsRequest =
      DescribeReservedInstancesListingsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(reservedInstancesId)(_.reservedInstancesId(_))
        .ifSome(reservedInstancesListingId)(_.reservedInstancesListingId(_))
        .build

    def describeReservedInstancesModificationsRequest(
      filters: Option[List[Filter]] = None,
      reservedInstancesModificationIds: Option[List[ReservedInstancesModificationId]] = None,
      nextToken: Option[String] = None
    ): DescribeReservedInstancesModificationsRequest =
      DescribeReservedInstancesModificationsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(reservedInstancesModificationIds)(_.reservedInstancesModificationIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeReservedInstancesOfferingsRequest(
      availabilityZone: Option[String] = None,
      filters: Option[List[Filter]] = None,
      includeMarketplace: Option[Boolean] = None,
      instanceType: Option[String] = None,
      maxDuration: Option[Long] = None,
      maxInstanceCount: Option[Int] = None,
      minDuration: Option[Long] = None,
      offeringClass: Option[String] = None,
      productDescription: Option[String] = None,
      reservedInstancesOfferingIds: Option[List[ReservedInstancesOfferingId]] = None,
      instanceTenancy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      offeringType: Option[String] = None
    ): DescribeReservedInstancesOfferingsRequest =
      DescribeReservedInstancesOfferingsRequest
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(includeMarketplace)(_.includeMarketplace(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(maxDuration)(_.maxDuration(_))
        .ifSome(maxInstanceCount)(_.maxInstanceCount(_))
        .ifSome(minDuration)(_.minDuration(_))
        .ifSome(offeringClass)(_.offeringClass(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(reservedInstancesOfferingIds)(_.reservedInstancesOfferingIds(_))
        .ifSome(instanceTenancy)(_.instanceTenancy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(offeringType)(_.offeringType(_))
        .build

    def describeReservedInstancesRequest(
      filters: Option[List[Filter]] = None,
      offeringClass: Option[String] = None,
      reservedInstancesIds: Option[List[ReservationId]] = None,
      offeringType: Option[String] = None
    ): DescribeReservedInstancesRequest =
      DescribeReservedInstancesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(offeringClass)(_.offeringClass(_))
        .ifSome(reservedInstancesIds)(_.reservedInstancesIds(_))
        .ifSome(offeringType)(_.offeringType(_))
        .build

    def describeRouteTablesRequest(
      filters: Option[List[Filter]] = None,
      routeTableIds: Option[List[RouteTableId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeRouteTablesRequest =
      DescribeRouteTablesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(routeTableIds)(_.routeTableIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeScheduledInstanceAvailabilityRequest(
      filters: Option[List[Filter]] = None,
      firstSlotStartTimeRange: Option[SlotDateTimeRangeRequest] = None,
      maxResults: Option[Int] = None,
      maxSlotDurationInHours: Option[Int] = None,
      minSlotDurationInHours: Option[Int] = None,
      nextToken: Option[String] = None,
      recurrence: Option[ScheduledInstanceRecurrenceRequest] = None
    ): DescribeScheduledInstanceAvailabilityRequest =
      DescribeScheduledInstanceAvailabilityRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(firstSlotStartTimeRange)(_.firstSlotStartTimeRange(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(maxSlotDurationInHours)(_.maxSlotDurationInHours(_))
        .ifSome(minSlotDurationInHours)(_.minSlotDurationInHours(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(recurrence)(_.recurrence(_))
        .build

    def describeScheduledInstancesRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      scheduledInstanceIds: Option[List[ScheduledInstanceId]] = None,
      slotStartTimeRange: Option[SlotStartTimeRangeRequest] = None
    ): DescribeScheduledInstancesRequest =
      DescribeScheduledInstancesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(scheduledInstanceIds)(_.scheduledInstanceIds(_))
        .ifSome(slotStartTimeRange)(_.slotStartTimeRange(_))
        .build

    def describeSecurityGroupReferencesRequest(
      groupId: Option[List[SecurityGroupId]] = None
    ): DescribeSecurityGroupReferencesRequest =
      DescribeSecurityGroupReferencesRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def describeSecurityGroupsRequest(
      filters: Option[List[Filter]] = None,
      groupIds: Option[List[String]] = None,
      groupNames: Option[List[SecurityGroupName]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeSecurityGroupsRequest =
      DescribeSecurityGroupsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(groupIds)(_.groupIds(_))
        .ifSome(groupNames)(_.groupNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeSnapshotAttributeRequest(
      attribute: Option[String] = None,
      snapshotId: Option[String] = None
    ): DescribeSnapshotAttributeRequest =
      DescribeSnapshotAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .build

    def describeSnapshotsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      ownerIds: Option[List[String]] = None,
      restorableByUserIds: Option[List[String]] = None,
      snapshotIds: Option[List[SnapshotId]] = None
    ): DescribeSnapshotsRequest =
      DescribeSnapshotsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(ownerIds)(_.ownerIds(_))
        .ifSome(restorableByUserIds)(_.restorableByUserIds(_))
        .ifSome(snapshotIds)(_.snapshotIds(_))
        .build

    def describeSpotDatafeedSubscriptionRequest(

    ): DescribeSpotDatafeedSubscriptionRequest =
      DescribeSpotDatafeedSubscriptionRequest
        .builder

        .build

    def describeSpotFleetInstancesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      spotFleetRequestId: Option[String] = None
    ): DescribeSpotFleetInstancesRequest =
      DescribeSpotFleetInstancesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .build

    def describeSpotFleetInstancesResponse(
      activeInstances: Option[List[ActiveInstance]] = None,
      nextToken: Option[String] = None,
      spotFleetRequestId: Option[String] = None
    ): DescribeSpotFleetInstancesResponse =
      DescribeSpotFleetInstancesResponse
        .builder
        .ifSome(activeInstances)(_.activeInstances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .build

    def describeSpotFleetRequestHistoryRequest(
      eventType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      spotFleetRequestId: Option[String] = None,
      startTime: Option[DateTime] = None
    ): DescribeSpotFleetRequestHistoryRequest =
      DescribeSpotFleetRequestHistoryRequest
        .builder
        .ifSome(eventType)(_.eventType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def describeSpotFleetRequestHistoryResponse(
      historyRecords: Option[List[HistoryRecord]] = None,
      lastEvaluatedTime: Option[DateTime] = None,
      nextToken: Option[String] = None,
      spotFleetRequestId: Option[String] = None,
      startTime: Option[DateTime] = None
    ): DescribeSpotFleetRequestHistoryResponse =
      DescribeSpotFleetRequestHistoryResponse
        .builder
        .ifSome(historyRecords)(_.historyRecords(_))
        .ifSome(lastEvaluatedTime)(_.lastEvaluatedTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def describeSpotFleetRequestsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      spotFleetRequestIds: Option[List[SpotFleetRequestId]] = None
    ): DescribeSpotFleetRequestsRequest =
      DescribeSpotFleetRequestsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(spotFleetRequestIds)(_.spotFleetRequestIds(_))
        .build

    def describeSpotFleetRequestsResponse(
      nextToken: Option[String] = None,
      spotFleetRequestConfigs: Option[List[SpotFleetRequestConfig]] = None
    ): DescribeSpotFleetRequestsResponse =
      DescribeSpotFleetRequestsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(spotFleetRequestConfigs)(_.spotFleetRequestConfigs(_))
        .build

    def describeSpotInstanceRequestsRequest(
      filters: Option[List[Filter]] = None,
      spotInstanceRequestIds: Option[List[SpotInstanceRequestId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeSpotInstanceRequestsRequest =
      DescribeSpotInstanceRequestsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(spotInstanceRequestIds)(_.spotInstanceRequestIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeSpotPriceHistoryRequest(
      filters: Option[List[Filter]] = None,
      availabilityZone: Option[String] = None,
      endTime: Option[DateTime] = None,
      instanceTypes: Option[List[InstanceType]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      productDescriptions: Option[List[String]] = None,
      startTime: Option[DateTime] = None
    ): DescribeSpotPriceHistoryRequest =
      DescribeSpotPriceHistoryRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(productDescriptions)(_.productDescriptions(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def describeStaleSecurityGroupsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      vpcId: Option[String] = None
    ): DescribeStaleSecurityGroupsRequest =
      DescribeStaleSecurityGroupsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def describeStoreImageTasksRequest(
      imageIds: Option[List[ImageId]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeStoreImageTasksRequest =
      DescribeStoreImageTasksRequest
        .builder
        .ifSome(imageIds)(_.imageIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeSubnetsRequest(
      filters: Option[List[Filter]] = None,
      subnetIds: Option[List[SubnetId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeSubnetsRequest =
      DescribeSubnetsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeTagsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTagsRequest =
      DescribeTagsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTrafficMirrorFiltersRequest(
      trafficMirrorFilterIds: Option[List[TrafficMirrorFilterId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTrafficMirrorFiltersRequest =
      DescribeTrafficMirrorFiltersRequest
        .builder
        .ifSome(trafficMirrorFilterIds)(_.trafficMirrorFilterIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTrafficMirrorSessionsRequest(
      trafficMirrorSessionIds: Option[List[TrafficMirrorSessionId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTrafficMirrorSessionsRequest =
      DescribeTrafficMirrorSessionsRequest
        .builder
        .ifSome(trafficMirrorSessionIds)(_.trafficMirrorSessionIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTrafficMirrorTargetsRequest(
      trafficMirrorTargetIds: Option[List[TrafficMirrorTargetId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTrafficMirrorTargetsRequest =
      DescribeTrafficMirrorTargetsRequest
        .builder
        .ifSome(trafficMirrorTargetIds)(_.trafficMirrorTargetIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewayAttachmentsRequest(
      transitGatewayAttachmentIds: Option[List[TransitGatewayAttachmentId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewayAttachmentsRequest =
      DescribeTransitGatewayAttachmentsRequest
        .builder
        .ifSome(transitGatewayAttachmentIds)(_.transitGatewayAttachmentIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewayConnectPeersRequest(
      transitGatewayConnectPeerIds: Option[List[TransitGatewayConnectPeerId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewayConnectPeersRequest =
      DescribeTransitGatewayConnectPeersRequest
        .builder
        .ifSome(transitGatewayConnectPeerIds)(_.transitGatewayConnectPeerIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewayConnectsRequest(
      transitGatewayAttachmentIds: Option[List[TransitGatewayAttachmentId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewayConnectsRequest =
      DescribeTransitGatewayConnectsRequest
        .builder
        .ifSome(transitGatewayAttachmentIds)(_.transitGatewayAttachmentIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewayMulticastDomainsRequest(
      transitGatewayMulticastDomainIds: Option[List[TransitGatewayMulticastDomainId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewayMulticastDomainsRequest =
      DescribeTransitGatewayMulticastDomainsRequest
        .builder
        .ifSome(transitGatewayMulticastDomainIds)(_.transitGatewayMulticastDomainIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewayPeeringAttachmentsRequest(
      transitGatewayAttachmentIds: Option[List[TransitGatewayAttachmentId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewayPeeringAttachmentsRequest =
      DescribeTransitGatewayPeeringAttachmentsRequest
        .builder
        .ifSome(transitGatewayAttachmentIds)(_.transitGatewayAttachmentIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewayRouteTablesRequest(
      transitGatewayRouteTableIds: Option[List[TransitGatewayRouteTableId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewayRouteTablesRequest =
      DescribeTransitGatewayRouteTablesRequest
        .builder
        .ifSome(transitGatewayRouteTableIds)(_.transitGatewayRouteTableIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewayVpcAttachmentsRequest(
      transitGatewayAttachmentIds: Option[List[TransitGatewayAttachmentId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewayVpcAttachmentsRequest =
      DescribeTransitGatewayVpcAttachmentsRequest
        .builder
        .ifSome(transitGatewayAttachmentIds)(_.transitGatewayAttachmentIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTransitGatewaysRequest(
      transitGatewayIds: Option[List[TransitGatewayId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTransitGatewaysRequest =
      DescribeTransitGatewaysRequest
        .builder
        .ifSome(transitGatewayIds)(_.transitGatewayIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVolumeAttributeRequest(
      attribute: Option[String] = None,
      volumeId: Option[String] = None
    ): DescribeVolumeAttributeRequest =
      DescribeVolumeAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def describeVolumeStatusRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      volumeIds: Option[List[VolumeId]] = None
    ): DescribeVolumeStatusRequest =
      DescribeVolumeStatusRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(volumeIds)(_.volumeIds(_))
        .build

    def describeVolumesModificationsRequest(
      volumeIds: Option[List[VolumeId]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeVolumesModificationsRequest =
      DescribeVolumesModificationsRequest
        .builder
        .ifSome(volumeIds)(_.volumeIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeVolumesRequest(
      filters: Option[List[Filter]] = None,
      volumeIds: Option[List[VolumeId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeVolumesRequest =
      DescribeVolumesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(volumeIds)(_.volumeIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVpcAttributeRequest(
      attribute: Option[String] = None,
      vpcId: Option[String] = None
    ): DescribeVpcAttributeRequest =
      DescribeVpcAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def describeVpcClassicLinkDnsSupportRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      vpcIds: Option[List[VpcId]] = None
    ): DescribeVpcClassicLinkDnsSupportRequest =
      DescribeVpcClassicLinkDnsSupportRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(vpcIds)(_.vpcIds(_))
        .build

    def describeVpcClassicLinkRequest(
      filters: Option[List[Filter]] = None,
      vpcIds: Option[List[VpcId]] = None
    ): DescribeVpcClassicLinkRequest =
      DescribeVpcClassicLinkRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(vpcIds)(_.vpcIds(_))
        .build

    def describeVpcEndpointConnectionNotificationsRequest(
      connectionNotificationId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeVpcEndpointConnectionNotificationsRequest =
      DescribeVpcEndpointConnectionNotificationsRequest
        .builder
        .ifSome(connectionNotificationId)(_.connectionNotificationId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVpcEndpointConnectionsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeVpcEndpointConnectionsRequest =
      DescribeVpcEndpointConnectionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVpcEndpointServiceConfigurationsRequest(
      serviceIds: Option[List[VpcEndpointServiceId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeVpcEndpointServiceConfigurationsRequest =
      DescribeVpcEndpointServiceConfigurationsRequest
        .builder
        .ifSome(serviceIds)(_.serviceIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVpcEndpointServicePermissionsRequest(
      serviceId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeVpcEndpointServicePermissionsRequest =
      DescribeVpcEndpointServicePermissionsRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVpcEndpointServicesRequest(
      serviceNames: Option[List[String]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeVpcEndpointServicesRequest =
      DescribeVpcEndpointServicesRequest
        .builder
        .ifSome(serviceNames)(_.serviceNames(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVpcEndpointsRequest(
      vpcEndpointIds: Option[List[VpcEndpointId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeVpcEndpointsRequest =
      DescribeVpcEndpointsRequest
        .builder
        .ifSome(vpcEndpointIds)(_.vpcEndpointIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeVpcPeeringConnectionsRequest(
      filters: Option[List[Filter]] = None,
      vpcPeeringConnectionIds: Option[List[VpcPeeringConnectionId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeVpcPeeringConnectionsRequest =
      DescribeVpcPeeringConnectionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(vpcPeeringConnectionIds)(_.vpcPeeringConnectionIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeVpcsRequest(
      filters: Option[List[Filter]] = None,
      vpcIds: Option[List[VpcId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeVpcsRequest =
      DescribeVpcsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(vpcIds)(_.vpcIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeVpnConnectionsRequest(
      filters: Option[List[Filter]] = None,
      vpnConnectionIds: Option[List[VpnConnectionId]] = None
    ): DescribeVpnConnectionsRequest =
      DescribeVpnConnectionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(vpnConnectionIds)(_.vpnConnectionIds(_))
        .build

    def describeVpnGatewaysRequest(
      filters: Option[List[Filter]] = None,
      vpnGatewayIds: Option[List[VpnGatewayId]] = None
    ): DescribeVpnGatewaysRequest =
      DescribeVpnGatewaysRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(vpnGatewayIds)(_.vpnGatewayIds(_))
        .build

    def detachClassicLinkVpcRequest(
      instanceId: Option[String] = None,
      vpcId: Option[String] = None
    ): DetachClassicLinkVpcRequest =
      DetachClassicLinkVpcRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def detachInternetGatewayRequest(
      internetGatewayId: Option[String] = None,
      vpcId: Option[String] = None
    ): DetachInternetGatewayRequest =
      DetachInternetGatewayRequest
        .builder
        .ifSome(internetGatewayId)(_.internetGatewayId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def detachNetworkInterfaceRequest(
      attachmentId: Option[String] = None,
      force: Option[Boolean] = None
    ): DetachNetworkInterfaceRequest =
      DetachNetworkInterfaceRequest
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(force)(_.force(_))
        .build

    def detachVolumeRequest(
      device: Option[String] = None,
      force: Option[Boolean] = None,
      instanceId: Option[String] = None,
      volumeId: Option[String] = None
    ): DetachVolumeRequest =
      DetachVolumeRequest
        .builder
        .ifSome(device)(_.device(_))
        .ifSome(force)(_.force(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def detachVpnGatewayRequest(
      vpcId: Option[String] = None,
      vpnGatewayId: Option[String] = None
    ): DetachVpnGatewayRequest =
      DetachVpnGatewayRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpnGatewayId)(_.vpnGatewayId(_))
        .build

    def dhcpConfiguration(
      key: Option[String] = None,
      values: Option[List[AttributeValue]] = None
    ): DhcpConfiguration =
      DhcpConfiguration
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def dhcpOptions(
      dhcpConfigurations: Option[List[DhcpConfiguration]] = None,
      dhcpOptionsId: Option[String] = None,
      ownerId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): DhcpOptions =
      DhcpOptions
        .builder
        .ifSome(dhcpConfigurations)(_.dhcpConfigurations(_))
        .ifSome(dhcpOptionsId)(_.dhcpOptionsId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def directoryServiceAuthentication(
      directoryId: Option[String] = None
    ): DirectoryServiceAuthentication =
      DirectoryServiceAuthentication
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def directoryServiceAuthenticationRequest(
      directoryId: Option[String] = None
    ): DirectoryServiceAuthenticationRequest =
      DirectoryServiceAuthenticationRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .build

    def disableEbsEncryptionByDefaultRequest(

    ): DisableEbsEncryptionByDefaultRequest =
      DisableEbsEncryptionByDefaultRequest
        .builder

        .build

    def disableFastSnapshotRestoreErrorItem(
      snapshotId: Option[String] = None,
      fastSnapshotRestoreStateErrors: Option[List[DisableFastSnapshotRestoreStateErrorItem]] = None
    ): DisableFastSnapshotRestoreErrorItem =
      DisableFastSnapshotRestoreErrorItem
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(fastSnapshotRestoreStateErrors)(_.fastSnapshotRestoreStateErrors(_))
        .build

    def disableFastSnapshotRestoreStateError(
      code: Option[String] = None,
      message: Option[String] = None
    ): DisableFastSnapshotRestoreStateError =
      DisableFastSnapshotRestoreStateError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def disableFastSnapshotRestoreStateErrorItem(
      availabilityZone: Option[String] = None,
      error: Option[DisableFastSnapshotRestoreStateError] = None
    ): DisableFastSnapshotRestoreStateErrorItem =
      DisableFastSnapshotRestoreStateErrorItem
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(error)(_.error(_))
        .build

    def disableFastSnapshotRestoreSuccessItem(
      snapshotId: Option[String] = None,
      availabilityZone: Option[String] = None,
      state: Option[String] = None,
      stateTransitionReason: Option[String] = None,
      ownerId: Option[String] = None,
      ownerAlias: Option[String] = None,
      enablingTime: Option[MillisecondDateTime] = None,
      optimizingTime: Option[MillisecondDateTime] = None,
      enabledTime: Option[MillisecondDateTime] = None,
      disablingTime: Option[MillisecondDateTime] = None,
      disabledTime: Option[MillisecondDateTime] = None
    ): DisableFastSnapshotRestoreSuccessItem =
      DisableFastSnapshotRestoreSuccessItem
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateTransitionReason)(_.stateTransitionReason(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(ownerAlias)(_.ownerAlias(_))
        .ifSome(enablingTime)(_.enablingTime(_))
        .ifSome(optimizingTime)(_.optimizingTime(_))
        .ifSome(enabledTime)(_.enabledTime(_))
        .ifSome(disablingTime)(_.disablingTime(_))
        .ifSome(disabledTime)(_.disabledTime(_))
        .build

    def disableFastSnapshotRestoresRequest(
      availabilityZones: Option[List[String]] = None,
      sourceSnapshotIds: Option[List[SnapshotId]] = None
    ): DisableFastSnapshotRestoresRequest =
      DisableFastSnapshotRestoresRequest
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(sourceSnapshotIds)(_.sourceSnapshotIds(_))
        .build

    def disableImageDeprecationRequest(
      imageId: Option[String] = None
    ): DisableImageDeprecationRequest =
      DisableImageDeprecationRequest
        .builder
        .ifSome(imageId)(_.imageId(_))
        .build

    def disableSerialConsoleAccessRequest(

    ): DisableSerialConsoleAccessRequest =
      DisableSerialConsoleAccessRequest
        .builder

        .build

    def disableTransitGatewayRouteTablePropagationRequest(
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None
    ): DisableTransitGatewayRouteTablePropagationRequest =
      DisableTransitGatewayRouteTablePropagationRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def disableVgwRoutePropagationRequest(
      gatewayId: Option[String] = None,
      routeTableId: Option[String] = None
    ): DisableVgwRoutePropagationRequest =
      DisableVgwRoutePropagationRequest
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .build

    def disableVpcClassicLinkDnsSupportRequest(
      vpcId: Option[String] = None
    ): DisableVpcClassicLinkDnsSupportRequest =
      DisableVpcClassicLinkDnsSupportRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def disableVpcClassicLinkRequest(
      vpcId: Option[String] = None
    ): DisableVpcClassicLinkRequest =
      DisableVpcClassicLinkRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def disassociateAddressRequest(
      associationId: Option[String] = None,
      publicIp: Option[String] = None
    ): DisassociateAddressRequest =
      DisassociateAddressRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(publicIp)(_.publicIp(_))
        .build

    def disassociateClientVpnTargetNetworkRequest(
      clientVpnEndpointId: Option[String] = None,
      associationId: Option[String] = None
    ): DisassociateClientVpnTargetNetworkRequest =
      DisassociateClientVpnTargetNetworkRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(associationId)(_.associationId(_))
        .build

    def disassociateEnclaveCertificateIamRoleRequest(
      certificateArn: Option[String] = None,
      roleArn: Option[String] = None
    ): DisassociateEnclaveCertificateIamRoleRequest =
      DisassociateEnclaveCertificateIamRoleRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def disassociateIamInstanceProfileRequest(
      associationId: Option[String] = None
    ): DisassociateIamInstanceProfileRequest =
      DisassociateIamInstanceProfileRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .build

    def disassociateRouteTableRequest(
      associationId: Option[String] = None
    ): DisassociateRouteTableRequest =
      DisassociateRouteTableRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .build

    def disassociateSubnetCidrBlockRequest(
      associationId: Option[String] = None
    ): DisassociateSubnetCidrBlockRequest =
      DisassociateSubnetCidrBlockRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .build

    def disassociateTransitGatewayMulticastDomainRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None
    ): DisassociateTransitGatewayMulticastDomainRequest =
      DisassociateTransitGatewayMulticastDomainRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def disassociateTransitGatewayRouteTableRequest(
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None
    ): DisassociateTransitGatewayRouteTableRequest =
      DisassociateTransitGatewayRouteTableRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def disassociateVpcCidrBlockRequest(
      associationId: Option[String] = None
    ): DisassociateVpcCidrBlockRequest =
      DisassociateVpcCidrBlockRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .build

    def diskImage(
      description: Option[String] = None,
      image: Option[DiskImageDetail] = None,
      volume: Option[VolumeDetail] = None
    ): DiskImage =
      DiskImage
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(image)(_.image(_))
        .ifSome(volume)(_.volume(_))
        .build

    def diskImageDescription(
      checksum: Option[String] = None,
      format: Option[String] = None,
      importManifestUrl: Option[String] = None,
      size: Option[Long] = None
    ): DiskImageDescription =
      DiskImageDescription
        .builder
        .ifSome(checksum)(_.checksum(_))
        .ifSome(format)(_.format(_))
        .ifSome(importManifestUrl)(_.importManifestUrl(_))
        .ifSome(size)(_.size(_))
        .build

    def diskImageDetail(
      bytes: Option[Long] = None,
      format: Option[String] = None,
      importManifestUrl: Option[String] = None
    ): DiskImageDetail =
      DiskImageDetail
        .builder
        .ifSome(bytes)(_.bytes(_))
        .ifSome(format)(_.format(_))
        .ifSome(importManifestUrl)(_.importManifestUrl(_))
        .build

    def diskImageVolumeDescription(
      id: Option[String] = None,
      size: Option[Long] = None
    ): DiskImageVolumeDescription =
      DiskImageVolumeDescription
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(size)(_.size(_))
        .build

    def diskInfo(
      sizeInGB: Option[DiskSize] = None,
      count: Option[Int] = None,
      `type`: Option[String] = None
    ): DiskInfo =
      DiskInfo
        .builder
        .ifSome(sizeInGB)(_.sizeInGB(_))
        .ifSome(count)(_.count(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def dnsEntry(
      dnsName: Option[String] = None,
      hostedZoneId: Option[String] = None
    ): DnsEntry =
      DnsEntry
        .builder
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def dnsServersOptionsModifyStructure(
      customDnsServers: Option[List[String]] = None,
      enabled: Option[Boolean] = None
    ): DnsServersOptionsModifyStructure =
      DnsServersOptionsModifyStructure
        .builder
        .ifSome(customDnsServers)(_.customDnsServers(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def ebsBlockDevice(
      deleteOnTermination: Option[Boolean] = None,
      iops: Option[Int] = None,
      snapshotId: Option[String] = None,
      volumeSize: Option[Int] = None,
      volumeType: Option[String] = None,
      kmsKeyId: Option[String] = None,
      throughput: Option[Int] = None,
      outpostArn: Option[String] = None,
      encrypted: Option[Boolean] = None
    ): EbsBlockDevice =
      EbsBlockDevice
        .builder
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(throughput)(_.throughput(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(encrypted)(_.encrypted(_))
        .build

    def ebsInfo(
      ebsOptimizedSupport: Option[String] = None,
      encryptionSupport: Option[String] = None,
      ebsOptimizedInfo: Option[EbsOptimizedInfo] = None,
      nvmeSupport: Option[String] = None
    ): EbsInfo =
      EbsInfo
        .builder
        .ifSome(ebsOptimizedSupport)(_.ebsOptimizedSupport(_))
        .ifSome(encryptionSupport)(_.encryptionSupport(_))
        .ifSome(ebsOptimizedInfo)(_.ebsOptimizedInfo(_))
        .ifSome(nvmeSupport)(_.nvmeSupport(_))
        .build

    def ebsInstanceBlockDevice(
      attachTime: Option[DateTime] = None,
      deleteOnTermination: Option[Boolean] = None,
      status: Option[String] = None,
      volumeId: Option[String] = None
    ): EbsInstanceBlockDevice =
      EbsInstanceBlockDevice
        .builder
        .ifSome(attachTime)(_.attachTime(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(status)(_.status(_))
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def ebsInstanceBlockDeviceSpecification(
      deleteOnTermination: Option[Boolean] = None,
      volumeId: Option[String] = None
    ): EbsInstanceBlockDeviceSpecification =
      EbsInstanceBlockDeviceSpecification
        .builder
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def ebsOptimizedInfo(
      baselineBandwidthInMbps: Option[Int] = None,
      baselineThroughputInMBps: Option[BaselineThroughputInMBps] = None,
      baselineIops: Option[Int] = None,
      maximumBandwidthInMbps: Option[Int] = None,
      maximumThroughputInMBps: Option[MaximumThroughputInMBps] = None,
      maximumIops: Option[Int] = None
    ): EbsOptimizedInfo =
      EbsOptimizedInfo
        .builder
        .ifSome(baselineBandwidthInMbps)(_.baselineBandwidthInMbps(_))
        .ifSome(baselineThroughputInMBps)(_.baselineThroughputInMBps(_))
        .ifSome(baselineIops)(_.baselineIops(_))
        .ifSome(maximumBandwidthInMbps)(_.maximumBandwidthInMbps(_))
        .ifSome(maximumThroughputInMBps)(_.maximumThroughputInMBps(_))
        .ifSome(maximumIops)(_.maximumIops(_))
        .build

    def efaInfo(
      maximumEfaInterfaces: Option[Int] = None
    ): EfaInfo =
      EfaInfo
        .builder
        .ifSome(maximumEfaInterfaces)(_.maximumEfaInterfaces(_))
        .build

    def egressOnlyInternetGateway(
      attachments: Option[List[InternetGatewayAttachment]] = None,
      egressOnlyInternetGatewayId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): EgressOnlyInternetGateway =
      EgressOnlyInternetGateway
        .builder
        .ifSome(attachments)(_.attachments(_))
        .ifSome(egressOnlyInternetGatewayId)(_.egressOnlyInternetGatewayId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def elasticGpuAssociation(
      elasticGpuId: Option[String] = None,
      elasticGpuAssociationId: Option[String] = None,
      elasticGpuAssociationState: Option[String] = None,
      elasticGpuAssociationTime: Option[String] = None
    ): ElasticGpuAssociation =
      ElasticGpuAssociation
        .builder
        .ifSome(elasticGpuId)(_.elasticGpuId(_))
        .ifSome(elasticGpuAssociationId)(_.elasticGpuAssociationId(_))
        .ifSome(elasticGpuAssociationState)(_.elasticGpuAssociationState(_))
        .ifSome(elasticGpuAssociationTime)(_.elasticGpuAssociationTime(_))
        .build

    def elasticGpuHealth(
      status: Option[String] = None
    ): ElasticGpuHealth =
      ElasticGpuHealth
        .builder
        .ifSome(status)(_.status(_))
        .build

    def elasticGpuSpecification(
      `type`: Option[String] = None
    ): ElasticGpuSpecification =
      ElasticGpuSpecification
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def elasticGpuSpecificationResponse(
      `type`: Option[String] = None
    ): ElasticGpuSpecificationResponse =
      ElasticGpuSpecificationResponse
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def elasticGpus(
      elasticGpuId: Option[String] = None,
      availabilityZone: Option[String] = None,
      elasticGpuType: Option[String] = None,
      elasticGpuHealth: Option[ElasticGpuHealth] = None,
      elasticGpuState: Option[String] = None,
      instanceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ElasticGpus =
      ElasticGpus
        .builder
        .ifSome(elasticGpuId)(_.elasticGpuId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(elasticGpuType)(_.elasticGpuType(_))
        .ifSome(elasticGpuHealth)(_.elasticGpuHealth(_))
        .ifSome(elasticGpuState)(_.elasticGpuState(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def elasticInferenceAccelerator(
      `type`: Option[String] = None,
      count: Option[Int] = None
    ): ElasticInferenceAccelerator =
      ElasticInferenceAccelerator
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(count)(_.count(_))
        .build

    def elasticInferenceAcceleratorAssociation(
      elasticInferenceAcceleratorArn: Option[String] = None,
      elasticInferenceAcceleratorAssociationId: Option[String] = None,
      elasticInferenceAcceleratorAssociationState: Option[String] = None,
      elasticInferenceAcceleratorAssociationTime: Option[DateTime] = None
    ): ElasticInferenceAcceleratorAssociation =
      ElasticInferenceAcceleratorAssociation
        .builder
        .ifSome(elasticInferenceAcceleratorArn)(_.elasticInferenceAcceleratorArn(_))
        .ifSome(elasticInferenceAcceleratorAssociationId)(_.elasticInferenceAcceleratorAssociationId(_))
        .ifSome(elasticInferenceAcceleratorAssociationState)(_.elasticInferenceAcceleratorAssociationState(_))
        .ifSome(elasticInferenceAcceleratorAssociationTime)(_.elasticInferenceAcceleratorAssociationTime(_))
        .build

    def enableEbsEncryptionByDefaultRequest(

    ): EnableEbsEncryptionByDefaultRequest =
      EnableEbsEncryptionByDefaultRequest
        .builder

        .build

    def enableFastSnapshotRestoreErrorItem(
      snapshotId: Option[String] = None,
      fastSnapshotRestoreStateErrors: Option[List[EnableFastSnapshotRestoreStateErrorItem]] = None
    ): EnableFastSnapshotRestoreErrorItem =
      EnableFastSnapshotRestoreErrorItem
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(fastSnapshotRestoreStateErrors)(_.fastSnapshotRestoreStateErrors(_))
        .build

    def enableFastSnapshotRestoreStateError(
      code: Option[String] = None,
      message: Option[String] = None
    ): EnableFastSnapshotRestoreStateError =
      EnableFastSnapshotRestoreStateError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def enableFastSnapshotRestoreStateErrorItem(
      availabilityZone: Option[String] = None,
      error: Option[EnableFastSnapshotRestoreStateError] = None
    ): EnableFastSnapshotRestoreStateErrorItem =
      EnableFastSnapshotRestoreStateErrorItem
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(error)(_.error(_))
        .build

    def enableFastSnapshotRestoreSuccessItem(
      snapshotId: Option[String] = None,
      availabilityZone: Option[String] = None,
      state: Option[String] = None,
      stateTransitionReason: Option[String] = None,
      ownerId: Option[String] = None,
      ownerAlias: Option[String] = None,
      enablingTime: Option[MillisecondDateTime] = None,
      optimizingTime: Option[MillisecondDateTime] = None,
      enabledTime: Option[MillisecondDateTime] = None,
      disablingTime: Option[MillisecondDateTime] = None,
      disabledTime: Option[MillisecondDateTime] = None
    ): EnableFastSnapshotRestoreSuccessItem =
      EnableFastSnapshotRestoreSuccessItem
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateTransitionReason)(_.stateTransitionReason(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(ownerAlias)(_.ownerAlias(_))
        .ifSome(enablingTime)(_.enablingTime(_))
        .ifSome(optimizingTime)(_.optimizingTime(_))
        .ifSome(enabledTime)(_.enabledTime(_))
        .ifSome(disablingTime)(_.disablingTime(_))
        .ifSome(disabledTime)(_.disabledTime(_))
        .build

    def enableFastSnapshotRestoresRequest(
      availabilityZones: Option[List[String]] = None,
      sourceSnapshotIds: Option[List[SnapshotId]] = None
    ): EnableFastSnapshotRestoresRequest =
      EnableFastSnapshotRestoresRequest
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(sourceSnapshotIds)(_.sourceSnapshotIds(_))
        .build

    def enableImageDeprecationRequest(
      imageId: Option[String] = None,
      deprecateAt: Option[MillisecondDateTime] = None
    ): EnableImageDeprecationRequest =
      EnableImageDeprecationRequest
        .builder
        .ifSome(imageId)(_.imageId(_))
        .ifSome(deprecateAt)(_.deprecateAt(_))
        .build

    def enableSerialConsoleAccessRequest(

    ): EnableSerialConsoleAccessRequest =
      EnableSerialConsoleAccessRequest
        .builder

        .build

    def enableTransitGatewayRouteTablePropagationRequest(
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None
    ): EnableTransitGatewayRouteTablePropagationRequest =
      EnableTransitGatewayRouteTablePropagationRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def enableVgwRoutePropagationRequest(
      gatewayId: Option[String] = None,
      routeTableId: Option[String] = None
    ): EnableVgwRoutePropagationRequest =
      EnableVgwRoutePropagationRequest
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .build

    def enableVolumeIORequest(
      volumeId: Option[String] = None
    ): EnableVolumeIORequest =
      EnableVolumeIORequest
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def enableVpcClassicLinkDnsSupportRequest(
      vpcId: Option[String] = None
    ): EnableVpcClassicLinkDnsSupportRequest =
      EnableVpcClassicLinkDnsSupportRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def enableVpcClassicLinkRequest(
      vpcId: Option[String] = None
    ): EnableVpcClassicLinkRequest =
      EnableVpcClassicLinkRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def enclaveOptions(
      enabled: Option[Boolean] = None
    ): EnclaveOptions =
      EnclaveOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def enclaveOptionsRequest(
      enabled: Option[Boolean] = None
    ): EnclaveOptionsRequest =
      EnclaveOptionsRequest
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def eventInformation(
      eventDescription: Option[String] = None,
      eventSubType: Option[String] = None,
      instanceId: Option[String] = None
    ): EventInformation =
      EventInformation
        .builder
        .ifSome(eventDescription)(_.eventDescription(_))
        .ifSome(eventSubType)(_.eventSubType(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def explanation(
      acl: Option[AnalysisComponent] = None,
      aclRule: Option[AnalysisAclRule] = None,
      address: Option[String] = None,
      addresses: Option[List[IpAddress]] = None,
      attachedTo: Option[AnalysisComponent] = None,
      availabilityZones: Option[List[String]] = None,
      cidrs: Option[List[String]] = None,
      component: Option[AnalysisComponent] = None,
      customerGateway: Option[AnalysisComponent] = None,
      destination: Option[AnalysisComponent] = None,
      destinationVpc: Option[AnalysisComponent] = None,
      direction: Option[String] = None,
      explanationCode: Option[String] = None,
      ingressRouteTable: Option[AnalysisComponent] = None,
      internetGateway: Option[AnalysisComponent] = None,
      loadBalancerArn: Option[String] = None,
      classicLoadBalancerListener: Option[AnalysisLoadBalancerListener] = None,
      loadBalancerListenerPort: Option[Int] = None,
      loadBalancerTarget: Option[AnalysisLoadBalancerTarget] = None,
      loadBalancerTargetGroup: Option[AnalysisComponent] = None,
      loadBalancerTargetGroups: Option[List[AnalysisComponent]] = None,
      loadBalancerTargetPort: Option[Int] = None,
      elasticLoadBalancerListener: Option[AnalysisComponent] = None,
      missingComponent: Option[String] = None,
      natGateway: Option[AnalysisComponent] = None,
      networkInterface: Option[AnalysisComponent] = None,
      packetField: Option[String] = None,
      vpcPeeringConnection: Option[AnalysisComponent] = None,
      port: Option[Int] = None,
      portRanges: Option[List[PortRange]] = None,
      prefixList: Option[AnalysisComponent] = None,
      protocols: Option[List[String]] = None,
      routeTableRoute: Option[AnalysisRouteTableRoute] = None,
      routeTable: Option[AnalysisComponent] = None,
      securityGroup: Option[AnalysisComponent] = None,
      securityGroupRule: Option[AnalysisSecurityGroupRule] = None,
      securityGroups: Option[List[AnalysisComponent]] = None,
      sourceVpc: Option[AnalysisComponent] = None,
      state: Option[String] = None,
      subnet: Option[AnalysisComponent] = None,
      subnetRouteTable: Option[AnalysisComponent] = None,
      vpc: Option[AnalysisComponent] = None,
      vpcEndpoint: Option[AnalysisComponent] = None,
      vpnConnection: Option[AnalysisComponent] = None,
      vpnGateway: Option[AnalysisComponent] = None
    ): Explanation =
      Explanation
        .builder
        .ifSome(acl)(_.acl(_))
        .ifSome(aclRule)(_.aclRule(_))
        .ifSome(address)(_.address(_))
        .ifSome(addresses)(_.addresses(_))
        .ifSome(attachedTo)(_.attachedTo(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(cidrs)(_.cidrs(_))
        .ifSome(component)(_.component(_))
        .ifSome(customerGateway)(_.customerGateway(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationVpc)(_.destinationVpc(_))
        .ifSome(direction)(_.direction(_))
        .ifSome(explanationCode)(_.explanationCode(_))
        .ifSome(ingressRouteTable)(_.ingressRouteTable(_))
        .ifSome(internetGateway)(_.internetGateway(_))
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(classicLoadBalancerListener)(_.classicLoadBalancerListener(_))
        .ifSome(loadBalancerListenerPort)(_.loadBalancerListenerPort(_))
        .ifSome(loadBalancerTarget)(_.loadBalancerTarget(_))
        .ifSome(loadBalancerTargetGroup)(_.loadBalancerTargetGroup(_))
        .ifSome(loadBalancerTargetGroups)(_.loadBalancerTargetGroups(_))
        .ifSome(loadBalancerTargetPort)(_.loadBalancerTargetPort(_))
        .ifSome(elasticLoadBalancerListener)(_.elasticLoadBalancerListener(_))
        .ifSome(missingComponent)(_.missingComponent(_))
        .ifSome(natGateway)(_.natGateway(_))
        .ifSome(networkInterface)(_.networkInterface(_))
        .ifSome(packetField)(_.packetField(_))
        .ifSome(vpcPeeringConnection)(_.vpcPeeringConnection(_))
        .ifSome(port)(_.port(_))
        .ifSome(portRanges)(_.portRanges(_))
        .ifSome(prefixList)(_.prefixList(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(routeTableRoute)(_.routeTableRoute(_))
        .ifSome(routeTable)(_.routeTable(_))
        .ifSome(securityGroup)(_.securityGroup(_))
        .ifSome(securityGroupRule)(_.securityGroupRule(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(sourceVpc)(_.sourceVpc(_))
        .ifSome(state)(_.state(_))
        .ifSome(subnet)(_.subnet(_))
        .ifSome(subnetRouteTable)(_.subnetRouteTable(_))
        .ifSome(vpc)(_.vpc(_))
        .ifSome(vpcEndpoint)(_.vpcEndpoint(_))
        .ifSome(vpnConnection)(_.vpnConnection(_))
        .ifSome(vpnGateway)(_.vpnGateway(_))
        .build

    def exportClientVpnClientCertificateRevocationListRequest(
      clientVpnEndpointId: Option[String] = None
    ): ExportClientVpnClientCertificateRevocationListRequest =
      ExportClientVpnClientCertificateRevocationListRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .build

    def exportClientVpnClientConfigurationRequest(
      clientVpnEndpointId: Option[String] = None
    ): ExportClientVpnClientConfigurationRequest =
      ExportClientVpnClientConfigurationRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .build

    def exportImageRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      diskImageFormat: Option[String] = None,
      imageId: Option[String] = None,
      s3ExportLocation: Option[ExportTaskS3LocationRequest] = None,
      roleName: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): ExportImageRequest =
      ExportImageRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(diskImageFormat)(_.diskImageFormat(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(s3ExportLocation)(_.s3ExportLocation(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def exportImageTask(
      description: Option[String] = None,
      exportImageTaskId: Option[String] = None,
      imageId: Option[String] = None,
      progress: Option[String] = None,
      s3ExportLocation: Option[ExportTaskS3Location] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ExportImageTask =
      ExportImageTask
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(exportImageTaskId)(_.exportImageTaskId(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(s3ExportLocation)(_.s3ExportLocation(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(tags)(_.tags(_))
        .build

    def exportTask(
      description: Option[String] = None,
      exportTaskId: Option[String] = None,
      exportToS3Task: Option[ExportToS3Task] = None,
      instanceExportDetails: Option[InstanceExportDetails] = None,
      state: Option[String] = None,
      statusMessage: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ExportTask =
      ExportTask
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(exportTaskId)(_.exportTaskId(_))
        .ifSome(exportToS3Task)(_.exportToS3Task(_))
        .ifSome(instanceExportDetails)(_.instanceExportDetails(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(tags)(_.tags(_))
        .build

    def exportTaskS3Location(
      s3Bucket: Option[String] = None,
      s3Prefix: Option[String] = None
    ): ExportTaskS3Location =
      ExportTaskS3Location
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .build

    def exportTaskS3LocationRequest(
      s3Bucket: Option[String] = None,
      s3Prefix: Option[String] = None
    ): ExportTaskS3LocationRequest =
      ExportTaskS3LocationRequest
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .build

    def exportToS3Task(
      containerFormat: Option[String] = None,
      diskImageFormat: Option[String] = None,
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None
    ): ExportToS3Task =
      ExportToS3Task
        .builder
        .ifSome(containerFormat)(_.containerFormat(_))
        .ifSome(diskImageFormat)(_.diskImageFormat(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def exportToS3TaskSpecification(
      containerFormat: Option[String] = None,
      diskImageFormat: Option[String] = None,
      s3Bucket: Option[String] = None,
      s3Prefix: Option[String] = None
    ): ExportToS3TaskSpecification =
      ExportToS3TaskSpecification
        .builder
        .ifSome(containerFormat)(_.containerFormat(_))
        .ifSome(diskImageFormat)(_.diskImageFormat(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .build

    def exportTransitGatewayRoutesRequest(
      transitGatewayRouteTableId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      s3Bucket: Option[String] = None
    ): ExportTransitGatewayRoutesRequest =
      ExportTransitGatewayRoutesRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .build

    def failedQueuedPurchaseDeletion(
      error: Option[DeleteQueuedReservedInstancesError] = None,
      reservedInstancesId: Option[String] = None
    ): FailedQueuedPurchaseDeletion =
      FailedQueuedPurchaseDeletion
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(reservedInstancesId)(_.reservedInstancesId(_))
        .build

    def federatedAuthentication(
      samlProviderArn: Option[String] = None,
      selfServiceSamlProviderArn: Option[String] = None
    ): FederatedAuthentication =
      FederatedAuthentication
        .builder
        .ifSome(samlProviderArn)(_.samlProviderArn(_))
        .ifSome(selfServiceSamlProviderArn)(_.selfServiceSamlProviderArn(_))
        .build

    def federatedAuthenticationRequest(
      sAMLProviderArn: Option[String] = None,
      selfServiceSAMLProviderArn: Option[String] = None
    ): FederatedAuthenticationRequest =
      FederatedAuthenticationRequest
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .ifSome(selfServiceSAMLProviderArn)(_.selfServiceSAMLProviderArn(_))
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

    def fleetData(
      activityStatus: Option[String] = None,
      createTime: Option[DateTime] = None,
      fleetId: Option[String] = None,
      fleetState: Option[String] = None,
      clientToken: Option[String] = None,
      excessCapacityTerminationPolicy: Option[String] = None,
      fulfilledCapacity: Option[Double] = None,
      fulfilledOnDemandCapacity: Option[Double] = None,
      launchTemplateConfigs: Option[List[FleetLaunchTemplateConfig]] = None,
      targetCapacitySpecification: Option[TargetCapacitySpecification] = None,
      terminateInstancesWithExpiration: Option[Boolean] = None,
      `type`: Option[String] = None,
      validFrom: Option[DateTime] = None,
      validUntil: Option[DateTime] = None,
      replaceUnhealthyInstances: Option[Boolean] = None,
      spotOptions: Option[SpotOptions] = None,
      onDemandOptions: Option[OnDemandOptions] = None,
      tags: Option[List[Tag]] = None,
      errors: Option[List[DescribeFleetError]] = None,
      instances: Option[List[DescribeFleetsInstances]] = None
    ): FleetData =
      FleetData
        .builder
        .ifSome(activityStatus)(_.activityStatus(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetState)(_.fleetState(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(excessCapacityTerminationPolicy)(_.excessCapacityTerminationPolicy(_))
        .ifSome(fulfilledCapacity)(_.fulfilledCapacity(_))
        .ifSome(fulfilledOnDemandCapacity)(_.fulfilledOnDemandCapacity(_))
        .ifSome(launchTemplateConfigs)(_.launchTemplateConfigs(_))
        .ifSome(targetCapacitySpecification)(_.targetCapacitySpecification(_))
        .ifSome(terminateInstancesWithExpiration)(_.terminateInstancesWithExpiration(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(validFrom)(_.validFrom(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(replaceUnhealthyInstances)(_.replaceUnhealthyInstances(_))
        .ifSome(spotOptions)(_.spotOptions(_))
        .ifSome(onDemandOptions)(_.onDemandOptions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(instances)(_.instances(_))
        .build

    def fleetLaunchTemplateConfig(
      launchTemplateSpecification: Option[FleetLaunchTemplateSpecification] = None,
      overrides: Option[List[FleetLaunchTemplateOverrides]] = None
    ): FleetLaunchTemplateConfig =
      FleetLaunchTemplateConfig
        .builder
        .ifSome(launchTemplateSpecification)(_.launchTemplateSpecification(_))
        .ifSome(overrides)(_.overrides(_))
        .build

    def fleetLaunchTemplateConfigRequest(
      launchTemplateSpecification: Option[FleetLaunchTemplateSpecificationRequest] = None,
      overrides: Option[List[FleetLaunchTemplateOverridesRequest]] = None
    ): FleetLaunchTemplateConfigRequest =
      FleetLaunchTemplateConfigRequest
        .builder
        .ifSome(launchTemplateSpecification)(_.launchTemplateSpecification(_))
        .ifSome(overrides)(_.overrides(_))
        .build

    def fleetLaunchTemplateOverrides(
      instanceType: Option[String] = None,
      maxPrice: Option[String] = None,
      subnetId: Option[String] = None,
      availabilityZone: Option[String] = None,
      weightedCapacity: Option[Double] = None,
      priority: Option[Double] = None,
      placement: Option[PlacementResponse] = None
    ): FleetLaunchTemplateOverrides =
      FleetLaunchTemplateOverrides
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(maxPrice)(_.maxPrice(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(placement)(_.placement(_))
        .build

    def fleetLaunchTemplateOverridesRequest(
      instanceType: Option[String] = None,
      maxPrice: Option[String] = None,
      subnetId: Option[String] = None,
      availabilityZone: Option[String] = None,
      weightedCapacity: Option[Double] = None,
      priority: Option[Double] = None,
      placement: Option[Placement] = None
    ): FleetLaunchTemplateOverridesRequest =
      FleetLaunchTemplateOverridesRequest
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(maxPrice)(_.maxPrice(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(placement)(_.placement(_))
        .build

    def fleetLaunchTemplateSpecification(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      version: Option[String] = None
    ): FleetLaunchTemplateSpecification =
      FleetLaunchTemplateSpecification
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(version)(_.version(_))
        .build

    def fleetLaunchTemplateSpecificationRequest(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      version: Option[String] = None
    ): FleetLaunchTemplateSpecificationRequest =
      FleetLaunchTemplateSpecificationRequest
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(version)(_.version(_))
        .build

    def fleetSpotCapacityRebalance(
      replacementStrategy: Option[String] = None
    ): FleetSpotCapacityRebalance =
      FleetSpotCapacityRebalance
        .builder
        .ifSome(replacementStrategy)(_.replacementStrategy(_))
        .build

    def fleetSpotCapacityRebalanceRequest(
      replacementStrategy: Option[String] = None
    ): FleetSpotCapacityRebalanceRequest =
      FleetSpotCapacityRebalanceRequest
        .builder
        .ifSome(replacementStrategy)(_.replacementStrategy(_))
        .build

    def fleetSpotMaintenanceStrategies(
      capacityRebalance: Option[FleetSpotCapacityRebalance] = None
    ): FleetSpotMaintenanceStrategies =
      FleetSpotMaintenanceStrategies
        .builder
        .ifSome(capacityRebalance)(_.capacityRebalance(_))
        .build

    def fleetSpotMaintenanceStrategiesRequest(
      capacityRebalance: Option[FleetSpotCapacityRebalanceRequest] = None
    ): FleetSpotMaintenanceStrategiesRequest =
      FleetSpotMaintenanceStrategiesRequest
        .builder
        .ifSome(capacityRebalance)(_.capacityRebalance(_))
        .build

    def flowLog(
      creationTime: Option[MillisecondDateTime] = None,
      deliverLogsErrorMessage: Option[String] = None,
      deliverLogsPermissionArn: Option[String] = None,
      deliverLogsStatus: Option[String] = None,
      flowLogId: Option[String] = None,
      flowLogStatus: Option[String] = None,
      logGroupName: Option[String] = None,
      resourceId: Option[String] = None,
      trafficType: Option[String] = None,
      logDestinationType: Option[String] = None,
      logDestination: Option[String] = None,
      logFormat: Option[String] = None,
      tags: Option[List[Tag]] = None,
      maxAggregationInterval: Option[Int] = None
    ): FlowLog =
      FlowLog
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(deliverLogsErrorMessage)(_.deliverLogsErrorMessage(_))
        .ifSome(deliverLogsPermissionArn)(_.deliverLogsPermissionArn(_))
        .ifSome(deliverLogsStatus)(_.deliverLogsStatus(_))
        .ifSome(flowLogId)(_.flowLogId(_))
        .ifSome(flowLogStatus)(_.flowLogStatus(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(trafficType)(_.trafficType(_))
        .ifSome(logDestinationType)(_.logDestinationType(_))
        .ifSome(logDestination)(_.logDestination(_))
        .ifSome(logFormat)(_.logFormat(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(maxAggregationInterval)(_.maxAggregationInterval(_))
        .build

    def fpgaDeviceInfo(
      name: Option[String] = None,
      manufacturer: Option[String] = None,
      count: Option[Int] = None,
      memoryInfo: Option[FpgaDeviceMemoryInfo] = None
    ): FpgaDeviceInfo =
      FpgaDeviceInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(manufacturer)(_.manufacturer(_))
        .ifSome(count)(_.count(_))
        .ifSome(memoryInfo)(_.memoryInfo(_))
        .build

    def fpgaDeviceMemoryInfo(
      sizeInMiB: Option[Int] = None
    ): FpgaDeviceMemoryInfo =
      FpgaDeviceMemoryInfo
        .builder
        .ifSome(sizeInMiB)(_.sizeInMiB(_))
        .build

    def fpgaImage(
      fpgaImageId: Option[String] = None,
      fpgaImageGlobalId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      shellVersion: Option[String] = None,
      pciId: Option[PciId] = None,
      state: Option[FpgaImageState] = None,
      createTime: Option[DateTime] = None,
      updateTime: Option[DateTime] = None,
      ownerId: Option[String] = None,
      ownerAlias: Option[String] = None,
      productCodes: Option[List[ProductCode]] = None,
      tags: Option[List[Tag]] = None,
      public: Option[Boolean] = None,
      dataRetentionSupport: Option[Boolean] = None
    ): FpgaImage =
      FpgaImage
        .builder
        .ifSome(fpgaImageId)(_.fpgaImageId(_))
        .ifSome(fpgaImageGlobalId)(_.fpgaImageGlobalId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(shellVersion)(_.shellVersion(_))
        .ifSome(pciId)(_.pciId(_))
        .ifSome(state)(_.state(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(ownerAlias)(_.ownerAlias(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(public)(_.public(_))
        .ifSome(dataRetentionSupport)(_.dataRetentionSupport(_))
        .build

    def fpgaImageAttribute(
      fpgaImageId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      loadPermissions: Option[List[LoadPermission]] = None,
      productCodes: Option[List[ProductCode]] = None
    ): FpgaImageAttribute =
      FpgaImageAttribute
        .builder
        .ifSome(fpgaImageId)(_.fpgaImageId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(loadPermissions)(_.loadPermissions(_))
        .ifSome(productCodes)(_.productCodes(_))
        .build

    def fpgaImageState(
      code: Option[String] = None,
      message: Option[String] = None
    ): FpgaImageState =
      FpgaImageState
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def fpgaInfo(
      fpgas: Option[List[FpgaDeviceInfo]] = None,
      totalFpgaMemoryInMiB: Option[Int] = None
    ): FpgaInfo =
      FpgaInfo
        .builder
        .ifSome(fpgas)(_.fpgas(_))
        .ifSome(totalFpgaMemoryInMiB)(_.totalFpgaMemoryInMiB(_))
        .build

    def getAssociatedEnclaveCertificateIamRolesRequest(
      certificateArn: Option[String] = None
    ): GetAssociatedEnclaveCertificateIamRolesRequest =
      GetAssociatedEnclaveCertificateIamRolesRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def getAssociatedIpv6PoolCidrsRequest(
      poolId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetAssociatedIpv6PoolCidrsRequest =
      GetAssociatedIpv6PoolCidrsRequest
        .builder
        .ifSome(poolId)(_.poolId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getCapacityReservationUsageRequest(
      capacityReservationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetCapacityReservationUsageRequest =
      GetCapacityReservationUsageRequest
        .builder
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getCoipPoolUsageRequest(
      poolId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetCoipPoolUsageRequest =
      GetCoipPoolUsageRequest
        .builder
        .ifSome(poolId)(_.poolId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getConsoleOutputRequest(
      instanceId: Option[String] = None,
      latest: Option[Boolean] = None
    ): GetConsoleOutputRequest =
      GetConsoleOutputRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(latest)(_.latest(_))
        .build

    def getConsoleScreenshotRequest(
      instanceId: Option[String] = None,
      wakeUp: Option[Boolean] = None
    ): GetConsoleScreenshotRequest =
      GetConsoleScreenshotRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(wakeUp)(_.wakeUp(_))
        .build

    def getDefaultCreditSpecificationRequest(
      instanceFamily: Option[String] = None
    ): GetDefaultCreditSpecificationRequest =
      GetDefaultCreditSpecificationRequest
        .builder
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .build

    def getEbsDefaultKmsKeyIdRequest(

    ): GetEbsDefaultKmsKeyIdRequest =
      GetEbsDefaultKmsKeyIdRequest
        .builder

        .build

    def getEbsEncryptionByDefaultRequest(

    ): GetEbsEncryptionByDefaultRequest =
      GetEbsEncryptionByDefaultRequest
        .builder

        .build

    def getFlowLogsIntegrationTemplateRequest(
      flowLogId: Option[String] = None,
      configDeliveryS3DestinationArn: Option[String] = None,
      integrateServices: Option[IntegrateServices] = None
    ): GetFlowLogsIntegrationTemplateRequest =
      GetFlowLogsIntegrationTemplateRequest
        .builder
        .ifSome(flowLogId)(_.flowLogId(_))
        .ifSome(configDeliveryS3DestinationArn)(_.configDeliveryS3DestinationArn(_))
        .ifSome(integrateServices)(_.integrateServices(_))
        .build

    def getGroupsForCapacityReservationRequest(
      capacityReservationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetGroupsForCapacityReservationRequest =
      GetGroupsForCapacityReservationRequest
        .builder
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getHostReservationPurchasePreviewRequest(
      hostIdSet: Option[List[DedicatedHostId]] = None,
      offeringId: Option[String] = None
    ): GetHostReservationPurchasePreviewRequest =
      GetHostReservationPurchasePreviewRequest
        .builder
        .ifSome(hostIdSet)(_.hostIdSet(_))
        .ifSome(offeringId)(_.offeringId(_))
        .build

    def getLaunchTemplateDataRequest(
      instanceId: Option[String] = None
    ): GetLaunchTemplateDataRequest =
      GetLaunchTemplateDataRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def getManagedPrefixListAssociationsRequest(
      prefixListId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetManagedPrefixListAssociationsRequest =
      GetManagedPrefixListAssociationsRequest
        .builder
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getManagedPrefixListEntriesRequest(
      prefixListId: Option[String] = None,
      targetVersion: Option[Long] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetManagedPrefixListEntriesRequest =
      GetManagedPrefixListEntriesRequest
        .builder
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(targetVersion)(_.targetVersion(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getPasswordDataRequest(
      instanceId: Option[String] = None
    ): GetPasswordDataRequest =
      GetPasswordDataRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def getReservedInstancesExchangeQuoteRequest(
      reservedInstanceIds: Option[List[ReservationId]] = None,
      targetConfigurations: Option[List[TargetConfigurationRequest]] = None
    ): GetReservedInstancesExchangeQuoteRequest =
      GetReservedInstancesExchangeQuoteRequest
        .builder
        .ifSome(reservedInstanceIds)(_.reservedInstanceIds(_))
        .ifSome(targetConfigurations)(_.targetConfigurations(_))
        .build

    def getSerialConsoleAccessStatusRequest(

    ): GetSerialConsoleAccessStatusRequest =
      GetSerialConsoleAccessStatusRequest
        .builder

        .build

    def getTransitGatewayAttachmentPropagationsRequest(
      transitGatewayAttachmentId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayAttachmentPropagationsRequest =
      GetTransitGatewayAttachmentPropagationsRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayMulticastDomainAssociationsRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayMulticastDomainAssociationsRequest =
      GetTransitGatewayMulticastDomainAssociationsRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayPrefixListReferencesRequest(
      transitGatewayRouteTableId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayPrefixListReferencesRequest =
      GetTransitGatewayPrefixListReferencesRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayRouteTableAssociationsRequest(
      transitGatewayRouteTableId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayRouteTableAssociationsRequest =
      GetTransitGatewayRouteTableAssociationsRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTransitGatewayRouteTablePropagationsRequest(
      transitGatewayRouteTableId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTransitGatewayRouteTablePropagationsRequest =
      GetTransitGatewayRouteTablePropagationsRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def gpuDeviceInfo(
      name: Option[String] = None,
      manufacturer: Option[String] = None,
      count: Option[Int] = None,
      memoryInfo: Option[GpuDeviceMemoryInfo] = None
    ): GpuDeviceInfo =
      GpuDeviceInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(manufacturer)(_.manufacturer(_))
        .ifSome(count)(_.count(_))
        .ifSome(memoryInfo)(_.memoryInfo(_))
        .build

    def gpuDeviceMemoryInfo(
      sizeInMiB: Option[Int] = None
    ): GpuDeviceMemoryInfo =
      GpuDeviceMemoryInfo
        .builder
        .ifSome(sizeInMiB)(_.sizeInMiB(_))
        .build

    def gpuInfo(
      gpus: Option[List[GpuDeviceInfo]] = None,
      totalGpuMemoryInMiB: Option[Int] = None
    ): GpuInfo =
      GpuInfo
        .builder
        .ifSome(gpus)(_.gpus(_))
        .ifSome(totalGpuMemoryInMiB)(_.totalGpuMemoryInMiB(_))
        .build

    def groupIdentifier(
      groupName: Option[String] = None,
      groupId: Option[String] = None
    ): GroupIdentifier =
      GroupIdentifier
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def hibernationOptions(
      configured: Option[Boolean] = None
    ): HibernationOptions =
      HibernationOptions
        .builder
        .ifSome(configured)(_.configured(_))
        .build

    def hibernationOptionsRequest(
      configured: Option[Boolean] = None
    ): HibernationOptionsRequest =
      HibernationOptionsRequest
        .builder
        .ifSome(configured)(_.configured(_))
        .build

    def historyRecord(
      eventInformation: Option[EventInformation] = None,
      eventType: Option[String] = None,
      timestamp: Option[DateTime] = None
    ): HistoryRecord =
      HistoryRecord
        .builder
        .ifSome(eventInformation)(_.eventInformation(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def historyRecordEntry(
      eventInformation: Option[EventInformation] = None,
      eventType: Option[String] = None,
      timestamp: Option[DateTime] = None
    ): HistoryRecordEntry =
      HistoryRecordEntry
        .builder
        .ifSome(eventInformation)(_.eventInformation(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def host(
      autoPlacement: Option[String] = None,
      availabilityZone: Option[String] = None,
      availableCapacity: Option[AvailableCapacity] = None,
      clientToken: Option[String] = None,
      hostId: Option[String] = None,
      hostProperties: Option[HostProperties] = None,
      hostReservationId: Option[String] = None,
      instances: Option[List[HostInstance]] = None,
      state: Option[String] = None,
      allocationTime: Option[DateTime] = None,
      releaseTime: Option[DateTime] = None,
      tags: Option[List[Tag]] = None,
      hostRecovery: Option[String] = None,
      allowsMultipleInstanceTypes: Option[String] = None,
      ownerId: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      memberOfServiceLinkedResourceGroup: Option[Boolean] = None
    ): Host =
      Host
        .builder
        .ifSome(autoPlacement)(_.autoPlacement(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availableCapacity)(_.availableCapacity(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(hostId)(_.hostId(_))
        .ifSome(hostProperties)(_.hostProperties(_))
        .ifSome(hostReservationId)(_.hostReservationId(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(state)(_.state(_))
        .ifSome(allocationTime)(_.allocationTime(_))
        .ifSome(releaseTime)(_.releaseTime(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(hostRecovery)(_.hostRecovery(_))
        .ifSome(allowsMultipleInstanceTypes)(_.allowsMultipleInstanceTypes(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(memberOfServiceLinkedResourceGroup)(_.memberOfServiceLinkedResourceGroup(_))
        .build

    def hostInstance(
      instanceId: Option[String] = None,
      instanceType: Option[String] = None,
      ownerId: Option[String] = None
    ): HostInstance =
      HostInstance
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(ownerId)(_.ownerId(_))
        .build

    def hostOffering(
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      hourlyPrice: Option[String] = None,
      instanceFamily: Option[String] = None,
      offeringId: Option[String] = None,
      paymentOption: Option[String] = None,
      upfrontPrice: Option[String] = None
    ): HostOffering =
      HostOffering
        .builder
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(hourlyPrice)(_.hourlyPrice(_))
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(upfrontPrice)(_.upfrontPrice(_))
        .build

    def hostProperties(
      cores: Option[Int] = None,
      instanceType: Option[String] = None,
      instanceFamily: Option[String] = None,
      sockets: Option[Int] = None,
      totalVCpus: Option[Int] = None
    ): HostProperties =
      HostProperties
        .builder
        .ifSome(cores)(_.cores(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(sockets)(_.sockets(_))
        .ifSome(totalVCpus)(_.totalVCpus(_))
        .build

    def hostReservation(
      count: Option[Int] = None,
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      end: Option[DateTime] = None,
      hostIdSet: Option[List[String]] = None,
      hostReservationId: Option[String] = None,
      hourlyPrice: Option[String] = None,
      instanceFamily: Option[String] = None,
      offeringId: Option[String] = None,
      paymentOption: Option[String] = None,
      start: Option[DateTime] = None,
      state: Option[String] = None,
      upfrontPrice: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): HostReservation =
      HostReservation
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(end)(_.end(_))
        .ifSome(hostIdSet)(_.hostIdSet(_))
        .ifSome(hostReservationId)(_.hostReservationId(_))
        .ifSome(hourlyPrice)(_.hourlyPrice(_))
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(start)(_.start(_))
        .ifSome(state)(_.state(_))
        .ifSome(upfrontPrice)(_.upfrontPrice(_))
        .ifSome(tags)(_.tags(_))
        .build

    def iKEVersionsListValue(
      value: Option[String] = None
    ): IKEVersionsListValue =
      IKEVersionsListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def iKEVersionsRequestListValue(
      value: Option[String] = None
    ): IKEVersionsRequestListValue =
      IKEVersionsRequestListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def iamInstanceProfile(
      arn: Option[String] = None,
      id: Option[String] = None
    ): IamInstanceProfile =
      IamInstanceProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def iamInstanceProfileAssociation(
      associationId: Option[String] = None,
      instanceId: Option[String] = None,
      iamInstanceProfile: Option[IamInstanceProfile] = None,
      state: Option[String] = None,
      timestamp: Option[DateTime] = None
    ): IamInstanceProfileAssociation =
      IamInstanceProfileAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(state)(_.state(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def iamInstanceProfileSpecification(
      arn: Option[String] = None,
      name: Option[String] = None
    ): IamInstanceProfileSpecification =
      IamInstanceProfileSpecification
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def icmpTypeCode(
      code: Option[Int] = None,
      `type`: Option[Int] = None
    ): IcmpTypeCode =
      IcmpTypeCode
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def idFormat(
      deadline: Option[DateTime] = None,
      resource: Option[String] = None,
      useLongIds: Option[Boolean] = None
    ): IdFormat =
      IdFormat
        .builder
        .ifSome(deadline)(_.deadline(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(useLongIds)(_.useLongIds(_))
        .build

    def image(
      architecture: Option[String] = None,
      creationDate: Option[String] = None,
      imageId: Option[String] = None,
      imageLocation: Option[String] = None,
      imageType: Option[String] = None,
      public: Option[Boolean] = None,
      kernelId: Option[String] = None,
      ownerId: Option[String] = None,
      platform: Option[String] = None,
      platformDetails: Option[String] = None,
      usageOperation: Option[String] = None,
      productCodes: Option[List[ProductCode]] = None,
      ramdiskId: Option[String] = None,
      state: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      description: Option[String] = None,
      enaSupport: Option[Boolean] = None,
      hypervisor: Option[String] = None,
      imageOwnerAlias: Option[String] = None,
      name: Option[String] = None,
      rootDeviceName: Option[String] = None,
      rootDeviceType: Option[String] = None,
      sriovNetSupport: Option[String] = None,
      stateReason: Option[StateReason] = None,
      tags: Option[List[Tag]] = None,
      virtualizationType: Option[String] = None,
      bootMode: Option[String] = None,
      deprecationTime: Option[String] = None
    ): Image =
      Image
        .builder
        .ifSome(architecture)(_.architecture(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(imageLocation)(_.imageLocation(_))
        .ifSome(imageType)(_.imageType(_))
        .ifSome(public)(_.public(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(platformDetails)(_.platformDetails(_))
        .ifSome(usageOperation)(_.usageOperation(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(state)(_.state(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(description)(_.description(_))
        .ifSome(enaSupport)(_.enaSupport(_))
        .ifSome(hypervisor)(_.hypervisor(_))
        .ifSome(imageOwnerAlias)(_.imageOwnerAlias(_))
        .ifSome(name)(_.name(_))
        .ifSome(rootDeviceName)(_.rootDeviceName(_))
        .ifSome(rootDeviceType)(_.rootDeviceType(_))
        .ifSome(sriovNetSupport)(_.sriovNetSupport(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualizationType)(_.virtualizationType(_))
        .ifSome(bootMode)(_.bootMode(_))
        .ifSome(deprecationTime)(_.deprecationTime(_))
        .build

    def imageAttribute(
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      imageId: Option[String] = None,
      launchPermissions: Option[List[LaunchPermission]] = None,
      productCodes: Option[List[ProductCode]] = None,
      description: Option[AttributeValue] = None,
      kernelId: Option[AttributeValue] = None,
      ramdiskId: Option[AttributeValue] = None,
      sriovNetSupport: Option[AttributeValue] = None,
      bootMode: Option[AttributeValue] = None
    ): ImageAttribute =
      ImageAttribute
        .builder
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(launchPermissions)(_.launchPermissions(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(description)(_.description(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(sriovNetSupport)(_.sriovNetSupport(_))
        .ifSome(bootMode)(_.bootMode(_))
        .build

    def imageDiskContainer(
      description: Option[String] = None,
      deviceName: Option[String] = None,
      format: Option[String] = None,
      snapshotId: Option[String] = None,
      url: Option[String] = None,
      userBucket: Option[UserBucket] = None
    ): ImageDiskContainer =
      ImageDiskContainer
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(format)(_.format(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(url)(_.url(_))
        .ifSome(userBucket)(_.userBucket(_))
        .build

    def importClientVpnClientCertificateRevocationListRequest(
      clientVpnEndpointId: Option[String] = None,
      certificateRevocationList: Option[String] = None
    ): ImportClientVpnClientCertificateRevocationListRequest =
      ImportClientVpnClientCertificateRevocationListRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(certificateRevocationList)(_.certificateRevocationList(_))
        .build

    def importImageLicenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None
    ): ImportImageLicenseConfigurationRequest =
      ImportImageLicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def importImageLicenseConfigurationResponse(
      licenseConfigurationArn: Option[String] = None
    ): ImportImageLicenseConfigurationResponse =
      ImportImageLicenseConfigurationResponse
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def importImageRequest(
      architecture: Option[String] = None,
      clientData: Option[ClientData] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None,
      diskContainers: Option[List[ImageDiskContainer]] = None,
      encrypted: Option[Boolean] = None,
      hypervisor: Option[String] = None,
      kmsKeyId: Option[String] = None,
      licenseType: Option[String] = None,
      platform: Option[String] = None,
      roleName: Option[String] = None,
      licenseSpecifications: Option[List[ImportImageLicenseConfigurationRequest]] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): ImportImageRequest =
      ImportImageRequest
        .builder
        .ifSome(architecture)(_.architecture(_))
        .ifSome(clientData)(_.clientData(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(diskContainers)(_.diskContainers(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(hypervisor)(_.hypervisor(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(licenseSpecifications)(_.licenseSpecifications(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def importImageTask(
      architecture: Option[String] = None,
      description: Option[String] = None,
      encrypted: Option[Boolean] = None,
      hypervisor: Option[String] = None,
      imageId: Option[String] = None,
      importTaskId: Option[String] = None,
      kmsKeyId: Option[String] = None,
      licenseType: Option[String] = None,
      platform: Option[String] = None,
      progress: Option[String] = None,
      snapshotDetails: Option[List[SnapshotDetail]] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      tags: Option[List[Tag]] = None,
      licenseSpecifications: Option[List[ImportImageLicenseConfigurationResponse]] = None
    ): ImportImageTask =
      ImportImageTask
        .builder
        .ifSome(architecture)(_.architecture(_))
        .ifSome(description)(_.description(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(hypervisor)(_.hypervisor(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(importTaskId)(_.importTaskId(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(snapshotDetails)(_.snapshotDetails(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(licenseSpecifications)(_.licenseSpecifications(_))
        .build

    def importInstanceLaunchSpecification(
      additionalInfo: Option[String] = None,
      architecture: Option[String] = None,
      groupIds: Option[List[SecurityGroupId]] = None,
      groupNames: Option[List[SecurityGroupName]] = None,
      instanceInitiatedShutdownBehavior: Option[String] = None,
      instanceType: Option[String] = None,
      monitoring: Option[Boolean] = None,
      placement: Option[Placement] = None,
      privateIpAddress: Option[String] = None,
      subnetId: Option[String] = None,
      userData: Option[UserData] = None
    ): ImportInstanceLaunchSpecification =
      ImportInstanceLaunchSpecification
        .builder
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(groupIds)(_.groupIds(_))
        .ifSome(groupNames)(_.groupNames(_))
        .ifSome(instanceInitiatedShutdownBehavior)(_.instanceInitiatedShutdownBehavior(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(userData)(_.userData(_))
        .build

    def importInstanceRequest(
      description: Option[String] = None,
      diskImages: Option[List[DiskImage]] = None,
      launchSpecification: Option[ImportInstanceLaunchSpecification] = None,
      platform: Option[String] = None
    ): ImportInstanceRequest =
      ImportInstanceRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(diskImages)(_.diskImages(_))
        .ifSome(launchSpecification)(_.launchSpecification(_))
        .ifSome(platform)(_.platform(_))
        .build

    def importInstanceTaskDetails(
      description: Option[String] = None,
      instanceId: Option[String] = None,
      platform: Option[String] = None,
      volumes: Option[List[ImportInstanceVolumeDetailItem]] = None
    ): ImportInstanceTaskDetails =
      ImportInstanceTaskDetails
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(volumes)(_.volumes(_))
        .build

    def importInstanceVolumeDetailItem(
      availabilityZone: Option[String] = None,
      bytesConverted: Option[Long] = None,
      description: Option[String] = None,
      image: Option[DiskImageDescription] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      volume: Option[DiskImageVolumeDescription] = None
    ): ImportInstanceVolumeDetailItem =
      ImportInstanceVolumeDetailItem
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(bytesConverted)(_.bytesConverted(_))
        .ifSome(description)(_.description(_))
        .ifSome(image)(_.image(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(volume)(_.volume(_))
        .build

    def importKeyPairRequest(
      keyName: Option[String] = None,
      publicKeyMaterial: Option[Blob] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): ImportKeyPairRequest =
      ImportKeyPairRequest
        .builder
        .ifSome(keyName)(_.keyName(_))
        .ifSome(publicKeyMaterial)(_.publicKeyMaterial(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def importSnapshotRequest(
      clientData: Option[ClientData] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None,
      diskContainer: Option[SnapshotDiskContainer] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      roleName: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): ImportSnapshotRequest =
      ImportSnapshotRequest
        .builder
        .ifSome(clientData)(_.clientData(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(diskContainer)(_.diskContainer(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def importSnapshotTask(
      description: Option[String] = None,
      importTaskId: Option[String] = None,
      snapshotTaskDetail: Option[SnapshotTaskDetail] = None,
      tags: Option[List[Tag]] = None
    ): ImportSnapshotTask =
      ImportSnapshotTask
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(importTaskId)(_.importTaskId(_))
        .ifSome(snapshotTaskDetail)(_.snapshotTaskDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def importVolumeRequest(
      availabilityZone: Option[String] = None,
      description: Option[String] = None,
      image: Option[DiskImageDetail] = None,
      volume: Option[VolumeDetail] = None
    ): ImportVolumeRequest =
      ImportVolumeRequest
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(description)(_.description(_))
        .ifSome(image)(_.image(_))
        .ifSome(volume)(_.volume(_))
        .build

    def importVolumeTaskDetails(
      availabilityZone: Option[String] = None,
      bytesConverted: Option[Long] = None,
      description: Option[String] = None,
      image: Option[DiskImageDescription] = None,
      volume: Option[DiskImageVolumeDescription] = None
    ): ImportVolumeTaskDetails =
      ImportVolumeTaskDetails
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(bytesConverted)(_.bytesConverted(_))
        .ifSome(description)(_.description(_))
        .ifSome(image)(_.image(_))
        .ifSome(volume)(_.volume(_))
        .build

    def inferenceAcceleratorInfo(
      accelerators: Option[List[InferenceDeviceInfo]] = None
    ): InferenceAcceleratorInfo =
      InferenceAcceleratorInfo
        .builder
        .ifSome(accelerators)(_.accelerators(_))
        .build

    def inferenceDeviceInfo(
      count: Option[Int] = None,
      name: Option[String] = None,
      manufacturer: Option[String] = None
    ): InferenceDeviceInfo =
      InferenceDeviceInfo
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(name)(_.name(_))
        .ifSome(manufacturer)(_.manufacturer(_))
        .build

    def instance(
      amiLaunchIndex: Option[Int] = None,
      imageId: Option[String] = None,
      instanceId: Option[String] = None,
      instanceType: Option[String] = None,
      kernelId: Option[String] = None,
      keyName: Option[String] = None,
      launchTime: Option[DateTime] = None,
      monitoring: Option[Monitoring] = None,
      placement: Option[Placement] = None,
      platform: Option[String] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None,
      productCodes: Option[List[ProductCode]] = None,
      publicDnsName: Option[String] = None,
      publicIpAddress: Option[String] = None,
      ramdiskId: Option[String] = None,
      state: Option[InstanceState] = None,
      stateTransitionReason: Option[String] = None,
      subnetId: Option[String] = None,
      vpcId: Option[String] = None,
      architecture: Option[String] = None,
      blockDeviceMappings: Option[List[InstanceBlockDeviceMapping]] = None,
      clientToken: Option[String] = None,
      ebsOptimized: Option[Boolean] = None,
      enaSupport: Option[Boolean] = None,
      hypervisor: Option[String] = None,
      iamInstanceProfile: Option[IamInstanceProfile] = None,
      instanceLifecycle: Option[String] = None,
      elasticGpuAssociations: Option[List[ElasticGpuAssociation]] = None,
      elasticInferenceAcceleratorAssociations: Option[List[ElasticInferenceAcceleratorAssociation]] = None,
      networkInterfaces: Option[List[InstanceNetworkInterface]] = None,
      outpostArn: Option[String] = None,
      rootDeviceName: Option[String] = None,
      rootDeviceType: Option[String] = None,
      securityGroups: Option[List[GroupIdentifier]] = None,
      sourceDestCheck: Option[Boolean] = None,
      spotInstanceRequestId: Option[String] = None,
      sriovNetSupport: Option[String] = None,
      stateReason: Option[StateReason] = None,
      tags: Option[List[Tag]] = None,
      virtualizationType: Option[String] = None,
      cpuOptions: Option[CpuOptions] = None,
      capacityReservationId: Option[String] = None,
      capacityReservationSpecification: Option[CapacityReservationSpecificationResponse] = None,
      hibernationOptions: Option[HibernationOptions] = None,
      licenses: Option[List[LicenseConfiguration]] = None,
      metadataOptions: Option[InstanceMetadataOptionsResponse] = None,
      enclaveOptions: Option[EnclaveOptions] = None,
      bootMode: Option[String] = None
    ): Instance =
      Instance
        .builder
        .ifSome(amiLaunchIndex)(_.amiLaunchIndex(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(launchTime)(_.launchTime(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(publicDnsName)(_.publicDnsName(_))
        .ifSome(publicIpAddress)(_.publicIpAddress(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateTransitionReason)(_.stateTransitionReason(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(enaSupport)(_.enaSupport(_))
        .ifSome(hypervisor)(_.hypervisor(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(instanceLifecycle)(_.instanceLifecycle(_))
        .ifSome(elasticGpuAssociations)(_.elasticGpuAssociations(_))
        .ifSome(elasticInferenceAcceleratorAssociations)(_.elasticInferenceAcceleratorAssociations(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(rootDeviceName)(_.rootDeviceName(_))
        .ifSome(rootDeviceType)(_.rootDeviceType(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .ifSome(spotInstanceRequestId)(_.spotInstanceRequestId(_))
        .ifSome(sriovNetSupport)(_.sriovNetSupport(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualizationType)(_.virtualizationType(_))
        .ifSome(cpuOptions)(_.cpuOptions(_))
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .ifSome(capacityReservationSpecification)(_.capacityReservationSpecification(_))
        .ifSome(hibernationOptions)(_.hibernationOptions(_))
        .ifSome(licenses)(_.licenses(_))
        .ifSome(metadataOptions)(_.metadataOptions(_))
        .ifSome(enclaveOptions)(_.enclaveOptions(_))
        .ifSome(bootMode)(_.bootMode(_))
        .build

    def instanceAttribute(
      groups: Option[List[GroupIdentifier]] = None,
      blockDeviceMappings: Option[List[InstanceBlockDeviceMapping]] = None,
      disableApiTermination: Option[AttributeBooleanValue] = None,
      enaSupport: Option[AttributeBooleanValue] = None,
      enclaveOptions: Option[EnclaveOptions] = None,
      ebsOptimized: Option[AttributeBooleanValue] = None,
      instanceId: Option[String] = None,
      instanceInitiatedShutdownBehavior: Option[AttributeValue] = None,
      instanceType: Option[AttributeValue] = None,
      kernelId: Option[AttributeValue] = None,
      productCodes: Option[List[ProductCode]] = None,
      ramdiskId: Option[AttributeValue] = None,
      rootDeviceName: Option[AttributeValue] = None,
      sourceDestCheck: Option[AttributeBooleanValue] = None,
      sriovNetSupport: Option[AttributeValue] = None,
      userData: Option[AttributeValue] = None
    ): InstanceAttribute =
      InstanceAttribute
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(disableApiTermination)(_.disableApiTermination(_))
        .ifSome(enaSupport)(_.enaSupport(_))
        .ifSome(enclaveOptions)(_.enclaveOptions(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceInitiatedShutdownBehavior)(_.instanceInitiatedShutdownBehavior(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(rootDeviceName)(_.rootDeviceName(_))
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .ifSome(sriovNetSupport)(_.sriovNetSupport(_))
        .ifSome(userData)(_.userData(_))
        .build

    def instanceBlockDeviceMapping(
      deviceName: Option[String] = None,
      ebs: Option[EbsInstanceBlockDevice] = None
    ): InstanceBlockDeviceMapping =
      InstanceBlockDeviceMapping
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(ebs)(_.ebs(_))
        .build

    def instanceBlockDeviceMappingSpecification(
      deviceName: Option[String] = None,
      ebs: Option[EbsInstanceBlockDeviceSpecification] = None,
      noDevice: Option[String] = None,
      virtualName: Option[String] = None
    ): InstanceBlockDeviceMappingSpecification =
      InstanceBlockDeviceMappingSpecification
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(ebs)(_.ebs(_))
        .ifSome(noDevice)(_.noDevice(_))
        .ifSome(virtualName)(_.virtualName(_))
        .build

    def instanceCapacity(
      availableCapacity: Option[Int] = None,
      instanceType: Option[String] = None,
      totalCapacity: Option[Int] = None
    ): InstanceCapacity =
      InstanceCapacity
        .builder
        .ifSome(availableCapacity)(_.availableCapacity(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(totalCapacity)(_.totalCapacity(_))
        .build

    def instanceCount(
      instanceCount: Option[Int] = None,
      state: Option[String] = None
    ): InstanceCount =
      InstanceCount
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(state)(_.state(_))
        .build

    def instanceCreditSpecification(
      instanceId: Option[String] = None,
      cpuCredits: Option[String] = None
    ): InstanceCreditSpecification =
      InstanceCreditSpecification
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(cpuCredits)(_.cpuCredits(_))
        .build

    def instanceCreditSpecificationRequest(
      instanceId: Option[String] = None,
      cpuCredits: Option[String] = None
    ): InstanceCreditSpecificationRequest =
      InstanceCreditSpecificationRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(cpuCredits)(_.cpuCredits(_))
        .build

    def instanceExportDetails(
      instanceId: Option[String] = None,
      targetEnvironment: Option[String] = None
    ): InstanceExportDetails =
      InstanceExportDetails
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(targetEnvironment)(_.targetEnvironment(_))
        .build

    def instanceFamilyCreditSpecification(
      instanceFamily: Option[String] = None,
      cpuCredits: Option[String] = None
    ): InstanceFamilyCreditSpecification =
      InstanceFamilyCreditSpecification
        .builder
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(cpuCredits)(_.cpuCredits(_))
        .build

    def instanceIpv6Address(
      ipv6Address: Option[String] = None
    ): InstanceIpv6Address =
      InstanceIpv6Address
        .builder
        .ifSome(ipv6Address)(_.ipv6Address(_))
        .build

    def instanceIpv6AddressRequest(
      ipv6Address: Option[String] = None
    ): InstanceIpv6AddressRequest =
      InstanceIpv6AddressRequest
        .builder
        .ifSome(ipv6Address)(_.ipv6Address(_))
        .build

    def instanceMarketOptionsRequest(
      marketType: Option[String] = None,
      spotOptions: Option[SpotMarketOptions] = None
    ): InstanceMarketOptionsRequest =
      InstanceMarketOptionsRequest
        .builder
        .ifSome(marketType)(_.marketType(_))
        .ifSome(spotOptions)(_.spotOptions(_))
        .build

    def instanceMetadataOptionsRequest(
      httpTokens: Option[String] = None,
      httpPutResponseHopLimit: Option[Int] = None,
      httpEndpoint: Option[String] = None
    ): InstanceMetadataOptionsRequest =
      InstanceMetadataOptionsRequest
        .builder
        .ifSome(httpTokens)(_.httpTokens(_))
        .ifSome(httpPutResponseHopLimit)(_.httpPutResponseHopLimit(_))
        .ifSome(httpEndpoint)(_.httpEndpoint(_))
        .build

    def instanceMetadataOptionsResponse(
      state: Option[String] = None,
      httpTokens: Option[String] = None,
      httpPutResponseHopLimit: Option[Int] = None,
      httpEndpoint: Option[String] = None
    ): InstanceMetadataOptionsResponse =
      InstanceMetadataOptionsResponse
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(httpTokens)(_.httpTokens(_))
        .ifSome(httpPutResponseHopLimit)(_.httpPutResponseHopLimit(_))
        .ifSome(httpEndpoint)(_.httpEndpoint(_))
        .build

    def instanceMonitoring(
      instanceId: Option[String] = None,
      monitoring: Option[Monitoring] = None
    ): InstanceMonitoring =
      InstanceMonitoring
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(monitoring)(_.monitoring(_))
        .build

    def instanceNetworkInterface(
      association: Option[InstanceNetworkInterfaceAssociation] = None,
      attachment: Option[InstanceNetworkInterfaceAttachment] = None,
      description: Option[String] = None,
      groups: Option[List[GroupIdentifier]] = None,
      ipv6Addresses: Option[List[InstanceIpv6Address]] = None,
      macAddress: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      ownerId: Option[String] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[InstancePrivateIpAddress]] = None,
      sourceDestCheck: Option[Boolean] = None,
      status: Option[String] = None,
      subnetId: Option[String] = None,
      vpcId: Option[String] = None,
      interfaceType: Option[String] = None
    ): InstanceNetworkInterface =
      InstanceNetworkInterface
        .builder
        .ifSome(association)(_.association(_))
        .ifSome(attachment)(_.attachment(_))
        .ifSome(description)(_.description(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .ifSome(status)(_.status(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(interfaceType)(_.interfaceType(_))
        .build

    def instanceNetworkInterfaceAssociation(
      carrierIp: Option[String] = None,
      ipOwnerId: Option[String] = None,
      publicDnsName: Option[String] = None,
      publicIp: Option[String] = None
    ): InstanceNetworkInterfaceAssociation =
      InstanceNetworkInterfaceAssociation
        .builder
        .ifSome(carrierIp)(_.carrierIp(_))
        .ifSome(ipOwnerId)(_.ipOwnerId(_))
        .ifSome(publicDnsName)(_.publicDnsName(_))
        .ifSome(publicIp)(_.publicIp(_))
        .build

    def instanceNetworkInterfaceAttachment(
      attachTime: Option[DateTime] = None,
      attachmentId: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None,
      deviceIndex: Option[Int] = None,
      status: Option[String] = None,
      networkCardIndex: Option[Int] = None
    ): InstanceNetworkInterfaceAttachment =
      InstanceNetworkInterfaceAttachment
        .builder
        .ifSome(attachTime)(_.attachTime(_))
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(status)(_.status(_))
        .ifSome(networkCardIndex)(_.networkCardIndex(_))
        .build

    def instanceNetworkInterfaceSpecification(
      associatePublicIpAddress: Option[Boolean] = None,
      deleteOnTermination: Option[Boolean] = None,
      description: Option[String] = None,
      deviceIndex: Option[Int] = None,
      groups: Option[List[SecurityGroupId]] = None,
      ipv6AddressCount: Option[Int] = None,
      ipv6Addresses: Option[List[InstanceIpv6Address]] = None,
      networkInterfaceId: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[PrivateIpAddressSpecification]] = None,
      secondaryPrivateIpAddressCount: Option[Int] = None,
      subnetId: Option[String] = None,
      associateCarrierIpAddress: Option[Boolean] = None,
      interfaceType: Option[String] = None,
      networkCardIndex: Option[Int] = None
    ): InstanceNetworkInterfaceSpecification =
      InstanceNetworkInterfaceSpecification
        .builder
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(description)(_.description(_))
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(ipv6AddressCount)(_.ipv6AddressCount(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(secondaryPrivateIpAddressCount)(_.secondaryPrivateIpAddressCount(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(associateCarrierIpAddress)(_.associateCarrierIpAddress(_))
        .ifSome(interfaceType)(_.interfaceType(_))
        .ifSome(networkCardIndex)(_.networkCardIndex(_))
        .build

    def instancePrivateIpAddress(
      association: Option[InstanceNetworkInterfaceAssociation] = None,
      primary: Option[Boolean] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None
    ): InstancePrivateIpAddress =
      InstancePrivateIpAddress
        .builder
        .ifSome(association)(_.association(_))
        .ifSome(primary)(_.primary(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def instanceSpecification(
      instanceId: Option[String] = None,
      excludeBootVolume: Option[Boolean] = None
    ): InstanceSpecification =
      InstanceSpecification
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(excludeBootVolume)(_.excludeBootVolume(_))
        .build

    def instanceState(
      code: Option[Int] = None,
      name: Option[String] = None
    ): InstanceState =
      InstanceState
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(name)(_.name(_))
        .build

    def instanceStateChange(
      currentState: Option[InstanceState] = None,
      instanceId: Option[String] = None,
      previousState: Option[InstanceState] = None
    ): InstanceStateChange =
      InstanceStateChange
        .builder
        .ifSome(currentState)(_.currentState(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(previousState)(_.previousState(_))
        .build

    def instanceStatus(
      availabilityZone: Option[String] = None,
      outpostArn: Option[String] = None,
      events: Option[List[InstanceStatusEvent]] = None,
      instanceId: Option[String] = None,
      instanceState: Option[InstanceState] = None,
      instanceStatus: Option[InstanceStatusSummary] = None,
      systemStatus: Option[InstanceStatusSummary] = None
    ): InstanceStatus =
      InstanceStatus
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(events)(_.events(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceState)(_.instanceState(_))
        .ifSome(instanceStatus)(_.instanceStatus(_))
        .ifSome(systemStatus)(_.systemStatus(_))
        .build

    def instanceStatusDetails(
      impairedSince: Option[DateTime] = None,
      name: Option[String] = None,
      status: Option[String] = None
    ): InstanceStatusDetails =
      InstanceStatusDetails
        .builder
        .ifSome(impairedSince)(_.impairedSince(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def instanceStatusEvent(
      instanceEventId: Option[String] = None,
      code: Option[String] = None,
      description: Option[String] = None,
      notAfter: Option[DateTime] = None,
      notBefore: Option[DateTime] = None,
      notBeforeDeadline: Option[DateTime] = None
    ): InstanceStatusEvent =
      InstanceStatusEvent
        .builder
        .ifSome(instanceEventId)(_.instanceEventId(_))
        .ifSome(code)(_.code(_))
        .ifSome(description)(_.description(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(notBeforeDeadline)(_.notBeforeDeadline(_))
        .build

    def instanceStatusSummary(
      details: Option[List[InstanceStatusDetails]] = None,
      status: Option[String] = None
    ): InstanceStatusSummary =
      InstanceStatusSummary
        .builder
        .ifSome(details)(_.details(_))
        .ifSome(status)(_.status(_))
        .build

    def instanceStorageInfo(
      totalSizeInGB: Option[DiskSize] = None,
      disks: Option[List[DiskInfo]] = None,
      nvmeSupport: Option[String] = None
    ): InstanceStorageInfo =
      InstanceStorageInfo
        .builder
        .ifSome(totalSizeInGB)(_.totalSizeInGB(_))
        .ifSome(disks)(_.disks(_))
        .ifSome(nvmeSupport)(_.nvmeSupport(_))
        .build

    def instanceTagNotificationAttribute(
      instanceTagKeys: Option[List[String]] = None,
      includeAllTagsOfInstance: Option[Boolean] = None
    ): InstanceTagNotificationAttribute =
      InstanceTagNotificationAttribute
        .builder
        .ifSome(instanceTagKeys)(_.instanceTagKeys(_))
        .ifSome(includeAllTagsOfInstance)(_.includeAllTagsOfInstance(_))
        .build

    def instanceTypeInfo(
      instanceType: Option[String] = None,
      currentGeneration: Option[Boolean] = None,
      freeTierEligible: Option[Boolean] = None,
      supportedUsageClasses: Option[List[UsageClassType]] = None,
      supportedRootDeviceTypes: Option[List[RootDeviceType]] = None,
      supportedVirtualizationTypes: Option[List[VirtualizationType]] = None,
      bareMetal: Option[Boolean] = None,
      hypervisor: Option[String] = None,
      processorInfo: Option[ProcessorInfo] = None,
      vCpuInfo: Option[VCpuInfo] = None,
      memoryInfo: Option[MemoryInfo] = None,
      instanceStorageSupported: Option[Boolean] = None,
      instanceStorageInfo: Option[InstanceStorageInfo] = None,
      ebsInfo: Option[EbsInfo] = None,
      networkInfo: Option[NetworkInfo] = None,
      gpuInfo: Option[GpuInfo] = None,
      fpgaInfo: Option[FpgaInfo] = None,
      placementGroupInfo: Option[PlacementGroupInfo] = None,
      inferenceAcceleratorInfo: Option[InferenceAcceleratorInfo] = None,
      hibernationSupported: Option[Boolean] = None,
      burstablePerformanceSupported: Option[Boolean] = None,
      dedicatedHostsSupported: Option[Boolean] = None,
      autoRecoverySupported: Option[Boolean] = None,
      supportedBootModes: Option[List[BootModeType]] = None
    ): InstanceTypeInfo =
      InstanceTypeInfo
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(currentGeneration)(_.currentGeneration(_))
        .ifSome(freeTierEligible)(_.freeTierEligible(_))
        .ifSome(supportedUsageClasses)(_.supportedUsageClasses(_))
        .ifSome(supportedRootDeviceTypes)(_.supportedRootDeviceTypes(_))
        .ifSome(supportedVirtualizationTypes)(_.supportedVirtualizationTypes(_))
        .ifSome(bareMetal)(_.bareMetal(_))
        .ifSome(hypervisor)(_.hypervisor(_))
        .ifSome(processorInfo)(_.processorInfo(_))
        .ifSome(vCpuInfo)(_.vCpuInfo(_))
        .ifSome(memoryInfo)(_.memoryInfo(_))
        .ifSome(instanceStorageSupported)(_.instanceStorageSupported(_))
        .ifSome(instanceStorageInfo)(_.instanceStorageInfo(_))
        .ifSome(ebsInfo)(_.ebsInfo(_))
        .ifSome(networkInfo)(_.networkInfo(_))
        .ifSome(gpuInfo)(_.gpuInfo(_))
        .ifSome(fpgaInfo)(_.fpgaInfo(_))
        .ifSome(placementGroupInfo)(_.placementGroupInfo(_))
        .ifSome(inferenceAcceleratorInfo)(_.inferenceAcceleratorInfo(_))
        .ifSome(hibernationSupported)(_.hibernationSupported(_))
        .ifSome(burstablePerformanceSupported)(_.burstablePerformanceSupported(_))
        .ifSome(dedicatedHostsSupported)(_.dedicatedHostsSupported(_))
        .ifSome(autoRecoverySupported)(_.autoRecoverySupported(_))
        .ifSome(supportedBootModes)(_.supportedBootModes(_))
        .build

    def instanceTypeOffering(
      instanceType: Option[String] = None,
      locationType: Option[String] = None,
      location: Option[String] = None
    ): InstanceTypeOffering =
      InstanceTypeOffering
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(locationType)(_.locationType(_))
        .ifSome(location)(_.location(_))
        .build

    def instanceUsage(
      accountId: Option[String] = None,
      usedInstanceCount: Option[Int] = None
    ): InstanceUsage =
      InstanceUsage
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(usedInstanceCount)(_.usedInstanceCount(_))
        .build

    def integrateServices(
      athenaIntegrations: Option[List[AthenaIntegration]] = None
    ): IntegrateServices =
      IntegrateServices
        .builder
        .ifSome(athenaIntegrations)(_.athenaIntegrations(_))
        .build

    def internetGateway(
      attachments: Option[List[InternetGatewayAttachment]] = None,
      internetGatewayId: Option[String] = None,
      ownerId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): InternetGateway =
      InternetGateway
        .builder
        .ifSome(attachments)(_.attachments(_))
        .ifSome(internetGatewayId)(_.internetGatewayId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internetGatewayAttachment(
      state: Option[String] = None,
      vpcId: Option[String] = None
    ): InternetGatewayAttachment =
      InternetGatewayAttachment
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def ipPermission(
      fromPort: Option[Int] = None,
      ipProtocol: Option[String] = None,
      ipRanges: Option[List[IpRange]] = None,
      ipv6Ranges: Option[List[Ipv6Range]] = None,
      prefixListIds: Option[List[PrefixListId]] = None,
      toPort: Option[Int] = None,
      userIdGroupPairs: Option[List[UserIdGroupPair]] = None
    ): IpPermission =
      IpPermission
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(ipProtocol)(_.ipProtocol(_))
        .ifSome(ipRanges)(_.ipRanges(_))
        .ifSome(ipv6Ranges)(_.ipv6Ranges(_))
        .ifSome(prefixListIds)(_.prefixListIds(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(userIdGroupPairs)(_.userIdGroupPairs(_))
        .build

    def ipRange(
      cidrIp: Option[String] = None,
      description: Option[String] = None
    ): IpRange =
      IpRange
        .builder
        .ifSome(cidrIp)(_.cidrIp(_))
        .ifSome(description)(_.description(_))
        .build

    def ipv6CidrAssociation(
      ipv6Cidr: Option[String] = None,
      associatedResource: Option[String] = None
    ): Ipv6CidrAssociation =
      Ipv6CidrAssociation
        .builder
        .ifSome(ipv6Cidr)(_.ipv6Cidr(_))
        .ifSome(associatedResource)(_.associatedResource(_))
        .build

    def ipv6CidrBlock(
      ipv6CidrBlock: Option[String] = None
    ): Ipv6CidrBlock =
      Ipv6CidrBlock
        .builder
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .build

    def ipv6Pool(
      poolId: Option[String] = None,
      description: Option[String] = None,
      poolCidrBlocks: Option[List[PoolCidrBlock]] = None,
      tags: Option[List[Tag]] = None
    ): Ipv6Pool =
      Ipv6Pool
        .builder
        .ifSome(poolId)(_.poolId(_))
        .ifSome(description)(_.description(_))
        .ifSome(poolCidrBlocks)(_.poolCidrBlocks(_))
        .ifSome(tags)(_.tags(_))
        .build

    def ipv6Range(
      cidrIpv6: Option[String] = None,
      description: Option[String] = None
    ): Ipv6Range =
      Ipv6Range
        .builder
        .ifSome(cidrIpv6)(_.cidrIpv6(_))
        .ifSome(description)(_.description(_))
        .build

    def keyPair(
      keyFingerprint: Option[String] = None,
      keyMaterial: Option[String] = None,
      keyName: Option[String] = None,
      keyPairId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): KeyPair =
      KeyPair
        .builder
        .ifSome(keyFingerprint)(_.keyFingerprint(_))
        .ifSome(keyMaterial)(_.keyMaterial(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(keyPairId)(_.keyPairId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def keyPairInfo(
      keyPairId: Option[String] = None,
      keyFingerprint: Option[String] = None,
      keyName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): KeyPairInfo =
      KeyPairInfo
        .builder
        .ifSome(keyPairId)(_.keyPairId(_))
        .ifSome(keyFingerprint)(_.keyFingerprint(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def lastError(
      message: Option[String] = None,
      code: Option[String] = None
    ): LastError =
      LastError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def launchPermission(
      group: Option[String] = None,
      userId: Option[String] = None
    ): LaunchPermission =
      LaunchPermission
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(userId)(_.userId(_))
        .build

    def launchPermissionModifications(
      add: Option[List[LaunchPermission]] = None,
      remove: Option[List[LaunchPermission]] = None
    ): LaunchPermissionModifications =
      LaunchPermissionModifications
        .builder
        .ifSome(add)(_.add(_))
        .ifSome(remove)(_.remove(_))
        .build

    def launchSpecification(
      userData: Option[String] = None,
      securityGroups: Option[List[GroupIdentifier]] = None,
      addressingType: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      ebsOptimized: Option[Boolean] = None,
      iamInstanceProfile: Option[IamInstanceProfileSpecification] = None,
      imageId: Option[String] = None,
      instanceType: Option[String] = None,
      kernelId: Option[String] = None,
      keyName: Option[String] = None,
      networkInterfaces: Option[List[InstanceNetworkInterfaceSpecification]] = None,
      placement: Option[SpotPlacement] = None,
      ramdiskId: Option[String] = None,
      subnetId: Option[String] = None,
      monitoring: Option[RunInstancesMonitoringEnabled] = None
    ): LaunchSpecification =
      LaunchSpecification
        .builder
        .ifSome(userData)(_.userData(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(addressingType)(_.addressingType(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(monitoring)(_.monitoring(_))
        .build

    def launchTemplate(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      createTime: Option[DateTime] = None,
      createdBy: Option[String] = None,
      defaultVersionNumber: Option[Long] = None,
      latestVersionNumber: Option[Long] = None,
      tags: Option[List[Tag]] = None
    ): LaunchTemplate =
      LaunchTemplate
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(defaultVersionNumber)(_.defaultVersionNumber(_))
        .ifSome(latestVersionNumber)(_.latestVersionNumber(_))
        .ifSome(tags)(_.tags(_))
        .build

    def launchTemplateAndOverridesResponse(
      launchTemplateSpecification: Option[FleetLaunchTemplateSpecification] = None,
      overrides: Option[FleetLaunchTemplateOverrides] = None
    ): LaunchTemplateAndOverridesResponse =
      LaunchTemplateAndOverridesResponse
        .builder
        .ifSome(launchTemplateSpecification)(_.launchTemplateSpecification(_))
        .ifSome(overrides)(_.overrides(_))
        .build

    def launchTemplateBlockDeviceMapping(
      deviceName: Option[String] = None,
      virtualName: Option[String] = None,
      ebs: Option[LaunchTemplateEbsBlockDevice] = None,
      noDevice: Option[String] = None
    ): LaunchTemplateBlockDeviceMapping =
      LaunchTemplateBlockDeviceMapping
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(virtualName)(_.virtualName(_))
        .ifSome(ebs)(_.ebs(_))
        .ifSome(noDevice)(_.noDevice(_))
        .build

    def launchTemplateBlockDeviceMappingRequest(
      deviceName: Option[String] = None,
      virtualName: Option[String] = None,
      ebs: Option[LaunchTemplateEbsBlockDeviceRequest] = None,
      noDevice: Option[String] = None
    ): LaunchTemplateBlockDeviceMappingRequest =
      LaunchTemplateBlockDeviceMappingRequest
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(virtualName)(_.virtualName(_))
        .ifSome(ebs)(_.ebs(_))
        .ifSome(noDevice)(_.noDevice(_))
        .build

    def launchTemplateCapacityReservationSpecificationRequest(
      capacityReservationPreference: Option[String] = None,
      capacityReservationTarget: Option[CapacityReservationTarget] = None
    ): LaunchTemplateCapacityReservationSpecificationRequest =
      LaunchTemplateCapacityReservationSpecificationRequest
        .builder
        .ifSome(capacityReservationPreference)(_.capacityReservationPreference(_))
        .ifSome(capacityReservationTarget)(_.capacityReservationTarget(_))
        .build

    def launchTemplateCapacityReservationSpecificationResponse(
      capacityReservationPreference: Option[String] = None,
      capacityReservationTarget: Option[CapacityReservationTargetResponse] = None
    ): LaunchTemplateCapacityReservationSpecificationResponse =
      LaunchTemplateCapacityReservationSpecificationResponse
        .builder
        .ifSome(capacityReservationPreference)(_.capacityReservationPreference(_))
        .ifSome(capacityReservationTarget)(_.capacityReservationTarget(_))
        .build

    def launchTemplateConfig(
      launchTemplateSpecification: Option[FleetLaunchTemplateSpecification] = None,
      overrides: Option[List[LaunchTemplateOverrides]] = None
    ): LaunchTemplateConfig =
      LaunchTemplateConfig
        .builder
        .ifSome(launchTemplateSpecification)(_.launchTemplateSpecification(_))
        .ifSome(overrides)(_.overrides(_))
        .build

    def launchTemplateCpuOptions(
      coreCount: Option[Int] = None,
      threadsPerCore: Option[Int] = None
    ): LaunchTemplateCpuOptions =
      LaunchTemplateCpuOptions
        .builder
        .ifSome(coreCount)(_.coreCount(_))
        .ifSome(threadsPerCore)(_.threadsPerCore(_))
        .build

    def launchTemplateCpuOptionsRequest(
      coreCount: Option[Int] = None,
      threadsPerCore: Option[Int] = None
    ): LaunchTemplateCpuOptionsRequest =
      LaunchTemplateCpuOptionsRequest
        .builder
        .ifSome(coreCount)(_.coreCount(_))
        .ifSome(threadsPerCore)(_.threadsPerCore(_))
        .build

    def launchTemplateEbsBlockDevice(
      encrypted: Option[Boolean] = None,
      deleteOnTermination: Option[Boolean] = None,
      iops: Option[Int] = None,
      kmsKeyId: Option[String] = None,
      snapshotId: Option[String] = None,
      volumeSize: Option[Int] = None,
      volumeType: Option[String] = None,
      throughput: Option[Int] = None
    ): LaunchTemplateEbsBlockDevice =
      LaunchTemplateEbsBlockDevice
        .builder
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(throughput)(_.throughput(_))
        .build

    def launchTemplateEbsBlockDeviceRequest(
      encrypted: Option[Boolean] = None,
      deleteOnTermination: Option[Boolean] = None,
      iops: Option[Int] = None,
      kmsKeyId: Option[String] = None,
      snapshotId: Option[String] = None,
      volumeSize: Option[Int] = None,
      volumeType: Option[String] = None,
      throughput: Option[Int] = None
    ): LaunchTemplateEbsBlockDeviceRequest =
      LaunchTemplateEbsBlockDeviceRequest
        .builder
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(throughput)(_.throughput(_))
        .build

    def launchTemplateElasticInferenceAccelerator(
      `type`: Option[String] = None,
      count: Option[Int] = None
    ): LaunchTemplateElasticInferenceAccelerator =
      LaunchTemplateElasticInferenceAccelerator
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(count)(_.count(_))
        .build

    def launchTemplateElasticInferenceAcceleratorResponse(
      `type`: Option[String] = None,
      count: Option[Int] = None
    ): LaunchTemplateElasticInferenceAcceleratorResponse =
      LaunchTemplateElasticInferenceAcceleratorResponse
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(count)(_.count(_))
        .build

    def launchTemplateEnclaveOptions(
      enabled: Option[Boolean] = None
    ): LaunchTemplateEnclaveOptions =
      LaunchTemplateEnclaveOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def launchTemplateEnclaveOptionsRequest(
      enabled: Option[Boolean] = None
    ): LaunchTemplateEnclaveOptionsRequest =
      LaunchTemplateEnclaveOptionsRequest
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def launchTemplateHibernationOptions(
      configured: Option[Boolean] = None
    ): LaunchTemplateHibernationOptions =
      LaunchTemplateHibernationOptions
        .builder
        .ifSome(configured)(_.configured(_))
        .build

    def launchTemplateHibernationOptionsRequest(
      configured: Option[Boolean] = None
    ): LaunchTemplateHibernationOptionsRequest =
      LaunchTemplateHibernationOptionsRequest
        .builder
        .ifSome(configured)(_.configured(_))
        .build

    def launchTemplateIamInstanceProfileSpecification(
      arn: Option[String] = None,
      name: Option[String] = None
    ): LaunchTemplateIamInstanceProfileSpecification =
      LaunchTemplateIamInstanceProfileSpecification
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def launchTemplateIamInstanceProfileSpecificationRequest(
      arn: Option[String] = None,
      name: Option[String] = None
    ): LaunchTemplateIamInstanceProfileSpecificationRequest =
      LaunchTemplateIamInstanceProfileSpecificationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def launchTemplateInstanceMarketOptions(
      marketType: Option[String] = None,
      spotOptions: Option[LaunchTemplateSpotMarketOptions] = None
    ): LaunchTemplateInstanceMarketOptions =
      LaunchTemplateInstanceMarketOptions
        .builder
        .ifSome(marketType)(_.marketType(_))
        .ifSome(spotOptions)(_.spotOptions(_))
        .build

    def launchTemplateInstanceMarketOptionsRequest(
      marketType: Option[String] = None,
      spotOptions: Option[LaunchTemplateSpotMarketOptionsRequest] = None
    ): LaunchTemplateInstanceMarketOptionsRequest =
      LaunchTemplateInstanceMarketOptionsRequest
        .builder
        .ifSome(marketType)(_.marketType(_))
        .ifSome(spotOptions)(_.spotOptions(_))
        .build

    def launchTemplateInstanceMetadataOptions(
      state: Option[String] = None,
      httpTokens: Option[String] = None,
      httpPutResponseHopLimit: Option[Int] = None,
      httpEndpoint: Option[String] = None
    ): LaunchTemplateInstanceMetadataOptions =
      LaunchTemplateInstanceMetadataOptions
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(httpTokens)(_.httpTokens(_))
        .ifSome(httpPutResponseHopLimit)(_.httpPutResponseHopLimit(_))
        .ifSome(httpEndpoint)(_.httpEndpoint(_))
        .build

    def launchTemplateInstanceMetadataOptionsRequest(
      httpTokens: Option[String] = None,
      httpPutResponseHopLimit: Option[Int] = None,
      httpEndpoint: Option[String] = None
    ): LaunchTemplateInstanceMetadataOptionsRequest =
      LaunchTemplateInstanceMetadataOptionsRequest
        .builder
        .ifSome(httpTokens)(_.httpTokens(_))
        .ifSome(httpPutResponseHopLimit)(_.httpPutResponseHopLimit(_))
        .ifSome(httpEndpoint)(_.httpEndpoint(_))
        .build

    def launchTemplateInstanceNetworkInterfaceSpecification(
      associateCarrierIpAddress: Option[Boolean] = None,
      associatePublicIpAddress: Option[Boolean] = None,
      deleteOnTermination: Option[Boolean] = None,
      description: Option[String] = None,
      deviceIndex: Option[Int] = None,
      groups: Option[List[String]] = None,
      interfaceType: Option[String] = None,
      ipv6AddressCount: Option[Int] = None,
      ipv6Addresses: Option[List[InstanceIpv6Address]] = None,
      networkInterfaceId: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[PrivateIpAddressSpecification]] = None,
      secondaryPrivateIpAddressCount: Option[Int] = None,
      subnetId: Option[String] = None,
      networkCardIndex: Option[Int] = None
    ): LaunchTemplateInstanceNetworkInterfaceSpecification =
      LaunchTemplateInstanceNetworkInterfaceSpecification
        .builder
        .ifSome(associateCarrierIpAddress)(_.associateCarrierIpAddress(_))
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(description)(_.description(_))
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(interfaceType)(_.interfaceType(_))
        .ifSome(ipv6AddressCount)(_.ipv6AddressCount(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(secondaryPrivateIpAddressCount)(_.secondaryPrivateIpAddressCount(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(networkCardIndex)(_.networkCardIndex(_))
        .build

    def launchTemplateInstanceNetworkInterfaceSpecificationRequest(
      associateCarrierIpAddress: Option[Boolean] = None,
      associatePublicIpAddress: Option[Boolean] = None,
      deleteOnTermination: Option[Boolean] = None,
      description: Option[String] = None,
      deviceIndex: Option[Int] = None,
      groups: Option[List[SecurityGroupId]] = None,
      interfaceType: Option[String] = None,
      ipv6AddressCount: Option[Int] = None,
      ipv6Addresses: Option[List[InstanceIpv6AddressRequest]] = None,
      networkInterfaceId: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[PrivateIpAddressSpecification]] = None,
      secondaryPrivateIpAddressCount: Option[Int] = None,
      subnetId: Option[String] = None,
      networkCardIndex: Option[Int] = None
    ): LaunchTemplateInstanceNetworkInterfaceSpecificationRequest =
      LaunchTemplateInstanceNetworkInterfaceSpecificationRequest
        .builder
        .ifSome(associateCarrierIpAddress)(_.associateCarrierIpAddress(_))
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(description)(_.description(_))
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(interfaceType)(_.interfaceType(_))
        .ifSome(ipv6AddressCount)(_.ipv6AddressCount(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(secondaryPrivateIpAddressCount)(_.secondaryPrivateIpAddressCount(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(networkCardIndex)(_.networkCardIndex(_))
        .build

    def launchTemplateLicenseConfiguration(
      licenseConfigurationArn: Option[String] = None
    ): LaunchTemplateLicenseConfiguration =
      LaunchTemplateLicenseConfiguration
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def launchTemplateLicenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None
    ): LaunchTemplateLicenseConfigurationRequest =
      LaunchTemplateLicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def launchTemplateOverrides(
      instanceType: Option[String] = None,
      spotPrice: Option[String] = None,
      subnetId: Option[String] = None,
      availabilityZone: Option[String] = None,
      weightedCapacity: Option[Double] = None,
      priority: Option[Double] = None
    ): LaunchTemplateOverrides =
      LaunchTemplateOverrides
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .ifSome(priority)(_.priority(_))
        .build

    def launchTemplatePlacement(
      availabilityZone: Option[String] = None,
      affinity: Option[String] = None,
      groupName: Option[String] = None,
      hostId: Option[String] = None,
      tenancy: Option[String] = None,
      spreadDomain: Option[String] = None,
      hostResourceGroupArn: Option[String] = None,
      partitionNumber: Option[Int] = None
    ): LaunchTemplatePlacement =
      LaunchTemplatePlacement
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(affinity)(_.affinity(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(hostId)(_.hostId(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(spreadDomain)(_.spreadDomain(_))
        .ifSome(hostResourceGroupArn)(_.hostResourceGroupArn(_))
        .ifSome(partitionNumber)(_.partitionNumber(_))
        .build

    def launchTemplatePlacementRequest(
      availabilityZone: Option[String] = None,
      affinity: Option[String] = None,
      groupName: Option[String] = None,
      hostId: Option[String] = None,
      tenancy: Option[String] = None,
      spreadDomain: Option[String] = None,
      hostResourceGroupArn: Option[String] = None,
      partitionNumber: Option[Int] = None
    ): LaunchTemplatePlacementRequest =
      LaunchTemplatePlacementRequest
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(affinity)(_.affinity(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(hostId)(_.hostId(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(spreadDomain)(_.spreadDomain(_))
        .ifSome(hostResourceGroupArn)(_.hostResourceGroupArn(_))
        .ifSome(partitionNumber)(_.partitionNumber(_))
        .build

    def launchTemplateSpecification(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      version: Option[String] = None
    ): LaunchTemplateSpecification =
      LaunchTemplateSpecification
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(version)(_.version(_))
        .build

    def launchTemplateSpotMarketOptions(
      maxPrice: Option[String] = None,
      spotInstanceType: Option[String] = None,
      blockDurationMinutes: Option[Int] = None,
      validUntil: Option[DateTime] = None,
      instanceInterruptionBehavior: Option[String] = None
    ): LaunchTemplateSpotMarketOptions =
      LaunchTemplateSpotMarketOptions
        .builder
        .ifSome(maxPrice)(_.maxPrice(_))
        .ifSome(spotInstanceType)(_.spotInstanceType(_))
        .ifSome(blockDurationMinutes)(_.blockDurationMinutes(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .build

    def launchTemplateSpotMarketOptionsRequest(
      maxPrice: Option[String] = None,
      spotInstanceType: Option[String] = None,
      blockDurationMinutes: Option[Int] = None,
      validUntil: Option[DateTime] = None,
      instanceInterruptionBehavior: Option[String] = None
    ): LaunchTemplateSpotMarketOptionsRequest =
      LaunchTemplateSpotMarketOptionsRequest
        .builder
        .ifSome(maxPrice)(_.maxPrice(_))
        .ifSome(spotInstanceType)(_.spotInstanceType(_))
        .ifSome(blockDurationMinutes)(_.blockDurationMinutes(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .build

    def launchTemplateTagSpecification(
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LaunchTemplateTagSpecification =
      LaunchTemplateTagSpecification
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def launchTemplateTagSpecificationRequest(
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LaunchTemplateTagSpecificationRequest =
      LaunchTemplateTagSpecificationRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def launchTemplateVersion(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      versionNumber: Option[Long] = None,
      versionDescription: Option[String] = None,
      createTime: Option[DateTime] = None,
      createdBy: Option[String] = None,
      defaultVersion: Option[Boolean] = None,
      launchTemplateData: Option[ResponseLaunchTemplateData] = None
    ): LaunchTemplateVersion =
      LaunchTemplateVersion
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(defaultVersion)(_.defaultVersion(_))
        .ifSome(launchTemplateData)(_.launchTemplateData(_))
        .build

    def launchTemplatesMonitoring(
      enabled: Option[Boolean] = None
    ): LaunchTemplatesMonitoring =
      LaunchTemplatesMonitoring
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def launchTemplatesMonitoringRequest(
      enabled: Option[Boolean] = None
    ): LaunchTemplatesMonitoringRequest =
      LaunchTemplatesMonitoringRequest
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def licenseConfiguration(
      licenseConfigurationArn: Option[String] = None
    ): LicenseConfiguration =
      LicenseConfiguration
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def licenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None
    ): LicenseConfigurationRequest =
      LicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def loadBalancersConfig(
      classicLoadBalancersConfig: Option[ClassicLoadBalancersConfig] = None,
      targetGroupsConfig: Option[TargetGroupsConfig] = None
    ): LoadBalancersConfig =
      LoadBalancersConfig
        .builder
        .ifSome(classicLoadBalancersConfig)(_.classicLoadBalancersConfig(_))
        .ifSome(targetGroupsConfig)(_.targetGroupsConfig(_))
        .build

    def loadPermission(
      userId: Option[String] = None,
      group: Option[String] = None
    ): LoadPermission =
      LoadPermission
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(group)(_.group(_))
        .build

    def loadPermissionModifications(
      add: Option[List[LoadPermissionRequest]] = None,
      remove: Option[List[LoadPermissionRequest]] = None
    ): LoadPermissionModifications =
      LoadPermissionModifications
        .builder
        .ifSome(add)(_.add(_))
        .ifSome(remove)(_.remove(_))
        .build

    def loadPermissionRequest(
      group: Option[String] = None,
      userId: Option[String] = None
    ): LoadPermissionRequest =
      LoadPermissionRequest
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(userId)(_.userId(_))
        .build

    def localGateway(
      localGatewayId: Option[String] = None,
      outpostArn: Option[String] = None,
      ownerId: Option[String] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LocalGateway =
      LocalGateway
        .builder
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def localGatewayRoute(
      destinationCidrBlock: Option[String] = None,
      localGatewayVirtualInterfaceGroupId: Option[String] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      localGatewayRouteTableId: Option[String] = None,
      localGatewayRouteTableArn: Option[String] = None,
      ownerId: Option[String] = None
    ): LocalGatewayRoute =
      LocalGatewayRoute
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(localGatewayVirtualInterfaceGroupId)(_.localGatewayVirtualInterfaceGroupId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(localGatewayRouteTableArn)(_.localGatewayRouteTableArn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .build

    def localGatewayRouteTable(
      localGatewayRouteTableId: Option[String] = None,
      localGatewayRouteTableArn: Option[String] = None,
      localGatewayId: Option[String] = None,
      outpostArn: Option[String] = None,
      ownerId: Option[String] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LocalGatewayRouteTable =
      LocalGatewayRouteTable
        .builder
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(localGatewayRouteTableArn)(_.localGatewayRouteTableArn(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def localGatewayRouteTableVirtualInterfaceGroupAssociation(
      localGatewayRouteTableVirtualInterfaceGroupAssociationId: Option[String] = None,
      localGatewayVirtualInterfaceGroupId: Option[String] = None,
      localGatewayId: Option[String] = None,
      localGatewayRouteTableId: Option[String] = None,
      localGatewayRouteTableArn: Option[String] = None,
      ownerId: Option[String] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LocalGatewayRouteTableVirtualInterfaceGroupAssociation =
      LocalGatewayRouteTableVirtualInterfaceGroupAssociation
        .builder
        .ifSome(localGatewayRouteTableVirtualInterfaceGroupAssociationId)(_.localGatewayRouteTableVirtualInterfaceGroupAssociationId(_))
        .ifSome(localGatewayVirtualInterfaceGroupId)(_.localGatewayVirtualInterfaceGroupId(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(localGatewayRouteTableArn)(_.localGatewayRouteTableArn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def localGatewayRouteTableVpcAssociation(
      localGatewayRouteTableVpcAssociationId: Option[String] = None,
      localGatewayRouteTableId: Option[String] = None,
      localGatewayRouteTableArn: Option[String] = None,
      localGatewayId: Option[String] = None,
      vpcId: Option[String] = None,
      ownerId: Option[String] = None,
      state: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LocalGatewayRouteTableVpcAssociation =
      LocalGatewayRouteTableVpcAssociation
        .builder
        .ifSome(localGatewayRouteTableVpcAssociationId)(_.localGatewayRouteTableVpcAssociationId(_))
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(localGatewayRouteTableArn)(_.localGatewayRouteTableArn(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def localGatewayVirtualInterface(
      localGatewayVirtualInterfaceId: Option[String] = None,
      localGatewayId: Option[String] = None,
      vlan: Option[Int] = None,
      localAddress: Option[String] = None,
      peerAddress: Option[String] = None,
      localBgpAsn: Option[Int] = None,
      peerBgpAsn: Option[Int] = None,
      ownerId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LocalGatewayVirtualInterface =
      LocalGatewayVirtualInterface
        .builder
        .ifSome(localGatewayVirtualInterfaceId)(_.localGatewayVirtualInterfaceId(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(vlan)(_.vlan(_))
        .ifSome(localAddress)(_.localAddress(_))
        .ifSome(peerAddress)(_.peerAddress(_))
        .ifSome(localBgpAsn)(_.localBgpAsn(_))
        .ifSome(peerBgpAsn)(_.peerBgpAsn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def localGatewayVirtualInterfaceGroup(
      localGatewayVirtualInterfaceGroupId: Option[String] = None,
      localGatewayVirtualInterfaceIds: Option[List[LocalGatewayVirtualInterfaceId]] = None,
      localGatewayId: Option[String] = None,
      ownerId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LocalGatewayVirtualInterfaceGroup =
      LocalGatewayVirtualInterfaceGroup
        .builder
        .ifSome(localGatewayVirtualInterfaceGroupId)(_.localGatewayVirtualInterfaceGroupId(_))
        .ifSome(localGatewayVirtualInterfaceIds)(_.localGatewayVirtualInterfaceIds(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def managedPrefixList(
      prefixListId: Option[String] = None,
      addressFamily: Option[String] = None,
      state: Option[String] = None,
      stateMessage: Option[String] = None,
      prefixListArn: Option[String] = None,
      prefixListName: Option[String] = None,
      maxEntries: Option[Int] = None,
      version: Option[Long] = None,
      tags: Option[List[Tag]] = None,
      ownerId: Option[String] = None
    ): ManagedPrefixList =
      ManagedPrefixList
        .builder
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(addressFamily)(_.addressFamily(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateMessage)(_.stateMessage(_))
        .ifSome(prefixListArn)(_.prefixListArn(_))
        .ifSome(prefixListName)(_.prefixListName(_))
        .ifSome(maxEntries)(_.maxEntries(_))
        .ifSome(version)(_.version(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(ownerId)(_.ownerId(_))
        .build

    def memoryInfo(
      sizeInMiB: Option[MemorySize] = None
    ): MemoryInfo =
      MemoryInfo
        .builder
        .ifSome(sizeInMiB)(_.sizeInMiB(_))
        .build

    def modifyAddressAttributeRequest(
      allocationId: Option[String] = None,
      domainName: Option[String] = None
    ): ModifyAddressAttributeRequest =
      ModifyAddressAttributeRequest
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def modifyAvailabilityZoneGroupRequest(
      groupName: Option[String] = None,
      optInStatus: Option[String] = None
    ): ModifyAvailabilityZoneGroupRequest =
      ModifyAvailabilityZoneGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(optInStatus)(_.optInStatus(_))
        .build

    def modifyCapacityReservationRequest(
      capacityReservationId: Option[String] = None,
      instanceCount: Option[Int] = None,
      endDate: Option[DateTime] = None,
      endDateType: Option[String] = None,
      accept: Option[Boolean] = None
    ): ModifyCapacityReservationRequest =
      ModifyCapacityReservationRequest
        .builder
        .ifSome(capacityReservationId)(_.capacityReservationId(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(endDateType)(_.endDateType(_))
        .ifSome(accept)(_.accept(_))
        .build

    def modifyClientVpnEndpointRequest(
      clientVpnEndpointId: Option[String] = None,
      serverCertificateArn: Option[String] = None,
      connectionLogOptions: Option[ConnectionLogOptions] = None,
      dnsServers: Option[DnsServersOptionsModifyStructure] = None,
      vpnPort: Option[Int] = None,
      description: Option[String] = None,
      splitTunnel: Option[Boolean] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      vpcId: Option[String] = None,
      selfServicePortal: Option[String] = None,
      clientConnectOptions: Option[ClientConnectOptions] = None
    ): ModifyClientVpnEndpointRequest =
      ModifyClientVpnEndpointRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(serverCertificateArn)(_.serverCertificateArn(_))
        .ifSome(connectionLogOptions)(_.connectionLogOptions(_))
        .ifSome(dnsServers)(_.dnsServers(_))
        .ifSome(vpnPort)(_.vpnPort(_))
        .ifSome(description)(_.description(_))
        .ifSome(splitTunnel)(_.splitTunnel(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(selfServicePortal)(_.selfServicePortal(_))
        .ifSome(clientConnectOptions)(_.clientConnectOptions(_))
        .build

    def modifyDefaultCreditSpecificationRequest(
      instanceFamily: Option[String] = None,
      cpuCredits: Option[String] = None
    ): ModifyDefaultCreditSpecificationRequest =
      ModifyDefaultCreditSpecificationRequest
        .builder
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(cpuCredits)(_.cpuCredits(_))
        .build

    def modifyEbsDefaultKmsKeyIdRequest(
      kmsKeyId: Option[String] = None
    ): ModifyEbsDefaultKmsKeyIdRequest =
      ModifyEbsDefaultKmsKeyIdRequest
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def modifyFleetRequest(
      excessCapacityTerminationPolicy: Option[String] = None,
      launchTemplateConfigs: Option[List[FleetLaunchTemplateConfigRequest]] = None,
      fleetId: Option[String] = None,
      targetCapacitySpecification: Option[TargetCapacitySpecificationRequest] = None
    ): ModifyFleetRequest =
      ModifyFleetRequest
        .builder
        .ifSome(excessCapacityTerminationPolicy)(_.excessCapacityTerminationPolicy(_))
        .ifSome(launchTemplateConfigs)(_.launchTemplateConfigs(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(targetCapacitySpecification)(_.targetCapacitySpecification(_))
        .build

    def modifyFpgaImageAttributeRequest(
      fpgaImageId: Option[String] = None,
      attribute: Option[String] = None,
      operationType: Option[String] = None,
      userIds: Option[List[String]] = None,
      userGroups: Option[List[String]] = None,
      productCodes: Option[List[String]] = None,
      loadPermission: Option[LoadPermissionModifications] = None,
      description: Option[String] = None,
      name: Option[String] = None
    ): ModifyFpgaImageAttributeRequest =
      ModifyFpgaImageAttributeRequest
        .builder
        .ifSome(fpgaImageId)(_.fpgaImageId(_))
        .ifSome(attribute)(_.attribute(_))
        .ifSome(operationType)(_.operationType(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(userGroups)(_.userGroups(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(loadPermission)(_.loadPermission(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .build

    def modifyHostsRequest(
      autoPlacement: Option[String] = None,
      hostIds: Option[List[DedicatedHostId]] = None,
      hostRecovery: Option[String] = None,
      instanceType: Option[String] = None,
      instanceFamily: Option[String] = None
    ): ModifyHostsRequest =
      ModifyHostsRequest
        .builder
        .ifSome(autoPlacement)(_.autoPlacement(_))
        .ifSome(hostIds)(_.hostIds(_))
        .ifSome(hostRecovery)(_.hostRecovery(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .build

    def modifyIdFormatRequest(
      resource: Option[String] = None,
      useLongIds: Option[Boolean] = None
    ): ModifyIdFormatRequest =
      ModifyIdFormatRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(useLongIds)(_.useLongIds(_))
        .build

    def modifyIdentityIdFormatRequest(
      principalArn: Option[String] = None,
      resource: Option[String] = None,
      useLongIds: Option[Boolean] = None
    ): ModifyIdentityIdFormatRequest =
      ModifyIdentityIdFormatRequest
        .builder
        .ifSome(principalArn)(_.principalArn(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(useLongIds)(_.useLongIds(_))
        .build

    def modifyImageAttributeRequest(
      attribute: Option[String] = None,
      description: Option[AttributeValue] = None,
      imageId: Option[String] = None,
      launchPermission: Option[LaunchPermissionModifications] = None,
      operationType: Option[String] = None,
      productCodes: Option[List[String]] = None,
      userGroups: Option[List[String]] = None,
      userIds: Option[List[String]] = None,
      value: Option[String] = None
    ): ModifyImageAttributeRequest =
      ModifyImageAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(description)(_.description(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(launchPermission)(_.launchPermission(_))
        .ifSome(operationType)(_.operationType(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(userGroups)(_.userGroups(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(value)(_.value(_))
        .build

    def modifyInstanceAttributeRequest(
      sourceDestCheck: Option[AttributeBooleanValue] = None,
      attribute: Option[String] = None,
      blockDeviceMappings: Option[List[InstanceBlockDeviceMappingSpecification]] = None,
      disableApiTermination: Option[AttributeBooleanValue] = None,
      ebsOptimized: Option[AttributeBooleanValue] = None,
      enaSupport: Option[AttributeBooleanValue] = None,
      groups: Option[List[String]] = None,
      instanceId: Option[String] = None,
      instanceInitiatedShutdownBehavior: Option[AttributeValue] = None,
      instanceType: Option[AttributeValue] = None,
      kernel: Option[AttributeValue] = None,
      ramdisk: Option[AttributeValue] = None,
      sriovNetSupport: Option[AttributeValue] = None,
      userData: Option[BlobAttributeValue] = None,
      value: Option[String] = None
    ): ModifyInstanceAttributeRequest =
      ModifyInstanceAttributeRequest
        .builder
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .ifSome(attribute)(_.attribute(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(disableApiTermination)(_.disableApiTermination(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(enaSupport)(_.enaSupport(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceInitiatedShutdownBehavior)(_.instanceInitiatedShutdownBehavior(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernel)(_.kernel(_))
        .ifSome(ramdisk)(_.ramdisk(_))
        .ifSome(sriovNetSupport)(_.sriovNetSupport(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(value)(_.value(_))
        .build

    def modifyInstanceCapacityReservationAttributesRequest(
      instanceId: Option[String] = None,
      capacityReservationSpecification: Option[CapacityReservationSpecification] = None
    ): ModifyInstanceCapacityReservationAttributesRequest =
      ModifyInstanceCapacityReservationAttributesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(capacityReservationSpecification)(_.capacityReservationSpecification(_))
        .build

    def modifyInstanceCreditSpecificationRequest(
      clientToken: Option[String] = None,
      instanceCreditSpecifications: Option[List[InstanceCreditSpecificationRequest]] = None
    ): ModifyInstanceCreditSpecificationRequest =
      ModifyInstanceCreditSpecificationRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(instanceCreditSpecifications)(_.instanceCreditSpecifications(_))
        .build

    def modifyInstanceEventStartTimeRequest(
      instanceId: Option[String] = None,
      instanceEventId: Option[String] = None,
      notBefore: Option[DateTime] = None
    ): ModifyInstanceEventStartTimeRequest =
      ModifyInstanceEventStartTimeRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceEventId)(_.instanceEventId(_))
        .ifSome(notBefore)(_.notBefore(_))
        .build

    def modifyInstanceMetadataOptionsRequest(
      instanceId: Option[String] = None,
      httpTokens: Option[String] = None,
      httpPutResponseHopLimit: Option[Int] = None,
      httpEndpoint: Option[String] = None
    ): ModifyInstanceMetadataOptionsRequest =
      ModifyInstanceMetadataOptionsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(httpTokens)(_.httpTokens(_))
        .ifSome(httpPutResponseHopLimit)(_.httpPutResponseHopLimit(_))
        .ifSome(httpEndpoint)(_.httpEndpoint(_))
        .build

    def modifyInstancePlacementRequest(
      affinity: Option[String] = None,
      groupName: Option[String] = None,
      hostId: Option[String] = None,
      instanceId: Option[String] = None,
      tenancy: Option[String] = None,
      partitionNumber: Option[Int] = None,
      hostResourceGroupArn: Option[String] = None
    ): ModifyInstancePlacementRequest =
      ModifyInstancePlacementRequest
        .builder
        .ifSome(affinity)(_.affinity(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(hostId)(_.hostId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(partitionNumber)(_.partitionNumber(_))
        .ifSome(hostResourceGroupArn)(_.hostResourceGroupArn(_))
        .build

    def modifyLaunchTemplateRequest(
      clientToken: Option[String] = None,
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      defaultVersion: Option[String] = None
    ): ModifyLaunchTemplateRequest =
      ModifyLaunchTemplateRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(defaultVersion)(_.defaultVersion(_))
        .build

    def modifyManagedPrefixListRequest(
      prefixListId: Option[String] = None,
      currentVersion: Option[Long] = None,
      prefixListName: Option[String] = None,
      addEntries: Option[List[AddPrefixListEntry]] = None,
      removeEntries: Option[List[RemovePrefixListEntry]] = None
    ): ModifyManagedPrefixListRequest =
      ModifyManagedPrefixListRequest
        .builder
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(prefixListName)(_.prefixListName(_))
        .ifSome(addEntries)(_.addEntries(_))
        .ifSome(removeEntries)(_.removeEntries(_))
        .build

    def modifyNetworkInterfaceAttributeRequest(
      attachment: Option[NetworkInterfaceAttachmentChanges] = None,
      description: Option[AttributeValue] = None,
      groups: Option[List[SecurityGroupId]] = None,
      networkInterfaceId: Option[String] = None,
      sourceDestCheck: Option[AttributeBooleanValue] = None
    ): ModifyNetworkInterfaceAttributeRequest =
      ModifyNetworkInterfaceAttributeRequest
        .builder
        .ifSome(attachment)(_.attachment(_))
        .ifSome(description)(_.description(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .build

    def modifyReservedInstancesRequest(
      reservedInstancesIds: Option[List[ReservationId]] = None,
      clientToken: Option[String] = None,
      targetConfigurations: Option[List[ReservedInstancesConfiguration]] = None
    ): ModifyReservedInstancesRequest =
      ModifyReservedInstancesRequest
        .builder
        .ifSome(reservedInstancesIds)(_.reservedInstancesIds(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(targetConfigurations)(_.targetConfigurations(_))
        .build

    def modifySnapshotAttributeRequest(
      attribute: Option[String] = None,
      createVolumePermission: Option[CreateVolumePermissionModifications] = None,
      groupNames: Option[List[SecurityGroupName]] = None,
      operationType: Option[String] = None,
      snapshotId: Option[String] = None,
      userIds: Option[List[String]] = None
    ): ModifySnapshotAttributeRequest =
      ModifySnapshotAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(createVolumePermission)(_.createVolumePermission(_))
        .ifSome(groupNames)(_.groupNames(_))
        .ifSome(operationType)(_.operationType(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(userIds)(_.userIds(_))
        .build

    def modifySpotFleetRequestRequest(
      excessCapacityTerminationPolicy: Option[String] = None,
      launchTemplateConfigs: Option[List[LaunchTemplateConfig]] = None,
      spotFleetRequestId: Option[String] = None,
      targetCapacity: Option[Int] = None,
      onDemandTargetCapacity: Option[Int] = None
    ): ModifySpotFleetRequestRequest =
      ModifySpotFleetRequestRequest
        .builder
        .ifSome(excessCapacityTerminationPolicy)(_.excessCapacityTerminationPolicy(_))
        .ifSome(launchTemplateConfigs)(_.launchTemplateConfigs(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .ifSome(targetCapacity)(_.targetCapacity(_))
        .ifSome(onDemandTargetCapacity)(_.onDemandTargetCapacity(_))
        .build

    def modifySpotFleetRequestResponse(
      return: Option[Boolean] = None
    ): ModifySpotFleetRequestResponse =
      ModifySpotFleetRequestResponse
        .builder
        .ifSome(return)(_.return(_))
        .build

    def modifySubnetAttributeRequest(
      assignIpv6AddressOnCreation: Option[AttributeBooleanValue] = None,
      mapPublicIpOnLaunch: Option[AttributeBooleanValue] = None,
      subnetId: Option[String] = None,
      mapCustomerOwnedIpOnLaunch: Option[AttributeBooleanValue] = None,
      customerOwnedIpv4Pool: Option[String] = None
    ): ModifySubnetAttributeRequest =
      ModifySubnetAttributeRequest
        .builder
        .ifSome(assignIpv6AddressOnCreation)(_.assignIpv6AddressOnCreation(_))
        .ifSome(mapPublicIpOnLaunch)(_.mapPublicIpOnLaunch(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(mapCustomerOwnedIpOnLaunch)(_.mapCustomerOwnedIpOnLaunch(_))
        .ifSome(customerOwnedIpv4Pool)(_.customerOwnedIpv4Pool(_))
        .build

    def modifyTrafficMirrorFilterNetworkServicesRequest(
      trafficMirrorFilterId: Option[String] = None,
      addNetworkServices: Option[List[TrafficMirrorNetworkService]] = None,
      removeNetworkServices: Option[List[TrafficMirrorNetworkService]] = None
    ): ModifyTrafficMirrorFilterNetworkServicesRequest =
      ModifyTrafficMirrorFilterNetworkServicesRequest
        .builder
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .ifSome(addNetworkServices)(_.addNetworkServices(_))
        .ifSome(removeNetworkServices)(_.removeNetworkServices(_))
        .build

    def modifyTrafficMirrorFilterRuleRequest(
      trafficMirrorFilterRuleId: Option[String] = None,
      trafficDirection: Option[String] = None,
      ruleNumber: Option[Int] = None,
      ruleAction: Option[String] = None,
      destinationPortRange: Option[TrafficMirrorPortRangeRequest] = None,
      sourcePortRange: Option[TrafficMirrorPortRangeRequest] = None,
      protocol: Option[Int] = None,
      destinationCidrBlock: Option[String] = None,
      sourceCidrBlock: Option[String] = None,
      description: Option[String] = None,
      removeFields: Option[List[TrafficMirrorFilterRuleField]] = None
    ): ModifyTrafficMirrorFilterRuleRequest =
      ModifyTrafficMirrorFilterRuleRequest
        .builder
        .ifSome(trafficMirrorFilterRuleId)(_.trafficMirrorFilterRuleId(_))
        .ifSome(trafficDirection)(_.trafficDirection(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(destinationPortRange)(_.destinationPortRange(_))
        .ifSome(sourcePortRange)(_.sourcePortRange(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(sourceCidrBlock)(_.sourceCidrBlock(_))
        .ifSome(description)(_.description(_))
        .ifSome(removeFields)(_.removeFields(_))
        .build

    def modifyTrafficMirrorSessionRequest(
      trafficMirrorSessionId: Option[String] = None,
      trafficMirrorTargetId: Option[String] = None,
      trafficMirrorFilterId: Option[String] = None,
      packetLength: Option[Int] = None,
      sessionNumber: Option[Int] = None,
      virtualNetworkId: Option[Int] = None,
      description: Option[String] = None,
      removeFields: Option[List[TrafficMirrorSessionField]] = None
    ): ModifyTrafficMirrorSessionRequest =
      ModifyTrafficMirrorSessionRequest
        .builder
        .ifSome(trafficMirrorSessionId)(_.trafficMirrorSessionId(_))
        .ifSome(trafficMirrorTargetId)(_.trafficMirrorTargetId(_))
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .ifSome(packetLength)(_.packetLength(_))
        .ifSome(sessionNumber)(_.sessionNumber(_))
        .ifSome(virtualNetworkId)(_.virtualNetworkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(removeFields)(_.removeFields(_))
        .build

    def modifyTransitGatewayOptions(
      addTransitGatewayCidrBlocks: Option[List[String]] = None,
      removeTransitGatewayCidrBlocks: Option[List[String]] = None,
      vpnEcmpSupport: Option[String] = None,
      dnsSupport: Option[String] = None,
      autoAcceptSharedAttachments: Option[String] = None,
      defaultRouteTableAssociation: Option[String] = None,
      associationDefaultRouteTableId: Option[String] = None,
      defaultRouteTablePropagation: Option[String] = None,
      propagationDefaultRouteTableId: Option[String] = None
    ): ModifyTransitGatewayOptions =
      ModifyTransitGatewayOptions
        .builder
        .ifSome(addTransitGatewayCidrBlocks)(_.addTransitGatewayCidrBlocks(_))
        .ifSome(removeTransitGatewayCidrBlocks)(_.removeTransitGatewayCidrBlocks(_))
        .ifSome(vpnEcmpSupport)(_.vpnEcmpSupport(_))
        .ifSome(dnsSupport)(_.dnsSupport(_))
        .ifSome(autoAcceptSharedAttachments)(_.autoAcceptSharedAttachments(_))
        .ifSome(defaultRouteTableAssociation)(_.defaultRouteTableAssociation(_))
        .ifSome(associationDefaultRouteTableId)(_.associationDefaultRouteTableId(_))
        .ifSome(defaultRouteTablePropagation)(_.defaultRouteTablePropagation(_))
        .ifSome(propagationDefaultRouteTableId)(_.propagationDefaultRouteTableId(_))
        .build

    def modifyTransitGatewayPrefixListReferenceRequest(
      transitGatewayRouteTableId: Option[String] = None,
      prefixListId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      blackhole: Option[Boolean] = None
    ): ModifyTransitGatewayPrefixListReferenceRequest =
      ModifyTransitGatewayPrefixListReferenceRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(blackhole)(_.blackhole(_))
        .build

    def modifyTransitGatewayRequest(
      transitGatewayId: Option[String] = None,
      description: Option[String] = None,
      options: Option[ModifyTransitGatewayOptions] = None
    ): ModifyTransitGatewayRequest =
      ModifyTransitGatewayRequest
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(description)(_.description(_))
        .ifSome(options)(_.options(_))
        .build

    def modifyTransitGatewayVpcAttachmentRequest(
      transitGatewayAttachmentId: Option[String] = None,
      addSubnetIds: Option[List[SubnetId]] = None,
      removeSubnetIds: Option[List[SubnetId]] = None,
      options: Option[ModifyTransitGatewayVpcAttachmentRequestOptions] = None
    ): ModifyTransitGatewayVpcAttachmentRequest =
      ModifyTransitGatewayVpcAttachmentRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(addSubnetIds)(_.addSubnetIds(_))
        .ifSome(removeSubnetIds)(_.removeSubnetIds(_))
        .ifSome(options)(_.options(_))
        .build

    def modifyTransitGatewayVpcAttachmentRequestOptions(
      dnsSupport: Option[String] = None,
      ipv6Support: Option[String] = None,
      applianceModeSupport: Option[String] = None
    ): ModifyTransitGatewayVpcAttachmentRequestOptions =
      ModifyTransitGatewayVpcAttachmentRequestOptions
        .builder
        .ifSome(dnsSupport)(_.dnsSupport(_))
        .ifSome(ipv6Support)(_.ipv6Support(_))
        .ifSome(applianceModeSupport)(_.applianceModeSupport(_))
        .build

    def modifyVolumeAttributeRequest(
      autoEnableIO: Option[AttributeBooleanValue] = None,
      volumeId: Option[String] = None
    ): ModifyVolumeAttributeRequest =
      ModifyVolumeAttributeRequest
        .builder
        .ifSome(autoEnableIO)(_.autoEnableIO(_))
        .ifSome(volumeId)(_.volumeId(_))
        .build

    def modifyVolumeRequest(
      volumeId: Option[String] = None,
      size: Option[Int] = None,
      volumeType: Option[String] = None,
      iops: Option[Int] = None,
      throughput: Option[Int] = None,
      multiAttachEnabled: Option[Boolean] = None
    ): ModifyVolumeRequest =
      ModifyVolumeRequest
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(size)(_.size(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(throughput)(_.throughput(_))
        .ifSome(multiAttachEnabled)(_.multiAttachEnabled(_))
        .build

    def modifyVpcAttributeRequest(
      enableDnsHostnames: Option[AttributeBooleanValue] = None,
      enableDnsSupport: Option[AttributeBooleanValue] = None,
      vpcId: Option[String] = None
    ): ModifyVpcAttributeRequest =
      ModifyVpcAttributeRequest
        .builder
        .ifSome(enableDnsHostnames)(_.enableDnsHostnames(_))
        .ifSome(enableDnsSupport)(_.enableDnsSupport(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def modifyVpcEndpointConnectionNotificationRequest(
      connectionNotificationId: Option[String] = None,
      connectionNotificationArn: Option[String] = None,
      connectionEvents: Option[List[String]] = None
    ): ModifyVpcEndpointConnectionNotificationRequest =
      ModifyVpcEndpointConnectionNotificationRequest
        .builder
        .ifSome(connectionNotificationId)(_.connectionNotificationId(_))
        .ifSome(connectionNotificationArn)(_.connectionNotificationArn(_))
        .ifSome(connectionEvents)(_.connectionEvents(_))
        .build

    def modifyVpcEndpointRequest(
      vpcEndpointId: Option[String] = None,
      resetPolicy: Option[Boolean] = None,
      policyDocument: Option[String] = None,
      addRouteTableIds: Option[List[RouteTableId]] = None,
      removeRouteTableIds: Option[List[RouteTableId]] = None,
      addSubnetIds: Option[List[SubnetId]] = None,
      removeSubnetIds: Option[List[SubnetId]] = None,
      addSecurityGroupIds: Option[List[SecurityGroupId]] = None,
      removeSecurityGroupIds: Option[List[SecurityGroupId]] = None,
      privateDnsEnabled: Option[Boolean] = None
    ): ModifyVpcEndpointRequest =
      ModifyVpcEndpointRequest
        .builder
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(resetPolicy)(_.resetPolicy(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(addRouteTableIds)(_.addRouteTableIds(_))
        .ifSome(removeRouteTableIds)(_.removeRouteTableIds(_))
        .ifSome(addSubnetIds)(_.addSubnetIds(_))
        .ifSome(removeSubnetIds)(_.removeSubnetIds(_))
        .ifSome(addSecurityGroupIds)(_.addSecurityGroupIds(_))
        .ifSome(removeSecurityGroupIds)(_.removeSecurityGroupIds(_))
        .ifSome(privateDnsEnabled)(_.privateDnsEnabled(_))
        .build

    def modifyVpcEndpointServiceConfigurationRequest(
      serviceId: Option[String] = None,
      privateDnsName: Option[String] = None,
      removePrivateDnsName: Option[Boolean] = None,
      acceptanceRequired: Option[Boolean] = None,
      addNetworkLoadBalancerArns: Option[List[String]] = None,
      removeNetworkLoadBalancerArns: Option[List[String]] = None,
      addGatewayLoadBalancerArns: Option[List[String]] = None,
      removeGatewayLoadBalancerArns: Option[List[String]] = None
    ): ModifyVpcEndpointServiceConfigurationRequest =
      ModifyVpcEndpointServiceConfigurationRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(removePrivateDnsName)(_.removePrivateDnsName(_))
        .ifSome(acceptanceRequired)(_.acceptanceRequired(_))
        .ifSome(addNetworkLoadBalancerArns)(_.addNetworkLoadBalancerArns(_))
        .ifSome(removeNetworkLoadBalancerArns)(_.removeNetworkLoadBalancerArns(_))
        .ifSome(addGatewayLoadBalancerArns)(_.addGatewayLoadBalancerArns(_))
        .ifSome(removeGatewayLoadBalancerArns)(_.removeGatewayLoadBalancerArns(_))
        .build

    def modifyVpcEndpointServicePermissionsRequest(
      serviceId: Option[String] = None,
      addAllowedPrincipals: Option[List[String]] = None,
      removeAllowedPrincipals: Option[List[String]] = None
    ): ModifyVpcEndpointServicePermissionsRequest =
      ModifyVpcEndpointServicePermissionsRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(addAllowedPrincipals)(_.addAllowedPrincipals(_))
        .ifSome(removeAllowedPrincipals)(_.removeAllowedPrincipals(_))
        .build

    def modifyVpcPeeringConnectionOptionsRequest(
      accepterPeeringConnectionOptions: Option[PeeringConnectionOptionsRequest] = None,
      requesterPeeringConnectionOptions: Option[PeeringConnectionOptionsRequest] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): ModifyVpcPeeringConnectionOptionsRequest =
      ModifyVpcPeeringConnectionOptionsRequest
        .builder
        .ifSome(accepterPeeringConnectionOptions)(_.accepterPeeringConnectionOptions(_))
        .ifSome(requesterPeeringConnectionOptions)(_.requesterPeeringConnectionOptions(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def modifyVpcTenancyRequest(
      vpcId: Option[String] = None,
      instanceTenancy: Option[String] = None
    ): ModifyVpcTenancyRequest =
      ModifyVpcTenancyRequest
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(instanceTenancy)(_.instanceTenancy(_))
        .build

    def modifyVpnConnectionOptionsRequest(
      vpnConnectionId: Option[String] = None,
      localIpv4NetworkCidr: Option[String] = None,
      remoteIpv4NetworkCidr: Option[String] = None,
      localIpv6NetworkCidr: Option[String] = None,
      remoteIpv6NetworkCidr: Option[String] = None
    ): ModifyVpnConnectionOptionsRequest =
      ModifyVpnConnectionOptionsRequest
        .builder
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .ifSome(localIpv4NetworkCidr)(_.localIpv4NetworkCidr(_))
        .ifSome(remoteIpv4NetworkCidr)(_.remoteIpv4NetworkCidr(_))
        .ifSome(localIpv6NetworkCidr)(_.localIpv6NetworkCidr(_))
        .ifSome(remoteIpv6NetworkCidr)(_.remoteIpv6NetworkCidr(_))
        .build

    def modifyVpnConnectionRequest(
      vpnConnectionId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      customerGatewayId: Option[String] = None,
      vpnGatewayId: Option[String] = None
    ): ModifyVpnConnectionRequest =
      ModifyVpnConnectionRequest
        .builder
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(customerGatewayId)(_.customerGatewayId(_))
        .ifSome(vpnGatewayId)(_.vpnGatewayId(_))
        .build

    def modifyVpnTunnelCertificateRequest(
      vpnConnectionId: Option[String] = None,
      vpnTunnelOutsideIpAddress: Option[String] = None
    ): ModifyVpnTunnelCertificateRequest =
      ModifyVpnTunnelCertificateRequest
        .builder
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .ifSome(vpnTunnelOutsideIpAddress)(_.vpnTunnelOutsideIpAddress(_))
        .build

    def modifyVpnTunnelOptionsRequest(
      vpnConnectionId: Option[String] = None,
      vpnTunnelOutsideIpAddress: Option[String] = None,
      tunnelOptions: Option[ModifyVpnTunnelOptionsSpecification] = None
    ): ModifyVpnTunnelOptionsRequest =
      ModifyVpnTunnelOptionsRequest
        .builder
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .ifSome(vpnTunnelOutsideIpAddress)(_.vpnTunnelOutsideIpAddress(_))
        .ifSome(tunnelOptions)(_.tunnelOptions(_))
        .build

    def modifyVpnTunnelOptionsSpecification(
      tunnelInsideCidr: Option[String] = None,
      tunnelInsideIpv6Cidr: Option[String] = None,
      preSharedKey: Option[String] = None,
      phase1LifetimeSeconds: Option[Int] = None,
      phase2LifetimeSeconds: Option[Int] = None,
      rekeyMarginTimeSeconds: Option[Int] = None,
      rekeyFuzzPercentage: Option[Int] = None,
      replayWindowSize: Option[Int] = None,
      dPDTimeoutSeconds: Option[Int] = None,
      dPDTimeoutAction: Option[String] = None,
      phase1EncryptionAlgorithms: Option[List[Phase1EncryptionAlgorithmsRequestListValue]] = None,
      phase2EncryptionAlgorithms: Option[List[Phase2EncryptionAlgorithmsRequestListValue]] = None,
      phase1IntegrityAlgorithms: Option[List[Phase1IntegrityAlgorithmsRequestListValue]] = None,
      phase2IntegrityAlgorithms: Option[List[Phase2IntegrityAlgorithmsRequestListValue]] = None,
      phase1DHGroupNumbers: Option[List[Phase1DHGroupNumbersRequestListValue]] = None,
      phase2DHGroupNumbers: Option[List[Phase2DHGroupNumbersRequestListValue]] = None,
      iKEVersions: Option[List[IKEVersionsRequestListValue]] = None,
      startupAction: Option[String] = None
    ): ModifyVpnTunnelOptionsSpecification =
      ModifyVpnTunnelOptionsSpecification
        .builder
        .ifSome(tunnelInsideCidr)(_.tunnelInsideCidr(_))
        .ifSome(tunnelInsideIpv6Cidr)(_.tunnelInsideIpv6Cidr(_))
        .ifSome(preSharedKey)(_.preSharedKey(_))
        .ifSome(phase1LifetimeSeconds)(_.phase1LifetimeSeconds(_))
        .ifSome(phase2LifetimeSeconds)(_.phase2LifetimeSeconds(_))
        .ifSome(rekeyMarginTimeSeconds)(_.rekeyMarginTimeSeconds(_))
        .ifSome(rekeyFuzzPercentage)(_.rekeyFuzzPercentage(_))
        .ifSome(replayWindowSize)(_.replayWindowSize(_))
        .ifSome(dPDTimeoutSeconds)(_.dPDTimeoutSeconds(_))
        .ifSome(dPDTimeoutAction)(_.dPDTimeoutAction(_))
        .ifSome(phase1EncryptionAlgorithms)(_.phase1EncryptionAlgorithms(_))
        .ifSome(phase2EncryptionAlgorithms)(_.phase2EncryptionAlgorithms(_))
        .ifSome(phase1IntegrityAlgorithms)(_.phase1IntegrityAlgorithms(_))
        .ifSome(phase2IntegrityAlgorithms)(_.phase2IntegrityAlgorithms(_))
        .ifSome(phase1DHGroupNumbers)(_.phase1DHGroupNumbers(_))
        .ifSome(phase2DHGroupNumbers)(_.phase2DHGroupNumbers(_))
        .ifSome(iKEVersions)(_.iKEVersions(_))
        .ifSome(startupAction)(_.startupAction(_))
        .build

    def monitorInstancesRequest(
      instanceIds: Option[List[InstanceId]] = None
    ): MonitorInstancesRequest =
      MonitorInstancesRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def monitoring(
      state: Option[String] = None
    ): Monitoring =
      Monitoring
        .builder
        .ifSome(state)(_.state(_))
        .build

    def moveAddressToVpcRequest(
      publicIp: Option[String] = None
    ): MoveAddressToVpcRequest =
      MoveAddressToVpcRequest
        .builder
        .ifSome(publicIp)(_.publicIp(_))
        .build

    def movingAddressStatus(
      moveStatus: Option[String] = None,
      publicIp: Option[String] = None
    ): MovingAddressStatus =
      MovingAddressStatus
        .builder
        .ifSome(moveStatus)(_.moveStatus(_))
        .ifSome(publicIp)(_.publicIp(_))
        .build

    def natGateway(
      createTime: Option[DateTime] = None,
      deleteTime: Option[DateTime] = None,
      failureCode: Option[String] = None,
      failureMessage: Option[String] = None,
      natGatewayAddresses: Option[List[NatGatewayAddress]] = None,
      natGatewayId: Option[String] = None,
      provisionedBandwidth: Option[ProvisionedBandwidth] = None,
      state: Option[String] = None,
      subnetId: Option[String] = None,
      vpcId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      connectivityType: Option[String] = None
    ): NatGateway =
      NatGateway
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(deleteTime)(_.deleteTime(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(natGatewayAddresses)(_.natGatewayAddresses(_))
        .ifSome(natGatewayId)(_.natGatewayId(_))
        .ifSome(provisionedBandwidth)(_.provisionedBandwidth(_))
        .ifSome(state)(_.state(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(connectivityType)(_.connectivityType(_))
        .build

    def natGatewayAddress(
      allocationId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      privateIp: Option[String] = None,
      publicIp: Option[String] = None
    ): NatGatewayAddress =
      NatGatewayAddress
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIp)(_.privateIp(_))
        .ifSome(publicIp)(_.publicIp(_))
        .build

    def networkAcl(
      associations: Option[List[NetworkAclAssociation]] = None,
      entries: Option[List[NetworkAclEntry]] = None,
      isDefault: Option[Boolean] = None,
      networkAclId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      vpcId: Option[String] = None,
      ownerId: Option[String] = None
    ): NetworkAcl =
      NetworkAcl
        .builder
        .ifSome(associations)(_.associations(_))
        .ifSome(entries)(_.entries(_))
        .ifSome(isDefault)(_.isDefault(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .build

    def networkAclAssociation(
      networkAclAssociationId: Option[String] = None,
      networkAclId: Option[String] = None,
      subnetId: Option[String] = None
    ): NetworkAclAssociation =
      NetworkAclAssociation
        .builder
        .ifSome(networkAclAssociationId)(_.networkAclAssociationId(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def networkAclEntry(
      cidrBlock: Option[String] = None,
      egress: Option[Boolean] = None,
      icmpTypeCode: Option[IcmpTypeCode] = None,
      ipv6CidrBlock: Option[String] = None,
      portRange: Option[PortRange] = None,
      protocol: Option[String] = None,
      ruleAction: Option[String] = None,
      ruleNumber: Option[Int] = None
    ): NetworkAclEntry =
      NetworkAclEntry
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(egress)(_.egress(_))
        .ifSome(icmpTypeCode)(_.icmpTypeCode(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(portRange)(_.portRange(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .build

    def networkCardInfo(
      networkCardIndex: Option[Int] = None,
      networkPerformance: Option[String] = None,
      maximumNetworkInterfaces: Option[Int] = None
    ): NetworkCardInfo =
      NetworkCardInfo
        .builder
        .ifSome(networkCardIndex)(_.networkCardIndex(_))
        .ifSome(networkPerformance)(_.networkPerformance(_))
        .ifSome(maximumNetworkInterfaces)(_.maximumNetworkInterfaces(_))
        .build

    def networkInfo(
      networkPerformance: Option[String] = None,
      maximumNetworkInterfaces: Option[Int] = None,
      maximumNetworkCards: Option[Int] = None,
      defaultNetworkCardIndex: Option[Int] = None,
      networkCards: Option[List[NetworkCardInfo]] = None,
      ipv4AddressesPerInterface: Option[Int] = None,
      ipv6AddressesPerInterface: Option[Int] = None,
      ipv6Supported: Option[Boolean] = None,
      enaSupport: Option[String] = None,
      efaSupported: Option[Boolean] = None,
      efaInfo: Option[EfaInfo] = None
    ): NetworkInfo =
      NetworkInfo
        .builder
        .ifSome(networkPerformance)(_.networkPerformance(_))
        .ifSome(maximumNetworkInterfaces)(_.maximumNetworkInterfaces(_))
        .ifSome(maximumNetworkCards)(_.maximumNetworkCards(_))
        .ifSome(defaultNetworkCardIndex)(_.defaultNetworkCardIndex(_))
        .ifSome(networkCards)(_.networkCards(_))
        .ifSome(ipv4AddressesPerInterface)(_.ipv4AddressesPerInterface(_))
        .ifSome(ipv6AddressesPerInterface)(_.ipv6AddressesPerInterface(_))
        .ifSome(ipv6Supported)(_.ipv6Supported(_))
        .ifSome(enaSupport)(_.enaSupport(_))
        .ifSome(efaSupported)(_.efaSupported(_))
        .ifSome(efaInfo)(_.efaInfo(_))
        .build

    def networkInsightsAnalysis(
      networkInsightsAnalysisId: Option[String] = None,
      networkInsightsAnalysisArn: Option[String] = None,
      networkInsightsPathId: Option[String] = None,
      filterInArns: Option[List[ResourceArn]] = None,
      startDate: Option[MillisecondDateTime] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      networkPathFound: Option[Boolean] = None,
      forwardPathComponents: Option[List[PathComponent]] = None,
      returnPathComponents: Option[List[PathComponent]] = None,
      explanations: Option[List[Explanation]] = None,
      alternatePathHints: Option[List[AlternatePathHint]] = None,
      tags: Option[List[Tag]] = None
    ): NetworkInsightsAnalysis =
      NetworkInsightsAnalysis
        .builder
        .ifSome(networkInsightsAnalysisId)(_.networkInsightsAnalysisId(_))
        .ifSome(networkInsightsAnalysisArn)(_.networkInsightsAnalysisArn(_))
        .ifSome(networkInsightsPathId)(_.networkInsightsPathId(_))
        .ifSome(filterInArns)(_.filterInArns(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(networkPathFound)(_.networkPathFound(_))
        .ifSome(forwardPathComponents)(_.forwardPathComponents(_))
        .ifSome(returnPathComponents)(_.returnPathComponents(_))
        .ifSome(explanations)(_.explanations(_))
        .ifSome(alternatePathHints)(_.alternatePathHints(_))
        .ifSome(tags)(_.tags(_))
        .build

    def networkInsightsPath(
      networkInsightsPathId: Option[String] = None,
      networkInsightsPathArn: Option[String] = None,
      createdDate: Option[MillisecondDateTime] = None,
      source: Option[String] = None,
      destination: Option[String] = None,
      sourceIp: Option[String] = None,
      destinationIp: Option[String] = None,
      protocol: Option[String] = None,
      destinationPort: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): NetworkInsightsPath =
      NetworkInsightsPath
        .builder
        .ifSome(networkInsightsPathId)(_.networkInsightsPathId(_))
        .ifSome(networkInsightsPathArn)(_.networkInsightsPathArn(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(sourceIp)(_.sourceIp(_))
        .ifSome(destinationIp)(_.destinationIp(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(destinationPort)(_.destinationPort(_))
        .ifSome(tags)(_.tags(_))
        .build

    def networkInterface(
      association: Option[NetworkInterfaceAssociation] = None,
      attachment: Option[NetworkInterfaceAttachment] = None,
      availabilityZone: Option[String] = None,
      description: Option[String] = None,
      groups: Option[List[GroupIdentifier]] = None,
      interfaceType: Option[String] = None,
      ipv6Addresses: Option[List[NetworkInterfaceIpv6Address]] = None,
      macAddress: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      outpostArn: Option[String] = None,
      ownerId: Option[String] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[NetworkInterfacePrivateIpAddress]] = None,
      requesterId: Option[String] = None,
      requesterManaged: Option[Boolean] = None,
      sourceDestCheck: Option[Boolean] = None,
      status: Option[String] = None,
      subnetId: Option[String] = None,
      tagSet: Option[List[Tag]] = None,
      vpcId: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(association)(_.association(_))
        .ifSome(attachment)(_.attachment(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(description)(_.description(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(interfaceType)(_.interfaceType(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(requesterId)(_.requesterId(_))
        .ifSome(requesterManaged)(_.requesterManaged(_))
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .ifSome(status)(_.status(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(tagSet)(_.tagSet(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def networkInterfaceAssociation(
      allocationId: Option[String] = None,
      associationId: Option[String] = None,
      ipOwnerId: Option[String] = None,
      publicDnsName: Option[String] = None,
      publicIp: Option[String] = None,
      customerOwnedIp: Option[String] = None,
      carrierIp: Option[String] = None
    ): NetworkInterfaceAssociation =
      NetworkInterfaceAssociation
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(ipOwnerId)(_.ipOwnerId(_))
        .ifSome(publicDnsName)(_.publicDnsName(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(customerOwnedIp)(_.customerOwnedIp(_))
        .ifSome(carrierIp)(_.carrierIp(_))
        .build

    def networkInterfaceAttachment(
      attachTime: Option[DateTime] = None,
      attachmentId: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None,
      deviceIndex: Option[Int] = None,
      networkCardIndex: Option[Int] = None,
      instanceId: Option[String] = None,
      instanceOwnerId: Option[String] = None,
      status: Option[String] = None
    ): NetworkInterfaceAttachment =
      NetworkInterfaceAttachment
        .builder
        .ifSome(attachTime)(_.attachTime(_))
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(networkCardIndex)(_.networkCardIndex(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceOwnerId)(_.instanceOwnerId(_))
        .ifSome(status)(_.status(_))
        .build

    def networkInterfaceAttachmentChanges(
      attachmentId: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None
    ): NetworkInterfaceAttachmentChanges =
      NetworkInterfaceAttachmentChanges
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .build

    def networkInterfaceIpv6Address(
      ipv6Address: Option[String] = None
    ): NetworkInterfaceIpv6Address =
      NetworkInterfaceIpv6Address
        .builder
        .ifSome(ipv6Address)(_.ipv6Address(_))
        .build

    def networkInterfacePermission(
      networkInterfacePermissionId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      awsAccountId: Option[String] = None,
      awsService: Option[String] = None,
      permission: Option[String] = None,
      permissionState: Option[NetworkInterfacePermissionState] = None
    ): NetworkInterfacePermission =
      NetworkInterfacePermission
        .builder
        .ifSome(networkInterfacePermissionId)(_.networkInterfacePermissionId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(awsService)(_.awsService(_))
        .ifSome(permission)(_.permission(_))
        .ifSome(permissionState)(_.permissionState(_))
        .build

    def networkInterfacePermissionState(
      state: Option[String] = None,
      statusMessage: Option[String] = None
    ): NetworkInterfacePermissionState =
      NetworkInterfacePermissionState
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def networkInterfacePrivateIpAddress(
      association: Option[NetworkInterfaceAssociation] = None,
      primary: Option[Boolean] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None
    ): NetworkInterfacePrivateIpAddress =
      NetworkInterfacePrivateIpAddress
        .builder
        .ifSome(association)(_.association(_))
        .ifSome(primary)(_.primary(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def newDhcpConfiguration(
      key: Option[String] = None,
      values: Option[List[String]] = None
    ): NewDhcpConfiguration =
      NewDhcpConfiguration
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def onDemandOptions(
      allocationStrategy: Option[String] = None,
      capacityReservationOptions: Option[CapacityReservationOptions] = None,
      singleInstanceType: Option[Boolean] = None,
      singleAvailabilityZone: Option[Boolean] = None,
      minTargetCapacity: Option[Int] = None,
      maxTotalPrice: Option[String] = None
    ): OnDemandOptions =
      OnDemandOptions
        .builder
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .ifSome(capacityReservationOptions)(_.capacityReservationOptions(_))
        .ifSome(singleInstanceType)(_.singleInstanceType(_))
        .ifSome(singleAvailabilityZone)(_.singleAvailabilityZone(_))
        .ifSome(minTargetCapacity)(_.minTargetCapacity(_))
        .ifSome(maxTotalPrice)(_.maxTotalPrice(_))
        .build

    def onDemandOptionsRequest(
      allocationStrategy: Option[String] = None,
      capacityReservationOptions: Option[CapacityReservationOptionsRequest] = None,
      singleInstanceType: Option[Boolean] = None,
      singleAvailabilityZone: Option[Boolean] = None,
      minTargetCapacity: Option[Int] = None,
      maxTotalPrice: Option[String] = None
    ): OnDemandOptionsRequest =
      OnDemandOptionsRequest
        .builder
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .ifSome(capacityReservationOptions)(_.capacityReservationOptions(_))
        .ifSome(singleInstanceType)(_.singleInstanceType(_))
        .ifSome(singleAvailabilityZone)(_.singleAvailabilityZone(_))
        .ifSome(minTargetCapacity)(_.minTargetCapacity(_))
        .ifSome(maxTotalPrice)(_.maxTotalPrice(_))
        .build

    def pathComponent(
      sequenceNumber: Option[Int] = None,
      aclRule: Option[AnalysisAclRule] = None,
      component: Option[AnalysisComponent] = None,
      destinationVpc: Option[AnalysisComponent] = None,
      outboundHeader: Option[AnalysisPacketHeader] = None,
      inboundHeader: Option[AnalysisPacketHeader] = None,
      routeTableRoute: Option[AnalysisRouteTableRoute] = None,
      securityGroupRule: Option[AnalysisSecurityGroupRule] = None,
      sourceVpc: Option[AnalysisComponent] = None,
      subnet: Option[AnalysisComponent] = None,
      vpc: Option[AnalysisComponent] = None
    ): PathComponent =
      PathComponent
        .builder
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .ifSome(aclRule)(_.aclRule(_))
        .ifSome(component)(_.component(_))
        .ifSome(destinationVpc)(_.destinationVpc(_))
        .ifSome(outboundHeader)(_.outboundHeader(_))
        .ifSome(inboundHeader)(_.inboundHeader(_))
        .ifSome(routeTableRoute)(_.routeTableRoute(_))
        .ifSome(securityGroupRule)(_.securityGroupRule(_))
        .ifSome(sourceVpc)(_.sourceVpc(_))
        .ifSome(subnet)(_.subnet(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def pciId(
      deviceId: Option[String] = None,
      vendorId: Option[String] = None,
      subsystemId: Option[String] = None,
      subsystemVendorId: Option[String] = None
    ): PciId =
      PciId
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(vendorId)(_.vendorId(_))
        .ifSome(subsystemId)(_.subsystemId(_))
        .ifSome(subsystemVendorId)(_.subsystemVendorId(_))
        .build

    def peeringAttachmentStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): PeeringAttachmentStatus =
      PeeringAttachmentStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def peeringConnectionOptions(
      allowDnsResolutionFromRemoteVpc: Option[Boolean] = None,
      allowEgressFromLocalClassicLinkToRemoteVpc: Option[Boolean] = None,
      allowEgressFromLocalVpcToRemoteClassicLink: Option[Boolean] = None
    ): PeeringConnectionOptions =
      PeeringConnectionOptions
        .builder
        .ifSome(allowDnsResolutionFromRemoteVpc)(_.allowDnsResolutionFromRemoteVpc(_))
        .ifSome(allowEgressFromLocalClassicLinkToRemoteVpc)(_.allowEgressFromLocalClassicLinkToRemoteVpc(_))
        .ifSome(allowEgressFromLocalVpcToRemoteClassicLink)(_.allowEgressFromLocalVpcToRemoteClassicLink(_))
        .build

    def peeringConnectionOptionsRequest(
      allowDnsResolutionFromRemoteVpc: Option[Boolean] = None,
      allowEgressFromLocalClassicLinkToRemoteVpc: Option[Boolean] = None,
      allowEgressFromLocalVpcToRemoteClassicLink: Option[Boolean] = None
    ): PeeringConnectionOptionsRequest =
      PeeringConnectionOptionsRequest
        .builder
        .ifSome(allowDnsResolutionFromRemoteVpc)(_.allowDnsResolutionFromRemoteVpc(_))
        .ifSome(allowEgressFromLocalClassicLinkToRemoteVpc)(_.allowEgressFromLocalClassicLinkToRemoteVpc(_))
        .ifSome(allowEgressFromLocalVpcToRemoteClassicLink)(_.allowEgressFromLocalVpcToRemoteClassicLink(_))
        .build

    def peeringTgwInfo(
      transitGatewayId: Option[String] = None,
      ownerId: Option[String] = None,
      region: Option[String] = None
    ): PeeringTgwInfo =
      PeeringTgwInfo
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(region)(_.region(_))
        .build

    def phase1DHGroupNumbersListValue(
      value: Option[Int] = None
    ): Phase1DHGroupNumbersListValue =
      Phase1DHGroupNumbersListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase1DHGroupNumbersRequestListValue(
      value: Option[Int] = None
    ): Phase1DHGroupNumbersRequestListValue =
      Phase1DHGroupNumbersRequestListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase1EncryptionAlgorithmsListValue(
      value: Option[String] = None
    ): Phase1EncryptionAlgorithmsListValue =
      Phase1EncryptionAlgorithmsListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase1EncryptionAlgorithmsRequestListValue(
      value: Option[String] = None
    ): Phase1EncryptionAlgorithmsRequestListValue =
      Phase1EncryptionAlgorithmsRequestListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase1IntegrityAlgorithmsListValue(
      value: Option[String] = None
    ): Phase1IntegrityAlgorithmsListValue =
      Phase1IntegrityAlgorithmsListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase1IntegrityAlgorithmsRequestListValue(
      value: Option[String] = None
    ): Phase1IntegrityAlgorithmsRequestListValue =
      Phase1IntegrityAlgorithmsRequestListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase2DHGroupNumbersListValue(
      value: Option[Int] = None
    ): Phase2DHGroupNumbersListValue =
      Phase2DHGroupNumbersListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase2DHGroupNumbersRequestListValue(
      value: Option[Int] = None
    ): Phase2DHGroupNumbersRequestListValue =
      Phase2DHGroupNumbersRequestListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase2EncryptionAlgorithmsListValue(
      value: Option[String] = None
    ): Phase2EncryptionAlgorithmsListValue =
      Phase2EncryptionAlgorithmsListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase2EncryptionAlgorithmsRequestListValue(
      value: Option[String] = None
    ): Phase2EncryptionAlgorithmsRequestListValue =
      Phase2EncryptionAlgorithmsRequestListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase2IntegrityAlgorithmsListValue(
      value: Option[String] = None
    ): Phase2IntegrityAlgorithmsListValue =
      Phase2IntegrityAlgorithmsListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def phase2IntegrityAlgorithmsRequestListValue(
      value: Option[String] = None
    ): Phase2IntegrityAlgorithmsRequestListValue =
      Phase2IntegrityAlgorithmsRequestListValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def placement(
      availabilityZone: Option[String] = None,
      affinity: Option[String] = None,
      groupName: Option[String] = None,
      partitionNumber: Option[Int] = None,
      hostId: Option[String] = None,
      tenancy: Option[String] = None,
      spreadDomain: Option[String] = None,
      hostResourceGroupArn: Option[String] = None
    ): Placement =
      Placement
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(affinity)(_.affinity(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(partitionNumber)(_.partitionNumber(_))
        .ifSome(hostId)(_.hostId(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(spreadDomain)(_.spreadDomain(_))
        .ifSome(hostResourceGroupArn)(_.hostResourceGroupArn(_))
        .build

    def placementGroup(
      groupName: Option[String] = None,
      state: Option[String] = None,
      strategy: Option[String] = None,
      partitionCount: Option[Int] = None,
      groupId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PlacementGroup =
      PlacementGroup
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(state)(_.state(_))
        .ifSome(strategy)(_.strategy(_))
        .ifSome(partitionCount)(_.partitionCount(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def placementGroupInfo(
      supportedStrategies: Option[List[PlacementGroupStrategy]] = None
    ): PlacementGroupInfo =
      PlacementGroupInfo
        .builder
        .ifSome(supportedStrategies)(_.supportedStrategies(_))
        .build

    def placementResponse(
      groupName: Option[String] = None
    ): PlacementResponse =
      PlacementResponse
        .builder
        .ifSome(groupName)(_.groupName(_))
        .build

    def poolCidrBlock(
      cidr: Option[String] = None
    ): PoolCidrBlock =
      PoolCidrBlock
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def portRange(
      from: Option[Int] = None,
      to: Option[Int] = None
    ): PortRange =
      PortRange
        .builder
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .build

    def prefixList(
      cidrs: Option[List[String]] = None,
      prefixListId: Option[String] = None,
      prefixListName: Option[String] = None
    ): PrefixList =
      PrefixList
        .builder
        .ifSome(cidrs)(_.cidrs(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(prefixListName)(_.prefixListName(_))
        .build

    def prefixListAssociation(
      resourceId: Option[String] = None,
      resourceOwner: Option[String] = None
    ): PrefixListAssociation =
      PrefixListAssociation
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .build

    def prefixListEntry(
      cidr: Option[String] = None,
      description: Option[String] = None
    ): PrefixListEntry =
      PrefixListEntry
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(description)(_.description(_))
        .build

    def prefixListId(
      description: Option[String] = None,
      prefixListId: Option[String] = None
    ): PrefixListId =
      PrefixListId
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .build

    def priceSchedule(
      active: Option[Boolean] = None,
      currencyCode: Option[String] = None,
      price: Option[Double] = None,
      term: Option[Long] = None
    ): PriceSchedule =
      PriceSchedule
        .builder
        .ifSome(active)(_.active(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(price)(_.price(_))
        .ifSome(term)(_.term(_))
        .build

    def priceScheduleSpecification(
      currencyCode: Option[String] = None,
      price: Option[Double] = None,
      term: Option[Long] = None
    ): PriceScheduleSpecification =
      PriceScheduleSpecification
        .builder
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(price)(_.price(_))
        .ifSome(term)(_.term(_))
        .build

    def pricingDetail(
      count: Option[Int] = None,
      price: Option[Double] = None
    ): PricingDetail =
      PricingDetail
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(price)(_.price(_))
        .build

    def principalIdFormat(
      arn: Option[String] = None,
      statuses: Option[List[IdFormat]] = None
    ): PrincipalIdFormat =
      PrincipalIdFormat
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(statuses)(_.statuses(_))
        .build

    def privateDnsDetails(
      privateDnsName: Option[String] = None
    ): PrivateDnsDetails =
      PrivateDnsDetails
        .builder
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .build

    def privateDnsNameConfiguration(
      state: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None,
      name: Option[String] = None
    ): PrivateDnsNameConfiguration =
      PrivateDnsNameConfiguration
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .ifSome(name)(_.name(_))
        .build

    def privateIpAddressSpecification(
      primary: Option[Boolean] = None,
      privateIpAddress: Option[String] = None
    ): PrivateIpAddressSpecification =
      PrivateIpAddressSpecification
        .builder
        .ifSome(primary)(_.primary(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def processorInfo(
      supportedArchitectures: Option[List[ArchitectureType]] = None,
      sustainedClockSpeedInGhz: Option[ProcessorSustainedClockSpeed] = None
    ): ProcessorInfo =
      ProcessorInfo
        .builder
        .ifSome(supportedArchitectures)(_.supportedArchitectures(_))
        .ifSome(sustainedClockSpeedInGhz)(_.sustainedClockSpeedInGhz(_))
        .build

    def productCode(
      productCodeId: Option[String] = None,
      productCodeType: Option[String] = None
    ): ProductCode =
      ProductCode
        .builder
        .ifSome(productCodeId)(_.productCodeId(_))
        .ifSome(productCodeType)(_.productCodeType(_))
        .build

    def propagatingVgw(
      gatewayId: Option[String] = None
    ): PropagatingVgw =
      PropagatingVgw
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .build

    def provisionByoipCidrRequest(
      cidr: Option[String] = None,
      cidrAuthorizationContext: Option[CidrAuthorizationContext] = None,
      publiclyAdvertisable: Option[Boolean] = None,
      description: Option[String] = None,
      poolTagSpecifications: Option[List[TagSpecification]] = None
    ): ProvisionByoipCidrRequest =
      ProvisionByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(cidrAuthorizationContext)(_.cidrAuthorizationContext(_))
        .ifSome(publiclyAdvertisable)(_.publiclyAdvertisable(_))
        .ifSome(description)(_.description(_))
        .ifSome(poolTagSpecifications)(_.poolTagSpecifications(_))
        .build

    def provisionedBandwidth(
      provisionTime: Option[DateTime] = None,
      provisioned: Option[String] = None,
      requestTime: Option[DateTime] = None,
      requested: Option[String] = None,
      status: Option[String] = None
    ): ProvisionedBandwidth =
      ProvisionedBandwidth
        .builder
        .ifSome(provisionTime)(_.provisionTime(_))
        .ifSome(provisioned)(_.provisioned(_))
        .ifSome(requestTime)(_.requestTime(_))
        .ifSome(requested)(_.requested(_))
        .ifSome(status)(_.status(_))
        .build

    def ptrUpdateStatus(
      value: Option[String] = None,
      status: Option[String] = None,
      reason: Option[String] = None
    ): PtrUpdateStatus =
      PtrUpdateStatus
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .build

    def publicIpv4Pool(
      poolId: Option[String] = None,
      description: Option[String] = None,
      poolAddressRanges: Option[List[PublicIpv4PoolRange]] = None,
      totalAddressCount: Option[Int] = None,
      totalAvailableAddressCount: Option[Int] = None,
      networkBorderGroup: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PublicIpv4Pool =
      PublicIpv4Pool
        .builder
        .ifSome(poolId)(_.poolId(_))
        .ifSome(description)(_.description(_))
        .ifSome(poolAddressRanges)(_.poolAddressRanges(_))
        .ifSome(totalAddressCount)(_.totalAddressCount(_))
        .ifSome(totalAvailableAddressCount)(_.totalAvailableAddressCount(_))
        .ifSome(networkBorderGroup)(_.networkBorderGroup(_))
        .ifSome(tags)(_.tags(_))
        .build

    def publicIpv4PoolRange(
      firstAddress: Option[String] = None,
      lastAddress: Option[String] = None,
      addressCount: Option[Int] = None,
      availableAddressCount: Option[Int] = None
    ): PublicIpv4PoolRange =
      PublicIpv4PoolRange
        .builder
        .ifSome(firstAddress)(_.firstAddress(_))
        .ifSome(lastAddress)(_.lastAddress(_))
        .ifSome(addressCount)(_.addressCount(_))
        .ifSome(availableAddressCount)(_.availableAddressCount(_))
        .build

    def purchase(
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      hostIdSet: Option[List[String]] = None,
      hostReservationId: Option[String] = None,
      hourlyPrice: Option[String] = None,
      instanceFamily: Option[String] = None,
      paymentOption: Option[String] = None,
      upfrontPrice: Option[String] = None
    ): Purchase =
      Purchase
        .builder
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(hostIdSet)(_.hostIdSet(_))
        .ifSome(hostReservationId)(_.hostReservationId(_))
        .ifSome(hourlyPrice)(_.hourlyPrice(_))
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(upfrontPrice)(_.upfrontPrice(_))
        .build

    def purchaseHostReservationRequest(
      clientToken: Option[String] = None,
      currencyCode: Option[String] = None,
      hostIdSet: Option[List[DedicatedHostId]] = None,
      limitPrice: Option[String] = None,
      offeringId: Option[String] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): PurchaseHostReservationRequest =
      PurchaseHostReservationRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(hostIdSet)(_.hostIdSet(_))
        .ifSome(limitPrice)(_.limitPrice(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def purchaseRequest(
      instanceCount: Option[Int] = None,
      purchaseToken: Option[String] = None
    ): PurchaseRequest =
      PurchaseRequest
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(purchaseToken)(_.purchaseToken(_))
        .build

    def purchaseReservedInstancesOfferingRequest(
      instanceCount: Option[Int] = None,
      reservedInstancesOfferingId: Option[String] = None,
      limitPrice: Option[ReservedInstanceLimitPrice] = None,
      purchaseTime: Option[DateTime] = None
    ): PurchaseReservedInstancesOfferingRequest =
      PurchaseReservedInstancesOfferingRequest
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(reservedInstancesOfferingId)(_.reservedInstancesOfferingId(_))
        .ifSome(limitPrice)(_.limitPrice(_))
        .ifSome(purchaseTime)(_.purchaseTime(_))
        .build

    def purchaseScheduledInstancesRequest(
      clientToken: Option[String] = None,
      purchaseRequests: Option[List[PurchaseRequest]] = None
    ): PurchaseScheduledInstancesRequest =
      PurchaseScheduledInstancesRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(purchaseRequests)(_.purchaseRequests(_))
        .build

    def rebootInstancesRequest(
      instanceIds: Option[List[InstanceId]] = None
    ): RebootInstancesRequest =
      RebootInstancesRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def recurringCharge(
      amount: Option[Double] = None,
      frequency: Option[String] = None
    ): RecurringCharge =
      RecurringCharge
        .builder
        .ifSome(amount)(_.amount(_))
        .ifSome(frequency)(_.frequency(_))
        .build

    def region(
      endpoint: Option[String] = None,
      regionName: Option[String] = None,
      optInStatus: Option[String] = None
    ): Region =
      Region
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(optInStatus)(_.optInStatus(_))
        .build

    def registerImageRequest(
      imageLocation: Option[String] = None,
      architecture: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      description: Option[String] = None,
      enaSupport: Option[Boolean] = None,
      kernelId: Option[String] = None,
      name: Option[String] = None,
      billingProducts: Option[List[String]] = None,
      ramdiskId: Option[String] = None,
      rootDeviceName: Option[String] = None,
      sriovNetSupport: Option[String] = None,
      virtualizationType: Option[String] = None,
      bootMode: Option[String] = None
    ): RegisterImageRequest =
      RegisterImageRequest
        .builder
        .ifSome(imageLocation)(_.imageLocation(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(description)(_.description(_))
        .ifSome(enaSupport)(_.enaSupport(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(name)(_.name(_))
        .ifSome(billingProducts)(_.billingProducts(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(rootDeviceName)(_.rootDeviceName(_))
        .ifSome(sriovNetSupport)(_.sriovNetSupport(_))
        .ifSome(virtualizationType)(_.virtualizationType(_))
        .ifSome(bootMode)(_.bootMode(_))
        .build

    def registerInstanceEventNotificationAttributesRequest(
      instanceTagAttribute: Option[RegisterInstanceTagAttributeRequest] = None
    ): RegisterInstanceEventNotificationAttributesRequest =
      RegisterInstanceEventNotificationAttributesRequest
        .builder
        .ifSome(instanceTagAttribute)(_.instanceTagAttribute(_))
        .build

    def registerInstanceTagAttributeRequest(
      includeAllTagsOfInstance: Option[Boolean] = None,
      instanceTagKeys: Option[List[String]] = None
    ): RegisterInstanceTagAttributeRequest =
      RegisterInstanceTagAttributeRequest
        .builder
        .ifSome(includeAllTagsOfInstance)(_.includeAllTagsOfInstance(_))
        .ifSome(instanceTagKeys)(_.instanceTagKeys(_))
        .build

    def registerTransitGatewayMulticastGroupMembersRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      groupIpAddress: Option[String] = None,
      networkInterfaceIds: Option[List[NetworkInterfaceId]] = None
    ): RegisterTransitGatewayMulticastGroupMembersRequest =
      RegisterTransitGatewayMulticastGroupMembersRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .build

    def registerTransitGatewayMulticastGroupSourcesRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      groupIpAddress: Option[String] = None,
      networkInterfaceIds: Option[List[NetworkInterfaceId]] = None
    ): RegisterTransitGatewayMulticastGroupSourcesRequest =
      RegisterTransitGatewayMulticastGroupSourcesRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .build

    def rejectTransitGatewayMulticastDomainAssociationsRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): RejectTransitGatewayMulticastDomainAssociationsRequest =
      RejectTransitGatewayMulticastDomainAssociationsRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def rejectTransitGatewayPeeringAttachmentRequest(
      transitGatewayAttachmentId: Option[String] = None
    ): RejectTransitGatewayPeeringAttachmentRequest =
      RejectTransitGatewayPeeringAttachmentRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def rejectTransitGatewayVpcAttachmentRequest(
      transitGatewayAttachmentId: Option[String] = None
    ): RejectTransitGatewayVpcAttachmentRequest =
      RejectTransitGatewayVpcAttachmentRequest
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .build

    def rejectVpcEndpointConnectionsRequest(
      serviceId: Option[String] = None,
      vpcEndpointIds: Option[List[VpcEndpointId]] = None
    ): RejectVpcEndpointConnectionsRequest =
      RejectVpcEndpointConnectionsRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(vpcEndpointIds)(_.vpcEndpointIds(_))
        .build

    def rejectVpcPeeringConnectionRequest(
      vpcPeeringConnectionId: Option[String] = None
    ): RejectVpcPeeringConnectionRequest =
      RejectVpcPeeringConnectionRequest
        .builder
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def releaseAddressRequest(
      allocationId: Option[String] = None,
      publicIp: Option[String] = None,
      networkBorderGroup: Option[String] = None
    ): ReleaseAddressRequest =
      ReleaseAddressRequest
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(networkBorderGroup)(_.networkBorderGroup(_))
        .build

    def releaseHostsRequest(
      hostIds: Option[List[DedicatedHostId]] = None
    ): ReleaseHostsRequest =
      ReleaseHostsRequest
        .builder
        .ifSome(hostIds)(_.hostIds(_))
        .build

    def removePrefixListEntry(
      cidr: Option[String] = None
    ): RemovePrefixListEntry =
      RemovePrefixListEntry
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def replaceIamInstanceProfileAssociationRequest(
      iamInstanceProfile: Option[IamInstanceProfileSpecification] = None,
      associationId: Option[String] = None
    ): ReplaceIamInstanceProfileAssociationRequest =
      ReplaceIamInstanceProfileAssociationRequest
        .builder
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(associationId)(_.associationId(_))
        .build

    def replaceNetworkAclAssociationRequest(
      associationId: Option[String] = None,
      networkAclId: Option[String] = None
    ): ReplaceNetworkAclAssociationRequest =
      ReplaceNetworkAclAssociationRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .build

    def replaceNetworkAclEntryRequest(
      cidrBlock: Option[String] = None,
      egress: Option[Boolean] = None,
      icmpTypeCode: Option[IcmpTypeCode] = None,
      ipv6CidrBlock: Option[String] = None,
      networkAclId: Option[String] = None,
      portRange: Option[PortRange] = None,
      protocol: Option[String] = None,
      ruleAction: Option[String] = None,
      ruleNumber: Option[Int] = None
    ): ReplaceNetworkAclEntryRequest =
      ReplaceNetworkAclEntryRequest
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(egress)(_.egress(_))
        .ifSome(icmpTypeCode)(_.icmpTypeCode(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .ifSome(portRange)(_.portRange(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .build

    def replaceRootVolumeTask(
      replaceRootVolumeTaskId: Option[String] = None,
      instanceId: Option[String] = None,
      taskState: Option[String] = None,
      startTime: Option[String] = None,
      completeTime: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ReplaceRootVolumeTask =
      ReplaceRootVolumeTask
        .builder
        .ifSome(replaceRootVolumeTaskId)(_.replaceRootVolumeTaskId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(taskState)(_.taskState(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(completeTime)(_.completeTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def replaceRouteRequest(
      destinationCidrBlock: Option[String] = None,
      destinationIpv6CidrBlock: Option[String] = None,
      destinationPrefixListId: Option[String] = None,
      vpcEndpointId: Option[String] = None,
      egressOnlyInternetGatewayId: Option[String] = None,
      gatewayId: Option[String] = None,
      instanceId: Option[String] = None,
      localTarget: Option[Boolean] = None,
      natGatewayId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      localGatewayId: Option[String] = None,
      carrierGatewayId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      routeTableId: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): ReplaceRouteRequest =
      ReplaceRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(destinationIpv6CidrBlock)(_.destinationIpv6CidrBlock(_))
        .ifSome(destinationPrefixListId)(_.destinationPrefixListId(_))
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(egressOnlyInternetGatewayId)(_.egressOnlyInternetGatewayId(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(localTarget)(_.localTarget(_))
        .ifSome(natGatewayId)(_.natGatewayId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(carrierGatewayId)(_.carrierGatewayId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def replaceRouteTableAssociationRequest(
      associationId: Option[String] = None,
      routeTableId: Option[String] = None
    ): ReplaceRouteTableAssociationRequest =
      ReplaceRouteTableAssociationRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .build

    def replaceTransitGatewayRouteRequest(
      destinationCidrBlock: Option[String] = None,
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      blackhole: Option[Boolean] = None
    ): ReplaceTransitGatewayRouteRequest =
      ReplaceTransitGatewayRouteRequest
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(blackhole)(_.blackhole(_))
        .build

    def reportInstanceStatusRequest(
      description: Option[String] = None,
      endTime: Option[DateTime] = None,
      instances: Option[List[InstanceId]] = None,
      reasonCodes: Option[List[ReportInstanceReasonCodes]] = None,
      startTime: Option[DateTime] = None,
      status: Option[String] = None
    ): ReportInstanceStatusRequest =
      ReportInstanceStatusRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(reasonCodes)(_.reasonCodes(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(status)(_.status(_))
        .build

    def requestLaunchTemplateData(
      kernelId: Option[String] = None,
      ebsOptimized: Option[Boolean] = None,
      iamInstanceProfile: Option[LaunchTemplateIamInstanceProfileSpecificationRequest] = None,
      blockDeviceMappings: Option[List[LaunchTemplateBlockDeviceMappingRequest]] = None,
      networkInterfaces: Option[List[LaunchTemplateInstanceNetworkInterfaceSpecificationRequest]] = None,
      imageId: Option[String] = None,
      instanceType: Option[String] = None,
      keyName: Option[String] = None,
      monitoring: Option[LaunchTemplatesMonitoringRequest] = None,
      placement: Option[LaunchTemplatePlacementRequest] = None,
      ramDiskId: Option[String] = None,
      disableApiTermination: Option[Boolean] = None,
      instanceInitiatedShutdownBehavior: Option[String] = None,
      userData: Option[String] = None,
      tagSpecifications: Option[List[LaunchTemplateTagSpecificationRequest]] = None,
      elasticGpuSpecifications: Option[List[ElasticGpuSpecification]] = None,
      elasticInferenceAccelerators: Option[List[LaunchTemplateElasticInferenceAccelerator]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      securityGroups: Option[List[SecurityGroupName]] = None,
      instanceMarketOptions: Option[LaunchTemplateInstanceMarketOptionsRequest] = None,
      creditSpecification: Option[CreditSpecificationRequest] = None,
      cpuOptions: Option[LaunchTemplateCpuOptionsRequest] = None,
      capacityReservationSpecification: Option[LaunchTemplateCapacityReservationSpecificationRequest] = None,
      licenseSpecifications: Option[List[LaunchTemplateLicenseConfigurationRequest]] = None,
      hibernationOptions: Option[LaunchTemplateHibernationOptionsRequest] = None,
      metadataOptions: Option[LaunchTemplateInstanceMetadataOptionsRequest] = None,
      enclaveOptions: Option[LaunchTemplateEnclaveOptionsRequest] = None
    ): RequestLaunchTemplateData =
      RequestLaunchTemplateData
        .builder
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(ramDiskId)(_.ramDiskId(_))
        .ifSome(disableApiTermination)(_.disableApiTermination(_))
        .ifSome(instanceInitiatedShutdownBehavior)(_.instanceInitiatedShutdownBehavior(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(elasticGpuSpecifications)(_.elasticGpuSpecifications(_))
        .ifSome(elasticInferenceAccelerators)(_.elasticInferenceAccelerators(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(instanceMarketOptions)(_.instanceMarketOptions(_))
        .ifSome(creditSpecification)(_.creditSpecification(_))
        .ifSome(cpuOptions)(_.cpuOptions(_))
        .ifSome(capacityReservationSpecification)(_.capacityReservationSpecification(_))
        .ifSome(licenseSpecifications)(_.licenseSpecifications(_))
        .ifSome(hibernationOptions)(_.hibernationOptions(_))
        .ifSome(metadataOptions)(_.metadataOptions(_))
        .ifSome(enclaveOptions)(_.enclaveOptions(_))
        .build

    def requestSpotFleetRequest(
      spotFleetRequestConfig: Option[SpotFleetRequestConfigData] = None
    ): RequestSpotFleetRequest =
      RequestSpotFleetRequest
        .builder
        .ifSome(spotFleetRequestConfig)(_.spotFleetRequestConfig(_))
        .build

    def requestSpotFleetResponse(
      spotFleetRequestId: Option[String] = None
    ): RequestSpotFleetResponse =
      RequestSpotFleetResponse
        .builder
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .build

    def requestSpotInstancesRequest(
      availabilityZoneGroup: Option[String] = None,
      blockDurationMinutes: Option[Int] = None,
      clientToken: Option[String] = None,
      instanceCount: Option[Int] = None,
      launchGroup: Option[String] = None,
      launchSpecification: Option[RequestSpotLaunchSpecification] = None,
      spotPrice: Option[String] = None,
      `type`: Option[String] = None,
      validFrom: Option[DateTime] = None,
      validUntil: Option[DateTime] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      instanceInterruptionBehavior: Option[String] = None
    ): RequestSpotInstancesRequest =
      RequestSpotInstancesRequest
        .builder
        .ifSome(availabilityZoneGroup)(_.availabilityZoneGroup(_))
        .ifSome(blockDurationMinutes)(_.blockDurationMinutes(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(launchGroup)(_.launchGroup(_))
        .ifSome(launchSpecification)(_.launchSpecification(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(validFrom)(_.validFrom(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .build

    def requestSpotLaunchSpecification(
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      securityGroups: Option[List[String]] = None,
      addressingType: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      ebsOptimized: Option[Boolean] = None,
      iamInstanceProfile: Option[IamInstanceProfileSpecification] = None,
      imageId: Option[String] = None,
      instanceType: Option[String] = None,
      kernelId: Option[String] = None,
      keyName: Option[String] = None,
      monitoring: Option[RunInstancesMonitoringEnabled] = None,
      networkInterfaces: Option[List[InstanceNetworkInterfaceSpecification]] = None,
      placement: Option[SpotPlacement] = None,
      ramdiskId: Option[String] = None,
      subnetId: Option[String] = None,
      userData: Option[String] = None
    ): RequestSpotLaunchSpecification =
      RequestSpotLaunchSpecification
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(addressingType)(_.addressingType(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(userData)(_.userData(_))
        .build

    def reservation(
      groups: Option[List[GroupIdentifier]] = None,
      instances: Option[List[Instance]] = None,
      ownerId: Option[String] = None,
      requesterId: Option[String] = None,
      reservationId: Option[String] = None
    ): Reservation =
      Reservation
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(requesterId)(_.requesterId(_))
        .ifSome(reservationId)(_.reservationId(_))
        .build

    def reservationValue(
      hourlyPrice: Option[String] = None,
      remainingTotalValue: Option[String] = None,
      remainingUpfrontValue: Option[String] = None
    ): ReservationValue =
      ReservationValue
        .builder
        .ifSome(hourlyPrice)(_.hourlyPrice(_))
        .ifSome(remainingTotalValue)(_.remainingTotalValue(_))
        .ifSome(remainingUpfrontValue)(_.remainingUpfrontValue(_))
        .build

    def reservedInstanceLimitPrice(
      amount: Option[Double] = None,
      currencyCode: Option[String] = None
    ): ReservedInstanceLimitPrice =
      ReservedInstanceLimitPrice
        .builder
        .ifSome(amount)(_.amount(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .build

    def reservedInstanceReservationValue(
      reservationValue: Option[ReservationValue] = None,
      reservedInstanceId: Option[String] = None
    ): ReservedInstanceReservationValue =
      ReservedInstanceReservationValue
        .builder
        .ifSome(reservationValue)(_.reservationValue(_))
        .ifSome(reservedInstanceId)(_.reservedInstanceId(_))
        .build

    def reservedInstances(
      availabilityZone: Option[String] = None,
      duration: Option[Long] = None,
      end: Option[DateTime] = None,
      fixedPrice: Option[Float] = None,
      instanceCount: Option[Int] = None,
      instanceType: Option[String] = None,
      productDescription: Option[String] = None,
      reservedInstancesId: Option[String] = None,
      start: Option[DateTime] = None,
      state: Option[String] = None,
      usagePrice: Option[Float] = None,
      currencyCode: Option[String] = None,
      instanceTenancy: Option[String] = None,
      offeringClass: Option[String] = None,
      offeringType: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None,
      scope: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ReservedInstances =
      ReservedInstances
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(end)(_.end(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(reservedInstancesId)(_.reservedInstancesId(_))
        .ifSome(start)(_.start(_))
        .ifSome(state)(_.state(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(instanceTenancy)(_.instanceTenancy(_))
        .ifSome(offeringClass)(_.offeringClass(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(tags)(_.tags(_))
        .build

    def reservedInstancesConfiguration(
      availabilityZone: Option[String] = None,
      instanceCount: Option[Int] = None,
      instanceType: Option[String] = None,
      platform: Option[String] = None,
      scope: Option[String] = None
    ): ReservedInstancesConfiguration =
      ReservedInstancesConfiguration
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(scope)(_.scope(_))
        .build

    def reservedInstancesId(
      reservedInstancesId: Option[String] = None
    ): ReservedInstancesId =
      ReservedInstancesId
        .builder
        .ifSome(reservedInstancesId)(_.reservedInstancesId(_))
        .build

    def reservedInstancesListing(
      clientToken: Option[String] = None,
      createDate: Option[DateTime] = None,
      instanceCounts: Option[List[InstanceCount]] = None,
      priceSchedules: Option[List[PriceSchedule]] = None,
      reservedInstancesId: Option[String] = None,
      reservedInstancesListingId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      tags: Option[List[Tag]] = None,
      updateDate: Option[DateTime] = None
    ): ReservedInstancesListing =
      ReservedInstancesListing
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(instanceCounts)(_.instanceCounts(_))
        .ifSome(priceSchedules)(_.priceSchedules(_))
        .ifSome(reservedInstancesId)(_.reservedInstancesId(_))
        .ifSome(reservedInstancesListingId)(_.reservedInstancesListingId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updateDate)(_.updateDate(_))
        .build

    def reservedInstancesModification(
      clientToken: Option[String] = None,
      createDate: Option[DateTime] = None,
      effectiveDate: Option[DateTime] = None,
      modificationResults: Option[List[ReservedInstancesModificationResult]] = None,
      reservedInstancesIds: Option[List[ReservedInstancesId]] = None,
      reservedInstancesModificationId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      updateDate: Option[DateTime] = None
    ): ReservedInstancesModification =
      ReservedInstancesModification
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(effectiveDate)(_.effectiveDate(_))
        .ifSome(modificationResults)(_.modificationResults(_))
        .ifSome(reservedInstancesIds)(_.reservedInstancesIds(_))
        .ifSome(reservedInstancesModificationId)(_.reservedInstancesModificationId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(updateDate)(_.updateDate(_))
        .build

    def reservedInstancesOffering(
      availabilityZone: Option[String] = None,
      duration: Option[Long] = None,
      fixedPrice: Option[Float] = None,
      instanceType: Option[String] = None,
      productDescription: Option[String] = None,
      reservedInstancesOfferingId: Option[String] = None,
      usagePrice: Option[Float] = None,
      currencyCode: Option[String] = None,
      instanceTenancy: Option[String] = None,
      marketplace: Option[Boolean] = None,
      offeringClass: Option[String] = None,
      offeringType: Option[String] = None,
      pricingDetails: Option[List[PricingDetail]] = None,
      recurringCharges: Option[List[RecurringCharge]] = None,
      scope: Option[String] = None
    ): ReservedInstancesOffering =
      ReservedInstancesOffering
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(reservedInstancesOfferingId)(_.reservedInstancesOfferingId(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(instanceTenancy)(_.instanceTenancy(_))
        .ifSome(marketplace)(_.marketplace(_))
        .ifSome(offeringClass)(_.offeringClass(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(pricingDetails)(_.pricingDetails(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .ifSome(scope)(_.scope(_))
        .build

    def resetAddressAttributeRequest(
      allocationId: Option[String] = None,
      attribute: Option[String] = None
    ): ResetAddressAttributeRequest =
      ResetAddressAttributeRequest
        .builder
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(attribute)(_.attribute(_))
        .build

    def resetEbsDefaultKmsKeyIdRequest(

    ): ResetEbsDefaultKmsKeyIdRequest =
      ResetEbsDefaultKmsKeyIdRequest
        .builder

        .build

    def resetFpgaImageAttributeRequest(
      fpgaImageId: Option[String] = None,
      attribute: Option[String] = None
    ): ResetFpgaImageAttributeRequest =
      ResetFpgaImageAttributeRequest
        .builder
        .ifSome(fpgaImageId)(_.fpgaImageId(_))
        .ifSome(attribute)(_.attribute(_))
        .build

    def resetImageAttributeRequest(
      attribute: Option[String] = None,
      imageId: Option[String] = None
    ): ResetImageAttributeRequest =
      ResetImageAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(imageId)(_.imageId(_))
        .build

    def resetInstanceAttributeRequest(
      attribute: Option[String] = None,
      instanceId: Option[String] = None
    ): ResetInstanceAttributeRequest =
      ResetInstanceAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def resetNetworkInterfaceAttributeRequest(
      networkInterfaceId: Option[String] = None,
      sourceDestCheck: Option[String] = None
    ): ResetNetworkInterfaceAttributeRequest =
      ResetNetworkInterfaceAttributeRequest
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .build

    def resetSnapshotAttributeRequest(
      attribute: Option[String] = None,
      snapshotId: Option[String] = None
    ): ResetSnapshotAttributeRequest =
      ResetSnapshotAttributeRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .build

    def responseError(
      code: Option[String] = None,
      message: Option[String] = None
    ): ResponseError =
      ResponseError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def responseLaunchTemplateData(
      kernelId: Option[String] = None,
      ebsOptimized: Option[Boolean] = None,
      iamInstanceProfile: Option[LaunchTemplateIamInstanceProfileSpecification] = None,
      blockDeviceMappings: Option[List[LaunchTemplateBlockDeviceMapping]] = None,
      networkInterfaces: Option[List[LaunchTemplateInstanceNetworkInterfaceSpecification]] = None,
      imageId: Option[String] = None,
      instanceType: Option[String] = None,
      keyName: Option[String] = None,
      monitoring: Option[LaunchTemplatesMonitoring] = None,
      placement: Option[LaunchTemplatePlacement] = None,
      ramDiskId: Option[String] = None,
      disableApiTermination: Option[Boolean] = None,
      instanceInitiatedShutdownBehavior: Option[String] = None,
      userData: Option[String] = None,
      tagSpecifications: Option[List[LaunchTemplateTagSpecification]] = None,
      elasticGpuSpecifications: Option[List[ElasticGpuSpecificationResponse]] = None,
      elasticInferenceAccelerators: Option[List[LaunchTemplateElasticInferenceAcceleratorResponse]] = None,
      securityGroupIds: Option[List[String]] = None,
      securityGroups: Option[List[String]] = None,
      instanceMarketOptions: Option[LaunchTemplateInstanceMarketOptions] = None,
      creditSpecification: Option[CreditSpecification] = None,
      cpuOptions: Option[LaunchTemplateCpuOptions] = None,
      capacityReservationSpecification: Option[LaunchTemplateCapacityReservationSpecificationResponse] = None,
      licenseSpecifications: Option[List[LaunchTemplateLicenseConfiguration]] = None,
      hibernationOptions: Option[LaunchTemplateHibernationOptions] = None,
      metadataOptions: Option[LaunchTemplateInstanceMetadataOptions] = None,
      enclaveOptions: Option[LaunchTemplateEnclaveOptions] = None
    ): ResponseLaunchTemplateData =
      ResponseLaunchTemplateData
        .builder
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(ramDiskId)(_.ramDiskId(_))
        .ifSome(disableApiTermination)(_.disableApiTermination(_))
        .ifSome(instanceInitiatedShutdownBehavior)(_.instanceInitiatedShutdownBehavior(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(elasticGpuSpecifications)(_.elasticGpuSpecifications(_))
        .ifSome(elasticInferenceAccelerators)(_.elasticInferenceAccelerators(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(instanceMarketOptions)(_.instanceMarketOptions(_))
        .ifSome(creditSpecification)(_.creditSpecification(_))
        .ifSome(cpuOptions)(_.cpuOptions(_))
        .ifSome(capacityReservationSpecification)(_.capacityReservationSpecification(_))
        .ifSome(licenseSpecifications)(_.licenseSpecifications(_))
        .ifSome(hibernationOptions)(_.hibernationOptions(_))
        .ifSome(metadataOptions)(_.metadataOptions(_))
        .ifSome(enclaveOptions)(_.enclaveOptions(_))
        .build

    def restoreAddressToClassicRequest(
      publicIp: Option[String] = None
    ): RestoreAddressToClassicRequest =
      RestoreAddressToClassicRequest
        .builder
        .ifSome(publicIp)(_.publicIp(_))
        .build

    def restoreManagedPrefixListVersionRequest(
      prefixListId: Option[String] = None,
      previousVersion: Option[Long] = None,
      currentVersion: Option[Long] = None
    ): RestoreManagedPrefixListVersionRequest =
      RestoreManagedPrefixListVersionRequest
        .builder
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(previousVersion)(_.previousVersion(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .build

    def revokeClientVpnIngressRequest(
      clientVpnEndpointId: Option[String] = None,
      targetNetworkCidr: Option[String] = None,
      accessGroupId: Option[String] = None,
      revokeAllGroups: Option[Boolean] = None
    ): RevokeClientVpnIngressRequest =
      RevokeClientVpnIngressRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(targetNetworkCidr)(_.targetNetworkCidr(_))
        .ifSome(accessGroupId)(_.accessGroupId(_))
        .ifSome(revokeAllGroups)(_.revokeAllGroups(_))
        .build

    def revokeSecurityGroupEgressRequest(
      groupId: Option[String] = None,
      ipPermissions: Option[List[IpPermission]] = None,
      cidrIp: Option[String] = None,
      fromPort: Option[Int] = None,
      ipProtocol: Option[String] = None,
      toPort: Option[Int] = None,
      sourceSecurityGroupName: Option[String] = None,
      sourceSecurityGroupOwnerId: Option[String] = None
    ): RevokeSecurityGroupEgressRequest =
      RevokeSecurityGroupEgressRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .ifSome(cidrIp)(_.cidrIp(_))
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(ipProtocol)(_.ipProtocol(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(sourceSecurityGroupName)(_.sourceSecurityGroupName(_))
        .ifSome(sourceSecurityGroupOwnerId)(_.sourceSecurityGroupOwnerId(_))
        .build

    def revokeSecurityGroupIngressRequest(
      cidrIp: Option[String] = None,
      fromPort: Option[Int] = None,
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      ipPermissions: Option[List[IpPermission]] = None,
      ipProtocol: Option[String] = None,
      sourceSecurityGroupName: Option[String] = None,
      sourceSecurityGroupOwnerId: Option[String] = None,
      toPort: Option[Int] = None
    ): RevokeSecurityGroupIngressRequest =
      RevokeSecurityGroupIngressRequest
        .builder
        .ifSome(cidrIp)(_.cidrIp(_))
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .ifSome(ipProtocol)(_.ipProtocol(_))
        .ifSome(sourceSecurityGroupName)(_.sourceSecurityGroupName(_))
        .ifSome(sourceSecurityGroupOwnerId)(_.sourceSecurityGroupOwnerId(_))
        .ifSome(toPort)(_.toPort(_))
        .build

    def route(
      destinationCidrBlock: Option[String] = None,
      destinationIpv6CidrBlock: Option[String] = None,
      destinationPrefixListId: Option[String] = None,
      egressOnlyInternetGatewayId: Option[String] = None,
      gatewayId: Option[String] = None,
      instanceId: Option[String] = None,
      instanceOwnerId: Option[String] = None,
      natGatewayId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      localGatewayId: Option[String] = None,
      carrierGatewayId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      origin: Option[String] = None,
      state: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): Route =
      Route
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(destinationIpv6CidrBlock)(_.destinationIpv6CidrBlock(_))
        .ifSome(destinationPrefixListId)(_.destinationPrefixListId(_))
        .ifSome(egressOnlyInternetGatewayId)(_.egressOnlyInternetGatewayId(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceOwnerId)(_.instanceOwnerId(_))
        .ifSome(natGatewayId)(_.natGatewayId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(localGatewayId)(_.localGatewayId(_))
        .ifSome(carrierGatewayId)(_.carrierGatewayId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(state)(_.state(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def routeTable(
      associations: Option[List[RouteTableAssociation]] = None,
      propagatingVgws: Option[List[PropagatingVgw]] = None,
      routeTableId: Option[String] = None,
      routes: Option[List[Route]] = None,
      tags: Option[List[Tag]] = None,
      vpcId: Option[String] = None,
      ownerId: Option[String] = None
    ): RouteTable =
      RouteTable
        .builder
        .ifSome(associations)(_.associations(_))
        .ifSome(propagatingVgws)(_.propagatingVgws(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .ifSome(routes)(_.routes(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .build

    def routeTableAssociation(
      main: Option[Boolean] = None,
      routeTableAssociationId: Option[String] = None,
      routeTableId: Option[String] = None,
      subnetId: Option[String] = None,
      gatewayId: Option[String] = None,
      associationState: Option[RouteTableAssociationState] = None
    ): RouteTableAssociation =
      RouteTableAssociation
        .builder
        .ifSome(main)(_.main(_))
        .ifSome(routeTableAssociationId)(_.routeTableAssociationId(_))
        .ifSome(routeTableId)(_.routeTableId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(associationState)(_.associationState(_))
        .build

    def routeTableAssociationState(
      state: Option[String] = None,
      statusMessage: Option[String] = None
    ): RouteTableAssociationState =
      RouteTableAssociationState
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def runInstancesMonitoringEnabled(
      enabled: Option[Boolean] = None
    ): RunInstancesMonitoringEnabled =
      RunInstancesMonitoringEnabled
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def runInstancesRequest(
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      imageId: Option[String] = None,
      instanceType: Option[String] = None,
      ipv6AddressCount: Option[Int] = None,
      ipv6Addresses: Option[List[InstanceIpv6Address]] = None,
      kernelId: Option[String] = None,
      keyName: Option[String] = None,
      maxCount: Option[Int] = None,
      minCount: Option[Int] = None,
      monitoring: Option[RunInstancesMonitoringEnabled] = None,
      placement: Option[Placement] = None,
      ramdiskId: Option[String] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      securityGroups: Option[List[SecurityGroupName]] = None,
      subnetId: Option[String] = None,
      userData: Option[String] = None,
      additionalInfo: Option[String] = None,
      clientToken: Option[String] = None,
      disableApiTermination: Option[Boolean] = None,
      ebsOptimized: Option[Boolean] = None,
      iamInstanceProfile: Option[IamInstanceProfileSpecification] = None,
      instanceInitiatedShutdownBehavior: Option[String] = None,
      networkInterfaces: Option[List[InstanceNetworkInterfaceSpecification]] = None,
      privateIpAddress: Option[String] = None,
      elasticGpuSpecification: Option[List[ElasticGpuSpecification]] = None,
      elasticInferenceAccelerators: Option[List[ElasticInferenceAccelerator]] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      instanceMarketOptions: Option[InstanceMarketOptionsRequest] = None,
      creditSpecification: Option[CreditSpecificationRequest] = None,
      cpuOptions: Option[CpuOptionsRequest] = None,
      capacityReservationSpecification: Option[CapacityReservationSpecification] = None,
      hibernationOptions: Option[HibernationOptionsRequest] = None,
      licenseSpecifications: Option[List[LicenseConfigurationRequest]] = None,
      metadataOptions: Option[InstanceMetadataOptionsRequest] = None,
      enclaveOptions: Option[EnclaveOptionsRequest] = None
    ): RunInstancesRequest =
      RunInstancesRequest
        .builder
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(ipv6AddressCount)(_.ipv6AddressCount(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(maxCount)(_.maxCount(_))
        .ifSome(minCount)(_.minCount(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(disableApiTermination)(_.disableApiTermination(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(instanceInitiatedShutdownBehavior)(_.instanceInitiatedShutdownBehavior(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(elasticGpuSpecification)(_.elasticGpuSpecification(_))
        .ifSome(elasticInferenceAccelerators)(_.elasticInferenceAccelerators(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(instanceMarketOptions)(_.instanceMarketOptions(_))
        .ifSome(creditSpecification)(_.creditSpecification(_))
        .ifSome(cpuOptions)(_.cpuOptions(_))
        .ifSome(capacityReservationSpecification)(_.capacityReservationSpecification(_))
        .ifSome(hibernationOptions)(_.hibernationOptions(_))
        .ifSome(licenseSpecifications)(_.licenseSpecifications(_))
        .ifSome(metadataOptions)(_.metadataOptions(_))
        .ifSome(enclaveOptions)(_.enclaveOptions(_))
        .build

    def runScheduledInstancesRequest(
      clientToken: Option[String] = None,
      instanceCount: Option[Int] = None,
      launchSpecification: Option[ScheduledInstancesLaunchSpecification] = None,
      scheduledInstanceId: Option[String] = None
    ): RunScheduledInstancesRequest =
      RunScheduledInstancesRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(launchSpecification)(_.launchSpecification(_))
        .ifSome(scheduledInstanceId)(_.scheduledInstanceId(_))
        .build

    def s3ObjectTag(
      key: Option[String] = None,
      value: Option[String] = None
    ): S3ObjectTag =
      S3ObjectTag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def s3Storage(
      aWSAccessKeyId: Option[String] = None,
      bucket: Option[String] = None,
      prefix: Option[String] = None,
      uploadPolicy: Option[Blob] = None,
      uploadPolicySignature: Option[String] = None
    ): S3Storage =
      S3Storage
        .builder
        .ifSome(aWSAccessKeyId)(_.aWSAccessKeyId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(uploadPolicy)(_.uploadPolicy(_))
        .ifSome(uploadPolicySignature)(_.uploadPolicySignature(_))
        .build

    def scheduledInstance(
      availabilityZone: Option[String] = None,
      createDate: Option[DateTime] = None,
      hourlyPrice: Option[String] = None,
      instanceCount: Option[Int] = None,
      instanceType: Option[String] = None,
      networkPlatform: Option[String] = None,
      nextSlotStartTime: Option[DateTime] = None,
      platform: Option[String] = None,
      previousSlotEndTime: Option[DateTime] = None,
      recurrence: Option[ScheduledInstanceRecurrence] = None,
      scheduledInstanceId: Option[String] = None,
      slotDurationInHours: Option[Int] = None,
      termEndDate: Option[DateTime] = None,
      termStartDate: Option[DateTime] = None,
      totalScheduledInstanceHours: Option[Int] = None
    ): ScheduledInstance =
      ScheduledInstance
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(hourlyPrice)(_.hourlyPrice(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(networkPlatform)(_.networkPlatform(_))
        .ifSome(nextSlotStartTime)(_.nextSlotStartTime(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(previousSlotEndTime)(_.previousSlotEndTime(_))
        .ifSome(recurrence)(_.recurrence(_))
        .ifSome(scheduledInstanceId)(_.scheduledInstanceId(_))
        .ifSome(slotDurationInHours)(_.slotDurationInHours(_))
        .ifSome(termEndDate)(_.termEndDate(_))
        .ifSome(termStartDate)(_.termStartDate(_))
        .ifSome(totalScheduledInstanceHours)(_.totalScheduledInstanceHours(_))
        .build

    def scheduledInstanceAvailability(
      availabilityZone: Option[String] = None,
      availableInstanceCount: Option[Int] = None,
      firstSlotStartTime: Option[DateTime] = None,
      hourlyPrice: Option[String] = None,
      instanceType: Option[String] = None,
      maxTermDurationInDays: Option[Int] = None,
      minTermDurationInDays: Option[Int] = None,
      networkPlatform: Option[String] = None,
      platform: Option[String] = None,
      purchaseToken: Option[String] = None,
      recurrence: Option[ScheduledInstanceRecurrence] = None,
      slotDurationInHours: Option[Int] = None,
      totalScheduledInstanceHours: Option[Int] = None
    ): ScheduledInstanceAvailability =
      ScheduledInstanceAvailability
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availableInstanceCount)(_.availableInstanceCount(_))
        .ifSome(firstSlotStartTime)(_.firstSlotStartTime(_))
        .ifSome(hourlyPrice)(_.hourlyPrice(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(maxTermDurationInDays)(_.maxTermDurationInDays(_))
        .ifSome(minTermDurationInDays)(_.minTermDurationInDays(_))
        .ifSome(networkPlatform)(_.networkPlatform(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(purchaseToken)(_.purchaseToken(_))
        .ifSome(recurrence)(_.recurrence(_))
        .ifSome(slotDurationInHours)(_.slotDurationInHours(_))
        .ifSome(totalScheduledInstanceHours)(_.totalScheduledInstanceHours(_))
        .build

    def scheduledInstanceRecurrence(
      frequency: Option[String] = None,
      interval: Option[Int] = None,
      occurrenceDaySet: Option[List[Integer]] = None,
      occurrenceRelativeToEnd: Option[Boolean] = None,
      occurrenceUnit: Option[String] = None
    ): ScheduledInstanceRecurrence =
      ScheduledInstanceRecurrence
        .builder
        .ifSome(frequency)(_.frequency(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(occurrenceDaySet)(_.occurrenceDaySet(_))
        .ifSome(occurrenceRelativeToEnd)(_.occurrenceRelativeToEnd(_))
        .ifSome(occurrenceUnit)(_.occurrenceUnit(_))
        .build

    def scheduledInstanceRecurrenceRequest(
      frequency: Option[String] = None,
      interval: Option[Int] = None,
      occurrenceDays: Option[List[Integer]] = None,
      occurrenceRelativeToEnd: Option[Boolean] = None,
      occurrenceUnit: Option[String] = None
    ): ScheduledInstanceRecurrenceRequest =
      ScheduledInstanceRecurrenceRequest
        .builder
        .ifSome(frequency)(_.frequency(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(occurrenceDays)(_.occurrenceDays(_))
        .ifSome(occurrenceRelativeToEnd)(_.occurrenceRelativeToEnd(_))
        .ifSome(occurrenceUnit)(_.occurrenceUnit(_))
        .build

    def scheduledInstancesBlockDeviceMapping(
      deviceName: Option[String] = None,
      ebs: Option[ScheduledInstancesEbs] = None,
      noDevice: Option[String] = None,
      virtualName: Option[String] = None
    ): ScheduledInstancesBlockDeviceMapping =
      ScheduledInstancesBlockDeviceMapping
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(ebs)(_.ebs(_))
        .ifSome(noDevice)(_.noDevice(_))
        .ifSome(virtualName)(_.virtualName(_))
        .build

    def scheduledInstancesEbs(
      deleteOnTermination: Option[Boolean] = None,
      encrypted: Option[Boolean] = None,
      iops: Option[Int] = None,
      snapshotId: Option[String] = None,
      volumeSize: Option[Int] = None,
      volumeType: Option[String] = None
    ): ScheduledInstancesEbs =
      ScheduledInstancesEbs
        .builder
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeType)(_.volumeType(_))
        .build

    def scheduledInstancesIamInstanceProfile(
      arn: Option[String] = None,
      name: Option[String] = None
    ): ScheduledInstancesIamInstanceProfile =
      ScheduledInstancesIamInstanceProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def scheduledInstancesIpv6Address(
      ipv6Address: Option[String] = None
    ): ScheduledInstancesIpv6Address =
      ScheduledInstancesIpv6Address
        .builder
        .ifSome(ipv6Address)(_.ipv6Address(_))
        .build

    def scheduledInstancesLaunchSpecification(
      blockDeviceMappings: Option[List[ScheduledInstancesBlockDeviceMapping]] = None,
      ebsOptimized: Option[Boolean] = None,
      iamInstanceProfile: Option[ScheduledInstancesIamInstanceProfile] = None,
      imageId: Option[String] = None,
      instanceType: Option[String] = None,
      kernelId: Option[String] = None,
      keyName: Option[String] = None,
      monitoring: Option[ScheduledInstancesMonitoring] = None,
      networkInterfaces: Option[List[ScheduledInstancesNetworkInterface]] = None,
      placement: Option[ScheduledInstancesPlacement] = None,
      ramdiskId: Option[String] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      subnetId: Option[String] = None,
      userData: Option[String] = None
    ): ScheduledInstancesLaunchSpecification =
      ScheduledInstancesLaunchSpecification
        .builder
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(userData)(_.userData(_))
        .build

    def scheduledInstancesMonitoring(
      enabled: Option[Boolean] = None
    ): ScheduledInstancesMonitoring =
      ScheduledInstancesMonitoring
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def scheduledInstancesNetworkInterface(
      associatePublicIpAddress: Option[Boolean] = None,
      deleteOnTermination: Option[Boolean] = None,
      description: Option[String] = None,
      deviceIndex: Option[Int] = None,
      groups: Option[List[SecurityGroupId]] = None,
      ipv6AddressCount: Option[Int] = None,
      ipv6Addresses: Option[List[ScheduledInstancesIpv6Address]] = None,
      networkInterfaceId: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddressConfigs: Option[List[ScheduledInstancesPrivateIpAddressConfig]] = None,
      secondaryPrivateIpAddressCount: Option[Int] = None,
      subnetId: Option[String] = None
    ): ScheduledInstancesNetworkInterface =
      ScheduledInstancesNetworkInterface
        .builder
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(description)(_.description(_))
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(ipv6AddressCount)(_.ipv6AddressCount(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddressConfigs)(_.privateIpAddressConfigs(_))
        .ifSome(secondaryPrivateIpAddressCount)(_.secondaryPrivateIpAddressCount(_))
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def scheduledInstancesPlacement(
      availabilityZone: Option[String] = None,
      groupName: Option[String] = None
    ): ScheduledInstancesPlacement =
      ScheduledInstancesPlacement
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def scheduledInstancesPrivateIpAddressConfig(
      primary: Option[Boolean] = None,
      privateIpAddress: Option[String] = None
    ): ScheduledInstancesPrivateIpAddressConfig =
      ScheduledInstancesPrivateIpAddressConfig
        .builder
        .ifSome(primary)(_.primary(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def searchLocalGatewayRoutesRequest(
      localGatewayRouteTableId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): SearchLocalGatewayRoutesRequest =
      SearchLocalGatewayRoutesRequest
        .builder
        .ifSome(localGatewayRouteTableId)(_.localGatewayRouteTableId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchTransitGatewayMulticastGroupsRequest(
      transitGatewayMulticastDomainId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): SearchTransitGatewayMulticastGroupsRequest =
      SearchTransitGatewayMulticastGroupsRequest
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchTransitGatewayRoutesRequest(
      transitGatewayRouteTableId: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None
    ): SearchTransitGatewayRoutesRequest =
      SearchTransitGatewayRoutesRequest
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def securityGroup(
      description: Option[String] = None,
      groupName: Option[String] = None,
      ipPermissions: Option[List[IpPermission]] = None,
      ownerId: Option[String] = None,
      groupId: Option[String] = None,
      ipPermissionsEgress: Option[List[IpPermission]] = None,
      tags: Option[List[Tag]] = None,
      vpcId: Option[String] = None
    ): SecurityGroup =
      SecurityGroup
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(ipPermissionsEgress)(_.ipPermissionsEgress(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def securityGroupIdentifier(
      groupId: Option[String] = None,
      groupName: Option[String] = None
    ): SecurityGroupIdentifier =
      SecurityGroupIdentifier
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def securityGroupReference(
      groupId: Option[String] = None,
      referencingVpcId: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): SecurityGroupReference =
      SecurityGroupReference
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(referencingVpcId)(_.referencingVpcId(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def sendDiagnosticInterruptRequest(
      instanceId: Option[String] = None
    ): SendDiagnosticInterruptRequest =
      SendDiagnosticInterruptRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def serviceConfiguration(
      serviceType: Option[List[ServiceTypeDetail]] = None,
      serviceId: Option[String] = None,
      serviceName: Option[String] = None,
      serviceState: Option[String] = None,
      availabilityZones: Option[List[String]] = None,
      acceptanceRequired: Option[Boolean] = None,
      managesVpcEndpoints: Option[Boolean] = None,
      networkLoadBalancerArns: Option[List[String]] = None,
      gatewayLoadBalancerArns: Option[List[String]] = None,
      baseEndpointDnsNames: Option[List[String]] = None,
      privateDnsName: Option[String] = None,
      privateDnsNameConfiguration: Option[PrivateDnsNameConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): ServiceConfiguration =
      ServiceConfiguration
        .builder
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceState)(_.serviceState(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(acceptanceRequired)(_.acceptanceRequired(_))
        .ifSome(managesVpcEndpoints)(_.managesVpcEndpoints(_))
        .ifSome(networkLoadBalancerArns)(_.networkLoadBalancerArns(_))
        .ifSome(gatewayLoadBalancerArns)(_.gatewayLoadBalancerArns(_))
        .ifSome(baseEndpointDnsNames)(_.baseEndpointDnsNames(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateDnsNameConfiguration)(_.privateDnsNameConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def serviceDetail(
      serviceName: Option[String] = None,
      serviceId: Option[String] = None,
      serviceType: Option[List[ServiceTypeDetail]] = None,
      availabilityZones: Option[List[String]] = None,
      owner: Option[String] = None,
      baseEndpointDnsNames: Option[List[String]] = None,
      privateDnsName: Option[String] = None,
      privateDnsNames: Option[List[PrivateDnsDetails]] = None,
      vpcEndpointPolicySupported: Option[Boolean] = None,
      acceptanceRequired: Option[Boolean] = None,
      managesVpcEndpoints: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      privateDnsNameVerificationState: Option[String] = None
    ): ServiceDetail =
      ServiceDetail
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(baseEndpointDnsNames)(_.baseEndpointDnsNames(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateDnsNames)(_.privateDnsNames(_))
        .ifSome(vpcEndpointPolicySupported)(_.vpcEndpointPolicySupported(_))
        .ifSome(acceptanceRequired)(_.acceptanceRequired(_))
        .ifSome(managesVpcEndpoints)(_.managesVpcEndpoints(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(privateDnsNameVerificationState)(_.privateDnsNameVerificationState(_))
        .build

    def serviceTypeDetail(
      serviceType: Option[String] = None
    ): ServiceTypeDetail =
      ServiceTypeDetail
        .builder
        .ifSome(serviceType)(_.serviceType(_))
        .build

    def slotDateTimeRangeRequest(
      earliestTime: Option[DateTime] = None,
      latestTime: Option[DateTime] = None
    ): SlotDateTimeRangeRequest =
      SlotDateTimeRangeRequest
        .builder
        .ifSome(earliestTime)(_.earliestTime(_))
        .ifSome(latestTime)(_.latestTime(_))
        .build

    def slotStartTimeRangeRequest(
      earliestTime: Option[DateTime] = None,
      latestTime: Option[DateTime] = None
    ): SlotStartTimeRangeRequest =
      SlotStartTimeRangeRequest
        .builder
        .ifSome(earliestTime)(_.earliestTime(_))
        .ifSome(latestTime)(_.latestTime(_))
        .build

    def snapshot(
      dataEncryptionKeyId: Option[String] = None,
      description: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      ownerId: Option[String] = None,
      progress: Option[String] = None,
      snapshotId: Option[String] = None,
      startTime: Option[DateTime] = None,
      state: Option[String] = None,
      stateMessage: Option[String] = None,
      volumeId: Option[String] = None,
      volumeSize: Option[Int] = None,
      ownerAlias: Option[String] = None,
      outpostArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): Snapshot =
      Snapshot
        .builder
        .ifSome(dataEncryptionKeyId)(_.dataEncryptionKeyId(_))
        .ifSome(description)(_.description(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateMessage)(_.stateMessage(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(ownerAlias)(_.ownerAlias(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def snapshotDetail(
      description: Option[String] = None,
      deviceName: Option[String] = None,
      diskImageSize: Option[Double] = None,
      format: Option[String] = None,
      progress: Option[String] = None,
      snapshotId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      url: Option[String] = None,
      userBucket: Option[UserBucketDetails] = None
    ): SnapshotDetail =
      SnapshotDetail
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(diskImageSize)(_.diskImageSize(_))
        .ifSome(format)(_.format(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(url)(_.url(_))
        .ifSome(userBucket)(_.userBucket(_))
        .build

    def snapshotDiskContainer(
      description: Option[String] = None,
      format: Option[String] = None,
      url: Option[String] = None,
      userBucket: Option[UserBucket] = None
    ): SnapshotDiskContainer =
      SnapshotDiskContainer
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(format)(_.format(_))
        .ifSome(url)(_.url(_))
        .ifSome(userBucket)(_.userBucket(_))
        .build

    def snapshotInfo(
      description: Option[String] = None,
      tags: Option[List[Tag]] = None,
      encrypted: Option[Boolean] = None,
      volumeId: Option[String] = None,
      state: Option[String] = None,
      volumeSize: Option[Int] = None,
      startTime: Option[MillisecondDateTime] = None,
      progress: Option[String] = None,
      ownerId: Option[String] = None,
      snapshotId: Option[String] = None,
      outpostArn: Option[String] = None
    ): SnapshotInfo =
      SnapshotInfo
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(state)(_.state(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .build

    def snapshotTaskDetail(
      description: Option[String] = None,
      diskImageSize: Option[Double] = None,
      encrypted: Option[Boolean] = None,
      format: Option[String] = None,
      kmsKeyId: Option[String] = None,
      progress: Option[String] = None,
      snapshotId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      url: Option[String] = None,
      userBucket: Option[UserBucketDetails] = None
    ): SnapshotTaskDetail =
      SnapshotTaskDetail
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(diskImageSize)(_.diskImageSize(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(format)(_.format(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(url)(_.url(_))
        .ifSome(userBucket)(_.userBucket(_))
        .build

    def spotCapacityRebalance(
      replacementStrategy: Option[String] = None
    ): SpotCapacityRebalance =
      SpotCapacityRebalance
        .builder
        .ifSome(replacementStrategy)(_.replacementStrategy(_))
        .build

    def spotDatafeedSubscription(
      bucket: Option[String] = None,
      fault: Option[SpotInstanceStateFault] = None,
      ownerId: Option[String] = None,
      prefix: Option[String] = None,
      state: Option[String] = None
    ): SpotDatafeedSubscription =
      SpotDatafeedSubscription
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(fault)(_.fault(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(state)(_.state(_))
        .build

    def spotFleetLaunchSpecification(
      securityGroups: Option[List[GroupIdentifier]] = None,
      addressingType: Option[String] = None,
      blockDeviceMappings: Option[List[BlockDeviceMapping]] = None,
      ebsOptimized: Option[Boolean] = None,
      iamInstanceProfile: Option[IamInstanceProfileSpecification] = None,
      imageId: Option[String] = None,
      instanceType: Option[String] = None,
      kernelId: Option[String] = None,
      keyName: Option[String] = None,
      monitoring: Option[SpotFleetMonitoring] = None,
      networkInterfaces: Option[List[InstanceNetworkInterfaceSpecification]] = None,
      placement: Option[SpotPlacement] = None,
      ramdiskId: Option[String] = None,
      spotPrice: Option[String] = None,
      subnetId: Option[String] = None,
      userData: Option[String] = None,
      weightedCapacity: Option[Double] = None,
      tagSpecifications: Option[List[SpotFleetTagSpecification]] = None
    ): SpotFleetLaunchSpecification =
      SpotFleetLaunchSpecification
        .builder
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(addressingType)(_.addressingType(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(ebsOptimized)(_.ebsOptimized(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(kernelId)(_.kernelId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(monitoring)(_.monitoring(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(placement)(_.placement(_))
        .ifSome(ramdiskId)(_.ramdiskId(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def spotFleetMonitoring(
      enabled: Option[Boolean] = None
    ): SpotFleetMonitoring =
      SpotFleetMonitoring
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def spotFleetRequestConfig(
      activityStatus: Option[String] = None,
      createTime: Option[MillisecondDateTime] = None,
      spotFleetRequestConfig: Option[SpotFleetRequestConfigData] = None,
      spotFleetRequestId: Option[String] = None,
      spotFleetRequestState: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): SpotFleetRequestConfig =
      SpotFleetRequestConfig
        .builder
        .ifSome(activityStatus)(_.activityStatus(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(spotFleetRequestConfig)(_.spotFleetRequestConfig(_))
        .ifSome(spotFleetRequestId)(_.spotFleetRequestId(_))
        .ifSome(spotFleetRequestState)(_.spotFleetRequestState(_))
        .ifSome(tags)(_.tags(_))
        .build

    def spotFleetRequestConfigData(
      allocationStrategy: Option[String] = None,
      onDemandAllocationStrategy: Option[String] = None,
      spotMaintenanceStrategies: Option[SpotMaintenanceStrategies] = None,
      clientToken: Option[String] = None,
      excessCapacityTerminationPolicy: Option[String] = None,
      fulfilledCapacity: Option[Double] = None,
      onDemandFulfilledCapacity: Option[Double] = None,
      iamFleetRole: Option[String] = None,
      launchSpecifications: Option[List[SpotFleetLaunchSpecification]] = None,
      launchTemplateConfigs: Option[List[LaunchTemplateConfig]] = None,
      spotPrice: Option[String] = None,
      targetCapacity: Option[Int] = None,
      onDemandTargetCapacity: Option[Int] = None,
      onDemandMaxTotalPrice: Option[String] = None,
      spotMaxTotalPrice: Option[String] = None,
      terminateInstancesWithExpiration: Option[Boolean] = None,
      `type`: Option[String] = None,
      validFrom: Option[DateTime] = None,
      validUntil: Option[DateTime] = None,
      replaceUnhealthyInstances: Option[Boolean] = None,
      instanceInterruptionBehavior: Option[String] = None,
      loadBalancersConfig: Option[LoadBalancersConfig] = None,
      instancePoolsToUseCount: Option[Int] = None,
      tagSpecifications: Option[List[TagSpecification]] = None
    ): SpotFleetRequestConfigData =
      SpotFleetRequestConfigData
        .builder
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .ifSome(onDemandAllocationStrategy)(_.onDemandAllocationStrategy(_))
        .ifSome(spotMaintenanceStrategies)(_.spotMaintenanceStrategies(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(excessCapacityTerminationPolicy)(_.excessCapacityTerminationPolicy(_))
        .ifSome(fulfilledCapacity)(_.fulfilledCapacity(_))
        .ifSome(onDemandFulfilledCapacity)(_.onDemandFulfilledCapacity(_))
        .ifSome(iamFleetRole)(_.iamFleetRole(_))
        .ifSome(launchSpecifications)(_.launchSpecifications(_))
        .ifSome(launchTemplateConfigs)(_.launchTemplateConfigs(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(targetCapacity)(_.targetCapacity(_))
        .ifSome(onDemandTargetCapacity)(_.onDemandTargetCapacity(_))
        .ifSome(onDemandMaxTotalPrice)(_.onDemandMaxTotalPrice(_))
        .ifSome(spotMaxTotalPrice)(_.spotMaxTotalPrice(_))
        .ifSome(terminateInstancesWithExpiration)(_.terminateInstancesWithExpiration(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(validFrom)(_.validFrom(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(replaceUnhealthyInstances)(_.replaceUnhealthyInstances(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .ifSome(loadBalancersConfig)(_.loadBalancersConfig(_))
        .ifSome(instancePoolsToUseCount)(_.instancePoolsToUseCount(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .build

    def spotFleetTagSpecification(
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): SpotFleetTagSpecification =
      SpotFleetTagSpecification
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def spotInstanceRequest(
      actualBlockHourlyPrice: Option[String] = None,
      availabilityZoneGroup: Option[String] = None,
      blockDurationMinutes: Option[Int] = None,
      createTime: Option[DateTime] = None,
      fault: Option[SpotInstanceStateFault] = None,
      instanceId: Option[String] = None,
      launchGroup: Option[String] = None,
      launchSpecification: Option[LaunchSpecification] = None,
      launchedAvailabilityZone: Option[String] = None,
      productDescription: Option[String] = None,
      spotInstanceRequestId: Option[String] = None,
      spotPrice: Option[String] = None,
      state: Option[String] = None,
      status: Option[SpotInstanceStatus] = None,
      tags: Option[List[Tag]] = None,
      `type`: Option[String] = None,
      validFrom: Option[DateTime] = None,
      validUntil: Option[DateTime] = None,
      instanceInterruptionBehavior: Option[String] = None
    ): SpotInstanceRequest =
      SpotInstanceRequest
        .builder
        .ifSome(actualBlockHourlyPrice)(_.actualBlockHourlyPrice(_))
        .ifSome(availabilityZoneGroup)(_.availabilityZoneGroup(_))
        .ifSome(blockDurationMinutes)(_.blockDurationMinutes(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(fault)(_.fault(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(launchGroup)(_.launchGroup(_))
        .ifSome(launchSpecification)(_.launchSpecification(_))
        .ifSome(launchedAvailabilityZone)(_.launchedAvailabilityZone(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(spotInstanceRequestId)(_.spotInstanceRequestId(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(state)(_.state(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(validFrom)(_.validFrom(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .build

    def spotInstanceStateFault(
      code: Option[String] = None,
      message: Option[String] = None
    ): SpotInstanceStateFault =
      SpotInstanceStateFault
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def spotInstanceStatus(
      code: Option[String] = None,
      message: Option[String] = None,
      updateTime: Option[DateTime] = None
    ): SpotInstanceStatus =
      SpotInstanceStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def spotMaintenanceStrategies(
      capacityRebalance: Option[SpotCapacityRebalance] = None
    ): SpotMaintenanceStrategies =
      SpotMaintenanceStrategies
        .builder
        .ifSome(capacityRebalance)(_.capacityRebalance(_))
        .build

    def spotMarketOptions(
      maxPrice: Option[String] = None,
      spotInstanceType: Option[String] = None,
      blockDurationMinutes: Option[Int] = None,
      validUntil: Option[DateTime] = None,
      instanceInterruptionBehavior: Option[String] = None
    ): SpotMarketOptions =
      SpotMarketOptions
        .builder
        .ifSome(maxPrice)(_.maxPrice(_))
        .ifSome(spotInstanceType)(_.spotInstanceType(_))
        .ifSome(blockDurationMinutes)(_.blockDurationMinutes(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .build

    def spotOptions(
      allocationStrategy: Option[String] = None,
      maintenanceStrategies: Option[FleetSpotMaintenanceStrategies] = None,
      instanceInterruptionBehavior: Option[String] = None,
      instancePoolsToUseCount: Option[Int] = None,
      singleInstanceType: Option[Boolean] = None,
      singleAvailabilityZone: Option[Boolean] = None,
      minTargetCapacity: Option[Int] = None,
      maxTotalPrice: Option[String] = None
    ): SpotOptions =
      SpotOptions
        .builder
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .ifSome(maintenanceStrategies)(_.maintenanceStrategies(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .ifSome(instancePoolsToUseCount)(_.instancePoolsToUseCount(_))
        .ifSome(singleInstanceType)(_.singleInstanceType(_))
        .ifSome(singleAvailabilityZone)(_.singleAvailabilityZone(_))
        .ifSome(minTargetCapacity)(_.minTargetCapacity(_))
        .ifSome(maxTotalPrice)(_.maxTotalPrice(_))
        .build

    def spotOptionsRequest(
      allocationStrategy: Option[String] = None,
      maintenanceStrategies: Option[FleetSpotMaintenanceStrategiesRequest] = None,
      instanceInterruptionBehavior: Option[String] = None,
      instancePoolsToUseCount: Option[Int] = None,
      singleInstanceType: Option[Boolean] = None,
      singleAvailabilityZone: Option[Boolean] = None,
      minTargetCapacity: Option[Int] = None,
      maxTotalPrice: Option[String] = None
    ): SpotOptionsRequest =
      SpotOptionsRequest
        .builder
        .ifSome(allocationStrategy)(_.allocationStrategy(_))
        .ifSome(maintenanceStrategies)(_.maintenanceStrategies(_))
        .ifSome(instanceInterruptionBehavior)(_.instanceInterruptionBehavior(_))
        .ifSome(instancePoolsToUseCount)(_.instancePoolsToUseCount(_))
        .ifSome(singleInstanceType)(_.singleInstanceType(_))
        .ifSome(singleAvailabilityZone)(_.singleAvailabilityZone(_))
        .ifSome(minTargetCapacity)(_.minTargetCapacity(_))
        .ifSome(maxTotalPrice)(_.maxTotalPrice(_))
        .build

    def spotPlacement(
      availabilityZone: Option[String] = None,
      groupName: Option[String] = None,
      tenancy: Option[String] = None
    ): SpotPlacement =
      SpotPlacement
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(tenancy)(_.tenancy(_))
        .build

    def spotPrice(
      availabilityZone: Option[String] = None,
      instanceType: Option[String] = None,
      productDescription: Option[String] = None,
      spotPrice: Option[String] = None,
      timestamp: Option[DateTime] = None
    ): SpotPrice =
      SpotPrice
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(spotPrice)(_.spotPrice(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def staleIpPermission(
      fromPort: Option[Int] = None,
      ipProtocol: Option[String] = None,
      ipRanges: Option[List[String]] = None,
      prefixListIds: Option[List[String]] = None,
      toPort: Option[Int] = None,
      userIdGroupPairs: Option[List[UserIdGroupPair]] = None
    ): StaleIpPermission =
      StaleIpPermission
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(ipProtocol)(_.ipProtocol(_))
        .ifSome(ipRanges)(_.ipRanges(_))
        .ifSome(prefixListIds)(_.prefixListIds(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(userIdGroupPairs)(_.userIdGroupPairs(_))
        .build

    def staleSecurityGroup(
      description: Option[String] = None,
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      staleIpPermissions: Option[List[StaleIpPermission]] = None,
      staleIpPermissionsEgress: Option[List[StaleIpPermission]] = None,
      vpcId: Option[String] = None
    ): StaleSecurityGroup =
      StaleSecurityGroup
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(staleIpPermissions)(_.staleIpPermissions(_))
        .ifSome(staleIpPermissionsEgress)(_.staleIpPermissionsEgress(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def startInstancesRequest(
      instanceIds: Option[List[InstanceId]] = None,
      additionalInfo: Option[String] = None
    ): StartInstancesRequest =
      StartInstancesRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .build

    def startNetworkInsightsAnalysisRequest(
      networkInsightsPathId: Option[String] = None,
      filterInArns: Option[List[ResourceArn]] = None,
      tagSpecifications: Option[List[TagSpecification]] = None,
      clientToken: Option[String] = None
    ): StartNetworkInsightsAnalysisRequest =
      StartNetworkInsightsAnalysisRequest
        .builder
        .ifSome(networkInsightsPathId)(_.networkInsightsPathId(_))
        .ifSome(filterInArns)(_.filterInArns(_))
        .ifSome(tagSpecifications)(_.tagSpecifications(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startVpcEndpointServicePrivateDnsVerificationRequest(
      serviceId: Option[String] = None
    ): StartVpcEndpointServicePrivateDnsVerificationRequest =
      StartVpcEndpointServicePrivateDnsVerificationRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .build

    def stateReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): StateReason =
      StateReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def stopInstancesRequest(
      instanceIds: Option[List[InstanceId]] = None,
      hibernate: Option[Boolean] = None,
      force: Option[Boolean] = None
    ): StopInstancesRequest =
      StopInstancesRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(hibernate)(_.hibernate(_))
        .ifSome(force)(_.force(_))
        .build

    def storage(
      s3: Option[S3Storage] = None
    ): Storage =
      Storage
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def storageLocation(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): StorageLocation =
      StorageLocation
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def subnet(
      availabilityZone: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      availableIpAddressCount: Option[Int] = None,
      cidrBlock: Option[String] = None,
      defaultForAz: Option[Boolean] = None,
      mapPublicIpOnLaunch: Option[Boolean] = None,
      mapCustomerOwnedIpOnLaunch: Option[Boolean] = None,
      customerOwnedIpv4Pool: Option[String] = None,
      state: Option[String] = None,
      subnetId: Option[String] = None,
      vpcId: Option[String] = None,
      ownerId: Option[String] = None,
      assignIpv6AddressOnCreation: Option[Boolean] = None,
      ipv6CidrBlockAssociationSet: Option[List[SubnetIpv6CidrBlockAssociation]] = None,
      tags: Option[List[Tag]] = None,
      subnetArn: Option[String] = None,
      outpostArn: Option[String] = None
    ): Subnet =
      Subnet
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(availableIpAddressCount)(_.availableIpAddressCount(_))
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(defaultForAz)(_.defaultForAz(_))
        .ifSome(mapPublicIpOnLaunch)(_.mapPublicIpOnLaunch(_))
        .ifSome(mapCustomerOwnedIpOnLaunch)(_.mapCustomerOwnedIpOnLaunch(_))
        .ifSome(customerOwnedIpv4Pool)(_.customerOwnedIpv4Pool(_))
        .ifSome(state)(_.state(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(assignIpv6AddressOnCreation)(_.assignIpv6AddressOnCreation(_))
        .ifSome(ipv6CidrBlockAssociationSet)(_.ipv6CidrBlockAssociationSet(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(subnetArn)(_.subnetArn(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .build

    def subnetAssociation(
      subnetId: Option[String] = None,
      state: Option[String] = None
    ): SubnetAssociation =
      SubnetAssociation
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(state)(_.state(_))
        .build

    def subnetCidrBlockState(
      state: Option[String] = None,
      statusMessage: Option[String] = None
    ): SubnetCidrBlockState =
      SubnetCidrBlockState
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def subnetIpv6CidrBlockAssociation(
      associationId: Option[String] = None,
      ipv6CidrBlock: Option[String] = None,
      ipv6CidrBlockState: Option[SubnetCidrBlockState] = None
    ): SubnetIpv6CidrBlockAssociation =
      SubnetIpv6CidrBlockAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(ipv6CidrBlockState)(_.ipv6CidrBlockState(_))
        .build

    def successfulInstanceCreditSpecificationItem(
      instanceId: Option[String] = None
    ): SuccessfulInstanceCreditSpecificationItem =
      SuccessfulInstanceCreditSpecificationItem
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def successfulQueuedPurchaseDeletion(
      reservedInstancesId: Option[String] = None
    ): SuccessfulQueuedPurchaseDeletion =
      SuccessfulQueuedPurchaseDeletion
        .builder
        .ifSome(reservedInstancesId)(_.reservedInstancesId(_))
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

    def tagDescription(
      key: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      value: Option[String] = None
    ): TagDescription =
      TagDescription
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(value)(_.value(_))
        .build

    def tagSpecification(
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagSpecification =
      TagSpecification
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def targetCapacitySpecification(
      totalTargetCapacity: Option[Int] = None,
      onDemandTargetCapacity: Option[Int] = None,
      spotTargetCapacity: Option[Int] = None,
      defaultTargetCapacityType: Option[String] = None
    ): TargetCapacitySpecification =
      TargetCapacitySpecification
        .builder
        .ifSome(totalTargetCapacity)(_.totalTargetCapacity(_))
        .ifSome(onDemandTargetCapacity)(_.onDemandTargetCapacity(_))
        .ifSome(spotTargetCapacity)(_.spotTargetCapacity(_))
        .ifSome(defaultTargetCapacityType)(_.defaultTargetCapacityType(_))
        .build

    def targetCapacitySpecificationRequest(
      totalTargetCapacity: Option[Int] = None,
      onDemandTargetCapacity: Option[Int] = None,
      spotTargetCapacity: Option[Int] = None,
      defaultTargetCapacityType: Option[String] = None
    ): TargetCapacitySpecificationRequest =
      TargetCapacitySpecificationRequest
        .builder
        .ifSome(totalTargetCapacity)(_.totalTargetCapacity(_))
        .ifSome(onDemandTargetCapacity)(_.onDemandTargetCapacity(_))
        .ifSome(spotTargetCapacity)(_.spotTargetCapacity(_))
        .ifSome(defaultTargetCapacityType)(_.defaultTargetCapacityType(_))
        .build

    def targetConfiguration(
      instanceCount: Option[Int] = None,
      offeringId: Option[String] = None
    ): TargetConfiguration =
      TargetConfiguration
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(offeringId)(_.offeringId(_))
        .build

    def targetConfigurationRequest(
      instanceCount: Option[Int] = None,
      offeringId: Option[String] = None
    ): TargetConfigurationRequest =
      TargetConfigurationRequest
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(offeringId)(_.offeringId(_))
        .build

    def targetGroup(
      arn: Option[String] = None
    ): TargetGroup =
      TargetGroup
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def targetGroupsConfig(
      targetGroups: Option[List[TargetGroup]] = None
    ): TargetGroupsConfig =
      TargetGroupsConfig
        .builder
        .ifSome(targetGroups)(_.targetGroups(_))
        .build

    def targetNetwork(
      associationId: Option[String] = None,
      vpcId: Option[String] = None,
      targetNetworkId: Option[String] = None,
      clientVpnEndpointId: Option[String] = None,
      status: Option[AssociationStatus] = None,
      securityGroups: Option[List[String]] = None
    ): TargetNetwork =
      TargetNetwork
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(targetNetworkId)(_.targetNetworkId(_))
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(status)(_.status(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def targetReservationValue(
      reservationValue: Option[ReservationValue] = None,
      targetConfiguration: Option[TargetConfiguration] = None
    ): TargetReservationValue =
      TargetReservationValue
        .builder
        .ifSome(reservationValue)(_.reservationValue(_))
        .ifSome(targetConfiguration)(_.targetConfiguration(_))
        .build

    def terminateClientVpnConnectionsRequest(
      clientVpnEndpointId: Option[String] = None,
      connectionId: Option[String] = None,
      username: Option[String] = None
    ): TerminateClientVpnConnectionsRequest =
      TerminateClientVpnConnectionsRequest
        .builder
        .ifSome(clientVpnEndpointId)(_.clientVpnEndpointId(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(username)(_.username(_))
        .build

    def terminateConnectionStatus(
      connectionId: Option[String] = None,
      previousStatus: Option[ClientVpnConnectionStatus] = None,
      currentStatus: Option[ClientVpnConnectionStatus] = None
    ): TerminateConnectionStatus =
      TerminateConnectionStatus
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(previousStatus)(_.previousStatus(_))
        .ifSome(currentStatus)(_.currentStatus(_))
        .build

    def terminateInstancesRequest(
      instanceIds: Option[List[InstanceId]] = None
    ): TerminateInstancesRequest =
      TerminateInstancesRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def trafficMirrorFilter(
      trafficMirrorFilterId: Option[String] = None,
      ingressFilterRules: Option[List[TrafficMirrorFilterRule]] = None,
      egressFilterRules: Option[List[TrafficMirrorFilterRule]] = None,
      networkServices: Option[List[TrafficMirrorNetworkService]] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TrafficMirrorFilter =
      TrafficMirrorFilter
        .builder
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .ifSome(ingressFilterRules)(_.ingressFilterRules(_))
        .ifSome(egressFilterRules)(_.egressFilterRules(_))
        .ifSome(networkServices)(_.networkServices(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def trafficMirrorFilterRule(
      trafficMirrorFilterRuleId: Option[String] = None,
      trafficMirrorFilterId: Option[String] = None,
      trafficDirection: Option[String] = None,
      ruleNumber: Option[Int] = None,
      ruleAction: Option[String] = None,
      protocol: Option[Int] = None,
      destinationPortRange: Option[TrafficMirrorPortRange] = None,
      sourcePortRange: Option[TrafficMirrorPortRange] = None,
      destinationCidrBlock: Option[String] = None,
      sourceCidrBlock: Option[String] = None,
      description: Option[String] = None
    ): TrafficMirrorFilterRule =
      TrafficMirrorFilterRule
        .builder
        .ifSome(trafficMirrorFilterRuleId)(_.trafficMirrorFilterRuleId(_))
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .ifSome(trafficDirection)(_.trafficDirection(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(destinationPortRange)(_.destinationPortRange(_))
        .ifSome(sourcePortRange)(_.sourcePortRange(_))
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(sourceCidrBlock)(_.sourceCidrBlock(_))
        .ifSome(description)(_.description(_))
        .build

    def trafficMirrorPortRange(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None
    ): TrafficMirrorPortRange =
      TrafficMirrorPortRange
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .build

    def trafficMirrorPortRangeRequest(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None
    ): TrafficMirrorPortRangeRequest =
      TrafficMirrorPortRangeRequest
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .build

    def trafficMirrorSession(
      trafficMirrorSessionId: Option[String] = None,
      trafficMirrorTargetId: Option[String] = None,
      trafficMirrorFilterId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      ownerId: Option[String] = None,
      packetLength: Option[Int] = None,
      sessionNumber: Option[Int] = None,
      virtualNetworkId: Option[Int] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TrafficMirrorSession =
      TrafficMirrorSession
        .builder
        .ifSome(trafficMirrorSessionId)(_.trafficMirrorSessionId(_))
        .ifSome(trafficMirrorTargetId)(_.trafficMirrorTargetId(_))
        .ifSome(trafficMirrorFilterId)(_.trafficMirrorFilterId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(packetLength)(_.packetLength(_))
        .ifSome(sessionNumber)(_.sessionNumber(_))
        .ifSome(virtualNetworkId)(_.virtualNetworkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def trafficMirrorTarget(
      trafficMirrorTargetId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      networkLoadBalancerArn: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      ownerId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TrafficMirrorTarget =
      TrafficMirrorTarget
        .builder
        .ifSome(trafficMirrorTargetId)(_.trafficMirrorTargetId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(networkLoadBalancerArn)(_.networkLoadBalancerArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGateway(
      transitGatewayId: Option[String] = None,
      transitGatewayArn: Option[String] = None,
      state: Option[String] = None,
      ownerId: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[DateTime] = None,
      options: Option[TransitGatewayOptions] = None,
      tags: Option[List[Tag]] = None
    ): TransitGateway =
      TransitGateway
        .builder
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(transitGatewayArn)(_.transitGatewayArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(options)(_.options(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayAssociation(
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayAssociation =
      TransitGatewayAssociation
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayAttachment(
      transitGatewayAttachmentId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      transitGatewayOwnerId: Option[String] = None,
      resourceOwnerId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      state: Option[String] = None,
      association: Option[TransitGatewayAttachmentAssociation] = None,
      creationTime: Option[DateTime] = None,
      tags: Option[List[Tag]] = None
    ): TransitGatewayAttachment =
      TransitGatewayAttachment
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(transitGatewayOwnerId)(_.transitGatewayOwnerId(_))
        .ifSome(resourceOwnerId)(_.resourceOwnerId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(state)(_.state(_))
        .ifSome(association)(_.association(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayAttachmentAssociation(
      transitGatewayRouteTableId: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayAttachmentAssociation =
      TransitGatewayAttachmentAssociation
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayAttachmentBgpConfiguration(
      transitGatewayAsn: Option[Long] = None,
      peerAsn: Option[Long] = None,
      transitGatewayAddress: Option[String] = None,
      peerAddress: Option[String] = None,
      bgpStatus: Option[String] = None
    ): TransitGatewayAttachmentBgpConfiguration =
      TransitGatewayAttachmentBgpConfiguration
        .builder
        .ifSome(transitGatewayAsn)(_.transitGatewayAsn(_))
        .ifSome(peerAsn)(_.peerAsn(_))
        .ifSome(transitGatewayAddress)(_.transitGatewayAddress(_))
        .ifSome(peerAddress)(_.peerAddress(_))
        .ifSome(bgpStatus)(_.bgpStatus(_))
        .build

    def transitGatewayAttachmentPropagation(
      transitGatewayRouteTableId: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayAttachmentPropagation =
      TransitGatewayAttachmentPropagation
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayConnect(
      transitGatewayAttachmentId: Option[String] = None,
      transportTransitGatewayAttachmentId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      state: Option[String] = None,
      creationTime: Option[DateTime] = None,
      options: Option[TransitGatewayConnectOptions] = None,
      tags: Option[List[Tag]] = None
    ): TransitGatewayConnect =
      TransitGatewayConnect
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(transportTransitGatewayAttachmentId)(_.transportTransitGatewayAttachmentId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(options)(_.options(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayConnectOptions(
      protocol: Option[String] = None
    ): TransitGatewayConnectOptions =
      TransitGatewayConnectOptions
        .builder
        .ifSome(protocol)(_.protocol(_))
        .build

    def transitGatewayConnectPeer(
      transitGatewayAttachmentId: Option[String] = None,
      transitGatewayConnectPeerId: Option[String] = None,
      state: Option[String] = None,
      creationTime: Option[DateTime] = None,
      connectPeerConfiguration: Option[TransitGatewayConnectPeerConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): TransitGatewayConnectPeer =
      TransitGatewayConnectPeer
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(transitGatewayConnectPeerId)(_.transitGatewayConnectPeerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(connectPeerConfiguration)(_.connectPeerConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayConnectPeerConfiguration(
      transitGatewayAddress: Option[String] = None,
      peerAddress: Option[String] = None,
      insideCidrBlocks: Option[List[String]] = None,
      protocol: Option[String] = None,
      bgpConfigurations: Option[List[TransitGatewayAttachmentBgpConfiguration]] = None
    ): TransitGatewayConnectPeerConfiguration =
      TransitGatewayConnectPeerConfiguration
        .builder
        .ifSome(transitGatewayAddress)(_.transitGatewayAddress(_))
        .ifSome(peerAddress)(_.peerAddress(_))
        .ifSome(insideCidrBlocks)(_.insideCidrBlocks(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(bgpConfigurations)(_.bgpConfigurations(_))
        .build

    def transitGatewayConnectRequestBgpOptions(
      peerAsn: Option[Long] = None
    ): TransitGatewayConnectRequestBgpOptions =
      TransitGatewayConnectRequestBgpOptions
        .builder
        .ifSome(peerAsn)(_.peerAsn(_))
        .build

    def transitGatewayMulticastDeregisteredGroupMembers(
      transitGatewayMulticastDomainId: Option[String] = None,
      deregisteredNetworkInterfaceIds: Option[List[String]] = None,
      groupIpAddress: Option[String] = None
    ): TransitGatewayMulticastDeregisteredGroupMembers =
      TransitGatewayMulticastDeregisteredGroupMembers
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(deregisteredNetworkInterfaceIds)(_.deregisteredNetworkInterfaceIds(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .build

    def transitGatewayMulticastDeregisteredGroupSources(
      transitGatewayMulticastDomainId: Option[String] = None,
      deregisteredNetworkInterfaceIds: Option[List[String]] = None,
      groupIpAddress: Option[String] = None
    ): TransitGatewayMulticastDeregisteredGroupSources =
      TransitGatewayMulticastDeregisteredGroupSources
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(deregisteredNetworkInterfaceIds)(_.deregisteredNetworkInterfaceIds(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .build

    def transitGatewayMulticastDomain(
      transitGatewayMulticastDomainId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      transitGatewayMulticastDomainArn: Option[String] = None,
      ownerId: Option[String] = None,
      options: Option[TransitGatewayMulticastDomainOptions] = None,
      state: Option[String] = None,
      creationTime: Option[DateTime] = None,
      tags: Option[List[Tag]] = None
    ): TransitGatewayMulticastDomain =
      TransitGatewayMulticastDomain
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(transitGatewayMulticastDomainArn)(_.transitGatewayMulticastDomainArn(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(options)(_.options(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayMulticastDomainAssociation(
      transitGatewayAttachmentId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceOwnerId: Option[String] = None,
      subnet: Option[SubnetAssociation] = None
    ): TransitGatewayMulticastDomainAssociation =
      TransitGatewayMulticastDomainAssociation
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceOwnerId)(_.resourceOwnerId(_))
        .ifSome(subnet)(_.subnet(_))
        .build

    def transitGatewayMulticastDomainAssociations(
      transitGatewayMulticastDomainId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceOwnerId: Option[String] = None,
      subnets: Option[List[SubnetAssociation]] = None
    ): TransitGatewayMulticastDomainAssociations =
      TransitGatewayMulticastDomainAssociations
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceOwnerId)(_.resourceOwnerId(_))
        .ifSome(subnets)(_.subnets(_))
        .build

    def transitGatewayMulticastDomainOptions(
      igmpv2Support: Option[String] = None,
      staticSourcesSupport: Option[String] = None,
      autoAcceptSharedAssociations: Option[String] = None
    ): TransitGatewayMulticastDomainOptions =
      TransitGatewayMulticastDomainOptions
        .builder
        .ifSome(igmpv2Support)(_.igmpv2Support(_))
        .ifSome(staticSourcesSupport)(_.staticSourcesSupport(_))
        .ifSome(autoAcceptSharedAssociations)(_.autoAcceptSharedAssociations(_))
        .build

    def transitGatewayMulticastGroup(
      groupIpAddress: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      subnetId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceOwnerId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      groupMember: Option[Boolean] = None,
      groupSource: Option[Boolean] = None,
      memberType: Option[String] = None,
      sourceType: Option[String] = None
    ): TransitGatewayMulticastGroup =
      TransitGatewayMulticastGroup
        .builder
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceOwnerId)(_.resourceOwnerId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(groupMember)(_.groupMember(_))
        .ifSome(groupSource)(_.groupSource(_))
        .ifSome(memberType)(_.memberType(_))
        .ifSome(sourceType)(_.sourceType(_))
        .build

    def transitGatewayMulticastRegisteredGroupMembers(
      transitGatewayMulticastDomainId: Option[String] = None,
      registeredNetworkInterfaceIds: Option[List[String]] = None,
      groupIpAddress: Option[String] = None
    ): TransitGatewayMulticastRegisteredGroupMembers =
      TransitGatewayMulticastRegisteredGroupMembers
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(registeredNetworkInterfaceIds)(_.registeredNetworkInterfaceIds(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .build

    def transitGatewayMulticastRegisteredGroupSources(
      transitGatewayMulticastDomainId: Option[String] = None,
      registeredNetworkInterfaceIds: Option[List[String]] = None,
      groupIpAddress: Option[String] = None
    ): TransitGatewayMulticastRegisteredGroupSources =
      TransitGatewayMulticastRegisteredGroupSources
        .builder
        .ifSome(transitGatewayMulticastDomainId)(_.transitGatewayMulticastDomainId(_))
        .ifSome(registeredNetworkInterfaceIds)(_.registeredNetworkInterfaceIds(_))
        .ifSome(groupIpAddress)(_.groupIpAddress(_))
        .build

    def transitGatewayOptions(
      amazonSideAsn: Option[Long] = None,
      transitGatewayCidrBlocks: Option[List[String]] = None,
      autoAcceptSharedAttachments: Option[String] = None,
      defaultRouteTableAssociation: Option[String] = None,
      associationDefaultRouteTableId: Option[String] = None,
      defaultRouteTablePropagation: Option[String] = None,
      propagationDefaultRouteTableId: Option[String] = None,
      vpnEcmpSupport: Option[String] = None,
      dnsSupport: Option[String] = None,
      multicastSupport: Option[String] = None
    ): TransitGatewayOptions =
      TransitGatewayOptions
        .builder
        .ifSome(amazonSideAsn)(_.amazonSideAsn(_))
        .ifSome(transitGatewayCidrBlocks)(_.transitGatewayCidrBlocks(_))
        .ifSome(autoAcceptSharedAttachments)(_.autoAcceptSharedAttachments(_))
        .ifSome(defaultRouteTableAssociation)(_.defaultRouteTableAssociation(_))
        .ifSome(associationDefaultRouteTableId)(_.associationDefaultRouteTableId(_))
        .ifSome(defaultRouteTablePropagation)(_.defaultRouteTablePropagation(_))
        .ifSome(propagationDefaultRouteTableId)(_.propagationDefaultRouteTableId(_))
        .ifSome(vpnEcmpSupport)(_.vpnEcmpSupport(_))
        .ifSome(dnsSupport)(_.dnsSupport(_))
        .ifSome(multicastSupport)(_.multicastSupport(_))
        .build

    def transitGatewayPeeringAttachment(
      transitGatewayAttachmentId: Option[String] = None,
      requesterTgwInfo: Option[PeeringTgwInfo] = None,
      accepterTgwInfo: Option[PeeringTgwInfo] = None,
      status: Option[PeeringAttachmentStatus] = None,
      state: Option[String] = None,
      creationTime: Option[DateTime] = None,
      tags: Option[List[Tag]] = None
    ): TransitGatewayPeeringAttachment =
      TransitGatewayPeeringAttachment
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(requesterTgwInfo)(_.requesterTgwInfo(_))
        .ifSome(accepterTgwInfo)(_.accepterTgwInfo(_))
        .ifSome(status)(_.status(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayPrefixListAttachment(
      transitGatewayAttachmentId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): TransitGatewayPrefixListAttachment =
      TransitGatewayPrefixListAttachment
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def transitGatewayPrefixListReference(
      transitGatewayRouteTableId: Option[String] = None,
      prefixListId: Option[String] = None,
      prefixListOwnerId: Option[String] = None,
      state: Option[String] = None,
      blackhole: Option[Boolean] = None,
      transitGatewayAttachment: Option[TransitGatewayPrefixListAttachment] = None
    ): TransitGatewayPrefixListReference =
      TransitGatewayPrefixListReference
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(prefixListOwnerId)(_.prefixListOwnerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(blackhole)(_.blackhole(_))
        .ifSome(transitGatewayAttachment)(_.transitGatewayAttachment(_))
        .build

    def transitGatewayPropagation(
      transitGatewayAttachmentId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      transitGatewayRouteTableId: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayPropagation =
      TransitGatewayPropagation
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayRequestOptions(
      amazonSideAsn: Option[Long] = None,
      autoAcceptSharedAttachments: Option[String] = None,
      defaultRouteTableAssociation: Option[String] = None,
      defaultRouteTablePropagation: Option[String] = None,
      vpnEcmpSupport: Option[String] = None,
      dnsSupport: Option[String] = None,
      multicastSupport: Option[String] = None,
      transitGatewayCidrBlocks: Option[List[String]] = None
    ): TransitGatewayRequestOptions =
      TransitGatewayRequestOptions
        .builder
        .ifSome(amazonSideAsn)(_.amazonSideAsn(_))
        .ifSome(autoAcceptSharedAttachments)(_.autoAcceptSharedAttachments(_))
        .ifSome(defaultRouteTableAssociation)(_.defaultRouteTableAssociation(_))
        .ifSome(defaultRouteTablePropagation)(_.defaultRouteTablePropagation(_))
        .ifSome(vpnEcmpSupport)(_.vpnEcmpSupport(_))
        .ifSome(dnsSupport)(_.dnsSupport(_))
        .ifSome(multicastSupport)(_.multicastSupport(_))
        .ifSome(transitGatewayCidrBlocks)(_.transitGatewayCidrBlocks(_))
        .build

    def transitGatewayRoute(
      destinationCidrBlock: Option[String] = None,
      prefixListId: Option[String] = None,
      transitGatewayAttachments: Option[List[TransitGatewayRouteAttachment]] = None,
      `type`: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayRoute =
      TransitGatewayRoute
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(transitGatewayAttachments)(_.transitGatewayAttachments(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayRouteAttachment(
      resourceId: Option[String] = None,
      transitGatewayAttachmentId: Option[String] = None,
      resourceType: Option[String] = None
    ): TransitGatewayRouteAttachment =
      TransitGatewayRouteAttachment
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def transitGatewayRouteTable(
      transitGatewayRouteTableId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      state: Option[String] = None,
      defaultAssociationRouteTable: Option[Boolean] = None,
      defaultPropagationRouteTable: Option[Boolean] = None,
      creationTime: Option[DateTime] = None,
      tags: Option[List[Tag]] = None
    ): TransitGatewayRouteTable =
      TransitGatewayRouteTable
        .builder
        .ifSome(transitGatewayRouteTableId)(_.transitGatewayRouteTableId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(state)(_.state(_))
        .ifSome(defaultAssociationRouteTable)(_.defaultAssociationRouteTable(_))
        .ifSome(defaultPropagationRouteTable)(_.defaultPropagationRouteTable(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayRouteTableAssociation(
      transitGatewayAttachmentId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayRouteTableAssociation =
      TransitGatewayRouteTableAssociation
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayRouteTablePropagation(
      transitGatewayAttachmentId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      state: Option[String] = None
    ): TransitGatewayRouteTablePropagation =
      TransitGatewayRouteTablePropagation
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(state)(_.state(_))
        .build

    def transitGatewayVpcAttachment(
      transitGatewayAttachmentId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      vpcId: Option[String] = None,
      vpcOwnerId: Option[String] = None,
      state: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      creationTime: Option[DateTime] = None,
      options: Option[TransitGatewayVpcAttachmentOptions] = None,
      tags: Option[List[Tag]] = None
    ): TransitGatewayVpcAttachment =
      TransitGatewayVpcAttachment
        .builder
        .ifSome(transitGatewayAttachmentId)(_.transitGatewayAttachmentId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpcOwnerId)(_.vpcOwnerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(options)(_.options(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transitGatewayVpcAttachmentOptions(
      dnsSupport: Option[String] = None,
      ipv6Support: Option[String] = None,
      applianceModeSupport: Option[String] = None
    ): TransitGatewayVpcAttachmentOptions =
      TransitGatewayVpcAttachmentOptions
        .builder
        .ifSome(dnsSupport)(_.dnsSupport(_))
        .ifSome(ipv6Support)(_.ipv6Support(_))
        .ifSome(applianceModeSupport)(_.applianceModeSupport(_))
        .build

    def tunnelOption(
      outsideIpAddress: Option[String] = None,
      tunnelInsideCidr: Option[String] = None,
      tunnelInsideIpv6Cidr: Option[String] = None,
      preSharedKey: Option[String] = None,
      phase1LifetimeSeconds: Option[Int] = None,
      phase2LifetimeSeconds: Option[Int] = None,
      rekeyMarginTimeSeconds: Option[Int] = None,
      rekeyFuzzPercentage: Option[Int] = None,
      replayWindowSize: Option[Int] = None,
      dpdTimeoutSeconds: Option[Int] = None,
      dpdTimeoutAction: Option[String] = None,
      phase1EncryptionAlgorithms: Option[List[Phase1EncryptionAlgorithmsListValue]] = None,
      phase2EncryptionAlgorithms: Option[List[Phase2EncryptionAlgorithmsListValue]] = None,
      phase1IntegrityAlgorithms: Option[List[Phase1IntegrityAlgorithmsListValue]] = None,
      phase2IntegrityAlgorithms: Option[List[Phase2IntegrityAlgorithmsListValue]] = None,
      phase1DHGroupNumbers: Option[List[Phase1DHGroupNumbersListValue]] = None,
      phase2DHGroupNumbers: Option[List[Phase2DHGroupNumbersListValue]] = None,
      ikeVersions: Option[List[IKEVersionsListValue]] = None,
      startupAction: Option[String] = None
    ): TunnelOption =
      TunnelOption
        .builder
        .ifSome(outsideIpAddress)(_.outsideIpAddress(_))
        .ifSome(tunnelInsideCidr)(_.tunnelInsideCidr(_))
        .ifSome(tunnelInsideIpv6Cidr)(_.tunnelInsideIpv6Cidr(_))
        .ifSome(preSharedKey)(_.preSharedKey(_))
        .ifSome(phase1LifetimeSeconds)(_.phase1LifetimeSeconds(_))
        .ifSome(phase2LifetimeSeconds)(_.phase2LifetimeSeconds(_))
        .ifSome(rekeyMarginTimeSeconds)(_.rekeyMarginTimeSeconds(_))
        .ifSome(rekeyFuzzPercentage)(_.rekeyFuzzPercentage(_))
        .ifSome(replayWindowSize)(_.replayWindowSize(_))
        .ifSome(dpdTimeoutSeconds)(_.dpdTimeoutSeconds(_))
        .ifSome(dpdTimeoutAction)(_.dpdTimeoutAction(_))
        .ifSome(phase1EncryptionAlgorithms)(_.phase1EncryptionAlgorithms(_))
        .ifSome(phase2EncryptionAlgorithms)(_.phase2EncryptionAlgorithms(_))
        .ifSome(phase1IntegrityAlgorithms)(_.phase1IntegrityAlgorithms(_))
        .ifSome(phase2IntegrityAlgorithms)(_.phase2IntegrityAlgorithms(_))
        .ifSome(phase1DHGroupNumbers)(_.phase1DHGroupNumbers(_))
        .ifSome(phase2DHGroupNumbers)(_.phase2DHGroupNumbers(_))
        .ifSome(ikeVersions)(_.ikeVersions(_))
        .ifSome(startupAction)(_.startupAction(_))
        .build

    def unassignIpv6AddressesRequest(
      networkInterfaceId: Option[String] = None,
      ipv6Addresses: Option[List[String]] = None
    ): UnassignIpv6AddressesRequest =
      UnassignIpv6AddressesRequest
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .build

    def unassignPrivateIpAddressesRequest(
      networkInterfaceId: Option[String] = None,
      privateIpAddresses: Option[List[String]] = None
    ): UnassignPrivateIpAddressesRequest =
      UnassignPrivateIpAddressesRequest
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .build

    def unmonitorInstancesRequest(
      instanceIds: Option[List[InstanceId]] = None
    ): UnmonitorInstancesRequest =
      UnmonitorInstancesRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def unsuccessfulInstanceCreditSpecificationItem(
      instanceId: Option[String] = None,
      error: Option[UnsuccessfulInstanceCreditSpecificationItemError] = None
    ): UnsuccessfulInstanceCreditSpecificationItem =
      UnsuccessfulInstanceCreditSpecificationItem
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(error)(_.error(_))
        .build

    def unsuccessfulInstanceCreditSpecificationItemError(
      code: Option[String] = None,
      message: Option[String] = None
    ): UnsuccessfulInstanceCreditSpecificationItemError =
      UnsuccessfulInstanceCreditSpecificationItemError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def unsuccessfulItem(
      error: Option[UnsuccessfulItemError] = None,
      resourceId: Option[String] = None
    ): UnsuccessfulItem =
      UnsuccessfulItem
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def unsuccessfulItemError(
      code: Option[String] = None,
      message: Option[String] = None
    ): UnsuccessfulItemError =
      UnsuccessfulItemError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def updateSecurityGroupRuleDescriptionsEgressRequest(
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      ipPermissions: Option[List[IpPermission]] = None
    ): UpdateSecurityGroupRuleDescriptionsEgressRequest =
      UpdateSecurityGroupRuleDescriptionsEgressRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .build

    def updateSecurityGroupRuleDescriptionsIngressRequest(
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      ipPermissions: Option[List[IpPermission]] = None
    ): UpdateSecurityGroupRuleDescriptionsIngressRequest =
      UpdateSecurityGroupRuleDescriptionsIngressRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .build

    def userBucket(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None
    ): UserBucket =
      UserBucket
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def userBucketDetails(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None
    ): UserBucketDetails =
      UserBucketDetails
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def userData(
      data: Option[String] = None
    ): UserData =
      UserData
        .builder
        .ifSome(data)(_.data(_))
        .build

    def userIdGroupPair(
      description: Option[String] = None,
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      peeringStatus: Option[String] = None,
      userId: Option[String] = None,
      vpcId: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): UserIdGroupPair =
      UserIdGroupPair
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(peeringStatus)(_.peeringStatus(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def vCpuInfo(
      defaultVCpus: Option[Int] = None,
      defaultCores: Option[Int] = None,
      defaultThreadsPerCore: Option[Int] = None,
      validCores: Option[List[CoreCount]] = None,
      validThreadsPerCore: Option[List[ThreadsPerCore]] = None
    ): VCpuInfo =
      VCpuInfo
        .builder
        .ifSome(defaultVCpus)(_.defaultVCpus(_))
        .ifSome(defaultCores)(_.defaultCores(_))
        .ifSome(defaultThreadsPerCore)(_.defaultThreadsPerCore(_))
        .ifSome(validCores)(_.validCores(_))
        .ifSome(validThreadsPerCore)(_.validThreadsPerCore(_))
        .build

    def validationError(
      code: Option[String] = None,
      message: Option[String] = None
    ): ValidationError =
      ValidationError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def validationWarning(
      errors: Option[List[ValidationError]] = None
    ): ValidationWarning =
      ValidationWarning
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def vgwTelemetry(
      acceptedRouteCount: Option[Int] = None,
      lastStatusChange: Option[DateTime] = None,
      outsideIpAddress: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      certificateArn: Option[String] = None
    ): VgwTelemetry =
      VgwTelemetry
        .builder
        .ifSome(acceptedRouteCount)(_.acceptedRouteCount(_))
        .ifSome(lastStatusChange)(_.lastStatusChange(_))
        .ifSome(outsideIpAddress)(_.outsideIpAddress(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def volume(
      attachments: Option[List[VolumeAttachment]] = None,
      availabilityZone: Option[String] = None,
      createTime: Option[DateTime] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      outpostArn: Option[String] = None,
      size: Option[Int] = None,
      snapshotId: Option[String] = None,
      state: Option[String] = None,
      volumeId: Option[String] = None,
      iops: Option[Int] = None,
      tags: Option[List[Tag]] = None,
      volumeType: Option[String] = None,
      fastRestored: Option[Boolean] = None,
      multiAttachEnabled: Option[Boolean] = None,
      throughput: Option[Int] = None
    ): Volume =
      Volume
        .builder
        .ifSome(attachments)(_.attachments(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(size)(_.size(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(state)(_.state(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(volumeType)(_.volumeType(_))
        .ifSome(fastRestored)(_.fastRestored(_))
        .ifSome(multiAttachEnabled)(_.multiAttachEnabled(_))
        .ifSome(throughput)(_.throughput(_))
        .build

    def volumeAttachment(
      attachTime: Option[DateTime] = None,
      device: Option[String] = None,
      instanceId: Option[String] = None,
      state: Option[String] = None,
      volumeId: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None
    ): VolumeAttachment =
      VolumeAttachment
        .builder
        .ifSome(attachTime)(_.attachTime(_))
        .ifSome(device)(_.device(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(state)(_.state(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .build

    def volumeDetail(
      size: Option[Long] = None
    ): VolumeDetail =
      VolumeDetail
        .builder
        .ifSome(size)(_.size(_))
        .build

    def volumeModification(
      volumeId: Option[String] = None,
      modificationState: Option[String] = None,
      statusMessage: Option[String] = None,
      targetSize: Option[Int] = None,
      targetIops: Option[Int] = None,
      targetVolumeType: Option[String] = None,
      targetThroughput: Option[Int] = None,
      targetMultiAttachEnabled: Option[Boolean] = None,
      originalSize: Option[Int] = None,
      originalIops: Option[Int] = None,
      originalVolumeType: Option[String] = None,
      originalThroughput: Option[Int] = None,
      originalMultiAttachEnabled: Option[Boolean] = None,
      progress: Option[Long] = None,
      startTime: Option[DateTime] = None,
      endTime: Option[DateTime] = None
    ): VolumeModification =
      VolumeModification
        .builder
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(modificationState)(_.modificationState(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(targetSize)(_.targetSize(_))
        .ifSome(targetIops)(_.targetIops(_))
        .ifSome(targetVolumeType)(_.targetVolumeType(_))
        .ifSome(targetThroughput)(_.targetThroughput(_))
        .ifSome(targetMultiAttachEnabled)(_.targetMultiAttachEnabled(_))
        .ifSome(originalSize)(_.originalSize(_))
        .ifSome(originalIops)(_.originalIops(_))
        .ifSome(originalVolumeType)(_.originalVolumeType(_))
        .ifSome(originalThroughput)(_.originalThroughput(_))
        .ifSome(originalMultiAttachEnabled)(_.originalMultiAttachEnabled(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def volumeStatusAction(
      code: Option[String] = None,
      description: Option[String] = None,
      eventId: Option[String] = None,
      eventType: Option[String] = None
    ): VolumeStatusAction =
      VolumeStatusAction
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventType)(_.eventType(_))
        .build

    def volumeStatusAttachmentStatus(
      ioPerformance: Option[String] = None,
      instanceId: Option[String] = None
    ): VolumeStatusAttachmentStatus =
      VolumeStatusAttachmentStatus
        .builder
        .ifSome(ioPerformance)(_.ioPerformance(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def volumeStatusDetails(
      name: Option[String] = None,
      status: Option[String] = None
    ): VolumeStatusDetails =
      VolumeStatusDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def volumeStatusEvent(
      description: Option[String] = None,
      eventId: Option[String] = None,
      eventType: Option[String] = None,
      notAfter: Option[MillisecondDateTime] = None,
      notBefore: Option[MillisecondDateTime] = None,
      instanceId: Option[String] = None
    ): VolumeStatusEvent =
      VolumeStatusEvent
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def volumeStatusInfo(
      details: Option[List[VolumeStatusDetails]] = None,
      status: Option[String] = None
    ): VolumeStatusInfo =
      VolumeStatusInfo
        .builder
        .ifSome(details)(_.details(_))
        .ifSome(status)(_.status(_))
        .build

    def volumeStatusItem(
      actions: Option[List[VolumeStatusAction]] = None,
      availabilityZone: Option[String] = None,
      outpostArn: Option[String] = None,
      events: Option[List[VolumeStatusEvent]] = None,
      volumeId: Option[String] = None,
      volumeStatus: Option[VolumeStatusInfo] = None,
      attachmentStatuses: Option[List[VolumeStatusAttachmentStatus]] = None
    ): VolumeStatusItem =
      VolumeStatusItem
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(events)(_.events(_))
        .ifSome(volumeId)(_.volumeId(_))
        .ifSome(volumeStatus)(_.volumeStatus(_))
        .ifSome(attachmentStatuses)(_.attachmentStatuses(_))
        .build

    def vpc(
      cidrBlock: Option[String] = None,
      dhcpOptionsId: Option[String] = None,
      state: Option[String] = None,
      vpcId: Option[String] = None,
      ownerId: Option[String] = None,
      instanceTenancy: Option[String] = None,
      ipv6CidrBlockAssociationSet: Option[List[VpcIpv6CidrBlockAssociation]] = None,
      cidrBlockAssociationSet: Option[List[VpcCidrBlockAssociation]] = None,
      isDefault: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): Vpc =
      Vpc
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(dhcpOptionsId)(_.dhcpOptionsId(_))
        .ifSome(state)(_.state(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(instanceTenancy)(_.instanceTenancy(_))
        .ifSome(ipv6CidrBlockAssociationSet)(_.ipv6CidrBlockAssociationSet(_))
        .ifSome(cidrBlockAssociationSet)(_.cidrBlockAssociationSet(_))
        .ifSome(isDefault)(_.isDefault(_))
        .ifSome(tags)(_.tags(_))
        .build

    def vpcAttachment(
      state: Option[String] = None,
      vpcId: Option[String] = None
    ): VpcAttachment =
      VpcAttachment
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def vpcCidrBlockAssociation(
      associationId: Option[String] = None,
      cidrBlock: Option[String] = None,
      cidrBlockState: Option[VpcCidrBlockState] = None
    ): VpcCidrBlockAssociation =
      VpcCidrBlockAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(cidrBlockState)(_.cidrBlockState(_))
        .build

    def vpcCidrBlockState(
      state: Option[String] = None,
      statusMessage: Option[String] = None
    ): VpcCidrBlockState =
      VpcCidrBlockState
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def vpcClassicLink(
      classicLinkEnabled: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      vpcId: Option[String] = None
    ): VpcClassicLink =
      VpcClassicLink
        .builder
        .ifSome(classicLinkEnabled)(_.classicLinkEnabled(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def vpcEndpoint(
      vpcEndpointId: Option[String] = None,
      vpcEndpointType: Option[String] = None,
      vpcId: Option[String] = None,
      serviceName: Option[String] = None,
      state: Option[String] = None,
      policyDocument: Option[String] = None,
      routeTableIds: Option[List[String]] = None,
      subnetIds: Option[List[String]] = None,
      groups: Option[List[SecurityGroupIdentifier]] = None,
      privateDnsEnabled: Option[Boolean] = None,
      requesterManaged: Option[Boolean] = None,
      networkInterfaceIds: Option[List[String]] = None,
      dnsEntries: Option[List[DnsEntry]] = None,
      creationTimestamp: Option[MillisecondDateTime] = None,
      tags: Option[List[Tag]] = None,
      ownerId: Option[String] = None,
      lastError: Option[LastError] = None
    ): VpcEndpoint =
      VpcEndpoint
        .builder
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(vpcEndpointType)(_.vpcEndpointType(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(state)(_.state(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(routeTableIds)(_.routeTableIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(privateDnsEnabled)(_.privateDnsEnabled(_))
        .ifSome(requesterManaged)(_.requesterManaged(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .ifSome(dnsEntries)(_.dnsEntries(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(lastError)(_.lastError(_))
        .build

    def vpcEndpointConnection(
      serviceId: Option[String] = None,
      vpcEndpointId: Option[String] = None,
      vpcEndpointOwner: Option[String] = None,
      vpcEndpointState: Option[String] = None,
      creationTimestamp: Option[MillisecondDateTime] = None,
      dnsEntries: Option[List[DnsEntry]] = None,
      networkLoadBalancerArns: Option[List[String]] = None,
      gatewayLoadBalancerArns: Option[List[String]] = None
    ): VpcEndpointConnection =
      VpcEndpointConnection
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(vpcEndpointId)(_.vpcEndpointId(_))
        .ifSome(vpcEndpointOwner)(_.vpcEndpointOwner(_))
        .ifSome(vpcEndpointState)(_.vpcEndpointState(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(dnsEntries)(_.dnsEntries(_))
        .ifSome(networkLoadBalancerArns)(_.networkLoadBalancerArns(_))
        .ifSome(gatewayLoadBalancerArns)(_.gatewayLoadBalancerArns(_))
        .build

    def vpcIpv6CidrBlockAssociation(
      associationId: Option[String] = None,
      ipv6CidrBlock: Option[String] = None,
      ipv6CidrBlockState: Option[VpcCidrBlockState] = None,
      networkBorderGroup: Option[String] = None,
      ipv6Pool: Option[String] = None
    ): VpcIpv6CidrBlockAssociation =
      VpcIpv6CidrBlockAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(ipv6CidrBlockState)(_.ipv6CidrBlockState(_))
        .ifSome(networkBorderGroup)(_.networkBorderGroup(_))
        .ifSome(ipv6Pool)(_.ipv6Pool(_))
        .build

    def vpcPeeringConnection(
      accepterVpcInfo: Option[VpcPeeringConnectionVpcInfo] = None,
      expirationTime: Option[DateTime] = None,
      requesterVpcInfo: Option[VpcPeeringConnectionVpcInfo] = None,
      status: Option[VpcPeeringConnectionStateReason] = None,
      tags: Option[List[Tag]] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): VpcPeeringConnection =
      VpcPeeringConnection
        .builder
        .ifSome(accepterVpcInfo)(_.accepterVpcInfo(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(requesterVpcInfo)(_.requesterVpcInfo(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def vpcPeeringConnectionOptionsDescription(
      allowDnsResolutionFromRemoteVpc: Option[Boolean] = None,
      allowEgressFromLocalClassicLinkToRemoteVpc: Option[Boolean] = None,
      allowEgressFromLocalVpcToRemoteClassicLink: Option[Boolean] = None
    ): VpcPeeringConnectionOptionsDescription =
      VpcPeeringConnectionOptionsDescription
        .builder
        .ifSome(allowDnsResolutionFromRemoteVpc)(_.allowDnsResolutionFromRemoteVpc(_))
        .ifSome(allowEgressFromLocalClassicLinkToRemoteVpc)(_.allowEgressFromLocalClassicLinkToRemoteVpc(_))
        .ifSome(allowEgressFromLocalVpcToRemoteClassicLink)(_.allowEgressFromLocalVpcToRemoteClassicLink(_))
        .build

    def vpcPeeringConnectionStateReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): VpcPeeringConnectionStateReason =
      VpcPeeringConnectionStateReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def vpcPeeringConnectionVpcInfo(
      cidrBlock: Option[String] = None,
      ipv6CidrBlockSet: Option[List[Ipv6CidrBlock]] = None,
      cidrBlockSet: Option[List[CidrBlock]] = None,
      ownerId: Option[String] = None,
      peeringOptions: Option[VpcPeeringConnectionOptionsDescription] = None,
      vpcId: Option[String] = None,
      region: Option[String] = None
    ): VpcPeeringConnectionVpcInfo =
      VpcPeeringConnectionVpcInfo
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(ipv6CidrBlockSet)(_.ipv6CidrBlockSet(_))
        .ifSome(cidrBlockSet)(_.cidrBlockSet(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(peeringOptions)(_.peeringOptions(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(region)(_.region(_))
        .build

    def vpnConnection(
      customerGatewayConfiguration: Option[String] = None,
      customerGatewayId: Option[String] = None,
      category: Option[String] = None,
      state: Option[String] = None,
      `type`: Option[String] = None,
      vpnConnectionId: Option[String] = None,
      vpnGatewayId: Option[String] = None,
      transitGatewayId: Option[String] = None,
      options: Option[VpnConnectionOptions] = None,
      routes: Option[List[VpnStaticRoute]] = None,
      tags: Option[List[Tag]] = None,
      vgwTelemetry: Option[List[VgwTelemetry]] = None
    ): VpnConnection =
      VpnConnection
        .builder
        .ifSome(customerGatewayConfiguration)(_.customerGatewayConfiguration(_))
        .ifSome(customerGatewayId)(_.customerGatewayId(_))
        .ifSome(category)(_.category(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vpnConnectionId)(_.vpnConnectionId(_))
        .ifSome(vpnGatewayId)(_.vpnGatewayId(_))
        .ifSome(transitGatewayId)(_.transitGatewayId(_))
        .ifSome(options)(_.options(_))
        .ifSome(routes)(_.routes(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vgwTelemetry)(_.vgwTelemetry(_))
        .build

    def vpnConnectionOptions(
      enableAcceleration: Option[Boolean] = None,
      staticRoutesOnly: Option[Boolean] = None,
      localIpv4NetworkCidr: Option[String] = None,
      remoteIpv4NetworkCidr: Option[String] = None,
      localIpv6NetworkCidr: Option[String] = None,
      remoteIpv6NetworkCidr: Option[String] = None,
      tunnelInsideIpVersion: Option[String] = None,
      tunnelOptions: Option[List[TunnelOption]] = None
    ): VpnConnectionOptions =
      VpnConnectionOptions
        .builder
        .ifSome(enableAcceleration)(_.enableAcceleration(_))
        .ifSome(staticRoutesOnly)(_.staticRoutesOnly(_))
        .ifSome(localIpv4NetworkCidr)(_.localIpv4NetworkCidr(_))
        .ifSome(remoteIpv4NetworkCidr)(_.remoteIpv4NetworkCidr(_))
        .ifSome(localIpv6NetworkCidr)(_.localIpv6NetworkCidr(_))
        .ifSome(remoteIpv6NetworkCidr)(_.remoteIpv6NetworkCidr(_))
        .ifSome(tunnelInsideIpVersion)(_.tunnelInsideIpVersion(_))
        .ifSome(tunnelOptions)(_.tunnelOptions(_))
        .build

    def vpnConnectionOptionsSpecification(
      enableAcceleration: Option[Boolean] = None,
      staticRoutesOnly: Option[Boolean] = None,
      tunnelInsideIpVersion: Option[String] = None,
      tunnelOptions: Option[List[VpnTunnelOptionsSpecification]] = None,
      localIpv4NetworkCidr: Option[String] = None,
      remoteIpv4NetworkCidr: Option[String] = None,
      localIpv6NetworkCidr: Option[String] = None,
      remoteIpv6NetworkCidr: Option[String] = None
    ): VpnConnectionOptionsSpecification =
      VpnConnectionOptionsSpecification
        .builder
        .ifSome(enableAcceleration)(_.enableAcceleration(_))
        .ifSome(staticRoutesOnly)(_.staticRoutesOnly(_))
        .ifSome(tunnelInsideIpVersion)(_.tunnelInsideIpVersion(_))
        .ifSome(tunnelOptions)(_.tunnelOptions(_))
        .ifSome(localIpv4NetworkCidr)(_.localIpv4NetworkCidr(_))
        .ifSome(remoteIpv4NetworkCidr)(_.remoteIpv4NetworkCidr(_))
        .ifSome(localIpv6NetworkCidr)(_.localIpv6NetworkCidr(_))
        .ifSome(remoteIpv6NetworkCidr)(_.remoteIpv6NetworkCidr(_))
        .build

    def vpnGateway(
      availabilityZone: Option[String] = None,
      state: Option[String] = None,
      `type`: Option[String] = None,
      vpcAttachments: Option[List[VpcAttachment]] = None,
      vpnGatewayId: Option[String] = None,
      amazonSideAsn: Option[Long] = None,
      tags: Option[List[Tag]] = None
    ): VpnGateway =
      VpnGateway
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vpcAttachments)(_.vpcAttachments(_))
        .ifSome(vpnGatewayId)(_.vpnGatewayId(_))
        .ifSome(amazonSideAsn)(_.amazonSideAsn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def vpnStaticRoute(
      destinationCidrBlock: Option[String] = None,
      source: Option[String] = None,
      state: Option[String] = None
    ): VpnStaticRoute =
      VpnStaticRoute
        .builder
        .ifSome(destinationCidrBlock)(_.destinationCidrBlock(_))
        .ifSome(source)(_.source(_))
        .ifSome(state)(_.state(_))
        .build

    def vpnTunnelOptionsSpecification(
      tunnelInsideCidr: Option[String] = None,
      tunnelInsideIpv6Cidr: Option[String] = None,
      preSharedKey: Option[String] = None,
      phase1LifetimeSeconds: Option[Int] = None,
      phase2LifetimeSeconds: Option[Int] = None,
      rekeyMarginTimeSeconds: Option[Int] = None,
      rekeyFuzzPercentage: Option[Int] = None,
      replayWindowSize: Option[Int] = None,
      dPDTimeoutSeconds: Option[Int] = None,
      dPDTimeoutAction: Option[String] = None,
      phase1EncryptionAlgorithms: Option[List[Phase1EncryptionAlgorithmsRequestListValue]] = None,
      phase2EncryptionAlgorithms: Option[List[Phase2EncryptionAlgorithmsRequestListValue]] = None,
      phase1IntegrityAlgorithms: Option[List[Phase1IntegrityAlgorithmsRequestListValue]] = None,
      phase2IntegrityAlgorithms: Option[List[Phase2IntegrityAlgorithmsRequestListValue]] = None,
      phase1DHGroupNumbers: Option[List[Phase1DHGroupNumbersRequestListValue]] = None,
      phase2DHGroupNumbers: Option[List[Phase2DHGroupNumbersRequestListValue]] = None,
      iKEVersions: Option[List[IKEVersionsRequestListValue]] = None,
      startupAction: Option[String] = None
    ): VpnTunnelOptionsSpecification =
      VpnTunnelOptionsSpecification
        .builder
        .ifSome(tunnelInsideCidr)(_.tunnelInsideCidr(_))
        .ifSome(tunnelInsideIpv6Cidr)(_.tunnelInsideIpv6Cidr(_))
        .ifSome(preSharedKey)(_.preSharedKey(_))
        .ifSome(phase1LifetimeSeconds)(_.phase1LifetimeSeconds(_))
        .ifSome(phase2LifetimeSeconds)(_.phase2LifetimeSeconds(_))
        .ifSome(rekeyMarginTimeSeconds)(_.rekeyMarginTimeSeconds(_))
        .ifSome(rekeyFuzzPercentage)(_.rekeyFuzzPercentage(_))
        .ifSome(replayWindowSize)(_.replayWindowSize(_))
        .ifSome(dPDTimeoutSeconds)(_.dPDTimeoutSeconds(_))
        .ifSome(dPDTimeoutAction)(_.dPDTimeoutAction(_))
        .ifSome(phase1EncryptionAlgorithms)(_.phase1EncryptionAlgorithms(_))
        .ifSome(phase2EncryptionAlgorithms)(_.phase2EncryptionAlgorithms(_))
        .ifSome(phase1IntegrityAlgorithms)(_.phase1IntegrityAlgorithms(_))
        .ifSome(phase2IntegrityAlgorithms)(_.phase2IntegrityAlgorithms(_))
        .ifSome(phase1DHGroupNumbers)(_.phase1DHGroupNumbers(_))
        .ifSome(phase2DHGroupNumbers)(_.phase2DHGroupNumbers(_))
        .ifSome(iKEVersions)(_.iKEVersions(_))
        .ifSome(startupAction)(_.startupAction(_))
        .build

    def withdrawByoipCidrRequest(
      cidr: Option[String] = None
    ): WithdrawByoipCidrRequest =
      WithdrawByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
