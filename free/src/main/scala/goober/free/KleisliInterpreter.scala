package goober.free

import scala.language.higherKinds

import java.nio.file.Path
import java.util.concurrent.Executors
import cats.data.Kleisli
import cats.effect.{Async, Blocker, Bracket, ContextShift, Resource}
import cats.{Applicative, Defer, Endo, ~>}
import goober.free.s3.S3Op
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.model._
import software.amazon.awssdk.services.s3.{S3Client, S3ClientBuilder}

import scala.concurrent.ExecutionContext

object transactor {
  type Interpreter[M[_]] = S3Op ~> Kleisli[M, S3Client, *]

  object Transactor {
    def apply[M[_]](
      connect: Resource[M, S3Client],
      interpreter: Interpreter[M],
    ): Transactor[M] =
      new Transactor[M](connect, interpreter) {}

    // An unbounded cached pool of daemon threads.
    private lazy val defaultBlocker: Blocker = Blocker.liftExecutionContext {
      ExecutionContext.fromExecutor(Executors.newCachedThreadPool((r: Runnable) => {
        val th = new Thread(r)
        th.setName(s"goober-fromDriverManager-pool-${th.getId}")
        th.setDaemon(true)
        th
      }))
    }

    case class from[M[_]](
      optBlocker: Option[Blocker] = None,
      optInterpreterFn: Option[Blocker => Interpreter[M]] = None
    )(implicit
      async: Async[M],
      cs: ContextShift[M]
    ) {

      def builder(builder: () => S3ClientBuilder): Transactor[M] = client(
        connect = () => builder().build()
      )

      def client(connect: () => S3Client): Transactor[M] = resource(
        resource = Resource.make(blocker.blockOn(async.delay(connect())))(s3Client => {
          blocker.blockOn(async.delay(s3Client.close()))
        })
      )

      def resource(resource: Resource[M, S3Client]): Transactor[M] = Transactor(
        connect     = resource,
        interpreter = interpreter
      )

      private lazy val blocker: Blocker = optBlocker.getOrElse(defaultBlocker)

      private lazy val interpreter: Interpreter[M] = optInterpreterFn match {
        case None     => KleisliInterpreter[M](blocker).S3Interpreter
        case Some(fn) => fn(blocker)
      }
    }
  }

  sealed abstract class Transactor[M[_]](
    connect: Resource[M, S3Client],
    interpreter: Interpreter[M]
  ) {
    def rawExec(implicit ev: Bracket[M, Throwable]): Kleisli[M, S3Client, *] ~> M = new (Kleisli[M, S3Client, *] ~> M) {
      def apply[A](k: Kleisli[M, S3Client, A]): M[A] = connect.use(k.run)
    }

    def modify(
      connect: Endo[Resource[M, S3Client]] = identity,
      interpreter: Endo[Interpreter[M]] = identity
    ): Transactor[M] = copy(
      connect = connect(this.connect),
      interpreter = interpreter(this.interpreter)
    )

    def copy(
      connect: Resource[M, S3Client] = connect,
      interpreter: Interpreter[M] = interpreter
    ): Transactor[M] = Transactor(
      connect,
      interpreter
    )

    def mapK[M0[_]](fk: M ~> M0)(implicit D: Defer[M0], A: Applicative[M0]): Transactor[M0] = Transactor[M0](
      connect.mapK(fk),
      interpreter.andThen[Kleisli[M0, S3Client, *]](new (Kleisli[M, S3Client, *] ~> Kleisli[M0, S3Client, *]) {
        def apply[A](k: Kleisli[M, S3Client, A]): Kleisli[M0, S3Client, A] = k.mapK(fk)
      })
    )
  }
}

object KleisliInterpreter {
  def apply[M[_]](b: Blocker)(implicit
    am: Async[M],
    cs: ContextShift[M]
  ): KleisliInterpreter[M] = new KleisliInterpreter[M] {
    val asyncM = am
    val contextShiftM = cs
    val blocker = b
  }
}

trait KleisliInterpreter[M[_]] { interpreter =>
  lazy val S3Interpreter: S3Op ~> Kleisli[M, S3Client, *] = new S3Interpreter {}

  trait S3Interpreter extends S3Op.Visitor[Kleisli[M, S3Client, *]] {

