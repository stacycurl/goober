package goober.hi

import goober.free.translate.TranslateIO
import software.amazon.awssdk.services.translate.model._


object translate {
  import goober.free.{translate ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def appliedTerminology(
      name: Option[String] = None,
      terms: Option[List[Term]] = None
    ): AppliedTerminology =
      AppliedTerminology
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(terms)(_.terms(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
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

    def createParallelDataRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      parallelDataConfig: Option[ParallelDataConfig] = None,
      encryptionKey: Option[EncryptionKey] = None,
      clientToken: Option[String] = None
    ): CreateParallelDataRequest =
      CreateParallelDataRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(parallelDataConfig)(_.parallelDataConfig(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createParallelDataResponse(
      name: Option[String] = None,
      status: Option[String] = None
    ): CreateParallelDataResponse =
      CreateParallelDataResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteParallelDataRequest(
      name: Option[String] = None
    ): DeleteParallelDataRequest =
      DeleteParallelDataRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteParallelDataResponse(
      name: Option[String] = None,
      status: Option[String] = None
    ): DeleteParallelDataResponse =
      DeleteParallelDataResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteTerminologyRequest(
      name: Option[String] = None
    ): DeleteTerminologyRequest =
      DeleteTerminologyRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeTextTranslationJobRequest(
      jobId: Option[String] = None
    ): DescribeTextTranslationJobRequest =
      DescribeTextTranslationJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeTextTranslationJobResponse(
      textTranslationJobProperties: Option[TextTranslationJobProperties] = None
    ): DescribeTextTranslationJobResponse =
      DescribeTextTranslationJobResponse
        .builder
        .ifSome(textTranslationJobProperties)(_.textTranslationJobProperties(_))
        .build

    def detectedLanguageLowConfidenceException(
      message: Option[String] = None,
      detectedLanguageCode: Option[String] = None
    ): DetectedLanguageLowConfidenceException =
      DetectedLanguageLowConfidenceException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(detectedLanguageCode)(_.detectedLanguageCode(_))
        .build

    def encryptionKey(
      `type`: Option[String] = None,
      id: Option[String] = None
    ): EncryptionKey =
      EncryptionKey
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .build

    def getParallelDataRequest(
      name: Option[String] = None
    ): GetParallelDataRequest =
      GetParallelDataRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getParallelDataResponse(
      parallelDataProperties: Option[ParallelDataProperties] = None,
      dataLocation: Option[ParallelDataDataLocation] = None,
      auxiliaryDataLocation: Option[ParallelDataDataLocation] = None,
      latestUpdateAttemptAuxiliaryDataLocation: Option[ParallelDataDataLocation] = None
    ): GetParallelDataResponse =
      GetParallelDataResponse
        .builder
        .ifSome(parallelDataProperties)(_.parallelDataProperties(_))
        .ifSome(dataLocation)(_.dataLocation(_))
        .ifSome(auxiliaryDataLocation)(_.auxiliaryDataLocation(_))
        .ifSome(latestUpdateAttemptAuxiliaryDataLocation)(_.latestUpdateAttemptAuxiliaryDataLocation(_))
        .build

    def getTerminologyRequest(
      name: Option[String] = None,
      terminologyDataFormat: Option[String] = None
    ): GetTerminologyRequest =
      GetTerminologyRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(terminologyDataFormat)(_.terminologyDataFormat(_))
        .build

    def getTerminologyResponse(
      terminologyProperties: Option[TerminologyProperties] = None,
      terminologyDataLocation: Option[TerminologyDataLocation] = None
    ): GetTerminologyResponse =
      GetTerminologyResponse
        .builder
        .ifSome(terminologyProperties)(_.terminologyProperties(_))
        .ifSome(terminologyDataLocation)(_.terminologyDataLocation(_))
        .build

    def importTerminologyRequest(
      name: Option[String] = None,
      mergeStrategy: Option[String] = None,
      description: Option[String] = None,
      terminologyData: Option[TerminologyData] = None,
      encryptionKey: Option[EncryptionKey] = None
    ): ImportTerminologyRequest =
      ImportTerminologyRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(mergeStrategy)(_.mergeStrategy(_))
        .ifSome(description)(_.description(_))
        .ifSome(terminologyData)(_.terminologyData(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .build

    def importTerminologyResponse(
      terminologyProperties: Option[TerminologyProperties] = None
    ): ImportTerminologyResponse =
      ImportTerminologyResponse
        .builder
        .ifSome(terminologyProperties)(_.terminologyProperties(_))
        .build

    def inputDataConfig(
      s3Uri: Option[String] = None,
      contentType: Option[String] = None
    ): InputDataConfig =
      InputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFilterException(
      message: Option[String] = None
    ): InvalidFilterException =
      InvalidFilterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterValueException(
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jobDetails(
      translatedDocumentsCount: Option[Int] = None,
      documentsWithErrorsCount: Option[Int] = None,
      inputDocumentsCount: Option[Int] = None
    ): JobDetails =
      JobDetails
        .builder
        .ifSome(translatedDocumentsCount)(_.translatedDocumentsCount(_))
        .ifSome(documentsWithErrorsCount)(_.documentsWithErrorsCount(_))
        .ifSome(inputDocumentsCount)(_.inputDocumentsCount(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listParallelDataRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListParallelDataRequest =
      ListParallelDataRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listParallelDataResponse(
      parallelDataPropertiesList: Option[List[ParallelDataProperties]] = None,
      nextToken: Option[String] = None
    ): ListParallelDataResponse =
      ListParallelDataResponse
        .builder
        .ifSome(parallelDataPropertiesList)(_.parallelDataPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTerminologiesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTerminologiesRequest =
      ListTerminologiesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTerminologiesResponse(
      terminologyPropertiesList: Option[List[TerminologyProperties]] = None,
      nextToken: Option[String] = None
    ): ListTerminologiesResponse =
      ListTerminologiesResponse
        .builder
        .ifSome(terminologyPropertiesList)(_.terminologyPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTextTranslationJobsRequest(
      filter: Option[TextTranslationJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTextTranslationJobsRequest =
      ListTextTranslationJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTextTranslationJobsResponse(
      textTranslationJobPropertiesList: Option[List[TextTranslationJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListTextTranslationJobsResponse =
      ListTextTranslationJobsResponse
        .builder
        .ifSome(textTranslationJobPropertiesList)(_.textTranslationJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def outputDataConfig(
      s3Uri: Option[String] = None
    ): OutputDataConfig =
      OutputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def parallelDataConfig(
      s3Uri: Option[String] = None,
      format: Option[String] = None
    ): ParallelDataConfig =
      ParallelDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(format)(_.format(_))
        .build

    def parallelDataDataLocation(
      repositoryType: Option[String] = None,
      location: Option[String] = None
    ): ParallelDataDataLocation =
      ParallelDataDataLocation
        .builder
        .ifSome(repositoryType)(_.repositoryType(_))
        .ifSome(location)(_.location(_))
        .build

    def parallelDataProperties(
      name: Option[String] = None,
      arn: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      sourceLanguageCode: Option[String] = None,
      targetLanguageCodes: Option[List[LanguageCodeString]] = None,
      parallelDataConfig: Option[ParallelDataConfig] = None,
      message: Option[String] = None,
      importedDataSize: Option[Long] = None,
      importedRecordCount: Option[Long] = None,
      failedRecordCount: Option[Long] = None,
      skippedRecordCount: Option[Long] = None,
      encryptionKey: Option[EncryptionKey] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      latestUpdateAttemptStatus: Option[String] = None,
      latestUpdateAttemptAt: Option[Timestamp] = None
    ): ParallelDataProperties =
      ParallelDataProperties
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(sourceLanguageCode)(_.sourceLanguageCode(_))
        .ifSome(targetLanguageCodes)(_.targetLanguageCodes(_))
        .ifSome(parallelDataConfig)(_.parallelDataConfig(_))
        .ifSome(message)(_.message(_))
        .ifSome(importedDataSize)(_.importedDataSize(_))
        .ifSome(importedRecordCount)(_.importedRecordCount(_))
        .ifSome(failedRecordCount)(_.failedRecordCount(_))
        .ifSome(skippedRecordCount)(_.skippedRecordCount(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(latestUpdateAttemptStatus)(_.latestUpdateAttemptStatus(_))
        .ifSome(latestUpdateAttemptAt)(_.latestUpdateAttemptAt(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startTextTranslationJobRequest(
      jobName: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      sourceLanguageCode: Option[String] = None,
      targetLanguageCodes: Option[List[LanguageCodeString]] = None,
      terminologyNames: Option[List[ResourceName]] = None,
      parallelDataNames: Option[List[ResourceName]] = None,
      clientToken: Option[String] = None
    ): StartTextTranslationJobRequest =
      StartTextTranslationJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(sourceLanguageCode)(_.sourceLanguageCode(_))
        .ifSome(targetLanguageCodes)(_.targetLanguageCodes(_))
        .ifSome(terminologyNames)(_.terminologyNames(_))
        .ifSome(parallelDataNames)(_.parallelDataNames(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startTextTranslationJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartTextTranslationJobResponse =
      StartTextTranslationJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopTextTranslationJobRequest(
      jobId: Option[String] = None
    ): StopTextTranslationJobRequest =
      StopTextTranslationJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopTextTranslationJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StopTextTranslationJobResponse =
      StopTextTranslationJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def term(
      sourceText: Option[String] = None,
      targetText: Option[String] = None
    ): Term =
      Term
        .builder
        .ifSome(sourceText)(_.sourceText(_))
        .ifSome(targetText)(_.targetText(_))
        .build

    def terminologyData(
      file: Option[TerminologyFile] = None,
      format: Option[String] = None
    ): TerminologyData =
      TerminologyData
        .builder
        .ifSome(file)(_.file(_))
        .ifSome(format)(_.format(_))
        .build

    def terminologyDataLocation(
      repositoryType: Option[String] = None,
      location: Option[String] = None
    ): TerminologyDataLocation =
      TerminologyDataLocation
        .builder
        .ifSome(repositoryType)(_.repositoryType(_))
        .ifSome(location)(_.location(_))
        .build

    def terminologyProperties(
      name: Option[String] = None,
      description: Option[String] = None,
      arn: Option[String] = None,
      sourceLanguageCode: Option[String] = None,
      targetLanguageCodes: Option[List[LanguageCodeString]] = None,
      encryptionKey: Option[EncryptionKey] = None,
      sizeBytes: Option[Int] = None,
      termCount: Option[Int] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None
    ): TerminologyProperties =
      TerminologyProperties
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(sourceLanguageCode)(_.sourceLanguageCode(_))
        .ifSome(targetLanguageCodes)(_.targetLanguageCodes(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(sizeBytes)(_.sizeBytes(_))
        .ifSome(termCount)(_.termCount(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def textSizeLimitExceededException(
      message: Option[String] = None
    ): TextSizeLimitExceededException =
      TextSizeLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def textTranslationJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submittedBeforeTime: Option[Timestamp] = None,
      submittedAfterTime: Option[Timestamp] = None
    ): TextTranslationJobFilter =
      TextTranslationJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submittedBeforeTime)(_.submittedBeforeTime(_))
        .ifSome(submittedAfterTime)(_.submittedAfterTime(_))
        .build

    def textTranslationJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      jobDetails: Option[JobDetails] = None,
      sourceLanguageCode: Option[String] = None,
      targetLanguageCodes: Option[List[LanguageCodeString]] = None,
      terminologyNames: Option[List[ResourceName]] = None,
      parallelDataNames: Option[List[ResourceName]] = None,
      message: Option[String] = None,
      submittedTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None
    ): TextTranslationJobProperties =
      TextTranslationJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(jobDetails)(_.jobDetails(_))
        .ifSome(sourceLanguageCode)(_.sourceLanguageCode(_))
        .ifSome(targetLanguageCodes)(_.targetLanguageCodes(_))
        .ifSome(terminologyNames)(_.terminologyNames(_))
        .ifSome(parallelDataNames)(_.parallelDataNames(_))
        .ifSome(message)(_.message(_))
        .ifSome(submittedTime)(_.submittedTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def translateTextRequest(
      text: Option[String] = None,
      terminologyNames: Option[List[ResourceName]] = None,
      sourceLanguageCode: Option[String] = None,
      targetLanguageCode: Option[String] = None
    ): TranslateTextRequest =
      TranslateTextRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(terminologyNames)(_.terminologyNames(_))
        .ifSome(sourceLanguageCode)(_.sourceLanguageCode(_))
        .ifSome(targetLanguageCode)(_.targetLanguageCode(_))
        .build

    def translateTextResponse(
      translatedText: Option[String] = None,
      sourceLanguageCode: Option[String] = None,
      targetLanguageCode: Option[String] = None,
      appliedTerminologies: Option[List[AppliedTerminology]] = None
    ): TranslateTextResponse =
      TranslateTextResponse
        .builder
        .ifSome(translatedText)(_.translatedText(_))
        .ifSome(sourceLanguageCode)(_.sourceLanguageCode(_))
        .ifSome(targetLanguageCode)(_.targetLanguageCode(_))
        .ifSome(appliedTerminologies)(_.appliedTerminologies(_))
        .build

    def unsupportedLanguagePairException(
      message: Option[String] = None,
      sourceLanguageCode: Option[String] = None,
      targetLanguageCode: Option[String] = None
    ): UnsupportedLanguagePairException =
      UnsupportedLanguagePairException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(sourceLanguageCode)(_.sourceLanguageCode(_))
        .ifSome(targetLanguageCode)(_.targetLanguageCode(_))
        .build

    def updateParallelDataRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      parallelDataConfig: Option[ParallelDataConfig] = None,
      clientToken: Option[String] = None
    ): UpdateParallelDataRequest =
      UpdateParallelDataRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(parallelDataConfig)(_.parallelDataConfig(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateParallelDataResponse(
      name: Option[String] = None,
      status: Option[String] = None,
      latestUpdateAttemptStatus: Option[String] = None,
      latestUpdateAttemptAt: Option[Timestamp] = None
    ): UpdateParallelDataResponse =
      UpdateParallelDataResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(latestUpdateAttemptStatus)(_.latestUpdateAttemptStatus(_))
        .ifSome(latestUpdateAttemptAt)(_.latestUpdateAttemptAt(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
