package goober.hi

import goober.free.route53resolver.Route53ResolverIO
import software.amazon.awssdk.services.route53resolver.model._


object route53resolver {
  import goober.free.{route53resolver ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associateFirewallRuleGroupRequest(
      creatorRequestId: Option[String] = None,
      firewallRuleGroupId: Option[String] = None,
      vpcId: Option[String] = None,
      priority: Option[Int] = None,
      name: Option[String] = None,
      mutationProtection: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AssociateFirewallRuleGroupRequest =
      AssociateFirewallRuleGroupRequest
        .builder
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(name)(_.name(_))
        .ifSome(mutationProtection)(_.mutationProtection(_))
        .ifSome(tags)(_.tags(_))
        .build

    def associateFirewallRuleGroupResponse(
      firewallRuleGroupAssociation: Option[FirewallRuleGroupAssociation] = None
    ): AssociateFirewallRuleGroupResponse =
      AssociateFirewallRuleGroupResponse
        .builder
        .ifSome(firewallRuleGroupAssociation)(_.firewallRuleGroupAssociation(_))
        .build

    def associateResolverEndpointIpAddressRequest(
      resolverEndpointId: Option[String] = None,
      ipAddress: Option[IpAddressUpdate] = None
    ): AssociateResolverEndpointIpAddressRequest =
      AssociateResolverEndpointIpAddressRequest
        .builder
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .build

    def associateResolverEndpointIpAddressResponse(
      resolverEndpoint: Option[ResolverEndpoint] = None
    ): AssociateResolverEndpointIpAddressResponse =
      AssociateResolverEndpointIpAddressResponse
        .builder
        .ifSome(resolverEndpoint)(_.resolverEndpoint(_))
        .build

    def associateResolverQueryLogConfigRequest(
      resolverQueryLogConfigId: Option[String] = None,
      resourceId: Option[String] = None
    ): AssociateResolverQueryLogConfigRequest =
      AssociateResolverQueryLogConfigRequest
        .builder
        .ifSome(resolverQueryLogConfigId)(_.resolverQueryLogConfigId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def associateResolverQueryLogConfigResponse(
      resolverQueryLogConfigAssociation: Option[ResolverQueryLogConfigAssociation] = None
    ): AssociateResolverQueryLogConfigResponse =
      AssociateResolverQueryLogConfigResponse
        .builder
        .ifSome(resolverQueryLogConfigAssociation)(_.resolverQueryLogConfigAssociation(_))
        .build

    def associateResolverRuleRequest(
      resolverRuleId: Option[String] = None,
      name: Option[String] = None,
      vPCId: Option[String] = None
    ): AssociateResolverRuleRequest =
      AssociateResolverRuleRequest
        .builder
        .ifSome(resolverRuleId)(_.resolverRuleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(vPCId)(_.vPCId(_))
        .build

    def associateResolverRuleResponse(
      resolverRuleAssociation: Option[ResolverRuleAssociation] = None
    ): AssociateResolverRuleResponse =
      AssociateResolverRuleResponse
        .builder
        .ifSome(resolverRuleAssociation)(_.resolverRuleAssociation(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createFirewallDomainListRequest(
      creatorRequestId: Option[String] = None,
      name: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateFirewallDomainListRequest =
      CreateFirewallDomainListRequest
        .builder
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFirewallDomainListResponse(
      firewallDomainList: Option[FirewallDomainList] = None
    ): CreateFirewallDomainListResponse =
      CreateFirewallDomainListResponse
        .builder
        .ifSome(firewallDomainList)(_.firewallDomainList(_))
        .build

    def createFirewallRuleGroupRequest(
      creatorRequestId: Option[String] = None,
      name: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateFirewallRuleGroupRequest =
      CreateFirewallRuleGroupRequest
        .builder
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFirewallRuleGroupResponse(
      firewallRuleGroup: Option[FirewallRuleGroup] = None
    ): CreateFirewallRuleGroupResponse =
      CreateFirewallRuleGroupResponse
        .builder
        .ifSome(firewallRuleGroup)(_.firewallRuleGroup(_))
        .build

    def createFirewallRuleRequest(
      creatorRequestId: Option[String] = None,
      firewallRuleGroupId: Option[String] = None,
      firewallDomainListId: Option[String] = None,
      priority: Option[Int] = None,
      action: Option[String] = None,
      blockResponse: Option[String] = None,
      blockOverrideDomain: Option[String] = None,
      blockOverrideDnsType: Option[String] = None,
      blockOverrideTtl: Option[Int] = None,
      name: Option[String] = None
    ): CreateFirewallRuleRequest =
      CreateFirewallRuleRequest
        .builder
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(action)(_.action(_))
        .ifSome(blockResponse)(_.blockResponse(_))
        .ifSome(blockOverrideDomain)(_.blockOverrideDomain(_))
        .ifSome(blockOverrideDnsType)(_.blockOverrideDnsType(_))
        .ifSome(blockOverrideTtl)(_.blockOverrideTtl(_))
        .ifSome(name)(_.name(_))
        .build

    def createFirewallRuleResponse(
      firewallRule: Option[FirewallRule] = None
    ): CreateFirewallRuleResponse =
      CreateFirewallRuleResponse
        .builder
        .ifSome(firewallRule)(_.firewallRule(_))
        .build

    def createResolverEndpointRequest(
      creatorRequestId: Option[String] = None,
      name: Option[String] = None,
      securityGroupIds: Option[List[ResourceId]] = None,
      direction: Option[String] = None,
      ipAddresses: Option[List[IpAddressRequest]] = None,
      tags: Option[List[Tag]] = None
    ): CreateResolverEndpointRequest =
      CreateResolverEndpointRequest
        .builder
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(direction)(_.direction(_))
        .ifSome(ipAddresses)(_.ipAddresses(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createResolverEndpointResponse(
      resolverEndpoint: Option[ResolverEndpoint] = None
    ): CreateResolverEndpointResponse =
      CreateResolverEndpointResponse
        .builder
        .ifSome(resolverEndpoint)(_.resolverEndpoint(_))
        .build

    def createResolverQueryLogConfigRequest(
      name: Option[String] = None,
      destinationArn: Option[String] = None,
      creatorRequestId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateResolverQueryLogConfigRequest =
      CreateResolverQueryLogConfigRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createResolverQueryLogConfigResponse(
      resolverQueryLogConfig: Option[ResolverQueryLogConfig] = None
    ): CreateResolverQueryLogConfigResponse =
      CreateResolverQueryLogConfigResponse
        .builder
        .ifSome(resolverQueryLogConfig)(_.resolverQueryLogConfig(_))
        .build

    def createResolverRuleRequest(
      creatorRequestId: Option[String] = None,
      name: Option[String] = None,
      ruleType: Option[String] = None,
      domainName: Option[String] = None,
      targetIps: Option[List[TargetAddress]] = None,
      resolverEndpointId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateResolverRuleRequest =
      CreateResolverRuleRequest
        .builder
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(name)(_.name(_))
        .ifSome(ruleType)(_.ruleType(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(targetIps)(_.targetIps(_))
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createResolverRuleResponse(
      resolverRule: Option[ResolverRule] = None
    ): CreateResolverRuleResponse =
      CreateResolverRuleResponse
        .builder
        .ifSome(resolverRule)(_.resolverRule(_))
        .build

    def deleteFirewallDomainListRequest(
      firewallDomainListId: Option[String] = None
    ): DeleteFirewallDomainListRequest =
      DeleteFirewallDomainListRequest
        .builder
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .build

    def deleteFirewallDomainListResponse(
      firewallDomainList: Option[FirewallDomainList] = None
    ): DeleteFirewallDomainListResponse =
      DeleteFirewallDomainListResponse
        .builder
        .ifSome(firewallDomainList)(_.firewallDomainList(_))
        .build

    def deleteFirewallRuleGroupRequest(
      firewallRuleGroupId: Option[String] = None
    ): DeleteFirewallRuleGroupRequest =
      DeleteFirewallRuleGroupRequest
        .builder
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .build

    def deleteFirewallRuleGroupResponse(
      firewallRuleGroup: Option[FirewallRuleGroup] = None
    ): DeleteFirewallRuleGroupResponse =
      DeleteFirewallRuleGroupResponse
        .builder
        .ifSome(firewallRuleGroup)(_.firewallRuleGroup(_))
        .build

    def deleteFirewallRuleRequest(
      firewallRuleGroupId: Option[String] = None,
      firewallDomainListId: Option[String] = None
    ): DeleteFirewallRuleRequest =
      DeleteFirewallRuleRequest
        .builder
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .build

    def deleteFirewallRuleResponse(
      firewallRule: Option[FirewallRule] = None
    ): DeleteFirewallRuleResponse =
      DeleteFirewallRuleResponse
        .builder
        .ifSome(firewallRule)(_.firewallRule(_))
        .build

    def deleteResolverEndpointRequest(
      resolverEndpointId: Option[String] = None
    ): DeleteResolverEndpointRequest =
      DeleteResolverEndpointRequest
        .builder
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .build

    def deleteResolverEndpointResponse(
      resolverEndpoint: Option[ResolverEndpoint] = None
    ): DeleteResolverEndpointResponse =
      DeleteResolverEndpointResponse
        .builder
        .ifSome(resolverEndpoint)(_.resolverEndpoint(_))
        .build

    def deleteResolverQueryLogConfigRequest(
      resolverQueryLogConfigId: Option[String] = None
    ): DeleteResolverQueryLogConfigRequest =
      DeleteResolverQueryLogConfigRequest
        .builder
        .ifSome(resolverQueryLogConfigId)(_.resolverQueryLogConfigId(_))
        .build

    def deleteResolverQueryLogConfigResponse(
      resolverQueryLogConfig: Option[ResolverQueryLogConfig] = None
    ): DeleteResolverQueryLogConfigResponse =
      DeleteResolverQueryLogConfigResponse
        .builder
        .ifSome(resolverQueryLogConfig)(_.resolverQueryLogConfig(_))
        .build

    def deleteResolverRuleRequest(
      resolverRuleId: Option[String] = None
    ): DeleteResolverRuleRequest =
      DeleteResolverRuleRequest
        .builder
        .ifSome(resolverRuleId)(_.resolverRuleId(_))
        .build

    def deleteResolverRuleResponse(
      resolverRule: Option[ResolverRule] = None
    ): DeleteResolverRuleResponse =
      DeleteResolverRuleResponse
        .builder
        .ifSome(resolverRule)(_.resolverRule(_))
        .build

    def disassociateFirewallRuleGroupRequest(
      firewallRuleGroupAssociationId: Option[String] = None
    ): DisassociateFirewallRuleGroupRequest =
      DisassociateFirewallRuleGroupRequest
        .builder
        .ifSome(firewallRuleGroupAssociationId)(_.firewallRuleGroupAssociationId(_))
        .build

    def disassociateFirewallRuleGroupResponse(
      firewallRuleGroupAssociation: Option[FirewallRuleGroupAssociation] = None
    ): DisassociateFirewallRuleGroupResponse =
      DisassociateFirewallRuleGroupResponse
        .builder
        .ifSome(firewallRuleGroupAssociation)(_.firewallRuleGroupAssociation(_))
        .build

    def disassociateResolverEndpointIpAddressRequest(
      resolverEndpointId: Option[String] = None,
      ipAddress: Option[IpAddressUpdate] = None
    ): DisassociateResolverEndpointIpAddressRequest =
      DisassociateResolverEndpointIpAddressRequest
        .builder
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .build

    def disassociateResolverEndpointIpAddressResponse(
      resolverEndpoint: Option[ResolverEndpoint] = None
    ): DisassociateResolverEndpointIpAddressResponse =
      DisassociateResolverEndpointIpAddressResponse
        .builder
        .ifSome(resolverEndpoint)(_.resolverEndpoint(_))
        .build

    def disassociateResolverQueryLogConfigRequest(
      resolverQueryLogConfigId: Option[String] = None,
      resourceId: Option[String] = None
    ): DisassociateResolverQueryLogConfigRequest =
      DisassociateResolverQueryLogConfigRequest
        .builder
        .ifSome(resolverQueryLogConfigId)(_.resolverQueryLogConfigId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def disassociateResolverQueryLogConfigResponse(
      resolverQueryLogConfigAssociation: Option[ResolverQueryLogConfigAssociation] = None
    ): DisassociateResolverQueryLogConfigResponse =
      DisassociateResolverQueryLogConfigResponse
        .builder
        .ifSome(resolverQueryLogConfigAssociation)(_.resolverQueryLogConfigAssociation(_))
        .build

    def disassociateResolverRuleRequest(
      vPCId: Option[String] = None,
      resolverRuleId: Option[String] = None
    ): DisassociateResolverRuleRequest =
      DisassociateResolverRuleRequest
        .builder
        .ifSome(vPCId)(_.vPCId(_))
        .ifSome(resolverRuleId)(_.resolverRuleId(_))
        .build

    def disassociateResolverRuleResponse(
      resolverRuleAssociation: Option[ResolverRuleAssociation] = None
    ): DisassociateResolverRuleResponse =
      DisassociateResolverRuleResponse
        .builder
        .ifSome(resolverRuleAssociation)(_.resolverRuleAssociation(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def firewallConfig(
      id: Option[String] = None,
      resourceId: Option[String] = None,
      ownerId: Option[String] = None,
      firewallFailOpen: Option[String] = None
    ): FirewallConfig =
      FirewallConfig
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(firewallFailOpen)(_.firewallFailOpen(_))
        .build

    def firewallDomainList(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      domainCount: Option[Int] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      managedOwnerName: Option[String] = None,
      creatorRequestId: Option[String] = None,
      creationTime: Option[String] = None,
      modificationTime: Option[String] = None
    ): FirewallDomainList =
      FirewallDomainList
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(domainCount)(_.domainCount(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(managedOwnerName)(_.managedOwnerName(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modificationTime)(_.modificationTime(_))
        .build

    def firewallDomainListMetadata(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      creatorRequestId: Option[String] = None,
      managedOwnerName: Option[String] = None
    ): FirewallDomainListMetadata =
      FirewallDomainListMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(managedOwnerName)(_.managedOwnerName(_))
        .build

    def firewallRule(
      firewallRuleGroupId: Option[String] = None,
      firewallDomainListId: Option[String] = None,
      name: Option[String] = None,
      priority: Option[Int] = None,
      action: Option[String] = None,
      blockResponse: Option[String] = None,
      blockOverrideDomain: Option[String] = None,
      blockOverrideDnsType: Option[String] = None,
      blockOverrideTtl: Option[Int] = None,
      creatorRequestId: Option[String] = None,
      creationTime: Option[String] = None,
      modificationTime: Option[String] = None
    ): FirewallRule =
      FirewallRule
        .builder
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(action)(_.action(_))
        .ifSome(blockResponse)(_.blockResponse(_))
        .ifSome(blockOverrideDomain)(_.blockOverrideDomain(_))
        .ifSome(blockOverrideDnsType)(_.blockOverrideDnsType(_))
        .ifSome(blockOverrideTtl)(_.blockOverrideTtl(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modificationTime)(_.modificationTime(_))
        .build

    def firewallRuleGroup(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      ruleCount: Option[Int] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      ownerId: Option[String] = None,
      creatorRequestId: Option[String] = None,
      shareStatus: Option[String] = None,
      creationTime: Option[String] = None,
      modificationTime: Option[String] = None
    ): FirewallRuleGroup =
      FirewallRuleGroup
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(ruleCount)(_.ruleCount(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(shareStatus)(_.shareStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modificationTime)(_.modificationTime(_))
        .build

    def firewallRuleGroupAssociation(
      id: Option[String] = None,
      arn: Option[String] = None,
      firewallRuleGroupId: Option[String] = None,
      vpcId: Option[String] = None,
      name: Option[String] = None,
      priority: Option[Int] = None,
      mutationProtection: Option[String] = None,
      managedOwnerName: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      creatorRequestId: Option[String] = None,
      creationTime: Option[String] = None,
      modificationTime: Option[String] = None
    ): FirewallRuleGroupAssociation =
      FirewallRuleGroupAssociation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(mutationProtection)(_.mutationProtection(_))
        .ifSome(managedOwnerName)(_.managedOwnerName(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modificationTime)(_.modificationTime(_))
        .build

    def firewallRuleGroupMetadata(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      ownerId: Option[String] = None,
      creatorRequestId: Option[String] = None,
      shareStatus: Option[String] = None
    ): FirewallRuleGroupMetadata =
      FirewallRuleGroupMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(shareStatus)(_.shareStatus(_))
        .build

    def getFirewallConfigRequest(
      resourceId: Option[String] = None
    ): GetFirewallConfigRequest =
      GetFirewallConfigRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def getFirewallConfigResponse(
      firewallConfig: Option[FirewallConfig] = None
    ): GetFirewallConfigResponse =
      GetFirewallConfigResponse
        .builder
        .ifSome(firewallConfig)(_.firewallConfig(_))
        .build

    def getFirewallDomainListRequest(
      firewallDomainListId: Option[String] = None
    ): GetFirewallDomainListRequest =
      GetFirewallDomainListRequest
        .builder
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .build

    def getFirewallDomainListResponse(
      firewallDomainList: Option[FirewallDomainList] = None
    ): GetFirewallDomainListResponse =
      GetFirewallDomainListResponse
        .builder
        .ifSome(firewallDomainList)(_.firewallDomainList(_))
        .build

    def getFirewallRuleGroupAssociationRequest(
      firewallRuleGroupAssociationId: Option[String] = None
    ): GetFirewallRuleGroupAssociationRequest =
      GetFirewallRuleGroupAssociationRequest
        .builder
        .ifSome(firewallRuleGroupAssociationId)(_.firewallRuleGroupAssociationId(_))
        .build

    def getFirewallRuleGroupAssociationResponse(
      firewallRuleGroupAssociation: Option[FirewallRuleGroupAssociation] = None
    ): GetFirewallRuleGroupAssociationResponse =
      GetFirewallRuleGroupAssociationResponse
        .builder
        .ifSome(firewallRuleGroupAssociation)(_.firewallRuleGroupAssociation(_))
        .build

    def getFirewallRuleGroupPolicyRequest(
      arn: Option[String] = None
    ): GetFirewallRuleGroupPolicyRequest =
      GetFirewallRuleGroupPolicyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getFirewallRuleGroupPolicyResponse(
      firewallRuleGroupPolicy: Option[String] = None
    ): GetFirewallRuleGroupPolicyResponse =
      GetFirewallRuleGroupPolicyResponse
        .builder
        .ifSome(firewallRuleGroupPolicy)(_.firewallRuleGroupPolicy(_))
        .build

    def getFirewallRuleGroupRequest(
      firewallRuleGroupId: Option[String] = None
    ): GetFirewallRuleGroupRequest =
      GetFirewallRuleGroupRequest
        .builder
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .build

    def getFirewallRuleGroupResponse(
      firewallRuleGroup: Option[FirewallRuleGroup] = None
    ): GetFirewallRuleGroupResponse =
      GetFirewallRuleGroupResponse
        .builder
        .ifSome(firewallRuleGroup)(_.firewallRuleGroup(_))
        .build

    def getResolverDnssecConfigRequest(
      resourceId: Option[String] = None
    ): GetResolverDnssecConfigRequest =
      GetResolverDnssecConfigRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def getResolverDnssecConfigResponse(
      resolverDNSSECConfig: Option[ResolverDnssecConfig] = None
    ): GetResolverDnssecConfigResponse =
      GetResolverDnssecConfigResponse
        .builder
        .ifSome(resolverDNSSECConfig)(_.resolverDNSSECConfig(_))
        .build

    def getResolverEndpointRequest(
      resolverEndpointId: Option[String] = None
    ): GetResolverEndpointRequest =
      GetResolverEndpointRequest
        .builder
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .build

    def getResolverEndpointResponse(
      resolverEndpoint: Option[ResolverEndpoint] = None
    ): GetResolverEndpointResponse =
      GetResolverEndpointResponse
        .builder
        .ifSome(resolverEndpoint)(_.resolverEndpoint(_))
        .build

    def getResolverQueryLogConfigAssociationRequest(
      resolverQueryLogConfigAssociationId: Option[String] = None
    ): GetResolverQueryLogConfigAssociationRequest =
      GetResolverQueryLogConfigAssociationRequest
        .builder
        .ifSome(resolverQueryLogConfigAssociationId)(_.resolverQueryLogConfigAssociationId(_))
        .build

    def getResolverQueryLogConfigAssociationResponse(
      resolverQueryLogConfigAssociation: Option[ResolverQueryLogConfigAssociation] = None
    ): GetResolverQueryLogConfigAssociationResponse =
      GetResolverQueryLogConfigAssociationResponse
        .builder
        .ifSome(resolverQueryLogConfigAssociation)(_.resolverQueryLogConfigAssociation(_))
        .build

    def getResolverQueryLogConfigPolicyRequest(
      arn: Option[String] = None
    ): GetResolverQueryLogConfigPolicyRequest =
      GetResolverQueryLogConfigPolicyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getResolverQueryLogConfigPolicyResponse(
      resolverQueryLogConfigPolicy: Option[String] = None
    ): GetResolverQueryLogConfigPolicyResponse =
      GetResolverQueryLogConfigPolicyResponse
        .builder
        .ifSome(resolverQueryLogConfigPolicy)(_.resolverQueryLogConfigPolicy(_))
        .build

    def getResolverQueryLogConfigRequest(
      resolverQueryLogConfigId: Option[String] = None
    ): GetResolverQueryLogConfigRequest =
      GetResolverQueryLogConfigRequest
        .builder
        .ifSome(resolverQueryLogConfigId)(_.resolverQueryLogConfigId(_))
        .build

    def getResolverQueryLogConfigResponse(
      resolverQueryLogConfig: Option[ResolverQueryLogConfig] = None
    ): GetResolverQueryLogConfigResponse =
      GetResolverQueryLogConfigResponse
        .builder
        .ifSome(resolverQueryLogConfig)(_.resolverQueryLogConfig(_))
        .build

    def getResolverRuleAssociationRequest(
      resolverRuleAssociationId: Option[String] = None
    ): GetResolverRuleAssociationRequest =
      GetResolverRuleAssociationRequest
        .builder
        .ifSome(resolverRuleAssociationId)(_.resolverRuleAssociationId(_))
        .build

    def getResolverRuleAssociationResponse(
      resolverRuleAssociation: Option[ResolverRuleAssociation] = None
    ): GetResolverRuleAssociationResponse =
      GetResolverRuleAssociationResponse
        .builder
        .ifSome(resolverRuleAssociation)(_.resolverRuleAssociation(_))
        .build

    def getResolverRulePolicyRequest(
      arn: Option[String] = None
    ): GetResolverRulePolicyRequest =
      GetResolverRulePolicyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getResolverRulePolicyResponse(
      resolverRulePolicy: Option[String] = None
    ): GetResolverRulePolicyResponse =
      GetResolverRulePolicyResponse
        .builder
        .ifSome(resolverRulePolicy)(_.resolverRulePolicy(_))
        .build

    def getResolverRuleRequest(
      resolverRuleId: Option[String] = None
    ): GetResolverRuleRequest =
      GetResolverRuleRequest
        .builder
        .ifSome(resolverRuleId)(_.resolverRuleId(_))
        .build

    def getResolverRuleResponse(
      resolverRule: Option[ResolverRule] = None
    ): GetResolverRuleResponse =
      GetResolverRuleResponse
        .builder
        .ifSome(resolverRule)(_.resolverRule(_))
        .build

    def importFirewallDomainsRequest(
      firewallDomainListId: Option[String] = None,
      operation: Option[String] = None,
      domainFileUrl: Option[String] = None
    ): ImportFirewallDomainsRequest =
      ImportFirewallDomainsRequest
        .builder
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(domainFileUrl)(_.domainFileUrl(_))
        .build

    def importFirewallDomainsResponse(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): ImportFirewallDomainsResponse =
      ImportFirewallDomainsResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def internalServiceErrorException(
      message: Option[String] = None
    ): InternalServiceErrorException =
      InternalServiceErrorException
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

    def invalidParameterException(
      message: Option[String] = None,
      fieldName: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(fieldName)(_.fieldName(_))
        .build

    def invalidPolicyDocument(
      message: Option[String] = None
    ): InvalidPolicyDocument =
      InvalidPolicyDocument
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

    def invalidTagException(
      message: Option[String] = None
    ): InvalidTagException =
      InvalidTagException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ipAddressRequest(
      subnetId: Option[String] = None,
      ip: Option[String] = None
    ): IpAddressRequest =
      IpAddressRequest
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(ip)(_.ip(_))
        .build

    def ipAddressResponse(
      ipId: Option[String] = None,
      subnetId: Option[String] = None,
      ip: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      creationTime: Option[String] = None,
      modificationTime: Option[String] = None
    ): IpAddressResponse =
      IpAddressResponse
        .builder
        .ifSome(ipId)(_.ipId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(ip)(_.ip(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modificationTime)(_.modificationTime(_))
        .build

    def ipAddressUpdate(
      ipId: Option[String] = None,
      subnetId: Option[String] = None,
      ip: Option[String] = None
    ): IpAddressUpdate =
      IpAddressUpdate
        .builder
        .ifSome(ipId)(_.ipId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(ip)(_.ip(_))
        .build

    def limitExceededException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def listFirewallConfigsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFirewallConfigsRequest =
      ListFirewallConfigsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFirewallConfigsResponse(
      nextToken: Option[String] = None,
      firewallConfigs: Option[List[FirewallConfig]] = None
    ): ListFirewallConfigsResponse =
      ListFirewallConfigsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(firewallConfigs)(_.firewallConfigs(_))
        .build

    def listFirewallDomainListsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFirewallDomainListsRequest =
      ListFirewallDomainListsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFirewallDomainListsResponse(
      nextToken: Option[String] = None,
      firewallDomainLists: Option[List[FirewallDomainListMetadata]] = None
    ): ListFirewallDomainListsResponse =
      ListFirewallDomainListsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(firewallDomainLists)(_.firewallDomainLists(_))
        .build

    def listFirewallDomainsRequest(
      firewallDomainListId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFirewallDomainsRequest =
      ListFirewallDomainsRequest
        .builder
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFirewallDomainsResponse(
      nextToken: Option[String] = None,
      domains: Option[List[FirewallDomainName]] = None
    ): ListFirewallDomainsResponse =
      ListFirewallDomainsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(domains)(_.domains(_))
        .build

    def listFirewallRuleGroupAssociationsRequest(
      firewallRuleGroupId: Option[String] = None,
      vpcId: Option[String] = None,
      priority: Option[Int] = None,
      status: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFirewallRuleGroupAssociationsRequest =
      ListFirewallRuleGroupAssociationsRequest
        .builder
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFirewallRuleGroupAssociationsResponse(
      nextToken: Option[String] = None,
      firewallRuleGroupAssociations: Option[List[FirewallRuleGroupAssociation]] = None
    ): ListFirewallRuleGroupAssociationsResponse =
      ListFirewallRuleGroupAssociationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(firewallRuleGroupAssociations)(_.firewallRuleGroupAssociations(_))
        .build

    def listFirewallRuleGroupsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFirewallRuleGroupsRequest =
      ListFirewallRuleGroupsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFirewallRuleGroupsResponse(
      nextToken: Option[String] = None,
      firewallRuleGroups: Option[List[FirewallRuleGroupMetadata]] = None
    ): ListFirewallRuleGroupsResponse =
      ListFirewallRuleGroupsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(firewallRuleGroups)(_.firewallRuleGroups(_))
        .build

    def listFirewallRulesRequest(
      firewallRuleGroupId: Option[String] = None,
      priority: Option[Int] = None,
      action: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFirewallRulesRequest =
      ListFirewallRulesRequest
        .builder
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(action)(_.action(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFirewallRulesResponse(
      nextToken: Option[String] = None,
      firewallRules: Option[List[FirewallRule]] = None
    ): ListFirewallRulesResponse =
      ListFirewallRulesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(firewallRules)(_.firewallRules(_))
        .build

    def listResolverDnssecConfigsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListResolverDnssecConfigsRequest =
      ListResolverDnssecConfigsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listResolverDnssecConfigsResponse(
      nextToken: Option[String] = None,
      resolverDnssecConfigs: Option[List[ResolverDnssecConfig]] = None
    ): ListResolverDnssecConfigsResponse =
      ListResolverDnssecConfigsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resolverDnssecConfigs)(_.resolverDnssecConfigs(_))
        .build

    def listResolverEndpointIpAddressesRequest(
      resolverEndpointId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListResolverEndpointIpAddressesRequest =
      ListResolverEndpointIpAddressesRequest
        .builder
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResolverEndpointIpAddressesResponse(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      ipAddresses: Option[List[IpAddressResponse]] = None
    ): ListResolverEndpointIpAddressesResponse =
      ListResolverEndpointIpAddressesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(ipAddresses)(_.ipAddresses(_))
        .build

    def listResolverEndpointsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListResolverEndpointsRequest =
      ListResolverEndpointsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listResolverEndpointsResponse(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      resolverEndpoints: Option[List[ResolverEndpoint]] = None
    ): ListResolverEndpointsResponse =
      ListResolverEndpointsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resolverEndpoints)(_.resolverEndpoints(_))
        .build

    def listResolverQueryLogConfigAssociationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListResolverQueryLogConfigAssociationsRequest =
      ListResolverQueryLogConfigAssociationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listResolverQueryLogConfigAssociationsResponse(
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None,
      totalFilteredCount: Option[Int] = None,
      resolverQueryLogConfigAssociations: Option[List[ResolverQueryLogConfigAssociation]] = None
    ): ListResolverQueryLogConfigAssociationsResponse =
      ListResolverQueryLogConfigAssociationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .ifSome(totalFilteredCount)(_.totalFilteredCount(_))
        .ifSome(resolverQueryLogConfigAssociations)(_.resolverQueryLogConfigAssociations(_))
        .build

    def listResolverQueryLogConfigsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListResolverQueryLogConfigsRequest =
      ListResolverQueryLogConfigsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listResolverQueryLogConfigsResponse(
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None,
      totalFilteredCount: Option[Int] = None,
      resolverQueryLogConfigs: Option[List[ResolverQueryLogConfig]] = None
    ): ListResolverQueryLogConfigsResponse =
      ListResolverQueryLogConfigsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .ifSome(totalFilteredCount)(_.totalFilteredCount(_))
        .ifSome(resolverQueryLogConfigs)(_.resolverQueryLogConfigs(_))
        .build

    def listResolverRuleAssociationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListResolverRuleAssociationsRequest =
      ListResolverRuleAssociationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listResolverRuleAssociationsResponse(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      resolverRuleAssociations: Option[List[ResolverRuleAssociation]] = None
    ): ListResolverRuleAssociationsResponse =
      ListResolverRuleAssociationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resolverRuleAssociations)(_.resolverRuleAssociations(_))
        .build

    def listResolverRulesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListResolverRulesRequest =
      ListResolverRulesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listResolverRulesResponse(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      resolverRules: Option[List[ResolverRule]] = None
    ): ListResolverRulesResponse =
      ListResolverRulesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resolverRules)(_.resolverRules(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def putFirewallRuleGroupPolicyRequest(
      arn: Option[String] = None,
      firewallRuleGroupPolicy: Option[String] = None
    ): PutFirewallRuleGroupPolicyRequest =
      PutFirewallRuleGroupPolicyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(firewallRuleGroupPolicy)(_.firewallRuleGroupPolicy(_))
        .build

    def putFirewallRuleGroupPolicyResponse(
      returnValue: Option[Boolean] = None
    ): PutFirewallRuleGroupPolicyResponse =
      PutFirewallRuleGroupPolicyResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .build

    def putResolverQueryLogConfigPolicyRequest(
      arn: Option[String] = None,
      resolverQueryLogConfigPolicy: Option[String] = None
    ): PutResolverQueryLogConfigPolicyRequest =
      PutResolverQueryLogConfigPolicyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(resolverQueryLogConfigPolicy)(_.resolverQueryLogConfigPolicy(_))
        .build

    def putResolverQueryLogConfigPolicyResponse(
      returnValue: Option[Boolean] = None
    ): PutResolverQueryLogConfigPolicyResponse =
      PutResolverQueryLogConfigPolicyResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .build

    def putResolverRulePolicyRequest(
      arn: Option[String] = None,
      resolverRulePolicy: Option[String] = None
    ): PutResolverRulePolicyRequest =
      PutResolverRulePolicyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(resolverRulePolicy)(_.resolverRulePolicy(_))
        .build

    def putResolverRulePolicyResponse(
      returnValue: Option[Boolean] = None
    ): PutResolverRulePolicyResponse =
      PutResolverRulePolicyResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .build

    def resolverDnssecConfig(
      id: Option[String] = None,
      ownerId: Option[String] = None,
      resourceId: Option[String] = None,
      validationStatus: Option[String] = None
    ): ResolverDnssecConfig =
      ResolverDnssecConfig
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(validationStatus)(_.validationStatus(_))
        .build

    def resolverEndpoint(
      id: Option[String] = None,
      creatorRequestId: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      securityGroupIds: Option[List[ResourceId]] = None,
      direction: Option[String] = None,
      ipAddressCount: Option[Int] = None,
      hostVPCId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      creationTime: Option[String] = None,
      modificationTime: Option[String] = None
    ): ResolverEndpoint =
      ResolverEndpoint
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(direction)(_.direction(_))
        .ifSome(ipAddressCount)(_.ipAddressCount(_))
        .ifSome(hostVPCId)(_.hostVPCId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modificationTime)(_.modificationTime(_))
        .build

    def resolverQueryLogConfig(
      id: Option[String] = None,
      ownerId: Option[String] = None,
      status: Option[String] = None,
      shareStatus: Option[String] = None,
      associationCount: Option[Int] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      destinationArn: Option[String] = None,
      creatorRequestId: Option[String] = None,
      creationTime: Option[String] = None
    ): ResolverQueryLogConfig =
      ResolverQueryLogConfig
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(status)(_.status(_))
        .ifSome(shareStatus)(_.shareStatus(_))
        .ifSome(associationCount)(_.associationCount(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def resolverQueryLogConfigAssociation(
      id: Option[String] = None,
      resolverQueryLogConfigId: Option[String] = None,
      resourceId: Option[String] = None,
      status: Option[String] = None,
      error: Option[String] = None,
      errorMessage: Option[String] = None,
      creationTime: Option[String] = None
    ): ResolverQueryLogConfigAssociation =
      ResolverQueryLogConfigAssociation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(resolverQueryLogConfigId)(_.resolverQueryLogConfigId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(status)(_.status(_))
        .ifSome(error)(_.error(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def resolverRule(
      id: Option[String] = None,
      creatorRequestId: Option[String] = None,
      arn: Option[String] = None,
      domainName: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      ruleType: Option[String] = None,
      name: Option[String] = None,
      targetIps: Option[List[TargetAddress]] = None,
      resolverEndpointId: Option[String] = None,
      ownerId: Option[String] = None,
      shareStatus: Option[String] = None,
      creationTime: Option[String] = None,
      modificationTime: Option[String] = None
    ): ResolverRule =
      ResolverRule
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(ruleType)(_.ruleType(_))
        .ifSome(name)(_.name(_))
        .ifSome(targetIps)(_.targetIps(_))
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(shareStatus)(_.shareStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modificationTime)(_.modificationTime(_))
        .build

    def resolverRuleAssociation(
      id: Option[String] = None,
      resolverRuleId: Option[String] = None,
      name: Option[String] = None,
      vPCId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): ResolverRuleAssociation =
      ResolverRuleAssociation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(resolverRuleId)(_.resolverRuleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(vPCId)(_.vPCId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def resolverRuleConfig(
      name: Option[String] = None,
      targetIps: Option[List[TargetAddress]] = None,
      resolverEndpointId: Option[String] = None
    ): ResolverRuleConfig =
      ResolverRuleConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(targetIps)(_.targetIps(_))
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .build

    def resourceExistsException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceExistsException =
      ResourceExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourceInUseException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourceUnavailableException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceUnavailableException =
      ResourceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
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

    def targetAddress(
      ip: Option[String] = None,
      port: Option[Int] = None
    ): TargetAddress =
      TargetAddress
        .builder
        .ifSome(ip)(_.ip(_))
        .ifSome(port)(_.port(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unknownResourceException(
      message: Option[String] = None
    ): UnknownResourceException =
      UnknownResourceException
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

    def updateFirewallConfigRequest(
      resourceId: Option[String] = None,
      firewallFailOpen: Option[String] = None
    ): UpdateFirewallConfigRequest =
      UpdateFirewallConfigRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(firewallFailOpen)(_.firewallFailOpen(_))
        .build

    def updateFirewallConfigResponse(
      firewallConfig: Option[FirewallConfig] = None
    ): UpdateFirewallConfigResponse =
      UpdateFirewallConfigResponse
        .builder
        .ifSome(firewallConfig)(_.firewallConfig(_))
        .build

    def updateFirewallDomainsRequest(
      firewallDomainListId: Option[String] = None,
      operation: Option[String] = None,
      domains: Option[List[FirewallDomainName]] = None
    ): UpdateFirewallDomainsRequest =
      UpdateFirewallDomainsRequest
        .builder
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(domains)(_.domains(_))
        .build

    def updateFirewallDomainsResponse(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): UpdateFirewallDomainsResponse =
      UpdateFirewallDomainsResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def updateFirewallRuleGroupAssociationRequest(
      firewallRuleGroupAssociationId: Option[String] = None,
      priority: Option[Int] = None,
      mutationProtection: Option[String] = None,
      name: Option[String] = None
    ): UpdateFirewallRuleGroupAssociationRequest =
      UpdateFirewallRuleGroupAssociationRequest
        .builder
        .ifSome(firewallRuleGroupAssociationId)(_.firewallRuleGroupAssociationId(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(mutationProtection)(_.mutationProtection(_))
        .ifSome(name)(_.name(_))
        .build

    def updateFirewallRuleGroupAssociationResponse(
      firewallRuleGroupAssociation: Option[FirewallRuleGroupAssociation] = None
    ): UpdateFirewallRuleGroupAssociationResponse =
      UpdateFirewallRuleGroupAssociationResponse
        .builder
        .ifSome(firewallRuleGroupAssociation)(_.firewallRuleGroupAssociation(_))
        .build

    def updateFirewallRuleRequest(
      firewallRuleGroupId: Option[String] = None,
      firewallDomainListId: Option[String] = None,
      priority: Option[Int] = None,
      action: Option[String] = None,
      blockResponse: Option[String] = None,
      blockOverrideDomain: Option[String] = None,
      blockOverrideDnsType: Option[String] = None,
      blockOverrideTtl: Option[Int] = None,
      name: Option[String] = None
    ): UpdateFirewallRuleRequest =
      UpdateFirewallRuleRequest
        .builder
        .ifSome(firewallRuleGroupId)(_.firewallRuleGroupId(_))
        .ifSome(firewallDomainListId)(_.firewallDomainListId(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(action)(_.action(_))
        .ifSome(blockResponse)(_.blockResponse(_))
        .ifSome(blockOverrideDomain)(_.blockOverrideDomain(_))
        .ifSome(blockOverrideDnsType)(_.blockOverrideDnsType(_))
        .ifSome(blockOverrideTtl)(_.blockOverrideTtl(_))
        .ifSome(name)(_.name(_))
        .build

    def updateFirewallRuleResponse(
      firewallRule: Option[FirewallRule] = None
    ): UpdateFirewallRuleResponse =
      UpdateFirewallRuleResponse
        .builder
        .ifSome(firewallRule)(_.firewallRule(_))
        .build

    def updateResolverDnssecConfigRequest(
      resourceId: Option[String] = None,
      validation: Option[String] = None
    ): UpdateResolverDnssecConfigRequest =
      UpdateResolverDnssecConfigRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(validation)(_.validation(_))
        .build

    def updateResolverDnssecConfigResponse(
      resolverDNSSECConfig: Option[ResolverDnssecConfig] = None
    ): UpdateResolverDnssecConfigResponse =
      UpdateResolverDnssecConfigResponse
        .builder
        .ifSome(resolverDNSSECConfig)(_.resolverDNSSECConfig(_))
        .build

    def updateResolverEndpointRequest(
      resolverEndpointId: Option[String] = None,
      name: Option[String] = None
    ): UpdateResolverEndpointRequest =
      UpdateResolverEndpointRequest
        .builder
        .ifSome(resolverEndpointId)(_.resolverEndpointId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateResolverEndpointResponse(
      resolverEndpoint: Option[ResolverEndpoint] = None
    ): UpdateResolverEndpointResponse =
      UpdateResolverEndpointResponse
        .builder
        .ifSome(resolverEndpoint)(_.resolverEndpoint(_))
        .build

    def updateResolverRuleRequest(
      resolverRuleId: Option[String] = None,
      config: Option[ResolverRuleConfig] = None
    ): UpdateResolverRuleRequest =
      UpdateResolverRuleRequest
        .builder
        .ifSome(resolverRuleId)(_.resolverRuleId(_))
        .ifSome(config)(_.config(_))
        .build

    def updateResolverRuleResponse(
      resolverRule: Option[ResolverRule] = None
    ): UpdateResolverRuleResponse =
      UpdateResolverRuleResponse
        .builder
        .ifSome(resolverRule)(_.resolverRule(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
