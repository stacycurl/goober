package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.elasticloadbalancing.ElasticLoadBalancingClient
import software.amazon.awssdk.services.elasticloadbalancing.model._


object elasticloadbalancing { module =>

  // Free monad over ElasticLoadBalancingOp
  type ElasticLoadBalancingIO[A] = FF[ElasticLoadBalancingOp, A]

  sealed trait ElasticLoadBalancingOp[A] {
    def visit[F[_]](visitor: ElasticLoadBalancingOp.Visitor[F]): F[A]
  }

  object ElasticLoadBalancingOp {
    // Given a ElasticLoadBalancingClient we can embed a ElasticLoadBalancingIO program in any algebra that understands embedding.
    implicit val ElasticLoadBalancingOpEmbeddable: Embeddable[ElasticLoadBalancingOp, ElasticLoadBalancingClient] = new Embeddable[ElasticLoadBalancingOp, ElasticLoadBalancingClient] {
      def embed[A](client: ElasticLoadBalancingClient, io: ElasticLoadBalancingIO[A]): Embedded[A] = Embedded.ElasticLoadBalancing(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ElasticLoadBalancingOp.Visitor[Kleisli[M, ElasticLoadBalancingClient, *]] {
        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, ElasticLoadBalancingClient, AddTagsResponse] =
          primitive(_.addTags(request))

        def applySecurityGroupsToLoadBalancer(
          request: ApplySecurityGroupsToLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, ApplySecurityGroupsToLoadBalancerResponse] =
          primitive(_.applySecurityGroupsToLoadBalancer(request))

        def attachLoadBalancerToSubnets(
          request: AttachLoadBalancerToSubnetsRequest
        ): Kleisli[M, ElasticLoadBalancingClient, AttachLoadBalancerToSubnetsResponse] =
          primitive(_.attachLoadBalancerToSubnets(request))

        def configureHealthCheck(
          request: ConfigureHealthCheckRequest
        ): Kleisli[M, ElasticLoadBalancingClient, ConfigureHealthCheckResponse] =
          primitive(_.configureHealthCheck(request))

        def createAppCookieStickinessPolicy(
          request: CreateAppCookieStickinessPolicyRequest
        ): Kleisli[M, ElasticLoadBalancingClient, CreateAppCookieStickinessPolicyResponse] =
          primitive(_.createAppCookieStickinessPolicy(request))

        def createLBCookieStickinessPolicy(
          request: CreateLbCookieStickinessPolicyRequest
        ): Kleisli[M, ElasticLoadBalancingClient, CreateLbCookieStickinessPolicyResponse] =
          primitive(_.createLBCookieStickinessPolicy(request))

        def createLoadBalancer(
          request: CreateLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, CreateLoadBalancerResponse] =
          primitive(_.createLoadBalancer(request))

        def createLoadBalancerListeners(
          request: CreateLoadBalancerListenersRequest
        ): Kleisli[M, ElasticLoadBalancingClient, CreateLoadBalancerListenersResponse] =
          primitive(_.createLoadBalancerListeners(request))

        def createLoadBalancerPolicy(
          request: CreateLoadBalancerPolicyRequest
        ): Kleisli[M, ElasticLoadBalancingClient, CreateLoadBalancerPolicyResponse] =
          primitive(_.createLoadBalancerPolicy(request))

        def deleteLoadBalancer(
          request: DeleteLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DeleteLoadBalancerResponse] =
          primitive(_.deleteLoadBalancer(request))

        def deleteLoadBalancerListeners(
          request: DeleteLoadBalancerListenersRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DeleteLoadBalancerListenersResponse] =
          primitive(_.deleteLoadBalancerListeners(request))

        def deleteLoadBalancerPolicy(
          request: DeleteLoadBalancerPolicyRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DeleteLoadBalancerPolicyResponse] =
          primitive(_.deleteLoadBalancerPolicy(request))

        def deregisterInstancesFromLoadBalancer(
          request: DeregisterInstancesFromLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DeregisterInstancesFromLoadBalancerResponse] =
          primitive(_.deregisterInstancesFromLoadBalancer(request))

        def describeAccountLimits(
          request: DescribeAccountLimitsRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DescribeAccountLimitsResponse] =
          primitive(_.describeAccountLimits(request))

        def describeInstanceHealth(
          request: DescribeInstanceHealthRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DescribeInstanceHealthResponse] =
          primitive(_.describeInstanceHealth(request))

        def describeLoadBalancerAttributes(
          request: DescribeLoadBalancerAttributesRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DescribeLoadBalancerAttributesResponse] =
          primitive(_.describeLoadBalancerAttributes(request))

        def describeLoadBalancerPolicies(
          request: DescribeLoadBalancerPoliciesRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DescribeLoadBalancerPoliciesResponse] =
          primitive(_.describeLoadBalancerPolicies(request))

        def describeLoadBalancerPolicyTypes(
          request: DescribeLoadBalancerPolicyTypesRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DescribeLoadBalancerPolicyTypesResponse] =
          primitive(_.describeLoadBalancerPolicyTypes(request))

        def describeLoadBalancers(
          request: DescribeLoadBalancersRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DescribeLoadBalancersResponse] =
          primitive(_.describeLoadBalancers(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def detachLoadBalancerFromSubnets(
          request: DetachLoadBalancerFromSubnetsRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DetachLoadBalancerFromSubnetsResponse] =
          primitive(_.detachLoadBalancerFromSubnets(request))

        def disableAvailabilityZonesForLoadBalancer(
          request: DisableAvailabilityZonesForLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, DisableAvailabilityZonesForLoadBalancerResponse] =
          primitive(_.disableAvailabilityZonesForLoadBalancer(request))

        def enableAvailabilityZonesForLoadBalancer(
          request: EnableAvailabilityZonesForLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, EnableAvailabilityZonesForLoadBalancerResponse] =
          primitive(_.enableAvailabilityZonesForLoadBalancer(request))

        def modifyLoadBalancerAttributes(
          request: ModifyLoadBalancerAttributesRequest
        ): Kleisli[M, ElasticLoadBalancingClient, ModifyLoadBalancerAttributesResponse] =
          primitive(_.modifyLoadBalancerAttributes(request))

        def registerInstancesWithLoadBalancer(
          request: RegisterInstancesWithLoadBalancerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, RegisterInstancesWithLoadBalancerResponse] =
          primitive(_.registerInstancesWithLoadBalancer(request))

        def removeTags(
          request: RemoveTagsRequest
        ): Kleisli[M, ElasticLoadBalancingClient, RemoveTagsResponse] =
          primitive(_.removeTags(request))

        def setLoadBalancerListenerSSLCertificate(
          request: SetLoadBalancerListenerSslCertificateRequest
        ): Kleisli[M, ElasticLoadBalancingClient, SetLoadBalancerListenerSslCertificateResponse] =
          primitive(_.setLoadBalancerListenerSSLCertificate(request))

        def setLoadBalancerPoliciesForBackendServer(
          request: SetLoadBalancerPoliciesForBackendServerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, SetLoadBalancerPoliciesForBackendServerResponse] =
          primitive(_.setLoadBalancerPoliciesForBackendServer(request))

        def setLoadBalancerPoliciesOfListener(
          request: SetLoadBalancerPoliciesOfListenerRequest
        ): Kleisli[M, ElasticLoadBalancingClient, SetLoadBalancerPoliciesOfListenerResponse] =
          primitive(_.setLoadBalancerPoliciesOfListener(request))

        def primitive[A](
          f: ElasticLoadBalancingClient => A
        ): Kleisli[M, ElasticLoadBalancingClient, A]
      }
    }

    trait Visitor[F[_]] extends (ElasticLoadBalancingOp ~> F) {
      final def apply[A](op: ElasticLoadBalancingOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def applySecurityGroupsToLoadBalancer(
        request: ApplySecurityGroupsToLoadBalancerRequest
      ): F[ApplySecurityGroupsToLoadBalancerResponse]

      def attachLoadBalancerToSubnets(
        request: AttachLoadBalancerToSubnetsRequest
      ): F[AttachLoadBalancerToSubnetsResponse]

      def configureHealthCheck(
        request: ConfigureHealthCheckRequest
      ): F[ConfigureHealthCheckResponse]

      def createAppCookieStickinessPolicy(
        request: CreateAppCookieStickinessPolicyRequest
      ): F[CreateAppCookieStickinessPolicyResponse]

      def createLBCookieStickinessPolicy(
        request: CreateLbCookieStickinessPolicyRequest
      ): F[CreateLbCookieStickinessPolicyResponse]

      def createLoadBalancer(
        request: CreateLoadBalancerRequest
      ): F[CreateLoadBalancerResponse]

      def createLoadBalancerListeners(
        request: CreateLoadBalancerListenersRequest
      ): F[CreateLoadBalancerListenersResponse]

      def createLoadBalancerPolicy(
        request: CreateLoadBalancerPolicyRequest
      ): F[CreateLoadBalancerPolicyResponse]

      def deleteLoadBalancer(
        request: DeleteLoadBalancerRequest
      ): F[DeleteLoadBalancerResponse]

      def deleteLoadBalancerListeners(
        request: DeleteLoadBalancerListenersRequest
      ): F[DeleteLoadBalancerListenersResponse]

      def deleteLoadBalancerPolicy(
        request: DeleteLoadBalancerPolicyRequest
      ): F[DeleteLoadBalancerPolicyResponse]

      def deregisterInstancesFromLoadBalancer(
        request: DeregisterInstancesFromLoadBalancerRequest
      ): F[DeregisterInstancesFromLoadBalancerResponse]

      def describeAccountLimits(
        request: DescribeAccountLimitsRequest
      ): F[DescribeAccountLimitsResponse]

      def describeInstanceHealth(
        request: DescribeInstanceHealthRequest
      ): F[DescribeInstanceHealthResponse]

      def describeLoadBalancerAttributes(
        request: DescribeLoadBalancerAttributesRequest
      ): F[DescribeLoadBalancerAttributesResponse]

      def describeLoadBalancerPolicies(
        request: DescribeLoadBalancerPoliciesRequest
      ): F[DescribeLoadBalancerPoliciesResponse]

      def describeLoadBalancerPolicyTypes(
        request: DescribeLoadBalancerPolicyTypesRequest
      ): F[DescribeLoadBalancerPolicyTypesResponse]

      def describeLoadBalancers(
        request: DescribeLoadBalancersRequest
      ): F[DescribeLoadBalancersResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def detachLoadBalancerFromSubnets(
        request: DetachLoadBalancerFromSubnetsRequest
      ): F[DetachLoadBalancerFromSubnetsResponse]

      def disableAvailabilityZonesForLoadBalancer(
        request: DisableAvailabilityZonesForLoadBalancerRequest
      ): F[DisableAvailabilityZonesForLoadBalancerResponse]

      def enableAvailabilityZonesForLoadBalancer(
        request: EnableAvailabilityZonesForLoadBalancerRequest
      ): F[EnableAvailabilityZonesForLoadBalancerResponse]

      def modifyLoadBalancerAttributes(
        request: ModifyLoadBalancerAttributesRequest
      ): F[ModifyLoadBalancerAttributesResponse]

      def registerInstancesWithLoadBalancer(
        request: RegisterInstancesWithLoadBalancerRequest
      ): F[RegisterInstancesWithLoadBalancerResponse]

      def removeTags(
        request: RemoveTagsRequest
      ): F[RemoveTagsResponse]

      def setLoadBalancerListenerSSLCertificate(
        request: SetLoadBalancerListenerSslCertificateRequest
      ): F[SetLoadBalancerListenerSslCertificateResponse]

      def setLoadBalancerPoliciesForBackendServer(
        request: SetLoadBalancerPoliciesForBackendServerRequest
      ): F[SetLoadBalancerPoliciesForBackendServerResponse]

      def setLoadBalancerPoliciesOfListener(
        request: SetLoadBalancerPoliciesOfListenerRequest
      ): F[SetLoadBalancerPoliciesOfListenerResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ElasticLoadBalancingOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends ElasticLoadBalancingOp[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class ApplySecurityGroupsToLoadBalancerOp(
      request: ApplySecurityGroupsToLoadBalancerRequest
    ) extends ElasticLoadBalancingOp[ApplySecurityGroupsToLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplySecurityGroupsToLoadBalancerResponse] =
        visitor.applySecurityGroupsToLoadBalancer(request)
    }

    final case class AttachLoadBalancerToSubnetsOp(
      request: AttachLoadBalancerToSubnetsRequest
    ) extends ElasticLoadBalancingOp[AttachLoadBalancerToSubnetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachLoadBalancerToSubnetsResponse] =
        visitor.attachLoadBalancerToSubnets(request)
    }

    final case class ConfigureHealthCheckOp(
      request: ConfigureHealthCheckRequest
    ) extends ElasticLoadBalancingOp[ConfigureHealthCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfigureHealthCheckResponse] =
        visitor.configureHealthCheck(request)
    }

    final case class CreateAppCookieStickinessPolicyOp(
      request: CreateAppCookieStickinessPolicyRequest
    ) extends ElasticLoadBalancingOp[CreateAppCookieStickinessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppCookieStickinessPolicyResponse] =
        visitor.createAppCookieStickinessPolicy(request)
    }

    final case class CreateLBCookieStickinessPolicyOp(
      request: CreateLbCookieStickinessPolicyRequest
    ) extends ElasticLoadBalancingOp[CreateLbCookieStickinessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLbCookieStickinessPolicyResponse] =
        visitor.createLBCookieStickinessPolicy(request)
    }

    final case class CreateLoadBalancerOp(
      request: CreateLoadBalancerRequest
    ) extends ElasticLoadBalancingOp[CreateLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoadBalancerResponse] =
        visitor.createLoadBalancer(request)
    }

    final case class CreateLoadBalancerListenersOp(
      request: CreateLoadBalancerListenersRequest
    ) extends ElasticLoadBalancingOp[CreateLoadBalancerListenersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoadBalancerListenersResponse] =
        visitor.createLoadBalancerListeners(request)
    }

