package goober.free

import scala.language.higherKinds

import java.nio.file.Path
import cats.free.{Free => FF}
import cats.~>
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model._

object s3 { module =>

  // Free monad over StatementOp.
  type S3IO[A] = FF[S3Op, A]

  // Operations for s3
  sealed trait S3Op[A] {
    def visit[F[_]](visitor: S3Op.Visitor[F]): F[A]
  }

  object S3Op {
    // Given a S3Client we can embed a S3IO program in any algebra that understands embedding.
    implicit val S3OpEmbeddable: Embeddable[S3Op, S3Client] = new Embeddable[S3Op, S3Client] {
      def embed[A](s3Client: S3Client, s3IO: S3IO[A]): Embedded[A] = Embedded.S3(s3Client, s3IO)
    }

    trait Visitor[F[_]] extends (S3Op ~> F) {
      final def apply[A](op: S3Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def abortMultipartUpload(
        abortMultipartUploadRequest: AbortMultipartUploadRequest
      ): F[AbortMultipartUploadResponse]

      def completeMultipartUpload(
        completeMultipartUploadRequest: CompleteMultipartUploadRequest
      ): F[CompleteMultipartUploadResponse]

      def copyObject(
        copyObjectRequest: CopyObjectRequest
      ): F[CopyObjectResponse]

      def createBucket(
        createBucketRequest: CreateBucketRequest
      ): F[CreateBucketResponse]

      def createMultipartUpload(
        createMultipartUploadRequest: CreateMultipartUploadRequest
      ): F[CreateMultipartUploadResponse]

      def deleteBucket(
        deleteBucketRequest: DeleteBucketRequest
      ): F[DeleteBucketResponse]

      def deleteBucketAnalyticsConfiguration(
        deleteBucketAnalyticsConfigurationRequest: DeleteBucketAnalyticsConfigurationRequest
      ): F[DeleteBucketAnalyticsConfigurationResponse]

      def deleteBucketCors(
        deleteBucketCorsRequest: DeleteBucketCorsRequest
      ): F[DeleteBucketCorsResponse]

      def deleteBucketEncryption(
        deleteBucketEncryptionRequest: DeleteBucketEncryptionRequest
      ): F[DeleteBucketEncryptionResponse]

      def deleteBucketIntelligentTieringConfiguration(
        deleteBucketIntelligentTieringConfigurationRequest: DeleteBucketIntelligentTieringConfigurationRequest
      ): F[DeleteBucketIntelligentTieringConfigurationResponse]

      def deleteBucketInventoryConfiguration(
        deleteBucketInventoryConfigurationRequest: DeleteBucketInventoryConfigurationRequest
      ): F[DeleteBucketInventoryConfigurationResponse]

      def deleteBucketLifecycle(
        deleteBucketLifecycleRequest: DeleteBucketLifecycleRequest
      ): F[DeleteBucketLifecycleResponse]

      def deleteBucketMetricsConfiguration(
        deleteBucketMetricsConfigurationRequest: DeleteBucketMetricsConfigurationRequest
      ): F[DeleteBucketMetricsConfigurationResponse]

      def deleteBucketOwnershipControls(
        deleteBucketOwnershipControlsRequest: DeleteBucketOwnershipControlsRequest
      ): F[DeleteBucketOwnershipControlsResponse]

      def deleteBucketPolicy(
        deleteBucketPolicyRequest: DeleteBucketPolicyRequest
      ): F[DeleteBucketPolicyResponse]

      def deleteBucketReplication(
        deleteBucketReplicationRequest: DeleteBucketReplicationRequest
      ): F[DeleteBucketReplicationResponse]

      def deleteBucketTagging(
        deleteBucketTaggingRequest: DeleteBucketTaggingRequest
      ): F[DeleteBucketTaggingResponse]

      def deleteBucketWebsite(
        deleteBucketWebsiteRequest: DeleteBucketWebsiteRequest
      ): F[DeleteBucketWebsiteResponse]

      def deleteObject(
        deleteObjectRequest: DeleteObjectRequest
      ): F[DeleteObjectResponse]

      def deleteObjectTagging(
        deleteObjectTaggingRequest: DeleteObjectTaggingRequest
      ): F[DeleteObjectTaggingResponse]

      def deleteObjects(
        deleteObjectsRequest: DeleteObjectsRequest
      ): F[DeleteObjectsResponse]

      def deletePublicAccessBlock(
        deletePublicAccessBlockRequest: DeletePublicAccessBlockRequest
      ): F[DeletePublicAccessBlockResponse]

      def getBucketAccelerateConfiguration(
        getBucketAccelerateConfigurationRequest: GetBucketAccelerateConfigurationRequest
      ): F[GetBucketAccelerateConfigurationResponse]

      def getBucketAcl(
        getBucketAclRequest: GetBucketAclRequest
      ): F[GetBucketAclResponse]

      def getBucketAnalyticsConfiguration(
        getBucketAnalyticsConfigurationRequest: GetBucketAnalyticsConfigurationRequest
      ): F[GetBucketAnalyticsConfigurationResponse]

      def getBucketCors(
        getBucketCorsRequest: GetBucketCorsRequest
      ): F[GetBucketCorsResponse]

      def getBucketEncryption(
        getBucketEncryptionRequest: GetBucketEncryptionRequest
      ): F[GetBucketEncryptionResponse]

      def getBucketIntelligentTieringConfiguration(
        getBucketIntelligentTieringConfigurationRequest: GetBucketIntelligentTieringConfigurationRequest
      ): F[GetBucketIntelligentTieringConfigurationResponse]

      def getBucketInventoryConfiguration(
        getBucketInventoryConfigurationRequest: GetBucketInventoryConfigurationRequest
      ): F[GetBucketInventoryConfigurationResponse]

      def getBucketLifecycleConfiguration(
        getBucketLifecycleConfigurationRequest: GetBucketLifecycleConfigurationRequest
      ): F[GetBucketLifecycleConfigurationResponse]

      def getBucketLocation(
        getBucketLocationRequest: GetBucketLocationRequest
      ): F[GetBucketLocationResponse]

      def getBucketLogging(
        getBucketLoggingRequest: GetBucketLoggingRequest
      ): F[GetBucketLoggingResponse]

      def getBucketMetricsConfiguration(
        getBucketMetricsConfigurationRequest: GetBucketMetricsConfigurationRequest
      ): F[GetBucketMetricsConfigurationResponse]

      def getBucketNotificationConfiguration(
        getBucketNotificationConfigurationRequest: GetBucketNotificationConfigurationRequest
      ): F[GetBucketNotificationConfigurationResponse]

      def getBucketOwnershipControls(
        getBucketOwnershipControlsRequest: GetBucketOwnershipControlsRequest
      ): F[GetBucketOwnershipControlsResponse]

      def getBucketPolicy(
        getBucketPolicyRequest: GetBucketPolicyRequest
      ): F[GetBucketPolicyResponse]

      def getBucketPolicyStatus(
        getBucketPolicyStatusRequest: GetBucketPolicyStatusRequest
      ): F[GetBucketPolicyStatusResponse]

      def getBucketReplication(
        getBucketReplicationRequest: GetBucketReplicationRequest
      ): F[GetBucketReplicationResponse]

      def getBucketRequestPayment(
        getBucketRequestPaymentRequest: GetBucketRequestPaymentRequest
      ): F[GetBucketRequestPaymentResponse]

      def getBucketTagging(
        getBucketTaggingRequest: GetBucketTaggingRequest
      ): F[GetBucketTaggingResponse]

      def getBucketVersioning(
        getBucketVersioningRequest: GetBucketVersioningRequest
      ): F[GetBucketVersioningResponse]

      def getBucketWebsite(
        getBucketWebsiteRequest: GetBucketWebsiteRequest
      ): F[GetBucketWebsiteResponse]

      def getObject(
        getObjectRequest: GetObjectRequest,
        destinationPath: Path
      ): F[GetObjectResponse]

      def getObjectAcl(
        getObjectAclRequest: GetObjectAclRequest
      ): F[GetObjectAclResponse]

      def getObjectLegalHold(
        getObjectLegalHoldRequest: GetObjectLegalHoldRequest
      ): F[GetObjectLegalHoldResponse]

      def getObjectLockConfiguration(
        getObjectLockConfigurationRequest: GetObjectLockConfigurationRequest
      ): F[GetObjectLockConfigurationResponse]

      def getObjectRetention(
        getObjectRetentionRequest: GetObjectRetentionRequest
      ): F[GetObjectRetentionResponse]

      def getObjectTagging(
        getObjectTaggingRequest: GetObjectTaggingRequest
      ): F[GetObjectTaggingResponse]

      def getPublicAccessBlock(
        getPublicAccessBlockRequest: GetPublicAccessBlockRequest
      ): F[GetPublicAccessBlockResponse]

      def headBucket(
        headBucketRequest: HeadBucketRequest
      ): F[HeadBucketResponse]

      def headObject(
        headObjectRequest: HeadObjectRequest
      ): F[HeadObjectResponse]

      def listBucketAnalyticsConfigurations(
        listBucketAnalyticsConfigurationsRequest: ListBucketAnalyticsConfigurationsRequest
      ): F[ListBucketAnalyticsConfigurationsResponse]

      def listBucketIntelligentTieringConfigurations(
        listBucketIntelligentTieringConfigurationsRequest: ListBucketIntelligentTieringConfigurationsRequest
      ): F[ListBucketIntelligentTieringConfigurationsResponse]

      def listBucketInventoryConfigurations(
        listBucketInventoryConfigurationsRequest: ListBucketInventoryConfigurationsRequest
      ): F[ListBucketInventoryConfigurationsResponse]

      def listBucketMetricsConfigurations(
        listBucketMetricsConfigurationsRequest: ListBucketMetricsConfigurationsRequest
      ): F[ListBucketMetricsConfigurationsResponse]

      def listBuckets(
        listBucketsRequest: ListBucketsRequest
      ): F[ListBucketsResponse]

      def listMultipartUploads(
        listMultipartUploadsRequest: ListMultipartUploadsRequest
      ): F[ListMultipartUploadsResponse]

      def listObjectVersions(
        listObjectVersionsRequest: ListObjectVersionsRequest
      ): F[ListObjectVersionsResponse]

      def listObjects(
        listObjectsRequest: ListObjectsRequest
      ): F[ListObjectsResponse]

      def listObjectsV2(
        listObjectsV2Request: ListObjectsV2Request
      ): F[ListObjectsV2Response]

      def listParts(
        listPartsRequest: ListPartsRequest
      ): F[ListPartsResponse]

      def putBucketAccelerateConfiguration(
        putBucketAccelerateConfigurationRequest: PutBucketAccelerateConfigurationRequest
      ): F[PutBucketAccelerateConfigurationResponse]

      def putBucketAcl(
        putBucketAclRequest: PutBucketAclRequest
      ): F[PutBucketAclResponse]

      def putBucketAnalyticsConfiguration(
        putBucketAnalyticsConfigurationRequest: PutBucketAnalyticsConfigurationRequest
      ): F[PutBucketAnalyticsConfigurationResponse]

      def putBucketCors(
        putBucketCorsRequest: PutBucketCorsRequest
      ): F[PutBucketCorsResponse]

      def putBucketEncryption(
        putBucketEncryptionRequest: PutBucketEncryptionRequest
      ): F[PutBucketEncryptionResponse]

      def putBucketIntelligentTieringConfiguration(
        putBucketIntelligentTieringConfigurationRequest: PutBucketIntelligentTieringConfigurationRequest
      ): F[PutBucketIntelligentTieringConfigurationResponse]

      def putBucketInventoryConfiguration(
        putBucketInventoryConfigurationRequest: PutBucketInventoryConfigurationRequest
      ): F[PutBucketInventoryConfigurationResponse]

      def putBucketLifecycleConfiguration(
        putBucketLifecycleConfigurationRequest: PutBucketLifecycleConfigurationRequest
      ): F[PutBucketLifecycleConfigurationResponse]

      def putBucketLogging(
        putBucketLoggingRequest: PutBucketLoggingRequest
      ): F[PutBucketLoggingResponse]

      def putBucketMetricsConfiguration(
        putBucketMetricsConfigurationRequest: PutBucketMetricsConfigurationRequest
      ): F[PutBucketMetricsConfigurationResponse]

      def putBucketNotificationConfiguration(
        putBucketNotificationConfigurationRequest: PutBucketNotificationConfigurationRequest
      ): F[PutBucketNotificationConfigurationResponse]

      def putBucketOwnershipControls(
        putBucketOwnershipControlsRequest: PutBucketOwnershipControlsRequest
      ): F[PutBucketOwnershipControlsResponse]

      def putBucketPolicy(
        putBucketPolicyRequest: PutBucketPolicyRequest
      ): F[PutBucketPolicyResponse]

      def putBucketReplication(
        putBucketReplicationRequest: PutBucketReplicationRequest
      ): F[PutBucketReplicationResponse]

      def putBucketRequestPayment(
        putBucketRequestPaymentRequest: PutBucketRequestPaymentRequest
      ): F[PutBucketRequestPaymentResponse]

      def putBucketTagging(
        putBucketTaggingRequest: PutBucketTaggingRequest
      ): F[PutBucketTaggingResponse]

      def putBucketVersioning(
        putBucketVersioningRequest: PutBucketVersioningRequest
      ): F[PutBucketVersioningResponse]

      def putBucketWebsite(
        putBucketWebsiteRequest: PutBucketWebsiteRequest
      ): F[PutBucketWebsiteResponse]

      def putObject(
        putObjectRequest: PutObjectRequest,
        requestBody: RequestBody
      ): F[PutObjectResponse]

      def putObjectAcl(
        putObjectAclRequest: PutObjectAclRequest
      ): F[PutObjectAclResponse]

      def putObjectLegalHold (
        putObjectLegalHoldRequest: PutObjectLegalHoldRequest
      ): F[PutObjectLegalHoldResponse]

      def putObjectLockConfiguration(
        putObjectLockConfigurationRequest: PutObjectLockConfigurationRequest
      ): F[PutObjectLockConfigurationResponse]

      def putObjectRetention(
        putObjectRetentionRequest: PutObjectRetentionRequest
      ): F[PutObjectRetentionResponse]

      def putObjectTagging(
        putObjectTaggingRequest: PutObjectTaggingRequest
      ): F[PutObjectTaggingResponse]

      def putPublicAccessBlock(
        putPublicAccessBlockRequest: PutPublicAccessBlockRequest
      ): F[PutPublicAccessBlockResponse]

      def restoreObject(
        restoreObjectRequest: RestoreObjectRequest
      ): F[RestoreObjectResponse]

      def uploadPart(
        uploadPartRequest: UploadPartRequest,
        requestBody: RequestBody
      ): F[UploadPartResponse]

      def uploadPartCopy(
        uploadPartCopyRequest: UploadPartCopyRequest
      ): F[UploadPartCopyResponse]

      def writeGetObjectResponse(
        writeGetObjectResponseRequest: WriteGetObjectResponseRequest,
        requestBody: RequestBody
      ): F[WriteGetObjectResponseResponse]
    }

