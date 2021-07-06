package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.waf.regional.WafRegionalClient
import software.amazon.awssdk.services.waf.model._


object wafregional { module =>

  // Free monad over WafRegionalOp
  type WafRegionalIO[A] = FF[WafRegionalOp, A]

  sealed trait WafRegionalOp[A] {
    def visit[F[_]](visitor: WafRegionalOp.Visitor[F]): F[A]
  }

  object WafRegionalOp {
    // Given a WafRegionalClient we can embed a WafRegionalIO program in any algebra that understands embedding.
    implicit val WafRegionalOpEmbeddable: Embeddable[WafRegionalOp, WafRegionalClient] = new Embeddable[WafRegionalOp, WafRegionalClient] {
      def embed[A](client: WafRegionalClient, io: WafRegionalIO[A]): Embedded[A] = Embedded.WafRegional(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WafRegionalOp.Visitor[Kleisli[M, WafRegionalClient, *]] {
        def associateWebACL(
          request: AssociateWebAclRequest
        ): Kleisli[M, WafRegionalClient, AssociateWebAclResponse] =
          primitive(_.associateWebACL(request))

        def createByteMatchSet(
          request: CreateByteMatchSetRequest
        ): Kleisli[M, WafRegionalClient, CreateByteMatchSetResponse] =
          primitive(_.createByteMatchSet(request))

        def createGeoMatchSet(
          request: CreateGeoMatchSetRequest
        ): Kleisli[M, WafRegionalClient, CreateGeoMatchSetResponse] =
          primitive(_.createGeoMatchSet(request))

        def createIPSet(
          request: CreateIpSetRequest
        ): Kleisli[M, WafRegionalClient, CreateIpSetResponse] =
          primitive(_.createIPSet(request))

        def createRateBasedRule(
          request: CreateRateBasedRuleRequest
        ): Kleisli[M, WafRegionalClient, CreateRateBasedRuleResponse] =
          primitive(_.createRateBasedRule(request))

        def createRegexMatchSet(
          request: CreateRegexMatchSetRequest
        ): Kleisli[M, WafRegionalClient, CreateRegexMatchSetResponse] =
          primitive(_.createRegexMatchSet(request))

        def createRegexPatternSet(
          request: CreateRegexPatternSetRequest
        ): Kleisli[M, WafRegionalClient, CreateRegexPatternSetResponse] =
          primitive(_.createRegexPatternSet(request))

        def createRule(
          request: CreateRuleRequest
        ): Kleisli[M, WafRegionalClient, CreateRuleResponse] =
          primitive(_.createRule(request))

        def createRuleGroup(
          request: CreateRuleGroupRequest
        ): Kleisli[M, WafRegionalClient, CreateRuleGroupResponse] =
          primitive(_.createRuleGroup(request))

        def createSizeConstraintSet(
          request: CreateSizeConstraintSetRequest
        ): Kleisli[M, WafRegionalClient, CreateSizeConstraintSetResponse] =
          primitive(_.createSizeConstraintSet(request))

        def createSqlInjectionMatchSet(
          request: CreateSqlInjectionMatchSetRequest
        ): Kleisli[M, WafRegionalClient, CreateSqlInjectionMatchSetResponse] =
          primitive(_.createSqlInjectionMatchSet(request))

        def createWebACL(
          request: CreateWebAclRequest
        ): Kleisli[M, WafRegionalClient, CreateWebAclResponse] =
          primitive(_.createWebACL(request))

        def createWebACLMigrationStack(
          request: CreateWebAclMigrationStackRequest
        ): Kleisli[M, WafRegionalClient, CreateWebAclMigrationStackResponse] =
          primitive(_.createWebACLMigrationStack(request))

        def createXssMatchSet(
          request: CreateXssMatchSetRequest
        ): Kleisli[M, WafRegionalClient, CreateXssMatchSetResponse] =
          primitive(_.createXssMatchSet(request))

        def deleteByteMatchSet(
          request: DeleteByteMatchSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteByteMatchSetResponse] =
          primitive(_.deleteByteMatchSet(request))

        def deleteGeoMatchSet(
          request: DeleteGeoMatchSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteGeoMatchSetResponse] =
          primitive(_.deleteGeoMatchSet(request))

        def deleteIPSet(
          request: DeleteIpSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteIpSetResponse] =
          primitive(_.deleteIPSet(request))

        def deleteLoggingConfiguration(
          request: DeleteLoggingConfigurationRequest
        ): Kleisli[M, WafRegionalClient, DeleteLoggingConfigurationResponse] =
          primitive(_.deleteLoggingConfiguration(request))

        def deletePermissionPolicy(
          request: DeletePermissionPolicyRequest
        ): Kleisli[M, WafRegionalClient, DeletePermissionPolicyResponse] =
          primitive(_.deletePermissionPolicy(request))

        def deleteRateBasedRule(
          request: DeleteRateBasedRuleRequest
        ): Kleisli[M, WafRegionalClient, DeleteRateBasedRuleResponse] =
          primitive(_.deleteRateBasedRule(request))

        def deleteRegexMatchSet(
          request: DeleteRegexMatchSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteRegexMatchSetResponse] =
          primitive(_.deleteRegexMatchSet(request))

        def deleteRegexPatternSet(
          request: DeleteRegexPatternSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteRegexPatternSetResponse] =
          primitive(_.deleteRegexPatternSet(request))

        def deleteRule(
          request: DeleteRuleRequest
        ): Kleisli[M, WafRegionalClient, DeleteRuleResponse] =
          primitive(_.deleteRule(request))

        def deleteRuleGroup(
          request: DeleteRuleGroupRequest
        ): Kleisli[M, WafRegionalClient, DeleteRuleGroupResponse] =
          primitive(_.deleteRuleGroup(request))

        def deleteSizeConstraintSet(
          request: DeleteSizeConstraintSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteSizeConstraintSetResponse] =
          primitive(_.deleteSizeConstraintSet(request))

        def deleteSqlInjectionMatchSet(
          request: DeleteSqlInjectionMatchSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteSqlInjectionMatchSetResponse] =
          primitive(_.deleteSqlInjectionMatchSet(request))

        def deleteWebACL(
          request: DeleteWebAclRequest
        ): Kleisli[M, WafRegionalClient, DeleteWebAclResponse] =
          primitive(_.deleteWebACL(request))

        def deleteXssMatchSet(
          request: DeleteXssMatchSetRequest
        ): Kleisli[M, WafRegionalClient, DeleteXssMatchSetResponse] =
          primitive(_.deleteXssMatchSet(request))

        def disassociateWebACL(
          request: DisassociateWebAclRequest
        ): Kleisli[M, WafRegionalClient, DisassociateWebAclResponse] =
          primitive(_.disassociateWebACL(request))

        def getByteMatchSet(
          request: GetByteMatchSetRequest
        ): Kleisli[M, WafRegionalClient, GetByteMatchSetResponse] =
          primitive(_.getByteMatchSet(request))

        def getChangeToken(
          request: GetChangeTokenRequest
        ): Kleisli[M, WafRegionalClient, GetChangeTokenResponse] =
          primitive(_.getChangeToken(request))

        def getChangeTokenStatus(
          request: GetChangeTokenStatusRequest
        ): Kleisli[M, WafRegionalClient, GetChangeTokenStatusResponse] =
          primitive(_.getChangeTokenStatus(request))

        def getGeoMatchSet(
          request: GetGeoMatchSetRequest
        ): Kleisli[M, WafRegionalClient, GetGeoMatchSetResponse] =
          primitive(_.getGeoMatchSet(request))

        def getIPSet(
          request: GetIpSetRequest
        ): Kleisli[M, WafRegionalClient, GetIpSetResponse] =
          primitive(_.getIPSet(request))

        def getLoggingConfiguration(
          request: GetLoggingConfigurationRequest
        ): Kleisli[M, WafRegionalClient, GetLoggingConfigurationResponse] =
          primitive(_.getLoggingConfiguration(request))

        def getPermissionPolicy(
          request: GetPermissionPolicyRequest
        ): Kleisli[M, WafRegionalClient, GetPermissionPolicyResponse] =
          primitive(_.getPermissionPolicy(request))

        def getRateBasedRule(
          request: GetRateBasedRuleRequest
        ): Kleisli[M, WafRegionalClient, GetRateBasedRuleResponse] =
          primitive(_.getRateBasedRule(request))

        def getRateBasedRuleManagedKeys(
          request: GetRateBasedRuleManagedKeysRequest
        ): Kleisli[M, WafRegionalClient, GetRateBasedRuleManagedKeysResponse] =
          primitive(_.getRateBasedRuleManagedKeys(request))

        def getRegexMatchSet(
          request: GetRegexMatchSetRequest
        ): Kleisli[M, WafRegionalClient, GetRegexMatchSetResponse] =
          primitive(_.getRegexMatchSet(request))

        def getRegexPatternSet(
          request: GetRegexPatternSetRequest
        ): Kleisli[M, WafRegionalClient, GetRegexPatternSetResponse] =
          primitive(_.getRegexPatternSet(request))

        def getRule(
          request: GetRuleRequest
        ): Kleisli[M, WafRegionalClient, GetRuleResponse] =
          primitive(_.getRule(request))

        def getRuleGroup(
          request: GetRuleGroupRequest
        ): Kleisli[M, WafRegionalClient, GetRuleGroupResponse] =
          primitive(_.getRuleGroup(request))

        def getSampledRequests(
          request: GetSampledRequestsRequest
        ): Kleisli[M, WafRegionalClient, GetSampledRequestsResponse] =
          primitive(_.getSampledRequests(request))

        def getSizeConstraintSet(
          request: GetSizeConstraintSetRequest
        ): Kleisli[M, WafRegionalClient, GetSizeConstraintSetResponse] =
          primitive(_.getSizeConstraintSet(request))

        def getSqlInjectionMatchSet(
          request: GetSqlInjectionMatchSetRequest
        ): Kleisli[M, WafRegionalClient, GetSqlInjectionMatchSetResponse] =
          primitive(_.getSqlInjectionMatchSet(request))

        def getWebACL(
          request: GetWebAclRequest
        ): Kleisli[M, WafRegionalClient, GetWebAclResponse] =
          primitive(_.getWebACL(request))

        def getWebACLForResource(
          request: GetWebAclForResourceRequest
        ): Kleisli[M, WafRegionalClient, GetWebAclForResourceResponse] =
          primitive(_.getWebACLForResource(request))

        def getXssMatchSet(
          request: GetXssMatchSetRequest
        ): Kleisli[M, WafRegionalClient, GetXssMatchSetResponse] =
          primitive(_.getXssMatchSet(request))

        def listActivatedRulesInRuleGroup(
          request: ListActivatedRulesInRuleGroupRequest
        ): Kleisli[M, WafRegionalClient, ListActivatedRulesInRuleGroupResponse] =
          primitive(_.listActivatedRulesInRuleGroup(request))

        def listByteMatchSets(
          request: ListByteMatchSetsRequest
        ): Kleisli[M, WafRegionalClient, ListByteMatchSetsResponse] =
          primitive(_.listByteMatchSets(request))

        def listGeoMatchSets(
          request: ListGeoMatchSetsRequest
        ): Kleisli[M, WafRegionalClient, ListGeoMatchSetsResponse] =
          primitive(_.listGeoMatchSets(request))

        def listIPSets(
          request: ListIpSetsRequest
        ): Kleisli[M, WafRegionalClient, ListIpSetsResponse] =
          primitive(_.listIPSets(request))

        def listLoggingConfigurations(
          request: ListLoggingConfigurationsRequest
        ): Kleisli[M, WafRegionalClient, ListLoggingConfigurationsResponse] =
          primitive(_.listLoggingConfigurations(request))

        def listRateBasedRules(
          request: ListRateBasedRulesRequest
        ): Kleisli[M, WafRegionalClient, ListRateBasedRulesResponse] =
          primitive(_.listRateBasedRules(request))

        def listRegexMatchSets(
          request: ListRegexMatchSetsRequest
        ): Kleisli[M, WafRegionalClient, ListRegexMatchSetsResponse] =
          primitive(_.listRegexMatchSets(request))

        def listRegexPatternSets(
          request: ListRegexPatternSetsRequest
        ): Kleisli[M, WafRegionalClient, ListRegexPatternSetsResponse] =
          primitive(_.listRegexPatternSets(request))

        def listResourcesForWebACL(
          request: ListResourcesForWebAclRequest
        ): Kleisli[M, WafRegionalClient, ListResourcesForWebAclResponse] =
          primitive(_.listResourcesForWebACL(request))

        def listRuleGroups(
          request: ListRuleGroupsRequest
        ): Kleisli[M, WafRegionalClient, ListRuleGroupsResponse] =
          primitive(_.listRuleGroups(request))

        def listRules(
          request: ListRulesRequest
        ): Kleisli[M, WafRegionalClient, ListRulesResponse] =
          primitive(_.listRules(request))

        def listSizeConstraintSets(
          request: ListSizeConstraintSetsRequest
        ): Kleisli[M, WafRegionalClient, ListSizeConstraintSetsResponse] =
          primitive(_.listSizeConstraintSets(request))

        def listSqlInjectionMatchSets(
          request: ListSqlInjectionMatchSetsRequest
        ): Kleisli[M, WafRegionalClient, ListSqlInjectionMatchSetsResponse] =
          primitive(_.listSqlInjectionMatchSets(request))

        def listSubscribedRuleGroups(
          request: ListSubscribedRuleGroupsRequest
        ): Kleisli[M, WafRegionalClient, ListSubscribedRuleGroupsResponse] =
          primitive(_.listSubscribedRuleGroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, WafRegionalClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWebACLs(
          request: ListWebAcLsRequest
        ): Kleisli[M, WafRegionalClient, ListWebAcLsResponse] =
          primitive(_.listWebACLs(request))

        def listXssMatchSets(
          request: ListXssMatchSetsRequest
        ): Kleisli[M, WafRegionalClient, ListXssMatchSetsResponse] =
          primitive(_.listXssMatchSets(request))

        def putLoggingConfiguration(
          request: PutLoggingConfigurationRequest
        ): Kleisli[M, WafRegionalClient, PutLoggingConfigurationResponse] =
          primitive(_.putLoggingConfiguration(request))

        def putPermissionPolicy(
          request: PutPermissionPolicyRequest
        ): Kleisli[M, WafRegionalClient, PutPermissionPolicyResponse] =
          primitive(_.putPermissionPolicy(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, WafRegionalClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, WafRegionalClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateByteMatchSet(
          request: UpdateByteMatchSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateByteMatchSetResponse] =
          primitive(_.updateByteMatchSet(request))

        def updateGeoMatchSet(
          request: UpdateGeoMatchSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateGeoMatchSetResponse] =
          primitive(_.updateGeoMatchSet(request))

        def updateIPSet(
          request: UpdateIpSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateIpSetResponse] =
          primitive(_.updateIPSet(request))

        def updateRateBasedRule(
          request: UpdateRateBasedRuleRequest
        ): Kleisli[M, WafRegionalClient, UpdateRateBasedRuleResponse] =
          primitive(_.updateRateBasedRule(request))

        def updateRegexMatchSet(
          request: UpdateRegexMatchSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateRegexMatchSetResponse] =
          primitive(_.updateRegexMatchSet(request))

        def updateRegexPatternSet(
          request: UpdateRegexPatternSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateRegexPatternSetResponse] =
          primitive(_.updateRegexPatternSet(request))

        def updateRule(
          request: UpdateRuleRequest
        ): Kleisli[M, WafRegionalClient, UpdateRuleResponse] =
          primitive(_.updateRule(request))

        def updateRuleGroup(
          request: UpdateRuleGroupRequest
        ): Kleisli[M, WafRegionalClient, UpdateRuleGroupResponse] =
          primitive(_.updateRuleGroup(request))

        def updateSizeConstraintSet(
          request: UpdateSizeConstraintSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateSizeConstraintSetResponse] =
          primitive(_.updateSizeConstraintSet(request))

        def updateSqlInjectionMatchSet(
          request: UpdateSqlInjectionMatchSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateSqlInjectionMatchSetResponse] =
          primitive(_.updateSqlInjectionMatchSet(request))

        def updateWebACL(
          request: UpdateWebAclRequest
        ): Kleisli[M, WafRegionalClient, UpdateWebAclResponse] =
          primitive(_.updateWebACL(request))

        def updateXssMatchSet(
          request: UpdateXssMatchSetRequest
        ): Kleisli[M, WafRegionalClient, UpdateXssMatchSetResponse] =
          primitive(_.updateXssMatchSet(request))

        def primitive[A](
          f: WafRegionalClient => A
        ): Kleisli[M, WafRegionalClient, A]
      }
    }

    trait Visitor[F[_]] extends (WafRegionalOp ~> F) {
      final def apply[A](op: WafRegionalOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateWebACL(
        request: AssociateWebAclRequest
      ): F[AssociateWebAclResponse]

      def createByteMatchSet(
        request: CreateByteMatchSetRequest
      ): F[CreateByteMatchSetResponse]

      def createGeoMatchSet(
        request: CreateGeoMatchSetRequest
      ): F[CreateGeoMatchSetResponse]

      def createIPSet(
        request: CreateIpSetRequest
      ): F[CreateIpSetResponse]

      def createRateBasedRule(
        request: CreateRateBasedRuleRequest
      ): F[CreateRateBasedRuleResponse]

      def createRegexMatchSet(
        request: CreateRegexMatchSetRequest
      ): F[CreateRegexMatchSetResponse]

      def createRegexPatternSet(
        request: CreateRegexPatternSetRequest
      ): F[CreateRegexPatternSetResponse]

      def createRule(
        request: CreateRuleRequest
      ): F[CreateRuleResponse]

      def createRuleGroup(
        request: CreateRuleGroupRequest
      ): F[CreateRuleGroupResponse]

      def createSizeConstraintSet(
        request: CreateSizeConstraintSetRequest
      ): F[CreateSizeConstraintSetResponse]

      def createSqlInjectionMatchSet(
        request: CreateSqlInjectionMatchSetRequest
      ): F[CreateSqlInjectionMatchSetResponse]

      def createWebACL(
        request: CreateWebAclRequest
      ): F[CreateWebAclResponse]

      def createWebACLMigrationStack(
        request: CreateWebAclMigrationStackRequest
      ): F[CreateWebAclMigrationStackResponse]

      def createXssMatchSet(
        request: CreateXssMatchSetRequest
      ): F[CreateXssMatchSetResponse]

      def deleteByteMatchSet(
        request: DeleteByteMatchSetRequest
      ): F[DeleteByteMatchSetResponse]

      def deleteGeoMatchSet(
        request: DeleteGeoMatchSetRequest
      ): F[DeleteGeoMatchSetResponse]

      def deleteIPSet(
        request: DeleteIpSetRequest
      ): F[DeleteIpSetResponse]

      def deleteLoggingConfiguration(
        request: DeleteLoggingConfigurationRequest
      ): F[DeleteLoggingConfigurationResponse]

      def deletePermissionPolicy(
        request: DeletePermissionPolicyRequest
      ): F[DeletePermissionPolicyResponse]

      def deleteRateBasedRule(
        request: DeleteRateBasedRuleRequest
      ): F[DeleteRateBasedRuleResponse]

      def deleteRegexMatchSet(
        request: DeleteRegexMatchSetRequest
      ): F[DeleteRegexMatchSetResponse]

      def deleteRegexPatternSet(
        request: DeleteRegexPatternSetRequest
      ): F[DeleteRegexPatternSetResponse]

      def deleteRule(
        request: DeleteRuleRequest
      ): F[DeleteRuleResponse]

      def deleteRuleGroup(
        request: DeleteRuleGroupRequest
      ): F[DeleteRuleGroupResponse]

      def deleteSizeConstraintSet(
        request: DeleteSizeConstraintSetRequest
      ): F[DeleteSizeConstraintSetResponse]

      def deleteSqlInjectionMatchSet(
        request: DeleteSqlInjectionMatchSetRequest
      ): F[DeleteSqlInjectionMatchSetResponse]

      def deleteWebACL(
        request: DeleteWebAclRequest
      ): F[DeleteWebAclResponse]

      def deleteXssMatchSet(
        request: DeleteXssMatchSetRequest
      ): F[DeleteXssMatchSetResponse]

      def disassociateWebACL(
        request: DisassociateWebAclRequest
      ): F[DisassociateWebAclResponse]

      def getByteMatchSet(
        request: GetByteMatchSetRequest
      ): F[GetByteMatchSetResponse]

      def getChangeToken(
        request: GetChangeTokenRequest
      ): F[GetChangeTokenResponse]

      def getChangeTokenStatus(
        request: GetChangeTokenStatusRequest
      ): F[GetChangeTokenStatusResponse]

      def getGeoMatchSet(
        request: GetGeoMatchSetRequest
      ): F[GetGeoMatchSetResponse]

      def getIPSet(
        request: GetIpSetRequest
      ): F[GetIpSetResponse]

      def getLoggingConfiguration(
        request: GetLoggingConfigurationRequest
      ): F[GetLoggingConfigurationResponse]

      def getPermissionPolicy(
        request: GetPermissionPolicyRequest
      ): F[GetPermissionPolicyResponse]

      def getRateBasedRule(
        request: GetRateBasedRuleRequest
      ): F[GetRateBasedRuleResponse]

      def getRateBasedRuleManagedKeys(
        request: GetRateBasedRuleManagedKeysRequest
      ): F[GetRateBasedRuleManagedKeysResponse]

      def getRegexMatchSet(
        request: GetRegexMatchSetRequest
      ): F[GetRegexMatchSetResponse]

      def getRegexPatternSet(
        request: GetRegexPatternSetRequest
      ): F[GetRegexPatternSetResponse]

      def getRule(
        request: GetRuleRequest
      ): F[GetRuleResponse]

      def getRuleGroup(
        request: GetRuleGroupRequest
      ): F[GetRuleGroupResponse]

      def getSampledRequests(
        request: GetSampledRequestsRequest
      ): F[GetSampledRequestsResponse]

      def getSizeConstraintSet(
        request: GetSizeConstraintSetRequest
      ): F[GetSizeConstraintSetResponse]

      def getSqlInjectionMatchSet(
        request: GetSqlInjectionMatchSetRequest
      ): F[GetSqlInjectionMatchSetResponse]

      def getWebACL(
        request: GetWebAclRequest
      ): F[GetWebAclResponse]

      def getWebACLForResource(
        request: GetWebAclForResourceRequest
      ): F[GetWebAclForResourceResponse]

      def getXssMatchSet(
        request: GetXssMatchSetRequest
      ): F[GetXssMatchSetResponse]

      def listActivatedRulesInRuleGroup(
        request: ListActivatedRulesInRuleGroupRequest
      ): F[ListActivatedRulesInRuleGroupResponse]

      def listByteMatchSets(
        request: ListByteMatchSetsRequest
      ): F[ListByteMatchSetsResponse]

      def listGeoMatchSets(
        request: ListGeoMatchSetsRequest
      ): F[ListGeoMatchSetsResponse]

      def listIPSets(
        request: ListIpSetsRequest
      ): F[ListIpSetsResponse]

      def listLoggingConfigurations(
        request: ListLoggingConfigurationsRequest
      ): F[ListLoggingConfigurationsResponse]

      def listRateBasedRules(
        request: ListRateBasedRulesRequest
      ): F[ListRateBasedRulesResponse]

      def listRegexMatchSets(
        request: ListRegexMatchSetsRequest
      ): F[ListRegexMatchSetsResponse]

      def listRegexPatternSets(
        request: ListRegexPatternSetsRequest
      ): F[ListRegexPatternSetsResponse]

      def listResourcesForWebACL(
        request: ListResourcesForWebAclRequest
      ): F[ListResourcesForWebAclResponse]

      def listRuleGroups(
        request: ListRuleGroupsRequest
      ): F[ListRuleGroupsResponse]

      def listRules(
        request: ListRulesRequest
      ): F[ListRulesResponse]

      def listSizeConstraintSets(
        request: ListSizeConstraintSetsRequest
      ): F[ListSizeConstraintSetsResponse]

      def listSqlInjectionMatchSets(
        request: ListSqlInjectionMatchSetsRequest
      ): F[ListSqlInjectionMatchSetsResponse]

      def listSubscribedRuleGroups(
        request: ListSubscribedRuleGroupsRequest
      ): F[ListSubscribedRuleGroupsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWebACLs(
        request: ListWebAcLsRequest
      ): F[ListWebAcLsResponse]

      def listXssMatchSets(
        request: ListXssMatchSetsRequest
      ): F[ListXssMatchSetsResponse]

      def putLoggingConfiguration(
        request: PutLoggingConfigurationRequest
      ): F[PutLoggingConfigurationResponse]

      def putPermissionPolicy(
        request: PutPermissionPolicyRequest
      ): F[PutPermissionPolicyResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateByteMatchSet(
        request: UpdateByteMatchSetRequest
      ): F[UpdateByteMatchSetResponse]

      def updateGeoMatchSet(
        request: UpdateGeoMatchSetRequest
      ): F[UpdateGeoMatchSetResponse]

      def updateIPSet(
        request: UpdateIpSetRequest
      ): F[UpdateIpSetResponse]

      def updateRateBasedRule(
        request: UpdateRateBasedRuleRequest
      ): F[UpdateRateBasedRuleResponse]

      def updateRegexMatchSet(
        request: UpdateRegexMatchSetRequest
      ): F[UpdateRegexMatchSetResponse]

      def updateRegexPatternSet(
        request: UpdateRegexPatternSetRequest
      ): F[UpdateRegexPatternSetResponse]

      def updateRule(
        request: UpdateRuleRequest
      ): F[UpdateRuleResponse]

      def updateRuleGroup(
        request: UpdateRuleGroupRequest
      ): F[UpdateRuleGroupResponse]

      def updateSizeConstraintSet(
        request: UpdateSizeConstraintSetRequest
      ): F[UpdateSizeConstraintSetResponse]

      def updateSqlInjectionMatchSet(
        request: UpdateSqlInjectionMatchSetRequest
      ): F[UpdateSqlInjectionMatchSetResponse]

      def updateWebACL(
        request: UpdateWebAclRequest
      ): F[UpdateWebAclResponse]

      def updateXssMatchSet(
        request: UpdateXssMatchSetRequest
      ): F[UpdateXssMatchSetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends WafRegionalOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateWebACLOp(
      request: AssociateWebAclRequest
    ) extends WafRegionalOp[AssociateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateWebAclResponse] =
        visitor.associateWebACL(request)
    }

    final case class CreateByteMatchSetOp(
      request: CreateByteMatchSetRequest
    ) extends WafRegionalOp[CreateByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateByteMatchSetResponse] =
        visitor.createByteMatchSet(request)
    }

    final case class CreateGeoMatchSetOp(
      request: CreateGeoMatchSetRequest
    ) extends WafRegionalOp[CreateGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGeoMatchSetResponse] =
        visitor.createGeoMatchSet(request)
    }

    final case class CreateIPSetOp(
      request: CreateIpSetRequest
    ) extends WafRegionalOp[CreateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIpSetResponse] =
        visitor.createIPSet(request)
    }

    final case class CreateRateBasedRuleOp(
      request: CreateRateBasedRuleRequest
    ) extends WafRegionalOp[CreateRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRateBasedRuleResponse] =
        visitor.createRateBasedRule(request)
    }

    final case class CreateRegexMatchSetOp(
      request: CreateRegexMatchSetRequest
    ) extends WafRegionalOp[CreateRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRegexMatchSetResponse] =
        visitor.createRegexMatchSet(request)
    }

    final case class CreateRegexPatternSetOp(
      request: CreateRegexPatternSetRequest
    ) extends WafRegionalOp[CreateRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRegexPatternSetResponse] =
        visitor.createRegexPatternSet(request)
    }

    final case class CreateRuleOp(
      request: CreateRuleRequest
    ) extends WafRegionalOp[CreateRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleResponse] =
        visitor.createRule(request)
    }

    final case class CreateRuleGroupOp(
      request: CreateRuleGroupRequest
    ) extends WafRegionalOp[CreateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleGroupResponse] =
        visitor.createRuleGroup(request)
    }

