package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sagemaker.SageMakerClient
import software.amazon.awssdk.services.sagemaker.model._


object sagemaker { module =>

  // Free monad over SageMakerOp
  type SageMakerIO[A] = FF[SageMakerOp, A]

  sealed trait SageMakerOp[A] {
    def visit[F[_]](visitor: SageMakerOp.Visitor[F]): F[A]
  }

  object SageMakerOp {
    // Given a SageMakerClient we can embed a SageMakerIO program in any algebra that understands embedding.
    implicit val SageMakerOpEmbeddable: Embeddable[SageMakerOp, SageMakerClient] = new Embeddable[SageMakerOp, SageMakerClient] {
      def embed[A](client: SageMakerClient, io: SageMakerIO[A]): Embedded[A] = Embedded.SageMaker(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SageMakerOp.Visitor[Kleisli[M, SageMakerClient, *]] {
        def addAssociation(
          request: AddAssociationRequest
        ): Kleisli[M, SageMakerClient, AddAssociationResponse] =
          primitive(_.addAssociation(request))

        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, SageMakerClient, AddTagsResponse] =
          primitive(_.addTags(request))

        def associateTrialComponent(
          request: AssociateTrialComponentRequest
        ): Kleisli[M, SageMakerClient, AssociateTrialComponentResponse] =
          primitive(_.associateTrialComponent(request))

        def createAction(
          request: CreateActionRequest
        ): Kleisli[M, SageMakerClient, CreateActionResponse] =
          primitive(_.createAction(request))

        def createAlgorithm(
          request: CreateAlgorithmRequest
        ): Kleisli[M, SageMakerClient, CreateAlgorithmResponse] =
          primitive(_.createAlgorithm(request))

        def createApp(
          request: CreateAppRequest
        ): Kleisli[M, SageMakerClient, CreateAppResponse] =
          primitive(_.createApp(request))

        def createAppImageConfig(
          request: CreateAppImageConfigRequest
        ): Kleisli[M, SageMakerClient, CreateAppImageConfigResponse] =
          primitive(_.createAppImageConfig(request))

        def createArtifact(
          request: CreateArtifactRequest
        ): Kleisli[M, SageMakerClient, CreateArtifactResponse] =
          primitive(_.createArtifact(request))

        def createAutoMLJob(
          request: CreateAutoMlJobRequest
        ): Kleisli[M, SageMakerClient, CreateAutoMlJobResponse] =
          primitive(_.createAutoMLJob(request))

        def createCodeRepository(
          request: CreateCodeRepositoryRequest
        ): Kleisli[M, SageMakerClient, CreateCodeRepositoryResponse] =
          primitive(_.createCodeRepository(request))

        def createCompilationJob(
          request: CreateCompilationJobRequest
        ): Kleisli[M, SageMakerClient, CreateCompilationJobResponse] =
          primitive(_.createCompilationJob(request))

        def createContext(
          request: CreateContextRequest
        ): Kleisli[M, SageMakerClient, CreateContextResponse] =
          primitive(_.createContext(request))

        def createDataQualityJobDefinition(
          request: CreateDataQualityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, CreateDataQualityJobDefinitionResponse] =
          primitive(_.createDataQualityJobDefinition(request))

        def createDeviceFleet(
          request: CreateDeviceFleetRequest
        ): Kleisli[M, SageMakerClient, CreateDeviceFleetResponse] =
          primitive(_.createDeviceFleet(request))

        def createDomain(
          request: CreateDomainRequest
        ): Kleisli[M, SageMakerClient, CreateDomainResponse] =
          primitive(_.createDomain(request))

        def createEdgePackagingJob(
          request: CreateEdgePackagingJobRequest
        ): Kleisli[M, SageMakerClient, CreateEdgePackagingJobResponse] =
          primitive(_.createEdgePackagingJob(request))

        def createEndpoint(
          request: CreateEndpointRequest
        ): Kleisli[M, SageMakerClient, CreateEndpointResponse] =
          primitive(_.createEndpoint(request))

        def createEndpointConfig(
          request: CreateEndpointConfigRequest
        ): Kleisli[M, SageMakerClient, CreateEndpointConfigResponse] =
          primitive(_.createEndpointConfig(request))

        def createExperiment(
          request: CreateExperimentRequest
        ): Kleisli[M, SageMakerClient, CreateExperimentResponse] =
          primitive(_.createExperiment(request))

        def createFeatureGroup(
          request: CreateFeatureGroupRequest
        ): Kleisli[M, SageMakerClient, CreateFeatureGroupResponse] =
          primitive(_.createFeatureGroup(request))

        def createFlowDefinition(
          request: CreateFlowDefinitionRequest
        ): Kleisli[M, SageMakerClient, CreateFlowDefinitionResponse] =
          primitive(_.createFlowDefinition(request))

        def createHumanTaskUi(
          request: CreateHumanTaskUiRequest
        ): Kleisli[M, SageMakerClient, CreateHumanTaskUiResponse] =
          primitive(_.createHumanTaskUi(request))

        def createHyperParameterTuningJob(
          request: CreateHyperParameterTuningJobRequest
        ): Kleisli[M, SageMakerClient, CreateHyperParameterTuningJobResponse] =
          primitive(_.createHyperParameterTuningJob(request))

        def createImage(
          request: CreateImageRequest
        ): Kleisli[M, SageMakerClient, CreateImageResponse] =
          primitive(_.createImage(request))

        def createImageVersion(
          request: CreateImageVersionRequest
        ): Kleisli[M, SageMakerClient, CreateImageVersionResponse] =
          primitive(_.createImageVersion(request))

        def createLabelingJob(
          request: CreateLabelingJobRequest
        ): Kleisli[M, SageMakerClient, CreateLabelingJobResponse] =
          primitive(_.createLabelingJob(request))

        def createModel(
          request: CreateModelRequest
        ): Kleisli[M, SageMakerClient, CreateModelResponse] =
          primitive(_.createModel(request))

        def createModelBiasJobDefinition(
          request: CreateModelBiasJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, CreateModelBiasJobDefinitionResponse] =
          primitive(_.createModelBiasJobDefinition(request))

        def createModelExplainabilityJobDefinition(
          request: CreateModelExplainabilityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, CreateModelExplainabilityJobDefinitionResponse] =
          primitive(_.createModelExplainabilityJobDefinition(request))

        def createModelPackage(
          request: CreateModelPackageRequest
        ): Kleisli[M, SageMakerClient, CreateModelPackageResponse] =
          primitive(_.createModelPackage(request))

        def createModelPackageGroup(
          request: CreateModelPackageGroupRequest
        ): Kleisli[M, SageMakerClient, CreateModelPackageGroupResponse] =
          primitive(_.createModelPackageGroup(request))

        def createModelQualityJobDefinition(
          request: CreateModelQualityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, CreateModelQualityJobDefinitionResponse] =
          primitive(_.createModelQualityJobDefinition(request))

        def createMonitoringSchedule(
          request: CreateMonitoringScheduleRequest
        ): Kleisli[M, SageMakerClient, CreateMonitoringScheduleResponse] =
          primitive(_.createMonitoringSchedule(request))

        def createNotebookInstance(
          request: CreateNotebookInstanceRequest
        ): Kleisli[M, SageMakerClient, CreateNotebookInstanceResponse] =
          primitive(_.createNotebookInstance(request))

        def createNotebookInstanceLifecycleConfig(
          request: CreateNotebookInstanceLifecycleConfigRequest
        ): Kleisli[M, SageMakerClient, CreateNotebookInstanceLifecycleConfigResponse] =
          primitive(_.createNotebookInstanceLifecycleConfig(request))

        def createPipeline(
          request: CreatePipelineRequest
        ): Kleisli[M, SageMakerClient, CreatePipelineResponse] =
          primitive(_.createPipeline(request))

        def createPresignedDomainUrl(
          request: CreatePresignedDomainUrlRequest
        ): Kleisli[M, SageMakerClient, CreatePresignedDomainUrlResponse] =
          primitive(_.createPresignedDomainUrl(request))

        def createPresignedNotebookInstanceUrl(
          request: CreatePresignedNotebookInstanceUrlRequest
        ): Kleisli[M, SageMakerClient, CreatePresignedNotebookInstanceUrlResponse] =
          primitive(_.createPresignedNotebookInstanceUrl(request))

        def createProcessingJob(
          request: CreateProcessingJobRequest
        ): Kleisli[M, SageMakerClient, CreateProcessingJobResponse] =
          primitive(_.createProcessingJob(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, SageMakerClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def createTrainingJob(
          request: CreateTrainingJobRequest
        ): Kleisli[M, SageMakerClient, CreateTrainingJobResponse] =
          primitive(_.createTrainingJob(request))

        def createTransformJob(
          request: CreateTransformJobRequest
        ): Kleisli[M, SageMakerClient, CreateTransformJobResponse] =
          primitive(_.createTransformJob(request))

        def createTrial(
          request: CreateTrialRequest
        ): Kleisli[M, SageMakerClient, CreateTrialResponse] =
          primitive(_.createTrial(request))

        def createTrialComponent(
          request: CreateTrialComponentRequest
        ): Kleisli[M, SageMakerClient, CreateTrialComponentResponse] =
          primitive(_.createTrialComponent(request))

        def createUserProfile(
          request: CreateUserProfileRequest
        ): Kleisli[M, SageMakerClient, CreateUserProfileResponse] =
          primitive(_.createUserProfile(request))

        def createWorkforce(
          request: CreateWorkforceRequest
        ): Kleisli[M, SageMakerClient, CreateWorkforceResponse] =
          primitive(_.createWorkforce(request))

        def createWorkteam(
          request: CreateWorkteamRequest
        ): Kleisli[M, SageMakerClient, CreateWorkteamResponse] =
          primitive(_.createWorkteam(request))

        def deleteAction(
          request: DeleteActionRequest
        ): Kleisli[M, SageMakerClient, DeleteActionResponse] =
          primitive(_.deleteAction(request))

        def deleteAlgorithm(
          request: DeleteAlgorithmRequest
        ): Kleisli[M, SageMakerClient, DeleteAlgorithmResponse] =
          primitive(_.deleteAlgorithm(request))

        def deleteApp(
          request: DeleteAppRequest
        ): Kleisli[M, SageMakerClient, DeleteAppResponse] =
          primitive(_.deleteApp(request))

        def deleteAppImageConfig(
          request: DeleteAppImageConfigRequest
        ): Kleisli[M, SageMakerClient, DeleteAppImageConfigResponse] =
          primitive(_.deleteAppImageConfig(request))

        def deleteArtifact(
          request: DeleteArtifactRequest
        ): Kleisli[M, SageMakerClient, DeleteArtifactResponse] =
          primitive(_.deleteArtifact(request))

        def deleteAssociation(
          request: DeleteAssociationRequest
        ): Kleisli[M, SageMakerClient, DeleteAssociationResponse] =
          primitive(_.deleteAssociation(request))

        def deleteCodeRepository(
          request: DeleteCodeRepositoryRequest
        ): Kleisli[M, SageMakerClient, DeleteCodeRepositoryResponse] =
          primitive(_.deleteCodeRepository(request))

        def deleteContext(
          request: DeleteContextRequest
        ): Kleisli[M, SageMakerClient, DeleteContextResponse] =
          primitive(_.deleteContext(request))

        def deleteDataQualityJobDefinition(
          request: DeleteDataQualityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DeleteDataQualityJobDefinitionResponse] =
          primitive(_.deleteDataQualityJobDefinition(request))

        def deleteDeviceFleet(
          request: DeleteDeviceFleetRequest
        ): Kleisli[M, SageMakerClient, DeleteDeviceFleetResponse] =
          primitive(_.deleteDeviceFleet(request))

        def deleteDomain(
          request: DeleteDomainRequest
        ): Kleisli[M, SageMakerClient, DeleteDomainResponse] =
          primitive(_.deleteDomain(request))

        def deleteEndpoint(
          request: DeleteEndpointRequest
        ): Kleisli[M, SageMakerClient, DeleteEndpointResponse] =
          primitive(_.deleteEndpoint(request))

        def deleteEndpointConfig(
          request: DeleteEndpointConfigRequest
        ): Kleisli[M, SageMakerClient, DeleteEndpointConfigResponse] =
          primitive(_.deleteEndpointConfig(request))

        def deleteExperiment(
          request: DeleteExperimentRequest
        ): Kleisli[M, SageMakerClient, DeleteExperimentResponse] =
          primitive(_.deleteExperiment(request))

        def deleteFeatureGroup(
          request: DeleteFeatureGroupRequest
        ): Kleisli[M, SageMakerClient, DeleteFeatureGroupResponse] =
          primitive(_.deleteFeatureGroup(request))

        def deleteFlowDefinition(
          request: DeleteFlowDefinitionRequest
        ): Kleisli[M, SageMakerClient, DeleteFlowDefinitionResponse] =
          primitive(_.deleteFlowDefinition(request))

        def deleteHumanTaskUi(
          request: DeleteHumanTaskUiRequest
        ): Kleisli[M, SageMakerClient, DeleteHumanTaskUiResponse] =
          primitive(_.deleteHumanTaskUi(request))

        def deleteImage(
          request: DeleteImageRequest
        ): Kleisli[M, SageMakerClient, DeleteImageResponse] =
          primitive(_.deleteImage(request))

        def deleteImageVersion(
          request: DeleteImageVersionRequest
        ): Kleisli[M, SageMakerClient, DeleteImageVersionResponse] =
          primitive(_.deleteImageVersion(request))

        def deleteModel(
          request: DeleteModelRequest
        ): Kleisli[M, SageMakerClient, DeleteModelResponse] =
          primitive(_.deleteModel(request))

        def deleteModelBiasJobDefinition(
          request: DeleteModelBiasJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DeleteModelBiasJobDefinitionResponse] =
          primitive(_.deleteModelBiasJobDefinition(request))

        def deleteModelExplainabilityJobDefinition(
          request: DeleteModelExplainabilityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DeleteModelExplainabilityJobDefinitionResponse] =
          primitive(_.deleteModelExplainabilityJobDefinition(request))

        def deleteModelPackage(
          request: DeleteModelPackageRequest
        ): Kleisli[M, SageMakerClient, DeleteModelPackageResponse] =
          primitive(_.deleteModelPackage(request))

        def deleteModelPackageGroup(
          request: DeleteModelPackageGroupRequest
        ): Kleisli[M, SageMakerClient, DeleteModelPackageGroupResponse] =
          primitive(_.deleteModelPackageGroup(request))

        def deleteModelPackageGroupPolicy(
          request: DeleteModelPackageGroupPolicyRequest
        ): Kleisli[M, SageMakerClient, DeleteModelPackageGroupPolicyResponse] =
          primitive(_.deleteModelPackageGroupPolicy(request))

        def deleteModelQualityJobDefinition(
          request: DeleteModelQualityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DeleteModelQualityJobDefinitionResponse] =
          primitive(_.deleteModelQualityJobDefinition(request))

        def deleteMonitoringSchedule(
          request: DeleteMonitoringScheduleRequest
        ): Kleisli[M, SageMakerClient, DeleteMonitoringScheduleResponse] =
          primitive(_.deleteMonitoringSchedule(request))

        def deleteNotebookInstance(
          request: DeleteNotebookInstanceRequest
        ): Kleisli[M, SageMakerClient, DeleteNotebookInstanceResponse] =
          primitive(_.deleteNotebookInstance(request))

        def deleteNotebookInstanceLifecycleConfig(
          request: DeleteNotebookInstanceLifecycleConfigRequest
        ): Kleisli[M, SageMakerClient, DeleteNotebookInstanceLifecycleConfigResponse] =
          primitive(_.deleteNotebookInstanceLifecycleConfig(request))

        def deletePipeline(
          request: DeletePipelineRequest
        ): Kleisli[M, SageMakerClient, DeletePipelineResponse] =
          primitive(_.deletePipeline(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, SageMakerClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, SageMakerClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def deleteTrial(
          request: DeleteTrialRequest
        ): Kleisli[M, SageMakerClient, DeleteTrialResponse] =
          primitive(_.deleteTrial(request))

        def deleteTrialComponent(
          request: DeleteTrialComponentRequest
        ): Kleisli[M, SageMakerClient, DeleteTrialComponentResponse] =
          primitive(_.deleteTrialComponent(request))

        def deleteUserProfile(
          request: DeleteUserProfileRequest
        ): Kleisli[M, SageMakerClient, DeleteUserProfileResponse] =
          primitive(_.deleteUserProfile(request))

        def deleteWorkforce(
          request: DeleteWorkforceRequest
        ): Kleisli[M, SageMakerClient, DeleteWorkforceResponse] =
          primitive(_.deleteWorkforce(request))

        def deleteWorkteam(
          request: DeleteWorkteamRequest
        ): Kleisli[M, SageMakerClient, DeleteWorkteamResponse] =
          primitive(_.deleteWorkteam(request))

        def deregisterDevices(
          request: DeregisterDevicesRequest
        ): Kleisli[M, SageMakerClient, DeregisterDevicesResponse] =
          primitive(_.deregisterDevices(request))

        def describeAction(
          request: DescribeActionRequest
        ): Kleisli[M, SageMakerClient, DescribeActionResponse] =
          primitive(_.describeAction(request))

        def describeAlgorithm(
          request: DescribeAlgorithmRequest
        ): Kleisli[M, SageMakerClient, DescribeAlgorithmResponse] =
          primitive(_.describeAlgorithm(request))

        def describeApp(
          request: DescribeAppRequest
        ): Kleisli[M, SageMakerClient, DescribeAppResponse] =
          primitive(_.describeApp(request))

        def describeAppImageConfig(
          request: DescribeAppImageConfigRequest
        ): Kleisli[M, SageMakerClient, DescribeAppImageConfigResponse] =
          primitive(_.describeAppImageConfig(request))

        def describeArtifact(
          request: DescribeArtifactRequest
        ): Kleisli[M, SageMakerClient, DescribeArtifactResponse] =
          primitive(_.describeArtifact(request))

        def describeAutoMLJob(
          request: DescribeAutoMlJobRequest
        ): Kleisli[M, SageMakerClient, DescribeAutoMlJobResponse] =
          primitive(_.describeAutoMLJob(request))

        def describeCodeRepository(
          request: DescribeCodeRepositoryRequest
        ): Kleisli[M, SageMakerClient, DescribeCodeRepositoryResponse] =
          primitive(_.describeCodeRepository(request))

        def describeCompilationJob(
          request: DescribeCompilationJobRequest
        ): Kleisli[M, SageMakerClient, DescribeCompilationJobResponse] =
          primitive(_.describeCompilationJob(request))

        def describeContext(
          request: DescribeContextRequest
        ): Kleisli[M, SageMakerClient, DescribeContextResponse] =
          primitive(_.describeContext(request))

        def describeDataQualityJobDefinition(
          request: DescribeDataQualityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DescribeDataQualityJobDefinitionResponse] =
          primitive(_.describeDataQualityJobDefinition(request))

        def describeDevice(
          request: DescribeDeviceRequest
        ): Kleisli[M, SageMakerClient, DescribeDeviceResponse] =
          primitive(_.describeDevice(request))

        def describeDeviceFleet(
          request: DescribeDeviceFleetRequest
        ): Kleisli[M, SageMakerClient, DescribeDeviceFleetResponse] =
          primitive(_.describeDeviceFleet(request))

        def describeDomain(
          request: DescribeDomainRequest
        ): Kleisli[M, SageMakerClient, DescribeDomainResponse] =
          primitive(_.describeDomain(request))

        def describeEdgePackagingJob(
          request: DescribeEdgePackagingJobRequest
        ): Kleisli[M, SageMakerClient, DescribeEdgePackagingJobResponse] =
          primitive(_.describeEdgePackagingJob(request))

        def describeEndpoint(
          request: DescribeEndpointRequest
        ): Kleisli[M, SageMakerClient, DescribeEndpointResponse] =
          primitive(_.describeEndpoint(request))

        def describeEndpointConfig(
          request: DescribeEndpointConfigRequest
        ): Kleisli[M, SageMakerClient, DescribeEndpointConfigResponse] =
          primitive(_.describeEndpointConfig(request))

        def describeExperiment(
          request: DescribeExperimentRequest
        ): Kleisli[M, SageMakerClient, DescribeExperimentResponse] =
          primitive(_.describeExperiment(request))

        def describeFeatureGroup(
          request: DescribeFeatureGroupRequest
        ): Kleisli[M, SageMakerClient, DescribeFeatureGroupResponse] =
          primitive(_.describeFeatureGroup(request))

        def describeFlowDefinition(
          request: DescribeFlowDefinitionRequest
        ): Kleisli[M, SageMakerClient, DescribeFlowDefinitionResponse] =
          primitive(_.describeFlowDefinition(request))

        def describeHumanTaskUi(
          request: DescribeHumanTaskUiRequest
        ): Kleisli[M, SageMakerClient, DescribeHumanTaskUiResponse] =
          primitive(_.describeHumanTaskUi(request))

        def describeHyperParameterTuningJob(
          request: DescribeHyperParameterTuningJobRequest
        ): Kleisli[M, SageMakerClient, DescribeHyperParameterTuningJobResponse] =
          primitive(_.describeHyperParameterTuningJob(request))

        def describeImage(
          request: DescribeImageRequest
        ): Kleisli[M, SageMakerClient, DescribeImageResponse] =
          primitive(_.describeImage(request))

        def describeImageVersion(
          request: DescribeImageVersionRequest
        ): Kleisli[M, SageMakerClient, DescribeImageVersionResponse] =
          primitive(_.describeImageVersion(request))

        def describeLabelingJob(
          request: DescribeLabelingJobRequest
        ): Kleisli[M, SageMakerClient, DescribeLabelingJobResponse] =
          primitive(_.describeLabelingJob(request))

        def describeModel(
          request: DescribeModelRequest
        ): Kleisli[M, SageMakerClient, DescribeModelResponse] =
          primitive(_.describeModel(request))

        def describeModelBiasJobDefinition(
          request: DescribeModelBiasJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DescribeModelBiasJobDefinitionResponse] =
          primitive(_.describeModelBiasJobDefinition(request))

        def describeModelExplainabilityJobDefinition(
          request: DescribeModelExplainabilityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DescribeModelExplainabilityJobDefinitionResponse] =
          primitive(_.describeModelExplainabilityJobDefinition(request))

        def describeModelPackage(
          request: DescribeModelPackageRequest
        ): Kleisli[M, SageMakerClient, DescribeModelPackageResponse] =
          primitive(_.describeModelPackage(request))

        def describeModelPackageGroup(
          request: DescribeModelPackageGroupRequest
        ): Kleisli[M, SageMakerClient, DescribeModelPackageGroupResponse] =
          primitive(_.describeModelPackageGroup(request))

        def describeModelQualityJobDefinition(
          request: DescribeModelQualityJobDefinitionRequest
        ): Kleisli[M, SageMakerClient, DescribeModelQualityJobDefinitionResponse] =
          primitive(_.describeModelQualityJobDefinition(request))

        def describeMonitoringSchedule(
          request: DescribeMonitoringScheduleRequest
        ): Kleisli[M, SageMakerClient, DescribeMonitoringScheduleResponse] =
          primitive(_.describeMonitoringSchedule(request))

        def describeNotebookInstance(
          request: DescribeNotebookInstanceRequest
        ): Kleisli[M, SageMakerClient, DescribeNotebookInstanceResponse] =
          primitive(_.describeNotebookInstance(request))

        def describeNotebookInstanceLifecycleConfig(
          request: DescribeNotebookInstanceLifecycleConfigRequest
        ): Kleisli[M, SageMakerClient, DescribeNotebookInstanceLifecycleConfigResponse] =
          primitive(_.describeNotebookInstanceLifecycleConfig(request))

        def describePipeline(
          request: DescribePipelineRequest
        ): Kleisli[M, SageMakerClient, DescribePipelineResponse] =
          primitive(_.describePipeline(request))

        def describePipelineDefinitionForExecution(
          request: DescribePipelineDefinitionForExecutionRequest
        ): Kleisli[M, SageMakerClient, DescribePipelineDefinitionForExecutionResponse] =
          primitive(_.describePipelineDefinitionForExecution(request))

        def describePipelineExecution(
          request: DescribePipelineExecutionRequest
        ): Kleisli[M, SageMakerClient, DescribePipelineExecutionResponse] =
          primitive(_.describePipelineExecution(request))

        def describeProcessingJob(
          request: DescribeProcessingJobRequest
        ): Kleisli[M, SageMakerClient, DescribeProcessingJobResponse] =
          primitive(_.describeProcessingJob(request))

        def describeProject(
          request: DescribeProjectRequest
        ): Kleisli[M, SageMakerClient, DescribeProjectResponse] =
          primitive(_.describeProject(request))

        def describeSubscribedWorkteam(
          request: DescribeSubscribedWorkteamRequest
        ): Kleisli[M, SageMakerClient, DescribeSubscribedWorkteamResponse] =
          primitive(_.describeSubscribedWorkteam(request))

        def describeTrainingJob(
          request: DescribeTrainingJobRequest
        ): Kleisli[M, SageMakerClient, DescribeTrainingJobResponse] =
          primitive(_.describeTrainingJob(request))

        def describeTransformJob(
          request: DescribeTransformJobRequest
        ): Kleisli[M, SageMakerClient, DescribeTransformJobResponse] =
          primitive(_.describeTransformJob(request))

        def describeTrial(
          request: DescribeTrialRequest
        ): Kleisli[M, SageMakerClient, DescribeTrialResponse] =
          primitive(_.describeTrial(request))

        def describeTrialComponent(
          request: DescribeTrialComponentRequest
        ): Kleisli[M, SageMakerClient, DescribeTrialComponentResponse] =
          primitive(_.describeTrialComponent(request))

        def describeUserProfile(
          request: DescribeUserProfileRequest
        ): Kleisli[M, SageMakerClient, DescribeUserProfileResponse] =
          primitive(_.describeUserProfile(request))

        def describeWorkforce(
          request: DescribeWorkforceRequest
        ): Kleisli[M, SageMakerClient, DescribeWorkforceResponse] =
          primitive(_.describeWorkforce(request))

        def describeWorkteam(
          request: DescribeWorkteamRequest
        ): Kleisli[M, SageMakerClient, DescribeWorkteamResponse] =
          primitive(_.describeWorkteam(request))

        def disableSagemakerServicecatalogPortfolio(
          request: DisableSagemakerServicecatalogPortfolioRequest
        ): Kleisli[M, SageMakerClient, DisableSagemakerServicecatalogPortfolioResponse] =
          primitive(_.disableSagemakerServicecatalogPortfolio(request))

        def disassociateTrialComponent(
          request: DisassociateTrialComponentRequest
        ): Kleisli[M, SageMakerClient, DisassociateTrialComponentResponse] =
          primitive(_.disassociateTrialComponent(request))

        def enableSagemakerServicecatalogPortfolio(
          request: EnableSagemakerServicecatalogPortfolioRequest
        ): Kleisli[M, SageMakerClient, EnableSagemakerServicecatalogPortfolioResponse] =
          primitive(_.enableSagemakerServicecatalogPortfolio(request))

        def getDeviceFleetReport(
          request: GetDeviceFleetReportRequest
        ): Kleisli[M, SageMakerClient, GetDeviceFleetReportResponse] =
          primitive(_.getDeviceFleetReport(request))

        def getModelPackageGroupPolicy(
          request: GetModelPackageGroupPolicyRequest
        ): Kleisli[M, SageMakerClient, GetModelPackageGroupPolicyResponse] =
          primitive(_.getModelPackageGroupPolicy(request))

        def getSagemakerServicecatalogPortfolioStatus(
          request: GetSagemakerServicecatalogPortfolioStatusRequest
        ): Kleisli[M, SageMakerClient, GetSagemakerServicecatalogPortfolioStatusResponse] =
          primitive(_.getSagemakerServicecatalogPortfolioStatus(request))

        def getSearchSuggestions(
          request: GetSearchSuggestionsRequest
        ): Kleisli[M, SageMakerClient, GetSearchSuggestionsResponse] =
          primitive(_.getSearchSuggestions(request))

        def listActions(
          request: ListActionsRequest
        ): Kleisli[M, SageMakerClient, ListActionsResponse] =
          primitive(_.listActions(request))

        def listAlgorithms(
          request: ListAlgorithmsRequest
        ): Kleisli[M, SageMakerClient, ListAlgorithmsResponse] =
          primitive(_.listAlgorithms(request))

        def listAppImageConfigs(
          request: ListAppImageConfigsRequest
        ): Kleisli[M, SageMakerClient, ListAppImageConfigsResponse] =
          primitive(_.listAppImageConfigs(request))

        def listApps(
          request: ListAppsRequest
        ): Kleisli[M, SageMakerClient, ListAppsResponse] =
          primitive(_.listApps(request))

        def listArtifacts(
          request: ListArtifactsRequest
        ): Kleisli[M, SageMakerClient, ListArtifactsResponse] =
          primitive(_.listArtifacts(request))

        def listAssociations(
          request: ListAssociationsRequest
        ): Kleisli[M, SageMakerClient, ListAssociationsResponse] =
          primitive(_.listAssociations(request))

        def listAutoMLJobs(
          request: ListAutoMlJobsRequest
        ): Kleisli[M, SageMakerClient, ListAutoMlJobsResponse] =
          primitive(_.listAutoMLJobs(request))

        def listCandidatesForAutoMLJob(
          request: ListCandidatesForAutoMlJobRequest
        ): Kleisli[M, SageMakerClient, ListCandidatesForAutoMlJobResponse] =
          primitive(_.listCandidatesForAutoMLJob(request))

        def listCodeRepositories(
          request: ListCodeRepositoriesRequest
        ): Kleisli[M, SageMakerClient, ListCodeRepositoriesResponse] =
          primitive(_.listCodeRepositories(request))

        def listCompilationJobs(
          request: ListCompilationJobsRequest
        ): Kleisli[M, SageMakerClient, ListCompilationJobsResponse] =
          primitive(_.listCompilationJobs(request))

        def listContexts(
          request: ListContextsRequest
        ): Kleisli[M, SageMakerClient, ListContextsResponse] =
          primitive(_.listContexts(request))

        def listDataQualityJobDefinitions(
          request: ListDataQualityJobDefinitionsRequest
        ): Kleisli[M, SageMakerClient, ListDataQualityJobDefinitionsResponse] =
          primitive(_.listDataQualityJobDefinitions(request))

        def listDeviceFleets(
          request: ListDeviceFleetsRequest
        ): Kleisli[M, SageMakerClient, ListDeviceFleetsResponse] =
          primitive(_.listDeviceFleets(request))

        def listDevices(
          request: ListDevicesRequest
        ): Kleisli[M, SageMakerClient, ListDevicesResponse] =
          primitive(_.listDevices(request))

        def listDomains(
          request: ListDomainsRequest
        ): Kleisli[M, SageMakerClient, ListDomainsResponse] =
          primitive(_.listDomains(request))

        def listEdgePackagingJobs(
          request: ListEdgePackagingJobsRequest
        ): Kleisli[M, SageMakerClient, ListEdgePackagingJobsResponse] =
          primitive(_.listEdgePackagingJobs(request))

        def listEndpointConfigs(
          request: ListEndpointConfigsRequest
        ): Kleisli[M, SageMakerClient, ListEndpointConfigsResponse] =
          primitive(_.listEndpointConfigs(request))

        def listEndpoints(
          request: ListEndpointsRequest
        ): Kleisli[M, SageMakerClient, ListEndpointsResponse] =
          primitive(_.listEndpoints(request))

        def listExperiments(
          request: ListExperimentsRequest
        ): Kleisli[M, SageMakerClient, ListExperimentsResponse] =
          primitive(_.listExperiments(request))

        def listFeatureGroups(
          request: ListFeatureGroupsRequest
        ): Kleisli[M, SageMakerClient, ListFeatureGroupsResponse] =
          primitive(_.listFeatureGroups(request))

        def listFlowDefinitions(
          request: ListFlowDefinitionsRequest
        ): Kleisli[M, SageMakerClient, ListFlowDefinitionsResponse] =
          primitive(_.listFlowDefinitions(request))

        def listHumanTaskUis(
          request: ListHumanTaskUisRequest
        ): Kleisli[M, SageMakerClient, ListHumanTaskUisResponse] =
          primitive(_.listHumanTaskUis(request))

        def listHyperParameterTuningJobs(
          request: ListHyperParameterTuningJobsRequest
        ): Kleisli[M, SageMakerClient, ListHyperParameterTuningJobsResponse] =
          primitive(_.listHyperParameterTuningJobs(request))

        def listImageVersions(
          request: ListImageVersionsRequest
        ): Kleisli[M, SageMakerClient, ListImageVersionsResponse] =
          primitive(_.listImageVersions(request))

        def listImages(
          request: ListImagesRequest
        ): Kleisli[M, SageMakerClient, ListImagesResponse] =
          primitive(_.listImages(request))

        def listLabelingJobs(
          request: ListLabelingJobsRequest
        ): Kleisli[M, SageMakerClient, ListLabelingJobsResponse] =
          primitive(_.listLabelingJobs(request))

        def listLabelingJobsForWorkteam(
          request: ListLabelingJobsForWorkteamRequest
        ): Kleisli[M, SageMakerClient, ListLabelingJobsForWorkteamResponse] =
          primitive(_.listLabelingJobsForWorkteam(request))

        def listModelBiasJobDefinitions(
          request: ListModelBiasJobDefinitionsRequest
        ): Kleisli[M, SageMakerClient, ListModelBiasJobDefinitionsResponse] =
          primitive(_.listModelBiasJobDefinitions(request))

        def listModelExplainabilityJobDefinitions(
          request: ListModelExplainabilityJobDefinitionsRequest
        ): Kleisli[M, SageMakerClient, ListModelExplainabilityJobDefinitionsResponse] =
          primitive(_.listModelExplainabilityJobDefinitions(request))

        def listModelPackageGroups(
          request: ListModelPackageGroupsRequest
        ): Kleisli[M, SageMakerClient, ListModelPackageGroupsResponse] =
          primitive(_.listModelPackageGroups(request))

        def listModelPackages(
          request: ListModelPackagesRequest
        ): Kleisli[M, SageMakerClient, ListModelPackagesResponse] =
          primitive(_.listModelPackages(request))

        def listModelQualityJobDefinitions(
          request: ListModelQualityJobDefinitionsRequest
        ): Kleisli[M, SageMakerClient, ListModelQualityJobDefinitionsResponse] =
          primitive(_.listModelQualityJobDefinitions(request))

        def listModels(
          request: ListModelsRequest
        ): Kleisli[M, SageMakerClient, ListModelsResponse] =
          primitive(_.listModels(request))

        def listMonitoringExecutions(
          request: ListMonitoringExecutionsRequest
        ): Kleisli[M, SageMakerClient, ListMonitoringExecutionsResponse] =
          primitive(_.listMonitoringExecutions(request))

        def listMonitoringSchedules(
          request: ListMonitoringSchedulesRequest
        ): Kleisli[M, SageMakerClient, ListMonitoringSchedulesResponse] =
          primitive(_.listMonitoringSchedules(request))

        def listNotebookInstanceLifecycleConfigs(
          request: ListNotebookInstanceLifecycleConfigsRequest
        ): Kleisli[M, SageMakerClient, ListNotebookInstanceLifecycleConfigsResponse] =
          primitive(_.listNotebookInstanceLifecycleConfigs(request))

        def listNotebookInstances(
          request: ListNotebookInstancesRequest
        ): Kleisli[M, SageMakerClient, ListNotebookInstancesResponse] =
          primitive(_.listNotebookInstances(request))

        def listPipelineExecutionSteps(
          request: ListPipelineExecutionStepsRequest
        ): Kleisli[M, SageMakerClient, ListPipelineExecutionStepsResponse] =
          primitive(_.listPipelineExecutionSteps(request))

        def listPipelineExecutions(
          request: ListPipelineExecutionsRequest
        ): Kleisli[M, SageMakerClient, ListPipelineExecutionsResponse] =
          primitive(_.listPipelineExecutions(request))

        def listPipelineParametersForExecution(
          request: ListPipelineParametersForExecutionRequest
        ): Kleisli[M, SageMakerClient, ListPipelineParametersForExecutionResponse] =
          primitive(_.listPipelineParametersForExecution(request))

        def listPipelines(
          request: ListPipelinesRequest
        ): Kleisli[M, SageMakerClient, ListPipelinesResponse] =
          primitive(_.listPipelines(request))

        def listProcessingJobs(
          request: ListProcessingJobsRequest
        ): Kleisli[M, SageMakerClient, ListProcessingJobsResponse] =
          primitive(_.listProcessingJobs(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, SageMakerClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listSubscribedWorkteams(
          request: ListSubscribedWorkteamsRequest
        ): Kleisli[M, SageMakerClient, ListSubscribedWorkteamsResponse] =
          primitive(_.listSubscribedWorkteams(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, SageMakerClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def listTrainingJobs(
          request: ListTrainingJobsRequest
        ): Kleisli[M, SageMakerClient, ListTrainingJobsResponse] =
          primitive(_.listTrainingJobs(request))

        def listTrainingJobsForHyperParameterTuningJob(
          request: ListTrainingJobsForHyperParameterTuningJobRequest
        ): Kleisli[M, SageMakerClient, ListTrainingJobsForHyperParameterTuningJobResponse] =
          primitive(_.listTrainingJobsForHyperParameterTuningJob(request))

        def listTransformJobs(
          request: ListTransformJobsRequest
        ): Kleisli[M, SageMakerClient, ListTransformJobsResponse] =
          primitive(_.listTransformJobs(request))

        def listTrialComponents(
          request: ListTrialComponentsRequest
        ): Kleisli[M, SageMakerClient, ListTrialComponentsResponse] =
          primitive(_.listTrialComponents(request))

        def listTrials(
          request: ListTrialsRequest
        ): Kleisli[M, SageMakerClient, ListTrialsResponse] =
          primitive(_.listTrials(request))

        def listUserProfiles(
          request: ListUserProfilesRequest
        ): Kleisli[M, SageMakerClient, ListUserProfilesResponse] =
          primitive(_.listUserProfiles(request))

        def listWorkforces(
          request: ListWorkforcesRequest
        ): Kleisli[M, SageMakerClient, ListWorkforcesResponse] =
          primitive(_.listWorkforces(request))

        def listWorkteams(
          request: ListWorkteamsRequest
        ): Kleisli[M, SageMakerClient, ListWorkteamsResponse] =
          primitive(_.listWorkteams(request))

        def putModelPackageGroupPolicy(
          request: PutModelPackageGroupPolicyRequest
        ): Kleisli[M, SageMakerClient, PutModelPackageGroupPolicyResponse] =
          primitive(_.putModelPackageGroupPolicy(request))

        def registerDevices(
          request: RegisterDevicesRequest
        ): Kleisli[M, SageMakerClient, RegisterDevicesResponse] =
          primitive(_.registerDevices(request))

        def renderUiTemplate(
          request: RenderUiTemplateRequest
        ): Kleisli[M, SageMakerClient, RenderUiTemplateResponse] =
          primitive(_.renderUiTemplate(request))

        def search(
          request: SearchRequest
        ): Kleisli[M, SageMakerClient, SearchResponse] =
          primitive(_.search(request))

        def sendPipelineExecutionStepFailure(
          request: SendPipelineExecutionStepFailureRequest
        ): Kleisli[M, SageMakerClient, SendPipelineExecutionStepFailureResponse] =
          primitive(_.sendPipelineExecutionStepFailure(request))

        def sendPipelineExecutionStepSuccess(
          request: SendPipelineExecutionStepSuccessRequest
        ): Kleisli[M, SageMakerClient, SendPipelineExecutionStepSuccessResponse] =
          primitive(_.sendPipelineExecutionStepSuccess(request))

        def startMonitoringSchedule(
          request: StartMonitoringScheduleRequest
        ): Kleisli[M, SageMakerClient, StartMonitoringScheduleResponse] =
          primitive(_.startMonitoringSchedule(request))

        def startNotebookInstance(
          request: StartNotebookInstanceRequest
        ): Kleisli[M, SageMakerClient, StartNotebookInstanceResponse] =
          primitive(_.startNotebookInstance(request))

        def startPipelineExecution(
          request: StartPipelineExecutionRequest
        ): Kleisli[M, SageMakerClient, StartPipelineExecutionResponse] =
          primitive(_.startPipelineExecution(request))

        def stopAutoMLJob(
          request: StopAutoMlJobRequest
        ): Kleisli[M, SageMakerClient, StopAutoMlJobResponse] =
          primitive(_.stopAutoMLJob(request))

        def stopCompilationJob(
          request: StopCompilationJobRequest
        ): Kleisli[M, SageMakerClient, StopCompilationJobResponse] =
          primitive(_.stopCompilationJob(request))

        def stopEdgePackagingJob(
          request: StopEdgePackagingJobRequest
        ): Kleisli[M, SageMakerClient, StopEdgePackagingJobResponse] =
          primitive(_.stopEdgePackagingJob(request))

        def stopHyperParameterTuningJob(
          request: StopHyperParameterTuningJobRequest
        ): Kleisli[M, SageMakerClient, StopHyperParameterTuningJobResponse] =
          primitive(_.stopHyperParameterTuningJob(request))

        def stopLabelingJob(
          request: StopLabelingJobRequest
        ): Kleisli[M, SageMakerClient, StopLabelingJobResponse] =
          primitive(_.stopLabelingJob(request))

        def stopMonitoringSchedule(
          request: StopMonitoringScheduleRequest
        ): Kleisli[M, SageMakerClient, StopMonitoringScheduleResponse] =
          primitive(_.stopMonitoringSchedule(request))

        def stopNotebookInstance(
          request: StopNotebookInstanceRequest
        ): Kleisli[M, SageMakerClient, StopNotebookInstanceResponse] =
          primitive(_.stopNotebookInstance(request))

        def stopPipelineExecution(
          request: StopPipelineExecutionRequest
        ): Kleisli[M, SageMakerClient, StopPipelineExecutionResponse] =
          primitive(_.stopPipelineExecution(request))

        def stopProcessingJob(
          request: StopProcessingJobRequest
        ): Kleisli[M, SageMakerClient, StopProcessingJobResponse] =
          primitive(_.stopProcessingJob(request))

        def stopTrainingJob(
          request: StopTrainingJobRequest
        ): Kleisli[M, SageMakerClient, StopTrainingJobResponse] =
          primitive(_.stopTrainingJob(request))

        def stopTransformJob(
          request: StopTransformJobRequest
        ): Kleisli[M, SageMakerClient, StopTransformJobResponse] =
          primitive(_.stopTransformJob(request))

        def updateAction(
          request: UpdateActionRequest
        ): Kleisli[M, SageMakerClient, UpdateActionResponse] =
          primitive(_.updateAction(request))

        def updateAppImageConfig(
          request: UpdateAppImageConfigRequest
        ): Kleisli[M, SageMakerClient, UpdateAppImageConfigResponse] =
          primitive(_.updateAppImageConfig(request))

        def updateArtifact(
          request: UpdateArtifactRequest
        ): Kleisli[M, SageMakerClient, UpdateArtifactResponse] =
          primitive(_.updateArtifact(request))

        def updateCodeRepository(
          request: UpdateCodeRepositoryRequest
        ): Kleisli[M, SageMakerClient, UpdateCodeRepositoryResponse] =
          primitive(_.updateCodeRepository(request))

        def updateContext(
          request: UpdateContextRequest
        ): Kleisli[M, SageMakerClient, UpdateContextResponse] =
          primitive(_.updateContext(request))

        def updateDeviceFleet(
          request: UpdateDeviceFleetRequest
        ): Kleisli[M, SageMakerClient, UpdateDeviceFleetResponse] =
          primitive(_.updateDeviceFleet(request))

        def updateDevices(
          request: UpdateDevicesRequest
        ): Kleisli[M, SageMakerClient, UpdateDevicesResponse] =
          primitive(_.updateDevices(request))

        def updateDomain(
          request: UpdateDomainRequest
        ): Kleisli[M, SageMakerClient, UpdateDomainResponse] =
          primitive(_.updateDomain(request))

        def updateEndpoint(
          request: UpdateEndpointRequest
        ): Kleisli[M, SageMakerClient, UpdateEndpointResponse] =
          primitive(_.updateEndpoint(request))

        def updateEndpointWeightsAndCapacities(
          request: UpdateEndpointWeightsAndCapacitiesRequest
        ): Kleisli[M, SageMakerClient, UpdateEndpointWeightsAndCapacitiesResponse] =
          primitive(_.updateEndpointWeightsAndCapacities(request))

        def updateExperiment(
          request: UpdateExperimentRequest
        ): Kleisli[M, SageMakerClient, UpdateExperimentResponse] =
          primitive(_.updateExperiment(request))

        def updateImage(
          request: UpdateImageRequest
        ): Kleisli[M, SageMakerClient, UpdateImageResponse] =
          primitive(_.updateImage(request))

        def updateModelPackage(
          request: UpdateModelPackageRequest
        ): Kleisli[M, SageMakerClient, UpdateModelPackageResponse] =
          primitive(_.updateModelPackage(request))

        def updateMonitoringSchedule(
          request: UpdateMonitoringScheduleRequest
        ): Kleisli[M, SageMakerClient, UpdateMonitoringScheduleResponse] =
          primitive(_.updateMonitoringSchedule(request))

        def updateNotebookInstance(
          request: UpdateNotebookInstanceRequest
        ): Kleisli[M, SageMakerClient, UpdateNotebookInstanceResponse] =
          primitive(_.updateNotebookInstance(request))

        def updateNotebookInstanceLifecycleConfig(
          request: UpdateNotebookInstanceLifecycleConfigRequest
        ): Kleisli[M, SageMakerClient, UpdateNotebookInstanceLifecycleConfigResponse] =
          primitive(_.updateNotebookInstanceLifecycleConfig(request))

        def updatePipeline(
          request: UpdatePipelineRequest
        ): Kleisli[M, SageMakerClient, UpdatePipelineResponse] =
          primitive(_.updatePipeline(request))

        def updatePipelineExecution(
          request: UpdatePipelineExecutionRequest
        ): Kleisli[M, SageMakerClient, UpdatePipelineExecutionResponse] =
          primitive(_.updatePipelineExecution(request))

        def updateTrainingJob(
          request: UpdateTrainingJobRequest
        ): Kleisli[M, SageMakerClient, UpdateTrainingJobResponse] =
          primitive(_.updateTrainingJob(request))

        def updateTrial(
          request: UpdateTrialRequest
        ): Kleisli[M, SageMakerClient, UpdateTrialResponse] =
          primitive(_.updateTrial(request))

        def updateTrialComponent(
          request: UpdateTrialComponentRequest
        ): Kleisli[M, SageMakerClient, UpdateTrialComponentResponse] =
          primitive(_.updateTrialComponent(request))

        def updateUserProfile(
          request: UpdateUserProfileRequest
        ): Kleisli[M, SageMakerClient, UpdateUserProfileResponse] =
          primitive(_.updateUserProfile(request))

        def updateWorkforce(
          request: UpdateWorkforceRequest
        ): Kleisli[M, SageMakerClient, UpdateWorkforceResponse] =
          primitive(_.updateWorkforce(request))

        def updateWorkteam(
          request: UpdateWorkteamRequest
        ): Kleisli[M, SageMakerClient, UpdateWorkteamResponse] =
          primitive(_.updateWorkteam(request))

        def primitive[A](
          f: SageMakerClient => A
        ): Kleisli[M, SageMakerClient, A]
      }
    }

    trait Visitor[F[_]] extends (SageMakerOp ~> F) {
      final def apply[A](op: SageMakerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addAssociation(
        request: AddAssociationRequest
      ): F[AddAssociationResponse]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def associateTrialComponent(
        request: AssociateTrialComponentRequest
      ): F[AssociateTrialComponentResponse]

      def createAction(
        request: CreateActionRequest
      ): F[CreateActionResponse]

      def createAlgorithm(
        request: CreateAlgorithmRequest
      ): F[CreateAlgorithmResponse]

      def createApp(
        request: CreateAppRequest
      ): F[CreateAppResponse]

      def createAppImageConfig(
        request: CreateAppImageConfigRequest
      ): F[CreateAppImageConfigResponse]

      def createArtifact(
        request: CreateArtifactRequest
      ): F[CreateArtifactResponse]

      def createAutoMLJob(
        request: CreateAutoMlJobRequest
      ): F[CreateAutoMlJobResponse]

      def createCodeRepository(
        request: CreateCodeRepositoryRequest
      ): F[CreateCodeRepositoryResponse]

      def createCompilationJob(
        request: CreateCompilationJobRequest
      ): F[CreateCompilationJobResponse]

      def createContext(
        request: CreateContextRequest
      ): F[CreateContextResponse]

      def createDataQualityJobDefinition(
        request: CreateDataQualityJobDefinitionRequest
      ): F[CreateDataQualityJobDefinitionResponse]

      def createDeviceFleet(
        request: CreateDeviceFleetRequest
      ): F[CreateDeviceFleetResponse]

      def createDomain(
        request: CreateDomainRequest
      ): F[CreateDomainResponse]

      def createEdgePackagingJob(
        request: CreateEdgePackagingJobRequest
      ): F[CreateEdgePackagingJobResponse]

      def createEndpoint(
        request: CreateEndpointRequest
      ): F[CreateEndpointResponse]

      def createEndpointConfig(
        request: CreateEndpointConfigRequest
      ): F[CreateEndpointConfigResponse]

      def createExperiment(
        request: CreateExperimentRequest
      ): F[CreateExperimentResponse]

      def createFeatureGroup(
        request: CreateFeatureGroupRequest
      ): F[CreateFeatureGroupResponse]

      def createFlowDefinition(
        request: CreateFlowDefinitionRequest
      ): F[CreateFlowDefinitionResponse]

      def createHumanTaskUi(
        request: CreateHumanTaskUiRequest
      ): F[CreateHumanTaskUiResponse]

      def createHyperParameterTuningJob(
        request: CreateHyperParameterTuningJobRequest
      ): F[CreateHyperParameterTuningJobResponse]

      def createImage(
        request: CreateImageRequest
      ): F[CreateImageResponse]

      def createImageVersion(
        request: CreateImageVersionRequest
      ): F[CreateImageVersionResponse]

      def createLabelingJob(
        request: CreateLabelingJobRequest
      ): F[CreateLabelingJobResponse]

      def createModel(
        request: CreateModelRequest
      ): F[CreateModelResponse]

      def createModelBiasJobDefinition(
        request: CreateModelBiasJobDefinitionRequest
      ): F[CreateModelBiasJobDefinitionResponse]

      def createModelExplainabilityJobDefinition(
        request: CreateModelExplainabilityJobDefinitionRequest
      ): F[CreateModelExplainabilityJobDefinitionResponse]

      def createModelPackage(
        request: CreateModelPackageRequest
      ): F[CreateModelPackageResponse]

      def createModelPackageGroup(
        request: CreateModelPackageGroupRequest
      ): F[CreateModelPackageGroupResponse]

      def createModelQualityJobDefinition(
        request: CreateModelQualityJobDefinitionRequest
      ): F[CreateModelQualityJobDefinitionResponse]

      def createMonitoringSchedule(
        request: CreateMonitoringScheduleRequest
      ): F[CreateMonitoringScheduleResponse]

      def createNotebookInstance(
        request: CreateNotebookInstanceRequest
      ): F[CreateNotebookInstanceResponse]

      def createNotebookInstanceLifecycleConfig(
        request: CreateNotebookInstanceLifecycleConfigRequest
      ): F[CreateNotebookInstanceLifecycleConfigResponse]

      def createPipeline(
        request: CreatePipelineRequest
      ): F[CreatePipelineResponse]

      def createPresignedDomainUrl(
        request: CreatePresignedDomainUrlRequest
      ): F[CreatePresignedDomainUrlResponse]

      def createPresignedNotebookInstanceUrl(
        request: CreatePresignedNotebookInstanceUrlRequest
      ): F[CreatePresignedNotebookInstanceUrlResponse]

      def createProcessingJob(
        request: CreateProcessingJobRequest
      ): F[CreateProcessingJobResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def createTrainingJob(
        request: CreateTrainingJobRequest
      ): F[CreateTrainingJobResponse]

      def createTransformJob(
        request: CreateTransformJobRequest
      ): F[CreateTransformJobResponse]

      def createTrial(
        request: CreateTrialRequest
      ): F[CreateTrialResponse]

      def createTrialComponent(
        request: CreateTrialComponentRequest
      ): F[CreateTrialComponentResponse]

      def createUserProfile(
        request: CreateUserProfileRequest
      ): F[CreateUserProfileResponse]

      def createWorkforce(
        request: CreateWorkforceRequest
      ): F[CreateWorkforceResponse]

      def createWorkteam(
        request: CreateWorkteamRequest
      ): F[CreateWorkteamResponse]

      def deleteAction(
        request: DeleteActionRequest
      ): F[DeleteActionResponse]

      def deleteAlgorithm(
        request: DeleteAlgorithmRequest
      ): F[DeleteAlgorithmResponse]

      def deleteApp(
        request: DeleteAppRequest
      ): F[DeleteAppResponse]

      def deleteAppImageConfig(
        request: DeleteAppImageConfigRequest
      ): F[DeleteAppImageConfigResponse]

      def deleteArtifact(
        request: DeleteArtifactRequest
      ): F[DeleteArtifactResponse]

      def deleteAssociation(
        request: DeleteAssociationRequest
      ): F[DeleteAssociationResponse]

      def deleteCodeRepository(
        request: DeleteCodeRepositoryRequest
      ): F[DeleteCodeRepositoryResponse]

      def deleteContext(
        request: DeleteContextRequest
      ): F[DeleteContextResponse]

      def deleteDataQualityJobDefinition(
        request: DeleteDataQualityJobDefinitionRequest
      ): F[DeleteDataQualityJobDefinitionResponse]

      def deleteDeviceFleet(
        request: DeleteDeviceFleetRequest
      ): F[DeleteDeviceFleetResponse]

      def deleteDomain(
        request: DeleteDomainRequest
      ): F[DeleteDomainResponse]

      def deleteEndpoint(
        request: DeleteEndpointRequest
      ): F[DeleteEndpointResponse]

      def deleteEndpointConfig(
        request: DeleteEndpointConfigRequest
      ): F[DeleteEndpointConfigResponse]

      def deleteExperiment(
        request: DeleteExperimentRequest
      ): F[DeleteExperimentResponse]

      def deleteFeatureGroup(
        request: DeleteFeatureGroupRequest
      ): F[DeleteFeatureGroupResponse]

      def deleteFlowDefinition(
        request: DeleteFlowDefinitionRequest
      ): F[DeleteFlowDefinitionResponse]

      def deleteHumanTaskUi(
        request: DeleteHumanTaskUiRequest
      ): F[DeleteHumanTaskUiResponse]

      def deleteImage(
        request: DeleteImageRequest
      ): F[DeleteImageResponse]

      def deleteImageVersion(
        request: DeleteImageVersionRequest
      ): F[DeleteImageVersionResponse]

      def deleteModel(
        request: DeleteModelRequest
      ): F[DeleteModelResponse]

      def deleteModelBiasJobDefinition(
        request: DeleteModelBiasJobDefinitionRequest
      ): F[DeleteModelBiasJobDefinitionResponse]

      def deleteModelExplainabilityJobDefinition(
        request: DeleteModelExplainabilityJobDefinitionRequest
      ): F[DeleteModelExplainabilityJobDefinitionResponse]

      def deleteModelPackage(
        request: DeleteModelPackageRequest
      ): F[DeleteModelPackageResponse]

      def deleteModelPackageGroup(
        request: DeleteModelPackageGroupRequest
      ): F[DeleteModelPackageGroupResponse]

      def deleteModelPackageGroupPolicy(
        request: DeleteModelPackageGroupPolicyRequest
      ): F[DeleteModelPackageGroupPolicyResponse]

      def deleteModelQualityJobDefinition(
        request: DeleteModelQualityJobDefinitionRequest
      ): F[DeleteModelQualityJobDefinitionResponse]

      def deleteMonitoringSchedule(
        request: DeleteMonitoringScheduleRequest
      ): F[DeleteMonitoringScheduleResponse]

      def deleteNotebookInstance(
        request: DeleteNotebookInstanceRequest
      ): F[DeleteNotebookInstanceResponse]

      def deleteNotebookInstanceLifecycleConfig(
        request: DeleteNotebookInstanceLifecycleConfigRequest
      ): F[DeleteNotebookInstanceLifecycleConfigResponse]

      def deletePipeline(
        request: DeletePipelineRequest
      ): F[DeletePipelineResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def deleteTrial(
        request: DeleteTrialRequest
      ): F[DeleteTrialResponse]

      def deleteTrialComponent(
        request: DeleteTrialComponentRequest
      ): F[DeleteTrialComponentResponse]

      def deleteUserProfile(
        request: DeleteUserProfileRequest
      ): F[DeleteUserProfileResponse]

      def deleteWorkforce(
        request: DeleteWorkforceRequest
      ): F[DeleteWorkforceResponse]

      def deleteWorkteam(
        request: DeleteWorkteamRequest
      ): F[DeleteWorkteamResponse]

      def deregisterDevices(
        request: DeregisterDevicesRequest
      ): F[DeregisterDevicesResponse]

      def describeAction(
        request: DescribeActionRequest
      ): F[DescribeActionResponse]

      def describeAlgorithm(
        request: DescribeAlgorithmRequest
      ): F[DescribeAlgorithmResponse]

      def describeApp(
        request: DescribeAppRequest
      ): F[DescribeAppResponse]

      def describeAppImageConfig(
        request: DescribeAppImageConfigRequest
      ): F[DescribeAppImageConfigResponse]

      def describeArtifact(
        request: DescribeArtifactRequest
      ): F[DescribeArtifactResponse]

      def describeAutoMLJob(
        request: DescribeAutoMlJobRequest
      ): F[DescribeAutoMlJobResponse]

      def describeCodeRepository(
        request: DescribeCodeRepositoryRequest
      ): F[DescribeCodeRepositoryResponse]

      def describeCompilationJob(
        request: DescribeCompilationJobRequest
      ): F[DescribeCompilationJobResponse]

      def describeContext(
        request: DescribeContextRequest
      ): F[DescribeContextResponse]

      def describeDataQualityJobDefinition(
        request: DescribeDataQualityJobDefinitionRequest
      ): F[DescribeDataQualityJobDefinitionResponse]

      def describeDevice(
        request: DescribeDeviceRequest
      ): F[DescribeDeviceResponse]

      def describeDeviceFleet(
        request: DescribeDeviceFleetRequest
      ): F[DescribeDeviceFleetResponse]

      def describeDomain(
        request: DescribeDomainRequest
      ): F[DescribeDomainResponse]

      def describeEdgePackagingJob(
        request: DescribeEdgePackagingJobRequest
      ): F[DescribeEdgePackagingJobResponse]

      def describeEndpoint(
        request: DescribeEndpointRequest
      ): F[DescribeEndpointResponse]

      def describeEndpointConfig(
        request: DescribeEndpointConfigRequest
      ): F[DescribeEndpointConfigResponse]

      def describeExperiment(
        request: DescribeExperimentRequest
      ): F[DescribeExperimentResponse]

      def describeFeatureGroup(
        request: DescribeFeatureGroupRequest
      ): F[DescribeFeatureGroupResponse]

      def describeFlowDefinition(
        request: DescribeFlowDefinitionRequest
      ): F[DescribeFlowDefinitionResponse]

      def describeHumanTaskUi(
        request: DescribeHumanTaskUiRequest
      ): F[DescribeHumanTaskUiResponse]

      def describeHyperParameterTuningJob(
        request: DescribeHyperParameterTuningJobRequest
      ): F[DescribeHyperParameterTuningJobResponse]

      def describeImage(
        request: DescribeImageRequest
      ): F[DescribeImageResponse]

      def describeImageVersion(
        request: DescribeImageVersionRequest
      ): F[DescribeImageVersionResponse]

      def describeLabelingJob(
        request: DescribeLabelingJobRequest
      ): F[DescribeLabelingJobResponse]

      def describeModel(
        request: DescribeModelRequest
      ): F[DescribeModelResponse]

      def describeModelBiasJobDefinition(
        request: DescribeModelBiasJobDefinitionRequest
      ): F[DescribeModelBiasJobDefinitionResponse]

      def describeModelExplainabilityJobDefinition(
        request: DescribeModelExplainabilityJobDefinitionRequest
      ): F[DescribeModelExplainabilityJobDefinitionResponse]

      def describeModelPackage(
        request: DescribeModelPackageRequest
      ): F[DescribeModelPackageResponse]

      def describeModelPackageGroup(
        request: DescribeModelPackageGroupRequest
      ): F[DescribeModelPackageGroupResponse]

      def describeModelQualityJobDefinition(
        request: DescribeModelQualityJobDefinitionRequest
      ): F[DescribeModelQualityJobDefinitionResponse]

      def describeMonitoringSchedule(
        request: DescribeMonitoringScheduleRequest
      ): F[DescribeMonitoringScheduleResponse]

      def describeNotebookInstance(
        request: DescribeNotebookInstanceRequest
      ): F[DescribeNotebookInstanceResponse]

      def describeNotebookInstanceLifecycleConfig(
        request: DescribeNotebookInstanceLifecycleConfigRequest
      ): F[DescribeNotebookInstanceLifecycleConfigResponse]

      def describePipeline(
        request: DescribePipelineRequest
      ): F[DescribePipelineResponse]

      def describePipelineDefinitionForExecution(
        request: DescribePipelineDefinitionForExecutionRequest
      ): F[DescribePipelineDefinitionForExecutionResponse]

      def describePipelineExecution(
        request: DescribePipelineExecutionRequest
      ): F[DescribePipelineExecutionResponse]

      def describeProcessingJob(
        request: DescribeProcessingJobRequest
      ): F[DescribeProcessingJobResponse]

      def describeProject(
        request: DescribeProjectRequest
      ): F[DescribeProjectResponse]

      def describeSubscribedWorkteam(
        request: DescribeSubscribedWorkteamRequest
      ): F[DescribeSubscribedWorkteamResponse]

      def describeTrainingJob(
        request: DescribeTrainingJobRequest
      ): F[DescribeTrainingJobResponse]

      def describeTransformJob(
        request: DescribeTransformJobRequest
      ): F[DescribeTransformJobResponse]

      def describeTrial(
        request: DescribeTrialRequest
      ): F[DescribeTrialResponse]

      def describeTrialComponent(
        request: DescribeTrialComponentRequest
      ): F[DescribeTrialComponentResponse]

      def describeUserProfile(
        request: DescribeUserProfileRequest
      ): F[DescribeUserProfileResponse]

      def describeWorkforce(
        request: DescribeWorkforceRequest
      ): F[DescribeWorkforceResponse]

      def describeWorkteam(
        request: DescribeWorkteamRequest
      ): F[DescribeWorkteamResponse]

      def disableSagemakerServicecatalogPortfolio(
        request: DisableSagemakerServicecatalogPortfolioRequest
      ): F[DisableSagemakerServicecatalogPortfolioResponse]

      def disassociateTrialComponent(
        request: DisassociateTrialComponentRequest
      ): F[DisassociateTrialComponentResponse]

      def enableSagemakerServicecatalogPortfolio(
        request: EnableSagemakerServicecatalogPortfolioRequest
      ): F[EnableSagemakerServicecatalogPortfolioResponse]

      def getDeviceFleetReport(
        request: GetDeviceFleetReportRequest
      ): F[GetDeviceFleetReportResponse]

      def getModelPackageGroupPolicy(
        request: GetModelPackageGroupPolicyRequest
      ): F[GetModelPackageGroupPolicyResponse]

      def getSagemakerServicecatalogPortfolioStatus(
        request: GetSagemakerServicecatalogPortfolioStatusRequest
      ): F[GetSagemakerServicecatalogPortfolioStatusResponse]

      def getSearchSuggestions(
        request: GetSearchSuggestionsRequest
      ): F[GetSearchSuggestionsResponse]

      def listActions(
        request: ListActionsRequest
      ): F[ListActionsResponse]

      def listAlgorithms(
        request: ListAlgorithmsRequest
      ): F[ListAlgorithmsResponse]

      def listAppImageConfigs(
        request: ListAppImageConfigsRequest
      ): F[ListAppImageConfigsResponse]

      def listApps(
        request: ListAppsRequest
      ): F[ListAppsResponse]

      def listArtifacts(
        request: ListArtifactsRequest
      ): F[ListArtifactsResponse]

      def listAssociations(
        request: ListAssociationsRequest
      ): F[ListAssociationsResponse]

      def listAutoMLJobs(
        request: ListAutoMlJobsRequest
      ): F[ListAutoMlJobsResponse]

      def listCandidatesForAutoMLJob(
        request: ListCandidatesForAutoMlJobRequest
      ): F[ListCandidatesForAutoMlJobResponse]

      def listCodeRepositories(
        request: ListCodeRepositoriesRequest
      ): F[ListCodeRepositoriesResponse]

      def listCompilationJobs(
        request: ListCompilationJobsRequest
      ): F[ListCompilationJobsResponse]

      def listContexts(
        request: ListContextsRequest
      ): F[ListContextsResponse]

      def listDataQualityJobDefinitions(
        request: ListDataQualityJobDefinitionsRequest
      ): F[ListDataQualityJobDefinitionsResponse]

      def listDeviceFleets(
        request: ListDeviceFleetsRequest
      ): F[ListDeviceFleetsResponse]

      def listDevices(
        request: ListDevicesRequest
      ): F[ListDevicesResponse]

      def listDomains(
        request: ListDomainsRequest
      ): F[ListDomainsResponse]

      def listEdgePackagingJobs(
        request: ListEdgePackagingJobsRequest
      ): F[ListEdgePackagingJobsResponse]

      def listEndpointConfigs(
        request: ListEndpointConfigsRequest
      ): F[ListEndpointConfigsResponse]

      def listEndpoints(
        request: ListEndpointsRequest
      ): F[ListEndpointsResponse]

      def listExperiments(
        request: ListExperimentsRequest
      ): F[ListExperimentsResponse]

      def listFeatureGroups(
        request: ListFeatureGroupsRequest
      ): F[ListFeatureGroupsResponse]

      def listFlowDefinitions(
        request: ListFlowDefinitionsRequest
      ): F[ListFlowDefinitionsResponse]

      def listHumanTaskUis(
        request: ListHumanTaskUisRequest
      ): F[ListHumanTaskUisResponse]

      def listHyperParameterTuningJobs(
        request: ListHyperParameterTuningJobsRequest
      ): F[ListHyperParameterTuningJobsResponse]

      def listImageVersions(
        request: ListImageVersionsRequest
      ): F[ListImageVersionsResponse]

      def listImages(
        request: ListImagesRequest
      ): F[ListImagesResponse]

      def listLabelingJobs(
        request: ListLabelingJobsRequest
      ): F[ListLabelingJobsResponse]

      def listLabelingJobsForWorkteam(
        request: ListLabelingJobsForWorkteamRequest
      ): F[ListLabelingJobsForWorkteamResponse]

      def listModelBiasJobDefinitions(
        request: ListModelBiasJobDefinitionsRequest
      ): F[ListModelBiasJobDefinitionsResponse]

      def listModelExplainabilityJobDefinitions(
        request: ListModelExplainabilityJobDefinitionsRequest
      ): F[ListModelExplainabilityJobDefinitionsResponse]

      def listModelPackageGroups(
        request: ListModelPackageGroupsRequest
      ): F[ListModelPackageGroupsResponse]

      def listModelPackages(
        request: ListModelPackagesRequest
      ): F[ListModelPackagesResponse]

      def listModelQualityJobDefinitions(
        request: ListModelQualityJobDefinitionsRequest
      ): F[ListModelQualityJobDefinitionsResponse]

      def listModels(
        request: ListModelsRequest
      ): F[ListModelsResponse]

      def listMonitoringExecutions(
        request: ListMonitoringExecutionsRequest
      ): F[ListMonitoringExecutionsResponse]

      def listMonitoringSchedules(
        request: ListMonitoringSchedulesRequest
      ): F[ListMonitoringSchedulesResponse]

      def listNotebookInstanceLifecycleConfigs(
        request: ListNotebookInstanceLifecycleConfigsRequest
      ): F[ListNotebookInstanceLifecycleConfigsResponse]

      def listNotebookInstances(
        request: ListNotebookInstancesRequest
      ): F[ListNotebookInstancesResponse]

      def listPipelineExecutionSteps(
        request: ListPipelineExecutionStepsRequest
      ): F[ListPipelineExecutionStepsResponse]

      def listPipelineExecutions(
        request: ListPipelineExecutionsRequest
      ): F[ListPipelineExecutionsResponse]

      def listPipelineParametersForExecution(
        request: ListPipelineParametersForExecutionRequest
      ): F[ListPipelineParametersForExecutionResponse]

      def listPipelines(
        request: ListPipelinesRequest
      ): F[ListPipelinesResponse]

      def listProcessingJobs(
        request: ListProcessingJobsRequest
      ): F[ListProcessingJobsResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listSubscribedWorkteams(
        request: ListSubscribedWorkteamsRequest
      ): F[ListSubscribedWorkteamsResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def listTrainingJobs(
        request: ListTrainingJobsRequest
      ): F[ListTrainingJobsResponse]

      def listTrainingJobsForHyperParameterTuningJob(
        request: ListTrainingJobsForHyperParameterTuningJobRequest
      ): F[ListTrainingJobsForHyperParameterTuningJobResponse]

      def listTransformJobs(
        request: ListTransformJobsRequest
      ): F[ListTransformJobsResponse]

      def listTrialComponents(
        request: ListTrialComponentsRequest
      ): F[ListTrialComponentsResponse]

      def listTrials(
        request: ListTrialsRequest
      ): F[ListTrialsResponse]

      def listUserProfiles(
        request: ListUserProfilesRequest
      ): F[ListUserProfilesResponse]

      def listWorkforces(
        request: ListWorkforcesRequest
      ): F[ListWorkforcesResponse]

      def listWorkteams(
        request: ListWorkteamsRequest
      ): F[ListWorkteamsResponse]

      def putModelPackageGroupPolicy(
        request: PutModelPackageGroupPolicyRequest
      ): F[PutModelPackageGroupPolicyResponse]

      def registerDevices(
        request: RegisterDevicesRequest
      ): F[RegisterDevicesResponse]

      def renderUiTemplate(
        request: RenderUiTemplateRequest
      ): F[RenderUiTemplateResponse]

      def search(
        request: SearchRequest
      ): F[SearchResponse]

      def sendPipelineExecutionStepFailure(
        request: SendPipelineExecutionStepFailureRequest
      ): F[SendPipelineExecutionStepFailureResponse]

      def sendPipelineExecutionStepSuccess(
        request: SendPipelineExecutionStepSuccessRequest
      ): F[SendPipelineExecutionStepSuccessResponse]

      def startMonitoringSchedule(
        request: StartMonitoringScheduleRequest
      ): F[StartMonitoringScheduleResponse]

      def startNotebookInstance(
        request: StartNotebookInstanceRequest
      ): F[StartNotebookInstanceResponse]

      def startPipelineExecution(
        request: StartPipelineExecutionRequest
      ): F[StartPipelineExecutionResponse]

      def stopAutoMLJob(
        request: StopAutoMlJobRequest
      ): F[StopAutoMlJobResponse]

      def stopCompilationJob(
        request: StopCompilationJobRequest
      ): F[StopCompilationJobResponse]

      def stopEdgePackagingJob(
        request: StopEdgePackagingJobRequest
      ): F[StopEdgePackagingJobResponse]

      def stopHyperParameterTuningJob(
        request: StopHyperParameterTuningJobRequest
      ): F[StopHyperParameterTuningJobResponse]

      def stopLabelingJob(
        request: StopLabelingJobRequest
      ): F[StopLabelingJobResponse]

      def stopMonitoringSchedule(
        request: StopMonitoringScheduleRequest
      ): F[StopMonitoringScheduleResponse]

      def stopNotebookInstance(
        request: StopNotebookInstanceRequest
      ): F[StopNotebookInstanceResponse]

      def stopPipelineExecution(
        request: StopPipelineExecutionRequest
      ): F[StopPipelineExecutionResponse]

      def stopProcessingJob(
        request: StopProcessingJobRequest
      ): F[StopProcessingJobResponse]

      def stopTrainingJob(
        request: StopTrainingJobRequest
      ): F[StopTrainingJobResponse]

      def stopTransformJob(
        request: StopTransformJobRequest
      ): F[StopTransformJobResponse]

      def updateAction(
        request: UpdateActionRequest
      ): F[UpdateActionResponse]

      def updateAppImageConfig(
        request: UpdateAppImageConfigRequest
      ): F[UpdateAppImageConfigResponse]

      def updateArtifact(
        request: UpdateArtifactRequest
      ): F[UpdateArtifactResponse]

      def updateCodeRepository(
        request: UpdateCodeRepositoryRequest
      ): F[UpdateCodeRepositoryResponse]

      def updateContext(
        request: UpdateContextRequest
      ): F[UpdateContextResponse]

      def updateDeviceFleet(
        request: UpdateDeviceFleetRequest
      ): F[UpdateDeviceFleetResponse]

      def updateDevices(
        request: UpdateDevicesRequest
      ): F[UpdateDevicesResponse]

      def updateDomain(
        request: UpdateDomainRequest
      ): F[UpdateDomainResponse]

      def updateEndpoint(
        request: UpdateEndpointRequest
      ): F[UpdateEndpointResponse]

      def updateEndpointWeightsAndCapacities(
        request: UpdateEndpointWeightsAndCapacitiesRequest
      ): F[UpdateEndpointWeightsAndCapacitiesResponse]

      def updateExperiment(
        request: UpdateExperimentRequest
      ): F[UpdateExperimentResponse]

      def updateImage(
        request: UpdateImageRequest
      ): F[UpdateImageResponse]

      def updateModelPackage(
        request: UpdateModelPackageRequest
      ): F[UpdateModelPackageResponse]

      def updateMonitoringSchedule(
        request: UpdateMonitoringScheduleRequest
      ): F[UpdateMonitoringScheduleResponse]

      def updateNotebookInstance(
        request: UpdateNotebookInstanceRequest
      ): F[UpdateNotebookInstanceResponse]

      def updateNotebookInstanceLifecycleConfig(
        request: UpdateNotebookInstanceLifecycleConfigRequest
      ): F[UpdateNotebookInstanceLifecycleConfigResponse]

      def updatePipeline(
        request: UpdatePipelineRequest
      ): F[UpdatePipelineResponse]

      def updatePipelineExecution(
        request: UpdatePipelineExecutionRequest
      ): F[UpdatePipelineExecutionResponse]

      def updateTrainingJob(
        request: UpdateTrainingJobRequest
      ): F[UpdateTrainingJobResponse]

      def updateTrial(
        request: UpdateTrialRequest
      ): F[UpdateTrialResponse]

      def updateTrialComponent(
        request: UpdateTrialComponentRequest
      ): F[UpdateTrialComponentResponse]

      def updateUserProfile(
        request: UpdateUserProfileRequest
      ): F[UpdateUserProfileResponse]

      def updateWorkforce(
        request: UpdateWorkforceRequest
      ): F[UpdateWorkforceResponse]

      def updateWorkteam(
        request: UpdateWorkteamRequest
      ): F[UpdateWorkteamResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SageMakerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddAssociationOp(
      request: AddAssociationRequest
    ) extends SageMakerOp[AddAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddAssociationResponse] =
        visitor.addAssociation(request)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends SageMakerOp[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class AssociateTrialComponentOp(
      request: AssociateTrialComponentRequest
    ) extends SageMakerOp[AssociateTrialComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTrialComponentResponse] =
        visitor.associateTrialComponent(request)
    }

    final case class CreateActionOp(
      request: CreateActionRequest
    ) extends SageMakerOp[CreateActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateActionResponse] =
        visitor.createAction(request)
    }

    final case class CreateAlgorithmOp(
      request: CreateAlgorithmRequest
    ) extends SageMakerOp[CreateAlgorithmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAlgorithmResponse] =
        visitor.createAlgorithm(request)
    }

    final case class CreateAppOp(
      request: CreateAppRequest
    ) extends SageMakerOp[CreateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppResponse] =
        visitor.createApp(request)
    }

    final case class CreateAppImageConfigOp(
      request: CreateAppImageConfigRequest
    ) extends SageMakerOp[CreateAppImageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppImageConfigResponse] =
        visitor.createAppImageConfig(request)
    }

    final case class CreateArtifactOp(
      request: CreateArtifactRequest
    ) extends SageMakerOp[CreateArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateArtifactResponse] =
        visitor.createArtifact(request)
    }

    final case class CreateAutoMLJobOp(
      request: CreateAutoMlJobRequest
    ) extends SageMakerOp[CreateAutoMlJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAutoMlJobResponse] =
        visitor.createAutoMLJob(request)
    }

    final case class CreateCodeRepositoryOp(
      request: CreateCodeRepositoryRequest
    ) extends SageMakerOp[CreateCodeRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCodeRepositoryResponse] =
        visitor.createCodeRepository(request)
    }

    final case class CreateCompilationJobOp(
      request: CreateCompilationJobRequest
    ) extends SageMakerOp[CreateCompilationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCompilationJobResponse] =
        visitor.createCompilationJob(request)
    }

    final case class CreateContextOp(
      request: CreateContextRequest
    ) extends SageMakerOp[CreateContextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContextResponse] =
        visitor.createContext(request)
    }

    final case class CreateDataQualityJobDefinitionOp(
      request: CreateDataQualityJobDefinitionRequest
    ) extends SageMakerOp[CreateDataQualityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataQualityJobDefinitionResponse] =
        visitor.createDataQualityJobDefinition(request)
    }

    final case class CreateDeviceFleetOp(
      request: CreateDeviceFleetRequest
    ) extends SageMakerOp[CreateDeviceFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeviceFleetResponse] =
        visitor.createDeviceFleet(request)
    }

    final case class CreateDomainOp(
      request: CreateDomainRequest
    ) extends SageMakerOp[CreateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainResponse] =
        visitor.createDomain(request)
    }

    final case class CreateEdgePackagingJobOp(
      request: CreateEdgePackagingJobRequest
    ) extends SageMakerOp[CreateEdgePackagingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEdgePackagingJobResponse] =
        visitor.createEdgePackagingJob(request)
    }

    final case class CreateEndpointOp(
      request: CreateEndpointRequest
    ) extends SageMakerOp[CreateEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEndpointResponse] =
        visitor.createEndpoint(request)
    }

    final case class CreateEndpointConfigOp(
      request: CreateEndpointConfigRequest
    ) extends SageMakerOp[CreateEndpointConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEndpointConfigResponse] =
        visitor.createEndpointConfig(request)
    }

