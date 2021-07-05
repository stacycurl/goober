package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.directconnect.DirectConnectClient
import software.amazon.awssdk.services.directconnect.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object directconnect { module =>

  // Free monad over DirectConnectOp
  type DirectConnectIO[A] = FF[DirectConnectOp, A]

  sealed trait DirectConnectOp[A] {
    def visit[F[_]](visitor: DirectConnectOp.Visitor[F]): F[A]
  }

  object DirectConnectOp {
    // Given a DirectConnectClient we can embed a DirectConnectIO program in any algebra that understands embedding.
    implicit val DirectConnectOpEmbeddable: Embeddable[DirectConnectOp, DirectConnectClient] = new Embeddable[DirectConnectOp, DirectConnectClient] {
      def embed[A](client: DirectConnectClient, io: DirectConnectIO[A]): Embedded[A] = Embedded.DirectConnect(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DirectConnectOp.Visitor[Kleisli[M, DirectConnectClient, *]] {
        def acceptDirectConnectGatewayAssociationProposal(
          request: AcceptDirectConnectGatewayAssociationProposalRequest
        ): Kleisli[M, DirectConnectClient, AcceptDirectConnectGatewayAssociationProposalResponse] =
          primitive(_.acceptDirectConnectGatewayAssociationProposal(request))

        def allocateHostedConnection(
          request: AllocateHostedConnectionRequest
        ): Kleisli[M, DirectConnectClient, AllocateHostedConnectionResponse] =
          primitive(_.allocateHostedConnection(request))

        def allocatePrivateVirtualInterface(
          request: AllocatePrivateVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, AllocatePrivateVirtualInterfaceResponse] =
          primitive(_.allocatePrivateVirtualInterface(request))

        def allocatePublicVirtualInterface(
          request: AllocatePublicVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, AllocatePublicVirtualInterfaceResponse] =
          primitive(_.allocatePublicVirtualInterface(request))

        def allocateTransitVirtualInterface(
          request: AllocateTransitVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, AllocateTransitVirtualInterfaceResponse] =
          primitive(_.allocateTransitVirtualInterface(request))

        def associateConnectionWithLag(
          request: AssociateConnectionWithLagRequest
        ): Kleisli[M, DirectConnectClient, AssociateConnectionWithLagResponse] =
          primitive(_.associateConnectionWithLag(request))

        def associateHostedConnection(
          request: AssociateHostedConnectionRequest
        ): Kleisli[M, DirectConnectClient, AssociateHostedConnectionResponse] =
          primitive(_.associateHostedConnection(request))

        def associateMacSecKey(
          request: AssociateMacSecKeyRequest
        ): Kleisli[M, DirectConnectClient, AssociateMacSecKeyResponse] =
          primitive(_.associateMacSecKey(request))

        def associateVirtualInterface(
          request: AssociateVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, AssociateVirtualInterfaceResponse] =
          primitive(_.associateVirtualInterface(request))

        def confirmConnection(
          request: ConfirmConnectionRequest
        ): Kleisli[M, DirectConnectClient, ConfirmConnectionResponse] =
          primitive(_.confirmConnection(request))

        def confirmPrivateVirtualInterface(
          request: ConfirmPrivateVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, ConfirmPrivateVirtualInterfaceResponse] =
          primitive(_.confirmPrivateVirtualInterface(request))

        def confirmPublicVirtualInterface(
          request: ConfirmPublicVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, ConfirmPublicVirtualInterfaceResponse] =
          primitive(_.confirmPublicVirtualInterface(request))

        def confirmTransitVirtualInterface(
          request: ConfirmTransitVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, ConfirmTransitVirtualInterfaceResponse] =
          primitive(_.confirmTransitVirtualInterface(request))

        def createBGPPeer(
          request: CreateBgpPeerRequest
        ): Kleisli[M, DirectConnectClient, CreateBgpPeerResponse] =
          primitive(_.createBGPPeer(request))

        def createConnection(
          request: CreateConnectionRequest
        ): Kleisli[M, DirectConnectClient, CreateConnectionResponse] =
          primitive(_.createConnection(request))

        def createDirectConnectGateway(
          request: CreateDirectConnectGatewayRequest
        ): Kleisli[M, DirectConnectClient, CreateDirectConnectGatewayResponse] =
          primitive(_.createDirectConnectGateway(request))

        def createDirectConnectGatewayAssociation(
          request: CreateDirectConnectGatewayAssociationRequest
        ): Kleisli[M, DirectConnectClient, CreateDirectConnectGatewayAssociationResponse] =
          primitive(_.createDirectConnectGatewayAssociation(request))

        def createDirectConnectGatewayAssociationProposal(
          request: CreateDirectConnectGatewayAssociationProposalRequest
        ): Kleisli[M, DirectConnectClient, CreateDirectConnectGatewayAssociationProposalResponse] =
          primitive(_.createDirectConnectGatewayAssociationProposal(request))

        def createInterconnect(
          request: CreateInterconnectRequest
        ): Kleisli[M, DirectConnectClient, CreateInterconnectResponse] =
          primitive(_.createInterconnect(request))

        def createLag(
          request: CreateLagRequest
        ): Kleisli[M, DirectConnectClient, CreateLagResponse] =
          primitive(_.createLag(request))

        def createPrivateVirtualInterface(
          request: CreatePrivateVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, CreatePrivateVirtualInterfaceResponse] =
          primitive(_.createPrivateVirtualInterface(request))

        def createPublicVirtualInterface(
          request: CreatePublicVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, CreatePublicVirtualInterfaceResponse] =
          primitive(_.createPublicVirtualInterface(request))

        def createTransitVirtualInterface(
          request: CreateTransitVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, CreateTransitVirtualInterfaceResponse] =
          primitive(_.createTransitVirtualInterface(request))

        def deleteBGPPeer(
          request: DeleteBgpPeerRequest
        ): Kleisli[M, DirectConnectClient, DeleteBgpPeerResponse] =
          primitive(_.deleteBGPPeer(request))

        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, DirectConnectClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def deleteDirectConnectGateway(
          request: DeleteDirectConnectGatewayRequest
        ): Kleisli[M, DirectConnectClient, DeleteDirectConnectGatewayResponse] =
          primitive(_.deleteDirectConnectGateway(request))

        def deleteDirectConnectGatewayAssociation(
          request: DeleteDirectConnectGatewayAssociationRequest
        ): Kleisli[M, DirectConnectClient, DeleteDirectConnectGatewayAssociationResponse] =
          primitive(_.deleteDirectConnectGatewayAssociation(request))

        def deleteDirectConnectGatewayAssociationProposal(
          request: DeleteDirectConnectGatewayAssociationProposalRequest
        ): Kleisli[M, DirectConnectClient, DeleteDirectConnectGatewayAssociationProposalResponse] =
          primitive(_.deleteDirectConnectGatewayAssociationProposal(request))

        def deleteInterconnect(
          request: DeleteInterconnectRequest
        ): Kleisli[M, DirectConnectClient, DeleteInterconnectResponse] =
          primitive(_.deleteInterconnect(request))

        def deleteLag(
          request: DeleteLagRequest
        ): Kleisli[M, DirectConnectClient, DeleteLagResponse] =
          primitive(_.deleteLag(request))

        def deleteVirtualInterface(
          request: DeleteVirtualInterfaceRequest
        ): Kleisli[M, DirectConnectClient, DeleteVirtualInterfaceResponse] =
          primitive(_.deleteVirtualInterface(request))

        def describeConnections(
          request: DescribeConnectionsRequest
        ): Kleisli[M, DirectConnectClient, DescribeConnectionsResponse] =
          primitive(_.describeConnections(request))

        def describeDirectConnectGatewayAssociationProposals(
          request: DescribeDirectConnectGatewayAssociationProposalsRequest
        ): Kleisli[M, DirectConnectClient, DescribeDirectConnectGatewayAssociationProposalsResponse] =
          primitive(_.describeDirectConnectGatewayAssociationProposals(request))

        def describeDirectConnectGatewayAssociations(
          request: DescribeDirectConnectGatewayAssociationsRequest
        ): Kleisli[M, DirectConnectClient, DescribeDirectConnectGatewayAssociationsResponse] =
          primitive(_.describeDirectConnectGatewayAssociations(request))

        def describeDirectConnectGatewayAttachments(
          request: DescribeDirectConnectGatewayAttachmentsRequest
        ): Kleisli[M, DirectConnectClient, DescribeDirectConnectGatewayAttachmentsResponse] =
          primitive(_.describeDirectConnectGatewayAttachments(request))

        def describeDirectConnectGateways(
          request: DescribeDirectConnectGatewaysRequest
        ): Kleisli[M, DirectConnectClient, DescribeDirectConnectGatewaysResponse] =
          primitive(_.describeDirectConnectGateways(request))

        def describeHostedConnections(
          request: DescribeHostedConnectionsRequest
        ): Kleisli[M, DirectConnectClient, DescribeHostedConnectionsResponse] =
          primitive(_.describeHostedConnections(request))

        def describeInterconnects(
          request: DescribeInterconnectsRequest
        ): Kleisli[M, DirectConnectClient, DescribeInterconnectsResponse] =
          primitive(_.describeInterconnects(request))

        def describeLags(
          request: DescribeLagsRequest
        ): Kleisli[M, DirectConnectClient, DescribeLagsResponse] =
          primitive(_.describeLags(request))

        def describeLoa(
          request: DescribeLoaRequest
        ): Kleisli[M, DirectConnectClient, DescribeLoaResponse] =
          primitive(_.describeLoa(request))

        def describeLocations(
          request: DescribeLocationsRequest
        ): Kleisli[M, DirectConnectClient, DescribeLocationsResponse] =
          primitive(_.describeLocations(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, DirectConnectClient, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def describeVirtualGateways(
          request: DescribeVirtualGatewaysRequest
        ): Kleisli[M, DirectConnectClient, DescribeVirtualGatewaysResponse] =
          primitive(_.describeVirtualGateways(request))

        def describeVirtualInterfaces(
          request: DescribeVirtualInterfacesRequest
        ): Kleisli[M, DirectConnectClient, DescribeVirtualInterfacesResponse] =
          primitive(_.describeVirtualInterfaces(request))

        def disassociateConnectionFromLag(
          request: DisassociateConnectionFromLagRequest
        ): Kleisli[M, DirectConnectClient, DisassociateConnectionFromLagResponse] =
          primitive(_.disassociateConnectionFromLag(request))

        def disassociateMacSecKey(
          request: DisassociateMacSecKeyRequest
        ): Kleisli[M, DirectConnectClient, DisassociateMacSecKeyResponse] =
          primitive(_.disassociateMacSecKey(request))

        def listVirtualInterfaceTestHistory(
          request: ListVirtualInterfaceTestHistoryRequest
        ): Kleisli[M, DirectConnectClient, ListVirtualInterfaceTestHistoryResponse] =
          primitive(_.listVirtualInterfaceTestHistory(request))

        def startBgpFailoverTest(
          request: StartBgpFailoverTestRequest
        ): Kleisli[M, DirectConnectClient, StartBgpFailoverTestResponse] =
          primitive(_.startBgpFailoverTest(request))

        def stopBgpFailoverTest(
          request: StopBgpFailoverTestRequest
        ): Kleisli[M, DirectConnectClient, StopBgpFailoverTestResponse] =
          primitive(_.stopBgpFailoverTest(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DirectConnectClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DirectConnectClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateConnection(
          request: UpdateConnectionRequest
        ): Kleisli[M, DirectConnectClient, UpdateConnectionResponse] =
          primitive(_.updateConnection(request))

        def updateDirectConnectGatewayAssociation(
          request: UpdateDirectConnectGatewayAssociationRequest
        ): Kleisli[M, DirectConnectClient, UpdateDirectConnectGatewayAssociationResponse] =
          primitive(_.updateDirectConnectGatewayAssociation(request))

        def updateLag(
          request: UpdateLagRequest
        ): Kleisli[M, DirectConnectClient, UpdateLagResponse] =
          primitive(_.updateLag(request))

        def updateVirtualInterfaceAttributes(
          request: UpdateVirtualInterfaceAttributesRequest
        ): Kleisli[M, DirectConnectClient, UpdateVirtualInterfaceAttributesResponse] =
          primitive(_.updateVirtualInterfaceAttributes(request))

        def primitive[A](
          f: DirectConnectClient => A
        ): Kleisli[M, DirectConnectClient, A]
      }
    }

    trait Visitor[F[_]] extends (DirectConnectOp ~> F) {
      final def apply[A](op: DirectConnectOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptDirectConnectGatewayAssociationProposal(
        request: AcceptDirectConnectGatewayAssociationProposalRequest
      ): F[AcceptDirectConnectGatewayAssociationProposalResponse]

      def allocateHostedConnection(
        request: AllocateHostedConnectionRequest
      ): F[AllocateHostedConnectionResponse]

      def allocatePrivateVirtualInterface(
        request: AllocatePrivateVirtualInterfaceRequest
      ): F[AllocatePrivateVirtualInterfaceResponse]

      def allocatePublicVirtualInterface(
        request: AllocatePublicVirtualInterfaceRequest
      ): F[AllocatePublicVirtualInterfaceResponse]

      def allocateTransitVirtualInterface(
        request: AllocateTransitVirtualInterfaceRequest
      ): F[AllocateTransitVirtualInterfaceResponse]

      def associateConnectionWithLag(
        request: AssociateConnectionWithLagRequest
      ): F[AssociateConnectionWithLagResponse]

      def associateHostedConnection(
        request: AssociateHostedConnectionRequest
      ): F[AssociateHostedConnectionResponse]

      def associateMacSecKey(
        request: AssociateMacSecKeyRequest
      ): F[AssociateMacSecKeyResponse]

      def associateVirtualInterface(
        request: AssociateVirtualInterfaceRequest
      ): F[AssociateVirtualInterfaceResponse]

      def confirmConnection(
        request: ConfirmConnectionRequest
      ): F[ConfirmConnectionResponse]

      def confirmPrivateVirtualInterface(
        request: ConfirmPrivateVirtualInterfaceRequest
      ): F[ConfirmPrivateVirtualInterfaceResponse]

      def confirmPublicVirtualInterface(
        request: ConfirmPublicVirtualInterfaceRequest
      ): F[ConfirmPublicVirtualInterfaceResponse]

      def confirmTransitVirtualInterface(
        request: ConfirmTransitVirtualInterfaceRequest
      ): F[ConfirmTransitVirtualInterfaceResponse]

      def createBGPPeer(
        request: CreateBgpPeerRequest
      ): F[CreateBgpPeerResponse]

      def createConnection(
        request: CreateConnectionRequest
      ): F[CreateConnectionResponse]

      def createDirectConnectGateway(
        request: CreateDirectConnectGatewayRequest
      ): F[CreateDirectConnectGatewayResponse]

      def createDirectConnectGatewayAssociation(
        request: CreateDirectConnectGatewayAssociationRequest
      ): F[CreateDirectConnectGatewayAssociationResponse]

      def createDirectConnectGatewayAssociationProposal(
        request: CreateDirectConnectGatewayAssociationProposalRequest
      ): F[CreateDirectConnectGatewayAssociationProposalResponse]

      def createInterconnect(
        request: CreateInterconnectRequest
      ): F[CreateInterconnectResponse]

      def createLag(
        request: CreateLagRequest
      ): F[CreateLagResponse]

      def createPrivateVirtualInterface(
        request: CreatePrivateVirtualInterfaceRequest
      ): F[CreatePrivateVirtualInterfaceResponse]

      def createPublicVirtualInterface(
        request: CreatePublicVirtualInterfaceRequest
      ): F[CreatePublicVirtualInterfaceResponse]

      def createTransitVirtualInterface(
        request: CreateTransitVirtualInterfaceRequest
      ): F[CreateTransitVirtualInterfaceResponse]

      def deleteBGPPeer(
        request: DeleteBgpPeerRequest
      ): F[DeleteBgpPeerResponse]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def deleteDirectConnectGateway(
        request: DeleteDirectConnectGatewayRequest
      ): F[DeleteDirectConnectGatewayResponse]

      def deleteDirectConnectGatewayAssociation(
        request: DeleteDirectConnectGatewayAssociationRequest
      ): F[DeleteDirectConnectGatewayAssociationResponse]

      def deleteDirectConnectGatewayAssociationProposal(
        request: DeleteDirectConnectGatewayAssociationProposalRequest
      ): F[DeleteDirectConnectGatewayAssociationProposalResponse]

      def deleteInterconnect(
        request: DeleteInterconnectRequest
      ): F[DeleteInterconnectResponse]

      def deleteLag(
        request: DeleteLagRequest
      ): F[DeleteLagResponse]

      def deleteVirtualInterface(
        request: DeleteVirtualInterfaceRequest
      ): F[DeleteVirtualInterfaceResponse]

      def describeConnections(
        request: DescribeConnectionsRequest
      ): F[DescribeConnectionsResponse]

      def describeDirectConnectGatewayAssociationProposals(
        request: DescribeDirectConnectGatewayAssociationProposalsRequest
      ): F[DescribeDirectConnectGatewayAssociationProposalsResponse]

      def describeDirectConnectGatewayAssociations(
        request: DescribeDirectConnectGatewayAssociationsRequest
      ): F[DescribeDirectConnectGatewayAssociationsResponse]

      def describeDirectConnectGatewayAttachments(
        request: DescribeDirectConnectGatewayAttachmentsRequest
      ): F[DescribeDirectConnectGatewayAttachmentsResponse]

      def describeDirectConnectGateways(
        request: DescribeDirectConnectGatewaysRequest
      ): F[DescribeDirectConnectGatewaysResponse]

      def describeHostedConnections(
        request: DescribeHostedConnectionsRequest
      ): F[DescribeHostedConnectionsResponse]

      def describeInterconnects(
        request: DescribeInterconnectsRequest
      ): F[DescribeInterconnectsResponse]

      def describeLags(
        request: DescribeLagsRequest
      ): F[DescribeLagsResponse]

      def describeLoa(
        request: DescribeLoaRequest
      ): F[DescribeLoaResponse]

      def describeLocations(
        request: DescribeLocationsRequest
      ): F[DescribeLocationsResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def describeVirtualGateways(
        request: DescribeVirtualGatewaysRequest
      ): F[DescribeVirtualGatewaysResponse]

      def describeVirtualInterfaces(
        request: DescribeVirtualInterfacesRequest
      ): F[DescribeVirtualInterfacesResponse]

      def disassociateConnectionFromLag(
        request: DisassociateConnectionFromLagRequest
      ): F[DisassociateConnectionFromLagResponse]

      def disassociateMacSecKey(
        request: DisassociateMacSecKeyRequest
      ): F[DisassociateMacSecKeyResponse]

      def listVirtualInterfaceTestHistory(
        request: ListVirtualInterfaceTestHistoryRequest
      ): F[ListVirtualInterfaceTestHistoryResponse]

      def startBgpFailoverTest(
        request: StartBgpFailoverTestRequest
      ): F[StartBgpFailoverTestResponse]

      def stopBgpFailoverTest(
        request: StopBgpFailoverTestRequest
      ): F[StopBgpFailoverTestResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateConnection(
        request: UpdateConnectionRequest
      ): F[UpdateConnectionResponse]

      def updateDirectConnectGatewayAssociation(
        request: UpdateDirectConnectGatewayAssociationRequest
      ): F[UpdateDirectConnectGatewayAssociationResponse]

      def updateLag(
        request: UpdateLagRequest
      ): F[UpdateLagResponse]

      def updateVirtualInterfaceAttributes(
        request: UpdateVirtualInterfaceAttributesRequest
      ): F[UpdateVirtualInterfaceAttributesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DirectConnectOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptDirectConnectGatewayAssociationProposalOp(
      request: AcceptDirectConnectGatewayAssociationProposalRequest
    ) extends DirectConnectOp[AcceptDirectConnectGatewayAssociationProposalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptDirectConnectGatewayAssociationProposalResponse] =
        visitor.acceptDirectConnectGatewayAssociationProposal(request)
    }

    final case class AllocateHostedConnectionOp(
      request: AllocateHostedConnectionRequest
    ) extends DirectConnectOp[AllocateHostedConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllocateHostedConnectionResponse] =
        visitor.allocateHostedConnection(request)
    }

    final case class AllocatePrivateVirtualInterfaceOp(
      request: AllocatePrivateVirtualInterfaceRequest
    ) extends DirectConnectOp[AllocatePrivateVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllocatePrivateVirtualInterfaceResponse] =
        visitor.allocatePrivateVirtualInterface(request)
    }

    final case class AllocatePublicVirtualInterfaceOp(
      request: AllocatePublicVirtualInterfaceRequest
    ) extends DirectConnectOp[AllocatePublicVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllocatePublicVirtualInterfaceResponse] =
        visitor.allocatePublicVirtualInterface(request)
    }

    final case class AllocateTransitVirtualInterfaceOp(
      request: AllocateTransitVirtualInterfaceRequest
    ) extends DirectConnectOp[AllocateTransitVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllocateTransitVirtualInterfaceResponse] =
        visitor.allocateTransitVirtualInterface(request)
    }

    final case class AssociateConnectionWithLagOp(
      request: AssociateConnectionWithLagRequest
    ) extends DirectConnectOp[AssociateConnectionWithLagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateConnectionWithLagResponse] =
        visitor.associateConnectionWithLag(request)
    }

    final case class AssociateHostedConnectionOp(
      request: AssociateHostedConnectionRequest
    ) extends DirectConnectOp[AssociateHostedConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateHostedConnectionResponse] =
        visitor.associateHostedConnection(request)
    }

    final case class AssociateMacSecKeyOp(
      request: AssociateMacSecKeyRequest
    ) extends DirectConnectOp[AssociateMacSecKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateMacSecKeyResponse] =
        visitor.associateMacSecKey(request)
    }

    final case class AssociateVirtualInterfaceOp(
      request: AssociateVirtualInterfaceRequest
    ) extends DirectConnectOp[AssociateVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateVirtualInterfaceResponse] =
        visitor.associateVirtualInterface(request)
    }

    final case class ConfirmConnectionOp(
      request: ConfirmConnectionRequest
    ) extends DirectConnectOp[ConfirmConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmConnectionResponse] =
        visitor.confirmConnection(request)
    }

    final case class ConfirmPrivateVirtualInterfaceOp(
      request: ConfirmPrivateVirtualInterfaceRequest
    ) extends DirectConnectOp[ConfirmPrivateVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmPrivateVirtualInterfaceResponse] =
        visitor.confirmPrivateVirtualInterface(request)
    }

    final case class ConfirmPublicVirtualInterfaceOp(
      request: ConfirmPublicVirtualInterfaceRequest
    ) extends DirectConnectOp[ConfirmPublicVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmPublicVirtualInterfaceResponse] =
        visitor.confirmPublicVirtualInterface(request)
    }

    final case class ConfirmTransitVirtualInterfaceOp(
      request: ConfirmTransitVirtualInterfaceRequest
    ) extends DirectConnectOp[ConfirmTransitVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmTransitVirtualInterfaceResponse] =
        visitor.confirmTransitVirtualInterface(request)
    }

    final case class CreateBGPPeerOp(
      request: CreateBgpPeerRequest
    ) extends DirectConnectOp[CreateBgpPeerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBgpPeerResponse] =
        visitor.createBGPPeer(request)
    }

    final case class CreateConnectionOp(
      request: CreateConnectionRequest
    ) extends DirectConnectOp[CreateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectionResponse] =
        visitor.createConnection(request)
    }

    final case class CreateDirectConnectGatewayOp(
      request: CreateDirectConnectGatewayRequest
    ) extends DirectConnectOp[CreateDirectConnectGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDirectConnectGatewayResponse] =
        visitor.createDirectConnectGateway(request)
    }

    final case class CreateDirectConnectGatewayAssociationOp(
      request: CreateDirectConnectGatewayAssociationRequest
    ) extends DirectConnectOp[CreateDirectConnectGatewayAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDirectConnectGatewayAssociationResponse] =
        visitor.createDirectConnectGatewayAssociation(request)
    }

    final case class CreateDirectConnectGatewayAssociationProposalOp(
      request: CreateDirectConnectGatewayAssociationProposalRequest
    ) extends DirectConnectOp[CreateDirectConnectGatewayAssociationProposalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDirectConnectGatewayAssociationProposalResponse] =
        visitor.createDirectConnectGatewayAssociationProposal(request)
    }

    final case class CreateInterconnectOp(
      request: CreateInterconnectRequest
    ) extends DirectConnectOp[CreateInterconnectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInterconnectResponse] =
        visitor.createInterconnect(request)
    }

    final case class CreateLagOp(
      request: CreateLagRequest
    ) extends DirectConnectOp[CreateLagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLagResponse] =
        visitor.createLag(request)
    }

    final case class CreatePrivateVirtualInterfaceOp(
      request: CreatePrivateVirtualInterfaceRequest
    ) extends DirectConnectOp[CreatePrivateVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePrivateVirtualInterfaceResponse] =
        visitor.createPrivateVirtualInterface(request)
    }

    final case class CreatePublicVirtualInterfaceOp(
      request: CreatePublicVirtualInterfaceRequest
    ) extends DirectConnectOp[CreatePublicVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePublicVirtualInterfaceResponse] =
        visitor.createPublicVirtualInterface(request)
    }

    final case class CreateTransitVirtualInterfaceOp(
      request: CreateTransitVirtualInterfaceRequest
    ) extends DirectConnectOp[CreateTransitVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransitVirtualInterfaceResponse] =
        visitor.createTransitVirtualInterface(request)
    }

    final case class DeleteBGPPeerOp(
      request: DeleteBgpPeerRequest
    ) extends DirectConnectOp[DeleteBgpPeerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBgpPeerResponse] =
        visitor.deleteBGPPeer(request)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends DirectConnectOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class DeleteDirectConnectGatewayOp(
      request: DeleteDirectConnectGatewayRequest
    ) extends DirectConnectOp[DeleteDirectConnectGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDirectConnectGatewayResponse] =
        visitor.deleteDirectConnectGateway(request)
    }

    final case class DeleteDirectConnectGatewayAssociationOp(
      request: DeleteDirectConnectGatewayAssociationRequest
    ) extends DirectConnectOp[DeleteDirectConnectGatewayAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDirectConnectGatewayAssociationResponse] =
        visitor.deleteDirectConnectGatewayAssociation(request)
    }

    final case class DeleteDirectConnectGatewayAssociationProposalOp(
      request: DeleteDirectConnectGatewayAssociationProposalRequest
    ) extends DirectConnectOp[DeleteDirectConnectGatewayAssociationProposalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDirectConnectGatewayAssociationProposalResponse] =
        visitor.deleteDirectConnectGatewayAssociationProposal(request)
    }

    final case class DeleteInterconnectOp(
      request: DeleteInterconnectRequest
    ) extends DirectConnectOp[DeleteInterconnectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInterconnectResponse] =
        visitor.deleteInterconnect(request)
    }

    final case class DeleteLagOp(
      request: DeleteLagRequest
    ) extends DirectConnectOp[DeleteLagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLagResponse] =
        visitor.deleteLag(request)
    }

    final case class DeleteVirtualInterfaceOp(
      request: DeleteVirtualInterfaceRequest
    ) extends DirectConnectOp[DeleteVirtualInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVirtualInterfaceResponse] =
        visitor.deleteVirtualInterface(request)
    }

    final case class DescribeConnectionsOp(
      request: DescribeConnectionsRequest
    ) extends DirectConnectOp[DescribeConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectionsResponse] =
        visitor.describeConnections(request)
    }

    final case class DescribeDirectConnectGatewayAssociationProposalsOp(
      request: DescribeDirectConnectGatewayAssociationProposalsRequest
    ) extends DirectConnectOp[DescribeDirectConnectGatewayAssociationProposalsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDirectConnectGatewayAssociationProposalsResponse] =
        visitor.describeDirectConnectGatewayAssociationProposals(request)
    }

    final case class DescribeDirectConnectGatewayAssociationsOp(
      request: DescribeDirectConnectGatewayAssociationsRequest
    ) extends DirectConnectOp[DescribeDirectConnectGatewayAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDirectConnectGatewayAssociationsResponse] =
        visitor.describeDirectConnectGatewayAssociations(request)
    }

    final case class DescribeDirectConnectGatewayAttachmentsOp(
      request: DescribeDirectConnectGatewayAttachmentsRequest
    ) extends DirectConnectOp[DescribeDirectConnectGatewayAttachmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDirectConnectGatewayAttachmentsResponse] =
        visitor.describeDirectConnectGatewayAttachments(request)
    }

    final case class DescribeDirectConnectGatewaysOp(
      request: DescribeDirectConnectGatewaysRequest
    ) extends DirectConnectOp[DescribeDirectConnectGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDirectConnectGatewaysResponse] =
        visitor.describeDirectConnectGateways(request)
    }

    final case class DescribeHostedConnectionsOp(
      request: DescribeHostedConnectionsRequest
    ) extends DirectConnectOp[DescribeHostedConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHostedConnectionsResponse] =
        visitor.describeHostedConnections(request)
    }

    final case class DescribeInterconnectsOp(
      request: DescribeInterconnectsRequest
    ) extends DirectConnectOp[DescribeInterconnectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInterconnectsResponse] =
        visitor.describeInterconnects(request)
    }

    final case class DescribeLagsOp(
      request: DescribeLagsRequest
    ) extends DirectConnectOp[DescribeLagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLagsResponse] =
        visitor.describeLags(request)
    }

    final case class DescribeLoaOp(
      request: DescribeLoaRequest
    ) extends DirectConnectOp[DescribeLoaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoaResponse] =
        visitor.describeLoa(request)
    }

    final case class DescribeLocationsOp(
      request: DescribeLocationsRequest
    ) extends DirectConnectOp[DescribeLocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocationsResponse] =
        visitor.describeLocations(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends DirectConnectOp[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DescribeVirtualGatewaysOp(
      request: DescribeVirtualGatewaysRequest
    ) extends DirectConnectOp[DescribeVirtualGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVirtualGatewaysResponse] =
        visitor.describeVirtualGateways(request)
    }

    final case class DescribeVirtualInterfacesOp(
      request: DescribeVirtualInterfacesRequest
    ) extends DirectConnectOp[DescribeVirtualInterfacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVirtualInterfacesResponse] =
        visitor.describeVirtualInterfaces(request)
    }

    final case class DisassociateConnectionFromLagOp(
      request: DisassociateConnectionFromLagRequest
    ) extends DirectConnectOp[DisassociateConnectionFromLagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateConnectionFromLagResponse] =
        visitor.disassociateConnectionFromLag(request)
    }

    final case class DisassociateMacSecKeyOp(
      request: DisassociateMacSecKeyRequest
    ) extends DirectConnectOp[DisassociateMacSecKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateMacSecKeyResponse] =
        visitor.disassociateMacSecKey(request)
    }

    final case class ListVirtualInterfaceTestHistoryOp(
      request: ListVirtualInterfaceTestHistoryRequest
    ) extends DirectConnectOp[ListVirtualInterfaceTestHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVirtualInterfaceTestHistoryResponse] =
        visitor.listVirtualInterfaceTestHistory(request)
    }

    final case class StartBgpFailoverTestOp(
      request: StartBgpFailoverTestRequest
    ) extends DirectConnectOp[StartBgpFailoverTestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartBgpFailoverTestResponse] =
        visitor.startBgpFailoverTest(request)
    }

    final case class StopBgpFailoverTestOp(
      request: StopBgpFailoverTestRequest
    ) extends DirectConnectOp[StopBgpFailoverTestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopBgpFailoverTestResponse] =
        visitor.stopBgpFailoverTest(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DirectConnectOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DirectConnectOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateConnectionOp(
      request: UpdateConnectionRequest
    ) extends DirectConnectOp[UpdateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectionResponse] =
        visitor.updateConnection(request)
    }

    final case class UpdateDirectConnectGatewayAssociationOp(
      request: UpdateDirectConnectGatewayAssociationRequest
    ) extends DirectConnectOp[UpdateDirectConnectGatewayAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDirectConnectGatewayAssociationResponse] =
        visitor.updateDirectConnectGatewayAssociation(request)
    }

    final case class UpdateLagOp(
      request: UpdateLagRequest
    ) extends DirectConnectOp[UpdateLagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLagResponse] =
        visitor.updateLag(request)
    }

    final case class UpdateVirtualInterfaceAttributesOp(
      request: UpdateVirtualInterfaceAttributesRequest
    ) extends DirectConnectOp[UpdateVirtualInterfaceAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVirtualInterfaceAttributesResponse] =
        visitor.updateVirtualInterfaceAttributes(request)
    }
  }

  import DirectConnectOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DirectConnectOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptDirectConnectGatewayAssociationProposal(
    request: AcceptDirectConnectGatewayAssociationProposalRequest
  ): DirectConnectIO[AcceptDirectConnectGatewayAssociationProposalResponse] =
    FF.liftF(AcceptDirectConnectGatewayAssociationProposalOp(request))

  def allocateHostedConnection(
    request: AllocateHostedConnectionRequest
  ): DirectConnectIO[AllocateHostedConnectionResponse] =
    FF.liftF(AllocateHostedConnectionOp(request))

  def allocatePrivateVirtualInterface(
    request: AllocatePrivateVirtualInterfaceRequest
  ): DirectConnectIO[AllocatePrivateVirtualInterfaceResponse] =
    FF.liftF(AllocatePrivateVirtualInterfaceOp(request))

  def allocatePublicVirtualInterface(
    request: AllocatePublicVirtualInterfaceRequest
  ): DirectConnectIO[AllocatePublicVirtualInterfaceResponse] =
    FF.liftF(AllocatePublicVirtualInterfaceOp(request))

  def allocateTransitVirtualInterface(
    request: AllocateTransitVirtualInterfaceRequest
  ): DirectConnectIO[AllocateTransitVirtualInterfaceResponse] =
    FF.liftF(AllocateTransitVirtualInterfaceOp(request))

  def associateConnectionWithLag(
    request: AssociateConnectionWithLagRequest
  ): DirectConnectIO[AssociateConnectionWithLagResponse] =
    FF.liftF(AssociateConnectionWithLagOp(request))

  def associateHostedConnection(
    request: AssociateHostedConnectionRequest
  ): DirectConnectIO[AssociateHostedConnectionResponse] =
    FF.liftF(AssociateHostedConnectionOp(request))

  def associateMacSecKey(
    request: AssociateMacSecKeyRequest
  ): DirectConnectIO[AssociateMacSecKeyResponse] =
    FF.liftF(AssociateMacSecKeyOp(request))

  def associateVirtualInterface(
    request: AssociateVirtualInterfaceRequest
  ): DirectConnectIO[AssociateVirtualInterfaceResponse] =
    FF.liftF(AssociateVirtualInterfaceOp(request))

  def confirmConnection(
    request: ConfirmConnectionRequest
  ): DirectConnectIO[ConfirmConnectionResponse] =
    FF.liftF(ConfirmConnectionOp(request))

  def confirmPrivateVirtualInterface(
    request: ConfirmPrivateVirtualInterfaceRequest
  ): DirectConnectIO[ConfirmPrivateVirtualInterfaceResponse] =
    FF.liftF(ConfirmPrivateVirtualInterfaceOp(request))

  def confirmPublicVirtualInterface(
    request: ConfirmPublicVirtualInterfaceRequest
  ): DirectConnectIO[ConfirmPublicVirtualInterfaceResponse] =
    FF.liftF(ConfirmPublicVirtualInterfaceOp(request))

  def confirmTransitVirtualInterface(
    request: ConfirmTransitVirtualInterfaceRequest
  ): DirectConnectIO[ConfirmTransitVirtualInterfaceResponse] =
    FF.liftF(ConfirmTransitVirtualInterfaceOp(request))

  def createBGPPeer(
    request: CreateBgpPeerRequest
  ): DirectConnectIO[CreateBgpPeerResponse] =
    FF.liftF(CreateBGPPeerOp(request))

  def createConnection(
    request: CreateConnectionRequest
  ): DirectConnectIO[CreateConnectionResponse] =
    FF.liftF(CreateConnectionOp(request))

  def createDirectConnectGateway(
    request: CreateDirectConnectGatewayRequest
  ): DirectConnectIO[CreateDirectConnectGatewayResponse] =
    FF.liftF(CreateDirectConnectGatewayOp(request))

  def createDirectConnectGatewayAssociation(
    request: CreateDirectConnectGatewayAssociationRequest
  ): DirectConnectIO[CreateDirectConnectGatewayAssociationResponse] =
    FF.liftF(CreateDirectConnectGatewayAssociationOp(request))

  def createDirectConnectGatewayAssociationProposal(
    request: CreateDirectConnectGatewayAssociationProposalRequest
  ): DirectConnectIO[CreateDirectConnectGatewayAssociationProposalResponse] =
    FF.liftF(CreateDirectConnectGatewayAssociationProposalOp(request))

  def createInterconnect(
    request: CreateInterconnectRequest
  ): DirectConnectIO[CreateInterconnectResponse] =
    FF.liftF(CreateInterconnectOp(request))

  def createLag(
    request: CreateLagRequest
  ): DirectConnectIO[CreateLagResponse] =
    FF.liftF(CreateLagOp(request))

  def createPrivateVirtualInterface(
    request: CreatePrivateVirtualInterfaceRequest
  ): DirectConnectIO[CreatePrivateVirtualInterfaceResponse] =
    FF.liftF(CreatePrivateVirtualInterfaceOp(request))

  def createPublicVirtualInterface(
    request: CreatePublicVirtualInterfaceRequest
  ): DirectConnectIO[CreatePublicVirtualInterfaceResponse] =
    FF.liftF(CreatePublicVirtualInterfaceOp(request))

  def createTransitVirtualInterface(
    request: CreateTransitVirtualInterfaceRequest
  ): DirectConnectIO[CreateTransitVirtualInterfaceResponse] =
    FF.liftF(CreateTransitVirtualInterfaceOp(request))

  def deleteBGPPeer(
    request: DeleteBgpPeerRequest
  ): DirectConnectIO[DeleteBgpPeerResponse] =
    FF.liftF(DeleteBGPPeerOp(request))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): DirectConnectIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def deleteDirectConnectGateway(
    request: DeleteDirectConnectGatewayRequest
  ): DirectConnectIO[DeleteDirectConnectGatewayResponse] =
    FF.liftF(DeleteDirectConnectGatewayOp(request))

  def deleteDirectConnectGatewayAssociation(
    request: DeleteDirectConnectGatewayAssociationRequest
  ): DirectConnectIO[DeleteDirectConnectGatewayAssociationResponse] =
    FF.liftF(DeleteDirectConnectGatewayAssociationOp(request))

  def deleteDirectConnectGatewayAssociationProposal(
    request: DeleteDirectConnectGatewayAssociationProposalRequest
  ): DirectConnectIO[DeleteDirectConnectGatewayAssociationProposalResponse] =
    FF.liftF(DeleteDirectConnectGatewayAssociationProposalOp(request))

  def deleteInterconnect(
    request: DeleteInterconnectRequest
  ): DirectConnectIO[DeleteInterconnectResponse] =
    FF.liftF(DeleteInterconnectOp(request))

  def deleteLag(
    request: DeleteLagRequest
  ): DirectConnectIO[DeleteLagResponse] =
    FF.liftF(DeleteLagOp(request))

  def deleteVirtualInterface(
    request: DeleteVirtualInterfaceRequest
  ): DirectConnectIO[DeleteVirtualInterfaceResponse] =
    FF.liftF(DeleteVirtualInterfaceOp(request))

  def describeConnections(
    request: DescribeConnectionsRequest
  ): DirectConnectIO[DescribeConnectionsResponse] =
    FF.liftF(DescribeConnectionsOp(request))

  def describeDirectConnectGatewayAssociationProposals(
    request: DescribeDirectConnectGatewayAssociationProposalsRequest
  ): DirectConnectIO[DescribeDirectConnectGatewayAssociationProposalsResponse] =
    FF.liftF(DescribeDirectConnectGatewayAssociationProposalsOp(request))

  def describeDirectConnectGatewayAssociations(
    request: DescribeDirectConnectGatewayAssociationsRequest
  ): DirectConnectIO[DescribeDirectConnectGatewayAssociationsResponse] =
    FF.liftF(DescribeDirectConnectGatewayAssociationsOp(request))

  def describeDirectConnectGatewayAttachments(
    request: DescribeDirectConnectGatewayAttachmentsRequest
  ): DirectConnectIO[DescribeDirectConnectGatewayAttachmentsResponse] =
    FF.liftF(DescribeDirectConnectGatewayAttachmentsOp(request))

  def describeDirectConnectGateways(
    request: DescribeDirectConnectGatewaysRequest
  ): DirectConnectIO[DescribeDirectConnectGatewaysResponse] =
    FF.liftF(DescribeDirectConnectGatewaysOp(request))

  def describeHostedConnections(
    request: DescribeHostedConnectionsRequest
  ): DirectConnectIO[DescribeHostedConnectionsResponse] =
    FF.liftF(DescribeHostedConnectionsOp(request))

  def describeInterconnects(
    request: DescribeInterconnectsRequest
  ): DirectConnectIO[DescribeInterconnectsResponse] =
    FF.liftF(DescribeInterconnectsOp(request))

  def describeLags(
    request: DescribeLagsRequest
  ): DirectConnectIO[DescribeLagsResponse] =
    FF.liftF(DescribeLagsOp(request))

  def describeLoa(
    request: DescribeLoaRequest
  ): DirectConnectIO[DescribeLoaResponse] =
    FF.liftF(DescribeLoaOp(request))

  def describeLocations(
    request: DescribeLocationsRequest
  ): DirectConnectIO[DescribeLocationsResponse] =
    FF.liftF(DescribeLocationsOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): DirectConnectIO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def describeVirtualGateways(
    request: DescribeVirtualGatewaysRequest
  ): DirectConnectIO[DescribeVirtualGatewaysResponse] =
    FF.liftF(DescribeVirtualGatewaysOp(request))

  def describeVirtualInterfaces(
    request: DescribeVirtualInterfacesRequest
  ): DirectConnectIO[DescribeVirtualInterfacesResponse] =
    FF.liftF(DescribeVirtualInterfacesOp(request))

  def disassociateConnectionFromLag(
    request: DisassociateConnectionFromLagRequest
  ): DirectConnectIO[DisassociateConnectionFromLagResponse] =
    FF.liftF(DisassociateConnectionFromLagOp(request))

  def disassociateMacSecKey(
    request: DisassociateMacSecKeyRequest
  ): DirectConnectIO[DisassociateMacSecKeyResponse] =
    FF.liftF(DisassociateMacSecKeyOp(request))

  def listVirtualInterfaceTestHistory(
    request: ListVirtualInterfaceTestHistoryRequest
  ): DirectConnectIO[ListVirtualInterfaceTestHistoryResponse] =
    FF.liftF(ListVirtualInterfaceTestHistoryOp(request))

  def startBgpFailoverTest(
    request: StartBgpFailoverTestRequest
  ): DirectConnectIO[StartBgpFailoverTestResponse] =
    FF.liftF(StartBgpFailoverTestOp(request))

  def stopBgpFailoverTest(
    request: StopBgpFailoverTestRequest
  ): DirectConnectIO[StopBgpFailoverTestResponse] =
    FF.liftF(StopBgpFailoverTestOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DirectConnectIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DirectConnectIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateConnection(
    request: UpdateConnectionRequest
  ): DirectConnectIO[UpdateConnectionResponse] =
    FF.liftF(UpdateConnectionOp(request))

  def updateDirectConnectGatewayAssociation(
    request: UpdateDirectConnectGatewayAssociationRequest
  ): DirectConnectIO[UpdateDirectConnectGatewayAssociationResponse] =
    FF.liftF(UpdateDirectConnectGatewayAssociationOp(request))

  def updateLag(
    request: UpdateLagRequest
  ): DirectConnectIO[UpdateLagResponse] =
    FF.liftF(UpdateLagOp(request))

  def updateVirtualInterfaceAttributes(
    request: UpdateVirtualInterfaceAttributesRequest
  ): DirectConnectIO[UpdateVirtualInterfaceAttributesResponse] =
    FF.liftF(UpdateVirtualInterfaceAttributesOp(request))
}
