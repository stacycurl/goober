package goober.hi

import goober.free.machinelearning.MachineLearningIO
import software.amazon.awssdk.services.machinelearning.model._


object machinelearning {
  import goober.free.{machinelearning ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addTagsInput(
      tags: Option[List[Tag]] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): AddTagsInput =
      AddTagsInput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def addTagsOutput(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): AddTagsOutput =
      AddTagsOutput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def batchPrediction(
      batchPredictionId: Option[String] = None,
      mLModelId: Option[String] = None,
      batchPredictionDataSourceId: Option[String] = None,
      inputDataLocationS3: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      outputUri: Option[String] = None,
      message: Option[String] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None,
      totalRecordCount: Option[LongType] = None,
      invalidRecordCount: Option[LongType] = None
    ): BatchPrediction =
      BatchPrediction
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(batchPredictionDataSourceId)(_.batchPredictionDataSourceId(_))
        .ifSome(inputDataLocationS3)(_.inputDataLocationS3(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(outputUri)(_.outputUri(_))
        .ifSome(message)(_.message(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(totalRecordCount)(_.totalRecordCount(_))
        .ifSome(invalidRecordCount)(_.invalidRecordCount(_))
        .build

    def createBatchPredictionInput(
      batchPredictionId: Option[String] = None,
      batchPredictionName: Option[String] = None,
      mLModelId: Option[String] = None,
      batchPredictionDataSourceId: Option[String] = None,
      outputUri: Option[String] = None
    ): CreateBatchPredictionInput =
      CreateBatchPredictionInput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .ifSome(batchPredictionName)(_.batchPredictionName(_))
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(batchPredictionDataSourceId)(_.batchPredictionDataSourceId(_))
        .ifSome(outputUri)(_.outputUri(_))
        .build

    def createBatchPredictionOutput(
      batchPredictionId: Option[String] = None
    ): CreateBatchPredictionOutput =
      CreateBatchPredictionOutput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .build

    def createDataSourceFromRDSInput(
      dataSourceId: Option[String] = None,
      dataSourceName: Option[String] = None,
      rDSData: Option[RDSDataSpec] = None,
      roleARN: Option[String] = None,
      computeStatistics: Option[Boolean] = None
    ): CreateDataSourceFromRDSInput =
      CreateDataSourceFromRDSInput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(rDSData)(_.rDSData(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(computeStatistics)(_.computeStatistics(_))
        .build

    def createDataSourceFromRDSOutput(
      dataSourceId: Option[String] = None
    ): CreateDataSourceFromRDSOutput =
      CreateDataSourceFromRDSOutput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def createDataSourceFromRedshiftInput(
      dataSourceId: Option[String] = None,
      dataSourceName: Option[String] = None,
      dataSpec: Option[RedshiftDataSpec] = None,
      roleARN: Option[String] = None,
      computeStatistics: Option[Boolean] = None
    ): CreateDataSourceFromRedshiftInput =
      CreateDataSourceFromRedshiftInput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(dataSpec)(_.dataSpec(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(computeStatistics)(_.computeStatistics(_))
        .build

    def createDataSourceFromRedshiftOutput(
      dataSourceId: Option[String] = None
    ): CreateDataSourceFromRedshiftOutput =
      CreateDataSourceFromRedshiftOutput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def createDataSourceFromS3Input(
      dataSourceId: Option[String] = None,
      dataSourceName: Option[String] = None,
      dataSpec: Option[S3DataSpec] = None,
      computeStatistics: Option[Boolean] = None
    ): CreateDataSourceFromS3Input =
      CreateDataSourceFromS3Input
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(dataSpec)(_.dataSpec(_))
        .ifSome(computeStatistics)(_.computeStatistics(_))
        .build

    def createDataSourceFromS3Output(
      dataSourceId: Option[String] = None
    ): CreateDataSourceFromS3Output =
      CreateDataSourceFromS3Output
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def createEvaluationInput(
      evaluationId: Option[String] = None,
      evaluationName: Option[String] = None,
      mLModelId: Option[String] = None,
      evaluationDataSourceId: Option[String] = None
    ): CreateEvaluationInput =
      CreateEvaluationInput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .ifSome(evaluationName)(_.evaluationName(_))
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(evaluationDataSourceId)(_.evaluationDataSourceId(_))
        .build

    def createEvaluationOutput(
      evaluationId: Option[String] = None
    ): CreateEvaluationOutput =
      CreateEvaluationOutput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .build

    def createMLModelInput(
      mLModelId: Option[String] = None,
      mLModelName: Option[String] = None,
      mLModelType: Option[String] = None,
      parameters: Option[TrainingParameters] = None,
      trainingDataSourceId: Option[String] = None,
      recipe: Option[String] = None,
      recipeUri: Option[String] = None
    ): CreateMLModelInput =
      CreateMLModelInput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(mLModelName)(_.mLModelName(_))
        .ifSome(mLModelType)(_.mLModelType(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(trainingDataSourceId)(_.trainingDataSourceId(_))
        .ifSome(recipe)(_.recipe(_))
        .ifSome(recipeUri)(_.recipeUri(_))
        .build

    def createMLModelOutput(
      mLModelId: Option[String] = None
    ): CreateMLModelOutput =
      CreateMLModelOutput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .build

    def createRealtimeEndpointInput(
      mLModelId: Option[String] = None
    ): CreateRealtimeEndpointInput =
      CreateRealtimeEndpointInput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .build

    def createRealtimeEndpointOutput(
      mLModelId: Option[String] = None,
      realtimeEndpointInfo: Option[RealtimeEndpointInfo] = None
    ): CreateRealtimeEndpointOutput =
      CreateRealtimeEndpointOutput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(realtimeEndpointInfo)(_.realtimeEndpointInfo(_))
        .build

    def dataSource(
      dataSourceId: Option[String] = None,
      dataLocationS3: Option[String] = None,
      dataRearrangement: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      dataSizeInBytes: Option[LongType] = None,
      numberOfFiles: Option[LongType] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      redshiftMetadata: Option[RedshiftMetadata] = None,
      rDSMetadata: Option[RDSMetadata] = None,
      roleARN: Option[String] = None,
      computeStatistics: Option[Boolean] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(dataLocationS3)(_.dataLocationS3(_))
        .ifSome(dataRearrangement)(_.dataRearrangement(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(dataSizeInBytes)(_.dataSizeInBytes(_))
        .ifSome(numberOfFiles)(_.numberOfFiles(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(redshiftMetadata)(_.redshiftMetadata(_))
        .ifSome(rDSMetadata)(_.rDSMetadata(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(computeStatistics)(_.computeStatistics(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .build

    def deleteBatchPredictionInput(
      batchPredictionId: Option[String] = None
    ): DeleteBatchPredictionInput =
      DeleteBatchPredictionInput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .build

    def deleteBatchPredictionOutput(
      batchPredictionId: Option[String] = None
    ): DeleteBatchPredictionOutput =
      DeleteBatchPredictionOutput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .build

    def deleteDataSourceInput(
      dataSourceId: Option[String] = None
    ): DeleteDataSourceInput =
      DeleteDataSourceInput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def deleteDataSourceOutput(
      dataSourceId: Option[String] = None
    ): DeleteDataSourceOutput =
      DeleteDataSourceOutput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def deleteEvaluationInput(
      evaluationId: Option[String] = None
    ): DeleteEvaluationInput =
      DeleteEvaluationInput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .build

    def deleteEvaluationOutput(
      evaluationId: Option[String] = None
    ): DeleteEvaluationOutput =
      DeleteEvaluationOutput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .build

    def deleteMLModelInput(
      mLModelId: Option[String] = None
    ): DeleteMLModelInput =
      DeleteMLModelInput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .build

    def deleteMLModelOutput(
      mLModelId: Option[String] = None
    ): DeleteMLModelOutput =
      DeleteMLModelOutput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .build

    def deleteRealtimeEndpointInput(
      mLModelId: Option[String] = None
    ): DeleteRealtimeEndpointInput =
      DeleteRealtimeEndpointInput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .build

    def deleteRealtimeEndpointOutput(
      mLModelId: Option[String] = None,
      realtimeEndpointInfo: Option[RealtimeEndpointInfo] = None
    ): DeleteRealtimeEndpointOutput =
      DeleteRealtimeEndpointOutput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(realtimeEndpointInfo)(_.realtimeEndpointInfo(_))
        .build

    def deleteTagsInput(
      tagKeys: Option[List[TagKey]] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): DeleteTagsInput =
      DeleteTagsInput
        .builder
        .ifSome(tagKeys)(_.tagKeys(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def deleteTagsOutput(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): DeleteTagsOutput =
      DeleteTagsOutput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def describeBatchPredictionsInput(
      filterVariable: Option[String] = None,
      eQ: Option[String] = None,
      gT: Option[String] = None,
      lT: Option[String] = None,
      gE: Option[String] = None,
      lE: Option[String] = None,
      nE: Option[String] = None,
      prefix: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeBatchPredictionsInput =
      DescribeBatchPredictionsInput
        .builder
        .ifSome(filterVariable)(_.filterVariable(_))
        .ifSome(eQ)(_.eQ(_))
        .ifSome(gT)(_.gT(_))
        .ifSome(lT)(_.lT(_))
        .ifSome(gE)(_.gE(_))
        .ifSome(lE)(_.lE(_))
        .ifSome(nE)(_.nE(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeBatchPredictionsOutput(
      results: Option[List[BatchPrediction]] = None,
      nextToken: Option[String] = None
    ): DescribeBatchPredictionsOutput =
      DescribeBatchPredictionsOutput
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDataSourcesInput(
      filterVariable: Option[String] = None,
      eQ: Option[String] = None,
      gT: Option[String] = None,
      lT: Option[String] = None,
      gE: Option[String] = None,
      lE: Option[String] = None,
      nE: Option[String] = None,
      prefix: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeDataSourcesInput =
      DescribeDataSourcesInput
        .builder
        .ifSome(filterVariable)(_.filterVariable(_))
        .ifSome(eQ)(_.eQ(_))
        .ifSome(gT)(_.gT(_))
        .ifSome(lT)(_.lT(_))
        .ifSome(gE)(_.gE(_))
        .ifSome(lE)(_.lE(_))
        .ifSome(nE)(_.nE(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeDataSourcesOutput(
      results: Option[List[DataSource]] = None,
      nextToken: Option[String] = None
    ): DescribeDataSourcesOutput =
      DescribeDataSourcesOutput
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEvaluationsInput(
      filterVariable: Option[String] = None,
      eQ: Option[String] = None,
      gT: Option[String] = None,
      lT: Option[String] = None,
      gE: Option[String] = None,
      lE: Option[String] = None,
      nE: Option[String] = None,
      prefix: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeEvaluationsInput =
      DescribeEvaluationsInput
        .builder
        .ifSome(filterVariable)(_.filterVariable(_))
        .ifSome(eQ)(_.eQ(_))
        .ifSome(gT)(_.gT(_))
        .ifSome(lT)(_.lT(_))
        .ifSome(gE)(_.gE(_))
        .ifSome(lE)(_.lE(_))
        .ifSome(nE)(_.nE(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeEvaluationsOutput(
      results: Option[List[Evaluation]] = None,
      nextToken: Option[String] = None
    ): DescribeEvaluationsOutput =
      DescribeEvaluationsOutput
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMLModelsInput(
      filterVariable: Option[String] = None,
      eQ: Option[String] = None,
      gT: Option[String] = None,
      lT: Option[String] = None,
      gE: Option[String] = None,
      lE: Option[String] = None,
      nE: Option[String] = None,
      prefix: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeMLModelsInput =
      DescribeMLModelsInput
        .builder
        .ifSome(filterVariable)(_.filterVariable(_))
        .ifSome(eQ)(_.eQ(_))
        .ifSome(gT)(_.gT(_))
        .ifSome(lT)(_.lT(_))
        .ifSome(gE)(_.gE(_))
        .ifSome(lE)(_.lE(_))
        .ifSome(nE)(_.nE(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeMLModelsOutput(
      results: Option[List[MLModel]] = None,
      nextToken: Option[String] = None
    ): DescribeMLModelsOutput =
      DescribeMLModelsOutput
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTagsInput(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): DescribeTagsInput =
      DescribeTagsInput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def describeTagsOutput(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): DescribeTagsOutput =
      DescribeTagsOutput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def evaluation(
      evaluationId: Option[String] = None,
      mLModelId: Option[String] = None,
      evaluationDataSourceId: Option[String] = None,
      inputDataLocationS3: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      performanceMetrics: Option[PerformanceMetrics] = None,
      message: Option[String] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None
    ): Evaluation =
      Evaluation
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(evaluationDataSourceId)(_.evaluationDataSourceId(_))
        .ifSome(inputDataLocationS3)(_.inputDataLocationS3(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(performanceMetrics)(_.performanceMetrics(_))
        .ifSome(message)(_.message(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .build

    def getBatchPredictionInput(
      batchPredictionId: Option[String] = None
    ): GetBatchPredictionInput =
      GetBatchPredictionInput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .build

    def getBatchPredictionOutput(
      batchPredictionId: Option[String] = None,
      mLModelId: Option[String] = None,
      batchPredictionDataSourceId: Option[String] = None,
      inputDataLocationS3: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      outputUri: Option[String] = None,
      logUri: Option[String] = None,
      message: Option[String] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None,
      totalRecordCount: Option[LongType] = None,
      invalidRecordCount: Option[LongType] = None
    ): GetBatchPredictionOutput =
      GetBatchPredictionOutput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(batchPredictionDataSourceId)(_.batchPredictionDataSourceId(_))
        .ifSome(inputDataLocationS3)(_.inputDataLocationS3(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(outputUri)(_.outputUri(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(message)(_.message(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(totalRecordCount)(_.totalRecordCount(_))
        .ifSome(invalidRecordCount)(_.invalidRecordCount(_))
        .build

    def getDataSourceInput(
      dataSourceId: Option[String] = None,
      verbose: Option[Boolean] = None
    ): GetDataSourceInput =
      GetDataSourceInput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(verbose)(_.verbose(_))
        .build

    def getDataSourceOutput(
      dataSourceId: Option[String] = None,
      dataLocationS3: Option[String] = None,
      dataRearrangement: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      dataSizeInBytes: Option[LongType] = None,
      numberOfFiles: Option[LongType] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      logUri: Option[String] = None,
      message: Option[String] = None,
      redshiftMetadata: Option[RedshiftMetadata] = None,
      rDSMetadata: Option[RDSMetadata] = None,
      roleARN: Option[String] = None,
      computeStatistics: Option[Boolean] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None,
      dataSourceSchema: Option[String] = None
    ): GetDataSourceOutput =
      GetDataSourceOutput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(dataLocationS3)(_.dataLocationS3(_))
        .ifSome(dataRearrangement)(_.dataRearrangement(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(dataSizeInBytes)(_.dataSizeInBytes(_))
        .ifSome(numberOfFiles)(_.numberOfFiles(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(message)(_.message(_))
        .ifSome(redshiftMetadata)(_.redshiftMetadata(_))
        .ifSome(rDSMetadata)(_.rDSMetadata(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(computeStatistics)(_.computeStatistics(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(dataSourceSchema)(_.dataSourceSchema(_))
        .build

    def getEvaluationInput(
      evaluationId: Option[String] = None
    ): GetEvaluationInput =
      GetEvaluationInput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .build

    def getEvaluationOutput(
      evaluationId: Option[String] = None,
      mLModelId: Option[String] = None,
      evaluationDataSourceId: Option[String] = None,
      inputDataLocationS3: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      performanceMetrics: Option[PerformanceMetrics] = None,
      logUri: Option[String] = None,
      message: Option[String] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None
    ): GetEvaluationOutput =
      GetEvaluationOutput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(evaluationDataSourceId)(_.evaluationDataSourceId(_))
        .ifSome(inputDataLocationS3)(_.inputDataLocationS3(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(performanceMetrics)(_.performanceMetrics(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(message)(_.message(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .build

    def getMLModelInput(
      mLModelId: Option[String] = None,
      verbose: Option[Boolean] = None
    ): GetMLModelInput =
      GetMLModelInput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(verbose)(_.verbose(_))
        .build

    def getMLModelOutput(
      mLModelId: Option[String] = None,
      trainingDataSourceId: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      sizeInBytes: Option[LongType] = None,
      endpointInfo: Option[RealtimeEndpointInfo] = None,
      trainingParameters: Option[TrainingParameters] = None,
      inputDataLocationS3: Option[String] = None,
      mLModelType: Option[String] = None,
      scoreThreshold: Option[ScoreThreshold] = None,
      scoreThresholdLastUpdatedAt: Option[EpochTime] = None,
      logUri: Option[String] = None,
      message: Option[String] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None,
      recipe: Option[String] = None,
      schema: Option[String] = None
    ): GetMLModelOutput =
      GetMLModelOutput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(trainingDataSourceId)(_.trainingDataSourceId(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(sizeInBytes)(_.sizeInBytes(_))
        .ifSome(endpointInfo)(_.endpointInfo(_))
        .ifSome(trainingParameters)(_.trainingParameters(_))
        .ifSome(inputDataLocationS3)(_.inputDataLocationS3(_))
        .ifSome(mLModelType)(_.mLModelType(_))
        .ifSome(scoreThreshold)(_.scoreThreshold(_))
        .ifSome(scoreThresholdLastUpdatedAt)(_.scoreThresholdLastUpdatedAt(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(message)(_.message(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(recipe)(_.recipe(_))
        .ifSome(schema)(_.schema(_))
        .build

    def idempotentParameterMismatchException(
      message: Option[String] = None,
      code: Option[Int] = None
    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      code: Option[Int] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def invalidInputException(
      message: Option[String] = None,
      code: Option[Int] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def invalidTagException(
      message: Option[String] = None
    ): InvalidTagException =
      InvalidTagException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None,
      code: Option[Int] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def mLModel(
      mLModelId: Option[String] = None,
      trainingDataSourceId: Option[String] = None,
      createdByIamUser: Option[String] = None,
      createdAt: Option[EpochTime] = None,
      lastUpdatedAt: Option[EpochTime] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      sizeInBytes: Option[LongType] = None,
      endpointInfo: Option[RealtimeEndpointInfo] = None,
      trainingParameters: Option[TrainingParameters] = None,
      inputDataLocationS3: Option[String] = None,
      algorithm: Option[String] = None,
      mLModelType: Option[String] = None,
      scoreThreshold: Option[ScoreThreshold] = None,
      scoreThresholdLastUpdatedAt: Option[EpochTime] = None,
      message: Option[String] = None,
      computeTime: Option[LongType] = None,
      finishedAt: Option[EpochTime] = None,
      startedAt: Option[EpochTime] = None
    ): MLModel =
      MLModel
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(trainingDataSourceId)(_.trainingDataSourceId(_))
        .ifSome(createdByIamUser)(_.createdByIamUser(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(sizeInBytes)(_.sizeInBytes(_))
        .ifSome(endpointInfo)(_.endpointInfo(_))
        .ifSome(trainingParameters)(_.trainingParameters(_))
        .ifSome(inputDataLocationS3)(_.inputDataLocationS3(_))
        .ifSome(algorithm)(_.algorithm(_))
        .ifSome(mLModelType)(_.mLModelType(_))
        .ifSome(scoreThreshold)(_.scoreThreshold(_))
        .ifSome(scoreThresholdLastUpdatedAt)(_.scoreThresholdLastUpdatedAt(_))
        .ifSome(message)(_.message(_))
        .ifSome(computeTime)(_.computeTime(_))
        .ifSome(finishedAt)(_.finishedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .build

    def performanceMetrics(
      properties: Option[PerformanceMetricsProperties] = None
    ): PerformanceMetrics =
      PerformanceMetrics
        .builder
        .ifSome(properties)(_.properties(_))
        .build

    def predictInput(
      mLModelId: Option[String] = None,
      record: Option[Record] = None,
      predictEndpoint: Option[String] = None
    ): PredictInput =
      PredictInput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(record)(_.record(_))
        .ifSome(predictEndpoint)(_.predictEndpoint(_))
        .build

    def predictOutput(
      prediction: Option[Prediction] = None
    ): PredictOutput =
      PredictOutput
        .builder
        .ifSome(prediction)(_.prediction(_))
        .build

    def prediction(
      predictedLabel: Option[String] = None,
      predictedValue: Option[floatLabel] = None,
      predictedScores: Option[ScoreValuePerLabelMap] = None,
      details: Option[DetailsMap] = None
    ): Prediction =
      Prediction
        .builder
        .ifSome(predictedLabel)(_.predictedLabel(_))
        .ifSome(predictedValue)(_.predictedValue(_))
        .ifSome(predictedScores)(_.predictedScores(_))
        .ifSome(details)(_.details(_))
        .build

    def predictorNotMountedException(
      message: Option[String] = None
    ): PredictorNotMountedException =
      PredictorNotMountedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def rDSDataSpec(
      databaseInformation: Option[RDSDatabase] = None,
      selectSqlQuery: Option[String] = None,
      databaseCredentials: Option[RDSDatabaseCredentials] = None,
      s3StagingLocation: Option[String] = None,
      dataRearrangement: Option[String] = None,
      dataSchema: Option[String] = None,
      dataSchemaUri: Option[String] = None,
      resourceRole: Option[String] = None,
      serviceRole: Option[String] = None,
      subnetId: Option[String] = None,
      securityGroupIds: Option[List[EDPSecurityGroupId]] = None
    ): RDSDataSpec =
      RDSDataSpec
        .builder
        .ifSome(databaseInformation)(_.databaseInformation(_))
        .ifSome(selectSqlQuery)(_.selectSqlQuery(_))
        .ifSome(databaseCredentials)(_.databaseCredentials(_))
        .ifSome(s3StagingLocation)(_.s3StagingLocation(_))
        .ifSome(dataRearrangement)(_.dataRearrangement(_))
        .ifSome(dataSchema)(_.dataSchema(_))
        .ifSome(dataSchemaUri)(_.dataSchemaUri(_))
        .ifSome(resourceRole)(_.resourceRole(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def rDSDatabase(
      instanceIdentifier: Option[String] = None,
      databaseName: Option[String] = None
    ): RDSDatabase =
      RDSDatabase
        .builder
        .ifSome(instanceIdentifier)(_.instanceIdentifier(_))
        .ifSome(databaseName)(_.databaseName(_))
        .build

    def rDSDatabaseCredentials(
      username: Option[String] = None,
      password: Option[String] = None
    ): RDSDatabaseCredentials =
      RDSDatabaseCredentials
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def rDSMetadata(
      database: Option[RDSDatabase] = None,
      databaseUserName: Option[String] = None,
      selectSqlQuery: Option[String] = None,
      resourceRole: Option[String] = None,
      serviceRole: Option[String] = None,
      dataPipelineId: Option[String] = None
    ): RDSMetadata =
      RDSMetadata
        .builder
        .ifSome(database)(_.database(_))
        .ifSome(databaseUserName)(_.databaseUserName(_))
        .ifSome(selectSqlQuery)(_.selectSqlQuery(_))
        .ifSome(resourceRole)(_.resourceRole(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(dataPipelineId)(_.dataPipelineId(_))
        .build

    def realtimeEndpointInfo(
      peakRequestsPerSecond: Option[Int] = None,
      createdAt: Option[EpochTime] = None,
      endpointUrl: Option[String] = None,
      endpointStatus: Option[String] = None
    ): RealtimeEndpointInfo =
      RealtimeEndpointInfo
        .builder
        .ifSome(peakRequestsPerSecond)(_.peakRequestsPerSecond(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(endpointUrl)(_.endpointUrl(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .build

    def redshiftDataSpec(
      databaseInformation: Option[RedshiftDatabase] = None,
      selectSqlQuery: Option[String] = None,
      databaseCredentials: Option[RedshiftDatabaseCredentials] = None,
      s3StagingLocation: Option[String] = None,
      dataRearrangement: Option[String] = None,
      dataSchema: Option[String] = None,
      dataSchemaUri: Option[String] = None
    ): RedshiftDataSpec =
      RedshiftDataSpec
        .builder
        .ifSome(databaseInformation)(_.databaseInformation(_))
        .ifSome(selectSqlQuery)(_.selectSqlQuery(_))
        .ifSome(databaseCredentials)(_.databaseCredentials(_))
        .ifSome(s3StagingLocation)(_.s3StagingLocation(_))
        .ifSome(dataRearrangement)(_.dataRearrangement(_))
        .ifSome(dataSchema)(_.dataSchema(_))
        .ifSome(dataSchemaUri)(_.dataSchemaUri(_))
        .build

    def redshiftDatabase(
      databaseName: Option[String] = None,
      clusterIdentifier: Option[String] = None
    ): RedshiftDatabase =
      RedshiftDatabase
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .build

    def redshiftDatabaseCredentials(
      username: Option[String] = None,
      password: Option[String] = None
    ): RedshiftDatabaseCredentials =
      RedshiftDatabaseCredentials
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def redshiftMetadata(
      redshiftDatabase: Option[RedshiftDatabase] = None,
      databaseUserName: Option[String] = None,
      selectSqlQuery: Option[String] = None
    ): RedshiftMetadata =
      RedshiftMetadata
        .builder
        .ifSome(redshiftDatabase)(_.redshiftDatabase(_))
        .ifSome(databaseUserName)(_.databaseUserName(_))
        .ifSome(selectSqlQuery)(_.selectSqlQuery(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      code: Option[Int] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def s3DataSpec(
      dataLocationS3: Option[String] = None,
      dataRearrangement: Option[String] = None,
      dataSchema: Option[String] = None,
      dataSchemaLocationS3: Option[String] = None
    ): S3DataSpec =
      S3DataSpec
        .builder
        .ifSome(dataLocationS3)(_.dataLocationS3(_))
        .ifSome(dataRearrangement)(_.dataRearrangement(_))
        .ifSome(dataSchema)(_.dataSchema(_))
        .ifSome(dataSchemaLocationS3)(_.dataSchemaLocationS3(_))
        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagLimitExceededException(
      message: Option[String] = None
    ): TagLimitExceededException =
      TagLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateBatchPredictionInput(
      batchPredictionId: Option[String] = None,
      batchPredictionName: Option[String] = None
    ): UpdateBatchPredictionInput =
      UpdateBatchPredictionInput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .ifSome(batchPredictionName)(_.batchPredictionName(_))
        .build

    def updateBatchPredictionOutput(
      batchPredictionId: Option[String] = None
    ): UpdateBatchPredictionOutput =
      UpdateBatchPredictionOutput
        .builder
        .ifSome(batchPredictionId)(_.batchPredictionId(_))
        .build

    def updateDataSourceInput(
      dataSourceId: Option[String] = None,
      dataSourceName: Option[String] = None
    ): UpdateDataSourceInput =
      UpdateDataSourceInput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .build

    def updateDataSourceOutput(
      dataSourceId: Option[String] = None
    ): UpdateDataSourceOutput =
      UpdateDataSourceOutput
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def updateEvaluationInput(
      evaluationId: Option[String] = None,
      evaluationName: Option[String] = None
    ): UpdateEvaluationInput =
      UpdateEvaluationInput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .ifSome(evaluationName)(_.evaluationName(_))
        .build

    def updateEvaluationOutput(
      evaluationId: Option[String] = None
    ): UpdateEvaluationOutput =
      UpdateEvaluationOutput
        .builder
        .ifSome(evaluationId)(_.evaluationId(_))
        .build

    def updateMLModelInput(
      mLModelId: Option[String] = None,
      mLModelName: Option[String] = None,
      scoreThreshold: Option[ScoreThreshold] = None
    ): UpdateMLModelInput =
      UpdateMLModelInput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .ifSome(mLModelName)(_.mLModelName(_))
        .ifSome(scoreThreshold)(_.scoreThreshold(_))
        .build

    def updateMLModelOutput(
      mLModelId: Option[String] = None
    ): UpdateMLModelOutput =
      UpdateMLModelOutput
        .builder
        .ifSome(mLModelId)(_.mLModelId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