    final case class Embed[A](e: Embedded[A]) extends S3Op[A] {
      def visit[F[_]](v: Visitor[F]) = v.embed(e)
    }

    final case class AbortMultipartUpload(
      abortMultipartUploadRequest: AbortMultipartUploadRequest
    ) extends S3Op[AbortMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AbortMultipartUploadResponse] =
        visitor.abortMultipartUpload(abortMultipartUploadRequest)
    }

    final case class CompleteMultipartUpload(
      completeMultipartUploadRequest: CompleteMultipartUploadRequest
    ) extends S3Op[CompleteMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteMultipartUploadResponse] =
        visitor.completeMultipartUpload(completeMultipartUploadRequest)
    }

    final case class CopyObject(
      copyObjectRequest: CopyObjectRequest
    ) extends S3Op[CopyObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyObjectResponse] =
        visitor.copyObject(copyObjectRequest)
    }

    final case class CreateBucket(
      createBucketRequest: CreateBucketRequest
    ) extends S3Op[CreateBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBucketResponse] =
        visitor.createBucket(createBucketRequest)
    }

    final case class CreateMultipartUpload(
      createMultipartUploadRequest: CreateMultipartUploadRequest
    ) extends S3Op[CreateMultipartUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMultipartUploadResponse] =
        visitor.createMultipartUpload(createMultipartUploadRequest)
    }

    final case class DeleteBucket(
      deleteBucketRequest: DeleteBucketRequest
    ) extends S3Op[DeleteBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketResponse] =
        visitor.deleteBucket(deleteBucketRequest)
    }

    final case class DeleteBucketAnalyticsConfiguration(
      deleteBucketAnalyticsConfigurationRequest: DeleteBucketAnalyticsConfigurationRequest
    ) extends S3Op[DeleteBucketAnalyticsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketAnalyticsConfigurationResponse] =
        visitor.deleteBucketAnalyticsConfiguration(deleteBucketAnalyticsConfigurationRequest)
    }

    final case class DeleteBucketCors(
      deleteBucketCorsRequest: DeleteBucketCorsRequest
    ) extends S3Op[DeleteBucketCorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketCorsResponse] =
        visitor.deleteBucketCors(deleteBucketCorsRequest)
    }

    final case class DeleteBucketEncryption(
      deleteBucketEncryptionRequest: DeleteBucketEncryptionRequest
    ) extends S3Op[DeleteBucketEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketEncryptionResponse] =
        visitor.deleteBucketEncryption(deleteBucketEncryptionRequest)
    }

    final case class DeleteBucketIntelligentTieringConfiguration(
      deleteBucketIntelligentTieringConfigurationRequest: DeleteBucketIntelligentTieringConfigurationRequest
    ) extends S3Op[DeleteBucketIntelligentTieringConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketIntelligentTieringConfigurationResponse] =
        visitor.deleteBucketIntelligentTieringConfiguration(deleteBucketIntelligentTieringConfigurationRequest)
    }

    final case class DeleteBucketInventoryConfiguration(
      deleteBucketInventoryConfigurationRequest: DeleteBucketInventoryConfigurationRequest
    ) extends S3Op[DeleteBucketInventoryConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketInventoryConfigurationResponse] =
        visitor.deleteBucketInventoryConfiguration(deleteBucketInventoryConfigurationRequest)
    }

    final case class DeleteBucketLifecycle(
      deleteBucketLifecycleRequest: DeleteBucketLifecycleRequest
    ) extends S3Op[DeleteBucketLifecycleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketLifecycleResponse] =
        visitor.deleteBucketLifecycle(deleteBucketLifecycleRequest)
    }

    final case class DeleteBucketMetricsConfiguration(
      deleteBucketMetricsConfigurationRequest: DeleteBucketMetricsConfigurationRequest
    ) extends S3Op[DeleteBucketMetricsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketMetricsConfigurationResponse] =
        visitor.deleteBucketMetricsConfiguration(deleteBucketMetricsConfigurationRequest)
    }

    final case class DeleteBucketOwnershipControls(
      deleteBucketOwnershipControlsRequest: DeleteBucketOwnershipControlsRequest
    ) extends S3Op[DeleteBucketOwnershipControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketOwnershipControlsResponse] =
        visitor.deleteBucketOwnershipControls(deleteBucketOwnershipControlsRequest)
    }

    final case class DeleteBucketPolicy(
      deleteBucketPolicyRequest: DeleteBucketPolicyRequest
    ) extends S3Op[DeleteBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketPolicyResponse] =
        visitor.deleteBucketPolicy(deleteBucketPolicyRequest)
    }

    final case class DeleteBucketReplication(
      deleteBucketReplicationRequest: DeleteBucketReplicationRequest
    ) extends S3Op[DeleteBucketReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketReplicationResponse] =
        visitor.deleteBucketReplication(deleteBucketReplicationRequest)
    }

    final case class DeleteBucketTagging(
      deleteBucketTaggingRequest: DeleteBucketTaggingRequest
    ) extends S3Op[DeleteBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketTaggingResponse] =
        visitor.deleteBucketTagging(deleteBucketTaggingRequest)
    }

    final case class DeleteBucketWebsite(
      deleteBucketWebsiteRequest: DeleteBucketWebsiteRequest
    ) extends S3Op[DeleteBucketWebsiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketWebsiteResponse] =
        visitor.deleteBucketWebsite(deleteBucketWebsiteRequest)
    }

    final case class DeleteObject(
      deleteObjectRequest: DeleteObjectRequest
    ) extends S3Op[DeleteObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectResponse] =
        visitor.deleteObject(deleteObjectRequest)
    }

    final case class DeleteObjectTagging(
      deleteObjectTaggingRequest: DeleteObjectTaggingRequest
    ) extends S3Op[DeleteObjectTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectTaggingResponse] =
        visitor.deleteObjectTagging(deleteObjectTaggingRequest)
    }

    final case class DeleteObjects(
      deleteObjectsRequest: DeleteObjectsRequest
    ) extends S3Op[DeleteObjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteObjectsResponse] =
        visitor.deleteObjects(deleteObjectsRequest)
    }

    final case class DeletePublicAccessBlock(
      deletePublicAccessBlockRequest: DeletePublicAccessBlockRequest
    ) extends S3Op[DeletePublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePublicAccessBlockResponse] =
        visitor.deletePublicAccessBlock(deletePublicAccessBlockRequest)
    }

    final case class GetBucketAccelerateConfiguration(
      getBucketAccelerateConfigurationRequest: GetBucketAccelerateConfigurationRequest
    ) extends S3Op[GetBucketAccelerateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketAccelerateConfigurationResponse] =
        visitor.getBucketAccelerateConfiguration(getBucketAccelerateConfigurationRequest)
    }

    final case class GetBucketAcl(
      getBucketAclRequest: GetBucketAclRequest
    ) extends S3Op[GetBucketAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketAclResponse] =
        visitor.getBucketAcl(getBucketAclRequest)
    }

    final case class GetBucketAnalyticsConfiguration(
      getBucketAnalyticsConfigurationRequest: GetBucketAnalyticsConfigurationRequest
    ) extends S3Op[GetBucketAnalyticsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketAnalyticsConfigurationResponse] =
        visitor.getBucketAnalyticsConfiguration(getBucketAnalyticsConfigurationRequest)
    }

    final case class GetBucketCors(
      getBucketCorsRequest: GetBucketCorsRequest
    ) extends S3Op[GetBucketCorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketCorsResponse] =
        visitor.getBucketCors(getBucketCorsRequest)
    }

    final case class GetBucketEncryption(
      getBucketEncryptionRequest: GetBucketEncryptionRequest
    ) extends S3Op[GetBucketEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketEncryptionResponse] =
        visitor.getBucketEncryption(getBucketEncryptionRequest)
    }

    final case class GetBucketIntelligentTieringConfiguration(
      getBucketIntelligentTieringConfigurationRequest: GetBucketIntelligentTieringConfigurationRequest
    ) extends S3Op[GetBucketIntelligentTieringConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketIntelligentTieringConfigurationResponse] =
        visitor.getBucketIntelligentTieringConfiguration(getBucketIntelligentTieringConfigurationRequest)
    }

    final case class GetBucketInventoryConfiguration(
      getBucketInventoryConfigurationRequest: GetBucketInventoryConfigurationRequest
    ) extends S3Op[GetBucketInventoryConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketInventoryConfigurationResponse] =
        visitor.getBucketInventoryConfiguration(getBucketInventoryConfigurationRequest)
    }

    final case class GetBucketLifecycleConfiguration(
      getBucketLifecycleConfigurationRequest: GetBucketLifecycleConfigurationRequest
    ) extends S3Op[GetBucketLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketLifecycleConfigurationResponse] =
        visitor.getBucketLifecycleConfiguration(getBucketLifecycleConfigurationRequest)
    }

    final case class GetBucketLocation(
      getBucketLocationRequest: GetBucketLocationRequest
    ) extends S3Op[GetBucketLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketLocationResponse] =
        visitor.getBucketLocation(getBucketLocationRequest)
    }

    final case class GetBucketLogging(
      getBucketLoggingRequest: GetBucketLoggingRequest
    ) extends S3Op[GetBucketLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketLoggingResponse] =
        visitor.getBucketLogging(getBucketLoggingRequest)
    }

    final case class GetBucketMetricsConfiguration(
      getBucketMetricsConfigurationRequest: GetBucketMetricsConfigurationRequest
    ) extends S3Op[GetBucketMetricsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketMetricsConfigurationResponse] =
        visitor.getBucketMetricsConfiguration(getBucketMetricsConfigurationRequest)
    }

    final case class GetBucketNotificationConfiguration(
      getBucketNotificationConfigurationRequest: GetBucketNotificationConfigurationRequest
    ) extends S3Op[GetBucketNotificationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketNotificationConfigurationResponse] =
        visitor.getBucketNotificationConfiguration(getBucketNotificationConfigurationRequest)
    }

    final case class GetBucketOwnershipControls(
      getBucketOwnershipControlsRequest: GetBucketOwnershipControlsRequest
    ) extends S3Op[GetBucketOwnershipControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketOwnershipControlsResponse] =
        visitor.getBucketOwnershipControls(getBucketOwnershipControlsRequest)
    }

    final case class GetBucketPolicy(
      getBucketPolicyRequest: GetBucketPolicyRequest
    ) extends S3Op[GetBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketPolicyResponse] =
        visitor.getBucketPolicy(getBucketPolicyRequest)
    }

    final case class GetBucketPolicyStatus(
      getBucketPolicyStatusRequest: GetBucketPolicyStatusRequest
    ) extends S3Op[GetBucketPolicyStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketPolicyStatusResponse] =
        visitor.getBucketPolicyStatus(getBucketPolicyStatusRequest)
    }

    final case class GetBucketReplication(
      getBucketReplicationRequest: GetBucketReplicationRequest
    ) extends S3Op[GetBucketReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketReplicationResponse] =
        visitor.getBucketReplication(getBucketReplicationRequest)
    }

    final case class GetBucketRequestPayment(
      getBucketRequestPaymentRequest: GetBucketRequestPaymentRequest
    ) extends S3Op[GetBucketRequestPaymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketRequestPaymentResponse] =
        visitor.getBucketRequestPayment(getBucketRequestPaymentRequest)
    }

    final case class GetBucketTagging(
      getBucketTaggingRequest: GetBucketTaggingRequest
    ) extends S3Op[GetBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketTaggingResponse] =
        visitor.getBucketTagging(getBucketTaggingRequest)
    }

    final case class GetBucketVersioning(
      getBucketVersioningRequest: GetBucketVersioningRequest
    ) extends S3Op[GetBucketVersioningResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketVersioningResponse] =
        visitor.getBucketVersioning(getBucketVersioningRequest)
    }

    final case class GetBucketWebsite(
      getBucketWebsiteRequest: GetBucketWebsiteRequest
    ) extends S3Op[GetBucketWebsiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketWebsiteResponse] =
        visitor.getBucketWebsite(getBucketWebsiteRequest)
    }

    final case class GetObject(
      getObjectRequest: GetObjectRequest,
      destinationPath: Path
    ) extends S3Op[GetObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectResponse] =
        visitor.getObject(getObjectRequest, destinationPath)
    }

    final case class GetObjectAcl(
      getObjectAclRequest: GetObjectAclRequest
    ) extends S3Op[GetObjectAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectAclResponse] =
        visitor.getObjectAcl(getObjectAclRequest)
    }

    final case class GetObjectLegalHold(
      getObjectLegalHoldRequest: GetObjectLegalHoldRequest
    ) extends S3Op[GetObjectLegalHoldResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectLegalHoldResponse] =
        visitor.getObjectLegalHold(getObjectLegalHoldRequest)
    }

    final case class GetObjectLockConfiguration(
      getObjectLockConfigurationRequest: GetObjectLockConfigurationRequest
    ) extends S3Op[GetObjectLockConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectLockConfigurationResponse] =
        visitor.getObjectLockConfiguration(getObjectLockConfigurationRequest)
    }

    final case class GetObjectRetention(
      getObjectRetentionRequest: GetObjectRetentionRequest
    ) extends S3Op[GetObjectRetentionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectRetentionResponse] =
        visitor.getObjectRetention(getObjectRetentionRequest)
    }

    final case class GetObjectTagging(
      getObjectTaggingRequest: GetObjectTaggingRequest
    ) extends S3Op[GetObjectTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetObjectTaggingResponse] =
        visitor.getObjectTagging(getObjectTaggingRequest)
    }

    final case class GetPublicAccessBlock(
      getPublicAccessBlockRequest: GetPublicAccessBlockRequest
    ) extends S3Op[GetPublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPublicAccessBlockResponse] =
        visitor.getPublicAccessBlock(getPublicAccessBlockRequest)
    }

    final case class HeadBucket(
      headBucketRequest: HeadBucketRequest
    ) extends S3Op[HeadBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[HeadBucketResponse] =
        visitor.headBucket(headBucketRequest)
    }

    final case class HeadObject(
      headObjectRequest: HeadObjectRequest
    ) extends S3Op[HeadObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[HeadObjectResponse] =
        visitor.headObject(headObjectRequest)
    }

    final case class ListBucketAnalyticsConfigurations(
      listBucketAnalyticsConfigurationsRequest: ListBucketAnalyticsConfigurationsRequest
    ) extends S3Op[ListBucketAnalyticsConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketAnalyticsConfigurationsResponse] =
        visitor.listBucketAnalyticsConfigurations(listBucketAnalyticsConfigurationsRequest)
    }

    final case class ListBucketIntelligentTieringConfigurations(
      listBucketIntelligentTieringConfigurationsRequest: ListBucketIntelligentTieringConfigurationsRequest
    ) extends S3Op[ListBucketIntelligentTieringConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketIntelligentTieringConfigurationsResponse] =
        visitor.listBucketIntelligentTieringConfigurations(listBucketIntelligentTieringConfigurationsRequest)
    }

    final case class ListBucketInventoryConfigurations(
      listBucketInventoryConfigurationsRequest: ListBucketInventoryConfigurationsRequest
    ) extends S3Op[ListBucketInventoryConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketInventoryConfigurationsResponse] =
        visitor.listBucketInventoryConfigurations(listBucketInventoryConfigurationsRequest)
    }

    final case class ListBucketMetricsConfigurations(
      listBucketMetricsConfigurationsRequest: ListBucketMetricsConfigurationsRequest
    ) extends S3Op[ListBucketMetricsConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketMetricsConfigurationsResponse] =
        visitor.listBucketMetricsConfigurations(listBucketMetricsConfigurationsRequest)
    }

    final case class ListBuckets(
      listBucketsRequest: ListBucketsRequest
    ) extends S3Op[ListBucketsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBucketsResponse] =
        visitor.listBuckets(listBucketsRequest)
    }

    final case class ListMultipartUploads(
      listMultipartUploadsRequest: ListMultipartUploadsRequest
    ) extends S3Op[ListMultipartUploadsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMultipartUploadsResponse] =
        visitor.listMultipartUploads(listMultipartUploadsRequest)
    }

    final case class ListObjectVersions(
      listObjectVersionsRequest: ListObjectVersionsRequest
    ) extends S3Op[ListObjectVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectVersionsResponse] =
        visitor.listObjectVersions(listObjectVersionsRequest)
    }

    final case class ListObjects(
      listObjectsRequest: ListObjectsRequest
    ) extends S3Op[ListObjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectsResponse] =
        visitor.listObjects(listObjectsRequest)
    }

    final case class ListObjectsV2(
      listObjectsV2Request: ListObjectsV2Request
    ) extends S3Op[ListObjectsV2Response] {
      def visit[F[_]](visitor: Visitor[F]): F[ListObjectsV2Response] =
        visitor.listObjectsV2(listObjectsV2Request)
    }

    final case class ListParts(
      listPartsRequest: ListPartsRequest
    ) extends S3Op[ListPartsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPartsResponse] =
        visitor.listParts(listPartsRequest)
    }

    final case class PutBucketAccelerateConfiguration(
      putBucketAccelerateConfigurationRequest: PutBucketAccelerateConfigurationRequest
    ) extends S3Op[PutBucketAccelerateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketAccelerateConfigurationResponse] =
        visitor.putBucketAccelerateConfiguration(putBucketAccelerateConfigurationRequest)
    }

    final case class PutBucketAcl(
      putBucketAclRequest: PutBucketAclRequest
    ) extends S3Op[PutBucketAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketAclResponse] =
        visitor.putBucketAcl(putBucketAclRequest)
    }

    final case class PutBucketAnalyticsConfiguration(
      putBucketAnalyticsConfigurationRequest: PutBucketAnalyticsConfigurationRequest
    ) extends S3Op[PutBucketAnalyticsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketAnalyticsConfigurationResponse] =
        visitor.putBucketAnalyticsConfiguration(putBucketAnalyticsConfigurationRequest)
    }

    final case class PutBucketCors(
      putBucketCorsRequest: PutBucketCorsRequest
    ) extends S3Op[PutBucketCorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketCorsResponse] =
        visitor.putBucketCors(putBucketCorsRequest)
    }

    final case class PutBucketEncryption(
      putBucketEncryptionRequest: PutBucketEncryptionRequest
    ) extends S3Op[PutBucketEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketEncryptionResponse] =
        visitor.putBucketEncryption(putBucketEncryptionRequest)
    }

    final case class PutBucketIntelligentTieringConfiguration(
      putBucketIntelligentTieringConfigurationRequest: PutBucketIntelligentTieringConfigurationRequest
    ) extends S3Op[PutBucketIntelligentTieringConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketIntelligentTieringConfigurationResponse] =
        visitor.putBucketIntelligentTieringConfiguration(putBucketIntelligentTieringConfigurationRequest)
    }

    final case class PutBucketInventoryConfiguration(
      putBucketInventoryConfigurationRequest: PutBucketInventoryConfigurationRequest
    ) extends S3Op[PutBucketInventoryConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketInventoryConfigurationResponse] =
        visitor.putBucketInventoryConfiguration(putBucketInventoryConfigurationRequest)
    }

    final case class PutBucketLifecycleConfiguration(
      putBucketLifecycleConfigurationRequest: PutBucketLifecycleConfigurationRequest
    ) extends S3Op[PutBucketLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketLifecycleConfigurationResponse] =
        visitor.putBucketLifecycleConfiguration(putBucketLifecycleConfigurationRequest)
    }

    final case class PutBucketLogging(
      putBucketLoggingRequest: PutBucketLoggingRequest
    ) extends S3Op[PutBucketLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketLoggingResponse] =
        visitor.putBucketLogging(putBucketLoggingRequest)
    }

    final case class PutBucketMetricsConfiguration(
      putBucketMetricsConfigurationRequest: PutBucketMetricsConfigurationRequest
    ) extends S3Op[PutBucketMetricsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketMetricsConfigurationResponse] =
        visitor.putBucketMetricsConfiguration(putBucketMetricsConfigurationRequest)
    }

    final case class PutBucketNotificationConfiguration(
      putBucketNotificationConfigurationRequest: PutBucketNotificationConfigurationRequest
    ) extends S3Op[PutBucketNotificationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketNotificationConfigurationResponse] =
        visitor.putBucketNotificationConfiguration(putBucketNotificationConfigurationRequest)
    }

    final case class PutBucketOwnershipControls(
      putBucketOwnershipControlsRequest: PutBucketOwnershipControlsRequest
    ) extends S3Op[PutBucketOwnershipControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketOwnershipControlsResponse] =
        visitor.putBucketOwnershipControls(putBucketOwnershipControlsRequest)
    }

    final case class PutBucketPolicy(
      putBucketPolicyRequest: PutBucketPolicyRequest
    ) extends S3Op[PutBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketPolicyResponse] =
        visitor.putBucketPolicy(putBucketPolicyRequest)
    }

    final case class PutBucketReplication(
      putBucketReplicationRequest: PutBucketReplicationRequest
    ) extends S3Op[PutBucketReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketReplicationResponse] =
        visitor.putBucketReplication(putBucketReplicationRequest)
    }

    final case class PutBucketRequestPayment(
      putBucketRequestPaymentRequest: PutBucketRequestPaymentRequest
    ) extends S3Op[PutBucketRequestPaymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketRequestPaymentResponse] =
        visitor.putBucketRequestPayment(putBucketRequestPaymentRequest)
    }

    final case class PutBucketTagging(
      putBucketTaggingRequest: PutBucketTaggingRequest
    ) extends S3Op[PutBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketTaggingResponse] =
        visitor.putBucketTagging(putBucketTaggingRequest)
    }

    final case class PutBucketVersioning(
      putBucketVersioningRequest: PutBucketVersioningRequest
    ) extends S3Op[PutBucketVersioningResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketVersioningResponse] =
        visitor.putBucketVersioning(putBucketVersioningRequest)
    }

    final case class PutBucketWebsite(
      putBucketWebsiteRequest: PutBucketWebsiteRequest
    ) extends S3Op[PutBucketWebsiteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketWebsiteResponse] =
        visitor.putBucketWebsite(putBucketWebsiteRequest)
    }

    final case class PutObject(
      putObjectRequest: PutObjectRequest,
      requestBody: RequestBody
    ) extends S3Op[PutObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectResponse] =
        visitor.putObject(putObjectRequest, requestBody)
    }

    final case class PutObjectAcl(
      putObjectAclRequest: PutObjectAclRequest
    ) extends S3Op[PutObjectAclResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectAclResponse] =
        visitor.putObjectAcl(putObjectAclRequest)
    }

    final case class PutObjectLegalHold (
      putObjectLegalHoldRequest: PutObjectLegalHoldRequest
    ) extends S3Op[PutObjectLegalHoldResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectLegalHoldResponse] =
        visitor.putObjectLegalHold(putObjectLegalHoldRequest)
    }

    final case class PutObjectLockConfiguration(
      putObjectLockConfigurationRequest: PutObjectLockConfigurationRequest
    ) extends S3Op[PutObjectLockConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectLockConfigurationResponse] =
        visitor.putObjectLockConfiguration(putObjectLockConfigurationRequest)
    }

    final case class PutObjectRetention(
      putObjectRetentionRequest: PutObjectRetentionRequest
    ) extends S3Op[PutObjectRetentionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectRetentionResponse] =
        visitor.putObjectRetention(putObjectRetentionRequest)
    }

    final case class PutObjectTagging(
      putObjectTaggingRequest: PutObjectTaggingRequest
    ) extends S3Op[PutObjectTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutObjectTaggingResponse] =
        visitor.putObjectTagging(putObjectTaggingRequest)
    }

    final case class PutPublicAccessBlock(
      putPublicAccessBlockRequest: PutPublicAccessBlockRequest
    ) extends S3Op[PutPublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPublicAccessBlockResponse] =
        visitor.putPublicAccessBlock(putPublicAccessBlockRequest)
    }

    final case class RestoreObject(
      restoreObjectRequest: RestoreObjectRequest
    ) extends S3Op[RestoreObjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreObjectResponse] =
        visitor.restoreObject(restoreObjectRequest)
    }

    final case class UploadPart(
      uploadPartRequest: UploadPartRequest,
      requestBody: RequestBody
    ) extends S3Op[UploadPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadPartResponse] =
        visitor.uploadPart(uploadPartRequest, requestBody)
    }

    final case class UploadPartCopy(
      uploadPartCopyRequest: UploadPartCopyRequest
    ) extends S3Op[UploadPartCopyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadPartCopyResponse] =
        visitor.uploadPartCopy(uploadPartCopyRequest)
    }

    final case class WriteGetObjectResponse(
      writeGetObjectResponseRequest: WriteGetObjectResponseRequest,
      requestBody: RequestBody
    ) extends S3Op[WriteGetObjectResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[WriteGetObjectResponseResponse] =
        visitor.writeGetObjectResponse(writeGetObjectResponseRequest, requestBody)
    }
  }

  // Smart constructors
  import S3Op._

  def embed[F[_], J, A](j: J, fa: FF[F, A])(implicit ev: Embeddable[F, J]): FF[S3Op, A] = FF.liftF(Embed(ev.embed(j, fa)))

  def abortMultipartUpload(
    abortMultipartUploadRequest: AbortMultipartUploadRequest
  ): S3IO[AbortMultipartUploadResponse] =
    FF.liftF(AbortMultipartUpload(abortMultipartUploadRequest))

  def completeMultipartUpload(
    completeMultipartUploadRequest: CompleteMultipartUploadRequest
  ): S3IO[CompleteMultipartUploadResponse] =
    FF.liftF(CompleteMultipartUpload(completeMultipartUploadRequest))

  def copyObject(
    copyObjectRequest: CopyObjectRequest
  ): S3IO[CopyObjectResponse] =
    FF.liftF(CopyObject(copyObjectRequest))

  def createBucket(
    createBucketRequest: CreateBucketRequest
  ): S3IO[CreateBucketResponse] =
    FF.liftF(CreateBucket(createBucketRequest))

  def createMultipartUpload(
    createMultipartUploadRequest: CreateMultipartUploadRequest
  ): S3IO[CreateMultipartUploadResponse] =
    FF.liftF(CreateMultipartUpload(createMultipartUploadRequest))

  def deleteBucket(
    deleteBucketRequest: DeleteBucketRequest
  ): S3IO[DeleteBucketResponse] =
    FF.liftF(DeleteBucket(deleteBucketRequest))

  def deleteBucketAnalyticsConfiguration(
    deleteBucketAnalyticsConfigurationRequest: DeleteBucketAnalyticsConfigurationRequest
  ): S3IO[DeleteBucketAnalyticsConfigurationResponse] =
    FF.liftF(DeleteBucketAnalyticsConfiguration(deleteBucketAnalyticsConfigurationRequest))

  def deleteBucketCors(
    deleteBucketCorsRequest: DeleteBucketCorsRequest
  ): S3IO[DeleteBucketCorsResponse] =
    FF.liftF(DeleteBucketCors(deleteBucketCorsRequest))

  def deleteBucketEncryption(
    deleteBucketEncryptionRequest: DeleteBucketEncryptionRequest
  ): S3IO[DeleteBucketEncryptionResponse] =
    FF.liftF(DeleteBucketEncryption(deleteBucketEncryptionRequest))

  def deleteBucketIntelligentTieringConfiguration(
    deleteBucketIntelligentTieringConfigurationRequest: DeleteBucketIntelligentTieringConfigurationRequest
  ): S3IO[DeleteBucketIntelligentTieringConfigurationResponse] =
    FF.liftF(DeleteBucketIntelligentTieringConfiguration(deleteBucketIntelligentTieringConfigurationRequest))

  def deleteBucketInventoryConfiguration(
    deleteBucketInventoryConfigurationRequest: DeleteBucketInventoryConfigurationRequest
  ): S3IO[DeleteBucketInventoryConfigurationResponse] =
    FF.liftF(DeleteBucketInventoryConfiguration(deleteBucketInventoryConfigurationRequest))

  def deleteBucketLifecycle(
    deleteBucketLifecycleRequest: DeleteBucketLifecycleRequest
  ): S3IO[DeleteBucketLifecycleResponse] =
    FF.liftF(DeleteBucketLifecycle(deleteBucketLifecycleRequest))

  def deleteBucketMetricsConfiguration(
    deleteBucketMetricsConfigurationRequest: DeleteBucketMetricsConfigurationRequest
  ): S3IO[DeleteBucketMetricsConfigurationResponse] =
    FF.liftF(DeleteBucketMetricsConfiguration(deleteBucketMetricsConfigurationRequest))

  def deleteBucketOwnershipControls(
    deleteBucketOwnershipControlsRequest: DeleteBucketOwnershipControlsRequest
  ): S3IO[DeleteBucketOwnershipControlsResponse] =
    FF.liftF(DeleteBucketOwnershipControls(deleteBucketOwnershipControlsRequest))

  def deleteBucketPolicy(
    deleteBucketPolicyRequest: DeleteBucketPolicyRequest
  ): S3IO[DeleteBucketPolicyResponse] =
    FF.liftF(DeleteBucketPolicy(deleteBucketPolicyRequest))

  def deleteBucketReplication(
    deleteBucketReplicationRequest: DeleteBucketReplicationRequest
  ): S3IO[DeleteBucketReplicationResponse] =
    FF.liftF(DeleteBucketReplication(deleteBucketReplicationRequest))

  def deleteBucketTagging(
    deleteBucketTaggingRequest: DeleteBucketTaggingRequest
  ): S3IO[DeleteBucketTaggingResponse] =
    FF.liftF(DeleteBucketTagging(deleteBucketTaggingRequest))

  def deleteBucketWebsite(
    deleteBucketWebsiteRequest: DeleteBucketWebsiteRequest
  ): S3IO[DeleteBucketWebsiteResponse] =
    FF.liftF(DeleteBucketWebsite(deleteBucketWebsiteRequest))

  def deleteObject(
    deleteObjectRequest: DeleteObjectRequest
  ): S3IO[DeleteObjectResponse] =
    FF.liftF(DeleteObject(deleteObjectRequest))

  def deleteObjectTagging(
    deleteObjectTaggingRequest: DeleteObjectTaggingRequest
  ): S3IO[DeleteObjectTaggingResponse] =
    FF.liftF(DeleteObjectTagging(deleteObjectTaggingRequest))

  def deleteObjects(
    deleteObjectsRequest: DeleteObjectsRequest
  ): S3IO[DeleteObjectsResponse] =
    FF.liftF(DeleteObjects(deleteObjectsRequest))

  def deletePublicAccessBlock(
    deletePublicAccessBlockRequest: DeletePublicAccessBlockRequest
  ): S3IO[DeletePublicAccessBlockResponse] =
    FF.liftF(DeletePublicAccessBlock(deletePublicAccessBlockRequest))

  def getBucketAccelerateConfiguration(
    getBucketAccelerateConfigurationRequest: GetBucketAccelerateConfigurationRequest
  ): S3IO[GetBucketAccelerateConfigurationResponse] =
    FF.liftF(GetBucketAccelerateConfiguration(getBucketAccelerateConfigurationRequest))

  def getBucketAcl(
    getBucketAclRequest: GetBucketAclRequest
  ): S3IO[GetBucketAclResponse] =
    FF.liftF(GetBucketAcl(getBucketAclRequest))

  def getBucketAnalyticsConfiguration(
    getBucketAnalyticsConfigurationRequest: GetBucketAnalyticsConfigurationRequest
  ): S3IO[GetBucketAnalyticsConfigurationResponse] =
    FF.liftF(GetBucketAnalyticsConfiguration(getBucketAnalyticsConfigurationRequest))

  def getBucketCors(
    getBucketCorsRequest: GetBucketCorsRequest
  ): S3IO[GetBucketCorsResponse] =
    FF.liftF(GetBucketCors(getBucketCorsRequest))

  def getBucketEncryption(
    getBucketEncryptionRequest: GetBucketEncryptionRequest
  ): S3IO[GetBucketEncryptionResponse] =
    FF.liftF(GetBucketEncryption(getBucketEncryptionRequest))

  def getBucketIntelligentTieringConfiguration(
    getBucketIntelligentTieringConfigurationRequest: GetBucketIntelligentTieringConfigurationRequest
  ): S3IO[GetBucketIntelligentTieringConfigurationResponse] =
    FF.liftF(GetBucketIntelligentTieringConfiguration(getBucketIntelligentTieringConfigurationRequest))

  def getBucketInventoryConfiguration(
    getBucketInventoryConfigurationRequest: GetBucketInventoryConfigurationRequest
  ): S3IO[GetBucketInventoryConfigurationResponse] =
    FF.liftF(GetBucketInventoryConfiguration(getBucketInventoryConfigurationRequest))

  def getBucketLifecycleConfiguration(
    getBucketLifecycleConfigurationRequest: GetBucketLifecycleConfigurationRequest
  ): S3IO[GetBucketLifecycleConfigurationResponse] =
    FF.liftF(GetBucketLifecycleConfiguration(getBucketLifecycleConfigurationRequest))

  def getBucketLocation(
    getBucketLocationRequest: GetBucketLocationRequest
  ): S3IO[GetBucketLocationResponse] =
    FF.liftF(GetBucketLocation(getBucketLocationRequest))

  def getBucketLogging(
    getBucketLoggingRequest: GetBucketLoggingRequest
  ): S3IO[GetBucketLoggingResponse] =
    FF.liftF(GetBucketLogging(getBucketLoggingRequest))

  def getBucketMetricsConfiguration(
    getBucketMetricsConfigurationRequest: GetBucketMetricsConfigurationRequest
  ): S3IO[GetBucketMetricsConfigurationResponse] =
    FF.liftF(GetBucketMetricsConfiguration(getBucketMetricsConfigurationRequest))

  def getBucketNotificationConfiguration(
    getBucketNotificationConfigurationRequest: GetBucketNotificationConfigurationRequest
  ): S3IO[GetBucketNotificationConfigurationResponse] =
    FF.liftF(GetBucketNotificationConfiguration(getBucketNotificationConfigurationRequest))

  def getBucketOwnershipControls(
    getBucketOwnershipControlsRequest: GetBucketOwnershipControlsRequest
  ): S3IO[GetBucketOwnershipControlsResponse] =
    FF.liftF(GetBucketOwnershipControls(getBucketOwnershipControlsRequest))

  def getBucketPolicy(
    getBucketPolicyRequest: GetBucketPolicyRequest
  ): S3IO[GetBucketPolicyResponse] =
    FF.liftF(GetBucketPolicy(getBucketPolicyRequest))

  def getBucketPolicyStatus(
    getBucketPolicyStatusRequest: GetBucketPolicyStatusRequest
  ): S3IO[GetBucketPolicyStatusResponse] =
    FF.liftF(GetBucketPolicyStatus(getBucketPolicyStatusRequest))

  def getBucketReplication(
    getBucketReplicationRequest: GetBucketReplicationRequest
  ): S3IO[GetBucketReplicationResponse] =
    FF.liftF(GetBucketReplication(getBucketReplicationRequest))

  def getBucketRequestPayment(
    getBucketRequestPaymentRequest: GetBucketRequestPaymentRequest
  ): S3IO[GetBucketRequestPaymentResponse] =
    FF.liftF(GetBucketRequestPayment(getBucketRequestPaymentRequest))

  def getBucketTagging(
    getBucketTaggingRequest: GetBucketTaggingRequest
  ): S3IO[GetBucketTaggingResponse] =
    FF.liftF(GetBucketTagging(getBucketTaggingRequest))

  def getBucketVersioning(
    getBucketVersioningRequest: GetBucketVersioningRequest
  ): S3IO[GetBucketVersioningResponse] =
    FF.liftF(GetBucketVersioning(getBucketVersioningRequest))

  def getBucketWebsite(
    getBucketWebsiteRequest: GetBucketWebsiteRequest
  ): S3IO[GetBucketWebsiteResponse] =
    FF.liftF(GetBucketWebsite(getBucketWebsiteRequest))

  def getObject(
    getObjectRequest: GetObjectRequest,
    destinationPath: Path
  ): S3IO[GetObjectResponse] =
    FF.liftF(GetObject(getObjectRequest, destinationPath))

  def getObjectAcl(
    getObjectAclRequest: GetObjectAclRequest
  ): S3IO[GetObjectAclResponse] =
    FF.liftF(GetObjectAcl(getObjectAclRequest))

  def getObjectLegalHold(
    getObjectLegalHoldRequest: GetObjectLegalHoldRequest
  ): S3IO[GetObjectLegalHoldResponse] =
    FF.liftF(GetObjectLegalHold(getObjectLegalHoldRequest))

  def getObjectLockConfiguration(
    getObjectLockConfigurationRequest: GetObjectLockConfigurationRequest
  ): S3IO[GetObjectLockConfigurationResponse] =
    FF.liftF(GetObjectLockConfiguration(getObjectLockConfigurationRequest))

  def getObjectRetention(
    getObjectRetentionRequest: GetObjectRetentionRequest
  ): S3IO[GetObjectRetentionResponse] =
    FF.liftF(GetObjectRetention(getObjectRetentionRequest))

  def getObjectTagging(
    getObjectTaggingRequest: GetObjectTaggingRequest
  ): S3IO[GetObjectTaggingResponse] =
    FF.liftF(GetObjectTagging(getObjectTaggingRequest))

  def getPublicAccessBlock(
    getPublicAccessBlockRequest: GetPublicAccessBlockRequest
  ): S3IO[GetPublicAccessBlockResponse] =
    FF.liftF(GetPublicAccessBlock(getPublicAccessBlockRequest))

  def headBucket(
    headBucketRequest: HeadBucketRequest
  ): S3IO[HeadBucketResponse] =
    FF.liftF(HeadBucket(headBucketRequest))

  def headObject(
    headObjectRequest: HeadObjectRequest
  ): S3IO[HeadObjectResponse] =
    FF.liftF(HeadObject(headObjectRequest))

  def listBucketAnalyticsConfigurations(
    listBucketAnalyticsConfigurationsRequest: ListBucketAnalyticsConfigurationsRequest
  ): S3IO[ListBucketAnalyticsConfigurationsResponse] =
    FF.liftF(ListBucketAnalyticsConfigurations(listBucketAnalyticsConfigurationsRequest))

  def listBucketIntelligentTieringConfigurations(
    listBucketIntelligentTieringConfigurationsRequest: ListBucketIntelligentTieringConfigurationsRequest
  ): S3IO[ListBucketIntelligentTieringConfigurationsResponse] =
    FF.liftF(ListBucketIntelligentTieringConfigurations(listBucketIntelligentTieringConfigurationsRequest))

  def listBucketInventoryConfigurations(
    listBucketInventoryConfigurationsRequest: ListBucketInventoryConfigurationsRequest
  ): S3IO[ListBucketInventoryConfigurationsResponse] =
    FF.liftF(ListBucketInventoryConfigurations(listBucketInventoryConfigurationsRequest))

  def listBucketMetricsConfigurations(
    listBucketMetricsConfigurationsRequest: ListBucketMetricsConfigurationsRequest
  ): S3IO[ListBucketMetricsConfigurationsResponse] =
    FF.liftF(ListBucketMetricsConfigurations(listBucketMetricsConfigurationsRequest))

  def listBuckets(
    listBucketsRequest: ListBucketsRequest
  ): S3IO[ListBucketsResponse] =
    FF.liftF(ListBuckets(listBucketsRequest))

  def listMultipartUploads(
    listMultipartUploadsRequest: ListMultipartUploadsRequest
  ): S3IO[ListMultipartUploadsResponse] =
    FF.liftF(ListMultipartUploads(listMultipartUploadsRequest))

  def listObjectVersions(
    listObjectVersionsRequest: ListObjectVersionsRequest
  ): S3IO[ListObjectVersionsResponse] =
    FF.liftF(ListObjectVersions(listObjectVersionsRequest))

  def listObjects(
    listObjectsRequest: ListObjectsRequest
  ): S3IO[ListObjectsResponse] =
    FF.liftF(ListObjects(listObjectsRequest))

  def listObjectsV2(
    listObjectsV2Request: ListObjectsV2Request
  ): S3IO[ListObjectsV2Response] =
    FF.liftF(ListObjectsV2(listObjectsV2Request))

  def listParts(
    listPartsRequest: ListPartsRequest
  ): S3IO[ListPartsResponse] =
    FF.liftF(ListParts(listPartsRequest))

  def putBucketAccelerateConfiguration(
    putBucketAccelerateConfigurationRequest: PutBucketAccelerateConfigurationRequest
  ): S3IO[PutBucketAccelerateConfigurationResponse] =
    FF.liftF(PutBucketAccelerateConfiguration(putBucketAccelerateConfigurationRequest))

  def putBucketAcl(
    putBucketAclRequest: PutBucketAclRequest
  ): S3IO[PutBucketAclResponse] =
    FF.liftF(PutBucketAcl(putBucketAclRequest))

  def putBucketAnalyticsConfiguration(
    putBucketAnalyticsConfigurationRequest: PutBucketAnalyticsConfigurationRequest
  ): S3IO[PutBucketAnalyticsConfigurationResponse] =
    FF.liftF(PutBucketAnalyticsConfiguration(putBucketAnalyticsConfigurationRequest))

  def putBucketCors(
    putBucketCorsRequest: PutBucketCorsRequest
  ): S3IO[PutBucketCorsResponse] =
    FF.liftF(PutBucketCors(putBucketCorsRequest))

  def putBucketEncryption(
    putBucketEncryptionRequest: PutBucketEncryptionRequest
  ): S3IO[PutBucketEncryptionResponse] =
    FF.liftF(PutBucketEncryption(putBucketEncryptionRequest))

  def putBucketIntelligentTieringConfiguration(
    putBucketIntelligentTieringConfigurationRequest: PutBucketIntelligentTieringConfigurationRequest
  ): S3IO[PutBucketIntelligentTieringConfigurationResponse] =
    FF.liftF(PutBucketIntelligentTieringConfiguration(putBucketIntelligentTieringConfigurationRequest))

  def putBucketInventoryConfiguration(
    putBucketInventoryConfigurationRequest: PutBucketInventoryConfigurationRequest
  ): S3IO[PutBucketInventoryConfigurationResponse] =
    FF.liftF(PutBucketInventoryConfiguration(putBucketInventoryConfigurationRequest))

  def putBucketLifecycleConfiguration(
    putBucketLifecycleConfigurationRequest: PutBucketLifecycleConfigurationRequest
  ): S3IO[PutBucketLifecycleConfigurationResponse] =
    FF.liftF(PutBucketLifecycleConfiguration(putBucketLifecycleConfigurationRequest))

  def putBucketLogging(
    putBucketLoggingRequest: PutBucketLoggingRequest
  ): S3IO[PutBucketLoggingResponse] =
    FF.liftF(PutBucketLogging(putBucketLoggingRequest))

  def putBucketMetricsConfiguration(
    putBucketMetricsConfigurationRequest: PutBucketMetricsConfigurationRequest
  ): S3IO[PutBucketMetricsConfigurationResponse] =
    FF.liftF(PutBucketMetricsConfiguration(putBucketMetricsConfigurationRequest))

  def putBucketNotificationConfiguration(
    putBucketNotificationConfigurationRequest: PutBucketNotificationConfigurationRequest
  ): S3IO[PutBucketNotificationConfigurationResponse] =
    FF.liftF(PutBucketNotificationConfiguration(putBucketNotificationConfigurationRequest))

  def putBucketOwnershipControls(
    putBucketOwnershipControlsRequest: PutBucketOwnershipControlsRequest
  ): S3IO[PutBucketOwnershipControlsResponse] =
    FF.liftF(PutBucketOwnershipControls(putBucketOwnershipControlsRequest))

  def putBucketPolicy(
    putBucketPolicyRequest: PutBucketPolicyRequest
  ): S3IO[PutBucketPolicyResponse] =
    FF.liftF(PutBucketPolicy(putBucketPolicyRequest))

  def putBucketReplication(
    putBucketReplicationRequest: PutBucketReplicationRequest
  ): S3IO[PutBucketReplicationResponse] =
    FF.liftF(PutBucketReplication(putBucketReplicationRequest))

  def putBucketRequestPayment(
    putBucketRequestPaymentRequest: PutBucketRequestPaymentRequest
  ): S3IO[PutBucketRequestPaymentResponse] =
    FF.liftF(PutBucketRequestPayment(putBucketRequestPaymentRequest))

  def putBucketTagging(
    putBucketTaggingRequest: PutBucketTaggingRequest
  ): S3IO[PutBucketTaggingResponse] =
    FF.liftF(PutBucketTagging(putBucketTaggingRequest))

  def putBucketVersioning(
    putBucketVersioningRequest: PutBucketVersioningRequest
  ): S3IO[PutBucketVersioningResponse] =
    FF.liftF(PutBucketVersioning(putBucketVersioningRequest))

  def putBucketWebsite(
    putBucketWebsiteRequest: PutBucketWebsiteRequest
  ): S3IO[PutBucketWebsiteResponse] =
    FF.liftF(PutBucketWebsite(putBucketWebsiteRequest))

  def putObject(
    putObjectRequest: PutObjectRequest,
    requestBody: RequestBody
  ): S3IO[PutObjectResponse] =
    FF.liftF(PutObject(putObjectRequest, requestBody))

  def putObjectAcl(
    putObjectAclRequest: PutObjectAclRequest
  ): S3IO[PutObjectAclResponse] =
    FF.liftF(PutObjectAcl(putObjectAclRequest))

  def putObjectLegalHold (
    putObjectLegalHoldRequest: PutObjectLegalHoldRequest
  ): S3IO[PutObjectLegalHoldResponse] =
    FF.liftF(PutObjectLegalHold (putObjectLegalHoldRequest))

  def putObjectLockConfiguration(
    putObjectLockConfigurationRequest: PutObjectLockConfigurationRequest
  ): S3IO[PutObjectLockConfigurationResponse] =
    FF.liftF(PutObjectLockConfiguration(putObjectLockConfigurationRequest))

  def putObjectRetention(
    putObjectRetentionRequest: PutObjectRetentionRequest
  ): S3IO[PutObjectRetentionResponse] =
    FF.liftF(PutObjectRetention(putObjectRetentionRequest))

  def putObjectTagging(
    putObjectTaggingRequest: PutObjectTaggingRequest
  ): S3IO[PutObjectTaggingResponse] =
    FF.liftF(PutObjectTagging(putObjectTaggingRequest))

  def putPublicAccessBlock(
    putPublicAccessBlockRequest: PutPublicAccessBlockRequest
  ): S3IO[PutPublicAccessBlockResponse] =
    FF.liftF(PutPublicAccessBlock(putPublicAccessBlockRequest))

  def restoreObject(
    restoreObjectRequest: RestoreObjectRequest
  ): S3IO[RestoreObjectResponse] =
    FF.liftF(RestoreObject(restoreObjectRequest))

  def uploadPart(
    uploadPartRequest: UploadPartRequest,
    requestBody: RequestBody
  ): S3IO[UploadPartResponse] =
    FF.liftF(UploadPart(uploadPartRequest, requestBody))

  def uploadPartCopy(
    uploadPartCopyRequest: UploadPartCopyRequest
  ): S3IO[UploadPartCopyResponse] =
    FF.liftF(UploadPartCopy(uploadPartCopyRequest))

  def writeGetObjectResponse(
    writeGetObjectResponseRequest: WriteGetObjectResponseRequest,
    requestBody: RequestBody
  ): S3IO[WriteGetObjectResponseResponse] =
    FF.liftF(WriteGetObjectResponse(writeGetObjectResponseRequest, requestBody))
}

