package goober.hi

import goober.free.glacier.GlacierIO
import software.amazon.awssdk.services.glacier.model._


object glacier {
  import goober.free.{glacier ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AbortMultipartUploadRequest
    // AbortVaultLockRequest
    // AddTagsToVaultRequest
    // CompleteMultipartUploadRequest
    // CompleteVaultLockRequest
    // CreateVaultRequest
    // DeleteArchiveRequest
    // DeleteVaultRequest
    // DeleteVaultAccessPolicyRequest
    // DeleteVaultNotificationsRequest
    // DescribeJobRequest
    // DescribeVaultRequest
    // GetDataRetrievalPolicyRequest
    // GetVaultAccessPolicyRequest
    // GetVaultLockRequest
    // GetVaultNotificationsRequest
    // InitiateJobRequest
    // InitiateMultipartUploadRequest
    // InitiateVaultLockRequest
    // ListJobsRequest
    // ListMultipartUploadsRequest
    // ListPartsRequest
    // ListProvisionedCapacityRequest
    // ListTagsForVaultRequest
    // ListVaultsRequest
    // PurchaseProvisionedCapacityRequest
    // RemoveTagsFromVaultRequest
    // SetDataRetrievalPolicyRequest
    // SetVaultAccessPolicyRequest
    // SetVaultNotificationsRequest
    // UploadArchiveRequest
    // UploadMultipartPartRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
