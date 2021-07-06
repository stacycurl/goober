package goober.hi

import goober.free.ecr.EcrIO
import software.amazon.awssdk.services.ecr.model._


object ecr {
  import goober.free.{ecr ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // BatchCheckLayerAvailabilityRequest
    // BatchDeleteImageRequest
    // BatchGetImageRequest
    // CompleteLayerUploadRequest
    // CreateRepositoryRequest
    // DeleteLifecyclePolicyRequest
    // DeleteRegistryPolicyRequest
    // DeleteRepositoryPolicyRequest
    // DeleteRepositoryRequest
    // DescribeImageScanFindingsRequest
    // DescribeImagesRequest
    // DescribeRegistryRequest
    // DescribeRepositoriesRequest
    // GetAuthorizationTokenRequest
    // GetDownloadUrlForLayerRequest
    // GetLifecyclePolicyPreviewRequest
    // GetLifecyclePolicyRequest
    // GetRegistryPolicyRequest
    // GetRepositoryPolicyRequest
    // InitiateLayerUploadRequest
    // ListImagesRequest
    // ListTagsForResourceRequest
    // PutImageRequest
    // PutImageScanningConfigurationRequest
    // PutImageTagMutabilityRequest
    // PutLifecyclePolicyRequest
    // PutRegistryPolicyRequest
    // PutReplicationConfigurationRequest
    // SetRepositoryPolicyRequest
    // StartImageScanRequest
    // StartLifecyclePolicyPreviewRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UploadLayerPartRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
