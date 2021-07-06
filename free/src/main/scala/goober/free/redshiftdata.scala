package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.redshiftdata.RedshiftDataClient
import software.amazon.awssdk.services.redshiftdata.model._


object redshiftdata { module =>

  // Free monad over RedshiftDataOp
  type RedshiftDataIO[A] = FF[RedshiftDataOp, A]

  sealed trait RedshiftDataOp[A] {
    def visit[F[_]](visitor: RedshiftDataOp.Visitor[F]): F[A]
  }

  object RedshiftDataOp {
    // Given a RedshiftDataClient we can embed a RedshiftDataIO program in any algebra that understands embedding.
    implicit val RedshiftDataOpEmbeddable: Embeddable[RedshiftDataOp, RedshiftDataClient] = new Embeddable[RedshiftDataOp, RedshiftDataClient] {
      def embed[A](client: RedshiftDataClient, io: RedshiftDataIO[A]): Embedded[A] = Embedded.RedshiftData(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends RedshiftDataOp.Visitor[Kleisli[M, RedshiftDataClient, *]] {
        def cancelStatement(
          request: CancelStatementRequest
        ): Kleisli[M, RedshiftDataClient, CancelStatementResponse] =
          primitive(_.cancelStatement(request))

        def describeStatement(
          request: DescribeStatementRequest
        ): Kleisli[M, RedshiftDataClient, DescribeStatementResponse] =
          primitive(_.describeStatement(request))

        def describeTable(
          request: DescribeTableRequest
        ): Kleisli[M, RedshiftDataClient, DescribeTableResponse] =
          primitive(_.describeTable(request))

        def executeStatement(
          request: ExecuteStatementRequest
        ): Kleisli[M, RedshiftDataClient, ExecuteStatementResponse] =
          primitive(_.executeStatement(request))

        def getStatementResult(
          request: GetStatementResultRequest
        ): Kleisli[M, RedshiftDataClient, GetStatementResultResponse] =
          primitive(_.getStatementResult(request))

        def listDatabases(
          request: ListDatabasesRequest
        ): Kleisli[M, RedshiftDataClient, ListDatabasesResponse] =
          primitive(_.listDatabases(request))

        def listSchemas(
          request: ListSchemasRequest
        ): Kleisli[M, RedshiftDataClient, ListSchemasResponse] =
          primitive(_.listSchemas(request))

        def listStatements(
          request: ListStatementsRequest
        ): Kleisli[M, RedshiftDataClient, ListStatementsResponse] =
          primitive(_.listStatements(request))

        def listTables(
          request: ListTablesRequest
        ): Kleisli[M, RedshiftDataClient, ListTablesResponse] =
          primitive(_.listTables(request))

        def primitive[A](
          f: RedshiftDataClient => A
        ): Kleisli[M, RedshiftDataClient, A]
      }
    }

    trait Visitor[F[_]] extends (RedshiftDataOp ~> F) {
      final def apply[A](op: RedshiftDataOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelStatement(
        request: CancelStatementRequest
      ): F[CancelStatementResponse]

      def describeStatement(
        request: DescribeStatementRequest
      ): F[DescribeStatementResponse]

      def describeTable(
        request: DescribeTableRequest
      ): F[DescribeTableResponse]

      def executeStatement(
        request: ExecuteStatementRequest
      ): F[ExecuteStatementResponse]

      def getStatementResult(
        request: GetStatementResultRequest
      ): F[GetStatementResultResponse]

      def listDatabases(
        request: ListDatabasesRequest
      ): F[ListDatabasesResponse]

      def listSchemas(
        request: ListSchemasRequest
      ): F[ListSchemasResponse]

      def listStatements(
        request: ListStatementsRequest
      ): F[ListStatementsResponse]

      def listTables(
        request: ListTablesRequest
      ): F[ListTablesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends RedshiftDataOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelStatementOp(
      request: CancelStatementRequest
    ) extends RedshiftDataOp[CancelStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelStatementResponse] =
        visitor.cancelStatement(request)
    }

    final case class DescribeStatementOp(
      request: DescribeStatementRequest
    ) extends RedshiftDataOp[DescribeStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStatementResponse] =
        visitor.describeStatement(request)
    }

    final case class DescribeTableOp(
      request: DescribeTableRequest
    ) extends RedshiftDataOp[DescribeTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTableResponse] =
        visitor.describeTable(request)
    }

    final case class ExecuteStatementOp(
      request: ExecuteStatementRequest
    ) extends RedshiftDataOp[ExecuteStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteStatementResponse] =
        visitor.executeStatement(request)
    }

    final case class GetStatementResultOp(
      request: GetStatementResultRequest
    ) extends RedshiftDataOp[GetStatementResultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStatementResultResponse] =
        visitor.getStatementResult(request)
    }

    final case class ListDatabasesOp(
      request: ListDatabasesRequest
    ) extends RedshiftDataOp[ListDatabasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatabasesResponse] =
        visitor.listDatabases(request)
    }

    final case class ListSchemasOp(
      request: ListSchemasRequest
    ) extends RedshiftDataOp[ListSchemasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchemasResponse] =
        visitor.listSchemas(request)
    }

    final case class ListStatementsOp(
      request: ListStatementsRequest
    ) extends RedshiftDataOp[ListStatementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStatementsResponse] =
        visitor.listStatements(request)
    }

    final case class ListTablesOp(
      request: ListTablesRequest
    ) extends RedshiftDataOp[ListTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTablesResponse] =
        visitor.listTables(request)
    }
  }

  import RedshiftDataOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[RedshiftDataOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelStatement(
    request: CancelStatementRequest
  ): RedshiftDataIO[CancelStatementResponse] =
    FF.liftF(CancelStatementOp(request))

  def describeStatement(
    request: DescribeStatementRequest
  ): RedshiftDataIO[DescribeStatementResponse] =
    FF.liftF(DescribeStatementOp(request))

  def describeTable(
    request: DescribeTableRequest
  ): RedshiftDataIO[DescribeTableResponse] =
    FF.liftF(DescribeTableOp(request))

  def executeStatement(
    request: ExecuteStatementRequest
  ): RedshiftDataIO[ExecuteStatementResponse] =
    FF.liftF(ExecuteStatementOp(request))

  def getStatementResult(
    request: GetStatementResultRequest
  ): RedshiftDataIO[GetStatementResultResponse] =
    FF.liftF(GetStatementResultOp(request))

  def listDatabases(
    request: ListDatabasesRequest
  ): RedshiftDataIO[ListDatabasesResponse] =
    FF.liftF(ListDatabasesOp(request))

  def listSchemas(
    request: ListSchemasRequest
  ): RedshiftDataIO[ListSchemasResponse] =
    FF.liftF(ListSchemasOp(request))

  def listStatements(
    request: ListStatementsRequest
  ): RedshiftDataIO[ListStatementsResponse] =
    FF.liftF(ListStatementsOp(request))

  def listTables(
    request: ListTablesRequest
  ): RedshiftDataIO[ListTablesResponse] =
    FF.liftF(ListTablesOp(request))
}
