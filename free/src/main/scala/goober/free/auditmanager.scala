package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.auditmanager.AuditManagerClient
import software.amazon.awssdk.services.auditmanager.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object auditmanager { module =>

  // Free monad over AuditManagerOp
  type AuditManagerIO[A] = FF[AuditManagerOp, A]

  sealed trait AuditManagerOp[A] {
    def visit[F[_]](visitor: AuditManagerOp.Visitor[F]): F[A]
  }

  object AuditManagerOp {
    // Given a AuditManagerClient we can embed a AuditManagerIO program in any algebra that understands embedding.
    implicit val AuditManagerOpEmbeddable: Embeddable[AuditManagerOp, AuditManagerClient] = new Embeddable[AuditManagerOp, AuditManagerClient] {
      def embed[A](client: AuditManagerClient, io: AuditManagerIO[A]): Embedded[A] = Embedded.AuditManager(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AuditManagerOp.Visitor[Kleisli[M, AuditManagerClient, *]] {
        def associateAssessmentReportEvidenceFolder(
          request: AssociateAssessmentReportEvidenceFolderRequest
        ): Kleisli[M, AuditManagerClient, AssociateAssessmentReportEvidenceFolderResponse] =
          primitive(_.associateAssessmentReportEvidenceFolder(request))

        def batchAssociateAssessmentReportEvidence(
          request: BatchAssociateAssessmentReportEvidenceRequest
        ): Kleisli[M, AuditManagerClient, BatchAssociateAssessmentReportEvidenceResponse] =
          primitive(_.batchAssociateAssessmentReportEvidence(request))

        def batchCreateDelegationByAssessment(
          request: BatchCreateDelegationByAssessmentRequest
        ): Kleisli[M, AuditManagerClient, BatchCreateDelegationByAssessmentResponse] =
          primitive(_.batchCreateDelegationByAssessment(request))

        def batchDeleteDelegationByAssessment(
          request: BatchDeleteDelegationByAssessmentRequest
        ): Kleisli[M, AuditManagerClient, BatchDeleteDelegationByAssessmentResponse] =
          primitive(_.batchDeleteDelegationByAssessment(request))

        def batchDisassociateAssessmentReportEvidence(
          request: BatchDisassociateAssessmentReportEvidenceRequest
        ): Kleisli[M, AuditManagerClient, BatchDisassociateAssessmentReportEvidenceResponse] =
          primitive(_.batchDisassociateAssessmentReportEvidence(request))

        def batchImportEvidenceToAssessmentControl(
          request: BatchImportEvidenceToAssessmentControlRequest
        ): Kleisli[M, AuditManagerClient, BatchImportEvidenceToAssessmentControlResponse] =
          primitive(_.batchImportEvidenceToAssessmentControl(request))

        def createAssessment(
          request: CreateAssessmentRequest
        ): Kleisli[M, AuditManagerClient, CreateAssessmentResponse] =
          primitive(_.createAssessment(request))

        def createAssessmentFramework(
          request: CreateAssessmentFrameworkRequest
        ): Kleisli[M, AuditManagerClient, CreateAssessmentFrameworkResponse] =
          primitive(_.createAssessmentFramework(request))

        def createAssessmentReport(
          request: CreateAssessmentReportRequest
        ): Kleisli[M, AuditManagerClient, CreateAssessmentReportResponse] =
          primitive(_.createAssessmentReport(request))

        def createControl(
          request: CreateControlRequest
        ): Kleisli[M, AuditManagerClient, CreateControlResponse] =
          primitive(_.createControl(request))

        def deleteAssessment(
          request: DeleteAssessmentRequest
        ): Kleisli[M, AuditManagerClient, DeleteAssessmentResponse] =
          primitive(_.deleteAssessment(request))

        def deleteAssessmentFramework(
          request: DeleteAssessmentFrameworkRequest
        ): Kleisli[M, AuditManagerClient, DeleteAssessmentFrameworkResponse] =
          primitive(_.deleteAssessmentFramework(request))

        def deleteAssessmentReport(
          request: DeleteAssessmentReportRequest
        ): Kleisli[M, AuditManagerClient, DeleteAssessmentReportResponse] =
          primitive(_.deleteAssessmentReport(request))

        def deleteControl(
          request: DeleteControlRequest
        ): Kleisli[M, AuditManagerClient, DeleteControlResponse] =
          primitive(_.deleteControl(request))

        def deregisterAccount(
          request: DeregisterAccountRequest
        ): Kleisli[M, AuditManagerClient, DeregisterAccountResponse] =
          primitive(_.deregisterAccount(request))

        def deregisterOrganizationAdminAccount(
          request: DeregisterOrganizationAdminAccountRequest
        ): Kleisli[M, AuditManagerClient, DeregisterOrganizationAdminAccountResponse] =
          primitive(_.deregisterOrganizationAdminAccount(request))

        def disassociateAssessmentReportEvidenceFolder(
          request: DisassociateAssessmentReportEvidenceFolderRequest
        ): Kleisli[M, AuditManagerClient, DisassociateAssessmentReportEvidenceFolderResponse] =
          primitive(_.disassociateAssessmentReportEvidenceFolder(request))

        def getAccountStatus(
          request: GetAccountStatusRequest
        ): Kleisli[M, AuditManagerClient, GetAccountStatusResponse] =
          primitive(_.getAccountStatus(request))

        def getAssessment(
          request: GetAssessmentRequest
        ): Kleisli[M, AuditManagerClient, GetAssessmentResponse] =
          primitive(_.getAssessment(request))

        def getAssessmentFramework(
          request: GetAssessmentFrameworkRequest
        ): Kleisli[M, AuditManagerClient, GetAssessmentFrameworkResponse] =
          primitive(_.getAssessmentFramework(request))

        def getAssessmentReportUrl(
          request: GetAssessmentReportUrlRequest
        ): Kleisli[M, AuditManagerClient, GetAssessmentReportUrlResponse] =
          primitive(_.getAssessmentReportUrl(request))

        def getChangeLogs(
          request: GetChangeLogsRequest
        ): Kleisli[M, AuditManagerClient, GetChangeLogsResponse] =
          primitive(_.getChangeLogs(request))

        def getControl(
          request: GetControlRequest
        ): Kleisli[M, AuditManagerClient, GetControlResponse] =
          primitive(_.getControl(request))

        def getDelegations(
          request: GetDelegationsRequest
        ): Kleisli[M, AuditManagerClient, GetDelegationsResponse] =
          primitive(_.getDelegations(request))

        def getEvidence(
          request: GetEvidenceRequest
        ): Kleisli[M, AuditManagerClient, GetEvidenceResponse] =
          primitive(_.getEvidence(request))

        def getEvidenceByEvidenceFolder(
          request: GetEvidenceByEvidenceFolderRequest
        ): Kleisli[M, AuditManagerClient, GetEvidenceByEvidenceFolderResponse] =
          primitive(_.getEvidenceByEvidenceFolder(request))

        def getEvidenceFolder(
          request: GetEvidenceFolderRequest
        ): Kleisli[M, AuditManagerClient, GetEvidenceFolderResponse] =
          primitive(_.getEvidenceFolder(request))

        def getEvidenceFoldersByAssessment(
          request: GetEvidenceFoldersByAssessmentRequest
        ): Kleisli[M, AuditManagerClient, GetEvidenceFoldersByAssessmentResponse] =
          primitive(_.getEvidenceFoldersByAssessment(request))

        def getEvidenceFoldersByAssessmentControl(
          request: GetEvidenceFoldersByAssessmentControlRequest
        ): Kleisli[M, AuditManagerClient, GetEvidenceFoldersByAssessmentControlResponse] =
          primitive(_.getEvidenceFoldersByAssessmentControl(request))

        def getOrganizationAdminAccount(
          request: GetOrganizationAdminAccountRequest
        ): Kleisli[M, AuditManagerClient, GetOrganizationAdminAccountResponse] =
          primitive(_.getOrganizationAdminAccount(request))

        def getServicesInScope(
          request: GetServicesInScopeRequest
        ): Kleisli[M, AuditManagerClient, GetServicesInScopeResponse] =
          primitive(_.getServicesInScope(request))

        def getSettings(
          request: GetSettingsRequest
        ): Kleisli[M, AuditManagerClient, GetSettingsResponse] =
          primitive(_.getSettings(request))

        def listAssessmentFrameworks(
          request: ListAssessmentFrameworksRequest
        ): Kleisli[M, AuditManagerClient, ListAssessmentFrameworksResponse] =
          primitive(_.listAssessmentFrameworks(request))

        def listAssessmentReports(
          request: ListAssessmentReportsRequest
        ): Kleisli[M, AuditManagerClient, ListAssessmentReportsResponse] =
          primitive(_.listAssessmentReports(request))

        def listAssessments(
          request: ListAssessmentsRequest
        ): Kleisli[M, AuditManagerClient, ListAssessmentsResponse] =
          primitive(_.listAssessments(request))

        def listControls(
          request: ListControlsRequest
        ): Kleisli[M, AuditManagerClient, ListControlsResponse] =
          primitive(_.listControls(request))

        def listKeywordsForDataSource(
          request: ListKeywordsForDataSourceRequest
        ): Kleisli[M, AuditManagerClient, ListKeywordsForDataSourceResponse] =
          primitive(_.listKeywordsForDataSource(request))

        def listNotifications(
          request: ListNotificationsRequest
        ): Kleisli[M, AuditManagerClient, ListNotificationsResponse] =
          primitive(_.listNotifications(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AuditManagerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def registerAccount(
          request: RegisterAccountRequest
        ): Kleisli[M, AuditManagerClient, RegisterAccountResponse] =
          primitive(_.registerAccount(request))

        def registerOrganizationAdminAccount(
          request: RegisterOrganizationAdminAccountRequest
        ): Kleisli[M, AuditManagerClient, RegisterOrganizationAdminAccountResponse] =
          primitive(_.registerOrganizationAdminAccount(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AuditManagerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AuditManagerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAssessment(
          request: UpdateAssessmentRequest
        ): Kleisli[M, AuditManagerClient, UpdateAssessmentResponse] =
          primitive(_.updateAssessment(request))

        def updateAssessmentControl(
          request: UpdateAssessmentControlRequest
        ): Kleisli[M, AuditManagerClient, UpdateAssessmentControlResponse] =
          primitive(_.updateAssessmentControl(request))

        def updateAssessmentControlSetStatus(
          request: UpdateAssessmentControlSetStatusRequest
        ): Kleisli[M, AuditManagerClient, UpdateAssessmentControlSetStatusResponse] =
          primitive(_.updateAssessmentControlSetStatus(request))

        def updateAssessmentFramework(
          request: UpdateAssessmentFrameworkRequest
        ): Kleisli[M, AuditManagerClient, UpdateAssessmentFrameworkResponse] =
          primitive(_.updateAssessmentFramework(request))

        def updateAssessmentStatus(
          request: UpdateAssessmentStatusRequest
        ): Kleisli[M, AuditManagerClient, UpdateAssessmentStatusResponse] =
          primitive(_.updateAssessmentStatus(request))

        def updateControl(
          request: UpdateControlRequest
        ): Kleisli[M, AuditManagerClient, UpdateControlResponse] =
          primitive(_.updateControl(request))

        def updateSettings(
          request: UpdateSettingsRequest
        ): Kleisli[M, AuditManagerClient, UpdateSettingsResponse] =
          primitive(_.updateSettings(request))

        def validateAssessmentReportIntegrity(
          request: ValidateAssessmentReportIntegrityRequest
        ): Kleisli[M, AuditManagerClient, ValidateAssessmentReportIntegrityResponse] =
          primitive(_.validateAssessmentReportIntegrity(request))

        def primitive[A](
          f: AuditManagerClient => A
        ): Kleisli[M, AuditManagerClient, A]
      }
    }

    trait Visitor[F[_]] extends (AuditManagerOp ~> F) {
      final def apply[A](op: AuditManagerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateAssessmentReportEvidenceFolder(
        request: AssociateAssessmentReportEvidenceFolderRequest
      ): F[AssociateAssessmentReportEvidenceFolderResponse]

      def batchAssociateAssessmentReportEvidence(
        request: BatchAssociateAssessmentReportEvidenceRequest
      ): F[BatchAssociateAssessmentReportEvidenceResponse]

      def batchCreateDelegationByAssessment(
        request: BatchCreateDelegationByAssessmentRequest
      ): F[BatchCreateDelegationByAssessmentResponse]

      def batchDeleteDelegationByAssessment(
        request: BatchDeleteDelegationByAssessmentRequest
      ): F[BatchDeleteDelegationByAssessmentResponse]

      def batchDisassociateAssessmentReportEvidence(
        request: BatchDisassociateAssessmentReportEvidenceRequest
      ): F[BatchDisassociateAssessmentReportEvidenceResponse]

      def batchImportEvidenceToAssessmentControl(
        request: BatchImportEvidenceToAssessmentControlRequest
      ): F[BatchImportEvidenceToAssessmentControlResponse]

      def createAssessment(
        request: CreateAssessmentRequest
      ): F[CreateAssessmentResponse]

      def createAssessmentFramework(
        request: CreateAssessmentFrameworkRequest
      ): F[CreateAssessmentFrameworkResponse]

      def createAssessmentReport(
        request: CreateAssessmentReportRequest
      ): F[CreateAssessmentReportResponse]

      def createControl(
        request: CreateControlRequest
      ): F[CreateControlResponse]

      def deleteAssessment(
        request: DeleteAssessmentRequest
      ): F[DeleteAssessmentResponse]

      def deleteAssessmentFramework(
        request: DeleteAssessmentFrameworkRequest
      ): F[DeleteAssessmentFrameworkResponse]

      def deleteAssessmentReport(
        request: DeleteAssessmentReportRequest
      ): F[DeleteAssessmentReportResponse]

      def deleteControl(
        request: DeleteControlRequest
      ): F[DeleteControlResponse]

      def deregisterAccount(
        request: DeregisterAccountRequest
      ): F[DeregisterAccountResponse]

      def deregisterOrganizationAdminAccount(
        request: DeregisterOrganizationAdminAccountRequest
      ): F[DeregisterOrganizationAdminAccountResponse]

      def disassociateAssessmentReportEvidenceFolder(
        request: DisassociateAssessmentReportEvidenceFolderRequest
      ): F[DisassociateAssessmentReportEvidenceFolderResponse]

      def getAccountStatus(
        request: GetAccountStatusRequest
      ): F[GetAccountStatusResponse]

      def getAssessment(
        request: GetAssessmentRequest
      ): F[GetAssessmentResponse]

      def getAssessmentFramework(
        request: GetAssessmentFrameworkRequest
      ): F[GetAssessmentFrameworkResponse]

      def getAssessmentReportUrl(
        request: GetAssessmentReportUrlRequest
      ): F[GetAssessmentReportUrlResponse]

      def getChangeLogs(
        request: GetChangeLogsRequest
      ): F[GetChangeLogsResponse]

      def getControl(
        request: GetControlRequest
      ): F[GetControlResponse]

      def getDelegations(
        request: GetDelegationsRequest
      ): F[GetDelegationsResponse]

      def getEvidence(
        request: GetEvidenceRequest
      ): F[GetEvidenceResponse]

      def getEvidenceByEvidenceFolder(
        request: GetEvidenceByEvidenceFolderRequest
      ): F[GetEvidenceByEvidenceFolderResponse]

      def getEvidenceFolder(
        request: GetEvidenceFolderRequest
      ): F[GetEvidenceFolderResponse]

      def getEvidenceFoldersByAssessment(
        request: GetEvidenceFoldersByAssessmentRequest
      ): F[GetEvidenceFoldersByAssessmentResponse]

      def getEvidenceFoldersByAssessmentControl(
        request: GetEvidenceFoldersByAssessmentControlRequest
      ): F[GetEvidenceFoldersByAssessmentControlResponse]

      def getOrganizationAdminAccount(
        request: GetOrganizationAdminAccountRequest
      ): F[GetOrganizationAdminAccountResponse]

      def getServicesInScope(
        request: GetServicesInScopeRequest
      ): F[GetServicesInScopeResponse]

      def getSettings(
        request: GetSettingsRequest
      ): F[GetSettingsResponse]

      def listAssessmentFrameworks(
        request: ListAssessmentFrameworksRequest
      ): F[ListAssessmentFrameworksResponse]

      def listAssessmentReports(
        request: ListAssessmentReportsRequest
      ): F[ListAssessmentReportsResponse]

      def listAssessments(
        request: ListAssessmentsRequest
      ): F[ListAssessmentsResponse]

      def listControls(
        request: ListControlsRequest
      ): F[ListControlsResponse]

      def listKeywordsForDataSource(
        request: ListKeywordsForDataSourceRequest
      ): F[ListKeywordsForDataSourceResponse]

      def listNotifications(
        request: ListNotificationsRequest
      ): F[ListNotificationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def registerAccount(
        request: RegisterAccountRequest
      ): F[RegisterAccountResponse]

      def registerOrganizationAdminAccount(
        request: RegisterOrganizationAdminAccountRequest
      ): F[RegisterOrganizationAdminAccountResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAssessment(
        request: UpdateAssessmentRequest
      ): F[UpdateAssessmentResponse]

      def updateAssessmentControl(
        request: UpdateAssessmentControlRequest
      ): F[UpdateAssessmentControlResponse]

      def updateAssessmentControlSetStatus(
        request: UpdateAssessmentControlSetStatusRequest
      ): F[UpdateAssessmentControlSetStatusResponse]

      def updateAssessmentFramework(
        request: UpdateAssessmentFrameworkRequest
      ): F[UpdateAssessmentFrameworkResponse]

      def updateAssessmentStatus(
        request: UpdateAssessmentStatusRequest
      ): F[UpdateAssessmentStatusResponse]

      def updateControl(
        request: UpdateControlRequest
      ): F[UpdateControlResponse]

      def updateSettings(
        request: UpdateSettingsRequest
      ): F[UpdateSettingsResponse]

      def validateAssessmentReportIntegrity(
        request: ValidateAssessmentReportIntegrityRequest
      ): F[ValidateAssessmentReportIntegrityResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AuditManagerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateAssessmentReportEvidenceFolderOp(
      request: AssociateAssessmentReportEvidenceFolderRequest
    ) extends AuditManagerOp[AssociateAssessmentReportEvidenceFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateAssessmentReportEvidenceFolderResponse] =
        visitor.associateAssessmentReportEvidenceFolder(request)
    }

    final case class BatchAssociateAssessmentReportEvidenceOp(
      request: BatchAssociateAssessmentReportEvidenceRequest
    ) extends AuditManagerOp[BatchAssociateAssessmentReportEvidenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAssociateAssessmentReportEvidenceResponse] =
        visitor.batchAssociateAssessmentReportEvidence(request)
    }

    final case class BatchCreateDelegationByAssessmentOp(
      request: BatchCreateDelegationByAssessmentRequest
    ) extends AuditManagerOp[BatchCreateDelegationByAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCreateDelegationByAssessmentResponse] =
        visitor.batchCreateDelegationByAssessment(request)
    }

    final case class BatchDeleteDelegationByAssessmentOp(
      request: BatchDeleteDelegationByAssessmentRequest
    ) extends AuditManagerOp[BatchDeleteDelegationByAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteDelegationByAssessmentResponse] =
        visitor.batchDeleteDelegationByAssessment(request)
    }

    final case class BatchDisassociateAssessmentReportEvidenceOp(
      request: BatchDisassociateAssessmentReportEvidenceRequest
    ) extends AuditManagerOp[BatchDisassociateAssessmentReportEvidenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisassociateAssessmentReportEvidenceResponse] =
        visitor.batchDisassociateAssessmentReportEvidence(request)
    }

    final case class BatchImportEvidenceToAssessmentControlOp(
      request: BatchImportEvidenceToAssessmentControlRequest
    ) extends AuditManagerOp[BatchImportEvidenceToAssessmentControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchImportEvidenceToAssessmentControlResponse] =
        visitor.batchImportEvidenceToAssessmentControl(request)
    }

    final case class CreateAssessmentOp(
      request: CreateAssessmentRequest
    ) extends AuditManagerOp[CreateAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssessmentResponse] =
        visitor.createAssessment(request)
    }

    final case class CreateAssessmentFrameworkOp(
      request: CreateAssessmentFrameworkRequest
    ) extends AuditManagerOp[CreateAssessmentFrameworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssessmentFrameworkResponse] =
        visitor.createAssessmentFramework(request)
    }

    final case class CreateAssessmentReportOp(
      request: CreateAssessmentReportRequest
    ) extends AuditManagerOp[CreateAssessmentReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssessmentReportResponse] =
        visitor.createAssessmentReport(request)
    }

    final case class CreateControlOp(
      request: CreateControlRequest
    ) extends AuditManagerOp[CreateControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateControlResponse] =
        visitor.createControl(request)
    }

    final case class DeleteAssessmentOp(
      request: DeleteAssessmentRequest
    ) extends AuditManagerOp[DeleteAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssessmentResponse] =
        visitor.deleteAssessment(request)
    }

    final case class DeleteAssessmentFrameworkOp(
      request: DeleteAssessmentFrameworkRequest
    ) extends AuditManagerOp[DeleteAssessmentFrameworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssessmentFrameworkResponse] =
        visitor.deleteAssessmentFramework(request)
    }

    final case class DeleteAssessmentReportOp(
      request: DeleteAssessmentReportRequest
    ) extends AuditManagerOp[DeleteAssessmentReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssessmentReportResponse] =
        visitor.deleteAssessmentReport(request)
    }

    final case class DeleteControlOp(
      request: DeleteControlRequest
    ) extends AuditManagerOp[DeleteControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteControlResponse] =
        visitor.deleteControl(request)
    }

    final case class DeregisterAccountOp(
      request: DeregisterAccountRequest
    ) extends AuditManagerOp[DeregisterAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterAccountResponse] =
        visitor.deregisterAccount(request)
    }

    final case class DeregisterOrganizationAdminAccountOp(
      request: DeregisterOrganizationAdminAccountRequest
    ) extends AuditManagerOp[DeregisterOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterOrganizationAdminAccountResponse] =
        visitor.deregisterOrganizationAdminAccount(request)
    }

    final case class DisassociateAssessmentReportEvidenceFolderOp(
      request: DisassociateAssessmentReportEvidenceFolderRequest
    ) extends AuditManagerOp[DisassociateAssessmentReportEvidenceFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateAssessmentReportEvidenceFolderResponse] =
        visitor.disassociateAssessmentReportEvidenceFolder(request)
    }

    final case class GetAccountStatusOp(
      request: GetAccountStatusRequest
    ) extends AuditManagerOp[GetAccountStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountStatusResponse] =
        visitor.getAccountStatus(request)
    }

    final case class GetAssessmentOp(
      request: GetAssessmentRequest
    ) extends AuditManagerOp[GetAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssessmentResponse] =
        visitor.getAssessment(request)
    }

    final case class GetAssessmentFrameworkOp(
      request: GetAssessmentFrameworkRequest
    ) extends AuditManagerOp[GetAssessmentFrameworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssessmentFrameworkResponse] =
        visitor.getAssessmentFramework(request)
    }

    final case class GetAssessmentReportUrlOp(
      request: GetAssessmentReportUrlRequest
    ) extends AuditManagerOp[GetAssessmentReportUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssessmentReportUrlResponse] =
        visitor.getAssessmentReportUrl(request)
    }

    final case class GetChangeLogsOp(
      request: GetChangeLogsRequest
    ) extends AuditManagerOp[GetChangeLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChangeLogsResponse] =
        visitor.getChangeLogs(request)
    }

    final case class GetControlOp(
      request: GetControlRequest
    ) extends AuditManagerOp[GetControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetControlResponse] =
        visitor.getControl(request)
    }

    final case class GetDelegationsOp(
      request: GetDelegationsRequest
    ) extends AuditManagerOp[GetDelegationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDelegationsResponse] =
        visitor.getDelegations(request)
    }

    final case class GetEvidenceOp(
      request: GetEvidenceRequest
    ) extends AuditManagerOp[GetEvidenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEvidenceResponse] =
        visitor.getEvidence(request)
    }

    final case class GetEvidenceByEvidenceFolderOp(
      request: GetEvidenceByEvidenceFolderRequest
    ) extends AuditManagerOp[GetEvidenceByEvidenceFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEvidenceByEvidenceFolderResponse] =
        visitor.getEvidenceByEvidenceFolder(request)
    }

    final case class GetEvidenceFolderOp(
      request: GetEvidenceFolderRequest
    ) extends AuditManagerOp[GetEvidenceFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEvidenceFolderResponse] =
        visitor.getEvidenceFolder(request)
    }

    final case class GetEvidenceFoldersByAssessmentOp(
      request: GetEvidenceFoldersByAssessmentRequest
    ) extends AuditManagerOp[GetEvidenceFoldersByAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEvidenceFoldersByAssessmentResponse] =
        visitor.getEvidenceFoldersByAssessment(request)
    }

    final case class GetEvidenceFoldersByAssessmentControlOp(
      request: GetEvidenceFoldersByAssessmentControlRequest
    ) extends AuditManagerOp[GetEvidenceFoldersByAssessmentControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEvidenceFoldersByAssessmentControlResponse] =
        visitor.getEvidenceFoldersByAssessmentControl(request)
    }

    final case class GetOrganizationAdminAccountOp(
      request: GetOrganizationAdminAccountRequest
    ) extends AuditManagerOp[GetOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOrganizationAdminAccountResponse] =
        visitor.getOrganizationAdminAccount(request)
    }

    final case class GetServicesInScopeOp(
      request: GetServicesInScopeRequest
    ) extends AuditManagerOp[GetServicesInScopeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServicesInScopeResponse] =
        visitor.getServicesInScope(request)
    }

    final case class GetSettingsOp(
      request: GetSettingsRequest
    ) extends AuditManagerOp[GetSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSettingsResponse] =
        visitor.getSettings(request)
    }

    final case class ListAssessmentFrameworksOp(
      request: ListAssessmentFrameworksRequest
    ) extends AuditManagerOp[ListAssessmentFrameworksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssessmentFrameworksResponse] =
        visitor.listAssessmentFrameworks(request)
    }

    final case class ListAssessmentReportsOp(
      request: ListAssessmentReportsRequest
    ) extends AuditManagerOp[ListAssessmentReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssessmentReportsResponse] =
        visitor.listAssessmentReports(request)
    }

    final case class ListAssessmentsOp(
      request: ListAssessmentsRequest
    ) extends AuditManagerOp[ListAssessmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssessmentsResponse] =
        visitor.listAssessments(request)
    }

    final case class ListControlsOp(
      request: ListControlsRequest
    ) extends AuditManagerOp[ListControlsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListControlsResponse] =
        visitor.listControls(request)
    }

    final case class ListKeywordsForDataSourceOp(
      request: ListKeywordsForDataSourceRequest
    ) extends AuditManagerOp[ListKeywordsForDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListKeywordsForDataSourceResponse] =
        visitor.listKeywordsForDataSource(request)
    }

    final case class ListNotificationsOp(
      request: ListNotificationsRequest
    ) extends AuditManagerOp[ListNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNotificationsResponse] =
        visitor.listNotifications(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AuditManagerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RegisterAccountOp(
      request: RegisterAccountRequest
    ) extends AuditManagerOp[RegisterAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterAccountResponse] =
        visitor.registerAccount(request)
    }

    final case class RegisterOrganizationAdminAccountOp(
      request: RegisterOrganizationAdminAccountRequest
    ) extends AuditManagerOp[RegisterOrganizationAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterOrganizationAdminAccountResponse] =
        visitor.registerOrganizationAdminAccount(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AuditManagerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AuditManagerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAssessmentOp(
      request: UpdateAssessmentRequest
    ) extends AuditManagerOp[UpdateAssessmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssessmentResponse] =
        visitor.updateAssessment(request)
    }

    final case class UpdateAssessmentControlOp(
      request: UpdateAssessmentControlRequest
    ) extends AuditManagerOp[UpdateAssessmentControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssessmentControlResponse] =
        visitor.updateAssessmentControl(request)
    }

    final case class UpdateAssessmentControlSetStatusOp(
      request: UpdateAssessmentControlSetStatusRequest
    ) extends AuditManagerOp[UpdateAssessmentControlSetStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssessmentControlSetStatusResponse] =
        visitor.updateAssessmentControlSetStatus(request)
    }

    final case class UpdateAssessmentFrameworkOp(
      request: UpdateAssessmentFrameworkRequest
    ) extends AuditManagerOp[UpdateAssessmentFrameworkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssessmentFrameworkResponse] =
        visitor.updateAssessmentFramework(request)
    }

    final case class UpdateAssessmentStatusOp(
      request: UpdateAssessmentStatusRequest
    ) extends AuditManagerOp[UpdateAssessmentStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssessmentStatusResponse] =
        visitor.updateAssessmentStatus(request)
    }

    final case class UpdateControlOp(
      request: UpdateControlRequest
    ) extends AuditManagerOp[UpdateControlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateControlResponse] =
        visitor.updateControl(request)
    }

    final case class UpdateSettingsOp(
      request: UpdateSettingsRequest
    ) extends AuditManagerOp[UpdateSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSettingsResponse] =
        visitor.updateSettings(request)
    }

    final case class ValidateAssessmentReportIntegrityOp(
      request: ValidateAssessmentReportIntegrityRequest
    ) extends AuditManagerOp[ValidateAssessmentReportIntegrityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidateAssessmentReportIntegrityResponse] =
        visitor.validateAssessmentReportIntegrity(request)
    }
  }

  import AuditManagerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AuditManagerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateAssessmentReportEvidenceFolder(
    request: AssociateAssessmentReportEvidenceFolderRequest
  ): AuditManagerIO[AssociateAssessmentReportEvidenceFolderResponse] =
    FF.liftF(AssociateAssessmentReportEvidenceFolderOp(request))

  def batchAssociateAssessmentReportEvidence(
    request: BatchAssociateAssessmentReportEvidenceRequest
  ): AuditManagerIO[BatchAssociateAssessmentReportEvidenceResponse] =
    FF.liftF(BatchAssociateAssessmentReportEvidenceOp(request))

  def batchCreateDelegationByAssessment(
    request: BatchCreateDelegationByAssessmentRequest
  ): AuditManagerIO[BatchCreateDelegationByAssessmentResponse] =
    FF.liftF(BatchCreateDelegationByAssessmentOp(request))

  def batchDeleteDelegationByAssessment(
    request: BatchDeleteDelegationByAssessmentRequest
  ): AuditManagerIO[BatchDeleteDelegationByAssessmentResponse] =
    FF.liftF(BatchDeleteDelegationByAssessmentOp(request))

  def batchDisassociateAssessmentReportEvidence(
    request: BatchDisassociateAssessmentReportEvidenceRequest
  ): AuditManagerIO[BatchDisassociateAssessmentReportEvidenceResponse] =
    FF.liftF(BatchDisassociateAssessmentReportEvidenceOp(request))

  def batchImportEvidenceToAssessmentControl(
    request: BatchImportEvidenceToAssessmentControlRequest
  ): AuditManagerIO[BatchImportEvidenceToAssessmentControlResponse] =
    FF.liftF(BatchImportEvidenceToAssessmentControlOp(request))

  def createAssessment(
    request: CreateAssessmentRequest
  ): AuditManagerIO[CreateAssessmentResponse] =
    FF.liftF(CreateAssessmentOp(request))

  def createAssessmentFramework(
    request: CreateAssessmentFrameworkRequest
  ): AuditManagerIO[CreateAssessmentFrameworkResponse] =
    FF.liftF(CreateAssessmentFrameworkOp(request))

  def createAssessmentReport(
    request: CreateAssessmentReportRequest
  ): AuditManagerIO[CreateAssessmentReportResponse] =
    FF.liftF(CreateAssessmentReportOp(request))

  def createControl(
    request: CreateControlRequest
  ): AuditManagerIO[CreateControlResponse] =
    FF.liftF(CreateControlOp(request))

  def deleteAssessment(
    request: DeleteAssessmentRequest
  ): AuditManagerIO[DeleteAssessmentResponse] =
    FF.liftF(DeleteAssessmentOp(request))

  def deleteAssessmentFramework(
    request: DeleteAssessmentFrameworkRequest
  ): AuditManagerIO[DeleteAssessmentFrameworkResponse] =
    FF.liftF(DeleteAssessmentFrameworkOp(request))

  def deleteAssessmentReport(
    request: DeleteAssessmentReportRequest
  ): AuditManagerIO[DeleteAssessmentReportResponse] =
    FF.liftF(DeleteAssessmentReportOp(request))

  def deleteControl(
    request: DeleteControlRequest
  ): AuditManagerIO[DeleteControlResponse] =
    FF.liftF(DeleteControlOp(request))

  def deregisterAccount(
    request: DeregisterAccountRequest
  ): AuditManagerIO[DeregisterAccountResponse] =
    FF.liftF(DeregisterAccountOp(request))

  def deregisterOrganizationAdminAccount(
    request: DeregisterOrganizationAdminAccountRequest
  ): AuditManagerIO[DeregisterOrganizationAdminAccountResponse] =
    FF.liftF(DeregisterOrganizationAdminAccountOp(request))

  def disassociateAssessmentReportEvidenceFolder(
    request: DisassociateAssessmentReportEvidenceFolderRequest
  ): AuditManagerIO[DisassociateAssessmentReportEvidenceFolderResponse] =
    FF.liftF(DisassociateAssessmentReportEvidenceFolderOp(request))

  def getAccountStatus(
    request: GetAccountStatusRequest
  ): AuditManagerIO[GetAccountStatusResponse] =
    FF.liftF(GetAccountStatusOp(request))

  def getAssessment(
    request: GetAssessmentRequest
  ): AuditManagerIO[GetAssessmentResponse] =
    FF.liftF(GetAssessmentOp(request))

  def getAssessmentFramework(
    request: GetAssessmentFrameworkRequest
  ): AuditManagerIO[GetAssessmentFrameworkResponse] =
    FF.liftF(GetAssessmentFrameworkOp(request))

  def getAssessmentReportUrl(
    request: GetAssessmentReportUrlRequest
  ): AuditManagerIO[GetAssessmentReportUrlResponse] =
    FF.liftF(GetAssessmentReportUrlOp(request))

  def getChangeLogs(
    request: GetChangeLogsRequest
  ): AuditManagerIO[GetChangeLogsResponse] =
    FF.liftF(GetChangeLogsOp(request))

  def getControl(
    request: GetControlRequest
  ): AuditManagerIO[GetControlResponse] =
    FF.liftF(GetControlOp(request))

  def getDelegations(
    request: GetDelegationsRequest
  ): AuditManagerIO[GetDelegationsResponse] =
    FF.liftF(GetDelegationsOp(request))

  def getEvidence(
    request: GetEvidenceRequest
  ): AuditManagerIO[GetEvidenceResponse] =
    FF.liftF(GetEvidenceOp(request))

  def getEvidenceByEvidenceFolder(
    request: GetEvidenceByEvidenceFolderRequest
  ): AuditManagerIO[GetEvidenceByEvidenceFolderResponse] =
    FF.liftF(GetEvidenceByEvidenceFolderOp(request))

  def getEvidenceFolder(
    request: GetEvidenceFolderRequest
  ): AuditManagerIO[GetEvidenceFolderResponse] =
    FF.liftF(GetEvidenceFolderOp(request))

  def getEvidenceFoldersByAssessment(
    request: GetEvidenceFoldersByAssessmentRequest
  ): AuditManagerIO[GetEvidenceFoldersByAssessmentResponse] =
    FF.liftF(GetEvidenceFoldersByAssessmentOp(request))

  def getEvidenceFoldersByAssessmentControl(
    request: GetEvidenceFoldersByAssessmentControlRequest
  ): AuditManagerIO[GetEvidenceFoldersByAssessmentControlResponse] =
    FF.liftF(GetEvidenceFoldersByAssessmentControlOp(request))

  def getOrganizationAdminAccount(
    request: GetOrganizationAdminAccountRequest
  ): AuditManagerIO[GetOrganizationAdminAccountResponse] =
    FF.liftF(GetOrganizationAdminAccountOp(request))

  def getServicesInScope(
    request: GetServicesInScopeRequest
  ): AuditManagerIO[GetServicesInScopeResponse] =
    FF.liftF(GetServicesInScopeOp(request))

  def getSettings(
    request: GetSettingsRequest
  ): AuditManagerIO[GetSettingsResponse] =
    FF.liftF(GetSettingsOp(request))

  def listAssessmentFrameworks(
    request: ListAssessmentFrameworksRequest
  ): AuditManagerIO[ListAssessmentFrameworksResponse] =
    FF.liftF(ListAssessmentFrameworksOp(request))

  def listAssessmentReports(
    request: ListAssessmentReportsRequest
  ): AuditManagerIO[ListAssessmentReportsResponse] =
    FF.liftF(ListAssessmentReportsOp(request))

  def listAssessments(
    request: ListAssessmentsRequest
  ): AuditManagerIO[ListAssessmentsResponse] =
    FF.liftF(ListAssessmentsOp(request))

  def listControls(
    request: ListControlsRequest
  ): AuditManagerIO[ListControlsResponse] =
    FF.liftF(ListControlsOp(request))

  def listKeywordsForDataSource(
    request: ListKeywordsForDataSourceRequest
  ): AuditManagerIO[ListKeywordsForDataSourceResponse] =
    FF.liftF(ListKeywordsForDataSourceOp(request))

  def listNotifications(
    request: ListNotificationsRequest
  ): AuditManagerIO[ListNotificationsResponse] =
    FF.liftF(ListNotificationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AuditManagerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def registerAccount(
    request: RegisterAccountRequest
  ): AuditManagerIO[RegisterAccountResponse] =
    FF.liftF(RegisterAccountOp(request))

  def registerOrganizationAdminAccount(
    request: RegisterOrganizationAdminAccountRequest
  ): AuditManagerIO[RegisterOrganizationAdminAccountResponse] =
    FF.liftF(RegisterOrganizationAdminAccountOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AuditManagerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AuditManagerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAssessment(
    request: UpdateAssessmentRequest
  ): AuditManagerIO[UpdateAssessmentResponse] =
    FF.liftF(UpdateAssessmentOp(request))

  def updateAssessmentControl(
    request: UpdateAssessmentControlRequest
  ): AuditManagerIO[UpdateAssessmentControlResponse] =
    FF.liftF(UpdateAssessmentControlOp(request))

  def updateAssessmentControlSetStatus(
    request: UpdateAssessmentControlSetStatusRequest
  ): AuditManagerIO[UpdateAssessmentControlSetStatusResponse] =
    FF.liftF(UpdateAssessmentControlSetStatusOp(request))

  def updateAssessmentFramework(
    request: UpdateAssessmentFrameworkRequest
  ): AuditManagerIO[UpdateAssessmentFrameworkResponse] =
    FF.liftF(UpdateAssessmentFrameworkOp(request))

  def updateAssessmentStatus(
    request: UpdateAssessmentStatusRequest
  ): AuditManagerIO[UpdateAssessmentStatusResponse] =
    FF.liftF(UpdateAssessmentStatusOp(request))

  def updateControl(
    request: UpdateControlRequest
  ): AuditManagerIO[UpdateControlResponse] =
    FF.liftF(UpdateControlOp(request))

  def updateSettings(
    request: UpdateSettingsRequest
  ): AuditManagerIO[UpdateSettingsResponse] =
    FF.liftF(UpdateSettingsOp(request))

  def validateAssessmentReportIntegrity(
    request: ValidateAssessmentReportIntegrityRequest
  ): AuditManagerIO[ValidateAssessmentReportIntegrityResponse] =
    FF.liftF(ValidateAssessmentReportIntegrityOp(request))
}
