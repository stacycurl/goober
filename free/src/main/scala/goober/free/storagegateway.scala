package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.storagegateway.StorageGatewayClient
import software.amazon.awssdk.services.storagegateway.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object storagegateway { module =>

  // Free monad over StorageGatewayOp
  type StorageGatewayIO[A] = FF[StorageGatewayOp, A]

  sealed trait StorageGatewayOp[A] {
    def visit[F[_]](visitor: StorageGatewayOp.Visitor[F]): F[A]
  }

  object StorageGatewayOp {
    // Given a StorageGatewayClient we can embed a StorageGatewayIO program in any algebra that understands embedding.
    implicit val StorageGatewayOpEmbeddable: Embeddable[StorageGatewayOp, StorageGatewayClient] = new Embeddable[StorageGatewayOp, StorageGatewayClient] {
      def embed[A](client: StorageGatewayClient, io: StorageGatewayIO[A]): Embedded[A] = Embedded.StorageGateway(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends StorageGatewayOp.Visitor[Kleisli[M, StorageGatewayClient, *]] {
        def activateGateway(
          request: ActivateGatewayRequest
        ): Kleisli[M, StorageGatewayClient, ActivateGatewayResponse] =
          primitive(_.activateGateway(request))

        def addCache(
          request: AddCacheRequest
        ): Kleisli[M, StorageGatewayClient, AddCacheResponse] =
          primitive(_.addCache(request))

        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, StorageGatewayClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def addUploadBuffer(
          request: AddUploadBufferRequest
        ): Kleisli[M, StorageGatewayClient, AddUploadBufferResponse] =
          primitive(_.addUploadBuffer(request))

        def addWorkingStorage(
          request: AddWorkingStorageRequest
        ): Kleisli[M, StorageGatewayClient, AddWorkingStorageResponse] =
          primitive(_.addWorkingStorage(request))

        def assignTapePool(
          request: AssignTapePoolRequest
        ): Kleisli[M, StorageGatewayClient, AssignTapePoolResponse] =
          primitive(_.assignTapePool(request))

        def associateFileSystem(
          request: AssociateFileSystemRequest
        ): Kleisli[M, StorageGatewayClient, AssociateFileSystemResponse] =
          primitive(_.associateFileSystem(request))

        def attachVolume(
          request: AttachVolumeRequest
        ): Kleisli[M, StorageGatewayClient, AttachVolumeResponse] =
          primitive(_.attachVolume(request))

        def cancelArchival(
          request: CancelArchivalRequest
        ): Kleisli[M, StorageGatewayClient, CancelArchivalResponse] =
          primitive(_.cancelArchival(request))

        def cancelRetrieval(
          request: CancelRetrievalRequest
        ): Kleisli[M, StorageGatewayClient, CancelRetrievalResponse] =
          primitive(_.cancelRetrieval(request))

        def createCachediSCSIVolume(
          request: CreateCachediScsiVolumeRequest
        ): Kleisli[M, StorageGatewayClient, CreateCachediScsiVolumeResponse] =
          primitive(_.createCachediSCSIVolume(request))

        def createNFSFileShare(
          request: CreateNfsFileShareRequest
        ): Kleisli[M, StorageGatewayClient, CreateNfsFileShareResponse] =
          primitive(_.createNFSFileShare(request))

        def createSMBFileShare(
          request: CreateSmbFileShareRequest
        ): Kleisli[M, StorageGatewayClient, CreateSmbFileShareResponse] =
          primitive(_.createSMBFileShare(request))

        def createSnapshot(
          request: CreateSnapshotRequest
        ): Kleisli[M, StorageGatewayClient, CreateSnapshotResponse] =
          primitive(_.createSnapshot(request))

        def createSnapshotFromVolumeRecoveryPoint(
          request: CreateSnapshotFromVolumeRecoveryPointRequest
        ): Kleisli[M, StorageGatewayClient, CreateSnapshotFromVolumeRecoveryPointResponse] =
          primitive(_.createSnapshotFromVolumeRecoveryPoint(request))

        def createStorediSCSIVolume(
          request: CreateStorediScsiVolumeRequest
        ): Kleisli[M, StorageGatewayClient, CreateStorediScsiVolumeResponse] =
          primitive(_.createStorediSCSIVolume(request))

        def createTapePool(
          request: CreateTapePoolRequest
        ): Kleisli[M, StorageGatewayClient, CreateTapePoolResponse] =
          primitive(_.createTapePool(request))

        def createTapeWithBarcode(
          request: CreateTapeWithBarcodeRequest
        ): Kleisli[M, StorageGatewayClient, CreateTapeWithBarcodeResponse] =
          primitive(_.createTapeWithBarcode(request))

        def createTapes(
          request: CreateTapesRequest
        ): Kleisli[M, StorageGatewayClient, CreateTapesResponse] =
          primitive(_.createTapes(request))

        def deleteAutomaticTapeCreationPolicy(
          request: DeleteAutomaticTapeCreationPolicyRequest
        ): Kleisli[M, StorageGatewayClient, DeleteAutomaticTapeCreationPolicyResponse] =
          primitive(_.deleteAutomaticTapeCreationPolicy(request))

        def deleteBandwidthRateLimit(
          request: DeleteBandwidthRateLimitRequest
        ): Kleisli[M, StorageGatewayClient, DeleteBandwidthRateLimitResponse] =
          primitive(_.deleteBandwidthRateLimit(request))

        def deleteChapCredentials(
          request: DeleteChapCredentialsRequest
        ): Kleisli[M, StorageGatewayClient, DeleteChapCredentialsResponse] =
          primitive(_.deleteChapCredentials(request))

        def deleteFileShare(
          request: DeleteFileShareRequest
        ): Kleisli[M, StorageGatewayClient, DeleteFileShareResponse] =
          primitive(_.deleteFileShare(request))

        def deleteGateway(
          request: DeleteGatewayRequest
        ): Kleisli[M, StorageGatewayClient, DeleteGatewayResponse] =
          primitive(_.deleteGateway(request))

        def deleteSnapshotSchedule(
          request: DeleteSnapshotScheduleRequest
        ): Kleisli[M, StorageGatewayClient, DeleteSnapshotScheduleResponse] =
          primitive(_.deleteSnapshotSchedule(request))

        def deleteTape(
          request: DeleteTapeRequest
        ): Kleisli[M, StorageGatewayClient, DeleteTapeResponse] =
          primitive(_.deleteTape(request))

        def deleteTapeArchive(
          request: DeleteTapeArchiveRequest
        ): Kleisli[M, StorageGatewayClient, DeleteTapeArchiveResponse] =
          primitive(_.deleteTapeArchive(request))

        def deleteTapePool(
          request: DeleteTapePoolRequest
        ): Kleisli[M, StorageGatewayClient, DeleteTapePoolResponse] =
          primitive(_.deleteTapePool(request))

        def deleteVolume(
          request: DeleteVolumeRequest
        ): Kleisli[M, StorageGatewayClient, DeleteVolumeResponse] =
          primitive(_.deleteVolume(request))

        def describeAvailabilityMonitorTest(
          request: DescribeAvailabilityMonitorTestRequest
        ): Kleisli[M, StorageGatewayClient, DescribeAvailabilityMonitorTestResponse] =
          primitive(_.describeAvailabilityMonitorTest(request))

        def describeBandwidthRateLimit(
          request: DescribeBandwidthRateLimitRequest
        ): Kleisli[M, StorageGatewayClient, DescribeBandwidthRateLimitResponse] =
          primitive(_.describeBandwidthRateLimit(request))

        def describeBandwidthRateLimitSchedule(
          request: DescribeBandwidthRateLimitScheduleRequest
        ): Kleisli[M, StorageGatewayClient, DescribeBandwidthRateLimitScheduleResponse] =
          primitive(_.describeBandwidthRateLimitSchedule(request))

        def describeCache(
          request: DescribeCacheRequest
        ): Kleisli[M, StorageGatewayClient, DescribeCacheResponse] =
          primitive(_.describeCache(request))

        def describeCachediSCSIVolumes(
          request: DescribeCachediScsiVolumesRequest
        ): Kleisli[M, StorageGatewayClient, DescribeCachediScsiVolumesResponse] =
          primitive(_.describeCachediSCSIVolumes(request))

        def describeChapCredentials(
          request: DescribeChapCredentialsRequest
        ): Kleisli[M, StorageGatewayClient, DescribeChapCredentialsResponse] =
          primitive(_.describeChapCredentials(request))

        def describeFileSystemAssociations(
          request: DescribeFileSystemAssociationsRequest
        ): Kleisli[M, StorageGatewayClient, DescribeFileSystemAssociationsResponse] =
          primitive(_.describeFileSystemAssociations(request))

        def describeGatewayInformation(
          request: DescribeGatewayInformationRequest
        ): Kleisli[M, StorageGatewayClient, DescribeGatewayInformationResponse] =
          primitive(_.describeGatewayInformation(request))

        def describeMaintenanceStartTime(
          request: DescribeMaintenanceStartTimeRequest
        ): Kleisli[M, StorageGatewayClient, DescribeMaintenanceStartTimeResponse] =
          primitive(_.describeMaintenanceStartTime(request))

        def describeNFSFileShares(
          request: DescribeNfsFileSharesRequest
        ): Kleisli[M, StorageGatewayClient, DescribeNfsFileSharesResponse] =
          primitive(_.describeNFSFileShares(request))

        def describeSMBFileShares(
          request: DescribeSmbFileSharesRequest
        ): Kleisli[M, StorageGatewayClient, DescribeSmbFileSharesResponse] =
          primitive(_.describeSMBFileShares(request))

        def describeSMBSettings(
          request: DescribeSmbSettingsRequest
        ): Kleisli[M, StorageGatewayClient, DescribeSmbSettingsResponse] =
          primitive(_.describeSMBSettings(request))

        def describeSnapshotSchedule(
          request: DescribeSnapshotScheduleRequest
        ): Kleisli[M, StorageGatewayClient, DescribeSnapshotScheduleResponse] =
          primitive(_.describeSnapshotSchedule(request))

        def describeStorediSCSIVolumes(
          request: DescribeStorediScsiVolumesRequest
        ): Kleisli[M, StorageGatewayClient, DescribeStorediScsiVolumesResponse] =
          primitive(_.describeStorediSCSIVolumes(request))

        def describeTapeArchives(
          request: DescribeTapeArchivesRequest
        ): Kleisli[M, StorageGatewayClient, DescribeTapeArchivesResponse] =
          primitive(_.describeTapeArchives(request))

        def describeTapeRecoveryPoints(
          request: DescribeTapeRecoveryPointsRequest
        ): Kleisli[M, StorageGatewayClient, DescribeTapeRecoveryPointsResponse] =
          primitive(_.describeTapeRecoveryPoints(request))

        def describeTapes(
          request: DescribeTapesRequest
        ): Kleisli[M, StorageGatewayClient, DescribeTapesResponse] =
          primitive(_.describeTapes(request))

        def describeUploadBuffer(
          request: DescribeUploadBufferRequest
        ): Kleisli[M, StorageGatewayClient, DescribeUploadBufferResponse] =
          primitive(_.describeUploadBuffer(request))

        def describeVTLDevices(
          request: DescribeVtlDevicesRequest
        ): Kleisli[M, StorageGatewayClient, DescribeVtlDevicesResponse] =
          primitive(_.describeVTLDevices(request))

        def describeWorkingStorage(
          request: DescribeWorkingStorageRequest
        ): Kleisli[M, StorageGatewayClient, DescribeWorkingStorageResponse] =
          primitive(_.describeWorkingStorage(request))

        def detachVolume(
          request: DetachVolumeRequest
        ): Kleisli[M, StorageGatewayClient, DetachVolumeResponse] =
          primitive(_.detachVolume(request))

        def disableGateway(
          request: DisableGatewayRequest
        ): Kleisli[M, StorageGatewayClient, DisableGatewayResponse] =
          primitive(_.disableGateway(request))

        def disassociateFileSystem(
          request: DisassociateFileSystemRequest
        ): Kleisli[M, StorageGatewayClient, DisassociateFileSystemResponse] =
          primitive(_.disassociateFileSystem(request))

        def joinDomain(
          request: JoinDomainRequest
        ): Kleisli[M, StorageGatewayClient, JoinDomainResponse] =
          primitive(_.joinDomain(request))

        def listAutomaticTapeCreationPolicies(
          request: ListAutomaticTapeCreationPoliciesRequest
        ): Kleisli[M, StorageGatewayClient, ListAutomaticTapeCreationPoliciesResponse] =
          primitive(_.listAutomaticTapeCreationPolicies(request))

        def listFileShares(
          request: ListFileSharesRequest
        ): Kleisli[M, StorageGatewayClient, ListFileSharesResponse] =
          primitive(_.listFileShares(request))

        def listFileSystemAssociations(
          request: ListFileSystemAssociationsRequest
        ): Kleisli[M, StorageGatewayClient, ListFileSystemAssociationsResponse] =
          primitive(_.listFileSystemAssociations(request))

        def listGateways(
          request: ListGatewaysRequest
        ): Kleisli[M, StorageGatewayClient, ListGatewaysResponse] =
          primitive(_.listGateways(request))

        def listLocalDisks(
          request: ListLocalDisksRequest
        ): Kleisli[M, StorageGatewayClient, ListLocalDisksResponse] =
          primitive(_.listLocalDisks(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, StorageGatewayClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTapePools(
          request: ListTapePoolsRequest
        ): Kleisli[M, StorageGatewayClient, ListTapePoolsResponse] =
          primitive(_.listTapePools(request))

        def listTapes(
          request: ListTapesRequest
        ): Kleisli[M, StorageGatewayClient, ListTapesResponse] =
          primitive(_.listTapes(request))

        def listVolumeInitiators(
          request: ListVolumeInitiatorsRequest
        ): Kleisli[M, StorageGatewayClient, ListVolumeInitiatorsResponse] =
          primitive(_.listVolumeInitiators(request))

        def listVolumeRecoveryPoints(
          request: ListVolumeRecoveryPointsRequest
        ): Kleisli[M, StorageGatewayClient, ListVolumeRecoveryPointsResponse] =
          primitive(_.listVolumeRecoveryPoints(request))

        def listVolumes(
          request: ListVolumesRequest
        ): Kleisli[M, StorageGatewayClient, ListVolumesResponse] =
          primitive(_.listVolumes(request))

        def notifyWhenUploaded(
          request: NotifyWhenUploadedRequest
        ): Kleisli[M, StorageGatewayClient, NotifyWhenUploadedResponse] =
          primitive(_.notifyWhenUploaded(request))

        def refreshCache(
          request: RefreshCacheRequest
        ): Kleisli[M, StorageGatewayClient, RefreshCacheResponse] =
          primitive(_.refreshCache(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, StorageGatewayClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def resetCache(
          request: ResetCacheRequest
        ): Kleisli[M, StorageGatewayClient, ResetCacheResponse] =
          primitive(_.resetCache(request))

        def retrieveTapeArchive(
          request: RetrieveTapeArchiveRequest
        ): Kleisli[M, StorageGatewayClient, RetrieveTapeArchiveResponse] =
          primitive(_.retrieveTapeArchive(request))

        def retrieveTapeRecoveryPoint(
          request: RetrieveTapeRecoveryPointRequest
        ): Kleisli[M, StorageGatewayClient, RetrieveTapeRecoveryPointResponse] =
          primitive(_.retrieveTapeRecoveryPoint(request))

        def setLocalConsolePassword(
          request: SetLocalConsolePasswordRequest
        ): Kleisli[M, StorageGatewayClient, SetLocalConsolePasswordResponse] =
          primitive(_.setLocalConsolePassword(request))

        def setSMBGuestPassword(
          request: SetSmbGuestPasswordRequest
        ): Kleisli[M, StorageGatewayClient, SetSmbGuestPasswordResponse] =
          primitive(_.setSMBGuestPassword(request))

        def shutdownGateway(
          request: ShutdownGatewayRequest
        ): Kleisli[M, StorageGatewayClient, ShutdownGatewayResponse] =
          primitive(_.shutdownGateway(request))

        def startAvailabilityMonitorTest(
          request: StartAvailabilityMonitorTestRequest
        ): Kleisli[M, StorageGatewayClient, StartAvailabilityMonitorTestResponse] =
          primitive(_.startAvailabilityMonitorTest(request))

        def startGateway(
          request: StartGatewayRequest
        ): Kleisli[M, StorageGatewayClient, StartGatewayResponse] =
          primitive(_.startGateway(request))

        def updateAutomaticTapeCreationPolicy(
          request: UpdateAutomaticTapeCreationPolicyRequest
        ): Kleisli[M, StorageGatewayClient, UpdateAutomaticTapeCreationPolicyResponse] =
          primitive(_.updateAutomaticTapeCreationPolicy(request))

        def updateBandwidthRateLimit(
          request: UpdateBandwidthRateLimitRequest
        ): Kleisli[M, StorageGatewayClient, UpdateBandwidthRateLimitResponse] =
          primitive(_.updateBandwidthRateLimit(request))

        def updateBandwidthRateLimitSchedule(
          request: UpdateBandwidthRateLimitScheduleRequest
        ): Kleisli[M, StorageGatewayClient, UpdateBandwidthRateLimitScheduleResponse] =
          primitive(_.updateBandwidthRateLimitSchedule(request))

        def updateChapCredentials(
          request: UpdateChapCredentialsRequest
        ): Kleisli[M, StorageGatewayClient, UpdateChapCredentialsResponse] =
          primitive(_.updateChapCredentials(request))

        def updateFileSystemAssociation(
          request: UpdateFileSystemAssociationRequest
        ): Kleisli[M, StorageGatewayClient, UpdateFileSystemAssociationResponse] =
          primitive(_.updateFileSystemAssociation(request))

        def updateGatewayInformation(
          request: UpdateGatewayInformationRequest
        ): Kleisli[M, StorageGatewayClient, UpdateGatewayInformationResponse] =
          primitive(_.updateGatewayInformation(request))

        def updateGatewaySoftwareNow(
          request: UpdateGatewaySoftwareNowRequest
        ): Kleisli[M, StorageGatewayClient, UpdateGatewaySoftwareNowResponse] =
          primitive(_.updateGatewaySoftwareNow(request))

        def updateMaintenanceStartTime(
          request: UpdateMaintenanceStartTimeRequest
        ): Kleisli[M, StorageGatewayClient, UpdateMaintenanceStartTimeResponse] =
          primitive(_.updateMaintenanceStartTime(request))

        def updateNFSFileShare(
          request: UpdateNfsFileShareRequest
        ): Kleisli[M, StorageGatewayClient, UpdateNfsFileShareResponse] =
          primitive(_.updateNFSFileShare(request))

        def updateSMBFileShare(
          request: UpdateSmbFileShareRequest
        ): Kleisli[M, StorageGatewayClient, UpdateSmbFileShareResponse] =
          primitive(_.updateSMBFileShare(request))

        def updateSMBFileShareVisibility(
          request: UpdateSmbFileShareVisibilityRequest
        ): Kleisli[M, StorageGatewayClient, UpdateSmbFileShareVisibilityResponse] =
          primitive(_.updateSMBFileShareVisibility(request))

        def updateSMBSecurityStrategy(
          request: UpdateSmbSecurityStrategyRequest
        ): Kleisli[M, StorageGatewayClient, UpdateSmbSecurityStrategyResponse] =
          primitive(_.updateSMBSecurityStrategy(request))

        def updateSnapshotSchedule(
          request: UpdateSnapshotScheduleRequest
        ): Kleisli[M, StorageGatewayClient, UpdateSnapshotScheduleResponse] =
          primitive(_.updateSnapshotSchedule(request))

        def updateVTLDeviceType(
          request: UpdateVtlDeviceTypeRequest
        ): Kleisli[M, StorageGatewayClient, UpdateVtlDeviceTypeResponse] =
          primitive(_.updateVTLDeviceType(request))

        def primitive[A](
          f: StorageGatewayClient => A
        ): Kleisli[M, StorageGatewayClient, A]
      }
    }

    trait Visitor[F[_]] extends (StorageGatewayOp ~> F) {
      final def apply[A](op: StorageGatewayOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def activateGateway(
        request: ActivateGatewayRequest
      ): F[ActivateGatewayResponse]

      def addCache(
        request: AddCacheRequest
      ): F[AddCacheResponse]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def addUploadBuffer(
        request: AddUploadBufferRequest
      ): F[AddUploadBufferResponse]

      def addWorkingStorage(
        request: AddWorkingStorageRequest
      ): F[AddWorkingStorageResponse]

      def assignTapePool(
        request: AssignTapePoolRequest
      ): F[AssignTapePoolResponse]

      def associateFileSystem(
        request: AssociateFileSystemRequest
      ): F[AssociateFileSystemResponse]

      def attachVolume(
        request: AttachVolumeRequest
      ): F[AttachVolumeResponse]

      def cancelArchival(
        request: CancelArchivalRequest
      ): F[CancelArchivalResponse]

      def cancelRetrieval(
        request: CancelRetrievalRequest
      ): F[CancelRetrievalResponse]

      def createCachediSCSIVolume(
        request: CreateCachediScsiVolumeRequest
      ): F[CreateCachediScsiVolumeResponse]

      def createNFSFileShare(
        request: CreateNfsFileShareRequest
      ): F[CreateNfsFileShareResponse]

      def createSMBFileShare(
        request: CreateSmbFileShareRequest
      ): F[CreateSmbFileShareResponse]

      def createSnapshot(
        request: CreateSnapshotRequest
      ): F[CreateSnapshotResponse]

      def createSnapshotFromVolumeRecoveryPoint(
        request: CreateSnapshotFromVolumeRecoveryPointRequest
      ): F[CreateSnapshotFromVolumeRecoveryPointResponse]

      def createStorediSCSIVolume(
        request: CreateStorediScsiVolumeRequest
      ): F[CreateStorediScsiVolumeResponse]

      def createTapePool(
        request: CreateTapePoolRequest
      ): F[CreateTapePoolResponse]

      def createTapeWithBarcode(
        request: CreateTapeWithBarcodeRequest
      ): F[CreateTapeWithBarcodeResponse]

      def createTapes(
        request: CreateTapesRequest
      ): F[CreateTapesResponse]

      def deleteAutomaticTapeCreationPolicy(
        request: DeleteAutomaticTapeCreationPolicyRequest
      ): F[DeleteAutomaticTapeCreationPolicyResponse]

      def deleteBandwidthRateLimit(
        request: DeleteBandwidthRateLimitRequest
      ): F[DeleteBandwidthRateLimitResponse]

      def deleteChapCredentials(
        request: DeleteChapCredentialsRequest
      ): F[DeleteChapCredentialsResponse]

      def deleteFileShare(
        request: DeleteFileShareRequest
      ): F[DeleteFileShareResponse]

      def deleteGateway(
        request: DeleteGatewayRequest
      ): F[DeleteGatewayResponse]

      def deleteSnapshotSchedule(
        request: DeleteSnapshotScheduleRequest
      ): F[DeleteSnapshotScheduleResponse]

      def deleteTape(
        request: DeleteTapeRequest
      ): F[DeleteTapeResponse]

      def deleteTapeArchive(
        request: DeleteTapeArchiveRequest
      ): F[DeleteTapeArchiveResponse]

      def deleteTapePool(
        request: DeleteTapePoolRequest
      ): F[DeleteTapePoolResponse]

      def deleteVolume(
        request: DeleteVolumeRequest
      ): F[DeleteVolumeResponse]

      def describeAvailabilityMonitorTest(
        request: DescribeAvailabilityMonitorTestRequest
      ): F[DescribeAvailabilityMonitorTestResponse]

      def describeBandwidthRateLimit(
        request: DescribeBandwidthRateLimitRequest
      ): F[DescribeBandwidthRateLimitResponse]

      def describeBandwidthRateLimitSchedule(
        request: DescribeBandwidthRateLimitScheduleRequest
      ): F[DescribeBandwidthRateLimitScheduleResponse]

      def describeCache(
        request: DescribeCacheRequest
      ): F[DescribeCacheResponse]

      def describeCachediSCSIVolumes(
        request: DescribeCachediScsiVolumesRequest
      ): F[DescribeCachediScsiVolumesResponse]

      def describeChapCredentials(
        request: DescribeChapCredentialsRequest
      ): F[DescribeChapCredentialsResponse]

      def describeFileSystemAssociations(
        request: DescribeFileSystemAssociationsRequest
      ): F[DescribeFileSystemAssociationsResponse]

      def describeGatewayInformation(
        request: DescribeGatewayInformationRequest
      ): F[DescribeGatewayInformationResponse]

      def describeMaintenanceStartTime(
        request: DescribeMaintenanceStartTimeRequest
      ): F[DescribeMaintenanceStartTimeResponse]

      def describeNFSFileShares(
        request: DescribeNfsFileSharesRequest
      ): F[DescribeNfsFileSharesResponse]

      def describeSMBFileShares(
        request: DescribeSmbFileSharesRequest
      ): F[DescribeSmbFileSharesResponse]

      def describeSMBSettings(
        request: DescribeSmbSettingsRequest
      ): F[DescribeSmbSettingsResponse]

      def describeSnapshotSchedule(
        request: DescribeSnapshotScheduleRequest
      ): F[DescribeSnapshotScheduleResponse]

      def describeStorediSCSIVolumes(
        request: DescribeStorediScsiVolumesRequest
      ): F[DescribeStorediScsiVolumesResponse]

      def describeTapeArchives(
        request: DescribeTapeArchivesRequest
      ): F[DescribeTapeArchivesResponse]

      def describeTapeRecoveryPoints(
        request: DescribeTapeRecoveryPointsRequest
      ): F[DescribeTapeRecoveryPointsResponse]

      def describeTapes(
        request: DescribeTapesRequest
      ): F[DescribeTapesResponse]

      def describeUploadBuffer(
        request: DescribeUploadBufferRequest
      ): F[DescribeUploadBufferResponse]

      def describeVTLDevices(
        request: DescribeVtlDevicesRequest
      ): F[DescribeVtlDevicesResponse]

      def describeWorkingStorage(
        request: DescribeWorkingStorageRequest
      ): F[DescribeWorkingStorageResponse]

      def detachVolume(
        request: DetachVolumeRequest
      ): F[DetachVolumeResponse]

      def disableGateway(
        request: DisableGatewayRequest
      ): F[DisableGatewayResponse]

      def disassociateFileSystem(
        request: DisassociateFileSystemRequest
      ): F[DisassociateFileSystemResponse]

      def joinDomain(
        request: JoinDomainRequest
      ): F[JoinDomainResponse]

      def listAutomaticTapeCreationPolicies(
        request: ListAutomaticTapeCreationPoliciesRequest
      ): F[ListAutomaticTapeCreationPoliciesResponse]

      def listFileShares(
        request: ListFileSharesRequest
      ): F[ListFileSharesResponse]

      def listFileSystemAssociations(
        request: ListFileSystemAssociationsRequest
      ): F[ListFileSystemAssociationsResponse]

      def listGateways(
        request: ListGatewaysRequest
      ): F[ListGatewaysResponse]

      def listLocalDisks(
        request: ListLocalDisksRequest
      ): F[ListLocalDisksResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTapePools(
        request: ListTapePoolsRequest
      ): F[ListTapePoolsResponse]

      def listTapes(
        request: ListTapesRequest
      ): F[ListTapesResponse]

      def listVolumeInitiators(
        request: ListVolumeInitiatorsRequest
      ): F[ListVolumeInitiatorsResponse]

      def listVolumeRecoveryPoints(
        request: ListVolumeRecoveryPointsRequest
      ): F[ListVolumeRecoveryPointsResponse]

      def listVolumes(
        request: ListVolumesRequest
      ): F[ListVolumesResponse]

      def notifyWhenUploaded(
        request: NotifyWhenUploadedRequest
      ): F[NotifyWhenUploadedResponse]

      def refreshCache(
        request: RefreshCacheRequest
      ): F[RefreshCacheResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]

      def resetCache(
        request: ResetCacheRequest
      ): F[ResetCacheResponse]

      def retrieveTapeArchive(
        request: RetrieveTapeArchiveRequest
      ): F[RetrieveTapeArchiveResponse]

      def retrieveTapeRecoveryPoint(
        request: RetrieveTapeRecoveryPointRequest
      ): F[RetrieveTapeRecoveryPointResponse]

      def setLocalConsolePassword(
        request: SetLocalConsolePasswordRequest
      ): F[SetLocalConsolePasswordResponse]

      def setSMBGuestPassword(
        request: SetSmbGuestPasswordRequest
      ): F[SetSmbGuestPasswordResponse]

      def shutdownGateway(
        request: ShutdownGatewayRequest
      ): F[ShutdownGatewayResponse]

      def startAvailabilityMonitorTest(
        request: StartAvailabilityMonitorTestRequest
      ): F[StartAvailabilityMonitorTestResponse]

      def startGateway(
        request: StartGatewayRequest
      ): F[StartGatewayResponse]

      def updateAutomaticTapeCreationPolicy(
        request: UpdateAutomaticTapeCreationPolicyRequest
      ): F[UpdateAutomaticTapeCreationPolicyResponse]

      def updateBandwidthRateLimit(
        request: UpdateBandwidthRateLimitRequest
      ): F[UpdateBandwidthRateLimitResponse]

      def updateBandwidthRateLimitSchedule(
        request: UpdateBandwidthRateLimitScheduleRequest
      ): F[UpdateBandwidthRateLimitScheduleResponse]

      def updateChapCredentials(
        request: UpdateChapCredentialsRequest
      ): F[UpdateChapCredentialsResponse]

      def updateFileSystemAssociation(
        request: UpdateFileSystemAssociationRequest
      ): F[UpdateFileSystemAssociationResponse]

      def updateGatewayInformation(
        request: UpdateGatewayInformationRequest
      ): F[UpdateGatewayInformationResponse]

      def updateGatewaySoftwareNow(
        request: UpdateGatewaySoftwareNowRequest
      ): F[UpdateGatewaySoftwareNowResponse]

      def updateMaintenanceStartTime(
        request: UpdateMaintenanceStartTimeRequest
      ): F[UpdateMaintenanceStartTimeResponse]

      def updateNFSFileShare(
        request: UpdateNfsFileShareRequest
      ): F[UpdateNfsFileShareResponse]

      def updateSMBFileShare(
        request: UpdateSmbFileShareRequest
      ): F[UpdateSmbFileShareResponse]

      def updateSMBFileShareVisibility(
        request: UpdateSmbFileShareVisibilityRequest
      ): F[UpdateSmbFileShareVisibilityResponse]

      def updateSMBSecurityStrategy(
        request: UpdateSmbSecurityStrategyRequest
      ): F[UpdateSmbSecurityStrategyResponse]

      def updateSnapshotSchedule(
        request: UpdateSnapshotScheduleRequest
      ): F[UpdateSnapshotScheduleResponse]

      def updateVTLDeviceType(
        request: UpdateVtlDeviceTypeRequest
      ): F[UpdateVtlDeviceTypeResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends StorageGatewayOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ActivateGatewayOp(
      request: ActivateGatewayRequest
    ) extends StorageGatewayOp[ActivateGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ActivateGatewayResponse] =
        visitor.activateGateway(request)
    }

    final case class AddCacheOp(
      request: AddCacheRequest
    ) extends StorageGatewayOp[AddCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddCacheResponse] =
        visitor.addCache(request)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends StorageGatewayOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class AddUploadBufferOp(
      request: AddUploadBufferRequest
    ) extends StorageGatewayOp[AddUploadBufferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddUploadBufferResponse] =
        visitor.addUploadBuffer(request)
    }

    final case class AddWorkingStorageOp(
      request: AddWorkingStorageRequest
    ) extends StorageGatewayOp[AddWorkingStorageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddWorkingStorageResponse] =
        visitor.addWorkingStorage(request)
    }

    final case class AssignTapePoolOp(
      request: AssignTapePoolRequest
    ) extends StorageGatewayOp[AssignTapePoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssignTapePoolResponse] =
        visitor.assignTapePool(request)
    }

    final case class AssociateFileSystemOp(
      request: AssociateFileSystemRequest
    ) extends StorageGatewayOp[AssociateFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateFileSystemResponse] =
        visitor.associateFileSystem(request)
    }

    final case class AttachVolumeOp(
      request: AttachVolumeRequest
    ) extends StorageGatewayOp[AttachVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachVolumeResponse] =
        visitor.attachVolume(request)
    }

    final case class CancelArchivalOp(
      request: CancelArchivalRequest
    ) extends StorageGatewayOp[CancelArchivalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelArchivalResponse] =
        visitor.cancelArchival(request)
    }

    final case class CancelRetrievalOp(
      request: CancelRetrievalRequest
    ) extends StorageGatewayOp[CancelRetrievalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelRetrievalResponse] =
        visitor.cancelRetrieval(request)
    }

    final case class CreateCachediSCSIVolumeOp(
      request: CreateCachediScsiVolumeRequest
    ) extends StorageGatewayOp[CreateCachediScsiVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCachediScsiVolumeResponse] =
        visitor.createCachediSCSIVolume(request)
    }

    final case class CreateNFSFileShareOp(
      request: CreateNfsFileShareRequest
    ) extends StorageGatewayOp[CreateNfsFileShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNfsFileShareResponse] =
        visitor.createNFSFileShare(request)
    }

    final case class CreateSMBFileShareOp(
      request: CreateSmbFileShareRequest
    ) extends StorageGatewayOp[CreateSmbFileShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSmbFileShareResponse] =
        visitor.createSMBFileShare(request)
    }

    final case class CreateSnapshotOp(
      request: CreateSnapshotRequest
    ) extends StorageGatewayOp[CreateSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotResponse] =
        visitor.createSnapshot(request)
    }

    final case class CreateSnapshotFromVolumeRecoveryPointOp(
      request: CreateSnapshotFromVolumeRecoveryPointRequest
    ) extends StorageGatewayOp[CreateSnapshotFromVolumeRecoveryPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotFromVolumeRecoveryPointResponse] =
        visitor.createSnapshotFromVolumeRecoveryPoint(request)
    }

    final case class CreateStorediSCSIVolumeOp(
      request: CreateStorediScsiVolumeRequest
    ) extends StorageGatewayOp[CreateStorediScsiVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStorediScsiVolumeResponse] =
        visitor.createStorediSCSIVolume(request)
    }

    final case class CreateTapePoolOp(
      request: CreateTapePoolRequest
    ) extends StorageGatewayOp[CreateTapePoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTapePoolResponse] =
        visitor.createTapePool(request)
    }

    final case class CreateTapeWithBarcodeOp(
      request: CreateTapeWithBarcodeRequest
    ) extends StorageGatewayOp[CreateTapeWithBarcodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTapeWithBarcodeResponse] =
        visitor.createTapeWithBarcode(request)
    }

    final case class CreateTapesOp(
      request: CreateTapesRequest
    ) extends StorageGatewayOp[CreateTapesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTapesResponse] =
        visitor.createTapes(request)
    }

    final case class DeleteAutomaticTapeCreationPolicyOp(
      request: DeleteAutomaticTapeCreationPolicyRequest
    ) extends StorageGatewayOp[DeleteAutomaticTapeCreationPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAutomaticTapeCreationPolicyResponse] =
        visitor.deleteAutomaticTapeCreationPolicy(request)
    }

    final case class DeleteBandwidthRateLimitOp(
      request: DeleteBandwidthRateLimitRequest
    ) extends StorageGatewayOp[DeleteBandwidthRateLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBandwidthRateLimitResponse] =
        visitor.deleteBandwidthRateLimit(request)
    }

    final case class DeleteChapCredentialsOp(
      request: DeleteChapCredentialsRequest
    ) extends StorageGatewayOp[DeleteChapCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChapCredentialsResponse] =
        visitor.deleteChapCredentials(request)
    }

    final case class DeleteFileShareOp(
      request: DeleteFileShareRequest
    ) extends StorageGatewayOp[DeleteFileShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFileShareResponse] =
        visitor.deleteFileShare(request)
    }

    final case class DeleteGatewayOp(
      request: DeleteGatewayRequest
    ) extends StorageGatewayOp[DeleteGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGatewayResponse] =
        visitor.deleteGateway(request)
    }

    final case class DeleteSnapshotScheduleOp(
      request: DeleteSnapshotScheduleRequest
    ) extends StorageGatewayOp[DeleteSnapshotScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSnapshotScheduleResponse] =
        visitor.deleteSnapshotSchedule(request)
    }

    final case class DeleteTapeOp(
      request: DeleteTapeRequest
    ) extends StorageGatewayOp[DeleteTapeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTapeResponse] =
        visitor.deleteTape(request)
    }

    final case class DeleteTapeArchiveOp(
      request: DeleteTapeArchiveRequest
    ) extends StorageGatewayOp[DeleteTapeArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTapeArchiveResponse] =
        visitor.deleteTapeArchive(request)
    }

    final case class DeleteTapePoolOp(
      request: DeleteTapePoolRequest
    ) extends StorageGatewayOp[DeleteTapePoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTapePoolResponse] =
        visitor.deleteTapePool(request)
    }

    final case class DeleteVolumeOp(
      request: DeleteVolumeRequest
    ) extends StorageGatewayOp[DeleteVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVolumeResponse] =
        visitor.deleteVolume(request)
    }

    final case class DescribeAvailabilityMonitorTestOp(
      request: DescribeAvailabilityMonitorTestRequest
    ) extends StorageGatewayOp[DescribeAvailabilityMonitorTestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAvailabilityMonitorTestResponse] =
        visitor.describeAvailabilityMonitorTest(request)
    }

    final case class DescribeBandwidthRateLimitOp(
      request: DescribeBandwidthRateLimitRequest
    ) extends StorageGatewayOp[DescribeBandwidthRateLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBandwidthRateLimitResponse] =
        visitor.describeBandwidthRateLimit(request)
    }

    final case class DescribeBandwidthRateLimitScheduleOp(
      request: DescribeBandwidthRateLimitScheduleRequest
    ) extends StorageGatewayOp[DescribeBandwidthRateLimitScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBandwidthRateLimitScheduleResponse] =
        visitor.describeBandwidthRateLimitSchedule(request)
    }

    final case class DescribeCacheOp(
      request: DescribeCacheRequest
    ) extends StorageGatewayOp[DescribeCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCacheResponse] =
        visitor.describeCache(request)
    }

    final case class DescribeCachediSCSIVolumesOp(
      request: DescribeCachediScsiVolumesRequest
    ) extends StorageGatewayOp[DescribeCachediScsiVolumesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCachediScsiVolumesResponse] =
        visitor.describeCachediSCSIVolumes(request)
    }

    final case class DescribeChapCredentialsOp(
      request: DescribeChapCredentialsRequest
    ) extends StorageGatewayOp[DescribeChapCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChapCredentialsResponse] =
        visitor.describeChapCredentials(request)
    }

    final case class DescribeFileSystemAssociationsOp(
      request: DescribeFileSystemAssociationsRequest
    ) extends StorageGatewayOp[DescribeFileSystemAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFileSystemAssociationsResponse] =
        visitor.describeFileSystemAssociations(request)
    }

    final case class DescribeGatewayInformationOp(
      request: DescribeGatewayInformationRequest
    ) extends StorageGatewayOp[DescribeGatewayInformationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGatewayInformationResponse] =
        visitor.describeGatewayInformation(request)
    }

    final case class DescribeMaintenanceStartTimeOp(
      request: DescribeMaintenanceStartTimeRequest
    ) extends StorageGatewayOp[DescribeMaintenanceStartTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceStartTimeResponse] =
        visitor.describeMaintenanceStartTime(request)
    }

    final case class DescribeNFSFileSharesOp(
      request: DescribeNfsFileSharesRequest
    ) extends StorageGatewayOp[DescribeNfsFileSharesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNfsFileSharesResponse] =
        visitor.describeNFSFileShares(request)
    }

    final case class DescribeSMBFileSharesOp(
      request: DescribeSmbFileSharesRequest
    ) extends StorageGatewayOp[DescribeSmbFileSharesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSmbFileSharesResponse] =
        visitor.describeSMBFileShares(request)
    }

    final case class DescribeSMBSettingsOp(
      request: DescribeSmbSettingsRequest
    ) extends StorageGatewayOp[DescribeSmbSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSmbSettingsResponse] =
        visitor.describeSMBSettings(request)
    }

    final case class DescribeSnapshotScheduleOp(
      request: DescribeSnapshotScheduleRequest
    ) extends StorageGatewayOp[DescribeSnapshotScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSnapshotScheduleResponse] =
        visitor.describeSnapshotSchedule(request)
    }

    final case class DescribeStorediSCSIVolumesOp(
      request: DescribeStorediScsiVolumesRequest
    ) extends StorageGatewayOp[DescribeStorediScsiVolumesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStorediScsiVolumesResponse] =
        visitor.describeStorediSCSIVolumes(request)
    }

    final case class DescribeTapeArchivesOp(
      request: DescribeTapeArchivesRequest
    ) extends StorageGatewayOp[DescribeTapeArchivesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTapeArchivesResponse] =
        visitor.describeTapeArchives(request)
    }

    final case class DescribeTapeRecoveryPointsOp(
      request: DescribeTapeRecoveryPointsRequest
    ) extends StorageGatewayOp[DescribeTapeRecoveryPointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTapeRecoveryPointsResponse] =
        visitor.describeTapeRecoveryPoints(request)
    }

    final case class DescribeTapesOp(
      request: DescribeTapesRequest
    ) extends StorageGatewayOp[DescribeTapesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTapesResponse] =
        visitor.describeTapes(request)
    }

    final case class DescribeUploadBufferOp(
      request: DescribeUploadBufferRequest
    ) extends StorageGatewayOp[DescribeUploadBufferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUploadBufferResponse] =
        visitor.describeUploadBuffer(request)
    }

    final case class DescribeVTLDevicesOp(
      request: DescribeVtlDevicesRequest
    ) extends StorageGatewayOp[DescribeVtlDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVtlDevicesResponse] =
        visitor.describeVTLDevices(request)
    }

    final case class DescribeWorkingStorageOp(
      request: DescribeWorkingStorageRequest
    ) extends StorageGatewayOp[DescribeWorkingStorageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkingStorageResponse] =
        visitor.describeWorkingStorage(request)
    }

    final case class DetachVolumeOp(
      request: DetachVolumeRequest
    ) extends StorageGatewayOp[DetachVolumeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachVolumeResponse] =
        visitor.detachVolume(request)
    }

    final case class DisableGatewayOp(
      request: DisableGatewayRequest
    ) extends StorageGatewayOp[DisableGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableGatewayResponse] =
        visitor.disableGateway(request)
    }

    final case class DisassociateFileSystemOp(
      request: DisassociateFileSystemRequest
    ) extends StorageGatewayOp[DisassociateFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFileSystemResponse] =
        visitor.disassociateFileSystem(request)
    }

    final case class JoinDomainOp(
      request: JoinDomainRequest
    ) extends StorageGatewayOp[JoinDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[JoinDomainResponse] =
        visitor.joinDomain(request)
    }

    final case class ListAutomaticTapeCreationPoliciesOp(
      request: ListAutomaticTapeCreationPoliciesRequest
    ) extends StorageGatewayOp[ListAutomaticTapeCreationPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAutomaticTapeCreationPoliciesResponse] =
        visitor.listAutomaticTapeCreationPolicies(request)
    }

    final case class ListFileSharesOp(
      request: ListFileSharesRequest
    ) extends StorageGatewayOp[ListFileSharesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFileSharesResponse] =
        visitor.listFileShares(request)
    }

    final case class ListFileSystemAssociationsOp(
      request: ListFileSystemAssociationsRequest
    ) extends StorageGatewayOp[ListFileSystemAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFileSystemAssociationsResponse] =
        visitor.listFileSystemAssociations(request)
    }

    final case class ListGatewaysOp(
      request: ListGatewaysRequest
    ) extends StorageGatewayOp[ListGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGatewaysResponse] =
        visitor.listGateways(request)
    }

    final case class ListLocalDisksOp(
      request: ListLocalDisksRequest
    ) extends StorageGatewayOp[ListLocalDisksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLocalDisksResponse] =
        visitor.listLocalDisks(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends StorageGatewayOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTapePoolsOp(
      request: ListTapePoolsRequest
    ) extends StorageGatewayOp[ListTapePoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTapePoolsResponse] =
        visitor.listTapePools(request)
    }

    final case class ListTapesOp(
      request: ListTapesRequest
    ) extends StorageGatewayOp[ListTapesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTapesResponse] =
        visitor.listTapes(request)
    }

    final case class ListVolumeInitiatorsOp(
      request: ListVolumeInitiatorsRequest
    ) extends StorageGatewayOp[ListVolumeInitiatorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVolumeInitiatorsResponse] =
        visitor.listVolumeInitiators(request)
    }

    final case class ListVolumeRecoveryPointsOp(
      request: ListVolumeRecoveryPointsRequest
    ) extends StorageGatewayOp[ListVolumeRecoveryPointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVolumeRecoveryPointsResponse] =
        visitor.listVolumeRecoveryPoints(request)
    }

    final case class ListVolumesOp(
      request: ListVolumesRequest
    ) extends StorageGatewayOp[ListVolumesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVolumesResponse] =
        visitor.listVolumes(request)
    }

    final case class NotifyWhenUploadedOp(
      request: NotifyWhenUploadedRequest
    ) extends StorageGatewayOp[NotifyWhenUploadedResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[NotifyWhenUploadedResponse] =
        visitor.notifyWhenUploaded(request)
    }

    final case class RefreshCacheOp(
      request: RefreshCacheRequest
    ) extends StorageGatewayOp[RefreshCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RefreshCacheResponse] =
        visitor.refreshCache(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends StorageGatewayOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class ResetCacheOp(
      request: ResetCacheRequest
    ) extends StorageGatewayOp[ResetCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetCacheResponse] =
        visitor.resetCache(request)
    }

    final case class RetrieveTapeArchiveOp(
      request: RetrieveTapeArchiveRequest
    ) extends StorageGatewayOp[RetrieveTapeArchiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetrieveTapeArchiveResponse] =
        visitor.retrieveTapeArchive(request)
    }

    final case class RetrieveTapeRecoveryPointOp(
      request: RetrieveTapeRecoveryPointRequest
    ) extends StorageGatewayOp[RetrieveTapeRecoveryPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetrieveTapeRecoveryPointResponse] =
        visitor.retrieveTapeRecoveryPoint(request)
    }

    final case class SetLocalConsolePasswordOp(
      request: SetLocalConsolePasswordRequest
    ) extends StorageGatewayOp[SetLocalConsolePasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetLocalConsolePasswordResponse] =
        visitor.setLocalConsolePassword(request)
    }

    final case class SetSMBGuestPasswordOp(
      request: SetSmbGuestPasswordRequest
    ) extends StorageGatewayOp[SetSmbGuestPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetSmbGuestPasswordResponse] =
        visitor.setSMBGuestPassword(request)
    }

    final case class ShutdownGatewayOp(
      request: ShutdownGatewayRequest
    ) extends StorageGatewayOp[ShutdownGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ShutdownGatewayResponse] =
        visitor.shutdownGateway(request)
    }

    final case class StartAvailabilityMonitorTestOp(
      request: StartAvailabilityMonitorTestRequest
    ) extends StorageGatewayOp[StartAvailabilityMonitorTestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAvailabilityMonitorTestResponse] =
        visitor.startAvailabilityMonitorTest(request)
    }

    final case class StartGatewayOp(
      request: StartGatewayRequest
    ) extends StorageGatewayOp[StartGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartGatewayResponse] =
        visitor.startGateway(request)
    }

    final case class UpdateAutomaticTapeCreationPolicyOp(
      request: UpdateAutomaticTapeCreationPolicyRequest
    ) extends StorageGatewayOp[UpdateAutomaticTapeCreationPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAutomaticTapeCreationPolicyResponse] =
        visitor.updateAutomaticTapeCreationPolicy(request)
    }

    final case class UpdateBandwidthRateLimitOp(
      request: UpdateBandwidthRateLimitRequest
    ) extends StorageGatewayOp[UpdateBandwidthRateLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBandwidthRateLimitResponse] =
        visitor.updateBandwidthRateLimit(request)
    }

    final case class UpdateBandwidthRateLimitScheduleOp(
      request: UpdateBandwidthRateLimitScheduleRequest
    ) extends StorageGatewayOp[UpdateBandwidthRateLimitScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBandwidthRateLimitScheduleResponse] =
        visitor.updateBandwidthRateLimitSchedule(request)
    }

    final case class UpdateChapCredentialsOp(
      request: UpdateChapCredentialsRequest
    ) extends StorageGatewayOp[UpdateChapCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChapCredentialsResponse] =
        visitor.updateChapCredentials(request)
    }

    final case class UpdateFileSystemAssociationOp(
      request: UpdateFileSystemAssociationRequest
    ) extends StorageGatewayOp[UpdateFileSystemAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFileSystemAssociationResponse] =
        visitor.updateFileSystemAssociation(request)
    }

    final case class UpdateGatewayInformationOp(
      request: UpdateGatewayInformationRequest
    ) extends StorageGatewayOp[UpdateGatewayInformationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewayInformationResponse] =
        visitor.updateGatewayInformation(request)
    }

    final case class UpdateGatewaySoftwareNowOp(
      request: UpdateGatewaySoftwareNowRequest
    ) extends StorageGatewayOp[UpdateGatewaySoftwareNowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewaySoftwareNowResponse] =
        visitor.updateGatewaySoftwareNow(request)
    }

    final case class UpdateMaintenanceStartTimeOp(
      request: UpdateMaintenanceStartTimeRequest
    ) extends StorageGatewayOp[UpdateMaintenanceStartTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMaintenanceStartTimeResponse] =
        visitor.updateMaintenanceStartTime(request)
    }

    final case class UpdateNFSFileShareOp(
      request: UpdateNfsFileShareRequest
    ) extends StorageGatewayOp[UpdateNfsFileShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNfsFileShareResponse] =
        visitor.updateNFSFileShare(request)
    }

    final case class UpdateSMBFileShareOp(
      request: UpdateSmbFileShareRequest
    ) extends StorageGatewayOp[UpdateSmbFileShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSmbFileShareResponse] =
        visitor.updateSMBFileShare(request)
    }

    final case class UpdateSMBFileShareVisibilityOp(
      request: UpdateSmbFileShareVisibilityRequest
    ) extends StorageGatewayOp[UpdateSmbFileShareVisibilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSmbFileShareVisibilityResponse] =
        visitor.updateSMBFileShareVisibility(request)
    }

    final case class UpdateSMBSecurityStrategyOp(
      request: UpdateSmbSecurityStrategyRequest
    ) extends StorageGatewayOp[UpdateSmbSecurityStrategyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSmbSecurityStrategyResponse] =
        visitor.updateSMBSecurityStrategy(request)
    }

    final case class UpdateSnapshotScheduleOp(
      request: UpdateSnapshotScheduleRequest
    ) extends StorageGatewayOp[UpdateSnapshotScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSnapshotScheduleResponse] =
        visitor.updateSnapshotSchedule(request)
    }

    final case class UpdateVTLDeviceTypeOp(
      request: UpdateVtlDeviceTypeRequest
    ) extends StorageGatewayOp[UpdateVtlDeviceTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVtlDeviceTypeResponse] =
        visitor.updateVTLDeviceType(request)
    }
  }

  import StorageGatewayOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[StorageGatewayOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def activateGateway(
    request: ActivateGatewayRequest
  ): StorageGatewayIO[ActivateGatewayResponse] =
    FF.liftF(ActivateGatewayOp(request))

  def addCache(
    request: AddCacheRequest
  ): StorageGatewayIO[AddCacheResponse] =
    FF.liftF(AddCacheOp(request))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): StorageGatewayIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def addUploadBuffer(
    request: AddUploadBufferRequest
  ): StorageGatewayIO[AddUploadBufferResponse] =
    FF.liftF(AddUploadBufferOp(request))

  def addWorkingStorage(
    request: AddWorkingStorageRequest
  ): StorageGatewayIO[AddWorkingStorageResponse] =
    FF.liftF(AddWorkingStorageOp(request))

  def assignTapePool(
    request: AssignTapePoolRequest
  ): StorageGatewayIO[AssignTapePoolResponse] =
    FF.liftF(AssignTapePoolOp(request))

  def associateFileSystem(
    request: AssociateFileSystemRequest
  ): StorageGatewayIO[AssociateFileSystemResponse] =
    FF.liftF(AssociateFileSystemOp(request))

  def attachVolume(
    request: AttachVolumeRequest
  ): StorageGatewayIO[AttachVolumeResponse] =
    FF.liftF(AttachVolumeOp(request))

  def cancelArchival(
    request: CancelArchivalRequest
  ): StorageGatewayIO[CancelArchivalResponse] =
    FF.liftF(CancelArchivalOp(request))

  def cancelRetrieval(
    request: CancelRetrievalRequest
  ): StorageGatewayIO[CancelRetrievalResponse] =
    FF.liftF(CancelRetrievalOp(request))

  def createCachediSCSIVolume(
    request: CreateCachediScsiVolumeRequest
  ): StorageGatewayIO[CreateCachediScsiVolumeResponse] =
    FF.liftF(CreateCachediSCSIVolumeOp(request))

  def createNFSFileShare(
    request: CreateNfsFileShareRequest
  ): StorageGatewayIO[CreateNfsFileShareResponse] =
    FF.liftF(CreateNFSFileShareOp(request))

  def createSMBFileShare(
    request: CreateSmbFileShareRequest
  ): StorageGatewayIO[CreateSmbFileShareResponse] =
    FF.liftF(CreateSMBFileShareOp(request))

  def createSnapshot(
    request: CreateSnapshotRequest
  ): StorageGatewayIO[CreateSnapshotResponse] =
    FF.liftF(CreateSnapshotOp(request))

  def createSnapshotFromVolumeRecoveryPoint(
    request: CreateSnapshotFromVolumeRecoveryPointRequest
  ): StorageGatewayIO[CreateSnapshotFromVolumeRecoveryPointResponse] =
    FF.liftF(CreateSnapshotFromVolumeRecoveryPointOp(request))

  def createStorediSCSIVolume(
    request: CreateStorediScsiVolumeRequest
  ): StorageGatewayIO[CreateStorediScsiVolumeResponse] =
    FF.liftF(CreateStorediSCSIVolumeOp(request))

  def createTapePool(
    request: CreateTapePoolRequest
  ): StorageGatewayIO[CreateTapePoolResponse] =
    FF.liftF(CreateTapePoolOp(request))

  def createTapeWithBarcode(
    request: CreateTapeWithBarcodeRequest
  ): StorageGatewayIO[CreateTapeWithBarcodeResponse] =
    FF.liftF(CreateTapeWithBarcodeOp(request))

  def createTapes(
    request: CreateTapesRequest
  ): StorageGatewayIO[CreateTapesResponse] =
    FF.liftF(CreateTapesOp(request))

  def deleteAutomaticTapeCreationPolicy(
    request: DeleteAutomaticTapeCreationPolicyRequest
  ): StorageGatewayIO[DeleteAutomaticTapeCreationPolicyResponse] =
    FF.liftF(DeleteAutomaticTapeCreationPolicyOp(request))

  def deleteBandwidthRateLimit(
    request: DeleteBandwidthRateLimitRequest
  ): StorageGatewayIO[DeleteBandwidthRateLimitResponse] =
    FF.liftF(DeleteBandwidthRateLimitOp(request))

  def deleteChapCredentials(
    request: DeleteChapCredentialsRequest
  ): StorageGatewayIO[DeleteChapCredentialsResponse] =
    FF.liftF(DeleteChapCredentialsOp(request))

  def deleteFileShare(
    request: DeleteFileShareRequest
  ): StorageGatewayIO[DeleteFileShareResponse] =
    FF.liftF(DeleteFileShareOp(request))

  def deleteGateway(
    request: DeleteGatewayRequest
  ): StorageGatewayIO[DeleteGatewayResponse] =
    FF.liftF(DeleteGatewayOp(request))

  def deleteSnapshotSchedule(
    request: DeleteSnapshotScheduleRequest
  ): StorageGatewayIO[DeleteSnapshotScheduleResponse] =
    FF.liftF(DeleteSnapshotScheduleOp(request))

  def deleteTape(
    request: DeleteTapeRequest
  ): StorageGatewayIO[DeleteTapeResponse] =
    FF.liftF(DeleteTapeOp(request))

  def deleteTapeArchive(
    request: DeleteTapeArchiveRequest
  ): StorageGatewayIO[DeleteTapeArchiveResponse] =
    FF.liftF(DeleteTapeArchiveOp(request))

  def deleteTapePool(
    request: DeleteTapePoolRequest
  ): StorageGatewayIO[DeleteTapePoolResponse] =
    FF.liftF(DeleteTapePoolOp(request))

  def deleteVolume(
    request: DeleteVolumeRequest
  ): StorageGatewayIO[DeleteVolumeResponse] =
    FF.liftF(DeleteVolumeOp(request))

  def describeAvailabilityMonitorTest(
    request: DescribeAvailabilityMonitorTestRequest
  ): StorageGatewayIO[DescribeAvailabilityMonitorTestResponse] =
    FF.liftF(DescribeAvailabilityMonitorTestOp(request))

  def describeBandwidthRateLimit(
    request: DescribeBandwidthRateLimitRequest
  ): StorageGatewayIO[DescribeBandwidthRateLimitResponse] =
    FF.liftF(DescribeBandwidthRateLimitOp(request))

  def describeBandwidthRateLimitSchedule(
    request: DescribeBandwidthRateLimitScheduleRequest
  ): StorageGatewayIO[DescribeBandwidthRateLimitScheduleResponse] =
    FF.liftF(DescribeBandwidthRateLimitScheduleOp(request))

  def describeCache(
    request: DescribeCacheRequest
  ): StorageGatewayIO[DescribeCacheResponse] =
    FF.liftF(DescribeCacheOp(request))

  def describeCachediSCSIVolumes(
    request: DescribeCachediScsiVolumesRequest
  ): StorageGatewayIO[DescribeCachediScsiVolumesResponse] =
    FF.liftF(DescribeCachediSCSIVolumesOp(request))

  def describeChapCredentials(
    request: DescribeChapCredentialsRequest
  ): StorageGatewayIO[DescribeChapCredentialsResponse] =
    FF.liftF(DescribeChapCredentialsOp(request))

  def describeFileSystemAssociations(
    request: DescribeFileSystemAssociationsRequest
  ): StorageGatewayIO[DescribeFileSystemAssociationsResponse] =
    FF.liftF(DescribeFileSystemAssociationsOp(request))

  def describeGatewayInformation(
    request: DescribeGatewayInformationRequest
  ): StorageGatewayIO[DescribeGatewayInformationResponse] =
    FF.liftF(DescribeGatewayInformationOp(request))

  def describeMaintenanceStartTime(
    request: DescribeMaintenanceStartTimeRequest
  ): StorageGatewayIO[DescribeMaintenanceStartTimeResponse] =
    FF.liftF(DescribeMaintenanceStartTimeOp(request))

  def describeNFSFileShares(
    request: DescribeNfsFileSharesRequest
  ): StorageGatewayIO[DescribeNfsFileSharesResponse] =
    FF.liftF(DescribeNFSFileSharesOp(request))

  def describeSMBFileShares(
    request: DescribeSmbFileSharesRequest
  ): StorageGatewayIO[DescribeSmbFileSharesResponse] =
    FF.liftF(DescribeSMBFileSharesOp(request))

  def describeSMBSettings(
    request: DescribeSmbSettingsRequest
  ): StorageGatewayIO[DescribeSmbSettingsResponse] =
    FF.liftF(DescribeSMBSettingsOp(request))

  def describeSnapshotSchedule(
    request: DescribeSnapshotScheduleRequest
  ): StorageGatewayIO[DescribeSnapshotScheduleResponse] =
    FF.liftF(DescribeSnapshotScheduleOp(request))

  def describeStorediSCSIVolumes(
    request: DescribeStorediScsiVolumesRequest
  ): StorageGatewayIO[DescribeStorediScsiVolumesResponse] =
    FF.liftF(DescribeStorediSCSIVolumesOp(request))

  def describeTapeArchives(
    request: DescribeTapeArchivesRequest
  ): StorageGatewayIO[DescribeTapeArchivesResponse] =
    FF.liftF(DescribeTapeArchivesOp(request))

  def describeTapeRecoveryPoints(
    request: DescribeTapeRecoveryPointsRequest
  ): StorageGatewayIO[DescribeTapeRecoveryPointsResponse] =
    FF.liftF(DescribeTapeRecoveryPointsOp(request))

  def describeTapes(
    request: DescribeTapesRequest
  ): StorageGatewayIO[DescribeTapesResponse] =
    FF.liftF(DescribeTapesOp(request))

  def describeUploadBuffer(
    request: DescribeUploadBufferRequest
  ): StorageGatewayIO[DescribeUploadBufferResponse] =
    FF.liftF(DescribeUploadBufferOp(request))

  def describeVTLDevices(
    request: DescribeVtlDevicesRequest
  ): StorageGatewayIO[DescribeVtlDevicesResponse] =
    FF.liftF(DescribeVTLDevicesOp(request))

  def describeWorkingStorage(
    request: DescribeWorkingStorageRequest
  ): StorageGatewayIO[DescribeWorkingStorageResponse] =
    FF.liftF(DescribeWorkingStorageOp(request))

  def detachVolume(
    request: DetachVolumeRequest
  ): StorageGatewayIO[DetachVolumeResponse] =
    FF.liftF(DetachVolumeOp(request))

  def disableGateway(
    request: DisableGatewayRequest
  ): StorageGatewayIO[DisableGatewayResponse] =
    FF.liftF(DisableGatewayOp(request))

  def disassociateFileSystem(
    request: DisassociateFileSystemRequest
  ): StorageGatewayIO[DisassociateFileSystemResponse] =
    FF.liftF(DisassociateFileSystemOp(request))

  def joinDomain(
    request: JoinDomainRequest
  ): StorageGatewayIO[JoinDomainResponse] =
    FF.liftF(JoinDomainOp(request))

  def listAutomaticTapeCreationPolicies(
    request: ListAutomaticTapeCreationPoliciesRequest
  ): StorageGatewayIO[ListAutomaticTapeCreationPoliciesResponse] =
    FF.liftF(ListAutomaticTapeCreationPoliciesOp(request))

  def listFileShares(
    request: ListFileSharesRequest
  ): StorageGatewayIO[ListFileSharesResponse] =
    FF.liftF(ListFileSharesOp(request))

  def listFileSystemAssociations(
    request: ListFileSystemAssociationsRequest
  ): StorageGatewayIO[ListFileSystemAssociationsResponse] =
    FF.liftF(ListFileSystemAssociationsOp(request))

  def listGateways(
    request: ListGatewaysRequest
  ): StorageGatewayIO[ListGatewaysResponse] =
    FF.liftF(ListGatewaysOp(request))

  def listLocalDisks(
    request: ListLocalDisksRequest
  ): StorageGatewayIO[ListLocalDisksResponse] =
    FF.liftF(ListLocalDisksOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): StorageGatewayIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTapePools(
    request: ListTapePoolsRequest
  ): StorageGatewayIO[ListTapePoolsResponse] =
    FF.liftF(ListTapePoolsOp(request))

  def listTapes(
    request: ListTapesRequest
  ): StorageGatewayIO[ListTapesResponse] =
    FF.liftF(ListTapesOp(request))

  def listVolumeInitiators(
    request: ListVolumeInitiatorsRequest
  ): StorageGatewayIO[ListVolumeInitiatorsResponse] =
    FF.liftF(ListVolumeInitiatorsOp(request))

  def listVolumeRecoveryPoints(
    request: ListVolumeRecoveryPointsRequest
  ): StorageGatewayIO[ListVolumeRecoveryPointsResponse] =
    FF.liftF(ListVolumeRecoveryPointsOp(request))

  def listVolumes(
    request: ListVolumesRequest
  ): StorageGatewayIO[ListVolumesResponse] =
    FF.liftF(ListVolumesOp(request))

  def notifyWhenUploaded(
    request: NotifyWhenUploadedRequest
  ): StorageGatewayIO[NotifyWhenUploadedResponse] =
    FF.liftF(NotifyWhenUploadedOp(request))

  def refreshCache(
    request: RefreshCacheRequest
  ): StorageGatewayIO[RefreshCacheResponse] =
    FF.liftF(RefreshCacheOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): StorageGatewayIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def resetCache(
    request: ResetCacheRequest
  ): StorageGatewayIO[ResetCacheResponse] =
    FF.liftF(ResetCacheOp(request))

  def retrieveTapeArchive(
    request: RetrieveTapeArchiveRequest
  ): StorageGatewayIO[RetrieveTapeArchiveResponse] =
    FF.liftF(RetrieveTapeArchiveOp(request))

  def retrieveTapeRecoveryPoint(
    request: RetrieveTapeRecoveryPointRequest
  ): StorageGatewayIO[RetrieveTapeRecoveryPointResponse] =
    FF.liftF(RetrieveTapeRecoveryPointOp(request))

  def setLocalConsolePassword(
    request: SetLocalConsolePasswordRequest
  ): StorageGatewayIO[SetLocalConsolePasswordResponse] =
    FF.liftF(SetLocalConsolePasswordOp(request))

  def setSMBGuestPassword(
    request: SetSmbGuestPasswordRequest
  ): StorageGatewayIO[SetSmbGuestPasswordResponse] =
    FF.liftF(SetSMBGuestPasswordOp(request))

  def shutdownGateway(
    request: ShutdownGatewayRequest
  ): StorageGatewayIO[ShutdownGatewayResponse] =
    FF.liftF(ShutdownGatewayOp(request))

  def startAvailabilityMonitorTest(
    request: StartAvailabilityMonitorTestRequest
  ): StorageGatewayIO[StartAvailabilityMonitorTestResponse] =
    FF.liftF(StartAvailabilityMonitorTestOp(request))

  def startGateway(
    request: StartGatewayRequest
  ): StorageGatewayIO[StartGatewayResponse] =
    FF.liftF(StartGatewayOp(request))

  def updateAutomaticTapeCreationPolicy(
    request: UpdateAutomaticTapeCreationPolicyRequest
  ): StorageGatewayIO[UpdateAutomaticTapeCreationPolicyResponse] =
    FF.liftF(UpdateAutomaticTapeCreationPolicyOp(request))

  def updateBandwidthRateLimit(
    request: UpdateBandwidthRateLimitRequest
  ): StorageGatewayIO[UpdateBandwidthRateLimitResponse] =
    FF.liftF(UpdateBandwidthRateLimitOp(request))

  def updateBandwidthRateLimitSchedule(
    request: UpdateBandwidthRateLimitScheduleRequest
  ): StorageGatewayIO[UpdateBandwidthRateLimitScheduleResponse] =
    FF.liftF(UpdateBandwidthRateLimitScheduleOp(request))

  def updateChapCredentials(
    request: UpdateChapCredentialsRequest
  ): StorageGatewayIO[UpdateChapCredentialsResponse] =
    FF.liftF(UpdateChapCredentialsOp(request))

  def updateFileSystemAssociation(
    request: UpdateFileSystemAssociationRequest
  ): StorageGatewayIO[UpdateFileSystemAssociationResponse] =
    FF.liftF(UpdateFileSystemAssociationOp(request))

  def updateGatewayInformation(
    request: UpdateGatewayInformationRequest
  ): StorageGatewayIO[UpdateGatewayInformationResponse] =
    FF.liftF(UpdateGatewayInformationOp(request))

  def updateGatewaySoftwareNow(
    request: UpdateGatewaySoftwareNowRequest
  ): StorageGatewayIO[UpdateGatewaySoftwareNowResponse] =
    FF.liftF(UpdateGatewaySoftwareNowOp(request))

  def updateMaintenanceStartTime(
    request: UpdateMaintenanceStartTimeRequest
  ): StorageGatewayIO[UpdateMaintenanceStartTimeResponse] =
    FF.liftF(UpdateMaintenanceStartTimeOp(request))

  def updateNFSFileShare(
    request: UpdateNfsFileShareRequest
  ): StorageGatewayIO[UpdateNfsFileShareResponse] =
    FF.liftF(UpdateNFSFileShareOp(request))

  def updateSMBFileShare(
    request: UpdateSmbFileShareRequest
  ): StorageGatewayIO[UpdateSmbFileShareResponse] =
    FF.liftF(UpdateSMBFileShareOp(request))

  def updateSMBFileShareVisibility(
    request: UpdateSmbFileShareVisibilityRequest
  ): StorageGatewayIO[UpdateSmbFileShareVisibilityResponse] =
    FF.liftF(UpdateSMBFileShareVisibilityOp(request))

  def updateSMBSecurityStrategy(
    request: UpdateSmbSecurityStrategyRequest
  ): StorageGatewayIO[UpdateSmbSecurityStrategyResponse] =
    FF.liftF(UpdateSMBSecurityStrategyOp(request))

  def updateSnapshotSchedule(
    request: UpdateSnapshotScheduleRequest
  ): StorageGatewayIO[UpdateSnapshotScheduleResponse] =
    FF.liftF(UpdateSnapshotScheduleOp(request))

  def updateVTLDeviceType(
    request: UpdateVtlDeviceTypeRequest
  ): StorageGatewayIO[UpdateVtlDeviceTypeResponse] =
    FF.liftF(UpdateVTLDeviceTypeOp(request))
}