    def embed[A](
      e: Embedded[A]
    ): Kleisli[M, S3Client, A] =
      interpreter.embed(e)

    def abortMultipartUpload(
      abortMultipartUploadRequest: AbortMultipartUploadRequest
    ): Kleisli[M, S3Client, AbortMultipartUploadResponse] =
      primitive(_.abortMultipartUpload(abortMultipartUploadRequest))

    def completeMultipartUpload(
      completeMultipartUploadRequest: CompleteMultipartUploadRequest
    ): Kleisli[M, S3Client, CompleteMultipartUploadResponse] =
      primitive(_.completeMultipartUpload(completeMultipartUploadRequest))

    def copyObject(
      copyObjectRequest: CopyObjectRequest
    ): Kleisli[M, S3Client, CopyObjectResponse] =
      primitive(_.copyObject(copyObjectRequest))

    def createBucket(
      createBucketRequest: CreateBucketRequest
    ): Kleisli[M, S3Client, CreateBucketResponse] =
      primitive(_.createBucket(createBucketRequest))

    def createMultipartUpload(
      createMultipartUploadRequest: CreateMultipartUploadRequest
    ): Kleisli[M, S3Client, CreateMultipartUploadResponse] =
      primitive(_.createMultipartUpload(createMultipartUploadRequest))

    def deleteBucket(
      deleteBucketRequest: DeleteBucketRequest
    ): Kleisli[M, S3Client, DeleteBucketResponse] =
      primitive(_.deleteBucket(deleteBucketRequest))

    def deleteBucketAnalyticsConfiguration(
      deleteBucketAnalyticsConfigurationRequest: DeleteBucketAnalyticsConfigurationRequest
    ): Kleisli[M, S3Client, DeleteBucketAnalyticsConfigurationResponse] =
      primitive(_.deleteBucketAnalyticsConfiguration(deleteBucketAnalyticsConfigurationRequest))

    def deleteBucketCors(
      deleteBucketCorsRequest: DeleteBucketCorsRequest
    ): Kleisli[M, S3Client, DeleteBucketCorsResponse] =
      primitive(_.deleteBucketCors(deleteBucketCorsRequest))

    def deleteBucketEncryption(
      deleteBucketEncryptionRequest: DeleteBucketEncryptionRequest
    ): Kleisli[M, S3Client, DeleteBucketEncryptionResponse] =
      primitive(_.deleteBucketEncryption(deleteBucketEncryptionRequest))

    def deleteBucketIntelligentTieringConfiguration(
      deleteBucketIntelligentTieringConfigurationRequest: DeleteBucketIntelligentTieringConfigurationRequest
    ): Kleisli[M, S3Client, DeleteBucketIntelligentTieringConfigurationResponse] =
      primitive(_.deleteBucketIntelligentTieringConfiguration(deleteBucketIntelligentTieringConfigurationRequest))

    def deleteBucketInventoryConfiguration(
      deleteBucketInventoryConfigurationRequest: DeleteBucketInventoryConfigurationRequest
    ): Kleisli[M, S3Client, DeleteBucketInventoryConfigurationResponse] =
      primitive(_.deleteBucketInventoryConfiguration(deleteBucketInventoryConfigurationRequest))

    def deleteBucketLifecycle(
      deleteBucketLifecycleRequest: DeleteBucketLifecycleRequest
    ): Kleisli[M, S3Client, DeleteBucketLifecycleResponse] =
      primitive(_.deleteBucketLifecycle(deleteBucketLifecycleRequest))

    def deleteBucketMetricsConfiguration(
      deleteBucketMetricsConfigurationRequest: DeleteBucketMetricsConfigurationRequest
    ): Kleisli[M, S3Client, DeleteBucketMetricsConfigurationResponse] =
      primitive(_.deleteBucketMetricsConfiguration(deleteBucketMetricsConfigurationRequest))

    def deleteBucketOwnershipControls(
      deleteBucketOwnershipControlsRequest: DeleteBucketOwnershipControlsRequest
    ): Kleisli[M, S3Client, DeleteBucketOwnershipControlsResponse] =
      primitive(_.deleteBucketOwnershipControls(deleteBucketOwnershipControlsRequest))

