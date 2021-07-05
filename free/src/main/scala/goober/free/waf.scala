package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.waf.WafClient
import software.amazon.awssdk.services.waf.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object waf { module =>

  // Free monad over WafOp
  type WafIO[A] = FF[WafOp, A]

  sealed trait WafOp[A] {
    def visit[F[_]](visitor: WafOp.Visitor[F]): F[A]
  }

  object WafOp {
    // Given a WafClient we can embed a WafIO program in any algebra that understands embedding.
    implicit val WafOpEmbeddable: Embeddable[WafOp, WafClient] = new Embeddable[WafOp, WafClient] {
      def embed[A](client: WafClient, io: WafIO[A]): Embedded[A] = Embedded.Waf(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WafOp.Visitor[Kleisli[M, WafClient, *]] {
        def createByteMatchSet(
          request: CreateByteMatchSetRequest
        ): Kleisli[M, WafClient, CreateByteMatchSetResponse] =
          primitive(_.createByteMatchSet(request))

        def createGeoMatchSet(
          request: CreateGeoMatchSetRequest
        ): Kleisli[M, WafClient, CreateGeoMatchSetResponse] =
          primitive(_.createGeoMatchSet(request))

        def createIPSet(
          request: CreateIpSetRequest
        ): Kleisli[M, WafClient, CreateIpSetResponse] =
          primitive(_.createIPSet(request))

        def createRateBasedRule(
          request: CreateRateBasedRuleRequest
        ): Kleisli[M, WafClient, CreateRateBasedRuleResponse] =
          primitive(_.createRateBasedRule(request))

        def createRegexMatchSet(
          request: CreateRegexMatchSetRequest
        ): Kleisli[M, WafClient, CreateRegexMatchSetResponse] =
          primitive(_.createRegexMatchSet(request))

        def createRegexPatternSet(
          request: CreateRegexPatternSetRequest
        ): Kleisli[M, WafClient, CreateRegexPatternSetResponse] =
          primitive(_.createRegexPatternSet(request))

        def createRule(
          request: CreateRuleRequest
        ): Kleisli[M, WafClient, CreateRuleResponse] =
          primitive(_.createRule(request))

        def createRuleGroup(
          request: CreateRuleGroupRequest
        ): Kleisli[M, WafClient, CreateRuleGroupResponse] =
          primitive(_.createRuleGroup(request))

        def createSizeConstraintSet(
          request: CreateSizeConstraintSetRequest
        ): Kleisli[M, WafClient, CreateSizeConstraintSetResponse] =
          primitive(_.createSizeConstraintSet(request))

        def createSqlInjectionMatchSet(
          request: CreateSqlInjectionMatchSetRequest
        ): Kleisli[M, WafClient, CreateSqlInjectionMatchSetResponse] =
          primitive(_.createSqlInjectionMatchSet(request))

        def createWebACL(
          request: CreateWebAclRequest
        ): Kleisli[M, WafClient, CreateWebAclResponse] =
          primitive(_.createWebACL(request))

        def createWebACLMigrationStack(
          request: CreateWebAclMigrationStackRequest
        ): Kleisli[M, WafClient, CreateWebAclMigrationStackResponse] =
          primitive(_.createWebACLMigrationStack(request))

        def createXssMatchSet(
          request: CreateXssMatchSetRequest
        ): Kleisli[M, WafClient, CreateXssMatchSetResponse] =
          primitive(_.createXssMatchSet(request))

        def deleteByteMatchSet(
          request: DeleteByteMatchSetRequest
        ): Kleisli[M, WafClient, DeleteByteMatchSetResponse] =
          primitive(_.deleteByteMatchSet(request))

        def deleteGeoMatchSet(
          request: DeleteGeoMatchSetRequest
        ): Kleisli[M, WafClient, DeleteGeoMatchSetResponse] =
          primitive(_.deleteGeoMatchSet(request))

        def deleteIPSet(
          request: DeleteIpSetRequest
        ): Kleisli[M, WafClient, DeleteIpSetResponse] =
          primitive(_.deleteIPSet(request))

        def deleteLoggingConfiguration(
          request: DeleteLoggingConfigurationRequest
        ): Kleisli[M, WafClient, DeleteLoggingConfigurationResponse] =
          primitive(_.deleteLoggingConfiguration(request))

        def deletePermissionPolicy(
          request: DeletePermissionPolicyRequest
        ): Kleisli[M, WafClient, DeletePermissionPolicyResponse] =
          primitive(_.deletePermissionPolicy(request))

        def deleteRateBasedRule(
          request: DeleteRateBasedRuleRequest
        ): Kleisli[M, WafClient, DeleteRateBasedRuleResponse] =
          primitive(_.deleteRateBasedRule(request))

        def deleteRegexMatchSet(
          request: DeleteRegexMatchSetRequest
        ): Kleisli[M, WafClient, DeleteRegexMatchSetResponse] =
          primitive(_.deleteRegexMatchSet(request))

        def deleteRegexPatternSet(
          request: DeleteRegexPatternSetRequest
        ): Kleisli[M, WafClient, DeleteRegexPatternSetResponse] =
          primitive(_.deleteRegexPatternSet(request))

        def deleteRule(
          request: DeleteRuleRequest
        ): Kleisli[M, WafClient, DeleteRuleResponse] =
          primitive(_.deleteRule(request))

        def deleteRuleGroup(
          request: DeleteRuleGroupRequest
        ): Kleisli[M, WafClient, DeleteRuleGroupResponse] =
          primitive(_.deleteRuleGroup(request))

        def deleteSizeConstraintSet(
          request: DeleteSizeConstraintSetRequest
        ): Kleisli[M, WafClient, DeleteSizeConstraintSetResponse] =
          primitive(_.deleteSizeConstraintSet(request))

        def deleteSqlInjectionMatchSet(
          request: DeleteSqlInjectionMatchSetRequest
        ): Kleisli[M, WafClient, DeleteSqlInjectionMatchSetResponse] =
          primitive(_.deleteSqlInjectionMatchSet(request))

        def deleteWebACL(
          request: DeleteWebAclRequest
        ): Kleisli[M, WafClient, DeleteWebAclResponse] =
          primitive(_.deleteWebACL(request))

        def deleteXssMatchSet(
          request: DeleteXssMatchSetRequest
        ): Kleisli[M, WafClient, DeleteXssMatchSetResponse] =
          primitive(_.deleteXssMatchSet(request))

        def getByteMatchSet(
          request: GetByteMatchSetRequest
        ): Kleisli[M, WafClient, GetByteMatchSetResponse] =
          primitive(_.getByteMatchSet(request))

        def getChangeToken(
          request: GetChangeTokenRequest
        ): Kleisli[M, WafClient, GetChangeTokenResponse] =
          primitive(_.getChangeToken(request))

        def getChangeTokenStatus(
          request: GetChangeTokenStatusRequest
        ): Kleisli[M, WafClient, GetChangeTokenStatusResponse] =
          primitive(_.getChangeTokenStatus(request))

        def getGeoMatchSet(
          request: GetGeoMatchSetRequest
        ): Kleisli[M, WafClient, GetGeoMatchSetResponse] =
          primitive(_.getGeoMatchSet(request))

        def getIPSet(
          request: GetIpSetRequest
        ): Kleisli[M, WafClient, GetIpSetResponse] =
          primitive(_.getIPSet(request))

        def getLoggingConfiguration(
          request: GetLoggingConfigurationRequest
        ): Kleisli[M, WafClient, GetLoggingConfigurationResponse] =
          primitive(_.getLoggingConfiguration(request))

        def getPermissionPolicy(
          request: GetPermissionPolicyRequest
        ): Kleisli[M, WafClient, GetPermissionPolicyResponse] =
          primitive(_.getPermissionPolicy(request))

        def getRateBasedRule(
          request: GetRateBasedRuleRequest
        ): Kleisli[M, WafClient, GetRateBasedRuleResponse] =
          primitive(_.getRateBasedRule(request))

        def getRateBasedRuleManagedKeys(
          request: GetRateBasedRuleManagedKeysRequest
        ): Kleisli[M, WafClient, GetRateBasedRuleManagedKeysResponse] =
          primitive(_.getRateBasedRuleManagedKeys(request))

        def getRegexMatchSet(
          request: GetRegexMatchSetRequest
        ): Kleisli[M, WafClient, GetRegexMatchSetResponse] =
          primitive(_.getRegexMatchSet(request))

        def getRegexPatternSet(
          request: GetRegexPatternSetRequest
        ): Kleisli[M, WafClient, GetRegexPatternSetResponse] =
          primitive(_.getRegexPatternSet(request))

        def getRule(
          request: GetRuleRequest
        ): Kleisli[M, WafClient, GetRuleResponse] =
          primitive(_.getRule(request))

        def getRuleGroup(
          request: GetRuleGroupRequest
        ): Kleisli[M, WafClient, GetRuleGroupResponse] =
          primitive(_.getRuleGroup(request))

        def getSampledRequests(
          request: GetSampledRequestsRequest
        ): Kleisli[M, WafClient, GetSampledRequestsResponse] =
          primitive(_.getSampledRequests(request))

        def getSizeConstraintSet(
          request: GetSizeConstraintSetRequest
        ): Kleisli[M, WafClient, GetSizeConstraintSetResponse] =
          primitive(_.getSizeConstraintSet(request))

        def getSqlInjectionMatchSet(
          request: GetSqlInjectionMatchSetRequest
        ): Kleisli[M, WafClient, GetSqlInjectionMatchSetResponse] =
          primitive(_.getSqlInjectionMatchSet(request))

        def getWebACL(
          request: GetWebAclRequest
        ): Kleisli[M, WafClient, GetWebAclResponse] =
          primitive(_.getWebACL(request))

        def getXssMatchSet(
          request: GetXssMatchSetRequest
        ): Kleisli[M, WafClient, GetXssMatchSetResponse] =
          primitive(_.getXssMatchSet(request))

        def listActivatedRulesInRuleGroup(
          request: ListActivatedRulesInRuleGroupRequest
        ): Kleisli[M, WafClient, ListActivatedRulesInRuleGroupResponse] =
          primitive(_.listActivatedRulesInRuleGroup(request))

        def listByteMatchSets(
          request: ListByteMatchSetsRequest
        ): Kleisli[M, WafClient, ListByteMatchSetsResponse] =
          primitive(_.listByteMatchSets(request))

        def listGeoMatchSets(
          request: ListGeoMatchSetsRequest
        ): Kleisli[M, WafClient, ListGeoMatchSetsResponse] =
          primitive(_.listGeoMatchSets(request))

        def listIPSets(
          request: ListIpSetsRequest
        ): Kleisli[M, WafClient, ListIpSetsResponse] =
          primitive(_.listIPSets(request))

        def listLoggingConfigurations(
          request: ListLoggingConfigurationsRequest
        ): Kleisli[M, WafClient, ListLoggingConfigurationsResponse] =
          primitive(_.listLoggingConfigurations(request))

        def listRateBasedRules(
          request: ListRateBasedRulesRequest
        ): Kleisli[M, WafClient, ListRateBasedRulesResponse] =
          primitive(_.listRateBasedRules(request))

        def listRegexMatchSets(
          request: ListRegexMatchSetsRequest
        ): Kleisli[M, WafClient, ListRegexMatchSetsResponse] =
          primitive(_.listRegexMatchSets(request))

        def listRegexPatternSets(
          request: ListRegexPatternSetsRequest
        ): Kleisli[M, WafClient, ListRegexPatternSetsResponse] =
          primitive(_.listRegexPatternSets(request))

        def listRuleGroups(
          request: ListRuleGroupsRequest
        ): Kleisli[M, WafClient, ListRuleGroupsResponse] =
          primitive(_.listRuleGroups(request))

        def listRules(
          request: ListRulesRequest
        ): Kleisli[M, WafClient, ListRulesResponse] =
          primitive(_.listRules(request))

        def listSizeConstraintSets(
          request: ListSizeConstraintSetsRequest
        ): Kleisli[M, WafClient, ListSizeConstraintSetsResponse] =
          primitive(_.listSizeConstraintSets(request))

        def listSqlInjectionMatchSets(
          request: ListSqlInjectionMatchSetsRequest
        ): Kleisli[M, WafClient, ListSqlInjectionMatchSetsResponse] =
          primitive(_.listSqlInjectionMatchSets(request))

        def listSubscribedRuleGroups(
          request: ListSubscribedRuleGroupsRequest
        ): Kleisli[M, WafClient, ListSubscribedRuleGroupsResponse] =
          primitive(_.listSubscribedRuleGroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, WafClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWebACLs(
          request: ListWebAcLsRequest
        ): Kleisli[M, WafClient, ListWebAcLsResponse] =
          primitive(_.listWebACLs(request))

        def listXssMatchSets(
          request: ListXssMatchSetsRequest
        ): Kleisli[M, WafClient, ListXssMatchSetsResponse] =
          primitive(_.listXssMatchSets(request))

        def putLoggingConfiguration(
          request: PutLoggingConfigurationRequest
        ): Kleisli[M, WafClient, PutLoggingConfigurationResponse] =
          primitive(_.putLoggingConfiguration(request))

        def putPermissionPolicy(
          request: PutPermissionPolicyRequest
        ): Kleisli[M, WafClient, PutPermissionPolicyResponse] =
          primitive(_.putPermissionPolicy(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, WafClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, WafClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateByteMatchSet(
          request: UpdateByteMatchSetRequest
        ): Kleisli[M, WafClient, UpdateByteMatchSetResponse] =
          primitive(_.updateByteMatchSet(request))

        def updateGeoMatchSet(
          request: UpdateGeoMatchSetRequest
        ): Kleisli[M, WafClient, UpdateGeoMatchSetResponse] =
          primitive(_.updateGeoMatchSet(request))

        def updateIPSet(
          request: UpdateIpSetRequest
        ): Kleisli[M, WafClient, UpdateIpSetResponse] =
          primitive(_.updateIPSet(request))

        def updateRateBasedRule(
          request: UpdateRateBasedRuleRequest
        ): Kleisli[M, WafClient, UpdateRateBasedRuleResponse] =
          primitive(_.updateRateBasedRule(request))

        def updateRegexMatchSet(
          request: UpdateRegexMatchSetRequest
        ): Kleisli[M, WafClient, UpdateRegexMatchSetResponse] =
          primitive(_.updateRegexMatchSet(request))

        def updateRegexPatternSet(
          request: UpdateRegexPatternSetRequest
        ): Kleisli[M, WafClient, UpdateRegexPatternSetResponse] =
          primitive(_.updateRegexPatternSet(request))

        def updateRule(
          request: UpdateRuleRequest
        ): Kleisli[M, WafClient, UpdateRuleResponse] =
          primitive(_.updateRule(request))

        def updateRuleGroup(
          request: UpdateRuleGroupRequest
        ): Kleisli[M, WafClient, UpdateRuleGroupResponse] =
          primitive(_.updateRuleGroup(request))

        def updateSizeConstraintSet(
          request: UpdateSizeConstraintSetRequest
        ): Kleisli[M, WafClient, UpdateSizeConstraintSetResponse] =
          primitive(_.updateSizeConstraintSet(request))

        def updateSqlInjectionMatchSet(
          request: UpdateSqlInjectionMatchSetRequest
        ): Kleisli[M, WafClient, UpdateSqlInjectionMatchSetResponse] =
          primitive(_.updateSqlInjectionMatchSet(request))

        def updateWebACL(
          request: UpdateWebAclRequest
        ): Kleisli[M, WafClient, UpdateWebAclResponse] =
          primitive(_.updateWebACL(request))

        def updateXssMatchSet(
          request: UpdateXssMatchSetRequest
        ): Kleisli[M, WafClient, UpdateXssMatchSetResponse] =
          primitive(_.updateXssMatchSet(request))

        def primitive[A](
          f: WafClient => A
        ): Kleisli[M, WafClient, A]
      }
    }

    trait Visitor[F[_]] extends (WafOp ~> F) {
      final def apply[A](op: WafOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

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
    ) extends WafOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateByteMatchSetOp(
      request: CreateByteMatchSetRequest
    ) extends WafOp[CreateByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateByteMatchSetResponse] =
        visitor.createByteMatchSet(request)
    }

    final case class CreateGeoMatchSetOp(
      request: CreateGeoMatchSetRequest
    ) extends WafOp[CreateGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGeoMatchSetResponse] =
        visitor.createGeoMatchSet(request)
    }

    final case class CreateIPSetOp(
      request: CreateIpSetRequest
    ) extends WafOp[CreateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIpSetResponse] =
        visitor.createIPSet(request)
    }

    final case class CreateRateBasedRuleOp(
      request: CreateRateBasedRuleRequest
    ) extends WafOp[CreateRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRateBasedRuleResponse] =
        visitor.createRateBasedRule(request)
    }

    final case class CreateRegexMatchSetOp(
      request: CreateRegexMatchSetRequest
    ) extends WafOp[CreateRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRegexMatchSetResponse] =
        visitor.createRegexMatchSet(request)
    }

    final case class CreateRegexPatternSetOp(
      request: CreateRegexPatternSetRequest
    ) extends WafOp[CreateRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRegexPatternSetResponse] =
        visitor.createRegexPatternSet(request)
    }

    final case class CreateRuleOp(
      request: CreateRuleRequest
    ) extends WafOp[CreateRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleResponse] =
        visitor.createRule(request)
    }

    final case class CreateRuleGroupOp(
      request: CreateRuleGroupRequest
    ) extends WafOp[CreateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleGroupResponse] =
        visitor.createRuleGroup(request)
    }

    final case class CreateSizeConstraintSetOp(
      request: CreateSizeConstraintSetRequest
    ) extends WafOp[CreateSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSizeConstraintSetResponse] =
        visitor.createSizeConstraintSet(request)
    }

    final case class CreateSqlInjectionMatchSetOp(
      request: CreateSqlInjectionMatchSetRequest
    ) extends WafOp[CreateSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSqlInjectionMatchSetResponse] =
        visitor.createSqlInjectionMatchSet(request)
    }

    final case class CreateWebACLOp(
      request: CreateWebAclRequest
    ) extends WafOp[CreateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebAclResponse] =
        visitor.createWebACL(request)
    }

    final case class CreateWebACLMigrationStackOp(
      request: CreateWebAclMigrationStackRequest
    ) extends WafOp[CreateWebAclMigrationStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebAclMigrationStackResponse] =
        visitor.createWebACLMigrationStack(request)
    }

    final case class CreateXssMatchSetOp(
      request: CreateXssMatchSetRequest
    ) extends WafOp[CreateXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateXssMatchSetResponse] =
        visitor.createXssMatchSet(request)
    }

    final case class DeleteByteMatchSetOp(
      request: DeleteByteMatchSetRequest
    ) extends WafOp[DeleteByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteByteMatchSetResponse] =
        visitor.deleteByteMatchSet(request)
    }

    final case class DeleteGeoMatchSetOp(
      request: DeleteGeoMatchSetRequest
    ) extends WafOp[DeleteGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGeoMatchSetResponse] =
        visitor.deleteGeoMatchSet(request)
    }

    final case class DeleteIPSetOp(
      request: DeleteIpSetRequest
    ) extends WafOp[DeleteIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIpSetResponse] =
        visitor.deleteIPSet(request)
    }

    final case class DeleteLoggingConfigurationOp(
      request: DeleteLoggingConfigurationRequest
    ) extends WafOp[DeleteLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoggingConfigurationResponse] =
        visitor.deleteLoggingConfiguration(request)
    }

    final case class DeletePermissionPolicyOp(
      request: DeletePermissionPolicyRequest
    ) extends WafOp[DeletePermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePermissionPolicyResponse] =
        visitor.deletePermissionPolicy(request)
    }

    final case class DeleteRateBasedRuleOp(
      request: DeleteRateBasedRuleRequest
    ) extends WafOp[DeleteRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRateBasedRuleResponse] =
        visitor.deleteRateBasedRule(request)
    }

    final case class DeleteRegexMatchSetOp(
      request: DeleteRegexMatchSetRequest
    ) extends WafOp[DeleteRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegexMatchSetResponse] =
        visitor.deleteRegexMatchSet(request)
    }

    final case class DeleteRegexPatternSetOp(
      request: DeleteRegexPatternSetRequest
    ) extends WafOp[DeleteRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegexPatternSetResponse] =
        visitor.deleteRegexPatternSet(request)
    }

    final case class DeleteRuleOp(
      request: DeleteRuleRequest
    ) extends WafOp[DeleteRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleResponse] =
        visitor.deleteRule(request)
    }

    final case class DeleteRuleGroupOp(
      request: DeleteRuleGroupRequest
    ) extends WafOp[DeleteRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleGroupResponse] =
        visitor.deleteRuleGroup(request)
    }

    final case class DeleteSizeConstraintSetOp(
      request: DeleteSizeConstraintSetRequest
    ) extends WafOp[DeleteSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSizeConstraintSetResponse] =
        visitor.deleteSizeConstraintSet(request)
    }

    final case class DeleteSqlInjectionMatchSetOp(
      request: DeleteSqlInjectionMatchSetRequest
    ) extends WafOp[DeleteSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSqlInjectionMatchSetResponse] =
        visitor.deleteSqlInjectionMatchSet(request)
    }

    final case class DeleteWebACLOp(
      request: DeleteWebAclRequest
    ) extends WafOp[DeleteWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWebAclResponse] =
        visitor.deleteWebACL(request)
    }

    final case class DeleteXssMatchSetOp(
      request: DeleteXssMatchSetRequest
    ) extends WafOp[DeleteXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteXssMatchSetResponse] =
        visitor.deleteXssMatchSet(request)
    }

    final case class GetByteMatchSetOp(
      request: GetByteMatchSetRequest
    ) extends WafOp[GetByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetByteMatchSetResponse] =
        visitor.getByteMatchSet(request)
    }

    final case class GetChangeTokenOp(
      request: GetChangeTokenRequest
    ) extends WafOp[GetChangeTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChangeTokenResponse] =
        visitor.getChangeToken(request)
    }

    final case class GetChangeTokenStatusOp(
      request: GetChangeTokenStatusRequest
    ) extends WafOp[GetChangeTokenStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChangeTokenStatusResponse] =
        visitor.getChangeTokenStatus(request)
    }

    final case class GetGeoMatchSetOp(
      request: GetGeoMatchSetRequest
    ) extends WafOp[GetGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGeoMatchSetResponse] =
        visitor.getGeoMatchSet(request)
    }

    final case class GetIPSetOp(
      request: GetIpSetRequest
    ) extends WafOp[GetIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIpSetResponse] =
        visitor.getIPSet(request)
    }

    final case class GetLoggingConfigurationOp(
      request: GetLoggingConfigurationRequest
    ) extends WafOp[GetLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoggingConfigurationResponse] =
        visitor.getLoggingConfiguration(request)
    }

    final case class GetPermissionPolicyOp(
      request: GetPermissionPolicyRequest
    ) extends WafOp[GetPermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPermissionPolicyResponse] =
        visitor.getPermissionPolicy(request)
    }

    final case class GetRateBasedRuleOp(
      request: GetRateBasedRuleRequest
    ) extends WafOp[GetRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRateBasedRuleResponse] =
        visitor.getRateBasedRule(request)
    }

    final case class GetRateBasedRuleManagedKeysOp(
      request: GetRateBasedRuleManagedKeysRequest
    ) extends WafOp[GetRateBasedRuleManagedKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRateBasedRuleManagedKeysResponse] =
        visitor.getRateBasedRuleManagedKeys(request)
    }

    final case class GetRegexMatchSetOp(
      request: GetRegexMatchSetRequest
    ) extends WafOp[GetRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegexMatchSetResponse] =
        visitor.getRegexMatchSet(request)
    }

    final case class GetRegexPatternSetOp(
      request: GetRegexPatternSetRequest
    ) extends WafOp[GetRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegexPatternSetResponse] =
        visitor.getRegexPatternSet(request)
    }

    final case class GetRuleOp(
      request: GetRuleRequest
    ) extends WafOp[GetRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRuleResponse] =
        visitor.getRule(request)
    }

    final case class GetRuleGroupOp(
      request: GetRuleGroupRequest
    ) extends WafOp[GetRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRuleGroupResponse] =
        visitor.getRuleGroup(request)
    }

    final case class GetSampledRequestsOp(
      request: GetSampledRequestsRequest
    ) extends WafOp[GetSampledRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSampledRequestsResponse] =
        visitor.getSampledRequests(request)
    }

    final case class GetSizeConstraintSetOp(
      request: GetSizeConstraintSetRequest
    ) extends WafOp[GetSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSizeConstraintSetResponse] =
        visitor.getSizeConstraintSet(request)
    }

    final case class GetSqlInjectionMatchSetOp(
      request: GetSqlInjectionMatchSetRequest
    ) extends WafOp[GetSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSqlInjectionMatchSetResponse] =
        visitor.getSqlInjectionMatchSet(request)
    }

    final case class GetWebACLOp(
      request: GetWebAclRequest
    ) extends WafOp[GetWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWebAclResponse] =
        visitor.getWebACL(request)
    }

    final case class GetXssMatchSetOp(
      request: GetXssMatchSetRequest
    ) extends WafOp[GetXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetXssMatchSetResponse] =
        visitor.getXssMatchSet(request)
    }

    final case class ListActivatedRulesInRuleGroupOp(
      request: ListActivatedRulesInRuleGroupRequest
    ) extends WafOp[ListActivatedRulesInRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActivatedRulesInRuleGroupResponse] =
        visitor.listActivatedRulesInRuleGroup(request)
    }

    final case class ListByteMatchSetsOp(
      request: ListByteMatchSetsRequest
    ) extends WafOp[ListByteMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListByteMatchSetsResponse] =
        visitor.listByteMatchSets(request)
    }

    final case class ListGeoMatchSetsOp(
      request: ListGeoMatchSetsRequest
    ) extends WafOp[ListGeoMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGeoMatchSetsResponse] =
        visitor.listGeoMatchSets(request)
    }

    final case class ListIPSetsOp(
      request: ListIpSetsRequest
    ) extends WafOp[ListIpSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIpSetsResponse] =
        visitor.listIPSets(request)
    }

    final case class ListLoggingConfigurationsOp(
      request: ListLoggingConfigurationsRequest
    ) extends WafOp[ListLoggingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLoggingConfigurationsResponse] =
        visitor.listLoggingConfigurations(request)
    }

    final case class ListRateBasedRulesOp(
      request: ListRateBasedRulesRequest
    ) extends WafOp[ListRateBasedRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRateBasedRulesResponse] =
        visitor.listRateBasedRules(request)
    }

    final case class ListRegexMatchSetsOp(
      request: ListRegexMatchSetsRequest
    ) extends WafOp[ListRegexMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegexMatchSetsResponse] =
        visitor.listRegexMatchSets(request)
    }

    final case class ListRegexPatternSetsOp(
      request: ListRegexPatternSetsRequest
    ) extends WafOp[ListRegexPatternSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegexPatternSetsResponse] =
        visitor.listRegexPatternSets(request)
    }

    final case class ListRuleGroupsOp(
      request: ListRuleGroupsRequest
    ) extends WafOp[ListRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRuleGroupsResponse] =
        visitor.listRuleGroups(request)
    }

    final case class ListRulesOp(
      request: ListRulesRequest
    ) extends WafOp[ListRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRulesResponse] =
        visitor.listRules(request)
    }

    final case class ListSizeConstraintSetsOp(
      request: ListSizeConstraintSetsRequest
    ) extends WafOp[ListSizeConstraintSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSizeConstraintSetsResponse] =
        visitor.listSizeConstraintSets(request)
    }

    final case class ListSqlInjectionMatchSetsOp(
      request: ListSqlInjectionMatchSetsRequest
    ) extends WafOp[ListSqlInjectionMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSqlInjectionMatchSetsResponse] =
        visitor.listSqlInjectionMatchSets(request)
    }

    final case class ListSubscribedRuleGroupsOp(
      request: ListSubscribedRuleGroupsRequest
    ) extends WafOp[ListSubscribedRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSubscribedRuleGroupsResponse] =
        visitor.listSubscribedRuleGroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends WafOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWebACLsOp(
      request: ListWebAcLsRequest
    ) extends WafOp[ListWebAcLsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWebAcLsResponse] =
        visitor.listWebACLs(request)
    }

    final case class ListXssMatchSetsOp(
      request: ListXssMatchSetsRequest
    ) extends WafOp[ListXssMatchSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListXssMatchSetsResponse] =
        visitor.listXssMatchSets(request)
    }

    final case class PutLoggingConfigurationOp(
      request: PutLoggingConfigurationRequest
    ) extends WafOp[PutLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLoggingConfigurationResponse] =
        visitor.putLoggingConfiguration(request)
    }

    final case class PutPermissionPolicyOp(
      request: PutPermissionPolicyRequest
    ) extends WafOp[PutPermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPermissionPolicyResponse] =
        visitor.putPermissionPolicy(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends WafOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends WafOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateByteMatchSetOp(
      request: UpdateByteMatchSetRequest
    ) extends WafOp[UpdateByteMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateByteMatchSetResponse] =
        visitor.updateByteMatchSet(request)
    }

    final case class UpdateGeoMatchSetOp(
      request: UpdateGeoMatchSetRequest
    ) extends WafOp[UpdateGeoMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGeoMatchSetResponse] =
        visitor.updateGeoMatchSet(request)
    }

    final case class UpdateIPSetOp(
      request: UpdateIpSetRequest
    ) extends WafOp[UpdateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIpSetResponse] =
        visitor.updateIPSet(request)
    }

    final case class UpdateRateBasedRuleOp(
      request: UpdateRateBasedRuleRequest
    ) extends WafOp[UpdateRateBasedRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRateBasedRuleResponse] =
        visitor.updateRateBasedRule(request)
    }

    final case class UpdateRegexMatchSetOp(
      request: UpdateRegexMatchSetRequest
    ) extends WafOp[UpdateRegexMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegexMatchSetResponse] =
        visitor.updateRegexMatchSet(request)
    }

    final case class UpdateRegexPatternSetOp(
      request: UpdateRegexPatternSetRequest
    ) extends WafOp[UpdateRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegexPatternSetResponse] =
        visitor.updateRegexPatternSet(request)
    }

    final case class UpdateRuleOp(
      request: UpdateRuleRequest
    ) extends WafOp[UpdateRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleResponse] =
        visitor.updateRule(request)
    }

    final case class UpdateRuleGroupOp(
      request: UpdateRuleGroupRequest
    ) extends WafOp[UpdateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleGroupResponse] =
        visitor.updateRuleGroup(request)
    }

    final case class UpdateSizeConstraintSetOp(
      request: UpdateSizeConstraintSetRequest
    ) extends WafOp[UpdateSizeConstraintSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSizeConstraintSetResponse] =
        visitor.updateSizeConstraintSet(request)
    }

    final case class UpdateSqlInjectionMatchSetOp(
      request: UpdateSqlInjectionMatchSetRequest
    ) extends WafOp[UpdateSqlInjectionMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSqlInjectionMatchSetResponse] =
        visitor.updateSqlInjectionMatchSet(request)
    }

    final case class UpdateWebACLOp(
      request: UpdateWebAclRequest
    ) extends WafOp[UpdateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWebAclResponse] =
        visitor.updateWebACL(request)
    }

    final case class UpdateXssMatchSetOp(
      request: UpdateXssMatchSetRequest
    ) extends WafOp[UpdateXssMatchSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateXssMatchSetResponse] =
        visitor.updateXssMatchSet(request)
    }
  }

  import WafOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WafOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createByteMatchSet(
    request: CreateByteMatchSetRequest
  ): WafIO[CreateByteMatchSetResponse] =
    FF.liftF(CreateByteMatchSetOp(request))

  def createGeoMatchSet(
    request: CreateGeoMatchSetRequest
  ): WafIO[CreateGeoMatchSetResponse] =
    FF.liftF(CreateGeoMatchSetOp(request))

  def createIPSet(
    request: CreateIpSetRequest
  ): WafIO[CreateIpSetResponse] =
    FF.liftF(CreateIPSetOp(request))

  def createRateBasedRule(
    request: CreateRateBasedRuleRequest
  ): WafIO[CreateRateBasedRuleResponse] =
    FF.liftF(CreateRateBasedRuleOp(request))

  def createRegexMatchSet(
    request: CreateRegexMatchSetRequest
  ): WafIO[CreateRegexMatchSetResponse] =
    FF.liftF(CreateRegexMatchSetOp(request))

  def createRegexPatternSet(
    request: CreateRegexPatternSetRequest
  ): WafIO[CreateRegexPatternSetResponse] =
    FF.liftF(CreateRegexPatternSetOp(request))

  def createRule(
    request: CreateRuleRequest
  ): WafIO[CreateRuleResponse] =
    FF.liftF(CreateRuleOp(request))

  def createRuleGroup(
    request: CreateRuleGroupRequest
  ): WafIO[CreateRuleGroupResponse] =
    FF.liftF(CreateRuleGroupOp(request))

  def createSizeConstraintSet(
    request: CreateSizeConstraintSetRequest
  ): WafIO[CreateSizeConstraintSetResponse] =
    FF.liftF(CreateSizeConstraintSetOp(request))

  def createSqlInjectionMatchSet(
    request: CreateSqlInjectionMatchSetRequest
  ): WafIO[CreateSqlInjectionMatchSetResponse] =
    FF.liftF(CreateSqlInjectionMatchSetOp(request))

  def createWebACL(
    request: CreateWebAclRequest
  ): WafIO[CreateWebAclResponse] =
    FF.liftF(CreateWebACLOp(request))

  def createWebACLMigrationStack(
    request: CreateWebAclMigrationStackRequest
  ): WafIO[CreateWebAclMigrationStackResponse] =
    FF.liftF(CreateWebACLMigrationStackOp(request))

  def createXssMatchSet(
    request: CreateXssMatchSetRequest
  ): WafIO[CreateXssMatchSetResponse] =
    FF.liftF(CreateXssMatchSetOp(request))

  def deleteByteMatchSet(
    request: DeleteByteMatchSetRequest
  ): WafIO[DeleteByteMatchSetResponse] =
    FF.liftF(DeleteByteMatchSetOp(request))

  def deleteGeoMatchSet(
    request: DeleteGeoMatchSetRequest
  ): WafIO[DeleteGeoMatchSetResponse] =
    FF.liftF(DeleteGeoMatchSetOp(request))

  def deleteIPSet(
    request: DeleteIpSetRequest
  ): WafIO[DeleteIpSetResponse] =
    FF.liftF(DeleteIPSetOp(request))

  def deleteLoggingConfiguration(
    request: DeleteLoggingConfigurationRequest
  ): WafIO[DeleteLoggingConfigurationResponse] =
    FF.liftF(DeleteLoggingConfigurationOp(request))

  def deletePermissionPolicy(
    request: DeletePermissionPolicyRequest
  ): WafIO[DeletePermissionPolicyResponse] =
    FF.liftF(DeletePermissionPolicyOp(request))

  def deleteRateBasedRule(
    request: DeleteRateBasedRuleRequest
  ): WafIO[DeleteRateBasedRuleResponse] =
    FF.liftF(DeleteRateBasedRuleOp(request))

  def deleteRegexMatchSet(
    request: DeleteRegexMatchSetRequest
  ): WafIO[DeleteRegexMatchSetResponse] =
    FF.liftF(DeleteRegexMatchSetOp(request))

  def deleteRegexPatternSet(
    request: DeleteRegexPatternSetRequest
  ): WafIO[DeleteRegexPatternSetResponse] =
    FF.liftF(DeleteRegexPatternSetOp(request))

  def deleteRule(
    request: DeleteRuleRequest
  ): WafIO[DeleteRuleResponse] =
    FF.liftF(DeleteRuleOp(request))

  def deleteRuleGroup(
    request: DeleteRuleGroupRequest
  ): WafIO[DeleteRuleGroupResponse] =
    FF.liftF(DeleteRuleGroupOp(request))

  def deleteSizeConstraintSet(
    request: DeleteSizeConstraintSetRequest
  ): WafIO[DeleteSizeConstraintSetResponse] =
    FF.liftF(DeleteSizeConstraintSetOp(request))

  def deleteSqlInjectionMatchSet(
    request: DeleteSqlInjectionMatchSetRequest
  ): WafIO[DeleteSqlInjectionMatchSetResponse] =
    FF.liftF(DeleteSqlInjectionMatchSetOp(request))

  def deleteWebACL(
    request: DeleteWebAclRequest
  ): WafIO[DeleteWebAclResponse] =
    FF.liftF(DeleteWebACLOp(request))

  def deleteXssMatchSet(
    request: DeleteXssMatchSetRequest
  ): WafIO[DeleteXssMatchSetResponse] =
    FF.liftF(DeleteXssMatchSetOp(request))

  def getByteMatchSet(
    request: GetByteMatchSetRequest
  ): WafIO[GetByteMatchSetResponse] =
    FF.liftF(GetByteMatchSetOp(request))

  def getChangeToken(
    request: GetChangeTokenRequest
  ): WafIO[GetChangeTokenResponse] =
    FF.liftF(GetChangeTokenOp(request))

  def getChangeTokenStatus(
    request: GetChangeTokenStatusRequest
  ): WafIO[GetChangeTokenStatusResponse] =
    FF.liftF(GetChangeTokenStatusOp(request))

  def getGeoMatchSet(
    request: GetGeoMatchSetRequest
  ): WafIO[GetGeoMatchSetResponse] =
    FF.liftF(GetGeoMatchSetOp(request))

  def getIPSet(
    request: GetIpSetRequest
  ): WafIO[GetIpSetResponse] =
    FF.liftF(GetIPSetOp(request))

  def getLoggingConfiguration(
    request: GetLoggingConfigurationRequest
  ): WafIO[GetLoggingConfigurationResponse] =
    FF.liftF(GetLoggingConfigurationOp(request))

  def getPermissionPolicy(
    request: GetPermissionPolicyRequest
  ): WafIO[GetPermissionPolicyResponse] =
    FF.liftF(GetPermissionPolicyOp(request))

  def getRateBasedRule(
    request: GetRateBasedRuleRequest
  ): WafIO[GetRateBasedRuleResponse] =
    FF.liftF(GetRateBasedRuleOp(request))

  def getRateBasedRuleManagedKeys(
    request: GetRateBasedRuleManagedKeysRequest
  ): WafIO[GetRateBasedRuleManagedKeysResponse] =
    FF.liftF(GetRateBasedRuleManagedKeysOp(request))

  def getRegexMatchSet(
    request: GetRegexMatchSetRequest
  ): WafIO[GetRegexMatchSetResponse] =
    FF.liftF(GetRegexMatchSetOp(request))

  def getRegexPatternSet(
    request: GetRegexPatternSetRequest
  ): WafIO[GetRegexPatternSetResponse] =
    FF.liftF(GetRegexPatternSetOp(request))

  def getRule(
    request: GetRuleRequest
  ): WafIO[GetRuleResponse] =
    FF.liftF(GetRuleOp(request))

  def getRuleGroup(
    request: GetRuleGroupRequest
  ): WafIO[GetRuleGroupResponse] =
    FF.liftF(GetRuleGroupOp(request))

  def getSampledRequests(
    request: GetSampledRequestsRequest
  ): WafIO[GetSampledRequestsResponse] =
    FF.liftF(GetSampledRequestsOp(request))

  def getSizeConstraintSet(
    request: GetSizeConstraintSetRequest
  ): WafIO[GetSizeConstraintSetResponse] =
    FF.liftF(GetSizeConstraintSetOp(request))

  def getSqlInjectionMatchSet(
    request: GetSqlInjectionMatchSetRequest
  ): WafIO[GetSqlInjectionMatchSetResponse] =
    FF.liftF(GetSqlInjectionMatchSetOp(request))

  def getWebACL(
    request: GetWebAclRequest
  ): WafIO[GetWebAclResponse] =
    FF.liftF(GetWebACLOp(request))

  def getXssMatchSet(
    request: GetXssMatchSetRequest
  ): WafIO[GetXssMatchSetResponse] =
    FF.liftF(GetXssMatchSetOp(request))

  def listActivatedRulesInRuleGroup(
    request: ListActivatedRulesInRuleGroupRequest
  ): WafIO[ListActivatedRulesInRuleGroupResponse] =
    FF.liftF(ListActivatedRulesInRuleGroupOp(request))

  def listByteMatchSets(
    request: ListByteMatchSetsRequest
  ): WafIO[ListByteMatchSetsResponse] =
    FF.liftF(ListByteMatchSetsOp(request))

  def listGeoMatchSets(
    request: ListGeoMatchSetsRequest
  ): WafIO[ListGeoMatchSetsResponse] =
    FF.liftF(ListGeoMatchSetsOp(request))

  def listIPSets(
    request: ListIpSetsRequest
  ): WafIO[ListIpSetsResponse] =
    FF.liftF(ListIPSetsOp(request))

  def listLoggingConfigurations(
    request: ListLoggingConfigurationsRequest
  ): WafIO[ListLoggingConfigurationsResponse] =
    FF.liftF(ListLoggingConfigurationsOp(request))

  def listRateBasedRules(
    request: ListRateBasedRulesRequest
  ): WafIO[ListRateBasedRulesResponse] =
    FF.liftF(ListRateBasedRulesOp(request))

  def listRegexMatchSets(
    request: ListRegexMatchSetsRequest
  ): WafIO[ListRegexMatchSetsResponse] =
    FF.liftF(ListRegexMatchSetsOp(request))

  def listRegexPatternSets(
    request: ListRegexPatternSetsRequest
  ): WafIO[ListRegexPatternSetsResponse] =
    FF.liftF(ListRegexPatternSetsOp(request))

  def listRuleGroups(
    request: ListRuleGroupsRequest
  ): WafIO[ListRuleGroupsResponse] =
    FF.liftF(ListRuleGroupsOp(request))

  def listRules(
    request: ListRulesRequest
  ): WafIO[ListRulesResponse] =
    FF.liftF(ListRulesOp(request))

  def listSizeConstraintSets(
    request: ListSizeConstraintSetsRequest
  ): WafIO[ListSizeConstraintSetsResponse] =
    FF.liftF(ListSizeConstraintSetsOp(request))

  def listSqlInjectionMatchSets(
    request: ListSqlInjectionMatchSetsRequest
  ): WafIO[ListSqlInjectionMatchSetsResponse] =
    FF.liftF(ListSqlInjectionMatchSetsOp(request))

  def listSubscribedRuleGroups(
    request: ListSubscribedRuleGroupsRequest
  ): WafIO[ListSubscribedRuleGroupsResponse] =
    FF.liftF(ListSubscribedRuleGroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): WafIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWebACLs(
    request: ListWebAcLsRequest
  ): WafIO[ListWebAcLsResponse] =
    FF.liftF(ListWebACLsOp(request))

  def listXssMatchSets(
    request: ListXssMatchSetsRequest
  ): WafIO[ListXssMatchSetsResponse] =
    FF.liftF(ListXssMatchSetsOp(request))

  def putLoggingConfiguration(
    request: PutLoggingConfigurationRequest
  ): WafIO[PutLoggingConfigurationResponse] =
    FF.liftF(PutLoggingConfigurationOp(request))

  def putPermissionPolicy(
    request: PutPermissionPolicyRequest
  ): WafIO[PutPermissionPolicyResponse] =
    FF.liftF(PutPermissionPolicyOp(request))

  def tagResource(
    request: TagResourceRequest
  ): WafIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): WafIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateByteMatchSet(
    request: UpdateByteMatchSetRequest
  ): WafIO[UpdateByteMatchSetResponse] =
    FF.liftF(UpdateByteMatchSetOp(request))

  def updateGeoMatchSet(
    request: UpdateGeoMatchSetRequest
  ): WafIO[UpdateGeoMatchSetResponse] =
    FF.liftF(UpdateGeoMatchSetOp(request))

  def updateIPSet(
    request: UpdateIpSetRequest
  ): WafIO[UpdateIpSetResponse] =
    FF.liftF(UpdateIPSetOp(request))

  def updateRateBasedRule(
    request: UpdateRateBasedRuleRequest
  ): WafIO[UpdateRateBasedRuleResponse] =
    FF.liftF(UpdateRateBasedRuleOp(request))

  def updateRegexMatchSet(
    request: UpdateRegexMatchSetRequest
  ): WafIO[UpdateRegexMatchSetResponse] =
    FF.liftF(UpdateRegexMatchSetOp(request))

  def updateRegexPatternSet(
    request: UpdateRegexPatternSetRequest
  ): WafIO[UpdateRegexPatternSetResponse] =
    FF.liftF(UpdateRegexPatternSetOp(request))

  def updateRule(
    request: UpdateRuleRequest
  ): WafIO[UpdateRuleResponse] =
    FF.liftF(UpdateRuleOp(request))

  def updateRuleGroup(
    request: UpdateRuleGroupRequest
  ): WafIO[UpdateRuleGroupResponse] =
    FF.liftF(UpdateRuleGroupOp(request))

  def updateSizeConstraintSet(
    request: UpdateSizeConstraintSetRequest
  ): WafIO[UpdateSizeConstraintSetResponse] =
    FF.liftF(UpdateSizeConstraintSetOp(request))

  def updateSqlInjectionMatchSet(
    request: UpdateSqlInjectionMatchSetRequest
  ): WafIO[UpdateSqlInjectionMatchSetResponse] =
    FF.liftF(UpdateSqlInjectionMatchSetOp(request))

  def updateWebACL(
    request: UpdateWebAclRequest
  ): WafIO[UpdateWebAclResponse] =
    FF.liftF(UpdateWebACLOp(request))

  def updateXssMatchSet(
    request: UpdateXssMatchSetRequest
  ): WafIO[UpdateXssMatchSetResponse] =
    FF.liftF(UpdateXssMatchSetOp(request))
}