    final case class CreateLoadBalancerPolicyOp(
      request: CreateLoadBalancerPolicyRequest
    ) extends ElasticLoadBalancingOp[CreateLoadBalancerPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoadBalancerPolicyResponse] =
        visitor.createLoadBalancerPolicy(request)
    }

    final case class DeleteLoadBalancerOp(
      request: DeleteLoadBalancerRequest
    ) extends ElasticLoadBalancingOp[DeleteLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoadBalancerResponse] =
        visitor.deleteLoadBalancer(request)
    }

    final case class DeleteLoadBalancerListenersOp(
      request: DeleteLoadBalancerListenersRequest
    ) extends ElasticLoadBalancingOp[DeleteLoadBalancerListenersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoadBalancerListenersResponse] =
        visitor.deleteLoadBalancerListeners(request)
    }

    final case class DeleteLoadBalancerPolicyOp(
      request: DeleteLoadBalancerPolicyRequest
    ) extends ElasticLoadBalancingOp[DeleteLoadBalancerPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoadBalancerPolicyResponse] =
        visitor.deleteLoadBalancerPolicy(request)
    }

    final case class DeregisterInstancesFromLoadBalancerOp(
      request: DeregisterInstancesFromLoadBalancerRequest
    ) extends ElasticLoadBalancingOp[DeregisterInstancesFromLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterInstancesFromLoadBalancerResponse] =
        visitor.deregisterInstancesFromLoadBalancer(request)
    }

    final case class DescribeAccountLimitsOp(
      request: DescribeAccountLimitsRequest
    ) extends ElasticLoadBalancingOp[DescribeAccountLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountLimitsResponse] =
        visitor.describeAccountLimits(request)
    }

    final case class DescribeInstanceHealthOp(
      request: DescribeInstanceHealthRequest
    ) extends ElasticLoadBalancingOp[DescribeInstanceHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceHealthResponse] =
        visitor.describeInstanceHealth(request)
    }

    final case class DescribeLoadBalancerAttributesOp(
      request: DescribeLoadBalancerAttributesRequest
    ) extends ElasticLoadBalancingOp[DescribeLoadBalancerAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancerAttributesResponse] =
        visitor.describeLoadBalancerAttributes(request)
    }

    final case class DescribeLoadBalancerPoliciesOp(
      request: DescribeLoadBalancerPoliciesRequest
    ) extends ElasticLoadBalancingOp[DescribeLoadBalancerPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancerPoliciesResponse] =
        visitor.describeLoadBalancerPolicies(request)
    }

    final case class DescribeLoadBalancerPolicyTypesOp(
      request: DescribeLoadBalancerPolicyTypesRequest
    ) extends ElasticLoadBalancingOp[DescribeLoadBalancerPolicyTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancerPolicyTypesResponse] =
        visitor.describeLoadBalancerPolicyTypes(request)
    }

    final case class DescribeLoadBalancersOp(
      request: DescribeLoadBalancersRequest
    ) extends ElasticLoadBalancingOp[DescribeLoadBalancersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoadBalancersResponse] =
        visitor.describeLoadBalancers(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends ElasticLoadBalancingOp[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DetachLoadBalancerFromSubnetsOp(
      request: DetachLoadBalancerFromSubnetsRequest
    ) extends ElasticLoadBalancingOp[DetachLoadBalancerFromSubnetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachLoadBalancerFromSubnetsResponse] =
        visitor.detachLoadBalancerFromSubnets(request)
    }

    final case class DisableAvailabilityZonesForLoadBalancerOp(
      request: DisableAvailabilityZonesForLoadBalancerRequest
    ) extends ElasticLoadBalancingOp[DisableAvailabilityZonesForLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableAvailabilityZonesForLoadBalancerResponse] =
        visitor.disableAvailabilityZonesForLoadBalancer(request)
    }

    final case class EnableAvailabilityZonesForLoadBalancerOp(
      request: EnableAvailabilityZonesForLoadBalancerRequest
    ) extends ElasticLoadBalancingOp[EnableAvailabilityZonesForLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableAvailabilityZonesForLoadBalancerResponse] =
        visitor.enableAvailabilityZonesForLoadBalancer(request)
    }

    final case class ModifyLoadBalancerAttributesOp(
      request: ModifyLoadBalancerAttributesRequest
    ) extends ElasticLoadBalancingOp[ModifyLoadBalancerAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyLoadBalancerAttributesResponse] =
        visitor.modifyLoadBalancerAttributes(request)
    }

    final case class RegisterInstancesWithLoadBalancerOp(
      request: RegisterInstancesWithLoadBalancerRequest
    ) extends ElasticLoadBalancingOp[RegisterInstancesWithLoadBalancerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterInstancesWithLoadBalancerResponse] =
        visitor.registerInstancesWithLoadBalancer(request)
    }

    final case class RemoveTagsOp(
      request: RemoveTagsRequest
    ) extends ElasticLoadBalancingOp[RemoveTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsResponse] =
        visitor.removeTags(request)
    }

    final case class SetLoadBalancerListenerSSLCertificateOp(
      request: SetLoadBalancerListenerSslCertificateRequest
    ) extends ElasticLoadBalancingOp[SetLoadBalancerListenerSslCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetLoadBalancerListenerSslCertificateResponse] =
        visitor.setLoadBalancerListenerSSLCertificate(request)
    }

    final case class SetLoadBalancerPoliciesForBackendServerOp(
      request: SetLoadBalancerPoliciesForBackendServerRequest
    ) extends ElasticLoadBalancingOp[SetLoadBalancerPoliciesForBackendServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetLoadBalancerPoliciesForBackendServerResponse] =
        visitor.setLoadBalancerPoliciesForBackendServer(request)
    }

    final case class SetLoadBalancerPoliciesOfListenerOp(
      request: SetLoadBalancerPoliciesOfListenerRequest
    ) extends ElasticLoadBalancingOp[SetLoadBalancerPoliciesOfListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetLoadBalancerPoliciesOfListenerResponse] =
        visitor.setLoadBalancerPoliciesOfListener(request)
    }
  }

  import ElasticLoadBalancingOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ElasticLoadBalancingOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTags(
    request: AddTagsRequest
  ): ElasticLoadBalancingIO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def applySecurityGroupsToLoadBalancer(
    request: ApplySecurityGroupsToLoadBalancerRequest
  ): ElasticLoadBalancingIO[ApplySecurityGroupsToLoadBalancerResponse] =
    FF.liftF(ApplySecurityGroupsToLoadBalancerOp(request))

  def attachLoadBalancerToSubnets(
    request: AttachLoadBalancerToSubnetsRequest
  ): ElasticLoadBalancingIO[AttachLoadBalancerToSubnetsResponse] =
    FF.liftF(AttachLoadBalancerToSubnetsOp(request))

  def configureHealthCheck(
    request: ConfigureHealthCheckRequest
  ): ElasticLoadBalancingIO[ConfigureHealthCheckResponse] =
    FF.liftF(ConfigureHealthCheckOp(request))

  def createAppCookieStickinessPolicy(
    request: CreateAppCookieStickinessPolicyRequest
  ): ElasticLoadBalancingIO[CreateAppCookieStickinessPolicyResponse] =
    FF.liftF(CreateAppCookieStickinessPolicyOp(request))

  def createLBCookieStickinessPolicy(
    request: CreateLbCookieStickinessPolicyRequest
  ): ElasticLoadBalancingIO[CreateLbCookieStickinessPolicyResponse] =
    FF.liftF(CreateLBCookieStickinessPolicyOp(request))

  def createLoadBalancer(
    request: CreateLoadBalancerRequest
  ): ElasticLoadBalancingIO[CreateLoadBalancerResponse] =
    FF.liftF(CreateLoadBalancerOp(request))

  def createLoadBalancerListeners(
    request: CreateLoadBalancerListenersRequest
  ): ElasticLoadBalancingIO[CreateLoadBalancerListenersResponse] =
    FF.liftF(CreateLoadBalancerListenersOp(request))

  def createLoadBalancerPolicy(
    request: CreateLoadBalancerPolicyRequest
  ): ElasticLoadBalancingIO[CreateLoadBalancerPolicyResponse] =
    FF.liftF(CreateLoadBalancerPolicyOp(request))

  def deleteLoadBalancer(
    request: DeleteLoadBalancerRequest
  ): ElasticLoadBalancingIO[DeleteLoadBalancerResponse] =
    FF.liftF(DeleteLoadBalancerOp(request))

  def deleteLoadBalancerListeners(
    request: DeleteLoadBalancerListenersRequest
  ): ElasticLoadBalancingIO[DeleteLoadBalancerListenersResponse] =
    FF.liftF(DeleteLoadBalancerListenersOp(request))

  def deleteLoadBalancerPolicy(
    request: DeleteLoadBalancerPolicyRequest
  ): ElasticLoadBalancingIO[DeleteLoadBalancerPolicyResponse] =
    FF.liftF(DeleteLoadBalancerPolicyOp(request))

  def deregisterInstancesFromLoadBalancer(
    request: DeregisterInstancesFromLoadBalancerRequest
  ): ElasticLoadBalancingIO[DeregisterInstancesFromLoadBalancerResponse] =
    FF.liftF(DeregisterInstancesFromLoadBalancerOp(request))

  def describeAccountLimits(
    request: DescribeAccountLimitsRequest
  ): ElasticLoadBalancingIO[DescribeAccountLimitsResponse] =
    FF.liftF(DescribeAccountLimitsOp(request))

  def describeInstanceHealth(
    request: DescribeInstanceHealthRequest
  ): ElasticLoadBalancingIO[DescribeInstanceHealthResponse] =
    FF.liftF(DescribeInstanceHealthOp(request))

  def describeLoadBalancerAttributes(
    request: DescribeLoadBalancerAttributesRequest
  ): ElasticLoadBalancingIO[DescribeLoadBalancerAttributesResponse] =
    FF.liftF(DescribeLoadBalancerAttributesOp(request))

  def describeLoadBalancerPolicies(
    request: DescribeLoadBalancerPoliciesRequest
  ): ElasticLoadBalancingIO[DescribeLoadBalancerPoliciesResponse] =
    FF.liftF(DescribeLoadBalancerPoliciesOp(request))

  def describeLoadBalancerPolicyTypes(
    request: DescribeLoadBalancerPolicyTypesRequest
  ): ElasticLoadBalancingIO[DescribeLoadBalancerPolicyTypesResponse] =
    FF.liftF(DescribeLoadBalancerPolicyTypesOp(request))

  def describeLoadBalancers(
    request: DescribeLoadBalancersRequest
  ): ElasticLoadBalancingIO[DescribeLoadBalancersResponse] =
    FF.liftF(DescribeLoadBalancersOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): ElasticLoadBalancingIO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def detachLoadBalancerFromSubnets(
    request: DetachLoadBalancerFromSubnetsRequest
  ): ElasticLoadBalancingIO[DetachLoadBalancerFromSubnetsResponse] =
    FF.liftF(DetachLoadBalancerFromSubnetsOp(request))

  def disableAvailabilityZonesForLoadBalancer(
    request: DisableAvailabilityZonesForLoadBalancerRequest
  ): ElasticLoadBalancingIO[DisableAvailabilityZonesForLoadBalancerResponse] =
    FF.liftF(DisableAvailabilityZonesForLoadBalancerOp(request))

  def enableAvailabilityZonesForLoadBalancer(
    request: EnableAvailabilityZonesForLoadBalancerRequest
  ): ElasticLoadBalancingIO[EnableAvailabilityZonesForLoadBalancerResponse] =
    FF.liftF(EnableAvailabilityZonesForLoadBalancerOp(request))

  def modifyLoadBalancerAttributes(
    request: ModifyLoadBalancerAttributesRequest
  ): ElasticLoadBalancingIO[ModifyLoadBalancerAttributesResponse] =
    FF.liftF(ModifyLoadBalancerAttributesOp(request))

  def registerInstancesWithLoadBalancer(
    request: RegisterInstancesWithLoadBalancerRequest
  ): ElasticLoadBalancingIO[RegisterInstancesWithLoadBalancerResponse] =
    FF.liftF(RegisterInstancesWithLoadBalancerOp(request))

  def removeTags(
    request: RemoveTagsRequest
  ): ElasticLoadBalancingIO[RemoveTagsResponse] =
    FF.liftF(RemoveTagsOp(request))

  def setLoadBalancerListenerSSLCertificate(
    request: SetLoadBalancerListenerSslCertificateRequest
  ): ElasticLoadBalancingIO[SetLoadBalancerListenerSslCertificateResponse] =
    FF.liftF(SetLoadBalancerListenerSSLCertificateOp(request))

  def setLoadBalancerPoliciesForBackendServer(
    request: SetLoadBalancerPoliciesForBackendServerRequest
  ): ElasticLoadBalancingIO[SetLoadBalancerPoliciesForBackendServerResponse] =
    FF.liftF(SetLoadBalancerPoliciesForBackendServerOp(request))

  def setLoadBalancerPoliciesOfListener(
    request: SetLoadBalancerPoliciesOfListenerRequest
  ): ElasticLoadBalancingIO[SetLoadBalancerPoliciesOfListenerResponse] =
    FF.liftF(SetLoadBalancerPoliciesOfListenerOp(request))
}
