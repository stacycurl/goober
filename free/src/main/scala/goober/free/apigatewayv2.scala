package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.apigatewayv2.ApiGatewayV2Client
import software.amazon.awssdk.services.apigatewayv2.model._


object apigatewayv2 { module =>

  // Free monad over ApiGatewayV2Op
  type ApiGatewayV2IO[A] = FF[ApiGatewayV2Op, A]

  sealed trait ApiGatewayV2Op[A] {
    def visit[F[_]](visitor: ApiGatewayV2Op.Visitor[F]): F[A]
  }

  object ApiGatewayV2Op {
    // Given a ApiGatewayV2Client we can embed a ApiGatewayV2IO program in any algebra that understands embedding.
    implicit val ApiGatewayV2OpEmbeddable: Embeddable[ApiGatewayV2Op, ApiGatewayV2Client] = new Embeddable[ApiGatewayV2Op, ApiGatewayV2Client] {
      def embed[A](client: ApiGatewayV2Client, io: ApiGatewayV2IO[A]): Embedded[A] = Embedded.ApiGatewayV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ApiGatewayV2Op.Visitor[Kleisli[M, ApiGatewayV2Client, *]] {
        def createApi(
          request: CreateApiRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateApiResponse] =
          primitive(_.createApi(request))

        def createApiMapping(
          request: CreateApiMappingRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateApiMappingResponse] =
          primitive(_.createApiMapping(request))

        def createAuthorizer(
          request: CreateAuthorizerRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateAuthorizerResponse] =
          primitive(_.createAuthorizer(request))

        def createDeployment(
          request: CreateDeploymentRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateDeploymentResponse] =
          primitive(_.createDeployment(request))

        def createDomainName(
          request: CreateDomainNameRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateDomainNameResponse] =
          primitive(_.createDomainName(request))

        def createIntegration(
          request: CreateIntegrationRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateIntegrationResponse] =
          primitive(_.createIntegration(request))

        def createIntegrationResponse(
          request: CreateIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateIntegrationResponseResponse] =
          primitive(_.createIntegrationResponse(request))

        def createModel(
          request: CreateModelRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateModelResponse] =
          primitive(_.createModel(request))

        def createRoute(
          request: CreateRouteRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateRouteResponse] =
          primitive(_.createRoute(request))

        def createRouteResponse(
          request: CreateRouteResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateRouteResponseResponse] =
          primitive(_.createRouteResponse(request))

        def createStage(
          request: CreateStageRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateStageResponse] =
          primitive(_.createStage(request))

        def createVpcLink(
          request: CreateVpcLinkRequest
        ): Kleisli[M, ApiGatewayV2Client, CreateVpcLinkResponse] =
          primitive(_.createVpcLink(request))

        def deleteAccessLogSettings(
          request: DeleteAccessLogSettingsRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteAccessLogSettingsResponse] =
          primitive(_.deleteAccessLogSettings(request))

        def deleteApi(
          request: DeleteApiRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteApiResponse] =
          primitive(_.deleteApi(request))

        def deleteApiMapping(
          request: DeleteApiMappingRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteApiMappingResponse] =
          primitive(_.deleteApiMapping(request))

        def deleteAuthorizer(
          request: DeleteAuthorizerRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteAuthorizerResponse] =
          primitive(_.deleteAuthorizer(request))

        def deleteCorsConfiguration(
          request: DeleteCorsConfigurationRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteCorsConfigurationResponse] =
          primitive(_.deleteCorsConfiguration(request))

        def deleteDeployment(
          request: DeleteDeploymentRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteDeploymentResponse] =
          primitive(_.deleteDeployment(request))

        def deleteDomainName(
          request: DeleteDomainNameRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteDomainNameResponse] =
          primitive(_.deleteDomainName(request))

        def deleteIntegration(
          request: DeleteIntegrationRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteIntegrationResponse] =
          primitive(_.deleteIntegration(request))

        def deleteIntegrationResponse(
          request: DeleteIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteIntegrationResponseResponse] =
          primitive(_.deleteIntegrationResponse(request))

        def deleteModel(
          request: DeleteModelRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteModelResponse] =
          primitive(_.deleteModel(request))

        def deleteRoute(
          request: DeleteRouteRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteRouteResponse] =
          primitive(_.deleteRoute(request))

        def deleteRouteRequestParameter(
          request: DeleteRouteRequestParameterRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteRouteRequestParameterResponse] =
          primitive(_.deleteRouteRequestParameter(request))

        def deleteRouteResponse(
          request: DeleteRouteResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteRouteResponseResponse] =
          primitive(_.deleteRouteResponse(request))

        def deleteRouteSettings(
          request: DeleteRouteSettingsRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteRouteSettingsResponse] =
          primitive(_.deleteRouteSettings(request))

        def deleteStage(
          request: DeleteStageRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteStageResponse] =
          primitive(_.deleteStage(request))

        def deleteVpcLink(
          request: DeleteVpcLinkRequest
        ): Kleisli[M, ApiGatewayV2Client, DeleteVpcLinkResponse] =
          primitive(_.deleteVpcLink(request))

        def exportApi(
          request: ExportApiRequest
        ): Kleisli[M, ApiGatewayV2Client, ExportApiResponse] =
          primitive(_.exportApi(request))

        def getApi(
          request: GetApiRequest
        ): Kleisli[M, ApiGatewayV2Client, GetApiResponse] =
          primitive(_.getApi(request))

        def getApiMapping(
          request: GetApiMappingRequest
        ): Kleisli[M, ApiGatewayV2Client, GetApiMappingResponse] =
          primitive(_.getApiMapping(request))

        def getApiMappings(
          request: GetApiMappingsRequest
        ): Kleisli[M, ApiGatewayV2Client, GetApiMappingsResponse] =
          primitive(_.getApiMappings(request))

        def getApis(
          request: GetApisRequest
        ): Kleisli[M, ApiGatewayV2Client, GetApisResponse] =
          primitive(_.getApis(request))

        def getAuthorizer(
          request: GetAuthorizerRequest
        ): Kleisli[M, ApiGatewayV2Client, GetAuthorizerResponse] =
          primitive(_.getAuthorizer(request))

        def getAuthorizers(
          request: GetAuthorizersRequest
        ): Kleisli[M, ApiGatewayV2Client, GetAuthorizersResponse] =
          primitive(_.getAuthorizers(request))

        def getDeployment(
          request: GetDeploymentRequest
        ): Kleisli[M, ApiGatewayV2Client, GetDeploymentResponse] =
          primitive(_.getDeployment(request))

        def getDeployments(
          request: GetDeploymentsRequest
        ): Kleisli[M, ApiGatewayV2Client, GetDeploymentsResponse] =
          primitive(_.getDeployments(request))

        def getDomainName(
          request: GetDomainNameRequest
        ): Kleisli[M, ApiGatewayV2Client, GetDomainNameResponse] =
          primitive(_.getDomainName(request))

        def getDomainNames(
          request: GetDomainNamesRequest
        ): Kleisli[M, ApiGatewayV2Client, GetDomainNamesResponse] =
          primitive(_.getDomainNames(request))

        def getIntegration(
          request: GetIntegrationRequest
        ): Kleisli[M, ApiGatewayV2Client, GetIntegrationResponse] =
          primitive(_.getIntegration(request))

        def getIntegrationResponse(
          request: GetIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, GetIntegrationResponseResponse] =
          primitive(_.getIntegrationResponse(request))

        def getIntegrationResponses(
          request: GetIntegrationResponsesRequest
        ): Kleisli[M, ApiGatewayV2Client, GetIntegrationResponsesResponse] =
          primitive(_.getIntegrationResponses(request))

        def getIntegrations(
          request: GetIntegrationsRequest
        ): Kleisli[M, ApiGatewayV2Client, GetIntegrationsResponse] =
          primitive(_.getIntegrations(request))

        def getModel(
          request: GetModelRequest
        ): Kleisli[M, ApiGatewayV2Client, GetModelResponse] =
          primitive(_.getModel(request))

        def getModelTemplate(
          request: GetModelTemplateRequest
        ): Kleisli[M, ApiGatewayV2Client, GetModelTemplateResponse] =
          primitive(_.getModelTemplate(request))

        def getModels(
          request: GetModelsRequest
        ): Kleisli[M, ApiGatewayV2Client, GetModelsResponse] =
          primitive(_.getModels(request))

        def getRoute(
          request: GetRouteRequest
        ): Kleisli[M, ApiGatewayV2Client, GetRouteResponse] =
          primitive(_.getRoute(request))

        def getRouteResponse(
          request: GetRouteResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, GetRouteResponseResponse] =
          primitive(_.getRouteResponse(request))

        def getRouteResponses(
          request: GetRouteResponsesRequest
        ): Kleisli[M, ApiGatewayV2Client, GetRouteResponsesResponse] =
          primitive(_.getRouteResponses(request))

        def getRoutes(
          request: GetRoutesRequest
        ): Kleisli[M, ApiGatewayV2Client, GetRoutesResponse] =
          primitive(_.getRoutes(request))

        def getStage(
          request: GetStageRequest
        ): Kleisli[M, ApiGatewayV2Client, GetStageResponse] =
          primitive(_.getStage(request))

        def getStages(
          request: GetStagesRequest
        ): Kleisli[M, ApiGatewayV2Client, GetStagesResponse] =
          primitive(_.getStages(request))

        def getTags(
          request: GetTagsRequest
        ): Kleisli[M, ApiGatewayV2Client, GetTagsResponse] =
          primitive(_.getTags(request))

        def getVpcLink(
          request: GetVpcLinkRequest
        ): Kleisli[M, ApiGatewayV2Client, GetVpcLinkResponse] =
          primitive(_.getVpcLink(request))

        def getVpcLinks(
          request: GetVpcLinksRequest
        ): Kleisli[M, ApiGatewayV2Client, GetVpcLinksResponse] =
          primitive(_.getVpcLinks(request))

        def importApi(
          request: ImportApiRequest
        ): Kleisli[M, ApiGatewayV2Client, ImportApiResponse] =
          primitive(_.importApi(request))

        def reimportApi(
          request: ReimportApiRequest
        ): Kleisli[M, ApiGatewayV2Client, ReimportApiResponse] =
          primitive(_.reimportApi(request))

        def resetAuthorizersCache(
          request: ResetAuthorizersCacheRequest
        ): Kleisli[M, ApiGatewayV2Client, ResetAuthorizersCacheResponse] =
          primitive(_.resetAuthorizersCache(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ApiGatewayV2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ApiGatewayV2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApi(
          request: UpdateApiRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateApiResponse] =
          primitive(_.updateApi(request))

        def updateApiMapping(
          request: UpdateApiMappingRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateApiMappingResponse] =
          primitive(_.updateApiMapping(request))

        def updateAuthorizer(
          request: UpdateAuthorizerRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateAuthorizerResponse] =
          primitive(_.updateAuthorizer(request))

        def updateDeployment(
          request: UpdateDeploymentRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateDeploymentResponse] =
          primitive(_.updateDeployment(request))

        def updateDomainName(
          request: UpdateDomainNameRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateDomainNameResponse] =
          primitive(_.updateDomainName(request))

        def updateIntegration(
          request: UpdateIntegrationRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateIntegrationResponse] =
          primitive(_.updateIntegration(request))

        def updateIntegrationResponse(
          request: UpdateIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateIntegrationResponseResponse] =
          primitive(_.updateIntegrationResponse(request))

        def updateModel(
          request: UpdateModelRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateModelResponse] =
          primitive(_.updateModel(request))

        def updateRoute(
          request: UpdateRouteRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateRouteResponse] =
          primitive(_.updateRoute(request))

        def updateRouteResponse(
          request: UpdateRouteResponseRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateRouteResponseResponse] =
          primitive(_.updateRouteResponse(request))

        def updateStage(
          request: UpdateStageRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateStageResponse] =
          primitive(_.updateStage(request))

        def updateVpcLink(
          request: UpdateVpcLinkRequest
        ): Kleisli[M, ApiGatewayV2Client, UpdateVpcLinkResponse] =
          primitive(_.updateVpcLink(request))

        def primitive[A](
          f: ApiGatewayV2Client => A
        ): Kleisli[M, ApiGatewayV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (ApiGatewayV2Op ~> F) {
      final def apply[A](op: ApiGatewayV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApi(
        request: CreateApiRequest
      ): F[CreateApiResponse]

      def createApiMapping(
        request: CreateApiMappingRequest
      ): F[CreateApiMappingResponse]

      def createAuthorizer(
        request: CreateAuthorizerRequest
      ): F[CreateAuthorizerResponse]

      def createDeployment(
        request: CreateDeploymentRequest
      ): F[CreateDeploymentResponse]

      def createDomainName(
        request: CreateDomainNameRequest
      ): F[CreateDomainNameResponse]

      def createIntegration(
        request: CreateIntegrationRequest
      ): F[CreateIntegrationResponse]

      def createIntegrationResponse(
        request: CreateIntegrationResponseRequest
      ): F[CreateIntegrationResponseResponse]

      def createModel(
        request: CreateModelRequest
      ): F[CreateModelResponse]

      def createRoute(
        request: CreateRouteRequest
      ): F[CreateRouteResponse]

      def createRouteResponse(
        request: CreateRouteResponseRequest
      ): F[CreateRouteResponseResponse]

      def createStage(
        request: CreateStageRequest
      ): F[CreateStageResponse]

      def createVpcLink(
        request: CreateVpcLinkRequest
      ): F[CreateVpcLinkResponse]

      def deleteAccessLogSettings(
        request: DeleteAccessLogSettingsRequest
      ): F[DeleteAccessLogSettingsResponse]

      def deleteApi(
        request: DeleteApiRequest
      ): F[DeleteApiResponse]

      def deleteApiMapping(
        request: DeleteApiMappingRequest
      ): F[DeleteApiMappingResponse]

      def deleteAuthorizer(
        request: DeleteAuthorizerRequest
      ): F[DeleteAuthorizerResponse]

      def deleteCorsConfiguration(
        request: DeleteCorsConfigurationRequest
      ): F[DeleteCorsConfigurationResponse]

      def deleteDeployment(
        request: DeleteDeploymentRequest
      ): F[DeleteDeploymentResponse]

      def deleteDomainName(
        request: DeleteDomainNameRequest
      ): F[DeleteDomainNameResponse]

      def deleteIntegration(
        request: DeleteIntegrationRequest
      ): F[DeleteIntegrationResponse]

      def deleteIntegrationResponse(
        request: DeleteIntegrationResponseRequest
      ): F[DeleteIntegrationResponseResponse]

      def deleteModel(
        request: DeleteModelRequest
      ): F[DeleteModelResponse]

      def deleteRoute(
        request: DeleteRouteRequest
      ): F[DeleteRouteResponse]

      def deleteRouteRequestParameter(
        request: DeleteRouteRequestParameterRequest
      ): F[DeleteRouteRequestParameterResponse]

      def deleteRouteResponse(
        request: DeleteRouteResponseRequest
      ): F[DeleteRouteResponseResponse]

      def deleteRouteSettings(
        request: DeleteRouteSettingsRequest
      ): F[DeleteRouteSettingsResponse]

      def deleteStage(
        request: DeleteStageRequest
      ): F[DeleteStageResponse]

      def deleteVpcLink(
        request: DeleteVpcLinkRequest
      ): F[DeleteVpcLinkResponse]

      def exportApi(
        request: ExportApiRequest
      ): F[ExportApiResponse]

      def getApi(
        request: GetApiRequest
      ): F[GetApiResponse]

      def getApiMapping(
        request: GetApiMappingRequest
      ): F[GetApiMappingResponse]

      def getApiMappings(
        request: GetApiMappingsRequest
      ): F[GetApiMappingsResponse]

      def getApis(
        request: GetApisRequest
      ): F[GetApisResponse]

      def getAuthorizer(
        request: GetAuthorizerRequest
      ): F[GetAuthorizerResponse]

      def getAuthorizers(
        request: GetAuthorizersRequest
      ): F[GetAuthorizersResponse]

      def getDeployment(
        request: GetDeploymentRequest
      ): F[GetDeploymentResponse]

      def getDeployments(
        request: GetDeploymentsRequest
      ): F[GetDeploymentsResponse]

      def getDomainName(
        request: GetDomainNameRequest
      ): F[GetDomainNameResponse]

      def getDomainNames(
        request: GetDomainNamesRequest
      ): F[GetDomainNamesResponse]

      def getIntegration(
        request: GetIntegrationRequest
      ): F[GetIntegrationResponse]

      def getIntegrationResponse(
        request: GetIntegrationResponseRequest
      ): F[GetIntegrationResponseResponse]

      def getIntegrationResponses(
        request: GetIntegrationResponsesRequest
      ): F[GetIntegrationResponsesResponse]

      def getIntegrations(
        request: GetIntegrationsRequest
      ): F[GetIntegrationsResponse]

      def getModel(
        request: GetModelRequest
      ): F[GetModelResponse]

      def getModelTemplate(
        request: GetModelTemplateRequest
      ): F[GetModelTemplateResponse]

      def getModels(
        request: GetModelsRequest
      ): F[GetModelsResponse]

      def getRoute(
        request: GetRouteRequest
      ): F[GetRouteResponse]

      def getRouteResponse(
        request: GetRouteResponseRequest
      ): F[GetRouteResponseResponse]

      def getRouteResponses(
        request: GetRouteResponsesRequest
      ): F[GetRouteResponsesResponse]

      def getRoutes(
        request: GetRoutesRequest
      ): F[GetRoutesResponse]

      def getStage(
        request: GetStageRequest
      ): F[GetStageResponse]

      def getStages(
        request: GetStagesRequest
      ): F[GetStagesResponse]

      def getTags(
        request: GetTagsRequest
      ): F[GetTagsResponse]

      def getVpcLink(
        request: GetVpcLinkRequest
      ): F[GetVpcLinkResponse]

      def getVpcLinks(
        request: GetVpcLinksRequest
      ): F[GetVpcLinksResponse]

      def importApi(
        request: ImportApiRequest
      ): F[ImportApiResponse]

      def reimportApi(
        request: ReimportApiRequest
      ): F[ReimportApiResponse]

      def resetAuthorizersCache(
        request: ResetAuthorizersCacheRequest
      ): F[ResetAuthorizersCacheResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApi(
        request: UpdateApiRequest
      ): F[UpdateApiResponse]

      def updateApiMapping(
        request: UpdateApiMappingRequest
      ): F[UpdateApiMappingResponse]

      def updateAuthorizer(
        request: UpdateAuthorizerRequest
      ): F[UpdateAuthorizerResponse]

      def updateDeployment(
        request: UpdateDeploymentRequest
      ): F[UpdateDeploymentResponse]

      def updateDomainName(
        request: UpdateDomainNameRequest
      ): F[UpdateDomainNameResponse]

      def updateIntegration(
        request: UpdateIntegrationRequest
      ): F[UpdateIntegrationResponse]

      def updateIntegrationResponse(
        request: UpdateIntegrationResponseRequest
      ): F[UpdateIntegrationResponseResponse]

      def updateModel(
        request: UpdateModelRequest
      ): F[UpdateModelResponse]

      def updateRoute(
        request: UpdateRouteRequest
      ): F[UpdateRouteResponse]

      def updateRouteResponse(
        request: UpdateRouteResponseRequest
      ): F[UpdateRouteResponseResponse]

      def updateStage(
        request: UpdateStageRequest
      ): F[UpdateStageResponse]

      def updateVpcLink(
        request: UpdateVpcLinkRequest
      ): F[UpdateVpcLinkResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ApiGatewayV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateApiOp(
      request: CreateApiRequest
    ) extends ApiGatewayV2Op[CreateApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApiResponse] =
        visitor.createApi(request)
    }

    final case class CreateApiMappingOp(
      request: CreateApiMappingRequest
    ) extends ApiGatewayV2Op[CreateApiMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApiMappingResponse] =
        visitor.createApiMapping(request)
    }

    final case class CreateAuthorizerOp(
      request: CreateAuthorizerRequest
    ) extends ApiGatewayV2Op[CreateAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAuthorizerResponse] =
        visitor.createAuthorizer(request)
    }

    final case class CreateDeploymentOp(
      request: CreateDeploymentRequest
    ) extends ApiGatewayV2Op[CreateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentResponse] =
        visitor.createDeployment(request)
    }

    final case class CreateDomainNameOp(
      request: CreateDomainNameRequest
    ) extends ApiGatewayV2Op[CreateDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainNameResponse] =
        visitor.createDomainName(request)
    }

    final case class CreateIntegrationOp(
      request: CreateIntegrationRequest
    ) extends ApiGatewayV2Op[CreateIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIntegrationResponse] =
        visitor.createIntegration(request)
    }

    final case class CreateIntegrationResponseOp(
      request: CreateIntegrationResponseRequest
    ) extends ApiGatewayV2Op[CreateIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIntegrationResponseResponse] =
        visitor.createIntegrationResponse(request)
    }

    final case class CreateModelOp(
      request: CreateModelRequest
    ) extends ApiGatewayV2Op[CreateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelResponse] =
        visitor.createModel(request)
    }

    final case class CreateRouteOp(
      request: CreateRouteRequest
    ) extends ApiGatewayV2Op[CreateRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRouteResponse] =
        visitor.createRoute(request)
    }

