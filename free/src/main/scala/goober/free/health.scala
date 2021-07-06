package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.health.HealthClient
import software.amazon.awssdk.services.health.model._


object health { module =>

  // Free monad over HealthOp
  type HealthIO[A] = FF[HealthOp, A]

  sealed trait HealthOp[A] {
    def visit[F[_]](visitor: HealthOp.Visitor[F]): F[A]
  }

  object HealthOp {
    // Given a HealthClient we can embed a HealthIO program in any algebra that understands embedding.
    implicit val HealthOpEmbeddable: Embeddable[HealthOp, HealthClient] = new Embeddable[HealthOp, HealthClient] {
      def embed[A](client: HealthClient, io: HealthIO[A]): Embedded[A] = Embedded.Health(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends HealthOp.Visitor[Kleisli[M, HealthClient, *]] {
        def describeAffectedAccountsForOrganization(
          request: DescribeAffectedAccountsForOrganizationRequest
        ): Kleisli[M, HealthClient, DescribeAffectedAccountsForOrganizationResponse] =
          primitive(_.describeAffectedAccountsForOrganization(request))

        def describeAffectedEntities(
          request: DescribeAffectedEntitiesRequest
        ): Kleisli[M, HealthClient, DescribeAffectedEntitiesResponse] =
          primitive(_.describeAffectedEntities(request))

        def describeAffectedEntitiesForOrganization(
          request: DescribeAffectedEntitiesForOrganizationRequest
        ): Kleisli[M, HealthClient, DescribeAffectedEntitiesForOrganizationResponse] =
          primitive(_.describeAffectedEntitiesForOrganization(request))

        def describeEntityAggregates(
          request: DescribeEntityAggregatesRequest
        ): Kleisli[M, HealthClient, DescribeEntityAggregatesResponse] =
          primitive(_.describeEntityAggregates(request))

        def describeEventAggregates(
          request: DescribeEventAggregatesRequest
        ): Kleisli[M, HealthClient, DescribeEventAggregatesResponse] =
          primitive(_.describeEventAggregates(request))

        def describeEventDetails(
          request: DescribeEventDetailsRequest
        ): Kleisli[M, HealthClient, DescribeEventDetailsResponse] =
          primitive(_.describeEventDetails(request))

        def describeEventDetailsForOrganization(
          request: DescribeEventDetailsForOrganizationRequest
        ): Kleisli[M, HealthClient, DescribeEventDetailsForOrganizationResponse] =
          primitive(_.describeEventDetailsForOrganization(request))

        def describeEventTypes(
          request: DescribeEventTypesRequest
        ): Kleisli[M, HealthClient, DescribeEventTypesResponse] =
          primitive(_.describeEventTypes(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, HealthClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeEventsForOrganization(
          request: DescribeEventsForOrganizationRequest
        ): Kleisli[M, HealthClient, DescribeEventsForOrganizationResponse] =
          primitive(_.describeEventsForOrganization(request))

        def describeHealthServiceStatusForOrganization(
          request: DescribeHealthServiceStatusForOrganizationRequest
        ): Kleisli[M, HealthClient, DescribeHealthServiceStatusForOrganizationResponse] =
          primitive(_.describeHealthServiceStatusForOrganization(request))

        def disableHealthServiceAccessForOrganization(
          request: DisableHealthServiceAccessForOrganizationRequest
        ): Kleisli[M, HealthClient, DisableHealthServiceAccessForOrganizationResponse] =
          primitive(_.disableHealthServiceAccessForOrganization(request))

        def enableHealthServiceAccessForOrganization(
          request: EnableHealthServiceAccessForOrganizationRequest
        ): Kleisli[M, HealthClient, EnableHealthServiceAccessForOrganizationResponse] =
          primitive(_.enableHealthServiceAccessForOrganization(request))

        def primitive[A](
          f: HealthClient => A
        ): Kleisli[M, HealthClient, A]
      }
    }

    trait Visitor[F[_]] extends (HealthOp ~> F) {
      final def apply[A](op: HealthOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeAffectedAccountsForOrganization(
        request: DescribeAffectedAccountsForOrganizationRequest
      ): F[DescribeAffectedAccountsForOrganizationResponse]

      def describeAffectedEntities(
        request: DescribeAffectedEntitiesRequest
      ): F[DescribeAffectedEntitiesResponse]

      def describeAffectedEntitiesForOrganization(
        request: DescribeAffectedEntitiesForOrganizationRequest
      ): F[DescribeAffectedEntitiesForOrganizationResponse]

      def describeEntityAggregates(
        request: DescribeEntityAggregatesRequest
      ): F[DescribeEntityAggregatesResponse]

      def describeEventAggregates(
        request: DescribeEventAggregatesRequest
      ): F[DescribeEventAggregatesResponse]

      def describeEventDetails(
        request: DescribeEventDetailsRequest
      ): F[DescribeEventDetailsResponse]

      def describeEventDetailsForOrganization(
        request: DescribeEventDetailsForOrganizationRequest
      ): F[DescribeEventDetailsForOrganizationResponse]

      def describeEventTypes(
        request: DescribeEventTypesRequest
      ): F[DescribeEventTypesResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeEventsForOrganization(
        request: DescribeEventsForOrganizationRequest
      ): F[DescribeEventsForOrganizationResponse]

      def describeHealthServiceStatusForOrganization(
        request: DescribeHealthServiceStatusForOrganizationRequest
      ): F[DescribeHealthServiceStatusForOrganizationResponse]

      def disableHealthServiceAccessForOrganization(
        request: DisableHealthServiceAccessForOrganizationRequest
      ): F[DisableHealthServiceAccessForOrganizationResponse]

      def enableHealthServiceAccessForOrganization(
        request: EnableHealthServiceAccessForOrganizationRequest
      ): F[EnableHealthServiceAccessForOrganizationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends HealthOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeAffectedAccountsForOrganizationOp(
      request: DescribeAffectedAccountsForOrganizationRequest
    ) extends HealthOp[DescribeAffectedAccountsForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAffectedAccountsForOrganizationResponse] =
        visitor.describeAffectedAccountsForOrganization(request)
    }

    final case class DescribeAffectedEntitiesOp(
      request: DescribeAffectedEntitiesRequest
    ) extends HealthOp[DescribeAffectedEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAffectedEntitiesResponse] =
        visitor.describeAffectedEntities(request)
    }

    final case class DescribeAffectedEntitiesForOrganizationOp(
      request: DescribeAffectedEntitiesForOrganizationRequest
    ) extends HealthOp[DescribeAffectedEntitiesForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAffectedEntitiesForOrganizationResponse] =
        visitor.describeAffectedEntitiesForOrganization(request)
    }

    final case class DescribeEntityAggregatesOp(
      request: DescribeEntityAggregatesRequest
    ) extends HealthOp[DescribeEntityAggregatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEntityAggregatesResponse] =
        visitor.describeEntityAggregates(request)
    }

    final case class DescribeEventAggregatesOp(
      request: DescribeEventAggregatesRequest
    ) extends HealthOp[DescribeEventAggregatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventAggregatesResponse] =
        visitor.describeEventAggregates(request)
    }

    final case class DescribeEventDetailsOp(
      request: DescribeEventDetailsRequest
    ) extends HealthOp[DescribeEventDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventDetailsResponse] =
        visitor.describeEventDetails(request)
    }

    final case class DescribeEventDetailsForOrganizationOp(
      request: DescribeEventDetailsForOrganizationRequest
    ) extends HealthOp[DescribeEventDetailsForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventDetailsForOrganizationResponse] =
        visitor.describeEventDetailsForOrganization(request)
    }

