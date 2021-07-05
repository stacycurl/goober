package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.computeoptimizer.ComputeOptimizerClient
import software.amazon.awssdk.services.computeoptimizer.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object computeoptimizer { module =>

  // Free monad over ComputeOptimizerOp
  type ComputeOptimizerIO[A] = FF[ComputeOptimizerOp, A]

  sealed trait ComputeOptimizerOp[A] {
    def visit[F[_]](visitor: ComputeOptimizerOp.Visitor[F]): F[A]
  }

  object ComputeOptimizerOp {
    // Given a ComputeOptimizerClient we can embed a ComputeOptimizerIO program in any algebra that understands embedding.
    implicit val ComputeOptimizerOpEmbeddable: Embeddable[ComputeOptimizerOp, ComputeOptimizerClient] = new Embeddable[ComputeOptimizerOp, ComputeOptimizerClient] {
      def embed[A](client: ComputeOptimizerClient, io: ComputeOptimizerIO[A]): Embedded[A] = Embedded.ComputeOptimizer(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ComputeOptimizerOp.Visitor[Kleisli[M, ComputeOptimizerClient, *]] {
        def describeRecommendationExportJobs(
          request: DescribeRecommendationExportJobsRequest
        ): Kleisli[M, ComputeOptimizerClient, DescribeRecommendationExportJobsResponse] =
          primitive(_.describeRecommendationExportJobs(request))

        def exportAutoScalingGroupRecommendations(
          request: ExportAutoScalingGroupRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, ExportAutoScalingGroupRecommendationsResponse] =
          primitive(_.exportAutoScalingGroupRecommendations(request))

        def exportEBSVolumeRecommendations(
          request: ExportEbsVolumeRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, ExportEbsVolumeRecommendationsResponse] =
          primitive(_.exportEBSVolumeRecommendations(request))

        def exportEC2InstanceRecommendations(
          request: ExportEc2InstanceRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, ExportEc2InstanceRecommendationsResponse] =
          primitive(_.exportEC2InstanceRecommendations(request))

        def exportLambdaFunctionRecommendations(
          request: ExportLambdaFunctionRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, ExportLambdaFunctionRecommendationsResponse] =
          primitive(_.exportLambdaFunctionRecommendations(request))

        def getAutoScalingGroupRecommendations(
          request: GetAutoScalingGroupRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, GetAutoScalingGroupRecommendationsResponse] =
          primitive(_.getAutoScalingGroupRecommendations(request))

        def getEBSVolumeRecommendations(
          request: GetEbsVolumeRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, GetEbsVolumeRecommendationsResponse] =
          primitive(_.getEBSVolumeRecommendations(request))

        def getEC2InstanceRecommendations(
          request: GetEc2InstanceRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, GetEc2InstanceRecommendationsResponse] =
          primitive(_.getEC2InstanceRecommendations(request))

        def getEC2RecommendationProjectedMetrics(
          request: GetEc2RecommendationProjectedMetricsRequest
        ): Kleisli[M, ComputeOptimizerClient, GetEc2RecommendationProjectedMetricsResponse] =
          primitive(_.getEC2RecommendationProjectedMetrics(request))

        def getEnrollmentStatus(
          request: GetEnrollmentStatusRequest
        ): Kleisli[M, ComputeOptimizerClient, GetEnrollmentStatusResponse] =
          primitive(_.getEnrollmentStatus(request))

        def getLambdaFunctionRecommendations(
          request: GetLambdaFunctionRecommendationsRequest
        ): Kleisli[M, ComputeOptimizerClient, GetLambdaFunctionRecommendationsResponse] =
          primitive(_.getLambdaFunctionRecommendations(request))

        def getRecommendationSummaries(
          request: GetRecommendationSummariesRequest
        ): Kleisli[M, ComputeOptimizerClient, GetRecommendationSummariesResponse] =
          primitive(_.getRecommendationSummaries(request))

        def updateEnrollmentStatus(
          request: UpdateEnrollmentStatusRequest
        ): Kleisli[M, ComputeOptimizerClient, UpdateEnrollmentStatusResponse] =
          primitive(_.updateEnrollmentStatus(request))

        def primitive[A](
          f: ComputeOptimizerClient => A
        ): Kleisli[M, ComputeOptimizerClient, A]
      }
    }

    trait Visitor[F[_]] extends (ComputeOptimizerOp ~> F) {
      final def apply[A](op: ComputeOptimizerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeRecommendationExportJobs(
        request: DescribeRecommendationExportJobsRequest
      ): F[DescribeRecommendationExportJobsResponse]

      def exportAutoScalingGroupRecommendations(
        request: ExportAutoScalingGroupRecommendationsRequest
      ): F[ExportAutoScalingGroupRecommendationsResponse]

      def exportEBSVolumeRecommendations(
        request: ExportEbsVolumeRecommendationsRequest
      ): F[ExportEbsVolumeRecommendationsResponse]

      def exportEC2InstanceRecommendations(
        request: ExportEc2InstanceRecommendationsRequest
      ): F[ExportEc2InstanceRecommendationsResponse]

      def exportLambdaFunctionRecommendations(
        request: ExportLambdaFunctionRecommendationsRequest
      ): F[ExportLambdaFunctionRecommendationsResponse]

      def getAutoScalingGroupRecommendations(
        request: GetAutoScalingGroupRecommendationsRequest
      ): F[GetAutoScalingGroupRecommendationsResponse]

      def getEBSVolumeRecommendations(
        request: GetEbsVolumeRecommendationsRequest
      ): F[GetEbsVolumeRecommendationsResponse]

      def getEC2InstanceRecommendations(
        request: GetEc2InstanceRecommendationsRequest
      ): F[GetEc2InstanceRecommendationsResponse]

      def getEC2RecommendationProjectedMetrics(
        request: GetEc2RecommendationProjectedMetricsRequest
      ): F[GetEc2RecommendationProjectedMetricsResponse]

      def getEnrollmentStatus(
        request: GetEnrollmentStatusRequest
      ): F[GetEnrollmentStatusResponse]

      def getLambdaFunctionRecommendations(
        request: GetLambdaFunctionRecommendationsRequest
      ): F[GetLambdaFunctionRecommendationsResponse]

      def getRecommendationSummaries(
        request: GetRecommendationSummariesRequest
      ): F[GetRecommendationSummariesResponse]

      def updateEnrollmentStatus(
        request: UpdateEnrollmentStatusRequest
      ): F[UpdateEnrollmentStatusResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ComputeOptimizerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeRecommendationExportJobsOp(
      request: DescribeRecommendationExportJobsRequest
    ) extends ComputeOptimizerOp[DescribeRecommendationExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRecommendationExportJobsResponse] =
        visitor.describeRecommendationExportJobs(request)
    }

    final case class ExportAutoScalingGroupRecommendationsOp(
      request: ExportAutoScalingGroupRecommendationsRequest
    ) extends ComputeOptimizerOp[ExportAutoScalingGroupRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportAutoScalingGroupRecommendationsResponse] =
        visitor.exportAutoScalingGroupRecommendations(request)
    }

    final case class ExportEBSVolumeRecommendationsOp(
      request: ExportEbsVolumeRecommendationsRequest
    ) extends ComputeOptimizerOp[ExportEbsVolumeRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportEbsVolumeRecommendationsResponse] =
        visitor.exportEBSVolumeRecommendations(request)
    }

    final case class ExportEC2InstanceRecommendationsOp(
      request: ExportEc2InstanceRecommendationsRequest
    ) extends ComputeOptimizerOp[ExportEc2InstanceRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportEc2InstanceRecommendationsResponse] =
        visitor.exportEC2InstanceRecommendations(request)
    }

    final case class ExportLambdaFunctionRecommendationsOp(
      request: ExportLambdaFunctionRecommendationsRequest
    ) extends ComputeOptimizerOp[ExportLambdaFunctionRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportLambdaFunctionRecommendationsResponse] =
        visitor.exportLambdaFunctionRecommendations(request)
    }

    final case class GetAutoScalingGroupRecommendationsOp(
      request: GetAutoScalingGroupRecommendationsRequest
    ) extends ComputeOptimizerOp[GetAutoScalingGroupRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAutoScalingGroupRecommendationsResponse] =
        visitor.getAutoScalingGroupRecommendations(request)
    }

    final case class GetEBSVolumeRecommendationsOp(
      request: GetEbsVolumeRecommendationsRequest
    ) extends ComputeOptimizerOp[GetEbsVolumeRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEbsVolumeRecommendationsResponse] =
        visitor.getEBSVolumeRecommendations(request)
    }

    final case class GetEC2InstanceRecommendationsOp(
      request: GetEc2InstanceRecommendationsRequest
    ) extends ComputeOptimizerOp[GetEc2InstanceRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEc2InstanceRecommendationsResponse] =
        visitor.getEC2InstanceRecommendations(request)
    }

    final case class GetEC2RecommendationProjectedMetricsOp(
      request: GetEc2RecommendationProjectedMetricsRequest
    ) extends ComputeOptimizerOp[GetEc2RecommendationProjectedMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEc2RecommendationProjectedMetricsResponse] =
        visitor.getEC2RecommendationProjectedMetrics(request)
    }

    final case class GetEnrollmentStatusOp(
      request: GetEnrollmentStatusRequest
    ) extends ComputeOptimizerOp[GetEnrollmentStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnrollmentStatusResponse] =
        visitor.getEnrollmentStatus(request)
    }

    final case class GetLambdaFunctionRecommendationsOp(
      request: GetLambdaFunctionRecommendationsRequest
    ) extends ComputeOptimizerOp[GetLambdaFunctionRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLambdaFunctionRecommendationsResponse] =
        visitor.getLambdaFunctionRecommendations(request)
    }

    final case class GetRecommendationSummariesOp(
      request: GetRecommendationSummariesRequest
    ) extends ComputeOptimizerOp[GetRecommendationSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecommendationSummariesResponse] =
        visitor.getRecommendationSummaries(request)
    }

    final case class UpdateEnrollmentStatusOp(
      request: UpdateEnrollmentStatusRequest
    ) extends ComputeOptimizerOp[UpdateEnrollmentStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnrollmentStatusResponse] =
        visitor.updateEnrollmentStatus(request)
    }
  }

  import ComputeOptimizerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ComputeOptimizerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeRecommendationExportJobs(
    request: DescribeRecommendationExportJobsRequest
  ): ComputeOptimizerIO[DescribeRecommendationExportJobsResponse] =
    FF.liftF(DescribeRecommendationExportJobsOp(request))

  def exportAutoScalingGroupRecommendations(
    request: ExportAutoScalingGroupRecommendationsRequest
  ): ComputeOptimizerIO[ExportAutoScalingGroupRecommendationsResponse] =
    FF.liftF(ExportAutoScalingGroupRecommendationsOp(request))

  def exportEBSVolumeRecommendations(
    request: ExportEbsVolumeRecommendationsRequest
  ): ComputeOptimizerIO[ExportEbsVolumeRecommendationsResponse] =
    FF.liftF(ExportEBSVolumeRecommendationsOp(request))

  def exportEC2InstanceRecommendations(
    request: ExportEc2InstanceRecommendationsRequest
  ): ComputeOptimizerIO[ExportEc2InstanceRecommendationsResponse] =
    FF.liftF(ExportEC2InstanceRecommendationsOp(request))

  def exportLambdaFunctionRecommendations(
    request: ExportLambdaFunctionRecommendationsRequest
  ): ComputeOptimizerIO[ExportLambdaFunctionRecommendationsResponse] =
    FF.liftF(ExportLambdaFunctionRecommendationsOp(request))

  def getAutoScalingGroupRecommendations(
    request: GetAutoScalingGroupRecommendationsRequest
  ): ComputeOptimizerIO[GetAutoScalingGroupRecommendationsResponse] =
    FF.liftF(GetAutoScalingGroupRecommendationsOp(request))

  def getEBSVolumeRecommendations(
    request: GetEbsVolumeRecommendationsRequest
  ): ComputeOptimizerIO[GetEbsVolumeRecommendationsResponse] =
    FF.liftF(GetEBSVolumeRecommendationsOp(request))

  def getEC2InstanceRecommendations(
    request: GetEc2InstanceRecommendationsRequest
  ): ComputeOptimizerIO[GetEc2InstanceRecommendationsResponse] =
    FF.liftF(GetEC2InstanceRecommendationsOp(request))

  def getEC2RecommendationProjectedMetrics(
    request: GetEc2RecommendationProjectedMetricsRequest
  ): ComputeOptimizerIO[GetEc2RecommendationProjectedMetricsResponse] =
    FF.liftF(GetEC2RecommendationProjectedMetricsOp(request))

  def getEnrollmentStatus(
    request: GetEnrollmentStatusRequest
  ): ComputeOptimizerIO[GetEnrollmentStatusResponse] =
    FF.liftF(GetEnrollmentStatusOp(request))

  def getLambdaFunctionRecommendations(
    request: GetLambdaFunctionRecommendationsRequest
  ): ComputeOptimizerIO[GetLambdaFunctionRecommendationsResponse] =
    FF.liftF(GetLambdaFunctionRecommendationsOp(request))

  def getRecommendationSummaries(
    request: GetRecommendationSummariesRequest
  ): ComputeOptimizerIO[GetRecommendationSummariesResponse] =
    FF.liftF(GetRecommendationSummariesOp(request))

  def updateEnrollmentStatus(
    request: UpdateEnrollmentStatusRequest
  ): ComputeOptimizerIO[UpdateEnrollmentStatusResponse] =
    FF.liftF(UpdateEnrollmentStatusOp(request))
}
