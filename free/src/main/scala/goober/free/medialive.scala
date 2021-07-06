package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.medialive.MediaLiveClient
import software.amazon.awssdk.services.medialive.model._
import java.nio.file.Path


object medialive { module =>

  // Free monad over MediaLiveOp
  type MediaLiveIO[A] = FF[MediaLiveOp, A]

  sealed trait MediaLiveOp[A] {
    def visit[F[_]](visitor: MediaLiveOp.Visitor[F]): F[A]
  }

  object MediaLiveOp {
    // Given a MediaLiveClient we can embed a MediaLiveIO program in any algebra that understands embedding.
    implicit val MediaLiveOpEmbeddable: Embeddable[MediaLiveOp, MediaLiveClient] = new Embeddable[MediaLiveOp, MediaLiveClient] {
      def embed[A](client: MediaLiveClient, io: MediaLiveIO[A]): Embedded[A] = Embedded.MediaLive(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaLiveOp.Visitor[Kleisli[M, MediaLiveClient, *]] {
        def acceptInputDeviceTransfer(
          request: AcceptInputDeviceTransferRequest
        ): Kleisli[M, MediaLiveClient, AcceptInputDeviceTransferResponse] =
          primitive(_.acceptInputDeviceTransfer(request))

        def batchDelete(
          request: BatchDeleteRequest
        ): Kleisli[M, MediaLiveClient, BatchDeleteResponse] =
          primitive(_.batchDelete(request))

        def batchStart(
          request: BatchStartRequest
        ): Kleisli[M, MediaLiveClient, BatchStartResponse] =
          primitive(_.batchStart(request))

        def batchStop(
          request: BatchStopRequest
        ): Kleisli[M, MediaLiveClient, BatchStopResponse] =
          primitive(_.batchStop(request))

        def batchUpdateSchedule(
          request: BatchUpdateScheduleRequest
        ): Kleisli[M, MediaLiveClient, BatchUpdateScheduleResponse] =
          primitive(_.batchUpdateSchedule(request))

        def cancelInputDeviceTransfer(
          request: CancelInputDeviceTransferRequest
        ): Kleisli[M, MediaLiveClient, CancelInputDeviceTransferResponse] =
          primitive(_.cancelInputDeviceTransfer(request))

        def createChannel(
          request: CreateChannelRequest
        ): Kleisli[M, MediaLiveClient, CreateChannelResponse] =
          primitive(_.createChannel(request))

        def createInput(
          request: CreateInputRequest
        ): Kleisli[M, MediaLiveClient, CreateInputResponse] =
          primitive(_.createInput(request))

        def createInputSecurityGroup(
          request: CreateInputSecurityGroupRequest
        ): Kleisli[M, MediaLiveClient, CreateInputSecurityGroupResponse] =
          primitive(_.createInputSecurityGroup(request))

        def createMultiplex(
          request: CreateMultiplexRequest
        ): Kleisli[M, MediaLiveClient, CreateMultiplexResponse] =
          primitive(_.createMultiplex(request))

        def createMultiplexProgram(
          request: CreateMultiplexProgramRequest
        ): Kleisli[M, MediaLiveClient, CreateMultiplexProgramResponse] =
          primitive(_.createMultiplexProgram(request))

        def createPartnerInput(
          request: CreatePartnerInputRequest
        ): Kleisli[M, MediaLiveClient, CreatePartnerInputResponse] =
          primitive(_.createPartnerInput(request))

        def createTags(
          request: CreateTagsRequest
        ): Kleisli[M, MediaLiveClient, CreateTagsResponse] =
          primitive(_.createTags(request))

        def deleteChannel(
          request: DeleteChannelRequest
        ): Kleisli[M, MediaLiveClient, DeleteChannelResponse] =
          primitive(_.deleteChannel(request))

        def deleteInput(
          request: DeleteInputRequest
        ): Kleisli[M, MediaLiveClient, DeleteInputResponse] =
          primitive(_.deleteInput(request))

        def deleteInputSecurityGroup(
          request: DeleteInputSecurityGroupRequest
        ): Kleisli[M, MediaLiveClient, DeleteInputSecurityGroupResponse] =
          primitive(_.deleteInputSecurityGroup(request))

        def deleteMultiplex(
          request: DeleteMultiplexRequest
        ): Kleisli[M, MediaLiveClient, DeleteMultiplexResponse] =
          primitive(_.deleteMultiplex(request))

        def deleteMultiplexProgram(
          request: DeleteMultiplexProgramRequest
        ): Kleisli[M, MediaLiveClient, DeleteMultiplexProgramResponse] =
          primitive(_.deleteMultiplexProgram(request))

        def deleteReservation(
          request: DeleteReservationRequest
        ): Kleisli[M, MediaLiveClient, DeleteReservationResponse] =
          primitive(_.deleteReservation(request))

        def deleteSchedule(
          request: DeleteScheduleRequest
        ): Kleisli[M, MediaLiveClient, DeleteScheduleResponse] =
          primitive(_.deleteSchedule(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, MediaLiveClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def describeChannel(
          request: DescribeChannelRequest
        ): Kleisli[M, MediaLiveClient, DescribeChannelResponse] =
          primitive(_.describeChannel(request))

        def describeInput(
          request: DescribeInputRequest
        ): Kleisli[M, MediaLiveClient, DescribeInputResponse] =
          primitive(_.describeInput(request))

        def describeInputDevice(
          request: DescribeInputDeviceRequest
        ): Kleisli[M, MediaLiveClient, DescribeInputDeviceResponse] =
          primitive(_.describeInputDevice(request))

        def describeInputDeviceThumbnail(
          request: DescribeInputDeviceThumbnailRequest,
          path: Path
        ): Kleisli[M, MediaLiveClient, DescribeInputDeviceThumbnailResponse] =
          primitive(_.describeInputDeviceThumbnail(request, path))

        def describeInputSecurityGroup(
          request: DescribeInputSecurityGroupRequest
        ): Kleisli[M, MediaLiveClient, DescribeInputSecurityGroupResponse] =
          primitive(_.describeInputSecurityGroup(request))

        def describeMultiplex(
          request: DescribeMultiplexRequest
        ): Kleisli[M, MediaLiveClient, DescribeMultiplexResponse] =
          primitive(_.describeMultiplex(request))

        def describeMultiplexProgram(
          request: DescribeMultiplexProgramRequest
        ): Kleisli[M, MediaLiveClient, DescribeMultiplexProgramResponse] =
          primitive(_.describeMultiplexProgram(request))

        def describeOffering(
          request: DescribeOfferingRequest
        ): Kleisli[M, MediaLiveClient, DescribeOfferingResponse] =
          primitive(_.describeOffering(request))

        def describeReservation(
          request: DescribeReservationRequest
        ): Kleisli[M, MediaLiveClient, DescribeReservationResponse] =
          primitive(_.describeReservation(request))

        def describeSchedule(
          request: DescribeScheduleRequest
        ): Kleisli[M, MediaLiveClient, DescribeScheduleResponse] =
          primitive(_.describeSchedule(request))

        def listChannels(
          request: ListChannelsRequest
        ): Kleisli[M, MediaLiveClient, ListChannelsResponse] =
          primitive(_.listChannels(request))

        def listInputDeviceTransfers(
          request: ListInputDeviceTransfersRequest
        ): Kleisli[M, MediaLiveClient, ListInputDeviceTransfersResponse] =
          primitive(_.listInputDeviceTransfers(request))

        def listInputDevices(
          request: ListInputDevicesRequest
        ): Kleisli[M, MediaLiveClient, ListInputDevicesResponse] =
          primitive(_.listInputDevices(request))

        def listInputSecurityGroups(
          request: ListInputSecurityGroupsRequest
        ): Kleisli[M, MediaLiveClient, ListInputSecurityGroupsResponse] =
          primitive(_.listInputSecurityGroups(request))

        def listInputs(
          request: ListInputsRequest
        ): Kleisli[M, MediaLiveClient, ListInputsResponse] =
          primitive(_.listInputs(request))

        def listMultiplexPrograms(
          request: ListMultiplexProgramsRequest
        ): Kleisli[M, MediaLiveClient, ListMultiplexProgramsResponse] =
          primitive(_.listMultiplexPrograms(request))

        def listMultiplexes(
          request: ListMultiplexesRequest
        ): Kleisli[M, MediaLiveClient, ListMultiplexesResponse] =
          primitive(_.listMultiplexes(request))

        def listOfferings(
          request: ListOfferingsRequest
        ): Kleisli[M, MediaLiveClient, ListOfferingsResponse] =
          primitive(_.listOfferings(request))

        def listReservations(
          request: ListReservationsRequest
        ): Kleisli[M, MediaLiveClient, ListReservationsResponse] =
          primitive(_.listReservations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MediaLiveClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def purchaseOffering(
          request: PurchaseOfferingRequest
        ): Kleisli[M, MediaLiveClient, PurchaseOfferingResponse] =
          primitive(_.purchaseOffering(request))

        def rejectInputDeviceTransfer(
          request: RejectInputDeviceTransferRequest
        ): Kleisli[M, MediaLiveClient, RejectInputDeviceTransferResponse] =
          primitive(_.rejectInputDeviceTransfer(request))

        def startChannel(
          request: StartChannelRequest
        ): Kleisli[M, MediaLiveClient, StartChannelResponse] =
          primitive(_.startChannel(request))

        def startMultiplex(
          request: StartMultiplexRequest
        ): Kleisli[M, MediaLiveClient, StartMultiplexResponse] =
          primitive(_.startMultiplex(request))

        def stopChannel(
          request: StopChannelRequest
        ): Kleisli[M, MediaLiveClient, StopChannelResponse] =
          primitive(_.stopChannel(request))

        def stopMultiplex(
          request: StopMultiplexRequest
        ): Kleisli[M, MediaLiveClient, StopMultiplexResponse] =
          primitive(_.stopMultiplex(request))

        def transferInputDevice(
          request: TransferInputDeviceRequest
        ): Kleisli[M, MediaLiveClient, TransferInputDeviceResponse] =
          primitive(_.transferInputDevice(request))

        def updateChannel(
          request: UpdateChannelRequest
        ): Kleisli[M, MediaLiveClient, UpdateChannelResponse] =
          primitive(_.updateChannel(request))

        def updateChannelClass(
          request: UpdateChannelClassRequest
        ): Kleisli[M, MediaLiveClient, UpdateChannelClassResponse] =
          primitive(_.updateChannelClass(request))

        def updateInput(
          request: UpdateInputRequest
        ): Kleisli[M, MediaLiveClient, UpdateInputResponse] =
          primitive(_.updateInput(request))

        def updateInputDevice(
          request: UpdateInputDeviceRequest
        ): Kleisli[M, MediaLiveClient, UpdateInputDeviceResponse] =
          primitive(_.updateInputDevice(request))

        def updateInputSecurityGroup(
          request: UpdateInputSecurityGroupRequest
        ): Kleisli[M, MediaLiveClient, UpdateInputSecurityGroupResponse] =
          primitive(_.updateInputSecurityGroup(request))

        def updateMultiplex(
          request: UpdateMultiplexRequest
        ): Kleisli[M, MediaLiveClient, UpdateMultiplexResponse] =
          primitive(_.updateMultiplex(request))

        def updateMultiplexProgram(
          request: UpdateMultiplexProgramRequest
        ): Kleisli[M, MediaLiveClient, UpdateMultiplexProgramResponse] =
          primitive(_.updateMultiplexProgram(request))

        def updateReservation(
          request: UpdateReservationRequest
        ): Kleisli[M, MediaLiveClient, UpdateReservationResponse] =
          primitive(_.updateReservation(request))

        def primitive[A](
          f: MediaLiveClient => A
        ): Kleisli[M, MediaLiveClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaLiveOp ~> F) {
      final def apply[A](op: MediaLiveOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptInputDeviceTransfer(
        request: AcceptInputDeviceTransferRequest
      ): F[AcceptInputDeviceTransferResponse]

      def batchDelete(
        request: BatchDeleteRequest
      ): F[BatchDeleteResponse]

      def batchStart(
        request: BatchStartRequest
      ): F[BatchStartResponse]

      def batchStop(
        request: BatchStopRequest
      ): F[BatchStopResponse]

      def batchUpdateSchedule(
        request: BatchUpdateScheduleRequest
      ): F[BatchUpdateScheduleResponse]

      def cancelInputDeviceTransfer(
        request: CancelInputDeviceTransferRequest
      ): F[CancelInputDeviceTransferResponse]

      def createChannel(
        request: CreateChannelRequest
      ): F[CreateChannelResponse]

      def createInput(
        request: CreateInputRequest
      ): F[CreateInputResponse]

      def createInputSecurityGroup(
        request: CreateInputSecurityGroupRequest
      ): F[CreateInputSecurityGroupResponse]

      def createMultiplex(
        request: CreateMultiplexRequest
      ): F[CreateMultiplexResponse]

      def createMultiplexProgram(
        request: CreateMultiplexProgramRequest
      ): F[CreateMultiplexProgramResponse]

      def createPartnerInput(
        request: CreatePartnerInputRequest
      ): F[CreatePartnerInputResponse]

      def createTags(
        request: CreateTagsRequest
      ): F[CreateTagsResponse]

      def deleteChannel(
        request: DeleteChannelRequest
      ): F[DeleteChannelResponse]

      def deleteInput(
        request: DeleteInputRequest
      ): F[DeleteInputResponse]

      def deleteInputSecurityGroup(
        request: DeleteInputSecurityGroupRequest
      ): F[DeleteInputSecurityGroupResponse]

      def deleteMultiplex(
        request: DeleteMultiplexRequest
      ): F[DeleteMultiplexResponse]

      def deleteMultiplexProgram(
        request: DeleteMultiplexProgramRequest
      ): F[DeleteMultiplexProgramResponse]

      def deleteReservation(
        request: DeleteReservationRequest
      ): F[DeleteReservationResponse]

      def deleteSchedule(
        request: DeleteScheduleRequest
      ): F[DeleteScheduleResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def describeChannel(
        request: DescribeChannelRequest
      ): F[DescribeChannelResponse]

      def describeInput(
        request: DescribeInputRequest
      ): F[DescribeInputResponse]

      def describeInputDevice(
        request: DescribeInputDeviceRequest
      ): F[DescribeInputDeviceResponse]

      def describeInputDeviceThumbnail(
        request: DescribeInputDeviceThumbnailRequest,
        path: Path
      ): F[DescribeInputDeviceThumbnailResponse]

      def describeInputSecurityGroup(
        request: DescribeInputSecurityGroupRequest
      ): F[DescribeInputSecurityGroupResponse]

      def describeMultiplex(
        request: DescribeMultiplexRequest
      ): F[DescribeMultiplexResponse]

      def describeMultiplexProgram(
        request: DescribeMultiplexProgramRequest
      ): F[DescribeMultiplexProgramResponse]

      def describeOffering(
        request: DescribeOfferingRequest
      ): F[DescribeOfferingResponse]

      def describeReservation(
        request: DescribeReservationRequest
      ): F[DescribeReservationResponse]

      def describeSchedule(
        request: DescribeScheduleRequest
      ): F[DescribeScheduleResponse]

      def listChannels(
        request: ListChannelsRequest
      ): F[ListChannelsResponse]

      def listInputDeviceTransfers(
        request: ListInputDeviceTransfersRequest
      ): F[ListInputDeviceTransfersResponse]

      def listInputDevices(
        request: ListInputDevicesRequest
      ): F[ListInputDevicesResponse]

      def listInputSecurityGroups(
        request: ListInputSecurityGroupsRequest
      ): F[ListInputSecurityGroupsResponse]

      def listInputs(
        request: ListInputsRequest
      ): F[ListInputsResponse]

      def listMultiplexPrograms(
        request: ListMultiplexProgramsRequest
      ): F[ListMultiplexProgramsResponse]

      def listMultiplexes(
        request: ListMultiplexesRequest
      ): F[ListMultiplexesResponse]

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

      def rejectInputDeviceTransfer(
        request: RejectInputDeviceTransferRequest
      ): F[RejectInputDeviceTransferResponse]

      def startChannel(
        request: StartChannelRequest
      ): F[StartChannelResponse]

      def startMultiplex(
        request: StartMultiplexRequest
      ): F[StartMultiplexResponse]

      def stopChannel(
        request: StopChannelRequest
      ): F[StopChannelResponse]

      def stopMultiplex(
        request: StopMultiplexRequest
      ): F[StopMultiplexResponse]

      def transferInputDevice(
        request: TransferInputDeviceRequest
      ): F[TransferInputDeviceResponse]

      def updateChannel(
        request: UpdateChannelRequest
      ): F[UpdateChannelResponse]

      def updateChannelClass(
        request: UpdateChannelClassRequest
      ): F[UpdateChannelClassResponse]

      def updateInput(
        request: UpdateInputRequest
      ): F[UpdateInputResponse]

      def updateInputDevice(
        request: UpdateInputDeviceRequest
      ): F[UpdateInputDeviceResponse]

      def updateInputSecurityGroup(
        request: UpdateInputSecurityGroupRequest
      ): F[UpdateInputSecurityGroupResponse]

      def updateMultiplex(
        request: UpdateMultiplexRequest
      ): F[UpdateMultiplexResponse]

      def updateMultiplexProgram(
        request: UpdateMultiplexProgramRequest
      ): F[UpdateMultiplexProgramResponse]

      def updateReservation(
        request: UpdateReservationRequest
      ): F[UpdateReservationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaLiveOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptInputDeviceTransferOp(
      request: AcceptInputDeviceTransferRequest
    ) extends MediaLiveOp[AcceptInputDeviceTransferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptInputDeviceTransferResponse] =
        visitor.acceptInputDeviceTransfer(request)
    }

    final case class BatchDeleteOp(
      request: BatchDeleteRequest
    ) extends MediaLiveOp[BatchDeleteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteResponse] =
        visitor.batchDelete(request)
    }

    final case class BatchStartOp(
      request: BatchStartRequest
    ) extends MediaLiveOp[BatchStartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchStartResponse] =
        visitor.batchStart(request)
    }

    final case class BatchStopOp(
      request: BatchStopRequest
    ) extends MediaLiveOp[BatchStopResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchStopResponse] =
        visitor.batchStop(request)
    }

    final case class BatchUpdateScheduleOp(
      request: BatchUpdateScheduleRequest
    ) extends MediaLiveOp[BatchUpdateScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdateScheduleResponse] =
        visitor.batchUpdateSchedule(request)
    }

    final case class CancelInputDeviceTransferOp(
      request: CancelInputDeviceTransferRequest
    ) extends MediaLiveOp[CancelInputDeviceTransferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelInputDeviceTransferResponse] =
        visitor.cancelInputDeviceTransfer(request)
    }

    final case class CreateChannelOp(
      request: CreateChannelRequest
    ) extends MediaLiveOp[CreateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelResponse] =
        visitor.createChannel(request)
    }

    final case class CreateInputOp(
      request: CreateInputRequest
    ) extends MediaLiveOp[CreateInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInputResponse] =
        visitor.createInput(request)
    }

    final case class CreateInputSecurityGroupOp(
      request: CreateInputSecurityGroupRequest
    ) extends MediaLiveOp[CreateInputSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInputSecurityGroupResponse] =
        visitor.createInputSecurityGroup(request)
    }

    final case class CreateMultiplexOp(
      request: CreateMultiplexRequest
    ) extends MediaLiveOp[CreateMultiplexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMultiplexResponse] =
        visitor.createMultiplex(request)
    }

