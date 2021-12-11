package goober.hi

import goober.free.transcribe.TranscribeIO
import software.amazon.awssdk.services.transcribe.model._


object transcribe {
  import goober.free.{transcribe ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
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

    def contentRedaction(
      redactionType: Option[String] = None,
      redactionOutput: Option[String] = None
    ): ContentRedaction =
      ContentRedaction
        .builder
        .ifSome(redactionType)(_.redactionType(_))
        .ifSome(redactionOutput)(_.redactionOutput(_))
        .build

    def createLanguageModelRequest(
      languageCode: Option[String] = None,
      baseModelName: Option[String] = None,
      modelName: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None
    ): CreateLanguageModelRequest =
      CreateLanguageModelRequest
        .builder
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(baseModelName)(_.baseModelName(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .build

    def createLanguageModelResponse(
      languageCode: Option[String] = None,
      baseModelName: Option[String] = None,
      modelName: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      modelStatus: Option[String] = None
    ): CreateLanguageModelResponse =
      CreateLanguageModelResponse
        .builder
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(baseModelName)(_.baseModelName(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(modelStatus)(_.modelStatus(_))
        .build

    def createMedicalVocabularyRequest(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      vocabularyFileUri: Option[String] = None
    ): CreateMedicalVocabularyRequest =
      CreateMedicalVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(vocabularyFileUri)(_.vocabularyFileUri(_))
        .build

    def createMedicalVocabularyResponse(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      vocabularyState: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      failureReason: Option[String] = None
    ): CreateMedicalVocabularyResponse =
      CreateMedicalVocabularyResponse
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(vocabularyState)(_.vocabularyState(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def createVocabularyFilterRequest(
      vocabularyFilterName: Option[String] = None,
      languageCode: Option[String] = None,
      words: Option[List[Word]] = None,
      vocabularyFilterFileUri: Option[String] = None
    ): CreateVocabularyFilterRequest =
      CreateVocabularyFilterRequest
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(words)(_.words(_))
        .ifSome(vocabularyFilterFileUri)(_.vocabularyFilterFileUri(_))
        .build

    def createVocabularyFilterResponse(
      vocabularyFilterName: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None
    ): CreateVocabularyFilterResponse =
      CreateVocabularyFilterResponse
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def createVocabularyRequest(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      phrases: Option[List[Phrase]] = None,
      vocabularyFileUri: Option[String] = None
    ): CreateVocabularyRequest =
      CreateVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(phrases)(_.phrases(_))
        .ifSome(vocabularyFileUri)(_.vocabularyFileUri(_))
        .build

    def createVocabularyResponse(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      vocabularyState: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      failureReason: Option[String] = None
    ): CreateVocabularyResponse =
      CreateVocabularyResponse
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(vocabularyState)(_.vocabularyState(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def deleteLanguageModelRequest(
      modelName: Option[String] = None
    ): DeleteLanguageModelRequest =
      DeleteLanguageModelRequest
        .builder
        .ifSome(modelName)(_.modelName(_))
        .build

    def deleteMedicalTranscriptionJobRequest(
      medicalTranscriptionJobName: Option[String] = None
    ): DeleteMedicalTranscriptionJobRequest =
      DeleteMedicalTranscriptionJobRequest
        .builder
        .ifSome(medicalTranscriptionJobName)(_.medicalTranscriptionJobName(_))
        .build

    def deleteMedicalVocabularyRequest(
      vocabularyName: Option[String] = None
    ): DeleteMedicalVocabularyRequest =
      DeleteMedicalVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .build

    def deleteTranscriptionJobRequest(
      transcriptionJobName: Option[String] = None
    ): DeleteTranscriptionJobRequest =
      DeleteTranscriptionJobRequest
        .builder
        .ifSome(transcriptionJobName)(_.transcriptionJobName(_))
        .build

    def deleteVocabularyFilterRequest(
      vocabularyFilterName: Option[String] = None
    ): DeleteVocabularyFilterRequest =
      DeleteVocabularyFilterRequest
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .build

    def deleteVocabularyRequest(
      vocabularyName: Option[String] = None
    ): DeleteVocabularyRequest =
      DeleteVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .build

    def describeLanguageModelRequest(
      modelName: Option[String] = None
    ): DescribeLanguageModelRequest =
      DescribeLanguageModelRequest
        .builder
        .ifSome(modelName)(_.modelName(_))
        .build

    def describeLanguageModelResponse(
      languageModel: Option[LanguageModel] = None
    ): DescribeLanguageModelResponse =
      DescribeLanguageModelResponse
        .builder
        .ifSome(languageModel)(_.languageModel(_))
        .build

    def getMedicalTranscriptionJobRequest(
      medicalTranscriptionJobName: Option[String] = None
    ): GetMedicalTranscriptionJobRequest =
      GetMedicalTranscriptionJobRequest
        .builder
        .ifSome(medicalTranscriptionJobName)(_.medicalTranscriptionJobName(_))
        .build

    def getMedicalTranscriptionJobResponse(
      medicalTranscriptionJob: Option[MedicalTranscriptionJob] = None
    ): GetMedicalTranscriptionJobResponse =
      GetMedicalTranscriptionJobResponse
        .builder
        .ifSome(medicalTranscriptionJob)(_.medicalTranscriptionJob(_))
        .build

    def getMedicalVocabularyRequest(
      vocabularyName: Option[String] = None
    ): GetMedicalVocabularyRequest =
      GetMedicalVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .build

    def getMedicalVocabularyResponse(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      vocabularyState: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      failureReason: Option[String] = None,
      downloadUri: Option[String] = None
    ): GetMedicalVocabularyResponse =
      GetMedicalVocabularyResponse
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(vocabularyState)(_.vocabularyState(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(downloadUri)(_.downloadUri(_))
        .build

    def getTranscriptionJobRequest(
      transcriptionJobName: Option[String] = None
    ): GetTranscriptionJobRequest =
      GetTranscriptionJobRequest
        .builder
        .ifSome(transcriptionJobName)(_.transcriptionJobName(_))
        .build

    def getTranscriptionJobResponse(
      transcriptionJob: Option[TranscriptionJob] = None
    ): GetTranscriptionJobResponse =
      GetTranscriptionJobResponse
        .builder
        .ifSome(transcriptionJob)(_.transcriptionJob(_))
        .build

    def getVocabularyFilterRequest(
      vocabularyFilterName: Option[String] = None
    ): GetVocabularyFilterRequest =
      GetVocabularyFilterRequest
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .build

    def getVocabularyFilterResponse(
      vocabularyFilterName: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      downloadUri: Option[String] = None
    ): GetVocabularyFilterResponse =
      GetVocabularyFilterResponse
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(downloadUri)(_.downloadUri(_))
        .build

    def getVocabularyRequest(
      vocabularyName: Option[String] = None
    ): GetVocabularyRequest =
      GetVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .build

    def getVocabularyResponse(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      vocabularyState: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      failureReason: Option[String] = None,
      downloadUri: Option[String] = None
    ): GetVocabularyResponse =
      GetVocabularyResponse
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(vocabularyState)(_.vocabularyState(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(downloadUri)(_.downloadUri(_))
        .build

    def inputDataConfig(
      s3Uri: Option[String] = None,
      tuningDataS3Uri: Option[String] = None,
      dataAccessRoleArn: Option[String] = None
    ): InputDataConfig =
      InputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(tuningDataS3Uri)(_.tuningDataS3Uri(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jobExecutionSettings(
      allowDeferredExecution: Option[Boolean] = None,
      dataAccessRoleArn: Option[String] = None
    ): JobExecutionSettings =
      JobExecutionSettings
        .builder
        .ifSome(allowDeferredExecution)(_.allowDeferredExecution(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .build

    def languageModel(
      modelName: Option[String] = None,
      createTime: Option[DateTime] = None,
      lastModifiedTime: Option[DateTime] = None,
      languageCode: Option[String] = None,
      baseModelName: Option[String] = None,
      modelStatus: Option[String] = None,
      upgradeAvailability: Option[Boolean] = None,
      failureReason: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None
    ): LanguageModel =
      LanguageModel
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(baseModelName)(_.baseModelName(_))
        .ifSome(modelStatus)(_.modelStatus(_))
        .ifSome(upgradeAvailability)(_.upgradeAvailability(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listLanguageModelsRequest(
      statusEquals: Option[String] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLanguageModelsRequest =
      ListLanguageModelsRequest
        .builder
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLanguageModelsResponse(
      nextToken: Option[String] = None,
      models: Option[List[LanguageModel]] = None
    ): ListLanguageModelsResponse =
      ListLanguageModelsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(models)(_.models(_))
        .build

    def listMedicalTranscriptionJobsRequest(
      status: Option[String] = None,
      jobNameContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMedicalTranscriptionJobsRequest =
      ListMedicalTranscriptionJobsRequest
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(jobNameContains)(_.jobNameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMedicalTranscriptionJobsResponse(
      status: Option[String] = None,
      nextToken: Option[String] = None,
      medicalTranscriptionJobSummaries: Option[List[MedicalTranscriptionJobSummary]] = None
    ): ListMedicalTranscriptionJobsResponse =
      ListMedicalTranscriptionJobsResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(medicalTranscriptionJobSummaries)(_.medicalTranscriptionJobSummaries(_))
        .build

    def listMedicalVocabulariesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      stateEquals: Option[String] = None,
      nameContains: Option[String] = None
    ): ListMedicalVocabulariesRequest =
      ListMedicalVocabulariesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(stateEquals)(_.stateEquals(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def listMedicalVocabulariesResponse(
      status: Option[String] = None,
      nextToken: Option[String] = None,
      vocabularies: Option[List[VocabularyInfo]] = None
    ): ListMedicalVocabulariesResponse =
      ListMedicalVocabulariesResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(vocabularies)(_.vocabularies(_))
        .build

    def listTranscriptionJobsRequest(
      status: Option[String] = None,
      jobNameContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTranscriptionJobsRequest =
      ListTranscriptionJobsRequest
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(jobNameContains)(_.jobNameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTranscriptionJobsResponse(
      status: Option[String] = None,
      nextToken: Option[String] = None,
      transcriptionJobSummaries: Option[List[TranscriptionJobSummary]] = None
    ): ListTranscriptionJobsResponse =
      ListTranscriptionJobsResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(transcriptionJobSummaries)(_.transcriptionJobSummaries(_))
        .build

    def listVocabulariesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      stateEquals: Option[String] = None,
      nameContains: Option[String] = None
    ): ListVocabulariesRequest =
      ListVocabulariesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(stateEquals)(_.stateEquals(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def listVocabulariesResponse(
      status: Option[String] = None,
      nextToken: Option[String] = None,
      vocabularies: Option[List[VocabularyInfo]] = None
    ): ListVocabulariesResponse =
      ListVocabulariesResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(vocabularies)(_.vocabularies(_))
        .build

    def listVocabularyFiltersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None
    ): ListVocabularyFiltersRequest =
      ListVocabularyFiltersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .build

    def listVocabularyFiltersResponse(
      nextToken: Option[String] = None,
      vocabularyFilters: Option[List[VocabularyFilterInfo]] = None
    ): ListVocabularyFiltersResponse =
      ListVocabularyFiltersResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(vocabularyFilters)(_.vocabularyFilters(_))
        .build

    def media(
      mediaFileUri: Option[String] = None
    ): Media =
      Media
        .builder
        .ifSome(mediaFileUri)(_.mediaFileUri(_))
        .build

    def medicalTranscript(
      transcriptFileUri: Option[String] = None
    ): MedicalTranscript =
      MedicalTranscript
        .builder
        .ifSome(transcriptFileUri)(_.transcriptFileUri(_))
        .build

    def medicalTranscriptionJob(
      medicalTranscriptionJobName: Option[String] = None,
      transcriptionJobStatus: Option[String] = None,
      languageCode: Option[String] = None,
      mediaSampleRateHertz: Option[Int] = None,
      mediaFormat: Option[String] = None,
      media: Option[Media] = None,
      transcript: Option[MedicalTranscript] = None,
      startTime: Option[DateTime] = None,
      creationTime: Option[DateTime] = None,
      completionTime: Option[DateTime] = None,
      failureReason: Option[String] = None,
      settings: Option[MedicalTranscriptionSetting] = None,
      contentIdentificationType: Option[String] = None,
      specialty: Option[String] = None,
      `type`: Option[String] = None
    ): MedicalTranscriptionJob =
      MedicalTranscriptionJob
        .builder
        .ifSome(medicalTranscriptionJobName)(_.medicalTranscriptionJobName(_))
        .ifSome(transcriptionJobStatus)(_.transcriptionJobStatus(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(mediaSampleRateHertz)(_.mediaSampleRateHertz(_))
        .ifSome(mediaFormat)(_.mediaFormat(_))
        .ifSome(media)(_.media(_))
        .ifSome(transcript)(_.transcript(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(completionTime)(_.completionTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(contentIdentificationType)(_.contentIdentificationType(_))
        .ifSome(specialty)(_.specialty(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def medicalTranscriptionJobSummary(
      medicalTranscriptionJobName: Option[String] = None,
      creationTime: Option[DateTime] = None,
      startTime: Option[DateTime] = None,
      completionTime: Option[DateTime] = None,
      languageCode: Option[String] = None,
      transcriptionJobStatus: Option[String] = None,
      failureReason: Option[String] = None,
      outputLocationType: Option[String] = None,
      specialty: Option[String] = None,
      contentIdentificationType: Option[String] = None,
      `type`: Option[String] = None
    ): MedicalTranscriptionJobSummary =
      MedicalTranscriptionJobSummary
        .builder
        .ifSome(medicalTranscriptionJobName)(_.medicalTranscriptionJobName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(completionTime)(_.completionTime(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(transcriptionJobStatus)(_.transcriptionJobStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(outputLocationType)(_.outputLocationType(_))
        .ifSome(specialty)(_.specialty(_))
        .ifSome(contentIdentificationType)(_.contentIdentificationType(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def medicalTranscriptionSetting(
      showSpeakerLabels: Option[Boolean] = None,
      maxSpeakerLabels: Option[Int] = None,
      channelIdentification: Option[Boolean] = None,
      showAlternatives: Option[Boolean] = None,
      maxAlternatives: Option[Int] = None,
      vocabularyName: Option[String] = None
    ): MedicalTranscriptionSetting =
      MedicalTranscriptionSetting
        .builder
        .ifSome(showSpeakerLabels)(_.showSpeakerLabels(_))
        .ifSome(maxSpeakerLabels)(_.maxSpeakerLabels(_))
        .ifSome(channelIdentification)(_.channelIdentification(_))
        .ifSome(showAlternatives)(_.showAlternatives(_))
        .ifSome(maxAlternatives)(_.maxAlternatives(_))
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .build

    def modelSettings(
      languageModelName: Option[String] = None
    ): ModelSettings =
      ModelSettings
        .builder
        .ifSome(languageModelName)(_.languageModelName(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def settings(
      vocabularyName: Option[String] = None,
      showSpeakerLabels: Option[Boolean] = None,
      maxSpeakerLabels: Option[Int] = None,
      channelIdentification: Option[Boolean] = None,
      showAlternatives: Option[Boolean] = None,
      maxAlternatives: Option[Int] = None,
      vocabularyFilterName: Option[String] = None,
      vocabularyFilterMethod: Option[String] = None
    ): Settings =
      Settings
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(showSpeakerLabels)(_.showSpeakerLabels(_))
        .ifSome(maxSpeakerLabels)(_.maxSpeakerLabels(_))
        .ifSome(channelIdentification)(_.channelIdentification(_))
        .ifSome(showAlternatives)(_.showAlternatives(_))
        .ifSome(maxAlternatives)(_.maxAlternatives(_))
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .ifSome(vocabularyFilterMethod)(_.vocabularyFilterMethod(_))
        .build

    def startMedicalTranscriptionJobRequest(
      medicalTranscriptionJobName: Option[String] = None,
      languageCode: Option[String] = None,
      mediaSampleRateHertz: Option[Int] = None,
      mediaFormat: Option[String] = None,
      media: Option[Media] = None,
      outputBucketName: Option[String] = None,
      outputKey: Option[String] = None,
      outputEncryptionKMSKeyId: Option[String] = None,
      settings: Option[MedicalTranscriptionSetting] = None,
      contentIdentificationType: Option[String] = None,
      specialty: Option[String] = None,
      `type`: Option[String] = None
    ): StartMedicalTranscriptionJobRequest =
      StartMedicalTranscriptionJobRequest
        .builder
        .ifSome(medicalTranscriptionJobName)(_.medicalTranscriptionJobName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(mediaSampleRateHertz)(_.mediaSampleRateHertz(_))
        .ifSome(mediaFormat)(_.mediaFormat(_))
        .ifSome(media)(_.media(_))
        .ifSome(outputBucketName)(_.outputBucketName(_))
        .ifSome(outputKey)(_.outputKey(_))
        .ifSome(outputEncryptionKMSKeyId)(_.outputEncryptionKMSKeyId(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(contentIdentificationType)(_.contentIdentificationType(_))
        .ifSome(specialty)(_.specialty(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def startMedicalTranscriptionJobResponse(
      medicalTranscriptionJob: Option[MedicalTranscriptionJob] = None
    ): StartMedicalTranscriptionJobResponse =
      StartMedicalTranscriptionJobResponse
        .builder
        .ifSome(medicalTranscriptionJob)(_.medicalTranscriptionJob(_))
        .build

    def startTranscriptionJobRequest(
      transcriptionJobName: Option[String] = None,
      languageCode: Option[String] = None,
      mediaSampleRateHertz: Option[Int] = None,
      mediaFormat: Option[String] = None,
      media: Option[Media] = None,
      outputBucketName: Option[String] = None,
      outputKey: Option[String] = None,
      outputEncryptionKMSKeyId: Option[String] = None,
      settings: Option[Settings] = None,
      modelSettings: Option[ModelSettings] = None,
      jobExecutionSettings: Option[JobExecutionSettings] = None,
      contentRedaction: Option[ContentRedaction] = None,
      identifyLanguage: Option[Boolean] = None,
      languageOptions: Option[List[LanguageCode]] = None
    ): StartTranscriptionJobRequest =
      StartTranscriptionJobRequest
        .builder
        .ifSome(transcriptionJobName)(_.transcriptionJobName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(mediaSampleRateHertz)(_.mediaSampleRateHertz(_))
        .ifSome(mediaFormat)(_.mediaFormat(_))
        .ifSome(media)(_.media(_))
        .ifSome(outputBucketName)(_.outputBucketName(_))
        .ifSome(outputKey)(_.outputKey(_))
        .ifSome(outputEncryptionKMSKeyId)(_.outputEncryptionKMSKeyId(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(modelSettings)(_.modelSettings(_))
        .ifSome(jobExecutionSettings)(_.jobExecutionSettings(_))
        .ifSome(contentRedaction)(_.contentRedaction(_))
        .ifSome(identifyLanguage)(_.identifyLanguage(_))
        .ifSome(languageOptions)(_.languageOptions(_))
        .build

    def startTranscriptionJobResponse(
      transcriptionJob: Option[TranscriptionJob] = None
    ): StartTranscriptionJobResponse =
      StartTranscriptionJobResponse
        .builder
        .ifSome(transcriptionJob)(_.transcriptionJob(_))
        .build

    def transcript(
      transcriptFileUri: Option[String] = None,
      redactedTranscriptFileUri: Option[String] = None
    ): Transcript =
      Transcript
        .builder
        .ifSome(transcriptFileUri)(_.transcriptFileUri(_))
        .ifSome(redactedTranscriptFileUri)(_.redactedTranscriptFileUri(_))
        .build

    def transcriptionJob(
      transcriptionJobName: Option[String] = None,
      transcriptionJobStatus: Option[String] = None,
      languageCode: Option[String] = None,
      mediaSampleRateHertz: Option[Int] = None,
      mediaFormat: Option[String] = None,
      media: Option[Media] = None,
      transcript: Option[Transcript] = None,
      startTime: Option[DateTime] = None,
      creationTime: Option[DateTime] = None,
      completionTime: Option[DateTime] = None,
      failureReason: Option[String] = None,
      settings: Option[Settings] = None,
      modelSettings: Option[ModelSettings] = None,
      jobExecutionSettings: Option[JobExecutionSettings] = None,
      contentRedaction: Option[ContentRedaction] = None,
      identifyLanguage: Option[Boolean] = None,
      languageOptions: Option[List[LanguageCode]] = None,
      identifiedLanguageScore: Option[IdentifiedLanguageScore] = None
    ): TranscriptionJob =
      TranscriptionJob
        .builder
        .ifSome(transcriptionJobName)(_.transcriptionJobName(_))
        .ifSome(transcriptionJobStatus)(_.transcriptionJobStatus(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(mediaSampleRateHertz)(_.mediaSampleRateHertz(_))
        .ifSome(mediaFormat)(_.mediaFormat(_))
        .ifSome(media)(_.media(_))
        .ifSome(transcript)(_.transcript(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(completionTime)(_.completionTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(modelSettings)(_.modelSettings(_))
        .ifSome(jobExecutionSettings)(_.jobExecutionSettings(_))
        .ifSome(contentRedaction)(_.contentRedaction(_))
        .ifSome(identifyLanguage)(_.identifyLanguage(_))
        .ifSome(languageOptions)(_.languageOptions(_))
        .ifSome(identifiedLanguageScore)(_.identifiedLanguageScore(_))
        .build

    def transcriptionJobSummary(
      transcriptionJobName: Option[String] = None,
      creationTime: Option[DateTime] = None,
      startTime: Option[DateTime] = None,
      completionTime: Option[DateTime] = None,
      languageCode: Option[String] = None,
      transcriptionJobStatus: Option[String] = None,
      failureReason: Option[String] = None,
      outputLocationType: Option[String] = None,
      contentRedaction: Option[ContentRedaction] = None,
      modelSettings: Option[ModelSettings] = None,
      identifyLanguage: Option[Boolean] = None,
      identifiedLanguageScore: Option[IdentifiedLanguageScore] = None
    ): TranscriptionJobSummary =
      TranscriptionJobSummary
        .builder
        .ifSome(transcriptionJobName)(_.transcriptionJobName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(completionTime)(_.completionTime(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(transcriptionJobStatus)(_.transcriptionJobStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(outputLocationType)(_.outputLocationType(_))
        .ifSome(contentRedaction)(_.contentRedaction(_))
        .ifSome(modelSettings)(_.modelSettings(_))
        .ifSome(identifyLanguage)(_.identifyLanguage(_))
        .ifSome(identifiedLanguageScore)(_.identifiedLanguageScore(_))
        .build

    def updateMedicalVocabularyRequest(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      vocabularyFileUri: Option[String] = None
    ): UpdateMedicalVocabularyRequest =
      UpdateMedicalVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(vocabularyFileUri)(_.vocabularyFileUri(_))
        .build

    def updateMedicalVocabularyResponse(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      vocabularyState: Option[String] = None
    ): UpdateMedicalVocabularyResponse =
      UpdateMedicalVocabularyResponse
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(vocabularyState)(_.vocabularyState(_))
        .build

    def updateVocabularyFilterRequest(
      vocabularyFilterName: Option[String] = None,
      words: Option[List[Word]] = None,
      vocabularyFilterFileUri: Option[String] = None
    ): UpdateVocabularyFilterRequest =
      UpdateVocabularyFilterRequest
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .ifSome(words)(_.words(_))
        .ifSome(vocabularyFilterFileUri)(_.vocabularyFilterFileUri(_))
        .build

    def updateVocabularyFilterResponse(
      vocabularyFilterName: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None
    ): UpdateVocabularyFilterResponse =
      UpdateVocabularyFilterResponse
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def updateVocabularyRequest(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      phrases: Option[List[Phrase]] = None,
      vocabularyFileUri: Option[String] = None
    ): UpdateVocabularyRequest =
      UpdateVocabularyRequest
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(phrases)(_.phrases(_))
        .ifSome(vocabularyFileUri)(_.vocabularyFileUri(_))
        .build

    def updateVocabularyResponse(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      vocabularyState: Option[String] = None
    ): UpdateVocabularyResponse =
      UpdateVocabularyResponse
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(vocabularyState)(_.vocabularyState(_))
        .build

    def vocabularyFilterInfo(
      vocabularyFilterName: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None
    ): VocabularyFilterInfo =
      VocabularyFilterInfo
        .builder
        .ifSome(vocabularyFilterName)(_.vocabularyFilterName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def vocabularyInfo(
      vocabularyName: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      vocabularyState: Option[String] = None
    ): VocabularyInfo =
      VocabularyInfo
        .builder
        .ifSome(vocabularyName)(_.vocabularyName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(vocabularyState)(_.vocabularyState(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