    def deleteBucketPolicy(
      deleteBucketPolicyRequest: DeleteBucketPolicyRequest
    ): Kleisli[M, S3Client, DeleteBucketPolicyResponse] =
      primitive(_.deleteBucketPolicy(deleteBucketPolicyRequest))

    def deleteBucketReplication(
      deleteBucketReplicationRequest: DeleteBucketReplicationRequest
    ): Kleisli[M, S3Client, DeleteBucketReplicationResponse] =
      primitive(_.deleteBucketReplication(deleteBucketReplicationRequest))

    def deleteBucketTagging(
      deleteBucketTaggingRequest: DeleteBucketTaggingRequest
    ): Kleisli[M, S3Client, DeleteBucketTaggingResponse] =
      primitive(_.deleteBucketTagging(deleteBucketTaggingRequest))

    def deleteBucketWebsite(
      deleteBucketWebsiteRequest: DeleteBucketWebsiteRequest
    ): Kleisli[M, S3Client, DeleteBucketWebsiteResponse] =
      primitive(_.deleteBucketWebsite(deleteBucketWebsiteRequest))

    def deleteObject(
      deleteObjectRequest: DeleteObjectRequest
    ): Kleisli[M, S3Client, DeleteObjectResponse] =
      primitive(_.deleteObject(deleteObjectRequest))

    def deleteObjectTagging(
      deleteObjectTaggingRequest: DeleteObjectTaggingRequest
    ): Kleisli[M, S3Client, DeleteObjectTaggingResponse] =
      primitive(_.deleteObjectTagging(deleteObjectTaggingRequest))

    def deleteObjects(
      deleteObjectsRequest: DeleteObjectsRequest
    ): Kleisli[M, S3Client, DeleteObjectsResponse] =
      primitive(_.deleteObjects(deleteObjectsRequest))

    def deletePublicAccessBlock(
      deletePublicAccessBlockRequest: DeletePublicAccessBlockRequest
    ): Kleisli[M, S3Client, DeletePublicAccessBlockResponse] =
      primitive(_.deletePublicAccessBlock(deletePublicAccessBlockRequest))


    def getBucketAccelerateConfiguration(
      getBucketAccelerateConfigurationRequest: GetBucketAccelerateConfigurationRequest
    ): Kleisli[M, S3Client, GetBucketAccelerateConfigurationResponse] =
      primitive(_.getBucketAccelerateConfiguration(getBucketAccelerateConfigurationRequest))

    def getBucketAcl(
      getBucketAclRequest: GetBucketAclRequest
    ): Kleisli[M, S3Client, GetBucketAclResponse] =
      primitive(_.getBucketAcl(getBucketAclRequest))

    def getBucketAnalyticsConfiguration(
      getBucketAnalyticsConfigurationRequest: GetBucketAnalyticsConfigurationRequest
    ): Kleisli[M, S3Client, GetBucketAnalyticsConfigurationResponse] =
      primitive(_.getBucketAnalyticsConfiguration(getBucketAnalyticsConfigurationRequest))

    def getBucketCors(
      getBucketCorsRequest: GetBucketCorsRequest
    ): Kleisli[M, S3Client, GetBucketCorsResponse] =
      primitive(_.getBucketCors(getBucketCorsRequest))

    def getBucketEncryption(
      getBucketEncryptionRequest: GetBucketEncryptionRequest
    ): Kleisli[M, S3Client, GetBucketEncryptionResponse] =
      primitive(_.getBucketEncryption(getBucketEncryptionRequest))

    def getBucketIntelligentTieringConfiguration(
      getBucketIntelligentTieringConfigurationRequest: GetBucketIntelligentTieringConfigurationRequest
    ): Kleisli[M, S3Client, GetBucketIntelligentTieringConfigurationResponse] =
      primitive(_.getBucketIntelligentTieringConfiguration(getBucketIntelligentTieringConfigurationRequest))

    def getBucketInventoryConfiguration(
      getBucketInventoryConfigurationRequest: GetBucketInventoryConfigurationRequest
    ): Kleisli[M, S3Client, GetBucketInventoryConfigurationResponse] =
      primitive(_.getBucketInventoryConfiguration(getBucketInventoryConfigurationRequest))

