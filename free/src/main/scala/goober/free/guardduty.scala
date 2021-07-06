package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.guardduty.GuardDutyClient
import software.amazon.awssdk.services.guardduty.model._


object guardduty { module =>

  // Free monad over GuardDutyOp
  type GuardDutyIO[A] = FF[GuardDutyOp, A]

  sealed trait GuardDutyOp[A] {
    def visit[F[_]](visitor: GuardDutyOp.Visitor[F]): F[A]
  }

  object GuardDutyOp {
    // Given a GuardDutyClient we can embed a GuardDutyIO program in any algebra that understands embedding.
    implicit val GuardDutyOpEmbeddable: Embeddable[GuardDutyOp, GuardDutyClient] = new Embeddable[GuardDutyOp, GuardDutyClient] {
      def embed[A](client: GuardDutyClient, io: GuardDutyIO[A]): Embedded[A] = Embedded.GuardDuty(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GuardDutyOp.Visitor[Kleisli[M, GuardDutyClient, *]] {
        def acceptInvitation(
          request: AcceptInvitationRequest
        ): Kleisli[M, GuardDutyClient, AcceptInvitationResponse] =
          primitive(_.acceptInvitation(request))

        def archiveFindings(
          request: ArchiveFindingsRequest
        ): Kleisli[M, GuardDutyClient, ArchiveFindingsResponse] =
          primitive(_.archiveFindings(request))

        def createDetector(
          request: CreateDetectorRequest
        ): Kleisli[M, GuardDutyClient, CreateDetectorResponse] =
          primitive(_.createDetector(request))

        def createFilter(
          request: CreateFilterRequest
        ): Kleisli[M, GuardDutyClient, CreateFilterResponse] =
          primitive(_.createFilter(request))

        def createIPSet(
          request: CreateIpSetRequest
        ): Kleisli[M, GuardDutyClient, CreateIpSetResponse] =
          primitive(_.createIPSet(request))

        def createMembers(
          request: CreateMembersRequest
        ): Kleisli[M, GuardDutyClient, CreateMembersResponse] =
          primitive(_.createMembers(request))

        def createPublishingDestination(
          request: CreatePublishingDestinationRequest
        ): Kleisli[M, GuardDutyClient, CreatePublishingDestinationResponse] =
          primitive(_.createPublishingDestination(request))

        def createSampleFindings(
          request: CreateSampleFindingsRequest
        ): Kleisli[M, GuardDutyClient, CreateSampleFindingsResponse] =
          primitive(_.createSampleFindings(request))

        def createThreatIntelSet(
          request: CreateThreatIntelSetRequest
        ): Kleisli[M, GuardDutyClient, CreateThreatIntelSetResponse] =
          primitive(_.createThreatIntelSet(request))

        def declineInvitations(
          request: DeclineInvitationsRequest
        ): Kleisli[M, GuardDutyClient, DeclineInvitationsResponse] =
          primitive(_.declineInvitations(request))

        def deleteDetector(
          request: DeleteDetectorRequest
        ): Kleisli[M, GuardDutyClient, DeleteDetectorResponse] =
          primitive(_.deleteDetector(request))

        def deleteFilter(
          request: DeleteFilterRequest
        ): Kleisli[M, GuardDutyClient, DeleteFilterResponse] =
          primitive(_.deleteFilter(request))

        def deleteIPSet(
          request: DeleteIpSetRequest
        ): Kleisli[M, GuardDutyClient, DeleteIpSetResponse] =
          primitive(_.deleteIPSet(request))

        def deleteInvitations(
          request: DeleteInvitationsRequest
        ): Kleisli[M, GuardDutyClient, DeleteInvitationsResponse] =
          primitive(_.deleteInvitations(request))

        def deleteMembers(
          request: DeleteMembersRequest
        ): Kleisli[M, GuardDutyClient, DeleteMembersResponse] =
          primitive(_.deleteMembers(request))

        def deletePublishingDestination(
          request: DeletePublishingDestinationRequest
        ): Kleisli[M, GuardDutyClient, DeletePublishingDestinationResponse] =
          primitive(_.deletePublishingDestination(request))

        def deleteThreatIntelSet(
          request: DeleteThreatIntelSetRequest
        ): Kleisli[M, GuardDutyClient, DeleteThreatIntelSetResponse] =
          primitive(_.deleteThreatIntelSet(request))

        def describeOrganizationConfiguration(
          request: DescribeOrganizationConfigurationRequest
        ): Kleisli[M, GuardDutyClient, DescribeOrganizationConfigurationResponse] =
          primitive(_.describeOrganizationConfiguration(request))

        def describePublishingDestination(
          request: DescribePublishingDestinationRequest
        ): Kleisli[M, GuardDutyClient, DescribePublishingDestinationResponse] =
          primitive(_.describePublishingDestination(request))

        def disableOrganizationAdminAccount(
          request: DisableOrganizationAdminAccountRequest
        ): Kleisli[M, GuardDutyClient, DisableOrganizationAdminAccountResponse] =
          primitive(_.disableOrganizationAdminAccount(request))

        def disassociateFromMasterAccount(
          request: DisassociateFromMasterAccountRequest
        ): Kleisli[M, GuardDutyClient, DisassociateFromMasterAccountResponse] =
          primitive(_.disassociateFromMasterAccount(request))

        def disassociateMembers(
          request: DisassociateMembersRequest
        ): Kleisli[M, GuardDutyClient, DisassociateMembersResponse] =
          primitive(_.disassociateMembers(request))

        def enableOrganizationAdminAccount(
          request: EnableOrganizationAdminAccountRequest
        ): Kleisli[M, GuardDutyClient, EnableOrganizationAdminAccountResponse] =
          primitive(_.enableOrganizationAdminAccount(request))

        def getDetector(
          request: GetDetectorRequest
        ): Kleisli[M, GuardDutyClient, GetDetectorResponse] =
          primitive(_.getDetector(request))

        def getFilter(
          request: GetFilterRequest
        ): Kleisli[M, GuardDutyClient, GetFilterResponse] =
          primitive(_.getFilter(request))

        def getFindings(
          request: GetFindingsRequest
        ): Kleisli[M, GuardDutyClient, GetFindingsResponse] =
          primitive(_.getFindings(request))

        def getFindingsStatistics(
          request: GetFindingsStatisticsRequest
        ): Kleisli[M, GuardDutyClient, GetFindingsStatisticsResponse] =
          primitive(_.getFindingsStatistics(request))

        def getIPSet(
          request: GetIpSetRequest
        ): Kleisli[M, GuardDutyClient, GetIpSetResponse] =
          primitive(_.getIPSet(request))

        def getInvitationsCount(
          request: GetInvitationsCountRequest
        ): Kleisli[M, GuardDutyClient, GetInvitationsCountResponse] =
          primitive(_.getInvitationsCount(request))

        def getMasterAccount(
          request: GetMasterAccountRequest
        ): Kleisli[M, GuardDutyClient, GetMasterAccountResponse] =
          primitive(_.getMasterAccount(request))

        def getMemberDetectors(
          request: GetMemberDetectorsRequest
        ): Kleisli[M, GuardDutyClient, GetMemberDetectorsResponse] =
          primitive(_.getMemberDetectors(request))

        def getMembers(
          request: GetMembersRequest
        ): Kleisli[M, GuardDutyClient, GetMembersResponse] =
          primitive(_.getMembers(request))

        def getThreatIntelSet(
          request: GetThreatIntelSetRequest
        ): Kleisli[M, GuardDutyClient, GetThreatIntelSetResponse] =
          primitive(_.getThreatIntelSet(request))

        def getUsageStatistics(
          request: GetUsageStatisticsRequest
        ): Kleisli[M, GuardDutyClient, GetUsageStatisticsResponse] =
          primitive(_.getUsageStatistics(request))

        def inviteMembers(
          request: InviteMembersRequest
        ): Kleisli[M, GuardDutyClient, InviteMembersResponse] =
          primitive(_.inviteMembers(request))

        def listDetectors(
          request: ListDetectorsRequest
        ): Kleisli[M, GuardDutyClient, ListDetectorsResponse] =
          primitive(_.listDetectors(request))

        def listFilters(
          request: ListFiltersRequest
        ): Kleisli[M, GuardDutyClient, ListFiltersResponse] =
          primitive(_.listFilters(request))

        def listFindings(
          request: ListFindingsRequest
        ): Kleisli[M, GuardDutyClient, ListFindingsResponse] =
          primitive(_.listFindings(request))

        def listIPSets(
          request: ListIpSetsRequest
        ): Kleisli[M, GuardDutyClient, ListIpSetsResponse] =
          primitive(_.listIPSets(request))

        def listInvitations(
          request: ListInvitationsRequest
        ): Kleisli[M, GuardDutyClient, ListInvitationsResponse] =
          primitive(_.listInvitations(request))

        def listMembers(
          request: ListMembersRequest
        ): Kleisli[M, GuardDutyClient, ListMembersResponse] =
          primitive(_.listMembers(request))

        def listOrganizationAdminAccounts(
          request: ListOrganizationAdminAccountsRequest
        ): Kleisli[M, GuardDutyClient, ListOrganizationAdminAccountsResponse] =
          primitive(_.listOrganizationAdminAccounts(request))

        def listPublishingDestinations(
          request: ListPublishingDestinationsRequest
        ): Kleisli[M, GuardDutyClient, ListPublishingDestinationsResponse] =
          primitive(_.listPublishingDestinations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, GuardDutyClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listThreatIntelSets(
          request: ListThreatIntelSetsRequest
        ): Kleisli[M, GuardDutyClient, ListThreatIntelSetsResponse] =
          primitive(_.listThreatIntelSets(request))

        def startMonitoringMembers(
          request: StartMonitoringMembersRequest
        ): Kleisli[M, GuardDutyClient, StartMonitoringMembersResponse] =
          primitive(_.startMonitoringMembers(request))

        def stopMonitoringMembers(
          request: StopMonitoringMembersRequest
        ): Kleisli[M, GuardDutyClient, StopMonitoringMembersResponse] =
          primitive(_.stopMonitoringMembers(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, GuardDutyClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def unarchiveFindings(
          request: UnarchiveFindingsRequest
        ): Kleisli[M, GuardDutyClient, UnarchiveFindingsResponse] =
          primitive(_.unarchiveFindings(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, GuardDutyClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDetector(
          request: UpdateDetectorRequest
        ): Kleisli[M, GuardDutyClient, UpdateDetectorResponse] =
          primitive(_.updateDetector(request))

        def updateFilter(
          request: UpdateFilterRequest
        ): Kleisli[M, GuardDutyClient, UpdateFilterResponse] =
          primitive(_.updateFilter(request))

        def updateFindingsFeedback(
          request: UpdateFindingsFeedbackRequest
        ): Kleisli[M, GuardDutyClient, UpdateFindingsFeedbackResponse] =
          primitive(_.updateFindingsFeedback(request))

        def updateIPSet(
          request: UpdateIpSetRequest
        ): Kleisli[M, GuardDutyClient, UpdateIpSetResponse] =
          primitive(_.updateIPSet(request))

        def updateMemberDetectors(
          request: UpdateMemberDetectorsRequest
        ): Kleisli[M, GuardDutyClient, UpdateMemberDetectorsResponse] =
          primitive(_.updateMemberDetectors(request))

        def updateOrganizationConfiguration(
          request: UpdateOrganizationConfigurationRequest
        ): Kleisli[M, GuardDutyClient, UpdateOrganizationConfigurationResponse] =
          primitive(_.updateOrganizationConfiguration(request))

        def updatePublishingDestination(
          request: UpdatePublishingDestinationRequest
        ): Kleisli[M, GuardDutyClient, UpdatePublishingDestinationResponse] =
          primitive(_.updatePublishingDestination(request))

        def updateThreatIntelSet(
          request: UpdateThreatIntelSetRequest
        ): Kleisli[M, GuardDutyClient, UpdateThreatIntelSetResponse] =
          primitive(_.updateThreatIntelSet(request))

        def primitive[A](
          f: GuardDutyClient => A
        ): Kleisli[M, GuardDutyClient, A]
      }
    }

    trait Visitor[F[_]] extends (GuardDutyOp ~> F) {
      final def apply[A](op: GuardDutyOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptInvitation(
        request: AcceptInvitationRequest
      ): F[AcceptInvitationResponse]

      def archiveFindings(
        request: ArchiveFindingsRequest
      ): F[ArchiveFindingsResponse]

      def createDetector(
        request: CreateDetectorRequest
      ): F[CreateDetectorResponse]

      def createFilter(
        request: CreateFilterRequest
      ): F[CreateFilterResponse]

      def createIPSet(
        request: CreateIpSetRequest
      ): F[CreateIpSetResponse]

      def createMembers(
        request: CreateMembersRequest
      ): F[CreateMembersResponse]

      def createPublishingDestination(
        request: CreatePublishingDestinationRequest
      ): F[CreatePublishingDestinationResponse]

      def createSampleFindings(
        request: CreateSampleFindingsRequest
      ): F[CreateSampleFindingsResponse]

      def createThreatIntelSet(
        request: CreateThreatIntelSetRequest
      ): F[CreateThreatIntelSetResponse]

      def declineInvitations(
        request: DeclineInvitationsRequest
      ): F[DeclineInvitationsResponse]

      def deleteDetector(
        request: DeleteDetectorRequest
      ): F[DeleteDetectorResponse]

      def deleteFilter(
        request: DeleteFilterRequest
      ): F[DeleteFilterResponse]

      def deleteIPSet(
        request: DeleteIpSetRequest
      ): F[DeleteIpSetResponse]

      def deleteInvitations(
        request: DeleteInvitationsRequest
      ): F[DeleteInvitationsResponse]

      def deleteMembers(
        request: DeleteMembersRequest
      ): F[DeleteMembersResponse]

      def deletePublishingDestination(
        request: DeletePublishingDestinationRequest
      ): F[DeletePublishingDestinationResponse]

      def deleteThreatIntelSet(
        request: DeleteThreatIntelSetRequest
      ): F[DeleteThreatIntelSetResponse]

      def describeOrganizationConfiguration(
        request: DescribeOrganizationConfigurationRequest
      ): F[DescribeOrganizationConfigurationResponse]

      def describePublishingDestination(
        request: DescribePublishingDestinationRequest
      ): F[DescribePublishingDestinationResponse]

      def disableOrganizationAdminAccount(
        request: DisableOrganizationAdminAccountRequest
      ): F[DisableOrganizationAdminAccountResponse]

      def disassociateFromMasterAccount(
        request: DisassociateFromMasterAccountRequest
      ): F[DisassociateFromMasterAccountResponse]

      def disassociateMembers(
        request: DisassociateMembersRequest
      ): F[DisassociateMembersResponse]

      def enableOrganizationAdminAccount(
        request: EnableOrganizationAdminAccountRequest
      ): F[EnableOrganizationAdminAccountResponse]

      def getDetector(
        request: GetDetectorRequest
      ): F[GetDetectorResponse]

      def getFilter(
        request: GetFilterRequest
      ): F[GetFilterResponse]

      def getFindings(
        request: GetFindingsRequest
      ): F[GetFindingsResponse]

      def getFindingsStatistics(
        request: GetFindingsStatisticsRequest
      ): F[GetFindingsStatisticsResponse]

      def getIPSet(
        request: GetIpSetRequest
      ): F[GetIpSetResponse]

      def getInvitationsCount(
        request: GetInvitationsCountRequest
      ): F[GetInvitationsCountResponse]

      def getMasterAccount(
        request: GetMasterAccountRequest
      ): F[GetMasterAccountResponse]

      def getMemberDetectors(
        request: GetMemberDetectorsRequest
      ): F[GetMemberDetectorsResponse]

      def getMembers(
        request: GetMembersRequest
      ): F[GetMembersResponse]

      def getThreatIntelSet(
        request: GetThreatIntelSetRequest
      ): F[GetThreatIntelSetResponse]

      def getUsageStatistics(
        request: GetUsageStatisticsRequest
      ): F[GetUsageStatisticsResponse]

      def inviteMembers(
        request: InviteMembersRequest
      ): F[InviteMembersResponse]

      def listDetectors(
        request: ListDetectorsRequest
      ): F[ListDetectorsResponse]

      def listFilters(
        request: ListFiltersRequest
      ): F[ListFiltersResponse]

      def listFindings(
        request: ListFindingsRequest
      ): F[ListFindingsResponse]

      def listIPSets(
        request: ListIpSetsRequest
      ): F[ListIpSetsResponse]

      def listInvitations(
        request: ListInvitationsRequest
      ): F[ListInvitationsResponse]

      def listMembers(
        request: ListMembersRequest
      ): F[ListMembersResponse]

      def listOrganizationAdminAccounts(
        request: ListOrganizationAdminAccountsRequest
      ): F[ListOrganizationAdminAccountsResponse]

      def listPublishingDestinations(
        request: ListPublishingDestinationsRequest
      ): F[ListPublishingDestinationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listThreatIntelSets(
        request: ListThreatIntelSetsRequest
      ): F[ListThreatIntelSetsResponse]

      def startMonitoringMembers(
        request: StartMonitoringMembersRequest
      ): F[StartMonitoringMembersResponse]

      def stopMonitoringMembers(
        request: StopMonitoringMembersRequest
      ): F[StopMonitoringMembersResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def unarchiveFindings(
        request: UnarchiveFindingsRequest
      ): F[UnarchiveFindingsResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDetector(
        request: UpdateDetectorRequest
      ): F[UpdateDetectorResponse]

      def updateFilter(
        request: UpdateFilterRequest
      ): F[UpdateFilterResponse]

      def updateFindingsFeedback(
        request: UpdateFindingsFeedbackRequest
      ): F[UpdateFindingsFeedbackResponse]

      def updateIPSet(
        request: UpdateIpSetRequest
      ): F[UpdateIpSetResponse]

      def updateMemberDetectors(
        request: UpdateMemberDetectorsRequest
      ): F[UpdateMemberDetectorsResponse]

      def updateOrganizationConfiguration(
        request: UpdateOrganizationConfigurationRequest
      ): F[UpdateOrganizationConfigurationResponse]

      def updatePublishingDestination(
        request: UpdatePublishingDestinationRequest
      ): F[UpdatePublishingDestinationResponse]

      def updateThreatIntelSet(
        request: UpdateThreatIntelSetRequest
      ): F[UpdateThreatIntelSetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GuardDutyOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptInvitationOp(
      request: AcceptInvitationRequest
    ) extends GuardDutyOp[AcceptInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptInvitationResponse] =
        visitor.acceptInvitation(request)
    }

    final case class ArchiveFindingsOp(
      request: ArchiveFindingsRequest
    ) extends GuardDutyOp[ArchiveFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ArchiveFindingsResponse] =
        visitor.archiveFindings(request)
    }

    final case class CreateDetectorOp(
      request: CreateDetectorRequest
    ) extends GuardDutyOp[CreateDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDetectorResponse] =
        visitor.createDetector(request)
    }

    final case class CreateFilterOp(
      request: CreateFilterRequest
    ) extends GuardDutyOp[CreateFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFilterResponse] =
        visitor.createFilter(request)
    }

    final case class CreateIPSetOp(
      request: CreateIpSetRequest
    ) extends GuardDutyOp[CreateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIpSetResponse] =
        visitor.createIPSet(request)
    }

    final case class CreateMembersOp(
      request: CreateMembersRequest
    ) extends GuardDutyOp[CreateMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMembersResponse] =
        visitor.createMembers(request)
    }

    final case class CreatePublishingDestinationOp(
      request: CreatePublishingDestinationRequest
    ) extends GuardDutyOp[CreatePublishingDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePublishingDestinationResponse] =
        visitor.createPublishingDestination(request)
    }

    final case class CreateSampleFindingsOp(
      request: CreateSampleFindingsRequest
    ) extends GuardDutyOp[CreateSampleFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSampleFindingsResponse] =
        visitor.createSampleFindings(request)
    }

    final case class CreateThreatIntelSetOp(
      request: CreateThreatIntelSetRequest
    ) extends GuardDutyOp[CreateThreatIntelSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateThreatIntelSetResponse] =
        visitor.createThreatIntelSet(request)
    }

    final case class DeclineInvitationsOp(
      request: DeclineInvitationsRequest
    ) extends GuardDutyOp[DeclineInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeclineInvitationsResponse] =
        visitor.declineInvitations(request)
    }

    final case class DeleteDetectorOp(
      request: DeleteDetectorRequest
    ) extends GuardDutyOp[DeleteDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDetectorResponse] =
        visitor.deleteDetector(request)
    }

    final case class DeleteFilterOp(
      request: DeleteFilterRequest
    ) extends GuardDutyOp[DeleteFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFilterResponse] =
        visitor.deleteFilter(request)
    }

