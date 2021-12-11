package goober.hi

import goober.free.comprehendmedical.ComprehendMedicalIO
import software.amazon.awssdk.services.comprehendmedical.model._


object comprehendmedical {
  import goober.free.{comprehendmedical ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def attribute(
      `type`: Option[String] = None,
      score: Option[Float] = None,
      relationshipScore: Option[Float] = None,
      relationshipType: Option[String] = None,
      id: Option[Int] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      text: Option[String] = None,
      category: Option[String] = None,
      traits: Option[List[Trait]] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(score)(_.score(_))
        .ifSome(relationshipScore)(_.relationshipScore(_))
        .ifSome(relationshipType)(_.relationshipType(_))
        .ifSome(id)(_.id(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(text)(_.text(_))
        .ifSome(category)(_.category(_))
        .ifSome(traits)(_.traits(_))
        .build

    def comprehendMedicalAsyncJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): ComprehendMedicalAsyncJobFilter =
      ComprehendMedicalAsyncJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def comprehendMedicalAsyncJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      expirationTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      languageCode: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      manifestFilePath: Option[String] = None,
      kMSKey: Option[String] = None,
      modelVersion: Option[String] = None
    ): ComprehendMedicalAsyncJobProperties =
      ComprehendMedicalAsyncJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(manifestFilePath)(_.manifestFilePath(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def describeEntitiesDetectionV2JobRequest(
      jobId: Option[String] = None
    ): DescribeEntitiesDetectionV2JobRequest =
      DescribeEntitiesDetectionV2JobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeEntitiesDetectionV2JobResponse(
      comprehendMedicalAsyncJobProperties: Option[ComprehendMedicalAsyncJobProperties] = None
    ): DescribeEntitiesDetectionV2JobResponse =
      DescribeEntitiesDetectionV2JobResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobProperties)(_.comprehendMedicalAsyncJobProperties(_))
        .build

    def describeICD10CMInferenceJobRequest(
      jobId: Option[String] = None
    ): DescribeICD10CMInferenceJobRequest =
      DescribeICD10CMInferenceJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeICD10CMInferenceJobResponse(
      comprehendMedicalAsyncJobProperties: Option[ComprehendMedicalAsyncJobProperties] = None
    ): DescribeICD10CMInferenceJobResponse =
      DescribeICD10CMInferenceJobResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobProperties)(_.comprehendMedicalAsyncJobProperties(_))
        .build

    def describePHIDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribePHIDetectionJobRequest =
      DescribePHIDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describePHIDetectionJobResponse(
      comprehendMedicalAsyncJobProperties: Option[ComprehendMedicalAsyncJobProperties] = None
    ): DescribePHIDetectionJobResponse =
      DescribePHIDetectionJobResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobProperties)(_.comprehendMedicalAsyncJobProperties(_))
        .build

    def describeRxNormInferenceJobRequest(
      jobId: Option[String] = None
    ): DescribeRxNormInferenceJobRequest =
      DescribeRxNormInferenceJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeRxNormInferenceJobResponse(
      comprehendMedicalAsyncJobProperties: Option[ComprehendMedicalAsyncJobProperties] = None
    ): DescribeRxNormInferenceJobResponse =
      DescribeRxNormInferenceJobResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobProperties)(_.comprehendMedicalAsyncJobProperties(_))
        .build

    def detectEntitiesRequest(
      text: Option[String] = None
    ): DetectEntitiesRequest =
      DetectEntitiesRequest
        .builder
        .ifSome(text)(_.text(_))
        .build

