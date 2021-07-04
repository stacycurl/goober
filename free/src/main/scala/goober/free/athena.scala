package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.athena.AthenaClient
import software.amazon.awssdk.services.athena.model._

object athena { module =>

  // Free monad over AthenaOp
  type AthenaIO[A] = FF[AthenaOp, A]

  sealed trait AthenaOp[A] {
    def visit[F[_]](visitor: AthenaOp.Visitor[F]): F[A]
  }

  object AthenaOp {
    // Given a AthenaClient we can embed a AthenaIO program in any algebra that understands embedding.
    implicit val AthenaOpEmbeddable: Embeddable[AthenaOp, AthenaClient] = new Embeddable[AthenaOp, AthenaClient] {
      def embed[A](client: AthenaClient, io: AthenaIO[A]): Embedded[A] = Embedded.Athena(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AthenaOp.Visitor[Kleisli[M, AthenaClient, *]] {
        def batchGetNamedQuery(
          request: BatchGetNamedQueryRequest
        ): Kleisli[M, AthenaClient, BatchGetNamedQueryResponse] =
          primitive(_.batchGetNamedQuery(request))

        def batchGetQueryExecution(
          request: BatchGetQueryExecutionRequest
        ): Kleisli[M, AthenaClient, BatchGetQueryExecutionResponse] =
          primitive(_.batchGetQueryExecution(request))

        def createDataCatalog(
          request: CreateDataCatalogRequest
        ): Kleisli[M, AthenaClient, CreateDataCatalogResponse] =
          primitive(_.createDataCatalog(request))

        def createNamedQuery(
          request: CreateNamedQueryRequest
        ): Kleisli[M, AthenaClient, CreateNamedQueryResponse] =
          primitive(_.createNamedQuery(request))

        def createPreparedStatement(
          request: CreatePreparedStatementRequest
        ): Kleisli[M, AthenaClient, CreatePreparedStatementResponse] =
          primitive(_.createPreparedStatement(request))

        def createWorkGroup(
          request: CreateWorkGroupRequest
        ): Kleisli[M, AthenaClient, CreateWorkGroupResponse] =
          primitive(_.createWorkGroup(request))

        def deleteDataCatalog(
          request: DeleteDataCatalogRequest
        ): Kleisli[M, AthenaClient, DeleteDataCatalogResponse] =
          primitive(_.deleteDataCatalog(request))

        def deleteNamedQuery(
          request: DeleteNamedQueryRequest
        ): Kleisli[M, AthenaClient, DeleteNamedQueryResponse] =
          primitive(_.deleteNamedQuery(request))

        def deletePreparedStatement(
          request: DeletePreparedStatementRequest
        ): Kleisli[M, AthenaClient, DeletePreparedStatementResponse] =
          primitive(_.deletePreparedStatement(request))

        def deleteWorkGroup(
          request: DeleteWorkGroupRequest
        ): Kleisli[M, AthenaClient, DeleteWorkGroupResponse] =
          primitive(_.deleteWorkGroup(request))

        def getDataCatalog(
          request: GetDataCatalogRequest
        ): Kleisli[M, AthenaClient, GetDataCatalogResponse] =
          primitive(_.getDataCatalog(request))

        def getDatabase(
          request: GetDatabaseRequest
        ): Kleisli[M, AthenaClient, GetDatabaseResponse] =
          primitive(_.getDatabase(request))

        def getNamedQuery(
          request: GetNamedQueryRequest
        ): Kleisli[M, AthenaClient, GetNamedQueryResponse] =
          primitive(_.getNamedQuery(request))

        def getPreparedStatement(
          request: GetPreparedStatementRequest
        ): Kleisli[M, AthenaClient, GetPreparedStatementResponse] =
          primitive(_.getPreparedStatement(request))

        def getQueryExecution(
          request: GetQueryExecutionRequest
        ): Kleisli[M, AthenaClient, GetQueryExecutionResponse] =
          primitive(_.getQueryExecution(request))

        def getQueryResults(
          request: GetQueryResultsRequest
        ): Kleisli[M, AthenaClient, GetQueryResultsResponse] =
          primitive(_.getQueryResults(request))

        def getTableMetadata(
          request: GetTableMetadataRequest
        ): Kleisli[M, AthenaClient, GetTableMetadataResponse] =
          primitive(_.getTableMetadata(request))

        def getWorkGroup(
          request: GetWorkGroupRequest
        ): Kleisli[M, AthenaClient, GetWorkGroupResponse] =
          primitive(_.getWorkGroup(request))

        def listDataCatalogs(
          request: ListDataCatalogsRequest
        ): Kleisli[M, AthenaClient, ListDataCatalogsResponse] =
          primitive(_.listDataCatalogs(request))

        def listDatabases(
          request: ListDatabasesRequest
        ): Kleisli[M, AthenaClient, ListDatabasesResponse] =
          primitive(_.listDatabases(request))

        def listEngineVersions(
          request: ListEngineVersionsRequest
        ): Kleisli[M, AthenaClient, ListEngineVersionsResponse] =
          primitive(_.listEngineVersions(request))

        def listNamedQueries(
          request: ListNamedQueriesRequest
        ): Kleisli[M, AthenaClient, ListNamedQueriesResponse] =
          primitive(_.listNamedQueries(request))

        def listPreparedStatements(
          request: ListPreparedStatementsRequest
        ): Kleisli[M, AthenaClient, ListPreparedStatementsResponse] =
          primitive(_.listPreparedStatements(request))

        def listQueryExecutions(
          request: ListQueryExecutionsRequest
        ): Kleisli[M, AthenaClient, ListQueryExecutionsResponse] =
          primitive(_.listQueryExecutions(request))

        def listTableMetadata(
          request: ListTableMetadataRequest
        ): Kleisli[M, AthenaClient, ListTableMetadataResponse] =
          primitive(_.listTableMetadata(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AthenaClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWorkGroups(
          request: ListWorkGroupsRequest
        ): Kleisli[M, AthenaClient, ListWorkGroupsResponse] =
          primitive(_.listWorkGroups(request))

        def startQueryExecution(
          request: StartQueryExecutionRequest
        ): Kleisli[M, AthenaClient, StartQueryExecutionResponse] =
          primitive(_.startQueryExecution(request))

        def stopQueryExecution(
          request: StopQueryExecutionRequest
        ): Kleisli[M, AthenaClient, StopQueryExecutionResponse] =
          primitive(_.stopQueryExecution(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AthenaClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AthenaClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDataCatalog(
          request: UpdateDataCatalogRequest
        ): Kleisli[M, AthenaClient, UpdateDataCatalogResponse] =
          primitive(_.updateDataCatalog(request))

        def updatePreparedStatement(
          request: UpdatePreparedStatementRequest
        ): Kleisli[M, AthenaClient, UpdatePreparedStatementResponse] =
          primitive(_.updatePreparedStatement(request))

        def updateWorkGroup(
          request: UpdateWorkGroupRequest
        ): Kleisli[M, AthenaClient, UpdateWorkGroupResponse] =
          primitive(_.updateWorkGroup(request))

        def primitive[A](
          f: AthenaClient => A
        ): Kleisli[M, AthenaClient, A]
      }
    }

    trait Visitor[F[_]] extends (AthenaOp ~> F) {
      final def apply[A](op: AthenaOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchGetNamedQuery(
        request: BatchGetNamedQueryRequest
      ): F[BatchGetNamedQueryResponse]

      def batchGetQueryExecution(
        request: BatchGetQueryExecutionRequest
      ): F[BatchGetQueryExecutionResponse]

      def createDataCatalog(
        request: CreateDataCatalogRequest
      ): F[CreateDataCatalogResponse]

      def createNamedQuery(
        request: CreateNamedQueryRequest
      ): F[CreateNamedQueryResponse]

      def createPreparedStatement(
        request: CreatePreparedStatementRequest
      ): F[CreatePreparedStatementResponse]

      def createWorkGroup(
        request: CreateWorkGroupRequest
      ): F[CreateWorkGroupResponse]

      def deleteDataCatalog(
        request: DeleteDataCatalogRequest
      ): F[DeleteDataCatalogResponse]

      def deleteNamedQuery(
        request: DeleteNamedQueryRequest
      ): F[DeleteNamedQueryResponse]

      def deletePreparedStatement(
        request: DeletePreparedStatementRequest
      ): F[DeletePreparedStatementResponse]

      def deleteWorkGroup(
        request: DeleteWorkGroupRequest
      ): F[DeleteWorkGroupResponse]

      def getDataCatalog(
        request: GetDataCatalogRequest
      ): F[GetDataCatalogResponse]

      def getDatabase(
        request: GetDatabaseRequest
      ): F[GetDatabaseResponse]

      def getNamedQuery(
        request: GetNamedQueryRequest
      ): F[GetNamedQueryResponse]

      def getPreparedStatement(
        request: GetPreparedStatementRequest
      ): F[GetPreparedStatementResponse]

      def getQueryExecution(
        request: GetQueryExecutionRequest
      ): F[GetQueryExecutionResponse]

      def getQueryResults(
        request: GetQueryResultsRequest
      ): F[GetQueryResultsResponse]

      def getTableMetadata(
        request: GetTableMetadataRequest
      ): F[GetTableMetadataResponse]

      def getWorkGroup(
        request: GetWorkGroupRequest
      ): F[GetWorkGroupResponse]

      def listDataCatalogs(
        request: ListDataCatalogsRequest
      ): F[ListDataCatalogsResponse]

      def listDatabases(
        request: ListDatabasesRequest
      ): F[ListDatabasesResponse]

      def listEngineVersions(
        request: ListEngineVersionsRequest
      ): F[ListEngineVersionsResponse]

      def listNamedQueries(
        request: ListNamedQueriesRequest
      ): F[ListNamedQueriesResponse]

      def listPreparedStatements(
        request: ListPreparedStatementsRequest
      ): F[ListPreparedStatementsResponse]

      def listQueryExecutions(
        request: ListQueryExecutionsRequest
      ): F[ListQueryExecutionsResponse]

      def listTableMetadata(
        request: ListTableMetadataRequest
      ): F[ListTableMetadataResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWorkGroups(
        request: ListWorkGroupsRequest
      ): F[ListWorkGroupsResponse]

      def startQueryExecution(
        request: StartQueryExecutionRequest
      ): F[StartQueryExecutionResponse]

      def stopQueryExecution(
        request: StopQueryExecutionRequest
      ): F[StopQueryExecutionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDataCatalog(
        request: UpdateDataCatalogRequest
      ): F[UpdateDataCatalogResponse]

      def updatePreparedStatement(
        request: UpdatePreparedStatementRequest
      ): F[UpdatePreparedStatementResponse]

      def updateWorkGroup(
        request: UpdateWorkGroupRequest
      ): F[UpdateWorkGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AthenaOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchGetNamedQuery(
      request: BatchGetNamedQueryRequest
    ) extends AthenaOp[BatchGetNamedQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetNamedQueryResponse] =
        visitor.batchGetNamedQuery(request)
    }

    final case class BatchGetQueryExecution(
      request: BatchGetQueryExecutionRequest
    ) extends AthenaOp[BatchGetQueryExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetQueryExecutionResponse] =
        visitor.batchGetQueryExecution(request)
    }

    final case class CreateDataCatalog(
      request: CreateDataCatalogRequest
    ) extends AthenaOp[CreateDataCatalogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataCatalogResponse] =
        visitor.createDataCatalog(request)
    }

    final case class CreateNamedQuery(
      request: CreateNamedQueryRequest
    ) extends AthenaOp[CreateNamedQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNamedQueryResponse] =
        visitor.createNamedQuery(request)
    }

    final case class CreatePreparedStatement(
      request: CreatePreparedStatementRequest
    ) extends AthenaOp[CreatePreparedStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePreparedStatementResponse] =
        visitor.createPreparedStatement(request)
    }

    final case class CreateWorkGroup(
      request: CreateWorkGroupRequest
    ) extends AthenaOp[CreateWorkGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkGroupResponse] =
        visitor.createWorkGroup(request)
    }

    final case class DeleteDataCatalog(
      request: DeleteDataCatalogRequest
    ) extends AthenaOp[DeleteDataCatalogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataCatalogResponse] =
        visitor.deleteDataCatalog(request)
    }

    final case class DeleteNamedQuery(
      request: DeleteNamedQueryRequest
    ) extends AthenaOp[DeleteNamedQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNamedQueryResponse] =
        visitor.deleteNamedQuery(request)
    }

    final case class DeletePreparedStatement(
      request: DeletePreparedStatementRequest
    ) extends AthenaOp[DeletePreparedStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePreparedStatementResponse] =
        visitor.deletePreparedStatement(request)
    }

    final case class DeleteWorkGroup(
      request: DeleteWorkGroupRequest
    ) extends AthenaOp[DeleteWorkGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkGroupResponse] =
        visitor.deleteWorkGroup(request)
    }

