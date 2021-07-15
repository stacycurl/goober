package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.securityhub.SecurityHubClient
import software.amazon.awssdk.services.securityhub.model._


object securityhub { module =>

  // Free monad over SecurityHubOp
  type SecurityHubIO[A] = FF[SecurityHubOp, A]

  sealed trait SecurityHubOp[A] {
    def visit[F[_]](visitor: SecurityHubOp.Visitor[F]): F[A]
  }

  object SecurityHubOp {
    // Given a SecurityHubClient we can embed a SecurityHubIO program in any algebra that understands embedding.
    implicit val SecurityHubOpEmbeddable: Embeddable[SecurityHubOp, SecurityHubClient] = new Embeddable[SecurityHubOp, SecurityHubClient] {
      def embed[A](client: SecurityHubClient, io: SecurityHubIO[A]): Embedded[A] = Embedded.SecurityHub(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SecurityHubOp.Visitor[Kleisli[M, SecurityHubClient, *]] {
        def acceptAdministratorInvitation(
          request: AcceptAdministratorInvitationRequest
        ): Kleisli[M, SecurityHubClient, AcceptAdministratorInvitationResponse] =
          primitive(_.acceptAdministratorInvitation(request))

        def batchDisableStandards(
          request: BatchDisableStandardsRequest
        ): Kleisli[M, SecurityHubClient, BatchDisableStandardsResponse] =
          primitive(_.batchDisableStandards(request))

        def batchEnableStandards(
          request: BatchEnableStandardsRequest
        ): Kleisli[M, SecurityHubClient, BatchEnableStandardsResponse] =
          primitive(_.batchEnableStandards(request))

        def batchImportFindings(
          request: BatchImportFindingsRequest
        ): Kleisli[M, SecurityHubClient, BatchImportFindingsResponse] =
          primitive(_.batchImportFindings(request))

        def batchUpdateFindings(
          request: BatchUpdateFindingsRequest
        ): Kleisli[M, SecurityHubClient, BatchUpdateFindingsResponse] =
          primitive(_.batchUpdateFindings(request))

        def createActionTarget(
          request: CreateActionTargetRequest
        ): Kleisli[M, SecurityHubClient, CreateActionTargetResponse] =
          primitive(_.createActionTarget(request))

        def createInsight(
          request: CreateInsightRequest
        ): Kleisli[M, SecurityHubClient, CreateInsightResponse] =
          primitive(_.createInsight(request))

        def createMembers(
          request: CreateMembersRequest
        ): Kleisli[M, SecurityHubClient, CreateMembersResponse] =
          primitive(_.createMembers(request))

        def declineInvitations(
          request: DeclineInvitationsRequest
        ): Kleisli[M, SecurityHubClient, DeclineInvitationsResponse] =
          primitive(_.declineInvitations(request))

        def deleteActionTarget(
          request: DeleteActionTargetRequest
        ): Kleisli[M, SecurityHubClient, DeleteActionTargetResponse] =
          primitive(_.deleteActionTarget(request))

        def deleteInsight(
          request: DeleteInsightRequest
        ): Kleisli[M, SecurityHubClient, DeleteInsightResponse] =
          primitive(_.deleteInsight(request))

        def deleteInvitations(
          request: DeleteInvitationsRequest
        ): Kleisli[M, SecurityHubClient, DeleteInvitationsResponse] =
          primitive(_.deleteInvitations(request))

        def deleteMembers(
          request: DeleteMembersRequest
        ): Kleisli[M, SecurityHubClient, DeleteMembersResponse] =
          primitive(_.deleteMembers(request))

        def describeActionTargets(
          request: DescribeActionTargetsRequest
        ): Kleisli[M, SecurityHubClient, DescribeActionTargetsResponse] =
          primitive(_.describeActionTargets(request))

        def describeHub(
          request: DescribeHubRequest
        ): Kleisli[M, SecurityHubClient, DescribeHubResponse] =
          primitive(_.describeHub(request))

        def describeOrganizationConfiguration(
          request: DescribeOrganizationConfigurationRequest
        ): Kleisli[M, SecurityHubClient, DescribeOrganizationConfigurationResponse] =
          primitive(_.describeOrganizationConfiguration(request))

        def describeProducts(
          request: DescribeProductsRequest
        ): Kleisli[M, SecurityHubClient, DescribeProductsResponse] =
          primitive(_.describeProducts(request))

        def describeStandards(
          request: DescribeStandardsRequest
        ): Kleisli[M, SecurityHubClient, DescribeStandardsResponse] =
          primitive(_.describeStandards(request))

        def describeStandardsControls(
          request: DescribeStandardsControlsRequest
        ): Kleisli[M, SecurityHubClient, DescribeStandardsControlsResponse] =
          primitive(_.describeStandardsControls(request))

        def disableImportFindingsForProduct(
          request: DisableImportFindingsForProductRequest
        ): Kleisli[M, SecurityHubClient, DisableImportFindingsForProductResponse] =
          primitive(_.disableImportFindingsForProduct(request))

        def disableOrganizationAdminAccount(
          request: DisableOrganizationAdminAccountRequest
        ): Kleisli[M, SecurityHubClient, DisableOrganizationAdminAccountResponse] =
          primitive(_.disableOrganizationAdminAccount(request))

        def disableSecurityHub(
          request: DisableSecurityHubRequest
        ): Kleisli[M, SecurityHubClient, DisableSecurityHubResponse] =
          primitive(_.disableSecurityHub(request))

        def disassociateFromAdministratorAccount(
          request: DisassociateFromAdministratorAccountRequest
        ): Kleisli[M, SecurityHubClient, DisassociateFromAdministratorAccountResponse] =
          primitive(_.disassociateFromAdministratorAccount(request))

        def disassociateMembers(
          request: DisassociateMembersRequest
        ): Kleisli[M, SecurityHubClient, DisassociateMembersResponse] =
          primitive(_.disassociateMembers(request))

        def enableImportFindingsForProduct(
          request: EnableImportFindingsForProductRequest
        ): Kleisli[M, SecurityHubClient, EnableImportFindingsForProductResponse] =
          primitive(_.enableImportFindingsForProduct(request))

        def enableOrganizationAdminAccount(
          request: EnableOrganizationAdminAccountRequest
        ): Kleisli[M, SecurityHubClient, EnableOrganizationAdminAccountResponse] =
          primitive(_.enableOrganizationAdminAccount(request))

        def enableSecurityHub(
          request: EnableSecurityHubRequest
        ): Kleisli[M, SecurityHubClient, EnableSecurityHubResponse] =
          primitive(_.enableSecurityHub(request))

        def getAdministratorAccount(
          request: GetAdministratorAccountRequest
        ): Kleisli[M, SecurityHubClient, GetAdministratorAccountResponse] =
          primitive(_.getAdministratorAccount(request))

        def getEnabledStandards(
          request: GetEnabledStandardsRequest
        ): Kleisli[M, SecurityHubClient, GetEnabledStandardsResponse] =
          primitive(_.getEnabledStandards(request))

        def getFindings(
          request: GetFindingsRequest
        ): Kleisli[M, SecurityHubClient, GetFindingsResponse] =
          primitive(_.getFindings(request))

        def getInsightResults(
          request: GetInsightResultsRequest
        ): Kleisli[M, SecurityHubClient, GetInsightResultsResponse] =
          primitive(_.getInsightResults(request))

        def getInsights(
          request: GetInsightsRequest
        ): Kleisli[M, SecurityHubClient, GetInsightsResponse] =
          primitive(_.getInsights(request))

        def getInvitationsCount(
          request: GetInvitationsCountRequest
        ): Kleisli[M, SecurityHubClient, GetInvitationsCountResponse] =
          primitive(_.getInvitationsCount(request))

        def getMembers(
          request: GetMembersRequest
        ): Kleisli[M, SecurityHubClient, GetMembersResponse] =
          primitive(_.getMembers(request))

        def inviteMembers(
          request: InviteMembersRequest
        ): Kleisli[M, SecurityHubClient, InviteMembersResponse] =
          primitive(_.inviteMembers(request))

        def listEnabledProductsForImport(
          request: ListEnabledProductsForImportRequest
        ): Kleisli[M, SecurityHubClient, ListEnabledProductsForImportResponse] =
          primitive(_.listEnabledProductsForImport(request))

        def listInvitations(
          request: ListInvitationsRequest
        ): Kleisli[M, SecurityHubClient, ListInvitationsResponse] =
          primitive(_.listInvitations(request))

        def listMembers(
          request: ListMembersRequest
        ): Kleisli[M, SecurityHubClient, ListMembersResponse] =
          primitive(_.listMembers(request))

        def listOrganizationAdminAccounts(
          request: ListOrganizationAdminAccountsRequest
        ): Kleisli[M, SecurityHubClient, ListOrganizationAdminAccountsResponse] =
          primitive(_.listOrganizationAdminAccounts(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SecurityHubClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SecurityHubClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SecurityHubClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateActionTarget(
          request: UpdateActionTargetRequest
        ): Kleisli[M, SecurityHubClient, UpdateActionTargetResponse] =
          primitive(_.updateActionTarget(request))

        def updateFindings(
          request: UpdateFindingsRequest
        ): Kleisli[M, SecurityHubClient, UpdateFindingsResponse] =
          primitive(_.updateFindings(request))

        def updateInsight(
          request: UpdateInsightRequest
        ): Kleisli[M, SecurityHubClient, UpdateInsightResponse] =
          primitive(_.updateInsight(request))

        def updateOrganizationConfiguration(
          request: UpdateOrganizationConfigurationRequest
        ): Kleisli[M, SecurityHubClient, UpdateOrganizationConfigurationResponse] =
          primitive(_.updateOrganizationConfiguration(request))

        def updateSecurityHubConfiguration(
          request: UpdateSecurityHubConfigurationRequest
        ): Kleisli[M, SecurityHubClient, UpdateSecurityHubConfigurationResponse] =
          primitive(_.updateSecurityHubConfiguration(request))

        def updateStandardsControl(
          request: UpdateStandardsControlRequest
        ): Kleisli[M, SecurityHubClient, UpdateStandardsControlResponse] =
          primitive(_.updateStandardsControl(request))

        def primitive[A](
          f: SecurityHubClient => A
        ): Kleisli[M, SecurityHubClient, A]
      }
    }

    trait Visitor[F[_]] extends (SecurityHubOp ~> F) {
      final def apply[A](op: SecurityHubOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptAdministratorInvitation(
        request: AcceptAdministratorInvitationRequest
      ): F[AcceptAdministratorInvitationResponse]

      def batchDisableStandards(
        request: BatchDisableStandardsRequest
      ): F[BatchDisableStandardsResponse]

      def batchEnableStandards(
        request: BatchEnableStandardsRequest
      ): F[BatchEnableStandardsResponse]

      def batchImportFindings(
        request: BatchImportFindingsRequest
      ): F[BatchImportFindingsResponse]

      def batchUpdateFindings(
        request: BatchUpdateFindingsRequest
      ): F[BatchUpdateFindingsResponse]

      def createActionTarget(
        request: CreateActionTargetRequest
      ): F[CreateActionTargetResponse]

      def createInsight(
        request: CreateInsightRequest
      ): F[CreateInsightResponse]

      def createMembers(
        request: CreateMembersRequest
      ): F[CreateMembersResponse]

      def declineInvitations(
        request: DeclineInvitationsRequest
      ): F[DeclineInvitationsResponse]

      def deleteActionTarget(
        request: DeleteActionTargetRequest
      ): F[DeleteActionTargetResponse]

      def deleteInsight(
        request: DeleteInsightRequest
      ): F[DeleteInsightResponse]

      def deleteInvitations(
        request: DeleteInvitationsRequest
      ): F[DeleteInvitationsResponse]

      def deleteMembers(
        request: DeleteMembersRequest
      ): F[DeleteMembersResponse]

      def describeActionTargets(
        request: DescribeActionTargetsRequest
      ): F[DescribeActionTargetsResponse]

      def describeHub(
        request: DescribeHubRequest
      ): F[DescribeHubResponse]

      def describeOrganizationConfiguration(
        request: DescribeOrganizationConfigurationRequest
      ): F[DescribeOrganizationConfigurationResponse]

      def describeProducts(
        request: DescribeProductsRequest
      ): F[DescribeProductsResponse]

      def describeStandards(
        request: DescribeStandardsRequest
      ): F[DescribeStandardsResponse]

      def describeStandardsControls(
        request: DescribeStandardsControlsRequest
      ): F[DescribeStandardsControlsResponse]

      def disableImportFindingsForProduct(
        request: DisableImportFindingsForProductRequest
      ): F[DisableImportFindingsForProductResponse]

      def disableOrganizationAdminAccount(
        request: DisableOrganizationAdminAccountRequest
      ): F[DisableOrganizationAdminAccountResponse]

      def disableSecurityHub(
        request: DisableSecurityHubRequest
      ): F[DisableSecurityHubResponse]

      def disassociateFromAdministratorAccount(
        request: DisassociateFromAdministratorAccountRequest
      ): F[DisassociateFromAdministratorAccountResponse]

      def disassociateMembers(
        request: DisassociateMembersRequest
      ): F[DisassociateMembersResponse]

      def enableImportFindingsForProduct(
        request: EnableImportFindingsForProductRequest
      ): F[EnableImportFindingsForProductResponse]

      def enableOrganizationAdminAccount(
        request: EnableOrganizationAdminAccountRequest
      ): F[EnableOrganizationAdminAccountResponse]

      def enableSecurityHub(
        request: EnableSecurityHubRequest
      ): F[EnableSecurityHubResponse]

      def getAdministratorAccount(
        request: GetAdministratorAccountRequest
      ): F[GetAdministratorAccountResponse]

      def getEnabledStandards(
        request: GetEnabledStandardsRequest
      ): F[GetEnabledStandardsResponse]

      def getFindings(
        request: GetFindingsRequest
      ): F[GetFindingsResponse]

      def getInsightResults(
        request: GetInsightResultsRequest
      ): F[GetInsightResultsResponse]

      def getInsights(
        request: GetInsightsRequest
      ): F[GetInsightsResponse]

      def getInvitationsCount(
        request: GetInvitationsCountRequest
      ): F[GetInvitationsCountResponse]

      def getMembers(
        request: GetMembersRequest
      ): F[GetMembersResponse]

      def inviteMembers(
        request: InviteMembersRequest
      ): F[InviteMembersResponse]

      def listEnabledProductsForImport(
        request: ListEnabledProductsForImportRequest
      ): F[ListEnabledProductsForImportResponse]

      def listInvitations(
        request: ListInvitationsRequest
      ): F[ListInvitationsResponse]

      def listMembers(
        request: ListMembersRequest
      ): F[ListMembersResponse]

      def listOrganizationAdminAccounts(
        request: ListOrganizationAdminAccountsRequest
      ): F[ListOrganizationAdminAccountsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateActionTarget(
        request: UpdateActionTargetRequest
      ): F[UpdateActionTargetResponse]

      def updateFindings(
        request: UpdateFindingsRequest
      ): F[UpdateFindingsResponse]

      def updateInsight(
        request: UpdateInsightRequest
      ): F[UpdateInsightResponse]

      def updateOrganizationConfiguration(
        request: UpdateOrganizationConfigurationRequest
      ): F[UpdateOrganizationConfigurationResponse]

      def updateSecurityHubConfiguration(
        request: UpdateSecurityHubConfigurationRequest
      ): F[UpdateSecurityHubConfigurationResponse]

      def updateStandardsControl(
        request: UpdateStandardsControlRequest
      ): F[UpdateStandardsControlResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SecurityHubOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptAdministratorInvitationOp(
      request: AcceptAdministratorInvitationRequest
    ) extends SecurityHubOp[AcceptAdministratorInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptAdministratorInvitationResponse] =
        visitor.acceptAdministratorInvitation(request)
    }

    final case class BatchDisableStandardsOp(
      request: BatchDisableStandardsRequest
    ) extends SecurityHubOp[BatchDisableStandardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisableStandardsResponse] =
        visitor.batchDisableStandards(request)
    }

    final case class BatchEnableStandardsOp(
      request: BatchEnableStandardsRequest
    ) extends SecurityHubOp[BatchEnableStandardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchEnableStandardsResponse] =
        visitor.batchEnableStandards(request)
    }

    final case class BatchImportFindingsOp(
      request: BatchImportFindingsRequest
    ) extends SecurityHubOp[BatchImportFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchImportFindingsResponse] =
        visitor.batchImportFindings(request)
    }

    final case class BatchUpdateFindingsOp(
      request: BatchUpdateFindingsRequest
    ) extends SecurityHubOp[BatchUpdateFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdateFindingsResponse] =
        visitor.batchUpdateFindings(request)
    }

    final case class CreateActionTargetOp(
      request: CreateActionTargetRequest
    ) extends SecurityHubOp[CreateActionTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateActionTargetResponse] =
        visitor.createActionTarget(request)
    }

    final case class CreateInsightOp(
      request: CreateInsightRequest
    ) extends SecurityHubOp[CreateInsightResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInsightResponse] =
        visitor.createInsight(request)
    }