    def detectEntitiesResponse(
      entities: Option[List[Entity]] = None,
      unmappedAttributes: Option[List[UnmappedAttribute]] = None,
      paginationToken: Option[String] = None,
      modelVersion: Option[String] = None
    ): DetectEntitiesResponse =
      DetectEntitiesResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .ifSome(unmappedAttributes)(_.unmappedAttributes(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def detectEntitiesV2Request(
      text: Option[String] = None
    ): DetectEntitiesV2Request =
      DetectEntitiesV2Request
        .builder
        .ifSome(text)(_.text(_))
        .build

    def detectEntitiesV2Response(
      entities: Option[List[Entity]] = None,
      unmappedAttributes: Option[List[UnmappedAttribute]] = None,
      paginationToken: Option[String] = None,
      modelVersion: Option[String] = None
    ): DetectEntitiesV2Response =
      DetectEntitiesV2Response
        .builder
        .ifSome(entities)(_.entities(_))
        .ifSome(unmappedAttributes)(_.unmappedAttributes(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def detectPHIRequest(
      text: Option[String] = None
    ): DetectPHIRequest =
      DetectPHIRequest
        .builder
        .ifSome(text)(_.text(_))
        .build

    def detectPHIResponse(
      entities: Option[List[Entity]] = None,
      paginationToken: Option[String] = None,
      modelVersion: Option[String] = None
    ): DetectPHIResponse =
      DetectPHIResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def entity(
      id: Option[Int] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      score: Option[Float] = None,
      text: Option[String] = None,
      category: Option[String] = None,
      `type`: Option[String] = None,
      traits: Option[List[Trait]] = None,
      attributes: Option[List[Attribute]] = None
    ): Entity =
      Entity
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(score)(_.score(_))
        .ifSome(text)(_.text(_))
        .ifSome(category)(_.category(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(traits)(_.traits(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def iCD10CMAttribute(
      `type`: Option[String] = None,
      score: Option[Float] = None,
      relationshipScore: Option[Float] = None,
      id: Option[Int] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      text: Option[String] = None,
      traits: Option[List[ICD10CMTrait]] = None,
      category: Option[String] = None,
      relationshipType: Option[String] = None
    ): ICD10CMAttribute =
      ICD10CMAttribute
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(score)(_.score(_))
        .ifSome(relationshipScore)(_.relationshipScore(_))
        .ifSome(id)(_.id(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(text)(_.text(_))
        .ifSome(traits)(_.traits(_))
        .ifSome(category)(_.category(_))
        .ifSome(relationshipType)(_.relationshipType(_))
        .build

    def iCD10CMConcept(
      description: Option[String] = None,
      code: Option[String] = None,
      score: Option[Float] = None
    ): ICD10CMConcept =
      ICD10CMConcept
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(code)(_.code(_))
        .ifSome(score)(_.score(_))
        .build

    def iCD10CMEntity(
      id: Option[Int] = None,
      text: Option[String] = None,
      category: Option[String] = None,
      `type`: Option[String] = None,
      score: Option[Float] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      attributes: Option[List[ICD10CMAttribute]] = None,
      traits: Option[List[ICD10CMTrait]] = None,
      iCD10CMConcepts: Option[List[ICD10CMConcept]] = None
    ): ICD10CMEntity =
      ICD10CMEntity
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(text)(_.text(_))
        .ifSome(category)(_.category(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(score)(_.score(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(traits)(_.traits(_))
        .ifSome(iCD10CMConcepts)(_.iCD10CMConcepts(_))
        .build

    def iCD10CMTrait(
      name: Option[String] = None,
      score: Option[Float] = None
    ): ICD10CMTrait =
      ICD10CMTrait
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(score)(_.score(_))
        .build

    def inferICD10CMRequest(
      text: Option[String] = None
    ): InferICD10CMRequest =
      InferICD10CMRequest
        .builder
        .ifSome(text)(_.text(_))
        .build

    def inferICD10CMResponse(
      entities: Option[List[ICD10CMEntity]] = None,
      paginationToken: Option[String] = None,
      modelVersion: Option[String] = None
    ): InferICD10CMResponse =
      InferICD10CMResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def inferRxNormRequest(
      text: Option[String] = None
    ): InferRxNormRequest =
      InferRxNormRequest
        .builder
        .ifSome(text)(_.text(_))
        .build

    def inferRxNormResponse(
      entities: Option[List[RxNormEntity]] = None,
      paginationToken: Option[String] = None,
      modelVersion: Option[String] = None
    ): InferRxNormResponse =
      InferRxNormResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def inputDataConfig(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None
    ): InputDataConfig =
      InputDataConfig
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidEncodingException(
      message: Option[String] = None
    ): InvalidEncodingException =
      InvalidEncodingException
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

    def listEntitiesDetectionV2JobsRequest(
      filter: Option[ComprehendMedicalAsyncJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEntitiesDetectionV2JobsRequest =
      ListEntitiesDetectionV2JobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEntitiesDetectionV2JobsResponse(
      comprehendMedicalAsyncJobPropertiesList: Option[List[ComprehendMedicalAsyncJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListEntitiesDetectionV2JobsResponse =
      ListEntitiesDetectionV2JobsResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobPropertiesList)(_.comprehendMedicalAsyncJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listICD10CMInferenceJobsRequest(
      filter: Option[ComprehendMedicalAsyncJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListICD10CMInferenceJobsRequest =
      ListICD10CMInferenceJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listICD10CMInferenceJobsResponse(
      comprehendMedicalAsyncJobPropertiesList: Option[List[ComprehendMedicalAsyncJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListICD10CMInferenceJobsResponse =
      ListICD10CMInferenceJobsResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobPropertiesList)(_.comprehendMedicalAsyncJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPHIDetectionJobsRequest(
      filter: Option[ComprehendMedicalAsyncJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPHIDetectionJobsRequest =
      ListPHIDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPHIDetectionJobsResponse(
      comprehendMedicalAsyncJobPropertiesList: Option[List[ComprehendMedicalAsyncJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListPHIDetectionJobsResponse =
      ListPHIDetectionJobsResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobPropertiesList)(_.comprehendMedicalAsyncJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRxNormInferenceJobsRequest(
      filter: Option[ComprehendMedicalAsyncJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRxNormInferenceJobsRequest =
      ListRxNormInferenceJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRxNormInferenceJobsResponse(
      comprehendMedicalAsyncJobPropertiesList: Option[List[ComprehendMedicalAsyncJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListRxNormInferenceJobsResponse =
      ListRxNormInferenceJobsResponse
        .builder
        .ifSome(comprehendMedicalAsyncJobPropertiesList)(_.comprehendMedicalAsyncJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def outputDataConfig(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None
    ): OutputDataConfig =
      OutputDataConfig
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def rxNormAttribute(
      `type`: Option[String] = None,
      score: Option[Float] = None,
      relationshipScore: Option[Float] = None,
      id: Option[Int] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      text: Option[String] = None,
      traits: Option[List[RxNormTrait]] = None
    ): RxNormAttribute =
      RxNormAttribute
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(score)(_.score(_))
        .ifSome(relationshipScore)(_.relationshipScore(_))
        .ifSome(id)(_.id(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(text)(_.text(_))
        .ifSome(traits)(_.traits(_))
        .build

    def rxNormConcept(
      description: Option[String] = None,
      code: Option[String] = None,
      score: Option[Float] = None
    ): RxNormConcept =
      RxNormConcept
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(code)(_.code(_))
        .ifSome(score)(_.score(_))
        .build

    def rxNormEntity(
      id: Option[Int] = None,
      text: Option[String] = None,
      category: Option[String] = None,
      `type`: Option[String] = None,
      score: Option[Float] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      attributes: Option[List[RxNormAttribute]] = None,
      traits: Option[List[RxNormTrait]] = None,
      rxNormConcepts: Option[List[RxNormConcept]] = None
    ): RxNormEntity =
      RxNormEntity
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(text)(_.text(_))
        .ifSome(category)(_.category(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(score)(_.score(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(traits)(_.traits(_))
        .ifSome(rxNormConcepts)(_.rxNormConcepts(_))
        .build

    def rxNormTrait(
      name: Option[String] = None,
      score: Option[Float] = None
    ): RxNormTrait =
      RxNormTrait
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(score)(_.score(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startEntitiesDetectionV2JobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      clientRequestToken: Option[String] = None,
      kMSKey: Option[String] = None,
      languageCode: Option[String] = None
    ): StartEntitiesDetectionV2JobRequest =
      StartEntitiesDetectionV2JobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def startEntitiesDetectionV2JobResponse(
      jobId: Option[String] = None
    ): StartEntitiesDetectionV2JobResponse =
      StartEntitiesDetectionV2JobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startICD10CMInferenceJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      clientRequestToken: Option[String] = None,
      kMSKey: Option[String] = None,
      languageCode: Option[String] = None
    ): StartICD10CMInferenceJobRequest =
      StartICD10CMInferenceJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def startICD10CMInferenceJobResponse(
      jobId: Option[String] = None
    ): StartICD10CMInferenceJobResponse =
      StartICD10CMInferenceJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startPHIDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      clientRequestToken: Option[String] = None,
      kMSKey: Option[String] = None,
      languageCode: Option[String] = None
    ): StartPHIDetectionJobRequest =
      StartPHIDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def startPHIDetectionJobResponse(
      jobId: Option[String] = None
    ): StartPHIDetectionJobResponse =
      StartPHIDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startRxNormInferenceJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      clientRequestToken: Option[String] = None,
      kMSKey: Option[String] = None,
      languageCode: Option[String] = None
    ): StartRxNormInferenceJobRequest =
      StartRxNormInferenceJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(kMSKey)(_.kMSKey(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def startRxNormInferenceJobResponse(
      jobId: Option[String] = None
    ): StartRxNormInferenceJobResponse =
      StartRxNormInferenceJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopEntitiesDetectionV2JobRequest(
      jobId: Option[String] = None
    ): StopEntitiesDetectionV2JobRequest =
      StopEntitiesDetectionV2JobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopEntitiesDetectionV2JobResponse(
      jobId: Option[String] = None
    ): StopEntitiesDetectionV2JobResponse =
      StopEntitiesDetectionV2JobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopICD10CMInferenceJobRequest(
      jobId: Option[String] = None
    ): StopICD10CMInferenceJobRequest =
      StopICD10CMInferenceJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopICD10CMInferenceJobResponse(
      jobId: Option[String] = None
    ): StopICD10CMInferenceJobResponse =
      StopICD10CMInferenceJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopPHIDetectionJobRequest(
      jobId: Option[String] = None
    ): StopPHIDetectionJobRequest =
      StopPHIDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopPHIDetectionJobResponse(
      jobId: Option[String] = None
    ): StopPHIDetectionJobResponse =
      StopPHIDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopRxNormInferenceJobRequest(
      jobId: Option[String] = None
    ): StopRxNormInferenceJobRequest =
      StopRxNormInferenceJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopRxNormInferenceJobResponse(
      jobId: Option[String] = None
    ): StopRxNormInferenceJobResponse =
      StopRxNormInferenceJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def textSizeLimitExceededException(
      message: Option[String] = None
    ): TextSizeLimitExceededException =
      TextSizeLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trait(
      name: Option[String] = None,
      score: Option[Float] = None
    ): Trait =
      Trait
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(score)(_.score(_))
        .build

    def unmappedAttribute(
      `type`: Option[String] = None,
      attribute: Option[Attribute] = None
    ): UnmappedAttribute =
      UnmappedAttribute
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(attribute)(_.attribute(_))
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
