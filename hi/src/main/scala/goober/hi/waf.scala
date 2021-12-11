package goober.hi

import goober.free.waf.WafIO
import software.amazon.awssdk.services.waf.model._


object waf {
  import goober.free.{waf ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activatedRule(
      priority: Option[Int] = None,
      ruleId: Option[String] = None,
      action: Option[WafAction] = None,
      overrideAction: Option[WafOverrideAction] = None,
      `type`: Option[String] = None,
      excludedRules: Option[List[ExcludedRule]] = None
    ): ActivatedRule =
      ActivatedRule
        .builder
        .ifSome(priority)(_.priority(_))
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(action)(_.action(_))
        .ifSome(overrideAction)(_.overrideAction(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(excludedRules)(_.excludedRules(_))
        .build

    def byteMatchSet(
      byteMatchSetId: Option[String] = None,
      name: Option[String] = None,
      byteMatchTuples: Option[List[ByteMatchTuple]] = None
    ): ByteMatchSet =
      ByteMatchSet
        .builder
        .ifSome(byteMatchSetId)(_.byteMatchSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(byteMatchTuples)(_.byteMatchTuples(_))
        .build

    def byteMatchSetSummary(
      byteMatchSetId: Option[String] = None,
      name: Option[String] = None
    ): ByteMatchSetSummary =
      ByteMatchSetSummary
        .builder
        .ifSome(byteMatchSetId)(_.byteMatchSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def byteMatchSetUpdate(
      action: Option[String] = None,
      byteMatchTuple: Option[ByteMatchTuple] = None
    ): ByteMatchSetUpdate =
      ByteMatchSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(byteMatchTuple)(_.byteMatchTuple(_))
        .build

    def byteMatchTuple(
      fieldToMatch: Option[FieldToMatch] = None,
      targetString: Option[ByteMatchTargetString] = None,
      textTransformation: Option[String] = None,
      positionalConstraint: Option[String] = None
    ): ByteMatchTuple =
      ByteMatchTuple
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(targetString)(_.targetString(_))
        .ifSome(textTransformation)(_.textTransformation(_))
        .ifSome(positionalConstraint)(_.positionalConstraint(_))
        .build

    def createByteMatchSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateByteMatchSetRequest =
      CreateByteMatchSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createByteMatchSetResponse(
      byteMatchSet: Option[ByteMatchSet] = None,
      changeToken: Option[String] = None
    ): CreateByteMatchSetResponse =
      CreateByteMatchSetResponse
        .builder
        .ifSome(byteMatchSet)(_.byteMatchSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createGeoMatchSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateGeoMatchSetRequest =
      CreateGeoMatchSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createGeoMatchSetResponse(
      geoMatchSet: Option[GeoMatchSet] = None,
      changeToken: Option[String] = None
    ): CreateGeoMatchSetResponse =
      CreateGeoMatchSetResponse
        .builder
        .ifSome(geoMatchSet)(_.geoMatchSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createIPSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateIPSetRequest =
      CreateIPSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createIPSetResponse(
      iPSet: Option[IPSet] = None,
      changeToken: Option[String] = None
    ): CreateIPSetResponse =
      CreateIPSetResponse
        .builder
        .ifSome(iPSet)(_.iPSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createRateBasedRuleRequest(
      name: Option[String] = None,
      metricName: Option[String] = None,
      rateKey: Option[String] = None,
      rateLimit: Option[RateLimit] = None,
      changeToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateRateBasedRuleRequest =
      CreateRateBasedRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(rateKey)(_.rateKey(_))
        .ifSome(rateLimit)(_.rateLimit(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRateBasedRuleResponse(
      rule: Option[RateBasedRule] = None,
      changeToken: Option[String] = None
    ): CreateRateBasedRuleResponse =
      CreateRateBasedRuleResponse
        .builder
        .ifSome(rule)(_.rule(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createRegexMatchSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateRegexMatchSetRequest =
      CreateRegexMatchSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createRegexMatchSetResponse(
      regexMatchSet: Option[RegexMatchSet] = None,
      changeToken: Option[String] = None
    ): CreateRegexMatchSetResponse =
      CreateRegexMatchSetResponse
        .builder
        .ifSome(regexMatchSet)(_.regexMatchSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createRegexPatternSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateRegexPatternSetRequest =
      CreateRegexPatternSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createRegexPatternSetResponse(
      regexPatternSet: Option[RegexPatternSet] = None,
      changeToken: Option[String] = None
    ): CreateRegexPatternSetResponse =
      CreateRegexPatternSetResponse
        .builder
        .ifSome(regexPatternSet)(_.regexPatternSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createRuleGroupRequest(
      name: Option[String] = None,
      metricName: Option[String] = None,
      changeToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateRuleGroupRequest =
      CreateRuleGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRuleGroupResponse(
      ruleGroup: Option[RuleGroup] = None,
      changeToken: Option[String] = None
    ): CreateRuleGroupResponse =
      CreateRuleGroupResponse
        .builder
        .ifSome(ruleGroup)(_.ruleGroup(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createRuleRequest(
      name: Option[String] = None,
      metricName: Option[String] = None,
      changeToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateRuleRequest =
      CreateRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRuleResponse(
      rule: Option[Rule] = None,
      changeToken: Option[String] = None
    ): CreateRuleResponse =
      CreateRuleResponse
        .builder
        .ifSome(rule)(_.rule(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createSizeConstraintSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateSizeConstraintSetRequest =
      CreateSizeConstraintSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createSizeConstraintSetResponse(
      sizeConstraintSet: Option[SizeConstraintSet] = None,
      changeToken: Option[String] = None
    ): CreateSizeConstraintSetResponse =
      CreateSizeConstraintSetResponse
        .builder
        .ifSome(sizeConstraintSet)(_.sizeConstraintSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createSqlInjectionMatchSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateSqlInjectionMatchSetRequest =
      CreateSqlInjectionMatchSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createSqlInjectionMatchSetResponse(
      sqlInjectionMatchSet: Option[SqlInjectionMatchSet] = None,
      changeToken: Option[String] = None
    ): CreateSqlInjectionMatchSetResponse =
      CreateSqlInjectionMatchSetResponse
        .builder
        .ifSome(sqlInjectionMatchSet)(_.sqlInjectionMatchSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createWebACLMigrationStackRequest(
      webACLId: Option[String] = None,
      s3BucketName: Option[String] = None,
      ignoreUnsupportedType: Option[Boolean] = None
    ): CreateWebACLMigrationStackRequest =
      CreateWebACLMigrationStackRequest
        .builder
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(ignoreUnsupportedType)(_.ignoreUnsupportedType(_))
        .build

    def createWebACLMigrationStackResponse(
      s3ObjectUrl: Option[String] = None
    ): CreateWebACLMigrationStackResponse =
      CreateWebACLMigrationStackResponse
        .builder
        .ifSome(s3ObjectUrl)(_.s3ObjectUrl(_))
        .build

    def createWebACLRequest(
      name: Option[String] = None,
      metricName: Option[String] = None,
      defaultAction: Option[WafAction] = None,
      changeToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateWebACLRequest =
      CreateWebACLRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWebACLResponse(
      webACL: Option[WebACL] = None,
      changeToken: Option[String] = None
    ): CreateWebACLResponse =
      CreateWebACLResponse
        .builder
        .ifSome(webACL)(_.webACL(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createXssMatchSetRequest(
      name: Option[String] = None,
      changeToken: Option[String] = None
    ): CreateXssMatchSetRequest =
      CreateXssMatchSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def createXssMatchSetResponse(
      xssMatchSet: Option[XssMatchSet] = None,
      changeToken: Option[String] = None
    ): CreateXssMatchSetResponse =
      CreateXssMatchSetResponse
        .builder
        .ifSome(xssMatchSet)(_.xssMatchSet(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteByteMatchSetRequest(
      byteMatchSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteByteMatchSetRequest =
      DeleteByteMatchSetRequest
        .builder
        .ifSome(byteMatchSetId)(_.byteMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteByteMatchSetResponse(
      changeToken: Option[String] = None
    ): DeleteByteMatchSetResponse =
      DeleteByteMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteGeoMatchSetRequest(
      geoMatchSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteGeoMatchSetRequest =
      DeleteGeoMatchSetRequest
        .builder
        .ifSome(geoMatchSetId)(_.geoMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteGeoMatchSetResponse(
      changeToken: Option[String] = None
    ): DeleteGeoMatchSetResponse =
      DeleteGeoMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteIPSetRequest(
      iPSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteIPSetRequest =
      DeleteIPSetRequest
        .builder
        .ifSome(iPSetId)(_.iPSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteIPSetResponse(
      changeToken: Option[String] = None
    ): DeleteIPSetResponse =
      DeleteIPSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
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

    def deleteRateBasedRuleRequest(
      ruleId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteRateBasedRuleRequest =
      DeleteRateBasedRuleRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRateBasedRuleResponse(
      changeToken: Option[String] = None
    ): DeleteRateBasedRuleResponse =
      DeleteRateBasedRuleResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRegexMatchSetRequest(
      regexMatchSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteRegexMatchSetRequest =
      DeleteRegexMatchSetRequest
        .builder
        .ifSome(regexMatchSetId)(_.regexMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRegexMatchSetResponse(
      changeToken: Option[String] = None
    ): DeleteRegexMatchSetResponse =
      DeleteRegexMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRegexPatternSetRequest(
      regexPatternSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteRegexPatternSetRequest =
      DeleteRegexPatternSetRequest
        .builder
        .ifSome(regexPatternSetId)(_.regexPatternSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRegexPatternSetResponse(
      changeToken: Option[String] = None
    ): DeleteRegexPatternSetResponse =
      DeleteRegexPatternSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRuleGroupRequest(
      ruleGroupId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteRuleGroupRequest =
      DeleteRuleGroupRequest
        .builder
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRuleGroupResponse(
      changeToken: Option[String] = None
    ): DeleteRuleGroupResponse =
      DeleteRuleGroupResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRuleRequest(
      ruleId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteRuleRequest =
      DeleteRuleRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteRuleResponse(
      changeToken: Option[String] = None
    ): DeleteRuleResponse =
      DeleteRuleResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteSizeConstraintSetRequest(
      sizeConstraintSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteSizeConstraintSetRequest =
      DeleteSizeConstraintSetRequest
        .builder
        .ifSome(sizeConstraintSetId)(_.sizeConstraintSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteSizeConstraintSetResponse(
      changeToken: Option[String] = None
    ): DeleteSizeConstraintSetResponse =
      DeleteSizeConstraintSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteSqlInjectionMatchSetRequest(
      sqlInjectionMatchSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteSqlInjectionMatchSetRequest =
      DeleteSqlInjectionMatchSetRequest
        .builder
        .ifSome(sqlInjectionMatchSetId)(_.sqlInjectionMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteSqlInjectionMatchSetResponse(
      changeToken: Option[String] = None
    ): DeleteSqlInjectionMatchSetResponse =
      DeleteSqlInjectionMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteWebACLRequest(
      webACLId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteWebACLRequest =
      DeleteWebACLRequest
        .builder
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteWebACLResponse(
      changeToken: Option[String] = None
    ): DeleteWebACLResponse =
      DeleteWebACLResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteXssMatchSetRequest(
      xssMatchSetId: Option[String] = None,
      changeToken: Option[String] = None
    ): DeleteXssMatchSetRequest =
      DeleteXssMatchSetRequest
        .builder
        .ifSome(xssMatchSetId)(_.xssMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def deleteXssMatchSetResponse(
      changeToken: Option[String] = None
    ): DeleteXssMatchSetResponse =
      DeleteXssMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def excludedRule(
      ruleId: Option[String] = None
    ): ExcludedRule =
      ExcludedRule
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .build

    def fieldToMatch(
      `type`: Option[String] = None,
      data: Option[String] = None
    ): FieldToMatch =
      FieldToMatch
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(data)(_.data(_))
        .build

    def geoMatchConstraint(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): GeoMatchConstraint =
      GeoMatchConstraint
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def geoMatchSet(
      geoMatchSetId: Option[String] = None,
      name: Option[String] = None,
      geoMatchConstraints: Option[List[GeoMatchConstraint]] = None
    ): GeoMatchSet =
      GeoMatchSet
        .builder
        .ifSome(geoMatchSetId)(_.geoMatchSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(geoMatchConstraints)(_.geoMatchConstraints(_))
        .build

    def geoMatchSetSummary(
      geoMatchSetId: Option[String] = None,
      name: Option[String] = None
    ): GeoMatchSetSummary =
      GeoMatchSetSummary
        .builder
        .ifSome(geoMatchSetId)(_.geoMatchSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def geoMatchSetUpdate(
      action: Option[String] = None,
      geoMatchConstraint: Option[GeoMatchConstraint] = None
    ): GeoMatchSetUpdate =
      GeoMatchSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(geoMatchConstraint)(_.geoMatchConstraint(_))
        .build

    def getByteMatchSetRequest(
      byteMatchSetId: Option[String] = None
    ): GetByteMatchSetRequest =
      GetByteMatchSetRequest
        .builder
        .ifSome(byteMatchSetId)(_.byteMatchSetId(_))
        .build

    def getByteMatchSetResponse(
      byteMatchSet: Option[ByteMatchSet] = None
    ): GetByteMatchSetResponse =
      GetByteMatchSetResponse
        .builder
        .ifSome(byteMatchSet)(_.byteMatchSet(_))
        .build

    def getChangeTokenRequest(

    ): GetChangeTokenRequest =
      GetChangeTokenRequest
        .builder

        .build

    def getChangeTokenResponse(
      changeToken: Option[String] = None
    ): GetChangeTokenResponse =
      GetChangeTokenResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def getChangeTokenStatusRequest(
      changeToken: Option[String] = None
    ): GetChangeTokenStatusRequest =
      GetChangeTokenStatusRequest
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def getChangeTokenStatusResponse(
      changeTokenStatus: Option[String] = None
    ): GetChangeTokenStatusResponse =
      GetChangeTokenStatusResponse
        .builder
        .ifSome(changeTokenStatus)(_.changeTokenStatus(_))
        .build

    def getGeoMatchSetRequest(
      geoMatchSetId: Option[String] = None
    ): GetGeoMatchSetRequest =
      GetGeoMatchSetRequest
        .builder
        .ifSome(geoMatchSetId)(_.geoMatchSetId(_))
        .build

    def getGeoMatchSetResponse(
      geoMatchSet: Option[GeoMatchSet] = None
    ): GetGeoMatchSetResponse =
      GetGeoMatchSetResponse
        .builder
        .ifSome(geoMatchSet)(_.geoMatchSet(_))
        .build

    def getIPSetRequest(
      iPSetId: Option[String] = None
    ): GetIPSetRequest =
      GetIPSetRequest
        .builder
        .ifSome(iPSetId)(_.iPSetId(_))
        .build

    def getIPSetResponse(
      iPSet: Option[IPSet] = None
    ): GetIPSetResponse =
      GetIPSetResponse
        .builder
        .ifSome(iPSet)(_.iPSet(_))
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

    def getRateBasedRuleManagedKeysRequest(
      ruleId: Option[String] = None,
      nextMarker: Option[String] = None
    ): GetRateBasedRuleManagedKeysRequest =
      GetRateBasedRuleManagedKeysRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def getRateBasedRuleManagedKeysResponse(
      managedKeys: Option[List[ManagedKey]] = None,
      nextMarker: Option[String] = None
    ): GetRateBasedRuleManagedKeysResponse =
      GetRateBasedRuleManagedKeysResponse
        .builder
        .ifSome(managedKeys)(_.managedKeys(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def getRateBasedRuleRequest(
      ruleId: Option[String] = None
    ): GetRateBasedRuleRequest =
      GetRateBasedRuleRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .build

    def getRateBasedRuleResponse(
      rule: Option[RateBasedRule] = None
    ): GetRateBasedRuleResponse =
      GetRateBasedRuleResponse
        .builder
        .ifSome(rule)(_.rule(_))
        .build

    def getRegexMatchSetRequest(
      regexMatchSetId: Option[String] = None
    ): GetRegexMatchSetRequest =
      GetRegexMatchSetRequest
        .builder
        .ifSome(regexMatchSetId)(_.regexMatchSetId(_))
        .build

    def getRegexMatchSetResponse(
      regexMatchSet: Option[RegexMatchSet] = None
    ): GetRegexMatchSetResponse =
      GetRegexMatchSetResponse
        .builder
        .ifSome(regexMatchSet)(_.regexMatchSet(_))
        .build

    def getRegexPatternSetRequest(
      regexPatternSetId: Option[String] = None
    ): GetRegexPatternSetRequest =
      GetRegexPatternSetRequest
        .builder
        .ifSome(regexPatternSetId)(_.regexPatternSetId(_))
        .build

    def getRegexPatternSetResponse(
      regexPatternSet: Option[RegexPatternSet] = None
    ): GetRegexPatternSetResponse =
      GetRegexPatternSetResponse
        .builder
        .ifSome(regexPatternSet)(_.regexPatternSet(_))
        .build

    def getRuleGroupRequest(
      ruleGroupId: Option[String] = None
    ): GetRuleGroupRequest =
      GetRuleGroupRequest
        .builder
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .build

    def getRuleGroupResponse(
      ruleGroup: Option[RuleGroup] = None
    ): GetRuleGroupResponse =
      GetRuleGroupResponse
        .builder
        .ifSome(ruleGroup)(_.ruleGroup(_))
        .build

    def getRuleRequest(
      ruleId: Option[String] = None
    ): GetRuleRequest =
      GetRuleRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .build

    def getRuleResponse(
      rule: Option[Rule] = None
    ): GetRuleResponse =
      GetRuleResponse
        .builder
        .ifSome(rule)(_.rule(_))
        .build

    def getSampledRequestsRequest(
      webAclId: Option[String] = None,
      ruleId: Option[String] = None,
      timeWindow: Option[TimeWindow] = None,
      maxItems: Option[GetSampledRequestsMaxItems] = None
    ): GetSampledRequestsRequest =
      GetSampledRequestsRequest
        .builder
        .ifSome(webAclId)(_.webAclId(_))
        .ifSome(ruleId)(_.ruleId(_))
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

    def getSizeConstraintSetRequest(
      sizeConstraintSetId: Option[String] = None
    ): GetSizeConstraintSetRequest =
      GetSizeConstraintSetRequest
        .builder
        .ifSome(sizeConstraintSetId)(_.sizeConstraintSetId(_))
        .build

    def getSizeConstraintSetResponse(
      sizeConstraintSet: Option[SizeConstraintSet] = None
    ): GetSizeConstraintSetResponse =
      GetSizeConstraintSetResponse
        .builder
        .ifSome(sizeConstraintSet)(_.sizeConstraintSet(_))
        .build

    def getSqlInjectionMatchSetRequest(
      sqlInjectionMatchSetId: Option[String] = None
    ): GetSqlInjectionMatchSetRequest =
      GetSqlInjectionMatchSetRequest
        .builder
        .ifSome(sqlInjectionMatchSetId)(_.sqlInjectionMatchSetId(_))
        .build

    def getSqlInjectionMatchSetResponse(
      sqlInjectionMatchSet: Option[SqlInjectionMatchSet] = None
    ): GetSqlInjectionMatchSetResponse =
      GetSqlInjectionMatchSetResponse
        .builder
        .ifSome(sqlInjectionMatchSet)(_.sqlInjectionMatchSet(_))
        .build

    def getWebACLRequest(
      webACLId: Option[String] = None
    ): GetWebACLRequest =
      GetWebACLRequest
        .builder
        .ifSome(webACLId)(_.webACLId(_))
        .build

    def getWebACLResponse(
      webACL: Option[WebACL] = None
    ): GetWebACLResponse =
      GetWebACLResponse
        .builder
        .ifSome(webACL)(_.webACL(_))
        .build

    def getXssMatchSetRequest(
      xssMatchSetId: Option[String] = None
    ): GetXssMatchSetRequest =
      GetXssMatchSetRequest
        .builder
        .ifSome(xssMatchSetId)(_.xssMatchSetId(_))
        .build

    def getXssMatchSetResponse(
      xssMatchSet: Option[XssMatchSet] = None
    ): GetXssMatchSetResponse =
      GetXssMatchSetResponse
        .builder
        .ifSome(xssMatchSet)(_.xssMatchSet(_))
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
      iPSetId: Option[String] = None,
      name: Option[String] = None,
      iPSetDescriptors: Option[List[IPSetDescriptor]] = None
    ): IPSet =
      IPSet
        .builder
        .ifSome(iPSetId)(_.iPSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(iPSetDescriptors)(_.iPSetDescriptors(_))
        .build

    def iPSetDescriptor(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): IPSetDescriptor =
      IPSetDescriptor
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def iPSetSummary(
      iPSetId: Option[String] = None,
      name: Option[String] = None
    ): IPSetSummary =
      IPSetSummary
        .builder
        .ifSome(iPSetId)(_.iPSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def iPSetUpdate(
      action: Option[String] = None,
      iPSetDescriptor: Option[IPSetDescriptor] = None
    ): IPSetUpdate =
      IPSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(iPSetDescriptor)(_.iPSetDescriptor(_))
        .build

    def listActivatedRulesInRuleGroupRequest(
      ruleGroupId: Option[String] = None,
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListActivatedRulesInRuleGroupRequest =
      ListActivatedRulesInRuleGroupRequest
        .builder
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listActivatedRulesInRuleGroupResponse(
      nextMarker: Option[String] = None,
      activatedRules: Option[List[ActivatedRule]] = None
    ): ListActivatedRulesInRuleGroupResponse =
      ListActivatedRulesInRuleGroupResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(activatedRules)(_.activatedRules(_))
        .build

    def listByteMatchSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListByteMatchSetsRequest =
      ListByteMatchSetsRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listByteMatchSetsResponse(
      nextMarker: Option[String] = None,
      byteMatchSets: Option[List[ByteMatchSetSummary]] = None
    ): ListByteMatchSetsResponse =
      ListByteMatchSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(byteMatchSets)(_.byteMatchSets(_))
        .build

    def listGeoMatchSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListGeoMatchSetsRequest =
      ListGeoMatchSetsRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listGeoMatchSetsResponse(
      nextMarker: Option[String] = None,
      geoMatchSets: Option[List[GeoMatchSetSummary]] = None
    ): ListGeoMatchSetsResponse =
      ListGeoMatchSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(geoMatchSets)(_.geoMatchSets(_))
        .build

    def listIPSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListIPSetsRequest =
      ListIPSetsRequest
        .builder
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
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListLoggingConfigurationsRequest =
      ListLoggingConfigurationsRequest
        .builder
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

    def listRateBasedRulesRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListRateBasedRulesRequest =
      ListRateBasedRulesRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listRateBasedRulesResponse(
      nextMarker: Option[String] = None,
      rules: Option[List[RuleSummary]] = None
    ): ListRateBasedRulesResponse =
      ListRateBasedRulesResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(rules)(_.rules(_))
        .build

    def listRegexMatchSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListRegexMatchSetsRequest =
      ListRegexMatchSetsRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listRegexMatchSetsResponse(
      nextMarker: Option[String] = None,
      regexMatchSets: Option[List[RegexMatchSetSummary]] = None
    ): ListRegexMatchSetsResponse =
      ListRegexMatchSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(regexMatchSets)(_.regexMatchSets(_))
        .build

    def listRegexPatternSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListRegexPatternSetsRequest =
      ListRegexPatternSetsRequest
        .builder
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

    def listRuleGroupsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListRuleGroupsRequest =
      ListRuleGroupsRequest
        .builder
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

    def listRulesRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListRulesRequest =
      ListRulesRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listRulesResponse(
      nextMarker: Option[String] = None,
      rules: Option[List[RuleSummary]] = None
    ): ListRulesResponse =
      ListRulesResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(rules)(_.rules(_))
        .build

    def listSizeConstraintSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListSizeConstraintSetsRequest =
      ListSizeConstraintSetsRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listSizeConstraintSetsResponse(
      nextMarker: Option[String] = None,
      sizeConstraintSets: Option[List[SizeConstraintSetSummary]] = None
    ): ListSizeConstraintSetsResponse =
      ListSizeConstraintSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(sizeConstraintSets)(_.sizeConstraintSets(_))
        .build

    def listSqlInjectionMatchSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListSqlInjectionMatchSetsRequest =
      ListSqlInjectionMatchSetsRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listSqlInjectionMatchSetsResponse(
      nextMarker: Option[String] = None,
      sqlInjectionMatchSets: Option[List[SqlInjectionMatchSetSummary]] = None
    ): ListSqlInjectionMatchSetsResponse =
      ListSqlInjectionMatchSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(sqlInjectionMatchSets)(_.sqlInjectionMatchSets(_))
        .build

    def listSubscribedRuleGroupsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListSubscribedRuleGroupsRequest =
      ListSubscribedRuleGroupsRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listSubscribedRuleGroupsResponse(
      nextMarker: Option[String] = None,
      ruleGroups: Option[List[SubscribedRuleGroupSummary]] = None
    ): ListSubscribedRuleGroupsResponse =
      ListSubscribedRuleGroupsResponse
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
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListWebACLsRequest =
      ListWebACLsRequest
        .builder
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

    def listXssMatchSetsRequest(
      nextMarker: Option[String] = None,
      limit: Option[Int] = None
    ): ListXssMatchSetsRequest =
      ListXssMatchSetsRequest
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listXssMatchSetsResponse(
      nextMarker: Option[String] = None,
      xssMatchSets: Option[List[XssMatchSetSummary]] = None
    ): ListXssMatchSetsResponse =
      ListXssMatchSetsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(xssMatchSets)(_.xssMatchSets(_))
        .build

    def loggingConfiguration(
      resourceArn: Option[String] = None,
      logDestinationConfigs: Option[List[ResourceArn]] = None,
      redactedFields: Option[List[FieldToMatch]] = None
    ): LoggingConfiguration =
      LoggingConfiguration
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(logDestinationConfigs)(_.logDestinationConfigs(_))
        .ifSome(redactedFields)(_.redactedFields(_))
        .build

    def predicate(
      negated: Option[Boolean] = None,
      `type`: Option[String] = None,
      dataId: Option[String] = None
    ): Predicate =
      Predicate
        .builder
        .ifSome(negated)(_.negated(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(dataId)(_.dataId(_))
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

    def rateBasedRule(
      ruleId: Option[String] = None,
      name: Option[String] = None,
      metricName: Option[String] = None,
      matchPredicates: Option[List[Predicate]] = None,
      rateKey: Option[String] = None,
      rateLimit: Option[RateLimit] = None
    ): RateBasedRule =
      RateBasedRule
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(matchPredicates)(_.matchPredicates(_))
        .ifSome(rateKey)(_.rateKey(_))
        .ifSome(rateLimit)(_.rateLimit(_))
        .build

    def regexMatchSet(
      regexMatchSetId: Option[String] = None,
      name: Option[String] = None,
      regexMatchTuples: Option[List[RegexMatchTuple]] = None
    ): RegexMatchSet =
      RegexMatchSet
        .builder
        .ifSome(regexMatchSetId)(_.regexMatchSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(regexMatchTuples)(_.regexMatchTuples(_))
        .build

    def regexMatchSetSummary(
      regexMatchSetId: Option[String] = None,
      name: Option[String] = None
    ): RegexMatchSetSummary =
      RegexMatchSetSummary
        .builder
        .ifSome(regexMatchSetId)(_.regexMatchSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def regexMatchSetUpdate(
      action: Option[String] = None,
      regexMatchTuple: Option[RegexMatchTuple] = None
    ): RegexMatchSetUpdate =
      RegexMatchSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(regexMatchTuple)(_.regexMatchTuple(_))
        .build

    def regexMatchTuple(
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformation: Option[String] = None,
      regexPatternSetId: Option[String] = None
    ): RegexMatchTuple =
      RegexMatchTuple
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformation)(_.textTransformation(_))
        .ifSome(regexPatternSetId)(_.regexPatternSetId(_))
        .build

    def regexPatternSet(
      regexPatternSetId: Option[String] = None,
      name: Option[String] = None,
      regexPatternStrings: Option[List[RegexPatternString]] = None
    ): RegexPatternSet =
      RegexPatternSet
        .builder
        .ifSome(regexPatternSetId)(_.regexPatternSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(regexPatternStrings)(_.regexPatternStrings(_))
        .build

    def regexPatternSetSummary(
      regexPatternSetId: Option[String] = None,
      name: Option[String] = None
    ): RegexPatternSetSummary =
      RegexPatternSetSummary
        .builder
        .ifSome(regexPatternSetId)(_.regexPatternSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def regexPatternSetUpdate(
      action: Option[String] = None,
      regexPatternString: Option[String] = None
    ): RegexPatternSetUpdate =
      RegexPatternSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(regexPatternString)(_.regexPatternString(_))
        .build

    def rule(
      ruleId: Option[String] = None,
      name: Option[String] = None,
      metricName: Option[String] = None,
      predicates: Option[List[Predicate]] = None
    ): Rule =
      Rule
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(predicates)(_.predicates(_))
        .build

    def ruleGroup(
      ruleGroupId: Option[String] = None,
      name: Option[String] = None,
      metricName: Option[String] = None
    ): RuleGroup =
      RuleGroup
        .builder
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .build

    def ruleGroupSummary(
      ruleGroupId: Option[String] = None,
      name: Option[String] = None
    ): RuleGroupSummary =
      RuleGroupSummary
        .builder
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .ifSome(name)(_.name(_))
        .build

    def ruleGroupUpdate(
      action: Option[String] = None,
      activatedRule: Option[ActivatedRule] = None
    ): RuleGroupUpdate =
      RuleGroupUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(activatedRule)(_.activatedRule(_))
        .build

    def ruleSummary(
      ruleId: Option[String] = None,
      name: Option[String] = None
    ): RuleSummary =
      RuleSummary
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(name)(_.name(_))
        .build

    def ruleUpdate(
      action: Option[String] = None,
      predicate: Option[Predicate] = None
    ): RuleUpdate =
      RuleUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(predicate)(_.predicate(_))
        .build

    def sampledHTTPRequest(
      request: Option[HTTPRequest] = None,
      weight: Option[SampleWeight] = None,
      timestamp: Option[Timestamp] = None,
      action: Option[String] = None,
      ruleWithinRuleGroup: Option[String] = None
    ): SampledHTTPRequest =
      SampledHTTPRequest
        .builder
        .ifSome(request)(_.request(_))
        .ifSome(weight)(_.weight(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(action)(_.action(_))
        .ifSome(ruleWithinRuleGroup)(_.ruleWithinRuleGroup(_))
        .build

    def sizeConstraint(
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformation: Option[String] = None,
      comparisonOperator: Option[String] = None,
      size: Option[Size] = None
    ): SizeConstraint =
      SizeConstraint
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformation)(_.textTransformation(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(size)(_.size(_))
        .build

    def sizeConstraintSet(
      sizeConstraintSetId: Option[String] = None,
      name: Option[String] = None,
      sizeConstraints: Option[List[SizeConstraint]] = None
    ): SizeConstraintSet =
      SizeConstraintSet
        .builder
        .ifSome(sizeConstraintSetId)(_.sizeConstraintSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(sizeConstraints)(_.sizeConstraints(_))
        .build

    def sizeConstraintSetSummary(
      sizeConstraintSetId: Option[String] = None,
      name: Option[String] = None
    ): SizeConstraintSetSummary =
      SizeConstraintSetSummary
        .builder
        .ifSome(sizeConstraintSetId)(_.sizeConstraintSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def sizeConstraintSetUpdate(
      action: Option[String] = None,
      sizeConstraint: Option[SizeConstraint] = None
    ): SizeConstraintSetUpdate =
      SizeConstraintSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(sizeConstraint)(_.sizeConstraint(_))
        .build

    def sqlInjectionMatchSet(
      sqlInjectionMatchSetId: Option[String] = None,
      name: Option[String] = None,
      sqlInjectionMatchTuples: Option[List[SqlInjectionMatchTuple]] = None
    ): SqlInjectionMatchSet =
      SqlInjectionMatchSet
        .builder
        .ifSome(sqlInjectionMatchSetId)(_.sqlInjectionMatchSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(sqlInjectionMatchTuples)(_.sqlInjectionMatchTuples(_))
        .build

    def sqlInjectionMatchSetSummary(
      sqlInjectionMatchSetId: Option[String] = None,
      name: Option[String] = None
    ): SqlInjectionMatchSetSummary =
      SqlInjectionMatchSetSummary
        .builder
        .ifSome(sqlInjectionMatchSetId)(_.sqlInjectionMatchSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def sqlInjectionMatchSetUpdate(
      action: Option[String] = None,
      sqlInjectionMatchTuple: Option[SqlInjectionMatchTuple] = None
    ): SqlInjectionMatchSetUpdate =
      SqlInjectionMatchSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(sqlInjectionMatchTuple)(_.sqlInjectionMatchTuple(_))
        .build

    def sqlInjectionMatchTuple(
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformation: Option[String] = None
    ): SqlInjectionMatchTuple =
      SqlInjectionMatchTuple
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformation)(_.textTransformation(_))
        .build

    def subscribedRuleGroupSummary(
      ruleGroupId: Option[String] = None,
      name: Option[String] = None,
      metricName: Option[String] = None
    ): SubscribedRuleGroupSummary =
      SubscribedRuleGroupSummary
        .builder
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
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

    def updateByteMatchSetRequest(
      byteMatchSetId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[ByteMatchSetUpdate]] = None
    ): UpdateByteMatchSetRequest =
      UpdateByteMatchSetRequest
        .builder
        .ifSome(byteMatchSetId)(_.byteMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .build

    def updateByteMatchSetResponse(
      changeToken: Option[String] = None
    ): UpdateByteMatchSetResponse =
      UpdateByteMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateGeoMatchSetRequest(
      geoMatchSetId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[GeoMatchSetUpdate]] = None
    ): UpdateGeoMatchSetRequest =
      UpdateGeoMatchSetRequest
        .builder
        .ifSome(geoMatchSetId)(_.geoMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .build

    def updateGeoMatchSetResponse(
      changeToken: Option[String] = None
    ): UpdateGeoMatchSetResponse =
      UpdateGeoMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateIPSetRequest(
      iPSetId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[IPSetUpdate]] = None
    ): UpdateIPSetRequest =
      UpdateIPSetRequest
        .builder
        .ifSome(iPSetId)(_.iPSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .build

    def updateIPSetResponse(
      changeToken: Option[String] = None
    ): UpdateIPSetResponse =
      UpdateIPSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRateBasedRuleRequest(
      ruleId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[RuleUpdate]] = None,
      rateLimit: Option[RateLimit] = None
    ): UpdateRateBasedRuleRequest =
      UpdateRateBasedRuleRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .ifSome(rateLimit)(_.rateLimit(_))
        .build

    def updateRateBasedRuleResponse(
      changeToken: Option[String] = None
    ): UpdateRateBasedRuleResponse =
      UpdateRateBasedRuleResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRegexMatchSetRequest(
      regexMatchSetId: Option[String] = None,
      updates: Option[List[RegexMatchSetUpdate]] = None,
      changeToken: Option[String] = None
    ): UpdateRegexMatchSetRequest =
      UpdateRegexMatchSetRequest
        .builder
        .ifSome(regexMatchSetId)(_.regexMatchSetId(_))
        .ifSome(updates)(_.updates(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRegexMatchSetResponse(
      changeToken: Option[String] = None
    ): UpdateRegexMatchSetResponse =
      UpdateRegexMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRegexPatternSetRequest(
      regexPatternSetId: Option[String] = None,
      updates: Option[List[RegexPatternSetUpdate]] = None,
      changeToken: Option[String] = None
    ): UpdateRegexPatternSetRequest =
      UpdateRegexPatternSetRequest
        .builder
        .ifSome(regexPatternSetId)(_.regexPatternSetId(_))
        .ifSome(updates)(_.updates(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRegexPatternSetResponse(
      changeToken: Option[String] = None
    ): UpdateRegexPatternSetResponse =
      UpdateRegexPatternSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRuleGroupRequest(
      ruleGroupId: Option[String] = None,
      updates: Option[List[RuleGroupUpdate]] = None,
      changeToken: Option[String] = None
    ): UpdateRuleGroupRequest =
      UpdateRuleGroupRequest
        .builder
        .ifSome(ruleGroupId)(_.ruleGroupId(_))
        .ifSome(updates)(_.updates(_))
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRuleGroupResponse(
      changeToken: Option[String] = None
    ): UpdateRuleGroupResponse =
      UpdateRuleGroupResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateRuleRequest(
      ruleId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[RuleUpdate]] = None
    ): UpdateRuleRequest =
      UpdateRuleRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .build

    def updateRuleResponse(
      changeToken: Option[String] = None
    ): UpdateRuleResponse =
      UpdateRuleResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateSizeConstraintSetRequest(
      sizeConstraintSetId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[SizeConstraintSetUpdate]] = None
    ): UpdateSizeConstraintSetRequest =
      UpdateSizeConstraintSetRequest
        .builder
        .ifSome(sizeConstraintSetId)(_.sizeConstraintSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .build

    def updateSizeConstraintSetResponse(
      changeToken: Option[String] = None
    ): UpdateSizeConstraintSetResponse =
      UpdateSizeConstraintSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateSqlInjectionMatchSetRequest(
      sqlInjectionMatchSetId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[SqlInjectionMatchSetUpdate]] = None
    ): UpdateSqlInjectionMatchSetRequest =
      UpdateSqlInjectionMatchSetRequest
        .builder
        .ifSome(sqlInjectionMatchSetId)(_.sqlInjectionMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .build

    def updateSqlInjectionMatchSetResponse(
      changeToken: Option[String] = None
    ): UpdateSqlInjectionMatchSetResponse =
      UpdateSqlInjectionMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateWebACLRequest(
      webACLId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[WebACLUpdate]] = None,
      defaultAction: Option[WafAction] = None
    ): UpdateWebACLRequest =
      UpdateWebACLRequest
        .builder
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .build

    def updateWebACLResponse(
      changeToken: Option[String] = None
    ): UpdateWebACLResponse =
      UpdateWebACLResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def updateXssMatchSetRequest(
      xssMatchSetId: Option[String] = None,
      changeToken: Option[String] = None,
      updates: Option[List[XssMatchSetUpdate]] = None
    ): UpdateXssMatchSetRequest =
      UpdateXssMatchSetRequest
        .builder
        .ifSome(xssMatchSetId)(_.xssMatchSetId(_))
        .ifSome(changeToken)(_.changeToken(_))
        .ifSome(updates)(_.updates(_))
        .build

    def updateXssMatchSetResponse(
      changeToken: Option[String] = None
    ): UpdateXssMatchSetResponse =
      UpdateXssMatchSetResponse
        .builder
        .ifSome(changeToken)(_.changeToken(_))
        .build

    def wAFBadRequestException(
      message: Option[String] = None
    ): WAFBadRequestException =
      WAFBadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFDisallowedNameException(
      message: Option[String] = None
    ): WAFDisallowedNameException =
      WAFDisallowedNameException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFEntityMigrationException(
      message: Option[String] = None,
      migrationErrorType: Option[String] = None,
      migrationErrorReason: Option[String] = None
    ): WAFEntityMigrationException =
      WAFEntityMigrationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(migrationErrorType)(_.migrationErrorType(_))
        .ifSome(migrationErrorReason)(_.migrationErrorReason(_))
        .build

    def wAFInternalErrorException(
      message: Option[String] = None
    ): WAFInternalErrorException =
      WAFInternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFInvalidAccountException(

    ): WAFInvalidAccountException =
      WAFInvalidAccountException
        .builder

        .build

    def wAFInvalidOperationException(
      message: Option[String] = None
    ): WAFInvalidOperationException =
      WAFInvalidOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFInvalidParameterException(
      field: Option[String] = None,
      parameter: Option[String] = None,
      reason: Option[String] = None
    ): WAFInvalidParameterException =
      WAFInvalidParameterException
        .builder
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

    def wAFInvalidRegexPatternException(
      message: Option[String] = None
    ): WAFInvalidRegexPatternException =
      WAFInvalidRegexPatternException
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

    def wAFNonEmptyEntityException(
      message: Option[String] = None
    ): WAFNonEmptyEntityException =
      WAFNonEmptyEntityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wAFNonexistentContainerException(
      message: Option[String] = None
    ): WAFNonexistentContainerException =
      WAFNonexistentContainerException
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

    def wAFReferencedItemException(
      message: Option[String] = None
    ): WAFReferencedItemException =
      WAFReferencedItemException
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

    def wAFStaleDataException(
      message: Option[String] = None
    ): WAFStaleDataException =
      WAFStaleDataException
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

    def wafAction(
      `type`: Option[String] = None
    ): WafAction =
      WafAction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def wafOverrideAction(
      `type`: Option[String] = None
    ): WafOverrideAction =
      WafOverrideAction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def webACL(
      webACLId: Option[String] = None,
      name: Option[String] = None,
      metricName: Option[String] = None,
      defaultAction: Option[WafAction] = None,
      rules: Option[List[ActivatedRule]] = None,
      webACLArn: Option[String] = None
    ): WebACL =
      WebACL
        .builder
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(name)(_.name(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(webACLArn)(_.webACLArn(_))
        .build

    def webACLSummary(
      webACLId: Option[String] = None,
      name: Option[String] = None
    ): WebACLSummary =
      WebACLSummary
        .builder
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(name)(_.name(_))
        .build

    def webACLUpdate(
      action: Option[String] = None,
      activatedRule: Option[ActivatedRule] = None
    ): WebACLUpdate =
      WebACLUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(activatedRule)(_.activatedRule(_))
        .build

    def xssMatchSet(
      xssMatchSetId: Option[String] = None,
      name: Option[String] = None,
      xssMatchTuples: Option[List[XssMatchTuple]] = None
    ): XssMatchSet =
      XssMatchSet
        .builder
        .ifSome(xssMatchSetId)(_.xssMatchSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(xssMatchTuples)(_.xssMatchTuples(_))
        .build

    def xssMatchSetSummary(
      xssMatchSetId: Option[String] = None,
      name: Option[String] = None
    ): XssMatchSetSummary =
      XssMatchSetSummary
        .builder
        .ifSome(xssMatchSetId)(_.xssMatchSetId(_))
        .ifSome(name)(_.name(_))
        .build

    def xssMatchSetUpdate(
      action: Option[String] = None,
      xssMatchTuple: Option[XssMatchTuple] = None
    ): XssMatchSetUpdate =
      XssMatchSetUpdate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(xssMatchTuple)(_.xssMatchTuple(_))
        .build

    def xssMatchTuple(
      fieldToMatch: Option[FieldToMatch] = None,
      textTransformation: Option[String] = None
    ): XssMatchTuple =
      XssMatchTuple
        .builder
        .ifSome(fieldToMatch)(_.fieldToMatch(_))
        .ifSome(textTransformation)(_.textTransformation(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
