package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lambda.LambdaClient
import software.amazon.awssdk.services.lambda.model._


object lambda { module =>

  // Free monad over LambdaOp
  type LambdaIO[A] = FF[LambdaOp, A]

  sealed trait LambdaOp[A] {
    def visit[F[_]](visitor: LambdaOp.Visitor[F]): F[A]
  }

  object LambdaOp {
    // Given a LambdaClient we can embed a LambdaIO program in any algebra that understands embedding.
    implicit val LambdaOpEmbeddable: Embeddable[LambdaOp, LambdaClient] = new Embeddable[LambdaOp, LambdaClient] {
      def embed[A](client: LambdaClient, io: LambdaIO[A]): Embedded[A] = Embedded.Lambda(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LambdaOp.Visitor[Kleisli[M, LambdaClient, *]] {
        def addLayerVersionPermission(
          request: AddLayerVersionPermissionRequest
        ): Kleisli[M, LambdaClient, AddLayerVersionPermissionResponse] =
          primitive(_.addLayerVersionPermission(request))

        def addPermission(
          request: AddPermissionRequest
        ): Kleisli[M, LambdaClient, AddPermissionResponse] =
          primitive(_.addPermission(request))

        def createAlias(
          request: CreateAliasRequest
        ): Kleisli[M, LambdaClient, CreateAliasResponse] =
          primitive(_.createAlias(request))

        def createCodeSigningConfig(
          request: CreateCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, CreateCodeSigningConfigResponse] =
          primitive(_.createCodeSigningConfig(request))

        def createEventSourceMapping(
          request: CreateEventSourceMappingRequest
        ): Kleisli[M, LambdaClient, CreateEventSourceMappingResponse] =
          primitive(_.createEventSourceMapping(request))

        def createFunction(
          request: CreateFunctionRequest
        ): Kleisli[M, LambdaClient, CreateFunctionResponse] =
          primitive(_.createFunction(request))

        def deleteAlias(
          request: DeleteAliasRequest
        ): Kleisli[M, LambdaClient, DeleteAliasResponse] =
          primitive(_.deleteAlias(request))

        def deleteCodeSigningConfig(
          request: DeleteCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, DeleteCodeSigningConfigResponse] =
          primitive(_.deleteCodeSigningConfig(request))

        def deleteEventSourceMapping(
          request: DeleteEventSourceMappingRequest
        ): Kleisli[M, LambdaClient, DeleteEventSourceMappingResponse] =
          primitive(_.deleteEventSourceMapping(request))

        def deleteFunction(
          request: DeleteFunctionRequest
        ): Kleisli[M, LambdaClient, DeleteFunctionResponse] =
          primitive(_.deleteFunction(request))

        def deleteFunctionCodeSigningConfig(
          request: DeleteFunctionCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, DeleteFunctionCodeSigningConfigResponse] =
          primitive(_.deleteFunctionCodeSigningConfig(request))

        def deleteFunctionConcurrency(
          request: DeleteFunctionConcurrencyRequest
        ): Kleisli[M, LambdaClient, DeleteFunctionConcurrencyResponse] =
          primitive(_.deleteFunctionConcurrency(request))

        def deleteFunctionEventInvokeConfig(
          request: DeleteFunctionEventInvokeConfigRequest
        ): Kleisli[M, LambdaClient, DeleteFunctionEventInvokeConfigResponse] =
          primitive(_.deleteFunctionEventInvokeConfig(request))

        def deleteLayerVersion(
          request: DeleteLayerVersionRequest
        ): Kleisli[M, LambdaClient, DeleteLayerVersionResponse] =
          primitive(_.deleteLayerVersion(request))

        def deleteProvisionedConcurrencyConfig(
          request: DeleteProvisionedConcurrencyConfigRequest
        ): Kleisli[M, LambdaClient, DeleteProvisionedConcurrencyConfigResponse] =
          primitive(_.deleteProvisionedConcurrencyConfig(request))

        def getAccountSettings(
          request: GetAccountSettingsRequest
        ): Kleisli[M, LambdaClient, GetAccountSettingsResponse] =
          primitive(_.getAccountSettings(request))

        def getAlias(
          request: GetAliasRequest
        ): Kleisli[M, LambdaClient, GetAliasResponse] =
          primitive(_.getAlias(request))

        def getCodeSigningConfig(
          request: GetCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, GetCodeSigningConfigResponse] =
          primitive(_.getCodeSigningConfig(request))

        def getEventSourceMapping(
          request: GetEventSourceMappingRequest
        ): Kleisli[M, LambdaClient, GetEventSourceMappingResponse] =
          primitive(_.getEventSourceMapping(request))

        def getFunction(
          request: GetFunctionRequest
        ): Kleisli[M, LambdaClient, GetFunctionResponse] =
          primitive(_.getFunction(request))

        def getFunctionCodeSigningConfig(
          request: GetFunctionCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, GetFunctionCodeSigningConfigResponse] =
          primitive(_.getFunctionCodeSigningConfig(request))

        def getFunctionConcurrency(
          request: GetFunctionConcurrencyRequest
        ): Kleisli[M, LambdaClient, GetFunctionConcurrencyResponse] =
          primitive(_.getFunctionConcurrency(request))

        def getFunctionConfiguration(
          request: GetFunctionConfigurationRequest
        ): Kleisli[M, LambdaClient, GetFunctionConfigurationResponse] =
          primitive(_.getFunctionConfiguration(request))

        def getFunctionEventInvokeConfig(
          request: GetFunctionEventInvokeConfigRequest
        ): Kleisli[M, LambdaClient, GetFunctionEventInvokeConfigResponse] =
          primitive(_.getFunctionEventInvokeConfig(request))

        def getLayerVersion(
          request: GetLayerVersionRequest
        ): Kleisli[M, LambdaClient, GetLayerVersionResponse] =
          primitive(_.getLayerVersion(request))

        def getLayerVersionByArn(
          request: GetLayerVersionByArnRequest
        ): Kleisli[M, LambdaClient, GetLayerVersionByArnResponse] =
          primitive(_.getLayerVersionByArn(request))

        def getLayerVersionPolicy(
          request: GetLayerVersionPolicyRequest
        ): Kleisli[M, LambdaClient, GetLayerVersionPolicyResponse] =
          primitive(_.getLayerVersionPolicy(request))

        def getPolicy(
          request: GetPolicyRequest
        ): Kleisli[M, LambdaClient, GetPolicyResponse] =
          primitive(_.getPolicy(request))

        def getProvisionedConcurrencyConfig(
          request: GetProvisionedConcurrencyConfigRequest
        ): Kleisli[M, LambdaClient, GetProvisionedConcurrencyConfigResponse] =
          primitive(_.getProvisionedConcurrencyConfig(request))

        def invoke(
          request: InvokeRequest
        ): Kleisli[M, LambdaClient, InvokeResponse] =
          primitive(_.invoke(request))

        def listAliases(
          request: ListAliasesRequest
        ): Kleisli[M, LambdaClient, ListAliasesResponse] =
          primitive(_.listAliases(request))

        def listCodeSigningConfigs(
          request: ListCodeSigningConfigsRequest
        ): Kleisli[M, LambdaClient, ListCodeSigningConfigsResponse] =
          primitive(_.listCodeSigningConfigs(request))

        def listEventSourceMappings(
          request: ListEventSourceMappingsRequest
        ): Kleisli[M, LambdaClient, ListEventSourceMappingsResponse] =
          primitive(_.listEventSourceMappings(request))

        def listFunctionEventInvokeConfigs(
          request: ListFunctionEventInvokeConfigsRequest
        ): Kleisli[M, LambdaClient, ListFunctionEventInvokeConfigsResponse] =
          primitive(_.listFunctionEventInvokeConfigs(request))

        def listFunctions(
          request: ListFunctionsRequest
        ): Kleisli[M, LambdaClient, ListFunctionsResponse] =
          primitive(_.listFunctions(request))

        def listFunctionsByCodeSigningConfig(
          request: ListFunctionsByCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, ListFunctionsByCodeSigningConfigResponse] =
          primitive(_.listFunctionsByCodeSigningConfig(request))

        def listLayerVersions(
          request: ListLayerVersionsRequest
        ): Kleisli[M, LambdaClient, ListLayerVersionsResponse] =
          primitive(_.listLayerVersions(request))

        def listLayers(
          request: ListLayersRequest
        ): Kleisli[M, LambdaClient, ListLayersResponse] =
          primitive(_.listLayers(request))

        def listProvisionedConcurrencyConfigs(
          request: ListProvisionedConcurrencyConfigsRequest
        ): Kleisli[M, LambdaClient, ListProvisionedConcurrencyConfigsResponse] =
          primitive(_.listProvisionedConcurrencyConfigs(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, LambdaClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def listVersionsByFunction(
          request: ListVersionsByFunctionRequest
        ): Kleisli[M, LambdaClient, ListVersionsByFunctionResponse] =
          primitive(_.listVersionsByFunction(request))

        def publishLayerVersion(
          request: PublishLayerVersionRequest
        ): Kleisli[M, LambdaClient, PublishLayerVersionResponse] =
          primitive(_.publishLayerVersion(request))

        def publishVersion(
          request: PublishVersionRequest
        ): Kleisli[M, LambdaClient, PublishVersionResponse] =
          primitive(_.publishVersion(request))

        def putFunctionCodeSigningConfig(
          request: PutFunctionCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, PutFunctionCodeSigningConfigResponse] =
          primitive(_.putFunctionCodeSigningConfig(request))

        def putFunctionConcurrency(
          request: PutFunctionConcurrencyRequest
        ): Kleisli[M, LambdaClient, PutFunctionConcurrencyResponse] =
          primitive(_.putFunctionConcurrency(request))

        def putFunctionEventInvokeConfig(
          request: PutFunctionEventInvokeConfigRequest
        ): Kleisli[M, LambdaClient, PutFunctionEventInvokeConfigResponse] =
          primitive(_.putFunctionEventInvokeConfig(request))

        def putProvisionedConcurrencyConfig(
          request: PutProvisionedConcurrencyConfigRequest
        ): Kleisli[M, LambdaClient, PutProvisionedConcurrencyConfigResponse] =
          primitive(_.putProvisionedConcurrencyConfig(request))

        def removeLayerVersionPermission(
          request: RemoveLayerVersionPermissionRequest
        ): Kleisli[M, LambdaClient, RemoveLayerVersionPermissionResponse] =
          primitive(_.removeLayerVersionPermission(request))

        def removePermission(
          request: RemovePermissionRequest
        ): Kleisli[M, LambdaClient, RemovePermissionResponse] =
          primitive(_.removePermission(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LambdaClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LambdaClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAlias(
          request: UpdateAliasRequest
        ): Kleisli[M, LambdaClient, UpdateAliasResponse] =
          primitive(_.updateAlias(request))

        def updateCodeSigningConfig(
          request: UpdateCodeSigningConfigRequest
        ): Kleisli[M, LambdaClient, UpdateCodeSigningConfigResponse] =
          primitive(_.updateCodeSigningConfig(request))

        def updateEventSourceMapping(
          request: UpdateEventSourceMappingRequest
        ): Kleisli[M, LambdaClient, UpdateEventSourceMappingResponse] =
          primitive(_.updateEventSourceMapping(request))

        def updateFunctionCode(
          request: UpdateFunctionCodeRequest
        ): Kleisli[M, LambdaClient, UpdateFunctionCodeResponse] =
          primitive(_.updateFunctionCode(request))

        def updateFunctionConfiguration(
          request: UpdateFunctionConfigurationRequest
        ): Kleisli[M, LambdaClient, UpdateFunctionConfigurationResponse] =
          primitive(_.updateFunctionConfiguration(request))

        def updateFunctionEventInvokeConfig(
          request: UpdateFunctionEventInvokeConfigRequest
        ): Kleisli[M, LambdaClient, UpdateFunctionEventInvokeConfigResponse] =
          primitive(_.updateFunctionEventInvokeConfig(request))

        def primitive[A](
          f: LambdaClient => A
        ): Kleisli[M, LambdaClient, A]
      }
    }

    trait Visitor[F[_]] extends (LambdaOp ~> F) {
      final def apply[A](op: LambdaOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addLayerVersionPermission(
        request: AddLayerVersionPermissionRequest
      ): F[AddLayerVersionPermissionResponse]

      def addPermission(
        request: AddPermissionRequest
      ): F[AddPermissionResponse]

      def createAlias(
        request: CreateAliasRequest
      ): F[CreateAliasResponse]

      def createCodeSigningConfig(
        request: CreateCodeSigningConfigRequest
      ): F[CreateCodeSigningConfigResponse]

      def createEventSourceMapping(
        request: CreateEventSourceMappingRequest
      ): F[CreateEventSourceMappingResponse]

      def createFunction(
        request: CreateFunctionRequest
      ): F[CreateFunctionResponse]

      def deleteAlias(
        request: DeleteAliasRequest
      ): F[DeleteAliasResponse]

      def deleteCodeSigningConfig(
        request: DeleteCodeSigningConfigRequest
      ): F[DeleteCodeSigningConfigResponse]

      def deleteEventSourceMapping(
        request: DeleteEventSourceMappingRequest
      ): F[DeleteEventSourceMappingResponse]

      def deleteFunction(
        request: DeleteFunctionRequest
      ): F[DeleteFunctionResponse]

      def deleteFunctionCodeSigningConfig(
        request: DeleteFunctionCodeSigningConfigRequest
      ): F[DeleteFunctionCodeSigningConfigResponse]

      def deleteFunctionConcurrency(
        request: DeleteFunctionConcurrencyRequest
      ): F[DeleteFunctionConcurrencyResponse]

      def deleteFunctionEventInvokeConfig(
        request: DeleteFunctionEventInvokeConfigRequest
      ): F[DeleteFunctionEventInvokeConfigResponse]

      def deleteLayerVersion(
        request: DeleteLayerVersionRequest
      ): F[DeleteLayerVersionResponse]

      def deleteProvisionedConcurrencyConfig(
        request: DeleteProvisionedConcurrencyConfigRequest
      ): F[DeleteProvisionedConcurrencyConfigResponse]

      def getAccountSettings(
        request: GetAccountSettingsRequest
      ): F[GetAccountSettingsResponse]

      def getAlias(
        request: GetAliasRequest
      ): F[GetAliasResponse]

      def getCodeSigningConfig(
        request: GetCodeSigningConfigRequest
      ): F[GetCodeSigningConfigResponse]

      def getEventSourceMapping(
        request: GetEventSourceMappingRequest
      ): F[GetEventSourceMappingResponse]

      def getFunction(
        request: GetFunctionRequest
      ): F[GetFunctionResponse]

      def getFunctionCodeSigningConfig(
        request: GetFunctionCodeSigningConfigRequest
      ): F[GetFunctionCodeSigningConfigResponse]

      def getFunctionConcurrency(
        request: GetFunctionConcurrencyRequest
      ): F[GetFunctionConcurrencyResponse]

      def getFunctionConfiguration(
        request: GetFunctionConfigurationRequest
      ): F[GetFunctionConfigurationResponse]

      def getFunctionEventInvokeConfig(
        request: GetFunctionEventInvokeConfigRequest
      ): F[GetFunctionEventInvokeConfigResponse]

      def getLayerVersion(
        request: GetLayerVersionRequest
      ): F[GetLayerVersionResponse]

      def getLayerVersionByArn(
        request: GetLayerVersionByArnRequest
      ): F[GetLayerVersionByArnResponse]

      def getLayerVersionPolicy(
        request: GetLayerVersionPolicyRequest
      ): F[GetLayerVersionPolicyResponse]

      def getPolicy(
        request: GetPolicyRequest
      ): F[GetPolicyResponse]

      def getProvisionedConcurrencyConfig(
        request: GetProvisionedConcurrencyConfigRequest
      ): F[GetProvisionedConcurrencyConfigResponse]

      def invoke(
        request: InvokeRequest
      ): F[InvokeResponse]

      def listAliases(
        request: ListAliasesRequest
      ): F[ListAliasesResponse]

      def listCodeSigningConfigs(
        request: ListCodeSigningConfigsRequest
      ): F[ListCodeSigningConfigsResponse]

      def listEventSourceMappings(
        request: ListEventSourceMappingsRequest
      ): F[ListEventSourceMappingsResponse]

      def listFunctionEventInvokeConfigs(
        request: ListFunctionEventInvokeConfigsRequest
      ): F[ListFunctionEventInvokeConfigsResponse]

      def listFunctions(
        request: ListFunctionsRequest
      ): F[ListFunctionsResponse]

      def listFunctionsByCodeSigningConfig(
        request: ListFunctionsByCodeSigningConfigRequest
      ): F[ListFunctionsByCodeSigningConfigResponse]

      def listLayerVersions(
        request: ListLayerVersionsRequest
      ): F[ListLayerVersionsResponse]

      def listLayers(
        request: ListLayersRequest
      ): F[ListLayersResponse]

      def listProvisionedConcurrencyConfigs(
        request: ListProvisionedConcurrencyConfigsRequest
      ): F[ListProvisionedConcurrencyConfigsResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def listVersionsByFunction(
        request: ListVersionsByFunctionRequest
      ): F[ListVersionsByFunctionResponse]

      def publishLayerVersion(
        request: PublishLayerVersionRequest
      ): F[PublishLayerVersionResponse]

      def publishVersion(
        request: PublishVersionRequest
      ): F[PublishVersionResponse]

      def putFunctionCodeSigningConfig(
        request: PutFunctionCodeSigningConfigRequest
      ): F[PutFunctionCodeSigningConfigResponse]

      def putFunctionConcurrency(
        request: PutFunctionConcurrencyRequest
      ): F[PutFunctionConcurrencyResponse]

      def putFunctionEventInvokeConfig(
        request: PutFunctionEventInvokeConfigRequest
      ): F[PutFunctionEventInvokeConfigResponse]

      def putProvisionedConcurrencyConfig(
        request: PutProvisionedConcurrencyConfigRequest
      ): F[PutProvisionedConcurrencyConfigResponse]

      def removeLayerVersionPermission(
        request: RemoveLayerVersionPermissionRequest
      ): F[RemoveLayerVersionPermissionResponse]

      def removePermission(
        request: RemovePermissionRequest
      ): F[RemovePermissionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAlias(
        request: UpdateAliasRequest
      ): F[UpdateAliasResponse]

      def updateCodeSigningConfig(
        request: UpdateCodeSigningConfigRequest
      ): F[UpdateCodeSigningConfigResponse]

      def updateEventSourceMapping(
        request: UpdateEventSourceMappingRequest
      ): F[UpdateEventSourceMappingResponse]

      def updateFunctionCode(
        request: UpdateFunctionCodeRequest
      ): F[UpdateFunctionCodeResponse]

      def updateFunctionConfiguration(
        request: UpdateFunctionConfigurationRequest
      ): F[UpdateFunctionConfigurationResponse]

      def updateFunctionEventInvokeConfig(
        request: UpdateFunctionEventInvokeConfigRequest
      ): F[UpdateFunctionEventInvokeConfigResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LambdaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddLayerVersionPermissionOp(
      request: AddLayerVersionPermissionRequest
    ) extends LambdaOp[AddLayerVersionPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddLayerVersionPermissionResponse] =
        visitor.addLayerVersionPermission(request)
    }

    final case class AddPermissionOp(
      request: AddPermissionRequest
    ) extends LambdaOp[AddPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddPermissionResponse] =
        visitor.addPermission(request)
    }

    final case class CreateAliasOp(
      request: CreateAliasRequest
    ) extends LambdaOp[CreateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAliasResponse] =
        visitor.createAlias(request)
    }

    final case class CreateCodeSigningConfigOp(
      request: CreateCodeSigningConfigRequest
    ) extends LambdaOp[CreateCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCodeSigningConfigResponse] =
        visitor.createCodeSigningConfig(request)
    }

    final case class CreateEventSourceMappingOp(
      request: CreateEventSourceMappingRequest
    ) extends LambdaOp[CreateEventSourceMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventSourceMappingResponse] =
        visitor.createEventSourceMapping(request)
    }

    final case class CreateFunctionOp(
      request: CreateFunctionRequest
    ) extends LambdaOp[CreateFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFunctionResponse] =
        visitor.createFunction(request)
    }

    final case class DeleteAliasOp(
      request: DeleteAliasRequest
    ) extends LambdaOp[DeleteAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAliasResponse] =
        visitor.deleteAlias(request)
    }

    final case class DeleteCodeSigningConfigOp(
      request: DeleteCodeSigningConfigRequest
    ) extends LambdaOp[DeleteCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCodeSigningConfigResponse] =
        visitor.deleteCodeSigningConfig(request)
    }

    final case class DeleteEventSourceMappingOp(
      request: DeleteEventSourceMappingRequest
    ) extends LambdaOp[DeleteEventSourceMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventSourceMappingResponse] =
        visitor.deleteEventSourceMapping(request)
    }

    final case class DeleteFunctionOp(
      request: DeleteFunctionRequest
    ) extends LambdaOp[DeleteFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFunctionResponse] =
        visitor.deleteFunction(request)
    }