    def getBucketLifecycleConfiguration(
      getBucketLifecycleConfigurationRequest: GetBucketLifecycleConfigurationRequest
    ): Kleisli[M, S3Client, GetBucketLifecycleConfigurationResponse] =
      primitive(_.getBucketLifecycleConfiguration(getBucketLifecycleConfigurationRequest))

    def getBucketLocation(
      getBucketLocationRequest: GetBucketLocationRequest
    ): Kleisli[M, S3Client, GetBucketLocationResponse] =
      primitive(_.getBucketLocation(getBucketLocationRequest))

    def getBucketLogging(
      getBucketLoggingRequest: GetBucketLoggingRequest
    ): Kleisli[M, S3Client, GetBucketLoggingResponse] =
      primitive(_.getBucketLogging(getBucketLoggingRequest))

    def getBucketMetricsConfiguration(
      getBucketMetricsConfigurationRequest: GetBucketMetricsConfigurationRequest
    ): Kleisli[M, S3Client, GetBucketMetricsConfigurationResponse] =
      primitive(_.getBucketMetricsConfiguration(getBucketMetricsConfigurationRequest))

    def getBucketNotificationConfiguration(
      getBucketNotificationConfigurationRequest: GetBucketNotificationConfigurationRequest
    ): Kleisli[M, S3Client, GetBucketNotificationConfigurationResponse] =
      primitive(_.getBucketNotificationConfiguration(getBucketNotificationConfigurationRequest))

    def getBucketOwnershipControls(
      getBucketOwnershipControlsRequest: GetBucketOwnershipControlsRequest
    ): Kleisli[M, S3Client, GetBucketOwnershipControlsResponse] =
      primitive(_.getBucketOwnershipControls(getBucketOwnershipControlsRequest))

    def getBucketPolicy(
      getBucketPolicyRequest: GetBucketPolicyRequest
    ): Kleisli[M, S3Client, GetBucketPolicyResponse] =
      primitive(_.getBucketPolicy(getBucketPolicyRequest))

    def getBucketPolicyStatus(
      getBucketPolicyStatusRequest: GetBucketPolicyStatusRequest
    ): Kleisli[M, S3Client, GetBucketPolicyStatusResponse] =
      primitive(_.getBucketPolicyStatus(getBucketPolicyStatusRequest))

    def getBucketReplication(
      getBucketReplicationRequest: GetBucketReplicationRequest
    ): Kleisli[M, S3Client, GetBucketReplicationResponse] =
      primitive(_.getBucketReplication(getBucketReplicationRequest))

    def getBucketRequestPayment(
      getBucketRequestPaymentRequest: GetBucketRequestPaymentRequest
    ): Kleisli[M, S3Client, GetBucketRequestPaymentResponse] =
      primitive(_.getBucketRequestPayment(getBucketRequestPaymentRequest))

    def getBucketTagging(
      getBucketTaggingRequest: GetBucketTaggingRequest
    ): Kleisli[M, S3Client, GetBucketTaggingResponse] =
      primitive(_.getBucketTagging(getBucketTaggingRequest))

    def getBucketVersioning(
      getBucketVersioningRequest: GetBucketVersioningRequest
    ): Kleisli[M, S3Client, GetBucketVersioningResponse] =
      primitive(_.getBucketVersioning(getBucketVersioningRequest))

    def getBucketWebsite(
      getBucketWebsiteRequest: GetBucketWebsiteRequest
    ): Kleisli[M, S3Client, GetBucketWebsiteResponse] =
      primitive(_.getBucketWebsite(getBucketWebsiteRequest))

    def getObject(
      getObjectRequest: GetObjectRequest,
      destinationPath: Path
    ): Kleisli[M, S3Client, GetObjectResponse] =
      primitive(_.getObject(getObjectRequest, destinationPath))

    def getObjectAcl(
      getObjectAclRequest: GetObjectAclRequest
    ): Kleisli[M, S3Client, GetObjectAclResponse] =
      primitive(_.getObjectAcl(getObjectAclRequest))

    def getObjectLegalHold(
      getObjectLegalHoldRequest: GetObjectLegalHoldRequest
    ): Kleisli[M, S3Client, GetObjectLegalHoldResponse] =
      primitive(_.getObjectLegalHold(getObjectLegalHoldRequest))

