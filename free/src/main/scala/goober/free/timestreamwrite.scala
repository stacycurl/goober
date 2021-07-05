package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.timestreamwrite.TimestreamWriteClient
import software.amazon.awssdk.services.timestreamwrite.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object timestreamwrite { module =>

  // Free monad over TimestreamWriteOp
  type TimestreamWriteIO[A] = FF[TimestreamWriteOp, A]

  sealed trait TimestreamWriteOp[A] {
    def visit[F[_]](visitor: TimestreamWriteOp.Visitor[F]): F[A]
  }

  object TimestreamWriteOp {
    // Given a TimestreamWriteClient we can embed a TimestreamWriteIO program in any algebra that understands embedding.
    implicit val TimestreamWriteOpEmbeddable: Embeddable[TimestreamWriteOp, TimestreamWriteClient] = new Embeddable[TimestreamWriteOp, TimestreamWriteClient] {
      def embed[A](client: TimestreamWriteClient, io: TimestreamWriteIO[A]): Embedded[A] = Embedded.TimestreamWrite(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends TimestreamWriteOp.Visitor[Kleisli[M, TimestreamWriteClient, *]] {
        def createDatabase(
          request: CreateDatabaseRequest
        ): Kleisli[M, TimestreamWriteClient, CreateDatabaseResponse] =
          primitive(_.createDatabase(request))

        def createTable(
          request: CreateTableRequest
        ): Kleisli[M, TimestreamWriteClient, CreateTableResponse] =
          primitive(_.createTable(request))

        def deleteDatabase(
          request: DeleteDatabaseRequest
        ): Kleisli[M, TimestreamWriteClient, DeleteDatabaseResponse] =
          primitive(_.deleteDatabase(request))

        def deleteTable(
          request: DeleteTableRequest
        ): Kleisli[M, TimestreamWriteClient, DeleteTableResponse] =
          primitive(_.deleteTable(request))

        def describeDatabase(
          request: DescribeDatabaseRequest
        ): Kleisli[M, TimestreamWriteClient, DescribeDatabaseResponse] =
          primitive(_.describeDatabase(request))

        def describeEndpoints(
          request: DescribeEndpointsRequest
        ): Kleisli[M, TimestreamWriteClient, DescribeEndpointsResponse] =
          primitive(_.describeEndpoints(request))

        def describeTable(
          request: DescribeTableRequest
        ): Kleisli[M, TimestreamWriteClient, DescribeTableResponse] =
          primitive(_.describeTable(request))

        def listDatabases(
          request: ListDatabasesRequest
        ): Kleisli[M, TimestreamWriteClient, ListDatabasesResponse] =
          primitive(_.listDatabases(request))

        def listTables(
          request: ListTablesRequest
        ): Kleisli[M, TimestreamWriteClient, ListTablesResponse] =
          primitive(_.listTables(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, TimestreamWriteClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, TimestreamWriteClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, TimestreamWriteClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDatabase(
          request: UpdateDatabaseRequest
        ): Kleisli[M, TimestreamWriteClient, UpdateDatabaseResponse] =
          primitive(_.updateDatabase(request))

        def updateTable(
          request: UpdateTableRequest
        ): Kleisli[M, TimestreamWriteClient, UpdateTableResponse] =
          primitive(_.updateTable(request))

        def writeRecords(
          request: WriteRecordsRequest
        ): Kleisli[M, TimestreamWriteClient, WriteRecordsResponse] =
          primitive(_.writeRecords(request))

        def primitive[A](
          f: TimestreamWriteClient => A
        ): Kleisli[M, TimestreamWriteClient, A]
      }
    }

    trait Visitor[F[_]] extends (TimestreamWriteOp ~> F) {
      final def apply[A](op: TimestreamWriteOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createDatabase(
        request: CreateDatabaseRequest
      ): F[CreateDatabaseResponse]

      def createTable(
        request: CreateTableRequest
      ): F[CreateTableResponse]

      def deleteDatabase(
        request: DeleteDatabaseRequest
      ): F[DeleteDatabaseResponse]

      def deleteTable(
        request: DeleteTableRequest
      ): F[DeleteTableResponse]

      def describeDatabase(
        request: DescribeDatabaseRequest
      ): F[DescribeDatabaseResponse]

      def describeEndpoints(
        request: DescribeEndpointsRequest
      ): F[DescribeEndpointsResponse]

      def describeTable(
        request: DescribeTableRequest
      ): F[DescribeTableResponse]

      def listDatabases(
        request: ListDatabasesRequest
      ): F[ListDatabasesResponse]

      def listTables(
        request: ListTablesRequest
      ): F[ListTablesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDatabase(
        request: UpdateDatabaseRequest
      ): F[UpdateDatabaseResponse]

      def updateTable(
        request: UpdateTableRequest
      ): F[UpdateTableResponse]

      def writeRecords(
        request: WriteRecordsRequest
      ): F[WriteRecordsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends TimestreamWriteOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateDatabaseOp(
      request: CreateDatabaseRequest
    ) extends TimestreamWriteOp[CreateDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatabaseResponse] =
        visitor.createDatabase(request)
    }

    final case class CreateTableOp(
      request: CreateTableRequest
    ) extends TimestreamWriteOp[CreateTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTableResponse] =
        visitor.createTable(request)
    }

    final case class DeleteDatabaseOp(
      request: DeleteDatabaseRequest
    ) extends TimestreamWriteOp[DeleteDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatabaseResponse] =
        visitor.deleteDatabase(request)
    }

    final case class DeleteTableOp(
      request: DeleteTableRequest
    ) extends TimestreamWriteOp[DeleteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTableResponse] =
        visitor.deleteTable(request)
    }

    final case class DescribeDatabaseOp(
      request: DescribeDatabaseRequest
    ) extends TimestreamWriteOp[DescribeDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatabaseResponse] =
        visitor.describeDatabase(request)
    }

    final case class DescribeEndpointsOp(
      request: DescribeEndpointsRequest
    ) extends TimestreamWriteOp[DescribeEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointsResponse] =
        visitor.describeEndpoints(request)
    }

    final case class DescribeTableOp(
      request: DescribeTableRequest
    ) extends TimestreamWriteOp[DescribeTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTableResponse] =
        visitor.describeTable(request)
    }

    final case class ListDatabasesOp(
      request: ListDatabasesRequest
    ) extends TimestreamWriteOp[ListDatabasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatabasesResponse] =
        visitor.listDatabases(request)
    }

    final case class ListTablesOp(
      request: ListTablesRequest
    ) extends TimestreamWriteOp[ListTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTablesResponse] =
        visitor.listTables(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends TimestreamWriteOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends TimestreamWriteOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends TimestreamWriteOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDatabaseOp(
      request: UpdateDatabaseRequest
    ) extends TimestreamWriteOp[UpdateDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDatabaseResponse] =
        visitor.updateDatabase(request)
    }

    final case class UpdateTableOp(
      request: UpdateTableRequest
    ) extends TimestreamWriteOp[UpdateTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTableResponse] =
        visitor.updateTable(request)
    }

    final case class WriteRecordsOp(
      request: WriteRecordsRequest
    ) extends TimestreamWriteOp[WriteRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[WriteRecordsResponse] =
        visitor.writeRecords(request)
    }
  }

  import TimestreamWriteOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[TimestreamWriteOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createDatabase(
    request: CreateDatabaseRequest
  ): TimestreamWriteIO[CreateDatabaseResponse] =
    FF.liftF(CreateDatabaseOp(request))

  def createTable(
    request: CreateTableRequest
  ): TimestreamWriteIO[CreateTableResponse] =
    FF.liftF(CreateTableOp(request))

  def deleteDatabase(
    request: DeleteDatabaseRequest
  ): TimestreamWriteIO[DeleteDatabaseResponse] =
    FF.liftF(DeleteDatabaseOp(request))

  def deleteTable(
    request: DeleteTableRequest
  ): TimestreamWriteIO[DeleteTableResponse] =
    FF.liftF(DeleteTableOp(request))

  def describeDatabase(
    request: DescribeDatabaseRequest
  ): TimestreamWriteIO[DescribeDatabaseResponse] =
    FF.liftF(DescribeDatabaseOp(request))

  def describeEndpoints(
    request: DescribeEndpointsRequest
  ): TimestreamWriteIO[DescribeEndpointsResponse] =
    FF.liftF(DescribeEndpointsOp(request))

  def describeTable(
    request: DescribeTableRequest
  ): TimestreamWriteIO[DescribeTableResponse] =
    FF.liftF(DescribeTableOp(request))

  def listDatabases(
    request: ListDatabasesRequest
  ): TimestreamWriteIO[ListDatabasesResponse] =
    FF.liftF(ListDatabasesOp(request))

  def listTables(
    request: ListTablesRequest
  ): TimestreamWriteIO[ListTablesResponse] =
    FF.liftF(ListTablesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): TimestreamWriteIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): TimestreamWriteIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): TimestreamWriteIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDatabase(
    request: UpdateDatabaseRequest
  ): TimestreamWriteIO[UpdateDatabaseResponse] =
    FF.liftF(UpdateDatabaseOp(request))

  def updateTable(
    request: UpdateTableRequest
  ): TimestreamWriteIO[UpdateTableResponse] =
    FF.liftF(UpdateTableOp(request))

  def writeRecords(
    request: WriteRecordsRequest
  ): TimestreamWriteIO[WriteRecordsResponse] =
    FF.liftF(WriteRecordsOp(request))
}
