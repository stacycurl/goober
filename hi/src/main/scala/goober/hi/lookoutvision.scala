package goober.hi

import goober.free.lookoutvision.LookoutVisionIO
import software.amazon.awssdk.services.lookoutvision.model._


object lookoutvision {
  import goober.free.{lookoutvision ⇒ free}

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
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def createDatasetRequest(
      projectName: Option[String] = None,
      datasetType: Option[String] = None,
      datasetSource: Option[DatasetSource] = None,
      clientToken: Option[String] = None
    ): CreateDatasetRequest =
      CreateDatasetRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(datasetSource)(_.datasetSource(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createDatasetResponse(
      datasetMetadata: Option[DatasetMetadata] = None
    ): CreateDatasetResponse =
      CreateDatasetResponse
        .builder
        .ifSome(datasetMetadata)(_.datasetMetadata(_))
        .build

    def createModelRequest(
      projectName: Option[String] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None,
      outputConfig: Option[OutputConfig] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelRequest =
      CreateModelRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelResponse(
      modelMetadata: Option[ModelMetadata] = None
    ): CreateModelResponse =
      CreateModelResponse
        .builder
        .ifSome(modelMetadata)(_.modelMetadata(_))
        .build

    def createProjectRequest(
      projectName: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createProjectResponse(
      projectMetadata: Option[ProjectMetadata] = None
    ): CreateProjectResponse =
      CreateProjectResponse
        .builder
        .ifSome(projectMetadata)(_.projectMetadata(_))
        .build

    def datasetDescription(
      projectName: Option[String] = None,
      datasetType: Option[String] = None,
      creationTimestamp: Option[DateTime] = None,
      lastUpdatedTimestamp: Option[DateTime] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      imageStats: Option[DatasetImageStats] = None
    ): DatasetDescription =
      DatasetDescription
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(imageStats)(_.imageStats(_))
        .build

    def datasetGroundTruthManifest(
      s3Object: Option[InputS3Object] = None
    ): DatasetGroundTruthManifest =
      DatasetGroundTruthManifest
        .builder
        .ifSome(s3Object)(_.s3Object(_))
        .build

    def datasetImageStats(
      total: Option[Int] = None,
      labeled: Option[Int] = None,
      normal: Option[Int] = None,
      anomaly: Option[Int] = None
    ): DatasetImageStats =
      DatasetImageStats
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(labeled)(_.labeled(_))
        .ifSome(normal)(_.normal(_))
        .ifSome(anomaly)(_.anomaly(_))
        .build

    def datasetMetadata(
      datasetType: Option[String] = None,
      creationTimestamp: Option[DateTime] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): DatasetMetadata =
      DatasetMetadata
        .builder
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def datasetSource(
      groundTruthManifest: Option[DatasetGroundTruthManifest] = None
    ): DatasetSource =
      DatasetSource
        .builder
        .ifSome(groundTruthManifest)(_.groundTruthManifest(_))
        .build

    def deleteDatasetRequest(
      projectName: Option[String] = None,
      datasetType: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteDatasetRequest =
      DeleteDatasetRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteDatasetResponse(

    ): DeleteDatasetResponse =
      DeleteDatasetResponse
        .builder

        .build

    def deleteModelRequest(
      projectName: Option[String] = None,
      modelVersion: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteModelRequest =
      DeleteModelRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteModelResponse(
      modelArn: Option[String] = None
    ): DeleteModelResponse =
      DeleteModelResponse
        .builder
        .ifSome(modelArn)(_.modelArn(_))
        .build

    def deleteProjectRequest(
      projectName: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteProjectResponse(
      projectArn: Option[String] = None
    ): DeleteProjectResponse =
      DeleteProjectResponse
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .build

    def describeDatasetRequest(
      projectName: Option[String] = None,
      datasetType: Option[String] = None
    ): DescribeDatasetRequest =
      DescribeDatasetRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(datasetType)(_.datasetType(_))
        .build

    def describeDatasetResponse(
      datasetDescription: Option[DatasetDescription] = None
    ): DescribeDatasetResponse =
      DescribeDatasetResponse
        .builder
        .ifSome(datasetDescription)(_.datasetDescription(_))
        .build

    def describeModelRequest(
      projectName: Option[String] = None,
      modelVersion: Option[String] = None
    ): DescribeModelRequest =
      DescribeModelRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def describeModelResponse(
      modelDescription: Option[ModelDescription] = None
    ): DescribeModelResponse =
      DescribeModelResponse
        .builder
        .ifSome(modelDescription)(_.modelDescription(_))
        .build

    def describeProjectRequest(
      projectName: Option[String] = None
    ): DescribeProjectRequest =
      DescribeProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def describeProjectResponse(
      projectDescription: Option[ProjectDescription] = None
    ): DescribeProjectResponse =
      DescribeProjectResponse
        .builder
        .ifSome(projectDescription)(_.projectDescription(_))
        .build

    def detectAnomaliesRequest(
      projectName: Option[String] = None,
      modelVersion: Option[String] = None,
      body: Option[Stream] = None,
      contentType: Option[String] = None
    ): DetectAnomaliesRequest =
      DetectAnomaliesRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(body)(_.body(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def detectAnomaliesResponse(
      detectAnomalyResult: Option[DetectAnomalyResult] = None
    ): DetectAnomaliesResponse =
      DetectAnomaliesResponse
        .builder
        .ifSome(detectAnomalyResult)(_.detectAnomalyResult(_))
        .build

    def imageSource(
      `type`: Option[String] = None
    ): ImageSource =
      ImageSource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def inputS3Object(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None
    ): InputS3Object =
      InputS3Object
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def listDatasetEntriesRequest(
      projectName: Option[String] = None,
      datasetType: Option[String] = None,
      labeled: Option[Boolean] = None,
      anomalyClass: Option[String] = None,
      beforeCreationDate: Option[DateTime] = None,
      afterCreationDate: Option[DateTime] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sourceRefContains: Option[String] = None
    ): ListDatasetEntriesRequest =
      ListDatasetEntriesRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(labeled)(_.labeled(_))
        .ifSome(anomalyClass)(_.anomalyClass(_))
        .ifSome(beforeCreationDate)(_.beforeCreationDate(_))
        .ifSome(afterCreationDate)(_.afterCreationDate(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sourceRefContains)(_.sourceRefContains(_))
        .build

    def listDatasetEntriesResponse(
      datasetEntries: Option[List[DatasetEntry]] = None,
      nextToken: Option[String] = None
    ): ListDatasetEntriesResponse =
      ListDatasetEntriesResponse
        .builder
        .ifSome(datasetEntries)(_.datasetEntries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listModelsRequest(
      projectName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListModelsRequest =
      ListModelsRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listModelsResponse(
      models: Option[List[ModelMetadata]] = None,
      nextToken: Option[String] = None
    ): ListModelsResponse =
      ListModelsResponse
        .builder
        .ifSome(models)(_.models(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProjectsRequest =
      ListProjectsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProjectsResponse(
      projects: Option[List[ProjectMetadata]] = None,
      nextToken: Option[String] = None
    ): ListProjectsResponse =
      ListProjectsResponse
        .builder
        .ifSome(projects)(_.projects(_))
        .ifSome(nextToken)(_.nextToken(_))
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

    def modelDescription(
      modelVersion: Option[String] = None,
      modelArn: Option[String] = None,
      creationTimestamp: Option[DateTime] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      performance: Option[ModelPerformance] = None,
      outputConfig: Option[OutputConfig] = None,
      evaluationManifest: Option[OutputS3Object] = None,
      evaluationResult: Option[OutputS3Object] = None,
      evaluationEndTimestamp: Option[DateTime] = None,
      kmsKeyId: Option[String] = None
    ): ModelDescription =
      ModelDescription
        .builder
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(performance)(_.performance(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(evaluationManifest)(_.evaluationManifest(_))
        .ifSome(evaluationResult)(_.evaluationResult(_))
        .ifSome(evaluationEndTimestamp)(_.evaluationEndTimestamp(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def modelMetadata(
      creationTimestamp: Option[DateTime] = None,
      modelVersion: Option[String] = None,
      modelArn: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      performance: Option[ModelPerformance] = None
    ): ModelMetadata =
      ModelMetadata
        .builder
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(performance)(_.performance(_))
        .build

    def modelPerformance(
      f1Score: Option[Float] = None,
      recall: Option[Float] = None,
      precision: Option[Float] = None
    ): ModelPerformance =
      ModelPerformance
        .builder
        .ifSome(f1Score)(_.f1Score(_))
        .ifSome(recall)(_.recall(_))
        .ifSome(precision)(_.precision(_))
        .build

    def outputConfig(
      s3Location: Option[S3Location] = None
    ): OutputConfig =
      OutputConfig
        .builder
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def outputS3Object(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): OutputS3Object =
      OutputS3Object
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def projectDescription(
      projectArn: Option[String] = None,
      projectName: Option[String] = None,
      creationTimestamp: Option[DateTime] = None,
      datasets: Option[List[DatasetMetadata]] = None
    ): ProjectDescription =
      ProjectDescription
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(datasets)(_.datasets(_))
        .build

    def projectMetadata(
      projectArn: Option[String] = None,
      projectName: Option[String] = None,
      creationTimestamp: Option[DateTime] = None
    ): ProjectMetadata =
      ProjectMetadata
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def s3Location(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def startModelRequest(
      projectName: Option[String] = None,
      modelVersion: Option[String] = None,
      minInferenceUnits: Option[Int] = None,
      clientToken: Option[String] = None
    ): StartModelRequest =
      StartModelRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(minInferenceUnits)(_.minInferenceUnits(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startModelResponse(
      status: Option[String] = None
    ): StartModelResponse =
      StartModelResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def stopModelRequest(
      projectName: Option[String] = None,
      modelVersion: Option[String] = None,
      clientToken: Option[String] = None
    ): StopModelRequest =
      StopModelRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def stopModelResponse(
      status: Option[String] = None
    ): StopModelResponse =
      StopModelResponse
        .builder
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
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
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

    def updateDatasetEntriesRequest(
      projectName: Option[String] = None,
      datasetType: Option[String] = None,
      changes: Option[DatasetChanges] = None,
      clientToken: Option[String] = None
    ): UpdateDatasetEntriesRequest =
      UpdateDatasetEntriesRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(changes)(_.changes(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateDatasetEntriesResponse(
      status: Option[String] = None
    ): UpdateDatasetEntriesResponse =
      UpdateDatasetEntriesResponse
        .builder
        .ifSome(status)(_.status(_))
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
