package goober.hi

import goober.free.globalaccelerator.GlobalAcceleratorIO
import software.amazon.awssdk.services.globalaccelerator.model._


object globalaccelerator {
  import goober.free.{globalaccelerator ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accelerator(
      acceleratorArn: Option[String] = None,
      name: Option[String] = None,
      ipAddressType: Option[String] = None,
      enabled: Option[Boolean] = None,
      ipSets: Option[List[IpSet]] = None,
      dnsName: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): Accelerator =
      Accelerator
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(ipSets)(_.ipSets(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def acceleratorAttributes(
      flowLogsEnabled: Option[Boolean] = None,
      flowLogsS3Bucket: Option[String] = None,
      flowLogsS3Prefix: Option[String] = None
    ): AcceleratorAttributes =
      AcceleratorAttributes
        .builder
        .ifSome(flowLogsEnabled)(_.flowLogsEnabled(_))
        .ifSome(flowLogsS3Bucket)(_.flowLogsS3Bucket(_))
        .ifSome(flowLogsS3Prefix)(_.flowLogsS3Prefix(_))
        .build

    def acceleratorNotDisabledException(
      message: Option[String] = None
    ): AcceleratorNotDisabledException =
      AcceleratorNotDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def acceleratorNotFoundException(
      message: Option[String] = None
    ): AcceleratorNotFoundException =
      AcceleratorNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def addCustomRoutingEndpointsRequest(
      endpointConfigurations: Option[List[CustomRoutingEndpointConfiguration]] = None,
      endpointGroupArn: Option[String] = None
    ): AddCustomRoutingEndpointsRequest =
      AddCustomRoutingEndpointsRequest
        .builder
        .ifSome(endpointConfigurations)(_.endpointConfigurations(_))
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .build

    def addCustomRoutingEndpointsResponse(
      endpointDescriptions: Option[List[CustomRoutingEndpointDescription]] = None,
      endpointGroupArn: Option[String] = None
    ): AddCustomRoutingEndpointsResponse =
      AddCustomRoutingEndpointsResponse
        .builder
        .ifSome(endpointDescriptions)(_.endpointDescriptions(_))
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .build

    def advertiseByoipCidrRequest(
      cidr: Option[String] = None
    ): AdvertiseByoipCidrRequest =
      AdvertiseByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def advertiseByoipCidrResponse(
      byoipCidr: Option[ByoipCidr] = None
    ): AdvertiseByoipCidrResponse =
      AdvertiseByoipCidrResponse
        .builder
        .ifSome(byoipCidr)(_.byoipCidr(_))
        .build

    def allowCustomRoutingTrafficRequest(
      endpointGroupArn: Option[String] = None,
      endpointId: Option[String] = None,
      destinationAddresses: Option[List[IpAddress]] = None,
      destinationPorts: Option[List[PortNumber]] = None,
      allowAllTrafficToEndpoint: Option[Boolean] = None
    ): AllowCustomRoutingTrafficRequest =
      AllowCustomRoutingTrafficRequest
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(destinationAddresses)(_.destinationAddresses(_))
        .ifSome(destinationPorts)(_.destinationPorts(_))
        .ifSome(allowAllTrafficToEndpoint)(_.allowAllTrafficToEndpoint(_))
        .build

    def associatedEndpointGroupFoundException(
      message: Option[String] = None
    ): AssociatedEndpointGroupFoundException =
      AssociatedEndpointGroupFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associatedListenerFoundException(
      message: Option[String] = None
    ): AssociatedListenerFoundException =
      AssociatedListenerFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def byoipCidr(
      cidr: Option[String] = None,
      state: Option[String] = None,
      events: Option[List[ByoipCidrEvent]] = None
    ): ByoipCidr =
      ByoipCidr
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(state)(_.state(_))
        .ifSome(events)(_.events(_))
        .build

    def byoipCidrEvent(
      message: Option[String] = None,
      timestamp: Option[Timestamp] = None
    ): ByoipCidrEvent =
      ByoipCidrEvent
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def byoipCidrNotFoundException(
      message: Option[String] = None
    ): ByoipCidrNotFoundException =
      ByoipCidrNotFoundException
        .builder
        .ifSome(message)(_.message(_))
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

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createAcceleratorRequest(
      name: Option[String] = None,
      ipAddressType: Option[String] = None,
      ipAddresses: Option[List[IpAddress]] = None,
      enabled: Option[Boolean] = None,
      idempotencyToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAcceleratorRequest =
      CreateAcceleratorRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(ipAddresses)(_.ipAddresses(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAcceleratorResponse(
      accelerator: Option[Accelerator] = None
    ): CreateAcceleratorResponse =
      CreateAcceleratorResponse
        .builder
        .ifSome(accelerator)(_.accelerator(_))
        .build

    def createCustomRoutingAcceleratorRequest(
      name: Option[String] = None,
      ipAddressType: Option[String] = None,
      ipAddresses: Option[List[IpAddress]] = None,
      enabled: Option[Boolean] = None,
      idempotencyToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateCustomRoutingAcceleratorRequest =
      CreateCustomRoutingAcceleratorRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(ipAddresses)(_.ipAddresses(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCustomRoutingAcceleratorResponse(
      accelerator: Option[CustomRoutingAccelerator] = None
    ): CreateCustomRoutingAcceleratorResponse =
      CreateCustomRoutingAcceleratorResponse
        .builder
        .ifSome(accelerator)(_.accelerator(_))
        .build

    def createCustomRoutingEndpointGroupRequest(
      listenerArn: Option[String] = None,
      endpointGroupRegion: Option[String] = None,
      destinationConfigurations: Option[List[CustomRoutingDestinationConfiguration]] = None,
      idempotencyToken: Option[String] = None
    ): CreateCustomRoutingEndpointGroupRequest =
      CreateCustomRoutingEndpointGroupRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(endpointGroupRegion)(_.endpointGroupRegion(_))
        .ifSome(destinationConfigurations)(_.destinationConfigurations(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createCustomRoutingEndpointGroupResponse(
      endpointGroup: Option[CustomRoutingEndpointGroup] = None
    ): CreateCustomRoutingEndpointGroupResponse =
      CreateCustomRoutingEndpointGroupResponse
        .builder
        .ifSome(endpointGroup)(_.endpointGroup(_))
        .build

    def createCustomRoutingListenerRequest(
      acceleratorArn: Option[String] = None,
      portRanges: Option[List[PortRange]] = None,
      idempotencyToken: Option[String] = None
    ): CreateCustomRoutingListenerRequest =
      CreateCustomRoutingListenerRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(portRanges)(_.portRanges(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createCustomRoutingListenerResponse(
      listener: Option[CustomRoutingListener] = None
    ): CreateCustomRoutingListenerResponse =
      CreateCustomRoutingListenerResponse
        .builder
        .ifSome(listener)(_.listener(_))
        .build

    def createEndpointGroupRequest(
      listenerArn: Option[String] = None,
      endpointGroupRegion: Option[String] = None,
      endpointConfigurations: Option[List[EndpointConfiguration]] = None,
      trafficDialPercentage: Option[TrafficDialPercentage] = None,
      healthCheckPort: Option[Int] = None,
      healthCheckProtocol: Option[String] = None,
      healthCheckPath: Option[String] = None,
      healthCheckIntervalSeconds: Option[Int] = None,
      thresholdCount: Option[Int] = None,
      idempotencyToken: Option[String] = None,
      portOverrides: Option[List[PortOverride]] = None
    ): CreateEndpointGroupRequest =
      CreateEndpointGroupRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(endpointGroupRegion)(_.endpointGroupRegion(_))
        .ifSome(endpointConfigurations)(_.endpointConfigurations(_))
        .ifSome(trafficDialPercentage)(_.trafficDialPercentage(_))
        .ifSome(healthCheckPort)(_.healthCheckPort(_))
        .ifSome(healthCheckProtocol)(_.healthCheckProtocol(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(healthCheckIntervalSeconds)(_.healthCheckIntervalSeconds(_))
        .ifSome(thresholdCount)(_.thresholdCount(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(portOverrides)(_.portOverrides(_))
        .build

    def createEndpointGroupResponse(
      endpointGroup: Option[EndpointGroup] = None
    ): CreateEndpointGroupResponse =
      CreateEndpointGroupResponse
        .builder
        .ifSome(endpointGroup)(_.endpointGroup(_))
        .build

    def createListenerRequest(
      acceleratorArn: Option[String] = None,
      portRanges: Option[List[PortRange]] = None,
      protocol: Option[String] = None,
      clientAffinity: Option[String] = None,
      idempotencyToken: Option[String] = None
    ): CreateListenerRequest =
      CreateListenerRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(portRanges)(_.portRanges(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(clientAffinity)(_.clientAffinity(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createListenerResponse(
      listener: Option[Listener] = None
    ): CreateListenerResponse =
      CreateListenerResponse
        .builder
        .ifSome(listener)(_.listener(_))
        .build

    def customRoutingAccelerator(
      acceleratorArn: Option[String] = None,
      name: Option[String] = None,
      ipAddressType: Option[String] = None,
      enabled: Option[Boolean] = None,
      ipSets: Option[List[IpSet]] = None,
      dnsName: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): CustomRoutingAccelerator =
      CustomRoutingAccelerator
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(ipSets)(_.ipSets(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def customRoutingAcceleratorAttributes(
      flowLogsEnabled: Option[Boolean] = None,
      flowLogsS3Bucket: Option[String] = None,
      flowLogsS3Prefix: Option[String] = None
    ): CustomRoutingAcceleratorAttributes =
      CustomRoutingAcceleratorAttributes
        .builder
        .ifSome(flowLogsEnabled)(_.flowLogsEnabled(_))
        .ifSome(flowLogsS3Bucket)(_.flowLogsS3Bucket(_))
        .ifSome(flowLogsS3Prefix)(_.flowLogsS3Prefix(_))
        .build

    def customRoutingDestinationConfiguration(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None,
      protocols: Option[List[CustomRoutingProtocol]] = None
    ): CustomRoutingDestinationConfiguration =
      CustomRoutingDestinationConfiguration
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(protocols)(_.protocols(_))
        .build

    def customRoutingDestinationDescription(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None,
      protocols: Option[List[Protocol]] = None
    ): CustomRoutingDestinationDescription =
      CustomRoutingDestinationDescription
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(protocols)(_.protocols(_))
        .build

    def customRoutingEndpointConfiguration(
      endpointId: Option[String] = None
    ): CustomRoutingEndpointConfiguration =
      CustomRoutingEndpointConfiguration
        .builder
        .ifSome(endpointId)(_.endpointId(_))
        .build

    def customRoutingEndpointDescription(
      endpointId: Option[String] = None
    ): CustomRoutingEndpointDescription =
      CustomRoutingEndpointDescription
        .builder
        .ifSome(endpointId)(_.endpointId(_))
        .build

    def customRoutingEndpointGroup(
      endpointGroupArn: Option[String] = None,
      endpointGroupRegion: Option[String] = None,
      destinationDescriptions: Option[List[CustomRoutingDestinationDescription]] = None,
      endpointDescriptions: Option[List[CustomRoutingEndpointDescription]] = None
    ): CustomRoutingEndpointGroup =
      CustomRoutingEndpointGroup
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(endpointGroupRegion)(_.endpointGroupRegion(_))
        .ifSome(destinationDescriptions)(_.destinationDescriptions(_))
        .ifSome(endpointDescriptions)(_.endpointDescriptions(_))
        .build

    def customRoutingListener(
      listenerArn: Option[String] = None,
      portRanges: Option[List[PortRange]] = None
    ): CustomRoutingListener =
      CustomRoutingListener
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(portRanges)(_.portRanges(_))
        .build

    def deleteAcceleratorRequest(
      acceleratorArn: Option[String] = None
    ): DeleteAcceleratorRequest =
      DeleteAcceleratorRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .build

    def deleteCustomRoutingAcceleratorRequest(
      acceleratorArn: Option[String] = None
    ): DeleteCustomRoutingAcceleratorRequest =
      DeleteCustomRoutingAcceleratorRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .build

    def deleteCustomRoutingEndpointGroupRequest(
      endpointGroupArn: Option[String] = None
    ): DeleteCustomRoutingEndpointGroupRequest =
      DeleteCustomRoutingEndpointGroupRequest
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .build

    def deleteCustomRoutingListenerRequest(
      listenerArn: Option[String] = None
    ): DeleteCustomRoutingListenerRequest =
      DeleteCustomRoutingListenerRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .build

    def deleteEndpointGroupRequest(
      endpointGroupArn: Option[String] = None
    ): DeleteEndpointGroupRequest =
      DeleteEndpointGroupRequest
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .build

    def deleteListenerRequest(
      listenerArn: Option[String] = None
    ): DeleteListenerRequest =
      DeleteListenerRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .build

    def denyCustomRoutingTrafficRequest(
      endpointGroupArn: Option[String] = None,
      endpointId: Option[String] = None,
      destinationAddresses: Option[List[IpAddress]] = None,
      destinationPorts: Option[List[PortNumber]] = None,
      denyAllTrafficToEndpoint: Option[Boolean] = None
    ): DenyCustomRoutingTrafficRequest =
      DenyCustomRoutingTrafficRequest
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(destinationAddresses)(_.destinationAddresses(_))
        .ifSome(destinationPorts)(_.destinationPorts(_))
        .ifSome(denyAllTrafficToEndpoint)(_.denyAllTrafficToEndpoint(_))
        .build

    def deprovisionByoipCidrRequest(
      cidr: Option[String] = None
    ): DeprovisionByoipCidrRequest =
      DeprovisionByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def deprovisionByoipCidrResponse(
      byoipCidr: Option[ByoipCidr] = None
    ): DeprovisionByoipCidrResponse =
      DeprovisionByoipCidrResponse
        .builder
        .ifSome(byoipCidr)(_.byoipCidr(_))
        .build

    def describeAcceleratorAttributesRequest(
      acceleratorArn: Option[String] = None
    ): DescribeAcceleratorAttributesRequest =
      DescribeAcceleratorAttributesRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .build

    def describeAcceleratorAttributesResponse(
      acceleratorAttributes: Option[AcceleratorAttributes] = None
    ): DescribeAcceleratorAttributesResponse =
      DescribeAcceleratorAttributesResponse
        .builder
        .ifSome(acceleratorAttributes)(_.acceleratorAttributes(_))
        .build

    def describeAcceleratorRequest(
      acceleratorArn: Option[String] = None
    ): DescribeAcceleratorRequest =
      DescribeAcceleratorRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .build

    def describeAcceleratorResponse(
      accelerator: Option[Accelerator] = None
    ): DescribeAcceleratorResponse =
      DescribeAcceleratorResponse
        .builder
        .ifSome(accelerator)(_.accelerator(_))
        .build

    def describeCustomRoutingAcceleratorAttributesRequest(
      acceleratorArn: Option[String] = None
    ): DescribeCustomRoutingAcceleratorAttributesRequest =
      DescribeCustomRoutingAcceleratorAttributesRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .build

    def describeCustomRoutingAcceleratorAttributesResponse(
      acceleratorAttributes: Option[CustomRoutingAcceleratorAttributes] = None
    ): DescribeCustomRoutingAcceleratorAttributesResponse =
      DescribeCustomRoutingAcceleratorAttributesResponse
        .builder
        .ifSome(acceleratorAttributes)(_.acceleratorAttributes(_))
        .build

    def describeCustomRoutingAcceleratorRequest(
      acceleratorArn: Option[String] = None
    ): DescribeCustomRoutingAcceleratorRequest =
      DescribeCustomRoutingAcceleratorRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .build

    def describeCustomRoutingAcceleratorResponse(
      accelerator: Option[CustomRoutingAccelerator] = None
    ): DescribeCustomRoutingAcceleratorResponse =
      DescribeCustomRoutingAcceleratorResponse
        .builder
        .ifSome(accelerator)(_.accelerator(_))
        .build

    def describeCustomRoutingEndpointGroupRequest(
      endpointGroupArn: Option[String] = None
    ): DescribeCustomRoutingEndpointGroupRequest =
      DescribeCustomRoutingEndpointGroupRequest
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .build

    def describeCustomRoutingEndpointGroupResponse(
      endpointGroup: Option[CustomRoutingEndpointGroup] = None
    ): DescribeCustomRoutingEndpointGroupResponse =
      DescribeCustomRoutingEndpointGroupResponse
        .builder
        .ifSome(endpointGroup)(_.endpointGroup(_))
        .build

    def describeCustomRoutingListenerRequest(
      listenerArn: Option[String] = None
    ): DescribeCustomRoutingListenerRequest =
      DescribeCustomRoutingListenerRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .build

    def describeCustomRoutingListenerResponse(
      listener: Option[CustomRoutingListener] = None
    ): DescribeCustomRoutingListenerResponse =
      DescribeCustomRoutingListenerResponse
        .builder
        .ifSome(listener)(_.listener(_))
        .build

    def describeEndpointGroupRequest(
      endpointGroupArn: Option[String] = None
    ): DescribeEndpointGroupRequest =
      DescribeEndpointGroupRequest
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .build

    def describeEndpointGroupResponse(
      endpointGroup: Option[EndpointGroup] = None
    ): DescribeEndpointGroupResponse =
      DescribeEndpointGroupResponse
        .builder
        .ifSome(endpointGroup)(_.endpointGroup(_))
        .build

    def describeListenerRequest(
      listenerArn: Option[String] = None
    ): DescribeListenerRequest =
      DescribeListenerRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .build

    def describeListenerResponse(
      listener: Option[Listener] = None
    ): DescribeListenerResponse =
      DescribeListenerResponse
        .builder
        .ifSome(listener)(_.listener(_))
        .build

    def destinationPortMapping(
      acceleratorArn: Option[String] = None,
      acceleratorSocketAddresses: Option[List[SocketAddress]] = None,
      endpointGroupArn: Option[String] = None,
      endpointId: Option[String] = None,
      endpointGroupRegion: Option[String] = None,
      destinationSocketAddress: Option[SocketAddress] = None,
      ipAddressType: Option[String] = None,
      destinationTrafficState: Option[String] = None
    ): DestinationPortMapping =
      DestinationPortMapping
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(acceleratorSocketAddresses)(_.acceleratorSocketAddresses(_))
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(endpointGroupRegion)(_.endpointGroupRegion(_))
        .ifSome(destinationSocketAddress)(_.destinationSocketAddress(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(destinationTrafficState)(_.destinationTrafficState(_))
        .build

    def endpointAlreadyExistsException(
      message: Option[String] = None
    ): EndpointAlreadyExistsException =
      EndpointAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def endpointConfiguration(
      endpointId: Option[String] = None,
      weight: Option[Int] = None,
      clientIPPreservationEnabled: Option[Boolean] = None
    ): EndpointConfiguration =
      EndpointConfiguration
        .builder
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(weight)(_.weight(_))
        .ifSome(clientIPPreservationEnabled)(_.clientIPPreservationEnabled(_))
        .build

    def endpointDescription(
      endpointId: Option[String] = None,
      weight: Option[Int] = None,
      healthState: Option[String] = None,
      healthReason: Option[String] = None,
      clientIPPreservationEnabled: Option[Boolean] = None
    ): EndpointDescription =
      EndpointDescription
        .builder
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(weight)(_.weight(_))
        .ifSome(healthState)(_.healthState(_))
        .ifSome(healthReason)(_.healthReason(_))
        .ifSome(clientIPPreservationEnabled)(_.clientIPPreservationEnabled(_))
        .build

    def endpointGroup(
      endpointGroupArn: Option[String] = None,
      endpointGroupRegion: Option[String] = None,
      endpointDescriptions: Option[List[EndpointDescription]] = None,
      trafficDialPercentage: Option[TrafficDialPercentage] = None,
      healthCheckPort: Option[Int] = None,
      healthCheckProtocol: Option[String] = None,
      healthCheckPath: Option[String] = None,
      healthCheckIntervalSeconds: Option[Int] = None,
      thresholdCount: Option[Int] = None,
      portOverrides: Option[List[PortOverride]] = None
    ): EndpointGroup =
      EndpointGroup
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(endpointGroupRegion)(_.endpointGroupRegion(_))
        .ifSome(endpointDescriptions)(_.endpointDescriptions(_))
        .ifSome(trafficDialPercentage)(_.trafficDialPercentage(_))
        .ifSome(healthCheckPort)(_.healthCheckPort(_))
        .ifSome(healthCheckProtocol)(_.healthCheckProtocol(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(healthCheckIntervalSeconds)(_.healthCheckIntervalSeconds(_))
        .ifSome(thresholdCount)(_.thresholdCount(_))
        .ifSome(portOverrides)(_.portOverrides(_))
        .build

    def endpointGroupAlreadyExistsException(
      message: Option[String] = None
    ): EndpointGroupAlreadyExistsException =
      EndpointGroupAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def endpointGroupNotFoundException(
      message: Option[String] = None
    ): EndpointGroupNotFoundException =
      EndpointGroupNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def endpointNotFoundException(
      message: Option[String] = None
    ): EndpointNotFoundException =
      EndpointNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def incorrectCidrStateException(
      message: Option[String] = None
    ): IncorrectCidrStateException =
      IncorrectCidrStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServiceErrorException(
      message: Option[String] = None
    ): InternalServiceErrorException =
      InternalServiceErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPortRangeException(
      message: Option[String] = None
    ): InvalidPortRangeException =
      InvalidPortRangeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ipSet(
      ipFamily: Option[String] = None,
      ipAddresses: Option[List[IpAddress]] = None
    ): IpSet =
      IpSet
        .builder
        .ifSome(ipFamily)(_.ipFamily(_))
        .ifSome(ipAddresses)(_.ipAddresses(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAcceleratorsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAcceleratorsRequest =
      ListAcceleratorsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAcceleratorsResponse(
      accelerators: Option[List[Accelerator]] = None,
      nextToken: Option[String] = None
    ): ListAcceleratorsResponse =
      ListAcceleratorsResponse
        .builder
        .ifSome(accelerators)(_.accelerators(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listByoipCidrsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListByoipCidrsRequest =
      ListByoipCidrsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listByoipCidrsResponse(
      byoipCidrs: Option[List[ByoipCidr]] = None,
      nextToken: Option[String] = None
    ): ListByoipCidrsResponse =
      ListByoipCidrsResponse
        .builder
        .ifSome(byoipCidrs)(_.byoipCidrs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingAcceleratorsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingAcceleratorsRequest =
      ListCustomRoutingAcceleratorsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingAcceleratorsResponse(
      accelerators: Option[List[CustomRoutingAccelerator]] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingAcceleratorsResponse =
      ListCustomRoutingAcceleratorsResponse
        .builder
        .ifSome(accelerators)(_.accelerators(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingEndpointGroupsRequest(
      listenerArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingEndpointGroupsRequest =
      ListCustomRoutingEndpointGroupsRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingEndpointGroupsResponse(
      endpointGroups: Option[List[CustomRoutingEndpointGroup]] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingEndpointGroupsResponse =
      ListCustomRoutingEndpointGroupsResponse
        .builder
        .ifSome(endpointGroups)(_.endpointGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingListenersRequest(
      acceleratorArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingListenersRequest =
      ListCustomRoutingListenersRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingListenersResponse(
      listeners: Option[List[CustomRoutingListener]] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingListenersResponse =
      ListCustomRoutingListenersResponse
        .builder
        .ifSome(listeners)(_.listeners(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingPortMappingsByDestinationRequest(
      endpointId: Option[String] = None,
      destinationAddress: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingPortMappingsByDestinationRequest =
      ListCustomRoutingPortMappingsByDestinationRequest
        .builder
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(destinationAddress)(_.destinationAddress(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingPortMappingsByDestinationResponse(
      destinationPortMappings: Option[List[DestinationPortMapping]] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingPortMappingsByDestinationResponse =
      ListCustomRoutingPortMappingsByDestinationResponse
        .builder
        .ifSome(destinationPortMappings)(_.destinationPortMappings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingPortMappingsRequest(
      acceleratorArn: Option[String] = None,
      endpointGroupArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingPortMappingsRequest =
      ListCustomRoutingPortMappingsRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomRoutingPortMappingsResponse(
      portMappings: Option[List[PortMapping]] = None,
      nextToken: Option[String] = None
    ): ListCustomRoutingPortMappingsResponse =
      ListCustomRoutingPortMappingsResponse
        .builder
        .ifSome(portMappings)(_.portMappings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEndpointGroupsRequest(
      listenerArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEndpointGroupsRequest =
      ListEndpointGroupsRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEndpointGroupsResponse(
      endpointGroups: Option[List[EndpointGroup]] = None,
      nextToken: Option[String] = None
    ): ListEndpointGroupsResponse =
      ListEndpointGroupsResponse
        .builder
        .ifSome(endpointGroups)(_.endpointGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listListenersRequest(
      acceleratorArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListListenersRequest =
      ListListenersRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listListenersResponse(
      listeners: Option[List[Listener]] = None,
      nextToken: Option[String] = None
    ): ListListenersResponse =
      ListListenersResponse
        .builder
        .ifSome(listeners)(_.listeners(_))
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
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listener(
      listenerArn: Option[String] = None,
      portRanges: Option[List[PortRange]] = None,
      protocol: Option[String] = None,
      clientAffinity: Option[String] = None
    ): Listener =
      Listener
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(portRanges)(_.portRanges(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(clientAffinity)(_.clientAffinity(_))
        .build

    def listenerNotFoundException(
      message: Option[String] = None
    ): ListenerNotFoundException =
      ListenerNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def portMapping(
      acceleratorPort: Option[Int] = None,
      endpointGroupArn: Option[String] = None,
      endpointId: Option[String] = None,
      destinationSocketAddress: Option[SocketAddress] = None,
      protocols: Option[List[CustomRoutingProtocol]] = None,
      destinationTrafficState: Option[String] = None
    ): PortMapping =
      PortMapping
        .builder
        .ifSome(acceleratorPort)(_.acceleratorPort(_))
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(destinationSocketAddress)(_.destinationSocketAddress(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(destinationTrafficState)(_.destinationTrafficState(_))
        .build

    def portOverride(
      listenerPort: Option[Int] = None,
      endpointPort: Option[Int] = None
    ): PortOverride =
      PortOverride
        .builder
        .ifSome(listenerPort)(_.listenerPort(_))
        .ifSome(endpointPort)(_.endpointPort(_))
        .build

    def portRange(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None
    ): PortRange =
      PortRange
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .build

    def provisionByoipCidrRequest(
      cidr: Option[String] = None,
      cidrAuthorizationContext: Option[CidrAuthorizationContext] = None
    ): ProvisionByoipCidrRequest =
      ProvisionByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .ifSome(cidrAuthorizationContext)(_.cidrAuthorizationContext(_))
        .build

    def provisionByoipCidrResponse(
      byoipCidr: Option[ByoipCidr] = None
    ): ProvisionByoipCidrResponse =
      ProvisionByoipCidrResponse
        .builder
        .ifSome(byoipCidr)(_.byoipCidr(_))
        .build

    def removeCustomRoutingEndpointsRequest(
      endpointIds: Option[List[GenericString]] = None,
      endpointGroupArn: Option[String] = None
    ): RemoveCustomRoutingEndpointsRequest =
      RemoveCustomRoutingEndpointsRequest
        .builder
        .ifSome(endpointIds)(_.endpointIds(_))
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .build

    def socketAddress(
      ipAddress: Option[String] = None,
      port: Option[Int] = None
    ): SocketAddress =
      SocketAddress
        .builder
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(port)(_.port(_))
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

    def updateAcceleratorAttributesRequest(
      acceleratorArn: Option[String] = None,
      flowLogsEnabled: Option[Boolean] = None,
      flowLogsS3Bucket: Option[String] = None,
      flowLogsS3Prefix: Option[String] = None
    ): UpdateAcceleratorAttributesRequest =
      UpdateAcceleratorAttributesRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(flowLogsEnabled)(_.flowLogsEnabled(_))
        .ifSome(flowLogsS3Bucket)(_.flowLogsS3Bucket(_))
        .ifSome(flowLogsS3Prefix)(_.flowLogsS3Prefix(_))
        .build

    def updateAcceleratorAttributesResponse(
      acceleratorAttributes: Option[AcceleratorAttributes] = None
    ): UpdateAcceleratorAttributesResponse =
      UpdateAcceleratorAttributesResponse
        .builder
        .ifSome(acceleratorAttributes)(_.acceleratorAttributes(_))
        .build

    def updateAcceleratorRequest(
      acceleratorArn: Option[String] = None,
      name: Option[String] = None,
      ipAddressType: Option[String] = None,
      enabled: Option[Boolean] = None
    ): UpdateAcceleratorRequest =
      UpdateAcceleratorRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateAcceleratorResponse(
      accelerator: Option[Accelerator] = None
    ): UpdateAcceleratorResponse =
      UpdateAcceleratorResponse
        .builder
        .ifSome(accelerator)(_.accelerator(_))
        .build

    def updateCustomRoutingAcceleratorAttributesRequest(
      acceleratorArn: Option[String] = None,
      flowLogsEnabled: Option[Boolean] = None,
      flowLogsS3Bucket: Option[String] = None,
      flowLogsS3Prefix: Option[String] = None
    ): UpdateCustomRoutingAcceleratorAttributesRequest =
      UpdateCustomRoutingAcceleratorAttributesRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(flowLogsEnabled)(_.flowLogsEnabled(_))
        .ifSome(flowLogsS3Bucket)(_.flowLogsS3Bucket(_))
        .ifSome(flowLogsS3Prefix)(_.flowLogsS3Prefix(_))
        .build

    def updateCustomRoutingAcceleratorAttributesResponse(
      acceleratorAttributes: Option[CustomRoutingAcceleratorAttributes] = None
    ): UpdateCustomRoutingAcceleratorAttributesResponse =
      UpdateCustomRoutingAcceleratorAttributesResponse
        .builder
        .ifSome(acceleratorAttributes)(_.acceleratorAttributes(_))
        .build

    def updateCustomRoutingAcceleratorRequest(
      acceleratorArn: Option[String] = None,
      name: Option[String] = None,
      ipAddressType: Option[String] = None,
      enabled: Option[Boolean] = None
    ): UpdateCustomRoutingAcceleratorRequest =
      UpdateCustomRoutingAcceleratorRequest
        .builder
        .ifSome(acceleratorArn)(_.acceleratorArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateCustomRoutingAcceleratorResponse(
      accelerator: Option[CustomRoutingAccelerator] = None
    ): UpdateCustomRoutingAcceleratorResponse =
      UpdateCustomRoutingAcceleratorResponse
        .builder
        .ifSome(accelerator)(_.accelerator(_))
        .build

    def updateCustomRoutingListenerRequest(
      listenerArn: Option[String] = None,
      portRanges: Option[List[PortRange]] = None
    ): UpdateCustomRoutingListenerRequest =
      UpdateCustomRoutingListenerRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(portRanges)(_.portRanges(_))
        .build

    def updateCustomRoutingListenerResponse(
      listener: Option[CustomRoutingListener] = None
    ): UpdateCustomRoutingListenerResponse =
      UpdateCustomRoutingListenerResponse
        .builder
        .ifSome(listener)(_.listener(_))
        .build

    def updateEndpointGroupRequest(
      endpointGroupArn: Option[String] = None,
      endpointConfigurations: Option[List[EndpointConfiguration]] = None,
      trafficDialPercentage: Option[TrafficDialPercentage] = None,
      healthCheckPort: Option[Int] = None,
      healthCheckProtocol: Option[String] = None,
      healthCheckPath: Option[String] = None,
      healthCheckIntervalSeconds: Option[Int] = None,
      thresholdCount: Option[Int] = None,
      portOverrides: Option[List[PortOverride]] = None
    ): UpdateEndpointGroupRequest =
      UpdateEndpointGroupRequest
        .builder
        .ifSome(endpointGroupArn)(_.endpointGroupArn(_))
        .ifSome(endpointConfigurations)(_.endpointConfigurations(_))
        .ifSome(trafficDialPercentage)(_.trafficDialPercentage(_))
        .ifSome(healthCheckPort)(_.healthCheckPort(_))
        .ifSome(healthCheckProtocol)(_.healthCheckProtocol(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(healthCheckIntervalSeconds)(_.healthCheckIntervalSeconds(_))
        .ifSome(thresholdCount)(_.thresholdCount(_))
        .ifSome(portOverrides)(_.portOverrides(_))
        .build

    def updateEndpointGroupResponse(
      endpointGroup: Option[EndpointGroup] = None
    ): UpdateEndpointGroupResponse =
      UpdateEndpointGroupResponse
        .builder
        .ifSome(endpointGroup)(_.endpointGroup(_))
        .build

    def updateListenerRequest(
      listenerArn: Option[String] = None,
      portRanges: Option[List[PortRange]] = None,
      protocol: Option[String] = None,
      clientAffinity: Option[String] = None
    ): UpdateListenerRequest =
      UpdateListenerRequest
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(portRanges)(_.portRanges(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(clientAffinity)(_.clientAffinity(_))
        .build

    def updateListenerResponse(
      listener: Option[Listener] = None
    ): UpdateListenerResponse =
      UpdateListenerResponse
        .builder
        .ifSome(listener)(_.listener(_))
        .build

    def withdrawByoipCidrRequest(
      cidr: Option[String] = None
    ): WithdrawByoipCidrRequest =
      WithdrawByoipCidrRequest
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def withdrawByoipCidrResponse(
      byoipCidr: Option[ByoipCidr] = None
    ): WithdrawByoipCidrResponse =
      WithdrawByoipCidrResponse
        .builder
        .ifSome(byoipCidr)(_.byoipCidr(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
