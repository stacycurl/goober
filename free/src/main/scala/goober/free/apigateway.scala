package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.apigateway.ApiGatewayClient
import software.amazon.awssdk.services.apigateway.model._


object apigateway { module =>

  // Free monad over ApiGatewayOp
  type ApiGatewayIO[A] = FF[ApiGatewayOp, A]

  sealed trait ApiGatewayOp[A] {
    def visit[F[_]](visitor: ApiGatewayOp.Visitor[F]): F[A]
  }

  object ApiGatewayOp {
    // Given a ApiGatewayClient we can embed a ApiGatewayIO program in any algebra that understands embedding.
    implicit val ApiGatewayOpEmbeddable: Embeddable[ApiGatewayOp, ApiGatewayClient] = new Embeddable[ApiGatewayOp, ApiGatewayClient] {
      def embed[A](client: ApiGatewayClient, io: ApiGatewayIO[A]): Embedded[A] = Embedded.ApiGateway(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ApiGatewayOp.Visitor[Kleisli[M, ApiGatewayClient, *]] {
        def createApiKey(
          request: CreateApiKeyRequest
        ): Kleisli[M, ApiGatewayClient, CreateApiKeyResponse] =
          primitive(_.createApiKey(request))

        def createAuthorizer(
          request: CreateAuthorizerRequest
        ): Kleisli[M, ApiGatewayClient, CreateAuthorizerResponse] =
          primitive(_.createAuthorizer(request))

        def createBasePathMapping(
          request: CreateBasePathMappingRequest
        ): Kleisli[M, ApiGatewayClient, CreateBasePathMappingResponse] =
          primitive(_.createBasePathMapping(request))

        def createDeployment(
          request: CreateDeploymentRequest
        ): Kleisli[M, ApiGatewayClient, CreateDeploymentResponse] =
          primitive(_.createDeployment(request))

        def createDocumentationPart(
          request: CreateDocumentationPartRequest
        ): Kleisli[M, ApiGatewayClient, CreateDocumentationPartResponse] =
          primitive(_.createDocumentationPart(request))

        def createDocumentationVersion(
          request: CreateDocumentationVersionRequest
        ): Kleisli[M, ApiGatewayClient, CreateDocumentationVersionResponse] =
          primitive(_.createDocumentationVersion(request))

        def createDomainName(
          request: CreateDomainNameRequest
        ): Kleisli[M, ApiGatewayClient, CreateDomainNameResponse] =
          primitive(_.createDomainName(request))

        def createModel(
          request: CreateModelRequest
        ): Kleisli[M, ApiGatewayClient, CreateModelResponse] =
          primitive(_.createModel(request))

        def createRequestValidator(
          request: CreateRequestValidatorRequest
        ): Kleisli[M, ApiGatewayClient, CreateRequestValidatorResponse] =
          primitive(_.createRequestValidator(request))

        def createResource(
          request: CreateResourceRequest
        ): Kleisli[M, ApiGatewayClient, CreateResourceResponse] =
          primitive(_.createResource(request))

        def createRestApi(
          request: CreateRestApiRequest
        ): Kleisli[M, ApiGatewayClient, CreateRestApiResponse] =
          primitive(_.createRestApi(request))

        def createStage(
          request: CreateStageRequest
        ): Kleisli[M, ApiGatewayClient, CreateStageResponse] =
          primitive(_.createStage(request))

        def createUsagePlan(
          request: CreateUsagePlanRequest
        ): Kleisli[M, ApiGatewayClient, CreateUsagePlanResponse] =
          primitive(_.createUsagePlan(request))

        def createUsagePlanKey(
          request: CreateUsagePlanKeyRequest
        ): Kleisli[M, ApiGatewayClient, CreateUsagePlanKeyResponse] =
          primitive(_.createUsagePlanKey(request))

        def createVpcLink(
          request: CreateVpcLinkRequest
        ): Kleisli[M, ApiGatewayClient, CreateVpcLinkResponse] =
          primitive(_.createVpcLink(request))

        def deleteApiKey(
          request: DeleteApiKeyRequest
        ): Kleisli[M, ApiGatewayClient, DeleteApiKeyResponse] =
          primitive(_.deleteApiKey(request))

        def deleteAuthorizer(
          request: DeleteAuthorizerRequest
        ): Kleisli[M, ApiGatewayClient, DeleteAuthorizerResponse] =
          primitive(_.deleteAuthorizer(request))

        def deleteBasePathMapping(
          request: DeleteBasePathMappingRequest
        ): Kleisli[M, ApiGatewayClient, DeleteBasePathMappingResponse] =
          primitive(_.deleteBasePathMapping(request))

        def deleteClientCertificate(
          request: DeleteClientCertificateRequest
        ): Kleisli[M, ApiGatewayClient, DeleteClientCertificateResponse] =
          primitive(_.deleteClientCertificate(request))

        def deleteDeployment(
          request: DeleteDeploymentRequest
        ): Kleisli[M, ApiGatewayClient, DeleteDeploymentResponse] =
          primitive(_.deleteDeployment(request))

        def deleteDocumentationPart(
          request: DeleteDocumentationPartRequest
        ): Kleisli[M, ApiGatewayClient, DeleteDocumentationPartResponse] =
          primitive(_.deleteDocumentationPart(request))

        def deleteDocumentationVersion(
          request: DeleteDocumentationVersionRequest
        ): Kleisli[M, ApiGatewayClient, DeleteDocumentationVersionResponse] =
          primitive(_.deleteDocumentationVersion(request))

        def deleteDomainName(
          request: DeleteDomainNameRequest
        ): Kleisli[M, ApiGatewayClient, DeleteDomainNameResponse] =
          primitive(_.deleteDomainName(request))

        def deleteGatewayResponse(
          request: DeleteGatewayResponseRequest
        ): Kleisli[M, ApiGatewayClient, DeleteGatewayResponseResponse] =
          primitive(_.deleteGatewayResponse(request))

        def deleteIntegration(
          request: DeleteIntegrationRequest
        ): Kleisli[M, ApiGatewayClient, DeleteIntegrationResponse] =
          primitive(_.deleteIntegration(request))

        def deleteIntegrationResponse(
          request: DeleteIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayClient, DeleteIntegrationResponseResponse] =
          primitive(_.deleteIntegrationResponse(request))

        def deleteMethod(
          request: DeleteMethodRequest
        ): Kleisli[M, ApiGatewayClient, DeleteMethodResponse] =
          primitive(_.deleteMethod(request))

        def deleteMethodResponse(
          request: DeleteMethodResponseRequest
        ): Kleisli[M, ApiGatewayClient, DeleteMethodResponseResponse] =
          primitive(_.deleteMethodResponse(request))

        def deleteModel(
          request: DeleteModelRequest
        ): Kleisli[M, ApiGatewayClient, DeleteModelResponse] =
          primitive(_.deleteModel(request))

        def deleteRequestValidator(
          request: DeleteRequestValidatorRequest
        ): Kleisli[M, ApiGatewayClient, DeleteRequestValidatorResponse] =
          primitive(_.deleteRequestValidator(request))

        def deleteResource(
          request: DeleteResourceRequest
        ): Kleisli[M, ApiGatewayClient, DeleteResourceResponse] =
          primitive(_.deleteResource(request))

        def deleteRestApi(
          request: DeleteRestApiRequest
        ): Kleisli[M, ApiGatewayClient, DeleteRestApiResponse] =
          primitive(_.deleteRestApi(request))

        def deleteStage(
          request: DeleteStageRequest
        ): Kleisli[M, ApiGatewayClient, DeleteStageResponse] =
          primitive(_.deleteStage(request))

        def deleteUsagePlan(
          request: DeleteUsagePlanRequest
        ): Kleisli[M, ApiGatewayClient, DeleteUsagePlanResponse] =
          primitive(_.deleteUsagePlan(request))

        def deleteUsagePlanKey(
          request: DeleteUsagePlanKeyRequest
        ): Kleisli[M, ApiGatewayClient, DeleteUsagePlanKeyResponse] =
          primitive(_.deleteUsagePlanKey(request))

        def deleteVpcLink(
          request: DeleteVpcLinkRequest
        ): Kleisli[M, ApiGatewayClient, DeleteVpcLinkResponse] =
          primitive(_.deleteVpcLink(request))

        def flushStageAuthorizersCache(
          request: FlushStageAuthorizersCacheRequest
        ): Kleisli[M, ApiGatewayClient, FlushStageAuthorizersCacheResponse] =
          primitive(_.flushStageAuthorizersCache(request))

        def flushStageCache(
          request: FlushStageCacheRequest
        ): Kleisli[M, ApiGatewayClient, FlushStageCacheResponse] =
          primitive(_.flushStageCache(request))

        def generateClientCertificate(
          request: GenerateClientCertificateRequest
        ): Kleisli[M, ApiGatewayClient, GenerateClientCertificateResponse] =
          primitive(_.generateClientCertificate(request))

        def getAccount(
          request: GetAccountRequest
        ): Kleisli[M, ApiGatewayClient, GetAccountResponse] =
          primitive(_.getAccount(request))

        def getApiKey(
          request: GetApiKeyRequest
        ): Kleisli[M, ApiGatewayClient, GetApiKeyResponse] =
          primitive(_.getApiKey(request))

        def getApiKeys(
          request: GetApiKeysRequest
        ): Kleisli[M, ApiGatewayClient, GetApiKeysResponse] =
          primitive(_.getApiKeys(request))

        def getAuthorizer(
          request: GetAuthorizerRequest
        ): Kleisli[M, ApiGatewayClient, GetAuthorizerResponse] =
          primitive(_.getAuthorizer(request))

        def getAuthorizers(
          request: GetAuthorizersRequest
        ): Kleisli[M, ApiGatewayClient, GetAuthorizersResponse] =
          primitive(_.getAuthorizers(request))

        def getBasePathMapping(
          request: GetBasePathMappingRequest
        ): Kleisli[M, ApiGatewayClient, GetBasePathMappingResponse] =
          primitive(_.getBasePathMapping(request))

        def getBasePathMappings(
          request: GetBasePathMappingsRequest
        ): Kleisli[M, ApiGatewayClient, GetBasePathMappingsResponse] =
          primitive(_.getBasePathMappings(request))

        def getClientCertificate(
          request: GetClientCertificateRequest
        ): Kleisli[M, ApiGatewayClient, GetClientCertificateResponse] =
          primitive(_.getClientCertificate(request))

        def getClientCertificates(
          request: GetClientCertificatesRequest
        ): Kleisli[M, ApiGatewayClient, GetClientCertificatesResponse] =
          primitive(_.getClientCertificates(request))

        def getDeployment(
          request: GetDeploymentRequest
        ): Kleisli[M, ApiGatewayClient, GetDeploymentResponse] =
          primitive(_.getDeployment(request))

        def getDeployments(
          request: GetDeploymentsRequest
        ): Kleisli[M, ApiGatewayClient, GetDeploymentsResponse] =
          primitive(_.getDeployments(request))

        def getDocumentationPart(
          request: GetDocumentationPartRequest
        ): Kleisli[M, ApiGatewayClient, GetDocumentationPartResponse] =
          primitive(_.getDocumentationPart(request))

        def getDocumentationParts(
          request: GetDocumentationPartsRequest
        ): Kleisli[M, ApiGatewayClient, GetDocumentationPartsResponse] =
          primitive(_.getDocumentationParts(request))

        def getDocumentationVersion(
          request: GetDocumentationVersionRequest
        ): Kleisli[M, ApiGatewayClient, GetDocumentationVersionResponse] =
          primitive(_.getDocumentationVersion(request))

        def getDocumentationVersions(
          request: GetDocumentationVersionsRequest
        ): Kleisli[M, ApiGatewayClient, GetDocumentationVersionsResponse] =
          primitive(_.getDocumentationVersions(request))

        def getDomainName(
          request: GetDomainNameRequest
        ): Kleisli[M, ApiGatewayClient, GetDomainNameResponse] =
          primitive(_.getDomainName(request))

        def getDomainNames(
          request: GetDomainNamesRequest
        ): Kleisli[M, ApiGatewayClient, GetDomainNamesResponse] =
          primitive(_.getDomainNames(request))

        def getExport(
          request: GetExportRequest
        ): Kleisli[M, ApiGatewayClient, GetExportResponse] =
          primitive(_.getExport(request))

        def getGatewayResponse(
          request: GetGatewayResponseRequest
        ): Kleisli[M, ApiGatewayClient, GetGatewayResponseResponse] =
          primitive(_.getGatewayResponse(request))

        def getGatewayResponses(
          request: GetGatewayResponsesRequest
        ): Kleisli[M, ApiGatewayClient, GetGatewayResponsesResponse] =
          primitive(_.getGatewayResponses(request))

        def getIntegration(
          request: GetIntegrationRequest
        ): Kleisli[M, ApiGatewayClient, GetIntegrationResponse] =
          primitive(_.getIntegration(request))

        def getIntegrationResponse(
          request: GetIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayClient, GetIntegrationResponseResponse] =
          primitive(_.getIntegrationResponse(request))

        def getMethod(
          request: GetMethodRequest
        ): Kleisli[M, ApiGatewayClient, GetMethodResponse] =
          primitive(_.getMethod(request))

        def getMethodResponse(
          request: GetMethodResponseRequest
        ): Kleisli[M, ApiGatewayClient, GetMethodResponseResponse] =
          primitive(_.getMethodResponse(request))

        def getModel(
          request: GetModelRequest
        ): Kleisli[M, ApiGatewayClient, GetModelResponse] =
          primitive(_.getModel(request))

        def getModelTemplate(
          request: GetModelTemplateRequest
        ): Kleisli[M, ApiGatewayClient, GetModelTemplateResponse] =
          primitive(_.getModelTemplate(request))

        def getModels(
          request: GetModelsRequest
        ): Kleisli[M, ApiGatewayClient, GetModelsResponse] =
          primitive(_.getModels(request))

        def getRequestValidator(
          request: GetRequestValidatorRequest
        ): Kleisli[M, ApiGatewayClient, GetRequestValidatorResponse] =
          primitive(_.getRequestValidator(request))

        def getRequestValidators(
          request: GetRequestValidatorsRequest
        ): Kleisli[M, ApiGatewayClient, GetRequestValidatorsResponse] =
          primitive(_.getRequestValidators(request))

        def getResource(
          request: GetResourceRequest
        ): Kleisli[M, ApiGatewayClient, GetResourceResponse] =
          primitive(_.getResource(request))

        def getResources(
          request: GetResourcesRequest
        ): Kleisli[M, ApiGatewayClient, GetResourcesResponse] =
          primitive(_.getResources(request))

        def getRestApi(
          request: GetRestApiRequest
        ): Kleisli[M, ApiGatewayClient, GetRestApiResponse] =
          primitive(_.getRestApi(request))

        def getRestApis(
          request: GetRestApisRequest
        ): Kleisli[M, ApiGatewayClient, GetRestApisResponse] =
          primitive(_.getRestApis(request))

        def getSdk(
          request: GetSdkRequest
        ): Kleisli[M, ApiGatewayClient, GetSdkResponse] =
          primitive(_.getSdk(request))

        def getSdkType(
          request: GetSdkTypeRequest
        ): Kleisli[M, ApiGatewayClient, GetSdkTypeResponse] =
          primitive(_.getSdkType(request))

        def getSdkTypes(
          request: GetSdkTypesRequest
        ): Kleisli[M, ApiGatewayClient, GetSdkTypesResponse] =
          primitive(_.getSdkTypes(request))

        def getStage(
          request: GetStageRequest
        ): Kleisli[M, ApiGatewayClient, GetStageResponse] =
          primitive(_.getStage(request))

        def getStages(
          request: GetStagesRequest
        ): Kleisli[M, ApiGatewayClient, GetStagesResponse] =
          primitive(_.getStages(request))

        def getTags(
          request: GetTagsRequest
        ): Kleisli[M, ApiGatewayClient, GetTagsResponse] =
          primitive(_.getTags(request))

        def getUsage(
          request: GetUsageRequest
        ): Kleisli[M, ApiGatewayClient, GetUsageResponse] =
          primitive(_.getUsage(request))

        def getUsagePlan(
          request: GetUsagePlanRequest
        ): Kleisli[M, ApiGatewayClient, GetUsagePlanResponse] =
          primitive(_.getUsagePlan(request))

        def getUsagePlanKey(
          request: GetUsagePlanKeyRequest
        ): Kleisli[M, ApiGatewayClient, GetUsagePlanKeyResponse] =
          primitive(_.getUsagePlanKey(request))

        def getUsagePlanKeys(
          request: GetUsagePlanKeysRequest
        ): Kleisli[M, ApiGatewayClient, GetUsagePlanKeysResponse] =
          primitive(_.getUsagePlanKeys(request))

        def getUsagePlans(
          request: GetUsagePlansRequest
        ): Kleisli[M, ApiGatewayClient, GetUsagePlansResponse] =
          primitive(_.getUsagePlans(request))

        def getVpcLink(
          request: GetVpcLinkRequest
        ): Kleisli[M, ApiGatewayClient, GetVpcLinkResponse] =
          primitive(_.getVpcLink(request))

        def getVpcLinks(
          request: GetVpcLinksRequest
        ): Kleisli[M, ApiGatewayClient, GetVpcLinksResponse] =
          primitive(_.getVpcLinks(request))

        def importApiKeys(
          request: ImportApiKeysRequest
        ): Kleisli[M, ApiGatewayClient, ImportApiKeysResponse] =
          primitive(_.importApiKeys(request))

        def importDocumentationParts(
          request: ImportDocumentationPartsRequest
        ): Kleisli[M, ApiGatewayClient, ImportDocumentationPartsResponse] =
          primitive(_.importDocumentationParts(request))

        def importRestApi(
          request: ImportRestApiRequest
        ): Kleisli[M, ApiGatewayClient, ImportRestApiResponse] =
          primitive(_.importRestApi(request))

        def putGatewayResponse(
          request: PutGatewayResponseRequest
        ): Kleisli[M, ApiGatewayClient, PutGatewayResponseResponse] =
          primitive(_.putGatewayResponse(request))

        def putIntegration(
          request: PutIntegrationRequest
        ): Kleisli[M, ApiGatewayClient, PutIntegrationResponse] =
          primitive(_.putIntegration(request))

        def putIntegrationResponse(
          request: PutIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayClient, PutIntegrationResponseResponse] =
          primitive(_.putIntegrationResponse(request))

        def putMethod(
          request: PutMethodRequest
        ): Kleisli[M, ApiGatewayClient, PutMethodResponse] =
          primitive(_.putMethod(request))

        def putMethodResponse(
          request: PutMethodResponseRequest
        ): Kleisli[M, ApiGatewayClient, PutMethodResponseResponse] =
          primitive(_.putMethodResponse(request))

        def putRestApi(
          request: PutRestApiRequest
        ): Kleisli[M, ApiGatewayClient, PutRestApiResponse] =
          primitive(_.putRestApi(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ApiGatewayClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testInvokeAuthorizer(
          request: TestInvokeAuthorizerRequest
        ): Kleisli[M, ApiGatewayClient, TestInvokeAuthorizerResponse] =
          primitive(_.testInvokeAuthorizer(request))

        def testInvokeMethod(
          request: TestInvokeMethodRequest
        ): Kleisli[M, ApiGatewayClient, TestInvokeMethodResponse] =
          primitive(_.testInvokeMethod(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ApiGatewayClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccount(
          request: UpdateAccountRequest
        ): Kleisli[M, ApiGatewayClient, UpdateAccountResponse] =
          primitive(_.updateAccount(request))

        def updateApiKey(
          request: UpdateApiKeyRequest
        ): Kleisli[M, ApiGatewayClient, UpdateApiKeyResponse] =
          primitive(_.updateApiKey(request))

        def updateAuthorizer(
          request: UpdateAuthorizerRequest
        ): Kleisli[M, ApiGatewayClient, UpdateAuthorizerResponse] =
          primitive(_.updateAuthorizer(request))

        def updateBasePathMapping(
          request: UpdateBasePathMappingRequest
        ): Kleisli[M, ApiGatewayClient, UpdateBasePathMappingResponse] =
          primitive(_.updateBasePathMapping(request))

        def updateClientCertificate(
          request: UpdateClientCertificateRequest
        ): Kleisli[M, ApiGatewayClient, UpdateClientCertificateResponse] =
          primitive(_.updateClientCertificate(request))

        def updateDeployment(
          request: UpdateDeploymentRequest
        ): Kleisli[M, ApiGatewayClient, UpdateDeploymentResponse] =
          primitive(_.updateDeployment(request))

        def updateDocumentationPart(
          request: UpdateDocumentationPartRequest
        ): Kleisli[M, ApiGatewayClient, UpdateDocumentationPartResponse] =
          primitive(_.updateDocumentationPart(request))

        def updateDocumentationVersion(
          request: UpdateDocumentationVersionRequest
        ): Kleisli[M, ApiGatewayClient, UpdateDocumentationVersionResponse] =
          primitive(_.updateDocumentationVersion(request))

        def updateDomainName(
          request: UpdateDomainNameRequest
        ): Kleisli[M, ApiGatewayClient, UpdateDomainNameResponse] =
          primitive(_.updateDomainName(request))

        def updateGatewayResponse(
          request: UpdateGatewayResponseRequest
        ): Kleisli[M, ApiGatewayClient, UpdateGatewayResponseResponse] =
          primitive(_.updateGatewayResponse(request))

        def updateIntegration(
          request: UpdateIntegrationRequest
        ): Kleisli[M, ApiGatewayClient, UpdateIntegrationResponse] =
          primitive(_.updateIntegration(request))

        def updateIntegrationResponse(
          request: UpdateIntegrationResponseRequest
        ): Kleisli[M, ApiGatewayClient, UpdateIntegrationResponseResponse] =
          primitive(_.updateIntegrationResponse(request))

        def updateMethod(
          request: UpdateMethodRequest
        ): Kleisli[M, ApiGatewayClient, UpdateMethodResponse] =
          primitive(_.updateMethod(request))

        def updateMethodResponse(
          request: UpdateMethodResponseRequest
        ): Kleisli[M, ApiGatewayClient, UpdateMethodResponseResponse] =
          primitive(_.updateMethodResponse(request))

        def updateModel(
          request: UpdateModelRequest
        ): Kleisli[M, ApiGatewayClient, UpdateModelResponse] =
          primitive(_.updateModel(request))

        def updateRequestValidator(
          request: UpdateRequestValidatorRequest
        ): Kleisli[M, ApiGatewayClient, UpdateRequestValidatorResponse] =
          primitive(_.updateRequestValidator(request))

        def updateResource(
          request: UpdateResourceRequest
        ): Kleisli[M, ApiGatewayClient, UpdateResourceResponse] =
          primitive(_.updateResource(request))

        def updateRestApi(
          request: UpdateRestApiRequest
        ): Kleisli[M, ApiGatewayClient, UpdateRestApiResponse] =
          primitive(_.updateRestApi(request))

        def updateStage(
          request: UpdateStageRequest
        ): Kleisli[M, ApiGatewayClient, UpdateStageResponse] =
          primitive(_.updateStage(request))

        def updateUsage(
          request: UpdateUsageRequest
        ): Kleisli[M, ApiGatewayClient, UpdateUsageResponse] =
          primitive(_.updateUsage(request))

        def updateUsagePlan(
          request: UpdateUsagePlanRequest
        ): Kleisli[M, ApiGatewayClient, UpdateUsagePlanResponse] =
          primitive(_.updateUsagePlan(request))

        def updateVpcLink(
          request: UpdateVpcLinkRequest
        ): Kleisli[M, ApiGatewayClient, UpdateVpcLinkResponse] =
          primitive(_.updateVpcLink(request))

        def primitive[A](
          f: ApiGatewayClient => A
        ): Kleisli[M, ApiGatewayClient, A]
      }
    }

    trait Visitor[F[_]] extends (ApiGatewayOp ~> F) {
      final def apply[A](op: ApiGatewayOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApiKey(
        request: CreateApiKeyRequest
      ): F[CreateApiKeyResponse]

      def createAuthorizer(
        request: CreateAuthorizerRequest
      ): F[CreateAuthorizerResponse]

      def createBasePathMapping(
        request: CreateBasePathMappingRequest
      ): F[CreateBasePathMappingResponse]

      def createDeployment(
        request: CreateDeploymentRequest
      ): F[CreateDeploymentResponse]

      def createDocumentationPart(
        request: CreateDocumentationPartRequest
      ): F[CreateDocumentationPartResponse]

      def createDocumentationVersion(
        request: CreateDocumentationVersionRequest
      ): F[CreateDocumentationVersionResponse]

      def createDomainName(
        request: CreateDomainNameRequest
      ): F[CreateDomainNameResponse]

      def createModel(
        request: CreateModelRequest
      ): F[CreateModelResponse]

      def createRequestValidator(
        request: CreateRequestValidatorRequest
      ): F[CreateRequestValidatorResponse]

      def createResource(
        request: CreateResourceRequest
      ): F[CreateResourceResponse]

      def createRestApi(
        request: CreateRestApiRequest
      ): F[CreateRestApiResponse]

      def createStage(
        request: CreateStageRequest
      ): F[CreateStageResponse]

      def createUsagePlan(
        request: CreateUsagePlanRequest
      ): F[CreateUsagePlanResponse]

      def createUsagePlanKey(
        request: CreateUsagePlanKeyRequest
      ): F[CreateUsagePlanKeyResponse]

      def createVpcLink(
        request: CreateVpcLinkRequest
      ): F[CreateVpcLinkResponse]

      def deleteApiKey(
        request: DeleteApiKeyRequest
      ): F[DeleteApiKeyResponse]

      def deleteAuthorizer(
        request: DeleteAuthorizerRequest
      ): F[DeleteAuthorizerResponse]

      def deleteBasePathMapping(
        request: DeleteBasePathMappingRequest
      ): F[DeleteBasePathMappingResponse]

      def deleteClientCertificate(
        request: DeleteClientCertificateRequest
      ): F[DeleteClientCertificateResponse]

      def deleteDeployment(
        request: DeleteDeploymentRequest
      ): F[DeleteDeploymentResponse]

      def deleteDocumentationPart(
        request: DeleteDocumentationPartRequest
      ): F[DeleteDocumentationPartResponse]

      def deleteDocumentationVersion(
        request: DeleteDocumentationVersionRequest
      ): F[DeleteDocumentationVersionResponse]

      def deleteDomainName(
        request: DeleteDomainNameRequest
      ): F[DeleteDomainNameResponse]

      def deleteGatewayResponse(
        request: DeleteGatewayResponseRequest
      ): F[DeleteGatewayResponseResponse]

      def deleteIntegration(
        request: DeleteIntegrationRequest
      ): F[DeleteIntegrationResponse]

      def deleteIntegrationResponse(
        request: DeleteIntegrationResponseRequest
      ): F[DeleteIntegrationResponseResponse]

      def deleteMethod(
        request: DeleteMethodRequest
      ): F[DeleteMethodResponse]

      def deleteMethodResponse(
        request: DeleteMethodResponseRequest
      ): F[DeleteMethodResponseResponse]

      def deleteModel(
        request: DeleteModelRequest
      ): F[DeleteModelResponse]

      def deleteRequestValidator(
        request: DeleteRequestValidatorRequest
      ): F[DeleteRequestValidatorResponse]

      def deleteResource(
        request: DeleteResourceRequest
      ): F[DeleteResourceResponse]

      def deleteRestApi(
        request: DeleteRestApiRequest
      ): F[DeleteRestApiResponse]

      def deleteStage(
        request: DeleteStageRequest
      ): F[DeleteStageResponse]

      def deleteUsagePlan(
        request: DeleteUsagePlanRequest
      ): F[DeleteUsagePlanResponse]

      def deleteUsagePlanKey(
        request: DeleteUsagePlanKeyRequest
      ): F[DeleteUsagePlanKeyResponse]

      def deleteVpcLink(
        request: DeleteVpcLinkRequest
      ): F[DeleteVpcLinkResponse]

      def flushStageAuthorizersCache(
        request: FlushStageAuthorizersCacheRequest
      ): F[FlushStageAuthorizersCacheResponse]

      def flushStageCache(
        request: FlushStageCacheRequest
      ): F[FlushStageCacheResponse]

      def generateClientCertificate(
        request: GenerateClientCertificateRequest
      ): F[GenerateClientCertificateResponse]

      def getAccount(
        request: GetAccountRequest
      ): F[GetAccountResponse]

      def getApiKey(
        request: GetApiKeyRequest
      ): F[GetApiKeyResponse]

      def getApiKeys(
        request: GetApiKeysRequest
      ): F[GetApiKeysResponse]

      def getAuthorizer(
        request: GetAuthorizerRequest
      ): F[GetAuthorizerResponse]

      def getAuthorizers(
        request: GetAuthorizersRequest
      ): F[GetAuthorizersResponse]

      def getBasePathMapping(
        request: GetBasePathMappingRequest
      ): F[GetBasePathMappingResponse]

      def getBasePathMappings(
        request: GetBasePathMappingsRequest
      ): F[GetBasePathMappingsResponse]

      def getClientCertificate(
        request: GetClientCertificateRequest
      ): F[GetClientCertificateResponse]

      def getClientCertificates(
        request: GetClientCertificatesRequest
      ): F[GetClientCertificatesResponse]

      def getDeployment(
        request: GetDeploymentRequest
      ): F[GetDeploymentResponse]

      def getDeployments(
        request: GetDeploymentsRequest
      ): F[GetDeploymentsResponse]

      def getDocumentationPart(
        request: GetDocumentationPartRequest
      ): F[GetDocumentationPartResponse]

      def getDocumentationParts(
        request: GetDocumentationPartsRequest
      ): F[GetDocumentationPartsResponse]

      def getDocumentationVersion(
        request: GetDocumentationVersionRequest
      ): F[GetDocumentationVersionResponse]

      def getDocumentationVersions(
        request: GetDocumentationVersionsRequest
      ): F[GetDocumentationVersionsResponse]

      def getDomainName(
        request: GetDomainNameRequest
      ): F[GetDomainNameResponse]

      def getDomainNames(
        request: GetDomainNamesRequest
      ): F[GetDomainNamesResponse]

      def getExport(
        request: GetExportRequest
      ): F[GetExportResponse]

      def getGatewayResponse(
        request: GetGatewayResponseRequest
      ): F[GetGatewayResponseResponse]

      def getGatewayResponses(
        request: GetGatewayResponsesRequest
      ): F[GetGatewayResponsesResponse]

      def getIntegration(
        request: GetIntegrationRequest
      ): F[GetIntegrationResponse]

      def getIntegrationResponse(
        request: GetIntegrationResponseRequest
      ): F[GetIntegrationResponseResponse]

      def getMethod(
        request: GetMethodRequest
      ): F[GetMethodResponse]

      def getMethodResponse(
        request: GetMethodResponseRequest
      ): F[GetMethodResponseResponse]

      def getModel(
        request: GetModelRequest
      ): F[GetModelResponse]

      def getModelTemplate(
        request: GetModelTemplateRequest
      ): F[GetModelTemplateResponse]

      def getModels(
        request: GetModelsRequest
      ): F[GetModelsResponse]

      def getRequestValidator(
        request: GetRequestValidatorRequest
      ): F[GetRequestValidatorResponse]

      def getRequestValidators(
        request: GetRequestValidatorsRequest
      ): F[GetRequestValidatorsResponse]

      def getResource(
        request: GetResourceRequest
      ): F[GetResourceResponse]

      def getResources(
        request: GetResourcesRequest
      ): F[GetResourcesResponse]

      def getRestApi(
        request: GetRestApiRequest
      ): F[GetRestApiResponse]

      def getRestApis(
        request: GetRestApisRequest
      ): F[GetRestApisResponse]

      def getSdk(
        request: GetSdkRequest
      ): F[GetSdkResponse]

      def getSdkType(
        request: GetSdkTypeRequest
      ): F[GetSdkTypeResponse]

      def getSdkTypes(
        request: GetSdkTypesRequest
      ): F[GetSdkTypesResponse]

      def getStage(
        request: GetStageRequest
      ): F[GetStageResponse]

      def getStages(
        request: GetStagesRequest
      ): F[GetStagesResponse]

      def getTags(
        request: GetTagsRequest
      ): F[GetTagsResponse]

      def getUsage(
        request: GetUsageRequest
      ): F[GetUsageResponse]

      def getUsagePlan(
        request: GetUsagePlanRequest
      ): F[GetUsagePlanResponse]

      def getUsagePlanKey(
        request: GetUsagePlanKeyRequest
      ): F[GetUsagePlanKeyResponse]

      def getUsagePlanKeys(
        request: GetUsagePlanKeysRequest
      ): F[GetUsagePlanKeysResponse]

      def getUsagePlans(
        request: GetUsagePlansRequest
      ): F[GetUsagePlansResponse]

      def getVpcLink(
        request: GetVpcLinkRequest
      ): F[GetVpcLinkResponse]

      def getVpcLinks(
        request: GetVpcLinksRequest
      ): F[GetVpcLinksResponse]

      def importApiKeys(
        request: ImportApiKeysRequest
      ): F[ImportApiKeysResponse]

      def importDocumentationParts(
        request: ImportDocumentationPartsRequest
      ): F[ImportDocumentationPartsResponse]

      def importRestApi(
        request: ImportRestApiRequest
      ): F[ImportRestApiResponse]

      def putGatewayResponse(
        request: PutGatewayResponseRequest
      ): F[PutGatewayResponseResponse]

      def putIntegration(
        request: PutIntegrationRequest
      ): F[PutIntegrationResponse]

      def putIntegrationResponse(
        request: PutIntegrationResponseRequest
      ): F[PutIntegrationResponseResponse]

      def putMethod(
        request: PutMethodRequest
      ): F[PutMethodResponse]

      def putMethodResponse(
        request: PutMethodResponseRequest
      ): F[PutMethodResponseResponse]

      def putRestApi(
        request: PutRestApiRequest
      ): F[PutRestApiResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testInvokeAuthorizer(
        request: TestInvokeAuthorizerRequest
      ): F[TestInvokeAuthorizerResponse]

      def testInvokeMethod(
        request: TestInvokeMethodRequest
      ): F[TestInvokeMethodResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccount(
        request: UpdateAccountRequest
      ): F[UpdateAccountResponse]

      def updateApiKey(
        request: UpdateApiKeyRequest
      ): F[UpdateApiKeyResponse]

      def updateAuthorizer(
        request: UpdateAuthorizerRequest
      ): F[UpdateAuthorizerResponse]

      def updateBasePathMapping(
        request: UpdateBasePathMappingRequest
      ): F[UpdateBasePathMappingResponse]

      def updateClientCertificate(
        request: UpdateClientCertificateRequest
      ): F[UpdateClientCertificateResponse]

      def updateDeployment(
        request: UpdateDeploymentRequest
      ): F[UpdateDeploymentResponse]

      def updateDocumentationPart(
        request: UpdateDocumentationPartRequest
      ): F[UpdateDocumentationPartResponse]

      def updateDocumentationVersion(
        request: UpdateDocumentationVersionRequest
      ): F[UpdateDocumentationVersionResponse]

      def updateDomainName(
        request: UpdateDomainNameRequest
      ): F[UpdateDomainNameResponse]

      def updateGatewayResponse(
        request: UpdateGatewayResponseRequest
      ): F[UpdateGatewayResponseResponse]

      def updateIntegration(
        request: UpdateIntegrationRequest
      ): F[UpdateIntegrationResponse]

      def updateIntegrationResponse(
        request: UpdateIntegrationResponseRequest
      ): F[UpdateIntegrationResponseResponse]

      def updateMethod(
        request: UpdateMethodRequest
      ): F[UpdateMethodResponse]

      def updateMethodResponse(
        request: UpdateMethodResponseRequest
      ): F[UpdateMethodResponseResponse]

      def updateModel(
        request: UpdateModelRequest
      ): F[UpdateModelResponse]

      def updateRequestValidator(
        request: UpdateRequestValidatorRequest
      ): F[UpdateRequestValidatorResponse]

      def updateResource(
        request: UpdateResourceRequest
      ): F[UpdateResourceResponse]

      def updateRestApi(
        request: UpdateRestApiRequest
      ): F[UpdateRestApiResponse]

      def updateStage(
        request: UpdateStageRequest
      ): F[UpdateStageResponse]

      def updateUsage(
        request: UpdateUsageRequest
      ): F[UpdateUsageResponse]

      def updateUsagePlan(
        request: UpdateUsagePlanRequest
      ): F[UpdateUsagePlanResponse]

      def updateVpcLink(
        request: UpdateVpcLinkRequest
      ): F[UpdateVpcLinkResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ApiGatewayOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateApiKeyOp(
      request: CreateApiKeyRequest
    ) extends ApiGatewayOp[CreateApiKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApiKeyResponse] =
        visitor.createApiKey(request)
    }

    final case class CreateAuthorizerOp(
      request: CreateAuthorizerRequest
    ) extends ApiGatewayOp[CreateAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAuthorizerResponse] =
        visitor.createAuthorizer(request)
    }

    final case class CreateBasePathMappingOp(
      request: CreateBasePathMappingRequest
    ) extends ApiGatewayOp[CreateBasePathMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBasePathMappingResponse] =
        visitor.createBasePathMapping(request)
    }

    final case class CreateDeploymentOp(
      request: CreateDeploymentRequest
    ) extends ApiGatewayOp[CreateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentResponse] =
        visitor.createDeployment(request)
    }

    final case class CreateDocumentationPartOp(
      request: CreateDocumentationPartRequest
    ) extends ApiGatewayOp[CreateDocumentationPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDocumentationPartResponse] =
        visitor.createDocumentationPart(request)
    }

    final case class CreateDocumentationVersionOp(
      request: CreateDocumentationVersionRequest
    ) extends ApiGatewayOp[CreateDocumentationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDocumentationVersionResponse] =
        visitor.createDocumentationVersion(request)
    }

    final case class CreateDomainNameOp(
      request: CreateDomainNameRequest
    ) extends ApiGatewayOp[CreateDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainNameResponse] =
        visitor.createDomainName(request)
    }

    final case class CreateModelOp(
      request: CreateModelRequest
    ) extends ApiGatewayOp[CreateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelResponse] =
        visitor.createModel(request)
    }

    final case class CreateRequestValidatorOp(
      request: CreateRequestValidatorRequest
    ) extends ApiGatewayOp[CreateRequestValidatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRequestValidatorResponse] =
        visitor.createRequestValidator(request)
    }

    final case class CreateResourceOp(
      request: CreateResourceRequest
    ) extends ApiGatewayOp[CreateResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceResponse] =
        visitor.createResource(request)
    }

