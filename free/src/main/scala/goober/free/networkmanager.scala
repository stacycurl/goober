package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.networkmanager.NetworkManagerClient
import software.amazon.awssdk.services.networkmanager.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object networkmanager { module =>

  // Free monad over NetworkManagerOp
  type NetworkManagerIO[A] = FF[NetworkManagerOp, A]

  sealed trait NetworkManagerOp[A] {
    def visit[F[_]](visitor: NetworkManagerOp.Visitor[F]): F[A]
  }

  object NetworkManagerOp {
    // Given a NetworkManagerClient we can embed a NetworkManagerIO program in any algebra that understands embedding.
    implicit val NetworkManagerOpEmbeddable: Embeddable[NetworkManagerOp, NetworkManagerClient] = new Embeddable[NetworkManagerOp, NetworkManagerClient] {
      def embed[A](client: NetworkManagerClient, io: NetworkManagerIO[A]): Embedded[A] = Embedded.NetworkManager(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends NetworkManagerOp.Visitor[Kleisli[M, NetworkManagerClient, *]] {
        def associateCustomerGateway(
          request: AssociateCustomerGatewayRequest
        ): Kleisli[M, NetworkManagerClient, AssociateCustomerGatewayResponse] =
          primitive(_.associateCustomerGateway(request))

        def associateLink(
          request: AssociateLinkRequest
        ): Kleisli[M, NetworkManagerClient, AssociateLinkResponse] =
          primitive(_.associateLink(request))

        def associateTransitGatewayConnectPeer(
          request: AssociateTransitGatewayConnectPeerRequest
        ): Kleisli[M, NetworkManagerClient, AssociateTransitGatewayConnectPeerResponse] =
          primitive(_.associateTransitGatewayConnectPeer(request))

        def createConnection(
          request: CreateConnectionRequest
        ): Kleisli[M, NetworkManagerClient, CreateConnectionResponse] =
          primitive(_.createConnection(request))

        def createDevice(
          request: CreateDeviceRequest
        ): Kleisli[M, NetworkManagerClient, CreateDeviceResponse] =
          primitive(_.createDevice(request))

        def createGlobalNetwork(
          request: CreateGlobalNetworkRequest
        ): Kleisli[M, NetworkManagerClient, CreateGlobalNetworkResponse] =
          primitive(_.createGlobalNetwork(request))

        def createLink(
          request: CreateLinkRequest
        ): Kleisli[M, NetworkManagerClient, CreateLinkResponse] =
          primitive(_.createLink(request))

        def createSite(
          request: CreateSiteRequest
        ): Kleisli[M, NetworkManagerClient, CreateSiteResponse] =
          primitive(_.createSite(request))

        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, NetworkManagerClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def deleteDevice(
          request: DeleteDeviceRequest
        ): Kleisli[M, NetworkManagerClient, DeleteDeviceResponse] =
          primitive(_.deleteDevice(request))

        def deleteGlobalNetwork(
          request: DeleteGlobalNetworkRequest
        ): Kleisli[M, NetworkManagerClient, DeleteGlobalNetworkResponse] =
          primitive(_.deleteGlobalNetwork(request))

        def deleteLink(
          request: DeleteLinkRequest
        ): Kleisli[M, NetworkManagerClient, DeleteLinkResponse] =
          primitive(_.deleteLink(request))

        def deleteSite(
          request: DeleteSiteRequest
        ): Kleisli[M, NetworkManagerClient, DeleteSiteResponse] =
          primitive(_.deleteSite(request))

        def deregisterTransitGateway(
          request: DeregisterTransitGatewayRequest
        ): Kleisli[M, NetworkManagerClient, DeregisterTransitGatewayResponse] =
          primitive(_.deregisterTransitGateway(request))

        def describeGlobalNetworks(
          request: DescribeGlobalNetworksRequest
        ): Kleisli[M, NetworkManagerClient, DescribeGlobalNetworksResponse] =
          primitive(_.describeGlobalNetworks(request))

        def disassociateCustomerGateway(
          request: DisassociateCustomerGatewayRequest
        ): Kleisli[M, NetworkManagerClient, DisassociateCustomerGatewayResponse] =
          primitive(_.disassociateCustomerGateway(request))

        def disassociateLink(
          request: DisassociateLinkRequest
        ): Kleisli[M, NetworkManagerClient, DisassociateLinkResponse] =
          primitive(_.disassociateLink(request))

        def disassociateTransitGatewayConnectPeer(
          request: DisassociateTransitGatewayConnectPeerRequest
        ): Kleisli[M, NetworkManagerClient, DisassociateTransitGatewayConnectPeerResponse] =
          primitive(_.disassociateTransitGatewayConnectPeer(request))

        def getConnections(
          request: GetConnectionsRequest
        ): Kleisli[M, NetworkManagerClient, GetConnectionsResponse] =
          primitive(_.getConnections(request))

        def getCustomerGatewayAssociations(
          request: GetCustomerGatewayAssociationsRequest
        ): Kleisli[M, NetworkManagerClient, GetCustomerGatewayAssociationsResponse] =
          primitive(_.getCustomerGatewayAssociations(request))

        def getDevices(
          request: GetDevicesRequest
        ): Kleisli[M, NetworkManagerClient, GetDevicesResponse] =
          primitive(_.getDevices(request))

        def getLinkAssociations(
          request: GetLinkAssociationsRequest
        ): Kleisli[M, NetworkManagerClient, GetLinkAssociationsResponse] =
          primitive(_.getLinkAssociations(request))

        def getLinks(
          request: GetLinksRequest
        ): Kleisli[M, NetworkManagerClient, GetLinksResponse] =
          primitive(_.getLinks(request))

        def getSites(
          request: GetSitesRequest
        ): Kleisli[M, NetworkManagerClient, GetSitesResponse] =
          primitive(_.getSites(request))

        def getTransitGatewayConnectPeerAssociations(
          request: GetTransitGatewayConnectPeerAssociationsRequest
        ): Kleisli[M, NetworkManagerClient, GetTransitGatewayConnectPeerAssociationsResponse] =
          primitive(_.getTransitGatewayConnectPeerAssociations(request))

        def getTransitGatewayRegistrations(
          request: GetTransitGatewayRegistrationsRequest
        ): Kleisli[M, NetworkManagerClient, GetTransitGatewayRegistrationsResponse] =
          primitive(_.getTransitGatewayRegistrations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, NetworkManagerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def registerTransitGateway(
          request: RegisterTransitGatewayRequest
        ): Kleisli[M, NetworkManagerClient, RegisterTransitGatewayResponse] =
          primitive(_.registerTransitGateway(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, NetworkManagerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, NetworkManagerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateConnection(
          request: UpdateConnectionRequest
        ): Kleisli[M, NetworkManagerClient, UpdateConnectionResponse] =
          primitive(_.updateConnection(request))

        def updateDevice(
          request: UpdateDeviceRequest
        ): Kleisli[M, NetworkManagerClient, UpdateDeviceResponse] =
          primitive(_.updateDevice(request))

        def updateGlobalNetwork(
          request: UpdateGlobalNetworkRequest
        ): Kleisli[M, NetworkManagerClient, UpdateGlobalNetworkResponse] =
          primitive(_.updateGlobalNetwork(request))

        def updateLink(
          request: UpdateLinkRequest
        ): Kleisli[M, NetworkManagerClient, UpdateLinkResponse] =
          primitive(_.updateLink(request))

        def updateSite(
          request: UpdateSiteRequest
        ): Kleisli[M, NetworkManagerClient, UpdateSiteResponse] =
          primitive(_.updateSite(request))

        def primitive[A](
          f: NetworkManagerClient => A
        ): Kleisli[M, NetworkManagerClient, A]
      }
    }

    trait Visitor[F[_]] extends (NetworkManagerOp ~> F) {
      final def apply[A](op: NetworkManagerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateCustomerGateway(
        request: AssociateCustomerGatewayRequest
      ): F[AssociateCustomerGatewayResponse]

      def associateLink(
        request: AssociateLinkRequest
      ): F[AssociateLinkResponse]

      def associateTransitGatewayConnectPeer(
        request: AssociateTransitGatewayConnectPeerRequest
      ): F[AssociateTransitGatewayConnectPeerResponse]

      def createConnection(
        request: CreateConnectionRequest
      ): F[CreateConnectionResponse]

      def createDevice(
        request: CreateDeviceRequest
      ): F[CreateDeviceResponse]

      def createGlobalNetwork(
        request: CreateGlobalNetworkRequest
      ): F[CreateGlobalNetworkResponse]

      def createLink(
        request: CreateLinkRequest
      ): F[CreateLinkResponse]

      def createSite(
        request: CreateSiteRequest
      ): F[CreateSiteResponse]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def deleteDevice(
        request: DeleteDeviceRequest
      ): F[DeleteDeviceResponse]

      def deleteGlobalNetwork(
        request: DeleteGlobalNetworkRequest
      ): F[DeleteGlobalNetworkResponse]

      def deleteLink(
        request: DeleteLinkRequest
      ): F[DeleteLinkResponse]

      def deleteSite(
        request: DeleteSiteRequest
      ): F[DeleteSiteResponse]

      def deregisterTransitGateway(
        request: DeregisterTransitGatewayRequest
      ): F[DeregisterTransitGatewayResponse]

      def describeGlobalNetworks(
        request: DescribeGlobalNetworksRequest
      ): F[DescribeGlobalNetworksResponse]

      def disassociateCustomerGateway(
        request: DisassociateCustomerGatewayRequest
      ): F[DisassociateCustomerGatewayResponse]

      def disassociateLink(
        request: DisassociateLinkRequest
      ): F[DisassociateLinkResponse]

      def disassociateTransitGatewayConnectPeer(
        request: DisassociateTransitGatewayConnectPeerRequest
      ): F[DisassociateTransitGatewayConnectPeerResponse]

      def getConnections(
        request: GetConnectionsRequest
      ): F[GetConnectionsResponse]

      def getCustomerGatewayAssociations(
        request: GetCustomerGatewayAssociationsRequest
      ): F[GetCustomerGatewayAssociationsResponse]

      def getDevices(
        request: GetDevicesRequest
      ): F[GetDevicesResponse]

      def getLinkAssociations(
        request: GetLinkAssociationsRequest
      ): F[GetLinkAssociationsResponse]

      def getLinks(
        request: GetLinksRequest
      ): F[GetLinksResponse]

      def getSites(
        request: GetSitesRequest
      ): F[GetSitesResponse]

      def getTransitGatewayConnectPeerAssociations(
        request: GetTransitGatewayConnectPeerAssociationsRequest
      ): F[GetTransitGatewayConnectPeerAssociationsResponse]

      def getTransitGatewayRegistrations(
        request: GetTransitGatewayRegistrationsRequest
      ): F[GetTransitGatewayRegistrationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def registerTransitGateway(
        request: RegisterTransitGatewayRequest
      ): F[RegisterTransitGatewayResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateConnection(
        request: UpdateConnectionRequest
      ): F[UpdateConnectionResponse]

      def updateDevice(
        request: UpdateDeviceRequest
      ): F[UpdateDeviceResponse]

      def updateGlobalNetwork(
        request: UpdateGlobalNetworkRequest
      ): F[UpdateGlobalNetworkResponse]

      def updateLink(
        request: UpdateLinkRequest
      ): F[UpdateLinkResponse]

      def updateSite(
        request: UpdateSiteRequest
      ): F[UpdateSiteResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends NetworkManagerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateCustomerGatewayOp(
      request: AssociateCustomerGatewayRequest
    ) extends NetworkManagerOp[AssociateCustomerGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateCustomerGatewayResponse] =
        visitor.associateCustomerGateway(request)
    }

    final case class AssociateLinkOp(
      request: AssociateLinkRequest
    ) extends NetworkManagerOp[AssociateLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateLinkResponse] =
        visitor.associateLink(request)
    }

    final case class AssociateTransitGatewayConnectPeerOp(
      request: AssociateTransitGatewayConnectPeerRequest
    ) extends NetworkManagerOp[AssociateTransitGatewayConnectPeerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTransitGatewayConnectPeerResponse] =
        visitor.associateTransitGatewayConnectPeer(request)
    }

    final case class CreateConnectionOp(
      request: CreateConnectionRequest
    ) extends NetworkManagerOp[CreateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectionResponse] =
        visitor.createConnection(request)
    }

    final case class CreateDeviceOp(
      request: CreateDeviceRequest
    ) extends NetworkManagerOp[CreateDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeviceResponse] =
        visitor.createDevice(request)
    }

    final case class CreateGlobalNetworkOp(
      request: CreateGlobalNetworkRequest
    ) extends NetworkManagerOp[CreateGlobalNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGlobalNetworkResponse] =
        visitor.createGlobalNetwork(request)
    }

    final case class CreateLinkOp(
      request: CreateLinkRequest
    ) extends NetworkManagerOp[CreateLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLinkResponse] =
        visitor.createLink(request)
    }

    final case class CreateSiteOp(
      request: CreateSiteRequest
    ) extends NetworkManagerOp[CreateSiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSiteResponse] =
        visitor.createSite(request)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends NetworkManagerOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class DeleteDeviceOp(
      request: DeleteDeviceRequest
    ) extends NetworkManagerOp[DeleteDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeviceResponse] =
        visitor.deleteDevice(request)
    }

    final case class DeleteGlobalNetworkOp(
      request: DeleteGlobalNetworkRequest
    ) extends NetworkManagerOp[DeleteGlobalNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGlobalNetworkResponse] =
        visitor.deleteGlobalNetwork(request)
    }

    final case class DeleteLinkOp(
      request: DeleteLinkRequest
    ) extends NetworkManagerOp[DeleteLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLinkResponse] =
        visitor.deleteLink(request)
    }

    final case class DeleteSiteOp(
      request: DeleteSiteRequest
    ) extends NetworkManagerOp[DeleteSiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSiteResponse] =
        visitor.deleteSite(request)
    }

    final case class DeregisterTransitGatewayOp(
      request: DeregisterTransitGatewayRequest
    ) extends NetworkManagerOp[DeregisterTransitGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTransitGatewayResponse] =
        visitor.deregisterTransitGateway(request)
    }

    final case class DescribeGlobalNetworksOp(
      request: DescribeGlobalNetworksRequest
    ) extends NetworkManagerOp[DescribeGlobalNetworksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGlobalNetworksResponse] =
        visitor.describeGlobalNetworks(request)
    }

    final case class DisassociateCustomerGatewayOp(
      request: DisassociateCustomerGatewayRequest
    ) extends NetworkManagerOp[DisassociateCustomerGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateCustomerGatewayResponse] =
        visitor.disassociateCustomerGateway(request)
    }

    final case class DisassociateLinkOp(
      request: DisassociateLinkRequest
    ) extends NetworkManagerOp[DisassociateLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateLinkResponse] =
        visitor.disassociateLink(request)
    }

    final case class DisassociateTransitGatewayConnectPeerOp(
      request: DisassociateTransitGatewayConnectPeerRequest
    ) extends NetworkManagerOp[DisassociateTransitGatewayConnectPeerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateTransitGatewayConnectPeerResponse] =
        visitor.disassociateTransitGatewayConnectPeer(request)
    }

    final case class GetConnectionsOp(
      request: GetConnectionsRequest
    ) extends NetworkManagerOp[GetConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectionsResponse] =
        visitor.getConnections(request)
    }

    final case class GetCustomerGatewayAssociationsOp(
      request: GetCustomerGatewayAssociationsRequest
    ) extends NetworkManagerOp[GetCustomerGatewayAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCustomerGatewayAssociationsResponse] =
        visitor.getCustomerGatewayAssociations(request)
    }

    final case class GetDevicesOp(
      request: GetDevicesRequest
    ) extends NetworkManagerOp[GetDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevicesResponse] =
        visitor.getDevices(request)
    }

    final case class GetLinkAssociationsOp(
      request: GetLinkAssociationsRequest
    ) extends NetworkManagerOp[GetLinkAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLinkAssociationsResponse] =
        visitor.getLinkAssociations(request)
    }

    final case class GetLinksOp(
      request: GetLinksRequest
    ) extends NetworkManagerOp[GetLinksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLinksResponse] =
        visitor.getLinks(request)
    }

    final case class GetSitesOp(
      request: GetSitesRequest
    ) extends NetworkManagerOp[GetSitesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSitesResponse] =
        visitor.getSites(request)
    }

    final case class GetTransitGatewayConnectPeerAssociationsOp(
      request: GetTransitGatewayConnectPeerAssociationsRequest
    ) extends NetworkManagerOp[GetTransitGatewayConnectPeerAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTransitGatewayConnectPeerAssociationsResponse] =
        visitor.getTransitGatewayConnectPeerAssociations(request)
    }

    final case class GetTransitGatewayRegistrationsOp(
      request: GetTransitGatewayRegistrationsRequest
    ) extends NetworkManagerOp[GetTransitGatewayRegistrationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTransitGatewayRegistrationsResponse] =
        visitor.getTransitGatewayRegistrations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends NetworkManagerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RegisterTransitGatewayOp(
      request: RegisterTransitGatewayRequest
    ) extends NetworkManagerOp[RegisterTransitGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTransitGatewayResponse] =
        visitor.registerTransitGateway(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends NetworkManagerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends NetworkManagerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateConnectionOp(
      request: UpdateConnectionRequest
    ) extends NetworkManagerOp[UpdateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectionResponse] =
        visitor.updateConnection(request)
    }

    final case class UpdateDeviceOp(
      request: UpdateDeviceRequest
    ) extends NetworkManagerOp[UpdateDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeviceResponse] =
        visitor.updateDevice(request)
    }

    final case class UpdateGlobalNetworkOp(
      request: UpdateGlobalNetworkRequest
    ) extends NetworkManagerOp[UpdateGlobalNetworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGlobalNetworkResponse] =
        visitor.updateGlobalNetwork(request)
    }

    final case class UpdateLinkOp(
      request: UpdateLinkRequest
    ) extends NetworkManagerOp[UpdateLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLinkResponse] =
        visitor.updateLink(request)
    }

    final case class UpdateSiteOp(
      request: UpdateSiteRequest
    ) extends NetworkManagerOp[UpdateSiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSiteResponse] =
        visitor.updateSite(request)
    }
  }

  import NetworkManagerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[NetworkManagerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateCustomerGateway(
    request: AssociateCustomerGatewayRequest
  ): NetworkManagerIO[AssociateCustomerGatewayResponse] =
    FF.liftF(AssociateCustomerGatewayOp(request))

  def associateLink(
    request: AssociateLinkRequest
  ): NetworkManagerIO[AssociateLinkResponse] =
    FF.liftF(AssociateLinkOp(request))

  def associateTransitGatewayConnectPeer(
    request: AssociateTransitGatewayConnectPeerRequest
  ): NetworkManagerIO[AssociateTransitGatewayConnectPeerResponse] =
    FF.liftF(AssociateTransitGatewayConnectPeerOp(request))

  def createConnection(
    request: CreateConnectionRequest
  ): NetworkManagerIO[CreateConnectionResponse] =
    FF.liftF(CreateConnectionOp(request))

  def createDevice(
    request: CreateDeviceRequest
  ): NetworkManagerIO[CreateDeviceResponse] =
    FF.liftF(CreateDeviceOp(request))

  def createGlobalNetwork(
    request: CreateGlobalNetworkRequest
  ): NetworkManagerIO[CreateGlobalNetworkResponse] =
    FF.liftF(CreateGlobalNetworkOp(request))

  def createLink(
    request: CreateLinkRequest
  ): NetworkManagerIO[CreateLinkResponse] =
    FF.liftF(CreateLinkOp(request))

  def createSite(
    request: CreateSiteRequest
  ): NetworkManagerIO[CreateSiteResponse] =
    FF.liftF(CreateSiteOp(request))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): NetworkManagerIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def deleteDevice(
    request: DeleteDeviceRequest
  ): NetworkManagerIO[DeleteDeviceResponse] =
    FF.liftF(DeleteDeviceOp(request))

  def deleteGlobalNetwork(
    request: DeleteGlobalNetworkRequest
  ): NetworkManagerIO[DeleteGlobalNetworkResponse] =
    FF.liftF(DeleteGlobalNetworkOp(request))

  def deleteLink(
    request: DeleteLinkRequest
  ): NetworkManagerIO[DeleteLinkResponse] =
    FF.liftF(DeleteLinkOp(request))

  def deleteSite(
    request: DeleteSiteRequest
  ): NetworkManagerIO[DeleteSiteResponse] =
    FF.liftF(DeleteSiteOp(request))

  def deregisterTransitGateway(
    request: DeregisterTransitGatewayRequest
  ): NetworkManagerIO[DeregisterTransitGatewayResponse] =
    FF.liftF(DeregisterTransitGatewayOp(request))

  def describeGlobalNetworks(
    request: DescribeGlobalNetworksRequest
  ): NetworkManagerIO[DescribeGlobalNetworksResponse] =
    FF.liftF(DescribeGlobalNetworksOp(request))

  def disassociateCustomerGateway(
    request: DisassociateCustomerGatewayRequest
  ): NetworkManagerIO[DisassociateCustomerGatewayResponse] =
    FF.liftF(DisassociateCustomerGatewayOp(request))

  def disassociateLink(
    request: DisassociateLinkRequest
  ): NetworkManagerIO[DisassociateLinkResponse] =
    FF.liftF(DisassociateLinkOp(request))

  def disassociateTransitGatewayConnectPeer(
    request: DisassociateTransitGatewayConnectPeerRequest
  ): NetworkManagerIO[DisassociateTransitGatewayConnectPeerResponse] =
    FF.liftF(DisassociateTransitGatewayConnectPeerOp(request))

  def getConnections(
    request: GetConnectionsRequest
  ): NetworkManagerIO[GetConnectionsResponse] =
    FF.liftF(GetConnectionsOp(request))

  def getCustomerGatewayAssociations(
    request: GetCustomerGatewayAssociationsRequest
  ): NetworkManagerIO[GetCustomerGatewayAssociationsResponse] =
    FF.liftF(GetCustomerGatewayAssociationsOp(request))

  def getDevices(
    request: GetDevicesRequest
  ): NetworkManagerIO[GetDevicesResponse] =
    FF.liftF(GetDevicesOp(request))

  def getLinkAssociations(
    request: GetLinkAssociationsRequest
  ): NetworkManagerIO[GetLinkAssociationsResponse] =
    FF.liftF(GetLinkAssociationsOp(request))

  def getLinks(
    request: GetLinksRequest
  ): NetworkManagerIO[GetLinksResponse] =
    FF.liftF(GetLinksOp(request))

  def getSites(
    request: GetSitesRequest
  ): NetworkManagerIO[GetSitesResponse] =
    FF.liftF(GetSitesOp(request))

  def getTransitGatewayConnectPeerAssociations(
    request: GetTransitGatewayConnectPeerAssociationsRequest
  ): NetworkManagerIO[GetTransitGatewayConnectPeerAssociationsResponse] =
    FF.liftF(GetTransitGatewayConnectPeerAssociationsOp(request))

  def getTransitGatewayRegistrations(
    request: GetTransitGatewayRegistrationsRequest
  ): NetworkManagerIO[GetTransitGatewayRegistrationsResponse] =
    FF.liftF(GetTransitGatewayRegistrationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): NetworkManagerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def registerTransitGateway(
    request: RegisterTransitGatewayRequest
  ): NetworkManagerIO[RegisterTransitGatewayResponse] =
    FF.liftF(RegisterTransitGatewayOp(request))

  def tagResource(
    request: TagResourceRequest
  ): NetworkManagerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): NetworkManagerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateConnection(
    request: UpdateConnectionRequest
  ): NetworkManagerIO[UpdateConnectionResponse] =
    FF.liftF(UpdateConnectionOp(request))

  def updateDevice(
    request: UpdateDeviceRequest
  ): NetworkManagerIO[UpdateDeviceResponse] =
    FF.liftF(UpdateDeviceOp(request))

  def updateGlobalNetwork(
    request: UpdateGlobalNetworkRequest
  ): NetworkManagerIO[UpdateGlobalNetworkResponse] =
    FF.liftF(UpdateGlobalNetworkOp(request))

  def updateLink(
    request: UpdateLinkRequest
  ): NetworkManagerIO[UpdateLinkResponse] =
    FF.liftF(UpdateLinkOp(request))

  def updateSite(
    request: UpdateSiteRequest
  ): NetworkManagerIO[UpdateSiteResponse] =
    FF.liftF(UpdateSiteOp(request))
}
