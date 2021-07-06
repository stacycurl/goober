package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.xray.XRayClient
import software.amazon.awssdk.services.xray.model._


object xray { module =>

  // Free monad over XRayOp
  type XRayIO[A] = FF[XRayOp, A]

  sealed trait XRayOp[A] {
    def visit[F[_]](visitor: XRayOp.Visitor[F]): F[A]
  }

  object XRayOp {
    // Given a XRayClient we can embed a XRayIO program in any algebra that understands embedding.
    implicit val XRayOpEmbeddable: Embeddable[XRayOp, XRayClient] = new Embeddable[XRayOp, XRayClient] {
      def embed[A](client: XRayClient, io: XRayIO[A]): Embedded[A] = Embedded.XRay(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends XRayOp.Visitor[Kleisli[M, XRayClient, *]] {
        def batchGetTraces(
          request: BatchGetTracesRequest
        ): Kleisli[M, XRayClient, BatchGetTracesResponse] =
          primitive(_.batchGetTraces(request))

        def createGroup(
          request: CreateGroupRequest
        ): Kleisli[M, XRayClient, CreateGroupResponse] =
          primitive(_.createGroup(request))

        def createSamplingRule(
          request: CreateSamplingRuleRequest
        ): Kleisli[M, XRayClient, CreateSamplingRuleResponse] =
          primitive(_.createSamplingRule(request))

        def deleteGroup(
          request: DeleteGroupRequest
        ): Kleisli[M, XRayClient, DeleteGroupResponse] =
          primitive(_.deleteGroup(request))

        def deleteSamplingRule(
          request: DeleteSamplingRuleRequest
        ): Kleisli[M, XRayClient, DeleteSamplingRuleResponse] =
          primitive(_.deleteSamplingRule(request))

        def getEncryptionConfig(
          request: GetEncryptionConfigRequest
        ): Kleisli[M, XRayClient, GetEncryptionConfigResponse] =
          primitive(_.getEncryptionConfig(request))

        def getGroup(
          request: GetGroupRequest
        ): Kleisli[M, XRayClient, GetGroupResponse] =
          primitive(_.getGroup(request))

        def getGroups(
          request: GetGroupsRequest
        ): Kleisli[M, XRayClient, GetGroupsResponse] =
          primitive(_.getGroups(request))

        def getInsight(
          request: GetInsightRequest
        ): Kleisli[M, XRayClient, GetInsightResponse] =
          primitive(_.getInsight(request))

        def getInsightEvents(
          request: GetInsightEventsRequest
        ): Kleisli[M, XRayClient, GetInsightEventsResponse] =
          primitive(_.getInsightEvents(request))

        def getInsightImpactGraph(
          request: GetInsightImpactGraphRequest
        ): Kleisli[M, XRayClient, GetInsightImpactGraphResponse] =
          primitive(_.getInsightImpactGraph(request))

        def getInsightSummaries(
          request: GetInsightSummariesRequest
        ): Kleisli[M, XRayClient, GetInsightSummariesResponse] =
          primitive(_.getInsightSummaries(request))

        def getSamplingRules(
          request: GetSamplingRulesRequest
        ): Kleisli[M, XRayClient, GetSamplingRulesResponse] =
          primitive(_.getSamplingRules(request))

        def getSamplingStatisticSummaries(
          request: GetSamplingStatisticSummariesRequest
        ): Kleisli[M, XRayClient, GetSamplingStatisticSummariesResponse] =
          primitive(_.getSamplingStatisticSummaries(request))

        def getSamplingTargets(
          request: GetSamplingTargetsRequest
        ): Kleisli[M, XRayClient, GetSamplingTargetsResponse] =
          primitive(_.getSamplingTargets(request))

        def getServiceGraph(
          request: GetServiceGraphRequest
        ): Kleisli[M, XRayClient, GetServiceGraphResponse] =
          primitive(_.getServiceGraph(request))

        def getTimeSeriesServiceStatistics(
          request: GetTimeSeriesServiceStatisticsRequest
        ): Kleisli[M, XRayClient, GetTimeSeriesServiceStatisticsResponse] =
          primitive(_.getTimeSeriesServiceStatistics(request))

        def getTraceGraph(
          request: GetTraceGraphRequest
        ): Kleisli[M, XRayClient, GetTraceGraphResponse] =
          primitive(_.getTraceGraph(request))

        def getTraceSummaries(
          request: GetTraceSummariesRequest
        ): Kleisli[M, XRayClient, GetTraceSummariesResponse] =
          primitive(_.getTraceSummaries(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, XRayClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putEncryptionConfig(
          request: PutEncryptionConfigRequest
        ): Kleisli[M, XRayClient, PutEncryptionConfigResponse] =
          primitive(_.putEncryptionConfig(request))

        def putTelemetryRecords(
          request: PutTelemetryRecordsRequest
        ): Kleisli[M, XRayClient, PutTelemetryRecordsResponse] =
          primitive(_.putTelemetryRecords(request))

        def putTraceSegments(
          request: PutTraceSegmentsRequest
        ): Kleisli[M, XRayClient, PutTraceSegmentsResponse] =
          primitive(_.putTraceSegments(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, XRayClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, XRayClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateGroup(
          request: UpdateGroupRequest
        ): Kleisli[M, XRayClient, UpdateGroupResponse] =
          primitive(_.updateGroup(request))

        def updateSamplingRule(
          request: UpdateSamplingRuleRequest
        ): Kleisli[M, XRayClient, UpdateSamplingRuleResponse] =
          primitive(_.updateSamplingRule(request))

        def primitive[A](
          f: XRayClient => A
        ): Kleisli[M, XRayClient, A]
      }
    }

    trait Visitor[F[_]] extends (XRayOp ~> F) {
      final def apply[A](op: XRayOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchGetTraces(
        request: BatchGetTracesRequest
      ): F[BatchGetTracesResponse]

      def createGroup(
        request: CreateGroupRequest
      ): F[CreateGroupResponse]

      def createSamplingRule(
        request: CreateSamplingRuleRequest
      ): F[CreateSamplingRuleResponse]

      def deleteGroup(
        request: DeleteGroupRequest
      ): F[DeleteGroupResponse]

      def deleteSamplingRule(
        request: DeleteSamplingRuleRequest
      ): F[DeleteSamplingRuleResponse]

      def getEncryptionConfig(
        request: GetEncryptionConfigRequest
      ): F[GetEncryptionConfigResponse]

      def getGroup(
        request: GetGroupRequest
      ): F[GetGroupResponse]

      def getGroups(
        request: GetGroupsRequest
      ): F[GetGroupsResponse]

      def getInsight(
        request: GetInsightRequest
      ): F[GetInsightResponse]

      def getInsightEvents(
        request: GetInsightEventsRequest
      ): F[GetInsightEventsResponse]

      def getInsightImpactGraph(
        request: GetInsightImpactGraphRequest
      ): F[GetInsightImpactGraphResponse]

      def getInsightSummaries(
        request: GetInsightSummariesRequest
      ): F[GetInsightSummariesResponse]

      def getSamplingRules(
        request: GetSamplingRulesRequest
      ): F[GetSamplingRulesResponse]

      def getSamplingStatisticSummaries(
        request: GetSamplingStatisticSummariesRequest
      ): F[GetSamplingStatisticSummariesResponse]

      def getSamplingTargets(
        request: GetSamplingTargetsRequest
      ): F[GetSamplingTargetsResponse]

      def getServiceGraph(
        request: GetServiceGraphRequest
      ): F[GetServiceGraphResponse]

      def getTimeSeriesServiceStatistics(
        request: GetTimeSeriesServiceStatisticsRequest
      ): F[GetTimeSeriesServiceStatisticsResponse]

      def getTraceGraph(
        request: GetTraceGraphRequest
      ): F[GetTraceGraphResponse]

      def getTraceSummaries(
        request: GetTraceSummariesRequest
      ): F[GetTraceSummariesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putEncryptionConfig(
        request: PutEncryptionConfigRequest
      ): F[PutEncryptionConfigResponse]

      def putTelemetryRecords(
        request: PutTelemetryRecordsRequest
      ): F[PutTelemetryRecordsResponse]

      def putTraceSegments(
        request: PutTraceSegmentsRequest
      ): F[PutTraceSegmentsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateGroup(
        request: UpdateGroupRequest
      ): F[UpdateGroupResponse]

      def updateSamplingRule(
        request: UpdateSamplingRuleRequest
      ): F[UpdateSamplingRuleResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends XRayOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchGetTracesOp(
      request: BatchGetTracesRequest
    ) extends XRayOp[BatchGetTracesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetTracesResponse] =
        visitor.batchGetTraces(request)
    }

    final case class CreateGroupOp(
      request: CreateGroupRequest
    ) extends XRayOp[CreateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupResponse] =
        visitor.createGroup(request)
    }

    final case class CreateSamplingRuleOp(
      request: CreateSamplingRuleRequest
    ) extends XRayOp[CreateSamplingRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSamplingRuleResponse] =
        visitor.createSamplingRule(request)
    }

    final case class DeleteGroupOp(
      request: DeleteGroupRequest
    ) extends XRayOp[DeleteGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupResponse] =
        visitor.deleteGroup(request)
    }

    final case class DeleteSamplingRuleOp(
      request: DeleteSamplingRuleRequest
    ) extends XRayOp[DeleteSamplingRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSamplingRuleResponse] =
        visitor.deleteSamplingRule(request)
    }

    final case class GetEncryptionConfigOp(
      request: GetEncryptionConfigRequest
    ) extends XRayOp[GetEncryptionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEncryptionConfigResponse] =
        visitor.getEncryptionConfig(request)
    }

    final case class GetGroupOp(
      request: GetGroupRequest
    ) extends XRayOp[GetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupResponse] =
        visitor.getGroup(request)
    }

    final case class GetGroupsOp(
      request: GetGroupsRequest
    ) extends XRayOp[GetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupsResponse] =
        visitor.getGroups(request)
    }

    final case class GetInsightOp(
      request: GetInsightRequest
    ) extends XRayOp[GetInsightResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightResponse] =
        visitor.getInsight(request)
    }

    final case class GetInsightEventsOp(
      request: GetInsightEventsRequest
    ) extends XRayOp[GetInsightEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightEventsResponse] =
        visitor.getInsightEvents(request)
    }