    final case class DeleteFunctionCodeSigningConfigOp(
      request: DeleteFunctionCodeSigningConfigRequest
    ) extends LambdaOp[DeleteFunctionCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFunctionCodeSigningConfigResponse] =
        visitor.deleteFunctionCodeSigningConfig(request)
    }

    final case class DeleteFunctionConcurrencyOp(
      request: DeleteFunctionConcurrencyRequest
    ) extends LambdaOp[DeleteFunctionConcurrencyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFunctionConcurrencyResponse] =
        visitor.deleteFunctionConcurrency(request)
    }

    final case class DeleteFunctionEventInvokeConfigOp(
      request: DeleteFunctionEventInvokeConfigRequest
    ) extends LambdaOp[DeleteFunctionEventInvokeConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFunctionEventInvokeConfigResponse] =
        visitor.deleteFunctionEventInvokeConfig(request)
    }

    final case class DeleteLayerVersionOp(
      request: DeleteLayerVersionRequest
    ) extends LambdaOp[DeleteLayerVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLayerVersionResponse] =
        visitor.deleteLayerVersion(request)
    }

    final case class DeleteProvisionedConcurrencyConfigOp(
      request: DeleteProvisionedConcurrencyConfigRequest
    ) extends LambdaOp[DeleteProvisionedConcurrencyConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProvisionedConcurrencyConfigResponse] =
        visitor.deleteProvisionedConcurrencyConfig(request)
    }

    final case class GetAccountSettingsOp(
      request: GetAccountSettingsRequest
    ) extends LambdaOp[GetAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountSettingsResponse] =
        visitor.getAccountSettings(request)
    }

    final case class GetAliasOp(
      request: GetAliasRequest
    ) extends LambdaOp[GetAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAliasResponse] =
        visitor.getAlias(request)
    }

    final case class GetCodeSigningConfigOp(
      request: GetCodeSigningConfigRequest
    ) extends LambdaOp[GetCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCodeSigningConfigResponse] =
        visitor.getCodeSigningConfig(request)
    }

    final case class GetEventSourceMappingOp(
      request: GetEventSourceMappingRequest
    ) extends LambdaOp[GetEventSourceMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEventSourceMappingResponse] =
        visitor.getEventSourceMapping(request)
    }

    final case class GetFunctionOp(
      request: GetFunctionRequest
    ) extends LambdaOp[GetFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionResponse] =
        visitor.getFunction(request)
    }

    final case class GetFunctionCodeSigningConfigOp(
      request: GetFunctionCodeSigningConfigRequest
    ) extends LambdaOp[GetFunctionCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionCodeSigningConfigResponse] =
        visitor.getFunctionCodeSigningConfig(request)
    }

    final case class GetFunctionConcurrencyOp(
      request: GetFunctionConcurrencyRequest
    ) extends LambdaOp[GetFunctionConcurrencyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionConcurrencyResponse] =
        visitor.getFunctionConcurrency(request)
    }

    final case class GetFunctionConfigurationOp(
      request: GetFunctionConfigurationRequest
    ) extends LambdaOp[GetFunctionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionConfigurationResponse] =
        visitor.getFunctionConfiguration(request)
    }

    final case class GetFunctionEventInvokeConfigOp(
      request: GetFunctionEventInvokeConfigRequest
    ) extends LambdaOp[GetFunctionEventInvokeConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionEventInvokeConfigResponse] =
        visitor.getFunctionEventInvokeConfig(request)
    }

    final case class GetLayerVersionOp(
      request: GetLayerVersionRequest
    ) extends LambdaOp[GetLayerVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLayerVersionResponse] =
        visitor.getLayerVersion(request)
    }

    final case class GetLayerVersionByArnOp(
      request: GetLayerVersionByArnRequest
    ) extends LambdaOp[GetLayerVersionByArnResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLayerVersionByArnResponse] =
        visitor.getLayerVersionByArn(request)
    }

    final case class GetLayerVersionPolicyOp(
      request: GetLayerVersionPolicyRequest
    ) extends LambdaOp[GetLayerVersionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLayerVersionPolicyResponse] =
        visitor.getLayerVersionPolicy(request)
    }

    final case class GetPolicyOp(
      request: GetPolicyRequest
    ) extends LambdaOp[GetPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyResponse] =
        visitor.getPolicy(request)
    }

    final case class GetProvisionedConcurrencyConfigOp(
      request: GetProvisionedConcurrencyConfigRequest
    ) extends LambdaOp[GetProvisionedConcurrencyConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProvisionedConcurrencyConfigResponse] =
        visitor.getProvisionedConcurrencyConfig(request)
    }

    final case class InvokeOp(
      request: InvokeRequest
    ) extends LambdaOp[InvokeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InvokeResponse] =
        visitor.invoke(request)
    }

    final case class ListAliasesOp(
      request: ListAliasesRequest
    ) extends LambdaOp[ListAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAliasesResponse] =
        visitor.listAliases(request)
    }

    final case class ListCodeSigningConfigsOp(
      request: ListCodeSigningConfigsRequest
    ) extends LambdaOp[ListCodeSigningConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCodeSigningConfigsResponse] =
        visitor.listCodeSigningConfigs(request)
    }

    final case class ListEventSourceMappingsOp(
      request: ListEventSourceMappingsRequest
    ) extends LambdaOp[ListEventSourceMappingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventSourceMappingsResponse] =
        visitor.listEventSourceMappings(request)
    }

    final case class ListFunctionEventInvokeConfigsOp(
      request: ListFunctionEventInvokeConfigsRequest
    ) extends LambdaOp[ListFunctionEventInvokeConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFunctionEventInvokeConfigsResponse] =
        visitor.listFunctionEventInvokeConfigs(request)
    }

    final case class ListFunctionsOp(
      request: ListFunctionsRequest
    ) extends LambdaOp[ListFunctionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFunctionsResponse] =
        visitor.listFunctions(request)
    }

    final case class ListFunctionsByCodeSigningConfigOp(
      request: ListFunctionsByCodeSigningConfigRequest
    ) extends LambdaOp[ListFunctionsByCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFunctionsByCodeSigningConfigResponse] =
        visitor.listFunctionsByCodeSigningConfig(request)
    }

    final case class ListLayerVersionsOp(
      request: ListLayerVersionsRequest
    ) extends LambdaOp[ListLayerVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLayerVersionsResponse] =
        visitor.listLayerVersions(request)
    }

    final case class ListLayersOp(
      request: ListLayersRequest
    ) extends LambdaOp[ListLayersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLayersResponse] =
        visitor.listLayers(request)
    }

    final case class ListProvisionedConcurrencyConfigsOp(
      request: ListProvisionedConcurrencyConfigsRequest
    ) extends LambdaOp[ListProvisionedConcurrencyConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProvisionedConcurrencyConfigsResponse] =
        visitor.listProvisionedConcurrencyConfigs(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends LambdaOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class ListVersionsByFunctionOp(
      request: ListVersionsByFunctionRequest
    ) extends LambdaOp[ListVersionsByFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVersionsByFunctionResponse] =
        visitor.listVersionsByFunction(request)
    }

    final case class PublishLayerVersionOp(
      request: PublishLayerVersionRequest
    ) extends LambdaOp[PublishLayerVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishLayerVersionResponse] =
        visitor.publishLayerVersion(request)
    }

    final case class PublishVersionOp(
      request: PublishVersionRequest
    ) extends LambdaOp[PublishVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishVersionResponse] =
        visitor.publishVersion(request)
    }

    final case class PutFunctionCodeSigningConfigOp(
      request: PutFunctionCodeSigningConfigRequest
    ) extends LambdaOp[PutFunctionCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFunctionCodeSigningConfigResponse] =
        visitor.putFunctionCodeSigningConfig(request)
    }

    final case class PutFunctionConcurrencyOp(
      request: PutFunctionConcurrencyRequest
    ) extends LambdaOp[PutFunctionConcurrencyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFunctionConcurrencyResponse] =
        visitor.putFunctionConcurrency(request)
    }

    final case class PutFunctionEventInvokeConfigOp(
      request: PutFunctionEventInvokeConfigRequest
    ) extends LambdaOp[PutFunctionEventInvokeConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFunctionEventInvokeConfigResponse] =
        visitor.putFunctionEventInvokeConfig(request)
    }

    final case class PutProvisionedConcurrencyConfigOp(
      request: PutProvisionedConcurrencyConfigRequest
    ) extends LambdaOp[PutProvisionedConcurrencyConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutProvisionedConcurrencyConfigResponse] =
        visitor.putProvisionedConcurrencyConfig(request)
    }

    final case class RemoveLayerVersionPermissionOp(
      request: RemoveLayerVersionPermissionRequest
    ) extends LambdaOp[RemoveLayerVersionPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveLayerVersionPermissionResponse] =
        visitor.removeLayerVersionPermission(request)
    }

    final case class RemovePermissionOp(
      request: RemovePermissionRequest
    ) extends LambdaOp[RemovePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemovePermissionResponse] =
        visitor.removePermission(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LambdaOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LambdaOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAliasOp(
      request: UpdateAliasRequest
    ) extends LambdaOp[UpdateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAliasResponse] =
        visitor.updateAlias(request)
    }

    final case class UpdateCodeSigningConfigOp(
      request: UpdateCodeSigningConfigRequest
    ) extends LambdaOp[UpdateCodeSigningConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCodeSigningConfigResponse] =
        visitor.updateCodeSigningConfig(request)
    }

    final case class UpdateEventSourceMappingOp(
      request: UpdateEventSourceMappingRequest
    ) extends LambdaOp[UpdateEventSourceMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEventSourceMappingResponse] =
        visitor.updateEventSourceMapping(request)
    }

    final case class UpdateFunctionCodeOp(
      request: UpdateFunctionCodeRequest
    ) extends LambdaOp[UpdateFunctionCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFunctionCodeResponse] =
        visitor.updateFunctionCode(request)
    }

    final case class UpdateFunctionConfigurationOp(
      request: UpdateFunctionConfigurationRequest
    ) extends LambdaOp[UpdateFunctionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFunctionConfigurationResponse] =
        visitor.updateFunctionConfiguration(request)
    }

    final case class UpdateFunctionEventInvokeConfigOp(
      request: UpdateFunctionEventInvokeConfigRequest
    ) extends LambdaOp[UpdateFunctionEventInvokeConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFunctionEventInvokeConfigResponse] =
        visitor.updateFunctionEventInvokeConfig(request)
    }
  }

  import LambdaOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LambdaOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addLayerVersionPermission(
    request: AddLayerVersionPermissionRequest
  ): LambdaIO[AddLayerVersionPermissionResponse] =
    FF.liftF(AddLayerVersionPermissionOp(request))

  def addPermission(
    request: AddPermissionRequest
  ): LambdaIO[AddPermissionResponse] =
    FF.liftF(AddPermissionOp(request))

  def createAlias(
    request: CreateAliasRequest
  ): LambdaIO[CreateAliasResponse] =
    FF.liftF(CreateAliasOp(request))

  def createCodeSigningConfig(
    request: CreateCodeSigningConfigRequest
  ): LambdaIO[CreateCodeSigningConfigResponse] =
    FF.liftF(CreateCodeSigningConfigOp(request))

  def createEventSourceMapping(
    request: CreateEventSourceMappingRequest
  ): LambdaIO[CreateEventSourceMappingResponse] =
    FF.liftF(CreateEventSourceMappingOp(request))

  def createFunction(
    request: CreateFunctionRequest
  ): LambdaIO[CreateFunctionResponse] =
    FF.liftF(CreateFunctionOp(request))

  def deleteAlias(
    request: DeleteAliasRequest
  ): LambdaIO[DeleteAliasResponse] =
    FF.liftF(DeleteAliasOp(request))

  def deleteCodeSigningConfig(
    request: DeleteCodeSigningConfigRequest
  ): LambdaIO[DeleteCodeSigningConfigResponse] =
    FF.liftF(DeleteCodeSigningConfigOp(request))

  def deleteEventSourceMapping(
    request: DeleteEventSourceMappingRequest
  ): LambdaIO[DeleteEventSourceMappingResponse] =
    FF.liftF(DeleteEventSourceMappingOp(request))

  def deleteFunction(
    request: DeleteFunctionRequest
  ): LambdaIO[DeleteFunctionResponse] =
    FF.liftF(DeleteFunctionOp(request))

  def deleteFunctionCodeSigningConfig(
    request: DeleteFunctionCodeSigningConfigRequest
  ): LambdaIO[DeleteFunctionCodeSigningConfigResponse] =
    FF.liftF(DeleteFunctionCodeSigningConfigOp(request))

  def deleteFunctionConcurrency(
    request: DeleteFunctionConcurrencyRequest
  ): LambdaIO[DeleteFunctionConcurrencyResponse] =
    FF.liftF(DeleteFunctionConcurrencyOp(request))

  def deleteFunctionEventInvokeConfig(
    request: DeleteFunctionEventInvokeConfigRequest
  ): LambdaIO[DeleteFunctionEventInvokeConfigResponse] =
    FF.liftF(DeleteFunctionEventInvokeConfigOp(request))

  def deleteLayerVersion(
    request: DeleteLayerVersionRequest
  ): LambdaIO[DeleteLayerVersionResponse] =
    FF.liftF(DeleteLayerVersionOp(request))

  def deleteProvisionedConcurrencyConfig(
    request: DeleteProvisionedConcurrencyConfigRequest
  ): LambdaIO[DeleteProvisionedConcurrencyConfigResponse] =
    FF.liftF(DeleteProvisionedConcurrencyConfigOp(request))

  def getAccountSettings(
    request: GetAccountSettingsRequest
  ): LambdaIO[GetAccountSettingsResponse] =
    FF.liftF(GetAccountSettingsOp(request))

  def getAlias(
    request: GetAliasRequest
  ): LambdaIO[GetAliasResponse] =
    FF.liftF(GetAliasOp(request))

  def getCodeSigningConfig(
    request: GetCodeSigningConfigRequest
  ): LambdaIO[GetCodeSigningConfigResponse] =
    FF.liftF(GetCodeSigningConfigOp(request))

  def getEventSourceMapping(
    request: GetEventSourceMappingRequest
  ): LambdaIO[GetEventSourceMappingResponse] =
    FF.liftF(GetEventSourceMappingOp(request))

  def getFunction(
    request: GetFunctionRequest
  ): LambdaIO[GetFunctionResponse] =
    FF.liftF(GetFunctionOp(request))

  def getFunctionCodeSigningConfig(
    request: GetFunctionCodeSigningConfigRequest
  ): LambdaIO[GetFunctionCodeSigningConfigResponse] =
    FF.liftF(GetFunctionCodeSigningConfigOp(request))

  def getFunctionConcurrency(
    request: GetFunctionConcurrencyRequest
  ): LambdaIO[GetFunctionConcurrencyResponse] =
    FF.liftF(GetFunctionConcurrencyOp(request))

  def getFunctionConfiguration(
    request: GetFunctionConfigurationRequest
  ): LambdaIO[GetFunctionConfigurationResponse] =
    FF.liftF(GetFunctionConfigurationOp(request))

  def getFunctionEventInvokeConfig(
    request: GetFunctionEventInvokeConfigRequest
  ): LambdaIO[GetFunctionEventInvokeConfigResponse] =
    FF.liftF(GetFunctionEventInvokeConfigOp(request))

  def getLayerVersion(
    request: GetLayerVersionRequest
  ): LambdaIO[GetLayerVersionResponse] =
    FF.liftF(GetLayerVersionOp(request))

  def getLayerVersionByArn(
    request: GetLayerVersionByArnRequest
  ): LambdaIO[GetLayerVersionByArnResponse] =
    FF.liftF(GetLayerVersionByArnOp(request))

  def getLayerVersionPolicy(
    request: GetLayerVersionPolicyRequest
  ): LambdaIO[GetLayerVersionPolicyResponse] =
    FF.liftF(GetLayerVersionPolicyOp(request))

  def getPolicy(
    request: GetPolicyRequest
  ): LambdaIO[GetPolicyResponse] =
    FF.liftF(GetPolicyOp(request))

  def getProvisionedConcurrencyConfig(
    request: GetProvisionedConcurrencyConfigRequest
  ): LambdaIO[GetProvisionedConcurrencyConfigResponse] =
    FF.liftF(GetProvisionedConcurrencyConfigOp(request))

  def invoke(
    request: InvokeRequest
  ): LambdaIO[InvokeResponse] =
    FF.liftF(InvokeOp(request))

  def listAliases(
    request: ListAliasesRequest
  ): LambdaIO[ListAliasesResponse] =
    FF.liftF(ListAliasesOp(request))

  def listCodeSigningConfigs(
    request: ListCodeSigningConfigsRequest
  ): LambdaIO[ListCodeSigningConfigsResponse] =
    FF.liftF(ListCodeSigningConfigsOp(request))

  def listEventSourceMappings(
    request: ListEventSourceMappingsRequest
  ): LambdaIO[ListEventSourceMappingsResponse] =
    FF.liftF(ListEventSourceMappingsOp(request))

  def listFunctionEventInvokeConfigs(
    request: ListFunctionEventInvokeConfigsRequest
  ): LambdaIO[ListFunctionEventInvokeConfigsResponse] =
    FF.liftF(ListFunctionEventInvokeConfigsOp(request))

  def listFunctions(
    request: ListFunctionsRequest
  ): LambdaIO[ListFunctionsResponse] =
    FF.liftF(ListFunctionsOp(request))

  def listFunctionsByCodeSigningConfig(
    request: ListFunctionsByCodeSigningConfigRequest
  ): LambdaIO[ListFunctionsByCodeSigningConfigResponse] =
    FF.liftF(ListFunctionsByCodeSigningConfigOp(request))

  def listLayerVersions(
    request: ListLayerVersionsRequest
  ): LambdaIO[ListLayerVersionsResponse] =
    FF.liftF(ListLayerVersionsOp(request))

  def listLayers(
    request: ListLayersRequest
  ): LambdaIO[ListLayersResponse] =
    FF.liftF(ListLayersOp(request))

  def listProvisionedConcurrencyConfigs(
    request: ListProvisionedConcurrencyConfigsRequest
  ): LambdaIO[ListProvisionedConcurrencyConfigsResponse] =
    FF.liftF(ListProvisionedConcurrencyConfigsOp(request))

  def listTags(
    request: ListTagsRequest
  ): LambdaIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def listVersionsByFunction(
    request: ListVersionsByFunctionRequest
  ): LambdaIO[ListVersionsByFunctionResponse] =
    FF.liftF(ListVersionsByFunctionOp(request))

  def publishLayerVersion(
    request: PublishLayerVersionRequest
  ): LambdaIO[PublishLayerVersionResponse] =
    FF.liftF(PublishLayerVersionOp(request))

  def publishVersion(
    request: PublishVersionRequest
  ): LambdaIO[PublishVersionResponse] =
    FF.liftF(PublishVersionOp(request))

  def putFunctionCodeSigningConfig(
    request: PutFunctionCodeSigningConfigRequest
  ): LambdaIO[PutFunctionCodeSigningConfigResponse] =
    FF.liftF(PutFunctionCodeSigningConfigOp(request))

  def putFunctionConcurrency(
    request: PutFunctionConcurrencyRequest
  ): LambdaIO[PutFunctionConcurrencyResponse] =
    FF.liftF(PutFunctionConcurrencyOp(request))

  def putFunctionEventInvokeConfig(
    request: PutFunctionEventInvokeConfigRequest
  ): LambdaIO[PutFunctionEventInvokeConfigResponse] =
    FF.liftF(PutFunctionEventInvokeConfigOp(request))

  def putProvisionedConcurrencyConfig(
    request: PutProvisionedConcurrencyConfigRequest
  ): LambdaIO[PutProvisionedConcurrencyConfigResponse] =
    FF.liftF(PutProvisionedConcurrencyConfigOp(request))

  def removeLayerVersionPermission(
    request: RemoveLayerVersionPermissionRequest
  ): LambdaIO[RemoveLayerVersionPermissionResponse] =
    FF.liftF(RemoveLayerVersionPermissionOp(request))

  def removePermission(
    request: RemovePermissionRequest
  ): LambdaIO[RemovePermissionResponse] =
    FF.liftF(RemovePermissionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LambdaIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LambdaIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAlias(
    request: UpdateAliasRequest
  ): LambdaIO[UpdateAliasResponse] =
    FF.liftF(UpdateAliasOp(request))

  def updateCodeSigningConfig(
    request: UpdateCodeSigningConfigRequest
  ): LambdaIO[UpdateCodeSigningConfigResponse] =
    FF.liftF(UpdateCodeSigningConfigOp(request))

  def updateEventSourceMapping(
    request: UpdateEventSourceMappingRequest
  ): LambdaIO[UpdateEventSourceMappingResponse] =
    FF.liftF(UpdateEventSourceMappingOp(request))

  def updateFunctionCode(
    request: UpdateFunctionCodeRequest
  ): LambdaIO[UpdateFunctionCodeResponse] =
    FF.liftF(UpdateFunctionCodeOp(request))

  def updateFunctionConfiguration(
    request: UpdateFunctionConfigurationRequest
  ): LambdaIO[UpdateFunctionConfigurationResponse] =
    FF.liftF(UpdateFunctionConfigurationOp(request))

  def updateFunctionEventInvokeConfig(
    request: UpdateFunctionEventInvokeConfigRequest
  ): LambdaIO[UpdateFunctionEventInvokeConfigResponse] =
    FF.liftF(UpdateFunctionEventInvokeConfigOp(request))
}
