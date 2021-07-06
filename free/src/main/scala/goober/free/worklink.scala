package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.worklink.WorkLinkClient
import software.amazon.awssdk.services.worklink.model._


object worklink { module =>

  // Free monad over WorkLinkOp
  type WorkLinkIO[A] = FF[WorkLinkOp, A]

  sealed trait WorkLinkOp[A] {
    def visit[F[_]](visitor: WorkLinkOp.Visitor[F]): F[A]
  }

  object WorkLinkOp {
    // Given a WorkLinkClient we can embed a WorkLinkIO program in any algebra that understands embedding.
    implicit val WorkLinkOpEmbeddable: Embeddable[WorkLinkOp, WorkLinkClient] = new Embeddable[WorkLinkOp, WorkLinkClient] {
      def embed[A](client: WorkLinkClient, io: WorkLinkIO[A]): Embedded[A] = Embedded.WorkLink(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WorkLinkOp.Visitor[Kleisli[M, WorkLinkClient, *]] {
        def associateDomain(
          request: AssociateDomainRequest
        ): Kleisli[M, WorkLinkClient, AssociateDomainResponse] =
          primitive(_.associateDomain(request))

        def associateWebsiteAuthorizationProvider(
          request: AssociateWebsiteAuthorizationProviderRequest
        ): Kleisli[M, WorkLinkClient, AssociateWebsiteAuthorizationProviderResponse] =
          primitive(_.associateWebsiteAuthorizationProvider(request))

        def associateWebsiteCertificateAuthority(
          request: AssociateWebsiteCertificateAuthorityRequest
        ): Kleisli[M, WorkLinkClient, AssociateWebsiteCertificateAuthorityResponse] =
          primitive(_.associateWebsiteCertificateAuthority(request))

        def createFleet(
          request: CreateFleetRequest
        ): Kleisli[M, WorkLinkClient, CreateFleetResponse] =
          primitive(_.createFleet(request))

        def deleteFleet(
          request: DeleteFleetRequest
        ): Kleisli[M, WorkLinkClient, DeleteFleetResponse] =
          primitive(_.deleteFleet(request))

        def describeAuditStreamConfiguration(
          request: DescribeAuditStreamConfigurationRequest
        ): Kleisli[M, WorkLinkClient, DescribeAuditStreamConfigurationResponse] =
          primitive(_.describeAuditStreamConfiguration(request))

        def describeCompanyNetworkConfiguration(
          request: DescribeCompanyNetworkConfigurationRequest
        ): Kleisli[M, WorkLinkClient, DescribeCompanyNetworkConfigurationResponse] =
          primitive(_.describeCompanyNetworkConfiguration(request))

        def describeDevice(
          request: DescribeDeviceRequest
        ): Kleisli[M, WorkLinkClient, DescribeDeviceResponse] =
          primitive(_.describeDevice(request))

        def describeDevicePolicyConfiguration(
          request: DescribeDevicePolicyConfigurationRequest
        ): Kleisli[M, WorkLinkClient, DescribeDevicePolicyConfigurationResponse] =
          primitive(_.describeDevicePolicyConfiguration(request))

        def describeDomain(
          request: DescribeDomainRequest
        ): Kleisli[M, WorkLinkClient, DescribeDomainResponse] =
          primitive(_.describeDomain(request))

        def describeFleetMetadata(
          request: DescribeFleetMetadataRequest
        ): Kleisli[M, WorkLinkClient, DescribeFleetMetadataResponse] =
          primitive(_.describeFleetMetadata(request))

        def describeIdentityProviderConfiguration(
          request: DescribeIdentityProviderConfigurationRequest
        ): Kleisli[M, WorkLinkClient, DescribeIdentityProviderConfigurationResponse] =
          primitive(_.describeIdentityProviderConfiguration(request))

        def describeWebsiteCertificateAuthority(
          request: DescribeWebsiteCertificateAuthorityRequest
        ): Kleisli[M, WorkLinkClient, DescribeWebsiteCertificateAuthorityResponse] =
          primitive(_.describeWebsiteCertificateAuthority(request))

        def disassociateDomain(
          request: DisassociateDomainRequest
        ): Kleisli[M, WorkLinkClient, DisassociateDomainResponse] =
          primitive(_.disassociateDomain(request))

        def disassociateWebsiteAuthorizationProvider(
          request: DisassociateWebsiteAuthorizationProviderRequest
        ): Kleisli[M, WorkLinkClient, DisassociateWebsiteAuthorizationProviderResponse] =
          primitive(_.disassociateWebsiteAuthorizationProvider(request))

        def disassociateWebsiteCertificateAuthority(
          request: DisassociateWebsiteCertificateAuthorityRequest
        ): Kleisli[M, WorkLinkClient, DisassociateWebsiteCertificateAuthorityResponse] =
          primitive(_.disassociateWebsiteCertificateAuthority(request))

        def listDevices(
          request: ListDevicesRequest
        ): Kleisli[M, WorkLinkClient, ListDevicesResponse] =
          primitive(_.listDevices(request))

        def listDomains(
          request: ListDomainsRequest
        ): Kleisli[M, WorkLinkClient, ListDomainsResponse] =
          primitive(_.listDomains(request))

        def listFleets(
          request: ListFleetsRequest
        ): Kleisli[M, WorkLinkClient, ListFleetsResponse] =
          primitive(_.listFleets(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, WorkLinkClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWebsiteAuthorizationProviders(
          request: ListWebsiteAuthorizationProvidersRequest
        ): Kleisli[M, WorkLinkClient, ListWebsiteAuthorizationProvidersResponse] =
          primitive(_.listWebsiteAuthorizationProviders(request))

        def listWebsiteCertificateAuthorities(
          request: ListWebsiteCertificateAuthoritiesRequest
        ): Kleisli[M, WorkLinkClient, ListWebsiteCertificateAuthoritiesResponse] =
          primitive(_.listWebsiteCertificateAuthorities(request))

        def restoreDomainAccess(
          request: RestoreDomainAccessRequest
        ): Kleisli[M, WorkLinkClient, RestoreDomainAccessResponse] =
          primitive(_.restoreDomainAccess(request))

        def revokeDomainAccess(
          request: RevokeDomainAccessRequest
        ): Kleisli[M, WorkLinkClient, RevokeDomainAccessResponse] =
          primitive(_.revokeDomainAccess(request))

        def signOutUser(
          request: SignOutUserRequest
        ): Kleisli[M, WorkLinkClient, SignOutUserResponse] =
          primitive(_.signOutUser(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, WorkLinkClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, WorkLinkClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAuditStreamConfiguration(
          request: UpdateAuditStreamConfigurationRequest
        ): Kleisli[M, WorkLinkClient, UpdateAuditStreamConfigurationResponse] =
          primitive(_.updateAuditStreamConfiguration(request))

        def updateCompanyNetworkConfiguration(
          request: UpdateCompanyNetworkConfigurationRequest
        ): Kleisli[M, WorkLinkClient, UpdateCompanyNetworkConfigurationResponse] =
          primitive(_.updateCompanyNetworkConfiguration(request))

        def updateDevicePolicyConfiguration(
          request: UpdateDevicePolicyConfigurationRequest
        ): Kleisli[M, WorkLinkClient, UpdateDevicePolicyConfigurationResponse] =
          primitive(_.updateDevicePolicyConfiguration(request))

        def updateDomainMetadata(
          request: UpdateDomainMetadataRequest
        ): Kleisli[M, WorkLinkClient, UpdateDomainMetadataResponse] =
          primitive(_.updateDomainMetadata(request))

        def updateFleetMetadata(
          request: UpdateFleetMetadataRequest
        ): Kleisli[M, WorkLinkClient, UpdateFleetMetadataResponse] =
          primitive(_.updateFleetMetadata(request))

        def updateIdentityProviderConfiguration(
          request: UpdateIdentityProviderConfigurationRequest
        ): Kleisli[M, WorkLinkClient, UpdateIdentityProviderConfigurationResponse] =
          primitive(_.updateIdentityProviderConfiguration(request))

        def primitive[A](
          f: WorkLinkClient => A
        ): Kleisli[M, WorkLinkClient, A]
      }
    }

    trait Visitor[F[_]] extends (WorkLinkOp ~> F) {
      final def apply[A](op: WorkLinkOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateDomain(
        request: AssociateDomainRequest
      ): F[AssociateDomainResponse]

      def associateWebsiteAuthorizationProvider(
        request: AssociateWebsiteAuthorizationProviderRequest
      ): F[AssociateWebsiteAuthorizationProviderResponse]

      def associateWebsiteCertificateAuthority(
        request: AssociateWebsiteCertificateAuthorityRequest
      ): F[AssociateWebsiteCertificateAuthorityResponse]

      def createFleet(
        request: CreateFleetRequest
      ): F[CreateFleetResponse]

      def deleteFleet(
        request: DeleteFleetRequest
      ): F[DeleteFleetResponse]

      def describeAuditStreamConfiguration(
        request: DescribeAuditStreamConfigurationRequest
      ): F[DescribeAuditStreamConfigurationResponse]

      def describeCompanyNetworkConfiguration(
        request: DescribeCompanyNetworkConfigurationRequest
      ): F[DescribeCompanyNetworkConfigurationResponse]

      def describeDevice(
        request: DescribeDeviceRequest
      ): F[DescribeDeviceResponse]

      def describeDevicePolicyConfiguration(
        request: DescribeDevicePolicyConfigurationRequest
      ): F[DescribeDevicePolicyConfigurationResponse]

      def describeDomain(
        request: DescribeDomainRequest
      ): F[DescribeDomainResponse]

      def describeFleetMetadata(
        request: DescribeFleetMetadataRequest
      ): F[DescribeFleetMetadataResponse]

      def describeIdentityProviderConfiguration(
        request: DescribeIdentityProviderConfigurationRequest
      ): F[DescribeIdentityProviderConfigurationResponse]

      def describeWebsiteCertificateAuthority(
        request: DescribeWebsiteCertificateAuthorityRequest
      ): F[DescribeWebsiteCertificateAuthorityResponse]

      def disassociateDomain(
        request: DisassociateDomainRequest
      ): F[DisassociateDomainResponse]

      def disassociateWebsiteAuthorizationProvider(
        request: DisassociateWebsiteAuthorizationProviderRequest
      ): F[DisassociateWebsiteAuthorizationProviderResponse]

      def disassociateWebsiteCertificateAuthority(
        request: DisassociateWebsiteCertificateAuthorityRequest
      ): F[DisassociateWebsiteCertificateAuthorityResponse]

      def listDevices(
        request: ListDevicesRequest
      ): F[ListDevicesResponse]

      def listDomains(
        request: ListDomainsRequest
      ): F[ListDomainsResponse]

      def listFleets(
        request: ListFleetsRequest
      ): F[ListFleetsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWebsiteAuthorizationProviders(
        request: ListWebsiteAuthorizationProvidersRequest
      ): F[ListWebsiteAuthorizationProvidersResponse]

      def listWebsiteCertificateAuthorities(
        request: ListWebsiteCertificateAuthoritiesRequest
      ): F[ListWebsiteCertificateAuthoritiesResponse]

      def restoreDomainAccess(
        request: RestoreDomainAccessRequest
      ): F[RestoreDomainAccessResponse]

      def revokeDomainAccess(
        request: RevokeDomainAccessRequest
      ): F[RevokeDomainAccessResponse]

      def signOutUser(
        request: SignOutUserRequest
      ): F[SignOutUserResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAuditStreamConfiguration(
        request: UpdateAuditStreamConfigurationRequest
      ): F[UpdateAuditStreamConfigurationResponse]

      def updateCompanyNetworkConfiguration(
        request: UpdateCompanyNetworkConfigurationRequest
      ): F[UpdateCompanyNetworkConfigurationResponse]

      def updateDevicePolicyConfiguration(
        request: UpdateDevicePolicyConfigurationRequest
      ): F[UpdateDevicePolicyConfigurationResponse]

      def updateDomainMetadata(
        request: UpdateDomainMetadataRequest
      ): F[UpdateDomainMetadataResponse]

      def updateFleetMetadata(
        request: UpdateFleetMetadataRequest
      ): F[UpdateFleetMetadataResponse]

      def updateIdentityProviderConfiguration(
        request: UpdateIdentityProviderConfigurationRequest
      ): F[UpdateIdentityProviderConfigurationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends WorkLinkOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateDomainOp(
      request: AssociateDomainRequest
    ) extends WorkLinkOp[AssociateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDomainResponse] =
        visitor.associateDomain(request)
    }

    final case class AssociateWebsiteAuthorizationProviderOp(
      request: AssociateWebsiteAuthorizationProviderRequest
    ) extends WorkLinkOp[AssociateWebsiteAuthorizationProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateWebsiteAuthorizationProviderResponse] =
        visitor.associateWebsiteAuthorizationProvider(request)
    }

    final case class AssociateWebsiteCertificateAuthorityOp(
      request: AssociateWebsiteCertificateAuthorityRequest
    ) extends WorkLinkOp[AssociateWebsiteCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateWebsiteCertificateAuthorityResponse] =
        visitor.associateWebsiteCertificateAuthority(request)
    }

    final case class CreateFleetOp(
      request: CreateFleetRequest
    ) extends WorkLinkOp[CreateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFleetResponse] =
        visitor.createFleet(request)
    }

    final case class DeleteFleetOp(
      request: DeleteFleetRequest
    ) extends WorkLinkOp[DeleteFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFleetResponse] =
        visitor.deleteFleet(request)
    }

    final case class DescribeAuditStreamConfigurationOp(
      request: DescribeAuditStreamConfigurationRequest
    ) extends WorkLinkOp[DescribeAuditStreamConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAuditStreamConfigurationResponse] =
        visitor.describeAuditStreamConfiguration(request)
    }

    final case class DescribeCompanyNetworkConfigurationOp(
      request: DescribeCompanyNetworkConfigurationRequest
    ) extends WorkLinkOp[DescribeCompanyNetworkConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCompanyNetworkConfigurationResponse] =
        visitor.describeCompanyNetworkConfiguration(request)
    }

    final case class DescribeDeviceOp(
      request: DescribeDeviceRequest
    ) extends WorkLinkOp[DescribeDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeviceResponse] =
        visitor.describeDevice(request)
    }

    final case class DescribeDevicePolicyConfigurationOp(
      request: DescribeDevicePolicyConfigurationRequest
    ) extends WorkLinkOp[DescribeDevicePolicyConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDevicePolicyConfigurationResponse] =
        visitor.describeDevicePolicyConfiguration(request)
    }

    final case class DescribeDomainOp(
      request: DescribeDomainRequest
    ) extends WorkLinkOp[DescribeDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainResponse] =
        visitor.describeDomain(request)
    }

