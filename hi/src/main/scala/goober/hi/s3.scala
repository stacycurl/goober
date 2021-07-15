package goober.hi

import goober.free.s3.S3IO
import software.amazon.awssdk.services.s3.model._


object s3 {
  import goober.free.{s3 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AbortMultipartUploadRequest
    // CompleteMultipartUploadRequest
    // CopyObjectRequest
    // CreateBucketRequest
    // CreateMultipartUploadRequest
    // DeleteBucketRequest
    // DeleteBucketAnalyticsConfigurationRequest
    // DeleteBucketCorsRequest
    // DeleteBucketEncryptionRequest
    // DeleteBucketIntelligentTieringConfigurationRequest
    // DeleteBucketInventoryConfigurationRequest
    // DeleteBucketLifecycleRequest
    // DeleteBucketMetricsConfigurationRequest
    // DeleteBucketOwnershipControlsRequest
    // DeleteBucketPolicyRequest
    // DeleteBucketReplicationRequest
    // DeleteBucketTaggingRequest
    // DeleteBucketWebsiteRequest
    // DeleteObjectRequest
    // DeleteObjectTaggingRequest
    // DeleteObjectsRequest
    // DeletePublicAccessBlockRequest
    // GetBucketAccelerateConfigurationRequest
    // GetBucketAclRequest
    // GetBucketAnalyticsConfigurationRequest
    // GetBucketCorsRequest
    // GetBucketEncryptionRequest
    // GetBucketIntelligentTieringConfigurationRequest
    // GetBucketInventoryConfigurationRequest
    // GetBucketLifecycleConfigurationRequest
    // GetBucketLocationRequest
    // GetBucketLoggingRequest
    // GetBucketMetricsConfigurationRequest
    // GetBucketNotificationConfigurationRequest
    // GetBucketOwnershipControlsRequest
    // GetBucketPolicyRequest
    // GetBucketPolicyStatusRequest
    // GetBucketReplicationRequest
    // GetBucketRequestPaymentRequest
    // GetBucketTaggingRequest
    // GetBucketVersioningRequest
    // GetBucketWebsiteRequest
    // GetObjectAclRequest
    // GetObjectLegalHoldRequest
    // GetObjectLockConfigurationRequest
    // GetObjectRetentionRequest
    // GetObjectTaggingRequest
    // GetPublicAccessBlockRequest
    // HeadBucketRequest
    // HeadObjectRequest
    // ListBucketAnalyticsConfigurationsRequest
    // ListBucketIntelligentTieringConfigurationsRequest
    // ListBucketInventoryConfigurationsRequest
    // ListBucketMetricsConfigurationsRequest
    // ListBucketsRequest
    // ListMultipartUploadsRequest
    // ListObjectVersionsRequest
    // ListObjectsRequest
    // ListObjectsV2Request
    // ListPartsRequest
    // PutBucketAccelerateConfigurationRequest
    // PutBucketAclRequest
    // PutBucketAnalyticsConfigurationRequest
    // PutBucketCorsRequest
    // PutBucketEncryptionRequest
    // PutBucketIntelligentTieringConfigurationRequest
    // PutBucketInventoryConfigurationRequest
    // PutBucketLifecycleConfigurationRequest
    // PutBucketLoggingRequest
    // PutBucketMetricsConfigurationRequest
    // PutBucketNotificationConfigurationRequest
    // PutBucketOwnershipControlsRequest
    // PutBucketPolicyRequest
    // PutBucketReplicationRequest
    // PutBucketRequestPaymentRequest
    // PutBucketTaggingRequest
    // PutBucketVersioningRequest
    // PutBucketWebsiteRequest
    // PutObjectRequest
    // PutObjectAclRequest
    // PutObjectLegalHoldRequest
    // PutObjectLockConfigurationRequest
    // PutObjectRetentionRequest
    // PutObjectTaggingRequest
    // PutPublicAccessBlockRequest
    // RestoreObjectRequest
    // UploadPartRequest
    // UploadPartCopyRequest
    // WriteGetObjectResponseRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
