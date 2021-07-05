package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.route53resolver.Route53ResolverClient
import software.amazon.awssdk.services.route53resolver.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object route53resolver { module =>

  // Free monad over Route53ResolverOp
  type Route53ResolverIO[A] = FF[Route53ResolverOp, A]

  sealed trait Route53ResolverOp[A] {
    def visit[F[_]](visitor: Route53ResolverOp.Visitor[F]): F[A]
  }

  object Route53ResolverOp {
    // Given a Route53ResolverClient we can embed a Route53ResolverIO program in any algebra that understands embedding.
    implicit val Route53ResolverOpEmbeddable: Embeddable[Route53ResolverOp, Route53ResolverClient] = new Embeddable[Route53ResolverOp, Route53ResolverClient] {
      def embed[A](client: Route53ResolverClient, io: Route53ResolverIO[A]): Embedded[A] = Embedded.Route53Resolver(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Route53ResolverOp.Visitor[Kleisli[M, Route53ResolverClient, *]] {
        def associateFirewallRuleGroup(
          request: AssociateFirewallRuleGroupRequest
        ): Kleisli[M, Route53ResolverClient, AssociateFirewallRuleGroupResponse] =
          primitive(_.associateFirewallRuleGroup(request))

        def associateResolverEndpointIpAddress(
          request: AssociateResolverEndpointIpAddressRequest
        ): Kleisli[M, Route53ResolverClient, AssociateResolverEndpointIpAddressResponse] =
          primitive(_.associateResolverEndpointIpAddress(request))

        def associateResolverQueryLogConfig(
          request: AssociateResolverQueryLogConfigRequest
        ): Kleisli[M, Route53ResolverClient, AssociateResolverQueryLogConfigResponse] =
          primitive(_.associateResolverQueryLogConfig(request))

        def associateResolverRule(
          request: AssociateResolverRuleRequest
        ): Kleisli[M, Route53ResolverClient, AssociateResolverRuleResponse] =
          primitive(_.associateResolverRule(request))

        def createFirewallDomainList(
          request: CreateFirewallDomainListRequest
        ): Kleisli[M, Route53ResolverClient, CreateFirewallDomainListResponse] =
          primitive(_.createFirewallDomainList(request))

        def createFirewallRule(
          request: CreateFirewallRuleRequest
        ): Kleisli[M, Route53ResolverClient, CreateFirewallRuleResponse] =
          primitive(_.createFirewallRule(request))

        def createFirewallRuleGroup(
          request: CreateFirewallRuleGroupRequest
        ): Kleisli[M, Route53ResolverClient, CreateFirewallRuleGroupResponse] =
          primitive(_.createFirewallRuleGroup(request))

        def createResolverEndpoint(
          request: CreateResolverEndpointRequest
        ): Kleisli[M, Route53ResolverClient, CreateResolverEndpointResponse] =
          primitive(_.createResolverEndpoint(request))

        def createResolverQueryLogConfig(
          request: CreateResolverQueryLogConfigRequest
        ): Kleisli[M, Route53ResolverClient, CreateResolverQueryLogConfigResponse] =
          primitive(_.createResolverQueryLogConfig(request))

        def createResolverRule(
          request: CreateResolverRuleRequest
        ): Kleisli[M, Route53ResolverClient, CreateResolverRuleResponse] =
          primitive(_.createResolverRule(request))

        def deleteFirewallDomainList(
          request: DeleteFirewallDomainListRequest
        ): Kleisli[M, Route53ResolverClient, DeleteFirewallDomainListResponse] =
          primitive(_.deleteFirewallDomainList(request))

        def deleteFirewallRule(
          request: DeleteFirewallRuleRequest
        ): Kleisli[M, Route53ResolverClient, DeleteFirewallRuleResponse] =
          primitive(_.deleteFirewallRule(request))

        def deleteFirewallRuleGroup(
          request: DeleteFirewallRuleGroupRequest
        ): Kleisli[M, Route53ResolverClient, DeleteFirewallRuleGroupResponse] =
          primitive(_.deleteFirewallRuleGroup(request))

        def deleteResolverEndpoint(
          request: DeleteResolverEndpointRequest
        ): Kleisli[M, Route53ResolverClient, DeleteResolverEndpointResponse] =
          primitive(_.deleteResolverEndpoint(request))

        def deleteResolverQueryLogConfig(
          request: DeleteResolverQueryLogConfigRequest
        ): Kleisli[M, Route53ResolverClient, DeleteResolverQueryLogConfigResponse] =
          primitive(_.deleteResolverQueryLogConfig(request))

        def deleteResolverRule(
          request: DeleteResolverRuleRequest
        ): Kleisli[M, Route53ResolverClient, DeleteResolverRuleResponse] =
          primitive(_.deleteResolverRule(request))

        def disassociateFirewallRuleGroup(
          request: DisassociateFirewallRuleGroupRequest
        ): Kleisli[M, Route53ResolverClient, DisassociateFirewallRuleGroupResponse] =
          primitive(_.disassociateFirewallRuleGroup(request))

        def disassociateResolverEndpointIpAddress(
          request: DisassociateResolverEndpointIpAddressRequest
        ): Kleisli[M, Route53ResolverClient, DisassociateResolverEndpointIpAddressResponse] =
          primitive(_.disassociateResolverEndpointIpAddress(request))

        def disassociateResolverQueryLogConfig(
          request: DisassociateResolverQueryLogConfigRequest
        ): Kleisli[M, Route53ResolverClient, DisassociateResolverQueryLogConfigResponse] =
          primitive(_.disassociateResolverQueryLogConfig(request))

        def disassociateResolverRule(
          request: DisassociateResolverRuleRequest
        ): Kleisli[M, Route53ResolverClient, DisassociateResolverRuleResponse] =
          primitive(_.disassociateResolverRule(request))

        def getFirewallConfig(
          request: GetFirewallConfigRequest
        ): Kleisli[M, Route53ResolverClient, GetFirewallConfigResponse] =
          primitive(_.getFirewallConfig(request))

        def getFirewallDomainList(
          request: GetFirewallDomainListRequest
        ): Kleisli[M, Route53ResolverClient, GetFirewallDomainListResponse] =
          primitive(_.getFirewallDomainList(request))

        def getFirewallRuleGroup(
          request: GetFirewallRuleGroupRequest
        ): Kleisli[M, Route53ResolverClient, GetFirewallRuleGroupResponse] =
          primitive(_.getFirewallRuleGroup(request))

        def getFirewallRuleGroupAssociation(
          request: GetFirewallRuleGroupAssociationRequest
        ): Kleisli[M, Route53ResolverClient, GetFirewallRuleGroupAssociationResponse] =
          primitive(_.getFirewallRuleGroupAssociation(request))

        def getFirewallRuleGroupPolicy(
          request: GetFirewallRuleGroupPolicyRequest
        ): Kleisli[M, Route53ResolverClient, GetFirewallRuleGroupPolicyResponse] =
          primitive(_.getFirewallRuleGroupPolicy(request))

        def getResolverDnssecConfig(
          request: GetResolverDnssecConfigRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverDnssecConfigResponse] =
          primitive(_.getResolverDnssecConfig(request))

        def getResolverEndpoint(
          request: GetResolverEndpointRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverEndpointResponse] =
          primitive(_.getResolverEndpoint(request))

        def getResolverQueryLogConfig(
          request: GetResolverQueryLogConfigRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverQueryLogConfigResponse] =
          primitive(_.getResolverQueryLogConfig(request))

        def getResolverQueryLogConfigAssociation(
          request: GetResolverQueryLogConfigAssociationRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverQueryLogConfigAssociationResponse] =
          primitive(_.getResolverQueryLogConfigAssociation(request))

        def getResolverQueryLogConfigPolicy(
          request: GetResolverQueryLogConfigPolicyRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverQueryLogConfigPolicyResponse] =
          primitive(_.getResolverQueryLogConfigPolicy(request))

        def getResolverRule(
          request: GetResolverRuleRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverRuleResponse] =
          primitive(_.getResolverRule(request))

        def getResolverRuleAssociation(
          request: GetResolverRuleAssociationRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverRuleAssociationResponse] =
          primitive(_.getResolverRuleAssociation(request))

        def getResolverRulePolicy(
          request: GetResolverRulePolicyRequest
        ): Kleisli[M, Route53ResolverClient, GetResolverRulePolicyResponse] =
          primitive(_.getResolverRulePolicy(request))

        def importFirewallDomains(
          request: ImportFirewallDomainsRequest
        ): Kleisli[M, Route53ResolverClient, ImportFirewallDomainsResponse] =
          primitive(_.importFirewallDomains(request))

        def listFirewallConfigs(
          request: ListFirewallConfigsRequest
        ): Kleisli[M, Route53ResolverClient, ListFirewallConfigsResponse] =
          primitive(_.listFirewallConfigs(request))

        def listFirewallDomainLists(
          request: ListFirewallDomainListsRequest
        ): Kleisli[M, Route53ResolverClient, ListFirewallDomainListsResponse] =
          primitive(_.listFirewallDomainLists(request))

        def listFirewallDomains(
          request: ListFirewallDomainsRequest
        ): Kleisli[M, Route53ResolverClient, ListFirewallDomainsResponse] =
          primitive(_.listFirewallDomains(request))

        def listFirewallRuleGroupAssociations(
          request: ListFirewallRuleGroupAssociationsRequest
        ): Kleisli[M, Route53ResolverClient, ListFirewallRuleGroupAssociationsResponse] =
          primitive(_.listFirewallRuleGroupAssociations(request))

        def listFirewallRuleGroups(
          request: ListFirewallRuleGroupsRequest
        ): Kleisli[M, Route53ResolverClient, ListFirewallRuleGroupsResponse] =
          primitive(_.listFirewallRuleGroups(request))

        def listFirewallRules(
          request: ListFirewallRulesRequest
        ): Kleisli[M, Route53ResolverClient, ListFirewallRulesResponse] =
          primitive(_.listFirewallRules(request))

        def listResolverDnssecConfigs(
          request: ListResolverDnssecConfigsRequest
        ): Kleisli[M, Route53ResolverClient, ListResolverDnssecConfigsResponse] =
          primitive(_.listResolverDnssecConfigs(request))

        def listResolverEndpointIpAddresses(
          request: ListResolverEndpointIpAddressesRequest
        ): Kleisli[M, Route53ResolverClient, ListResolverEndpointIpAddressesResponse] =
          primitive(_.listResolverEndpointIpAddresses(request))

        def listResolverEndpoints(
          request: ListResolverEndpointsRequest
        ): Kleisli[M, Route53ResolverClient, ListResolverEndpointsResponse] =
          primitive(_.listResolverEndpoints(request))

        def listResolverQueryLogConfigAssociations(
          request: ListResolverQueryLogConfigAssociationsRequest
        ): Kleisli[M, Route53ResolverClient, ListResolverQueryLogConfigAssociationsResponse] =
          primitive(_.listResolverQueryLogConfigAssociations(request))

        def listResolverQueryLogConfigs(
          request: ListResolverQueryLogConfigsRequest
        ): Kleisli[M, Route53ResolverClient, ListResolverQueryLogConfigsResponse] =
          primitive(_.listResolverQueryLogConfigs(request))

        def listResolverRuleAssociations(
          request: ListResolverRuleAssociationsRequest
        ): Kleisli[M, Route53ResolverClient, ListResolverRuleAssociationsResponse] =
          primitive(_.listResolverRuleAssociations(request))

        def listResolverRules(
          request: ListResolverRulesRequest
        ): Kleisli[M, Route53ResolverClient, ListResolverRulesResponse] =
          primitive(_.listResolverRules(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, Route53ResolverClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putFirewallRuleGroupPolicy(
          request: PutFirewallRuleGroupPolicyRequest
        ): Kleisli[M, Route53ResolverClient, PutFirewallRuleGroupPolicyResponse] =
          primitive(_.putFirewallRuleGroupPolicy(request))

        def putResolverQueryLogConfigPolicy(
          request: PutResolverQueryLogConfigPolicyRequest
        ): Kleisli[M, Route53ResolverClient, PutResolverQueryLogConfigPolicyResponse] =
          primitive(_.putResolverQueryLogConfigPolicy(request))

        def putResolverRulePolicy(
          request: PutResolverRulePolicyRequest
        ): Kleisli[M, Route53ResolverClient, PutResolverRulePolicyResponse] =
          primitive(_.putResolverRulePolicy(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, Route53ResolverClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, Route53ResolverClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateFirewallConfig(
          request: UpdateFirewallConfigRequest
        ): Kleisli[M, Route53ResolverClient, UpdateFirewallConfigResponse] =
          primitive(_.updateFirewallConfig(request))

        def updateFirewallDomains(
          request: UpdateFirewallDomainsRequest
        ): Kleisli[M, Route53ResolverClient, UpdateFirewallDomainsResponse] =
          primitive(_.updateFirewallDomains(request))

        def updateFirewallRule(
          request: UpdateFirewallRuleRequest
        ): Kleisli[M, Route53ResolverClient, UpdateFirewallRuleResponse] =
          primitive(_.updateFirewallRule(request))

        def updateFirewallRuleGroupAssociation(
          request: UpdateFirewallRuleGroupAssociationRequest
        ): Kleisli[M, Route53ResolverClient, UpdateFirewallRuleGroupAssociationResponse] =
          primitive(_.updateFirewallRuleGroupAssociation(request))

        def updateResolverDnssecConfig(
          request: UpdateResolverDnssecConfigRequest
        ): Kleisli[M, Route53ResolverClient, UpdateResolverDnssecConfigResponse] =
          primitive(_.updateResolverDnssecConfig(request))

        def updateResolverEndpoint(
          request: UpdateResolverEndpointRequest
        ): Kleisli[M, Route53ResolverClient, UpdateResolverEndpointResponse] =
          primitive(_.updateResolverEndpoint(request))

        def updateResolverRule(
          request: UpdateResolverRuleRequest
        ): Kleisli[M, Route53ResolverClient, UpdateResolverRuleResponse] =
          primitive(_.updateResolverRule(request))

        def primitive[A](
          f: Route53ResolverClient => A
        ): Kleisli[M, Route53ResolverClient, A]
      }
    }

    trait Visitor[F[_]] extends (Route53ResolverOp ~> F) {
      final def apply[A](op: Route53ResolverOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateFirewallRuleGroup(
        request: AssociateFirewallRuleGroupRequest
      ): F[AssociateFirewallRuleGroupResponse]

      def associateResolverEndpointIpAddress(
        request: AssociateResolverEndpointIpAddressRequest
      ): F[AssociateResolverEndpointIpAddressResponse]

      def associateResolverQueryLogConfig(
        request: AssociateResolverQueryLogConfigRequest
      ): F[AssociateResolverQueryLogConfigResponse]

      def associateResolverRule(
        request: AssociateResolverRuleRequest
      ): F[AssociateResolverRuleResponse]

      def createFirewallDomainList(
        request: CreateFirewallDomainListRequest
      ): F[CreateFirewallDomainListResponse]

      def createFirewallRule(
        request: CreateFirewallRuleRequest
      ): F[CreateFirewallRuleResponse]

      def createFirewallRuleGroup(
        request: CreateFirewallRuleGroupRequest
      ): F[CreateFirewallRuleGroupResponse]

      def createResolverEndpoint(
        request: CreateResolverEndpointRequest
      ): F[CreateResolverEndpointResponse]

      def createResolverQueryLogConfig(
        request: CreateResolverQueryLogConfigRequest
      ): F[CreateResolverQueryLogConfigResponse]

      def createResolverRule(
        request: CreateResolverRuleRequest
      ): F[CreateResolverRuleResponse]

      def deleteFirewallDomainList(
        request: DeleteFirewallDomainListRequest
      ): F[DeleteFirewallDomainListResponse]

      def deleteFirewallRule(
        request: DeleteFirewallRuleRequest
      ): F[DeleteFirewallRuleResponse]

      def deleteFirewallRuleGroup(
        request: DeleteFirewallRuleGroupRequest
      ): F[DeleteFirewallRuleGroupResponse]

      def deleteResolverEndpoint(
        request: DeleteResolverEndpointRequest
      ): F[DeleteResolverEndpointResponse]

      def deleteResolverQueryLogConfig(
        request: DeleteResolverQueryLogConfigRequest
      ): F[DeleteResolverQueryLogConfigResponse]

      def deleteResolverRule(
        request: DeleteResolverRuleRequest
      ): F[DeleteResolverRuleResponse]

      def disassociateFirewallRuleGroup(
        request: DisassociateFirewallRuleGroupRequest
      ): F[DisassociateFirewallRuleGroupResponse]

      def disassociateResolverEndpointIpAddress(
        request: DisassociateResolverEndpointIpAddressRequest
      ): F[DisassociateResolverEndpointIpAddressResponse]

      def disassociateResolverQueryLogConfig(
        request: DisassociateResolverQueryLogConfigRequest
      ): F[DisassociateResolverQueryLogConfigResponse]

      def disassociateResolverRule(
        request: DisassociateResolverRuleRequest
      ): F[DisassociateResolverRuleResponse]

      def getFirewallConfig(
        request: GetFirewallConfigRequest
      ): F[GetFirewallConfigResponse]

      def getFirewallDomainList(
        request: GetFirewallDomainListRequest
      ): F[GetFirewallDomainListResponse]

      def getFirewallRuleGroup(
        request: GetFirewallRuleGroupRequest
      ): F[GetFirewallRuleGroupResponse]

      def getFirewallRuleGroupAssociation(
        request: GetFirewallRuleGroupAssociationRequest
      ): F[GetFirewallRuleGroupAssociationResponse]

      def getFirewallRuleGroupPolicy(
        request: GetFirewallRuleGroupPolicyRequest
      ): F[GetFirewallRuleGroupPolicyResponse]

      def getResolverDnssecConfig(
        request: GetResolverDnssecConfigRequest
      ): F[GetResolverDnssecConfigResponse]

      def getResolverEndpoint(
        request: GetResolverEndpointRequest
      ): F[GetResolverEndpointResponse]

      def getResolverQueryLogConfig(
        request: GetResolverQueryLogConfigRequest
      ): F[GetResolverQueryLogConfigResponse]

      def getResolverQueryLogConfigAssociation(
        request: GetResolverQueryLogConfigAssociationRequest
      ): F[GetResolverQueryLogConfigAssociationResponse]

      def getResolverQueryLogConfigPolicy(
        request: GetResolverQueryLogConfigPolicyRequest
      ): F[GetResolverQueryLogConfigPolicyResponse]

      def getResolverRule(
        request: GetResolverRuleRequest
      ): F[GetResolverRuleResponse]

      def getResolverRuleAssociation(
        request: GetResolverRuleAssociationRequest
      ): F[GetResolverRuleAssociationResponse]

      def getResolverRulePolicy(
        request: GetResolverRulePolicyRequest
      ): F[GetResolverRulePolicyResponse]

      def importFirewallDomains(
        request: ImportFirewallDomainsRequest
      ): F[ImportFirewallDomainsResponse]

      def listFirewallConfigs(
        request: ListFirewallConfigsRequest
      ): F[ListFirewallConfigsResponse]

      def listFirewallDomainLists(
        request: ListFirewallDomainListsRequest
      ): F[ListFirewallDomainListsResponse]

      def listFirewallDomains(
        request: ListFirewallDomainsRequest
      ): F[ListFirewallDomainsResponse]

      def listFirewallRuleGroupAssociations(
        request: ListFirewallRuleGroupAssociationsRequest
      ): F[ListFirewallRuleGroupAssociationsResponse]

      def listFirewallRuleGroups(
        request: ListFirewallRuleGroupsRequest
      ): F[ListFirewallRuleGroupsResponse]

      def listFirewallRules(
        request: ListFirewallRulesRequest
      ): F[ListFirewallRulesResponse]

      def listResolverDnssecConfigs(
        request: ListResolverDnssecConfigsRequest
      ): F[ListResolverDnssecConfigsResponse]

      def listResolverEndpointIpAddresses(
        request: ListResolverEndpointIpAddressesRequest
      ): F[ListResolverEndpointIpAddressesResponse]

      def listResolverEndpoints(
        request: ListResolverEndpointsRequest
      ): F[ListResolverEndpointsResponse]

      def listResolverQueryLogConfigAssociations(
        request: ListResolverQueryLogConfigAssociationsRequest
      ): F[ListResolverQueryLogConfigAssociationsResponse]

      def listResolverQueryLogConfigs(
        request: ListResolverQueryLogConfigsRequest
      ): F[ListResolverQueryLogConfigsResponse]

      def listResolverRuleAssociations(
        request: ListResolverRuleAssociationsRequest
      ): F[ListResolverRuleAssociationsResponse]

      def listResolverRules(
        request: ListResolverRulesRequest
      ): F[ListResolverRulesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putFirewallRuleGroupPolicy(
        request: PutFirewallRuleGroupPolicyRequest
      ): F[PutFirewallRuleGroupPolicyResponse]

      def putResolverQueryLogConfigPolicy(
        request: PutResolverQueryLogConfigPolicyRequest
      ): F[PutResolverQueryLogConfigPolicyResponse]

      def putResolverRulePolicy(
        request: PutResolverRulePolicyRequest
      ): F[PutResolverRulePolicyResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateFirewallConfig(
        request: UpdateFirewallConfigRequest
      ): F[UpdateFirewallConfigResponse]

      def updateFirewallDomains(
        request: UpdateFirewallDomainsRequest
      ): F[UpdateFirewallDomainsResponse]

      def updateFirewallRule(
        request: UpdateFirewallRuleRequest
      ): F[UpdateFirewallRuleResponse]

      def updateFirewallRuleGroupAssociation(
        request: UpdateFirewallRuleGroupAssociationRequest
      ): F[UpdateFirewallRuleGroupAssociationResponse]

      def updateResolverDnssecConfig(
        request: UpdateResolverDnssecConfigRequest
      ): F[UpdateResolverDnssecConfigResponse]

      def updateResolverEndpoint(
        request: UpdateResolverEndpointRequest
      ): F[UpdateResolverEndpointResponse]

      def updateResolverRule(
        request: UpdateResolverRuleRequest
      ): F[UpdateResolverRuleResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Route53ResolverOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateFirewallRuleGroupOp(
      request: AssociateFirewallRuleGroupRequest
    ) extends Route53ResolverOp[AssociateFirewallRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateFirewallRuleGroupResponse] =
        visitor.associateFirewallRuleGroup(request)
    }

    final case class AssociateResolverEndpointIpAddressOp(
      request: AssociateResolverEndpointIpAddressRequest
    ) extends Route53ResolverOp[AssociateResolverEndpointIpAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateResolverEndpointIpAddressResponse] =
        visitor.associateResolverEndpointIpAddress(request)
    }

    final case class AssociateResolverQueryLogConfigOp(
      request: AssociateResolverQueryLogConfigRequest
    ) extends Route53ResolverOp[AssociateResolverQueryLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateResolverQueryLogConfigResponse] =
        visitor.associateResolverQueryLogConfig(request)
    }

    final case class AssociateResolverRuleOp(
      request: AssociateResolverRuleRequest
    ) extends Route53ResolverOp[AssociateResolverRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateResolverRuleResponse] =
        visitor.associateResolverRule(request)
    }

    final case class CreateFirewallDomainListOp(
      request: CreateFirewallDomainListRequest
    ) extends Route53ResolverOp[CreateFirewallDomainListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFirewallDomainListResponse] =
        visitor.createFirewallDomainList(request)
    }

    final case class CreateFirewallRuleOp(
      request: CreateFirewallRuleRequest
    ) extends Route53ResolverOp[CreateFirewallRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFirewallRuleResponse] =
        visitor.createFirewallRule(request)
    }

    final case class CreateFirewallRuleGroupOp(
      request: CreateFirewallRuleGroupRequest
    ) extends Route53ResolverOp[CreateFirewallRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFirewallRuleGroupResponse] =
        visitor.createFirewallRuleGroup(request)
    }

    final case class CreateResolverEndpointOp(
      request: CreateResolverEndpointRequest
    ) extends Route53ResolverOp[CreateResolverEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResolverEndpointResponse] =
        visitor.createResolverEndpoint(request)
    }

    final case class CreateResolverQueryLogConfigOp(
      request: CreateResolverQueryLogConfigRequest
    ) extends Route53ResolverOp[CreateResolverQueryLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResolverQueryLogConfigResponse] =
        visitor.createResolverQueryLogConfig(request)
    }

    final case class CreateResolverRuleOp(
      request: CreateResolverRuleRequest
    ) extends Route53ResolverOp[CreateResolverRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResolverRuleResponse] =
        visitor.createResolverRule(request)
    }

    final case class DeleteFirewallDomainListOp(
      request: DeleteFirewallDomainListRequest
    ) extends Route53ResolverOp[DeleteFirewallDomainListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFirewallDomainListResponse] =
        visitor.deleteFirewallDomainList(request)
    }

    final case class DeleteFirewallRuleOp(
      request: DeleteFirewallRuleRequest
    ) extends Route53ResolverOp[DeleteFirewallRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFirewallRuleResponse] =
        visitor.deleteFirewallRule(request)
    }

    final case class DeleteFirewallRuleGroupOp(
      request: DeleteFirewallRuleGroupRequest
    ) extends Route53ResolverOp[DeleteFirewallRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFirewallRuleGroupResponse] =
        visitor.deleteFirewallRuleGroup(request)
    }

    final case class DeleteResolverEndpointOp(
      request: DeleteResolverEndpointRequest
    ) extends Route53ResolverOp[DeleteResolverEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResolverEndpointResponse] =
        visitor.deleteResolverEndpoint(request)
    }

    final case class DeleteResolverQueryLogConfigOp(
      request: DeleteResolverQueryLogConfigRequest
    ) extends Route53ResolverOp[DeleteResolverQueryLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResolverQueryLogConfigResponse] =
        visitor.deleteResolverQueryLogConfig(request)
    }

    final case class DeleteResolverRuleOp(
      request: DeleteResolverRuleRequest
    ) extends Route53ResolverOp[DeleteResolverRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResolverRuleResponse] =
        visitor.deleteResolverRule(request)
    }

    final case class DisassociateFirewallRuleGroupOp(
      request: DisassociateFirewallRuleGroupRequest
    ) extends Route53ResolverOp[DisassociateFirewallRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFirewallRuleGroupResponse] =
        visitor.disassociateFirewallRuleGroup(request)
    }

    final case class DisassociateResolverEndpointIpAddressOp(
      request: DisassociateResolverEndpointIpAddressRequest
    ) extends Route53ResolverOp[DisassociateResolverEndpointIpAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateResolverEndpointIpAddressResponse] =
        visitor.disassociateResolverEndpointIpAddress(request)
    }

    final case class DisassociateResolverQueryLogConfigOp(
      request: DisassociateResolverQueryLogConfigRequest
    ) extends Route53ResolverOp[DisassociateResolverQueryLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateResolverQueryLogConfigResponse] =
        visitor.disassociateResolverQueryLogConfig(request)
    }

    final case class DisassociateResolverRuleOp(
      request: DisassociateResolverRuleRequest
    ) extends Route53ResolverOp[DisassociateResolverRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateResolverRuleResponse] =
        visitor.disassociateResolverRule(request)
    }

    final case class GetFirewallConfigOp(
      request: GetFirewallConfigRequest
    ) extends Route53ResolverOp[GetFirewallConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFirewallConfigResponse] =
        visitor.getFirewallConfig(request)
    }

    final case class GetFirewallDomainListOp(
      request: GetFirewallDomainListRequest
    ) extends Route53ResolverOp[GetFirewallDomainListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFirewallDomainListResponse] =
        visitor.getFirewallDomainList(request)
    }

    final case class GetFirewallRuleGroupOp(
      request: GetFirewallRuleGroupRequest
    ) extends Route53ResolverOp[GetFirewallRuleGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFirewallRuleGroupResponse] =
        visitor.getFirewallRuleGroup(request)
    }

    final case class GetFirewallRuleGroupAssociationOp(
      request: GetFirewallRuleGroupAssociationRequest
    ) extends Route53ResolverOp[GetFirewallRuleGroupAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFirewallRuleGroupAssociationResponse] =
        visitor.getFirewallRuleGroupAssociation(request)
    }

    final case class GetFirewallRuleGroupPolicyOp(
      request: GetFirewallRuleGroupPolicyRequest
    ) extends Route53ResolverOp[GetFirewallRuleGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFirewallRuleGroupPolicyResponse] =
        visitor.getFirewallRuleGroupPolicy(request)
    }

    final case class GetResolverDnssecConfigOp(
      request: GetResolverDnssecConfigRequest
    ) extends Route53ResolverOp[GetResolverDnssecConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverDnssecConfigResponse] =
        visitor.getResolverDnssecConfig(request)
    }

    final case class GetResolverEndpointOp(
      request: GetResolverEndpointRequest
    ) extends Route53ResolverOp[GetResolverEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverEndpointResponse] =
        visitor.getResolverEndpoint(request)
    }

    final case class GetResolverQueryLogConfigOp(
      request: GetResolverQueryLogConfigRequest
    ) extends Route53ResolverOp[GetResolverQueryLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverQueryLogConfigResponse] =
        visitor.getResolverQueryLogConfig(request)
    }

    final case class GetResolverQueryLogConfigAssociationOp(
      request: GetResolverQueryLogConfigAssociationRequest
    ) extends Route53ResolverOp[GetResolverQueryLogConfigAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverQueryLogConfigAssociationResponse] =
        visitor.getResolverQueryLogConfigAssociation(request)
    }

    final case class GetResolverQueryLogConfigPolicyOp(
      request: GetResolverQueryLogConfigPolicyRequest
    ) extends Route53ResolverOp[GetResolverQueryLogConfigPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverQueryLogConfigPolicyResponse] =
        visitor.getResolverQueryLogConfigPolicy(request)
    }

    final case class GetResolverRuleOp(
      request: GetResolverRuleRequest
    ) extends Route53ResolverOp[GetResolverRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverRuleResponse] =
        visitor.getResolverRule(request)
    }

    final case class GetResolverRuleAssociationOp(
      request: GetResolverRuleAssociationRequest
    ) extends Route53ResolverOp[GetResolverRuleAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverRuleAssociationResponse] =
        visitor.getResolverRuleAssociation(request)
    }

    final case class GetResolverRulePolicyOp(
      request: GetResolverRulePolicyRequest
    ) extends Route53ResolverOp[GetResolverRulePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverRulePolicyResponse] =
        visitor.getResolverRulePolicy(request)
    }

    final case class ImportFirewallDomainsOp(
      request: ImportFirewallDomainsRequest
    ) extends Route53ResolverOp[ImportFirewallDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportFirewallDomainsResponse] =
        visitor.importFirewallDomains(request)
    }

    final case class ListFirewallConfigsOp(
      request: ListFirewallConfigsRequest
    ) extends Route53ResolverOp[ListFirewallConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallConfigsResponse] =
        visitor.listFirewallConfigs(request)
    }

    final case class ListFirewallDomainListsOp(
      request: ListFirewallDomainListsRequest
    ) extends Route53ResolverOp[ListFirewallDomainListsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallDomainListsResponse] =
        visitor.listFirewallDomainLists(request)
    }

    final case class ListFirewallDomainsOp(
      request: ListFirewallDomainsRequest
    ) extends Route53ResolverOp[ListFirewallDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallDomainsResponse] =
        visitor.listFirewallDomains(request)
    }

    final case class ListFirewallRuleGroupAssociationsOp(
      request: ListFirewallRuleGroupAssociationsRequest
    ) extends Route53ResolverOp[ListFirewallRuleGroupAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallRuleGroupAssociationsResponse] =
        visitor.listFirewallRuleGroupAssociations(request)
    }

    final case class ListFirewallRuleGroupsOp(
      request: ListFirewallRuleGroupsRequest
    ) extends Route53ResolverOp[ListFirewallRuleGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallRuleGroupsResponse] =
        visitor.listFirewallRuleGroups(request)
    }

    final case class ListFirewallRulesOp(
      request: ListFirewallRulesRequest
    ) extends Route53ResolverOp[ListFirewallRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFirewallRulesResponse] =
        visitor.listFirewallRules(request)
    }

    final case class ListResolverDnssecConfigsOp(
      request: ListResolverDnssecConfigsRequest
    ) extends Route53ResolverOp[ListResolverDnssecConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolverDnssecConfigsResponse] =
        visitor.listResolverDnssecConfigs(request)
    }

    final case class ListResolverEndpointIpAddressesOp(
      request: ListResolverEndpointIpAddressesRequest
    ) extends Route53ResolverOp[ListResolverEndpointIpAddressesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolverEndpointIpAddressesResponse] =
        visitor.listResolverEndpointIpAddresses(request)
    }

    final case class ListResolverEndpointsOp(
      request: ListResolverEndpointsRequest
    ) extends Route53ResolverOp[ListResolverEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolverEndpointsResponse] =
        visitor.listResolverEndpoints(request)
    }

    final case class ListResolverQueryLogConfigAssociationsOp(
      request: ListResolverQueryLogConfigAssociationsRequest
    ) extends Route53ResolverOp[ListResolverQueryLogConfigAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolverQueryLogConfigAssociationsResponse] =
        visitor.listResolverQueryLogConfigAssociations(request)
    }

    final case class ListResolverQueryLogConfigsOp(
      request: ListResolverQueryLogConfigsRequest
    ) extends Route53ResolverOp[ListResolverQueryLogConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolverQueryLogConfigsResponse] =
        visitor.listResolverQueryLogConfigs(request)
    }

    final case class ListResolverRuleAssociationsOp(
      request: ListResolverRuleAssociationsRequest
    ) extends Route53ResolverOp[ListResolverRuleAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolverRuleAssociationsResponse] =
        visitor.listResolverRuleAssociations(request)
    }

    final case class ListResolverRulesOp(
      request: ListResolverRulesRequest
    ) extends Route53ResolverOp[ListResolverRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolverRulesResponse] =
        visitor.listResolverRules(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends Route53ResolverOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutFirewallRuleGroupPolicyOp(
      request: PutFirewallRuleGroupPolicyRequest
    ) extends Route53ResolverOp[PutFirewallRuleGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFirewallRuleGroupPolicyResponse] =
        visitor.putFirewallRuleGroupPolicy(request)
    }

    final case class PutResolverQueryLogConfigPolicyOp(
      request: PutResolverQueryLogConfigPolicyRequest
    ) extends Route53ResolverOp[PutResolverQueryLogConfigPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResolverQueryLogConfigPolicyResponse] =
        visitor.putResolverQueryLogConfigPolicy(request)
    }

    final case class PutResolverRulePolicyOp(
      request: PutResolverRulePolicyRequest
    ) extends Route53ResolverOp[PutResolverRulePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResolverRulePolicyResponse] =
        visitor.putResolverRulePolicy(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends Route53ResolverOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends Route53ResolverOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateFirewallConfigOp(
      request: UpdateFirewallConfigRequest
    ) extends Route53ResolverOp[UpdateFirewallConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallConfigResponse] =
        visitor.updateFirewallConfig(request)
    }

    final case class UpdateFirewallDomainsOp(
      request: UpdateFirewallDomainsRequest
    ) extends Route53ResolverOp[UpdateFirewallDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallDomainsResponse] =
        visitor.updateFirewallDomains(request)
    }

    final case class UpdateFirewallRuleOp(
      request: UpdateFirewallRuleRequest
    ) extends Route53ResolverOp[UpdateFirewallRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallRuleResponse] =
        visitor.updateFirewallRule(request)
    }

    final case class UpdateFirewallRuleGroupAssociationOp(
      request: UpdateFirewallRuleGroupAssociationRequest
    ) extends Route53ResolverOp[UpdateFirewallRuleGroupAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFirewallRuleGroupAssociationResponse] =
        visitor.updateFirewallRuleGroupAssociation(request)
    }

    final case class UpdateResolverDnssecConfigOp(
      request: UpdateResolverDnssecConfigRequest
    ) extends Route53ResolverOp[UpdateResolverDnssecConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResolverDnssecConfigResponse] =
        visitor.updateResolverDnssecConfig(request)
    }

    final case class UpdateResolverEndpointOp(
      request: UpdateResolverEndpointRequest
    ) extends Route53ResolverOp[UpdateResolverEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResolverEndpointResponse] =
        visitor.updateResolverEndpoint(request)
    }

    final case class UpdateResolverRuleOp(
      request: UpdateResolverRuleRequest
    ) extends Route53ResolverOp[UpdateResolverRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResolverRuleResponse] =
        visitor.updateResolverRule(request)
    }
  }

  import Route53ResolverOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Route53ResolverOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateFirewallRuleGroup(
    request: AssociateFirewallRuleGroupRequest
  ): Route53ResolverIO[AssociateFirewallRuleGroupResponse] =
    FF.liftF(AssociateFirewallRuleGroupOp(request))

  def associateResolverEndpointIpAddress(
    request: AssociateResolverEndpointIpAddressRequest
  ): Route53ResolverIO[AssociateResolverEndpointIpAddressResponse] =
    FF.liftF(AssociateResolverEndpointIpAddressOp(request))

  def associateResolverQueryLogConfig(
    request: AssociateResolverQueryLogConfigRequest
  ): Route53ResolverIO[AssociateResolverQueryLogConfigResponse] =
    FF.liftF(AssociateResolverQueryLogConfigOp(request))

  def associateResolverRule(
    request: AssociateResolverRuleRequest
  ): Route53ResolverIO[AssociateResolverRuleResponse] =
    FF.liftF(AssociateResolverRuleOp(request))

  def createFirewallDomainList(
    request: CreateFirewallDomainListRequest
  ): Route53ResolverIO[CreateFirewallDomainListResponse] =
    FF.liftF(CreateFirewallDomainListOp(request))

  def createFirewallRule(
    request: CreateFirewallRuleRequest
  ): Route53ResolverIO[CreateFirewallRuleResponse] =
    FF.liftF(CreateFirewallRuleOp(request))

  def createFirewallRuleGroup(
    request: CreateFirewallRuleGroupRequest
  ): Route53ResolverIO[CreateFirewallRuleGroupResponse] =
    FF.liftF(CreateFirewallRuleGroupOp(request))

  def createResolverEndpoint(
    request: CreateResolverEndpointRequest
  ): Route53ResolverIO[CreateResolverEndpointResponse] =
    FF.liftF(CreateResolverEndpointOp(request))

  def createResolverQueryLogConfig(
    request: CreateResolverQueryLogConfigRequest
  ): Route53ResolverIO[CreateResolverQueryLogConfigResponse] =
    FF.liftF(CreateResolverQueryLogConfigOp(request))

  def createResolverRule(
    request: CreateResolverRuleRequest
  ): Route53ResolverIO[CreateResolverRuleResponse] =
    FF.liftF(CreateResolverRuleOp(request))

  def deleteFirewallDomainList(
    request: DeleteFirewallDomainListRequest
  ): Route53ResolverIO[DeleteFirewallDomainListResponse] =
    FF.liftF(DeleteFirewallDomainListOp(request))

  def deleteFirewallRule(
    request: DeleteFirewallRuleRequest
  ): Route53ResolverIO[DeleteFirewallRuleResponse] =
    FF.liftF(DeleteFirewallRuleOp(request))

  def deleteFirewallRuleGroup(
    request: DeleteFirewallRuleGroupRequest
  ): Route53ResolverIO[DeleteFirewallRuleGroupResponse] =
    FF.liftF(DeleteFirewallRuleGroupOp(request))

  def deleteResolverEndpoint(
    request: DeleteResolverEndpointRequest
  ): Route53ResolverIO[DeleteResolverEndpointResponse] =
    FF.liftF(DeleteResolverEndpointOp(request))

  def deleteResolverQueryLogConfig(
    request: DeleteResolverQueryLogConfigRequest
  ): Route53ResolverIO[DeleteResolverQueryLogConfigResponse] =
    FF.liftF(DeleteResolverQueryLogConfigOp(request))

  def deleteResolverRule(
    request: DeleteResolverRuleRequest
  ): Route53ResolverIO[DeleteResolverRuleResponse] =
    FF.liftF(DeleteResolverRuleOp(request))

  def disassociateFirewallRuleGroup(
    request: DisassociateFirewallRuleGroupRequest
  ): Route53ResolverIO[DisassociateFirewallRuleGroupResponse] =
    FF.liftF(DisassociateFirewallRuleGroupOp(request))

  def disassociateResolverEndpointIpAddress(
    request: DisassociateResolverEndpointIpAddressRequest
  ): Route53ResolverIO[DisassociateResolverEndpointIpAddressResponse] =
    FF.liftF(DisassociateResolverEndpointIpAddressOp(request))

  def disassociateResolverQueryLogConfig(
    request: DisassociateResolverQueryLogConfigRequest
  ): Route53ResolverIO[DisassociateResolverQueryLogConfigResponse] =
    FF.liftF(DisassociateResolverQueryLogConfigOp(request))

  def disassociateResolverRule(
    request: DisassociateResolverRuleRequest
  ): Route53ResolverIO[DisassociateResolverRuleResponse] =
    FF.liftF(DisassociateResolverRuleOp(request))

  def getFirewallConfig(
    request: GetFirewallConfigRequest
  ): Route53ResolverIO[GetFirewallConfigResponse] =
    FF.liftF(GetFirewallConfigOp(request))

  def getFirewallDomainList(
    request: GetFirewallDomainListRequest
  ): Route53ResolverIO[GetFirewallDomainListResponse] =
    FF.liftF(GetFirewallDomainListOp(request))

  def getFirewallRuleGroup(
    request: GetFirewallRuleGroupRequest
  ): Route53ResolverIO[GetFirewallRuleGroupResponse] =
    FF.liftF(GetFirewallRuleGroupOp(request))

  def getFirewallRuleGroupAssociation(
    request: GetFirewallRuleGroupAssociationRequest
  ): Route53ResolverIO[GetFirewallRuleGroupAssociationResponse] =
    FF.liftF(GetFirewallRuleGroupAssociationOp(request))

  def getFirewallRuleGroupPolicy(
    request: GetFirewallRuleGroupPolicyRequest
  ): Route53ResolverIO[GetFirewallRuleGroupPolicyResponse] =
    FF.liftF(GetFirewallRuleGroupPolicyOp(request))

  def getResolverDnssecConfig(
    request: GetResolverDnssecConfigRequest
  ): Route53ResolverIO[GetResolverDnssecConfigResponse] =
    FF.liftF(GetResolverDnssecConfigOp(request))

  def getResolverEndpoint(
    request: GetResolverEndpointRequest
  ): Route53ResolverIO[GetResolverEndpointResponse] =
    FF.liftF(GetResolverEndpointOp(request))

  def getResolverQueryLogConfig(
    request: GetResolverQueryLogConfigRequest
  ): Route53ResolverIO[GetResolverQueryLogConfigResponse] =
    FF.liftF(GetResolverQueryLogConfigOp(request))

  def getResolverQueryLogConfigAssociation(
    request: GetResolverQueryLogConfigAssociationRequest
  ): Route53ResolverIO[GetResolverQueryLogConfigAssociationResponse] =
    FF.liftF(GetResolverQueryLogConfigAssociationOp(request))

  def getResolverQueryLogConfigPolicy(
    request: GetResolverQueryLogConfigPolicyRequest
  ): Route53ResolverIO[GetResolverQueryLogConfigPolicyResponse] =
    FF.liftF(GetResolverQueryLogConfigPolicyOp(request))

  def getResolverRule(
    request: GetResolverRuleRequest
  ): Route53ResolverIO[GetResolverRuleResponse] =
    FF.liftF(GetResolverRuleOp(request))

  def getResolverRuleAssociation(
    request: GetResolverRuleAssociationRequest
  ): Route53ResolverIO[GetResolverRuleAssociationResponse] =
    FF.liftF(GetResolverRuleAssociationOp(request))

  def getResolverRulePolicy(
    request: GetResolverRulePolicyRequest
  ): Route53ResolverIO[GetResolverRulePolicyResponse] =
    FF.liftF(GetResolverRulePolicyOp(request))

  def importFirewallDomains(
    request: ImportFirewallDomainsRequest
  ): Route53ResolverIO[ImportFirewallDomainsResponse] =
    FF.liftF(ImportFirewallDomainsOp(request))

  def listFirewallConfigs(
    request: ListFirewallConfigsRequest
  ): Route53ResolverIO[ListFirewallConfigsResponse] =
    FF.liftF(ListFirewallConfigsOp(request))

  def listFirewallDomainLists(
    request: ListFirewallDomainListsRequest
  ): Route53ResolverIO[ListFirewallDomainListsResponse] =
    FF.liftF(ListFirewallDomainListsOp(request))

  def listFirewallDomains(
    request: ListFirewallDomainsRequest
  ): Route53ResolverIO[ListFirewallDomainsResponse] =
    FF.liftF(ListFirewallDomainsOp(request))

  def listFirewallRuleGroupAssociations(
    request: ListFirewallRuleGroupAssociationsRequest
  ): Route53ResolverIO[ListFirewallRuleGroupAssociationsResponse] =
    FF.liftF(ListFirewallRuleGroupAssociationsOp(request))

  def listFirewallRuleGroups(
    request: ListFirewallRuleGroupsRequest
  ): Route53ResolverIO[ListFirewallRuleGroupsResponse] =
    FF.liftF(ListFirewallRuleGroupsOp(request))

  def listFirewallRules(
    request: ListFirewallRulesRequest
  ): Route53ResolverIO[ListFirewallRulesResponse] =
    FF.liftF(ListFirewallRulesOp(request))

  def listResolverDnssecConfigs(
    request: ListResolverDnssecConfigsRequest
  ): Route53ResolverIO[ListResolverDnssecConfigsResponse] =
    FF.liftF(ListResolverDnssecConfigsOp(request))

  def listResolverEndpointIpAddresses(
    request: ListResolverEndpointIpAddressesRequest
  ): Route53ResolverIO[ListResolverEndpointIpAddressesResponse] =
    FF.liftF(ListResolverEndpointIpAddressesOp(request))

  def listResolverEndpoints(
    request: ListResolverEndpointsRequest
  ): Route53ResolverIO[ListResolverEndpointsResponse] =
    FF.liftF(ListResolverEndpointsOp(request))

  def listResolverQueryLogConfigAssociations(
    request: ListResolverQueryLogConfigAssociationsRequest
  ): Route53ResolverIO[ListResolverQueryLogConfigAssociationsResponse] =
    FF.liftF(ListResolverQueryLogConfigAssociationsOp(request))

  def listResolverQueryLogConfigs(
    request: ListResolverQueryLogConfigsRequest
  ): Route53ResolverIO[ListResolverQueryLogConfigsResponse] =
    FF.liftF(ListResolverQueryLogConfigsOp(request))

  def listResolverRuleAssociations(
    request: ListResolverRuleAssociationsRequest
  ): Route53ResolverIO[ListResolverRuleAssociationsResponse] =
    FF.liftF(ListResolverRuleAssociationsOp(request))

  def listResolverRules(
    request: ListResolverRulesRequest
  ): Route53ResolverIO[ListResolverRulesResponse] =
    FF.liftF(ListResolverRulesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): Route53ResolverIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putFirewallRuleGroupPolicy(
    request: PutFirewallRuleGroupPolicyRequest
  ): Route53ResolverIO[PutFirewallRuleGroupPolicyResponse] =
    FF.liftF(PutFirewallRuleGroupPolicyOp(request))

  def putResolverQueryLogConfigPolicy(
    request: PutResolverQueryLogConfigPolicyRequest
  ): Route53ResolverIO[PutResolverQueryLogConfigPolicyResponse] =
    FF.liftF(PutResolverQueryLogConfigPolicyOp(request))

  def putResolverRulePolicy(
    request: PutResolverRulePolicyRequest
  ): Route53ResolverIO[PutResolverRulePolicyResponse] =
    FF.liftF(PutResolverRulePolicyOp(request))

  def tagResource(
    request: TagResourceRequest
  ): Route53ResolverIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): Route53ResolverIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateFirewallConfig(
    request: UpdateFirewallConfigRequest
  ): Route53ResolverIO[UpdateFirewallConfigResponse] =
    FF.liftF(UpdateFirewallConfigOp(request))

  def updateFirewallDomains(
    request: UpdateFirewallDomainsRequest
  ): Route53ResolverIO[UpdateFirewallDomainsResponse] =
    FF.liftF(UpdateFirewallDomainsOp(request))

  def updateFirewallRule(
    request: UpdateFirewallRuleRequest
  ): Route53ResolverIO[UpdateFirewallRuleResponse] =
    FF.liftF(UpdateFirewallRuleOp(request))

  def updateFirewallRuleGroupAssociation(
    request: UpdateFirewallRuleGroupAssociationRequest
  ): Route53ResolverIO[UpdateFirewallRuleGroupAssociationResponse] =
    FF.liftF(UpdateFirewallRuleGroupAssociationOp(request))

  def updateResolverDnssecConfig(
    request: UpdateResolverDnssecConfigRequest
  ): Route53ResolverIO[UpdateResolverDnssecConfigResponse] =
    FF.liftF(UpdateResolverDnssecConfigOp(request))

  def updateResolverEndpoint(
    request: UpdateResolverEndpointRequest
  ): Route53ResolverIO[UpdateResolverEndpointResponse] =
    FF.liftF(UpdateResolverEndpointOp(request))

  def updateResolverRule(
    request: UpdateResolverRuleRequest
  ): Route53ResolverIO[UpdateResolverRuleResponse] =
    FF.liftF(UpdateResolverRuleOp(request))
}