    final case class DeleteIPSetOp(
      request: DeleteIpSetRequest
    ) extends GuardDutyOp[DeleteIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIpSetResponse] =
        visitor.deleteIPSet(request)
    }

    final case class DeleteInvitationsOp(
      request: DeleteInvitationsRequest
    ) extends GuardDutyOp[DeleteInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInvitationsResponse] =
        visitor.deleteInvitations(request)
    }

    final case class DeleteMembersOp(
      request: DeleteMembersRequest
    ) extends GuardDutyOp[DeleteMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMembersResponse] =
        visitor.deleteMembers(request)
    }

    final case class DeletePublishingDestinationOp(
      request: DeletePublishingDestinationRequest
    ) extends GuardDutyOp[DeletePublishingDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePublishingDestinationResponse] =
        visitor.deletePublishingDestination(request)
    }

    final case class DeleteThreatIntelSetOp(
      request: DeleteThreatIntelSetRequest
    ) extends GuardDutyOp[DeleteThreatIntelSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThreatIntelSetResponse] =
        visitor.deleteThreatIntelSet(request)
    }

    final case class DescribeOrganizationConfigurationOp(
      request: DescribeOrganizationConfigurationRequest
    ) extends GuardDutyOp[DescribeOrganizationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationConfigurationResponse] =
        visitor.describeOrganizationConfiguration(request)
    }

    final case class DescribePublishingDestinationOp(
      request: DescribePublishingDestinationRequest
    ) extends GuardDutyOp[DescribePublishingDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePublishingDestinationResponse] =
        visitor.describePublishingDestination(request)
    }

    final case class DisableOrganizationAdminAccountOp(
      request: DisableOrganizationAdminAccountRequest
    ) extends GuardDutyOp[DisableOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableOrganizationAdminAccountResponse] =
        visitor.disableOrganizationAdminAccount(request)
    }

    final case class DisassociateFromMasterAccountOp(
      request: DisassociateFromMasterAccountRequest
    ) extends GuardDutyOp[DisassociateFromMasterAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFromMasterAccountResponse] =
        visitor.disassociateFromMasterAccount(request)
    }

    final case class DisassociateMembersOp(
      request: DisassociateMembersRequest
    ) extends GuardDutyOp[DisassociateMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateMembersResponse] =
        visitor.disassociateMembers(request)
    }

    final case class EnableOrganizationAdminAccountOp(
      request: EnableOrganizationAdminAccountRequest
    ) extends GuardDutyOp[EnableOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableOrganizationAdminAccountResponse] =
        visitor.enableOrganizationAdminAccount(request)
    }

    final case class GetDetectorOp(
      request: GetDetectorRequest
    ) extends GuardDutyOp[GetDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDetectorResponse] =
        visitor.getDetector(request)
    }

    final case class GetFilterOp(
      request: GetFilterRequest
    ) extends GuardDutyOp[GetFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFilterResponse] =
        visitor.getFilter(request)
    }

    final case class GetFindingsOp(
      request: GetFindingsRequest
    ) extends GuardDutyOp[GetFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingsResponse] =
        visitor.getFindings(request)
    }

    final case class GetFindingsStatisticsOp(
      request: GetFindingsStatisticsRequest
    ) extends GuardDutyOp[GetFindingsStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingsStatisticsResponse] =
        visitor.getFindingsStatistics(request)
    }

    final case class GetIPSetOp(
      request: GetIpSetRequest
    ) extends GuardDutyOp[GetIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIpSetResponse] =
        visitor.getIPSet(request)
    }

    final case class GetInvitationsCountOp(
      request: GetInvitationsCountRequest
    ) extends GuardDutyOp[GetInvitationsCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInvitationsCountResponse] =
        visitor.getInvitationsCount(request)
    }

    final case class GetMasterAccountOp(
      request: GetMasterAccountRequest
    ) extends GuardDutyOp[GetMasterAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMasterAccountResponse] =
        visitor.getMasterAccount(request)
    }

    final case class GetMemberDetectorsOp(
      request: GetMemberDetectorsRequest
    ) extends GuardDutyOp[GetMemberDetectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMemberDetectorsResponse] =
        visitor.getMemberDetectors(request)
    }

    final case class GetMembersOp(
      request: GetMembersRequest
    ) extends GuardDutyOp[GetMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMembersResponse] =
        visitor.getMembers(request)
    }

    final case class GetThreatIntelSetOp(
      request: GetThreatIntelSetRequest
    ) extends GuardDutyOp[GetThreatIntelSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetThreatIntelSetResponse] =
        visitor.getThreatIntelSet(request)
    }

    final case class GetUsageStatisticsOp(
      request: GetUsageStatisticsRequest
    ) extends GuardDutyOp[GetUsageStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsageStatisticsResponse] =
        visitor.getUsageStatistics(request)
    }

    final case class InviteMembersOp(
      request: InviteMembersRequest
    ) extends GuardDutyOp[InviteMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InviteMembersResponse] =
        visitor.inviteMembers(request)
    }

    final case class ListDetectorsOp(
      request: ListDetectorsRequest
    ) extends GuardDutyOp[ListDetectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDetectorsResponse] =
        visitor.listDetectors(request)
    }

    final case class ListFiltersOp(
      request: ListFiltersRequest
    ) extends GuardDutyOp[ListFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFiltersResponse] =
        visitor.listFilters(request)
    }

    final case class ListFindingsOp(
      request: ListFindingsRequest
    ) extends GuardDutyOp[ListFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFindingsResponse] =
        visitor.listFindings(request)
    }

    final case class ListIPSetsOp(
      request: ListIpSetsRequest
    ) extends GuardDutyOp[ListIpSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIpSetsResponse] =
        visitor.listIPSets(request)
    }

    final case class ListInvitationsOp(
      request: ListInvitationsRequest
    ) extends GuardDutyOp[ListInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInvitationsResponse] =
        visitor.listInvitations(request)
    }

    final case class ListMembersOp(
      request: ListMembersRequest
    ) extends GuardDutyOp[ListMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMembersResponse] =
        visitor.listMembers(request)
    }

    final case class ListOrganizationAdminAccountsOp(
      request: ListOrganizationAdminAccountsRequest
    ) extends GuardDutyOp[ListOrganizationAdminAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOrganizationAdminAccountsResponse] =
        visitor.listOrganizationAdminAccounts(request)
    }

    final case class ListPublishingDestinationsOp(
      request: ListPublishingDestinationsRequest
    ) extends GuardDutyOp[ListPublishingDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPublishingDestinationsResponse] =
        visitor.listPublishingDestinations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends GuardDutyOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListThreatIntelSetsOp(
      request: ListThreatIntelSetsRequest
    ) extends GuardDutyOp[ListThreatIntelSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThreatIntelSetsResponse] =
        visitor.listThreatIntelSets(request)
    }

    final case class StartMonitoringMembersOp(
      request: StartMonitoringMembersRequest
    ) extends GuardDutyOp[StartMonitoringMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMonitoringMembersResponse] =
        visitor.startMonitoringMembers(request)
    }

    final case class StopMonitoringMembersOp(
      request: StopMonitoringMembersRequest
    ) extends GuardDutyOp[StopMonitoringMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopMonitoringMembersResponse] =
        visitor.stopMonitoringMembers(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends GuardDutyOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UnarchiveFindingsOp(
      request: UnarchiveFindingsRequest
    ) extends GuardDutyOp[UnarchiveFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnarchiveFindingsResponse] =
        visitor.unarchiveFindings(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends GuardDutyOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDetectorOp(
      request: UpdateDetectorRequest
    ) extends GuardDutyOp[UpdateDetectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDetectorResponse] =
        visitor.updateDetector(request)
    }

    final case class UpdateFilterOp(
      request: UpdateFilterRequest
    ) extends GuardDutyOp[UpdateFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFilterResponse] =
        visitor.updateFilter(request)
    }

    final case class UpdateFindingsFeedbackOp(
      request: UpdateFindingsFeedbackRequest
    ) extends GuardDutyOp[UpdateFindingsFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFindingsFeedbackResponse] =
        visitor.updateFindingsFeedback(request)
    }

    final case class UpdateIPSetOp(
      request: UpdateIpSetRequest
    ) extends GuardDutyOp[UpdateIpSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIpSetResponse] =
        visitor.updateIPSet(request)
    }

    final case class UpdateMemberDetectorsOp(
      request: UpdateMemberDetectorsRequest
    ) extends GuardDutyOp[UpdateMemberDetectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMemberDetectorsResponse] =
        visitor.updateMemberDetectors(request)
    }

    final case class UpdateOrganizationConfigurationOp(
      request: UpdateOrganizationConfigurationRequest
    ) extends GuardDutyOp[UpdateOrganizationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOrganizationConfigurationResponse] =
        visitor.updateOrganizationConfiguration(request)
    }

    final case class UpdatePublishingDestinationOp(
      request: UpdatePublishingDestinationRequest
    ) extends GuardDutyOp[UpdatePublishingDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePublishingDestinationResponse] =
        visitor.updatePublishingDestination(request)
    }

    final case class UpdateThreatIntelSetOp(
      request: UpdateThreatIntelSetRequest
    ) extends GuardDutyOp[UpdateThreatIntelSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThreatIntelSetResponse] =
        visitor.updateThreatIntelSet(request)
    }
  }

  import GuardDutyOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GuardDutyOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptInvitation(
    request: AcceptInvitationRequest
  ): GuardDutyIO[AcceptInvitationResponse] =
    FF.liftF(AcceptInvitationOp(request))

  def archiveFindings(
    request: ArchiveFindingsRequest
  ): GuardDutyIO[ArchiveFindingsResponse] =
    FF.liftF(ArchiveFindingsOp(request))

  def createDetector(
    request: CreateDetectorRequest
  ): GuardDutyIO[CreateDetectorResponse] =
    FF.liftF(CreateDetectorOp(request))

  def createFilter(
    request: CreateFilterRequest
  ): GuardDutyIO[CreateFilterResponse] =
    FF.liftF(CreateFilterOp(request))

  def createIPSet(
    request: CreateIpSetRequest
  ): GuardDutyIO[CreateIpSetResponse] =
    FF.liftF(CreateIPSetOp(request))

  def createMembers(
    request: CreateMembersRequest
  ): GuardDutyIO[CreateMembersResponse] =
    FF.liftF(CreateMembersOp(request))

  def createPublishingDestination(
    request: CreatePublishingDestinationRequest
  ): GuardDutyIO[CreatePublishingDestinationResponse] =
    FF.liftF(CreatePublishingDestinationOp(request))

  def createSampleFindings(
    request: CreateSampleFindingsRequest
  ): GuardDutyIO[CreateSampleFindingsResponse] =
    FF.liftF(CreateSampleFindingsOp(request))

  def createThreatIntelSet(
    request: CreateThreatIntelSetRequest
  ): GuardDutyIO[CreateThreatIntelSetResponse] =
    FF.liftF(CreateThreatIntelSetOp(request))

  def declineInvitations(
    request: DeclineInvitationsRequest
  ): GuardDutyIO[DeclineInvitationsResponse] =
    FF.liftF(DeclineInvitationsOp(request))

  def deleteDetector(
    request: DeleteDetectorRequest
  ): GuardDutyIO[DeleteDetectorResponse] =
    FF.liftF(DeleteDetectorOp(request))

  def deleteFilter(
    request: DeleteFilterRequest
  ): GuardDutyIO[DeleteFilterResponse] =
    FF.liftF(DeleteFilterOp(request))

  def deleteIPSet(
    request: DeleteIpSetRequest
  ): GuardDutyIO[DeleteIpSetResponse] =
    FF.liftF(DeleteIPSetOp(request))

  def deleteInvitations(
    request: DeleteInvitationsRequest
  ): GuardDutyIO[DeleteInvitationsResponse] =
    FF.liftF(DeleteInvitationsOp(request))

  def deleteMembers(
    request: DeleteMembersRequest
  ): GuardDutyIO[DeleteMembersResponse] =
    FF.liftF(DeleteMembersOp(request))

  def deletePublishingDestination(
    request: DeletePublishingDestinationRequest
  ): GuardDutyIO[DeletePublishingDestinationResponse] =
    FF.liftF(DeletePublishingDestinationOp(request))

  def deleteThreatIntelSet(
    request: DeleteThreatIntelSetRequest
  ): GuardDutyIO[DeleteThreatIntelSetResponse] =
    FF.liftF(DeleteThreatIntelSetOp(request))

  def describeOrganizationConfiguration(
    request: DescribeOrganizationConfigurationRequest
  ): GuardDutyIO[DescribeOrganizationConfigurationResponse] =
    FF.liftF(DescribeOrganizationConfigurationOp(request))

  def describePublishingDestination(
    request: DescribePublishingDestinationRequest
  ): GuardDutyIO[DescribePublishingDestinationResponse] =
    FF.liftF(DescribePublishingDestinationOp(request))

  def disableOrganizationAdminAccount(
    request: DisableOrganizationAdminAccountRequest
  ): GuardDutyIO[DisableOrganizationAdminAccountResponse] =
    FF.liftF(DisableOrganizationAdminAccountOp(request))

  def disassociateFromMasterAccount(
    request: DisassociateFromMasterAccountRequest
  ): GuardDutyIO[DisassociateFromMasterAccountResponse] =
    FF.liftF(DisassociateFromMasterAccountOp(request))

  def disassociateMembers(
    request: DisassociateMembersRequest
  ): GuardDutyIO[DisassociateMembersResponse] =
    FF.liftF(DisassociateMembersOp(request))

  def enableOrganizationAdminAccount(
    request: EnableOrganizationAdminAccountRequest
  ): GuardDutyIO[EnableOrganizationAdminAccountResponse] =
    FF.liftF(EnableOrganizationAdminAccountOp(request))

  def getDetector(
    request: GetDetectorRequest
  ): GuardDutyIO[GetDetectorResponse] =
    FF.liftF(GetDetectorOp(request))

  def getFilter(
    request: GetFilterRequest
  ): GuardDutyIO[GetFilterResponse] =
    FF.liftF(GetFilterOp(request))

  def getFindings(
    request: GetFindingsRequest
  ): GuardDutyIO[GetFindingsResponse] =
    FF.liftF(GetFindingsOp(request))

  def getFindingsStatistics(
    request: GetFindingsStatisticsRequest
  ): GuardDutyIO[GetFindingsStatisticsResponse] =
    FF.liftF(GetFindingsStatisticsOp(request))

  def getIPSet(
    request: GetIpSetRequest
  ): GuardDutyIO[GetIpSetResponse] =
    FF.liftF(GetIPSetOp(request))

  def getInvitationsCount(
    request: GetInvitationsCountRequest
  ): GuardDutyIO[GetInvitationsCountResponse] =
    FF.liftF(GetInvitationsCountOp(request))

  def getMasterAccount(
    request: GetMasterAccountRequest
  ): GuardDutyIO[GetMasterAccountResponse] =
    FF.liftF(GetMasterAccountOp(request))

  def getMemberDetectors(
    request: GetMemberDetectorsRequest
  ): GuardDutyIO[GetMemberDetectorsResponse] =
    FF.liftF(GetMemberDetectorsOp(request))

  def getMembers(
    request: GetMembersRequest
  ): GuardDutyIO[GetMembersResponse] =
    FF.liftF(GetMembersOp(request))

  def getThreatIntelSet(
    request: GetThreatIntelSetRequest
  ): GuardDutyIO[GetThreatIntelSetResponse] =
    FF.liftF(GetThreatIntelSetOp(request))

  def getUsageStatistics(
    request: GetUsageStatisticsRequest
  ): GuardDutyIO[GetUsageStatisticsResponse] =
    FF.liftF(GetUsageStatisticsOp(request))

  def inviteMembers(
    request: InviteMembersRequest
  ): GuardDutyIO[InviteMembersResponse] =
    FF.liftF(InviteMembersOp(request))

  def listDetectors(
    request: ListDetectorsRequest
  ): GuardDutyIO[ListDetectorsResponse] =
    FF.liftF(ListDetectorsOp(request))

  def listFilters(
    request: ListFiltersRequest
  ): GuardDutyIO[ListFiltersResponse] =
    FF.liftF(ListFiltersOp(request))

  def listFindings(
    request: ListFindingsRequest
  ): GuardDutyIO[ListFindingsResponse] =
    FF.liftF(ListFindingsOp(request))

  def listIPSets(
    request: ListIpSetsRequest
  ): GuardDutyIO[ListIpSetsResponse] =
    FF.liftF(ListIPSetsOp(request))

  def listInvitations(
    request: ListInvitationsRequest
  ): GuardDutyIO[ListInvitationsResponse] =
    FF.liftF(ListInvitationsOp(request))

  def listMembers(
    request: ListMembersRequest
  ): GuardDutyIO[ListMembersResponse] =
    FF.liftF(ListMembersOp(request))

  def listOrganizationAdminAccounts(
    request: ListOrganizationAdminAccountsRequest
  ): GuardDutyIO[ListOrganizationAdminAccountsResponse] =
    FF.liftF(ListOrganizationAdminAccountsOp(request))

  def listPublishingDestinations(
    request: ListPublishingDestinationsRequest
  ): GuardDutyIO[ListPublishingDestinationsResponse] =
    FF.liftF(ListPublishingDestinationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): GuardDutyIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listThreatIntelSets(
    request: ListThreatIntelSetsRequest
  ): GuardDutyIO[ListThreatIntelSetsResponse] =
    FF.liftF(ListThreatIntelSetsOp(request))

  def startMonitoringMembers(
    request: StartMonitoringMembersRequest
  ): GuardDutyIO[StartMonitoringMembersResponse] =
    FF.liftF(StartMonitoringMembersOp(request))

  def stopMonitoringMembers(
    request: StopMonitoringMembersRequest
  ): GuardDutyIO[StopMonitoringMembersResponse] =
    FF.liftF(StopMonitoringMembersOp(request))

  def tagResource(
    request: TagResourceRequest
  ): GuardDutyIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def unarchiveFindings(
    request: UnarchiveFindingsRequest
  ): GuardDutyIO[UnarchiveFindingsResponse] =
    FF.liftF(UnarchiveFindingsOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): GuardDutyIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDetector(
    request: UpdateDetectorRequest
  ): GuardDutyIO[UpdateDetectorResponse] =
    FF.liftF(UpdateDetectorOp(request))

  def updateFilter(
    request: UpdateFilterRequest
  ): GuardDutyIO[UpdateFilterResponse] =
    FF.liftF(UpdateFilterOp(request))

  def updateFindingsFeedback(
    request: UpdateFindingsFeedbackRequest
  ): GuardDutyIO[UpdateFindingsFeedbackResponse] =
    FF.liftF(UpdateFindingsFeedbackOp(request))

  def updateIPSet(
    request: UpdateIpSetRequest
  ): GuardDutyIO[UpdateIpSetResponse] =
    FF.liftF(UpdateIPSetOp(request))

  def updateMemberDetectors(
    request: UpdateMemberDetectorsRequest
  ): GuardDutyIO[UpdateMemberDetectorsResponse] =
    FF.liftF(UpdateMemberDetectorsOp(request))

  def updateOrganizationConfiguration(
    request: UpdateOrganizationConfigurationRequest
  ): GuardDutyIO[UpdateOrganizationConfigurationResponse] =
    FF.liftF(UpdateOrganizationConfigurationOp(request))

  def updatePublishingDestination(
    request: UpdatePublishingDestinationRequest
  ): GuardDutyIO[UpdatePublishingDestinationResponse] =
    FF.liftF(UpdatePublishingDestinationOp(request))

  def updateThreatIntelSet(
    request: UpdateThreatIntelSetRequest
  ): GuardDutyIO[UpdateThreatIntelSetResponse] =
    FF.liftF(UpdateThreatIntelSetOp(request))
}
