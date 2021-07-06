package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.route53.Route53Client
import software.amazon.awssdk.services.route53.model._


object route53 { module =>

  // Free monad over Route53Op
  type Route53IO[A] = FF[Route53Op, A]

  sealed trait Route53Op[A] {
    def visit[F[_]](visitor: Route53Op.Visitor[F]): F[A]
  }

  object Route53Op {
    // Given a Route53Client we can embed a Route53IO program in any algebra that understands embedding.
    implicit val Route53OpEmbeddable: Embeddable[Route53Op, Route53Client] = new Embeddable[Route53Op, Route53Client] {
      def embed[A](client: Route53Client, io: Route53IO[A]): Embedded[A] = Embedded.Route53(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Route53Op.Visitor[Kleisli[M, Route53Client, *]] {
        def activateKeySigningKey(
          request: ActivateKeySigningKeyRequest
        ): Kleisli[M, Route53Client, ActivateKeySigningKeyResponse] =
          primitive(_.activateKeySigningKey(request))

        def associateVPCWithHostedZone(
          request: AssociateVpcWithHostedZoneRequest
        ): Kleisli[M, Route53Client, AssociateVpcWithHostedZoneResponse] =
          primitive(_.associateVPCWithHostedZone(request))

        def changeResourceRecordSets(
          request: ChangeResourceRecordSetsRequest
        ): Kleisli[M, Route53Client, ChangeResourceRecordSetsResponse] =
          primitive(_.changeResourceRecordSets(request))

        def changeTagsForResource(
          request: ChangeTagsForResourceRequest
        ): Kleisli[M, Route53Client, ChangeTagsForResourceResponse] =
          primitive(_.changeTagsForResource(request))

        def createHealthCheck(
          request: CreateHealthCheckRequest
        ): Kleisli[M, Route53Client, CreateHealthCheckResponse] =
          primitive(_.createHealthCheck(request))

        def createHostedZone(
          request: CreateHostedZoneRequest
        ): Kleisli[M, Route53Client, CreateHostedZoneResponse] =
          primitive(_.createHostedZone(request))

        def createKeySigningKey(
          request: CreateKeySigningKeyRequest
        ): Kleisli[M, Route53Client, CreateKeySigningKeyResponse] =
          primitive(_.createKeySigningKey(request))

        def createQueryLoggingConfig(
          request: CreateQueryLoggingConfigRequest
        ): Kleisli[M, Route53Client, CreateQueryLoggingConfigResponse] =
          primitive(_.createQueryLoggingConfig(request))

        def createReusableDelegationSet(
          request: CreateReusableDelegationSetRequest
        ): Kleisli[M, Route53Client, CreateReusableDelegationSetResponse] =
          primitive(_.createReusableDelegationSet(request))

        def createTrafficPolicy(
          request: CreateTrafficPolicyRequest
        ): Kleisli[M, Route53Client, CreateTrafficPolicyResponse] =
          primitive(_.createTrafficPolicy(request))

        def createTrafficPolicyInstance(
          request: CreateTrafficPolicyInstanceRequest
        ): Kleisli[M, Route53Client, CreateTrafficPolicyInstanceResponse] =
          primitive(_.createTrafficPolicyInstance(request))

        def createTrafficPolicyVersion(
          request: CreateTrafficPolicyVersionRequest
        ): Kleisli[M, Route53Client, CreateTrafficPolicyVersionResponse] =
          primitive(_.createTrafficPolicyVersion(request))

        def createVPCAssociationAuthorization(
          request: CreateVpcAssociationAuthorizationRequest
        ): Kleisli[M, Route53Client, CreateVpcAssociationAuthorizationResponse] =
          primitive(_.createVPCAssociationAuthorization(request))

        def deactivateKeySigningKey(
          request: DeactivateKeySigningKeyRequest
        ): Kleisli[M, Route53Client, DeactivateKeySigningKeyResponse] =
          primitive(_.deactivateKeySigningKey(request))

        def deleteHealthCheck(
          request: DeleteHealthCheckRequest
        ): Kleisli[M, Route53Client, DeleteHealthCheckResponse] =
          primitive(_.deleteHealthCheck(request))

        def deleteHostedZone(
          request: DeleteHostedZoneRequest
        ): Kleisli[M, Route53Client, DeleteHostedZoneResponse] =
          primitive(_.deleteHostedZone(request))

        def deleteKeySigningKey(
          request: DeleteKeySigningKeyRequest
        ): Kleisli[M, Route53Client, DeleteKeySigningKeyResponse] =
          primitive(_.deleteKeySigningKey(request))

        def deleteQueryLoggingConfig(
          request: DeleteQueryLoggingConfigRequest
        ): Kleisli[M, Route53Client, DeleteQueryLoggingConfigResponse] =
          primitive(_.deleteQueryLoggingConfig(request))

        def deleteReusableDelegationSet(
          request: DeleteReusableDelegationSetRequest
        ): Kleisli[M, Route53Client, DeleteReusableDelegationSetResponse] =
          primitive(_.deleteReusableDelegationSet(request))

        def deleteTrafficPolicy(
          request: DeleteTrafficPolicyRequest
        ): Kleisli[M, Route53Client, DeleteTrafficPolicyResponse] =
          primitive(_.deleteTrafficPolicy(request))

        def deleteTrafficPolicyInstance(
          request: DeleteTrafficPolicyInstanceRequest
        ): Kleisli[M, Route53Client, DeleteTrafficPolicyInstanceResponse] =
          primitive(_.deleteTrafficPolicyInstance(request))

        def deleteVPCAssociationAuthorization(
          request: DeleteVpcAssociationAuthorizationRequest
        ): Kleisli[M, Route53Client, DeleteVpcAssociationAuthorizationResponse] =
          primitive(_.deleteVPCAssociationAuthorization(request))

        def disableHostedZoneDNSSEC(
          request: DisableHostedZoneDnssecRequest
        ): Kleisli[M, Route53Client, DisableHostedZoneDnssecResponse] =
          primitive(_.disableHostedZoneDNSSEC(request))

        def disassociateVPCFromHostedZone(
          request: DisassociateVpcFromHostedZoneRequest
        ): Kleisli[M, Route53Client, DisassociateVpcFromHostedZoneResponse] =
          primitive(_.disassociateVPCFromHostedZone(request))

        def enableHostedZoneDNSSEC(
          request: EnableHostedZoneDnssecRequest
        ): Kleisli[M, Route53Client, EnableHostedZoneDnssecResponse] =
          primitive(_.enableHostedZoneDNSSEC(request))

        def getAccountLimit(
          request: GetAccountLimitRequest
        ): Kleisli[M, Route53Client, GetAccountLimitResponse] =
          primitive(_.getAccountLimit(request))

        def getChange(
          request: GetChangeRequest
        ): Kleisli[M, Route53Client, GetChangeResponse] =
          primitive(_.getChange(request))

        def getCheckerIpRanges(
          request: GetCheckerIpRangesRequest
        ): Kleisli[M, Route53Client, GetCheckerIpRangesResponse] =
          primitive(_.getCheckerIpRanges(request))

        def getDNSSEC(
          request: GetDnssecRequest
        ): Kleisli[M, Route53Client, GetDnssecResponse] =
          primitive(_.getDNSSEC(request))

        def getGeoLocation(
          request: GetGeoLocationRequest
        ): Kleisli[M, Route53Client, GetGeoLocationResponse] =
          primitive(_.getGeoLocation(request))

        def getHealthCheck(
          request: GetHealthCheckRequest
        ): Kleisli[M, Route53Client, GetHealthCheckResponse] =
          primitive(_.getHealthCheck(request))

        def getHealthCheckCount(
          request: GetHealthCheckCountRequest
        ): Kleisli[M, Route53Client, GetHealthCheckCountResponse] =
          primitive(_.getHealthCheckCount(request))

        def getHealthCheckLastFailureReason(
          request: GetHealthCheckLastFailureReasonRequest
        ): Kleisli[M, Route53Client, GetHealthCheckLastFailureReasonResponse] =
          primitive(_.getHealthCheckLastFailureReason(request))

        def getHealthCheckStatus(
          request: GetHealthCheckStatusRequest
        ): Kleisli[M, Route53Client, GetHealthCheckStatusResponse] =
          primitive(_.getHealthCheckStatus(request))

        def getHostedZone(
          request: GetHostedZoneRequest
        ): Kleisli[M, Route53Client, GetHostedZoneResponse] =
          primitive(_.getHostedZone(request))

        def getHostedZoneCount(
          request: GetHostedZoneCountRequest
        ): Kleisli[M, Route53Client, GetHostedZoneCountResponse] =
          primitive(_.getHostedZoneCount(request))

        def getHostedZoneLimit(
          request: GetHostedZoneLimitRequest
        ): Kleisli[M, Route53Client, GetHostedZoneLimitResponse] =
          primitive(_.getHostedZoneLimit(request))

        def getQueryLoggingConfig(
          request: GetQueryLoggingConfigRequest
        ): Kleisli[M, Route53Client, GetQueryLoggingConfigResponse] =
          primitive(_.getQueryLoggingConfig(request))

        def getReusableDelegationSet(
          request: GetReusableDelegationSetRequest
        ): Kleisli[M, Route53Client, GetReusableDelegationSetResponse] =
          primitive(_.getReusableDelegationSet(request))

        def getReusableDelegationSetLimit(
          request: GetReusableDelegationSetLimitRequest
        ): Kleisli[M, Route53Client, GetReusableDelegationSetLimitResponse] =
          primitive(_.getReusableDelegationSetLimit(request))

        def getTrafficPolicy(
          request: GetTrafficPolicyRequest
        ): Kleisli[M, Route53Client, GetTrafficPolicyResponse] =
          primitive(_.getTrafficPolicy(request))

        def getTrafficPolicyInstance(
          request: GetTrafficPolicyInstanceRequest
        ): Kleisli[M, Route53Client, GetTrafficPolicyInstanceResponse] =
          primitive(_.getTrafficPolicyInstance(request))

        def getTrafficPolicyInstanceCount(
          request: GetTrafficPolicyInstanceCountRequest
        ): Kleisli[M, Route53Client, GetTrafficPolicyInstanceCountResponse] =
          primitive(_.getTrafficPolicyInstanceCount(request))

        def listGeoLocations(
          request: ListGeoLocationsRequest
        ): Kleisli[M, Route53Client, ListGeoLocationsResponse] =
          primitive(_.listGeoLocations(request))

        def listHealthChecks(
          request: ListHealthChecksRequest
        ): Kleisli[M, Route53Client, ListHealthChecksResponse] =
          primitive(_.listHealthChecks(request))

        def listHostedZones(
          request: ListHostedZonesRequest
        ): Kleisli[M, Route53Client, ListHostedZonesResponse] =
          primitive(_.listHostedZones(request))

        def listHostedZonesByName(
          request: ListHostedZonesByNameRequest
        ): Kleisli[M, Route53Client, ListHostedZonesByNameResponse] =
          primitive(_.listHostedZonesByName(request))

        def listHostedZonesByVPC(
          request: ListHostedZonesByVpcRequest
        ): Kleisli[M, Route53Client, ListHostedZonesByVpcResponse] =
          primitive(_.listHostedZonesByVPC(request))

        def listQueryLoggingConfigs(
          request: ListQueryLoggingConfigsRequest
        ): Kleisli[M, Route53Client, ListQueryLoggingConfigsResponse] =
          primitive(_.listQueryLoggingConfigs(request))

        def listResourceRecordSets(
          request: ListResourceRecordSetsRequest
        ): Kleisli[M, Route53Client, ListResourceRecordSetsResponse] =
          primitive(_.listResourceRecordSets(request))

        def listReusableDelegationSets(
          request: ListReusableDelegationSetsRequest
        ): Kleisli[M, Route53Client, ListReusableDelegationSetsResponse] =
          primitive(_.listReusableDelegationSets(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, Route53Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTagsForResources(
          request: ListTagsForResourcesRequest
        ): Kleisli[M, Route53Client, ListTagsForResourcesResponse] =
          primitive(_.listTagsForResources(request))

        def listTrafficPolicies(
          request: ListTrafficPoliciesRequest
        ): Kleisli[M, Route53Client, ListTrafficPoliciesResponse] =
          primitive(_.listTrafficPolicies(request))

        def listTrafficPolicyInstances(
          request: ListTrafficPolicyInstancesRequest
        ): Kleisli[M, Route53Client, ListTrafficPolicyInstancesResponse] =
          primitive(_.listTrafficPolicyInstances(request))

        def listTrafficPolicyInstancesByHostedZone(
          request: ListTrafficPolicyInstancesByHostedZoneRequest
        ): Kleisli[M, Route53Client, ListTrafficPolicyInstancesByHostedZoneResponse] =
          primitive(_.listTrafficPolicyInstancesByHostedZone(request))

        def listTrafficPolicyInstancesByPolicy(
          request: ListTrafficPolicyInstancesByPolicyRequest
        ): Kleisli[M, Route53Client, ListTrafficPolicyInstancesByPolicyResponse] =
          primitive(_.listTrafficPolicyInstancesByPolicy(request))

        def listTrafficPolicyVersions(
          request: ListTrafficPolicyVersionsRequest
        ): Kleisli[M, Route53Client, ListTrafficPolicyVersionsResponse] =
          primitive(_.listTrafficPolicyVersions(request))

        def listVPCAssociationAuthorizations(
          request: ListVpcAssociationAuthorizationsRequest
        ): Kleisli[M, Route53Client, ListVpcAssociationAuthorizationsResponse] =
          primitive(_.listVPCAssociationAuthorizations(request))

        def testDNSAnswer(
          request: TestDnsAnswerRequest
        ): Kleisli[M, Route53Client, TestDnsAnswerResponse] =
          primitive(_.testDNSAnswer(request))

        def updateHealthCheck(
          request: UpdateHealthCheckRequest
        ): Kleisli[M, Route53Client, UpdateHealthCheckResponse] =
          primitive(_.updateHealthCheck(request))

        def updateHostedZoneComment(
          request: UpdateHostedZoneCommentRequest
        ): Kleisli[M, Route53Client, UpdateHostedZoneCommentResponse] =
          primitive(_.updateHostedZoneComment(request))

        def updateTrafficPolicyComment(
          request: UpdateTrafficPolicyCommentRequest
        ): Kleisli[M, Route53Client, UpdateTrafficPolicyCommentResponse] =
          primitive(_.updateTrafficPolicyComment(request))

        def updateTrafficPolicyInstance(
          request: UpdateTrafficPolicyInstanceRequest
        ): Kleisli[M, Route53Client, UpdateTrafficPolicyInstanceResponse] =
          primitive(_.updateTrafficPolicyInstance(request))

        def primitive[A](
          f: Route53Client => A
        ): Kleisli[M, Route53Client, A]
      }
    }

    trait Visitor[F[_]] extends (Route53Op ~> F) {
      final def apply[A](op: Route53Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def activateKeySigningKey(
        request: ActivateKeySigningKeyRequest
      ): F[ActivateKeySigningKeyResponse]

      def associateVPCWithHostedZone(
        request: AssociateVpcWithHostedZoneRequest
      ): F[AssociateVpcWithHostedZoneResponse]

      def changeResourceRecordSets(
        request: ChangeResourceRecordSetsRequest
      ): F[ChangeResourceRecordSetsResponse]

      def changeTagsForResource(
        request: ChangeTagsForResourceRequest
      ): F[ChangeTagsForResourceResponse]

      def createHealthCheck(
        request: CreateHealthCheckRequest
      ): F[CreateHealthCheckResponse]

      def createHostedZone(
        request: CreateHostedZoneRequest
      ): F[CreateHostedZoneResponse]

      def createKeySigningKey(
        request: CreateKeySigningKeyRequest
      ): F[CreateKeySigningKeyResponse]

      def createQueryLoggingConfig(
        request: CreateQueryLoggingConfigRequest
      ): F[CreateQueryLoggingConfigResponse]

      def createReusableDelegationSet(
        request: CreateReusableDelegationSetRequest
      ): F[CreateReusableDelegationSetResponse]

      def createTrafficPolicy(
        request: CreateTrafficPolicyRequest
      ): F[CreateTrafficPolicyResponse]

      def createTrafficPolicyInstance(
        request: CreateTrafficPolicyInstanceRequest
      ): F[CreateTrafficPolicyInstanceResponse]

      def createTrafficPolicyVersion(
        request: CreateTrafficPolicyVersionRequest
      ): F[CreateTrafficPolicyVersionResponse]

      def createVPCAssociationAuthorization(
        request: CreateVpcAssociationAuthorizationRequest
      ): F[CreateVpcAssociationAuthorizationResponse]

      def deactivateKeySigningKey(
        request: DeactivateKeySigningKeyRequest
      ): F[DeactivateKeySigningKeyResponse]

      def deleteHealthCheck(
        request: DeleteHealthCheckRequest
      ): F[DeleteHealthCheckResponse]

      def deleteHostedZone(
        request: DeleteHostedZoneRequest
      ): F[DeleteHostedZoneResponse]

      def deleteKeySigningKey(
        request: DeleteKeySigningKeyRequest
      ): F[DeleteKeySigningKeyResponse]

      def deleteQueryLoggingConfig(
        request: DeleteQueryLoggingConfigRequest
      ): F[DeleteQueryLoggingConfigResponse]

      def deleteReusableDelegationSet(
        request: DeleteReusableDelegationSetRequest
      ): F[DeleteReusableDelegationSetResponse]

      def deleteTrafficPolicy(
        request: DeleteTrafficPolicyRequest
      ): F[DeleteTrafficPolicyResponse]

      def deleteTrafficPolicyInstance(
        request: DeleteTrafficPolicyInstanceRequest
      ): F[DeleteTrafficPolicyInstanceResponse]

      def deleteVPCAssociationAuthorization(
        request: DeleteVpcAssociationAuthorizationRequest
      ): F[DeleteVpcAssociationAuthorizationResponse]

      def disableHostedZoneDNSSEC(
        request: DisableHostedZoneDnssecRequest
      ): F[DisableHostedZoneDnssecResponse]

      def disassociateVPCFromHostedZone(
        request: DisassociateVpcFromHostedZoneRequest
      ): F[DisassociateVpcFromHostedZoneResponse]

      def enableHostedZoneDNSSEC(
        request: EnableHostedZoneDnssecRequest
      ): F[EnableHostedZoneDnssecResponse]

      def getAccountLimit(
        request: GetAccountLimitRequest
      ): F[GetAccountLimitResponse]

      def getChange(
        request: GetChangeRequest
      ): F[GetChangeResponse]

      def getCheckerIpRanges(
        request: GetCheckerIpRangesRequest
      ): F[GetCheckerIpRangesResponse]

      def getDNSSEC(
        request: GetDnssecRequest
      ): F[GetDnssecResponse]

      def getGeoLocation(
        request: GetGeoLocationRequest
      ): F[GetGeoLocationResponse]

      def getHealthCheck(
        request: GetHealthCheckRequest
      ): F[GetHealthCheckResponse]

      def getHealthCheckCount(
        request: GetHealthCheckCountRequest
      ): F[GetHealthCheckCountResponse]

      def getHealthCheckLastFailureReason(
        request: GetHealthCheckLastFailureReasonRequest
      ): F[GetHealthCheckLastFailureReasonResponse]

      def getHealthCheckStatus(
        request: GetHealthCheckStatusRequest
      ): F[GetHealthCheckStatusResponse]

      def getHostedZone(
        request: GetHostedZoneRequest
      ): F[GetHostedZoneResponse]

      def getHostedZoneCount(
        request: GetHostedZoneCountRequest
      ): F[GetHostedZoneCountResponse]

      def getHostedZoneLimit(
        request: GetHostedZoneLimitRequest
      ): F[GetHostedZoneLimitResponse]

      def getQueryLoggingConfig(
        request: GetQueryLoggingConfigRequest
      ): F[GetQueryLoggingConfigResponse]

      def getReusableDelegationSet(
        request: GetReusableDelegationSetRequest
      ): F[GetReusableDelegationSetResponse]

      def getReusableDelegationSetLimit(
        request: GetReusableDelegationSetLimitRequest
      ): F[GetReusableDelegationSetLimitResponse]

      def getTrafficPolicy(
        request: GetTrafficPolicyRequest
      ): F[GetTrafficPolicyResponse]

      def getTrafficPolicyInstance(
        request: GetTrafficPolicyInstanceRequest
      ): F[GetTrafficPolicyInstanceResponse]

      def getTrafficPolicyInstanceCount(
        request: GetTrafficPolicyInstanceCountRequest
      ): F[GetTrafficPolicyInstanceCountResponse]

      def listGeoLocations(
        request: ListGeoLocationsRequest
      ): F[ListGeoLocationsResponse]

      def listHealthChecks(
        request: ListHealthChecksRequest
      ): F[ListHealthChecksResponse]

      def listHostedZones(
        request: ListHostedZonesRequest
      ): F[ListHostedZonesResponse]

      def listHostedZonesByName(
        request: ListHostedZonesByNameRequest
      ): F[ListHostedZonesByNameResponse]

      def listHostedZonesByVPC(
        request: ListHostedZonesByVpcRequest
      ): F[ListHostedZonesByVpcResponse]

      def listQueryLoggingConfigs(
        request: ListQueryLoggingConfigsRequest
      ): F[ListQueryLoggingConfigsResponse]

      def listResourceRecordSets(
        request: ListResourceRecordSetsRequest
      ): F[ListResourceRecordSetsResponse]

      def listReusableDelegationSets(
        request: ListReusableDelegationSetsRequest
      ): F[ListReusableDelegationSetsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTagsForResources(
        request: ListTagsForResourcesRequest
      ): F[ListTagsForResourcesResponse]

      def listTrafficPolicies(
        request: ListTrafficPoliciesRequest
      ): F[ListTrafficPoliciesResponse]

      def listTrafficPolicyInstances(
        request: ListTrafficPolicyInstancesRequest
      ): F[ListTrafficPolicyInstancesResponse]

      def listTrafficPolicyInstancesByHostedZone(
        request: ListTrafficPolicyInstancesByHostedZoneRequest
      ): F[ListTrafficPolicyInstancesByHostedZoneResponse]

      def listTrafficPolicyInstancesByPolicy(
        request: ListTrafficPolicyInstancesByPolicyRequest
      ): F[ListTrafficPolicyInstancesByPolicyResponse]

      def listTrafficPolicyVersions(
        request: ListTrafficPolicyVersionsRequest
      ): F[ListTrafficPolicyVersionsResponse]

      def listVPCAssociationAuthorizations(
        request: ListVpcAssociationAuthorizationsRequest
      ): F[ListVpcAssociationAuthorizationsResponse]

      def testDNSAnswer(
        request: TestDnsAnswerRequest
      ): F[TestDnsAnswerResponse]

      def updateHealthCheck(
        request: UpdateHealthCheckRequest
      ): F[UpdateHealthCheckResponse]

      def updateHostedZoneComment(
        request: UpdateHostedZoneCommentRequest
      ): F[UpdateHostedZoneCommentResponse]

      def updateTrafficPolicyComment(
        request: UpdateTrafficPolicyCommentRequest
      ): F[UpdateTrafficPolicyCommentResponse]

      def updateTrafficPolicyInstance(
        request: UpdateTrafficPolicyInstanceRequest
      ): F[UpdateTrafficPolicyInstanceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Route53Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ActivateKeySigningKeyOp(
      request: ActivateKeySigningKeyRequest
    ) extends Route53Op[ActivateKeySigningKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ActivateKeySigningKeyResponse] =
        visitor.activateKeySigningKey(request)
    }

    final case class AssociateVPCWithHostedZoneOp(
      request: AssociateVpcWithHostedZoneRequest
    ) extends Route53Op[AssociateVpcWithHostedZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateVpcWithHostedZoneResponse] =
        visitor.associateVPCWithHostedZone(request)
    }

    final case class ChangeResourceRecordSetsOp(
      request: ChangeResourceRecordSetsRequest
    ) extends Route53Op[ChangeResourceRecordSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ChangeResourceRecordSetsResponse] =
        visitor.changeResourceRecordSets(request)
    }

    final case class ChangeTagsForResourceOp(
      request: ChangeTagsForResourceRequest
    ) extends Route53Op[ChangeTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ChangeTagsForResourceResponse] =
        visitor.changeTagsForResource(request)
    }

    final case class CreateHealthCheckOp(
      request: CreateHealthCheckRequest
    ) extends Route53Op[CreateHealthCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHealthCheckResponse] =
        visitor.createHealthCheck(request)
    }

    final case class CreateHostedZoneOp(
      request: CreateHostedZoneRequest
    ) extends Route53Op[CreateHostedZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHostedZoneResponse] =
        visitor.createHostedZone(request)
    }

    final case class CreateKeySigningKeyOp(
      request: CreateKeySigningKeyRequest
    ) extends Route53Op[CreateKeySigningKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateKeySigningKeyResponse] =
        visitor.createKeySigningKey(request)
    }

