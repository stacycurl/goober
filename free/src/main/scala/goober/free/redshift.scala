package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.redshift.RedshiftClient
import software.amazon.awssdk.services.redshift.model._


object redshift { module =>

  // Free monad over RedshiftOp
  type RedshiftIO[A] = FF[RedshiftOp, A]

  sealed trait RedshiftOp[A] {
    def visit[F[_]](visitor: RedshiftOp.Visitor[F]): F[A]
  }

  object RedshiftOp {
    // Given a RedshiftClient we can embed a RedshiftIO program in any algebra that understands embedding.
    implicit val RedshiftOpEmbeddable: Embeddable[RedshiftOp, RedshiftClient] = new Embeddable[RedshiftOp, RedshiftClient] {
      def embed[A](client: RedshiftClient, io: RedshiftIO[A]): Embedded[A] = Embedded.Redshift(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends RedshiftOp.Visitor[Kleisli[M, RedshiftClient, *]] {
        def acceptReservedNodeExchange(
          request: AcceptReservedNodeExchangeRequest
        ): Kleisli[M, RedshiftClient, AcceptReservedNodeExchangeResponse] =
          primitive(_.acceptReservedNodeExchange(request))

        def addPartner(
          request: AddPartnerRequest
        ): Kleisli[M, RedshiftClient, AddPartnerResponse] =
          primitive(_.addPartner(request))

        def authorizeClusterSecurityGroupIngress(
          request: AuthorizeClusterSecurityGroupIngressRequest
        ): Kleisli[M, RedshiftClient, AuthorizeClusterSecurityGroupIngressResponse] =
          primitive(_.authorizeClusterSecurityGroupIngress(request))

        def authorizeEndpointAccess(
          request: AuthorizeEndpointAccessRequest
        ): Kleisli[M, RedshiftClient, AuthorizeEndpointAccessResponse] =
          primitive(_.authorizeEndpointAccess(request))

        def authorizeSnapshotAccess(
          request: AuthorizeSnapshotAccessRequest
        ): Kleisli[M, RedshiftClient, AuthorizeSnapshotAccessResponse] =
          primitive(_.authorizeSnapshotAccess(request))

        def batchDeleteClusterSnapshots(
          request: BatchDeleteClusterSnapshotsRequest
        ): Kleisli[M, RedshiftClient, BatchDeleteClusterSnapshotsResponse] =
          primitive(_.batchDeleteClusterSnapshots(request))

        def batchModifyClusterSnapshots(
          request: BatchModifyClusterSnapshotsRequest
        ): Kleisli[M, RedshiftClient, BatchModifyClusterSnapshotsResponse] =
          primitive(_.batchModifyClusterSnapshots(request))

        def cancelResize(
          request: CancelResizeRequest
        ): Kleisli[M, RedshiftClient, CancelResizeResponse] =
          primitive(_.cancelResize(request))

        def copyClusterSnapshot(
          request: CopyClusterSnapshotRequest
        ): Kleisli[M, RedshiftClient, CopyClusterSnapshotResponse] =
          primitive(_.copyClusterSnapshot(request))

        def createCluster(
          request: CreateClusterRequest
        ): Kleisli[M, RedshiftClient, CreateClusterResponse] =
          primitive(_.createCluster(request))

        def createClusterParameterGroup(
          request: CreateClusterParameterGroupRequest
        ): Kleisli[M, RedshiftClient, CreateClusterParameterGroupResponse] =
          primitive(_.createClusterParameterGroup(request))

        def createClusterSecurityGroup(
          request: CreateClusterSecurityGroupRequest
        ): Kleisli[M, RedshiftClient, CreateClusterSecurityGroupResponse] =
          primitive(_.createClusterSecurityGroup(request))

        def createClusterSnapshot(
          request: CreateClusterSnapshotRequest
        ): Kleisli[M, RedshiftClient, CreateClusterSnapshotResponse] =
          primitive(_.createClusterSnapshot(request))

        def createClusterSubnetGroup(
          request: CreateClusterSubnetGroupRequest
        ): Kleisli[M, RedshiftClient, CreateClusterSubnetGroupResponse] =
          primitive(_.createClusterSubnetGroup(request))

        def createEndpointAccess(
          request: CreateEndpointAccessRequest
        ): Kleisli[M, RedshiftClient, CreateEndpointAccessResponse] =
          primitive(_.createEndpointAccess(request))

        def createEventSubscription(
          request: CreateEventSubscriptionRequest
        ): Kleisli[M, RedshiftClient, CreateEventSubscriptionResponse] =
          primitive(_.createEventSubscription(request))

        def createHsmClientCertificate(
          request: CreateHsmClientCertificateRequest
        ): Kleisli[M, RedshiftClient, CreateHsmClientCertificateResponse] =
          primitive(_.createHsmClientCertificate(request))

        def createHsmConfiguration(
          request: CreateHsmConfigurationRequest
        ): Kleisli[M, RedshiftClient, CreateHsmConfigurationResponse] =
          primitive(_.createHsmConfiguration(request))

        def createScheduledAction(
          request: CreateScheduledActionRequest
        ): Kleisli[M, RedshiftClient, CreateScheduledActionResponse] =
          primitive(_.createScheduledAction(request))

        def createSnapshotCopyGrant(
          request: CreateSnapshotCopyGrantRequest
        ): Kleisli[M, RedshiftClient, CreateSnapshotCopyGrantResponse] =
          primitive(_.createSnapshotCopyGrant(request))

        def createSnapshotSchedule(
          request: CreateSnapshotScheduleRequest
        ): Kleisli[M, RedshiftClient, CreateSnapshotScheduleResponse] =
          primitive(_.createSnapshotSchedule(request))

        def createTags(
          request: CreateTagsRequest
        ): Kleisli[M, RedshiftClient, CreateTagsResponse] =
          primitive(_.createTags(request))

        def createUsageLimit(
          request: CreateUsageLimitRequest
        ): Kleisli[M, RedshiftClient, CreateUsageLimitResponse] =
          primitive(_.createUsageLimit(request))

        def deleteCluster(
          request: DeleteClusterRequest
        ): Kleisli[M, RedshiftClient, DeleteClusterResponse] =
          primitive(_.deleteCluster(request))

        def deleteClusterParameterGroup(
          request: DeleteClusterParameterGroupRequest
        ): Kleisli[M, RedshiftClient, DeleteClusterParameterGroupResponse] =
          primitive(_.deleteClusterParameterGroup(request))

        def deleteClusterSecurityGroup(
          request: DeleteClusterSecurityGroupRequest
        ): Kleisli[M, RedshiftClient, DeleteClusterSecurityGroupResponse] =
          primitive(_.deleteClusterSecurityGroup(request))

        def deleteClusterSnapshot(
          request: DeleteClusterSnapshotRequest
        ): Kleisli[M, RedshiftClient, DeleteClusterSnapshotResponse] =
          primitive(_.deleteClusterSnapshot(request))

        def deleteClusterSubnetGroup(
          request: DeleteClusterSubnetGroupRequest
        ): Kleisli[M, RedshiftClient, DeleteClusterSubnetGroupResponse] =
          primitive(_.deleteClusterSubnetGroup(request))

        def deleteEndpointAccess(
          request: DeleteEndpointAccessRequest
        ): Kleisli[M, RedshiftClient, DeleteEndpointAccessResponse] =
          primitive(_.deleteEndpointAccess(request))

        def deleteEventSubscription(
          request: DeleteEventSubscriptionRequest
        ): Kleisli[M, RedshiftClient, DeleteEventSubscriptionResponse] =
          primitive(_.deleteEventSubscription(request))

        def deleteHsmClientCertificate(
          request: DeleteHsmClientCertificateRequest
        ): Kleisli[M, RedshiftClient, DeleteHsmClientCertificateResponse] =
          primitive(_.deleteHsmClientCertificate(request))

        def deleteHsmConfiguration(
          request: DeleteHsmConfigurationRequest
        ): Kleisli[M, RedshiftClient, DeleteHsmConfigurationResponse] =
          primitive(_.deleteHsmConfiguration(request))

        def deletePartner(
          request: DeletePartnerRequest
        ): Kleisli[M, RedshiftClient, DeletePartnerResponse] =
          primitive(_.deletePartner(request))

        def deleteScheduledAction(
          request: DeleteScheduledActionRequest
        ): Kleisli[M, RedshiftClient, DeleteScheduledActionResponse] =
          primitive(_.deleteScheduledAction(request))

        def deleteSnapshotCopyGrant(
          request: DeleteSnapshotCopyGrantRequest
        ): Kleisli[M, RedshiftClient, DeleteSnapshotCopyGrantResponse] =
          primitive(_.deleteSnapshotCopyGrant(request))

        def deleteSnapshotSchedule(
          request: DeleteSnapshotScheduleRequest
        ): Kleisli[M, RedshiftClient, DeleteSnapshotScheduleResponse] =
          primitive(_.deleteSnapshotSchedule(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, RedshiftClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def deleteUsageLimit(
          request: DeleteUsageLimitRequest
        ): Kleisli[M, RedshiftClient, DeleteUsageLimitResponse] =
          primitive(_.deleteUsageLimit(request))

        def describeAccountAttributes(
          request: DescribeAccountAttributesRequest
        ): Kleisli[M, RedshiftClient, DescribeAccountAttributesResponse] =
          primitive(_.describeAccountAttributes(request))

        def describeClusterDbRevisions(
          request: DescribeClusterDbRevisionsRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterDbRevisionsResponse] =
          primitive(_.describeClusterDbRevisions(request))

        def describeClusterParameterGroups(
          request: DescribeClusterParameterGroupsRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterParameterGroupsResponse] =
          primitive(_.describeClusterParameterGroups(request))

        def describeClusterParameters(
          request: DescribeClusterParametersRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterParametersResponse] =
          primitive(_.describeClusterParameters(request))

        def describeClusterSecurityGroups(
          request: DescribeClusterSecurityGroupsRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterSecurityGroupsResponse] =
          primitive(_.describeClusterSecurityGroups(request))

        def describeClusterSnapshots(
          request: DescribeClusterSnapshotsRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterSnapshotsResponse] =
          primitive(_.describeClusterSnapshots(request))

        def describeClusterSubnetGroups(
          request: DescribeClusterSubnetGroupsRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterSubnetGroupsResponse] =
          primitive(_.describeClusterSubnetGroups(request))

        def describeClusterTracks(
          request: DescribeClusterTracksRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterTracksResponse] =
          primitive(_.describeClusterTracks(request))

        def describeClusterVersions(
          request: DescribeClusterVersionsRequest
        ): Kleisli[M, RedshiftClient, DescribeClusterVersionsResponse] =
          primitive(_.describeClusterVersions(request))

        def describeClusters(
          request: DescribeClustersRequest
        ): Kleisli[M, RedshiftClient, DescribeClustersResponse] =
          primitive(_.describeClusters(request))

        def describeDefaultClusterParameters(
          request: DescribeDefaultClusterParametersRequest
        ): Kleisli[M, RedshiftClient, DescribeDefaultClusterParametersResponse] =
          primitive(_.describeDefaultClusterParameters(request))

        def describeEndpointAccess(
          request: DescribeEndpointAccessRequest
        ): Kleisli[M, RedshiftClient, DescribeEndpointAccessResponse] =
          primitive(_.describeEndpointAccess(request))

        def describeEndpointAuthorization(
          request: DescribeEndpointAuthorizationRequest
        ): Kleisli[M, RedshiftClient, DescribeEndpointAuthorizationResponse] =
          primitive(_.describeEndpointAuthorization(request))

        def describeEventCategories(
          request: DescribeEventCategoriesRequest
        ): Kleisli[M, RedshiftClient, DescribeEventCategoriesResponse] =
          primitive(_.describeEventCategories(request))

        def describeEventSubscriptions(
          request: DescribeEventSubscriptionsRequest
        ): Kleisli[M, RedshiftClient, DescribeEventSubscriptionsResponse] =
          primitive(_.describeEventSubscriptions(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, RedshiftClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeHsmClientCertificates(
          request: DescribeHsmClientCertificatesRequest
        ): Kleisli[M, RedshiftClient, DescribeHsmClientCertificatesResponse] =
          primitive(_.describeHsmClientCertificates(request))

        def describeHsmConfigurations(
          request: DescribeHsmConfigurationsRequest
        ): Kleisli[M, RedshiftClient, DescribeHsmConfigurationsResponse] =
          primitive(_.describeHsmConfigurations(request))

        def describeLoggingStatus(
          request: DescribeLoggingStatusRequest
        ): Kleisli[M, RedshiftClient, DescribeLoggingStatusResponse] =
          primitive(_.describeLoggingStatus(request))

        def describeNodeConfigurationOptions(
          request: DescribeNodeConfigurationOptionsRequest
        ): Kleisli[M, RedshiftClient, DescribeNodeConfigurationOptionsResponse] =
          primitive(_.describeNodeConfigurationOptions(request))

        def describeOrderableClusterOptions(
          request: DescribeOrderableClusterOptionsRequest
        ): Kleisli[M, RedshiftClient, DescribeOrderableClusterOptionsResponse] =
          primitive(_.describeOrderableClusterOptions(request))

        def describePartners(
          request: DescribePartnersRequest
        ): Kleisli[M, RedshiftClient, DescribePartnersResponse] =
          primitive(_.describePartners(request))

        def describeReservedNodeOfferings(
          request: DescribeReservedNodeOfferingsRequest
        ): Kleisli[M, RedshiftClient, DescribeReservedNodeOfferingsResponse] =
          primitive(_.describeReservedNodeOfferings(request))

        def describeReservedNodes(
          request: DescribeReservedNodesRequest
        ): Kleisli[M, RedshiftClient, DescribeReservedNodesResponse] =
          primitive(_.describeReservedNodes(request))

        def describeResize(
          request: DescribeResizeRequest
        ): Kleisli[M, RedshiftClient, DescribeResizeResponse] =
          primitive(_.describeResize(request))

        def describeScheduledActions(
          request: DescribeScheduledActionsRequest
        ): Kleisli[M, RedshiftClient, DescribeScheduledActionsResponse] =
          primitive(_.describeScheduledActions(request))

        def describeSnapshotCopyGrants(
          request: DescribeSnapshotCopyGrantsRequest
        ): Kleisli[M, RedshiftClient, DescribeSnapshotCopyGrantsResponse] =
          primitive(_.describeSnapshotCopyGrants(request))

        def describeSnapshotSchedules(
          request: DescribeSnapshotSchedulesRequest
        ): Kleisli[M, RedshiftClient, DescribeSnapshotSchedulesResponse] =
          primitive(_.describeSnapshotSchedules(request))

        def describeStorage(
          request: DescribeStorageRequest
        ): Kleisli[M, RedshiftClient, DescribeStorageResponse] =
          primitive(_.describeStorage(request))

        def describeTableRestoreStatus(
          request: DescribeTableRestoreStatusRequest
        ): Kleisli[M, RedshiftClient, DescribeTableRestoreStatusResponse] =
          primitive(_.describeTableRestoreStatus(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, RedshiftClient, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def describeUsageLimits(
          request: DescribeUsageLimitsRequest
        ): Kleisli[M, RedshiftClient, DescribeUsageLimitsResponse] =
          primitive(_.describeUsageLimits(request))

        def disableLogging(
          request: DisableLoggingRequest
        ): Kleisli[M, RedshiftClient, DisableLoggingResponse] =
          primitive(_.disableLogging(request))

        def disableSnapshotCopy(
          request: DisableSnapshotCopyRequest
        ): Kleisli[M, RedshiftClient, DisableSnapshotCopyResponse] =
          primitive(_.disableSnapshotCopy(request))

        def enableLogging(
          request: EnableLoggingRequest
        ): Kleisli[M, RedshiftClient, EnableLoggingResponse] =
          primitive(_.enableLogging(request))

        def enableSnapshotCopy(
          request: EnableSnapshotCopyRequest
        ): Kleisli[M, RedshiftClient, EnableSnapshotCopyResponse] =
          primitive(_.enableSnapshotCopy(request))

        def getClusterCredentials(
          request: GetClusterCredentialsRequest
        ): Kleisli[M, RedshiftClient, GetClusterCredentialsResponse] =
          primitive(_.getClusterCredentials(request))

        def getReservedNodeExchangeOfferings(
          request: GetReservedNodeExchangeOfferingsRequest
        ): Kleisli[M, RedshiftClient, GetReservedNodeExchangeOfferingsResponse] =
          primitive(_.getReservedNodeExchangeOfferings(request))

        def modifyAquaConfiguration(
          request: ModifyAquaConfigurationRequest
        ): Kleisli[M, RedshiftClient, ModifyAquaConfigurationResponse] =
          primitive(_.modifyAquaConfiguration(request))

        def modifyCluster(
          request: ModifyClusterRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterResponse] =
          primitive(_.modifyCluster(request))

        def modifyClusterDbRevision(
          request: ModifyClusterDbRevisionRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterDbRevisionResponse] =
          primitive(_.modifyClusterDbRevision(request))

        def modifyClusterIamRoles(
          request: ModifyClusterIamRolesRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterIamRolesResponse] =
          primitive(_.modifyClusterIamRoles(request))

        def modifyClusterMaintenance(
          request: ModifyClusterMaintenanceRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterMaintenanceResponse] =
          primitive(_.modifyClusterMaintenance(request))

        def modifyClusterParameterGroup(
          request: ModifyClusterParameterGroupRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterParameterGroupResponse] =
          primitive(_.modifyClusterParameterGroup(request))

        def modifyClusterSnapshot(
          request: ModifyClusterSnapshotRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterSnapshotResponse] =
          primitive(_.modifyClusterSnapshot(request))

        def modifyClusterSnapshotSchedule(
          request: ModifyClusterSnapshotScheduleRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterSnapshotScheduleResponse] =
          primitive(_.modifyClusterSnapshotSchedule(request))

        def modifyClusterSubnetGroup(
          request: ModifyClusterSubnetGroupRequest
        ): Kleisli[M, RedshiftClient, ModifyClusterSubnetGroupResponse] =
          primitive(_.modifyClusterSubnetGroup(request))

        def modifyEndpointAccess(
          request: ModifyEndpointAccessRequest
        ): Kleisli[M, RedshiftClient, ModifyEndpointAccessResponse] =
          primitive(_.modifyEndpointAccess(request))

        def modifyEventSubscription(
          request: ModifyEventSubscriptionRequest
        ): Kleisli[M, RedshiftClient, ModifyEventSubscriptionResponse] =
          primitive(_.modifyEventSubscription(request))

        def modifyScheduledAction(
          request: ModifyScheduledActionRequest
        ): Kleisli[M, RedshiftClient, ModifyScheduledActionResponse] =
          primitive(_.modifyScheduledAction(request))

        def modifySnapshotCopyRetentionPeriod(
          request: ModifySnapshotCopyRetentionPeriodRequest
        ): Kleisli[M, RedshiftClient, ModifySnapshotCopyRetentionPeriodResponse] =
          primitive(_.modifySnapshotCopyRetentionPeriod(request))

        def modifySnapshotSchedule(
          request: ModifySnapshotScheduleRequest
        ): Kleisli[M, RedshiftClient, ModifySnapshotScheduleResponse] =
          primitive(_.modifySnapshotSchedule(request))

        def modifyUsageLimit(
          request: ModifyUsageLimitRequest
        ): Kleisli[M, RedshiftClient, ModifyUsageLimitResponse] =
          primitive(_.modifyUsageLimit(request))

        def pauseCluster(
          request: PauseClusterRequest
        ): Kleisli[M, RedshiftClient, PauseClusterResponse] =
          primitive(_.pauseCluster(request))

        def purchaseReservedNodeOffering(
          request: PurchaseReservedNodeOfferingRequest
        ): Kleisli[M, RedshiftClient, PurchaseReservedNodeOfferingResponse] =
          primitive(_.purchaseReservedNodeOffering(request))

        def rebootCluster(
          request: RebootClusterRequest
        ): Kleisli[M, RedshiftClient, RebootClusterResponse] =
          primitive(_.rebootCluster(request))

        def resetClusterParameterGroup(
          request: ResetClusterParameterGroupRequest
        ): Kleisli[M, RedshiftClient, ResetClusterParameterGroupResponse] =
          primitive(_.resetClusterParameterGroup(request))

        def resizeCluster(
          request: ResizeClusterRequest
        ): Kleisli[M, RedshiftClient, ResizeClusterResponse] =
          primitive(_.resizeCluster(request))

        def restoreFromClusterSnapshot(
          request: RestoreFromClusterSnapshotRequest
        ): Kleisli[M, RedshiftClient, RestoreFromClusterSnapshotResponse] =
          primitive(_.restoreFromClusterSnapshot(request))

        def restoreTableFromClusterSnapshot(
          request: RestoreTableFromClusterSnapshotRequest
        ): Kleisli[M, RedshiftClient, RestoreTableFromClusterSnapshotResponse] =
          primitive(_.restoreTableFromClusterSnapshot(request))

        def resumeCluster(
          request: ResumeClusterRequest
        ): Kleisli[M, RedshiftClient, ResumeClusterResponse] =
          primitive(_.resumeCluster(request))

        def revokeClusterSecurityGroupIngress(
          request: RevokeClusterSecurityGroupIngressRequest
        ): Kleisli[M, RedshiftClient, RevokeClusterSecurityGroupIngressResponse] =
          primitive(_.revokeClusterSecurityGroupIngress(request))

        def revokeEndpointAccess(
          request: RevokeEndpointAccessRequest
        ): Kleisli[M, RedshiftClient, RevokeEndpointAccessResponse] =
          primitive(_.revokeEndpointAccess(request))

        def revokeSnapshotAccess(
          request: RevokeSnapshotAccessRequest
        ): Kleisli[M, RedshiftClient, RevokeSnapshotAccessResponse] =
          primitive(_.revokeSnapshotAccess(request))

        def rotateEncryptionKey(
          request: RotateEncryptionKeyRequest
        ): Kleisli[M, RedshiftClient, RotateEncryptionKeyResponse] =
          primitive(_.rotateEncryptionKey(request))

        def updatePartnerStatus(
          request: UpdatePartnerStatusRequest
        ): Kleisli[M, RedshiftClient, UpdatePartnerStatusResponse] =
          primitive(_.updatePartnerStatus(request))

        def primitive[A](
          f: RedshiftClient => A
        ): Kleisli[M, RedshiftClient, A]
      }
    }

    trait Visitor[F[_]] extends (RedshiftOp ~> F) {
      final def apply[A](op: RedshiftOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptReservedNodeExchange(
        request: AcceptReservedNodeExchangeRequest
      ): F[AcceptReservedNodeExchangeResponse]

      def addPartner(
        request: AddPartnerRequest
      ): F[AddPartnerResponse]

      def authorizeClusterSecurityGroupIngress(
        request: AuthorizeClusterSecurityGroupIngressRequest
      ): F[AuthorizeClusterSecurityGroupIngressResponse]

      def authorizeEndpointAccess(
        request: AuthorizeEndpointAccessRequest
      ): F[AuthorizeEndpointAccessResponse]

      def authorizeSnapshotAccess(
        request: AuthorizeSnapshotAccessRequest
      ): F[AuthorizeSnapshotAccessResponse]

      def batchDeleteClusterSnapshots(
        request: BatchDeleteClusterSnapshotsRequest
      ): F[BatchDeleteClusterSnapshotsResponse]

      def batchModifyClusterSnapshots(
        request: BatchModifyClusterSnapshotsRequest
      ): F[BatchModifyClusterSnapshotsResponse]

      def cancelResize(
        request: CancelResizeRequest
      ): F[CancelResizeResponse]

      def copyClusterSnapshot(
        request: CopyClusterSnapshotRequest
      ): F[CopyClusterSnapshotResponse]

      def createCluster(
        request: CreateClusterRequest
      ): F[CreateClusterResponse]

      def createClusterParameterGroup(
        request: CreateClusterParameterGroupRequest
      ): F[CreateClusterParameterGroupResponse]

      def createClusterSecurityGroup(
        request: CreateClusterSecurityGroupRequest
      ): F[CreateClusterSecurityGroupResponse]

      def createClusterSnapshot(
        request: CreateClusterSnapshotRequest
      ): F[CreateClusterSnapshotResponse]

      def createClusterSubnetGroup(
        request: CreateClusterSubnetGroupRequest
      ): F[CreateClusterSubnetGroupResponse]

      def createEndpointAccess(
        request: CreateEndpointAccessRequest
      ): F[CreateEndpointAccessResponse]

      def createEventSubscription(
        request: CreateEventSubscriptionRequest
      ): F[CreateEventSubscriptionResponse]

      def createHsmClientCertificate(
        request: CreateHsmClientCertificateRequest
      ): F[CreateHsmClientCertificateResponse]

      def createHsmConfiguration(
        request: CreateHsmConfigurationRequest
      ): F[CreateHsmConfigurationResponse]

      def createScheduledAction(
        request: CreateScheduledActionRequest
      ): F[CreateScheduledActionResponse]

      def createSnapshotCopyGrant(
        request: CreateSnapshotCopyGrantRequest
      ): F[CreateSnapshotCopyGrantResponse]

      def createSnapshotSchedule(
        request: CreateSnapshotScheduleRequest
      ): F[CreateSnapshotScheduleResponse]

      def createTags(
        request: CreateTagsRequest
      ): F[CreateTagsResponse]

      def createUsageLimit(
        request: CreateUsageLimitRequest
      ): F[CreateUsageLimitResponse]

      def deleteCluster(
        request: DeleteClusterRequest
      ): F[DeleteClusterResponse]

      def deleteClusterParameterGroup(
        request: DeleteClusterParameterGroupRequest
      ): F[DeleteClusterParameterGroupResponse]

      def deleteClusterSecurityGroup(
        request: DeleteClusterSecurityGroupRequest
      ): F[DeleteClusterSecurityGroupResponse]

      def deleteClusterSnapshot(
        request: DeleteClusterSnapshotRequest
      ): F[DeleteClusterSnapshotResponse]

      def deleteClusterSubnetGroup(
        request: DeleteClusterSubnetGroupRequest
      ): F[DeleteClusterSubnetGroupResponse]

      def deleteEndpointAccess(
        request: DeleteEndpointAccessRequest
      ): F[DeleteEndpointAccessResponse]

      def deleteEventSubscription(
        request: DeleteEventSubscriptionRequest
      ): F[DeleteEventSubscriptionResponse]

      def deleteHsmClientCertificate(
        request: DeleteHsmClientCertificateRequest
      ): F[DeleteHsmClientCertificateResponse]

      def deleteHsmConfiguration(
        request: DeleteHsmConfigurationRequest
      ): F[DeleteHsmConfigurationResponse]

      def deletePartner(
        request: DeletePartnerRequest
      ): F[DeletePartnerResponse]

      def deleteScheduledAction(
        request: DeleteScheduledActionRequest
      ): F[DeleteScheduledActionResponse]

      def deleteSnapshotCopyGrant(
        request: DeleteSnapshotCopyGrantRequest
      ): F[DeleteSnapshotCopyGrantResponse]

      def deleteSnapshotSchedule(
        request: DeleteSnapshotScheduleRequest
      ): F[DeleteSnapshotScheduleResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def deleteUsageLimit(
        request: DeleteUsageLimitRequest
      ): F[DeleteUsageLimitResponse]

      def describeAccountAttributes(
        request: DescribeAccountAttributesRequest
      ): F[DescribeAccountAttributesResponse]

      def describeClusterDbRevisions(
        request: DescribeClusterDbRevisionsRequest
      ): F[DescribeClusterDbRevisionsResponse]

      def describeClusterParameterGroups(
        request: DescribeClusterParameterGroupsRequest
      ): F[DescribeClusterParameterGroupsResponse]

      def describeClusterParameters(
        request: DescribeClusterParametersRequest
      ): F[DescribeClusterParametersResponse]

      def describeClusterSecurityGroups(
        request: DescribeClusterSecurityGroupsRequest
      ): F[DescribeClusterSecurityGroupsResponse]

      def describeClusterSnapshots(
        request: DescribeClusterSnapshotsRequest
      ): F[DescribeClusterSnapshotsResponse]

      def describeClusterSubnetGroups(
        request: DescribeClusterSubnetGroupsRequest
      ): F[DescribeClusterSubnetGroupsResponse]

      def describeClusterTracks(
        request: DescribeClusterTracksRequest
      ): F[DescribeClusterTracksResponse]

      def describeClusterVersions(
        request: DescribeClusterVersionsRequest
      ): F[DescribeClusterVersionsResponse]

      def describeClusters(
        request: DescribeClustersRequest
      ): F[DescribeClustersResponse]

      def describeDefaultClusterParameters(
        request: DescribeDefaultClusterParametersRequest
      ): F[DescribeDefaultClusterParametersResponse]

      def describeEndpointAccess(
        request: DescribeEndpointAccessRequest
      ): F[DescribeEndpointAccessResponse]

      def describeEndpointAuthorization(
        request: DescribeEndpointAuthorizationRequest
      ): F[DescribeEndpointAuthorizationResponse]

      def describeEventCategories(
        request: DescribeEventCategoriesRequest
      ): F[DescribeEventCategoriesResponse]

      def describeEventSubscriptions(
        request: DescribeEventSubscriptionsRequest
      ): F[DescribeEventSubscriptionsResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeHsmClientCertificates(
        request: DescribeHsmClientCertificatesRequest
      ): F[DescribeHsmClientCertificatesResponse]

      def describeHsmConfigurations(
        request: DescribeHsmConfigurationsRequest
      ): F[DescribeHsmConfigurationsResponse]

      def describeLoggingStatus(
        request: DescribeLoggingStatusRequest
      ): F[DescribeLoggingStatusResponse]

      def describeNodeConfigurationOptions(
        request: DescribeNodeConfigurationOptionsRequest
      ): F[DescribeNodeConfigurationOptionsResponse]

      def describeOrderableClusterOptions(
        request: DescribeOrderableClusterOptionsRequest
      ): F[DescribeOrderableClusterOptionsResponse]

      def describePartners(
        request: DescribePartnersRequest
      ): F[DescribePartnersResponse]

      def describeReservedNodeOfferings(
        request: DescribeReservedNodeOfferingsRequest
      ): F[DescribeReservedNodeOfferingsResponse]

      def describeReservedNodes(
        request: DescribeReservedNodesRequest
      ): F[DescribeReservedNodesResponse]

      def describeResize(
        request: DescribeResizeRequest
      ): F[DescribeResizeResponse]

      def describeScheduledActions(
        request: DescribeScheduledActionsRequest
      ): F[DescribeScheduledActionsResponse]

      def describeSnapshotCopyGrants(
        request: DescribeSnapshotCopyGrantsRequest
      ): F[DescribeSnapshotCopyGrantsResponse]

      def describeSnapshotSchedules(
        request: DescribeSnapshotSchedulesRequest
      ): F[DescribeSnapshotSchedulesResponse]

      def describeStorage(
        request: DescribeStorageRequest
      ): F[DescribeStorageResponse]

      def describeTableRestoreStatus(
        request: DescribeTableRestoreStatusRequest
      ): F[DescribeTableRestoreStatusResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def describeUsageLimits(
        request: DescribeUsageLimitsRequest
      ): F[DescribeUsageLimitsResponse]

      def disableLogging(
        request: DisableLoggingRequest
      ): F[DisableLoggingResponse]

      def disableSnapshotCopy(
        request: DisableSnapshotCopyRequest
      ): F[DisableSnapshotCopyResponse]

      def enableLogging(
        request: EnableLoggingRequest
      ): F[EnableLoggingResponse]

      def enableSnapshotCopy(
        request: EnableSnapshotCopyRequest
      ): F[EnableSnapshotCopyResponse]

      def getClusterCredentials(
        request: GetClusterCredentialsRequest
      ): F[GetClusterCredentialsResponse]

      def getReservedNodeExchangeOfferings(
        request: GetReservedNodeExchangeOfferingsRequest
      ): F[GetReservedNodeExchangeOfferingsResponse]

      def modifyAquaConfiguration(
        request: ModifyAquaConfigurationRequest
      ): F[ModifyAquaConfigurationResponse]

      def modifyCluster(
        request: ModifyClusterRequest
      ): F[ModifyClusterResponse]

      def modifyClusterDbRevision(
        request: ModifyClusterDbRevisionRequest
      ): F[ModifyClusterDbRevisionResponse]

      def modifyClusterIamRoles(
        request: ModifyClusterIamRolesRequest
      ): F[ModifyClusterIamRolesResponse]

      def modifyClusterMaintenance(
        request: ModifyClusterMaintenanceRequest
      ): F[ModifyClusterMaintenanceResponse]

      def modifyClusterParameterGroup(
        request: ModifyClusterParameterGroupRequest
      ): F[ModifyClusterParameterGroupResponse]

      def modifyClusterSnapshot(
        request: ModifyClusterSnapshotRequest
      ): F[ModifyClusterSnapshotResponse]

      def modifyClusterSnapshotSchedule(
        request: ModifyClusterSnapshotScheduleRequest
      ): F[ModifyClusterSnapshotScheduleResponse]

      def modifyClusterSubnetGroup(
        request: ModifyClusterSubnetGroupRequest
      ): F[ModifyClusterSubnetGroupResponse]

      def modifyEndpointAccess(
        request: ModifyEndpointAccessRequest
      ): F[ModifyEndpointAccessResponse]

      def modifyEventSubscription(
        request: ModifyEventSubscriptionRequest
      ): F[ModifyEventSubscriptionResponse]

      def modifyScheduledAction(
        request: ModifyScheduledActionRequest
      ): F[ModifyScheduledActionResponse]

      def modifySnapshotCopyRetentionPeriod(
        request: ModifySnapshotCopyRetentionPeriodRequest
      ): F[ModifySnapshotCopyRetentionPeriodResponse]

      def modifySnapshotSchedule(
        request: ModifySnapshotScheduleRequest
      ): F[ModifySnapshotScheduleResponse]

      def modifyUsageLimit(
        request: ModifyUsageLimitRequest
      ): F[ModifyUsageLimitResponse]

      def pauseCluster(
        request: PauseClusterRequest
      ): F[PauseClusterResponse]

      def purchaseReservedNodeOffering(
        request: PurchaseReservedNodeOfferingRequest
      ): F[PurchaseReservedNodeOfferingResponse]

      def rebootCluster(
        request: RebootClusterRequest
      ): F[RebootClusterResponse]

      def resetClusterParameterGroup(
        request: ResetClusterParameterGroupRequest
      ): F[ResetClusterParameterGroupResponse]

      def resizeCluster(
        request: ResizeClusterRequest
      ): F[ResizeClusterResponse]

      def restoreFromClusterSnapshot(
        request: RestoreFromClusterSnapshotRequest
      ): F[RestoreFromClusterSnapshotResponse]

      def restoreTableFromClusterSnapshot(
        request: RestoreTableFromClusterSnapshotRequest
      ): F[RestoreTableFromClusterSnapshotResponse]

      def resumeCluster(
        request: ResumeClusterRequest
      ): F[ResumeClusterResponse]

      def revokeClusterSecurityGroupIngress(
        request: RevokeClusterSecurityGroupIngressRequest
      ): F[RevokeClusterSecurityGroupIngressResponse]

      def revokeEndpointAccess(
        request: RevokeEndpointAccessRequest
      ): F[RevokeEndpointAccessResponse]

      def revokeSnapshotAccess(
        request: RevokeSnapshotAccessRequest
      ): F[RevokeSnapshotAccessResponse]

      def rotateEncryptionKey(
        request: RotateEncryptionKeyRequest
      ): F[RotateEncryptionKeyResponse]

      def updatePartnerStatus(
        request: UpdatePartnerStatusRequest
      ): F[UpdatePartnerStatusResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends RedshiftOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptReservedNodeExchangeOp(
      request: AcceptReservedNodeExchangeRequest
    ) extends RedshiftOp[AcceptReservedNodeExchangeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptReservedNodeExchangeResponse] =
        visitor.acceptReservedNodeExchange(request)
    }

    final case class AddPartnerOp(
      request: AddPartnerRequest
    ) extends RedshiftOp[AddPartnerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddPartnerResponse] =
        visitor.addPartner(request)
    }

    final case class AuthorizeClusterSecurityGroupIngressOp(
      request: AuthorizeClusterSecurityGroupIngressRequest
    ) extends RedshiftOp[AuthorizeClusterSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeClusterSecurityGroupIngressResponse] =
        visitor.authorizeClusterSecurityGroupIngress(request)
    }

    final case class AuthorizeEndpointAccessOp(
      request: AuthorizeEndpointAccessRequest
    ) extends RedshiftOp[AuthorizeEndpointAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeEndpointAccessResponse] =
        visitor.authorizeEndpointAccess(request)
    }

    final case class AuthorizeSnapshotAccessOp(
      request: AuthorizeSnapshotAccessRequest
    ) extends RedshiftOp[AuthorizeSnapshotAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeSnapshotAccessResponse] =
        visitor.authorizeSnapshotAccess(request)
    }

    final case class BatchDeleteClusterSnapshotsOp(
      request: BatchDeleteClusterSnapshotsRequest
    ) extends RedshiftOp[BatchDeleteClusterSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteClusterSnapshotsResponse] =
        visitor.batchDeleteClusterSnapshots(request)
    }

    final case class BatchModifyClusterSnapshotsOp(
      request: BatchModifyClusterSnapshotsRequest
    ) extends RedshiftOp[BatchModifyClusterSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchModifyClusterSnapshotsResponse] =
        visitor.batchModifyClusterSnapshots(request)
    }

    final case class CancelResizeOp(
      request: CancelResizeRequest
    ) extends RedshiftOp[CancelResizeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelResizeResponse] =
        visitor.cancelResize(request)
    }

    final case class CopyClusterSnapshotOp(
      request: CopyClusterSnapshotRequest
    ) extends RedshiftOp[CopyClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyClusterSnapshotResponse] =
        visitor.copyClusterSnapshot(request)
    }

    final case class CreateClusterOp(
      request: CreateClusterRequest
    ) extends RedshiftOp[CreateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterResponse] =
        visitor.createCluster(request)
    }

    final case class CreateClusterParameterGroupOp(
      request: CreateClusterParameterGroupRequest
    ) extends RedshiftOp[CreateClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterParameterGroupResponse] =
        visitor.createClusterParameterGroup(request)
    }

    final case class CreateClusterSecurityGroupOp(
      request: CreateClusterSecurityGroupRequest
    ) extends RedshiftOp[CreateClusterSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterSecurityGroupResponse] =
        visitor.createClusterSecurityGroup(request)
    }

    final case class CreateClusterSnapshotOp(
      request: CreateClusterSnapshotRequest
    ) extends RedshiftOp[CreateClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterSnapshotResponse] =
        visitor.createClusterSnapshot(request)
    }

