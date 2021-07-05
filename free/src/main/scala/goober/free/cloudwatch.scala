package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient
import software.amazon.awssdk.services.cloudwatch.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object cloudwatch { module =>

  // Free monad over CloudWatchOp
  type CloudWatchIO[A] = FF[CloudWatchOp, A]

  sealed trait CloudWatchOp[A] {
    def visit[F[_]](visitor: CloudWatchOp.Visitor[F]): F[A]
  }

  object CloudWatchOp {
    // Given a CloudWatchClient we can embed a CloudWatchIO program in any algebra that understands embedding.
    implicit val CloudWatchOpEmbeddable: Embeddable[CloudWatchOp, CloudWatchClient] = new Embeddable[CloudWatchOp, CloudWatchClient] {
      def embed[A](client: CloudWatchClient, io: CloudWatchIO[A]): Embedded[A] = Embedded.CloudWatch(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudWatchOp.Visitor[Kleisli[M, CloudWatchClient, *]] {
        def deleteAlarms(
          request: DeleteAlarmsRequest
        ): Kleisli[M, CloudWatchClient, DeleteAlarmsResponse] =
          primitive(_.deleteAlarms(request))

        def deleteAnomalyDetector(
          request: DeleteAnomalyDetectorRequest
        ): Kleisli[M, CloudWatchClient, DeleteAnomalyDetectorResponse] =
          primitive(_.deleteAnomalyDetector(request))

        def deleteDashboards(
          request: DeleteDashboardsRequest
        ): Kleisli[M, CloudWatchClient, DeleteDashboardsResponse] =
          primitive(_.deleteDashboards(request))

        def deleteInsightRules(
          request: DeleteInsightRulesRequest
        ): Kleisli[M, CloudWatchClient, DeleteInsightRulesResponse] =
          primitive(_.deleteInsightRules(request))

        def deleteMetricStream(
          request: DeleteMetricStreamRequest
        ): Kleisli[M, CloudWatchClient, DeleteMetricStreamResponse] =
          primitive(_.deleteMetricStream(request))

        def describeAlarmHistory(
          request: DescribeAlarmHistoryRequest
        ): Kleisli[M, CloudWatchClient, DescribeAlarmHistoryResponse] =
          primitive(_.describeAlarmHistory(request))

        def describeAlarms(
          request: DescribeAlarmsRequest
        ): Kleisli[M, CloudWatchClient, DescribeAlarmsResponse] =
          primitive(_.describeAlarms(request))

        def describeAlarmsForMetric(
          request: DescribeAlarmsForMetricRequest
        ): Kleisli[M, CloudWatchClient, DescribeAlarmsForMetricResponse] =
          primitive(_.describeAlarmsForMetric(request))

        def describeAnomalyDetectors(
          request: DescribeAnomalyDetectorsRequest
        ): Kleisli[M, CloudWatchClient, DescribeAnomalyDetectorsResponse] =
          primitive(_.describeAnomalyDetectors(request))

        def describeInsightRules(
          request: DescribeInsightRulesRequest
        ): Kleisli[M, CloudWatchClient, DescribeInsightRulesResponse] =
          primitive(_.describeInsightRules(request))

        def disableAlarmActions(
          request: DisableAlarmActionsRequest
        ): Kleisli[M, CloudWatchClient, DisableAlarmActionsResponse] =
          primitive(_.disableAlarmActions(request))

        def disableInsightRules(
          request: DisableInsightRulesRequest
        ): Kleisli[M, CloudWatchClient, DisableInsightRulesResponse] =
          primitive(_.disableInsightRules(request))

        def enableAlarmActions(
          request: EnableAlarmActionsRequest
        ): Kleisli[M, CloudWatchClient, EnableAlarmActionsResponse] =
          primitive(_.enableAlarmActions(request))

        def enableInsightRules(
          request: EnableInsightRulesRequest
        ): Kleisli[M, CloudWatchClient, EnableInsightRulesResponse] =
          primitive(_.enableInsightRules(request))

        def getDashboard(
          request: GetDashboardRequest
        ): Kleisli[M, CloudWatchClient, GetDashboardResponse] =
          primitive(_.getDashboard(request))

        def getInsightRuleReport(
          request: GetInsightRuleReportRequest
        ): Kleisli[M, CloudWatchClient, GetInsightRuleReportResponse] =
          primitive(_.getInsightRuleReport(request))

        def getMetricData(
          request: GetMetricDataRequest
        ): Kleisli[M, CloudWatchClient, GetMetricDataResponse] =
          primitive(_.getMetricData(request))

        def getMetricStatistics(
          request: GetMetricStatisticsRequest
        ): Kleisli[M, CloudWatchClient, GetMetricStatisticsResponse] =
          primitive(_.getMetricStatistics(request))

        def getMetricStream(
          request: GetMetricStreamRequest
        ): Kleisli[M, CloudWatchClient, GetMetricStreamResponse] =
          primitive(_.getMetricStream(request))

        def getMetricWidgetImage(
          request: GetMetricWidgetImageRequest
        ): Kleisli[M, CloudWatchClient, GetMetricWidgetImageResponse] =
          primitive(_.getMetricWidgetImage(request))

        def listDashboards(
          request: ListDashboardsRequest
        ): Kleisli[M, CloudWatchClient, ListDashboardsResponse] =
          primitive(_.listDashboards(request))

        def listMetricStreams(
          request: ListMetricStreamsRequest
        ): Kleisli[M, CloudWatchClient, ListMetricStreamsResponse] =
          primitive(_.listMetricStreams(request))

        def listMetrics(
          request: ListMetricsRequest
        ): Kleisli[M, CloudWatchClient, ListMetricsResponse] =
          primitive(_.listMetrics(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CloudWatchClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putAnomalyDetector(
          request: PutAnomalyDetectorRequest
        ): Kleisli[M, CloudWatchClient, PutAnomalyDetectorResponse] =
          primitive(_.putAnomalyDetector(request))

        def putCompositeAlarm(
          request: PutCompositeAlarmRequest
        ): Kleisli[M, CloudWatchClient, PutCompositeAlarmResponse] =
          primitive(_.putCompositeAlarm(request))

        def putDashboard(
          request: PutDashboardRequest
        ): Kleisli[M, CloudWatchClient, PutDashboardResponse] =
          primitive(_.putDashboard(request))

        def putInsightRule(
          request: PutInsightRuleRequest
        ): Kleisli[M, CloudWatchClient, PutInsightRuleResponse] =
          primitive(_.putInsightRule(request))

        def putMetricAlarm(
          request: PutMetricAlarmRequest
        ): Kleisli[M, CloudWatchClient, PutMetricAlarmResponse] =
          primitive(_.putMetricAlarm(request))

        def putMetricData(
          request: PutMetricDataRequest
        ): Kleisli[M, CloudWatchClient, PutMetricDataResponse] =
          primitive(_.putMetricData(request))

        def putMetricStream(
          request: PutMetricStreamRequest
        ): Kleisli[M, CloudWatchClient, PutMetricStreamResponse] =
          primitive(_.putMetricStream(request))

        def setAlarmState(
          request: SetAlarmStateRequest
        ): Kleisli[M, CloudWatchClient, SetAlarmStateResponse] =
          primitive(_.setAlarmState(request))

        def startMetricStreams(
          request: StartMetricStreamsRequest
        ): Kleisli[M, CloudWatchClient, StartMetricStreamsResponse] =
          primitive(_.startMetricStreams(request))

        def stopMetricStreams(
          request: StopMetricStreamsRequest
        ): Kleisli[M, CloudWatchClient, StopMetricStreamsResponse] =
          primitive(_.stopMetricStreams(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CloudWatchClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CloudWatchClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: CloudWatchClient => A
        ): Kleisli[M, CloudWatchClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudWatchOp ~> F) {
      final def apply[A](op: CloudWatchOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def deleteAlarms(
        request: DeleteAlarmsRequest
      ): F[DeleteAlarmsResponse]

      def deleteAnomalyDetector(
        request: DeleteAnomalyDetectorRequest
      ): F[DeleteAnomalyDetectorResponse]

      def deleteDashboards(
        request: DeleteDashboardsRequest
      ): F[DeleteDashboardsResponse]

      def deleteInsightRules(
        request: DeleteInsightRulesRequest
      ): F[DeleteInsightRulesResponse]

      def deleteMetricStream(
        request: DeleteMetricStreamRequest
      ): F[DeleteMetricStreamResponse]

      def describeAlarmHistory(
        request: DescribeAlarmHistoryRequest
      ): F[DescribeAlarmHistoryResponse]

      def describeAlarms(
        request: DescribeAlarmsRequest
      ): F[DescribeAlarmsResponse]

      def describeAlarmsForMetric(
        request: DescribeAlarmsForMetricRequest
      ): F[DescribeAlarmsForMetricResponse]

      def describeAnomalyDetectors(
        request: DescribeAnomalyDetectorsRequest
      ): F[DescribeAnomalyDetectorsResponse]

      def describeInsightRules(
        request: DescribeInsightRulesRequest
      ): F[DescribeInsightRulesResponse]

      def disableAlarmActions(
        request: DisableAlarmActionsRequest
      ): F[DisableAlarmActionsResponse]

      def disableInsightRules(
        request: DisableInsightRulesRequest
      ): F[DisableInsightRulesResponse]

      def enableAlarmActions(
        request: EnableAlarmActionsRequest
      ): F[EnableAlarmActionsResponse]

      def enableInsightRules(
        request: EnableInsightRulesRequest
      ): F[EnableInsightRulesResponse]

      def getDashboard(
        request: GetDashboardRequest
      ): F[GetDashboardResponse]

      def getInsightRuleReport(
        request: GetInsightRuleReportRequest
      ): F[GetInsightRuleReportResponse]

      def getMetricData(
        request: GetMetricDataRequest
      ): F[GetMetricDataResponse]

      def getMetricStatistics(
        request: GetMetricStatisticsRequest
      ): F[GetMetricStatisticsResponse]

      def getMetricStream(
        request: GetMetricStreamRequest
      ): F[GetMetricStreamResponse]

      def getMetricWidgetImage(
        request: GetMetricWidgetImageRequest
      ): F[GetMetricWidgetImageResponse]

      def listDashboards(
        request: ListDashboardsRequest
      ): F[ListDashboardsResponse]

      def listMetricStreams(
        request: ListMetricStreamsRequest
      ): F[ListMetricStreamsResponse]

      def listMetrics(
        request: ListMetricsRequest
      ): F[ListMetricsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putAnomalyDetector(
        request: PutAnomalyDetectorRequest
      ): F[PutAnomalyDetectorResponse]

      def putCompositeAlarm(
        request: PutCompositeAlarmRequest
      ): F[PutCompositeAlarmResponse]

      def putDashboard(
        request: PutDashboardRequest
      ): F[PutDashboardResponse]

      def putInsightRule(
        request: PutInsightRuleRequest
      ): F[PutInsightRuleResponse]

      def putMetricAlarm(
        request: PutMetricAlarmRequest
      ): F[PutMetricAlarmResponse]

      def putMetricData(
        request: PutMetricDataRequest
      ): F[PutMetricDataResponse]

      def putMetricStream(
        request: PutMetricStreamRequest
      ): F[PutMetricStreamResponse]

      def setAlarmState(
        request: SetAlarmStateRequest
      ): F[SetAlarmStateResponse]

      def startMetricStreams(
        request: StartMetricStreamsRequest
      ): F[StartMetricStreamsResponse]

      def stopMetricStreams(
        request: StopMetricStreamsRequest
      ): F[StopMetricStreamsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudWatchOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DeleteAlarmsOp(
      request: DeleteAlarmsRequest
    ) extends CloudWatchOp[DeleteAlarmsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAlarmsResponse] =
        visitor.deleteAlarms(request)
    }

    final case class DeleteAnomalyDetectorOp(
      request: DeleteAnomalyDetectorRequest
    ) extends CloudWatchOp[DeleteAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAnomalyDetectorResponse] =
        visitor.deleteAnomalyDetector(request)
    }

    final case class DeleteDashboardsOp(
      request: DeleteDashboardsRequest
    ) extends CloudWatchOp[DeleteDashboardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDashboardsResponse] =
        visitor.deleteDashboards(request)
    }

    final case class DeleteInsightRulesOp(
      request: DeleteInsightRulesRequest
    ) extends CloudWatchOp[DeleteInsightRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInsightRulesResponse] =
        visitor.deleteInsightRules(request)
    }

    final case class DeleteMetricStreamOp(
      request: DeleteMetricStreamRequest
    ) extends CloudWatchOp[DeleteMetricStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMetricStreamResponse] =
        visitor.deleteMetricStream(request)
    }

    final case class DescribeAlarmHistoryOp(
      request: DescribeAlarmHistoryRequest
    ) extends CloudWatchOp[DescribeAlarmHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlarmHistoryResponse] =
        visitor.describeAlarmHistory(request)
    }

    final case class DescribeAlarmsOp(
      request: DescribeAlarmsRequest
    ) extends CloudWatchOp[DescribeAlarmsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlarmsResponse] =
        visitor.describeAlarms(request)
    }

    final case class DescribeAlarmsForMetricOp(
      request: DescribeAlarmsForMetricRequest
    ) extends CloudWatchOp[DescribeAlarmsForMetricResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlarmsForMetricResponse] =
        visitor.describeAlarmsForMetric(request)
    }

    final case class DescribeAnomalyDetectorsOp(
      request: DescribeAnomalyDetectorsRequest
    ) extends CloudWatchOp[DescribeAnomalyDetectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAnomalyDetectorsResponse] =
        visitor.describeAnomalyDetectors(request)
    }

    final case class DescribeInsightRulesOp(
      request: DescribeInsightRulesRequest
    ) extends CloudWatchOp[DescribeInsightRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInsightRulesResponse] =
        visitor.describeInsightRules(request)
    }

    final case class DisableAlarmActionsOp(
      request: DisableAlarmActionsRequest
    ) extends CloudWatchOp[DisableAlarmActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableAlarmActionsResponse] =
        visitor.disableAlarmActions(request)
    }

    final case class DisableInsightRulesOp(
      request: DisableInsightRulesRequest
    ) extends CloudWatchOp[DisableInsightRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableInsightRulesResponse] =
        visitor.disableInsightRules(request)
    }

    final case class EnableAlarmActionsOp(
      request: EnableAlarmActionsRequest
    ) extends CloudWatchOp[EnableAlarmActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableAlarmActionsResponse] =
        visitor.enableAlarmActions(request)
    }

    final case class EnableInsightRulesOp(
      request: EnableInsightRulesRequest
    ) extends CloudWatchOp[EnableInsightRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableInsightRulesResponse] =
        visitor.enableInsightRules(request)
    }

    final case class GetDashboardOp(
      request: GetDashboardRequest
    ) extends CloudWatchOp[GetDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDashboardResponse] =
        visitor.getDashboard(request)
    }

    final case class GetInsightRuleReportOp(
      request: GetInsightRuleReportRequest
    ) extends CloudWatchOp[GetInsightRuleReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightRuleReportResponse] =
        visitor.getInsightRuleReport(request)
    }

    final case class GetMetricDataOp(
      request: GetMetricDataRequest
    ) extends CloudWatchOp[GetMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMetricDataResponse] =
        visitor.getMetricData(request)
    }

    final case class GetMetricStatisticsOp(
      request: GetMetricStatisticsRequest
    ) extends CloudWatchOp[GetMetricStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMetricStatisticsResponse] =
        visitor.getMetricStatistics(request)
    }

    final case class GetMetricStreamOp(
      request: GetMetricStreamRequest
    ) extends CloudWatchOp[GetMetricStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMetricStreamResponse] =
        visitor.getMetricStream(request)
    }

    final case class GetMetricWidgetImageOp(
      request: GetMetricWidgetImageRequest
    ) extends CloudWatchOp[GetMetricWidgetImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMetricWidgetImageResponse] =
        visitor.getMetricWidgetImage(request)
    }

    final case class ListDashboardsOp(
      request: ListDashboardsRequest
    ) extends CloudWatchOp[ListDashboardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDashboardsResponse] =
        visitor.listDashboards(request)
    }

    final case class ListMetricStreamsOp(
      request: ListMetricStreamsRequest
    ) extends CloudWatchOp[ListMetricStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMetricStreamsResponse] =
        visitor.listMetricStreams(request)
    }

    final case class ListMetricsOp(
      request: ListMetricsRequest
    ) extends CloudWatchOp[ListMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMetricsResponse] =
        visitor.listMetrics(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CloudWatchOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutAnomalyDetectorOp(
      request: PutAnomalyDetectorRequest
    ) extends CloudWatchOp[PutAnomalyDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAnomalyDetectorResponse] =
        visitor.putAnomalyDetector(request)
    }

    final case class PutCompositeAlarmOp(
      request: PutCompositeAlarmRequest
    ) extends CloudWatchOp[PutCompositeAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutCompositeAlarmResponse] =
        visitor.putCompositeAlarm(request)
    }

    final case class PutDashboardOp(
      request: PutDashboardRequest
    ) extends CloudWatchOp[PutDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDashboardResponse] =
        visitor.putDashboard(request)
    }

    final case class PutInsightRuleOp(
      request: PutInsightRuleRequest
    ) extends CloudWatchOp[PutInsightRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutInsightRuleResponse] =
        visitor.putInsightRule(request)
    }

    final case class PutMetricAlarmOp(
      request: PutMetricAlarmRequest
    ) extends CloudWatchOp[PutMetricAlarmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMetricAlarmResponse] =
        visitor.putMetricAlarm(request)
    }

    final case class PutMetricDataOp(
      request: PutMetricDataRequest
    ) extends CloudWatchOp[PutMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMetricDataResponse] =
        visitor.putMetricData(request)
    }

    final case class PutMetricStreamOp(
      request: PutMetricStreamRequest
    ) extends CloudWatchOp[PutMetricStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMetricStreamResponse] =
        visitor.putMetricStream(request)
    }

    final case class SetAlarmStateOp(
      request: SetAlarmStateRequest
    ) extends CloudWatchOp[SetAlarmStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetAlarmStateResponse] =
        visitor.setAlarmState(request)
    }

    final case class StartMetricStreamsOp(
      request: StartMetricStreamsRequest
    ) extends CloudWatchOp[StartMetricStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMetricStreamsResponse] =
        visitor.startMetricStreams(request)
    }

    final case class StopMetricStreamsOp(
      request: StopMetricStreamsRequest
    ) extends CloudWatchOp[StopMetricStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopMetricStreamsResponse] =
        visitor.stopMetricStreams(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CloudWatchOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CloudWatchOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import CloudWatchOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudWatchOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def deleteAlarms(
    request: DeleteAlarmsRequest
  ): CloudWatchIO[DeleteAlarmsResponse] =
    FF.liftF(DeleteAlarmsOp(request))

  def deleteAnomalyDetector(
    request: DeleteAnomalyDetectorRequest
  ): CloudWatchIO[DeleteAnomalyDetectorResponse] =
    FF.liftF(DeleteAnomalyDetectorOp(request))

  def deleteDashboards(
    request: DeleteDashboardsRequest
  ): CloudWatchIO[DeleteDashboardsResponse] =
    FF.liftF(DeleteDashboardsOp(request))

  def deleteInsightRules(
    request: DeleteInsightRulesRequest
  ): CloudWatchIO[DeleteInsightRulesResponse] =
    FF.liftF(DeleteInsightRulesOp(request))

  def deleteMetricStream(
    request: DeleteMetricStreamRequest
  ): CloudWatchIO[DeleteMetricStreamResponse] =
    FF.liftF(DeleteMetricStreamOp(request))

  def describeAlarmHistory(
    request: DescribeAlarmHistoryRequest
  ): CloudWatchIO[DescribeAlarmHistoryResponse] =
    FF.liftF(DescribeAlarmHistoryOp(request))

  def describeAlarms(
    request: DescribeAlarmsRequest
  ): CloudWatchIO[DescribeAlarmsResponse] =
    FF.liftF(DescribeAlarmsOp(request))

  def describeAlarmsForMetric(
    request: DescribeAlarmsForMetricRequest
  ): CloudWatchIO[DescribeAlarmsForMetricResponse] =
    FF.liftF(DescribeAlarmsForMetricOp(request))

  def describeAnomalyDetectors(
    request: DescribeAnomalyDetectorsRequest
  ): CloudWatchIO[DescribeAnomalyDetectorsResponse] =
    FF.liftF(DescribeAnomalyDetectorsOp(request))

  def describeInsightRules(
    request: DescribeInsightRulesRequest
  ): CloudWatchIO[DescribeInsightRulesResponse] =
    FF.liftF(DescribeInsightRulesOp(request))

  def disableAlarmActions(
    request: DisableAlarmActionsRequest
  ): CloudWatchIO[DisableAlarmActionsResponse] =
    FF.liftF(DisableAlarmActionsOp(request))

  def disableInsightRules(
    request: DisableInsightRulesRequest
  ): CloudWatchIO[DisableInsightRulesResponse] =
    FF.liftF(DisableInsightRulesOp(request))

  def enableAlarmActions(
    request: EnableAlarmActionsRequest
  ): CloudWatchIO[EnableAlarmActionsResponse] =
    FF.liftF(EnableAlarmActionsOp(request))

  def enableInsightRules(
    request: EnableInsightRulesRequest
  ): CloudWatchIO[EnableInsightRulesResponse] =
    FF.liftF(EnableInsightRulesOp(request))

  def getDashboard(
    request: GetDashboardRequest
  ): CloudWatchIO[GetDashboardResponse] =
    FF.liftF(GetDashboardOp(request))

  def getInsightRuleReport(
    request: GetInsightRuleReportRequest
  ): CloudWatchIO[GetInsightRuleReportResponse] =
    FF.liftF(GetInsightRuleReportOp(request))

  def getMetricData(
    request: GetMetricDataRequest
  ): CloudWatchIO[GetMetricDataResponse] =
    FF.liftF(GetMetricDataOp(request))

  def getMetricStatistics(
    request: GetMetricStatisticsRequest
  ): CloudWatchIO[GetMetricStatisticsResponse] =
    FF.liftF(GetMetricStatisticsOp(request))

  def getMetricStream(
    request: GetMetricStreamRequest
  ): CloudWatchIO[GetMetricStreamResponse] =
    FF.liftF(GetMetricStreamOp(request))

  def getMetricWidgetImage(
    request: GetMetricWidgetImageRequest
  ): CloudWatchIO[GetMetricWidgetImageResponse] =
    FF.liftF(GetMetricWidgetImageOp(request))

  def listDashboards(
    request: ListDashboardsRequest
  ): CloudWatchIO[ListDashboardsResponse] =
    FF.liftF(ListDashboardsOp(request))

  def listMetricStreams(
    request: ListMetricStreamsRequest
  ): CloudWatchIO[ListMetricStreamsResponse] =
    FF.liftF(ListMetricStreamsOp(request))

  def listMetrics(
    request: ListMetricsRequest
  ): CloudWatchIO[ListMetricsResponse] =
    FF.liftF(ListMetricsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CloudWatchIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putAnomalyDetector(
    request: PutAnomalyDetectorRequest
  ): CloudWatchIO[PutAnomalyDetectorResponse] =
    FF.liftF(PutAnomalyDetectorOp(request))

  def putCompositeAlarm(
    request: PutCompositeAlarmRequest
  ): CloudWatchIO[PutCompositeAlarmResponse] =
    FF.liftF(PutCompositeAlarmOp(request))

  def putDashboard(
    request: PutDashboardRequest
  ): CloudWatchIO[PutDashboardResponse] =
    FF.liftF(PutDashboardOp(request))

  def putInsightRule(
    request: PutInsightRuleRequest
  ): CloudWatchIO[PutInsightRuleResponse] =
    FF.liftF(PutInsightRuleOp(request))

  def putMetricAlarm(
    request: PutMetricAlarmRequest
  ): CloudWatchIO[PutMetricAlarmResponse] =
    FF.liftF(PutMetricAlarmOp(request))

  def putMetricData(
    request: PutMetricDataRequest
  ): CloudWatchIO[PutMetricDataResponse] =
    FF.liftF(PutMetricDataOp(request))

  def putMetricStream(
    request: PutMetricStreamRequest
  ): CloudWatchIO[PutMetricStreamResponse] =
    FF.liftF(PutMetricStreamOp(request))

  def setAlarmState(
    request: SetAlarmStateRequest
  ): CloudWatchIO[SetAlarmStateResponse] =
    FF.liftF(SetAlarmStateOp(request))

  def startMetricStreams(
    request: StartMetricStreamsRequest
  ): CloudWatchIO[StartMetricStreamsResponse] =
    FF.liftF(StartMetricStreamsOp(request))

  def stopMetricStreams(
    request: StopMetricStreamsRequest
  ): CloudWatchIO[StopMetricStreamsResponse] =
    FF.liftF(StopMetricStreamsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CloudWatchIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CloudWatchIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