    final case class CreateMembersOp(
      request: CreateMembersRequest
    ) extends SecurityHubOp[CreateMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMembersResponse] =
        visitor.createMembers(request)
    }

    final case class DeclineInvitationsOp(
      request: DeclineInvitationsRequest
    ) extends SecurityHubOp[DeclineInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeclineInvitationsResponse] =
        visitor.declineInvitations(request)
    }

    final case class DeleteActionTargetOp(
      request: DeleteActionTargetRequest
    ) extends SecurityHubOp[DeleteActionTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteActionTargetResponse] =
        visitor.deleteActionTarget(request)
    }

    final case class DeleteInsightOp(
      request: DeleteInsightRequest
    ) extends SecurityHubOp[DeleteInsightResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInsightResponse] =
        visitor.deleteInsight(request)
    }

    final case class DeleteInvitationsOp(
      request: DeleteInvitationsRequest
    ) extends SecurityHubOp[DeleteInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInvitationsResponse] =
        visitor.deleteInvitations(request)
    }

    final case class DeleteMembersOp(
      request: DeleteMembersRequest
    ) extends SecurityHubOp[DeleteMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMembersResponse] =
        visitor.deleteMembers(request)
    }

    final case class DescribeActionTargetsOp(
      request: DescribeActionTargetsRequest
    ) extends SecurityHubOp[DescribeActionTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeActionTargetsResponse] =
        visitor.describeActionTargets(request)
    }

    final case class DescribeHubOp(
      request: DescribeHubRequest
    ) extends SecurityHubOp[DescribeHubResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHubResponse] =
        visitor.describeHub(request)
    }

    final case class DescribeOrganizationConfigurationOp(
      request: DescribeOrganizationConfigurationRequest
    ) extends SecurityHubOp[DescribeOrganizationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationConfigurationResponse] =
        visitor.describeOrganizationConfiguration(request)
    }

    final case class DescribeProductsOp(
      request: DescribeProductsRequest
    ) extends SecurityHubOp[DescribeProductsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProductsResponse] =
        visitor.describeProducts(request)
    }

    final case class DescribeStandardsOp(
      request: DescribeStandardsRequest
    ) extends SecurityHubOp[DescribeStandardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStandardsResponse] =
        visitor.describeStandards(request)
    }

    final case class DescribeStandardsControlsOp(
      request: DescribeStandardsControlsRequest
    ) extends SecurityHubOp[DescribeStandardsControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStandardsControlsResponse] =
        visitor.describeStandardsControls(request)
    }

    final case class DisableImportFindingsForProductOp(
      request: DisableImportFindingsForProductRequest
    ) extends SecurityHubOp[DisableImportFindingsForProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableImportFindingsForProductResponse] =
        visitor.disableImportFindingsForProduct(request)
    }

    final case class DisableOrganizationAdminAccountOp(
      request: DisableOrganizationAdminAccountRequest
    ) extends SecurityHubOp[DisableOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableOrganizationAdminAccountResponse] =
        visitor.disableOrganizationAdminAccount(request)
    }

    final case class DisableSecurityHubOp(
      request: DisableSecurityHubRequest
    ) extends SecurityHubOp[DisableSecurityHubResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableSecurityHubResponse] =
        visitor.disableSecurityHub(request)
    }

    final case class DisassociateFromAdministratorAccountOp(
      request: DisassociateFromAdministratorAccountRequest
    ) extends SecurityHubOp[DisassociateFromAdministratorAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFromAdministratorAccountResponse] =
        visitor.disassociateFromAdministratorAccount(request)
    }

    final case class DisassociateMembersOp(
      request: DisassociateMembersRequest
    ) extends SecurityHubOp[DisassociateMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateMembersResponse] =
        visitor.disassociateMembers(request)
    }

    final case class EnableImportFindingsForProductOp(
      request: EnableImportFindingsForProductRequest
    ) extends SecurityHubOp[EnableImportFindingsForProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableImportFindingsForProductResponse] =
        visitor.enableImportFindingsForProduct(request)
    }

    final case class EnableOrganizationAdminAccountOp(
      request: EnableOrganizationAdminAccountRequest
    ) extends SecurityHubOp[EnableOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableOrganizationAdminAccountResponse] =
        visitor.enableOrganizationAdminAccount(request)
    }

    final case class EnableSecurityHubOp(
      request: EnableSecurityHubRequest
    ) extends SecurityHubOp[EnableSecurityHubResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableSecurityHubResponse] =
        visitor.enableSecurityHub(request)
    }

    final case class GetAdministratorAccountOp(
      request: GetAdministratorAccountRequest
    ) extends SecurityHubOp[GetAdministratorAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAdministratorAccountResponse] =
        visitor.getAdministratorAccount(request)
    }

    final case class GetEnabledStandardsOp(
      request: GetEnabledStandardsRequest
    ) extends SecurityHubOp[GetEnabledStandardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnabledStandardsResponse] =
        visitor.getEnabledStandards(request)
    }

    final case class GetFindingsOp(
      request: GetFindingsRequest
    ) extends SecurityHubOp[GetFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingsResponse] =
        visitor.getFindings(request)
    }

    final case class GetInsightResultsOp(
      request: GetInsightResultsRequest
    ) extends SecurityHubOp[GetInsightResultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightResultsResponse] =
        visitor.getInsightResults(request)
    }

    final case class GetInsightsOp(
      request: GetInsightsRequest
    ) extends SecurityHubOp[GetInsightsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightsResponse] =
        visitor.getInsights(request)
    }

    final case class GetInvitationsCountOp(
      request: GetInvitationsCountRequest
    ) extends SecurityHubOp[GetInvitationsCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInvitationsCountResponse] =
        visitor.getInvitationsCount(request)
    }

    final case class GetMembersOp(
      request: GetMembersRequest
    ) extends SecurityHubOp[GetMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMembersResponse] =
        visitor.getMembers(request)
    }

    final case class InviteMembersOp(
      request: InviteMembersRequest
    ) extends SecurityHubOp[InviteMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InviteMembersResponse] =
        visitor.inviteMembers(request)
    }

    final case class ListEnabledProductsForImportOp(
      request: ListEnabledProductsForImportRequest
    ) extends SecurityHubOp[ListEnabledProductsForImportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnabledProductsForImportResponse] =
        visitor.listEnabledProductsForImport(request)
    }

    final case class ListInvitationsOp(
      request: ListInvitationsRequest
    ) extends SecurityHubOp[ListInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInvitationsResponse] =
        visitor.listInvitations(request)
    }

    final case class ListMembersOp(
      request: ListMembersRequest
    ) extends SecurityHubOp[ListMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMembersResponse] =
        visitor.listMembers(request)
    }

    final case class ListOrganizationAdminAccountsOp(
      request: ListOrganizationAdminAccountsRequest
    ) extends SecurityHubOp[ListOrganizationAdminAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOrganizationAdminAccountsResponse] =
        visitor.listOrganizationAdminAccounts(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SecurityHubOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SecurityHubOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SecurityHubOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateActionTargetOp(
      request: UpdateActionTargetRequest
    ) extends SecurityHubOp[UpdateActionTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateActionTargetResponse] =
        visitor.updateActionTarget(request)
    }

    final case class UpdateFindingsOp(
      request: UpdateFindingsRequest
    ) extends SecurityHubOp[UpdateFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFindingsResponse] =
        visitor.updateFindings(request)
    }

    final case class UpdateInsightOp(
      request: UpdateInsightRequest
    ) extends SecurityHubOp[UpdateInsightResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInsightResponse] =
        visitor.updateInsight(request)
    }

    final case class UpdateOrganizationConfigurationOp(
      request: UpdateOrganizationConfigurationRequest
    ) extends SecurityHubOp[UpdateOrganizationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOrganizationConfigurationResponse] =
        visitor.updateOrganizationConfiguration(request)
    }

    final case class UpdateSecurityHubConfigurationOp(
      request: UpdateSecurityHubConfigurationRequest
    ) extends SecurityHubOp[UpdateSecurityHubConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSecurityHubConfigurationResponse] =
        visitor.updateSecurityHubConfiguration(request)
    }

    final case class UpdateStandardsControlOp(
      request: UpdateStandardsControlRequest
    ) extends SecurityHubOp[UpdateStandardsControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStandardsControlResponse] =
        visitor.updateStandardsControl(request)
    }
  }

  import SecurityHubOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SecurityHubOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptAdministratorInvitation(
    request: AcceptAdministratorInvitationRequest
  ): SecurityHubIO[AcceptAdministratorInvitationResponse] =
    FF.liftF(AcceptAdministratorInvitationOp(request))

  def batchDisableStandards(
    request: BatchDisableStandardsRequest
  ): SecurityHubIO[BatchDisableStandardsResponse] =
    FF.liftF(BatchDisableStandardsOp(request))

  def batchEnableStandards(
    request: BatchEnableStandardsRequest
  ): SecurityHubIO[BatchEnableStandardsResponse] =
    FF.liftF(BatchEnableStandardsOp(request))

  def batchImportFindings(
    request: BatchImportFindingsRequest
  ): SecurityHubIO[BatchImportFindingsResponse] =
    FF.liftF(BatchImportFindingsOp(request))

  def batchUpdateFindings(
    request: BatchUpdateFindingsRequest
  ): SecurityHubIO[BatchUpdateFindingsResponse] =
    FF.liftF(BatchUpdateFindingsOp(request))

  def createActionTarget(
    request: CreateActionTargetRequest
  ): SecurityHubIO[CreateActionTargetResponse] =
    FF.liftF(CreateActionTargetOp(request))

  def createInsight(
    request: CreateInsightRequest
  ): SecurityHubIO[CreateInsightResponse] =
    FF.liftF(CreateInsightOp(request))

  def createMembers(
    request: CreateMembersRequest
  ): SecurityHubIO[CreateMembersResponse] =
    FF.liftF(CreateMembersOp(request))

  def declineInvitations(
    request: DeclineInvitationsRequest
  ): SecurityHubIO[DeclineInvitationsResponse] =
    FF.liftF(DeclineInvitationsOp(request))

  def deleteActionTarget(
    request: DeleteActionTargetRequest
  ): SecurityHubIO[DeleteActionTargetResponse] =
    FF.liftF(DeleteActionTargetOp(request))

  def deleteInsight(
    request: DeleteInsightRequest
  ): SecurityHubIO[DeleteInsightResponse] =
    FF.liftF(DeleteInsightOp(request))

  def deleteInvitations(
    request: DeleteInvitationsRequest
  ): SecurityHubIO[DeleteInvitationsResponse] =
    FF.liftF(DeleteInvitationsOp(request))

  def deleteMembers(
    request: DeleteMembersRequest
  ): SecurityHubIO[DeleteMembersResponse] =
    FF.liftF(DeleteMembersOp(request))

  def describeActionTargets(
    request: DescribeActionTargetsRequest
  ): SecurityHubIO[DescribeActionTargetsResponse] =
    FF.liftF(DescribeActionTargetsOp(request))

  def describeHub(
    request: DescribeHubRequest
  ): SecurityHubIO[DescribeHubResponse] =
    FF.liftF(DescribeHubOp(request))

  def describeOrganizationConfiguration(
    request: DescribeOrganizationConfigurationRequest
  ): SecurityHubIO[DescribeOrganizationConfigurationResponse] =
    FF.liftF(DescribeOrganizationConfigurationOp(request))

  def describeProducts(
    request: DescribeProductsRequest
  ): SecurityHubIO[DescribeProductsResponse] =
    FF.liftF(DescribeProductsOp(request))

  def describeStandards(
    request: DescribeStandardsRequest
  ): SecurityHubIO[DescribeStandardsResponse] =
    FF.liftF(DescribeStandardsOp(request))

  def describeStandardsControls(
    request: DescribeStandardsControlsRequest
  ): SecurityHubIO[DescribeStandardsControlsResponse] =
    FF.liftF(DescribeStandardsControlsOp(request))

  def disableImportFindingsForProduct(
    request: DisableImportFindingsForProductRequest
  ): SecurityHubIO[DisableImportFindingsForProductResponse] =
    FF.liftF(DisableImportFindingsForProductOp(request))

  def disableOrganizationAdminAccount(
    request: DisableOrganizationAdminAccountRequest
  ): SecurityHubIO[DisableOrganizationAdminAccountResponse] =
    FF.liftF(DisableOrganizationAdminAccountOp(request))

  def disableSecurityHub(
    request: DisableSecurityHubRequest
  ): SecurityHubIO[DisableSecurityHubResponse] =
    FF.liftF(DisableSecurityHubOp(request))

  def disassociateFromAdministratorAccount(
    request: DisassociateFromAdministratorAccountRequest
  ): SecurityHubIO[DisassociateFromAdministratorAccountResponse] =
    FF.liftF(DisassociateFromAdministratorAccountOp(request))

  def disassociateMembers(
    request: DisassociateMembersRequest
  ): SecurityHubIO[DisassociateMembersResponse] =
    FF.liftF(DisassociateMembersOp(request))

  def enableImportFindingsForProduct(
    request: EnableImportFindingsForProductRequest
  ): SecurityHubIO[EnableImportFindingsForProductResponse] =
    FF.liftF(EnableImportFindingsForProductOp(request))

  def enableOrganizationAdminAccount(
    request: EnableOrganizationAdminAccountRequest
  ): SecurityHubIO[EnableOrganizationAdminAccountResponse] =
    FF.liftF(EnableOrganizationAdminAccountOp(request))

  def enableSecurityHub(
    request: EnableSecurityHubRequest
  ): SecurityHubIO[EnableSecurityHubResponse] =
    FF.liftF(EnableSecurityHubOp(request))

  def getAdministratorAccount(
    request: GetAdministratorAccountRequest
  ): SecurityHubIO[GetAdministratorAccountResponse] =
    FF.liftF(GetAdministratorAccountOp(request))

  def getEnabledStandards(
    request: GetEnabledStandardsRequest
  ): SecurityHubIO[GetEnabledStandardsResponse] =
    FF.liftF(GetEnabledStandardsOp(request))

  def getFindings(
    request: GetFindingsRequest
  ): SecurityHubIO[GetFindingsResponse] =
    FF.liftF(GetFindingsOp(request))

  def getInsightResults(
    request: GetInsightResultsRequest
  ): SecurityHubIO[GetInsightResultsResponse] =
    FF.liftF(GetInsightResultsOp(request))

  def getInsights(
    request: GetInsightsRequest
  ): SecurityHubIO[GetInsightsResponse] =
    FF.liftF(GetInsightsOp(request))

  def getInvitationsCount(
    request: GetInvitationsCountRequest
  ): SecurityHubIO[GetInvitationsCountResponse] =
    FF.liftF(GetInvitationsCountOp(request))

  def getMembers(
    request: GetMembersRequest
  ): SecurityHubIO[GetMembersResponse] =
    FF.liftF(GetMembersOp(request))

  def inviteMembers(
    request: InviteMembersRequest
  ): SecurityHubIO[InviteMembersResponse] =
    FF.liftF(InviteMembersOp(request))

  def listEnabledProductsForImport(
    request: ListEnabledProductsForImportRequest
  ): SecurityHubIO[ListEnabledProductsForImportResponse] =
    FF.liftF(ListEnabledProductsForImportOp(request))

  def listInvitations(
    request: ListInvitationsRequest
  ): SecurityHubIO[ListInvitationsResponse] =
    FF.liftF(ListInvitationsOp(request))

  def listMembers(
    request: ListMembersRequest
  ): SecurityHubIO[ListMembersResponse] =
    FF.liftF(ListMembersOp(request))

  def listOrganizationAdminAccounts(
    request: ListOrganizationAdminAccountsRequest
  ): SecurityHubIO[ListOrganizationAdminAccountsResponse] =
    FF.liftF(ListOrganizationAdminAccountsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SecurityHubIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SecurityHubIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SecurityHubIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateActionTarget(
    request: UpdateActionTargetRequest
  ): SecurityHubIO[UpdateActionTargetResponse] =
    FF.liftF(UpdateActionTargetOp(request))

  def updateFindings(
    request: UpdateFindingsRequest
  ): SecurityHubIO[UpdateFindingsResponse] =
    FF.liftF(UpdateFindingsOp(request))

  def updateInsight(
    request: UpdateInsightRequest
  ): SecurityHubIO[UpdateInsightResponse] =
    FF.liftF(UpdateInsightOp(request))

  def updateOrganizationConfiguration(
    request: UpdateOrganizationConfigurationRequest
  ): SecurityHubIO[UpdateOrganizationConfigurationResponse] =
    FF.liftF(UpdateOrganizationConfigurationOp(request))

  def updateSecurityHubConfiguration(
    request: UpdateSecurityHubConfigurationRequest
  ): SecurityHubIO[UpdateSecurityHubConfigurationResponse] =
    FF.liftF(UpdateSecurityHubConfigurationOp(request))

  def updateStandardsControl(
    request: UpdateStandardsControlRequest
  ): SecurityHubIO[UpdateStandardsControlResponse] =
    FF.liftF(UpdateStandardsControlOp(request))
}
