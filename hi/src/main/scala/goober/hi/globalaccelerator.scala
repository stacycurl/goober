package goober.hi

import goober.free.globalaccelerator.GlobalAcceleratorIO
import software.amazon.awssdk.services.globalaccelerator.model._


object globalaccelerator {
  import goober.free.{globalaccelerator ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AddCustomRoutingEndpointsRequest
    // AdvertiseByoipCidrRequest
    // AllowCustomRoutingTrafficRequest
    // CreateAcceleratorRequest
    // CreateCustomRoutingAcceleratorRequest
    // CreateCustomRoutingEndpointGroupRequest
    // CreateCustomRoutingListenerRequest
    // CreateEndpointGroupRequest
    // CreateListenerRequest
    // DeleteAcceleratorRequest
    // DeleteCustomRoutingAcceleratorRequest
    // DeleteCustomRoutingEndpointGroupRequest
    // DeleteCustomRoutingListenerRequest
    // DeleteEndpointGroupRequest
    // DeleteListenerRequest
    // DenyCustomRoutingTrafficRequest
    // DeprovisionByoipCidrRequest
    // DescribeAcceleratorAttributesRequest
    // DescribeAcceleratorRequest
    // DescribeCustomRoutingAcceleratorAttributesRequest
    // DescribeCustomRoutingAcceleratorRequest
    // DescribeCustomRoutingEndpointGroupRequest
    // DescribeCustomRoutingListenerRequest
    // DescribeEndpointGroupRequest
    // DescribeListenerRequest
    // ListAcceleratorsRequest
    // ListByoipCidrsRequest
    // ListCustomRoutingAcceleratorsRequest
    // ListCustomRoutingEndpointGroupsRequest
    // ListCustomRoutingListenersRequest
    // ListCustomRoutingPortMappingsByDestinationRequest
    // ListCustomRoutingPortMappingsRequest
    // ListEndpointGroupsRequest
    // ListListenersRequest
    // ListTagsForResourceRequest
    // ProvisionByoipCidrRequest
    // RemoveCustomRoutingEndpointsRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UpdateAcceleratorAttributesRequest
    // UpdateAcceleratorRequest
    // UpdateCustomRoutingAcceleratorAttributesRequest
    // UpdateCustomRoutingAcceleratorRequest
    // UpdateCustomRoutingListenerRequest
    // UpdateEndpointGroupRequest
    // UpdateListenerRequest
    // WithdrawByoipCidrRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
