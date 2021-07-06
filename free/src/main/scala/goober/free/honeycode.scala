package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.honeycode.HoneycodeClient
import software.amazon.awssdk.services.honeycode.model._


object honeycode { module =>

  // Free monad over HoneycodeOp
  type HoneycodeIO[A] = FF[HoneycodeOp, A]

  sealed trait HoneycodeOp[A] {
    def visit[F[_]](visitor: HoneycodeOp.Visitor[F]): F[A]
  }

  object HoneycodeOp {
    // Given a HoneycodeClient we can embed a HoneycodeIO program in any algebra that understands embedding.
    implicit val HoneycodeOpEmbeddable: Embeddable[HoneycodeOp, HoneycodeClient] = new Embeddable[HoneycodeOp, HoneycodeClient] {
      def embed[A](client: HoneycodeClient, io: HoneycodeIO[A]): Embedded[A] = Embedded.Honeycode(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends HoneycodeOp.Visitor[Kleisli[M, HoneycodeClient, *]] {
        def batchCreateTableRows(
          request: BatchCreateTableRowsRequest
        ): Kleisli[M, HoneycodeClient, BatchCreateTableRowsResponse] =
          primitive(_.batchCreateTableRows(request))

        def batchDeleteTableRows(
          request: BatchDeleteTableRowsRequest
        ): Kleisli[M, HoneycodeClient, BatchDeleteTableRowsResponse] =
          primitive(_.batchDeleteTableRows(request))

        def batchUpdateTableRows(
          request: BatchUpdateTableRowsRequest
        ): Kleisli[M, HoneycodeClient, BatchUpdateTableRowsResponse] =
          primitive(_.batchUpdateTableRows(request))

        def batchUpsertTableRows(
          request: BatchUpsertTableRowsRequest
        ): Kleisli[M, HoneycodeClient, BatchUpsertTableRowsResponse] =
          primitive(_.batchUpsertTableRows(request))

        def describeTableDataImportJob(
          request: DescribeTableDataImportJobRequest
        ): Kleisli[M, HoneycodeClient, DescribeTableDataImportJobResponse] =
          primitive(_.describeTableDataImportJob(request))

        def getScreenData(
          request: GetScreenDataRequest
        ): Kleisli[M, HoneycodeClient, GetScreenDataResponse] =
          primitive(_.getScreenData(request))

        def invokeScreenAutomation(
          request: InvokeScreenAutomationRequest
        ): Kleisli[M, HoneycodeClient, InvokeScreenAutomationResponse] =
          primitive(_.invokeScreenAutomation(request))

        def listTableColumns(
          request: ListTableColumnsRequest
        ): Kleisli[M, HoneycodeClient, ListTableColumnsResponse] =
          primitive(_.listTableColumns(request))

        def listTableRows(
          request: ListTableRowsRequest
        ): Kleisli[M, HoneycodeClient, ListTableRowsResponse] =
          primitive(_.listTableRows(request))

        def listTables(
          request: ListTablesRequest
        ): Kleisli[M, HoneycodeClient, ListTablesResponse] =
          primitive(_.listTables(request))

        def queryTableRows(
          request: QueryTableRowsRequest
        ): Kleisli[M, HoneycodeClient, QueryTableRowsResponse] =
          primitive(_.queryTableRows(request))

        def startTableDataImportJob(
          request: StartTableDataImportJobRequest
        ): Kleisli[M, HoneycodeClient, StartTableDataImportJobResponse] =
          primitive(_.startTableDataImportJob(request))

        def primitive[A](
          f: HoneycodeClient => A
        ): Kleisli[M, HoneycodeClient, A]
      }
    }

    trait Visitor[F[_]] extends (HoneycodeOp ~> F) {
      final def apply[A](op: HoneycodeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchCreateTableRows(
        request: BatchCreateTableRowsRequest
      ): F[BatchCreateTableRowsResponse]

      def batchDeleteTableRows(
        request: BatchDeleteTableRowsRequest
      ): F[BatchDeleteTableRowsResponse]

      def batchUpdateTableRows(
        request: BatchUpdateTableRowsRequest
      ): F[BatchUpdateTableRowsResponse]

      def batchUpsertTableRows(
        request: BatchUpsertTableRowsRequest
      ): F[BatchUpsertTableRowsResponse]

      def describeTableDataImportJob(
        request: DescribeTableDataImportJobRequest
      ): F[DescribeTableDataImportJobResponse]

      def getScreenData(
        request: GetScreenDataRequest
      ): F[GetScreenDataResponse]

      def invokeScreenAutomation(
        request: InvokeScreenAutomationRequest
      ): F[InvokeScreenAutomationResponse]

      def listTableColumns(
        request: ListTableColumnsRequest
      ): F[ListTableColumnsResponse]

      def listTableRows(
        request: ListTableRowsRequest
      ): F[ListTableRowsResponse]

      def listTables(
        request: ListTablesRequest
      ): F[ListTablesResponse]

      def queryTableRows(
        request: QueryTableRowsRequest
      ): F[QueryTableRowsResponse]

      def startTableDataImportJob(
        request: StartTableDataImportJobRequest
      ): F[StartTableDataImportJobResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends HoneycodeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchCreateTableRowsOp(
      request: BatchCreateTableRowsRequest
    ) extends HoneycodeOp[BatchCreateTableRowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCreateTableRowsResponse] =
        visitor.batchCreateTableRows(request)
    }

    final case class BatchDeleteTableRowsOp(
      request: BatchDeleteTableRowsRequest
    ) extends HoneycodeOp[BatchDeleteTableRowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteTableRowsResponse] =
        visitor.batchDeleteTableRows(request)
    }

    final case class BatchUpdateTableRowsOp(
      request: BatchUpdateTableRowsRequest
    ) extends HoneycodeOp[BatchUpdateTableRowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdateTableRowsResponse] =
        visitor.batchUpdateTableRows(request)
    }

    final case class BatchUpsertTableRowsOp(
      request: BatchUpsertTableRowsRequest
    ) extends HoneycodeOp[BatchUpsertTableRowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpsertTableRowsResponse] =
        visitor.batchUpsertTableRows(request)
    }

