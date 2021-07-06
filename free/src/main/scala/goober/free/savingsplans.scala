package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.savingsplans.SavingsplansClient
import software.amazon.awssdk.services.savingsplans.model._


object savingsplans { module =>

  // Free monad over SavingsplansOp
  type SavingsplansIO[A] = FF[SavingsplansOp, A]

  sealed trait SavingsplansOp[A] {
    def visit[F[_]](visitor: SavingsplansOp.Visitor[F]): F[A]
  }

  object SavingsplansOp {
    // Given a SavingsplansClient we can embed a SavingsplansIO program in any algebra that understands embedding.
    implicit val SavingsplansOpEmbeddable: Embeddable[SavingsplansOp, SavingsplansClient] = new Embeddable[SavingsplansOp, SavingsplansClient] {
      def embed[A](client: SavingsplansClient, io: SavingsplansIO[A]): Embedded[A] = Embedded.Savingsplans(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SavingsplansOp.Visitor[Kleisli[M, SavingsplansClient, *]] {
        def createSavingsPlan(
          request: CreateSavingsPlanRequest
        ): Kleisli[M, SavingsplansClient, CreateSavingsPlanResponse] =
          primitive(_.createSavingsPlan(request))

        def deleteQueuedSavingsPlan(
          request: DeleteQueuedSavingsPlanRequest
        ): Kleisli[M, SavingsplansClient, DeleteQueuedSavingsPlanResponse] =
          primitive(_.deleteQueuedSavingsPlan(request))

        def describeSavingsPlanRates(
          request: DescribeSavingsPlanRatesRequest
        ): Kleisli[M, SavingsplansClient, DescribeSavingsPlanRatesResponse] =
          primitive(_.describeSavingsPlanRates(request))

        def describeSavingsPlans(
          request: DescribeSavingsPlansRequest
        ): Kleisli[M, SavingsplansClient, DescribeSavingsPlansResponse] =
          primitive(_.describeSavingsPlans(request))

        def describeSavingsPlansOfferingRates(
          request: DescribeSavingsPlansOfferingRatesRequest
        ): Kleisli[M, SavingsplansClient, DescribeSavingsPlansOfferingRatesResponse] =
          primitive(_.describeSavingsPlansOfferingRates(request))

        def describeSavingsPlansOfferings(
          request: DescribeSavingsPlansOfferingsRequest
        ): Kleisli[M, SavingsplansClient, DescribeSavingsPlansOfferingsResponse] =
          primitive(_.describeSavingsPlansOfferings(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SavingsplansClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SavingsplansClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SavingsplansClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: SavingsplansClient => A
        ): Kleisli[M, SavingsplansClient, A]
      }
    }

    trait Visitor[F[_]] extends (SavingsplansOp ~> F) {
      final def apply[A](op: SavingsplansOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createSavingsPlan(
        request: CreateSavingsPlanRequest
      ): F[CreateSavingsPlanResponse]

      def deleteQueuedSavingsPlan(
        request: DeleteQueuedSavingsPlanRequest
      ): F[DeleteQueuedSavingsPlanResponse]

      def describeSavingsPlanRates(
        request: DescribeSavingsPlanRatesRequest
      ): F[DescribeSavingsPlanRatesResponse]

      def describeSavingsPlans(
        request: DescribeSavingsPlansRequest
      ): F[DescribeSavingsPlansResponse]

      def describeSavingsPlansOfferingRates(
        request: DescribeSavingsPlansOfferingRatesRequest
      ): F[DescribeSavingsPlansOfferingRatesResponse]

      def describeSavingsPlansOfferings(
        request: DescribeSavingsPlansOfferingsRequest
      ): F[DescribeSavingsPlansOfferingsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SavingsplansOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateSavingsPlanOp(
      request: CreateSavingsPlanRequest
    ) extends SavingsplansOp[CreateSavingsPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSavingsPlanResponse] =
        visitor.createSavingsPlan(request)
    }

    final case class DeleteQueuedSavingsPlanOp(
      request: DeleteQueuedSavingsPlanRequest
    ) extends SavingsplansOp[DeleteQueuedSavingsPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQueuedSavingsPlanResponse] =
        visitor.deleteQueuedSavingsPlan(request)
    }

    final case class DescribeSavingsPlanRatesOp(
      request: DescribeSavingsPlanRatesRequest
    ) extends SavingsplansOp[DescribeSavingsPlanRatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSavingsPlanRatesResponse] =
        visitor.describeSavingsPlanRates(request)
    }

    final case class DescribeSavingsPlansOp(
      request: DescribeSavingsPlansRequest
    ) extends SavingsplansOp[DescribeSavingsPlansResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSavingsPlansResponse] =
        visitor.describeSavingsPlans(request)
    }

    final case class DescribeSavingsPlansOfferingRatesOp(
      request: DescribeSavingsPlansOfferingRatesRequest
    ) extends SavingsplansOp[DescribeSavingsPlansOfferingRatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSavingsPlansOfferingRatesResponse] =
        visitor.describeSavingsPlansOfferingRates(request)
    }

    final case class DescribeSavingsPlansOfferingsOp(
      request: DescribeSavingsPlansOfferingsRequest
    ) extends SavingsplansOp[DescribeSavingsPlansOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSavingsPlansOfferingsResponse] =
        visitor.describeSavingsPlansOfferings(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SavingsplansOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SavingsplansOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SavingsplansOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import SavingsplansOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SavingsplansOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createSavingsPlan(
    request: CreateSavingsPlanRequest
  ): SavingsplansIO[CreateSavingsPlanResponse] =
    FF.liftF(CreateSavingsPlanOp(request))

  def deleteQueuedSavingsPlan(
    request: DeleteQueuedSavingsPlanRequest
  ): SavingsplansIO[DeleteQueuedSavingsPlanResponse] =
    FF.liftF(DeleteQueuedSavingsPlanOp(request))

  def describeSavingsPlanRates(
    request: DescribeSavingsPlanRatesRequest
  ): SavingsplansIO[DescribeSavingsPlanRatesResponse] =
    FF.liftF(DescribeSavingsPlanRatesOp(request))

  def describeSavingsPlans(
    request: DescribeSavingsPlansRequest
  ): SavingsplansIO[DescribeSavingsPlansResponse] =
    FF.liftF(DescribeSavingsPlansOp(request))

  def describeSavingsPlansOfferingRates(
    request: DescribeSavingsPlansOfferingRatesRequest
  ): SavingsplansIO[DescribeSavingsPlansOfferingRatesResponse] =
    FF.liftF(DescribeSavingsPlansOfferingRatesOp(request))

  def describeSavingsPlansOfferings(
    request: DescribeSavingsPlansOfferingsRequest
  ): SavingsplansIO[DescribeSavingsPlansOfferingsResponse] =
    FF.liftF(DescribeSavingsPlansOfferingsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SavingsplansIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SavingsplansIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SavingsplansIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