    final case class CreateClusterSubnetGroupOp(
      request: CreateClusterSubnetGroupRequest
    ) extends RedshiftOp[CreateClusterSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterSubnetGroupResponse] =
        visitor.createClusterSubnetGroup(request)
    }

    final case class CreateEndpointAccessOp(
      request: CreateEndpointAccessRequest
    ) extends RedshiftOp[CreateEndpointAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEndpointAccessResponse] =
        visitor.createEndpointAccess(request)
    }

    final case class CreateEventSubscriptionOp(
      request: CreateEventSubscriptionRequest
    ) extends RedshiftOp[CreateEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventSubscriptionResponse] =
        visitor.createEventSubscription(request)
    }

    final case class CreateHsmClientCertificateOp(
      request: CreateHsmClientCertificateRequest
    ) extends RedshiftOp[CreateHsmClientCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHsmClientCertificateResponse] =
        visitor.createHsmClientCertificate(request)
    }

    final case class CreateHsmConfigurationOp(
      request: CreateHsmConfigurationRequest
    ) extends RedshiftOp[CreateHsmConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHsmConfigurationResponse] =
        visitor.createHsmConfiguration(request)
    }

    final case class CreateScheduledActionOp(
      request: CreateScheduledActionRequest
    ) extends RedshiftOp[CreateScheduledActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateScheduledActionResponse] =
        visitor.createScheduledAction(request)
    }

    final case class CreateSnapshotCopyGrantOp(
      request: CreateSnapshotCopyGrantRequest
    ) extends RedshiftOp[CreateSnapshotCopyGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotCopyGrantResponse] =
        visitor.createSnapshotCopyGrant(request)
    }

    final case class CreateSnapshotScheduleOp(
      request: CreateSnapshotScheduleRequest
    ) extends RedshiftOp[CreateSnapshotScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSnapshotScheduleResponse] =
        visitor.createSnapshotSchedule(request)
    }

    final case class CreateTagsOp(
      request: CreateTagsRequest
    ) extends RedshiftOp[CreateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTagsResponse] =
        visitor.createTags(request)
    }

    final case class CreateUsageLimitOp(
      request: CreateUsageLimitRequest
    ) extends RedshiftOp[CreateUsageLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUsageLimitResponse] =
        visitor.createUsageLimit(request)
    }

    final case class DeleteClusterOp(
      request: DeleteClusterRequest
    ) extends RedshiftOp[DeleteClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterResponse] =
        visitor.deleteCluster(request)
    }

    final case class DeleteClusterParameterGroupOp(
      request: DeleteClusterParameterGroupRequest
    ) extends RedshiftOp[DeleteClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterParameterGroupResponse] =
        visitor.deleteClusterParameterGroup(request)
    }

    final case class DeleteClusterSecurityGroupOp(
      request: DeleteClusterSecurityGroupRequest
    ) extends RedshiftOp[DeleteClusterSecurityGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterSecurityGroupResponse] =
        visitor.deleteClusterSecurityGroup(request)
    }

    final case class DeleteClusterSnapshotOp(
      request: DeleteClusterSnapshotRequest
    ) extends RedshiftOp[DeleteClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterSnapshotResponse] =
        visitor.deleteClusterSnapshot(request)
    }

    final case class DeleteClusterSubnetGroupOp(
      request: DeleteClusterSubnetGroupRequest
    ) extends RedshiftOp[DeleteClusterSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterSubnetGroupResponse] =
        visitor.deleteClusterSubnetGroup(request)
    }

    final case class DeleteEndpointAccessOp(
      request: DeleteEndpointAccessRequest
    ) extends RedshiftOp[DeleteEndpointAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointAccessResponse] =
        visitor.deleteEndpointAccess(request)
    }

    final case class DeleteEventSubscriptionOp(
      request: DeleteEventSubscriptionRequest
    ) extends RedshiftOp[DeleteEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventSubscriptionResponse] =
        visitor.deleteEventSubscription(request)
    }

    final case class DeleteHsmClientCertificateOp(
      request: DeleteHsmClientCertificateRequest
    ) extends RedshiftOp[DeleteHsmClientCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHsmClientCertificateResponse] =
        visitor.deleteHsmClientCertificate(request)
    }

    final case class DeleteHsmConfigurationOp(
      request: DeleteHsmConfigurationRequest
    ) extends RedshiftOp[DeleteHsmConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHsmConfigurationResponse] =
        visitor.deleteHsmConfiguration(request)
    }

    final case class DeletePartnerOp(
      request: DeletePartnerRequest
    ) extends RedshiftOp[DeletePartnerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePartnerResponse] =
        visitor.deletePartner(request)
    }

    final case class DeleteScheduledActionOp(
      request: DeleteScheduledActionRequest
    ) extends RedshiftOp[DeleteScheduledActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScheduledActionResponse] =
        visitor.deleteScheduledAction(request)
    }

    final case class DeleteSnapshotCopyGrantOp(
      request: DeleteSnapshotCopyGrantRequest
    ) extends RedshiftOp[DeleteSnapshotCopyGrantResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSnapshotCopyGrantResponse] =
        visitor.deleteSnapshotCopyGrant(request)
    }

    final case class DeleteSnapshotScheduleOp(
      request: DeleteSnapshotScheduleRequest
    ) extends RedshiftOp[DeleteSnapshotScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSnapshotScheduleResponse] =
        visitor.deleteSnapshotSchedule(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends RedshiftOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DeleteUsageLimitOp(
      request: DeleteUsageLimitRequest
    ) extends RedshiftOp[DeleteUsageLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUsageLimitResponse] =
        visitor.deleteUsageLimit(request)
    }

    final case class DescribeAccountAttributesOp(
      request: DescribeAccountAttributesRequest
    ) extends RedshiftOp[DescribeAccountAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAttributesResponse] =
        visitor.describeAccountAttributes(request)
    }

    final case class DescribeClusterDbRevisionsOp(
      request: DescribeClusterDbRevisionsRequest
    ) extends RedshiftOp[DescribeClusterDbRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterDbRevisionsResponse] =
        visitor.describeClusterDbRevisions(request)
    }

    final case class DescribeClusterParameterGroupsOp(
      request: DescribeClusterParameterGroupsRequest
    ) extends RedshiftOp[DescribeClusterParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterParameterGroupsResponse] =
        visitor.describeClusterParameterGroups(request)
    }

    final case class DescribeClusterParametersOp(
      request: DescribeClusterParametersRequest
    ) extends RedshiftOp[DescribeClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterParametersResponse] =
        visitor.describeClusterParameters(request)
    }

    final case class DescribeClusterSecurityGroupsOp(
      request: DescribeClusterSecurityGroupsRequest
    ) extends RedshiftOp[DescribeClusterSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterSecurityGroupsResponse] =
        visitor.describeClusterSecurityGroups(request)
    }

    final case class DescribeClusterSnapshotsOp(
      request: DescribeClusterSnapshotsRequest
    ) extends RedshiftOp[DescribeClusterSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterSnapshotsResponse] =
        visitor.describeClusterSnapshots(request)
    }

    final case class DescribeClusterSubnetGroupsOp(
      request: DescribeClusterSubnetGroupsRequest
    ) extends RedshiftOp[DescribeClusterSubnetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterSubnetGroupsResponse] =
        visitor.describeClusterSubnetGroups(request)
    }

    final case class DescribeClusterTracksOp(
      request: DescribeClusterTracksRequest
    ) extends RedshiftOp[DescribeClusterTracksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterTracksResponse] =
        visitor.describeClusterTracks(request)
    }

    final case class DescribeClusterVersionsOp(
      request: DescribeClusterVersionsRequest
    ) extends RedshiftOp[DescribeClusterVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterVersionsResponse] =
        visitor.describeClusterVersions(request)
    }

    final case class DescribeClustersOp(
      request: DescribeClustersRequest
    ) extends RedshiftOp[DescribeClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClustersResponse] =
        visitor.describeClusters(request)
    }

    final case class DescribeDefaultClusterParametersOp(
      request: DescribeDefaultClusterParametersRequest
    ) extends RedshiftOp[DescribeDefaultClusterParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDefaultClusterParametersResponse] =
        visitor.describeDefaultClusterParameters(request)
    }

    final case class DescribeEndpointAccessOp(
      request: DescribeEndpointAccessRequest
    ) extends RedshiftOp[DescribeEndpointAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointAccessResponse] =
        visitor.describeEndpointAccess(request)
    }

    final case class DescribeEndpointAuthorizationOp(
      request: DescribeEndpointAuthorizationRequest
    ) extends RedshiftOp[DescribeEndpointAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointAuthorizationResponse] =
        visitor.describeEndpointAuthorization(request)
    }

    final case class DescribeEventCategoriesOp(
      request: DescribeEventCategoriesRequest
    ) extends RedshiftOp[DescribeEventCategoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventCategoriesResponse] =
        visitor.describeEventCategories(request)
    }

    final case class DescribeEventSubscriptionsOp(
      request: DescribeEventSubscriptionsRequest
    ) extends RedshiftOp[DescribeEventSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventSubscriptionsResponse] =
        visitor.describeEventSubscriptions(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends RedshiftOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeHsmClientCertificatesOp(
      request: DescribeHsmClientCertificatesRequest
    ) extends RedshiftOp[DescribeHsmClientCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHsmClientCertificatesResponse] =
        visitor.describeHsmClientCertificates(request)
    }

    final case class DescribeHsmConfigurationsOp(
      request: DescribeHsmConfigurationsRequest
    ) extends RedshiftOp[DescribeHsmConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHsmConfigurationsResponse] =
        visitor.describeHsmConfigurations(request)
    }

    final case class DescribeLoggingStatusOp(
      request: DescribeLoggingStatusRequest
    ) extends RedshiftOp[DescribeLoggingStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoggingStatusResponse] =
        visitor.describeLoggingStatus(request)
    }

    final case class DescribeNodeConfigurationOptionsOp(
      request: DescribeNodeConfigurationOptionsRequest
    ) extends RedshiftOp[DescribeNodeConfigurationOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNodeConfigurationOptionsResponse] =
        visitor.describeNodeConfigurationOptions(request)
    }

    final case class DescribeOrderableClusterOptionsOp(
      request: DescribeOrderableClusterOptionsRequest
    ) extends RedshiftOp[DescribeOrderableClusterOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrderableClusterOptionsResponse] =
        visitor.describeOrderableClusterOptions(request)
    }

    final case class DescribePartnersOp(
      request: DescribePartnersRequest
    ) extends RedshiftOp[DescribePartnersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePartnersResponse] =
        visitor.describePartners(request)
    }

    final case class DescribeReservedNodeOfferingsOp(
      request: DescribeReservedNodeOfferingsRequest
    ) extends RedshiftOp[DescribeReservedNodeOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedNodeOfferingsResponse] =
        visitor.describeReservedNodeOfferings(request)
    }

    final case class DescribeReservedNodesOp(
      request: DescribeReservedNodesRequest
    ) extends RedshiftOp[DescribeReservedNodesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReservedNodesResponse] =
        visitor.describeReservedNodes(request)
    }

    final case class DescribeResizeOp(
      request: DescribeResizeRequest
    ) extends RedshiftOp[DescribeResizeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResizeResponse] =
        visitor.describeResize(request)
    }

    final case class DescribeScheduledActionsOp(
      request: DescribeScheduledActionsRequest
    ) extends RedshiftOp[DescribeScheduledActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduledActionsResponse] =
        visitor.describeScheduledActions(request)
    }

    final case class DescribeSnapshotCopyGrantsOp(
      request: DescribeSnapshotCopyGrantsRequest
    ) extends RedshiftOp[DescribeSnapshotCopyGrantsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSnapshotCopyGrantsResponse] =
        visitor.describeSnapshotCopyGrants(request)
    }

    final case class DescribeSnapshotSchedulesOp(
      request: DescribeSnapshotSchedulesRequest
    ) extends RedshiftOp[DescribeSnapshotSchedulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSnapshotSchedulesResponse] =
        visitor.describeSnapshotSchedules(request)
    }

    final case class DescribeStorageOp(
      request: DescribeStorageRequest
    ) extends RedshiftOp[DescribeStorageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStorageResponse] =
        visitor.describeStorage(request)
    }

    final case class DescribeTableRestoreStatusOp(
      request: DescribeTableRestoreStatusRequest
    ) extends RedshiftOp[DescribeTableRestoreStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTableRestoreStatusResponse] =
        visitor.describeTableRestoreStatus(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends RedshiftOp[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DescribeUsageLimitsOp(
      request: DescribeUsageLimitsRequest
    ) extends RedshiftOp[DescribeUsageLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUsageLimitsResponse] =
        visitor.describeUsageLimits(request)
    }

    final case class DisableLoggingOp(
      request: DisableLoggingRequest
    ) extends RedshiftOp[DisableLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableLoggingResponse] =
        visitor.disableLogging(request)
    }

    final case class DisableSnapshotCopyOp(
      request: DisableSnapshotCopyRequest
    ) extends RedshiftOp[DisableSnapshotCopyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableSnapshotCopyResponse] =
        visitor.disableSnapshotCopy(request)
    }

    final case class EnableLoggingOp(
      request: EnableLoggingRequest
    ) extends RedshiftOp[EnableLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableLoggingResponse] =
        visitor.enableLogging(request)
    }

    final case class EnableSnapshotCopyOp(
      request: EnableSnapshotCopyRequest
    ) extends RedshiftOp[EnableSnapshotCopyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableSnapshotCopyResponse] =
        visitor.enableSnapshotCopy(request)
    }

    final case class GetClusterCredentialsOp(
      request: GetClusterCredentialsRequest
    ) extends RedshiftOp[GetClusterCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetClusterCredentialsResponse] =
        visitor.getClusterCredentials(request)
    }

    final case class GetReservedNodeExchangeOfferingsOp(
      request: GetReservedNodeExchangeOfferingsRequest
    ) extends RedshiftOp[GetReservedNodeExchangeOfferingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReservedNodeExchangeOfferingsResponse] =
        visitor.getReservedNodeExchangeOfferings(request)
    }

    final case class ModifyAquaConfigurationOp(
      request: ModifyAquaConfigurationRequest
    ) extends RedshiftOp[ModifyAquaConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyAquaConfigurationResponse] =
        visitor.modifyAquaConfiguration(request)
    }

    final case class ModifyClusterOp(
      request: ModifyClusterRequest
    ) extends RedshiftOp[ModifyClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterResponse] =
        visitor.modifyCluster(request)
    }

    final case class ModifyClusterDbRevisionOp(
      request: ModifyClusterDbRevisionRequest
    ) extends RedshiftOp[ModifyClusterDbRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterDbRevisionResponse] =
        visitor.modifyClusterDbRevision(request)
    }

    final case class ModifyClusterIamRolesOp(
      request: ModifyClusterIamRolesRequest
    ) extends RedshiftOp[ModifyClusterIamRolesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterIamRolesResponse] =
        visitor.modifyClusterIamRoles(request)
    }

    final case class ModifyClusterMaintenanceOp(
      request: ModifyClusterMaintenanceRequest
    ) extends RedshiftOp[ModifyClusterMaintenanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterMaintenanceResponse] =
        visitor.modifyClusterMaintenance(request)
    }

    final case class ModifyClusterParameterGroupOp(
      request: ModifyClusterParameterGroupRequest
    ) extends RedshiftOp[ModifyClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterParameterGroupResponse] =
        visitor.modifyClusterParameterGroup(request)
    }

    final case class ModifyClusterSnapshotOp(
      request: ModifyClusterSnapshotRequest
    ) extends RedshiftOp[ModifyClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterSnapshotResponse] =
        visitor.modifyClusterSnapshot(request)
    }

    final case class ModifyClusterSnapshotScheduleOp(
      request: ModifyClusterSnapshotScheduleRequest
    ) extends RedshiftOp[ModifyClusterSnapshotScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterSnapshotScheduleResponse] =
        visitor.modifyClusterSnapshotSchedule(request)
    }

    final case class ModifyClusterSubnetGroupOp(
      request: ModifyClusterSubnetGroupRequest
    ) extends RedshiftOp[ModifyClusterSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterSubnetGroupResponse] =
        visitor.modifyClusterSubnetGroup(request)
    }

    final case class ModifyEndpointAccessOp(
      request: ModifyEndpointAccessRequest
    ) extends RedshiftOp[ModifyEndpointAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEndpointAccessResponse] =
        visitor.modifyEndpointAccess(request)
    }

    final case class ModifyEventSubscriptionOp(
      request: ModifyEventSubscriptionRequest
    ) extends RedshiftOp[ModifyEventSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyEventSubscriptionResponse] =
        visitor.modifyEventSubscription(request)
    }

    final case class ModifyScheduledActionOp(
      request: ModifyScheduledActionRequest
    ) extends RedshiftOp[ModifyScheduledActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyScheduledActionResponse] =
        visitor.modifyScheduledAction(request)
    }

    final case class ModifySnapshotCopyRetentionPeriodOp(
      request: ModifySnapshotCopyRetentionPeriodRequest
    ) extends RedshiftOp[ModifySnapshotCopyRetentionPeriodResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifySnapshotCopyRetentionPeriodResponse] =
        visitor.modifySnapshotCopyRetentionPeriod(request)
    }

    final case class ModifySnapshotScheduleOp(
      request: ModifySnapshotScheduleRequest
    ) extends RedshiftOp[ModifySnapshotScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifySnapshotScheduleResponse] =
        visitor.modifySnapshotSchedule(request)
    }

    final case class ModifyUsageLimitOp(
      request: ModifyUsageLimitRequest
    ) extends RedshiftOp[ModifyUsageLimitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyUsageLimitResponse] =
        visitor.modifyUsageLimit(request)
    }

    final case class PauseClusterOp(
      request: PauseClusterRequest
    ) extends RedshiftOp[PauseClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PauseClusterResponse] =
        visitor.pauseCluster(request)
    }

    final case class PurchaseReservedNodeOfferingOp(
      request: PurchaseReservedNodeOfferingRequest
    ) extends RedshiftOp[PurchaseReservedNodeOfferingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PurchaseReservedNodeOfferingResponse] =
        visitor.purchaseReservedNodeOffering(request)
    }

    final case class RebootClusterOp(
      request: RebootClusterRequest
    ) extends RedshiftOp[RebootClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootClusterResponse] =
        visitor.rebootCluster(request)
    }

    final case class ResetClusterParameterGroupOp(
      request: ResetClusterParameterGroupRequest
    ) extends RedshiftOp[ResetClusterParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetClusterParameterGroupResponse] =
        visitor.resetClusterParameterGroup(request)
    }

    final case class ResizeClusterOp(
      request: ResizeClusterRequest
    ) extends RedshiftOp[ResizeClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResizeClusterResponse] =
        visitor.resizeCluster(request)
    }

    final case class RestoreFromClusterSnapshotOp(
      request: RestoreFromClusterSnapshotRequest
    ) extends RedshiftOp[RestoreFromClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreFromClusterSnapshotResponse] =
        visitor.restoreFromClusterSnapshot(request)
    }

    final case class RestoreTableFromClusterSnapshotOp(
      request: RestoreTableFromClusterSnapshotRequest
    ) extends RedshiftOp[RestoreTableFromClusterSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreTableFromClusterSnapshotResponse] =
        visitor.restoreTableFromClusterSnapshot(request)
    }

    final case class ResumeClusterOp(
      request: ResumeClusterRequest
    ) extends RedshiftOp[ResumeClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResumeClusterResponse] =
        visitor.resumeCluster(request)
    }

    final case class RevokeClusterSecurityGroupIngressOp(
      request: RevokeClusterSecurityGroupIngressRequest
    ) extends RedshiftOp[RevokeClusterSecurityGroupIngressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeClusterSecurityGroupIngressResponse] =
        visitor.revokeClusterSecurityGroupIngress(request)
    }

    final case class RevokeEndpointAccessOp(
      request: RevokeEndpointAccessRequest
    ) extends RedshiftOp[RevokeEndpointAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeEndpointAccessResponse] =
        visitor.revokeEndpointAccess(request)
    }

    final case class RevokeSnapshotAccessOp(
      request: RevokeSnapshotAccessRequest
    ) extends RedshiftOp[RevokeSnapshotAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeSnapshotAccessResponse] =
        visitor.revokeSnapshotAccess(request)
    }

    final case class RotateEncryptionKeyOp(
      request: RotateEncryptionKeyRequest
    ) extends RedshiftOp[RotateEncryptionKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RotateEncryptionKeyResponse] =
        visitor.rotateEncryptionKey(request)
    }

    final case class UpdatePartnerStatusOp(
      request: UpdatePartnerStatusRequest
    ) extends RedshiftOp[UpdatePartnerStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePartnerStatusResponse] =
        visitor.updatePartnerStatus(request)
    }
  }

  import RedshiftOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[RedshiftOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptReservedNodeExchange(
    request: AcceptReservedNodeExchangeRequest
  ): RedshiftIO[AcceptReservedNodeExchangeResponse] =
    FF.liftF(AcceptReservedNodeExchangeOp(request))

  def addPartner(
    request: AddPartnerRequest
  ): RedshiftIO[AddPartnerResponse] =
    FF.liftF(AddPartnerOp(request))

  def authorizeClusterSecurityGroupIngress(
    request: AuthorizeClusterSecurityGroupIngressRequest
  ): RedshiftIO[AuthorizeClusterSecurityGroupIngressResponse] =
    FF.liftF(AuthorizeClusterSecurityGroupIngressOp(request))

  def authorizeEndpointAccess(
    request: AuthorizeEndpointAccessRequest
  ): RedshiftIO[AuthorizeEndpointAccessResponse] =
    FF.liftF(AuthorizeEndpointAccessOp(request))

  def authorizeSnapshotAccess(
    request: AuthorizeSnapshotAccessRequest
  ): RedshiftIO[AuthorizeSnapshotAccessResponse] =
    FF.liftF(AuthorizeSnapshotAccessOp(request))

  def batchDeleteClusterSnapshots(
    request: BatchDeleteClusterSnapshotsRequest
  ): RedshiftIO[BatchDeleteClusterSnapshotsResponse] =
    FF.liftF(BatchDeleteClusterSnapshotsOp(request))

  def batchModifyClusterSnapshots(
    request: BatchModifyClusterSnapshotsRequest
  ): RedshiftIO[BatchModifyClusterSnapshotsResponse] =
    FF.liftF(BatchModifyClusterSnapshotsOp(request))

  def cancelResize(
    request: CancelResizeRequest
  ): RedshiftIO[CancelResizeResponse] =
    FF.liftF(CancelResizeOp(request))

  def copyClusterSnapshot(
    request: CopyClusterSnapshotRequest
  ): RedshiftIO[CopyClusterSnapshotResponse] =
    FF.liftF(CopyClusterSnapshotOp(request))

  def createCluster(
    request: CreateClusterRequest
  ): RedshiftIO[CreateClusterResponse] =
    FF.liftF(CreateClusterOp(request))

  def createClusterParameterGroup(
    request: CreateClusterParameterGroupRequest
  ): RedshiftIO[CreateClusterParameterGroupResponse] =
    FF.liftF(CreateClusterParameterGroupOp(request))

  def createClusterSecurityGroup(
    request: CreateClusterSecurityGroupRequest
  ): RedshiftIO[CreateClusterSecurityGroupResponse] =
    FF.liftF(CreateClusterSecurityGroupOp(request))

  def createClusterSnapshot(
    request: CreateClusterSnapshotRequest
  ): RedshiftIO[CreateClusterSnapshotResponse] =
    FF.liftF(CreateClusterSnapshotOp(request))

  def createClusterSubnetGroup(
    request: CreateClusterSubnetGroupRequest
  ): RedshiftIO[CreateClusterSubnetGroupResponse] =
    FF.liftF(CreateClusterSubnetGroupOp(request))

  def createEndpointAccess(
    request: CreateEndpointAccessRequest
  ): RedshiftIO[CreateEndpointAccessResponse] =
    FF.liftF(CreateEndpointAccessOp(request))

  def createEventSubscription(
    request: CreateEventSubscriptionRequest
  ): RedshiftIO[CreateEventSubscriptionResponse] =
    FF.liftF(CreateEventSubscriptionOp(request))

  def createHsmClientCertificate(
    request: CreateHsmClientCertificateRequest
  ): RedshiftIO[CreateHsmClientCertificateResponse] =
    FF.liftF(CreateHsmClientCertificateOp(request))

  def createHsmConfiguration(
    request: CreateHsmConfigurationRequest
  ): RedshiftIO[CreateHsmConfigurationResponse] =
    FF.liftF(CreateHsmConfigurationOp(request))

  def createScheduledAction(
    request: CreateScheduledActionRequest
  ): RedshiftIO[CreateScheduledActionResponse] =
    FF.liftF(CreateScheduledActionOp(request))

  def createSnapshotCopyGrant(
    request: CreateSnapshotCopyGrantRequest
  ): RedshiftIO[CreateSnapshotCopyGrantResponse] =
    FF.liftF(CreateSnapshotCopyGrantOp(request))

  def createSnapshotSchedule(
    request: CreateSnapshotScheduleRequest
  ): RedshiftIO[CreateSnapshotScheduleResponse] =
    FF.liftF(CreateSnapshotScheduleOp(request))

  def createTags(
    request: CreateTagsRequest
  ): RedshiftIO[CreateTagsResponse] =
    FF.liftF(CreateTagsOp(request))

  def createUsageLimit(
    request: CreateUsageLimitRequest
  ): RedshiftIO[CreateUsageLimitResponse] =
    FF.liftF(CreateUsageLimitOp(request))

  def deleteCluster(
    request: DeleteClusterRequest
  ): RedshiftIO[DeleteClusterResponse] =
    FF.liftF(DeleteClusterOp(request))

  def deleteClusterParameterGroup(
    request: DeleteClusterParameterGroupRequest
  ): RedshiftIO[DeleteClusterParameterGroupResponse] =
    FF.liftF(DeleteClusterParameterGroupOp(request))

  def deleteClusterSecurityGroup(
    request: DeleteClusterSecurityGroupRequest
  ): RedshiftIO[DeleteClusterSecurityGroupResponse] =
    FF.liftF(DeleteClusterSecurityGroupOp(request))

  def deleteClusterSnapshot(
    request: DeleteClusterSnapshotRequest
  ): RedshiftIO[DeleteClusterSnapshotResponse] =
    FF.liftF(DeleteClusterSnapshotOp(request))

  def deleteClusterSubnetGroup(
    request: DeleteClusterSubnetGroupRequest
  ): RedshiftIO[DeleteClusterSubnetGroupResponse] =
    FF.liftF(DeleteClusterSubnetGroupOp(request))

  def deleteEndpointAccess(
    request: DeleteEndpointAccessRequest
  ): RedshiftIO[DeleteEndpointAccessResponse] =
    FF.liftF(DeleteEndpointAccessOp(request))

  def deleteEventSubscription(
    request: DeleteEventSubscriptionRequest
  ): RedshiftIO[DeleteEventSubscriptionResponse] =
    FF.liftF(DeleteEventSubscriptionOp(request))

  def deleteHsmClientCertificate(
    request: DeleteHsmClientCertificateRequest
  ): RedshiftIO[DeleteHsmClientCertificateResponse] =
    FF.liftF(DeleteHsmClientCertificateOp(request))

  def deleteHsmConfiguration(
    request: DeleteHsmConfigurationRequest
  ): RedshiftIO[DeleteHsmConfigurationResponse] =
    FF.liftF(DeleteHsmConfigurationOp(request))

  def deletePartner(
    request: DeletePartnerRequest
  ): RedshiftIO[DeletePartnerResponse] =
    FF.liftF(DeletePartnerOp(request))

  def deleteScheduledAction(
    request: DeleteScheduledActionRequest
  ): RedshiftIO[DeleteScheduledActionResponse] =
    FF.liftF(DeleteScheduledActionOp(request))

  def deleteSnapshotCopyGrant(
    request: DeleteSnapshotCopyGrantRequest
  ): RedshiftIO[DeleteSnapshotCopyGrantResponse] =
    FF.liftF(DeleteSnapshotCopyGrantOp(request))

  def deleteSnapshotSchedule(
    request: DeleteSnapshotScheduleRequest
  ): RedshiftIO[DeleteSnapshotScheduleResponse] =
    FF.liftF(DeleteSnapshotScheduleOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): RedshiftIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def deleteUsageLimit(
    request: DeleteUsageLimitRequest
  ): RedshiftIO[DeleteUsageLimitResponse] =
    FF.liftF(DeleteUsageLimitOp(request))

  def describeAccountAttributes(
    request: DescribeAccountAttributesRequest
  ): RedshiftIO[DescribeAccountAttributesResponse] =
    FF.liftF(DescribeAccountAttributesOp(request))

  def describeClusterDbRevisions(
    request: DescribeClusterDbRevisionsRequest
  ): RedshiftIO[DescribeClusterDbRevisionsResponse] =
    FF.liftF(DescribeClusterDbRevisionsOp(request))

  def describeClusterParameterGroups(
    request: DescribeClusterParameterGroupsRequest
  ): RedshiftIO[DescribeClusterParameterGroupsResponse] =
    FF.liftF(DescribeClusterParameterGroupsOp(request))

  def describeClusterParameters(
    request: DescribeClusterParametersRequest
  ): RedshiftIO[DescribeClusterParametersResponse] =
    FF.liftF(DescribeClusterParametersOp(request))

  def describeClusterSecurityGroups(
    request: DescribeClusterSecurityGroupsRequest
  ): RedshiftIO[DescribeClusterSecurityGroupsResponse] =
    FF.liftF(DescribeClusterSecurityGroupsOp(request))

  def describeClusterSnapshots(
    request: DescribeClusterSnapshotsRequest
  ): RedshiftIO[DescribeClusterSnapshotsResponse] =
    FF.liftF(DescribeClusterSnapshotsOp(request))

  def describeClusterSubnetGroups(
    request: DescribeClusterSubnetGroupsRequest
  ): RedshiftIO[DescribeClusterSubnetGroupsResponse] =
    FF.liftF(DescribeClusterSubnetGroupsOp(request))

  def describeClusterTracks(
    request: DescribeClusterTracksRequest
  ): RedshiftIO[DescribeClusterTracksResponse] =
    FF.liftF(DescribeClusterTracksOp(request))

  def describeClusterVersions(
    request: DescribeClusterVersionsRequest
  ): RedshiftIO[DescribeClusterVersionsResponse] =
    FF.liftF(DescribeClusterVersionsOp(request))

  def describeClusters(
    request: DescribeClustersRequest
  ): RedshiftIO[DescribeClustersResponse] =
    FF.liftF(DescribeClustersOp(request))

  def describeDefaultClusterParameters(
    request: DescribeDefaultClusterParametersRequest
  ): RedshiftIO[DescribeDefaultClusterParametersResponse] =
    FF.liftF(DescribeDefaultClusterParametersOp(request))

  def describeEndpointAccess(
    request: DescribeEndpointAccessRequest
  ): RedshiftIO[DescribeEndpointAccessResponse] =
    FF.liftF(DescribeEndpointAccessOp(request))

  def describeEndpointAuthorization(
    request: DescribeEndpointAuthorizationRequest
  ): RedshiftIO[DescribeEndpointAuthorizationResponse] =
    FF.liftF(DescribeEndpointAuthorizationOp(request))

  def describeEventCategories(
    request: DescribeEventCategoriesRequest
  ): RedshiftIO[DescribeEventCategoriesResponse] =
    FF.liftF(DescribeEventCategoriesOp(request))

  def describeEventSubscriptions(
    request: DescribeEventSubscriptionsRequest
  ): RedshiftIO[DescribeEventSubscriptionsResponse] =
    FF.liftF(DescribeEventSubscriptionsOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): RedshiftIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeHsmClientCertificates(
    request: DescribeHsmClientCertificatesRequest
  ): RedshiftIO[DescribeHsmClientCertificatesResponse] =
    FF.liftF(DescribeHsmClientCertificatesOp(request))

  def describeHsmConfigurations(
    request: DescribeHsmConfigurationsRequest
  ): RedshiftIO[DescribeHsmConfigurationsResponse] =
    FF.liftF(DescribeHsmConfigurationsOp(request))

  def describeLoggingStatus(
    request: DescribeLoggingStatusRequest
  ): RedshiftIO[DescribeLoggingStatusResponse] =
    FF.liftF(DescribeLoggingStatusOp(request))

  def describeNodeConfigurationOptions(
    request: DescribeNodeConfigurationOptionsRequest
  ): RedshiftIO[DescribeNodeConfigurationOptionsResponse] =
    FF.liftF(DescribeNodeConfigurationOptionsOp(request))

  def describeOrderableClusterOptions(
    request: DescribeOrderableClusterOptionsRequest
  ): RedshiftIO[DescribeOrderableClusterOptionsResponse] =
    FF.liftF(DescribeOrderableClusterOptionsOp(request))

  def describePartners(
    request: DescribePartnersRequest
  ): RedshiftIO[DescribePartnersResponse] =
    FF.liftF(DescribePartnersOp(request))

  def describeReservedNodeOfferings(
    request: DescribeReservedNodeOfferingsRequest
  ): RedshiftIO[DescribeReservedNodeOfferingsResponse] =
    FF.liftF(DescribeReservedNodeOfferingsOp(request))

  def describeReservedNodes(
    request: DescribeReservedNodesRequest
  ): RedshiftIO[DescribeReservedNodesResponse] =
    FF.liftF(DescribeReservedNodesOp(request))

  def describeResize(
    request: DescribeResizeRequest
  ): RedshiftIO[DescribeResizeResponse] =
    FF.liftF(DescribeResizeOp(request))

  def describeScheduledActions(
    request: DescribeScheduledActionsRequest
  ): RedshiftIO[DescribeScheduledActionsResponse] =
    FF.liftF(DescribeScheduledActionsOp(request))

  def describeSnapshotCopyGrants(
    request: DescribeSnapshotCopyGrantsRequest
  ): RedshiftIO[DescribeSnapshotCopyGrantsResponse] =
    FF.liftF(DescribeSnapshotCopyGrantsOp(request))

  def describeSnapshotSchedules(
    request: DescribeSnapshotSchedulesRequest
  ): RedshiftIO[DescribeSnapshotSchedulesResponse] =
    FF.liftF(DescribeSnapshotSchedulesOp(request))

  def describeStorage(
    request: DescribeStorageRequest
  ): RedshiftIO[DescribeStorageResponse] =
    FF.liftF(DescribeStorageOp(request))

  def describeTableRestoreStatus(
    request: DescribeTableRestoreStatusRequest
  ): RedshiftIO[DescribeTableRestoreStatusResponse] =
    FF.liftF(DescribeTableRestoreStatusOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): RedshiftIO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def describeUsageLimits(
    request: DescribeUsageLimitsRequest
  ): RedshiftIO[DescribeUsageLimitsResponse] =
    FF.liftF(DescribeUsageLimitsOp(request))

  def disableLogging(
    request: DisableLoggingRequest
  ): RedshiftIO[DisableLoggingResponse] =
    FF.liftF(DisableLoggingOp(request))

  def disableSnapshotCopy(
    request: DisableSnapshotCopyRequest
  ): RedshiftIO[DisableSnapshotCopyResponse] =
    FF.liftF(DisableSnapshotCopyOp(request))

  def enableLogging(
    request: EnableLoggingRequest
  ): RedshiftIO[EnableLoggingResponse] =
    FF.liftF(EnableLoggingOp(request))

  def enableSnapshotCopy(
    request: EnableSnapshotCopyRequest
  ): RedshiftIO[EnableSnapshotCopyResponse] =
    FF.liftF(EnableSnapshotCopyOp(request))

  def getClusterCredentials(
    request: GetClusterCredentialsRequest
  ): RedshiftIO[GetClusterCredentialsResponse] =
    FF.liftF(GetClusterCredentialsOp(request))

  def getReservedNodeExchangeOfferings(
    request: GetReservedNodeExchangeOfferingsRequest
  ): RedshiftIO[GetReservedNodeExchangeOfferingsResponse] =
    FF.liftF(GetReservedNodeExchangeOfferingsOp(request))

  def modifyAquaConfiguration(
    request: ModifyAquaConfigurationRequest
  ): RedshiftIO[ModifyAquaConfigurationResponse] =
    FF.liftF(ModifyAquaConfigurationOp(request))

  def modifyCluster(
    request: ModifyClusterRequest
  ): RedshiftIO[ModifyClusterResponse] =
    FF.liftF(ModifyClusterOp(request))

  def modifyClusterDbRevision(
    request: ModifyClusterDbRevisionRequest
  ): RedshiftIO[ModifyClusterDbRevisionResponse] =
    FF.liftF(ModifyClusterDbRevisionOp(request))

  def modifyClusterIamRoles(
    request: ModifyClusterIamRolesRequest
  ): RedshiftIO[ModifyClusterIamRolesResponse] =
    FF.liftF(ModifyClusterIamRolesOp(request))

  def modifyClusterMaintenance(
    request: ModifyClusterMaintenanceRequest
  ): RedshiftIO[ModifyClusterMaintenanceResponse] =
    FF.liftF(ModifyClusterMaintenanceOp(request))

  def modifyClusterParameterGroup(
    request: ModifyClusterParameterGroupRequest
  ): RedshiftIO[ModifyClusterParameterGroupResponse] =
    FF.liftF(ModifyClusterParameterGroupOp(request))

  def modifyClusterSnapshot(
    request: ModifyClusterSnapshotRequest
  ): RedshiftIO[ModifyClusterSnapshotResponse] =
    FF.liftF(ModifyClusterSnapshotOp(request))

  def modifyClusterSnapshotSchedule(
    request: ModifyClusterSnapshotScheduleRequest
  ): RedshiftIO[ModifyClusterSnapshotScheduleResponse] =
    FF.liftF(ModifyClusterSnapshotScheduleOp(request))

  def modifyClusterSubnetGroup(
    request: ModifyClusterSubnetGroupRequest
  ): RedshiftIO[ModifyClusterSubnetGroupResponse] =
    FF.liftF(ModifyClusterSubnetGroupOp(request))

  def modifyEndpointAccess(
    request: ModifyEndpointAccessRequest
  ): RedshiftIO[ModifyEndpointAccessResponse] =
    FF.liftF(ModifyEndpointAccessOp(request))

  def modifyEventSubscription(
    request: ModifyEventSubscriptionRequest
  ): RedshiftIO[ModifyEventSubscriptionResponse] =
    FF.liftF(ModifyEventSubscriptionOp(request))

  def modifyScheduledAction(
    request: ModifyScheduledActionRequest
  ): RedshiftIO[ModifyScheduledActionResponse] =
    FF.liftF(ModifyScheduledActionOp(request))

  def modifySnapshotCopyRetentionPeriod(
    request: ModifySnapshotCopyRetentionPeriodRequest
  ): RedshiftIO[ModifySnapshotCopyRetentionPeriodResponse] =
    FF.liftF(ModifySnapshotCopyRetentionPeriodOp(request))

  def modifySnapshotSchedule(
    request: ModifySnapshotScheduleRequest
  ): RedshiftIO[ModifySnapshotScheduleResponse] =
    FF.liftF(ModifySnapshotScheduleOp(request))

  def modifyUsageLimit(
    request: ModifyUsageLimitRequest
  ): RedshiftIO[ModifyUsageLimitResponse] =
    FF.liftF(ModifyUsageLimitOp(request))

  def pauseCluster(
    request: PauseClusterRequest
  ): RedshiftIO[PauseClusterResponse] =
    FF.liftF(PauseClusterOp(request))

  def purchaseReservedNodeOffering(
    request: PurchaseReservedNodeOfferingRequest
  ): RedshiftIO[PurchaseReservedNodeOfferingResponse] =
    FF.liftF(PurchaseReservedNodeOfferingOp(request))

  def rebootCluster(
    request: RebootClusterRequest
  ): RedshiftIO[RebootClusterResponse] =
    FF.liftF(RebootClusterOp(request))

  def resetClusterParameterGroup(
    request: ResetClusterParameterGroupRequest
  ): RedshiftIO[ResetClusterParameterGroupResponse] =
    FF.liftF(ResetClusterParameterGroupOp(request))

  def resizeCluster(
    request: ResizeClusterRequest
  ): RedshiftIO[ResizeClusterResponse] =
    FF.liftF(ResizeClusterOp(request))

  def restoreFromClusterSnapshot(
    request: RestoreFromClusterSnapshotRequest
  ): RedshiftIO[RestoreFromClusterSnapshotResponse] =
    FF.liftF(RestoreFromClusterSnapshotOp(request))

  def restoreTableFromClusterSnapshot(
    request: RestoreTableFromClusterSnapshotRequest
  ): RedshiftIO[RestoreTableFromClusterSnapshotResponse] =
    FF.liftF(RestoreTableFromClusterSnapshotOp(request))

  def resumeCluster(
    request: ResumeClusterRequest
  ): RedshiftIO[ResumeClusterResponse] =
    FF.liftF(ResumeClusterOp(request))

  def revokeClusterSecurityGroupIngress(
    request: RevokeClusterSecurityGroupIngressRequest
  ): RedshiftIO[RevokeClusterSecurityGroupIngressResponse] =
    FF.liftF(RevokeClusterSecurityGroupIngressOp(request))

  def revokeEndpointAccess(
    request: RevokeEndpointAccessRequest
  ): RedshiftIO[RevokeEndpointAccessResponse] =
    FF.liftF(RevokeEndpointAccessOp(request))

  def revokeSnapshotAccess(
    request: RevokeSnapshotAccessRequest
  ): RedshiftIO[RevokeSnapshotAccessResponse] =
    FF.liftF(RevokeSnapshotAccessOp(request))

  def rotateEncryptionKey(
    request: RotateEncryptionKeyRequest
  ): RedshiftIO[RotateEncryptionKeyResponse] =
    FF.liftF(RotateEncryptionKeyOp(request))

  def updatePartnerStatus(
    request: UpdatePartnerStatusRequest
  ): RedshiftIO[UpdatePartnerStatusResponse] =
    FF.liftF(UpdatePartnerStatusOp(request))
}
