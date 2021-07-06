package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.model._


object dynamodb { module =>

  // Free monad over DynamoDbOp
  type DynamoDbIO[A] = FF[DynamoDbOp, A]

  sealed trait DynamoDbOp[A] {
    def visit[F[_]](visitor: DynamoDbOp.Visitor[F]): F[A]
  }

  object DynamoDbOp {
    // Given a DynamoDbClient we can embed a DynamoDbIO program in any algebra that understands embedding.
    implicit val DynamoDbOpEmbeddable: Embeddable[DynamoDbOp, DynamoDbClient] = new Embeddable[DynamoDbOp, DynamoDbClient] {
      def embed[A](client: DynamoDbClient, io: DynamoDbIO[A]): Embedded[A] = Embedded.DynamoDb(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DynamoDbOp.Visitor[Kleisli[M, DynamoDbClient, *]] {
        def batchExecuteStatement(
          request: BatchExecuteStatementRequest
        ): Kleisli[M, DynamoDbClient, BatchExecuteStatementResponse] =
          primitive(_.batchExecuteStatement(request))

        def batchGetItem(
          request: BatchGetItemRequest
        ): Kleisli[M, DynamoDbClient, BatchGetItemResponse] =
          primitive(_.batchGetItem(request))

        def batchWriteItem(
          request: BatchWriteItemRequest
        ): Kleisli[M, DynamoDbClient, BatchWriteItemResponse] =
          primitive(_.batchWriteItem(request))

        def createBackup(
          request: CreateBackupRequest
        ): Kleisli[M, DynamoDbClient, CreateBackupResponse] =
          primitive(_.createBackup(request))

        def createGlobalTable(
          request: CreateGlobalTableRequest
        ): Kleisli[M, DynamoDbClient, CreateGlobalTableResponse] =
          primitive(_.createGlobalTable(request))

        def createTable(
          request: CreateTableRequest
        ): Kleisli[M, DynamoDbClient, CreateTableResponse] =
          primitive(_.createTable(request))

        def deleteBackup(
          request: DeleteBackupRequest
        ): Kleisli[M, DynamoDbClient, DeleteBackupResponse] =
          primitive(_.deleteBackup(request))

        def deleteItem(
          request: DeleteItemRequest
        ): Kleisli[M, DynamoDbClient, DeleteItemResponse] =
          primitive(_.deleteItem(request))

        def deleteTable(
          request: DeleteTableRequest
        ): Kleisli[M, DynamoDbClient, DeleteTableResponse] =
          primitive(_.deleteTable(request))

        def describeBackup(
          request: DescribeBackupRequest
        ): Kleisli[M, DynamoDbClient, DescribeBackupResponse] =
          primitive(_.describeBackup(request))

        def describeContinuousBackups(
          request: DescribeContinuousBackupsRequest
        ): Kleisli[M, DynamoDbClient, DescribeContinuousBackupsResponse] =
          primitive(_.describeContinuousBackups(request))

        def describeContributorInsights(
          request: DescribeContributorInsightsRequest
        ): Kleisli[M, DynamoDbClient, DescribeContributorInsightsResponse] =
          primitive(_.describeContributorInsights(request))

        def describeEndpoints(
          request: DescribeEndpointsRequest
        ): Kleisli[M, DynamoDbClient, DescribeEndpointsResponse] =
          primitive(_.describeEndpoints(request))

        def describeExport(
          request: DescribeExportRequest
        ): Kleisli[M, DynamoDbClient, DescribeExportResponse] =
          primitive(_.describeExport(request))

        def describeGlobalTable(
          request: DescribeGlobalTableRequest
        ): Kleisli[M, DynamoDbClient, DescribeGlobalTableResponse] =
          primitive(_.describeGlobalTable(request))

        def describeGlobalTableSettings(
          request: DescribeGlobalTableSettingsRequest
        ): Kleisli[M, DynamoDbClient, DescribeGlobalTableSettingsResponse] =
          primitive(_.describeGlobalTableSettings(request))

        def describeKinesisStreamingDestination(
          request: DescribeKinesisStreamingDestinationRequest
        ): Kleisli[M, DynamoDbClient, DescribeKinesisStreamingDestinationResponse] =
          primitive(_.describeKinesisStreamingDestination(request))

        def describeLimits(
          request: DescribeLimitsRequest
        ): Kleisli[M, DynamoDbClient, DescribeLimitsResponse] =
          primitive(_.describeLimits(request))

        def describeTable(
          request: DescribeTableRequest
        ): Kleisli[M, DynamoDbClient, DescribeTableResponse] =
          primitive(_.describeTable(request))

        def describeTableReplicaAutoScaling(
          request: DescribeTableReplicaAutoScalingRequest
        ): Kleisli[M, DynamoDbClient, DescribeTableReplicaAutoScalingResponse] =
          primitive(_.describeTableReplicaAutoScaling(request))

        def describeTimeToLive(
          request: DescribeTimeToLiveRequest
        ): Kleisli[M, DynamoDbClient, DescribeTimeToLiveResponse] =
          primitive(_.describeTimeToLive(request))

        def disableKinesisStreamingDestination(
          request: DisableKinesisStreamingDestinationRequest
        ): Kleisli[M, DynamoDbClient, DisableKinesisStreamingDestinationResponse] =
          primitive(_.disableKinesisStreamingDestination(request))

        def enableKinesisStreamingDestination(
          request: EnableKinesisStreamingDestinationRequest
        ): Kleisli[M, DynamoDbClient, EnableKinesisStreamingDestinationResponse] =
          primitive(_.enableKinesisStreamingDestination(request))

        def executeStatement(
          request: ExecuteStatementRequest
        ): Kleisli[M, DynamoDbClient, ExecuteStatementResponse] =
          primitive(_.executeStatement(request))

        def executeTransaction(
          request: ExecuteTransactionRequest
        ): Kleisli[M, DynamoDbClient, ExecuteTransactionResponse] =
          primitive(_.executeTransaction(request))

        def exportTableToPointInTime(
          request: ExportTableToPointInTimeRequest
        ): Kleisli[M, DynamoDbClient, ExportTableToPointInTimeResponse] =
          primitive(_.exportTableToPointInTime(request))

        def getItem(
          request: GetItemRequest
        ): Kleisli[M, DynamoDbClient, GetItemResponse] =
          primitive(_.getItem(request))

        def listBackups(
          request: ListBackupsRequest
        ): Kleisli[M, DynamoDbClient, ListBackupsResponse] =
          primitive(_.listBackups(request))

        def listContributorInsights(
          request: ListContributorInsightsRequest
        ): Kleisli[M, DynamoDbClient, ListContributorInsightsResponse] =
          primitive(_.listContributorInsights(request))

        def listExports(
          request: ListExportsRequest
        ): Kleisli[M, DynamoDbClient, ListExportsResponse] =
          primitive(_.listExports(request))

        def listGlobalTables(
          request: ListGlobalTablesRequest
        ): Kleisli[M, DynamoDbClient, ListGlobalTablesResponse] =
          primitive(_.listGlobalTables(request))

        def listTables(
          request: ListTablesRequest
        ): Kleisli[M, DynamoDbClient, ListTablesResponse] =
          primitive(_.listTables(request))

        def listTagsOfResource(
          request: ListTagsOfResourceRequest
        ): Kleisli[M, DynamoDbClient, ListTagsOfResourceResponse] =
          primitive(_.listTagsOfResource(request))

        def putItem(
          request: PutItemRequest
        ): Kleisli[M, DynamoDbClient, PutItemResponse] =
          primitive(_.putItem(request))

        def query(
          request: QueryRequest
        ): Kleisli[M, DynamoDbClient, QueryResponse] =
          primitive(_.query(request))

        def restoreTableFromBackup(
          request: RestoreTableFromBackupRequest
        ): Kleisli[M, DynamoDbClient, RestoreTableFromBackupResponse] =
          primitive(_.restoreTableFromBackup(request))

        def restoreTableToPointInTime(
          request: RestoreTableToPointInTimeRequest
        ): Kleisli[M, DynamoDbClient, RestoreTableToPointInTimeResponse] =
          primitive(_.restoreTableToPointInTime(request))

        def scan(
          request: ScanRequest
        ): Kleisli[M, DynamoDbClient, ScanResponse] =
          primitive(_.scan(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DynamoDbClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def transactGetItems(
          request: TransactGetItemsRequest
        ): Kleisli[M, DynamoDbClient, TransactGetItemsResponse] =
          primitive(_.transactGetItems(request))

        def transactWriteItems(
          request: TransactWriteItemsRequest
        ): Kleisli[M, DynamoDbClient, TransactWriteItemsResponse] =
          primitive(_.transactWriteItems(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DynamoDbClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateContinuousBackups(
          request: UpdateContinuousBackupsRequest
        ): Kleisli[M, DynamoDbClient, UpdateContinuousBackupsResponse] =
          primitive(_.updateContinuousBackups(request))

        def updateContributorInsights(
          request: UpdateContributorInsightsRequest
        ): Kleisli[M, DynamoDbClient, UpdateContributorInsightsResponse] =
          primitive(_.updateContributorInsights(request))

        def updateGlobalTable(
          request: UpdateGlobalTableRequest
        ): Kleisli[M, DynamoDbClient, UpdateGlobalTableResponse] =
          primitive(_.updateGlobalTable(request))

        def updateGlobalTableSettings(
          request: UpdateGlobalTableSettingsRequest
        ): Kleisli[M, DynamoDbClient, UpdateGlobalTableSettingsResponse] =
          primitive(_.updateGlobalTableSettings(request))

        def updateItem(
          request: UpdateItemRequest
        ): Kleisli[M, DynamoDbClient, UpdateItemResponse] =
          primitive(_.updateItem(request))

        def updateTable(
          request: UpdateTableRequest
        ): Kleisli[M, DynamoDbClient, UpdateTableResponse] =
          primitive(_.updateTable(request))

        def updateTableReplicaAutoScaling(
          request: UpdateTableReplicaAutoScalingRequest
        ): Kleisli[M, DynamoDbClient, UpdateTableReplicaAutoScalingResponse] =
          primitive(_.updateTableReplicaAutoScaling(request))

        def updateTimeToLive(
          request: UpdateTimeToLiveRequest
        ): Kleisli[M, DynamoDbClient, UpdateTimeToLiveResponse] =
          primitive(_.updateTimeToLive(request))

        def primitive[A](
          f: DynamoDbClient => A
        ): Kleisli[M, DynamoDbClient, A]
      }
    }

    trait Visitor[F[_]] extends (DynamoDbOp ~> F) {
      final def apply[A](op: DynamoDbOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchExecuteStatement(
        request: BatchExecuteStatementRequest
      ): F[BatchExecuteStatementResponse]

      def batchGetItem(
        request: BatchGetItemRequest
      ): F[BatchGetItemResponse]

      def batchWriteItem(
        request: BatchWriteItemRequest
      ): F[BatchWriteItemResponse]

      def createBackup(
        request: CreateBackupRequest
      ): F[CreateBackupResponse]

      def createGlobalTable(
        request: CreateGlobalTableRequest
      ): F[CreateGlobalTableResponse]

      def createTable(
        request: CreateTableRequest
      ): F[CreateTableResponse]

      def deleteBackup(
        request: DeleteBackupRequest
      ): F[DeleteBackupResponse]

      def deleteItem(
        request: DeleteItemRequest
      ): F[DeleteItemResponse]

      def deleteTable(
        request: DeleteTableRequest
      ): F[DeleteTableResponse]

      def describeBackup(
        request: DescribeBackupRequest
      ): F[DescribeBackupResponse]

      def describeContinuousBackups(
        request: DescribeContinuousBackupsRequest
      ): F[DescribeContinuousBackupsResponse]

      def describeContributorInsights(
        request: DescribeContributorInsightsRequest
      ): F[DescribeContributorInsightsResponse]

      def describeEndpoints(
        request: DescribeEndpointsRequest
      ): F[DescribeEndpointsResponse]

      def describeExport(
        request: DescribeExportRequest
      ): F[DescribeExportResponse]

      def describeGlobalTable(
        request: DescribeGlobalTableRequest
      ): F[DescribeGlobalTableResponse]

      def describeGlobalTableSettings(
        request: DescribeGlobalTableSettingsRequest
      ): F[DescribeGlobalTableSettingsResponse]

      def describeKinesisStreamingDestination(
        request: DescribeKinesisStreamingDestinationRequest
      ): F[DescribeKinesisStreamingDestinationResponse]

      def describeLimits(
        request: DescribeLimitsRequest
      ): F[DescribeLimitsResponse]

      def describeTable(
        request: DescribeTableRequest
      ): F[DescribeTableResponse]

      def describeTableReplicaAutoScaling(
        request: DescribeTableReplicaAutoScalingRequest
      ): F[DescribeTableReplicaAutoScalingResponse]

      def describeTimeToLive(
        request: DescribeTimeToLiveRequest
      ): F[DescribeTimeToLiveResponse]

      def disableKinesisStreamingDestination(
        request: DisableKinesisStreamingDestinationRequest
      ): F[DisableKinesisStreamingDestinationResponse]

      def enableKinesisStreamingDestination(
        request: EnableKinesisStreamingDestinationRequest
      ): F[EnableKinesisStreamingDestinationResponse]

      def executeStatement(
        request: ExecuteStatementRequest
      ): F[ExecuteStatementResponse]

      def executeTransaction(
        request: ExecuteTransactionRequest
      ): F[ExecuteTransactionResponse]

      def exportTableToPointInTime(
        request: ExportTableToPointInTimeRequest
      ): F[ExportTableToPointInTimeResponse]

      def getItem(
        request: GetItemRequest
      ): F[GetItemResponse]

      def listBackups(
        request: ListBackupsRequest
      ): F[ListBackupsResponse]

      def listContributorInsights(
        request: ListContributorInsightsRequest
      ): F[ListContributorInsightsResponse]

      def listExports(
        request: ListExportsRequest
      ): F[ListExportsResponse]

      def listGlobalTables(
        request: ListGlobalTablesRequest
      ): F[ListGlobalTablesResponse]

      def listTables(
        request: ListTablesRequest
      ): F[ListTablesResponse]

      def listTagsOfResource(
        request: ListTagsOfResourceRequest
      ): F[ListTagsOfResourceResponse]

      def putItem(
        request: PutItemRequest
      ): F[PutItemResponse]

      def query(
        request: QueryRequest
      ): F[QueryResponse]

      def restoreTableFromBackup(
        request: RestoreTableFromBackupRequest
      ): F[RestoreTableFromBackupResponse]

      def restoreTableToPointInTime(
        request: RestoreTableToPointInTimeRequest
      ): F[RestoreTableToPointInTimeResponse]

      def scan(
        request: ScanRequest
      ): F[ScanResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def transactGetItems(
        request: TransactGetItemsRequest
      ): F[TransactGetItemsResponse]

      def transactWriteItems(
        request: TransactWriteItemsRequest
      ): F[TransactWriteItemsResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateContinuousBackups(
        request: UpdateContinuousBackupsRequest
      ): F[UpdateContinuousBackupsResponse]

      def updateContributorInsights(
        request: UpdateContributorInsightsRequest
      ): F[UpdateContributorInsightsResponse]

      def updateGlobalTable(
        request: UpdateGlobalTableRequest
      ): F[UpdateGlobalTableResponse]

      def updateGlobalTableSettings(
        request: UpdateGlobalTableSettingsRequest
      ): F[UpdateGlobalTableSettingsResponse]

      def updateItem(
        request: UpdateItemRequest
      ): F[UpdateItemResponse]

      def updateTable(
        request: UpdateTableRequest
      ): F[UpdateTableResponse]

      def updateTableReplicaAutoScaling(
        request: UpdateTableReplicaAutoScalingRequest
      ): F[UpdateTableReplicaAutoScalingResponse]

      def updateTimeToLive(
        request: UpdateTimeToLiveRequest
      ): F[UpdateTimeToLiveResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DynamoDbOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchExecuteStatementOp(
      request: BatchExecuteStatementRequest
    ) extends DynamoDbOp[BatchExecuteStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchExecuteStatementResponse] =
        visitor.batchExecuteStatement(request)
    }

    final case class BatchGetItemOp(
      request: BatchGetItemRequest
    ) extends DynamoDbOp[BatchGetItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetItemResponse] =
        visitor.batchGetItem(request)
    }

    final case class BatchWriteItemOp(
      request: BatchWriteItemRequest
    ) extends DynamoDbOp[BatchWriteItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchWriteItemResponse] =
        visitor.batchWriteItem(request)
    }

    final case class CreateBackupOp(
      request: CreateBackupRequest
    ) extends DynamoDbOp[CreateBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackupResponse] =
        visitor.createBackup(request)
    }

    final case class CreateGlobalTableOp(
      request: CreateGlobalTableRequest
    ) extends DynamoDbOp[CreateGlobalTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGlobalTableResponse] =
        visitor.createGlobalTable(request)
    }

    final case class CreateTableOp(
      request: CreateTableRequest
    ) extends DynamoDbOp[CreateTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTableResponse] =
        visitor.createTable(request)
    }

    final case class DeleteBackupOp(
      request: DeleteBackupRequest
    ) extends DynamoDbOp[DeleteBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupResponse] =
        visitor.deleteBackup(request)
    }

    final case class DeleteItemOp(
      request: DeleteItemRequest
    ) extends DynamoDbOp[DeleteItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteItemResponse] =
        visitor.deleteItem(request)
    }

    final case class DeleteTableOp(
      request: DeleteTableRequest
    ) extends DynamoDbOp[DeleteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTableResponse] =
        visitor.deleteTable(request)
    }

    final case class DescribeBackupOp(
      request: DescribeBackupRequest
    ) extends DynamoDbOp[DescribeBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBackupResponse] =
        visitor.describeBackup(request)
    }

