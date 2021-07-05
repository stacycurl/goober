package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.elasticache.ElastiCacheClient
import software.amazon.awssdk.services.elasticache.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object elasticache { module =>

  // Free monad over ElastiCacheOp
  type ElastiCacheIO[A] = FF[ElastiCacheOp, A]

  sealed trait ElastiCacheOp[A] {
    def visit[F[_]](visitor: ElastiCacheOp.Visitor[F]): F[A]
  }

  object ElastiCacheOp {
    // Given a ElastiCacheClient we can embed a ElastiCacheIO program in any algebra that understands embedding.
    implicit val ElastiCacheOpEmbeddable: Embeddable[ElastiCacheOp, ElastiCacheClient] = new Embeddable[ElastiCacheOp, ElastiCacheClient] {
      def embed[A](client: ElastiCacheClient, io: ElastiCacheIO[A]): Embedded[A] = Embedded.ElastiCache(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ElastiCacheOp.Visitor[Kleisli[M, ElastiCacheClient, *]] {
        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, ElastiCacheClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def authorizeCacheSecurityGroupIngress(
          request: AuthorizeCacheSecurityGroupIngressRequest
        ): Kleisli[M, ElastiCacheClient, AuthorizeCacheSecurityGroupIngressResponse] =
          primitive(_.authorizeCacheSecurityGroupIngress(request))

        def batchApplyUpdateAction(
          request: BatchApplyUpdateActionRequest
        ): Kleisli[M, ElastiCacheClient, BatchApplyUpdateActionResponse] =
          primitive(_.batchApplyUpdateAction(request))

        def batchStopUpdateAction(
          request: BatchStopUpdateActionRequest
        ): Kleisli[M, ElastiCacheClient, BatchStopUpdateActionResponse] =
          primitive(_.batchStopUpdateAction(request))

        def completeMigration(
          request: CompleteMigrationRequest
        ): Kleisli[M, ElastiCacheClient, CompleteMigrationResponse] =
          primitive(_.completeMigration(request))

        def copySnapshot(
          request: CopySnapshotRequest
        ): Kleisli[M, ElastiCacheClient, CopySnapshotResponse] =
          primitive(_.copySnapshot(request))

        def createCacheCluster(
          request: CreateCacheClusterRequest
        ): Kleisli[M, ElastiCacheClient, CreateCacheClusterResponse] =
          primitive(_.createCacheCluster(request))

        def createCacheParameterGroup(
          request: CreateCacheParameterGroupRequest
        ): Kleisli[M, ElastiCacheClient, CreateCacheParameterGroupResponse] =
          primitive(_.createCacheParameterGroup(request))

        def createCacheSecurityGroup(
          request: CreateCacheSecurityGroupRequest
        ): Kleisli[M, ElastiCacheClient, CreateCacheSecurityGroupResponse] =
          primitive(_.createCacheSecurityGroup(request))

        def createCacheSubnetGroup(
          request: CreateCacheSubnetGroupRequest
        ): Kleisli[M, ElastiCacheClient, CreateCacheSubnetGroupResponse] =
          primitive(_.createCacheSubnetGroup(request))

        def createGlobalReplicationGroup(
          request: CreateGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, CreateGlobalReplicationGroupResponse] =
          primitive(_.createGlobalReplicationGroup(request))

        def createReplicationGroup(
          request: CreateReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, CreateReplicationGroupResponse] =
          primitive(_.createReplicationGroup(request))

        def createSnapshot(
          request: CreateSnapshotRequest
        ): Kleisli[M, ElastiCacheClient, CreateSnapshotResponse] =
          primitive(_.createSnapshot(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, ElastiCacheClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def createUserGroup(
          request: CreateUserGroupRequest
        ): Kleisli[M, ElastiCacheClient, CreateUserGroupResponse] =
          primitive(_.createUserGroup(request))

        def decreaseNodeGroupsInGlobalReplicationGroup(
          request: DecreaseNodeGroupsInGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, DecreaseNodeGroupsInGlobalReplicationGroupResponse] =
          primitive(_.decreaseNodeGroupsInGlobalReplicationGroup(request))

        def decreaseReplicaCount(
          request: DecreaseReplicaCountRequest
        ): Kleisli[M, ElastiCacheClient, DecreaseReplicaCountResponse] =
          primitive(_.decreaseReplicaCount(request))

        def deleteCacheCluster(
          request: DeleteCacheClusterRequest
        ): Kleisli[M, ElastiCacheClient, DeleteCacheClusterResponse] =
          primitive(_.deleteCacheCluster(request))

        def deleteCacheParameterGroup(
          request: DeleteCacheParameterGroupRequest
        ): Kleisli[M, ElastiCacheClient, DeleteCacheParameterGroupResponse] =
          primitive(_.deleteCacheParameterGroup(request))

        def deleteCacheSecurityGroup(
          request: DeleteCacheSecurityGroupRequest
        ): Kleisli[M, ElastiCacheClient, DeleteCacheSecurityGroupResponse] =
          primitive(_.deleteCacheSecurityGroup(request))

        def deleteCacheSubnetGroup(
          request: DeleteCacheSubnetGroupRequest
        ): Kleisli[M, ElastiCacheClient, DeleteCacheSubnetGroupResponse] =
          primitive(_.deleteCacheSubnetGroup(request))

        def deleteGlobalReplicationGroup(
          request: DeleteGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, DeleteGlobalReplicationGroupResponse] =
          primitive(_.deleteGlobalReplicationGroup(request))

        def deleteReplicationGroup(
          request: DeleteReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, DeleteReplicationGroupResponse] =
          primitive(_.deleteReplicationGroup(request))

        def deleteSnapshot(
          request: DeleteSnapshotRequest
        ): Kleisli[M, ElastiCacheClient, DeleteSnapshotResponse] =
          primitive(_.deleteSnapshot(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, ElastiCacheClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def deleteUserGroup(
          request: DeleteUserGroupRequest
        ): Kleisli[M, ElastiCacheClient, DeleteUserGroupResponse] =
          primitive(_.deleteUserGroup(request))

        def describeCacheClusters(
          request: DescribeCacheClustersRequest
        ): Kleisli[M, ElastiCacheClient, DescribeCacheClustersResponse] =
          primitive(_.describeCacheClusters(request))

        def describeCacheEngineVersions(
          request: DescribeCacheEngineVersionsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeCacheEngineVersionsResponse] =
          primitive(_.describeCacheEngineVersions(request))

        def describeCacheParameterGroups(
          request: DescribeCacheParameterGroupsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeCacheParameterGroupsResponse] =
          primitive(_.describeCacheParameterGroups(request))

        def describeCacheParameters(
          request: DescribeCacheParametersRequest
        ): Kleisli[M, ElastiCacheClient, DescribeCacheParametersResponse] =
          primitive(_.describeCacheParameters(request))

        def describeCacheSecurityGroups(
          request: DescribeCacheSecurityGroupsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeCacheSecurityGroupsResponse] =
          primitive(_.describeCacheSecurityGroups(request))

        def describeCacheSubnetGroups(
          request: DescribeCacheSubnetGroupsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeCacheSubnetGroupsResponse] =
          primitive(_.describeCacheSubnetGroups(request))

        def describeEngineDefaultParameters(
          request: DescribeEngineDefaultParametersRequest
        ): Kleisli[M, ElastiCacheClient, DescribeEngineDefaultParametersResponse] =
          primitive(_.describeEngineDefaultParameters(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeGlobalReplicationGroups(
          request: DescribeGlobalReplicationGroupsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeGlobalReplicationGroupsResponse] =
          primitive(_.describeGlobalReplicationGroups(request))

        def describeReplicationGroups(
          request: DescribeReplicationGroupsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeReplicationGroupsResponse] =
          primitive(_.describeReplicationGroups(request))

        def describeReservedCacheNodes(
          request: DescribeReservedCacheNodesRequest
        ): Kleisli[M, ElastiCacheClient, DescribeReservedCacheNodesResponse] =
          primitive(_.describeReservedCacheNodes(request))

        def describeReservedCacheNodesOfferings(
          request: DescribeReservedCacheNodesOfferingsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeReservedCacheNodesOfferingsResponse] =
          primitive(_.describeReservedCacheNodesOfferings(request))

        def describeServiceUpdates(
          request: DescribeServiceUpdatesRequest
        ): Kleisli[M, ElastiCacheClient, DescribeServiceUpdatesResponse] =
          primitive(_.describeServiceUpdates(request))

        def describeSnapshots(
          request: DescribeSnapshotsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeSnapshotsResponse] =
          primitive(_.describeSnapshots(request))

        def describeUpdateActions(
          request: DescribeUpdateActionsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeUpdateActionsResponse] =
          primitive(_.describeUpdateActions(request))

        def describeUserGroups(
          request: DescribeUserGroupsRequest
        ): Kleisli[M, ElastiCacheClient, DescribeUserGroupsResponse] =
          primitive(_.describeUserGroups(request))

        def describeUsers(
          request: DescribeUsersRequest
        ): Kleisli[M, ElastiCacheClient, DescribeUsersResponse] =
          primitive(_.describeUsers(request))

        def disassociateGlobalReplicationGroup(
          request: DisassociateGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, DisassociateGlobalReplicationGroupResponse] =
          primitive(_.disassociateGlobalReplicationGroup(request))

        def failoverGlobalReplicationGroup(
          request: FailoverGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, FailoverGlobalReplicationGroupResponse] =
          primitive(_.failoverGlobalReplicationGroup(request))

        def increaseNodeGroupsInGlobalReplicationGroup(
          request: IncreaseNodeGroupsInGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, IncreaseNodeGroupsInGlobalReplicationGroupResponse] =
          primitive(_.increaseNodeGroupsInGlobalReplicationGroup(request))

        def increaseReplicaCount(
          request: IncreaseReplicaCountRequest
        ): Kleisli[M, ElastiCacheClient, IncreaseReplicaCountResponse] =
          primitive(_.increaseReplicaCount(request))

        def listAllowedNodeTypeModifications(
          request: ListAllowedNodeTypeModificationsRequest
        ): Kleisli[M, ElastiCacheClient, ListAllowedNodeTypeModificationsResponse] =
          primitive(_.listAllowedNodeTypeModifications(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ElastiCacheClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyCacheCluster(
          request: ModifyCacheClusterRequest
        ): Kleisli[M, ElastiCacheClient, ModifyCacheClusterResponse] =
          primitive(_.modifyCacheCluster(request))

        def modifyCacheParameterGroup(
          request: ModifyCacheParameterGroupRequest
        ): Kleisli[M, ElastiCacheClient, ModifyCacheParameterGroupResponse] =
          primitive(_.modifyCacheParameterGroup(request))

        def modifyCacheSubnetGroup(
          request: ModifyCacheSubnetGroupRequest
        ): Kleisli[M, ElastiCacheClient, ModifyCacheSubnetGroupResponse] =
          primitive(_.modifyCacheSubnetGroup(request))

        def modifyGlobalReplicationGroup(
          request: ModifyGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, ModifyGlobalReplicationGroupResponse] =
          primitive(_.modifyGlobalReplicationGroup(request))

        def modifyReplicationGroup(
          request: ModifyReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, ModifyReplicationGroupResponse] =
          primitive(_.modifyReplicationGroup(request))

        def modifyReplicationGroupShardConfiguration(
          request: ModifyReplicationGroupShardConfigurationRequest
        ): Kleisli[M, ElastiCacheClient, ModifyReplicationGroupShardConfigurationResponse] =
          primitive(_.modifyReplicationGroupShardConfiguration(request))

        def modifyUser(
          request: ModifyUserRequest
        ): Kleisli[M, ElastiCacheClient, ModifyUserResponse] =
          primitive(_.modifyUser(request))

        def modifyUserGroup(
          request: ModifyUserGroupRequest
        ): Kleisli[M, ElastiCacheClient, ModifyUserGroupResponse] =
          primitive(_.modifyUserGroup(request))

        def purchaseReservedCacheNodesOffering(
          request: PurchaseReservedCacheNodesOfferingRequest
        ): Kleisli[M, ElastiCacheClient, PurchaseReservedCacheNodesOfferingResponse] =
          primitive(_.purchaseReservedCacheNodesOffering(request))

        def rebalanceSlotsInGlobalReplicationGroup(
          request: RebalanceSlotsInGlobalReplicationGroupRequest
        ): Kleisli[M, ElastiCacheClient, RebalanceSlotsInGlobalReplicationGroupResponse] =
          primitive(_.rebalanceSlotsInGlobalReplicationGroup(request))

        def rebootCacheCluster(
          request: RebootCacheClusterRequest
        ): Kleisli[M, ElastiCacheClient, RebootCacheClusterResponse] =
          primitive(_.rebootCacheCluster(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, ElastiCacheClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def resetCacheParameterGroup(
          request: ResetCacheParameterGroupRequest
        ): Kleisli[M, ElastiCacheClient, ResetCacheParameterGroupResponse] =
          primitive(_.resetCacheParameterGroup(request))

        def revokeCacheSecurityGroupIngress(
          request: RevokeCacheSecurityGroupIngressRequest
        ): Kleisli[M, ElastiCacheClient, RevokeCacheSecurityGroupIngressResponse] =
          primitive(_.revokeCacheSecurityGroupIngress(request))

        def startMigration(
          request: StartMigrationRequest
        ): Kleisli[M, ElastiCacheClient, StartMigrationResponse] =
          primitive(_.startMigration(request))

        def testFailover(
          request: TestFailoverRequest
        ): Kleisli[M, ElastiCacheClient, TestFailoverResponse] =
          primitive(_.testFailover(request))

        def primitive[A](
          f: ElastiCacheClient => A
        ): Kleisli[M, ElastiCacheClient, A]
      }
    }

    trait Visitor[F[_]] extends (ElastiCacheOp ~> F) {
      final def apply[A](op: ElastiCacheOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def authorizeCacheSecurityGroupIngress(
        request: AuthorizeCacheSecurityGroupIngressRequest
      ): F[AuthorizeCacheSecurityGroupIngressResponse]

      def batchApplyUpdateAction(
        request: BatchApplyUpdateActionRequest
      ): F[BatchApplyUpdateActionResponse]

      def batchStopUpdateAction(
        request: BatchStopUpdateActionRequest
      ): F[BatchStopUpdateActionResponse]

      def completeMigration(
        request: CompleteMigrationRequest
      ): F[CompleteMigrationResponse]

      def copySnapshot(
        request: CopySnapshotRequest
      ): F[CopySnapshotResponse]

      def createCacheCluster(
        request: CreateCacheClusterRequest
      ): F[CreateCacheClusterResponse]

      def createCacheParameterGroup(
        request: CreateCacheParameterGroupRequest
      ): F[CreateCacheParameterGroupResponse]

      def createCacheSecurityGroup(
        request: CreateCacheSecurityGroupRequest
      ): F[CreateCacheSecurityGroupResponse]

      def createCacheSubnetGroup(
        request: CreateCacheSubnetGroupRequest
      ): F[CreateCacheSubnetGroupResponse]

      def createGlobalReplicationGroup(
        request: CreateGlobalReplicationGroupRequest
      ): F[CreateGlobalReplicationGroupResponse]

      def createReplicationGroup(
        request: CreateReplicationGroupRequest
      ): F[CreateReplicationGroupResponse]

      def createSnapshot(
        request: CreateSnapshotRequest
      ): F[CreateSnapshotResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def createUserGroup(
        request: CreateUserGroupRequest
      ): F[CreateUserGroupResponse]

      def decreaseNodeGroupsInGlobalReplicationGroup(
        request: DecreaseNodeGroupsInGlobalReplicationGroupRequest
      ): F[DecreaseNodeGroupsInGlobalReplicationGroupResponse]

      def decreaseReplicaCount(
        request: DecreaseReplicaCountRequest
      ): F[DecreaseReplicaCountResponse]

      def deleteCacheCluster(
        request: DeleteCacheClusterRequest
      ): F[DeleteCacheClusterResponse]

      def deleteCacheParameterGroup(
        request: DeleteCacheParameterGroupRequest
      ): F[DeleteCacheParameterGroupResponse]

      def deleteCacheSecurityGroup(
        request: DeleteCacheSecurityGroupRequest
      ): F[DeleteCacheSecurityGroupResponse]

      def deleteCacheSubnetGroup(
        request: DeleteCacheSubnetGroupRequest
      ): F[DeleteCacheSubnetGroupResponse]

      def deleteGlobalReplicationGroup(
        request: DeleteGlobalReplicationGroupRequest
      ): F[DeleteGlobalReplicationGroupResponse]

      def deleteReplicationGroup(
        request: DeleteReplicationGroupRequest
      ): F[DeleteReplicationGroupResponse]

      def deleteSnapshot(
        request: DeleteSnapshotRequest
      ): F[DeleteSnapshotResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def deleteUserGroup(
        request: DeleteUserGroupRequest
      ): F[DeleteUserGroupResponse]

      def describeCacheClusters(
        request: DescribeCacheClustersRequest
      ): F[DescribeCacheClustersResponse]

      def describeCacheEngineVersions(
        request: DescribeCacheEngineVersionsRequest
      ): F[DescribeCacheEngineVersionsResponse]

      def describeCacheParameterGroups(
        request: DescribeCacheParameterGroupsRequest
      ): F[DescribeCacheParameterGroupsResponse]

      def describeCacheParameters(
        request: DescribeCacheParametersRequest
      ): F[DescribeCacheParametersResponse]

      def describeCacheSecurityGroups(
        request: DescribeCacheSecurityGroupsRequest
      ): F[DescribeCacheSecurityGroupsResponse]

      def describeCacheSubnetGroups(
        request: DescribeCacheSubnetGroupsRequest
      ): F[DescribeCacheSubnetGroupsResponse]

      def describeEngineDefaultParameters(
        request: DescribeEngineDefaultParametersRequest
      ): F[DescribeEngineDefaultParametersResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeGlobalReplicationGroups(
        request: DescribeGlobalReplicationGroupsRequest
      ): F[DescribeGlobalReplicationGroupsResponse]

      def describeReplicationGroups(
        request: DescribeReplicationGroupsRequest
      ): F[DescribeReplicationGroupsResponse]

      def describeReservedCacheNodes(
        request: DescribeReservedCacheNodesRequest
      ): F[DescribeReservedCacheNodesResponse]

      def describeReservedCacheNodesOfferings(
        request: DescribeReservedCacheNodesOfferingsRequest
      ): F[DescribeReservedCacheNodesOfferingsResponse]

      def describeServiceUpdates(
        request: DescribeServiceUpdatesRequest
      ): F[DescribeServiceUpdatesResponse]

      def describeSnapshots(
        request: DescribeSnapshotsRequest
      ): F[DescribeSnapshotsResponse]

      def describeUpdateActions(
        request: DescribeUpdateActionsRequest
      ): F[DescribeUpdateActionsResponse]

      def describeUserGroups(
        request: DescribeUserGroupsRequest
      ): F[DescribeUserGroupsResponse]

      def describeUsers(
        request: DescribeUsersRequest
      ): F[DescribeUsersResponse]

      def disassociateGlobalReplicationGroup(
        request: DisassociateGlobalReplicationGroupRequest
      ): F[DisassociateGlobalReplicationGroupResponse]

      def failoverGlobalReplicationGroup(
        request: FailoverGlobalReplicationGroupRequest
      ): F[FailoverGlobalReplicationGroupResponse]

      def increaseNodeGroupsInGlobalReplicationGroup(
        request: IncreaseNodeGroupsInGlobalReplicationGroupRequest
      ): F[IncreaseNodeGroupsInGlobalReplicationGroupResponse]

      def increaseReplicaCount(
        request: IncreaseReplicaCountRequest
      ): F[IncreaseReplicaCountResponse]

      def listAllowedNodeTypeModifications(
        request: ListAllowedNodeTypeModificationsRequest
      ): F[ListAllowedNodeTypeModificationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyCacheCluster(
        request: ModifyCacheClusterRequest
      ): F[ModifyCacheClusterResponse]

      def modifyCacheParameterGroup(
        request: ModifyCacheParameterGroupRequest
      ): F[ModifyCacheParameterGroupResponse]

      def modifyCacheSubnetGroup(
        request: ModifyCacheSubnetGroupRequest
      ): F[ModifyCacheSubnetGroupResponse]

      def modifyGlobalReplicationGroup(
        request: ModifyGlobalReplicationGroupRequest
      ): F[ModifyGlobalReplicationGroupResponse]

      def modifyReplicationGroup(
        request: ModifyReplicationGroupRequest
      ): F[ModifyReplicationGroupResponse]

      def modifyReplicationGroupShardConfiguration(
        request: ModifyReplicationGroupShardConfigurationRequest
      ): F[ModifyReplicationGroupShardConfigurationResponse]

      def modifyUser(
        request: ModifyUserRequest
      ): F[ModifyUserResponse]

      def modifyUserGroup(
        request: ModifyUserGroupRequest
      ): F[ModifyUserGroupResponse]

      def purchaseReservedCacheNodesOffering(
        request: PurchaseReservedCacheNodesOfferingRequest
      ): F[PurchaseReservedCacheNodesOfferingResponse]

      def rebalanceSlotsInGlobalReplicationGroup(
        request: RebalanceSlotsInGlobalReplicationGroupRequest
      ): F[RebalanceSlotsInGlobalReplicationGroupResponse]

      def rebootCacheCluster(
        request: RebootCacheClusterRequest
      ): F[RebootCacheClusterResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]

      def resetCacheParameterGroup(
        request: ResetCacheParameterGroupRequest
      ): F[ResetCacheParameterGroupResponse]

      def revokeCacheSecurityGroupIngress(
        request: RevokeCacheSecurityGroupIngressRequest
      ): F[RevokeCacheSecurityGroupIngressResponse]

      def startMigration(
        request: StartMigrationRequest
      ): F[StartMigrationResponse]

      def testFailover(
        request: TestFailoverRequest
      ): F[TestFailoverResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ElastiCacheOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends ElastiCacheOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class AuthorizeCacheSecurityGroupIngressOp(
      request: AuthorizeCacheSecurityGroupIngressRequest
    ) extends ElastiCacheOp[AuthorizeCacheSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeCacheSecurityGroupIngressResponse] =
        visitor.authorizeCacheSecurityGroupIngress(request)
    }

    final case class BatchApplyUpdateActionOp(
      request: BatchApplyUpdateActionRequest
    ) extends ElastiCacheOp[BatchApplyUpdateActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchApplyUpdateActionResponse] =
        visitor.batchApplyUpdateAction(request)
    }

    final case class BatchStopUpdateActionOp(
      request: BatchStopUpdateActionRequest
    ) extends ElastiCacheOp[BatchStopUpdateActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchStopUpdateActionResponse] =
        visitor.batchStopUpdateAction(request)
    }

    final case class CompleteMigrationOp(
      request: CompleteMigrationRequest
    ) extends ElastiCacheOp[CompleteMigrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteMigrationResponse] =
        visitor.completeMigration(request)
    }

    final case class CopySnapshotOp(
      request: CopySnapshotRequest
    ) extends ElastiCacheOp[CopySnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopySnapshotResponse] =
        visitor.copySnapshot(request)
    }

    final case class CreateCacheClusterOp(
      request: CreateCacheClusterRequest
    ) extends ElastiCacheOp[CreateCacheClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCacheClusterResponse] =
        visitor.createCacheCluster(request)
    }

    final case class CreateCacheParameterGroupOp(
      request: CreateCacheParameterGroupRequest
    ) extends ElastiCacheOp[CreateCacheParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCacheParameterGroupResponse] =
        visitor.createCacheParameterGroup(request)
    }

    final case class CreateCacheSecurityGroupOp(
      request: CreateCacheSecurityGroupRequest
    ) extends ElastiCacheOp[CreateCacheSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCacheSecurityGroupResponse] =
        visitor.createCacheSecurityGroup(request)
    }

    final case class CreateCacheSubnetGroupOp(
      request: CreateCacheSubnetGroupRequest
    ) extends ElastiCacheOp[CreateCacheSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCacheSubnetGroupResponse] =
        visitor.createCacheSubnetGroup(request)
    }

    final case class CreateGlobalReplicationGroupOp(
      request: CreateGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[CreateGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGlobalReplicationGroupResponse] =
        visitor.createGlobalReplicationGroup(request)
    }

    final case class CreateReplicationGroupOp(
      request: CreateReplicationGroupRequest
    ) extends ElastiCacheOp[CreateReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplicationGroupResponse] =
        visitor.createReplicationGroup(request)
    }

    final case class CreateSnapshotOp(
      request: CreateSnapshotRequest
    ) extends ElastiCacheOp[CreateSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotResponse] =
        visitor.createSnapshot(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends ElastiCacheOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class CreateUserGroupOp(
      request: CreateUserGroupRequest
    ) extends ElastiCacheOp[CreateUserGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserGroupResponse] =
        visitor.createUserGroup(request)
    }

    final case class DecreaseNodeGroupsInGlobalReplicationGroupOp(
      request: DecreaseNodeGroupsInGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[DecreaseNodeGroupsInGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DecreaseNodeGroupsInGlobalReplicationGroupResponse] =
        visitor.decreaseNodeGroupsInGlobalReplicationGroup(request)
    }

    final case class DecreaseReplicaCountOp(
      request: DecreaseReplicaCountRequest
    ) extends ElastiCacheOp[DecreaseReplicaCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DecreaseReplicaCountResponse] =
        visitor.decreaseReplicaCount(request)
    }

    final case class DeleteCacheClusterOp(
      request: DeleteCacheClusterRequest
    ) extends ElastiCacheOp[DeleteCacheClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCacheClusterResponse] =
        visitor.deleteCacheCluster(request)
    }

    final case class DeleteCacheParameterGroupOp(
      request: DeleteCacheParameterGroupRequest
    ) extends ElastiCacheOp[DeleteCacheParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCacheParameterGroupResponse] =
        visitor.deleteCacheParameterGroup(request)
    }

    final case class DeleteCacheSecurityGroupOp(
      request: DeleteCacheSecurityGroupRequest
    ) extends ElastiCacheOp[DeleteCacheSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCacheSecurityGroupResponse] =
        visitor.deleteCacheSecurityGroup(request)
    }

    final case class DeleteCacheSubnetGroupOp(
      request: DeleteCacheSubnetGroupRequest
    ) extends ElastiCacheOp[DeleteCacheSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCacheSubnetGroupResponse] =
        visitor.deleteCacheSubnetGroup(request)
    }

    final case class DeleteGlobalReplicationGroupOp(
      request: DeleteGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[DeleteGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGlobalReplicationGroupResponse] =
        visitor.deleteGlobalReplicationGroup(request)
    }

    final case class DeleteReplicationGroupOp(
      request: DeleteReplicationGroupRequest
    ) extends ElastiCacheOp[DeleteReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationGroupResponse] =
        visitor.deleteReplicationGroup(request)
    }

    final case class DeleteSnapshotOp(
      request: DeleteSnapshotRequest
    ) extends ElastiCacheOp[DeleteSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSnapshotResponse] =
        visitor.deleteSnapshot(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends ElastiCacheOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DeleteUserGroupOp(
      request: DeleteUserGroupRequest
    ) extends ElastiCacheOp[DeleteUserGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserGroupResponse] =
        visitor.deleteUserGroup(request)
    }

    final case class DescribeCacheClustersOp(
      request: DescribeCacheClustersRequest
    ) extends ElastiCacheOp[DescribeCacheClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCacheClustersResponse] =
        visitor.describeCacheClusters(request)
    }

    final case class DescribeCacheEngineVersionsOp(
      request: DescribeCacheEngineVersionsRequest
    ) extends ElastiCacheOp[DescribeCacheEngineVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCacheEngineVersionsResponse] =
        visitor.describeCacheEngineVersions(request)
    }

    final case class DescribeCacheParameterGroupsOp(
      request: DescribeCacheParameterGroupsRequest
    ) extends ElastiCacheOp[DescribeCacheParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCacheParameterGroupsResponse] =
        visitor.describeCacheParameterGroups(request)
    }

    final case class DescribeCacheParametersOp(
      request: DescribeCacheParametersRequest
    ) extends ElastiCacheOp[DescribeCacheParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCacheParametersResponse] =
        visitor.describeCacheParameters(request)
    }

    final case class DescribeCacheSecurityGroupsOp(
      request: DescribeCacheSecurityGroupsRequest
    ) extends ElastiCacheOp[DescribeCacheSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCacheSecurityGroupsResponse] =
        visitor.describeCacheSecurityGroups(request)
    }

    final case class DescribeCacheSubnetGroupsOp(
      request: DescribeCacheSubnetGroupsRequest
    ) extends ElastiCacheOp[DescribeCacheSubnetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCacheSubnetGroupsResponse] =
        visitor.describeCacheSubnetGroups(request)
    }

    final case class DescribeEngineDefaultParametersOp(
      request: DescribeEngineDefaultParametersRequest
    ) extends ElastiCacheOp[DescribeEngineDefaultParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEngineDefaultParametersResponse] =
        visitor.describeEngineDefaultParameters(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends ElastiCacheOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeGlobalReplicationGroupsOp(
      request: DescribeGlobalReplicationGroupsRequest
    ) extends ElastiCacheOp[DescribeGlobalReplicationGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGlobalReplicationGroupsResponse] =
        visitor.describeGlobalReplicationGroups(request)
    }

    final case class DescribeReplicationGroupsOp(
      request: DescribeReplicationGroupsRequest
    ) extends ElastiCacheOp[DescribeReplicationGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationGroupsResponse] =
        visitor.describeReplicationGroups(request)
    }

    final case class DescribeReservedCacheNodesOp(
      request: DescribeReservedCacheNodesRequest
    ) extends ElastiCacheOp[DescribeReservedCacheNodesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedCacheNodesResponse] =
        visitor.describeReservedCacheNodes(request)
    }

    final case class DescribeReservedCacheNodesOfferingsOp(
      request: DescribeReservedCacheNodesOfferingsRequest
    ) extends ElastiCacheOp[DescribeReservedCacheNodesOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedCacheNodesOfferingsResponse] =
        visitor.describeReservedCacheNodesOfferings(request)
    }

    final case class DescribeServiceUpdatesOp(
      request: DescribeServiceUpdatesRequest
    ) extends ElastiCacheOp[DescribeServiceUpdatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServiceUpdatesResponse] =
        visitor.describeServiceUpdates(request)
    }

    final case class DescribeSnapshotsOp(
      request: DescribeSnapshotsRequest
    ) extends ElastiCacheOp[DescribeSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSnapshotsResponse] =
        visitor.describeSnapshots(request)
    }

    final case class DescribeUpdateActionsOp(
      request: DescribeUpdateActionsRequest
    ) extends ElastiCacheOp[DescribeUpdateActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUpdateActionsResponse] =
        visitor.describeUpdateActions(request)
    }

    final case class DescribeUserGroupsOp(
      request: DescribeUserGroupsRequest
    ) extends ElastiCacheOp[DescribeUserGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserGroupsResponse] =
        visitor.describeUserGroups(request)
    }

    final case class DescribeUsersOp(
      request: DescribeUsersRequest
    ) extends ElastiCacheOp[DescribeUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUsersResponse] =
        visitor.describeUsers(request)
    }

    final case class DisassociateGlobalReplicationGroupOp(
      request: DisassociateGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[DisassociateGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateGlobalReplicationGroupResponse] =
        visitor.disassociateGlobalReplicationGroup(request)
    }

    final case class FailoverGlobalReplicationGroupOp(
      request: FailoverGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[FailoverGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FailoverGlobalReplicationGroupResponse] =
        visitor.failoverGlobalReplicationGroup(request)
    }

    final case class IncreaseNodeGroupsInGlobalReplicationGroupOp(
      request: IncreaseNodeGroupsInGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[IncreaseNodeGroupsInGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IncreaseNodeGroupsInGlobalReplicationGroupResponse] =
        visitor.increaseNodeGroupsInGlobalReplicationGroup(request)
    }

    final case class IncreaseReplicaCountOp(
      request: IncreaseReplicaCountRequest
    ) extends ElastiCacheOp[IncreaseReplicaCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IncreaseReplicaCountResponse] =
        visitor.increaseReplicaCount(request)
    }

    final case class ListAllowedNodeTypeModificationsOp(
      request: ListAllowedNodeTypeModificationsRequest
    ) extends ElastiCacheOp[ListAllowedNodeTypeModificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAllowedNodeTypeModificationsResponse] =
        visitor.listAllowedNodeTypeModifications(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ElastiCacheOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyCacheClusterOp(
      request: ModifyCacheClusterRequest
    ) extends ElastiCacheOp[ModifyCacheClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyCacheClusterResponse] =
        visitor.modifyCacheCluster(request)
    }

    final case class ModifyCacheParameterGroupOp(
      request: ModifyCacheParameterGroupRequest
    ) extends ElastiCacheOp[ModifyCacheParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyCacheParameterGroupResponse] =
        visitor.modifyCacheParameterGroup(request)
    }

    final case class ModifyCacheSubnetGroupOp(
      request: ModifyCacheSubnetGroupRequest
    ) extends ElastiCacheOp[ModifyCacheSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyCacheSubnetGroupResponse] =
        visitor.modifyCacheSubnetGroup(request)
    }

    final case class ModifyGlobalReplicationGroupOp(
      request: ModifyGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[ModifyGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyGlobalReplicationGroupResponse] =
        visitor.modifyGlobalReplicationGroup(request)
    }

    final case class ModifyReplicationGroupOp(
      request: ModifyReplicationGroupRequest
    ) extends ElastiCacheOp[ModifyReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyReplicationGroupResponse] =
        visitor.modifyReplicationGroup(request)
    }

    final case class ModifyReplicationGroupShardConfigurationOp(
      request: ModifyReplicationGroupShardConfigurationRequest
    ) extends ElastiCacheOp[ModifyReplicationGroupShardConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyReplicationGroupShardConfigurationResponse] =
        visitor.modifyReplicationGroupShardConfiguration(request)
    }

    final case class ModifyUserOp(
      request: ModifyUserRequest
    ) extends ElastiCacheOp[ModifyUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyUserResponse] =
        visitor.modifyUser(request)
    }

    final case class ModifyUserGroupOp(
      request: ModifyUserGroupRequest
    ) extends ElastiCacheOp[ModifyUserGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyUserGroupResponse] =
        visitor.modifyUserGroup(request)
    }

    final case class PurchaseReservedCacheNodesOfferingOp(
      request: PurchaseReservedCacheNodesOfferingRequest
    ) extends ElastiCacheOp[PurchaseReservedCacheNodesOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseReservedCacheNodesOfferingResponse] =
        visitor.purchaseReservedCacheNodesOffering(request)
    }

    final case class RebalanceSlotsInGlobalReplicationGroupOp(
      request: RebalanceSlotsInGlobalReplicationGroupRequest
    ) extends ElastiCacheOp[RebalanceSlotsInGlobalReplicationGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebalanceSlotsInGlobalReplicationGroupResponse] =
        visitor.rebalanceSlotsInGlobalReplicationGroup(request)
    }

    final case class RebootCacheClusterOp(
      request: RebootCacheClusterRequest
    ) extends ElastiCacheOp[RebootCacheClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootCacheClusterResponse] =
        visitor.rebootCacheCluster(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends ElastiCacheOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class ResetCacheParameterGroupOp(
      request: ResetCacheParameterGroupRequest
    ) extends ElastiCacheOp[ResetCacheParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetCacheParameterGroupResponse] =
        visitor.resetCacheParameterGroup(request)
    }

    final case class RevokeCacheSecurityGroupIngressOp(
      request: RevokeCacheSecurityGroupIngressRequest
    ) extends ElastiCacheOp[RevokeCacheSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeCacheSecurityGroupIngressResponse] =
        visitor.revokeCacheSecurityGroupIngress(request)
    }

    final case class StartMigrationOp(
      request: StartMigrationRequest
    ) extends ElastiCacheOp[StartMigrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMigrationResponse] =
        visitor.startMigration(request)
    }

    final case class TestFailoverOp(
      request: TestFailoverRequest
    ) extends ElastiCacheOp[TestFailoverResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestFailoverResponse] =
        visitor.testFailover(request)
    }
  }

  import ElastiCacheOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ElastiCacheOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): ElastiCacheIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def authorizeCacheSecurityGroupIngress(
    request: AuthorizeCacheSecurityGroupIngressRequest
  ): ElastiCacheIO[AuthorizeCacheSecurityGroupIngressResponse] =
    FF.liftF(AuthorizeCacheSecurityGroupIngressOp(request))

  def batchApplyUpdateAction(
    request: BatchApplyUpdateActionRequest
  ): ElastiCacheIO[BatchApplyUpdateActionResponse] =
    FF.liftF(BatchApplyUpdateActionOp(request))

  def batchStopUpdateAction(
    request: BatchStopUpdateActionRequest
  ): ElastiCacheIO[BatchStopUpdateActionResponse] =
    FF.liftF(BatchStopUpdateActionOp(request))

  def completeMigration(
    request: CompleteMigrationRequest
  ): ElastiCacheIO[CompleteMigrationResponse] =
    FF.liftF(CompleteMigrationOp(request))

  def copySnapshot(
    request: CopySnapshotRequest
  ): ElastiCacheIO[CopySnapshotResponse] =
    FF.liftF(CopySnapshotOp(request))

  def createCacheCluster(
    request: CreateCacheClusterRequest
  ): ElastiCacheIO[CreateCacheClusterResponse] =
    FF.liftF(CreateCacheClusterOp(request))

  def createCacheParameterGroup(
    request: CreateCacheParameterGroupRequest
  ): ElastiCacheIO[CreateCacheParameterGroupResponse] =
    FF.liftF(CreateCacheParameterGroupOp(request))

  def createCacheSecurityGroup(
    request: CreateCacheSecurityGroupRequest
  ): ElastiCacheIO[CreateCacheSecurityGroupResponse] =
    FF.liftF(CreateCacheSecurityGroupOp(request))

  def createCacheSubnetGroup(
    request: CreateCacheSubnetGroupRequest
  ): ElastiCacheIO[CreateCacheSubnetGroupResponse] =
    FF.liftF(CreateCacheSubnetGroupOp(request))

  def createGlobalReplicationGroup(
    request: CreateGlobalReplicationGroupRequest
  ): ElastiCacheIO[CreateGlobalReplicationGroupResponse] =
    FF.liftF(CreateGlobalReplicationGroupOp(request))

  def createReplicationGroup(
    request: CreateReplicationGroupRequest
  ): ElastiCacheIO[CreateReplicationGroupResponse] =
    FF.liftF(CreateReplicationGroupOp(request))

  def createSnapshot(
    request: CreateSnapshotRequest
  ): ElastiCacheIO[CreateSnapshotResponse] =
    FF.liftF(CreateSnapshotOp(request))

  def createUser(
    request: CreateUserRequest
  ): ElastiCacheIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def createUserGroup(
    request: CreateUserGroupRequest
  ): ElastiCacheIO[CreateUserGroupResponse] =
    FF.liftF(CreateUserGroupOp(request))

  def decreaseNodeGroupsInGlobalReplicationGroup(
    request: DecreaseNodeGroupsInGlobalReplicationGroupRequest
  ): ElastiCacheIO[DecreaseNodeGroupsInGlobalReplicationGroupResponse] =
    FF.liftF(DecreaseNodeGroupsInGlobalReplicationGroupOp(request))

  def decreaseReplicaCount(
    request: DecreaseReplicaCountRequest
  ): ElastiCacheIO[DecreaseReplicaCountResponse] =
    FF.liftF(DecreaseReplicaCountOp(request))

  def deleteCacheCluster(
    request: DeleteCacheClusterRequest
  ): ElastiCacheIO[DeleteCacheClusterResponse] =
    FF.liftF(DeleteCacheClusterOp(request))

  def deleteCacheParameterGroup(
    request: DeleteCacheParameterGroupRequest
  ): ElastiCacheIO[DeleteCacheParameterGroupResponse] =
    FF.liftF(DeleteCacheParameterGroupOp(request))

  def deleteCacheSecurityGroup(
    request: DeleteCacheSecurityGroupRequest
  ): ElastiCacheIO[DeleteCacheSecurityGroupResponse] =
    FF.liftF(DeleteCacheSecurityGroupOp(request))

  def deleteCacheSubnetGroup(
    request: DeleteCacheSubnetGroupRequest
  ): ElastiCacheIO[DeleteCacheSubnetGroupResponse] =
    FF.liftF(DeleteCacheSubnetGroupOp(request))

  def deleteGlobalReplicationGroup(
    request: DeleteGlobalReplicationGroupRequest
  ): ElastiCacheIO[DeleteGlobalReplicationGroupResponse] =
    FF.liftF(DeleteGlobalReplicationGroupOp(request))

  def deleteReplicationGroup(
    request: DeleteReplicationGroupRequest
  ): ElastiCacheIO[DeleteReplicationGroupResponse] =
    FF.liftF(DeleteReplicationGroupOp(request))

  def deleteSnapshot(
    request: DeleteSnapshotRequest
  ): ElastiCacheIO[DeleteSnapshotResponse] =
    FF.liftF(DeleteSnapshotOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): ElastiCacheIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def deleteUserGroup(
    request: DeleteUserGroupRequest
  ): ElastiCacheIO[DeleteUserGroupResponse] =
    FF.liftF(DeleteUserGroupOp(request))

  def describeCacheClusters(
    request: DescribeCacheClustersRequest
  ): ElastiCacheIO[DescribeCacheClustersResponse] =
    FF.liftF(DescribeCacheClustersOp(request))

  def describeCacheEngineVersions(
    request: DescribeCacheEngineVersionsRequest
  ): ElastiCacheIO[DescribeCacheEngineVersionsResponse] =
    FF.liftF(DescribeCacheEngineVersionsOp(request))

  def describeCacheParameterGroups(
    request: DescribeCacheParameterGroupsRequest
  ): ElastiCacheIO[DescribeCacheParameterGroupsResponse] =
    FF.liftF(DescribeCacheParameterGroupsOp(request))

  def describeCacheParameters(
    request: DescribeCacheParametersRequest
  ): ElastiCacheIO[DescribeCacheParametersResponse] =
    FF.liftF(DescribeCacheParametersOp(request))

  def describeCacheSecurityGroups(
    request: DescribeCacheSecurityGroupsRequest
  ): ElastiCacheIO[DescribeCacheSecurityGroupsResponse] =
    FF.liftF(DescribeCacheSecurityGroupsOp(request))

  def describeCacheSubnetGroups(
    request: DescribeCacheSubnetGroupsRequest
  ): ElastiCacheIO[DescribeCacheSubnetGroupsResponse] =
    FF.liftF(DescribeCacheSubnetGroupsOp(request))

  def describeEngineDefaultParameters(
    request: DescribeEngineDefaultParametersRequest
  ): ElastiCacheIO[DescribeEngineDefaultParametersResponse] =
    FF.liftF(DescribeEngineDefaultParametersOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): ElastiCacheIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeGlobalReplicationGroups(
    request: DescribeGlobalReplicationGroupsRequest
  ): ElastiCacheIO[DescribeGlobalReplicationGroupsResponse] =
    FF.liftF(DescribeGlobalReplicationGroupsOp(request))

  def describeReplicationGroups(
    request: DescribeReplicationGroupsRequest
  ): ElastiCacheIO[DescribeReplicationGroupsResponse] =
    FF.liftF(DescribeReplicationGroupsOp(request))

  def describeReservedCacheNodes(
    request: DescribeReservedCacheNodesRequest
  ): ElastiCacheIO[DescribeReservedCacheNodesResponse] =
    FF.liftF(DescribeReservedCacheNodesOp(request))

  def describeReservedCacheNodesOfferings(
    request: DescribeReservedCacheNodesOfferingsRequest
  ): ElastiCacheIO[DescribeReservedCacheNodesOfferingsResponse] =
    FF.liftF(DescribeReservedCacheNodesOfferingsOp(request))

  def describeServiceUpdates(
    request: DescribeServiceUpdatesRequest
  ): ElastiCacheIO[DescribeServiceUpdatesResponse] =
    FF.liftF(DescribeServiceUpdatesOp(request))

  def describeSnapshots(
    request: DescribeSnapshotsRequest
  ): ElastiCacheIO[DescribeSnapshotsResponse] =
    FF.liftF(DescribeSnapshotsOp(request))

  def describeUpdateActions(
    request: DescribeUpdateActionsRequest
  ): ElastiCacheIO[DescribeUpdateActionsResponse] =
    FF.liftF(DescribeUpdateActionsOp(request))

  def describeUserGroups(
    request: DescribeUserGroupsRequest
  ): ElastiCacheIO[DescribeUserGroupsResponse] =
    FF.liftF(DescribeUserGroupsOp(request))

  def describeUsers(
    request: DescribeUsersRequest
  ): ElastiCacheIO[DescribeUsersResponse] =
    FF.liftF(DescribeUsersOp(request))

  def disassociateGlobalReplicationGroup(
    request: DisassociateGlobalReplicationGroupRequest
  ): ElastiCacheIO[DisassociateGlobalReplicationGroupResponse] =
    FF.liftF(DisassociateGlobalReplicationGroupOp(request))

  def failoverGlobalReplicationGroup(
    request: FailoverGlobalReplicationGroupRequest
  ): ElastiCacheIO[FailoverGlobalReplicationGroupResponse] =
    FF.liftF(FailoverGlobalReplicationGroupOp(request))

  def increaseNodeGroupsInGlobalReplicationGroup(
    request: IncreaseNodeGroupsInGlobalReplicationGroupRequest
  ): ElastiCacheIO[IncreaseNodeGroupsInGlobalReplicationGroupResponse] =
    FF.liftF(IncreaseNodeGroupsInGlobalReplicationGroupOp(request))

  def increaseReplicaCount(
    request: IncreaseReplicaCountRequest
  ): ElastiCacheIO[IncreaseReplicaCountResponse] =
    FF.liftF(IncreaseReplicaCountOp(request))

  def listAllowedNodeTypeModifications(
    request: ListAllowedNodeTypeModificationsRequest
  ): ElastiCacheIO[ListAllowedNodeTypeModificationsResponse] =
    FF.liftF(ListAllowedNodeTypeModificationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ElastiCacheIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyCacheCluster(
    request: ModifyCacheClusterRequest
  ): ElastiCacheIO[ModifyCacheClusterResponse] =
    FF.liftF(ModifyCacheClusterOp(request))

  def modifyCacheParameterGroup(
    request: ModifyCacheParameterGroupRequest
  ): ElastiCacheIO[ModifyCacheParameterGroupResponse] =
    FF.liftF(ModifyCacheParameterGroupOp(request))

  def modifyCacheSubnetGroup(
    request: ModifyCacheSubnetGroupRequest
  ): ElastiCacheIO[ModifyCacheSubnetGroupResponse] =
    FF.liftF(ModifyCacheSubnetGroupOp(request))

  def modifyGlobalReplicationGroup(
    request: ModifyGlobalReplicationGroupRequest
  ): ElastiCacheIO[ModifyGlobalReplicationGroupResponse] =
    FF.liftF(ModifyGlobalReplicationGroupOp(request))

  def modifyReplicationGroup(
    request: ModifyReplicationGroupRequest
  ): ElastiCacheIO[ModifyReplicationGroupResponse] =
    FF.liftF(ModifyReplicationGroupOp(request))

  def modifyReplicationGroupShardConfiguration(
    request: ModifyReplicationGroupShardConfigurationRequest
  ): ElastiCacheIO[ModifyReplicationGroupShardConfigurationResponse] =
    FF.liftF(ModifyReplicationGroupShardConfigurationOp(request))

  def modifyUser(
    request: ModifyUserRequest
  ): ElastiCacheIO[ModifyUserResponse] =
    FF.liftF(ModifyUserOp(request))

  def modifyUserGroup(
    request: ModifyUserGroupRequest
  ): ElastiCacheIO[ModifyUserGroupResponse] =
    FF.liftF(ModifyUserGroupOp(request))

  def purchaseReservedCacheNodesOffering(
    request: PurchaseReservedCacheNodesOfferingRequest
  ): ElastiCacheIO[PurchaseReservedCacheNodesOfferingResponse] =
    FF.liftF(PurchaseReservedCacheNodesOfferingOp(request))

  def rebalanceSlotsInGlobalReplicationGroup(
    request: RebalanceSlotsInGlobalReplicationGroupRequest
  ): ElastiCacheIO[RebalanceSlotsInGlobalReplicationGroupResponse] =
    FF.liftF(RebalanceSlotsInGlobalReplicationGroupOp(request))

  def rebootCacheCluster(
    request: RebootCacheClusterRequest
  ): ElastiCacheIO[RebootCacheClusterResponse] =
    FF.liftF(RebootCacheClusterOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): ElastiCacheIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def resetCacheParameterGroup(
    request: ResetCacheParameterGroupRequest
  ): ElastiCacheIO[ResetCacheParameterGroupResponse] =
    FF.liftF(ResetCacheParameterGroupOp(request))

  def revokeCacheSecurityGroupIngress(
    request: RevokeCacheSecurityGroupIngressRequest
  ): ElastiCacheIO[RevokeCacheSecurityGroupIngressResponse] =
    FF.liftF(RevokeCacheSecurityGroupIngressOp(request))

  def startMigration(
    request: StartMigrationRequest
  ): ElastiCacheIO[StartMigrationResponse] =
    FF.liftF(StartMigrationOp(request))

  def testFailover(
    request: TestFailoverRequest
  ): ElastiCacheIO[TestFailoverResponse] =
    FF.liftF(TestFailoverOp(request))
}
