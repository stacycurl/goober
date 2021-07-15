package goober.hi

import goober.free.sagemaker.SageMakerIO
import software.amazon.awssdk.services.sagemaker.model._


object sagemaker {
  import goober.free.{sagemaker ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AddAssociationRequest
    // AddTagsRequest
    // AssociateTrialComponentRequest
    // CreateActionRequest
    // CreateAlgorithmRequest
    // CreateAppRequest
    // CreateAppImageConfigRequest
    // CreateArtifactRequest
    // CreateAutoMlJobRequest
    // CreateCodeRepositoryRequest
    // CreateCompilationJobRequest
    // CreateContextRequest
    // CreateDataQualityJobDefinitionRequest
    // CreateDeviceFleetRequest
    // CreateDomainRequest
    // CreateEdgePackagingJobRequest
    // CreateEndpointRequest
    // CreateEndpointConfigRequest
    // CreateExperimentRequest
    // CreateFeatureGroupRequest
    // CreateFlowDefinitionRequest
    // CreateHumanTaskUiRequest
    // CreateHyperParameterTuningJobRequest
    // CreateImageRequest
    // CreateImageVersionRequest
    // CreateLabelingJobRequest
    // CreateModelRequest
    // CreateModelBiasJobDefinitionRequest
    // CreateModelExplainabilityJobDefinitionRequest
    // CreateModelPackageRequest
    // CreateModelPackageGroupRequest
    // CreateModelQualityJobDefinitionRequest
    // CreateMonitoringScheduleRequest
    // CreateNotebookInstanceRequest
    // CreateNotebookInstanceLifecycleConfigRequest
    // CreatePipelineRequest
    // CreatePresignedDomainUrlRequest
    // CreatePresignedNotebookInstanceUrlRequest
    // CreateProcessingJobRequest
    // CreateProjectRequest
    // CreateTrainingJobRequest
    // CreateTransformJobRequest
    // CreateTrialRequest
    // CreateTrialComponentRequest
    // CreateUserProfileRequest
    // CreateWorkforceRequest
    // CreateWorkteamRequest
    // DeleteActionRequest
    // DeleteAlgorithmRequest
    // DeleteAppRequest
    // DeleteAppImageConfigRequest
    // DeleteArtifactRequest
    // DeleteAssociationRequest
    // DeleteCodeRepositoryRequest
    // DeleteContextRequest
    // DeleteDataQualityJobDefinitionRequest
    // DeleteDeviceFleetRequest
    // DeleteDomainRequest
    // DeleteEndpointRequest
    // DeleteEndpointConfigRequest
    // DeleteExperimentRequest
    // DeleteFeatureGroupRequest
    // DeleteFlowDefinitionRequest
    // DeleteHumanTaskUiRequest
    // DeleteImageRequest
    // DeleteImageVersionRequest
    // DeleteModelRequest
    // DeleteModelBiasJobDefinitionRequest
    // DeleteModelExplainabilityJobDefinitionRequest
    // DeleteModelPackageRequest
    // DeleteModelPackageGroupRequest
    // DeleteModelPackageGroupPolicyRequest
    // DeleteModelQualityJobDefinitionRequest
    // DeleteMonitoringScheduleRequest
    // DeleteNotebookInstanceRequest
    // DeleteNotebookInstanceLifecycleConfigRequest
    // DeletePipelineRequest
    // DeleteProjectRequest
    // DeleteTagsRequest
    // DeleteTrialRequest
    // DeleteTrialComponentRequest
    // DeleteUserProfileRequest
    // DeleteWorkforceRequest
    // DeleteWorkteamRequest
    // DeregisterDevicesRequest
    // DescribeActionRequest
    // DescribeAlgorithmRequest
    // DescribeAppRequest
    // DescribeAppImageConfigRequest
    // DescribeArtifactRequest
    // DescribeAutoMlJobRequest
    // DescribeCodeRepositoryRequest
    // DescribeCompilationJobRequest
    // DescribeContextRequest
    // DescribeDataQualityJobDefinitionRequest
    // DescribeDeviceRequest
    // DescribeDeviceFleetRequest
    // DescribeDomainRequest
    // DescribeEdgePackagingJobRequest
    // DescribeEndpointRequest
    // DescribeEndpointConfigRequest
    // DescribeExperimentRequest
    // DescribeFeatureGroupRequest
    // DescribeFlowDefinitionRequest
    // DescribeHumanTaskUiRequest
    // DescribeHyperParameterTuningJobRequest
    // DescribeImageRequest
    // DescribeImageVersionRequest
    // DescribeLabelingJobRequest
    // DescribeModelRequest
    // DescribeModelBiasJobDefinitionRequest
    // DescribeModelExplainabilityJobDefinitionRequest
    // DescribeModelPackageRequest
    // DescribeModelPackageGroupRequest
    // DescribeModelQualityJobDefinitionRequest
    // DescribeMonitoringScheduleRequest
    // DescribeNotebookInstanceRequest
    // DescribeNotebookInstanceLifecycleConfigRequest
    // DescribePipelineRequest
    // DescribePipelineDefinitionForExecutionRequest
    // DescribePipelineExecutionRequest
    // DescribeProcessingJobRequest
    // DescribeProjectRequest
    // DescribeSubscribedWorkteamRequest
    // DescribeTrainingJobRequest
    // DescribeTransformJobRequest
    // DescribeTrialRequest
    // DescribeTrialComponentRequest
    // DescribeUserProfileRequest
    // DescribeWorkforceRequest
    // DescribeWorkteamRequest
    // DisableSagemakerServicecatalogPortfolioRequest
    // DisassociateTrialComponentRequest
    // EnableSagemakerServicecatalogPortfolioRequest
    // GetDeviceFleetReportRequest
    // GetModelPackageGroupPolicyRequest
    // GetSagemakerServicecatalogPortfolioStatusRequest
    // GetSearchSuggestionsRequest
    // ListActionsRequest
    // ListAlgorithmsRequest
    // ListAppImageConfigsRequest
    // ListAppsRequest
    // ListArtifactsRequest
    // ListAssociationsRequest
    // ListAutoMlJobsRequest
    // ListCandidatesForAutoMlJobRequest
    // ListCodeRepositoriesRequest
    // ListCompilationJobsRequest
    // ListContextsRequest
    // ListDataQualityJobDefinitionsRequest
    // ListDeviceFleetsRequest
    // ListDevicesRequest
    // ListDomainsRequest
    // ListEdgePackagingJobsRequest
    // ListEndpointConfigsRequest
    // ListEndpointsRequest
    // ListExperimentsRequest
    // ListFeatureGroupsRequest
    // ListFlowDefinitionsRequest
    // ListHumanTaskUisRequest
    // ListHyperParameterTuningJobsRequest
    // ListImageVersionsRequest
    // ListImagesRequest
    // ListLabelingJobsRequest
    // ListLabelingJobsForWorkteamRequest
    // ListModelBiasJobDefinitionsRequest
    // ListModelExplainabilityJobDefinitionsRequest
    // ListModelPackageGroupsRequest
    // ListModelPackagesRequest
    // ListModelQualityJobDefinitionsRequest
    // ListModelsRequest
    // ListMonitoringExecutionsRequest
    // ListMonitoringSchedulesRequest
    // ListNotebookInstanceLifecycleConfigsRequest
    // ListNotebookInstancesRequest
    // ListPipelineExecutionStepsRequest
    // ListPipelineExecutionsRequest
    // ListPipelineParametersForExecutionRequest
    // ListPipelinesRequest
    // ListProcessingJobsRequest
    // ListProjectsRequest
    // ListSubscribedWorkteamsRequest
    // ListTagsRequest
    // ListTrainingJobsRequest
    // ListTrainingJobsForHyperParameterTuningJobRequest
    // ListTransformJobsRequest
    // ListTrialComponentsRequest
    // ListTrialsRequest
    // ListUserProfilesRequest
    // ListWorkforcesRequest
    // ListWorkteamsRequest
    // PutModelPackageGroupPolicyRequest
    // RegisterDevicesRequest
    // RenderUiTemplateRequest
    // SearchRequest
    // SendPipelineExecutionStepFailureRequest
    // SendPipelineExecutionStepSuccessRequest
    // StartMonitoringScheduleRequest
    // StartNotebookInstanceRequest
    // StartPipelineExecutionRequest
    // StopAutoMlJobRequest
    // StopCompilationJobRequest
    // StopEdgePackagingJobRequest
    // StopHyperParameterTuningJobRequest
    // StopLabelingJobRequest
    // StopMonitoringScheduleRequest
    // StopNotebookInstanceRequest
    // StopPipelineExecutionRequest
    // StopProcessingJobRequest
    // StopTrainingJobRequest
    // StopTransformJobRequest
    // UpdateActionRequest
    // UpdateAppImageConfigRequest
    // UpdateArtifactRequest
    // UpdateCodeRepositoryRequest
    // UpdateContextRequest
    // UpdateDeviceFleetRequest
    // UpdateDevicesRequest
    // UpdateDomainRequest
    // UpdateEndpointRequest
    // UpdateEndpointWeightsAndCapacitiesRequest
    // UpdateExperimentRequest
    // UpdateImageRequest
    // UpdateModelPackageRequest
    // UpdateMonitoringScheduleRequest
    // UpdateNotebookInstanceRequest
    // UpdateNotebookInstanceLifecycleConfigRequest
    // UpdatePipelineRequest
    // UpdatePipelineExecutionRequest
    // UpdateTrainingJobRequest
    // UpdateTrialRequest
    // UpdateTrialComponentRequest
    // UpdateUserProfileRequest
    // UpdateWorkforceRequest
    // UpdateWorkteamRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
