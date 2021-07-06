package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody


object s3 { module =>

  // Free monad over S3Op
  type S3IO[A] = FF[S3Op, A]

  sealed trait S3Op[A] {
    def visit[F[_]](visitor: S3Op.Visitor[F]): F[A]
  }

  object S3Op {
    // Given a S3Client we can embed a S3IO program in any algebra that understands embedding.
    implicit val S3OpEmbeddable: Embeddable[S3Op, S3Client] = new Embeddable[S3Op, S3Client] {
      def embed[A](client: S3Client, io: S3IO[A]): Embedded[A] = Embedded.S3(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends S3Op.Visitor[Kleisli[M, S3Client, *]] {
        def abortMultipartUpload(
          request: AbortMultipartUploadRequest
        ): Kleisli[M, S3Client, AbortMultipartUploadResponse] =
          primitive(_.abortMultipartUpload(request))

        def completeMultipartUpload(
          request: CompleteMultipartUploadRequest
        ): Kleisli[M, S3Client, CompleteMultipartUploadResponse] =
          primitive(_.completeMultipartUpload(request))

        def copyObject(
          request: CopyObjectRequest
        ): Kleisli[M, S3Client, CopyObjectResponse] =
          primitive(_.copyObject(request))

        def createBucket(
          request: CreateBucketRequest
        ): Kleisli[M, S3Client, CreateBucketResponse] =
          primitive(_.createBucket(request))

        def createMultipartUpload(
          request: CreateMultipartUploadRequest
        ): Kleisli[M, S3Client, CreateMultipartUploadResponse] =
          primitive(_.createMultipartUpload(request))

        def deleteBucket(
          request: DeleteBucketRequest
        ): Kleisli[M, S3Client, DeleteBucketResponse] =
          primitive(_.deleteBucket(request))

        def deleteBucketAnalyticsConfiguration(
          request: DeleteBucketAnalyticsConfigurationRequest
        ): Kleisli[M, S3Client, DeleteBucketAnalyticsConfigurationResponse] =
          primitive(_.deleteBucketAnalyticsConfiguration(request))

        def deleteBucketCors(
          request: DeleteBucketCorsRequest
        ): Kleisli[M, S3Client, DeleteBucketCorsResponse] =
          primitive(_.deleteBucketCors(request))

        def deleteBucketEncryption(
          request: DeleteBucketEncryptionRequest
        ): Kleisli[M, S3Client, DeleteBucketEncryptionResponse] =
          primitive(_.deleteBucketEncryption(request))

        def deleteBucketIntelligentTieringConfiguration(
          request: DeleteBucketIntelligentTieringConfigurationRequest
        ): Kleisli[M, S3Client, DeleteBucketIntelligentTieringConfigurationResponse] =
          primitive(_.deleteBucketIntelligentTieringConfiguration(request))

        def deleteBucketInventoryConfiguration(
          request: DeleteBucketInventoryConfigurationRequest
        ): Kleisli[M, S3Client, DeleteBucketInventoryConfigurationResponse] =
          primitive(_.deleteBucketInventoryConfiguration(request))

        def deleteBucketLifecycle(
          request: DeleteBucketLifecycleRequest
        ): Kleisli[M, S3Client, DeleteBucketLifecycleResponse] =
          primitive(_.deleteBucketLifecycle(request))

        def deleteBucketMetricsConfiguration(
          request: DeleteBucketMetricsConfigurationRequest
        ): Kleisli[M, S3Client, DeleteBucketMetricsConfigurationResponse] =
          primitive(_.deleteBucketMetricsConfiguration(request))

        def deleteBucketOwnershipControls(
          request: DeleteBucketOwnershipControlsRequest
        ): Kleisli[M, S3Client, DeleteBucketOwnershipControlsResponse] =
          primitive(_.deleteBucketOwnershipControls(request))

        def deleteBucketPolicy(
          request: DeleteBucketPolicyRequest
        ): Kleisli[M, S3Client, DeleteBucketPolicyResponse] =
          primitive(_.deleteBucketPolicy(request))

        def deleteBucketReplication(
          request: DeleteBucketReplicationRequest
        ): Kleisli[M, S3Client, DeleteBucketReplicationResponse] =
          primitive(_.deleteBucketReplication(request))

        def deleteBucketTagging(
          request: DeleteBucketTaggingRequest
        ): Kleisli[M, S3Client, DeleteBucketTaggingResponse] =
          primitive(_.deleteBucketTagging(request))

        def deleteBucketWebsite(
          request: DeleteBucketWebsiteRequest
        ): Kleisli[M, S3Client, DeleteBucketWebsiteResponse] =
          primitive(_.deleteBucketWebsite(request))

        def deleteObject(
          request: DeleteObjectRequest
        ): Kleisli[M, S3Client, DeleteObjectResponse] =
          primitive(_.deleteObject(request))

        def deleteObjectTagging(
          request: DeleteObjectTaggingRequest
        ): Kleisli[M, S3Client, DeleteObjectTaggingResponse] =
          primitive(_.deleteObjectTagging(request))

        def deleteObjects(
          request: DeleteObjectsRequest
        ): Kleisli[M, S3Client, DeleteObjectsResponse] =
          primitive(_.deleteObjects(request))

        def deletePublicAccessBlock(
          request: DeletePublicAccessBlockRequest
        ): Kleisli[M, S3Client, DeletePublicAccessBlockResponse] =
          primitive(_.deletePublicAccessBlock(request))

        def getBucketAccelerateConfiguration(
          request: GetBucketAccelerateConfigurationRequest
        ): Kleisli[M, S3Client, GetBucketAccelerateConfigurationResponse] =
          primitive(_.getBucketAccelerateConfiguration(request))

        def getBucketAcl(
          request: GetBucketAclRequest
        ): Kleisli[M, S3Client, GetBucketAclResponse] =
          primitive(_.getBucketAcl(request))

        def getBucketAnalyticsConfiguration(
          request: GetBucketAnalyticsConfigurationRequest
        ): Kleisli[M, S3Client, GetBucketAnalyticsConfigurationResponse] =
          primitive(_.getBucketAnalyticsConfiguration(request))

        def getBucketCors(
          request: GetBucketCorsRequest
        ): Kleisli[M, S3Client, GetBucketCorsResponse] =
          primitive(_.getBucketCors(request))

        def getBucketEncryption(
          request: GetBucketEncryptionRequest
        ): Kleisli[M, S3Client, GetBucketEncryptionResponse] =
          primitive(_.getBucketEncryption(request))

        def getBucketIntelligentTieringConfiguration(
          request: GetBucketIntelligentTieringConfigurationRequest
        ): Kleisli[M, S3Client, GetBucketIntelligentTieringConfigurationResponse] =
          primitive(_.getBucketIntelligentTieringConfiguration(request))

        def getBucketInventoryConfiguration(
          request: GetBucketInventoryConfigurationRequest
        ): Kleisli[M, S3Client, GetBucketInventoryConfigurationResponse] =
          primitive(_.getBucketInventoryConfiguration(request))

        def getBucketLifecycleConfiguration(
          request: GetBucketLifecycleConfigurationRequest
        ): Kleisli[M, S3Client, GetBucketLifecycleConfigurationResponse] =
          primitive(_.getBucketLifecycleConfiguration(request))

        def getBucketLocation(
          request: GetBucketLocationRequest
        ): Kleisli[M, S3Client, GetBucketLocationResponse] =
          primitive(_.getBucketLocation(request))

        def getBucketLogging(
          request: GetBucketLoggingRequest
        ): Kleisli[M, S3Client, GetBucketLoggingResponse] =
          primitive(_.getBucketLogging(request))

        def getBucketMetricsConfiguration(
          request: GetBucketMetricsConfigurationRequest
        ): Kleisli[M, S3Client, GetBucketMetricsConfigurationResponse] =
          primitive(_.getBucketMetricsConfiguration(request))

        def getBucketNotificationConfiguration(
          request: GetBucketNotificationConfigurationRequest
        ): Kleisli[M, S3Client, GetBucketNotificationConfigurationResponse] =
          primitive(_.getBucketNotificationConfiguration(request))

        def getBucketOwnershipControls(
          request: GetBucketOwnershipControlsRequest
        ): Kleisli[M, S3Client, GetBucketOwnershipControlsResponse] =
          primitive(_.getBucketOwnershipControls(request))

        def getBucketPolicy(
          request: GetBucketPolicyRequest
        ): Kleisli[M, S3Client, GetBucketPolicyResponse] =
          primitive(_.getBucketPolicy(request))

        def getBucketPolicyStatus(
          request: GetBucketPolicyStatusRequest
        ): Kleisli[M, S3Client, GetBucketPolicyStatusResponse] =
          primitive(_.getBucketPolicyStatus(request))

        def getBucketReplication(
          request: GetBucketReplicationRequest
        ): Kleisli[M, S3Client, GetBucketReplicationResponse] =
          primitive(_.getBucketReplication(request))

        def getBucketRequestPayment(
          request: GetBucketRequestPaymentRequest
        ): Kleisli[M, S3Client, GetBucketRequestPaymentResponse] =
          primitive(_.getBucketRequestPayment(request))

        def getBucketTagging(
          request: GetBucketTaggingRequest
        ): Kleisli[M, S3Client, GetBucketTaggingResponse] =
          primitive(_.getBucketTagging(request))

        def getBucketVersioning(
          request: GetBucketVersioningRequest
        ): Kleisli[M, S3Client, GetBucketVersioningResponse] =
          primitive(_.getBucketVersioning(request))

        def getBucketWebsite(
          request: GetBucketWebsiteRequest
        ): Kleisli[M, S3Client, GetBucketWebsiteResponse] =
          primitive(_.getBucketWebsite(request))

        def getObject(
          request: GetObjectRequest,
          path: Path
        ): Kleisli[M, S3Client, GetObjectResponse] =
          primitive(_.getObject(request, path))

        def getObjectAcl(
          request: GetObjectAclRequest
        ): Kleisli[M, S3Client, GetObjectAclResponse] =
          primitive(_.getObjectAcl(request))

        def getObjectLegalHold(
          request: GetObjectLegalHoldRequest
        ): Kleisli[M, S3Client, GetObjectLegalHoldResponse] =
          primitive(_.getObjectLegalHold(request))

        def getObjectLockConfiguration(
          request: GetObjectLockConfigurationRequest
        ): Kleisli[M, S3Client, GetObjectLockConfigurationResponse] =
          primitive(_.getObjectLockConfiguration(request))

        def getObjectRetention(
          request: GetObjectRetentionRequest
        ): Kleisli[M, S3Client, GetObjectRetentionResponse] =
          primitive(_.getObjectRetention(request))

        def getObjectTagging(
          request: GetObjectTaggingRequest
        ): Kleisli[M, S3Client, GetObjectTaggingResponse] =
          primitive(_.getObjectTagging(request))

        def getPublicAccessBlock(
          request: GetPublicAccessBlockRequest
        ): Kleisli[M, S3Client, GetPublicAccessBlockResponse] =
          primitive(_.getPublicAccessBlock(request))

        def headBucket(
          request: HeadBucketRequest
        ): Kleisli[M, S3Client, HeadBucketResponse] =
          primitive(_.headBucket(request))

        def headObject(
          request: HeadObjectRequest
        ): Kleisli[M, S3Client, HeadObjectResponse] =
          primitive(_.headObject(request))

        def listBucketAnalyticsConfigurations(
          request: ListBucketAnalyticsConfigurationsRequest
        ): Kleisli[M, S3Client, ListBucketAnalyticsConfigurationsResponse] =
          primitive(_.listBucketAnalyticsConfigurations(request))

        def listBucketIntelligentTieringConfigurations(
          request: ListBucketIntelligentTieringConfigurationsRequest
        ): Kleisli[M, S3Client, ListBucketIntelligentTieringConfigurationsResponse] =
          primitive(_.listBucketIntelligentTieringConfigurations(request))

        def listBucketInventoryConfigurations(
          request: ListBucketInventoryConfigurationsRequest
        ): Kleisli[M, S3Client, ListBucketInventoryConfigurationsResponse] =
          primitive(_.listBucketInventoryConfigurations(request))

        def listBucketMetricsConfigurations(
          request: ListBucketMetricsConfigurationsRequest
        ): Kleisli[M, S3Client, ListBucketMetricsConfigurationsResponse] =
          primitive(_.listBucketMetricsConfigurations(request))

        def listBuckets(
          request: ListBucketsRequest
        ): Kleisli[M, S3Client, ListBucketsResponse] =
          primitive(_.listBuckets(request))

        def listMultipartUploads(
          request: ListMultipartUploadsRequest
        ): Kleisli[M, S3Client, ListMultipartUploadsResponse] =
          primitive(_.listMultipartUploads(request))

        def listObjectVersions(
          request: ListObjectVersionsRequest
        ): Kleisli[M, S3Client, ListObjectVersionsResponse] =
          primitive(_.listObjectVersions(request))

        def listObjects(
          request: ListObjectsRequest
        ): Kleisli[M, S3Client, ListObjectsResponse] =
          primitive(_.listObjects(request))

        def listObjectsV2(
          request: ListObjectsV2Request
        ): Kleisli[M, S3Client, ListObjectsV2Response] =
          primitive(_.listObjectsV2(request))

        def listParts(
          request: ListPartsRequest
        ): Kleisli[M, S3Client, ListPartsResponse] =
          primitive(_.listParts(request))

        def putBucketAccelerateConfiguration(
          request: PutBucketAccelerateConfigurationRequest
        ): Kleisli[M, S3Client, PutBucketAccelerateConfigurationResponse] =
          primitive(_.putBucketAccelerateConfiguration(request))

        def putBucketAcl(
          request: PutBucketAclRequest
        ): Kleisli[M, S3Client, PutBucketAclResponse] =
          primitive(_.putBucketAcl(request))

        def putBucketAnalyticsConfiguration(
          request: PutBucketAnalyticsConfigurationRequest
        ): Kleisli[M, S3Client, PutBucketAnalyticsConfigurationResponse] =
          primitive(_.putBucketAnalyticsConfiguration(request))

        def putBucketCors(
          request: PutBucketCorsRequest
        ): Kleisli[M, S3Client, PutBucketCorsResponse] =
          primitive(_.putBucketCors(request))

        def putBucketEncryption(
          request: PutBucketEncryptionRequest
        ): Kleisli[M, S3Client, PutBucketEncryptionResponse] =
          primitive(_.putBucketEncryption(request))

        def putBucketIntelligentTieringConfiguration(
          request: PutBucketIntelligentTieringConfigurationRequest
        ): Kleisli[M, S3Client, PutBucketIntelligentTieringConfigurationResponse] =
          primitive(_.putBucketIntelligentTieringConfiguration(request))

        def putBucketInventoryConfiguration(
          request: PutBucketInventoryConfigurationRequest
        ): Kleisli[M, S3Client, PutBucketInventoryConfigurationResponse] =
          primitive(_.putBucketInventoryConfiguration(request))

        def putBucketLifecycleConfiguration(
          request: PutBucketLifecycleConfigurationRequest
        ): Kleisli[M, S3Client, PutBucketLifecycleConfigurationResponse] =
          primitive(_.putBucketLifecycleConfiguration(request))

        def putBucketLogging(
          request: PutBucketLoggingRequest
        ): Kleisli[M, S3Client, PutBucketLoggingResponse] =
          primitive(_.putBucketLogging(request))

        def putBucketMetricsConfiguration(
          request: PutBucketMetricsConfigurationRequest
        ): Kleisli[M, S3Client, PutBucketMetricsConfigurationResponse] =
          primitive(_.putBucketMetricsConfiguration(request))

        def putBucketNotificationConfiguration(
          request: PutBucketNotificationConfigurationRequest
        ): Kleisli[M, S3Client, PutBucketNotificationConfigurationResponse] =
          primitive(_.putBucketNotificationConfiguration(request))

        def putBucketOwnershipControls(
          request: PutBucketOwnershipControlsRequest
        ): Kleisli[M, S3Client, PutBucketOwnershipControlsResponse] =
          primitive(_.putBucketOwnershipControls(request))

        def putBucketPolicy(
          request: PutBucketPolicyRequest
        ): Kleisli[M, S3Client, PutBucketPolicyResponse] =
          primitive(_.putBucketPolicy(request))

        def putBucketReplication(
          request: PutBucketReplicationRequest
        ): Kleisli[M, S3Client, PutBucketReplicationResponse] =
          primitive(_.putBucketReplication(request))

        def putBucketRequestPayment(
          request: PutBucketRequestPaymentRequest
        ): Kleisli[M, S3Client, PutBucketRequestPaymentResponse] =
          primitive(_.putBucketRequestPayment(request))

        def putBucketTagging(
          request: PutBucketTaggingRequest
        ): Kleisli[M, S3Client, PutBucketTaggingResponse] =
          primitive(_.putBucketTagging(request))

        def putBucketVersioning(
          request: PutBucketVersioningRequest
        ): Kleisli[M, S3Client, PutBucketVersioningResponse] =
          primitive(_.putBucketVersioning(request))

        def putBucketWebsite(
          request: PutBucketWebsiteRequest
        ): Kleisli[M, S3Client, PutBucketWebsiteResponse] =
          primitive(_.putBucketWebsite(request))

        def putObject(
          request: PutObjectRequest,
          body: RequestBody
        ): Kleisli[M, S3Client, PutObjectResponse] =
          primitive(_.putObject(request, body))

        def putObjectAcl(
          request: PutObjectAclRequest
        ): Kleisli[M, S3Client, PutObjectAclResponse] =
          primitive(_.putObjectAcl(request))

        def putObjectLegalHold(
          request: PutObjectLegalHoldRequest
        ): Kleisli[M, S3Client, PutObjectLegalHoldResponse] =
          primitive(_.putObjectLegalHold(request))

        def putObjectLockConfiguration(
          request: PutObjectLockConfigurationRequest
        ): Kleisli[M, S3Client, PutObjectLockConfigurationResponse] =
          primitive(_.putObjectLockConfiguration(request))

        def putObjectRetention(
          request: PutObjectRetentionRequest
        ): Kleisli[M, S3Client, PutObjectRetentionResponse] =
          primitive(_.putObjectRetention(request))

        def putObjectTagging(
          request: PutObjectTaggingRequest
        ): Kleisli[M, S3Client, PutObjectTaggingResponse] =
          primitive(_.putObjectTagging(request))

        def putPublicAccessBlock(
          request: PutPublicAccessBlockRequest
        ): Kleisli[M, S3Client, PutPublicAccessBlockResponse] =
          primitive(_.putPublicAccessBlock(request))

        def restoreObject(
          request: RestoreObjectRequest
        ): Kleisli[M, S3Client, RestoreObjectResponse] =
          primitive(_.restoreObject(request))

        def uploadPart(
          request: UploadPartRequest,
          body: RequestBody
        ): Kleisli[M, S3Client, UploadPartResponse] =
          primitive(_.uploadPart(request, body))

        def uploadPartCopy(
          request: UploadPartCopyRequest
        ): Kleisli[M, S3Client, UploadPartCopyResponse] =
          primitive(_.uploadPartCopy(request))

        def writeGetObjectResponse(
          request: WriteGetObjectResponseRequest,
          body: RequestBody
        ): Kleisli[M, S3Client, WriteGetObjectResponseResponse] =
          primitive(_.writeGetObjectResponse(request, body))

        def primitive[A](
          f: S3Client => A
        ): Kleisli[M, S3Client, A]
      }
    }

    trait Visitor[F[_]] extends (S3Op ~> F) {
      final def apply[A](op: S3Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def abortMultipartUpload(
        request: AbortMultipartUploadRequest
      ): F[AbortMultipartUploadResponse]

      def completeMultipartUpload(
        request: CompleteMultipartUploadRequest
      ): F[CompleteMultipartUploadResponse]

      def copyObject(
        request: CopyObjectRequest
      ): F[CopyObjectResponse]

      def createBucket(
        request: CreateBucketRequest
      ): F[CreateBucketResponse]

      def createMultipartUpload(
        request: CreateMultipartUploadRequest
      ): F[CreateMultipartUploadResponse]

      def deleteBucket(
        request: DeleteBucketRequest
      ): F[DeleteBucketResponse]

      def deleteBucketAnalyticsConfiguration(
        request: DeleteBucketAnalyticsConfigurationRequest
      ): F[DeleteBucketAnalyticsConfigurationResponse]

      def deleteBucketCors(
        request: DeleteBucketCorsRequest
      ): F[DeleteBucketCorsResponse]

      def deleteBucketEncryption(
        request: DeleteBucketEncryptionRequest
      ): F[DeleteBucketEncryptionResponse]

      def deleteBucketIntelligentTieringConfiguration(
        request: DeleteBucketIntelligentTieringConfigurationRequest
      ): F[DeleteBucketIntelligentTieringConfigurationResponse]

      def deleteBucketInventoryConfiguration(
        request: DeleteBucketInventoryConfigurationRequest
      ): F[DeleteBucketInventoryConfigurationResponse]

      def deleteBucketLifecycle(
        request: DeleteBucketLifecycleRequest
      ): F[DeleteBucketLifecycleResponse]

      def deleteBucketMetricsConfiguration(
        request: DeleteBucketMetricsConfigurationRequest
      ): F[DeleteBucketMetricsConfigurationResponse]

      def deleteBucketOwnershipControls(
        request: DeleteBucketOwnershipControlsRequest
      ): F[DeleteBucketOwnershipControlsResponse]

      def deleteBucketPolicy(
        request: DeleteBucketPolicyRequest
      ): F[DeleteBucketPolicyResponse]

      def deleteBucketReplication(
        request: DeleteBucketReplicationRequest
      ): F[DeleteBucketReplicationResponse]

      def deleteBucketTagging(
        request: DeleteBucketTaggingRequest
      ): F[DeleteBucketTaggingResponse]

      def deleteBucketWebsite(
        request: DeleteBucketWebsiteRequest
      ): F[DeleteBucketWebsiteResponse]

      def deleteObject(
        request: DeleteObjectRequest
      ): F[DeleteObjectResponse]

      def deleteObjectTagging(
        request: DeleteObjectTaggingRequest
      ): F[DeleteObjectTaggingResponse]

      def deleteObjects(
        request: DeleteObjectsRequest
      ): F[DeleteObjectsResponse]

      def deletePublicAccessBlock(
        request: DeletePublicAccessBlockRequest
      ): F[DeletePublicAccessBlockResponse]

      def getBucketAccelerateConfiguration(
        request: GetBucketAccelerateConfigurationRequest
      ): F[GetBucketAccelerateConfigurationResponse]

      def getBucketAcl(
        request: GetBucketAclRequest
      ): F[GetBucketAclResponse]

      def getBucketAnalyticsConfiguration(
        request: GetBucketAnalyticsConfigurationRequest
      ): F[GetBucketAnalyticsConfigurationResponse]

      def getBucketCors(
        request: GetBucketCorsRequest
      ): F[GetBucketCorsResponse]

      def getBucketEncryption(
        request: GetBucketEncryptionRequest
      ): F[GetBucketEncryptionResponse]

      def getBucketIntelligentTieringConfiguration(
        request: GetBucketIntelligentTieringConfigurationRequest
      ): F[GetBucketIntelligentTieringConfigurationResponse]

      def getBucketInventoryConfiguration(
        request: GetBucketInventoryConfigurationRequest
      ): F[GetBucketInventoryConfigurationResponse]

      def getBucketLifecycleConfiguration(
        request: GetBucketLifecycleConfigurationRequest
      ): F[GetBucketLifecycleConfigurationResponse]

      def getBucketLocation(
        request: GetBucketLocationRequest
      ): F[GetBucketLocationResponse]

      def getBucketLogging(
        request: GetBucketLoggingRequest
      ): F[GetBucketLoggingResponse]

      def getBucketMetricsConfiguration(
        request: GetBucketMetricsConfigurationRequest
      ): F[GetBucketMetricsConfigurationResponse]

      def getBucketNotificationConfiguration(
        request: GetBucketNotificationConfigurationRequest
      ): F[GetBucketNotificationConfigurationResponse]

      def getBucketOwnershipControls(
        request: GetBucketOwnershipControlsRequest
      ): F[GetBucketOwnershipControlsResponse]

      def getBucketPolicy(
        request: GetBucketPolicyRequest
      ): F[GetBucketPolicyResponse]

      def getBucketPolicyStatus(
        request: GetBucketPolicyStatusRequest
      ): F[GetBucketPolicyStatusResponse]

      def getBucketReplication(
        request: GetBucketReplicationRequest
      ): F[GetBucketReplicationResponse]

      def getBucketRequestPayment(
        request: GetBucketRequestPaymentRequest
      ): F[GetBucketRequestPaymentResponse]

      def getBucketTagging(
        request: GetBucketTaggingRequest
      ): F[GetBucketTaggingResponse]

      def getBucketVersioning(
        request: GetBucketVersioningRequest
      ): F[GetBucketVersioningResponse]

      def getBucketWebsite(
        request: GetBucketWebsiteRequest
      ): F[GetBucketWebsiteResponse]

      def getObject(
        request: GetObjectRequest,
        path: Path
      ): F[GetObjectResponse]

      def getObjectAcl(
        request: GetObjectAclRequest
      ): F[GetObjectAclResponse]

      def getObjectLegalHold(
        request: GetObjectLegalHoldRequest
      ): F[GetObjectLegalHoldResponse]

      def getObjectLockConfiguration(
        request: GetObjectLockConfigurationRequest
      ): F[GetObjectLockConfigurationResponse]

      def getObjectRetention(
        request: GetObjectRetentionRequest
      ): F[GetObjectRetentionResponse]

      def getObjectTagging(
        request: GetObjectTaggingRequest
      ): F[GetObjectTaggingResponse]

      def getPublicAccessBlock(
        request: GetPublicAccessBlockRequest
      ): F[GetPublicAccessBlockResponse]

      def headBucket(
        request: HeadBucketRequest
      ): F[HeadBucketResponse]

      def headObject(
        request: HeadObjectRequest
      ): F[HeadObjectResponse]

      def listBucketAnalyticsConfigurations(
        request: ListBucketAnalyticsConfigurationsRequest
      ): F[ListBucketAnalyticsConfigurationsResponse]

      def listBucketIntelligentTieringConfigurations(
        request: ListBucketIntelligentTieringConfigurationsRequest
      ): F[ListBucketIntelligentTieringConfigurationsResponse]

      def listBucketInventoryConfigurations(
        request: ListBucketInventoryConfigurationsRequest
      ): F[ListBucketInventoryConfigurationsResponse]

      def listBucketMetricsConfigurations(
        request: ListBucketMetricsConfigurationsRequest
      ): F[ListBucketMetricsConfigurationsResponse]

      def listBuckets(
        request: ListBucketsRequest
      ): F[ListBucketsResponse]

      def listMultipartUploads(
        request: ListMultipartUploadsRequest
      ): F[ListMultipartUploadsResponse]

      def listObjectVersions(
        request: ListObjectVersionsRequest
      ): F[ListObjectVersionsResponse]

      def listObjects(
        request: ListObjectsRequest
      ): F[ListObjectsResponse]

      def listObjectsV2(
        request: ListObjectsV2Request
      ): F[ListObjectsV2Response]

      def listParts(
        request: ListPartsRequest
      ): F[ListPartsResponse]

      def putBucketAccelerateConfiguration(
        request: PutBucketAccelerateConfigurationRequest
      ): F[PutBucketAccelerateConfigurationResponse]

      def putBucketAcl(
        request: PutBucketAclRequest
      ): F[PutBucketAclResponse]

      def putBucketAnalyticsConfiguration(
        request: PutBucketAnalyticsConfigurationRequest
      ): F[PutBucketAnalyticsConfigurationResponse]

      def putBucketCors(
        request: PutBucketCorsRequest
      ): F[PutBucketCorsResponse]

      def putBucketEncryption(
        request: PutBucketEncryptionRequest
      ): F[PutBucketEncryptionResponse]

      def putBucketIntelligentTieringConfiguration(
        request: PutBucketIntelligentTieringConfigurationRequest
      ): F[PutBucketIntelligentTieringConfigurationResponse]

      def putBucketInventoryConfiguration(
        request: PutBucketInventoryConfigurationRequest
      ): F[PutBucketInventoryConfigurationResponse]

      def putBucketLifecycleConfiguration(
        request: PutBucketLifecycleConfigurationRequest
      ): F[PutBucketLifecycleConfigurationResponse]

      def putBucketLogging(
        request: PutBucketLoggingRequest
      ): F[PutBucketLoggingResponse]

      def putBucketMetricsConfiguration(
        request: PutBucketMetricsConfigurationRequest
      ): F[PutBucketMetricsConfigurationResponse]

      def putBucketNotificationConfiguration(
        request: PutBucketNotificationConfigurationRequest
      ): F[PutBucketNotificationConfigurationResponse]

      def putBucketOwnershipControls(
        request: PutBucketOwnershipControlsRequest
      ): F[PutBucketOwnershipControlsResponse]

      def putBucketPolicy(
        request: PutBucketPolicyRequest
      ): F[PutBucketPolicyResponse]

      def putBucketReplication(
        request: PutBucketReplicationRequest
      ): F[PutBucketReplicationResponse]

      def putBucketRequestPayment(
        request: PutBucketRequestPaymentRequest
      ): F[PutBucketRequestPaymentResponse]

      def putBucketTagging(
        request: PutBucketTaggingRequest
      ): F[PutBucketTaggingResponse]

      def putBucketVersioning(
        request: PutBucketVersioningRequest
      ): F[PutBucketVersioningResponse]

      def putBucketWebsite(
        request: PutBucketWebsiteRequest
      ): F[PutBucketWebsiteResponse]

      def putObject(
        request: PutObjectRequest,
        body: RequestBody
      ): F[PutObjectResponse]

      def putObjectAcl(
        request: PutObjectAclRequest
      ): F[PutObjectAclResponse]

      def putObjectLegalHold(
        request: PutObjectLegalHoldRequest
      ): F[PutObjectLegalHoldResponse]

      def putObjectLockConfiguration(
        request: PutObjectLockConfigurationRequest
      ): F[PutObjectLockConfigurationResponse]

      def putObjectRetention(
        request: PutObjectRetentionRequest
      ): F[PutObjectRetentionResponse]

      def putObjectTagging(
        request: PutObjectTaggingRequest
      ): F[PutObjectTaggingResponse]

      def putPublicAccessBlock(
        request: PutPublicAccessBlockRequest
      ): F[PutPublicAccessBlockResponse]

      def restoreObject(
        request: RestoreObjectRequest
      ): F[RestoreObjectResponse]

      def uploadPart(
        request: UploadPartRequest,
        body: RequestBody
      ): F[UploadPartResponse]

      def uploadPartCopy(
        request: UploadPartCopyRequest
      ): F[UploadPartCopyResponse]

      def writeGetObjectResponse(
        request: WriteGetObjectResponseRequest,
        body: RequestBody
      ): F[WriteGetObjectResponseResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends S3Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AbortMultipartUploadOp(
      request: AbortMultipartUploadRequest
    ) extends S3Op[AbortMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AbortMultipartUploadResponse] =
        visitor.abortMultipartUpload(request)
    }

    final case class CompleteMultipartUploadOp(
      request: CompleteMultipartUploadRequest
    ) extends S3Op[CompleteMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteMultipartUploadResponse] =
        visitor.completeMultipartUpload(request)
    }

    final case class CopyObjectOp(
      request: CopyObjectRequest
    ) extends S3Op[CopyObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyObjectResponse] =
        visitor.copyObject(request)
    }

    final case class CreateBucketOp(
      request: CreateBucketRequest
    ) extends S3Op[CreateBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBucketResponse] =
        visitor.createBucket(request)
    }

