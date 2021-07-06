package goober.hi

import goober.free.rds.RdsIO
import software.amazon.awssdk.services.rds.model._


object rds {
  import goober.free.{rds ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AddRoleToDbClusterRequest
    // AddRoleToDbInstanceRequest
    // AddSourceIdentifierToSubscriptionRequest
    // AddTagsToResourceRequest
    // ApplyPendingMaintenanceActionRequest
    // AuthorizeDbSecurityGroupIngressRequest
    // BacktrackDbClusterRequest
    // CancelExportTaskRequest
    // CopyDbClusterParameterGroupRequest
    // CopyDbClusterSnapshotRequest
    // CopyDbParameterGroupRequest
    // CopyDbSnapshotRequest
    // CopyOptionGroupRequest
    // CreateCustomAvailabilityZoneRequest
    // CreateDbClusterEndpointRequest
    // CreateDbClusterParameterGroupRequest
    // CreateDbClusterRequest
    // CreateDbClusterSnapshotRequest
    // CreateDbInstanceReadReplicaRequest
    // CreateDbInstanceRequest
    // CreateDbParameterGroupRequest
    // CreateDbProxyEndpointRequest
    // CreateDbProxyRequest
    // CreateDbSecurityGroupRequest
    // CreateDbSnapshotRequest
    // CreateDbSubnetGroupRequest
    // CreateEventSubscriptionRequest
    // CreateGlobalClusterRequest
    // CreateOptionGroupRequest
    // DeleteCustomAvailabilityZoneRequest
    // DeleteDbClusterEndpointRequest
    // DeleteDbClusterParameterGroupRequest
    // DeleteDbClusterRequest
    // DeleteDbClusterSnapshotRequest
    // DeleteDbInstanceAutomatedBackupRequest
    // DeleteDbInstanceRequest
    // DeleteDbParameterGroupRequest
    // DeleteDbProxyEndpointRequest
    // DeleteDbProxyRequest
    // DeleteDbSecurityGroupRequest
    // DeleteDbSnapshotRequest
    // DeleteDbSubnetGroupRequest
    // DeleteEventSubscriptionRequest
    // DeleteGlobalClusterRequest
    // DeleteInstallationMediaRequest
    // DeleteOptionGroupRequest
    // DeregisterDbProxyTargetsRequest
    // DescribeAccountAttributesRequest
    // DescribeCertificatesRequest
    // DescribeCustomAvailabilityZonesRequest
    // DescribeDbClusterBacktracksRequest
    // DescribeDbClusterEndpointsRequest
    // DescribeDbClusterParameterGroupsRequest
    // DescribeDbClusterParametersRequest
    // DescribeDbClusterSnapshotAttributesRequest
    // DescribeDbClusterSnapshotsRequest
    // DescribeDbClustersRequest
    // DescribeDbEngineVersionsRequest
    // DescribeDbInstanceAutomatedBackupsRequest
    // DescribeDbInstancesRequest
    // DescribeDbLogFilesRequest
    // DescribeDbParameterGroupsRequest
    // DescribeDbParametersRequest
    // DescribeDbProxiesRequest
    // DescribeDbProxyEndpointsRequest
    // DescribeDbProxyTargetGroupsRequest
    // DescribeDbProxyTargetsRequest
    // DescribeDbSecurityGroupsRequest
    // DescribeDbSnapshotAttributesRequest
    // DescribeDbSnapshotsRequest
    // DescribeDbSubnetGroupsRequest
    // DescribeEngineDefaultClusterParametersRequest
    // DescribeEngineDefaultParametersRequest
    // DescribeEventCategoriesRequest
    // DescribeEventSubscriptionsRequest
    // DescribeEventsRequest
    // DescribeExportTasksRequest
    // DescribeGlobalClustersRequest
    // DescribeInstallationMediaRequest
    // DescribeOptionGroupOptionsRequest
    // DescribeOptionGroupsRequest
    // DescribeOrderableDbInstanceOptionsRequest
    // DescribePendingMaintenanceActionsRequest
    // DescribeReservedDbInstancesOfferingsRequest
    // DescribeReservedDbInstancesRequest
    // DescribeSourceRegionsRequest
    // DescribeValidDbInstanceModificationsRequest
    // DownloadDbLogFilePortionRequest
    // FailoverDbClusterRequest
    // FailoverGlobalClusterRequest
    // ImportInstallationMediaRequest
    // ListTagsForResourceRequest
    // ModifyCertificatesRequest
    // ModifyCurrentDbClusterCapacityRequest
    // ModifyDbClusterEndpointRequest
    // ModifyDbClusterParameterGroupRequest
    // ModifyDbClusterRequest
    // ModifyDbClusterSnapshotAttributeRequest
    // ModifyDbInstanceRequest
    // ModifyDbParameterGroupRequest
    // ModifyDbProxyEndpointRequest
    // ModifyDbProxyRequest
    // ModifyDbProxyTargetGroupRequest
    // ModifyDbSnapshotAttributeRequest
    // ModifyDbSnapshotRequest
    // ModifyDbSubnetGroupRequest
    // ModifyEventSubscriptionRequest
    // ModifyGlobalClusterRequest
    // ModifyOptionGroupRequest
    // PromoteReadReplicaDbClusterRequest
    // PromoteReadReplicaRequest
    // PurchaseReservedDbInstancesOfferingRequest
    // RebootDbInstanceRequest
    // RegisterDbProxyTargetsRequest
    // RemoveFromGlobalClusterRequest
    // RemoveRoleFromDbClusterRequest
    // RemoveRoleFromDbInstanceRequest
    // RemoveSourceIdentifierFromSubscriptionRequest
    // RemoveTagsFromResourceRequest
    // ResetDbClusterParameterGroupRequest
    // ResetDbParameterGroupRequest
    // RestoreDbClusterFromS3Request
    // RestoreDbClusterFromSnapshotRequest
    // RestoreDbClusterToPointInTimeRequest
    // RestoreDbInstanceFromDbSnapshotRequest
    // RestoreDbInstanceFromS3Request
    // RestoreDbInstanceToPointInTimeRequest
    // RevokeDbSecurityGroupIngressRequest
    // StartActivityStreamRequest
    // StartDbClusterRequest
    // StartDbInstanceAutomatedBackupsReplicationRequest
    // StartDbInstanceRequest
    // StartExportTaskRequest
    // StopActivityStreamRequest
    // StopDbClusterRequest
    // StopDbInstanceAutomatedBackupsReplicationRequest
    // StopDbInstanceRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}