    final case class DescribeTableDataImportJobOp(
      request: DescribeTableDataImportJobRequest
    ) extends HoneycodeOp[DescribeTableDataImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTableDataImportJobResponse] =
        visitor.describeTableDataImportJob(request)
    }

    final case class GetScreenDataOp(
      request: GetScreenDataRequest
    ) extends HoneycodeOp[GetScreenDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetScreenDataResponse] =
        visitor.getScreenData(request)
    }

    final case class InvokeScreenAutomationOp(
      request: InvokeScreenAutomationRequest
    ) extends HoneycodeOp[InvokeScreenAutomationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InvokeScreenAutomationResponse] =
        visitor.invokeScreenAutomation(request)
    }

    final case class ListTableColumnsOp(
      request: ListTableColumnsRequest
    ) extends HoneycodeOp[ListTableColumnsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTableColumnsResponse] =
        visitor.listTableColumns(request)
    }

    final case class ListTableRowsOp(
      request: ListTableRowsRequest
    ) extends HoneycodeOp[ListTableRowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTableRowsResponse] =
        visitor.listTableRows(request)
    }

    final case class ListTablesOp(
      request: ListTablesRequest
    ) extends HoneycodeOp[ListTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTablesResponse] =
        visitor.listTables(request)
    }

    final case class QueryTableRowsOp(
      request: QueryTableRowsRequest
    ) extends HoneycodeOp[QueryTableRowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[QueryTableRowsResponse] =
        visitor.queryTableRows(request)
    }

    final case class StartTableDataImportJobOp(
      request: StartTableDataImportJobRequest
    ) extends HoneycodeOp[StartTableDataImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTableDataImportJobResponse] =
        visitor.startTableDataImportJob(request)
    }
  }

  import HoneycodeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[HoneycodeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchCreateTableRows(
    request: BatchCreateTableRowsRequest
  ): HoneycodeIO[BatchCreateTableRowsResponse] =
    FF.liftF(BatchCreateTableRowsOp(request))

  def batchDeleteTableRows(
    request: BatchDeleteTableRowsRequest
  ): HoneycodeIO[BatchDeleteTableRowsResponse] =
    FF.liftF(BatchDeleteTableRowsOp(request))

  def batchUpdateTableRows(
    request: BatchUpdateTableRowsRequest
  ): HoneycodeIO[BatchUpdateTableRowsResponse] =
    FF.liftF(BatchUpdateTableRowsOp(request))

  def batchUpsertTableRows(
    request: BatchUpsertTableRowsRequest
  ): HoneycodeIO[BatchUpsertTableRowsResponse] =
    FF.liftF(BatchUpsertTableRowsOp(request))

  def describeTableDataImportJob(
    request: DescribeTableDataImportJobRequest
  ): HoneycodeIO[DescribeTableDataImportJobResponse] =
    FF.liftF(DescribeTableDataImportJobOp(request))

  def getScreenData(
    request: GetScreenDataRequest
  ): HoneycodeIO[GetScreenDataResponse] =
    FF.liftF(GetScreenDataOp(request))

  def invokeScreenAutomation(
    request: InvokeScreenAutomationRequest
  ): HoneycodeIO[InvokeScreenAutomationResponse] =
    FF.liftF(InvokeScreenAutomationOp(request))

  def listTableColumns(
    request: ListTableColumnsRequest
  ): HoneycodeIO[ListTableColumnsResponse] =
    FF.liftF(ListTableColumnsOp(request))

  def listTableRows(
    request: ListTableRowsRequest
  ): HoneycodeIO[ListTableRowsResponse] =
    FF.liftF(ListTableRowsOp(request))

  def listTables(
    request: ListTablesRequest
  ): HoneycodeIO[ListTablesResponse] =
    FF.liftF(ListTablesOp(request))

  def queryTableRows(
    request: QueryTableRowsRequest
  ): HoneycodeIO[QueryTableRowsResponse] =
    FF.liftF(QueryTableRowsOp(request))

  def startTableDataImportJob(
    request: StartTableDataImportJobRequest
  ): HoneycodeIO[StartTableDataImportJobResponse] =
    FF.liftF(StartTableDataImportJobOp(request))
}
