package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.elasticloadbalancingv2.ElasticLoadBalancingV2Client
import software.amazon.awssdk.services.elasticloadbalancingv2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object elasticloadbalancingv2 { module =>

  // Free monad over ElasticLoadBalancingV2Op
  type ElasticLoadBalancingV2IO[A] = FF[ElasticLoadBalancingV2Op, A]

  sealed trait ElasticLoadBalancingV2Op[A] {
    def visit[F[_]](visitor: ElasticLoadBalancingV2Op.Visitor[F]): F[A]
  }

  object ElasticLoadBalancingV2Op {
    // Given a ElasticLoadBalancingV2Client we can embed a ElasticLoadBalancingV2IO program in any algebra that understands embedding.
    implicit val ElasticLoadBalancingV2OpEmbeddable: Embeddable[ElasticLoadBalancingV2Op, ElasticLoadBalancingV2Client] = new Embeddable[ElasticLoadBalancingV2Op, ElasticLoadBalancingV2Client] {
      def embed[A](client: ElasticLoadBalancingV2Client, io: ElasticLoadBalancingV2IO[A]): Embedded[A] = Embedded.ElasticLoadBalancingV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ElasticLoadBalancingV2Op.Visitor[Kleisli[M, ElasticLoadBalancingV2Client, *]] {
        def addListenerCertificates(
          request: AddListenerCertificatesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, AddListenerCertificatesResponse] =
          primitive(_.addListenerCertificates(request))

        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, AddTagsResponse] =
          primitive(_.addTags(request))

        def createListener(
          request: CreateListenerRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, CreateListenerResponse] =
          primitive(_.createListener(request))

        def createLoadBalancer(
          request: CreateLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, CreateLoadBalancerResponse] =
          primitive(_.createLoadBalancer(request))

        def createRule(
          request: CreateRuleRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, CreateRuleResponse] =
          primitive(_.createRule(request))

        def createTargetGroup(
          request: CreateTargetGroupRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, CreateTargetGroupResponse] =
          primitive(_.createTargetGroup(request))

        def deleteListener(
          request: DeleteListenerRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DeleteListenerResponse] =
          primitive(_.deleteListener(request))

        def deleteLoadBalancer(
          request: DeleteLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DeleteLoadBalancerResponse] =
          primitive(_.deleteLoadBalancer(request))

        def deleteRule(
          request: DeleteRuleRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DeleteRuleResponse] =
          primitive(_.deleteRule(request))

        def deleteTargetGroup(
          request: DeleteTargetGroupRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DeleteTargetGroupResponse] =
          primitive(_.deleteTargetGroup(request))

        def deregisterTargets(
          request: DeregisterTargetsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DeregisterTargetsResponse] =
          primitive(_.deregisterTargets(request))

        def describeAccountLimits(
          request: DescribeAccountLimitsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeAccountLimitsResponse] =
          primitive(_.describeAccountLimits(request))

        def describeListenerCertificates(
          request: DescribeListenerCertificatesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeListenerCertificatesResponse] =
          primitive(_.describeListenerCertificates(request))

        def describeListeners(
          request: DescribeListenersRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeListenersResponse] =
          primitive(_.describeListeners(request))

        def describeLoadBalancerAttributes(
          request: DescribeLoadBalancerAttributesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeLoadBalancerAttributesResponse] =
          primitive(_.describeLoadBalancerAttributes(request))

        def describeLoadBalancers(
          request: DescribeLoadBalancersRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeLoadBalancersResponse] =
          primitive(_.describeLoadBalancers(request))

        def describeRules(
          request: DescribeRulesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeRulesResponse] =
          primitive(_.describeRules(request))

        def describeSSLPolicies(
          request: DescribeSslPoliciesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeSslPoliciesResponse] =
          primitive(_.describeSSLPolicies(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def describeTargetGroupAttributes(
          request: DescribeTargetGroupAttributesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeTargetGroupAttributesResponse] =
          primitive(_.describeTargetGroupAttributes(request))

        def describeTargetGroups(
          request: DescribeTargetGroupsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeTargetGroupsResponse] =
          primitive(_.describeTargetGroups(request))

        def describeTargetHealth(
          request: DescribeTargetHealthRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, DescribeTargetHealthResponse] =
          primitive(_.describeTargetHealth(request))

        def modifyListener(
          request: ModifyListenerRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, ModifyListenerResponse] =
          primitive(_.modifyListener(request))

        def modifyLoadBalancerAttributes(
          request: ModifyLoadBalancerAttributesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, ModifyLoadBalancerAttributesResponse] =
          primitive(_.modifyLoadBalancerAttributes(request))

        def modifyRule(
          request: ModifyRuleRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, ModifyRuleResponse] =
          primitive(_.modifyRule(request))

        def modifyTargetGroup(
          request: ModifyTargetGroupRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, ModifyTargetGroupResponse] =
          primitive(_.modifyTargetGroup(request))

        def modifyTargetGroupAttributes(
          request: ModifyTargetGroupAttributesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, ModifyTargetGroupAttributesResponse] =
          primitive(_.modifyTargetGroupAttributes(request))

        def registerTargets(
          request: RegisterTargetsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, RegisterTargetsResponse] =
          primitive(_.registerTargets(request))

        def removeListenerCertificates(
          request: RemoveListenerCertificatesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, RemoveListenerCertificatesResponse] =
          primitive(_.removeListenerCertificates(request))

        def removeTags(
          request: RemoveTagsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, RemoveTagsResponse] =
          primitive(_.removeTags(request))

        def setIpAddressType(
          request: SetIpAddressTypeRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, SetIpAddressTypeResponse] =
          primitive(_.setIpAddressType(request))

        def setRulePriorities(
          request: SetRulePrioritiesRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, SetRulePrioritiesResponse] =
          primitive(_.setRulePriorities(request))

        def setSecurityGroups(
          request: SetSecurityGroupsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, SetSecurityGroupsResponse] =
          primitive(_.setSecurityGroups(request))

        def setSubnets(
          request: SetSubnetsRequest
        ): Kleisli[M, ElasticLoadBalancingV2Client, SetSubnetsResponse] =
          primitive(_.setSubnets(request))

        def primitive[A](
          f: ElasticLoadBalancingV2Client => A
        ): Kleisli[M, ElasticLoadBalancingV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (ElasticLoadBalancingV2Op ~> F) {
      final def apply[A](op: ElasticLoadBalancingV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addListenerCertificates(
        request: AddListenerCertificatesRequest
      ): F[AddListenerCertificatesResponse]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def createListener(
        request: CreateListenerRequest
      ): F[CreateListenerResponse]

      def createLoadBalancer(
        request: CreateLoadBalancerRequest
      ): F[CreateLoadBalancerResponse]

      def createRule(
        request: CreateRuleRequest
      ): F[CreateRuleResponse]

      def createTargetGroup(
        request: CreateTargetGroupRequest
      ): F[CreateTargetGroupResponse]

      def deleteListener(
        request: DeleteListenerRequest
      ): F[DeleteListenerResponse]

      def deleteLoadBalancer(
        request: DeleteLoadBalancerRequest
      ): F[DeleteLoadBalancerResponse]

      def deleteRule(
        request: DeleteRuleRequest
      ): F[DeleteRuleResponse]

      def deleteTargetGroup(
        request: DeleteTargetGroupRequest
      ): F[DeleteTargetGroupResponse]

      def deregisterTargets(
        request: DeregisterTargetsRequest
      ): F[DeregisterTargetsResponse]

      def describeAccountLimits(
        request: DescribeAccountLimitsRequest
      ): F[DescribeAccountLimitsResponse]

      def describeListenerCertificates(
        request: DescribeListenerCertificatesRequest
      ): F[DescribeListenerCertificatesResponse]

      def describeListeners(
        request: DescribeListenersRequest
      ): F[DescribeListenersResponse]

      def describeLoadBalancerAttributes(
        request: DescribeLoadBalancerAttributesRequest
      ): F[DescribeLoadBalancerAttributesResponse]

      def describeLoadBalancers(
        request: DescribeLoadBalancersRequest
      ): F[DescribeLoadBalancersResponse]

      def describeRules(
        request: DescribeRulesRequest
      ): F[DescribeRulesResponse]

      def describeSSLPolicies(
        request: DescribeSslPoliciesRequest
      ): F[DescribeSslPoliciesResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def describeTargetGroupAttributes(
        request: DescribeTargetGroupAttributesRequest
      ): F[DescribeTargetGroupAttributesResponse]

      def describeTargetGroups(
        request: DescribeTargetGroupsRequest
      ): F[DescribeTargetGroupsResponse]

      def describeTargetHealth(
        request: DescribeTargetHealthRequest
      ): F[DescribeTargetHealthResponse]

      def modifyListener(
        request: ModifyListenerRequest
      ): F[ModifyListenerResponse]

      def modifyLoadBalancerAttributes(
        request: ModifyLoadBalancerAttributesRequest
      ): F[ModifyLoadBalancerAttributesResponse]

      def modifyRule(
        request: ModifyRuleRequest
      ): F[ModifyRuleResponse]

      def modifyTargetGroup(
        request: ModifyTargetGroupRequest
      ): F[ModifyTargetGroupResponse]

      def modifyTargetGroupAttributes(
        request: ModifyTargetGroupAttributesRequest
      ): F[ModifyTargetGroupAttributesResponse]

      def registerTargets(
        request: RegisterTargetsRequest
      ): F[RegisterTargetsResponse]

      def removeListenerCertificates(
        request: RemoveListenerCertificatesRequest
      ): F[RemoveListenerCertificatesResponse]

      def removeTags(
        request: RemoveTagsRequest
      ): F[RemoveTagsResponse]

      def setIpAddressType(
        request: SetIpAddressTypeRequest
      ): F[SetIpAddressTypeResponse]

      def setRulePriorities(
        request: SetRulePrioritiesRequest
      ): F[SetRulePrioritiesResponse]

      def setSecurityGroups(
        request: SetSecurityGroupsRequest
      ): F[SetSecurityGroupsResponse]

      def setSubnets(
        request: SetSubnetsRequest
      ): F[SetSubnetsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ElasticLoadBalancingV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddListenerCertificatesOp(
      request: AddListenerCertificatesRequest
    ) extends ElasticLoadBalancingV2Op[AddListenerCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddListenerCertificatesResponse] =
        visitor.addListenerCertificates(request)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends ElasticLoadBalancingV2Op[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class CreateListenerOp(
      request: CreateListenerRequest
    ) extends ElasticLoadBalancingV2Op[CreateListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateListenerResponse] =
        visitor.createListener(request)
    }

    final case class CreateLoadBalancerOp(
      request: CreateLoadBalancerRequest
    ) extends ElasticLoadBalancingV2Op[CreateLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoadBalancerResponse] =
        visitor.createLoadBalancer(request)
    }

    final case class CreateRuleOp(
      request: CreateRuleRequest
    ) extends ElasticLoadBalancingV2Op[CreateRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRuleResponse] =
        visitor.createRule(request)
    }

    final case class CreateTargetGroupOp(
      request: CreateTargetGroupRequest
    ) extends ElasticLoadBalancingV2Op[CreateTargetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTargetGroupResponse] =
        visitor.createTargetGroup(request)
    }

    final case class DeleteListenerOp(
      request: DeleteListenerRequest
    ) extends ElasticLoadBalancingV2Op[DeleteListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteListenerResponse] =
        visitor.deleteListener(request)
    }

    final case class DeleteLoadBalancerOp(
      request: DeleteLoadBalancerRequest
    ) extends ElasticLoadBalancingV2Op[DeleteLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoadBalancerResponse] =
        visitor.deleteLoadBalancer(request)
    }

    final case class DeleteRuleOp(
      request: DeleteRuleRequest
    ) extends ElasticLoadBalancingV2Op[DeleteRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRuleResponse] =
        visitor.deleteRule(request)
    }

    final case class DeleteTargetGroupOp(
      request: DeleteTargetGroupRequest
    ) extends ElasticLoadBalancingV2Op[DeleteTargetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTargetGroupResponse] =
        visitor.deleteTargetGroup(request)
    }

    final case class DeregisterTargetsOp(
      request: DeregisterTargetsRequest
    ) extends ElasticLoadBalancingV2Op[DeregisterTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTargetsResponse] =
        visitor.deregisterTargets(request)
    }

    final case class DescribeAccountLimitsOp(
      request: DescribeAccountLimitsRequest
    ) extends ElasticLoadBalancingV2Op[DescribeAccountLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountLimitsResponse] =
        visitor.describeAccountLimits(request)
    }

    final case class DescribeListenerCertificatesOp(
      request: DescribeListenerCertificatesRequest
    ) extends ElasticLoadBalancingV2Op[DescribeListenerCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeListenerCertificatesResponse] =
        visitor.describeListenerCertificates(request)
    }

    final case class DescribeListenersOp(
      request: DescribeListenersRequest
    ) extends ElasticLoadBalancingV2Op[DescribeListenersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeListenersResponse] =
        visitor.describeListeners(request)
    }

    final case class DescribeLoadBalancerAttributesOp(
      request: DescribeLoadBalancerAttributesRequest
    ) extends ElasticLoadBalancingV2Op[DescribeLoadBalancerAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancerAttributesResponse] =
        visitor.describeLoadBalancerAttributes(request)
    }

    final case class DescribeLoadBalancersOp(
      request: DescribeLoadBalancersRequest
    ) extends ElasticLoadBalancingV2Op[DescribeLoadBalancersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancersResponse] =
        visitor.describeLoadBalancers(request)
    }

    final case class DescribeRulesOp(
      request: DescribeRulesRequest
    ) extends ElasticLoadBalancingV2Op[DescribeRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRulesResponse] =
        visitor.describeRules(request)
    }

    final case class DescribeSSLPoliciesOp(
      request: DescribeSslPoliciesRequest
    ) extends ElasticLoadBalancingV2Op[DescribeSslPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSslPoliciesResponse] =
        visitor.describeSSLPolicies(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends ElasticLoadBalancingV2Op[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DescribeTargetGroupAttributesOp(
      request: DescribeTargetGroupAttributesRequest
    ) extends ElasticLoadBalancingV2Op[DescribeTargetGroupAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTargetGroupAttributesResponse] =
        visitor.describeTargetGroupAttributes(request)
    }

    final case class DescribeTargetGroupsOp(
      request: DescribeTargetGroupsRequest
    ) extends ElasticLoadBalancingV2Op[DescribeTargetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTargetGroupsResponse] =
        visitor.describeTargetGroups(request)
    }

    final case class DescribeTargetHealthOp(
      request: DescribeTargetHealthRequest
    ) extends ElasticLoadBalancingV2Op[DescribeTargetHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTargetHealthResponse] =
        visitor.describeTargetHealth(request)
    }

    final case class ModifyListenerOp(
      request: ModifyListenerRequest
    ) extends ElasticLoadBalancingV2Op[ModifyListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyListenerResponse] =
        visitor.modifyListener(request)
    }

    final case class ModifyLoadBalancerAttributesOp(
      request: ModifyLoadBalancerAttributesRequest
    ) extends ElasticLoadBalancingV2Op[ModifyLoadBalancerAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyLoadBalancerAttributesResponse] =
        visitor.modifyLoadBalancerAttributes(request)
    }

    final case class ModifyRuleOp(
      request: ModifyRuleRequest
    ) extends ElasticLoadBalancingV2Op[ModifyRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyRuleResponse] =
        visitor.modifyRule(request)
    }

    final case class ModifyTargetGroupOp(
      request: ModifyTargetGroupRequest
    ) extends ElasticLoadBalancingV2Op[ModifyTargetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTargetGroupResponse] =
        visitor.modifyTargetGroup(request)
    }

    final case class ModifyTargetGroupAttributesOp(
      request: ModifyTargetGroupAttributesRequest
    ) extends ElasticLoadBalancingV2Op[ModifyTargetGroupAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyTargetGroupAttributesResponse] =
        visitor.modifyTargetGroupAttributes(request)
    }

    final case class RegisterTargetsOp(
      request: RegisterTargetsRequest
    ) extends ElasticLoadBalancingV2Op[RegisterTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTargetsResponse] =
        visitor.registerTargets(request)
    }

    final case class RemoveListenerCertificatesOp(
      request: RemoveListenerCertificatesRequest
    ) extends ElasticLoadBalancingV2Op[RemoveListenerCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveListenerCertificatesResponse] =
        visitor.removeListenerCertificates(request)
    }

    final case class RemoveTagsOp(
      request: RemoveTagsRequest
    ) extends ElasticLoadBalancingV2Op[RemoveTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsResponse] =
        visitor.removeTags(request)
    }

    final case class SetIpAddressTypeOp(
      request: SetIpAddressTypeRequest
    ) extends ElasticLoadBalancingV2Op[SetIpAddressTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetIpAddressTypeResponse] =
        visitor.setIpAddressType(request)
    }

    final case class SetRulePrioritiesOp(
      request: SetRulePrioritiesRequest
    ) extends ElasticLoadBalancingV2Op[SetRulePrioritiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetRulePrioritiesResponse] =
        visitor.setRulePriorities(request)
    }

    final case class SetSecurityGroupsOp(
      request: SetSecurityGroupsRequest
    ) extends ElasticLoadBalancingV2Op[SetSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetSecurityGroupsResponse] =
        visitor.setSecurityGroups(request)
    }

    final case class SetSubnetsOp(
      request: SetSubnetsRequest
    ) extends ElasticLoadBalancingV2Op[SetSubnetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetSubnetsResponse] =
        visitor.setSubnets(request)
    }
  }

  import ElasticLoadBalancingV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ElasticLoadBalancingV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addListenerCertificates(
    request: AddListenerCertificatesRequest
  ): ElasticLoadBalancingV2IO[AddListenerCertificatesResponse] =
    FF.liftF(AddListenerCertificatesOp(request))

  def addTags(
    request: AddTagsRequest
  ): ElasticLoadBalancingV2IO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def createListener(
    request: CreateListenerRequest
  ): ElasticLoadBalancingV2IO[CreateListenerResponse] =
    FF.liftF(CreateListenerOp(request))

  def createLoadBalancer(
    request: CreateLoadBalancerRequest
  ): ElasticLoadBalancingV2IO[CreateLoadBalancerResponse] =
    FF.liftF(CreateLoadBalancerOp(request))

  def createRule(
    request: CreateRuleRequest
  ): ElasticLoadBalancingV2IO[CreateRuleResponse] =
    FF.liftF(CreateRuleOp(request))

  def createTargetGroup(
    request: CreateTargetGroupRequest
  ): ElasticLoadBalancingV2IO[CreateTargetGroupResponse] =
    FF.liftF(CreateTargetGroupOp(request))

  def deleteListener(
    request: DeleteListenerRequest
  ): ElasticLoadBalancingV2IO[DeleteListenerResponse] =
    FF.liftF(DeleteListenerOp(request))

  def deleteLoadBalancer(
    request: DeleteLoadBalancerRequest
  ): ElasticLoadBalancingV2IO[DeleteLoadBalancerResponse] =
    FF.liftF(DeleteLoadBalancerOp(request))

  def deleteRule(
    request: DeleteRuleRequest
  ): ElasticLoadBalancingV2IO[DeleteRuleResponse] =
    FF.liftF(DeleteRuleOp(request))

  def deleteTargetGroup(
    request: DeleteTargetGroupRequest
  ): ElasticLoadBalancingV2IO[DeleteTargetGroupResponse] =
    FF.liftF(DeleteTargetGroupOp(request))

  def deregisterTargets(
    request: DeregisterTargetsRequest
  ): ElasticLoadBalancingV2IO[DeregisterTargetsResponse] =
    FF.liftF(DeregisterTargetsOp(request))

  def describeAccountLimits(
    request: DescribeAccountLimitsRequest
  ): ElasticLoadBalancingV2IO[DescribeAccountLimitsResponse] =
    FF.liftF(DescribeAccountLimitsOp(request))

  def describeListenerCertificates(
    request: DescribeListenerCertificatesRequest
  ): ElasticLoadBalancingV2IO[DescribeListenerCertificatesResponse] =
    FF.liftF(DescribeListenerCertificatesOp(request))

  def describeListeners(
    request: DescribeListenersRequest
  ): ElasticLoadBalancingV2IO[DescribeListenersResponse] =
    FF.liftF(DescribeListenersOp(request))

  def describeLoadBalancerAttributes(
    request: DescribeLoadBalancerAttributesRequest
  ): ElasticLoadBalancingV2IO[DescribeLoadBalancerAttributesResponse] =
    FF.liftF(DescribeLoadBalancerAttributesOp(request))

  def describeLoadBalancers(
    request: DescribeLoadBalancersRequest
  ): ElasticLoadBalancingV2IO[DescribeLoadBalancersResponse] =
    FF.liftF(DescribeLoadBalancersOp(request))

  def describeRules(
    request: DescribeRulesRequest
  ): ElasticLoadBalancingV2IO[DescribeRulesResponse] =
    FF.liftF(DescribeRulesOp(request))

  def describeSSLPolicies(
    request: DescribeSslPoliciesRequest
  ): ElasticLoadBalancingV2IO[DescribeSslPoliciesResponse] =
    FF.liftF(DescribeSSLPoliciesOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): ElasticLoadBalancingV2IO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def describeTargetGroupAttributes(
    request: DescribeTargetGroupAttributesRequest
  ): ElasticLoadBalancingV2IO[DescribeTargetGroupAttributesResponse] =
    FF.liftF(DescribeTargetGroupAttributesOp(request))

  def describeTargetGroups(
    request: DescribeTargetGroupsRequest
  ): ElasticLoadBalancingV2IO[DescribeTargetGroupsResponse] =
    FF.liftF(DescribeTargetGroupsOp(request))

  def describeTargetHealth(
    request: DescribeTargetHealthRequest
  ): ElasticLoadBalancingV2IO[DescribeTargetHealthResponse] =
    FF.liftF(DescribeTargetHealthOp(request))

  def modifyListener(
    request: ModifyListenerRequest
  ): ElasticLoadBalancingV2IO[ModifyListenerResponse] =
    FF.liftF(ModifyListenerOp(request))

  def modifyLoadBalancerAttributes(
    request: ModifyLoadBalancerAttributesRequest
  ): ElasticLoadBalancingV2IO[ModifyLoadBalancerAttributesResponse] =
    FF.liftF(ModifyLoadBalancerAttributesOp(request))

  def modifyRule(
    request: ModifyRuleRequest
  ): ElasticLoadBalancingV2IO[ModifyRuleResponse] =
    FF.liftF(ModifyRuleOp(request))

  def modifyTargetGroup(
    request: ModifyTargetGroupRequest
  ): ElasticLoadBalancingV2IO[ModifyTargetGroupResponse] =
    FF.liftF(ModifyTargetGroupOp(request))

  def modifyTargetGroupAttributes(
    request: ModifyTargetGroupAttributesRequest
  ): ElasticLoadBalancingV2IO[ModifyTargetGroupAttributesResponse] =
    FF.liftF(ModifyTargetGroupAttributesOp(request))

  def registerTargets(
    request: RegisterTargetsRequest
  ): ElasticLoadBalancingV2IO[RegisterTargetsResponse] =
    FF.liftF(RegisterTargetsOp(request))

  def removeListenerCertificates(
    request: RemoveListenerCertificatesRequest
  ): ElasticLoadBalancingV2IO[RemoveListenerCertificatesResponse] =
    FF.liftF(RemoveListenerCertificatesOp(request))

  def removeTags(
    request: RemoveTagsRequest
  ): ElasticLoadBalancingV2IO[RemoveTagsResponse] =
    FF.liftF(RemoveTagsOp(request))

  def setIpAddressType(
    request: SetIpAddressTypeRequest
  ): ElasticLoadBalancingV2IO[SetIpAddressTypeResponse] =
    FF.liftF(SetIpAddressTypeOp(request))

  def setRulePriorities(
    request: SetRulePrioritiesRequest
  ): ElasticLoadBalancingV2IO[SetRulePrioritiesResponse] =
    FF.liftF(SetRulePrioritiesOp(request))

  def setSecurityGroups(
    request: SetSecurityGroupsRequest
  ): ElasticLoadBalancingV2IO[SetSecurityGroupsResponse] =
    FF.liftF(SetSecurityGroupsOp(request))

  def setSubnets(
    request: SetSubnetsRequest
  ): ElasticLoadBalancingV2IO[SetSubnetsResponse] =
    FF.liftF(SetSubnetsOp(request))
}
