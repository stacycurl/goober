package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.rdsdata.RdsDataClient
import software.amazon.awssdk.services.rdsdata.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object rdsdata { module =>

  // Free monad over RdsDataOp
  type RdsDataIO[A] = FF[RdsDataOp, A]

  sealed trait RdsDataOp[A] {
    def visit[F[_]](visitor: RdsDataOp.Visitor[F]): F[A]
  }

  object RdsDataOp {
    // Given a RdsDataClient we can embed a RdsDataIO program in any algebra that understands embedding.
    implicit val RdsDataOpEmbeddable: Embeddable[RdsDataOp, RdsDataClient] = new Embeddable[RdsDataOp, RdsDataClient] {
      def embed[A](client: RdsDataClient, io: RdsDataIO[A]): Embedded[A] = Embedded.RdsData(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends RdsDataOp.Visitor[Kleisli[M, RdsDataClient, *]] {
        def batchExecuteStatement(
          request: BatchExecuteStatementRequest
        ): Kleisli[M, RdsDataClient, BatchExecuteStatementResponse] =
          primitive(_.batchExecuteStatement(request))

        def beginTransaction(
          request: BeginTransactionRequest
        ): Kleisli[M, RdsDataClient, BeginTransactionResponse] =
          primitive(_.beginTransaction(request))

        def commitTransaction(
          request: CommitTransactionRequest
        ): Kleisli[M, RdsDataClient, CommitTransactionResponse] =
          primitive(_.commitTransaction(request))

        def executeSql(
          request: ExecuteSqlRequest
        ): Kleisli[M, RdsDataClient, ExecuteSqlResponse] =
          primitive(_.executeSql(request))

        def executeStatement(
          request: ExecuteStatementRequest
        ): Kleisli[M, RdsDataClient, ExecuteStatementResponse] =
          primitive(_.executeStatement(request))

        def rollbackTransaction(
          request: RollbackTransactionRequest
        ): Kleisli[M, RdsDataClient, RollbackTransactionResponse] =
          primitive(_.rollbackTransaction(request))

        def primitive[A](
          f: RdsDataClient => A
        ): Kleisli[M, RdsDataClient, A]
      }
    }

    trait Visitor[F[_]] extends (RdsDataOp ~> F) {
      final def apply[A](op: RdsDataOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchExecuteStatement(
        request: BatchExecuteStatementRequest
      ): F[BatchExecuteStatementResponse]

      def beginTransaction(
        request: BeginTransactionRequest
      ): F[BeginTransactionResponse]

      def commitTransaction(
        request: CommitTransactionRequest
      ): F[CommitTransactionResponse]

      def executeSql(
        request: ExecuteSqlRequest
      ): F[ExecuteSqlResponse]

      def executeStatement(
        request: ExecuteStatementRequest
      ): F[ExecuteStatementResponse]

      def rollbackTransaction(
        request: RollbackTransactionRequest
      ): F[RollbackTransactionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends RdsDataOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchExecuteStatementOp(
      request: BatchExecuteStatementRequest
    ) extends RdsDataOp[BatchExecuteStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchExecuteStatementResponse] =
        visitor.batchExecuteStatement(request)
    }

    final case class BeginTransactionOp(
      request: BeginTransactionRequest
    ) extends RdsDataOp[BeginTransactionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BeginTransactionResponse] =
        visitor.beginTransaction(request)
    }

    final case class CommitTransactionOp(
      request: CommitTransactionRequest
    ) extends RdsDataOp[CommitTransactionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CommitTransactionResponse] =
        visitor.commitTransaction(request)
    }

    final case class ExecuteSqlOp(
      request: ExecuteSqlRequest
    ) extends RdsDataOp[ExecuteSqlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteSqlResponse] =
        visitor.executeSql(request)
    }

    final case class ExecuteStatementOp(
      request: ExecuteStatementRequest
    ) extends RdsDataOp[ExecuteStatementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteStatementResponse] =
        visitor.executeStatement(request)
    }

    final case class RollbackTransactionOp(
      request: RollbackTransactionRequest
    ) extends RdsDataOp[RollbackTransactionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RollbackTransactionResponse] =
        visitor.rollbackTransaction(request)
    }
  }

  import RdsDataOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[RdsDataOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchExecuteStatement(
    request: BatchExecuteStatementRequest
  ): RdsDataIO[BatchExecuteStatementResponse] =
    FF.liftF(BatchExecuteStatementOp(request))

  def beginTransaction(
    request: BeginTransactionRequest
  ): RdsDataIO[BeginTransactionResponse] =
    FF.liftF(BeginTransactionOp(request))

  def commitTransaction(
    request: CommitTransactionRequest
  ): RdsDataIO[CommitTransactionResponse] =
    FF.liftF(CommitTransactionOp(request))

  def executeSql(
    request: ExecuteSqlRequest
  ): RdsDataIO[ExecuteSqlResponse] =
    FF.liftF(ExecuteSqlOp(request))

  def executeStatement(
    request: ExecuteStatementRequest
  ): RdsDataIO[ExecuteStatementResponse] =
    FF.liftF(ExecuteStatementOp(request))

  def rollbackTransaction(
    request: RollbackTransactionRequest
  ): RdsDataIO[RollbackTransactionResponse] =
    FF.liftF(RollbackTransactionOp(request))
}
