package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.marketplacecommerceanalytics.MarketplaceCommerceAnalyticsClient
import software.amazon.awssdk.services.marketplacecommerceanalytics.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object marketplacecommerceanalytics { module =>

  // Free monad over MarketplaceCommerceAnalyticsOp
  type MarketplaceCommerceAnalyticsIO[A] = FF[MarketplaceCommerceAnalyticsOp, A]

  sealed trait MarketplaceCommerceAnalyticsOp[A] {
    def visit[F[_]](visitor: MarketplaceCommerceAnalyticsOp.Visitor[F]): F[A]
  }

  object MarketplaceCommerceAnalyticsOp {
    // Given a MarketplaceCommerceAnalyticsClient we can embed a MarketplaceCommerceAnalyticsIO program in any algebra that understands embedding.
    implicit val MarketplaceCommerceAnalyticsOpEmbeddable: Embeddable[MarketplaceCommerceAnalyticsOp, MarketplaceCommerceAnalyticsClient] = new Embeddable[MarketplaceCommerceAnalyticsOp, MarketplaceCommerceAnalyticsClient] {
      def embed[A](client: MarketplaceCommerceAnalyticsClient, io: MarketplaceCommerceAnalyticsIO[A]): Embedded[A] = Embedded.MarketplaceCommerceAnalytics(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MarketplaceCommerceAnalyticsOp.Visitor[Kleisli[M, MarketplaceCommerceAnalyticsClient, *]] {
        def generateDataSet(
          request: GenerateDataSetRequest
        ): Kleisli[M, MarketplaceCommerceAnalyticsClient, GenerateDataSetResponse] =
          primitive(_.generateDataSet(request))

        def startSupportDataExport(
          request: StartSupportDataExportRequest
        ): Kleisli[M, MarketplaceCommerceAnalyticsClient, StartSupportDataExportResponse] =
          primitive(_.startSupportDataExport(request))

        def primitive[A](
          f: MarketplaceCommerceAnalyticsClient => A
        ): Kleisli[M, MarketplaceCommerceAnalyticsClient, A]
      }
    }

    trait Visitor[F[_]] extends (MarketplaceCommerceAnalyticsOp ~> F) {
      final def apply[A](op: MarketplaceCommerceAnalyticsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def generateDataSet(
        request: GenerateDataSetRequest
      ): F[GenerateDataSetResponse]

      def startSupportDataExport(
        request: StartSupportDataExportRequest
      ): F[StartSupportDataExportResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MarketplaceCommerceAnalyticsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GenerateDataSetOp(
      request: GenerateDataSetRequest
    ) extends MarketplaceCommerceAnalyticsOp[GenerateDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateDataSetResponse] =
        visitor.generateDataSet(request)
    }

    final case class StartSupportDataExportOp(
      request: StartSupportDataExportRequest
    ) extends MarketplaceCommerceAnalyticsOp[StartSupportDataExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSupportDataExportResponse] =
        visitor.startSupportDataExport(request)
    }
  }

  import MarketplaceCommerceAnalyticsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MarketplaceCommerceAnalyticsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def generateDataSet(
    request: GenerateDataSetRequest
  ): MarketplaceCommerceAnalyticsIO[GenerateDataSetResponse] =
    FF.liftF(GenerateDataSetOp(request))

  def startSupportDataExport(
    request: StartSupportDataExportRequest
  ): MarketplaceCommerceAnalyticsIO[StartSupportDataExportResponse] =
    FF.liftF(StartSupportDataExportOp(request))
}
