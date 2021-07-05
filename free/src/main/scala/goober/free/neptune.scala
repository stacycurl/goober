package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.neptune.NeptuneClient
import software.amazon.awssdk.services.neptune.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object neptune { module =>

  // Free monad over NeptuneOp
  type NeptuneIO[A] = FF[NeptuneOp, A]

  sealed trait NeptuneOp[A] {
    def visit[F[_]](visitor: NeptuneOp.Visitor[F]): F[A]
  }

  object NeptuneOp {
    // Given a NeptuneClient we can embed a NeptuneIO program in any algebra that understands embedding.
    implicit val NeptuneOpEmbeddable: Embeddable[NeptuneOp, NeptuneClient] = new Embeddable[NeptuneOp, NeptuneClient] {
      def embed[A](client: NeptuneClient, io: NeptuneIO[A]): Embedded[A] = Embedded.Neptune(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends NeptuneOp.Visitor[Kleisli[M, NeptuneClient, *]] {
        def addRoleToDBCluster(
          request: AddRoleToDbClusterRequest
        ): Kleisli[M, NeptuneClient, AddRoleToDbClusterResponse] =
          primitive(_.addRoleToDBCluster(request))

        def addSourceIdentifierToSubscription(
          request: AddSourceIdentifierToSubscriptionRequest
        ): Kleisli[M, NeptuneClient, AddSourceIdentifierToSubscriptionResponse] =
          primitive(_.addSourceIdentifierToSubscription(request))

        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, NeptuneClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def applyPendingMaintenanceAction(
          request: ApplyPendingMaintenanceActionRequest
        ): Kleisli[M, NeptuneClient, ApplyPendingMaintenanceActionResponse] =
          primitive(_.applyPendingMaintenanceAction(request))

        def copyDBClusterParameterGroup(
          request: CopyDbClusterParameterGroupRequest
        ): Kleisli[M, NeptuneClient, CopyDbClusterParameterGroupResponse] =
          primitive(_.copyDBClusterParameterGroup(request))

        def copyDBClusterSnapshot(
          request: CopyDbClusterSnapshotRequest
        ): Kleisli[M, NeptuneClient, CopyDbClusterSnapshotResponse] =
          primitive(_.copyDBClusterSnapshot(request))

        def copyDBParameterGroup(
          request: CopyDbParameterGroupRequest
        ): Kleisli[M, NeptuneClient, CopyDbParameterGroupResponse] =
          primitive(_.copyDBParameterGroup(request))

        def createDBCluster(
          request: CreateDbClusterRequest
        ): Kleisli[M, NeptuneClient, CreateDbClusterResponse] =
          primitive(_.createDBCluster(request))

        def createDBClusterEndpoint(
          request: CreateDbClusterEndpointRequest
        ): Kleisli[M, NeptuneClient, CreateDbClusterEndpointResponse] =
          primitive(_.createDBClusterEndpoint(request))

        def createDBClusterParameterGroup(
          request: CreateDbClusterParameterGroupRequest
        ): Kleisli[M, NeptuneClient, CreateDbClusterParameterGroupResponse] =
          primitive(_.createDBClusterParameterGroup(request))

        def createDBClusterSnapshot(
          request: CreateDbClusterSnapshotRequest
        ): Kleisli[M, NeptuneClient, CreateDbClusterSnapshotResponse] =
          primitive(_.createDBClusterSnapshot(request))

        def createDBInstance(
          request: CreateDbInstanceRequest
        ): Kleisli[M, NeptuneClient, CreateDbInstanceResponse] =
          primitive(_.createDBInstance(request))

        def createDBParameterGroup(
          request: CreateDbParameterGroupRequest
        ): Kleisli[M, NeptuneClient, CreateDbParameterGroupResponse] =
          primitive(_.createDBParameterGroup(request))

        def createDBSubnetGroup(
          request: CreateDbSubnetGroupRequest
        ): Kleisli[M, NeptuneClient, CreateDbSubnetGroupResponse] =
          primitive(_.createDBSubnetGroup(request))

        def createEventSubscription(
          request: CreateEventSubscriptionRequest
        ): Kleisli[M, NeptuneClient, CreateEventSubscriptionResponse] =
          primitive(_.createEventSubscription(request))

        def deleteDBCluster(
          request: DeleteDbClusterRequest
        ): Kleisli[M, NeptuneClient, DeleteDbClusterResponse] =
          primitive(_.deleteDBCluster(request))

        def deleteDBClusterEndpoint(
          request: DeleteDbClusterEndpointRequest
        ): Kleisli[M, NeptuneClient, DeleteDbClusterEndpointResponse] =
          primitive(_.deleteDBClusterEndpoint(request))

        def deleteDBClusterParameterGroup(
          request: DeleteDbClusterParameterGroupRequest
        ): Kleisli[M, NeptuneClient, DeleteDbClusterParameterGroupResponse] =
          primitive(_.deleteDBClusterParameterGroup(request))

        def deleteDBClusterSnapshot(
          request: DeleteDbClusterSnapshotRequest
        ): Kleisli[M, NeptuneClient, DeleteDbClusterSnapshotResponse] =
          primitive(_.deleteDBClusterSnapshot(request))

        def deleteDBInstance(
          request: DeleteDbInstanceRequest
        ): Kleisli[M, NeptuneClient, DeleteDbInstanceResponse] =
          primitive(_.deleteDBInstance(request))

        def deleteDBParameterGroup(
          request: DeleteDbParameterGroupRequest
        ): Kleisli[M, NeptuneClient, DeleteDbParameterGroupResponse] =
          primitive(_.deleteDBParameterGroup(request))

        def deleteDBSubnetGroup(
          request: DeleteDbSubnetGroupRequest
        ): Kleisli[M, NeptuneClient, DeleteDbSubnetGroupResponse] =
          primitive(_.deleteDBSubnetGroup(request))

        def deleteEventSubscription(
          request: DeleteEventSubscriptionRequest
        ): Kleisli[M, NeptuneClient, DeleteEventSubscriptionResponse] =
          primitive(_.deleteEventSubscription(request))

        def describeDBClusterEndpoints(
          request: DescribeDbClusterEndpointsRequest
        ): Kleisli[M, NeptuneClient, DescribeDbClusterEndpointsResponse] =
          primitive(_.describeDBClusterEndpoints(request))

        def describeDBClusterParameterGroups(
          request: DescribeDbClusterParameterGroupsRequest
        ): Kleisli[M, NeptuneClient, DescribeDbClusterParameterGroupsResponse] =
          primitive(_.describeDBClusterParameterGroups(request))

        def describeDBClusterParameters(
          request: DescribeDbClusterParametersRequest
        ): Kleisli[M, NeptuneClient, DescribeDbClusterParametersResponse] =
          primitive(_.describeDBClusterParameters(request))

        def describeDBClusterSnapshotAttributes(
          request: DescribeDbClusterSnapshotAttributesRequest
        ): Kleisli[M, NeptuneClient, DescribeDbClusterSnapshotAttributesResponse] =
          primitive(_.describeDBClusterSnapshotAttributes(request))

        def describeDBClusterSnapshots(
          request: DescribeDbClusterSnapshotsRequest
        ): Kleisli[M, NeptuneClient, DescribeDbClusterSnapshotsResponse] =
          primitive(_.describeDBClusterSnapshots(request))

        def describeDBClusters(
          request: DescribeDbClustersRequest
        ): Kleisli[M, NeptuneClient, DescribeDbClustersResponse] =
          primitive(_.describeDBClusters(request))

        def describeDBEngineVersions(
          request: DescribeDbEngineVersionsRequest
        ): Kleisli[M, NeptuneClient, DescribeDbEngineVersionsResponse] =
          primitive(_.describeDBEngineVersions(request))

        def describeDBInstances(
          request: DescribeDbInstancesRequest
        ): Kleisli[M, NeptuneClient, DescribeDbInstancesResponse] =
          primitive(_.describeDBInstances(request))

        def describeDBParameterGroups(
          request: DescribeDbParameterGroupsRequest
        ): Kleisli[M, NeptuneClient, DescribeDbParameterGroupsResponse] =
          primitive(_.describeDBParameterGroups(request))

        def describeDBParameters(
          request: DescribeDbParametersRequest
        ): Kleisli[M, NeptuneClient, DescribeDbParametersResponse] =
          primitive(_.describeDBParameters(request))

        def describeDBSubnetGroups(
          request: DescribeDbSubnetGroupsRequest
        ): Kleisli[M, NeptuneClient, DescribeDbSubnetGroupsResponse] =
          primitive(_.describeDBSubnetGroups(request))

        def describeEngineDefaultClusterParameters(
          request: DescribeEngineDefaultClusterParametersRequest
        ): Kleisli[M, NeptuneClient, DescribeEngineDefaultClusterParametersResponse] =
          primitive(_.describeEngineDefaultClusterParameters(request))

        def describeEngineDefaultParameters(
          request: DescribeEngineDefaultParametersRequest
        ): Kleisli[M, NeptuneClient, DescribeEngineDefaultParametersResponse] =
          primitive(_.describeEngineDefaultParameters(request))

        def describeEventCategories(
          request: DescribeEventCategoriesRequest
        ): Kleisli[M, NeptuneClient, DescribeEventCategoriesResponse] =
          primitive(_.describeEventCategories(request))

        def describeEventSubscriptions(
          request: DescribeEventSubscriptionsRequest
        ): Kleisli[M, NeptuneClient, DescribeEventSubscriptionsResponse] =
          primitive(_.describeEventSubscriptions(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, NeptuneClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeOrderableDBInstanceOptions(
          request: DescribeOrderableDbInstanceOptionsRequest
        ): Kleisli[M, NeptuneClient, DescribeOrderableDbInstanceOptionsResponse] =
          primitive(_.describeOrderableDBInstanceOptions(request))

        def describePendingMaintenanceActions(
          request: DescribePendingMaintenanceActionsRequest
        ): Kleisli[M, NeptuneClient, DescribePendingMaintenanceActionsResponse] =
          primitive(_.describePendingMaintenanceActions(request))

        def describeValidDBInstanceModifications(
          request: DescribeValidDbInstanceModificationsRequest
        ): Kleisli[M, NeptuneClient, DescribeValidDbInstanceModificationsResponse] =
          primitive(_.describeValidDBInstanceModifications(request))

        def failoverDBCluster(
          request: FailoverDbClusterRequest
        ): Kleisli[M, NeptuneClient, FailoverDbClusterResponse] =
          primitive(_.failoverDBCluster(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, NeptuneClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyDBCluster(
          request: ModifyDbClusterRequest
        ): Kleisli[M, NeptuneClient, ModifyDbClusterResponse] =
          primitive(_.modifyDBCluster(request))

        def modifyDBClusterEndpoint(
          request: ModifyDbClusterEndpointRequest
        ): Kleisli[M, NeptuneClient, ModifyDbClusterEndpointResponse] =
          primitive(_.modifyDBClusterEndpoint(request))

        def modifyDBClusterParameterGroup(
          request: ModifyDbClusterParameterGroupRequest
        ): Kleisli[M, NeptuneClient, ModifyDbClusterParameterGroupResponse] =
          primitive(_.modifyDBClusterParameterGroup(request))

        def modifyDBClusterSnapshotAttribute(
          request: ModifyDbClusterSnapshotAttributeRequest
        ): Kleisli[M, NeptuneClient, ModifyDbClusterSnapshotAttributeResponse] =
          primitive(_.modifyDBClusterSnapshotAttribute(request))

        def modifyDBInstance(
          request: ModifyDbInstanceRequest
        ): Kleisli[M, NeptuneClient, ModifyDbInstanceResponse] =
          primitive(_.modifyDBInstance(request))

        def modifyDBParameterGroup(
          request: ModifyDbParameterGroupRequest
        ): Kleisli[M, NeptuneClient, ModifyDbParameterGroupResponse] =
          primitive(_.modifyDBParameterGroup(request))

        def modifyDBSubnetGroup(
          request: ModifyDbSubnetGroupRequest
        ): Kleisli[M, NeptuneClient, ModifyDbSubnetGroupResponse] =
          primitive(_.modifyDBSubnetGroup(request))

        def modifyEventSubscription(
          request: ModifyEventSubscriptionRequest
        ): Kleisli[M, NeptuneClient, ModifyEventSubscriptionResponse] =
          primitive(_.modifyEventSubscription(request))

        def promoteReadReplicaDBCluster(
          request: PromoteReadReplicaDbClusterRequest
        ): Kleisli[M, NeptuneClient, PromoteReadReplicaDbClusterResponse] =
          primitive(_.promoteReadReplicaDBCluster(request))

        def rebootDBInstance(
          request: RebootDbInstanceRequest
        ): Kleisli[M, NeptuneClient, RebootDbInstanceResponse] =
          primitive(_.rebootDBInstance(request))

        def removeRoleFromDBCluster(
          request: RemoveRoleFromDbClusterRequest
        ): Kleisli[M, NeptuneClient, RemoveRoleFromDbClusterResponse] =
          primitive(_.removeRoleFromDBCluster(request))

        def removeSourceIdentifierFromSubscription(
          request: RemoveSourceIdentifierFromSubscriptionRequest
        ): Kleisli[M, NeptuneClient, RemoveSourceIdentifierFromSubscriptionResponse] =
          primitive(_.removeSourceIdentifierFromSubscription(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, NeptuneClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def resetDBClusterParameterGroup(
          request: ResetDbClusterParameterGroupRequest
        ): Kleisli[M, NeptuneClient, ResetDbClusterParameterGroupResponse] =
          primitive(_.resetDBClusterParameterGroup(request))

        def resetDBParameterGroup(
          request: ResetDbParameterGroupRequest
        ): Kleisli[M, NeptuneClient, ResetDbParameterGroupResponse] =
          primitive(_.resetDBParameterGroup(request))

        def restoreDBClusterFromSnapshot(
          request: RestoreDbClusterFromSnapshotRequest
        ): Kleisli[M, NeptuneClient, RestoreDbClusterFromSnapshotResponse] =
          primitive(_.restoreDBClusterFromSnapshot(request))

        def restoreDBClusterToPointInTime(
          request: RestoreDbClusterToPointInTimeRequest
        ): Kleisli[M, NeptuneClient, RestoreDbClusterToPointInTimeResponse] =
          primitive(_.restoreDBClusterToPointInTime(request))

        def startDBCluster(
          request: StartDbClusterRequest
        ): Kleisli[M, NeptuneClient, StartDbClusterResponse] =
          primitive(_.startDBCluster(request))

        def stopDBCluster(
          request: StopDbClusterRequest
        ): Kleisli[M, NeptuneClient, StopDbClusterResponse] =
          primitive(_.stopDBCluster(request))

        def primitive[A](
          f: NeptuneClient => A
        ): Kleisli[M, NeptuneClient, A]
      }
    }

    trait Visitor[F[_]] extends (NeptuneOp ~> F) {
      final def apply[A](op: NeptuneOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addRoleToDBCluster(
        request: AddRoleToDbClusterRequest
      ): F[AddRoleToDbClusterResponse]

      def addSourceIdentifierToSubscription(
        request: AddSourceIdentifierToSubscriptionRequest
      ): F[AddSourceIdentifierToSubscriptionResponse]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def applyPendingMaintenanceAction(
        request: ApplyPendingMaintenanceActionRequest
      ): F[ApplyPendingMaintenanceActionResponse]

      def copyDBClusterParameterGroup(
        request: CopyDbClusterParameterGroupRequest
      ): F[CopyDbClusterParameterGroupResponse]

      def copyDBClusterSnapshot(
        request: CopyDbClusterSnapshotRequest
      ): F[CopyDbClusterSnapshotResponse]

      def copyDBParameterGroup(
        request: CopyDbParameterGroupRequest
      ): F[CopyDbParameterGroupResponse]

      def createDBCluster(
        request: CreateDbClusterRequest
      ): F[CreateDbClusterResponse]

      def createDBClusterEndpoint(
        request: CreateDbClusterEndpointRequest
      ): F[CreateDbClusterEndpointResponse]

      def createDBClusterParameterGroup(
        request: CreateDbClusterParameterGroupRequest
      ): F[CreateDbClusterParameterGroupResponse]

      def createDBClusterSnapshot(
        request: CreateDbClusterSnapshotRequest
      ): F[CreateDbClusterSnapshotResponse]

      def createDBInstance(
        request: CreateDbInstanceRequest
      ): F[CreateDbInstanceResponse]

      def createDBParameterGroup(
        request: CreateDbParameterGroupRequest
      ): F[CreateDbParameterGroupResponse]

      def createDBSubnetGroup(
        request: CreateDbSubnetGroupRequest
      ): F[CreateDbSubnetGroupResponse]

      def createEventSubscription(
        request: CreateEventSubscriptionRequest
      ): F[CreateEventSubscriptionResponse]

      def deleteDBCluster(
        request: DeleteDbClusterRequest
      ): F[DeleteDbClusterResponse]

      def deleteDBClusterEndpoint(
        request: DeleteDbClusterEndpointRequest
      ): F[DeleteDbClusterEndpointResponse]

      def deleteDBClusterParameterGroup(
        request: DeleteDbClusterParameterGroupRequest
      ): F[DeleteDbClusterParameterGroupResponse]

      def deleteDBClusterSnapshot(
        request: DeleteDbClusterSnapshotRequest
      ): F[DeleteDbClusterSnapshotResponse]

      def deleteDBInstance(
        request: DeleteDbInstanceRequest
      ): F[DeleteDbInstanceResponse]

      def deleteDBParameterGroup(
        request: DeleteDbParameterGroupRequest
      ): F[DeleteDbParameterGroupResponse]

      def deleteDBSubnetGroup(
        request: DeleteDbSubnetGroupRequest
      ): F[DeleteDbSubnetGroupResponse]

      def deleteEventSubscription(
        request: DeleteEventSubscriptionRequest
      ): F[DeleteEventSubscriptionResponse]

      def describeDBClusterEndpoints(
        request: DescribeDbClusterEndpointsRequest
      ): F[DescribeDbClusterEndpointsResponse]

      def describeDBClusterParameterGroups(
        request: DescribeDbClusterParameterGroupsRequest
      ): F[DescribeDbClusterParameterGroupsResponse]

      def describeDBClusterParameters(
        request: DescribeDbClusterParametersRequest
      ): F[DescribeDbClusterParametersResponse]

      def describeDBClusterSnapshotAttributes(
        request: DescribeDbClusterSnapshotAttributesRequest
      ): F[DescribeDbClusterSnapshotAttributesResponse]

      def describeDBClusterSnapshots(
        request: DescribeDbClusterSnapshotsRequest
      ): F[DescribeDbClusterSnapshotsResponse]

      def describeDBClusters(
        request: DescribeDbClustersRequest
      ): F[DescribeDbClustersResponse]

      def describeDBEngineVersions(
        request: DescribeDbEngineVersionsRequest
      ): F[DescribeDbEngineVersionsResponse]

      def describeDBInstances(
        request: DescribeDbInstancesRequest
      ): F[DescribeDbInstancesResponse]

      def describeDBParameterGroups(
        request: DescribeDbParameterGroupsRequest
      ): F[DescribeDbParameterGroupsResponse]

      def describeDBParameters(
        request: DescribeDbParametersRequest
      ): F[DescribeDbParametersResponse]

      def describeDBSubnetGroups(
        request: DescribeDbSubnetGroupsRequest
      ): F[DescribeDbSubnetGroupsResponse]

      def describeEngineDefaultClusterParameters(
        request: DescribeEngineDefaultClusterParametersRequest
      ): F[DescribeEngineDefaultClusterParametersResponse]

      def describeEngineDefaultParameters(
        request: DescribeEngineDefaultParametersRequest
      ): F[DescribeEngineDefaultParametersResponse]

      def describeEventCategories(
        request: DescribeEventCategoriesRequest
      ): F[DescribeEventCategoriesResponse]

      def describeEventSubscriptions(
        request: DescribeEventSubscriptionsRequest
      ): F[DescribeEventSubscriptionsResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeOrderableDBInstanceOptions(
        request: DescribeOrderableDbInstanceOptionsRequest
      ): F[DescribeOrderableDbInstanceOptionsResponse]

      def describePendingMaintenanceActions(
        request: DescribePendingMaintenanceActionsRequest
      ): F[DescribePendingMaintenanceActionsResponse]

      def describeValidDBInstanceModifications(
        request: DescribeValidDbInstanceModificationsRequest
      ): F[DescribeValidDbInstanceModificationsResponse]

      def failoverDBCluster(
        request: FailoverDbClusterRequest
      ): F[FailoverDbClusterResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyDBCluster(
        request: ModifyDbClusterRequest
      ): F[ModifyDbClusterResponse]

      def modifyDBClusterEndpoint(
        request: ModifyDbClusterEndpointRequest
      ): F[ModifyDbClusterEndpointResponse]

      def modifyDBClusterParameterGroup(
        request: ModifyDbClusterParameterGroupRequest
      ): F[ModifyDbClusterParameterGroupResponse]

      def modifyDBClusterSnapshotAttribute(
        request: ModifyDbClusterSnapshotAttributeRequest
      ): F[ModifyDbClusterSnapshotAttributeResponse]

      def modifyDBInstance(
        request: ModifyDbInstanceRequest
      ): F[ModifyDbInstanceResponse]

      def modifyDBParameterGroup(
        request: ModifyDbParameterGroupRequest
      ): F[ModifyDbParameterGroupResponse]

      def modifyDBSubnetGroup(
        request: ModifyDbSubnetGroupRequest
      ): F[ModifyDbSubnetGroupResponse]

      def modifyEventSubscription(
        request: ModifyEventSubscriptionRequest
      ): F[ModifyEventSubscriptionResponse]

      def promoteReadReplicaDBCluster(
        request: PromoteReadReplicaDbClusterRequest
      ): F[PromoteReadReplicaDbClusterResponse]

      def rebootDBInstance(
        request: RebootDbInstanceRequest
      ): F[RebootDbInstanceResponse]

      def removeRoleFromDBCluster(
        request: RemoveRoleFromDbClusterRequest
      ): F[RemoveRoleFromDbClusterResponse]

      def removeSourceIdentifierFromSubscription(
        request: RemoveSourceIdentifierFromSubscriptionRequest
      ): F[RemoveSourceIdentifierFromSubscriptionResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]

      def resetDBClusterParameterGroup(
        request: ResetDbClusterParameterGroupRequest
      ): F[ResetDbClusterParameterGroupResponse]

      def resetDBParameterGroup(
        request: ResetDbParameterGroupRequest
      ): F[ResetDbParameterGroupResponse]

      def restoreDBClusterFromSnapshot(
        request: RestoreDbClusterFromSnapshotRequest
      ): F[RestoreDbClusterFromSnapshotResponse]

      def restoreDBClusterToPointInTime(
        request: RestoreDbClusterToPointInTimeRequest
      ): F[RestoreDbClusterToPointInTimeResponse]

      def startDBCluster(
        request: StartDbClusterRequest
      ): F[StartDbClusterResponse]

      def stopDBCluster(
        request: StopDbClusterRequest
      ): F[StopDbClusterResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends NeptuneOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddRoleToDBClusterOp(
      request: AddRoleToDbClusterRequest
    ) extends NeptuneOp[AddRoleToDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddRoleToDbClusterResponse] =
        visitor.addRoleToDBCluster(request)
    }

    final case class AddSourceIdentifierToSubscriptionOp(
      request: AddSourceIdentifierToSubscriptionRequest
    ) extends NeptuneOp[AddSourceIdentifierToSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddSourceIdentifierToSubscriptionResponse] =
        visitor.addSourceIdentifierToSubscription(request)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends NeptuneOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class ApplyPendingMaintenanceActionOp(
      request: ApplyPendingMaintenanceActionRequest
    ) extends NeptuneOp[ApplyPendingMaintenanceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplyPendingMaintenanceActionResponse] =
        visitor.applyPendingMaintenanceAction(request)
    }

    final case class CopyDBClusterParameterGroupOp(
      request: CopyDbClusterParameterGroupRequest
    ) extends NeptuneOp[CopyDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbClusterParameterGroupResponse] =
        visitor.copyDBClusterParameterGroup(request)
    }

    final case class CopyDBClusterSnapshotOp(
      request: CopyDbClusterSnapshotRequest
    ) extends NeptuneOp[CopyDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbClusterSnapshotResponse] =
        visitor.copyDBClusterSnapshot(request)
    }

    final case class CopyDBParameterGroupOp(
      request: CopyDbParameterGroupRequest
    ) extends NeptuneOp[CopyDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbParameterGroupResponse] =
        visitor.copyDBParameterGroup(request)
    }

    final case class CreateDBClusterOp(
      request: CreateDbClusterRequest
    ) extends NeptuneOp[CreateDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterResponse] =
        visitor.createDBCluster(request)
    }

    final case class CreateDBClusterEndpointOp(
      request: CreateDbClusterEndpointRequest
    ) extends NeptuneOp[CreateDbClusterEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterEndpointResponse] =
        visitor.createDBClusterEndpoint(request)
    }

    final case class CreateDBClusterParameterGroupOp(
      request: CreateDbClusterParameterGroupRequest
    ) extends NeptuneOp[CreateDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterParameterGroupResponse] =
        visitor.createDBClusterParameterGroup(request)
    }

    final case class CreateDBClusterSnapshotOp(
      request: CreateDbClusterSnapshotRequest
    ) extends NeptuneOp[CreateDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterSnapshotResponse] =
        visitor.createDBClusterSnapshot(request)
    }

    final case class CreateDBInstanceOp(
      request: CreateDbInstanceRequest
    ) extends NeptuneOp[CreateDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbInstanceResponse] =
        visitor.createDBInstance(request)
    }

    final case class CreateDBParameterGroupOp(
      request: CreateDbParameterGroupRequest
    ) extends NeptuneOp[CreateDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbParameterGroupResponse] =
        visitor.createDBParameterGroup(request)
    }

    final case class CreateDBSubnetGroupOp(
      request: CreateDbSubnetGroupRequest
    ) extends NeptuneOp[CreateDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbSubnetGroupResponse] =
        visitor.createDBSubnetGroup(request)
    }

    final case class CreateEventSubscriptionOp(
      request: CreateEventSubscriptionRequest
    ) extends NeptuneOp[CreateEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventSubscriptionResponse] =
        visitor.createEventSubscription(request)
    }

    final case class DeleteDBClusterOp(
      request: DeleteDbClusterRequest
    ) extends NeptuneOp[DeleteDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterResponse] =
        visitor.deleteDBCluster(request)
    }

    final case class DeleteDBClusterEndpointOp(
      request: DeleteDbClusterEndpointRequest
    ) extends NeptuneOp[DeleteDbClusterEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterEndpointResponse] =
        visitor.deleteDBClusterEndpoint(request)
    }

    final case class DeleteDBClusterParameterGroupOp(
      request: DeleteDbClusterParameterGroupRequest
    ) extends NeptuneOp[DeleteDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterParameterGroupResponse] =
        visitor.deleteDBClusterParameterGroup(request)
    }

    final case class DeleteDBClusterSnapshotOp(
      request: DeleteDbClusterSnapshotRequest
    ) extends NeptuneOp[DeleteDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterSnapshotResponse] =
        visitor.deleteDBClusterSnapshot(request)
    }

    final case class DeleteDBInstanceOp(
      request: DeleteDbInstanceRequest
    ) extends NeptuneOp[DeleteDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbInstanceResponse] =
        visitor.deleteDBInstance(request)
    }

    final case class DeleteDBParameterGroupOp(
      request: DeleteDbParameterGroupRequest
    ) extends NeptuneOp[DeleteDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbParameterGroupResponse] =
        visitor.deleteDBParameterGroup(request)
    }

    final case class DeleteDBSubnetGroupOp(
      request: DeleteDbSubnetGroupRequest
    ) extends NeptuneOp[DeleteDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbSubnetGroupResponse] =
        visitor.deleteDBSubnetGroup(request)
    }

    final case class DeleteEventSubscriptionOp(
      request: DeleteEventSubscriptionRequest
    ) extends NeptuneOp[DeleteEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventSubscriptionResponse] =
        visitor.deleteEventSubscription(request)
    }

    final case class DescribeDBClusterEndpointsOp(
      request: DescribeDbClusterEndpointsRequest
    ) extends NeptuneOp[DescribeDbClusterEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterEndpointsResponse] =
        visitor.describeDBClusterEndpoints(request)
    }

    final case class DescribeDBClusterParameterGroupsOp(
      request: DescribeDbClusterParameterGroupsRequest
    ) extends NeptuneOp[DescribeDbClusterParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterParameterGroupsResponse] =
        visitor.describeDBClusterParameterGroups(request)
    }

    final case class DescribeDBClusterParametersOp(
      request: DescribeDbClusterParametersRequest
    ) extends NeptuneOp[DescribeDbClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterParametersResponse] =
        visitor.describeDBClusterParameters(request)
    }

    final case class DescribeDBClusterSnapshotAttributesOp(
      request: DescribeDbClusterSnapshotAttributesRequest
    ) extends NeptuneOp[DescribeDbClusterSnapshotAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterSnapshotAttributesResponse] =
        visitor.describeDBClusterSnapshotAttributes(request)
    }

    final case class DescribeDBClusterSnapshotsOp(
      request: DescribeDbClusterSnapshotsRequest
    ) extends NeptuneOp[DescribeDbClusterSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterSnapshotsResponse] =
        visitor.describeDBClusterSnapshots(request)
    }

    final case class DescribeDBClustersOp(
      request: DescribeDbClustersRequest
    ) extends NeptuneOp[DescribeDbClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClustersResponse] =
        visitor.describeDBClusters(request)
    }

    final case class DescribeDBEngineVersionsOp(
      request: DescribeDbEngineVersionsRequest
    ) extends NeptuneOp[DescribeDbEngineVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbEngineVersionsResponse] =
        visitor.describeDBEngineVersions(request)
    }

    final case class DescribeDBInstancesOp(
      request: DescribeDbInstancesRequest
    ) extends NeptuneOp[DescribeDbInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbInstancesResponse] =
        visitor.describeDBInstances(request)
    }

    final case class DescribeDBParameterGroupsOp(
      request: DescribeDbParameterGroupsRequest
    ) extends NeptuneOp[DescribeDbParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbParameterGroupsResponse] =
        visitor.describeDBParameterGroups(request)
    }

    final case class DescribeDBParametersOp(
      request: DescribeDbParametersRequest
    ) extends NeptuneOp[DescribeDbParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbParametersResponse] =
        visitor.describeDBParameters(request)
    }

    final case class DescribeDBSubnetGroupsOp(
      request: DescribeDbSubnetGroupsRequest
    ) extends NeptuneOp[DescribeDbSubnetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbSubnetGroupsResponse] =
        visitor.describeDBSubnetGroups(request)
    }

    final case class DescribeEngineDefaultClusterParametersOp(
      request: DescribeEngineDefaultClusterParametersRequest
    ) extends NeptuneOp[DescribeEngineDefaultClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEngineDefaultClusterParametersResponse] =
        visitor.describeEngineDefaultClusterParameters(request)
    }

    final case class DescribeEngineDefaultParametersOp(
      request: DescribeEngineDefaultParametersRequest
    ) extends NeptuneOp[DescribeEngineDefaultParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEngineDefaultParametersResponse] =
        visitor.describeEngineDefaultParameters(request)
    }

    final case class DescribeEventCategoriesOp(
      request: DescribeEventCategoriesRequest
    ) extends NeptuneOp[DescribeEventCategoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventCategoriesResponse] =
        visitor.describeEventCategories(request)
    }

    final case class DescribeEventSubscriptionsOp(
      request: DescribeEventSubscriptionsRequest
    ) extends NeptuneOp[DescribeEventSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventSubscriptionsResponse] =
        visitor.describeEventSubscriptions(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends NeptuneOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeOrderableDBInstanceOptionsOp(
      request: DescribeOrderableDbInstanceOptionsRequest
    ) extends NeptuneOp[DescribeOrderableDbInstanceOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrderableDbInstanceOptionsResponse] =
        visitor.describeOrderableDBInstanceOptions(request)
    }

    final case class DescribePendingMaintenanceActionsOp(
      request: DescribePendingMaintenanceActionsRequest
    ) extends NeptuneOp[DescribePendingMaintenanceActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePendingMaintenanceActionsResponse] =
        visitor.describePendingMaintenanceActions(request)
    }

    final case class DescribeValidDBInstanceModificationsOp(
      request: DescribeValidDbInstanceModificationsRequest
    ) extends NeptuneOp[DescribeValidDbInstanceModificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeValidDbInstanceModificationsResponse] =
        visitor.describeValidDBInstanceModifications(request)
    }

    final case class FailoverDBClusterOp(
      request: FailoverDbClusterRequest
    ) extends NeptuneOp[FailoverDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FailoverDbClusterResponse] =
        visitor.failoverDBCluster(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends NeptuneOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyDBClusterOp(
      request: ModifyDbClusterRequest
    ) extends NeptuneOp[ModifyDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterResponse] =
        visitor.modifyDBCluster(request)
    }

    final case class ModifyDBClusterEndpointOp(
      request: ModifyDbClusterEndpointRequest
    ) extends NeptuneOp[ModifyDbClusterEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterEndpointResponse] =
        visitor.modifyDBClusterEndpoint(request)
    }

    final case class ModifyDBClusterParameterGroupOp(
      request: ModifyDbClusterParameterGroupRequest
    ) extends NeptuneOp[ModifyDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterParameterGroupResponse] =
        visitor.modifyDBClusterParameterGroup(request)
    }

    final case class ModifyDBClusterSnapshotAttributeOp(
      request: ModifyDbClusterSnapshotAttributeRequest
    ) extends NeptuneOp[ModifyDbClusterSnapshotAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterSnapshotAttributeResponse] =
        visitor.modifyDBClusterSnapshotAttribute(request)
    }

    final case class ModifyDBInstanceOp(
      request: ModifyDbInstanceRequest
    ) extends NeptuneOp[ModifyDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbInstanceResponse] =
        visitor.modifyDBInstance(request)
    }

    final case class ModifyDBParameterGroupOp(
      request: ModifyDbParameterGroupRequest
    ) extends NeptuneOp[ModifyDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbParameterGroupResponse] =
        visitor.modifyDBParameterGroup(request)
    }

    final case class ModifyDBSubnetGroupOp(
      request: ModifyDbSubnetGroupRequest
    ) extends NeptuneOp[ModifyDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbSubnetGroupResponse] =
        visitor.modifyDBSubnetGroup(request)
    }

    final case class ModifyEventSubscriptionOp(
      request: ModifyEventSubscriptionRequest
    ) extends NeptuneOp[ModifyEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEventSubscriptionResponse] =
        visitor.modifyEventSubscription(request)
    }

    final case class PromoteReadReplicaDBClusterOp(
      request: PromoteReadReplicaDbClusterRequest
    ) extends NeptuneOp[PromoteReadReplicaDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PromoteReadReplicaDbClusterResponse] =
        visitor.promoteReadReplicaDBCluster(request)
    }

    final case class RebootDBInstanceOp(
      request: RebootDbInstanceRequest
    ) extends NeptuneOp[RebootDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootDbInstanceResponse] =
        visitor.rebootDBInstance(request)
    }

    final case class RemoveRoleFromDBClusterOp(
      request: RemoveRoleFromDbClusterRequest
    ) extends NeptuneOp[RemoveRoleFromDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveRoleFromDbClusterResponse] =
        visitor.removeRoleFromDBCluster(request)
    }

    final case class RemoveSourceIdentifierFromSubscriptionOp(
      request: RemoveSourceIdentifierFromSubscriptionRequest
    ) extends NeptuneOp[RemoveSourceIdentifierFromSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveSourceIdentifierFromSubscriptionResponse] =
        visitor.removeSourceIdentifierFromSubscription(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends NeptuneOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class ResetDBClusterParameterGroupOp(
      request: ResetDbClusterParameterGroupRequest
    ) extends NeptuneOp[ResetDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetDbClusterParameterGroupResponse] =
        visitor.resetDBClusterParameterGroup(request)
    }

    final case class ResetDBParameterGroupOp(
      request: ResetDbParameterGroupRequest
    ) extends NeptuneOp[ResetDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetDbParameterGroupResponse] =
        visitor.resetDBParameterGroup(request)
    }

    final case class RestoreDBClusterFromSnapshotOp(
      request: RestoreDbClusterFromSnapshotRequest
    ) extends NeptuneOp[RestoreDbClusterFromSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbClusterFromSnapshotResponse] =
        visitor.restoreDBClusterFromSnapshot(request)
    }

    final case class RestoreDBClusterToPointInTimeOp(
      request: RestoreDbClusterToPointInTimeRequest
    ) extends NeptuneOp[RestoreDbClusterToPointInTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbClusterToPointInTimeResponse] =
        visitor.restoreDBClusterToPointInTime(request)
    }

    final case class StartDBClusterOp(
      request: StartDbClusterRequest
    ) extends NeptuneOp[StartDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDbClusterResponse] =
        visitor.startDBCluster(request)
    }

    final case class StopDBClusterOp(
      request: StopDbClusterRequest
    ) extends NeptuneOp[StopDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDbClusterResponse] =
        visitor.stopDBCluster(request)
    }
  }

  import NeptuneOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[NeptuneOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addRoleToDBCluster(
    request: AddRoleToDbClusterRequest
  ): NeptuneIO[AddRoleToDbClusterResponse] =
    FF.liftF(AddRoleToDBClusterOp(request))

  def addSourceIdentifierToSubscription(
    request: AddSourceIdentifierToSubscriptionRequest
  ): NeptuneIO[AddSourceIdentifierToSubscriptionResponse] =
    FF.liftF(AddSourceIdentifierToSubscriptionOp(request))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): NeptuneIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def applyPendingMaintenanceAction(
    request: ApplyPendingMaintenanceActionRequest
  ): NeptuneIO[ApplyPendingMaintenanceActionResponse] =
    FF.liftF(ApplyPendingMaintenanceActionOp(request))

  def copyDBClusterParameterGroup(
    request: CopyDbClusterParameterGroupRequest
  ): NeptuneIO[CopyDbClusterParameterGroupResponse] =
    FF.liftF(CopyDBClusterParameterGroupOp(request))

  def copyDBClusterSnapshot(
    request: CopyDbClusterSnapshotRequest
  ): NeptuneIO[CopyDbClusterSnapshotResponse] =
    FF.liftF(CopyDBClusterSnapshotOp(request))

  def copyDBParameterGroup(
    request: CopyDbParameterGroupRequest
  ): NeptuneIO[CopyDbParameterGroupResponse] =
    FF.liftF(CopyDBParameterGroupOp(request))

  def createDBCluster(
    request: CreateDbClusterRequest
  ): NeptuneIO[CreateDbClusterResponse] =
    FF.liftF(CreateDBClusterOp(request))

  def createDBClusterEndpoint(
    request: CreateDbClusterEndpointRequest
  ): NeptuneIO[CreateDbClusterEndpointResponse] =
    FF.liftF(CreateDBClusterEndpointOp(request))

  def createDBClusterParameterGroup(
    request: CreateDbClusterParameterGroupRequest
  ): NeptuneIO[CreateDbClusterParameterGroupResponse] =
    FF.liftF(CreateDBClusterParameterGroupOp(request))

  def createDBClusterSnapshot(
    request: CreateDbClusterSnapshotRequest
  ): NeptuneIO[CreateDbClusterSnapshotResponse] =
    FF.liftF(CreateDBClusterSnapshotOp(request))

  def createDBInstance(
    request: CreateDbInstanceRequest
  ): NeptuneIO[CreateDbInstanceResponse] =
    FF.liftF(CreateDBInstanceOp(request))

  def createDBParameterGroup(
    request: CreateDbParameterGroupRequest
  ): NeptuneIO[CreateDbParameterGroupResponse] =
    FF.liftF(CreateDBParameterGroupOp(request))

  def createDBSubnetGroup(
    request: CreateDbSubnetGroupRequest
  ): NeptuneIO[CreateDbSubnetGroupResponse] =
    FF.liftF(CreateDBSubnetGroupOp(request))

  def createEventSubscription(
    request: CreateEventSubscriptionRequest
  ): NeptuneIO[CreateEventSubscriptionResponse] =
    FF.liftF(CreateEventSubscriptionOp(request))

  def deleteDBCluster(
    request: DeleteDbClusterRequest
  ): NeptuneIO[DeleteDbClusterResponse] =
    FF.liftF(DeleteDBClusterOp(request))

  def deleteDBClusterEndpoint(
    request: DeleteDbClusterEndpointRequest
  ): NeptuneIO[DeleteDbClusterEndpointResponse] =
    FF.liftF(DeleteDBClusterEndpointOp(request))

  def deleteDBClusterParameterGroup(
    request: DeleteDbClusterParameterGroupRequest
  ): NeptuneIO[DeleteDbClusterParameterGroupResponse] =
    FF.liftF(DeleteDBClusterParameterGroupOp(request))

  def deleteDBClusterSnapshot(
    request: DeleteDbClusterSnapshotRequest
  ): NeptuneIO[DeleteDbClusterSnapshotResponse] =
    FF.liftF(DeleteDBClusterSnapshotOp(request))

  def deleteDBInstance(
    request: DeleteDbInstanceRequest
  ): NeptuneIO[DeleteDbInstanceResponse] =
    FF.liftF(DeleteDBInstanceOp(request))

  def deleteDBParameterGroup(
    request: DeleteDbParameterGroupRequest
  ): NeptuneIO[DeleteDbParameterGroupResponse] =
    FF.liftF(DeleteDBParameterGroupOp(request))

  def deleteDBSubnetGroup(
    request: DeleteDbSubnetGroupRequest
  ): NeptuneIO[DeleteDbSubnetGroupResponse] =
    FF.liftF(DeleteDBSubnetGroupOp(request))

  def deleteEventSubscription(
    request: DeleteEventSubscriptionRequest
  ): NeptuneIO[DeleteEventSubscriptionResponse] =
    FF.liftF(DeleteEventSubscriptionOp(request))

  def describeDBClusterEndpoints(
    request: DescribeDbClusterEndpointsRequest
  ): NeptuneIO[DescribeDbClusterEndpointsResponse] =
    FF.liftF(DescribeDBClusterEndpointsOp(request))

  def describeDBClusterParameterGroups(
    request: DescribeDbClusterParameterGroupsRequest
  ): NeptuneIO[DescribeDbClusterParameterGroupsResponse] =
    FF.liftF(DescribeDBClusterParameterGroupsOp(request))

  def describeDBClusterParameters(
    request: DescribeDbClusterParametersRequest
  ): NeptuneIO[DescribeDbClusterParametersResponse] =
    FF.liftF(DescribeDBClusterParametersOp(request))

  def describeDBClusterSnapshotAttributes(
    request: DescribeDbClusterSnapshotAttributesRequest
  ): NeptuneIO[DescribeDbClusterSnapshotAttributesResponse] =
    FF.liftF(DescribeDBClusterSnapshotAttributesOp(request))

  def describeDBClusterSnapshots(
    request: DescribeDbClusterSnapshotsRequest
  ): NeptuneIO[DescribeDbClusterSnapshotsResponse] =
    FF.liftF(DescribeDBClusterSnapshotsOp(request))

  def describeDBClusters(
    request: DescribeDbClustersRequest
  ): NeptuneIO[DescribeDbClustersResponse] =
    FF.liftF(DescribeDBClustersOp(request))

  def describeDBEngineVersions(
    request: DescribeDbEngineVersionsRequest
  ): NeptuneIO[DescribeDbEngineVersionsResponse] =
    FF.liftF(DescribeDBEngineVersionsOp(request))

  def describeDBInstances(
    request: DescribeDbInstancesRequest
  ): NeptuneIO[DescribeDbInstancesResponse] =
    FF.liftF(DescribeDBInstancesOp(request))

  def describeDBParameterGroups(
    request: DescribeDbParameterGroupsRequest
  ): NeptuneIO[DescribeDbParameterGroupsResponse] =
    FF.liftF(DescribeDBParameterGroupsOp(request))

  def describeDBParameters(
    request: DescribeDbParametersRequest
  ): NeptuneIO[DescribeDbParametersResponse] =
    FF.liftF(DescribeDBParametersOp(request))

  def describeDBSubnetGroups(
    request: DescribeDbSubnetGroupsRequest
  ): NeptuneIO[DescribeDbSubnetGroupsResponse] =
    FF.liftF(DescribeDBSubnetGroupsOp(request))

  def describeEngineDefaultClusterParameters(
    request: DescribeEngineDefaultClusterParametersRequest
  ): NeptuneIO[DescribeEngineDefaultClusterParametersResponse] =
    FF.liftF(DescribeEngineDefaultClusterParametersOp(request))

  def describeEngineDefaultParameters(
    request: DescribeEngineDefaultParametersRequest
  ): NeptuneIO[DescribeEngineDefaultParametersResponse] =
    FF.liftF(DescribeEngineDefaultParametersOp(request))

  def describeEventCategories(
    request: DescribeEventCategoriesRequest
  ): NeptuneIO[DescribeEventCategoriesResponse] =
    FF.liftF(DescribeEventCategoriesOp(request))

  def describeEventSubscriptions(
    request: DescribeEventSubscriptionsRequest
  ): NeptuneIO[DescribeEventSubscriptionsResponse] =
    FF.liftF(DescribeEventSubscriptionsOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): NeptuneIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeOrderableDBInstanceOptions(
    request: DescribeOrderableDbInstanceOptionsRequest
  ): NeptuneIO[DescribeOrderableDbInstanceOptionsResponse] =
    FF.liftF(DescribeOrderableDBInstanceOptionsOp(request))

  def describePendingMaintenanceActions(
    request: DescribePendingMaintenanceActionsRequest
  ): NeptuneIO[DescribePendingMaintenanceActionsResponse] =
    FF.liftF(DescribePendingMaintenanceActionsOp(request))

  def describeValidDBInstanceModifications(
    request: DescribeValidDbInstanceModificationsRequest
  ): NeptuneIO[DescribeValidDbInstanceModificationsResponse] =
    FF.liftF(DescribeValidDBInstanceModificationsOp(request))

  def failoverDBCluster(
    request: FailoverDbClusterRequest
  ): NeptuneIO[FailoverDbClusterResponse] =
    FF.liftF(FailoverDBClusterOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): NeptuneIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyDBCluster(
    request: ModifyDbClusterRequest
  ): NeptuneIO[ModifyDbClusterResponse] =
    FF.liftF(ModifyDBClusterOp(request))

  def modifyDBClusterEndpoint(
    request: ModifyDbClusterEndpointRequest
  ): NeptuneIO[ModifyDbClusterEndpointResponse] =
    FF.liftF(ModifyDBClusterEndpointOp(request))

  def modifyDBClusterParameterGroup(
    request: ModifyDbClusterParameterGroupRequest
  ): NeptuneIO[ModifyDbClusterParameterGroupResponse] =
    FF.liftF(ModifyDBClusterParameterGroupOp(request))

  def modifyDBClusterSnapshotAttribute(
    request: ModifyDbClusterSnapshotAttributeRequest
  ): NeptuneIO[ModifyDbClusterSnapshotAttributeResponse] =
    FF.liftF(ModifyDBClusterSnapshotAttributeOp(request))

  def modifyDBInstance(
    request: ModifyDbInstanceRequest
  ): NeptuneIO[ModifyDbInstanceResponse] =
    FF.liftF(ModifyDBInstanceOp(request))

  def modifyDBParameterGroup(
    request: ModifyDbParameterGroupRequest
  ): NeptuneIO[ModifyDbParameterGroupResponse] =
    FF.liftF(ModifyDBParameterGroupOp(request))

  def modifyDBSubnetGroup(
    request: ModifyDbSubnetGroupRequest
  ): NeptuneIO[ModifyDbSubnetGroupResponse] =
    FF.liftF(ModifyDBSubnetGroupOp(request))

  def modifyEventSubscription(
    request: ModifyEventSubscriptionRequest
  ): NeptuneIO[ModifyEventSubscriptionResponse] =
    FF.liftF(ModifyEventSubscriptionOp(request))

  def promoteReadReplicaDBCluster(
    request: PromoteReadReplicaDbClusterRequest
  ): NeptuneIO[PromoteReadReplicaDbClusterResponse] =
    FF.liftF(PromoteReadReplicaDBClusterOp(request))

  def rebootDBInstance(
    request: RebootDbInstanceRequest
  ): NeptuneIO[RebootDbInstanceResponse] =
    FF.liftF(RebootDBInstanceOp(request))

  def removeRoleFromDBCluster(
    request: RemoveRoleFromDbClusterRequest
  ): NeptuneIO[RemoveRoleFromDbClusterResponse] =
    FF.liftF(RemoveRoleFromDBClusterOp(request))

  def removeSourceIdentifierFromSubscription(
    request: RemoveSourceIdentifierFromSubscriptionRequest
  ): NeptuneIO[RemoveSourceIdentifierFromSubscriptionResponse] =
    FF.liftF(RemoveSourceIdentifierFromSubscriptionOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): NeptuneIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def resetDBClusterParameterGroup(
    request: ResetDbClusterParameterGroupRequest
  ): NeptuneIO[ResetDbClusterParameterGroupResponse] =
    FF.liftF(ResetDBClusterParameterGroupOp(request))

  def resetDBParameterGroup(
    request: ResetDbParameterGroupRequest
  ): NeptuneIO[ResetDbParameterGroupResponse] =
    FF.liftF(ResetDBParameterGroupOp(request))

  def restoreDBClusterFromSnapshot(
    request: RestoreDbClusterFromSnapshotRequest
  ): NeptuneIO[RestoreDbClusterFromSnapshotResponse] =
    FF.liftF(RestoreDBClusterFromSnapshotOp(request))

  def restoreDBClusterToPointInTime(
    request: RestoreDbClusterToPointInTimeRequest
  ): NeptuneIO[RestoreDbClusterToPointInTimeResponse] =
    FF.liftF(RestoreDBClusterToPointInTimeOp(request))

  def startDBCluster(
    request: StartDbClusterRequest
  ): NeptuneIO[StartDbClusterResponse] =
    FF.liftF(StartDBClusterOp(request))

  def stopDBCluster(
    request: StopDbClusterRequest
  ): NeptuneIO[StopDbClusterResponse] =
    FF.liftF(StopDBClusterOp(request))
}
