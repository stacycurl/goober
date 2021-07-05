package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.personalizeruntime.PersonalizeRuntimeClient
import software.amazon.awssdk.services.personalizeruntime.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object personalizeruntime { module =>

  // Free monad over PersonalizeRuntimeOp
  type PersonalizeRuntimeIO[A] = FF[PersonalizeRuntimeOp, A]

  sealed trait PersonalizeRuntimeOp[A] {
    def visit[F[_]](visitor: PersonalizeRuntimeOp.Visitor[F]): F[A]
  }

  object PersonalizeRuntimeOp {
    // Given a PersonalizeRuntimeClient we can embed a PersonalizeRuntimeIO program in any algebra that understands embedding.
    implicit val PersonalizeRuntimeOpEmbeddable: Embeddable[PersonalizeRuntimeOp, PersonalizeRuntimeClient] = new Embeddable[PersonalizeRuntimeOp, PersonalizeRuntimeClient] {
      def embed[A](client: PersonalizeRuntimeClient, io: PersonalizeRuntimeIO[A]): Embedded[A] = Embedded.PersonalizeRuntime(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PersonalizeRuntimeOp.Visitor[Kleisli[M, PersonalizeRuntimeClient, *]] {
        def getPersonalizedRanking(
          request: GetPersonalizedRankingRequest
        ): Kleisli[M, PersonalizeRuntimeClient, GetPersonalizedRankingResponse] =
          primitive(_.getPersonalizedRanking(request))

        def getRecommendations(
          request: GetRecommendationsRequest
        ): Kleisli[M, PersonalizeRuntimeClient, GetRecommendationsResponse] =
          primitive(_.getRecommendations(request))

        def primitive[A](
          f: PersonalizeRuntimeClient => A
        ): Kleisli[M, PersonalizeRuntimeClient, A]
      }
    }

    trait Visitor[F[_]] extends (PersonalizeRuntimeOp ~> F) {
      final def apply[A](op: PersonalizeRuntimeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def getPersonalizedRanking(
        request: GetPersonalizedRankingRequest
      ): F[GetPersonalizedRankingResponse]

      def getRecommendations(
        request: GetRecommendationsRequest
      ): F[GetRecommendationsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PersonalizeRuntimeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class GetPersonalizedRankingOp(
      request: GetPersonalizedRankingRequest
    ) extends PersonalizeRuntimeOp[GetPersonalizedRankingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPersonalizedRankingResponse] =
        visitor.getPersonalizedRanking(request)
    }

    final case class GetRecommendationsOp(
      request: GetRecommendationsRequest
    ) extends PersonalizeRuntimeOp[GetRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecommendationsResponse] =
        visitor.getRecommendations(request)
    }
  }

  import PersonalizeRuntimeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PersonalizeRuntimeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def getPersonalizedRanking(
    request: GetPersonalizedRankingRequest
  ): PersonalizeRuntimeIO[GetPersonalizedRankingResponse] =
    FF.liftF(GetPersonalizedRankingOp(request))

  def getRecommendations(
    request: GetRecommendationsRequest
  ): PersonalizeRuntimeIO[GetRecommendationsResponse] =
    FF.liftF(GetRecommendationsOp(request))
}
