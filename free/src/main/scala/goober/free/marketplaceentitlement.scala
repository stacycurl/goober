package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.marketplaceentitlement.MarketplaceEntitlementClient
import software.amazon.awssdk.services.marketplaceentitlement.model._


object marketplaceentitlement { module =>

  // Free monad over MarketplaceEntitlementOp
  type MarketplaceEntitlementIO[A] = FF[MarketplaceEntitlementOp, A]

  sealed trait MarketplaceEntitlementOp[A] {
    def visit[F[_]](visitor: MarketplaceEntitlementOp.Visitor[F]): F[A]
  }

  object MarketplaceEntitlementOp {
    // Given a MarketplaceEntitlementClient we can embed a MarketplaceEntitlementIO program in any algebra that understands embedding.
    implicit val MarketplaceEntitlementOpEmbeddable: Embeddable[MarketplaceEntitlementOp, MarketplaceEntitlementClient] = new Embeddable[MarketplaceEntitlementOp, MarketplaceEntitlementClient] {
      def embed[A](client: MarketplaceEntitlementClient, io: MarketplaceEntitlementIO[A]): Embedded[A] = Embedded.MarketplaceEntitlement(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MarketplaceEntitlementOp.Visitor[Kleisli[M, MarketplaceEntitlementClient, *]] {
        def getEntitlements(
          request: GetEntitlementsRequest
        ): Kleisli[M, MarketplaceEntitlementClient, GetEntitlementsResponse] =
          primitive(_.getEntitlements(request))

        def primitive[A](
          f: MarketplaceEntitlementClient => A
        ): Kleisli[M, MarketplaceEntitlementClient, A]
      }
    }

    trait Visitor[F[_]] extends (MarketplaceEntitlementOp ~> F) {
      final def apply[A](op: MarketplaceEntitlementOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def getEntitlements(
        request: GetEntitlementsRequest
      ): F[GetEntitlementsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MarketplaceEntitlementOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GetEntitlementsOp(
      request: GetEntitlementsRequest
    ) extends MarketplaceEntitlementOp[GetEntitlementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEntitlementsResponse] =
        visitor.getEntitlements(request)
    }
  }

  import MarketplaceEntitlementOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MarketplaceEntitlementOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def getEntitlements(
    request: GetEntitlementsRequest
  ): MarketplaceEntitlementIO[GetEntitlementsResponse] =
    FF.liftF(GetEntitlementsOp(request))
}
