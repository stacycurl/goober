package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ecrpublic.EcrPublicClient
import software.amazon.awssdk.services.ecrpublic.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ecrpublic { module =>

  // Free monad over EcrPublicOp
  type EcrPublicIO[A] = FF[EcrPublicOp, A]

  sealed trait EcrPublicOp[A] {
    def visit[F[_]](visitor: EcrPublicOp.Visitor[F]): F[A]
  }

  object EcrPublicOp {
    // Given a EcrPublicClient we can embed a EcrPublicIO program in any algebra that understands embedding.
    implicit val EcrPublicOpEmbeddable: Embeddable[EcrPublicOp, EcrPublicClient] = new Embeddable[EcrPublicOp, EcrPublicClient] {
      def embed[A](client: EcrPublicClient, io: EcrPublicIO[A]): Embedded[A] = Embedded.EcrPublic(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EcrPublicOp.Visitor[Kleisli[M, EcrPublicClient, *]] {
        def batchCheckLayerAvailability(
          request: BatchCheckLayerAvailabilityRequest
        ): Kleisli[M, EcrPublicClient, BatchCheckLayerAvailabilityResponse] =
          primitive(_.batchCheckLayerAvailability(request))

        def batchDeleteImage(
          request: BatchDeleteImageRequest
        ): Kleisli[M, EcrPublicClient, BatchDeleteImageResponse] =
          primitive(_.batchDeleteImage(request))

        def completeLayerUpload(
          request: CompleteLayerUploadRequest
        ): Kleisli[M, EcrPublicClient, CompleteLayerUploadResponse] =
          primitive(_.completeLayerUpload(request))

        def createRepository(
          request: CreateRepositoryRequest
        ): Kleisli[M, EcrPublicClient, CreateRepositoryResponse] =
          primitive(_.createRepository(request))

        def deleteRepository(
          request: DeleteRepositoryRequest
        ): Kleisli[M, EcrPublicClient, DeleteRepositoryResponse] =
          primitive(_.deleteRepository(request))

        def deleteRepositoryPolicy(
          request: DeleteRepositoryPolicyRequest
        ): Kleisli[M, EcrPublicClient, DeleteRepositoryPolicyResponse] =
          primitive(_.deleteRepositoryPolicy(request))

        def describeImageTags(
          request: DescribeImageTagsRequest
        ): Kleisli[M, EcrPublicClient, DescribeImageTagsResponse] =
          primitive(_.describeImageTags(request))

        def describeImages(
          request: DescribeImagesRequest
        ): Kleisli[M, EcrPublicClient, DescribeImagesResponse] =
          primitive(_.describeImages(request))

        def describeRegistries(
          request: DescribeRegistriesRequest
        ): Kleisli[M, EcrPublicClient, DescribeRegistriesResponse] =
          primitive(_.describeRegistries(request))

        def describeRepositories(
          request: DescribeRepositoriesRequest
        ): Kleisli[M, EcrPublicClient, DescribeRepositoriesResponse] =
          primitive(_.describeRepositories(request))

        def getAuthorizationToken(
          request: GetAuthorizationTokenRequest
        ): Kleisli[M, EcrPublicClient, GetAuthorizationTokenResponse] =
          primitive(_.getAuthorizationToken(request))

        def getRegistryCatalogData(
          request: GetRegistryCatalogDataRequest
        ): Kleisli[M, EcrPublicClient, GetRegistryCatalogDataResponse] =
          primitive(_.getRegistryCatalogData(request))

        def getRepositoryCatalogData(
          request: GetRepositoryCatalogDataRequest
        ): Kleisli[M, EcrPublicClient, GetRepositoryCatalogDataResponse] =
          primitive(_.getRepositoryCatalogData(request))

        def getRepositoryPolicy(
          request: GetRepositoryPolicyRequest
        ): Kleisli[M, EcrPublicClient, GetRepositoryPolicyResponse] =
          primitive(_.getRepositoryPolicy(request))

        def initiateLayerUpload(
          request: InitiateLayerUploadRequest
        ): Kleisli[M, EcrPublicClient, InitiateLayerUploadResponse] =
          primitive(_.initiateLayerUpload(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, EcrPublicClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putImage(
          request: PutImageRequest
        ): Kleisli[M, EcrPublicClient, PutImageResponse] =
          primitive(_.putImage(request))

        def putRegistryCatalogData(
          request: PutRegistryCatalogDataRequest
        ): Kleisli[M, EcrPublicClient, PutRegistryCatalogDataResponse] =
          primitive(_.putRegistryCatalogData(request))

        def putRepositoryCatalogData(
          request: PutRepositoryCatalogDataRequest
        ): Kleisli[M, EcrPublicClient, PutRepositoryCatalogDataResponse] =
          primitive(_.putRepositoryCatalogData(request))

        def setRepositoryPolicy(
          request: SetRepositoryPolicyRequest
        ): Kleisli[M, EcrPublicClient, SetRepositoryPolicyResponse] =
          primitive(_.setRepositoryPolicy(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, EcrPublicClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, EcrPublicClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def uploadLayerPart(
          request: UploadLayerPartRequest
        ): Kleisli[M, EcrPublicClient, UploadLayerPartResponse] =
          primitive(_.uploadLayerPart(request))

        def primitive[A](
          f: EcrPublicClient => A
        ): Kleisli[M, EcrPublicClient, A]
      }
    }

    trait Visitor[F[_]] extends (EcrPublicOp ~> F) {
      final def apply[A](op: EcrPublicOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchCheckLayerAvailability(
        request: BatchCheckLayerAvailabilityRequest
      ): F[BatchCheckLayerAvailabilityResponse]

      def batchDeleteImage(
        request: BatchDeleteImageRequest
      ): F[BatchDeleteImageResponse]

      def completeLayerUpload(
        request: CompleteLayerUploadRequest
      ): F[CompleteLayerUploadResponse]

      def createRepository(
        request: CreateRepositoryRequest
      ): F[CreateRepositoryResponse]

      def deleteRepository(
        request: DeleteRepositoryRequest
      ): F[DeleteRepositoryResponse]

      def deleteRepositoryPolicy(
        request: DeleteRepositoryPolicyRequest
      ): F[DeleteRepositoryPolicyResponse]

      def describeImageTags(
        request: DescribeImageTagsRequest
      ): F[DescribeImageTagsResponse]

      def describeImages(
        request: DescribeImagesRequest
      ): F[DescribeImagesResponse]

      def describeRegistries(
        request: DescribeRegistriesRequest
      ): F[DescribeRegistriesResponse]

      def describeRepositories(
        request: DescribeRepositoriesRequest
      ): F[DescribeRepositoriesResponse]

      def getAuthorizationToken(
        request: GetAuthorizationTokenRequest
      ): F[GetAuthorizationTokenResponse]

      def getRegistryCatalogData(
        request: GetRegistryCatalogDataRequest
      ): F[GetRegistryCatalogDataResponse]

      def getRepositoryCatalogData(
        request: GetRepositoryCatalogDataRequest
      ): F[GetRepositoryCatalogDataResponse]

      def getRepositoryPolicy(
        request: GetRepositoryPolicyRequest
      ): F[GetRepositoryPolicyResponse]

      def initiateLayerUpload(
        request: InitiateLayerUploadRequest
      ): F[InitiateLayerUploadResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putImage(
        request: PutImageRequest
      ): F[PutImageResponse]

      def putRegistryCatalogData(
        request: PutRegistryCatalogDataRequest
      ): F[PutRegistryCatalogDataResponse]

      def putRepositoryCatalogData(
        request: PutRepositoryCatalogDataRequest
      ): F[PutRepositoryCatalogDataResponse]

      def setRepositoryPolicy(
        request: SetRepositoryPolicyRequest
      ): F[SetRepositoryPolicyResponse]

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
    ) extends EcrPublicOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchCheckLayerAvailabilityOp(
      request: BatchCheckLayerAvailabilityRequest
    ) extends EcrPublicOp[BatchCheckLayerAvailabilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCheckLayerAvailabilityResponse] =
        visitor.batchCheckLayerAvailability(request)
    }

    final case class BatchDeleteImageOp(
      request: BatchDeleteImageRequest
    ) extends EcrPublicOp[BatchDeleteImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteImageResponse] =
        visitor.batchDeleteImage(request)
    }

    final case class CompleteLayerUploadOp(
      request: CompleteLayerUploadRequest
    ) extends EcrPublicOp[CompleteLayerUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteLayerUploadResponse] =
        visitor.completeLayerUpload(request)
    }

    final case class CreateRepositoryOp(
      request: CreateRepositoryRequest
    ) extends EcrPublicOp[CreateRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRepositoryResponse] =
        visitor.createRepository(request)
    }

    final case class DeleteRepositoryOp(
      request: DeleteRepositoryRequest
    ) extends EcrPublicOp[DeleteRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRepositoryResponse] =
        visitor.deleteRepository(request)
    }

    final case class DeleteRepositoryPolicyOp(
      request: DeleteRepositoryPolicyRequest
    ) extends EcrPublicOp[DeleteRepositoryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRepositoryPolicyResponse] =
        visitor.deleteRepositoryPolicy(request)
    }

    final case class DescribeImageTagsOp(
      request: DescribeImageTagsRequest
    ) extends EcrPublicOp[DescribeImageTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImageTagsResponse] =
        visitor.describeImageTags(request)
    }

    final case class DescribeImagesOp(
      request: DescribeImagesRequest
    ) extends EcrPublicOp[DescribeImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImagesResponse] =
        visitor.describeImages(request)
    }

    final case class DescribeRegistriesOp(
      request: DescribeRegistriesRequest
    ) extends EcrPublicOp[DescribeRegistriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRegistriesResponse] =
        visitor.describeRegistries(request)
    }

    final case class DescribeRepositoriesOp(
      request: DescribeRepositoriesRequest
    ) extends EcrPublicOp[DescribeRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRepositoriesResponse] =
        visitor.describeRepositories(request)
    }

    final case class GetAuthorizationTokenOp(
      request: GetAuthorizationTokenRequest
    ) extends EcrPublicOp[GetAuthorizationTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAuthorizationTokenResponse] =
        visitor.getAuthorizationToken(request)
    }

    final case class GetRegistryCatalogDataOp(
      request: GetRegistryCatalogDataRequest
    ) extends EcrPublicOp[GetRegistryCatalogDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegistryCatalogDataResponse] =
        visitor.getRegistryCatalogData(request)
    }

    final case class GetRepositoryCatalogDataOp(
      request: GetRepositoryCatalogDataRequest
    ) extends EcrPublicOp[GetRepositoryCatalogDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRepositoryCatalogDataResponse] =
        visitor.getRepositoryCatalogData(request)
    }

    final case class GetRepositoryPolicyOp(
      request: GetRepositoryPolicyRequest
    ) extends EcrPublicOp[GetRepositoryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRepositoryPolicyResponse] =
        visitor.getRepositoryPolicy(request)
    }

    final case class InitiateLayerUploadOp(
      request: InitiateLayerUploadRequest
    ) extends EcrPublicOp[InitiateLayerUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateLayerUploadResponse] =
        visitor.initiateLayerUpload(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends EcrPublicOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutImageOp(
      request: PutImageRequest
    ) extends EcrPublicOp[PutImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutImageResponse] =
        visitor.putImage(request)
    }

    final case class PutRegistryCatalogDataOp(
      request: PutRegistryCatalogDataRequest
    ) extends EcrPublicOp[PutRegistryCatalogDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRegistryCatalogDataResponse] =
        visitor.putRegistryCatalogData(request)
    }

    final case class PutRepositoryCatalogDataOp(
      request: PutRepositoryCatalogDataRequest
    ) extends EcrPublicOp[PutRepositoryCatalogDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRepositoryCatalogDataResponse] =
        visitor.putRepositoryCatalogData(request)
    }

    final case class SetRepositoryPolicyOp(
      request: SetRepositoryPolicyRequest
    ) extends EcrPublicOp[SetRepositoryPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetRepositoryPolicyResponse] =
        visitor.setRepositoryPolicy(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends EcrPublicOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends EcrPublicOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UploadLayerPartOp(
      request: UploadLayerPartRequest
    ) extends EcrPublicOp[UploadLayerPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadLayerPartResponse] =
        visitor.uploadLayerPart(request)
    }
  }

  import EcrPublicOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EcrPublicOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchCheckLayerAvailability(
    request: BatchCheckLayerAvailabilityRequest
  ): EcrPublicIO[BatchCheckLayerAvailabilityResponse] =
    FF.liftF(BatchCheckLayerAvailabilityOp(request))

  def batchDeleteImage(
    request: BatchDeleteImageRequest
  ): EcrPublicIO[BatchDeleteImageResponse] =
    FF.liftF(BatchDeleteImageOp(request))

  def completeLayerUpload(
    request: CompleteLayerUploadRequest
  ): EcrPublicIO[CompleteLayerUploadResponse] =
    FF.liftF(CompleteLayerUploadOp(request))

  def createRepository(
    request: CreateRepositoryRequest
  ): EcrPublicIO[CreateRepositoryResponse] =
    FF.liftF(CreateRepositoryOp(request))

  def deleteRepository(
    request: DeleteRepositoryRequest
  ): EcrPublicIO[DeleteRepositoryResponse] =
    FF.liftF(DeleteRepositoryOp(request))

  def deleteRepositoryPolicy(
    request: DeleteRepositoryPolicyRequest
  ): EcrPublicIO[DeleteRepositoryPolicyResponse] =
    FF.liftF(DeleteRepositoryPolicyOp(request))

  def describeImageTags(
    request: DescribeImageTagsRequest
  ): EcrPublicIO[DescribeImageTagsResponse] =
    FF.liftF(DescribeImageTagsOp(request))

  def describeImages(
    request: DescribeImagesRequest
  ): EcrPublicIO[DescribeImagesResponse] =
    FF.liftF(DescribeImagesOp(request))

  def describeRegistries(
    request: DescribeRegistriesRequest
  ): EcrPublicIO[DescribeRegistriesResponse] =
    FF.liftF(DescribeRegistriesOp(request))

  def describeRepositories(
    request: DescribeRepositoriesRequest
  ): EcrPublicIO[DescribeRepositoriesResponse] =
    FF.liftF(DescribeRepositoriesOp(request))

  def getAuthorizationToken(
    request: GetAuthorizationTokenRequest
  ): EcrPublicIO[GetAuthorizationTokenResponse] =
    FF.liftF(GetAuthorizationTokenOp(request))

  def getRegistryCatalogData(
    request: GetRegistryCatalogDataRequest
  ): EcrPublicIO[GetRegistryCatalogDataResponse] =
    FF.liftF(GetRegistryCatalogDataOp(request))

  def getRepositoryCatalogData(
    request: GetRepositoryCatalogDataRequest
  ): EcrPublicIO[GetRepositoryCatalogDataResponse] =
    FF.liftF(GetRepositoryCatalogDataOp(request))

  def getRepositoryPolicy(
    request: GetRepositoryPolicyRequest
  ): EcrPublicIO[GetRepositoryPolicyResponse] =
    FF.liftF(GetRepositoryPolicyOp(request))

  def initiateLayerUpload(
    request: InitiateLayerUploadRequest
  ): EcrPublicIO[InitiateLayerUploadResponse] =
    FF.liftF(InitiateLayerUploadOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): EcrPublicIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putImage(
    request: PutImageRequest
  ): EcrPublicIO[PutImageResponse] =
    FF.liftF(PutImageOp(request))

  def putRegistryCatalogData(
    request: PutRegistryCatalogDataRequest
  ): EcrPublicIO[PutRegistryCatalogDataResponse] =
    FF.liftF(PutRegistryCatalogDataOp(request))

  def putRepositoryCatalogData(
    request: PutRepositoryCatalogDataRequest
  ): EcrPublicIO[PutRepositoryCatalogDataResponse] =
    FF.liftF(PutRepositoryCatalogDataOp(request))

  def setRepositoryPolicy(
    request: SetRepositoryPolicyRequest
  ): EcrPublicIO[SetRepositoryPolicyResponse] =
    FF.liftF(SetRepositoryPolicyOp(request))

  def tagResource(
    request: TagResourceRequest
  ): EcrPublicIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): EcrPublicIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def uploadLayerPart(
    request: UploadLayerPartRequest
  ): EcrPublicIO[UploadLayerPartResponse] =
    FF.liftF(UploadLayerPartOp(request))
}
