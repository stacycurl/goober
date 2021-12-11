package goober.hi

import goober.free.healthlake.HealthLakeIO
import software.amazon.awssdk.services.healthlake.model._


object healthlake {
  import goober.free.{healthlake ⇒ free}

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

    def createFHIRDatastoreRequest(
      datastoreName: Option[String] = None,
      datastoreTypeVersion: Option[String] = None,
      preloadDataConfig: Option[PreloadDataConfig] = None,
      clientToken: Option[String] = None
    ): CreateFHIRDatastoreRequest =
      CreateFHIRDatastoreRequest
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(datastoreTypeVersion)(_.datastoreTypeVersion(_))
        .ifSome(preloadDataConfig)(_.preloadDataConfig(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createFHIRDatastoreResponse(
      datastoreId: Option[String] = None,
      datastoreArn: Option[String] = None,
      datastoreStatus: Option[String] = None,
      datastoreEndpoint: Option[String] = None
    ): CreateFHIRDatastoreResponse =
      CreateFHIRDatastoreResponse
        .builder
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(datastoreArn)(_.datastoreArn(_))
        .ifSome(datastoreStatus)(_.datastoreStatus(_))
        .ifSome(datastoreEndpoint)(_.datastoreEndpoint(_))
        .build

    def datastoreFilter(
      datastoreName: Option[String] = None,
      datastoreStatus: Option[String] = None,
      createdBefore: Option[Timestamp] = None,
      createdAfter: Option[Timestamp] = None
    ): DatastoreFilter =
      DatastoreFilter
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(datastoreStatus)(_.datastoreStatus(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .build

    def datastoreProperties(
      datastoreId: Option[String] = None,
      datastoreArn: Option[String] = None,
      datastoreName: Option[String] = None,
      datastoreStatus: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      datastoreTypeVersion: Option[String] = None,
      datastoreEndpoint: Option[String] = None,
      preloadDataConfig: Option[PreloadDataConfig] = None
    ): DatastoreProperties =
      DatastoreProperties
        .builder
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(datastoreArn)(_.datastoreArn(_))
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(datastoreStatus)(_.datastoreStatus(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(datastoreTypeVersion)(_.datastoreTypeVersion(_))
        .ifSome(datastoreEndpoint)(_.datastoreEndpoint(_))
        .ifSome(preloadDataConfig)(_.preloadDataConfig(_))
        .build

    def deleteFHIRDatastoreRequest(
      datastoreId: Option[String] = None
    ): DeleteFHIRDatastoreRequest =
      DeleteFHIRDatastoreRequest
        .builder
        .ifSome(datastoreId)(_.datastoreId(_))
        .build

    def deleteFHIRDatastoreResponse(
      datastoreId: Option[String] = None,
      datastoreArn: Option[String] = None,
      datastoreStatus: Option[String] = None,
      datastoreEndpoint: Option[String] = None
    ): DeleteFHIRDatastoreResponse =
      DeleteFHIRDatastoreResponse
        .builder
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(datastoreArn)(_.datastoreArn(_))
        .ifSome(datastoreStatus)(_.datastoreStatus(_))
        .ifSome(datastoreEndpoint)(_.datastoreEndpoint(_))
        .build

    def describeFHIRDatastoreRequest(
      datastoreId: Option[String] = None
    ): DescribeFHIRDatastoreRequest =
      DescribeFHIRDatastoreRequest
        .builder
        .ifSome(datastoreId)(_.datastoreId(_))
        .build

    def describeFHIRDatastoreResponse(
      datastoreProperties: Option[DatastoreProperties] = None
    ): DescribeFHIRDatastoreResponse =
      DescribeFHIRDatastoreResponse
        .builder
        .ifSome(datastoreProperties)(_.datastoreProperties(_))
        .build

    def describeFHIRExportJobRequest(
      datastoreId: Option[String] = None,
      jobId: Option[String] = None
    ): DescribeFHIRExportJobRequest =
      DescribeFHIRExportJobRequest
        .builder
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeFHIRExportJobResponse(
      exportJobProperties: Option[ExportJobProperties] = None
    ): DescribeFHIRExportJobResponse =
      DescribeFHIRExportJobResponse
        .builder
        .ifSome(exportJobProperties)(_.exportJobProperties(_))
        .build

    def describeFHIRImportJobRequest(
      datastoreId: Option[String] = None,
      jobId: Option[String] = None
    ): DescribeFHIRImportJobRequest =
      DescribeFHIRImportJobRequest
        .builder
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeFHIRImportJobResponse(
      importJobProperties: Option[ImportJobProperties] = None
    ): DescribeFHIRImportJobResponse =
      DescribeFHIRImportJobResponse
        .builder
        .ifSome(importJobProperties)(_.importJobProperties(_))
        .build

    def exportJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      datastoreId: Option[String] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      message: Option[String] = None
    ): ExportJobProperties =
      ExportJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(message)(_.message(_))
        .build

    def importJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      datastoreId: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      message: Option[String] = None
    ): ImportJobProperties =
      ImportJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(message)(_.message(_))
        .build

    def inputDataConfig(
      s3Uri: Option[String] = None
    ): InputDataConfig =
      InputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listFHIRDatastoresRequest(
      filter: Option[DatastoreFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFHIRDatastoresRequest =
      ListFHIRDatastoresRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFHIRDatastoresResponse(
      datastorePropertiesList: Option[List[DatastoreProperties]] = None,
      nextToken: Option[String] = None
    ): ListFHIRDatastoresResponse =
      ListFHIRDatastoresResponse
        .builder
        .ifSome(datastorePropertiesList)(_.datastorePropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def outputDataConfig(
      s3Uri: Option[String] = None
    ): OutputDataConfig =
      OutputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def preloadDataConfig(
      preloadDataType: Option[String] = None
    ): PreloadDataConfig =
      PreloadDataConfig
        .builder
        .ifSome(preloadDataType)(_.preloadDataType(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startFHIRExportJobRequest(
      jobName: Option[String] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      datastoreId: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      clientToken: Option[String] = None
    ): StartFHIRExportJobRequest =
      StartFHIRExportJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startFHIRExportJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None,
      datastoreId: Option[String] = None
    ): StartFHIRExportJobResponse =
      StartFHIRExportJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(datastoreId)(_.datastoreId(_))
        .build

    def startFHIRImportJobRequest(
      jobName: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      datastoreId: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      clientToken: Option[String] = None
    ): StartFHIRImportJobRequest =
      StartFHIRImportJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(datastoreId)(_.datastoreId(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startFHIRImportJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None,
      datastoreId: Option[String] = None
    ): StartFHIRImportJobResponse =
      StartFHIRImportJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(datastoreId)(_.datastoreId(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
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
