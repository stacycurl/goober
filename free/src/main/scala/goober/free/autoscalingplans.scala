package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.autoscalingplans.AutoScalingPlansClient
import software.amazon.awssdk.services.autoscalingplans.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object autoscalingplans { module =>

  // Free monad over AutoScalingPlansOp
  type AutoScalingPlansIO[A] = FF[AutoScalingPlansOp, A]

  sealed trait AutoScalingPlansOp[A] {
    def visit[F[_]](visitor: AutoScalingPlansOp.Visitor[F]): F[A]
  }

  object AutoScalingPlansOp {
    // Given a AutoScalingPlansClient we can embed a AutoScalingPlansIO program in any algebra that understands embedding.
    implicit val AutoScalingPlansOpEmbeddable: Embeddable[AutoScalingPlansOp, AutoScalingPlansClient] = new Embeddable[AutoScalingPlansOp, AutoScalingPlansClient] {
      def embed[A](client: AutoScalingPlansClient, io: AutoScalingPlansIO[A]): Embedded[A] = Embedded.AutoScalingPlans(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AutoScalingPlansOp.Visitor[Kleisli[M, AutoScalingPlansClient, *]] {
        def createScalingPlan(
          request: CreateScalingPlanRequest
        ): Kleisli[M, AutoScalingPlansClient, CreateScalingPlanResponse] =
          primitive(_.createScalingPlan(request))

        def deleteScalingPlan(
          request: DeleteScalingPlanRequest
        ): Kleisli[M, AutoScalingPlansClient, DeleteScalingPlanResponse] =
          primitive(_.deleteScalingPlan(request))

        def describeScalingPlanResources(
          request: DescribeScalingPlanResourcesRequest
        ): Kleisli[M, AutoScalingPlansClient, DescribeScalingPlanResourcesResponse] =
          primitive(_.describeScalingPlanResources(request))

        def describeScalingPlans(
          request: DescribeScalingPlansRequest
        ): Kleisli[M, AutoScalingPlansClient, DescribeScalingPlansResponse] =
          primitive(_.describeScalingPlans(request))

        def getScalingPlanResourceForecastData(
          request: GetScalingPlanResourceForecastDataRequest
        ): Kleisli[M, AutoScalingPlansClient, GetScalingPlanResourceForecastDataResponse] =
          primitive(_.getScalingPlanResourceForecastData(request))

        def updateScalingPlan(
          request: UpdateScalingPlanRequest
        ): Kleisli[M, AutoScalingPlansClient, UpdateScalingPlanResponse] =
          primitive(_.updateScalingPlan(request))

        def primitive[A](
          f: AutoScalingPlansClient => A
        ): Kleisli[M, AutoScalingPlansClient, A]
      }
    }

    trait Visitor[F[_]] extends (AutoScalingPlansOp ~> F) {
      final def apply[A](op: AutoScalingPlansOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createScalingPlan(
        request: CreateScalingPlanRequest
      ): F[CreateScalingPlanResponse]

      def deleteScalingPlan(
        request: DeleteScalingPlanRequest
      ): F[DeleteScalingPlanResponse]

      def describeScalingPlanResources(
        request: DescribeScalingPlanResourcesRequest
      ): F[DescribeScalingPlanResourcesResponse]

      def describeScalingPlans(
        request: DescribeScalingPlansRequest
      ): F[DescribeScalingPlansResponse]

      def getScalingPlanResourceForecastData(
        request: GetScalingPlanResourceForecastDataRequest
      ): F[GetScalingPlanResourceForecastDataResponse]

      def updateScalingPlan(
        request: UpdateScalingPlanRequest
      ): F[UpdateScalingPlanResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AutoScalingPlansOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateScalingPlanOp(
      request: CreateScalingPlanRequest
    ) extends AutoScalingPlansOp[CreateScalingPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateScalingPlanResponse] =
        visitor.createScalingPlan(request)
    }

    final case class DeleteScalingPlanOp(
      request: DeleteScalingPlanRequest
    ) extends AutoScalingPlansOp[DeleteScalingPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScalingPlanResponse] =
        visitor.deleteScalingPlan(request)
    }

    final case class DescribeScalingPlanResourcesOp(
      request: DescribeScalingPlanResourcesRequest
    ) extends AutoScalingPlansOp[DescribeScalingPlanResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingPlanResourcesResponse] =
        visitor.describeScalingPlanResources(request)
    }

    final case class DescribeScalingPlansOp(
      request: DescribeScalingPlansRequest
    ) extends AutoScalingPlansOp[DescribeScalingPlansResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingPlansResponse] =
        visitor.describeScalingPlans(request)
    }

    final case class GetScalingPlanResourceForecastDataOp(
      request: GetScalingPlanResourceForecastDataRequest
    ) extends AutoScalingPlansOp[GetScalingPlanResourceForecastDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetScalingPlanResourceForecastDataResponse] =
        visitor.getScalingPlanResourceForecastData(request)
    }

    final case class UpdateScalingPlanOp(
      request: UpdateScalingPlanRequest
    ) extends AutoScalingPlansOp[UpdateScalingPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateScalingPlanResponse] =
        visitor.updateScalingPlan(request)
    }
  }

  import AutoScalingPlansOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AutoScalingPlansOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createScalingPlan(
    request: CreateScalingPlanRequest
  ): AutoScalingPlansIO[CreateScalingPlanResponse] =
    FF.liftF(CreateScalingPlanOp(request))

  def deleteScalingPlan(
    request: DeleteScalingPlanRequest
  ): AutoScalingPlansIO[DeleteScalingPlanResponse] =
    FF.liftF(DeleteScalingPlanOp(request))

  def describeScalingPlanResources(
    request: DescribeScalingPlanResourcesRequest
  ): AutoScalingPlansIO[DescribeScalingPlanResourcesResponse] =
    FF.liftF(DescribeScalingPlanResourcesOp(request))

  def describeScalingPlans(
    request: DescribeScalingPlansRequest
  ): AutoScalingPlansIO[DescribeScalingPlansResponse] =
    FF.liftF(DescribeScalingPlansOp(request))

  def getScalingPlanResourceForecastData(
    request: GetScalingPlanResourceForecastDataRequest
  ): AutoScalingPlansIO[GetScalingPlanResourceForecastDataResponse] =
    FF.liftF(GetScalingPlanResourceForecastDataOp(request))

  def updateScalingPlan(
    request: UpdateScalingPlanRequest
  ): AutoScalingPlansIO[UpdateScalingPlanResponse] =
    FF.liftF(UpdateScalingPlanOp(request))
}