    final case class GetDataCatalog(
      request: GetDataCatalogRequest
    ) extends AthenaOp[GetDataCatalogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataCatalogResponse] =
        visitor.getDataCatalog(request)
    }

    final case class GetDatabase(
      request: GetDatabaseRequest
    ) extends AthenaOp[GetDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDatabaseResponse] =
        visitor.getDatabase(request)
    }

    final case class GetNamedQuery(
      request: GetNamedQueryRequest
    ) extends AthenaOp[GetNamedQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNamedQueryResponse] =
        visitor.getNamedQuery(request)
    }

    final case class GetPreparedStatement(
      request: GetPreparedStatementRequest
    ) extends AthenaOp[GetPreparedStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPreparedStatementResponse] =
        visitor.getPreparedStatement(request)
    }

    final case class GetQueryExecution(
      request: GetQueryExecutionRequest
    ) extends AthenaOp[GetQueryExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQueryExecutionResponse] =
        visitor.getQueryExecution(request)
    }

    final case class GetQueryResults(
      request: GetQueryResultsRequest
    ) extends AthenaOp[GetQueryResultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQueryResultsResponse] =
        visitor.getQueryResults(request)
    }

    final case class GetTableMetadata(
      request: GetTableMetadataRequest
    ) extends AthenaOp[GetTableMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTableMetadataResponse] =
        visitor.getTableMetadata(request)
    }

    final case class GetWorkGroup(
      request: GetWorkGroupRequest
    ) extends AthenaOp[GetWorkGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkGroupResponse] =
        visitor.getWorkGroup(request)
    }

    final case class ListDataCatalogs(
      request: ListDataCatalogsRequest
    ) extends AthenaOp[ListDataCatalogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataCatalogsResponse] =
        visitor.listDataCatalogs(request)
    }

    final case class ListDatabases(
      request: ListDatabasesRequest
    ) extends AthenaOp[ListDatabasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatabasesResponse] =
        visitor.listDatabases(request)
    }

    final case class ListEngineVersions(
      request: ListEngineVersionsRequest
    ) extends AthenaOp[ListEngineVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEngineVersionsResponse] =
        visitor.listEngineVersions(request)
    }

    final case class ListNamedQueries(
      request: ListNamedQueriesRequest
    ) extends AthenaOp[ListNamedQueriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNamedQueriesResponse] =
        visitor.listNamedQueries(request)
    }

    final case class ListPreparedStatements(
      request: ListPreparedStatementsRequest
    ) extends AthenaOp[ListPreparedStatementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPreparedStatementsResponse] =
        visitor.listPreparedStatements(request)
    }

    final case class ListQueryExecutions(
      request: ListQueryExecutionsRequest
    ) extends AthenaOp[ListQueryExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQueryExecutionsResponse] =
        visitor.listQueryExecutions(request)
    }

    final case class ListTableMetadata(
      request: ListTableMetadataRequest
    ) extends AthenaOp[ListTableMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTableMetadataResponse] =
        visitor.listTableMetadata(request)
    }

    final case class ListTagsForResource(
      request: ListTagsForResourceRequest
    ) extends AthenaOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWorkGroups(
      request: ListWorkGroupsRequest
    ) extends AthenaOp[ListWorkGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkGroupsResponse] =
        visitor.listWorkGroups(request)
    }

    final case class StartQueryExecution(
      request: StartQueryExecutionRequest
    ) extends AthenaOp[StartQueryExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartQueryExecutionResponse] =
        visitor.startQueryExecution(request)
    }

    final case class StopQueryExecution(
      request: StopQueryExecutionRequest
    ) extends AthenaOp[StopQueryExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopQueryExecutionResponse] =
        visitor.stopQueryExecution(request)
    }

    final case class TagResource(
      request: TagResourceRequest
    ) extends AthenaOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResource(
      request: UntagResourceRequest
    ) extends AthenaOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDataCatalog(
      request: UpdateDataCatalogRequest
    ) extends AthenaOp[UpdateDataCatalogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataCatalogResponse] =
        visitor.updateDataCatalog(request)
    }

    final case class UpdatePreparedStatement(
      request: UpdatePreparedStatementRequest
    ) extends AthenaOp[UpdatePreparedStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePreparedStatementResponse] =
        visitor.updatePreparedStatement(request)
    }

    final case class UpdateWorkGroup(
      request: UpdateWorkGroupRequest
    ) extends AthenaOp[UpdateWorkGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkGroupResponse] =
        visitor.updateWorkGroup(request)
    }
  }

  import AthenaOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AthenaOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchGetNamedQuery(
    request: BatchGetNamedQueryRequest
  ): AthenaIO[BatchGetNamedQueryResponse] =
    FF.liftF(BatchGetNamedQuery(request))

  def batchGetQueryExecution(
    request: BatchGetQueryExecutionRequest
  ): AthenaIO[BatchGetQueryExecutionResponse] =
    FF.liftF(BatchGetQueryExecution(request))

  def createDataCatalog(
    request: CreateDataCatalogRequest
  ): AthenaIO[CreateDataCatalogResponse] =
    FF.liftF(CreateDataCatalog(request))

  def createNamedQuery(
    request: CreateNamedQueryRequest
  ): AthenaIO[CreateNamedQueryResponse] =
    FF.liftF(CreateNamedQuery(request))

  def createPreparedStatement(
    request: CreatePreparedStatementRequest
  ): AthenaIO[CreatePreparedStatementResponse] =
    FF.liftF(CreatePreparedStatement(request))

  def createWorkGroup(
    request: CreateWorkGroupRequest
  ): AthenaIO[CreateWorkGroupResponse] =
    FF.liftF(CreateWorkGroup(request))

  def deleteDataCatalog(
    request: DeleteDataCatalogRequest
  ): AthenaIO[DeleteDataCatalogResponse] =
    FF.liftF(DeleteDataCatalog(request))

  def deleteNamedQuery(
    request: DeleteNamedQueryRequest
  ): AthenaIO[DeleteNamedQueryResponse] =
    FF.liftF(DeleteNamedQuery(request))

  def deletePreparedStatement(
    request: DeletePreparedStatementRequest
  ): AthenaIO[DeletePreparedStatementResponse] =
    FF.liftF(DeletePreparedStatement(request))

  def deleteWorkGroup(
    request: DeleteWorkGroupRequest
  ): AthenaIO[DeleteWorkGroupResponse] =
    FF.liftF(DeleteWorkGroup(request))

  def getDataCatalog(
    request: GetDataCatalogRequest
  ): AthenaIO[GetDataCatalogResponse] =
    FF.liftF(GetDataCatalog(request))

  def getDatabase(
    request: GetDatabaseRequest
  ): AthenaIO[GetDatabaseResponse] =
    FF.liftF(GetDatabase(request))

  def getNamedQuery(
    request: GetNamedQueryRequest
  ): AthenaIO[GetNamedQueryResponse] =
    FF.liftF(GetNamedQuery(request))

  def getPreparedStatement(
    request: GetPreparedStatementRequest
  ): AthenaIO[GetPreparedStatementResponse] =
    FF.liftF(GetPreparedStatement(request))

  def getQueryExecution(
    request: GetQueryExecutionRequest
  ): AthenaIO[GetQueryExecutionResponse] =
    FF.liftF(GetQueryExecution(request))

  def getQueryResults(
    request: GetQueryResultsRequest
  ): AthenaIO[GetQueryResultsResponse] =
    FF.liftF(GetQueryResults(request))

  def getTableMetadata(
    request: GetTableMetadataRequest
  ): AthenaIO[GetTableMetadataResponse] =
    FF.liftF(GetTableMetadata(request))

  def getWorkGroup(
    request: GetWorkGroupRequest
  ): AthenaIO[GetWorkGroupResponse] =
    FF.liftF(GetWorkGroup(request))

  def listDataCatalogs(
    request: ListDataCatalogsRequest
  ): AthenaIO[ListDataCatalogsResponse] =
    FF.liftF(ListDataCatalogs(request))

  def listDatabases(
    request: ListDatabasesRequest
  ): AthenaIO[ListDatabasesResponse] =
    FF.liftF(ListDatabases(request))

  def listEngineVersions(
    request: ListEngineVersionsRequest
  ): AthenaIO[ListEngineVersionsResponse] =
    FF.liftF(ListEngineVersions(request))

  def listNamedQueries(
    request: ListNamedQueriesRequest
  ): AthenaIO[ListNamedQueriesResponse] =
    FF.liftF(ListNamedQueries(request))

  def listPreparedStatements(
    request: ListPreparedStatementsRequest
  ): AthenaIO[ListPreparedStatementsResponse] =
    FF.liftF(ListPreparedStatements(request))

  def listQueryExecutions(
    request: ListQueryExecutionsRequest
  ): AthenaIO[ListQueryExecutionsResponse] =
    FF.liftF(ListQueryExecutions(request))

  def listTableMetadata(
    request: ListTableMetadataRequest
  ): AthenaIO[ListTableMetadataResponse] =
    FF.liftF(ListTableMetadata(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AthenaIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResource(request))

  def listWorkGroups(
    request: ListWorkGroupsRequest
  ): AthenaIO[ListWorkGroupsResponse] =
    FF.liftF(ListWorkGroups(request))

  def startQueryExecution(
    request: StartQueryExecutionRequest
  ): AthenaIO[StartQueryExecutionResponse] =
    FF.liftF(StartQueryExecution(request))

  def stopQueryExecution(
    request: StopQueryExecutionRequest
  ): AthenaIO[StopQueryExecutionResponse] =
    FF.liftF(StopQueryExecution(request))

  def tagResource(
    request: TagResourceRequest
  ): AthenaIO[TagResourceResponse] =
    FF.liftF(TagResource(request))

  def untagResource(
    request: UntagResourceRequest
  ): AthenaIO[UntagResourceResponse] =
    FF.liftF(UntagResource(request))

  def updateDataCatalog(
    request: UpdateDataCatalogRequest
  ): AthenaIO[UpdateDataCatalogResponse] =
    FF.liftF(UpdateDataCatalog(request))

  def updatePreparedStatement(
    request: UpdatePreparedStatementRequest
  ): AthenaIO[UpdatePreparedStatementResponse] =
    FF.liftF(UpdatePreparedStatement(request))

  def updateWorkGroup(
    request: UpdateWorkGroupRequest
  ): AthenaIO[UpdateWorkGroupResponse] =
    FF.liftF(UpdateWorkGroup(request))
}
