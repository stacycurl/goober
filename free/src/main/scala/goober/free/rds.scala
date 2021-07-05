package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.rds.RdsClient
import software.amazon.awssdk.services.rds.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object rds { module =>

  // Free monad over RdsOp
  type RdsIO[A] = FF[RdsOp, A]

  sealed trait RdsOp[A] {
    def visit[F[_]](visitor: RdsOp.Visitor[F]): F[A]
  }

  object RdsOp {
    // Given a RdsClient we can embed a RdsIO program in any algebra that understands embedding.
    implicit val RdsOpEmbeddable: Embeddable[RdsOp, RdsClient] = new Embeddable[RdsOp, RdsClient] {
      def embed[A](client: RdsClient, io: RdsIO[A]): Embedded[A] = Embedded.Rds(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends RdsOp.Visitor[Kleisli[M, RdsClient, *]] {
        def addRoleToDBCluster(
          request: AddRoleToDbClusterRequest
        ): Kleisli[M, RdsClient, AddRoleToDbClusterResponse] =
          primitive(_.addRoleToDBCluster(request))

        def addRoleToDBInstance(
          request: AddRoleToDbInstanceRequest
        ): Kleisli[M, RdsClient, AddRoleToDbInstanceResponse] =
          primitive(_.addRoleToDBInstance(request))

        def addSourceIdentifierToSubscription(
          request: AddSourceIdentifierToSubscriptionRequest
        ): Kleisli[M, RdsClient, AddSourceIdentifierToSubscriptionResponse] =
          primitive(_.addSourceIdentifierToSubscription(request))

        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, RdsClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def applyPendingMaintenanceAction(
          request: ApplyPendingMaintenanceActionRequest
        ): Kleisli[M, RdsClient, ApplyPendingMaintenanceActionResponse] =
          primitive(_.applyPendingMaintenanceAction(request))

        def authorizeDBSecurityGroupIngress(
          request: AuthorizeDbSecurityGroupIngressRequest
        ): Kleisli[M, RdsClient, AuthorizeDbSecurityGroupIngressResponse] =
          primitive(_.authorizeDBSecurityGroupIngress(request))

        def backtrackDBCluster(
          request: BacktrackDbClusterRequest
        ): Kleisli[M, RdsClient, BacktrackDbClusterResponse] =
          primitive(_.backtrackDBCluster(request))

        def cancelExportTask(
          request: CancelExportTaskRequest
        ): Kleisli[M, RdsClient, CancelExportTaskResponse] =
          primitive(_.cancelExportTask(request))

        def copyDBClusterParameterGroup(
          request: CopyDbClusterParameterGroupRequest
        ): Kleisli[M, RdsClient, CopyDbClusterParameterGroupResponse] =
          primitive(_.copyDBClusterParameterGroup(request))

        def copyDBClusterSnapshot(
          request: CopyDbClusterSnapshotRequest
        ): Kleisli[M, RdsClient, CopyDbClusterSnapshotResponse] =
          primitive(_.copyDBClusterSnapshot(request))

        def copyDBParameterGroup(
          request: CopyDbParameterGroupRequest
        ): Kleisli[M, RdsClient, CopyDbParameterGroupResponse] =
          primitive(_.copyDBParameterGroup(request))

        def copyDBSnapshot(
          request: CopyDbSnapshotRequest
        ): Kleisli[M, RdsClient, CopyDbSnapshotResponse] =
          primitive(_.copyDBSnapshot(request))

        def copyOptionGroup(
          request: CopyOptionGroupRequest
        ): Kleisli[M, RdsClient, CopyOptionGroupResponse] =
          primitive(_.copyOptionGroup(request))

        def createCustomAvailabilityZone(
          request: CreateCustomAvailabilityZoneRequest
        ): Kleisli[M, RdsClient, CreateCustomAvailabilityZoneResponse] =
          primitive(_.createCustomAvailabilityZone(request))

        def createDBCluster(
          request: CreateDbClusterRequest
        ): Kleisli[M, RdsClient, CreateDbClusterResponse] =
          primitive(_.createDBCluster(request))

        def createDBClusterEndpoint(
          request: CreateDbClusterEndpointRequest
        ): Kleisli[M, RdsClient, CreateDbClusterEndpointResponse] =
          primitive(_.createDBClusterEndpoint(request))

        def createDBClusterParameterGroup(
          request: CreateDbClusterParameterGroupRequest
        ): Kleisli[M, RdsClient, CreateDbClusterParameterGroupResponse] =
          primitive(_.createDBClusterParameterGroup(request))

        def createDBClusterSnapshot(
          request: CreateDbClusterSnapshotRequest
        ): Kleisli[M, RdsClient, CreateDbClusterSnapshotResponse] =
          primitive(_.createDBClusterSnapshot(request))

        def createDBInstance(
          request: CreateDbInstanceRequest
        ): Kleisli[M, RdsClient, CreateDbInstanceResponse] =
          primitive(_.createDBInstance(request))

        def createDBInstanceReadReplica(
          request: CreateDbInstanceReadReplicaRequest
        ): Kleisli[M, RdsClient, CreateDbInstanceReadReplicaResponse] =
          primitive(_.createDBInstanceReadReplica(request))

        def createDBParameterGroup(
          request: CreateDbParameterGroupRequest
        ): Kleisli[M, RdsClient, CreateDbParameterGroupResponse] =
          primitive(_.createDBParameterGroup(request))

        def createDBProxy(
          request: CreateDbProxyRequest
        ): Kleisli[M, RdsClient, CreateDbProxyResponse] =
          primitive(_.createDBProxy(request))

        def createDBProxyEndpoint(
          request: CreateDbProxyEndpointRequest
        ): Kleisli[M, RdsClient, CreateDbProxyEndpointResponse] =
          primitive(_.createDBProxyEndpoint(request))

        def createDBSecurityGroup(
          request: CreateDbSecurityGroupRequest
        ): Kleisli[M, RdsClient, CreateDbSecurityGroupResponse] =
          primitive(_.createDBSecurityGroup(request))

        def createDBSnapshot(
          request: CreateDbSnapshotRequest
        ): Kleisli[M, RdsClient, CreateDbSnapshotResponse] =
          primitive(_.createDBSnapshot(request))

        def createDBSubnetGroup(
          request: CreateDbSubnetGroupRequest
        ): Kleisli[M, RdsClient, CreateDbSubnetGroupResponse] =
          primitive(_.createDBSubnetGroup(request))

        def createEventSubscription(
          request: CreateEventSubscriptionRequest
        ): Kleisli[M, RdsClient, CreateEventSubscriptionResponse] =
          primitive(_.createEventSubscription(request))

        def createGlobalCluster(
          request: CreateGlobalClusterRequest
        ): Kleisli[M, RdsClient, CreateGlobalClusterResponse] =
          primitive(_.createGlobalCluster(request))

        def createOptionGroup(
          request: CreateOptionGroupRequest
        ): Kleisli[M, RdsClient, CreateOptionGroupResponse] =
          primitive(_.createOptionGroup(request))

        def deleteCustomAvailabilityZone(
          request: DeleteCustomAvailabilityZoneRequest
        ): Kleisli[M, RdsClient, DeleteCustomAvailabilityZoneResponse] =
          primitive(_.deleteCustomAvailabilityZone(request))

        def deleteDBCluster(
          request: DeleteDbClusterRequest
        ): Kleisli[M, RdsClient, DeleteDbClusterResponse] =
          primitive(_.deleteDBCluster(request))

        def deleteDBClusterEndpoint(
          request: DeleteDbClusterEndpointRequest
        ): Kleisli[M, RdsClient, DeleteDbClusterEndpointResponse] =
          primitive(_.deleteDBClusterEndpoint(request))

        def deleteDBClusterParameterGroup(
          request: DeleteDbClusterParameterGroupRequest
        ): Kleisli[M, RdsClient, DeleteDbClusterParameterGroupResponse] =
          primitive(_.deleteDBClusterParameterGroup(request))

        def deleteDBClusterSnapshot(
          request: DeleteDbClusterSnapshotRequest
        ): Kleisli[M, RdsClient, DeleteDbClusterSnapshotResponse] =
          primitive(_.deleteDBClusterSnapshot(request))

        def deleteDBInstance(
          request: DeleteDbInstanceRequest
        ): Kleisli[M, RdsClient, DeleteDbInstanceResponse] =
          primitive(_.deleteDBInstance(request))

        def deleteDBInstanceAutomatedBackup(
          request: DeleteDbInstanceAutomatedBackupRequest
        ): Kleisli[M, RdsClient, DeleteDbInstanceAutomatedBackupResponse] =
          primitive(_.deleteDBInstanceAutomatedBackup(request))

        def deleteDBParameterGroup(
          request: DeleteDbParameterGroupRequest
        ): Kleisli[M, RdsClient, DeleteDbParameterGroupResponse] =
          primitive(_.deleteDBParameterGroup(request))

        def deleteDBProxy(
          request: DeleteDbProxyRequest
        ): Kleisli[M, RdsClient, DeleteDbProxyResponse] =
          primitive(_.deleteDBProxy(request))

        def deleteDBProxyEndpoint(
          request: DeleteDbProxyEndpointRequest
        ): Kleisli[M, RdsClient, DeleteDbProxyEndpointResponse] =
          primitive(_.deleteDBProxyEndpoint(request))

        def deleteDBSecurityGroup(
          request: DeleteDbSecurityGroupRequest
        ): Kleisli[M, RdsClient, DeleteDbSecurityGroupResponse] =
          primitive(_.deleteDBSecurityGroup(request))

        def deleteDBSnapshot(
          request: DeleteDbSnapshotRequest
        ): Kleisli[M, RdsClient, DeleteDbSnapshotResponse] =
          primitive(_.deleteDBSnapshot(request))

        def deleteDBSubnetGroup(
          request: DeleteDbSubnetGroupRequest
        ): Kleisli[M, RdsClient, DeleteDbSubnetGroupResponse] =
          primitive(_.deleteDBSubnetGroup(request))

        def deleteEventSubscription(
          request: DeleteEventSubscriptionRequest
        ): Kleisli[M, RdsClient, DeleteEventSubscriptionResponse] =
          primitive(_.deleteEventSubscription(request))

        def deleteGlobalCluster(
          request: DeleteGlobalClusterRequest
        ): Kleisli[M, RdsClient, DeleteGlobalClusterResponse] =
          primitive(_.deleteGlobalCluster(request))

        def deleteInstallationMedia(
          request: DeleteInstallationMediaRequest
        ): Kleisli[M, RdsClient, DeleteInstallationMediaResponse] =
          primitive(_.deleteInstallationMedia(request))

        def deleteOptionGroup(
          request: DeleteOptionGroupRequest
        ): Kleisli[M, RdsClient, DeleteOptionGroupResponse] =
          primitive(_.deleteOptionGroup(request))

        def deregisterDBProxyTargets(
          request: DeregisterDbProxyTargetsRequest
        ): Kleisli[M, RdsClient, DeregisterDbProxyTargetsResponse] =
          primitive(_.deregisterDBProxyTargets(request))

        def describeAccountAttributes(
          request: DescribeAccountAttributesRequest
        ): Kleisli[M, RdsClient, DescribeAccountAttributesResponse] =
          primitive(_.describeAccountAttributes(request))

        def describeCertificates(
          request: DescribeCertificatesRequest
        ): Kleisli[M, RdsClient, DescribeCertificatesResponse] =
          primitive(_.describeCertificates(request))

        def describeCustomAvailabilityZones(
          request: DescribeCustomAvailabilityZonesRequest
        ): Kleisli[M, RdsClient, DescribeCustomAvailabilityZonesResponse] =
          primitive(_.describeCustomAvailabilityZones(request))

        def describeDBClusterBacktracks(
          request: DescribeDbClusterBacktracksRequest
        ): Kleisli[M, RdsClient, DescribeDbClusterBacktracksResponse] =
          primitive(_.describeDBClusterBacktracks(request))

        def describeDBClusterEndpoints(
          request: DescribeDbClusterEndpointsRequest
        ): Kleisli[M, RdsClient, DescribeDbClusterEndpointsResponse] =
          primitive(_.describeDBClusterEndpoints(request))

        def describeDBClusterParameterGroups(
          request: DescribeDbClusterParameterGroupsRequest
        ): Kleisli[M, RdsClient, DescribeDbClusterParameterGroupsResponse] =
          primitive(_.describeDBClusterParameterGroups(request))

        def describeDBClusterParameters(
          request: DescribeDbClusterParametersRequest
        ): Kleisli[M, RdsClient, DescribeDbClusterParametersResponse] =
          primitive(_.describeDBClusterParameters(request))

        def describeDBClusterSnapshotAttributes(
          request: DescribeDbClusterSnapshotAttributesRequest
        ): Kleisli[M, RdsClient, DescribeDbClusterSnapshotAttributesResponse] =
          primitive(_.describeDBClusterSnapshotAttributes(request))

        def describeDBClusterSnapshots(
          request: DescribeDbClusterSnapshotsRequest
        ): Kleisli[M, RdsClient, DescribeDbClusterSnapshotsResponse] =
          primitive(_.describeDBClusterSnapshots(request))

        def describeDBClusters(
          request: DescribeDbClustersRequest
        ): Kleisli[M, RdsClient, DescribeDbClustersResponse] =
          primitive(_.describeDBClusters(request))

        def describeDBEngineVersions(
          request: DescribeDbEngineVersionsRequest
        ): Kleisli[M, RdsClient, DescribeDbEngineVersionsResponse] =
          primitive(_.describeDBEngineVersions(request))

        def describeDBInstanceAutomatedBackups(
          request: DescribeDbInstanceAutomatedBackupsRequest
        ): Kleisli[M, RdsClient, DescribeDbInstanceAutomatedBackupsResponse] =
          primitive(_.describeDBInstanceAutomatedBackups(request))

        def describeDBInstances(
          request: DescribeDbInstancesRequest
        ): Kleisli[M, RdsClient, DescribeDbInstancesResponse] =
          primitive(_.describeDBInstances(request))

        def describeDBLogFiles(
          request: DescribeDbLogFilesRequest
        ): Kleisli[M, RdsClient, DescribeDbLogFilesResponse] =
          primitive(_.describeDBLogFiles(request))

        def describeDBParameterGroups(
          request: DescribeDbParameterGroupsRequest
        ): Kleisli[M, RdsClient, DescribeDbParameterGroupsResponse] =
          primitive(_.describeDBParameterGroups(request))

        def describeDBParameters(
          request: DescribeDbParametersRequest
        ): Kleisli[M, RdsClient, DescribeDbParametersResponse] =
          primitive(_.describeDBParameters(request))

        def describeDBProxies(
          request: DescribeDbProxiesRequest
        ): Kleisli[M, RdsClient, DescribeDbProxiesResponse] =
          primitive(_.describeDBProxies(request))

        def describeDBProxyEndpoints(
          request: DescribeDbProxyEndpointsRequest
        ): Kleisli[M, RdsClient, DescribeDbProxyEndpointsResponse] =
          primitive(_.describeDBProxyEndpoints(request))

        def describeDBProxyTargetGroups(
          request: DescribeDbProxyTargetGroupsRequest
        ): Kleisli[M, RdsClient, DescribeDbProxyTargetGroupsResponse] =
          primitive(_.describeDBProxyTargetGroups(request))

        def describeDBProxyTargets(
          request: DescribeDbProxyTargetsRequest
        ): Kleisli[M, RdsClient, DescribeDbProxyTargetsResponse] =
          primitive(_.describeDBProxyTargets(request))

        def describeDBSecurityGroups(
          request: DescribeDbSecurityGroupsRequest
        ): Kleisli[M, RdsClient, DescribeDbSecurityGroupsResponse] =
          primitive(_.describeDBSecurityGroups(request))

        def describeDBSnapshotAttributes(
          request: DescribeDbSnapshotAttributesRequest
        ): Kleisli[M, RdsClient, DescribeDbSnapshotAttributesResponse] =
          primitive(_.describeDBSnapshotAttributes(request))

        def describeDBSnapshots(
          request: DescribeDbSnapshotsRequest
        ): Kleisli[M, RdsClient, DescribeDbSnapshotsResponse] =
          primitive(_.describeDBSnapshots(request))

        def describeDBSubnetGroups(
          request: DescribeDbSubnetGroupsRequest
        ): Kleisli[M, RdsClient, DescribeDbSubnetGroupsResponse] =
          primitive(_.describeDBSubnetGroups(request))

        def describeEngineDefaultClusterParameters(
          request: DescribeEngineDefaultClusterParametersRequest
        ): Kleisli[M, RdsClient, DescribeEngineDefaultClusterParametersResponse] =
          primitive(_.describeEngineDefaultClusterParameters(request))

        def describeEngineDefaultParameters(
          request: DescribeEngineDefaultParametersRequest
        ): Kleisli[M, RdsClient, DescribeEngineDefaultParametersResponse] =
          primitive(_.describeEngineDefaultParameters(request))

        def describeEventCategories(
          request: DescribeEventCategoriesRequest
        ): Kleisli[M, RdsClient, DescribeEventCategoriesResponse] =
          primitive(_.describeEventCategories(request))

        def describeEventSubscriptions(
          request: DescribeEventSubscriptionsRequest
        ): Kleisli[M, RdsClient, DescribeEventSubscriptionsResponse] =
          primitive(_.describeEventSubscriptions(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, RdsClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeExportTasks(
          request: DescribeExportTasksRequest
        ): Kleisli[M, RdsClient, DescribeExportTasksResponse] =
          primitive(_.describeExportTasks(request))

        def describeGlobalClusters(
          request: DescribeGlobalClustersRequest
        ): Kleisli[M, RdsClient, DescribeGlobalClustersResponse] =
          primitive(_.describeGlobalClusters(request))

        def describeInstallationMedia(
          request: DescribeInstallationMediaRequest
        ): Kleisli[M, RdsClient, DescribeInstallationMediaResponse] =
          primitive(_.describeInstallationMedia(request))

        def describeOptionGroupOptions(
          request: DescribeOptionGroupOptionsRequest
        ): Kleisli[M, RdsClient, DescribeOptionGroupOptionsResponse] =
          primitive(_.describeOptionGroupOptions(request))

        def describeOptionGroups(
          request: DescribeOptionGroupsRequest
        ): Kleisli[M, RdsClient, DescribeOptionGroupsResponse] =
          primitive(_.describeOptionGroups(request))

        def describeOrderableDBInstanceOptions(
          request: DescribeOrderableDbInstanceOptionsRequest
        ): Kleisli[M, RdsClient, DescribeOrderableDbInstanceOptionsResponse] =
          primitive(_.describeOrderableDBInstanceOptions(request))

        def describePendingMaintenanceActions(
          request: DescribePendingMaintenanceActionsRequest
        ): Kleisli[M, RdsClient, DescribePendingMaintenanceActionsResponse] =
          primitive(_.describePendingMaintenanceActions(request))

        def describeReservedDBInstances(
          request: DescribeReservedDbInstancesRequest
        ): Kleisli[M, RdsClient, DescribeReservedDbInstancesResponse] =
          primitive(_.describeReservedDBInstances(request))

        def describeReservedDBInstancesOfferings(
          request: DescribeReservedDbInstancesOfferingsRequest
        ): Kleisli[M, RdsClient, DescribeReservedDbInstancesOfferingsResponse] =
          primitive(_.describeReservedDBInstancesOfferings(request))

        def describeSourceRegions(
          request: DescribeSourceRegionsRequest
        ): Kleisli[M, RdsClient, DescribeSourceRegionsResponse] =
          primitive(_.describeSourceRegions(request))

        def describeValidDBInstanceModifications(
          request: DescribeValidDbInstanceModificationsRequest
        ): Kleisli[M, RdsClient, DescribeValidDbInstanceModificationsResponse] =
          primitive(_.describeValidDBInstanceModifications(request))

        def downloadDBLogFilePortion(
          request: DownloadDbLogFilePortionRequest
        ): Kleisli[M, RdsClient, DownloadDbLogFilePortionResponse] =
          primitive(_.downloadDBLogFilePortion(request))

        def failoverDBCluster(
          request: FailoverDbClusterRequest
        ): Kleisli[M, RdsClient, FailoverDbClusterResponse] =
          primitive(_.failoverDBCluster(request))

        def failoverGlobalCluster(
          request: FailoverGlobalClusterRequest
        ): Kleisli[M, RdsClient, FailoverGlobalClusterResponse] =
          primitive(_.failoverGlobalCluster(request))

        def importInstallationMedia(
          request: ImportInstallationMediaRequest
        ): Kleisli[M, RdsClient, ImportInstallationMediaResponse] =
          primitive(_.importInstallationMedia(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, RdsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyCertificates(
          request: ModifyCertificatesRequest
        ): Kleisli[M, RdsClient, ModifyCertificatesResponse] =
          primitive(_.modifyCertificates(request))

        def modifyCurrentDBClusterCapacity(
          request: ModifyCurrentDbClusterCapacityRequest
        ): Kleisli[M, RdsClient, ModifyCurrentDbClusterCapacityResponse] =
          primitive(_.modifyCurrentDBClusterCapacity(request))

        def modifyDBCluster(
          request: ModifyDbClusterRequest
        ): Kleisli[M, RdsClient, ModifyDbClusterResponse] =
          primitive(_.modifyDBCluster(request))

        def modifyDBClusterEndpoint(
          request: ModifyDbClusterEndpointRequest
        ): Kleisli[M, RdsClient, ModifyDbClusterEndpointResponse] =
          primitive(_.modifyDBClusterEndpoint(request))

        def modifyDBClusterParameterGroup(
          request: ModifyDbClusterParameterGroupRequest
        ): Kleisli[M, RdsClient, ModifyDbClusterParameterGroupResponse] =
          primitive(_.modifyDBClusterParameterGroup(request))

        def modifyDBClusterSnapshotAttribute(
          request: ModifyDbClusterSnapshotAttributeRequest
        ): Kleisli[M, RdsClient, ModifyDbClusterSnapshotAttributeResponse] =
          primitive(_.modifyDBClusterSnapshotAttribute(request))

        def modifyDBInstance(
          request: ModifyDbInstanceRequest
        ): Kleisli[M, RdsClient, ModifyDbInstanceResponse] =
          primitive(_.modifyDBInstance(request))

        def modifyDBParameterGroup(
          request: ModifyDbParameterGroupRequest
        ): Kleisli[M, RdsClient, ModifyDbParameterGroupResponse] =
          primitive(_.modifyDBParameterGroup(request))

        def modifyDBProxy(
          request: ModifyDbProxyRequest
        ): Kleisli[M, RdsClient, ModifyDbProxyResponse] =
          primitive(_.modifyDBProxy(request))

        def modifyDBProxyEndpoint(
          request: ModifyDbProxyEndpointRequest
        ): Kleisli[M, RdsClient, ModifyDbProxyEndpointResponse] =
          primitive(_.modifyDBProxyEndpoint(request))

        def modifyDBProxyTargetGroup(
          request: ModifyDbProxyTargetGroupRequest
        ): Kleisli[M, RdsClient, ModifyDbProxyTargetGroupResponse] =
          primitive(_.modifyDBProxyTargetGroup(request))

        def modifyDBSnapshot(
          request: ModifyDbSnapshotRequest
        ): Kleisli[M, RdsClient, ModifyDbSnapshotResponse] =
          primitive(_.modifyDBSnapshot(request))

        def modifyDBSnapshotAttribute(
          request: ModifyDbSnapshotAttributeRequest
        ): Kleisli[M, RdsClient, ModifyDbSnapshotAttributeResponse] =
          primitive(_.modifyDBSnapshotAttribute(request))

        def modifyDBSubnetGroup(
          request: ModifyDbSubnetGroupRequest
        ): Kleisli[M, RdsClient, ModifyDbSubnetGroupResponse] =
          primitive(_.modifyDBSubnetGroup(request))

        def modifyEventSubscription(
          request: ModifyEventSubscriptionRequest
        ): Kleisli[M, RdsClient, ModifyEventSubscriptionResponse] =
          primitive(_.modifyEventSubscription(request))

        def modifyGlobalCluster(
          request: ModifyGlobalClusterRequest
        ): Kleisli[M, RdsClient, ModifyGlobalClusterResponse] =
          primitive(_.modifyGlobalCluster(request))

        def modifyOptionGroup(
          request: ModifyOptionGroupRequest
        ): Kleisli[M, RdsClient, ModifyOptionGroupResponse] =
          primitive(_.modifyOptionGroup(request))

        def promoteReadReplica(
          request: PromoteReadReplicaRequest
        ): Kleisli[M, RdsClient, PromoteReadReplicaResponse] =
          primitive(_.promoteReadReplica(request))

        def promoteReadReplicaDBCluster(
          request: PromoteReadReplicaDbClusterRequest
        ): Kleisli[M, RdsClient, PromoteReadReplicaDbClusterResponse] =
          primitive(_.promoteReadReplicaDBCluster(request))

        def purchaseReservedDBInstancesOffering(
          request: PurchaseReservedDbInstancesOfferingRequest
        ): Kleisli[M, RdsClient, PurchaseReservedDbInstancesOfferingResponse] =
          primitive(_.purchaseReservedDBInstancesOffering(request))

        def rebootDBInstance(
          request: RebootDbInstanceRequest
        ): Kleisli[M, RdsClient, RebootDbInstanceResponse] =
          primitive(_.rebootDBInstance(request))

        def registerDBProxyTargets(
          request: RegisterDbProxyTargetsRequest
        ): Kleisli[M, RdsClient, RegisterDbProxyTargetsResponse] =
          primitive(_.registerDBProxyTargets(request))

        def removeFromGlobalCluster(
          request: RemoveFromGlobalClusterRequest
        ): Kleisli[M, RdsClient, RemoveFromGlobalClusterResponse] =
          primitive(_.removeFromGlobalCluster(request))

        def removeRoleFromDBCluster(
          request: RemoveRoleFromDbClusterRequest
        ): Kleisli[M, RdsClient, RemoveRoleFromDbClusterResponse] =
          primitive(_.removeRoleFromDBCluster(request))

        def removeRoleFromDBInstance(
          request: RemoveRoleFromDbInstanceRequest
        ): Kleisli[M, RdsClient, RemoveRoleFromDbInstanceResponse] =
          primitive(_.removeRoleFromDBInstance(request))

        def removeSourceIdentifierFromSubscription(
          request: RemoveSourceIdentifierFromSubscriptionRequest
        ): Kleisli[M, RdsClient, RemoveSourceIdentifierFromSubscriptionResponse] =
          primitive(_.removeSourceIdentifierFromSubscription(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, RdsClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def resetDBClusterParameterGroup(
          request: ResetDbClusterParameterGroupRequest
        ): Kleisli[M, RdsClient, ResetDbClusterParameterGroupResponse] =
          primitive(_.resetDBClusterParameterGroup(request))

        def resetDBParameterGroup(
          request: ResetDbParameterGroupRequest
        ): Kleisli[M, RdsClient, ResetDbParameterGroupResponse] =
          primitive(_.resetDBParameterGroup(request))

        def restoreDBClusterFromS3(
          request: RestoreDbClusterFromS3Request
        ): Kleisli[M, RdsClient, RestoreDbClusterFromS3Response] =
          primitive(_.restoreDBClusterFromS3(request))

        def restoreDBClusterFromSnapshot(
          request: RestoreDbClusterFromSnapshotRequest
        ): Kleisli[M, RdsClient, RestoreDbClusterFromSnapshotResponse] =
          primitive(_.restoreDBClusterFromSnapshot(request))

        def restoreDBClusterToPointInTime(
          request: RestoreDbClusterToPointInTimeRequest
        ): Kleisli[M, RdsClient, RestoreDbClusterToPointInTimeResponse] =
          primitive(_.restoreDBClusterToPointInTime(request))

        def restoreDBInstanceFromDBSnapshot(
          request: RestoreDbInstanceFromDbSnapshotRequest
        ): Kleisli[M, RdsClient, RestoreDbInstanceFromDbSnapshotResponse] =
          primitive(_.restoreDBInstanceFromDBSnapshot(request))

        def restoreDBInstanceFromS3(
          request: RestoreDbInstanceFromS3Request
        ): Kleisli[M, RdsClient, RestoreDbInstanceFromS3Response] =
          primitive(_.restoreDBInstanceFromS3(request))

        def restoreDBInstanceToPointInTime(
          request: RestoreDbInstanceToPointInTimeRequest
        ): Kleisli[M, RdsClient, RestoreDbInstanceToPointInTimeResponse] =
          primitive(_.restoreDBInstanceToPointInTime(request))

        def revokeDBSecurityGroupIngress(
          request: RevokeDbSecurityGroupIngressRequest
        ): Kleisli[M, RdsClient, RevokeDbSecurityGroupIngressResponse] =
          primitive(_.revokeDBSecurityGroupIngress(request))

        def startActivityStream(
          request: StartActivityStreamRequest
        ): Kleisli[M, RdsClient, StartActivityStreamResponse] =
          primitive(_.startActivityStream(request))

        def startDBCluster(
          request: StartDbClusterRequest
        ): Kleisli[M, RdsClient, StartDbClusterResponse] =
          primitive(_.startDBCluster(request))

        def startDBInstance(
          request: StartDbInstanceRequest
        ): Kleisli[M, RdsClient, StartDbInstanceResponse] =
          primitive(_.startDBInstance(request))

        def startDBInstanceAutomatedBackupsReplication(
          request: StartDbInstanceAutomatedBackupsReplicationRequest
        ): Kleisli[M, RdsClient, StartDbInstanceAutomatedBackupsReplicationResponse] =
          primitive(_.startDBInstanceAutomatedBackupsReplication(request))

        def startExportTask(
          request: StartExportTaskRequest
        ): Kleisli[M, RdsClient, StartExportTaskResponse] =
          primitive(_.startExportTask(request))

        def stopActivityStream(
          request: StopActivityStreamRequest
        ): Kleisli[M, RdsClient, StopActivityStreamResponse] =
          primitive(_.stopActivityStream(request))

        def stopDBCluster(
          request: StopDbClusterRequest
        ): Kleisli[M, RdsClient, StopDbClusterResponse] =
          primitive(_.stopDBCluster(request))

        def stopDBInstance(
          request: StopDbInstanceRequest
        ): Kleisli[M, RdsClient, StopDbInstanceResponse] =
          primitive(_.stopDBInstance(request))

        def stopDBInstanceAutomatedBackupsReplication(
          request: StopDbInstanceAutomatedBackupsReplicationRequest
        ): Kleisli[M, RdsClient, StopDbInstanceAutomatedBackupsReplicationResponse] =
          primitive(_.stopDBInstanceAutomatedBackupsReplication(request))

        def primitive[A](
          f: RdsClient => A
        ): Kleisli[M, RdsClient, A]
      }
    }

    trait Visitor[F[_]] extends (RdsOp ~> F) {
      final def apply[A](op: RdsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addRoleToDBCluster(
        request: AddRoleToDbClusterRequest
      ): F[AddRoleToDbClusterResponse]

      def addRoleToDBInstance(
        request: AddRoleToDbInstanceRequest
      ): F[AddRoleToDbInstanceResponse]

      def addSourceIdentifierToSubscription(
        request: AddSourceIdentifierToSubscriptionRequest
      ): F[AddSourceIdentifierToSubscriptionResponse]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def applyPendingMaintenanceAction(
        request: ApplyPendingMaintenanceActionRequest
      ): F[ApplyPendingMaintenanceActionResponse]

      def authorizeDBSecurityGroupIngress(
        request: AuthorizeDbSecurityGroupIngressRequest
      ): F[AuthorizeDbSecurityGroupIngressResponse]

      def backtrackDBCluster(
        request: BacktrackDbClusterRequest
      ): F[BacktrackDbClusterResponse]

      def cancelExportTask(
        request: CancelExportTaskRequest
      ): F[CancelExportTaskResponse]

      def copyDBClusterParameterGroup(
        request: CopyDbClusterParameterGroupRequest
      ): F[CopyDbClusterParameterGroupResponse]

      def copyDBClusterSnapshot(
        request: CopyDbClusterSnapshotRequest
      ): F[CopyDbClusterSnapshotResponse]

      def copyDBParameterGroup(
        request: CopyDbParameterGroupRequest
      ): F[CopyDbParameterGroupResponse]

      def copyDBSnapshot(
        request: CopyDbSnapshotRequest
      ): F[CopyDbSnapshotResponse]

      def copyOptionGroup(
        request: CopyOptionGroupRequest
      ): F[CopyOptionGroupResponse]

      def createCustomAvailabilityZone(
        request: CreateCustomAvailabilityZoneRequest
      ): F[CreateCustomAvailabilityZoneResponse]

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

      def createDBInstanceReadReplica(
        request: CreateDbInstanceReadReplicaRequest
      ): F[CreateDbInstanceReadReplicaResponse]

      def createDBParameterGroup(
        request: CreateDbParameterGroupRequest
      ): F[CreateDbParameterGroupResponse]

      def createDBProxy(
        request: CreateDbProxyRequest
      ): F[CreateDbProxyResponse]

      def createDBProxyEndpoint(
        request: CreateDbProxyEndpointRequest
      ): F[CreateDbProxyEndpointResponse]

      def createDBSecurityGroup(
        request: CreateDbSecurityGroupRequest
      ): F[CreateDbSecurityGroupResponse]

      def createDBSnapshot(
        request: CreateDbSnapshotRequest
      ): F[CreateDbSnapshotResponse]

      def createDBSubnetGroup(
        request: CreateDbSubnetGroupRequest
      ): F[CreateDbSubnetGroupResponse]

      def createEventSubscription(
        request: CreateEventSubscriptionRequest
      ): F[CreateEventSubscriptionResponse]

      def createGlobalCluster(
        request: CreateGlobalClusterRequest
      ): F[CreateGlobalClusterResponse]

      def createOptionGroup(
        request: CreateOptionGroupRequest
      ): F[CreateOptionGroupResponse]

      def deleteCustomAvailabilityZone(
        request: DeleteCustomAvailabilityZoneRequest
      ): F[DeleteCustomAvailabilityZoneResponse]

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

      def deleteDBInstanceAutomatedBackup(
        request: DeleteDbInstanceAutomatedBackupRequest
      ): F[DeleteDbInstanceAutomatedBackupResponse]

      def deleteDBParameterGroup(
        request: DeleteDbParameterGroupRequest
      ): F[DeleteDbParameterGroupResponse]

      def deleteDBProxy(
        request: DeleteDbProxyRequest
      ): F[DeleteDbProxyResponse]

      def deleteDBProxyEndpoint(
        request: DeleteDbProxyEndpointRequest
      ): F[DeleteDbProxyEndpointResponse]

      def deleteDBSecurityGroup(
        request: DeleteDbSecurityGroupRequest
      ): F[DeleteDbSecurityGroupResponse]

      def deleteDBSnapshot(
        request: DeleteDbSnapshotRequest
      ): F[DeleteDbSnapshotResponse]

      def deleteDBSubnetGroup(
        request: DeleteDbSubnetGroupRequest
      ): F[DeleteDbSubnetGroupResponse]

      def deleteEventSubscription(
        request: DeleteEventSubscriptionRequest
      ): F[DeleteEventSubscriptionResponse]

      def deleteGlobalCluster(
        request: DeleteGlobalClusterRequest
      ): F[DeleteGlobalClusterResponse]

      def deleteInstallationMedia(
        request: DeleteInstallationMediaRequest
      ): F[DeleteInstallationMediaResponse]

      def deleteOptionGroup(
        request: DeleteOptionGroupRequest
      ): F[DeleteOptionGroupResponse]

      def deregisterDBProxyTargets(
        request: DeregisterDbProxyTargetsRequest
      ): F[DeregisterDbProxyTargetsResponse]

      def describeAccountAttributes(
        request: DescribeAccountAttributesRequest
      ): F[DescribeAccountAttributesResponse]

      def describeCertificates(
        request: DescribeCertificatesRequest
      ): F[DescribeCertificatesResponse]

      def describeCustomAvailabilityZones(
        request: DescribeCustomAvailabilityZonesRequest
      ): F[DescribeCustomAvailabilityZonesResponse]

      def describeDBClusterBacktracks(
        request: DescribeDbClusterBacktracksRequest
      ): F[DescribeDbClusterBacktracksResponse]

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

      def describeDBInstanceAutomatedBackups(
        request: DescribeDbInstanceAutomatedBackupsRequest
      ): F[DescribeDbInstanceAutomatedBackupsResponse]

      def describeDBInstances(
        request: DescribeDbInstancesRequest
      ): F[DescribeDbInstancesResponse]

      def describeDBLogFiles(
        request: DescribeDbLogFilesRequest
      ): F[DescribeDbLogFilesResponse]

      def describeDBParameterGroups(
        request: DescribeDbParameterGroupsRequest
      ): F[DescribeDbParameterGroupsResponse]

      def describeDBParameters(
        request: DescribeDbParametersRequest
      ): F[DescribeDbParametersResponse]

      def describeDBProxies(
        request: DescribeDbProxiesRequest
      ): F[DescribeDbProxiesResponse]

      def describeDBProxyEndpoints(
        request: DescribeDbProxyEndpointsRequest
      ): F[DescribeDbProxyEndpointsResponse]

      def describeDBProxyTargetGroups(
        request: DescribeDbProxyTargetGroupsRequest
      ): F[DescribeDbProxyTargetGroupsResponse]

      def describeDBProxyTargets(
        request: DescribeDbProxyTargetsRequest
      ): F[DescribeDbProxyTargetsResponse]

      def describeDBSecurityGroups(
        request: DescribeDbSecurityGroupsRequest
      ): F[DescribeDbSecurityGroupsResponse]

      def describeDBSnapshotAttributes(
        request: DescribeDbSnapshotAttributesRequest
      ): F[DescribeDbSnapshotAttributesResponse]

      def describeDBSnapshots(
        request: DescribeDbSnapshotsRequest
      ): F[DescribeDbSnapshotsResponse]

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

      def describeExportTasks(
        request: DescribeExportTasksRequest
      ): F[DescribeExportTasksResponse]

      def describeGlobalClusters(
        request: DescribeGlobalClustersRequest
      ): F[DescribeGlobalClustersResponse]

      def describeInstallationMedia(
        request: DescribeInstallationMediaRequest
      ): F[DescribeInstallationMediaResponse]

      def describeOptionGroupOptions(
        request: DescribeOptionGroupOptionsRequest
      ): F[DescribeOptionGroupOptionsResponse]

      def describeOptionGroups(
        request: DescribeOptionGroupsRequest
      ): F[DescribeOptionGroupsResponse]

      def describeOrderableDBInstanceOptions(
        request: DescribeOrderableDbInstanceOptionsRequest
      ): F[DescribeOrderableDbInstanceOptionsResponse]

      def describePendingMaintenanceActions(
        request: DescribePendingMaintenanceActionsRequest
      ): F[DescribePendingMaintenanceActionsResponse]

      def describeReservedDBInstances(
        request: DescribeReservedDbInstancesRequest
      ): F[DescribeReservedDbInstancesResponse]

      def describeReservedDBInstancesOfferings(
        request: DescribeReservedDbInstancesOfferingsRequest
      ): F[DescribeReservedDbInstancesOfferingsResponse]

      def describeSourceRegions(
        request: DescribeSourceRegionsRequest
      ): F[DescribeSourceRegionsResponse]

      def describeValidDBInstanceModifications(
        request: DescribeValidDbInstanceModificationsRequest
      ): F[DescribeValidDbInstanceModificationsResponse]

      def downloadDBLogFilePortion(
        request: DownloadDbLogFilePortionRequest
      ): F[DownloadDbLogFilePortionResponse]

      def failoverDBCluster(
        request: FailoverDbClusterRequest
      ): F[FailoverDbClusterResponse]

      def failoverGlobalCluster(
        request: FailoverGlobalClusterRequest
      ): F[FailoverGlobalClusterResponse]

      def importInstallationMedia(
        request: ImportInstallationMediaRequest
      ): F[ImportInstallationMediaResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyCertificates(
        request: ModifyCertificatesRequest
      ): F[ModifyCertificatesResponse]

      def modifyCurrentDBClusterCapacity(
        request: ModifyCurrentDbClusterCapacityRequest
      ): F[ModifyCurrentDbClusterCapacityResponse]

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

      def modifyDBProxy(
        request: ModifyDbProxyRequest
      ): F[ModifyDbProxyResponse]

      def modifyDBProxyEndpoint(
        request: ModifyDbProxyEndpointRequest
      ): F[ModifyDbProxyEndpointResponse]

      def modifyDBProxyTargetGroup(
        request: ModifyDbProxyTargetGroupRequest
      ): F[ModifyDbProxyTargetGroupResponse]

      def modifyDBSnapshot(
        request: ModifyDbSnapshotRequest
      ): F[ModifyDbSnapshotResponse]

      def modifyDBSnapshotAttribute(
        request: ModifyDbSnapshotAttributeRequest
      ): F[ModifyDbSnapshotAttributeResponse]

      def modifyDBSubnetGroup(
        request: ModifyDbSubnetGroupRequest
      ): F[ModifyDbSubnetGroupResponse]

      def modifyEventSubscription(
        request: ModifyEventSubscriptionRequest
      ): F[ModifyEventSubscriptionResponse]

      def modifyGlobalCluster(
        request: ModifyGlobalClusterRequest
      ): F[ModifyGlobalClusterResponse]

      def modifyOptionGroup(
        request: ModifyOptionGroupRequest
      ): F[ModifyOptionGroupResponse]

      def promoteReadReplica(
        request: PromoteReadReplicaRequest
      ): F[PromoteReadReplicaResponse]

      def promoteReadReplicaDBCluster(
        request: PromoteReadReplicaDbClusterRequest
      ): F[PromoteReadReplicaDbClusterResponse]

      def purchaseReservedDBInstancesOffering(
        request: PurchaseReservedDbInstancesOfferingRequest
      ): F[PurchaseReservedDbInstancesOfferingResponse]

      def rebootDBInstance(
        request: RebootDbInstanceRequest
      ): F[RebootDbInstanceResponse]

      def registerDBProxyTargets(
        request: RegisterDbProxyTargetsRequest
      ): F[RegisterDbProxyTargetsResponse]

      def removeFromGlobalCluster(
        request: RemoveFromGlobalClusterRequest
      ): F[RemoveFromGlobalClusterResponse]

      def removeRoleFromDBCluster(
        request: RemoveRoleFromDbClusterRequest
      ): F[RemoveRoleFromDbClusterResponse]

      def removeRoleFromDBInstance(
        request: RemoveRoleFromDbInstanceRequest
      ): F[RemoveRoleFromDbInstanceResponse]

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

      def restoreDBClusterFromS3(
        request: RestoreDbClusterFromS3Request
      ): F[RestoreDbClusterFromS3Response]

      def restoreDBClusterFromSnapshot(
        request: RestoreDbClusterFromSnapshotRequest
      ): F[RestoreDbClusterFromSnapshotResponse]

      def restoreDBClusterToPointInTime(
        request: RestoreDbClusterToPointInTimeRequest
      ): F[RestoreDbClusterToPointInTimeResponse]

      def restoreDBInstanceFromDBSnapshot(
        request: RestoreDbInstanceFromDbSnapshotRequest
      ): F[RestoreDbInstanceFromDbSnapshotResponse]

      def restoreDBInstanceFromS3(
        request: RestoreDbInstanceFromS3Request
      ): F[RestoreDbInstanceFromS3Response]

      def restoreDBInstanceToPointInTime(
        request: RestoreDbInstanceToPointInTimeRequest
      ): F[RestoreDbInstanceToPointInTimeResponse]

      def revokeDBSecurityGroupIngress(
        request: RevokeDbSecurityGroupIngressRequest
      ): F[RevokeDbSecurityGroupIngressResponse]

      def startActivityStream(
        request: StartActivityStreamRequest
      ): F[StartActivityStreamResponse]

      def startDBCluster(
        request: StartDbClusterRequest
      ): F[StartDbClusterResponse]

      def startDBInstance(
        request: StartDbInstanceRequest
      ): F[StartDbInstanceResponse]

      def startDBInstanceAutomatedBackupsReplication(
        request: StartDbInstanceAutomatedBackupsReplicationRequest
      ): F[StartDbInstanceAutomatedBackupsReplicationResponse]

      def startExportTask(
        request: StartExportTaskRequest
      ): F[StartExportTaskResponse]

      def stopActivityStream(
        request: StopActivityStreamRequest
      ): F[StopActivityStreamResponse]

      def stopDBCluster(
        request: StopDbClusterRequest
      ): F[StopDbClusterResponse]

      def stopDBInstance(
        request: StopDbInstanceRequest
      ): F[StopDbInstanceResponse]

      def stopDBInstanceAutomatedBackupsReplication(
        request: StopDbInstanceAutomatedBackupsReplicationRequest
      ): F[StopDbInstanceAutomatedBackupsReplicationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends RdsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddRoleToDBClusterOp(
      request: AddRoleToDbClusterRequest
    ) extends RdsOp[AddRoleToDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddRoleToDbClusterResponse] =
        visitor.addRoleToDBCluster(request)
    }

    final case class AddRoleToDBInstanceOp(
      request: AddRoleToDbInstanceRequest
    ) extends RdsOp[AddRoleToDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddRoleToDbInstanceResponse] =
        visitor.addRoleToDBInstance(request)
    }

    final case class AddSourceIdentifierToSubscriptionOp(
      request: AddSourceIdentifierToSubscriptionRequest
    ) extends RdsOp[AddSourceIdentifierToSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddSourceIdentifierToSubscriptionResponse] =
        visitor.addSourceIdentifierToSubscription(request)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends RdsOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class ApplyPendingMaintenanceActionOp(
      request: ApplyPendingMaintenanceActionRequest
    ) extends RdsOp[ApplyPendingMaintenanceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApplyPendingMaintenanceActionResponse] =
        visitor.applyPendingMaintenanceAction(request)
    }

    final case class AuthorizeDBSecurityGroupIngressOp(
      request: AuthorizeDbSecurityGroupIngressRequest
    ) extends RdsOp[AuthorizeDbSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeDbSecurityGroupIngressResponse] =
        visitor.authorizeDBSecurityGroupIngress(request)
    }

    final case class BacktrackDBClusterOp(
      request: BacktrackDbClusterRequest
    ) extends RdsOp[BacktrackDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BacktrackDbClusterResponse] =
        visitor.backtrackDBCluster(request)
    }

    final case class CancelExportTaskOp(
      request: CancelExportTaskRequest
    ) extends RdsOp[CancelExportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelExportTaskResponse] =
        visitor.cancelExportTask(request)
    }

    final case class CopyDBClusterParameterGroupOp(
      request: CopyDbClusterParameterGroupRequest
    ) extends RdsOp[CopyDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbClusterParameterGroupResponse] =
        visitor.copyDBClusterParameterGroup(request)
    }

    final case class CopyDBClusterSnapshotOp(
      request: CopyDbClusterSnapshotRequest
    ) extends RdsOp[CopyDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbClusterSnapshotResponse] =
        visitor.copyDBClusterSnapshot(request)
    }

    final case class CopyDBParameterGroupOp(
      request: CopyDbParameterGroupRequest
    ) extends RdsOp[CopyDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbParameterGroupResponse] =
        visitor.copyDBParameterGroup(request)
    }

    final case class CopyDBSnapshotOp(
      request: CopyDbSnapshotRequest
    ) extends RdsOp[CopyDbSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyDbSnapshotResponse] =
        visitor.copyDBSnapshot(request)
    }

    final case class CopyOptionGroupOp(
      request: CopyOptionGroupRequest
    ) extends RdsOp[CopyOptionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyOptionGroupResponse] =
        visitor.copyOptionGroup(request)
    }

    final case class CreateCustomAvailabilityZoneOp(
      request: CreateCustomAvailabilityZoneRequest
    ) extends RdsOp[CreateCustomAvailabilityZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomAvailabilityZoneResponse] =
        visitor.createCustomAvailabilityZone(request)
    }

    final case class CreateDBClusterOp(
      request: CreateDbClusterRequest
    ) extends RdsOp[CreateDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterResponse] =
        visitor.createDBCluster(request)
    }

    final case class CreateDBClusterEndpointOp(
      request: CreateDbClusterEndpointRequest
    ) extends RdsOp[CreateDbClusterEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterEndpointResponse] =
        visitor.createDBClusterEndpoint(request)
    }

    final case class CreateDBClusterParameterGroupOp(
      request: CreateDbClusterParameterGroupRequest
    ) extends RdsOp[CreateDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterParameterGroupResponse] =
        visitor.createDBClusterParameterGroup(request)
    }

    final case class CreateDBClusterSnapshotOp(
      request: CreateDbClusterSnapshotRequest
    ) extends RdsOp[CreateDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbClusterSnapshotResponse] =
        visitor.createDBClusterSnapshot(request)
    }

    final case class CreateDBInstanceOp(
      request: CreateDbInstanceRequest
    ) extends RdsOp[CreateDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbInstanceResponse] =
        visitor.createDBInstance(request)
    }

    final case class CreateDBInstanceReadReplicaOp(
      request: CreateDbInstanceReadReplicaRequest
    ) extends RdsOp[CreateDbInstanceReadReplicaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbInstanceReadReplicaResponse] =
        visitor.createDBInstanceReadReplica(request)
    }

    final case class CreateDBParameterGroupOp(
      request: CreateDbParameterGroupRequest
    ) extends RdsOp[CreateDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbParameterGroupResponse] =
        visitor.createDBParameterGroup(request)
    }

    final case class CreateDBProxyOp(
      request: CreateDbProxyRequest
    ) extends RdsOp[CreateDbProxyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbProxyResponse] =
        visitor.createDBProxy(request)
    }

    final case class CreateDBProxyEndpointOp(
      request: CreateDbProxyEndpointRequest
    ) extends RdsOp[CreateDbProxyEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbProxyEndpointResponse] =
        visitor.createDBProxyEndpoint(request)
    }

    final case class CreateDBSecurityGroupOp(
      request: CreateDbSecurityGroupRequest
    ) extends RdsOp[CreateDbSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbSecurityGroupResponse] =
        visitor.createDBSecurityGroup(request)
    }

    final case class CreateDBSnapshotOp(
      request: CreateDbSnapshotRequest
    ) extends RdsOp[CreateDbSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbSnapshotResponse] =
        visitor.createDBSnapshot(request)
    }

    final case class CreateDBSubnetGroupOp(
      request: CreateDbSubnetGroupRequest
    ) extends RdsOp[CreateDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDbSubnetGroupResponse] =
        visitor.createDBSubnetGroup(request)
    }

    final case class CreateEventSubscriptionOp(
      request: CreateEventSubscriptionRequest
    ) extends RdsOp[CreateEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventSubscriptionResponse] =
        visitor.createEventSubscription(request)
    }

    final case class CreateGlobalClusterOp(
      request: CreateGlobalClusterRequest
    ) extends RdsOp[CreateGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGlobalClusterResponse] =
        visitor.createGlobalCluster(request)
    }

    final case class CreateOptionGroupOp(
      request: CreateOptionGroupRequest
    ) extends RdsOp[CreateOptionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOptionGroupResponse] =
        visitor.createOptionGroup(request)
    }

    final case class DeleteCustomAvailabilityZoneOp(
      request: DeleteCustomAvailabilityZoneRequest
    ) extends RdsOp[DeleteCustomAvailabilityZoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomAvailabilityZoneResponse] =
        visitor.deleteCustomAvailabilityZone(request)
    }

    final case class DeleteDBClusterOp(
      request: DeleteDbClusterRequest
    ) extends RdsOp[DeleteDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterResponse] =
        visitor.deleteDBCluster(request)
    }

    final case class DeleteDBClusterEndpointOp(
      request: DeleteDbClusterEndpointRequest
    ) extends RdsOp[DeleteDbClusterEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterEndpointResponse] =
        visitor.deleteDBClusterEndpoint(request)
    }

    final case class DeleteDBClusterParameterGroupOp(
      request: DeleteDbClusterParameterGroupRequest
    ) extends RdsOp[DeleteDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterParameterGroupResponse] =
        visitor.deleteDBClusterParameterGroup(request)
    }

    final case class DeleteDBClusterSnapshotOp(
      request: DeleteDbClusterSnapshotRequest
    ) extends RdsOp[DeleteDbClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbClusterSnapshotResponse] =
        visitor.deleteDBClusterSnapshot(request)
    }

    final case class DeleteDBInstanceOp(
      request: DeleteDbInstanceRequest
    ) extends RdsOp[DeleteDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbInstanceResponse] =
        visitor.deleteDBInstance(request)
    }

    final case class DeleteDBInstanceAutomatedBackupOp(
      request: DeleteDbInstanceAutomatedBackupRequest
    ) extends RdsOp[DeleteDbInstanceAutomatedBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbInstanceAutomatedBackupResponse] =
        visitor.deleteDBInstanceAutomatedBackup(request)
    }

    final case class DeleteDBParameterGroupOp(
      request: DeleteDbParameterGroupRequest
    ) extends RdsOp[DeleteDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbParameterGroupResponse] =
        visitor.deleteDBParameterGroup(request)
    }

    final case class DeleteDBProxyOp(
      request: DeleteDbProxyRequest
    ) extends RdsOp[DeleteDbProxyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbProxyResponse] =
        visitor.deleteDBProxy(request)
    }

    final case class DeleteDBProxyEndpointOp(
      request: DeleteDbProxyEndpointRequest
    ) extends RdsOp[DeleteDbProxyEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbProxyEndpointResponse] =
        visitor.deleteDBProxyEndpoint(request)
    }

    final case class DeleteDBSecurityGroupOp(
      request: DeleteDbSecurityGroupRequest
    ) extends RdsOp[DeleteDbSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbSecurityGroupResponse] =
        visitor.deleteDBSecurityGroup(request)
    }

    final case class DeleteDBSnapshotOp(
      request: DeleteDbSnapshotRequest
    ) extends RdsOp[DeleteDbSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbSnapshotResponse] =
        visitor.deleteDBSnapshot(request)
    }

    final case class DeleteDBSubnetGroupOp(
      request: DeleteDbSubnetGroupRequest
    ) extends RdsOp[DeleteDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDbSubnetGroupResponse] =
        visitor.deleteDBSubnetGroup(request)
    }

    final case class DeleteEventSubscriptionOp(
      request: DeleteEventSubscriptionRequest
    ) extends RdsOp[DeleteEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventSubscriptionResponse] =
        visitor.deleteEventSubscription(request)
    }

    final case class DeleteGlobalClusterOp(
      request: DeleteGlobalClusterRequest
    ) extends RdsOp[DeleteGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGlobalClusterResponse] =
        visitor.deleteGlobalCluster(request)
    }

    final case class DeleteInstallationMediaOp(
      request: DeleteInstallationMediaRequest
    ) extends RdsOp[DeleteInstallationMediaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstallationMediaResponse] =
        visitor.deleteInstallationMedia(request)
    }

    final case class DeleteOptionGroupOp(
      request: DeleteOptionGroupRequest
    ) extends RdsOp[DeleteOptionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOptionGroupResponse] =
        visitor.deleteOptionGroup(request)
    }

    final case class DeregisterDBProxyTargetsOp(
      request: DeregisterDbProxyTargetsRequest
    ) extends RdsOp[DeregisterDbProxyTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterDbProxyTargetsResponse] =
        visitor.deregisterDBProxyTargets(request)
    }

    final case class DescribeAccountAttributesOp(
      request: DescribeAccountAttributesRequest
    ) extends RdsOp[DescribeAccountAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAttributesResponse] =
        visitor.describeAccountAttributes(request)
    }

    final case class DescribeCertificatesOp(
      request: DescribeCertificatesRequest
    ) extends RdsOp[DescribeCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificatesResponse] =
        visitor.describeCertificates(request)
    }

    final case class DescribeCustomAvailabilityZonesOp(
      request: DescribeCustomAvailabilityZonesRequest
    ) extends RdsOp[DescribeCustomAvailabilityZonesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomAvailabilityZonesResponse] =
        visitor.describeCustomAvailabilityZones(request)
    }

    final case class DescribeDBClusterBacktracksOp(
      request: DescribeDbClusterBacktracksRequest
    ) extends RdsOp[DescribeDbClusterBacktracksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterBacktracksResponse] =
        visitor.describeDBClusterBacktracks(request)
    }

    final case class DescribeDBClusterEndpointsOp(
      request: DescribeDbClusterEndpointsRequest
    ) extends RdsOp[DescribeDbClusterEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterEndpointsResponse] =
        visitor.describeDBClusterEndpoints(request)
    }

    final case class DescribeDBClusterParameterGroupsOp(
      request: DescribeDbClusterParameterGroupsRequest
    ) extends RdsOp[DescribeDbClusterParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterParameterGroupsResponse] =
        visitor.describeDBClusterParameterGroups(request)
    }

    final case class DescribeDBClusterParametersOp(
      request: DescribeDbClusterParametersRequest
    ) extends RdsOp[DescribeDbClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterParametersResponse] =
        visitor.describeDBClusterParameters(request)
    }

    final case class DescribeDBClusterSnapshotAttributesOp(
      request: DescribeDbClusterSnapshotAttributesRequest
    ) extends RdsOp[DescribeDbClusterSnapshotAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterSnapshotAttributesResponse] =
        visitor.describeDBClusterSnapshotAttributes(request)
    }

    final case class DescribeDBClusterSnapshotsOp(
      request: DescribeDbClusterSnapshotsRequest
    ) extends RdsOp[DescribeDbClusterSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClusterSnapshotsResponse] =
        visitor.describeDBClusterSnapshots(request)
    }

    final case class DescribeDBClustersOp(
      request: DescribeDbClustersRequest
    ) extends RdsOp[DescribeDbClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbClustersResponse] =
        visitor.describeDBClusters(request)
    }

    final case class DescribeDBEngineVersionsOp(
      request: DescribeDbEngineVersionsRequest
    ) extends RdsOp[DescribeDbEngineVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbEngineVersionsResponse] =
        visitor.describeDBEngineVersions(request)
    }

    final case class DescribeDBInstanceAutomatedBackupsOp(
      request: DescribeDbInstanceAutomatedBackupsRequest
    ) extends RdsOp[DescribeDbInstanceAutomatedBackupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbInstanceAutomatedBackupsResponse] =
        visitor.describeDBInstanceAutomatedBackups(request)
    }

    final case class DescribeDBInstancesOp(
      request: DescribeDbInstancesRequest
    ) extends RdsOp[DescribeDbInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbInstancesResponse] =
        visitor.describeDBInstances(request)
    }

    final case class DescribeDBLogFilesOp(
      request: DescribeDbLogFilesRequest
    ) extends RdsOp[DescribeDbLogFilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbLogFilesResponse] =
        visitor.describeDBLogFiles(request)
    }

    final case class DescribeDBParameterGroupsOp(
      request: DescribeDbParameterGroupsRequest
    ) extends RdsOp[DescribeDbParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbParameterGroupsResponse] =
        visitor.describeDBParameterGroups(request)
    }

    final case class DescribeDBParametersOp(
      request: DescribeDbParametersRequest
    ) extends RdsOp[DescribeDbParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbParametersResponse] =
        visitor.describeDBParameters(request)
    }

    final case class DescribeDBProxiesOp(
      request: DescribeDbProxiesRequest
    ) extends RdsOp[DescribeDbProxiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbProxiesResponse] =
        visitor.describeDBProxies(request)
    }

    final case class DescribeDBProxyEndpointsOp(
      request: DescribeDbProxyEndpointsRequest
    ) extends RdsOp[DescribeDbProxyEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbProxyEndpointsResponse] =
        visitor.describeDBProxyEndpoints(request)
    }

    final case class DescribeDBProxyTargetGroupsOp(
      request: DescribeDbProxyTargetGroupsRequest
    ) extends RdsOp[DescribeDbProxyTargetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbProxyTargetGroupsResponse] =
        visitor.describeDBProxyTargetGroups(request)
    }

    final case class DescribeDBProxyTargetsOp(
      request: DescribeDbProxyTargetsRequest
    ) extends RdsOp[DescribeDbProxyTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbProxyTargetsResponse] =
        visitor.describeDBProxyTargets(request)
    }

    final case class DescribeDBSecurityGroupsOp(
      request: DescribeDbSecurityGroupsRequest
    ) extends RdsOp[DescribeDbSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbSecurityGroupsResponse] =
        visitor.describeDBSecurityGroups(request)
    }

    final case class DescribeDBSnapshotAttributesOp(
      request: DescribeDbSnapshotAttributesRequest
    ) extends RdsOp[DescribeDbSnapshotAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbSnapshotAttributesResponse] =
        visitor.describeDBSnapshotAttributes(request)
    }

    final case class DescribeDBSnapshotsOp(
      request: DescribeDbSnapshotsRequest
    ) extends RdsOp[DescribeDbSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbSnapshotsResponse] =
        visitor.describeDBSnapshots(request)
    }

    final case class DescribeDBSubnetGroupsOp(
      request: DescribeDbSubnetGroupsRequest
    ) extends RdsOp[DescribeDbSubnetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDbSubnetGroupsResponse] =
        visitor.describeDBSubnetGroups(request)
    }

    final case class DescribeEngineDefaultClusterParametersOp(
      request: DescribeEngineDefaultClusterParametersRequest
    ) extends RdsOp[DescribeEngineDefaultClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEngineDefaultClusterParametersResponse] =
        visitor.describeEngineDefaultClusterParameters(request)
    }

    final case class DescribeEngineDefaultParametersOp(
      request: DescribeEngineDefaultParametersRequest
    ) extends RdsOp[DescribeEngineDefaultParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEngineDefaultParametersResponse] =
        visitor.describeEngineDefaultParameters(request)
    }

    final case class DescribeEventCategoriesOp(
      request: DescribeEventCategoriesRequest
    ) extends RdsOp[DescribeEventCategoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventCategoriesResponse] =
        visitor.describeEventCategories(request)
    }

    final case class DescribeEventSubscriptionsOp(
      request: DescribeEventSubscriptionsRequest
    ) extends RdsOp[DescribeEventSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventSubscriptionsResponse] =
        visitor.describeEventSubscriptions(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends RdsOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeExportTasksOp(
      request: DescribeExportTasksRequest
    ) extends RdsOp[DescribeExportTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExportTasksResponse] =
        visitor.describeExportTasks(request)
    }

    final case class DescribeGlobalClustersOp(
      request: DescribeGlobalClustersRequest
    ) extends RdsOp[DescribeGlobalClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGlobalClustersResponse] =
        visitor.describeGlobalClusters(request)
    }

    final case class DescribeInstallationMediaOp(
      request: DescribeInstallationMediaRequest
    ) extends RdsOp[DescribeInstallationMediaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstallationMediaResponse] =
        visitor.describeInstallationMedia(request)
    }

    final case class DescribeOptionGroupOptionsOp(
      request: DescribeOptionGroupOptionsRequest
    ) extends RdsOp[DescribeOptionGroupOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOptionGroupOptionsResponse] =
        visitor.describeOptionGroupOptions(request)
    }

    final case class DescribeOptionGroupsOp(
      request: DescribeOptionGroupsRequest
    ) extends RdsOp[DescribeOptionGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOptionGroupsResponse] =
        visitor.describeOptionGroups(request)
    }

    final case class DescribeOrderableDBInstanceOptionsOp(
      request: DescribeOrderableDbInstanceOptionsRequest
    ) extends RdsOp[DescribeOrderableDbInstanceOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrderableDbInstanceOptionsResponse] =
        visitor.describeOrderableDBInstanceOptions(request)
    }

    final case class DescribePendingMaintenanceActionsOp(
      request: DescribePendingMaintenanceActionsRequest
    ) extends RdsOp[DescribePendingMaintenanceActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePendingMaintenanceActionsResponse] =
        visitor.describePendingMaintenanceActions(request)
    }

    final case class DescribeReservedDBInstancesOp(
      request: DescribeReservedDbInstancesRequest
    ) extends RdsOp[DescribeReservedDbInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedDbInstancesResponse] =
        visitor.describeReservedDBInstances(request)
    }

    final case class DescribeReservedDBInstancesOfferingsOp(
      request: DescribeReservedDbInstancesOfferingsRequest
    ) extends RdsOp[DescribeReservedDbInstancesOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedDbInstancesOfferingsResponse] =
        visitor.describeReservedDBInstancesOfferings(request)
    }

    final case class DescribeSourceRegionsOp(
      request: DescribeSourceRegionsRequest
    ) extends RdsOp[DescribeSourceRegionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSourceRegionsResponse] =
        visitor.describeSourceRegions(request)
    }

    final case class DescribeValidDBInstanceModificationsOp(
      request: DescribeValidDbInstanceModificationsRequest
    ) extends RdsOp[DescribeValidDbInstanceModificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeValidDbInstanceModificationsResponse] =
        visitor.describeValidDBInstanceModifications(request)
    }

    final case class DownloadDBLogFilePortionOp(
      request: DownloadDbLogFilePortionRequest
    ) extends RdsOp[DownloadDbLogFilePortionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DownloadDbLogFilePortionResponse] =
        visitor.downloadDBLogFilePortion(request)
    }

    final case class FailoverDBClusterOp(
      request: FailoverDbClusterRequest
    ) extends RdsOp[FailoverDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FailoverDbClusterResponse] =
        visitor.failoverDBCluster(request)
    }

    final case class FailoverGlobalClusterOp(
      request: FailoverGlobalClusterRequest
    ) extends RdsOp[FailoverGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FailoverGlobalClusterResponse] =
        visitor.failoverGlobalCluster(request)
    }

    final case class ImportInstallationMediaOp(
      request: ImportInstallationMediaRequest
    ) extends RdsOp[ImportInstallationMediaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportInstallationMediaResponse] =
        visitor.importInstallationMedia(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends RdsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyCertificatesOp(
      request: ModifyCertificatesRequest
    ) extends RdsOp[ModifyCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyCertificatesResponse] =
        visitor.modifyCertificates(request)
    }

    final case class ModifyCurrentDBClusterCapacityOp(
      request: ModifyCurrentDbClusterCapacityRequest
    ) extends RdsOp[ModifyCurrentDbClusterCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyCurrentDbClusterCapacityResponse] =
        visitor.modifyCurrentDBClusterCapacity(request)
    }

    final case class ModifyDBClusterOp(
      request: ModifyDbClusterRequest
    ) extends RdsOp[ModifyDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterResponse] =
        visitor.modifyDBCluster(request)
    }

    final case class ModifyDBClusterEndpointOp(
      request: ModifyDbClusterEndpointRequest
    ) extends RdsOp[ModifyDbClusterEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterEndpointResponse] =
        visitor.modifyDBClusterEndpoint(request)
    }

    final case class ModifyDBClusterParameterGroupOp(
      request: ModifyDbClusterParameterGroupRequest
    ) extends RdsOp[ModifyDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterParameterGroupResponse] =
        visitor.modifyDBClusterParameterGroup(request)
    }

    final case class ModifyDBClusterSnapshotAttributeOp(
      request: ModifyDbClusterSnapshotAttributeRequest
    ) extends RdsOp[ModifyDbClusterSnapshotAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbClusterSnapshotAttributeResponse] =
        visitor.modifyDBClusterSnapshotAttribute(request)
    }

    final case class ModifyDBInstanceOp(
      request: ModifyDbInstanceRequest
    ) extends RdsOp[ModifyDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbInstanceResponse] =
        visitor.modifyDBInstance(request)
    }

    final case class ModifyDBParameterGroupOp(
      request: ModifyDbParameterGroupRequest
    ) extends RdsOp[ModifyDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbParameterGroupResponse] =
        visitor.modifyDBParameterGroup(request)
    }

    final case class ModifyDBProxyOp(
      request: ModifyDbProxyRequest
    ) extends RdsOp[ModifyDbProxyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbProxyResponse] =
        visitor.modifyDBProxy(request)
    }

    final case class ModifyDBProxyEndpointOp(
      request: ModifyDbProxyEndpointRequest
    ) extends RdsOp[ModifyDbProxyEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbProxyEndpointResponse] =
        visitor.modifyDBProxyEndpoint(request)
    }

    final case class ModifyDBProxyTargetGroupOp(
      request: ModifyDbProxyTargetGroupRequest
    ) extends RdsOp[ModifyDbProxyTargetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbProxyTargetGroupResponse] =
        visitor.modifyDBProxyTargetGroup(request)
    }

    final case class ModifyDBSnapshotOp(
      request: ModifyDbSnapshotRequest
    ) extends RdsOp[ModifyDbSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbSnapshotResponse] =
        visitor.modifyDBSnapshot(request)
    }

    final case class ModifyDBSnapshotAttributeOp(
      request: ModifyDbSnapshotAttributeRequest
    ) extends RdsOp[ModifyDbSnapshotAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbSnapshotAttributeResponse] =
        visitor.modifyDBSnapshotAttribute(request)
    }

    final case class ModifyDBSubnetGroupOp(
      request: ModifyDbSubnetGroupRequest
    ) extends RdsOp[ModifyDbSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDbSubnetGroupResponse] =
        visitor.modifyDBSubnetGroup(request)
    }

    final case class ModifyEventSubscriptionOp(
      request: ModifyEventSubscriptionRequest
    ) extends RdsOp[ModifyEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEventSubscriptionResponse] =
        visitor.modifyEventSubscription(request)
    }

    final case class ModifyGlobalClusterOp(
      request: ModifyGlobalClusterRequest
    ) extends RdsOp[ModifyGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyGlobalClusterResponse] =
        visitor.modifyGlobalCluster(request)
    }

    final case class ModifyOptionGroupOp(
      request: ModifyOptionGroupRequest
    ) extends RdsOp[ModifyOptionGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyOptionGroupResponse] =
        visitor.modifyOptionGroup(request)
    }

    final case class PromoteReadReplicaOp(
      request: PromoteReadReplicaRequest
    ) extends RdsOp[PromoteReadReplicaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PromoteReadReplicaResponse] =
        visitor.promoteReadReplica(request)
    }

    final case class PromoteReadReplicaDBClusterOp(
      request: PromoteReadReplicaDbClusterRequest
    ) extends RdsOp[PromoteReadReplicaDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PromoteReadReplicaDbClusterResponse] =
        visitor.promoteReadReplicaDBCluster(request)
    }

    final case class PurchaseReservedDBInstancesOfferingOp(
      request: PurchaseReservedDbInstancesOfferingRequest
    ) extends RdsOp[PurchaseReservedDbInstancesOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseReservedDbInstancesOfferingResponse] =
        visitor.purchaseReservedDBInstancesOffering(request)
    }

    final case class RebootDBInstanceOp(
      request: RebootDbInstanceRequest
    ) extends RdsOp[RebootDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootDbInstanceResponse] =
        visitor.rebootDBInstance(request)
    }

    final case class RegisterDBProxyTargetsOp(
      request: RegisterDbProxyTargetsRequest
    ) extends RdsOp[RegisterDbProxyTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterDbProxyTargetsResponse] =
        visitor.registerDBProxyTargets(request)
    }

    final case class RemoveFromGlobalClusterOp(
      request: RemoveFromGlobalClusterRequest
    ) extends RdsOp[RemoveFromGlobalClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveFromGlobalClusterResponse] =
        visitor.removeFromGlobalCluster(request)
    }

    final case class RemoveRoleFromDBClusterOp(
      request: RemoveRoleFromDbClusterRequest
    ) extends RdsOp[RemoveRoleFromDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveRoleFromDbClusterResponse] =
        visitor.removeRoleFromDBCluster(request)
    }

    final case class RemoveRoleFromDBInstanceOp(
      request: RemoveRoleFromDbInstanceRequest
    ) extends RdsOp[RemoveRoleFromDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveRoleFromDbInstanceResponse] =
        visitor.removeRoleFromDBInstance(request)
    }

    final case class RemoveSourceIdentifierFromSubscriptionOp(
      request: RemoveSourceIdentifierFromSubscriptionRequest
    ) extends RdsOp[RemoveSourceIdentifierFromSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveSourceIdentifierFromSubscriptionResponse] =
        visitor.removeSourceIdentifierFromSubscription(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends RdsOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class ResetDBClusterParameterGroupOp(
      request: ResetDbClusterParameterGroupRequest
    ) extends RdsOp[ResetDbClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetDbClusterParameterGroupResponse] =
        visitor.resetDBClusterParameterGroup(request)
    }

    final case class ResetDBParameterGroupOp(
      request: ResetDbParameterGroupRequest
    ) extends RdsOp[ResetDbParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetDbParameterGroupResponse] =
        visitor.resetDBParameterGroup(request)
    }

    final case class RestoreDBClusterFromS3Op(
      request: RestoreDbClusterFromS3Request
    ) extends RdsOp[RestoreDbClusterFromS3Response] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbClusterFromS3Response] =
        visitor.restoreDBClusterFromS3(request)
    }

    final case class RestoreDBClusterFromSnapshotOp(
      request: RestoreDbClusterFromSnapshotRequest
    ) extends RdsOp[RestoreDbClusterFromSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbClusterFromSnapshotResponse] =
        visitor.restoreDBClusterFromSnapshot(request)
    }

    final case class RestoreDBClusterToPointInTimeOp(
      request: RestoreDbClusterToPointInTimeRequest
    ) extends RdsOp[RestoreDbClusterToPointInTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbClusterToPointInTimeResponse] =
        visitor.restoreDBClusterToPointInTime(request)
    }

    final case class RestoreDBInstanceFromDBSnapshotOp(
      request: RestoreDbInstanceFromDbSnapshotRequest
    ) extends RdsOp[RestoreDbInstanceFromDbSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbInstanceFromDbSnapshotResponse] =
        visitor.restoreDBInstanceFromDBSnapshot(request)
    }

    final case class RestoreDBInstanceFromS3Op(
      request: RestoreDbInstanceFromS3Request
    ) extends RdsOp[RestoreDbInstanceFromS3Response] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbInstanceFromS3Response] =
        visitor.restoreDBInstanceFromS3(request)
    }

    final case class RestoreDBInstanceToPointInTimeOp(
      request: RestoreDbInstanceToPointInTimeRequest
    ) extends RdsOp[RestoreDbInstanceToPointInTimeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreDbInstanceToPointInTimeResponse] =
        visitor.restoreDBInstanceToPointInTime(request)
    }

    final case class RevokeDBSecurityGroupIngressOp(
      request: RevokeDbSecurityGroupIngressRequest
    ) extends RdsOp[RevokeDbSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeDbSecurityGroupIngressResponse] =
        visitor.revokeDBSecurityGroupIngress(request)
    }

    final case class StartActivityStreamOp(
      request: StartActivityStreamRequest
    ) extends RdsOp[StartActivityStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartActivityStreamResponse] =
        visitor.startActivityStream(request)
    }

    final case class StartDBClusterOp(
      request: StartDbClusterRequest
    ) extends RdsOp[StartDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDbClusterResponse] =
        visitor.startDBCluster(request)
    }

    final case class StartDBInstanceOp(
      request: StartDbInstanceRequest
    ) extends RdsOp[StartDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDbInstanceResponse] =
        visitor.startDBInstance(request)
    }

    final case class StartDBInstanceAutomatedBackupsReplicationOp(
      request: StartDbInstanceAutomatedBackupsReplicationRequest
    ) extends RdsOp[StartDbInstanceAutomatedBackupsReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDbInstanceAutomatedBackupsReplicationResponse] =
        visitor.startDBInstanceAutomatedBackupsReplication(request)
    }

    final case class StartExportTaskOp(
      request: StartExportTaskRequest
    ) extends RdsOp[StartExportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartExportTaskResponse] =
        visitor.startExportTask(request)
    }

    final case class StopActivityStreamOp(
      request: StopActivityStreamRequest
    ) extends RdsOp[StopActivityStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopActivityStreamResponse] =
        visitor.stopActivityStream(request)
    }

    final case class StopDBClusterOp(
      request: StopDbClusterRequest
    ) extends RdsOp[StopDbClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDbClusterResponse] =
        visitor.stopDBCluster(request)
    }

    final case class StopDBInstanceOp(
      request: StopDbInstanceRequest
    ) extends RdsOp[StopDbInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDbInstanceResponse] =
        visitor.stopDBInstance(request)
    }

    final case class StopDBInstanceAutomatedBackupsReplicationOp(
      request: StopDbInstanceAutomatedBackupsReplicationRequest
    ) extends RdsOp[StopDbInstanceAutomatedBackupsReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDbInstanceAutomatedBackupsReplicationResponse] =
        visitor.stopDBInstanceAutomatedBackupsReplication(request)
    }
  }

  import RdsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[RdsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addRoleToDBCluster(
    request: AddRoleToDbClusterRequest
  ): RdsIO[AddRoleToDbClusterResponse] =
    FF.liftF(AddRoleToDBClusterOp(request))

  def addRoleToDBInstance(
    request: AddRoleToDbInstanceRequest
  ): RdsIO[AddRoleToDbInstanceResponse] =
    FF.liftF(AddRoleToDBInstanceOp(request))

  def addSourceIdentifierToSubscription(
    request: AddSourceIdentifierToSubscriptionRequest
  ): RdsIO[AddSourceIdentifierToSubscriptionResponse] =
    FF.liftF(AddSourceIdentifierToSubscriptionOp(request))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): RdsIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def applyPendingMaintenanceAction(
    request: ApplyPendingMaintenanceActionRequest
  ): RdsIO[ApplyPendingMaintenanceActionResponse] =
    FF.liftF(ApplyPendingMaintenanceActionOp(request))

  def authorizeDBSecurityGroupIngress(
    request: AuthorizeDbSecurityGroupIngressRequest
  ): RdsIO[AuthorizeDbSecurityGroupIngressResponse] =
    FF.liftF(AuthorizeDBSecurityGroupIngressOp(request))

  def backtrackDBCluster(
    request: BacktrackDbClusterRequest
  ): RdsIO[BacktrackDbClusterResponse] =
    FF.liftF(BacktrackDBClusterOp(request))

  def cancelExportTask(
    request: CancelExportTaskRequest
  ): RdsIO[CancelExportTaskResponse] =
    FF.liftF(CancelExportTaskOp(request))

  def copyDBClusterParameterGroup(
    request: CopyDbClusterParameterGroupRequest
  ): RdsIO[CopyDbClusterParameterGroupResponse] =
    FF.liftF(CopyDBClusterParameterGroupOp(request))

  def copyDBClusterSnapshot(
    request: CopyDbClusterSnapshotRequest
  ): RdsIO[CopyDbClusterSnapshotResponse] =
    FF.liftF(CopyDBClusterSnapshotOp(request))

  def copyDBParameterGroup(
    request: CopyDbParameterGroupRequest
  ): RdsIO[CopyDbParameterGroupResponse] =
    FF.liftF(CopyDBParameterGroupOp(request))

  def copyDBSnapshot(
    request: CopyDbSnapshotRequest
  ): RdsIO[CopyDbSnapshotResponse] =
    FF.liftF(CopyDBSnapshotOp(request))

  def copyOptionGroup(
    request: CopyOptionGroupRequest
  ): RdsIO[CopyOptionGroupResponse] =
    FF.liftF(CopyOptionGroupOp(request))

  def createCustomAvailabilityZone(
    request: CreateCustomAvailabilityZoneRequest
  ): RdsIO[CreateCustomAvailabilityZoneResponse] =
    FF.liftF(CreateCustomAvailabilityZoneOp(request))

  def createDBCluster(
    request: CreateDbClusterRequest
  ): RdsIO[CreateDbClusterResponse] =
    FF.liftF(CreateDBClusterOp(request))

  def createDBClusterEndpoint(
    request: CreateDbClusterEndpointRequest
  ): RdsIO[CreateDbClusterEndpointResponse] =
    FF.liftF(CreateDBClusterEndpointOp(request))

  def createDBClusterParameterGroup(
    request: CreateDbClusterParameterGroupRequest
  ): RdsIO[CreateDbClusterParameterGroupResponse] =
    FF.liftF(CreateDBClusterParameterGroupOp(request))

  def createDBClusterSnapshot(
    request: CreateDbClusterSnapshotRequest
  ): RdsIO[CreateDbClusterSnapshotResponse] =
    FF.liftF(CreateDBClusterSnapshotOp(request))

  def createDBInstance(
    request: CreateDbInstanceRequest
  ): RdsIO[CreateDbInstanceResponse] =
    FF.liftF(CreateDBInstanceOp(request))

  def createDBInstanceReadReplica(
    request: CreateDbInstanceReadReplicaRequest
  ): RdsIO[CreateDbInstanceReadReplicaResponse] =
    FF.liftF(CreateDBInstanceReadReplicaOp(request))

  def createDBParameterGroup(
    request: CreateDbParameterGroupRequest
  ): RdsIO[CreateDbParameterGroupResponse] =
    FF.liftF(CreateDBParameterGroupOp(request))

  def createDBProxy(
    request: CreateDbProxyRequest
  ): RdsIO[CreateDbProxyResponse] =
    FF.liftF(CreateDBProxyOp(request))

  def createDBProxyEndpoint(
    request: CreateDbProxyEndpointRequest
  ): RdsIO[CreateDbProxyEndpointResponse] =
    FF.liftF(CreateDBProxyEndpointOp(request))

  def createDBSecurityGroup(
    request: CreateDbSecurityGroupRequest
  ): RdsIO[CreateDbSecurityGroupResponse] =
    FF.liftF(CreateDBSecurityGroupOp(request))

  def createDBSnapshot(
    request: CreateDbSnapshotRequest
  ): RdsIO[CreateDbSnapshotResponse] =
    FF.liftF(CreateDBSnapshotOp(request))

  def createDBSubnetGroup(
    request: CreateDbSubnetGroupRequest
  ): RdsIO[CreateDbSubnetGroupResponse] =
    FF.liftF(CreateDBSubnetGroupOp(request))

  def createEventSubscription(
    request: CreateEventSubscriptionRequest
  ): RdsIO[CreateEventSubscriptionResponse] =
    FF.liftF(CreateEventSubscriptionOp(request))

  def createGlobalCluster(
    request: CreateGlobalClusterRequest
  ): RdsIO[CreateGlobalClusterResponse] =
    FF.liftF(CreateGlobalClusterOp(request))

  def createOptionGroup(
    request: CreateOptionGroupRequest
  ): RdsIO[CreateOptionGroupResponse] =
    FF.liftF(CreateOptionGroupOp(request))

  def deleteCustomAvailabilityZone(
    request: DeleteCustomAvailabilityZoneRequest
  ): RdsIO[DeleteCustomAvailabilityZoneResponse] =
    FF.liftF(DeleteCustomAvailabilityZoneOp(request))

  def deleteDBCluster(
    request: DeleteDbClusterRequest
  ): RdsIO[DeleteDbClusterResponse] =
    FF.liftF(DeleteDBClusterOp(request))

  def deleteDBClusterEndpoint(
    request: DeleteDbClusterEndpointRequest
  ): RdsIO[DeleteDbClusterEndpointResponse] =
    FF.liftF(DeleteDBClusterEndpointOp(request))

  def deleteDBClusterParameterGroup(
    request: DeleteDbClusterParameterGroupRequest
  ): RdsIO[DeleteDbClusterParameterGroupResponse] =
    FF.liftF(DeleteDBClusterParameterGroupOp(request))

  def deleteDBClusterSnapshot(
    request: DeleteDbClusterSnapshotRequest
  ): RdsIO[DeleteDbClusterSnapshotResponse] =
    FF.liftF(DeleteDBClusterSnapshotOp(request))

  def deleteDBInstance(
    request: DeleteDbInstanceRequest
  ): RdsIO[DeleteDbInstanceResponse] =
    FF.liftF(DeleteDBInstanceOp(request))

  def deleteDBInstanceAutomatedBackup(
    request: DeleteDbInstanceAutomatedBackupRequest
  ): RdsIO[DeleteDbInstanceAutomatedBackupResponse] =
    FF.liftF(DeleteDBInstanceAutomatedBackupOp(request))

  def deleteDBParameterGroup(
    request: DeleteDbParameterGroupRequest
  ): RdsIO[DeleteDbParameterGroupResponse] =
    FF.liftF(DeleteDBParameterGroupOp(request))

  def deleteDBProxy(
    request: DeleteDbProxyRequest
  ): RdsIO[DeleteDbProxyResponse] =
    FF.liftF(DeleteDBProxyOp(request))

  def deleteDBProxyEndpoint(
    request: DeleteDbProxyEndpointRequest
  ): RdsIO[DeleteDbProxyEndpointResponse] =
    FF.liftF(DeleteDBProxyEndpointOp(request))

  def deleteDBSecurityGroup(
    request: DeleteDbSecurityGroupRequest
  ): RdsIO[DeleteDbSecurityGroupResponse] =
    FF.liftF(DeleteDBSecurityGroupOp(request))

  def deleteDBSnapshot(
    request: DeleteDbSnapshotRequest
  ): RdsIO[DeleteDbSnapshotResponse] =
    FF.liftF(DeleteDBSnapshotOp(request))

  def deleteDBSubnetGroup(
    request: DeleteDbSubnetGroupRequest
  ): RdsIO[DeleteDbSubnetGroupResponse] =
    FF.liftF(DeleteDBSubnetGroupOp(request))

  def deleteEventSubscription(
    request: DeleteEventSubscriptionRequest
  ): RdsIO[DeleteEventSubscriptionResponse] =
    FF.liftF(DeleteEventSubscriptionOp(request))

  def deleteGlobalCluster(
    request: DeleteGlobalClusterRequest
  ): RdsIO[DeleteGlobalClusterResponse] =
    FF.liftF(DeleteGlobalClusterOp(request))

  def deleteInstallationMedia(
    request: DeleteInstallationMediaRequest
  ): RdsIO[DeleteInstallationMediaResponse] =
    FF.liftF(DeleteInstallationMediaOp(request))

  def deleteOptionGroup(
    request: DeleteOptionGroupRequest
  ): RdsIO[DeleteOptionGroupResponse] =
    FF.liftF(DeleteOptionGroupOp(request))

  def deregisterDBProxyTargets(
    request: DeregisterDbProxyTargetsRequest
  ): RdsIO[DeregisterDbProxyTargetsResponse] =
    FF.liftF(DeregisterDBProxyTargetsOp(request))

  def describeAccountAttributes(
    request: DescribeAccountAttributesRequest
  ): RdsIO[DescribeAccountAttributesResponse] =
    FF.liftF(DescribeAccountAttributesOp(request))

  def describeCertificates(
    request: DescribeCertificatesRequest
  ): RdsIO[DescribeCertificatesResponse] =
    FF.liftF(DescribeCertificatesOp(request))

  def describeCustomAvailabilityZones(
    request: DescribeCustomAvailabilityZonesRequest
  ): RdsIO[DescribeCustomAvailabilityZonesResponse] =
    FF.liftF(DescribeCustomAvailabilityZonesOp(request))

  def describeDBClusterBacktracks(
    request: DescribeDbClusterBacktracksRequest
  ): RdsIO[DescribeDbClusterBacktracksResponse] =
    FF.liftF(DescribeDBClusterBacktracksOp(request))

  def describeDBClusterEndpoints(
    request: DescribeDbClusterEndpointsRequest
  ): RdsIO[DescribeDbClusterEndpointsResponse] =
    FF.liftF(DescribeDBClusterEndpointsOp(request))

  def describeDBClusterParameterGroups(
    request: DescribeDbClusterParameterGroupsRequest
  ): RdsIO[DescribeDbClusterParameterGroupsResponse] =
    FF.liftF(DescribeDBClusterParameterGroupsOp(request))

  def describeDBClusterParameters(
    request: DescribeDbClusterParametersRequest
  ): RdsIO[DescribeDbClusterParametersResponse] =
    FF.liftF(DescribeDBClusterParametersOp(request))

  def describeDBClusterSnapshotAttributes(
    request: DescribeDbClusterSnapshotAttributesRequest
  ): RdsIO[DescribeDbClusterSnapshotAttributesResponse] =
    FF.liftF(DescribeDBClusterSnapshotAttributesOp(request))

  def describeDBClusterSnapshots(
    request: DescribeDbClusterSnapshotsRequest
  ): RdsIO[DescribeDbClusterSnapshotsResponse] =
    FF.liftF(DescribeDBClusterSnapshotsOp(request))

  def describeDBClusters(
    request: DescribeDbClustersRequest
  ): RdsIO[DescribeDbClustersResponse] =
    FF.liftF(DescribeDBClustersOp(request))

  def describeDBEngineVersions(
    request: DescribeDbEngineVersionsRequest
  ): RdsIO[DescribeDbEngineVersionsResponse] =
    FF.liftF(DescribeDBEngineVersionsOp(request))

  def describeDBInstanceAutomatedBackups(
    request: DescribeDbInstanceAutomatedBackupsRequest
  ): RdsIO[DescribeDbInstanceAutomatedBackupsResponse] =
    FF.liftF(DescribeDBInstanceAutomatedBackupsOp(request))

  def describeDBInstances(
    request: DescribeDbInstancesRequest
  ): RdsIO[DescribeDbInstancesResponse] =
    FF.liftF(DescribeDBInstancesOp(request))

  def describeDBLogFiles(
    request: DescribeDbLogFilesRequest
  ): RdsIO[DescribeDbLogFilesResponse] =
    FF.liftF(DescribeDBLogFilesOp(request))

  def describeDBParameterGroups(
    request: DescribeDbParameterGroupsRequest
  ): RdsIO[DescribeDbParameterGroupsResponse] =
    FF.liftF(DescribeDBParameterGroupsOp(request))

  def describeDBParameters(
    request: DescribeDbParametersRequest
  ): RdsIO[DescribeDbParametersResponse] =
    FF.liftF(DescribeDBParametersOp(request))

  def describeDBProxies(
    request: DescribeDbProxiesRequest
  ): RdsIO[DescribeDbProxiesResponse] =
    FF.liftF(DescribeDBProxiesOp(request))

  def describeDBProxyEndpoints(
    request: DescribeDbProxyEndpointsRequest
  ): RdsIO[DescribeDbProxyEndpointsResponse] =
    FF.liftF(DescribeDBProxyEndpointsOp(request))

  def describeDBProxyTargetGroups(
    request: DescribeDbProxyTargetGroupsRequest
  ): RdsIO[DescribeDbProxyTargetGroupsResponse] =
    FF.liftF(DescribeDBProxyTargetGroupsOp(request))

  def describeDBProxyTargets(
    request: DescribeDbProxyTargetsRequest
  ): RdsIO[DescribeDbProxyTargetsResponse] =
    FF.liftF(DescribeDBProxyTargetsOp(request))

  def describeDBSecurityGroups(
    request: DescribeDbSecurityGroupsRequest
  ): RdsIO[DescribeDbSecurityGroupsResponse] =
    FF.liftF(DescribeDBSecurityGroupsOp(request))

  def describeDBSnapshotAttributes(
    request: DescribeDbSnapshotAttributesRequest
  ): RdsIO[DescribeDbSnapshotAttributesResponse] =
    FF.liftF(DescribeDBSnapshotAttributesOp(request))

  def describeDBSnapshots(
    request: DescribeDbSnapshotsRequest
  ): RdsIO[DescribeDbSnapshotsResponse] =
    FF.liftF(DescribeDBSnapshotsOp(request))

  def describeDBSubnetGroups(
    request: DescribeDbSubnetGroupsRequest
  ): RdsIO[DescribeDbSubnetGroupsResponse] =
    FF.liftF(DescribeDBSubnetGroupsOp(request))

  def describeEngineDefaultClusterParameters(
    request: DescribeEngineDefaultClusterParametersRequest
  ): RdsIO[DescribeEngineDefaultClusterParametersResponse] =
    FF.liftF(DescribeEngineDefaultClusterParametersOp(request))

  def describeEngineDefaultParameters(
    request: DescribeEngineDefaultParametersRequest
  ): RdsIO[DescribeEngineDefaultParametersResponse] =
    FF.liftF(DescribeEngineDefaultParametersOp(request))

  def describeEventCategories(
    request: DescribeEventCategoriesRequest
  ): RdsIO[DescribeEventCategoriesResponse] =
    FF.liftF(DescribeEventCategoriesOp(request))

  def describeEventSubscriptions(
    request: DescribeEventSubscriptionsRequest
  ): RdsIO[DescribeEventSubscriptionsResponse] =
    FF.liftF(DescribeEventSubscriptionsOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): RdsIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeExportTasks(
    request: DescribeExportTasksRequest
  ): RdsIO[DescribeExportTasksResponse] =
    FF.liftF(DescribeExportTasksOp(request))

  def describeGlobalClusters(
    request: DescribeGlobalClustersRequest
  ): RdsIO[DescribeGlobalClustersResponse] =
    FF.liftF(DescribeGlobalClustersOp(request))

  def describeInstallationMedia(
    request: DescribeInstallationMediaRequest
  ): RdsIO[DescribeInstallationMediaResponse] =
    FF.liftF(DescribeInstallationMediaOp(request))

  def describeOptionGroupOptions(
    request: DescribeOptionGroupOptionsRequest
  ): RdsIO[DescribeOptionGroupOptionsResponse] =
    FF.liftF(DescribeOptionGroupOptionsOp(request))

  def describeOptionGroups(
    request: DescribeOptionGroupsRequest
  ): RdsIO[DescribeOptionGroupsResponse] =
    FF.liftF(DescribeOptionGroupsOp(request))

  def describeOrderableDBInstanceOptions(
    request: DescribeOrderableDbInstanceOptionsRequest
  ): RdsIO[DescribeOrderableDbInstanceOptionsResponse] =
    FF.liftF(DescribeOrderableDBInstanceOptionsOp(request))

  def describePendingMaintenanceActions(
    request: DescribePendingMaintenanceActionsRequest
  ): RdsIO[DescribePendingMaintenanceActionsResponse] =
    FF.liftF(DescribePendingMaintenanceActionsOp(request))

  def describeReservedDBInstances(
    request: DescribeReservedDbInstancesRequest
  ): RdsIO[DescribeReservedDbInstancesResponse] =
    FF.liftF(DescribeReservedDBInstancesOp(request))

  def describeReservedDBInstancesOfferings(
    request: DescribeReservedDbInstancesOfferingsRequest
  ): RdsIO[DescribeReservedDbInstancesOfferingsResponse] =
    FF.liftF(DescribeReservedDBInstancesOfferingsOp(request))

  def describeSourceRegions(
    request: DescribeSourceRegionsRequest
  ): RdsIO[DescribeSourceRegionsResponse] =
    FF.liftF(DescribeSourceRegionsOp(request))

  def describeValidDBInstanceModifications(
    request: DescribeValidDbInstanceModificationsRequest
  ): RdsIO[DescribeValidDbInstanceModificationsResponse] =
    FF.liftF(DescribeValidDBInstanceModificationsOp(request))

  def downloadDBLogFilePortion(
    request: DownloadDbLogFilePortionRequest
  ): RdsIO[DownloadDbLogFilePortionResponse] =
    FF.liftF(DownloadDBLogFilePortionOp(request))

  def failoverDBCluster(
    request: FailoverDbClusterRequest
  ): RdsIO[FailoverDbClusterResponse] =
    FF.liftF(FailoverDBClusterOp(request))

  def failoverGlobalCluster(
    request: FailoverGlobalClusterRequest
  ): RdsIO[FailoverGlobalClusterResponse] =
    FF.liftF(FailoverGlobalClusterOp(request))

  def importInstallationMedia(
    request: ImportInstallationMediaRequest
  ): RdsIO[ImportInstallationMediaResponse] =
    FF.liftF(ImportInstallationMediaOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): RdsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyCertificates(
    request: ModifyCertificatesRequest
  ): RdsIO[ModifyCertificatesResponse] =
    FF.liftF(ModifyCertificatesOp(request))

  def modifyCurrentDBClusterCapacity(
    request: ModifyCurrentDbClusterCapacityRequest
  ): RdsIO[ModifyCurrentDbClusterCapacityResponse] =
    FF.liftF(ModifyCurrentDBClusterCapacityOp(request))

  def modifyDBCluster(
    request: ModifyDbClusterRequest
  ): RdsIO[ModifyDbClusterResponse] =
    FF.liftF(ModifyDBClusterOp(request))

  def modifyDBClusterEndpoint(
    request: ModifyDbClusterEndpointRequest
  ): RdsIO[ModifyDbClusterEndpointResponse] =
    FF.liftF(ModifyDBClusterEndpointOp(request))

  def modifyDBClusterParameterGroup(
    request: ModifyDbClusterParameterGroupRequest
  ): RdsIO[ModifyDbClusterParameterGroupResponse] =
    FF.liftF(ModifyDBClusterParameterGroupOp(request))

  def modifyDBClusterSnapshotAttribute(
    request: ModifyDbClusterSnapshotAttributeRequest
  ): RdsIO[ModifyDbClusterSnapshotAttributeResponse] =
    FF.liftF(ModifyDBClusterSnapshotAttributeOp(request))

  def modifyDBInstance(
    request: ModifyDbInstanceRequest
  ): RdsIO[ModifyDbInstanceResponse] =
    FF.liftF(ModifyDBInstanceOp(request))

  def modifyDBParameterGroup(
    request: ModifyDbParameterGroupRequest
  ): RdsIO[ModifyDbParameterGroupResponse] =
    FF.liftF(ModifyDBParameterGroupOp(request))

  def modifyDBProxy(
    request: ModifyDbProxyRequest
  ): RdsIO[ModifyDbProxyResponse] =
    FF.liftF(ModifyDBProxyOp(request))

  def modifyDBProxyEndpoint(
    request: ModifyDbProxyEndpointRequest
  ): RdsIO[ModifyDbProxyEndpointResponse] =
    FF.liftF(ModifyDBProxyEndpointOp(request))

  def modifyDBProxyTargetGroup(
    request: ModifyDbProxyTargetGroupRequest
  ): RdsIO[ModifyDbProxyTargetGroupResponse] =
    FF.liftF(ModifyDBProxyTargetGroupOp(request))

  def modifyDBSnapshot(
    request: ModifyDbSnapshotRequest
  ): RdsIO[ModifyDbSnapshotResponse] =
    FF.liftF(ModifyDBSnapshotOp(request))

  def modifyDBSnapshotAttribute(
    request: ModifyDbSnapshotAttributeRequest
  ): RdsIO[ModifyDbSnapshotAttributeResponse] =
    FF.liftF(ModifyDBSnapshotAttributeOp(request))

  def modifyDBSubnetGroup(
    request: ModifyDbSubnetGroupRequest
  ): RdsIO[ModifyDbSubnetGroupResponse] =
    FF.liftF(ModifyDBSubnetGroupOp(request))

  def modifyEventSubscription(
    request: ModifyEventSubscriptionRequest
  ): RdsIO[ModifyEventSubscriptionResponse] =
    FF.liftF(ModifyEventSubscriptionOp(request))

  def modifyGlobalCluster(
    request: ModifyGlobalClusterRequest
  ): RdsIO[ModifyGlobalClusterResponse] =
    FF.liftF(ModifyGlobalClusterOp(request))

  def modifyOptionGroup(
    request: ModifyOptionGroupRequest
  ): RdsIO[ModifyOptionGroupResponse] =
    FF.liftF(ModifyOptionGroupOp(request))

  def promoteReadReplica(
    request: PromoteReadReplicaRequest
  ): RdsIO[PromoteReadReplicaResponse] =
    FF.liftF(PromoteReadReplicaOp(request))

  def promoteReadReplicaDBCluster(
    request: PromoteReadReplicaDbClusterRequest
  ): RdsIO[PromoteReadReplicaDbClusterResponse] =
    FF.liftF(PromoteReadReplicaDBClusterOp(request))

  def purchaseReservedDBInstancesOffering(
    request: PurchaseReservedDbInstancesOfferingRequest
  ): RdsIO[PurchaseReservedDbInstancesOfferingResponse] =
    FF.liftF(PurchaseReservedDBInstancesOfferingOp(request))

  def rebootDBInstance(
    request: RebootDbInstanceRequest
  ): RdsIO[RebootDbInstanceResponse] =
    FF.liftF(RebootDBInstanceOp(request))

  def registerDBProxyTargets(
    request: RegisterDbProxyTargetsRequest
  ): RdsIO[RegisterDbProxyTargetsResponse] =
    FF.liftF(RegisterDBProxyTargetsOp(request))

  def removeFromGlobalCluster(
    request: RemoveFromGlobalClusterRequest
  ): RdsIO[RemoveFromGlobalClusterResponse] =
    FF.liftF(RemoveFromGlobalClusterOp(request))

  def removeRoleFromDBCluster(
    request: RemoveRoleFromDbClusterRequest
  ): RdsIO[RemoveRoleFromDbClusterResponse] =
    FF.liftF(RemoveRoleFromDBClusterOp(request))

  def removeRoleFromDBInstance(
    request: RemoveRoleFromDbInstanceRequest
  ): RdsIO[RemoveRoleFromDbInstanceResponse] =
    FF.liftF(RemoveRoleFromDBInstanceOp(request))

  def removeSourceIdentifierFromSubscription(
    request: RemoveSourceIdentifierFromSubscriptionRequest
  ): RdsIO[RemoveSourceIdentifierFromSubscriptionResponse] =
    FF.liftF(RemoveSourceIdentifierFromSubscriptionOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): RdsIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def resetDBClusterParameterGroup(
    request: ResetDbClusterParameterGroupRequest
  ): RdsIO[ResetDbClusterParameterGroupResponse] =
    FF.liftF(ResetDBClusterParameterGroupOp(request))

  def resetDBParameterGroup(
    request: ResetDbParameterGroupRequest
  ): RdsIO[ResetDbParameterGroupResponse] =
    FF.liftF(ResetDBParameterGroupOp(request))

  def restoreDBClusterFromS3(
    request: RestoreDbClusterFromS3Request
  ): RdsIO[RestoreDbClusterFromS3Response] =
    FF.liftF(RestoreDBClusterFromS3Op(request))

  def restoreDBClusterFromSnapshot(
    request: RestoreDbClusterFromSnapshotRequest
  ): RdsIO[RestoreDbClusterFromSnapshotResponse] =
    FF.liftF(RestoreDBClusterFromSnapshotOp(request))

  def restoreDBClusterToPointInTime(
    request: RestoreDbClusterToPointInTimeRequest
  ): RdsIO[RestoreDbClusterToPointInTimeResponse] =
    FF.liftF(RestoreDBClusterToPointInTimeOp(request))

  def restoreDBInstanceFromDBSnapshot(
    request: RestoreDbInstanceFromDbSnapshotRequest
  ): RdsIO[RestoreDbInstanceFromDbSnapshotResponse] =
    FF.liftF(RestoreDBInstanceFromDBSnapshotOp(request))

  def restoreDBInstanceFromS3(
    request: RestoreDbInstanceFromS3Request
  ): RdsIO[RestoreDbInstanceFromS3Response] =
    FF.liftF(RestoreDBInstanceFromS3Op(request))

  def restoreDBInstanceToPointInTime(
    request: RestoreDbInstanceToPointInTimeRequest
  ): RdsIO[RestoreDbInstanceToPointInTimeResponse] =
    FF.liftF(RestoreDBInstanceToPointInTimeOp(request))

  def revokeDBSecurityGroupIngress(
    request: RevokeDbSecurityGroupIngressRequest
  ): RdsIO[RevokeDbSecurityGroupIngressResponse] =
    FF.liftF(RevokeDBSecurityGroupIngressOp(request))

  def startActivityStream(
    request: StartActivityStreamRequest
  ): RdsIO[StartActivityStreamResponse] =
    FF.liftF(StartActivityStreamOp(request))

  def startDBCluster(
    request: StartDbClusterRequest
  ): RdsIO[StartDbClusterResponse] =
    FF.liftF(StartDBClusterOp(request))

  def startDBInstance(
    request: StartDbInstanceRequest
  ): RdsIO[StartDbInstanceResponse] =
    FF.liftF(StartDBInstanceOp(request))

  def startDBInstanceAutomatedBackupsReplication(
    request: StartDbInstanceAutomatedBackupsReplicationRequest
  ): RdsIO[StartDbInstanceAutomatedBackupsReplicationResponse] =
    FF.liftF(StartDBInstanceAutomatedBackupsReplicationOp(request))

  def startExportTask(
    request: StartExportTaskRequest
  ): RdsIO[StartExportTaskResponse] =
    FF.liftF(StartExportTaskOp(request))

  def stopActivityStream(
    request: StopActivityStreamRequest
  ): RdsIO[StopActivityStreamResponse] =
    FF.liftF(StopActivityStreamOp(request))

  def stopDBCluster(
    request: StopDbClusterRequest
  ): RdsIO[StopDbClusterResponse] =
    FF.liftF(StopDBClusterOp(request))

  def stopDBInstance(
    request: StopDbInstanceRequest
  ): RdsIO[StopDbInstanceResponse] =
    FF.liftF(StopDBInstanceOp(request))

  def stopDBInstanceAutomatedBackupsReplication(
    request: StopDbInstanceAutomatedBackupsReplicationRequest
  ): RdsIO[StopDbInstanceAutomatedBackupsReplicationResponse] =
    FF.liftF(StopDBInstanceAutomatedBackupsReplicationOp(request))
}
