package goober.hi

import goober.free.wafv2.Wafv2IO
import software.amazon.awssdk.services.wafv2.model._


object wafv2 {
  import goober.free.{wafv2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def actionCondition(
      action: Option[String] = None
    ): ActionCondition =
      ActionCondition
        .builder
        .ifSome(action)(_.action(_))
        .build

    def all(

    ): All =
      All
        .builder

        .build

    def allQueryArguments(

    ): AllQueryArguments =
      AllQueryArguments
        .builder

        .build

    def allowAction(
      customRequestHandling: Option[CustomRequestHandling] = None
    ): AllowAction =
      AllowAction
        .builder
        .ifSome(customRequestHandling)(_.customRequestHandling(_))
        .build

    def andStatement(
      statements: Option[List[Statement]] = None
    ): AndStatement =
      AndStatement
        .builder
        .ifSome(statements)(_.statements(_))
        .build

    def associateWebACLRequest(
      webACLArn: Option[String] = None,
      resourceArn: Option[String] = None
    ): AssociateWebACLRequest =
      AssociateWebACLRequest
        .builder
        .ifSome(webACLArn)(_.webACLArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def associateWebACLResponse(

    ): AssociateWebACLResponse =
      AssociateWebACLResponse
        .builder

        .build

    def blockAction(
      customResponse: Option[CustomResponse] = None
    ): BlockAction =
      BlockAction
        .builder
        .ifSome(customResponse)(_.customResponse(_))
        .build

    def body(

    ): Body =
      Body
        .builder

        .build

    def byteMatchStatement(
      searchString: Option[SearchString] = None,
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformations: Option[List[TextTransformation]] = None,
      positionalConstraint: Option[String] = None
    ): ByteMatchStatement =
      ByteMatchStatement
        .builder
        .ifSome(searchString)(_.searchString(_))
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformations)(_.textTransformations(_))
        .ifSome(positionalConstraint)(_.positionalConstraint(_))
        .build

    def checkCapacityRequest(
      scope: Option[String] = None,
      rules: Option[List[Rule]] = None
    ): CheckCapacityRequest =
      CheckCapacityRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(rules)(_.rules(_))
        .build

    def checkCapacityResponse(
      capacity: Option[ConsumedCapacity] = None
    ): CheckCapacityResponse =
      CheckCapacityResponse
        .builder
        .ifSome(capacity)(_.capacity(_))
        .build

    def condition(
      actionCondition: Option[ActionCondition] = None,
      labelNameCondition: Option[LabelNameCondition] = None
    ): Condition =
      Condition
        .builder
        .ifSome(actionCondition)(_.actionCondition(_))
        .ifSome(labelNameCondition)(_.labelNameCondition(_))
        .build

    def countAction(
      customRequestHandling: Option[CustomRequestHandling] = None
    ): CountAction =
      CountAction
        .builder
        .ifSome(customRequestHandling)(_.customRequestHandling(_))
        .build

    def createIPSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      description: Option[String] = None,
      iPAddressVersion: Option[String] = None,
      addresses: Option[List[IPAddress]] = None,
      tags: Option[List[Tag]] = None
    ): CreateIPSetRequest =
      CreateIPSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(description)(_.description(_))
        .ifSome(iPAddressVersion)(_.iPAddressVersion(_))
        .ifSome(addresses)(_.addresses(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createIPSetResponse(
      summary: Option[IPSetSummary] = None
    ): CreateIPSetResponse =
      CreateIPSetResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def createRegexPatternSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      description: Option[String] = None,
      regularExpressionList: Option[List[Regex]] = None,
      tags: Option[List[Tag]] = None
    ): CreateRegexPatternSetRequest =
      CreateRegexPatternSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(description)(_.description(_))
        .ifSome(regularExpressionList)(_.regularExpressionList(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRegexPatternSetResponse(
      summary: Option[RegexPatternSetSummary] = None
    ): CreateRegexPatternSetResponse =
      CreateRegexPatternSetResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def createRuleGroupRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      capacity: Option[CapacityUnit] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      visibilityConfig: Option[VisibilityConfig] = None,
      tags: Option[List[Tag]] = None,
      customResponseBodies: Option[CustomResponseBodies] = None
    ): CreateRuleGroupRequest =
      CreateRuleGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(capacity)(_.capacity(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(customResponseBodies)(_.customResponseBodies(_))
        .build

    def createRuleGroupResponse(
      summary: Option[RuleGroupSummary] = None
    ): CreateRuleGroupResponse =
      CreateRuleGroupResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def createWebACLRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      defaultAction: Option[DefaultAction] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      visibilityConfig: Option[VisibilityConfig] = None,
      tags: Option[List[Tag]] = None,
      customResponseBodies: Option[CustomResponseBodies] = None
    ): CreateWebACLRequest =
      CreateWebACLRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(customResponseBodies)(_.customResponseBodies(_))
        .build

    def createWebACLResponse(
      summary: Option[WebACLSummary] = None
    ): CreateWebACLResponse =
      CreateWebACLResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def customHTTPHeader(
      name: Option[String] = None,
      value: Option[String] = None
    ): CustomHTTPHeader =
      CustomHTTPHeader
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def customRequestHandling(
      insertHeaders: Option[List[CustomHTTPHeader]] = None
    ): CustomRequestHandling =
      CustomRequestHandling
        .builder
        .ifSome(insertHeaders)(_.insertHeaders(_))
        .build

    def customResponse(
      responseCode: Option[Int] = None,
      customResponseBodyKey: Option[String] = None,
      responseHeaders: Option[List[CustomHTTPHeader]] = None
    ): CustomResponse =
      CustomResponse
        .builder
        .ifSome(responseCode)(_.responseCode(_))
        .ifSome(customResponseBodyKey)(_.customResponseBodyKey(_))
        .ifSome(responseHeaders)(_.responseHeaders(_))
        .build

    def customResponseBody(
      contentType: Option[String] = None,
      content: Option[String] = None
    ): CustomResponseBody =
      CustomResponseBody
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(content)(_.content(_))
        .build

    def defaultAction(
      block: Option[BlockAction] = None,
      allow: Option[AllowAction] = None
    ): DefaultAction =
      DefaultAction
        .builder
        .ifSome(block)(_.block(_))
        .ifSome(allow)(_.allow(_))
        .build

    def deleteFirewallManagerRuleGroupsRequest(
      webACLArn: Option[String] = None,
      webACLLockToken: Option[String] = None
    ): DeleteFirewallManagerRuleGroupsRequest =
      DeleteFirewallManagerRuleGroupsRequest
        .builder
        .ifSome(webACLArn)(_.webACLArn(_))
        .ifSome(webACLLockToken)(_.webACLLockToken(_))
        .build

    def deleteFirewallManagerRuleGroupsResponse(
      nextWebACLLockToken: Option[String] = None
    ): DeleteFirewallManagerRuleGroupsResponse =
      DeleteFirewallManagerRuleGroupsResponse
        .builder
        .ifSome(nextWebACLLockToken)(_.nextWebACLLockToken(_))
        .build

    def deleteIPSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      lockToken: Option[String] = None
    ): DeleteIPSetRequest =
      DeleteIPSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def deleteIPSetResponse(

    ): DeleteIPSetResponse =
      DeleteIPSetResponse
        .builder

        .build

    def deleteLoggingConfigurationRequest(
      resourceArn: Option[String] = None
    ): DeleteLoggingConfigurationRequest =
      DeleteLoggingConfigurationRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def deleteLoggingConfigurationResponse(

    ): DeleteLoggingConfigurationResponse =
      DeleteLoggingConfigurationResponse
        .builder

        .build

    def deletePermissionPolicyRequest(
      resourceArn: Option[String] = None
    ): DeletePermissionPolicyRequest =
      DeletePermissionPolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def deletePermissionPolicyResponse(

    ): DeletePermissionPolicyResponse =
      DeletePermissionPolicyResponse
        .builder

        .build

    def deleteRegexPatternSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      lockToken: Option[String] = None
    ): DeleteRegexPatternSetRequest =
      DeleteRegexPatternSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def deleteRegexPatternSetResponse(

    ): DeleteRegexPatternSetResponse =
      DeleteRegexPatternSetResponse
        .builder

        .build

    def deleteRuleGroupRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      lockToken: Option[String] = None
    ): DeleteRuleGroupRequest =
      DeleteRuleGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def deleteRuleGroupResponse(

    ): DeleteRuleGroupResponse =
      DeleteRuleGroupResponse
        .builder

