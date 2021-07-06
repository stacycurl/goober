package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.backup.BackupClient
import software.amazon.awssdk.services.backup.model._


object backup { module =>

  // Free monad over BackupOp
  type BackupIO[A] = FF[BackupOp, A]

  sealed trait BackupOp[A] {
    def visit[F[_]](visitor: BackupOp.Visitor[F]): F[A]
  }

  object BackupOp {
    // Given a BackupClient we can embed a BackupIO program in any algebra that understands embedding.
    implicit val BackupOpEmbeddable: Embeddable[BackupOp, BackupClient] = new Embeddable[BackupOp, BackupClient] {
      def embed[A](client: BackupClient, io: BackupIO[A]): Embedded[A] = Embedded.Backup(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends BackupOp.Visitor[Kleisli[M, BackupClient, *]] {
        def createBackupPlan(
          request: CreateBackupPlanRequest
        ): Kleisli[M, BackupClient, CreateBackupPlanResponse] =
          primitive(_.createBackupPlan(request))

        def createBackupSelection(
          request: CreateBackupSelectionRequest
        ): Kleisli[M, BackupClient, CreateBackupSelectionResponse] =
          primitive(_.createBackupSelection(request))

        def createBackupVault(
          request: CreateBackupVaultRequest
        ): Kleisli[M, BackupClient, CreateBackupVaultResponse] =
          primitive(_.createBackupVault(request))

        def deleteBackupPlan(
          request: DeleteBackupPlanRequest
        ): Kleisli[M, BackupClient, DeleteBackupPlanResponse] =
          primitive(_.deleteBackupPlan(request))

        def deleteBackupSelection(
          request: DeleteBackupSelectionRequest
        ): Kleisli[M, BackupClient, DeleteBackupSelectionResponse] =
          primitive(_.deleteBackupSelection(request))

        def deleteBackupVault(
          request: DeleteBackupVaultRequest
        ): Kleisli[M, BackupClient, DeleteBackupVaultResponse] =
          primitive(_.deleteBackupVault(request))

        def deleteBackupVaultAccessPolicy(
          request: DeleteBackupVaultAccessPolicyRequest
        ): Kleisli[M, BackupClient, DeleteBackupVaultAccessPolicyResponse] =
          primitive(_.deleteBackupVaultAccessPolicy(request))

        def deleteBackupVaultNotifications(
          request: DeleteBackupVaultNotificationsRequest
        ): Kleisli[M, BackupClient, DeleteBackupVaultNotificationsResponse] =
          primitive(_.deleteBackupVaultNotifications(request))

        def deleteRecoveryPoint(
          request: DeleteRecoveryPointRequest
        ): Kleisli[M, BackupClient, DeleteRecoveryPointResponse] =
          primitive(_.deleteRecoveryPoint(request))

        def describeBackupJob(
          request: DescribeBackupJobRequest
        ): Kleisli[M, BackupClient, DescribeBackupJobResponse] =
          primitive(_.describeBackupJob(request))

        def describeBackupVault(
          request: DescribeBackupVaultRequest
        ): Kleisli[M, BackupClient, DescribeBackupVaultResponse] =
          primitive(_.describeBackupVault(request))

        def describeCopyJob(
          request: DescribeCopyJobRequest
        ): Kleisli[M, BackupClient, DescribeCopyJobResponse] =
          primitive(_.describeCopyJob(request))

        def describeGlobalSettings(
          request: DescribeGlobalSettingsRequest
        ): Kleisli[M, BackupClient, DescribeGlobalSettingsResponse] =
          primitive(_.describeGlobalSettings(request))

        def describeProtectedResource(
          request: DescribeProtectedResourceRequest
        ): Kleisli[M, BackupClient, DescribeProtectedResourceResponse] =
          primitive(_.describeProtectedResource(request))

        def describeRecoveryPoint(
          request: DescribeRecoveryPointRequest
        ): Kleisli[M, BackupClient, DescribeRecoveryPointResponse] =
          primitive(_.describeRecoveryPoint(request))

        def describeRegionSettings(
          request: DescribeRegionSettingsRequest
        ): Kleisli[M, BackupClient, DescribeRegionSettingsResponse] =
          primitive(_.describeRegionSettings(request))

        def describeRestoreJob(
          request: DescribeRestoreJobRequest
        ): Kleisli[M, BackupClient, DescribeRestoreJobResponse] =
          primitive(_.describeRestoreJob(request))

        def disassociateRecoveryPoint(
          request: DisassociateRecoveryPointRequest
        ): Kleisli[M, BackupClient, DisassociateRecoveryPointResponse] =
          primitive(_.disassociateRecoveryPoint(request))

        def exportBackupPlanTemplate(
          request: ExportBackupPlanTemplateRequest
        ): Kleisli[M, BackupClient, ExportBackupPlanTemplateResponse] =
          primitive(_.exportBackupPlanTemplate(request))

        def getBackupPlan(
          request: GetBackupPlanRequest
        ): Kleisli[M, BackupClient, GetBackupPlanResponse] =
          primitive(_.getBackupPlan(request))

        def getBackupPlanFromJSON(
          request: GetBackupPlanFromJsonRequest
        ): Kleisli[M, BackupClient, GetBackupPlanFromJsonResponse] =
          primitive(_.getBackupPlanFromJSON(request))

        def getBackupPlanFromTemplate(
          request: GetBackupPlanFromTemplateRequest
        ): Kleisli[M, BackupClient, GetBackupPlanFromTemplateResponse] =
          primitive(_.getBackupPlanFromTemplate(request))

        def getBackupSelection(
          request: GetBackupSelectionRequest
        ): Kleisli[M, BackupClient, GetBackupSelectionResponse] =
          primitive(_.getBackupSelection(request))

        def getBackupVaultAccessPolicy(
          request: GetBackupVaultAccessPolicyRequest
        ): Kleisli[M, BackupClient, GetBackupVaultAccessPolicyResponse] =
          primitive(_.getBackupVaultAccessPolicy(request))

        def getBackupVaultNotifications(
          request: GetBackupVaultNotificationsRequest
        ): Kleisli[M, BackupClient, GetBackupVaultNotificationsResponse] =
          primitive(_.getBackupVaultNotifications(request))

        def getRecoveryPointRestoreMetadata(
          request: GetRecoveryPointRestoreMetadataRequest
        ): Kleisli[M, BackupClient, GetRecoveryPointRestoreMetadataResponse] =
          primitive(_.getRecoveryPointRestoreMetadata(request))

        def getSupportedResourceTypes(
          request: GetSupportedResourceTypesRequest
        ): Kleisli[M, BackupClient, GetSupportedResourceTypesResponse] =
          primitive(_.getSupportedResourceTypes(request))

        def listBackupJobs(
          request: ListBackupJobsRequest
        ): Kleisli[M, BackupClient, ListBackupJobsResponse] =
          primitive(_.listBackupJobs(request))

        def listBackupPlanTemplates(
          request: ListBackupPlanTemplatesRequest
        ): Kleisli[M, BackupClient, ListBackupPlanTemplatesResponse] =
          primitive(_.listBackupPlanTemplates(request))

        def listBackupPlanVersions(
          request: ListBackupPlanVersionsRequest
        ): Kleisli[M, BackupClient, ListBackupPlanVersionsResponse] =
          primitive(_.listBackupPlanVersions(request))

        def listBackupPlans(
          request: ListBackupPlansRequest
        ): Kleisli[M, BackupClient, ListBackupPlansResponse] =
          primitive(_.listBackupPlans(request))

        def listBackupSelections(
          request: ListBackupSelectionsRequest
        ): Kleisli[M, BackupClient, ListBackupSelectionsResponse] =
          primitive(_.listBackupSelections(request))

        def listBackupVaults(
          request: ListBackupVaultsRequest
        ): Kleisli[M, BackupClient, ListBackupVaultsResponse] =
          primitive(_.listBackupVaults(request))

        def listCopyJobs(
          request: ListCopyJobsRequest
        ): Kleisli[M, BackupClient, ListCopyJobsResponse] =
          primitive(_.listCopyJobs(request))

        def listProtectedResources(
          request: ListProtectedResourcesRequest
        ): Kleisli[M, BackupClient, ListProtectedResourcesResponse] =
          primitive(_.listProtectedResources(request))

        def listRecoveryPointsByBackupVault(
          request: ListRecoveryPointsByBackupVaultRequest
        ): Kleisli[M, BackupClient, ListRecoveryPointsByBackupVaultResponse] =
          primitive(_.listRecoveryPointsByBackupVault(request))

        def listRecoveryPointsByResource(
          request: ListRecoveryPointsByResourceRequest
        ): Kleisli[M, BackupClient, ListRecoveryPointsByResourceResponse] =
          primitive(_.listRecoveryPointsByResource(request))

        def listRestoreJobs(
          request: ListRestoreJobsRequest
        ): Kleisli[M, BackupClient, ListRestoreJobsResponse] =
          primitive(_.listRestoreJobs(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, BackupClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def putBackupVaultAccessPolicy(
          request: PutBackupVaultAccessPolicyRequest
        ): Kleisli[M, BackupClient, PutBackupVaultAccessPolicyResponse] =
          primitive(_.putBackupVaultAccessPolicy(request))

        def putBackupVaultNotifications(
          request: PutBackupVaultNotificationsRequest
        ): Kleisli[M, BackupClient, PutBackupVaultNotificationsResponse] =
          primitive(_.putBackupVaultNotifications(request))

        def startBackupJob(
          request: StartBackupJobRequest
        ): Kleisli[M, BackupClient, StartBackupJobResponse] =
          primitive(_.startBackupJob(request))

        def startCopyJob(
          request: StartCopyJobRequest
        ): Kleisli[M, BackupClient, StartCopyJobResponse] =
          primitive(_.startCopyJob(request))

        def startRestoreJob(
          request: StartRestoreJobRequest
        ): Kleisli[M, BackupClient, StartRestoreJobResponse] =
          primitive(_.startRestoreJob(request))

        def stopBackupJob(
          request: StopBackupJobRequest
        ): Kleisli[M, BackupClient, StopBackupJobResponse] =
          primitive(_.stopBackupJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, BackupClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, BackupClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateBackupPlan(
          request: UpdateBackupPlanRequest
        ): Kleisli[M, BackupClient, UpdateBackupPlanResponse] =
          primitive(_.updateBackupPlan(request))

        def updateGlobalSettings(
          request: UpdateGlobalSettingsRequest
        ): Kleisli[M, BackupClient, UpdateGlobalSettingsResponse] =
          primitive(_.updateGlobalSettings(request))

        def updateRecoveryPointLifecycle(
          request: UpdateRecoveryPointLifecycleRequest
        ): Kleisli[M, BackupClient, UpdateRecoveryPointLifecycleResponse] =
          primitive(_.updateRecoveryPointLifecycle(request))

        def updateRegionSettings(
          request: UpdateRegionSettingsRequest
        ): Kleisli[M, BackupClient, UpdateRegionSettingsResponse] =
          primitive(_.updateRegionSettings(request))

        def primitive[A](
          f: BackupClient => A
        ): Kleisli[M, BackupClient, A]
      }
    }

    trait Visitor[F[_]] extends (BackupOp ~> F) {
      final def apply[A](op: BackupOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createBackupPlan(
        request: CreateBackupPlanRequest
      ): F[CreateBackupPlanResponse]

      def createBackupSelection(
        request: CreateBackupSelectionRequest
      ): F[CreateBackupSelectionResponse]

      def createBackupVault(
        request: CreateBackupVaultRequest
      ): F[CreateBackupVaultResponse]

      def deleteBackupPlan(
        request: DeleteBackupPlanRequest
      ): F[DeleteBackupPlanResponse]

      def deleteBackupSelection(
        request: DeleteBackupSelectionRequest
      ): F[DeleteBackupSelectionResponse]

      def deleteBackupVault(
        request: DeleteBackupVaultRequest
      ): F[DeleteBackupVaultResponse]

      def deleteBackupVaultAccessPolicy(
        request: DeleteBackupVaultAccessPolicyRequest
      ): F[DeleteBackupVaultAccessPolicyResponse]

      def deleteBackupVaultNotifications(
        request: DeleteBackupVaultNotificationsRequest
      ): F[DeleteBackupVaultNotificationsResponse]

      def deleteRecoveryPoint(
        request: DeleteRecoveryPointRequest
      ): F[DeleteRecoveryPointResponse]

      def describeBackupJob(
        request: DescribeBackupJobRequest
      ): F[DescribeBackupJobResponse]

      def describeBackupVault(
        request: DescribeBackupVaultRequest
      ): F[DescribeBackupVaultResponse]

      def describeCopyJob(
        request: DescribeCopyJobRequest
      ): F[DescribeCopyJobResponse]

      def describeGlobalSettings(
        request: DescribeGlobalSettingsRequest
      ): F[DescribeGlobalSettingsResponse]

      def describeProtectedResource(
        request: DescribeProtectedResourceRequest
      ): F[DescribeProtectedResourceResponse]

      def describeRecoveryPoint(
        request: DescribeRecoveryPointRequest
      ): F[DescribeRecoveryPointResponse]

      def describeRegionSettings(
        request: DescribeRegionSettingsRequest
      ): F[DescribeRegionSettingsResponse]

      def describeRestoreJob(
        request: DescribeRestoreJobRequest
      ): F[DescribeRestoreJobResponse]

      def disassociateRecoveryPoint(
        request: DisassociateRecoveryPointRequest
      ): F[DisassociateRecoveryPointResponse]

      def exportBackupPlanTemplate(
        request: ExportBackupPlanTemplateRequest
      ): F[ExportBackupPlanTemplateResponse]

      def getBackupPlan(
        request: GetBackupPlanRequest
      ): F[GetBackupPlanResponse]

      def getBackupPlanFromJSON(
        request: GetBackupPlanFromJsonRequest
      ): F[GetBackupPlanFromJsonResponse]

      def getBackupPlanFromTemplate(
        request: GetBackupPlanFromTemplateRequest
      ): F[GetBackupPlanFromTemplateResponse]

      def getBackupSelection(
        request: GetBackupSelectionRequest
      ): F[GetBackupSelectionResponse]

      def getBackupVaultAccessPolicy(
        request: GetBackupVaultAccessPolicyRequest
      ): F[GetBackupVaultAccessPolicyResponse]

      def getBackupVaultNotifications(
        request: GetBackupVaultNotificationsRequest
      ): F[GetBackupVaultNotificationsResponse]

      def getRecoveryPointRestoreMetadata(
        request: GetRecoveryPointRestoreMetadataRequest
      ): F[GetRecoveryPointRestoreMetadataResponse]

      def getSupportedResourceTypes(
        request: GetSupportedResourceTypesRequest
      ): F[GetSupportedResourceTypesResponse]

      def listBackupJobs(
        request: ListBackupJobsRequest
      ): F[ListBackupJobsResponse]

      def listBackupPlanTemplates(
        request: ListBackupPlanTemplatesRequest
      ): F[ListBackupPlanTemplatesResponse]

      def listBackupPlanVersions(
        request: ListBackupPlanVersionsRequest
      ): F[ListBackupPlanVersionsResponse]

      def listBackupPlans(
        request: ListBackupPlansRequest
      ): F[ListBackupPlansResponse]

      def listBackupSelections(
        request: ListBackupSelectionsRequest
      ): F[ListBackupSelectionsResponse]

      def listBackupVaults(
        request: ListBackupVaultsRequest
      ): F[ListBackupVaultsResponse]

      def listCopyJobs(
        request: ListCopyJobsRequest
      ): F[ListCopyJobsResponse]

      def listProtectedResources(
        request: ListProtectedResourcesRequest
      ): F[ListProtectedResourcesResponse]

      def listRecoveryPointsByBackupVault(
        request: ListRecoveryPointsByBackupVaultRequest
      ): F[ListRecoveryPointsByBackupVaultResponse]

      def listRecoveryPointsByResource(
        request: ListRecoveryPointsByResourceRequest
      ): F[ListRecoveryPointsByResourceResponse]

      def listRestoreJobs(
        request: ListRestoreJobsRequest
      ): F[ListRestoreJobsResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def putBackupVaultAccessPolicy(
        request: PutBackupVaultAccessPolicyRequest
      ): F[PutBackupVaultAccessPolicyResponse]

      def putBackupVaultNotifications(
        request: PutBackupVaultNotificationsRequest
      ): F[PutBackupVaultNotificationsResponse]

      def startBackupJob(
        request: StartBackupJobRequest
      ): F[StartBackupJobResponse]

      def startCopyJob(
        request: StartCopyJobRequest
      ): F[StartCopyJobResponse]

      def startRestoreJob(
        request: StartRestoreJobRequest
      ): F[StartRestoreJobResponse]

      def stopBackupJob(
        request: StopBackupJobRequest
      ): F[StopBackupJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateBackupPlan(
        request: UpdateBackupPlanRequest
      ): F[UpdateBackupPlanResponse]

      def updateGlobalSettings(
        request: UpdateGlobalSettingsRequest
      ): F[UpdateGlobalSettingsResponse]

      def updateRecoveryPointLifecycle(
        request: UpdateRecoveryPointLifecycleRequest
      ): F[UpdateRecoveryPointLifecycleResponse]

      def updateRegionSettings(
        request: UpdateRegionSettingsRequest
      ): F[UpdateRegionSettingsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends BackupOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateBackupPlanOp(
      request: CreateBackupPlanRequest
    ) extends BackupOp[CreateBackupPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackupPlanResponse] =
        visitor.createBackupPlan(request)
    }

    final case class CreateBackupSelectionOp(
      request: CreateBackupSelectionRequest
    ) extends BackupOp[CreateBackupSelectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackupSelectionResponse] =
        visitor.createBackupSelection(request)
    }

    final case class CreateBackupVaultOp(
      request: CreateBackupVaultRequest
    ) extends BackupOp[CreateBackupVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackupVaultResponse] =
        visitor.createBackupVault(request)
    }

    final case class DeleteBackupPlanOp(
      request: DeleteBackupPlanRequest
    ) extends BackupOp[DeleteBackupPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupPlanResponse] =
        visitor.deleteBackupPlan(request)
    }

    final case class DeleteBackupSelectionOp(
      request: DeleteBackupSelectionRequest
    ) extends BackupOp[DeleteBackupSelectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupSelectionResponse] =
        visitor.deleteBackupSelection(request)
    }

    final case class DeleteBackupVaultOp(
      request: DeleteBackupVaultRequest
    ) extends BackupOp[DeleteBackupVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupVaultResponse] =
        visitor.deleteBackupVault(request)
    }

    final case class DeleteBackupVaultAccessPolicyOp(
      request: DeleteBackupVaultAccessPolicyRequest
    ) extends BackupOp[DeleteBackupVaultAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupVaultAccessPolicyResponse] =
        visitor.deleteBackupVaultAccessPolicy(request)
    }

    final case class DeleteBackupVaultNotificationsOp(
      request: DeleteBackupVaultNotificationsRequest
    ) extends BackupOp[DeleteBackupVaultNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupVaultNotificationsResponse] =
        visitor.deleteBackupVaultNotifications(request)
    }

    final case class DeleteRecoveryPointOp(
      request: DeleteRecoveryPointRequest
    ) extends BackupOp[DeleteRecoveryPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRecoveryPointResponse] =
        visitor.deleteRecoveryPoint(request)
    }

