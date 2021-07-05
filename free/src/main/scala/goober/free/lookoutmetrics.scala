package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lookoutmetrics.LookoutMetricsClient
import software.amazon.awssdk.services.lookoutmetrics.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object lookoutmetrics { module =>

  // Free monad over LookoutMetricsOp
  type LookoutMetricsIO[A] = FF[LookoutMetricsOp, A]

  sealed trait LookoutMetricsOp[A] {
    def visit[F[_]](visitor: LookoutMetricsOp.Visitor[F]): F[A]
  }

  object LookoutMetricsOp {
    // Given a LookoutMetricsClient we can embed a LookoutMetricsIO program in any algebra that understands embedding.
    implicit val LookoutMetricsOpEmbeddable: Embeddable[LookoutMetricsOp, LookoutMetricsClient] = new Embeddable[LookoutMetricsOp, LookoutMetricsClient] {
      def embed[A](client: LookoutMetricsClient, io: LookoutMetricsIO[A]): Embedded[A] = Embedded.LookoutMetrics(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LookoutMetricsOp.Visitor[Kleisli[M, LookoutMetricsClient, *]] {
        def activateAnomalyDetector(
          request: ActivateAnomalyDetectorRequest
        ): Kleisli[M, LookoutMetricsClient, ActivateAnomalyDetectorResponse] =
          primitive(_.activateAnomalyDetector(request))

        def backTestAnomalyDetector(
          request: BackTestAnomalyDetectorRequest
        ): Kleisli[M, LookoutMetricsClient, BackTestAnomalyDetectorResponse] =
          primitive(_.backTestAnomalyDetector(request))

        def createAlert(
          request: CreateAlertRequest
        ): Kleisli[M, LookoutMetricsClient, CreateAlertResponse] =
          primitive(_.createAlert(request))

        def createAnomalyDetector(
          request: CreateAnomalyDetectorRequest
        ): Kleisli[M, LookoutMetricsClient, CreateAnomalyDetectorResponse] =
          primitive(_.createAnomalyDetector(request))

        def createMetricSet(
          request: CreateMetricSetRequest
        ): Kleisli[M, LookoutMetricsClient, CreateMetricSetResponse] =
          primitive(_.createMetricSet(request))

        def deleteAlert(
          request: DeleteAlertRequest
        ): Kleisli[M, LookoutMetricsClient, DeleteAlertResponse] =
          primitive(_.deleteAlert(request))

        def deleteAnomalyDetector(
          request: DeleteAnomalyDetectorRequest
        ): Kleisli[M, LookoutMetricsClient, DeleteAnomalyDetectorResponse] =
          primitive(_.deleteAnomalyDetector(request))

        def describeAlert(
          request: DescribeAlertRequest
        ): Kleisli[M, LookoutMetricsClient, DescribeAlertResponse] =
          primitive(_.describeAlert(request))

        def describeAnomalyDetectionExecutions(
          request: DescribeAnomalyDetectionExecutionsRequest
        ): Kleisli[M, LookoutMetricsClient, DescribeAnomalyDetectionExecutionsResponse] =
          primitive(_.describeAnomalyDetectionExecutions(request))

        def describeAnomalyDetector(
          request: DescribeAnomalyDetectorRequest
        ): Kleisli[M, LookoutMetricsClient, DescribeAnomalyDetectorResponse] =
          primitive(_.describeAnomalyDetector(request))

        def describeMetricSet(
          request: DescribeMetricSetRequest
        ): Kleisli[M, LookoutMetricsClient, DescribeMetricSetResponse] =
          primitive(_.describeMetricSet(request))

        def getAnomalyGroup(
          request: GetAnomalyGroupRequest
        ): Kleisli[M, LookoutMetricsClient, GetAnomalyGroupResponse] =
          primitive(_.getAnomalyGroup(request))

        def getFeedback(
          request: GetFeedbackRequest
        ): Kleisli[M, LookoutMetricsClient, GetFeedbackResponse] =
          primitive(_.getFeedback(request))

        def getSampleData(
          request: GetSampleDataRequest
        ): Kleisli[M, LookoutMetricsClient, GetSampleDataResponse] =
          primitive(_.getSampleData(request))

        def listAlerts(
          request: ListAlertsRequest
        ): Kleisli[M, LookoutMetricsClient, ListAlertsResponse] =
          primitive(_.listAlerts(request))

        def listAnomalyDetectors(
          request: ListAnomalyDetectorsRequest
        ): Kleisli[M, LookoutMetricsClient, ListAnomalyDetectorsResponse] =
          primitive(_.listAnomalyDetectors(request))

        def listAnomalyGroupSummaries(
          request: ListAnomalyGroupSummariesRequest
        ): Kleisli[M, LookoutMetricsClient, ListAnomalyGroupSummariesResponse] =
          primitive(_.listAnomalyGroupSummaries(request))

        def listAnomalyGroupTimeSeries(
          request: ListAnomalyGroupTimeSeriesRequest
        ): Kleisli[M, LookoutMetricsClient, ListAnomalyGroupTimeSeriesResponse] =
          primitive(_.listAnomalyGroupTimeSeries(request))

        def listMetricSets(
          request: ListMetricSetsRequest
        ): Kleisli[M, LookoutMetricsClient, ListMetricSetsResponse] =
          primitive(_.listMetricSets(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, LookoutMetricsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putFeedback(
          request: PutFeedbackRequest
        ): Kleisli[M, LookoutMetricsClient, PutFeedbackResponse] =
          primitive(_.putFeedback(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LookoutMetricsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LookoutMetricsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAnomalyDetector(
          request: UpdateAnomalyDetectorRequest
        ): Kleisli[M, LookoutMetricsClient, UpdateAnomalyDetectorResponse] =
          primitive(_.updateAnomalyDetector(request))

        def updateMetricSet(
          request: UpdateMetricSetRequest
        ): Kleisli[M, LookoutMetricsClient, UpdateMetricSetResponse] =
          primitive(_.updateMetricSet(request))

        def primitive[A](
          f: LookoutMetricsClient => A
        ): Kleisli[M, LookoutMetricsClient, A]
      }
    }

    trait Visitor[F[_]] extends (LookoutMetricsOp ~> F) {
      final def apply[A](op: LookoutMetricsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def activateAnomalyDetector(
        request: ActivateAnomalyDetectorRequest
      ): F[ActivateAnomalyDetectorResponse]

      def backTestAnomalyDetector(
        request: BackTestAnomalyDetectorRequest
      ): F[BackTestAnomalyDetectorResponse]

      def createAlert(
        request: CreateAlertRequest
      ): F[CreateAlertResponse]

      def createAnomalyDetector(
        request: CreateAnomalyDetectorRequest
      ): F[CreateAnomalyDetectorResponse]

      def createMetricSet(
        request: CreateMetricSetRequest
      ): F[CreateMetricSetResponse]

      def deleteAlert(
        request: DeleteAlertRequest
      ): F[DeleteAlertResponse]

      def deleteAnomalyDetector(
        request: DeleteAnomalyDetectorRequest
      ): F[DeleteAnomalyDetectorResponse]

      def describeAlert(
        request: DescribeAlertRequest
      ): F[DescribeAlertResponse]

      def describeAnomalyDetectionExecutions(
        request: DescribeAnomalyDetectionExecutionsRequest
      ): F[DescribeAnomalyDetectionExecutionsResponse]

      def describeAnomalyDetector(
        request: DescribeAnomalyDetectorRequest
      ): F[DescribeAnomalyDetectorResponse]

      def describeMetricSet(
        request: DescribeMetricSetRequest
      ): F[DescribeMetricSetResponse]

      def getAnomalyGroup(
        request: GetAnomalyGroupRequest
      ): F[GetAnomalyGroupResponse]

      def getFeedback(
        request: GetFeedbackRequest
      ): F[GetFeedbackResponse]

      def getSampleData(
        request: GetSampleDataRequest
      ): F[GetSampleDataResponse]

      def listAlerts(
        request: ListAlertsRequest
      ): F[ListAlertsResponse]

      def listAnomalyDetectors(
        request: ListAnomalyDetectorsRequest
      ): F[ListAnomalyDetectorsResponse]

      def listAnomalyGroupSummaries(
        request: ListAnomalyGroupSummariesRequest
      ): F[ListAnomalyGroupSummariesResponse]

      def listAnomalyGroupTimeSeries(
        request: ListAnomalyGroupTimeSeriesRequest
      ): F[ListAnomalyGroupTimeSeriesResponse]

      def listMetricSets(
        request: ListMetricSetsRequest
      ): F[ListMetricSetsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putFeedback(
        request: PutFeedbackRequest
      ): F[PutFeedbackResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAnomalyDetector(
        request: UpdateAnomalyDetectorRequest
      ): F[UpdateAnomalyDetectorResponse]

      def updateMetricSet(
        request: UpdateMetricSetRequest
      ): F[UpdateMetricSetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LookoutMetricsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ActivateAnomalyDetectorOp(
      request: ActivateAnomalyDetectorRequest
    ) extends LookoutMetricsOp[ActivateAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ActivateAnomalyDetectorResponse] =
        visitor.activateAnomalyDetector(request)
    }

    final case class BackTestAnomalyDetectorOp(
      request: BackTestAnomalyDetectorRequest
    ) extends LookoutMetricsOp[BackTestAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BackTestAnomalyDetectorResponse] =
        visitor.backTestAnomalyDetector(request)
    }

    final case class CreateAlertOp(
      request: CreateAlertRequest
    ) extends LookoutMetricsOp[CreateAlertResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAlertResponse] =
        visitor.createAlert(request)
    }

    final case class CreateAnomalyDetectorOp(
      request: CreateAnomalyDetectorRequest
    ) extends LookoutMetricsOp[CreateAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAnomalyDetectorResponse] =
        visitor.createAnomalyDetector(request)
    }

    final case class CreateMetricSetOp(
      request: CreateMetricSetRequest
    ) extends LookoutMetricsOp[CreateMetricSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMetricSetResponse] =
        visitor.createMetricSet(request)
    }

    final case class DeleteAlertOp(
      request: DeleteAlertRequest
    ) extends LookoutMetricsOp[DeleteAlertResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAlertResponse] =
        visitor.deleteAlert(request)
    }

    final case class DeleteAnomalyDetectorOp(
      request: DeleteAnomalyDetectorRequest
    ) extends LookoutMetricsOp[DeleteAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAnomalyDetectorResponse] =
        visitor.deleteAnomalyDetector(request)
    }

    final case class DescribeAlertOp(
      request: DescribeAlertRequest
    ) extends LookoutMetricsOp[DescribeAlertResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlertResponse] =
        visitor.describeAlert(request)
    }

    final case class DescribeAnomalyDetectionExecutionsOp(
      request: DescribeAnomalyDetectionExecutionsRequest
    ) extends LookoutMetricsOp[DescribeAnomalyDetectionExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAnomalyDetectionExecutionsResponse] =
        visitor.describeAnomalyDetectionExecutions(request)
    }

    final case class DescribeAnomalyDetectorOp(
      request: DescribeAnomalyDetectorRequest
    ) extends LookoutMetricsOp[DescribeAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAnomalyDetectorResponse] =
        visitor.describeAnomalyDetector(request)
    }

    final case class DescribeMetricSetOp(
      request: DescribeMetricSetRequest
    ) extends LookoutMetricsOp[DescribeMetricSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMetricSetResponse] =
        visitor.describeMetricSet(request)
    }

    final case class GetAnomalyGroupOp(
      request: GetAnomalyGroupRequest
    ) extends LookoutMetricsOp[GetAnomalyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAnomalyGroupResponse] =
        visitor.getAnomalyGroup(request)
    }

    final case class GetFeedbackOp(
      request: GetFeedbackRequest
    ) extends LookoutMetricsOp[GetFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFeedbackResponse] =
        visitor.getFeedback(request)
    }

    final case class GetSampleDataOp(
      request: GetSampleDataRequest
    ) extends LookoutMetricsOp[GetSampleDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSampleDataResponse] =
        visitor.getSampleData(request)
    }

    final case class ListAlertsOp(
      request: ListAlertsRequest
    ) extends LookoutMetricsOp[ListAlertsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAlertsResponse] =
        visitor.listAlerts(request)
    }

    final case class ListAnomalyDetectorsOp(
      request: ListAnomalyDetectorsRequest
    ) extends LookoutMetricsOp[ListAnomalyDetectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnomalyDetectorsResponse] =
        visitor.listAnomalyDetectors(request)
    }

    final case class ListAnomalyGroupSummariesOp(
      request: ListAnomalyGroupSummariesRequest
    ) extends LookoutMetricsOp[ListAnomalyGroupSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnomalyGroupSummariesResponse] =
        visitor.listAnomalyGroupSummaries(request)
    }

    final case class ListAnomalyGroupTimeSeriesOp(
      request: ListAnomalyGroupTimeSeriesRequest
    ) extends LookoutMetricsOp[ListAnomalyGroupTimeSeriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnomalyGroupTimeSeriesResponse] =
        visitor.listAnomalyGroupTimeSeries(request)
    }

    final case class ListMetricSetsOp(
      request: ListMetricSetsRequest
    ) extends LookoutMetricsOp[ListMetricSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMetricSetsResponse] =
        visitor.listMetricSets(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends LookoutMetricsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutFeedbackOp(
      request: PutFeedbackRequest
    ) extends LookoutMetricsOp[PutFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFeedbackResponse] =
        visitor.putFeedback(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LookoutMetricsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LookoutMetricsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAnomalyDetectorOp(
      request: UpdateAnomalyDetectorRequest
    ) extends LookoutMetricsOp[UpdateAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAnomalyDetectorResponse] =
        visitor.updateAnomalyDetector(request)
    }

    final case class UpdateMetricSetOp(
      request: UpdateMetricSetRequest
    ) extends LookoutMetricsOp[UpdateMetricSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMetricSetResponse] =
        visitor.updateMetricSet(request)
    }
  }

  import LookoutMetricsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LookoutMetricsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def activateAnomalyDetector(
    request: ActivateAnomalyDetectorRequest
  ): LookoutMetricsIO[ActivateAnomalyDetectorResponse] =
    FF.liftF(ActivateAnomalyDetectorOp(request))

  def backTestAnomalyDetector(
    request: BackTestAnomalyDetectorRequest
  ): LookoutMetricsIO[BackTestAnomalyDetectorResponse] =
    FF.liftF(BackTestAnomalyDetectorOp(request))

  def createAlert(
    request: CreateAlertRequest
  ): LookoutMetricsIO[CreateAlertResponse] =
    FF.liftF(CreateAlertOp(request))

  def createAnomalyDetector(
    request: CreateAnomalyDetectorRequest
  ): LookoutMetricsIO[CreateAnomalyDetectorResponse] =
    FF.liftF(CreateAnomalyDetectorOp(request))

  def createMetricSet(
    request: CreateMetricSetRequest
  ): LookoutMetricsIO[CreateMetricSetResponse] =
    FF.liftF(CreateMetricSetOp(request))

  def deleteAlert(
    request: DeleteAlertRequest
  ): LookoutMetricsIO[DeleteAlertResponse] =
    FF.liftF(DeleteAlertOp(request))

  def deleteAnomalyDetector(
    request: DeleteAnomalyDetectorRequest
  ): LookoutMetricsIO[DeleteAnomalyDetectorResponse] =
    FF.liftF(DeleteAnomalyDetectorOp(request))

  def describeAlert(
    request: DescribeAlertRequest
  ): LookoutMetricsIO[DescribeAlertResponse] =
    FF.liftF(DescribeAlertOp(request))

  def describeAnomalyDetectionExecutions(
    request: DescribeAnomalyDetectionExecutionsRequest
  ): LookoutMetricsIO[DescribeAnomalyDetectionExecutionsResponse] =
    FF.liftF(DescribeAnomalyDetectionExecutionsOp(request))

  def describeAnomalyDetector(
    request: DescribeAnomalyDetectorRequest
  ): LookoutMetricsIO[DescribeAnomalyDetectorResponse] =
    FF.liftF(DescribeAnomalyDetectorOp(request))

  def describeMetricSet(
    request: DescribeMetricSetRequest
  ): LookoutMetricsIO[DescribeMetricSetResponse] =
    FF.liftF(DescribeMetricSetOp(request))

  def getAnomalyGroup(
    request: GetAnomalyGroupRequest
  ): LookoutMetricsIO[GetAnomalyGroupResponse] =
    FF.liftF(GetAnomalyGroupOp(request))

  def getFeedback(
    request: GetFeedbackRequest
  ): LookoutMetricsIO[GetFeedbackResponse] =
    FF.liftF(GetFeedbackOp(request))

  def getSampleData(
    request: GetSampleDataRequest
  ): LookoutMetricsIO[GetSampleDataResponse] =
    FF.liftF(GetSampleDataOp(request))

  def listAlerts(
    request: ListAlertsRequest
  ): LookoutMetricsIO[ListAlertsResponse] =
    FF.liftF(ListAlertsOp(request))

  def listAnomalyDetectors(
    request: ListAnomalyDetectorsRequest
  ): LookoutMetricsIO[ListAnomalyDetectorsResponse] =
    FF.liftF(ListAnomalyDetectorsOp(request))

  def listAnomalyGroupSummaries(
    request: ListAnomalyGroupSummariesRequest
  ): LookoutMetricsIO[ListAnomalyGroupSummariesResponse] =
    FF.liftF(ListAnomalyGroupSummariesOp(request))

  def listAnomalyGroupTimeSeries(
    request: ListAnomalyGroupTimeSeriesRequest
  ): LookoutMetricsIO[ListAnomalyGroupTimeSeriesResponse] =
    FF.liftF(ListAnomalyGroupTimeSeriesOp(request))

  def listMetricSets(
    request: ListMetricSetsRequest
  ): LookoutMetricsIO[ListMetricSetsResponse] =
    FF.liftF(ListMetricSetsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): LookoutMetricsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putFeedback(
    request: PutFeedbackRequest
  ): LookoutMetricsIO[PutFeedbackResponse] =
    FF.liftF(PutFeedbackOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LookoutMetricsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LookoutMetricsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAnomalyDetector(
    request: UpdateAnomalyDetectorRequest
  ): LookoutMetricsIO[UpdateAnomalyDetectorResponse] =
    FF.liftF(UpdateAnomalyDetectorOp(request))

  def updateMetricSet(
    request: UpdateMetricSetRequest
  ): LookoutMetricsIO[UpdateMetricSetResponse] =
    FF.liftF(UpdateMetricSetOp(request))
}