    def getObjectLockConfiguration(
      getObjectLockConfigurationRequest: GetObjectLockConfigurationRequest
    ): Kleisli[M, S3Client, GetObjectLockConfigurationResponse] =
      primitive(_.getObjectLockConfiguration(getObjectLockConfigurationRequest))

    def getObjectRetention(
      getObjectRetentionRequest: GetObjectRetentionRequest
    ): Kleisli[M, S3Client, GetObjectRetentionResponse] =
      primitive(_.getObjectRetention(getObjectRetentionRequest))

    def getObjectTagging(
      getObjectTaggingRequest: GetObjectTaggingRequest
    ): Kleisli[M, S3Client, GetObjectTaggingResponse] =
      primitive(_.getObjectTagging(getObjectTaggingRequest))

    def getPublicAccessBlock(
      getPublicAccessBlockRequest: GetPublicAccessBlockRequest
    ): Kleisli[M, S3Client, GetPublicAccessBlockResponse] =
      primitive(_.getPublicAccessBlock(getPublicAccessBlockRequest))

    def headBucket(
      headBucketRequest: HeadBucketRequest
    ): Kleisli[M, S3Client, HeadBucketResponse] =
      primitive(_.headBucket(headBucketRequest))

    def headObject(
      headObjectRequest: HeadObjectRequest
    ): Kleisli[M, S3Client, HeadObjectResponse] =
      primitive(_.headObject(headObjectRequest))

    def listBuckets(
      listBucketsRequest: ListBucketsRequest
    ): Kleisli[M, S3Client, ListBucketsResponse] =
      primitive(_.listBuckets(listBucketsRequest))

    def listBucketAnalyticsConfigurations(
      listBucketAnalyticsConfigurationsRequest: ListBucketAnalyticsConfigurationsRequest
    ): Kleisli[M, S3Client, ListBucketAnalyticsConfigurationsResponse] =
      primitive(_.listBucketAnalyticsConfigurations(listBucketAnalyticsConfigurationsRequest))

    def listBucketIntelligentTieringConfigurations(
      listBucketIntelligentTieringConfigurationsRequest: ListBucketIntelligentTieringConfigurationsRequest
    ): Kleisli[M, S3Client, ListBucketIntelligentTieringConfigurationsResponse] =
      primitive(_.listBucketIntelligentTieringConfigurations(listBucketIntelligentTieringConfigurationsRequest))

    def listBucketInventoryConfigurations(
      listBucketInventoryConfigurationsRequest: ListBucketInventoryConfigurationsRequest
    ): Kleisli[M, S3Client, ListBucketInventoryConfigurationsResponse] =
      primitive(_.listBucketInventoryConfigurations(listBucketInventoryConfigurationsRequest))

    def listBucketMetricsConfigurations(
      listBucketMetricsConfigurationsRequest: ListBucketMetricsConfigurationsRequest
    ): Kleisli[M, S3Client, ListBucketMetricsConfigurationsResponse] =
      primitive(_.listBucketMetricsConfigurations(listBucketMetricsConfigurationsRequest))

    def listMultipartUploads(
      listMultipartUploadsRequest: ListMultipartUploadsRequest
    ): Kleisli[M, S3Client, ListMultipartUploadsResponse] =
      primitive(_.listMultipartUploads(listMultipartUploadsRequest))

    def listObjectVersions(
      listObjectVersionsRequest: ListObjectVersionsRequest
    ): Kleisli[M, S3Client, ListObjectVersionsResponse] =
      primitive(_.listObjectVersions(listObjectVersionsRequest))

    def listObjects(
      listObjectsRequest: ListObjectsRequest
    ): Kleisli[M, S3Client, ListObjectsResponse] =
      primitive(_.listObjects(listObjectsRequest))

    def listObjectsV2(
      listObjectsV2Request: ListObjectsV2Request
    ): Kleisli[M, S3Client, ListObjectsV2Response] =
      primitive(_.listObjectsV2(listObjectsV2Request))

    def listParts(
      listPartsRequest: ListPartsRequest
    ): Kleisli[M, S3Client, ListPartsResponse] =
      primitive(_.listParts(listPartsRequest))

    def putBucketAccelerateConfiguration(
      putBucketAccelerateConfigurationRequest: PutBucketAccelerateConfigurationRequest
    ): Kleisli[M, S3Client, PutBucketAccelerateConfigurationResponse] =
      primitive(_.putBucketAccelerateConfiguration(putBucketAccelerateConfigurationRequest))