    final case class CreateExperimentOp(
      request: CreateExperimentRequest
    ) extends SageMakerOp[CreateExperimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateExperimentResponse] =
        visitor.createExperiment(request)
    }

    final case class CreateFeatureGroupOp(
      request: CreateFeatureGroupRequest
    ) extends SageMakerOp[CreateFeatureGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFeatureGroupResponse] =
        visitor.createFeatureGroup(request)
    }

    final case class CreateFlowDefinitionOp(
      request: CreateFlowDefinitionRequest
    ) extends SageMakerOp[CreateFlowDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFlowDefinitionResponse] =
        visitor.createFlowDefinition(request)
    }

    final case class CreateHumanTaskUiOp(
      request: CreateHumanTaskUiRequest
    ) extends SageMakerOp[CreateHumanTaskUiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHumanTaskUiResponse] =
        visitor.createHumanTaskUi(request)
    }

    final case class CreateHyperParameterTuningJobOp(
      request: CreateHyperParameterTuningJobRequest
    ) extends SageMakerOp[CreateHyperParameterTuningJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHyperParameterTuningJobResponse] =
        visitor.createHyperParameterTuningJob(request)
    }

    final case class CreateImageOp(
      request: CreateImageRequest
    ) extends SageMakerOp[CreateImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImageResponse] =
        visitor.createImage(request)
    }

    final case class CreateImageVersionOp(
      request: CreateImageVersionRequest
    ) extends SageMakerOp[CreateImageVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImageVersionResponse] =
        visitor.createImageVersion(request)
    }

    final case class CreateLabelingJobOp(
      request: CreateLabelingJobRequest
    ) extends SageMakerOp[CreateLabelingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLabelingJobResponse] =
        visitor.createLabelingJob(request)
    }

    final case class CreateModelOp(
      request: CreateModelRequest
    ) extends SageMakerOp[CreateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelResponse] =
        visitor.createModel(request)
    }

    final case class CreateModelBiasJobDefinitionOp(
      request: CreateModelBiasJobDefinitionRequest
    ) extends SageMakerOp[CreateModelBiasJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelBiasJobDefinitionResponse] =
        visitor.createModelBiasJobDefinition(request)
    }

    final case class CreateModelExplainabilityJobDefinitionOp(
      request: CreateModelExplainabilityJobDefinitionRequest
    ) extends SageMakerOp[CreateModelExplainabilityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelExplainabilityJobDefinitionResponse] =
        visitor.createModelExplainabilityJobDefinition(request)
    }

    final case class CreateModelPackageOp(
      request: CreateModelPackageRequest
    ) extends SageMakerOp[CreateModelPackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelPackageResponse] =
        visitor.createModelPackage(request)
    }

    final case class CreateModelPackageGroupOp(
      request: CreateModelPackageGroupRequest
    ) extends SageMakerOp[CreateModelPackageGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelPackageGroupResponse] =
        visitor.createModelPackageGroup(request)
    }

    final case class CreateModelQualityJobDefinitionOp(
      request: CreateModelQualityJobDefinitionRequest
    ) extends SageMakerOp[CreateModelQualityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelQualityJobDefinitionResponse] =
        visitor.createModelQualityJobDefinition(request)
    }

    final case class CreateMonitoringScheduleOp(
      request: CreateMonitoringScheduleRequest
    ) extends SageMakerOp[CreateMonitoringScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMonitoringScheduleResponse] =
        visitor.createMonitoringSchedule(request)
    }

    final case class CreateNotebookInstanceOp(
      request: CreateNotebookInstanceRequest
    ) extends SageMakerOp[CreateNotebookInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNotebookInstanceResponse] =
        visitor.createNotebookInstance(request)
    }

    final case class CreateNotebookInstanceLifecycleConfigOp(
      request: CreateNotebookInstanceLifecycleConfigRequest
    ) extends SageMakerOp[CreateNotebookInstanceLifecycleConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNotebookInstanceLifecycleConfigResponse] =
        visitor.createNotebookInstanceLifecycleConfig(request)
    }

    final case class CreatePipelineOp(
      request: CreatePipelineRequest
    ) extends SageMakerOp[CreatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePipelineResponse] =
        visitor.createPipeline(request)
    }

    final case class CreatePresignedDomainUrlOp(
      request: CreatePresignedDomainUrlRequest
    ) extends SageMakerOp[CreatePresignedDomainUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePresignedDomainUrlResponse] =
        visitor.createPresignedDomainUrl(request)
    }

    final case class CreatePresignedNotebookInstanceUrlOp(
      request: CreatePresignedNotebookInstanceUrlRequest
    ) extends SageMakerOp[CreatePresignedNotebookInstanceUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePresignedNotebookInstanceUrlResponse] =
        visitor.createPresignedNotebookInstanceUrl(request)
    }

    final case class CreateProcessingJobOp(
      request: CreateProcessingJobRequest
    ) extends SageMakerOp[CreateProcessingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProcessingJobResponse] =
        visitor.createProcessingJob(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends SageMakerOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class CreateTrainingJobOp(
      request: CreateTrainingJobRequest
    ) extends SageMakerOp[CreateTrainingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrainingJobResponse] =
        visitor.createTrainingJob(request)
    }

    final case class CreateTransformJobOp(
      request: CreateTransformJobRequest
    ) extends SageMakerOp[CreateTransformJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTransformJobResponse] =
        visitor.createTransformJob(request)
    }

    final case class CreateTrialOp(
      request: CreateTrialRequest
    ) extends SageMakerOp[CreateTrialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrialResponse] =
        visitor.createTrial(request)
    }

    final case class CreateTrialComponentOp(
      request: CreateTrialComponentRequest
    ) extends SageMakerOp[CreateTrialComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrialComponentResponse] =
        visitor.createTrialComponent(request)
    }

    final case class CreateUserProfileOp(
      request: CreateUserProfileRequest
    ) extends SageMakerOp[CreateUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserProfileResponse] =
        visitor.createUserProfile(request)
    }

    final case class CreateWorkforceOp(
      request: CreateWorkforceRequest
    ) extends SageMakerOp[CreateWorkforceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkforceResponse] =
        visitor.createWorkforce(request)
    }

    final case class CreateWorkteamOp(
      request: CreateWorkteamRequest
    ) extends SageMakerOp[CreateWorkteamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkteamResponse] =
        visitor.createWorkteam(request)
    }

    final case class DeleteActionOp(
      request: DeleteActionRequest
    ) extends SageMakerOp[DeleteActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteActionResponse] =
        visitor.deleteAction(request)
    }

    final case class DeleteAlgorithmOp(
      request: DeleteAlgorithmRequest
    ) extends SageMakerOp[DeleteAlgorithmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAlgorithmResponse] =
        visitor.deleteAlgorithm(request)
    }

    final case class DeleteAppOp(
      request: DeleteAppRequest
    ) extends SageMakerOp[DeleteAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppResponse] =
        visitor.deleteApp(request)
    }

    final case class DeleteAppImageConfigOp(
      request: DeleteAppImageConfigRequest
    ) extends SageMakerOp[DeleteAppImageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppImageConfigResponse] =
        visitor.deleteAppImageConfig(request)
    }

    final case class DeleteArtifactOp(
      request: DeleteArtifactRequest
    ) extends SageMakerOp[DeleteArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteArtifactResponse] =
        visitor.deleteArtifact(request)
    }

    final case class DeleteAssociationOp(
      request: DeleteAssociationRequest
    ) extends SageMakerOp[DeleteAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssociationResponse] =
        visitor.deleteAssociation(request)
    }

    final case class DeleteCodeRepositoryOp(
      request: DeleteCodeRepositoryRequest
    ) extends SageMakerOp[DeleteCodeRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCodeRepositoryResponse] =
        visitor.deleteCodeRepository(request)
    }

    final case class DeleteContextOp(
      request: DeleteContextRequest
    ) extends SageMakerOp[DeleteContextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContextResponse] =
        visitor.deleteContext(request)
    }

    final case class DeleteDataQualityJobDefinitionOp(
      request: DeleteDataQualityJobDefinitionRequest
    ) extends SageMakerOp[DeleteDataQualityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataQualityJobDefinitionResponse] =
        visitor.deleteDataQualityJobDefinition(request)
    }

    final case class DeleteDeviceFleetOp(
      request: DeleteDeviceFleetRequest
    ) extends SageMakerOp[DeleteDeviceFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeviceFleetResponse] =
        visitor.deleteDeviceFleet(request)
    }

    final case class DeleteDomainOp(
      request: DeleteDomainRequest
    ) extends SageMakerOp[DeleteDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainResponse] =
        visitor.deleteDomain(request)
    }

    final case class DeleteEndpointOp(
      request: DeleteEndpointRequest
    ) extends SageMakerOp[DeleteEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointResponse] =
        visitor.deleteEndpoint(request)
    }

    final case class DeleteEndpointConfigOp(
      request: DeleteEndpointConfigRequest
    ) extends SageMakerOp[DeleteEndpointConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointConfigResponse] =
        visitor.deleteEndpointConfig(request)
    }

    final case class DeleteExperimentOp(
      request: DeleteExperimentRequest
    ) extends SageMakerOp[DeleteExperimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteExperimentResponse] =
        visitor.deleteExperiment(request)
    }

    final case class DeleteFeatureGroupOp(
      request: DeleteFeatureGroupRequest
    ) extends SageMakerOp[DeleteFeatureGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFeatureGroupResponse] =
        visitor.deleteFeatureGroup(request)
    }

    final case class DeleteFlowDefinitionOp(
      request: DeleteFlowDefinitionRequest
    ) extends SageMakerOp[DeleteFlowDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFlowDefinitionResponse] =
        visitor.deleteFlowDefinition(request)
    }

    final case class DeleteHumanTaskUiOp(
      request: DeleteHumanTaskUiRequest
    ) extends SageMakerOp[DeleteHumanTaskUiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHumanTaskUiResponse] =
        visitor.deleteHumanTaskUi(request)
    }

    final case class DeleteImageOp(
      request: DeleteImageRequest
    ) extends SageMakerOp[DeleteImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImageResponse] =
        visitor.deleteImage(request)
    }

    final case class DeleteImageVersionOp(
      request: DeleteImageVersionRequest
    ) extends SageMakerOp[DeleteImageVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImageVersionResponse] =
        visitor.deleteImageVersion(request)
    }

    final case class DeleteModelOp(
      request: DeleteModelRequest
    ) extends SageMakerOp[DeleteModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelResponse] =
        visitor.deleteModel(request)
    }

    final case class DeleteModelBiasJobDefinitionOp(
      request: DeleteModelBiasJobDefinitionRequest
    ) extends SageMakerOp[DeleteModelBiasJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelBiasJobDefinitionResponse] =
        visitor.deleteModelBiasJobDefinition(request)
    }

    final case class DeleteModelExplainabilityJobDefinitionOp(
      request: DeleteModelExplainabilityJobDefinitionRequest
    ) extends SageMakerOp[DeleteModelExplainabilityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelExplainabilityJobDefinitionResponse] =
        visitor.deleteModelExplainabilityJobDefinition(request)
    }

    final case class DeleteModelPackageOp(
      request: DeleteModelPackageRequest
    ) extends SageMakerOp[DeleteModelPackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelPackageResponse] =
        visitor.deleteModelPackage(request)
    }

    final case class DeleteModelPackageGroupOp(
      request: DeleteModelPackageGroupRequest
    ) extends SageMakerOp[DeleteModelPackageGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelPackageGroupResponse] =
        visitor.deleteModelPackageGroup(request)
    }

    final case class DeleteModelPackageGroupPolicyOp(
      request: DeleteModelPackageGroupPolicyRequest
    ) extends SageMakerOp[DeleteModelPackageGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelPackageGroupPolicyResponse] =
        visitor.deleteModelPackageGroupPolicy(request)
    }

    final case class DeleteModelQualityJobDefinitionOp(
      request: DeleteModelQualityJobDefinitionRequest
    ) extends SageMakerOp[DeleteModelQualityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelQualityJobDefinitionResponse] =
        visitor.deleteModelQualityJobDefinition(request)
    }

    final case class DeleteMonitoringScheduleOp(
      request: DeleteMonitoringScheduleRequest
    ) extends SageMakerOp[DeleteMonitoringScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMonitoringScheduleResponse] =
        visitor.deleteMonitoringSchedule(request)
    }

    final case class DeleteNotebookInstanceOp(
      request: DeleteNotebookInstanceRequest
    ) extends SageMakerOp[DeleteNotebookInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNotebookInstanceResponse] =
        visitor.deleteNotebookInstance(request)
    }

    final case class DeleteNotebookInstanceLifecycleConfigOp(
      request: DeleteNotebookInstanceLifecycleConfigRequest
    ) extends SageMakerOp[DeleteNotebookInstanceLifecycleConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNotebookInstanceLifecycleConfigResponse] =
        visitor.deleteNotebookInstanceLifecycleConfig(request)
    }

    final case class DeletePipelineOp(
      request: DeletePipelineRequest
    ) extends SageMakerOp[DeletePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePipelineResponse] =
        visitor.deletePipeline(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends SageMakerOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends SageMakerOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DeleteTrialOp(
      request: DeleteTrialRequest
    ) extends SageMakerOp[DeleteTrialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrialResponse] =
        visitor.deleteTrial(request)
    }

    final case class DeleteTrialComponentOp(
      request: DeleteTrialComponentRequest
    ) extends SageMakerOp[DeleteTrialComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrialComponentResponse] =
        visitor.deleteTrialComponent(request)
    }

    final case class DeleteUserProfileOp(
      request: DeleteUserProfileRequest
    ) extends SageMakerOp[DeleteUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserProfileResponse] =
        visitor.deleteUserProfile(request)
    }

    final case class DeleteWorkforceOp(
      request: DeleteWorkforceRequest
    ) extends SageMakerOp[DeleteWorkforceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkforceResponse] =
        visitor.deleteWorkforce(request)
    }

    final case class DeleteWorkteamOp(
      request: DeleteWorkteamRequest
    ) extends SageMakerOp[DeleteWorkteamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkteamResponse] =
        visitor.deleteWorkteam(request)
    }

    final case class DeregisterDevicesOp(
      request: DeregisterDevicesRequest
    ) extends SageMakerOp[DeregisterDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterDevicesResponse] =
        visitor.deregisterDevices(request)
    }

    final case class DescribeActionOp(
      request: DescribeActionRequest
    ) extends SageMakerOp[DescribeActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeActionResponse] =
        visitor.describeAction(request)
    }

    final case class DescribeAlgorithmOp(
      request: DescribeAlgorithmRequest
    ) extends SageMakerOp[DescribeAlgorithmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlgorithmResponse] =
        visitor.describeAlgorithm(request)
    }

    final case class DescribeAppOp(
      request: DescribeAppRequest
    ) extends SageMakerOp[DescribeAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAppResponse] =
        visitor.describeApp(request)
    }

    final case class DescribeAppImageConfigOp(
      request: DescribeAppImageConfigRequest
    ) extends SageMakerOp[DescribeAppImageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAppImageConfigResponse] =
        visitor.describeAppImageConfig(request)
    }

    final case class DescribeArtifactOp(
      request: DescribeArtifactRequest
    ) extends SageMakerOp[DescribeArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeArtifactResponse] =
        visitor.describeArtifact(request)
    }

    final case class DescribeAutoMLJobOp(
      request: DescribeAutoMlJobRequest
    ) extends SageMakerOp[DescribeAutoMlJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAutoMlJobResponse] =
        visitor.describeAutoMLJob(request)
    }

    final case class DescribeCodeRepositoryOp(
      request: DescribeCodeRepositoryRequest
    ) extends SageMakerOp[DescribeCodeRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCodeRepositoryResponse] =
        visitor.describeCodeRepository(request)
    }

    final case class DescribeCompilationJobOp(
      request: DescribeCompilationJobRequest
    ) extends SageMakerOp[DescribeCompilationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCompilationJobResponse] =
        visitor.describeCompilationJob(request)
    }

    final case class DescribeContextOp(
      request: DescribeContextRequest
    ) extends SageMakerOp[DescribeContextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContextResponse] =
        visitor.describeContext(request)
    }

    final case class DescribeDataQualityJobDefinitionOp(
      request: DescribeDataQualityJobDefinitionRequest
    ) extends SageMakerOp[DescribeDataQualityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataQualityJobDefinitionResponse] =
        visitor.describeDataQualityJobDefinition(request)
    }

    final case class DescribeDeviceOp(
      request: DescribeDeviceRequest
    ) extends SageMakerOp[DescribeDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeviceResponse] =
        visitor.describeDevice(request)
    }

    final case class DescribeDeviceFleetOp(
      request: DescribeDeviceFleetRequest
    ) extends SageMakerOp[DescribeDeviceFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeviceFleetResponse] =
        visitor.describeDeviceFleet(request)
    }

    final case class DescribeDomainOp(
      request: DescribeDomainRequest
    ) extends SageMakerOp[DescribeDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainResponse] =
        visitor.describeDomain(request)
    }

    final case class DescribeEdgePackagingJobOp(
      request: DescribeEdgePackagingJobRequest
    ) extends SageMakerOp[DescribeEdgePackagingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEdgePackagingJobResponse] =
        visitor.describeEdgePackagingJob(request)
    }

    final case class DescribeEndpointOp(
      request: DescribeEndpointRequest
    ) extends SageMakerOp[DescribeEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointResponse] =
        visitor.describeEndpoint(request)
    }

    final case class DescribeEndpointConfigOp(
      request: DescribeEndpointConfigRequest
    ) extends SageMakerOp[DescribeEndpointConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointConfigResponse] =
        visitor.describeEndpointConfig(request)
    }

    final case class DescribeExperimentOp(
      request: DescribeExperimentRequest
    ) extends SageMakerOp[DescribeExperimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExperimentResponse] =
        visitor.describeExperiment(request)
    }

    final case class DescribeFeatureGroupOp(
      request: DescribeFeatureGroupRequest
    ) extends SageMakerOp[DescribeFeatureGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFeatureGroupResponse] =
        visitor.describeFeatureGroup(request)
    }

    final case class DescribeFlowDefinitionOp(
      request: DescribeFlowDefinitionRequest
    ) extends SageMakerOp[DescribeFlowDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFlowDefinitionResponse] =
        visitor.describeFlowDefinition(request)
    }

    final case class DescribeHumanTaskUiOp(
      request: DescribeHumanTaskUiRequest
    ) extends SageMakerOp[DescribeHumanTaskUiResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHumanTaskUiResponse] =
        visitor.describeHumanTaskUi(request)
    }

    final case class DescribeHyperParameterTuningJobOp(
      request: DescribeHyperParameterTuningJobRequest
    ) extends SageMakerOp[DescribeHyperParameterTuningJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHyperParameterTuningJobResponse] =
        visitor.describeHyperParameterTuningJob(request)
    }

    final case class DescribeImageOp(
      request: DescribeImageRequest
    ) extends SageMakerOp[DescribeImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImageResponse] =
        visitor.describeImage(request)
    }

    final case class DescribeImageVersionOp(
      request: DescribeImageVersionRequest
    ) extends SageMakerOp[DescribeImageVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImageVersionResponse] =
        visitor.describeImageVersion(request)
    }

    final case class DescribeLabelingJobOp(
      request: DescribeLabelingJobRequest
    ) extends SageMakerOp[DescribeLabelingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLabelingJobResponse] =
        visitor.describeLabelingJob(request)
    }

    final case class DescribeModelOp(
      request: DescribeModelRequest
    ) extends SageMakerOp[DescribeModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelResponse] =
        visitor.describeModel(request)
    }

    final case class DescribeModelBiasJobDefinitionOp(
      request: DescribeModelBiasJobDefinitionRequest
    ) extends SageMakerOp[DescribeModelBiasJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelBiasJobDefinitionResponse] =
        visitor.describeModelBiasJobDefinition(request)
    }

    final case class DescribeModelExplainabilityJobDefinitionOp(
      request: DescribeModelExplainabilityJobDefinitionRequest
    ) extends SageMakerOp[DescribeModelExplainabilityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelExplainabilityJobDefinitionResponse] =
        visitor.describeModelExplainabilityJobDefinition(request)
    }

    final case class DescribeModelPackageOp(
      request: DescribeModelPackageRequest
    ) extends SageMakerOp[DescribeModelPackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelPackageResponse] =
        visitor.describeModelPackage(request)
    }

    final case class DescribeModelPackageGroupOp(
      request: DescribeModelPackageGroupRequest
    ) extends SageMakerOp[DescribeModelPackageGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelPackageGroupResponse] =
        visitor.describeModelPackageGroup(request)
    }

    final case class DescribeModelQualityJobDefinitionOp(
      request: DescribeModelQualityJobDefinitionRequest
    ) extends SageMakerOp[DescribeModelQualityJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelQualityJobDefinitionResponse] =
        visitor.describeModelQualityJobDefinition(request)
    }

    final case class DescribeMonitoringScheduleOp(
      request: DescribeMonitoringScheduleRequest
    ) extends SageMakerOp[DescribeMonitoringScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMonitoringScheduleResponse] =
        visitor.describeMonitoringSchedule(request)
    }

    final case class DescribeNotebookInstanceOp(
      request: DescribeNotebookInstanceRequest
    ) extends SageMakerOp[DescribeNotebookInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNotebookInstanceResponse] =
        visitor.describeNotebookInstance(request)
    }

    final case class DescribeNotebookInstanceLifecycleConfigOp(
      request: DescribeNotebookInstanceLifecycleConfigRequest
    ) extends SageMakerOp[DescribeNotebookInstanceLifecycleConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNotebookInstanceLifecycleConfigResponse] =
        visitor.describeNotebookInstanceLifecycleConfig(request)
    }

    final case class DescribePipelineOp(
      request: DescribePipelineRequest
    ) extends SageMakerOp[DescribePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePipelineResponse] =
        visitor.describePipeline(request)
    }

    final case class DescribePipelineDefinitionForExecutionOp(
      request: DescribePipelineDefinitionForExecutionRequest
    ) extends SageMakerOp[DescribePipelineDefinitionForExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePipelineDefinitionForExecutionResponse] =
        visitor.describePipelineDefinitionForExecution(request)
    }

    final case class DescribePipelineExecutionOp(
      request: DescribePipelineExecutionRequest
    ) extends SageMakerOp[DescribePipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePipelineExecutionResponse] =
        visitor.describePipelineExecution(request)
    }

    final case class DescribeProcessingJobOp(
      request: DescribeProcessingJobRequest
    ) extends SageMakerOp[DescribeProcessingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProcessingJobResponse] =
        visitor.describeProcessingJob(request)
    }

    final case class DescribeProjectOp(
      request: DescribeProjectRequest
    ) extends SageMakerOp[DescribeProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectResponse] =
        visitor.describeProject(request)
    }

    final case class DescribeSubscribedWorkteamOp(
      request: DescribeSubscribedWorkteamRequest
    ) extends SageMakerOp[DescribeSubscribedWorkteamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSubscribedWorkteamResponse] =
        visitor.describeSubscribedWorkteam(request)
    }

    final case class DescribeTrainingJobOp(
      request: DescribeTrainingJobRequest
    ) extends SageMakerOp[DescribeTrainingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrainingJobResponse] =
        visitor.describeTrainingJob(request)
    }

    final case class DescribeTransformJobOp(
      request: DescribeTransformJobRequest
    ) extends SageMakerOp[DescribeTransformJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTransformJobResponse] =
        visitor.describeTransformJob(request)
    }

    final case class DescribeTrialOp(
      request: DescribeTrialRequest
    ) extends SageMakerOp[DescribeTrialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrialResponse] =
        visitor.describeTrial(request)
    }

    final case class DescribeTrialComponentOp(
      request: DescribeTrialComponentRequest
    ) extends SageMakerOp[DescribeTrialComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrialComponentResponse] =
        visitor.describeTrialComponent(request)
    }

    final case class DescribeUserProfileOp(
      request: DescribeUserProfileRequest
    ) extends SageMakerOp[DescribeUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserProfileResponse] =
        visitor.describeUserProfile(request)
    }

    final case class DescribeWorkforceOp(
      request: DescribeWorkforceRequest
    ) extends SageMakerOp[DescribeWorkforceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkforceResponse] =
        visitor.describeWorkforce(request)
    }

    final case class DescribeWorkteamOp(
      request: DescribeWorkteamRequest
    ) extends SageMakerOp[DescribeWorkteamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkteamResponse] =
        visitor.describeWorkteam(request)
    }

    final case class DisableSagemakerServicecatalogPortfolioOp(
      request: DisableSagemakerServicecatalogPortfolioRequest
    ) extends SageMakerOp[DisableSagemakerServicecatalogPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableSagemakerServicecatalogPortfolioResponse] =
        visitor.disableSagemakerServicecatalogPortfolio(request)
    }

    final case class DisassociateTrialComponentOp(
      request: DisassociateTrialComponentRequest
    ) extends SageMakerOp[DisassociateTrialComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateTrialComponentResponse] =
        visitor.disassociateTrialComponent(request)
    }

    final case class EnableSagemakerServicecatalogPortfolioOp(
      request: EnableSagemakerServicecatalogPortfolioRequest
    ) extends SageMakerOp[EnableSagemakerServicecatalogPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableSagemakerServicecatalogPortfolioResponse] =
        visitor.enableSagemakerServicecatalogPortfolio(request)
    }

    final case class GetDeviceFleetReportOp(
      request: GetDeviceFleetReportRequest
    ) extends SageMakerOp[GetDeviceFleetReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceFleetReportResponse] =
        visitor.getDeviceFleetReport(request)
    }

    final case class GetModelPackageGroupPolicyOp(
      request: GetModelPackageGroupPolicyRequest
    ) extends SageMakerOp[GetModelPackageGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetModelPackageGroupPolicyResponse] =
        visitor.getModelPackageGroupPolicy(request)
    }

    final case class GetSagemakerServicecatalogPortfolioStatusOp(
      request: GetSagemakerServicecatalogPortfolioStatusRequest
    ) extends SageMakerOp[GetSagemakerServicecatalogPortfolioStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSagemakerServicecatalogPortfolioStatusResponse] =
        visitor.getSagemakerServicecatalogPortfolioStatus(request)
    }

    final case class GetSearchSuggestionsOp(
      request: GetSearchSuggestionsRequest
    ) extends SageMakerOp[GetSearchSuggestionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSearchSuggestionsResponse] =
        visitor.getSearchSuggestions(request)
    }

    final case class ListActionsOp(
      request: ListActionsRequest
    ) extends SageMakerOp[ListActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActionsResponse] =
        visitor.listActions(request)
    }

    final case class ListAlgorithmsOp(
      request: ListAlgorithmsRequest
    ) extends SageMakerOp[ListAlgorithmsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAlgorithmsResponse] =
        visitor.listAlgorithms(request)
    }

    final case class ListAppImageConfigsOp(
      request: ListAppImageConfigsRequest
    ) extends SageMakerOp[ListAppImageConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppImageConfigsResponse] =
        visitor.listAppImageConfigs(request)
    }

    final case class ListAppsOp(
      request: ListAppsRequest
    ) extends SageMakerOp[ListAppsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppsResponse] =
        visitor.listApps(request)
    }

    final case class ListArtifactsOp(
      request: ListArtifactsRequest
    ) extends SageMakerOp[ListArtifactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListArtifactsResponse] =
        visitor.listArtifacts(request)
    }

    final case class ListAssociationsOp(
      request: ListAssociationsRequest
    ) extends SageMakerOp[ListAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociationsResponse] =
        visitor.listAssociations(request)
    }

    final case class ListAutoMLJobsOp(
      request: ListAutoMlJobsRequest
    ) extends SageMakerOp[ListAutoMlJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAutoMlJobsResponse] =
        visitor.listAutoMLJobs(request)
    }

    final case class ListCandidatesForAutoMLJobOp(
      request: ListCandidatesForAutoMlJobRequest
    ) extends SageMakerOp[ListCandidatesForAutoMlJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCandidatesForAutoMlJobResponse] =
        visitor.listCandidatesForAutoMLJob(request)
    }

    final case class ListCodeRepositoriesOp(
      request: ListCodeRepositoriesRequest
    ) extends SageMakerOp[ListCodeRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCodeRepositoriesResponse] =
        visitor.listCodeRepositories(request)
    }

    final case class ListCompilationJobsOp(
      request: ListCompilationJobsRequest
    ) extends SageMakerOp[ListCompilationJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCompilationJobsResponse] =
        visitor.listCompilationJobs(request)
    }

    final case class ListContextsOp(
      request: ListContextsRequest
    ) extends SageMakerOp[ListContextsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContextsResponse] =
        visitor.listContexts(request)
    }

    final case class ListDataQualityJobDefinitionsOp(
      request: ListDataQualityJobDefinitionsRequest
    ) extends SageMakerOp[ListDataQualityJobDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataQualityJobDefinitionsResponse] =
        visitor.listDataQualityJobDefinitions(request)
    }

    final case class ListDeviceFleetsOp(
      request: ListDeviceFleetsRequest
    ) extends SageMakerOp[ListDeviceFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeviceFleetsResponse] =
        visitor.listDeviceFleets(request)
    }

    final case class ListDevicesOp(
      request: ListDevicesRequest
    ) extends SageMakerOp[ListDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevicesResponse] =
        visitor.listDevices(request)
    }

    final case class ListDomainsOp(
      request: ListDomainsRequest
    ) extends SageMakerOp[ListDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainsResponse] =
        visitor.listDomains(request)
    }

    final case class ListEdgePackagingJobsOp(
      request: ListEdgePackagingJobsRequest
    ) extends SageMakerOp[ListEdgePackagingJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEdgePackagingJobsResponse] =
        visitor.listEdgePackagingJobs(request)
    }

    final case class ListEndpointConfigsOp(
      request: ListEndpointConfigsRequest
    ) extends SageMakerOp[ListEndpointConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEndpointConfigsResponse] =
        visitor.listEndpointConfigs(request)
    }

    final case class ListEndpointsOp(
      request: ListEndpointsRequest
    ) extends SageMakerOp[ListEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEndpointsResponse] =
        visitor.listEndpoints(request)
    }

    final case class ListExperimentsOp(
      request: ListExperimentsRequest
    ) extends SageMakerOp[ListExperimentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExperimentsResponse] =
        visitor.listExperiments(request)
    }

    final case class ListFeatureGroupsOp(
      request: ListFeatureGroupsRequest
    ) extends SageMakerOp[ListFeatureGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFeatureGroupsResponse] =
        visitor.listFeatureGroups(request)
    }

    final case class ListFlowDefinitionsOp(
      request: ListFlowDefinitionsRequest
    ) extends SageMakerOp[ListFlowDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFlowDefinitionsResponse] =
        visitor.listFlowDefinitions(request)
    }

    final case class ListHumanTaskUisOp(
      request: ListHumanTaskUisRequest
    ) extends SageMakerOp[ListHumanTaskUisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHumanTaskUisResponse] =
        visitor.listHumanTaskUis(request)
    }

    final case class ListHyperParameterTuningJobsOp(
      request: ListHyperParameterTuningJobsRequest
    ) extends SageMakerOp[ListHyperParameterTuningJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHyperParameterTuningJobsResponse] =
        visitor.listHyperParameterTuningJobs(request)
    }

    final case class ListImageVersionsOp(
      request: ListImageVersionsRequest
    ) extends SageMakerOp[ListImageVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImageVersionsResponse] =
        visitor.listImageVersions(request)
    }

    final case class ListImagesOp(
      request: ListImagesRequest
    ) extends SageMakerOp[ListImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImagesResponse] =
        visitor.listImages(request)
    }

    final case class ListLabelingJobsOp(
      request: ListLabelingJobsRequest
    ) extends SageMakerOp[ListLabelingJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLabelingJobsResponse] =
        visitor.listLabelingJobs(request)
    }

    final case class ListLabelingJobsForWorkteamOp(
      request: ListLabelingJobsForWorkteamRequest
    ) extends SageMakerOp[ListLabelingJobsForWorkteamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLabelingJobsForWorkteamResponse] =
        visitor.listLabelingJobsForWorkteam(request)
    }

    final case class ListModelBiasJobDefinitionsOp(
      request: ListModelBiasJobDefinitionsRequest
    ) extends SageMakerOp[ListModelBiasJobDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelBiasJobDefinitionsResponse] =
        visitor.listModelBiasJobDefinitions(request)
    }

    final case class ListModelExplainabilityJobDefinitionsOp(
      request: ListModelExplainabilityJobDefinitionsRequest
    ) extends SageMakerOp[ListModelExplainabilityJobDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelExplainabilityJobDefinitionsResponse] =
        visitor.listModelExplainabilityJobDefinitions(request)
    }

    final case class ListModelPackageGroupsOp(
      request: ListModelPackageGroupsRequest
    ) extends SageMakerOp[ListModelPackageGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelPackageGroupsResponse] =
        visitor.listModelPackageGroups(request)
    }

    final case class ListModelPackagesOp(
      request: ListModelPackagesRequest
    ) extends SageMakerOp[ListModelPackagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelPackagesResponse] =
        visitor.listModelPackages(request)
    }

    final case class ListModelQualityJobDefinitionsOp(
      request: ListModelQualityJobDefinitionsRequest
    ) extends SageMakerOp[ListModelQualityJobDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelQualityJobDefinitionsResponse] =
        visitor.listModelQualityJobDefinitions(request)
    }

    final case class ListModelsOp(
      request: ListModelsRequest
    ) extends SageMakerOp[ListModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelsResponse] =
        visitor.listModels(request)
    }

    final case class ListMonitoringExecutionsOp(
      request: ListMonitoringExecutionsRequest
    ) extends SageMakerOp[ListMonitoringExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMonitoringExecutionsResponse] =
        visitor.listMonitoringExecutions(request)
    }

    final case class ListMonitoringSchedulesOp(
      request: ListMonitoringSchedulesRequest
    ) extends SageMakerOp[ListMonitoringSchedulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMonitoringSchedulesResponse] =
        visitor.listMonitoringSchedules(request)
    }

    final case class ListNotebookInstanceLifecycleConfigsOp(
      request: ListNotebookInstanceLifecycleConfigsRequest
    ) extends SageMakerOp[ListNotebookInstanceLifecycleConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNotebookInstanceLifecycleConfigsResponse] =
        visitor.listNotebookInstanceLifecycleConfigs(request)
    }

    final case class ListNotebookInstancesOp(
      request: ListNotebookInstancesRequest
    ) extends SageMakerOp[ListNotebookInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNotebookInstancesResponse] =
        visitor.listNotebookInstances(request)
    }

    final case class ListPipelineExecutionStepsOp(
      request: ListPipelineExecutionStepsRequest
    ) extends SageMakerOp[ListPipelineExecutionStepsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelineExecutionStepsResponse] =
        visitor.listPipelineExecutionSteps(request)
    }

    final case class ListPipelineExecutionsOp(
      request: ListPipelineExecutionsRequest
    ) extends SageMakerOp[ListPipelineExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelineExecutionsResponse] =
        visitor.listPipelineExecutions(request)
    }

    final case class ListPipelineParametersForExecutionOp(
      request: ListPipelineParametersForExecutionRequest
    ) extends SageMakerOp[ListPipelineParametersForExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelineParametersForExecutionResponse] =
        visitor.listPipelineParametersForExecution(request)
    }

    final case class ListPipelinesOp(
      request: ListPipelinesRequest
    ) extends SageMakerOp[ListPipelinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelinesResponse] =
        visitor.listPipelines(request)
    }

    final case class ListProcessingJobsOp(
      request: ListProcessingJobsRequest
    ) extends SageMakerOp[ListProcessingJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProcessingJobsResponse] =
        visitor.listProcessingJobs(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends SageMakerOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListSubscribedWorkteamsOp(
      request: ListSubscribedWorkteamsRequest
    ) extends SageMakerOp[ListSubscribedWorkteamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSubscribedWorkteamsResponse] =
        visitor.listSubscribedWorkteams(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends SageMakerOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class ListTrainingJobsOp(
      request: ListTrainingJobsRequest
    ) extends SageMakerOp[ListTrainingJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrainingJobsResponse] =
        visitor.listTrainingJobs(request)
    }

    final case class ListTrainingJobsForHyperParameterTuningJobOp(
      request: ListTrainingJobsForHyperParameterTuningJobRequest
    ) extends SageMakerOp[ListTrainingJobsForHyperParameterTuningJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrainingJobsForHyperParameterTuningJobResponse] =
        visitor.listTrainingJobsForHyperParameterTuningJob(request)
    }

    final case class ListTransformJobsOp(
      request: ListTransformJobsRequest
    ) extends SageMakerOp[ListTransformJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTransformJobsResponse] =
        visitor.listTransformJobs(request)
    }

    final case class ListTrialComponentsOp(
      request: ListTrialComponentsRequest
    ) extends SageMakerOp[ListTrialComponentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrialComponentsResponse] =
        visitor.listTrialComponents(request)
    }

    final case class ListTrialsOp(
      request: ListTrialsRequest
    ) extends SageMakerOp[ListTrialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrialsResponse] =
        visitor.listTrials(request)
    }

    final case class ListUserProfilesOp(
      request: ListUserProfilesRequest
    ) extends SageMakerOp[ListUserProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserProfilesResponse] =
        visitor.listUserProfiles(request)
    }

    final case class ListWorkforcesOp(
      request: ListWorkforcesRequest
    ) extends SageMakerOp[ListWorkforcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkforcesResponse] =
        visitor.listWorkforces(request)
    }

    final case class ListWorkteamsOp(
      request: ListWorkteamsRequest
    ) extends SageMakerOp[ListWorkteamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkteamsResponse] =
        visitor.listWorkteams(request)
    }

    final case class PutModelPackageGroupPolicyOp(
      request: PutModelPackageGroupPolicyRequest
    ) extends SageMakerOp[PutModelPackageGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutModelPackageGroupPolicyResponse] =
        visitor.putModelPackageGroupPolicy(request)
    }

    final case class RegisterDevicesOp(
      request: RegisterDevicesRequest
    ) extends SageMakerOp[RegisterDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterDevicesResponse] =
        visitor.registerDevices(request)
    }

    final case class RenderUiTemplateOp(
      request: RenderUiTemplateRequest
    ) extends SageMakerOp[RenderUiTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RenderUiTemplateResponse] =
        visitor.renderUiTemplate(request)
    }

    final case class SearchOp(
      request: SearchRequest
    ) extends SageMakerOp[SearchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchResponse] =
        visitor.search(request)
    }

    final case class SendPipelineExecutionStepFailureOp(
      request: SendPipelineExecutionStepFailureRequest
    ) extends SageMakerOp[SendPipelineExecutionStepFailureResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendPipelineExecutionStepFailureResponse] =
        visitor.sendPipelineExecutionStepFailure(request)
    }

    final case class SendPipelineExecutionStepSuccessOp(
      request: SendPipelineExecutionStepSuccessRequest
    ) extends SageMakerOp[SendPipelineExecutionStepSuccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendPipelineExecutionStepSuccessResponse] =
        visitor.sendPipelineExecutionStepSuccess(request)
    }

    final case class StartMonitoringScheduleOp(
      request: StartMonitoringScheduleRequest
    ) extends SageMakerOp[StartMonitoringScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMonitoringScheduleResponse] =
        visitor.startMonitoringSchedule(request)
    }

    final case class StartNotebookInstanceOp(
      request: StartNotebookInstanceRequest
    ) extends SageMakerOp[StartNotebookInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartNotebookInstanceResponse] =
        visitor.startNotebookInstance(request)
    }

    final case class StartPipelineExecutionOp(
      request: StartPipelineExecutionRequest
    ) extends SageMakerOp[StartPipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartPipelineExecutionResponse] =
        visitor.startPipelineExecution(request)
    }

    final case class StopAutoMLJobOp(
      request: StopAutoMlJobRequest
    ) extends SageMakerOp[StopAutoMlJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopAutoMlJobResponse] =
        visitor.stopAutoMLJob(request)
    }

    final case class StopCompilationJobOp(
      request: StopCompilationJobRequest
    ) extends SageMakerOp[StopCompilationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopCompilationJobResponse] =
        visitor.stopCompilationJob(request)
    }

    final case class StopEdgePackagingJobOp(
      request: StopEdgePackagingJobRequest
    ) extends SageMakerOp[StopEdgePackagingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopEdgePackagingJobResponse] =
        visitor.stopEdgePackagingJob(request)
    }

    final case class StopHyperParameterTuningJobOp(
      request: StopHyperParameterTuningJobRequest
    ) extends SageMakerOp[StopHyperParameterTuningJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopHyperParameterTuningJobResponse] =
        visitor.stopHyperParameterTuningJob(request)
    }

    final case class StopLabelingJobOp(
      request: StopLabelingJobRequest
    ) extends SageMakerOp[StopLabelingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopLabelingJobResponse] =
        visitor.stopLabelingJob(request)
    }

    final case class StopMonitoringScheduleOp(
      request: StopMonitoringScheduleRequest
    ) extends SageMakerOp[StopMonitoringScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopMonitoringScheduleResponse] =
        visitor.stopMonitoringSchedule(request)
    }

    final case class StopNotebookInstanceOp(
      request: StopNotebookInstanceRequest
    ) extends SageMakerOp[StopNotebookInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopNotebookInstanceResponse] =
        visitor.stopNotebookInstance(request)
    }

    final case class StopPipelineExecutionOp(
      request: StopPipelineExecutionRequest
    ) extends SageMakerOp[StopPipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopPipelineExecutionResponse] =
        visitor.stopPipelineExecution(request)
    }

    final case class StopProcessingJobOp(
      request: StopProcessingJobRequest
    ) extends SageMakerOp[StopProcessingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopProcessingJobResponse] =
        visitor.stopProcessingJob(request)
    }

    final case class StopTrainingJobOp(
      request: StopTrainingJobRequest
    ) extends SageMakerOp[StopTrainingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopTrainingJobResponse] =
        visitor.stopTrainingJob(request)
    }

    final case class StopTransformJobOp(
      request: StopTransformJobRequest
    ) extends SageMakerOp[StopTransformJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopTransformJobResponse] =
        visitor.stopTransformJob(request)
    }

    final case class UpdateActionOp(
      request: UpdateActionRequest
    ) extends SageMakerOp[UpdateActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateActionResponse] =
        visitor.updateAction(request)
    }

    final case class UpdateAppImageConfigOp(
      request: UpdateAppImageConfigRequest
    ) extends SageMakerOp[UpdateAppImageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAppImageConfigResponse] =
        visitor.updateAppImageConfig(request)
    }

    final case class UpdateArtifactOp(
      request: UpdateArtifactRequest
    ) extends SageMakerOp[UpdateArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateArtifactResponse] =
        visitor.updateArtifact(request)
    }

    final case class UpdateCodeRepositoryOp(
      request: UpdateCodeRepositoryRequest
    ) extends SageMakerOp[UpdateCodeRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCodeRepositoryResponse] =
        visitor.updateCodeRepository(request)
    }

    final case class UpdateContextOp(
      request: UpdateContextRequest
    ) extends SageMakerOp[UpdateContextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContextResponse] =
        visitor.updateContext(request)
    }

    final case class UpdateDeviceFleetOp(
      request: UpdateDeviceFleetRequest
    ) extends SageMakerOp[UpdateDeviceFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeviceFleetResponse] =
        visitor.updateDeviceFleet(request)
    }

    final case class UpdateDevicesOp(
      request: UpdateDevicesRequest
    ) extends SageMakerOp[UpdateDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDevicesResponse] =
        visitor.updateDevices(request)
    }

    final case class UpdateDomainOp(
      request: UpdateDomainRequest
    ) extends SageMakerOp[UpdateDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainResponse] =
        visitor.updateDomain(request)
    }

    final case class UpdateEndpointOp(
      request: UpdateEndpointRequest
    ) extends SageMakerOp[UpdateEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEndpointResponse] =
        visitor.updateEndpoint(request)
    }

    final case class UpdateEndpointWeightsAndCapacitiesOp(
      request: UpdateEndpointWeightsAndCapacitiesRequest
    ) extends SageMakerOp[UpdateEndpointWeightsAndCapacitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEndpointWeightsAndCapacitiesResponse] =
        visitor.updateEndpointWeightsAndCapacities(request)
    }

    final case class UpdateExperimentOp(
      request: UpdateExperimentRequest
    ) extends SageMakerOp[UpdateExperimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateExperimentResponse] =
        visitor.updateExperiment(request)
    }

    final case class UpdateImageOp(
      request: UpdateImageRequest
    ) extends SageMakerOp[UpdateImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateImageResponse] =
        visitor.updateImage(request)
    }

    final case class UpdateModelPackageOp(
      request: UpdateModelPackageRequest
    ) extends SageMakerOp[UpdateModelPackageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateModelPackageResponse] =
        visitor.updateModelPackage(request)
    }

    final case class UpdateMonitoringScheduleOp(
      request: UpdateMonitoringScheduleRequest
    ) extends SageMakerOp[UpdateMonitoringScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMonitoringScheduleResponse] =
        visitor.updateMonitoringSchedule(request)
    }

    final case class UpdateNotebookInstanceOp(
      request: UpdateNotebookInstanceRequest
    ) extends SageMakerOp[UpdateNotebookInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNotebookInstanceResponse] =
        visitor.updateNotebookInstance(request)
    }

    final case class UpdateNotebookInstanceLifecycleConfigOp(
      request: UpdateNotebookInstanceLifecycleConfigRequest
    ) extends SageMakerOp[UpdateNotebookInstanceLifecycleConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNotebookInstanceLifecycleConfigResponse] =
        visitor.updateNotebookInstanceLifecycleConfig(request)
    }

    final case class UpdatePipelineOp(
      request: UpdatePipelineRequest
    ) extends SageMakerOp[UpdatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePipelineResponse] =
        visitor.updatePipeline(request)
    }

    final case class UpdatePipelineExecutionOp(
      request: UpdatePipelineExecutionRequest
    ) extends SageMakerOp[UpdatePipelineExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePipelineExecutionResponse] =
        visitor.updatePipelineExecution(request)
    }

    final case class UpdateTrainingJobOp(
      request: UpdateTrainingJobRequest
    ) extends SageMakerOp[UpdateTrainingJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTrainingJobResponse] =
        visitor.updateTrainingJob(request)
    }

    final case class UpdateTrialOp(
      request: UpdateTrialRequest
    ) extends SageMakerOp[UpdateTrialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTrialResponse] =
        visitor.updateTrial(request)
    }

    final case class UpdateTrialComponentOp(
      request: UpdateTrialComponentRequest
    ) extends SageMakerOp[UpdateTrialComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTrialComponentResponse] =
        visitor.updateTrialComponent(request)
    }

    final case class UpdateUserProfileOp(
      request: UpdateUserProfileRequest
    ) extends SageMakerOp[UpdateUserProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserProfileResponse] =
        visitor.updateUserProfile(request)
    }

    final case class UpdateWorkforceOp(
      request: UpdateWorkforceRequest
    ) extends SageMakerOp[UpdateWorkforceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkforceResponse] =
        visitor.updateWorkforce(request)
    }

    final case class UpdateWorkteamOp(
      request: UpdateWorkteamRequest
    ) extends SageMakerOp[UpdateWorkteamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkteamResponse] =
        visitor.updateWorkteam(request)
    }
  }

  import SageMakerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SageMakerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addAssociation(
    request: AddAssociationRequest
  ): SageMakerIO[AddAssociationResponse] =
    FF.liftF(AddAssociationOp(request))

  def addTags(
    request: AddTagsRequest
  ): SageMakerIO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def associateTrialComponent(
    request: AssociateTrialComponentRequest
  ): SageMakerIO[AssociateTrialComponentResponse] =
    FF.liftF(AssociateTrialComponentOp(request))

  def createAction(
    request: CreateActionRequest
  ): SageMakerIO[CreateActionResponse] =
    FF.liftF(CreateActionOp(request))

  def createAlgorithm(
    request: CreateAlgorithmRequest
  ): SageMakerIO[CreateAlgorithmResponse] =
    FF.liftF(CreateAlgorithmOp(request))

  def createApp(
    request: CreateAppRequest
  ): SageMakerIO[CreateAppResponse] =
    FF.liftF(CreateAppOp(request))

  def createAppImageConfig(
    request: CreateAppImageConfigRequest
  ): SageMakerIO[CreateAppImageConfigResponse] =
    FF.liftF(CreateAppImageConfigOp(request))

  def createArtifact(
    request: CreateArtifactRequest
  ): SageMakerIO[CreateArtifactResponse] =
    FF.liftF(CreateArtifactOp(request))

  def createAutoMLJob(
    request: CreateAutoMlJobRequest
  ): SageMakerIO[CreateAutoMlJobResponse] =
    FF.liftF(CreateAutoMLJobOp(request))

  def createCodeRepository(
    request: CreateCodeRepositoryRequest
  ): SageMakerIO[CreateCodeRepositoryResponse] =
    FF.liftF(CreateCodeRepositoryOp(request))

  def createCompilationJob(
    request: CreateCompilationJobRequest
  ): SageMakerIO[CreateCompilationJobResponse] =
    FF.liftF(CreateCompilationJobOp(request))

  def createContext(
    request: CreateContextRequest
  ): SageMakerIO[CreateContextResponse] =
    FF.liftF(CreateContextOp(request))

  def createDataQualityJobDefinition(
    request: CreateDataQualityJobDefinitionRequest
  ): SageMakerIO[CreateDataQualityJobDefinitionResponse] =
    FF.liftF(CreateDataQualityJobDefinitionOp(request))

  def createDeviceFleet(
    request: CreateDeviceFleetRequest
  ): SageMakerIO[CreateDeviceFleetResponse] =
    FF.liftF(CreateDeviceFleetOp(request))

  def createDomain(
    request: CreateDomainRequest
  ): SageMakerIO[CreateDomainResponse] =
    FF.liftF(CreateDomainOp(request))

  def createEdgePackagingJob(
    request: CreateEdgePackagingJobRequest
  ): SageMakerIO[CreateEdgePackagingJobResponse] =
    FF.liftF(CreateEdgePackagingJobOp(request))

  def createEndpoint(
    request: CreateEndpointRequest
  ): SageMakerIO[CreateEndpointResponse] =
    FF.liftF(CreateEndpointOp(request))

  def createEndpointConfig(
    request: CreateEndpointConfigRequest
  ): SageMakerIO[CreateEndpointConfigResponse] =
    FF.liftF(CreateEndpointConfigOp(request))

  def createExperiment(
    request: CreateExperimentRequest
  ): SageMakerIO[CreateExperimentResponse] =
    FF.liftF(CreateExperimentOp(request))

  def createFeatureGroup(
    request: CreateFeatureGroupRequest
  ): SageMakerIO[CreateFeatureGroupResponse] =
    FF.liftF(CreateFeatureGroupOp(request))

  def createFlowDefinition(
    request: CreateFlowDefinitionRequest
  ): SageMakerIO[CreateFlowDefinitionResponse] =
    FF.liftF(CreateFlowDefinitionOp(request))

  def createHumanTaskUi(
    request: CreateHumanTaskUiRequest
  ): SageMakerIO[CreateHumanTaskUiResponse] =
    FF.liftF(CreateHumanTaskUiOp(request))

  def createHyperParameterTuningJob(
    request: CreateHyperParameterTuningJobRequest
  ): SageMakerIO[CreateHyperParameterTuningJobResponse] =
    FF.liftF(CreateHyperParameterTuningJobOp(request))

  def createImage(
    request: CreateImageRequest
  ): SageMakerIO[CreateImageResponse] =
    FF.liftF(CreateImageOp(request))

  def createImageVersion(
    request: CreateImageVersionRequest
  ): SageMakerIO[CreateImageVersionResponse] =
    FF.liftF(CreateImageVersionOp(request))

  def createLabelingJob(
    request: CreateLabelingJobRequest
  ): SageMakerIO[CreateLabelingJobResponse] =
    FF.liftF(CreateLabelingJobOp(request))

  def createModel(
    request: CreateModelRequest
  ): SageMakerIO[CreateModelResponse] =
    FF.liftF(CreateModelOp(request))

  def createModelBiasJobDefinition(
    request: CreateModelBiasJobDefinitionRequest
  ): SageMakerIO[CreateModelBiasJobDefinitionResponse] =
    FF.liftF(CreateModelBiasJobDefinitionOp(request))

  def createModelExplainabilityJobDefinition(
    request: CreateModelExplainabilityJobDefinitionRequest
  ): SageMakerIO[CreateModelExplainabilityJobDefinitionResponse] =
    FF.liftF(CreateModelExplainabilityJobDefinitionOp(request))

  def createModelPackage(
    request: CreateModelPackageRequest
  ): SageMakerIO[CreateModelPackageResponse] =
    FF.liftF(CreateModelPackageOp(request))

  def createModelPackageGroup(
    request: CreateModelPackageGroupRequest
  ): SageMakerIO[CreateModelPackageGroupResponse] =
    FF.liftF(CreateModelPackageGroupOp(request))

  def createModelQualityJobDefinition(
    request: CreateModelQualityJobDefinitionRequest
  ): SageMakerIO[CreateModelQualityJobDefinitionResponse] =
    FF.liftF(CreateModelQualityJobDefinitionOp(request))

  def createMonitoringSchedule(
    request: CreateMonitoringScheduleRequest
  ): SageMakerIO[CreateMonitoringScheduleResponse] =
    FF.liftF(CreateMonitoringScheduleOp(request))

  def createNotebookInstance(
    request: CreateNotebookInstanceRequest
  ): SageMakerIO[CreateNotebookInstanceResponse] =
    FF.liftF(CreateNotebookInstanceOp(request))

  def createNotebookInstanceLifecycleConfig(
    request: CreateNotebookInstanceLifecycleConfigRequest
  ): SageMakerIO[CreateNotebookInstanceLifecycleConfigResponse] =
    FF.liftF(CreateNotebookInstanceLifecycleConfigOp(request))

  def createPipeline(
    request: CreatePipelineRequest
  ): SageMakerIO[CreatePipelineResponse] =
    FF.liftF(CreatePipelineOp(request))

  def createPresignedDomainUrl(
    request: CreatePresignedDomainUrlRequest
  ): SageMakerIO[CreatePresignedDomainUrlResponse] =
    FF.liftF(CreatePresignedDomainUrlOp(request))

  def createPresignedNotebookInstanceUrl(
    request: CreatePresignedNotebookInstanceUrlRequest
  ): SageMakerIO[CreatePresignedNotebookInstanceUrlResponse] =
    FF.liftF(CreatePresignedNotebookInstanceUrlOp(request))

  def createProcessingJob(
    request: CreateProcessingJobRequest
  ): SageMakerIO[CreateProcessingJobResponse] =
    FF.liftF(CreateProcessingJobOp(request))

  def createProject(
    request: CreateProjectRequest
  ): SageMakerIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def createTrainingJob(
    request: CreateTrainingJobRequest
  ): SageMakerIO[CreateTrainingJobResponse] =
    FF.liftF(CreateTrainingJobOp(request))

  def createTransformJob(
    request: CreateTransformJobRequest
  ): SageMakerIO[CreateTransformJobResponse] =
    FF.liftF(CreateTransformJobOp(request))

  def createTrial(
    request: CreateTrialRequest
  ): SageMakerIO[CreateTrialResponse] =
    FF.liftF(CreateTrialOp(request))

  def createTrialComponent(
    request: CreateTrialComponentRequest
  ): SageMakerIO[CreateTrialComponentResponse] =
    FF.liftF(CreateTrialComponentOp(request))

  def createUserProfile(
    request: CreateUserProfileRequest
  ): SageMakerIO[CreateUserProfileResponse] =
    FF.liftF(CreateUserProfileOp(request))

  def createWorkforce(
    request: CreateWorkforceRequest
  ): SageMakerIO[CreateWorkforceResponse] =
    FF.liftF(CreateWorkforceOp(request))

  def createWorkteam(
    request: CreateWorkteamRequest
  ): SageMakerIO[CreateWorkteamResponse] =
    FF.liftF(CreateWorkteamOp(request))

  def deleteAction(
    request: DeleteActionRequest
  ): SageMakerIO[DeleteActionResponse] =
    FF.liftF(DeleteActionOp(request))

  def deleteAlgorithm(
    request: DeleteAlgorithmRequest
  ): SageMakerIO[DeleteAlgorithmResponse] =
    FF.liftF(DeleteAlgorithmOp(request))

  def deleteApp(
    request: DeleteAppRequest
  ): SageMakerIO[DeleteAppResponse] =
    FF.liftF(DeleteAppOp(request))

  def deleteAppImageConfig(
    request: DeleteAppImageConfigRequest
  ): SageMakerIO[DeleteAppImageConfigResponse] =
    FF.liftF(DeleteAppImageConfigOp(request))

  def deleteArtifact(
    request: DeleteArtifactRequest
  ): SageMakerIO[DeleteArtifactResponse] =
    FF.liftF(DeleteArtifactOp(request))

  def deleteAssociation(
    request: DeleteAssociationRequest
  ): SageMakerIO[DeleteAssociationResponse] =
    FF.liftF(DeleteAssociationOp(request))

  def deleteCodeRepository(
    request: DeleteCodeRepositoryRequest
  ): SageMakerIO[DeleteCodeRepositoryResponse] =
    FF.liftF(DeleteCodeRepositoryOp(request))

  def deleteContext(
    request: DeleteContextRequest
  ): SageMakerIO[DeleteContextResponse] =
    FF.liftF(DeleteContextOp(request))

  def deleteDataQualityJobDefinition(
    request: DeleteDataQualityJobDefinitionRequest
  ): SageMakerIO[DeleteDataQualityJobDefinitionResponse] =
    FF.liftF(DeleteDataQualityJobDefinitionOp(request))

  def deleteDeviceFleet(
    request: DeleteDeviceFleetRequest
  ): SageMakerIO[DeleteDeviceFleetResponse] =
    FF.liftF(DeleteDeviceFleetOp(request))

  def deleteDomain(
    request: DeleteDomainRequest
  ): SageMakerIO[DeleteDomainResponse] =
    FF.liftF(DeleteDomainOp(request))

  def deleteEndpoint(
    request: DeleteEndpointRequest
  ): SageMakerIO[DeleteEndpointResponse] =
    FF.liftF(DeleteEndpointOp(request))

  def deleteEndpointConfig(
    request: DeleteEndpointConfigRequest
  ): SageMakerIO[DeleteEndpointConfigResponse] =
    FF.liftF(DeleteEndpointConfigOp(request))

  def deleteExperiment(
    request: DeleteExperimentRequest
  ): SageMakerIO[DeleteExperimentResponse] =
    FF.liftF(DeleteExperimentOp(request))

  def deleteFeatureGroup(
    request: DeleteFeatureGroupRequest
  ): SageMakerIO[DeleteFeatureGroupResponse] =
    FF.liftF(DeleteFeatureGroupOp(request))

  def deleteFlowDefinition(
    request: DeleteFlowDefinitionRequest
  ): SageMakerIO[DeleteFlowDefinitionResponse] =
    FF.liftF(DeleteFlowDefinitionOp(request))

  def deleteHumanTaskUi(
    request: DeleteHumanTaskUiRequest
  ): SageMakerIO[DeleteHumanTaskUiResponse] =
    FF.liftF(DeleteHumanTaskUiOp(request))

  def deleteImage(
    request: DeleteImageRequest
  ): SageMakerIO[DeleteImageResponse] =
    FF.liftF(DeleteImageOp(request))

  def deleteImageVersion(
    request: DeleteImageVersionRequest
  ): SageMakerIO[DeleteImageVersionResponse] =
    FF.liftF(DeleteImageVersionOp(request))

  def deleteModel(
    request: DeleteModelRequest
  ): SageMakerIO[DeleteModelResponse] =
    FF.liftF(DeleteModelOp(request))

  def deleteModelBiasJobDefinition(
    request: DeleteModelBiasJobDefinitionRequest
  ): SageMakerIO[DeleteModelBiasJobDefinitionResponse] =
    FF.liftF(DeleteModelBiasJobDefinitionOp(request))

  def deleteModelExplainabilityJobDefinition(
    request: DeleteModelExplainabilityJobDefinitionRequest
  ): SageMakerIO[DeleteModelExplainabilityJobDefinitionResponse] =
    FF.liftF(DeleteModelExplainabilityJobDefinitionOp(request))

  def deleteModelPackage(
    request: DeleteModelPackageRequest
  ): SageMakerIO[DeleteModelPackageResponse] =
    FF.liftF(DeleteModelPackageOp(request))

  def deleteModelPackageGroup(
    request: DeleteModelPackageGroupRequest
  ): SageMakerIO[DeleteModelPackageGroupResponse] =
    FF.liftF(DeleteModelPackageGroupOp(request))

  def deleteModelPackageGroupPolicy(
    request: DeleteModelPackageGroupPolicyRequest
  ): SageMakerIO[DeleteModelPackageGroupPolicyResponse] =
    FF.liftF(DeleteModelPackageGroupPolicyOp(request))

  def deleteModelQualityJobDefinition(
    request: DeleteModelQualityJobDefinitionRequest
  ): SageMakerIO[DeleteModelQualityJobDefinitionResponse] =
    FF.liftF(DeleteModelQualityJobDefinitionOp(request))

  def deleteMonitoringSchedule(
    request: DeleteMonitoringScheduleRequest
  ): SageMakerIO[DeleteMonitoringScheduleResponse] =
    FF.liftF(DeleteMonitoringScheduleOp(request))

  def deleteNotebookInstance(
    request: DeleteNotebookInstanceRequest
  ): SageMakerIO[DeleteNotebookInstanceResponse] =
    FF.liftF(DeleteNotebookInstanceOp(request))

  def deleteNotebookInstanceLifecycleConfig(
    request: DeleteNotebookInstanceLifecycleConfigRequest
  ): SageMakerIO[DeleteNotebookInstanceLifecycleConfigResponse] =
    FF.liftF(DeleteNotebookInstanceLifecycleConfigOp(request))

  def deletePipeline(
    request: DeletePipelineRequest
  ): SageMakerIO[DeletePipelineResponse] =
    FF.liftF(DeletePipelineOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): SageMakerIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): SageMakerIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def deleteTrial(
    request: DeleteTrialRequest
  ): SageMakerIO[DeleteTrialResponse] =
    FF.liftF(DeleteTrialOp(request))

  def deleteTrialComponent(
    request: DeleteTrialComponentRequest
  ): SageMakerIO[DeleteTrialComponentResponse] =
    FF.liftF(DeleteTrialComponentOp(request))

  def deleteUserProfile(
    request: DeleteUserProfileRequest
  ): SageMakerIO[DeleteUserProfileResponse] =
    FF.liftF(DeleteUserProfileOp(request))

  def deleteWorkforce(
    request: DeleteWorkforceRequest
  ): SageMakerIO[DeleteWorkforceResponse] =
    FF.liftF(DeleteWorkforceOp(request))

  def deleteWorkteam(
    request: DeleteWorkteamRequest
  ): SageMakerIO[DeleteWorkteamResponse] =
    FF.liftF(DeleteWorkteamOp(request))

  def deregisterDevices(
    request: DeregisterDevicesRequest
  ): SageMakerIO[DeregisterDevicesResponse] =
    FF.liftF(DeregisterDevicesOp(request))

  def describeAction(
    request: DescribeActionRequest
  ): SageMakerIO[DescribeActionResponse] =
    FF.liftF(DescribeActionOp(request))

  def describeAlgorithm(
    request: DescribeAlgorithmRequest
  ): SageMakerIO[DescribeAlgorithmResponse] =
    FF.liftF(DescribeAlgorithmOp(request))

  def describeApp(
    request: DescribeAppRequest
  ): SageMakerIO[DescribeAppResponse] =
    FF.liftF(DescribeAppOp(request))

  def describeAppImageConfig(
    request: DescribeAppImageConfigRequest
  ): SageMakerIO[DescribeAppImageConfigResponse] =
    FF.liftF(DescribeAppImageConfigOp(request))

  def describeArtifact(
    request: DescribeArtifactRequest
  ): SageMakerIO[DescribeArtifactResponse] =
    FF.liftF(DescribeArtifactOp(request))

  def describeAutoMLJob(
    request: DescribeAutoMlJobRequest
  ): SageMakerIO[DescribeAutoMlJobResponse] =
    FF.liftF(DescribeAutoMLJobOp(request))

  def describeCodeRepository(
    request: DescribeCodeRepositoryRequest
  ): SageMakerIO[DescribeCodeRepositoryResponse] =
    FF.liftF(DescribeCodeRepositoryOp(request))

  def describeCompilationJob(
    request: DescribeCompilationJobRequest
  ): SageMakerIO[DescribeCompilationJobResponse] =
    FF.liftF(DescribeCompilationJobOp(request))

  def describeContext(
    request: DescribeContextRequest
  ): SageMakerIO[DescribeContextResponse] =
    FF.liftF(DescribeContextOp(request))

  def describeDataQualityJobDefinition(
    request: DescribeDataQualityJobDefinitionRequest
  ): SageMakerIO[DescribeDataQualityJobDefinitionResponse] =
    FF.liftF(DescribeDataQualityJobDefinitionOp(request))

  def describeDevice(
    request: DescribeDeviceRequest
  ): SageMakerIO[DescribeDeviceResponse] =
    FF.liftF(DescribeDeviceOp(request))

  def describeDeviceFleet(
    request: DescribeDeviceFleetRequest
  ): SageMakerIO[DescribeDeviceFleetResponse] =
    FF.liftF(DescribeDeviceFleetOp(request))

  def describeDomain(
    request: DescribeDomainRequest
  ): SageMakerIO[DescribeDomainResponse] =
    FF.liftF(DescribeDomainOp(request))

  def describeEdgePackagingJob(
    request: DescribeEdgePackagingJobRequest
  ): SageMakerIO[DescribeEdgePackagingJobResponse] =
    FF.liftF(DescribeEdgePackagingJobOp(request))

  def describeEndpoint(
    request: DescribeEndpointRequest
  ): SageMakerIO[DescribeEndpointResponse] =
    FF.liftF(DescribeEndpointOp(request))

  def describeEndpointConfig(
    request: DescribeEndpointConfigRequest
  ): SageMakerIO[DescribeEndpointConfigResponse] =
    FF.liftF(DescribeEndpointConfigOp(request))

  def describeExperiment(
    request: DescribeExperimentRequest
  ): SageMakerIO[DescribeExperimentResponse] =
    FF.liftF(DescribeExperimentOp(request))

  def describeFeatureGroup(
    request: DescribeFeatureGroupRequest
  ): SageMakerIO[DescribeFeatureGroupResponse] =
    FF.liftF(DescribeFeatureGroupOp(request))

  def describeFlowDefinition(
    request: DescribeFlowDefinitionRequest
  ): SageMakerIO[DescribeFlowDefinitionResponse] =
    FF.liftF(DescribeFlowDefinitionOp(request))

  def describeHumanTaskUi(
    request: DescribeHumanTaskUiRequest
  ): SageMakerIO[DescribeHumanTaskUiResponse] =
    FF.liftF(DescribeHumanTaskUiOp(request))

  def describeHyperParameterTuningJob(
    request: DescribeHyperParameterTuningJobRequest
  ): SageMakerIO[DescribeHyperParameterTuningJobResponse] =
    FF.liftF(DescribeHyperParameterTuningJobOp(request))

  def describeImage(
    request: DescribeImageRequest
  ): SageMakerIO[DescribeImageResponse] =
    FF.liftF(DescribeImageOp(request))

  def describeImageVersion(
    request: DescribeImageVersionRequest
  ): SageMakerIO[DescribeImageVersionResponse] =
    FF.liftF(DescribeImageVersionOp(request))

  def describeLabelingJob(
    request: DescribeLabelingJobRequest
  ): SageMakerIO[DescribeLabelingJobResponse] =
    FF.liftF(DescribeLabelingJobOp(request))

  def describeModel(
    request: DescribeModelRequest
  ): SageMakerIO[DescribeModelResponse] =
    FF.liftF(DescribeModelOp(request))

  def describeModelBiasJobDefinition(
    request: DescribeModelBiasJobDefinitionRequest
  ): SageMakerIO[DescribeModelBiasJobDefinitionResponse] =
    FF.liftF(DescribeModelBiasJobDefinitionOp(request))

  def describeModelExplainabilityJobDefinition(
    request: DescribeModelExplainabilityJobDefinitionRequest
  ): SageMakerIO[DescribeModelExplainabilityJobDefinitionResponse] =
    FF.liftF(DescribeModelExplainabilityJobDefinitionOp(request))

  def describeModelPackage(
    request: DescribeModelPackageRequest
  ): SageMakerIO[DescribeModelPackageResponse] =
    FF.liftF(DescribeModelPackageOp(request))

  def describeModelPackageGroup(
    request: DescribeModelPackageGroupRequest
  ): SageMakerIO[DescribeModelPackageGroupResponse] =
    FF.liftF(DescribeModelPackageGroupOp(request))

  def describeModelQualityJobDefinition(
    request: DescribeModelQualityJobDefinitionRequest
  ): SageMakerIO[DescribeModelQualityJobDefinitionResponse] =
    FF.liftF(DescribeModelQualityJobDefinitionOp(request))

  def describeMonitoringSchedule(
    request: DescribeMonitoringScheduleRequest
  ): SageMakerIO[DescribeMonitoringScheduleResponse] =
    FF.liftF(DescribeMonitoringScheduleOp(request))

  def describeNotebookInstance(
    request: DescribeNotebookInstanceRequest
  ): SageMakerIO[DescribeNotebookInstanceResponse] =
    FF.liftF(DescribeNotebookInstanceOp(request))

  def describeNotebookInstanceLifecycleConfig(
    request: DescribeNotebookInstanceLifecycleConfigRequest
  ): SageMakerIO[DescribeNotebookInstanceLifecycleConfigResponse] =
    FF.liftF(DescribeNotebookInstanceLifecycleConfigOp(request))

  def describePipeline(
    request: DescribePipelineRequest
  ): SageMakerIO[DescribePipelineResponse] =
    FF.liftF(DescribePipelineOp(request))

  def describePipelineDefinitionForExecution(
    request: DescribePipelineDefinitionForExecutionRequest
  ): SageMakerIO[DescribePipelineDefinitionForExecutionResponse] =
    FF.liftF(DescribePipelineDefinitionForExecutionOp(request))

  def describePipelineExecution(
    request: DescribePipelineExecutionRequest
  ): SageMakerIO[DescribePipelineExecutionResponse] =
    FF.liftF(DescribePipelineExecutionOp(request))

  def describeProcessingJob(
    request: DescribeProcessingJobRequest
  ): SageMakerIO[DescribeProcessingJobResponse] =
    FF.liftF(DescribeProcessingJobOp(request))

  def describeProject(
    request: DescribeProjectRequest
  ): SageMakerIO[DescribeProjectResponse] =
    FF.liftF(DescribeProjectOp(request))

  def describeSubscribedWorkteam(
    request: DescribeSubscribedWorkteamRequest
  ): SageMakerIO[DescribeSubscribedWorkteamResponse] =
    FF.liftF(DescribeSubscribedWorkteamOp(request))

  def describeTrainingJob(
    request: DescribeTrainingJobRequest
  ): SageMakerIO[DescribeTrainingJobResponse] =
    FF.liftF(DescribeTrainingJobOp(request))

  def describeTransformJob(
    request: DescribeTransformJobRequest
  ): SageMakerIO[DescribeTransformJobResponse] =
    FF.liftF(DescribeTransformJobOp(request))

  def describeTrial(
    request: DescribeTrialRequest
  ): SageMakerIO[DescribeTrialResponse] =
    FF.liftF(DescribeTrialOp(request))

  def describeTrialComponent(
    request: DescribeTrialComponentRequest
  ): SageMakerIO[DescribeTrialComponentResponse] =
    FF.liftF(DescribeTrialComponentOp(request))

  def describeUserProfile(
    request: DescribeUserProfileRequest
  ): SageMakerIO[DescribeUserProfileResponse] =
    FF.liftF(DescribeUserProfileOp(request))

  def describeWorkforce(
    request: DescribeWorkforceRequest
  ): SageMakerIO[DescribeWorkforceResponse] =
    FF.liftF(DescribeWorkforceOp(request))

  def describeWorkteam(
    request: DescribeWorkteamRequest
  ): SageMakerIO[DescribeWorkteamResponse] =
    FF.liftF(DescribeWorkteamOp(request))

  def disableSagemakerServicecatalogPortfolio(
    request: DisableSagemakerServicecatalogPortfolioRequest
  ): SageMakerIO[DisableSagemakerServicecatalogPortfolioResponse] =
    FF.liftF(DisableSagemakerServicecatalogPortfolioOp(request))

  def disassociateTrialComponent(
    request: DisassociateTrialComponentRequest
  ): SageMakerIO[DisassociateTrialComponentResponse] =
    FF.liftF(DisassociateTrialComponentOp(request))

  def enableSagemakerServicecatalogPortfolio(
    request: EnableSagemakerServicecatalogPortfolioRequest
  ): SageMakerIO[EnableSagemakerServicecatalogPortfolioResponse] =
    FF.liftF(EnableSagemakerServicecatalogPortfolioOp(request))

  def getDeviceFleetReport(
    request: GetDeviceFleetReportRequest
  ): SageMakerIO[GetDeviceFleetReportResponse] =
    FF.liftF(GetDeviceFleetReportOp(request))

  def getModelPackageGroupPolicy(
    request: GetModelPackageGroupPolicyRequest
  ): SageMakerIO[GetModelPackageGroupPolicyResponse] =
    FF.liftF(GetModelPackageGroupPolicyOp(request))

  def getSagemakerServicecatalogPortfolioStatus(
    request: GetSagemakerServicecatalogPortfolioStatusRequest
  ): SageMakerIO[GetSagemakerServicecatalogPortfolioStatusResponse] =
    FF.liftF(GetSagemakerServicecatalogPortfolioStatusOp(request))

  def getSearchSuggestions(
    request: GetSearchSuggestionsRequest
  ): SageMakerIO[GetSearchSuggestionsResponse] =
    FF.liftF(GetSearchSuggestionsOp(request))

  def listActions(
    request: ListActionsRequest
  ): SageMakerIO[ListActionsResponse] =
    FF.liftF(ListActionsOp(request))

  def listAlgorithms(
    request: ListAlgorithmsRequest
  ): SageMakerIO[ListAlgorithmsResponse] =
    FF.liftF(ListAlgorithmsOp(request))

  def listAppImageConfigs(
    request: ListAppImageConfigsRequest
  ): SageMakerIO[ListAppImageConfigsResponse] =
    FF.liftF(ListAppImageConfigsOp(request))

  def listApps(
    request: ListAppsRequest
  ): SageMakerIO[ListAppsResponse] =
    FF.liftF(ListAppsOp(request))

  def listArtifacts(
    request: ListArtifactsRequest
  ): SageMakerIO[ListArtifactsResponse] =
    FF.liftF(ListArtifactsOp(request))

  def listAssociations(
    request: ListAssociationsRequest
  ): SageMakerIO[ListAssociationsResponse] =
    FF.liftF(ListAssociationsOp(request))

  def listAutoMLJobs(
    request: ListAutoMlJobsRequest
  ): SageMakerIO[ListAutoMlJobsResponse] =
    FF.liftF(ListAutoMLJobsOp(request))

  def listCandidatesForAutoMLJob(
    request: ListCandidatesForAutoMlJobRequest
  ): SageMakerIO[ListCandidatesForAutoMlJobResponse] =
    FF.liftF(ListCandidatesForAutoMLJobOp(request))

  def listCodeRepositories(
    request: ListCodeRepositoriesRequest
  ): SageMakerIO[ListCodeRepositoriesResponse] =
    FF.liftF(ListCodeRepositoriesOp(request))

  def listCompilationJobs(
    request: ListCompilationJobsRequest
  ): SageMakerIO[ListCompilationJobsResponse] =
    FF.liftF(ListCompilationJobsOp(request))

  def listContexts(
    request: ListContextsRequest
  ): SageMakerIO[ListContextsResponse] =
    FF.liftF(ListContextsOp(request))

  def listDataQualityJobDefinitions(
    request: ListDataQualityJobDefinitionsRequest
  ): SageMakerIO[ListDataQualityJobDefinitionsResponse] =
    FF.liftF(ListDataQualityJobDefinitionsOp(request))

  def listDeviceFleets(
    request: ListDeviceFleetsRequest
  ): SageMakerIO[ListDeviceFleetsResponse] =
    FF.liftF(ListDeviceFleetsOp(request))

  def listDevices(
    request: ListDevicesRequest
  ): SageMakerIO[ListDevicesResponse] =
    FF.liftF(ListDevicesOp(request))

  def listDomains(
    request: ListDomainsRequest
  ): SageMakerIO[ListDomainsResponse] =
    FF.liftF(ListDomainsOp(request))

  def listEdgePackagingJobs(
    request: ListEdgePackagingJobsRequest
  ): SageMakerIO[ListEdgePackagingJobsResponse] =
    FF.liftF(ListEdgePackagingJobsOp(request))

  def listEndpointConfigs(
    request: ListEndpointConfigsRequest
  ): SageMakerIO[ListEndpointConfigsResponse] =
    FF.liftF(ListEndpointConfigsOp(request))

  def listEndpoints(
    request: ListEndpointsRequest
  ): SageMakerIO[ListEndpointsResponse] =
    FF.liftF(ListEndpointsOp(request))

  def listExperiments(
    request: ListExperimentsRequest
  ): SageMakerIO[ListExperimentsResponse] =
    FF.liftF(ListExperimentsOp(request))

  def listFeatureGroups(
    request: ListFeatureGroupsRequest
  ): SageMakerIO[ListFeatureGroupsResponse] =
    FF.liftF(ListFeatureGroupsOp(request))

  def listFlowDefinitions(
    request: ListFlowDefinitionsRequest
  ): SageMakerIO[ListFlowDefinitionsResponse] =
    FF.liftF(ListFlowDefinitionsOp(request))

  def listHumanTaskUis(
    request: ListHumanTaskUisRequest
  ): SageMakerIO[ListHumanTaskUisResponse] =
    FF.liftF(ListHumanTaskUisOp(request))

  def listHyperParameterTuningJobs(
    request: ListHyperParameterTuningJobsRequest
  ): SageMakerIO[ListHyperParameterTuningJobsResponse] =
    FF.liftF(ListHyperParameterTuningJobsOp(request))

  def listImageVersions(
    request: ListImageVersionsRequest
  ): SageMakerIO[ListImageVersionsResponse] =
    FF.liftF(ListImageVersionsOp(request))

  def listImages(
    request: ListImagesRequest
  ): SageMakerIO[ListImagesResponse] =
    FF.liftF(ListImagesOp(request))

  def listLabelingJobs(
    request: ListLabelingJobsRequest
  ): SageMakerIO[ListLabelingJobsResponse] =
    FF.liftF(ListLabelingJobsOp(request))

  def listLabelingJobsForWorkteam(
    request: ListLabelingJobsForWorkteamRequest
  ): SageMakerIO[ListLabelingJobsForWorkteamResponse] =
    FF.liftF(ListLabelingJobsForWorkteamOp(request))

  def listModelBiasJobDefinitions(
    request: ListModelBiasJobDefinitionsRequest
  ): SageMakerIO[ListModelBiasJobDefinitionsResponse] =
    FF.liftF(ListModelBiasJobDefinitionsOp(request))

  def listModelExplainabilityJobDefinitions(
    request: ListModelExplainabilityJobDefinitionsRequest
  ): SageMakerIO[ListModelExplainabilityJobDefinitionsResponse] =
    FF.liftF(ListModelExplainabilityJobDefinitionsOp(request))

  def listModelPackageGroups(
    request: ListModelPackageGroupsRequest
  ): SageMakerIO[ListModelPackageGroupsResponse] =
    FF.liftF(ListModelPackageGroupsOp(request))

  def listModelPackages(
    request: ListModelPackagesRequest
  ): SageMakerIO[ListModelPackagesResponse] =
    FF.liftF(ListModelPackagesOp(request))

  def listModelQualityJobDefinitions(
    request: ListModelQualityJobDefinitionsRequest
  ): SageMakerIO[ListModelQualityJobDefinitionsResponse] =
    FF.liftF(ListModelQualityJobDefinitionsOp(request))

  def listModels(
    request: ListModelsRequest
  ): SageMakerIO[ListModelsResponse] =
    FF.liftF(ListModelsOp(request))

  def listMonitoringExecutions(
    request: ListMonitoringExecutionsRequest
  ): SageMakerIO[ListMonitoringExecutionsResponse] =
    FF.liftF(ListMonitoringExecutionsOp(request))

  def listMonitoringSchedules(
    request: ListMonitoringSchedulesRequest
  ): SageMakerIO[ListMonitoringSchedulesResponse] =
    FF.liftF(ListMonitoringSchedulesOp(request))

  def listNotebookInstanceLifecycleConfigs(
    request: ListNotebookInstanceLifecycleConfigsRequest
  ): SageMakerIO[ListNotebookInstanceLifecycleConfigsResponse] =
    FF.liftF(ListNotebookInstanceLifecycleConfigsOp(request))

  def listNotebookInstances(
    request: ListNotebookInstancesRequest
  ): SageMakerIO[ListNotebookInstancesResponse] =
    FF.liftF(ListNotebookInstancesOp(request))

  def listPipelineExecutionSteps(
    request: ListPipelineExecutionStepsRequest
  ): SageMakerIO[ListPipelineExecutionStepsResponse] =
    FF.liftF(ListPipelineExecutionStepsOp(request))

  def listPipelineExecutions(
    request: ListPipelineExecutionsRequest
  ): SageMakerIO[ListPipelineExecutionsResponse] =
    FF.liftF(ListPipelineExecutionsOp(request))

  def listPipelineParametersForExecution(
    request: ListPipelineParametersForExecutionRequest
  ): SageMakerIO[ListPipelineParametersForExecutionResponse] =
    FF.liftF(ListPipelineParametersForExecutionOp(request))

  def listPipelines(
    request: ListPipelinesRequest
  ): SageMakerIO[ListPipelinesResponse] =
    FF.liftF(ListPipelinesOp(request))

  def listProcessingJobs(
    request: ListProcessingJobsRequest
  ): SageMakerIO[ListProcessingJobsResponse] =
    FF.liftF(ListProcessingJobsOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): SageMakerIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def listSubscribedWorkteams(
    request: ListSubscribedWorkteamsRequest
  ): SageMakerIO[ListSubscribedWorkteamsResponse] =
    FF.liftF(ListSubscribedWorkteamsOp(request))

  def listTags(
    request: ListTagsRequest
  ): SageMakerIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def listTrainingJobs(
    request: ListTrainingJobsRequest
  ): SageMakerIO[ListTrainingJobsResponse] =
    FF.liftF(ListTrainingJobsOp(request))

  def listTrainingJobsForHyperParameterTuningJob(
    request: ListTrainingJobsForHyperParameterTuningJobRequest
  ): SageMakerIO[ListTrainingJobsForHyperParameterTuningJobResponse] =
    FF.liftF(ListTrainingJobsForHyperParameterTuningJobOp(request))

  def listTransformJobs(
    request: ListTransformJobsRequest
  ): SageMakerIO[ListTransformJobsResponse] =
    FF.liftF(ListTransformJobsOp(request))

  def listTrialComponents(
    request: ListTrialComponentsRequest
  ): SageMakerIO[ListTrialComponentsResponse] =
    FF.liftF(ListTrialComponentsOp(request))

  def listTrials(
    request: ListTrialsRequest
  ): SageMakerIO[ListTrialsResponse] =
    FF.liftF(ListTrialsOp(request))

  def listUserProfiles(
    request: ListUserProfilesRequest
  ): SageMakerIO[ListUserProfilesResponse] =
    FF.liftF(ListUserProfilesOp(request))

  def listWorkforces(
    request: ListWorkforcesRequest
  ): SageMakerIO[ListWorkforcesResponse] =
    FF.liftF(ListWorkforcesOp(request))

  def listWorkteams(
    request: ListWorkteamsRequest
  ): SageMakerIO[ListWorkteamsResponse] =
    FF.liftF(ListWorkteamsOp(request))

  def putModelPackageGroupPolicy(
    request: PutModelPackageGroupPolicyRequest
  ): SageMakerIO[PutModelPackageGroupPolicyResponse] =
    FF.liftF(PutModelPackageGroupPolicyOp(request))

  def registerDevices(
    request: RegisterDevicesRequest
  ): SageMakerIO[RegisterDevicesResponse] =
    FF.liftF(RegisterDevicesOp(request))

  def renderUiTemplate(
    request: RenderUiTemplateRequest
  ): SageMakerIO[RenderUiTemplateResponse] =
    FF.liftF(RenderUiTemplateOp(request))

  def search(
    request: SearchRequest
  ): SageMakerIO[SearchResponse] =
    FF.liftF(SearchOp(request))

  def sendPipelineExecutionStepFailure(
    request: SendPipelineExecutionStepFailureRequest
  ): SageMakerIO[SendPipelineExecutionStepFailureResponse] =
    FF.liftF(SendPipelineExecutionStepFailureOp(request))

  def sendPipelineExecutionStepSuccess(
    request: SendPipelineExecutionStepSuccessRequest
  ): SageMakerIO[SendPipelineExecutionStepSuccessResponse] =
    FF.liftF(SendPipelineExecutionStepSuccessOp(request))

  def startMonitoringSchedule(
    request: StartMonitoringScheduleRequest
  ): SageMakerIO[StartMonitoringScheduleResponse] =
    FF.liftF(StartMonitoringScheduleOp(request))

  def startNotebookInstance(
    request: StartNotebookInstanceRequest
  ): SageMakerIO[StartNotebookInstanceResponse] =
    FF.liftF(StartNotebookInstanceOp(request))

  def startPipelineExecution(
    request: StartPipelineExecutionRequest
  ): SageMakerIO[StartPipelineExecutionResponse] =
    FF.liftF(StartPipelineExecutionOp(request))

  def stopAutoMLJob(
    request: StopAutoMlJobRequest
  ): SageMakerIO[StopAutoMlJobResponse] =
    FF.liftF(StopAutoMLJobOp(request))

  def stopCompilationJob(
    request: StopCompilationJobRequest
  ): SageMakerIO[StopCompilationJobResponse] =
    FF.liftF(StopCompilationJobOp(request))

  def stopEdgePackagingJob(
    request: StopEdgePackagingJobRequest
  ): SageMakerIO[StopEdgePackagingJobResponse] =
    FF.liftF(StopEdgePackagingJobOp(request))

  def stopHyperParameterTuningJob(
    request: StopHyperParameterTuningJobRequest
  ): SageMakerIO[StopHyperParameterTuningJobResponse] =
    FF.liftF(StopHyperParameterTuningJobOp(request))

  def stopLabelingJob(
    request: StopLabelingJobRequest
  ): SageMakerIO[StopLabelingJobResponse] =
    FF.liftF(StopLabelingJobOp(request))

  def stopMonitoringSchedule(
    request: StopMonitoringScheduleRequest
  ): SageMakerIO[StopMonitoringScheduleResponse] =
    FF.liftF(StopMonitoringScheduleOp(request))

  def stopNotebookInstance(
    request: StopNotebookInstanceRequest
  ): SageMakerIO[StopNotebookInstanceResponse] =
    FF.liftF(StopNotebookInstanceOp(request))

  def stopPipelineExecution(
    request: StopPipelineExecutionRequest
  ): SageMakerIO[StopPipelineExecutionResponse] =
    FF.liftF(StopPipelineExecutionOp(request))

  def stopProcessingJob(
    request: StopProcessingJobRequest
  ): SageMakerIO[StopProcessingJobResponse] =
    FF.liftF(StopProcessingJobOp(request))

  def stopTrainingJob(
    request: StopTrainingJobRequest
  ): SageMakerIO[StopTrainingJobResponse] =
    FF.liftF(StopTrainingJobOp(request))

  def stopTransformJob(
    request: StopTransformJobRequest
  ): SageMakerIO[StopTransformJobResponse] =
    FF.liftF(StopTransformJobOp(request))

  def updateAction(
    request: UpdateActionRequest
  ): SageMakerIO[UpdateActionResponse] =
    FF.liftF(UpdateActionOp(request))

  def updateAppImageConfig(
    request: UpdateAppImageConfigRequest
  ): SageMakerIO[UpdateAppImageConfigResponse] =
    FF.liftF(UpdateAppImageConfigOp(request))

  def updateArtifact(
    request: UpdateArtifactRequest
  ): SageMakerIO[UpdateArtifactResponse] =
    FF.liftF(UpdateArtifactOp(request))

  def updateCodeRepository(
    request: UpdateCodeRepositoryRequest
  ): SageMakerIO[UpdateCodeRepositoryResponse] =
    FF.liftF(UpdateCodeRepositoryOp(request))

  def updateContext(
    request: UpdateContextRequest
  ): SageMakerIO[UpdateContextResponse] =
    FF.liftF(UpdateContextOp(request))

  def updateDeviceFleet(
    request: UpdateDeviceFleetRequest
  ): SageMakerIO[UpdateDeviceFleetResponse] =
    FF.liftF(UpdateDeviceFleetOp(request))

  def updateDevices(
    request: UpdateDevicesRequest
  ): SageMakerIO[UpdateDevicesResponse] =
    FF.liftF(UpdateDevicesOp(request))

  def updateDomain(
    request: UpdateDomainRequest
  ): SageMakerIO[UpdateDomainResponse] =
    FF.liftF(UpdateDomainOp(request))

  def updateEndpoint(
    request: UpdateEndpointRequest
  ): SageMakerIO[UpdateEndpointResponse] =
    FF.liftF(UpdateEndpointOp(request))

  def updateEndpointWeightsAndCapacities(
    request: UpdateEndpointWeightsAndCapacitiesRequest
  ): SageMakerIO[UpdateEndpointWeightsAndCapacitiesResponse] =
    FF.liftF(UpdateEndpointWeightsAndCapacitiesOp(request))

  def updateExperiment(
    request: UpdateExperimentRequest
  ): SageMakerIO[UpdateExperimentResponse] =
    FF.liftF(UpdateExperimentOp(request))

  def updateImage(
    request: UpdateImageRequest
  ): SageMakerIO[UpdateImageResponse] =
    FF.liftF(UpdateImageOp(request))

  def updateModelPackage(
    request: UpdateModelPackageRequest
  ): SageMakerIO[UpdateModelPackageResponse] =
    FF.liftF(UpdateModelPackageOp(request))

  def updateMonitoringSchedule(
    request: UpdateMonitoringScheduleRequest
  ): SageMakerIO[UpdateMonitoringScheduleResponse] =
    FF.liftF(UpdateMonitoringScheduleOp(request))

  def updateNotebookInstance(
    request: UpdateNotebookInstanceRequest
  ): SageMakerIO[UpdateNotebookInstanceResponse] =
    FF.liftF(UpdateNotebookInstanceOp(request))

  def updateNotebookInstanceLifecycleConfig(
    request: UpdateNotebookInstanceLifecycleConfigRequest
  ): SageMakerIO[UpdateNotebookInstanceLifecycleConfigResponse] =
    FF.liftF(UpdateNotebookInstanceLifecycleConfigOp(request))

  def updatePipeline(
    request: UpdatePipelineRequest
  ): SageMakerIO[UpdatePipelineResponse] =
    FF.liftF(UpdatePipelineOp(request))

  def updatePipelineExecution(
    request: UpdatePipelineExecutionRequest
  ): SageMakerIO[UpdatePipelineExecutionResponse] =
    FF.liftF(UpdatePipelineExecutionOp(request))

  def updateTrainingJob(
    request: UpdateTrainingJobRequest
  ): SageMakerIO[UpdateTrainingJobResponse] =
    FF.liftF(UpdateTrainingJobOp(request))

  def updateTrial(
    request: UpdateTrialRequest
  ): SageMakerIO[UpdateTrialResponse] =
    FF.liftF(UpdateTrialOp(request))

  def updateTrialComponent(
    request: UpdateTrialComponentRequest
  ): SageMakerIO[UpdateTrialComponentResponse] =
    FF.liftF(UpdateTrialComponentOp(request))

  def updateUserProfile(
    request: UpdateUserProfileRequest
  ): SageMakerIO[UpdateUserProfileResponse] =
    FF.liftF(UpdateUserProfileOp(request))

  def updateWorkforce(
    request: UpdateWorkforceRequest
  ): SageMakerIO[UpdateWorkforceResponse] =
    FF.liftF(UpdateWorkforceOp(request))

  def updateWorkteam(
    request: UpdateWorkteamRequest
  ): SageMakerIO[UpdateWorkteamResponse] =
    FF.liftF(UpdateWorkteamOp(request))
}
