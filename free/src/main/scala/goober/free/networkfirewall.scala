package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.networkfirewall.NetworkFirewallClient
import software.amazon.awssdk.services.networkfirewall.model._


object networkfirewall { module =>

  // Free monad over NetworkFirewallOp
  type NetworkFirewallIO[A] = FF[NetworkFirewallOp, A]

  sealed trait NetworkFirewallOp[A] {
    def visit[F[_]](visitor: NetworkFirewallOp.Visitor[F]): F[A]
  }

  object NetworkFirewallOp {
    // Given a NetworkFirewallClient we can embed a NetworkFirewallIO program in any algebra that understands embedding.
    implicit val NetworkFirewallOpEmbeddable: Embeddable[NetworkFirewallOp, NetworkFirewallClient] = new Embeddable[NetworkFirewallOp, NetworkFirewallClient] {
      def embed[A](client: NetworkFirewallClient, io: NetworkFirewallIO[A]): Embedded[A] = Embedded.NetworkFirewall(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends NetworkFirewallOp.Visitor[Kleisli[M, NetworkFirewallClient, *]] {
        def associateFirewallPolicy(
          request: AssociateFirewallPolicyRequest
        ): Kleisli[M, NetworkFirewallClient, AssociateFirewallPolicyResponse] =
          primitive(_.associateFirewallPolicy(request))

        def associateSubnets(
          request: AssociateSubnetsRequest
        ): Kleisli[M, NetworkFirewallClient, AssociateSubnetsResponse] =
          primitive(_.associateSubnets(request))

        def createFirewall(
          request: CreateFirewallRequest
        ): Kleisli[M, NetworkFirewallClient, CreateFirewallResponse] =
          primitive(_.createFirewall(request))

        def createFirewallPolicy(
          request: CreateFirewallPolicyRequest
        ): Kleisli[M, NetworkFirewallClient, CreateFirewallPolicyResponse] =
          primitive(_.createFirewallPolicy(request))

        def createRuleGroup(
          request: CreateRuleGroupRequest
        ): Kleisli[M, NetworkFirewallClient, CreateRuleGroupResponse] =
          primitive(_.createRuleGroup(request))

        def deleteFirewall(
          request: DeleteFirewallRequest
        ): Kleisli[M, NetworkFirewallClient, DeleteFirewallResponse] =
          primitive(_.deleteFirewall(request))

        def deleteFirewallPolicy(
          request: DeleteFirewallPolicyRequest
        ): Kleisli[M, NetworkFirewallClient, DeleteFirewallPolicyResponse] =
          primitive(_.deleteFirewallPolicy(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, NetworkFirewallClient, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteRuleGroup(
          request: DeleteRuleGroupRequest
        ): Kleisli[M, NetworkFirewallClient, DeleteRuleGroupResponse] =
          primitive(_.deleteRuleGroup(request))

        def describeFirewall(
          request: DescribeFirewallRequest
        ): Kleisli[M, NetworkFirewallClient, DescribeFirewallResponse] =
          primitive(_.describeFirewall(request))

        def describeFirewallPolicy(
          request: DescribeFirewallPolicyRequest
        ): Kleisli[M, NetworkFirewallClient, DescribeFirewallPolicyResponse] =
          primitive(_.describeFirewallPolicy(request))

        def describeLoggingConfiguration(
          request: DescribeLoggingConfigurationRequest
        ): Kleisli[M, NetworkFirewallClient, DescribeLoggingConfigurationResponse] =
          primitive(_.describeLoggingConfiguration(request))

        def describeResourcePolicy(
          request: DescribeResourcePolicyRequest
        ): Kleisli[M, NetworkFirewallClient, DescribeResourcePolicyResponse] =
          primitive(_.describeResourcePolicy(request))

        def describeRuleGroup(
          request: DescribeRuleGroupRequest
        ): Kleisli[M, NetworkFirewallClient, DescribeRuleGroupResponse] =
          primitive(_.describeRuleGroup(request))

        def disassociateSubnets(
          request: DisassociateSubnetsRequest
        ): Kleisli[M, NetworkFirewallClient, DisassociateSubnetsResponse] =
          primitive(_.disassociateSubnets(request))

        def listFirewallPolicies(
          request: ListFirewallPoliciesRequest
        ): Kleisli[M, NetworkFirewallClient, ListFirewallPoliciesResponse] =
          primitive(_.listFirewallPolicies(request))

        def listFirewalls(
          request: ListFirewallsRequest
        ): Kleisli[M, NetworkFirewallClient, ListFirewallsResponse] =
          primitive(_.listFirewalls(request))

        def listRuleGroups(
          request: ListRuleGroupsRequest
        ): Kleisli[M, NetworkFirewallClient, ListRuleGroupsResponse] =
          primitive(_.listRuleGroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, NetworkFirewallClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putResourcePolicy(
          request: PutResourcePolicyRequest
        ): Kleisli[M, NetworkFirewallClient, PutResourcePolicyResponse] =
          primitive(_.putResourcePolicy(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, NetworkFirewallClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, NetworkFirewallClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateFirewallDeleteProtection(
          request: UpdateFirewallDeleteProtectionRequest
        ): Kleisli[M, NetworkFirewallClient, UpdateFirewallDeleteProtectionResponse] =
          primitive(_.updateFirewallDeleteProtection(request))

        def updateFirewallDescription(
          request: UpdateFirewallDescriptionRequest
        ): Kleisli[M, NetworkFirewallClient, UpdateFirewallDescriptionResponse] =
          primitive(_.updateFirewallDescription(request))

        def updateFirewallPolicy(
          request: UpdateFirewallPolicyRequest
        ): Kleisli[M, NetworkFirewallClient, UpdateFirewallPolicyResponse] =
          primitive(_.updateFirewallPolicy(request))

        def updateFirewallPolicyChangeProtection(
          request: UpdateFirewallPolicyChangeProtectionRequest
        ): Kleisli[M, NetworkFirewallClient, UpdateFirewallPolicyChangeProtectionResponse] =
          primitive(_.updateFirewallPolicyChangeProtection(request))

        def updateLoggingConfiguration(
          request: UpdateLoggingConfigurationRequest
        ): Kleisli[M, NetworkFirewallClient, UpdateLoggingConfigurationResponse] =
          primitive(_.updateLoggingConfiguration(request))

        def updateRuleGroup(
          request: UpdateRuleGroupRequest
        ): Kleisli[M, NetworkFirewallClient, UpdateRuleGroupResponse] =
          primitive(_.updateRuleGroup(request))

        def updateSubnetChangeProtection(
          request: UpdateSubnetChangeProtectionRequest
        ): Kleisli[M, NetworkFirewallClient, UpdateSubnetChangeProtectionResponse] =
          primitive(_.updateSubnetChangeProtection(request))

        def primitive[A](
          f: NetworkFirewallClient => A
        ): Kleisli[M, NetworkFirewallClient, A]
      }
    }

    trait Visitor[F[_]] extends (NetworkFirewallOp ~> F) {
      final def apply[A](op: NetworkFirewallOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateFirewallPolicy(
        request: AssociateFirewallPolicyRequest
      ): F[AssociateFirewallPolicyResponse]

      def associateSubnets(
        request: AssociateSubnetsRequest
      ): F[AssociateSubnetsResponse]

      def createFirewall(
        request: CreateFirewallRequest
      ): F[CreateFirewallResponse]

      def createFirewallPolicy(
        request: CreateFirewallPolicyRequest
      ): F[CreateFirewallPolicyResponse]

      def createRuleGroup(
        request: CreateRuleGroupRequest
      ): F[CreateRuleGroupResponse]

      def deleteFirewall(
        request: DeleteFirewallRequest
      ): F[DeleteFirewallResponse]

      def deleteFirewallPolicy(
        request: DeleteFirewallPolicyRequest
      ): F[DeleteFirewallPolicyResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteRuleGroup(
        request: DeleteRuleGroupRequest
      ): F[DeleteRuleGroupResponse]

      def describeFirewall(
        request: DescribeFirewallRequest
      ): F[DescribeFirewallResponse]

      def describeFirewallPolicy(
        request: DescribeFirewallPolicyRequest
      ): F[DescribeFirewallPolicyResponse]

      def describeLoggingConfiguration(
        request: DescribeLoggingConfigurationRequest
      ): F[DescribeLoggingConfigurationResponse]

      def describeResourcePolicy(
        request: DescribeResourcePolicyRequest
      ): F[DescribeResourcePolicyResponse]

      def describeRuleGroup(
        request: DescribeRuleGroupRequest
      ): F[DescribeRuleGroupResponse]

      def disassociateSubnets(
        request: DisassociateSubnetsRequest
      ): F[DisassociateSubnetsResponse]

      def listFirewallPolicies(
        request: ListFirewallPoliciesRequest
      ): F[ListFirewallPoliciesResponse]

      def listFirewalls(
        request: ListFirewallsRequest
      ): F[ListFirewallsResponse]

      def listRuleGroups(
        request: ListRuleGroupsRequest
      ): F[ListRuleGroupsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putResourcePolicy(
        request: PutResourcePolicyRequest
      ): F[PutResourcePolicyResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateFirewallDeleteProtection(
        request: UpdateFirewallDeleteProtectionRequest
      ): F[UpdateFirewallDeleteProtectionResponse]

      def updateFirewallDescription(
        request: UpdateFirewallDescriptionRequest
      ): F[UpdateFirewallDescriptionResponse]

      def updateFirewallPolicy(
        request: UpdateFirewallPolicyRequest
      ): F[UpdateFirewallPolicyResponse]

      def updateFirewallPolicyChangeProtection(
        request: UpdateFirewallPolicyChangeProtectionRequest
      ): F[UpdateFirewallPolicyChangeProtectionResponse]

      def updateLoggingConfiguration(
        request: UpdateLoggingConfigurationRequest
      ): F[UpdateLoggingConfigurationResponse]

      def updateRuleGroup(
        request: UpdateRuleGroupRequest
      ): F[UpdateRuleGroupResponse]

      def updateSubnetChangeProtection(
        request: UpdateSubnetChangeProtectionRequest
      ): F[UpdateSubnetChangeProtectionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends NetworkFirewallOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateFirewallPolicyOp(
      request: AssociateFirewallPolicyRequest
    ) extends NetworkFirewallOp[AssociateFirewallPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateFirewallPolicyResponse] =
        visitor.associateFirewallPolicy(request)
    }

    final case class AssociateSubnetsOp(
      request: AssociateSubnetsRequest
    ) extends NetworkFirewallOp[AssociateSubnetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSubnetsResponse] =
        visitor.associateSubnets(request)
    }

    final case class CreateFirewallOp(
      request: CreateFirewallRequest
    ) extends NetworkFirewallOp[CreateFirewallResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFirewallResponse] =
        visitor.createFirewall(request)
    }

    final case class CreateFirewallPolicyOp(
      request: CreateFirewallPolicyRequest
    ) extends NetworkFirewallOp[CreateFirewallPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFirewallPolicyResponse] =
        visitor.createFirewallPolicy(request)
    }

    final case class CreateRuleGroupOp(
      request: CreateRuleGroupRequest
    ) extends NetworkFirewallOp[CreateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleGroupResponse] =
        visitor.createRuleGroup(request)
    }

    final case class DeleteFirewallOp(
      request: DeleteFirewallRequest
    ) extends NetworkFirewallOp[DeleteFirewallResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFirewallResponse] =
        visitor.deleteFirewall(request)
    }

    final case class DeleteFirewallPolicyOp(
      request: DeleteFirewallPolicyRequest
    ) extends NetworkFirewallOp[DeleteFirewallPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFirewallPolicyResponse] =
        visitor.deleteFirewallPolicy(request)
    }

    final case class DeleteResourcePolicyOp(
      request: DeleteResourcePolicyRequest
    ) extends NetworkFirewallOp[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteRuleGroupOp(
      request: DeleteRuleGroupRequest
    ) extends NetworkFirewallOp[DeleteRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleGroupResponse] =
        visitor.deleteRuleGroup(request)
    }

    final case class DescribeFirewallOp(
      request: DescribeFirewallRequest
    ) extends NetworkFirewallOp[DescribeFirewallResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFirewallResponse] =
        visitor.describeFirewall(request)
    }

    final case class DescribeFirewallPolicyOp(
      request: DescribeFirewallPolicyRequest
    ) extends NetworkFirewallOp[DescribeFirewallPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFirewallPolicyResponse] =
        visitor.describeFirewallPolicy(request)
    }

    final case class DescribeLoggingConfigurationOp(
      request: DescribeLoggingConfigurationRequest
    ) extends NetworkFirewallOp[DescribeLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoggingConfigurationResponse] =
        visitor.describeLoggingConfiguration(request)
    }

    final case class DescribeResourcePolicyOp(
      request: DescribeResourcePolicyRequest
    ) extends NetworkFirewallOp[DescribeResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourcePolicyResponse] =
        visitor.describeResourcePolicy(request)
    }

    final case class DescribeRuleGroupOp(
      request: DescribeRuleGroupRequest
    ) extends NetworkFirewallOp[DescribeRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRuleGroupResponse] =
        visitor.describeRuleGroup(request)
    }