    final case class CreateMultipartUploadOp(
      request: CreateMultipartUploadRequest
    ) extends S3Op[CreateMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMultipartUploadResponse] =
        visitor.createMultipartUpload(request)
    }

    final case class DeleteBucketOp(
      request: DeleteBucketRequest
    ) extends S3Op[DeleteBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketResponse] =
        visitor.deleteBucket(request)
    }

    final case class DeleteBucketAnalyticsConfigurationOp(
      request: DeleteBucketAnalyticsConfigurationRequest
    ) extends S3Op[DeleteBucketAnalyticsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketAnalyticsConfigurationResponse] =
        visitor.deleteBucketAnalyticsConfiguration(request)
    }

    final case class DeleteBucketCorsOp(
      request: DeleteBucketCorsRequest
    ) extends S3Op[DeleteBucketCorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketCorsResponse] =
        visitor.deleteBucketCors(request)
    }

    final case class DeleteBucketEncryptionOp(
      request: DeleteBucketEncryptionRequest
    ) extends S3Op[DeleteBucketEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketEncryptionResponse] =
        visitor.deleteBucketEncryption(request)
    }

    final case class DeleteBucketIntelligentTieringConfigurationOp(
      request: DeleteBucketIntelligentTieringConfigurationRequest
    ) extends S3Op[DeleteBucketIntelligentTieringConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketIntelligentTieringConfigurationResponse] =
        visitor.deleteBucketIntelligentTieringConfiguration(request)
    }

    final case class DeleteBucketInventoryConfigurationOp(
      request: DeleteBucketInventoryConfigurationRequest
    ) extends S3Op[DeleteBucketInventoryConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketInventoryConfigurationResponse] =
        visitor.deleteBucketInventoryConfiguration(request)
    }

    final case class DeleteBucketLifecycleOp(
      request: DeleteBucketLifecycleRequest
    ) extends S3Op[DeleteBucketLifecycleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketLifecycleResponse] =
        visitor.deleteBucketLifecycle(request)
    }

    final case class DeleteBucketMetricsConfigurationOp(
      request: DeleteBucketMetricsConfigurationRequest
    ) extends S3Op[DeleteBucketMetricsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketMetricsConfigurationResponse] =
        visitor.deleteBucketMetricsConfiguration(request)
    }

    final case class DeleteBucketOwnershipControlsOp(
      request: DeleteBucketOwnershipControlsRequest
    ) extends S3Op[DeleteBucketOwnershipControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketOwnershipControlsResponse] =
        visitor.deleteBucketOwnershipControls(request)
    }

    final case class DeleteBucketPolicyOp(
      request: DeleteBucketPolicyRequest
    ) extends S3Op[DeleteBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketPolicyResponse] =
        visitor.deleteBucketPolicy(request)
    }

    final case class DeleteBucketReplicationOp(
      request: DeleteBucketReplicationRequest
    ) extends S3Op[DeleteBucketReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketReplicationResponse] =
        visitor.deleteBucketReplication(request)
    }

    final case class DeleteBucketTaggingOp(
      request: DeleteBucketTaggingRequest
    ) extends S3Op[DeleteBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketTaggingResponse] =
        visitor.deleteBucketTagging(request)
    }

    final case class DeleteBucketWebsiteOp(
      request: DeleteBucketWebsiteRequest
    ) extends S3Op[DeleteBucketWebsiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketWebsiteResponse] =
        visitor.deleteBucketWebsite(request)
    }

    final case class DeleteObjectOp(
      request: DeleteObjectRequest
    ) extends S3Op[DeleteObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectResponse] =
        visitor.deleteObject(request)
    }

    final case class DeleteObjectTaggingOp(
      request: DeleteObjectTaggingRequest
    ) extends S3Op[DeleteObjectTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectTaggingResponse] =
        visitor.deleteObjectTagging(request)
    }

    final case class DeleteObjectsOp(
      request: DeleteObjectsRequest
    ) extends S3Op[DeleteObjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectsResponse] =
        visitor.deleteObjects(request)
    }

    final case class DeletePublicAccessBlockOp(
      request: DeletePublicAccessBlockRequest
    ) extends S3Op[DeletePublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePublicAccessBlockResponse] =
        visitor.deletePublicAccessBlock(request)
    }

    final case class GetBucketAccelerateConfigurationOp(
      request: GetBucketAccelerateConfigurationRequest
    ) extends S3Op[GetBucketAccelerateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketAccelerateConfigurationResponse] =
        visitor.getBucketAccelerateConfiguration(request)
    }

    final case class GetBucketAclOp(
      request: GetBucketAclRequest
    ) extends S3Op[GetBucketAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketAclResponse] =
        visitor.getBucketAcl(request)
    }

    final case class GetBucketAnalyticsConfigurationOp(
      request: GetBucketAnalyticsConfigurationRequest
    ) extends S3Op[GetBucketAnalyticsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketAnalyticsConfigurationResponse] =
        visitor.getBucketAnalyticsConfiguration(request)
    }

    final case class GetBucketCorsOp(
      request: GetBucketCorsRequest
    ) extends S3Op[GetBucketCorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketCorsResponse] =
        visitor.getBucketCors(request)
    }

    final case class GetBucketEncryptionOp(
      request: GetBucketEncryptionRequest
    ) extends S3Op[GetBucketEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketEncryptionResponse] =
        visitor.getBucketEncryption(request)
    }

    final case class GetBucketIntelligentTieringConfigurationOp(
      request: GetBucketIntelligentTieringConfigurationRequest
    ) extends S3Op[GetBucketIntelligentTieringConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketIntelligentTieringConfigurationResponse] =
        visitor.getBucketIntelligentTieringConfiguration(request)
    }

    final case class GetBucketInventoryConfigurationOp(
      request: GetBucketInventoryConfigurationRequest
    ) extends S3Op[GetBucketInventoryConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketInventoryConfigurationResponse] =
        visitor.getBucketInventoryConfiguration(request)
    }

    final case class GetBucketLifecycleConfigurationOp(
      request: GetBucketLifecycleConfigurationRequest
    ) extends S3Op[GetBucketLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketLifecycleConfigurationResponse] =
        visitor.getBucketLifecycleConfiguration(request)
    }

    final case class GetBucketLocationOp(
      request: GetBucketLocationRequest
    ) extends S3Op[GetBucketLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketLocationResponse] =
        visitor.getBucketLocation(request)
    }

    final case class GetBucketLoggingOp(
      request: GetBucketLoggingRequest
    ) extends S3Op[GetBucketLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketLoggingResponse] =
        visitor.getBucketLogging(request)
    }

    final case class GetBucketMetricsConfigurationOp(
      request: GetBucketMetricsConfigurationRequest
    ) extends S3Op[GetBucketMetricsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketMetricsConfigurationResponse] =
        visitor.getBucketMetricsConfiguration(request)
    }

    final case class GetBucketNotificationConfigurationOp(
      request: GetBucketNotificationConfigurationRequest
    ) extends S3Op[GetBucketNotificationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketNotificationConfigurationResponse] =
        visitor.getBucketNotificationConfiguration(request)
    }

    final case class GetBucketOwnershipControlsOp(
      request: GetBucketOwnershipControlsRequest
    ) extends S3Op[GetBucketOwnershipControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketOwnershipControlsResponse] =
        visitor.getBucketOwnershipControls(request)
    }

    final case class GetBucketPolicyOp(
      request: GetBucketPolicyRequest
    ) extends S3Op[GetBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketPolicyResponse] =
        visitor.getBucketPolicy(request)
    }

    final case class GetBucketPolicyStatusOp(
      request: GetBucketPolicyStatusRequest
    ) extends S3Op[GetBucketPolicyStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketPolicyStatusResponse] =
        visitor.getBucketPolicyStatus(request)
    }

    final case class GetBucketReplicationOp(
      request: GetBucketReplicationRequest
    ) extends S3Op[GetBucketReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketReplicationResponse] =
        visitor.getBucketReplication(request)
    }

    final case class GetBucketRequestPaymentOp(
      request: GetBucketRequestPaymentRequest
    ) extends S3Op[GetBucketRequestPaymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketRequestPaymentResponse] =
        visitor.getBucketRequestPayment(request)
    }

    final case class GetBucketTaggingOp(
      request: GetBucketTaggingRequest
    ) extends S3Op[GetBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketTaggingResponse] =
        visitor.getBucketTagging(request)
    }

    final case class GetBucketVersioningOp(
      request: GetBucketVersioningRequest
    ) extends S3Op[GetBucketVersioningResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketVersioningResponse] =
        visitor.getBucketVersioning(request)
    }

    final case class GetBucketWebsiteOp(
      request: GetBucketWebsiteRequest
    ) extends S3Op[GetBucketWebsiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketWebsiteResponse] =
        visitor.getBucketWebsite(request)
    }

    final case class GetObjectOp(
      request: GetObjectRequest,
      path: Path
    ) extends S3Op[GetObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectResponse] =
        visitor.getObject(request, path)
    }

    final case class GetObjectAclOp(
      request: GetObjectAclRequest
    ) extends S3Op[GetObjectAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectAclResponse] =
        visitor.getObjectAcl(request)
    }

    final case class GetObjectLegalHoldOp(
      request: GetObjectLegalHoldRequest
    ) extends S3Op[GetObjectLegalHoldResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectLegalHoldResponse] =
        visitor.getObjectLegalHold(request)
    }

    final case class GetObjectLockConfigurationOp(
      request: GetObjectLockConfigurationRequest
    ) extends S3Op[GetObjectLockConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectLockConfigurationResponse] =
        visitor.getObjectLockConfiguration(request)
    }

    final case class GetObjectRetentionOp(
      request: GetObjectRetentionRequest
    ) extends S3Op[GetObjectRetentionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectRetentionResponse] =
        visitor.getObjectRetention(request)
    }

    final case class GetObjectTaggingOp(
      request: GetObjectTaggingRequest
    ) extends S3Op[GetObjectTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectTaggingResponse] =
        visitor.getObjectTagging(request)
    }

    final case class GetPublicAccessBlockOp(
      request: GetPublicAccessBlockRequest
    ) extends S3Op[GetPublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPublicAccessBlockResponse] =
        visitor.getPublicAccessBlock(request)
    }

    final case class HeadBucketOp(
      request: HeadBucketRequest
    ) extends S3Op[HeadBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[HeadBucketResponse] =
        visitor.headBucket(request)
    }

    final case class HeadObjectOp(
      request: HeadObjectRequest
    ) extends S3Op[HeadObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[HeadObjectResponse] =
        visitor.headObject(request)
    }

    final case class ListBucketAnalyticsConfigurationsOp(
      request: ListBucketAnalyticsConfigurationsRequest
    ) extends S3Op[ListBucketAnalyticsConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketAnalyticsConfigurationsResponse] =
        visitor.listBucketAnalyticsConfigurations(request)
    }

    final case class ListBucketIntelligentTieringConfigurationsOp(
      request: ListBucketIntelligentTieringConfigurationsRequest
    ) extends S3Op[ListBucketIntelligentTieringConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketIntelligentTieringConfigurationsResponse] =
        visitor.listBucketIntelligentTieringConfigurations(request)
    }

    final case class ListBucketInventoryConfigurationsOp(
      request: ListBucketInventoryConfigurationsRequest
    ) extends S3Op[ListBucketInventoryConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketInventoryConfigurationsResponse] =
        visitor.listBucketInventoryConfigurations(request)
    }

    final case class ListBucketMetricsConfigurationsOp(
      request: ListBucketMetricsConfigurationsRequest
    ) extends S3Op[ListBucketMetricsConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketMetricsConfigurationsResponse] =
        visitor.listBucketMetricsConfigurations(request)
    }

    final case class ListBucketsOp(
      request: ListBucketsRequest
    ) extends S3Op[ListBucketsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketsResponse] =
        visitor.listBuckets(request)
    }

    final case class ListMultipartUploadsOp(
      request: ListMultipartUploadsRequest
    ) extends S3Op[ListMultipartUploadsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMultipartUploadsResponse] =
        visitor.listMultipartUploads(request)
    }

    final case class ListObjectVersionsOp(
      request: ListObjectVersionsRequest
    ) extends S3Op[ListObjectVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectVersionsResponse] =
        visitor.listObjectVersions(request)
    }

    final case class ListObjectsOp(
      request: ListObjectsRequest
    ) extends S3Op[ListObjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectsResponse] =
        visitor.listObjects(request)
    }

    final case class ListObjectsV2Op(
      request: ListObjectsV2Request
    ) extends S3Op[ListObjectsV2Response] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectsV2Response] =
        visitor.listObjectsV2(request)
    }

    final case class ListPartsOp(
      request: ListPartsRequest
    ) extends S3Op[ListPartsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPartsResponse] =
        visitor.listParts(request)
    }

    final case class PutBucketAccelerateConfigurationOp(
      request: PutBucketAccelerateConfigurationRequest
    ) extends S3Op[PutBucketAccelerateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketAccelerateConfigurationResponse] =
        visitor.putBucketAccelerateConfiguration(request)
    }

    final case class PutBucketAclOp(
      request: PutBucketAclRequest
    ) extends S3Op[PutBucketAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketAclResponse] =
        visitor.putBucketAcl(request)
    }

    final case class PutBucketAnalyticsConfigurationOp(
      request: PutBucketAnalyticsConfigurationRequest
    ) extends S3Op[PutBucketAnalyticsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketAnalyticsConfigurationResponse] =
        visitor.putBucketAnalyticsConfiguration(request)
    }

    final case class PutBucketCorsOp(
      request: PutBucketCorsRequest
    ) extends S3Op[PutBucketCorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketCorsResponse] =
        visitor.putBucketCors(request)
    }

    final case class PutBucketEncryptionOp(
      request: PutBucketEncryptionRequest
    ) extends S3Op[PutBucketEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketEncryptionResponse] =
        visitor.putBucketEncryption(request)
    }

    final case class PutBucketIntelligentTieringConfigurationOp(
      request: PutBucketIntelligentTieringConfigurationRequest
    ) extends S3Op[PutBucketIntelligentTieringConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketIntelligentTieringConfigurationResponse] =
        visitor.putBucketIntelligentTieringConfiguration(request)
    }

    final case class PutBucketInventoryConfigurationOp(
      request: PutBucketInventoryConfigurationRequest
    ) extends S3Op[PutBucketInventoryConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketInventoryConfigurationResponse] =
        visitor.putBucketInventoryConfiguration(request)
    }

    final case class PutBucketLifecycleConfigurationOp(
      request: PutBucketLifecycleConfigurationRequest
    ) extends S3Op[PutBucketLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketLifecycleConfigurationResponse] =
        visitor.putBucketLifecycleConfiguration(request)
    }

    final case class PutBucketLoggingOp(
      request: PutBucketLoggingRequest
    ) extends S3Op[PutBucketLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketLoggingResponse] =
        visitor.putBucketLogging(request)
    }

    final case class PutBucketMetricsConfigurationOp(
      request: PutBucketMetricsConfigurationRequest
    ) extends S3Op[PutBucketMetricsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketMetricsConfigurationResponse] =
        visitor.putBucketMetricsConfiguration(request)
    }

    final case class PutBucketNotificationConfigurationOp(
      request: PutBucketNotificationConfigurationRequest
    ) extends S3Op[PutBucketNotificationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketNotificationConfigurationResponse] =
        visitor.putBucketNotificationConfiguration(request)
    }

    final case class PutBucketOwnershipControlsOp(
      request: PutBucketOwnershipControlsRequest
    ) extends S3Op[PutBucketOwnershipControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketOwnershipControlsResponse] =
        visitor.putBucketOwnershipControls(request)
    }

    final case class PutBucketPolicyOp(
      request: PutBucketPolicyRequest
    ) extends S3Op[PutBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketPolicyResponse] =
        visitor.putBucketPolicy(request)
    }

    final case class PutBucketReplicationOp(
      request: PutBucketReplicationRequest
    ) extends S3Op[PutBucketReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketReplicationResponse] =
        visitor.putBucketReplication(request)
    }

    final case class PutBucketRequestPaymentOp(
      request: PutBucketRequestPaymentRequest
    ) extends S3Op[PutBucketRequestPaymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketRequestPaymentResponse] =
        visitor.putBucketRequestPayment(request)
    }

    final case class PutBucketTaggingOp(
      request: PutBucketTaggingRequest
    ) extends S3Op[PutBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketTaggingResponse] =
        visitor.putBucketTagging(request)
    }

    final case class PutBucketVersioningOp(
      request: PutBucketVersioningRequest
    ) extends S3Op[PutBucketVersioningResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketVersioningResponse] =
        visitor.putBucketVersioning(request)
    }

    final case class PutBucketWebsiteOp(
      request: PutBucketWebsiteRequest
    ) extends S3Op[PutBucketWebsiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketWebsiteResponse] =
        visitor.putBucketWebsite(request)
    }

    final case class PutObjectOp(
      request: PutObjectRequest,
      body: RequestBody
    ) extends S3Op[PutObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectResponse] =
        visitor.putObject(request, body)
    }

    final case class PutObjectAclOp(
      request: PutObjectAclRequest
    ) extends S3Op[PutObjectAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectAclResponse] =
        visitor.putObjectAcl(request)
    }

    final case class PutObjectLegalHoldOp(
      request: PutObjectLegalHoldRequest
    ) extends S3Op[PutObjectLegalHoldResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectLegalHoldResponse] =
        visitor.putObjectLegalHold(request)
    }

    final case class PutObjectLockConfigurationOp(
      request: PutObjectLockConfigurationRequest
    ) extends S3Op[PutObjectLockConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectLockConfigurationResponse] =
        visitor.putObjectLockConfiguration(request)
    }

    final case class PutObjectRetentionOp(
      request: PutObjectRetentionRequest
    ) extends S3Op[PutObjectRetentionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectRetentionResponse] =
        visitor.putObjectRetention(request)
    }

    final case class PutObjectTaggingOp(
      request: PutObjectTaggingRequest
    ) extends S3Op[PutObjectTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectTaggingResponse] =
        visitor.putObjectTagging(request)
    }

    final case class PutPublicAccessBlockOp(
      request: PutPublicAccessBlockRequest
    ) extends S3Op[PutPublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPublicAccessBlockResponse] =
        visitor.putPublicAccessBlock(request)
    }

    final case class RestoreObjectOp(
      request: RestoreObjectRequest
    ) extends S3Op[RestoreObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreObjectResponse] =
        visitor.restoreObject(request)
    }

    final case class UploadPartOp(
      request: UploadPartRequest,
      body: RequestBody
    ) extends S3Op[UploadPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadPartResponse] =
        visitor.uploadPart(request, body)
    }

    final case class UploadPartCopyOp(
      request: UploadPartCopyRequest
    ) extends S3Op[UploadPartCopyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadPartCopyResponse] =
        visitor.uploadPartCopy(request)
    }

    final case class WriteGetObjectResponseOp(
      request: WriteGetObjectResponseRequest,
      body: RequestBody
    ) extends S3Op[WriteGetObjectResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[WriteGetObjectResponseResponse] =
        visitor.writeGetObjectResponse(request, body)
    }
  }

  import S3Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[S3Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def abortMultipartUpload(
    request: AbortMultipartUploadRequest
  ): S3IO[AbortMultipartUploadResponse] =
    FF.liftF(AbortMultipartUploadOp(request))

  def completeMultipartUpload(
    request: CompleteMultipartUploadRequest
  ): S3IO[CompleteMultipartUploadResponse] =
    FF.liftF(CompleteMultipartUploadOp(request))

  def copyObject(
    request: CopyObjectRequest
  ): S3IO[CopyObjectResponse] =
    FF.liftF(CopyObjectOp(request))

  def createBucket(
    request: CreateBucketRequest
  ): S3IO[CreateBucketResponse] =
    FF.liftF(CreateBucketOp(request))

  def createMultipartUpload(
    request: CreateMultipartUploadRequest
  ): S3IO[CreateMultipartUploadResponse] =
    FF.liftF(CreateMultipartUploadOp(request))

  def deleteBucket(
    request: DeleteBucketRequest
  ): S3IO[DeleteBucketResponse] =
    FF.liftF(DeleteBucketOp(request))

  def deleteBucketAnalyticsConfiguration(
    request: DeleteBucketAnalyticsConfigurationRequest
  ): S3IO[DeleteBucketAnalyticsConfigurationResponse] =
    FF.liftF(DeleteBucketAnalyticsConfigurationOp(request))

  def deleteBucketCors(
    request: DeleteBucketCorsRequest
  ): S3IO[DeleteBucketCorsResponse] =
    FF.liftF(DeleteBucketCorsOp(request))

  def deleteBucketEncryption(
    request: DeleteBucketEncryptionRequest
  ): S3IO[DeleteBucketEncryptionResponse] =
    FF.liftF(DeleteBucketEncryptionOp(request))

  def deleteBucketIntelligentTieringConfiguration(
    request: DeleteBucketIntelligentTieringConfigurationRequest
  ): S3IO[DeleteBucketIntelligentTieringConfigurationResponse] =
    FF.liftF(DeleteBucketIntelligentTieringConfigurationOp(request))

  def deleteBucketInventoryConfiguration(
    request: DeleteBucketInventoryConfigurationRequest
  ): S3IO[DeleteBucketInventoryConfigurationResponse] =
    FF.liftF(DeleteBucketInventoryConfigurationOp(request))

  def deleteBucketLifecycle(
    request: DeleteBucketLifecycleRequest
  ): S3IO[DeleteBucketLifecycleResponse] =
    FF.liftF(DeleteBucketLifecycleOp(request))

  def deleteBucketMetricsConfiguration(
    request: DeleteBucketMetricsConfigurationRequest
  ): S3IO[DeleteBucketMetricsConfigurationResponse] =
    FF.liftF(DeleteBucketMetricsConfigurationOp(request))

  def deleteBucketOwnershipControls(
    request: DeleteBucketOwnershipControlsRequest
  ): S3IO[DeleteBucketOwnershipControlsResponse] =
    FF.liftF(DeleteBucketOwnershipControlsOp(request))

  def deleteBucketPolicy(
    request: DeleteBucketPolicyRequest
  ): S3IO[DeleteBucketPolicyResponse] =
    FF.liftF(DeleteBucketPolicyOp(request))

  def deleteBucketReplication(
    request: DeleteBucketReplicationRequest
  ): S3IO[DeleteBucketReplicationResponse] =
    FF.liftF(DeleteBucketReplicationOp(request))

  def deleteBucketTagging(
    request: DeleteBucketTaggingRequest
  ): S3IO[DeleteBucketTaggingResponse] =
    FF.liftF(DeleteBucketTaggingOp(request))

  def deleteBucketWebsite(
    request: DeleteBucketWebsiteRequest
  ): S3IO[DeleteBucketWebsiteResponse] =
    FF.liftF(DeleteBucketWebsiteOp(request))

  def deleteObject(
    request: DeleteObjectRequest
  ): S3IO[DeleteObjectResponse] =
    FF.liftF(DeleteObjectOp(request))

  def deleteObjectTagging(
    request: DeleteObjectTaggingRequest
  ): S3IO[DeleteObjectTaggingResponse] =
    FF.liftF(DeleteObjectTaggingOp(request))

  def deleteObjects(
    request: DeleteObjectsRequest
  ): S3IO[DeleteObjectsResponse] =
    FF.liftF(DeleteObjectsOp(request))

  def deletePublicAccessBlock(
    request: DeletePublicAccessBlockRequest
  ): S3IO[DeletePublicAccessBlockResponse] =
    FF.liftF(DeletePublicAccessBlockOp(request))

  def getBucketAccelerateConfiguration(
    request: GetBucketAccelerateConfigurationRequest
  ): S3IO[GetBucketAccelerateConfigurationResponse] =
    FF.liftF(GetBucketAccelerateConfigurationOp(request))

  def getBucketAcl(
    request: GetBucketAclRequest
  ): S3IO[GetBucketAclResponse] =
    FF.liftF(GetBucketAclOp(request))

  def getBucketAnalyticsConfiguration(
    request: GetBucketAnalyticsConfigurationRequest
  ): S3IO[GetBucketAnalyticsConfigurationResponse] =
    FF.liftF(GetBucketAnalyticsConfigurationOp(request))

  def getBucketCors(
    request: GetBucketCorsRequest
  ): S3IO[GetBucketCorsResponse] =
    FF.liftF(GetBucketCorsOp(request))

  def getBucketEncryption(
    request: GetBucketEncryptionRequest
  ): S3IO[GetBucketEncryptionResponse] =
    FF.liftF(GetBucketEncryptionOp(request))

  def getBucketIntelligentTieringConfiguration(
    request: GetBucketIntelligentTieringConfigurationRequest
  ): S3IO[GetBucketIntelligentTieringConfigurationResponse] =
    FF.liftF(GetBucketIntelligentTieringConfigurationOp(request))

  def getBucketInventoryConfiguration(
    request: GetBucketInventoryConfigurationRequest
  ): S3IO[GetBucketInventoryConfigurationResponse] =
    FF.liftF(GetBucketInventoryConfigurationOp(request))

  def getBucketLifecycleConfiguration(
    request: GetBucketLifecycleConfigurationRequest
  ): S3IO[GetBucketLifecycleConfigurationResponse] =
    FF.liftF(GetBucketLifecycleConfigurationOp(request))

  def getBucketLocation(
    request: GetBucketLocationRequest
  ): S3IO[GetBucketLocationResponse] =
    FF.liftF(GetBucketLocationOp(request))

  def getBucketLogging(
    request: GetBucketLoggingRequest
  ): S3IO[GetBucketLoggingResponse] =
    FF.liftF(GetBucketLoggingOp(request))

  def getBucketMetricsConfiguration(
    request: GetBucketMetricsConfigurationRequest
  ): S3IO[GetBucketMetricsConfigurationResponse] =
    FF.liftF(GetBucketMetricsConfigurationOp(request))

  def getBucketNotificationConfiguration(
    request: GetBucketNotificationConfigurationRequest
  ): S3IO[GetBucketNotificationConfigurationResponse] =
    FF.liftF(GetBucketNotificationConfigurationOp(request))

  def getBucketOwnershipControls(
    request: GetBucketOwnershipControlsRequest
  ): S3IO[GetBucketOwnershipControlsResponse] =
    FF.liftF(GetBucketOwnershipControlsOp(request))

  def getBucketPolicy(
    request: GetBucketPolicyRequest
  ): S3IO[GetBucketPolicyResponse] =
    FF.liftF(GetBucketPolicyOp(request))

  def getBucketPolicyStatus(
    request: GetBucketPolicyStatusRequest
  ): S3IO[GetBucketPolicyStatusResponse] =
    FF.liftF(GetBucketPolicyStatusOp(request))

  def getBucketReplication(
    request: GetBucketReplicationRequest
  ): S3IO[GetBucketReplicationResponse] =
    FF.liftF(GetBucketReplicationOp(request))

  def getBucketRequestPayment(
    request: GetBucketRequestPaymentRequest
  ): S3IO[GetBucketRequestPaymentResponse] =
    FF.liftF(GetBucketRequestPaymentOp(request))

  def getBucketTagging(
    request: GetBucketTaggingRequest
  ): S3IO[GetBucketTaggingResponse] =
    FF.liftF(GetBucketTaggingOp(request))

  def getBucketVersioning(
    request: GetBucketVersioningRequest
  ): S3IO[GetBucketVersioningResponse] =
    FF.liftF(GetBucketVersioningOp(request))

  def getBucketWebsite(
    request: GetBucketWebsiteRequest
  ): S3IO[GetBucketWebsiteResponse] =
    FF.liftF(GetBucketWebsiteOp(request))

  def getObject(
    request: GetObjectRequest,
    path: Path
  ): S3IO[GetObjectResponse] =
    FF.liftF(GetObjectOp(request, path))

  def getObjectAcl(
    request: GetObjectAclRequest
  ): S3IO[GetObjectAclResponse] =
    FF.liftF(GetObjectAclOp(request))

  def getObjectLegalHold(
    request: GetObjectLegalHoldRequest
  ): S3IO[GetObjectLegalHoldResponse] =
    FF.liftF(GetObjectLegalHoldOp(request))

  def getObjectLockConfiguration(
    request: GetObjectLockConfigurationRequest
  ): S3IO[GetObjectLockConfigurationResponse] =
    FF.liftF(GetObjectLockConfigurationOp(request))

  def getObjectRetention(
    request: GetObjectRetentionRequest
  ): S3IO[GetObjectRetentionResponse] =
    FF.liftF(GetObjectRetentionOp(request))

  def getObjectTagging(
    request: GetObjectTaggingRequest
  ): S3IO[GetObjectTaggingResponse] =
    FF.liftF(GetObjectTaggingOp(request))

  def getPublicAccessBlock(
    request: GetPublicAccessBlockRequest
  ): S3IO[GetPublicAccessBlockResponse] =
    FF.liftF(GetPublicAccessBlockOp(request))

  def headBucket(
    request: HeadBucketRequest
  ): S3IO[HeadBucketResponse] =
    FF.liftF(HeadBucketOp(request))

  def headObject(
    request: HeadObjectRequest
  ): S3IO[HeadObjectResponse] =
    FF.liftF(HeadObjectOp(request))

  def listBucketAnalyticsConfigurations(
    request: ListBucketAnalyticsConfigurationsRequest
  ): S3IO[ListBucketAnalyticsConfigurationsResponse] =
    FF.liftF(ListBucketAnalyticsConfigurationsOp(request))

  def listBucketIntelligentTieringConfigurations(
    request: ListBucketIntelligentTieringConfigurationsRequest
  ): S3IO[ListBucketIntelligentTieringConfigurationsResponse] =
    FF.liftF(ListBucketIntelligentTieringConfigurationsOp(request))

  def listBucketInventoryConfigurations(
    request: ListBucketInventoryConfigurationsRequest
  ): S3IO[ListBucketInventoryConfigurationsResponse] =
    FF.liftF(ListBucketInventoryConfigurationsOp(request))

  def listBucketMetricsConfigurations(
    request: ListBucketMetricsConfigurationsRequest
  ): S3IO[ListBucketMetricsConfigurationsResponse] =
    FF.liftF(ListBucketMetricsConfigurationsOp(request))

  def listBuckets(
    request: ListBucketsRequest
  ): S3IO[ListBucketsResponse] =
    FF.liftF(ListBucketsOp(request))

  def listMultipartUploads(
    request: ListMultipartUploadsRequest
  ): S3IO[ListMultipartUploadsResponse] =
    FF.liftF(ListMultipartUploadsOp(request))

  def listObjectVersions(
    request: ListObjectVersionsRequest
  ): S3IO[ListObjectVersionsResponse] =
    FF.liftF(ListObjectVersionsOp(request))

  def listObjects(
    request: ListObjectsRequest
  ): S3IO[ListObjectsResponse] =
    FF.liftF(ListObjectsOp(request))

  def listObjectsV2(
    request: ListObjectsV2Request
  ): S3IO[ListObjectsV2Response] =
    FF.liftF(ListObjectsV2Op(request))

  def listParts(
    request: ListPartsRequest
  ): S3IO[ListPartsResponse] =
    FF.liftF(ListPartsOp(request))

  def putBucketAccelerateConfiguration(
    request: PutBucketAccelerateConfigurationRequest
  ): S3IO[PutBucketAccelerateConfigurationResponse] =
    FF.liftF(PutBucketAccelerateConfigurationOp(request))

  def putBucketAcl(
    request: PutBucketAclRequest
  ): S3IO[PutBucketAclResponse] =
    FF.liftF(PutBucketAclOp(request))

  def putBucketAnalyticsConfiguration(
    request: PutBucketAnalyticsConfigurationRequest
  ): S3IO[PutBucketAnalyticsConfigurationResponse] =
    FF.liftF(PutBucketAnalyticsConfigurationOp(request))

  def putBucketCors(
    request: PutBucketCorsRequest
  ): S3IO[PutBucketCorsResponse] =
    FF.liftF(PutBucketCorsOp(request))

  def putBucketEncryption(
    request: PutBucketEncryptionRequest
  ): S3IO[PutBucketEncryptionResponse] =
    FF.liftF(PutBucketEncryptionOp(request))

  def putBucketIntelligentTieringConfiguration(
    request: PutBucketIntelligentTieringConfigurationRequest
  ): S3IO[PutBucketIntelligentTieringConfigurationResponse] =
    FF.liftF(PutBucketIntelligentTieringConfigurationOp(request))

  def putBucketInventoryConfiguration(
    request: PutBucketInventoryConfigurationRequest
  ): S3IO[PutBucketInventoryConfigurationResponse] =
    FF.liftF(PutBucketInventoryConfigurationOp(request))

  def putBucketLifecycleConfiguration(
    request: PutBucketLifecycleConfigurationRequest
  ): S3IO[PutBucketLifecycleConfigurationResponse] =
    FF.liftF(PutBucketLifecycleConfigurationOp(request))

  def putBucketLogging(
    request: PutBucketLoggingRequest
  ): S3IO[PutBucketLoggingResponse] =
    FF.liftF(PutBucketLoggingOp(request))

  def putBucketMetricsConfiguration(
    request: PutBucketMetricsConfigurationRequest
  ): S3IO[PutBucketMetricsConfigurationResponse] =
    FF.liftF(PutBucketMetricsConfigurationOp(request))

  def putBucketNotificationConfiguration(
    request: PutBucketNotificationConfigurationRequest
  ): S3IO[PutBucketNotificationConfigurationResponse] =
    FF.liftF(PutBucketNotificationConfigurationOp(request))

  def putBucketOwnershipControls(
    request: PutBucketOwnershipControlsRequest
  ): S3IO[PutBucketOwnershipControlsResponse] =
    FF.liftF(PutBucketOwnershipControlsOp(request))

  def putBucketPolicy(
    request: PutBucketPolicyRequest
  ): S3IO[PutBucketPolicyResponse] =
    FF.liftF(PutBucketPolicyOp(request))

  def putBucketReplication(
    request: PutBucketReplicationRequest
  ): S3IO[PutBucketReplicationResponse] =
    FF.liftF(PutBucketReplicationOp(request))

  def putBucketRequestPayment(
    request: PutBucketRequestPaymentRequest
  ): S3IO[PutBucketRequestPaymentResponse] =
    FF.liftF(PutBucketRequestPaymentOp(request))

  def putBucketTagging(
    request: PutBucketTaggingRequest
  ): S3IO[PutBucketTaggingResponse] =
    FF.liftF(PutBucketTaggingOp(request))

  def putBucketVersioning(
    request: PutBucketVersioningRequest
  ): S3IO[PutBucketVersioningResponse] =
    FF.liftF(PutBucketVersioningOp(request))

  def putBucketWebsite(
    request: PutBucketWebsiteRequest
  ): S3IO[PutBucketWebsiteResponse] =
    FF.liftF(PutBucketWebsiteOp(request))

  def putObject(
    request: PutObjectRequest,
    body: RequestBody
  ): S3IO[PutObjectResponse] =
    FF.liftF(PutObjectOp(request, body))

  def putObjectAcl(
    request: PutObjectAclRequest
  ): S3IO[PutObjectAclResponse] =
    FF.liftF(PutObjectAclOp(request))

  def putObjectLegalHold(
    request: PutObjectLegalHoldRequest
  ): S3IO[PutObjectLegalHoldResponse] =
    FF.liftF(PutObjectLegalHoldOp(request))

  def putObjectLockConfiguration(
    request: PutObjectLockConfigurationRequest
  ): S3IO[PutObjectLockConfigurationResponse] =
    FF.liftF(PutObjectLockConfigurationOp(request))

  def putObjectRetention(
    request: PutObjectRetentionRequest
  ): S3IO[PutObjectRetentionResponse] =
    FF.liftF(PutObjectRetentionOp(request))

  def putObjectTagging(
    request: PutObjectTaggingRequest
  ): S3IO[PutObjectTaggingResponse] =
    FF.liftF(PutObjectTaggingOp(request))

  def putPublicAccessBlock(
    request: PutPublicAccessBlockRequest
  ): S3IO[PutPublicAccessBlockResponse] =
    FF.liftF(PutPublicAccessBlockOp(request))

  def restoreObject(
    request: RestoreObjectRequest
  ): S3IO[RestoreObjectResponse] =
    FF.liftF(RestoreObjectOp(request))

  def uploadPart(
    request: UploadPartRequest,
    body: RequestBody
  ): S3IO[UploadPartResponse] =
    FF.liftF(UploadPartOp(request, body))

  def uploadPartCopy(
    request: UploadPartCopyRequest
  ): S3IO[UploadPartCopyResponse] =
    FF.liftF(UploadPartCopyOp(request))

  def writeGetObjectResponse(
    request: WriteGetObjectResponseRequest,
    body: RequestBody
  ): S3IO[WriteGetObjectResponseResponse] =
    FF.liftF(WriteGetObjectResponseOp(request, body))
}
