package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.macie2.Macie2Client
import software.amazon.awssdk.services.macie2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object macie2 { module =>

  // Free monad over Macie2Op
  type Macie2IO[A] = FF[Macie2Op, A]

  sealed trait Macie2Op[A] {
    def visit[F[_]](visitor: Macie2Op.Visitor[F]): F[A]
  }

  object Macie2Op {
    // Given a Macie2Client we can embed a Macie2IO program in any algebra that understands embedding.
    implicit val Macie2OpEmbeddable: Embeddable[Macie2Op, Macie2Client] = new Embeddable[Macie2Op, Macie2Client] {
      def embed[A](client: Macie2Client, io: Macie2IO[A]): Embedded[A] = Embedded.Macie2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Macie2Op.Visitor[Kleisli[M, Macie2Client, *]] {
        def acceptInvitation(
          request: AcceptInvitationRequest
        ): Kleisli[M, Macie2Client, AcceptInvitationResponse] =
          primitive(_.acceptInvitation(request))

        def batchGetCustomDataIdentifiers(
          request: BatchGetCustomDataIdentifiersRequest
        ): Kleisli[M, Macie2Client, BatchGetCustomDataIdentifiersResponse] =
          primitive(_.batchGetCustomDataIdentifiers(request))

        def createClassificationJob(
          request: CreateClassificationJobRequest
        ): Kleisli[M, Macie2Client, CreateClassificationJobResponse] =
          primitive(_.createClassificationJob(request))

        def createCustomDataIdentifier(
          request: CreateCustomDataIdentifierRequest
        ): Kleisli[M, Macie2Client, CreateCustomDataIdentifierResponse] =
          primitive(_.createCustomDataIdentifier(request))

        def createFindingsFilter(
          request: CreateFindingsFilterRequest
        ): Kleisli[M, Macie2Client, CreateFindingsFilterResponse] =
          primitive(_.createFindingsFilter(request))

        def createInvitations(
          request: CreateInvitationsRequest
        ): Kleisli[M, Macie2Client, CreateInvitationsResponse] =
          primitive(_.createInvitations(request))

        def createMember(
          request: CreateMemberRequest
        ): Kleisli[M, Macie2Client, CreateMemberResponse] =
          primitive(_.createMember(request))

        def createSampleFindings(
          request: CreateSampleFindingsRequest
        ): Kleisli[M, Macie2Client, CreateSampleFindingsResponse] =
          primitive(_.createSampleFindings(request))

        def declineInvitations(
          request: DeclineInvitationsRequest
        ): Kleisli[M, Macie2Client, DeclineInvitationsResponse] =
          primitive(_.declineInvitations(request))

        def deleteCustomDataIdentifier(
          request: DeleteCustomDataIdentifierRequest
        ): Kleisli[M, Macie2Client, DeleteCustomDataIdentifierResponse] =
          primitive(_.deleteCustomDataIdentifier(request))

        def deleteFindingsFilter(
          request: DeleteFindingsFilterRequest
        ): Kleisli[M, Macie2Client, DeleteFindingsFilterResponse] =
          primitive(_.deleteFindingsFilter(request))

        def deleteInvitations(
          request: DeleteInvitationsRequest
        ): Kleisli[M, Macie2Client, DeleteInvitationsResponse] =
          primitive(_.deleteInvitations(request))

        def deleteMember(
          request: DeleteMemberRequest
        ): Kleisli[M, Macie2Client, DeleteMemberResponse] =
          primitive(_.deleteMember(request))

        def describeBuckets(
          request: DescribeBucketsRequest
        ): Kleisli[M, Macie2Client, DescribeBucketsResponse] =
          primitive(_.describeBuckets(request))

        def describeClassificationJob(
          request: DescribeClassificationJobRequest
        ): Kleisli[M, Macie2Client, DescribeClassificationJobResponse] =
          primitive(_.describeClassificationJob(request))

        def describeOrganizationConfiguration(
          request: DescribeOrganizationConfigurationRequest
        ): Kleisli[M, Macie2Client, DescribeOrganizationConfigurationResponse] =
          primitive(_.describeOrganizationConfiguration(request))

        def disableMacie(
          request: DisableMacieRequest
        ): Kleisli[M, Macie2Client, DisableMacieResponse] =
          primitive(_.disableMacie(request))

        def disableOrganizationAdminAccount(
          request: DisableOrganizationAdminAccountRequest
        ): Kleisli[M, Macie2Client, DisableOrganizationAdminAccountResponse] =
          primitive(_.disableOrganizationAdminAccount(request))

        def disassociateFromAdministratorAccount(
          request: DisassociateFromAdministratorAccountRequest
        ): Kleisli[M, Macie2Client, DisassociateFromAdministratorAccountResponse] =
          primitive(_.disassociateFromAdministratorAccount(request))

        def disassociateFromMasterAccount(
          request: DisassociateFromMasterAccountRequest
        ): Kleisli[M, Macie2Client, DisassociateFromMasterAccountResponse] =
          primitive(_.disassociateFromMasterAccount(request))

        def disassociateMember(
          request: DisassociateMemberRequest
        ): Kleisli[M, Macie2Client, DisassociateMemberResponse] =
          primitive(_.disassociateMember(request))

        def enableMacie(
          request: EnableMacieRequest
        ): Kleisli[M, Macie2Client, EnableMacieResponse] =
          primitive(_.enableMacie(request))

        def enableOrganizationAdminAccount(
          request: EnableOrganizationAdminAccountRequest
        ): Kleisli[M, Macie2Client, EnableOrganizationAdminAccountResponse] =
          primitive(_.enableOrganizationAdminAccount(request))

        def getAdministratorAccount(
          request: GetAdministratorAccountRequest
        ): Kleisli[M, Macie2Client, GetAdministratorAccountResponse] =
          primitive(_.getAdministratorAccount(request))

        def getBucketStatistics(
          request: GetBucketStatisticsRequest
        ): Kleisli[M, Macie2Client, GetBucketStatisticsResponse] =
          primitive(_.getBucketStatistics(request))

        def getClassificationExportConfiguration(
          request: GetClassificationExportConfigurationRequest
        ): Kleisli[M, Macie2Client, GetClassificationExportConfigurationResponse] =
          primitive(_.getClassificationExportConfiguration(request))

        def getCustomDataIdentifier(
          request: GetCustomDataIdentifierRequest
        ): Kleisli[M, Macie2Client, GetCustomDataIdentifierResponse] =
          primitive(_.getCustomDataIdentifier(request))

        def getFindingStatistics(
          request: GetFindingStatisticsRequest
        ): Kleisli[M, Macie2Client, GetFindingStatisticsResponse] =
          primitive(_.getFindingStatistics(request))

        def getFindings(
          request: GetFindingsRequest
        ): Kleisli[M, Macie2Client, GetFindingsResponse] =
          primitive(_.getFindings(request))

        def getFindingsFilter(
          request: GetFindingsFilterRequest
        ): Kleisli[M, Macie2Client, GetFindingsFilterResponse] =
          primitive(_.getFindingsFilter(request))

        def getFindingsPublicationConfiguration(
          request: GetFindingsPublicationConfigurationRequest
        ): Kleisli[M, Macie2Client, GetFindingsPublicationConfigurationResponse] =
          primitive(_.getFindingsPublicationConfiguration(request))

        def getInvitationsCount(
          request: GetInvitationsCountRequest
        ): Kleisli[M, Macie2Client, GetInvitationsCountResponse] =
          primitive(_.getInvitationsCount(request))

        def getMacieSession(
          request: GetMacieSessionRequest
        ): Kleisli[M, Macie2Client, GetMacieSessionResponse] =
          primitive(_.getMacieSession(request))

        def getMasterAccount(
          request: GetMasterAccountRequest
        ): Kleisli[M, Macie2Client, GetMasterAccountResponse] =
          primitive(_.getMasterAccount(request))

        def getMember(
          request: GetMemberRequest
        ): Kleisli[M, Macie2Client, GetMemberResponse] =
          primitive(_.getMember(request))

        def getUsageStatistics(
          request: GetUsageStatisticsRequest
        ): Kleisli[M, Macie2Client, GetUsageStatisticsResponse] =
          primitive(_.getUsageStatistics(request))

        def getUsageTotals(
          request: GetUsageTotalsRequest
        ): Kleisli[M, Macie2Client, GetUsageTotalsResponse] =
          primitive(_.getUsageTotals(request))

        def listClassificationJobs(
          request: ListClassificationJobsRequest
        ): Kleisli[M, Macie2Client, ListClassificationJobsResponse] =
          primitive(_.listClassificationJobs(request))

        def listCustomDataIdentifiers(
          request: ListCustomDataIdentifiersRequest
        ): Kleisli[M, Macie2Client, ListCustomDataIdentifiersResponse] =
          primitive(_.listCustomDataIdentifiers(request))

        def listFindings(
          request: ListFindingsRequest
        ): Kleisli[M, Macie2Client, ListFindingsResponse] =
          primitive(_.listFindings(request))

        def listFindingsFilters(
          request: ListFindingsFiltersRequest
        ): Kleisli[M, Macie2Client, ListFindingsFiltersResponse] =
          primitive(_.listFindingsFilters(request))

        def listInvitations(
          request: ListInvitationsRequest
        ): Kleisli[M, Macie2Client, ListInvitationsResponse] =
          primitive(_.listInvitations(request))

        def listMembers(
          request: ListMembersRequest
        ): Kleisli[M, Macie2Client, ListMembersResponse] =
          primitive(_.listMembers(request))

        def listOrganizationAdminAccounts(
          request: ListOrganizationAdminAccountsRequest
        ): Kleisli[M, Macie2Client, ListOrganizationAdminAccountsResponse] =
          primitive(_.listOrganizationAdminAccounts(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, Macie2Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putClassificationExportConfiguration(
          request: PutClassificationExportConfigurationRequest
        ): Kleisli[M, Macie2Client, PutClassificationExportConfigurationResponse] =
          primitive(_.putClassificationExportConfiguration(request))

        def putFindingsPublicationConfiguration(
          request: PutFindingsPublicationConfigurationRequest
        ): Kleisli[M, Macie2Client, PutFindingsPublicationConfigurationResponse] =
          primitive(_.putFindingsPublicationConfiguration(request))

        def searchResources(
          request: SearchResourcesRequest
        ): Kleisli[M, Macie2Client, SearchResourcesResponse] =
          primitive(_.searchResources(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, Macie2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testCustomDataIdentifier(
          request: TestCustomDataIdentifierRequest
        ): Kleisli[M, Macie2Client, TestCustomDataIdentifierResponse] =
          primitive(_.testCustomDataIdentifier(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, Macie2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateClassificationJob(
          request: UpdateClassificationJobRequest
        ): Kleisli[M, Macie2Client, UpdateClassificationJobResponse] =
          primitive(_.updateClassificationJob(request))

        def updateFindingsFilter(
          request: UpdateFindingsFilterRequest
        ): Kleisli[M, Macie2Client, UpdateFindingsFilterResponse] =
          primitive(_.updateFindingsFilter(request))

        def updateMacieSession(
          request: UpdateMacieSessionRequest
        ): Kleisli[M, Macie2Client, UpdateMacieSessionResponse] =
          primitive(_.updateMacieSession(request))

        def updateMemberSession(
          request: UpdateMemberSessionRequest
        ): Kleisli[M, Macie2Client, UpdateMemberSessionResponse] =
          primitive(_.updateMemberSession(request))

        def updateOrganizationConfiguration(
          request: UpdateOrganizationConfigurationRequest
        ): Kleisli[M, Macie2Client, UpdateOrganizationConfigurationResponse] =
          primitive(_.updateOrganizationConfiguration(request))

        def primitive[A](
          f: Macie2Client => A
        ): Kleisli[M, Macie2Client, A]
      }
    }

    trait Visitor[F[_]] extends (Macie2Op ~> F) {
      final def apply[A](op: Macie2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptInvitation(
        request: AcceptInvitationRequest
      ): F[AcceptInvitationResponse]

      def batchGetCustomDataIdentifiers(
        request: BatchGetCustomDataIdentifiersRequest
      ): F[BatchGetCustomDataIdentifiersResponse]

      def createClassificationJob(
        request: CreateClassificationJobRequest
      ): F[CreateClassificationJobResponse]

      def createCustomDataIdentifier(
        request: CreateCustomDataIdentifierRequest
      ): F[CreateCustomDataIdentifierResponse]

      def createFindingsFilter(
        request: CreateFindingsFilterRequest
      ): F[CreateFindingsFilterResponse]

      def createInvitations(
        request: CreateInvitationsRequest
      ): F[CreateInvitationsResponse]

      def createMember(
        request: CreateMemberRequest
      ): F[CreateMemberResponse]

      def createSampleFindings(
        request: CreateSampleFindingsRequest
      ): F[CreateSampleFindingsResponse]

      def declineInvitations(
        request: DeclineInvitationsRequest
      ): F[DeclineInvitationsResponse]

      def deleteCustomDataIdentifier(
        request: DeleteCustomDataIdentifierRequest
      ): F[DeleteCustomDataIdentifierResponse]

      def deleteFindingsFilter(
        request: DeleteFindingsFilterRequest
      ): F[DeleteFindingsFilterResponse]

      def deleteInvitations(
        request: DeleteInvitationsRequest
      ): F[DeleteInvitationsResponse]

      def deleteMember(
        request: DeleteMemberRequest
      ): F[DeleteMemberResponse]

      def describeBuckets(
        request: DescribeBucketsRequest
      ): F[DescribeBucketsResponse]

      def describeClassificationJob(
        request: DescribeClassificationJobRequest
      ): F[DescribeClassificationJobResponse]

      def describeOrganizationConfiguration(
        request: DescribeOrganizationConfigurationRequest
      ): F[DescribeOrganizationConfigurationResponse]

      def disableMacie(
        request: DisableMacieRequest
      ): F[DisableMacieResponse]

      def disableOrganizationAdminAccount(
        request: DisableOrganizationAdminAccountRequest
      ): F[DisableOrganizationAdminAccountResponse]

      def disassociateFromAdministratorAccount(
        request: DisassociateFromAdministratorAccountRequest
      ): F[DisassociateFromAdministratorAccountResponse]

      def disassociateFromMasterAccount(
        request: DisassociateFromMasterAccountRequest
      ): F[DisassociateFromMasterAccountResponse]

      def disassociateMember(
        request: DisassociateMemberRequest
      ): F[DisassociateMemberResponse]

      def enableMacie(
        request: EnableMacieRequest
      ): F[EnableMacieResponse]

      def enableOrganizationAdminAccount(
        request: EnableOrganizationAdminAccountRequest
      ): F[EnableOrganizationAdminAccountResponse]

      def getAdministratorAccount(
        request: GetAdministratorAccountRequest
      ): F[GetAdministratorAccountResponse]

      def getBucketStatistics(
        request: GetBucketStatisticsRequest
      ): F[GetBucketStatisticsResponse]

      def getClassificationExportConfiguration(
        request: GetClassificationExportConfigurationRequest
      ): F[GetClassificationExportConfigurationResponse]

      def getCustomDataIdentifier(
        request: GetCustomDataIdentifierRequest
      ): F[GetCustomDataIdentifierResponse]

      def getFindingStatistics(
        request: GetFindingStatisticsRequest
      ): F[GetFindingStatisticsResponse]

      def getFindings(
        request: GetFindingsRequest
      ): F[GetFindingsResponse]

      def getFindingsFilter(
        request: GetFindingsFilterRequest
      ): F[GetFindingsFilterResponse]

      def getFindingsPublicationConfiguration(
        request: GetFindingsPublicationConfigurationRequest
      ): F[GetFindingsPublicationConfigurationResponse]

      def getInvitationsCount(
        request: GetInvitationsCountRequest
      ): F[GetInvitationsCountResponse]

      def getMacieSession(
        request: GetMacieSessionRequest
      ): F[GetMacieSessionResponse]

      def getMasterAccount(
        request: GetMasterAccountRequest
      ): F[GetMasterAccountResponse]

      def getMember(
        request: GetMemberRequest
      ): F[GetMemberResponse]

      def getUsageStatistics(
        request: GetUsageStatisticsRequest
      ): F[GetUsageStatisticsResponse]

      def getUsageTotals(
        request: GetUsageTotalsRequest
      ): F[GetUsageTotalsResponse]

      def listClassificationJobs(
        request: ListClassificationJobsRequest
      ): F[ListClassificationJobsResponse]

      def listCustomDataIdentifiers(
        request: ListCustomDataIdentifiersRequest
      ): F[ListCustomDataIdentifiersResponse]

      def listFindings(
        request: ListFindingsRequest
      ): F[ListFindingsResponse]

      def listFindingsFilters(
        request: ListFindingsFiltersRequest
      ): F[ListFindingsFiltersResponse]

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

      def putClassificationExportConfiguration(
        request: PutClassificationExportConfigurationRequest
      ): F[PutClassificationExportConfigurationResponse]

      def putFindingsPublicationConfiguration(
        request: PutFindingsPublicationConfigurationRequest
      ): F[PutFindingsPublicationConfigurationResponse]

      def searchResources(
        request: SearchResourcesRequest
      ): F[SearchResourcesResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testCustomDataIdentifier(
        request: TestCustomDataIdentifierRequest
      ): F[TestCustomDataIdentifierResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateClassificationJob(
        request: UpdateClassificationJobRequest
      ): F[UpdateClassificationJobResponse]

      def updateFindingsFilter(
        request: UpdateFindingsFilterRequest
      ): F[UpdateFindingsFilterResponse]

      def updateMacieSession(
        request: UpdateMacieSessionRequest
      ): F[UpdateMacieSessionResponse]

      def updateMemberSession(
        request: UpdateMemberSessionRequest
      ): F[UpdateMemberSessionResponse]

      def updateOrganizationConfiguration(
        request: UpdateOrganizationConfigurationRequest
      ): F[UpdateOrganizationConfigurationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Macie2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptInvitationOp(
      request: AcceptInvitationRequest
    ) extends Macie2Op[AcceptInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptInvitationResponse] =
        visitor.acceptInvitation(request)
    }

    final case class BatchGetCustomDataIdentifiersOp(
      request: BatchGetCustomDataIdentifiersRequest
    ) extends Macie2Op[BatchGetCustomDataIdentifiersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetCustomDataIdentifiersResponse] =
        visitor.batchGetCustomDataIdentifiers(request)
    }

    final case class CreateClassificationJobOp(
      request: CreateClassificationJobRequest
    ) extends Macie2Op[CreateClassificationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClassificationJobResponse] =
        visitor.createClassificationJob(request)
    }

    final case class CreateCustomDataIdentifierOp(
      request: CreateCustomDataIdentifierRequest
    ) extends Macie2Op[CreateCustomDataIdentifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomDataIdentifierResponse] =
        visitor.createCustomDataIdentifier(request)
    }

    final case class CreateFindingsFilterOp(
      request: CreateFindingsFilterRequest
    ) extends Macie2Op[CreateFindingsFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFindingsFilterResponse] =
        visitor.createFindingsFilter(request)
    }

    final case class CreateInvitationsOp(
      request: CreateInvitationsRequest
    ) extends Macie2Op[CreateInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInvitationsResponse] =
        visitor.createInvitations(request)
    }

    final case class CreateMemberOp(
      request: CreateMemberRequest
    ) extends Macie2Op[CreateMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMemberResponse] =
        visitor.createMember(request)
    }

    final case class CreateSampleFindingsOp(
      request: CreateSampleFindingsRequest
    ) extends Macie2Op[CreateSampleFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSampleFindingsResponse] =
        visitor.createSampleFindings(request)
    }

    final case class DeclineInvitationsOp(
      request: DeclineInvitationsRequest
    ) extends Macie2Op[DeclineInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeclineInvitationsResponse] =
        visitor.declineInvitations(request)
    }

    final case class DeleteCustomDataIdentifierOp(
      request: DeleteCustomDataIdentifierRequest
    ) extends Macie2Op[DeleteCustomDataIdentifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomDataIdentifierResponse] =
        visitor.deleteCustomDataIdentifier(request)
    }

    final case class DeleteFindingsFilterOp(
      request: DeleteFindingsFilterRequest
    ) extends Macie2Op[DeleteFindingsFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFindingsFilterResponse] =
        visitor.deleteFindingsFilter(request)
    }

    final case class DeleteInvitationsOp(
      request: DeleteInvitationsRequest
    ) extends Macie2Op[DeleteInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInvitationsResponse] =
        visitor.deleteInvitations(request)
    }

    final case class DeleteMemberOp(
      request: DeleteMemberRequest
    ) extends Macie2Op[DeleteMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMemberResponse] =
        visitor.deleteMember(request)
    }

    final case class DescribeBucketsOp(
      request: DescribeBucketsRequest
    ) extends Macie2Op[DescribeBucketsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBucketsResponse] =
        visitor.describeBuckets(request)
    }

    final case class DescribeClassificationJobOp(
      request: DescribeClassificationJobRequest
    ) extends Macie2Op[DescribeClassificationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClassificationJobResponse] =
        visitor.describeClassificationJob(request)
    }

    final case class DescribeOrganizationConfigurationOp(
      request: DescribeOrganizationConfigurationRequest
    ) extends Macie2Op[DescribeOrganizationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationConfigurationResponse] =
        visitor.describeOrganizationConfiguration(request)
    }

    final case class DisableMacieOp(
      request: DisableMacieRequest
    ) extends Macie2Op[DisableMacieResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableMacieResponse] =
        visitor.disableMacie(request)
    }

    final case class DisableOrganizationAdminAccountOp(
      request: DisableOrganizationAdminAccountRequest
    ) extends Macie2Op[DisableOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableOrganizationAdminAccountResponse] =
        visitor.disableOrganizationAdminAccount(request)
    }

    final case class DisassociateFromAdministratorAccountOp(
      request: DisassociateFromAdministratorAccountRequest
    ) extends Macie2Op[DisassociateFromAdministratorAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFromAdministratorAccountResponse] =
        visitor.disassociateFromAdministratorAccount(request)
    }

    final case class DisassociateFromMasterAccountOp(
      request: DisassociateFromMasterAccountRequest
    ) extends Macie2Op[DisassociateFromMasterAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFromMasterAccountResponse] =
        visitor.disassociateFromMasterAccount(request)
    }

    final case class DisassociateMemberOp(
      request: DisassociateMemberRequest
    ) extends Macie2Op[DisassociateMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateMemberResponse] =
        visitor.disassociateMember(request)
    }

    final case class EnableMacieOp(
      request: EnableMacieRequest
    ) extends Macie2Op[EnableMacieResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableMacieResponse] =
        visitor.enableMacie(request)
    }

    final case class EnableOrganizationAdminAccountOp(
      request: EnableOrganizationAdminAccountRequest
    ) extends Macie2Op[EnableOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableOrganizationAdminAccountResponse] =
        visitor.enableOrganizationAdminAccount(request)
    }

    final case class GetAdministratorAccountOp(
      request: GetAdministratorAccountRequest
    ) extends Macie2Op[GetAdministratorAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAdministratorAccountResponse] =
        visitor.getAdministratorAccount(request)
    }

    final case class GetBucketStatisticsOp(
      request: GetBucketStatisticsRequest
    ) extends Macie2Op[GetBucketStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBucketStatisticsResponse] =
        visitor.getBucketStatistics(request)
    }

    final case class GetClassificationExportConfigurationOp(
      request: GetClassificationExportConfigurationRequest
    ) extends Macie2Op[GetClassificationExportConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetClassificationExportConfigurationResponse] =
        visitor.getClassificationExportConfiguration(request)
    }

    final case class GetCustomDataIdentifierOp(
      request: GetCustomDataIdentifierRequest
    ) extends Macie2Op[GetCustomDataIdentifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCustomDataIdentifierResponse] =
        visitor.getCustomDataIdentifier(request)
    }

    final case class GetFindingStatisticsOp(
      request: GetFindingStatisticsRequest
    ) extends Macie2Op[GetFindingStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingStatisticsResponse] =
        visitor.getFindingStatistics(request)
    }

    final case class GetFindingsOp(
      request: GetFindingsRequest
    ) extends Macie2Op[GetFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingsResponse] =
        visitor.getFindings(request)
    }

    final case class GetFindingsFilterOp(
      request: GetFindingsFilterRequest
    ) extends Macie2Op[GetFindingsFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingsFilterResponse] =
        visitor.getFindingsFilter(request)
    }

    final case class GetFindingsPublicationConfigurationOp(
      request: GetFindingsPublicationConfigurationRequest
    ) extends Macie2Op[GetFindingsPublicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFindingsPublicationConfigurationResponse] =
        visitor.getFindingsPublicationConfiguration(request)
    }

    final case class GetInvitationsCountOp(
      request: GetInvitationsCountRequest
    ) extends Macie2Op[GetInvitationsCountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInvitationsCountResponse] =
        visitor.getInvitationsCount(request)
    }

    final case class GetMacieSessionOp(
      request: GetMacieSessionRequest
    ) extends Macie2Op[GetMacieSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMacieSessionResponse] =
        visitor.getMacieSession(request)
    }

    final case class GetMasterAccountOp(
      request: GetMasterAccountRequest
    ) extends Macie2Op[GetMasterAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMasterAccountResponse] =
        visitor.getMasterAccount(request)
    }

    final case class GetMemberOp(
      request: GetMemberRequest
    ) extends Macie2Op[GetMemberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMemberResponse] =
        visitor.getMember(request)
    }

    final case class GetUsageStatisticsOp(
      request: GetUsageStatisticsRequest
    ) extends Macie2Op[GetUsageStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsageStatisticsResponse] =
        visitor.getUsageStatistics(request)
    }

    final case class GetUsageTotalsOp(
      request: GetUsageTotalsRequest
    ) extends Macie2Op[GetUsageTotalsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsageTotalsResponse] =
        visitor.getUsageTotals(request)
    }

    final case class ListClassificationJobsOp(
      request: ListClassificationJobsRequest
    ) extends Macie2Op[ListClassificationJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClassificationJobsResponse] =
        visitor.listClassificationJobs(request)
    }

    final case class ListCustomDataIdentifiersOp(
      request: ListCustomDataIdentifiersRequest
    ) extends Macie2Op[ListCustomDataIdentifiersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomDataIdentifiersResponse] =
        visitor.listCustomDataIdentifiers(request)
    }

    final case class ListFindingsOp(
      request: ListFindingsRequest
    ) extends Macie2Op[ListFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFindingsResponse] =
        visitor.listFindings(request)
    }

    final case class ListFindingsFiltersOp(
      request: ListFindingsFiltersRequest
    ) extends Macie2Op[ListFindingsFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFindingsFiltersResponse] =
        visitor.listFindingsFilters(request)
    }

    final case class ListInvitationsOp(
      request: ListInvitationsRequest
    ) extends Macie2Op[ListInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInvitationsResponse] =
        visitor.listInvitations(request)
    }

    final case class ListMembersOp(
      request: ListMembersRequest
    ) extends Macie2Op[ListMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMembersResponse] =
        visitor.listMembers(request)
    }

    final case class ListOrganizationAdminAccountsOp(
      request: ListOrganizationAdminAccountsRequest
    ) extends Macie2Op[ListOrganizationAdminAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOrganizationAdminAccountsResponse] =
        visitor.listOrganizationAdminAccounts(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends Macie2Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutClassificationExportConfigurationOp(
      request: PutClassificationExportConfigurationRequest
    ) extends Macie2Op[PutClassificationExportConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutClassificationExportConfigurationResponse] =
        visitor.putClassificationExportConfiguration(request)
    }

    final case class PutFindingsPublicationConfigurationOp(
      request: PutFindingsPublicationConfigurationRequest
    ) extends Macie2Op[PutFindingsPublicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFindingsPublicationConfigurationResponse] =
        visitor.putFindingsPublicationConfiguration(request)
    }

    final case class SearchResourcesOp(
      request: SearchResourcesRequest
    ) extends Macie2Op[SearchResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchResourcesResponse] =
        visitor.searchResources(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends Macie2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestCustomDataIdentifierOp(
      request: TestCustomDataIdentifierRequest
    ) extends Macie2Op[TestCustomDataIdentifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestCustomDataIdentifierResponse] =
        visitor.testCustomDataIdentifier(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends Macie2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateClassificationJobOp(
      request: UpdateClassificationJobRequest
    ) extends Macie2Op[UpdateClassificationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClassificationJobResponse] =
        visitor.updateClassificationJob(request)
    }

    final case class UpdateFindingsFilterOp(
      request: UpdateFindingsFilterRequest
    ) extends Macie2Op[UpdateFindingsFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFindingsFilterResponse] =
        visitor.updateFindingsFilter(request)
    }

    final case class UpdateMacieSessionOp(
      request: UpdateMacieSessionRequest
    ) extends Macie2Op[UpdateMacieSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMacieSessionResponse] =
        visitor.updateMacieSession(request)
    }

    final case class UpdateMemberSessionOp(
      request: UpdateMemberSessionRequest
    ) extends Macie2Op[UpdateMemberSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMemberSessionResponse] =
        visitor.updateMemberSession(request)
    }

    final case class UpdateOrganizationConfigurationOp(
      request: UpdateOrganizationConfigurationRequest
    ) extends Macie2Op[UpdateOrganizationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOrganizationConfigurationResponse] =
        visitor.updateOrganizationConfiguration(request)
    }
  }

  import Macie2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Macie2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptInvitation(
    request: AcceptInvitationRequest
  ): Macie2IO[AcceptInvitationResponse] =
    FF.liftF(AcceptInvitationOp(request))

  def batchGetCustomDataIdentifiers(
    request: BatchGetCustomDataIdentifiersRequest
  ): Macie2IO[BatchGetCustomDataIdentifiersResponse] =
    FF.liftF(BatchGetCustomDataIdentifiersOp(request))

  def createClassificationJob(
    request: CreateClassificationJobRequest
  ): Macie2IO[CreateClassificationJobResponse] =
    FF.liftF(CreateClassificationJobOp(request))

  def createCustomDataIdentifier(
    request: CreateCustomDataIdentifierRequest
  ): Macie2IO[CreateCustomDataIdentifierResponse] =
    FF.liftF(CreateCustomDataIdentifierOp(request))

  def createFindingsFilter(
    request: CreateFindingsFilterRequest
  ): Macie2IO[CreateFindingsFilterResponse] =
    FF.liftF(CreateFindingsFilterOp(request))

  def createInvitations(
    request: CreateInvitationsRequest
  ): Macie2IO[CreateInvitationsResponse] =
    FF.liftF(CreateInvitationsOp(request))

  def createMember(
    request: CreateMemberRequest
  ): Macie2IO[CreateMemberResponse] =
    FF.liftF(CreateMemberOp(request))

  def createSampleFindings(
    request: CreateSampleFindingsRequest
  ): Macie2IO[CreateSampleFindingsResponse] =
    FF.liftF(CreateSampleFindingsOp(request))

  def declineInvitations(
    request: DeclineInvitationsRequest
  ): Macie2IO[DeclineInvitationsResponse] =
    FF.liftF(DeclineInvitationsOp(request))

  def deleteCustomDataIdentifier(
    request: DeleteCustomDataIdentifierRequest
  ): Macie2IO[DeleteCustomDataIdentifierResponse] =
    FF.liftF(DeleteCustomDataIdentifierOp(request))

  def deleteFindingsFilter(
    request: DeleteFindingsFilterRequest
  ): Macie2IO[DeleteFindingsFilterResponse] =
    FF.liftF(DeleteFindingsFilterOp(request))

  def deleteInvitations(
    request: DeleteInvitationsRequest
  ): Macie2IO[DeleteInvitationsResponse] =
    FF.liftF(DeleteInvitationsOp(request))

  def deleteMember(
    request: DeleteMemberRequest
  ): Macie2IO[DeleteMemberResponse] =
    FF.liftF(DeleteMemberOp(request))

  def describeBuckets(
    request: DescribeBucketsRequest
  ): Macie2IO[DescribeBucketsResponse] =
    FF.liftF(DescribeBucketsOp(request))

  def describeClassificationJob(
    request: DescribeClassificationJobRequest
  ): Macie2IO[DescribeClassificationJobResponse] =
    FF.liftF(DescribeClassificationJobOp(request))

  def describeOrganizationConfiguration(
    request: DescribeOrganizationConfigurationRequest
  ): Macie2IO[DescribeOrganizationConfigurationResponse] =
    FF.liftF(DescribeOrganizationConfigurationOp(request))

  def disableMacie(
    request: DisableMacieRequest
  ): Macie2IO[DisableMacieResponse] =
    FF.liftF(DisableMacieOp(request))

  def disableOrganizationAdminAccount(
    request: DisableOrganizationAdminAccountRequest
  ): Macie2IO[DisableOrganizationAdminAccountResponse] =
    FF.liftF(DisableOrganizationAdminAccountOp(request))

  def disassociateFromAdministratorAccount(
    request: DisassociateFromAdministratorAccountRequest
  ): Macie2IO[DisassociateFromAdministratorAccountResponse] =
    FF.liftF(DisassociateFromAdministratorAccountOp(request))

  def disassociateFromMasterAccount(
    request: DisassociateFromMasterAccountRequest
  ): Macie2IO[DisassociateFromMasterAccountResponse] =
    FF.liftF(DisassociateFromMasterAccountOp(request))

  def disassociateMember(
    request: DisassociateMemberRequest
  ): Macie2IO[DisassociateMemberResponse] =
    FF.liftF(DisassociateMemberOp(request))

  def enableMacie(
    request: EnableMacieRequest
  ): Macie2IO[EnableMacieResponse] =
    FF.liftF(EnableMacieOp(request))

  def enableOrganizationAdminAccount(
    request: EnableOrganizationAdminAccountRequest
  ): Macie2IO[EnableOrganizationAdminAccountResponse] =
    FF.liftF(EnableOrganizationAdminAccountOp(request))

  def getAdministratorAccount(
    request: GetAdministratorAccountRequest
  ): Macie2IO[GetAdministratorAccountResponse] =
    FF.liftF(GetAdministratorAccountOp(request))

  def getBucketStatistics(
    request: GetBucketStatisticsRequest
  ): Macie2IO[GetBucketStatisticsResponse] =
    FF.liftF(GetBucketStatisticsOp(request))

  def getClassificationExportConfiguration(
    request: GetClassificationExportConfigurationRequest
  ): Macie2IO[GetClassificationExportConfigurationResponse] =
    FF.liftF(GetClassificationExportConfigurationOp(request))

  def getCustomDataIdentifier(
    request: GetCustomDataIdentifierRequest
  ): Macie2IO[GetCustomDataIdentifierResponse] =
    FF.liftF(GetCustomDataIdentifierOp(request))

  def getFindingStatistics(
    request: GetFindingStatisticsRequest
  ): Macie2IO[GetFindingStatisticsResponse] =
    FF.liftF(GetFindingStatisticsOp(request))

  def getFindings(
    request: GetFindingsRequest
  ): Macie2IO[GetFindingsResponse] =
    FF.liftF(GetFindingsOp(request))

  def getFindingsFilter(
    request: GetFindingsFilterRequest
  ): Macie2IO[GetFindingsFilterResponse] =
    FF.liftF(GetFindingsFilterOp(request))

  def getFindingsPublicationConfiguration(
    request: GetFindingsPublicationConfigurationRequest
  ): Macie2IO[GetFindingsPublicationConfigurationResponse] =
    FF.liftF(GetFindingsPublicationConfigurationOp(request))

  def getInvitationsCount(
    request: GetInvitationsCountRequest
  ): Macie2IO[GetInvitationsCountResponse] =
    FF.liftF(GetInvitationsCountOp(request))

  def getMacieSession(
    request: GetMacieSessionRequest
  ): Macie2IO[GetMacieSessionResponse] =
    FF.liftF(GetMacieSessionOp(request))

  def getMasterAccount(
    request: GetMasterAccountRequest
  ): Macie2IO[GetMasterAccountResponse] =
    FF.liftF(GetMasterAccountOp(request))

  def getMember(
    request: GetMemberRequest
  ): Macie2IO[GetMemberResponse] =
    FF.liftF(GetMemberOp(request))

  def getUsageStatistics(
    request: GetUsageStatisticsRequest
  ): Macie2IO[GetUsageStatisticsResponse] =
    FF.liftF(GetUsageStatisticsOp(request))

  def getUsageTotals(
    request: GetUsageTotalsRequest
  ): Macie2IO[GetUsageTotalsResponse] =
    FF.liftF(GetUsageTotalsOp(request))

  def listClassificationJobs(
    request: ListClassificationJobsRequest
  ): Macie2IO[ListClassificationJobsResponse] =
    FF.liftF(ListClassificationJobsOp(request))

  def listCustomDataIdentifiers(
    request: ListCustomDataIdentifiersRequest
  ): Macie2IO[ListCustomDataIdentifiersResponse] =
    FF.liftF(ListCustomDataIdentifiersOp(request))

  def listFindings(
    request: ListFindingsRequest
  ): Macie2IO[ListFindingsResponse] =
    FF.liftF(ListFindingsOp(request))

  def listFindingsFilters(
    request: ListFindingsFiltersRequest
  ): Macie2IO[ListFindingsFiltersResponse] =
    FF.liftF(ListFindingsFiltersOp(request))

  def listInvitations(
    request: ListInvitationsRequest
  ): Macie2IO[ListInvitationsResponse] =
    FF.liftF(ListInvitationsOp(request))

  def listMembers(
    request: ListMembersRequest
  ): Macie2IO[ListMembersResponse] =
    FF.liftF(ListMembersOp(request))

  def listOrganizationAdminAccounts(
    request: ListOrganizationAdminAccountsRequest
  ): Macie2IO[ListOrganizationAdminAccountsResponse] =
    FF.liftF(ListOrganizationAdminAccountsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): Macie2IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putClassificationExportConfiguration(
    request: PutClassificationExportConfigurationRequest
  ): Macie2IO[PutClassificationExportConfigurationResponse] =
    FF.liftF(PutClassificationExportConfigurationOp(request))

  def putFindingsPublicationConfiguration(
    request: PutFindingsPublicationConfigurationRequest
  ): Macie2IO[PutFindingsPublicationConfigurationResponse] =
    FF.liftF(PutFindingsPublicationConfigurationOp(request))

  def searchResources(
    request: SearchResourcesRequest
  ): Macie2IO[SearchResourcesResponse] =
    FF.liftF(SearchResourcesOp(request))

  def tagResource(
    request: TagResourceRequest
  ): Macie2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testCustomDataIdentifier(
    request: TestCustomDataIdentifierRequest
  ): Macie2IO[TestCustomDataIdentifierResponse] =
    FF.liftF(TestCustomDataIdentifierOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): Macie2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateClassificationJob(
    request: UpdateClassificationJobRequest
  ): Macie2IO[UpdateClassificationJobResponse] =
    FF.liftF(UpdateClassificationJobOp(request))

  def updateFindingsFilter(
    request: UpdateFindingsFilterRequest
  ): Macie2IO[UpdateFindingsFilterResponse] =
    FF.liftF(UpdateFindingsFilterOp(request))

  def updateMacieSession(
    request: UpdateMacieSessionRequest
  ): Macie2IO[UpdateMacieSessionResponse] =
    FF.liftF(UpdateMacieSessionOp(request))

  def updateMemberSession(
    request: UpdateMemberSessionRequest
  ): Macie2IO[UpdateMemberSessionResponse] =
    FF.liftF(UpdateMemberSessionOp(request))

  def updateOrganizationConfiguration(
    request: UpdateOrganizationConfigurationRequest
  ): Macie2IO[UpdateOrganizationConfigurationResponse] =
    FF.liftF(UpdateOrganizationConfigurationOp(request))
}