    def putBucketAcl(
      putBucketAclRequest: PutBucketAclRequest
    ): Kleisli[M, S3Client, PutBucketAclResponse] =
      primitive(_.putBucketAcl(putBucketAclRequest))

    def putBucketAnalyticsConfiguration(
      putBucketAnalyticsConfigurationRequest: PutBucketAnalyticsConfigurationRequest
    ): Kleisli[M, S3Client, PutBucketAnalyticsConfigurationResponse] =
      primitive(_.putBucketAnalyticsConfiguration(putBucketAnalyticsConfigurationRequest))

    def putBucketCors(
      putBucketCorsRequest: PutBucketCorsRequest
    ): Kleisli[M, S3Client, PutBucketCorsResponse] =
      primitive(_.putBucketCors(putBucketCorsRequest))

    def putBucketEncryption(
      putBucketEncryptionRequest: PutBucketEncryptionRequest
    ): Kleisli[M, S3Client, PutBucketEncryptionResponse] =
      primitive(_.putBucketEncryption(putBucketEncryptionRequest))

    def putBucketIntelligentTieringConfiguration(
      putBucketIntelligentTieringConfigurationRequest: PutBucketIntelligentTieringConfigurationRequest
    ): Kleisli[M, S3Client, PutBucketIntelligentTieringConfigurationResponse] =
      primitive(_.putBucketIntelligentTieringConfiguration(putBucketIntelligentTieringConfigurationRequest))

    def putBucketInventoryConfiguration(
      putBucketInventoryConfigurationRequest: PutBucketInventoryConfigurationRequest
    ): Kleisli[M, S3Client, PutBucketInventoryConfigurationResponse] =
      primitive(_.putBucketInventoryConfiguration(putBucketInventoryConfigurationRequest))

    def putBucketLifecycleConfiguration(
      putBucketLifecycleConfigurationRequest: PutBucketLifecycleConfigurationRequest
    ): Kleisli[M, S3Client, PutBucketLifecycleConfigurationResponse] =
      primitive(_.putBucketLifecycleConfiguration(putBucketLifecycleConfigurationRequest))

    def putBucketLogging(
      putBucketLoggingRequest: PutBucketLoggingRequest
    ): Kleisli[M, S3Client, PutBucketLoggingResponse] =
      primitive(_.putBucketLogging(putBucketLoggingRequest))

    def putBucketMetricsConfiguration(
      putBucketMetricsConfigurationRequest: PutBucketMetricsConfigurationRequest
    ): Kleisli[M, S3Client, PutBucketMetricsConfigurationResponse] =
      primitive(_.putBucketMetricsConfiguration(putBucketMetricsConfigurationRequest))

    def putBucketNotificationConfiguration(
      putBucketNotificationConfigurationRequest: PutBucketNotificationConfigurationRequest
    ): Kleisli[M, S3Client, PutBucketNotificationConfigurationResponse] =
      primitive(_.putBucketNotificationConfiguration(putBucketNotificationConfigurationRequest))

    def putBucketOwnershipControls(
      putBucketOwnershipControlsRequest: PutBucketOwnershipControlsRequest
    ): Kleisli[M, S3Client, PutBucketOwnershipControlsResponse] =
      primitive(_.putBucketOwnershipControls(putBucketOwnershipControlsRequest))

    def putBucketPolicy(
      putBucketPolicyRequest: PutBucketPolicyRequest
    ): Kleisli[M, S3Client, PutBucketPolicyResponse] =
      primitive(_.putBucketPolicy(putBucketPolicyRequest))

    def putBucketReplication(
      putBucketReplicationRequest: PutBucketReplicationRequest
    ): Kleisli[M, S3Client, PutBucketReplicationResponse] =
      primitive(_.putBucketReplication(putBucketReplicationRequest))

    def putBucketRequestPayment(
      putBucketRequestPaymentRequest: PutBucketRequestPaymentRequest
    ): Kleisli[M, S3Client, PutBucketRequestPaymentResponse] =
      primitive(_.putBucketRequestPayment(putBucketRequestPaymentRequest))

