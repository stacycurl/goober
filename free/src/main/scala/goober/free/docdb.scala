package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.docdb.DocDbClient
import software.amazon.awssdk.services.docdb.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object docdb { module =>

  // Free monad over DocDbOp
  type DocDbIO[A] = FF[DocDbOp, A]

  sealed trait DocDbOp[A] {
    def visit[F[_]](visitor: DocDbOp.Visitor[F]): F[A]
  }

  object DocDbOp {
    // Given a DocDbClient we can embed a DocDbIO program in any algebra that understands embedding.
    implicit val DocDbOpEmbeddable: Embeddable[DocDbOp, DocDbClient] = new Embeddable[DocDbOp, DocDbClient] {
      def embed[A](client: DocDbClient, io: DocDbIO[A]): Embedded[A] = Embedded.DocDb(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DocDbOp.Visitor[Kleisli[M, DocDbClient, *]] {
        def addSourceIdentifierToSubscription(
          request: AddSourceIdentifierToSubscriptionRequest
        ): Kleisli[M, DocDbClient, AddSourceIdentifierToSubscriptionResponse] =
          primitive(_.addSourceIdentifierToSubscription(request))

        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, DocDbClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def applyPendingMaintenanceAction(
          request: ApplyPendingMaintenanceActionRequest
        ): Kleisli[M, DocDbClient, ApplyPendingMaintenanceActionResponse] =
          primitive(_.applyPendingMaintenanceAction(request))

        def copyDBClusterParameterGroup(
          request: CopyDbClusterParameterGroupRequest
        ): Kleisli[M, DocDbClient, CopyDbClusterParameterGroupResponse] =
          primitive(_.copyDBClusterParameterGroup(request))

        def copyDBClusterSnapshot(
          request: CopyDbClusterSnapshotRequest
        ): Kleisli[M, DocDbClient, CopyDbClusterSnapshotResponse] =
          primitive(_.copyDBClusterSnapshot(request))

        def createDBCluster(
          request: CreateDbClusterRequest
        ): Kleisli[M, DocDbClient, CreateDbClusterResponse] =
          primitive(_.createDBCluster(request))

        def createDBClusterParameterGroup(
          request: CreateDbClusterParameterGroupRequest
        ): Kleisli[M, DocDbClient, CreateDbClusterParameterGroupResponse] =
          primitive(_.createDBClusterParameterGroup(request))

        def createDBClusterSnapshot(
          request: CreateDbClusterSnapshotRequest
        ): Kleisli[M, DocDbClient, CreateDbClusterSnapshotResponse] =
          primitive(_.createDBClusterSnapshot(request))

        def createDBInstance(
          request: CreateDbInstanceRequest
        ): Kleisli[M, DocDbClient, CreateDbInstanceResponse] =
          primitive(_.createDBInstance(request))

        def createDBSubnetGroup(
          request: CreateDbSubnetGroupRequest
        ): Kleisli[M, DocDbClient, CreateDbSubnetGroupResponse] =
          primitive(_.createDBSubnetGroup(request))

        def createEventSubscription(
          request: CreateEventSubscriptionRequest
        ): Kleisli[M, DocDbClient, CreateEventSubscriptionResponse] =
          primitive(_.createEventSubscription(request))

        def createGlobalCluster(
          request: CreateGlobalClusterRequest
        ): Kleisli[M, DocDbClient, CreateGlobalClusterResponse] =
          primitive(_.createGlobalCluster(request))

        def deleteDBCluster(
          request: DeleteDbClusterRequest
        ): Kleisli[M, DocDbClient, DeleteDbClusterResponse] =
          primitive(_.deleteDBCluster(request))

        def deleteDBClusterParameterGroup(
          request: DeleteDbClusterParameterGroupRequest
        ): Kleisli[M, DocDbClient, DeleteDbClusterParameterGroupResponse] =
          primitive(_.deleteDBClusterParameterGroup(request))

        def deleteDBClusterSnapshot(
          request: DeleteDbClusterSnapshotRequest
        ): Kleisli[M, DocDbClient, DeleteDbClusterSnapshotResponse] =
          primitive(_.deleteDBClusterSnapshot(request))

        def deleteDBInstance(
          request: DeleteDbInstanceRequest
        ): Kleisli[M, DocDbClient, DeleteDbInstanceResponse] =
          primitive(_.deleteDBInstance(request))

        def deleteDBSubnetGroup(
          request: DeleteDbSubnetGroupRequest
        ): Kleisli[M, DocDbClient, DeleteDbSubnetGroupResponse] =
          primitive(_.deleteDBSubnetGroup(request))

        def deleteEventSubscription(
          request: DeleteEventSubscriptionRequest
        ): Kleisli[M, DocDbClient, DeleteEventSubscriptionResponse] =
          primitive(_.deleteEventSubscription(request))

        def deleteGlobalCluster(
          request: DeleteGlobalClusterRequest
        ): Kleisli[M, DocDbClient, DeleteGlobalClusterResponse] =
          primitive(_.deleteGlobalCluster(request))

        def describeCertificates(
          request: DescribeCertificatesRequest
        ): Kleisli[M, DocDbClient, DescribeCertificatesResponse] =
          primitive(_.describeCertificates(request))

        def describeDBClusterParameterGroups(
          request: DescribeDbClusterParameterGroupsRequest
        ): Kleisli[M, DocDbClient, DescribeDbClusterParameterGroupsResponse] =
          primitive(_.describeDBClusterParameterGroups(request))

        def describeDBClusterParameters(
          request: DescribeDbClusterParametersRequest
        ): Kleisli[M, DocDbClient, DescribeDbClusterParametersResponse] =
          primitive(_.describeDBClusterParameters(request))

        def describeDBClusterSnapshotAttributes(
          request: DescribeDbClusterSnapshotAttributesRequest
        ): Kleisli[M, DocDbClient, DescribeDbClusterSnapshotAttributesResponse] =
          primitive(_.describeDBClusterSnapshotAttributes(request))

        def describeDBClusterSnapshots(
          request: DescribeDbClusterSnapshotsRequest
        ): Kleisli[M, DocDbClient, DescribeDbClusterSnapshotsResponse] =
          primitive(_.describeDBClusterSnapshots(request))

        def describeDBClusters(
          request: DescribeDbClustersRequest
        ): Kleisli[M, DocDbClient, DescribeDbClustersResponse] =
          primitive(_.describeDBClusters(request))

        def describeDBEngineVersions(
          request: DescribeDbEngineVersionsRequest
        ): Kleisli[M, DocDbClient, DescribeDbEngineVersionsResponse] =
          primitive(_.describeDBEngineVersions(request))

        def describeDBInstances(
          request: DescribeDbInstancesRequest
        ): Kleisli[M, DocDbClient, DescribeDbInstancesResponse] =
          primitive(_.describeDBInstances(request))

        def describeDBSubnetGroups(
          request: DescribeDbSubnetGroupsRequest
        ): Kleisli[M, DocDbClient, DescribeDbSubnetGroupsResponse] =
          primitive(_.describeDBSubnetGroups(request))

        def describeEngineDefaultClusterParameters(
          request: DescribeEngineDefaultClusterParametersRequest
        ): Kleisli[M, DocDbClient, DescribeEngineDefaultClusterParametersResponse] =
          primitive(_.describeEngineDefaultClusterParameters(request))

        def describeEventCategories(
          request: DescribeEventCategoriesRequest
        ): Kleisli[M, DocDbClient, DescribeEventCategoriesResponse] =
          primitive(_.describeEventCategories(request))

        def describeEventSubscriptions(
          request: DescribeEventSubscriptionsRequest
        ): Kleisli[M, DocDbClient, DescribeEventSubscriptionsResponse] =
          primitive(_.describeEventSubscriptions(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, DocDbClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeGlobalClusters(
          request: DescribeGlobalClustersRequest
        ): Kleisli[M, DocDbClient, DescribeGlobalClustersResponse] =
          primitive(_.describeGlobalClusters(request))

        def describeOrderableDBInstanceOptions(
          request: DescribeOrderableDbInstanceOptionsRequest
        ): Kleisli[M, DocDbClient, DescribeOrderableDbInstanceOptionsResponse] =
          primitive(_.describeOrderableDBInstanceOptions(request))

        def describePendingMaintenanceActions(
          request: DescribePendingMaintenanceActionsRequest
        ): Kleisli[M, DocDbClient, DescribePendingMaintenanceActionsResponse] =
          primitive(_.describePendingMaintenanceActions(request))

        def failoverDBCluster(
          request: FailoverDbClusterRequest
        ): Kleisli[M, DocDbClient, FailoverDbClusterResponse] =
          primitive(_.failoverDBCluster(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DocDbClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyDBCluster(
          request: ModifyDbClusterRequest
        ): Kleisli[M, DocDbClient, ModifyDbClusterResponse] =
          primitive(_.modifyDBCluster(request))

        def modifyDBClusterParameterGroup(
          request: ModifyDbClusterParameterGroupRequest
        ): Kleisli[M, DocDbClient, ModifyDbClusterParameterGroupResponse] =
          primitive(_.modifyDBClusterParameterGroup(request))

        def modifyDBClusterSnapshotAttribute(
          request: ModifyDbClusterSnapshotAttributeRequest
        ): Kleisli[M, DocDbClient, ModifyDbClusterSnapshotAttributeResponse] =
          primitive(_.modifyDBClusterSnapshotAttribute(request))

        def modifyDBInstance(
          request: ModifyDbInstanceRequest
        ): Kleisli[M, DocDbClient, ModifyDbInstanceResponse] =
          primitive(_.modifyDBInstance(request))

        def modifyDBSubnetGroup(
          request: ModifyDbSubnetGroupRequest
        ): Kleisli[M, DocDbClient, ModifyDbSubnetGroupResponse] =
          primitive(_.modifyDBSubnetGroup(request))

        def modifyEventSubscription(
          request: ModifyEventSubscriptionRequest
        ): Kleisli[M, DocDbClient, ModifyEventSubscriptionResponse] =
          primitive(_.modifyEventSubscription(request))

        def modifyGlobalCluster(
          request: ModifyGlobalClusterRequest
        ): Kleisli[M, DocDbClient, ModifyGlobalClusterResponse] =
          primitive(_.modifyGlobalCluster(request))

        def rebootDBInstance(
          request: RebootDbInstanceRequest
        ): Kleisli[M, DocDbClient, RebootDbInstanceResponse] =
          primitive(_.rebootDBInstance(request))

        def removeFromGlobalCluster(
          request: RemoveFromGlobalClusterRequest
        ): Kleisli[M, DocDbClient, RemoveFromGlobalClusterResponse] =
          primitive(_.removeFromGlobalCluster(request))

        def removeSourceIdentifierFromSubscription(
          request: RemoveSourceIdentifierFromSubscriptionRequest
        ): Kleisli[M, DocDbClient, RemoveSourceIdentifierFromSubscriptionResponse] =
          primitive(_.removeSourceIdentifierFromSubscription(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, DocDbClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def resetDBClusterParameterGroup(
          request: ResetDbClusterParameterGroupRequest
        ): Kleisli[M, DocDbClient, ResetDbClusterParameterGroupResponse] =
          primitive(_.resetDBClusterParameterGroup(request))

        def restoreDBClusterFromSnapshot(
          request: RestoreDbClusterFromSnapshotRequest
        ): Kleisli[M, DocDbClient, RestoreDbClusterFromSnapshotResponse] =
          primitive(_.restoreDBClusterFromSnapshot(request))

        def restoreDBClusterToPointInTime(
          request: RestoreDbClusterToPointInTimeRequest
        ): Kleisli[M, DocDbClient, RestoreDbClusterToPointInTimeResponse] =
          primitive(_.restoreDBClusterToPointInTime(request))

        def startDBCluster(
          request: StartDbClusterRequest
        ): Kleisli[M, DocDbClient, StartDbClusterResponse] =
          primitive(_.startDBCluster(request))

        def stopDBCluster(
          request: StopDbClusterRequest
        ): Kleisli[M, DocDbClient, StopDbClusterResponse] =
          primitive(_.stopDBCluster(request))

        def primitive[A](
          f: DocDbClient => A
        ): Kleisli[M, DocDbClient, A]
      }
    }

    trait Visitor[F[_]] extends (DocDbOp ~> F) {
      final def apply[A](op: DocDbOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

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

      def createDBCluster(
        request: CreateDbClusterRequest
      ): F[CreateDbClusterResponse]

      def createDBClusterParameterGroup(
        request: CreateDbClusterParameterGroupRequest
      ): F[CreateDbClusterParameterGroupResponse]

      def createDBClusterSnapshot(
        request: CreateDbClusterSnapshotRequest
      ): F[CreateDbClusterSnapshotResponse]

      def createDBInstance(
        request: CreateDbInstanceRequest
      ): F[CreateDbInstanceResponse]

      def createDBSubnetGroup(
        request: CreateDbSubnetGroupRequest
      ): F[CreateDbSubnetGroupResponse]

      def createEventSubscription(
        request: CreateEventSubscriptionRequest
      ): F[CreateEventSubscriptionResponse]

      def createGlobalCluster(
        request: CreateGlobalClusterRequest
      ): F[CreateGlobalClusterResponse]

      def deleteDBCluster(
        request: DeleteDbClusterRequest
      ): F[DeleteDbClusterResponse]

      def deleteDBClusterParameterGroup(
        request: DeleteDbClusterParameterGroupRequest
      ): F[DeleteDbClusterParameterGroupResponse]

      def deleteDBClusterSnapshot(
        request: DeleteDbClusterSnapshotRequest
      ): F[DeleteDbClusterSnapshotResponse]

      def deleteDBInstance(
        request: DeleteDbInstanceRequest
      ): F[DeleteDbInstanceResponse]

      def deleteDBSubnetGroup(
        request: DeleteDbSubnetGroupRequest
      ): F[DeleteDbSubnetGroupResponse]

      def deleteEventSubscription(
        request: DeleteEventSubscriptionRequest
      ): F[DeleteEventSubscriptionResponse]

      def deleteGlobalCluster(
        request: DeleteGlobalClusterRequest
      ): F[DeleteGlobalClusterResponse]

      def describeCertificates(
        request: DescribeCertificatesRequest
      ): F[DescribeCertificatesResponse]

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

      def describeDBSubnetGroups(
        request: DescribeDbSubnetGroupsRequest
      ): F[DescribeDbSubnetGroupsResponse]

      def describeEngineDefaultClusterParameters(
        request: DescribeEngineDefaultClusterParametersRequest
      ): F[DescribeEngineDefaultClusterParametersResponse]

      def describeEventCategories(
        request: DescribeEventCategoriesRequest
      ): F[DescribeEventCategoriesResponse]

      def describeEventSubscriptions(
        request: DescribeEventSubscriptionsRequest
      ): F[DescribeEventSubscriptionsResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeGlobalClusters(
        request: DescribeGlobalClustersRequest
      ): F[DescribeGlobalClustersResponse]

      def describeOrderableDBInstanceOptions(
        request: DescribeOrderableDbInstanceOptionsRequest
      ): F[DescribeOrderableDbInstanceOptionsResponse]

      def describePendingMaintenanceActions(
        request: DescribePendingMaintenanceActionsRequest
      ): F[DescribePendingMaintenanceActionsResponse]

      def failoverDBCluster(
        request: FailoverDbClusterRequest
      ): F[FailoverDbClusterResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyDBCluster(
        request: ModifyDbClusterRequest
      ): F[ModifyDbClusterResponse]

      def modifyDBClusterParameterGroup(
        request: ModifyDbClusterParameterGroupRequest
      ): F[ModifyDbClusterParameterGroupResponse]

      def modifyDBClusterSnapshotAttribute(
        request: ModifyDbClusterSnapshotAttributeRequest
      ): F[ModifyDbClusterSnapshotAttributeResponse]

      def modifyDBInstance(
        request: ModifyDbInstanceRequest
      ): F[ModifyDbInstanceResponse]

      def modifyDBSubnetGroup(
        request: ModifyDbSubnetGroupRequest
      ): F[ModifyDbSubnetGroupResponse]

      def modifyEventSubscription(
        request: ModifyEventSubscriptionRequest
      ): F[ModifyEventSubscriptionResponse]

      def modifyGlobalCluster(
        request: ModifyGlobalClusterRequest
      ): F[ModifyGlobalClusterResponse]

      def rebootDBInstance(
        request: RebootDbInstanceRequest
      ): F[RebootDbInstanceResponse]

      def removeFromGlobalCluster(
        request: RemoveFromGlobalClusterRequest
      ): F[RemoveFromGlobalClusterResponse]

      def removeSourceIdentifierFromSubscription(
        request: RemoveSourceIdentifierFromSubscriptionRequest
      ): F[RemoveSourceIdentifierFromSubscriptionResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]

      def resetDBClusterParameterGroup(
        request: ResetDbClusterParameterGroupRequest
      ): F[ResetDbClusterParameterGroupResponse]

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
    ) extends DocDbOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddSourceIdentifierToSubscriptionOp(
      request: AddSourceIdentifierToSubscriptionRequest
    ) extends DocDbOp[AddSourceIdentifierToSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddSourceIdentifierToSubscriptionResponse] =
        visitor.addSourceIdentifierToSubscription(request)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends DocDbOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class ApplyPendingMaintenanceActionOp(
      request: ApplyPendingMaintenanceActionRequest
    ) extends DocDbOp[ApplyPendingMaintenanceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplyPendingMaintenanceActionResponse] =
        visitor.applyPendingMaintenanceAction(request)
    }

    final case class CopyDBClusterParameterGroupOp(
      request: CopyDbClusterParameterGroupRequest
    ) extends DocDbOp[CopyDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbClusterParameterGroupResponse] =
        visitor.copyDBClusterParameterGroup(request)
    }

    final case class CopyDBClusterSnapshotOp(
      request: CopyDbClusterSnapshotRequest
    ) extends DocDbOp[CopyDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbClusterSnapshotResponse] =
        visitor.copyDBClusterSnapshot(request)
    }

    final case class CreateDBClusterOp(
      request: CreateDbClusterRequest
    ) extends DocDbOp[CreateDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterResponse] =
        visitor.createDBCluster(request)
    }

    final case class CreateDBClusterParameterGroupOp(
      request: CreateDbClusterParameterGroupRequest
    ) extends DocDbOp[CreateDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterParameterGroupResponse] =
        visitor.createDBClusterParameterGroup(request)
    }

    final case class CreateDBClusterSnapshotOp(
      request: CreateDbClusterSnapshotRequest
    ) extends DocDbOp[CreateDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterSnapshotResponse] =
        visitor.createDBClusterSnapshot(request)
    }

    final case class CreateDBInstanceOp(
      request: CreateDbInstanceRequest
    ) extends DocDbOp[CreateDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbInstanceResponse] =
        visitor.createDBInstance(request)
    }

    final case class CreateDBSubnetGroupOp(
      request: CreateDbSubnetGroupRequest
    ) extends DocDbOp[CreateDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbSubnetGroupResponse] =
        visitor.createDBSubnetGroup(request)
    }

    final case class CreateEventSubscriptionOp(
      request: CreateEventSubscriptionRequest
    ) extends DocDbOp[CreateEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventSubscriptionResponse] =
        visitor.createEventSubscription(request)
    }

    final case class CreateGlobalClusterOp(
      request: CreateGlobalClusterRequest
    ) extends DocDbOp[CreateGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGlobalClusterResponse] =
        visitor.createGlobalCluster(request)
    }

    final case class DeleteDBClusterOp(
      request: DeleteDbClusterRequest
    ) extends DocDbOp[DeleteDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterResponse] =
        visitor.deleteDBCluster(request)
    }

    final case class DeleteDBClusterParameterGroupOp(
      request: DeleteDbClusterParameterGroupRequest
    ) extends DocDbOp[DeleteDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterParameterGroupResponse] =
        visitor.deleteDBClusterParameterGroup(request)
    }

    final case class DeleteDBClusterSnapshotOp(
      request: DeleteDbClusterSnapshotRequest
    ) extends DocDbOp[DeleteDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterSnapshotResponse] =
        visitor.deleteDBClusterSnapshot(request)
    }

    final case class DeleteDBInstanceOp(
      request: DeleteDbInstanceRequest
    ) extends DocDbOp[DeleteDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbInstanceResponse] =
        visitor.deleteDBInstance(request)
    }

    final case class DeleteDBSubnetGroupOp(
      request: DeleteDbSubnetGroupRequest
    ) extends DocDbOp[DeleteDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbSubnetGroupResponse] =
        visitor.deleteDBSubnetGroup(request)
    }

    final case class DeleteEventSubscriptionOp(
      request: DeleteEventSubscriptionRequest
    ) extends DocDbOp[DeleteEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventSubscriptionResponse] =
        visitor.deleteEventSubscription(request)
    }

    final case class DeleteGlobalClusterOp(
      request: DeleteGlobalClusterRequest
    ) extends DocDbOp[DeleteGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGlobalClusterResponse] =
        visitor.deleteGlobalCluster(request)
    }

    final case class DescribeCertificatesOp(
      request: DescribeCertificatesRequest
    ) extends DocDbOp[DescribeCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificatesResponse] =
        visitor.describeCertificates(request)
    }

    final case class DescribeDBClusterParameterGroupsOp(
      request: DescribeDbClusterParameterGroupsRequest
    ) extends DocDbOp[DescribeDbClusterParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterParameterGroupsResponse] =
        visitor.describeDBClusterParameterGroups(request)
    }

    final case class DescribeDBClusterParametersOp(
      request: DescribeDbClusterParametersRequest
    ) extends DocDbOp[DescribeDbClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterParametersResponse] =
        visitor.describeDBClusterParameters(request)
    }

    final case class DescribeDBClusterSnapshotAttributesOp(
      request: DescribeDbClusterSnapshotAttributesRequest
    ) extends DocDbOp[DescribeDbClusterSnapshotAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterSnapshotAttributesResponse] =
        visitor.describeDBClusterSnapshotAttributes(request)
    }

    final case class DescribeDBClusterSnapshotsOp(
      request: DescribeDbClusterSnapshotsRequest
    ) extends DocDbOp[DescribeDbClusterSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterSnapshotsResponse] =
        visitor.describeDBClusterSnapshots(request)
    }

    final case class DescribeDBClustersOp(
      request: DescribeDbClustersRequest
    ) extends DocDbOp[DescribeDbClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClustersResponse] =
        visitor.describeDBClusters(request)
    }

    final case class DescribeDBEngineVersionsOp(
      request: DescribeDbEngineVersionsRequest
    ) extends DocDbOp[DescribeDbEngineVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbEngineVersionsResponse] =
        visitor.describeDBEngineVersions(request)
    }

    final case class DescribeDBInstancesOp(
      request: DescribeDbInstancesRequest
    ) extends DocDbOp[DescribeDbInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbInstancesResponse] =
        visitor.describeDBInstances(request)
    }

    final case class DescribeDBSubnetGroupsOp(
      request: DescribeDbSubnetGroupsRequest
    ) extends DocDbOp[DescribeDbSubnetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbSubnetGroupsResponse] =
        visitor.describeDBSubnetGroups(request)
    }

    final case class DescribeEngineDefaultClusterParametersOp(
      request: DescribeEngineDefaultClusterParametersRequest
    ) extends DocDbOp[DescribeEngineDefaultClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEngineDefaultClusterParametersResponse] =
        visitor.describeEngineDefaultClusterParameters(request)
    }

    final case class DescribeEventCategoriesOp(
      request: DescribeEventCategoriesRequest
    ) extends DocDbOp[DescribeEventCategoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventCategoriesResponse] =
        visitor.describeEventCategories(request)
    }

    final case class DescribeEventSubscriptionsOp(
      request: DescribeEventSubscriptionsRequest
    ) extends DocDbOp[DescribeEventSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventSubscriptionsResponse] =
        visitor.describeEventSubscriptions(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends DocDbOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeGlobalClustersOp(
      request: DescribeGlobalClustersRequest
    ) extends DocDbOp[DescribeGlobalClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGlobalClustersResponse] =
        visitor.describeGlobalClusters(request)
    }

    final case class DescribeOrderableDBInstanceOptionsOp(
      request: DescribeOrderableDbInstanceOptionsRequest
    ) extends DocDbOp[DescribeOrderableDbInstanceOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrderableDbInstanceOptionsResponse] =
        visitor.describeOrderableDBInstanceOptions(request)
    }

    final case class DescribePendingMaintenanceActionsOp(
      request: DescribePendingMaintenanceActionsRequest
    ) extends DocDbOp[DescribePendingMaintenanceActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePendingMaintenanceActionsResponse] =
        visitor.describePendingMaintenanceActions(request)
    }

    final case class FailoverDBClusterOp(
      request: FailoverDbClusterRequest
    ) extends DocDbOp[FailoverDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FailoverDbClusterResponse] =
        visitor.failoverDBCluster(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DocDbOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyDBClusterOp(
      request: ModifyDbClusterRequest
    ) extends DocDbOp[ModifyDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterResponse] =
        visitor.modifyDBCluster(request)
    }

    final case class ModifyDBClusterParameterGroupOp(
      request: ModifyDbClusterParameterGroupRequest
    ) extends DocDbOp[ModifyDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterParameterGroupResponse] =
        visitor.modifyDBClusterParameterGroup(request)
    }

    final case class ModifyDBClusterSnapshotAttributeOp(
      request: ModifyDbClusterSnapshotAttributeRequest
    ) extends DocDbOp[ModifyDbClusterSnapshotAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterSnapshotAttributeResponse] =
        visitor.modifyDBClusterSnapshotAttribute(request)
    }

    final case class ModifyDBInstanceOp(
      request: ModifyDbInstanceRequest
    ) extends DocDbOp[ModifyDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbInstanceResponse] =
        visitor.modifyDBInstance(request)
    }

    final case class ModifyDBSubnetGroupOp(
      request: ModifyDbSubnetGroupRequest
    ) extends DocDbOp[ModifyDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbSubnetGroupResponse] =
        visitor.modifyDBSubnetGroup(request)
    }

    final case class ModifyEventSubscriptionOp(
      request: ModifyEventSubscriptionRequest
    ) extends DocDbOp[ModifyEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEventSubscriptionResponse] =
        visitor.modifyEventSubscription(request)
    }

    final case class ModifyGlobalClusterOp(
      request: ModifyGlobalClusterRequest
    ) extends DocDbOp[ModifyGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyGlobalClusterResponse] =
        visitor.modifyGlobalCluster(request)
    }

    final case class RebootDBInstanceOp(
      request: RebootDbInstanceRequest
    ) extends DocDbOp[RebootDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootDbInstanceResponse] =
        visitor.rebootDBInstance(request)
    }

    final case class RemoveFromGlobalClusterOp(
      request: RemoveFromGlobalClusterRequest
    ) extends DocDbOp[RemoveFromGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveFromGlobalClusterResponse] =
        visitor.removeFromGlobalCluster(request)
    }

    final case class RemoveSourceIdentifierFromSubscriptionOp(
      request: RemoveSourceIdentifierFromSubscriptionRequest
    ) extends DocDbOp[RemoveSourceIdentifierFromSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveSourceIdentifierFromSubscriptionResponse] =
        visitor.removeSourceIdentifierFromSubscription(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends DocDbOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class ResetDBClusterParameterGroupOp(
      request: ResetDbClusterParameterGroupRequest
    ) extends DocDbOp[ResetDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetDbClusterParameterGroupResponse] =
        visitor.resetDBClusterParameterGroup(request)
    }

    final case class RestoreDBClusterFromSnapshotOp(
      request: RestoreDbClusterFromSnapshotRequest
    ) extends DocDbOp[RestoreDbClusterFromSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbClusterFromSnapshotResponse] =
        visitor.restoreDBClusterFromSnapshot(request)
    }

    final case class RestoreDBClusterToPointInTimeOp(
      request: RestoreDbClusterToPointInTimeRequest
    ) extends DocDbOp[RestoreDbClusterToPointInTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbClusterToPointInTimeResponse] =
        visitor.restoreDBClusterToPointInTime(request)
    }

    final case class StartDBClusterOp(
      request: StartDbClusterRequest
    ) extends DocDbOp[StartDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDbClusterResponse] =
        visitor.startDBCluster(request)
    }

    final case class StopDBClusterOp(
      request: StopDbClusterRequest
    ) extends DocDbOp[StopDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDbClusterResponse] =
        visitor.stopDBCluster(request)
    }
  }

  import DocDbOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DocDbOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addSourceIdentifierToSubscription(
    request: AddSourceIdentifierToSubscriptionRequest
  ): DocDbIO[AddSourceIdentifierToSubscriptionResponse] =
    FF.liftF(AddSourceIdentifierToSubscriptionOp(request))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): DocDbIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def applyPendingMaintenanceAction(
    request: ApplyPendingMaintenanceActionRequest
  ): DocDbIO[ApplyPendingMaintenanceActionResponse] =
    FF.liftF(ApplyPendingMaintenanceActionOp(request))

  def copyDBClusterParameterGroup(
    request: CopyDbClusterParameterGroupRequest
  ): DocDbIO[CopyDbClusterParameterGroupResponse] =
    FF.liftF(CopyDBClusterParameterGroupOp(request))

  def copyDBClusterSnapshot(
    request: CopyDbClusterSnapshotRequest
  ): DocDbIO[CopyDbClusterSnapshotResponse] =
    FF.liftF(CopyDBClusterSnapshotOp(request))

  def createDBCluster(
    request: CreateDbClusterRequest
  ): DocDbIO[CreateDbClusterResponse] =
    FF.liftF(CreateDBClusterOp(request))

  def createDBClusterParameterGroup(
    request: CreateDbClusterParameterGroupRequest
  ): DocDbIO[CreateDbClusterParameterGroupResponse] =
    FF.liftF(CreateDBClusterParameterGroupOp(request))

  def createDBClusterSnapshot(
    request: CreateDbClusterSnapshotRequest
  ): DocDbIO[CreateDbClusterSnapshotResponse] =
    FF.liftF(CreateDBClusterSnapshotOp(request))

  def createDBInstance(
    request: CreateDbInstanceRequest
  ): DocDbIO[CreateDbInstanceResponse] =
    FF.liftF(CreateDBInstanceOp(request))

  def createDBSubnetGroup(
    request: CreateDbSubnetGroupRequest
  ): DocDbIO[CreateDbSubnetGroupResponse] =
    FF.liftF(CreateDBSubnetGroupOp(request))

  def createEventSubscription(
    request: CreateEventSubscriptionRequest
  ): DocDbIO[CreateEventSubscriptionResponse] =
    FF.liftF(CreateEventSubscriptionOp(request))

  def createGlobalCluster(
    request: CreateGlobalClusterRequest
  ): DocDbIO[CreateGlobalClusterResponse] =
    FF.liftF(CreateGlobalClusterOp(request))

  def deleteDBCluster(
    request: DeleteDbClusterRequest
  ): DocDbIO[DeleteDbClusterResponse] =
    FF.liftF(DeleteDBClusterOp(request))

  def deleteDBClusterParameterGroup(
    request: DeleteDbClusterParameterGroupRequest
  ): DocDbIO[DeleteDbClusterParameterGroupResponse] =
    FF.liftF(DeleteDBClusterParameterGroupOp(request))

  def deleteDBClusterSnapshot(
    request: DeleteDbClusterSnapshotRequest
  ): DocDbIO[DeleteDbClusterSnapshotResponse] =
    FF.liftF(DeleteDBClusterSnapshotOp(request))

  def deleteDBInstance(
    request: DeleteDbInstanceRequest
  ): DocDbIO[DeleteDbInstanceResponse] =
    FF.liftF(DeleteDBInstanceOp(request))

  def deleteDBSubnetGroup(
    request: DeleteDbSubnetGroupRequest
  ): DocDbIO[DeleteDbSubnetGroupResponse] =
    FF.liftF(DeleteDBSubnetGroupOp(request))

  def deleteEventSubscription(
    request: DeleteEventSubscriptionRequest
  ): DocDbIO[DeleteEventSubscriptionResponse] =
    FF.liftF(DeleteEventSubscriptionOp(request))

  def deleteGlobalCluster(
    request: DeleteGlobalClusterRequest
  ): DocDbIO[DeleteGlobalClusterResponse] =
    FF.liftF(DeleteGlobalClusterOp(request))

  def describeCertificates(
    request: DescribeCertificatesRequest
  ): DocDbIO[DescribeCertificatesResponse] =
    FF.liftF(DescribeCertificatesOp(request))

  def describeDBClusterParameterGroups(
    request: DescribeDbClusterParameterGroupsRequest
  ): DocDbIO[DescribeDbClusterParameterGroupsResponse] =
    FF.liftF(DescribeDBClusterParameterGroupsOp(request))

  def describeDBClusterParameters(
    request: DescribeDbClusterParametersRequest
  ): DocDbIO[DescribeDbClusterParametersResponse] =
    FF.liftF(DescribeDBClusterParametersOp(request))

  def describeDBClusterSnapshotAttributes(
    request: DescribeDbClusterSnapshotAttributesRequest
  ): DocDbIO[DescribeDbClusterSnapshotAttributesResponse] =
    FF.liftF(DescribeDBClusterSnapshotAttributesOp(request))

  def describeDBClusterSnapshots(
    request: DescribeDbClusterSnapshotsRequest
  ): DocDbIO[DescribeDbClusterSnapshotsResponse] =
    FF.liftF(DescribeDBClusterSnapshotsOp(request))

  def describeDBClusters(
    request: DescribeDbClustersRequest
  ): DocDbIO[DescribeDbClustersResponse] =
    FF.liftF(DescribeDBClustersOp(request))

  def describeDBEngineVersions(
    request: DescribeDbEngineVersionsRequest
  ): DocDbIO[DescribeDbEngineVersionsResponse] =
    FF.liftF(DescribeDBEngineVersionsOp(request))

  def describeDBInstances(
    request: DescribeDbInstancesRequest
  ): DocDbIO[DescribeDbInstancesResponse] =
    FF.liftF(DescribeDBInstancesOp(request))

  def describeDBSubnetGroups(
    request: DescribeDbSubnetGroupsRequest
  ): DocDbIO[DescribeDbSubnetGroupsResponse] =
    FF.liftF(DescribeDBSubnetGroupsOp(request))

  def describeEngineDefaultClusterParameters(
    request: DescribeEngineDefaultClusterParametersRequest
  ): DocDbIO[DescribeEngineDefaultClusterParametersResponse] =
    FF.liftF(DescribeEngineDefaultClusterParametersOp(request))

  def describeEventCategories(
    request: DescribeEventCategoriesRequest
  ): DocDbIO[DescribeEventCategoriesResponse] =
    FF.liftF(DescribeEventCategoriesOp(request))

  def describeEventSubscriptions(
    request: DescribeEventSubscriptionsRequest
  ): DocDbIO[DescribeEventSubscriptionsResponse] =
    FF.liftF(DescribeEventSubscriptionsOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): DocDbIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeGlobalClusters(
    request: DescribeGlobalClustersRequest
  ): DocDbIO[DescribeGlobalClustersResponse] =
    FF.liftF(DescribeGlobalClustersOp(request))

  def describeOrderableDBInstanceOptions(
    request: DescribeOrderableDbInstanceOptionsRequest
  ): DocDbIO[DescribeOrderableDbInstanceOptionsResponse] =
    FF.liftF(DescribeOrderableDBInstanceOptionsOp(request))

  def describePendingMaintenanceActions(
    request: DescribePendingMaintenanceActionsRequest
  ): DocDbIO[DescribePendingMaintenanceActionsResponse] =
    FF.liftF(DescribePendingMaintenanceActionsOp(request))

  def failoverDBCluster(
    request: FailoverDbClusterRequest
  ): DocDbIO[FailoverDbClusterResponse] =
    FF.liftF(FailoverDBClusterOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DocDbIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyDBCluster(
    request: ModifyDbClusterRequest
  ): DocDbIO[ModifyDbClusterResponse] =
    FF.liftF(ModifyDBClusterOp(request))

  def modifyDBClusterParameterGroup(
    request: ModifyDbClusterParameterGroupRequest
  ): DocDbIO[ModifyDbClusterParameterGroupResponse] =
    FF.liftF(ModifyDBClusterParameterGroupOp(request))

  def modifyDBClusterSnapshotAttribute(
    request: ModifyDbClusterSnapshotAttributeRequest
  ): DocDbIO[ModifyDbClusterSnapshotAttributeResponse] =
    FF.liftF(ModifyDBClusterSnapshotAttributeOp(request))

  def modifyDBInstance(
    request: ModifyDbInstanceRequest
  ): DocDbIO[ModifyDbInstanceResponse] =
    FF.liftF(ModifyDBInstanceOp(request))

  def modifyDBSubnetGroup(
    request: ModifyDbSubnetGroupRequest
  ): DocDbIO[ModifyDbSubnetGroupResponse] =
    FF.liftF(ModifyDBSubnetGroupOp(request))

  def modifyEventSubscription(
    request: ModifyEventSubscriptionRequest
  ): DocDbIO[ModifyEventSubscriptionResponse] =
    FF.liftF(ModifyEventSubscriptionOp(request))

  def modifyGlobalCluster(
    request: ModifyGlobalClusterRequest
  ): DocDbIO[ModifyGlobalClusterResponse] =
    FF.liftF(ModifyGlobalClusterOp(request))

  def rebootDBInstance(
    request: RebootDbInstanceRequest
  ): DocDbIO[RebootDbInstanceResponse] =
    FF.liftF(RebootDBInstanceOp(request))

  def removeFromGlobalCluster(
    request: RemoveFromGlobalClusterRequest
  ): DocDbIO[RemoveFromGlobalClusterResponse] =
    FF.liftF(RemoveFromGlobalClusterOp(request))

  def removeSourceIdentifierFromSubscription(
    request: RemoveSourceIdentifierFromSubscriptionRequest
  ): DocDbIO[RemoveSourceIdentifierFromSubscriptionResponse] =
    FF.liftF(RemoveSourceIdentifierFromSubscriptionOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): DocDbIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def resetDBClusterParameterGroup(
    request: ResetDbClusterParameterGroupRequest
  ): DocDbIO[ResetDbClusterParameterGroupResponse] =
    FF.liftF(ResetDBClusterParameterGroupOp(request))

  def restoreDBClusterFromSnapshot(
    request: RestoreDbClusterFromSnapshotRequest
  ): DocDbIO[RestoreDbClusterFromSnapshotResponse] =
    FF.liftF(RestoreDBClusterFromSnapshotOp(request))

  def restoreDBClusterToPointInTime(
    request: RestoreDbClusterToPointInTimeRequest
  ): DocDbIO[RestoreDbClusterToPointInTimeResponse] =
    FF.liftF(RestoreDBClusterToPointInTimeOp(request))

  def startDBCluster(
    request: StartDbClusterRequest
  ): DocDbIO[StartDbClusterResponse] =
    FF.liftF(StartDBClusterOp(request))

  def stopDBCluster(
    request: StopDbClusterRequest
  ): DocDbIO[StopDbClusterResponse] =
    FF.liftF(StopDBClusterOp(request))
}
