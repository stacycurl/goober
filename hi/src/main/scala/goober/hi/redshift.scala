package goober.hi

import goober.free.redshift.RedshiftIO
import software.amazon.awssdk.services.redshift.model._


object redshift {
  import goober.free.{redshift ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AcceptReservedNodeExchangeRequest
    // AddPartnerRequest
    // AuthorizeClusterSecurityGroupIngressRequest
    // AuthorizeEndpointAccessRequest
    // AuthorizeSnapshotAccessRequest
    // BatchDeleteClusterSnapshotsRequest
    // BatchModifyClusterSnapshotsRequest
    // CancelResizeRequest
    // CopyClusterSnapshotRequest
    // CreateClusterParameterGroupRequest
    // CreateClusterRequest
    // CreateClusterSecurityGroupRequest
    // CreateClusterSnapshotRequest
    // CreateClusterSubnetGroupRequest
    // CreateEndpointAccessRequest
    // CreateEventSubscriptionRequest
    // CreateHsmClientCertificateRequest
    // CreateHsmConfigurationRequest
    // CreateScheduledActionRequest
    // CreateSnapshotCopyGrantRequest
    // CreateSnapshotScheduleRequest
    // CreateTagsRequest
    // CreateUsageLimitRequest
    // DeleteClusterParameterGroupRequest
    // DeleteClusterRequest
    // DeleteClusterSecurityGroupRequest
    // DeleteClusterSnapshotRequest
    // DeleteClusterSubnetGroupRequest
    // DeleteEndpointAccessRequest
    // DeleteEventSubscriptionRequest
    // DeleteHsmClientCertificateRequest
    // DeleteHsmConfigurationRequest
    // DeletePartnerRequest
    // DeleteScheduledActionRequest
    // DeleteSnapshotCopyGrantRequest
    // DeleteSnapshotScheduleRequest
    // DeleteTagsRequest
    // DeleteUsageLimitRequest
    // DescribeAccountAttributesRequest
    // DescribeClusterDbRevisionsRequest
    // DescribeClusterParameterGroupsRequest
    // DescribeClusterParametersRequest
    // DescribeClusterSecurityGroupsRequest
    // DescribeClusterSnapshotsRequest
    // DescribeClusterSubnetGroupsRequest
    // DescribeClusterTracksRequest
    // DescribeClusterVersionsRequest
    // DescribeClustersRequest
    // DescribeDefaultClusterParametersRequest
    // DescribeEndpointAccessRequest
    // DescribeEndpointAuthorizationRequest
    // DescribeEventCategoriesRequest
    // DescribeEventSubscriptionsRequest
    // DescribeEventsRequest
    // DescribeHsmClientCertificatesRequest
    // DescribeHsmConfigurationsRequest
    // DescribeLoggingStatusRequest
    // DescribeNodeConfigurationOptionsRequest
    // DescribeOrderableClusterOptionsRequest
    // DescribePartnersRequest
    // DescribeReservedNodeOfferingsRequest
    // DescribeReservedNodesRequest
    // DescribeResizeRequest
    // DescribeScheduledActionsRequest
    // DescribeSnapshotCopyGrantsRequest
    // DescribeSnapshotSchedulesRequest
    // DescribeStorageRequest
    // DescribeTableRestoreStatusRequest
    // DescribeTagsRequest
    // DescribeUsageLimitsRequest
    // DisableLoggingRequest
    // DisableSnapshotCopyRequest
    // EnableLoggingRequest
    // EnableSnapshotCopyRequest
    // GetClusterCredentialsRequest
    // GetReservedNodeExchangeOfferingsRequest
    // ModifyAquaConfigurationRequest
    // ModifyClusterDbRevisionRequest
    // ModifyClusterIamRolesRequest
    // ModifyClusterMaintenanceRequest
    // ModifyClusterParameterGroupRequest
    // ModifyClusterRequest
    // ModifyClusterSnapshotRequest
    // ModifyClusterSnapshotScheduleRequest
    // ModifyClusterSubnetGroupRequest
    // ModifyEndpointAccessRequest
    // ModifyEventSubscriptionRequest
    // ModifyScheduledActionRequest
    // ModifySnapshotCopyRetentionPeriodRequest
    // ModifySnapshotScheduleRequest
    // ModifyUsageLimitRequest
    // PauseClusterRequest
    // PurchaseReservedNodeOfferingRequest
    // RebootClusterRequest
    // ResetClusterParameterGroupRequest
    // ResizeClusterRequest
    // RestoreFromClusterSnapshotRequest
    // RestoreTableFromClusterSnapshotRequest
    // ResumeClusterRequest
    // RevokeClusterSecurityGroupIngressRequest
    // RevokeEndpointAccessRequest
    // RevokeSnapshotAccessRequest
    // RotateEncryptionKeyRequest
    // UpdatePartnerStatusRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
