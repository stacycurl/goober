package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.pricing.PricingClient
import software.amazon.awssdk.services.pricing.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object pricing { module =>

  // Free monad over PricingOp
  type PricingIO[A] = FF[PricingOp, A]

  sealed trait PricingOp[A] {
    def visit[F[_]](visitor: PricingOp.Visitor[F]): F[A]
  }

  object PricingOp {
    // Given a PricingClient we can embed a PricingIO program in any algebra that understands embedding.
    implicit val PricingOpEmbeddable: Embeddable[PricingOp, PricingClient] = new Embeddable[PricingOp, PricingClient] {
      def embed[A](client: PricingClient, io: PricingIO[A]): Embedded[A] = Embedded.Pricing(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PricingOp.Visitor[Kleisli[M, PricingClient, *]] {
        def describeServices(
          request: DescribeServicesRequest
        ): Kleisli[M, PricingClient, DescribeServicesResponse] =
          primitive(_.describeServices(request))

        def getAttributeValues(
          request: GetAttributeValuesRequest
        ): Kleisli[M, PricingClient, GetAttributeValuesResponse] =
          primitive(_.getAttributeValues(request))

        def getProducts(
          request: GetProductsRequest
        ): Kleisli[M, PricingClient, GetProductsResponse] =
          primitive(_.getProducts(request))

        def primitive[A](
          f: PricingClient => A
        ): Kleisli[M, PricingClient, A]
      }
    }

    trait Visitor[F[_]] extends (PricingOp ~> F) {
      final def apply[A](op: PricingOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeServices(
        request: DescribeServicesRequest
      ): F[DescribeServicesResponse]

      def getAttributeValues(
        request: GetAttributeValuesRequest
      ): F[GetAttributeValuesResponse]

      def getProducts(
        request: GetProductsRequest
      ): F[GetProductsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PricingOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeServicesOp(
      request: DescribeServicesRequest
    ) extends PricingOp[DescribeServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServicesResponse] =
        visitor.describeServices(request)
    }

    final case class GetAttributeValuesOp(
      request: GetAttributeValuesRequest
    ) extends PricingOp[GetAttributeValuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAttributeValuesResponse] =
        visitor.getAttributeValues(request)
    }

    final case class GetProductsOp(
      request: GetProductsRequest
    ) extends PricingOp[GetProductsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProductsResponse] =
        visitor.getProducts(request)
    }
  }

  import PricingOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PricingOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeServices(
    request: DescribeServicesRequest
  ): PricingIO[DescribeServicesResponse] =
    FF.liftF(DescribeServicesOp(request))

  def getAttributeValues(
    request: GetAttributeValuesRequest
  ): PricingIO[GetAttributeValuesResponse] =
    FF.liftF(GetAttributeValuesOp(request))

  def getProducts(
    request: GetProductsRequest
  ): PricingIO[GetProductsResponse] =
    FF.liftF(GetProductsOp(request))
}