    final case class DisassociateSubnetsOp(
      request: DisassociateSubnetsRequest
    ) extends NetworkFirewallOp[DisassociateSubnetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateSubnetsResponse] =
        visitor.disassociateSubnets(request)
    }

    final case class ListFirewallPoliciesOp(
      request: ListFirewallPoliciesRequest
    ) extends NetworkFirewallOp[ListFirewallPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallPoliciesResponse] =
        visitor.listFirewallPolicies(request)
    }

    final case class ListFirewallsOp(
      request: ListFirewallsRequest
    ) extends NetworkFirewallOp[ListFirewallsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallsResponse] =
        visitor.listFirewalls(request)
    }

    final case class ListRuleGroupsOp(
      request: ListRuleGroupsRequest
    ) extends NetworkFirewallOp[ListRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRuleGroupsResponse] =
        visitor.listRuleGroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends NetworkFirewallOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutResourcePolicyOp(
      request: PutResourcePolicyRequest
    ) extends NetworkFirewallOp[PutResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourcePolicyResponse] =
        visitor.putResourcePolicy(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends NetworkFirewallOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends NetworkFirewallOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateFirewallDeleteProtectionOp(
      request: UpdateFirewallDeleteProtectionRequest
    ) extends NetworkFirewallOp[UpdateFirewallDeleteProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallDeleteProtectionResponse] =
        visitor.updateFirewallDeleteProtection(request)
    }

    final case class UpdateFirewallDescriptionOp(
      request: UpdateFirewallDescriptionRequest
    ) extends NetworkFirewallOp[UpdateFirewallDescriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallDescriptionResponse] =
        visitor.updateFirewallDescription(request)
    }

    final case class UpdateFirewallPolicyOp(
      request: UpdateFirewallPolicyRequest
    ) extends NetworkFirewallOp[UpdateFirewallPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallPolicyResponse] =
        visitor.updateFirewallPolicy(request)
    }

    final case class UpdateFirewallPolicyChangeProtectionOp(
      request: UpdateFirewallPolicyChangeProtectionRequest
    ) extends NetworkFirewallOp[UpdateFirewallPolicyChangeProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallPolicyChangeProtectionResponse] =
        visitor.updateFirewallPolicyChangeProtection(request)
    }

    final case class UpdateLoggingConfigurationOp(
      request: UpdateLoggingConfigurationRequest
    ) extends NetworkFirewallOp[UpdateLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLoggingConfigurationResponse] =
        visitor.updateLoggingConfiguration(request)
    }

    final case class UpdateRuleGroupOp(
      request: UpdateRuleGroupRequest
    ) extends NetworkFirewallOp[UpdateRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuleGroupResponse] =
        visitor.updateRuleGroup(request)
    }

    final case class UpdateSubnetChangeProtectionOp(
      request: UpdateSubnetChangeProtectionRequest
    ) extends NetworkFirewallOp[UpdateSubnetChangeProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSubnetChangeProtectionResponse] =
        visitor.updateSubnetChangeProtection(request)
    }
  }

  import NetworkFirewallOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[NetworkFirewallOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateFirewallPolicy(
    request: AssociateFirewallPolicyRequest
  ): NetworkFirewallIO[AssociateFirewallPolicyResponse] =
    FF.liftF(AssociateFirewallPolicyOp(request))

  def associateSubnets(
    request: AssociateSubnetsRequest
  ): NetworkFirewallIO[AssociateSubnetsResponse] =
    FF.liftF(AssociateSubnetsOp(request))

  def createFirewall(
    request: CreateFirewallRequest
  ): NetworkFirewallIO[CreateFirewallResponse] =
    FF.liftF(CreateFirewallOp(request))

  def createFirewallPolicy(
    request: CreateFirewallPolicyRequest
  ): NetworkFirewallIO[CreateFirewallPolicyResponse] =
    FF.liftF(CreateFirewallPolicyOp(request))

  def createRuleGroup(
    request: CreateRuleGroupRequest
  ): NetworkFirewallIO[CreateRuleGroupResponse] =
    FF.liftF(CreateRuleGroupOp(request))

  def deleteFirewall(
    request: DeleteFirewallRequest
  ): NetworkFirewallIO[DeleteFirewallResponse] =
    FF.liftF(DeleteFirewallOp(request))

  def deleteFirewallPolicy(
    request: DeleteFirewallPolicyRequest
  ): NetworkFirewallIO[DeleteFirewallPolicyResponse] =
    FF.liftF(DeleteFirewallPolicyOp(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): NetworkFirewallIO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicyOp(request))

  def deleteRuleGroup(
    request: DeleteRuleGroupRequest
  ): NetworkFirewallIO[DeleteRuleGroupResponse] =
    FF.liftF(DeleteRuleGroupOp(request))

  def describeFirewall(
    request: DescribeFirewallRequest
  ): NetworkFirewallIO[DescribeFirewallResponse] =
    FF.liftF(DescribeFirewallOp(request))

  def describeFirewallPolicy(
    request: DescribeFirewallPolicyRequest
  ): NetworkFirewallIO[DescribeFirewallPolicyResponse] =
    FF.liftF(DescribeFirewallPolicyOp(request))

  def describeLoggingConfiguration(
    request: DescribeLoggingConfigurationRequest
  ): NetworkFirewallIO[DescribeLoggingConfigurationResponse] =
    FF.liftF(DescribeLoggingConfigurationOp(request))

  def describeResourcePolicy(
    request: DescribeResourcePolicyRequest
  ): NetworkFirewallIO[DescribeResourcePolicyResponse] =
    FF.liftF(DescribeResourcePolicyOp(request))

  def describeRuleGroup(
    request: DescribeRuleGroupRequest
  ): NetworkFirewallIO[DescribeRuleGroupResponse] =
    FF.liftF(DescribeRuleGroupOp(request))

  def disassociateSubnets(
    request: DisassociateSubnetsRequest
  ): NetworkFirewallIO[DisassociateSubnetsResponse] =
    FF.liftF(DisassociateSubnetsOp(request))

  def listFirewallPolicies(
    request: ListFirewallPoliciesRequest
  ): NetworkFirewallIO[ListFirewallPoliciesResponse] =
    FF.liftF(ListFirewallPoliciesOp(request))

  def listFirewalls(
    request: ListFirewallsRequest
  ): NetworkFirewallIO[ListFirewallsResponse] =
    FF.liftF(ListFirewallsOp(request))

  def listRuleGroups(
    request: ListRuleGroupsRequest
  ): NetworkFirewallIO[ListRuleGroupsResponse] =
    FF.liftF(ListRuleGroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): NetworkFirewallIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putResourcePolicy(
    request: PutResourcePolicyRequest
  ): NetworkFirewallIO[PutResourcePolicyResponse] =
    FF.liftF(PutResourcePolicyOp(request))

  def tagResource(
    request: TagResourceRequest
  ): NetworkFirewallIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): NetworkFirewallIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateFirewallDeleteProtection(
    request: UpdateFirewallDeleteProtectionRequest
  ): NetworkFirewallIO[UpdateFirewallDeleteProtectionResponse] =
    FF.liftF(UpdateFirewallDeleteProtectionOp(request))

  def updateFirewallDescription(
    request: UpdateFirewallDescriptionRequest
  ): NetworkFirewallIO[UpdateFirewallDescriptionResponse] =
    FF.liftF(UpdateFirewallDescriptionOp(request))

  def updateFirewallPolicy(
    request: UpdateFirewallPolicyRequest
  ): NetworkFirewallIO[UpdateFirewallPolicyResponse] =
    FF.liftF(UpdateFirewallPolicyOp(request))

  def updateFirewallPolicyChangeProtection(
    request: UpdateFirewallPolicyChangeProtectionRequest
  ): NetworkFirewallIO[UpdateFirewallPolicyChangeProtectionResponse] =
    FF.liftF(UpdateFirewallPolicyChangeProtectionOp(request))

  def updateLoggingConfiguration(
    request: UpdateLoggingConfigurationRequest
  ): NetworkFirewallIO[UpdateLoggingConfigurationResponse] =
    FF.liftF(UpdateLoggingConfigurationOp(request))

  def updateRuleGroup(
    request: UpdateRuleGroupRequest
  ): NetworkFirewallIO[UpdateRuleGroupResponse] =
    FF.liftF(UpdateRuleGroupOp(request))

  def updateSubnetChangeProtection(
    request: UpdateSubnetChangeProtectionRequest
  ): NetworkFirewallIO[UpdateSubnetChangeProtectionResponse] =
    FF.liftF(UpdateSubnetChangeProtectionOp(request))
}