    final case class DescribeBackupJobOp(
      request: DescribeBackupJobRequest
    ) extends BackupOp[DescribeBackupJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBackupJobResponse] =
        visitor.describeBackupJob(request)
    }

    final case class DescribeBackupVaultOp(
      request: DescribeBackupVaultRequest
    ) extends BackupOp[DescribeBackupVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBackupVaultResponse] =
        visitor.describeBackupVault(request)
    }

    final case class DescribeCopyJobOp(
      request: DescribeCopyJobRequest
    ) extends BackupOp[DescribeCopyJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCopyJobResponse] =
        visitor.describeCopyJob(request)
    }

    final case class DescribeGlobalSettingsOp(
      request: DescribeGlobalSettingsRequest
    ) extends BackupOp[DescribeGlobalSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGlobalSettingsResponse] =
        visitor.describeGlobalSettings(request)
    }

    final case class DescribeProtectedResourceOp(
      request: DescribeProtectedResourceRequest
    ) extends BackupOp[DescribeProtectedResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProtectedResourceResponse] =
        visitor.describeProtectedResource(request)
    }

    final case class DescribeRecoveryPointOp(
      request: DescribeRecoveryPointRequest
    ) extends BackupOp[DescribeRecoveryPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRecoveryPointResponse] =
        visitor.describeRecoveryPoint(request)
    }

    final case class DescribeRegionSettingsOp(
      request: DescribeRegionSettingsRequest
    ) extends BackupOp[DescribeRegionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRegionSettingsResponse] =
        visitor.describeRegionSettings(request)
    }

    final case class DescribeRestoreJobOp(
      request: DescribeRestoreJobRequest
    ) extends BackupOp[DescribeRestoreJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRestoreJobResponse] =
        visitor.describeRestoreJob(request)
    }

    final case class DisassociateRecoveryPointOp(
      request: DisassociateRecoveryPointRequest
    ) extends BackupOp[DisassociateRecoveryPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateRecoveryPointResponse] =
        visitor.disassociateRecoveryPoint(request)
    }

    final case class ExportBackupPlanTemplateOp(
      request: ExportBackupPlanTemplateRequest
    ) extends BackupOp[ExportBackupPlanTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportBackupPlanTemplateResponse] =
        visitor.exportBackupPlanTemplate(request)
    }

    final case class GetBackupPlanOp(
      request: GetBackupPlanRequest
    ) extends BackupOp[GetBackupPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackupPlanResponse] =
        visitor.getBackupPlan(request)
    }

    final case class GetBackupPlanFromJSONOp(
      request: GetBackupPlanFromJsonRequest
    ) extends BackupOp[GetBackupPlanFromJsonResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackupPlanFromJsonResponse] =
        visitor.getBackupPlanFromJSON(request)
    }

    final case class GetBackupPlanFromTemplateOp(
      request: GetBackupPlanFromTemplateRequest
    ) extends BackupOp[GetBackupPlanFromTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackupPlanFromTemplateResponse] =
        visitor.getBackupPlanFromTemplate(request)
    }

    final case class GetBackupSelectionOp(
      request: GetBackupSelectionRequest
    ) extends BackupOp[GetBackupSelectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackupSelectionResponse] =
        visitor.getBackupSelection(request)
    }

    final case class GetBackupVaultAccessPolicyOp(
      request: GetBackupVaultAccessPolicyRequest
    ) extends BackupOp[GetBackupVaultAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackupVaultAccessPolicyResponse] =
        visitor.getBackupVaultAccessPolicy(request)
    }

    final case class GetBackupVaultNotificationsOp(
      request: GetBackupVaultNotificationsRequest
    ) extends BackupOp[GetBackupVaultNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackupVaultNotificationsResponse] =
        visitor.getBackupVaultNotifications(request)
    }

    final case class GetRecoveryPointRestoreMetadataOp(
      request: GetRecoveryPointRestoreMetadataRequest
    ) extends BackupOp[GetRecoveryPointRestoreMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRecoveryPointRestoreMetadataResponse] =
        visitor.getRecoveryPointRestoreMetadata(request)
    }

    final case class GetSupportedResourceTypesOp(
      request: GetSupportedResourceTypesRequest
    ) extends BackupOp[GetSupportedResourceTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSupportedResourceTypesResponse] =
        visitor.getSupportedResourceTypes(request)
    }

    final case class ListBackupJobsOp(
      request: ListBackupJobsRequest
    ) extends BackupOp[ListBackupJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackupJobsResponse] =
        visitor.listBackupJobs(request)
    }

    final case class ListBackupPlanTemplatesOp(
      request: ListBackupPlanTemplatesRequest
    ) extends BackupOp[ListBackupPlanTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackupPlanTemplatesResponse] =
        visitor.listBackupPlanTemplates(request)
    }

    final case class ListBackupPlanVersionsOp(
      request: ListBackupPlanVersionsRequest
    ) extends BackupOp[ListBackupPlanVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackupPlanVersionsResponse] =
        visitor.listBackupPlanVersions(request)
    }

    final case class ListBackupPlansOp(
      request: ListBackupPlansRequest
    ) extends BackupOp[ListBackupPlansResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackupPlansResponse] =
        visitor.listBackupPlans(request)
    }

    final case class ListBackupSelectionsOp(
      request: ListBackupSelectionsRequest
    ) extends BackupOp[ListBackupSelectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackupSelectionsResponse] =
        visitor.listBackupSelections(request)
    }

    final case class ListBackupVaultsOp(
      request: ListBackupVaultsRequest
    ) extends BackupOp[ListBackupVaultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackupVaultsResponse] =
        visitor.listBackupVaults(request)
    }

    final case class ListCopyJobsOp(
      request: ListCopyJobsRequest
    ) extends BackupOp[ListCopyJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCopyJobsResponse] =
        visitor.listCopyJobs(request)
    }

    final case class ListProtectedResourcesOp(
      request: ListProtectedResourcesRequest
    ) extends BackupOp[ListProtectedResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProtectedResourcesResponse] =
        visitor.listProtectedResources(request)
    }

    final case class ListRecoveryPointsByBackupVaultOp(
      request: ListRecoveryPointsByBackupVaultRequest
    ) extends BackupOp[ListRecoveryPointsByBackupVaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecoveryPointsByBackupVaultResponse] =
        visitor.listRecoveryPointsByBackupVault(request)
    }

    final case class ListRecoveryPointsByResourceOp(
      request: ListRecoveryPointsByResourceRequest
    ) extends BackupOp[ListRecoveryPointsByResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecoveryPointsByResourceResponse] =
        visitor.listRecoveryPointsByResource(request)
    }

    final case class ListRestoreJobsOp(
      request: ListRestoreJobsRequest
    ) extends BackupOp[ListRestoreJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRestoreJobsResponse] =
        visitor.listRestoreJobs(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends BackupOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class PutBackupVaultAccessPolicyOp(
      request: PutBackupVaultAccessPolicyRequest
    ) extends BackupOp[PutBackupVaultAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBackupVaultAccessPolicyResponse] =
        visitor.putBackupVaultAccessPolicy(request)
    }

    final case class PutBackupVaultNotificationsOp(
      request: PutBackupVaultNotificationsRequest
    ) extends BackupOp[PutBackupVaultNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBackupVaultNotificationsResponse] =
        visitor.putBackupVaultNotifications(request)
    }

    final case class StartBackupJobOp(
      request: StartBackupJobRequest
    ) extends BackupOp[StartBackupJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartBackupJobResponse] =
        visitor.startBackupJob(request)
    }

    final case class StartCopyJobOp(
      request: StartCopyJobRequest
    ) extends BackupOp[StartCopyJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartCopyJobResponse] =
        visitor.startCopyJob(request)
    }

    final case class StartRestoreJobOp(
      request: StartRestoreJobRequest
    ) extends BackupOp[StartRestoreJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartRestoreJobResponse] =
        visitor.startRestoreJob(request)
    }

    final case class StopBackupJobOp(
      request: StopBackupJobRequest
    ) extends BackupOp[StopBackupJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopBackupJobResponse] =
        visitor.stopBackupJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends BackupOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends BackupOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateBackupPlanOp(
      request: UpdateBackupPlanRequest
    ) extends BackupOp[UpdateBackupPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBackupPlanResponse] =
        visitor.updateBackupPlan(request)
    }

    final case class UpdateGlobalSettingsOp(
      request: UpdateGlobalSettingsRequest
    ) extends BackupOp[UpdateGlobalSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGlobalSettingsResponse] =
        visitor.updateGlobalSettings(request)
    }

    final case class UpdateRecoveryPointLifecycleOp(
      request: UpdateRecoveryPointLifecycleRequest
    ) extends BackupOp[UpdateRecoveryPointLifecycleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRecoveryPointLifecycleResponse] =
        visitor.updateRecoveryPointLifecycle(request)
    }

    final case class UpdateRegionSettingsOp(
      request: UpdateRegionSettingsRequest
    ) extends BackupOp[UpdateRegionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegionSettingsResponse] =
        visitor.updateRegionSettings(request)
    }
  }

  import BackupOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[BackupOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createBackupPlan(
    request: CreateBackupPlanRequest
  ): BackupIO[CreateBackupPlanResponse] =
    FF.liftF(CreateBackupPlanOp(request))

  def createBackupSelection(
    request: CreateBackupSelectionRequest
  ): BackupIO[CreateBackupSelectionResponse] =
    FF.liftF(CreateBackupSelectionOp(request))

  def createBackupVault(
    request: CreateBackupVaultRequest
  ): BackupIO[CreateBackupVaultResponse] =
    FF.liftF(CreateBackupVaultOp(request))

  def deleteBackupPlan(
    request: DeleteBackupPlanRequest
  ): BackupIO[DeleteBackupPlanResponse] =
    FF.liftF(DeleteBackupPlanOp(request))

  def deleteBackupSelection(
    request: DeleteBackupSelectionRequest
  ): BackupIO[DeleteBackupSelectionResponse] =
    FF.liftF(DeleteBackupSelectionOp(request))

  def deleteBackupVault(
    request: DeleteBackupVaultRequest
  ): BackupIO[DeleteBackupVaultResponse] =
    FF.liftF(DeleteBackupVaultOp(request))

  def deleteBackupVaultAccessPolicy(
    request: DeleteBackupVaultAccessPolicyRequest
  ): BackupIO[DeleteBackupVaultAccessPolicyResponse] =
    FF.liftF(DeleteBackupVaultAccessPolicyOp(request))

  def deleteBackupVaultNotifications(
    request: DeleteBackupVaultNotificationsRequest
  ): BackupIO[DeleteBackupVaultNotificationsResponse] =
    FF.liftF(DeleteBackupVaultNotificationsOp(request))

  def deleteRecoveryPoint(
    request: DeleteRecoveryPointRequest
  ): BackupIO[DeleteRecoveryPointResponse] =
    FF.liftF(DeleteRecoveryPointOp(request))

  def describeBackupJob(
    request: DescribeBackupJobRequest
  ): BackupIO[DescribeBackupJobResponse] =
    FF.liftF(DescribeBackupJobOp(request))

  def describeBackupVault(
    request: DescribeBackupVaultRequest
  ): BackupIO[DescribeBackupVaultResponse] =
    FF.liftF(DescribeBackupVaultOp(request))

  def describeCopyJob(
    request: DescribeCopyJobRequest
  ): BackupIO[DescribeCopyJobResponse] =
    FF.liftF(DescribeCopyJobOp(request))

  def describeGlobalSettings(
    request: DescribeGlobalSettingsRequest
  ): BackupIO[DescribeGlobalSettingsResponse] =
    FF.liftF(DescribeGlobalSettingsOp(request))

  def describeProtectedResource(
    request: DescribeProtectedResourceRequest
  ): BackupIO[DescribeProtectedResourceResponse] =
    FF.liftF(DescribeProtectedResourceOp(request))

  def describeRecoveryPoint(
    request: DescribeRecoveryPointRequest
  ): BackupIO[DescribeRecoveryPointResponse] =
    FF.liftF(DescribeRecoveryPointOp(request))

  def describeRegionSettings(
    request: DescribeRegionSettingsRequest
  ): BackupIO[DescribeRegionSettingsResponse] =
    FF.liftF(DescribeRegionSettingsOp(request))

  def describeRestoreJob(
    request: DescribeRestoreJobRequest
  ): BackupIO[DescribeRestoreJobResponse] =
    FF.liftF(DescribeRestoreJobOp(request))

  def disassociateRecoveryPoint(
    request: DisassociateRecoveryPointRequest
  ): BackupIO[DisassociateRecoveryPointResponse] =
    FF.liftF(DisassociateRecoveryPointOp(request))

  def exportBackupPlanTemplate(
    request: ExportBackupPlanTemplateRequest
  ): BackupIO[ExportBackupPlanTemplateResponse] =
    FF.liftF(ExportBackupPlanTemplateOp(request))

  def getBackupPlan(
    request: GetBackupPlanRequest
  ): BackupIO[GetBackupPlanResponse] =
    FF.liftF(GetBackupPlanOp(request))

  def getBackupPlanFromJSON(
    request: GetBackupPlanFromJsonRequest
  ): BackupIO[GetBackupPlanFromJsonResponse] =
    FF.liftF(GetBackupPlanFromJSONOp(request))

  def getBackupPlanFromTemplate(
    request: GetBackupPlanFromTemplateRequest
  ): BackupIO[GetBackupPlanFromTemplateResponse] =
    FF.liftF(GetBackupPlanFromTemplateOp(request))

  def getBackupSelection(
    request: GetBackupSelectionRequest
  ): BackupIO[GetBackupSelectionResponse] =
    FF.liftF(GetBackupSelectionOp(request))

  def getBackupVaultAccessPolicy(
    request: GetBackupVaultAccessPolicyRequest
  ): BackupIO[GetBackupVaultAccessPolicyResponse] =
    FF.liftF(GetBackupVaultAccessPolicyOp(request))

  def getBackupVaultNotifications(
    request: GetBackupVaultNotificationsRequest
  ): BackupIO[GetBackupVaultNotificationsResponse] =
    FF.liftF(GetBackupVaultNotificationsOp(request))

  def getRecoveryPointRestoreMetadata(
    request: GetRecoveryPointRestoreMetadataRequest
  ): BackupIO[GetRecoveryPointRestoreMetadataResponse] =
    FF.liftF(GetRecoveryPointRestoreMetadataOp(request))

  def getSupportedResourceTypes(
    request: GetSupportedResourceTypesRequest
  ): BackupIO[GetSupportedResourceTypesResponse] =
    FF.liftF(GetSupportedResourceTypesOp(request))

  def listBackupJobs(
    request: ListBackupJobsRequest
  ): BackupIO[ListBackupJobsResponse] =
    FF.liftF(ListBackupJobsOp(request))

  def listBackupPlanTemplates(
    request: ListBackupPlanTemplatesRequest
  ): BackupIO[ListBackupPlanTemplatesResponse] =
    FF.liftF(ListBackupPlanTemplatesOp(request))

  def listBackupPlanVersions(
    request: ListBackupPlanVersionsRequest
  ): BackupIO[ListBackupPlanVersionsResponse] =
    FF.liftF(ListBackupPlanVersionsOp(request))

  def listBackupPlans(
    request: ListBackupPlansRequest
  ): BackupIO[ListBackupPlansResponse] =
    FF.liftF(ListBackupPlansOp(request))

  def listBackupSelections(
    request: ListBackupSelectionsRequest
  ): BackupIO[ListBackupSelectionsResponse] =
    FF.liftF(ListBackupSelectionsOp(request))

  def listBackupVaults(
    request: ListBackupVaultsRequest
  ): BackupIO[ListBackupVaultsResponse] =
    FF.liftF(ListBackupVaultsOp(request))

  def listCopyJobs(
    request: ListCopyJobsRequest
  ): BackupIO[ListCopyJobsResponse] =
    FF.liftF(ListCopyJobsOp(request))

  def listProtectedResources(
    request: ListProtectedResourcesRequest
  ): BackupIO[ListProtectedResourcesResponse] =
    FF.liftF(ListProtectedResourcesOp(request))

  def listRecoveryPointsByBackupVault(
    request: ListRecoveryPointsByBackupVaultRequest
  ): BackupIO[ListRecoveryPointsByBackupVaultResponse] =
    FF.liftF(ListRecoveryPointsByBackupVaultOp(request))

  def listRecoveryPointsByResource(
    request: ListRecoveryPointsByResourceRequest
  ): BackupIO[ListRecoveryPointsByResourceResponse] =
    FF.liftF(ListRecoveryPointsByResourceOp(request))

  def listRestoreJobs(
    request: ListRestoreJobsRequest
  ): BackupIO[ListRestoreJobsResponse] =
    FF.liftF(ListRestoreJobsOp(request))

  def listTags(
    request: ListTagsRequest
  ): BackupIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def putBackupVaultAccessPolicy(
    request: PutBackupVaultAccessPolicyRequest
  ): BackupIO[PutBackupVaultAccessPolicyResponse] =
    FF.liftF(PutBackupVaultAccessPolicyOp(request))

  def putBackupVaultNotifications(
    request: PutBackupVaultNotificationsRequest
  ): BackupIO[PutBackupVaultNotificationsResponse] =
    FF.liftF(PutBackupVaultNotificationsOp(request))

  def startBackupJob(
    request: StartBackupJobRequest
  ): BackupIO[StartBackupJobResponse] =
    FF.liftF(StartBackupJobOp(request))

  def startCopyJob(
    request: StartCopyJobRequest
  ): BackupIO[StartCopyJobResponse] =
    FF.liftF(StartCopyJobOp(request))

  def startRestoreJob(
    request: StartRestoreJobRequest
  ): BackupIO[StartRestoreJobResponse] =
    FF.liftF(StartRestoreJobOp(request))

  def stopBackupJob(
    request: StopBackupJobRequest
  ): BackupIO[StopBackupJobResponse] =
    FF.liftF(StopBackupJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): BackupIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): BackupIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateBackupPlan(
    request: UpdateBackupPlanRequest
  ): BackupIO[UpdateBackupPlanResponse] =
    FF.liftF(UpdateBackupPlanOp(request))

  def updateGlobalSettings(
    request: UpdateGlobalSettingsRequest
  ): BackupIO[UpdateGlobalSettingsResponse] =
    FF.liftF(UpdateGlobalSettingsOp(request))

  def updateRecoveryPointLifecycle(
    request: UpdateRecoveryPointLifecycleRequest
  ): BackupIO[UpdateRecoveryPointLifecycleResponse] =
    FF.liftF(UpdateRecoveryPointLifecycleOp(request))

  def updateRegionSettings(
    request: UpdateRegionSettingsRequest
  ): BackupIO[UpdateRegionSettingsResponse] =
    FF.liftF(UpdateRegionSettingsOp(request))
}
