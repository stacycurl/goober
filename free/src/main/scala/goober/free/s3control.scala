package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.s3control.S3ControlClient
import software.amazon.awssdk.services.s3control.model._


object s3control { module =>

  // Free monad over S3ControlOp
  type S3ControlIO[A] = FF[S3ControlOp, A]

  sealed trait S3ControlOp[A] {
    def visit[F[_]](visitor: S3ControlOp.Visitor[F]): F[A]
  }

  object S3ControlOp {
    // Given a S3ControlClient we can embed a S3ControlIO program in any algebra that understands embedding.
    implicit val S3ControlOpEmbeddable: Embeddable[S3ControlOp, S3ControlClient] = new Embeddable[S3ControlOp, S3ControlClient] {
      def embed[A](client: S3ControlClient, io: S3ControlIO[A]): Embedded[A] = Embedded.S3Control(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends S3ControlOp.Visitor[Kleisli[M, S3ControlClient, *]] {
        def createAccessPoint(
          request: CreateAccessPointRequest
        ): Kleisli[M, S3ControlClient, CreateAccessPointResponse] =
          primitive(_.createAccessPoint(request))

        def createAccessPointForObjectLambda(
          request: CreateAccessPointForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, CreateAccessPointForObjectLambdaResponse] =
          primitive(_.createAccessPointForObjectLambda(request))

        def createBucket(
          request: CreateBucketRequest
        ): Kleisli[M, S3ControlClient, CreateBucketResponse] =
          primitive(_.createBucket(request))

        def createJob(
          request: CreateJobRequest
        ): Kleisli[M, S3ControlClient, CreateJobResponse] =
          primitive(_.createJob(request))

        def deleteAccessPoint(
          request: DeleteAccessPointRequest
        ): Kleisli[M, S3ControlClient, DeleteAccessPointResponse] =
          primitive(_.deleteAccessPoint(request))

        def deleteAccessPointForObjectLambda(
          request: DeleteAccessPointForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, DeleteAccessPointForObjectLambdaResponse] =
          primitive(_.deleteAccessPointForObjectLambda(request))

        def deleteAccessPointPolicy(
          request: DeleteAccessPointPolicyRequest
        ): Kleisli[M, S3ControlClient, DeleteAccessPointPolicyResponse] =
          primitive(_.deleteAccessPointPolicy(request))

        def deleteAccessPointPolicyForObjectLambda(
          request: DeleteAccessPointPolicyForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, DeleteAccessPointPolicyForObjectLambdaResponse] =
          primitive(_.deleteAccessPointPolicyForObjectLambda(request))

        def deleteBucket(
          request: DeleteBucketRequest
        ): Kleisli[M, S3ControlClient, DeleteBucketResponse] =
          primitive(_.deleteBucket(request))

        def deleteBucketLifecycleConfiguration(
          request: DeleteBucketLifecycleConfigurationRequest
        ): Kleisli[M, S3ControlClient, DeleteBucketLifecycleConfigurationResponse] =
          primitive(_.deleteBucketLifecycleConfiguration(request))

        def deleteBucketPolicy(
          request: DeleteBucketPolicyRequest
        ): Kleisli[M, S3ControlClient, DeleteBucketPolicyResponse] =
          primitive(_.deleteBucketPolicy(request))

        def deleteBucketTagging(
          request: DeleteBucketTaggingRequest
        ): Kleisli[M, S3ControlClient, DeleteBucketTaggingResponse] =
          primitive(_.deleteBucketTagging(request))

        def deleteJobTagging(
          request: DeleteJobTaggingRequest
        ): Kleisli[M, S3ControlClient, DeleteJobTaggingResponse] =
          primitive(_.deleteJobTagging(request))

        def deletePublicAccessBlock(
          request: DeletePublicAccessBlockRequest
        ): Kleisli[M, S3ControlClient, DeletePublicAccessBlockResponse] =
          primitive(_.deletePublicAccessBlock(request))

        def deleteStorageLensConfiguration(
          request: DeleteStorageLensConfigurationRequest
        ): Kleisli[M, S3ControlClient, DeleteStorageLensConfigurationResponse] =
          primitive(_.deleteStorageLensConfiguration(request))

        def deleteStorageLensConfigurationTagging(
          request: DeleteStorageLensConfigurationTaggingRequest
        ): Kleisli[M, S3ControlClient, DeleteStorageLensConfigurationTaggingResponse] =
          primitive(_.deleteStorageLensConfigurationTagging(request))

        def describeJob(
          request: DescribeJobRequest
        ): Kleisli[M, S3ControlClient, DescribeJobResponse] =
          primitive(_.describeJob(request))

        def getAccessPoint(
          request: GetAccessPointRequest
        ): Kleisli[M, S3ControlClient, GetAccessPointResponse] =
          primitive(_.getAccessPoint(request))

        def getAccessPointConfigurationForObjectLambda(
          request: GetAccessPointConfigurationForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, GetAccessPointConfigurationForObjectLambdaResponse] =
          primitive(_.getAccessPointConfigurationForObjectLambda(request))

        def getAccessPointForObjectLambda(
          request: GetAccessPointForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, GetAccessPointForObjectLambdaResponse] =
          primitive(_.getAccessPointForObjectLambda(request))

        def getAccessPointPolicy(
          request: GetAccessPointPolicyRequest
        ): Kleisli[M, S3ControlClient, GetAccessPointPolicyResponse] =
          primitive(_.getAccessPointPolicy(request))

        def getAccessPointPolicyForObjectLambda(
          request: GetAccessPointPolicyForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, GetAccessPointPolicyForObjectLambdaResponse] =
          primitive(_.getAccessPointPolicyForObjectLambda(request))

        def getAccessPointPolicyStatus(
          request: GetAccessPointPolicyStatusRequest
        ): Kleisli[M, S3ControlClient, GetAccessPointPolicyStatusResponse] =
          primitive(_.getAccessPointPolicyStatus(request))

        def getAccessPointPolicyStatusForObjectLambda(
          request: GetAccessPointPolicyStatusForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, GetAccessPointPolicyStatusForObjectLambdaResponse] =
          primitive(_.getAccessPointPolicyStatusForObjectLambda(request))

        def getBucket(
          request: GetBucketRequest
        ): Kleisli[M, S3ControlClient, GetBucketResponse] =
          primitive(_.getBucket(request))

        def getBucketLifecycleConfiguration(
          request: GetBucketLifecycleConfigurationRequest
        ): Kleisli[M, S3ControlClient, GetBucketLifecycleConfigurationResponse] =
          primitive(_.getBucketLifecycleConfiguration(request))

        def getBucketPolicy(
          request: GetBucketPolicyRequest
        ): Kleisli[M, S3ControlClient, GetBucketPolicyResponse] =
          primitive(_.getBucketPolicy(request))

        def getBucketTagging(
          request: GetBucketTaggingRequest
        ): Kleisli[M, S3ControlClient, GetBucketTaggingResponse] =
          primitive(_.getBucketTagging(request))

        def getJobTagging(
          request: GetJobTaggingRequest
        ): Kleisli[M, S3ControlClient, GetJobTaggingResponse] =
          primitive(_.getJobTagging(request))

        def getPublicAccessBlock(
          request: GetPublicAccessBlockRequest
        ): Kleisli[M, S3ControlClient, GetPublicAccessBlockResponse] =
          primitive(_.getPublicAccessBlock(request))

        def getStorageLensConfiguration(
          request: GetStorageLensConfigurationRequest
        ): Kleisli[M, S3ControlClient, GetStorageLensConfigurationResponse] =
          primitive(_.getStorageLensConfiguration(request))

        def getStorageLensConfigurationTagging(
          request: GetStorageLensConfigurationTaggingRequest
        ): Kleisli[M, S3ControlClient, GetStorageLensConfigurationTaggingResponse] =
          primitive(_.getStorageLensConfigurationTagging(request))

        def listAccessPoints(
          request: ListAccessPointsRequest
        ): Kleisli[M, S3ControlClient, ListAccessPointsResponse] =
          primitive(_.listAccessPoints(request))

        def listAccessPointsForObjectLambda(
          request: ListAccessPointsForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, ListAccessPointsForObjectLambdaResponse] =
          primitive(_.listAccessPointsForObjectLambda(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, S3ControlClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listRegionalBuckets(
          request: ListRegionalBucketsRequest
        ): Kleisli[M, S3ControlClient, ListRegionalBucketsResponse] =
          primitive(_.listRegionalBuckets(request))

        def listStorageLensConfigurations(
          request: ListStorageLensConfigurationsRequest
        ): Kleisli[M, S3ControlClient, ListStorageLensConfigurationsResponse] =
          primitive(_.listStorageLensConfigurations(request))

        def putAccessPointConfigurationForObjectLambda(
          request: PutAccessPointConfigurationForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, PutAccessPointConfigurationForObjectLambdaResponse] =
          primitive(_.putAccessPointConfigurationForObjectLambda(request))

        def putAccessPointPolicy(
          request: PutAccessPointPolicyRequest
        ): Kleisli[M, S3ControlClient, PutAccessPointPolicyResponse] =
          primitive(_.putAccessPointPolicy(request))

        def putAccessPointPolicyForObjectLambda(
          request: PutAccessPointPolicyForObjectLambdaRequest
        ): Kleisli[M, S3ControlClient, PutAccessPointPolicyForObjectLambdaResponse] =
          primitive(_.putAccessPointPolicyForObjectLambda(request))

        def putBucketLifecycleConfiguration(
          request: PutBucketLifecycleConfigurationRequest
        ): Kleisli[M, S3ControlClient, PutBucketLifecycleConfigurationResponse] =
          primitive(_.putBucketLifecycleConfiguration(request))

        def putBucketPolicy(
          request: PutBucketPolicyRequest
        ): Kleisli[M, S3ControlClient, PutBucketPolicyResponse] =
          primitive(_.putBucketPolicy(request))

        def putBucketTagging(
          request: PutBucketTaggingRequest
        ): Kleisli[M, S3ControlClient, PutBucketTaggingResponse] =
          primitive(_.putBucketTagging(request))

        def putJobTagging(
          request: PutJobTaggingRequest
        ): Kleisli[M, S3ControlClient, PutJobTaggingResponse] =
          primitive(_.putJobTagging(request))

        def putPublicAccessBlock(
          request: PutPublicAccessBlockRequest
        ): Kleisli[M, S3ControlClient, PutPublicAccessBlockResponse] =
          primitive(_.putPublicAccessBlock(request))

        def putStorageLensConfiguration(
          request: PutStorageLensConfigurationRequest
        ): Kleisli[M, S3ControlClient, PutStorageLensConfigurationResponse] =
          primitive(_.putStorageLensConfiguration(request))

        def putStorageLensConfigurationTagging(
          request: PutStorageLensConfigurationTaggingRequest
        ): Kleisli[M, S3ControlClient, PutStorageLensConfigurationTaggingResponse] =
          primitive(_.putStorageLensConfigurationTagging(request))

        def updateJobPriority(
          request: UpdateJobPriorityRequest
        ): Kleisli[M, S3ControlClient, UpdateJobPriorityResponse] =
          primitive(_.updateJobPriority(request))

        def updateJobStatus(
          request: UpdateJobStatusRequest
        ): Kleisli[M, S3ControlClient, UpdateJobStatusResponse] =
          primitive(_.updateJobStatus(request))

        def primitive[A](
          f: S3ControlClient => A
        ): Kleisli[M, S3ControlClient, A]
      }
    }

    trait Visitor[F[_]] extends (S3ControlOp ~> F) {
      final def apply[A](op: S3ControlOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createAccessPoint(
        request: CreateAccessPointRequest
      ): F[CreateAccessPointResponse]

      def createAccessPointForObjectLambda(
        request: CreateAccessPointForObjectLambdaRequest
      ): F[CreateAccessPointForObjectLambdaResponse]

      def createBucket(
        request: CreateBucketRequest
      ): F[CreateBucketResponse]

      def createJob(
        request: CreateJobRequest
      ): F[CreateJobResponse]

      def deleteAccessPoint(
        request: DeleteAccessPointRequest
      ): F[DeleteAccessPointResponse]

      def deleteAccessPointForObjectLambda(
        request: DeleteAccessPointForObjectLambdaRequest
      ): F[DeleteAccessPointForObjectLambdaResponse]

      def deleteAccessPointPolicy(
        request: DeleteAccessPointPolicyRequest
      ): F[DeleteAccessPointPolicyResponse]

      def deleteAccessPointPolicyForObjectLambda(
        request: DeleteAccessPointPolicyForObjectLambdaRequest
      ): F[DeleteAccessPointPolicyForObjectLambdaResponse]

      def deleteBucket(
        request: DeleteBucketRequest
      ): F[DeleteBucketResponse]

      def deleteBucketLifecycleConfiguration(
        request: DeleteBucketLifecycleConfigurationRequest
      ): F[DeleteBucketLifecycleConfigurationResponse]

      def deleteBucketPolicy(
        request: DeleteBucketPolicyRequest
      ): F[DeleteBucketPolicyResponse]

      def deleteBucketTagging(
        request: DeleteBucketTaggingRequest
      ): F[DeleteBucketTaggingResponse]

      def deleteJobTagging(
        request: DeleteJobTaggingRequest
      ): F[DeleteJobTaggingResponse]

      def deletePublicAccessBlock(
        request: DeletePublicAccessBlockRequest
      ): F[DeletePublicAccessBlockResponse]

      def deleteStorageLensConfiguration(
        request: DeleteStorageLensConfigurationRequest
      ): F[DeleteStorageLensConfigurationResponse]

      def deleteStorageLensConfigurationTagging(
        request: DeleteStorageLensConfigurationTaggingRequest
      ): F[DeleteStorageLensConfigurationTaggingResponse]

      def describeJob(
        request: DescribeJobRequest
      ): F[DescribeJobResponse]

      def getAccessPoint(
        request: GetAccessPointRequest
      ): F[GetAccessPointResponse]

      def getAccessPointConfigurationForObjectLambda(
        request: GetAccessPointConfigurationForObjectLambdaRequest
      ): F[GetAccessPointConfigurationForObjectLambdaResponse]

      def getAccessPointForObjectLambda(
        request: GetAccessPointForObjectLambdaRequest
      ): F[GetAccessPointForObjectLambdaResponse]

      def getAccessPointPolicy(
        request: GetAccessPointPolicyRequest
      ): F[GetAccessPointPolicyResponse]

      def getAccessPointPolicyForObjectLambda(
        request: GetAccessPointPolicyForObjectLambdaRequest
      ): F[GetAccessPointPolicyForObjectLambdaResponse]

      def getAccessPointPolicyStatus(
        request: GetAccessPointPolicyStatusRequest
      ): F[GetAccessPointPolicyStatusResponse]

      def getAccessPointPolicyStatusForObjectLambda(
        request: GetAccessPointPolicyStatusForObjectLambdaRequest
      ): F[GetAccessPointPolicyStatusForObjectLambdaResponse]

      def getBucket(
        request: GetBucketRequest
      ): F[GetBucketResponse]

      def getBucketLifecycleConfiguration(
        request: GetBucketLifecycleConfigurationRequest
      ): F[GetBucketLifecycleConfigurationResponse]

      def getBucketPolicy(
        request: GetBucketPolicyRequest
      ): F[GetBucketPolicyResponse]

      def getBucketTagging(
        request: GetBucketTaggingRequest
      ): F[GetBucketTaggingResponse]

      def getJobTagging(
        request: GetJobTaggingRequest
      ): F[GetJobTaggingResponse]

      def getPublicAccessBlock(
        request: GetPublicAccessBlockRequest
      ): F[GetPublicAccessBlockResponse]

      def getStorageLensConfiguration(
        request: GetStorageLensConfigurationRequest
      ): F[GetStorageLensConfigurationResponse]

      def getStorageLensConfigurationTagging(
        request: GetStorageLensConfigurationTaggingRequest
      ): F[GetStorageLensConfigurationTaggingResponse]

      def listAccessPoints(
        request: ListAccessPointsRequest
      ): F[ListAccessPointsResponse]

      def listAccessPointsForObjectLambda(
        request: ListAccessPointsForObjectLambdaRequest
      ): F[ListAccessPointsForObjectLambdaResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listRegionalBuckets(
        request: ListRegionalBucketsRequest
      ): F[ListRegionalBucketsResponse]

      def listStorageLensConfigurations(
        request: ListStorageLensConfigurationsRequest
      ): F[ListStorageLensConfigurationsResponse]

      def putAccessPointConfigurationForObjectLambda(
        request: PutAccessPointConfigurationForObjectLambdaRequest
      ): F[PutAccessPointConfigurationForObjectLambdaResponse]

      def putAccessPointPolicy(
        request: PutAccessPointPolicyRequest
      ): F[PutAccessPointPolicyResponse]

      def putAccessPointPolicyForObjectLambda(
        request: PutAccessPointPolicyForObjectLambdaRequest
      ): F[PutAccessPointPolicyForObjectLambdaResponse]

      def putBucketLifecycleConfiguration(
        request: PutBucketLifecycleConfigurationRequest
      ): F[PutBucketLifecycleConfigurationResponse]

      def putBucketPolicy(
        request: PutBucketPolicyRequest
      ): F[PutBucketPolicyResponse]

      def putBucketTagging(
        request: PutBucketTaggingRequest
      ): F[PutBucketTaggingResponse]

      def putJobTagging(
        request: PutJobTaggingRequest
      ): F[PutJobTaggingResponse]

      def putPublicAccessBlock(
        request: PutPublicAccessBlockRequest
      ): F[PutPublicAccessBlockResponse]

      def putStorageLensConfiguration(
        request: PutStorageLensConfigurationRequest
      ): F[PutStorageLensConfigurationResponse]

      def putStorageLensConfigurationTagging(
        request: PutStorageLensConfigurationTaggingRequest
      ): F[PutStorageLensConfigurationTaggingResponse]

      def updateJobPriority(
        request: UpdateJobPriorityRequest
      ): F[UpdateJobPriorityResponse]

      def updateJobStatus(
        request: UpdateJobStatusRequest
      ): F[UpdateJobStatusResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends S3ControlOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAccessPointOp(
      request: CreateAccessPointRequest
    ) extends S3ControlOp[CreateAccessPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccessPointResponse] =
        visitor.createAccessPoint(request)
    }

    final case class CreateAccessPointForObjectLambdaOp(
      request: CreateAccessPointForObjectLambdaRequest
    ) extends S3ControlOp[CreateAccessPointForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccessPointForObjectLambdaResponse] =
        visitor.createAccessPointForObjectLambda(request)
    }

    final case class CreateBucketOp(
      request: CreateBucketRequest
    ) extends S3ControlOp[CreateBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBucketResponse] =
        visitor.createBucket(request)
    }

    final case class CreateJobOp(
      request: CreateJobRequest
    ) extends S3ControlOp[CreateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobResponse] =
        visitor.createJob(request)
    }

    final case class DeleteAccessPointOp(
      request: DeleteAccessPointRequest
    ) extends S3ControlOp[DeleteAccessPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessPointResponse] =
        visitor.deleteAccessPoint(request)
    }

    final case class DeleteAccessPointForObjectLambdaOp(
      request: DeleteAccessPointForObjectLambdaRequest
    ) extends S3ControlOp[DeleteAccessPointForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessPointForObjectLambdaResponse] =
        visitor.deleteAccessPointForObjectLambda(request)
    }

    final case class DeleteAccessPointPolicyOp(
      request: DeleteAccessPointPolicyRequest
    ) extends S3ControlOp[DeleteAccessPointPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessPointPolicyResponse] =
        visitor.deleteAccessPointPolicy(request)
    }

