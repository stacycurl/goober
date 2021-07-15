package goober.hi

import goober.free.ssm.SsmIO
import software.amazon.awssdk.services.ssm.model._


object ssm {
  import goober.free.{ssm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AddTagsToResourceRequest
    // AssociateOpsItemRelatedItemRequest
    // CancelCommandRequest
    // CancelMaintenanceWindowExecutionRequest
    // CreateActivationRequest
    // CreateAssociationRequest
    // CreateAssociationBatchRequest
    // CreateDocumentRequest
    // CreateMaintenanceWindowRequest
    // CreateOpsItemRequest
    // CreateOpsMetadataRequest
    // CreatePatchBaselineRequest
    // CreateResourceDataSyncRequest
    // DeleteActivationRequest
    // DeleteAssociationRequest
    // DeleteDocumentRequest
    // DeleteInventoryRequest
    // DeleteMaintenanceWindowRequest
    // DeleteOpsMetadataRequest
    // DeleteParameterRequest
    // DeleteParametersRequest
    // DeletePatchBaselineRequest
    // DeleteResourceDataSyncRequest
    // DeregisterManagedInstanceRequest
    // DeregisterPatchBaselineForPatchGroupRequest
    // DeregisterTargetFromMaintenanceWindowRequest
    // DeregisterTaskFromMaintenanceWindowRequest
    // DescribeActivationsRequest
    // DescribeAssociationRequest
    // DescribeAssociationExecutionTargetsRequest
    // DescribeAssociationExecutionsRequest
    // DescribeAutomationExecutionsRequest
    // DescribeAutomationStepExecutionsRequest
    // DescribeAvailablePatchesRequest
    // DescribeDocumentRequest
    // DescribeDocumentPermissionRequest
    // DescribeEffectiveInstanceAssociationsRequest
    // DescribeEffectivePatchesForPatchBaselineRequest
    // DescribeInstanceAssociationsStatusRequest
    // DescribeInstanceInformationRequest
    // DescribeInstancePatchStatesRequest
    // DescribeInstancePatchStatesForPatchGroupRequest
    // DescribeInstancePatchesRequest
    // DescribeInventoryDeletionsRequest
    // DescribeMaintenanceWindowExecutionTaskInvocationsRequest
    // DescribeMaintenanceWindowExecutionTasksRequest
    // DescribeMaintenanceWindowExecutionsRequest
    // DescribeMaintenanceWindowScheduleRequest
    // DescribeMaintenanceWindowTargetsRequest
    // DescribeMaintenanceWindowTasksRequest
    // DescribeMaintenanceWindowsRequest
    // DescribeMaintenanceWindowsForTargetRequest
    // DescribeOpsItemsRequest
    // DescribeParametersRequest
    // DescribePatchBaselinesRequest
    // DescribePatchGroupStateRequest
    // DescribePatchGroupsRequest
    // DescribePatchPropertiesRequest
    // DescribeSessionsRequest
    // DisassociateOpsItemRelatedItemRequest
    // GetAutomationExecutionRequest
    // GetCalendarStateRequest
    // GetCommandInvocationRequest
    // GetConnectionStatusRequest
    // GetDefaultPatchBaselineRequest
    // GetDeployablePatchSnapshotForInstanceRequest
    // GetDocumentRequest
    // GetInventoryRequest
    // GetInventorySchemaRequest
    // GetMaintenanceWindowRequest
    // GetMaintenanceWindowExecutionRequest
    // GetMaintenanceWindowExecutionTaskRequest
    // GetMaintenanceWindowExecutionTaskInvocationRequest
    // GetMaintenanceWindowTaskRequest
    // GetOpsItemRequest
    // GetOpsMetadataRequest
    // GetOpsSummaryRequest
    // GetParameterRequest
    // GetParameterHistoryRequest
    // GetParametersRequest
    // GetParametersByPathRequest
    // GetPatchBaselineRequest
    // GetPatchBaselineForPatchGroupRequest
    // GetServiceSettingRequest
    // LabelParameterVersionRequest
    // ListAssociationVersionsRequest
    // ListAssociationsRequest
    // ListCommandInvocationsRequest
    // ListCommandsRequest
    // ListComplianceItemsRequest
    // ListComplianceSummariesRequest
    // ListDocumentMetadataHistoryRequest
    // ListDocumentVersionsRequest
    // ListDocumentsRequest
    // ListInventoryEntriesRequest
    // ListOpsItemEventsRequest
    // ListOpsItemRelatedItemsRequest
    // ListOpsMetadataRequest
    // ListResourceComplianceSummariesRequest
    // ListResourceDataSyncRequest
    // ListTagsForResourceRequest
    // ModifyDocumentPermissionRequest
    // PutComplianceItemsRequest
    // PutInventoryRequest
    // PutParameterRequest
    // RegisterDefaultPatchBaselineRequest
    // RegisterPatchBaselineForPatchGroupRequest
    // RegisterTargetWithMaintenanceWindowRequest
    // RegisterTaskWithMaintenanceWindowRequest
    // RemoveTagsFromResourceRequest
    // ResetServiceSettingRequest
    // ResumeSessionRequest
    // SendAutomationSignalRequest
    // SendCommandRequest
    // StartAssociationsOnceRequest
    // StartAutomationExecutionRequest
    // StartChangeRequestExecutionRequest
    // StartSessionRequest
    // StopAutomationExecutionRequest
    // TerminateSessionRequest
    // UnlabelParameterVersionRequest
    // UpdateAssociationRequest
    // UpdateAssociationStatusRequest
    // UpdateDocumentRequest
    // UpdateDocumentDefaultVersionRequest
    // UpdateDocumentMetadataRequest
    // UpdateMaintenanceWindowRequest
    // UpdateMaintenanceWindowTargetRequest
    // UpdateMaintenanceWindowTaskRequest
    // UpdateManagedInstanceRoleRequest
    // UpdateOpsItemRequest
    // UpdateOpsMetadataRequest
    // UpdatePatchBaselineRequest
    // UpdateResourceDataSyncRequest
    // UpdateServiceSettingRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
