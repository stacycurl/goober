package goober.hi

import goober.free.frauddetector.FraudDetectorIO
import software.amazon.awssdk.services.frauddetector.model._


object frauddetector {
  import goober.free.{frauddetector ⇒ free}

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

    def batchCreateVariableError(
      name: Option[String] = None,
      code: Option[Int] = None,
      message: Option[String] = None
    ): BatchCreateVariableError =
      BatchCreateVariableError
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def batchCreateVariableRequest(
      variableEntries: Option[List[VariableEntry]] = None,
      tags: Option[List[Tag]] = None
    ): BatchCreateVariableRequest =
      BatchCreateVariableRequest
        .builder
        .ifSome(variableEntries)(_.variableEntries(_))
        .ifSome(tags)(_.tags(_))
        .build

    def batchGetVariableError(
      name: Option[String] = None,
      code: Option[Int] = None,
      message: Option[String] = None
    ): BatchGetVariableError =
      BatchGetVariableError
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def batchGetVariableRequest(
      names: Option[List[string]] = None
    ): BatchGetVariableRequest =
      BatchGetVariableRequest
        .builder
        .ifSome(names)(_.names(_))
        .build

    def batchPrediction(
      jobId: Option[String] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None,
      startTime: Option[String] = None,
      completionTime: Option[String] = None,
      lastHeartbeatTime: Option[String] = None,
      inputPath: Option[String] = None,
      outputPath: Option[String] = None,
      eventTypeName: Option[String] = None,
      detectorName: Option[String] = None,
      detectorVersion: Option[String] = None,
      iamRoleArn: Option[String] = None,
      arn: Option[String] = None,
      processedRecordsCount: Option[Int] = None,
      totalRecordsCount: Option[Int] = None
    ): BatchPrediction =
      BatchPrediction
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(completionTime)(_.completionTime(_))
        .ifSome(lastHeartbeatTime)(_.lastHeartbeatTime(_))
        .ifSome(inputPath)(_.inputPath(_))
        .ifSome(outputPath)(_.outputPath(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(detectorName)(_.detectorName(_))
        .ifSome(detectorVersion)(_.detectorVersion(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(processedRecordsCount)(_.processedRecordsCount(_))
        .ifSome(totalRecordsCount)(_.totalRecordsCount(_))
        .build

    def cancelBatchPredictionJobRequest(
      jobId: Option[String] = None
    ): CancelBatchPredictionJobRequest =
      CancelBatchPredictionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createBatchPredictionJobRequest(
      jobId: Option[String] = None,
      inputPath: Option[String] = None,
      outputPath: Option[String] = None,
      eventTypeName: Option[String] = None,
      detectorName: Option[String] = None,
      detectorVersion: Option[String] = None,
      iamRoleArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateBatchPredictionJobRequest =
      CreateBatchPredictionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(inputPath)(_.inputPath(_))
        .ifSome(outputPath)(_.outputPath(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(detectorName)(_.detectorName(_))
        .ifSome(detectorVersion)(_.detectorVersion(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDetectorVersionRequest(
      detectorId: Option[String] = None,
      description: Option[String] = None,
      externalModelEndpoints: Option[List[string]] = None,
      rules: Option[List[Rule]] = None,
      modelVersions: Option[List[ModelVersion]] = None,
      ruleExecutionMode: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDetectorVersionRequest =
      CreateDetectorVersionRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(description)(_.description(_))
        .ifSome(externalModelEndpoints)(_.externalModelEndpoints(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(modelVersions)(_.modelVersions(_))
        .ifSome(ruleExecutionMode)(_.ruleExecutionMode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      description: Option[String] = None,
      eventTypeName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelRequest =
      CreateModelRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelVersionRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      trainingDataSource: Option[String] = None,
      trainingDataSchema: Option[TrainingDataSchema] = None,
      externalEventsDetail: Option[ExternalEventsDetail] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelVersionRequest =
      CreateModelVersionRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(trainingDataSource)(_.trainingDataSource(_))
        .ifSome(trainingDataSchema)(_.trainingDataSchema(_))
        .ifSome(externalEventsDetail)(_.externalEventsDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRuleRequest(
      ruleId: Option[String] = None,
      detectorId: Option[String] = None,
      description: Option[String] = None,
      expression: Option[String] = None,
      language: Option[String] = None,
      outcomes: Option[List[string]] = None,
      tags: Option[List[Tag]] = None
    ): CreateRuleRequest =
      CreateRuleRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(description)(_.description(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(language)(_.language(_))
        .ifSome(outcomes)(_.outcomes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVariableRequest(
      name: Option[String] = None,
      dataType: Option[String] = None,
      dataSource: Option[String] = None,
      defaultValue: Option[String] = None,
      description: Option[String] = None,
      variableType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateVariableRequest =
      CreateVariableRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(variableType)(_.variableType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def dataValidationMetrics(
      fileLevelMessages: Option[List[FileValidationMessage]] = None,
      fieldLevelMessages: Option[List[FieldValidationMessage]] = None
    ): DataValidationMetrics =
      DataValidationMetrics
        .builder
        .ifSome(fileLevelMessages)(_.fileLevelMessages(_))
        .ifSome(fieldLevelMessages)(_.fieldLevelMessages(_))
        .build

    def deleteBatchPredictionJobRequest(
      jobId: Option[String] = None
    ): DeleteBatchPredictionJobRequest =
      DeleteBatchPredictionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def deleteDetectorRequest(
      detectorId: Option[String] = None
    ): DeleteDetectorRequest =
      DeleteDetectorRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .build

    def deleteDetectorVersionRequest(
      detectorId: Option[String] = None,
      detectorVersionId: Option[String] = None
    ): DeleteDetectorVersionRequest =
      DeleteDetectorVersionRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(detectorVersionId)(_.detectorVersionId(_))
        .build

    def deleteEntityTypeRequest(
      name: Option[String] = None
    ): DeleteEntityTypeRequest =
      DeleteEntityTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteEventRequest(
      eventId: Option[String] = None,
      eventTypeName: Option[String] = None
    ): DeleteEventRequest =
      DeleteEventRequest
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .build

    def deleteEventTypeRequest(
      name: Option[String] = None
    ): DeleteEventTypeRequest =
      DeleteEventTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteExternalModelRequest(
      modelEndpoint: Option[String] = None
    ): DeleteExternalModelRequest =
      DeleteExternalModelRequest
        .builder
        .ifSome(modelEndpoint)(_.modelEndpoint(_))
        .build

    def deleteLabelRequest(
      name: Option[String] = None
    ): DeleteLabelRequest =
      DeleteLabelRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteModelRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None
    ): DeleteModelRequest =
      DeleteModelRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .build

    def deleteModelVersionRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      modelVersionNumber: Option[String] = None
    ): DeleteModelVersionRequest =
      DeleteModelVersionRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(modelVersionNumber)(_.modelVersionNumber(_))
        .build

    def deleteOutcomeRequest(
      name: Option[String] = None
    ): DeleteOutcomeRequest =
      DeleteOutcomeRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteRuleRequest(
      rule: Option[Rule] = None
    ): DeleteRuleRequest =
      DeleteRuleRequest
        .builder
        .ifSome(rule)(_.rule(_))
        .build

    def deleteVariableRequest(
      name: Option[String] = None
    ): DeleteVariableRequest =
      DeleteVariableRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeDetectorRequest(
      detectorId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeDetectorRequest =
      DescribeDetectorRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeModelVersionsRequest(
      modelId: Option[String] = None,
      modelVersionNumber: Option[String] = None,
      modelType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeModelVersionsRequest =
      DescribeModelVersionsRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelVersionNumber)(_.modelVersionNumber(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def detector(
      detectorId: Option[String] = None,
      description: Option[String] = None,
      eventTypeName: Option[String] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): Detector =
      Detector
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def detectorVersionSummary(
      detectorVersionId: Option[String] = None,
      status: Option[String] = None,
      description: Option[String] = None,
      lastUpdatedTime: Option[String] = None
    ): DetectorVersionSummary =
      DetectorVersionSummary
        .builder
        .ifSome(detectorVersionId)(_.detectorVersionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def entity(
      entityType: Option[String] = None,
      entityId: Option[String] = None
    ): Entity =
      Entity
        .builder
        .ifSome(entityType)(_.entityType(_))
        .ifSome(entityId)(_.entityId(_))
        .build

    def entityType(
      name: Option[String] = None,
      description: Option[String] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): EntityType =
      EntityType
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def eventType(
      name: Option[String] = None,
      description: Option[String] = None,
      eventVariables: Option[List[string]] = None,
      labels: Option[List[string]] = None,
      entityTypes: Option[List[string]] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): EventType =
      EventType
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventVariables)(_.eventVariables(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(entityTypes)(_.entityTypes(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def externalEventsDetail(
      dataLocation: Option[String] = None,
      dataAccessRoleArn: Option[String] = None
    ): ExternalEventsDetail =
      ExternalEventsDetail
        .builder
        .ifSome(dataLocation)(_.dataLocation(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .build

    def externalModel(
      modelEndpoint: Option[String] = None,
      modelSource: Option[String] = None,
      invokeModelEndpointRoleArn: Option[String] = None,
      inputConfiguration: Option[ModelInputConfiguration] = None,
      outputConfiguration: Option[ModelOutputConfiguration] = None,
      modelEndpointStatus: Option[String] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): ExternalModel =
      ExternalModel
        .builder
        .ifSome(modelEndpoint)(_.modelEndpoint(_))
        .ifSome(modelSource)(_.modelSource(_))
        .ifSome(invokeModelEndpointRoleArn)(_.invokeModelEndpointRoleArn(_))
        .ifSome(inputConfiguration)(_.inputConfiguration(_))
        .ifSome(outputConfiguration)(_.outputConfiguration(_))
        .ifSome(modelEndpointStatus)(_.modelEndpointStatus(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def fieldValidationMessage(
      fieldName: Option[String] = None,
      identifier: Option[String] = None,
      title: Option[String] = None,
      content: Option[String] = None,
      `type`: Option[String] = None
    ): FieldValidationMessage =
      FieldValidationMessage
        .builder
        .ifSome(fieldName)(_.fieldName(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(title)(_.title(_))
        .ifSome(content)(_.content(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def fileValidationMessage(
      title: Option[String] = None,
      content: Option[String] = None,
      `type`: Option[String] = None
    ): FileValidationMessage =
      FileValidationMessage
        .builder
        .ifSome(title)(_.title(_))
        .ifSome(content)(_.content(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def getBatchPredictionJobsRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetBatchPredictionJobsRequest =
      GetBatchPredictionJobsRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDetectorVersionRequest(
      detectorId: Option[String] = None,
      detectorVersionId: Option[String] = None
    ): GetDetectorVersionRequest =
      GetDetectorVersionRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(detectorVersionId)(_.detectorVersionId(_))
        .build

    def getDetectorsRequest(
      detectorId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetDetectorsRequest =
      GetDetectorsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getEntityTypesRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEntityTypesRequest =
      GetEntityTypesRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getEventPredictionRequest(
      detectorId: Option[String] = None,
      detectorVersionId: Option[String] = None,
      eventId: Option[String] = None,
      eventTypeName: Option[String] = None,
      entities: Option[List[Entity]] = None,
      eventTimestamp: Option[String] = None,
      eventVariables: Option[EventVariableMap] = None,
      externalModelEndpointDataBlobs: Option[ExternalModelEndpointDataBlobMap] = None
    ): GetEventPredictionRequest =
      GetEventPredictionRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(detectorVersionId)(_.detectorVersionId(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(entities)(_.entities(_))
        .ifSome(eventTimestamp)(_.eventTimestamp(_))
        .ifSome(eventVariables)(_.eventVariables(_))
        .ifSome(externalModelEndpointDataBlobs)(_.externalModelEndpointDataBlobs(_))
        .build

    def getEventTypesRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEventTypesRequest =
      GetEventTypesRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getExternalModelsRequest(
      modelEndpoint: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetExternalModelsRequest =
      GetExternalModelsRequest
        .builder
        .ifSome(modelEndpoint)(_.modelEndpoint(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getLabelsRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetLabelsRequest =
      GetLabelsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getModelVersionRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      modelVersionNumber: Option[String] = None
    ): GetModelVersionRequest =
      GetModelVersionRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(modelVersionNumber)(_.modelVersionNumber(_))
        .build

    def getModelsRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetModelsRequest =
      GetModelsRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getOutcomesRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetOutcomesRequest =
      GetOutcomesRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getRulesRequest(
      ruleId: Option[String] = None,
      detectorId: Option[String] = None,
      ruleVersion: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetRulesRequest =
      GetRulesRequest
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(ruleVersion)(_.ruleVersion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getVariablesRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetVariablesRequest =
      GetVariablesRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSKey(
      kmsEncryptionKeyArn: Option[String] = None
    ): KMSKey =
      KMSKey
        .builder
        .ifSome(kmsEncryptionKeyArn)(_.kmsEncryptionKeyArn(_))
        .build

    def label(
      name: Option[String] = None,
      description: Option[String] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): Label =
      Label
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def labelSchema(
      labelMapper: Option[labelMapper] = None
    ): LabelSchema =
      LabelSchema
        .builder
        .ifSome(labelMapper)(_.labelMapper(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def metricDataPoint(
      fpr: Option[float] = None,
      precision: Option[float] = None,
      tpr: Option[float] = None,
      threshold: Option[float] = None
    ): MetricDataPoint =
      MetricDataPoint
        .builder
        .ifSome(fpr)(_.fpr(_))
        .ifSome(precision)(_.precision(_))
        .ifSome(tpr)(_.tpr(_))
        .ifSome(threshold)(_.threshold(_))
        .build

    def model(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      description: Option[String] = None,
      eventTypeName: Option[String] = None,
      createdTime: Option[String] = None,
      lastUpdatedTime: Option[String] = None,
      arn: Option[String] = None
    ): Model =
      Model
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def modelEndpointDataBlob(
      byteBuffer: Option[blob] = None,
      contentType: Option[String] = None
    ): ModelEndpointDataBlob =
      ModelEndpointDataBlob
        .builder
        .ifSome(byteBuffer)(_.byteBuffer(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def modelInputConfiguration(
      eventTypeName: Option[String] = None,
      format: Option[String] = None,
      useEventVariables: Option[Boolean] = None,
      jsonInputTemplate: Option[String] = None,
      csvInputTemplate: Option[String] = None
    ): ModelInputConfiguration =
      ModelInputConfiguration
        .builder
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(format)(_.format(_))
        .ifSome(useEventVariables)(_.useEventVariables(_))
        .ifSome(jsonInputTemplate)(_.jsonInputTemplate(_))
        .ifSome(csvInputTemplate)(_.csvInputTemplate(_))
        .build

    def modelOutputConfiguration(
      format: Option[String] = None,
      jsonKeyToVariableMap: Option[JsonKeyToVariableMap] = None,
      csvIndexToVariableMap: Option[CsvIndexToVariableMap] = None
    ): ModelOutputConfiguration =
      ModelOutputConfiguration
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(jsonKeyToVariableMap)(_.jsonKeyToVariableMap(_))
        .ifSome(csvIndexToVariableMap)(_.csvIndexToVariableMap(_))
        .build

    def modelScores(
      modelVersion: Option[ModelVersion] = None,
      scores: Option[ModelPredictionMap] = None
    ): ModelScores =
      ModelScores
        .builder
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(scores)(_.scores(_))
        .build

    def modelVersion(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      modelVersionNumber: Option[String] = None,
      arn: Option[String] = None
    ): ModelVersion =
      ModelVersion
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(modelVersionNumber)(_.modelVersionNumber(_))
        .ifSome(arn)(_.arn(_))
        .build

    def modelVersionDetail(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      modelVersionNumber: Option[String] = None,
      status: Option[String] = None,
      trainingDataSource: Option[String] = None,
      trainingDataSchema: Option[TrainingDataSchema] = None,
      externalEventsDetail: Option[ExternalEventsDetail] = None,
      trainingResult: Option[TrainingResult] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): ModelVersionDetail =
      ModelVersionDetail
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(modelVersionNumber)(_.modelVersionNumber(_))
        .ifSome(status)(_.status(_))
        .ifSome(trainingDataSource)(_.trainingDataSource(_))
        .ifSome(trainingDataSchema)(_.trainingDataSchema(_))
        .ifSome(externalEventsDetail)(_.externalEventsDetail(_))
        .ifSome(trainingResult)(_.trainingResult(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def outcome(
      name: Option[String] = None,
      description: Option[String] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): Outcome =
      Outcome
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def putDetectorRequest(
      detectorId: Option[String] = None,
      description: Option[String] = None,
      eventTypeName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutDetectorRequest =
      PutDetectorRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putEntityTypeRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutEntityTypeRequest =
      PutEntityTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putEventTypeRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      eventVariables: Option[List[string]] = None,
      labels: Option[List[string]] = None,
      entityTypes: Option[List[string]] = None,
      tags: Option[List[Tag]] = None
    ): PutEventTypeRequest =
      PutEventTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventVariables)(_.eventVariables(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(entityTypes)(_.entityTypes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putExternalModelRequest(
      modelEndpoint: Option[String] = None,
      modelSource: Option[String] = None,
      invokeModelEndpointRoleArn: Option[String] = None,
      inputConfiguration: Option[ModelInputConfiguration] = None,
      outputConfiguration: Option[ModelOutputConfiguration] = None,
      modelEndpointStatus: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutExternalModelRequest =
      PutExternalModelRequest
        .builder
        .ifSome(modelEndpoint)(_.modelEndpoint(_))
        .ifSome(modelSource)(_.modelSource(_))
        .ifSome(invokeModelEndpointRoleArn)(_.invokeModelEndpointRoleArn(_))
        .ifSome(inputConfiguration)(_.inputConfiguration(_))
        .ifSome(outputConfiguration)(_.outputConfiguration(_))
        .ifSome(modelEndpointStatus)(_.modelEndpointStatus(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putKMSEncryptionKeyRequest(
      kmsEncryptionKeyArn: Option[String] = None
    ): PutKMSEncryptionKeyRequest =
      PutKMSEncryptionKeyRequest
        .builder
        .ifSome(kmsEncryptionKeyArn)(_.kmsEncryptionKeyArn(_))
        .build

    def putLabelRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutLabelRequest =
      PutLabelRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putOutcomeRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutOutcomeRequest =
      PutOutcomeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def rule(
      detectorId: Option[String] = None,
      ruleId: Option[String] = None,
      ruleVersion: Option[String] = None
    ): Rule =
      Rule
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(ruleVersion)(_.ruleVersion(_))
        .build

    def ruleDetail(
      ruleId: Option[String] = None,
      description: Option[String] = None,
      detectorId: Option[String] = None,
      ruleVersion: Option[String] = None,
      expression: Option[String] = None,
      language: Option[String] = None,
      outcomes: Option[List[string]] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): RuleDetail =
      RuleDetail
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(description)(_.description(_))
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(ruleVersion)(_.ruleVersion(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(language)(_.language(_))
        .ifSome(outcomes)(_.outcomes(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trainingDataSchema(
      modelVariables: Option[List[string]] = None,
      labelSchema: Option[LabelSchema] = None
    ): TrainingDataSchema =
      TrainingDataSchema
        .builder
        .ifSome(modelVariables)(_.modelVariables(_))
        .ifSome(labelSchema)(_.labelSchema(_))
        .build

    def trainingMetrics(
      auc: Option[float] = None,
      metricDataPoints: Option[List[MetricDataPoint]] = None
    ): TrainingMetrics =
      TrainingMetrics
        .builder
        .ifSome(auc)(_.auc(_))
        .ifSome(metricDataPoints)(_.metricDataPoints(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[tagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateDetectorVersionMetadataRequest(
      detectorId: Option[String] = None,
      detectorVersionId: Option[String] = None,
      description: Option[String] = None
    ): UpdateDetectorVersionMetadataRequest =
      UpdateDetectorVersionMetadataRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(detectorVersionId)(_.detectorVersionId(_))
        .ifSome(description)(_.description(_))
        .build

    def updateDetectorVersionRequest(
      detectorId: Option[String] = None,
      detectorVersionId: Option[String] = None,
      externalModelEndpoints: Option[List[string]] = None,
      rules: Option[List[Rule]] = None,
      description: Option[String] = None,
      modelVersions: Option[List[ModelVersion]] = None,
      ruleExecutionMode: Option[String] = None
    ): UpdateDetectorVersionRequest =
      UpdateDetectorVersionRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(detectorVersionId)(_.detectorVersionId(_))
        .ifSome(externalModelEndpoints)(_.externalModelEndpoints(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(description)(_.description(_))
        .ifSome(modelVersions)(_.modelVersions(_))
        .ifSome(ruleExecutionMode)(_.ruleExecutionMode(_))
        .build

    def updateDetectorVersionStatusRequest(
      detectorId: Option[String] = None,
      detectorVersionId: Option[String] = None,
      status: Option[String] = None
    ): UpdateDetectorVersionStatusRequest =
      UpdateDetectorVersionStatusRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(detectorVersionId)(_.detectorVersionId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateModelRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      description: Option[String] = None
    ): UpdateModelRequest =
      UpdateModelRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(description)(_.description(_))
        .build

    def updateModelVersionRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      majorVersionNumber: Option[String] = None,
      externalEventsDetail: Option[ExternalEventsDetail] = None,
      tags: Option[List[Tag]] = None
    ): UpdateModelVersionRequest =
      UpdateModelVersionRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(majorVersionNumber)(_.majorVersionNumber(_))
        .ifSome(externalEventsDetail)(_.externalEventsDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateModelVersionStatusRequest(
      modelId: Option[String] = None,
      modelType: Option[String] = None,
      modelVersionNumber: Option[String] = None,
      status: Option[String] = None
    ): UpdateModelVersionStatusRequest =
      UpdateModelVersionStatusRequest
        .builder
        .ifSome(modelId)(_.modelId(_))
        .ifSome(modelType)(_.modelType(_))
        .ifSome(modelVersionNumber)(_.modelVersionNumber(_))
        .ifSome(status)(_.status(_))
        .build

    def updateRuleMetadataRequest(
      rule: Option[Rule] = None,
      description: Option[String] = None
    ): UpdateRuleMetadataRequest =
      UpdateRuleMetadataRequest
        .builder
        .ifSome(rule)(_.rule(_))
        .ifSome(description)(_.description(_))
        .build

    def updateRuleVersionRequest(
      rule: Option[Rule] = None,
      description: Option[String] = None,
      expression: Option[String] = None,
      language: Option[String] = None,
      outcomes: Option[List[string]] = None,
      tags: Option[List[Tag]] = None
    ): UpdateRuleVersionRequest =
      UpdateRuleVersionRequest
        .builder
        .ifSome(rule)(_.rule(_))
        .ifSome(description)(_.description(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(language)(_.language(_))
        .ifSome(outcomes)(_.outcomes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateVariableRequest(
      name: Option[String] = None,
      defaultValue: Option[String] = None,
      description: Option[String] = None,
      variableType: Option[String] = None
    ): UpdateVariableRequest =
      UpdateVariableRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(variableType)(_.variableType(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def variable(
      name: Option[String] = None,
      dataType: Option[String] = None,
      dataSource: Option[String] = None,
      defaultValue: Option[String] = None,
      description: Option[String] = None,
      variableType: Option[String] = None,
      lastUpdatedTime: Option[String] = None,
      createdTime: Option[String] = None,
      arn: Option[String] = None
    ): Variable =
      Variable
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(variableType)(_.variableType(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(arn)(_.arn(_))
        .build

    def variableEntry(
      name: Option[String] = None,
      dataType: Option[String] = None,
      dataSource: Option[String] = None,
      defaultValue: Option[String] = None,
      description: Option[String] = None,
      variableType: Option[String] = None
    ): VariableEntry =
      VariableEntry
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(variableType)(_.variableType(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
