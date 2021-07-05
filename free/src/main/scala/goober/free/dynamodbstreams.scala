package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient
import software.amazon.awssdk.services.dynamodb.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object dynamodbstreams { module =>

  // Free monad over DynamoDbStreamsOp
  type DynamoDbStreamsIO[A] = FF[DynamoDbStreamsOp, A]

  sealed trait DynamoDbStreamsOp[A] {
    def visit[F[_]](visitor: DynamoDbStreamsOp.Visitor[F]): F[A]
  }

  object DynamoDbStreamsOp {
    // Given a DynamoDbStreamsClient we can embed a DynamoDbStreamsIO program in any algebra that understands embedding.
    implicit val DynamoDbStreamsOpEmbeddable: Embeddable[DynamoDbStreamsOp, DynamoDbStreamsClient] = new Embeddable[DynamoDbStreamsOp, DynamoDbStreamsClient] {
      def embed[A](client: DynamoDbStreamsClient, io: DynamoDbStreamsIO[A]): Embedded[A] = Embedded.DynamoDbStreams(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DynamoDbStreamsOp.Visitor[Kleisli[M, DynamoDbStreamsClient, *]] {
        def describeStream(
          request: DescribeStreamRequest
        ): Kleisli[M, DynamoDbStreamsClient, DescribeStreamResponse] =
          primitive(_.describeStream(request))

        def getRecords(
          request: GetRecordsRequest
        ): Kleisli[M, DynamoDbStreamsClient, GetRecordsResponse] =
          primitive(_.getRecords(request))

        def getShardIterator(
          request: GetShardIteratorRequest
        ): Kleisli[M, DynamoDbStreamsClient, GetShardIteratorResponse] =
          primitive(_.getShardIterator(request))

        def listStreams(
          request: ListStreamsRequest
        ): Kleisli[M, DynamoDbStreamsClient, ListStreamsResponse] =
          primitive(_.listStreams(request))

        def primitive[A](
          f: DynamoDbStreamsClient => A
        ): Kleisli[M, DynamoDbStreamsClient, A]
      }
    }

    trait Visitor[F[_]] extends (DynamoDbStreamsOp ~> F) {
      final def apply[A](op: DynamoDbStreamsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeStream(
        request: DescribeStreamRequest
      ): F[DescribeStreamResponse]

      def getRecords(
        request: GetRecordsRequest
      ): F[GetRecordsResponse]

      def getShardIterator(
        request: GetShardIteratorRequest
      ): F[GetShardIteratorResponse]

      def listStreams(
        request: ListStreamsRequest
      ): F[ListStreamsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DynamoDbStreamsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeStreamOp(
      request: DescribeStreamRequest
    ) extends DynamoDbStreamsOp[DescribeStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStreamResponse] =
        visitor.describeStream(request)
    }

    final case class GetRecordsOp(
      request: GetRecordsRequest
    ) extends DynamoDbStreamsOp[GetRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecordsResponse] =
        visitor.getRecords(request)
    }

    final case class GetShardIteratorOp(
      request: GetShardIteratorRequest
    ) extends DynamoDbStreamsOp[GetShardIteratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetShardIteratorResponse] =
        visitor.getShardIterator(request)
    }

    final case class ListStreamsOp(
      request: ListStreamsRequest
    ) extends DynamoDbStreamsOp[ListStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamsResponse] =
        visitor.listStreams(request)
    }
  }

  import DynamoDbStreamsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DynamoDbStreamsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeStream(
    request: DescribeStreamRequest
  ): DynamoDbStreamsIO[DescribeStreamResponse] =
    FF.liftF(DescribeStreamOp(request))

  def getRecords(
    request: GetRecordsRequest
  ): DynamoDbStreamsIO[GetRecordsResponse] =
    FF.liftF(GetRecordsOp(request))

  def getShardIterator(
    request: GetShardIteratorRequest
  ): DynamoDbStreamsIO[GetShardIteratorResponse] =
    FF.liftF(GetShardIteratorOp(request))

  def listStreams(
    request: ListStreamsRequest
  ): DynamoDbStreamsIO[ListStreamsResponse] =
    FF.liftF(ListStreamsOp(request))
}
