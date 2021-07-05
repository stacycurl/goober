package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.marketplacemetering.MarketplaceMeteringClient
import software.amazon.awssdk.services.marketplacemetering.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object marketplacemetering { module =>

  // Free monad over MarketplaceMeteringOp
  type MarketplaceMeteringIO[A] = FF[MarketplaceMeteringOp, A]

  sealed trait MarketplaceMeteringOp[A] {
    def visit[F[_]](visitor: MarketplaceMeteringOp.Visitor[F]): F[A]
  }

  object MarketplaceMeteringOp {
    // Given a MarketplaceMeteringClient we can embed a MarketplaceMeteringIO program in any algebra that understands embedding.
    implicit val MarketplaceMeteringOpEmbeddable: Embeddable[MarketplaceMeteringOp, MarketplaceMeteringClient] = new Embeddable[MarketplaceMeteringOp, MarketplaceMeteringClient] {
      def embed[A](client: MarketplaceMeteringClient, io: MarketplaceMeteringIO[A]): Embedded[A] = Embedded.MarketplaceMetering(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MarketplaceMeteringOp.Visitor[Kleisli[M, MarketplaceMeteringClient, *]] {
        def batchMeterUsage(
          request: BatchMeterUsageRequest
        ): Kleisli[M, MarketplaceMeteringClient, BatchMeterUsageResponse] =
          primitive(_.batchMeterUsage(request))

        def meterUsage(
          request: MeterUsageRequest
        ): Kleisli[M, MarketplaceMeteringClient, MeterUsageResponse] =
          primitive(_.meterUsage(request))

        def registerUsage(
          request: RegisterUsageRequest
        ): Kleisli[M, MarketplaceMeteringClient, RegisterUsageResponse] =
          primitive(_.registerUsage(request))

        def resolveCustomer(
          request: ResolveCustomerRequest
        ): Kleisli[M, MarketplaceMeteringClient, ResolveCustomerResponse] =
          primitive(_.resolveCustomer(request))

        def primitive[A](
          f: MarketplaceMeteringClient => A
        ): Kleisli[M, MarketplaceMeteringClient, A]
      }
    }

    trait Visitor[F[_]] extends (MarketplaceMeteringOp ~> F) {
      final def apply[A](op: MarketplaceMeteringOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchMeterUsage(
        request: BatchMeterUsageRequest
      ): F[BatchMeterUsageResponse]

      def meterUsage(
        request: MeterUsageRequest
      ): F[MeterUsageResponse]

      def registerUsage(
        request: RegisterUsageRequest
      ): F[RegisterUsageResponse]

      def resolveCustomer(
        request: ResolveCustomerRequest
      ): F[ResolveCustomerResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MarketplaceMeteringOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchMeterUsageOp(
      request: BatchMeterUsageRequest
    ) extends MarketplaceMeteringOp[BatchMeterUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchMeterUsageResponse] =
        visitor.batchMeterUsage(request)
    }

    final case class MeterUsageOp(
      request: MeterUsageRequest
    ) extends MarketplaceMeteringOp[MeterUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MeterUsageResponse] =
        visitor.meterUsage(request)
    }

    final case class RegisterUsageOp(
      request: RegisterUsageRequest
    ) extends MarketplaceMeteringOp[RegisterUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterUsageResponse] =
        visitor.registerUsage(request)
    }

    final case class ResolveCustomerOp(
      request: ResolveCustomerRequest
    ) extends MarketplaceMeteringOp[ResolveCustomerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResolveCustomerResponse] =
        visitor.resolveCustomer(request)
    }
  }

  import MarketplaceMeteringOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MarketplaceMeteringOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchMeterUsage(
    request: BatchMeterUsageRequest
  ): MarketplaceMeteringIO[BatchMeterUsageResponse] =
    FF.liftF(BatchMeterUsageOp(request))

  def meterUsage(
    request: MeterUsageRequest
  ): MarketplaceMeteringIO[MeterUsageResponse] =
    FF.liftF(MeterUsageOp(request))

  def registerUsage(
    request: RegisterUsageRequest
  ): MarketplaceMeteringIO[RegisterUsageResponse] =
    FF.liftF(RegisterUsageOp(request))

  def resolveCustomer(
    request: ResolveCustomerRequest
  ): MarketplaceMeteringIO[ResolveCustomerResponse] =
    FF.liftF(ResolveCustomerOp(request))
}
