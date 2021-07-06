package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.databasemigration.DatabaseMigrationClient
import software.amazon.awssdk.services.databasemigration.model._


object databasemigration { module =>

  // Free monad over DatabaseMigrationOp
  type DatabaseMigrationIO[A] = FF[DatabaseMigrationOp, A]

  sealed trait DatabaseMigrationOp[A] {
    def visit[F[_]](visitor: DatabaseMigrationOp.Visitor[F]): F[A]
  }

  object DatabaseMigrationOp {
    // Given a DatabaseMigrationClient we can embed a DatabaseMigrationIO program in any algebra that understands embedding.
    implicit val DatabaseMigrationOpEmbeddable: Embeddable[DatabaseMigrationOp, DatabaseMigrationClient] = new Embeddable[DatabaseMigrationOp, DatabaseMigrationClient] {
      def embed[A](client: DatabaseMigrationClient, io: DatabaseMigrationIO[A]): Embedded[A] = Embedded.DatabaseMigration(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DatabaseMigrationOp.Visitor[Kleisli[M, DatabaseMigrationClient, *]] {
        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, DatabaseMigrationClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def applyPendingMaintenanceAction(
          request: ApplyPendingMaintenanceActionRequest
        ): Kleisli[M, DatabaseMigrationClient, ApplyPendingMaintenanceActionResponse] =
          primitive(_.applyPendingMaintenanceAction(request))

        def cancelReplicationTaskAssessmentRun(
          request: CancelReplicationTaskAssessmentRunRequest
        ): Kleisli[M, DatabaseMigrationClient, CancelReplicationTaskAssessmentRunResponse] =
          primitive(_.cancelReplicationTaskAssessmentRun(request))

        def createEndpoint(
          request: CreateEndpointRequest
        ): Kleisli[M, DatabaseMigrationClient, CreateEndpointResponse] =
          primitive(_.createEndpoint(request))

        def createEventSubscription(
          request: CreateEventSubscriptionRequest
        ): Kleisli[M, DatabaseMigrationClient, CreateEventSubscriptionResponse] =
          primitive(_.createEventSubscription(request))

        def createReplicationInstance(
          request: CreateReplicationInstanceRequest
        ): Kleisli[M, DatabaseMigrationClient, CreateReplicationInstanceResponse] =
          primitive(_.createReplicationInstance(request))

        def createReplicationSubnetGroup(
          request: CreateReplicationSubnetGroupRequest
        ): Kleisli[M, DatabaseMigrationClient, CreateReplicationSubnetGroupResponse] =
          primitive(_.createReplicationSubnetGroup(request))

        def createReplicationTask(
          request: CreateReplicationTaskRequest
        ): Kleisli[M, DatabaseMigrationClient, CreateReplicationTaskResponse] =
          primitive(_.createReplicationTask(request))

        def deleteCertificate(
          request: DeleteCertificateRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteCertificateResponse] =
          primitive(_.deleteCertificate(request))

        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def deleteEndpoint(
          request: DeleteEndpointRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteEndpointResponse] =
          primitive(_.deleteEndpoint(request))

        def deleteEventSubscription(
          request: DeleteEventSubscriptionRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteEventSubscriptionResponse] =
          primitive(_.deleteEventSubscription(request))

        def deleteReplicationInstance(
          request: DeleteReplicationInstanceRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteReplicationInstanceResponse] =
          primitive(_.deleteReplicationInstance(request))

        def deleteReplicationSubnetGroup(
          request: DeleteReplicationSubnetGroupRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteReplicationSubnetGroupResponse] =
          primitive(_.deleteReplicationSubnetGroup(request))

        def deleteReplicationTask(
          request: DeleteReplicationTaskRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteReplicationTaskResponse] =
          primitive(_.deleteReplicationTask(request))

        def deleteReplicationTaskAssessmentRun(
          request: DeleteReplicationTaskAssessmentRunRequest
        ): Kleisli[M, DatabaseMigrationClient, DeleteReplicationTaskAssessmentRunResponse] =
          primitive(_.deleteReplicationTaskAssessmentRun(request))

        def describeAccountAttributes(
          request: DescribeAccountAttributesRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeAccountAttributesResponse] =
          primitive(_.describeAccountAttributes(request))

        def describeApplicableIndividualAssessments(
          request: DescribeApplicableIndividualAssessmentsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeApplicableIndividualAssessmentsResponse] =
          primitive(_.describeApplicableIndividualAssessments(request))

        def describeCertificates(
          request: DescribeCertificatesRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeCertificatesResponse] =
          primitive(_.describeCertificates(request))

        def describeConnections(
          request: DescribeConnectionsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeConnectionsResponse] =
          primitive(_.describeConnections(request))

        def describeEndpointSettings(
          request: DescribeEndpointSettingsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeEndpointSettingsResponse] =
          primitive(_.describeEndpointSettings(request))

        def describeEndpointTypes(
          request: DescribeEndpointTypesRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeEndpointTypesResponse] =
          primitive(_.describeEndpointTypes(request))

        def describeEndpoints(
          request: DescribeEndpointsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeEndpointsResponse] =
          primitive(_.describeEndpoints(request))

        def describeEventCategories(
          request: DescribeEventCategoriesRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeEventCategoriesResponse] =
          primitive(_.describeEventCategories(request))

        def describeEventSubscriptions(
          request: DescribeEventSubscriptionsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeEventSubscriptionsResponse] =
          primitive(_.describeEventSubscriptions(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeOrderableReplicationInstances(
          request: DescribeOrderableReplicationInstancesRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeOrderableReplicationInstancesResponse] =
          primitive(_.describeOrderableReplicationInstances(request))

        def describePendingMaintenanceActions(
          request: DescribePendingMaintenanceActionsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribePendingMaintenanceActionsResponse] =
          primitive(_.describePendingMaintenanceActions(request))

        def describeRefreshSchemasStatus(
          request: DescribeRefreshSchemasStatusRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeRefreshSchemasStatusResponse] =
          primitive(_.describeRefreshSchemasStatus(request))

        def describeReplicationInstanceTaskLogs(
          request: DescribeReplicationInstanceTaskLogsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeReplicationInstanceTaskLogsResponse] =
          primitive(_.describeReplicationInstanceTaskLogs(request))

        def describeReplicationInstances(
          request: DescribeReplicationInstancesRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeReplicationInstancesResponse] =
          primitive(_.describeReplicationInstances(request))

        def describeReplicationSubnetGroups(
          request: DescribeReplicationSubnetGroupsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeReplicationSubnetGroupsResponse] =
          primitive(_.describeReplicationSubnetGroups(request))

        def describeReplicationTaskAssessmentResults(
          request: DescribeReplicationTaskAssessmentResultsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeReplicationTaskAssessmentResultsResponse] =
          primitive(_.describeReplicationTaskAssessmentResults(request))

        def describeReplicationTaskAssessmentRuns(
          request: DescribeReplicationTaskAssessmentRunsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeReplicationTaskAssessmentRunsResponse] =
          primitive(_.describeReplicationTaskAssessmentRuns(request))

        def describeReplicationTaskIndividualAssessments(
          request: DescribeReplicationTaskIndividualAssessmentsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeReplicationTaskIndividualAssessmentsResponse] =
          primitive(_.describeReplicationTaskIndividualAssessments(request))

        def describeReplicationTasks(
          request: DescribeReplicationTasksRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeReplicationTasksResponse] =
          primitive(_.describeReplicationTasks(request))

        def describeSchemas(
          request: DescribeSchemasRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeSchemasResponse] =
          primitive(_.describeSchemas(request))

        def describeTableStatistics(
          request: DescribeTableStatisticsRequest
        ): Kleisli[M, DatabaseMigrationClient, DescribeTableStatisticsResponse] =
          primitive(_.describeTableStatistics(request))

        def importCertificate(
          request: ImportCertificateRequest
        ): Kleisli[M, DatabaseMigrationClient, ImportCertificateResponse] =
          primitive(_.importCertificate(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DatabaseMigrationClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyEndpoint(
          request: ModifyEndpointRequest
        ): Kleisli[M, DatabaseMigrationClient, ModifyEndpointResponse] =
          primitive(_.modifyEndpoint(request))

        def modifyEventSubscription(
          request: ModifyEventSubscriptionRequest
        ): Kleisli[M, DatabaseMigrationClient, ModifyEventSubscriptionResponse] =
          primitive(_.modifyEventSubscription(request))

        def modifyReplicationInstance(
          request: ModifyReplicationInstanceRequest
        ): Kleisli[M, DatabaseMigrationClient, ModifyReplicationInstanceResponse] =
          primitive(_.modifyReplicationInstance(request))

        def modifyReplicationSubnetGroup(
          request: ModifyReplicationSubnetGroupRequest
        ): Kleisli[M, DatabaseMigrationClient, ModifyReplicationSubnetGroupResponse] =
          primitive(_.modifyReplicationSubnetGroup(request))

        def modifyReplicationTask(
          request: ModifyReplicationTaskRequest
        ): Kleisli[M, DatabaseMigrationClient, ModifyReplicationTaskResponse] =
          primitive(_.modifyReplicationTask(request))

        def moveReplicationTask(
          request: MoveReplicationTaskRequest
        ): Kleisli[M, DatabaseMigrationClient, MoveReplicationTaskResponse] =
          primitive(_.moveReplicationTask(request))

        def rebootReplicationInstance(
          request: RebootReplicationInstanceRequest
        ): Kleisli[M, DatabaseMigrationClient, RebootReplicationInstanceResponse] =
          primitive(_.rebootReplicationInstance(request))

        def refreshSchemas(
          request: RefreshSchemasRequest
        ): Kleisli[M, DatabaseMigrationClient, RefreshSchemasResponse] =
          primitive(_.refreshSchemas(request))

        def reloadTables(
          request: ReloadTablesRequest
        ): Kleisli[M, DatabaseMigrationClient, ReloadTablesResponse] =
          primitive(_.reloadTables(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, DatabaseMigrationClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def startReplicationTask(
          request: StartReplicationTaskRequest
        ): Kleisli[M, DatabaseMigrationClient, StartReplicationTaskResponse] =
          primitive(_.startReplicationTask(request))

        def startReplicationTaskAssessment(
          request: StartReplicationTaskAssessmentRequest
        ): Kleisli[M, DatabaseMigrationClient, StartReplicationTaskAssessmentResponse] =
          primitive(_.startReplicationTaskAssessment(request))

        def startReplicationTaskAssessmentRun(
          request: StartReplicationTaskAssessmentRunRequest
        ): Kleisli[M, DatabaseMigrationClient, StartReplicationTaskAssessmentRunResponse] =
          primitive(_.startReplicationTaskAssessmentRun(request))

        def stopReplicationTask(
          request: StopReplicationTaskRequest
        ): Kleisli[M, DatabaseMigrationClient, StopReplicationTaskResponse] =
          primitive(_.stopReplicationTask(request))

        def testConnection(
          request: TestConnectionRequest
        ): Kleisli[M, DatabaseMigrationClient, TestConnectionResponse] =
          primitive(_.testConnection(request))

        def primitive[A](
          f: DatabaseMigrationClient => A
        ): Kleisli[M, DatabaseMigrationClient, A]
      }
    }

    trait Visitor[F[_]] extends (DatabaseMigrationOp ~> F) {
      final def apply[A](op: DatabaseMigrationOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def applyPendingMaintenanceAction(
        request: ApplyPendingMaintenanceActionRequest
      ): F[ApplyPendingMaintenanceActionResponse]

      def cancelReplicationTaskAssessmentRun(
        request: CancelReplicationTaskAssessmentRunRequest
      ): F[CancelReplicationTaskAssessmentRunResponse]

      def createEndpoint(
        request: CreateEndpointRequest
      ): F[CreateEndpointResponse]

      def createEventSubscription(
        request: CreateEventSubscriptionRequest
      ): F[CreateEventSubscriptionResponse]

      def createReplicationInstance(
        request: CreateReplicationInstanceRequest
      ): F[CreateReplicationInstanceResponse]

      def createReplicationSubnetGroup(
        request: CreateReplicationSubnetGroupRequest
      ): F[CreateReplicationSubnetGroupResponse]

      def createReplicationTask(
        request: CreateReplicationTaskRequest
      ): F[CreateReplicationTaskResponse]

      def deleteCertificate(
        request: DeleteCertificateRequest
      ): F[DeleteCertificateResponse]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def deleteEndpoint(
        request: DeleteEndpointRequest
      ): F[DeleteEndpointResponse]

      def deleteEventSubscription(
        request: DeleteEventSubscriptionRequest
      ): F[DeleteEventSubscriptionResponse]

      def deleteReplicationInstance(
        request: DeleteReplicationInstanceRequest
      ): F[DeleteReplicationInstanceResponse]

      def deleteReplicationSubnetGroup(
        request: DeleteReplicationSubnetGroupRequest
      ): F[DeleteReplicationSubnetGroupResponse]

      def deleteReplicationTask(
        request: DeleteReplicationTaskRequest
      ): F[DeleteReplicationTaskResponse]

      def deleteReplicationTaskAssessmentRun(
        request: DeleteReplicationTaskAssessmentRunRequest
      ): F[DeleteReplicationTaskAssessmentRunResponse]

      def describeAccountAttributes(
        request: DescribeAccountAttributesRequest
      ): F[DescribeAccountAttributesResponse]

      def describeApplicableIndividualAssessments(
        request: DescribeApplicableIndividualAssessmentsRequest
      ): F[DescribeApplicableIndividualAssessmentsResponse]

      def describeCertificates(
        request: DescribeCertificatesRequest
      ): F[DescribeCertificatesResponse]

      def describeConnections(
        request: DescribeConnectionsRequest
      ): F[DescribeConnectionsResponse]

      def describeEndpointSettings(
        request: DescribeEndpointSettingsRequest
      ): F[DescribeEndpointSettingsResponse]

      def describeEndpointTypes(
        request: DescribeEndpointTypesRequest
      ): F[DescribeEndpointTypesResponse]

      def describeEndpoints(
        request: DescribeEndpointsRequest
      ): F[DescribeEndpointsResponse]

      def describeEventCategories(
        request: DescribeEventCategoriesRequest
      ): F[DescribeEventCategoriesResponse]

      def describeEventSubscriptions(
        request: DescribeEventSubscriptionsRequest
      ): F[DescribeEventSubscriptionsResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeOrderableReplicationInstances(
        request: DescribeOrderableReplicationInstancesRequest
      ): F[DescribeOrderableReplicationInstancesResponse]

      def describePendingMaintenanceActions(
        request: DescribePendingMaintenanceActionsRequest
      ): F[DescribePendingMaintenanceActionsResponse]

      def describeRefreshSchemasStatus(
        request: DescribeRefreshSchemasStatusRequest
      ): F[DescribeRefreshSchemasStatusResponse]

      def describeReplicationInstanceTaskLogs(
        request: DescribeReplicationInstanceTaskLogsRequest
      ): F[DescribeReplicationInstanceTaskLogsResponse]

      def describeReplicationInstances(
        request: DescribeReplicationInstancesRequest
      ): F[DescribeReplicationInstancesResponse]

      def describeReplicationSubnetGroups(
        request: DescribeReplicationSubnetGroupsRequest
      ): F[DescribeReplicationSubnetGroupsResponse]

      def describeReplicationTaskAssessmentResults(
        request: DescribeReplicationTaskAssessmentResultsRequest
      ): F[DescribeReplicationTaskAssessmentResultsResponse]

      def describeReplicationTaskAssessmentRuns(
        request: DescribeReplicationTaskAssessmentRunsRequest
      ): F[DescribeReplicationTaskAssessmentRunsResponse]

      def describeReplicationTaskIndividualAssessments(
        request: DescribeReplicationTaskIndividualAssessmentsRequest
      ): F[DescribeReplicationTaskIndividualAssessmentsResponse]

      def describeReplicationTasks(
        request: DescribeReplicationTasksRequest
      ): F[DescribeReplicationTasksResponse]

      def describeSchemas(
        request: DescribeSchemasRequest
      ): F[DescribeSchemasResponse]

      def describeTableStatistics(
        request: DescribeTableStatisticsRequest
      ): F[DescribeTableStatisticsResponse]

      def importCertificate(
        request: ImportCertificateRequest
      ): F[ImportCertificateResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyEndpoint(
        request: ModifyEndpointRequest
      ): F[ModifyEndpointResponse]

      def modifyEventSubscription(
        request: ModifyEventSubscriptionRequest
      ): F[ModifyEventSubscriptionResponse]

      def modifyReplicationInstance(
        request: ModifyReplicationInstanceRequest
      ): F[ModifyReplicationInstanceResponse]

      def modifyReplicationSubnetGroup(
        request: ModifyReplicationSubnetGroupRequest
      ): F[ModifyReplicationSubnetGroupResponse]

      def modifyReplicationTask(
        request: ModifyReplicationTaskRequest
      ): F[ModifyReplicationTaskResponse]

      def moveReplicationTask(
        request: MoveReplicationTaskRequest
      ): F[MoveReplicationTaskResponse]

      def rebootReplicationInstance(
        request: RebootReplicationInstanceRequest
      ): F[RebootReplicationInstanceResponse]

      def refreshSchemas(
        request: RefreshSchemasRequest
      ): F[RefreshSchemasResponse]

      def reloadTables(
        request: ReloadTablesRequest
      ): F[ReloadTablesResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]

      def startReplicationTask(
        request: StartReplicationTaskRequest
      ): F[StartReplicationTaskResponse]

      def startReplicationTaskAssessment(
        request: StartReplicationTaskAssessmentRequest
      ): F[StartReplicationTaskAssessmentResponse]

      def startReplicationTaskAssessmentRun(
        request: StartReplicationTaskAssessmentRunRequest
      ): F[StartReplicationTaskAssessmentRunResponse]

      def stopReplicationTask(
        request: StopReplicationTaskRequest
      ): F[StopReplicationTaskResponse]

      def testConnection(
        request: TestConnectionRequest
      ): F[TestConnectionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DatabaseMigrationOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends DatabaseMigrationOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class ApplyPendingMaintenanceActionOp(
      request: ApplyPendingMaintenanceActionRequest
    ) extends DatabaseMigrationOp[ApplyPendingMaintenanceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplyPendingMaintenanceActionResponse] =
        visitor.applyPendingMaintenanceAction(request)
    }

    final case class CancelReplicationTaskAssessmentRunOp(
      request: CancelReplicationTaskAssessmentRunRequest
    ) extends DatabaseMigrationOp[CancelReplicationTaskAssessmentRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelReplicationTaskAssessmentRunResponse] =
        visitor.cancelReplicationTaskAssessmentRun(request)
    }

    final case class CreateEndpointOp(
      request: CreateEndpointRequest
    ) extends DatabaseMigrationOp[CreateEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEndpointResponse] =
        visitor.createEndpoint(request)
    }

    final case class CreateEventSubscriptionOp(
      request: CreateEventSubscriptionRequest
    ) extends DatabaseMigrationOp[CreateEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventSubscriptionResponse] =
        visitor.createEventSubscription(request)
    }

    final case class CreateReplicationInstanceOp(
      request: CreateReplicationInstanceRequest
    ) extends DatabaseMigrationOp[CreateReplicationInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplicationInstanceResponse] =
        visitor.createReplicationInstance(request)
    }

    final case class CreateReplicationSubnetGroupOp(
      request: CreateReplicationSubnetGroupRequest
    ) extends DatabaseMigrationOp[CreateReplicationSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplicationSubnetGroupResponse] =
        visitor.createReplicationSubnetGroup(request)
    }

    final case class CreateReplicationTaskOp(
      request: CreateReplicationTaskRequest
    ) extends DatabaseMigrationOp[CreateReplicationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplicationTaskResponse] =
        visitor.createReplicationTask(request)
    }

    final case class DeleteCertificateOp(
      request: DeleteCertificateRequest
    ) extends DatabaseMigrationOp[DeleteCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCertificateResponse] =
        visitor.deleteCertificate(request)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends DatabaseMigrationOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class DeleteEndpointOp(
      request: DeleteEndpointRequest
    ) extends DatabaseMigrationOp[DeleteEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointResponse] =
        visitor.deleteEndpoint(request)
    }

    final case class DeleteEventSubscriptionOp(
      request: DeleteEventSubscriptionRequest
    ) extends DatabaseMigrationOp[DeleteEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventSubscriptionResponse] =
        visitor.deleteEventSubscription(request)
    }

    final case class DeleteReplicationInstanceOp(
      request: DeleteReplicationInstanceRequest
    ) extends DatabaseMigrationOp[DeleteReplicationInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationInstanceResponse] =
        visitor.deleteReplicationInstance(request)
    }

    final case class DeleteReplicationSubnetGroupOp(
      request: DeleteReplicationSubnetGroupRequest
    ) extends DatabaseMigrationOp[DeleteReplicationSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationSubnetGroupResponse] =
        visitor.deleteReplicationSubnetGroup(request)
    }

    final case class DeleteReplicationTaskOp(
      request: DeleteReplicationTaskRequest
    ) extends DatabaseMigrationOp[DeleteReplicationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationTaskResponse] =
        visitor.deleteReplicationTask(request)
    }

