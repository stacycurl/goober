package goober.hi

import goober.free.elasticloadbalancing.ElasticLoadBalancingIO
import software.amazon.awssdk.services.elasticloadbalancing.model._


object elasticloadbalancing {
  import goober.free.{elasticloadbalancing ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessLog(
      enabled: Option[Boolean] = None,
      s3BucketName: Option[String] = None,
      emitInterval: Option[Int] = None,
      s3BucketPrefix: Option[String] = None
    ): AccessLog =
      AccessLog
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(emitInterval)(_.emitInterval(_))
        .ifSome(s3BucketPrefix)(_.s3BucketPrefix(_))
        .build

    def accessPointNotFoundException(

    ): AccessPointNotFoundException =
      AccessPointNotFoundException
        .builder

        .build

    def addAvailabilityZonesInput(
      loadBalancerName: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None
    ): AddAvailabilityZonesInput =
      AddAvailabilityZonesInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def addAvailabilityZonesOutput(
      availabilityZones: Option[List[AvailabilityZone]] = None
    ): AddAvailabilityZonesOutput =
      AddAvailabilityZonesOutput
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def addTagsInput(
      loadBalancerNames: Option[List[AccessPointName]] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsInput =
      AddTagsInput
        .builder
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsOutput(

    ): AddTagsOutput =
      AddTagsOutput
        .builder

        .build

    def additionalAttribute(
      key: Option[String] = None,
      value: Option[String] = None
    ): AdditionalAttribute =
      AdditionalAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def appCookieStickinessPolicy(
      policyName: Option[String] = None,
      cookieName: Option[String] = None
    ): AppCookieStickinessPolicy =
      AppCookieStickinessPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(cookieName)(_.cookieName(_))
        .build

    def applySecurityGroupsToLoadBalancerInput(
      loadBalancerName: Option[String] = None,
      securityGroups: Option[List[SecurityGroupId]] = None
    ): ApplySecurityGroupsToLoadBalancerInput =
      ApplySecurityGroupsToLoadBalancerInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def applySecurityGroupsToLoadBalancerOutput(
      securityGroups: Option[List[SecurityGroupId]] = None
    ): ApplySecurityGroupsToLoadBalancerOutput =
      ApplySecurityGroupsToLoadBalancerOutput
        .builder
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def attachLoadBalancerToSubnetsInput(
      loadBalancerName: Option[String] = None,
      subnets: Option[List[SubnetId]] = None
    ): AttachLoadBalancerToSubnetsInput =
      AttachLoadBalancerToSubnetsInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(subnets)(_.subnets(_))
        .build

    def attachLoadBalancerToSubnetsOutput(
      subnets: Option[List[SubnetId]] = None
    ): AttachLoadBalancerToSubnetsOutput =
      AttachLoadBalancerToSubnetsOutput
        .builder
        .ifSome(subnets)(_.subnets(_))
        .build

    def backendServerDescription(
      instancePort: Option[Int] = None,
      policyNames: Option[List[PolicyName]] = None
    ): BackendServerDescription =
      BackendServerDescription
        .builder
        .ifSome(instancePort)(_.instancePort(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def certificateNotFoundException(

    ): CertificateNotFoundException =
      CertificateNotFoundException
        .builder

        .build

    def configureHealthCheckInput(
      loadBalancerName: Option[String] = None,
      healthCheck: Option[HealthCheck] = None
    ): ConfigureHealthCheckInput =
      ConfigureHealthCheckInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .build

    def configureHealthCheckOutput(
      healthCheck: Option[HealthCheck] = None
    ): ConfigureHealthCheckOutput =
      ConfigureHealthCheckOutput
        .builder
        .ifSome(healthCheck)(_.healthCheck(_))
        .build

    def connectionDraining(
      enabled: Option[Boolean] = None,
      timeout: Option[Int] = None
    ): ConnectionDraining =
      ConnectionDraining
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def connectionSettings(
      idleTimeout: Option[Int] = None
    ): ConnectionSettings =
      ConnectionSettings
        .builder
        .ifSome(idleTimeout)(_.idleTimeout(_))
        .build

    def createAccessPointInput(
      loadBalancerName: Option[String] = None,
      listeners: Option[List[Listener]] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None,
      subnets: Option[List[SubnetId]] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      scheme: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAccessPointInput =
      CreateAccessPointInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(listeners)(_.listeners(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(scheme)(_.scheme(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAccessPointOutput(
      dNSName: Option[String] = None
    ): CreateAccessPointOutput =
      CreateAccessPointOutput
        .builder
        .ifSome(dNSName)(_.dNSName(_))
        .build

    def createAppCookieStickinessPolicyInput(
      loadBalancerName: Option[String] = None,
      policyName: Option[String] = None,
      cookieName: Option[String] = None
    ): CreateAppCookieStickinessPolicyInput =
      CreateAppCookieStickinessPolicyInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(cookieName)(_.cookieName(_))
        .build

    def createAppCookieStickinessPolicyOutput(

    ): CreateAppCookieStickinessPolicyOutput =
      CreateAppCookieStickinessPolicyOutput
        .builder

        .build

    def createLBCookieStickinessPolicyInput(
      loadBalancerName: Option[String] = None,
      policyName: Option[String] = None,
      cookieExpirationPeriod: Option[CookieExpirationPeriod] = None
    ): CreateLBCookieStickinessPolicyInput =
      CreateLBCookieStickinessPolicyInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(cookieExpirationPeriod)(_.cookieExpirationPeriod(_))
        .build

    def createLBCookieStickinessPolicyOutput(

    ): CreateLBCookieStickinessPolicyOutput =
      CreateLBCookieStickinessPolicyOutput
        .builder

        .build

    def createLoadBalancerListenerInput(
      loadBalancerName: Option[String] = None,
      listeners: Option[List[Listener]] = None
    ): CreateLoadBalancerListenerInput =
      CreateLoadBalancerListenerInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(listeners)(_.listeners(_))
        .build

    def createLoadBalancerListenerOutput(

    ): CreateLoadBalancerListenerOutput =
      CreateLoadBalancerListenerOutput
        .builder

        .build

    def createLoadBalancerPolicyInput(
      loadBalancerName: Option[String] = None,
      policyName: Option[String] = None,
      policyTypeName: Option[String] = None,
      policyAttributes: Option[List[PolicyAttribute]] = None
    ): CreateLoadBalancerPolicyInput =
      CreateLoadBalancerPolicyInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyTypeName)(_.policyTypeName(_))
        .ifSome(policyAttributes)(_.policyAttributes(_))
        .build

    def createLoadBalancerPolicyOutput(

    ): CreateLoadBalancerPolicyOutput =
      CreateLoadBalancerPolicyOutput
        .builder

        .build

    def crossZoneLoadBalancing(
      enabled: Option[Boolean] = None
    ): CrossZoneLoadBalancing =
      CrossZoneLoadBalancing
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def deleteAccessPointInput(
      loadBalancerName: Option[String] = None
    ): DeleteAccessPointInput =
      DeleteAccessPointInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .build

    def deleteAccessPointOutput(

    ): DeleteAccessPointOutput =
      DeleteAccessPointOutput
        .builder

        .build

    def deleteLoadBalancerListenerInput(
      loadBalancerName: Option[String] = None,
      loadBalancerPorts: Option[List[AccessPointPort]] = None
    ): DeleteLoadBalancerListenerInput =
      DeleteLoadBalancerListenerInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(loadBalancerPorts)(_.loadBalancerPorts(_))
        .build

    def deleteLoadBalancerListenerOutput(

    ): DeleteLoadBalancerListenerOutput =
      DeleteLoadBalancerListenerOutput
        .builder

        .build

    def deleteLoadBalancerPolicyInput(
      loadBalancerName: Option[String] = None,
      policyName: Option[String] = None
    ): DeleteLoadBalancerPolicyInput =
      DeleteLoadBalancerPolicyInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteLoadBalancerPolicyOutput(

    ): DeleteLoadBalancerPolicyOutput =
      DeleteLoadBalancerPolicyOutput
        .builder

        .build

    def dependencyThrottleException(

    ): DependencyThrottleException =
      DependencyThrottleException
        .builder

        .build

    def deregisterEndPointsInput(
      loadBalancerName: Option[String] = None,
      instances: Option[List[Instance]] = None
    ): DeregisterEndPointsInput =
      DeregisterEndPointsInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(instances)(_.instances(_))
        .build

    def deregisterEndPointsOutput(
      instances: Option[List[Instance]] = None
    ): DeregisterEndPointsOutput =
      DeregisterEndPointsOutput
        .builder
        .ifSome(instances)(_.instances(_))
        .build

    def describeAccessPointsInput(
      loadBalancerNames: Option[List[AccessPointName]] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeAccessPointsInput =
      DescribeAccessPointsInput
        .builder
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeAccessPointsOutput(
      loadBalancerDescriptions: Option[List[LoadBalancerDescription]] = None,
      nextMarker: Option[String] = None
    ): DescribeAccessPointsOutput =
      DescribeAccessPointsOutput
        .builder
        .ifSome(loadBalancerDescriptions)(_.loadBalancerDescriptions(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeAccountLimitsInput(
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeAccountLimitsInput =
      DescribeAccountLimitsInput
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeAccountLimitsOutput(
      limits: Option[List[Limit]] = None,
      nextMarker: Option[String] = None
    ): DescribeAccountLimitsOutput =
      DescribeAccountLimitsOutput
        .builder
        .ifSome(limits)(_.limits(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeEndPointStateInput(
      loadBalancerName: Option[String] = None,
      instances: Option[List[Instance]] = None
    ): DescribeEndPointStateInput =
      DescribeEndPointStateInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(instances)(_.instances(_))
        .build

    def describeEndPointStateOutput(
      instanceStates: Option[List[InstanceState]] = None
    ): DescribeEndPointStateOutput =
      DescribeEndPointStateOutput
        .builder
        .ifSome(instanceStates)(_.instanceStates(_))
        .build

    def describeLoadBalancerAttributesInput(
      loadBalancerName: Option[String] = None
    ): DescribeLoadBalancerAttributesInput =
      DescribeLoadBalancerAttributesInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .build

    def describeLoadBalancerAttributesOutput(
      loadBalancerAttributes: Option[LoadBalancerAttributes] = None
    ): DescribeLoadBalancerAttributesOutput =
      DescribeLoadBalancerAttributesOutput
        .builder
        .ifSome(loadBalancerAttributes)(_.loadBalancerAttributes(_))
        .build

    def describeLoadBalancerPoliciesInput(
      loadBalancerName: Option[String] = None,
      policyNames: Option[List[PolicyName]] = None
    ): DescribeLoadBalancerPoliciesInput =
      DescribeLoadBalancerPoliciesInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def describeLoadBalancerPoliciesOutput(
      policyDescriptions: Option[List[PolicyDescription]] = None
    ): DescribeLoadBalancerPoliciesOutput =
      DescribeLoadBalancerPoliciesOutput
        .builder
        .ifSome(policyDescriptions)(_.policyDescriptions(_))
        .build

    def describeLoadBalancerPolicyTypesInput(
      policyTypeNames: Option[List[PolicyTypeName]] = None
    ): DescribeLoadBalancerPolicyTypesInput =
      DescribeLoadBalancerPolicyTypesInput
        .builder
        .ifSome(policyTypeNames)(_.policyTypeNames(_))
        .build

    def describeLoadBalancerPolicyTypesOutput(
      policyTypeDescriptions: Option[List[PolicyTypeDescription]] = None
    ): DescribeLoadBalancerPolicyTypesOutput =
      DescribeLoadBalancerPolicyTypesOutput
        .builder
        .ifSome(policyTypeDescriptions)(_.policyTypeDescriptions(_))
        .build

    def describeTagsInput(
      loadBalancerNames: Option[List[AccessPointName]] = None
    ): DescribeTagsInput =
      DescribeTagsInput
        .builder
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .build

    def describeTagsOutput(
      tagDescriptions: Option[List[TagDescription]] = None
    ): DescribeTagsOutput =
      DescribeTagsOutput
        .builder
        .ifSome(tagDescriptions)(_.tagDescriptions(_))
        .build

    def detachLoadBalancerFromSubnetsInput(
      loadBalancerName: Option[String] = None,
      subnets: Option[List[SubnetId]] = None
    ): DetachLoadBalancerFromSubnetsInput =
      DetachLoadBalancerFromSubnetsInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(subnets)(_.subnets(_))
        .build

    def detachLoadBalancerFromSubnetsOutput(
      subnets: Option[List[SubnetId]] = None
    ): DetachLoadBalancerFromSubnetsOutput =
      DetachLoadBalancerFromSubnetsOutput
        .builder
        .ifSome(subnets)(_.subnets(_))
        .build

    def duplicateAccessPointNameException(

    ): DuplicateAccessPointNameException =
      DuplicateAccessPointNameException
        .builder

        .build

    def duplicateListenerException(

    ): DuplicateListenerException =
      DuplicateListenerException
        .builder

        .build

    def duplicatePolicyNameException(

    ): DuplicatePolicyNameException =
      DuplicatePolicyNameException
        .builder

        .build

    def duplicateTagKeysException(

    ): DuplicateTagKeysException =
      DuplicateTagKeysException
        .builder

        .build

    def healthCheck(
      target: Option[String] = None,
      interval: Option[Int] = None,
      timeout: Option[Int] = None,
      unhealthyThreshold: Option[Int] = None,
      healthyThreshold: Option[Int] = None
    ): HealthCheck =
      HealthCheck
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(unhealthyThreshold)(_.unhealthyThreshold(_))
        .ifSome(healthyThreshold)(_.healthyThreshold(_))
        .build

    def instance(
      instanceId: Option[String] = None
    ): Instance =
      Instance
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def instanceState(
      instanceId: Option[String] = None,
      state: Option[String] = None,
      reasonCode: Option[String] = None,
      description: Option[String] = None
    ): InstanceState =
      InstanceState
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(state)(_.state(_))
        .ifSome(reasonCode)(_.reasonCode(_))
        .ifSome(description)(_.description(_))
        .build

    def invalidConfigurationRequestException(

    ): InvalidConfigurationRequestException =
      InvalidConfigurationRequestException
        .builder

        .build

    def invalidEndPointException(

    ): InvalidEndPointException =
      InvalidEndPointException
        .builder

        .build

    def invalidSchemeException(

    ): InvalidSchemeException =
      InvalidSchemeException
        .builder

        .build

    def invalidSecurityGroupException(

    ): InvalidSecurityGroupException =
      InvalidSecurityGroupException
        .builder

        .build

    def invalidSubnetException(

    ): InvalidSubnetException =
      InvalidSubnetException
        .builder

        .build

    def lBCookieStickinessPolicy(
      policyName: Option[String] = None,
      cookieExpirationPeriod: Option[CookieExpirationPeriod] = None
    ): LBCookieStickinessPolicy =
      LBCookieStickinessPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(cookieExpirationPeriod)(_.cookieExpirationPeriod(_))
        .build

    def limit(
      name: Option[String] = None,
      max: Option[String] = None
    ): Limit =
      Limit
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(max)(_.max(_))
        .build

    def listener(
      protocol: Option[String] = None,
      loadBalancerPort: Option[Int] = None,
      instanceProtocol: Option[String] = None,
      instancePort: Option[Int] = None,
      sSLCertificateId: Option[String] = None
    ): Listener =
      Listener
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(loadBalancerPort)(_.loadBalancerPort(_))
        .ifSome(instanceProtocol)(_.instanceProtocol(_))
        .ifSome(instancePort)(_.instancePort(_))
        .ifSome(sSLCertificateId)(_.sSLCertificateId(_))
        .build

    def listenerDescription(
      listener: Option[Listener] = None,
      policyNames: Option[List[PolicyName]] = None
    ): ListenerDescription =
      ListenerDescription
        .builder
        .ifSome(listener)(_.listener(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def listenerNotFoundException(

    ): ListenerNotFoundException =
      ListenerNotFoundException
        .builder

        .build

    def loadBalancerAttributeNotFoundException(

    ): LoadBalancerAttributeNotFoundException =
      LoadBalancerAttributeNotFoundException
        .builder

        .build

    def loadBalancerAttributes(
      crossZoneLoadBalancing: Option[CrossZoneLoadBalancing] = None,
      accessLog: Option[AccessLog] = None,
      connectionDraining: Option[ConnectionDraining] = None,
      connectionSettings: Option[ConnectionSettings] = None,
      additionalAttributes: Option[List[AdditionalAttribute]] = None
    ): LoadBalancerAttributes =
      LoadBalancerAttributes
        .builder
        .ifSome(crossZoneLoadBalancing)(_.crossZoneLoadBalancing(_))
        .ifSome(accessLog)(_.accessLog(_))
        .ifSome(connectionDraining)(_.connectionDraining(_))
        .ifSome(connectionSettings)(_.connectionSettings(_))
        .ifSome(additionalAttributes)(_.additionalAttributes(_))
        .build

    def loadBalancerDescription(
      loadBalancerName: Option[String] = None,
      dNSName: Option[String] = None,
      canonicalHostedZoneName: Option[String] = None,
      canonicalHostedZoneNameID: Option[String] = None,
      listenerDescriptions: Option[List[ListenerDescription]] = None,
      policies: Option[Policies] = None,
      backendServerDescriptions: Option[List[BackendServerDescription]] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None,
      subnets: Option[List[SubnetId]] = None,
      vPCId: Option[String] = None,
      instances: Option[List[Instance]] = None,
      healthCheck: Option[HealthCheck] = None,
      sourceSecurityGroup: Option[SourceSecurityGroup] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      createdTime: Option[CreatedTime] = None,
      scheme: Option[String] = None
    ): LoadBalancerDescription =
      LoadBalancerDescription
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(dNSName)(_.dNSName(_))
        .ifSome(canonicalHostedZoneName)(_.canonicalHostedZoneName(_))
        .ifSome(canonicalHostedZoneNameID)(_.canonicalHostedZoneNameID(_))
        .ifSome(listenerDescriptions)(_.listenerDescriptions(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(backendServerDescriptions)(_.backendServerDescriptions(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(vPCId)(_.vPCId(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .ifSome(sourceSecurityGroup)(_.sourceSecurityGroup(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(scheme)(_.scheme(_))
        .build

    def modifyLoadBalancerAttributesInput(
      loadBalancerName: Option[String] = None,
      loadBalancerAttributes: Option[LoadBalancerAttributes] = None
    ): ModifyLoadBalancerAttributesInput =
      ModifyLoadBalancerAttributesInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(loadBalancerAttributes)(_.loadBalancerAttributes(_))
        .build

    def modifyLoadBalancerAttributesOutput(
      loadBalancerName: Option[String] = None,
      loadBalancerAttributes: Option[LoadBalancerAttributes] = None
    ): ModifyLoadBalancerAttributesOutput =
      ModifyLoadBalancerAttributesOutput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(loadBalancerAttributes)(_.loadBalancerAttributes(_))
        .build

    def operationNotPermittedException(

    ): OperationNotPermittedException =
      OperationNotPermittedException
        .builder

        .build

    def policies(
      appCookieStickinessPolicies: Option[List[AppCookieStickinessPolicy]] = None,
      lBCookieStickinessPolicies: Option[List[LBCookieStickinessPolicy]] = None,
      otherPolicies: Option[List[PolicyName]] = None
    ): Policies =
      Policies
        .builder
        .ifSome(appCookieStickinessPolicies)(_.appCookieStickinessPolicies(_))
        .ifSome(lBCookieStickinessPolicies)(_.lBCookieStickinessPolicies(_))
        .ifSome(otherPolicies)(_.otherPolicies(_))
        .build

    def policyAttribute(
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None
    ): PolicyAttribute =
      PolicyAttribute
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def policyAttributeDescription(
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None
    ): PolicyAttributeDescription =
      PolicyAttributeDescription
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def policyAttributeTypeDescription(
      attributeName: Option[String] = None,
      attributeType: Option[String] = None,
      description: Option[String] = None,
      defaultValue: Option[String] = None,
      cardinality: Option[String] = None
    ): PolicyAttributeTypeDescription =
      PolicyAttributeTypeDescription
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeType)(_.attributeType(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(cardinality)(_.cardinality(_))
        .build

    def policyDescription(
      policyName: Option[String] = None,
      policyTypeName: Option[String] = None,
      policyAttributeDescriptions: Option[List[PolicyAttributeDescription]] = None
    ): PolicyDescription =
      PolicyDescription
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyTypeName)(_.policyTypeName(_))
        .ifSome(policyAttributeDescriptions)(_.policyAttributeDescriptions(_))
        .build

    def policyNotFoundException(

    ): PolicyNotFoundException =
      PolicyNotFoundException
        .builder

        .build

    def policyTypeDescription(
      policyTypeName: Option[String] = None,
      description: Option[String] = None,
      policyAttributeTypeDescriptions: Option[List[PolicyAttributeTypeDescription]] = None
    ): PolicyTypeDescription =
      PolicyTypeDescription
        .builder
        .ifSome(policyTypeName)(_.policyTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(policyAttributeTypeDescriptions)(_.policyAttributeTypeDescriptions(_))
        .build

    def policyTypeNotFoundException(

    ): PolicyTypeNotFoundException =
      PolicyTypeNotFoundException
        .builder

        .build

    def registerEndPointsInput(
      loadBalancerName: Option[String] = None,
      instances: Option[List[Instance]] = None
    ): RegisterEndPointsInput =
      RegisterEndPointsInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(instances)(_.instances(_))
        .build

    def registerEndPointsOutput(
      instances: Option[List[Instance]] = None
    ): RegisterEndPointsOutput =
      RegisterEndPointsOutput
        .builder
        .ifSome(instances)(_.instances(_))
        .build

    def removeAvailabilityZonesInput(
      loadBalancerName: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None
    ): RemoveAvailabilityZonesInput =
      RemoveAvailabilityZonesInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def removeAvailabilityZonesOutput(
      availabilityZones: Option[List[AvailabilityZone]] = None
    ): RemoveAvailabilityZonesOutput =
      RemoveAvailabilityZonesOutput
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def removeTagsInput(
      loadBalancerNames: Option[List[AccessPointName]] = None,
      tags: Option[List[TagKeyOnly]] = None
    ): RemoveTagsInput =
      RemoveTagsInput
        .builder
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .ifSome(tags)(_.tags(_))
        .build

    def removeTagsOutput(

    ): RemoveTagsOutput =
      RemoveTagsOutput
        .builder

        .build

    def setLoadBalancerListenerSSLCertificateInput(
      loadBalancerName: Option[String] = None,
      loadBalancerPort: Option[Int] = None,
      sSLCertificateId: Option[String] = None
    ): SetLoadBalancerListenerSSLCertificateInput =
      SetLoadBalancerListenerSSLCertificateInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(loadBalancerPort)(_.loadBalancerPort(_))
        .ifSome(sSLCertificateId)(_.sSLCertificateId(_))
        .build

    def setLoadBalancerListenerSSLCertificateOutput(

    ): SetLoadBalancerListenerSSLCertificateOutput =
      SetLoadBalancerListenerSSLCertificateOutput
        .builder

        .build

    def setLoadBalancerPoliciesForBackendServerInput(
      loadBalancerName: Option[String] = None,
      instancePort: Option[Int] = None,
      policyNames: Option[List[PolicyName]] = None
    ): SetLoadBalancerPoliciesForBackendServerInput =
      SetLoadBalancerPoliciesForBackendServerInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(instancePort)(_.instancePort(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def setLoadBalancerPoliciesForBackendServerOutput(

    ): SetLoadBalancerPoliciesForBackendServerOutput =
      SetLoadBalancerPoliciesForBackendServerOutput
        .builder

        .build

    def setLoadBalancerPoliciesOfListenerInput(
      loadBalancerName: Option[String] = None,
      loadBalancerPort: Option[Int] = None,
      policyNames: Option[List[PolicyName]] = None
    ): SetLoadBalancerPoliciesOfListenerInput =
      SetLoadBalancerPoliciesOfListenerInput
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(loadBalancerPort)(_.loadBalancerPort(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def setLoadBalancerPoliciesOfListenerOutput(

    ): SetLoadBalancerPoliciesOfListenerOutput =
      SetLoadBalancerPoliciesOfListenerOutput
        .builder

        .build

    def sourceSecurityGroup(
      ownerAlias: Option[String] = None,
      groupName: Option[String] = None
    ): SourceSecurityGroup =
      SourceSecurityGroup
        .builder
        .ifSome(ownerAlias)(_.ownerAlias(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def subnetNotFoundException(

    ): SubnetNotFoundException =
      SubnetNotFoundException
        .builder

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
      loadBalancerName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagDescription =
      TagDescription
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagKeyOnly(
      key: Option[String] = None
    ): TagKeyOnly =
      TagKeyOnly
        .builder
        .ifSome(key)(_.key(_))
        .build

    def tooManyAccessPointsException(

    ): TooManyAccessPointsException =
      TooManyAccessPointsException
        .builder

        .build

    def tooManyPoliciesException(

    ): TooManyPoliciesException =
      TooManyPoliciesException
        .builder

        .build

    def tooManyTagsException(

    ): TooManyTagsException =
      TooManyTagsException
        .builder

        .build

    def unsupportedProtocolException(

    ): UnsupportedProtocolException =
      UnsupportedProtocolException
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
