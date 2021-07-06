package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mediaconnect.MediaConnectClient
import software.amazon.awssdk.services.mediaconnect.model._


object mediaconnect { module =>

  // Free monad over MediaConnectOp
  type MediaConnectIO[A] = FF[MediaConnectOp, A]

  sealed trait MediaConnectOp[A] {
    def visit[F[_]](visitor: MediaConnectOp.Visitor[F]): F[A]
  }

  object MediaConnectOp {
    // Given a MediaConnectClient we can embed a MediaConnectIO program in any algebra that understands embedding.
    implicit val MediaConnectOpEmbeddable: Embeddable[MediaConnectOp, MediaConnectClient] = new Embeddable[MediaConnectOp, MediaConnectClient] {
      def embed[A](client: MediaConnectClient, io: MediaConnectIO[A]): Embedded[A] = Embedded.MediaConnect(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaConnectOp.Visitor[Kleisli[M, MediaConnectClient, *]] {
        def addFlowMediaStreams(
          request: AddFlowMediaStreamsRequest
        ): Kleisli[M, MediaConnectClient, AddFlowMediaStreamsResponse] =
          primitive(_.addFlowMediaStreams(request))

        def addFlowOutputs(
          request: AddFlowOutputsRequest
        ): Kleisli[M, MediaConnectClient, AddFlowOutputsResponse] =
          primitive(_.addFlowOutputs(request))

        def addFlowSources(
          request: AddFlowSourcesRequest
        ): Kleisli[M, MediaConnectClient, AddFlowSourcesResponse] =
          primitive(_.addFlowSources(request))

        def addFlowVpcInterfaces(
          request: AddFlowVpcInterfacesRequest
        ): Kleisli[M, MediaConnectClient, AddFlowVpcInterfacesResponse] =
          primitive(_.addFlowVpcInterfaces(request))

        def createFlow(
          request: CreateFlowRequest
        ): Kleisli[M, MediaConnectClient, CreateFlowResponse] =
          primitive(_.createFlow(request))

        def deleteFlow(
          request: DeleteFlowRequest
        ): Kleisli[M, MediaConnectClient, DeleteFlowResponse] =
          primitive(_.deleteFlow(request))

        def describeFlow(
          request: DescribeFlowRequest
        ): Kleisli[M, MediaConnectClient, DescribeFlowResponse] =
          primitive(_.describeFlow(request))

        def describeOffering(
          request: DescribeOfferingRequest
        ): Kleisli[M, MediaConnectClient, DescribeOfferingResponse] =
          primitive(_.describeOffering(request))

        def describeReservation(
          request: DescribeReservationRequest
        ): Kleisli[M, MediaConnectClient, DescribeReservationResponse] =
          primitive(_.describeReservation(request))

        def grantFlowEntitlements(
          request: GrantFlowEntitlementsRequest
        ): Kleisli[M, MediaConnectClient, GrantFlowEntitlementsResponse] =
          primitive(_.grantFlowEntitlements(request))

        def listEntitlements(
          request: ListEntitlementsRequest
        ): Kleisli[M, MediaConnectClient, ListEntitlementsResponse] =
          primitive(_.listEntitlements(request))

        def listFlows(
          request: ListFlowsRequest
        ): Kleisli[M, MediaConnectClient, ListFlowsResponse] =
          primitive(_.listFlows(request))

        def listOfferings(
          request: ListOfferingsRequest
        ): Kleisli[M, MediaConnectClient, ListOfferingsResponse] =
          primitive(_.listOfferings(request))

        def listReservations(
          request: ListReservationsRequest
        ): Kleisli[M, MediaConnectClient, ListReservationsResponse] =
          primitive(_.listReservations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MediaConnectClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def purchaseOffering(
          request: PurchaseOfferingRequest
        ): Kleisli[M, MediaConnectClient, PurchaseOfferingResponse] =
          primitive(_.purchaseOffering(request))

        def removeFlowMediaStream(
          request: RemoveFlowMediaStreamRequest
        ): Kleisli[M, MediaConnectClient, RemoveFlowMediaStreamResponse] =
          primitive(_.removeFlowMediaStream(request))

        def removeFlowOutput(
          request: RemoveFlowOutputRequest
        ): Kleisli[M, MediaConnectClient, RemoveFlowOutputResponse] =
          primitive(_.removeFlowOutput(request))

        def removeFlowSource(
          request: RemoveFlowSourceRequest
        ): Kleisli[M, MediaConnectClient, RemoveFlowSourceResponse] =
          primitive(_.removeFlowSource(request))

        def removeFlowVpcInterface(
          request: RemoveFlowVpcInterfaceRequest
        ): Kleisli[M, MediaConnectClient, RemoveFlowVpcInterfaceResponse] =
          primitive(_.removeFlowVpcInterface(request))

        def revokeFlowEntitlement(
          request: RevokeFlowEntitlementRequest
        ): Kleisli[M, MediaConnectClient, RevokeFlowEntitlementResponse] =
          primitive(_.revokeFlowEntitlement(request))

        def startFlow(
          request: StartFlowRequest
        ): Kleisli[M, MediaConnectClient, StartFlowResponse] =
          primitive(_.startFlow(request))

        def stopFlow(
          request: StopFlowRequest
        ): Kleisli[M, MediaConnectClient, StopFlowResponse] =
          primitive(_.stopFlow(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MediaConnectClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MediaConnectClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateFlow(
          request: UpdateFlowRequest
        ): Kleisli[M, MediaConnectClient, UpdateFlowResponse] =
          primitive(_.updateFlow(request))

        def updateFlowEntitlement(
          request: UpdateFlowEntitlementRequest
        ): Kleisli[M, MediaConnectClient, UpdateFlowEntitlementResponse] =
          primitive(_.updateFlowEntitlement(request))

        def updateFlowMediaStream(
          request: UpdateFlowMediaStreamRequest
        ): Kleisli[M, MediaConnectClient, UpdateFlowMediaStreamResponse] =
          primitive(_.updateFlowMediaStream(request))

        def updateFlowOutput(
          request: UpdateFlowOutputRequest
        ): Kleisli[M, MediaConnectClient, UpdateFlowOutputResponse] =
          primitive(_.updateFlowOutput(request))

        def updateFlowSource(
          request: UpdateFlowSourceRequest
        ): Kleisli[M, MediaConnectClient, UpdateFlowSourceResponse] =
          primitive(_.updateFlowSource(request))

        def primitive[A](
          f: MediaConnectClient => A
        ): Kleisli[M, MediaConnectClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaConnectOp ~> F) {
      final def apply[A](op: MediaConnectOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addFlowMediaStreams(
        request: AddFlowMediaStreamsRequest
      ): F[AddFlowMediaStreamsResponse]

      def addFlowOutputs(
        request: AddFlowOutputsRequest
      ): F[AddFlowOutputsResponse]

      def addFlowSources(
        request: AddFlowSourcesRequest
      ): F[AddFlowSourcesResponse]

      def addFlowVpcInterfaces(
        request: AddFlowVpcInterfacesRequest
      ): F[AddFlowVpcInterfacesResponse]

      def createFlow(
        request: CreateFlowRequest
      ): F[CreateFlowResponse]

      def deleteFlow(
        request: DeleteFlowRequest
      ): F[DeleteFlowResponse]

      def describeFlow(
        request: DescribeFlowRequest
      ): F[DescribeFlowResponse]

      def describeOffering(
        request: DescribeOfferingRequest
      ): F[DescribeOfferingResponse]

      def describeReservation(
        request: DescribeReservationRequest
      ): F[DescribeReservationResponse]

      def grantFlowEntitlements(
        request: GrantFlowEntitlementsRequest
      ): F[GrantFlowEntitlementsResponse]

      def listEntitlements(
        request: ListEntitlementsRequest
      ): F[ListEntitlementsResponse]

      def listFlows(
        request: ListFlowsRequest
      ): F[ListFlowsResponse]

      def listOfferings(
        request: ListOfferingsRequest
      ): F[ListOfferingsResponse]

      def listReservations(
        request: ListReservationsRequest
      ): F[ListReservationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def purchaseOffering(
        request: PurchaseOfferingRequest
      ): F[PurchaseOfferingResponse]

      def removeFlowMediaStream(
        request: RemoveFlowMediaStreamRequest
      ): F[RemoveFlowMediaStreamResponse]

      def removeFlowOutput(
        request: RemoveFlowOutputRequest
      ): F[RemoveFlowOutputResponse]

      def removeFlowSource(
        request: RemoveFlowSourceRequest
      ): F[RemoveFlowSourceResponse]

      def removeFlowVpcInterface(
        request: RemoveFlowVpcInterfaceRequest
      ): F[RemoveFlowVpcInterfaceResponse]

      def revokeFlowEntitlement(
        request: RevokeFlowEntitlementRequest
      ): F[RevokeFlowEntitlementResponse]

      def startFlow(
        request: StartFlowRequest
      ): F[StartFlowResponse]

      def stopFlow(
        request: StopFlowRequest
      ): F[StopFlowResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateFlow(
        request: UpdateFlowRequest
      ): F[UpdateFlowResponse]

      def updateFlowEntitlement(
        request: UpdateFlowEntitlementRequest
      ): F[UpdateFlowEntitlementResponse]

      def updateFlowMediaStream(
        request: UpdateFlowMediaStreamRequest
      ): F[UpdateFlowMediaStreamResponse]

      def updateFlowOutput(
        request: UpdateFlowOutputRequest
      ): F[UpdateFlowOutputResponse]

      def updateFlowSource(
        request: UpdateFlowSourceRequest
      ): F[UpdateFlowSourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaConnectOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddFlowMediaStreamsOp(
      request: AddFlowMediaStreamsRequest
    ) extends MediaConnectOp[AddFlowMediaStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddFlowMediaStreamsResponse] =
        visitor.addFlowMediaStreams(request)
    }

    final case class AddFlowOutputsOp(
      request: AddFlowOutputsRequest
    ) extends MediaConnectOp[AddFlowOutputsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddFlowOutputsResponse] =
        visitor.addFlowOutputs(request)
    }

    final case class AddFlowSourcesOp(
      request: AddFlowSourcesRequest
    ) extends MediaConnectOp[AddFlowSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddFlowSourcesResponse] =
        visitor.addFlowSources(request)
    }

    final case class AddFlowVpcInterfacesOp(
      request: AddFlowVpcInterfacesRequest
    ) extends MediaConnectOp[AddFlowVpcInterfacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddFlowVpcInterfacesResponse] =
        visitor.addFlowVpcInterfaces(request)
    }

    final case class CreateFlowOp(
      request: CreateFlowRequest
    ) extends MediaConnectOp[CreateFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFlowResponse] =
        visitor.createFlow(request)
    }

    final case class DeleteFlowOp(
      request: DeleteFlowRequest
    ) extends MediaConnectOp[DeleteFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFlowResponse] =
        visitor.deleteFlow(request)
    }

    final case class DescribeFlowOp(
      request: DescribeFlowRequest
    ) extends MediaConnectOp[DescribeFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFlowResponse] =
        visitor.describeFlow(request)
    }

    final case class DescribeOfferingOp(
      request: DescribeOfferingRequest
    ) extends MediaConnectOp[DescribeOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOfferingResponse] =
        visitor.describeOffering(request)
    }

    final case class DescribeReservationOp(
      request: DescribeReservationRequest
    ) extends MediaConnectOp[DescribeReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservationResponse] =
        visitor.describeReservation(request)
    }

    final case class GrantFlowEntitlementsOp(
      request: GrantFlowEntitlementsRequest
    ) extends MediaConnectOp[GrantFlowEntitlementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GrantFlowEntitlementsResponse] =
        visitor.grantFlowEntitlements(request)
    }

    final case class ListEntitlementsOp(
      request: ListEntitlementsRequest
    ) extends MediaConnectOp[ListEntitlementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEntitlementsResponse] =
        visitor.listEntitlements(request)
    }

