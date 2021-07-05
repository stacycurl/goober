package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.forecastquery.ForecastqueryClient
import software.amazon.awssdk.services.forecastquery.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object forecastquery { module =>

  // Free monad over ForecastqueryOp
  type ForecastqueryIO[A] = FF[ForecastqueryOp, A]

  sealed trait ForecastqueryOp[A] {
    def visit[F[_]](visitor: ForecastqueryOp.Visitor[F]): F[A]
  }

  object ForecastqueryOp {
    // Given a ForecastqueryClient we can embed a ForecastqueryIO program in any algebra that understands embedding.
    implicit val ForecastqueryOpEmbeddable: Embeddable[ForecastqueryOp, ForecastqueryClient] = new Embeddable[ForecastqueryOp, ForecastqueryClient] {
      def embed[A](client: ForecastqueryClient, io: ForecastqueryIO[A]): Embedded[A] = Embedded.Forecastquery(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ForecastqueryOp.Visitor[Kleisli[M, ForecastqueryClient, *]] {
        def queryForecast(
          request: QueryForecastRequest
        ): Kleisli[M, ForecastqueryClient, QueryForecastResponse] =
          primitive(_.queryForecast(request))

        def primitive[A](
          f: ForecastqueryClient => A
        ): Kleisli[M, ForecastqueryClient, A]
      }
    }

    trait Visitor[F[_]] extends (ForecastqueryOp ~> F) {
      final def apply[A](op: ForecastqueryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def queryForecast(
        request: QueryForecastRequest
      ): F[QueryForecastResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ForecastqueryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class QueryForecastOp(
      request: QueryForecastRequest
    ) extends ForecastqueryOp[QueryForecastResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[QueryForecastResponse] =
        visitor.queryForecast(request)
    }
  }

  import ForecastqueryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ForecastqueryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def queryForecast(
    request: QueryForecastRequest
  ): ForecastqueryIO[QueryForecastResponse] =
    FF.liftF(QueryForecastOp(request))
}
