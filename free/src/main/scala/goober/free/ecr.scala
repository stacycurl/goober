package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ecr.EcrClient
import software.amazon.awssdk.services.ecr.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ecr { module =>

  // Free monad over EcrOp
  type EcrIO[A] = FF[EcrOp, A]

  sealed trait EcrOp[A] {
    def visit[F[_]](visitor: EcrOp.Visitor[F]): F[A]
  }

  object EcrOp {
    // Given a EcrClient we can embed a EcrIO program in any algebra that understands embedding.
    implicit val EcrOpEmbeddable: Embeddable[EcrOp, EcrClient] = new Embeddable[EcrOp, EcrClient] {
      def embed[A](client: EcrClient, io: EcrIO[A]): Embedded[A] = Embedded.Ecr(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EcrOp.Visitor[Kleisli[M, EcrClient, *]] {
        def batchCheckLayerAvailability(
          request: BatchCheckLayerAvailabilityRequest
        ): Kleisli[M, EcrClient, BatchCheckLayerAvailabilityResponse] =
          primitive(_.batchCheckLayerAvailability(request))

        def batchDeleteImage(
          request: BatchDeleteImageRequest
        ): Kleisli[M, EcrClient, BatchDeleteImageResponse] =
          primitive(_.batchDeleteImage(request))

        def batchGetImage(
          request: BatchGetImageRequest
        ): Kleisli[M, EcrClient, BatchGetImageResponse] =
          primitive(_.batchGetImage(request))

        def completeLayerUpload(
          request: CompleteLayerUploadRequest
        ): Kleisli[M, EcrClient, CompleteLayerUploadResponse] =
          primitive(_.completeLayerUpload(request))

        def createRepository(
          request: CreateRepositoryRequest
        ): Kleisli[M, EcrClient, CreateRepositoryResponse] =
          primitive(_.createRepository(request))

        def deleteLifecyclePolicy(
          request: DeleteLifecyclePolicyRequest
        ): Kleisli[M, EcrClient, DeleteLifecyclePolicyResponse] =
          primitive(_.deleteLifecyclePolicy(request))

        def deleteRegistryPolicy(
          request: DeleteRegistryPolicyRequest
        ): Kleisli[M, EcrClient, DeleteRegistryPolicyResponse] =
          primitive(_.deleteRegistryPolicy(request))

        def deleteRepository(
          request: DeleteRepositoryRequest
        ): Kleisli[M, EcrClient, DeleteRepositoryResponse] =
          primitive(_.deleteRepository(request))

        def deleteRepositoryPolicy(
          request: DeleteRepositoryPolicyRequest
        ): Kleisli[M, EcrClient, DeleteRepositoryPolicyResponse] =
          primitive(_.deleteRepositoryPolicy(request))

        def describeImageScanFindings(
          request: DescribeImageScanFindingsRequest
        ): Kleisli[M, EcrClient, DescribeImageScanFindingsResponse] =
          primitive(_.describeImageScanFindings(request))

        def describeImages(
          request: DescribeImagesRequest
        ): Kleisli[M, EcrClient, DescribeImagesResponse] =
          primitive(_.describeImages(request))

        def describeRegistry(
          request: DescribeRegistryRequest
        ): Kleisli[M, EcrClient, DescribeRegistryResponse] =
          primitive(_.describeRegistry(request))

        def describeRepositories(
          request: DescribeRepositoriesRequest
        ): Kleisli[M, EcrClient, DescribeRepositoriesResponse] =
          primitive(_.describeRepositories(request))

        def getAuthorizationToken(
          request: GetAuthorizationTokenRequest
        ): Kleisli[M, EcrClient, GetAuthorizationTokenResponse] =
          primitive(_.getAuthorizationToken(request))

        def getDownloadUrlForLayer(
          request: GetDownloadUrlForLayerRequest
        ): Kleisli[M, EcrClient, GetDownloadUrlForLayerResponse] =
          primitive(_.getDownloadUrlForLayer(request))

        def getLifecyclePolicy(
          request: GetLifecyclePolicyRequest
        ): Kleisli[M, EcrClient, GetLifecyclePolicyResponse] =
          primitive(_.getLifecyclePolicy(request))

        def getLifecyclePolicyPreview(
          request: GetLifecyclePolicyPreviewRequest
        ): Kleisli[M, EcrClient, GetLifecyclePolicyPreviewResponse] =
          primitive(_.getLifecyclePolicyPreview(request))

        def getRegistryPolicy(
          request: GetRegistryPolicyRequest
        ): Kleisli[M, EcrClient, GetRegistryPolicyResponse] =
          primitive(_.getRegistryPolicy(request))

        def getRepositoryPolicy(
          request: GetRepositoryPolicyRequest
        ): Kleisli[M, EcrClient, GetRepositoryPolicyResponse] =
          primitive(_.getRepositoryPolicy(request))

        def initiateLayerUpload(
          request: InitiateLayerUploadRequest
        ): Kleisli[M, EcrClient, InitiateLayerUploadResponse] =
          primitive(_.initiateLayerUpload(request))

        def listImages(
          request: ListImagesRequest
        ): Kleisli[M, EcrClient, ListImagesResponse] =
          primitive(_.listImages(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, EcrClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putImage(
          request: PutImageRequest
        ): Kleisli[M, EcrClient, PutImageResponse] =
          primitive(_.putImage(request))

        def putImageScanningConfiguration(
          request: PutImageScanningConfigurationRequest
        ): Kleisli[M, EcrClient, PutImageScanningConfigurationResponse] =
          primitive(_.putImageScanningConfiguration(request))

        def putImageTagMutability(
          request: PutImageTagMutabilityRequest
        ): Kleisli[M, EcrClient, PutImageTagMutabilityResponse] =
          primitive(_.putImageTagMutability(request))

        def putLifecyclePolicy(
          request: PutLifecyclePolicyRequest
        ): Kleisli[M, EcrClient, PutLifecyclePolicyResponse] =
          primitive(_.putLifecyclePolicy(request))

        def putRegistryPolicy(
          request: PutRegistryPolicyRequest
        ): Kleisli[M, EcrClient, PutRegistryPolicyResponse] =
          primitive(_.putRegistryPolicy(request))

        def putReplicationConfiguration(
          request: PutReplicationConfigurationRequest
        ): Kleisli[M, EcrClient, PutReplicationConfigurationResponse] =
          primitive(_.putReplicationConfiguration(request))

        def setRepositoryPolicy(
          request: SetRepositoryPolicyRequest
        ): Kleisli[M, EcrClient, SetRepositoryPolicyResponse] =
          primitive(_.setRepositoryPolicy(request))

        def startImageScan(
          request: StartImageScanRequest
        ): Kleisli[M, EcrClient, StartImageScanResponse] =
          primitive(_.startImageScan(request))

        def startLifecyclePolicyPreview(
          request: StartLifecyclePolicyPreviewRequest
        ): Kleisli[M, EcrClient, StartLifecyclePolicyPreviewResponse] =
          primitive(_.startLifecyclePolicyPreview(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, EcrClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, EcrClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def uploadLayerPart(
          request: UploadLayerPartRequest
        ): Kleisli[M, EcrClient, UploadLayerPartResponse] =
          primitive(_.uploadLayerPart(request))

        def primitive[A](
          f: EcrClient => A
        ): Kleisli[M, EcrClient, A]
      }
    }

    trait Visitor[F[_]] extends (EcrOp ~> F) {
      final def apply[A](op: EcrOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchCheckLayerAvailability(
        request: BatchCheckLayerAvailabilityRequest
      ): F[BatchCheckLayerAvailabilityResponse]

      def batchDeleteImage(
        request: BatchDeleteImageRequest
      ): F[BatchDeleteImageResponse]

      def batchGetImage(
        request: BatchGetImageRequest
      ): F[BatchGetImageResponse]

      def completeLayerUpload(
        request: CompleteLayerUploadRequest
      ): F[CompleteLayerUploadResponse]

      def createRepository(
        request: CreateRepositoryRequest
      ): F[CreateRepositoryResponse]

      def deleteLifecyclePolicy(
        request: DeleteLifecyclePolicyRequest
      ): F[DeleteLifecyclePolicyResponse]

      def deleteRegistryPolicy(
        request: DeleteRegistryPolicyRequest
      ): F[DeleteRegistryPolicyResponse]

      def deleteRepository(
        request: DeleteRepositoryRequest
      ): F[DeleteRepositoryResponse]

      def deleteRepositoryPolicy(
        request: DeleteRepositoryPolicyRequest
      ): F[DeleteRepositoryPolicyResponse]

      def describeImageScanFindings(
        request: DescribeImageScanFindingsRequest
      ): F[DescribeImageScanFindingsResponse]

      def describeImages(
        request: DescribeImagesRequest
      ): F[DescribeImagesResponse]

      def describeRegistry(
        request: DescribeRegistryRequest
      ): F[DescribeRegistryResponse]

      def describeRepositories(
        request: DescribeRepositoriesRequest
      ): F[DescribeRepositoriesResponse]

      def getAuthorizationToken(
        request: GetAuthorizationTokenRequest
      ): F[GetAuthorizationTokenResponse]

      def getDownloadUrlForLayer(
        request: GetDownloadUrlForLayerRequest
      ): F[GetDownloadUrlForLayerResponse]

      def getLifecyclePolicy(
        request: GetLifecyclePolicyRequest
      ): F[GetLifecyclePolicyResponse]

      def getLifecyclePolicyPreview(
        request: GetLifecyclePolicyPreviewRequest
      ): F[GetLifecyclePolicyPreviewResponse]

      def getRegistryPolicy(
        request: GetRegistryPolicyRequest
      ): F[GetRegistryPolicyResponse]

      def getRepositoryPolicy(
        request: GetRepositoryPolicyRequest
      ): F[GetRepositoryPolicyResponse]

      def initiateLayerUpload(
        request: InitiateLayerUploadRequest
      ): F[InitiateLayerUploadResponse]

      def listImages(
        request: ListImagesRequest
      ): F[ListImagesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putImage(
        request: PutImageRequest
      ): F[PutImageResponse]

      def putImageScanningConfiguration(
        request: PutImageScanningConfigurationRequest
      ): F[PutImageScanningConfigurationResponse]

      def putImageTagMutability(
        request: PutImageTagMutabilityRequest
      ): F[PutImageTagMutabilityResponse]

      def putLifecyclePolicy(
        request: PutLifecyclePolicyRequest
      ): F[PutLifecyclePolicyResponse]

      def putRegistryPolicy(
        request: PutRegistryPolicyRequest
      ): F[PutRegistryPolicyResponse]

      def putReplicationConfiguration(
        request: PutReplicationConfigurationRequest
      ): F[PutReplicationConfigurationResponse]

      def setRepositoryPolicy(
        request: SetRepositoryPolicyRequest
      ): F[SetRepositoryPolicyResponse]

      def startImageScan(
        request: StartImageScanRequest
      ): F[StartImageScanResponse]

      def startLifecyclePolicyPreview(
        request: StartLifecyclePolicyPreviewRequest
      ): F[StartLifecyclePolicyPreviewResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def uploadLayerPart(
        request: UploadLayerPartRequest
      ): F[UploadLayerPartResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EcrOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchCheckLayerAvailabilityOp(
      request: BatchCheckLayerAvailabilityRequest
    ) extends EcrOp[BatchCheckLayerAvailabilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCheckLayerAvailabilityResponse] =
        visitor.batchCheckLayerAvailability(request)
    }

    final case class BatchDeleteImageOp(
      request: BatchDeleteImageRequest
    ) extends EcrOp[BatchDeleteImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteImageResponse] =
        visitor.batchDeleteImage(request)
    }

    final case class BatchGetImageOp(
      request: BatchGetImageRequest
    ) extends EcrOp[BatchGetImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetImageResponse] =
        visitor.batchGetImage(request)
    }

    final case class CompleteLayerUploadOp(
      request: CompleteLayerUploadRequest
    ) extends EcrOp[CompleteLayerUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteLayerUploadResponse] =
        visitor.completeLayerUpload(request)
    }

    final case class CreateRepositoryOp(
      request: CreateRepositoryRequest
    ) extends EcrOp[CreateRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRepositoryResponse] =
        visitor.createRepository(request)
    }

    final case class DeleteLifecyclePolicyOp(
      request: DeleteLifecyclePolicyRequest
    ) extends EcrOp[DeleteLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLifecyclePolicyResponse] =
        visitor.deleteLifecyclePolicy(request)
    }

    final case class DeleteRegistryPolicyOp(
      request: DeleteRegistryPolicyRequest
    ) extends EcrOp[DeleteRegistryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegistryPolicyResponse] =
        visitor.deleteRegistryPolicy(request)
    }

    final case class DeleteRepositoryOp(
      request: DeleteRepositoryRequest
    ) extends EcrOp[DeleteRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRepositoryResponse] =
        visitor.deleteRepository(request)
    }

    final case class DeleteRepositoryPolicyOp(
      request: DeleteRepositoryPolicyRequest
    ) extends EcrOp[DeleteRepositoryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRepositoryPolicyResponse] =
        visitor.deleteRepositoryPolicy(request)
    }

    final case class DescribeImageScanFindingsOp(
      request: DescribeImageScanFindingsRequest
    ) extends EcrOp[DescribeImageScanFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImageScanFindingsResponse] =
        visitor.describeImageScanFindings(request)
    }

    final case class DescribeImagesOp(
      request: DescribeImagesRequest
    ) extends EcrOp[DescribeImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImagesResponse] =
        visitor.describeImages(request)
    }

    final case class DescribeRegistryOp(
      request: DescribeRegistryRequest
    ) extends EcrOp[DescribeRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRegistryResponse] =
        visitor.describeRegistry(request)
    }

    final case class DescribeRepositoriesOp(
      request: DescribeRepositoriesRequest
    ) extends EcrOp[DescribeRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRepositoriesResponse] =
        visitor.describeRepositories(request)
    }

    final case class GetAuthorizationTokenOp(
      request: GetAuthorizationTokenRequest
    ) extends EcrOp[GetAuthorizationTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAuthorizationTokenResponse] =
        visitor.getAuthorizationToken(request)
    }

    final case class GetDownloadUrlForLayerOp(
      request: GetDownloadUrlForLayerRequest
    ) extends EcrOp[GetDownloadUrlForLayerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDownloadUrlForLayerResponse] =
        visitor.getDownloadUrlForLayer(request)
    }

    final case class GetLifecyclePolicyOp(
      request: GetLifecyclePolicyRequest
    ) extends EcrOp[GetLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLifecyclePolicyResponse] =
        visitor.getLifecyclePolicy(request)
    }

    final case class GetLifecyclePolicyPreviewOp(
      request: GetLifecyclePolicyPreviewRequest
    ) extends EcrOp[GetLifecyclePolicyPreviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLifecyclePolicyPreviewResponse] =
        visitor.getLifecyclePolicyPreview(request)
    }

    final case class GetRegistryPolicyOp(
      request: GetRegistryPolicyRequest
    ) extends EcrOp[GetRegistryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegistryPolicyResponse] =
        visitor.getRegistryPolicy(request)
    }

    final case class GetRepositoryPolicyOp(
      request: GetRepositoryPolicyRequest
    ) extends EcrOp[GetRepositoryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRepositoryPolicyResponse] =
        visitor.getRepositoryPolicy(request)
    }

    final case class InitiateLayerUploadOp(
      request: InitiateLayerUploadRequest
    ) extends EcrOp[InitiateLayerUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateLayerUploadResponse] =
        visitor.initiateLayerUpload(request)
    }

    final case class ListImagesOp(
      request: ListImagesRequest
    ) extends EcrOp[ListImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImagesResponse] =
        visitor.listImages(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends EcrOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutImageOp(
      request: PutImageRequest
    ) extends EcrOp[PutImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutImageResponse] =
        visitor.putImage(request)
    }

    final case class PutImageScanningConfigurationOp(
      request: PutImageScanningConfigurationRequest
    ) extends EcrOp[PutImageScanningConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutImageScanningConfigurationResponse] =
        visitor.putImageScanningConfiguration(request)
    }

    final case class PutImageTagMutabilityOp(
      request: PutImageTagMutabilityRequest
    ) extends EcrOp[PutImageTagMutabilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutImageTagMutabilityResponse] =
        visitor.putImageTagMutability(request)
    }

    final case class PutLifecyclePolicyOp(
      request: PutLifecyclePolicyRequest
    ) extends EcrOp[PutLifecyclePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLifecyclePolicyResponse] =
        visitor.putLifecyclePolicy(request)
    }

    final case class PutRegistryPolicyOp(
      request: PutRegistryPolicyRequest
    ) extends EcrOp[PutRegistryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRegistryPolicyResponse] =
        visitor.putRegistryPolicy(request)
    }

    final case class PutReplicationConfigurationOp(
      request: PutReplicationConfigurationRequest
    ) extends EcrOp[PutReplicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutReplicationConfigurationResponse] =
        visitor.putReplicationConfiguration(request)
    }

    final case class SetRepositoryPolicyOp(
      request: SetRepositoryPolicyRequest
    ) extends EcrOp[SetRepositoryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetRepositoryPolicyResponse] =
        visitor.setRepositoryPolicy(request)
    }

    final case class StartImageScanOp(
      request: StartImageScanRequest
    ) extends EcrOp[StartImageScanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartImageScanResponse] =
        visitor.startImageScan(request)
    }

    final case class StartLifecyclePolicyPreviewOp(
      request: StartLifecyclePolicyPreviewRequest
    ) extends EcrOp[StartLifecyclePolicyPreviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartLifecyclePolicyPreviewResponse] =
        visitor.startLifecyclePolicyPreview(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends EcrOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends EcrOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UploadLayerPartOp(
      request: UploadLayerPartRequest
    ) extends EcrOp[UploadLayerPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadLayerPartResponse] =
        visitor.uploadLayerPart(request)
    }
  }

  import EcrOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EcrOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchCheckLayerAvailability(
    request: BatchCheckLayerAvailabilityRequest
  ): EcrIO[BatchCheckLayerAvailabilityResponse] =
    FF.liftF(BatchCheckLayerAvailabilityOp(request))

  def batchDeleteImage(
    request: BatchDeleteImageRequest
  ): EcrIO[BatchDeleteImageResponse] =
    FF.liftF(BatchDeleteImageOp(request))

  def batchGetImage(
    request: BatchGetImageRequest
  ): EcrIO[BatchGetImageResponse] =
    FF.liftF(BatchGetImageOp(request))

  def completeLayerUpload(
    request: CompleteLayerUploadRequest
  ): EcrIO[CompleteLayerUploadResponse] =
    FF.liftF(CompleteLayerUploadOp(request))

  def createRepository(
    request: CreateRepositoryRequest
  ): EcrIO[CreateRepositoryResponse] =
    FF.liftF(CreateRepositoryOp(request))

  def deleteLifecyclePolicy(
    request: DeleteLifecyclePolicyRequest
  ): EcrIO[DeleteLifecyclePolicyResponse] =
    FF.liftF(DeleteLifecyclePolicyOp(request))

  def deleteRegistryPolicy(
    request: DeleteRegistryPolicyRequest
  ): EcrIO[DeleteRegistryPolicyResponse] =
    FF.liftF(DeleteRegistryPolicyOp(request))

  def deleteRepository(
    request: DeleteRepositoryRequest
  ): EcrIO[DeleteRepositoryResponse] =
    FF.liftF(DeleteRepositoryOp(request))

  def deleteRepositoryPolicy(
    request: DeleteRepositoryPolicyRequest
  ): EcrIO[DeleteRepositoryPolicyResponse] =
    FF.liftF(DeleteRepositoryPolicyOp(request))

  def describeImageScanFindings(
    request: DescribeImageScanFindingsRequest
  ): EcrIO[DescribeImageScanFindingsResponse] =
    FF.liftF(DescribeImageScanFindingsOp(request))

  def describeImages(
    request: DescribeImagesRequest
  ): EcrIO[DescribeImagesResponse] =
    FF.liftF(DescribeImagesOp(request))

  def describeRegistry(
    request: DescribeRegistryRequest
  ): EcrIO[DescribeRegistryResponse] =
    FF.liftF(DescribeRegistryOp(request))

  def describeRepositories(
    request: DescribeRepositoriesRequest
  ): EcrIO[DescribeRepositoriesResponse] =
    FF.liftF(DescribeRepositoriesOp(request))

  def getAuthorizationToken(
    request: GetAuthorizationTokenRequest
  ): EcrIO[GetAuthorizationTokenResponse] =
    FF.liftF(GetAuthorizationTokenOp(request))

  def getDownloadUrlForLayer(
    request: GetDownloadUrlForLayerRequest
  ): EcrIO[GetDownloadUrlForLayerResponse] =
    FF.liftF(GetDownloadUrlForLayerOp(request))

  def getLifecyclePolicy(
    request: GetLifecyclePolicyRequest
  ): EcrIO[GetLifecyclePolicyResponse] =
    FF.liftF(GetLifecyclePolicyOp(request))

  def getLifecyclePolicyPreview(
    request: GetLifecyclePolicyPreviewRequest
  ): EcrIO[GetLifecyclePolicyPreviewResponse] =
    FF.liftF(GetLifecyclePolicyPreviewOp(request))

  def getRegistryPolicy(
    request: GetRegistryPolicyRequest
  ): EcrIO[GetRegistryPolicyResponse] =
    FF.liftF(GetRegistryPolicyOp(request))

  def getRepositoryPolicy(
    request: GetRepositoryPolicyRequest
  ): EcrIO[GetRepositoryPolicyResponse] =
    FF.liftF(GetRepositoryPolicyOp(request))

  def initiateLayerUpload(
    request: InitiateLayerUploadRequest
  ): EcrIO[InitiateLayerUploadResponse] =
    FF.liftF(InitiateLayerUploadOp(request))

  def listImages(
    request: ListImagesRequest
  ): EcrIO[ListImagesResponse] =
    FF.liftF(ListImagesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): EcrIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putImage(
    request: PutImageRequest
  ): EcrIO[PutImageResponse] =
    FF.liftF(PutImageOp(request))

  def putImageScanningConfiguration(
    request: PutImageScanningConfigurationRequest
  ): EcrIO[PutImageScanningConfigurationResponse] =
    FF.liftF(PutImageScanningConfigurationOp(request))

  def putImageTagMutability(
    request: PutImageTagMutabilityRequest
  ): EcrIO[PutImageTagMutabilityResponse] =
    FF.liftF(PutImageTagMutabilityOp(request))

  def putLifecyclePolicy(
    request: PutLifecyclePolicyRequest
  ): EcrIO[PutLifecyclePolicyResponse] =
    FF.liftF(PutLifecyclePolicyOp(request))

  def putRegistryPolicy(
    request: PutRegistryPolicyRequest
  ): EcrIO[PutRegistryPolicyResponse] =
    FF.liftF(PutRegistryPolicyOp(request))

  def putReplicationConfiguration(
    request: PutReplicationConfigurationRequest
  ): EcrIO[PutReplicationConfigurationResponse] =
    FF.liftF(PutReplicationConfigurationOp(request))

  def setRepositoryPolicy(
    request: SetRepositoryPolicyRequest
  ): EcrIO[SetRepositoryPolicyResponse] =
    FF.liftF(SetRepositoryPolicyOp(request))

  def startImageScan(
    request: StartImageScanRequest
  ): EcrIO[StartImageScanResponse] =
    FF.liftF(StartImageScanOp(request))

  def startLifecyclePolicyPreview(
    request: StartLifecyclePolicyPreviewRequest
  ): EcrIO[StartLifecyclePolicyPreviewResponse] =
    FF.liftF(StartLifecyclePolicyPreviewOp(request))

  def tagResource(
    request: TagResourceRequest
  ): EcrIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): EcrIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def uploadLayerPart(
    request: UploadLayerPartRequest
  ): EcrIO[UploadLayerPartResponse] =
    FF.liftF(UploadLayerPartOp(request))
}
