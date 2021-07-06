package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.timestreamquery.TimestreamQueryClient
import software.amazon.awssdk.services.timestreamquery.model._


object timestreamquery { module =>

  // Free monad over TimestreamQueryOp
  type TimestreamQueryIO[A] = FF[TimestreamQueryOp, A]

  sealed trait TimestreamQueryOp[A] {
    def visit[F[_]](visitor: TimestreamQueryOp.Visitor[F]): F[A]
  }

  object TimestreamQueryOp {
    // Given a TimestreamQueryClient we can embed a TimestreamQueryIO program in any algebra that understands embedding.
    implicit val TimestreamQueryOpEmbeddable: Embeddable[TimestreamQueryOp, TimestreamQueryClient] = new Embeddable[TimestreamQueryOp, TimestreamQueryClient] {
      def embed[A](client: TimestreamQueryClient, io: TimestreamQueryIO[A]): Embedded[A] = Embedded.TimestreamQuery(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends TimestreamQueryOp.Visitor[Kleisli[M, TimestreamQueryClient, *]] {
        def cancelQuery(
          request: CancelQueryRequest
        ): Kleisli[M, TimestreamQueryClient, CancelQueryResponse] =
          primitive(_.cancelQuery(request))

        def describeEndpoints(
          request: DescribeEndpointsRequest
        ): Kleisli[M, TimestreamQueryClient, DescribeEndpointsResponse] =
          primitive(_.describeEndpoints(request))

        def query(
          request: QueryRequest
        ): Kleisli[M, TimestreamQueryClient, QueryResponse] =
          primitive(_.query(request))

        def primitive[A](
          f: TimestreamQueryClient => A
        ): Kleisli[M, TimestreamQueryClient, A]
      }
    }

    trait Visitor[F[_]] extends (TimestreamQueryOp ~> F) {
      final def apply[A](op: TimestreamQueryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelQuery(
        request: CancelQueryRequest
      ): F[CancelQueryResponse]

      def describeEndpoints(
        request: DescribeEndpointsRequest
      ): F[DescribeEndpointsResponse]

      def query(
        request: QueryRequest
      ): F[QueryResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends TimestreamQueryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelQueryOp(
      request: CancelQueryRequest
    ) extends TimestreamQueryOp[CancelQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelQueryResponse] =
        visitor.cancelQuery(request)
    }

    final case class DescribeEndpointsOp(
      request: DescribeEndpointsRequest
    ) extends TimestreamQueryOp[DescribeEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointsResponse] =
        visitor.describeEndpoints(request)
    }

    final case class QueryOp(
      request: QueryRequest
    ) extends TimestreamQueryOp[QueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[QueryResponse] =
        visitor.query(request)
    }
  }

  import TimestreamQueryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[TimestreamQueryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelQuery(
    request: CancelQueryRequest
  ): TimestreamQueryIO[CancelQueryResponse] =
    FF.liftF(CancelQueryOp(request))

  def describeEndpoints(
    request: DescribeEndpointsRequest
  ): TimestreamQueryIO[DescribeEndpointsResponse] =
    FF.liftF(DescribeEndpointsOp(request))

  def query(
    request: QueryRequest
  ): TimestreamQueryIO[QueryResponse] =
    FF.liftF(QueryOp(request))
}
