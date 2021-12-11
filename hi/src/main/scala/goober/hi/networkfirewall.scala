package goober.hi

import goober.free.networkfirewall.NetworkFirewallIO
import software.amazon.awssdk.services.networkfirewall.model._


object networkfirewall {
  import goober.free.{networkfirewall ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def actionDefinition(
      publishMetricAction: Option[PublishMetricAction] = None
    ): ActionDefinition =
      ActionDefinition
        .builder
        .ifSome(publishMetricAction)(_.publishMetricAction(_))
        .build

    def address(
      addressDefinition: Option[String] = None
    ): Address =
      Address
        .builder
        .ifSome(addressDefinition)(_.addressDefinition(_))
        .build

    def associateFirewallPolicyRequest(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      firewallPolicyArn: Option[String] = None
    ): AssociateFirewallPolicyRequest =
      AssociateFirewallPolicyRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .build

    def associateFirewallPolicyResponse(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      firewallPolicyArn: Option[String] = None,
      updateToken: Option[String] = None
    ): AssociateFirewallPolicyResponse =
      AssociateFirewallPolicyResponse
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .ifSome(updateToken)(_.updateToken(_))
        .build

    def associateSubnetsRequest(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      subnetMappings: Option[List[SubnetMapping]] = None
    ): AssociateSubnetsRequest =
      AssociateSubnetsRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(subnetMappings)(_.subnetMappings(_))
        .build

    def associateSubnetsResponse(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      subnetMappings: Option[List[SubnetMapping]] = None,
      updateToken: Option[String] = None
    ): AssociateSubnetsResponse =
      AssociateSubnetsResponse
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(subnetMappings)(_.subnetMappings(_))
        .ifSome(updateToken)(_.updateToken(_))
        .build

    def attachment(
      subnetId: Option[String] = None,
      endpointId: Option[String] = None,
      status: Option[String] = None
    ): Attachment =
      Attachment
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(status)(_.status(_))
        .build

    def createFirewallPolicyRequest(
      firewallPolicyName: Option[String] = None,
      firewallPolicy: Option[FirewallPolicy] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateFirewallPolicyRequest =
      CreateFirewallPolicyRequest
        .builder
        .ifSome(firewallPolicyName)(_.firewallPolicyName(_))
        .ifSome(firewallPolicy)(_.firewallPolicy(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFirewallPolicyResponse(
      updateToken: Option[String] = None,
      firewallPolicyResponse: Option[FirewallPolicyResponse] = None
    ): CreateFirewallPolicyResponse =
      CreateFirewallPolicyResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallPolicyResponse)(_.firewallPolicyResponse(_))
        .build

    def createFirewallRequest(
      firewallName: Option[String] = None,
      firewallPolicyArn: Option[String] = None,
      vpcId: Option[String] = None,
      subnetMappings: Option[List[SubnetMapping]] = None,
      deleteProtection: Option[Boolean] = None,
      subnetChangeProtection: Option[Boolean] = None,
      firewallPolicyChangeProtection: Option[Boolean] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateFirewallRequest =
      CreateFirewallRequest
        .builder
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetMappings)(_.subnetMappings(_))
        .ifSome(deleteProtection)(_.deleteProtection(_))
        .ifSome(subnetChangeProtection)(_.subnetChangeProtection(_))
        .ifSome(firewallPolicyChangeProtection)(_.firewallPolicyChangeProtection(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFirewallResponse(
      firewall: Option[Firewall] = None,
      firewallStatus: Option[FirewallStatus] = None
    ): CreateFirewallResponse =
      CreateFirewallResponse
        .builder
        .ifSome(firewall)(_.firewall(_))
        .ifSome(firewallStatus)(_.firewallStatus(_))
        .build

    def createRuleGroupRequest(
      ruleGroupName: Option[String] = None,
      ruleGroup: Option[RuleGroup] = None,
      rules: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      capacity: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): CreateRuleGroupRequest =
      CreateRuleGroupRequest
        .builder
        .ifSome(ruleGroupName)(_.ruleGroupName(_))
        .ifSome(ruleGroup)(_.ruleGroup(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(capacity)(_.capacity(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRuleGroupResponse(
      updateToken: Option[String] = None,
      ruleGroupResponse: Option[RuleGroupResponse] = None
    ): CreateRuleGroupResponse =
      CreateRuleGroupResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(ruleGroupResponse)(_.ruleGroupResponse(_))
        .build

    def customAction(
      actionName: Option[String] = None,
      actionDefinition: Option[ActionDefinition] = None
    ): CustomAction =
      CustomAction
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(actionDefinition)(_.actionDefinition(_))
        .build

    def deleteFirewallPolicyRequest(
      firewallPolicyName: Option[String] = None,
      firewallPolicyArn: Option[String] = None
    ): DeleteFirewallPolicyRequest =
      DeleteFirewallPolicyRequest
        .builder
        .ifSome(firewallPolicyName)(_.firewallPolicyName(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .build

    def deleteFirewallPolicyResponse(
      firewallPolicyResponse: Option[FirewallPolicyResponse] = None
    ): DeleteFirewallPolicyResponse =
      DeleteFirewallPolicyResponse
        .builder
        .ifSome(firewallPolicyResponse)(_.firewallPolicyResponse(_))
        .build

    def deleteFirewallRequest(
      firewallName: Option[String] = None,
      firewallArn: Option[String] = None
    ): DeleteFirewallRequest =
      DeleteFirewallRequest
        .builder
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .build

    def deleteFirewallResponse(
      firewall: Option[Firewall] = None,
      firewallStatus: Option[FirewallStatus] = None
    ): DeleteFirewallResponse =
      DeleteFirewallResponse
        .builder
        .ifSome(firewall)(_.firewall(_))
        .ifSome(firewallStatus)(_.firewallStatus(_))
        .build

    def deleteResourcePolicyRequest(
      resourceArn: Option[String] = None
    ): DeleteResourcePolicyRequest =
      DeleteResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def deleteResourcePolicyResponse(

    ): DeleteResourcePolicyResponse =
      DeleteResourcePolicyResponse
        .builder

        .build

    def deleteRuleGroupRequest(
      ruleGroupName: Option[String] = None,
      ruleGroupArn: Option[String] = None,
      `type`: Option[String] = None
    ): DeleteRuleGroupRequest =
      DeleteRuleGroupRequest
        .builder
        .ifSome(ruleGroupName)(_.ruleGroupName(_))
        .ifSome(ruleGroupArn)(_.ruleGroupArn(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def deleteRuleGroupResponse(
      ruleGroupResponse: Option[RuleGroupResponse] = None
    ): DeleteRuleGroupResponse =
      DeleteRuleGroupResponse
        .builder
        .ifSome(ruleGroupResponse)(_.ruleGroupResponse(_))
        .build

    def describeFirewallPolicyRequest(
      firewallPolicyName: Option[String] = None,
      firewallPolicyArn: Option[String] = None
    ): DescribeFirewallPolicyRequest =
      DescribeFirewallPolicyRequest
        .builder
        .ifSome(firewallPolicyName)(_.firewallPolicyName(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .build

    def describeFirewallPolicyResponse(
      updateToken: Option[String] = None,
      firewallPolicyResponse: Option[FirewallPolicyResponse] = None,
      firewallPolicy: Option[FirewallPolicy] = None
    ): DescribeFirewallPolicyResponse =
      DescribeFirewallPolicyResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallPolicyResponse)(_.firewallPolicyResponse(_))
        .ifSome(firewallPolicy)(_.firewallPolicy(_))
        .build

    def describeFirewallRequest(
      firewallName: Option[String] = None,
      firewallArn: Option[String] = None
    ): DescribeFirewallRequest =
      DescribeFirewallRequest
        .builder
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .build

    def describeFirewallResponse(
      updateToken: Option[String] = None,
      firewall: Option[Firewall] = None,
      firewallStatus: Option[FirewallStatus] = None
    ): DescribeFirewallResponse =
      DescribeFirewallResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewall)(_.firewall(_))
        .ifSome(firewallStatus)(_.firewallStatus(_))
        .build

    def describeLoggingConfigurationRequest(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None
    ): DescribeLoggingConfigurationRequest =
      DescribeLoggingConfigurationRequest
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .build

    def describeLoggingConfigurationResponse(
      firewallArn: Option[String] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): DescribeLoggingConfigurationResponse =
      DescribeLoggingConfigurationResponse
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def describeResourcePolicyRequest(
      resourceArn: Option[String] = None
    ): DescribeResourcePolicyRequest =
      DescribeResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeResourcePolicyResponse(
      policy: Option[String] = None
    ): DescribeResourcePolicyResponse =
      DescribeResourcePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def describeRuleGroupRequest(
      ruleGroupName: Option[String] = None,
      ruleGroupArn: Option[String] = None,
      `type`: Option[String] = None
    ): DescribeRuleGroupRequest =
      DescribeRuleGroupRequest
        .builder
        .ifSome(ruleGroupName)(_.ruleGroupName(_))
        .ifSome(ruleGroupArn)(_.ruleGroupArn(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def describeRuleGroupResponse(
      updateToken: Option[String] = None,
      ruleGroup: Option[RuleGroup] = None,
      ruleGroupResponse: Option[RuleGroupResponse] = None
    ): DescribeRuleGroupResponse =
      DescribeRuleGroupResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(ruleGroup)(_.ruleGroup(_))
        .ifSome(ruleGroupResponse)(_.ruleGroupResponse(_))
        .build

    def dimension(
      value: Option[String] = None
    ): Dimension =
      Dimension
        .builder
        .ifSome(value)(_.value(_))
        .build

    def disassociateSubnetsRequest(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      subnetIds: Option[List[AzSubnet]] = None
    ): DisassociateSubnetsRequest =
      DisassociateSubnetsRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def disassociateSubnetsResponse(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      subnetMappings: Option[List[SubnetMapping]] = None,
      updateToken: Option[String] = None
    ): DisassociateSubnetsResponse =
      DisassociateSubnetsResponse
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(subnetMappings)(_.subnetMappings(_))
        .ifSome(updateToken)(_.updateToken(_))
        .build

    def firewall(
      firewallName: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallPolicyArn: Option[String] = None,
      vpcId: Option[String] = None,
      subnetMappings: Option[List[SubnetMapping]] = None,
      deleteProtection: Option[Boolean] = None,
      subnetChangeProtection: Option[Boolean] = None,
      firewallPolicyChangeProtection: Option[Boolean] = None,
      description: Option[String] = None,
      firewallId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): Firewall =
      Firewall
        .builder
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetMappings)(_.subnetMappings(_))
        .ifSome(deleteProtection)(_.deleteProtection(_))
        .ifSome(subnetChangeProtection)(_.subnetChangeProtection(_))
        .ifSome(firewallPolicyChangeProtection)(_.firewallPolicyChangeProtection(_))
        .ifSome(description)(_.description(_))
        .ifSome(firewallId)(_.firewallId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def firewallMetadata(
      firewallName: Option[String] = None,
      firewallArn: Option[String] = None
    ): FirewallMetadata =
      FirewallMetadata
        .builder
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .build

    def firewallPolicy(
      statelessRuleGroupReferences: Option[List[StatelessRuleGroupReference]] = None,
      statelessDefaultActions: Option[List[CollectionMember_String]] = None,
      statelessFragmentDefaultActions: Option[List[CollectionMember_String]] = None,
      statelessCustomActions: Option[List[CustomAction]] = None,
      statefulRuleGroupReferences: Option[List[StatefulRuleGroupReference]] = None
    ): FirewallPolicy =
      FirewallPolicy
        .builder
        .ifSome(statelessRuleGroupReferences)(_.statelessRuleGroupReferences(_))
        .ifSome(statelessDefaultActions)(_.statelessDefaultActions(_))
        .ifSome(statelessFragmentDefaultActions)(_.statelessFragmentDefaultActions(_))
        .ifSome(statelessCustomActions)(_.statelessCustomActions(_))
        .ifSome(statefulRuleGroupReferences)(_.statefulRuleGroupReferences(_))
        .build

    def firewallPolicyMetadata(
      name: Option[String] = None,
      arn: Option[String] = None
    ): FirewallPolicyMetadata =
      FirewallPolicyMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def firewallPolicyResponse(
      firewallPolicyName: Option[String] = None,
      firewallPolicyArn: Option[String] = None,
      firewallPolicyId: Option[String] = None,
      description: Option[String] = None,
      firewallPolicyStatus: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): FirewallPolicyResponse =
      FirewallPolicyResponse
        .builder
        .ifSome(firewallPolicyName)(_.firewallPolicyName(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .ifSome(firewallPolicyId)(_.firewallPolicyId(_))
        .ifSome(description)(_.description(_))
        .ifSome(firewallPolicyStatus)(_.firewallPolicyStatus(_))
        .ifSome(tags)(_.tags(_))
        .build

    def firewallStatus(
      status: Option[String] = None,
      configurationSyncStateSummary: Option[String] = None,
      syncStates: Option[SyncStates] = None
    ): FirewallStatus =
      FirewallStatus
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(configurationSyncStateSummary)(_.configurationSyncStateSummary(_))
        .ifSome(syncStates)(_.syncStates(_))
        .build

    def header(
      protocol: Option[String] = None,
      source: Option[String] = None,
      sourcePort: Option[String] = None,
      direction: Option[String] = None,
      destination: Option[String] = None,
      destinationPort: Option[String] = None
    ): Header =
      Header
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(source)(_.source(_))
        .ifSome(sourcePort)(_.sourcePort(_))
        .ifSome(direction)(_.direction(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationPort)(_.destinationPort(_))
        .build

    def iPSet(
      definition: Option[List[VariableDefinition]] = None
    ): IPSet =
      IPSet
        .builder
        .ifSome(definition)(_.definition(_))
        .build

    def insufficientCapacityException(
      message: Option[String] = None
    ): InsufficientCapacityException =
      InsufficientCapacityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOperationException(
      message: Option[String] = None
    ): InvalidOperationException =
      InvalidOperationException
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

    def invalidResourcePolicyException(
      message: Option[String] = None
    ): InvalidResourcePolicyException =
      InvalidResourcePolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTokenException(
      message: Option[String] = None
    ): InvalidTokenException =
      InvalidTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listFirewallPoliciesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFirewallPoliciesRequest =
      ListFirewallPoliciesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFirewallPoliciesResponse(
      nextToken: Option[String] = None,
      firewallPolicies: Option[List[FirewallPolicyMetadata]] = None
    ): ListFirewallPoliciesResponse =
      ListFirewallPoliciesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(firewallPolicies)(_.firewallPolicies(_))
        .build

    def listFirewallsRequest(
      nextToken: Option[String] = None,
      vpcIds: Option[List[VpcId]] = None,
      maxResults: Option[Int] = None
    ): ListFirewallsRequest =
      ListFirewallsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(vpcIds)(_.vpcIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFirewallsResponse(
      nextToken: Option[String] = None,
      firewalls: Option[List[FirewallMetadata]] = None
    ): ListFirewallsResponse =
      ListFirewallsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(firewalls)(_.firewalls(_))
        .build

    def listRuleGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRuleGroupsRequest =
      ListRuleGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRuleGroupsResponse(
      nextToken: Option[String] = None,
      ruleGroups: Option[List[RuleGroupMetadata]] = None
    ): ListRuleGroupsResponse =
      ListRuleGroupsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(ruleGroups)(_.ruleGroups(_))
        .build

    def listTagsForResourceRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      nextToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def logDestinationConfig(
      logType: Option[String] = None,
      logDestinationType: Option[String] = None,
      logDestination: Option[LogDestinationMap] = None
    ): LogDestinationConfig =
      LogDestinationConfig
        .builder
        .ifSome(logType)(_.logType(_))
        .ifSome(logDestinationType)(_.logDestinationType(_))
        .ifSome(logDestination)(_.logDestination(_))
        .build

    def logDestinationPermissionException(
      message: Option[String] = None
    ): LogDestinationPermissionException =
      LogDestinationPermissionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def loggingConfiguration(
      logDestinationConfigs: Option[List[LogDestinationConfig]] = None
    ): LoggingConfiguration =
      LoggingConfiguration
        .builder
        .ifSome(logDestinationConfigs)(_.logDestinationConfigs(_))
        .build

    def matchAttributes(
      sources: Option[List[Address]] = None,
      destinations: Option[List[Address]] = None,
      sourcePorts: Option[List[PortRange]] = None,
      destinationPorts: Option[List[PortRange]] = None,
      protocols: Option[List[ProtocolNumber]] = None,
      tCPFlags: Option[List[TCPFlagField]] = None
    ): MatchAttributes =
      MatchAttributes
        .builder
        .ifSome(sources)(_.sources(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(sourcePorts)(_.sourcePorts(_))
        .ifSome(destinationPorts)(_.destinationPorts(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(tCPFlags)(_.tCPFlags(_))
        .build

    def perObjectStatus(
      syncStatus: Option[String] = None,
      updateToken: Option[String] = None
    ): PerObjectStatus =
      PerObjectStatus
        .builder
        .ifSome(syncStatus)(_.syncStatus(_))
        .ifSome(updateToken)(_.updateToken(_))
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

    def portSet(
      definition: Option[List[VariableDefinition]] = None
    ): PortSet =
      PortSet
        .builder
        .ifSome(definition)(_.definition(_))
        .build

    def publishMetricAction(
      dimensions: Option[List[Dimension]] = None
    ): PublishMetricAction =
      PublishMetricAction
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .build

    def putResourcePolicyRequest(
      resourceArn: Option[String] = None,
      policy: Option[String] = None
    ): PutResourcePolicyRequest =
      PutResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putResourcePolicyResponse(

    ): PutResourcePolicyResponse =
      PutResourcePolicyResponse
        .builder

        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceOwnerCheckException(
      message: Option[String] = None
    ): ResourceOwnerCheckException =
      ResourceOwnerCheckException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ruleDefinition(
      matchAttributes: Option[MatchAttributes] = None,
      actions: Option[List[CollectionMember_String]] = None
    ): RuleDefinition =
      RuleDefinition
        .builder
        .ifSome(matchAttributes)(_.matchAttributes(_))
        .ifSome(actions)(_.actions(_))
        .build

    def ruleGroup(
      ruleVariables: Option[RuleVariables] = None,
      rulesSource: Option[RulesSource] = None
    ): RuleGroup =
      RuleGroup
        .builder
        .ifSome(ruleVariables)(_.ruleVariables(_))
        .ifSome(rulesSource)(_.rulesSource(_))
        .build

    def ruleGroupMetadata(
      name: Option[String] = None,
      arn: Option[String] = None
    ): RuleGroupMetadata =
      RuleGroupMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def ruleGroupResponse(
      ruleGroupArn: Option[String] = None,
      ruleGroupName: Option[String] = None,
      ruleGroupId: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      capacity: Option[Int] = None,
      ruleGroupStatus: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): RuleGroupResponse =
      RuleGroupResponse
        .builder
        .ifSome(ruleGroupArn)(_.ruleGroupArn(_))
        .ifSome(ruleGroupName)(_.ruleGroupName(_))
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(capacity)(_.capacity(_))
        .ifSome(ruleGroupStatus)(_.ruleGroupStatus(_))
        .ifSome(tags)(_.tags(_))
        .build

    def ruleOption(
      keyword: Option[String] = None,
      settings: Option[List[Setting]] = None
    ): RuleOption =
      RuleOption
        .builder
        .ifSome(keyword)(_.keyword(_))
        .ifSome(settings)(_.settings(_))
        .build

    def ruleVariables(
      iPSets: Option[IPSets] = None,
      portSets: Option[PortSets] = None
    ): RuleVariables =
      RuleVariables
        .builder
        .ifSome(iPSets)(_.iPSets(_))
        .ifSome(portSets)(_.portSets(_))
        .build

    def rulesSource(
      rulesString: Option[String] = None,
      rulesSourceList: Option[RulesSourceList] = None,
      statefulRules: Option[List[StatefulRule]] = None,
      statelessRulesAndCustomActions: Option[StatelessRulesAndCustomActions] = None
    ): RulesSource =
      RulesSource
        .builder
        .ifSome(rulesString)(_.rulesString(_))
        .ifSome(rulesSourceList)(_.rulesSourceList(_))
        .ifSome(statefulRules)(_.statefulRules(_))
        .ifSome(statelessRulesAndCustomActions)(_.statelessRulesAndCustomActions(_))
        .build

    def rulesSourceList(
      targets: Option[List[CollectionMember_String]] = None,
      targetTypes: Option[List[TargetType]] = None,
      generatedRulesType: Option[String] = None
    ): RulesSourceList =
      RulesSourceList
        .builder
        .ifSome(targets)(_.targets(_))
        .ifSome(targetTypes)(_.targetTypes(_))
        .ifSome(generatedRulesType)(_.generatedRulesType(_))
        .build

    def statefulRule(
      action: Option[String] = None,
      header: Option[Header] = None,
      ruleOptions: Option[List[RuleOption]] = None
    ): StatefulRule =
      StatefulRule
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(header)(_.header(_))
        .ifSome(ruleOptions)(_.ruleOptions(_))
        .build

    def statefulRuleGroupReference(
      resourceArn: Option[String] = None
    ): StatefulRuleGroupReference =
      StatefulRuleGroupReference
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def statelessRule(
      ruleDefinition: Option[RuleDefinition] = None,
      priority: Option[Int] = None
    ): StatelessRule =
      StatelessRule
        .builder
        .ifSome(ruleDefinition)(_.ruleDefinition(_))
        .ifSome(priority)(_.priority(_))
        .build

    def statelessRuleGroupReference(
      resourceArn: Option[String] = None,
      priority: Option[Int] = None
    ): StatelessRuleGroupReference =
      StatelessRuleGroupReference
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(priority)(_.priority(_))
        .build

    def statelessRulesAndCustomActions(
      statelessRules: Option[List[StatelessRule]] = None,
      customActions: Option[List[CustomAction]] = None
    ): StatelessRulesAndCustomActions =
      StatelessRulesAndCustomActions
        .builder
        .ifSome(statelessRules)(_.statelessRules(_))
        .ifSome(customActions)(_.customActions(_))
        .build

    def subnetMapping(
      subnetId: Option[String] = None
    ): SubnetMapping =
      SubnetMapping
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def syncState(
      attachment: Option[Attachment] = None,
      config: Option[SyncStateConfig] = None
    ): SyncState =
      SyncState
        .builder
        .ifSome(attachment)(_.attachment(_))
        .ifSome(config)(_.config(_))
        .build

    def tCPFlagField(
      flags: Option[List[TCPFlag]] = None,
      masks: Option[List[TCPFlag]] = None
    ): TCPFlagField =
      TCPFlagField
        .builder
        .ifSome(flags)(_.flags(_))
        .ifSome(masks)(_.masks(_))
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
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
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

    def updateFirewallDeleteProtectionRequest(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      deleteProtection: Option[Boolean] = None
    ): UpdateFirewallDeleteProtectionRequest =
      UpdateFirewallDeleteProtectionRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(deleteProtection)(_.deleteProtection(_))
        .build

    def updateFirewallDeleteProtectionResponse(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      deleteProtection: Option[Boolean] = None,
      updateToken: Option[String] = None
    ): UpdateFirewallDeleteProtectionResponse =
      UpdateFirewallDeleteProtectionResponse
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(deleteProtection)(_.deleteProtection(_))
        .ifSome(updateToken)(_.updateToken(_))
        .build

    def updateFirewallDescriptionRequest(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      description: Option[String] = None
    ): UpdateFirewallDescriptionRequest =
      UpdateFirewallDescriptionRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(description)(_.description(_))
        .build

    def updateFirewallDescriptionResponse(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      description: Option[String] = None,
      updateToken: Option[String] = None
    ): UpdateFirewallDescriptionResponse =
      UpdateFirewallDescriptionResponse
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(description)(_.description(_))
        .ifSome(updateToken)(_.updateToken(_))
        .build

    def updateFirewallPolicyChangeProtectionRequest(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      firewallPolicyChangeProtection: Option[Boolean] = None
    ): UpdateFirewallPolicyChangeProtectionRequest =
      UpdateFirewallPolicyChangeProtectionRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallPolicyChangeProtection)(_.firewallPolicyChangeProtection(_))
        .build

    def updateFirewallPolicyChangeProtectionResponse(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      firewallPolicyChangeProtection: Option[Boolean] = None
    ): UpdateFirewallPolicyChangeProtectionResponse =
      UpdateFirewallPolicyChangeProtectionResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(firewallPolicyChangeProtection)(_.firewallPolicyChangeProtection(_))
        .build

    def updateFirewallPolicyRequest(
      updateToken: Option[String] = None,
      firewallPolicyArn: Option[String] = None,
      firewallPolicyName: Option[String] = None,
      firewallPolicy: Option[FirewallPolicy] = None,
      description: Option[String] = None
    ): UpdateFirewallPolicyRequest =
      UpdateFirewallPolicyRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallPolicyArn)(_.firewallPolicyArn(_))
        .ifSome(firewallPolicyName)(_.firewallPolicyName(_))
        .ifSome(firewallPolicy)(_.firewallPolicy(_))
        .ifSome(description)(_.description(_))
        .build

    def updateFirewallPolicyResponse(
      updateToken: Option[String] = None,
      firewallPolicyResponse: Option[FirewallPolicyResponse] = None
    ): UpdateFirewallPolicyResponse =
      UpdateFirewallPolicyResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallPolicyResponse)(_.firewallPolicyResponse(_))
        .build

    def updateLoggingConfigurationRequest(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): UpdateLoggingConfigurationRequest =
      UpdateLoggingConfigurationRequest
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def updateLoggingConfigurationResponse(
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): UpdateLoggingConfigurationResponse =
      UpdateLoggingConfigurationResponse
        .builder
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def updateRuleGroupRequest(
      updateToken: Option[String] = None,
      ruleGroupArn: Option[String] = None,
      ruleGroupName: Option[String] = None,
      ruleGroup: Option[RuleGroup] = None,
      rules: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None
    ): UpdateRuleGroupRequest =
      UpdateRuleGroupRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(ruleGroupArn)(_.ruleGroupArn(_))
        .ifSome(ruleGroupName)(_.ruleGroupName(_))
        .ifSome(ruleGroup)(_.ruleGroup(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .build

    def updateRuleGroupResponse(
      updateToken: Option[String] = None,
      ruleGroupResponse: Option[RuleGroupResponse] = None
    ): UpdateRuleGroupResponse =
      UpdateRuleGroupResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(ruleGroupResponse)(_.ruleGroupResponse(_))
        .build

    def updateSubnetChangeProtectionRequest(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      subnetChangeProtection: Option[Boolean] = None
    ): UpdateSubnetChangeProtectionRequest =
      UpdateSubnetChangeProtectionRequest
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(subnetChangeProtection)(_.subnetChangeProtection(_))
        .build

    def updateSubnetChangeProtectionResponse(
      updateToken: Option[String] = None,
      firewallArn: Option[String] = None,
      firewallName: Option[String] = None,
      subnetChangeProtection: Option[Boolean] = None
    ): UpdateSubnetChangeProtectionResponse =
      UpdateSubnetChangeProtectionResponse
        .builder
        .ifSome(updateToken)(_.updateToken(_))
        .ifSome(firewallArn)(_.firewallArn(_))
        .ifSome(firewallName)(_.firewallName(_))
        .ifSome(subnetChangeProtection)(_.subnetChangeProtection(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
