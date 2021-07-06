package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.glue.GlueClient
import software.amazon.awssdk.services.glue.model._


object glue { module =>

  // Free monad over GlueOp
  type GlueIO[A] = FF[GlueOp, A]

  sealed trait GlueOp[A] {
    def visit[F[_]](visitor: GlueOp.Visitor[F]): F[A]
  }

  object GlueOp {
    // Given a GlueClient we can embed a GlueIO program in any algebra that understands embedding.
    implicit val GlueOpEmbeddable: Embeddable[GlueOp, GlueClient] = new Embeddable[GlueOp, GlueClient] {
      def embed[A](client: GlueClient, io: GlueIO[A]): Embedded[A] = Embedded.Glue(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GlueOp.Visitor[Kleisli[M, GlueClient, *]] {
        def batchCreatePartition(
          request: BatchCreatePartitionRequest
        ): Kleisli[M, GlueClient, BatchCreatePartitionResponse] =
          primitive(_.batchCreatePartition(request))

        def batchDeleteConnection(
          request: BatchDeleteConnectionRequest
        ): Kleisli[M, GlueClient, BatchDeleteConnectionResponse] =
          primitive(_.batchDeleteConnection(request))

        def batchDeletePartition(
          request: BatchDeletePartitionRequest
        ): Kleisli[M, GlueClient, BatchDeletePartitionResponse] =
          primitive(_.batchDeletePartition(request))

        def batchDeleteTable(
          request: BatchDeleteTableRequest
        ): Kleisli[M, GlueClient, BatchDeleteTableResponse] =
          primitive(_.batchDeleteTable(request))

        def batchDeleteTableVersion(
          request: BatchDeleteTableVersionRequest
        ): Kleisli[M, GlueClient, BatchDeleteTableVersionResponse] =
          primitive(_.batchDeleteTableVersion(request))

        def batchGetCrawlers(
          request: BatchGetCrawlersRequest
        ): Kleisli[M, GlueClient, BatchGetCrawlersResponse] =
          primitive(_.batchGetCrawlers(request))

        def batchGetDevEndpoints(
          request: BatchGetDevEndpointsRequest
        ): Kleisli[M, GlueClient, BatchGetDevEndpointsResponse] =
          primitive(_.batchGetDevEndpoints(request))

        def batchGetJobs(
          request: BatchGetJobsRequest
        ): Kleisli[M, GlueClient, BatchGetJobsResponse] =
          primitive(_.batchGetJobs(request))

        def batchGetPartition(
          request: BatchGetPartitionRequest
        ): Kleisli[M, GlueClient, BatchGetPartitionResponse] =
          primitive(_.batchGetPartition(request))

        def batchGetTriggers(
          request: BatchGetTriggersRequest
        ): Kleisli[M, GlueClient, BatchGetTriggersResponse] =
          primitive(_.batchGetTriggers(request))

        def batchGetWorkflows(
          request: BatchGetWorkflowsRequest
        ): Kleisli[M, GlueClient, BatchGetWorkflowsResponse] =
          primitive(_.batchGetWorkflows(request))

        def batchStopJobRun(
          request: BatchStopJobRunRequest
        ): Kleisli[M, GlueClient, BatchStopJobRunResponse] =
          primitive(_.batchStopJobRun(request))

        def batchUpdatePartition(
          request: BatchUpdatePartitionRequest
        ): Kleisli[M, GlueClient, BatchUpdatePartitionResponse] =
          primitive(_.batchUpdatePartition(request))

        def cancelMLTaskRun(
          request: CancelMlTaskRunRequest
        ): Kleisli[M, GlueClient, CancelMlTaskRunResponse] =
          primitive(_.cancelMLTaskRun(request))

        def checkSchemaVersionValidity(
          request: CheckSchemaVersionValidityRequest
        ): Kleisli[M, GlueClient, CheckSchemaVersionValidityResponse] =
          primitive(_.checkSchemaVersionValidity(request))

        def createClassifier(
          request: CreateClassifierRequest
        ): Kleisli[M, GlueClient, CreateClassifierResponse] =
          primitive(_.createClassifier(request))

        def createConnection(
          request: CreateConnectionRequest
        ): Kleisli[M, GlueClient, CreateConnectionResponse] =
          primitive(_.createConnection(request))

        def createCrawler(
          request: CreateCrawlerRequest
        ): Kleisli[M, GlueClient, CreateCrawlerResponse] =
          primitive(_.createCrawler(request))

        def createDatabase(
          request: CreateDatabaseRequest
        ): Kleisli[M, GlueClient, CreateDatabaseResponse] =
          primitive(_.createDatabase(request))

        def createDevEndpoint(
          request: CreateDevEndpointRequest
        ): Kleisli[M, GlueClient, CreateDevEndpointResponse] =
          primitive(_.createDevEndpoint(request))

        def createJob(
          request: CreateJobRequest
        ): Kleisli[M, GlueClient, CreateJobResponse] =
          primitive(_.createJob(request))

        def createMLTransform(
          request: CreateMlTransformRequest
        ): Kleisli[M, GlueClient, CreateMlTransformResponse] =
          primitive(_.createMLTransform(request))

        def createPartition(
          request: CreatePartitionRequest
        ): Kleisli[M, GlueClient, CreatePartitionResponse] =
          primitive(_.createPartition(request))

        def createPartitionIndex(
          request: CreatePartitionIndexRequest
        ): Kleisli[M, GlueClient, CreatePartitionIndexResponse] =
          primitive(_.createPartitionIndex(request))

        def createRegistry(
          request: CreateRegistryRequest
        ): Kleisli[M, GlueClient, CreateRegistryResponse] =
          primitive(_.createRegistry(request))

        def createSchema(
          request: CreateSchemaRequest
        ): Kleisli[M, GlueClient, CreateSchemaResponse] =
          primitive(_.createSchema(request))

        def createScript(
          request: CreateScriptRequest
        ): Kleisli[M, GlueClient, CreateScriptResponse] =
          primitive(_.createScript(request))

        def createSecurityConfiguration(
          request: CreateSecurityConfigurationRequest
        ): Kleisli[M, GlueClient, CreateSecurityConfigurationResponse] =
          primitive(_.createSecurityConfiguration(request))

        def createTable(
          request: CreateTableRequest
        ): Kleisli[M, GlueClient, CreateTableResponse] =
          primitive(_.createTable(request))

        def createTrigger(
          request: CreateTriggerRequest
        ): Kleisli[M, GlueClient, CreateTriggerResponse] =
          primitive(_.createTrigger(request))

        def createUserDefinedFunction(
          request: CreateUserDefinedFunctionRequest
        ): Kleisli[M, GlueClient, CreateUserDefinedFunctionResponse] =
          primitive(_.createUserDefinedFunction(request))

        def createWorkflow(
          request: CreateWorkflowRequest
        ): Kleisli[M, GlueClient, CreateWorkflowResponse] =
          primitive(_.createWorkflow(request))

        def deleteClassifier(
          request: DeleteClassifierRequest
        ): Kleisli[M, GlueClient, DeleteClassifierResponse] =
          primitive(_.deleteClassifier(request))

        def deleteColumnStatisticsForPartition(
          request: DeleteColumnStatisticsForPartitionRequest
        ): Kleisli[M, GlueClient, DeleteColumnStatisticsForPartitionResponse] =
          primitive(_.deleteColumnStatisticsForPartition(request))

        def deleteColumnStatisticsForTable(
          request: DeleteColumnStatisticsForTableRequest
        ): Kleisli[M, GlueClient, DeleteColumnStatisticsForTableResponse] =
          primitive(_.deleteColumnStatisticsForTable(request))

        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, GlueClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def deleteCrawler(
          request: DeleteCrawlerRequest
        ): Kleisli[M, GlueClient, DeleteCrawlerResponse] =
          primitive(_.deleteCrawler(request))

        def deleteDatabase(
          request: DeleteDatabaseRequest
        ): Kleisli[M, GlueClient, DeleteDatabaseResponse] =
          primitive(_.deleteDatabase(request))

        def deleteDevEndpoint(
          request: DeleteDevEndpointRequest
        ): Kleisli[M, GlueClient, DeleteDevEndpointResponse] =
          primitive(_.deleteDevEndpoint(request))

        def deleteJob(
          request: DeleteJobRequest
        ): Kleisli[M, GlueClient, DeleteJobResponse] =
          primitive(_.deleteJob(request))

        def deleteMLTransform(
          request: DeleteMlTransformRequest
        ): Kleisli[M, GlueClient, DeleteMlTransformResponse] =
          primitive(_.deleteMLTransform(request))

        def deletePartition(
          request: DeletePartitionRequest
        ): Kleisli[M, GlueClient, DeletePartitionResponse] =
          primitive(_.deletePartition(request))

        def deletePartitionIndex(
          request: DeletePartitionIndexRequest
        ): Kleisli[M, GlueClient, DeletePartitionIndexResponse] =
          primitive(_.deletePartitionIndex(request))

        def deleteRegistry(
          request: DeleteRegistryRequest
        ): Kleisli[M, GlueClient, DeleteRegistryResponse] =
          primitive(_.deleteRegistry(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, GlueClient, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteSchema(
          request: DeleteSchemaRequest
        ): Kleisli[M, GlueClient, DeleteSchemaResponse] =
          primitive(_.deleteSchema(request))

        def deleteSchemaVersions(
          request: DeleteSchemaVersionsRequest
        ): Kleisli[M, GlueClient, DeleteSchemaVersionsResponse] =
          primitive(_.deleteSchemaVersions(request))

        def deleteSecurityConfiguration(
          request: DeleteSecurityConfigurationRequest
        ): Kleisli[M, GlueClient, DeleteSecurityConfigurationResponse] =
          primitive(_.deleteSecurityConfiguration(request))

        def deleteTable(
          request: DeleteTableRequest
        ): Kleisli[M, GlueClient, DeleteTableResponse] =
          primitive(_.deleteTable(request))

        def deleteTableVersion(
          request: DeleteTableVersionRequest
        ): Kleisli[M, GlueClient, DeleteTableVersionResponse] =
          primitive(_.deleteTableVersion(request))

        def deleteTrigger(
          request: DeleteTriggerRequest
        ): Kleisli[M, GlueClient, DeleteTriggerResponse] =
          primitive(_.deleteTrigger(request))

        def deleteUserDefinedFunction(
          request: DeleteUserDefinedFunctionRequest
        ): Kleisli[M, GlueClient, DeleteUserDefinedFunctionResponse] =
          primitive(_.deleteUserDefinedFunction(request))

        def deleteWorkflow(
          request: DeleteWorkflowRequest
        ): Kleisli[M, GlueClient, DeleteWorkflowResponse] =
          primitive(_.deleteWorkflow(request))

        def getCatalogImportStatus(
          request: GetCatalogImportStatusRequest
        ): Kleisli[M, GlueClient, GetCatalogImportStatusResponse] =
          primitive(_.getCatalogImportStatus(request))

        def getClassifier(
          request: GetClassifierRequest
        ): Kleisli[M, GlueClient, GetClassifierResponse] =
          primitive(_.getClassifier(request))

        def getClassifiers(
          request: GetClassifiersRequest
        ): Kleisli[M, GlueClient, GetClassifiersResponse] =
          primitive(_.getClassifiers(request))

        def getColumnStatisticsForPartition(
          request: GetColumnStatisticsForPartitionRequest
        ): Kleisli[M, GlueClient, GetColumnStatisticsForPartitionResponse] =
          primitive(_.getColumnStatisticsForPartition(request))

        def getColumnStatisticsForTable(
          request: GetColumnStatisticsForTableRequest
        ): Kleisli[M, GlueClient, GetColumnStatisticsForTableResponse] =
          primitive(_.getColumnStatisticsForTable(request))

        def getConnection(
          request: GetConnectionRequest
        ): Kleisli[M, GlueClient, GetConnectionResponse] =
          primitive(_.getConnection(request))

        def getConnections(
          request: GetConnectionsRequest
        ): Kleisli[M, GlueClient, GetConnectionsResponse] =
          primitive(_.getConnections(request))

        def getCrawler(
          request: GetCrawlerRequest
        ): Kleisli[M, GlueClient, GetCrawlerResponse] =
          primitive(_.getCrawler(request))

        def getCrawlerMetrics(
          request: GetCrawlerMetricsRequest
        ): Kleisli[M, GlueClient, GetCrawlerMetricsResponse] =
          primitive(_.getCrawlerMetrics(request))

        def getCrawlers(
          request: GetCrawlersRequest
        ): Kleisli[M, GlueClient, GetCrawlersResponse] =
          primitive(_.getCrawlers(request))

        def getDataCatalogEncryptionSettings(
          request: GetDataCatalogEncryptionSettingsRequest
        ): Kleisli[M, GlueClient, GetDataCatalogEncryptionSettingsResponse] =
          primitive(_.getDataCatalogEncryptionSettings(request))

        def getDatabase(
          request: GetDatabaseRequest
        ): Kleisli[M, GlueClient, GetDatabaseResponse] =
          primitive(_.getDatabase(request))

        def getDatabases(
          request: GetDatabasesRequest
        ): Kleisli[M, GlueClient, GetDatabasesResponse] =
          primitive(_.getDatabases(request))

        def getDataflowGraph(
          request: GetDataflowGraphRequest
        ): Kleisli[M, GlueClient, GetDataflowGraphResponse] =
          primitive(_.getDataflowGraph(request))

        def getDevEndpoint(
          request: GetDevEndpointRequest
        ): Kleisli[M, GlueClient, GetDevEndpointResponse] =
          primitive(_.getDevEndpoint(request))

        def getDevEndpoints(
          request: GetDevEndpointsRequest
        ): Kleisli[M, GlueClient, GetDevEndpointsResponse] =
          primitive(_.getDevEndpoints(request))

        def getJob(
          request: GetJobRequest
        ): Kleisli[M, GlueClient, GetJobResponse] =
          primitive(_.getJob(request))

        def getJobBookmark(
          request: GetJobBookmarkRequest
        ): Kleisli[M, GlueClient, GetJobBookmarkResponse] =
          primitive(_.getJobBookmark(request))

        def getJobRun(
          request: GetJobRunRequest
        ): Kleisli[M, GlueClient, GetJobRunResponse] =
          primitive(_.getJobRun(request))

        def getJobRuns(
          request: GetJobRunsRequest
        ): Kleisli[M, GlueClient, GetJobRunsResponse] =
          primitive(_.getJobRuns(request))

        def getJobs(
          request: GetJobsRequest
        ): Kleisli[M, GlueClient, GetJobsResponse] =
          primitive(_.getJobs(request))

        def getMLTaskRun(
          request: GetMlTaskRunRequest
        ): Kleisli[M, GlueClient, GetMlTaskRunResponse] =
          primitive(_.getMLTaskRun(request))

        def getMLTaskRuns(
          request: GetMlTaskRunsRequest
        ): Kleisli[M, GlueClient, GetMlTaskRunsResponse] =
          primitive(_.getMLTaskRuns(request))

        def getMLTransform(
          request: GetMlTransformRequest
        ): Kleisli[M, GlueClient, GetMlTransformResponse] =
          primitive(_.getMLTransform(request))

        def getMLTransforms(
          request: GetMlTransformsRequest
        ): Kleisli[M, GlueClient, GetMlTransformsResponse] =
          primitive(_.getMLTransforms(request))

        def getMapping(
          request: GetMappingRequest
        ): Kleisli[M, GlueClient, GetMappingResponse] =
          primitive(_.getMapping(request))

        def getPartition(
          request: GetPartitionRequest
        ): Kleisli[M, GlueClient, GetPartitionResponse] =
          primitive(_.getPartition(request))

        def getPartitionIndexes(
          request: GetPartitionIndexesRequest
        ): Kleisli[M, GlueClient, GetPartitionIndexesResponse] =
          primitive(_.getPartitionIndexes(request))

        def getPartitions(
          request: GetPartitionsRequest
        ): Kleisli[M, GlueClient, GetPartitionsResponse] =
          primitive(_.getPartitions(request))

        def getPlan(
          request: GetPlanRequest
        ): Kleisli[M, GlueClient, GetPlanResponse] =
          primitive(_.getPlan(request))

        def getRegistry(
          request: GetRegistryRequest
        ): Kleisli[M, GlueClient, GetRegistryResponse] =
          primitive(_.getRegistry(request))

        def getResourcePolicies(
          request: GetResourcePoliciesRequest
        ): Kleisli[M, GlueClient, GetResourcePoliciesResponse] =
          primitive(_.getResourcePolicies(request))

        def getResourcePolicy(
          request: GetResourcePolicyRequest
        ): Kleisli[M, GlueClient, GetResourcePolicyResponse] =
          primitive(_.getResourcePolicy(request))

        def getSchema(
          request: GetSchemaRequest
        ): Kleisli[M, GlueClient, GetSchemaResponse] =
          primitive(_.getSchema(request))

        def getSchemaByDefinition(
          request: GetSchemaByDefinitionRequest
        ): Kleisli[M, GlueClient, GetSchemaByDefinitionResponse] =
          primitive(_.getSchemaByDefinition(request))

        def getSchemaVersion(
          request: GetSchemaVersionRequest
        ): Kleisli[M, GlueClient, GetSchemaVersionResponse] =
          primitive(_.getSchemaVersion(request))

        def getSchemaVersionsDiff(
          request: GetSchemaVersionsDiffRequest
        ): Kleisli[M, GlueClient, GetSchemaVersionsDiffResponse] =
          primitive(_.getSchemaVersionsDiff(request))

        def getSecurityConfiguration(
          request: GetSecurityConfigurationRequest
        ): Kleisli[M, GlueClient, GetSecurityConfigurationResponse] =
          primitive(_.getSecurityConfiguration(request))

        def getSecurityConfigurations(
          request: GetSecurityConfigurationsRequest
        ): Kleisli[M, GlueClient, GetSecurityConfigurationsResponse] =
          primitive(_.getSecurityConfigurations(request))

        def getTable(
          request: GetTableRequest
        ): Kleisli[M, GlueClient, GetTableResponse] =
          primitive(_.getTable(request))

        def getTableVersion(
          request: GetTableVersionRequest
        ): Kleisli[M, GlueClient, GetTableVersionResponse] =
          primitive(_.getTableVersion(request))

        def getTableVersions(
          request: GetTableVersionsRequest
        ): Kleisli[M, GlueClient, GetTableVersionsResponse] =
          primitive(_.getTableVersions(request))

        def getTables(
          request: GetTablesRequest
        ): Kleisli[M, GlueClient, GetTablesResponse] =
          primitive(_.getTables(request))

        def getTags(
          request: GetTagsRequest
        ): Kleisli[M, GlueClient, GetTagsResponse] =
          primitive(_.getTags(request))

        def getTrigger(
          request: GetTriggerRequest
        ): Kleisli[M, GlueClient, GetTriggerResponse] =
          primitive(_.getTrigger(request))

        def getTriggers(
          request: GetTriggersRequest
        ): Kleisli[M, GlueClient, GetTriggersResponse] =
          primitive(_.getTriggers(request))

        def getUserDefinedFunction(
          request: GetUserDefinedFunctionRequest
        ): Kleisli[M, GlueClient, GetUserDefinedFunctionResponse] =
          primitive(_.getUserDefinedFunction(request))

        def getUserDefinedFunctions(
          request: GetUserDefinedFunctionsRequest
        ): Kleisli[M, GlueClient, GetUserDefinedFunctionsResponse] =
          primitive(_.getUserDefinedFunctions(request))

        def getWorkflow(
          request: GetWorkflowRequest
        ): Kleisli[M, GlueClient, GetWorkflowResponse] =
          primitive(_.getWorkflow(request))

        def getWorkflowRun(
          request: GetWorkflowRunRequest
        ): Kleisli[M, GlueClient, GetWorkflowRunResponse] =
          primitive(_.getWorkflowRun(request))

        def getWorkflowRunProperties(
          request: GetWorkflowRunPropertiesRequest
        ): Kleisli[M, GlueClient, GetWorkflowRunPropertiesResponse] =
          primitive(_.getWorkflowRunProperties(request))

        def getWorkflowRuns(
          request: GetWorkflowRunsRequest
        ): Kleisli[M, GlueClient, GetWorkflowRunsResponse] =
          primitive(_.getWorkflowRuns(request))

        def importCatalogToGlue(
          request: ImportCatalogToGlueRequest
        ): Kleisli[M, GlueClient, ImportCatalogToGlueResponse] =
          primitive(_.importCatalogToGlue(request))

        def listCrawlers(
          request: ListCrawlersRequest
        ): Kleisli[M, GlueClient, ListCrawlersResponse] =
          primitive(_.listCrawlers(request))

        def listDevEndpoints(
          request: ListDevEndpointsRequest
        ): Kleisli[M, GlueClient, ListDevEndpointsResponse] =
          primitive(_.listDevEndpoints(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, GlueClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listMLTransforms(
          request: ListMlTransformsRequest
        ): Kleisli[M, GlueClient, ListMlTransformsResponse] =
          primitive(_.listMLTransforms(request))

        def listRegistries(
          request: ListRegistriesRequest
        ): Kleisli[M, GlueClient, ListRegistriesResponse] =
          primitive(_.listRegistries(request))

        def listSchemaVersions(
          request: ListSchemaVersionsRequest
        ): Kleisli[M, GlueClient, ListSchemaVersionsResponse] =
          primitive(_.listSchemaVersions(request))

        def listSchemas(
          request: ListSchemasRequest
        ): Kleisli[M, GlueClient, ListSchemasResponse] =
          primitive(_.listSchemas(request))

        def listTriggers(
          request: ListTriggersRequest
        ): Kleisli[M, GlueClient, ListTriggersResponse] =
          primitive(_.listTriggers(request))

        def listWorkflows(
          request: ListWorkflowsRequest
        ): Kleisli[M, GlueClient, ListWorkflowsResponse] =
          primitive(_.listWorkflows(request))

        def putDataCatalogEncryptionSettings(
          request: PutDataCatalogEncryptionSettingsRequest
        ): Kleisli[M, GlueClient, PutDataCatalogEncryptionSettingsResponse] =
          primitive(_.putDataCatalogEncryptionSettings(request))

        def putResourcePolicy(
          request: PutResourcePolicyRequest
        ): Kleisli[M, GlueClient, PutResourcePolicyResponse] =
          primitive(_.putResourcePolicy(request))

        def putSchemaVersionMetadata(
          request: PutSchemaVersionMetadataRequest
        ): Kleisli[M, GlueClient, PutSchemaVersionMetadataResponse] =
          primitive(_.putSchemaVersionMetadata(request))

        def putWorkflowRunProperties(
          request: PutWorkflowRunPropertiesRequest
        ): Kleisli[M, GlueClient, PutWorkflowRunPropertiesResponse] =
          primitive(_.putWorkflowRunProperties(request))

        def querySchemaVersionMetadata(
          request: QuerySchemaVersionMetadataRequest
        ): Kleisli[M, GlueClient, QuerySchemaVersionMetadataResponse] =
          primitive(_.querySchemaVersionMetadata(request))

        def registerSchemaVersion(
          request: RegisterSchemaVersionRequest
        ): Kleisli[M, GlueClient, RegisterSchemaVersionResponse] =
          primitive(_.registerSchemaVersion(request))

        def removeSchemaVersionMetadata(
          request: RemoveSchemaVersionMetadataRequest
        ): Kleisli[M, GlueClient, RemoveSchemaVersionMetadataResponse] =
          primitive(_.removeSchemaVersionMetadata(request))

        def resetJobBookmark(
          request: ResetJobBookmarkRequest
        ): Kleisli[M, GlueClient, ResetJobBookmarkResponse] =
          primitive(_.resetJobBookmark(request))

        def resumeWorkflowRun(
          request: ResumeWorkflowRunRequest
        ): Kleisli[M, GlueClient, ResumeWorkflowRunResponse] =
          primitive(_.resumeWorkflowRun(request))

        def searchTables(
          request: SearchTablesRequest
        ): Kleisli[M, GlueClient, SearchTablesResponse] =
          primitive(_.searchTables(request))

        def startCrawler(
          request: StartCrawlerRequest
        ): Kleisli[M, GlueClient, StartCrawlerResponse] =
          primitive(_.startCrawler(request))

        def startCrawlerSchedule(
          request: StartCrawlerScheduleRequest
        ): Kleisli[M, GlueClient, StartCrawlerScheduleResponse] =
          primitive(_.startCrawlerSchedule(request))

        def startExportLabelsTaskRun(
          request: StartExportLabelsTaskRunRequest
        ): Kleisli[M, GlueClient, StartExportLabelsTaskRunResponse] =
          primitive(_.startExportLabelsTaskRun(request))

        def startImportLabelsTaskRun(
          request: StartImportLabelsTaskRunRequest
        ): Kleisli[M, GlueClient, StartImportLabelsTaskRunResponse] =
          primitive(_.startImportLabelsTaskRun(request))

        def startJobRun(
          request: StartJobRunRequest
        ): Kleisli[M, GlueClient, StartJobRunResponse] =
          primitive(_.startJobRun(request))

        def startMLEvaluationTaskRun(
          request: StartMlEvaluationTaskRunRequest
        ): Kleisli[M, GlueClient, StartMlEvaluationTaskRunResponse] =
          primitive(_.startMLEvaluationTaskRun(request))

        def startMLLabelingSetGenerationTaskRun(
          request: StartMlLabelingSetGenerationTaskRunRequest
        ): Kleisli[M, GlueClient, StartMlLabelingSetGenerationTaskRunResponse] =
          primitive(_.startMLLabelingSetGenerationTaskRun(request))

        def startTrigger(
          request: StartTriggerRequest
        ): Kleisli[M, GlueClient, StartTriggerResponse] =
          primitive(_.startTrigger(request))

        def startWorkflowRun(
          request: StartWorkflowRunRequest
        ): Kleisli[M, GlueClient, StartWorkflowRunResponse] =
          primitive(_.startWorkflowRun(request))

        def stopCrawler(
          request: StopCrawlerRequest
        ): Kleisli[M, GlueClient, StopCrawlerResponse] =
          primitive(_.stopCrawler(request))

        def stopCrawlerSchedule(
          request: StopCrawlerScheduleRequest
        ): Kleisli[M, GlueClient, StopCrawlerScheduleResponse] =
          primitive(_.stopCrawlerSchedule(request))

        def stopTrigger(
          request: StopTriggerRequest
        ): Kleisli[M, GlueClient, StopTriggerResponse] =
          primitive(_.stopTrigger(request))

        def stopWorkflowRun(
          request: StopWorkflowRunRequest
        ): Kleisli[M, GlueClient, StopWorkflowRunResponse] =
          primitive(_.stopWorkflowRun(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, GlueClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, GlueClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateClassifier(
          request: UpdateClassifierRequest
        ): Kleisli[M, GlueClient, UpdateClassifierResponse] =
          primitive(_.updateClassifier(request))

        def updateColumnStatisticsForPartition(
          request: UpdateColumnStatisticsForPartitionRequest
        ): Kleisli[M, GlueClient, UpdateColumnStatisticsForPartitionResponse] =
          primitive(_.updateColumnStatisticsForPartition(request))

        def updateColumnStatisticsForTable(
          request: UpdateColumnStatisticsForTableRequest
        ): Kleisli[M, GlueClient, UpdateColumnStatisticsForTableResponse] =
          primitive(_.updateColumnStatisticsForTable(request))

        def updateConnection(
          request: UpdateConnectionRequest
        ): Kleisli[M, GlueClient, UpdateConnectionResponse] =
          primitive(_.updateConnection(request))

        def updateCrawler(
          request: UpdateCrawlerRequest
        ): Kleisli[M, GlueClient, UpdateCrawlerResponse] =
          primitive(_.updateCrawler(request))

        def updateCrawlerSchedule(
          request: UpdateCrawlerScheduleRequest
        ): Kleisli[M, GlueClient, UpdateCrawlerScheduleResponse] =
          primitive(_.updateCrawlerSchedule(request))

        def updateDatabase(
          request: UpdateDatabaseRequest
        ): Kleisli[M, GlueClient, UpdateDatabaseResponse] =
          primitive(_.updateDatabase(request))

        def updateDevEndpoint(
          request: UpdateDevEndpointRequest
        ): Kleisli[M, GlueClient, UpdateDevEndpointResponse] =
          primitive(_.updateDevEndpoint(request))

        def updateJob(
          request: UpdateJobRequest
        ): Kleisli[M, GlueClient, UpdateJobResponse] =
          primitive(_.updateJob(request))

        def updateMLTransform(
          request: UpdateMlTransformRequest
        ): Kleisli[M, GlueClient, UpdateMlTransformResponse] =
          primitive(_.updateMLTransform(request))

        def updatePartition(
          request: UpdatePartitionRequest
        ): Kleisli[M, GlueClient, UpdatePartitionResponse] =
          primitive(_.updatePartition(request))

        def updateRegistry(
          request: UpdateRegistryRequest
        ): Kleisli[M, GlueClient, UpdateRegistryResponse] =
          primitive(_.updateRegistry(request))

        def updateSchema(
          request: UpdateSchemaRequest
        ): Kleisli[M, GlueClient, UpdateSchemaResponse] =
          primitive(_.updateSchema(request))

        def updateTable(
          request: UpdateTableRequest
        ): Kleisli[M, GlueClient, UpdateTableResponse] =
          primitive(_.updateTable(request))

        def updateTrigger(
          request: UpdateTriggerRequest
        ): Kleisli[M, GlueClient, UpdateTriggerResponse] =
          primitive(_.updateTrigger(request))

        def updateUserDefinedFunction(
          request: UpdateUserDefinedFunctionRequest
        ): Kleisli[M, GlueClient, UpdateUserDefinedFunctionResponse] =
          primitive(_.updateUserDefinedFunction(request))

        def updateWorkflow(
          request: UpdateWorkflowRequest
        ): Kleisli[M, GlueClient, UpdateWorkflowResponse] =
          primitive(_.updateWorkflow(request))

        def primitive[A](
          f: GlueClient => A
        ): Kleisli[M, GlueClient, A]
      }
    }

    trait Visitor[F[_]] extends (GlueOp ~> F) {
      final def apply[A](op: GlueOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchCreatePartition(
        request: BatchCreatePartitionRequest
      ): F[BatchCreatePartitionResponse]

      def batchDeleteConnection(
        request: BatchDeleteConnectionRequest
      ): F[BatchDeleteConnectionResponse]

      def batchDeletePartition(
        request: BatchDeletePartitionRequest
      ): F[BatchDeletePartitionResponse]

      def batchDeleteTable(
        request: BatchDeleteTableRequest
      ): F[BatchDeleteTableResponse]

      def batchDeleteTableVersion(
        request: BatchDeleteTableVersionRequest
      ): F[BatchDeleteTableVersionResponse]

      def batchGetCrawlers(
        request: BatchGetCrawlersRequest
      ): F[BatchGetCrawlersResponse]

      def batchGetDevEndpoints(
        request: BatchGetDevEndpointsRequest
      ): F[BatchGetDevEndpointsResponse]

      def batchGetJobs(
        request: BatchGetJobsRequest
      ): F[BatchGetJobsResponse]

      def batchGetPartition(
        request: BatchGetPartitionRequest
      ): F[BatchGetPartitionResponse]

      def batchGetTriggers(
        request: BatchGetTriggersRequest
      ): F[BatchGetTriggersResponse]

      def batchGetWorkflows(
        request: BatchGetWorkflowsRequest
      ): F[BatchGetWorkflowsResponse]

      def batchStopJobRun(
        request: BatchStopJobRunRequest
      ): F[BatchStopJobRunResponse]

      def batchUpdatePartition(
        request: BatchUpdatePartitionRequest
      ): F[BatchUpdatePartitionResponse]

      def cancelMLTaskRun(
        request: CancelMlTaskRunRequest
      ): F[CancelMlTaskRunResponse]

      def checkSchemaVersionValidity(
        request: CheckSchemaVersionValidityRequest
      ): F[CheckSchemaVersionValidityResponse]

      def createClassifier(
        request: CreateClassifierRequest
      ): F[CreateClassifierResponse]

      def createConnection(
        request: CreateConnectionRequest
      ): F[CreateConnectionResponse]

      def createCrawler(
        request: CreateCrawlerRequest
      ): F[CreateCrawlerResponse]

      def createDatabase(
        request: CreateDatabaseRequest
      ): F[CreateDatabaseResponse]

      def createDevEndpoint(
        request: CreateDevEndpointRequest
      ): F[CreateDevEndpointResponse]

      def createJob(
        request: CreateJobRequest
      ): F[CreateJobResponse]

      def createMLTransform(
        request: CreateMlTransformRequest
      ): F[CreateMlTransformResponse]

      def createPartition(
        request: CreatePartitionRequest
      ): F[CreatePartitionResponse]

      def createPartitionIndex(
        request: CreatePartitionIndexRequest
      ): F[CreatePartitionIndexResponse]

      def createRegistry(
        request: CreateRegistryRequest
      ): F[CreateRegistryResponse]

      def createSchema(
        request: CreateSchemaRequest
      ): F[CreateSchemaResponse]

      def createScript(
        request: CreateScriptRequest
      ): F[CreateScriptResponse]

      def createSecurityConfiguration(
        request: CreateSecurityConfigurationRequest
      ): F[CreateSecurityConfigurationResponse]

      def createTable(
        request: CreateTableRequest
      ): F[CreateTableResponse]

      def createTrigger(
        request: CreateTriggerRequest
      ): F[CreateTriggerResponse]

      def createUserDefinedFunction(
        request: CreateUserDefinedFunctionRequest
      ): F[CreateUserDefinedFunctionResponse]

      def createWorkflow(
        request: CreateWorkflowRequest
      ): F[CreateWorkflowResponse]

      def deleteClassifier(
        request: DeleteClassifierRequest
      ): F[DeleteClassifierResponse]

      def deleteColumnStatisticsForPartition(
        request: DeleteColumnStatisticsForPartitionRequest
      ): F[DeleteColumnStatisticsForPartitionResponse]

      def deleteColumnStatisticsForTable(
        request: DeleteColumnStatisticsForTableRequest
      ): F[DeleteColumnStatisticsForTableResponse]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def deleteCrawler(
        request: DeleteCrawlerRequest
      ): F[DeleteCrawlerResponse]

      def deleteDatabase(
        request: DeleteDatabaseRequest
      ): F[DeleteDatabaseResponse]

      def deleteDevEndpoint(
        request: DeleteDevEndpointRequest
      ): F[DeleteDevEndpointResponse]

      def deleteJob(
        request: DeleteJobRequest
      ): F[DeleteJobResponse]

      def deleteMLTransform(
        request: DeleteMlTransformRequest
      ): F[DeleteMlTransformResponse]

      def deletePartition(
        request: DeletePartitionRequest
      ): F[DeletePartitionResponse]

      def deletePartitionIndex(
        request: DeletePartitionIndexRequest
      ): F[DeletePartitionIndexResponse]

      def deleteRegistry(
        request: DeleteRegistryRequest
      ): F[DeleteRegistryResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteSchema(
        request: DeleteSchemaRequest
      ): F[DeleteSchemaResponse]

      def deleteSchemaVersions(
        request: DeleteSchemaVersionsRequest
      ): F[DeleteSchemaVersionsResponse]

      def deleteSecurityConfiguration(
        request: DeleteSecurityConfigurationRequest
      ): F[DeleteSecurityConfigurationResponse]

      def deleteTable(
        request: DeleteTableRequest
      ): F[DeleteTableResponse]

      def deleteTableVersion(
        request: DeleteTableVersionRequest
      ): F[DeleteTableVersionResponse]

      def deleteTrigger(
        request: DeleteTriggerRequest
      ): F[DeleteTriggerResponse]

      def deleteUserDefinedFunction(
        request: DeleteUserDefinedFunctionRequest
      ): F[DeleteUserDefinedFunctionResponse]

      def deleteWorkflow(
        request: DeleteWorkflowRequest
      ): F[DeleteWorkflowResponse]

      def getCatalogImportStatus(
        request: GetCatalogImportStatusRequest
      ): F[GetCatalogImportStatusResponse]

      def getClassifier(
        request: GetClassifierRequest
      ): F[GetClassifierResponse]

      def getClassifiers(
        request: GetClassifiersRequest
      ): F[GetClassifiersResponse]

      def getColumnStatisticsForPartition(
        request: GetColumnStatisticsForPartitionRequest
      ): F[GetColumnStatisticsForPartitionResponse]

      def getColumnStatisticsForTable(
        request: GetColumnStatisticsForTableRequest
      ): F[GetColumnStatisticsForTableResponse]

      def getConnection(
        request: GetConnectionRequest
      ): F[GetConnectionResponse]

      def getConnections(
        request: GetConnectionsRequest
      ): F[GetConnectionsResponse]

      def getCrawler(
        request: GetCrawlerRequest
      ): F[GetCrawlerResponse]

      def getCrawlerMetrics(
        request: GetCrawlerMetricsRequest
      ): F[GetCrawlerMetricsResponse]

      def getCrawlers(
        request: GetCrawlersRequest
      ): F[GetCrawlersResponse]

      def getDataCatalogEncryptionSettings(
        request: GetDataCatalogEncryptionSettingsRequest
      ): F[GetDataCatalogEncryptionSettingsResponse]

      def getDatabase(
        request: GetDatabaseRequest
      ): F[GetDatabaseResponse]

      def getDatabases(
        request: GetDatabasesRequest
      ): F[GetDatabasesResponse]

      def getDataflowGraph(
        request: GetDataflowGraphRequest
      ): F[GetDataflowGraphResponse]

      def getDevEndpoint(
        request: GetDevEndpointRequest
      ): F[GetDevEndpointResponse]

      def getDevEndpoints(
        request: GetDevEndpointsRequest
      ): F[GetDevEndpointsResponse]

      def getJob(
        request: GetJobRequest
      ): F[GetJobResponse]

      def getJobBookmark(
        request: GetJobBookmarkRequest
      ): F[GetJobBookmarkResponse]

      def getJobRun(
        request: GetJobRunRequest
      ): F[GetJobRunResponse]

      def getJobRuns(
        request: GetJobRunsRequest
      ): F[GetJobRunsResponse]

      def getJobs(
        request: GetJobsRequest
      ): F[GetJobsResponse]

      def getMLTaskRun(
        request: GetMlTaskRunRequest
      ): F[GetMlTaskRunResponse]

      def getMLTaskRuns(
        request: GetMlTaskRunsRequest
      ): F[GetMlTaskRunsResponse]

      def getMLTransform(
        request: GetMlTransformRequest
      ): F[GetMlTransformResponse]

      def getMLTransforms(
        request: GetMlTransformsRequest
      ): F[GetMlTransformsResponse]

      def getMapping(
        request: GetMappingRequest
      ): F[GetMappingResponse]

      def getPartition(
        request: GetPartitionRequest
      ): F[GetPartitionResponse]

      def getPartitionIndexes(
        request: GetPartitionIndexesRequest
      ): F[GetPartitionIndexesResponse]

      def getPartitions(
        request: GetPartitionsRequest
      ): F[GetPartitionsResponse]

      def getPlan(
        request: GetPlanRequest
      ): F[GetPlanResponse]

      def getRegistry(
        request: GetRegistryRequest
      ): F[GetRegistryResponse]

      def getResourcePolicies(
        request: GetResourcePoliciesRequest
      ): F[GetResourcePoliciesResponse]

      def getResourcePolicy(
        request: GetResourcePolicyRequest
      ): F[GetResourcePolicyResponse]

      def getSchema(
        request: GetSchemaRequest
      ): F[GetSchemaResponse]

      def getSchemaByDefinition(
        request: GetSchemaByDefinitionRequest
      ): F[GetSchemaByDefinitionResponse]

      def getSchemaVersion(
        request: GetSchemaVersionRequest
      ): F[GetSchemaVersionResponse]

      def getSchemaVersionsDiff(
        request: GetSchemaVersionsDiffRequest
      ): F[GetSchemaVersionsDiffResponse]

      def getSecurityConfiguration(
        request: GetSecurityConfigurationRequest
      ): F[GetSecurityConfigurationResponse]

      def getSecurityConfigurations(
        request: GetSecurityConfigurationsRequest
      ): F[GetSecurityConfigurationsResponse]

      def getTable(
        request: GetTableRequest
      ): F[GetTableResponse]

      def getTableVersion(
        request: GetTableVersionRequest
      ): F[GetTableVersionResponse]

      def getTableVersions(
        request: GetTableVersionsRequest
      ): F[GetTableVersionsResponse]

      def getTables(
        request: GetTablesRequest
      ): F[GetTablesResponse]

      def getTags(
        request: GetTagsRequest
      ): F[GetTagsResponse]

      def getTrigger(
        request: GetTriggerRequest
      ): F[GetTriggerResponse]

      def getTriggers(
        request: GetTriggersRequest
      ): F[GetTriggersResponse]

      def getUserDefinedFunction(
        request: GetUserDefinedFunctionRequest
      ): F[GetUserDefinedFunctionResponse]

      def getUserDefinedFunctions(
        request: GetUserDefinedFunctionsRequest
      ): F[GetUserDefinedFunctionsResponse]

      def getWorkflow(
        request: GetWorkflowRequest
      ): F[GetWorkflowResponse]

      def getWorkflowRun(
        request: GetWorkflowRunRequest
      ): F[GetWorkflowRunResponse]

      def getWorkflowRunProperties(
        request: GetWorkflowRunPropertiesRequest
      ): F[GetWorkflowRunPropertiesResponse]

      def getWorkflowRuns(
        request: GetWorkflowRunsRequest
      ): F[GetWorkflowRunsResponse]

      def importCatalogToGlue(
        request: ImportCatalogToGlueRequest
      ): F[ImportCatalogToGlueResponse]

      def listCrawlers(
        request: ListCrawlersRequest
      ): F[ListCrawlersResponse]

      def listDevEndpoints(
        request: ListDevEndpointsRequest
      ): F[ListDevEndpointsResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listMLTransforms(
        request: ListMlTransformsRequest
      ): F[ListMlTransformsResponse]

      def listRegistries(
        request: ListRegistriesRequest
      ): F[ListRegistriesResponse]

      def listSchemaVersions(
        request: ListSchemaVersionsRequest
      ): F[ListSchemaVersionsResponse]

      def listSchemas(
        request: ListSchemasRequest
      ): F[ListSchemasResponse]

      def listTriggers(
        request: ListTriggersRequest
      ): F[ListTriggersResponse]

      def listWorkflows(
        request: ListWorkflowsRequest
      ): F[ListWorkflowsResponse]

      def putDataCatalogEncryptionSettings(
        request: PutDataCatalogEncryptionSettingsRequest
      ): F[PutDataCatalogEncryptionSettingsResponse]

      def putResourcePolicy(
        request: PutResourcePolicyRequest
      ): F[PutResourcePolicyResponse]

      def putSchemaVersionMetadata(
        request: PutSchemaVersionMetadataRequest
      ): F[PutSchemaVersionMetadataResponse]

      def putWorkflowRunProperties(
        request: PutWorkflowRunPropertiesRequest
      ): F[PutWorkflowRunPropertiesResponse]

      def querySchemaVersionMetadata(
        request: QuerySchemaVersionMetadataRequest
      ): F[QuerySchemaVersionMetadataResponse]

      def registerSchemaVersion(
        request: RegisterSchemaVersionRequest
      ): F[RegisterSchemaVersionResponse]

      def removeSchemaVersionMetadata(
        request: RemoveSchemaVersionMetadataRequest
      ): F[RemoveSchemaVersionMetadataResponse]

      def resetJobBookmark(
        request: ResetJobBookmarkRequest
      ): F[ResetJobBookmarkResponse]

      def resumeWorkflowRun(
        request: ResumeWorkflowRunRequest
      ): F[ResumeWorkflowRunResponse]

      def searchTables(
        request: SearchTablesRequest
      ): F[SearchTablesResponse]

      def startCrawler(
        request: StartCrawlerRequest
      ): F[StartCrawlerResponse]

      def startCrawlerSchedule(
        request: StartCrawlerScheduleRequest
      ): F[StartCrawlerScheduleResponse]

      def startExportLabelsTaskRun(
        request: StartExportLabelsTaskRunRequest
      ): F[StartExportLabelsTaskRunResponse]

      def startImportLabelsTaskRun(
        request: StartImportLabelsTaskRunRequest
      ): F[StartImportLabelsTaskRunResponse]

      def startJobRun(
        request: StartJobRunRequest
      ): F[StartJobRunResponse]

      def startMLEvaluationTaskRun(
        request: StartMlEvaluationTaskRunRequest
      ): F[StartMlEvaluationTaskRunResponse]

      def startMLLabelingSetGenerationTaskRun(
        request: StartMlLabelingSetGenerationTaskRunRequest
      ): F[StartMlLabelingSetGenerationTaskRunResponse]

      def startTrigger(
        request: StartTriggerRequest
      ): F[StartTriggerResponse]

      def startWorkflowRun(
        request: StartWorkflowRunRequest
      ): F[StartWorkflowRunResponse]

      def stopCrawler(
        request: StopCrawlerRequest
      ): F[StopCrawlerResponse]

      def stopCrawlerSchedule(
        request: StopCrawlerScheduleRequest
      ): F[StopCrawlerScheduleResponse]

      def stopTrigger(
        request: StopTriggerRequest
      ): F[StopTriggerResponse]

      def stopWorkflowRun(
        request: StopWorkflowRunRequest
      ): F[StopWorkflowRunResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateClassifier(
        request: UpdateClassifierRequest
      ): F[UpdateClassifierResponse]

      def updateColumnStatisticsForPartition(
        request: UpdateColumnStatisticsForPartitionRequest
      ): F[UpdateColumnStatisticsForPartitionResponse]

      def updateColumnStatisticsForTable(
        request: UpdateColumnStatisticsForTableRequest
      ): F[UpdateColumnStatisticsForTableResponse]

      def updateConnection(
        request: UpdateConnectionRequest
      ): F[UpdateConnectionResponse]

      def updateCrawler(
        request: UpdateCrawlerRequest
      ): F[UpdateCrawlerResponse]

      def updateCrawlerSchedule(
        request: UpdateCrawlerScheduleRequest
      ): F[UpdateCrawlerScheduleResponse]

      def updateDatabase(
        request: UpdateDatabaseRequest
      ): F[UpdateDatabaseResponse]

      def updateDevEndpoint(
        request: UpdateDevEndpointRequest
      ): F[UpdateDevEndpointResponse]

      def updateJob(
        request: UpdateJobRequest
      ): F[UpdateJobResponse]

      def updateMLTransform(
        request: UpdateMlTransformRequest
      ): F[UpdateMlTransformResponse]

      def updatePartition(
        request: UpdatePartitionRequest
      ): F[UpdatePartitionResponse]

      def updateRegistry(
        request: UpdateRegistryRequest
      ): F[UpdateRegistryResponse]

      def updateSchema(
        request: UpdateSchemaRequest
      ): F[UpdateSchemaResponse]

      def updateTable(
        request: UpdateTableRequest
      ): F[UpdateTableResponse]

      def updateTrigger(
        request: UpdateTriggerRequest
      ): F[UpdateTriggerResponse]

      def updateUserDefinedFunction(
        request: UpdateUserDefinedFunctionRequest
      ): F[UpdateUserDefinedFunctionResponse]

      def updateWorkflow(
        request: UpdateWorkflowRequest
      ): F[UpdateWorkflowResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GlueOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchCreatePartitionOp(
      request: BatchCreatePartitionRequest
    ) extends GlueOp[BatchCreatePartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCreatePartitionResponse] =
        visitor.batchCreatePartition(request)
    }

    final case class BatchDeleteConnectionOp(
      request: BatchDeleteConnectionRequest
    ) extends GlueOp[BatchDeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteConnectionResponse] =
        visitor.batchDeleteConnection(request)
    }

    final case class BatchDeletePartitionOp(
      request: BatchDeletePartitionRequest
    ) extends GlueOp[BatchDeletePartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeletePartitionResponse] =
        visitor.batchDeletePartition(request)
    }

    final case class BatchDeleteTableOp(
      request: BatchDeleteTableRequest
    ) extends GlueOp[BatchDeleteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteTableResponse] =
        visitor.batchDeleteTable(request)
    }

    final case class BatchDeleteTableVersionOp(
      request: BatchDeleteTableVersionRequest
    ) extends GlueOp[BatchDeleteTableVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteTableVersionResponse] =
        visitor.batchDeleteTableVersion(request)
    }

    final case class BatchGetCrawlersOp(
      request: BatchGetCrawlersRequest
    ) extends GlueOp[BatchGetCrawlersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetCrawlersResponse] =
        visitor.batchGetCrawlers(request)
    }

    final case class BatchGetDevEndpointsOp(
      request: BatchGetDevEndpointsRequest
    ) extends GlueOp[BatchGetDevEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetDevEndpointsResponse] =
        visitor.batchGetDevEndpoints(request)
    }

    final case class BatchGetJobsOp(
      request: BatchGetJobsRequest
    ) extends GlueOp[BatchGetJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetJobsResponse] =
        visitor.batchGetJobs(request)
    }

    final case class BatchGetPartitionOp(
      request: BatchGetPartitionRequest
    ) extends GlueOp[BatchGetPartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetPartitionResponse] =
        visitor.batchGetPartition(request)
    }

    final case class BatchGetTriggersOp(
      request: BatchGetTriggersRequest
    ) extends GlueOp[BatchGetTriggersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetTriggersResponse] =
        visitor.batchGetTriggers(request)
    }

    final case class BatchGetWorkflowsOp(
      request: BatchGetWorkflowsRequest
    ) extends GlueOp[BatchGetWorkflowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetWorkflowsResponse] =
        visitor.batchGetWorkflows(request)
    }

    final case class BatchStopJobRunOp(
      request: BatchStopJobRunRequest
    ) extends GlueOp[BatchStopJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchStopJobRunResponse] =
        visitor.batchStopJobRun(request)
    }

    final case class BatchUpdatePartitionOp(
      request: BatchUpdatePartitionRequest
    ) extends GlueOp[BatchUpdatePartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdatePartitionResponse] =
        visitor.batchUpdatePartition(request)
    }

