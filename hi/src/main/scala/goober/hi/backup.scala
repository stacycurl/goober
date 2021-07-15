package goober.hi

import goober.free.backup.BackupIO
import software.amazon.awssdk.services.backup.model._


object backup {
  import goober.free.{backup ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CreateBackupPlanRequest
    // CreateBackupSelectionRequest
    // CreateBackupVaultRequest
    // DeleteBackupPlanRequest
    // DeleteBackupSelectionRequest
    // DeleteBackupVaultRequest
    // DeleteBackupVaultAccessPolicyRequest
    // DeleteBackupVaultNotificationsRequest
    // DeleteRecoveryPointRequest
    // DescribeBackupJobRequest
    // DescribeBackupVaultRequest
    // DescribeCopyJobRequest
    // DescribeGlobalSettingsRequest
    // DescribeProtectedResourceRequest
    // DescribeRecoveryPointRequest
    // DescribeRegionSettingsRequest
    // DescribeRestoreJobRequest
    // DisassociateRecoveryPointRequest
    // ExportBackupPlanTemplateRequest
    // GetBackupPlanRequest
    // GetBackupPlanFromJsonRequest
    // GetBackupPlanFromTemplateRequest
    // GetBackupSelectionRequest
    // GetBackupVaultAccessPolicyRequest
    // GetBackupVaultNotificationsRequest
    // GetRecoveryPointRestoreMetadataRequest
    // GetSupportedResourceTypesRequest
    // ListBackupJobsRequest
    // ListBackupPlanTemplatesRequest
    // ListBackupPlanVersionsRequest
    // ListBackupPlansRequest
    // ListBackupSelectionsRequest
    // ListBackupVaultsRequest
    // ListCopyJobsRequest
    // ListProtectedResourcesRequest
    // ListRecoveryPointsByBackupVaultRequest
    // ListRecoveryPointsByResourceRequest
    // ListRestoreJobsRequest
    // ListTagsRequest
    // PutBackupVaultAccessPolicyRequest
    // PutBackupVaultNotificationsRequest
    // StartBackupJobRequest
    // StartCopyJobRequest
    // StartRestoreJobRequest
    // StopBackupJobRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UpdateBackupPlanRequest
    // UpdateGlobalSettingsRequest
    // UpdateRecoveryPointLifecycleRequest
    // UpdateRegionSettingsRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