    def putBucketTagging(
      putBucketTaggingRequest: PutBucketTaggingRequest
    ): Kleisli[M, S3Client, PutBucketTaggingResponse] =
      primitive(_.putBucketTagging(putBucketTaggingRequest))

    def putBucketVersioning(
      putBucketVersioningRequest: PutBucketVersioningRequest
    ): Kleisli[M, S3Client, PutBucketVersioningResponse] =
      primitive(_.putBucketVersioning(putBucketVersioningRequest))

    def putBucketWebsite(
      putBucketWebsiteRequest: PutBucketWebsiteRequest
    ): Kleisli[M, S3Client, PutBucketWebsiteResponse] =
      primitive(_.putBucketWebsite(putBucketWebsiteRequest))

    def putObject(
      putObjectRequest: PutObjectRequest,
      requestBody: RequestBody
    ): Kleisli[M, S3Client, PutObjectResponse] =
      primitive(_.putObject(putObjectRequest, requestBody))

    def putObjectAcl(
      putObjectAclRequest: PutObjectAclRequest
    ): Kleisli[M, S3Client, PutObjectAclResponse] =
      primitive(_.putObjectAcl(putObjectAclRequest))

    def putObjectLegalHold(
      putObjectLegalHoldRequest: PutObjectLegalHoldRequest
    ): Kleisli[M, S3Client, PutObjectLegalHoldResponse] =
      primitive(_.putObjectLegalHold(putObjectLegalHoldRequest))

    def putObjectLockConfiguration(
      putObjectLockConfigurationRequest: PutObjectLockConfigurationRequest
    ): Kleisli[M, S3Client, PutObjectLockConfigurationResponse] =
      primitive(_.putObjectLockConfiguration(putObjectLockConfigurationRequest))

    def putObjectRetention(
      putObjectRetentionRequest: PutObjectRetentionRequest
    ): Kleisli[M, S3Client, PutObjectRetentionResponse] =
      primitive(_.putObjectRetention(putObjectRetentionRequest))

    def putObjectTagging(
      putObjectTaggingRequest: PutObjectTaggingRequest
    ): Kleisli[M, S3Client, PutObjectTaggingResponse] =
      primitive(_.putObjectTagging(putObjectTaggingRequest))

    def putPublicAccessBlock(
      putPublicAccessBlockRequest: PutPublicAccessBlockRequest
    ): Kleisli[M, S3Client, PutPublicAccessBlockResponse] =
      primitive(_.putPublicAccessBlock(putPublicAccessBlockRequest))

    def restoreObject(
      restoreObjectRequest: RestoreObjectRequest
    ): Kleisli[M, S3Client, RestoreObjectResponse] =
      primitive(_.restoreObject(restoreObjectRequest))

    def uploadPart(
      uploadPartRequest: UploadPartRequest,
      requestBody: RequestBody
    ): Kleisli[M, S3Client, UploadPartResponse] =
      primitive(_.uploadPart(uploadPartRequest, requestBody))

    def uploadPartCopy(
      uploadPartCopyRequest: UploadPartCopyRequest
    ): Kleisli[M, S3Client, UploadPartCopyResponse] =
      primitive(_.uploadPartCopy(uploadPartCopyRequest))

    def writeGetObjectResponse(
      writeGetObjectResponseRequest: WriteGetObjectResponseRequest,
      requestBody: RequestBody
    ): Kleisli[M, S3Client, WriteGetObjectResponseResponse] =
      primitive(_.writeGetObjectResponse(writeGetObjectResponseRequest, requestBody))
  }

  def primitive[J, A](f: J => A): Kleisli[M, J, A] = Kleisli(a => {
    // primitive AWS methods throw exceptions and so do we when reading values
    // so catch any non-fatal exceptions and lift them into the effect
    blocker.blockOn[M, A](try {
      asyncM.delay(f(a))
    } catch {
      case scala.util.control.NonFatal(e) => asyncM.raiseError(e)
    })(contextShiftM)
  })

  def embed[J, A](e: Embedded[A]): Kleisli[M, J, A] = e match {
    case Embedded.S3(s3Client, s3IO) => Kleisli(_ => s3IO.foldMap[Kleisli[M, S3Client, *]](S3Interpreter).run(s3Client))
  }

  val blocker: Blocker
  implicit val asyncM: Async[M]
  val contextShiftM: ContextShift[M]
}
