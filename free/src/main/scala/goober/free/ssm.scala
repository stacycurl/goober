package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ssm.SsmClient
import software.amazon.awssdk.services.ssm.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ssm { module =>

  // Free monad over SsmOp
  type SsmIO[A] = FF[SsmOp, A]

  sealed trait SsmOp[A] {
    def visit[F[_]](visitor: SsmOp.Visitor[F]): F[A]
  }

  object SsmOp {
    // Given a SsmClient we can embed a SsmIO program in any algebra that understands embedding.
    implicit val SsmOpEmbeddable: Embeddable[SsmOp, SsmClient] = new Embeddable[SsmOp, SsmClient] {
      def embed[A](client: SsmClient, io: SsmIO[A]): Embedded[A] = Embedded.Ssm(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SsmOp.Visitor[Kleisli[M, SsmClient, *]] {
        def addTagsToResource(
          request: AddTagsToResourceRequest
        ): Kleisli[M, SsmClient, AddTagsToResourceResponse] =
          primitive(_.addTagsToResource(request))

        def associateOpsItemRelatedItem(
          request: AssociateOpsItemRelatedItemRequest
        ): Kleisli[M, SsmClient, AssociateOpsItemRelatedItemResponse] =
          primitive(_.associateOpsItemRelatedItem(request))

        def cancelCommand(
          request: CancelCommandRequest
        ): Kleisli[M, SsmClient, CancelCommandResponse] =
          primitive(_.cancelCommand(request))

        def cancelMaintenanceWindowExecution(
          request: CancelMaintenanceWindowExecutionRequest
        ): Kleisli[M, SsmClient, CancelMaintenanceWindowExecutionResponse] =
          primitive(_.cancelMaintenanceWindowExecution(request))

        def createActivation(
          request: CreateActivationRequest
        ): Kleisli[M, SsmClient, CreateActivationResponse] =
          primitive(_.createActivation(request))

        def createAssociation(
          request: CreateAssociationRequest
        ): Kleisli[M, SsmClient, CreateAssociationResponse] =
          primitive(_.createAssociation(request))

        def createAssociationBatch(
          request: CreateAssociationBatchRequest
        ): Kleisli[M, SsmClient, CreateAssociationBatchResponse] =
          primitive(_.createAssociationBatch(request))

        def createDocument(
          request: CreateDocumentRequest
        ): Kleisli[M, SsmClient, CreateDocumentResponse] =
          primitive(_.createDocument(request))

        def createMaintenanceWindow(
          request: CreateMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, CreateMaintenanceWindowResponse] =
          primitive(_.createMaintenanceWindow(request))

        def createOpsItem(
          request: CreateOpsItemRequest
        ): Kleisli[M, SsmClient, CreateOpsItemResponse] =
          primitive(_.createOpsItem(request))

        def createOpsMetadata(
          request: CreateOpsMetadataRequest
        ): Kleisli[M, SsmClient, CreateOpsMetadataResponse] =
          primitive(_.createOpsMetadata(request))

        def createPatchBaseline(
          request: CreatePatchBaselineRequest
        ): Kleisli[M, SsmClient, CreatePatchBaselineResponse] =
          primitive(_.createPatchBaseline(request))

        def createResourceDataSync(
          request: CreateResourceDataSyncRequest
        ): Kleisli[M, SsmClient, CreateResourceDataSyncResponse] =
          primitive(_.createResourceDataSync(request))

        def deleteActivation(
          request: DeleteActivationRequest
        ): Kleisli[M, SsmClient, DeleteActivationResponse] =
          primitive(_.deleteActivation(request))

        def deleteAssociation(
          request: DeleteAssociationRequest
        ): Kleisli[M, SsmClient, DeleteAssociationResponse] =
          primitive(_.deleteAssociation(request))

        def deleteDocument(
          request: DeleteDocumentRequest
        ): Kleisli[M, SsmClient, DeleteDocumentResponse] =
          primitive(_.deleteDocument(request))

        def deleteInventory(
          request: DeleteInventoryRequest
        ): Kleisli[M, SsmClient, DeleteInventoryResponse] =
          primitive(_.deleteInventory(request))

        def deleteMaintenanceWindow(
          request: DeleteMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, DeleteMaintenanceWindowResponse] =
          primitive(_.deleteMaintenanceWindow(request))

        def deleteOpsMetadata(
          request: DeleteOpsMetadataRequest
        ): Kleisli[M, SsmClient, DeleteOpsMetadataResponse] =
          primitive(_.deleteOpsMetadata(request))

        def deleteParameter(
          request: DeleteParameterRequest
        ): Kleisli[M, SsmClient, DeleteParameterResponse] =
          primitive(_.deleteParameter(request))

        def deleteParameters(
          request: DeleteParametersRequest
        ): Kleisli[M, SsmClient, DeleteParametersResponse] =
          primitive(_.deleteParameters(request))

        def deletePatchBaseline(
          request: DeletePatchBaselineRequest
        ): Kleisli[M, SsmClient, DeletePatchBaselineResponse] =
          primitive(_.deletePatchBaseline(request))

        def deleteResourceDataSync(
          request: DeleteResourceDataSyncRequest
        ): Kleisli[M, SsmClient, DeleteResourceDataSyncResponse] =
          primitive(_.deleteResourceDataSync(request))

        def deregisterManagedInstance(
          request: DeregisterManagedInstanceRequest
        ): Kleisli[M, SsmClient, DeregisterManagedInstanceResponse] =
          primitive(_.deregisterManagedInstance(request))

        def deregisterPatchBaselineForPatchGroup(
          request: DeregisterPatchBaselineForPatchGroupRequest
        ): Kleisli[M, SsmClient, DeregisterPatchBaselineForPatchGroupResponse] =
          primitive(_.deregisterPatchBaselineForPatchGroup(request))

        def deregisterTargetFromMaintenanceWindow(
          request: DeregisterTargetFromMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, DeregisterTargetFromMaintenanceWindowResponse] =
          primitive(_.deregisterTargetFromMaintenanceWindow(request))

        def deregisterTaskFromMaintenanceWindow(
          request: DeregisterTaskFromMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, DeregisterTaskFromMaintenanceWindowResponse] =
          primitive(_.deregisterTaskFromMaintenanceWindow(request))

        def describeActivations(
          request: DescribeActivationsRequest
        ): Kleisli[M, SsmClient, DescribeActivationsResponse] =
          primitive(_.describeActivations(request))

        def describeAssociation(
          request: DescribeAssociationRequest
        ): Kleisli[M, SsmClient, DescribeAssociationResponse] =
          primitive(_.describeAssociation(request))

        def describeAssociationExecutionTargets(
          request: DescribeAssociationExecutionTargetsRequest
        ): Kleisli[M, SsmClient, DescribeAssociationExecutionTargetsResponse] =
          primitive(_.describeAssociationExecutionTargets(request))

        def describeAssociationExecutions(
          request: DescribeAssociationExecutionsRequest
        ): Kleisli[M, SsmClient, DescribeAssociationExecutionsResponse] =
          primitive(_.describeAssociationExecutions(request))

        def describeAutomationExecutions(
          request: DescribeAutomationExecutionsRequest
        ): Kleisli[M, SsmClient, DescribeAutomationExecutionsResponse] =
          primitive(_.describeAutomationExecutions(request))

        def describeAutomationStepExecutions(
          request: DescribeAutomationStepExecutionsRequest
        ): Kleisli[M, SsmClient, DescribeAutomationStepExecutionsResponse] =
          primitive(_.describeAutomationStepExecutions(request))

        def describeAvailablePatches(
          request: DescribeAvailablePatchesRequest
        ): Kleisli[M, SsmClient, DescribeAvailablePatchesResponse] =
          primitive(_.describeAvailablePatches(request))

        def describeDocument(
          request: DescribeDocumentRequest
        ): Kleisli[M, SsmClient, DescribeDocumentResponse] =
          primitive(_.describeDocument(request))

        def describeDocumentPermission(
          request: DescribeDocumentPermissionRequest
        ): Kleisli[M, SsmClient, DescribeDocumentPermissionResponse] =
          primitive(_.describeDocumentPermission(request))

        def describeEffectiveInstanceAssociations(
          request: DescribeEffectiveInstanceAssociationsRequest
        ): Kleisli[M, SsmClient, DescribeEffectiveInstanceAssociationsResponse] =
          primitive(_.describeEffectiveInstanceAssociations(request))

        def describeEffectivePatchesForPatchBaseline(
          request: DescribeEffectivePatchesForPatchBaselineRequest
        ): Kleisli[M, SsmClient, DescribeEffectivePatchesForPatchBaselineResponse] =
          primitive(_.describeEffectivePatchesForPatchBaseline(request))

        def describeInstanceAssociationsStatus(
          request: DescribeInstanceAssociationsStatusRequest
        ): Kleisli[M, SsmClient, DescribeInstanceAssociationsStatusResponse] =
          primitive(_.describeInstanceAssociationsStatus(request))

        def describeInstanceInformation(
          request: DescribeInstanceInformationRequest
        ): Kleisli[M, SsmClient, DescribeInstanceInformationResponse] =
          primitive(_.describeInstanceInformation(request))

        def describeInstancePatchStates(
          request: DescribeInstancePatchStatesRequest
        ): Kleisli[M, SsmClient, DescribeInstancePatchStatesResponse] =
          primitive(_.describeInstancePatchStates(request))

        def describeInstancePatchStatesForPatchGroup(
          request: DescribeInstancePatchStatesForPatchGroupRequest
        ): Kleisli[M, SsmClient, DescribeInstancePatchStatesForPatchGroupResponse] =
          primitive(_.describeInstancePatchStatesForPatchGroup(request))

        def describeInstancePatches(
          request: DescribeInstancePatchesRequest
        ): Kleisli[M, SsmClient, DescribeInstancePatchesResponse] =
          primitive(_.describeInstancePatches(request))

        def describeInventoryDeletions(
          request: DescribeInventoryDeletionsRequest
        ): Kleisli[M, SsmClient, DescribeInventoryDeletionsResponse] =
          primitive(_.describeInventoryDeletions(request))

        def describeMaintenanceWindowExecutionTaskInvocations(
          request: DescribeMaintenanceWindowExecutionTaskInvocationsRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowExecutionTaskInvocationsResponse] =
          primitive(_.describeMaintenanceWindowExecutionTaskInvocations(request))

        def describeMaintenanceWindowExecutionTasks(
          request: DescribeMaintenanceWindowExecutionTasksRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowExecutionTasksResponse] =
          primitive(_.describeMaintenanceWindowExecutionTasks(request))

        def describeMaintenanceWindowExecutions(
          request: DescribeMaintenanceWindowExecutionsRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowExecutionsResponse] =
          primitive(_.describeMaintenanceWindowExecutions(request))

        def describeMaintenanceWindowSchedule(
          request: DescribeMaintenanceWindowScheduleRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowScheduleResponse] =
          primitive(_.describeMaintenanceWindowSchedule(request))

        def describeMaintenanceWindowTargets(
          request: DescribeMaintenanceWindowTargetsRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowTargetsResponse] =
          primitive(_.describeMaintenanceWindowTargets(request))

        def describeMaintenanceWindowTasks(
          request: DescribeMaintenanceWindowTasksRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowTasksResponse] =
          primitive(_.describeMaintenanceWindowTasks(request))

        def describeMaintenanceWindows(
          request: DescribeMaintenanceWindowsRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowsResponse] =
          primitive(_.describeMaintenanceWindows(request))

        def describeMaintenanceWindowsForTarget(
          request: DescribeMaintenanceWindowsForTargetRequest
        ): Kleisli[M, SsmClient, DescribeMaintenanceWindowsForTargetResponse] =
          primitive(_.describeMaintenanceWindowsForTarget(request))

        def describeOpsItems(
          request: DescribeOpsItemsRequest
        ): Kleisli[M, SsmClient, DescribeOpsItemsResponse] =
          primitive(_.describeOpsItems(request))

        def describeParameters(
          request: DescribeParametersRequest
        ): Kleisli[M, SsmClient, DescribeParametersResponse] =
          primitive(_.describeParameters(request))

        def describePatchBaselines(
          request: DescribePatchBaselinesRequest
        ): Kleisli[M, SsmClient, DescribePatchBaselinesResponse] =
          primitive(_.describePatchBaselines(request))

        def describePatchGroupState(
          request: DescribePatchGroupStateRequest
        ): Kleisli[M, SsmClient, DescribePatchGroupStateResponse] =
          primitive(_.describePatchGroupState(request))

        def describePatchGroups(
          request: DescribePatchGroupsRequest
        ): Kleisli[M, SsmClient, DescribePatchGroupsResponse] =
          primitive(_.describePatchGroups(request))

        def describePatchProperties(
          request: DescribePatchPropertiesRequest
        ): Kleisli[M, SsmClient, DescribePatchPropertiesResponse] =
          primitive(_.describePatchProperties(request))

        def describeSessions(
          request: DescribeSessionsRequest
        ): Kleisli[M, SsmClient, DescribeSessionsResponse] =
          primitive(_.describeSessions(request))

        def disassociateOpsItemRelatedItem(
          request: DisassociateOpsItemRelatedItemRequest
        ): Kleisli[M, SsmClient, DisassociateOpsItemRelatedItemResponse] =
          primitive(_.disassociateOpsItemRelatedItem(request))

        def getAutomationExecution(
          request: GetAutomationExecutionRequest
        ): Kleisli[M, SsmClient, GetAutomationExecutionResponse] =
          primitive(_.getAutomationExecution(request))

        def getCalendarState(
          request: GetCalendarStateRequest
        ): Kleisli[M, SsmClient, GetCalendarStateResponse] =
          primitive(_.getCalendarState(request))

        def getCommandInvocation(
          request: GetCommandInvocationRequest
        ): Kleisli[M, SsmClient, GetCommandInvocationResponse] =
          primitive(_.getCommandInvocation(request))

        def getConnectionStatus(
          request: GetConnectionStatusRequest
        ): Kleisli[M, SsmClient, GetConnectionStatusResponse] =
          primitive(_.getConnectionStatus(request))

        def getDefaultPatchBaseline(
          request: GetDefaultPatchBaselineRequest
        ): Kleisli[M, SsmClient, GetDefaultPatchBaselineResponse] =
          primitive(_.getDefaultPatchBaseline(request))

        def getDeployablePatchSnapshotForInstance(
          request: GetDeployablePatchSnapshotForInstanceRequest
        ): Kleisli[M, SsmClient, GetDeployablePatchSnapshotForInstanceResponse] =
          primitive(_.getDeployablePatchSnapshotForInstance(request))

        def getDocument(
          request: GetDocumentRequest
        ): Kleisli[M, SsmClient, GetDocumentResponse] =
          primitive(_.getDocument(request))

        def getInventory(
          request: GetInventoryRequest
        ): Kleisli[M, SsmClient, GetInventoryResponse] =
          primitive(_.getInventory(request))

        def getInventorySchema(
          request: GetInventorySchemaRequest
        ): Kleisli[M, SsmClient, GetInventorySchemaResponse] =
          primitive(_.getInventorySchema(request))

        def getMaintenanceWindow(
          request: GetMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, GetMaintenanceWindowResponse] =
          primitive(_.getMaintenanceWindow(request))

        def getMaintenanceWindowExecution(
          request: GetMaintenanceWindowExecutionRequest
        ): Kleisli[M, SsmClient, GetMaintenanceWindowExecutionResponse] =
          primitive(_.getMaintenanceWindowExecution(request))

        def getMaintenanceWindowExecutionTask(
          request: GetMaintenanceWindowExecutionTaskRequest
        ): Kleisli[M, SsmClient, GetMaintenanceWindowExecutionTaskResponse] =
          primitive(_.getMaintenanceWindowExecutionTask(request))

        def getMaintenanceWindowExecutionTaskInvocation(
          request: GetMaintenanceWindowExecutionTaskInvocationRequest
        ): Kleisli[M, SsmClient, GetMaintenanceWindowExecutionTaskInvocationResponse] =
          primitive(_.getMaintenanceWindowExecutionTaskInvocation(request))

        def getMaintenanceWindowTask(
          request: GetMaintenanceWindowTaskRequest
        ): Kleisli[M, SsmClient, GetMaintenanceWindowTaskResponse] =
          primitive(_.getMaintenanceWindowTask(request))

        def getOpsItem(
          request: GetOpsItemRequest
        ): Kleisli[M, SsmClient, GetOpsItemResponse] =
          primitive(_.getOpsItem(request))

        def getOpsMetadata(
          request: GetOpsMetadataRequest
        ): Kleisli[M, SsmClient, GetOpsMetadataResponse] =
          primitive(_.getOpsMetadata(request))

        def getOpsSummary(
          request: GetOpsSummaryRequest
        ): Kleisli[M, SsmClient, GetOpsSummaryResponse] =
          primitive(_.getOpsSummary(request))

        def getParameter(
          request: GetParameterRequest
        ): Kleisli[M, SsmClient, GetParameterResponse] =
          primitive(_.getParameter(request))

        def getParameterHistory(
          request: GetParameterHistoryRequest
        ): Kleisli[M, SsmClient, GetParameterHistoryResponse] =
          primitive(_.getParameterHistory(request))

        def getParameters(
          request: GetParametersRequest
        ): Kleisli[M, SsmClient, GetParametersResponse] =
          primitive(_.getParameters(request))

        def getParametersByPath(
          request: GetParametersByPathRequest
        ): Kleisli[M, SsmClient, GetParametersByPathResponse] =
          primitive(_.getParametersByPath(request))

        def getPatchBaseline(
          request: GetPatchBaselineRequest
        ): Kleisli[M, SsmClient, GetPatchBaselineResponse] =
          primitive(_.getPatchBaseline(request))

        def getPatchBaselineForPatchGroup(
          request: GetPatchBaselineForPatchGroupRequest
        ): Kleisli[M, SsmClient, GetPatchBaselineForPatchGroupResponse] =
          primitive(_.getPatchBaselineForPatchGroup(request))

        def getServiceSetting(
          request: GetServiceSettingRequest
        ): Kleisli[M, SsmClient, GetServiceSettingResponse] =
          primitive(_.getServiceSetting(request))

        def labelParameterVersion(
          request: LabelParameterVersionRequest
        ): Kleisli[M, SsmClient, LabelParameterVersionResponse] =
          primitive(_.labelParameterVersion(request))

        def listAssociationVersions(
          request: ListAssociationVersionsRequest
        ): Kleisli[M, SsmClient, ListAssociationVersionsResponse] =
          primitive(_.listAssociationVersions(request))

        def listAssociations(
          request: ListAssociationsRequest
        ): Kleisli[M, SsmClient, ListAssociationsResponse] =
          primitive(_.listAssociations(request))

        def listCommandInvocations(
          request: ListCommandInvocationsRequest
        ): Kleisli[M, SsmClient, ListCommandInvocationsResponse] =
          primitive(_.listCommandInvocations(request))

        def listCommands(
          request: ListCommandsRequest
        ): Kleisli[M, SsmClient, ListCommandsResponse] =
          primitive(_.listCommands(request))

        def listComplianceItems(
          request: ListComplianceItemsRequest
        ): Kleisli[M, SsmClient, ListComplianceItemsResponse] =
          primitive(_.listComplianceItems(request))

        def listComplianceSummaries(
          request: ListComplianceSummariesRequest
        ): Kleisli[M, SsmClient, ListComplianceSummariesResponse] =
          primitive(_.listComplianceSummaries(request))

        def listDocumentMetadataHistory(
          request: ListDocumentMetadataHistoryRequest
        ): Kleisli[M, SsmClient, ListDocumentMetadataHistoryResponse] =
          primitive(_.listDocumentMetadataHistory(request))

        def listDocumentVersions(
          request: ListDocumentVersionsRequest
        ): Kleisli[M, SsmClient, ListDocumentVersionsResponse] =
          primitive(_.listDocumentVersions(request))

        def listDocuments(
          request: ListDocumentsRequest
        ): Kleisli[M, SsmClient, ListDocumentsResponse] =
          primitive(_.listDocuments(request))

        def listInventoryEntries(
          request: ListInventoryEntriesRequest
        ): Kleisli[M, SsmClient, ListInventoryEntriesResponse] =
          primitive(_.listInventoryEntries(request))

        def listOpsItemEvents(
          request: ListOpsItemEventsRequest
        ): Kleisli[M, SsmClient, ListOpsItemEventsResponse] =
          primitive(_.listOpsItemEvents(request))

        def listOpsItemRelatedItems(
          request: ListOpsItemRelatedItemsRequest
        ): Kleisli[M, SsmClient, ListOpsItemRelatedItemsResponse] =
          primitive(_.listOpsItemRelatedItems(request))

        def listOpsMetadata(
          request: ListOpsMetadataRequest
        ): Kleisli[M, SsmClient, ListOpsMetadataResponse] =
          primitive(_.listOpsMetadata(request))

        def listResourceComplianceSummaries(
          request: ListResourceComplianceSummariesRequest
        ): Kleisli[M, SsmClient, ListResourceComplianceSummariesResponse] =
          primitive(_.listResourceComplianceSummaries(request))

        def listResourceDataSync(
          request: ListResourceDataSyncRequest
        ): Kleisli[M, SsmClient, ListResourceDataSyncResponse] =
          primitive(_.listResourceDataSync(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SsmClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyDocumentPermission(
          request: ModifyDocumentPermissionRequest
        ): Kleisli[M, SsmClient, ModifyDocumentPermissionResponse] =
          primitive(_.modifyDocumentPermission(request))

        def putComplianceItems(
          request: PutComplianceItemsRequest
        ): Kleisli[M, SsmClient, PutComplianceItemsResponse] =
          primitive(_.putComplianceItems(request))

        def putInventory(
          request: PutInventoryRequest
        ): Kleisli[M, SsmClient, PutInventoryResponse] =
          primitive(_.putInventory(request))

        def putParameter(
          request: PutParameterRequest
        ): Kleisli[M, SsmClient, PutParameterResponse] =
          primitive(_.putParameter(request))

        def registerDefaultPatchBaseline(
          request: RegisterDefaultPatchBaselineRequest
        ): Kleisli[M, SsmClient, RegisterDefaultPatchBaselineResponse] =
          primitive(_.registerDefaultPatchBaseline(request))

        def registerPatchBaselineForPatchGroup(
          request: RegisterPatchBaselineForPatchGroupRequest
        ): Kleisli[M, SsmClient, RegisterPatchBaselineForPatchGroupResponse] =
          primitive(_.registerPatchBaselineForPatchGroup(request))

        def registerTargetWithMaintenanceWindow(
          request: RegisterTargetWithMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, RegisterTargetWithMaintenanceWindowResponse] =
          primitive(_.registerTargetWithMaintenanceWindow(request))

        def registerTaskWithMaintenanceWindow(
          request: RegisterTaskWithMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, RegisterTaskWithMaintenanceWindowResponse] =
          primitive(_.registerTaskWithMaintenanceWindow(request))

        def removeTagsFromResource(
          request: RemoveTagsFromResourceRequest
        ): Kleisli[M, SsmClient, RemoveTagsFromResourceResponse] =
          primitive(_.removeTagsFromResource(request))

        def resetServiceSetting(
          request: ResetServiceSettingRequest
        ): Kleisli[M, SsmClient, ResetServiceSettingResponse] =
          primitive(_.resetServiceSetting(request))

        def resumeSession(
          request: ResumeSessionRequest
        ): Kleisli[M, SsmClient, ResumeSessionResponse] =
          primitive(_.resumeSession(request))

        def sendAutomationSignal(
          request: SendAutomationSignalRequest
        ): Kleisli[M, SsmClient, SendAutomationSignalResponse] =
          primitive(_.sendAutomationSignal(request))

        def sendCommand(
          request: SendCommandRequest
        ): Kleisli[M, SsmClient, SendCommandResponse] =
          primitive(_.sendCommand(request))

        def startAssociationsOnce(
          request: StartAssociationsOnceRequest
        ): Kleisli[M, SsmClient, StartAssociationsOnceResponse] =
          primitive(_.startAssociationsOnce(request))

        def startAutomationExecution(
          request: StartAutomationExecutionRequest
        ): Kleisli[M, SsmClient, StartAutomationExecutionResponse] =
          primitive(_.startAutomationExecution(request))

        def startChangeRequestExecution(
          request: StartChangeRequestExecutionRequest
        ): Kleisli[M, SsmClient, StartChangeRequestExecutionResponse] =
          primitive(_.startChangeRequestExecution(request))

        def startSession(
          request: StartSessionRequest
        ): Kleisli[M, SsmClient, StartSessionResponse] =
          primitive(_.startSession(request))

        def stopAutomationExecution(
          request: StopAutomationExecutionRequest
        ): Kleisli[M, SsmClient, StopAutomationExecutionResponse] =
          primitive(_.stopAutomationExecution(request))

        def terminateSession(
          request: TerminateSessionRequest
        ): Kleisli[M, SsmClient, TerminateSessionResponse] =
          primitive(_.terminateSession(request))

        def unlabelParameterVersion(
          request: UnlabelParameterVersionRequest
        ): Kleisli[M, SsmClient, UnlabelParameterVersionResponse] =
          primitive(_.unlabelParameterVersion(request))

        def updateAssociation(
          request: UpdateAssociationRequest
        ): Kleisli[M, SsmClient, UpdateAssociationResponse] =
          primitive(_.updateAssociation(request))

        def updateAssociationStatus(
          request: UpdateAssociationStatusRequest
        ): Kleisli[M, SsmClient, UpdateAssociationStatusResponse] =
          primitive(_.updateAssociationStatus(request))

        def updateDocument(
          request: UpdateDocumentRequest
        ): Kleisli[M, SsmClient, UpdateDocumentResponse] =
          primitive(_.updateDocument(request))

        def updateDocumentDefaultVersion(
          request: UpdateDocumentDefaultVersionRequest
        ): Kleisli[M, SsmClient, UpdateDocumentDefaultVersionResponse] =
          primitive(_.updateDocumentDefaultVersion(request))

        def updateDocumentMetadata(
          request: UpdateDocumentMetadataRequest
        ): Kleisli[M, SsmClient, UpdateDocumentMetadataResponse] =
          primitive(_.updateDocumentMetadata(request))

        def updateMaintenanceWindow(
          request: UpdateMaintenanceWindowRequest
        ): Kleisli[M, SsmClient, UpdateMaintenanceWindowResponse] =
          primitive(_.updateMaintenanceWindow(request))

        def updateMaintenanceWindowTarget(
          request: UpdateMaintenanceWindowTargetRequest
        ): Kleisli[M, SsmClient, UpdateMaintenanceWindowTargetResponse] =
          primitive(_.updateMaintenanceWindowTarget(request))

        def updateMaintenanceWindowTask(
          request: UpdateMaintenanceWindowTaskRequest
        ): Kleisli[M, SsmClient, UpdateMaintenanceWindowTaskResponse] =
          primitive(_.updateMaintenanceWindowTask(request))

        def updateManagedInstanceRole(
          request: UpdateManagedInstanceRoleRequest
        ): Kleisli[M, SsmClient, UpdateManagedInstanceRoleResponse] =
          primitive(_.updateManagedInstanceRole(request))

        def updateOpsItem(
          request: UpdateOpsItemRequest
        ): Kleisli[M, SsmClient, UpdateOpsItemResponse] =
          primitive(_.updateOpsItem(request))

        def updateOpsMetadata(
          request: UpdateOpsMetadataRequest
        ): Kleisli[M, SsmClient, UpdateOpsMetadataResponse] =
          primitive(_.updateOpsMetadata(request))

        def updatePatchBaseline(
          request: UpdatePatchBaselineRequest
        ): Kleisli[M, SsmClient, UpdatePatchBaselineResponse] =
          primitive(_.updatePatchBaseline(request))

        def updateResourceDataSync(
          request: UpdateResourceDataSyncRequest
        ): Kleisli[M, SsmClient, UpdateResourceDataSyncResponse] =
          primitive(_.updateResourceDataSync(request))

        def updateServiceSetting(
          request: UpdateServiceSettingRequest
        ): Kleisli[M, SsmClient, UpdateServiceSettingResponse] =
          primitive(_.updateServiceSetting(request))

        def primitive[A](
          f: SsmClient => A
        ): Kleisli[M, SsmClient, A]
      }
    }

    trait Visitor[F[_]] extends (SsmOp ~> F) {
      final def apply[A](op: SsmOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTagsToResource(
        request: AddTagsToResourceRequest
      ): F[AddTagsToResourceResponse]

      def associateOpsItemRelatedItem(
        request: AssociateOpsItemRelatedItemRequest
      ): F[AssociateOpsItemRelatedItemResponse]

      def cancelCommand(
        request: CancelCommandRequest
      ): F[CancelCommandResponse]

      def cancelMaintenanceWindowExecution(
        request: CancelMaintenanceWindowExecutionRequest
      ): F[CancelMaintenanceWindowExecutionResponse]

      def createActivation(
        request: CreateActivationRequest
      ): F[CreateActivationResponse]

      def createAssociation(
        request: CreateAssociationRequest
      ): F[CreateAssociationResponse]

      def createAssociationBatch(
        request: CreateAssociationBatchRequest
      ): F[CreateAssociationBatchResponse]

      def createDocument(
        request: CreateDocumentRequest
      ): F[CreateDocumentResponse]

      def createMaintenanceWindow(
        request: CreateMaintenanceWindowRequest
      ): F[CreateMaintenanceWindowResponse]

      def createOpsItem(
        request: CreateOpsItemRequest
      ): F[CreateOpsItemResponse]

      def createOpsMetadata(
        request: CreateOpsMetadataRequest
      ): F[CreateOpsMetadataResponse]

      def createPatchBaseline(
        request: CreatePatchBaselineRequest
      ): F[CreatePatchBaselineResponse]

      def createResourceDataSync(
        request: CreateResourceDataSyncRequest
      ): F[CreateResourceDataSyncResponse]

      def deleteActivation(
        request: DeleteActivationRequest
      ): F[DeleteActivationResponse]

      def deleteAssociation(
        request: DeleteAssociationRequest
      ): F[DeleteAssociationResponse]

      def deleteDocument(
        request: DeleteDocumentRequest
      ): F[DeleteDocumentResponse]

      def deleteInventory(
        request: DeleteInventoryRequest
      ): F[DeleteInventoryResponse]

      def deleteMaintenanceWindow(
        request: DeleteMaintenanceWindowRequest
      ): F[DeleteMaintenanceWindowResponse]

      def deleteOpsMetadata(
        request: DeleteOpsMetadataRequest
      ): F[DeleteOpsMetadataResponse]

      def deleteParameter(
        request: DeleteParameterRequest
      ): F[DeleteParameterResponse]

      def deleteParameters(
        request: DeleteParametersRequest
      ): F[DeleteParametersResponse]

      def deletePatchBaseline(
        request: DeletePatchBaselineRequest
      ): F[DeletePatchBaselineResponse]

      def deleteResourceDataSync(
        request: DeleteResourceDataSyncRequest
      ): F[DeleteResourceDataSyncResponse]

      def deregisterManagedInstance(
        request: DeregisterManagedInstanceRequest
      ): F[DeregisterManagedInstanceResponse]

      def deregisterPatchBaselineForPatchGroup(
        request: DeregisterPatchBaselineForPatchGroupRequest
      ): F[DeregisterPatchBaselineForPatchGroupResponse]

      def deregisterTargetFromMaintenanceWindow(
        request: DeregisterTargetFromMaintenanceWindowRequest
      ): F[DeregisterTargetFromMaintenanceWindowResponse]

      def deregisterTaskFromMaintenanceWindow(
        request: DeregisterTaskFromMaintenanceWindowRequest
      ): F[DeregisterTaskFromMaintenanceWindowResponse]

      def describeActivations(
        request: DescribeActivationsRequest
      ): F[DescribeActivationsResponse]

      def describeAssociation(
        request: DescribeAssociationRequest
      ): F[DescribeAssociationResponse]

      def describeAssociationExecutionTargets(
        request: DescribeAssociationExecutionTargetsRequest
      ): F[DescribeAssociationExecutionTargetsResponse]

      def describeAssociationExecutions(
        request: DescribeAssociationExecutionsRequest
      ): F[DescribeAssociationExecutionsResponse]

      def describeAutomationExecutions(
        request: DescribeAutomationExecutionsRequest
      ): F[DescribeAutomationExecutionsResponse]

      def describeAutomationStepExecutions(
        request: DescribeAutomationStepExecutionsRequest
      ): F[DescribeAutomationStepExecutionsResponse]

      def describeAvailablePatches(
        request: DescribeAvailablePatchesRequest
      ): F[DescribeAvailablePatchesResponse]

      def describeDocument(
        request: DescribeDocumentRequest
      ): F[DescribeDocumentResponse]

      def describeDocumentPermission(
        request: DescribeDocumentPermissionRequest
      ): F[DescribeDocumentPermissionResponse]

      def describeEffectiveInstanceAssociations(
        request: DescribeEffectiveInstanceAssociationsRequest
      ): F[DescribeEffectiveInstanceAssociationsResponse]

      def describeEffectivePatchesForPatchBaseline(
        request: DescribeEffectivePatchesForPatchBaselineRequest
      ): F[DescribeEffectivePatchesForPatchBaselineResponse]

      def describeInstanceAssociationsStatus(
        request: DescribeInstanceAssociationsStatusRequest
      ): F[DescribeInstanceAssociationsStatusResponse]

      def describeInstanceInformation(
        request: DescribeInstanceInformationRequest
      ): F[DescribeInstanceInformationResponse]

      def describeInstancePatchStates(
        request: DescribeInstancePatchStatesRequest
      ): F[DescribeInstancePatchStatesResponse]

      def describeInstancePatchStatesForPatchGroup(
        request: DescribeInstancePatchStatesForPatchGroupRequest
      ): F[DescribeInstancePatchStatesForPatchGroupResponse]

      def describeInstancePatches(
        request: DescribeInstancePatchesRequest
      ): F[DescribeInstancePatchesResponse]

      def describeInventoryDeletions(
        request: DescribeInventoryDeletionsRequest
      ): F[DescribeInventoryDeletionsResponse]

      def describeMaintenanceWindowExecutionTaskInvocations(
        request: DescribeMaintenanceWindowExecutionTaskInvocationsRequest
      ): F[DescribeMaintenanceWindowExecutionTaskInvocationsResponse]

      def describeMaintenanceWindowExecutionTasks(
        request: DescribeMaintenanceWindowExecutionTasksRequest
      ): F[DescribeMaintenanceWindowExecutionTasksResponse]

      def describeMaintenanceWindowExecutions(
        request: DescribeMaintenanceWindowExecutionsRequest
      ): F[DescribeMaintenanceWindowExecutionsResponse]

      def describeMaintenanceWindowSchedule(
        request: DescribeMaintenanceWindowScheduleRequest
      ): F[DescribeMaintenanceWindowScheduleResponse]

      def describeMaintenanceWindowTargets(
        request: DescribeMaintenanceWindowTargetsRequest
      ): F[DescribeMaintenanceWindowTargetsResponse]

      def describeMaintenanceWindowTasks(
        request: DescribeMaintenanceWindowTasksRequest
      ): F[DescribeMaintenanceWindowTasksResponse]

      def describeMaintenanceWindows(
        request: DescribeMaintenanceWindowsRequest
      ): F[DescribeMaintenanceWindowsResponse]

      def describeMaintenanceWindowsForTarget(
        request: DescribeMaintenanceWindowsForTargetRequest
      ): F[DescribeMaintenanceWindowsForTargetResponse]

      def describeOpsItems(
        request: DescribeOpsItemsRequest
      ): F[DescribeOpsItemsResponse]

      def describeParameters(
        request: DescribeParametersRequest
      ): F[DescribeParametersResponse]

      def describePatchBaselines(
        request: DescribePatchBaselinesRequest
      ): F[DescribePatchBaselinesResponse]

      def describePatchGroupState(
        request: DescribePatchGroupStateRequest
      ): F[DescribePatchGroupStateResponse]

      def describePatchGroups(
        request: DescribePatchGroupsRequest
      ): F[DescribePatchGroupsResponse]

      def describePatchProperties(
        request: DescribePatchPropertiesRequest
      ): F[DescribePatchPropertiesResponse]

      def describeSessions(
        request: DescribeSessionsRequest
      ): F[DescribeSessionsResponse]

      def disassociateOpsItemRelatedItem(
        request: DisassociateOpsItemRelatedItemRequest
      ): F[DisassociateOpsItemRelatedItemResponse]

      def getAutomationExecution(
        request: GetAutomationExecutionRequest
      ): F[GetAutomationExecutionResponse]

      def getCalendarState(
        request: GetCalendarStateRequest
      ): F[GetCalendarStateResponse]

      def getCommandInvocation(
        request: GetCommandInvocationRequest
      ): F[GetCommandInvocationResponse]

      def getConnectionStatus(
        request: GetConnectionStatusRequest
      ): F[GetConnectionStatusResponse]

      def getDefaultPatchBaseline(
        request: GetDefaultPatchBaselineRequest
      ): F[GetDefaultPatchBaselineResponse]

      def getDeployablePatchSnapshotForInstance(
        request: GetDeployablePatchSnapshotForInstanceRequest
      ): F[GetDeployablePatchSnapshotForInstanceResponse]

      def getDocument(
        request: GetDocumentRequest
      ): F[GetDocumentResponse]

      def getInventory(
        request: GetInventoryRequest
      ): F[GetInventoryResponse]

      def getInventorySchema(
        request: GetInventorySchemaRequest
      ): F[GetInventorySchemaResponse]

      def getMaintenanceWindow(
        request: GetMaintenanceWindowRequest
      ): F[GetMaintenanceWindowResponse]

      def getMaintenanceWindowExecution(
        request: GetMaintenanceWindowExecutionRequest
      ): F[GetMaintenanceWindowExecutionResponse]

      def getMaintenanceWindowExecutionTask(
        request: GetMaintenanceWindowExecutionTaskRequest
      ): F[GetMaintenanceWindowExecutionTaskResponse]

      def getMaintenanceWindowExecutionTaskInvocation(
        request: GetMaintenanceWindowExecutionTaskInvocationRequest
      ): F[GetMaintenanceWindowExecutionTaskInvocationResponse]

      def getMaintenanceWindowTask(
        request: GetMaintenanceWindowTaskRequest
      ): F[GetMaintenanceWindowTaskResponse]

      def getOpsItem(
        request: GetOpsItemRequest
      ): F[GetOpsItemResponse]

      def getOpsMetadata(
        request: GetOpsMetadataRequest
      ): F[GetOpsMetadataResponse]

      def getOpsSummary(
        request: GetOpsSummaryRequest
      ): F[GetOpsSummaryResponse]

      def getParameter(
        request: GetParameterRequest
      ): F[GetParameterResponse]

      def getParameterHistory(
        request: GetParameterHistoryRequest
      ): F[GetParameterHistoryResponse]

      def getParameters(
        request: GetParametersRequest
      ): F[GetParametersResponse]

      def getParametersByPath(
        request: GetParametersByPathRequest
      ): F[GetParametersByPathResponse]

      def getPatchBaseline(
        request: GetPatchBaselineRequest
      ): F[GetPatchBaselineResponse]

      def getPatchBaselineForPatchGroup(
        request: GetPatchBaselineForPatchGroupRequest
      ): F[GetPatchBaselineForPatchGroupResponse]

      def getServiceSetting(
        request: GetServiceSettingRequest
      ): F[GetServiceSettingResponse]

      def labelParameterVersion(
        request: LabelParameterVersionRequest
      ): F[LabelParameterVersionResponse]

      def listAssociationVersions(
        request: ListAssociationVersionsRequest
      ): F[ListAssociationVersionsResponse]

      def listAssociations(
        request: ListAssociationsRequest
      ): F[ListAssociationsResponse]

      def listCommandInvocations(
        request: ListCommandInvocationsRequest
      ): F[ListCommandInvocationsResponse]

      def listCommands(
        request: ListCommandsRequest
      ): F[ListCommandsResponse]

      def listComplianceItems(
        request: ListComplianceItemsRequest
      ): F[ListComplianceItemsResponse]

      def listComplianceSummaries(
        request: ListComplianceSummariesRequest
      ): F[ListComplianceSummariesResponse]

      def listDocumentMetadataHistory(
        request: ListDocumentMetadataHistoryRequest
      ): F[ListDocumentMetadataHistoryResponse]

      def listDocumentVersions(
        request: ListDocumentVersionsRequest
      ): F[ListDocumentVersionsResponse]

      def listDocuments(
        request: ListDocumentsRequest
      ): F[ListDocumentsResponse]

      def listInventoryEntries(
        request: ListInventoryEntriesRequest
      ): F[ListInventoryEntriesResponse]

      def listOpsItemEvents(
        request: ListOpsItemEventsRequest
      ): F[ListOpsItemEventsResponse]

      def listOpsItemRelatedItems(
        request: ListOpsItemRelatedItemsRequest
      ): F[ListOpsItemRelatedItemsResponse]

      def listOpsMetadata(
        request: ListOpsMetadataRequest
      ): F[ListOpsMetadataResponse]

      def listResourceComplianceSummaries(
        request: ListResourceComplianceSummariesRequest
      ): F[ListResourceComplianceSummariesResponse]

      def listResourceDataSync(
        request: ListResourceDataSyncRequest
      ): F[ListResourceDataSyncResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyDocumentPermission(
        request: ModifyDocumentPermissionRequest
      ): F[ModifyDocumentPermissionResponse]

      def putComplianceItems(
        request: PutComplianceItemsRequest
      ): F[PutComplianceItemsResponse]

      def putInventory(
        request: PutInventoryRequest
      ): F[PutInventoryResponse]

      def putParameter(
        request: PutParameterRequest
      ): F[PutParameterResponse]

      def registerDefaultPatchBaseline(
        request: RegisterDefaultPatchBaselineRequest
      ): F[RegisterDefaultPatchBaselineResponse]

      def registerPatchBaselineForPatchGroup(
        request: RegisterPatchBaselineForPatchGroupRequest
      ): F[RegisterPatchBaselineForPatchGroupResponse]

      def registerTargetWithMaintenanceWindow(
        request: RegisterTargetWithMaintenanceWindowRequest
      ): F[RegisterTargetWithMaintenanceWindowResponse]

      def registerTaskWithMaintenanceWindow(
        request: RegisterTaskWithMaintenanceWindowRequest
      ): F[RegisterTaskWithMaintenanceWindowResponse]

      def removeTagsFromResource(
        request: RemoveTagsFromResourceRequest
      ): F[RemoveTagsFromResourceResponse]

      def resetServiceSetting(
        request: ResetServiceSettingRequest
      ): F[ResetServiceSettingResponse]

      def resumeSession(
        request: ResumeSessionRequest
      ): F[ResumeSessionResponse]

      def sendAutomationSignal(
        request: SendAutomationSignalRequest
      ): F[SendAutomationSignalResponse]

      def sendCommand(
        request: SendCommandRequest
      ): F[SendCommandResponse]

      def startAssociationsOnce(
        request: StartAssociationsOnceRequest
      ): F[StartAssociationsOnceResponse]

      def startAutomationExecution(
        request: StartAutomationExecutionRequest
      ): F[StartAutomationExecutionResponse]

      def startChangeRequestExecution(
        request: StartChangeRequestExecutionRequest
      ): F[StartChangeRequestExecutionResponse]

      def startSession(
        request: StartSessionRequest
      ): F[StartSessionResponse]

      def stopAutomationExecution(
        request: StopAutomationExecutionRequest
      ): F[StopAutomationExecutionResponse]

      def terminateSession(
        request: TerminateSessionRequest
      ): F[TerminateSessionResponse]

      def unlabelParameterVersion(
        request: UnlabelParameterVersionRequest
      ): F[UnlabelParameterVersionResponse]

      def updateAssociation(
        request: UpdateAssociationRequest
      ): F[UpdateAssociationResponse]

      def updateAssociationStatus(
        request: UpdateAssociationStatusRequest
      ): F[UpdateAssociationStatusResponse]

      def updateDocument(
        request: UpdateDocumentRequest
      ): F[UpdateDocumentResponse]

      def updateDocumentDefaultVersion(
        request: UpdateDocumentDefaultVersionRequest
      ): F[UpdateDocumentDefaultVersionResponse]

      def updateDocumentMetadata(
        request: UpdateDocumentMetadataRequest
      ): F[UpdateDocumentMetadataResponse]

      def updateMaintenanceWindow(
        request: UpdateMaintenanceWindowRequest
      ): F[UpdateMaintenanceWindowResponse]

      def updateMaintenanceWindowTarget(
        request: UpdateMaintenanceWindowTargetRequest
      ): F[UpdateMaintenanceWindowTargetResponse]

      def updateMaintenanceWindowTask(
        request: UpdateMaintenanceWindowTaskRequest
      ): F[UpdateMaintenanceWindowTaskResponse]

      def updateManagedInstanceRole(
        request: UpdateManagedInstanceRoleRequest
      ): F[UpdateManagedInstanceRoleResponse]

      def updateOpsItem(
        request: UpdateOpsItemRequest
      ): F[UpdateOpsItemResponse]

      def updateOpsMetadata(
        request: UpdateOpsMetadataRequest
      ): F[UpdateOpsMetadataResponse]

      def updatePatchBaseline(
        request: UpdatePatchBaselineRequest
      ): F[UpdatePatchBaselineResponse]

      def updateResourceDataSync(
        request: UpdateResourceDataSyncRequest
      ): F[UpdateResourceDataSyncResponse]

      def updateServiceSetting(
        request: UpdateServiceSettingRequest
      ): F[UpdateServiceSettingResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SsmOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsToResourceOp(
      request: AddTagsToResourceRequest
    ) extends SsmOp[AddTagsToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToResourceResponse] =
        visitor.addTagsToResource(request)
    }

    final case class AssociateOpsItemRelatedItemOp(
      request: AssociateOpsItemRelatedItemRequest
    ) extends SsmOp[AssociateOpsItemRelatedItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateOpsItemRelatedItemResponse] =
        visitor.associateOpsItemRelatedItem(request)
    }

    final case class CancelCommandOp(
      request: CancelCommandRequest
    ) extends SsmOp[CancelCommandResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelCommandResponse] =
        visitor.cancelCommand(request)
    }

    final case class CancelMaintenanceWindowExecutionOp(
      request: CancelMaintenanceWindowExecutionRequest
    ) extends SsmOp[CancelMaintenanceWindowExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelMaintenanceWindowExecutionResponse] =
        visitor.cancelMaintenanceWindowExecution(request)
    }

    final case class CreateActivationOp(
      request: CreateActivationRequest
    ) extends SsmOp[CreateActivationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateActivationResponse] =
        visitor.createActivation(request)
    }

    final case class CreateAssociationOp(
      request: CreateAssociationRequest
    ) extends SsmOp[CreateAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssociationResponse] =
        visitor.createAssociation(request)
    }

    final case class CreateAssociationBatchOp(
      request: CreateAssociationBatchRequest
    ) extends SsmOp[CreateAssociationBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssociationBatchResponse] =
        visitor.createAssociationBatch(request)
    }

    final case class CreateDocumentOp(
      request: CreateDocumentRequest
    ) extends SsmOp[CreateDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDocumentResponse] =
        visitor.createDocument(request)
    }

    final case class CreateMaintenanceWindowOp(
      request: CreateMaintenanceWindowRequest
    ) extends SsmOp[CreateMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMaintenanceWindowResponse] =
        visitor.createMaintenanceWindow(request)
    }

    final case class CreateOpsItemOp(
      request: CreateOpsItemRequest
    ) extends SsmOp[CreateOpsItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOpsItemResponse] =
        visitor.createOpsItem(request)
    }

    final case class CreateOpsMetadataOp(
      request: CreateOpsMetadataRequest
    ) extends SsmOp[CreateOpsMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOpsMetadataResponse] =
        visitor.createOpsMetadata(request)
    }

    final case class CreatePatchBaselineOp(
      request: CreatePatchBaselineRequest
    ) extends SsmOp[CreatePatchBaselineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePatchBaselineResponse] =
        visitor.createPatchBaseline(request)
    }

    final case class CreateResourceDataSyncOp(
      request: CreateResourceDataSyncRequest
    ) extends SsmOp[CreateResourceDataSyncResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceDataSyncResponse] =
        visitor.createResourceDataSync(request)
    }

    final case class DeleteActivationOp(
      request: DeleteActivationRequest
    ) extends SsmOp[DeleteActivationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteActivationResponse] =
        visitor.deleteActivation(request)
    }

    final case class DeleteAssociationOp(
      request: DeleteAssociationRequest
    ) extends SsmOp[DeleteAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssociationResponse] =
        visitor.deleteAssociation(request)
    }

    final case class DeleteDocumentOp(
      request: DeleteDocumentRequest
    ) extends SsmOp[DeleteDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDocumentResponse] =
        visitor.deleteDocument(request)
    }

    final case class DeleteInventoryOp(
      request: DeleteInventoryRequest
    ) extends SsmOp[DeleteInventoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInventoryResponse] =
        visitor.deleteInventory(request)
    }

    final case class DeleteMaintenanceWindowOp(
      request: DeleteMaintenanceWindowRequest
    ) extends SsmOp[DeleteMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMaintenanceWindowResponse] =
        visitor.deleteMaintenanceWindow(request)
    }

    final case class DeleteOpsMetadataOp(
      request: DeleteOpsMetadataRequest
    ) extends SsmOp[DeleteOpsMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOpsMetadataResponse] =
        visitor.deleteOpsMetadata(request)
    }

    final case class DeleteParameterOp(
      request: DeleteParameterRequest
    ) extends SsmOp[DeleteParameterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteParameterResponse] =
        visitor.deleteParameter(request)
    }

    final case class DeleteParametersOp(
      request: DeleteParametersRequest
    ) extends SsmOp[DeleteParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteParametersResponse] =
        visitor.deleteParameters(request)
    }

    final case class DeletePatchBaselineOp(
      request: DeletePatchBaselineRequest
    ) extends SsmOp[DeletePatchBaselineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePatchBaselineResponse] =
        visitor.deletePatchBaseline(request)
    }

    final case class DeleteResourceDataSyncOp(
      request: DeleteResourceDataSyncRequest
    ) extends SsmOp[DeleteResourceDataSyncResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceDataSyncResponse] =
        visitor.deleteResourceDataSync(request)
    }

    final case class DeregisterManagedInstanceOp(
      request: DeregisterManagedInstanceRequest
    ) extends SsmOp[DeregisterManagedInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterManagedInstanceResponse] =
        visitor.deregisterManagedInstance(request)
    }

    final case class DeregisterPatchBaselineForPatchGroupOp(
      request: DeregisterPatchBaselineForPatchGroupRequest
    ) extends SsmOp[DeregisterPatchBaselineForPatchGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterPatchBaselineForPatchGroupResponse] =
        visitor.deregisterPatchBaselineForPatchGroup(request)
    }

    final case class DeregisterTargetFromMaintenanceWindowOp(
      request: DeregisterTargetFromMaintenanceWindowRequest
    ) extends SsmOp[DeregisterTargetFromMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTargetFromMaintenanceWindowResponse] =
        visitor.deregisterTargetFromMaintenanceWindow(request)
    }

    final case class DeregisterTaskFromMaintenanceWindowOp(
      request: DeregisterTaskFromMaintenanceWindowRequest
    ) extends SsmOp[DeregisterTaskFromMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTaskFromMaintenanceWindowResponse] =
        visitor.deregisterTaskFromMaintenanceWindow(request)
    }

    final case class DescribeActivationsOp(
      request: DescribeActivationsRequest
    ) extends SsmOp[DescribeActivationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeActivationsResponse] =
        visitor.describeActivations(request)
    }

    final case class DescribeAssociationOp(
      request: DescribeAssociationRequest
    ) extends SsmOp[DescribeAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssociationResponse] =
        visitor.describeAssociation(request)
    }

    final case class DescribeAssociationExecutionTargetsOp(
      request: DescribeAssociationExecutionTargetsRequest
    ) extends SsmOp[DescribeAssociationExecutionTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssociationExecutionTargetsResponse] =
        visitor.describeAssociationExecutionTargets(request)
    }

    final case class DescribeAssociationExecutionsOp(
      request: DescribeAssociationExecutionsRequest
    ) extends SsmOp[DescribeAssociationExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssociationExecutionsResponse] =
        visitor.describeAssociationExecutions(request)
    }

    final case class DescribeAutomationExecutionsOp(
      request: DescribeAutomationExecutionsRequest
    ) extends SsmOp[DescribeAutomationExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAutomationExecutionsResponse] =
        visitor.describeAutomationExecutions(request)
    }

    final case class DescribeAutomationStepExecutionsOp(
      request: DescribeAutomationStepExecutionsRequest
    ) extends SsmOp[DescribeAutomationStepExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAutomationStepExecutionsResponse] =
        visitor.describeAutomationStepExecutions(request)
    }

    final case class DescribeAvailablePatchesOp(
      request: DescribeAvailablePatchesRequest
    ) extends SsmOp[DescribeAvailablePatchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAvailablePatchesResponse] =
        visitor.describeAvailablePatches(request)
    }

    final case class DescribeDocumentOp(
      request: DescribeDocumentRequest
    ) extends SsmOp[DescribeDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDocumentResponse] =
        visitor.describeDocument(request)
    }

    final case class DescribeDocumentPermissionOp(
      request: DescribeDocumentPermissionRequest
    ) extends SsmOp[DescribeDocumentPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDocumentPermissionResponse] =
        visitor.describeDocumentPermission(request)
    }

    final case class DescribeEffectiveInstanceAssociationsOp(
      request: DescribeEffectiveInstanceAssociationsRequest
    ) extends SsmOp[DescribeEffectiveInstanceAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEffectiveInstanceAssociationsResponse] =
        visitor.describeEffectiveInstanceAssociations(request)
    }

    final case class DescribeEffectivePatchesForPatchBaselineOp(
      request: DescribeEffectivePatchesForPatchBaselineRequest
    ) extends SsmOp[DescribeEffectivePatchesForPatchBaselineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEffectivePatchesForPatchBaselineResponse] =
        visitor.describeEffectivePatchesForPatchBaseline(request)
    }

    final case class DescribeInstanceAssociationsStatusOp(
      request: DescribeInstanceAssociationsStatusRequest
    ) extends SsmOp[DescribeInstanceAssociationsStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceAssociationsStatusResponse] =
        visitor.describeInstanceAssociationsStatus(request)
    }

    final case class DescribeInstanceInformationOp(
      request: DescribeInstanceInformationRequest
    ) extends SsmOp[DescribeInstanceInformationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceInformationResponse] =
        visitor.describeInstanceInformation(request)
    }

    final case class DescribeInstancePatchStatesOp(
      request: DescribeInstancePatchStatesRequest
    ) extends SsmOp[DescribeInstancePatchStatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstancePatchStatesResponse] =
        visitor.describeInstancePatchStates(request)
    }

    final case class DescribeInstancePatchStatesForPatchGroupOp(
      request: DescribeInstancePatchStatesForPatchGroupRequest
    ) extends SsmOp[DescribeInstancePatchStatesForPatchGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstancePatchStatesForPatchGroupResponse] =
        visitor.describeInstancePatchStatesForPatchGroup(request)
    }

    final case class DescribeInstancePatchesOp(
      request: DescribeInstancePatchesRequest
    ) extends SsmOp[DescribeInstancePatchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstancePatchesResponse] =
        visitor.describeInstancePatches(request)
    }

    final case class DescribeInventoryDeletionsOp(
      request: DescribeInventoryDeletionsRequest
    ) extends SsmOp[DescribeInventoryDeletionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInventoryDeletionsResponse] =
        visitor.describeInventoryDeletions(request)
    }

    final case class DescribeMaintenanceWindowExecutionTaskInvocationsOp(
      request: DescribeMaintenanceWindowExecutionTaskInvocationsRequest
    ) extends SsmOp[DescribeMaintenanceWindowExecutionTaskInvocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowExecutionTaskInvocationsResponse] =
        visitor.describeMaintenanceWindowExecutionTaskInvocations(request)
    }

    final case class DescribeMaintenanceWindowExecutionTasksOp(
      request: DescribeMaintenanceWindowExecutionTasksRequest
    ) extends SsmOp[DescribeMaintenanceWindowExecutionTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowExecutionTasksResponse] =
        visitor.describeMaintenanceWindowExecutionTasks(request)
    }

    final case class DescribeMaintenanceWindowExecutionsOp(
      request: DescribeMaintenanceWindowExecutionsRequest
    ) extends SsmOp[DescribeMaintenanceWindowExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowExecutionsResponse] =
        visitor.describeMaintenanceWindowExecutions(request)
    }

    final case class DescribeMaintenanceWindowScheduleOp(
      request: DescribeMaintenanceWindowScheduleRequest
    ) extends SsmOp[DescribeMaintenanceWindowScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowScheduleResponse] =
        visitor.describeMaintenanceWindowSchedule(request)
    }

    final case class DescribeMaintenanceWindowTargetsOp(
      request: DescribeMaintenanceWindowTargetsRequest
    ) extends SsmOp[DescribeMaintenanceWindowTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowTargetsResponse] =
        visitor.describeMaintenanceWindowTargets(request)
    }

    final case class DescribeMaintenanceWindowTasksOp(
      request: DescribeMaintenanceWindowTasksRequest
    ) extends SsmOp[DescribeMaintenanceWindowTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowTasksResponse] =
        visitor.describeMaintenanceWindowTasks(request)
    }

    final case class DescribeMaintenanceWindowsOp(
      request: DescribeMaintenanceWindowsRequest
    ) extends SsmOp[DescribeMaintenanceWindowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowsResponse] =
        visitor.describeMaintenanceWindows(request)
    }

    final case class DescribeMaintenanceWindowsForTargetOp(
      request: DescribeMaintenanceWindowsForTargetRequest
    ) extends SsmOp[DescribeMaintenanceWindowsForTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMaintenanceWindowsForTargetResponse] =
        visitor.describeMaintenanceWindowsForTarget(request)
    }

    final case class DescribeOpsItemsOp(
      request: DescribeOpsItemsRequest
    ) extends SsmOp[DescribeOpsItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOpsItemsResponse] =
        visitor.describeOpsItems(request)
    }

    final case class DescribeParametersOp(
      request: DescribeParametersRequest
    ) extends SsmOp[DescribeParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeParametersResponse] =
        visitor.describeParameters(request)
    }

    final case class DescribePatchBaselinesOp(
      request: DescribePatchBaselinesRequest
    ) extends SsmOp[DescribePatchBaselinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePatchBaselinesResponse] =
        visitor.describePatchBaselines(request)
    }

    final case class DescribePatchGroupStateOp(
      request: DescribePatchGroupStateRequest
    ) extends SsmOp[DescribePatchGroupStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePatchGroupStateResponse] =
        visitor.describePatchGroupState(request)
    }

    final case class DescribePatchGroupsOp(
      request: DescribePatchGroupsRequest
    ) extends SsmOp[DescribePatchGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePatchGroupsResponse] =
        visitor.describePatchGroups(request)
    }

    final case class DescribePatchPropertiesOp(
      request: DescribePatchPropertiesRequest
    ) extends SsmOp[DescribePatchPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePatchPropertiesResponse] =
        visitor.describePatchProperties(request)
    }

    final case class DescribeSessionsOp(
      request: DescribeSessionsRequest
    ) extends SsmOp[DescribeSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSessionsResponse] =
        visitor.describeSessions(request)
    }

    final case class DisassociateOpsItemRelatedItemOp(
      request: DisassociateOpsItemRelatedItemRequest
    ) extends SsmOp[DisassociateOpsItemRelatedItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateOpsItemRelatedItemResponse] =
        visitor.disassociateOpsItemRelatedItem(request)
    }

    final case class GetAutomationExecutionOp(
      request: GetAutomationExecutionRequest
    ) extends SsmOp[GetAutomationExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAutomationExecutionResponse] =
        visitor.getAutomationExecution(request)
    }

    final case class GetCalendarStateOp(
      request: GetCalendarStateRequest
    ) extends SsmOp[GetCalendarStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCalendarStateResponse] =
        visitor.getCalendarState(request)
    }

    final case class GetCommandInvocationOp(
      request: GetCommandInvocationRequest
    ) extends SsmOp[GetCommandInvocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCommandInvocationResponse] =
        visitor.getCommandInvocation(request)
    }

    final case class GetConnectionStatusOp(
      request: GetConnectionStatusRequest
    ) extends SsmOp[GetConnectionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectionStatusResponse] =
        visitor.getConnectionStatus(request)
    }

    final case class GetDefaultPatchBaselineOp(
      request: GetDefaultPatchBaselineRequest
    ) extends SsmOp[GetDefaultPatchBaselineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDefaultPatchBaselineResponse] =
        visitor.getDefaultPatchBaseline(request)
    }

    final case class GetDeployablePatchSnapshotForInstanceOp(
      request: GetDeployablePatchSnapshotForInstanceRequest
    ) extends SsmOp[GetDeployablePatchSnapshotForInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeployablePatchSnapshotForInstanceResponse] =
        visitor.getDeployablePatchSnapshotForInstance(request)
    }

    final case class GetDocumentOp(
      request: GetDocumentRequest
    ) extends SsmOp[GetDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentResponse] =
        visitor.getDocument(request)
    }

    final case class GetInventoryOp(
      request: GetInventoryRequest
    ) extends SsmOp[GetInventoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInventoryResponse] =
        visitor.getInventory(request)
    }

    final case class GetInventorySchemaOp(
      request: GetInventorySchemaRequest
    ) extends SsmOp[GetInventorySchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInventorySchemaResponse] =
        visitor.getInventorySchema(request)
    }

    final case class GetMaintenanceWindowOp(
      request: GetMaintenanceWindowRequest
    ) extends SsmOp[GetMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMaintenanceWindowResponse] =
        visitor.getMaintenanceWindow(request)
    }

    final case class GetMaintenanceWindowExecutionOp(
      request: GetMaintenanceWindowExecutionRequest
    ) extends SsmOp[GetMaintenanceWindowExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMaintenanceWindowExecutionResponse] =
        visitor.getMaintenanceWindowExecution(request)
    }

    final case class GetMaintenanceWindowExecutionTaskOp(
      request: GetMaintenanceWindowExecutionTaskRequest
    ) extends SsmOp[GetMaintenanceWindowExecutionTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMaintenanceWindowExecutionTaskResponse] =
        visitor.getMaintenanceWindowExecutionTask(request)
    }

    final case class GetMaintenanceWindowExecutionTaskInvocationOp(
      request: GetMaintenanceWindowExecutionTaskInvocationRequest
    ) extends SsmOp[GetMaintenanceWindowExecutionTaskInvocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMaintenanceWindowExecutionTaskInvocationResponse] =
        visitor.getMaintenanceWindowExecutionTaskInvocation(request)
    }

    final case class GetMaintenanceWindowTaskOp(
      request: GetMaintenanceWindowTaskRequest
    ) extends SsmOp[GetMaintenanceWindowTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMaintenanceWindowTaskResponse] =
        visitor.getMaintenanceWindowTask(request)
    }

    final case class GetOpsItemOp(
      request: GetOpsItemRequest
    ) extends SsmOp[GetOpsItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOpsItemResponse] =
        visitor.getOpsItem(request)
    }

    final case class GetOpsMetadataOp(
      request: GetOpsMetadataRequest
    ) extends SsmOp[GetOpsMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOpsMetadataResponse] =
        visitor.getOpsMetadata(request)
    }

    final case class GetOpsSummaryOp(
      request: GetOpsSummaryRequest
    ) extends SsmOp[GetOpsSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOpsSummaryResponse] =
        visitor.getOpsSummary(request)
    }

    final case class GetParameterOp(
      request: GetParameterRequest
    ) extends SsmOp[GetParameterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetParameterResponse] =
        visitor.getParameter(request)
    }

    final case class GetParameterHistoryOp(
      request: GetParameterHistoryRequest
    ) extends SsmOp[GetParameterHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetParameterHistoryResponse] =
        visitor.getParameterHistory(request)
    }

    final case class GetParametersOp(
      request: GetParametersRequest
    ) extends SsmOp[GetParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetParametersResponse] =
        visitor.getParameters(request)
    }

    final case class GetParametersByPathOp(
      request: GetParametersByPathRequest
    ) extends SsmOp[GetParametersByPathResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetParametersByPathResponse] =
        visitor.getParametersByPath(request)
    }

    final case class GetPatchBaselineOp(
      request: GetPatchBaselineRequest
    ) extends SsmOp[GetPatchBaselineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPatchBaselineResponse] =
        visitor.getPatchBaseline(request)
    }

    final case class GetPatchBaselineForPatchGroupOp(
      request: GetPatchBaselineForPatchGroupRequest
    ) extends SsmOp[GetPatchBaselineForPatchGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPatchBaselineForPatchGroupResponse] =
        visitor.getPatchBaselineForPatchGroup(request)
    }

    final case class GetServiceSettingOp(
      request: GetServiceSettingRequest
    ) extends SsmOp[GetServiceSettingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceSettingResponse] =
        visitor.getServiceSetting(request)
    }

    final case class LabelParameterVersionOp(
      request: LabelParameterVersionRequest
    ) extends SsmOp[LabelParameterVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LabelParameterVersionResponse] =
        visitor.labelParameterVersion(request)
    }

    final case class ListAssociationVersionsOp(
      request: ListAssociationVersionsRequest
    ) extends SsmOp[ListAssociationVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociationVersionsResponse] =
        visitor.listAssociationVersions(request)
    }

    final case class ListAssociationsOp(
      request: ListAssociationsRequest
    ) extends SsmOp[ListAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociationsResponse] =
        visitor.listAssociations(request)
    }

    final case class ListCommandInvocationsOp(
      request: ListCommandInvocationsRequest
    ) extends SsmOp[ListCommandInvocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCommandInvocationsResponse] =
        visitor.listCommandInvocations(request)
    }

    final case class ListCommandsOp(
      request: ListCommandsRequest
    ) extends SsmOp[ListCommandsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCommandsResponse] =
        visitor.listCommands(request)
    }

    final case class ListComplianceItemsOp(
      request: ListComplianceItemsRequest
    ) extends SsmOp[ListComplianceItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComplianceItemsResponse] =
        visitor.listComplianceItems(request)
    }

    final case class ListComplianceSummariesOp(
      request: ListComplianceSummariesRequest
    ) extends SsmOp[ListComplianceSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComplianceSummariesResponse] =
        visitor.listComplianceSummaries(request)
    }

    final case class ListDocumentMetadataHistoryOp(
      request: ListDocumentMetadataHistoryRequest
    ) extends SsmOp[ListDocumentMetadataHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDocumentMetadataHistoryResponse] =
        visitor.listDocumentMetadataHistory(request)
    }

    final case class ListDocumentVersionsOp(
      request: ListDocumentVersionsRequest
    ) extends SsmOp[ListDocumentVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDocumentVersionsResponse] =
        visitor.listDocumentVersions(request)
    }

    final case class ListDocumentsOp(
      request: ListDocumentsRequest
    ) extends SsmOp[ListDocumentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDocumentsResponse] =
        visitor.listDocuments(request)
    }

    final case class ListInventoryEntriesOp(
      request: ListInventoryEntriesRequest
    ) extends SsmOp[ListInventoryEntriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInventoryEntriesResponse] =
        visitor.listInventoryEntries(request)
    }

    final case class ListOpsItemEventsOp(
      request: ListOpsItemEventsRequest
    ) extends SsmOp[ListOpsItemEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOpsItemEventsResponse] =
        visitor.listOpsItemEvents(request)
    }

    final case class ListOpsItemRelatedItemsOp(
      request: ListOpsItemRelatedItemsRequest
    ) extends SsmOp[ListOpsItemRelatedItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOpsItemRelatedItemsResponse] =
        visitor.listOpsItemRelatedItems(request)
    }

    final case class ListOpsMetadataOp(
      request: ListOpsMetadataRequest
    ) extends SsmOp[ListOpsMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOpsMetadataResponse] =
        visitor.listOpsMetadata(request)
    }

    final case class ListResourceComplianceSummariesOp(
      request: ListResourceComplianceSummariesRequest
    ) extends SsmOp[ListResourceComplianceSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceComplianceSummariesResponse] =
        visitor.listResourceComplianceSummaries(request)
    }

    final case class ListResourceDataSyncOp(
      request: ListResourceDataSyncRequest
    ) extends SsmOp[ListResourceDataSyncResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceDataSyncResponse] =
        visitor.listResourceDataSync(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SsmOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyDocumentPermissionOp(
      request: ModifyDocumentPermissionRequest
    ) extends SsmOp[ModifyDocumentPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyDocumentPermissionResponse] =
        visitor.modifyDocumentPermission(request)
    }

    final case class PutComplianceItemsOp(
      request: PutComplianceItemsRequest
    ) extends SsmOp[PutComplianceItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutComplianceItemsResponse] =
        visitor.putComplianceItems(request)
    }

    final case class PutInventoryOp(
      request: PutInventoryRequest
    ) extends SsmOp[PutInventoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutInventoryResponse] =
        visitor.putInventory(request)
    }

    final case class PutParameterOp(
      request: PutParameterRequest
    ) extends SsmOp[PutParameterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutParameterResponse] =
        visitor.putParameter(request)
    }

    final case class RegisterDefaultPatchBaselineOp(
      request: RegisterDefaultPatchBaselineRequest
    ) extends SsmOp[RegisterDefaultPatchBaselineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterDefaultPatchBaselineResponse] =
        visitor.registerDefaultPatchBaseline(request)
    }

    final case class RegisterPatchBaselineForPatchGroupOp(
      request: RegisterPatchBaselineForPatchGroupRequest
    ) extends SsmOp[RegisterPatchBaselineForPatchGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterPatchBaselineForPatchGroupResponse] =
        visitor.registerPatchBaselineForPatchGroup(request)
    }

    final case class RegisterTargetWithMaintenanceWindowOp(
      request: RegisterTargetWithMaintenanceWindowRequest
    ) extends SsmOp[RegisterTargetWithMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTargetWithMaintenanceWindowResponse] =
        visitor.registerTargetWithMaintenanceWindow(request)
    }

    final case class RegisterTaskWithMaintenanceWindowOp(
      request: RegisterTaskWithMaintenanceWindowRequest
    ) extends SsmOp[RegisterTaskWithMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTaskWithMaintenanceWindowResponse] =
        visitor.registerTaskWithMaintenanceWindow(request)
    }

    final case class RemoveTagsFromResourceOp(
      request: RemoveTagsFromResourceRequest
    ) extends SsmOp[RemoveTagsFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromResourceResponse] =
        visitor.removeTagsFromResource(request)
    }

    final case class ResetServiceSettingOp(
      request: ResetServiceSettingRequest
    ) extends SsmOp[ResetServiceSettingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetServiceSettingResponse] =
        visitor.resetServiceSetting(request)
    }

    final case class ResumeSessionOp(
      request: ResumeSessionRequest
    ) extends SsmOp[ResumeSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResumeSessionResponse] =
        visitor.resumeSession(request)
    }

    final case class SendAutomationSignalOp(
      request: SendAutomationSignalRequest
    ) extends SsmOp[SendAutomationSignalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendAutomationSignalResponse] =
        visitor.sendAutomationSignal(request)
    }

    final case class SendCommandOp(
      request: SendCommandRequest
    ) extends SsmOp[SendCommandResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendCommandResponse] =
        visitor.sendCommand(request)
    }

    final case class StartAssociationsOnceOp(
      request: StartAssociationsOnceRequest
    ) extends SsmOp[StartAssociationsOnceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAssociationsOnceResponse] =
        visitor.startAssociationsOnce(request)
    }

    final case class StartAutomationExecutionOp(
      request: StartAutomationExecutionRequest
    ) extends SsmOp[StartAutomationExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAutomationExecutionResponse] =
        visitor.startAutomationExecution(request)
    }

    final case class StartChangeRequestExecutionOp(
      request: StartChangeRequestExecutionRequest
    ) extends SsmOp[StartChangeRequestExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartChangeRequestExecutionResponse] =
        visitor.startChangeRequestExecution(request)
    }

    final case class StartSessionOp(
      request: StartSessionRequest
    ) extends SsmOp[StartSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSessionResponse] =
        visitor.startSession(request)
    }

    final case class StopAutomationExecutionOp(
      request: StopAutomationExecutionRequest
    ) extends SsmOp[StopAutomationExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopAutomationExecutionResponse] =
        visitor.stopAutomationExecution(request)
    }

    final case class TerminateSessionOp(
      request: TerminateSessionRequest
    ) extends SsmOp[TerminateSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateSessionResponse] =
        visitor.terminateSession(request)
    }

    final case class UnlabelParameterVersionOp(
      request: UnlabelParameterVersionRequest
    ) extends SsmOp[UnlabelParameterVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnlabelParameterVersionResponse] =
        visitor.unlabelParameterVersion(request)
    }

    final case class UpdateAssociationOp(
      request: UpdateAssociationRequest
    ) extends SsmOp[UpdateAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssociationResponse] =
        visitor.updateAssociation(request)
    }

    final case class UpdateAssociationStatusOp(
      request: UpdateAssociationStatusRequest
    ) extends SsmOp[UpdateAssociationStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssociationStatusResponse] =
        visitor.updateAssociationStatus(request)
    }

    final case class UpdateDocumentOp(
      request: UpdateDocumentRequest
    ) extends SsmOp[UpdateDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDocumentResponse] =
        visitor.updateDocument(request)
    }

    final case class UpdateDocumentDefaultVersionOp(
      request: UpdateDocumentDefaultVersionRequest
    ) extends SsmOp[UpdateDocumentDefaultVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDocumentDefaultVersionResponse] =
        visitor.updateDocumentDefaultVersion(request)
    }

    final case class UpdateDocumentMetadataOp(
      request: UpdateDocumentMetadataRequest
    ) extends SsmOp[UpdateDocumentMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDocumentMetadataResponse] =
        visitor.updateDocumentMetadata(request)
    }

    final case class UpdateMaintenanceWindowOp(
      request: UpdateMaintenanceWindowRequest
    ) extends SsmOp[UpdateMaintenanceWindowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMaintenanceWindowResponse] =
        visitor.updateMaintenanceWindow(request)
    }

    final case class UpdateMaintenanceWindowTargetOp(
      request: UpdateMaintenanceWindowTargetRequest
    ) extends SsmOp[UpdateMaintenanceWindowTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMaintenanceWindowTargetResponse] =
        visitor.updateMaintenanceWindowTarget(request)
    }

    final case class UpdateMaintenanceWindowTaskOp(
      request: UpdateMaintenanceWindowTaskRequest
    ) extends SsmOp[UpdateMaintenanceWindowTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMaintenanceWindowTaskResponse] =
        visitor.updateMaintenanceWindowTask(request)
    }

    final case class UpdateManagedInstanceRoleOp(
      request: UpdateManagedInstanceRoleRequest
    ) extends SsmOp[UpdateManagedInstanceRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateManagedInstanceRoleResponse] =
        visitor.updateManagedInstanceRole(request)
    }

    final case class UpdateOpsItemOp(
      request: UpdateOpsItemRequest
    ) extends SsmOp[UpdateOpsItemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOpsItemResponse] =
        visitor.updateOpsItem(request)
    }

    final case class UpdateOpsMetadataOp(
      request: UpdateOpsMetadataRequest
    ) extends SsmOp[UpdateOpsMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOpsMetadataResponse] =
        visitor.updateOpsMetadata(request)
    }

    final case class UpdatePatchBaselineOp(
      request: UpdatePatchBaselineRequest
    ) extends SsmOp[UpdatePatchBaselineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePatchBaselineResponse] =
        visitor.updatePatchBaseline(request)
    }

    final case class UpdateResourceDataSyncOp(
      request: UpdateResourceDataSyncRequest
    ) extends SsmOp[UpdateResourceDataSyncResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceDataSyncResponse] =
        visitor.updateResourceDataSync(request)
    }

    final case class UpdateServiceSettingOp(
      request: UpdateServiceSettingRequest
    ) extends SsmOp[UpdateServiceSettingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceSettingResponse] =
        visitor.updateServiceSetting(request)
    }
  }

  import SsmOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SsmOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTagsToResource(
    request: AddTagsToResourceRequest
  ): SsmIO[AddTagsToResourceResponse] =
    FF.liftF(AddTagsToResourceOp(request))

  def associateOpsItemRelatedItem(
    request: AssociateOpsItemRelatedItemRequest
  ): SsmIO[AssociateOpsItemRelatedItemResponse] =
    FF.liftF(AssociateOpsItemRelatedItemOp(request))

  def cancelCommand(
    request: CancelCommandRequest
  ): SsmIO[CancelCommandResponse] =
    FF.liftF(CancelCommandOp(request))

  def cancelMaintenanceWindowExecution(
    request: CancelMaintenanceWindowExecutionRequest
  ): SsmIO[CancelMaintenanceWindowExecutionResponse] =
    FF.liftF(CancelMaintenanceWindowExecutionOp(request))

  def createActivation(
    request: CreateActivationRequest
  ): SsmIO[CreateActivationResponse] =
    FF.liftF(CreateActivationOp(request))

  def createAssociation(
    request: CreateAssociationRequest
  ): SsmIO[CreateAssociationResponse] =
    FF.liftF(CreateAssociationOp(request))

  def createAssociationBatch(
    request: CreateAssociationBatchRequest
  ): SsmIO[CreateAssociationBatchResponse] =
    FF.liftF(CreateAssociationBatchOp(request))

  def createDocument(
    request: CreateDocumentRequest
  ): SsmIO[CreateDocumentResponse] =
    FF.liftF(CreateDocumentOp(request))

  def createMaintenanceWindow(
    request: CreateMaintenanceWindowRequest
  ): SsmIO[CreateMaintenanceWindowResponse] =
    FF.liftF(CreateMaintenanceWindowOp(request))

  def createOpsItem(
    request: CreateOpsItemRequest
  ): SsmIO[CreateOpsItemResponse] =
    FF.liftF(CreateOpsItemOp(request))

  def createOpsMetadata(
    request: CreateOpsMetadataRequest
  ): SsmIO[CreateOpsMetadataResponse] =
    FF.liftF(CreateOpsMetadataOp(request))

  def createPatchBaseline(
    request: CreatePatchBaselineRequest
  ): SsmIO[CreatePatchBaselineResponse] =
    FF.liftF(CreatePatchBaselineOp(request))

  def createResourceDataSync(
    request: CreateResourceDataSyncRequest
  ): SsmIO[CreateResourceDataSyncResponse] =
    FF.liftF(CreateResourceDataSyncOp(request))

  def deleteActivation(
    request: DeleteActivationRequest
  ): SsmIO[DeleteActivationResponse] =
    FF.liftF(DeleteActivationOp(request))

  def deleteAssociation(
    request: DeleteAssociationRequest
  ): SsmIO[DeleteAssociationResponse] =
    FF.liftF(DeleteAssociationOp(request))

  def deleteDocument(
    request: DeleteDocumentRequest
  ): SsmIO[DeleteDocumentResponse] =
    FF.liftF(DeleteDocumentOp(request))

  def deleteInventory(
    request: DeleteInventoryRequest
  ): SsmIO[DeleteInventoryResponse] =
    FF.liftF(DeleteInventoryOp(request))

  def deleteMaintenanceWindow(
    request: DeleteMaintenanceWindowRequest
  ): SsmIO[DeleteMaintenanceWindowResponse] =
    FF.liftF(DeleteMaintenanceWindowOp(request))

  def deleteOpsMetadata(
    request: DeleteOpsMetadataRequest
  ): SsmIO[DeleteOpsMetadataResponse] =
    FF.liftF(DeleteOpsMetadataOp(request))

  def deleteParameter(
    request: DeleteParameterRequest
  ): SsmIO[DeleteParameterResponse] =
    FF.liftF(DeleteParameterOp(request))

  def deleteParameters(
    request: DeleteParametersRequest
  ): SsmIO[DeleteParametersResponse] =
    FF.liftF(DeleteParametersOp(request))

  def deletePatchBaseline(
    request: DeletePatchBaselineRequest
  ): SsmIO[DeletePatchBaselineResponse] =
    FF.liftF(DeletePatchBaselineOp(request))

  def deleteResourceDataSync(
    request: DeleteResourceDataSyncRequest
  ): SsmIO[DeleteResourceDataSyncResponse] =
    FF.liftF(DeleteResourceDataSyncOp(request))

  def deregisterManagedInstance(
    request: DeregisterManagedInstanceRequest
  ): SsmIO[DeregisterManagedInstanceResponse] =
    FF.liftF(DeregisterManagedInstanceOp(request))

  def deregisterPatchBaselineForPatchGroup(
    request: DeregisterPatchBaselineForPatchGroupRequest
  ): SsmIO[DeregisterPatchBaselineForPatchGroupResponse] =
    FF.liftF(DeregisterPatchBaselineForPatchGroupOp(request))

  def deregisterTargetFromMaintenanceWindow(
    request: DeregisterTargetFromMaintenanceWindowRequest
  ): SsmIO[DeregisterTargetFromMaintenanceWindowResponse] =
    FF.liftF(DeregisterTargetFromMaintenanceWindowOp(request))

  def deregisterTaskFromMaintenanceWindow(
    request: DeregisterTaskFromMaintenanceWindowRequest
  ): SsmIO[DeregisterTaskFromMaintenanceWindowResponse] =
    FF.liftF(DeregisterTaskFromMaintenanceWindowOp(request))

  def describeActivations(
    request: DescribeActivationsRequest
  ): SsmIO[DescribeActivationsResponse] =
    FF.liftF(DescribeActivationsOp(request))

  def describeAssociation(
    request: DescribeAssociationRequest
  ): SsmIO[DescribeAssociationResponse] =
    FF.liftF(DescribeAssociationOp(request))

  def describeAssociationExecutionTargets(
    request: DescribeAssociationExecutionTargetsRequest
  ): SsmIO[DescribeAssociationExecutionTargetsResponse] =
    FF.liftF(DescribeAssociationExecutionTargetsOp(request))

  def describeAssociationExecutions(
    request: DescribeAssociationExecutionsRequest
  ): SsmIO[DescribeAssociationExecutionsResponse] =
    FF.liftF(DescribeAssociationExecutionsOp(request))

  def describeAutomationExecutions(
    request: DescribeAutomationExecutionsRequest
  ): SsmIO[DescribeAutomationExecutionsResponse] =
    FF.liftF(DescribeAutomationExecutionsOp(request))

  def describeAutomationStepExecutions(
    request: DescribeAutomationStepExecutionsRequest
  ): SsmIO[DescribeAutomationStepExecutionsResponse] =
    FF.liftF(DescribeAutomationStepExecutionsOp(request))

  def describeAvailablePatches(
    request: DescribeAvailablePatchesRequest
  ): SsmIO[DescribeAvailablePatchesResponse] =
    FF.liftF(DescribeAvailablePatchesOp(request))

  def describeDocument(
    request: DescribeDocumentRequest
  ): SsmIO[DescribeDocumentResponse] =
    FF.liftF(DescribeDocumentOp(request))

  def describeDocumentPermission(
    request: DescribeDocumentPermissionRequest
  ): SsmIO[DescribeDocumentPermissionResponse] =
    FF.liftF(DescribeDocumentPermissionOp(request))

  def describeEffectiveInstanceAssociations(
    request: DescribeEffectiveInstanceAssociationsRequest
  ): SsmIO[DescribeEffectiveInstanceAssociationsResponse] =
    FF.liftF(DescribeEffectiveInstanceAssociationsOp(request))

  def describeEffectivePatchesForPatchBaseline(
    request: DescribeEffectivePatchesForPatchBaselineRequest
  ): SsmIO[DescribeEffectivePatchesForPatchBaselineResponse] =
    FF.liftF(DescribeEffectivePatchesForPatchBaselineOp(request))

  def describeInstanceAssociationsStatus(
    request: DescribeInstanceAssociationsStatusRequest
  ): SsmIO[DescribeInstanceAssociationsStatusResponse] =
    FF.liftF(DescribeInstanceAssociationsStatusOp(request))

  def describeInstanceInformation(
    request: DescribeInstanceInformationRequest
  ): SsmIO[DescribeInstanceInformationResponse] =
    FF.liftF(DescribeInstanceInformationOp(request))

  def describeInstancePatchStates(
    request: DescribeInstancePatchStatesRequest
  ): SsmIO[DescribeInstancePatchStatesResponse] =
    FF.liftF(DescribeInstancePatchStatesOp(request))

  def describeInstancePatchStatesForPatchGroup(
    request: DescribeInstancePatchStatesForPatchGroupRequest
  ): SsmIO[DescribeInstancePatchStatesForPatchGroupResponse] =
    FF.liftF(DescribeInstancePatchStatesForPatchGroupOp(request))

  def describeInstancePatches(
    request: DescribeInstancePatchesRequest
  ): SsmIO[DescribeInstancePatchesResponse] =
    FF.liftF(DescribeInstancePatchesOp(request))

  def describeInventoryDeletions(
    request: DescribeInventoryDeletionsRequest
  ): SsmIO[DescribeInventoryDeletionsResponse] =
    FF.liftF(DescribeInventoryDeletionsOp(request))

  def describeMaintenanceWindowExecutionTaskInvocations(
    request: DescribeMaintenanceWindowExecutionTaskInvocationsRequest
  ): SsmIO[DescribeMaintenanceWindowExecutionTaskInvocationsResponse] =
    FF.liftF(DescribeMaintenanceWindowExecutionTaskInvocationsOp(request))

  def describeMaintenanceWindowExecutionTasks(
    request: DescribeMaintenanceWindowExecutionTasksRequest
  ): SsmIO[DescribeMaintenanceWindowExecutionTasksResponse] =
    FF.liftF(DescribeMaintenanceWindowExecutionTasksOp(request))

  def describeMaintenanceWindowExecutions(
    request: DescribeMaintenanceWindowExecutionsRequest
  ): SsmIO[DescribeMaintenanceWindowExecutionsResponse] =
    FF.liftF(DescribeMaintenanceWindowExecutionsOp(request))

  def describeMaintenanceWindowSchedule(
    request: DescribeMaintenanceWindowScheduleRequest
  ): SsmIO[DescribeMaintenanceWindowScheduleResponse] =
    FF.liftF(DescribeMaintenanceWindowScheduleOp(request))

  def describeMaintenanceWindowTargets(
    request: DescribeMaintenanceWindowTargetsRequest
  ): SsmIO[DescribeMaintenanceWindowTargetsResponse] =
    FF.liftF(DescribeMaintenanceWindowTargetsOp(request))

  def describeMaintenanceWindowTasks(
    request: DescribeMaintenanceWindowTasksRequest
  ): SsmIO[DescribeMaintenanceWindowTasksResponse] =
    FF.liftF(DescribeMaintenanceWindowTasksOp(request))

  def describeMaintenanceWindows(
    request: DescribeMaintenanceWindowsRequest
  ): SsmIO[DescribeMaintenanceWindowsResponse] =
    FF.liftF(DescribeMaintenanceWindowsOp(request))

  def describeMaintenanceWindowsForTarget(
    request: DescribeMaintenanceWindowsForTargetRequest
  ): SsmIO[DescribeMaintenanceWindowsForTargetResponse] =
    FF.liftF(DescribeMaintenanceWindowsForTargetOp(request))

  def describeOpsItems(
    request: DescribeOpsItemsRequest
  ): SsmIO[DescribeOpsItemsResponse] =
    FF.liftF(DescribeOpsItemsOp(request))

  def describeParameters(
    request: DescribeParametersRequest
  ): SsmIO[DescribeParametersResponse] =
    FF.liftF(DescribeParametersOp(request))

  def describePatchBaselines(
    request: DescribePatchBaselinesRequest
  ): SsmIO[DescribePatchBaselinesResponse] =
    FF.liftF(DescribePatchBaselinesOp(request))

  def describePatchGroupState(
    request: DescribePatchGroupStateRequest
  ): SsmIO[DescribePatchGroupStateResponse] =
    FF.liftF(DescribePatchGroupStateOp(request))

  def describePatchGroups(
    request: DescribePatchGroupsRequest
  ): SsmIO[DescribePatchGroupsResponse] =
    FF.liftF(DescribePatchGroupsOp(request))

  def describePatchProperties(
    request: DescribePatchPropertiesRequest
  ): SsmIO[DescribePatchPropertiesResponse] =
    FF.liftF(DescribePatchPropertiesOp(request))

  def describeSessions(
    request: DescribeSessionsRequest
  ): SsmIO[DescribeSessionsResponse] =
    FF.liftF(DescribeSessionsOp(request))

  def disassociateOpsItemRelatedItem(
    request: DisassociateOpsItemRelatedItemRequest
  ): SsmIO[DisassociateOpsItemRelatedItemResponse] =
    FF.liftF(DisassociateOpsItemRelatedItemOp(request))

  def getAutomationExecution(
    request: GetAutomationExecutionRequest
  ): SsmIO[GetAutomationExecutionResponse] =
    FF.liftF(GetAutomationExecutionOp(request))

  def getCalendarState(
    request: GetCalendarStateRequest
  ): SsmIO[GetCalendarStateResponse] =
    FF.liftF(GetCalendarStateOp(request))

  def getCommandInvocation(
    request: GetCommandInvocationRequest
  ): SsmIO[GetCommandInvocationResponse] =
    FF.liftF(GetCommandInvocationOp(request))

  def getConnectionStatus(
    request: GetConnectionStatusRequest
  ): SsmIO[GetConnectionStatusResponse] =
    FF.liftF(GetConnectionStatusOp(request))

  def getDefaultPatchBaseline(
    request: GetDefaultPatchBaselineRequest
  ): SsmIO[GetDefaultPatchBaselineResponse] =
    FF.liftF(GetDefaultPatchBaselineOp(request))

  def getDeployablePatchSnapshotForInstance(
    request: GetDeployablePatchSnapshotForInstanceRequest
  ): SsmIO[GetDeployablePatchSnapshotForInstanceResponse] =
    FF.liftF(GetDeployablePatchSnapshotForInstanceOp(request))

  def getDocument(
    request: GetDocumentRequest
  ): SsmIO[GetDocumentResponse] =
    FF.liftF(GetDocumentOp(request))

  def getInventory(
    request: GetInventoryRequest
  ): SsmIO[GetInventoryResponse] =
    FF.liftF(GetInventoryOp(request))

  def getInventorySchema(
    request: GetInventorySchemaRequest
  ): SsmIO[GetInventorySchemaResponse] =
    FF.liftF(GetInventorySchemaOp(request))

  def getMaintenanceWindow(
    request: GetMaintenanceWindowRequest
  ): SsmIO[GetMaintenanceWindowResponse] =
    FF.liftF(GetMaintenanceWindowOp(request))

  def getMaintenanceWindowExecution(
    request: GetMaintenanceWindowExecutionRequest
  ): SsmIO[GetMaintenanceWindowExecutionResponse] =
    FF.liftF(GetMaintenanceWindowExecutionOp(request))

  def getMaintenanceWindowExecutionTask(
    request: GetMaintenanceWindowExecutionTaskRequest
  ): SsmIO[GetMaintenanceWindowExecutionTaskResponse] =
    FF.liftF(GetMaintenanceWindowExecutionTaskOp(request))

  def getMaintenanceWindowExecutionTaskInvocation(
    request: GetMaintenanceWindowExecutionTaskInvocationRequest
  ): SsmIO[GetMaintenanceWindowExecutionTaskInvocationResponse] =
    FF.liftF(GetMaintenanceWindowExecutionTaskInvocationOp(request))

  def getMaintenanceWindowTask(
    request: GetMaintenanceWindowTaskRequest
  ): SsmIO[GetMaintenanceWindowTaskResponse] =
    FF.liftF(GetMaintenanceWindowTaskOp(request))

  def getOpsItem(
    request: GetOpsItemRequest
  ): SsmIO[GetOpsItemResponse] =
    FF.liftF(GetOpsItemOp(request))

  def getOpsMetadata(
    request: GetOpsMetadataRequest
  ): SsmIO[GetOpsMetadataResponse] =
    FF.liftF(GetOpsMetadataOp(request))

  def getOpsSummary(
    request: GetOpsSummaryRequest
  ): SsmIO[GetOpsSummaryResponse] =
    FF.liftF(GetOpsSummaryOp(request))

  def getParameter(
    request: GetParameterRequest
  ): SsmIO[GetParameterResponse] =
    FF.liftF(GetParameterOp(request))

  def getParameterHistory(
    request: GetParameterHistoryRequest
  ): SsmIO[GetParameterHistoryResponse] =
    FF.liftF(GetParameterHistoryOp(request))

  def getParameters(
    request: GetParametersRequest
  ): SsmIO[GetParametersResponse] =
    FF.liftF(GetParametersOp(request))

  def getParametersByPath(
    request: GetParametersByPathRequest
  ): SsmIO[GetParametersByPathResponse] =
    FF.liftF(GetParametersByPathOp(request))

  def getPatchBaseline(
    request: GetPatchBaselineRequest
  ): SsmIO[GetPatchBaselineResponse] =
    FF.liftF(GetPatchBaselineOp(request))

  def getPatchBaselineForPatchGroup(
    request: GetPatchBaselineForPatchGroupRequest
  ): SsmIO[GetPatchBaselineForPatchGroupResponse] =
    FF.liftF(GetPatchBaselineForPatchGroupOp(request))

  def getServiceSetting(
    request: GetServiceSettingRequest
  ): SsmIO[GetServiceSettingResponse] =
    FF.liftF(GetServiceSettingOp(request))

  def labelParameterVersion(
    request: LabelParameterVersionRequest
  ): SsmIO[LabelParameterVersionResponse] =
    FF.liftF(LabelParameterVersionOp(request))

  def listAssociationVersions(
    request: ListAssociationVersionsRequest
  ): SsmIO[ListAssociationVersionsResponse] =
    FF.liftF(ListAssociationVersionsOp(request))

  def listAssociations(
    request: ListAssociationsRequest
  ): SsmIO[ListAssociationsResponse] =
    FF.liftF(ListAssociationsOp(request))

  def listCommandInvocations(
    request: ListCommandInvocationsRequest
  ): SsmIO[ListCommandInvocationsResponse] =
    FF.liftF(ListCommandInvocationsOp(request))

  def listCommands(
    request: ListCommandsRequest
  ): SsmIO[ListCommandsResponse] =
    FF.liftF(ListCommandsOp(request))

  def listComplianceItems(
    request: ListComplianceItemsRequest
  ): SsmIO[ListComplianceItemsResponse] =
    FF.liftF(ListComplianceItemsOp(request))

  def listComplianceSummaries(
    request: ListComplianceSummariesRequest
  ): SsmIO[ListComplianceSummariesResponse] =
    FF.liftF(ListComplianceSummariesOp(request))

  def listDocumentMetadataHistory(
    request: ListDocumentMetadataHistoryRequest
  ): SsmIO[ListDocumentMetadataHistoryResponse] =
    FF.liftF(ListDocumentMetadataHistoryOp(request))

  def listDocumentVersions(
    request: ListDocumentVersionsRequest
  ): SsmIO[ListDocumentVersionsResponse] =
    FF.liftF(ListDocumentVersionsOp(request))

  def listDocuments(
    request: ListDocumentsRequest
  ): SsmIO[ListDocumentsResponse] =
    FF.liftF(ListDocumentsOp(request))

  def listInventoryEntries(
    request: ListInventoryEntriesRequest
  ): SsmIO[ListInventoryEntriesResponse] =
    FF.liftF(ListInventoryEntriesOp(request))

  def listOpsItemEvents(
    request: ListOpsItemEventsRequest
  ): SsmIO[ListOpsItemEventsResponse] =
    FF.liftF(ListOpsItemEventsOp(request))

  def listOpsItemRelatedItems(
    request: ListOpsItemRelatedItemsRequest
  ): SsmIO[ListOpsItemRelatedItemsResponse] =
    FF.liftF(ListOpsItemRelatedItemsOp(request))

  def listOpsMetadata(
    request: ListOpsMetadataRequest
  ): SsmIO[ListOpsMetadataResponse] =
    FF.liftF(ListOpsMetadataOp(request))

  def listResourceComplianceSummaries(
    request: ListResourceComplianceSummariesRequest
  ): SsmIO[ListResourceComplianceSummariesResponse] =
    FF.liftF(ListResourceComplianceSummariesOp(request))

  def listResourceDataSync(
    request: ListResourceDataSyncRequest
  ): SsmIO[ListResourceDataSyncResponse] =
    FF.liftF(ListResourceDataSyncOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SsmIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyDocumentPermission(
    request: ModifyDocumentPermissionRequest
  ): SsmIO[ModifyDocumentPermissionResponse] =
    FF.liftF(ModifyDocumentPermissionOp(request))

  def putComplianceItems(
    request: PutComplianceItemsRequest
  ): SsmIO[PutComplianceItemsResponse] =
    FF.liftF(PutComplianceItemsOp(request))

  def putInventory(
    request: PutInventoryRequest
  ): SsmIO[PutInventoryResponse] =
    FF.liftF(PutInventoryOp(request))

  def putParameter(
    request: PutParameterRequest
  ): SsmIO[PutParameterResponse] =
    FF.liftF(PutParameterOp(request))

  def registerDefaultPatchBaseline(
    request: RegisterDefaultPatchBaselineRequest
  ): SsmIO[RegisterDefaultPatchBaselineResponse] =
    FF.liftF(RegisterDefaultPatchBaselineOp(request))

  def registerPatchBaselineForPatchGroup(
    request: RegisterPatchBaselineForPatchGroupRequest
  ): SsmIO[RegisterPatchBaselineForPatchGroupResponse] =
    FF.liftF(RegisterPatchBaselineForPatchGroupOp(request))

  def registerTargetWithMaintenanceWindow(
    request: RegisterTargetWithMaintenanceWindowRequest
  ): SsmIO[RegisterTargetWithMaintenanceWindowResponse] =
    FF.liftF(RegisterTargetWithMaintenanceWindowOp(request))

  def registerTaskWithMaintenanceWindow(
    request: RegisterTaskWithMaintenanceWindowRequest
  ): SsmIO[RegisterTaskWithMaintenanceWindowResponse] =
    FF.liftF(RegisterTaskWithMaintenanceWindowOp(request))

  def removeTagsFromResource(
    request: RemoveTagsFromResourceRequest
  ): SsmIO[RemoveTagsFromResourceResponse] =
    FF.liftF(RemoveTagsFromResourceOp(request))

  def resetServiceSetting(
    request: ResetServiceSettingRequest
  ): SsmIO[ResetServiceSettingResponse] =
    FF.liftF(ResetServiceSettingOp(request))

  def resumeSession(
    request: ResumeSessionRequest
  ): SsmIO[ResumeSessionResponse] =
    FF.liftF(ResumeSessionOp(request))

  def sendAutomationSignal(
    request: SendAutomationSignalRequest
  ): SsmIO[SendAutomationSignalResponse] =
    FF.liftF(SendAutomationSignalOp(request))

  def sendCommand(
    request: SendCommandRequest
  ): SsmIO[SendCommandResponse] =
    FF.liftF(SendCommandOp(request))

  def startAssociationsOnce(
    request: StartAssociationsOnceRequest
  ): SsmIO[StartAssociationsOnceResponse] =
    FF.liftF(StartAssociationsOnceOp(request))

  def startAutomationExecution(
    request: StartAutomationExecutionRequest
  ): SsmIO[StartAutomationExecutionResponse] =
    FF.liftF(StartAutomationExecutionOp(request))

  def startChangeRequestExecution(
    request: StartChangeRequestExecutionRequest
  ): SsmIO[StartChangeRequestExecutionResponse] =
    FF.liftF(StartChangeRequestExecutionOp(request))

  def startSession(
    request: StartSessionRequest
  ): SsmIO[StartSessionResponse] =
    FF.liftF(StartSessionOp(request))

  def stopAutomationExecution(
    request: StopAutomationExecutionRequest
  ): SsmIO[StopAutomationExecutionResponse] =
    FF.liftF(StopAutomationExecutionOp(request))

  def terminateSession(
    request: TerminateSessionRequest
  ): SsmIO[TerminateSessionResponse] =
    FF.liftF(TerminateSessionOp(request))

  def unlabelParameterVersion(
    request: UnlabelParameterVersionRequest
  ): SsmIO[UnlabelParameterVersionResponse] =
    FF.liftF(UnlabelParameterVersionOp(request))

  def updateAssociation(
    request: UpdateAssociationRequest
  ): SsmIO[UpdateAssociationResponse] =
    FF.liftF(UpdateAssociationOp(request))

  def updateAssociationStatus(
    request: UpdateAssociationStatusRequest
  ): SsmIO[UpdateAssociationStatusResponse] =
    FF.liftF(UpdateAssociationStatusOp(request))

  def updateDocument(
    request: UpdateDocumentRequest
  ): SsmIO[UpdateDocumentResponse] =
    FF.liftF(UpdateDocumentOp(request))

  def updateDocumentDefaultVersion(
    request: UpdateDocumentDefaultVersionRequest
  ): SsmIO[UpdateDocumentDefaultVersionResponse] =
    FF.liftF(UpdateDocumentDefaultVersionOp(request))

  def updateDocumentMetadata(
    request: UpdateDocumentMetadataRequest
  ): SsmIO[UpdateDocumentMetadataResponse] =
    FF.liftF(UpdateDocumentMetadataOp(request))

  def updateMaintenanceWindow(
    request: UpdateMaintenanceWindowRequest
  ): SsmIO[UpdateMaintenanceWindowResponse] =
    FF.liftF(UpdateMaintenanceWindowOp(request))

  def updateMaintenanceWindowTarget(
    request: UpdateMaintenanceWindowTargetRequest
  ): SsmIO[UpdateMaintenanceWindowTargetResponse] =
    FF.liftF(UpdateMaintenanceWindowTargetOp(request))

  def updateMaintenanceWindowTask(
    request: UpdateMaintenanceWindowTaskRequest
  ): SsmIO[UpdateMaintenanceWindowTaskResponse] =
    FF.liftF(UpdateMaintenanceWindowTaskOp(request))

  def updateManagedInstanceRole(
    request: UpdateManagedInstanceRoleRequest
  ): SsmIO[UpdateManagedInstanceRoleResponse] =
    FF.liftF(UpdateManagedInstanceRoleOp(request))

  def updateOpsItem(
    request: UpdateOpsItemRequest
  ): SsmIO[UpdateOpsItemResponse] =
    FF.liftF(UpdateOpsItemOp(request))

  def updateOpsMetadata(
    request: UpdateOpsMetadataRequest
  ): SsmIO[UpdateOpsMetadataResponse] =
    FF.liftF(UpdateOpsMetadataOp(request))

  def updatePatchBaseline(
    request: UpdatePatchBaselineRequest
  ): SsmIO[UpdatePatchBaselineResponse] =
    FF.liftF(UpdatePatchBaselineOp(request))

  def updateResourceDataSync(
    request: UpdateResourceDataSyncRequest
  ): SsmIO[UpdateResourceDataSyncResponse] =
    FF.liftF(UpdateResourceDataSyncOp(request))

  def updateServiceSetting(
    request: UpdateServiceSettingRequest
  ): SsmIO[UpdateServiceSettingResponse] =
    FF.liftF(UpdateServiceSettingOp(request))
}