    final case class DescribeFleetMetadataOp(
      request: DescribeFleetMetadataRequest
    ) extends WorkLinkOp[DescribeFleetMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetMetadataResponse] =
        visitor.describeFleetMetadata(request)
    }

    final case class DescribeIdentityProviderConfigurationOp(
      request: DescribeIdentityProviderConfigurationRequest
    ) extends WorkLinkOp[DescribeIdentityProviderConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityProviderConfigurationResponse] =
        visitor.describeIdentityProviderConfiguration(request)
    }

    final case class DescribeWebsiteCertificateAuthorityOp(
      request: DescribeWebsiteCertificateAuthorityRequest
    ) extends WorkLinkOp[DescribeWebsiteCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWebsiteCertificateAuthorityResponse] =
        visitor.describeWebsiteCertificateAuthority(request)
    }

    final case class DisassociateDomainOp(
      request: DisassociateDomainRequest
    ) extends WorkLinkOp[DisassociateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateDomainResponse] =
        visitor.disassociateDomain(request)
    }

    final case class DisassociateWebsiteAuthorizationProviderOp(
      request: DisassociateWebsiteAuthorizationProviderRequest
    ) extends WorkLinkOp[DisassociateWebsiteAuthorizationProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateWebsiteAuthorizationProviderResponse] =
        visitor.disassociateWebsiteAuthorizationProvider(request)
    }

    final case class DisassociateWebsiteCertificateAuthorityOp(
      request: DisassociateWebsiteCertificateAuthorityRequest
    ) extends WorkLinkOp[DisassociateWebsiteCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateWebsiteCertificateAuthorityResponse] =
        visitor.disassociateWebsiteCertificateAuthority(request)
    }

    final case class ListDevicesOp(
      request: ListDevicesRequest
    ) extends WorkLinkOp[ListDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevicesResponse] =
        visitor.listDevices(request)
    }

    final case class ListDomainsOp(
      request: ListDomainsRequest
    ) extends WorkLinkOp[ListDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainsResponse] =
        visitor.listDomains(request)
    }

    final case class ListFleetsOp(
      request: ListFleetsRequest
    ) extends WorkLinkOp[ListFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFleetsResponse] =
        visitor.listFleets(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends WorkLinkOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWebsiteAuthorizationProvidersOp(
      request: ListWebsiteAuthorizationProvidersRequest
    ) extends WorkLinkOp[ListWebsiteAuthorizationProvidersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWebsiteAuthorizationProvidersResponse] =
        visitor.listWebsiteAuthorizationProviders(request)
    }

    final case class ListWebsiteCertificateAuthoritiesOp(
      request: ListWebsiteCertificateAuthoritiesRequest
    ) extends WorkLinkOp[ListWebsiteCertificateAuthoritiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWebsiteCertificateAuthoritiesResponse] =
        visitor.listWebsiteCertificateAuthorities(request)
    }

    final case class RestoreDomainAccessOp(
      request: RestoreDomainAccessRequest
    ) extends WorkLinkOp[RestoreDomainAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDomainAccessResponse] =
        visitor.restoreDomainAccess(request)
    }

    final case class RevokeDomainAccessOp(
      request: RevokeDomainAccessRequest
    ) extends WorkLinkOp[RevokeDomainAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeDomainAccessResponse] =
        visitor.revokeDomainAccess(request)
    }

    final case class SignOutUserOp(
      request: SignOutUserRequest
    ) extends WorkLinkOp[SignOutUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SignOutUserResponse] =
        visitor.signOutUser(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends WorkLinkOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends WorkLinkOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAuditStreamConfigurationOp(
      request: UpdateAuditStreamConfigurationRequest
    ) extends WorkLinkOp[UpdateAuditStreamConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAuditStreamConfigurationResponse] =
        visitor.updateAuditStreamConfiguration(request)
    }

    final case class UpdateCompanyNetworkConfigurationOp(
      request: UpdateCompanyNetworkConfigurationRequest
    ) extends WorkLinkOp[UpdateCompanyNetworkConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCompanyNetworkConfigurationResponse] =
        visitor.updateCompanyNetworkConfiguration(request)
    }

    final case class UpdateDevicePolicyConfigurationOp(
      request: UpdateDevicePolicyConfigurationRequest
    ) extends WorkLinkOp[UpdateDevicePolicyConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDevicePolicyConfigurationResponse] =
        visitor.updateDevicePolicyConfiguration(request)
    }

    final case class UpdateDomainMetadataOp(
      request: UpdateDomainMetadataRequest
    ) extends WorkLinkOp[UpdateDomainMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainMetadataResponse] =
        visitor.updateDomainMetadata(request)
    }

    final case class UpdateFleetMetadataOp(
      request: UpdateFleetMetadataRequest
    ) extends WorkLinkOp[UpdateFleetMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFleetMetadataResponse] =
        visitor.updateFleetMetadata(request)
    }

    final case class UpdateIdentityProviderConfigurationOp(
      request: UpdateIdentityProviderConfigurationRequest
    ) extends WorkLinkOp[UpdateIdentityProviderConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIdentityProviderConfigurationResponse] =
        visitor.updateIdentityProviderConfiguration(request)
    }
  }

  import WorkLinkOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WorkLinkOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateDomain(
    request: AssociateDomainRequest
  ): WorkLinkIO[AssociateDomainResponse] =
    FF.liftF(AssociateDomainOp(request))

  def associateWebsiteAuthorizationProvider(
    request: AssociateWebsiteAuthorizationProviderRequest
  ): WorkLinkIO[AssociateWebsiteAuthorizationProviderResponse] =
    FF.liftF(AssociateWebsiteAuthorizationProviderOp(request))

  def associateWebsiteCertificateAuthority(
    request: AssociateWebsiteCertificateAuthorityRequest
  ): WorkLinkIO[AssociateWebsiteCertificateAuthorityResponse] =
    FF.liftF(AssociateWebsiteCertificateAuthorityOp(request))

  def createFleet(
    request: CreateFleetRequest
  ): WorkLinkIO[CreateFleetResponse] =
    FF.liftF(CreateFleetOp(request))

  def deleteFleet(
    request: DeleteFleetRequest
  ): WorkLinkIO[DeleteFleetResponse] =
    FF.liftF(DeleteFleetOp(request))

  def describeAuditStreamConfiguration(
    request: DescribeAuditStreamConfigurationRequest
  ): WorkLinkIO[DescribeAuditStreamConfigurationResponse] =
    FF.liftF(DescribeAuditStreamConfigurationOp(request))

  def describeCompanyNetworkConfiguration(
    request: DescribeCompanyNetworkConfigurationRequest
  ): WorkLinkIO[DescribeCompanyNetworkConfigurationResponse] =
    FF.liftF(DescribeCompanyNetworkConfigurationOp(request))

  def describeDevice(
    request: DescribeDeviceRequest
  ): WorkLinkIO[DescribeDeviceResponse] =
    FF.liftF(DescribeDeviceOp(request))

  def describeDevicePolicyConfiguration(
    request: DescribeDevicePolicyConfigurationRequest
  ): WorkLinkIO[DescribeDevicePolicyConfigurationResponse] =
    FF.liftF(DescribeDevicePolicyConfigurationOp(request))

  def describeDomain(
    request: DescribeDomainRequest
  ): WorkLinkIO[DescribeDomainResponse] =
    FF.liftF(DescribeDomainOp(request))

  def describeFleetMetadata(
    request: DescribeFleetMetadataRequest
  ): WorkLinkIO[DescribeFleetMetadataResponse] =
    FF.liftF(DescribeFleetMetadataOp(request))

  def describeIdentityProviderConfiguration(
    request: DescribeIdentityProviderConfigurationRequest
  ): WorkLinkIO[DescribeIdentityProviderConfigurationResponse] =
    FF.liftF(DescribeIdentityProviderConfigurationOp(request))

  def describeWebsiteCertificateAuthority(
    request: DescribeWebsiteCertificateAuthorityRequest
  ): WorkLinkIO[DescribeWebsiteCertificateAuthorityResponse] =
    FF.liftF(DescribeWebsiteCertificateAuthorityOp(request))

  def disassociateDomain(
    request: DisassociateDomainRequest
  ): WorkLinkIO[DisassociateDomainResponse] =
    FF.liftF(DisassociateDomainOp(request))

  def disassociateWebsiteAuthorizationProvider(
    request: DisassociateWebsiteAuthorizationProviderRequest
  ): WorkLinkIO[DisassociateWebsiteAuthorizationProviderResponse] =
    FF.liftF(DisassociateWebsiteAuthorizationProviderOp(request))

  def disassociateWebsiteCertificateAuthority(
    request: DisassociateWebsiteCertificateAuthorityRequest
  ): WorkLinkIO[DisassociateWebsiteCertificateAuthorityResponse] =
    FF.liftF(DisassociateWebsiteCertificateAuthorityOp(request))

  def listDevices(
    request: ListDevicesRequest
  ): WorkLinkIO[ListDevicesResponse] =
    FF.liftF(ListDevicesOp(request))

  def listDomains(
    request: ListDomainsRequest
  ): WorkLinkIO[ListDomainsResponse] =
    FF.liftF(ListDomainsOp(request))

  def listFleets(
    request: ListFleetsRequest
  ): WorkLinkIO[ListFleetsResponse] =
    FF.liftF(ListFleetsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): WorkLinkIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWebsiteAuthorizationProviders(
    request: ListWebsiteAuthorizationProvidersRequest
  ): WorkLinkIO[ListWebsiteAuthorizationProvidersResponse] =
    FF.liftF(ListWebsiteAuthorizationProvidersOp(request))

  def listWebsiteCertificateAuthorities(
    request: ListWebsiteCertificateAuthoritiesRequest
  ): WorkLinkIO[ListWebsiteCertificateAuthoritiesResponse] =
    FF.liftF(ListWebsiteCertificateAuthoritiesOp(request))

  def restoreDomainAccess(
    request: RestoreDomainAccessRequest
  ): WorkLinkIO[RestoreDomainAccessResponse] =
    FF.liftF(RestoreDomainAccessOp(request))

  def revokeDomainAccess(
    request: RevokeDomainAccessRequest
  ): WorkLinkIO[RevokeDomainAccessResponse] =
    FF.liftF(RevokeDomainAccessOp(request))

  def signOutUser(
    request: SignOutUserRequest
  ): WorkLinkIO[SignOutUserResponse] =
    FF.liftF(SignOutUserOp(request))

  def tagResource(
    request: TagResourceRequest
  ): WorkLinkIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): WorkLinkIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAuditStreamConfiguration(
    request: UpdateAuditStreamConfigurationRequest
  ): WorkLinkIO[UpdateAuditStreamConfigurationResponse] =
    FF.liftF(UpdateAuditStreamConfigurationOp(request))

  def updateCompanyNetworkConfiguration(
    request: UpdateCompanyNetworkConfigurationRequest
  ): WorkLinkIO[UpdateCompanyNetworkConfigurationResponse] =
    FF.liftF(UpdateCompanyNetworkConfigurationOp(request))

  def updateDevicePolicyConfiguration(
    request: UpdateDevicePolicyConfigurationRequest
  ): WorkLinkIO[UpdateDevicePolicyConfigurationResponse] =
    FF.liftF(UpdateDevicePolicyConfigurationOp(request))

  def updateDomainMetadata(
    request: UpdateDomainMetadataRequest
  ): WorkLinkIO[UpdateDomainMetadataResponse] =
    FF.liftF(UpdateDomainMetadataOp(request))

  def updateFleetMetadata(
    request: UpdateFleetMetadataRequest
  ): WorkLinkIO[UpdateFleetMetadataResponse] =
    FF.liftF(UpdateFleetMetadataOp(request))

  def updateIdentityProviderConfiguration(
    request: UpdateIdentityProviderConfigurationRequest
  ): WorkLinkIO[UpdateIdentityProviderConfigurationResponse] =
    FF.liftF(UpdateIdentityProviderConfigurationOp(request))
}
