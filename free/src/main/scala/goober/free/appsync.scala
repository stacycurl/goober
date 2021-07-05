package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.appsync.AppSyncClient
import software.amazon.awssdk.services.appsync.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object appsync { module =>

  // Free monad over AppSyncOp
  type AppSyncIO[A] = FF[AppSyncOp, A]

  sealed trait AppSyncOp[A] {
    def visit[F[_]](visitor: AppSyncOp.Visitor[F]): F[A]
  }

  object AppSyncOp {
    // Given a AppSyncClient we can embed a AppSyncIO program in any algebra that understands embedding.
    implicit val AppSyncOpEmbeddable: Embeddable[AppSyncOp, AppSyncClient] = new Embeddable[AppSyncOp, AppSyncClient] {
      def embed[A](client: AppSyncClient, io: AppSyncIO[A]): Embedded[A] = Embedded.AppSync(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AppSyncOp.Visitor[Kleisli[M, AppSyncClient, *]] {
        def createApiCache(
          request: CreateApiCacheRequest
        ): Kleisli[M, AppSyncClient, CreateApiCacheResponse] =
          primitive(_.createApiCache(request))

        def createApiKey(
          request: CreateApiKeyRequest
        ): Kleisli[M, AppSyncClient, CreateApiKeyResponse] =
          primitive(_.createApiKey(request))

        def createDataSource(
          request: CreateDataSourceRequest
        ): Kleisli[M, AppSyncClient, CreateDataSourceResponse] =
          primitive(_.createDataSource(request))

        def createFunction(
          request: CreateFunctionRequest
        ): Kleisli[M, AppSyncClient, CreateFunctionResponse] =
          primitive(_.createFunction(request))

        def createGraphqlApi(
          request: CreateGraphqlApiRequest
        ): Kleisli[M, AppSyncClient, CreateGraphqlApiResponse] =
          primitive(_.createGraphqlApi(request))

        def createResolver(
          request: CreateResolverRequest
        ): Kleisli[M, AppSyncClient, CreateResolverResponse] =
          primitive(_.createResolver(request))

        def createType(
          request: CreateTypeRequest
        ): Kleisli[M, AppSyncClient, CreateTypeResponse] =
          primitive(_.createType(request))

        def deleteApiCache(
          request: DeleteApiCacheRequest
        ): Kleisli[M, AppSyncClient, DeleteApiCacheResponse] =
          primitive(_.deleteApiCache(request))

        def deleteApiKey(
          request: DeleteApiKeyRequest
        ): Kleisli[M, AppSyncClient, DeleteApiKeyResponse] =
          primitive(_.deleteApiKey(request))

        def deleteDataSource(
          request: DeleteDataSourceRequest
        ): Kleisli[M, AppSyncClient, DeleteDataSourceResponse] =
          primitive(_.deleteDataSource(request))

        def deleteFunction(
          request: DeleteFunctionRequest
        ): Kleisli[M, AppSyncClient, DeleteFunctionResponse] =
          primitive(_.deleteFunction(request))

        def deleteGraphqlApi(
          request: DeleteGraphqlApiRequest
        ): Kleisli[M, AppSyncClient, DeleteGraphqlApiResponse] =
          primitive(_.deleteGraphqlApi(request))

        def deleteResolver(
          request: DeleteResolverRequest
        ): Kleisli[M, AppSyncClient, DeleteResolverResponse] =
          primitive(_.deleteResolver(request))

        def deleteType(
          request: DeleteTypeRequest
        ): Kleisli[M, AppSyncClient, DeleteTypeResponse] =
          primitive(_.deleteType(request))

        def flushApiCache(
          request: FlushApiCacheRequest
        ): Kleisli[M, AppSyncClient, FlushApiCacheResponse] =
          primitive(_.flushApiCache(request))

        def getApiCache(
          request: GetApiCacheRequest
        ): Kleisli[M, AppSyncClient, GetApiCacheResponse] =
          primitive(_.getApiCache(request))

        def getDataSource(
          request: GetDataSourceRequest
        ): Kleisli[M, AppSyncClient, GetDataSourceResponse] =
          primitive(_.getDataSource(request))

        def getFunction(
          request: GetFunctionRequest
        ): Kleisli[M, AppSyncClient, GetFunctionResponse] =
          primitive(_.getFunction(request))

        def getGraphqlApi(
          request: GetGraphqlApiRequest
        ): Kleisli[M, AppSyncClient, GetGraphqlApiResponse] =
          primitive(_.getGraphqlApi(request))

        def getIntrospectionSchema(
          request: GetIntrospectionSchemaRequest
        ): Kleisli[M, AppSyncClient, GetIntrospectionSchemaResponse] =
          primitive(_.getIntrospectionSchema(request))

        def getResolver(
          request: GetResolverRequest
        ): Kleisli[M, AppSyncClient, GetResolverResponse] =
          primitive(_.getResolver(request))

        def getSchemaCreationStatus(
          request: GetSchemaCreationStatusRequest
        ): Kleisli[M, AppSyncClient, GetSchemaCreationStatusResponse] =
          primitive(_.getSchemaCreationStatus(request))

        def getType(
          request: GetTypeRequest
        ): Kleisli[M, AppSyncClient, GetTypeResponse] =
          primitive(_.getType(request))

        def listApiKeys(
          request: ListApiKeysRequest
        ): Kleisli[M, AppSyncClient, ListApiKeysResponse] =
          primitive(_.listApiKeys(request))

        def listDataSources(
          request: ListDataSourcesRequest
        ): Kleisli[M, AppSyncClient, ListDataSourcesResponse] =
          primitive(_.listDataSources(request))

        def listFunctions(
          request: ListFunctionsRequest
        ): Kleisli[M, AppSyncClient, ListFunctionsResponse] =
          primitive(_.listFunctions(request))

        def listGraphqlApis(
          request: ListGraphqlApisRequest
        ): Kleisli[M, AppSyncClient, ListGraphqlApisResponse] =
          primitive(_.listGraphqlApis(request))

        def listResolvers(
          request: ListResolversRequest
        ): Kleisli[M, AppSyncClient, ListResolversResponse] =
          primitive(_.listResolvers(request))

        def listResolversByFunction(
          request: ListResolversByFunctionRequest
        ): Kleisli[M, AppSyncClient, ListResolversByFunctionResponse] =
          primitive(_.listResolversByFunction(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AppSyncClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTypes(
          request: ListTypesRequest
        ): Kleisli[M, AppSyncClient, ListTypesResponse] =
          primitive(_.listTypes(request))

        def startSchemaCreation(
          request: StartSchemaCreationRequest
        ): Kleisli[M, AppSyncClient, StartSchemaCreationResponse] =
          primitive(_.startSchemaCreation(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AppSyncClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AppSyncClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApiCache(
          request: UpdateApiCacheRequest
        ): Kleisli[M, AppSyncClient, UpdateApiCacheResponse] =
          primitive(_.updateApiCache(request))

        def updateApiKey(
          request: UpdateApiKeyRequest
        ): Kleisli[M, AppSyncClient, UpdateApiKeyResponse] =
          primitive(_.updateApiKey(request))

        def updateDataSource(
          request: UpdateDataSourceRequest
        ): Kleisli[M, AppSyncClient, UpdateDataSourceResponse] =
          primitive(_.updateDataSource(request))

        def updateFunction(
          request: UpdateFunctionRequest
        ): Kleisli[M, AppSyncClient, UpdateFunctionResponse] =
          primitive(_.updateFunction(request))

        def updateGraphqlApi(
          request: UpdateGraphqlApiRequest
        ): Kleisli[M, AppSyncClient, UpdateGraphqlApiResponse] =
          primitive(_.updateGraphqlApi(request))

        def updateResolver(
          request: UpdateResolverRequest
        ): Kleisli[M, AppSyncClient, UpdateResolverResponse] =
          primitive(_.updateResolver(request))

        def updateType(
          request: UpdateTypeRequest
        ): Kleisli[M, AppSyncClient, UpdateTypeResponse] =
          primitive(_.updateType(request))

        def primitive[A](
          f: AppSyncClient => A
        ): Kleisli[M, AppSyncClient, A]
      }
    }

    trait Visitor[F[_]] extends (AppSyncOp ~> F) {
      final def apply[A](op: AppSyncOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApiCache(
        request: CreateApiCacheRequest
      ): F[CreateApiCacheResponse]

      def createApiKey(
        request: CreateApiKeyRequest
      ): F[CreateApiKeyResponse]

      def createDataSource(
        request: CreateDataSourceRequest
      ): F[CreateDataSourceResponse]

      def createFunction(
        request: CreateFunctionRequest
      ): F[CreateFunctionResponse]

      def createGraphqlApi(
        request: CreateGraphqlApiRequest
      ): F[CreateGraphqlApiResponse]

      def createResolver(
        request: CreateResolverRequest
      ): F[CreateResolverResponse]

      def createType(
        request: CreateTypeRequest
      ): F[CreateTypeResponse]

      def deleteApiCache(
        request: DeleteApiCacheRequest
      ): F[DeleteApiCacheResponse]

      def deleteApiKey(
        request: DeleteApiKeyRequest
      ): F[DeleteApiKeyResponse]

      def deleteDataSource(
        request: DeleteDataSourceRequest
      ): F[DeleteDataSourceResponse]

      def deleteFunction(
        request: DeleteFunctionRequest
      ): F[DeleteFunctionResponse]

      def deleteGraphqlApi(
        request: DeleteGraphqlApiRequest
      ): F[DeleteGraphqlApiResponse]

      def deleteResolver(
        request: DeleteResolverRequest
      ): F[DeleteResolverResponse]

      def deleteType(
        request: DeleteTypeRequest
      ): F[DeleteTypeResponse]

      def flushApiCache(
        request: FlushApiCacheRequest
      ): F[FlushApiCacheResponse]

      def getApiCache(
        request: GetApiCacheRequest
      ): F[GetApiCacheResponse]

      def getDataSource(
        request: GetDataSourceRequest
      ): F[GetDataSourceResponse]

      def getFunction(
        request: GetFunctionRequest
      ): F[GetFunctionResponse]

      def getGraphqlApi(
        request: GetGraphqlApiRequest
      ): F[GetGraphqlApiResponse]

      def getIntrospectionSchema(
        request: GetIntrospectionSchemaRequest
      ): F[GetIntrospectionSchemaResponse]

      def getResolver(
        request: GetResolverRequest
      ): F[GetResolverResponse]

      def getSchemaCreationStatus(
        request: GetSchemaCreationStatusRequest
      ): F[GetSchemaCreationStatusResponse]

      def getType(
        request: GetTypeRequest
      ): F[GetTypeResponse]

      def listApiKeys(
        request: ListApiKeysRequest
      ): F[ListApiKeysResponse]

      def listDataSources(
        request: ListDataSourcesRequest
      ): F[ListDataSourcesResponse]

      def listFunctions(
        request: ListFunctionsRequest
      ): F[ListFunctionsResponse]

      def listGraphqlApis(
        request: ListGraphqlApisRequest
      ): F[ListGraphqlApisResponse]

      def listResolvers(
        request: ListResolversRequest
      ): F[ListResolversResponse]

      def listResolversByFunction(
        request: ListResolversByFunctionRequest
      ): F[ListResolversByFunctionResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTypes(
        request: ListTypesRequest
      ): F[ListTypesResponse]

      def startSchemaCreation(
        request: StartSchemaCreationRequest
      ): F[StartSchemaCreationResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApiCache(
        request: UpdateApiCacheRequest
      ): F[UpdateApiCacheResponse]

      def updateApiKey(
        request: UpdateApiKeyRequest
      ): F[UpdateApiKeyResponse]

      def updateDataSource(
        request: UpdateDataSourceRequest
      ): F[UpdateDataSourceResponse]

      def updateFunction(
        request: UpdateFunctionRequest
      ): F[UpdateFunctionResponse]

      def updateGraphqlApi(
        request: UpdateGraphqlApiRequest
      ): F[UpdateGraphqlApiResponse]

      def updateResolver(
        request: UpdateResolverRequest
      ): F[UpdateResolverResponse]

      def updateType(
        request: UpdateTypeRequest
      ): F[UpdateTypeResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AppSyncOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateApiCacheOp(
      request: CreateApiCacheRequest
    ) extends AppSyncOp[CreateApiCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApiCacheResponse] =
        visitor.createApiCache(request)
    }

    final case class CreateApiKeyOp(
      request: CreateApiKeyRequest
    ) extends AppSyncOp[CreateApiKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApiKeyResponse] =
        visitor.createApiKey(request)
    }

    final case class CreateDataSourceOp(
      request: CreateDataSourceRequest
    ) extends AppSyncOp[CreateDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSourceResponse] =
        visitor.createDataSource(request)
    }

    final case class CreateFunctionOp(
      request: CreateFunctionRequest
    ) extends AppSyncOp[CreateFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFunctionResponse] =
        visitor.createFunction(request)
    }

    final case class CreateGraphqlApiOp(
      request: CreateGraphqlApiRequest
    ) extends AppSyncOp[CreateGraphqlApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGraphqlApiResponse] =
        visitor.createGraphqlApi(request)
    }

    final case class CreateResolverOp(
      request: CreateResolverRequest
    ) extends AppSyncOp[CreateResolverResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResolverResponse] =
        visitor.createResolver(request)
    }

    final case class CreateTypeOp(
      request: CreateTypeRequest
    ) extends AppSyncOp[CreateTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTypeResponse] =
        visitor.createType(request)
    }

    final case class DeleteApiCacheOp(
      request: DeleteApiCacheRequest
    ) extends AppSyncOp[DeleteApiCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApiCacheResponse] =
        visitor.deleteApiCache(request)
    }

    final case class DeleteApiKeyOp(
      request: DeleteApiKeyRequest
    ) extends AppSyncOp[DeleteApiKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApiKeyResponse] =
        visitor.deleteApiKey(request)
    }

    final case class DeleteDataSourceOp(
      request: DeleteDataSourceRequest
    ) extends AppSyncOp[DeleteDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataSourceResponse] =
        visitor.deleteDataSource(request)
    }

    final case class DeleteFunctionOp(
      request: DeleteFunctionRequest
    ) extends AppSyncOp[DeleteFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFunctionResponse] =
        visitor.deleteFunction(request)
    }

    final case class DeleteGraphqlApiOp(
      request: DeleteGraphqlApiRequest
    ) extends AppSyncOp[DeleteGraphqlApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGraphqlApiResponse] =
        visitor.deleteGraphqlApi(request)
    }

    final case class DeleteResolverOp(
      request: DeleteResolverRequest
    ) extends AppSyncOp[DeleteResolverResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResolverResponse] =
        visitor.deleteResolver(request)
    }

    final case class DeleteTypeOp(
      request: DeleteTypeRequest
    ) extends AppSyncOp[DeleteTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTypeResponse] =
        visitor.deleteType(request)
    }

    final case class FlushApiCacheOp(
      request: FlushApiCacheRequest
    ) extends AppSyncOp[FlushApiCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FlushApiCacheResponse] =
        visitor.flushApiCache(request)
    }

    final case class GetApiCacheOp(
      request: GetApiCacheRequest
    ) extends AppSyncOp[GetApiCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApiCacheResponse] =
        visitor.getApiCache(request)
    }

    final case class GetDataSourceOp(
      request: GetDataSourceRequest
    ) extends AppSyncOp[GetDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataSourceResponse] =
        visitor.getDataSource(request)
    }

    final case class GetFunctionOp(
      request: GetFunctionRequest
    ) extends AppSyncOp[GetFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionResponse] =
        visitor.getFunction(request)
    }

    final case class GetGraphqlApiOp(
      request: GetGraphqlApiRequest
    ) extends AppSyncOp[GetGraphqlApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGraphqlApiResponse] =
        visitor.getGraphqlApi(request)
    }

    final case class GetIntrospectionSchemaOp(
      request: GetIntrospectionSchemaRequest
    ) extends AppSyncOp[GetIntrospectionSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIntrospectionSchemaResponse] =
        visitor.getIntrospectionSchema(request)
    }

    final case class GetResolverOp(
      request: GetResolverRequest
    ) extends AppSyncOp[GetResolverResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResolverResponse] =
        visitor.getResolver(request)
    }

    final case class GetSchemaCreationStatusOp(
      request: GetSchemaCreationStatusRequest
    ) extends AppSyncOp[GetSchemaCreationStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSchemaCreationStatusResponse] =
        visitor.getSchemaCreationStatus(request)
    }

    final case class GetTypeOp(
      request: GetTypeRequest
    ) extends AppSyncOp[GetTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTypeResponse] =
        visitor.getType(request)
    }

    final case class ListApiKeysOp(
      request: ListApiKeysRequest
    ) extends AppSyncOp[ListApiKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApiKeysResponse] =
        visitor.listApiKeys(request)
    }

    final case class ListDataSourcesOp(
      request: ListDataSourcesRequest
    ) extends AppSyncOp[ListDataSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataSourcesResponse] =
        visitor.listDataSources(request)
    }

    final case class ListFunctionsOp(
      request: ListFunctionsRequest
    ) extends AppSyncOp[ListFunctionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFunctionsResponse] =
        visitor.listFunctions(request)
    }

    final case class ListGraphqlApisOp(
      request: ListGraphqlApisRequest
    ) extends AppSyncOp[ListGraphqlApisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGraphqlApisResponse] =
        visitor.listGraphqlApis(request)
    }

    final case class ListResolversOp(
      request: ListResolversRequest
    ) extends AppSyncOp[ListResolversResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolversResponse] =
        visitor.listResolvers(request)
    }

    final case class ListResolversByFunctionOp(
      request: ListResolversByFunctionRequest
    ) extends AppSyncOp[ListResolversByFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResolversByFunctionResponse] =
        visitor.listResolversByFunction(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AppSyncOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTypesOp(
      request: ListTypesRequest
    ) extends AppSyncOp[ListTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTypesResponse] =
        visitor.listTypes(request)
    }

    final case class StartSchemaCreationOp(
      request: StartSchemaCreationRequest
    ) extends AppSyncOp[StartSchemaCreationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSchemaCreationResponse] =
        visitor.startSchemaCreation(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AppSyncOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AppSyncOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApiCacheOp(
      request: UpdateApiCacheRequest
    ) extends AppSyncOp[UpdateApiCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApiCacheResponse] =
        visitor.updateApiCache(request)
    }

    final case class UpdateApiKeyOp(
      request: UpdateApiKeyRequest
    ) extends AppSyncOp[UpdateApiKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApiKeyResponse] =
        visitor.updateApiKey(request)
    }

    final case class UpdateDataSourceOp(
      request: UpdateDataSourceRequest
    ) extends AppSyncOp[UpdateDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSourceResponse] =
        visitor.updateDataSource(request)
    }

    final case class UpdateFunctionOp(
      request: UpdateFunctionRequest
    ) extends AppSyncOp[UpdateFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFunctionResponse] =
        visitor.updateFunction(request)
    }

    final case class UpdateGraphqlApiOp(
      request: UpdateGraphqlApiRequest
    ) extends AppSyncOp[UpdateGraphqlApiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGraphqlApiResponse] =
        visitor.updateGraphqlApi(request)
    }

    final case class UpdateResolverOp(
      request: UpdateResolverRequest
    ) extends AppSyncOp[UpdateResolverResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResolverResponse] =
        visitor.updateResolver(request)
    }

    final case class UpdateTypeOp(
      request: UpdateTypeRequest
    ) extends AppSyncOp[UpdateTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTypeResponse] =
        visitor.updateType(request)
    }
  }

  import AppSyncOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AppSyncOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApiCache(
    request: CreateApiCacheRequest
  ): AppSyncIO[CreateApiCacheResponse] =
    FF.liftF(CreateApiCacheOp(request))

  def createApiKey(
    request: CreateApiKeyRequest
  ): AppSyncIO[CreateApiKeyResponse] =
    FF.liftF(CreateApiKeyOp(request))

  def createDataSource(
    request: CreateDataSourceRequest
  ): AppSyncIO[CreateDataSourceResponse] =
    FF.liftF(CreateDataSourceOp(request))

  def createFunction(
    request: CreateFunctionRequest
  ): AppSyncIO[CreateFunctionResponse] =
    FF.liftF(CreateFunctionOp(request))

  def createGraphqlApi(
    request: CreateGraphqlApiRequest
  ): AppSyncIO[CreateGraphqlApiResponse] =
    FF.liftF(CreateGraphqlApiOp(request))

  def createResolver(
    request: CreateResolverRequest
  ): AppSyncIO[CreateResolverResponse] =
    FF.liftF(CreateResolverOp(request))

  def createType(
    request: CreateTypeRequest
  ): AppSyncIO[CreateTypeResponse] =
    FF.liftF(CreateTypeOp(request))

  def deleteApiCache(
    request: DeleteApiCacheRequest
  ): AppSyncIO[DeleteApiCacheResponse] =
    FF.liftF(DeleteApiCacheOp(request))

  def deleteApiKey(
    request: DeleteApiKeyRequest
  ): AppSyncIO[DeleteApiKeyResponse] =
    FF.liftF(DeleteApiKeyOp(request))

  def deleteDataSource(
    request: DeleteDataSourceRequest
  ): AppSyncIO[DeleteDataSourceResponse] =
    FF.liftF(DeleteDataSourceOp(request))

  def deleteFunction(
    request: DeleteFunctionRequest
  ): AppSyncIO[DeleteFunctionResponse] =
    FF.liftF(DeleteFunctionOp(request))

  def deleteGraphqlApi(
    request: DeleteGraphqlApiRequest
  ): AppSyncIO[DeleteGraphqlApiResponse] =
    FF.liftF(DeleteGraphqlApiOp(request))

  def deleteResolver(
    request: DeleteResolverRequest
  ): AppSyncIO[DeleteResolverResponse] =
    FF.liftF(DeleteResolverOp(request))

  def deleteType(
    request: DeleteTypeRequest
  ): AppSyncIO[DeleteTypeResponse] =
    FF.liftF(DeleteTypeOp(request))

  def flushApiCache(
    request: FlushApiCacheRequest
  ): AppSyncIO[FlushApiCacheResponse] =
    FF.liftF(FlushApiCacheOp(request))

  def getApiCache(
    request: GetApiCacheRequest
  ): AppSyncIO[GetApiCacheResponse] =
    FF.liftF(GetApiCacheOp(request))

  def getDataSource(
    request: GetDataSourceRequest
  ): AppSyncIO[GetDataSourceResponse] =
    FF.liftF(GetDataSourceOp(request))

  def getFunction(
    request: GetFunctionRequest
  ): AppSyncIO[GetFunctionResponse] =
    FF.liftF(GetFunctionOp(request))

  def getGraphqlApi(
    request: GetGraphqlApiRequest
  ): AppSyncIO[GetGraphqlApiResponse] =
    FF.liftF(GetGraphqlApiOp(request))

  def getIntrospectionSchema(
    request: GetIntrospectionSchemaRequest
  ): AppSyncIO[GetIntrospectionSchemaResponse] =
    FF.liftF(GetIntrospectionSchemaOp(request))

  def getResolver(
    request: GetResolverRequest
  ): AppSyncIO[GetResolverResponse] =
    FF.liftF(GetResolverOp(request))

  def getSchemaCreationStatus(
    request: GetSchemaCreationStatusRequest
  ): AppSyncIO[GetSchemaCreationStatusResponse] =
    FF.liftF(GetSchemaCreationStatusOp(request))

  def getType(
    request: GetTypeRequest
  ): AppSyncIO[GetTypeResponse] =
    FF.liftF(GetTypeOp(request))

  def listApiKeys(
    request: ListApiKeysRequest
  ): AppSyncIO[ListApiKeysResponse] =
    FF.liftF(ListApiKeysOp(request))

  def listDataSources(
    request: ListDataSourcesRequest
  ): AppSyncIO[ListDataSourcesResponse] =
    FF.liftF(ListDataSourcesOp(request))

  def listFunctions(
    request: ListFunctionsRequest
  ): AppSyncIO[ListFunctionsResponse] =
    FF.liftF(ListFunctionsOp(request))

  def listGraphqlApis(
    request: ListGraphqlApisRequest
  ): AppSyncIO[ListGraphqlApisResponse] =
    FF.liftF(ListGraphqlApisOp(request))

  def listResolvers(
    request: ListResolversRequest
  ): AppSyncIO[ListResolversResponse] =
    FF.liftF(ListResolversOp(request))

  def listResolversByFunction(
    request: ListResolversByFunctionRequest
  ): AppSyncIO[ListResolversByFunctionResponse] =
    FF.liftF(ListResolversByFunctionOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AppSyncIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTypes(
    request: ListTypesRequest
  ): AppSyncIO[ListTypesResponse] =
    FF.liftF(ListTypesOp(request))

  def startSchemaCreation(
    request: StartSchemaCreationRequest
  ): AppSyncIO[StartSchemaCreationResponse] =
    FF.liftF(StartSchemaCreationOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AppSyncIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AppSyncIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApiCache(
    request: UpdateApiCacheRequest
  ): AppSyncIO[UpdateApiCacheResponse] =
    FF.liftF(UpdateApiCacheOp(request))

  def updateApiKey(
    request: UpdateApiKeyRequest
  ): AppSyncIO[UpdateApiKeyResponse] =
    FF.liftF(UpdateApiKeyOp(request))

  def updateDataSource(
    request: UpdateDataSourceRequest
  ): AppSyncIO[UpdateDataSourceResponse] =
    FF.liftF(UpdateDataSourceOp(request))

  def updateFunction(
    request: UpdateFunctionRequest
  ): AppSyncIO[UpdateFunctionResponse] =
    FF.liftF(UpdateFunctionOp(request))

  def updateGraphqlApi(
    request: UpdateGraphqlApiRequest
  ): AppSyncIO[UpdateGraphqlApiResponse] =
    FF.liftF(UpdateGraphqlApiOp(request))

  def updateResolver(
    request: UpdateResolverRequest
  ): AppSyncIO[UpdateResolverResponse] =
    FF.liftF(UpdateResolverOp(request))

  def updateType(
    request: UpdateTypeRequest
  ): AppSyncIO[UpdateTypeResponse] =
    FF.liftF(UpdateTypeOp(request))
}