        .build

    def deleteWebACLRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      lockToken: Option[String] = None
    ): DeleteWebACLRequest =
      DeleteWebACLRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def deleteWebACLResponse(

    ): DeleteWebACLResponse =
      DeleteWebACLResponse
        .builder

        .build

    def describeManagedRuleGroupRequest(
      vendorName: Option[String] = None,
      name: Option[String] = None,
      scope: Option[String] = None
    ): DescribeManagedRuleGroupRequest =
      DescribeManagedRuleGroupRequest
        .builder
        .ifSome(vendorName)(_.vendorName(_))
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .build

    def describeManagedRuleGroupResponse(
      capacity: Option[CapacityUnit] = None,
      rules: Option[List[RuleSummary]] = None,
      labelNamespace: Option[String] = None,
      availableLabels: Option[List[LabelSummary]] = None,
      consumedLabels: Option[List[LabelSummary]] = None
    ): DescribeManagedRuleGroupResponse =
      DescribeManagedRuleGroupResponse
        .builder
        .ifSome(capacity)(_.capacity(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(labelNamespace)(_.labelNamespace(_))
        .ifSome(availableLabels)(_.availableLabels(_))
        .ifSome(consumedLabels)(_.consumedLabels(_))
        .build

    def disassociateWebACLRequest(
      resourceArn: Option[String] = None
    ): DisassociateWebACLRequest =
      DisassociateWebACLRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def disassociateWebACLResponse(

    ): DisassociateWebACLResponse =
      DisassociateWebACLResponse
        .builder

        .build

    def excludedRule(
      name: Option[String] = None
    ): ExcludedRule =
      ExcludedRule
        .builder
        .ifSome(name)(_.name(_))
        .build

    def fieldToMatch(
      singleHeader: Option[SingleHeader] = None,
      singleQueryArgument: Option[SingleQueryArgument] = None,
      allQueryArguments: Option[AllQueryArguments] = None,
      uriPath: Option[UriPath] = None,
      queryString: Option[QueryString] = None,
      body: Option[Body] = None,
      method: Option[Method] = None,
      jsonBody: Option[JsonBody] = None
    ): FieldToMatch =
      FieldToMatch
        .builder
        .ifSome(singleHeader)(_.singleHeader(_))
        .ifSome(singleQueryArgument)(_.singleQueryArgument(_))
        .ifSome(allQueryArguments)(_.allQueryArguments(_))
        .ifSome(uriPath)(_.uriPath(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(body)(_.body(_))
        .ifSome(method)(_.method(_))
        .ifSome(jsonBody)(_.jsonBody(_))
        .build

    def filter(
      behavior: Option[String] = None,
      requirement: Option[String] = None,
      conditions: Option[List[Condition]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(behavior)(_.behavior(_))
        .ifSome(requirement)(_.requirement(_))
        .ifSome(conditions)(_.conditions(_))
        .build

    def firewallManagerRuleGroup(
      name: Option[String] = None,
      priority: Option[Int] = None,
      firewallManagerStatement: Option[FirewallManagerStatement] = None,
      overrideAction: Option[OverrideAction] = None,
      visibilityConfig: Option[VisibilityConfig] = None
    ): FirewallManagerRuleGroup =
      FirewallManagerRuleGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(firewallManagerStatement)(_.firewallManagerStatement(_))
        .ifSome(overrideAction)(_.overrideAction(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .build

    def firewallManagerStatement(
      managedRuleGroupStatement: Option[ManagedRuleGroupStatement] = None,
      ruleGroupReferenceStatement: Option[RuleGroupReferenceStatement] = None
    ): FirewallManagerStatement =
      FirewallManagerStatement
        .builder
        .ifSome(managedRuleGroupStatement)(_.managedRuleGroupStatement(_))
        .ifSome(ruleGroupReferenceStatement)(_.ruleGroupReferenceStatement(_))
        .build

    def forwardedIPConfig(
      headerName: Option[String] = None,
      fallbackBehavior: Option[String] = None
    ): ForwardedIPConfig =
      ForwardedIPConfig
        .builder
        .ifSome(headerName)(_.headerName(_))
        .ifSome(fallbackBehavior)(_.fallbackBehavior(_))
        .build

    def geoMatchStatement(
      countryCodes: Option[List[CountryCode]] = None,
      forwardedIPConfig: Option[ForwardedIPConfig] = None
    ): GeoMatchStatement =
      GeoMatchStatement
        .builder
        .ifSome(countryCodes)(_.countryCodes(_))
        .ifSome(forwardedIPConfig)(_.forwardedIPConfig(_))
        .build

    def getIPSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None
    ): GetIPSetRequest =
      GetIPSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .build

    def getIPSetResponse(
      iPSet: Option[IPSet] = None,
      lockToken: Option[String] = None
    ): GetIPSetResponse =
      GetIPSetResponse
        .builder
        .ifSome(iPSet)(_.iPSet(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def getLoggingConfigurationRequest(
      resourceArn: Option[String] = None
    ): GetLoggingConfigurationRequest =
      GetLoggingConfigurationRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getLoggingConfigurationResponse(
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): GetLoggingConfigurationResponse =
      GetLoggingConfigurationResponse
        .builder
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def getPermissionPolicyRequest(
      resourceArn: Option[String] = None
    ): GetPermissionPolicyRequest =
      GetPermissionPolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getPermissionPolicyResponse(
      policy: Option[String] = None
    ): GetPermissionPolicyResponse =
      GetPermissionPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getRateBasedStatementManagedKeysRequest(
      scope: Option[String] = None,
      webACLName: Option[String] = None,
      webACLId: Option[String] = None,
      ruleName: Option[String] = None
    ): GetRateBasedStatementManagedKeysRequest =
      GetRateBasedStatementManagedKeysRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(webACLName)(_.webACLName(_))
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def getRateBasedStatementManagedKeysResponse(
      managedKeysIPV4: Option[RateBasedStatementManagedKeysIPSet] = None,
      managedKeysIPV6: Option[RateBasedStatementManagedKeysIPSet] = None
    ): GetRateBasedStatementManagedKeysResponse =
      GetRateBasedStatementManagedKeysResponse
        .builder
        .ifSome(managedKeysIPV4)(_.managedKeysIPV4(_))
        .ifSome(managedKeysIPV6)(_.managedKeysIPV6(_))
        .build

    def getRegexPatternSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None
    ): GetRegexPatternSetRequest =
      GetRegexPatternSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .build

    def getRegexPatternSetResponse(
      regexPatternSet: Option[RegexPatternSet] = None,
      lockToken: Option[String] = None
    ): GetRegexPatternSetResponse =
      GetRegexPatternSetResponse
        .builder
        .ifSome(regexPatternSet)(_.regexPatternSet(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def getRuleGroupRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None
    ): GetRuleGroupRequest =
      GetRuleGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .build

    def getRuleGroupResponse(
      ruleGroup: Option[RuleGroup] = None,
      lockToken: Option[String] = None
    ): GetRuleGroupResponse =
      GetRuleGroupResponse
        .builder
        .ifSome(ruleGroup)(_.ruleGroup(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def getSampledRequestsRequest(
      webAclArn: Option[String] = None,
      ruleMetricName: Option[String] = None,
      scope: Option[String] = None,
      timeWindow: Option[TimeWindow] = None,
      maxItems: Option[ListMaxItems] = None
    ): GetSampledRequestsRequest =
      GetSampledRequestsRequest
        .builder
        .ifSome(webAclArn)(_.webAclArn(_))
        .ifSome(ruleMetricName)(_.ruleMetricName(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(timeWindow)(_.timeWindow(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def getSampledRequestsResponse(
      sampledRequests: Option[List[SampledHTTPRequest]] = None,
      populationSize: Option[PopulationSize] = None,
      timeWindow: Option[TimeWindow] = None
    ): GetSampledRequestsResponse =
      GetSampledRequestsResponse
        .builder
        .ifSome(sampledRequests)(_.sampledRequests(_))
        .ifSome(populationSize)(_.populationSize(_))
        .ifSome(timeWindow)(_.timeWindow(_))
        .build

    def getWebACLForResourceRequest(
      resourceArn: Option[String] = None
    ): GetWebACLForResourceRequest =
      GetWebACLForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getWebACLForResourceResponse(
      webACL: Option[WebACL] = None
    ): GetWebACLForResourceResponse =
      GetWebACLForResourceResponse
        .builder
        .ifSome(webACL)(_.webACL(_))
        .build

    def getWebACLRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None
    ): GetWebACLRequest =
      GetWebACLRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .build

    def getWebACLResponse(
      webACL: Option[WebACL] = None,
      lockToken: Option[String] = None
    ): GetWebACLResponse =
      GetWebACLResponse
        .builder
        .ifSome(webACL)(_.webACL(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def hTTPHeader(
      name: Option[String] = None,
      value: Option[String] = None
    ): HTTPHeader =
      HTTPHeader
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def hTTPRequest(
      clientIP: Option[String] = None,
      country: Option[String] = None,
      uRI: Option[String] = None,
      method: Option[String] = None,
      hTTPVersion: Option[String] = None,
      headers: Option[List[HTTPHeader]] = None
    ): HTTPRequest =
      HTTPRequest
        .builder
        .ifSome(clientIP)(_.clientIP(_))
        .ifSome(country)(_.country(_))
        .ifSome(uRI)(_.uRI(_))
        .ifSome(method)(_.method(_))
        .ifSome(hTTPVersion)(_.hTTPVersion(_))
        .ifSome(headers)(_.headers(_))
        .build

    def iPSet(
      name: Option[String] = None,
      id: Option[String] = None,
      aRN: Option[String] = None,
      description: Option[String] = None,
      iPAddressVersion: Option[String] = None,
      addresses: Option[List[IPAddress]] = None
    ): IPSet =
      IPSet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(description)(_.description(_))
        .ifSome(iPAddressVersion)(_.iPAddressVersion(_))
        .ifSome(addresses)(_.addresses(_))
        .build

    def iPSetForwardedIPConfig(
      headerName: Option[String] = None,
      fallbackBehavior: Option[String] = None,
      position: Option[String] = None
    ): IPSetForwardedIPConfig =
      IPSetForwardedIPConfig
        .builder
        .ifSome(headerName)(_.headerName(_))
        .ifSome(fallbackBehavior)(_.fallbackBehavior(_))
        .ifSome(position)(_.position(_))
        .build

    def iPSetReferenceStatement(
      aRN: Option[String] = None,
      iPSetForwardedIPConfig: Option[IPSetForwardedIPConfig] = None
    ): IPSetReferenceStatement =
      IPSetReferenceStatement
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(iPSetForwardedIPConfig)(_.iPSetForwardedIPConfig(_))
        .build

    def iPSetSummary(
      name: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      lockToken: Option[String] = None,
      aRN: Option[String] = None
    ): IPSetSummary =
      IPSetSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(lockToken)(_.lockToken(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def jsonBody(
      matchPattern: Option[JsonMatchPattern] = None,
      matchScope: Option[String] = None,
      invalidFallbackBehavior: Option[String] = None
    ): JsonBody =
      JsonBody
        .builder
        .ifSome(matchPattern)(_.matchPattern(_))
        .ifSome(matchScope)(_.matchScope(_))
        .ifSome(invalidFallbackBehavior)(_.invalidFallbackBehavior(_))
        .build

    def jsonMatchPattern(
      all: Option[All] = None,
      includedPaths: Option[List[JsonPointerPath]] = None
    ): JsonMatchPattern =
      JsonMatchPattern
        .builder
        .ifSome(all)(_.all(_))
        .ifSome(includedPaths)(_.includedPaths(_))
        .build

    def label(
      name: Option[String] = None
    ): Label =
      Label
        .builder
        .ifSome(name)(_.name(_))
        .build

    def labelMatchStatement(
      scope: Option[String] = None,
      key: Option[String] = None
    ): LabelMatchStatement =
      LabelMatchStatement
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(key)(_.key(_))
        .build

    def labelNameCondition(
      labelName: Option[String] = None
    ): LabelNameCondition =
      LabelNameCondition
        .builder
        .ifSome(labelName)(_.labelName(_))
        .build

    def labelSummary(
      name: Option[String] = None
    ): LabelSummary =
      LabelSummary
        .builder
        .ifSome(name)(_.name(_))
        .build

    def listAvailableManagedRuleGroupsRequest(
      scope: Option[String] = None,
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListAvailableManagedRuleGroupsRequest =
      ListAvailableManagedRuleGroupsRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listAvailableManagedRuleGroupsResponse(
      nextMarker: Option[String] = None,
      managedRuleGroups: Option[List[ManagedRuleGroupSummary]] = None
    ): ListAvailableManagedRuleGroupsResponse =
      ListAvailableManagedRuleGroupsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(managedRuleGroups)(_.managedRuleGroups(_))
        .build

    def listIPSetsRequest(
      scope: Option[String] = None,
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListIPSetsRequest =
      ListIPSetsRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listIPSetsResponse(
      nextMarker: Option[String] = None,
      iPSets: Option[List[IPSetSummary]] = None
    ): ListIPSetsResponse =
      ListIPSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(iPSets)(_.iPSets(_))
        .build

    def listLoggingConfigurationsRequest(
      scope: Option[String] = None,
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListLoggingConfigurationsRequest =
      ListLoggingConfigurationsRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listLoggingConfigurationsResponse(
      loggingConfigurations: Option[List[LoggingConfiguration]] = None,
      nextMarker: Option[String] = None
    ): ListLoggingConfigurationsResponse =
      ListLoggingConfigurationsResponse
        .builder
        .ifSome(loggingConfigurations)(_.loggingConfigurations(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listRegexPatternSetsRequest(
      scope: Option[String] = None,
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListRegexPatternSetsRequest =
      ListRegexPatternSetsRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listRegexPatternSetsResponse(
      nextMarker: Option[String] = None,
      regexPatternSets: Option[List[RegexPatternSetSummary]] = None
    ): ListRegexPatternSetsResponse =
      ListRegexPatternSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(regexPatternSets)(_.regexPatternSets(_))
        .build

    def listResourcesForWebACLRequest(
      webACLArn: Option[String] = None,
      resourceType: Option[String] = None
    ): ListResourcesForWebACLRequest =
      ListResourcesForWebACLRequest
        .builder
        .ifSome(webACLArn)(_.webACLArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def listResourcesForWebACLResponse(
      resourceArns: Option[List[ResourceArn]] = None
    ): ListResourcesForWebACLResponse =
      ListResourcesForWebACLResponse
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .build

    def listRuleGroupsRequest(
      scope: Option[String] = None,
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListRuleGroupsRequest =
      ListRuleGroupsRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listRuleGroupsResponse(
      nextMarker: Option[String] = None,
      ruleGroups: Option[List[RuleGroupSummary]] = None
    ): ListRuleGroupsResponse =
      ListRuleGroupsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(ruleGroups)(_.ruleGroups(_))
        .build

    def listTagsForResourceRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None,
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      nextMarker: Option[String] = None,
      tagInfoForResource: Option[TagInfoForResource] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(tagInfoForResource)(_.tagInfoForResource(_))
        .build

    def listWebACLsRequest(
      scope: Option[String] = None,
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListWebACLsRequest =
      ListWebACLsRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listWebACLsResponse(
      nextMarker: Option[String] = None,
      webACLs: Option[List[WebACLSummary]] = None
    ): ListWebACLsResponse =
      ListWebACLsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(webACLs)(_.webACLs(_))
        .build

    def loggingConfiguration(
      resourceArn: Option[String] = None,
      logDestinationConfigs: Option[List[ResourceArn]] = None,
      redactedFields: Option[List[FieldToMatch]] = None,
      managedByFirewallManager: Option[Boolean] = None,
      loggingFilter: Option[LoggingFilter] = None
    ): LoggingConfiguration =
      LoggingConfiguration
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(logDestinationConfigs)(_.logDestinationConfigs(_))
        .ifSome(redactedFields)(_.redactedFields(_))
        .ifSome(managedByFirewallManager)(_.managedByFirewallManager(_))
        .ifSome(loggingFilter)(_.loggingFilter(_))
        .build

    def loggingFilter(
      filters: Option[List[Filter]] = None,
      defaultBehavior: Option[String] = None
    ): LoggingFilter =
      LoggingFilter
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(defaultBehavior)(_.defaultBehavior(_))
        .build

    def managedRuleGroupStatement(
      vendorName: Option[String] = None,
      name: Option[String] = None,
      excludedRules: Option[List[ExcludedRule]] = None,
      scopeDownStatement: Option[Statement] = None
    ): ManagedRuleGroupStatement =
      ManagedRuleGroupStatement
        .builder
        .ifSome(vendorName)(_.vendorName(_))
        .ifSome(name)(_.name(_))
        .ifSome(excludedRules)(_.excludedRules(_))
        .ifSome(scopeDownStatement)(_.scopeDownStatement(_))
        .build

    def managedRuleGroupSummary(
      vendorName: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): ManagedRuleGroupSummary =
      ManagedRuleGroupSummary
        .builder
        .ifSome(vendorName)(_.vendorName(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def method(

    ): Method =
      Method
        .builder

        .build

    def noneAction(

    ): NoneAction =
      NoneAction
        .builder

        .build

    def notStatement(
      statement: Option[Statement] = None
    ): NotStatement =
      NotStatement
        .builder
        .ifSome(statement)(_.statement(_))
        .build

    def orStatement(
      statements: Option[List[Statement]] = None
    ): OrStatement =
      OrStatement
        .builder
        .ifSome(statements)(_.statements(_))
        .build

    def overrideAction(
      count: Option[CountAction] = None,
      none: Option[NoneAction] = None
    ): OverrideAction =
      OverrideAction
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(none)(_.none(_))
        .build

    def putLoggingConfigurationRequest(
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): PutLoggingConfigurationRequest =
      PutLoggingConfigurationRequest
        .builder
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def putLoggingConfigurationResponse(
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): PutLoggingConfigurationResponse =
      PutLoggingConfigurationResponse
        .builder
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def putPermissionPolicyRequest(
      resourceArn: Option[String] = None,
      policy: Option[String] = None
    ): PutPermissionPolicyRequest =
      PutPermissionPolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putPermissionPolicyResponse(

    ): PutPermissionPolicyResponse =
      PutPermissionPolicyResponse
        .builder

        .build

    def queryString(

    ): QueryString =
      QueryString
        .builder

        .build

    def rateBasedStatement(
      limit: Option[RateLimit] = None,
      aggregateKeyType: Option[String] = None,
      scopeDownStatement: Option[Statement] = None,
      forwardedIPConfig: Option[ForwardedIPConfig] = None
    ): RateBasedStatement =
      RateBasedStatement
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(aggregateKeyType)(_.aggregateKeyType(_))
        .ifSome(scopeDownStatement)(_.scopeDownStatement(_))
        .ifSome(forwardedIPConfig)(_.forwardedIPConfig(_))
        .build

    def rateBasedStatementManagedKeysIPSet(
      iPAddressVersion: Option[String] = None,
      addresses: Option[List[IPAddress]] = None
    ): RateBasedStatementManagedKeysIPSet =
      RateBasedStatementManagedKeysIPSet
        .builder
        .ifSome(iPAddressVersion)(_.iPAddressVersion(_))
        .ifSome(addresses)(_.addresses(_))
        .build

    def regex(
      regexString: Option[String] = None
    ): Regex =
      Regex
        .builder
        .ifSome(regexString)(_.regexString(_))
        .build

    def regexPatternSet(
      name: Option[String] = None,
      id: Option[String] = None,
      aRN: Option[String] = None,
      description: Option[String] = None,
      regularExpressionList: Option[List[Regex]] = None
    ): RegexPatternSet =
      RegexPatternSet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(description)(_.description(_))
        .ifSome(regularExpressionList)(_.regularExpressionList(_))
        .build

    def regexPatternSetReferenceStatement(
      aRN: Option[String] = None,
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformations: Option[List[TextTransformation]] = None
    ): RegexPatternSetReferenceStatement =
      RegexPatternSetReferenceStatement
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformations)(_.textTransformations(_))
        .build

    def regexPatternSetSummary(
      name: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      lockToken: Option[String] = None,
      aRN: Option[String] = None
    ): RegexPatternSetSummary =
      RegexPatternSetSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(lockToken)(_.lockToken(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def rule(
      name: Option[String] = None,
      priority: Option[Int] = None,
      statement: Option[Statement] = None,
      action: Option[RuleAction] = None,
      overrideAction: Option[OverrideAction] = None,
      ruleLabels: Option[List[Label]] = None,
      visibilityConfig: Option[VisibilityConfig] = None
    ): Rule =
      Rule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(statement)(_.statement(_))
        .ifSome(action)(_.action(_))
        .ifSome(overrideAction)(_.overrideAction(_))
        .ifSome(ruleLabels)(_.ruleLabels(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .build

    def ruleAction(
      block: Option[BlockAction] = None,
      allow: Option[AllowAction] = None,
      count: Option[CountAction] = None
    ): RuleAction =
      RuleAction
        .builder
        .ifSome(block)(_.block(_))
        .ifSome(allow)(_.allow(_))
        .ifSome(count)(_.count(_))
        .build

    def ruleGroup(
      name: Option[String] = None,
      id: Option[String] = None,
      capacity: Option[CapacityUnit] = None,
      aRN: Option[String] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      visibilityConfig: Option[VisibilityConfig] = None,
      labelNamespace: Option[String] = None,
      customResponseBodies: Option[CustomResponseBodies] = None,
      availableLabels: Option[List[LabelSummary]] = None,
      consumedLabels: Option[List[LabelSummary]] = None
    ): RuleGroup =
      RuleGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(capacity)(_.capacity(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .ifSome(labelNamespace)(_.labelNamespace(_))
        .ifSome(customResponseBodies)(_.customResponseBodies(_))
        .ifSome(availableLabels)(_.availableLabels(_))
        .ifSome(consumedLabels)(_.consumedLabels(_))
        .build

    def ruleGroupReferenceStatement(
      aRN: Option[String] = None,
      excludedRules: Option[List[ExcludedRule]] = None
    ): RuleGroupReferenceStatement =
      RuleGroupReferenceStatement
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(excludedRules)(_.excludedRules(_))
        .build

    def ruleGroupSummary(
      name: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      lockToken: Option[String] = None,
      aRN: Option[String] = None
    ): RuleGroupSummary =
      RuleGroupSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(lockToken)(_.lockToken(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def ruleSummary(
      name: Option[String] = None,
      action: Option[RuleAction] = None
    ): RuleSummary =
      RuleSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(action)(_.action(_))
        .build

    def sampledHTTPRequest(
      request: Option[HTTPRequest] = None,
      weight: Option[SampleWeight] = None,
      timestamp: Option[Timestamp] = None,
      action: Option[String] = None,
      ruleNameWithinRuleGroup: Option[String] = None,
      requestHeadersInserted: Option[List[HTTPHeader]] = None,
      responseCodeSent: Option[Int] = None,
      labels: Option[List[Label]] = None
    ): SampledHTTPRequest =
      SampledHTTPRequest
        .builder
        .ifSome(request)(_.request(_))
        .ifSome(weight)(_.weight(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(action)(_.action(_))
        .ifSome(ruleNameWithinRuleGroup)(_.ruleNameWithinRuleGroup(_))
        .ifSome(requestHeadersInserted)(_.requestHeadersInserted(_))
        .ifSome(responseCodeSent)(_.responseCodeSent(_))
        .ifSome(labels)(_.labels(_))
        .build

    def singleHeader(
      name: Option[String] = None
    ): SingleHeader =
      SingleHeader
        .builder
        .ifSome(name)(_.name(_))
        .build

    def singleQueryArgument(
      name: Option[String] = None
    ): SingleQueryArgument =
      SingleQueryArgument
        .builder
        .ifSome(name)(_.name(_))
        .build

    def sizeConstraintStatement(
      fieldToMatch: Option[FieldToMatch] = None,
      comparisonOperator: Option[String] = None,
      size: Option[Size] = None,
      textTransformations: Option[List[TextTransformation]] = None
    ): SizeConstraintStatement =
      SizeConstraintStatement
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(size)(_.size(_))
        .ifSome(textTransformations)(_.textTransformations(_))
        .build

    def sqliMatchStatement(
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformations: Option[List[TextTransformation]] = None
    ): SqliMatchStatement =
      SqliMatchStatement
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformations)(_.textTransformations(_))
        .build

    def statement(
      byteMatchStatement: Option[ByteMatchStatement] = None,
      sqliMatchStatement: Option[SqliMatchStatement] = None,
      xssMatchStatement: Option[XssMatchStatement] = None,
      sizeConstraintStatement: Option[SizeConstraintStatement] = None,
      geoMatchStatement: Option[GeoMatchStatement] = None,
      ruleGroupReferenceStatement: Option[RuleGroupReferenceStatement] = None,
      iPSetReferenceStatement: Option[IPSetReferenceStatement] = None,
      regexPatternSetReferenceStatement: Option[RegexPatternSetReferenceStatement] = None,
      rateBasedStatement: Option[RateBasedStatement] = None,
      andStatement: Option[AndStatement] = None,
      orStatement: Option[OrStatement] = None,
      notStatement: Option[NotStatement] = None,
      managedRuleGroupStatement: Option[ManagedRuleGroupStatement] = None,
      labelMatchStatement: Option[LabelMatchStatement] = None
    ): Statement =
      Statement
        .builder
        .ifSome(byteMatchStatement)(_.byteMatchStatement(_))
        .ifSome(sqliMatchStatement)(_.sqliMatchStatement(_))
        .ifSome(xssMatchStatement)(_.xssMatchStatement(_))
        .ifSome(sizeConstraintStatement)(_.sizeConstraintStatement(_))
        .ifSome(geoMatchStatement)(_.geoMatchStatement(_))
        .ifSome(ruleGroupReferenceStatement)(_.ruleGroupReferenceStatement(_))
        .ifSome(iPSetReferenceStatement)(_.iPSetReferenceStatement(_))
        .ifSome(regexPatternSetReferenceStatement)(_.regexPatternSetReferenceStatement(_))
        .ifSome(rateBasedStatement)(_.rateBasedStatement(_))
        .ifSome(andStatement)(_.andStatement(_))
        .ifSome(orStatement)(_.orStatement(_))
        .ifSome(notStatement)(_.notStatement(_))
        .ifSome(managedRuleGroupStatement)(_.managedRuleGroupStatement(_))
        .ifSome(labelMatchStatement)(_.labelMatchStatement(_))
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

    def tagInfoForResource(
      resourceARN: Option[String] = None,
      tagList: Option[List[Tag]] = None
    ): TagInfoForResource =
      TagInfoForResource
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def tagResourceRequest(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def textTransformation(
      priority: Option[Int] = None,
      `type`: Option[String] = None
    ): TextTransformation =
      TextTransformation
        .builder
        .ifSome(priority)(_.priority(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def timeWindow(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): TimeWindow =
      TimeWindow
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateIPSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      addresses: Option[List[IPAddress]] = None,
      lockToken: Option[String] = None
    ): UpdateIPSetRequest =
      UpdateIPSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(addresses)(_.addresses(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def updateIPSetResponse(
      nextLockToken: Option[String] = None
    ): UpdateIPSetResponse =
      UpdateIPSetResponse
        .builder
        .ifSome(nextLockToken)(_.nextLockToken(_))
        .build

    def updateRegexPatternSetRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      regularExpressionList: Option[List[Regex]] = None,
      lockToken: Option[String] = None
    ): UpdateRegexPatternSetRequest =
      UpdateRegexPatternSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(regularExpressionList)(_.regularExpressionList(_))
        .ifSome(lockToken)(_.lockToken(_))
        .build

    def updateRegexPatternSetResponse(
      nextLockToken: Option[String] = None
    ): UpdateRegexPatternSetResponse =
      UpdateRegexPatternSetResponse
        .builder
        .ifSome(nextLockToken)(_.nextLockToken(_))
        .build

    def updateRuleGroupRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      visibilityConfig: Option[VisibilityConfig] = None,
      lockToken: Option[String] = None,
      customResponseBodies: Option[CustomResponseBodies] = None
    ): UpdateRuleGroupRequest =
      UpdateRuleGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .ifSome(lockToken)(_.lockToken(_))
        .ifSome(customResponseBodies)(_.customResponseBodies(_))
        .build

    def updateRuleGroupResponse(
      nextLockToken: Option[String] = None
    ): UpdateRuleGroupResponse =
      UpdateRuleGroupResponse
        .builder
        .ifSome(nextLockToken)(_.nextLockToken(_))
        .build

    def updateWebACLRequest(
      name: Option[String] = None,
      scope: Option[String] = None,
      id: Option[String] = None,
      defaultAction: Option[DefaultAction] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      visibilityConfig: Option[VisibilityConfig] = None,
      lockToken: Option[String] = None,
      customResponseBodies: Option[CustomResponseBodies] = None
    ): UpdateWebACLRequest =
      UpdateWebACLRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(id)(_.id(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .ifSome(lockToken)(_.lockToken(_))
        .ifSome(customResponseBodies)(_.customResponseBodies(_))
        .build

    def updateWebACLResponse(
      nextLockToken: Option[String] = None
    ): UpdateWebACLResponse =
      UpdateWebACLResponse
        .builder
        .ifSome(nextLockToken)(_.nextLockToken(_))
        .build

    def uriPath(

    ): UriPath =
      UriPath
        .builder

        .build

    def visibilityConfig(
      sampledRequestsEnabled: Option[Boolean] = None,
      cloudWatchMetricsEnabled: Option[Boolean] = None,
      metricName: Option[String] = None
    ): VisibilityConfig =
      VisibilityConfig
        .builder
        .ifSome(sampledRequestsEnabled)(_.sampledRequestsEnabled(_))
        .ifSome(cloudWatchMetricsEnabled)(_.cloudWatchMetricsEnabled(_))
        .ifSome(metricName)(_.metricName(_))
        .build

    def wAFAssociatedItemException(
      message: Option[String] = None
    ): WAFAssociatedItemException =
      WAFAssociatedItemException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFDuplicateItemException(
      message: Option[String] = None
    ): WAFDuplicateItemException =
      WAFDuplicateItemException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFInternalErrorException(
      message: Option[String] = None
    ): WAFInternalErrorException =
      WAFInternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFInvalidOperationException(
      message: Option[String] = None
    ): WAFInvalidOperationException =
      WAFInvalidOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFInvalidParameterException(
      message: Option[String] = None,
      field: Option[String] = None,
      parameter: Option[String] = None,
      reason: Option[String] = None
    ): WAFInvalidParameterException =
      WAFInvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(field)(_.field(_))
        .ifSome(parameter)(_.parameter(_))
        .ifSome(reason)(_.reason(_))
        .build

    def wAFInvalidPermissionPolicyException(
      message: Option[String] = None
    ): WAFInvalidPermissionPolicyException =
      WAFInvalidPermissionPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFInvalidResourceException(
      message: Option[String] = None
    ): WAFInvalidResourceException =
      WAFInvalidResourceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFLimitsExceededException(
      message: Option[String] = None
    ): WAFLimitsExceededException =
      WAFLimitsExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFNonexistentItemException(
      message: Option[String] = None
    ): WAFNonexistentItemException =
      WAFNonexistentItemException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFOptimisticLockException(
      message: Option[String] = None
    ): WAFOptimisticLockException =
      WAFOptimisticLockException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFServiceLinkedRoleErrorException(
      message: Option[String] = None
    ): WAFServiceLinkedRoleErrorException =
      WAFServiceLinkedRoleErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFSubscriptionNotFoundException(
      message: Option[String] = None
    ): WAFSubscriptionNotFoundException =
      WAFSubscriptionNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFTagOperationException(
      message: Option[String] = None
    ): WAFTagOperationException =
      WAFTagOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFTagOperationInternalErrorException(
      message: Option[String] = None
    ): WAFTagOperationInternalErrorException =
      WAFTagOperationInternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFUnavailableEntityException(
      message: Option[String] = None
    ): WAFUnavailableEntityException =
      WAFUnavailableEntityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def webACL(
      name: Option[String] = None,
      id: Option[String] = None,
      aRN: Option[String] = None,
      defaultAction: Option[DefaultAction] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      visibilityConfig: Option[VisibilityConfig] = None,
      capacity: Option[ConsumedCapacity] = None,
      preProcessFirewallManagerRuleGroups: Option[List[FirewallManagerRuleGroup]] = None,
      postProcessFirewallManagerRuleGroups: Option[List[FirewallManagerRuleGroup]] = None,
      managedByFirewallManager: Option[Boolean] = None,
      labelNamespace: Option[String] = None,
      customResponseBodies: Option[CustomResponseBodies] = None
    ): WebACL =
      WebACL
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(visibilityConfig)(_.visibilityConfig(_))
        .ifSome(capacity)(_.capacity(_))
        .ifSome(preProcessFirewallManagerRuleGroups)(_.preProcessFirewallManagerRuleGroups(_))
        .ifSome(postProcessFirewallManagerRuleGroups)(_.postProcessFirewallManagerRuleGroups(_))
        .ifSome(managedByFirewallManager)(_.managedByFirewallManager(_))
        .ifSome(labelNamespace)(_.labelNamespace(_))
        .ifSome(customResponseBodies)(_.customResponseBodies(_))
        .build

    def webACLSummary(
      name: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      lockToken: Option[String] = None,
      aRN: Option[String] = None
    ): WebACLSummary =
      WebACLSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(lockToken)(_.lockToken(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def xssMatchStatement(
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformations: Option[List[TextTransformation]] = None
    ): XssMatchStatement =
      XssMatchStatement
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformations)(_.textTransformations(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