    final case class CreateSizeConstraintSetOp(
      request: CreateSizeConstraintSetRequest
    ) extends WafRegionalOp[CreateSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSizeConstraintSetResponse] =
        visitor.createSizeConstraintSet(request)
    }

    final case class CreateSqlInjectionMatchSetOp(
      request: CreateSqlInjectionMatchSetRequest
    ) extends WafRegionalOp[CreateSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSqlInjectionMatchSetResponse] =
        visitor.createSqlInjectionMatchSet(request)
    }

    final case class CreateWebACLOp(
      request: CreateWebAclRequest
    ) extends WafRegionalOp[CreateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebAclResponse] =
        visitor.createWebACL(request)
    }

    final case class CreateWebACLMigrationStackOp(
      request: CreateWebAclMigrationStackRequest
    ) extends WafRegionalOp[CreateWebAclMigrationStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebAclMigrationStackResponse] =
        visitor.createWebACLMigrationStack(request)
    }

    final case class CreateXssMatchSetOp(
      request: CreateXssMatchSetRequest
    ) extends WafRegionalOp[CreateXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateXssMatchSetResponse] =
        visitor.createXssMatchSet(request)
    }

    final case class DeleteByteMatchSetOp(
      request: DeleteByteMatchSetRequest
    ) extends WafRegionalOp[DeleteByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteByteMatchSetResponse] =
        visitor.deleteByteMatchSet(request)
    }

    final case class DeleteGeoMatchSetOp(
      request: DeleteGeoMatchSetRequest
    ) extends WafRegionalOp[DeleteGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGeoMatchSetResponse] =
        visitor.deleteGeoMatchSet(request)
    }

    final case class DeleteIPSetOp(
      request: DeleteIpSetRequest
    ) extends WafRegionalOp[DeleteIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIpSetResponse] =
        visitor.deleteIPSet(request)
    }

    final case class DeleteLoggingConfigurationOp(
      request: DeleteLoggingConfigurationRequest
    ) extends WafRegionalOp[DeleteLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoggingConfigurationResponse] =
        visitor.deleteLoggingConfiguration(request)
    }

    final case class DeletePermissionPolicyOp(
      request: DeletePermissionPolicyRequest
    ) extends WafRegionalOp[DeletePermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePermissionPolicyResponse] =
        visitor.deletePermissionPolicy(request)
    }

    final case class DeleteRateBasedRuleOp(
      request: DeleteRateBasedRuleRequest
    ) extends WafRegionalOp[DeleteRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRateBasedRuleResponse] =
        visitor.deleteRateBasedRule(request)
    }

    final case class DeleteRegexMatchSetOp(
      request: DeleteRegexMatchSetRequest
    ) extends WafRegionalOp[DeleteRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegexMatchSetResponse] =
        visitor.deleteRegexMatchSet(request)
    }

    final case class DeleteRegexPatternSetOp(
      request: DeleteRegexPatternSetRequest
    ) extends WafRegionalOp[DeleteRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegexPatternSetResponse] =
        visitor.deleteRegexPatternSet(request)
    }

    final case class DeleteRuleOp(
      request: DeleteRuleRequest
    ) extends WafRegionalOp[DeleteRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleResponse] =
        visitor.deleteRule(request)
    }

    final case class DeleteRuleGroupOp(
      request: DeleteRuleGroupRequest
    ) extends WafRegionalOp[DeleteRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleGroupResponse] =
        visitor.deleteRuleGroup(request)
    }

    final case class DeleteSizeConstraintSetOp(
      request: DeleteSizeConstraintSetRequest
    ) extends WafRegionalOp[DeleteSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSizeConstraintSetResponse] =
        visitor.deleteSizeConstraintSet(request)
    }

    final case class DeleteSqlInjectionMatchSetOp(
      request: DeleteSqlInjectionMatchSetRequest
    ) extends WafRegionalOp[DeleteSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSqlInjectionMatchSetResponse] =
        visitor.deleteSqlInjectionMatchSet(request)
    }

    final case class DeleteWebACLOp(
      request: DeleteWebAclRequest
    ) extends WafRegionalOp[DeleteWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWebAclResponse] =
        visitor.deleteWebACL(request)
    }

    final case class DeleteXssMatchSetOp(
      request: DeleteXssMatchSetRequest
    ) extends WafRegionalOp[DeleteXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteXssMatchSetResponse] =
        visitor.deleteXssMatchSet(request)
    }

    final case class DisassociateWebACLOp(
      request: DisassociateWebAclRequest
    ) extends WafRegionalOp[DisassociateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateWebAclResponse] =
        visitor.disassociateWebACL(request)
    }

    final case class GetByteMatchSetOp(
      request: GetByteMatchSetRequest
    ) extends WafRegionalOp[GetByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetByteMatchSetResponse] =
        visitor.getByteMatchSet(request)
    }

    final case class GetChangeTokenOp(
      request: GetChangeTokenRequest
    ) extends WafRegionalOp[GetChangeTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChangeTokenResponse] =
        visitor.getChangeToken(request)
    }

    final case class GetChangeTokenStatusOp(
      request: GetChangeTokenStatusRequest
    ) extends WafRegionalOp[GetChangeTokenStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChangeTokenStatusResponse] =
        visitor.getChangeTokenStatus(request)
    }

    final case class GetGeoMatchSetOp(
      request: GetGeoMatchSetRequest
    ) extends WafRegionalOp[GetGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGeoMatchSetResponse] =
        visitor.getGeoMatchSet(request)
    }

    final case class GetIPSetOp(
      request: GetIpSetRequest
    ) extends WafRegionalOp[GetIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIpSetResponse] =
        visitor.getIPSet(request)
    }

    final case class GetLoggingConfigurationOp(
      request: GetLoggingConfigurationRequest
    ) extends WafRegionalOp[GetLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoggingConfigurationResponse] =
        visitor.getLoggingConfiguration(request)
    }

    final case class GetPermissionPolicyOp(
      request: GetPermissionPolicyRequest
    ) extends WafRegionalOp[GetPermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPermissionPolicyResponse] =
        visitor.getPermissionPolicy(request)
    }

    final case class GetRateBasedRuleOp(
      request: GetRateBasedRuleRequest
    ) extends WafRegionalOp[GetRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRateBasedRuleResponse] =
        visitor.getRateBasedRule(request)
    }

    final case class GetRateBasedRuleManagedKeysOp(
      request: GetRateBasedRuleManagedKeysRequest
    ) extends WafRegionalOp[GetRateBasedRuleManagedKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRateBasedRuleManagedKeysResponse] =
        visitor.getRateBasedRuleManagedKeys(request)
    }

    final case class GetRegexMatchSetOp(
      request: GetRegexMatchSetRequest
    ) extends WafRegionalOp[GetRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegexMatchSetResponse] =
        visitor.getRegexMatchSet(request)
    }

    final case class GetRegexPatternSetOp(
      request: GetRegexPatternSetRequest
    ) extends WafRegionalOp[GetRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegexPatternSetResponse] =
        visitor.getRegexPatternSet(request)
    }

    final case class GetRuleOp(
      request: GetRuleRequest
    ) extends WafRegionalOp[GetRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRuleResponse] =
        visitor.getRule(request)
    }

    final case class GetRuleGroupOp(
      request: GetRuleGroupRequest
    ) extends WafRegionalOp[GetRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRuleGroupResponse] =
        visitor.getRuleGroup(request)
    }

    final case class GetSampledRequestsOp(
      request: GetSampledRequestsRequest
    ) extends WafRegionalOp[GetSampledRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSampledRequestsResponse] =
        visitor.getSampledRequests(request)
    }

    final case class GetSizeConstraintSetOp(
      request: GetSizeConstraintSetRequest
    ) extends WafRegionalOp[GetSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSizeConstraintSetResponse] =
        visitor.getSizeConstraintSet(request)
    }

    final case class GetSqlInjectionMatchSetOp(
      request: GetSqlInjectionMatchSetRequest
    ) extends WafRegionalOp[GetSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSqlInjectionMatchSetResponse] =
        visitor.getSqlInjectionMatchSet(request)
    }

    final case class GetWebACLOp(
      request: GetWebAclRequest
    ) extends WafRegionalOp[GetWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWebAclResponse] =
        visitor.getWebACL(request)
    }

    final case class GetWebACLForResourceOp(
      request: GetWebAclForResourceRequest
    ) extends WafRegionalOp[GetWebAclForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWebAclForResourceResponse] =
        visitor.getWebACLForResource(request)
    }

    final case class GetXssMatchSetOp(
      request: GetXssMatchSetRequest
    ) extends WafRegionalOp[GetXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetXssMatchSetResponse] =
        visitor.getXssMatchSet(request)
    }

    final case class ListActivatedRulesInRuleGroupOp(
      request: ListActivatedRulesInRuleGroupRequest
    ) extends WafRegionalOp[ListActivatedRulesInRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActivatedRulesInRuleGroupResponse] =
        visitor.listActivatedRulesInRuleGroup(request)
    }

    final case class ListByteMatchSetsOp(
      request: ListByteMatchSetsRequest
    ) extends WafRegionalOp[ListByteMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListByteMatchSetsResponse] =
        visitor.listByteMatchSets(request)
    }

    final case class ListGeoMatchSetsOp(
      request: ListGeoMatchSetsRequest
    ) extends WafRegionalOp[ListGeoMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGeoMatchSetsResponse] =
        visitor.listGeoMatchSets(request)
    }

    final case class ListIPSetsOp(
      request: ListIpSetsRequest
    ) extends WafRegionalOp[ListIpSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIpSetsResponse] =
        visitor.listIPSets(request)
    }

    final case class ListLoggingConfigurationsOp(
      request: ListLoggingConfigurationsRequest
    ) extends WafRegionalOp[ListLoggingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLoggingConfigurationsResponse] =
        visitor.listLoggingConfigurations(request)
    }

    final case class ListRateBasedRulesOp(
      request: ListRateBasedRulesRequest
    ) extends WafRegionalOp[ListRateBasedRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRateBasedRulesResponse] =
        visitor.listRateBasedRules(request)
    }

    final case class ListRegexMatchSetsOp(
      request: ListRegexMatchSetsRequest
    ) extends WafRegionalOp[ListRegexMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegexMatchSetsResponse] =
        visitor.listRegexMatchSets(request)
    }

    final case class ListRegexPatternSetsOp(
      request: ListRegexPatternSetsRequest
    ) extends WafRegionalOp[ListRegexPatternSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegexPatternSetsResponse] =
        visitor.listRegexPatternSets(request)
    }

    final case class ListResourcesForWebACLOp(
      request: ListResourcesForWebAclRequest
    ) extends WafRegionalOp[ListResourcesForWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesForWebAclResponse] =
        visitor.listResourcesForWebACL(request)
    }

    final case class ListRuleGroupsOp(
      request: ListRuleGroupsRequest
    ) extends WafRegionalOp[ListRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRuleGroupsResponse] =
        visitor.listRuleGroups(request)
    }

    final case class ListRulesOp(
      request: ListRulesRequest
    ) extends WafRegionalOp[ListRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRulesResponse] =
        visitor.listRules(request)
    }

    final case class ListSizeConstraintSetsOp(
      request: ListSizeConstraintSetsRequest
    ) extends WafRegionalOp[ListSizeConstraintSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSizeConstraintSetsResponse] =
        visitor.listSizeConstraintSets(request)
    }

    final case class ListSqlInjectionMatchSetsOp(
      request: ListSqlInjectionMatchSetsRequest
    ) extends WafRegionalOp[ListSqlInjectionMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSqlInjectionMatchSetsResponse] =
        visitor.listSqlInjectionMatchSets(request)
    }

    final case class ListSubscribedRuleGroupsOp(
      request: ListSubscribedRuleGroupsRequest
    ) extends WafRegionalOp[ListSubscribedRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSubscribedRuleGroupsResponse] =
        visitor.listSubscribedRuleGroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends WafRegionalOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWebACLsOp(
      request: ListWebAcLsRequest
    ) extends WafRegionalOp[ListWebAcLsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWebAcLsResponse] =
        visitor.listWebACLs(request)
    }

    final case class ListXssMatchSetsOp(
      request: ListXssMatchSetsRequest
    ) extends WafRegionalOp[ListXssMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListXssMatchSetsResponse] =
        visitor.listXssMatchSets(request)
    }

    final case class PutLoggingConfigurationOp(
      request: PutLoggingConfigurationRequest
    ) extends WafRegionalOp[PutLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLoggingConfigurationResponse] =
        visitor.putLoggingConfiguration(request)
    }

    final case class PutPermissionPolicyOp(
      request: PutPermissionPolicyRequest
    ) extends WafRegionalOp[PutPermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPermissionPolicyResponse] =
        visitor.putPermissionPolicy(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends WafRegionalOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends WafRegionalOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateByteMatchSetOp(
      request: UpdateByteMatchSetRequest
    ) extends WafRegionalOp[UpdateByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateByteMatchSetResponse] =
        visitor.updateByteMatchSet(request)
    }

    final case class UpdateGeoMatchSetOp(
      request: UpdateGeoMatchSetRequest
    ) extends WafRegionalOp[UpdateGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGeoMatchSetResponse] =
        visitor.updateGeoMatchSet(request)
    }

    final case class UpdateIPSetOp(
      request: UpdateIpSetRequest
    ) extends WafRegionalOp[UpdateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIpSetResponse] =
        visitor.updateIPSet(request)
    }

    final case class UpdateRateBasedRuleOp(
      request: UpdateRateBasedRuleRequest
    ) extends WafRegionalOp[UpdateRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRateBasedRuleResponse] =
        visitor.updateRateBasedRule(request)
    }

    final case class UpdateRegexMatchSetOp(
      request: UpdateRegexMatchSetRequest
    ) extends WafRegionalOp[UpdateRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegexMatchSetResponse] =
        visitor.updateRegexMatchSet(request)
    }

    final case class UpdateRegexPatternSetOp(
      request: UpdateRegexPatternSetRequest
    ) extends WafRegionalOp[UpdateRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegexPatternSetResponse] =
        visitor.updateRegexPatternSet(request)
    }

    final case class UpdateRuleOp(
      request: UpdateRuleRequest
    ) extends WafRegionalOp[UpdateRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleResponse] =
        visitor.updateRule(request)
    }

    final case class UpdateRuleGroupOp(
      request: UpdateRuleGroupRequest
    ) extends WafRegionalOp[UpdateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleGroupResponse] =
        visitor.updateRuleGroup(request)
    }

    final case class UpdateSizeConstraintSetOp(
      request: UpdateSizeConstraintSetRequest
    ) extends WafRegionalOp[UpdateSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSizeConstraintSetResponse] =
        visitor.updateSizeConstraintSet(request)
    }

    final case class UpdateSqlInjectionMatchSetOp(
      request: UpdateSqlInjectionMatchSetRequest
    ) extends WafRegionalOp[UpdateSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSqlInjectionMatchSetResponse] =
        visitor.updateSqlInjectionMatchSet(request)
    }

    final case class UpdateWebACLOp(
      request: UpdateWebAclRequest
    ) extends WafRegionalOp[UpdateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWebAclResponse] =
        visitor.updateWebACL(request)
    }

    final case class UpdateXssMatchSetOp(
      request: UpdateXssMatchSetRequest
    ) extends WafRegionalOp[UpdateXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateXssMatchSetResponse] =
        visitor.updateXssMatchSet(request)
    }
  }

  import WafRegionalOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WafRegionalOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateWebACL(
    request: AssociateWebAclRequest
  ): WafRegionalIO[AssociateWebAclResponse] =
    FF.liftF(AssociateWebACLOp(request))

  def createByteMatchSet(
    request: CreateByteMatchSetRequest
  ): WafRegionalIO[CreateByteMatchSetResponse] =
    FF.liftF(CreateByteMatchSetOp(request))

  def createGeoMatchSet(
    request: CreateGeoMatchSetRequest
  ): WafRegionalIO[CreateGeoMatchSetResponse] =
    FF.liftF(CreateGeoMatchSetOp(request))

  def createIPSet(
    request: CreateIpSetRequest
  ): WafRegionalIO[CreateIpSetResponse] =
    FF.liftF(CreateIPSetOp(request))

  def createRateBasedRule(
    request: CreateRateBasedRuleRequest
  ): WafRegionalIO[CreateRateBasedRuleResponse] =
    FF.liftF(CreateRateBasedRuleOp(request))

  def createRegexMatchSet(
    request: CreateRegexMatchSetRequest
  ): WafRegionalIO[CreateRegexMatchSetResponse] =
    FF.liftF(CreateRegexMatchSetOp(request))

  def createRegexPatternSet(
    request: CreateRegexPatternSetRequest
  ): WafRegionalIO[CreateRegexPatternSetResponse] =
    FF.liftF(CreateRegexPatternSetOp(request))

  def createRule(
    request: CreateRuleRequest
  ): WafRegionalIO[CreateRuleResponse] =
    FF.liftF(CreateRuleOp(request))

  def createRuleGroup(
    request: CreateRuleGroupRequest
  ): WafRegionalIO[CreateRuleGroupResponse] =
    FF.liftF(CreateRuleGroupOp(request))

  def createSizeConstraintSet(
    request: CreateSizeConstraintSetRequest
  ): WafRegionalIO[CreateSizeConstraintSetResponse] =
    FF.liftF(CreateSizeConstraintSetOp(request))

  def createSqlInjectionMatchSet(
    request: CreateSqlInjectionMatchSetRequest
  ): WafRegionalIO[CreateSqlInjectionMatchSetResponse] =
    FF.liftF(CreateSqlInjectionMatchSetOp(request))

  def createWebACL(
    request: CreateWebAclRequest
  ): WafRegionalIO[CreateWebAclResponse] =
    FF.liftF(CreateWebACLOp(request))

  def createWebACLMigrationStack(
    request: CreateWebAclMigrationStackRequest
  ): WafRegionalIO[CreateWebAclMigrationStackResponse] =
    FF.liftF(CreateWebACLMigrationStackOp(request))

  def createXssMatchSet(
    request: CreateXssMatchSetRequest
  ): WafRegionalIO[CreateXssMatchSetResponse] =
    FF.liftF(CreateXssMatchSetOp(request))

  def deleteByteMatchSet(
    request: DeleteByteMatchSetRequest
  ): WafRegionalIO[DeleteByteMatchSetResponse] =
    FF.liftF(DeleteByteMatchSetOp(request))

  def deleteGeoMatchSet(
    request: DeleteGeoMatchSetRequest
  ): WafRegionalIO[DeleteGeoMatchSetResponse] =
    FF.liftF(DeleteGeoMatchSetOp(request))

  def deleteIPSet(
    request: DeleteIpSetRequest
  ): WafRegionalIO[DeleteIpSetResponse] =
    FF.liftF(DeleteIPSetOp(request))

  def deleteLoggingConfiguration(
    request: DeleteLoggingConfigurationRequest
  ): WafRegionalIO[DeleteLoggingConfigurationResponse] =
    FF.liftF(DeleteLoggingConfigurationOp(request))

  def deletePermissionPolicy(
    request: DeletePermissionPolicyRequest
  ): WafRegionalIO[DeletePermissionPolicyResponse] =
    FF.liftF(DeletePermissionPolicyOp(request))

  def deleteRateBasedRule(
    request: DeleteRateBasedRuleRequest
  ): WafRegionalIO[DeleteRateBasedRuleResponse] =
    FF.liftF(DeleteRateBasedRuleOp(request))

  def deleteRegexMatchSet(
    request: DeleteRegexMatchSetRequest
  ): WafRegionalIO[DeleteRegexMatchSetResponse] =
    FF.liftF(DeleteRegexMatchSetOp(request))

  def deleteRegexPatternSet(
    request: DeleteRegexPatternSetRequest
  ): WafRegionalIO[DeleteRegexPatternSetResponse] =
    FF.liftF(DeleteRegexPatternSetOp(request))

  def deleteRule(
    request: DeleteRuleRequest
  ): WafRegionalIO[DeleteRuleResponse] =
    FF.liftF(DeleteRuleOp(request))

  def deleteRuleGroup(
    request: DeleteRuleGroupRequest
  ): WafRegionalIO[DeleteRuleGroupResponse] =
    FF.liftF(DeleteRuleGroupOp(request))

  def deleteSizeConstraintSet(
    request: DeleteSizeConstraintSetRequest
  ): WafRegionalIO[DeleteSizeConstraintSetResponse] =
    FF.liftF(DeleteSizeConstraintSetOp(request))

  def deleteSqlInjectionMatchSet(
    request: DeleteSqlInjectionMatchSetRequest
  ): WafRegionalIO[DeleteSqlInjectionMatchSetResponse] =
    FF.liftF(DeleteSqlInjectionMatchSetOp(request))

  def deleteWebACL(
    request: DeleteWebAclRequest
  ): WafRegionalIO[DeleteWebAclResponse] =
    FF.liftF(DeleteWebACLOp(request))

  def deleteXssMatchSet(
    request: DeleteXssMatchSetRequest
  ): WafRegionalIO[DeleteXssMatchSetResponse] =
    FF.liftF(DeleteXssMatchSetOp(request))

  def disassociateWebACL(
    request: DisassociateWebAclRequest
  ): WafRegionalIO[DisassociateWebAclResponse] =
    FF.liftF(DisassociateWebACLOp(request))

  def getByteMatchSet(
    request: GetByteMatchSetRequest
  ): WafRegionalIO[GetByteMatchSetResponse] =
    FF.liftF(GetByteMatchSetOp(request))

  def getChangeToken(
    request: GetChangeTokenRequest
  ): WafRegionalIO[GetChangeTokenResponse] =
    FF.liftF(GetChangeTokenOp(request))

  def getChangeTokenStatus(
    request: GetChangeTokenStatusRequest
  ): WafRegionalIO[GetChangeTokenStatusResponse] =
    FF.liftF(GetChangeTokenStatusOp(request))

  def getGeoMatchSet(
    request: GetGeoMatchSetRequest
  ): WafRegionalIO[GetGeoMatchSetResponse] =
    FF.liftF(GetGeoMatchSetOp(request))

  def getIPSet(
    request: GetIpSetRequest
  ): WafRegionalIO[GetIpSetResponse] =
    FF.liftF(GetIPSetOp(request))

  def getLoggingConfiguration(
    request: GetLoggingConfigurationRequest
  ): WafRegionalIO[GetLoggingConfigurationResponse] =
    FF.liftF(GetLoggingConfigurationOp(request))

  def getPermissionPolicy(
    request: GetPermissionPolicyRequest
  ): WafRegionalIO[GetPermissionPolicyResponse] =
    FF.liftF(GetPermissionPolicyOp(request))

  def getRateBasedRule(
    request: GetRateBasedRuleRequest
  ): WafRegionalIO[GetRateBasedRuleResponse] =
    FF.liftF(GetRateBasedRuleOp(request))

  def getRateBasedRuleManagedKeys(
    request: GetRateBasedRuleManagedKeysRequest
  ): WafRegionalIO[GetRateBasedRuleManagedKeysResponse] =
    FF.liftF(GetRateBasedRuleManagedKeysOp(request))

  def getRegexMatchSet(
    request: GetRegexMatchSetRequest
  ): WafRegionalIO[GetRegexMatchSetResponse] =
    FF.liftF(GetRegexMatchSetOp(request))

  def getRegexPatternSet(
    request: GetRegexPatternSetRequest
  ): WafRegionalIO[GetRegexPatternSetResponse] =
    FF.liftF(GetRegexPatternSetOp(request))

  def getRule(
    request: GetRuleRequest
  ): WafRegionalIO[GetRuleResponse] =
    FF.liftF(GetRuleOp(request))

  def getRuleGroup(
    request: GetRuleGroupRequest
  ): WafRegionalIO[GetRuleGroupResponse] =
    FF.liftF(GetRuleGroupOp(request))

  def getSampledRequests(
    request: GetSampledRequestsRequest
  ): WafRegionalIO[GetSampledRequestsResponse] =
    FF.liftF(GetSampledRequestsOp(request))

  def getSizeConstraintSet(
    request: GetSizeConstraintSetRequest
  ): WafRegionalIO[GetSizeConstraintSetResponse] =
    FF.liftF(GetSizeConstraintSetOp(request))

  def getSqlInjectionMatchSet(
    request: GetSqlInjectionMatchSetRequest
  ): WafRegionalIO[GetSqlInjectionMatchSetResponse] =
    FF.liftF(GetSqlInjectionMatchSetOp(request))

  def getWebACL(
    request: GetWebAclRequest
  ): WafRegionalIO[GetWebAclResponse] =
    FF.liftF(GetWebACLOp(request))

  def getWebACLForResource(
    request: GetWebAclForResourceRequest
  ): WafRegionalIO[GetWebAclForResourceResponse] =
    FF.liftF(GetWebACLForResourceOp(request))

  def getXssMatchSet(
    request: GetXssMatchSetRequest
  ): WafRegionalIO[GetXssMatchSetResponse] =
    FF.liftF(GetXssMatchSetOp(request))

  def listActivatedRulesInRuleGroup(
    request: ListActivatedRulesInRuleGroupRequest
  ): WafRegionalIO[ListActivatedRulesInRuleGroupResponse] =
    FF.liftF(ListActivatedRulesInRuleGroupOp(request))

  def listByteMatchSets(
    request: ListByteMatchSetsRequest
  ): WafRegionalIO[ListByteMatchSetsResponse] =
    FF.liftF(ListByteMatchSetsOp(request))

  def listGeoMatchSets(
    request: ListGeoMatchSetsRequest
  ): WafRegionalIO[ListGeoMatchSetsResponse] =
    FF.liftF(ListGeoMatchSetsOp(request))

  def listIPSets(
    request: ListIpSetsRequest
  ): WafRegionalIO[ListIpSetsResponse] =
    FF.liftF(ListIPSetsOp(request))

  def listLoggingConfigurations(
    request: ListLoggingConfigurationsRequest
  ): WafRegionalIO[ListLoggingConfigurationsResponse] =
    FF.liftF(ListLoggingConfigurationsOp(request))

  def listRateBasedRules(
    request: ListRateBasedRulesRequest
  ): WafRegionalIO[ListRateBasedRulesResponse] =
    FF.liftF(ListRateBasedRulesOp(request))

  def listRegexMatchSets(
    request: ListRegexMatchSetsRequest
  ): WafRegionalIO[ListRegexMatchSetsResponse] =
    FF.liftF(ListRegexMatchSetsOp(request))

  def listRegexPatternSets(
    request: ListRegexPatternSetsRequest
  ): WafRegionalIO[ListRegexPatternSetsResponse] =
    FF.liftF(ListRegexPatternSetsOp(request))

  def listResourcesForWebACL(
    request: ListResourcesForWebAclRequest
  ): WafRegionalIO[ListResourcesForWebAclResponse] =
    FF.liftF(ListResourcesForWebACLOp(request))

  def listRuleGroups(
    request: ListRuleGroupsRequest
  ): WafRegionalIO[ListRuleGroupsResponse] =
    FF.liftF(ListRuleGroupsOp(request))

  def listRules(
    request: ListRulesRequest
  ): WafRegionalIO[ListRulesResponse] =
    FF.liftF(ListRulesOp(request))

  def listSizeConstraintSets(
    request: ListSizeConstraintSetsRequest
  ): WafRegionalIO[ListSizeConstraintSetsResponse] =
    FF.liftF(ListSizeConstraintSetsOp(request))

  def listSqlInjectionMatchSets(
    request: ListSqlInjectionMatchSetsRequest
  ): WafRegionalIO[ListSqlInjectionMatchSetsResponse] =
    FF.liftF(ListSqlInjectionMatchSetsOp(request))

  def listSubscribedRuleGroups(
    request: ListSubscribedRuleGroupsRequest
  ): WafRegionalIO[ListSubscribedRuleGroupsResponse] =
    FF.liftF(ListSubscribedRuleGroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): WafRegionalIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWebACLs(
    request: ListWebAcLsRequest
  ): WafRegionalIO[ListWebAcLsResponse] =
    FF.liftF(ListWebACLsOp(request))

  def listXssMatchSets(
    request: ListXssMatchSetsRequest
  ): WafRegionalIO[ListXssMatchSetsResponse] =
    FF.liftF(ListXssMatchSetsOp(request))

  def putLoggingConfiguration(
    request: PutLoggingConfigurationRequest
  ): WafRegionalIO[PutLoggingConfigurationResponse] =
    FF.liftF(PutLoggingConfigurationOp(request))

  def putPermissionPolicy(
    request: PutPermissionPolicyRequest
  ): WafRegionalIO[PutPermissionPolicyResponse] =
    FF.liftF(PutPermissionPolicyOp(request))

  def tagResource(
    request: TagResourceRequest
  ): WafRegionalIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): WafRegionalIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateByteMatchSet(
    request: UpdateByteMatchSetRequest
  ): WafRegionalIO[UpdateByteMatchSetResponse] =
    FF.liftF(UpdateByteMatchSetOp(request))

  def updateGeoMatchSet(
    request: UpdateGeoMatchSetRequest
  ): WafRegionalIO[UpdateGeoMatchSetResponse] =
    FF.liftF(UpdateGeoMatchSetOp(request))

  def updateIPSet(
    request: UpdateIpSetRequest
  ): WafRegionalIO[UpdateIpSetResponse] =
    FF.liftF(UpdateIPSetOp(request))

  def updateRateBasedRule(
    request: UpdateRateBasedRuleRequest
  ): WafRegionalIO[UpdateRateBasedRuleResponse] =
    FF.liftF(UpdateRateBasedRuleOp(request))

  def updateRegexMatchSet(
    request: UpdateRegexMatchSetRequest
  ): WafRegionalIO[UpdateRegexMatchSetResponse] =
    FF.liftF(UpdateRegexMatchSetOp(request))

  def updateRegexPatternSet(
    request: UpdateRegexPatternSetRequest
  ): WafRegionalIO[UpdateRegexPatternSetResponse] =
    FF.liftF(UpdateRegexPatternSetOp(request))

  def updateRule(
    request: UpdateRuleRequest
  ): WafRegionalIO[UpdateRuleResponse] =
    FF.liftF(UpdateRuleOp(request))

  def updateRuleGroup(
    request: UpdateRuleGroupRequest
  ): WafRegionalIO[UpdateRuleGroupResponse] =
    FF.liftF(UpdateRuleGroupOp(request))

  def updateSizeConstraintSet(
    request: UpdateSizeConstraintSetRequest
  ): WafRegionalIO[UpdateSizeConstraintSetResponse] =
    FF.liftF(UpdateSizeConstraintSetOp(request))

  def updateSqlInjectionMatchSet(
    request: UpdateSqlInjectionMatchSetRequest
  ): WafRegionalIO[UpdateSqlInjectionMatchSetResponse] =
    FF.liftF(UpdateSqlInjectionMatchSetOp(request))

  def updateWebACL(
    request: UpdateWebAclRequest
  ): WafRegionalIO[UpdateWebAclResponse] =
    FF.liftF(UpdateWebACLOp(request))

  def updateXssMatchSet(
    request: UpdateXssMatchSetRequest
  ): WafRegionalIO[UpdateXssMatchSetResponse] =
    FF.liftF(UpdateXssMatchSetOp(request))
}
