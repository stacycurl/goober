package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.imagebuilder.ImagebuilderClient
import software.amazon.awssdk.services.imagebuilder.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object imagebuilder { module =>

  // Free monad over ImagebuilderOp
  type ImagebuilderIO[A] = FF[ImagebuilderOp, A]

  sealed trait ImagebuilderOp[A] {
    def visit[F[_]](visitor: ImagebuilderOp.Visitor[F]): F[A]
  }

  object ImagebuilderOp {
    // Given a ImagebuilderClient we can embed a ImagebuilderIO program in any algebra that understands embedding.
    implicit val ImagebuilderOpEmbeddable: Embeddable[ImagebuilderOp, ImagebuilderClient] = new Embeddable[ImagebuilderOp, ImagebuilderClient] {
      def embed[A](client: ImagebuilderClient, io: ImagebuilderIO[A]): Embedded[A] = Embedded.Imagebuilder(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ImagebuilderOp.Visitor[Kleisli[M, ImagebuilderClient, *]] {
        def cancelImageCreation(
          request: CancelImageCreationRequest
        ): Kleisli[M, ImagebuilderClient, CancelImageCreationResponse] =
          primitive(_.cancelImageCreation(request))

        def createComponent(
          request: CreateComponentRequest
        ): Kleisli[M, ImagebuilderClient, CreateComponentResponse] =
          primitive(_.createComponent(request))

        def createContainerRecipe(
          request: CreateContainerRecipeRequest
        ): Kleisli[M, ImagebuilderClient, CreateContainerRecipeResponse] =
          primitive(_.createContainerRecipe(request))

        def createDistributionConfiguration(
          request: CreateDistributionConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, CreateDistributionConfigurationResponse] =
          primitive(_.createDistributionConfiguration(request))

        def createImage(
          request: CreateImageRequest
        ): Kleisli[M, ImagebuilderClient, CreateImageResponse] =
          primitive(_.createImage(request))

        def createImagePipeline(
          request: CreateImagePipelineRequest
        ): Kleisli[M, ImagebuilderClient, CreateImagePipelineResponse] =
          primitive(_.createImagePipeline(request))

        def createImageRecipe(
          request: CreateImageRecipeRequest
        ): Kleisli[M, ImagebuilderClient, CreateImageRecipeResponse] =
          primitive(_.createImageRecipe(request))

        def createInfrastructureConfiguration(
          request: CreateInfrastructureConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, CreateInfrastructureConfigurationResponse] =
          primitive(_.createInfrastructureConfiguration(request))

        def deleteComponent(
          request: DeleteComponentRequest
        ): Kleisli[M, ImagebuilderClient, DeleteComponentResponse] =
          primitive(_.deleteComponent(request))

        def deleteContainerRecipe(
          request: DeleteContainerRecipeRequest
        ): Kleisli[M, ImagebuilderClient, DeleteContainerRecipeResponse] =
          primitive(_.deleteContainerRecipe(request))

        def deleteDistributionConfiguration(
          request: DeleteDistributionConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, DeleteDistributionConfigurationResponse] =
          primitive(_.deleteDistributionConfiguration(request))

        def deleteImage(
          request: DeleteImageRequest
        ): Kleisli[M, ImagebuilderClient, DeleteImageResponse] =
          primitive(_.deleteImage(request))

        def deleteImagePipeline(
          request: DeleteImagePipelineRequest
        ): Kleisli[M, ImagebuilderClient, DeleteImagePipelineResponse] =
          primitive(_.deleteImagePipeline(request))

        def deleteImageRecipe(
          request: DeleteImageRecipeRequest
        ): Kleisli[M, ImagebuilderClient, DeleteImageRecipeResponse] =
          primitive(_.deleteImageRecipe(request))

        def deleteInfrastructureConfiguration(
          request: DeleteInfrastructureConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, DeleteInfrastructureConfigurationResponse] =
          primitive(_.deleteInfrastructureConfiguration(request))

        def getComponent(
          request: GetComponentRequest
        ): Kleisli[M, ImagebuilderClient, GetComponentResponse] =
          primitive(_.getComponent(request))

        def getComponentPolicy(
          request: GetComponentPolicyRequest
        ): Kleisli[M, ImagebuilderClient, GetComponentPolicyResponse] =
          primitive(_.getComponentPolicy(request))

        def getContainerRecipe(
          request: GetContainerRecipeRequest
        ): Kleisli[M, ImagebuilderClient, GetContainerRecipeResponse] =
          primitive(_.getContainerRecipe(request))

        def getContainerRecipePolicy(
          request: GetContainerRecipePolicyRequest
        ): Kleisli[M, ImagebuilderClient, GetContainerRecipePolicyResponse] =
          primitive(_.getContainerRecipePolicy(request))

        def getDistributionConfiguration(
          request: GetDistributionConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, GetDistributionConfigurationResponse] =
          primitive(_.getDistributionConfiguration(request))

        def getImage(
          request: GetImageRequest
        ): Kleisli[M, ImagebuilderClient, GetImageResponse] =
          primitive(_.getImage(request))

        def getImagePipeline(
          request: GetImagePipelineRequest
        ): Kleisli[M, ImagebuilderClient, GetImagePipelineResponse] =
          primitive(_.getImagePipeline(request))

        def getImagePolicy(
          request: GetImagePolicyRequest
        ): Kleisli[M, ImagebuilderClient, GetImagePolicyResponse] =
          primitive(_.getImagePolicy(request))

        def getImageRecipe(
          request: GetImageRecipeRequest
        ): Kleisli[M, ImagebuilderClient, GetImageRecipeResponse] =
          primitive(_.getImageRecipe(request))

        def getImageRecipePolicy(
          request: GetImageRecipePolicyRequest
        ): Kleisli[M, ImagebuilderClient, GetImageRecipePolicyResponse] =
          primitive(_.getImageRecipePolicy(request))

        def getInfrastructureConfiguration(
          request: GetInfrastructureConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, GetInfrastructureConfigurationResponse] =
          primitive(_.getInfrastructureConfiguration(request))

        def importComponent(
          request: ImportComponentRequest
        ): Kleisli[M, ImagebuilderClient, ImportComponentResponse] =
          primitive(_.importComponent(request))

        def listComponentBuildVersions(
          request: ListComponentBuildVersionsRequest
        ): Kleisli[M, ImagebuilderClient, ListComponentBuildVersionsResponse] =
          primitive(_.listComponentBuildVersions(request))

        def listComponents(
          request: ListComponentsRequest
        ): Kleisli[M, ImagebuilderClient, ListComponentsResponse] =
          primitive(_.listComponents(request))

        def listContainerRecipes(
          request: ListContainerRecipesRequest
        ): Kleisli[M, ImagebuilderClient, ListContainerRecipesResponse] =
          primitive(_.listContainerRecipes(request))

        def listDistributionConfigurations(
          request: ListDistributionConfigurationsRequest
        ): Kleisli[M, ImagebuilderClient, ListDistributionConfigurationsResponse] =
          primitive(_.listDistributionConfigurations(request))

        def listImageBuildVersions(
          request: ListImageBuildVersionsRequest
        ): Kleisli[M, ImagebuilderClient, ListImageBuildVersionsResponse] =
          primitive(_.listImageBuildVersions(request))

        def listImagePackages(
          request: ListImagePackagesRequest
        ): Kleisli[M, ImagebuilderClient, ListImagePackagesResponse] =
          primitive(_.listImagePackages(request))

        def listImagePipelineImages(
          request: ListImagePipelineImagesRequest
        ): Kleisli[M, ImagebuilderClient, ListImagePipelineImagesResponse] =
          primitive(_.listImagePipelineImages(request))

        def listImagePipelines(
          request: ListImagePipelinesRequest
        ): Kleisli[M, ImagebuilderClient, ListImagePipelinesResponse] =
          primitive(_.listImagePipelines(request))

        def listImageRecipes(
          request: ListImageRecipesRequest
        ): Kleisli[M, ImagebuilderClient, ListImageRecipesResponse] =
          primitive(_.listImageRecipes(request))

        def listImages(
          request: ListImagesRequest
        ): Kleisli[M, ImagebuilderClient, ListImagesResponse] =
          primitive(_.listImages(request))

        def listInfrastructureConfigurations(
          request: ListInfrastructureConfigurationsRequest
        ): Kleisli[M, ImagebuilderClient, ListInfrastructureConfigurationsResponse] =
          primitive(_.listInfrastructureConfigurations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ImagebuilderClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putComponentPolicy(
          request: PutComponentPolicyRequest
        ): Kleisli[M, ImagebuilderClient, PutComponentPolicyResponse] =
          primitive(_.putComponentPolicy(request))

        def putContainerRecipePolicy(
          request: PutContainerRecipePolicyRequest
        ): Kleisli[M, ImagebuilderClient, PutContainerRecipePolicyResponse] =
          primitive(_.putContainerRecipePolicy(request))

        def putImagePolicy(
          request: PutImagePolicyRequest
        ): Kleisli[M, ImagebuilderClient, PutImagePolicyResponse] =
          primitive(_.putImagePolicy(request))

        def putImageRecipePolicy(
          request: PutImageRecipePolicyRequest
        ): Kleisli[M, ImagebuilderClient, PutImageRecipePolicyResponse] =
          primitive(_.putImageRecipePolicy(request))

        def startImagePipelineExecution(
          request: StartImagePipelineExecutionRequest
        ): Kleisli[M, ImagebuilderClient, StartImagePipelineExecutionResponse] =
          primitive(_.startImagePipelineExecution(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ImagebuilderClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ImagebuilderClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDistributionConfiguration(
          request: UpdateDistributionConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, UpdateDistributionConfigurationResponse] =
          primitive(_.updateDistributionConfiguration(request))

        def updateImagePipeline(
          request: UpdateImagePipelineRequest
        ): Kleisli[M, ImagebuilderClient, UpdateImagePipelineResponse] =
          primitive(_.updateImagePipeline(request))

        def updateInfrastructureConfiguration(
          request: UpdateInfrastructureConfigurationRequest
        ): Kleisli[M, ImagebuilderClient, UpdateInfrastructureConfigurationResponse] =
          primitive(_.updateInfrastructureConfiguration(request))

        def primitive[A](
          f: ImagebuilderClient => A
        ): Kleisli[M, ImagebuilderClient, A]
      }
    }

    trait Visitor[F[_]] extends (ImagebuilderOp ~> F) {
      final def apply[A](op: ImagebuilderOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelImageCreation(
        request: CancelImageCreationRequest
      ): F[CancelImageCreationResponse]

      def createComponent(
        request: CreateComponentRequest
      ): F[CreateComponentResponse]

      def createContainerRecipe(
        request: CreateContainerRecipeRequest
      ): F[CreateContainerRecipeResponse]

      def createDistributionConfiguration(
        request: CreateDistributionConfigurationRequest
      ): F[CreateDistributionConfigurationResponse]

      def createImage(
        request: CreateImageRequest
      ): F[CreateImageResponse]

      def createImagePipeline(
        request: CreateImagePipelineRequest
      ): F[CreateImagePipelineResponse]

      def createImageRecipe(
        request: CreateImageRecipeRequest
      ): F[CreateImageRecipeResponse]

      def createInfrastructureConfiguration(
        request: CreateInfrastructureConfigurationRequest
      ): F[CreateInfrastructureConfigurationResponse]

      def deleteComponent(
        request: DeleteComponentRequest
      ): F[DeleteComponentResponse]

      def deleteContainerRecipe(
        request: DeleteContainerRecipeRequest
      ): F[DeleteContainerRecipeResponse]

      def deleteDistributionConfiguration(
        request: DeleteDistributionConfigurationRequest
      ): F[DeleteDistributionConfigurationResponse]

      def deleteImage(
        request: DeleteImageRequest
      ): F[DeleteImageResponse]

      def deleteImagePipeline(
        request: DeleteImagePipelineRequest
      ): F[DeleteImagePipelineResponse]

      def deleteImageRecipe(
        request: DeleteImageRecipeRequest
      ): F[DeleteImageRecipeResponse]

      def deleteInfrastructureConfiguration(
        request: DeleteInfrastructureConfigurationRequest
      ): F[DeleteInfrastructureConfigurationResponse]

      def getComponent(
        request: GetComponentRequest
      ): F[GetComponentResponse]

      def getComponentPolicy(
        request: GetComponentPolicyRequest
      ): F[GetComponentPolicyResponse]

      def getContainerRecipe(
        request: GetContainerRecipeRequest
      ): F[GetContainerRecipeResponse]

      def getContainerRecipePolicy(
        request: GetContainerRecipePolicyRequest
      ): F[GetContainerRecipePolicyResponse]

      def getDistributionConfiguration(
        request: GetDistributionConfigurationRequest
      ): F[GetDistributionConfigurationResponse]

      def getImage(
        request: GetImageRequest
      ): F[GetImageResponse]

      def getImagePipeline(
        request: GetImagePipelineRequest
      ): F[GetImagePipelineResponse]

      def getImagePolicy(
        request: GetImagePolicyRequest
      ): F[GetImagePolicyResponse]

      def getImageRecipe(
        request: GetImageRecipeRequest
      ): F[GetImageRecipeResponse]

      def getImageRecipePolicy(
        request: GetImageRecipePolicyRequest
      ): F[GetImageRecipePolicyResponse]

      def getInfrastructureConfiguration(
        request: GetInfrastructureConfigurationRequest
      ): F[GetInfrastructureConfigurationResponse]

      def importComponent(
        request: ImportComponentRequest
      ): F[ImportComponentResponse]

      def listComponentBuildVersions(
        request: ListComponentBuildVersionsRequest
      ): F[ListComponentBuildVersionsResponse]

      def listComponents(
        request: ListComponentsRequest
      ): F[ListComponentsResponse]

      def listContainerRecipes(
        request: ListContainerRecipesRequest
      ): F[ListContainerRecipesResponse]

      def listDistributionConfigurations(
        request: ListDistributionConfigurationsRequest
      ): F[ListDistributionConfigurationsResponse]

      def listImageBuildVersions(
        request: ListImageBuildVersionsRequest
      ): F[ListImageBuildVersionsResponse]

      def listImagePackages(
        request: ListImagePackagesRequest
      ): F[ListImagePackagesResponse]

      def listImagePipelineImages(
        request: ListImagePipelineImagesRequest
      ): F[ListImagePipelineImagesResponse]

      def listImagePipelines(
        request: ListImagePipelinesRequest
      ): F[ListImagePipelinesResponse]

      def listImageRecipes(
        request: ListImageRecipesRequest
      ): F[ListImageRecipesResponse]

      def listImages(
        request: ListImagesRequest
      ): F[ListImagesResponse]

      def listInfrastructureConfigurations(
        request: ListInfrastructureConfigurationsRequest
      ): F[ListInfrastructureConfigurationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putComponentPolicy(
        request: PutComponentPolicyRequest
      ): F[PutComponentPolicyResponse]

      def putContainerRecipePolicy(
        request: PutContainerRecipePolicyRequest
      ): F[PutContainerRecipePolicyResponse]

      def putImagePolicy(
        request: PutImagePolicyRequest
      ): F[PutImagePolicyResponse]

      def putImageRecipePolicy(
        request: PutImageRecipePolicyRequest
      ): F[PutImageRecipePolicyResponse]

      def startImagePipelineExecution(
        request: StartImagePipelineExecutionRequest
      ): F[StartImagePipelineExecutionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDistributionConfiguration(
        request: UpdateDistributionConfigurationRequest
      ): F[UpdateDistributionConfigurationResponse]

      def updateImagePipeline(
        request: UpdateImagePipelineRequest
      ): F[UpdateImagePipelineResponse]

      def updateInfrastructureConfiguration(
        request: UpdateInfrastructureConfigurationRequest
      ): F[UpdateInfrastructureConfigurationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ImagebuilderOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelImageCreationOp(
      request: CancelImageCreationRequest
    ) extends ImagebuilderOp[CancelImageCreationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelImageCreationResponse] =
        visitor.cancelImageCreation(request)
    }

    final case class CreateComponentOp(
      request: CreateComponentRequest
    ) extends ImagebuilderOp[CreateComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateComponentResponse] =
        visitor.createComponent(request)
    }

    final case class CreateContainerRecipeOp(
      request: CreateContainerRecipeRequest
    ) extends ImagebuilderOp[CreateContainerRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContainerRecipeResponse] =
        visitor.createContainerRecipe(request)
    }

    final case class CreateDistributionConfigurationOp(
      request: CreateDistributionConfigurationRequest
    ) extends ImagebuilderOp[CreateDistributionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDistributionConfigurationResponse] =
        visitor.createDistributionConfiguration(request)
    }

    final case class CreateImageOp(
      request: CreateImageRequest
    ) extends ImagebuilderOp[CreateImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImageResponse] =
        visitor.createImage(request)
    }

    final case class CreateImagePipelineOp(
      request: CreateImagePipelineRequest
    ) extends ImagebuilderOp[CreateImagePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImagePipelineResponse] =
        visitor.createImagePipeline(request)
    }

    final case class CreateImageRecipeOp(
      request: CreateImageRecipeRequest
    ) extends ImagebuilderOp[CreateImageRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImageRecipeResponse] =
        visitor.createImageRecipe(request)
    }

    final case class CreateInfrastructureConfigurationOp(
      request: CreateInfrastructureConfigurationRequest
    ) extends ImagebuilderOp[CreateInfrastructureConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInfrastructureConfigurationResponse] =
        visitor.createInfrastructureConfiguration(request)
    }

    final case class DeleteComponentOp(
      request: DeleteComponentRequest
    ) extends ImagebuilderOp[DeleteComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteComponentResponse] =
        visitor.deleteComponent(request)
    }

    final case class DeleteContainerRecipeOp(
      request: DeleteContainerRecipeRequest
    ) extends ImagebuilderOp[DeleteContainerRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContainerRecipeResponse] =
        visitor.deleteContainerRecipe(request)
    }

    final case class DeleteDistributionConfigurationOp(
      request: DeleteDistributionConfigurationRequest
    ) extends ImagebuilderOp[DeleteDistributionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDistributionConfigurationResponse] =
        visitor.deleteDistributionConfiguration(request)
    }

    final case class DeleteImageOp(
      request: DeleteImageRequest
    ) extends ImagebuilderOp[DeleteImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImageResponse] =
        visitor.deleteImage(request)
    }

    final case class DeleteImagePipelineOp(
      request: DeleteImagePipelineRequest
    ) extends ImagebuilderOp[DeleteImagePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImagePipelineResponse] =
        visitor.deleteImagePipeline(request)
    }

    final case class DeleteImageRecipeOp(
      request: DeleteImageRecipeRequest
    ) extends ImagebuilderOp[DeleteImageRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImageRecipeResponse] =
        visitor.deleteImageRecipe(request)
    }

    final case class DeleteInfrastructureConfigurationOp(
      request: DeleteInfrastructureConfigurationRequest
    ) extends ImagebuilderOp[DeleteInfrastructureConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInfrastructureConfigurationResponse] =
        visitor.deleteInfrastructureConfiguration(request)
    }

    final case class GetComponentOp(
      request: GetComponentRequest
    ) extends ImagebuilderOp[GetComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComponentResponse] =
        visitor.getComponent(request)
    }

    final case class GetComponentPolicyOp(
      request: GetComponentPolicyRequest
    ) extends ImagebuilderOp[GetComponentPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComponentPolicyResponse] =
        visitor.getComponentPolicy(request)
    }

    final case class GetContainerRecipeOp(
      request: GetContainerRecipeRequest
    ) extends ImagebuilderOp[GetContainerRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerRecipeResponse] =
        visitor.getContainerRecipe(request)
    }

    final case class GetContainerRecipePolicyOp(
      request: GetContainerRecipePolicyRequest
    ) extends ImagebuilderOp[GetContainerRecipePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContainerRecipePolicyResponse] =
        visitor.getContainerRecipePolicy(request)
    }

    final case class GetDistributionConfigurationOp(
      request: GetDistributionConfigurationRequest
    ) extends ImagebuilderOp[GetDistributionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDistributionConfigurationResponse] =
        visitor.getDistributionConfiguration(request)
    }

    final case class GetImageOp(
      request: GetImageRequest
    ) extends ImagebuilderOp[GetImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImageResponse] =
        visitor.getImage(request)
    }

    final case class GetImagePipelineOp(
      request: GetImagePipelineRequest
    ) extends ImagebuilderOp[GetImagePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImagePipelineResponse] =
        visitor.getImagePipeline(request)
    }

    final case class GetImagePolicyOp(
      request: GetImagePolicyRequest
    ) extends ImagebuilderOp[GetImagePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImagePolicyResponse] =
        visitor.getImagePolicy(request)
    }

    final case class GetImageRecipeOp(
      request: GetImageRecipeRequest
    ) extends ImagebuilderOp[GetImageRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImageRecipeResponse] =
        visitor.getImageRecipe(request)
    }

    final case class GetImageRecipePolicyOp(
      request: GetImageRecipePolicyRequest
    ) extends ImagebuilderOp[GetImageRecipePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetImageRecipePolicyResponse] =
        visitor.getImageRecipePolicy(request)
    }

    final case class GetInfrastructureConfigurationOp(
      request: GetInfrastructureConfigurationRequest
    ) extends ImagebuilderOp[GetInfrastructureConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInfrastructureConfigurationResponse] =
        visitor.getInfrastructureConfiguration(request)
    }

    final case class ImportComponentOp(
      request: ImportComponentRequest
    ) extends ImagebuilderOp[ImportComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportComponentResponse] =
        visitor.importComponent(request)
    }

    final case class ListComponentBuildVersionsOp(
      request: ListComponentBuildVersionsRequest
    ) extends ImagebuilderOp[ListComponentBuildVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComponentBuildVersionsResponse] =
        visitor.listComponentBuildVersions(request)
    }

    final case class ListComponentsOp(
      request: ListComponentsRequest
    ) extends ImagebuilderOp[ListComponentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComponentsResponse] =
        visitor.listComponents(request)
    }

    final case class ListContainerRecipesOp(
      request: ListContainerRecipesRequest
    ) extends ImagebuilderOp[ListContainerRecipesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContainerRecipesResponse] =
        visitor.listContainerRecipes(request)
    }

    final case class ListDistributionConfigurationsOp(
      request: ListDistributionConfigurationsRequest
    ) extends ImagebuilderOp[ListDistributionConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributionConfigurationsResponse] =
        visitor.listDistributionConfigurations(request)
    }

    final case class ListImageBuildVersionsOp(
      request: ListImageBuildVersionsRequest
    ) extends ImagebuilderOp[ListImageBuildVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImageBuildVersionsResponse] =
        visitor.listImageBuildVersions(request)
    }

    final case class ListImagePackagesOp(
      request: ListImagePackagesRequest
    ) extends ImagebuilderOp[ListImagePackagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImagePackagesResponse] =
        visitor.listImagePackages(request)
    }

    final case class ListImagePipelineImagesOp(
      request: ListImagePipelineImagesRequest
    ) extends ImagebuilderOp[ListImagePipelineImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImagePipelineImagesResponse] =
        visitor.listImagePipelineImages(request)
    }

    final case class ListImagePipelinesOp(
      request: ListImagePipelinesRequest
    ) extends ImagebuilderOp[ListImagePipelinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImagePipelinesResponse] =
        visitor.listImagePipelines(request)
    }

    final case class ListImageRecipesOp(
      request: ListImageRecipesRequest
    ) extends ImagebuilderOp[ListImageRecipesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImageRecipesResponse] =
        visitor.listImageRecipes(request)
    }

    final case class ListImagesOp(
      request: ListImagesRequest
    ) extends ImagebuilderOp[ListImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImagesResponse] =
        visitor.listImages(request)
    }

    final case class ListInfrastructureConfigurationsOp(
      request: ListInfrastructureConfigurationsRequest
    ) extends ImagebuilderOp[ListInfrastructureConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInfrastructureConfigurationsResponse] =
        visitor.listInfrastructureConfigurations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ImagebuilderOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutComponentPolicyOp(
      request: PutComponentPolicyRequest
    ) extends ImagebuilderOp[PutComponentPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutComponentPolicyResponse] =
        visitor.putComponentPolicy(request)
    }

    final case class PutContainerRecipePolicyOp(
      request: PutContainerRecipePolicyRequest
    ) extends ImagebuilderOp[PutContainerRecipePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutContainerRecipePolicyResponse] =
        visitor.putContainerRecipePolicy(request)
    }

    final case class PutImagePolicyOp(
      request: PutImagePolicyRequest
    ) extends ImagebuilderOp[PutImagePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutImagePolicyResponse] =
        visitor.putImagePolicy(request)
    }

    final case class PutImageRecipePolicyOp(
      request: PutImageRecipePolicyRequest
    ) extends ImagebuilderOp[PutImageRecipePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutImageRecipePolicyResponse] =
        visitor.putImageRecipePolicy(request)
    }

    final case class StartImagePipelineExecutionOp(
      request: StartImagePipelineExecutionRequest
    ) extends ImagebuilderOp[StartImagePipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartImagePipelineExecutionResponse] =
        visitor.startImagePipelineExecution(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ImagebuilderOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ImagebuilderOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDistributionConfigurationOp(
      request: UpdateDistributionConfigurationRequest
    ) extends ImagebuilderOp[UpdateDistributionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDistributionConfigurationResponse] =
        visitor.updateDistributionConfiguration(request)
    }

    final case class UpdateImagePipelineOp(
      request: UpdateImagePipelineRequest
    ) extends ImagebuilderOp[UpdateImagePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateImagePipelineResponse] =
        visitor.updateImagePipeline(request)
    }

    final case class UpdateInfrastructureConfigurationOp(
      request: UpdateInfrastructureConfigurationRequest
    ) extends ImagebuilderOp[UpdateInfrastructureConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInfrastructureConfigurationResponse] =
        visitor.updateInfrastructureConfiguration(request)
    }
  }

  import ImagebuilderOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ImagebuilderOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelImageCreation(
    request: CancelImageCreationRequest
  ): ImagebuilderIO[CancelImageCreationResponse] =
    FF.liftF(CancelImageCreationOp(request))

  def createComponent(
    request: CreateComponentRequest
  ): ImagebuilderIO[CreateComponentResponse] =
    FF.liftF(CreateComponentOp(request))

  def createContainerRecipe(
    request: CreateContainerRecipeRequest
  ): ImagebuilderIO[CreateContainerRecipeResponse] =
    FF.liftF(CreateContainerRecipeOp(request))

  def createDistributionConfiguration(
    request: CreateDistributionConfigurationRequest
  ): ImagebuilderIO[CreateDistributionConfigurationResponse] =
    FF.liftF(CreateDistributionConfigurationOp(request))

  def createImage(
    request: CreateImageRequest
  ): ImagebuilderIO[CreateImageResponse] =
    FF.liftF(CreateImageOp(request))

  def createImagePipeline(
    request: CreateImagePipelineRequest
  ): ImagebuilderIO[CreateImagePipelineResponse] =
    FF.liftF(CreateImagePipelineOp(request))

  def createImageRecipe(
    request: CreateImageRecipeRequest
  ): ImagebuilderIO[CreateImageRecipeResponse] =
    FF.liftF(CreateImageRecipeOp(request))

  def createInfrastructureConfiguration(
    request: CreateInfrastructureConfigurationRequest
  ): ImagebuilderIO[CreateInfrastructureConfigurationResponse] =
    FF.liftF(CreateInfrastructureConfigurationOp(request))

  def deleteComponent(
    request: DeleteComponentRequest
  ): ImagebuilderIO[DeleteComponentResponse] =
    FF.liftF(DeleteComponentOp(request))

  def deleteContainerRecipe(
    request: DeleteContainerRecipeRequest
  ): ImagebuilderIO[DeleteContainerRecipeResponse] =
    FF.liftF(DeleteContainerRecipeOp(request))

  def deleteDistributionConfiguration(
    request: DeleteDistributionConfigurationRequest
  ): ImagebuilderIO[DeleteDistributionConfigurationResponse] =
    FF.liftF(DeleteDistributionConfigurationOp(request))

  def deleteImage(
    request: DeleteImageRequest
  ): ImagebuilderIO[DeleteImageResponse] =
    FF.liftF(DeleteImageOp(request))

  def deleteImagePipeline(
    request: DeleteImagePipelineRequest
  ): ImagebuilderIO[DeleteImagePipelineResponse] =
    FF.liftF(DeleteImagePipelineOp(request))

  def deleteImageRecipe(
    request: DeleteImageRecipeRequest
  ): ImagebuilderIO[DeleteImageRecipeResponse] =
    FF.liftF(DeleteImageRecipeOp(request))

  def deleteInfrastructureConfiguration(
    request: DeleteInfrastructureConfigurationRequest
  ): ImagebuilderIO[DeleteInfrastructureConfigurationResponse] =
    FF.liftF(DeleteInfrastructureConfigurationOp(request))

  def getComponent(
    request: GetComponentRequest
  ): ImagebuilderIO[GetComponentResponse] =
    FF.liftF(GetComponentOp(request))

  def getComponentPolicy(
    request: GetComponentPolicyRequest
  ): ImagebuilderIO[GetComponentPolicyResponse] =
    FF.liftF(GetComponentPolicyOp(request))

  def getContainerRecipe(
    request: GetContainerRecipeRequest
  ): ImagebuilderIO[GetContainerRecipeResponse] =
    FF.liftF(GetContainerRecipeOp(request))

  def getContainerRecipePolicy(
    request: GetContainerRecipePolicyRequest
  ): ImagebuilderIO[GetContainerRecipePolicyResponse] =
    FF.liftF(GetContainerRecipePolicyOp(request))

  def getDistributionConfiguration(
    request: GetDistributionConfigurationRequest
  ): ImagebuilderIO[GetDistributionConfigurationResponse] =
    FF.liftF(GetDistributionConfigurationOp(request))

  def getImage(
    request: GetImageRequest
  ): ImagebuilderIO[GetImageResponse] =
    FF.liftF(GetImageOp(request))

  def getImagePipeline(
    request: GetImagePipelineRequest
  ): ImagebuilderIO[GetImagePipelineResponse] =
    FF.liftF(GetImagePipelineOp(request))

  def getImagePolicy(
    request: GetImagePolicyRequest
  ): ImagebuilderIO[GetImagePolicyResponse] =
    FF.liftF(GetImagePolicyOp(request))

  def getImageRecipe(
    request: GetImageRecipeRequest
  ): ImagebuilderIO[GetImageRecipeResponse] =
    FF.liftF(GetImageRecipeOp(request))

  def getImageRecipePolicy(
    request: GetImageRecipePolicyRequest
  ): ImagebuilderIO[GetImageRecipePolicyResponse] =
    FF.liftF(GetImageRecipePolicyOp(request))

  def getInfrastructureConfiguration(
    request: GetInfrastructureConfigurationRequest
  ): ImagebuilderIO[GetInfrastructureConfigurationResponse] =
    FF.liftF(GetInfrastructureConfigurationOp(request))

  def importComponent(
    request: ImportComponentRequest
  ): ImagebuilderIO[ImportComponentResponse] =
    FF.liftF(ImportComponentOp(request))

  def listComponentBuildVersions(
    request: ListComponentBuildVersionsRequest
  ): ImagebuilderIO[ListComponentBuildVersionsResponse] =
    FF.liftF(ListComponentBuildVersionsOp(request))

  def listComponents(
    request: ListComponentsRequest
  ): ImagebuilderIO[ListComponentsResponse] =
    FF.liftF(ListComponentsOp(request))

  def listContainerRecipes(
    request: ListContainerRecipesRequest
  ): ImagebuilderIO[ListContainerRecipesResponse] =
    FF.liftF(ListContainerRecipesOp(request))

  def listDistributionConfigurations(
    request: ListDistributionConfigurationsRequest
  ): ImagebuilderIO[ListDistributionConfigurationsResponse] =
    FF.liftF(ListDistributionConfigurationsOp(request))

  def listImageBuildVersions(
    request: ListImageBuildVersionsRequest
  ): ImagebuilderIO[ListImageBuildVersionsResponse] =
    FF.liftF(ListImageBuildVersionsOp(request))

  def listImagePackages(
    request: ListImagePackagesRequest
  ): ImagebuilderIO[ListImagePackagesResponse] =
    FF.liftF(ListImagePackagesOp(request))

  def listImagePipelineImages(
    request: ListImagePipelineImagesRequest
  ): ImagebuilderIO[ListImagePipelineImagesResponse] =
    FF.liftF(ListImagePipelineImagesOp(request))

  def listImagePipelines(
    request: ListImagePipelinesRequest
  ): ImagebuilderIO[ListImagePipelinesResponse] =
    FF.liftF(ListImagePipelinesOp(request))

  def listImageRecipes(
    request: ListImageRecipesRequest
  ): ImagebuilderIO[ListImageRecipesResponse] =
    FF.liftF(ListImageRecipesOp(request))

  def listImages(
    request: ListImagesRequest
  ): ImagebuilderIO[ListImagesResponse] =
    FF.liftF(ListImagesOp(request))

  def listInfrastructureConfigurations(
    request: ListInfrastructureConfigurationsRequest
  ): ImagebuilderIO[ListInfrastructureConfigurationsResponse] =
    FF.liftF(ListInfrastructureConfigurationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ImagebuilderIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putComponentPolicy(
    request: PutComponentPolicyRequest
  ): ImagebuilderIO[PutComponentPolicyResponse] =
    FF.liftF(PutComponentPolicyOp(request))

  def putContainerRecipePolicy(
    request: PutContainerRecipePolicyRequest
  ): ImagebuilderIO[PutContainerRecipePolicyResponse] =
    FF.liftF(PutContainerRecipePolicyOp(request))

  def putImagePolicy(
    request: PutImagePolicyRequest
  ): ImagebuilderIO[PutImagePolicyResponse] =
    FF.liftF(PutImagePolicyOp(request))

  def putImageRecipePolicy(
    request: PutImageRecipePolicyRequest
  ): ImagebuilderIO[PutImageRecipePolicyResponse] =
    FF.liftF(PutImageRecipePolicyOp(request))

  def startImagePipelineExecution(
    request: StartImagePipelineExecutionRequest
  ): ImagebuilderIO[StartImagePipelineExecutionResponse] =
    FF.liftF(StartImagePipelineExecutionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ImagebuilderIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ImagebuilderIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDistributionConfiguration(
    request: UpdateDistributionConfigurationRequest
  ): ImagebuilderIO[UpdateDistributionConfigurationResponse] =
    FF.liftF(UpdateDistributionConfigurationOp(request))

  def updateImagePipeline(
    request: UpdateImagePipelineRequest
  ): ImagebuilderIO[UpdateImagePipelineResponse] =
    FF.liftF(UpdateImagePipelineOp(request))

  def updateInfrastructureConfiguration(
    request: UpdateInfrastructureConfigurationRequest
  ): ImagebuilderIO[UpdateInfrastructureConfigurationResponse] =
    FF.liftF(UpdateInfrastructureConfigurationOp(request))
}