    final case class DeleteAccessPointPolicyForObjectLambdaOp(
      request: DeleteAccessPointPolicyForObjectLambdaRequest
    ) extends S3ControlOp[DeleteAccessPointPolicyForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessPointPolicyForObjectLambdaResponse] =
        visitor.deleteAccessPointPolicyForObjectLambda(request)
    }

    final case class DeleteBucketOp(
      request: DeleteBucketRequest
    ) extends S3ControlOp[DeleteBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketResponse] =
        visitor.deleteBucket(request)
    }

    final case class DeleteBucketLifecycleConfigurationOp(
      request: DeleteBucketLifecycleConfigurationRequest
    ) extends S3ControlOp[DeleteBucketLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketLifecycleConfigurationResponse] =
        visitor.deleteBucketLifecycleConfiguration(request)
    }

    final case class DeleteBucketPolicyOp(
      request: DeleteBucketPolicyRequest
    ) extends S3ControlOp[DeleteBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketPolicyResponse] =
        visitor.deleteBucketPolicy(request)
    }

    final case class DeleteBucketTaggingOp(
      request: DeleteBucketTaggingRequest
    ) extends S3ControlOp[DeleteBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBucketTaggingResponse] =
        visitor.deleteBucketTagging(request)
    }

    final case class DeleteJobTaggingOp(
      request: DeleteJobTaggingRequest
    ) extends S3ControlOp[DeleteJobTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobTaggingResponse] =
        visitor.deleteJobTagging(request)
    }

    final case class DeletePublicAccessBlockOp(
      request: DeletePublicAccessBlockRequest
    ) extends S3ControlOp[DeletePublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePublicAccessBlockResponse] =
        visitor.deletePublicAccessBlock(request)
    }

    final case class DeleteStorageLensConfigurationOp(
      request: DeleteStorageLensConfigurationRequest
    ) extends S3ControlOp[DeleteStorageLensConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStorageLensConfigurationResponse] =
        visitor.deleteStorageLensConfiguration(request)
    }

    final case class DeleteStorageLensConfigurationTaggingOp(
      request: DeleteStorageLensConfigurationTaggingRequest
    ) extends S3ControlOp[DeleteStorageLensConfigurationTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStorageLensConfigurationTaggingResponse] =
        visitor.deleteStorageLensConfigurationTagging(request)
    }

    final case class DescribeJobOp(
      request: DescribeJobRequest
    ) extends S3ControlOp[DescribeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobResponse] =
        visitor.describeJob(request)
    }

    final case class GetAccessPointOp(
      request: GetAccessPointRequest
    ) extends S3ControlOp[GetAccessPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPointResponse] =
        visitor.getAccessPoint(request)
    }

    final case class GetAccessPointConfigurationForObjectLambdaOp(
      request: GetAccessPointConfigurationForObjectLambdaRequest
    ) extends S3ControlOp[GetAccessPointConfigurationForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPointConfigurationForObjectLambdaResponse] =
        visitor.getAccessPointConfigurationForObjectLambda(request)
    }

    final case class GetAccessPointForObjectLambdaOp(
      request: GetAccessPointForObjectLambdaRequest
    ) extends S3ControlOp[GetAccessPointForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPointForObjectLambdaResponse] =
        visitor.getAccessPointForObjectLambda(request)
    }

    final case class GetAccessPointPolicyOp(
      request: GetAccessPointPolicyRequest
    ) extends S3ControlOp[GetAccessPointPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPointPolicyResponse] =
        visitor.getAccessPointPolicy(request)
    }

    final case class GetAccessPointPolicyForObjectLambdaOp(
      request: GetAccessPointPolicyForObjectLambdaRequest
    ) extends S3ControlOp[GetAccessPointPolicyForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPointPolicyForObjectLambdaResponse] =
        visitor.getAccessPointPolicyForObjectLambda(request)
    }

    final case class GetAccessPointPolicyStatusOp(
      request: GetAccessPointPolicyStatusRequest
    ) extends S3ControlOp[GetAccessPointPolicyStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPointPolicyStatusResponse] =
        visitor.getAccessPointPolicyStatus(request)
    }

    final case class GetAccessPointPolicyStatusForObjectLambdaOp(
      request: GetAccessPointPolicyStatusForObjectLambdaRequest
    ) extends S3ControlOp[GetAccessPointPolicyStatusForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessPointPolicyStatusForObjectLambdaResponse] =
        visitor.getAccessPointPolicyStatusForObjectLambda(request)
    }

    final case class GetBucketOp(
      request: GetBucketRequest
    ) extends S3ControlOp[GetBucketResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketResponse] =
        visitor.getBucket(request)
    }

    final case class GetBucketLifecycleConfigurationOp(
      request: GetBucketLifecycleConfigurationRequest
    ) extends S3ControlOp[GetBucketLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketLifecycleConfigurationResponse] =
        visitor.getBucketLifecycleConfiguration(request)
    }

    final case class GetBucketPolicyOp(
      request: GetBucketPolicyRequest
    ) extends S3ControlOp[GetBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketPolicyResponse] =
        visitor.getBucketPolicy(request)
    }

    final case class GetBucketTaggingOp(
      request: GetBucketTaggingRequest
    ) extends S3ControlOp[GetBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketTaggingResponse] =
        visitor.getBucketTagging(request)
    }

    final case class GetJobTaggingOp(
      request: GetJobTaggingRequest
    ) extends S3ControlOp[GetJobTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobTaggingResponse] =
        visitor.getJobTagging(request)
    }

    final case class GetPublicAccessBlockOp(
      request: GetPublicAccessBlockRequest
    ) extends S3ControlOp[GetPublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPublicAccessBlockResponse] =
        visitor.getPublicAccessBlock(request)
    }

    final case class GetStorageLensConfigurationOp(
      request: GetStorageLensConfigurationRequest
    ) extends S3ControlOp[GetStorageLensConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStorageLensConfigurationResponse] =
        visitor.getStorageLensConfiguration(request)
    }

    final case class GetStorageLensConfigurationTaggingOp(
      request: GetStorageLensConfigurationTaggingRequest
    ) extends S3ControlOp[GetStorageLensConfigurationTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStorageLensConfigurationTaggingResponse] =
        visitor.getStorageLensConfigurationTagging(request)
    }

    final case class ListAccessPointsOp(
      request: ListAccessPointsRequest
    ) extends S3ControlOp[ListAccessPointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessPointsResponse] =
        visitor.listAccessPoints(request)
    }

    final case class ListAccessPointsForObjectLambdaOp(
      request: ListAccessPointsForObjectLambdaRequest
    ) extends S3ControlOp[ListAccessPointsForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessPointsForObjectLambdaResponse] =
        visitor.listAccessPointsForObjectLambda(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends S3ControlOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListRegionalBucketsOp(
      request: ListRegionalBucketsRequest
    ) extends S3ControlOp[ListRegionalBucketsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegionalBucketsResponse] =
        visitor.listRegionalBuckets(request)
    }

    final case class ListStorageLensConfigurationsOp(
      request: ListStorageLensConfigurationsRequest
    ) extends S3ControlOp[ListStorageLensConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStorageLensConfigurationsResponse] =
        visitor.listStorageLensConfigurations(request)
    }

    final case class PutAccessPointConfigurationForObjectLambdaOp(
      request: PutAccessPointConfigurationForObjectLambdaRequest
    ) extends S3ControlOp[PutAccessPointConfigurationForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccessPointConfigurationForObjectLambdaResponse] =
        visitor.putAccessPointConfigurationForObjectLambda(request)
    }

    final case class PutAccessPointPolicyOp(
      request: PutAccessPointPolicyRequest
    ) extends S3ControlOp[PutAccessPointPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccessPointPolicyResponse] =
        visitor.putAccessPointPolicy(request)
    }

    final case class PutAccessPointPolicyForObjectLambdaOp(
      request: PutAccessPointPolicyForObjectLambdaRequest
    ) extends S3ControlOp[PutAccessPointPolicyForObjectLambdaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccessPointPolicyForObjectLambdaResponse] =
        visitor.putAccessPointPolicyForObjectLambda(request)
    }

    final case class PutBucketLifecycleConfigurationOp(
      request: PutBucketLifecycleConfigurationRequest
    ) extends S3ControlOp[PutBucketLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketLifecycleConfigurationResponse] =
        visitor.putBucketLifecycleConfiguration(request)
    }

    final case class PutBucketPolicyOp(
      request: PutBucketPolicyRequest
    ) extends S3ControlOp[PutBucketPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketPolicyResponse] =
        visitor.putBucketPolicy(request)
    }

    final case class PutBucketTaggingOp(
      request: PutBucketTaggingRequest
    ) extends S3ControlOp[PutBucketTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBucketTaggingResponse] =
        visitor.putBucketTagging(request)
    }

    final case class PutJobTaggingOp(
      request: PutJobTaggingRequest
    ) extends S3ControlOp[PutJobTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutJobTaggingResponse] =
        visitor.putJobTagging(request)
    }

    final case class PutPublicAccessBlockOp(
      request: PutPublicAccessBlockRequest
    ) extends S3ControlOp[PutPublicAccessBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPublicAccessBlockResponse] =
        visitor.putPublicAccessBlock(request)
    }

    final case class PutStorageLensConfigurationOp(
      request: PutStorageLensConfigurationRequest
    ) extends S3ControlOp[PutStorageLensConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutStorageLensConfigurationResponse] =
        visitor.putStorageLensConfiguration(request)
    }

    final case class PutStorageLensConfigurationTaggingOp(
      request: PutStorageLensConfigurationTaggingRequest
    ) extends S3ControlOp[PutStorageLensConfigurationTaggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutStorageLensConfigurationTaggingResponse] =
        visitor.putStorageLensConfigurationTagging(request)
    }

    final case class UpdateJobPriorityOp(
      request: UpdateJobPriorityRequest
    ) extends S3ControlOp[UpdateJobPriorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobPriorityResponse] =
        visitor.updateJobPriority(request)
    }

    final case class UpdateJobStatusOp(
      request: UpdateJobStatusRequest
    ) extends S3ControlOp[UpdateJobStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobStatusResponse] =
        visitor.updateJobStatus(request)
    }
  }

  import S3ControlOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[S3ControlOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createAccessPoint(
    request: CreateAccessPointRequest
  ): S3ControlIO[CreateAccessPointResponse] =
    FF.liftF(CreateAccessPointOp(request))

  def createAccessPointForObjectLambda(
    request: CreateAccessPointForObjectLambdaRequest
  ): S3ControlIO[CreateAccessPointForObjectLambdaResponse] =
    FF.liftF(CreateAccessPointForObjectLambdaOp(request))

  def createBucket(
    request: CreateBucketRequest
  ): S3ControlIO[CreateBucketResponse] =
    FF.liftF(CreateBucketOp(request))

  def createJob(
    request: CreateJobRequest
  ): S3ControlIO[CreateJobResponse] =
    FF.liftF(CreateJobOp(request))

  def deleteAccessPoint(
    request: DeleteAccessPointRequest
  ): S3ControlIO[DeleteAccessPointResponse] =
    FF.liftF(DeleteAccessPointOp(request))

  def deleteAccessPointForObjectLambda(
    request: DeleteAccessPointForObjectLambdaRequest
  ): S3ControlIO[DeleteAccessPointForObjectLambdaResponse] =
    FF.liftF(DeleteAccessPointForObjectLambdaOp(request))

  def deleteAccessPointPolicy(
    request: DeleteAccessPointPolicyRequest
  ): S3ControlIO[DeleteAccessPointPolicyResponse] =
    FF.liftF(DeleteAccessPointPolicyOp(request))

  def deleteAccessPointPolicyForObjectLambda(
    request: DeleteAccessPointPolicyForObjectLambdaRequest
  ): S3ControlIO[DeleteAccessPointPolicyForObjectLambdaResponse] =
    FF.liftF(DeleteAccessPointPolicyForObjectLambdaOp(request))

  def deleteBucket(
    request: DeleteBucketRequest
  ): S3ControlIO[DeleteBucketResponse] =
    FF.liftF(DeleteBucketOp(request))

  def deleteBucketLifecycleConfiguration(
    request: DeleteBucketLifecycleConfigurationRequest
  ): S3ControlIO[DeleteBucketLifecycleConfigurationResponse] =
    FF.liftF(DeleteBucketLifecycleConfigurationOp(request))

  def deleteBucketPolicy(
    request: DeleteBucketPolicyRequest
  ): S3ControlIO[DeleteBucketPolicyResponse] =
    FF.liftF(DeleteBucketPolicyOp(request))

  def deleteBucketTagging(
    request: DeleteBucketTaggingRequest
  ): S3ControlIO[DeleteBucketTaggingResponse] =
    FF.liftF(DeleteBucketTaggingOp(request))

  def deleteJobTagging(
    request: DeleteJobTaggingRequest
  ): S3ControlIO[DeleteJobTaggingResponse] =
    FF.liftF(DeleteJobTaggingOp(request))

  def deletePublicAccessBlock(
    request: DeletePublicAccessBlockRequest
  ): S3ControlIO[DeletePublicAccessBlockResponse] =
    FF.liftF(DeletePublicAccessBlockOp(request))

  def deleteStorageLensConfiguration(
    request: DeleteStorageLensConfigurationRequest
  ): S3ControlIO[DeleteStorageLensConfigurationResponse] =
    FF.liftF(DeleteStorageLensConfigurationOp(request))

  def deleteStorageLensConfigurationTagging(
    request: DeleteStorageLensConfigurationTaggingRequest
  ): S3ControlIO[DeleteStorageLensConfigurationTaggingResponse] =
    FF.liftF(DeleteStorageLensConfigurationTaggingOp(request))

  def describeJob(
    request: DescribeJobRequest
  ): S3ControlIO[DescribeJobResponse] =
    FF.liftF(DescribeJobOp(request))

  def getAccessPoint(
    request: GetAccessPointRequest
  ): S3ControlIO[GetAccessPointResponse] =
    FF.liftF(GetAccessPointOp(request))

  def getAccessPointConfigurationForObjectLambda(
    request: GetAccessPointConfigurationForObjectLambdaRequest
  ): S3ControlIO[GetAccessPointConfigurationForObjectLambdaResponse] =
    FF.liftF(GetAccessPointConfigurationForObjectLambdaOp(request))

  def getAccessPointForObjectLambda(
    request: GetAccessPointForObjectLambdaRequest
  ): S3ControlIO[GetAccessPointForObjectLambdaResponse] =
    FF.liftF(GetAccessPointForObjectLambdaOp(request))

  def getAccessPointPolicy(
    request: GetAccessPointPolicyRequest
  ): S3ControlIO[GetAccessPointPolicyResponse] =
    FF.liftF(GetAccessPointPolicyOp(request))

  def getAccessPointPolicyForObjectLambda(
    request: GetAccessPointPolicyForObjectLambdaRequest
  ): S3ControlIO[GetAccessPointPolicyForObjectLambdaResponse] =
    FF.liftF(GetAccessPointPolicyForObjectLambdaOp(request))

  def getAccessPointPolicyStatus(
    request: GetAccessPointPolicyStatusRequest
  ): S3ControlIO[GetAccessPointPolicyStatusResponse] =
    FF.liftF(GetAccessPointPolicyStatusOp(request))

  def getAccessPointPolicyStatusForObjectLambda(
    request: GetAccessPointPolicyStatusForObjectLambdaRequest
  ): S3ControlIO[GetAccessPointPolicyStatusForObjectLambdaResponse] =
    FF.liftF(GetAccessPointPolicyStatusForObjectLambdaOp(request))

  def getBucket(
    request: GetBucketRequest
  ): S3ControlIO[GetBucketResponse] =
    FF.liftF(GetBucketOp(request))

  def getBucketLifecycleConfiguration(
    request: GetBucketLifecycleConfigurationRequest
  ): S3ControlIO[GetBucketLifecycleConfigurationResponse] =
    FF.liftF(GetBucketLifecycleConfigurationOp(request))

  def getBucketPolicy(
    request: GetBucketPolicyRequest
  ): S3ControlIO[GetBucketPolicyResponse] =
    FF.liftF(GetBucketPolicyOp(request))

  def getBucketTagging(
    request: GetBucketTaggingRequest
  ): S3ControlIO[GetBucketTaggingResponse] =
    FF.liftF(GetBucketTaggingOp(request))

  def getJobTagging(
    request: GetJobTaggingRequest
  ): S3ControlIO[GetJobTaggingResponse] =
    FF.liftF(GetJobTaggingOp(request))

  def getPublicAccessBlock(
    request: GetPublicAccessBlockRequest
  ): S3ControlIO[GetPublicAccessBlockResponse] =
    FF.liftF(GetPublicAccessBlockOp(request))

  def getStorageLensConfiguration(
    request: GetStorageLensConfigurationRequest
  ): S3ControlIO[GetStorageLensConfigurationResponse] =
    FF.liftF(GetStorageLensConfigurationOp(request))

  def getStorageLensConfigurationTagging(
    request: GetStorageLensConfigurationTaggingRequest
  ): S3ControlIO[GetStorageLensConfigurationTaggingResponse] =
    FF.liftF(GetStorageLensConfigurationTaggingOp(request))

  def listAccessPoints(
    request: ListAccessPointsRequest
  ): S3ControlIO[ListAccessPointsResponse] =
    FF.liftF(ListAccessPointsOp(request))

  def listAccessPointsForObjectLambda(
    request: ListAccessPointsForObjectLambdaRequest
  ): S3ControlIO[ListAccessPointsForObjectLambdaResponse] =
    FF.liftF(ListAccessPointsForObjectLambdaOp(request))

  def listJobs(
    request: ListJobsRequest
  ): S3ControlIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listRegionalBuckets(
    request: ListRegionalBucketsRequest
  ): S3ControlIO[ListRegionalBucketsResponse] =
    FF.liftF(ListRegionalBucketsOp(request))

  def listStorageLensConfigurations(
    request: ListStorageLensConfigurationsRequest
  ): S3ControlIO[ListStorageLensConfigurationsResponse] =
    FF.liftF(ListStorageLensConfigurationsOp(request))

  def putAccessPointConfigurationForObjectLambda(
    request: PutAccessPointConfigurationForObjectLambdaRequest
  ): S3ControlIO[PutAccessPointConfigurationForObjectLambdaResponse] =
    FF.liftF(PutAccessPointConfigurationForObjectLambdaOp(request))

  def putAccessPointPolicy(
    request: PutAccessPointPolicyRequest
  ): S3ControlIO[PutAccessPointPolicyResponse] =
    FF.liftF(PutAccessPointPolicyOp(request))

  def putAccessPointPolicyForObjectLambda(
    request: PutAccessPointPolicyForObjectLambdaRequest
  ): S3ControlIO[PutAccessPointPolicyForObjectLambdaResponse] =
    FF.liftF(PutAccessPointPolicyForObjectLambdaOp(request))

  def putBucketLifecycleConfiguration(
    request: PutBucketLifecycleConfigurationRequest
  ): S3ControlIO[PutBucketLifecycleConfigurationResponse] =
    FF.liftF(PutBucketLifecycleConfigurationOp(request))

  def putBucketPolicy(
    request: PutBucketPolicyRequest
  ): S3ControlIO[PutBucketPolicyResponse] =
    FF.liftF(PutBucketPolicyOp(request))

  def putBucketTagging(
    request: PutBucketTaggingRequest
  ): S3ControlIO[PutBucketTaggingResponse] =
    FF.liftF(PutBucketTaggingOp(request))

  def putJobTagging(
    request: PutJobTaggingRequest
  ): S3ControlIO[PutJobTaggingResponse] =
    FF.liftF(PutJobTaggingOp(request))

  def putPublicAccessBlock(
    request: PutPublicAccessBlockRequest
  ): S3ControlIO[PutPublicAccessBlockResponse] =
    FF.liftF(PutPublicAccessBlockOp(request))

  def putStorageLensConfiguration(
    request: PutStorageLensConfigurationRequest
  ): S3ControlIO[PutStorageLensConfigurationResponse] =
    FF.liftF(PutStorageLensConfigurationOp(request))

  def putStorageLensConfigurationTagging(
    request: PutStorageLensConfigurationTaggingRequest
  ): S3ControlIO[PutStorageLensConfigurationTaggingResponse] =
    FF.liftF(PutStorageLensConfigurationTaggingOp(request))

  def updateJobPriority(
    request: UpdateJobPriorityRequest
  ): S3ControlIO[UpdateJobPriorityResponse] =
    FF.liftF(UpdateJobPriorityOp(request))

  def updateJobStatus(
    request: UpdateJobStatusRequest
  ): S3ControlIO[UpdateJobStatusResponse] =
    FF.liftF(UpdateJobStatusOp(request))
}