    final case class CreateQueryLoggingConfigOp(
      request: CreateQueryLoggingConfigRequest
    ) extends Route53Op[CreateQueryLoggingConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQueryLoggingConfigResponse] =
        visitor.createQueryLoggingConfig(request)
    }

    final case class CreateReusableDelegationSetOp(
      request: CreateReusableDelegationSetRequest
    ) extends Route53Op[CreateReusableDelegationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReusableDelegationSetResponse] =
        visitor.createReusableDelegationSet(request)
    }

    final case class CreateTrafficPolicyOp(
      request: CreateTrafficPolicyRequest
    ) extends Route53Op[CreateTrafficPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrafficPolicyResponse] =
        visitor.createTrafficPolicy(request)
    }

    final case class CreateTrafficPolicyInstanceOp(
      request: CreateTrafficPolicyInstanceRequest
    ) extends Route53Op[CreateTrafficPolicyInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrafficPolicyInstanceResponse] =
        visitor.createTrafficPolicyInstance(request)
    }

    final case class CreateTrafficPolicyVersionOp(
      request: CreateTrafficPolicyVersionRequest
    ) extends Route53Op[CreateTrafficPolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrafficPolicyVersionResponse] =
        visitor.createTrafficPolicyVersion(request)
    }

    final case class CreateVPCAssociationAuthorizationOp(
      request: CreateVpcAssociationAuthorizationRequest
    ) extends Route53Op[CreateVpcAssociationAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcAssociationAuthorizationResponse] =
        visitor.createVPCAssociationAuthorization(request)
    }

    final case class DeactivateKeySigningKeyOp(
      request: DeactivateKeySigningKeyRequest
    ) extends Route53Op[DeactivateKeySigningKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeactivateKeySigningKeyResponse] =
        visitor.deactivateKeySigningKey(request)
    }

    final case class DeleteHealthCheckOp(
      request: DeleteHealthCheckRequest
    ) extends Route53Op[DeleteHealthCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHealthCheckResponse] =
        visitor.deleteHealthCheck(request)
    }

    final case class DeleteHostedZoneOp(
      request: DeleteHostedZoneRequest
    ) extends Route53Op[DeleteHostedZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHostedZoneResponse] =
        visitor.deleteHostedZone(request)
    }

    final case class DeleteKeySigningKeyOp(
      request: DeleteKeySigningKeyRequest
    ) extends Route53Op[DeleteKeySigningKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteKeySigningKeyResponse] =
        visitor.deleteKeySigningKey(request)
    }

    final case class DeleteQueryLoggingConfigOp(
      request: DeleteQueryLoggingConfigRequest
    ) extends Route53Op[DeleteQueryLoggingConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQueryLoggingConfigResponse] =
        visitor.deleteQueryLoggingConfig(request)
    }

    final case class DeleteReusableDelegationSetOp(
      request: DeleteReusableDelegationSetRequest
    ) extends Route53Op[DeleteReusableDelegationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReusableDelegationSetResponse] =
        visitor.deleteReusableDelegationSet(request)
    }

    final case class DeleteTrafficPolicyOp(
      request: DeleteTrafficPolicyRequest
    ) extends Route53Op[DeleteTrafficPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrafficPolicyResponse] =
        visitor.deleteTrafficPolicy(request)
    }

    final case class DeleteTrafficPolicyInstanceOp(
      request: DeleteTrafficPolicyInstanceRequest
    ) extends Route53Op[DeleteTrafficPolicyInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrafficPolicyInstanceResponse] =
        visitor.deleteTrafficPolicyInstance(request)
    }

    final case class DeleteVPCAssociationAuthorizationOp(
      request: DeleteVpcAssociationAuthorizationRequest
    ) extends Route53Op[DeleteVpcAssociationAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcAssociationAuthorizationResponse] =
        visitor.deleteVPCAssociationAuthorization(request)
    }

    final case class DisableHostedZoneDNSSECOp(
      request: DisableHostedZoneDnssecRequest
    ) extends Route53Op[DisableHostedZoneDnssecResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableHostedZoneDnssecResponse] =
        visitor.disableHostedZoneDNSSEC(request)
    }

    final case class DisassociateVPCFromHostedZoneOp(
      request: DisassociateVpcFromHostedZoneRequest
    ) extends Route53Op[DisassociateVpcFromHostedZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateVpcFromHostedZoneResponse] =
        visitor.disassociateVPCFromHostedZone(request)
    }

    final case class EnableHostedZoneDNSSECOp(
      request: EnableHostedZoneDnssecRequest
    ) extends Route53Op[EnableHostedZoneDnssecResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableHostedZoneDnssecResponse] =
        visitor.enableHostedZoneDNSSEC(request)
    }

    final case class GetAccountLimitOp(
      request: GetAccountLimitRequest
    ) extends Route53Op[GetAccountLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountLimitResponse] =
        visitor.getAccountLimit(request)
    }

    final case class GetChangeOp(
      request: GetChangeRequest
    ) extends Route53Op[GetChangeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChangeResponse] =
        visitor.getChange(request)
    }

    final case class GetCheckerIpRangesOp(
      request: GetCheckerIpRangesRequest
    ) extends Route53Op[GetCheckerIpRangesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCheckerIpRangesResponse] =
        visitor.getCheckerIpRanges(request)
    }

    final case class GetDNSSECOp(
      request: GetDnssecRequest
    ) extends Route53Op[GetDnssecResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDnssecResponse] =
        visitor.getDNSSEC(request)
    }

    final case class GetGeoLocationOp(
      request: GetGeoLocationRequest
    ) extends Route53Op[GetGeoLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGeoLocationResponse] =
        visitor.getGeoLocation(request)
    }

    final case class GetHealthCheckOp(
      request: GetHealthCheckRequest
    ) extends Route53Op[GetHealthCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHealthCheckResponse] =
        visitor.getHealthCheck(request)
    }

    final case class GetHealthCheckCountOp(
      request: GetHealthCheckCountRequest
    ) extends Route53Op[GetHealthCheckCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHealthCheckCountResponse] =
        visitor.getHealthCheckCount(request)
    }

    final case class GetHealthCheckLastFailureReasonOp(
      request: GetHealthCheckLastFailureReasonRequest
    ) extends Route53Op[GetHealthCheckLastFailureReasonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHealthCheckLastFailureReasonResponse] =
        visitor.getHealthCheckLastFailureReason(request)
    }

    final case class GetHealthCheckStatusOp(
      request: GetHealthCheckStatusRequest
    ) extends Route53Op[GetHealthCheckStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHealthCheckStatusResponse] =
        visitor.getHealthCheckStatus(request)
    }

    final case class GetHostedZoneOp(
      request: GetHostedZoneRequest
    ) extends Route53Op[GetHostedZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHostedZoneResponse] =
        visitor.getHostedZone(request)
    }

    final case class GetHostedZoneCountOp(
      request: GetHostedZoneCountRequest
    ) extends Route53Op[GetHostedZoneCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHostedZoneCountResponse] =
        visitor.getHostedZoneCount(request)
    }

    final case class GetHostedZoneLimitOp(
      request: GetHostedZoneLimitRequest
    ) extends Route53Op[GetHostedZoneLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHostedZoneLimitResponse] =
        visitor.getHostedZoneLimit(request)
    }

    final case class GetQueryLoggingConfigOp(
      request: GetQueryLoggingConfigRequest
    ) extends Route53Op[GetQueryLoggingConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQueryLoggingConfigResponse] =
        visitor.getQueryLoggingConfig(request)
    }

    final case class GetReusableDelegationSetOp(
      request: GetReusableDelegationSetRequest
    ) extends Route53Op[GetReusableDelegationSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReusableDelegationSetResponse] =
        visitor.getReusableDelegationSet(request)
    }

    final case class GetReusableDelegationSetLimitOp(
      request: GetReusableDelegationSetLimitRequest
    ) extends Route53Op[GetReusableDelegationSetLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReusableDelegationSetLimitResponse] =
        visitor.getReusableDelegationSetLimit(request)
    }

    final case class GetTrafficPolicyOp(
      request: GetTrafficPolicyRequest
    ) extends Route53Op[GetTrafficPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTrafficPolicyResponse] =
        visitor.getTrafficPolicy(request)
    }

    final case class GetTrafficPolicyInstanceOp(
      request: GetTrafficPolicyInstanceRequest
    ) extends Route53Op[GetTrafficPolicyInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTrafficPolicyInstanceResponse] =
        visitor.getTrafficPolicyInstance(request)
    }

    final case class GetTrafficPolicyInstanceCountOp(
      request: GetTrafficPolicyInstanceCountRequest
    ) extends Route53Op[GetTrafficPolicyInstanceCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTrafficPolicyInstanceCountResponse] =
        visitor.getTrafficPolicyInstanceCount(request)
    }

    final case class ListGeoLocationsOp(
      request: ListGeoLocationsRequest
    ) extends Route53Op[ListGeoLocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGeoLocationsResponse] =
        visitor.listGeoLocations(request)
    }

    final case class ListHealthChecksOp(
      request: ListHealthChecksRequest
    ) extends Route53Op[ListHealthChecksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHealthChecksResponse] =
        visitor.listHealthChecks(request)
    }

    final case class ListHostedZonesOp(
      request: ListHostedZonesRequest
    ) extends Route53Op[ListHostedZonesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHostedZonesResponse] =
        visitor.listHostedZones(request)
    }

    final case class ListHostedZonesByNameOp(
      request: ListHostedZonesByNameRequest
    ) extends Route53Op[ListHostedZonesByNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHostedZonesByNameResponse] =
        visitor.listHostedZonesByName(request)
    }

    final case class ListHostedZonesByVPCOp(
      request: ListHostedZonesByVpcRequest
    ) extends Route53Op[ListHostedZonesByVpcResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHostedZonesByVpcResponse] =
        visitor.listHostedZonesByVPC(request)
    }

    final case class ListQueryLoggingConfigsOp(
      request: ListQueryLoggingConfigsRequest
    ) extends Route53Op[ListQueryLoggingConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQueryLoggingConfigsResponse] =
        visitor.listQueryLoggingConfigs(request)
    }

    final case class ListResourceRecordSetsOp(
      request: ListResourceRecordSetsRequest
    ) extends Route53Op[ListResourceRecordSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceRecordSetsResponse] =
        visitor.listResourceRecordSets(request)
    }

    final case class ListReusableDelegationSetsOp(
      request: ListReusableDelegationSetsRequest
    ) extends Route53Op[ListReusableDelegationSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReusableDelegationSetsResponse] =
        visitor.listReusableDelegationSets(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends Route53Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTagsForResourcesOp(
      request: ListTagsForResourcesRequest
    ) extends Route53Op[ListTagsForResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourcesResponse] =
        visitor.listTagsForResources(request)
    }

    final case class ListTrafficPoliciesOp(
      request: ListTrafficPoliciesRequest
    ) extends Route53Op[ListTrafficPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrafficPoliciesResponse] =
        visitor.listTrafficPolicies(request)
    }

    final case class ListTrafficPolicyInstancesOp(
      request: ListTrafficPolicyInstancesRequest
    ) extends Route53Op[ListTrafficPolicyInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrafficPolicyInstancesResponse] =
        visitor.listTrafficPolicyInstances(request)
    }

    final case class ListTrafficPolicyInstancesByHostedZoneOp(
      request: ListTrafficPolicyInstancesByHostedZoneRequest
    ) extends Route53Op[ListTrafficPolicyInstancesByHostedZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrafficPolicyInstancesByHostedZoneResponse] =
        visitor.listTrafficPolicyInstancesByHostedZone(request)
    }

    final case class ListTrafficPolicyInstancesByPolicyOp(
      request: ListTrafficPolicyInstancesByPolicyRequest
    ) extends Route53Op[ListTrafficPolicyInstancesByPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrafficPolicyInstancesByPolicyResponse] =
        visitor.listTrafficPolicyInstancesByPolicy(request)
    }

    final case class ListTrafficPolicyVersionsOp(
      request: ListTrafficPolicyVersionsRequest
    ) extends Route53Op[ListTrafficPolicyVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrafficPolicyVersionsResponse] =
        visitor.listTrafficPolicyVersions(request)
    }

    final case class ListVPCAssociationAuthorizationsOp(
      request: ListVpcAssociationAuthorizationsRequest
    ) extends Route53Op[ListVpcAssociationAuthorizationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVpcAssociationAuthorizationsResponse] =
        visitor.listVPCAssociationAuthorizations(request)
    }

    final case class TestDNSAnswerOp(
      request: TestDnsAnswerRequest
    ) extends Route53Op[TestDnsAnswerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestDnsAnswerResponse] =
        visitor.testDNSAnswer(request)
    }

    final case class UpdateHealthCheckOp(
      request: UpdateHealthCheckRequest
    ) extends Route53Op[UpdateHealthCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateHealthCheckResponse] =
        visitor.updateHealthCheck(request)
    }

    final case class UpdateHostedZoneCommentOp(
      request: UpdateHostedZoneCommentRequest
    ) extends Route53Op[UpdateHostedZoneCommentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateHostedZoneCommentResponse] =
        visitor.updateHostedZoneComment(request)
    }

    final case class UpdateTrafficPolicyCommentOp(
      request: UpdateTrafficPolicyCommentRequest
    ) extends Route53Op[UpdateTrafficPolicyCommentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTrafficPolicyCommentResponse] =
        visitor.updateTrafficPolicyComment(request)
    }

    final case class UpdateTrafficPolicyInstanceOp(
      request: UpdateTrafficPolicyInstanceRequest
    ) extends Route53Op[UpdateTrafficPolicyInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTrafficPolicyInstanceResponse] =
        visitor.updateTrafficPolicyInstance(request)
    }
  }

  import Route53Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Route53Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def activateKeySigningKey(
    request: ActivateKeySigningKeyRequest
  ): Route53IO[ActivateKeySigningKeyResponse] =
    FF.liftF(ActivateKeySigningKeyOp(request))

  def associateVPCWithHostedZone(
    request: AssociateVpcWithHostedZoneRequest
  ): Route53IO[AssociateVpcWithHostedZoneResponse] =
    FF.liftF(AssociateVPCWithHostedZoneOp(request))

  def changeResourceRecordSets(
    request: ChangeResourceRecordSetsRequest
  ): Route53IO[ChangeResourceRecordSetsResponse] =
    FF.liftF(ChangeResourceRecordSetsOp(request))

  def changeTagsForResource(
    request: ChangeTagsForResourceRequest
  ): Route53IO[ChangeTagsForResourceResponse] =
    FF.liftF(ChangeTagsForResourceOp(request))

  def createHealthCheck(
    request: CreateHealthCheckRequest
  ): Route53IO[CreateHealthCheckResponse] =
    FF.liftF(CreateHealthCheckOp(request))

  def createHostedZone(
    request: CreateHostedZoneRequest
  ): Route53IO[CreateHostedZoneResponse] =
    FF.liftF(CreateHostedZoneOp(request))

  def createKeySigningKey(
    request: CreateKeySigningKeyRequest
  ): Route53IO[CreateKeySigningKeyResponse] =
    FF.liftF(CreateKeySigningKeyOp(request))

  def createQueryLoggingConfig(
    request: CreateQueryLoggingConfigRequest
  ): Route53IO[CreateQueryLoggingConfigResponse] =
    FF.liftF(CreateQueryLoggingConfigOp(request))

  def createReusableDelegationSet(
    request: CreateReusableDelegationSetRequest
  ): Route53IO[CreateReusableDelegationSetResponse] =
    FF.liftF(CreateReusableDelegationSetOp(request))

  def createTrafficPolicy(
    request: CreateTrafficPolicyRequest
  ): Route53IO[CreateTrafficPolicyResponse] =
    FF.liftF(CreateTrafficPolicyOp(request))

  def createTrafficPolicyInstance(
    request: CreateTrafficPolicyInstanceRequest
  ): Route53IO[CreateTrafficPolicyInstanceResponse] =
    FF.liftF(CreateTrafficPolicyInstanceOp(request))

  def createTrafficPolicyVersion(
    request: CreateTrafficPolicyVersionRequest
  ): Route53IO[CreateTrafficPolicyVersionResponse] =
    FF.liftF(CreateTrafficPolicyVersionOp(request))

  def createVPCAssociationAuthorization(
    request: CreateVpcAssociationAuthorizationRequest
  ): Route53IO[CreateVpcAssociationAuthorizationResponse] =
    FF.liftF(CreateVPCAssociationAuthorizationOp(request))

  def deactivateKeySigningKey(
    request: DeactivateKeySigningKeyRequest
  ): Route53IO[DeactivateKeySigningKeyResponse] =
    FF.liftF(DeactivateKeySigningKeyOp(request))

  def deleteHealthCheck(
    request: DeleteHealthCheckRequest
  ): Route53IO[DeleteHealthCheckResponse] =
    FF.liftF(DeleteHealthCheckOp(request))

  def deleteHostedZone(
    request: DeleteHostedZoneRequest
  ): Route53IO[DeleteHostedZoneResponse] =
    FF.liftF(DeleteHostedZoneOp(request))

  def deleteKeySigningKey(
    request: DeleteKeySigningKeyRequest
  ): Route53IO[DeleteKeySigningKeyResponse] =
    FF.liftF(DeleteKeySigningKeyOp(request))

  def deleteQueryLoggingConfig(
    request: DeleteQueryLoggingConfigRequest
  ): Route53IO[DeleteQueryLoggingConfigResponse] =
    FF.liftF(DeleteQueryLoggingConfigOp(request))

  def deleteReusableDelegationSet(
    request: DeleteReusableDelegationSetRequest
  ): Route53IO[DeleteReusableDelegationSetResponse] =
    FF.liftF(DeleteReusableDelegationSetOp(request))

  def deleteTrafficPolicy(
    request: DeleteTrafficPolicyRequest
  ): Route53IO[DeleteTrafficPolicyResponse] =
    FF.liftF(DeleteTrafficPolicyOp(request))

  def deleteTrafficPolicyInstance(
    request: DeleteTrafficPolicyInstanceRequest
  ): Route53IO[DeleteTrafficPolicyInstanceResponse] =
    FF.liftF(DeleteTrafficPolicyInstanceOp(request))

  def deleteVPCAssociationAuthorization(
    request: DeleteVpcAssociationAuthorizationRequest
  ): Route53IO[DeleteVpcAssociationAuthorizationResponse] =
    FF.liftF(DeleteVPCAssociationAuthorizationOp(request))

  def disableHostedZoneDNSSEC(
    request: DisableHostedZoneDnssecRequest
  ): Route53IO[DisableHostedZoneDnssecResponse] =
    FF.liftF(DisableHostedZoneDNSSECOp(request))

  def disassociateVPCFromHostedZone(
    request: DisassociateVpcFromHostedZoneRequest
  ): Route53IO[DisassociateVpcFromHostedZoneResponse] =
    FF.liftF(DisassociateVPCFromHostedZoneOp(request))

  def enableHostedZoneDNSSEC(
    request: EnableHostedZoneDnssecRequest
  ): Route53IO[EnableHostedZoneDnssecResponse] =
    FF.liftF(EnableHostedZoneDNSSECOp(request))

  def getAccountLimit(
    request: GetAccountLimitRequest
  ): Route53IO[GetAccountLimitResponse] =
    FF.liftF(GetAccountLimitOp(request))

  def getChange(
    request: GetChangeRequest
  ): Route53IO[GetChangeResponse] =
    FF.liftF(GetChangeOp(request))

  def getCheckerIpRanges(
    request: GetCheckerIpRangesRequest
  ): Route53IO[GetCheckerIpRangesResponse] =
    FF.liftF(GetCheckerIpRangesOp(request))

  def getDNSSEC(
    request: GetDnssecRequest
  ): Route53IO[GetDnssecResponse] =
    FF.liftF(GetDNSSECOp(request))

  def getGeoLocation(
    request: GetGeoLocationRequest
  ): Route53IO[GetGeoLocationResponse] =
    FF.liftF(GetGeoLocationOp(request))

  def getHealthCheck(
    request: GetHealthCheckRequest
  ): Route53IO[GetHealthCheckResponse] =
    FF.liftF(GetHealthCheckOp(request))

  def getHealthCheckCount(
    request: GetHealthCheckCountRequest
  ): Route53IO[GetHealthCheckCountResponse] =
    FF.liftF(GetHealthCheckCountOp(request))

  def getHealthCheckLastFailureReason(
    request: GetHealthCheckLastFailureReasonRequest
  ): Route53IO[GetHealthCheckLastFailureReasonResponse] =
    FF.liftF(GetHealthCheckLastFailureReasonOp(request))

  def getHealthCheckStatus(
    request: GetHealthCheckStatusRequest
  ): Route53IO[GetHealthCheckStatusResponse] =
    FF.liftF(GetHealthCheckStatusOp(request))

  def getHostedZone(
    request: GetHostedZoneRequest
  ): Route53IO[GetHostedZoneResponse] =
    FF.liftF(GetHostedZoneOp(request))

  def getHostedZoneCount(
    request: GetHostedZoneCountRequest
  ): Route53IO[GetHostedZoneCountResponse] =
    FF.liftF(GetHostedZoneCountOp(request))

  def getHostedZoneLimit(
    request: GetHostedZoneLimitRequest
  ): Route53IO[GetHostedZoneLimitResponse] =
    FF.liftF(GetHostedZoneLimitOp(request))

  def getQueryLoggingConfig(
    request: GetQueryLoggingConfigRequest
  ): Route53IO[GetQueryLoggingConfigResponse] =
    FF.liftF(GetQueryLoggingConfigOp(request))

  def getReusableDelegationSet(
    request: GetReusableDelegationSetRequest
  ): Route53IO[GetReusableDelegationSetResponse] =
    FF.liftF(GetReusableDelegationSetOp(request))

  def getReusableDelegationSetLimit(
    request: GetReusableDelegationSetLimitRequest
  ): Route53IO[GetReusableDelegationSetLimitResponse] =
    FF.liftF(GetReusableDelegationSetLimitOp(request))

  def getTrafficPolicy(
    request: GetTrafficPolicyRequest
  ): Route53IO[GetTrafficPolicyResponse] =
    FF.liftF(GetTrafficPolicyOp(request))

  def getTrafficPolicyInstance(
    request: GetTrafficPolicyInstanceRequest
  ): Route53IO[GetTrafficPolicyInstanceResponse] =
    FF.liftF(GetTrafficPolicyInstanceOp(request))

  def getTrafficPolicyInstanceCount(
    request: GetTrafficPolicyInstanceCountRequest
  ): Route53IO[GetTrafficPolicyInstanceCountResponse] =
    FF.liftF(GetTrafficPolicyInstanceCountOp(request))

  def listGeoLocations(
    request: ListGeoLocationsRequest
  ): Route53IO[ListGeoLocationsResponse] =
    FF.liftF(ListGeoLocationsOp(request))

  def listHealthChecks(
    request: ListHealthChecksRequest
  ): Route53IO[ListHealthChecksResponse] =
    FF.liftF(ListHealthChecksOp(request))

  def listHostedZones(
    request: ListHostedZonesRequest
  ): Route53IO[ListHostedZonesResponse] =
    FF.liftF(ListHostedZonesOp(request))

  def listHostedZonesByName(
    request: ListHostedZonesByNameRequest
  ): Route53IO[ListHostedZonesByNameResponse] =
    FF.liftF(ListHostedZonesByNameOp(request))

  def listHostedZonesByVPC(
    request: ListHostedZonesByVpcRequest
  ): Route53IO[ListHostedZonesByVpcResponse] =
    FF.liftF(ListHostedZonesByVPCOp(request))

  def listQueryLoggingConfigs(
    request: ListQueryLoggingConfigsRequest
  ): Route53IO[ListQueryLoggingConfigsResponse] =
    FF.liftF(ListQueryLoggingConfigsOp(request))

  def listResourceRecordSets(
    request: ListResourceRecordSetsRequest
  ): Route53IO[ListResourceRecordSetsResponse] =
    FF.liftF(ListResourceRecordSetsOp(request))

  def listReusableDelegationSets(
    request: ListReusableDelegationSetsRequest
  ): Route53IO[ListReusableDelegationSetsResponse] =
    FF.liftF(ListReusableDelegationSetsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): Route53IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTagsForResources(
    request: ListTagsForResourcesRequest
  ): Route53IO[ListTagsForResourcesResponse] =
    FF.liftF(ListTagsForResourcesOp(request))

  def listTrafficPolicies(
    request: ListTrafficPoliciesRequest
  ): Route53IO[ListTrafficPoliciesResponse] =
    FF.liftF(ListTrafficPoliciesOp(request))

  def listTrafficPolicyInstances(
    request: ListTrafficPolicyInstancesRequest
  ): Route53IO[ListTrafficPolicyInstancesResponse] =
    FF.liftF(ListTrafficPolicyInstancesOp(request))

  def listTrafficPolicyInstancesByHostedZone(
    request: ListTrafficPolicyInstancesByHostedZoneRequest
  ): Route53IO[ListTrafficPolicyInstancesByHostedZoneResponse] =
    FF.liftF(ListTrafficPolicyInstancesByHostedZoneOp(request))

  def listTrafficPolicyInstancesByPolicy(
    request: ListTrafficPolicyInstancesByPolicyRequest
  ): Route53IO[ListTrafficPolicyInstancesByPolicyResponse] =
    FF.liftF(ListTrafficPolicyInstancesByPolicyOp(request))

  def listTrafficPolicyVersions(
    request: ListTrafficPolicyVersionsRequest
  ): Route53IO[ListTrafficPolicyVersionsResponse] =
    FF.liftF(ListTrafficPolicyVersionsOp(request))

  def listVPCAssociationAuthorizations(
    request: ListVpcAssociationAuthorizationsRequest
  ): Route53IO[ListVpcAssociationAuthorizationsResponse] =
    FF.liftF(ListVPCAssociationAuthorizationsOp(request))

  def testDNSAnswer(
    request: TestDnsAnswerRequest
  ): Route53IO[TestDnsAnswerResponse] =
    FF.liftF(TestDNSAnswerOp(request))

  def updateHealthCheck(
    request: UpdateHealthCheckRequest
  ): Route53IO[UpdateHealthCheckResponse] =
    FF.liftF(UpdateHealthCheckOp(request))

  def updateHostedZoneComment(
    request: UpdateHostedZoneCommentRequest
  ): Route53IO[UpdateHostedZoneCommentResponse] =
    FF.liftF(UpdateHostedZoneCommentOp(request))

  def updateTrafficPolicyComment(
    request: UpdateTrafficPolicyCommentRequest
  ): Route53IO[UpdateTrafficPolicyCommentResponse] =
    FF.liftF(UpdateTrafficPolicyCommentOp(request))

  def updateTrafficPolicyInstance(
    request: UpdateTrafficPolicyInstanceRequest
  ): Route53IO[UpdateTrafficPolicyInstanceResponse] =
    FF.liftF(UpdateTrafficPolicyInstanceOp(request))
}
