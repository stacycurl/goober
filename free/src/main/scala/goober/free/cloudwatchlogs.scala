package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudwatchlogs.CloudWatchLogsClient
import software.amazon.awssdk.services.cloudwatchlogs.model._


object cloudwatchlogs { module =>

  // Free monad over CloudWatchLogsOp
  type CloudWatchLogsIO[A] = FF[CloudWatchLogsOp, A]

  sealed trait CloudWatchLogsOp[A] {
    def visit[F[_]](visitor: CloudWatchLogsOp.Visitor[F]): F[A]
  }

  object CloudWatchLogsOp {
    // Given a CloudWatchLogsClient we can embed a CloudWatchLogsIO program in any algebra that understands embedding.
    implicit val CloudWatchLogsOpEmbeddable: Embeddable[CloudWatchLogsOp, CloudWatchLogsClient] = new Embeddable[CloudWatchLogsOp, CloudWatchLogsClient] {
      def embed[A](client: CloudWatchLogsClient, io: CloudWatchLogsIO[A]): Embedded[A] = Embedded.CloudWatchLogs(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudWatchLogsOp.Visitor[Kleisli[M, CloudWatchLogsClient, *]] {
        def associateKmsKey(
          request: AssociateKmsKeyRequest
        ): Kleisli[M, CloudWatchLogsClient, AssociateKmsKeyResponse] =
          primitive(_.associateKmsKey(request))

        def cancelExportTask(
          request: CancelExportTaskRequest
        ): Kleisli[M, CloudWatchLogsClient, CancelExportTaskResponse] =
          primitive(_.cancelExportTask(request))

        def createExportTask(
          request: CreateExportTaskRequest
        ): Kleisli[M, CloudWatchLogsClient, CreateExportTaskResponse] =
          primitive(_.createExportTask(request))

        def createLogGroup(
          request: CreateLogGroupRequest
        ): Kleisli[M, CloudWatchLogsClient, CreateLogGroupResponse] =
          primitive(_.createLogGroup(request))

        def createLogStream(
          request: CreateLogStreamRequest
        ): Kleisli[M, CloudWatchLogsClient, CreateLogStreamResponse] =
          primitive(_.createLogStream(request))

        def deleteDestination(
          request: DeleteDestinationRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteDestinationResponse] =
          primitive(_.deleteDestination(request))

        def deleteLogGroup(
          request: DeleteLogGroupRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteLogGroupResponse] =
          primitive(_.deleteLogGroup(request))

        def deleteLogStream(
          request: DeleteLogStreamRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteLogStreamResponse] =
          primitive(_.deleteLogStream(request))

        def deleteMetricFilter(
          request: DeleteMetricFilterRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteMetricFilterResponse] =
          primitive(_.deleteMetricFilter(request))

        def deleteQueryDefinition(
          request: DeleteQueryDefinitionRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteQueryDefinitionResponse] =
          primitive(_.deleteQueryDefinition(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteRetentionPolicy(
          request: DeleteRetentionPolicyRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteRetentionPolicyResponse] =
          primitive(_.deleteRetentionPolicy(request))

        def deleteSubscriptionFilter(
          request: DeleteSubscriptionFilterRequest
        ): Kleisli[M, CloudWatchLogsClient, DeleteSubscriptionFilterResponse] =
          primitive(_.deleteSubscriptionFilter(request))

        def describeDestinations(
          request: DescribeDestinationsRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeDestinationsResponse] =
          primitive(_.describeDestinations(request))

        def describeExportTasks(
          request: DescribeExportTasksRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeExportTasksResponse] =
          primitive(_.describeExportTasks(request))

        def describeLogGroups(
          request: DescribeLogGroupsRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeLogGroupsResponse] =
          primitive(_.describeLogGroups(request))

        def describeLogStreams(
          request: DescribeLogStreamsRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeLogStreamsResponse] =
          primitive(_.describeLogStreams(request))

        def describeMetricFilters(
          request: DescribeMetricFiltersRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeMetricFiltersResponse] =
          primitive(_.describeMetricFilters(request))

        def describeQueries(
          request: DescribeQueriesRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeQueriesResponse] =
          primitive(_.describeQueries(request))

        def describeQueryDefinitions(
          request: DescribeQueryDefinitionsRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeQueryDefinitionsResponse] =
          primitive(_.describeQueryDefinitions(request))

        def describeResourcePolicies(
          request: DescribeResourcePoliciesRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeResourcePoliciesResponse] =
          primitive(_.describeResourcePolicies(request))

        def describeSubscriptionFilters(
          request: DescribeSubscriptionFiltersRequest
        ): Kleisli[M, CloudWatchLogsClient, DescribeSubscriptionFiltersResponse] =
          primitive(_.describeSubscriptionFilters(request))

        def disassociateKmsKey(
          request: DisassociateKmsKeyRequest
        ): Kleisli[M, CloudWatchLogsClient, DisassociateKmsKeyResponse] =
          primitive(_.disassociateKmsKey(request))

        def filterLogEvents(
          request: FilterLogEventsRequest
        ): Kleisli[M, CloudWatchLogsClient, FilterLogEventsResponse] =
          primitive(_.filterLogEvents(request))

        def getLogEvents(
          request: GetLogEventsRequest
        ): Kleisli[M, CloudWatchLogsClient, GetLogEventsResponse] =
          primitive(_.getLogEvents(request))

        def getLogGroupFields(
          request: GetLogGroupFieldsRequest
        ): Kleisli[M, CloudWatchLogsClient, GetLogGroupFieldsResponse] =
          primitive(_.getLogGroupFields(request))

        def getLogRecord(
          request: GetLogRecordRequest
        ): Kleisli[M, CloudWatchLogsClient, GetLogRecordResponse] =
          primitive(_.getLogRecord(request))

        def getQueryResults(
          request: GetQueryResultsRequest
        ): Kleisli[M, CloudWatchLogsClient, GetQueryResultsResponse] =
          primitive(_.getQueryResults(request))

        def listTagsLogGroup(
          request: ListTagsLogGroupRequest
        ): Kleisli[M, CloudWatchLogsClient, ListTagsLogGroupResponse] =
          primitive(_.listTagsLogGroup(request))

        def putDestination(
          request: PutDestinationRequest
        ): Kleisli[M, CloudWatchLogsClient, PutDestinationResponse] =
          primitive(_.putDestination(request))

        def putDestinationPolicy(
          request: PutDestinationPolicyRequest
        ): Kleisli[M, CloudWatchLogsClient, PutDestinationPolicyResponse] =
          primitive(_.putDestinationPolicy(request))

        def putLogEvents(
          request: PutLogEventsRequest
        ): Kleisli[M, CloudWatchLogsClient, PutLogEventsResponse] =
          primitive(_.putLogEvents(request))

        def putMetricFilter(
          request: PutMetricFilterRequest
        ): Kleisli[M, CloudWatchLogsClient, PutMetricFilterResponse] =
          primitive(_.putMetricFilter(request))

        def putQueryDefinition(
          request: PutQueryDefinitionRequest
        ): Kleisli[M, CloudWatchLogsClient, PutQueryDefinitionResponse] =
          primitive(_.putQueryDefinition(request))

        def putResourcePolicy(
          request: PutResourcePolicyRequest
        ): Kleisli[M, CloudWatchLogsClient, PutResourcePolicyResponse] =
          primitive(_.putResourcePolicy(request))

        def putRetentionPolicy(
          request: PutRetentionPolicyRequest
        ): Kleisli[M, CloudWatchLogsClient, PutRetentionPolicyResponse] =
          primitive(_.putRetentionPolicy(request))

        def putSubscriptionFilter(
          request: PutSubscriptionFilterRequest
        ): Kleisli[M, CloudWatchLogsClient, PutSubscriptionFilterResponse] =
          primitive(_.putSubscriptionFilter(request))

        def startQuery(
          request: StartQueryRequest
        ): Kleisli[M, CloudWatchLogsClient, StartQueryResponse] =
          primitive(_.startQuery(request))

        def stopQuery(
          request: StopQueryRequest
        ): Kleisli[M, CloudWatchLogsClient, StopQueryResponse] =
          primitive(_.stopQuery(request))

        def tagLogGroup(
          request: TagLogGroupRequest
        ): Kleisli[M, CloudWatchLogsClient, TagLogGroupResponse] =
          primitive(_.tagLogGroup(request))

        def testMetricFilter(
          request: TestMetricFilterRequest
        ): Kleisli[M, CloudWatchLogsClient, TestMetricFilterResponse] =
          primitive(_.testMetricFilter(request))

        def untagLogGroup(
          request: UntagLogGroupRequest
        ): Kleisli[M, CloudWatchLogsClient, UntagLogGroupResponse] =
          primitive(_.untagLogGroup(request))

        def primitive[A](
          f: CloudWatchLogsClient => A
        ): Kleisli[M, CloudWatchLogsClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudWatchLogsOp ~> F) {
      final def apply[A](op: CloudWatchLogsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateKmsKey(
        request: AssociateKmsKeyRequest
      ): F[AssociateKmsKeyResponse]

      def cancelExportTask(
        request: CancelExportTaskRequest
      ): F[CancelExportTaskResponse]

      def createExportTask(
        request: CreateExportTaskRequest
      ): F[CreateExportTaskResponse]

      def createLogGroup(
        request: CreateLogGroupRequest
      ): F[CreateLogGroupResponse]

      def createLogStream(
        request: CreateLogStreamRequest
      ): F[CreateLogStreamResponse]

      def deleteDestination(
        request: DeleteDestinationRequest
      ): F[DeleteDestinationResponse]

      def deleteLogGroup(
        request: DeleteLogGroupRequest
      ): F[DeleteLogGroupResponse]

      def deleteLogStream(
        request: DeleteLogStreamRequest
      ): F[DeleteLogStreamResponse]

      def deleteMetricFilter(
        request: DeleteMetricFilterRequest
      ): F[DeleteMetricFilterResponse]

      def deleteQueryDefinition(
        request: DeleteQueryDefinitionRequest
      ): F[DeleteQueryDefinitionResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteRetentionPolicy(
        request: DeleteRetentionPolicyRequest
      ): F[DeleteRetentionPolicyResponse]

      def deleteSubscriptionFilter(
        request: DeleteSubscriptionFilterRequest
      ): F[DeleteSubscriptionFilterResponse]

      def describeDestinations(
        request: DescribeDestinationsRequest
      ): F[DescribeDestinationsResponse]

      def describeExportTasks(
        request: DescribeExportTasksRequest
      ): F[DescribeExportTasksResponse]

      def describeLogGroups(
        request: DescribeLogGroupsRequest
      ): F[DescribeLogGroupsResponse]

      def describeLogStreams(
        request: DescribeLogStreamsRequest
      ): F[DescribeLogStreamsResponse]

      def describeMetricFilters(
        request: DescribeMetricFiltersRequest
      ): F[DescribeMetricFiltersResponse]

      def describeQueries(
        request: DescribeQueriesRequest
      ): F[DescribeQueriesResponse]

      def describeQueryDefinitions(
        request: DescribeQueryDefinitionsRequest
      ): F[DescribeQueryDefinitionsResponse]

      def describeResourcePolicies(
        request: DescribeResourcePoliciesRequest
      ): F[DescribeResourcePoliciesResponse]

      def describeSubscriptionFilters(
        request: DescribeSubscriptionFiltersRequest
      ): F[DescribeSubscriptionFiltersResponse]

      def disassociateKmsKey(
        request: DisassociateKmsKeyRequest
      ): F[DisassociateKmsKeyResponse]

      def filterLogEvents(
        request: FilterLogEventsRequest
      ): F[FilterLogEventsResponse]

      def getLogEvents(
        request: GetLogEventsRequest
      ): F[GetLogEventsResponse]

      def getLogGroupFields(
        request: GetLogGroupFieldsRequest
      ): F[GetLogGroupFieldsResponse]

      def getLogRecord(
        request: GetLogRecordRequest
      ): F[GetLogRecordResponse]

      def getQueryResults(
        request: GetQueryResultsRequest
      ): F[GetQueryResultsResponse]

      def listTagsLogGroup(
        request: ListTagsLogGroupRequest
      ): F[ListTagsLogGroupResponse]

      def putDestination(
        request: PutDestinationRequest
      ): F[PutDestinationResponse]

      def putDestinationPolicy(
        request: PutDestinationPolicyRequest
      ): F[PutDestinationPolicyResponse]

      def putLogEvents(
        request: PutLogEventsRequest
      ): F[PutLogEventsResponse]

      def putMetricFilter(
        request: PutMetricFilterRequest
      ): F[PutMetricFilterResponse]

      def putQueryDefinition(
        request: PutQueryDefinitionRequest
      ): F[PutQueryDefinitionResponse]

      def putResourcePolicy(
        request: PutResourcePolicyRequest
      ): F[PutResourcePolicyResponse]

      def putRetentionPolicy(
        request: PutRetentionPolicyRequest
      ): F[PutRetentionPolicyResponse]

      def putSubscriptionFilter(
        request: PutSubscriptionFilterRequest
      ): F[PutSubscriptionFilterResponse]

      def startQuery(
        request: StartQueryRequest
      ): F[StartQueryResponse]

      def stopQuery(
        request: StopQueryRequest
      ): F[StopQueryResponse]

      def tagLogGroup(
        request: TagLogGroupRequest
      ): F[TagLogGroupResponse]

      def testMetricFilter(
        request: TestMetricFilterRequest
      ): F[TestMetricFilterResponse]

      def untagLogGroup(
        request: UntagLogGroupRequest
      ): F[UntagLogGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudWatchLogsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateKmsKeyOp(
      request: AssociateKmsKeyRequest
    ) extends CloudWatchLogsOp[AssociateKmsKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateKmsKeyResponse] =
        visitor.associateKmsKey(request)
    }

    final case class CancelExportTaskOp(
      request: CancelExportTaskRequest
    ) extends CloudWatchLogsOp[CancelExportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelExportTaskResponse] =
        visitor.cancelExportTask(request)
    }

    final case class CreateExportTaskOp(
      request: CreateExportTaskRequest
    ) extends CloudWatchLogsOp[CreateExportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateExportTaskResponse] =
        visitor.createExportTask(request)
    }

    final case class CreateLogGroupOp(
      request: CreateLogGroupRequest
    ) extends CloudWatchLogsOp[CreateLogGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLogGroupResponse] =
        visitor.createLogGroup(request)
    }

    final case class CreateLogStreamOp(
      request: CreateLogStreamRequest
    ) extends CloudWatchLogsOp[CreateLogStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLogStreamResponse] =
        visitor.createLogStream(request)
    }

    final case class DeleteDestinationOp(
      request: DeleteDestinationRequest
    ) extends CloudWatchLogsOp[DeleteDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDestinationResponse] =
        visitor.deleteDestination(request)
    }

    final case class DeleteLogGroupOp(
      request: DeleteLogGroupRequest
    ) extends CloudWatchLogsOp[DeleteLogGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLogGroupResponse] =
        visitor.deleteLogGroup(request)
    }

    final case class DeleteLogStreamOp(
      request: DeleteLogStreamRequest
    ) extends CloudWatchLogsOp[DeleteLogStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLogStreamResponse] =
        visitor.deleteLogStream(request)
    }

    final case class DeleteMetricFilterOp(
      request: DeleteMetricFilterRequest
    ) extends CloudWatchLogsOp[DeleteMetricFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMetricFilterResponse] =
        visitor.deleteMetricFilter(request)
    }

