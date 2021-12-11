package goober.hi

import goober.free.personalize.PersonalizeIO
import software.amazon.awssdk.services.personalize.model._


object personalize {
  import goober.free.{personalize ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def algorithm(
      name: Option[String] = None,
      algorithmArn: Option[String] = None,
      algorithmImage: Option[AlgorithmImage] = None,
      defaultHyperParameters: Option[HyperParameters] = None,
      defaultHyperParameterRanges: Option[DefaultHyperParameterRanges] = None,
      defaultResourceConfig: Option[ResourceConfig] = None,
      trainingInputMode: Option[String] = None,
      roleArn: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): Algorithm =
      Algorithm
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .ifSome(algorithmImage)(_.algorithmImage(_))
        .ifSome(defaultHyperParameters)(_.defaultHyperParameters(_))
        .ifSome(defaultHyperParameterRanges)(_.defaultHyperParameterRanges(_))
        .ifSome(defaultResourceConfig)(_.defaultResourceConfig(_))
        .ifSome(trainingInputMode)(_.trainingInputMode(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def algorithmImage(
      name: Option[String] = None,
      dockerURI: Option[String] = None
    ): AlgorithmImage =
      AlgorithmImage
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dockerURI)(_.dockerURI(_))
        .build

    def autoMLConfig(
      metricName: Option[String] = None,
      recipeList: Option[List[Arn]] = None
    ): AutoMLConfig =
      AutoMLConfig
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(recipeList)(_.recipeList(_))
        .build

    def batchInferenceJob(
      jobName: Option[String] = None,
      batchInferenceJobArn: Option[String] = None,
      filterArn: Option[String] = None,
      failureReason: Option[String] = None,
      solutionVersionArn: Option[String] = None,
      numResults: Option[Int] = None,
      jobInput: Option[BatchInferenceJobInput] = None,
      jobOutput: Option[BatchInferenceJobOutput] = None,
      batchInferenceJobConfig: Option[BatchInferenceJobConfig] = None,
      roleArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): BatchInferenceJob =
      BatchInferenceJob
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(batchInferenceJobArn)(_.batchInferenceJobArn(_))
        .ifSome(filterArn)(_.filterArn(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(jobInput)(_.jobInput(_))
        .ifSome(jobOutput)(_.jobOutput(_))
        .ifSome(batchInferenceJobConfig)(_.batchInferenceJobConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def batchInferenceJobConfig(
      itemExplorationConfig: Option[HyperParameters] = None
    ): BatchInferenceJobConfig =
      BatchInferenceJobConfig
        .builder
        .ifSome(itemExplorationConfig)(_.itemExplorationConfig(_))
        .build

    def batchInferenceJobInput(
      s3DataSource: Option[S3DataConfig] = None
    ): BatchInferenceJobInput =
      BatchInferenceJobInput
        .builder
        .ifSome(s3DataSource)(_.s3DataSource(_))
        .build

    def batchInferenceJobOutput(
      s3DataDestination: Option[S3DataConfig] = None
    ): BatchInferenceJobOutput =
      BatchInferenceJobOutput
        .builder
        .ifSome(s3DataDestination)(_.s3DataDestination(_))
        .build

    def batchInferenceJobSummary(
      batchInferenceJobArn: Option[String] = None,
      jobName: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None,
      solutionVersionArn: Option[String] = None
    ): BatchInferenceJobSummary =
      BatchInferenceJobSummary
        .builder
        .ifSome(batchInferenceJobArn)(_.batchInferenceJobArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .build

    def campaign(
      name: Option[String] = None,
      campaignArn: Option[String] = None,
      solutionVersionArn: Option[String] = None,
      minProvisionedTPS: Option[Int] = None,
      campaignConfig: Option[CampaignConfig] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      latestCampaignUpdate: Option[CampaignUpdateSummary] = None
    ): Campaign =
      Campaign
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(campaignArn)(_.campaignArn(_))
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(minProvisionedTPS)(_.minProvisionedTPS(_))
        .ifSome(campaignConfig)(_.campaignConfig(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(latestCampaignUpdate)(_.latestCampaignUpdate(_))
        .build

    def campaignConfig(
      itemExplorationConfig: Option[HyperParameters] = None
    ): CampaignConfig =
      CampaignConfig
        .builder
        .ifSome(itemExplorationConfig)(_.itemExplorationConfig(_))
        .build

    def campaignSummary(
      name: Option[String] = None,
      campaignArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): CampaignSummary =
      CampaignSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(campaignArn)(_.campaignArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def campaignUpdateSummary(
      solutionVersionArn: Option[String] = None,
      minProvisionedTPS: Option[Int] = None,
      campaignConfig: Option[CampaignConfig] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): CampaignUpdateSummary =
      CampaignUpdateSummary
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(minProvisionedTPS)(_.minProvisionedTPS(_))
        .ifSome(campaignConfig)(_.campaignConfig(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def categoricalHyperParameterRange(
      name: Option[String] = None,
      values: Option[List[CategoricalValue]] = None
    ): CategoricalHyperParameterRange =
      CategoricalHyperParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def continuousHyperParameterRange(
      name: Option[String] = None,
      minValue: Option[ContinuousMinValue] = None,
      maxValue: Option[ContinuousMaxValue] = None
    ): ContinuousHyperParameterRange =
      ContinuousHyperParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .build

    def createBatchInferenceJobRequest(
      jobName: Option[String] = None,
      solutionVersionArn: Option[String] = None,
      filterArn: Option[String] = None,
      numResults: Option[Int] = None,
      jobInput: Option[BatchInferenceJobInput] = None,
      jobOutput: Option[BatchInferenceJobOutput] = None,
      roleArn: Option[String] = None,
      batchInferenceJobConfig: Option[BatchInferenceJobConfig] = None
    ): CreateBatchInferenceJobRequest =
      CreateBatchInferenceJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(filterArn)(_.filterArn(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(jobInput)(_.jobInput(_))
        .ifSome(jobOutput)(_.jobOutput(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(batchInferenceJobConfig)(_.batchInferenceJobConfig(_))
        .build

    def createBatchInferenceJobResponse(
      batchInferenceJobArn: Option[String] = None
    ): CreateBatchInferenceJobResponse =
      CreateBatchInferenceJobResponse
        .builder
        .ifSome(batchInferenceJobArn)(_.batchInferenceJobArn(_))
        .build

    def createCampaignRequest(
      name: Option[String] = None,
      solutionVersionArn: Option[String] = None,
      minProvisionedTPS: Option[Int] = None,
      campaignConfig: Option[CampaignConfig] = None
    ): CreateCampaignRequest =
      CreateCampaignRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(minProvisionedTPS)(_.minProvisionedTPS(_))
        .ifSome(campaignConfig)(_.campaignConfig(_))
        .build

    def createCampaignResponse(
      campaignArn: Option[String] = None
    ): CreateCampaignResponse =
      CreateCampaignResponse
        .builder
        .ifSome(campaignArn)(_.campaignArn(_))
        .build

    def createDatasetExportJobRequest(
      jobName: Option[String] = None,
      datasetArn: Option[String] = None,
      ingestionMode: Option[String] = None,
      roleArn: Option[String] = None,
      jobOutput: Option[DatasetExportJobOutput] = None
    ): CreateDatasetExportJobRequest =
      CreateDatasetExportJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(ingestionMode)(_.ingestionMode(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(jobOutput)(_.jobOutput(_))
        .build

    def createDatasetExportJobResponse(
      datasetExportJobArn: Option[String] = None
    ): CreateDatasetExportJobResponse =
      CreateDatasetExportJobResponse
        .builder
        .ifSome(datasetExportJobArn)(_.datasetExportJobArn(_))
        .build

    def createDatasetGroupRequest(
      name: Option[String] = None,
      roleArn: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): CreateDatasetGroupRequest =
      CreateDatasetGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def createDatasetGroupResponse(
      datasetGroupArn: Option[String] = None
    ): CreateDatasetGroupResponse =
      CreateDatasetGroupResponse
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .build

    def createDatasetImportJobRequest(
      jobName: Option[String] = None,
      datasetArn: Option[String] = None,
      dataSource: Option[DataSource] = None,
      roleArn: Option[String] = None
    ): CreateDatasetImportJobRequest =
      CreateDatasetImportJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def createDatasetImportJobResponse(
      datasetImportJobArn: Option[String] = None
    ): CreateDatasetImportJobResponse =
      CreateDatasetImportJobResponse
        .builder
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .build

    def createDatasetRequest(
      name: Option[String] = None,
      schemaArn: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      datasetType: Option[String] = None
    ): CreateDatasetRequest =
      CreateDatasetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(datasetType)(_.datasetType(_))
        .build

    def createDatasetResponse(
      datasetArn: Option[String] = None
    ): CreateDatasetResponse =
      CreateDatasetResponse
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .build

    def createEventTrackerRequest(
      name: Option[String] = None,
      datasetGroupArn: Option[String] = None
    ): CreateEventTrackerRequest =
      CreateEventTrackerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .build

    def createEventTrackerResponse(
      eventTrackerArn: Option[String] = None,
      trackingId: Option[String] = None
    ): CreateEventTrackerResponse =
      CreateEventTrackerResponse
        .builder
        .ifSome(eventTrackerArn)(_.eventTrackerArn(_))
        .ifSome(trackingId)(_.trackingId(_))
        .build

    def createFilterRequest(
      name: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      filterExpression: Option[String] = None
    ): CreateFilterRequest =
      CreateFilterRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .build

    def createFilterResponse(
      filterArn: Option[String] = None
    ): CreateFilterResponse =
      CreateFilterResponse
        .builder
        .ifSome(filterArn)(_.filterArn(_))
        .build

    def createSchemaRequest(
      name: Option[String] = None,
      schema: Option[String] = None
    ): CreateSchemaRequest =
      CreateSchemaRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def createSchemaResponse(
      schemaArn: Option[String] = None
    ): CreateSchemaResponse =
      CreateSchemaResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def createSolutionRequest(
      name: Option[String] = None,
      performHPO: Option[Boolean] = None,
      performAutoML: Option[Boolean] = None,
      recipeArn: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      eventType: Option[String] = None,
      solutionConfig: Option[SolutionConfig] = None
    ): CreateSolutionRequest =
      CreateSolutionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(performHPO)(_.performHPO(_))
        .ifSome(performAutoML)(_.performAutoML(_))
        .ifSome(recipeArn)(_.recipeArn(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(solutionConfig)(_.solutionConfig(_))
        .build

    def createSolutionResponse(
      solutionArn: Option[String] = None
    ): CreateSolutionResponse =
      CreateSolutionResponse
        .builder
        .ifSome(solutionArn)(_.solutionArn(_))
        .build

    def createSolutionVersionRequest(
      solutionArn: Option[String] = None,
      trainingMode: Option[String] = None
    ): CreateSolutionVersionRequest =
      CreateSolutionVersionRequest
        .builder
        .ifSome(solutionArn)(_.solutionArn(_))
        .ifSome(trainingMode)(_.trainingMode(_))
        .build

    def createSolutionVersionResponse(
      solutionVersionArn: Option[String] = None
    ): CreateSolutionVersionResponse =
      CreateSolutionVersionResponse
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .build

    def dataSource(
      dataLocation: Option[String] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(dataLocation)(_.dataLocation(_))
        .build

    def dataset(
      name: Option[String] = None,
      datasetArn: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      datasetType: Option[String] = None,
      schemaArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): Dataset =
      Dataset
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def datasetExportJob(
      jobName: Option[String] = None,
      datasetExportJobArn: Option[String] = None,
      datasetArn: Option[String] = None,
      ingestionMode: Option[String] = None,
      roleArn: Option[String] = None,
      status: Option[String] = None,
      jobOutput: Option[DatasetExportJobOutput] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): DatasetExportJob =
      DatasetExportJob
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(datasetExportJobArn)(_.datasetExportJobArn(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(ingestionMode)(_.ingestionMode(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(jobOutput)(_.jobOutput(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def datasetExportJobOutput(
      s3DataDestination: Option[S3DataConfig] = None
    ): DatasetExportJobOutput =
      DatasetExportJobOutput
        .builder
        .ifSome(s3DataDestination)(_.s3DataDestination(_))
        .build

    def datasetExportJobSummary(
      datasetExportJobArn: Option[String] = None,
      jobName: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): DatasetExportJobSummary =
      DatasetExportJobSummary
        .builder
        .ifSome(datasetExportJobArn)(_.datasetExportJobArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def datasetGroup(
      name: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      status: Option[String] = None,
      roleArn: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): DatasetGroup =
      DatasetGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def datasetGroupSummary(
      name: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): DatasetGroupSummary =
      DatasetGroupSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def datasetImportJob(
      jobName: Option[String] = None,
      datasetImportJobArn: Option[String] = None,
      datasetArn: Option[String] = None,
      dataSource: Option[DataSource] = None,
      roleArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): DatasetImportJob =
      DatasetImportJob
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def datasetImportJobSummary(
      datasetImportJobArn: Option[String] = None,
      jobName: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): DatasetImportJobSummary =
      DatasetImportJobSummary
        .builder
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def datasetSchema(
      name: Option[String] = None,
      schemaArn: Option[String] = None,
      schema: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): DatasetSchema =
      DatasetSchema
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def datasetSchemaSummary(
      name: Option[String] = None,
      schemaArn: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): DatasetSchemaSummary =
      DatasetSchemaSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def datasetSummary(
      name: Option[String] = None,
      datasetArn: Option[String] = None,
      datasetType: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): DatasetSummary =
      DatasetSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def defaultCategoricalHyperParameterRange(
      name: Option[String] = None,
      values: Option[List[CategoricalValue]] = None,
      isTunable: Option[Boolean] = None
    ): DefaultCategoricalHyperParameterRange =
      DefaultCategoricalHyperParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(isTunable)(_.isTunable(_))
        .build

    def defaultContinuousHyperParameterRange(
      name: Option[String] = None,
      minValue: Option[ContinuousMinValue] = None,
      maxValue: Option[ContinuousMaxValue] = None,
      isTunable: Option[Boolean] = None
    ): DefaultContinuousHyperParameterRange =
      DefaultContinuousHyperParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(isTunable)(_.isTunable(_))
        .build

    def defaultHyperParameterRanges(
      integerHyperParameterRanges: Option[List[DefaultIntegerHyperParameterRange]] = None,
      continuousHyperParameterRanges: Option[List[DefaultContinuousHyperParameterRange]] = None,
      categoricalHyperParameterRanges: Option[List[DefaultCategoricalHyperParameterRange]] = None
    ): DefaultHyperParameterRanges =
      DefaultHyperParameterRanges
        .builder
        .ifSome(integerHyperParameterRanges)(_.integerHyperParameterRanges(_))
        .ifSome(continuousHyperParameterRanges)(_.continuousHyperParameterRanges(_))
        .ifSome(categoricalHyperParameterRanges)(_.categoricalHyperParameterRanges(_))
        .build

    def defaultIntegerHyperParameterRange(
      name: Option[String] = None,
      minValue: Option[Int] = None,
      maxValue: Option[Int] = None,
      isTunable: Option[Boolean] = None
    ): DefaultIntegerHyperParameterRange =
      DefaultIntegerHyperParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(isTunable)(_.isTunable(_))
        .build

    def deleteCampaignRequest(
      campaignArn: Option[String] = None
    ): DeleteCampaignRequest =
      DeleteCampaignRequest
        .builder
        .ifSome(campaignArn)(_.campaignArn(_))
        .build

    def deleteDatasetGroupRequest(
      datasetGroupArn: Option[String] = None
    ): DeleteDatasetGroupRequest =
      DeleteDatasetGroupRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .build

    def deleteDatasetRequest(
      datasetArn: Option[String] = None
    ): DeleteDatasetRequest =
      DeleteDatasetRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .build

    def deleteEventTrackerRequest(
      eventTrackerArn: Option[String] = None
    ): DeleteEventTrackerRequest =
      DeleteEventTrackerRequest
        .builder
        .ifSome(eventTrackerArn)(_.eventTrackerArn(_))
        .build

    def deleteFilterRequest(
      filterArn: Option[String] = None
    ): DeleteFilterRequest =
      DeleteFilterRequest
        .builder
        .ifSome(filterArn)(_.filterArn(_))
        .build

    def deleteSchemaRequest(
      schemaArn: Option[String] = None
    ): DeleteSchemaRequest =
      DeleteSchemaRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def deleteSolutionRequest(
      solutionArn: Option[String] = None
    ): DeleteSolutionRequest =
      DeleteSolutionRequest
        .builder
        .ifSome(solutionArn)(_.solutionArn(_))
        .build

    def describeAlgorithmRequest(
      algorithmArn: Option[String] = None
    ): DescribeAlgorithmRequest =
      DescribeAlgorithmRequest
        .builder
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .build

    def describeAlgorithmResponse(
      algorithm: Option[Algorithm] = None
    ): DescribeAlgorithmResponse =
      DescribeAlgorithmResponse
        .builder
        .ifSome(algorithm)(_.algorithm(_))
        .build

    def describeBatchInferenceJobRequest(
      batchInferenceJobArn: Option[String] = None
    ): DescribeBatchInferenceJobRequest =
      DescribeBatchInferenceJobRequest
        .builder
        .ifSome(batchInferenceJobArn)(_.batchInferenceJobArn(_))
        .build

    def describeBatchInferenceJobResponse(
      batchInferenceJob: Option[BatchInferenceJob] = None
    ): DescribeBatchInferenceJobResponse =
      DescribeBatchInferenceJobResponse
        .builder
        .ifSome(batchInferenceJob)(_.batchInferenceJob(_))
        .build

    def describeCampaignRequest(
      campaignArn: Option[String] = None
    ): DescribeCampaignRequest =
      DescribeCampaignRequest
        .builder
        .ifSome(campaignArn)(_.campaignArn(_))
        .build

    def describeCampaignResponse(
      campaign: Option[Campaign] = None
    ): DescribeCampaignResponse =
      DescribeCampaignResponse
        .builder
        .ifSome(campaign)(_.campaign(_))
        .build

    def describeDatasetExportJobRequest(
      datasetExportJobArn: Option[String] = None
    ): DescribeDatasetExportJobRequest =
      DescribeDatasetExportJobRequest
        .builder
        .ifSome(datasetExportJobArn)(_.datasetExportJobArn(_))
        .build

    def describeDatasetExportJobResponse(
      datasetExportJob: Option[DatasetExportJob] = None
    ): DescribeDatasetExportJobResponse =
      DescribeDatasetExportJobResponse
        .builder
        .ifSome(datasetExportJob)(_.datasetExportJob(_))
        .build

    def describeDatasetGroupRequest(
      datasetGroupArn: Option[String] = None
    ): DescribeDatasetGroupRequest =
      DescribeDatasetGroupRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .build

    def describeDatasetGroupResponse(
      datasetGroup: Option[DatasetGroup] = None
    ): DescribeDatasetGroupResponse =
      DescribeDatasetGroupResponse
        .builder
        .ifSome(datasetGroup)(_.datasetGroup(_))
        .build

    def describeDatasetImportJobRequest(
      datasetImportJobArn: Option[String] = None
    ): DescribeDatasetImportJobRequest =
      DescribeDatasetImportJobRequest
        .builder
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .build

    def describeDatasetImportJobResponse(
      datasetImportJob: Option[DatasetImportJob] = None
    ): DescribeDatasetImportJobResponse =
      DescribeDatasetImportJobResponse
        .builder
        .ifSome(datasetImportJob)(_.datasetImportJob(_))
        .build

    def describeDatasetRequest(
      datasetArn: Option[String] = None
    ): DescribeDatasetRequest =
      DescribeDatasetRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .build

    def describeDatasetResponse(
      dataset: Option[Dataset] = None
    ): DescribeDatasetResponse =
      DescribeDatasetResponse
        .builder
        .ifSome(dataset)(_.dataset(_))
        .build

    def describeEventTrackerRequest(
      eventTrackerArn: Option[String] = None
    ): DescribeEventTrackerRequest =
      DescribeEventTrackerRequest
        .builder
        .ifSome(eventTrackerArn)(_.eventTrackerArn(_))
        .build

    def describeEventTrackerResponse(
      eventTracker: Option[EventTracker] = None
    ): DescribeEventTrackerResponse =
      DescribeEventTrackerResponse
        .builder
        .ifSome(eventTracker)(_.eventTracker(_))
        .build

    def describeFeatureTransformationRequest(
      featureTransformationArn: Option[String] = None
    ): DescribeFeatureTransformationRequest =
      DescribeFeatureTransformationRequest
        .builder
        .ifSome(featureTransformationArn)(_.featureTransformationArn(_))
        .build

    def describeFeatureTransformationResponse(
      featureTransformation: Option[FeatureTransformation] = None
    ): DescribeFeatureTransformationResponse =
      DescribeFeatureTransformationResponse
        .builder
        .ifSome(featureTransformation)(_.featureTransformation(_))
        .build

    def describeFilterRequest(
      filterArn: Option[String] = None
    ): DescribeFilterRequest =
      DescribeFilterRequest
        .builder
        .ifSome(filterArn)(_.filterArn(_))
        .build

    def describeFilterResponse(
      filter: Option[Filter] = None
    ): DescribeFilterResponse =
      DescribeFilterResponse
        .builder
        .ifSome(filter)(_.filter(_))
        .build

    def describeRecipeRequest(
      recipeArn: Option[String] = None
    ): DescribeRecipeRequest =
      DescribeRecipeRequest
        .builder
        .ifSome(recipeArn)(_.recipeArn(_))
        .build

    def describeRecipeResponse(
      recipe: Option[Recipe] = None
    ): DescribeRecipeResponse =
      DescribeRecipeResponse
        .builder
        .ifSome(recipe)(_.recipe(_))
        .build

    def describeSchemaRequest(
      schemaArn: Option[String] = None
    ): DescribeSchemaRequest =
      DescribeSchemaRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def describeSchemaResponse(
      schema: Option[DatasetSchema] = None
    ): DescribeSchemaResponse =
      DescribeSchemaResponse
        .builder
        .ifSome(schema)(_.schema(_))
        .build

    def describeSolutionRequest(
      solutionArn: Option[String] = None
    ): DescribeSolutionRequest =
      DescribeSolutionRequest
        .builder
        .ifSome(solutionArn)(_.solutionArn(_))
        .build

    def describeSolutionResponse(
      solution: Option[Solution] = None
    ): DescribeSolutionResponse =
      DescribeSolutionResponse
        .builder
        .ifSome(solution)(_.solution(_))
        .build

    def describeSolutionVersionRequest(
      solutionVersionArn: Option[String] = None
    ): DescribeSolutionVersionRequest =
      DescribeSolutionVersionRequest
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .build

    def describeSolutionVersionResponse(
      solutionVersion: Option[SolutionVersion] = None
    ): DescribeSolutionVersionResponse =
      DescribeSolutionVersionResponse
        .builder
        .ifSome(solutionVersion)(_.solutionVersion(_))
        .build

    def eventTracker(
      name: Option[String] = None,
      eventTrackerArn: Option[String] = None,
      accountId: Option[String] = None,
      trackingId: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): EventTracker =
      EventTracker
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventTrackerArn)(_.eventTrackerArn(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(trackingId)(_.trackingId(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def eventTrackerSummary(
      name: Option[String] = None,
      eventTrackerArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): EventTrackerSummary =
      EventTrackerSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventTrackerArn)(_.eventTrackerArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def featureTransformation(
      name: Option[String] = None,
      featureTransformationArn: Option[String] = None,
      defaultParameters: Option[FeaturizationParameters] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      status: Option[String] = None
    ): FeatureTransformation =
      FeatureTransformation
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(featureTransformationArn)(_.featureTransformationArn(_))
        .ifSome(defaultParameters)(_.defaultParameters(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(status)(_.status(_))
        .build

    def filter(
      name: Option[String] = None,
      filterArn: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      datasetGroupArn: Option[String] = None,
      failureReason: Option[String] = None,
      filterExpression: Option[String] = None,
      status: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(filterArn)(_.filterArn(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(status)(_.status(_))
        .build

    def filterSummary(
      name: Option[String] = None,
      filterArn: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      datasetGroupArn: Option[String] = None,
      failureReason: Option[String] = None,
      status: Option[String] = None
    ): FilterSummary =
      FilterSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(filterArn)(_.filterArn(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(status)(_.status(_))
        .build

    def getSolutionMetricsRequest(
      solutionVersionArn: Option[String] = None
    ): GetSolutionMetricsRequest =
      GetSolutionMetricsRequest
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .build

    def getSolutionMetricsResponse(
      solutionVersionArn: Option[String] = None,
      metrics: Option[Metrics] = None
    ): GetSolutionMetricsResponse =
      GetSolutionMetricsResponse
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def hPOConfig(
      hpoObjective: Option[HPOObjective] = None,
      hpoResourceConfig: Option[HPOResourceConfig] = None,
      algorithmHyperParameterRanges: Option[HyperParameterRanges] = None
    ): HPOConfig =
      HPOConfig
        .builder
        .ifSome(hpoObjective)(_.hpoObjective(_))
        .ifSome(hpoResourceConfig)(_.hpoResourceConfig(_))
        .ifSome(algorithmHyperParameterRanges)(_.algorithmHyperParameterRanges(_))
        .build

    def hPOObjective(
      `type`: Option[String] = None,
      metricName: Option[String] = None,
      metricRegex: Option[String] = None
    ): HPOObjective =
      HPOObjective
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricRegex)(_.metricRegex(_))
        .build

    def hPOResourceConfig(
      maxNumberOfTrainingJobs: Option[String] = None,
      maxParallelTrainingJobs: Option[String] = None
    ): HPOResourceConfig =
      HPOResourceConfig
        .builder
        .ifSome(maxNumberOfTrainingJobs)(_.maxNumberOfTrainingJobs(_))
        .ifSome(maxParallelTrainingJobs)(_.maxParallelTrainingJobs(_))
        .build

    def hyperParameterRanges(
      integerHyperParameterRanges: Option[List[IntegerHyperParameterRange]] = None,
      continuousHyperParameterRanges: Option[List[ContinuousHyperParameterRange]] = None,
      categoricalHyperParameterRanges: Option[List[CategoricalHyperParameterRange]] = None
    ): HyperParameterRanges =
      HyperParameterRanges
        .builder
        .ifSome(integerHyperParameterRanges)(_.integerHyperParameterRanges(_))
        .ifSome(continuousHyperParameterRanges)(_.continuousHyperParameterRanges(_))
        .ifSome(categoricalHyperParameterRanges)(_.categoricalHyperParameterRanges(_))
        .build

    def integerHyperParameterRange(
      name: Option[String] = None,
      minValue: Option[Int] = None,
      maxValue: Option[Int] = None
    ): IntegerHyperParameterRange =
      IntegerHyperParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listBatchInferenceJobsRequest(
      solutionVersionArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBatchInferenceJobsRequest =
      ListBatchInferenceJobsRequest
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBatchInferenceJobsResponse(
      batchInferenceJobs: Option[List[BatchInferenceJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListBatchInferenceJobsResponse =
      ListBatchInferenceJobsResponse
        .builder
        .ifSome(batchInferenceJobs)(_.batchInferenceJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCampaignsRequest(
      solutionArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListCampaignsRequest =
      ListCampaignsRequest
        .builder
        .ifSome(solutionArn)(_.solutionArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listCampaignsResponse(
      campaigns: Option[List[CampaignSummary]] = None,
      nextToken: Option[String] = None
    ): ListCampaignsResponse =
      ListCampaignsResponse
        .builder
        .ifSome(campaigns)(_.campaigns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetExportJobsRequest(
      datasetArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetExportJobsRequest =
      ListDatasetExportJobsRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetExportJobsResponse(
      datasetExportJobs: Option[List[DatasetExportJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetExportJobsResponse =
      ListDatasetExportJobsResponse
        .builder
        .ifSome(datasetExportJobs)(_.datasetExportJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetGroupsRequest =
      ListDatasetGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetGroupsResponse(
      datasetGroups: Option[List[DatasetGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetGroupsResponse =
      ListDatasetGroupsResponse
        .builder
        .ifSome(datasetGroups)(_.datasetGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetImportJobsRequest(
      datasetArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetImportJobsRequest =
      ListDatasetImportJobsRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetImportJobsResponse(
      datasetImportJobs: Option[List[DatasetImportJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetImportJobsResponse =
      ListDatasetImportJobsResponse
        .builder
        .ifSome(datasetImportJobs)(_.datasetImportJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetsRequest(
      datasetGroupArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetsRequest =
      ListDatasetsRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetsResponse(
      datasets: Option[List[DatasetSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetsResponse =
      ListDatasetsResponse
        .builder
        .ifSome(datasets)(_.datasets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventTrackersRequest(
      datasetGroupArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEventTrackersRequest =
      ListEventTrackersRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEventTrackersResponse(
      eventTrackers: Option[List[EventTrackerSummary]] = None,
      nextToken: Option[String] = None
    ): ListEventTrackersResponse =
      ListEventTrackersResponse
        .builder
        .ifSome(eventTrackers)(_.eventTrackers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFiltersRequest(
      datasetGroupArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFiltersRequest =
      ListFiltersRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFiltersResponse(
      filters: Option[List[FilterSummary]] = None,
      nextToken: Option[String] = None
    ): ListFiltersResponse =
      ListFiltersResponse
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecipesRequest(
      recipeProvider: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRecipesRequest =
      ListRecipesRequest
        .builder
        .ifSome(recipeProvider)(_.recipeProvider(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRecipesResponse(
      recipes: Option[List[RecipeSummary]] = None,
      nextToken: Option[String] = None
    ): ListRecipesResponse =
      ListRecipesResponse
        .builder
        .ifSome(recipes)(_.recipes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchemasRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSchemasRequest =
      ListSchemasRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSchemasResponse(
      schemas: Option[List[DatasetSchemaSummary]] = None,
      nextToken: Option[String] = None
    ): ListSchemasResponse =
      ListSchemasResponse
        .builder
        .ifSome(schemas)(_.schemas(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSolutionVersionsRequest(
      solutionArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSolutionVersionsRequest =
      ListSolutionVersionsRequest
        .builder
        .ifSome(solutionArn)(_.solutionArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSolutionVersionsResponse(
      solutionVersions: Option[List[SolutionVersionSummary]] = None,
      nextToken: Option[String] = None
    ): ListSolutionVersionsResponse =
      ListSolutionVersionsResponse
        .builder
        .ifSome(solutionVersions)(_.solutionVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSolutionsRequest(
      datasetGroupArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSolutionsRequest =
      ListSolutionsRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSolutionsResponse(
      solutions: Option[List[SolutionSummary]] = None,
      nextToken: Option[String] = None
    ): ListSolutionsResponse =
      ListSolutionsResponse
        .builder
        .ifSome(solutions)(_.solutions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def optimizationObjective(
      itemAttribute: Option[String] = None,
      objectiveSensitivity: Option[String] = None
    ): OptimizationObjective =
      OptimizationObjective
        .builder
        .ifSome(itemAttribute)(_.itemAttribute(_))
        .ifSome(objectiveSensitivity)(_.objectiveSensitivity(_))
        .build

    def recipe(
      name: Option[String] = None,
      recipeArn: Option[String] = None,
      algorithmArn: Option[String] = None,
      featureTransformationArn: Option[String] = None,
      status: Option[String] = None,
      description: Option[String] = None,
      creationDateTime: Option[Date] = None,
      recipeType: Option[String] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): Recipe =
      Recipe
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(recipeArn)(_.recipeArn(_))
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .ifSome(featureTransformationArn)(_.featureTransformationArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(recipeType)(_.recipeType(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def recipeSummary(
      name: Option[String] = None,
      recipeArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): RecipeSummary =
      RecipeSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(recipeArn)(_.recipeArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3DataConfig(
      path: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): S3DataConfig =
      S3DataConfig
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def solution(
      name: Option[String] = None,
      solutionArn: Option[String] = None,
      performHPO: Option[Boolean] = None,
      performAutoML: Option[Boolean] = None,
      recipeArn: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      eventType: Option[String] = None,
      solutionConfig: Option[SolutionConfig] = None,
      autoMLResult: Option[AutoMLResult] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      latestSolutionVersion: Option[SolutionVersionSummary] = None
    ): Solution =
      Solution
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(solutionArn)(_.solutionArn(_))
        .ifSome(performHPO)(_.performHPO(_))
        .ifSome(performAutoML)(_.performAutoML(_))
        .ifSome(recipeArn)(_.recipeArn(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(solutionConfig)(_.solutionConfig(_))
        .ifSome(autoMLResult)(_.autoMLResult(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(latestSolutionVersion)(_.latestSolutionVersion(_))
        .build

    def solutionConfig(
      eventValueThreshold: Option[String] = None,
      hpoConfig: Option[HPOConfig] = None,
      algorithmHyperParameters: Option[HyperParameters] = None,
      featureTransformationParameters: Option[FeatureTransformationParameters] = None,
      autoMLConfig: Option[AutoMLConfig] = None,
      optimizationObjective: Option[OptimizationObjective] = None
    ): SolutionConfig =
      SolutionConfig
        .builder
        .ifSome(eventValueThreshold)(_.eventValueThreshold(_))
        .ifSome(hpoConfig)(_.hpoConfig(_))
        .ifSome(algorithmHyperParameters)(_.algorithmHyperParameters(_))
        .ifSome(featureTransformationParameters)(_.featureTransformationParameters(_))
        .ifSome(autoMLConfig)(_.autoMLConfig(_))
        .ifSome(optimizationObjective)(_.optimizationObjective(_))
        .build

    def solutionSummary(
      name: Option[String] = None,
      solutionArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): SolutionSummary =
      SolutionSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(solutionArn)(_.solutionArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def solutionVersion(
      solutionVersionArn: Option[String] = None,
      solutionArn: Option[String] = None,
      performHPO: Option[Boolean] = None,
      performAutoML: Option[Boolean] = None,
      recipeArn: Option[String] = None,
      eventType: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      solutionConfig: Option[SolutionConfig] = None,
      trainingHours: Option[TrainingHours] = None,
      trainingMode: Option[String] = None,
      tunedHPOParams: Option[TunedHPOParams] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None
    ): SolutionVersion =
      SolutionVersion
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(solutionArn)(_.solutionArn(_))
        .ifSome(performHPO)(_.performHPO(_))
        .ifSome(performAutoML)(_.performAutoML(_))
        .ifSome(recipeArn)(_.recipeArn(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(solutionConfig)(_.solutionConfig(_))
        .ifSome(trainingHours)(_.trainingHours(_))
        .ifSome(trainingMode)(_.trainingMode(_))
        .ifSome(tunedHPOParams)(_.tunedHPOParams(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .build

    def solutionVersionSummary(
      solutionVersionArn: Option[String] = None,
      status: Option[String] = None,
      creationDateTime: Option[Date] = None,
      lastUpdatedDateTime: Option[Date] = None,
      failureReason: Option[String] = None
    ): SolutionVersionSummary =
      SolutionVersionSummary
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(lastUpdatedDateTime)(_.lastUpdatedDateTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def stopSolutionVersionCreationRequest(
      solutionVersionArn: Option[String] = None
    ): StopSolutionVersionCreationRequest =
      StopSolutionVersionCreationRequest
        .builder
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .build

    def tunedHPOParams(
      algorithmHyperParameters: Option[HyperParameters] = None
    ): TunedHPOParams =
      TunedHPOParams
        .builder
        .ifSome(algorithmHyperParameters)(_.algorithmHyperParameters(_))
        .build

    def updateCampaignRequest(
      campaignArn: Option[String] = None,
      solutionVersionArn: Option[String] = None,
      minProvisionedTPS: Option[Int] = None,
      campaignConfig: Option[CampaignConfig] = None
    ): UpdateCampaignRequest =
      UpdateCampaignRequest
        .builder
        .ifSome(campaignArn)(_.campaignArn(_))
        .ifSome(solutionVersionArn)(_.solutionVersionArn(_))
        .ifSome(minProvisionedTPS)(_.minProvisionedTPS(_))
        .ifSome(campaignConfig)(_.campaignConfig(_))
        .build

    def updateCampaignResponse(
      campaignArn: Option[String] = None
    ): UpdateCampaignResponse =
      UpdateCampaignResponse
        .builder
        .ifSome(campaignArn)(_.campaignArn(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