    final case class DescribeContinuousBackupsOp(
      request: DescribeContinuousBackupsRequest
    ) extends DynamoDbOp[DescribeContinuousBackupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContinuousBackupsResponse] =
        visitor.describeContinuousBackups(request)
    }

    final case class DescribeContributorInsightsOp(
      request: DescribeContributorInsightsRequest
    ) extends DynamoDbOp[DescribeContributorInsightsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContributorInsightsResponse] =
        visitor.describeContributorInsights(request)
    }

    final case class DescribeEndpointsOp(
      request: DescribeEndpointsRequest
    ) extends DynamoDbOp[DescribeEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointsResponse] =
        visitor.describeEndpoints(request)
    }

    final case class DescribeExportOp(
      request: DescribeExportRequest
    ) extends DynamoDbOp[DescribeExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExportResponse] =
        visitor.describeExport(request)
    }

    final case class DescribeGlobalTableOp(
      request: DescribeGlobalTableRequest
    ) extends DynamoDbOp[DescribeGlobalTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGlobalTableResponse] =
        visitor.describeGlobalTable(request)
    }

    final case class DescribeGlobalTableSettingsOp(
      request: DescribeGlobalTableSettingsRequest
    ) extends DynamoDbOp[DescribeGlobalTableSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGlobalTableSettingsResponse] =
        visitor.describeGlobalTableSettings(request)
    }

    final case class DescribeKinesisStreamingDestinationOp(
      request: DescribeKinesisStreamingDestinationRequest
    ) extends DynamoDbOp[DescribeKinesisStreamingDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeKinesisStreamingDestinationResponse] =
        visitor.describeKinesisStreamingDestination(request)
    }

    final case class DescribeLimitsOp(
      request: DescribeLimitsRequest
    ) extends DynamoDbOp[DescribeLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLimitsResponse] =
        visitor.describeLimits(request)
    }

    final case class DescribeTableOp(
      request: DescribeTableRequest
    ) extends DynamoDbOp[DescribeTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTableResponse] =
        visitor.describeTable(request)
    }

    final case class DescribeTableReplicaAutoScalingOp(
      request: DescribeTableReplicaAutoScalingRequest
    ) extends DynamoDbOp[DescribeTableReplicaAutoScalingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTableReplicaAutoScalingResponse] =
        visitor.describeTableReplicaAutoScaling(request)
    }

    final case class DescribeTimeToLiveOp(
      request: DescribeTimeToLiveRequest
    ) extends DynamoDbOp[DescribeTimeToLiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTimeToLiveResponse] =
        visitor.describeTimeToLive(request)
    }

    final case class DisableKinesisStreamingDestinationOp(
      request: DisableKinesisStreamingDestinationRequest
    ) extends DynamoDbOp[DisableKinesisStreamingDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableKinesisStreamingDestinationResponse] =
        visitor.disableKinesisStreamingDestination(request)
    }

    final case class EnableKinesisStreamingDestinationOp(
      request: EnableKinesisStreamingDestinationRequest
    ) extends DynamoDbOp[EnableKinesisStreamingDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableKinesisStreamingDestinationResponse] =
        visitor.enableKinesisStreamingDestination(request)
    }

    final case class ExecuteStatementOp(
      request: ExecuteStatementRequest
    ) extends DynamoDbOp[ExecuteStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteStatementResponse] =
        visitor.executeStatement(request)
    }

    final case class ExecuteTransactionOp(
      request: ExecuteTransactionRequest
    ) extends DynamoDbOp[ExecuteTransactionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteTransactionResponse] =
        visitor.executeTransaction(request)
    }

    final case class ExportTableToPointInTimeOp(
      request: ExportTableToPointInTimeRequest
    ) extends DynamoDbOp[ExportTableToPointInTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportTableToPointInTimeResponse] =
        visitor.exportTableToPointInTime(request)
    }

    final case class GetItemOp(
      request: GetItemRequest
    ) extends DynamoDbOp[GetItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetItemResponse] =
        visitor.getItem(request)
    }

    final case class ListBackupsOp(
      request: ListBackupsRequest
    ) extends DynamoDbOp[ListBackupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackupsResponse] =
        visitor.listBackups(request)
    }

    final case class ListContributorInsightsOp(
      request: ListContributorInsightsRequest
    ) extends DynamoDbOp[ListContributorInsightsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContributorInsightsResponse] =
        visitor.listContributorInsights(request)
    }

    final case class ListExportsOp(
      request: ListExportsRequest
    ) extends DynamoDbOp[ListExportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExportsResponse] =
        visitor.listExports(request)
    }

    final case class ListGlobalTablesOp(
      request: ListGlobalTablesRequest
    ) extends DynamoDbOp[ListGlobalTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGlobalTablesResponse] =
        visitor.listGlobalTables(request)
    }

    final case class ListTablesOp(
      request: ListTablesRequest
    ) extends DynamoDbOp[ListTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTablesResponse] =
        visitor.listTables(request)
    }

    final case class ListTagsOfResourceOp(
      request: ListTagsOfResourceRequest
    ) extends DynamoDbOp[ListTagsOfResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsOfResourceResponse] =
        visitor.listTagsOfResource(request)
    }

    final case class PutItemOp(
      request: PutItemRequest
    ) extends DynamoDbOp[PutItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutItemResponse] =
        visitor.putItem(request)
    }

    final case class QueryOp(
      request: QueryRequest
    ) extends DynamoDbOp[QueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[QueryResponse] =
        visitor.query(request)
    }

    final case class RestoreTableFromBackupOp(
      request: RestoreTableFromBackupRequest
    ) extends DynamoDbOp[RestoreTableFromBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreTableFromBackupResponse] =
        visitor.restoreTableFromBackup(request)
    }

    final case class RestoreTableToPointInTimeOp(
      request: RestoreTableToPointInTimeRequest
    ) extends DynamoDbOp[RestoreTableToPointInTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreTableToPointInTimeResponse] =
        visitor.restoreTableToPointInTime(request)
    }

    final case class ScanOp(
      request: ScanRequest
    ) extends DynamoDbOp[ScanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ScanResponse] =
        visitor.scan(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DynamoDbOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TransactGetItemsOp(
      request: TransactGetItemsRequest
    ) extends DynamoDbOp[TransactGetItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TransactGetItemsResponse] =
        visitor.transactGetItems(request)
    }

    final case class TransactWriteItemsOp(
      request: TransactWriteItemsRequest
    ) extends DynamoDbOp[TransactWriteItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TransactWriteItemsResponse] =
        visitor.transactWriteItems(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DynamoDbOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateContinuousBackupsOp(
      request: UpdateContinuousBackupsRequest
    ) extends DynamoDbOp[UpdateContinuousBackupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContinuousBackupsResponse] =
        visitor.updateContinuousBackups(request)
    }

    final case class UpdateContributorInsightsOp(
      request: UpdateContributorInsightsRequest
    ) extends DynamoDbOp[UpdateContributorInsightsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContributorInsightsResponse] =
        visitor.updateContributorInsights(request)
    }

    final case class UpdateGlobalTableOp(
      request: UpdateGlobalTableRequest
    ) extends DynamoDbOp[UpdateGlobalTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGlobalTableResponse] =
        visitor.updateGlobalTable(request)
    }

    final case class UpdateGlobalTableSettingsOp(
      request: UpdateGlobalTableSettingsRequest
    ) extends DynamoDbOp[UpdateGlobalTableSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGlobalTableSettingsResponse] =
        visitor.updateGlobalTableSettings(request)
    }

    final case class UpdateItemOp(
      request: UpdateItemRequest
    ) extends DynamoDbOp[UpdateItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateItemResponse] =
        visitor.updateItem(request)
    }

    final case class UpdateTableOp(
      request: UpdateTableRequest
    ) extends DynamoDbOp[UpdateTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTableResponse] =
        visitor.updateTable(request)
    }

    final case class UpdateTableReplicaAutoScalingOp(
      request: UpdateTableReplicaAutoScalingRequest
    ) extends DynamoDbOp[UpdateTableReplicaAutoScalingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTableReplicaAutoScalingResponse] =
        visitor.updateTableReplicaAutoScaling(request)
    }

    final case class UpdateTimeToLiveOp(
      request: UpdateTimeToLiveRequest
    ) extends DynamoDbOp[UpdateTimeToLiveResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTimeToLiveResponse] =
        visitor.updateTimeToLive(request)
    }
  }

  import DynamoDbOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DynamoDbOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchExecuteStatement(
    request: BatchExecuteStatementRequest
  ): DynamoDbIO[BatchExecuteStatementResponse] =
    FF.liftF(BatchExecuteStatementOp(request))

  def batchGetItem(
    request: BatchGetItemRequest
  ): DynamoDbIO[BatchGetItemResponse] =
    FF.liftF(BatchGetItemOp(request))

  def batchWriteItem(
    request: BatchWriteItemRequest
  ): DynamoDbIO[BatchWriteItemResponse] =
    FF.liftF(BatchWriteItemOp(request))

  def createBackup(
    request: CreateBackupRequest
  ): DynamoDbIO[CreateBackupResponse] =
    FF.liftF(CreateBackupOp(request))

  def createGlobalTable(
    request: CreateGlobalTableRequest
  ): DynamoDbIO[CreateGlobalTableResponse] =
    FF.liftF(CreateGlobalTableOp(request))

  def createTable(
    request: CreateTableRequest
  ): DynamoDbIO[CreateTableResponse] =
    FF.liftF(CreateTableOp(request))

  def deleteBackup(
    request: DeleteBackupRequest
  ): DynamoDbIO[DeleteBackupResponse] =
    FF.liftF(DeleteBackupOp(request))

  def deleteItem(
    request: DeleteItemRequest
  ): DynamoDbIO[DeleteItemResponse] =
    FF.liftF(DeleteItemOp(request))

  def deleteTable(
    request: DeleteTableRequest
  ): DynamoDbIO[DeleteTableResponse] =
    FF.liftF(DeleteTableOp(request))

  def describeBackup(
    request: DescribeBackupRequest
  ): DynamoDbIO[DescribeBackupResponse] =
    FF.liftF(DescribeBackupOp(request))

  def describeContinuousBackups(
    request: DescribeContinuousBackupsRequest
  ): DynamoDbIO[DescribeContinuousBackupsResponse] =
    FF.liftF(DescribeContinuousBackupsOp(request))

  def describeContributorInsights(
    request: DescribeContributorInsightsRequest
  ): DynamoDbIO[DescribeContributorInsightsResponse] =
    FF.liftF(DescribeContributorInsightsOp(request))

  def describeEndpoints(
    request: DescribeEndpointsRequest
  ): DynamoDbIO[DescribeEndpointsResponse] =
    FF.liftF(DescribeEndpointsOp(request))

  def describeExport(
    request: DescribeExportRequest
  ): DynamoDbIO[DescribeExportResponse] =
    FF.liftF(DescribeExportOp(request))

  def describeGlobalTable(
    request: DescribeGlobalTableRequest
  ): DynamoDbIO[DescribeGlobalTableResponse] =
    FF.liftF(DescribeGlobalTableOp(request))

  def describeGlobalTableSettings(
    request: DescribeGlobalTableSettingsRequest
  ): DynamoDbIO[DescribeGlobalTableSettingsResponse] =
    FF.liftF(DescribeGlobalTableSettingsOp(request))

  def describeKinesisStreamingDestination(
    request: DescribeKinesisStreamingDestinationRequest
  ): DynamoDbIO[DescribeKinesisStreamingDestinationResponse] =
    FF.liftF(DescribeKinesisStreamingDestinationOp(request))

  def describeLimits(
    request: DescribeLimitsRequest
  ): DynamoDbIO[DescribeLimitsResponse] =
    FF.liftF(DescribeLimitsOp(request))

  def describeTable(
    request: DescribeTableRequest
  ): DynamoDbIO[DescribeTableResponse] =
    FF.liftF(DescribeTableOp(request))

  def describeTableReplicaAutoScaling(
    request: DescribeTableReplicaAutoScalingRequest
  ): DynamoDbIO[DescribeTableReplicaAutoScalingResponse] =
    FF.liftF(DescribeTableReplicaAutoScalingOp(request))

  def describeTimeToLive(
    request: DescribeTimeToLiveRequest
  ): DynamoDbIO[DescribeTimeToLiveResponse] =
    FF.liftF(DescribeTimeToLiveOp(request))

  def disableKinesisStreamingDestination(
    request: DisableKinesisStreamingDestinationRequest
  ): DynamoDbIO[DisableKinesisStreamingDestinationResponse] =
    FF.liftF(DisableKinesisStreamingDestinationOp(request))

  def enableKinesisStreamingDestination(
    request: EnableKinesisStreamingDestinationRequest
  ): DynamoDbIO[EnableKinesisStreamingDestinationResponse] =
    FF.liftF(EnableKinesisStreamingDestinationOp(request))

  def executeStatement(
    request: ExecuteStatementRequest
  ): DynamoDbIO[ExecuteStatementResponse] =
    FF.liftF(ExecuteStatementOp(request))

  def executeTransaction(
    request: ExecuteTransactionRequest
  ): DynamoDbIO[ExecuteTransactionResponse] =
    FF.liftF(ExecuteTransactionOp(request))

  def exportTableToPointInTime(
    request: ExportTableToPointInTimeRequest
  ): DynamoDbIO[ExportTableToPointInTimeResponse] =
    FF.liftF(ExportTableToPointInTimeOp(request))

  def getItem(
    request: GetItemRequest
  ): DynamoDbIO[GetItemResponse] =
    FF.liftF(GetItemOp(request))

  def listBackups(
    request: ListBackupsRequest
  ): DynamoDbIO[ListBackupsResponse] =
    FF.liftF(ListBackupsOp(request))

  def listContributorInsights(
    request: ListContributorInsightsRequest
  ): DynamoDbIO[ListContributorInsightsResponse] =
    FF.liftF(ListContributorInsightsOp(request))

  def listExports(
    request: ListExportsRequest
  ): DynamoDbIO[ListExportsResponse] =
    FF.liftF(ListExportsOp(request))

  def listGlobalTables(
    request: ListGlobalTablesRequest
  ): DynamoDbIO[ListGlobalTablesResponse] =
    FF.liftF(ListGlobalTablesOp(request))

  def listTables(
    request: ListTablesRequest
  ): DynamoDbIO[ListTablesResponse] =
    FF.liftF(ListTablesOp(request))

  def listTagsOfResource(
    request: ListTagsOfResourceRequest
  ): DynamoDbIO[ListTagsOfResourceResponse] =
    FF.liftF(ListTagsOfResourceOp(request))

  def putItem(
    request: PutItemRequest
  ): DynamoDbIO[PutItemResponse] =
    FF.liftF(PutItemOp(request))

  def query(
    request: QueryRequest
  ): DynamoDbIO[QueryResponse] =
    FF.liftF(QueryOp(request))

  def restoreTableFromBackup(
    request: RestoreTableFromBackupRequest
  ): DynamoDbIO[RestoreTableFromBackupResponse] =
    FF.liftF(RestoreTableFromBackupOp(request))

  def restoreTableToPointInTime(
    request: RestoreTableToPointInTimeRequest
  ): DynamoDbIO[RestoreTableToPointInTimeResponse] =
    FF.liftF(RestoreTableToPointInTimeOp(request))

  def scan(
    request: ScanRequest
  ): DynamoDbIO[ScanResponse] =
    FF.liftF(ScanOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DynamoDbIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def transactGetItems(
    request: TransactGetItemsRequest
  ): DynamoDbIO[TransactGetItemsResponse] =
    FF.liftF(TransactGetItemsOp(request))

  def transactWriteItems(
    request: TransactWriteItemsRequest
  ): DynamoDbIO[TransactWriteItemsResponse] =
    FF.liftF(TransactWriteItemsOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DynamoDbIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateContinuousBackups(
    request: UpdateContinuousBackupsRequest
  ): DynamoDbIO[UpdateContinuousBackupsResponse] =
    FF.liftF(UpdateContinuousBackupsOp(request))

  def updateContributorInsights(
    request: UpdateContributorInsightsRequest
  ): DynamoDbIO[UpdateContributorInsightsResponse] =
    FF.liftF(UpdateContributorInsightsOp(request))

  def updateGlobalTable(
    request: UpdateGlobalTableRequest
  ): DynamoDbIO[UpdateGlobalTableResponse] =
    FF.liftF(UpdateGlobalTableOp(request))

  def updateGlobalTableSettings(
    request: UpdateGlobalTableSettingsRequest
  ): DynamoDbIO[UpdateGlobalTableSettingsResponse] =
    FF.liftF(UpdateGlobalTableSettingsOp(request))

  def updateItem(
    request: UpdateItemRequest
  ): DynamoDbIO[UpdateItemResponse] =
    FF.liftF(UpdateItemOp(request))

  def updateTable(
    request: UpdateTableRequest
  ): DynamoDbIO[UpdateTableResponse] =
    FF.liftF(UpdateTableOp(request))

  def updateTableReplicaAutoScaling(
    request: UpdateTableReplicaAutoScalingRequest
  ): DynamoDbIO[UpdateTableReplicaAutoScalingResponse] =
    FF.liftF(UpdateTableReplicaAutoScalingOp(request))

  def updateTimeToLive(
    request: UpdateTimeToLiveRequest
  ): DynamoDbIO[UpdateTimeToLiveResponse] =
    FF.liftF(UpdateTimeToLiveOp(request))
}