    final case class DeleteQueryDefinitionOp(
      request: DeleteQueryDefinitionRequest
    ) extends CloudWatchLogsOp[DeleteQueryDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQueryDefinitionResponse] =
        visitor.deleteQueryDefinition(request)
    }

    final case class DeleteResourcePolicyOp(
      request: DeleteResourcePolicyRequest
    ) extends CloudWatchLogsOp[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteRetentionPolicyOp(
      request: DeleteRetentionPolicyRequest
    ) extends CloudWatchLogsOp[DeleteRetentionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRetentionPolicyResponse] =
        visitor.deleteRetentionPolicy(request)
    }

    final case class DeleteSubscriptionFilterOp(
      request: DeleteSubscriptionFilterRequest
    ) extends CloudWatchLogsOp[DeleteSubscriptionFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSubscriptionFilterResponse] =
        visitor.deleteSubscriptionFilter(request)
    }

    final case class DescribeDestinationsOp(
      request: DescribeDestinationsRequest
    ) extends CloudWatchLogsOp[DescribeDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDestinationsResponse] =
        visitor.describeDestinations(request)
    }

    final case class DescribeExportTasksOp(
      request: DescribeExportTasksRequest
    ) extends CloudWatchLogsOp[DescribeExportTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExportTasksResponse] =
        visitor.describeExportTasks(request)
    }

    final case class DescribeLogGroupsOp(
      request: DescribeLogGroupsRequest
    ) extends CloudWatchLogsOp[DescribeLogGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLogGroupsResponse] =
        visitor.describeLogGroups(request)
    }

    final case class DescribeLogStreamsOp(
      request: DescribeLogStreamsRequest
    ) extends CloudWatchLogsOp[DescribeLogStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLogStreamsResponse] =
        visitor.describeLogStreams(request)
    }

    final case class DescribeMetricFiltersOp(
      request: DescribeMetricFiltersRequest
    ) extends CloudWatchLogsOp[DescribeMetricFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMetricFiltersResponse] =
        visitor.describeMetricFilters(request)
    }

    final case class DescribeQueriesOp(
      request: DescribeQueriesRequest
    ) extends CloudWatchLogsOp[DescribeQueriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeQueriesResponse] =
        visitor.describeQueries(request)
    }

    final case class DescribeQueryDefinitionsOp(
      request: DescribeQueryDefinitionsRequest
    ) extends CloudWatchLogsOp[DescribeQueryDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeQueryDefinitionsResponse] =
        visitor.describeQueryDefinitions(request)
    }

    final case class DescribeResourcePoliciesOp(
      request: DescribeResourcePoliciesRequest
    ) extends CloudWatchLogsOp[DescribeResourcePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourcePoliciesResponse] =
        visitor.describeResourcePolicies(request)
    }

    final case class DescribeSubscriptionFiltersOp(
      request: DescribeSubscriptionFiltersRequest
    ) extends CloudWatchLogsOp[DescribeSubscriptionFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSubscriptionFiltersResponse] =
        visitor.describeSubscriptionFilters(request)
    }

    final case class DisassociateKmsKeyOp(
      request: DisassociateKmsKeyRequest
    ) extends CloudWatchLogsOp[DisassociateKmsKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateKmsKeyResponse] =
        visitor.disassociateKmsKey(request)
    }

    final case class FilterLogEventsOp(
      request: FilterLogEventsRequest
    ) extends CloudWatchLogsOp[FilterLogEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FilterLogEventsResponse] =
        visitor.filterLogEvents(request)
    }

    final case class GetLogEventsOp(
      request: GetLogEventsRequest
    ) extends CloudWatchLogsOp[GetLogEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLogEventsResponse] =
        visitor.getLogEvents(request)
    }

    final case class GetLogGroupFieldsOp(
      request: GetLogGroupFieldsRequest
    ) extends CloudWatchLogsOp[GetLogGroupFieldsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLogGroupFieldsResponse] =
        visitor.getLogGroupFields(request)
    }

    final case class GetLogRecordOp(
      request: GetLogRecordRequest
    ) extends CloudWatchLogsOp[GetLogRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLogRecordResponse] =
        visitor.getLogRecord(request)
    }

    final case class GetQueryResultsOp(
      request: GetQueryResultsRequest
    ) extends CloudWatchLogsOp[GetQueryResultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQueryResultsResponse] =
        visitor.getQueryResults(request)
    }

    final case class ListTagsLogGroupOp(
      request: ListTagsLogGroupRequest
    ) extends CloudWatchLogsOp[ListTagsLogGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsLogGroupResponse] =
        visitor.listTagsLogGroup(request)
    }

    final case class PutDestinationOp(
      request: PutDestinationRequest
    ) extends CloudWatchLogsOp[PutDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDestinationResponse] =
        visitor.putDestination(request)
    }

    final case class PutDestinationPolicyOp(
      request: PutDestinationPolicyRequest
    ) extends CloudWatchLogsOp[PutDestinationPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDestinationPolicyResponse] =
        visitor.putDestinationPolicy(request)
    }

    final case class PutLogEventsOp(
      request: PutLogEventsRequest
    ) extends CloudWatchLogsOp[PutLogEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLogEventsResponse] =
        visitor.putLogEvents(request)
    }

    final case class PutMetricFilterOp(
      request: PutMetricFilterRequest
    ) extends CloudWatchLogsOp[PutMetricFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMetricFilterResponse] =
        visitor.putMetricFilter(request)
    }

    final case class PutQueryDefinitionOp(
      request: PutQueryDefinitionRequest
    ) extends CloudWatchLogsOp[PutQueryDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutQueryDefinitionResponse] =
        visitor.putQueryDefinition(request)
    }

    final case class PutResourcePolicyOp(
      request: PutResourcePolicyRequest
    ) extends CloudWatchLogsOp[PutResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourcePolicyResponse] =
        visitor.putResourcePolicy(request)
    }

    final case class PutRetentionPolicyOp(
      request: PutRetentionPolicyRequest
    ) extends CloudWatchLogsOp[PutRetentionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRetentionPolicyResponse] =
        visitor.putRetentionPolicy(request)
    }

    final case class PutSubscriptionFilterOp(
      request: PutSubscriptionFilterRequest
    ) extends CloudWatchLogsOp[PutSubscriptionFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSubscriptionFilterResponse] =
        visitor.putSubscriptionFilter(request)
    }

    final case class StartQueryOp(
      request: StartQueryRequest
    ) extends CloudWatchLogsOp[StartQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartQueryResponse] =
        visitor.startQuery(request)
    }

    final case class StopQueryOp(
      request: StopQueryRequest
    ) extends CloudWatchLogsOp[StopQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopQueryResponse] =
        visitor.stopQuery(request)
    }

    final case class TagLogGroupOp(
      request: TagLogGroupRequest
    ) extends CloudWatchLogsOp[TagLogGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagLogGroupResponse] =
        visitor.tagLogGroup(request)
    }

    final case class TestMetricFilterOp(
      request: TestMetricFilterRequest
    ) extends CloudWatchLogsOp[TestMetricFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestMetricFilterResponse] =
        visitor.testMetricFilter(request)
    }

    final case class UntagLogGroupOp(
      request: UntagLogGroupRequest
    ) extends CloudWatchLogsOp[UntagLogGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagLogGroupResponse] =
        visitor.untagLogGroup(request)
    }
  }

  import CloudWatchLogsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudWatchLogsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateKmsKey(
    request: AssociateKmsKeyRequest
  ): CloudWatchLogsIO[AssociateKmsKeyResponse] =
    FF.liftF(AssociateKmsKeyOp(request))

  def cancelExportTask(
    request: CancelExportTaskRequest
  ): CloudWatchLogsIO[CancelExportTaskResponse] =
    FF.liftF(CancelExportTaskOp(request))

  def createExportTask(
    request: CreateExportTaskRequest
  ): CloudWatchLogsIO[CreateExportTaskResponse] =
    FF.liftF(CreateExportTaskOp(request))

  def createLogGroup(
    request: CreateLogGroupRequest
  ): CloudWatchLogsIO[CreateLogGroupResponse] =
    FF.liftF(CreateLogGroupOp(request))

  def createLogStream(
    request: CreateLogStreamRequest
  ): CloudWatchLogsIO[CreateLogStreamResponse] =
    FF.liftF(CreateLogStreamOp(request))

  def deleteDestination(
    request: DeleteDestinationRequest
  ): CloudWatchLogsIO[DeleteDestinationResponse] =
    FF.liftF(DeleteDestinationOp(request))

  def deleteLogGroup(
    request: DeleteLogGroupRequest
  ): CloudWatchLogsIO[DeleteLogGroupResponse] =
    FF.liftF(DeleteLogGroupOp(request))

  def deleteLogStream(
    request: DeleteLogStreamRequest
  ): CloudWatchLogsIO[DeleteLogStreamResponse] =
    FF.liftF(DeleteLogStreamOp(request))

  def deleteMetricFilter(
    request: DeleteMetricFilterRequest
  ): CloudWatchLogsIO[DeleteMetricFilterResponse] =
    FF.liftF(DeleteMetricFilterOp(request))

  def deleteQueryDefinition(
    request: DeleteQueryDefinitionRequest
  ): CloudWatchLogsIO[DeleteQueryDefinitionResponse] =
    FF.liftF(DeleteQueryDefinitionOp(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): CloudWatchLogsIO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicyOp(request))

  def deleteRetentionPolicy(
    request: DeleteRetentionPolicyRequest
  ): CloudWatchLogsIO[DeleteRetentionPolicyResponse] =
    FF.liftF(DeleteRetentionPolicyOp(request))

  def deleteSubscriptionFilter(
    request: DeleteSubscriptionFilterRequest
  ): CloudWatchLogsIO[DeleteSubscriptionFilterResponse] =
    FF.liftF(DeleteSubscriptionFilterOp(request))

  def describeDestinations(
    request: DescribeDestinationsRequest
  ): CloudWatchLogsIO[DescribeDestinationsResponse] =
    FF.liftF(DescribeDestinationsOp(request))

  def describeExportTasks(
    request: DescribeExportTasksRequest
  ): CloudWatchLogsIO[DescribeExportTasksResponse] =
    FF.liftF(DescribeExportTasksOp(request))

  def describeLogGroups(
    request: DescribeLogGroupsRequest
  ): CloudWatchLogsIO[DescribeLogGroupsResponse] =
    FF.liftF(DescribeLogGroupsOp(request))

  def describeLogStreams(
    request: DescribeLogStreamsRequest
  ): CloudWatchLogsIO[DescribeLogStreamsResponse] =
    FF.liftF(DescribeLogStreamsOp(request))

  def describeMetricFilters(
    request: DescribeMetricFiltersRequest
  ): CloudWatchLogsIO[DescribeMetricFiltersResponse] =
    FF.liftF(DescribeMetricFiltersOp(request))

  def describeQueries(
    request: DescribeQueriesRequest
  ): CloudWatchLogsIO[DescribeQueriesResponse] =
    FF.liftF(DescribeQueriesOp(request))

  def describeQueryDefinitions(
    request: DescribeQueryDefinitionsRequest
  ): CloudWatchLogsIO[DescribeQueryDefinitionsResponse] =
    FF.liftF(DescribeQueryDefinitionsOp(request))

  def describeResourcePolicies(
    request: DescribeResourcePoliciesRequest
  ): CloudWatchLogsIO[DescribeResourcePoliciesResponse] =
    FF.liftF(DescribeResourcePoliciesOp(request))

  def describeSubscriptionFilters(
    request: DescribeSubscriptionFiltersRequest
  ): CloudWatchLogsIO[DescribeSubscriptionFiltersResponse] =
    FF.liftF(DescribeSubscriptionFiltersOp(request))

  def disassociateKmsKey(
    request: DisassociateKmsKeyRequest
  ): CloudWatchLogsIO[DisassociateKmsKeyResponse] =
    FF.liftF(DisassociateKmsKeyOp(request))

  def filterLogEvents(
    request: FilterLogEventsRequest
  ): CloudWatchLogsIO[FilterLogEventsResponse] =
    FF.liftF(FilterLogEventsOp(request))

  def getLogEvents(
    request: GetLogEventsRequest
  ): CloudWatchLogsIO[GetLogEventsResponse] =
    FF.liftF(GetLogEventsOp(request))

  def getLogGroupFields(
    request: GetLogGroupFieldsRequest
  ): CloudWatchLogsIO[GetLogGroupFieldsResponse] =
    FF.liftF(GetLogGroupFieldsOp(request))

  def getLogRecord(
    request: GetLogRecordRequest
  ): CloudWatchLogsIO[GetLogRecordResponse] =
    FF.liftF(GetLogRecordOp(request))

  def getQueryResults(
    request: GetQueryResultsRequest
  ): CloudWatchLogsIO[GetQueryResultsResponse] =
    FF.liftF(GetQueryResultsOp(request))

  def listTagsLogGroup(
    request: ListTagsLogGroupRequest
  ): CloudWatchLogsIO[ListTagsLogGroupResponse] =
    FF.liftF(ListTagsLogGroupOp(request))

  def putDestination(
    request: PutDestinationRequest
  ): CloudWatchLogsIO[PutDestinationResponse] =
    FF.liftF(PutDestinationOp(request))

  def putDestinationPolicy(
    request: PutDestinationPolicyRequest
  ): CloudWatchLogsIO[PutDestinationPolicyResponse] =
    FF.liftF(PutDestinationPolicyOp(request))

  def putLogEvents(
    request: PutLogEventsRequest
  ): CloudWatchLogsIO[PutLogEventsResponse] =
    FF.liftF(PutLogEventsOp(request))

  def putMetricFilter(
    request: PutMetricFilterRequest
  ): CloudWatchLogsIO[PutMetricFilterResponse] =
    FF.liftF(PutMetricFilterOp(request))

  def putQueryDefinition(
    request: PutQueryDefinitionRequest
  ): CloudWatchLogsIO[PutQueryDefinitionResponse] =
    FF.liftF(PutQueryDefinitionOp(request))

  def putResourcePolicy(
    request: PutResourcePolicyRequest
  ): CloudWatchLogsIO[PutResourcePolicyResponse] =
    FF.liftF(PutResourcePolicyOp(request))

  def putRetentionPolicy(
    request: PutRetentionPolicyRequest
  ): CloudWatchLogsIO[PutRetentionPolicyResponse] =
    FF.liftF(PutRetentionPolicyOp(request))

  def putSubscriptionFilter(
    request: PutSubscriptionFilterRequest
  ): CloudWatchLogsIO[PutSubscriptionFilterResponse] =
    FF.liftF(PutSubscriptionFilterOp(request))

  def startQuery(
    request: StartQueryRequest
  ): CloudWatchLogsIO[StartQueryResponse] =
    FF.liftF(StartQueryOp(request))

  def stopQuery(
    request: StopQueryRequest
  ): CloudWatchLogsIO[StopQueryResponse] =
    FF.liftF(StopQueryOp(request))

  def tagLogGroup(
    request: TagLogGroupRequest
  ): CloudWatchLogsIO[TagLogGroupResponse] =
    FF.liftF(TagLogGroupOp(request))

  def testMetricFilter(
    request: TestMetricFilterRequest
  ): CloudWatchLogsIO[TestMetricFilterResponse] =
    FF.liftF(TestMetricFilterOp(request))

  def untagLogGroup(
    request: UntagLogGroupRequest
  ): CloudWatchLogsIO[UntagLogGroupResponse] =
    FF.liftF(UntagLogGroupOp(request))
}
