package goober.hi

import goober.free.elasticloadbalancing.ElasticLoadBalancingIO
import software.amazon.awssdk.services.elasticloadbalancing.model._


object elasticloadbalancing {
  import goober.free.{elasticloadbalancing ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AddTagsRequest
    // ApplySecurityGroupsToLoadBalancerRequest
    // AttachLoadBalancerToSubnetsRequest
    // ConfigureHealthCheckRequest
    // CreateAppCookieStickinessPolicyRequest
    // CreateLbCookieStickinessPolicyRequest
    // CreateLoadBalancerListenersRequest
    // CreateLoadBalancerPolicyRequest
    // CreateLoadBalancerRequest
    // DeleteLoadBalancerListenersRequest
    // DeleteLoadBalancerPolicyRequest
    // DeleteLoadBalancerRequest
    // DeregisterInstancesFromLoadBalancerRequest
    // DescribeAccountLimitsRequest
    // DescribeInstanceHealthRequest
    // DescribeLoadBalancerAttributesRequest
    // DescribeLoadBalancerPoliciesRequest
    // DescribeLoadBalancerPolicyTypesRequest
    // DescribeLoadBalancersRequest
    // DescribeTagsRequest
    // DetachLoadBalancerFromSubnetsRequest
    // DisableAvailabilityZonesForLoadBalancerRequest
    // EnableAvailabilityZonesForLoadBalancerRequest
    // ModifyLoadBalancerAttributesRequest
    // RegisterInstancesWithLoadBalancerRequest
    // RemoveTagsRequest
    // SetLoadBalancerListenerSslCertificateRequest
    // SetLoadBalancerPoliciesForBackendServerRequest
    // SetLoadBalancerPoliciesOfListenerRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
