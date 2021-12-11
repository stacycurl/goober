package goober.hi

import goober.free.fms.FmsIO
import software.amazon.awssdk.services.fms.model._


object fms {
  import goober.free.{fms ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def app(
      appName: Option[String] = None,
      protocol: Option[String] = None,
      port: Option[IPPortNumber] = None
    ): App =
      App
        .builder
        .ifSome(appName)(_.appName(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(port)(_.port(_))
        .build

    def appsListData(
      listId: Option[String] = None,
      listName: Option[String] = None,
      listUpdateToken: Option[String] = None,
      createTime: Option[TimeStamp] = None,
      lastUpdateTime: Option[TimeStamp] = None,
      appsList: Option[List[App]] = None,
      previousAppsList: Option[PreviousAppsList] = None
    ): AppsListData =
      AppsListData
        .builder
        .ifSome(listId)(_.listId(_))
        .ifSome(listName)(_.listName(_))
        .ifSome(listUpdateToken)(_.listUpdateToken(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(appsList)(_.appsList(_))
        .ifSome(previousAppsList)(_.previousAppsList(_))
        .build

    def appsListDataSummary(
      listArn: Option[String] = None,
      listId: Option[String] = None,
      listName: Option[String] = None,
      appsList: Option[List[App]] = None
    ): AppsListDataSummary =
      AppsListDataSummary
        .builder
        .ifSome(listArn)(_.listArn(_))
        .ifSome(listId)(_.listId(_))
        .ifSome(listName)(_.listName(_))
        .ifSome(appsList)(_.appsList(_))
        .build

    def associateAdminAccountRequest(
      adminAccount: Option[String] = None
    ): AssociateAdminAccountRequest =
      AssociateAdminAccountRequest
        .builder
        .ifSome(adminAccount)(_.adminAccount(_))
        .build

    def awsEc2InstanceViolation(
      violationTarget: Option[String] = None,
      awsEc2NetworkInterfaceViolations: Option[List[AwsEc2NetworkInterfaceViolation]] = None
    ): AwsEc2InstanceViolation =
      AwsEc2InstanceViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(awsEc2NetworkInterfaceViolations)(_.awsEc2NetworkInterfaceViolations(_))
        .build

    def awsEc2NetworkInterfaceViolation(
      violationTarget: Option[String] = None,
      violatingSecurityGroups: Option[List[ResourceId]] = None
    ): AwsEc2NetworkInterfaceViolation =
      AwsEc2NetworkInterfaceViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(violatingSecurityGroups)(_.violatingSecurityGroups(_))
        .build

    def awsVPCSecurityGroupViolation(
      violationTarget: Option[String] = None,
      violationTargetDescription: Option[String] = None,
      partialMatches: Option[List[PartialMatch]] = None,
      possibleSecurityGroupRemediationActions: Option[List[SecurityGroupRemediationAction]] = None
    ): AwsVPCSecurityGroupViolation =
      AwsVPCSecurityGroupViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(violationTargetDescription)(_.violationTargetDescription(_))
        .ifSome(partialMatches)(_.partialMatches(_))
        .ifSome(possibleSecurityGroupRemediationActions)(_.possibleSecurityGroupRemediationActions(_))
        .build

    def complianceViolator(
      resourceId: Option[String] = None,
      violationReason: Option[String] = None,
      resourceType: Option[String] = None
    ): ComplianceViolator =
      ComplianceViolator
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(violationReason)(_.violationReason(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def deleteAppsListRequest(
      listId: Option[String] = None
    ): DeleteAppsListRequest =
      DeleteAppsListRequest
        .builder
        .ifSome(listId)(_.listId(_))
        .build

    def deleteNotificationChannelRequest(

    ): DeleteNotificationChannelRequest =
      DeleteNotificationChannelRequest
        .builder

        .build

    def deletePolicyRequest(
      policyId: Option[String] = None,
      deleteAllPolicyResources: Option[Boolean] = None
    ): DeletePolicyRequest =
      DeletePolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(deleteAllPolicyResources)(_.deleteAllPolicyResources(_))
        .build

    def deleteProtocolsListRequest(
      listId: Option[String] = None
    ): DeleteProtocolsListRequest =
      DeleteProtocolsListRequest
        .builder
        .ifSome(listId)(_.listId(_))
        .build

    def disassociateAdminAccountRequest(

    ): DisassociateAdminAccountRequest =
      DisassociateAdminAccountRequest
        .builder

        .build

    def dnsDuplicateRuleGroupViolation(
      violationTarget: Option[String] = None,
      violationTargetDescription: Option[String] = None
    ): DnsDuplicateRuleGroupViolation =
      DnsDuplicateRuleGroupViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(violationTargetDescription)(_.violationTargetDescription(_))
        .build

    def dnsRuleGroupLimitExceededViolation(
      violationTarget: Option[String] = None,
      violationTargetDescription: Option[String] = None,
      numberOfRuleGroupsAlreadyAssociated: Option[Int] = None
    ): DnsRuleGroupLimitExceededViolation =
      DnsRuleGroupLimitExceededViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(violationTargetDescription)(_.violationTargetDescription(_))
        .ifSome(numberOfRuleGroupsAlreadyAssociated)(_.numberOfRuleGroupsAlreadyAssociated(_))
        .build

    def dnsRuleGroupPriorityConflictViolation(
      violationTarget: Option[String] = None,
      violationTargetDescription: Option[String] = None,
      conflictingPriority: Option[Int] = None,
      conflictingPolicyId: Option[String] = None,
      unavailablePriorities: Option[List[DnsRuleGroupPriority]] = None
    ): DnsRuleGroupPriorityConflictViolation =
      DnsRuleGroupPriorityConflictViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(violationTargetDescription)(_.violationTargetDescription(_))
        .ifSome(conflictingPriority)(_.conflictingPriority(_))
        .ifSome(conflictingPolicyId)(_.conflictingPolicyId(_))
        .ifSome(unavailablePriorities)(_.unavailablePriorities(_))
        .build

    def getAdminAccountRequest(

    ): GetAdminAccountRequest =
      GetAdminAccountRequest
        .builder

        .build

    def getAdminAccountResponse(
      adminAccount: Option[String] = None,
      roleStatus: Option[String] = None
    ): GetAdminAccountResponse =
      GetAdminAccountResponse
        .builder
        .ifSome(adminAccount)(_.adminAccount(_))
        .ifSome(roleStatus)(_.roleStatus(_))
        .build

    def getAppsListRequest(
      listId: Option[String] = None,
      defaultList: Option[Boolean] = None
    ): GetAppsListRequest =
      GetAppsListRequest
        .builder
        .ifSome(listId)(_.listId(_))
        .ifSome(defaultList)(_.defaultList(_))
        .build

    def getAppsListResponse(
      appsList: Option[AppsListData] = None,
      appsListArn: Option[String] = None
    ): GetAppsListResponse =
      GetAppsListResponse
        .builder
        .ifSome(appsList)(_.appsList(_))
        .ifSome(appsListArn)(_.appsListArn(_))
        .build

    def getComplianceDetailRequest(
      policyId: Option[String] = None,
      memberAccount: Option[String] = None
    ): GetComplianceDetailRequest =
      GetComplianceDetailRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(memberAccount)(_.memberAccount(_))
        .build

    def getComplianceDetailResponse(
      policyComplianceDetail: Option[PolicyComplianceDetail] = None
    ): GetComplianceDetailResponse =
      GetComplianceDetailResponse
        .builder
        .ifSome(policyComplianceDetail)(_.policyComplianceDetail(_))
        .build

    def getNotificationChannelRequest(

    ): GetNotificationChannelRequest =
      GetNotificationChannelRequest
        .builder

        .build

    def getNotificationChannelResponse(
      snsTopicArn: Option[String] = None,
      snsRoleName: Option[String] = None
    ): GetNotificationChannelResponse =
      GetNotificationChannelResponse
        .builder
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(snsRoleName)(_.snsRoleName(_))
        .build

    def getPolicyRequest(
      policyId: Option[String] = None
    ): GetPolicyRequest =
      GetPolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .build

    def getPolicyResponse(
      policy: Option[Policy] = None,
      policyArn: Option[String] = None
    ): GetPolicyResponse =
      GetPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def getProtectionStatusRequest(
      policyId: Option[String] = None,
      memberAccountId: Option[String] = None,
      startTime: Option[TimeStamp] = None,
      endTime: Option[TimeStamp] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetProtectionStatusRequest =
      GetProtectionStatusRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(memberAccountId)(_.memberAccountId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getProtectionStatusResponse(
      adminAccountId: Option[String] = None,
      serviceType: Option[String] = None,
      data: Option[String] = None,
      nextToken: Option[String] = None
    ): GetProtectionStatusResponse =
      GetProtectionStatusResponse
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(data)(_.data(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getProtocolsListRequest(
      listId: Option[String] = None,
      defaultList: Option[Boolean] = None
    ): GetProtocolsListRequest =
      GetProtocolsListRequest
        .builder
        .ifSome(listId)(_.listId(_))
        .ifSome(defaultList)(_.defaultList(_))
        .build

    def getProtocolsListResponse(
      protocolsList: Option[ProtocolsListData] = None,
      protocolsListArn: Option[String] = None
    ): GetProtocolsListResponse =
      GetProtocolsListResponse
        .builder
        .ifSome(protocolsList)(_.protocolsList(_))
        .ifSome(protocolsListArn)(_.protocolsListArn(_))
        .build

    def getViolationDetailsRequest(
      policyId: Option[String] = None,
      memberAccount: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): GetViolationDetailsRequest =
      GetViolationDetailsRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(memberAccount)(_.memberAccount(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def getViolationDetailsResponse(
      violationDetail: Option[ViolationDetail] = None
    ): GetViolationDetailsResponse =
      GetViolationDetailsResponse
        .builder
        .ifSome(violationDetail)(_.violationDetail(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
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

    def invalidTypeException(
      message: Option[String] = None
    ): InvalidTypeException =
      InvalidTypeException
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

    def listAppsListsRequest(
      defaultLists: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAppsListsRequest =
      ListAppsListsRequest
        .builder
        .ifSome(defaultLists)(_.defaultLists(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAppsListsResponse(
      appsLists: Option[List[AppsListDataSummary]] = None,
      nextToken: Option[String] = None
    ): ListAppsListsResponse =
      ListAppsListsResponse
        .builder
        .ifSome(appsLists)(_.appsLists(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComplianceStatusRequest(
      policyId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListComplianceStatusRequest =
      ListComplianceStatusRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listComplianceStatusResponse(
      policyComplianceStatusList: Option[List[PolicyComplianceStatus]] = None,
      nextToken: Option[String] = None
    ): ListComplianceStatusResponse =
      ListComplianceStatusResponse
        .builder
        .ifSome(policyComplianceStatusList)(_.policyComplianceStatusList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMemberAccountsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMemberAccountsRequest =
      ListMemberAccountsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMemberAccountsResponse(
      memberAccounts: Option[List[AWSAccountId]] = None,
      nextToken: Option[String] = None
    ): ListMemberAccountsResponse =
      ListMemberAccountsResponse
        .builder
        .ifSome(memberAccounts)(_.memberAccounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPoliciesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPoliciesRequest =
      ListPoliciesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPoliciesResponse(
      policyList: Option[List[PolicySummary]] = None,
      nextToken: Option[String] = None
    ): ListPoliciesResponse =
      ListPoliciesResponse
        .builder
        .ifSome(policyList)(_.policyList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProtocolsListsRequest(
      defaultLists: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProtocolsListsRequest =
      ListProtocolsListsRequest
        .builder
        .ifSome(defaultLists)(_.defaultLists(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProtocolsListsResponse(
      protocolsLists: Option[List[ProtocolsListDataSummary]] = None,
      nextToken: Option[String] = None
    ): ListProtocolsListsResponse =
      ListProtocolsListsResponse
        .builder
        .ifSome(protocolsLists)(_.protocolsLists(_))
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
      tagList: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tagList)(_.tagList(_))
        .build

    def networkFirewallMissingExpectedRTViolation(
      violationTarget: Option[String] = None,
      vPC: Option[String] = None,
      availabilityZone: Option[String] = None,
      currentRouteTable: Option[String] = None,
      expectedRouteTable: Option[String] = None
    ): NetworkFirewallMissingExpectedRTViolation =
      NetworkFirewallMissingExpectedRTViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(vPC)(_.vPC(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(currentRouteTable)(_.currentRouteTable(_))
        .ifSome(expectedRouteTable)(_.expectedRouteTable(_))
        .build

    def networkFirewallMissingFirewallViolation(
      violationTarget: Option[String] = None,
      vPC: Option[String] = None,
      availabilityZone: Option[String] = None,
      targetViolationReason: Option[String] = None
    ): NetworkFirewallMissingFirewallViolation =
      NetworkFirewallMissingFirewallViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(vPC)(_.vPC(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(targetViolationReason)(_.targetViolationReason(_))
        .build

    def networkFirewallMissingSubnetViolation(
      violationTarget: Option[String] = None,
      vPC: Option[String] = None,
      availabilityZone: Option[String] = None,
      targetViolationReason: Option[String] = None
    ): NetworkFirewallMissingSubnetViolation =
      NetworkFirewallMissingSubnetViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(vPC)(_.vPC(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(targetViolationReason)(_.targetViolationReason(_))
        .build

    def networkFirewallPolicyDescription(
      statelessRuleGroups: Option[List[StatelessRuleGroup]] = None,
      statelessDefaultActions: Option[List[NetworkFirewallAction]] = None,
      statelessFragmentDefaultActions: Option[List[NetworkFirewallAction]] = None,
      statelessCustomActions: Option[List[NetworkFirewallAction]] = None,
      statefulRuleGroups: Option[List[StatefulRuleGroup]] = None
    ): NetworkFirewallPolicyDescription =
      NetworkFirewallPolicyDescription
        .builder
        .ifSome(statelessRuleGroups)(_.statelessRuleGroups(_))
        .ifSome(statelessDefaultActions)(_.statelessDefaultActions(_))
        .ifSome(statelessFragmentDefaultActions)(_.statelessFragmentDefaultActions(_))
        .ifSome(statelessCustomActions)(_.statelessCustomActions(_))
        .ifSome(statefulRuleGroups)(_.statefulRuleGroups(_))
        .build

    def networkFirewallPolicyModifiedViolation(
      violationTarget: Option[String] = None,
      currentPolicyDescription: Option[NetworkFirewallPolicyDescription] = None,
      expectedPolicyDescription: Option[NetworkFirewallPolicyDescription] = None
    ): NetworkFirewallPolicyModifiedViolation =
      NetworkFirewallPolicyModifiedViolation
        .builder
        .ifSome(violationTarget)(_.violationTarget(_))
        .ifSome(currentPolicyDescription)(_.currentPolicyDescription(_))
        .ifSome(expectedPolicyDescription)(_.expectedPolicyDescription(_))
        .build

    def partialMatch(
      reference: Option[String] = None,
      targetViolationReasons: Option[List[TargetViolationReason]] = None
    ): PartialMatch =
      PartialMatch
        .builder
        .ifSome(reference)(_.reference(_))
        .ifSome(targetViolationReasons)(_.targetViolationReasons(_))
        .build

    def policy(
      policyId: Option[String] = None,
      policyName: Option[String] = None,
      policyUpdateToken: Option[String] = None,
      securityServicePolicyData: Option[SecurityServicePolicyData] = None,
      resourceType: Option[String] = None,
      resourceTypeList: Option[List[ResourceType]] = None,
      resourceTags: Option[List[ResourceTag]] = None,
      excludeResourceTags: Option[Boolean] = None,
      remediationEnabled: Option[Boolean] = None,
      includeMap: Option[CustomerPolicyScopeMap] = None,
      excludeMap: Option[CustomerPolicyScopeMap] = None
    ): Policy =
      Policy
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyUpdateToken)(_.policyUpdateToken(_))
        .ifSome(securityServicePolicyData)(_.securityServicePolicyData(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceTypeList)(_.resourceTypeList(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(excludeResourceTags)(_.excludeResourceTags(_))
        .ifSome(remediationEnabled)(_.remediationEnabled(_))
        .ifSome(includeMap)(_.includeMap(_))
        .ifSome(excludeMap)(_.excludeMap(_))
        .build

    def policyComplianceDetail(
      policyOwner: Option[String] = None,
      policyId: Option[String] = None,
      memberAccount: Option[String] = None,
      violators: Option[List[ComplianceViolator]] = None,
      evaluationLimitExceeded: Option[Boolean] = None,
      expiredAt: Option[TimeStamp] = None,
      issueInfoMap: Option[IssueInfoMap] = None
    ): PolicyComplianceDetail =
      PolicyComplianceDetail
        .builder
        .ifSome(policyOwner)(_.policyOwner(_))
        .ifSome(policyId)(_.policyId(_))
        .ifSome(memberAccount)(_.memberAccount(_))
        .ifSome(violators)(_.violators(_))
        .ifSome(evaluationLimitExceeded)(_.evaluationLimitExceeded(_))
        .ifSome(expiredAt)(_.expiredAt(_))
        .ifSome(issueInfoMap)(_.issueInfoMap(_))
        .build

    def policyComplianceStatus(
      policyOwner: Option[String] = None,
      policyId: Option[String] = None,
      policyName: Option[String] = None,
      memberAccount: Option[String] = None,
      evaluationResults: Option[List[EvaluationResult]] = None,
      lastUpdated: Option[TimeStamp] = None,
      issueInfoMap: Option[IssueInfoMap] = None
    ): PolicyComplianceStatus =
      PolicyComplianceStatus
        .builder
        .ifSome(policyOwner)(_.policyOwner(_))
        .ifSome(policyId)(_.policyId(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(memberAccount)(_.memberAccount(_))
        .ifSome(evaluationResults)(_.evaluationResults(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(issueInfoMap)(_.issueInfoMap(_))
        .build

    def policySummary(
      policyArn: Option[String] = None,
      policyId: Option[String] = None,
      policyName: Option[String] = None,
      resourceType: Option[String] = None,
      securityServiceType: Option[String] = None,
      remediationEnabled: Option[Boolean] = None
    ): PolicySummary =
      PolicySummary
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(policyId)(_.policyId(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(securityServiceType)(_.securityServiceType(_))
        .ifSome(remediationEnabled)(_.remediationEnabled(_))
        .build

    def protocolsListData(
      listId: Option[String] = None,
      listName: Option[String] = None,
      listUpdateToken: Option[String] = None,
      createTime: Option[TimeStamp] = None,
      lastUpdateTime: Option[TimeStamp] = None,
      protocolsList: Option[List[Protocol]] = None,
      previousProtocolsList: Option[PreviousProtocolsList] = None
    ): ProtocolsListData =
      ProtocolsListData
        .builder
        .ifSome(listId)(_.listId(_))
        .ifSome(listName)(_.listName(_))
        .ifSome(listUpdateToken)(_.listUpdateToken(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(protocolsList)(_.protocolsList(_))
        .ifSome(previousProtocolsList)(_.previousProtocolsList(_))
        .build

    def protocolsListDataSummary(
      listArn: Option[String] = None,
      listId: Option[String] = None,
      listName: Option[String] = None,
      protocolsList: Option[List[Protocol]] = None
    ): ProtocolsListDataSummary =
      ProtocolsListDataSummary
        .builder
        .ifSome(listArn)(_.listArn(_))
        .ifSome(listId)(_.listId(_))
        .ifSome(listName)(_.listName(_))
        .ifSome(protocolsList)(_.protocolsList(_))
        .build

    def putAppsListRequest(
      appsList: Option[AppsListData] = None,
      tagList: Option[List[Tag]] = None
    ): PutAppsListRequest =
      PutAppsListRequest
        .builder
        .ifSome(appsList)(_.appsList(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def putAppsListResponse(
      appsList: Option[AppsListData] = None,
      appsListArn: Option[String] = None
    ): PutAppsListResponse =
      PutAppsListResponse
        .builder
        .ifSome(appsList)(_.appsList(_))
        .ifSome(appsListArn)(_.appsListArn(_))
        .build

    def putNotificationChannelRequest(
      snsTopicArn: Option[String] = None,
      snsRoleName: Option[String] = None
    ): PutNotificationChannelRequest =
      PutNotificationChannelRequest
        .builder
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(snsRoleName)(_.snsRoleName(_))
        .build

    def putPolicyRequest(
      policy: Option[Policy] = None,
      tagList: Option[List[Tag]] = None
    ): PutPolicyRequest =
      PutPolicyRequest
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def putPolicyResponse(
      policy: Option[Policy] = None,
      policyArn: Option[String] = None
    ): PutPolicyResponse =
      PutPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def putProtocolsListRequest(
      protocolsList: Option[ProtocolsListData] = None,
      tagList: Option[List[Tag]] = None
    ): PutProtocolsListRequest =
      PutProtocolsListRequest
        .builder
        .ifSome(protocolsList)(_.protocolsList(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def putProtocolsListResponse(
      protocolsList: Option[ProtocolsListData] = None,
      protocolsListArn: Option[String] = None
    ): PutProtocolsListResponse =
      PutProtocolsListResponse
        .builder
        .ifSome(protocolsList)(_.protocolsList(_))
        .ifSome(protocolsListArn)(_.protocolsListArn(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceTag(
      key: Option[String] = None,
      value: Option[String] = None
    ): ResourceTag =
      ResourceTag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def resourceViolation(
      awsVPCSecurityGroupViolation: Option[AwsVPCSecurityGroupViolation] = None,
      awsEc2NetworkInterfaceViolation: Option[AwsEc2NetworkInterfaceViolation] = None,
      awsEc2InstanceViolation: Option[AwsEc2InstanceViolation] = None,
      networkFirewallMissingFirewallViolation: Option[NetworkFirewallMissingFirewallViolation] = None,
      networkFirewallMissingSubnetViolation: Option[NetworkFirewallMissingSubnetViolation] = None,
      networkFirewallMissingExpectedRTViolation: Option[NetworkFirewallMissingExpectedRTViolation] = None,
      networkFirewallPolicyModifiedViolation: Option[NetworkFirewallPolicyModifiedViolation] = None,
      dnsRuleGroupPriorityConflictViolation: Option[DnsRuleGroupPriorityConflictViolation] = None,
      dnsDuplicateRuleGroupViolation: Option[DnsDuplicateRuleGroupViolation] = None,
      dnsRuleGroupLimitExceededViolation: Option[DnsRuleGroupLimitExceededViolation] = None
    ): ResourceViolation =
      ResourceViolation
        .builder
        .ifSome(awsVPCSecurityGroupViolation)(_.awsVPCSecurityGroupViolation(_))
        .ifSome(awsEc2NetworkInterfaceViolation)(_.awsEc2NetworkInterfaceViolation(_))
        .ifSome(awsEc2InstanceViolation)(_.awsEc2InstanceViolation(_))
        .ifSome(networkFirewallMissingFirewallViolation)(_.networkFirewallMissingFirewallViolation(_))
        .ifSome(networkFirewallMissingSubnetViolation)(_.networkFirewallMissingSubnetViolation(_))
        .ifSome(networkFirewallMissingExpectedRTViolation)(_.networkFirewallMissingExpectedRTViolation(_))
        .ifSome(networkFirewallPolicyModifiedViolation)(_.networkFirewallPolicyModifiedViolation(_))
        .ifSome(dnsRuleGroupPriorityConflictViolation)(_.dnsRuleGroupPriorityConflictViolation(_))
        .ifSome(dnsDuplicateRuleGroupViolation)(_.dnsDuplicateRuleGroupViolation(_))
        .ifSome(dnsRuleGroupLimitExceededViolation)(_.dnsRuleGroupLimitExceededViolation(_))
        .build

    def securityGroupRemediationAction(
      remediationActionType: Option[String] = None,
      description: Option[String] = None,
      remediationResult: Option[SecurityGroupRuleDescription] = None,
      isDefaultAction: Option[Boolean] = None
    ): SecurityGroupRemediationAction =
      SecurityGroupRemediationAction
        .builder
        .ifSome(remediationActionType)(_.remediationActionType(_))
        .ifSome(description)(_.description(_))
        .ifSome(remediationResult)(_.remediationResult(_))
        .ifSome(isDefaultAction)(_.isDefaultAction(_))
        .build

    def securityGroupRuleDescription(
      iPV4Range: Option[String] = None,
      iPV6Range: Option[String] = None,
      prefixListId: Option[String] = None,
      protocol: Option[String] = None,
      fromPort: Option[IPPortNumber] = None,
      toPort: Option[IPPortNumber] = None
    ): SecurityGroupRuleDescription =
      SecurityGroupRuleDescription
        .builder
        .ifSome(iPV4Range)(_.iPV4Range(_))
        .ifSome(iPV6Range)(_.iPV6Range(_))
        .ifSome(prefixListId)(_.prefixListId(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .build

    def securityServicePolicyData(
      `type`: Option[String] = None,
      managedServiceData: Option[String] = None
    ): SecurityServicePolicyData =
      SecurityServicePolicyData
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(managedServiceData)(_.managedServiceData(_))
        .build

    def statefulRuleGroup(
      ruleGroupName: Option[String] = None,
      resourceId: Option[String] = None
    ): StatefulRuleGroup =
      StatefulRuleGroup
        .builder
        .ifSome(ruleGroupName)(_.ruleGroupName(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def statelessRuleGroup(
      ruleGroupName: Option[String] = None,
      resourceId: Option[String] = None,
      priority: Option[Int] = None
    ): StatelessRuleGroup =
      StatelessRuleGroup
        .builder
        .ifSome(ruleGroupName)(_.ruleGroupName(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(priority)(_.priority(_))
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
      tagList: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagList)(_.tagList(_))
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

    def violationDetail(
      policyId: Option[String] = None,
      memberAccount: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceViolations: Option[List[ResourceViolation]] = None,
      resourceTags: Option[List[Tag]] = None,
      resourceDescription: Option[String] = None
    ): ViolationDetail =
      ViolationDetail
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(memberAccount)(_.memberAccount(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceViolations)(_.resourceViolations(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(resourceDescription)(_.resourceDescription(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
