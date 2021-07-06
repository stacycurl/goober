package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.pi.PiClient
import software.amazon.awssdk.services.pi.model._


object pi { module =>

  // Free monad over PiOp
  type PiIO[A] = FF[PiOp, A]

  sealed trait PiOp[A] {
    def visit[F[_]](visitor: PiOp.Visitor[F]): F[A]
  }

  object PiOp {
    // Given a PiClient we can embed a PiIO program in any algebra that understands embedding.
    implicit val PiOpEmbeddable: Embeddable[PiOp, PiClient] = new Embeddable[PiOp, PiClient] {
      def embed[A](client: PiClient, io: PiIO[A]): Embedded[A] = Embedded.Pi(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PiOp.Visitor[Kleisli[M, PiClient, *]] {
        def describeDimensionKeys(
          request: DescribeDimensionKeysRequest
        ): Kleisli[M, PiClient, DescribeDimensionKeysResponse] =
          primitive(_.describeDimensionKeys(request))

        def getDimensionKeyDetails(
          request: GetDimensionKeyDetailsRequest
        ): Kleisli[M, PiClient, GetDimensionKeyDetailsResponse] =
          primitive(_.getDimensionKeyDetails(request))

        def getResourceMetrics(
          request: GetResourceMetricsRequest
        ): Kleisli[M, PiClient, GetResourceMetricsResponse] =
          primitive(_.getResourceMetrics(request))

        def primitive[A](
          f: PiClient => A
        ): Kleisli[M, PiClient, A]
      }
    }

    trait Visitor[F[_]] extends (PiOp ~> F) {
      final def apply[A](op: PiOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeDimensionKeys(
        request: DescribeDimensionKeysRequest
      ): F[DescribeDimensionKeysResponse]

      def getDimensionKeyDetails(
        request: GetDimensionKeyDetailsRequest
      ): F[GetDimensionKeyDetailsResponse]

      def getResourceMetrics(
        request: GetResourceMetricsRequest
      ): F[GetResourceMetricsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PiOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeDimensionKeysOp(
      request: DescribeDimensionKeysRequest
    ) extends PiOp[DescribeDimensionKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDimensionKeysResponse] =
        visitor.describeDimensionKeys(request)
    }

    final case class GetDimensionKeyDetailsOp(
      request: GetDimensionKeyDetailsRequest
    ) extends PiOp[GetDimensionKeyDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDimensionKeyDetailsResponse] =
        visitor.getDimensionKeyDetails(request)
    }

    final case class GetResourceMetricsOp(
      request: GetResourceMetricsRequest
    ) extends PiOp[GetResourceMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceMetricsResponse] =
        visitor.getResourceMetrics(request)
    }
  }

  import PiOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PiOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeDimensionKeys(
    request: DescribeDimensionKeysRequest
  ): PiIO[DescribeDimensionKeysResponse] =
    FF.liftF(DescribeDimensionKeysOp(request))

  def getDimensionKeyDetails(
    request: GetDimensionKeyDetailsRequest
  ): PiIO[GetDimensionKeyDetailsResponse] =
    FF.liftF(GetDimensionKeyDetailsOp(request))

  def getResourceMetrics(
    request: GetResourceMetricsRequest
  ): PiIO[GetResourceMetricsResponse] =
    FF.liftF(GetResourceMetricsOp(request))
}
