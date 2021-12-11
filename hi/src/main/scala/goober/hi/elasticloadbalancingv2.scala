package goober.hi

import goober.free.elasticloadbalancingv2.ElasticLoadBalancingV2IO
import software.amazon.awssdk.services.elasticloadbalancingv2.model._


object elasticloadbalancingv2 {
  import goober.free.{elasticloadbalancingv2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aLPNPolicyNotSupportedException(

    ): ALPNPolicyNotSupportedException =
      ALPNPolicyNotSupportedException
        .builder

        .build

    def action(
      `type`: Option[String] = None,
      targetGroupArn: Option[String] = None,
      authenticateOidcConfig: Option[AuthenticateOidcActionConfig] = None,
      authenticateCognitoConfig: Option[AuthenticateCognitoActionConfig] = None,
      order: Option[Int] = None,
      redirectConfig: Option[RedirectActionConfig] = None,
      fixedResponseConfig: Option[FixedResponseActionConfig] = None,
      forwardConfig: Option[ForwardActionConfig] = None
    ): Action =
      Action
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(authenticateOidcConfig)(_.authenticateOidcConfig(_))
        .ifSome(authenticateCognitoConfig)(_.authenticateCognitoConfig(_))
        .ifSome(order)(_.order(_))
        .ifSome(redirectConfig)(_.redirectConfig(_))
        .ifSome(fixedResponseConfig)(_.fixedResponseConfig(_))
        .ifSome(forwardConfig)(_.forwardConfig(_))
        .build

    def addListenerCertificatesInput(
      listenerArn: Option[String] = None,
      certificates: Option[List[Certificate]] = None
    ): AddListenerCertificatesInput =
      AddListenerCertificatesInput
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(certificates)(_.certificates(_))
        .build

    def addListenerCertificatesOutput(
      certificates: Option[List[Certificate]] = None
    ): AddListenerCertificatesOutput =
      AddListenerCertificatesOutput
        .builder
        .ifSome(certificates)(_.certificates(_))
        .build

    def addTagsInput(
      resourceArns: Option[List[ResourceArn]] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsInput =
      AddTagsInput
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsOutput(

    ): AddTagsOutput =
      AddTagsOutput
        .builder

        .build

    def allocationIdNotFoundException(

    ): AllocationIdNotFoundException =
      AllocationIdNotFoundException
        .builder

        .build

    def authenticateCognitoActionConfig(
      userPoolArn: Option[String] = None,
      userPoolClientId: Option[String] = None,
      userPoolDomain: Option[String] = None,
      sessionCookieName: Option[String] = None,
      scope: Option[String] = None,
      sessionTimeout: Option[AuthenticateCognitoActionSessionTimeout] = None,
      authenticationRequestExtraParams: Option[AuthenticateCognitoActionAuthenticationRequestExtraParams] = None,
      onUnauthenticatedRequest: Option[String] = None
    ): AuthenticateCognitoActionConfig =
      AuthenticateCognitoActionConfig
        .builder
        .ifSome(userPoolArn)(_.userPoolArn(_))
        .ifSome(userPoolClientId)(_.userPoolClientId(_))
        .ifSome(userPoolDomain)(_.userPoolDomain(_))
        .ifSome(sessionCookieName)(_.sessionCookieName(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(sessionTimeout)(_.sessionTimeout(_))
        .ifSome(authenticationRequestExtraParams)(_.authenticationRequestExtraParams(_))
        .ifSome(onUnauthenticatedRequest)(_.onUnauthenticatedRequest(_))
        .build

    def authenticateOidcActionConfig(
      issuer: Option[String] = None,
      authorizationEndpoint: Option[String] = None,
      tokenEndpoint: Option[String] = None,
      userInfoEndpoint: Option[String] = None,
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      sessionCookieName: Option[String] = None,
      scope: Option[String] = None,
      sessionTimeout: Option[AuthenticateOidcActionSessionTimeout] = None,
      authenticationRequestExtraParams: Option[AuthenticateOidcActionAuthenticationRequestExtraParams] = None,
      onUnauthenticatedRequest: Option[String] = None,
      useExistingClientSecret: Option[Boolean] = None
    ): AuthenticateOidcActionConfig =
      AuthenticateOidcActionConfig
        .builder
        .ifSome(issuer)(_.issuer(_))
        .ifSome(authorizationEndpoint)(_.authorizationEndpoint(_))
        .ifSome(tokenEndpoint)(_.tokenEndpoint(_))
        .ifSome(userInfoEndpoint)(_.userInfoEndpoint(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(sessionCookieName)(_.sessionCookieName(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(sessionTimeout)(_.sessionTimeout(_))
        .ifSome(authenticationRequestExtraParams)(_.authenticationRequestExtraParams(_))
        .ifSome(onUnauthenticatedRequest)(_.onUnauthenticatedRequest(_))
        .ifSome(useExistingClientSecret)(_.useExistingClientSecret(_))
        .build

    def availabilityZone(
      zoneName: Option[String] = None,
      subnetId: Option[String] = None,
      outpostId: Option[String] = None,
      loadBalancerAddresses: Option[List[LoadBalancerAddress]] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(zoneName)(_.zoneName(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(outpostId)(_.outpostId(_))
        .ifSome(loadBalancerAddresses)(_.loadBalancerAddresses(_))
        .build

    def availabilityZoneNotSupportedException(

    ): AvailabilityZoneNotSupportedException =
      AvailabilityZoneNotSupportedException
        .builder

        .build

    def certificate(
      certificateArn: Option[String] = None,
      isDefault: Option[Boolean] = None
    ): Certificate =
      Certificate
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(isDefault)(_.isDefault(_))
        .build

    def certificateNotFoundException(

    ): CertificateNotFoundException =
      CertificateNotFoundException
        .builder

        .build

    def cipher(
      name: Option[String] = None,
      priority: Option[Int] = None
    ): Cipher =
      Cipher
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .build

    def createListenerInput(
      loadBalancerArn: Option[String] = None,
      protocol: Option[String] = None,
      port: Option[Int] = None,
      sslPolicy: Option[String] = None,
      certificates: Option[List[Certificate]] = None,
      defaultActions: Option[List[Action]] = None,
      alpnPolicy: Option[List[AlpnPolicyValue]] = None,
      tags: Option[List[Tag]] = None
    ): CreateListenerInput =
      CreateListenerInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(port)(_.port(_))
        .ifSome(sslPolicy)(_.sslPolicy(_))
        .ifSome(certificates)(_.certificates(_))
        .ifSome(defaultActions)(_.defaultActions(_))
        .ifSome(alpnPolicy)(_.alpnPolicy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createListenerOutput(
      listeners: Option[List[Listener]] = None
    ): CreateListenerOutput =
      CreateListenerOutput
        .builder
        .ifSome(listeners)(_.listeners(_))
        .build

    def createLoadBalancerInput(
      name: Option[String] = None,
      subnets: Option[List[SubnetId]] = None,
      subnetMappings: Option[List[SubnetMapping]] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      scheme: Option[String] = None,
      tags: Option[List[Tag]] = None,
      `type`: Option[String] = None,
      ipAddressType: Option[String] = None,
      customerOwnedIpv4Pool: Option[String] = None
    ): CreateLoadBalancerInput =
      CreateLoadBalancerInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(subnetMappings)(_.subnetMappings(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(scheme)(_.scheme(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(customerOwnedIpv4Pool)(_.customerOwnedIpv4Pool(_))
        .build

    def createLoadBalancerOutput(
      loadBalancers: Option[List[LoadBalancer]] = None
    ): CreateLoadBalancerOutput =
      CreateLoadBalancerOutput
        .builder
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .build

    def createRuleInput(
      listenerArn: Option[String] = None,
      conditions: Option[List[RuleCondition]] = None,
      priority: Option[Int] = None,
      actions: Option[List[Action]] = None,
      tags: Option[List[Tag]] = None
    ): CreateRuleInput =
      CreateRuleInput
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(conditions)(_.conditions(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRuleOutput(
      rules: Option[List[Rule]] = None
    ): CreateRuleOutput =
      CreateRuleOutput
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def createTargetGroupInput(
      name: Option[String] = None,
      protocol: Option[String] = None,
      protocolVersion: Option[String] = None,
      port: Option[Int] = None,
      vpcId: Option[String] = None,
      healthCheckProtocol: Option[String] = None,
      healthCheckPort: Option[String] = None,
      healthCheckEnabled: Option[Boolean] = None,
      healthCheckPath: Option[String] = None,
      healthCheckIntervalSeconds: Option[Int] = None,
      healthCheckTimeoutSeconds: Option[Int] = None,
      healthyThresholdCount: Option[Int] = None,
      unhealthyThresholdCount: Option[Int] = None,
      matcher: Option[Matcher] = None,
      targetType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateTargetGroupInput =
      CreateTargetGroupInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(protocolVersion)(_.protocolVersion(_))
        .ifSome(port)(_.port(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(healthCheckProtocol)(_.healthCheckProtocol(_))
        .ifSome(healthCheckPort)(_.healthCheckPort(_))
        .ifSome(healthCheckEnabled)(_.healthCheckEnabled(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(healthCheckIntervalSeconds)(_.healthCheckIntervalSeconds(_))
        .ifSome(healthCheckTimeoutSeconds)(_.healthCheckTimeoutSeconds(_))
        .ifSome(healthyThresholdCount)(_.healthyThresholdCount(_))
        .ifSome(unhealthyThresholdCount)(_.unhealthyThresholdCount(_))
        .ifSome(matcher)(_.matcher(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTargetGroupOutput(
      targetGroups: Option[List[TargetGroup]] = None
    ): CreateTargetGroupOutput =
      CreateTargetGroupOutput
        .builder
        .ifSome(targetGroups)(_.targetGroups(_))
        .build

    def deleteListenerInput(
      listenerArn: Option[String] = None
    ): DeleteListenerInput =
      DeleteListenerInput
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .build

    def deleteListenerOutput(

    ): DeleteListenerOutput =
      DeleteListenerOutput
        .builder

        .build

    def deleteLoadBalancerInput(
      loadBalancerArn: Option[String] = None
    ): DeleteLoadBalancerInput =
      DeleteLoadBalancerInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .build

    def deleteLoadBalancerOutput(

    ): DeleteLoadBalancerOutput =
      DeleteLoadBalancerOutput
        .builder

        .build

    def deleteRuleInput(
      ruleArn: Option[String] = None
    ): DeleteRuleInput =
      DeleteRuleInput
        .builder
        .ifSome(ruleArn)(_.ruleArn(_))
        .build

    def deleteRuleOutput(

    ): DeleteRuleOutput =
      DeleteRuleOutput
        .builder

        .build

    def deleteTargetGroupInput(
      targetGroupArn: Option[String] = None
    ): DeleteTargetGroupInput =
      DeleteTargetGroupInput
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .build

    def deleteTargetGroupOutput(

    ): DeleteTargetGroupOutput =
      DeleteTargetGroupOutput
        .builder

        .build

    def deregisterTargetsInput(
      targetGroupArn: Option[String] = None,
      targets: Option[List[TargetDescription]] = None
    ): DeregisterTargetsInput =
      DeregisterTargetsInput
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(targets)(_.targets(_))
        .build

    def deregisterTargetsOutput(

    ): DeregisterTargetsOutput =
      DeregisterTargetsOutput
        .builder

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

    def describeListenerCertificatesInput(
      listenerArn: Option[String] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeListenerCertificatesInput =
      DescribeListenerCertificatesInput
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeListenerCertificatesOutput(
      certificates: Option[List[Certificate]] = None,
      nextMarker: Option[String] = None
    ): DescribeListenerCertificatesOutput =
      DescribeListenerCertificatesOutput
        .builder
        .ifSome(certificates)(_.certificates(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeListenersInput(
      loadBalancerArn: Option[String] = None,
      listenerArns: Option[List[ListenerArn]] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeListenersInput =
      DescribeListenersInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(listenerArns)(_.listenerArns(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeListenersOutput(
      listeners: Option[List[Listener]] = None,
      nextMarker: Option[String] = None
    ): DescribeListenersOutput =
      DescribeListenersOutput
        .builder
        .ifSome(listeners)(_.listeners(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeLoadBalancerAttributesInput(
      loadBalancerArn: Option[String] = None
    ): DescribeLoadBalancerAttributesInput =
      DescribeLoadBalancerAttributesInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .build

    def describeLoadBalancerAttributesOutput(
      attributes: Option[List[LoadBalancerAttribute]] = None
    ): DescribeLoadBalancerAttributesOutput =
      DescribeLoadBalancerAttributesOutput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def describeLoadBalancersInput(
      loadBalancerArns: Option[List[LoadBalancerArn]] = None,
      names: Option[List[LoadBalancerName]] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeLoadBalancersInput =
      DescribeLoadBalancersInput
        .builder
        .ifSome(loadBalancerArns)(_.loadBalancerArns(_))
        .ifSome(names)(_.names(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeLoadBalancersOutput(
      loadBalancers: Option[List[LoadBalancer]] = None,
      nextMarker: Option[String] = None
    ): DescribeLoadBalancersOutput =
      DescribeLoadBalancersOutput
        .builder
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeRulesInput(
      listenerArn: Option[String] = None,
      ruleArns: Option[List[RuleArn]] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeRulesInput =
      DescribeRulesInput
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(ruleArns)(_.ruleArns(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeRulesOutput(
      rules: Option[List[Rule]] = None,
      nextMarker: Option[String] = None
    ): DescribeRulesOutput =
      DescribeRulesOutput
        .builder
        .ifSome(rules)(_.rules(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeSSLPoliciesInput(
      names: Option[List[SslPolicyName]] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeSSLPoliciesInput =
      DescribeSSLPoliciesInput
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeSSLPoliciesOutput(
      sslPolicies: Option[List[SslPolicy]] = None,
      nextMarker: Option[String] = None
    ): DescribeSSLPoliciesOutput =
      DescribeSSLPoliciesOutput
        .builder
        .ifSome(sslPolicies)(_.sslPolicies(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeTagsInput(
      resourceArns: Option[List[ResourceArn]] = None
    ): DescribeTagsInput =
      DescribeTagsInput
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .build

    def describeTagsOutput(
      tagDescriptions: Option[List[TagDescription]] = None
    ): DescribeTagsOutput =
      DescribeTagsOutput
        .builder
        .ifSome(tagDescriptions)(_.tagDescriptions(_))
        .build

    def describeTargetGroupAttributesInput(
      targetGroupArn: Option[String] = None
    ): DescribeTargetGroupAttributesInput =
      DescribeTargetGroupAttributesInput
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .build

    def describeTargetGroupAttributesOutput(
      attributes: Option[List[TargetGroupAttribute]] = None
    ): DescribeTargetGroupAttributesOutput =
      DescribeTargetGroupAttributesOutput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def describeTargetGroupsInput(
      loadBalancerArn: Option[String] = None,
      targetGroupArns: Option[List[TargetGroupArn]] = None,
      names: Option[List[TargetGroupName]] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeTargetGroupsInput =
      DescribeTargetGroupsInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(targetGroupArns)(_.targetGroupArns(_))
        .ifSome(names)(_.names(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeTargetGroupsOutput(
      targetGroups: Option[List[TargetGroup]] = None,
      nextMarker: Option[String] = None
    ): DescribeTargetGroupsOutput =
      DescribeTargetGroupsOutput
        .builder
        .ifSome(targetGroups)(_.targetGroups(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def describeTargetHealthInput(
      targetGroupArn: Option[String] = None,
      targets: Option[List[TargetDescription]] = None
    ): DescribeTargetHealthInput =
      DescribeTargetHealthInput
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(targets)(_.targets(_))
        .build

    def describeTargetHealthOutput(
      targetHealthDescriptions: Option[List[TargetHealthDescription]] = None
    ): DescribeTargetHealthOutput =
      DescribeTargetHealthOutput
        .builder
        .ifSome(targetHealthDescriptions)(_.targetHealthDescriptions(_))
        .build

    def duplicateListenerException(

    ): DuplicateListenerException =
      DuplicateListenerException
        .builder

        .build

    def duplicateLoadBalancerNameException(

    ): DuplicateLoadBalancerNameException =
      DuplicateLoadBalancerNameException
        .builder

        .build

    def duplicateTagKeysException(

    ): DuplicateTagKeysException =
      DuplicateTagKeysException
        .builder

        .build

    def duplicateTargetGroupNameException(

    ): DuplicateTargetGroupNameException =
      DuplicateTargetGroupNameException
        .builder

        .build

    def fixedResponseActionConfig(
      messageBody: Option[String] = None,
      statusCode: Option[String] = None,
      contentType: Option[String] = None
    ): FixedResponseActionConfig =
      FixedResponseActionConfig
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def forwardActionConfig(
      targetGroups: Option[List[TargetGroupTuple]] = None,
      targetGroupStickinessConfig: Option[TargetGroupStickinessConfig] = None
    ): ForwardActionConfig =
      ForwardActionConfig
        .builder
        .ifSome(targetGroups)(_.targetGroups(_))
        .ifSome(targetGroupStickinessConfig)(_.targetGroupStickinessConfig(_))
        .build

    def healthUnavailableException(

    ): HealthUnavailableException =
      HealthUnavailableException
        .builder

        .build

    def hostHeaderConditionConfig(
      values: Option[List[StringValue]] = None
    ): HostHeaderConditionConfig =
      HostHeaderConditionConfig
        .builder
        .ifSome(values)(_.values(_))
        .build

    def httpHeaderConditionConfig(
      httpHeaderName: Option[String] = None,
      values: Option[List[StringValue]] = None
    ): HttpHeaderConditionConfig =
      HttpHeaderConditionConfig
        .builder
        .ifSome(httpHeaderName)(_.httpHeaderName(_))
        .ifSome(values)(_.values(_))
        .build

    def httpRequestMethodConditionConfig(
      values: Option[List[StringValue]] = None
    ): HttpRequestMethodConditionConfig =
      HttpRequestMethodConditionConfig
        .builder
        .ifSome(values)(_.values(_))
        .build

    def incompatibleProtocolsException(

    ): IncompatibleProtocolsException =
      IncompatibleProtocolsException
        .builder

        .build

    def invalidConfigurationRequestException(

    ): InvalidConfigurationRequestException =
      InvalidConfigurationRequestException
        .builder

        .build

    def invalidLoadBalancerActionException(

    ): InvalidLoadBalancerActionException =
      InvalidLoadBalancerActionException
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

    def invalidTargetException(

    ): InvalidTargetException =
      InvalidTargetException
        .builder

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
      listenerArn: Option[String] = None,
      loadBalancerArn: Option[String] = None,
      port: Option[Int] = None,
      protocol: Option[String] = None,
      certificates: Option[List[Certificate]] = None,
      sslPolicy: Option[String] = None,
      defaultActions: Option[List[Action]] = None,
      alpnPolicy: Option[List[AlpnPolicyValue]] = None
    ): Listener =
      Listener
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(certificates)(_.certificates(_))
        .ifSome(sslPolicy)(_.sslPolicy(_))
        .ifSome(defaultActions)(_.defaultActions(_))
        .ifSome(alpnPolicy)(_.alpnPolicy(_))
        .build

    def listenerNotFoundException(

    ): ListenerNotFoundException =
      ListenerNotFoundException
        .builder

        .build

    def loadBalancer(
      loadBalancerArn: Option[String] = None,
      dNSName: Option[String] = None,
      canonicalHostedZoneId: Option[String] = None,
      createdTime: Option[CreatedTime] = None,
      loadBalancerName: Option[String] = None,
      scheme: Option[String] = None,
      vpcId: Option[String] = None,
      state: Option[LoadBalancerState] = None,
      `type`: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      ipAddressType: Option[String] = None,
      customerOwnedIpv4Pool: Option[String] = None
    ): LoadBalancer =
      LoadBalancer
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(dNSName)(_.dNSName(_))
        .ifSome(canonicalHostedZoneId)(_.canonicalHostedZoneId(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(scheme)(_.scheme(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(customerOwnedIpv4Pool)(_.customerOwnedIpv4Pool(_))
        .build

    def loadBalancerAddress(
      ipAddress: Option[String] = None,
      allocationId: Option[String] = None,
      privateIPv4Address: Option[String] = None,
      iPv6Address: Option[String] = None
    ): LoadBalancerAddress =
      LoadBalancerAddress
        .builder
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(privateIPv4Address)(_.privateIPv4Address(_))
        .ifSome(iPv6Address)(_.iPv6Address(_))
        .build

    def loadBalancerAttribute(
      key: Option[String] = None,
      value: Option[String] = None
    ): LoadBalancerAttribute =
      LoadBalancerAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def loadBalancerNotFoundException(

    ): LoadBalancerNotFoundException =
      LoadBalancerNotFoundException
        .builder

        .build

    def loadBalancerState(
      code: Option[String] = None,
      reason: Option[String] = None
    ): LoadBalancerState =
      LoadBalancerState
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(reason)(_.reason(_))
        .build

    def matcher(
      httpCode: Option[String] = None,
      grpcCode: Option[String] = None
    ): Matcher =
      Matcher
        .builder
        .ifSome(httpCode)(_.httpCode(_))
        .ifSome(grpcCode)(_.grpcCode(_))
        .build

    def modifyListenerInput(
      listenerArn: Option[String] = None,
      port: Option[Int] = None,
      protocol: Option[String] = None,
      sslPolicy: Option[String] = None,
      certificates: Option[List[Certificate]] = None,
      defaultActions: Option[List[Action]] = None,
      alpnPolicy: Option[List[AlpnPolicyValue]] = None
    ): ModifyListenerInput =
      ModifyListenerInput
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(sslPolicy)(_.sslPolicy(_))
        .ifSome(certificates)(_.certificates(_))
        .ifSome(defaultActions)(_.defaultActions(_))
        .ifSome(alpnPolicy)(_.alpnPolicy(_))
        .build

    def modifyListenerOutput(
      listeners: Option[List[Listener]] = None
    ): ModifyListenerOutput =
      ModifyListenerOutput
        .builder
        .ifSome(listeners)(_.listeners(_))
        .build

    def modifyLoadBalancerAttributesInput(
      loadBalancerArn: Option[String] = None,
      attributes: Option[List[LoadBalancerAttribute]] = None
    ): ModifyLoadBalancerAttributesInput =
      ModifyLoadBalancerAttributesInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def modifyLoadBalancerAttributesOutput(
      attributes: Option[List[LoadBalancerAttribute]] = None
    ): ModifyLoadBalancerAttributesOutput =
      ModifyLoadBalancerAttributesOutput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def modifyRuleInput(
      ruleArn: Option[String] = None,
      conditions: Option[List[RuleCondition]] = None,
      actions: Option[List[Action]] = None
    ): ModifyRuleInput =
      ModifyRuleInput
        .builder
        .ifSome(ruleArn)(_.ruleArn(_))
        .ifSome(conditions)(_.conditions(_))
        .ifSome(actions)(_.actions(_))
        .build

    def modifyRuleOutput(
      rules: Option[List[Rule]] = None
    ): ModifyRuleOutput =
      ModifyRuleOutput
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def modifyTargetGroupAttributesInput(
      targetGroupArn: Option[String] = None,
      attributes: Option[List[TargetGroupAttribute]] = None
    ): ModifyTargetGroupAttributesInput =
      ModifyTargetGroupAttributesInput
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def modifyTargetGroupAttributesOutput(
      attributes: Option[List[TargetGroupAttribute]] = None
    ): ModifyTargetGroupAttributesOutput =
      ModifyTargetGroupAttributesOutput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def modifyTargetGroupInput(
      targetGroupArn: Option[String] = None,
      healthCheckProtocol: Option[String] = None,
      healthCheckPort: Option[String] = None,
      healthCheckPath: Option[String] = None,
      healthCheckEnabled: Option[Boolean] = None,
      healthCheckIntervalSeconds: Option[Int] = None,
      healthCheckTimeoutSeconds: Option[Int] = None,
      healthyThresholdCount: Option[Int] = None,
      unhealthyThresholdCount: Option[Int] = None,
      matcher: Option[Matcher] = None
    ): ModifyTargetGroupInput =
      ModifyTargetGroupInput
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(healthCheckProtocol)(_.healthCheckProtocol(_))
        .ifSome(healthCheckPort)(_.healthCheckPort(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(healthCheckEnabled)(_.healthCheckEnabled(_))
        .ifSome(healthCheckIntervalSeconds)(_.healthCheckIntervalSeconds(_))
        .ifSome(healthCheckTimeoutSeconds)(_.healthCheckTimeoutSeconds(_))
        .ifSome(healthyThresholdCount)(_.healthyThresholdCount(_))
        .ifSome(unhealthyThresholdCount)(_.unhealthyThresholdCount(_))
        .ifSome(matcher)(_.matcher(_))
        .build

    def modifyTargetGroupOutput(
      targetGroups: Option[List[TargetGroup]] = None
    ): ModifyTargetGroupOutput =
      ModifyTargetGroupOutput
        .builder
        .ifSome(targetGroups)(_.targetGroups(_))
        .build

    def operationNotPermittedException(

    ): OperationNotPermittedException =
      OperationNotPermittedException
        .builder

        .build

    def pathPatternConditionConfig(
      values: Option[List[StringValue]] = None
    ): PathPatternConditionConfig =
      PathPatternConditionConfig
        .builder
        .ifSome(values)(_.values(_))
        .build

    def priorityInUseException(

    ): PriorityInUseException =
      PriorityInUseException
        .builder

        .build

    def queryStringConditionConfig(
      values: Option[List[QueryStringKeyValuePair]] = None
    ): QueryStringConditionConfig =
      QueryStringConditionConfig
        .builder
        .ifSome(values)(_.values(_))
        .build

    def queryStringKeyValuePair(
      key: Option[String] = None,
      value: Option[String] = None
    ): QueryStringKeyValuePair =
      QueryStringKeyValuePair
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def redirectActionConfig(
      protocol: Option[String] = None,
      port: Option[String] = None,
      host: Option[String] = None,
      path: Option[String] = None,
      query: Option[String] = None,
      statusCode: Option[String] = None
    ): RedirectActionConfig =
      RedirectActionConfig
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(port)(_.port(_))
        .ifSome(host)(_.host(_))
        .ifSome(path)(_.path(_))
        .ifSome(query)(_.query(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def registerTargetsInput(
      targetGroupArn: Option[String] = None,
      targets: Option[List[TargetDescription]] = None
    ): RegisterTargetsInput =
      RegisterTargetsInput
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(targets)(_.targets(_))
        .build

    def registerTargetsOutput(

    ): RegisterTargetsOutput =
      RegisterTargetsOutput
        .builder

        .build

    def removeListenerCertificatesInput(
      listenerArn: Option[String] = None,
      certificates: Option[List[Certificate]] = None
    ): RemoveListenerCertificatesInput =
      RemoveListenerCertificatesInput
        .builder
        .ifSome(listenerArn)(_.listenerArn(_))
        .ifSome(certificates)(_.certificates(_))
        .build

    def removeListenerCertificatesOutput(

    ): RemoveListenerCertificatesOutput =
      RemoveListenerCertificatesOutput
        .builder

        .build

    def removeTagsInput(
      resourceArns: Option[List[ResourceArn]] = None,
      tagKeys: Option[List[TagKey]] = None
    ): RemoveTagsInput =
      RemoveTagsInput
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def removeTagsOutput(

    ): RemoveTagsOutput =
      RemoveTagsOutput
        .builder

        .build

    def resourceInUseException(

    ): ResourceInUseException =
      ResourceInUseException
        .builder

        .build

    def rule(
      ruleArn: Option[String] = None,
      priority: Option[String] = None,
      conditions: Option[List[RuleCondition]] = None,
      actions: Option[List[Action]] = None,
      isDefault: Option[Boolean] = None
    ): Rule =
      Rule
        .builder
        .ifSome(ruleArn)(_.ruleArn(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(conditions)(_.conditions(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(isDefault)(_.isDefault(_))
        .build

    def ruleCondition(
      field: Option[String] = None,
      values: Option[List[StringValue]] = None,
      hostHeaderConfig: Option[HostHeaderConditionConfig] = None,
      pathPatternConfig: Option[PathPatternConditionConfig] = None,
      httpHeaderConfig: Option[HttpHeaderConditionConfig] = None,
      queryStringConfig: Option[QueryStringConditionConfig] = None,
      httpRequestMethodConfig: Option[HttpRequestMethodConditionConfig] = None,
      sourceIpConfig: Option[SourceIpConditionConfig] = None
    ): RuleCondition =
      RuleCondition
        .builder
        .ifSome(field)(_.field(_))
        .ifSome(values)(_.values(_))
        .ifSome(hostHeaderConfig)(_.hostHeaderConfig(_))
        .ifSome(pathPatternConfig)(_.pathPatternConfig(_))
        .ifSome(httpHeaderConfig)(_.httpHeaderConfig(_))
        .ifSome(queryStringConfig)(_.queryStringConfig(_))
        .ifSome(httpRequestMethodConfig)(_.httpRequestMethodConfig(_))
        .ifSome(sourceIpConfig)(_.sourceIpConfig(_))
        .build

    def ruleNotFoundException(

    ): RuleNotFoundException =
      RuleNotFoundException
        .builder

        .build

    def rulePriorityPair(
      ruleArn: Option[String] = None,
      priority: Option[Int] = None
    ): RulePriorityPair =
      RulePriorityPair
        .builder
        .ifSome(ruleArn)(_.ruleArn(_))
        .ifSome(priority)(_.priority(_))
        .build

    def sSLPolicyNotFoundException(

    ): SSLPolicyNotFoundException =
      SSLPolicyNotFoundException
        .builder

        .build

    def setIpAddressTypeInput(
      loadBalancerArn: Option[String] = None,
      ipAddressType: Option[String] = None
    ): SetIpAddressTypeInput =
      SetIpAddressTypeInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def setIpAddressTypeOutput(
      ipAddressType: Option[String] = None
    ): SetIpAddressTypeOutput =
      SetIpAddressTypeOutput
        .builder
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def setRulePrioritiesInput(
      rulePriorities: Option[List[RulePriorityPair]] = None
    ): SetRulePrioritiesInput =
      SetRulePrioritiesInput
        .builder
        .ifSome(rulePriorities)(_.rulePriorities(_))
        .build

    def setRulePrioritiesOutput(
      rules: Option[List[Rule]] = None
    ): SetRulePrioritiesOutput =
      SetRulePrioritiesOutput
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def setSecurityGroupsInput(
      loadBalancerArn: Option[String] = None,
      securityGroups: Option[List[SecurityGroupId]] = None
    ): SetSecurityGroupsInput =
      SetSecurityGroupsInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def setSecurityGroupsOutput(
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): SetSecurityGroupsOutput =
      SetSecurityGroupsOutput
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def setSubnetsInput(
      loadBalancerArn: Option[String] = None,
      subnets: Option[List[SubnetId]] = None,
      subnetMappings: Option[List[SubnetMapping]] = None,
      ipAddressType: Option[String] = None
    ): SetSubnetsInput =
      SetSubnetsInput
        .builder
        .ifSome(loadBalancerArn)(_.loadBalancerArn(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(subnetMappings)(_.subnetMappings(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def setSubnetsOutput(
      availabilityZones: Option[List[AvailabilityZone]] = None,
      ipAddressType: Option[String] = None
    ): SetSubnetsOutput =
      SetSubnetsOutput
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def sourceIpConditionConfig(
      values: Option[List[StringValue]] = None
    ): SourceIpConditionConfig =
      SourceIpConditionConfig
        .builder
        .ifSome(values)(_.values(_))
        .build

    def sslPolicy(
      sslProtocols: Option[List[SslProtocol]] = None,
      ciphers: Option[List[Cipher]] = None,
      name: Option[String] = None
    ): SslPolicy =
      SslPolicy
        .builder
        .ifSome(sslProtocols)(_.sslProtocols(_))
        .ifSome(ciphers)(_.ciphers(_))
        .ifSome(name)(_.name(_))
        .build

    def subnetMapping(
      subnetId: Option[String] = None,
      allocationId: Option[String] = None,
      privateIPv4Address: Option[String] = None,
      iPv6Address: Option[String] = None
    ): SubnetMapping =
      SubnetMapping
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(privateIPv4Address)(_.privateIPv4Address(_))
        .ifSome(iPv6Address)(_.iPv6Address(_))
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
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagDescription =
      TagDescription
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def targetDescription(
      id: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None
    ): TargetDescription =
      TargetDescription
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .build

    def targetGroup(
      targetGroupArn: Option[String] = None,
      targetGroupName: Option[String] = None,
      protocol: Option[String] = None,
      port: Option[Int] = None,
      vpcId: Option[String] = None,
      healthCheckProtocol: Option[String] = None,
      healthCheckPort: Option[String] = None,
      healthCheckEnabled: Option[Boolean] = None,
      healthCheckIntervalSeconds: Option[Int] = None,
      healthCheckTimeoutSeconds: Option[Int] = None,
      healthyThresholdCount: Option[Int] = None,
      unhealthyThresholdCount: Option[Int] = None,
      healthCheckPath: Option[String] = None,
      matcher: Option[Matcher] = None,
      loadBalancerArns: Option[List[LoadBalancerArn]] = None,
      targetType: Option[String] = None,
      protocolVersion: Option[String] = None
    ): TargetGroup =
      TargetGroup
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(targetGroupName)(_.targetGroupName(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(port)(_.port(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(healthCheckProtocol)(_.healthCheckProtocol(_))
        .ifSome(healthCheckPort)(_.healthCheckPort(_))
        .ifSome(healthCheckEnabled)(_.healthCheckEnabled(_))
        .ifSome(healthCheckIntervalSeconds)(_.healthCheckIntervalSeconds(_))
        .ifSome(healthCheckTimeoutSeconds)(_.healthCheckTimeoutSeconds(_))
        .ifSome(healthyThresholdCount)(_.healthyThresholdCount(_))
        .ifSome(unhealthyThresholdCount)(_.unhealthyThresholdCount(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(matcher)(_.matcher(_))
        .ifSome(loadBalancerArns)(_.loadBalancerArns(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(protocolVersion)(_.protocolVersion(_))
        .build

    def targetGroupAssociationLimitException(

    ): TargetGroupAssociationLimitException =
      TargetGroupAssociationLimitException
        .builder

        .build

    def targetGroupAttribute(
      key: Option[String] = None,
      value: Option[String] = None
    ): TargetGroupAttribute =
      TargetGroupAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def targetGroupNotFoundException(

    ): TargetGroupNotFoundException =
      TargetGroupNotFoundException
        .builder

        .build

    def targetGroupStickinessConfig(
      enabled: Option[Boolean] = None,
      durationSeconds: Option[Int] = None
    ): TargetGroupStickinessConfig =
      TargetGroupStickinessConfig
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .build

    def targetGroupTuple(
      targetGroupArn: Option[String] = None,
      weight: Option[Int] = None
    ): TargetGroupTuple =
      TargetGroupTuple
        .builder
        .ifSome(targetGroupArn)(_.targetGroupArn(_))
        .ifSome(weight)(_.weight(_))
        .build

    def targetHealth(
      state: Option[String] = None,
      reason: Option[String] = None,
      description: Option[String] = None
    ): TargetHealth =
      TargetHealth
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(description)(_.description(_))
        .build

    def targetHealthDescription(
      target: Option[TargetDescription] = None,
      healthCheckPort: Option[String] = None,
      targetHealth: Option[TargetHealth] = None
    ): TargetHealthDescription =
      TargetHealthDescription
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(healthCheckPort)(_.healthCheckPort(_))
        .ifSome(targetHealth)(_.targetHealth(_))
        .build

    def tooManyActionsException(

    ): TooManyActionsException =
      TooManyActionsException
        .builder

        .build

    def tooManyCertificatesException(

    ): TooManyCertificatesException =
      TooManyCertificatesException
        .builder

        .build

    def tooManyListenersException(

    ): TooManyListenersException =
      TooManyListenersException
        .builder

        .build

    def tooManyLoadBalancersException(

    ): TooManyLoadBalancersException =
      TooManyLoadBalancersException
        .builder

        .build

    def tooManyRegistrationsForTargetIdException(

    ): TooManyRegistrationsForTargetIdException =
      TooManyRegistrationsForTargetIdException
        .builder

        .build

    def tooManyRulesException(

    ): TooManyRulesException =
      TooManyRulesException
        .builder

        .build

    def tooManyTagsException(

    ): TooManyTagsException =
      TooManyTagsException
        .builder

        .build

    def tooManyTargetGroupsException(

    ): TooManyTargetGroupsException =
      TooManyTargetGroupsException
        .builder

        .build

    def tooManyTargetsException(

    ): TooManyTargetsException =
      TooManyTargetsException
        .builder

        .build

    def tooManyUniqueTargetGroupsPerLoadBalancerException(

    ): TooManyUniqueTargetGroupsPerLoadBalancerException =
      TooManyUniqueTargetGroupsPerLoadBalancerException
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