    final case class CancelMLTaskRunOp(
      request: CancelMlTaskRunRequest
    ) extends GlueOp[CancelMlTaskRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelMlTaskRunResponse] =
        visitor.cancelMLTaskRun(request)
    }

    final case class CheckSchemaVersionValidityOp(
      request: CheckSchemaVersionValidityRequest
    ) extends GlueOp[CheckSchemaVersionValidityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckSchemaVersionValidityResponse] =
        visitor.checkSchemaVersionValidity(request)
    }

    final case class CreateClassifierOp(
      request: CreateClassifierRequest
    ) extends GlueOp[CreateClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClassifierResponse] =
        visitor.createClassifier(request)
    }

    final case class CreateConnectionOp(
      request: CreateConnectionRequest
    ) extends GlueOp[CreateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectionResponse] =
        visitor.createConnection(request)
    }

    final case class CreateCrawlerOp(
      request: CreateCrawlerRequest
    ) extends GlueOp[CreateCrawlerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCrawlerResponse] =
        visitor.createCrawler(request)
    }

    final case class CreateDatabaseOp(
      request: CreateDatabaseRequest
    ) extends GlueOp[CreateDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatabaseResponse] =
        visitor.createDatabase(request)
    }

    final case class CreateDevEndpointOp(
      request: CreateDevEndpointRequest
    ) extends GlueOp[CreateDevEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDevEndpointResponse] =
        visitor.createDevEndpoint(request)
    }

    final case class CreateJobOp(
      request: CreateJobRequest
    ) extends GlueOp[CreateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobResponse] =
        visitor.createJob(request)
    }

    final case class CreateMLTransformOp(
      request: CreateMlTransformRequest
    ) extends GlueOp[CreateMlTransformResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMlTransformResponse] =
        visitor.createMLTransform(request)
    }

    final case class CreatePartitionOp(
      request: CreatePartitionRequest
    ) extends GlueOp[CreatePartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePartitionResponse] =
        visitor.createPartition(request)
    }

    final case class CreatePartitionIndexOp(
      request: CreatePartitionIndexRequest
    ) extends GlueOp[CreatePartitionIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePartitionIndexResponse] =
        visitor.createPartitionIndex(request)
    }

    final case class CreateRegistryOp(
      request: CreateRegistryRequest
    ) extends GlueOp[CreateRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRegistryResponse] =
        visitor.createRegistry(request)
    }

    final case class CreateSchemaOp(
      request: CreateSchemaRequest
    ) extends GlueOp[CreateSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSchemaResponse] =
        visitor.createSchema(request)
    }

    final case class CreateScriptOp(
      request: CreateScriptRequest
    ) extends GlueOp[CreateScriptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateScriptResponse] =
        visitor.createScript(request)
    }

    final case class CreateSecurityConfigurationOp(
      request: CreateSecurityConfigurationRequest
    ) extends GlueOp[CreateSecurityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSecurityConfigurationResponse] =
        visitor.createSecurityConfiguration(request)
    }

    final case class CreateTableOp(
      request: CreateTableRequest
    ) extends GlueOp[CreateTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTableResponse] =
        visitor.createTable(request)
    }

    final case class CreateTriggerOp(
      request: CreateTriggerRequest
    ) extends GlueOp[CreateTriggerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTriggerResponse] =
        visitor.createTrigger(request)
    }

    final case class CreateUserDefinedFunctionOp(
      request: CreateUserDefinedFunctionRequest
    ) extends GlueOp[CreateUserDefinedFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserDefinedFunctionResponse] =
        visitor.createUserDefinedFunction(request)
    }

    final case class CreateWorkflowOp(
      request: CreateWorkflowRequest
    ) extends GlueOp[CreateWorkflowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkflowResponse] =
        visitor.createWorkflow(request)
    }

    final case class DeleteClassifierOp(
      request: DeleteClassifierRequest
    ) extends GlueOp[DeleteClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClassifierResponse] =
        visitor.deleteClassifier(request)
    }

    final case class DeleteColumnStatisticsForPartitionOp(
      request: DeleteColumnStatisticsForPartitionRequest
    ) extends GlueOp[DeleteColumnStatisticsForPartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteColumnStatisticsForPartitionResponse] =
        visitor.deleteColumnStatisticsForPartition(request)
    }

    final case class DeleteColumnStatisticsForTableOp(
      request: DeleteColumnStatisticsForTableRequest
    ) extends GlueOp[DeleteColumnStatisticsForTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteColumnStatisticsForTableResponse] =
        visitor.deleteColumnStatisticsForTable(request)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends GlueOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class DeleteCrawlerOp(
      request: DeleteCrawlerRequest
    ) extends GlueOp[DeleteCrawlerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCrawlerResponse] =
        visitor.deleteCrawler(request)
    }

    final case class DeleteDatabaseOp(
      request: DeleteDatabaseRequest
    ) extends GlueOp[DeleteDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatabaseResponse] =
        visitor.deleteDatabase(request)
    }

    final case class DeleteDevEndpointOp(
      request: DeleteDevEndpointRequest
    ) extends GlueOp[DeleteDevEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDevEndpointResponse] =
        visitor.deleteDevEndpoint(request)
    }

    final case class DeleteJobOp(
      request: DeleteJobRequest
    ) extends GlueOp[DeleteJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobResponse] =
        visitor.deleteJob(request)
    }

    final case class DeleteMLTransformOp(
      request: DeleteMlTransformRequest
    ) extends GlueOp[DeleteMlTransformResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMlTransformResponse] =
        visitor.deleteMLTransform(request)
    }

    final case class DeletePartitionOp(
      request: DeletePartitionRequest
    ) extends GlueOp[DeletePartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePartitionResponse] =
        visitor.deletePartition(request)
    }

    final case class DeletePartitionIndexOp(
      request: DeletePartitionIndexRequest
    ) extends GlueOp[DeletePartitionIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePartitionIndexResponse] =
        visitor.deletePartitionIndex(request)
    }

    final case class DeleteRegistryOp(
      request: DeleteRegistryRequest
    ) extends GlueOp[DeleteRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegistryResponse] =
        visitor.deleteRegistry(request)
    }

    final case class DeleteResourcePolicyOp(
      request: DeleteResourcePolicyRequest
    ) extends GlueOp[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteSchemaOp(
      request: DeleteSchemaRequest
    ) extends GlueOp[DeleteSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSchemaResponse] =
        visitor.deleteSchema(request)
    }

    final case class DeleteSchemaVersionsOp(
      request: DeleteSchemaVersionsRequest
    ) extends GlueOp[DeleteSchemaVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSchemaVersionsResponse] =
        visitor.deleteSchemaVersions(request)
    }

    final case class DeleteSecurityConfigurationOp(
      request: DeleteSecurityConfigurationRequest
    ) extends GlueOp[DeleteSecurityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSecurityConfigurationResponse] =
        visitor.deleteSecurityConfiguration(request)
    }

    final case class DeleteTableOp(
      request: DeleteTableRequest
    ) extends GlueOp[DeleteTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTableResponse] =
        visitor.deleteTable(request)
    }

    final case class DeleteTableVersionOp(
      request: DeleteTableVersionRequest
    ) extends GlueOp[DeleteTableVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTableVersionResponse] =
        visitor.deleteTableVersion(request)
    }

    final case class DeleteTriggerOp(
      request: DeleteTriggerRequest
    ) extends GlueOp[DeleteTriggerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTriggerResponse] =
        visitor.deleteTrigger(request)
    }

    final case class DeleteUserDefinedFunctionOp(
      request: DeleteUserDefinedFunctionRequest
    ) extends GlueOp[DeleteUserDefinedFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserDefinedFunctionResponse] =
        visitor.deleteUserDefinedFunction(request)
    }

    final case class DeleteWorkflowOp(
      request: DeleteWorkflowRequest
    ) extends GlueOp[DeleteWorkflowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkflowResponse] =
        visitor.deleteWorkflow(request)
    }

    final case class GetCatalogImportStatusOp(
      request: GetCatalogImportStatusRequest
    ) extends GlueOp[GetCatalogImportStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCatalogImportStatusResponse] =
        visitor.getCatalogImportStatus(request)
    }

    final case class GetClassifierOp(
      request: GetClassifierRequest
    ) extends GlueOp[GetClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetClassifierResponse] =
        visitor.getClassifier(request)
    }

    final case class GetClassifiersOp(
      request: GetClassifiersRequest
    ) extends GlueOp[GetClassifiersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetClassifiersResponse] =
        visitor.getClassifiers(request)
    }

    final case class GetColumnStatisticsForPartitionOp(
      request: GetColumnStatisticsForPartitionRequest
    ) extends GlueOp[GetColumnStatisticsForPartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetColumnStatisticsForPartitionResponse] =
        visitor.getColumnStatisticsForPartition(request)
    }

    final case class GetColumnStatisticsForTableOp(
      request: GetColumnStatisticsForTableRequest
    ) extends GlueOp[GetColumnStatisticsForTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetColumnStatisticsForTableResponse] =
        visitor.getColumnStatisticsForTable(request)
    }

    final case class GetConnectionOp(
      request: GetConnectionRequest
    ) extends GlueOp[GetConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectionResponse] =
        visitor.getConnection(request)
    }

    final case class GetConnectionsOp(
      request: GetConnectionsRequest
    ) extends GlueOp[GetConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectionsResponse] =
        visitor.getConnections(request)
    }

    final case class GetCrawlerOp(
      request: GetCrawlerRequest
    ) extends GlueOp[GetCrawlerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCrawlerResponse] =
        visitor.getCrawler(request)
    }

    final case class GetCrawlerMetricsOp(
      request: GetCrawlerMetricsRequest
    ) extends GlueOp[GetCrawlerMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCrawlerMetricsResponse] =
        visitor.getCrawlerMetrics(request)
    }

    final case class GetCrawlersOp(
      request: GetCrawlersRequest
    ) extends GlueOp[GetCrawlersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCrawlersResponse] =
        visitor.getCrawlers(request)
    }

    final case class GetDataCatalogEncryptionSettingsOp(
      request: GetDataCatalogEncryptionSettingsRequest
    ) extends GlueOp[GetDataCatalogEncryptionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataCatalogEncryptionSettingsResponse] =
        visitor.getDataCatalogEncryptionSettings(request)
    }

    final case class GetDatabaseOp(
      request: GetDatabaseRequest
    ) extends GlueOp[GetDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDatabaseResponse] =
        visitor.getDatabase(request)
    }

    final case class GetDatabasesOp(
      request: GetDatabasesRequest
    ) extends GlueOp[GetDatabasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDatabasesResponse] =
        visitor.getDatabases(request)
    }

    final case class GetDataflowGraphOp(
      request: GetDataflowGraphRequest
    ) extends GlueOp[GetDataflowGraphResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataflowGraphResponse] =
        visitor.getDataflowGraph(request)
    }

    final case class GetDevEndpointOp(
      request: GetDevEndpointRequest
    ) extends GlueOp[GetDevEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevEndpointResponse] =
        visitor.getDevEndpoint(request)
    }

    final case class GetDevEndpointsOp(
      request: GetDevEndpointsRequest
    ) extends GlueOp[GetDevEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevEndpointsResponse] =
        visitor.getDevEndpoints(request)
    }

    final case class GetJobOp(
      request: GetJobRequest
    ) extends GlueOp[GetJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobResponse] =
        visitor.getJob(request)
    }

    final case class GetJobBookmarkOp(
      request: GetJobBookmarkRequest
    ) extends GlueOp[GetJobBookmarkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobBookmarkResponse] =
        visitor.getJobBookmark(request)
    }

    final case class GetJobRunOp(
      request: GetJobRunRequest
    ) extends GlueOp[GetJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobRunResponse] =
        visitor.getJobRun(request)
    }

    final case class GetJobRunsOp(
      request: GetJobRunsRequest
    ) extends GlueOp[GetJobRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobRunsResponse] =
        visitor.getJobRuns(request)
    }

    final case class GetJobsOp(
      request: GetJobsRequest
    ) extends GlueOp[GetJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobsResponse] =
        visitor.getJobs(request)
    }

    final case class GetMLTaskRunOp(
      request: GetMlTaskRunRequest
    ) extends GlueOp[GetMlTaskRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMlTaskRunResponse] =
        visitor.getMLTaskRun(request)
    }

    final case class GetMLTaskRunsOp(
      request: GetMlTaskRunsRequest
    ) extends GlueOp[GetMlTaskRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMlTaskRunsResponse] =
        visitor.getMLTaskRuns(request)
    }

    final case class GetMLTransformOp(
      request: GetMlTransformRequest
    ) extends GlueOp[GetMlTransformResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMlTransformResponse] =
        visitor.getMLTransform(request)
    }

    final case class GetMLTransformsOp(
      request: GetMlTransformsRequest
    ) extends GlueOp[GetMlTransformsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMlTransformsResponse] =
        visitor.getMLTransforms(request)
    }

    final case class GetMappingOp(
      request: GetMappingRequest
    ) extends GlueOp[GetMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMappingResponse] =
        visitor.getMapping(request)
    }

    final case class GetPartitionOp(
      request: GetPartitionRequest
    ) extends GlueOp[GetPartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPartitionResponse] =
        visitor.getPartition(request)
    }

    final case class GetPartitionIndexesOp(
      request: GetPartitionIndexesRequest
    ) extends GlueOp[GetPartitionIndexesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPartitionIndexesResponse] =
        visitor.getPartitionIndexes(request)
    }

    final case class GetPartitionsOp(
      request: GetPartitionsRequest
    ) extends GlueOp[GetPartitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPartitionsResponse] =
        visitor.getPartitions(request)
    }

    final case class GetPlanOp(
      request: GetPlanRequest
    ) extends GlueOp[GetPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPlanResponse] =
        visitor.getPlan(request)
    }

    final case class GetRegistryOp(
      request: GetRegistryRequest
    ) extends GlueOp[GetRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegistryResponse] =
        visitor.getRegistry(request)
    }

    final case class GetResourcePoliciesOp(
      request: GetResourcePoliciesRequest
    ) extends GlueOp[GetResourcePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcePoliciesResponse] =
        visitor.getResourcePolicies(request)
    }

    final case class GetResourcePolicyOp(
      request: GetResourcePolicyRequest
    ) extends GlueOp[GetResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcePolicyResponse] =
        visitor.getResourcePolicy(request)
    }

    final case class GetSchemaOp(
      request: GetSchemaRequest
    ) extends GlueOp[GetSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSchemaResponse] =
        visitor.getSchema(request)
    }

    final case class GetSchemaByDefinitionOp(
      request: GetSchemaByDefinitionRequest
    ) extends GlueOp[GetSchemaByDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSchemaByDefinitionResponse] =
        visitor.getSchemaByDefinition(request)
    }

    final case class GetSchemaVersionOp(
      request: GetSchemaVersionRequest
    ) extends GlueOp[GetSchemaVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSchemaVersionResponse] =
        visitor.getSchemaVersion(request)
    }

    final case class GetSchemaVersionsDiffOp(
      request: GetSchemaVersionsDiffRequest
    ) extends GlueOp[GetSchemaVersionsDiffResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSchemaVersionsDiffResponse] =
        visitor.getSchemaVersionsDiff(request)
    }

    final case class GetSecurityConfigurationOp(
      request: GetSecurityConfigurationRequest
    ) extends GlueOp[GetSecurityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSecurityConfigurationResponse] =
        visitor.getSecurityConfiguration(request)
    }

    final case class GetSecurityConfigurationsOp(
      request: GetSecurityConfigurationsRequest
    ) extends GlueOp[GetSecurityConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSecurityConfigurationsResponse] =
        visitor.getSecurityConfigurations(request)
    }

    final case class GetTableOp(
      request: GetTableRequest
    ) extends GlueOp[GetTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTableResponse] =
        visitor.getTable(request)
    }

    final case class GetTableVersionOp(
      request: GetTableVersionRequest
    ) extends GlueOp[GetTableVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTableVersionResponse] =
        visitor.getTableVersion(request)
    }

    final case class GetTableVersionsOp(
      request: GetTableVersionsRequest
    ) extends GlueOp[GetTableVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTableVersionsResponse] =
        visitor.getTableVersions(request)
    }

    final case class GetTablesOp(
      request: GetTablesRequest
    ) extends GlueOp[GetTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTablesResponse] =
        visitor.getTables(request)
    }

    final case class GetTagsOp(
      request: GetTagsRequest
    ) extends GlueOp[GetTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTagsResponse] =
        visitor.getTags(request)
    }

    final case class GetTriggerOp(
      request: GetTriggerRequest
    ) extends GlueOp[GetTriggerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTriggerResponse] =
        visitor.getTrigger(request)
    }

    final case class GetTriggersOp(
      request: GetTriggersRequest
    ) extends GlueOp[GetTriggersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTriggersResponse] =
        visitor.getTriggers(request)
    }

    final case class GetUserDefinedFunctionOp(
      request: GetUserDefinedFunctionRequest
    ) extends GlueOp[GetUserDefinedFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserDefinedFunctionResponse] =
        visitor.getUserDefinedFunction(request)
    }

    final case class GetUserDefinedFunctionsOp(
      request: GetUserDefinedFunctionsRequest
    ) extends GlueOp[GetUserDefinedFunctionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserDefinedFunctionsResponse] =
        visitor.getUserDefinedFunctions(request)
    }

    final case class GetWorkflowOp(
      request: GetWorkflowRequest
    ) extends GlueOp[GetWorkflowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkflowResponse] =
        visitor.getWorkflow(request)
    }

    final case class GetWorkflowRunOp(
      request: GetWorkflowRunRequest
    ) extends GlueOp[GetWorkflowRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkflowRunResponse] =
        visitor.getWorkflowRun(request)
    }

    final case class GetWorkflowRunPropertiesOp(
      request: GetWorkflowRunPropertiesRequest
    ) extends GlueOp[GetWorkflowRunPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkflowRunPropertiesResponse] =
        visitor.getWorkflowRunProperties(request)
    }

    final case class GetWorkflowRunsOp(
      request: GetWorkflowRunsRequest
    ) extends GlueOp[GetWorkflowRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkflowRunsResponse] =
        visitor.getWorkflowRuns(request)
    }

    final case class ImportCatalogToGlueOp(
      request: ImportCatalogToGlueRequest
    ) extends GlueOp[ImportCatalogToGlueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportCatalogToGlueResponse] =
        visitor.importCatalogToGlue(request)
    }

    final case class ListCrawlersOp(
      request: ListCrawlersRequest
    ) extends GlueOp[ListCrawlersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCrawlersResponse] =
        visitor.listCrawlers(request)
    }

    final case class ListDevEndpointsOp(
      request: ListDevEndpointsRequest
    ) extends GlueOp[ListDevEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevEndpointsResponse] =
        visitor.listDevEndpoints(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends GlueOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListMLTransformsOp(
      request: ListMlTransformsRequest
    ) extends GlueOp[ListMlTransformsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMlTransformsResponse] =
        visitor.listMLTransforms(request)
    }

    final case class ListRegistriesOp(
      request: ListRegistriesRequest
    ) extends GlueOp[ListRegistriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRegistriesResponse] =
        visitor.listRegistries(request)
    }

    final case class ListSchemaVersionsOp(
      request: ListSchemaVersionsRequest
    ) extends GlueOp[ListSchemaVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchemaVersionsResponse] =
        visitor.listSchemaVersions(request)
    }

    final case class ListSchemasOp(
      request: ListSchemasRequest
    ) extends GlueOp[ListSchemasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchemasResponse] =
        visitor.listSchemas(request)
    }

    final case class ListTriggersOp(
      request: ListTriggersRequest
    ) extends GlueOp[ListTriggersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTriggersResponse] =
        visitor.listTriggers(request)
    }

    final case class ListWorkflowsOp(
      request: ListWorkflowsRequest
    ) extends GlueOp[ListWorkflowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkflowsResponse] =
        visitor.listWorkflows(request)
    }

    final case class PutDataCatalogEncryptionSettingsOp(
      request: PutDataCatalogEncryptionSettingsRequest
    ) extends GlueOp[PutDataCatalogEncryptionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDataCatalogEncryptionSettingsResponse] =
        visitor.putDataCatalogEncryptionSettings(request)
    }

    final case class PutResourcePolicyOp(
      request: PutResourcePolicyRequest
    ) extends GlueOp[PutResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourcePolicyResponse] =
        visitor.putResourcePolicy(request)
    }

    final case class PutSchemaVersionMetadataOp(
      request: PutSchemaVersionMetadataRequest
    ) extends GlueOp[PutSchemaVersionMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSchemaVersionMetadataResponse] =
        visitor.putSchemaVersionMetadata(request)
    }

    final case class PutWorkflowRunPropertiesOp(
      request: PutWorkflowRunPropertiesRequest
    ) extends GlueOp[PutWorkflowRunPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutWorkflowRunPropertiesResponse] =
        visitor.putWorkflowRunProperties(request)
    }

    final case class QuerySchemaVersionMetadataOp(
      request: QuerySchemaVersionMetadataRequest
    ) extends GlueOp[QuerySchemaVersionMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[QuerySchemaVersionMetadataResponse] =
        visitor.querySchemaVersionMetadata(request)
    }

    final case class RegisterSchemaVersionOp(
      request: RegisterSchemaVersionRequest
    ) extends GlueOp[RegisterSchemaVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterSchemaVersionResponse] =
        visitor.registerSchemaVersion(request)
    }

    final case class RemoveSchemaVersionMetadataOp(
      request: RemoveSchemaVersionMetadataRequest
    ) extends GlueOp[RemoveSchemaVersionMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveSchemaVersionMetadataResponse] =
        visitor.removeSchemaVersionMetadata(request)
    }

    final case class ResetJobBookmarkOp(
      request: ResetJobBookmarkRequest
    ) extends GlueOp[ResetJobBookmarkResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetJobBookmarkResponse] =
        visitor.resetJobBookmark(request)
    }

    final case class ResumeWorkflowRunOp(
      request: ResumeWorkflowRunRequest
    ) extends GlueOp[ResumeWorkflowRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResumeWorkflowRunResponse] =
        visitor.resumeWorkflowRun(request)
    }

    final case class SearchTablesOp(
      request: SearchTablesRequest
    ) extends GlueOp[SearchTablesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchTablesResponse] =
        visitor.searchTables(request)
    }

    final case class StartCrawlerOp(
      request: StartCrawlerRequest
    ) extends GlueOp[StartCrawlerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartCrawlerResponse] =
        visitor.startCrawler(request)
    }

    final case class StartCrawlerScheduleOp(
      request: StartCrawlerScheduleRequest
    ) extends GlueOp[StartCrawlerScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartCrawlerScheduleResponse] =
        visitor.startCrawlerSchedule(request)
    }

    final case class StartExportLabelsTaskRunOp(
      request: StartExportLabelsTaskRunRequest
    ) extends GlueOp[StartExportLabelsTaskRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartExportLabelsTaskRunResponse] =
        visitor.startExportLabelsTaskRun(request)
    }

    final case class StartImportLabelsTaskRunOp(
      request: StartImportLabelsTaskRunRequest
    ) extends GlueOp[StartImportLabelsTaskRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartImportLabelsTaskRunResponse] =
        visitor.startImportLabelsTaskRun(request)
    }

    final case class StartJobRunOp(
      request: StartJobRunRequest
    ) extends GlueOp[StartJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartJobRunResponse] =
        visitor.startJobRun(request)
    }

    final case class StartMLEvaluationTaskRunOp(
      request: StartMlEvaluationTaskRunRequest
    ) extends GlueOp[StartMlEvaluationTaskRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMlEvaluationTaskRunResponse] =
        visitor.startMLEvaluationTaskRun(request)
    }

    final case class StartMLLabelingSetGenerationTaskRunOp(
      request: StartMlLabelingSetGenerationTaskRunRequest
    ) extends GlueOp[StartMlLabelingSetGenerationTaskRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMlLabelingSetGenerationTaskRunResponse] =
        visitor.startMLLabelingSetGenerationTaskRun(request)
    }

    final case class StartTriggerOp(
      request: StartTriggerRequest
    ) extends GlueOp[StartTriggerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTriggerResponse] =
        visitor.startTrigger(request)
    }

    final case class StartWorkflowRunOp(
      request: StartWorkflowRunRequest
    ) extends GlueOp[StartWorkflowRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartWorkflowRunResponse] =
        visitor.startWorkflowRun(request)
    }

    final case class StopCrawlerOp(
      request: StopCrawlerRequest
    ) extends GlueOp[StopCrawlerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopCrawlerResponse] =
        visitor.stopCrawler(request)
    }

    final case class StopCrawlerScheduleOp(
      request: StopCrawlerScheduleRequest
    ) extends GlueOp[StopCrawlerScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopCrawlerScheduleResponse] =
        visitor.stopCrawlerSchedule(request)
    }

    final case class StopTriggerOp(
      request: StopTriggerRequest
    ) extends GlueOp[StopTriggerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopTriggerResponse] =
        visitor.stopTrigger(request)
    }

    final case class StopWorkflowRunOp(
      request: StopWorkflowRunRequest
    ) extends GlueOp[StopWorkflowRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopWorkflowRunResponse] =
        visitor.stopWorkflowRun(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends GlueOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends GlueOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateClassifierOp(
      request: UpdateClassifierRequest
    ) extends GlueOp[UpdateClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClassifierResponse] =
        visitor.updateClassifier(request)
    }

    final case class UpdateColumnStatisticsForPartitionOp(
      request: UpdateColumnStatisticsForPartitionRequest
    ) extends GlueOp[UpdateColumnStatisticsForPartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateColumnStatisticsForPartitionResponse] =
        visitor.updateColumnStatisticsForPartition(request)
    }

    final case class UpdateColumnStatisticsForTableOp(
      request: UpdateColumnStatisticsForTableRequest
    ) extends GlueOp[UpdateColumnStatisticsForTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateColumnStatisticsForTableResponse] =
        visitor.updateColumnStatisticsForTable(request)
    }

    final case class UpdateConnectionOp(
      request: UpdateConnectionRequest
    ) extends GlueOp[UpdateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectionResponse] =
        visitor.updateConnection(request)
    }

    final case class UpdateCrawlerOp(
      request: UpdateCrawlerRequest
    ) extends GlueOp[UpdateCrawlerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCrawlerResponse] =
        visitor.updateCrawler(request)
    }

    final case class UpdateCrawlerScheduleOp(
      request: UpdateCrawlerScheduleRequest
    ) extends GlueOp[UpdateCrawlerScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCrawlerScheduleResponse] =
        visitor.updateCrawlerSchedule(request)
    }

    final case class UpdateDatabaseOp(
      request: UpdateDatabaseRequest
    ) extends GlueOp[UpdateDatabaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDatabaseResponse] =
        visitor.updateDatabase(request)
    }

    final case class UpdateDevEndpointOp(
      request: UpdateDevEndpointRequest
    ) extends GlueOp[UpdateDevEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDevEndpointResponse] =
        visitor.updateDevEndpoint(request)
    }

    final case class UpdateJobOp(
      request: UpdateJobRequest
    ) extends GlueOp[UpdateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobResponse] =
        visitor.updateJob(request)
    }

    final case class UpdateMLTransformOp(
      request: UpdateMlTransformRequest
    ) extends GlueOp[UpdateMlTransformResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMlTransformResponse] =
        visitor.updateMLTransform(request)
    }

    final case class UpdatePartitionOp(
      request: UpdatePartitionRequest
    ) extends GlueOp[UpdatePartitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePartitionResponse] =
        visitor.updatePartition(request)
    }

    final case class UpdateRegistryOp(
      request: UpdateRegistryRequest
    ) extends GlueOp[UpdateRegistryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRegistryResponse] =
        visitor.updateRegistry(request)
    }

    final case class UpdateSchemaOp(
      request: UpdateSchemaRequest
    ) extends GlueOp[UpdateSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSchemaResponse] =
        visitor.updateSchema(request)
    }

    final case class UpdateTableOp(
      request: UpdateTableRequest
    ) extends GlueOp[UpdateTableResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTableResponse] =
        visitor.updateTable(request)
    }

    final case class UpdateTriggerOp(
      request: UpdateTriggerRequest
    ) extends GlueOp[UpdateTriggerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTriggerResponse] =
        visitor.updateTrigger(request)
    }

    final case class UpdateUserDefinedFunctionOp(
      request: UpdateUserDefinedFunctionRequest
    ) extends GlueOp[UpdateUserDefinedFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserDefinedFunctionResponse] =
        visitor.updateUserDefinedFunction(request)
    }

    final case class UpdateWorkflowOp(
      request: UpdateWorkflowRequest
    ) extends GlueOp[UpdateWorkflowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkflowResponse] =
        visitor.updateWorkflow(request)
    }
  }

  import GlueOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GlueOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchCreatePartition(
    request: BatchCreatePartitionRequest
  ): GlueIO[BatchCreatePartitionResponse] =
    FF.liftF(BatchCreatePartitionOp(request))

  def batchDeleteConnection(
    request: BatchDeleteConnectionRequest
  ): GlueIO[BatchDeleteConnectionResponse] =
    FF.liftF(BatchDeleteConnectionOp(request))

  def batchDeletePartition(
    request: BatchDeletePartitionRequest
  ): GlueIO[BatchDeletePartitionResponse] =
    FF.liftF(BatchDeletePartitionOp(request))

  def batchDeleteTable(
    request: BatchDeleteTableRequest
  ): GlueIO[BatchDeleteTableResponse] =
    FF.liftF(BatchDeleteTableOp(request))

  def batchDeleteTableVersion(
    request: BatchDeleteTableVersionRequest
  ): GlueIO[BatchDeleteTableVersionResponse] =
    FF.liftF(BatchDeleteTableVersionOp(request))

  def batchGetCrawlers(
    request: BatchGetCrawlersRequest
  ): GlueIO[BatchGetCrawlersResponse] =
    FF.liftF(BatchGetCrawlersOp(request))

  def batchGetDevEndpoints(
    request: BatchGetDevEndpointsRequest
  ): GlueIO[BatchGetDevEndpointsResponse] =
    FF.liftF(BatchGetDevEndpointsOp(request))

  def batchGetJobs(
    request: BatchGetJobsRequest
  ): GlueIO[BatchGetJobsResponse] =
    FF.liftF(BatchGetJobsOp(request))

  def batchGetPartition(
    request: BatchGetPartitionRequest
  ): GlueIO[BatchGetPartitionResponse] =
    FF.liftF(BatchGetPartitionOp(request))

  def batchGetTriggers(
    request: BatchGetTriggersRequest
  ): GlueIO[BatchGetTriggersResponse] =
    FF.liftF(BatchGetTriggersOp(request))

  def batchGetWorkflows(
    request: BatchGetWorkflowsRequest
  ): GlueIO[BatchGetWorkflowsResponse] =
    FF.liftF(BatchGetWorkflowsOp(request))

  def batchStopJobRun(
    request: BatchStopJobRunRequest
  ): GlueIO[BatchStopJobRunResponse] =
    FF.liftF(BatchStopJobRunOp(request))

  def batchUpdatePartition(
    request: BatchUpdatePartitionRequest
  ): GlueIO[BatchUpdatePartitionResponse] =
    FF.liftF(BatchUpdatePartitionOp(request))

  def cancelMLTaskRun(
    request: CancelMlTaskRunRequest
  ): GlueIO[CancelMlTaskRunResponse] =
    FF.liftF(CancelMLTaskRunOp(request))

  def checkSchemaVersionValidity(
    request: CheckSchemaVersionValidityRequest
  ): GlueIO[CheckSchemaVersionValidityResponse] =
    FF.liftF(CheckSchemaVersionValidityOp(request))

  def createClassifier(
    request: CreateClassifierRequest
  ): GlueIO[CreateClassifierResponse] =
    FF.liftF(CreateClassifierOp(request))

  def createConnection(
    request: CreateConnectionRequest
  ): GlueIO[CreateConnectionResponse] =
    FF.liftF(CreateConnectionOp(request))

  def createCrawler(
    request: CreateCrawlerRequest
  ): GlueIO[CreateCrawlerResponse] =
    FF.liftF(CreateCrawlerOp(request))

  def createDatabase(
    request: CreateDatabaseRequest
  ): GlueIO[CreateDatabaseResponse] =
    FF.liftF(CreateDatabaseOp(request))

  def createDevEndpoint(
    request: CreateDevEndpointRequest
  ): GlueIO[CreateDevEndpointResponse] =
    FF.liftF(CreateDevEndpointOp(request))

  def createJob(
    request: CreateJobRequest
  ): GlueIO[CreateJobResponse] =
    FF.liftF(CreateJobOp(request))

  def createMLTransform(
    request: CreateMlTransformRequest
  ): GlueIO[CreateMlTransformResponse] =
    FF.liftF(CreateMLTransformOp(request))

  def createPartition(
    request: CreatePartitionRequest
  ): GlueIO[CreatePartitionResponse] =
    FF.liftF(CreatePartitionOp(request))

  def createPartitionIndex(
    request: CreatePartitionIndexRequest
  ): GlueIO[CreatePartitionIndexResponse] =
    FF.liftF(CreatePartitionIndexOp(request))

  def createRegistry(
    request: CreateRegistryRequest
  ): GlueIO[CreateRegistryResponse] =
    FF.liftF(CreateRegistryOp(request))

  def createSchema(
    request: CreateSchemaRequest
  ): GlueIO[CreateSchemaResponse] =
    FF.liftF(CreateSchemaOp(request))

  def createScript(
    request: CreateScriptRequest
  ): GlueIO[CreateScriptResponse] =
    FF.liftF(CreateScriptOp(request))

  def createSecurityConfiguration(
    request: CreateSecurityConfigurationRequest
  ): GlueIO[CreateSecurityConfigurationResponse] =
    FF.liftF(CreateSecurityConfigurationOp(request))

  def createTable(
    request: CreateTableRequest
  ): GlueIO[CreateTableResponse] =
    FF.liftF(CreateTableOp(request))

  def createTrigger(
    request: CreateTriggerRequest
  ): GlueIO[CreateTriggerResponse] =
    FF.liftF(CreateTriggerOp(request))

  def createUserDefinedFunction(
    request: CreateUserDefinedFunctionRequest
  ): GlueIO[CreateUserDefinedFunctionResponse] =
    FF.liftF(CreateUserDefinedFunctionOp(request))

  def createWorkflow(
    request: CreateWorkflowRequest
  ): GlueIO[CreateWorkflowResponse] =
    FF.liftF(CreateWorkflowOp(request))

  def deleteClassifier(
    request: DeleteClassifierRequest
  ): GlueIO[DeleteClassifierResponse] =
    FF.liftF(DeleteClassifierOp(request))

  def deleteColumnStatisticsForPartition(
    request: DeleteColumnStatisticsForPartitionRequest
  ): GlueIO[DeleteColumnStatisticsForPartitionResponse] =
    FF.liftF(DeleteColumnStatisticsForPartitionOp(request))

  def deleteColumnStatisticsForTable(
    request: DeleteColumnStatisticsForTableRequest
  ): GlueIO[DeleteColumnStatisticsForTableResponse] =
    FF.liftF(DeleteColumnStatisticsForTableOp(request))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): GlueIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def deleteCrawler(
    request: DeleteCrawlerRequest
  ): GlueIO[DeleteCrawlerResponse] =
    FF.liftF(DeleteCrawlerOp(request))

  def deleteDatabase(
    request: DeleteDatabaseRequest
  ): GlueIO[DeleteDatabaseResponse] =
    FF.liftF(DeleteDatabaseOp(request))

  def deleteDevEndpoint(
    request: DeleteDevEndpointRequest
  ): GlueIO[DeleteDevEndpointResponse] =
    FF.liftF(DeleteDevEndpointOp(request))

  def deleteJob(
    request: DeleteJobRequest
  ): GlueIO[DeleteJobResponse] =
    FF.liftF(DeleteJobOp(request))

  def deleteMLTransform(
    request: DeleteMlTransformRequest
  ): GlueIO[DeleteMlTransformResponse] =
    FF.liftF(DeleteMLTransformOp(request))

  def deletePartition(
    request: DeletePartitionRequest
  ): GlueIO[DeletePartitionResponse] =
    FF.liftF(DeletePartitionOp(request))

  def deletePartitionIndex(
    request: DeletePartitionIndexRequest
  ): GlueIO[DeletePartitionIndexResponse] =
    FF.liftF(DeletePartitionIndexOp(request))

  def deleteRegistry(
    request: DeleteRegistryRequest
  ): GlueIO[DeleteRegistryResponse] =
    FF.liftF(DeleteRegistryOp(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): GlueIO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicyOp(request))

  def deleteSchema(
    request: DeleteSchemaRequest
  ): GlueIO[DeleteSchemaResponse] =
    FF.liftF(DeleteSchemaOp(request))

  def deleteSchemaVersions(
    request: DeleteSchemaVersionsRequest
  ): GlueIO[DeleteSchemaVersionsResponse] =
    FF.liftF(DeleteSchemaVersionsOp(request))

  def deleteSecurityConfiguration(
    request: DeleteSecurityConfigurationRequest
  ): GlueIO[DeleteSecurityConfigurationResponse] =
    FF.liftF(DeleteSecurityConfigurationOp(request))

  def deleteTable(
    request: DeleteTableRequest
  ): GlueIO[DeleteTableResponse] =
    FF.liftF(DeleteTableOp(request))

  def deleteTableVersion(
    request: DeleteTableVersionRequest
  ): GlueIO[DeleteTableVersionResponse] =
    FF.liftF(DeleteTableVersionOp(request))

  def deleteTrigger(
    request: DeleteTriggerRequest
  ): GlueIO[DeleteTriggerResponse] =
    FF.liftF(DeleteTriggerOp(request))

  def deleteUserDefinedFunction(
    request: DeleteUserDefinedFunctionRequest
  ): GlueIO[DeleteUserDefinedFunctionResponse] =
    FF.liftF(DeleteUserDefinedFunctionOp(request))

  def deleteWorkflow(
    request: DeleteWorkflowRequest
  ): GlueIO[DeleteWorkflowResponse] =
    FF.liftF(DeleteWorkflowOp(request))

  def getCatalogImportStatus(
    request: GetCatalogImportStatusRequest
  ): GlueIO[GetCatalogImportStatusResponse] =
    FF.liftF(GetCatalogImportStatusOp(request))

  def getClassifier(
    request: GetClassifierRequest
  ): GlueIO[GetClassifierResponse] =
    FF.liftF(GetClassifierOp(request))

  def getClassifiers(
    request: GetClassifiersRequest
  ): GlueIO[GetClassifiersResponse] =
    FF.liftF(GetClassifiersOp(request))

  def getColumnStatisticsForPartition(
    request: GetColumnStatisticsForPartitionRequest
  ): GlueIO[GetColumnStatisticsForPartitionResponse] =
    FF.liftF(GetColumnStatisticsForPartitionOp(request))

  def getColumnStatisticsForTable(
    request: GetColumnStatisticsForTableRequest
  ): GlueIO[GetColumnStatisticsForTableResponse] =
    FF.liftF(GetColumnStatisticsForTableOp(request))

  def getConnection(
    request: GetConnectionRequest
  ): GlueIO[GetConnectionResponse] =
    FF.liftF(GetConnectionOp(request))

  def getConnections(
    request: GetConnectionsRequest
  ): GlueIO[GetConnectionsResponse] =
    FF.liftF(GetConnectionsOp(request))

  def getCrawler(
    request: GetCrawlerRequest
  ): GlueIO[GetCrawlerResponse] =
    FF.liftF(GetCrawlerOp(request))

  def getCrawlerMetrics(
    request: GetCrawlerMetricsRequest
  ): GlueIO[GetCrawlerMetricsResponse] =
    FF.liftF(GetCrawlerMetricsOp(request))

  def getCrawlers(
    request: GetCrawlersRequest
  ): GlueIO[GetCrawlersResponse] =
    FF.liftF(GetCrawlersOp(request))

  def getDataCatalogEncryptionSettings(
    request: GetDataCatalogEncryptionSettingsRequest
  ): GlueIO[GetDataCatalogEncryptionSettingsResponse] =
    FF.liftF(GetDataCatalogEncryptionSettingsOp(request))

  def getDatabase(
    request: GetDatabaseRequest
  ): GlueIO[GetDatabaseResponse] =
    FF.liftF(GetDatabaseOp(request))

  def getDatabases(
    request: GetDatabasesRequest
  ): GlueIO[GetDatabasesResponse] =
    FF.liftF(GetDatabasesOp(request))

  def getDataflowGraph(
    request: GetDataflowGraphRequest
  ): GlueIO[GetDataflowGraphResponse] =
    FF.liftF(GetDataflowGraphOp(request))

  def getDevEndpoint(
    request: GetDevEndpointRequest
  ): GlueIO[GetDevEndpointResponse] =
    FF.liftF(GetDevEndpointOp(request))

  def getDevEndpoints(
    request: GetDevEndpointsRequest
  ): GlueIO[GetDevEndpointsResponse] =
    FF.liftF(GetDevEndpointsOp(request))

  def getJob(
    request: GetJobRequest
  ): GlueIO[GetJobResponse] =
    FF.liftF(GetJobOp(request))

  def getJobBookmark(
    request: GetJobBookmarkRequest
  ): GlueIO[GetJobBookmarkResponse] =
    FF.liftF(GetJobBookmarkOp(request))

  def getJobRun(
    request: GetJobRunRequest
  ): GlueIO[GetJobRunResponse] =
    FF.liftF(GetJobRunOp(request))

  def getJobRuns(
    request: GetJobRunsRequest
  ): GlueIO[GetJobRunsResponse] =
    FF.liftF(GetJobRunsOp(request))

  def getJobs(
    request: GetJobsRequest
  ): GlueIO[GetJobsResponse] =
    FF.liftF(GetJobsOp(request))

  def getMLTaskRun(
    request: GetMlTaskRunRequest
  ): GlueIO[GetMlTaskRunResponse] =
    FF.liftF(GetMLTaskRunOp(request))

  def getMLTaskRuns(
    request: GetMlTaskRunsRequest
  ): GlueIO[GetMlTaskRunsResponse] =
    FF.liftF(GetMLTaskRunsOp(request))

  def getMLTransform(
    request: GetMlTransformRequest
  ): GlueIO[GetMlTransformResponse] =
    FF.liftF(GetMLTransformOp(request))

  def getMLTransforms(
    request: GetMlTransformsRequest
  ): GlueIO[GetMlTransformsResponse] =
    FF.liftF(GetMLTransformsOp(request))

  def getMapping(
    request: GetMappingRequest
  ): GlueIO[GetMappingResponse] =
    FF.liftF(GetMappingOp(request))

  def getPartition(
    request: GetPartitionRequest
  ): GlueIO[GetPartitionResponse] =
    FF.liftF(GetPartitionOp(request))

  def getPartitionIndexes(
    request: GetPartitionIndexesRequest
  ): GlueIO[GetPartitionIndexesResponse] =
    FF.liftF(GetPartitionIndexesOp(request))

  def getPartitions(
    request: GetPartitionsRequest
  ): GlueIO[GetPartitionsResponse] =
    FF.liftF(GetPartitionsOp(request))

  def getPlan(
    request: GetPlanRequest
  ): GlueIO[GetPlanResponse] =
    FF.liftF(GetPlanOp(request))

  def getRegistry(
    request: GetRegistryRequest
  ): GlueIO[GetRegistryResponse] =
    FF.liftF(GetRegistryOp(request))

  def getResourcePolicies(
    request: GetResourcePoliciesRequest
  ): GlueIO[GetResourcePoliciesResponse] =
    FF.liftF(GetResourcePoliciesOp(request))

  def getResourcePolicy(
    request: GetResourcePolicyRequest
  ): GlueIO[GetResourcePolicyResponse] =
    FF.liftF(GetResourcePolicyOp(request))

  def getSchema(
    request: GetSchemaRequest
  ): GlueIO[GetSchemaResponse] =
    FF.liftF(GetSchemaOp(request))

  def getSchemaByDefinition(
    request: GetSchemaByDefinitionRequest
  ): GlueIO[GetSchemaByDefinitionResponse] =
    FF.liftF(GetSchemaByDefinitionOp(request))

  def getSchemaVersion(
    request: GetSchemaVersionRequest
  ): GlueIO[GetSchemaVersionResponse] =
    FF.liftF(GetSchemaVersionOp(request))

  def getSchemaVersionsDiff(
    request: GetSchemaVersionsDiffRequest
  ): GlueIO[GetSchemaVersionsDiffResponse] =
    FF.liftF(GetSchemaVersionsDiffOp(request))

  def getSecurityConfiguration(
    request: GetSecurityConfigurationRequest
  ): GlueIO[GetSecurityConfigurationResponse] =
    FF.liftF(GetSecurityConfigurationOp(request))

  def getSecurityConfigurations(
    request: GetSecurityConfigurationsRequest
  ): GlueIO[GetSecurityConfigurationsResponse] =
    FF.liftF(GetSecurityConfigurationsOp(request))

  def getTable(
    request: GetTableRequest
  ): GlueIO[GetTableResponse] =
    FF.liftF(GetTableOp(request))

  def getTableVersion(
    request: GetTableVersionRequest
  ): GlueIO[GetTableVersionResponse] =
    FF.liftF(GetTableVersionOp(request))

  def getTableVersions(
    request: GetTableVersionsRequest
  ): GlueIO[GetTableVersionsResponse] =
    FF.liftF(GetTableVersionsOp(request))

  def getTables(
    request: GetTablesRequest
  ): GlueIO[GetTablesResponse] =
    FF.liftF(GetTablesOp(request))

  def getTags(
    request: GetTagsRequest
  ): GlueIO[GetTagsResponse] =
    FF.liftF(GetTagsOp(request))

  def getTrigger(
    request: GetTriggerRequest
  ): GlueIO[GetTriggerResponse] =
    FF.liftF(GetTriggerOp(request))

  def getTriggers(
    request: GetTriggersRequest
  ): GlueIO[GetTriggersResponse] =
    FF.liftF(GetTriggersOp(request))

  def getUserDefinedFunction(
    request: GetUserDefinedFunctionRequest
  ): GlueIO[GetUserDefinedFunctionResponse] =
    FF.liftF(GetUserDefinedFunctionOp(request))

  def getUserDefinedFunctions(
    request: GetUserDefinedFunctionsRequest
  ): GlueIO[GetUserDefinedFunctionsResponse] =
    FF.liftF(GetUserDefinedFunctionsOp(request))

  def getWorkflow(
    request: GetWorkflowRequest
  ): GlueIO[GetWorkflowResponse] =
    FF.liftF(GetWorkflowOp(request))

  def getWorkflowRun(
    request: GetWorkflowRunRequest
  ): GlueIO[GetWorkflowRunResponse] =
    FF.liftF(GetWorkflowRunOp(request))

  def getWorkflowRunProperties(
    request: GetWorkflowRunPropertiesRequest
  ): GlueIO[GetWorkflowRunPropertiesResponse] =
    FF.liftF(GetWorkflowRunPropertiesOp(request))

  def getWorkflowRuns(
    request: GetWorkflowRunsRequest
  ): GlueIO[GetWorkflowRunsResponse] =
    FF.liftF(GetWorkflowRunsOp(request))

  def importCatalogToGlue(
    request: ImportCatalogToGlueRequest
  ): GlueIO[ImportCatalogToGlueResponse] =
    FF.liftF(ImportCatalogToGlueOp(request))

  def listCrawlers(
    request: ListCrawlersRequest
  ): GlueIO[ListCrawlersResponse] =
    FF.liftF(ListCrawlersOp(request))

  def listDevEndpoints(
    request: ListDevEndpointsRequest
  ): GlueIO[ListDevEndpointsResponse] =
    FF.liftF(ListDevEndpointsOp(request))

  def listJobs(
    request: ListJobsRequest
  ): GlueIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listMLTransforms(
    request: ListMlTransformsRequest
  ): GlueIO[ListMlTransformsResponse] =
    FF.liftF(ListMLTransformsOp(request))

  def listRegistries(
    request: ListRegistriesRequest
  ): GlueIO[ListRegistriesResponse] =
    FF.liftF(ListRegistriesOp(request))

  def listSchemaVersions(
    request: ListSchemaVersionsRequest
  ): GlueIO[ListSchemaVersionsResponse] =
    FF.liftF(ListSchemaVersionsOp(request))

  def listSchemas(
    request: ListSchemasRequest
  ): GlueIO[ListSchemasResponse] =
    FF.liftF(ListSchemasOp(request))

  def listTriggers(
    request: ListTriggersRequest
  ): GlueIO[ListTriggersResponse] =
    FF.liftF(ListTriggersOp(request))

  def listWorkflows(
    request: ListWorkflowsRequest
  ): GlueIO[ListWorkflowsResponse] =
    FF.liftF(ListWorkflowsOp(request))

  def putDataCatalogEncryptionSettings(
    request: PutDataCatalogEncryptionSettingsRequest
  ): GlueIO[PutDataCatalogEncryptionSettingsResponse] =
    FF.liftF(PutDataCatalogEncryptionSettingsOp(request))

  def putResourcePolicy(
    request: PutResourcePolicyRequest
  ): GlueIO[PutResourcePolicyResponse] =
    FF.liftF(PutResourcePolicyOp(request))

  def putSchemaVersionMetadata(
    request: PutSchemaVersionMetadataRequest
  ): GlueIO[PutSchemaVersionMetadataResponse] =
    FF.liftF(PutSchemaVersionMetadataOp(request))

  def putWorkflowRunProperties(
    request: PutWorkflowRunPropertiesRequest
  ): GlueIO[PutWorkflowRunPropertiesResponse] =
    FF.liftF(PutWorkflowRunPropertiesOp(request))

  def querySchemaVersionMetadata(
    request: QuerySchemaVersionMetadataRequest
  ): GlueIO[QuerySchemaVersionMetadataResponse] =
    FF.liftF(QuerySchemaVersionMetadataOp(request))

  def registerSchemaVersion(
    request: RegisterSchemaVersionRequest
  ): GlueIO[RegisterSchemaVersionResponse] =
    FF.liftF(RegisterSchemaVersionOp(request))

  def removeSchemaVersionMetadata(
    request: RemoveSchemaVersionMetadataRequest
  ): GlueIO[RemoveSchemaVersionMetadataResponse] =
    FF.liftF(RemoveSchemaVersionMetadataOp(request))

  def resetJobBookmark(
    request: ResetJobBookmarkRequest
  ): GlueIO[ResetJobBookmarkResponse] =
    FF.liftF(ResetJobBookmarkOp(request))

  def resumeWorkflowRun(
    request: ResumeWorkflowRunRequest
  ): GlueIO[ResumeWorkflowRunResponse] =
    FF.liftF(ResumeWorkflowRunOp(request))

  def searchTables(
    request: SearchTablesRequest
  ): GlueIO[SearchTablesResponse] =
    FF.liftF(SearchTablesOp(request))

  def startCrawler(
    request: StartCrawlerRequest
  ): GlueIO[StartCrawlerResponse] =
    FF.liftF(StartCrawlerOp(request))

  def startCrawlerSchedule(
    request: StartCrawlerScheduleRequest
  ): GlueIO[StartCrawlerScheduleResponse] =
    FF.liftF(StartCrawlerScheduleOp(request))

  def startExportLabelsTaskRun(
    request: StartExportLabelsTaskRunRequest
  ): GlueIO[StartExportLabelsTaskRunResponse] =
    FF.liftF(StartExportLabelsTaskRunOp(request))

  def startImportLabelsTaskRun(
    request: StartImportLabelsTaskRunRequest
  ): GlueIO[StartImportLabelsTaskRunResponse] =
    FF.liftF(StartImportLabelsTaskRunOp(request))

  def startJobRun(
    request: StartJobRunRequest
  ): GlueIO[StartJobRunResponse] =
    FF.liftF(StartJobRunOp(request))

  def startMLEvaluationTaskRun(
    request: StartMlEvaluationTaskRunRequest
  ): GlueIO[StartMlEvaluationTaskRunResponse] =
    FF.liftF(StartMLEvaluationTaskRunOp(request))

  def startMLLabelingSetGenerationTaskRun(
    request: StartMlLabelingSetGenerationTaskRunRequest
  ): GlueIO[StartMlLabelingSetGenerationTaskRunResponse] =
    FF.liftF(StartMLLabelingSetGenerationTaskRunOp(request))

  def startTrigger(
    request: StartTriggerRequest
  ): GlueIO[StartTriggerResponse] =
    FF.liftF(StartTriggerOp(request))

  def startWorkflowRun(
    request: StartWorkflowRunRequest
  ): GlueIO[StartWorkflowRunResponse] =
    FF.liftF(StartWorkflowRunOp(request))

  def stopCrawler(
    request: StopCrawlerRequest
  ): GlueIO[StopCrawlerResponse] =
    FF.liftF(StopCrawlerOp(request))

  def stopCrawlerSchedule(
    request: StopCrawlerScheduleRequest
  ): GlueIO[StopCrawlerScheduleResponse] =
    FF.liftF(StopCrawlerScheduleOp(request))

  def stopTrigger(
    request: StopTriggerRequest
  ): GlueIO[StopTriggerResponse] =
    FF.liftF(StopTriggerOp(request))

  def stopWorkflowRun(
    request: StopWorkflowRunRequest
  ): GlueIO[StopWorkflowRunResponse] =
    FF.liftF(StopWorkflowRunOp(request))

  def tagResource(
    request: TagResourceRequest
  ): GlueIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): GlueIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateClassifier(
    request: UpdateClassifierRequest
  ): GlueIO[UpdateClassifierResponse] =
    FF.liftF(UpdateClassifierOp(request))

  def updateColumnStatisticsForPartition(
    request: UpdateColumnStatisticsForPartitionRequest
  ): GlueIO[UpdateColumnStatisticsForPartitionResponse] =
    FF.liftF(UpdateColumnStatisticsForPartitionOp(request))

  def updateColumnStatisticsForTable(
    request: UpdateColumnStatisticsForTableRequest
  ): GlueIO[UpdateColumnStatisticsForTableResponse] =
    FF.liftF(UpdateColumnStatisticsForTableOp(request))

  def updateConnection(
    request: UpdateConnectionRequest
  ): GlueIO[UpdateConnectionResponse] =
    FF.liftF(UpdateConnectionOp(request))

  def updateCrawler(
    request: UpdateCrawlerRequest
  ): GlueIO[UpdateCrawlerResponse] =
    FF.liftF(UpdateCrawlerOp(request))

  def updateCrawlerSchedule(
    request: UpdateCrawlerScheduleRequest
  ): GlueIO[UpdateCrawlerScheduleResponse] =
    FF.liftF(UpdateCrawlerScheduleOp(request))

  def updateDatabase(
    request: UpdateDatabaseRequest
  ): GlueIO[UpdateDatabaseResponse] =
    FF.liftF(UpdateDatabaseOp(request))

  def updateDevEndpoint(
    request: UpdateDevEndpointRequest
  ): GlueIO[UpdateDevEndpointResponse] =
    FF.liftF(UpdateDevEndpointOp(request))

  def updateJob(
    request: UpdateJobRequest
  ): GlueIO[UpdateJobResponse] =
    FF.liftF(UpdateJobOp(request))

  def updateMLTransform(
    request: UpdateMlTransformRequest
  ): GlueIO[UpdateMlTransformResponse] =
    FF.liftF(UpdateMLTransformOp(request))

  def updatePartition(
    request: UpdatePartitionRequest
  ): GlueIO[UpdatePartitionResponse] =
    FF.liftF(UpdatePartitionOp(request))

  def updateRegistry(
    request: UpdateRegistryRequest
  ): GlueIO[UpdateRegistryResponse] =
    FF.liftF(UpdateRegistryOp(request))

  def updateSchema(
    request: UpdateSchemaRequest
  ): GlueIO[UpdateSchemaResponse] =
    FF.liftF(UpdateSchemaOp(request))

  def updateTable(
    request: UpdateTableRequest
  ): GlueIO[UpdateTableResponse] =
    FF.liftF(UpdateTableOp(request))

  def updateTrigger(
    request: UpdateTriggerRequest
  ): GlueIO[UpdateTriggerResponse] =
    FF.liftF(UpdateTriggerOp(request))

  def updateUserDefinedFunction(
    request: UpdateUserDefinedFunctionRequest
  ): GlueIO[UpdateUserDefinedFunctionResponse] =
    FF.liftF(UpdateUserDefinedFunctionOp(request))

  def updateWorkflow(
    request: UpdateWorkflowRequest
  ): GlueIO[UpdateWorkflowResponse] =
    FF.liftF(UpdateWorkflowOp(request))
}
