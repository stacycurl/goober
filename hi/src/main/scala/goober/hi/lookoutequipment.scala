package goober.hi

import goober.free.lookoutequipment.LookoutEquipmentIO
import software.amazon.awssdk.services.lookoutequipment.model._


object lookoutequipment {
  import goober.free.{lookoutequipment ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createDatasetRequest(
      datasetName: Option[String] = None,
      datasetSchema: Option[DatasetSchema] = None,
      serverSideKmsKeyId: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDatasetRequest =
      CreateDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetSchema)(_.datasetSchema(_))
        .ifSome(serverSideKmsKeyId)(_.serverSideKmsKeyId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDatasetResponse(
      datasetName: Option[String] = None,
      datasetArn: Option[String] = None,
      status: Option[String] = None
    ): CreateDatasetResponse =
      CreateDatasetResponse
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(status)(_.status(_))
        .build

    def createInferenceSchedulerRequest(
      modelName: Option[String] = None,
      inferenceSchedulerName: Option[String] = None,
      dataDelayOffsetInMinutes: Option[DataDelayOffsetInMinutes] = None,
      dataUploadFrequency: Option[String] = None,
      dataInputConfiguration: Option[InferenceInputConfiguration] = None,
      dataOutputConfiguration: Option[InferenceOutputConfiguration] = None,
      roleArn: Option[String] = None,
      serverSideKmsKeyId: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateInferenceSchedulerRequest =
      CreateInferenceSchedulerRequest
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(dataDelayOffsetInMinutes)(_.dataDelayOffsetInMinutes(_))
        .ifSome(dataUploadFrequency)(_.dataUploadFrequency(_))
        .ifSome(dataInputConfiguration)(_.dataInputConfiguration(_))
        .ifSome(dataOutputConfiguration)(_.dataOutputConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(serverSideKmsKeyId)(_.serverSideKmsKeyId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createInferenceSchedulerResponse(
      inferenceSchedulerArn: Option[String] = None,
      inferenceSchedulerName: Option[String] = None,
      status: Option[String] = None
    ): CreateInferenceSchedulerResponse =
      CreateInferenceSchedulerResponse
        .builder
        .ifSome(inferenceSchedulerArn)(_.inferenceSchedulerArn(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(status)(_.status(_))
        .build

    def createModelRequest(
      modelName: Option[String] = None,
      datasetName: Option[String] = None,
      datasetSchema: Option[DatasetSchema] = None,
      labelsInputConfiguration: Option[LabelsInputConfiguration] = None,
      clientToken: Option[String] = None,
      trainingDataStartTime: Option[Timestamp] = None,
      trainingDataEndTime: Option[Timestamp] = None,
      evaluationDataStartTime: Option[Timestamp] = None,
      evaluationDataEndTime: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      dataPreProcessingConfiguration: Option[DataPreProcessingConfiguration] = None,
      serverSideKmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelRequest =
      CreateModelRequest
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetSchema)(_.datasetSchema(_))
        .ifSome(labelsInputConfiguration)(_.labelsInputConfiguration(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(trainingDataStartTime)(_.trainingDataStartTime(_))
        .ifSome(trainingDataEndTime)(_.trainingDataEndTime(_))
        .ifSome(evaluationDataStartTime)(_.evaluationDataStartTime(_))
        .ifSome(evaluationDataEndTime)(_.evaluationDataEndTime(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPreProcessingConfiguration)(_.dataPreProcessingConfiguration(_))
        .ifSome(serverSideKmsKeyId)(_.serverSideKmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelResponse(
      modelArn: Option[String] = None,
      status: Option[String] = None
    ): CreateModelResponse =
      CreateModelResponse
        .builder
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(status)(_.status(_))
        .build

    def dataIngestionJobSummary(
      jobId: Option[String] = None,
      datasetName: Option[String] = None,
      datasetArn: Option[String] = None,
      ingestionInputConfiguration: Option[IngestionInputConfiguration] = None,
      status: Option[String] = None
    ): DataIngestionJobSummary =
      DataIngestionJobSummary
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(ingestionInputConfiguration)(_.ingestionInputConfiguration(_))
        .ifSome(status)(_.status(_))
        .build

    def dataPreProcessingConfiguration(
      targetSamplingRate: Option[String] = None
    ): DataPreProcessingConfiguration =
      DataPreProcessingConfiguration
        .builder
        .ifSome(targetSamplingRate)(_.targetSamplingRate(_))
        .build

    def datasetSchema(
      inlineDataSchema: Option[String] = None
    ): DatasetSchema =
      DatasetSchema
        .builder
        .ifSome(inlineDataSchema)(_.inlineDataSchema(_))
        .build

    def datasetSummary(
      datasetName: Option[String] = None,
      datasetArn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[Timestamp] = None
    ): DatasetSummary =
      DatasetSummary
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def deleteDatasetRequest(
      datasetName: Option[String] = None
    ): DeleteDatasetRequest =
      DeleteDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .build

    def deleteInferenceSchedulerRequest(
      inferenceSchedulerName: Option[String] = None
    ): DeleteInferenceSchedulerRequest =
      DeleteInferenceSchedulerRequest
        .builder
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .build

    def deleteModelRequest(
      modelName: Option[String] = None
    ): DeleteModelRequest =
      DeleteModelRequest
        .builder
        .ifSome(modelName)(_.modelName(_))
        .build

    def describeDataIngestionJobRequest(
      jobId: Option[String] = None
    ): DescribeDataIngestionJobRequest =
      DescribeDataIngestionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeDataIngestionJobResponse(
      jobId: Option[String] = None,
      datasetArn: Option[String] = None,
      ingestionInputConfiguration: Option[IngestionInputConfiguration] = None,
      roleArn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      status: Option[String] = None,
      failedReason: Option[String] = None
    ): DescribeDataIngestionJobResponse =
      DescribeDataIngestionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(ingestionInputConfiguration)(_.ingestionInputConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(failedReason)(_.failedReason(_))
        .build

    def describeDatasetRequest(
      datasetName: Option[String] = None
    ): DescribeDatasetRequest =
      DescribeDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .build

    def describeDatasetResponse(
      datasetName: Option[String] = None,
      datasetArn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      status: Option[String] = None,
      schema: Option[String] = None,
      serverSideKmsKeyId: Option[String] = None,
      ingestionInputConfiguration: Option[IngestionInputConfiguration] = None
    ): DescribeDatasetResponse =
      DescribeDatasetResponse
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(serverSideKmsKeyId)(_.serverSideKmsKeyId(_))
        .ifSome(ingestionInputConfiguration)(_.ingestionInputConfiguration(_))
        .build

    def describeInferenceSchedulerRequest(
      inferenceSchedulerName: Option[String] = None
    ): DescribeInferenceSchedulerRequest =
      DescribeInferenceSchedulerRequest
        .builder
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .build

    def describeInferenceSchedulerResponse(
      modelArn: Option[String] = None,
      modelName: Option[String] = None,
      inferenceSchedulerName: Option[String] = None,
      inferenceSchedulerArn: Option[String] = None,
      status: Option[String] = None,
      dataDelayOffsetInMinutes: Option[DataDelayOffsetInMinutes] = None,
      dataUploadFrequency: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      dataInputConfiguration: Option[InferenceInputConfiguration] = None,
      dataOutputConfiguration: Option[InferenceOutputConfiguration] = None,
      roleArn: Option[String] = None,
      serverSideKmsKeyId: Option[String] = None
    ): DescribeInferenceSchedulerResponse =
      DescribeInferenceSchedulerResponse
        .builder
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(inferenceSchedulerArn)(_.inferenceSchedulerArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(dataDelayOffsetInMinutes)(_.dataDelayOffsetInMinutes(_))
        .ifSome(dataUploadFrequency)(_.dataUploadFrequency(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(dataInputConfiguration)(_.dataInputConfiguration(_))
        .ifSome(dataOutputConfiguration)(_.dataOutputConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(serverSideKmsKeyId)(_.serverSideKmsKeyId(_))
        .build

    def describeModelRequest(
      modelName: Option[String] = None
    ): DescribeModelRequest =
      DescribeModelRequest
        .builder
        .ifSome(modelName)(_.modelName(_))
        .build

    def describeModelResponse(
      modelName: Option[String] = None,
      modelArn: Option[String] = None,
      datasetName: Option[String] = None,
      datasetArn: Option[String] = None,
      schema: Option[String] = None,
      labelsInputConfiguration: Option[LabelsInputConfiguration] = None,
      trainingDataStartTime: Option[Timestamp] = None,
      trainingDataEndTime: Option[Timestamp] = None,
      evaluationDataStartTime: Option[Timestamp] = None,
      evaluationDataEndTime: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      dataPreProcessingConfiguration: Option[DataPreProcessingConfiguration] = None,
      status: Option[String] = None,
      trainingExecutionStartTime: Option[Timestamp] = None,
      trainingExecutionEndTime: Option[Timestamp] = None,
      failedReason: Option[String] = None,
      modelMetrics: Option[String] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      createdAt: Option[Timestamp] = None,
      serverSideKmsKeyId: Option[String] = None
    ): DescribeModelResponse =
      DescribeModelResponse
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(labelsInputConfiguration)(_.labelsInputConfiguration(_))
        .ifSome(trainingDataStartTime)(_.trainingDataStartTime(_))
        .ifSome(trainingDataEndTime)(_.trainingDataEndTime(_))
        .ifSome(evaluationDataStartTime)(_.evaluationDataStartTime(_))
        .ifSome(evaluationDataEndTime)(_.evaluationDataEndTime(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(dataPreProcessingConfiguration)(_.dataPreProcessingConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(trainingExecutionStartTime)(_.trainingExecutionStartTime(_))
        .ifSome(trainingExecutionEndTime)(_.trainingExecutionEndTime(_))
        .ifSome(failedReason)(_.failedReason(_))
        .ifSome(modelMetrics)(_.modelMetrics(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(serverSideKmsKeyId)(_.serverSideKmsKeyId(_))
        .build

    def inferenceExecutionSummary(
      modelName: Option[String] = None,
      modelArn: Option[String] = None,
      inferenceSchedulerName: Option[String] = None,
      inferenceSchedulerArn: Option[String] = None,
      scheduledStartTime: Option[Timestamp] = None,
      dataStartTime: Option[Timestamp] = None,
      dataEndTime: Option[Timestamp] = None,
      dataInputConfiguration: Option[InferenceInputConfiguration] = None,
      dataOutputConfiguration: Option[InferenceOutputConfiguration] = None,
      customerResultObject: Option[S3Object] = None,
      status: Option[String] = None,
      failedReason: Option[String] = None
    ): InferenceExecutionSummary =
      InferenceExecutionSummary
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(inferenceSchedulerArn)(_.inferenceSchedulerArn(_))
        .ifSome(scheduledStartTime)(_.scheduledStartTime(_))
        .ifSome(dataStartTime)(_.dataStartTime(_))
        .ifSome(dataEndTime)(_.dataEndTime(_))
        .ifSome(dataInputConfiguration)(_.dataInputConfiguration(_))
        .ifSome(dataOutputConfiguration)(_.dataOutputConfiguration(_))
        .ifSome(customerResultObject)(_.customerResultObject(_))
        .ifSome(status)(_.status(_))
        .ifSome(failedReason)(_.failedReason(_))
        .build

    def inferenceInputConfiguration(
      s3InputConfiguration: Option[InferenceS3InputConfiguration] = None,
      inputTimeZoneOffset: Option[String] = None,
      inferenceInputNameConfiguration: Option[InferenceInputNameConfiguration] = None
    ): InferenceInputConfiguration =
      InferenceInputConfiguration
        .builder
        .ifSome(s3InputConfiguration)(_.s3InputConfiguration(_))
        .ifSome(inputTimeZoneOffset)(_.inputTimeZoneOffset(_))
        .ifSome(inferenceInputNameConfiguration)(_.inferenceInputNameConfiguration(_))
        .build

    def inferenceInputNameConfiguration(
      timestampFormat: Option[String] = None,
      componentTimestampDelimiter: Option[String] = None
    ): InferenceInputNameConfiguration =
      InferenceInputNameConfiguration
        .builder
        .ifSome(timestampFormat)(_.timestampFormat(_))
        .ifSome(componentTimestampDelimiter)(_.componentTimestampDelimiter(_))
        .build

    def inferenceOutputConfiguration(
      s3OutputConfiguration: Option[InferenceS3OutputConfiguration] = None,
      kmsKeyId: Option[String] = None
    ): InferenceOutputConfiguration =
      InferenceOutputConfiguration
        .builder
        .ifSome(s3OutputConfiguration)(_.s3OutputConfiguration(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def inferenceS3InputConfiguration(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): InferenceS3InputConfiguration =
      InferenceS3InputConfiguration
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def inferenceS3OutputConfiguration(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): InferenceS3OutputConfiguration =
      InferenceS3OutputConfiguration
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def inferenceSchedulerSummary(
      modelName: Option[String] = None,
      modelArn: Option[String] = None,
      inferenceSchedulerName: Option[String] = None,
      inferenceSchedulerArn: Option[String] = None,
      status: Option[String] = None,
      dataDelayOffsetInMinutes: Option[DataDelayOffsetInMinutes] = None,
      dataUploadFrequency: Option[String] = None
    ): InferenceSchedulerSummary =
      InferenceSchedulerSummary
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(inferenceSchedulerArn)(_.inferenceSchedulerArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(dataDelayOffsetInMinutes)(_.dataDelayOffsetInMinutes(_))
        .ifSome(dataUploadFrequency)(_.dataUploadFrequency(_))
        .build

    def ingestionInputConfiguration(
      s3InputConfiguration: Option[IngestionS3InputConfiguration] = None
    ): IngestionInputConfiguration =
      IngestionInputConfiguration
        .builder
        .ifSome(s3InputConfiguration)(_.s3InputConfiguration(_))
        .build

    def ingestionS3InputConfiguration(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): IngestionS3InputConfiguration =
      IngestionS3InputConfiguration
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def labelsInputConfiguration(
      s3InputConfiguration: Option[LabelsS3InputConfiguration] = None
    ): LabelsInputConfiguration =
      LabelsInputConfiguration
        .builder
        .ifSome(s3InputConfiguration)(_.s3InputConfiguration(_))
        .build

    def labelsS3InputConfiguration(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): LabelsS3InputConfiguration =
      LabelsS3InputConfiguration
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def listDataIngestionJobsRequest(
      datasetName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      status: Option[String] = None
    ): ListDataIngestionJobsRequest =
      ListDataIngestionJobsRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(status)(_.status(_))
        .build

    def listDataIngestionJobsResponse(
      nextToken: Option[String] = None,
      dataIngestionJobSummaries: Option[List[DataIngestionJobSummary]] = None
    ): ListDataIngestionJobsResponse =
      ListDataIngestionJobsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(dataIngestionJobSummaries)(_.dataIngestionJobSummaries(_))
        .build

    def listDatasetsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      datasetNameBeginsWith: Option[String] = None
    ): ListDatasetsRequest =
      ListDatasetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(datasetNameBeginsWith)(_.datasetNameBeginsWith(_))
        .build

    def listDatasetsResponse(
      nextToken: Option[String] = None,
      datasetSummaries: Option[List[DatasetSummary]] = None
    ): ListDatasetsResponse =
      ListDatasetsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(datasetSummaries)(_.datasetSummaries(_))
        .build

    def listInferenceExecutionsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      inferenceSchedulerName: Option[String] = None,
      dataStartTimeAfter: Option[Timestamp] = None,
      dataEndTimeBefore: Option[Timestamp] = None,
      status: Option[String] = None
    ): ListInferenceExecutionsRequest =
      ListInferenceExecutionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(dataStartTimeAfter)(_.dataStartTimeAfter(_))
        .ifSome(dataEndTimeBefore)(_.dataEndTimeBefore(_))
        .ifSome(status)(_.status(_))
        .build

    def listInferenceExecutionsResponse(
      nextToken: Option[String] = None,
      inferenceExecutionSummaries: Option[List[InferenceExecutionSummary]] = None
    ): ListInferenceExecutionsResponse =
      ListInferenceExecutionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(inferenceExecutionSummaries)(_.inferenceExecutionSummaries(_))
        .build

    def listInferenceSchedulersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      inferenceSchedulerNameBeginsWith: Option[String] = None,
      modelName: Option[String] = None
    ): ListInferenceSchedulersRequest =
      ListInferenceSchedulersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(inferenceSchedulerNameBeginsWith)(_.inferenceSchedulerNameBeginsWith(_))
        .ifSome(modelName)(_.modelName(_))
        .build

    def listInferenceSchedulersResponse(
      nextToken: Option[String] = None,
      inferenceSchedulerSummaries: Option[List[InferenceSchedulerSummary]] = None
    ): ListInferenceSchedulersResponse =
      ListInferenceSchedulersResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(inferenceSchedulerSummaries)(_.inferenceSchedulerSummaries(_))
        .build

    def listModelsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      status: Option[String] = None,
      modelNameBeginsWith: Option[String] = None,
      datasetNameBeginsWith: Option[String] = None
    ): ListModelsRequest =
      ListModelsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(status)(_.status(_))
        .ifSome(modelNameBeginsWith)(_.modelNameBeginsWith(_))
        .ifSome(datasetNameBeginsWith)(_.datasetNameBeginsWith(_))
        .build

    def listModelsResponse(
      nextToken: Option[String] = None,
      modelSummaries: Option[List[ModelSummary]] = None
    ): ListModelsResponse =
      ListModelsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(modelSummaries)(_.modelSummaries(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def modelSummary(
      modelName: Option[String] = None,
      modelArn: Option[String] = None,
      datasetName: Option[String] = None,
      datasetArn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[Timestamp] = None
    ): ModelSummary =
      ModelSummary
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3Object(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): S3Object =
      S3Object
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startDataIngestionJobRequest(
      datasetName: Option[String] = None,
      ingestionInputConfiguration: Option[IngestionInputConfiguration] = None,
      roleArn: Option[String] = None,
      clientToken: Option[String] = None
    ): StartDataIngestionJobRequest =
      StartDataIngestionJobRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(ingestionInputConfiguration)(_.ingestionInputConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startDataIngestionJobResponse(
      jobId: Option[String] = None,
      status: Option[String] = None
    ): StartDataIngestionJobResponse =
      StartDataIngestionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(status)(_.status(_))
        .build

    def startInferenceSchedulerRequest(
      inferenceSchedulerName: Option[String] = None
    ): StartInferenceSchedulerRequest =
      StartInferenceSchedulerRequest
        .builder
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .build

    def startInferenceSchedulerResponse(
      modelArn: Option[String] = None,
      modelName: Option[String] = None,
      inferenceSchedulerName: Option[String] = None,
      inferenceSchedulerArn: Option[String] = None,
      status: Option[String] = None
    ): StartInferenceSchedulerResponse =
      StartInferenceSchedulerResponse
        .builder
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(inferenceSchedulerArn)(_.inferenceSchedulerArn(_))
        .ifSome(status)(_.status(_))
        .build

    def stopInferenceSchedulerRequest(
      inferenceSchedulerName: Option[String] = None
    ): StopInferenceSchedulerRequest =
      StopInferenceSchedulerRequest
        .builder
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .build

    def stopInferenceSchedulerResponse(
      modelArn: Option[String] = None,
      modelName: Option[String] = None,
      inferenceSchedulerName: Option[String] = None,
      inferenceSchedulerArn: Option[String] = None,
      status: Option[String] = None
    ): StopInferenceSchedulerResponse =
      StopInferenceSchedulerResponse
        .builder
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(inferenceSchedulerArn)(_.inferenceSchedulerArn(_))
        .ifSome(status)(_.status(_))
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

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateInferenceSchedulerRequest(
      inferenceSchedulerName: Option[String] = None,
      dataDelayOffsetInMinutes: Option[DataDelayOffsetInMinutes] = None,
      dataUploadFrequency: Option[String] = None,
      dataInputConfiguration: Option[InferenceInputConfiguration] = None,
      dataOutputConfiguration: Option[InferenceOutputConfiguration] = None,
      roleArn: Option[String] = None
    ): UpdateInferenceSchedulerRequest =
      UpdateInferenceSchedulerRequest
        .builder
        .ifSome(inferenceSchedulerName)(_.inferenceSchedulerName(_))
        .ifSome(dataDelayOffsetInMinutes)(_.dataDelayOffsetInMinutes(_))
        .ifSome(dataUploadFrequency)(_.dataUploadFrequency(_))
        .ifSome(dataInputConfiguration)(_.dataInputConfiguration(_))
        .ifSome(dataOutputConfiguration)(_.dataOutputConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