    final case class DescribeEventTypesOp(
      request: DescribeEventTypesRequest
    ) extends HealthOp[DescribeEventTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventTypesResponse] =
        visitor.describeEventTypes(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends HealthOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeEventsForOrganizationOp(
      request: DescribeEventsForOrganizationRequest
    ) extends HealthOp[DescribeEventsForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsForOrganizationResponse] =
        visitor.describeEventsForOrganization(request)
    }

    final case class DescribeHealthServiceStatusForOrganizationOp(
      request: DescribeHealthServiceStatusForOrganizationRequest
    ) extends HealthOp[DescribeHealthServiceStatusForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHealthServiceStatusForOrganizationResponse] =
        visitor.describeHealthServiceStatusForOrganization(request)
    }

    final case class DisableHealthServiceAccessForOrganizationOp(
      request: DisableHealthServiceAccessForOrganizationRequest
    ) extends HealthOp[DisableHealthServiceAccessForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableHealthServiceAccessForOrganizationResponse] =
        visitor.disableHealthServiceAccessForOrganization(request)
    }

    final case class EnableHealthServiceAccessForOrganizationOp(
      request: EnableHealthServiceAccessForOrganizationRequest
    ) extends HealthOp[EnableHealthServiceAccessForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableHealthServiceAccessForOrganizationResponse] =
        visitor.enableHealthServiceAccessForOrganization(request)
    }
  }

  import HealthOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[HealthOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeAffectedAccountsForOrganization(
    request: DescribeAffectedAccountsForOrganizationRequest
  ): HealthIO[DescribeAffectedAccountsForOrganizationResponse] =
    FF.liftF(DescribeAffectedAccountsForOrganizationOp(request))

  def describeAffectedEntities(
    request: DescribeAffectedEntitiesRequest
  ): HealthIO[DescribeAffectedEntitiesResponse] =
    FF.liftF(DescribeAffectedEntitiesOp(request))

  def describeAffectedEntitiesForOrganization(
    request: DescribeAffectedEntitiesForOrganizationRequest
  ): HealthIO[DescribeAffectedEntitiesForOrganizationResponse] =
    FF.liftF(DescribeAffectedEntitiesForOrganizationOp(request))

  def describeEntityAggregates(
    request: DescribeEntityAggregatesRequest
  ): HealthIO[DescribeEntityAggregatesResponse] =
    FF.liftF(DescribeEntityAggregatesOp(request))

  def describeEventAggregates(
    request: DescribeEventAggregatesRequest
  ): HealthIO[DescribeEventAggregatesResponse] =
    FF.liftF(DescribeEventAggregatesOp(request))

  def describeEventDetails(
    request: DescribeEventDetailsRequest
  ): HealthIO[DescribeEventDetailsResponse] =
    FF.liftF(DescribeEventDetailsOp(request))

  def describeEventDetailsForOrganization(
    request: DescribeEventDetailsForOrganizationRequest
  ): HealthIO[DescribeEventDetailsForOrganizationResponse] =
    FF.liftF(DescribeEventDetailsForOrganizationOp(request))

  def describeEventTypes(
    request: DescribeEventTypesRequest
  ): HealthIO[DescribeEventTypesResponse] =
    FF.liftF(DescribeEventTypesOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): HealthIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeEventsForOrganization(
    request: DescribeEventsForOrganizationRequest
  ): HealthIO[DescribeEventsForOrganizationResponse] =
    FF.liftF(DescribeEventsForOrganizationOp(request))

  def describeHealthServiceStatusForOrganization(
    request: DescribeHealthServiceStatusForOrganizationRequest
  ): HealthIO[DescribeHealthServiceStatusForOrganizationResponse] =
    FF.liftF(DescribeHealthServiceStatusForOrganizationOp(request))

  def disableHealthServiceAccessForOrganization(
    request: DisableHealthServiceAccessForOrganizationRequest
  ): HealthIO[DisableHealthServiceAccessForOrganizationResponse] =
    FF.liftF(DisableHealthServiceAccessForOrganizationOp(request))

  def enableHealthServiceAccessForOrganization(
    request: EnableHealthServiceAccessForOrganizationRequest
  ): HealthIO[EnableHealthServiceAccessForOrganizationResponse] =
    FF.liftF(EnableHealthServiceAccessForOrganizationOp(request))
}