    final case class ListFlowsOp(
      request: ListFlowsRequest
    ) extends MediaConnectOp[ListFlowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFlowsResponse] =
        visitor.listFlows(request)
    }

    final case class ListOfferingsOp(
      request: ListOfferingsRequest
    ) extends MediaConnectOp[ListOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOfferingsResponse] =
        visitor.listOfferings(request)
    }

    final case class ListReservationsOp(
      request: ListReservationsRequest
    ) extends MediaConnectOp[ListReservationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReservationsResponse] =
        visitor.listReservations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MediaConnectOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PurchaseOfferingOp(
      request: PurchaseOfferingRequest
    ) extends MediaConnectOp[PurchaseOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseOfferingResponse] =
        visitor.purchaseOffering(request)
    }

    final case class RemoveFlowMediaStreamOp(
      request: RemoveFlowMediaStreamRequest
    ) extends MediaConnectOp[RemoveFlowMediaStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveFlowMediaStreamResponse] =
        visitor.removeFlowMediaStream(request)
    }

    final case class RemoveFlowOutputOp(
      request: RemoveFlowOutputRequest
    ) extends MediaConnectOp[RemoveFlowOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveFlowOutputResponse] =
        visitor.removeFlowOutput(request)
    }

    final case class RemoveFlowSourceOp(
      request: RemoveFlowSourceRequest
    ) extends MediaConnectOp[RemoveFlowSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveFlowSourceResponse] =
        visitor.removeFlowSource(request)
    }

    final case class RemoveFlowVpcInterfaceOp(
      request: RemoveFlowVpcInterfaceRequest
    ) extends MediaConnectOp[RemoveFlowVpcInterfaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveFlowVpcInterfaceResponse] =
        visitor.removeFlowVpcInterface(request)
    }

    final case class RevokeFlowEntitlementOp(
      request: RevokeFlowEntitlementRequest
    ) extends MediaConnectOp[RevokeFlowEntitlementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeFlowEntitlementResponse] =
        visitor.revokeFlowEntitlement(request)
    }

    final case class StartFlowOp(
      request: StartFlowRequest
    ) extends MediaConnectOp[StartFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFlowResponse] =
        visitor.startFlow(request)
    }

    final case class StopFlowOp(
      request: StopFlowRequest
    ) extends MediaConnectOp[StopFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopFlowResponse] =
        visitor.stopFlow(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MediaConnectOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MediaConnectOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateFlowOp(
      request: UpdateFlowRequest
    ) extends MediaConnectOp[UpdateFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFlowResponse] =
        visitor.updateFlow(request)
    }

    final case class UpdateFlowEntitlementOp(
      request: UpdateFlowEntitlementRequest
    ) extends MediaConnectOp[UpdateFlowEntitlementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFlowEntitlementResponse] =
        visitor.updateFlowEntitlement(request)
    }

    final case class UpdateFlowMediaStreamOp(
      request: UpdateFlowMediaStreamRequest
    ) extends MediaConnectOp[UpdateFlowMediaStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFlowMediaStreamResponse] =
        visitor.updateFlowMediaStream(request)
    }

    final case class UpdateFlowOutputOp(
      request: UpdateFlowOutputRequest
    ) extends MediaConnectOp[UpdateFlowOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFlowOutputResponse] =
        visitor.updateFlowOutput(request)
    }

    final case class UpdateFlowSourceOp(
      request: UpdateFlowSourceRequest
    ) extends MediaConnectOp[UpdateFlowSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFlowSourceResponse] =
        visitor.updateFlowSource(request)
    }
  }

  import MediaConnectOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaConnectOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addFlowMediaStreams(
    request: AddFlowMediaStreamsRequest
  ): MediaConnectIO[AddFlowMediaStreamsResponse] =
    FF.liftF(AddFlowMediaStreamsOp(request))

  def addFlowOutputs(
    request: AddFlowOutputsRequest
  ): MediaConnectIO[AddFlowOutputsResponse] =
    FF.liftF(AddFlowOutputsOp(request))

  def addFlowSources(
    request: AddFlowSourcesRequest
  ): MediaConnectIO[AddFlowSourcesResponse] =
    FF.liftF(AddFlowSourcesOp(request))

  def addFlowVpcInterfaces(
    request: AddFlowVpcInterfacesRequest
  ): MediaConnectIO[AddFlowVpcInterfacesResponse] =
    FF.liftF(AddFlowVpcInterfacesOp(request))

  def createFlow(
    request: CreateFlowRequest
  ): MediaConnectIO[CreateFlowResponse] =
    FF.liftF(CreateFlowOp(request))

  def deleteFlow(
    request: DeleteFlowRequest
  ): MediaConnectIO[DeleteFlowResponse] =
    FF.liftF(DeleteFlowOp(request))

  def describeFlow(
    request: DescribeFlowRequest
  ): MediaConnectIO[DescribeFlowResponse] =
    FF.liftF(DescribeFlowOp(request))

  def describeOffering(
    request: DescribeOfferingRequest
  ): MediaConnectIO[DescribeOfferingResponse] =
    FF.liftF(DescribeOfferingOp(request))

  def describeReservation(
    request: DescribeReservationRequest
  ): MediaConnectIO[DescribeReservationResponse] =
    FF.liftF(DescribeReservationOp(request))

  def grantFlowEntitlements(
    request: GrantFlowEntitlementsRequest
  ): MediaConnectIO[GrantFlowEntitlementsResponse] =
    FF.liftF(GrantFlowEntitlementsOp(request))

  def listEntitlements(
    request: ListEntitlementsRequest
  ): MediaConnectIO[ListEntitlementsResponse] =
    FF.liftF(ListEntitlementsOp(request))

  def listFlows(
    request: ListFlowsRequest
  ): MediaConnectIO[ListFlowsResponse] =
    FF.liftF(ListFlowsOp(request))

  def listOfferings(
    request: ListOfferingsRequest
  ): MediaConnectIO[ListOfferingsResponse] =
    FF.liftF(ListOfferingsOp(request))

  def listReservations(
    request: ListReservationsRequest
  ): MediaConnectIO[ListReservationsResponse] =
    FF.liftF(ListReservationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MediaConnectIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def purchaseOffering(
    request: PurchaseOfferingRequest
  ): MediaConnectIO[PurchaseOfferingResponse] =
    FF.liftF(PurchaseOfferingOp(request))

  def removeFlowMediaStream(
    request: RemoveFlowMediaStreamRequest
  ): MediaConnectIO[RemoveFlowMediaStreamResponse] =
    FF.liftF(RemoveFlowMediaStreamOp(request))

  def removeFlowOutput(
    request: RemoveFlowOutputRequest
  ): MediaConnectIO[RemoveFlowOutputResponse] =
    FF.liftF(RemoveFlowOutputOp(request))

  def removeFlowSource(
    request: RemoveFlowSourceRequest
  ): MediaConnectIO[RemoveFlowSourceResponse] =
    FF.liftF(RemoveFlowSourceOp(request))

  def removeFlowVpcInterface(
    request: RemoveFlowVpcInterfaceRequest
  ): MediaConnectIO[RemoveFlowVpcInterfaceResponse] =
    FF.liftF(RemoveFlowVpcInterfaceOp(request))

  def revokeFlowEntitlement(
    request: RevokeFlowEntitlementRequest
  ): MediaConnectIO[RevokeFlowEntitlementResponse] =
    FF.liftF(RevokeFlowEntitlementOp(request))

  def startFlow(
    request: StartFlowRequest
  ): MediaConnectIO[StartFlowResponse] =
    FF.liftF(StartFlowOp(request))

  def stopFlow(
    request: StopFlowRequest
  ): MediaConnectIO[StopFlowResponse] =
    FF.liftF(StopFlowOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MediaConnectIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MediaConnectIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateFlow(
    request: UpdateFlowRequest
  ): MediaConnectIO[UpdateFlowResponse] =
    FF.liftF(UpdateFlowOp(request))

  def updateFlowEntitlement(
    request: UpdateFlowEntitlementRequest
  ): MediaConnectIO[UpdateFlowEntitlementResponse] =
    FF.liftF(UpdateFlowEntitlementOp(request))

  def updateFlowMediaStream(
    request: UpdateFlowMediaStreamRequest
  ): MediaConnectIO[UpdateFlowMediaStreamResponse] =
    FF.liftF(UpdateFlowMediaStreamOp(request))

  def updateFlowOutput(
    request: UpdateFlowOutputRequest
  ): MediaConnectIO[UpdateFlowOutputResponse] =
    FF.liftF(UpdateFlowOutputOp(request))

  def updateFlowSource(
    request: UpdateFlowSourceRequest
  ): MediaConnectIO[UpdateFlowSourceResponse] =
    FF.liftF(UpdateFlowSourceOp(request))
}