    final case class CreateMultiplexProgramOp(
      request: CreateMultiplexProgramRequest
    ) extends MediaLiveOp[CreateMultiplexProgramResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMultiplexProgramResponse] =
        visitor.createMultiplexProgram(request)
    }

    final case class CreatePartnerInputOp(
      request: CreatePartnerInputRequest
    ) extends MediaLiveOp[CreatePartnerInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePartnerInputResponse] =
        visitor.createPartnerInput(request)
    }

    final case class CreateTagsOp(
      request: CreateTagsRequest
    ) extends MediaLiveOp[CreateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTagsResponse] =
        visitor.createTags(request)
    }

    final case class DeleteChannelOp(
      request: DeleteChannelRequest
    ) extends MediaLiveOp[DeleteChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelResponse] =
        visitor.deleteChannel(request)
    }

    final case class DeleteInputOp(
      request: DeleteInputRequest
    ) extends MediaLiveOp[DeleteInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInputResponse] =
        visitor.deleteInput(request)
    }

    final case class DeleteInputSecurityGroupOp(
      request: DeleteInputSecurityGroupRequest
    ) extends MediaLiveOp[DeleteInputSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInputSecurityGroupResponse] =
        visitor.deleteInputSecurityGroup(request)
    }

    final case class DeleteMultiplexOp(
      request: DeleteMultiplexRequest
    ) extends MediaLiveOp[DeleteMultiplexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMultiplexResponse] =
        visitor.deleteMultiplex(request)
    }

    final case class DeleteMultiplexProgramOp(
      request: DeleteMultiplexProgramRequest
    ) extends MediaLiveOp[DeleteMultiplexProgramResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMultiplexProgramResponse] =
        visitor.deleteMultiplexProgram(request)
    }

    final case class DeleteReservationOp(
      request: DeleteReservationRequest
    ) extends MediaLiveOp[DeleteReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReservationResponse] =
        visitor.deleteReservation(request)
    }

    final case class DeleteScheduleOp(
      request: DeleteScheduleRequest
    ) extends MediaLiveOp[DeleteScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScheduleResponse] =
        visitor.deleteSchedule(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends MediaLiveOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DescribeChannelOp(
      request: DescribeChannelRequest
    ) extends MediaLiveOp[DescribeChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelResponse] =
        visitor.describeChannel(request)
    }

    final case class DescribeInputOp(
      request: DescribeInputRequest
    ) extends MediaLiveOp[DescribeInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInputResponse] =
        visitor.describeInput(request)
    }

    final case class DescribeInputDeviceOp(
      request: DescribeInputDeviceRequest
    ) extends MediaLiveOp[DescribeInputDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInputDeviceResponse] =
        visitor.describeInputDevice(request)
    }

    final case class DescribeInputDeviceThumbnailOp(
      request: DescribeInputDeviceThumbnailRequest,
      path: Path
    ) extends MediaLiveOp[DescribeInputDeviceThumbnailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInputDeviceThumbnailResponse] =
        visitor.describeInputDeviceThumbnail(request, path)
    }

    final case class DescribeInputSecurityGroupOp(
      request: DescribeInputSecurityGroupRequest
    ) extends MediaLiveOp[DescribeInputSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInputSecurityGroupResponse] =
        visitor.describeInputSecurityGroup(request)
    }

    final case class DescribeMultiplexOp(
      request: DescribeMultiplexRequest
    ) extends MediaLiveOp[DescribeMultiplexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMultiplexResponse] =
        visitor.describeMultiplex(request)
    }

    final case class DescribeMultiplexProgramOp(
      request: DescribeMultiplexProgramRequest
    ) extends MediaLiveOp[DescribeMultiplexProgramResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMultiplexProgramResponse] =
        visitor.describeMultiplexProgram(request)
    }

    final case class DescribeOfferingOp(
      request: DescribeOfferingRequest
    ) extends MediaLiveOp[DescribeOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOfferingResponse] =
        visitor.describeOffering(request)
    }

    final case class DescribeReservationOp(
      request: DescribeReservationRequest
    ) extends MediaLiveOp[DescribeReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservationResponse] =
        visitor.describeReservation(request)
    }

    final case class DescribeScheduleOp(
      request: DescribeScheduleRequest
    ) extends MediaLiveOp[DescribeScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduleResponse] =
        visitor.describeSchedule(request)
    }

    final case class ListChannelsOp(
      request: ListChannelsRequest
    ) extends MediaLiveOp[ListChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelsResponse] =
        visitor.listChannels(request)
    }

    final case class ListInputDeviceTransfersOp(
      request: ListInputDeviceTransfersRequest
    ) extends MediaLiveOp[ListInputDeviceTransfersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInputDeviceTransfersResponse] =
        visitor.listInputDeviceTransfers(request)
    }

    final case class ListInputDevicesOp(
      request: ListInputDevicesRequest
    ) extends MediaLiveOp[ListInputDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInputDevicesResponse] =
        visitor.listInputDevices(request)
    }

    final case class ListInputSecurityGroupsOp(
      request: ListInputSecurityGroupsRequest
    ) extends MediaLiveOp[ListInputSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInputSecurityGroupsResponse] =
        visitor.listInputSecurityGroups(request)
    }

    final case class ListInputsOp(
      request: ListInputsRequest
    ) extends MediaLiveOp[ListInputsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInputsResponse] =
        visitor.listInputs(request)
    }

    final case class ListMultiplexProgramsOp(
      request: ListMultiplexProgramsRequest
    ) extends MediaLiveOp[ListMultiplexProgramsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMultiplexProgramsResponse] =
        visitor.listMultiplexPrograms(request)
    }

    final case class ListMultiplexesOp(
      request: ListMultiplexesRequest
    ) extends MediaLiveOp[ListMultiplexesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMultiplexesResponse] =
        visitor.listMultiplexes(request)
    }

    final case class ListOfferingsOp(
      request: ListOfferingsRequest
    ) extends MediaLiveOp[ListOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOfferingsResponse] =
        visitor.listOfferings(request)
    }

    final case class ListReservationsOp(
      request: ListReservationsRequest
    ) extends MediaLiveOp[ListReservationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReservationsResponse] =
        visitor.listReservations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MediaLiveOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PurchaseOfferingOp(
      request: PurchaseOfferingRequest
    ) extends MediaLiveOp[PurchaseOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseOfferingResponse] =
        visitor.purchaseOffering(request)
    }

    final case class RejectInputDeviceTransferOp(
      request: RejectInputDeviceTransferRequest
    ) extends MediaLiveOp[RejectInputDeviceTransferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectInputDeviceTransferResponse] =
        visitor.rejectInputDeviceTransfer(request)
    }

    final case class StartChannelOp(
      request: StartChannelRequest
    ) extends MediaLiveOp[StartChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartChannelResponse] =
        visitor.startChannel(request)
    }

    final case class StartMultiplexOp(
      request: StartMultiplexRequest
    ) extends MediaLiveOp[StartMultiplexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMultiplexResponse] =
        visitor.startMultiplex(request)
    }

    final case class StopChannelOp(
      request: StopChannelRequest
    ) extends MediaLiveOp[StopChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopChannelResponse] =
        visitor.stopChannel(request)
    }

    final case class StopMultiplexOp(
      request: StopMultiplexRequest
    ) extends MediaLiveOp[StopMultiplexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopMultiplexResponse] =
        visitor.stopMultiplex(request)
    }

    final case class TransferInputDeviceOp(
      request: TransferInputDeviceRequest
    ) extends MediaLiveOp[TransferInputDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TransferInputDeviceResponse] =
        visitor.transferInputDevice(request)
    }

    final case class UpdateChannelOp(
      request: UpdateChannelRequest
    ) extends MediaLiveOp[UpdateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelResponse] =
        visitor.updateChannel(request)
    }

    final case class UpdateChannelClassOp(
      request: UpdateChannelClassRequest
    ) extends MediaLiveOp[UpdateChannelClassResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelClassResponse] =
        visitor.updateChannelClass(request)
    }

    final case class UpdateInputOp(
      request: UpdateInputRequest
    ) extends MediaLiveOp[UpdateInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInputResponse] =
        visitor.updateInput(request)
    }

    final case class UpdateInputDeviceOp(
      request: UpdateInputDeviceRequest
    ) extends MediaLiveOp[UpdateInputDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInputDeviceResponse] =
        visitor.updateInputDevice(request)
    }

    final case class UpdateInputSecurityGroupOp(
      request: UpdateInputSecurityGroupRequest
    ) extends MediaLiveOp[UpdateInputSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInputSecurityGroupResponse] =
        visitor.updateInputSecurityGroup(request)
    }

    final case class UpdateMultiplexOp(
      request: UpdateMultiplexRequest
    ) extends MediaLiveOp[UpdateMultiplexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMultiplexResponse] =
        visitor.updateMultiplex(request)
    }

    final case class UpdateMultiplexProgramOp(
      request: UpdateMultiplexProgramRequest
    ) extends MediaLiveOp[UpdateMultiplexProgramResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMultiplexProgramResponse] =
        visitor.updateMultiplexProgram(request)
    }

    final case class UpdateReservationOp(
      request: UpdateReservationRequest
    ) extends MediaLiveOp[UpdateReservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReservationResponse] =
        visitor.updateReservation(request)
    }
  }

  import MediaLiveOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaLiveOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptInputDeviceTransfer(
    request: AcceptInputDeviceTransferRequest
  ): MediaLiveIO[AcceptInputDeviceTransferResponse] =
    FF.liftF(AcceptInputDeviceTransferOp(request))

  def batchDelete(
    request: BatchDeleteRequest
  ): MediaLiveIO[BatchDeleteResponse] =
    FF.liftF(BatchDeleteOp(request))

  def batchStart(
    request: BatchStartRequest
  ): MediaLiveIO[BatchStartResponse] =
    FF.liftF(BatchStartOp(request))

  def batchStop(
    request: BatchStopRequest
  ): MediaLiveIO[BatchStopResponse] =
    FF.liftF(BatchStopOp(request))

  def batchUpdateSchedule(
    request: BatchUpdateScheduleRequest
  ): MediaLiveIO[BatchUpdateScheduleResponse] =
    FF.liftF(BatchUpdateScheduleOp(request))

  def cancelInputDeviceTransfer(
    request: CancelInputDeviceTransferRequest
  ): MediaLiveIO[CancelInputDeviceTransferResponse] =
    FF.liftF(CancelInputDeviceTransferOp(request))

  def createChannel(
    request: CreateChannelRequest
  ): MediaLiveIO[CreateChannelResponse] =
    FF.liftF(CreateChannelOp(request))

  def createInput(
    request: CreateInputRequest
  ): MediaLiveIO[CreateInputResponse] =
    FF.liftF(CreateInputOp(request))

  def createInputSecurityGroup(
    request: CreateInputSecurityGroupRequest
  ): MediaLiveIO[CreateInputSecurityGroupResponse] =
    FF.liftF(CreateInputSecurityGroupOp(request))

  def createMultiplex(
    request: CreateMultiplexRequest
  ): MediaLiveIO[CreateMultiplexResponse] =
    FF.liftF(CreateMultiplexOp(request))

  def createMultiplexProgram(
    request: CreateMultiplexProgramRequest
  ): MediaLiveIO[CreateMultiplexProgramResponse] =
    FF.liftF(CreateMultiplexProgramOp(request))

  def createPartnerInput(
    request: CreatePartnerInputRequest
  ): MediaLiveIO[CreatePartnerInputResponse] =
    FF.liftF(CreatePartnerInputOp(request))

  def createTags(
    request: CreateTagsRequest
  ): MediaLiveIO[CreateTagsResponse] =
    FF.liftF(CreateTagsOp(request))

  def deleteChannel(
    request: DeleteChannelRequest
  ): MediaLiveIO[DeleteChannelResponse] =
    FF.liftF(DeleteChannelOp(request))

  def deleteInput(
    request: DeleteInputRequest
  ): MediaLiveIO[DeleteInputResponse] =
    FF.liftF(DeleteInputOp(request))

  def deleteInputSecurityGroup(
    request: DeleteInputSecurityGroupRequest
  ): MediaLiveIO[DeleteInputSecurityGroupResponse] =
    FF.liftF(DeleteInputSecurityGroupOp(request))

  def deleteMultiplex(
    request: DeleteMultiplexRequest
  ): MediaLiveIO[DeleteMultiplexResponse] =
    FF.liftF(DeleteMultiplexOp(request))

  def deleteMultiplexProgram(
    request: DeleteMultiplexProgramRequest
  ): MediaLiveIO[DeleteMultiplexProgramResponse] =
    FF.liftF(DeleteMultiplexProgramOp(request))

  def deleteReservation(
    request: DeleteReservationRequest
  ): MediaLiveIO[DeleteReservationResponse] =
    FF.liftF(DeleteReservationOp(request))

  def deleteSchedule(
    request: DeleteScheduleRequest
  ): MediaLiveIO[DeleteScheduleResponse] =
    FF.liftF(DeleteScheduleOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): MediaLiveIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def describeChannel(
    request: DescribeChannelRequest
  ): MediaLiveIO[DescribeChannelResponse] =
    FF.liftF(DescribeChannelOp(request))

  def describeInput(
    request: DescribeInputRequest
  ): MediaLiveIO[DescribeInputResponse] =
    FF.liftF(DescribeInputOp(request))

  def describeInputDevice(
    request: DescribeInputDeviceRequest
  ): MediaLiveIO[DescribeInputDeviceResponse] =
    FF.liftF(DescribeInputDeviceOp(request))

  def describeInputDeviceThumbnail(
    request: DescribeInputDeviceThumbnailRequest,
    path: Path
  ): MediaLiveIO[DescribeInputDeviceThumbnailResponse] =
    FF.liftF(DescribeInputDeviceThumbnailOp(request, path))

  def describeInputSecurityGroup(
    request: DescribeInputSecurityGroupRequest
  ): MediaLiveIO[DescribeInputSecurityGroupResponse] =
    FF.liftF(DescribeInputSecurityGroupOp(request))

  def describeMultiplex(
    request: DescribeMultiplexRequest
  ): MediaLiveIO[DescribeMultiplexResponse] =
    FF.liftF(DescribeMultiplexOp(request))

  def describeMultiplexProgram(
    request: DescribeMultiplexProgramRequest
  ): MediaLiveIO[DescribeMultiplexProgramResponse] =
    FF.liftF(DescribeMultiplexProgramOp(request))

  def describeOffering(
    request: DescribeOfferingRequest
  ): MediaLiveIO[DescribeOfferingResponse] =
    FF.liftF(DescribeOfferingOp(request))

  def describeReservation(
    request: DescribeReservationRequest
  ): MediaLiveIO[DescribeReservationResponse] =
    FF.liftF(DescribeReservationOp(request))

  def describeSchedule(
    request: DescribeScheduleRequest
  ): MediaLiveIO[DescribeScheduleResponse] =
    FF.liftF(DescribeScheduleOp(request))

  def listChannels(
    request: ListChannelsRequest
  ): MediaLiveIO[ListChannelsResponse] =
    FF.liftF(ListChannelsOp(request))

  def listInputDeviceTransfers(
    request: ListInputDeviceTransfersRequest
  ): MediaLiveIO[ListInputDeviceTransfersResponse] =
    FF.liftF(ListInputDeviceTransfersOp(request))

  def listInputDevices(
    request: ListInputDevicesRequest
  ): MediaLiveIO[ListInputDevicesResponse] =
    FF.liftF(ListInputDevicesOp(request))

  def listInputSecurityGroups(
    request: ListInputSecurityGroupsRequest
  ): MediaLiveIO[ListInputSecurityGroupsResponse] =
    FF.liftF(ListInputSecurityGroupsOp(request))

  def listInputs(
    request: ListInputsRequest
  ): MediaLiveIO[ListInputsResponse] =
    FF.liftF(ListInputsOp(request))

  def listMultiplexPrograms(
    request: ListMultiplexProgramsRequest
  ): MediaLiveIO[ListMultiplexProgramsResponse] =
    FF.liftF(ListMultiplexProgramsOp(request))

  def listMultiplexes(
    request: ListMultiplexesRequest
  ): MediaLiveIO[ListMultiplexesResponse] =
    FF.liftF(ListMultiplexesOp(request))

  def listOfferings(
    request: ListOfferingsRequest
  ): MediaLiveIO[ListOfferingsResponse] =
    FF.liftF(ListOfferingsOp(request))

  def listReservations(
    request: ListReservationsRequest
  ): MediaLiveIO[ListReservationsResponse] =
    FF.liftF(ListReservationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MediaLiveIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def purchaseOffering(
    request: PurchaseOfferingRequest
  ): MediaLiveIO[PurchaseOfferingResponse] =
    FF.liftF(PurchaseOfferingOp(request))

  def rejectInputDeviceTransfer(
    request: RejectInputDeviceTransferRequest
  ): MediaLiveIO[RejectInputDeviceTransferResponse] =
    FF.liftF(RejectInputDeviceTransferOp(request))

  def startChannel(
    request: StartChannelRequest
  ): MediaLiveIO[StartChannelResponse] =
    FF.liftF(StartChannelOp(request))

  def startMultiplex(
    request: StartMultiplexRequest
  ): MediaLiveIO[StartMultiplexResponse] =
    FF.liftF(StartMultiplexOp(request))

  def stopChannel(
    request: StopChannelRequest
  ): MediaLiveIO[StopChannelResponse] =
    FF.liftF(StopChannelOp(request))

  def stopMultiplex(
    request: StopMultiplexRequest
  ): MediaLiveIO[StopMultiplexResponse] =
    FF.liftF(StopMultiplexOp(request))

  def transferInputDevice(
    request: TransferInputDeviceRequest
  ): MediaLiveIO[TransferInputDeviceResponse] =
    FF.liftF(TransferInputDeviceOp(request))

  def updateChannel(
    request: UpdateChannelRequest
  ): MediaLiveIO[UpdateChannelResponse] =
    FF.liftF(UpdateChannelOp(request))

  def updateChannelClass(
    request: UpdateChannelClassRequest
  ): MediaLiveIO[UpdateChannelClassResponse] =
    FF.liftF(UpdateChannelClassOp(request))

  def updateInput(
    request: UpdateInputRequest
  ): MediaLiveIO[UpdateInputResponse] =
    FF.liftF(UpdateInputOp(request))

  def updateInputDevice(
    request: UpdateInputDeviceRequest
  ): MediaLiveIO[UpdateInputDeviceResponse] =
    FF.liftF(UpdateInputDeviceOp(request))

  def updateInputSecurityGroup(
    request: UpdateInputSecurityGroupRequest
  ): MediaLiveIO[UpdateInputSecurityGroupResponse] =
    FF.liftF(UpdateInputSecurityGroupOp(request))

  def updateMultiplex(
    request: UpdateMultiplexRequest
  ): MediaLiveIO[UpdateMultiplexResponse] =
    FF.liftF(UpdateMultiplexOp(request))

  def updateMultiplexProgram(
    request: UpdateMultiplexProgramRequest
  ): MediaLiveIO[UpdateMultiplexProgramResponse] =
    FF.liftF(UpdateMultiplexProgramOp(request))

  def updateReservation(
    request: UpdateReservationRequest
  ): MediaLiveIO[UpdateReservationResponse] =
    FF.liftF(UpdateReservationOp(request))
}