    final case class CreateRouteResponseOp(
      request: CreateRouteResponseRequest
    ) extends ApiGatewayV2Op[CreateRouteResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRouteResponseResponse] =
        visitor.createRouteResponse(request)
    }

    final case class CreateStageOp(
      request: CreateStageRequest
    ) extends ApiGatewayV2Op[CreateStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStageResponse] =
        visitor.createStage(request)
    }

    final case class CreateVpcLinkOp(
      request: CreateVpcLinkRequest
    ) extends ApiGatewayV2Op[CreateVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcLinkResponse] =
        visitor.createVpcLink(request)
    }

    final case class DeleteAccessLogSettingsOp(
      request: DeleteAccessLogSettingsRequest
    ) extends ApiGatewayV2Op[DeleteAccessLogSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessLogSettingsResponse] =
        visitor.deleteAccessLogSettings(request)
    }

    final case class DeleteApiOp(
      request: DeleteApiRequest
    ) extends ApiGatewayV2Op[DeleteApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApiResponse] =
        visitor.deleteApi(request)
    }

    final case class DeleteApiMappingOp(
      request: DeleteApiMappingRequest
    ) extends ApiGatewayV2Op[DeleteApiMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApiMappingResponse] =
        visitor.deleteApiMapping(request)
    }

    final case class DeleteAuthorizerOp(
      request: DeleteAuthorizerRequest
    ) extends ApiGatewayV2Op[DeleteAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAuthorizerResponse] =
        visitor.deleteAuthorizer(request)
    }

    final case class DeleteCorsConfigurationOp(
      request: DeleteCorsConfigurationRequest
    ) extends ApiGatewayV2Op[DeleteCorsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCorsConfigurationResponse] =
        visitor.deleteCorsConfiguration(request)
    }

    final case class DeleteDeploymentOp(
      request: DeleteDeploymentRequest
    ) extends ApiGatewayV2Op[DeleteDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeploymentResponse] =
        visitor.deleteDeployment(request)
    }

    final case class DeleteDomainNameOp(
      request: DeleteDomainNameRequest
    ) extends ApiGatewayV2Op[DeleteDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainNameResponse] =
        visitor.deleteDomainName(request)
    }

    final case class DeleteIntegrationOp(
      request: DeleteIntegrationRequest
    ) extends ApiGatewayV2Op[DeleteIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntegrationResponse] =
        visitor.deleteIntegration(request)
    }

    final case class DeleteIntegrationResponseOp(
      request: DeleteIntegrationResponseRequest
    ) extends ApiGatewayV2Op[DeleteIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntegrationResponseResponse] =
        visitor.deleteIntegrationResponse(request)
    }

    final case class DeleteModelOp(
      request: DeleteModelRequest
    ) extends ApiGatewayV2Op[DeleteModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelResponse] =
        visitor.deleteModel(request)
    }

    final case class DeleteRouteOp(
      request: DeleteRouteRequest
    ) extends ApiGatewayV2Op[DeleteRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteResponse] =
        visitor.deleteRoute(request)
    }

    final case class DeleteRouteRequestParameterOp(
      request: DeleteRouteRequestParameterRequest
    ) extends ApiGatewayV2Op[DeleteRouteRequestParameterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteRequestParameterResponse] =
        visitor.deleteRouteRequestParameter(request)
    }

    final case class DeleteRouteResponseOp(
      request: DeleteRouteResponseRequest
    ) extends ApiGatewayV2Op[DeleteRouteResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteResponseResponse] =
        visitor.deleteRouteResponse(request)
    }

    final case class DeleteRouteSettingsOp(
      request: DeleteRouteSettingsRequest
    ) extends ApiGatewayV2Op[DeleteRouteSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteSettingsResponse] =
        visitor.deleteRouteSettings(request)
    }

    final case class DeleteStageOp(
      request: DeleteStageRequest
    ) extends ApiGatewayV2Op[DeleteStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStageResponse] =
        visitor.deleteStage(request)
    }

    final case class DeleteVpcLinkOp(
      request: DeleteVpcLinkRequest
    ) extends ApiGatewayV2Op[DeleteVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcLinkResponse] =
        visitor.deleteVpcLink(request)
    }

    final case class ExportApiOp(
      request: ExportApiRequest
    ) extends ApiGatewayV2Op[ExportApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportApiResponse] =
        visitor.exportApi(request)
    }

    final case class GetApiOp(
      request: GetApiRequest
    ) extends ApiGatewayV2Op[GetApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApiResponse] =
        visitor.getApi(request)
    }

    final case class GetApiMappingOp(
      request: GetApiMappingRequest
    ) extends ApiGatewayV2Op[GetApiMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApiMappingResponse] =
        visitor.getApiMapping(request)
    }

    final case class GetApiMappingsOp(
      request: GetApiMappingsRequest
    ) extends ApiGatewayV2Op[GetApiMappingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApiMappingsResponse] =
        visitor.getApiMappings(request)
    }

    final case class GetApisOp(
      request: GetApisRequest
    ) extends ApiGatewayV2Op[GetApisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApisResponse] =
        visitor.getApis(request)
    }

    final case class GetAuthorizerOp(
      request: GetAuthorizerRequest
    ) extends ApiGatewayV2Op[GetAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAuthorizerResponse] =
        visitor.getAuthorizer(request)
    }

    final case class GetAuthorizersOp(
      request: GetAuthorizersRequest
    ) extends ApiGatewayV2Op[GetAuthorizersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAuthorizersResponse] =
        visitor.getAuthorizers(request)
    }

    final case class GetDeploymentOp(
      request: GetDeploymentRequest
    ) extends ApiGatewayV2Op[GetDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentResponse] =
        visitor.getDeployment(request)
    }

    final case class GetDeploymentsOp(
      request: GetDeploymentsRequest
    ) extends ApiGatewayV2Op[GetDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentsResponse] =
        visitor.getDeployments(request)
    }

    final case class GetDomainNameOp(
      request: GetDomainNameRequest
    ) extends ApiGatewayV2Op[GetDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainNameResponse] =
        visitor.getDomainName(request)
    }

    final case class GetDomainNamesOp(
      request: GetDomainNamesRequest
    ) extends ApiGatewayV2Op[GetDomainNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainNamesResponse] =
        visitor.getDomainNames(request)
    }

    final case class GetIntegrationOp(
      request: GetIntegrationRequest
    ) extends ApiGatewayV2Op[GetIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntegrationResponse] =
        visitor.getIntegration(request)
    }

    final case class GetIntegrationResponseOp(
      request: GetIntegrationResponseRequest
    ) extends ApiGatewayV2Op[GetIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntegrationResponseResponse] =
        visitor.getIntegrationResponse(request)
    }

    final case class GetIntegrationResponsesOp(
      request: GetIntegrationResponsesRequest
    ) extends ApiGatewayV2Op[GetIntegrationResponsesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntegrationResponsesResponse] =
        visitor.getIntegrationResponses(request)
    }

    final case class GetIntegrationsOp(
      request: GetIntegrationsRequest
    ) extends ApiGatewayV2Op[GetIntegrationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntegrationsResponse] =
        visitor.getIntegrations(request)
    }

    final case class GetModelOp(
      request: GetModelRequest
    ) extends ApiGatewayV2Op[GetModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelResponse] =
        visitor.getModel(request)
    }

    final case class GetModelTemplateOp(
      request: GetModelTemplateRequest
    ) extends ApiGatewayV2Op[GetModelTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelTemplateResponse] =
        visitor.getModelTemplate(request)
    }

    final case class GetModelsOp(
      request: GetModelsRequest
    ) extends ApiGatewayV2Op[GetModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelsResponse] =
        visitor.getModels(request)
    }

    final case class GetRouteOp(
      request: GetRouteRequest
    ) extends ApiGatewayV2Op[GetRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRouteResponse] =
        visitor.getRoute(request)
    }

    final case class GetRouteResponseOp(
      request: GetRouteResponseRequest
    ) extends ApiGatewayV2Op[GetRouteResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRouteResponseResponse] =
        visitor.getRouteResponse(request)
    }

    final case class GetRouteResponsesOp(
      request: GetRouteResponsesRequest
    ) extends ApiGatewayV2Op[GetRouteResponsesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRouteResponsesResponse] =
        visitor.getRouteResponses(request)
    }

    final case class GetRoutesOp(
      request: GetRoutesRequest
    ) extends ApiGatewayV2Op[GetRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRoutesResponse] =
        visitor.getRoutes(request)
    }

    final case class GetStageOp(
      request: GetStageRequest
    ) extends ApiGatewayV2Op[GetStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStageResponse] =
        visitor.getStage(request)
    }

    final case class GetStagesOp(
      request: GetStagesRequest
    ) extends ApiGatewayV2Op[GetStagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStagesResponse] =
        visitor.getStages(request)
    }

    final case class GetTagsOp(
      request: GetTagsRequest
    ) extends ApiGatewayV2Op[GetTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTagsResponse] =
        visitor.getTags(request)
    }

    final case class GetVpcLinkOp(
      request: GetVpcLinkRequest
    ) extends ApiGatewayV2Op[GetVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVpcLinkResponse] =
        visitor.getVpcLink(request)
    }

    final case class GetVpcLinksOp(
      request: GetVpcLinksRequest
    ) extends ApiGatewayV2Op[GetVpcLinksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVpcLinksResponse] =
        visitor.getVpcLinks(request)
    }

    final case class ImportApiOp(
      request: ImportApiRequest
    ) extends ApiGatewayV2Op[ImportApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportApiResponse] =
        visitor.importApi(request)
    }

    final case class ReimportApiOp(
      request: ReimportApiRequest
    ) extends ApiGatewayV2Op[ReimportApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReimportApiResponse] =
        visitor.reimportApi(request)
    }

    final case class ResetAuthorizersCacheOp(
      request: ResetAuthorizersCacheRequest
    ) extends ApiGatewayV2Op[ResetAuthorizersCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetAuthorizersCacheResponse] =
        visitor.resetAuthorizersCache(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ApiGatewayV2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ApiGatewayV2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApiOp(
      request: UpdateApiRequest
    ) extends ApiGatewayV2Op[UpdateApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApiResponse] =
        visitor.updateApi(request)
    }

    final case class UpdateApiMappingOp(
      request: UpdateApiMappingRequest
    ) extends ApiGatewayV2Op[UpdateApiMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApiMappingResponse] =
        visitor.updateApiMapping(request)
    }

    final case class UpdateAuthorizerOp(
      request: UpdateAuthorizerRequest
    ) extends ApiGatewayV2Op[UpdateAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAuthorizerResponse] =
        visitor.updateAuthorizer(request)
    }

    final case class UpdateDeploymentOp(
      request: UpdateDeploymentRequest
    ) extends ApiGatewayV2Op[UpdateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeploymentResponse] =
        visitor.updateDeployment(request)
    }

    final case class UpdateDomainNameOp(
      request: UpdateDomainNameRequest
    ) extends ApiGatewayV2Op[UpdateDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainNameResponse] =
        visitor.updateDomainName(request)
    }

    final case class UpdateIntegrationOp(
      request: UpdateIntegrationRequest
    ) extends ApiGatewayV2Op[UpdateIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIntegrationResponse] =
        visitor.updateIntegration(request)
    }

    final case class UpdateIntegrationResponseOp(
      request: UpdateIntegrationResponseRequest
    ) extends ApiGatewayV2Op[UpdateIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIntegrationResponseResponse] =
        visitor.updateIntegrationResponse(request)
    }

    final case class UpdateModelOp(
      request: UpdateModelRequest
    ) extends ApiGatewayV2Op[UpdateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateModelResponse] =
        visitor.updateModel(request)
    }

    final case class UpdateRouteOp(
      request: UpdateRouteRequest
    ) extends ApiGatewayV2Op[UpdateRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRouteResponse] =
        visitor.updateRoute(request)
    }

    final case class UpdateRouteResponseOp(
      request: UpdateRouteResponseRequest
    ) extends ApiGatewayV2Op[UpdateRouteResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRouteResponseResponse] =
        visitor.updateRouteResponse(request)
    }

    final case class UpdateStageOp(
      request: UpdateStageRequest
    ) extends ApiGatewayV2Op[UpdateStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStageResponse] =
        visitor.updateStage(request)
    }

    final case class UpdateVpcLinkOp(
      request: UpdateVpcLinkRequest
    ) extends ApiGatewayV2Op[UpdateVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVpcLinkResponse] =
        visitor.updateVpcLink(request)
    }
  }

  import ApiGatewayV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ApiGatewayV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApi(
    request: CreateApiRequest
  ): ApiGatewayV2IO[CreateApiResponse] =
    FF.liftF(CreateApiOp(request))

  def createApiMapping(
    request: CreateApiMappingRequest
  ): ApiGatewayV2IO[CreateApiMappingResponse] =
    FF.liftF(CreateApiMappingOp(request))

  def createAuthorizer(
    request: CreateAuthorizerRequest
  ): ApiGatewayV2IO[CreateAuthorizerResponse] =
    FF.liftF(CreateAuthorizerOp(request))

  def createDeployment(
    request: CreateDeploymentRequest
  ): ApiGatewayV2IO[CreateDeploymentResponse] =
    FF.liftF(CreateDeploymentOp(request))

  def createDomainName(
    request: CreateDomainNameRequest
  ): ApiGatewayV2IO[CreateDomainNameResponse] =
    FF.liftF(CreateDomainNameOp(request))

  def createIntegration(
    request: CreateIntegrationRequest
  ): ApiGatewayV2IO[CreateIntegrationResponse] =
    FF.liftF(CreateIntegrationOp(request))

  def createIntegrationResponse(
    request: CreateIntegrationResponseRequest
  ): ApiGatewayV2IO[CreateIntegrationResponseResponse] =
    FF.liftF(CreateIntegrationResponseOp(request))

  def createModel(
    request: CreateModelRequest
  ): ApiGatewayV2IO[CreateModelResponse] =
    FF.liftF(CreateModelOp(request))

  def createRoute(
    request: CreateRouteRequest
  ): ApiGatewayV2IO[CreateRouteResponse] =
    FF.liftF(CreateRouteOp(request))

  def createRouteResponse(
    request: CreateRouteResponseRequest
  ): ApiGatewayV2IO[CreateRouteResponseResponse] =
    FF.liftF(CreateRouteResponseOp(request))

  def createStage(
    request: CreateStageRequest
  ): ApiGatewayV2IO[CreateStageResponse] =
    FF.liftF(CreateStageOp(request))

  def createVpcLink(
    request: CreateVpcLinkRequest
  ): ApiGatewayV2IO[CreateVpcLinkResponse] =
    FF.liftF(CreateVpcLinkOp(request))

  def deleteAccessLogSettings(
    request: DeleteAccessLogSettingsRequest
  ): ApiGatewayV2IO[DeleteAccessLogSettingsResponse] =
    FF.liftF(DeleteAccessLogSettingsOp(request))

  def deleteApi(
    request: DeleteApiRequest
  ): ApiGatewayV2IO[DeleteApiResponse] =
    FF.liftF(DeleteApiOp(request))

  def deleteApiMapping(
    request: DeleteApiMappingRequest
  ): ApiGatewayV2IO[DeleteApiMappingResponse] =
    FF.liftF(DeleteApiMappingOp(request))

  def deleteAuthorizer(
    request: DeleteAuthorizerRequest
  ): ApiGatewayV2IO[DeleteAuthorizerResponse] =
    FF.liftF(DeleteAuthorizerOp(request))

  def deleteCorsConfiguration(
    request: DeleteCorsConfigurationRequest
  ): ApiGatewayV2IO[DeleteCorsConfigurationResponse] =
    FF.liftF(DeleteCorsConfigurationOp(request))

  def deleteDeployment(
    request: DeleteDeploymentRequest
  ): ApiGatewayV2IO[DeleteDeploymentResponse] =
    FF.liftF(DeleteDeploymentOp(request))

  def deleteDomainName(
    request: DeleteDomainNameRequest
  ): ApiGatewayV2IO[DeleteDomainNameResponse] =
    FF.liftF(DeleteDomainNameOp(request))

  def deleteIntegration(
    request: DeleteIntegrationRequest
  ): ApiGatewayV2IO[DeleteIntegrationResponse] =
    FF.liftF(DeleteIntegrationOp(request))

  def deleteIntegrationResponse(
    request: DeleteIntegrationResponseRequest
  ): ApiGatewayV2IO[DeleteIntegrationResponseResponse] =
    FF.liftF(DeleteIntegrationResponseOp(request))

  def deleteModel(
    request: DeleteModelRequest
  ): ApiGatewayV2IO[DeleteModelResponse] =
    FF.liftF(DeleteModelOp(request))

  def deleteRoute(
    request: DeleteRouteRequest
  ): ApiGatewayV2IO[DeleteRouteResponse] =
    FF.liftF(DeleteRouteOp(request))

  def deleteRouteRequestParameter(
    request: DeleteRouteRequestParameterRequest
  ): ApiGatewayV2IO[DeleteRouteRequestParameterResponse] =
    FF.liftF(DeleteRouteRequestParameterOp(request))

  def deleteRouteResponse(
    request: DeleteRouteResponseRequest
  ): ApiGatewayV2IO[DeleteRouteResponseResponse] =
    FF.liftF(DeleteRouteResponseOp(request))

  def deleteRouteSettings(
    request: DeleteRouteSettingsRequest
  ): ApiGatewayV2IO[DeleteRouteSettingsResponse] =
    FF.liftF(DeleteRouteSettingsOp(request))

  def deleteStage(
    request: DeleteStageRequest
  ): ApiGatewayV2IO[DeleteStageResponse] =
    FF.liftF(DeleteStageOp(request))

  def deleteVpcLink(
    request: DeleteVpcLinkRequest
  ): ApiGatewayV2IO[DeleteVpcLinkResponse] =
    FF.liftF(DeleteVpcLinkOp(request))

  def exportApi(
    request: ExportApiRequest
  ): ApiGatewayV2IO[ExportApiResponse] =
    FF.liftF(ExportApiOp(request))

  def getApi(
    request: GetApiRequest
  ): ApiGatewayV2IO[GetApiResponse] =
    FF.liftF(GetApiOp(request))

  def getApiMapping(
    request: GetApiMappingRequest
  ): ApiGatewayV2IO[GetApiMappingResponse] =
    FF.liftF(GetApiMappingOp(request))

  def getApiMappings(
    request: GetApiMappingsRequest
  ): ApiGatewayV2IO[GetApiMappingsResponse] =
    FF.liftF(GetApiMappingsOp(request))

  def getApis(
    request: GetApisRequest
  ): ApiGatewayV2IO[GetApisResponse] =
    FF.liftF(GetApisOp(request))

  def getAuthorizer(
    request: GetAuthorizerRequest
  ): ApiGatewayV2IO[GetAuthorizerResponse] =
    FF.liftF(GetAuthorizerOp(request))

  def getAuthorizers(
    request: GetAuthorizersRequest
  ): ApiGatewayV2IO[GetAuthorizersResponse] =
    FF.liftF(GetAuthorizersOp(request))

  def getDeployment(
    request: GetDeploymentRequest
  ): ApiGatewayV2IO[GetDeploymentResponse] =
    FF.liftF(GetDeploymentOp(request))

  def getDeployments(
    request: GetDeploymentsRequest
  ): ApiGatewayV2IO[GetDeploymentsResponse] =
    FF.liftF(GetDeploymentsOp(request))

  def getDomainName(
    request: GetDomainNameRequest
  ): ApiGatewayV2IO[GetDomainNameResponse] =
    FF.liftF(GetDomainNameOp(request))

  def getDomainNames(
    request: GetDomainNamesRequest
  ): ApiGatewayV2IO[GetDomainNamesResponse] =
    FF.liftF(GetDomainNamesOp(request))

  def getIntegration(
    request: GetIntegrationRequest
  ): ApiGatewayV2IO[GetIntegrationResponse] =
    FF.liftF(GetIntegrationOp(request))

  def getIntegrationResponse(
    request: GetIntegrationResponseRequest
  ): ApiGatewayV2IO[GetIntegrationResponseResponse] =
    FF.liftF(GetIntegrationResponseOp(request))

  def getIntegrationResponses(
    request: GetIntegrationResponsesRequest
  ): ApiGatewayV2IO[GetIntegrationResponsesResponse] =
    FF.liftF(GetIntegrationResponsesOp(request))

  def getIntegrations(
    request: GetIntegrationsRequest
  ): ApiGatewayV2IO[GetIntegrationsResponse] =
    FF.liftF(GetIntegrationsOp(request))

  def getModel(
    request: GetModelRequest
  ): ApiGatewayV2IO[GetModelResponse] =
    FF.liftF(GetModelOp(request))

  def getModelTemplate(
    request: GetModelTemplateRequest
  ): ApiGatewayV2IO[GetModelTemplateResponse] =
    FF.liftF(GetModelTemplateOp(request))

  def getModels(
    request: GetModelsRequest
  ): ApiGatewayV2IO[GetModelsResponse] =
    FF.liftF(GetModelsOp(request))

  def getRoute(
    request: GetRouteRequest
  ): ApiGatewayV2IO[GetRouteResponse] =
    FF.liftF(GetRouteOp(request))

  def getRouteResponse(
    request: GetRouteResponseRequest
  ): ApiGatewayV2IO[GetRouteResponseResponse] =
    FF.liftF(GetRouteResponseOp(request))

  def getRouteResponses(
    request: GetRouteResponsesRequest
  ): ApiGatewayV2IO[GetRouteResponsesResponse] =
    FF.liftF(GetRouteResponsesOp(request))

  def getRoutes(
    request: GetRoutesRequest
  ): ApiGatewayV2IO[GetRoutesResponse] =
    FF.liftF(GetRoutesOp(request))

  def getStage(
    request: GetStageRequest
  ): ApiGatewayV2IO[GetStageResponse] =
    FF.liftF(GetStageOp(request))

  def getStages(
    request: GetStagesRequest
  ): ApiGatewayV2IO[GetStagesResponse] =
    FF.liftF(GetStagesOp(request))

  def getTags(
    request: GetTagsRequest
  ): ApiGatewayV2IO[GetTagsResponse] =
    FF.liftF(GetTagsOp(request))

  def getVpcLink(
    request: GetVpcLinkRequest
  ): ApiGatewayV2IO[GetVpcLinkResponse] =
    FF.liftF(GetVpcLinkOp(request))

  def getVpcLinks(
    request: GetVpcLinksRequest
  ): ApiGatewayV2IO[GetVpcLinksResponse] =
    FF.liftF(GetVpcLinksOp(request))

  def importApi(
    request: ImportApiRequest
  ): ApiGatewayV2IO[ImportApiResponse] =
    FF.liftF(ImportApiOp(request))

  def reimportApi(
    request: ReimportApiRequest
  ): ApiGatewayV2IO[ReimportApiResponse] =
    FF.liftF(ReimportApiOp(request))

  def resetAuthorizersCache(
    request: ResetAuthorizersCacheRequest
  ): ApiGatewayV2IO[ResetAuthorizersCacheResponse] =
    FF.liftF(ResetAuthorizersCacheOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ApiGatewayV2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ApiGatewayV2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApi(
    request: UpdateApiRequest
  ): ApiGatewayV2IO[UpdateApiResponse] =
    FF.liftF(UpdateApiOp(request))

  def updateApiMapping(
    request: UpdateApiMappingRequest
  ): ApiGatewayV2IO[UpdateApiMappingResponse] =
    FF.liftF(UpdateApiMappingOp(request))

  def updateAuthorizer(
    request: UpdateAuthorizerRequest
  ): ApiGatewayV2IO[UpdateAuthorizerResponse] =
    FF.liftF(UpdateAuthorizerOp(request))

  def updateDeployment(
    request: UpdateDeploymentRequest
  ): ApiGatewayV2IO[UpdateDeploymentResponse] =
    FF.liftF(UpdateDeploymentOp(request))

  def updateDomainName(
    request: UpdateDomainNameRequest
  ): ApiGatewayV2IO[UpdateDomainNameResponse] =
    FF.liftF(UpdateDomainNameOp(request))

  def updateIntegration(
    request: UpdateIntegrationRequest
  ): ApiGatewayV2IO[UpdateIntegrationResponse] =
    FF.liftF(UpdateIntegrationOp(request))

  def updateIntegrationResponse(
    request: UpdateIntegrationResponseRequest
  ): ApiGatewayV2IO[UpdateIntegrationResponseResponse] =
    FF.liftF(UpdateIntegrationResponseOp(request))

  def updateModel(
    request: UpdateModelRequest
  ): ApiGatewayV2IO[UpdateModelResponse] =
    FF.liftF(UpdateModelOp(request))

  def updateRoute(
    request: UpdateRouteRequest
  ): ApiGatewayV2IO[UpdateRouteResponse] =
    FF.liftF(UpdateRouteOp(request))

  def updateRouteResponse(
    request: UpdateRouteResponseRequest
  ): ApiGatewayV2IO[UpdateRouteResponseResponse] =
    FF.liftF(UpdateRouteResponseOp(request))

  def updateStage(
    request: UpdateStageRequest
  ): ApiGatewayV2IO[UpdateStageResponse] =
    FF.liftF(UpdateStageOp(request))

  def updateVpcLink(
    request: UpdateVpcLinkRequest
  ): ApiGatewayV2IO[UpdateVpcLinkResponse] =
    FF.liftF(UpdateVpcLinkOp(request))
}
