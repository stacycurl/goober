package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.wafv2.Wafv2Client
import software.amazon.awssdk.services.wafv2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object wafv2 { module =>

  // Free monad over Wafv2Op
  type Wafv2IO[A] = FF[Wafv2Op, A]

  sealed trait Wafv2Op[A] {
    def visit[F[_]](visitor: Wafv2Op.Visitor[F]): F[A]
  }

  object Wafv2Op {
    // Given a Wafv2Client we can embed a Wafv2IO program in any algebra that understands embedding.
    implicit val Wafv2OpEmbeddable: Embeddable[Wafv2Op, Wafv2Client] = new Embeddable[Wafv2Op, Wafv2Client] {
      def embed[A](client: Wafv2Client, io: Wafv2IO[A]): Embedded[A] = Embedded.Wafv2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Wafv2Op.Visitor[Kleisli[M, Wafv2Client, *]] {
        def associateWebACL(
          request: AssociateWebAclRequest
        ): Kleisli[M, Wafv2Client, AssociateWebAclResponse] =
          primitive(_.associateWebACL(request))

        def checkCapacity(
          request: CheckCapacityRequest
        ): Kleisli[M, Wafv2Client, CheckCapacityResponse] =
          primitive(_.checkCapacity(request))

        def createIPSet(
          request: CreateIpSetRequest
        ): Kleisli[M, Wafv2Client, CreateIpSetResponse] =
          primitive(_.createIPSet(request))

        def createRegexPatternSet(
          request: CreateRegexPatternSetRequest
        ): Kleisli[M, Wafv2Client, CreateRegexPatternSetResponse] =
          primitive(_.createRegexPatternSet(request))

        def createRuleGroup(
          request: CreateRuleGroupRequest
        ): Kleisli[M, Wafv2Client, CreateRuleGroupResponse] =
          primitive(_.createRuleGroup(request))

        def createWebACL(
          request: CreateWebAclRequest
        ): Kleisli[M, Wafv2Client, CreateWebAclResponse] =
          primitive(_.createWebACL(request))

        def deleteFirewallManagerRuleGroups(
          request: DeleteFirewallManagerRuleGroupsRequest
        ): Kleisli[M, Wafv2Client, DeleteFirewallManagerRuleGroupsResponse] =
          primitive(_.deleteFirewallManagerRuleGroups(request))

        def deleteIPSet(
          request: DeleteIpSetRequest
        ): Kleisli[M, Wafv2Client, DeleteIpSetResponse] =
          primitive(_.deleteIPSet(request))

        def deleteLoggingConfiguration(
          request: DeleteLoggingConfigurationRequest
        ): Kleisli[M, Wafv2Client, DeleteLoggingConfigurationResponse] =
          primitive(_.deleteLoggingConfiguration(request))

        def deletePermissionPolicy(
          request: DeletePermissionPolicyRequest
        ): Kleisli[M, Wafv2Client, DeletePermissionPolicyResponse] =
          primitive(_.deletePermissionPolicy(request))

        def deleteRegexPatternSet(
          request: DeleteRegexPatternSetRequest
        ): Kleisli[M, Wafv2Client, DeleteRegexPatternSetResponse] =
          primitive(_.deleteRegexPatternSet(request))

        def deleteRuleGroup(
          request: DeleteRuleGroupRequest
        ): Kleisli[M, Wafv2Client, DeleteRuleGroupResponse] =
          primitive(_.deleteRuleGroup(request))

        def deleteWebACL(
          request: DeleteWebAclRequest
        ): Kleisli[M, Wafv2Client, DeleteWebAclResponse] =
          primitive(_.deleteWebACL(request))

        def describeManagedRuleGroup(
          request: DescribeManagedRuleGroupRequest
        ): Kleisli[M, Wafv2Client, DescribeManagedRuleGroupResponse] =
          primitive(_.describeManagedRuleGroup(request))

        def disassociateWebACL(
          request: DisassociateWebAclRequest
        ): Kleisli[M, Wafv2Client, DisassociateWebAclResponse] =
          primitive(_.disassociateWebACL(request))

        def getIPSet(
          request: GetIpSetRequest
        ): Kleisli[M, Wafv2Client, GetIpSetResponse] =
          primitive(_.getIPSet(request))

        def getLoggingConfiguration(
          request: GetLoggingConfigurationRequest
        ): Kleisli[M, Wafv2Client, GetLoggingConfigurationResponse] =
          primitive(_.getLoggingConfiguration(request))

        def getPermissionPolicy(
          request: GetPermissionPolicyRequest
        ): Kleisli[M, Wafv2Client, GetPermissionPolicyResponse] =
          primitive(_.getPermissionPolicy(request))

        def getRateBasedStatementManagedKeys(
          request: GetRateBasedStatementManagedKeysRequest
        ): Kleisli[M, Wafv2Client, GetRateBasedStatementManagedKeysResponse] =
          primitive(_.getRateBasedStatementManagedKeys(request))

        def getRegexPatternSet(
          request: GetRegexPatternSetRequest
        ): Kleisli[M, Wafv2Client, GetRegexPatternSetResponse] =
          primitive(_.getRegexPatternSet(request))

        def getRuleGroup(
          request: GetRuleGroupRequest
        ): Kleisli[M, Wafv2Client, GetRuleGroupResponse] =
          primitive(_.getRuleGroup(request))

        def getSampledRequests(
          request: GetSampledRequestsRequest
        ): Kleisli[M, Wafv2Client, GetSampledRequestsResponse] =
          primitive(_.getSampledRequests(request))

        def getWebACL(
          request: GetWebAclRequest
        ): Kleisli[M, Wafv2Client, GetWebAclResponse] =
          primitive(_.getWebACL(request))

        def getWebACLForResource(
          request: GetWebAclForResourceRequest
        ): Kleisli[M, Wafv2Client, GetWebAclForResourceResponse] =
          primitive(_.getWebACLForResource(request))

        def listAvailableManagedRuleGroups(
          request: ListAvailableManagedRuleGroupsRequest
        ): Kleisli[M, Wafv2Client, ListAvailableManagedRuleGroupsResponse] =
          primitive(_.listAvailableManagedRuleGroups(request))

        def listIPSets(
          request: ListIpSetsRequest
        ): Kleisli[M, Wafv2Client, ListIpSetsResponse] =
          primitive(_.listIPSets(request))

        def listLoggingConfigurations(
          request: ListLoggingConfigurationsRequest
        ): Kleisli[M, Wafv2Client, ListLoggingConfigurationsResponse] =
          primitive(_.listLoggingConfigurations(request))

        def listRegexPatternSets(
          request: ListRegexPatternSetsRequest
        ): Kleisli[M, Wafv2Client, ListRegexPatternSetsResponse] =
          primitive(_.listRegexPatternSets(request))

        def listResourcesForWebACL(
          request: ListResourcesForWebAclRequest
        ): Kleisli[M, Wafv2Client, ListResourcesForWebAclResponse] =
          primitive(_.listResourcesForWebACL(request))

        def listRuleGroups(
          request: ListRuleGroupsRequest
        ): Kleisli[M, Wafv2Client, ListRuleGroupsResponse] =
          primitive(_.listRuleGroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, Wafv2Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWebACLs(
          request: ListWebAcLsRequest
        ): Kleisli[M, Wafv2Client, ListWebAcLsResponse] =
          primitive(_.listWebACLs(request))

        def putLoggingConfiguration(
          request: PutLoggingConfigurationRequest
        ): Kleisli[M, Wafv2Client, PutLoggingConfigurationResponse] =
          primitive(_.putLoggingConfiguration(request))

        def putPermissionPolicy(
          request: PutPermissionPolicyRequest
        ): Kleisli[M, Wafv2Client, PutPermissionPolicyResponse] =
          primitive(_.putPermissionPolicy(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, Wafv2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, Wafv2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateIPSet(
          request: UpdateIpSetRequest
        ): Kleisli[M, Wafv2Client, UpdateIpSetResponse] =
          primitive(_.updateIPSet(request))

        def updateRegexPatternSet(
          request: UpdateRegexPatternSetRequest
        ): Kleisli[M, Wafv2Client, UpdateRegexPatternSetResponse] =
          primitive(_.updateRegexPatternSet(request))

        def updateRuleGroup(
          request: UpdateRuleGroupRequest
        ): Kleisli[M, Wafv2Client, UpdateRuleGroupResponse] =
          primitive(_.updateRuleGroup(request))

        def updateWebACL(
          request: UpdateWebAclRequest
        ): Kleisli[M, Wafv2Client, UpdateWebAclResponse] =
          primitive(_.updateWebACL(request))

        def primitive[A](
          f: Wafv2Client => A
        ): Kleisli[M, Wafv2Client, A]
      }
    }

    trait Visitor[F[_]] extends (Wafv2Op ~> F) {
      final def apply[A](op: Wafv2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateWebACL(
        request: AssociateWebAclRequest
      ): F[AssociateWebAclResponse]

      def checkCapacity(
        request: CheckCapacityRequest
      ): F[CheckCapacityResponse]

      def createIPSet(
        request: CreateIpSetRequest
      ): F[CreateIpSetResponse]

      def createRegexPatternSet(
        request: CreateRegexPatternSetRequest
      ): F[CreateRegexPatternSetResponse]

      def createRuleGroup(
        request: CreateRuleGroupRequest
      ): F[CreateRuleGroupResponse]

      def createWebACL(
        request: CreateWebAclRequest
      ): F[CreateWebAclResponse]

      def deleteFirewallManagerRuleGroups(
        request: DeleteFirewallManagerRuleGroupsRequest
      ): F[DeleteFirewallManagerRuleGroupsResponse]

      def deleteIPSet(
        request: DeleteIpSetRequest
      ): F[DeleteIpSetResponse]

      def deleteLoggingConfiguration(
        request: DeleteLoggingConfigurationRequest
      ): F[DeleteLoggingConfigurationResponse]

      def deletePermissionPolicy(
        request: DeletePermissionPolicyRequest
      ): F[DeletePermissionPolicyResponse]

      def deleteRegexPatternSet(
        request: DeleteRegexPatternSetRequest
      ): F[DeleteRegexPatternSetResponse]

      def deleteRuleGroup(
        request: DeleteRuleGroupRequest
      ): F[DeleteRuleGroupResponse]

      def deleteWebACL(
        request: DeleteWebAclRequest
      ): F[DeleteWebAclResponse]

      def describeManagedRuleGroup(
        request: DescribeManagedRuleGroupRequest
      ): F[DescribeManagedRuleGroupResponse]

      def disassociateWebACL(
        request: DisassociateWebAclRequest
      ): F[DisassociateWebAclResponse]

      def getIPSet(
        request: GetIpSetRequest
      ): F[GetIpSetResponse]

      def getLoggingConfiguration(
        request: GetLoggingConfigurationRequest
      ): F[GetLoggingConfigurationResponse]

      def getPermissionPolicy(
        request: GetPermissionPolicyRequest
      ): F[GetPermissionPolicyResponse]

      def getRateBasedStatementManagedKeys(
        request: GetRateBasedStatementManagedKeysRequest
      ): F[GetRateBasedStatementManagedKeysResponse]

      def getRegexPatternSet(
        request: GetRegexPatternSetRequest
      ): F[GetRegexPatternSetResponse]

      def getRuleGroup(
        request: GetRuleGroupRequest
      ): F[GetRuleGroupResponse]

      def getSampledRequests(
        request: GetSampledRequestsRequest
      ): F[GetSampledRequestsResponse]

      def getWebACL(
        request: GetWebAclRequest
      ): F[GetWebAclResponse]

      def getWebACLForResource(
        request: GetWebAclForResourceRequest
      ): F[GetWebAclForResourceResponse]

      def listAvailableManagedRuleGroups(
        request: ListAvailableManagedRuleGroupsRequest
      ): F[ListAvailableManagedRuleGroupsResponse]

      def listIPSets(
        request: ListIpSetsRequest
      ): F[ListIpSetsResponse]

      def listLoggingConfigurations(
        request: ListLoggingConfigurationsRequest
      ): F[ListLoggingConfigurationsResponse]

      def listRegexPatternSets(
        request: ListRegexPatternSetsRequest
      ): F[ListRegexPatternSetsResponse]

      def listResourcesForWebACL(
        request: ListResourcesForWebAclRequest
      ): F[ListResourcesForWebAclResponse]

      def listRuleGroups(
        request: ListRuleGroupsRequest
      ): F[ListRuleGroupsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWebACLs(
        request: ListWebAcLsRequest
      ): F[ListWebAcLsResponse]

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

      def updateIPSet(
        request: UpdateIpSetRequest
      ): F[UpdateIpSetResponse]

      def updateRegexPatternSet(
        request: UpdateRegexPatternSetRequest
      ): F[UpdateRegexPatternSetResponse]

      def updateRuleGroup(
        request: UpdateRuleGroupRequest
      ): F[UpdateRuleGroupResponse]

      def updateWebACL(
        request: UpdateWebAclRequest
      ): F[UpdateWebAclResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Wafv2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateWebACLOp(
      request: AssociateWebAclRequest
    ) extends Wafv2Op[AssociateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateWebAclResponse] =
        visitor.associateWebACL(request)
    }

    final case class CheckCapacityOp(
      request: CheckCapacityRequest
    ) extends Wafv2Op[CheckCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckCapacityResponse] =
        visitor.checkCapacity(request)
    }

    final case class CreateIPSetOp(
      request: CreateIpSetRequest
    ) extends Wafv2Op[CreateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIpSetResponse] =
        visitor.createIPSet(request)
    }

    final case class CreateRegexPatternSetOp(
      request: CreateRegexPatternSetRequest
    ) extends Wafv2Op[CreateRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRegexPatternSetResponse] =
        visitor.createRegexPatternSet(request)
    }

    final case class CreateRuleGroupOp(
      request: CreateRuleGroupRequest
    ) extends Wafv2Op[CreateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleGroupResponse] =
        visitor.createRuleGroup(request)
    }

    final case class CreateWebACLOp(
      request: CreateWebAclRequest
    ) extends Wafv2Op[CreateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebAclResponse] =
        visitor.createWebACL(request)
    }

    final case class DeleteFirewallManagerRuleGroupsOp(
      request: DeleteFirewallManagerRuleGroupsRequest
    ) extends Wafv2Op[DeleteFirewallManagerRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFirewallManagerRuleGroupsResponse] =
        visitor.deleteFirewallManagerRuleGroups(request)
    }

    final case class DeleteIPSetOp(
      request: DeleteIpSetRequest
    ) extends Wafv2Op[DeleteIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIpSetResponse] =
        visitor.deleteIPSet(request)
    }

    final case class DeleteLoggingConfigurationOp(
      request: DeleteLoggingConfigurationRequest
    ) extends Wafv2Op[DeleteLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoggingConfigurationResponse] =
        visitor.deleteLoggingConfiguration(request)
    }

    final case class DeletePermissionPolicyOp(
      request: DeletePermissionPolicyRequest
    ) extends Wafv2Op[DeletePermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePermissionPolicyResponse] =
        visitor.deletePermissionPolicy(request)
    }

    final case class DeleteRegexPatternSetOp(
      request: DeleteRegexPatternSetRequest
    ) extends Wafv2Op[DeleteRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegexPatternSetResponse] =
        visitor.deleteRegexPatternSet(request)
    }

    final case class DeleteRuleGroupOp(
      request: DeleteRuleGroupRequest
    ) extends Wafv2Op[DeleteRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleGroupResponse] =
        visitor.deleteRuleGroup(request)
    }

    final case class DeleteWebACLOp(
      request: DeleteWebAclRequest
    ) extends Wafv2Op[DeleteWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWebAclResponse] =
        visitor.deleteWebACL(request)
    }

    final case class DescribeManagedRuleGroupOp(
      request: DescribeManagedRuleGroupRequest
    ) extends Wafv2Op[DescribeManagedRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeManagedRuleGroupResponse] =
        visitor.describeManagedRuleGroup(request)
    }

    final case class DisassociateWebACLOp(
      request: DisassociateWebAclRequest
    ) extends Wafv2Op[DisassociateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateWebAclResponse] =
        visitor.disassociateWebACL(request)
    }

    final case class GetIPSetOp(
      request: GetIpSetRequest
    ) extends Wafv2Op[GetIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIpSetResponse] =
        visitor.getIPSet(request)
    }

    final case class GetLoggingConfigurationOp(
      request: GetLoggingConfigurationRequest
    ) extends Wafv2Op[GetLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoggingConfigurationResponse] =
        visitor.getLoggingConfiguration(request)
    }

    final case class GetPermissionPolicyOp(
      request: GetPermissionPolicyRequest
    ) extends Wafv2Op[GetPermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPermissionPolicyResponse] =
        visitor.getPermissionPolicy(request)
    }

    final case class GetRateBasedStatementManagedKeysOp(
      request: GetRateBasedStatementManagedKeysRequest
    ) extends Wafv2Op[GetRateBasedStatementManagedKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRateBasedStatementManagedKeysResponse] =
        visitor.getRateBasedStatementManagedKeys(request)
    }

    final case class GetRegexPatternSetOp(
      request: GetRegexPatternSetRequest
    ) extends Wafv2Op[GetRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegexPatternSetResponse] =
        visitor.getRegexPatternSet(request)
    }

    final case class GetRuleGroupOp(
      request: GetRuleGroupRequest
    ) extends Wafv2Op[GetRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRuleGroupResponse] =
        visitor.getRuleGroup(request)
    }

    final case class GetSampledRequestsOp(
      request: GetSampledRequestsRequest
    ) extends Wafv2Op[GetSampledRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSampledRequestsResponse] =
        visitor.getSampledRequests(request)
    }

    final case class GetWebACLOp(
      request: GetWebAclRequest
    ) extends Wafv2Op[GetWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWebAclResponse] =
        visitor.getWebACL(request)
    }

    final case class GetWebACLForResourceOp(
      request: GetWebAclForResourceRequest
    ) extends Wafv2Op[GetWebAclForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWebAclForResourceResponse] =
        visitor.getWebACLForResource(request)
    }

    final case class ListAvailableManagedRuleGroupsOp(
      request: ListAvailableManagedRuleGroupsRequest
    ) extends Wafv2Op[ListAvailableManagedRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAvailableManagedRuleGroupsResponse] =
        visitor.listAvailableManagedRuleGroups(request)
    }

    final case class ListIPSetsOp(
      request: ListIpSetsRequest
    ) extends Wafv2Op[ListIpSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIpSetsResponse] =
        visitor.listIPSets(request)
    }

    final case class ListLoggingConfigurationsOp(
      request: ListLoggingConfigurationsRequest
    ) extends Wafv2Op[ListLoggingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLoggingConfigurationsResponse] =
        visitor.listLoggingConfigurations(request)
    }

    final case class ListRegexPatternSetsOp(
      request: ListRegexPatternSetsRequest
    ) extends Wafv2Op[ListRegexPatternSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegexPatternSetsResponse] =
        visitor.listRegexPatternSets(request)
    }

    final case class ListResourcesForWebACLOp(
      request: ListResourcesForWebAclRequest
    ) extends Wafv2Op[ListResourcesForWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesForWebAclResponse] =
        visitor.listResourcesForWebACL(request)
    }

    final case class ListRuleGroupsOp(
      request: ListRuleGroupsRequest
    ) extends Wafv2Op[ListRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRuleGroupsResponse] =
        visitor.listRuleGroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends Wafv2Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWebACLsOp(
      request: ListWebAcLsRequest
    ) extends Wafv2Op[ListWebAcLsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWebAcLsResponse] =
        visitor.listWebACLs(request)
    }

    final case class PutLoggingConfigurationOp(
      request: PutLoggingConfigurationRequest
    ) extends Wafv2Op[PutLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLoggingConfigurationResponse] =
        visitor.putLoggingConfiguration(request)
    }

    final case class PutPermissionPolicyOp(
      request: PutPermissionPolicyRequest
    ) extends Wafv2Op[PutPermissionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPermissionPolicyResponse] =
        visitor.putPermissionPolicy(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends Wafv2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends Wafv2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateIPSetOp(
      request: UpdateIpSetRequest
    ) extends Wafv2Op[UpdateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIpSetResponse] =
        visitor.updateIPSet(request)
    }

    final case class UpdateRegexPatternSetOp(
      request: UpdateRegexPatternSetRequest
    ) extends Wafv2Op[UpdateRegexPatternSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegexPatternSetResponse] =
        visitor.updateRegexPatternSet(request)
    }

    final case class UpdateRuleGroupOp(
      request: UpdateRuleGroupRequest
    ) extends Wafv2Op[UpdateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleGroupResponse] =
        visitor.updateRuleGroup(request)
    }

    final case class UpdateWebACLOp(
      request: UpdateWebAclRequest
    ) extends Wafv2Op[UpdateWebAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWebAclResponse] =
        visitor.updateWebACL(request)
    }
  }

  import Wafv2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Wafv2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateWebACL(
    request: AssociateWebAclRequest
  ): Wafv2IO[AssociateWebAclResponse] =
    FF.liftF(AssociateWebACLOp(request))

  def checkCapacity(
    request: CheckCapacityRequest
  ): Wafv2IO[CheckCapacityResponse] =
    FF.liftF(CheckCapacityOp(request))

  def createIPSet(
    request: CreateIpSetRequest
  ): Wafv2IO[CreateIpSetResponse] =
    FF.liftF(CreateIPSetOp(request))

  def createRegexPatternSet(
    request: CreateRegexPatternSetRequest
  ): Wafv2IO[CreateRegexPatternSetResponse] =
    FF.liftF(CreateRegexPatternSetOp(request))

  def createRuleGroup(
    request: CreateRuleGroupRequest
  ): Wafv2IO[CreateRuleGroupResponse] =
    FF.liftF(CreateRuleGroupOp(request))

  def createWebACL(
    request: CreateWebAclRequest
  ): Wafv2IO[CreateWebAclResponse] =
    FF.liftF(CreateWebACLOp(request))

  def deleteFirewallManagerRuleGroups(
    request: DeleteFirewallManagerRuleGroupsRequest
  ): Wafv2IO[DeleteFirewallManagerRuleGroupsResponse] =
    FF.liftF(DeleteFirewallManagerRuleGroupsOp(request))

  def deleteIPSet(
    request: DeleteIpSetRequest
  ): Wafv2IO[DeleteIpSetResponse] =
    FF.liftF(DeleteIPSetOp(request))

  def deleteLoggingConfiguration(
    request: DeleteLoggingConfigurationRequest
  ): Wafv2IO[DeleteLoggingConfigurationResponse] =
    FF.liftF(DeleteLoggingConfigurationOp(request))

  def deletePermissionPolicy(
    request: DeletePermissionPolicyRequest
  ): Wafv2IO[DeletePermissionPolicyResponse] =
    FF.liftF(DeletePermissionPolicyOp(request))

  def deleteRegexPatternSet(
    request: DeleteRegexPatternSetRequest
  ): Wafv2IO[DeleteRegexPatternSetResponse] =
    FF.liftF(DeleteRegexPatternSetOp(request))

  def deleteRuleGroup(
    request: DeleteRuleGroupRequest
  ): Wafv2IO[DeleteRuleGroupResponse] =
    FF.liftF(DeleteRuleGroupOp(request))

  def deleteWebACL(
    request: DeleteWebAclRequest
  ): Wafv2IO[DeleteWebAclResponse] =
    FF.liftF(DeleteWebACLOp(request))

  def describeManagedRuleGroup(
    request: DescribeManagedRuleGroupRequest
  ): Wafv2IO[DescribeManagedRuleGroupResponse] =
    FF.liftF(DescribeManagedRuleGroupOp(request))

  def disassociateWebACL(
    request: DisassociateWebAclRequest
  ): Wafv2IO[DisassociateWebAclResponse] =
    FF.liftF(DisassociateWebACLOp(request))

  def getIPSet(
    request: GetIpSetRequest
  ): Wafv2IO[GetIpSetResponse] =
    FF.liftF(GetIPSetOp(request))

  def getLoggingConfiguration(
    request: GetLoggingConfigurationRequest
  ): Wafv2IO[GetLoggingConfigurationResponse] =
    FF.liftF(GetLoggingConfigurationOp(request))

  def getPermissionPolicy(
    request: GetPermissionPolicyRequest
  ): Wafv2IO[GetPermissionPolicyResponse] =
    FF.liftF(GetPermissionPolicyOp(request))

  def getRateBasedStatementManagedKeys(
    request: GetRateBasedStatementManagedKeysRequest
  ): Wafv2IO[GetRateBasedStatementManagedKeysResponse] =
    FF.liftF(GetRateBasedStatementManagedKeysOp(request))

  def getRegexPatternSet(
    request: GetRegexPatternSetRequest
  ): Wafv2IO[GetRegexPatternSetResponse] =
    FF.liftF(GetRegexPatternSetOp(request))

  def getRuleGroup(
    request: GetRuleGroupRequest
  ): Wafv2IO[GetRuleGroupResponse] =
    FF.liftF(GetRuleGroupOp(request))

  def getSampledRequests(
    request: GetSampledRequestsRequest
  ): Wafv2IO[GetSampledRequestsResponse] =
    FF.liftF(GetSampledRequestsOp(request))

  def getWebACL(
    request: GetWebAclRequest
  ): Wafv2IO[GetWebAclResponse] =
    FF.liftF(GetWebACLOp(request))

  def getWebACLForResource(
    request: GetWebAclForResourceRequest
  ): Wafv2IO[GetWebAclForResourceResponse] =
    FF.liftF(GetWebACLForResourceOp(request))

  def listAvailableManagedRuleGroups(
    request: ListAvailableManagedRuleGroupsRequest
  ): Wafv2IO[ListAvailableManagedRuleGroupsResponse] =
    FF.liftF(ListAvailableManagedRuleGroupsOp(request))

  def listIPSets(
    request: ListIpSetsRequest
  ): Wafv2IO[ListIpSetsResponse] =
    FF.liftF(ListIPSetsOp(request))

  def listLoggingConfigurations(
    request: ListLoggingConfigurationsRequest
  ): Wafv2IO[ListLoggingConfigurationsResponse] =
    FF.liftF(ListLoggingConfigurationsOp(request))

  def listRegexPatternSets(
    request: ListRegexPatternSetsRequest
  ): Wafv2IO[ListRegexPatternSetsResponse] =
    FF.liftF(ListRegexPatternSetsOp(request))

  def listResourcesForWebACL(
    request: ListResourcesForWebAclRequest
  ): Wafv2IO[ListResourcesForWebAclResponse] =
    FF.liftF(ListResourcesForWebACLOp(request))

  def listRuleGroups(
    request: ListRuleGroupsRequest
  ): Wafv2IO[ListRuleGroupsResponse] =
    FF.liftF(ListRuleGroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): Wafv2IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWebACLs(
    request: ListWebAcLsRequest
  ): Wafv2IO[ListWebAcLsResponse] =
    FF.liftF(ListWebACLsOp(request))

  def putLoggingConfiguration(
    request: PutLoggingConfigurationRequest
  ): Wafv2IO[PutLoggingConfigurationResponse] =
    FF.liftF(PutLoggingConfigurationOp(request))

  def putPermissionPolicy(
    request: PutPermissionPolicyRequest
  ): Wafv2IO[PutPermissionPolicyResponse] =
    FF.liftF(PutPermissionPolicyOp(request))

  def tagResource(
    request: TagResourceRequest
  ): Wafv2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): Wafv2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateIPSet(
    request: UpdateIpSetRequest
  ): Wafv2IO[UpdateIpSetResponse] =
    FF.liftF(UpdateIPSetOp(request))

  def updateRegexPatternSet(
    request: UpdateRegexPatternSetRequest
  ): Wafv2IO[UpdateRegexPatternSetResponse] =
    FF.liftF(UpdateRegexPatternSetOp(request))

  def updateRuleGroup(
    request: UpdateRuleGroupRequest
  ): Wafv2IO[UpdateRuleGroupResponse] =
    FF.liftF(UpdateRuleGroupOp(request))

  def updateWebACL(
    request: UpdateWebAclRequest
  ): Wafv2IO[UpdateWebAclResponse] =
    FF.liftF(UpdateWebACLOp(request))
}
