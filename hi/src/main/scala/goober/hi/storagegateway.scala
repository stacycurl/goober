package goober.hi

import goober.free.storagegateway.StorageGatewayIO
import software.amazon.awssdk.services.storagegateway.model._


object storagegateway {
  import goober.free.{storagegateway ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // ActivateGatewayRequest
    // AddCacheRequest
    // AddTagsToResourceRequest
    // AddUploadBufferRequest
    // AddWorkingStorageRequest
    // AssignTapePoolRequest
    // AssociateFileSystemRequest
    // AttachVolumeRequest
    // CancelArchivalRequest
    // CancelRetrievalRequest
    // CreateCachediScsiVolumeRequest
    // CreateNfsFileShareRequest
    // CreateSmbFileShareRequest
    // CreateSnapshotFromVolumeRecoveryPointRequest
    // CreateSnapshotRequest
    // CreateStorediScsiVolumeRequest
    // CreateTapePoolRequest
    // CreateTapeWithBarcodeRequest
    // CreateTapesRequest
    // DeleteAutomaticTapeCreationPolicyRequest
    // DeleteBandwidthRateLimitRequest
    // DeleteChapCredentialsRequest
    // DeleteFileShareRequest
    // DeleteGatewayRequest
    // DeleteSnapshotScheduleRequest
    // DeleteTapeArchiveRequest
    // DeleteTapePoolRequest
    // DeleteTapeRequest
    // DeleteVolumeRequest
    // DescribeAvailabilityMonitorTestRequest
    // DescribeBandwidthRateLimitRequest
    // DescribeBandwidthRateLimitScheduleRequest
    // DescribeCacheRequest
    // DescribeCachediScsiVolumesRequest
    // DescribeChapCredentialsRequest
    // DescribeFileSystemAssociationsRequest
    // DescribeGatewayInformationRequest
    // DescribeMaintenanceStartTimeRequest
    // DescribeNfsFileSharesRequest
    // DescribeSmbFileSharesRequest
    // DescribeSmbSettingsRequest
    // DescribeSnapshotScheduleRequest
    // DescribeStorediScsiVolumesRequest
    // DescribeTapeArchivesRequest
    // DescribeTapeRecoveryPointsRequest
    // DescribeTapesRequest
    // DescribeUploadBufferRequest
    // DescribeVtlDevicesRequest
    // DescribeWorkingStorageRequest
    // DetachVolumeRequest
    // DisableGatewayRequest
    // DisassociateFileSystemRequest
    // JoinDomainRequest
    // ListAutomaticTapeCreationPoliciesRequest
    // ListFileSharesRequest
    // ListFileSystemAssociationsRequest
    // ListGatewaysRequest
    // ListLocalDisksRequest
    // ListTagsForResourceRequest
    // ListTapePoolsRequest
    // ListTapesRequest
    // ListVolumeInitiatorsRequest
    // ListVolumeRecoveryPointsRequest
    // ListVolumesRequest
    // NotifyWhenUploadedRequest
    // RefreshCacheRequest
    // RemoveTagsFromResourceRequest
    // ResetCacheRequest
    // RetrieveTapeArchiveRequest
    // RetrieveTapeRecoveryPointRequest
    // SetLocalConsolePasswordRequest
    // SetSmbGuestPasswordRequest
    // ShutdownGatewayRequest
    // StartAvailabilityMonitorTestRequest
    // StartGatewayRequest
    // UpdateAutomaticTapeCreationPolicyRequest
    // UpdateBandwidthRateLimitRequest
    // UpdateBandwidthRateLimitScheduleRequest
    // UpdateChapCredentialsRequest
    // UpdateFileSystemAssociationRequest
    // UpdateGatewayInformationRequest
    // UpdateGatewaySoftwareNowRequest
    // UpdateMaintenanceStartTimeRequest
    // UpdateNfsFileShareRequest
    // UpdateSmbFileShareRequest
    // UpdateSmbFileShareVisibilityRequest
    // UpdateSmbSecurityStrategyRequest
    // UpdateSnapshotScheduleRequest
    // UpdateVtlDeviceTypeRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