    final case class DeleteReplicationTaskAssessmentRunOp(
      request: DeleteReplicationTaskAssessmentRunRequest
    ) extends DatabaseMigrationOp[DeleteReplicationTaskAssessmentRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationTaskAssessmentRunResponse] =
        visitor.deleteReplicationTaskAssessmentRun(request)
    }

    final case class DescribeAccountAttributesOp(
      request: DescribeAccountAttributesRequest
    ) extends DatabaseMigrationOp[DescribeAccountAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAttributesResponse] =
        visitor.describeAccountAttributes(request)
    }

    final case class DescribeApplicableIndividualAssessmentsOp(
      request: DescribeApplicableIndividualAssessmentsRequest
    ) extends DatabaseMigrationOp[DescribeApplicableIndividualAssessmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicableIndividualAssessmentsResponse] =
        visitor.describeApplicableIndividualAssessments(request)
    }

    final case class DescribeCertificatesOp(
      request: DescribeCertificatesRequest
    ) extends DatabaseMigrationOp[DescribeCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificatesResponse] =
        visitor.describeCertificates(request)
    }

    final case class DescribeConnectionsOp(
      request: DescribeConnectionsRequest
    ) extends DatabaseMigrationOp[DescribeConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectionsResponse] =
        visitor.describeConnections(request)
    }

    final case class DescribeEndpointSettingsOp(
      request: DescribeEndpointSettingsRequest
    ) extends DatabaseMigrationOp[DescribeEndpointSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointSettingsResponse] =
        visitor.describeEndpointSettings(request)
    }

    final case class DescribeEndpointTypesOp(
      request: DescribeEndpointTypesRequest
    ) extends DatabaseMigrationOp[DescribeEndpointTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointTypesResponse] =
        visitor.describeEndpointTypes(request)
    }

    final case class DescribeEndpointsOp(
      request: DescribeEndpointsRequest
    ) extends DatabaseMigrationOp[DescribeEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointsResponse] =
        visitor.describeEndpoints(request)
    }

    final case class DescribeEventCategoriesOp(
      request: DescribeEventCategoriesRequest
    ) extends DatabaseMigrationOp[DescribeEventCategoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventCategoriesResponse] =
        visitor.describeEventCategories(request)
    }

    final case class DescribeEventSubscriptionsOp(
      request: DescribeEventSubscriptionsRequest
    ) extends DatabaseMigrationOp[DescribeEventSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventSubscriptionsResponse] =
        visitor.describeEventSubscriptions(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends DatabaseMigrationOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeOrderableReplicationInstancesOp(
      request: DescribeOrderableReplicationInstancesRequest
    ) extends DatabaseMigrationOp[DescribeOrderableReplicationInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrderableReplicationInstancesResponse] =
        visitor.describeOrderableReplicationInstances(request)
    }

    final case class DescribePendingMaintenanceActionsOp(
      request: DescribePendingMaintenanceActionsRequest
    ) extends DatabaseMigrationOp[DescribePendingMaintenanceActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePendingMaintenanceActionsResponse] =
        visitor.describePendingMaintenanceActions(request)
    }

    final case class DescribeRefreshSchemasStatusOp(
      request: DescribeRefreshSchemasStatusRequest
    ) extends DatabaseMigrationOp[DescribeRefreshSchemasStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRefreshSchemasStatusResponse] =
        visitor.describeRefreshSchemasStatus(request)
    }

    final case class DescribeReplicationInstanceTaskLogsOp(
      request: DescribeReplicationInstanceTaskLogsRequest
    ) extends DatabaseMigrationOp[DescribeReplicationInstanceTaskLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationInstanceTaskLogsResponse] =
        visitor.describeReplicationInstanceTaskLogs(request)
    }

    final case class DescribeReplicationInstancesOp(
      request: DescribeReplicationInstancesRequest
    ) extends DatabaseMigrationOp[DescribeReplicationInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationInstancesResponse] =
        visitor.describeReplicationInstances(request)
    }

    final case class DescribeReplicationSubnetGroupsOp(
      request: DescribeReplicationSubnetGroupsRequest
    ) extends DatabaseMigrationOp[DescribeReplicationSubnetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationSubnetGroupsResponse] =
        visitor.describeReplicationSubnetGroups(request)
    }

    final case class DescribeReplicationTaskAssessmentResultsOp(
      request: DescribeReplicationTaskAssessmentResultsRequest
    ) extends DatabaseMigrationOp[DescribeReplicationTaskAssessmentResultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationTaskAssessmentResultsResponse] =
        visitor.describeReplicationTaskAssessmentResults(request)
    }

    final case class DescribeReplicationTaskAssessmentRunsOp(
      request: DescribeReplicationTaskAssessmentRunsRequest
    ) extends DatabaseMigrationOp[DescribeReplicationTaskAssessmentRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationTaskAssessmentRunsResponse] =
        visitor.describeReplicationTaskAssessmentRuns(request)
    }

    final case class DescribeReplicationTaskIndividualAssessmentsOp(
      request: DescribeReplicationTaskIndividualAssessmentsRequest
    ) extends DatabaseMigrationOp[DescribeReplicationTaskIndividualAssessmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationTaskIndividualAssessmentsResponse] =
        visitor.describeReplicationTaskIndividualAssessments(request)
    }

    final case class DescribeReplicationTasksOp(
      request: DescribeReplicationTasksRequest
    ) extends DatabaseMigrationOp[DescribeReplicationTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationTasksResponse] =
        visitor.describeReplicationTasks(request)
    }

    final case class DescribeSchemasOp(
      request: DescribeSchemasRequest
    ) extends DatabaseMigrationOp[DescribeSchemasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSchemasResponse] =
        visitor.describeSchemas(request)
    }

    final case class DescribeTableStatisticsOp(
      request: DescribeTableStatisticsRequest
    ) extends DatabaseMigrationOp[DescribeTableStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTableStatisticsResponse] =
        visitor.describeTableStatistics(request)
    }

    final case class ImportCertificateOp(
      request: ImportCertificateRequest
    ) extends DatabaseMigrationOp[ImportCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportCertificateResponse] =
        visitor.importCertificate(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DatabaseMigrationOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyEndpointOp(
      request: ModifyEndpointRequest
    ) extends DatabaseMigrationOp[ModifyEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEndpointResponse] =
        visitor.modifyEndpoint(request)
    }

    final case class ModifyEventSubscriptionOp(
      request: ModifyEventSubscriptionRequest
    ) extends DatabaseMigrationOp[ModifyEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEventSubscriptionResponse] =
        visitor.modifyEventSubscription(request)
    }

    final case class ModifyReplicationInstanceOp(
      request: ModifyReplicationInstanceRequest
    ) extends DatabaseMigrationOp[ModifyReplicationInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyReplicationInstanceResponse] =
        visitor.modifyReplicationInstance(request)
    }

    final case class ModifyReplicationSubnetGroupOp(
      request: ModifyReplicationSubnetGroupRequest
    ) extends DatabaseMigrationOp[ModifyReplicationSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyReplicationSubnetGroupResponse] =
        visitor.modifyReplicationSubnetGroup(request)
    }

    final case class ModifyReplicationTaskOp(
      request: ModifyReplicationTaskRequest
    ) extends DatabaseMigrationOp[ModifyReplicationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyReplicationTaskResponse] =
        visitor.modifyReplicationTask(request)
    }

    final case class MoveReplicationTaskOp(
      request: MoveReplicationTaskRequest
    ) extends DatabaseMigrationOp[MoveReplicationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MoveReplicationTaskResponse] =
        visitor.moveReplicationTask(request)
    }

    final case class RebootReplicationInstanceOp(
      request: RebootReplicationInstanceRequest
    ) extends DatabaseMigrationOp[RebootReplicationInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootReplicationInstanceResponse] =
        visitor.rebootReplicationInstance(request)
    }

    final case class RefreshSchemasOp(
      request: RefreshSchemasRequest
    ) extends DatabaseMigrationOp[RefreshSchemasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RefreshSchemasResponse] =
        visitor.refreshSchemas(request)
    }

    final case class ReloadTablesOp(
      request: ReloadTablesRequest
    ) extends DatabaseMigrationOp[ReloadTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReloadTablesResponse] =
        visitor.reloadTables(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends DatabaseMigrationOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class StartReplicationTaskOp(
      request: StartReplicationTaskRequest
    ) extends DatabaseMigrationOp[StartReplicationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartReplicationTaskResponse] =
        visitor.startReplicationTask(request)
    }

    final case class StartReplicationTaskAssessmentOp(
      request: StartReplicationTaskAssessmentRequest
    ) extends DatabaseMigrationOp[StartReplicationTaskAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartReplicationTaskAssessmentResponse] =
        visitor.startReplicationTaskAssessment(request)
    }

    final case class StartReplicationTaskAssessmentRunOp(
      request: StartReplicationTaskAssessmentRunRequest
    ) extends DatabaseMigrationOp[StartReplicationTaskAssessmentRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartReplicationTaskAssessmentRunResponse] =
        visitor.startReplicationTaskAssessmentRun(request)
    }

    final case class StopReplicationTaskOp(
      request: StopReplicationTaskRequest
    ) extends DatabaseMigrationOp[StopReplicationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopReplicationTaskResponse] =
        visitor.stopReplicationTask(request)
    }

    final case class TestConnectionOp(
      request: TestConnectionRequest
    ) extends DatabaseMigrationOp[TestConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestConnectionResponse] =
        visitor.testConnection(request)
    }
  }

  import DatabaseMigrationOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DatabaseMigrationOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): DatabaseMigrationIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def applyPendingMaintenanceAction(
    request: ApplyPendingMaintenanceActionRequest
  ): DatabaseMigrationIO[ApplyPendingMaintenanceActionResponse] =
    FF.liftF(ApplyPendingMaintenanceActionOp(request))

  def cancelReplicationTaskAssessmentRun(
    request: CancelReplicationTaskAssessmentRunRequest
  ): DatabaseMigrationIO[CancelReplicationTaskAssessmentRunResponse] =
    FF.liftF(CancelReplicationTaskAssessmentRunOp(request))

  def createEndpoint(
    request: CreateEndpointRequest
  ): DatabaseMigrationIO[CreateEndpointResponse] =
    FF.liftF(CreateEndpointOp(request))

  def createEventSubscription(
    request: CreateEventSubscriptionRequest
  ): DatabaseMigrationIO[CreateEventSubscriptionResponse] =
    FF.liftF(CreateEventSubscriptionOp(request))

  def createReplicationInstance(
    request: CreateReplicationInstanceRequest
  ): DatabaseMigrationIO[CreateReplicationInstanceResponse] =
    FF.liftF(CreateReplicationInstanceOp(request))

  def createReplicationSubnetGroup(
    request: CreateReplicationSubnetGroupRequest
  ): DatabaseMigrationIO[CreateReplicationSubnetGroupResponse] =
    FF.liftF(CreateReplicationSubnetGroupOp(request))

  def createReplicationTask(
    request: CreateReplicationTaskRequest
  ): DatabaseMigrationIO[CreateReplicationTaskResponse] =
    FF.liftF(CreateReplicationTaskOp(request))

  def deleteCertificate(
    request: DeleteCertificateRequest
  ): DatabaseMigrationIO[DeleteCertificateResponse] =
    FF.liftF(DeleteCertificateOp(request))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): DatabaseMigrationIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def deleteEndpoint(
    request: DeleteEndpointRequest
  ): DatabaseMigrationIO[DeleteEndpointResponse] =
    FF.liftF(DeleteEndpointOp(request))

  def deleteEventSubscription(
    request: DeleteEventSubscriptionRequest
  ): DatabaseMigrationIO[DeleteEventSubscriptionResponse] =
    FF.liftF(DeleteEventSubscriptionOp(request))

  def deleteReplicationInstance(
    request: DeleteReplicationInstanceRequest
  ): DatabaseMigrationIO[DeleteReplicationInstanceResponse] =
    FF.liftF(DeleteReplicationInstanceOp(request))

  def deleteReplicationSubnetGroup(
    request: DeleteReplicationSubnetGroupRequest
  ): DatabaseMigrationIO[DeleteReplicationSubnetGroupResponse] =
    FF.liftF(DeleteReplicationSubnetGroupOp(request))

  def deleteReplicationTask(
    request: DeleteReplicationTaskRequest
  ): DatabaseMigrationIO[DeleteReplicationTaskResponse] =
    FF.liftF(DeleteReplicationTaskOp(request))

  def deleteReplicationTaskAssessmentRun(
    request: DeleteReplicationTaskAssessmentRunRequest
  ): DatabaseMigrationIO[DeleteReplicationTaskAssessmentRunResponse] =
    FF.liftF(DeleteReplicationTaskAssessmentRunOp(request))

  def describeAccountAttributes(
    request: DescribeAccountAttributesRequest
  ): DatabaseMigrationIO[DescribeAccountAttributesResponse] =
    FF.liftF(DescribeAccountAttributesOp(request))

  def describeApplicableIndividualAssessments(
    request: DescribeApplicableIndividualAssessmentsRequest
  ): DatabaseMigrationIO[DescribeApplicableIndividualAssessmentsResponse] =
    FF.liftF(DescribeApplicableIndividualAssessmentsOp(request))

  def describeCertificates(
    request: DescribeCertificatesRequest
  ): DatabaseMigrationIO[DescribeCertificatesResponse] =
    FF.liftF(DescribeCertificatesOp(request))

  def describeConnections(
    request: DescribeConnectionsRequest
  ): DatabaseMigrationIO[DescribeConnectionsResponse] =
    FF.liftF(DescribeConnectionsOp(request))

  def describeEndpointSettings(
    request: DescribeEndpointSettingsRequest
  ): DatabaseMigrationIO[DescribeEndpointSettingsResponse] =
    FF.liftF(DescribeEndpointSettingsOp(request))

  def describeEndpointTypes(
    request: DescribeEndpointTypesRequest
  ): DatabaseMigrationIO[DescribeEndpointTypesResponse] =
    FF.liftF(DescribeEndpointTypesOp(request))

  def describeEndpoints(
    request: DescribeEndpointsRequest
  ): DatabaseMigrationIO[DescribeEndpointsResponse] =
    FF.liftF(DescribeEndpointsOp(request))

  def describeEventCategories(
    request: DescribeEventCategoriesRequest
  ): DatabaseMigrationIO[DescribeEventCategoriesResponse] =
    FF.liftF(DescribeEventCategoriesOp(request))

  def describeEventSubscriptions(
    request: DescribeEventSubscriptionsRequest
  ): DatabaseMigrationIO[DescribeEventSubscriptionsResponse] =
    FF.liftF(DescribeEventSubscriptionsOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): DatabaseMigrationIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeOrderableReplicationInstances(
    request: DescribeOrderableReplicationInstancesRequest
  ): DatabaseMigrationIO[DescribeOrderableReplicationInstancesResponse] =
    FF.liftF(DescribeOrderableReplicationInstancesOp(request))

  def describePendingMaintenanceActions(
    request: DescribePendingMaintenanceActionsRequest
  ): DatabaseMigrationIO[DescribePendingMaintenanceActionsResponse] =
    FF.liftF(DescribePendingMaintenanceActionsOp(request))

  def describeRefreshSchemasStatus(
    request: DescribeRefreshSchemasStatusRequest
  ): DatabaseMigrationIO[DescribeRefreshSchemasStatusResponse] =
    FF.liftF(DescribeRefreshSchemasStatusOp(request))

  def describeReplicationInstanceTaskLogs(
    request: DescribeReplicationInstanceTaskLogsRequest
  ): DatabaseMigrationIO[DescribeReplicationInstanceTaskLogsResponse] =
    FF.liftF(DescribeReplicationInstanceTaskLogsOp(request))

  def describeReplicationInstances(
    request: DescribeReplicationInstancesRequest
  ): DatabaseMigrationIO[DescribeReplicationInstancesResponse] =
    FF.liftF(DescribeReplicationInstancesOp(request))

  def describeReplicationSubnetGroups(
    request: DescribeReplicationSubnetGroupsRequest
  ): DatabaseMigrationIO[DescribeReplicationSubnetGroupsResponse] =
    FF.liftF(DescribeReplicationSubnetGroupsOp(request))

  def describeReplicationTaskAssessmentResults(
    request: DescribeReplicationTaskAssessmentResultsRequest
  ): DatabaseMigrationIO[DescribeReplicationTaskAssessmentResultsResponse] =
    FF.liftF(DescribeReplicationTaskAssessmentResultsOp(request))

  def describeReplicationTaskAssessmentRuns(
    request: DescribeReplicationTaskAssessmentRunsRequest
  ): DatabaseMigrationIO[DescribeReplicationTaskAssessmentRunsResponse] =
    FF.liftF(DescribeReplicationTaskAssessmentRunsOp(request))

  def describeReplicationTaskIndividualAssessments(
    request: DescribeReplicationTaskIndividualAssessmentsRequest
  ): DatabaseMigrationIO[DescribeReplicationTaskIndividualAssessmentsResponse] =
    FF.liftF(DescribeReplicationTaskIndividualAssessmentsOp(request))

  def describeReplicationTasks(
    request: DescribeReplicationTasksRequest
  ): DatabaseMigrationIO[DescribeReplicationTasksResponse] =
    FF.liftF(DescribeReplicationTasksOp(request))

  def describeSchemas(
    request: DescribeSchemasRequest
  ): DatabaseMigrationIO[DescribeSchemasResponse] =
    FF.liftF(DescribeSchemasOp(request))

  def describeTableStatistics(
    request: DescribeTableStatisticsRequest
  ): DatabaseMigrationIO[DescribeTableStatisticsResponse] =
    FF.liftF(DescribeTableStatisticsOp(request))

  def importCertificate(
    request: ImportCertificateRequest
  ): DatabaseMigrationIO[ImportCertificateResponse] =
    FF.liftF(ImportCertificateOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DatabaseMigrationIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyEndpoint(
    request: ModifyEndpointRequest
  ): DatabaseMigrationIO[ModifyEndpointResponse] =
    FF.liftF(ModifyEndpointOp(request))

  def modifyEventSubscription(
    request: ModifyEventSubscriptionRequest
  ): DatabaseMigrationIO[ModifyEventSubscriptionResponse] =
    FF.liftF(ModifyEventSubscriptionOp(request))

  def modifyReplicationInstance(
    request: ModifyReplicationInstanceRequest
  ): DatabaseMigrationIO[ModifyReplicationInstanceResponse] =
    FF.liftF(ModifyReplicationInstanceOp(request))

  def modifyReplicationSubnetGroup(
    request: ModifyReplicationSubnetGroupRequest
  ): DatabaseMigrationIO[ModifyReplicationSubnetGroupResponse] =
    FF.liftF(ModifyReplicationSubnetGroupOp(request))

  def modifyReplicationTask(
    request: ModifyReplicationTaskRequest
  ): DatabaseMigrationIO[ModifyReplicationTaskResponse] =
    FF.liftF(ModifyReplicationTaskOp(request))

  def moveReplicationTask(
    request: MoveReplicationTaskRequest
  ): DatabaseMigrationIO[MoveReplicationTaskResponse] =
    FF.liftF(MoveReplicationTaskOp(request))

  def rebootReplicationInstance(
    request: RebootReplicationInstanceRequest
  ): DatabaseMigrationIO[RebootReplicationInstanceResponse] =
    FF.liftF(RebootReplicationInstanceOp(request))

  def refreshSchemas(
    request: RefreshSchemasRequest
  ): DatabaseMigrationIO[RefreshSchemasResponse] =
    FF.liftF(RefreshSchemasOp(request))

  def reloadTables(
    request: ReloadTablesRequest
  ): DatabaseMigrationIO[ReloadTablesResponse] =
    FF.liftF(ReloadTablesOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): DatabaseMigrationIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def startReplicationTask(
    request: StartReplicationTaskRequest
  ): DatabaseMigrationIO[StartReplicationTaskResponse] =
    FF.liftF(StartReplicationTaskOp(request))

  def startReplicationTaskAssessment(
    request: StartReplicationTaskAssessmentRequest
  ): DatabaseMigrationIO[StartReplicationTaskAssessmentResponse] =
    FF.liftF(StartReplicationTaskAssessmentOp(request))

  def startReplicationTaskAssessmentRun(
    request: StartReplicationTaskAssessmentRunRequest
  ): DatabaseMigrationIO[StartReplicationTaskAssessmentRunResponse] =
    FF.liftF(StartReplicationTaskAssessmentRunOp(request))

  def stopReplicationTask(
    request: StopReplicationTaskRequest
  ): DatabaseMigrationIO[StopReplicationTaskResponse] =
    FF.liftF(StopReplicationTaskOp(request))

  def testConnection(
    request: TestConnectionRequest
  ): DatabaseMigrationIO[TestConnectionResponse] =
    FF.liftF(TestConnectionOp(request))
}