    final case class GetInsightImpactGraphOp(
      request: GetInsightImpactGraphRequest
    ) extends XRayOp[GetInsightImpactGraphResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightImpactGraphResponse] =
        visitor.getInsightImpactGraph(request)
    }

    final case class GetInsightSummariesOp(
      request: GetInsightSummariesRequest
    ) extends XRayOp[GetInsightSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightSummariesResponse] =
        visitor.getInsightSummaries(request)
    }

    final case class GetSamplingRulesOp(
      request: GetSamplingRulesRequest
    ) extends XRayOp[GetSamplingRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSamplingRulesResponse] =
        visitor.getSamplingRules(request)
    }

    final case class GetSamplingStatisticSummariesOp(
      request: GetSamplingStatisticSummariesRequest
    ) extends XRayOp[GetSamplingStatisticSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSamplingStatisticSummariesResponse] =
        visitor.getSamplingStatisticSummaries(request)
    }

    final case class GetSamplingTargetsOp(
      request: GetSamplingTargetsRequest
    ) extends XRayOp[GetSamplingTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSamplingTargetsResponse] =
        visitor.getSamplingTargets(request)
    }

    final case class GetServiceGraphOp(
      request: GetServiceGraphRequest
    ) extends XRayOp[GetServiceGraphResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceGraphResponse] =
        visitor.getServiceGraph(request)
    }

    final case class GetTimeSeriesServiceStatisticsOp(
      request: GetTimeSeriesServiceStatisticsRequest
    ) extends XRayOp[GetTimeSeriesServiceStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTimeSeriesServiceStatisticsResponse] =
        visitor.getTimeSeriesServiceStatistics(request)
    }

    final case class GetTraceGraphOp(
      request: GetTraceGraphRequest
    ) extends XRayOp[GetTraceGraphResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTraceGraphResponse] =
        visitor.getTraceGraph(request)
    }

    final case class GetTraceSummariesOp(
      request: GetTraceSummariesRequest
    ) extends XRayOp[GetTraceSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTraceSummariesResponse] =
        visitor.getTraceSummaries(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends XRayOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutEncryptionConfigOp(
      request: PutEncryptionConfigRequest
    ) extends XRayOp[PutEncryptionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEncryptionConfigResponse] =
        visitor.putEncryptionConfig(request)
    }

    final case class PutTelemetryRecordsOp(
      request: PutTelemetryRecordsRequest
    ) extends XRayOp[PutTelemetryRecordsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutTelemetryRecordsResponse] =
        visitor.putTelemetryRecords(request)
    }

    final case class PutTraceSegmentsOp(
      request: PutTraceSegmentsRequest
    ) extends XRayOp[PutTraceSegmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutTraceSegmentsResponse] =
        visitor.putTraceSegments(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends XRayOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends XRayOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateGroupOp(
      request: UpdateGroupRequest
    ) extends XRayOp[UpdateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupResponse] =
        visitor.updateGroup(request)
    }

    final case class UpdateSamplingRuleOp(
      request: UpdateSamplingRuleRequest
    ) extends XRayOp[UpdateSamplingRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSamplingRuleResponse] =
        visitor.updateSamplingRule(request)
    }
  }

  import XRayOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[XRayOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchGetTraces(
    request: BatchGetTracesRequest
  ): XRayIO[BatchGetTracesResponse] =
    FF.liftF(BatchGetTracesOp(request))

  def createGroup(
    request: CreateGroupRequest
  ): XRayIO[CreateGroupResponse] =
    FF.liftF(CreateGroupOp(request))

  def createSamplingRule(
    request: CreateSamplingRuleRequest
  ): XRayIO[CreateSamplingRuleResponse] =
    FF.liftF(CreateSamplingRuleOp(request))

  def deleteGroup(
    request: DeleteGroupRequest
  ): XRayIO[DeleteGroupResponse] =
    FF.liftF(DeleteGroupOp(request))

  def deleteSamplingRule(
    request: DeleteSamplingRuleRequest
  ): XRayIO[DeleteSamplingRuleResponse] =
    FF.liftF(DeleteSamplingRuleOp(request))

  def getEncryptionConfig(
    request: GetEncryptionConfigRequest
  ): XRayIO[GetEncryptionConfigResponse] =
    FF.liftF(GetEncryptionConfigOp(request))

  def getGroup(
    request: GetGroupRequest
  ): XRayIO[GetGroupResponse] =
    FF.liftF(GetGroupOp(request))

  def getGroups(
    request: GetGroupsRequest
  ): XRayIO[GetGroupsResponse] =
    FF.liftF(GetGroupsOp(request))

  def getInsight(
    request: GetInsightRequest
  ): XRayIO[GetInsightResponse] =
    FF.liftF(GetInsightOp(request))

  def getInsightEvents(
    request: GetInsightEventsRequest
  ): XRayIO[GetInsightEventsResponse] =
    FF.liftF(GetInsightEventsOp(request))

  def getInsightImpactGraph(
    request: GetInsightImpactGraphRequest
  ): XRayIO[GetInsightImpactGraphResponse] =
    FF.liftF(GetInsightImpactGraphOp(request))

  def getInsightSummaries(
    request: GetInsightSummariesRequest
  ): XRayIO[GetInsightSummariesResponse] =
    FF.liftF(GetInsightSummariesOp(request))

  def getSamplingRules(
    request: GetSamplingRulesRequest
  ): XRayIO[GetSamplingRulesResponse] =
    FF.liftF(GetSamplingRulesOp(request))

  def getSamplingStatisticSummaries(
    request: GetSamplingStatisticSummariesRequest
  ): XRayIO[GetSamplingStatisticSummariesResponse] =
    FF.liftF(GetSamplingStatisticSummariesOp(request))

  def getSamplingTargets(
    request: GetSamplingTargetsRequest
  ): XRayIO[GetSamplingTargetsResponse] =
    FF.liftF(GetSamplingTargetsOp(request))

  def getServiceGraph(
    request: GetServiceGraphRequest
  ): XRayIO[GetServiceGraphResponse] =
    FF.liftF(GetServiceGraphOp(request))

  def getTimeSeriesServiceStatistics(
    request: GetTimeSeriesServiceStatisticsRequest
  ): XRayIO[GetTimeSeriesServiceStatisticsResponse] =
    FF.liftF(GetTimeSeriesServiceStatisticsOp(request))

  def getTraceGraph(
    request: GetTraceGraphRequest
  ): XRayIO[GetTraceGraphResponse] =
    FF.liftF(GetTraceGraphOp(request))

  def getTraceSummaries(
    request: GetTraceSummariesRequest
  ): XRayIO[GetTraceSummariesResponse] =
    FF.liftF(GetTraceSummariesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): XRayIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putEncryptionConfig(
    request: PutEncryptionConfigRequest
  ): XRayIO[PutEncryptionConfigResponse] =
    FF.liftF(PutEncryptionConfigOp(request))

  def putTelemetryRecords(
    request: PutTelemetryRecordsRequest
  ): XRayIO[PutTelemetryRecordsResponse] =
    FF.liftF(PutTelemetryRecordsOp(request))

  def putTraceSegments(
    request: PutTraceSegmentsRequest
  ): XRayIO[PutTraceSegmentsResponse] =
    FF.liftF(PutTraceSegmentsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): XRayIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): XRayIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateGroup(
    request: UpdateGroupRequest
  ): XRayIO[UpdateGroupResponse] =
    FF.liftF(UpdateGroupOp(request))

  def updateSamplingRule(
    request: UpdateSamplingRuleRequest
  ): XRayIO[UpdateSamplingRuleResponse] =
    FF.liftF(UpdateSamplingRuleOp(request))
}