    final case class CreateRestApiOp(
      request: CreateRestApiRequest
    ) extends ApiGatewayOp[CreateRestApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRestApiResponse] =
        visitor.createRestApi(request)
    }

    final case class CreateStageOp(
      request: CreateStageRequest
    ) extends ApiGatewayOp[CreateStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStageResponse] =
        visitor.createStage(request)
    }

    final case class CreateUsagePlanOp(
      request: CreateUsagePlanRequest
    ) extends ApiGatewayOp[CreateUsagePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUsagePlanResponse] =
        visitor.createUsagePlan(request)
    }

    final case class CreateUsagePlanKeyOp(
      request: CreateUsagePlanKeyRequest
    ) extends ApiGatewayOp[CreateUsagePlanKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUsagePlanKeyResponse] =
        visitor.createUsagePlanKey(request)
    }

    final case class CreateVpcLinkOp(
      request: CreateVpcLinkRequest
    ) extends ApiGatewayOp[CreateVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcLinkResponse] =
        visitor.createVpcLink(request)
    }

    final case class DeleteApiKeyOp(
      request: DeleteApiKeyRequest
    ) extends ApiGatewayOp[DeleteApiKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApiKeyResponse] =
        visitor.deleteApiKey(request)
    }

    final case class DeleteAuthorizerOp(
      request: DeleteAuthorizerRequest
    ) extends ApiGatewayOp[DeleteAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAuthorizerResponse] =
        visitor.deleteAuthorizer(request)
    }

    final case class DeleteBasePathMappingOp(
      request: DeleteBasePathMappingRequest
    ) extends ApiGatewayOp[DeleteBasePathMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBasePathMappingResponse] =
        visitor.deleteBasePathMapping(request)
    }

    final case class DeleteClientCertificateOp(
      request: DeleteClientCertificateRequest
    ) extends ApiGatewayOp[DeleteClientCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClientCertificateResponse] =
        visitor.deleteClientCertificate(request)
    }

    final case class DeleteDeploymentOp(
      request: DeleteDeploymentRequest
    ) extends ApiGatewayOp[DeleteDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeploymentResponse] =
        visitor.deleteDeployment(request)
    }

    final case class DeleteDocumentationPartOp(
      request: DeleteDocumentationPartRequest
    ) extends ApiGatewayOp[DeleteDocumentationPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDocumentationPartResponse] =
        visitor.deleteDocumentationPart(request)
    }

    final case class DeleteDocumentationVersionOp(
      request: DeleteDocumentationVersionRequest
    ) extends ApiGatewayOp[DeleteDocumentationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDocumentationVersionResponse] =
        visitor.deleteDocumentationVersion(request)
    }

    final case class DeleteDomainNameOp(
      request: DeleteDomainNameRequest
    ) extends ApiGatewayOp[DeleteDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainNameResponse] =
        visitor.deleteDomainName(request)
    }

    final case class DeleteGatewayResponseOp(
      request: DeleteGatewayResponseRequest
    ) extends ApiGatewayOp[DeleteGatewayResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGatewayResponseResponse] =
        visitor.deleteGatewayResponse(request)
    }

    final case class DeleteIntegrationOp(
      request: DeleteIntegrationRequest
    ) extends ApiGatewayOp[DeleteIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntegrationResponse] =
        visitor.deleteIntegration(request)
    }

    final case class DeleteIntegrationResponseOp(
      request: DeleteIntegrationResponseRequest
    ) extends ApiGatewayOp[DeleteIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntegrationResponseResponse] =
        visitor.deleteIntegrationResponse(request)
    }

    final case class DeleteMethodOp(
      request: DeleteMethodRequest
    ) extends ApiGatewayOp[DeleteMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMethodResponse] =
        visitor.deleteMethod(request)
    }

    final case class DeleteMethodResponseOp(
      request: DeleteMethodResponseRequest
    ) extends ApiGatewayOp[DeleteMethodResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMethodResponseResponse] =
        visitor.deleteMethodResponse(request)
    }

    final case class DeleteModelOp(
      request: DeleteModelRequest
    ) extends ApiGatewayOp[DeleteModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelResponse] =
        visitor.deleteModel(request)
    }

    final case class DeleteRequestValidatorOp(
      request: DeleteRequestValidatorRequest
    ) extends ApiGatewayOp[DeleteRequestValidatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRequestValidatorResponse] =
        visitor.deleteRequestValidator(request)
    }

    final case class DeleteResourceOp(
      request: DeleteResourceRequest
    ) extends ApiGatewayOp[DeleteResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceResponse] =
        visitor.deleteResource(request)
    }

    final case class DeleteRestApiOp(
      request: DeleteRestApiRequest
    ) extends ApiGatewayOp[DeleteRestApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRestApiResponse] =
        visitor.deleteRestApi(request)
    }

    final case class DeleteStageOp(
      request: DeleteStageRequest
    ) extends ApiGatewayOp[DeleteStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStageResponse] =
        visitor.deleteStage(request)
    }

    final case class DeleteUsagePlanOp(
      request: DeleteUsagePlanRequest
    ) extends ApiGatewayOp[DeleteUsagePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUsagePlanResponse] =
        visitor.deleteUsagePlan(request)
    }

    final case class DeleteUsagePlanKeyOp(
      request: DeleteUsagePlanKeyRequest
    ) extends ApiGatewayOp[DeleteUsagePlanKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUsagePlanKeyResponse] =
        visitor.deleteUsagePlanKey(request)
    }

    final case class DeleteVpcLinkOp(
      request: DeleteVpcLinkRequest
    ) extends ApiGatewayOp[DeleteVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcLinkResponse] =
        visitor.deleteVpcLink(request)
    }

    final case class FlushStageAuthorizersCacheOp(
      request: FlushStageAuthorizersCacheRequest
    ) extends ApiGatewayOp[FlushStageAuthorizersCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FlushStageAuthorizersCacheResponse] =
        visitor.flushStageAuthorizersCache(request)
    }

    final case class FlushStageCacheOp(
      request: FlushStageCacheRequest
    ) extends ApiGatewayOp[FlushStageCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FlushStageCacheResponse] =
        visitor.flushStageCache(request)
    }

    final case class GenerateClientCertificateOp(
      request: GenerateClientCertificateRequest
    ) extends ApiGatewayOp[GenerateClientCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateClientCertificateResponse] =
        visitor.generateClientCertificate(request)
    }

    final case class GetAccountOp(
      request: GetAccountRequest
    ) extends ApiGatewayOp[GetAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountResponse] =
        visitor.getAccount(request)
    }

    final case class GetApiKeyOp(
      request: GetApiKeyRequest
    ) extends ApiGatewayOp[GetApiKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApiKeyResponse] =
        visitor.getApiKey(request)
    }

    final case class GetApiKeysOp(
      request: GetApiKeysRequest
    ) extends ApiGatewayOp[GetApiKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApiKeysResponse] =
        visitor.getApiKeys(request)
    }

    final case class GetAuthorizerOp(
      request: GetAuthorizerRequest
    ) extends ApiGatewayOp[GetAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAuthorizerResponse] =
        visitor.getAuthorizer(request)
    }

    final case class GetAuthorizersOp(
      request: GetAuthorizersRequest
    ) extends ApiGatewayOp[GetAuthorizersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAuthorizersResponse] =
        visitor.getAuthorizers(request)
    }

    final case class GetBasePathMappingOp(
      request: GetBasePathMappingRequest
    ) extends ApiGatewayOp[GetBasePathMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBasePathMappingResponse] =
        visitor.getBasePathMapping(request)
    }

    final case class GetBasePathMappingsOp(
      request: GetBasePathMappingsRequest
    ) extends ApiGatewayOp[GetBasePathMappingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBasePathMappingsResponse] =
        visitor.getBasePathMappings(request)
    }

    final case class GetClientCertificateOp(
      request: GetClientCertificateRequest
    ) extends ApiGatewayOp[GetClientCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetClientCertificateResponse] =
        visitor.getClientCertificate(request)
    }

    final case class GetClientCertificatesOp(
      request: GetClientCertificatesRequest
    ) extends ApiGatewayOp[GetClientCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetClientCertificatesResponse] =
        visitor.getClientCertificates(request)
    }

    final case class GetDeploymentOp(
      request: GetDeploymentRequest
    ) extends ApiGatewayOp[GetDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentResponse] =
        visitor.getDeployment(request)
    }

    final case class GetDeploymentsOp(
      request: GetDeploymentsRequest
    ) extends ApiGatewayOp[GetDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentsResponse] =
        visitor.getDeployments(request)
    }

    final case class GetDocumentationPartOp(
      request: GetDocumentationPartRequest
    ) extends ApiGatewayOp[GetDocumentationPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentationPartResponse] =
        visitor.getDocumentationPart(request)
    }

    final case class GetDocumentationPartsOp(
      request: GetDocumentationPartsRequest
    ) extends ApiGatewayOp[GetDocumentationPartsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentationPartsResponse] =
        visitor.getDocumentationParts(request)
    }

    final case class GetDocumentationVersionOp(
      request: GetDocumentationVersionRequest
    ) extends ApiGatewayOp[GetDocumentationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentationVersionResponse] =
        visitor.getDocumentationVersion(request)
    }

    final case class GetDocumentationVersionsOp(
      request: GetDocumentationVersionsRequest
    ) extends ApiGatewayOp[GetDocumentationVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentationVersionsResponse] =
        visitor.getDocumentationVersions(request)
    }

    final case class GetDomainNameOp(
      request: GetDomainNameRequest
    ) extends ApiGatewayOp[GetDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainNameResponse] =
        visitor.getDomainName(request)
    }

    final case class GetDomainNamesOp(
      request: GetDomainNamesRequest
    ) extends ApiGatewayOp[GetDomainNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainNamesResponse] =
        visitor.getDomainNames(request)
    }

    final case class GetExportOp(
      request: GetExportRequest
    ) extends ApiGatewayOp[GetExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExportResponse] =
        visitor.getExport(request)
    }

    final case class GetGatewayResponseOp(
      request: GetGatewayResponseRequest
    ) extends ApiGatewayOp[GetGatewayResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGatewayResponseResponse] =
        visitor.getGatewayResponse(request)
    }

    final case class GetGatewayResponsesOp(
      request: GetGatewayResponsesRequest
    ) extends ApiGatewayOp[GetGatewayResponsesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGatewayResponsesResponse] =
        visitor.getGatewayResponses(request)
    }

    final case class GetIntegrationOp(
      request: GetIntegrationRequest
    ) extends ApiGatewayOp[GetIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntegrationResponse] =
        visitor.getIntegration(request)
    }

    final case class GetIntegrationResponseOp(
      request: GetIntegrationResponseRequest
    ) extends ApiGatewayOp[GetIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntegrationResponseResponse] =
        visitor.getIntegrationResponse(request)
    }

    final case class GetMethodOp(
      request: GetMethodRequest
    ) extends ApiGatewayOp[GetMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMethodResponse] =
        visitor.getMethod(request)
    }

    final case class GetMethodResponseOp(
      request: GetMethodResponseRequest
    ) extends ApiGatewayOp[GetMethodResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMethodResponseResponse] =
        visitor.getMethodResponse(request)
    }

    final case class GetModelOp(
      request: GetModelRequest
    ) extends ApiGatewayOp[GetModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelResponse] =
        visitor.getModel(request)
    }

    final case class GetModelTemplateOp(
      request: GetModelTemplateRequest
    ) extends ApiGatewayOp[GetModelTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelTemplateResponse] =
        visitor.getModelTemplate(request)
    }

    final case class GetModelsOp(
      request: GetModelsRequest
    ) extends ApiGatewayOp[GetModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelsResponse] =
        visitor.getModels(request)
    }

    final case class GetRequestValidatorOp(
      request: GetRequestValidatorRequest
    ) extends ApiGatewayOp[GetRequestValidatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRequestValidatorResponse] =
        visitor.getRequestValidator(request)
    }

    final case class GetRequestValidatorsOp(
      request: GetRequestValidatorsRequest
    ) extends ApiGatewayOp[GetRequestValidatorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRequestValidatorsResponse] =
        visitor.getRequestValidators(request)
    }

    final case class GetResourceOp(
      request: GetResourceRequest
    ) extends ApiGatewayOp[GetResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceResponse] =
        visitor.getResource(request)
    }

    final case class GetResourcesOp(
      request: GetResourcesRequest
    ) extends ApiGatewayOp[GetResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcesResponse] =
        visitor.getResources(request)
    }

    final case class GetRestApiOp(
      request: GetRestApiRequest
    ) extends ApiGatewayOp[GetRestApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRestApiResponse] =
        visitor.getRestApi(request)
    }

    final case class GetRestApisOp(
      request: GetRestApisRequest
    ) extends ApiGatewayOp[GetRestApisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRestApisResponse] =
        visitor.getRestApis(request)
    }

    final case class GetSdkOp(
      request: GetSdkRequest
    ) extends ApiGatewayOp[GetSdkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSdkResponse] =
        visitor.getSdk(request)
    }

    final case class GetSdkTypeOp(
      request: GetSdkTypeRequest
    ) extends ApiGatewayOp[GetSdkTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSdkTypeResponse] =
        visitor.getSdkType(request)
    }

    final case class GetSdkTypesOp(
      request: GetSdkTypesRequest
    ) extends ApiGatewayOp[GetSdkTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSdkTypesResponse] =
        visitor.getSdkTypes(request)
    }

    final case class GetStageOp(
      request: GetStageRequest
    ) extends ApiGatewayOp[GetStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStageResponse] =
        visitor.getStage(request)
    }

    final case class GetStagesOp(
      request: GetStagesRequest
    ) extends ApiGatewayOp[GetStagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStagesResponse] =
        visitor.getStages(request)
    }

    final case class GetTagsOp(
      request: GetTagsRequest
    ) extends ApiGatewayOp[GetTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTagsResponse] =
        visitor.getTags(request)
    }

    final case class GetUsageOp(
      request: GetUsageRequest
    ) extends ApiGatewayOp[GetUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsageResponse] =
        visitor.getUsage(request)
    }

    final case class GetUsagePlanOp(
      request: GetUsagePlanRequest
    ) extends ApiGatewayOp[GetUsagePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsagePlanResponse] =
        visitor.getUsagePlan(request)
    }

    final case class GetUsagePlanKeyOp(
      request: GetUsagePlanKeyRequest
    ) extends ApiGatewayOp[GetUsagePlanKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsagePlanKeyResponse] =
        visitor.getUsagePlanKey(request)
    }

    final case class GetUsagePlanKeysOp(
      request: GetUsagePlanKeysRequest
    ) extends ApiGatewayOp[GetUsagePlanKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsagePlanKeysResponse] =
        visitor.getUsagePlanKeys(request)
    }

    final case class GetUsagePlansOp(
      request: GetUsagePlansRequest
    ) extends ApiGatewayOp[GetUsagePlansResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsagePlansResponse] =
        visitor.getUsagePlans(request)
    }

    final case class GetVpcLinkOp(
      request: GetVpcLinkRequest
    ) extends ApiGatewayOp[GetVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVpcLinkResponse] =
        visitor.getVpcLink(request)
    }

    final case class GetVpcLinksOp(
      request: GetVpcLinksRequest
    ) extends ApiGatewayOp[GetVpcLinksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVpcLinksResponse] =
        visitor.getVpcLinks(request)
    }

    final case class ImportApiKeysOp(
      request: ImportApiKeysRequest
    ) extends ApiGatewayOp[ImportApiKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportApiKeysResponse] =
        visitor.importApiKeys(request)
    }

    final case class ImportDocumentationPartsOp(
      request: ImportDocumentationPartsRequest
    ) extends ApiGatewayOp[ImportDocumentationPartsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportDocumentationPartsResponse] =
        visitor.importDocumentationParts(request)
    }

    final case class ImportRestApiOp(
      request: ImportRestApiRequest
    ) extends ApiGatewayOp[ImportRestApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportRestApiResponse] =
        visitor.importRestApi(request)
    }

    final case class PutGatewayResponseOp(
      request: PutGatewayResponseRequest
    ) extends ApiGatewayOp[PutGatewayResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutGatewayResponseResponse] =
        visitor.putGatewayResponse(request)
    }

    final case class PutIntegrationOp(
      request: PutIntegrationRequest
    ) extends ApiGatewayOp[PutIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutIntegrationResponse] =
        visitor.putIntegration(request)
    }

    final case class PutIntegrationResponseOp(
      request: PutIntegrationResponseRequest
    ) extends ApiGatewayOp[PutIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutIntegrationResponseResponse] =
        visitor.putIntegrationResponse(request)
    }

    final case class PutMethodOp(
      request: PutMethodRequest
    ) extends ApiGatewayOp[PutMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMethodResponse] =
        visitor.putMethod(request)
    }

    final case class PutMethodResponseOp(
      request: PutMethodResponseRequest
    ) extends ApiGatewayOp[PutMethodResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMethodResponseResponse] =
        visitor.putMethodResponse(request)
    }

    final case class PutRestApiOp(
      request: PutRestApiRequest
    ) extends ApiGatewayOp[PutRestApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRestApiResponse] =
        visitor.putRestApi(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ApiGatewayOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestInvokeAuthorizerOp(
      request: TestInvokeAuthorizerRequest
    ) extends ApiGatewayOp[TestInvokeAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestInvokeAuthorizerResponse] =
        visitor.testInvokeAuthorizer(request)
    }

    final case class TestInvokeMethodOp(
      request: TestInvokeMethodRequest
    ) extends ApiGatewayOp[TestInvokeMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestInvokeMethodResponse] =
        visitor.testInvokeMethod(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ApiGatewayOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAccountOp(
      request: UpdateAccountRequest
    ) extends ApiGatewayOp[UpdateAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountResponse] =
        visitor.updateAccount(request)
    }

    final case class UpdateApiKeyOp(
      request: UpdateApiKeyRequest
    ) extends ApiGatewayOp[UpdateApiKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApiKeyResponse] =
        visitor.updateApiKey(request)
    }

    final case class UpdateAuthorizerOp(
      request: UpdateAuthorizerRequest
    ) extends ApiGatewayOp[UpdateAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAuthorizerResponse] =
        visitor.updateAuthorizer(request)
    }

    final case class UpdateBasePathMappingOp(
      request: UpdateBasePathMappingRequest
    ) extends ApiGatewayOp[UpdateBasePathMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBasePathMappingResponse] =
        visitor.updateBasePathMapping(request)
    }

    final case class UpdateClientCertificateOp(
      request: UpdateClientCertificateRequest
    ) extends ApiGatewayOp[UpdateClientCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClientCertificateResponse] =
        visitor.updateClientCertificate(request)
    }

    final case class UpdateDeploymentOp(
      request: UpdateDeploymentRequest
    ) extends ApiGatewayOp[UpdateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeploymentResponse] =
        visitor.updateDeployment(request)
    }

    final case class UpdateDocumentationPartOp(
      request: UpdateDocumentationPartRequest
    ) extends ApiGatewayOp[UpdateDocumentationPartResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDocumentationPartResponse] =
        visitor.updateDocumentationPart(request)
    }

    final case class UpdateDocumentationVersionOp(
      request: UpdateDocumentationVersionRequest
    ) extends ApiGatewayOp[UpdateDocumentationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDocumentationVersionResponse] =
        visitor.updateDocumentationVersion(request)
    }

    final case class UpdateDomainNameOp(
      request: UpdateDomainNameRequest
    ) extends ApiGatewayOp[UpdateDomainNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainNameResponse] =
        visitor.updateDomainName(request)
    }

    final case class UpdateGatewayResponseOp(
      request: UpdateGatewayResponseRequest
    ) extends ApiGatewayOp[UpdateGatewayResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewayResponseResponse] =
        visitor.updateGatewayResponse(request)
    }

    final case class UpdateIntegrationOp(
      request: UpdateIntegrationRequest
    ) extends ApiGatewayOp[UpdateIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIntegrationResponse] =
        visitor.updateIntegration(request)
    }

    final case class UpdateIntegrationResponseOp(
      request: UpdateIntegrationResponseRequest
    ) extends ApiGatewayOp[UpdateIntegrationResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIntegrationResponseResponse] =
        visitor.updateIntegrationResponse(request)
    }

    final case class UpdateMethodOp(
      request: UpdateMethodRequest
    ) extends ApiGatewayOp[UpdateMethodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMethodResponse] =
        visitor.updateMethod(request)
    }

    final case class UpdateMethodResponseOp(
      request: UpdateMethodResponseRequest
    ) extends ApiGatewayOp[UpdateMethodResponseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMethodResponseResponse] =
        visitor.updateMethodResponse(request)
    }

    final case class UpdateModelOp(
      request: UpdateModelRequest
    ) extends ApiGatewayOp[UpdateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateModelResponse] =
        visitor.updateModel(request)
    }

    final case class UpdateRequestValidatorOp(
      request: UpdateRequestValidatorRequest
    ) extends ApiGatewayOp[UpdateRequestValidatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRequestValidatorResponse] =
        visitor.updateRequestValidator(request)
    }

    final case class UpdateResourceOp(
      request: UpdateResourceRequest
    ) extends ApiGatewayOp[UpdateResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceResponse] =
        visitor.updateResource(request)
    }

    final case class UpdateRestApiOp(
      request: UpdateRestApiRequest
    ) extends ApiGatewayOp[UpdateRestApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRestApiResponse] =
        visitor.updateRestApi(request)
    }

    final case class UpdateStageOp(
      request: UpdateStageRequest
    ) extends ApiGatewayOp[UpdateStageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStageResponse] =
        visitor.updateStage(request)
    }

    final case class UpdateUsageOp(
      request: UpdateUsageRequest
    ) extends ApiGatewayOp[UpdateUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUsageResponse] =
        visitor.updateUsage(request)
    }

    final case class UpdateUsagePlanOp(
      request: UpdateUsagePlanRequest
    ) extends ApiGatewayOp[UpdateUsagePlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUsagePlanResponse] =
        visitor.updateUsagePlan(request)
    }

    final case class UpdateVpcLinkOp(
      request: UpdateVpcLinkRequest
    ) extends ApiGatewayOp[UpdateVpcLinkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVpcLinkResponse] =
        visitor.updateVpcLink(request)
    }
  }

  import ApiGatewayOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ApiGatewayOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApiKey(
    request: CreateApiKeyRequest
  ): ApiGatewayIO[CreateApiKeyResponse] =
    FF.liftF(CreateApiKeyOp(request))

  def createAuthorizer(
    request: CreateAuthorizerRequest
  ): ApiGatewayIO[CreateAuthorizerResponse] =
    FF.liftF(CreateAuthorizerOp(request))

  def createBasePathMapping(
    request: CreateBasePathMappingRequest
  ): ApiGatewayIO[CreateBasePathMappingResponse] =
    FF.liftF(CreateBasePathMappingOp(request))

  def createDeployment(
    request: CreateDeploymentRequest
  ): ApiGatewayIO[CreateDeploymentResponse] =
    FF.liftF(CreateDeploymentOp(request))

  def createDocumentationPart(
    request: CreateDocumentationPartRequest
  ): ApiGatewayIO[CreateDocumentationPartResponse] =
    FF.liftF(CreateDocumentationPartOp(request))

  def createDocumentationVersion(
    request: CreateDocumentationVersionRequest
  ): ApiGatewayIO[CreateDocumentationVersionResponse] =
    FF.liftF(CreateDocumentationVersionOp(request))

  def createDomainName(
    request: CreateDomainNameRequest
  ): ApiGatewayIO[CreateDomainNameResponse] =
    FF.liftF(CreateDomainNameOp(request))

  def createModel(
    request: CreateModelRequest
  ): ApiGatewayIO[CreateModelResponse] =
    FF.liftF(CreateModelOp(request))

  def createRequestValidator(
    request: CreateRequestValidatorRequest
  ): ApiGatewayIO[CreateRequestValidatorResponse] =
    FF.liftF(CreateRequestValidatorOp(request))

  def createResource(
    request: CreateResourceRequest
  ): ApiGatewayIO[CreateResourceResponse] =
    FF.liftF(CreateResourceOp(request))

  def createRestApi(
    request: CreateRestApiRequest
  ): ApiGatewayIO[CreateRestApiResponse] =
    FF.liftF(CreateRestApiOp(request))

  def createStage(
    request: CreateStageRequest
  ): ApiGatewayIO[CreateStageResponse] =
    FF.liftF(CreateStageOp(request))

  def createUsagePlan(
    request: CreateUsagePlanRequest
  ): ApiGatewayIO[CreateUsagePlanResponse] =
    FF.liftF(CreateUsagePlanOp(request))

  def createUsagePlanKey(
    request: CreateUsagePlanKeyRequest
  ): ApiGatewayIO[CreateUsagePlanKeyResponse] =
    FF.liftF(CreateUsagePlanKeyOp(request))

  def createVpcLink(
    request: CreateVpcLinkRequest
  ): ApiGatewayIO[CreateVpcLinkResponse] =
    FF.liftF(CreateVpcLinkOp(request))

  def deleteApiKey(
    request: DeleteApiKeyRequest
  ): ApiGatewayIO[DeleteApiKeyResponse] =
    FF.liftF(DeleteApiKeyOp(request))

  def deleteAuthorizer(
    request: DeleteAuthorizerRequest
  ): ApiGatewayIO[DeleteAuthorizerResponse] =
    FF.liftF(DeleteAuthorizerOp(request))

  def deleteBasePathMapping(
    request: DeleteBasePathMappingRequest
  ): ApiGatewayIO[DeleteBasePathMappingResponse] =
    FF.liftF(DeleteBasePathMappingOp(request))

  def deleteClientCertificate(
    request: DeleteClientCertificateRequest
  ): ApiGatewayIO[DeleteClientCertificateResponse] =
    FF.liftF(DeleteClientCertificateOp(request))

  def deleteDeployment(
    request: DeleteDeploymentRequest
  ): ApiGatewayIO[DeleteDeploymentResponse] =
    FF.liftF(DeleteDeploymentOp(request))

  def deleteDocumentationPart(
    request: DeleteDocumentationPartRequest
  ): ApiGatewayIO[DeleteDocumentationPartResponse] =
    FF.liftF(DeleteDocumentationPartOp(request))

  def deleteDocumentationVersion(
    request: DeleteDocumentationVersionRequest
  ): ApiGatewayIO[DeleteDocumentationVersionResponse] =
    FF.liftF(DeleteDocumentationVersionOp(request))

  def deleteDomainName(
    request: DeleteDomainNameRequest
  ): ApiGatewayIO[DeleteDomainNameResponse] =
    FF.liftF(DeleteDomainNameOp(request))

  def deleteGatewayResponse(
    request: DeleteGatewayResponseRequest
  ): ApiGatewayIO[DeleteGatewayResponseResponse] =
    FF.liftF(DeleteGatewayResponseOp(request))

  def deleteIntegration(
    request: DeleteIntegrationRequest
  ): ApiGatewayIO[DeleteIntegrationResponse] =
    FF.liftF(DeleteIntegrationOp(request))

  def deleteIntegrationResponse(
    request: DeleteIntegrationResponseRequest
  ): ApiGatewayIO[DeleteIntegrationResponseResponse] =
    FF.liftF(DeleteIntegrationResponseOp(request))

  def deleteMethod(
    request: DeleteMethodRequest
  ): ApiGatewayIO[DeleteMethodResponse] =
    FF.liftF(DeleteMethodOp(request))

  def deleteMethodResponse(
    request: DeleteMethodResponseRequest
  ): ApiGatewayIO[DeleteMethodResponseResponse] =
    FF.liftF(DeleteMethodResponseOp(request))

  def deleteModel(
    request: DeleteModelRequest
  ): ApiGatewayIO[DeleteModelResponse] =
    FF.liftF(DeleteModelOp(request))

  def deleteRequestValidator(
    request: DeleteRequestValidatorRequest
  ): ApiGatewayIO[DeleteRequestValidatorResponse] =
    FF.liftF(DeleteRequestValidatorOp(request))

  def deleteResource(
    request: DeleteResourceRequest
  ): ApiGatewayIO[DeleteResourceResponse] =
    FF.liftF(DeleteResourceOp(request))

  def deleteRestApi(
    request: DeleteRestApiRequest
  ): ApiGatewayIO[DeleteRestApiResponse] =
    FF.liftF(DeleteRestApiOp(request))

  def deleteStage(
    request: DeleteStageRequest
  ): ApiGatewayIO[DeleteStageResponse] =
    FF.liftF(DeleteStageOp(request))

  def deleteUsagePlan(
    request: DeleteUsagePlanRequest
  ): ApiGatewayIO[DeleteUsagePlanResponse] =
    FF.liftF(DeleteUsagePlanOp(request))

  def deleteUsagePlanKey(
    request: DeleteUsagePlanKeyRequest
  ): ApiGatewayIO[DeleteUsagePlanKeyResponse] =
    FF.liftF(DeleteUsagePlanKeyOp(request))

  def deleteVpcLink(
    request: DeleteVpcLinkRequest
  ): ApiGatewayIO[DeleteVpcLinkResponse] =
    FF.liftF(DeleteVpcLinkOp(request))

  def flushStageAuthorizersCache(
    request: FlushStageAuthorizersCacheRequest
  ): ApiGatewayIO[FlushStageAuthorizersCacheResponse] =
    FF.liftF(FlushStageAuthorizersCacheOp(request))

  def flushStageCache(
    request: FlushStageCacheRequest
  ): ApiGatewayIO[FlushStageCacheResponse] =
    FF.liftF(FlushStageCacheOp(request))

  def generateClientCertificate(
    request: GenerateClientCertificateRequest
  ): ApiGatewayIO[GenerateClientCertificateResponse] =
    FF.liftF(GenerateClientCertificateOp(request))

  def getAccount(
    request: GetAccountRequest
  ): ApiGatewayIO[GetAccountResponse] =
    FF.liftF(GetAccountOp(request))

  def getApiKey(
    request: GetApiKeyRequest
  ): ApiGatewayIO[GetApiKeyResponse] =
    FF.liftF(GetApiKeyOp(request))

  def getApiKeys(
    request: GetApiKeysRequest
  ): ApiGatewayIO[GetApiKeysResponse] =
    FF.liftF(GetApiKeysOp(request))

  def getAuthorizer(
    request: GetAuthorizerRequest
  ): ApiGatewayIO[GetAuthorizerResponse] =
    FF.liftF(GetAuthorizerOp(request))

  def getAuthorizers(
    request: GetAuthorizersRequest
  ): ApiGatewayIO[GetAuthorizersResponse] =
    FF.liftF(GetAuthorizersOp(request))

  def getBasePathMapping(
    request: GetBasePathMappingRequest
  ): ApiGatewayIO[GetBasePathMappingResponse] =
    FF.liftF(GetBasePathMappingOp(request))

  def getBasePathMappings(
    request: GetBasePathMappingsRequest
  ): ApiGatewayIO[GetBasePathMappingsResponse] =
    FF.liftF(GetBasePathMappingsOp(request))

  def getClientCertificate(
    request: GetClientCertificateRequest
  ): ApiGatewayIO[GetClientCertificateResponse] =
    FF.liftF(GetClientCertificateOp(request))

  def getClientCertificates(
    request: GetClientCertificatesRequest
  ): ApiGatewayIO[GetClientCertificatesResponse] =
    FF.liftF(GetClientCertificatesOp(request))

  def getDeployment(
    request: GetDeploymentRequest
  ): ApiGatewayIO[GetDeploymentResponse] =
    FF.liftF(GetDeploymentOp(request))

  def getDeployments(
    request: GetDeploymentsRequest
  ): ApiGatewayIO[GetDeploymentsResponse] =
    FF.liftF(GetDeploymentsOp(request))

  def getDocumentationPart(
    request: GetDocumentationPartRequest
  ): ApiGatewayIO[GetDocumentationPartResponse] =
    FF.liftF(GetDocumentationPartOp(request))

  def getDocumentationParts(
    request: GetDocumentationPartsRequest
  ): ApiGatewayIO[GetDocumentationPartsResponse] =
    FF.liftF(GetDocumentationPartsOp(request))

  def getDocumentationVersion(
    request: GetDocumentationVersionRequest
  ): ApiGatewayIO[GetDocumentationVersionResponse] =
    FF.liftF(GetDocumentationVersionOp(request))

  def getDocumentationVersions(
    request: GetDocumentationVersionsRequest
  ): ApiGatewayIO[GetDocumentationVersionsResponse] =
    FF.liftF(GetDocumentationVersionsOp(request))

  def getDomainName(
    request: GetDomainNameRequest
  ): ApiGatewayIO[GetDomainNameResponse] =
    FF.liftF(GetDomainNameOp(request))

  def getDomainNames(
    request: GetDomainNamesRequest
  ): ApiGatewayIO[GetDomainNamesResponse] =
    FF.liftF(GetDomainNamesOp(request))

  def getExport(
    request: GetExportRequest
  ): ApiGatewayIO[GetExportResponse] =
    FF.liftF(GetExportOp(request))

  def getGatewayResponse(
    request: GetGatewayResponseRequest
  ): ApiGatewayIO[GetGatewayResponseResponse] =
    FF.liftF(GetGatewayResponseOp(request))

  def getGatewayResponses(
    request: GetGatewayResponsesRequest
  ): ApiGatewayIO[GetGatewayResponsesResponse] =
    FF.liftF(GetGatewayResponsesOp(request))

  def getIntegration(
    request: GetIntegrationRequest
  ): ApiGatewayIO[GetIntegrationResponse] =
    FF.liftF(GetIntegrationOp(request))

  def getIntegrationResponse(
    request: GetIntegrationResponseRequest
  ): ApiGatewayIO[GetIntegrationResponseResponse] =
    FF.liftF(GetIntegrationResponseOp(request))

  def getMethod(
    request: GetMethodRequest
  ): ApiGatewayIO[GetMethodResponse] =
    FF.liftF(GetMethodOp(request))

  def getMethodResponse(
    request: GetMethodResponseRequest
  ): ApiGatewayIO[GetMethodResponseResponse] =
    FF.liftF(GetMethodResponseOp(request))

  def getModel(
    request: GetModelRequest
  ): ApiGatewayIO[GetModelResponse] =
    FF.liftF(GetModelOp(request))

  def getModelTemplate(
    request: GetModelTemplateRequest
  ): ApiGatewayIO[GetModelTemplateResponse] =
    FF.liftF(GetModelTemplateOp(request))

  def getModels(
    request: GetModelsRequest
  ): ApiGatewayIO[GetModelsResponse] =
    FF.liftF(GetModelsOp(request))

  def getRequestValidator(
    request: GetRequestValidatorRequest
  ): ApiGatewayIO[GetRequestValidatorResponse] =
    FF.liftF(GetRequestValidatorOp(request))

  def getRequestValidators(
    request: GetRequestValidatorsRequest
  ): ApiGatewayIO[GetRequestValidatorsResponse] =
    FF.liftF(GetRequestValidatorsOp(request))

  def getResource(
    request: GetResourceRequest
  ): ApiGatewayIO[GetResourceResponse] =
    FF.liftF(GetResourceOp(request))

  def getResources(
    request: GetResourcesRequest
  ): ApiGatewayIO[GetResourcesResponse] =
    FF.liftF(GetResourcesOp(request))

  def getRestApi(
    request: GetRestApiRequest
  ): ApiGatewayIO[GetRestApiResponse] =
    FF.liftF(GetRestApiOp(request))

  def getRestApis(
    request: GetRestApisRequest
  ): ApiGatewayIO[GetRestApisResponse] =
    FF.liftF(GetRestApisOp(request))

  def getSdk(
    request: GetSdkRequest
  ): ApiGatewayIO[GetSdkResponse] =
    FF.liftF(GetSdkOp(request))

  def getSdkType(
    request: GetSdkTypeRequest
  ): ApiGatewayIO[GetSdkTypeResponse] =
    FF.liftF(GetSdkTypeOp(request))

  def getSdkTypes(
    request: GetSdkTypesRequest
  ): ApiGatewayIO[GetSdkTypesResponse] =
    FF.liftF(GetSdkTypesOp(request))

  def getStage(
    request: GetStageRequest
  ): ApiGatewayIO[GetStageResponse] =
    FF.liftF(GetStageOp(request))

  def getStages(
    request: GetStagesRequest
  ): ApiGatewayIO[GetStagesResponse] =
    FF.liftF(GetStagesOp(request))

  def getTags(
    request: GetTagsRequest
  ): ApiGatewayIO[GetTagsResponse] =
    FF.liftF(GetTagsOp(request))

  def getUsage(
    request: GetUsageRequest
  ): ApiGatewayIO[GetUsageResponse] =
    FF.liftF(GetUsageOp(request))

  def getUsagePlan(
    request: GetUsagePlanRequest
  ): ApiGatewayIO[GetUsagePlanResponse] =
    FF.liftF(GetUsagePlanOp(request))

  def getUsagePlanKey(
    request: GetUsagePlanKeyRequest
  ): ApiGatewayIO[GetUsagePlanKeyResponse] =
    FF.liftF(GetUsagePlanKeyOp(request))

  def getUsagePlanKeys(
    request: GetUsagePlanKeysRequest
  ): ApiGatewayIO[GetUsagePlanKeysResponse] =
    FF.liftF(GetUsagePlanKeysOp(request))

  def getUsagePlans(
    request: GetUsagePlansRequest
  ): ApiGatewayIO[GetUsagePlansResponse] =
    FF.liftF(GetUsagePlansOp(request))

  def getVpcLink(
    request: GetVpcLinkRequest
  ): ApiGatewayIO[GetVpcLinkResponse] =
    FF.liftF(GetVpcLinkOp(request))

  def getVpcLinks(
    request: GetVpcLinksRequest
  ): ApiGatewayIO[GetVpcLinksResponse] =
    FF.liftF(GetVpcLinksOp(request))

  def importApiKeys(
    request: ImportApiKeysRequest
  ): ApiGatewayIO[ImportApiKeysResponse] =
    FF.liftF(ImportApiKeysOp(request))

  def importDocumentationParts(
    request: ImportDocumentationPartsRequest
  ): ApiGatewayIO[ImportDocumentationPartsResponse] =
    FF.liftF(ImportDocumentationPartsOp(request))

  def importRestApi(
    request: ImportRestApiRequest
  ): ApiGatewayIO[ImportRestApiResponse] =
    FF.liftF(ImportRestApiOp(request))

  def putGatewayResponse(
    request: PutGatewayResponseRequest
  ): ApiGatewayIO[PutGatewayResponseResponse] =
    FF.liftF(PutGatewayResponseOp(request))

  def putIntegration(
    request: PutIntegrationRequest
  ): ApiGatewayIO[PutIntegrationResponse] =
    FF.liftF(PutIntegrationOp(request))

  def putIntegrationResponse(
    request: PutIntegrationResponseRequest
  ): ApiGatewayIO[PutIntegrationResponseResponse] =
    FF.liftF(PutIntegrationResponseOp(request))

  def putMethod(
    request: PutMethodRequest
  ): ApiGatewayIO[PutMethodResponse] =
    FF.liftF(PutMethodOp(request))

  def putMethodResponse(
    request: PutMethodResponseRequest
  ): ApiGatewayIO[PutMethodResponseResponse] =
    FF.liftF(PutMethodResponseOp(request))

  def putRestApi(
    request: PutRestApiRequest
  ): ApiGatewayIO[PutRestApiResponse] =
    FF.liftF(PutRestApiOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ApiGatewayIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testInvokeAuthorizer(
    request: TestInvokeAuthorizerRequest
  ): ApiGatewayIO[TestInvokeAuthorizerResponse] =
    FF.liftF(TestInvokeAuthorizerOp(request))

  def testInvokeMethod(
    request: TestInvokeMethodRequest
  ): ApiGatewayIO[TestInvokeMethodResponse] =
    FF.liftF(TestInvokeMethodOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ApiGatewayIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccount(
    request: UpdateAccountRequest
  ): ApiGatewayIO[UpdateAccountResponse] =
    FF.liftF(UpdateAccountOp(request))

  def updateApiKey(
    request: UpdateApiKeyRequest
  ): ApiGatewayIO[UpdateApiKeyResponse] =
    FF.liftF(UpdateApiKeyOp(request))

  def updateAuthorizer(
    request: UpdateAuthorizerRequest
  ): ApiGatewayIO[UpdateAuthorizerResponse] =
    FF.liftF(UpdateAuthorizerOp(request))

  def updateBasePathMapping(
    request: UpdateBasePathMappingRequest
  ): ApiGatewayIO[UpdateBasePathMappingResponse] =
    FF.liftF(UpdateBasePathMappingOp(request))

  def updateClientCertificate(
    request: UpdateClientCertificateRequest
  ): ApiGatewayIO[UpdateClientCertificateResponse] =
    FF.liftF(UpdateClientCertificateOp(request))

  def updateDeployment(
    request: UpdateDeploymentRequest
  ): ApiGatewayIO[UpdateDeploymentResponse] =
    FF.liftF(UpdateDeploymentOp(request))

  def updateDocumentationPart(
    request: UpdateDocumentationPartRequest
  ): ApiGatewayIO[UpdateDocumentationPartResponse] =
    FF.liftF(UpdateDocumentationPartOp(request))

  def updateDocumentationVersion(
    request: UpdateDocumentationVersionRequest
  ): ApiGatewayIO[UpdateDocumentationVersionResponse] =
    FF.liftF(UpdateDocumentationVersionOp(request))

  def updateDomainName(
    request: UpdateDomainNameRequest
  ): ApiGatewayIO[UpdateDomainNameResponse] =
    FF.liftF(UpdateDomainNameOp(request))

  def updateGatewayResponse(
    request: UpdateGatewayResponseRequest
  ): ApiGatewayIO[UpdateGatewayResponseResponse] =
    FF.liftF(UpdateGatewayResponseOp(request))

  def updateIntegration(
    request: UpdateIntegrationRequest
  ): ApiGatewayIO[UpdateIntegrationResponse] =
    FF.liftF(UpdateIntegrationOp(request))

  def updateIntegrationResponse(
    request: UpdateIntegrationResponseRequest
  ): ApiGatewayIO[UpdateIntegrationResponseResponse] =
    FF.liftF(UpdateIntegrationResponseOp(request))

  def updateMethod(
    request: UpdateMethodRequest
  ): ApiGatewayIO[UpdateMethodResponse] =
    FF.liftF(UpdateMethodOp(request))

  def updateMethodResponse(
    request: UpdateMethodResponseRequest
  ): ApiGatewayIO[UpdateMethodResponseResponse] =
    FF.liftF(UpdateMethodResponseOp(request))

  def updateModel(
    request: UpdateModelRequest
  ): ApiGatewayIO[UpdateModelResponse] =
    FF.liftF(UpdateModelOp(request))

  def updateRequestValidator(
    request: UpdateRequestValidatorRequest
  ): ApiGatewayIO[UpdateRequestValidatorResponse] =
    FF.liftF(UpdateRequestValidatorOp(request))

  def updateResource(
    request: UpdateResourceRequest
  ): ApiGatewayIO[UpdateResourceResponse] =
    FF.liftF(UpdateResourceOp(request))

  def updateRestApi(
    request: UpdateRestApiRequest
  ): ApiGatewayIO[UpdateRestApiResponse] =
    FF.liftF(UpdateRestApiOp(request))

  def updateStage(
    request: UpdateStageRequest
  ): ApiGatewayIO[UpdateStageResponse] =
    FF.liftF(UpdateStageOp(request))

  def updateUsage(
    request: UpdateUsageRequest
  ): ApiGatewayIO[UpdateUsageResponse] =
    FF.liftF(UpdateUsageOp(request))

  def updateUsagePlan(
    request: UpdateUsagePlanRequest
  ): ApiGatewayIO[UpdateUsagePlanResponse] =
    FF.liftF(UpdateUsagePlanOp(request))

  def updateVpcLink(
    request: UpdateVpcLinkRequest
  ): ApiGatewayIO[UpdateVpcLinkResponse] =
    FF.liftF(UpdateVpcLinkOp(request))
}
