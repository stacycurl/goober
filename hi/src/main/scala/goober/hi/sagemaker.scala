package goober.hi

import goober.free.sagemaker.SageMakerIO
import software.amazon.awssdk.services.sagemaker.model._


object sagemaker {
  import goober.free.{sagemaker ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def actionSource(
      sourceUri: Option[String] = None,
      sourceType: Option[String] = None,
      sourceId: Option[String] = None
    ): ActionSource =
      ActionSource
        .builder
        .ifSome(sourceUri)(_.sourceUri(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceId)(_.sourceId(_))
        .build

    def actionSummary(
      actionArn: Option[String] = None,
      actionName: Option[String] = None,
      source: Option[ActionSource] = None,
      actionType: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): ActionSummary =
      ActionSummary
        .builder
        .ifSome(actionArn)(_.actionArn(_))
        .ifSome(actionName)(_.actionName(_))
        .ifSome(source)(_.source(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def addAssociationRequest(
      sourceArn: Option[String] = None,
      destinationArn: Option[String] = None,
      associationType: Option[String] = None
    ): AddAssociationRequest =
      AddAssociationRequest
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(associationType)(_.associationType(_))
        .build

    def addAssociationResponse(
      sourceArn: Option[String] = None,
      destinationArn: Option[String] = None
    ): AddAssociationResponse =
      AddAssociationResponse
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .build

    def addTagsInput(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsInput =
      AddTagsInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsOutput(
      tags: Option[List[Tag]] = None
    ): AddTagsOutput =
      AddTagsOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def agentVersion(
      version: Option[String] = None,
      agentCount: Option[Long] = None
    ): AgentVersion =
      AgentVersion
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(agentCount)(_.agentCount(_))
        .build

    def alarm(
      alarmName: Option[String] = None
    ): Alarm =
      Alarm
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .build

    def algorithmSpecification(
      trainingImage: Option[String] = None,
      algorithmName: Option[String] = None,
      trainingInputMode: Option[String] = None,
      metricDefinitions: Option[List[MetricDefinition]] = None,
      enableSageMakerMetricsTimeSeries: Option[Boolean] = None
    ): AlgorithmSpecification =
      AlgorithmSpecification
        .builder
        .ifSome(trainingImage)(_.trainingImage(_))
        .ifSome(algorithmName)(_.algorithmName(_))
        .ifSome(trainingInputMode)(_.trainingInputMode(_))
        .ifSome(metricDefinitions)(_.metricDefinitions(_))
        .ifSome(enableSageMakerMetricsTimeSeries)(_.enableSageMakerMetricsTimeSeries(_))
        .build

    def algorithmStatusDetails(
      validationStatuses: Option[List[AlgorithmStatusItem]] = None,
      imageScanStatuses: Option[List[AlgorithmStatusItem]] = None
    ): AlgorithmStatusDetails =
      AlgorithmStatusDetails
        .builder
        .ifSome(validationStatuses)(_.validationStatuses(_))
        .ifSome(imageScanStatuses)(_.imageScanStatuses(_))
        .build

    def algorithmStatusItem(
      name: Option[String] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None
    ): AlgorithmStatusItem =
      AlgorithmStatusItem
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def algorithmSummary(
      algorithmName: Option[String] = None,
      algorithmArn: Option[String] = None,
      algorithmDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      algorithmStatus: Option[String] = None
    ): AlgorithmSummary =
      AlgorithmSummary
        .builder
        .ifSome(algorithmName)(_.algorithmName(_))
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .ifSome(algorithmDescription)(_.algorithmDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(algorithmStatus)(_.algorithmStatus(_))
        .build

    def algorithmValidationProfile(
      profileName: Option[String] = None,
      trainingJobDefinition: Option[TrainingJobDefinition] = None,
      transformJobDefinition: Option[TransformJobDefinition] = None
    ): AlgorithmValidationProfile =
      AlgorithmValidationProfile
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(trainingJobDefinition)(_.trainingJobDefinition(_))
        .ifSome(transformJobDefinition)(_.transformJobDefinition(_))
        .build

    def algorithmValidationSpecification(
      validationRole: Option[String] = None,
      validationProfiles: Option[List[AlgorithmValidationProfile]] = None
    ): AlgorithmValidationSpecification =
      AlgorithmValidationSpecification
        .builder
        .ifSome(validationRole)(_.validationRole(_))
        .ifSome(validationProfiles)(_.validationProfiles(_))
        .build

    def annotationConsolidationConfig(
      annotationConsolidationLambdaArn: Option[String] = None
    ): AnnotationConsolidationConfig =
      AnnotationConsolidationConfig
        .builder
        .ifSome(annotationConsolidationLambdaArn)(_.annotationConsolidationLambdaArn(_))
        .build

    def appDetails(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      appType: Option[String] = None,
      appName: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[CreationTime] = None
    ): AppDetails =
      AppDetails
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(appType)(_.appType(_))
        .ifSome(appName)(_.appName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def appImageConfigDetails(
      appImageConfigArn: Option[String] = None,
      appImageConfigName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      kernelGatewayImageConfig: Option[KernelGatewayImageConfig] = None
    ): AppImageConfigDetails =
      AppImageConfigDetails
        .builder
        .ifSome(appImageConfigArn)(_.appImageConfigArn(_))
        .ifSome(appImageConfigName)(_.appImageConfigName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(kernelGatewayImageConfig)(_.kernelGatewayImageConfig(_))
        .build

    def appSpecification(
      imageUri: Option[String] = None,
      containerEntrypoint: Option[List[ContainerEntrypointString]] = None,
      containerArguments: Option[List[ContainerArgument]] = None
    ): AppSpecification =
      AppSpecification
        .builder
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(containerEntrypoint)(_.containerEntrypoint(_))
        .ifSome(containerArguments)(_.containerArguments(_))
        .build

    def artifactSource(
      sourceUri: Option[String] = None,
      sourceTypes: Option[List[ArtifactSourceType]] = None
    ): ArtifactSource =
      ArtifactSource
        .builder
        .ifSome(sourceUri)(_.sourceUri(_))
        .ifSome(sourceTypes)(_.sourceTypes(_))
        .build

    def artifactSourceType(
      sourceIdType: Option[String] = None,
      value: Option[String] = None
    ): ArtifactSourceType =
      ArtifactSourceType
        .builder
        .ifSome(sourceIdType)(_.sourceIdType(_))
        .ifSome(value)(_.value(_))
        .build

    def artifactSummary(
      artifactArn: Option[String] = None,
      artifactName: Option[String] = None,
      source: Option[ArtifactSource] = None,
      artifactType: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): ArtifactSummary =
      ArtifactSummary
        .builder
        .ifSome(artifactArn)(_.artifactArn(_))
        .ifSome(artifactName)(_.artifactName(_))
        .ifSome(source)(_.source(_))
        .ifSome(artifactType)(_.artifactType(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def associateTrialComponentRequest(
      trialComponentName: Option[String] = None,
      trialName: Option[String] = None
    ): AssociateTrialComponentRequest =
      AssociateTrialComponentRequest
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(trialName)(_.trialName(_))
        .build

    def associateTrialComponentResponse(
      trialComponentArn: Option[String] = None,
      trialArn: Option[String] = None
    ): AssociateTrialComponentResponse =
      AssociateTrialComponentResponse
        .builder
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .ifSome(trialArn)(_.trialArn(_))
        .build

    def associationSummary(
      sourceArn: Option[String] = None,
      destinationArn: Option[String] = None,
      sourceType: Option[String] = None,
      destinationType: Option[String] = None,
      associationType: Option[String] = None,
      sourceName: Option[String] = None,
      destinationName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None
    ): AssociationSummary =
      AssociationSummary
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(associationType)(_.associationType(_))
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def athenaDatasetDefinition(
      catalog: Option[String] = None,
      database: Option[String] = None,
      queryString: Option[String] = None,
      workGroup: Option[String] = None,
      outputS3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None,
      outputFormat: Option[String] = None,
      outputCompression: Option[String] = None
    ): AthenaDatasetDefinition =
      AthenaDatasetDefinition
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(database)(_.database(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(workGroup)(_.workGroup(_))
        .ifSome(outputS3Uri)(_.outputS3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .ifSome(outputCompression)(_.outputCompression(_))
        .build

    def autoMLCandidate(
      candidateName: Option[String] = None,
      finalAutoMLJobObjectiveMetric: Option[FinalAutoMLJobObjectiveMetric] = None,
      objectiveStatus: Option[String] = None,
      candidateSteps: Option[List[AutoMLCandidateStep]] = None,
      candidateStatus: Option[String] = None,
      inferenceContainers: Option[List[AutoMLContainerDefinition]] = None,
      creationTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      failureReason: Option[String] = None,
      candidateProperties: Option[CandidateProperties] = None
    ): AutoMLCandidate =
      AutoMLCandidate
        .builder
        .ifSome(candidateName)(_.candidateName(_))
        .ifSome(finalAutoMLJobObjectiveMetric)(_.finalAutoMLJobObjectiveMetric(_))
        .ifSome(objectiveStatus)(_.objectiveStatus(_))
        .ifSome(candidateSteps)(_.candidateSteps(_))
        .ifSome(candidateStatus)(_.candidateStatus(_))
        .ifSome(inferenceContainers)(_.inferenceContainers(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(candidateProperties)(_.candidateProperties(_))
        .build

    def autoMLCandidateStep(
      candidateStepType: Option[String] = None,
      candidateStepArn: Option[String] = None,
      candidateStepName: Option[String] = None
    ): AutoMLCandidateStep =
      AutoMLCandidateStep
        .builder
        .ifSome(candidateStepType)(_.candidateStepType(_))
        .ifSome(candidateStepArn)(_.candidateStepArn(_))
        .ifSome(candidateStepName)(_.candidateStepName(_))
        .build

    def autoMLChannel(
      dataSource: Option[AutoMLDataSource] = None,
      compressionType: Option[String] = None,
      targetAttributeName: Option[String] = None
    ): AutoMLChannel =
      AutoMLChannel
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(compressionType)(_.compressionType(_))
        .ifSome(targetAttributeName)(_.targetAttributeName(_))
        .build

    def autoMLContainerDefinition(
      image: Option[String] = None,
      modelDataUrl: Option[String] = None,
      environment: Option[EnvironmentMap] = None
    ): AutoMLContainerDefinition =
      AutoMLContainerDefinition
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(modelDataUrl)(_.modelDataUrl(_))
        .ifSome(environment)(_.environment(_))
        .build

    def autoMLDataSource(
      s3DataSource: Option[AutoMLS3DataSource] = None
    ): AutoMLDataSource =
      AutoMLDataSource
        .builder
        .ifSome(s3DataSource)(_.s3DataSource(_))
        .build

    def autoMLJobArtifacts(
      candidateDefinitionNotebookLocation: Option[String] = None,
      dataExplorationNotebookLocation: Option[String] = None
    ): AutoMLJobArtifacts =
      AutoMLJobArtifacts
        .builder
        .ifSome(candidateDefinitionNotebookLocation)(_.candidateDefinitionNotebookLocation(_))
        .ifSome(dataExplorationNotebookLocation)(_.dataExplorationNotebookLocation(_))
        .build

    def autoMLJobCompletionCriteria(
      maxCandidates: Option[Int] = None,
      maxRuntimePerTrainingJobInSeconds: Option[Int] = None,
      maxAutoMLJobRuntimeInSeconds: Option[Int] = None
    ): AutoMLJobCompletionCriteria =
      AutoMLJobCompletionCriteria
        .builder
        .ifSome(maxCandidates)(_.maxCandidates(_))
        .ifSome(maxRuntimePerTrainingJobInSeconds)(_.maxRuntimePerTrainingJobInSeconds(_))
        .ifSome(maxAutoMLJobRuntimeInSeconds)(_.maxAutoMLJobRuntimeInSeconds(_))
        .build

    def autoMLJobConfig(
      completionCriteria: Option[AutoMLJobCompletionCriteria] = None,
      securityConfig: Option[AutoMLSecurityConfig] = None
    ): AutoMLJobConfig =
      AutoMLJobConfig
        .builder
        .ifSome(completionCriteria)(_.completionCriteria(_))
        .ifSome(securityConfig)(_.securityConfig(_))
        .build

    def autoMLJobObjective(
      metricName: Option[String] = None
    ): AutoMLJobObjective =
      AutoMLJobObjective
        .builder
        .ifSome(metricName)(_.metricName(_))
        .build

    def autoMLJobSummary(
      autoMLJobName: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      autoMLJobStatus: Option[String] = None,
      autoMLJobSecondaryStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      failureReason: Option[String] = None,
      partialFailureReasons: Option[List[AutoMLPartialFailureReason]] = None
    ): AutoMLJobSummary =
      AutoMLJobSummary
        .builder
        .ifSome(autoMLJobName)(_.autoMLJobName(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(autoMLJobStatus)(_.autoMLJobStatus(_))
        .ifSome(autoMLJobSecondaryStatus)(_.autoMLJobSecondaryStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(partialFailureReasons)(_.partialFailureReasons(_))
        .build

    def autoMLOutputDataConfig(
      kmsKeyId: Option[String] = None,
      s3OutputPath: Option[String] = None
    ): AutoMLOutputDataConfig =
      AutoMLOutputDataConfig
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .build

    def autoMLPartialFailureReason(
      partialFailureMessage: Option[String] = None
    ): AutoMLPartialFailureReason =
      AutoMLPartialFailureReason
        .builder
        .ifSome(partialFailureMessage)(_.partialFailureMessage(_))
        .build

    def autoMLS3DataSource(
      s3DataType: Option[String] = None,
      s3Uri: Option[String] = None
    ): AutoMLS3DataSource =
      AutoMLS3DataSource
        .builder
        .ifSome(s3DataType)(_.s3DataType(_))
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def autoMLSecurityConfig(
      volumeKmsKeyId: Option[String] = None,
      enableInterContainerTrafficEncryption: Option[Boolean] = None,
      vpcConfig: Option[VpcConfig] = None
    ): AutoMLSecurityConfig =
      AutoMLSecurityConfig
        .builder
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(enableInterContainerTrafficEncryption)(_.enableInterContainerTrafficEncryption(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def autoRollbackConfig(
      alarms: Option[List[Alarm]] = None
    ): AutoRollbackConfig =
      AutoRollbackConfig
        .builder
        .ifSome(alarms)(_.alarms(_))
        .build

    def bias(
      report: Option[MetricsSource] = None
    ): Bias =
      Bias
        .builder
        .ifSome(report)(_.report(_))
        .build

    def blueGreenUpdatePolicy(
      trafficRoutingConfiguration: Option[TrafficRoutingConfig] = None,
      terminationWaitInSeconds: Option[Int] = None,
      maximumExecutionTimeoutInSeconds: Option[Int] = None
    ): BlueGreenUpdatePolicy =
      BlueGreenUpdatePolicy
        .builder
        .ifSome(trafficRoutingConfiguration)(_.trafficRoutingConfiguration(_))
        .ifSome(terminationWaitInSeconds)(_.terminationWaitInSeconds(_))
        .ifSome(maximumExecutionTimeoutInSeconds)(_.maximumExecutionTimeoutInSeconds(_))
        .build

    def callbackStepMetadata(
      callbackToken: Option[String] = None,
      sqsQueueUrl: Option[String] = None,
      outputParameters: Option[List[OutputParameter]] = None
    ): CallbackStepMetadata =
      CallbackStepMetadata
        .builder
        .ifSome(callbackToken)(_.callbackToken(_))
        .ifSome(sqsQueueUrl)(_.sqsQueueUrl(_))
        .ifSome(outputParameters)(_.outputParameters(_))
        .build

    def candidateArtifactLocations(
      explainability: Option[String] = None
    ): CandidateArtifactLocations =
      CandidateArtifactLocations
        .builder
        .ifSome(explainability)(_.explainability(_))
        .build

    def candidateProperties(
      candidateArtifactLocations: Option[CandidateArtifactLocations] = None
    ): CandidateProperties =
      CandidateProperties
        .builder
        .ifSome(candidateArtifactLocations)(_.candidateArtifactLocations(_))
        .build

    def capacitySize(
      `type`: Option[String] = None,
      value: Option[Int] = None
    ): CapacitySize =
      CapacitySize
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def captureContentTypeHeader(
      csvContentTypes: Option[List[CsvContentType]] = None,
      jsonContentTypes: Option[List[JsonContentType]] = None
    ): CaptureContentTypeHeader =
      CaptureContentTypeHeader
        .builder
        .ifSome(csvContentTypes)(_.csvContentTypes(_))
        .ifSome(jsonContentTypes)(_.jsonContentTypes(_))
        .build

    def captureOption(
      captureMode: Option[String] = None
    ): CaptureOption =
      CaptureOption
        .builder
        .ifSome(captureMode)(_.captureMode(_))
        .build

    def categoricalParameterRange(
      name: Option[String] = None,
      values: Option[List[ParameterValue]] = None
    ): CategoricalParameterRange =
      CategoricalParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def categoricalParameterRangeSpecification(
      values: Option[List[ParameterValue]] = None
    ): CategoricalParameterRangeSpecification =
      CategoricalParameterRangeSpecification
        .builder
        .ifSome(values)(_.values(_))
        .build

    def channel(
      channelName: Option[String] = None,
      dataSource: Option[DataSource] = None,
      contentType: Option[String] = None,
      compressionType: Option[String] = None,
      recordWrapperType: Option[String] = None,
      inputMode: Option[String] = None,
      shuffleConfig: Option[ShuffleConfig] = None
    ): Channel =
      Channel
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(compressionType)(_.compressionType(_))
        .ifSome(recordWrapperType)(_.recordWrapperType(_))
        .ifSome(inputMode)(_.inputMode(_))
        .ifSome(shuffleConfig)(_.shuffleConfig(_))
        .build

    def channelSpecification(
      name: Option[String] = None,
      description: Option[String] = None,
      isRequired: Option[Boolean] = None,
      supportedContentTypes: Option[List[ContentType]] = None,
      supportedCompressionTypes: Option[List[CompressionType]] = None,
      supportedInputModes: Option[List[TrainingInputMode]] = None
    ): ChannelSpecification =
      ChannelSpecification
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(isRequired)(_.isRequired(_))
        .ifSome(supportedContentTypes)(_.supportedContentTypes(_))
        .ifSome(supportedCompressionTypes)(_.supportedCompressionTypes(_))
        .ifSome(supportedInputModes)(_.supportedInputModes(_))
        .build

    def checkpointConfig(
      s3Uri: Option[String] = None,
      localPath: Option[String] = None
    ): CheckpointConfig =
      CheckpointConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(localPath)(_.localPath(_))
        .build

    def codeRepositorySummary(
      codeRepositoryName: Option[String] = None,
      codeRepositoryArn: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      gitConfig: Option[GitConfig] = None
    ): CodeRepositorySummary =
      CodeRepositorySummary
        .builder
        .ifSome(codeRepositoryName)(_.codeRepositoryName(_))
        .ifSome(codeRepositoryArn)(_.codeRepositoryArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(gitConfig)(_.gitConfig(_))
        .build

    def cognitoConfig(
      userPool: Option[String] = None,
      clientId: Option[String] = None
    ): CognitoConfig =
      CognitoConfig
        .builder
        .ifSome(userPool)(_.userPool(_))
        .ifSome(clientId)(_.clientId(_))
        .build

    def cognitoMemberDefinition(
      userPool: Option[String] = None,
      userGroup: Option[String] = None,
      clientId: Option[String] = None
    ): CognitoMemberDefinition =
      CognitoMemberDefinition
        .builder
        .ifSome(userPool)(_.userPool(_))
        .ifSome(userGroup)(_.userGroup(_))
        .ifSome(clientId)(_.clientId(_))
        .build

    def collectionConfiguration(
      collectionName: Option[String] = None,
      collectionParameters: Option[CollectionParameters] = None
    ): CollectionConfiguration =
      CollectionConfiguration
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(collectionParameters)(_.collectionParameters(_))
        .build

    def compilationJobSummary(
      compilationJobName: Option[String] = None,
      compilationJobArn: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      compilationStartTime: Option[Timestamp] = None,
      compilationEndTime: Option[Timestamp] = None,
      compilationTargetDevice: Option[String] = None,
      compilationTargetPlatformOs: Option[String] = None,
      compilationTargetPlatformArch: Option[String] = None,
      compilationTargetPlatformAccelerator: Option[String] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      compilationJobStatus: Option[String] = None
    ): CompilationJobSummary =
      CompilationJobSummary
        .builder
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .ifSome(compilationJobArn)(_.compilationJobArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(compilationStartTime)(_.compilationStartTime(_))
        .ifSome(compilationEndTime)(_.compilationEndTime(_))
        .ifSome(compilationTargetDevice)(_.compilationTargetDevice(_))
        .ifSome(compilationTargetPlatformOs)(_.compilationTargetPlatformOs(_))
        .ifSome(compilationTargetPlatformArch)(_.compilationTargetPlatformArch(_))
        .ifSome(compilationTargetPlatformAccelerator)(_.compilationTargetPlatformAccelerator(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(compilationJobStatus)(_.compilationJobStatus(_))
        .build

    def conditionStepMetadata(
      outcome: Option[String] = None
    ): ConditionStepMetadata =
      ConditionStepMetadata
        .builder
        .ifSome(outcome)(_.outcome(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def containerDefinition(
      containerHostname: Option[String] = None,
      image: Option[String] = None,
      imageConfig: Option[ImageConfig] = None,
      mode: Option[String] = None,
      modelDataUrl: Option[String] = None,
      environment: Option[EnvironmentMap] = None,
      modelPackageName: Option[String] = None,
      multiModelConfig: Option[MultiModelConfig] = None
    ): ContainerDefinition =
      ContainerDefinition
        .builder
        .ifSome(containerHostname)(_.containerHostname(_))
        .ifSome(image)(_.image(_))
        .ifSome(imageConfig)(_.imageConfig(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(modelDataUrl)(_.modelDataUrl(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(modelPackageName)(_.modelPackageName(_))
        .ifSome(multiModelConfig)(_.multiModelConfig(_))
        .build

    def contextSource(
      sourceUri: Option[String] = None,
      sourceType: Option[String] = None,
      sourceId: Option[String] = None
    ): ContextSource =
      ContextSource
        .builder
        .ifSome(sourceUri)(_.sourceUri(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceId)(_.sourceId(_))
        .build

    def contextSummary(
      contextArn: Option[String] = None,
      contextName: Option[String] = None,
      source: Option[ContextSource] = None,
      contextType: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): ContextSummary =
      ContextSummary
        .builder
        .ifSome(contextArn)(_.contextArn(_))
        .ifSome(contextName)(_.contextName(_))
        .ifSome(source)(_.source(_))
        .ifSome(contextType)(_.contextType(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def continuousParameterRange(
      name: Option[String] = None,
      minValue: Option[String] = None,
      maxValue: Option[String] = None,
      scalingType: Option[String] = None
    ): ContinuousParameterRange =
      ContinuousParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(scalingType)(_.scalingType(_))
        .build

    def continuousParameterRangeSpecification(
      minValue: Option[String] = None,
      maxValue: Option[String] = None
    ): ContinuousParameterRangeSpecification =
      ContinuousParameterRangeSpecification
        .builder
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .build

    def createActionRequest(
      actionName: Option[String] = None,
      source: Option[ActionSource] = None,
      actionType: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      metadataProperties: Option[MetadataProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateActionRequest =
      CreateActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(source)(_.source(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createActionResponse(
      actionArn: Option[String] = None
    ): CreateActionResponse =
      CreateActionResponse
        .builder
        .ifSome(actionArn)(_.actionArn(_))
        .build

    def createAlgorithmInput(
      algorithmName: Option[String] = None,
      algorithmDescription: Option[String] = None,
      trainingSpecification: Option[TrainingSpecification] = None,
      inferenceSpecification: Option[InferenceSpecification] = None,
      validationSpecification: Option[AlgorithmValidationSpecification] = None,
      certifyForMarketplace: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateAlgorithmInput =
      CreateAlgorithmInput
        .builder
        .ifSome(algorithmName)(_.algorithmName(_))
        .ifSome(algorithmDescription)(_.algorithmDescription(_))
        .ifSome(trainingSpecification)(_.trainingSpecification(_))
        .ifSome(inferenceSpecification)(_.inferenceSpecification(_))
        .ifSome(validationSpecification)(_.validationSpecification(_))
        .ifSome(certifyForMarketplace)(_.certifyForMarketplace(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAlgorithmOutput(
      algorithmArn: Option[String] = None
    ): CreateAlgorithmOutput =
      CreateAlgorithmOutput
        .builder
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .build

    def createAppImageConfigRequest(
      appImageConfigName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      kernelGatewayImageConfig: Option[KernelGatewayImageConfig] = None
    ): CreateAppImageConfigRequest =
      CreateAppImageConfigRequest
        .builder
        .ifSome(appImageConfigName)(_.appImageConfigName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kernelGatewayImageConfig)(_.kernelGatewayImageConfig(_))
        .build

    def createAppImageConfigResponse(
      appImageConfigArn: Option[String] = None
    ): CreateAppImageConfigResponse =
      CreateAppImageConfigResponse
        .builder
        .ifSome(appImageConfigArn)(_.appImageConfigArn(_))
        .build

    def createAppRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      appType: Option[String] = None,
      appName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      resourceSpec: Option[ResourceSpec] = None
    ): CreateAppRequest =
      CreateAppRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(appType)(_.appType(_))
        .ifSome(appName)(_.appName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(resourceSpec)(_.resourceSpec(_))
        .build

    def createAppResponse(
      appArn: Option[String] = None
    ): CreateAppResponse =
      CreateAppResponse
        .builder
        .ifSome(appArn)(_.appArn(_))
        .build

    def createArtifactRequest(
      artifactName: Option[String] = None,
      source: Option[ArtifactSource] = None,
      artifactType: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      metadataProperties: Option[MetadataProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateArtifactRequest =
      CreateArtifactRequest
        .builder
        .ifSome(artifactName)(_.artifactName(_))
        .ifSome(source)(_.source(_))
        .ifSome(artifactType)(_.artifactType(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createArtifactResponse(
      artifactArn: Option[String] = None
    ): CreateArtifactResponse =
      CreateArtifactResponse
        .builder
        .ifSome(artifactArn)(_.artifactArn(_))
        .build

    def createAutoMLJobRequest(
      autoMLJobName: Option[String] = None,
      inputDataConfig: Option[List[AutoMLChannel]] = None,
      outputDataConfig: Option[AutoMLOutputDataConfig] = None,
      problemType: Option[String] = None,
      autoMLJobObjective: Option[AutoMLJobObjective] = None,
      autoMLJobConfig: Option[AutoMLJobConfig] = None,
      roleArn: Option[String] = None,
      generateCandidateDefinitionsOnly: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      modelDeployConfig: Option[ModelDeployConfig] = None
    ): CreateAutoMLJobRequest =
      CreateAutoMLJobRequest
        .builder
        .ifSome(autoMLJobName)(_.autoMLJobName(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(problemType)(_.problemType(_))
        .ifSome(autoMLJobObjective)(_.autoMLJobObjective(_))
        .ifSome(autoMLJobConfig)(_.autoMLJobConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(generateCandidateDefinitionsOnly)(_.generateCandidateDefinitionsOnly(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(modelDeployConfig)(_.modelDeployConfig(_))
        .build

    def createAutoMLJobResponse(
      autoMLJobArn: Option[String] = None
    ): CreateAutoMLJobResponse =
      CreateAutoMLJobResponse
        .builder
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .build

    def createCodeRepositoryInput(
      codeRepositoryName: Option[String] = None,
      gitConfig: Option[GitConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateCodeRepositoryInput =
      CreateCodeRepositoryInput
        .builder
        .ifSome(codeRepositoryName)(_.codeRepositoryName(_))
        .ifSome(gitConfig)(_.gitConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCodeRepositoryOutput(
      codeRepositoryArn: Option[String] = None
    ): CreateCodeRepositoryOutput =
      CreateCodeRepositoryOutput
        .builder
        .ifSome(codeRepositoryArn)(_.codeRepositoryArn(_))
        .build

    def createCompilationJobRequest(
      compilationJobName: Option[String] = None,
      roleArn: Option[String] = None,
      inputConfig: Option[InputConfig] = None,
      outputConfig: Option[OutputConfig] = None,
      stoppingCondition: Option[StoppingCondition] = None,
      tags: Option[List[Tag]] = None
    ): CreateCompilationJobRequest =
      CreateCompilationJobRequest
        .builder
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(inputConfig)(_.inputConfig(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCompilationJobResponse(
      compilationJobArn: Option[String] = None
    ): CreateCompilationJobResponse =
      CreateCompilationJobResponse
        .builder
        .ifSome(compilationJobArn)(_.compilationJobArn(_))
        .build

    def createContextRequest(
      contextName: Option[String] = None,
      source: Option[ContextSource] = None,
      contextType: Option[String] = None,
      description: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      tags: Option[List[Tag]] = None
    ): CreateContextRequest =
      CreateContextRequest
        .builder
        .ifSome(contextName)(_.contextName(_))
        .ifSome(source)(_.source(_))
        .ifSome(contextType)(_.contextType(_))
        .ifSome(description)(_.description(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createContextResponse(
      contextArn: Option[String] = None
    ): CreateContextResponse =
      CreateContextResponse
        .builder
        .ifSome(contextArn)(_.contextArn(_))
        .build

    def createDataQualityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None,
      dataQualityBaselineConfig: Option[DataQualityBaselineConfig] = None,
      dataQualityAppSpecification: Option[DataQualityAppSpecification] = None,
      dataQualityJobInput: Option[DataQualityJobInput] = None,
      dataQualityJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None,
      tags: Option[List[Tag]] = None
    ): CreateDataQualityJobDefinitionRequest =
      CreateDataQualityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(dataQualityBaselineConfig)(_.dataQualityBaselineConfig(_))
        .ifSome(dataQualityAppSpecification)(_.dataQualityAppSpecification(_))
        .ifSome(dataQualityJobInput)(_.dataQualityJobInput(_))
        .ifSome(dataQualityJobOutputConfig)(_.dataQualityJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDataQualityJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None
    ): CreateDataQualityJobDefinitionResponse =
      CreateDataQualityJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .build

    def createDeviceFleetRequest(
      deviceFleetName: Option[String] = None,
      roleArn: Option[String] = None,
      description: Option[String] = None,
      outputConfig: Option[EdgeOutputConfig] = None,
      tags: Option[List[Tag]] = None,
      enableIotRoleAlias: Option[Boolean] = None
    ): CreateDeviceFleetRequest =
      CreateDeviceFleetRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(enableIotRoleAlias)(_.enableIotRoleAlias(_))
        .build

    def createDomainRequest(
      domainName: Option[String] = None,
      authMode: Option[String] = None,
      defaultUserSettings: Option[UserSettings] = None,
      subnetIds: Option[List[SubnetId]] = None,
      vpcId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      appNetworkAccessType: Option[String] = None,
      homeEfsFileSystemKmsKeyId: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): CreateDomainRequest =
      CreateDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(authMode)(_.authMode(_))
        .ifSome(defaultUserSettings)(_.defaultUserSettings(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(appNetworkAccessType)(_.appNetworkAccessType(_))
        .ifSome(homeEfsFileSystemKmsKeyId)(_.homeEfsFileSystemKmsKeyId(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def createDomainResponse(
      domainArn: Option[String] = None,
      url: Option[String] = None
    ): CreateDomainResponse =
      CreateDomainResponse
        .builder
        .ifSome(domainArn)(_.domainArn(_))
        .ifSome(url)(_.url(_))
        .build

    def createEdgePackagingJobRequest(
      edgePackagingJobName: Option[String] = None,
      compilationJobName: Option[String] = None,
      modelName: Option[String] = None,
      modelVersion: Option[String] = None,
      roleArn: Option[String] = None,
      outputConfig: Option[EdgeOutputConfig] = None,
      resourceKey: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateEdgePackagingJobRequest =
      CreateEdgePackagingJobRequest
        .builder
        .ifSome(edgePackagingJobName)(_.edgePackagingJobName(_))
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(resourceKey)(_.resourceKey(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEndpointConfigInput(
      endpointConfigName: Option[String] = None,
      productionVariants: Option[List[ProductionVariant]] = None,
      dataCaptureConfig: Option[DataCaptureConfig] = None,
      tags: Option[List[Tag]] = None,
      kmsKeyId: Option[String] = None
    ): CreateEndpointConfigInput =
      CreateEndpointConfigInput
        .builder
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .ifSome(productionVariants)(_.productionVariants(_))
        .ifSome(dataCaptureConfig)(_.dataCaptureConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def createEndpointConfigOutput(
      endpointConfigArn: Option[String] = None
    ): CreateEndpointConfigOutput =
      CreateEndpointConfigOutput
        .builder
        .ifSome(endpointConfigArn)(_.endpointConfigArn(_))
        .build

    def createEndpointInput(
      endpointName: Option[String] = None,
      endpointConfigName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateEndpointInput =
      CreateEndpointInput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEndpointOutput(
      endpointArn: Option[String] = None
    ): CreateEndpointOutput =
      CreateEndpointOutput
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def createExperimentRequest(
      experimentName: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateExperimentRequest =
      CreateExperimentRequest
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createExperimentResponse(
      experimentArn: Option[String] = None
    ): CreateExperimentResponse =
      CreateExperimentResponse
        .builder
        .ifSome(experimentArn)(_.experimentArn(_))
        .build

    def createFeatureGroupRequest(
      featureGroupName: Option[String] = None,
      recordIdentifierFeatureName: Option[String] = None,
      eventTimeFeatureName: Option[String] = None,
      featureDefinitions: Option[List[FeatureDefinition]] = None,
      onlineStoreConfig: Option[OnlineStoreConfig] = None,
      offlineStoreConfig: Option[OfflineStoreConfig] = None,
      roleArn: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateFeatureGroupRequest =
      CreateFeatureGroupRequest
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifierFeatureName)(_.recordIdentifierFeatureName(_))
        .ifSome(eventTimeFeatureName)(_.eventTimeFeatureName(_))
        .ifSome(featureDefinitions)(_.featureDefinitions(_))
        .ifSome(onlineStoreConfig)(_.onlineStoreConfig(_))
        .ifSome(offlineStoreConfig)(_.offlineStoreConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFeatureGroupResponse(
      featureGroupArn: Option[String] = None
    ): CreateFeatureGroupResponse =
      CreateFeatureGroupResponse
        .builder
        .ifSome(featureGroupArn)(_.featureGroupArn(_))
        .build

    def createFlowDefinitionRequest(
      flowDefinitionName: Option[String] = None,
      humanLoopRequestSource: Option[HumanLoopRequestSource] = None,
      humanLoopActivationConfig: Option[HumanLoopActivationConfig] = None,
      humanLoopConfig: Option[HumanLoopConfig] = None,
      outputConfig: Option[FlowDefinitionOutputConfig] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateFlowDefinitionRequest =
      CreateFlowDefinitionRequest
        .builder
        .ifSome(flowDefinitionName)(_.flowDefinitionName(_))
        .ifSome(humanLoopRequestSource)(_.humanLoopRequestSource(_))
        .ifSome(humanLoopActivationConfig)(_.humanLoopActivationConfig(_))
        .ifSome(humanLoopConfig)(_.humanLoopConfig(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFlowDefinitionResponse(
      flowDefinitionArn: Option[String] = None
    ): CreateFlowDefinitionResponse =
      CreateFlowDefinitionResponse
        .builder
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .build

    def createHumanTaskUiRequest(
      humanTaskUiName: Option[String] = None,
      uiTemplate: Option[UiTemplate] = None,
      tags: Option[List[Tag]] = None
    ): CreateHumanTaskUiRequest =
      CreateHumanTaskUiRequest
        .builder
        .ifSome(humanTaskUiName)(_.humanTaskUiName(_))
        .ifSome(uiTemplate)(_.uiTemplate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHumanTaskUiResponse(
      humanTaskUiArn: Option[String] = None
    ): CreateHumanTaskUiResponse =
      CreateHumanTaskUiResponse
        .builder
        .ifSome(humanTaskUiArn)(_.humanTaskUiArn(_))
        .build

    def createHyperParameterTuningJobRequest(
      hyperParameterTuningJobName: Option[String] = None,
      hyperParameterTuningJobConfig: Option[HyperParameterTuningJobConfig] = None,
      trainingJobDefinition: Option[HyperParameterTrainingJobDefinition] = None,
      trainingJobDefinitions: Option[List[HyperParameterTrainingJobDefinition]] = None,
      warmStartConfig: Option[HyperParameterTuningJobWarmStartConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateHyperParameterTuningJobRequest =
      CreateHyperParameterTuningJobRequest
        .builder
        .ifSome(hyperParameterTuningJobName)(_.hyperParameterTuningJobName(_))
        .ifSome(hyperParameterTuningJobConfig)(_.hyperParameterTuningJobConfig(_))
        .ifSome(trainingJobDefinition)(_.trainingJobDefinition(_))
        .ifSome(trainingJobDefinitions)(_.trainingJobDefinitions(_))
        .ifSome(warmStartConfig)(_.warmStartConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHyperParameterTuningJobResponse(
      hyperParameterTuningJobArn: Option[String] = None
    ): CreateHyperParameterTuningJobResponse =
      CreateHyperParameterTuningJobResponse
        .builder
        .ifSome(hyperParameterTuningJobArn)(_.hyperParameterTuningJobArn(_))
        .build

    def createImageRequest(
      description: Option[String] = None,
      displayName: Option[String] = None,
      imageName: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateImageRequest =
      CreateImageRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createImageResponse(
      imageArn: Option[String] = None
    ): CreateImageResponse =
      CreateImageResponse
        .builder
        .ifSome(imageArn)(_.imageArn(_))
        .build

    def createImageVersionRequest(
      baseImage: Option[String] = None,
      clientToken: Option[String] = None,
      imageName: Option[String] = None
    ): CreateImageVersionRequest =
      CreateImageVersionRequest
        .builder
        .ifSome(baseImage)(_.baseImage(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(imageName)(_.imageName(_))
        .build

    def createImageVersionResponse(
      imageVersionArn: Option[String] = None
    ): CreateImageVersionResponse =
      CreateImageVersionResponse
        .builder
        .ifSome(imageVersionArn)(_.imageVersionArn(_))
        .build

    def createLabelingJobRequest(
      labelingJobName: Option[String] = None,
      labelAttributeName: Option[String] = None,
      inputConfig: Option[LabelingJobInputConfig] = None,
      outputConfig: Option[LabelingJobOutputConfig] = None,
      roleArn: Option[String] = None,
      labelCategoryConfigS3Uri: Option[String] = None,
      stoppingConditions: Option[LabelingJobStoppingConditions] = None,
      labelingJobAlgorithmsConfig: Option[LabelingJobAlgorithmsConfig] = None,
      humanTaskConfig: Option[HumanTaskConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateLabelingJobRequest =
      CreateLabelingJobRequest
        .builder
        .ifSome(labelingJobName)(_.labelingJobName(_))
        .ifSome(labelAttributeName)(_.labelAttributeName(_))
        .ifSome(inputConfig)(_.inputConfig(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(labelCategoryConfigS3Uri)(_.labelCategoryConfigS3Uri(_))
        .ifSome(stoppingConditions)(_.stoppingConditions(_))
        .ifSome(labelingJobAlgorithmsConfig)(_.labelingJobAlgorithmsConfig(_))
        .ifSome(humanTaskConfig)(_.humanTaskConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLabelingJobResponse(
      labelingJobArn: Option[String] = None
    ): CreateLabelingJobResponse =
      CreateLabelingJobResponse
        .builder
        .ifSome(labelingJobArn)(_.labelingJobArn(_))
        .build

    def createModelBiasJobDefinitionRequest(
      jobDefinitionName: Option[String] = None,
      modelBiasBaselineConfig: Option[ModelBiasBaselineConfig] = None,
      modelBiasAppSpecification: Option[ModelBiasAppSpecification] = None,
      modelBiasJobInput: Option[ModelBiasJobInput] = None,
      modelBiasJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelBiasJobDefinitionRequest =
      CreateModelBiasJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(modelBiasBaselineConfig)(_.modelBiasBaselineConfig(_))
        .ifSome(modelBiasAppSpecification)(_.modelBiasAppSpecification(_))
        .ifSome(modelBiasJobInput)(_.modelBiasJobInput(_))
        .ifSome(modelBiasJobOutputConfig)(_.modelBiasJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelBiasJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None
    ): CreateModelBiasJobDefinitionResponse =
      CreateModelBiasJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .build

    def createModelExplainabilityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None,
      modelExplainabilityBaselineConfig: Option[ModelExplainabilityBaselineConfig] = None,
      modelExplainabilityAppSpecification: Option[ModelExplainabilityAppSpecification] = None,
      modelExplainabilityJobInput: Option[ModelExplainabilityJobInput] = None,
      modelExplainabilityJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelExplainabilityJobDefinitionRequest =
      CreateModelExplainabilityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(modelExplainabilityBaselineConfig)(_.modelExplainabilityBaselineConfig(_))
        .ifSome(modelExplainabilityAppSpecification)(_.modelExplainabilityAppSpecification(_))
        .ifSome(modelExplainabilityJobInput)(_.modelExplainabilityJobInput(_))
        .ifSome(modelExplainabilityJobOutputConfig)(_.modelExplainabilityJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelExplainabilityJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None
    ): CreateModelExplainabilityJobDefinitionResponse =
      CreateModelExplainabilityJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .build

    def createModelInput(
      modelName: Option[String] = None,
      primaryContainer: Option[ContainerDefinition] = None,
      containers: Option[List[ContainerDefinition]] = None,
      inferenceExecutionConfig: Option[InferenceExecutionConfig] = None,
      executionRoleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      vpcConfig: Option[VpcConfig] = None,
      enableNetworkIsolation: Option[Boolean] = None
    ): CreateModelInput =
      CreateModelInput
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(primaryContainer)(_.primaryContainer(_))
        .ifSome(containers)(_.containers(_))
        .ifSome(inferenceExecutionConfig)(_.inferenceExecutionConfig(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .build

    def createModelOutput(
      modelArn: Option[String] = None
    ): CreateModelOutput =
      CreateModelOutput
        .builder
        .ifSome(modelArn)(_.modelArn(_))
        .build

    def createModelPackageGroupInput(
      modelPackageGroupName: Option[String] = None,
      modelPackageGroupDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelPackageGroupInput =
      CreateModelPackageGroupInput
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageGroupDescription)(_.modelPackageGroupDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelPackageGroupOutput(
      modelPackageGroupArn: Option[String] = None
    ): CreateModelPackageGroupOutput =
      CreateModelPackageGroupOutput
        .builder
        .ifSome(modelPackageGroupArn)(_.modelPackageGroupArn(_))
        .build

    def createModelPackageInput(
      modelPackageName: Option[String] = None,
      modelPackageGroupName: Option[String] = None,
      modelPackageDescription: Option[String] = None,
      inferenceSpecification: Option[InferenceSpecification] = None,
      validationSpecification: Option[ModelPackageValidationSpecification] = None,
      sourceAlgorithmSpecification: Option[SourceAlgorithmSpecification] = None,
      certifyForMarketplace: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      modelApprovalStatus: Option[String] = None,
      metadataProperties: Option[MetadataProperties] = None,
      modelMetrics: Option[ModelMetrics] = None,
      clientToken: Option[String] = None
    ): CreateModelPackageInput =
      CreateModelPackageInput
        .builder
        .ifSome(modelPackageName)(_.modelPackageName(_))
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageDescription)(_.modelPackageDescription(_))
        .ifSome(inferenceSpecification)(_.inferenceSpecification(_))
        .ifSome(validationSpecification)(_.validationSpecification(_))
        .ifSome(sourceAlgorithmSpecification)(_.sourceAlgorithmSpecification(_))
        .ifSome(certifyForMarketplace)(_.certifyForMarketplace(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(modelApprovalStatus)(_.modelApprovalStatus(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(modelMetrics)(_.modelMetrics(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createModelPackageOutput(
      modelPackageArn: Option[String] = None
    ): CreateModelPackageOutput =
      CreateModelPackageOutput
        .builder
        .ifSome(modelPackageArn)(_.modelPackageArn(_))
        .build

    def createModelQualityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None,
      modelQualityBaselineConfig: Option[ModelQualityBaselineConfig] = None,
      modelQualityAppSpecification: Option[ModelQualityAppSpecification] = None,
      modelQualityJobInput: Option[ModelQualityJobInput] = None,
      modelQualityJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None,
      tags: Option[List[Tag]] = None
    ): CreateModelQualityJobDefinitionRequest =
      CreateModelQualityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(modelQualityBaselineConfig)(_.modelQualityBaselineConfig(_))
        .ifSome(modelQualityAppSpecification)(_.modelQualityAppSpecification(_))
        .ifSome(modelQualityJobInput)(_.modelQualityJobInput(_))
        .ifSome(modelQualityJobOutputConfig)(_.modelQualityJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createModelQualityJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None
    ): CreateModelQualityJobDefinitionResponse =
      CreateModelQualityJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .build

    def createMonitoringScheduleRequest(
      monitoringScheduleName: Option[String] = None,
      monitoringScheduleConfig: Option[MonitoringScheduleConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateMonitoringScheduleRequest =
      CreateMonitoringScheduleRequest
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .ifSome(monitoringScheduleConfig)(_.monitoringScheduleConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMonitoringScheduleResponse(
      monitoringScheduleArn: Option[String] = None
    ): CreateMonitoringScheduleResponse =
      CreateMonitoringScheduleResponse
        .builder
        .ifSome(monitoringScheduleArn)(_.monitoringScheduleArn(_))
        .build

    def createNotebookInstanceInput(
      notebookInstanceName: Option[String] = None,
      instanceType: Option[String] = None,
      subnetId: Option[String] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      roleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      lifecycleConfigName: Option[String] = None,
      directInternetAccess: Option[String] = None,
      volumeSizeInGB: Option[Int] = None,
      acceleratorTypes: Option[List[NotebookInstanceAcceleratorType]] = None,
      defaultCodeRepository: Option[String] = None,
      additionalCodeRepositories: Option[List[CodeRepositoryNameOrUrl]] = None,
      rootAccess: Option[String] = None
    ): CreateNotebookInstanceInput =
      CreateNotebookInstanceInput
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(lifecycleConfigName)(_.lifecycleConfigName(_))
        .ifSome(directInternetAccess)(_.directInternetAccess(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(acceleratorTypes)(_.acceleratorTypes(_))
        .ifSome(defaultCodeRepository)(_.defaultCodeRepository(_))
        .ifSome(additionalCodeRepositories)(_.additionalCodeRepositories(_))
        .ifSome(rootAccess)(_.rootAccess(_))
        .build

    def createNotebookInstanceLifecycleConfigInput(
      notebookInstanceLifecycleConfigName: Option[String] = None,
      onCreate: Option[List[NotebookInstanceLifecycleHook]] = None,
      onStart: Option[List[NotebookInstanceLifecycleHook]] = None
    ): CreateNotebookInstanceLifecycleConfigInput =
      CreateNotebookInstanceLifecycleConfigInput
        .builder
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .ifSome(onCreate)(_.onCreate(_))
        .ifSome(onStart)(_.onStart(_))
        .build

    def createNotebookInstanceLifecycleConfigOutput(
      notebookInstanceLifecycleConfigArn: Option[String] = None
    ): CreateNotebookInstanceLifecycleConfigOutput =
      CreateNotebookInstanceLifecycleConfigOutput
        .builder
        .ifSome(notebookInstanceLifecycleConfigArn)(_.notebookInstanceLifecycleConfigArn(_))
        .build

    def createNotebookInstanceOutput(
      notebookInstanceArn: Option[String] = None
    ): CreateNotebookInstanceOutput =
      CreateNotebookInstanceOutput
        .builder
        .ifSome(notebookInstanceArn)(_.notebookInstanceArn(_))
        .build

    def createPipelineRequest(
      pipelineName: Option[String] = None,
      pipelineDisplayName: Option[String] = None,
      pipelineDefinition: Option[String] = None,
      pipelineDescription: Option[String] = None,
      clientRequestToken: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePipelineRequest =
      CreatePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineDisplayName)(_.pipelineDisplayName(_))
        .ifSome(pipelineDefinition)(_.pipelineDefinition(_))
        .ifSome(pipelineDescription)(_.pipelineDescription(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPipelineResponse(
      pipelineArn: Option[String] = None
    ): CreatePipelineResponse =
      CreatePipelineResponse
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .build

    def createPresignedDomainUrlRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      sessionExpirationDurationInSeconds: Option[Int] = None,
      expiresInSeconds: Option[Int] = None
    ): CreatePresignedDomainUrlRequest =
      CreatePresignedDomainUrlRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(sessionExpirationDurationInSeconds)(_.sessionExpirationDurationInSeconds(_))
        .ifSome(expiresInSeconds)(_.expiresInSeconds(_))
        .build

    def createPresignedDomainUrlResponse(
      authorizedUrl: Option[String] = None
    ): CreatePresignedDomainUrlResponse =
      CreatePresignedDomainUrlResponse
        .builder
        .ifSome(authorizedUrl)(_.authorizedUrl(_))
        .build

    def createPresignedNotebookInstanceUrlInput(
      notebookInstanceName: Option[String] = None,
      sessionExpirationDurationInSeconds: Option[Int] = None
    ): CreatePresignedNotebookInstanceUrlInput =
      CreatePresignedNotebookInstanceUrlInput
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .ifSome(sessionExpirationDurationInSeconds)(_.sessionExpirationDurationInSeconds(_))
        .build

    def createPresignedNotebookInstanceUrlOutput(
      authorizedUrl: Option[String] = None
    ): CreatePresignedNotebookInstanceUrlOutput =
      CreatePresignedNotebookInstanceUrlOutput
        .builder
        .ifSome(authorizedUrl)(_.authorizedUrl(_))
        .build

    def createProcessingJobRequest(
      processingInputs: Option[List[ProcessingInput]] = None,
      processingOutputConfig: Option[ProcessingOutputConfig] = None,
      processingJobName: Option[String] = None,
      processingResources: Option[ProcessingResources] = None,
      stoppingCondition: Option[ProcessingStoppingCondition] = None,
      appSpecification: Option[AppSpecification] = None,
      environment: Option[ProcessingEnvironmentMap] = None,
      networkConfig: Option[NetworkConfig] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      experimentConfig: Option[ExperimentConfig] = None
    ): CreateProcessingJobRequest =
      CreateProcessingJobRequest
        .builder
        .ifSome(processingInputs)(_.processingInputs(_))
        .ifSome(processingOutputConfig)(_.processingOutputConfig(_))
        .ifSome(processingJobName)(_.processingJobName(_))
        .ifSome(processingResources)(_.processingResources(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(appSpecification)(_.appSpecification(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .build

    def createProcessingJobResponse(
      processingJobArn: Option[String] = None
    ): CreateProcessingJobResponse =
      CreateProcessingJobResponse
        .builder
        .ifSome(processingJobArn)(_.processingJobArn(_))
        .build

    def createProjectInput(
      projectName: Option[String] = None,
      projectDescription: Option[String] = None,
      serviceCatalogProvisioningDetails: Option[ServiceCatalogProvisioningDetails] = None,
      tags: Option[List[Tag]] = None
    ): CreateProjectInput =
      CreateProjectInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(projectDescription)(_.projectDescription(_))
        .ifSome(serviceCatalogProvisioningDetails)(_.serviceCatalogProvisioningDetails(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProjectOutput(
      projectArn: Option[String] = None,
      projectId: Option[String] = None
    ): CreateProjectOutput =
      CreateProjectOutput
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(projectId)(_.projectId(_))
        .build

    def createTrainingJobRequest(
      trainingJobName: Option[String] = None,
      hyperParameters: Option[HyperParameters] = None,
      algorithmSpecification: Option[AlgorithmSpecification] = None,
      roleArn: Option[String] = None,
      inputDataConfig: Option[List[Channel]] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      resourceConfig: Option[ResourceConfig] = None,
      vpcConfig: Option[VpcConfig] = None,
      stoppingCondition: Option[StoppingCondition] = None,
      tags: Option[List[Tag]] = None,
      enableNetworkIsolation: Option[Boolean] = None,
      enableInterContainerTrafficEncryption: Option[Boolean] = None,
      enableManagedSpotTraining: Option[Boolean] = None,
      checkpointConfig: Option[CheckpointConfig] = None,
      debugHookConfig: Option[DebugHookConfig] = None,
      debugRuleConfigurations: Option[List[DebugRuleConfiguration]] = None,
      tensorBoardOutputConfig: Option[TensorBoardOutputConfig] = None,
      experimentConfig: Option[ExperimentConfig] = None,
      profilerConfig: Option[ProfilerConfig] = None,
      profilerRuleConfigurations: Option[List[ProfilerRuleConfiguration]] = None,
      environment: Option[TrainingEnvironmentMap] = None,
      retryStrategy: Option[RetryStrategy] = None
    ): CreateTrainingJobRequest =
      CreateTrainingJobRequest
        .builder
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .ifSome(hyperParameters)(_.hyperParameters(_))
        .ifSome(algorithmSpecification)(_.algorithmSpecification(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .ifSome(enableInterContainerTrafficEncryption)(_.enableInterContainerTrafficEncryption(_))
        .ifSome(enableManagedSpotTraining)(_.enableManagedSpotTraining(_))
        .ifSome(checkpointConfig)(_.checkpointConfig(_))
        .ifSome(debugHookConfig)(_.debugHookConfig(_))
        .ifSome(debugRuleConfigurations)(_.debugRuleConfigurations(_))
        .ifSome(tensorBoardOutputConfig)(_.tensorBoardOutputConfig(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .ifSome(profilerConfig)(_.profilerConfig(_))
        .ifSome(profilerRuleConfigurations)(_.profilerRuleConfigurations(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .build

    def createTrainingJobResponse(
      trainingJobArn: Option[String] = None
    ): CreateTrainingJobResponse =
      CreateTrainingJobResponse
        .builder
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .build

    def createTransformJobRequest(
      transformJobName: Option[String] = None,
      modelName: Option[String] = None,
      maxConcurrentTransforms: Option[Int] = None,
      modelClientConfig: Option[ModelClientConfig] = None,
      maxPayloadInMB: Option[Int] = None,
      batchStrategy: Option[String] = None,
      environment: Option[TransformEnvironmentMap] = None,
      transformInput: Option[TransformInput] = None,
      transformOutput: Option[TransformOutput] = None,
      transformResources: Option[TransformResources] = None,
      dataProcessing: Option[DataProcessing] = None,
      tags: Option[List[Tag]] = None,
      experimentConfig: Option[ExperimentConfig] = None
    ): CreateTransformJobRequest =
      CreateTransformJobRequest
        .builder
        .ifSome(transformJobName)(_.transformJobName(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(maxConcurrentTransforms)(_.maxConcurrentTransforms(_))
        .ifSome(modelClientConfig)(_.modelClientConfig(_))
        .ifSome(maxPayloadInMB)(_.maxPayloadInMB(_))
        .ifSome(batchStrategy)(_.batchStrategy(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(transformInput)(_.transformInput(_))
        .ifSome(transformOutput)(_.transformOutput(_))
        .ifSome(transformResources)(_.transformResources(_))
        .ifSome(dataProcessing)(_.dataProcessing(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .build

    def createTransformJobResponse(
      transformJobArn: Option[String] = None
    ): CreateTransformJobResponse =
      CreateTransformJobResponse
        .builder
        .ifSome(transformJobArn)(_.transformJobArn(_))
        .build

    def createTrialComponentRequest(
      trialComponentName: Option[String] = None,
      displayName: Option[String] = None,
      status: Option[TrialComponentStatus] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      parameters: Option[TrialComponentParameters] = None,
      inputArtifacts: Option[TrialComponentArtifacts] = None,
      outputArtifacts: Option[TrialComponentArtifacts] = None,
      metadataProperties: Option[MetadataProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateTrialComponentRequest =
      CreateTrialComponentRequest
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTrialComponentResponse(
      trialComponentArn: Option[String] = None
    ): CreateTrialComponentResponse =
      CreateTrialComponentResponse
        .builder
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .build

    def createTrialRequest(
      trialName: Option[String] = None,
      displayName: Option[String] = None,
      experimentName: Option[String] = None,
      metadataProperties: Option[MetadataProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateTrialRequest =
      CreateTrialRequest
        .builder
        .ifSome(trialName)(_.trialName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTrialResponse(
      trialArn: Option[String] = None
    ): CreateTrialResponse =
      CreateTrialResponse
        .builder
        .ifSome(trialArn)(_.trialArn(_))
        .build

    def createUserProfileRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      singleSignOnUserIdentifier: Option[String] = None,
      singleSignOnUserValue: Option[String] = None,
      tags: Option[List[Tag]] = None,
      userSettings: Option[UserSettings] = None
    ): CreateUserProfileRequest =
      CreateUserProfileRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(singleSignOnUserIdentifier)(_.singleSignOnUserIdentifier(_))
        .ifSome(singleSignOnUserValue)(_.singleSignOnUserValue(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userSettings)(_.userSettings(_))
        .build

    def createUserProfileResponse(
      userProfileArn: Option[String] = None
    ): CreateUserProfileResponse =
      CreateUserProfileResponse
        .builder
        .ifSome(userProfileArn)(_.userProfileArn(_))
        .build

    def createWorkforceRequest(
      cognitoConfig: Option[CognitoConfig] = None,
      oidcConfig: Option[OidcConfig] = None,
      sourceIpConfig: Option[SourceIpConfig] = None,
      workforceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateWorkforceRequest =
      CreateWorkforceRequest
        .builder
        .ifSome(cognitoConfig)(_.cognitoConfig(_))
        .ifSome(oidcConfig)(_.oidcConfig(_))
        .ifSome(sourceIpConfig)(_.sourceIpConfig(_))
        .ifSome(workforceName)(_.workforceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorkforceResponse(
      workforceArn: Option[String] = None
    ): CreateWorkforceResponse =
      CreateWorkforceResponse
        .builder
        .ifSome(workforceArn)(_.workforceArn(_))
        .build

    def createWorkteamRequest(
      workteamName: Option[String] = None,
      workforceName: Option[String] = None,
      memberDefinitions: Option[List[MemberDefinition]] = None,
      description: Option[String] = None,
      notificationConfiguration: Option[NotificationConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): CreateWorkteamRequest =
      CreateWorkteamRequest
        .builder
        .ifSome(workteamName)(_.workteamName(_))
        .ifSome(workforceName)(_.workforceName(_))
        .ifSome(memberDefinitions)(_.memberDefinitions(_))
        .ifSome(description)(_.description(_))
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorkteamResponse(
      workteamArn: Option[String] = None
    ): CreateWorkteamResponse =
      CreateWorkteamResponse
        .builder
        .ifSome(workteamArn)(_.workteamArn(_))
        .build

    def customImage(
      imageName: Option[String] = None,
      imageVersionNumber: Option[Int] = None,
      appImageConfigName: Option[String] = None
    ): CustomImage =
      CustomImage
        .builder
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageVersionNumber)(_.imageVersionNumber(_))
        .ifSome(appImageConfigName)(_.appImageConfigName(_))
        .build

    def dataCaptureConfig(
      enableCapture: Option[Boolean] = None,
      initialSamplingPercentage: Option[Int] = None,
      destinationS3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None,
      captureOptions: Option[List[CaptureOption]] = None,
      captureContentTypeHeader: Option[CaptureContentTypeHeader] = None
    ): DataCaptureConfig =
      DataCaptureConfig
        .builder
        .ifSome(enableCapture)(_.enableCapture(_))
        .ifSome(initialSamplingPercentage)(_.initialSamplingPercentage(_))
        .ifSome(destinationS3Uri)(_.destinationS3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(captureOptions)(_.captureOptions(_))
        .ifSome(captureContentTypeHeader)(_.captureContentTypeHeader(_))
        .build

    def dataCaptureConfigSummary(
      enableCapture: Option[Boolean] = None,
      captureStatus: Option[String] = None,
      currentSamplingPercentage: Option[Int] = None,
      destinationS3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): DataCaptureConfigSummary =
      DataCaptureConfigSummary
        .builder
        .ifSome(enableCapture)(_.enableCapture(_))
        .ifSome(captureStatus)(_.captureStatus(_))
        .ifSome(currentSamplingPercentage)(_.currentSamplingPercentage(_))
        .ifSome(destinationS3Uri)(_.destinationS3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def dataCatalogConfig(
      tableName: Option[String] = None,
      catalog: Option[String] = None,
      database: Option[String] = None
    ): DataCatalogConfig =
      DataCatalogConfig
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(catalog)(_.catalog(_))
        .ifSome(database)(_.database(_))
        .build

    def dataProcessing(
      inputFilter: Option[String] = None,
      outputFilter: Option[String] = None,
      joinSource: Option[String] = None
    ): DataProcessing =
      DataProcessing
        .builder
        .ifSome(inputFilter)(_.inputFilter(_))
        .ifSome(outputFilter)(_.outputFilter(_))
        .ifSome(joinSource)(_.joinSource(_))
        .build

    def dataQualityAppSpecification(
      imageUri: Option[String] = None,
      containerEntrypoint: Option[List[ContainerEntrypointString]] = None,
      containerArguments: Option[List[ContainerArgument]] = None,
      recordPreprocessorSourceUri: Option[String] = None,
      postAnalyticsProcessorSourceUri: Option[String] = None,
      environment: Option[MonitoringEnvironmentMap] = None
    ): DataQualityAppSpecification =
      DataQualityAppSpecification
        .builder
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(containerEntrypoint)(_.containerEntrypoint(_))
        .ifSome(containerArguments)(_.containerArguments(_))
        .ifSome(recordPreprocessorSourceUri)(_.recordPreprocessorSourceUri(_))
        .ifSome(postAnalyticsProcessorSourceUri)(_.postAnalyticsProcessorSourceUri(_))
        .ifSome(environment)(_.environment(_))
        .build

    def dataQualityBaselineConfig(
      baseliningJobName: Option[String] = None,
      constraintsResource: Option[MonitoringConstraintsResource] = None,
      statisticsResource: Option[MonitoringStatisticsResource] = None
    ): DataQualityBaselineConfig =
      DataQualityBaselineConfig
        .builder
        .ifSome(baseliningJobName)(_.baseliningJobName(_))
        .ifSome(constraintsResource)(_.constraintsResource(_))
        .ifSome(statisticsResource)(_.statisticsResource(_))
        .build

    def dataQualityJobInput(
      endpointInput: Option[EndpointInput] = None
    ): DataQualityJobInput =
      DataQualityJobInput
        .builder
        .ifSome(endpointInput)(_.endpointInput(_))
        .build

    def dataSource(
      s3DataSource: Option[S3DataSource] = None,
      fileSystemDataSource: Option[FileSystemDataSource] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(s3DataSource)(_.s3DataSource(_))
        .ifSome(fileSystemDataSource)(_.fileSystemDataSource(_))
        .build

    def datasetDefinition(
      athenaDatasetDefinition: Option[AthenaDatasetDefinition] = None,
      redshiftDatasetDefinition: Option[RedshiftDatasetDefinition] = None,
      localPath: Option[String] = None,
      dataDistributionType: Option[String] = None,
      inputMode: Option[String] = None
    ): DatasetDefinition =
      DatasetDefinition
        .builder
        .ifSome(athenaDatasetDefinition)(_.athenaDatasetDefinition(_))
        .ifSome(redshiftDatasetDefinition)(_.redshiftDatasetDefinition(_))
        .ifSome(localPath)(_.localPath(_))
        .ifSome(dataDistributionType)(_.dataDistributionType(_))
        .ifSome(inputMode)(_.inputMode(_))
        .build

    def debugHookConfig(
      localPath: Option[String] = None,
      s3OutputPath: Option[String] = None,
      hookParameters: Option[HookParameters] = None,
      collectionConfigurations: Option[List[CollectionConfiguration]] = None
    ): DebugHookConfig =
      DebugHookConfig
        .builder
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(hookParameters)(_.hookParameters(_))
        .ifSome(collectionConfigurations)(_.collectionConfigurations(_))
        .build

    def debugRuleConfiguration(
      ruleConfigurationName: Option[String] = None,
      localPath: Option[String] = None,
      s3OutputPath: Option[String] = None,
      ruleEvaluatorImage: Option[String] = None,
      instanceType: Option[String] = None,
      volumeSizeInGB: Option[Int] = None,
      ruleParameters: Option[RuleParameters] = None
    ): DebugRuleConfiguration =
      DebugRuleConfiguration
        .builder
        .ifSome(ruleConfigurationName)(_.ruleConfigurationName(_))
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(ruleEvaluatorImage)(_.ruleEvaluatorImage(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(ruleParameters)(_.ruleParameters(_))
        .build

    def debugRuleEvaluationStatus(
      ruleConfigurationName: Option[String] = None,
      ruleEvaluationJobArn: Option[String] = None,
      ruleEvaluationStatus: Option[String] = None,
      statusDetails: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): DebugRuleEvaluationStatus =
      DebugRuleEvaluationStatus
        .builder
        .ifSome(ruleConfigurationName)(_.ruleConfigurationName(_))
        .ifSome(ruleEvaluationJobArn)(_.ruleEvaluationJobArn(_))
        .ifSome(ruleEvaluationStatus)(_.ruleEvaluationStatus(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def deleteActionRequest(
      actionName: Option[String] = None
    ): DeleteActionRequest =
      DeleteActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .build

    def deleteActionResponse(
      actionArn: Option[String] = None
    ): DeleteActionResponse =
      DeleteActionResponse
        .builder
        .ifSome(actionArn)(_.actionArn(_))
        .build

    def deleteAlgorithmInput(
      algorithmName: Option[String] = None
    ): DeleteAlgorithmInput =
      DeleteAlgorithmInput
        .builder
        .ifSome(algorithmName)(_.algorithmName(_))
        .build

    def deleteAppImageConfigRequest(
      appImageConfigName: Option[String] = None
    ): DeleteAppImageConfigRequest =
      DeleteAppImageConfigRequest
        .builder
        .ifSome(appImageConfigName)(_.appImageConfigName(_))
        .build

    def deleteAppRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      appType: Option[String] = None,
      appName: Option[String] = None
    ): DeleteAppRequest =
      DeleteAppRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(appType)(_.appType(_))
        .ifSome(appName)(_.appName(_))
        .build

    def deleteArtifactRequest(
      artifactArn: Option[String] = None,
      source: Option[ArtifactSource] = None
    ): DeleteArtifactRequest =
      DeleteArtifactRequest
        .builder
        .ifSome(artifactArn)(_.artifactArn(_))
        .ifSome(source)(_.source(_))
        .build

    def deleteArtifactResponse(
      artifactArn: Option[String] = None
    ): DeleteArtifactResponse =
      DeleteArtifactResponse
        .builder
        .ifSome(artifactArn)(_.artifactArn(_))
        .build

    def deleteAssociationRequest(
      sourceArn: Option[String] = None,
      destinationArn: Option[String] = None
    ): DeleteAssociationRequest =
      DeleteAssociationRequest
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .build

    def deleteAssociationResponse(
      sourceArn: Option[String] = None,
      destinationArn: Option[String] = None
    ): DeleteAssociationResponse =
      DeleteAssociationResponse
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .build

    def deleteCodeRepositoryInput(
      codeRepositoryName: Option[String] = None
    ): DeleteCodeRepositoryInput =
      DeleteCodeRepositoryInput
        .builder
        .ifSome(codeRepositoryName)(_.codeRepositoryName(_))
        .build

    def deleteContextRequest(
      contextName: Option[String] = None
    ): DeleteContextRequest =
      DeleteContextRequest
        .builder
        .ifSome(contextName)(_.contextName(_))
        .build

    def deleteContextResponse(
      contextArn: Option[String] = None
    ): DeleteContextResponse =
      DeleteContextResponse
        .builder
        .ifSome(contextArn)(_.contextArn(_))
        .build

    def deleteDataQualityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DeleteDataQualityJobDefinitionRequest =
      DeleteDataQualityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def deleteDeviceFleetRequest(
      deviceFleetName: Option[String] = None
    ): DeleteDeviceFleetRequest =
      DeleteDeviceFleetRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .build

    def deleteDomainRequest(
      domainId: Option[String] = None,
      retentionPolicy: Option[RetentionPolicy] = None
    ): DeleteDomainRequest =
      DeleteDomainRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(retentionPolicy)(_.retentionPolicy(_))
        .build

    def deleteEndpointConfigInput(
      endpointConfigName: Option[String] = None
    ): DeleteEndpointConfigInput =
      DeleteEndpointConfigInput
        .builder
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .build

    def deleteEndpointInput(
      endpointName: Option[String] = None
    ): DeleteEndpointInput =
      DeleteEndpointInput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .build

    def deleteExperimentRequest(
      experimentName: Option[String] = None
    ): DeleteExperimentRequest =
      DeleteExperimentRequest
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .build

    def deleteExperimentResponse(
      experimentArn: Option[String] = None
    ): DeleteExperimentResponse =
      DeleteExperimentResponse
        .builder
        .ifSome(experimentArn)(_.experimentArn(_))
        .build

    def deleteFeatureGroupRequest(
      featureGroupName: Option[String] = None
    ): DeleteFeatureGroupRequest =
      DeleteFeatureGroupRequest
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .build

    def deleteFlowDefinitionRequest(
      flowDefinitionName: Option[String] = None
    ): DeleteFlowDefinitionRequest =
      DeleteFlowDefinitionRequest
        .builder
        .ifSome(flowDefinitionName)(_.flowDefinitionName(_))
        .build

    def deleteFlowDefinitionResponse(

    ): DeleteFlowDefinitionResponse =
      DeleteFlowDefinitionResponse
        .builder

        .build

    def deleteHumanTaskUiRequest(
      humanTaskUiName: Option[String] = None
    ): DeleteHumanTaskUiRequest =
      DeleteHumanTaskUiRequest
        .builder
        .ifSome(humanTaskUiName)(_.humanTaskUiName(_))
        .build

    def deleteHumanTaskUiResponse(

    ): DeleteHumanTaskUiResponse =
      DeleteHumanTaskUiResponse
        .builder

        .build

    def deleteImageRequest(
      imageName: Option[String] = None
    ): DeleteImageRequest =
      DeleteImageRequest
        .builder
        .ifSome(imageName)(_.imageName(_))
        .build

    def deleteImageResponse(

    ): DeleteImageResponse =
      DeleteImageResponse
        .builder

        .build

    def deleteImageVersionRequest(
      imageName: Option[String] = None,
      version: Option[Int] = None
    ): DeleteImageVersionRequest =
      DeleteImageVersionRequest
        .builder
        .ifSome(imageName)(_.imageName(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteImageVersionResponse(

    ): DeleteImageVersionResponse =
      DeleteImageVersionResponse
        .builder

        .build

    def deleteModelBiasJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DeleteModelBiasJobDefinitionRequest =
      DeleteModelBiasJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def deleteModelExplainabilityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DeleteModelExplainabilityJobDefinitionRequest =
      DeleteModelExplainabilityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def deleteModelInput(
      modelName: Option[String] = None
    ): DeleteModelInput =
      DeleteModelInput
        .builder
        .ifSome(modelName)(_.modelName(_))
        .build

    def deleteModelPackageGroupInput(
      modelPackageGroupName: Option[String] = None
    ): DeleteModelPackageGroupInput =
      DeleteModelPackageGroupInput
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .build

    def deleteModelPackageGroupPolicyInput(
      modelPackageGroupName: Option[String] = None
    ): DeleteModelPackageGroupPolicyInput =
      DeleteModelPackageGroupPolicyInput
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .build

    def deleteModelPackageInput(
      modelPackageName: Option[String] = None
    ): DeleteModelPackageInput =
      DeleteModelPackageInput
        .builder
        .ifSome(modelPackageName)(_.modelPackageName(_))
        .build

    def deleteModelQualityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DeleteModelQualityJobDefinitionRequest =
      DeleteModelQualityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def deleteMonitoringScheduleRequest(
      monitoringScheduleName: Option[String] = None
    ): DeleteMonitoringScheduleRequest =
      DeleteMonitoringScheduleRequest
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .build

    def deleteNotebookInstanceInput(
      notebookInstanceName: Option[String] = None
    ): DeleteNotebookInstanceInput =
      DeleteNotebookInstanceInput
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .build

    def deleteNotebookInstanceLifecycleConfigInput(
      notebookInstanceLifecycleConfigName: Option[String] = None
    ): DeleteNotebookInstanceLifecycleConfigInput =
      DeleteNotebookInstanceLifecycleConfigInput
        .builder
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .build

    def deletePipelineRequest(
      pipelineName: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): DeletePipelineRequest =
      DeletePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def deletePipelineResponse(
      pipelineArn: Option[String] = None
    ): DeletePipelineResponse =
      DeletePipelineResponse
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .build

    def deleteProjectInput(
      projectName: Option[String] = None
    ): DeleteProjectInput =
      DeleteProjectInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def deleteTagsInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): DeleteTagsInput =
      DeleteTagsInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def deleteTagsOutput(

    ): DeleteTagsOutput =
      DeleteTagsOutput
        .builder

        .build

    def deleteTrialComponentRequest(
      trialComponentName: Option[String] = None
    ): DeleteTrialComponentRequest =
      DeleteTrialComponentRequest
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .build

    def deleteTrialComponentResponse(
      trialComponentArn: Option[String] = None
    ): DeleteTrialComponentResponse =
      DeleteTrialComponentResponse
        .builder
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .build

    def deleteTrialRequest(
      trialName: Option[String] = None
    ): DeleteTrialRequest =
      DeleteTrialRequest
        .builder
        .ifSome(trialName)(_.trialName(_))
        .build

    def deleteTrialResponse(
      trialArn: Option[String] = None
    ): DeleteTrialResponse =
      DeleteTrialResponse
        .builder
        .ifSome(trialArn)(_.trialArn(_))
        .build

    def deleteUserProfileRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None
    ): DeleteUserProfileRequest =
      DeleteUserProfileRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .build

    def deleteWorkforceRequest(
      workforceName: Option[String] = None
    ): DeleteWorkforceRequest =
      DeleteWorkforceRequest
        .builder
        .ifSome(workforceName)(_.workforceName(_))
        .build

    def deleteWorkforceResponse(

    ): DeleteWorkforceResponse =
      DeleteWorkforceResponse
        .builder

        .build

    def deleteWorkteamRequest(
      workteamName: Option[String] = None
    ): DeleteWorkteamRequest =
      DeleteWorkteamRequest
        .builder
        .ifSome(workteamName)(_.workteamName(_))
        .build

    def deleteWorkteamResponse(
      success: Option[Boolean] = None
    ): DeleteWorkteamResponse =
      DeleteWorkteamResponse
        .builder
        .ifSome(success)(_.success(_))
        .build

    def deployedImage(
      specifiedImage: Option[String] = None,
      resolvedImage: Option[String] = None,
      resolutionTime: Option[Timestamp] = None
    ): DeployedImage =
      DeployedImage
        .builder
        .ifSome(specifiedImage)(_.specifiedImage(_))
        .ifSome(resolvedImage)(_.resolvedImage(_))
        .ifSome(resolutionTime)(_.resolutionTime(_))
        .build

    def deploymentConfig(
      blueGreenUpdatePolicy: Option[BlueGreenUpdatePolicy] = None,
      autoRollbackConfiguration: Option[AutoRollbackConfig] = None
    ): DeploymentConfig =
      DeploymentConfig
        .builder
        .ifSome(blueGreenUpdatePolicy)(_.blueGreenUpdatePolicy(_))
        .ifSome(autoRollbackConfiguration)(_.autoRollbackConfiguration(_))
        .build

    def deregisterDevicesRequest(
      deviceFleetName: Option[String] = None,
      deviceNames: Option[List[DeviceName]] = None
    ): DeregisterDevicesRequest =
      DeregisterDevicesRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(deviceNames)(_.deviceNames(_))
        .build

    def describeActionRequest(
      actionName: Option[String] = None
    ): DescribeActionRequest =
      DescribeActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .build

    def describeActionResponse(
      actionName: Option[String] = None,
      actionArn: Option[String] = None,
      source: Option[ActionSource] = None,
      actionType: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      metadataProperties: Option[MetadataProperties] = None
    ): DescribeActionResponse =
      DescribeActionResponse
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(actionArn)(_.actionArn(_))
        .ifSome(source)(_.source(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .build

    def describeAlgorithmInput(
      algorithmName: Option[String] = None
    ): DescribeAlgorithmInput =
      DescribeAlgorithmInput
        .builder
        .ifSome(algorithmName)(_.algorithmName(_))
        .build

    def describeAlgorithmOutput(
      algorithmName: Option[String] = None,
      algorithmArn: Option[String] = None,
      algorithmDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      trainingSpecification: Option[TrainingSpecification] = None,
      inferenceSpecification: Option[InferenceSpecification] = None,
      validationSpecification: Option[AlgorithmValidationSpecification] = None,
      algorithmStatus: Option[String] = None,
      algorithmStatusDetails: Option[AlgorithmStatusDetails] = None,
      productId: Option[String] = None,
      certifyForMarketplace: Option[Boolean] = None
    ): DescribeAlgorithmOutput =
      DescribeAlgorithmOutput
        .builder
        .ifSome(algorithmName)(_.algorithmName(_))
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .ifSome(algorithmDescription)(_.algorithmDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(trainingSpecification)(_.trainingSpecification(_))
        .ifSome(inferenceSpecification)(_.inferenceSpecification(_))
        .ifSome(validationSpecification)(_.validationSpecification(_))
        .ifSome(algorithmStatus)(_.algorithmStatus(_))
        .ifSome(algorithmStatusDetails)(_.algorithmStatusDetails(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(certifyForMarketplace)(_.certifyForMarketplace(_))
        .build

    def describeAppImageConfigRequest(
      appImageConfigName: Option[String] = None
    ): DescribeAppImageConfigRequest =
      DescribeAppImageConfigRequest
        .builder
        .ifSome(appImageConfigName)(_.appImageConfigName(_))
        .build

    def describeAppImageConfigResponse(
      appImageConfigArn: Option[String] = None,
      appImageConfigName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      kernelGatewayImageConfig: Option[KernelGatewayImageConfig] = None
    ): DescribeAppImageConfigResponse =
      DescribeAppImageConfigResponse
        .builder
        .ifSome(appImageConfigArn)(_.appImageConfigArn(_))
        .ifSome(appImageConfigName)(_.appImageConfigName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(kernelGatewayImageConfig)(_.kernelGatewayImageConfig(_))
        .build

    def describeAppRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      appType: Option[String] = None,
      appName: Option[String] = None
    ): DescribeAppRequest =
      DescribeAppRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(appType)(_.appType(_))
        .ifSome(appName)(_.appName(_))
        .build

    def describeAppResponse(
      appArn: Option[String] = None,
      appType: Option[String] = None,
      appName: Option[String] = None,
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      status: Option[String] = None,
      lastHealthCheckTimestamp: Option[Timestamp] = None,
      lastUserActivityTimestamp: Option[Timestamp] = None,
      creationTime: Option[CreationTime] = None,
      failureReason: Option[String] = None,
      resourceSpec: Option[ResourceSpec] = None
    ): DescribeAppResponse =
      DescribeAppResponse
        .builder
        .ifSome(appArn)(_.appArn(_))
        .ifSome(appType)(_.appType(_))
        .ifSome(appName)(_.appName(_))
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastHealthCheckTimestamp)(_.lastHealthCheckTimestamp(_))
        .ifSome(lastUserActivityTimestamp)(_.lastUserActivityTimestamp(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(resourceSpec)(_.resourceSpec(_))
        .build

    def describeArtifactRequest(
      artifactArn: Option[String] = None
    ): DescribeArtifactRequest =
      DescribeArtifactRequest
        .builder
        .ifSome(artifactArn)(_.artifactArn(_))
        .build

    def describeArtifactResponse(
      artifactName: Option[String] = None,
      artifactArn: Option[String] = None,
      source: Option[ArtifactSource] = None,
      artifactType: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      metadataProperties: Option[MetadataProperties] = None
    ): DescribeArtifactResponse =
      DescribeArtifactResponse
        .builder
        .ifSome(artifactName)(_.artifactName(_))
        .ifSome(artifactArn)(_.artifactArn(_))
        .ifSome(source)(_.source(_))
        .ifSome(artifactType)(_.artifactType(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .build

    def describeAutoMLJobRequest(
      autoMLJobName: Option[String] = None
    ): DescribeAutoMLJobRequest =
      DescribeAutoMLJobRequest
        .builder
        .ifSome(autoMLJobName)(_.autoMLJobName(_))
        .build

    def describeAutoMLJobResponse(
      autoMLJobName: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      inputDataConfig: Option[List[AutoMLChannel]] = None,
      outputDataConfig: Option[AutoMLOutputDataConfig] = None,
      roleArn: Option[String] = None,
      autoMLJobObjective: Option[AutoMLJobObjective] = None,
      problemType: Option[String] = None,
      autoMLJobConfig: Option[AutoMLJobConfig] = None,
      creationTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      failureReason: Option[String] = None,
      partialFailureReasons: Option[List[AutoMLPartialFailureReason]] = None,
      bestCandidate: Option[AutoMLCandidate] = None,
      autoMLJobStatus: Option[String] = None,
      autoMLJobSecondaryStatus: Option[String] = None,
      generateCandidateDefinitionsOnly: Option[Boolean] = None,
      autoMLJobArtifacts: Option[AutoMLJobArtifacts] = None,
      resolvedAttributes: Option[ResolvedAttributes] = None,
      modelDeployConfig: Option[ModelDeployConfig] = None,
      modelDeployResult: Option[ModelDeployResult] = None
    ): DescribeAutoMLJobResponse =
      DescribeAutoMLJobResponse
        .builder
        .ifSome(autoMLJobName)(_.autoMLJobName(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(autoMLJobObjective)(_.autoMLJobObjective(_))
        .ifSome(problemType)(_.problemType(_))
        .ifSome(autoMLJobConfig)(_.autoMLJobConfig(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(partialFailureReasons)(_.partialFailureReasons(_))
        .ifSome(bestCandidate)(_.bestCandidate(_))
        .ifSome(autoMLJobStatus)(_.autoMLJobStatus(_))
        .ifSome(autoMLJobSecondaryStatus)(_.autoMLJobSecondaryStatus(_))
        .ifSome(generateCandidateDefinitionsOnly)(_.generateCandidateDefinitionsOnly(_))
        .ifSome(autoMLJobArtifacts)(_.autoMLJobArtifacts(_))
        .ifSome(resolvedAttributes)(_.resolvedAttributes(_))
        .ifSome(modelDeployConfig)(_.modelDeployConfig(_))
        .ifSome(modelDeployResult)(_.modelDeployResult(_))
        .build

    def describeCodeRepositoryInput(
      codeRepositoryName: Option[String] = None
    ): DescribeCodeRepositoryInput =
      DescribeCodeRepositoryInput
        .builder
        .ifSome(codeRepositoryName)(_.codeRepositoryName(_))
        .build

    def describeCodeRepositoryOutput(
      codeRepositoryName: Option[String] = None,
      codeRepositoryArn: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      gitConfig: Option[GitConfig] = None
    ): DescribeCodeRepositoryOutput =
      DescribeCodeRepositoryOutput
        .builder
        .ifSome(codeRepositoryName)(_.codeRepositoryName(_))
        .ifSome(codeRepositoryArn)(_.codeRepositoryArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(gitConfig)(_.gitConfig(_))
        .build

    def describeCompilationJobRequest(
      compilationJobName: Option[String] = None
    ): DescribeCompilationJobRequest =
      DescribeCompilationJobRequest
        .builder
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .build

    def describeCompilationJobResponse(
      compilationJobName: Option[String] = None,
      compilationJobArn: Option[String] = None,
      compilationJobStatus: Option[String] = None,
      compilationStartTime: Option[Timestamp] = None,
      compilationEndTime: Option[Timestamp] = None,
      stoppingCondition: Option[StoppingCondition] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      failureReason: Option[String] = None,
      modelArtifacts: Option[ModelArtifacts] = None,
      modelDigests: Option[ModelDigests] = None,
      roleArn: Option[String] = None,
      inputConfig: Option[InputConfig] = None,
      outputConfig: Option[OutputConfig] = None
    ): DescribeCompilationJobResponse =
      DescribeCompilationJobResponse
        .builder
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .ifSome(compilationJobArn)(_.compilationJobArn(_))
        .ifSome(compilationJobStatus)(_.compilationJobStatus(_))
        .ifSome(compilationStartTime)(_.compilationStartTime(_))
        .ifSome(compilationEndTime)(_.compilationEndTime(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(modelArtifacts)(_.modelArtifacts(_))
        .ifSome(modelDigests)(_.modelDigests(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(inputConfig)(_.inputConfig(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .build

    def describeContextRequest(
      contextName: Option[String] = None
    ): DescribeContextRequest =
      DescribeContextRequest
        .builder
        .ifSome(contextName)(_.contextName(_))
        .build

    def describeContextResponse(
      contextName: Option[String] = None,
      contextArn: Option[String] = None,
      source: Option[ContextSource] = None,
      contextType: Option[String] = None,
      description: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None
    ): DescribeContextResponse =
      DescribeContextResponse
        .builder
        .ifSome(contextName)(_.contextName(_))
        .ifSome(contextArn)(_.contextArn(_))
        .ifSome(source)(_.source(_))
        .ifSome(contextType)(_.contextType(_))
        .ifSome(description)(_.description(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .build

    def describeDataQualityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DescribeDataQualityJobDefinitionRequest =
      DescribeDataQualityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def describeDataQualityJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None,
      jobDefinitionName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      dataQualityBaselineConfig: Option[DataQualityBaselineConfig] = None,
      dataQualityAppSpecification: Option[DataQualityAppSpecification] = None,
      dataQualityJobInput: Option[DataQualityJobInput] = None,
      dataQualityJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None
    ): DescribeDataQualityJobDefinitionResponse =
      DescribeDataQualityJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(dataQualityBaselineConfig)(_.dataQualityBaselineConfig(_))
        .ifSome(dataQualityAppSpecification)(_.dataQualityAppSpecification(_))
        .ifSome(dataQualityJobInput)(_.dataQualityJobInput(_))
        .ifSome(dataQualityJobOutputConfig)(_.dataQualityJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .build

    def describeDeviceFleetRequest(
      deviceFleetName: Option[String] = None
    ): DescribeDeviceFleetRequest =
      DescribeDeviceFleetRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .build

    def describeDeviceFleetResponse(
      deviceFleetName: Option[String] = None,
      deviceFleetArn: Option[String] = None,
      outputConfig: Option[EdgeOutputConfig] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      iotRoleAlias: Option[String] = None
    ): DescribeDeviceFleetResponse =
      DescribeDeviceFleetResponse
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(deviceFleetArn)(_.deviceFleetArn(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(iotRoleAlias)(_.iotRoleAlias(_))
        .build

    def describeDeviceRequest(
      nextToken: Option[String] = None,
      deviceName: Option[String] = None,
      deviceFleetName: Option[String] = None
    ): DescribeDeviceRequest =
      DescribeDeviceRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .build

    def describeDeviceResponse(
      deviceArn: Option[String] = None,
      deviceName: Option[String] = None,
      description: Option[String] = None,
      deviceFleetName: Option[String] = None,
      iotThingName: Option[String] = None,
      registrationTime: Option[Timestamp] = None,
      latestHeartbeat: Option[Timestamp] = None,
      models: Option[List[EdgeModel]] = None,
      maxModels: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDeviceResponse =
      DescribeDeviceResponse
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(description)(_.description(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(iotThingName)(_.iotThingName(_))
        .ifSome(registrationTime)(_.registrationTime(_))
        .ifSome(latestHeartbeat)(_.latestHeartbeat(_))
        .ifSome(models)(_.models(_))
        .ifSome(maxModels)(_.maxModels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDomainRequest(
      domainId: Option[String] = None
    ): DescribeDomainRequest =
      DescribeDomainRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .build

    def describeDomainResponse(
      domainArn: Option[String] = None,
      domainId: Option[String] = None,
      domainName: Option[String] = None,
      homeEfsFileSystemId: Option[String] = None,
      singleSignOnManagedApplicationInstanceId: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      failureReason: Option[String] = None,
      authMode: Option[String] = None,
      defaultUserSettings: Option[UserSettings] = None,
      appNetworkAccessType: Option[String] = None,
      homeEfsFileSystemKmsKeyId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      url: Option[String] = None,
      vpcId: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): DescribeDomainResponse =
      DescribeDomainResponse
        .builder
        .ifSome(domainArn)(_.domainArn(_))
        .ifSome(domainId)(_.domainId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(homeEfsFileSystemId)(_.homeEfsFileSystemId(_))
        .ifSome(singleSignOnManagedApplicationInstanceId)(_.singleSignOnManagedApplicationInstanceId(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(authMode)(_.authMode(_))
        .ifSome(defaultUserSettings)(_.defaultUserSettings(_))
        .ifSome(appNetworkAccessType)(_.appNetworkAccessType(_))
        .ifSome(homeEfsFileSystemKmsKeyId)(_.homeEfsFileSystemKmsKeyId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(url)(_.url(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def describeEdgePackagingJobRequest(
      edgePackagingJobName: Option[String] = None
    ): DescribeEdgePackagingJobRequest =
      DescribeEdgePackagingJobRequest
        .builder
        .ifSome(edgePackagingJobName)(_.edgePackagingJobName(_))
        .build

    def describeEdgePackagingJobResponse(
      edgePackagingJobArn: Option[String] = None,
      edgePackagingJobName: Option[String] = None,
      compilationJobName: Option[String] = None,
      modelName: Option[String] = None,
      modelVersion: Option[String] = None,
      roleArn: Option[String] = None,
      outputConfig: Option[EdgeOutputConfig] = None,
      resourceKey: Option[String] = None,
      edgePackagingJobStatus: Option[String] = None,
      edgePackagingJobStatusMessage: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      modelArtifact: Option[String] = None,
      modelSignature: Option[String] = None,
      presetDeploymentOutput: Option[EdgePresetDeploymentOutput] = None
    ): DescribeEdgePackagingJobResponse =
      DescribeEdgePackagingJobResponse
        .builder
        .ifSome(edgePackagingJobArn)(_.edgePackagingJobArn(_))
        .ifSome(edgePackagingJobName)(_.edgePackagingJobName(_))
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(resourceKey)(_.resourceKey(_))
        .ifSome(edgePackagingJobStatus)(_.edgePackagingJobStatus(_))
        .ifSome(edgePackagingJobStatusMessage)(_.edgePackagingJobStatusMessage(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(modelArtifact)(_.modelArtifact(_))
        .ifSome(modelSignature)(_.modelSignature(_))
        .ifSome(presetDeploymentOutput)(_.presetDeploymentOutput(_))
        .build

    def describeEndpointConfigInput(
      endpointConfigName: Option[String] = None
    ): DescribeEndpointConfigInput =
      DescribeEndpointConfigInput
        .builder
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .build

    def describeEndpointConfigOutput(
      endpointConfigName: Option[String] = None,
      endpointConfigArn: Option[String] = None,
      productionVariants: Option[List[ProductionVariant]] = None,
      dataCaptureConfig: Option[DataCaptureConfig] = None,
      kmsKeyId: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): DescribeEndpointConfigOutput =
      DescribeEndpointConfigOutput
        .builder
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .ifSome(endpointConfigArn)(_.endpointConfigArn(_))
        .ifSome(productionVariants)(_.productionVariants(_))
        .ifSome(dataCaptureConfig)(_.dataCaptureConfig(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeEndpointInput(
      endpointName: Option[String] = None
    ): DescribeEndpointInput =
      DescribeEndpointInput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .build

    def describeEndpointOutput(
      endpointName: Option[String] = None,
      endpointArn: Option[String] = None,
      endpointConfigName: Option[String] = None,
      productionVariants: Option[List[ProductionVariantSummary]] = None,
      dataCaptureConfig: Option[DataCaptureConfigSummary] = None,
      endpointStatus: Option[String] = None,
      failureReason: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastDeploymentConfig: Option[DeploymentConfig] = None
    ): DescribeEndpointOutput =
      DescribeEndpointOutput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .ifSome(productionVariants)(_.productionVariants(_))
        .ifSome(dataCaptureConfig)(_.dataCaptureConfig(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastDeploymentConfig)(_.lastDeploymentConfig(_))
        .build

    def describeExperimentRequest(
      experimentName: Option[String] = None
    ): DescribeExperimentRequest =
      DescribeExperimentRequest
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .build

    def describeExperimentResponse(
      experimentName: Option[String] = None,
      experimentArn: Option[String] = None,
      displayName: Option[String] = None,
      source: Option[ExperimentSource] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None
    ): DescribeExperimentResponse =
      DescribeExperimentResponse
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(experimentArn)(_.experimentArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(source)(_.source(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .build

    def describeFeatureGroupRequest(
      featureGroupName: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeFeatureGroupRequest =
      DescribeFeatureGroupRequest
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFeatureGroupResponse(
      featureGroupArn: Option[String] = None,
      featureGroupName: Option[String] = None,
      recordIdentifierFeatureName: Option[String] = None,
      eventTimeFeatureName: Option[String] = None,
      featureDefinitions: Option[List[FeatureDefinition]] = None,
      creationTime: Option[CreationTime] = None,
      onlineStoreConfig: Option[OnlineStoreConfig] = None,
      offlineStoreConfig: Option[OfflineStoreConfig] = None,
      roleArn: Option[String] = None,
      featureGroupStatus: Option[String] = None,
      offlineStoreStatus: Option[OfflineStoreStatus] = None,
      failureReason: Option[String] = None,
      description: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeFeatureGroupResponse =
      DescribeFeatureGroupResponse
        .builder
        .ifSome(featureGroupArn)(_.featureGroupArn(_))
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifierFeatureName)(_.recordIdentifierFeatureName(_))
        .ifSome(eventTimeFeatureName)(_.eventTimeFeatureName(_))
        .ifSome(featureDefinitions)(_.featureDefinitions(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(onlineStoreConfig)(_.onlineStoreConfig(_))
        .ifSome(offlineStoreConfig)(_.offlineStoreConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(featureGroupStatus)(_.featureGroupStatus(_))
        .ifSome(offlineStoreStatus)(_.offlineStoreStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(description)(_.description(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFlowDefinitionRequest(
      flowDefinitionName: Option[String] = None
    ): DescribeFlowDefinitionRequest =
      DescribeFlowDefinitionRequest
        .builder
        .ifSome(flowDefinitionName)(_.flowDefinitionName(_))
        .build

    def describeFlowDefinitionResponse(
      flowDefinitionArn: Option[String] = None,
      flowDefinitionName: Option[String] = None,
      flowDefinitionStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      humanLoopRequestSource: Option[HumanLoopRequestSource] = None,
      humanLoopActivationConfig: Option[HumanLoopActivationConfig] = None,
      humanLoopConfig: Option[HumanLoopConfig] = None,
      outputConfig: Option[FlowDefinitionOutputConfig] = None,
      roleArn: Option[String] = None,
      failureReason: Option[String] = None
    ): DescribeFlowDefinitionResponse =
      DescribeFlowDefinitionResponse
        .builder
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .ifSome(flowDefinitionName)(_.flowDefinitionName(_))
        .ifSome(flowDefinitionStatus)(_.flowDefinitionStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(humanLoopRequestSource)(_.humanLoopRequestSource(_))
        .ifSome(humanLoopActivationConfig)(_.humanLoopActivationConfig(_))
        .ifSome(humanLoopConfig)(_.humanLoopConfig(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def describeHumanTaskUiRequest(
      humanTaskUiName: Option[String] = None
    ): DescribeHumanTaskUiRequest =
      DescribeHumanTaskUiRequest
        .builder
        .ifSome(humanTaskUiName)(_.humanTaskUiName(_))
        .build

    def describeHumanTaskUiResponse(
      humanTaskUiArn: Option[String] = None,
      humanTaskUiName: Option[String] = None,
      humanTaskUiStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      uiTemplate: Option[UiTemplateInfo] = None
    ): DescribeHumanTaskUiResponse =
      DescribeHumanTaskUiResponse
        .builder
        .ifSome(humanTaskUiArn)(_.humanTaskUiArn(_))
        .ifSome(humanTaskUiName)(_.humanTaskUiName(_))
        .ifSome(humanTaskUiStatus)(_.humanTaskUiStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(uiTemplate)(_.uiTemplate(_))
        .build

    def describeHyperParameterTuningJobRequest(
      hyperParameterTuningJobName: Option[String] = None
    ): DescribeHyperParameterTuningJobRequest =
      DescribeHyperParameterTuningJobRequest
        .builder
        .ifSome(hyperParameterTuningJobName)(_.hyperParameterTuningJobName(_))
        .build

    def describeHyperParameterTuningJobResponse(
      hyperParameterTuningJobName: Option[String] = None,
      hyperParameterTuningJobArn: Option[String] = None,
      hyperParameterTuningJobConfig: Option[HyperParameterTuningJobConfig] = None,
      trainingJobDefinition: Option[HyperParameterTrainingJobDefinition] = None,
      trainingJobDefinitions: Option[List[HyperParameterTrainingJobDefinition]] = None,
      hyperParameterTuningJobStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      hyperParameterTuningEndTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      trainingJobStatusCounters: Option[TrainingJobStatusCounters] = None,
      objectiveStatusCounters: Option[ObjectiveStatusCounters] = None,
      bestTrainingJob: Option[HyperParameterTrainingJobSummary] = None,
      overallBestTrainingJob: Option[HyperParameterTrainingJobSummary] = None,
      warmStartConfig: Option[HyperParameterTuningJobWarmStartConfig] = None,
      failureReason: Option[String] = None
    ): DescribeHyperParameterTuningJobResponse =
      DescribeHyperParameterTuningJobResponse
        .builder
        .ifSome(hyperParameterTuningJobName)(_.hyperParameterTuningJobName(_))
        .ifSome(hyperParameterTuningJobArn)(_.hyperParameterTuningJobArn(_))
        .ifSome(hyperParameterTuningJobConfig)(_.hyperParameterTuningJobConfig(_))
        .ifSome(trainingJobDefinition)(_.trainingJobDefinition(_))
        .ifSome(trainingJobDefinitions)(_.trainingJobDefinitions(_))
        .ifSome(hyperParameterTuningJobStatus)(_.hyperParameterTuningJobStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(hyperParameterTuningEndTime)(_.hyperParameterTuningEndTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(trainingJobStatusCounters)(_.trainingJobStatusCounters(_))
        .ifSome(objectiveStatusCounters)(_.objectiveStatusCounters(_))
        .ifSome(bestTrainingJob)(_.bestTrainingJob(_))
        .ifSome(overallBestTrainingJob)(_.overallBestTrainingJob(_))
        .ifSome(warmStartConfig)(_.warmStartConfig(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def describeImageRequest(
      imageName: Option[String] = None
    ): DescribeImageRequest =
      DescribeImageRequest
        .builder
        .ifSome(imageName)(_.imageName(_))
        .build

    def describeImageResponse(
      creationTime: Option[Timestamp] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      failureReason: Option[String] = None,
      imageArn: Option[String] = None,
      imageName: Option[String] = None,
      imageStatus: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None,
      roleArn: Option[String] = None
    ): DescribeImageResponse =
      DescribeImageResponse
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageStatus)(_.imageStatus(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def describeImageVersionRequest(
      imageName: Option[String] = None,
      version: Option[Int] = None
    ): DescribeImageVersionRequest =
      DescribeImageVersionRequest
        .builder
        .ifSome(imageName)(_.imageName(_))
        .ifSome(version)(_.version(_))
        .build

    def describeImageVersionResponse(
      baseImage: Option[String] = None,
      containerImage: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      failureReason: Option[String] = None,
      imageArn: Option[String] = None,
      imageVersionArn: Option[String] = None,
      imageVersionStatus: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None,
      version: Option[Int] = None
    ): DescribeImageVersionResponse =
      DescribeImageVersionResponse
        .builder
        .ifSome(baseImage)(_.baseImage(_))
        .ifSome(containerImage)(_.containerImage(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(imageVersionArn)(_.imageVersionArn(_))
        .ifSome(imageVersionStatus)(_.imageVersionStatus(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(version)(_.version(_))
        .build

    def describeLabelingJobRequest(
      labelingJobName: Option[String] = None
    ): DescribeLabelingJobRequest =
      DescribeLabelingJobRequest
        .builder
        .ifSome(labelingJobName)(_.labelingJobName(_))
        .build

    def describeLabelingJobResponse(
      labelingJobStatus: Option[String] = None,
      labelCounters: Option[LabelCounters] = None,
      failureReason: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      jobReferenceCode: Option[String] = None,
      labelingJobName: Option[String] = None,
      labelingJobArn: Option[String] = None,
      labelAttributeName: Option[String] = None,
      inputConfig: Option[LabelingJobInputConfig] = None,
      outputConfig: Option[LabelingJobOutputConfig] = None,
      roleArn: Option[String] = None,
      labelCategoryConfigS3Uri: Option[String] = None,
      stoppingConditions: Option[LabelingJobStoppingConditions] = None,
      labelingJobAlgorithmsConfig: Option[LabelingJobAlgorithmsConfig] = None,
      humanTaskConfig: Option[HumanTaskConfig] = None,
      tags: Option[List[Tag]] = None,
      labelingJobOutput: Option[LabelingJobOutput] = None
    ): DescribeLabelingJobResponse =
      DescribeLabelingJobResponse
        .builder
        .ifSome(labelingJobStatus)(_.labelingJobStatus(_))
        .ifSome(labelCounters)(_.labelCounters(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(jobReferenceCode)(_.jobReferenceCode(_))
        .ifSome(labelingJobName)(_.labelingJobName(_))
        .ifSome(labelingJobArn)(_.labelingJobArn(_))
        .ifSome(labelAttributeName)(_.labelAttributeName(_))
        .ifSome(inputConfig)(_.inputConfig(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(labelCategoryConfigS3Uri)(_.labelCategoryConfigS3Uri(_))
        .ifSome(stoppingConditions)(_.stoppingConditions(_))
        .ifSome(labelingJobAlgorithmsConfig)(_.labelingJobAlgorithmsConfig(_))
        .ifSome(humanTaskConfig)(_.humanTaskConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(labelingJobOutput)(_.labelingJobOutput(_))
        .build

    def describeModelBiasJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DescribeModelBiasJobDefinitionRequest =
      DescribeModelBiasJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def describeModelBiasJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None,
      jobDefinitionName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      modelBiasBaselineConfig: Option[ModelBiasBaselineConfig] = None,
      modelBiasAppSpecification: Option[ModelBiasAppSpecification] = None,
      modelBiasJobInput: Option[ModelBiasJobInput] = None,
      modelBiasJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None
    ): DescribeModelBiasJobDefinitionResponse =
      DescribeModelBiasJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modelBiasBaselineConfig)(_.modelBiasBaselineConfig(_))
        .ifSome(modelBiasAppSpecification)(_.modelBiasAppSpecification(_))
        .ifSome(modelBiasJobInput)(_.modelBiasJobInput(_))
        .ifSome(modelBiasJobOutputConfig)(_.modelBiasJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .build

    def describeModelExplainabilityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DescribeModelExplainabilityJobDefinitionRequest =
      DescribeModelExplainabilityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def describeModelExplainabilityJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None,
      jobDefinitionName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      modelExplainabilityBaselineConfig: Option[ModelExplainabilityBaselineConfig] = None,
      modelExplainabilityAppSpecification: Option[ModelExplainabilityAppSpecification] = None,
      modelExplainabilityJobInput: Option[ModelExplainabilityJobInput] = None,
      modelExplainabilityJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None
    ): DescribeModelExplainabilityJobDefinitionResponse =
      DescribeModelExplainabilityJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modelExplainabilityBaselineConfig)(_.modelExplainabilityBaselineConfig(_))
        .ifSome(modelExplainabilityAppSpecification)(_.modelExplainabilityAppSpecification(_))
        .ifSome(modelExplainabilityJobInput)(_.modelExplainabilityJobInput(_))
        .ifSome(modelExplainabilityJobOutputConfig)(_.modelExplainabilityJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .build

    def describeModelInput(
      modelName: Option[String] = None
    ): DescribeModelInput =
      DescribeModelInput
        .builder
        .ifSome(modelName)(_.modelName(_))
        .build

    def describeModelOutput(
      modelName: Option[String] = None,
      primaryContainer: Option[ContainerDefinition] = None,
      containers: Option[List[ContainerDefinition]] = None,
      inferenceExecutionConfig: Option[InferenceExecutionConfig] = None,
      executionRoleArn: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      creationTime: Option[Timestamp] = None,
      modelArn: Option[String] = None,
      enableNetworkIsolation: Option[Boolean] = None
    ): DescribeModelOutput =
      DescribeModelOutput
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(primaryContainer)(_.primaryContainer(_))
        .ifSome(containers)(_.containers(_))
        .ifSome(inferenceExecutionConfig)(_.inferenceExecutionConfig(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .build

    def describeModelPackageGroupInput(
      modelPackageGroupName: Option[String] = None
    ): DescribeModelPackageGroupInput =
      DescribeModelPackageGroupInput
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .build

    def describeModelPackageGroupOutput(
      modelPackageGroupName: Option[String] = None,
      modelPackageGroupArn: Option[String] = None,
      modelPackageGroupDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      createdBy: Option[UserContext] = None,
      modelPackageGroupStatus: Option[String] = None
    ): DescribeModelPackageGroupOutput =
      DescribeModelPackageGroupOutput
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageGroupArn)(_.modelPackageGroupArn(_))
        .ifSome(modelPackageGroupDescription)(_.modelPackageGroupDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(modelPackageGroupStatus)(_.modelPackageGroupStatus(_))
        .build

    def describeModelPackageInput(
      modelPackageName: Option[String] = None
    ): DescribeModelPackageInput =
      DescribeModelPackageInput
        .builder
        .ifSome(modelPackageName)(_.modelPackageName(_))
        .build

    def describeModelPackageOutput(
      modelPackageName: Option[String] = None,
      modelPackageGroupName: Option[String] = None,
      modelPackageVersion: Option[Int] = None,
      modelPackageArn: Option[String] = None,
      modelPackageDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      inferenceSpecification: Option[InferenceSpecification] = None,
      sourceAlgorithmSpecification: Option[SourceAlgorithmSpecification] = None,
      validationSpecification: Option[ModelPackageValidationSpecification] = None,
      modelPackageStatus: Option[String] = None,
      modelPackageStatusDetails: Option[ModelPackageStatusDetails] = None,
      certifyForMarketplace: Option[Boolean] = None,
      modelApprovalStatus: Option[String] = None,
      createdBy: Option[UserContext] = None,
      metadataProperties: Option[MetadataProperties] = None,
      modelMetrics: Option[ModelMetrics] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      approvalDescription: Option[String] = None
    ): DescribeModelPackageOutput =
      DescribeModelPackageOutput
        .builder
        .ifSome(modelPackageName)(_.modelPackageName(_))
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageVersion)(_.modelPackageVersion(_))
        .ifSome(modelPackageArn)(_.modelPackageArn(_))
        .ifSome(modelPackageDescription)(_.modelPackageDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(inferenceSpecification)(_.inferenceSpecification(_))
        .ifSome(sourceAlgorithmSpecification)(_.sourceAlgorithmSpecification(_))
        .ifSome(validationSpecification)(_.validationSpecification(_))
        .ifSome(modelPackageStatus)(_.modelPackageStatus(_))
        .ifSome(modelPackageStatusDetails)(_.modelPackageStatusDetails(_))
        .ifSome(certifyForMarketplace)(_.certifyForMarketplace(_))
        .ifSome(modelApprovalStatus)(_.modelApprovalStatus(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(modelMetrics)(_.modelMetrics(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(approvalDescription)(_.approvalDescription(_))
        .build

    def describeModelQualityJobDefinitionRequest(
      jobDefinitionName: Option[String] = None
    ): DescribeModelQualityJobDefinitionRequest =
      DescribeModelQualityJobDefinitionRequest
        .builder
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .build

    def describeModelQualityJobDefinitionResponse(
      jobDefinitionArn: Option[String] = None,
      jobDefinitionName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      modelQualityBaselineConfig: Option[ModelQualityBaselineConfig] = None,
      modelQualityAppSpecification: Option[ModelQualityAppSpecification] = None,
      modelQualityJobInput: Option[ModelQualityJobInput] = None,
      modelQualityJobOutputConfig: Option[MonitoringOutputConfig] = None,
      jobResources: Option[MonitoringResources] = None,
      networkConfig: Option[MonitoringNetworkConfig] = None,
      roleArn: Option[String] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None
    ): DescribeModelQualityJobDefinitionResponse =
      DescribeModelQualityJobDefinitionResponse
        .builder
        .ifSome(jobDefinitionArn)(_.jobDefinitionArn(_))
        .ifSome(jobDefinitionName)(_.jobDefinitionName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modelQualityBaselineConfig)(_.modelQualityBaselineConfig(_))
        .ifSome(modelQualityAppSpecification)(_.modelQualityAppSpecification(_))
        .ifSome(modelQualityJobInput)(_.modelQualityJobInput(_))
        .ifSome(modelQualityJobOutputConfig)(_.modelQualityJobOutputConfig(_))
        .ifSome(jobResources)(_.jobResources(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .build

    def describeMonitoringScheduleRequest(
      monitoringScheduleName: Option[String] = None
    ): DescribeMonitoringScheduleRequest =
      DescribeMonitoringScheduleRequest
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .build

    def describeMonitoringScheduleResponse(
      monitoringScheduleArn: Option[String] = None,
      monitoringScheduleName: Option[String] = None,
      monitoringScheduleStatus: Option[String] = None,
      monitoringType: Option[String] = None,
      failureReason: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      monitoringScheduleConfig: Option[MonitoringScheduleConfig] = None,
      endpointName: Option[String] = None,
      lastMonitoringExecutionSummary: Option[MonitoringExecutionSummary] = None
    ): DescribeMonitoringScheduleResponse =
      DescribeMonitoringScheduleResponse
        .builder
        .ifSome(monitoringScheduleArn)(_.monitoringScheduleArn(_))
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .ifSome(monitoringScheduleStatus)(_.monitoringScheduleStatus(_))
        .ifSome(monitoringType)(_.monitoringType(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(monitoringScheduleConfig)(_.monitoringScheduleConfig(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(lastMonitoringExecutionSummary)(_.lastMonitoringExecutionSummary(_))
        .build

    def describeNotebookInstanceInput(
      notebookInstanceName: Option[String] = None
    ): DescribeNotebookInstanceInput =
      DescribeNotebookInstanceInput
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .build

    def describeNotebookInstanceLifecycleConfigInput(
      notebookInstanceLifecycleConfigName: Option[String] = None
    ): DescribeNotebookInstanceLifecycleConfigInput =
      DescribeNotebookInstanceLifecycleConfigInput
        .builder
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .build

    def describeNotebookInstanceLifecycleConfigOutput(
      notebookInstanceLifecycleConfigArn: Option[String] = None,
      notebookInstanceLifecycleConfigName: Option[String] = None,
      onCreate: Option[List[NotebookInstanceLifecycleHook]] = None,
      onStart: Option[List[NotebookInstanceLifecycleHook]] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      creationTime: Option[CreationTime] = None
    ): DescribeNotebookInstanceLifecycleConfigOutput =
      DescribeNotebookInstanceLifecycleConfigOutput
        .builder
        .ifSome(notebookInstanceLifecycleConfigArn)(_.notebookInstanceLifecycleConfigArn(_))
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .ifSome(onCreate)(_.onCreate(_))
        .ifSome(onStart)(_.onStart(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeNotebookInstanceOutput(
      notebookInstanceArn: Option[String] = None,
      notebookInstanceName: Option[String] = None,
      notebookInstanceStatus: Option[String] = None,
      failureReason: Option[String] = None,
      url: Option[String] = None,
      instanceType: Option[String] = None,
      subnetId: Option[String] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      roleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      creationTime: Option[CreationTime] = None,
      notebookInstanceLifecycleConfigName: Option[String] = None,
      directInternetAccess: Option[String] = None,
      volumeSizeInGB: Option[Int] = None,
      acceleratorTypes: Option[List[NotebookInstanceAcceleratorType]] = None,
      defaultCodeRepository: Option[String] = None,
      additionalCodeRepositories: Option[List[CodeRepositoryNameOrUrl]] = None,
      rootAccess: Option[String] = None
    ): DescribeNotebookInstanceOutput =
      DescribeNotebookInstanceOutput
        .builder
        .ifSome(notebookInstanceArn)(_.notebookInstanceArn(_))
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .ifSome(notebookInstanceStatus)(_.notebookInstanceStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(url)(_.url(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .ifSome(directInternetAccess)(_.directInternetAccess(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(acceleratorTypes)(_.acceleratorTypes(_))
        .ifSome(defaultCodeRepository)(_.defaultCodeRepository(_))
        .ifSome(additionalCodeRepositories)(_.additionalCodeRepositories(_))
        .ifSome(rootAccess)(_.rootAccess(_))
        .build

    def describePipelineDefinitionForExecutionRequest(
      pipelineExecutionArn: Option[String] = None
    ): DescribePipelineDefinitionForExecutionRequest =
      DescribePipelineDefinitionForExecutionRequest
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .build

    def describePipelineDefinitionForExecutionResponse(
      pipelineDefinition: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): DescribePipelineDefinitionForExecutionResponse =
      DescribePipelineDefinitionForExecutionResponse
        .builder
        .ifSome(pipelineDefinition)(_.pipelineDefinition(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describePipelineExecutionRequest(
      pipelineExecutionArn: Option[String] = None
    ): DescribePipelineExecutionRequest =
      DescribePipelineExecutionRequest
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .build

    def describePipelineExecutionResponse(
      pipelineArn: Option[String] = None,
      pipelineExecutionArn: Option[String] = None,
      pipelineExecutionDisplayName: Option[String] = None,
      pipelineExecutionStatus: Option[String] = None,
      pipelineExecutionDescription: Option[String] = None,
      pipelineExperimentConfig: Option[PipelineExperimentConfig] = None,
      failureReason: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedBy: Option[UserContext] = None
    ): DescribePipelineExecutionResponse =
      DescribePipelineExecutionResponse
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .ifSome(pipelineExecutionDisplayName)(_.pipelineExecutionDisplayName(_))
        .ifSome(pipelineExecutionStatus)(_.pipelineExecutionStatus(_))
        .ifSome(pipelineExecutionDescription)(_.pipelineExecutionDescription(_))
        .ifSome(pipelineExperimentConfig)(_.pipelineExperimentConfig(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .build

    def describePipelineRequest(
      pipelineName: Option[String] = None
    ): DescribePipelineRequest =
      DescribePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .build

    def describePipelineResponse(
      pipelineArn: Option[String] = None,
      pipelineName: Option[String] = None,
      pipelineDisplayName: Option[String] = None,
      pipelineDefinition: Option[String] = None,
      pipelineDescription: Option[String] = None,
      roleArn: Option[String] = None,
      pipelineStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastRunTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedBy: Option[UserContext] = None
    ): DescribePipelineResponse =
      DescribePipelineResponse
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineDisplayName)(_.pipelineDisplayName(_))
        .ifSome(pipelineDefinition)(_.pipelineDefinition(_))
        .ifSome(pipelineDescription)(_.pipelineDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(pipelineStatus)(_.pipelineStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastRunTime)(_.lastRunTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .build

    def describeProcessingJobRequest(
      processingJobName: Option[String] = None
    ): DescribeProcessingJobRequest =
      DescribeProcessingJobRequest
        .builder
        .ifSome(processingJobName)(_.processingJobName(_))
        .build

    def describeProcessingJobResponse(
      processingInputs: Option[List[ProcessingInput]] = None,
      processingOutputConfig: Option[ProcessingOutputConfig] = None,
      processingJobName: Option[String] = None,
      processingResources: Option[ProcessingResources] = None,
      stoppingCondition: Option[ProcessingStoppingCondition] = None,
      appSpecification: Option[AppSpecification] = None,
      environment: Option[ProcessingEnvironmentMap] = None,
      networkConfig: Option[NetworkConfig] = None,
      roleArn: Option[String] = None,
      experimentConfig: Option[ExperimentConfig] = None,
      processingJobArn: Option[String] = None,
      processingJobStatus: Option[String] = None,
      exitMessage: Option[String] = None,
      failureReason: Option[String] = None,
      processingEndTime: Option[Timestamp] = None,
      processingStartTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None,
      monitoringScheduleArn: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      trainingJobArn: Option[String] = None
    ): DescribeProcessingJobResponse =
      DescribeProcessingJobResponse
        .builder
        .ifSome(processingInputs)(_.processingInputs(_))
        .ifSome(processingOutputConfig)(_.processingOutputConfig(_))
        .ifSome(processingJobName)(_.processingJobName(_))
        .ifSome(processingResources)(_.processingResources(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(appSpecification)(_.appSpecification(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .ifSome(processingJobArn)(_.processingJobArn(_))
        .ifSome(processingJobStatus)(_.processingJobStatus(_))
        .ifSome(exitMessage)(_.exitMessage(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(processingEndTime)(_.processingEndTime(_))
        .ifSome(processingStartTime)(_.processingStartTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(monitoringScheduleArn)(_.monitoringScheduleArn(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .build

    def describeProjectInput(
      projectName: Option[String] = None
    ): DescribeProjectInput =
      DescribeProjectInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def describeProjectOutput(
      projectArn: Option[String] = None,
      projectName: Option[String] = None,
      projectId: Option[String] = None,
      projectDescription: Option[String] = None,
      serviceCatalogProvisioningDetails: Option[ServiceCatalogProvisioningDetails] = None,
      serviceCatalogProvisionedProductDetails: Option[ServiceCatalogProvisionedProductDetails] = None,
      projectStatus: Option[String] = None,
      createdBy: Option[UserContext] = None,
      creationTime: Option[Timestamp] = None
    ): DescribeProjectOutput =
      DescribeProjectOutput
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(projectId)(_.projectId(_))
        .ifSome(projectDescription)(_.projectDescription(_))
        .ifSome(serviceCatalogProvisioningDetails)(_.serviceCatalogProvisioningDetails(_))
        .ifSome(serviceCatalogProvisionedProductDetails)(_.serviceCatalogProvisionedProductDetails(_))
        .ifSome(projectStatus)(_.projectStatus(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeSubscribedWorkteamRequest(
      workteamArn: Option[String] = None
    ): DescribeSubscribedWorkteamRequest =
      DescribeSubscribedWorkteamRequest
        .builder
        .ifSome(workteamArn)(_.workteamArn(_))
        .build

    def describeSubscribedWorkteamResponse(
      subscribedWorkteam: Option[SubscribedWorkteam] = None
    ): DescribeSubscribedWorkteamResponse =
      DescribeSubscribedWorkteamResponse
        .builder
        .ifSome(subscribedWorkteam)(_.subscribedWorkteam(_))
        .build

    def describeTrainingJobRequest(
      trainingJobName: Option[String] = None
    ): DescribeTrainingJobRequest =
      DescribeTrainingJobRequest
        .builder
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .build

    def describeTrainingJobResponse(
      trainingJobName: Option[String] = None,
      trainingJobArn: Option[String] = None,
      tuningJobArn: Option[String] = None,
      labelingJobArn: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      modelArtifacts: Option[ModelArtifacts] = None,
      trainingJobStatus: Option[String] = None,
      secondaryStatus: Option[String] = None,
      failureReason: Option[String] = None,
      hyperParameters: Option[HyperParameters] = None,
      algorithmSpecification: Option[AlgorithmSpecification] = None,
      roleArn: Option[String] = None,
      inputDataConfig: Option[List[Channel]] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      resourceConfig: Option[ResourceConfig] = None,
      vpcConfig: Option[VpcConfig] = None,
      stoppingCondition: Option[StoppingCondition] = None,
      creationTime: Option[Timestamp] = None,
      trainingStartTime: Option[Timestamp] = None,
      trainingEndTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      secondaryStatusTransitions: Option[List[SecondaryStatusTransition]] = None,
      finalMetricDataList: Option[List[MetricData]] = None,
      enableNetworkIsolation: Option[Boolean] = None,
      enableInterContainerTrafficEncryption: Option[Boolean] = None,
      enableManagedSpotTraining: Option[Boolean] = None,
      checkpointConfig: Option[CheckpointConfig] = None,
      trainingTimeInSeconds: Option[Int] = None,
      billableTimeInSeconds: Option[Int] = None,
      debugHookConfig: Option[DebugHookConfig] = None,
      experimentConfig: Option[ExperimentConfig] = None,
      debugRuleConfigurations: Option[List[DebugRuleConfiguration]] = None,
      tensorBoardOutputConfig: Option[TensorBoardOutputConfig] = None,
      debugRuleEvaluationStatuses: Option[List[DebugRuleEvaluationStatus]] = None,
      profilerConfig: Option[ProfilerConfig] = None,
      profilerRuleConfigurations: Option[List[ProfilerRuleConfiguration]] = None,
      profilerRuleEvaluationStatuses: Option[List[ProfilerRuleEvaluationStatus]] = None,
      profilingStatus: Option[String] = None,
      retryStrategy: Option[RetryStrategy] = None,
      environment: Option[TrainingEnvironmentMap] = None
    ): DescribeTrainingJobResponse =
      DescribeTrainingJobResponse
        .builder
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .ifSome(tuningJobArn)(_.tuningJobArn(_))
        .ifSome(labelingJobArn)(_.labelingJobArn(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(modelArtifacts)(_.modelArtifacts(_))
        .ifSome(trainingJobStatus)(_.trainingJobStatus(_))
        .ifSome(secondaryStatus)(_.secondaryStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(hyperParameters)(_.hyperParameters(_))
        .ifSome(algorithmSpecification)(_.algorithmSpecification(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(trainingStartTime)(_.trainingStartTime(_))
        .ifSome(trainingEndTime)(_.trainingEndTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(secondaryStatusTransitions)(_.secondaryStatusTransitions(_))
        .ifSome(finalMetricDataList)(_.finalMetricDataList(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .ifSome(enableInterContainerTrafficEncryption)(_.enableInterContainerTrafficEncryption(_))
        .ifSome(enableManagedSpotTraining)(_.enableManagedSpotTraining(_))
        .ifSome(checkpointConfig)(_.checkpointConfig(_))
        .ifSome(trainingTimeInSeconds)(_.trainingTimeInSeconds(_))
        .ifSome(billableTimeInSeconds)(_.billableTimeInSeconds(_))
        .ifSome(debugHookConfig)(_.debugHookConfig(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .ifSome(debugRuleConfigurations)(_.debugRuleConfigurations(_))
        .ifSome(tensorBoardOutputConfig)(_.tensorBoardOutputConfig(_))
        .ifSome(debugRuleEvaluationStatuses)(_.debugRuleEvaluationStatuses(_))
        .ifSome(profilerConfig)(_.profilerConfig(_))
        .ifSome(profilerRuleConfigurations)(_.profilerRuleConfigurations(_))
        .ifSome(profilerRuleEvaluationStatuses)(_.profilerRuleEvaluationStatuses(_))
        .ifSome(profilingStatus)(_.profilingStatus(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .ifSome(environment)(_.environment(_))
        .build

    def describeTransformJobRequest(
      transformJobName: Option[String] = None
    ): DescribeTransformJobRequest =
      DescribeTransformJobRequest
        .builder
        .ifSome(transformJobName)(_.transformJobName(_))
        .build

    def describeTransformJobResponse(
      transformJobName: Option[String] = None,
      transformJobArn: Option[String] = None,
      transformJobStatus: Option[String] = None,
      failureReason: Option[String] = None,
      modelName: Option[String] = None,
      maxConcurrentTransforms: Option[Int] = None,
      modelClientConfig: Option[ModelClientConfig] = None,
      maxPayloadInMB: Option[Int] = None,
      batchStrategy: Option[String] = None,
      environment: Option[TransformEnvironmentMap] = None,
      transformInput: Option[TransformInput] = None,
      transformOutput: Option[TransformOutput] = None,
      transformResources: Option[TransformResources] = None,
      creationTime: Option[Timestamp] = None,
      transformStartTime: Option[Timestamp] = None,
      transformEndTime: Option[Timestamp] = None,
      labelingJobArn: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      dataProcessing: Option[DataProcessing] = None,
      experimentConfig: Option[ExperimentConfig] = None
    ): DescribeTransformJobResponse =
      DescribeTransformJobResponse
        .builder
        .ifSome(transformJobName)(_.transformJobName(_))
        .ifSome(transformJobArn)(_.transformJobArn(_))
        .ifSome(transformJobStatus)(_.transformJobStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(maxConcurrentTransforms)(_.maxConcurrentTransforms(_))
        .ifSome(modelClientConfig)(_.modelClientConfig(_))
        .ifSome(maxPayloadInMB)(_.maxPayloadInMB(_))
        .ifSome(batchStrategy)(_.batchStrategy(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(transformInput)(_.transformInput(_))
        .ifSome(transformOutput)(_.transformOutput(_))
        .ifSome(transformResources)(_.transformResources(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(transformStartTime)(_.transformStartTime(_))
        .ifSome(transformEndTime)(_.transformEndTime(_))
        .ifSome(labelingJobArn)(_.labelingJobArn(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(dataProcessing)(_.dataProcessing(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .build

    def describeTrialComponentRequest(
      trialComponentName: Option[String] = None
    ): DescribeTrialComponentRequest =
      DescribeTrialComponentRequest
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .build

    def describeTrialComponentResponse(
      trialComponentName: Option[String] = None,
      trialComponentArn: Option[String] = None,
      displayName: Option[String] = None,
      source: Option[TrialComponentSource] = None,
      status: Option[TrialComponentStatus] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      parameters: Option[TrialComponentParameters] = None,
      inputArtifacts: Option[TrialComponentArtifacts] = None,
      outputArtifacts: Option[TrialComponentArtifacts] = None,
      metadataProperties: Option[MetadataProperties] = None,
      metrics: Option[List[TrialComponentMetricSummary]] = None
    ): DescribeTrialComponentResponse =
      DescribeTrialComponentResponse
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(source)(_.source(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def describeTrialRequest(
      trialName: Option[String] = None
    ): DescribeTrialRequest =
      DescribeTrialRequest
        .builder
        .ifSome(trialName)(_.trialName(_))
        .build

    def describeTrialResponse(
      trialName: Option[String] = None,
      trialArn: Option[String] = None,
      displayName: Option[String] = None,
      experimentName: Option[String] = None,
      source: Option[TrialSource] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      metadataProperties: Option[MetadataProperties] = None
    ): DescribeTrialResponse =
      DescribeTrialResponse
        .builder
        .ifSome(trialName)(_.trialName(_))
        .ifSome(trialArn)(_.trialArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(source)(_.source(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .build

    def describeUserProfileRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None
    ): DescribeUserProfileRequest =
      DescribeUserProfileRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .build

    def describeUserProfileResponse(
      domainId: Option[String] = None,
      userProfileArn: Option[String] = None,
      userProfileName: Option[String] = None,
      homeEfsFileSystemUid: Option[String] = None,
      status: Option[String] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      creationTime: Option[CreationTime] = None,
      failureReason: Option[String] = None,
      singleSignOnUserIdentifier: Option[String] = None,
      singleSignOnUserValue: Option[String] = None,
      userSettings: Option[UserSettings] = None
    ): DescribeUserProfileResponse =
      DescribeUserProfileResponse
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileArn)(_.userProfileArn(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(homeEfsFileSystemUid)(_.homeEfsFileSystemUid(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(singleSignOnUserIdentifier)(_.singleSignOnUserIdentifier(_))
        .ifSome(singleSignOnUserValue)(_.singleSignOnUserValue(_))
        .ifSome(userSettings)(_.userSettings(_))
        .build

    def describeWorkforceRequest(
      workforceName: Option[String] = None
    ): DescribeWorkforceRequest =
      DescribeWorkforceRequest
        .builder
        .ifSome(workforceName)(_.workforceName(_))
        .build

    def describeWorkforceResponse(
      workforce: Option[Workforce] = None
    ): DescribeWorkforceResponse =
      DescribeWorkforceResponse
        .builder
        .ifSome(workforce)(_.workforce(_))
        .build

    def describeWorkteamRequest(
      workteamName: Option[String] = None
    ): DescribeWorkteamRequest =
      DescribeWorkteamRequest
        .builder
        .ifSome(workteamName)(_.workteamName(_))
        .build

    def describeWorkteamResponse(
      workteam: Option[Workteam] = None
    ): DescribeWorkteamResponse =
      DescribeWorkteamResponse
        .builder
        .ifSome(workteam)(_.workteam(_))
        .build

    def desiredWeightAndCapacity(
      variantName: Option[String] = None,
      desiredWeight: Option[VariantWeight] = None,
      desiredInstanceCount: Option[Int] = None
    ): DesiredWeightAndCapacity =
      DesiredWeightAndCapacity
        .builder
        .ifSome(variantName)(_.variantName(_))
        .ifSome(desiredWeight)(_.desiredWeight(_))
        .ifSome(desiredInstanceCount)(_.desiredInstanceCount(_))
        .build

    def device(
      deviceName: Option[String] = None,
      description: Option[String] = None,
      iotThingName: Option[String] = None
    ): Device =
      Device
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(description)(_.description(_))
        .ifSome(iotThingName)(_.iotThingName(_))
        .build

    def deviceFleetSummary(
      deviceFleetArn: Option[String] = None,
      deviceFleetName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): DeviceFleetSummary =
      DeviceFleetSummary
        .builder
        .ifSome(deviceFleetArn)(_.deviceFleetArn(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def deviceStats(
      connectedDeviceCount: Option[Long] = None,
      registeredDeviceCount: Option[Long] = None
    ): DeviceStats =
      DeviceStats
        .builder
        .ifSome(connectedDeviceCount)(_.connectedDeviceCount(_))
        .ifSome(registeredDeviceCount)(_.registeredDeviceCount(_))
        .build

    def deviceSummary(
      deviceName: Option[String] = None,
      deviceArn: Option[String] = None,
      description: Option[String] = None,
      deviceFleetName: Option[String] = None,
      iotThingName: Option[String] = None,
      registrationTime: Option[Timestamp] = None,
      latestHeartbeat: Option[Timestamp] = None,
      models: Option[List[EdgeModelSummary]] = None
    ): DeviceSummary =
      DeviceSummary
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(iotThingName)(_.iotThingName(_))
        .ifSome(registrationTime)(_.registrationTime(_))
        .ifSome(latestHeartbeat)(_.latestHeartbeat(_))
        .ifSome(models)(_.models(_))
        .build

    def disableSagemakerServicecatalogPortfolioInput(

    ): DisableSagemakerServicecatalogPortfolioInput =
      DisableSagemakerServicecatalogPortfolioInput
        .builder

        .build

    def disableSagemakerServicecatalogPortfolioOutput(

    ): DisableSagemakerServicecatalogPortfolioOutput =
      DisableSagemakerServicecatalogPortfolioOutput
        .builder

        .build

    def disassociateTrialComponentRequest(
      trialComponentName: Option[String] = None,
      trialName: Option[String] = None
    ): DisassociateTrialComponentRequest =
      DisassociateTrialComponentRequest
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(trialName)(_.trialName(_))
        .build

    def disassociateTrialComponentResponse(
      trialComponentArn: Option[String] = None,
      trialArn: Option[String] = None
    ): DisassociateTrialComponentResponse =
      DisassociateTrialComponentResponse
        .builder
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .ifSome(trialArn)(_.trialArn(_))
        .build

    def domainDetails(
      domainArn: Option[String] = None,
      domainId: Option[String] = None,
      domainName: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      url: Option[String] = None
    ): DomainDetails =
      DomainDetails
        .builder
        .ifSome(domainArn)(_.domainArn(_))
        .ifSome(domainId)(_.domainId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(url)(_.url(_))
        .build

    def edgeModel(
      modelName: Option[String] = None,
      modelVersion: Option[String] = None,
      latestSampleTime: Option[Timestamp] = None,
      latestInference: Option[Timestamp] = None
    ): EdgeModel =
      EdgeModel
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(latestSampleTime)(_.latestSampleTime(_))
        .ifSome(latestInference)(_.latestInference(_))
        .build

    def edgeModelStat(
      modelName: Option[String] = None,
      modelVersion: Option[String] = None,
      offlineDeviceCount: Option[Long] = None,
      connectedDeviceCount: Option[Long] = None,
      activeDeviceCount: Option[Long] = None,
      samplingDeviceCount: Option[Long] = None
    ): EdgeModelStat =
      EdgeModelStat
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(offlineDeviceCount)(_.offlineDeviceCount(_))
        .ifSome(connectedDeviceCount)(_.connectedDeviceCount(_))
        .ifSome(activeDeviceCount)(_.activeDeviceCount(_))
        .ifSome(samplingDeviceCount)(_.samplingDeviceCount(_))
        .build

    def edgeModelSummary(
      modelName: Option[String] = None,
      modelVersion: Option[String] = None
    ): EdgeModelSummary =
      EdgeModelSummary
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def edgeOutputConfig(
      s3OutputLocation: Option[String] = None,
      kmsKeyId: Option[String] = None,
      presetDeploymentType: Option[String] = None,
      presetDeploymentConfig: Option[String] = None
    ): EdgeOutputConfig =
      EdgeOutputConfig
        .builder
        .ifSome(s3OutputLocation)(_.s3OutputLocation(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(presetDeploymentType)(_.presetDeploymentType(_))
        .ifSome(presetDeploymentConfig)(_.presetDeploymentConfig(_))
        .build

    def edgePackagingJobSummary(
      edgePackagingJobArn: Option[String] = None,
      edgePackagingJobName: Option[String] = None,
      edgePackagingJobStatus: Option[String] = None,
      compilationJobName: Option[String] = None,
      modelName: Option[String] = None,
      modelVersion: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): EdgePackagingJobSummary =
      EdgePackagingJobSummary
        .builder
        .ifSome(edgePackagingJobArn)(_.edgePackagingJobArn(_))
        .ifSome(edgePackagingJobName)(_.edgePackagingJobName(_))
        .ifSome(edgePackagingJobStatus)(_.edgePackagingJobStatus(_))
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def edgePresetDeploymentOutput(
      `type`: Option[String] = None,
      artifact: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): EdgePresetDeploymentOutput =
      EdgePresetDeploymentOutput
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(artifact)(_.artifact(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def enableSagemakerServicecatalogPortfolioInput(

    ): EnableSagemakerServicecatalogPortfolioInput =
      EnableSagemakerServicecatalogPortfolioInput
        .builder

        .build

    def enableSagemakerServicecatalogPortfolioOutput(

    ): EnableSagemakerServicecatalogPortfolioOutput =
      EnableSagemakerServicecatalogPortfolioOutput
        .builder

        .build

    def endpoint(
      endpointName: Option[String] = None,
      endpointArn: Option[String] = None,
      endpointConfigName: Option[String] = None,
      productionVariants: Option[List[ProductionVariantSummary]] = None,
      dataCaptureConfig: Option[DataCaptureConfigSummary] = None,
      endpointStatus: Option[String] = None,
      failureReason: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      monitoringSchedules: Option[List[MonitoringSchedule]] = None,
      tags: Option[List[Tag]] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .ifSome(productionVariants)(_.productionVariants(_))
        .ifSome(dataCaptureConfig)(_.dataCaptureConfig(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(monitoringSchedules)(_.monitoringSchedules(_))
        .ifSome(tags)(_.tags(_))
        .build

    def endpointConfigSummary(
      endpointConfigName: Option[String] = None,
      endpointConfigArn: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): EndpointConfigSummary =
      EndpointConfigSummary
        .builder
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .ifSome(endpointConfigArn)(_.endpointConfigArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def endpointInput(
      endpointName: Option[String] = None,
      localPath: Option[String] = None,
      s3InputMode: Option[String] = None,
      s3DataDistributionType: Option[String] = None,
      featuresAttribute: Option[String] = None,
      inferenceAttribute: Option[String] = None,
      probabilityAttribute: Option[String] = None,
      probabilityThresholdAttribute: Option[ProbabilityThresholdAttribute] = None,
      startTimeOffset: Option[String] = None,
      endTimeOffset: Option[String] = None
    ): EndpointInput =
      EndpointInput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3InputMode)(_.s3InputMode(_))
        .ifSome(s3DataDistributionType)(_.s3DataDistributionType(_))
        .ifSome(featuresAttribute)(_.featuresAttribute(_))
        .ifSome(inferenceAttribute)(_.inferenceAttribute(_))
        .ifSome(probabilityAttribute)(_.probabilityAttribute(_))
        .ifSome(probabilityThresholdAttribute)(_.probabilityThresholdAttribute(_))
        .ifSome(startTimeOffset)(_.startTimeOffset(_))
        .ifSome(endTimeOffset)(_.endTimeOffset(_))
        .build

    def endpointSummary(
      endpointName: Option[String] = None,
      endpointArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      endpointStatus: Option[String] = None
    ): EndpointSummary =
      EndpointSummary
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .build

    def experiment(
      experimentName: Option[String] = None,
      experimentArn: Option[String] = None,
      displayName: Option[String] = None,
      source: Option[ExperimentSource] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      tags: Option[List[Tag]] = None
    ): Experiment =
      Experiment
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(experimentArn)(_.experimentArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(source)(_.source(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def experimentConfig(
      experimentName: Option[String] = None,
      trialName: Option[String] = None,
      trialComponentDisplayName: Option[String] = None
    ): ExperimentConfig =
      ExperimentConfig
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(trialName)(_.trialName(_))
        .ifSome(trialComponentDisplayName)(_.trialComponentDisplayName(_))
        .build

    def experimentSource(
      sourceArn: Option[String] = None,
      sourceType: Option[String] = None
    ): ExperimentSource =
      ExperimentSource
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .build

    def experimentSummary(
      experimentArn: Option[String] = None,
      experimentName: Option[String] = None,
      displayName: Option[String] = None,
      experimentSource: Option[ExperimentSource] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): ExperimentSummary =
      ExperimentSummary
        .builder
        .ifSome(experimentArn)(_.experimentArn(_))
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(experimentSource)(_.experimentSource(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def explainability(
      report: Option[MetricsSource] = None
    ): Explainability =
      Explainability
        .builder
        .ifSome(report)(_.report(_))
        .build

    def featureDefinition(
      featureName: Option[String] = None,
      featureType: Option[String] = None
    ): FeatureDefinition =
      FeatureDefinition
        .builder
        .ifSome(featureName)(_.featureName(_))
        .ifSome(featureType)(_.featureType(_))
        .build

    def featureGroup(
      featureGroupArn: Option[String] = None,
      featureGroupName: Option[String] = None,
      recordIdentifierFeatureName: Option[String] = None,
      eventTimeFeatureName: Option[String] = None,
      featureDefinitions: Option[List[FeatureDefinition]] = None,
      creationTime: Option[CreationTime] = None,
      onlineStoreConfig: Option[OnlineStoreConfig] = None,
      offlineStoreConfig: Option[OfflineStoreConfig] = None,
      roleArn: Option[String] = None,
      featureGroupStatus: Option[String] = None,
      offlineStoreStatus: Option[OfflineStoreStatus] = None,
      failureReason: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): FeatureGroup =
      FeatureGroup
        .builder
        .ifSome(featureGroupArn)(_.featureGroupArn(_))
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifierFeatureName)(_.recordIdentifierFeatureName(_))
        .ifSome(eventTimeFeatureName)(_.eventTimeFeatureName(_))
        .ifSome(featureDefinitions)(_.featureDefinitions(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(onlineStoreConfig)(_.onlineStoreConfig(_))
        .ifSome(offlineStoreConfig)(_.offlineStoreConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(featureGroupStatus)(_.featureGroupStatus(_))
        .ifSome(offlineStoreStatus)(_.offlineStoreStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def featureGroupSummary(
      featureGroupName: Option[String] = None,
      featureGroupArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      featureGroupStatus: Option[String] = None,
      offlineStoreStatus: Option[OfflineStoreStatus] = None
    ): FeatureGroupSummary =
      FeatureGroupSummary
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(featureGroupArn)(_.featureGroupArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(featureGroupStatus)(_.featureGroupStatus(_))
        .ifSome(offlineStoreStatus)(_.offlineStoreStatus(_))
        .build

    def fileSystemConfig(
      mountPath: Option[String] = None,
      defaultUid: Option[Int] = None,
      defaultGid: Option[Int] = None
    ): FileSystemConfig =
      FileSystemConfig
        .builder
        .ifSome(mountPath)(_.mountPath(_))
        .ifSome(defaultUid)(_.defaultUid(_))
        .ifSome(defaultGid)(_.defaultGid(_))
        .build

    def fileSystemDataSource(
      fileSystemId: Option[String] = None,
      fileSystemAccessMode: Option[String] = None,
      fileSystemType: Option[String] = None,
      directoryPath: Option[String] = None
    ): FileSystemDataSource =
      FileSystemDataSource
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(fileSystemAccessMode)(_.fileSystemAccessMode(_))
        .ifSome(fileSystemType)(_.fileSystemType(_))
        .ifSome(directoryPath)(_.directoryPath(_))
        .build

    def filter(
      name: Option[String] = None,
      operator: Option[String] = None,
      value: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(value)(_.value(_))
        .build

    def finalAutoMLJobObjectiveMetric(
      `type`: Option[String] = None,
      metricName: Option[String] = None,
      value: Option[MetricValue] = None
    ): FinalAutoMLJobObjectiveMetric =
      FinalAutoMLJobObjectiveMetric
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(value)(_.value(_))
        .build

    def finalHyperParameterTuningJobObjectiveMetric(
      `type`: Option[String] = None,
      metricName: Option[String] = None,
      value: Option[MetricValue] = None
    ): FinalHyperParameterTuningJobObjectiveMetric =
      FinalHyperParameterTuningJobObjectiveMetric
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(value)(_.value(_))
        .build

    def flowDefinitionOutputConfig(
      s3OutputPath: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): FlowDefinitionOutputConfig =
      FlowDefinitionOutputConfig
        .builder
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def flowDefinitionSummary(
      flowDefinitionName: Option[String] = None,
      flowDefinitionArn: Option[String] = None,
      flowDefinitionStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      failureReason: Option[String] = None
    ): FlowDefinitionSummary =
      FlowDefinitionSummary
        .builder
        .ifSome(flowDefinitionName)(_.flowDefinitionName(_))
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .ifSome(flowDefinitionStatus)(_.flowDefinitionStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def getDeviceFleetReportRequest(
      deviceFleetName: Option[String] = None
    ): GetDeviceFleetReportRequest =
      GetDeviceFleetReportRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .build

    def getDeviceFleetReportResponse(
      deviceFleetArn: Option[String] = None,
      deviceFleetName: Option[String] = None,
      outputConfig: Option[EdgeOutputConfig] = None,
      description: Option[String] = None,
      reportGenerated: Option[Timestamp] = None,
      deviceStats: Option[DeviceStats] = None,
      agentVersions: Option[List[AgentVersion]] = None,
      modelStats: Option[List[EdgeModelStat]] = None
    ): GetDeviceFleetReportResponse =
      GetDeviceFleetReportResponse
        .builder
        .ifSome(deviceFleetArn)(_.deviceFleetArn(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(description)(_.description(_))
        .ifSome(reportGenerated)(_.reportGenerated(_))
        .ifSome(deviceStats)(_.deviceStats(_))
        .ifSome(agentVersions)(_.agentVersions(_))
        .ifSome(modelStats)(_.modelStats(_))
        .build

    def getModelPackageGroupPolicyInput(
      modelPackageGroupName: Option[String] = None
    ): GetModelPackageGroupPolicyInput =
      GetModelPackageGroupPolicyInput
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .build

    def getModelPackageGroupPolicyOutput(
      resourcePolicy: Option[String] = None
    ): GetModelPackageGroupPolicyOutput =
      GetModelPackageGroupPolicyOutput
        .builder
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .build

    def getSagemakerServicecatalogPortfolioStatusInput(

    ): GetSagemakerServicecatalogPortfolioStatusInput =
      GetSagemakerServicecatalogPortfolioStatusInput
        .builder

        .build

    def getSagemakerServicecatalogPortfolioStatusOutput(
      status: Option[String] = None
    ): GetSagemakerServicecatalogPortfolioStatusOutput =
      GetSagemakerServicecatalogPortfolioStatusOutput
        .builder
        .ifSome(status)(_.status(_))
        .build

    def getSearchSuggestionsRequest(
      resource: Option[String] = None,
      suggestionQuery: Option[SuggestionQuery] = None
    ): GetSearchSuggestionsRequest =
      GetSearchSuggestionsRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(suggestionQuery)(_.suggestionQuery(_))
        .build

    def getSearchSuggestionsResponse(
      propertyNameSuggestions: Option[List[PropertyNameSuggestion]] = None
    ): GetSearchSuggestionsResponse =
      GetSearchSuggestionsResponse
        .builder
        .ifSome(propertyNameSuggestions)(_.propertyNameSuggestions(_))
        .build

    def gitConfig(
      repositoryUrl: Option[String] = None,
      branch: Option[String] = None,
      secretArn: Option[String] = None
    ): GitConfig =
      GitConfig
        .builder
        .ifSome(repositoryUrl)(_.repositoryUrl(_))
        .ifSome(branch)(_.branch(_))
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def gitConfigForUpdate(
      secretArn: Option[String] = None
    ): GitConfigForUpdate =
      GitConfigForUpdate
        .builder
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def humanLoopActivationConditionsConfig(
      humanLoopActivationConditions: Option[String] = None
    ): HumanLoopActivationConditionsConfig =
      HumanLoopActivationConditionsConfig
        .builder
        .ifSome(humanLoopActivationConditions)(_.humanLoopActivationConditions(_))
        .build

    def humanLoopActivationConfig(
      humanLoopActivationConditionsConfig: Option[HumanLoopActivationConditionsConfig] = None
    ): HumanLoopActivationConfig =
      HumanLoopActivationConfig
        .builder
        .ifSome(humanLoopActivationConditionsConfig)(_.humanLoopActivationConditionsConfig(_))
        .build

    def humanLoopConfig(
      workteamArn: Option[String] = None,
      humanTaskUiArn: Option[String] = None,
      taskTitle: Option[String] = None,
      taskDescription: Option[String] = None,
      taskCount: Option[Int] = None,
      taskAvailabilityLifetimeInSeconds: Option[Int] = None,
      taskTimeLimitInSeconds: Option[Int] = None,
      taskKeywords: Option[List[FlowDefinitionTaskKeyword]] = None,
      publicWorkforceTaskPrice: Option[PublicWorkforceTaskPrice] = None
    ): HumanLoopConfig =
      HumanLoopConfig
        .builder
        .ifSome(workteamArn)(_.workteamArn(_))
        .ifSome(humanTaskUiArn)(_.humanTaskUiArn(_))
        .ifSome(taskTitle)(_.taskTitle(_))
        .ifSome(taskDescription)(_.taskDescription(_))
        .ifSome(taskCount)(_.taskCount(_))
        .ifSome(taskAvailabilityLifetimeInSeconds)(_.taskAvailabilityLifetimeInSeconds(_))
        .ifSome(taskTimeLimitInSeconds)(_.taskTimeLimitInSeconds(_))
        .ifSome(taskKeywords)(_.taskKeywords(_))
        .ifSome(publicWorkforceTaskPrice)(_.publicWorkforceTaskPrice(_))
        .build

    def humanLoopRequestSource(
      awsManagedHumanLoopRequestSource: Option[String] = None
    ): HumanLoopRequestSource =
      HumanLoopRequestSource
        .builder
        .ifSome(awsManagedHumanLoopRequestSource)(_.awsManagedHumanLoopRequestSource(_))
        .build

    def humanTaskConfig(
      workteamArn: Option[String] = None,
      uiConfig: Option[UiConfig] = None,
      preHumanTaskLambdaArn: Option[String] = None,
      taskKeywords: Option[List[TaskKeyword]] = None,
      taskTitle: Option[String] = None,
      taskDescription: Option[String] = None,
      numberOfHumanWorkersPerDataObject: Option[Int] = None,
      taskTimeLimitInSeconds: Option[Int] = None,
      taskAvailabilityLifetimeInSeconds: Option[Int] = None,
      maxConcurrentTaskCount: Option[Int] = None,
      annotationConsolidationConfig: Option[AnnotationConsolidationConfig] = None,
      publicWorkforceTaskPrice: Option[PublicWorkforceTaskPrice] = None
    ): HumanTaskConfig =
      HumanTaskConfig
        .builder
        .ifSome(workteamArn)(_.workteamArn(_))
        .ifSome(uiConfig)(_.uiConfig(_))
        .ifSome(preHumanTaskLambdaArn)(_.preHumanTaskLambdaArn(_))
        .ifSome(taskKeywords)(_.taskKeywords(_))
        .ifSome(taskTitle)(_.taskTitle(_))
        .ifSome(taskDescription)(_.taskDescription(_))
        .ifSome(numberOfHumanWorkersPerDataObject)(_.numberOfHumanWorkersPerDataObject(_))
        .ifSome(taskTimeLimitInSeconds)(_.taskTimeLimitInSeconds(_))
        .ifSome(taskAvailabilityLifetimeInSeconds)(_.taskAvailabilityLifetimeInSeconds(_))
        .ifSome(maxConcurrentTaskCount)(_.maxConcurrentTaskCount(_))
        .ifSome(annotationConsolidationConfig)(_.annotationConsolidationConfig(_))
        .ifSome(publicWorkforceTaskPrice)(_.publicWorkforceTaskPrice(_))
        .build

    def humanTaskUiSummary(
      humanTaskUiName: Option[String] = None,
      humanTaskUiArn: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): HumanTaskUiSummary =
      HumanTaskUiSummary
        .builder
        .ifSome(humanTaskUiName)(_.humanTaskUiName(_))
        .ifSome(humanTaskUiArn)(_.humanTaskUiArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def hyperParameterAlgorithmSpecification(
      trainingImage: Option[String] = None,
      trainingInputMode: Option[String] = None,
      algorithmName: Option[String] = None,
      metricDefinitions: Option[List[MetricDefinition]] = None
    ): HyperParameterAlgorithmSpecification =
      HyperParameterAlgorithmSpecification
        .builder
        .ifSome(trainingImage)(_.trainingImage(_))
        .ifSome(trainingInputMode)(_.trainingInputMode(_))
        .ifSome(algorithmName)(_.algorithmName(_))
        .ifSome(metricDefinitions)(_.metricDefinitions(_))
        .build

    def hyperParameterSpecification(
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      range: Option[ParameterRange] = None,
      isTunable: Option[Boolean] = None,
      isRequired: Option[Boolean] = None,
      defaultValue: Option[String] = None
    ): HyperParameterSpecification =
      HyperParameterSpecification
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(range)(_.range(_))
        .ifSome(isTunable)(_.isTunable(_))
        .ifSome(isRequired)(_.isRequired(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def hyperParameterTrainingJobDefinition(
      definitionName: Option[String] = None,
      tuningObjective: Option[HyperParameterTuningJobObjective] = None,
      hyperParameterRanges: Option[ParameterRanges] = None,
      staticHyperParameters: Option[HyperParameters] = None,
      algorithmSpecification: Option[HyperParameterAlgorithmSpecification] = None,
      roleArn: Option[String] = None,
      inputDataConfig: Option[List[Channel]] = None,
      vpcConfig: Option[VpcConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      resourceConfig: Option[ResourceConfig] = None,
      stoppingCondition: Option[StoppingCondition] = None,
      enableNetworkIsolation: Option[Boolean] = None,
      enableInterContainerTrafficEncryption: Option[Boolean] = None,
      enableManagedSpotTraining: Option[Boolean] = None,
      checkpointConfig: Option[CheckpointConfig] = None,
      retryStrategy: Option[RetryStrategy] = None
    ): HyperParameterTrainingJobDefinition =
      HyperParameterTrainingJobDefinition
        .builder
        .ifSome(definitionName)(_.definitionName(_))
        .ifSome(tuningObjective)(_.tuningObjective(_))
        .ifSome(hyperParameterRanges)(_.hyperParameterRanges(_))
        .ifSome(staticHyperParameters)(_.staticHyperParameters(_))
        .ifSome(algorithmSpecification)(_.algorithmSpecification(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .ifSome(enableInterContainerTrafficEncryption)(_.enableInterContainerTrafficEncryption(_))
        .ifSome(enableManagedSpotTraining)(_.enableManagedSpotTraining(_))
        .ifSome(checkpointConfig)(_.checkpointConfig(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .build

    def hyperParameterTrainingJobSummary(
      trainingJobDefinitionName: Option[String] = None,
      trainingJobName: Option[String] = None,
      trainingJobArn: Option[String] = None,
      tuningJobName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      trainingStartTime: Option[Timestamp] = None,
      trainingEndTime: Option[Timestamp] = None,
      trainingJobStatus: Option[String] = None,
      tunedHyperParameters: Option[HyperParameters] = None,
      failureReason: Option[String] = None,
      finalHyperParameterTuningJobObjectiveMetric: Option[FinalHyperParameterTuningJobObjectiveMetric] = None,
      objectiveStatus: Option[String] = None
    ): HyperParameterTrainingJobSummary =
      HyperParameterTrainingJobSummary
        .builder
        .ifSome(trainingJobDefinitionName)(_.trainingJobDefinitionName(_))
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .ifSome(tuningJobName)(_.tuningJobName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(trainingStartTime)(_.trainingStartTime(_))
        .ifSome(trainingEndTime)(_.trainingEndTime(_))
        .ifSome(trainingJobStatus)(_.trainingJobStatus(_))
        .ifSome(tunedHyperParameters)(_.tunedHyperParameters(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(finalHyperParameterTuningJobObjectiveMetric)(_.finalHyperParameterTuningJobObjectiveMetric(_))
        .ifSome(objectiveStatus)(_.objectiveStatus(_))
        .build

    def hyperParameterTuningJobConfig(
      strategy: Option[String] = None,
      hyperParameterTuningJobObjective: Option[HyperParameterTuningJobObjective] = None,
      resourceLimits: Option[ResourceLimits] = None,
      parameterRanges: Option[ParameterRanges] = None,
      trainingJobEarlyStoppingType: Option[String] = None,
      tuningJobCompletionCriteria: Option[TuningJobCompletionCriteria] = None
    ): HyperParameterTuningJobConfig =
      HyperParameterTuningJobConfig
        .builder
        .ifSome(strategy)(_.strategy(_))
        .ifSome(hyperParameterTuningJobObjective)(_.hyperParameterTuningJobObjective(_))
        .ifSome(resourceLimits)(_.resourceLimits(_))
        .ifSome(parameterRanges)(_.parameterRanges(_))
        .ifSome(trainingJobEarlyStoppingType)(_.trainingJobEarlyStoppingType(_))
        .ifSome(tuningJobCompletionCriteria)(_.tuningJobCompletionCriteria(_))
        .build

    def hyperParameterTuningJobObjective(
      `type`: Option[String] = None,
      metricName: Option[String] = None
    ): HyperParameterTuningJobObjective =
      HyperParameterTuningJobObjective
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(metricName)(_.metricName(_))
        .build

    def hyperParameterTuningJobSummary(
      hyperParameterTuningJobName: Option[String] = None,
      hyperParameterTuningJobArn: Option[String] = None,
      hyperParameterTuningJobStatus: Option[String] = None,
      strategy: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      hyperParameterTuningEndTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      trainingJobStatusCounters: Option[TrainingJobStatusCounters] = None,
      objectiveStatusCounters: Option[ObjectiveStatusCounters] = None,
      resourceLimits: Option[ResourceLimits] = None
    ): HyperParameterTuningJobSummary =
      HyperParameterTuningJobSummary
        .builder
        .ifSome(hyperParameterTuningJobName)(_.hyperParameterTuningJobName(_))
        .ifSome(hyperParameterTuningJobArn)(_.hyperParameterTuningJobArn(_))
        .ifSome(hyperParameterTuningJobStatus)(_.hyperParameterTuningJobStatus(_))
        .ifSome(strategy)(_.strategy(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(hyperParameterTuningEndTime)(_.hyperParameterTuningEndTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(trainingJobStatusCounters)(_.trainingJobStatusCounters(_))
        .ifSome(objectiveStatusCounters)(_.objectiveStatusCounters(_))
        .ifSome(resourceLimits)(_.resourceLimits(_))
        .build

    def hyperParameterTuningJobWarmStartConfig(
      parentHyperParameterTuningJobs: Option[List[ParentHyperParameterTuningJob]] = None,
      warmStartType: Option[String] = None
    ): HyperParameterTuningJobWarmStartConfig =
      HyperParameterTuningJobWarmStartConfig
        .builder
        .ifSome(parentHyperParameterTuningJobs)(_.parentHyperParameterTuningJobs(_))
        .ifSome(warmStartType)(_.warmStartType(_))
        .build

    def image(
      creationTime: Option[Timestamp] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      failureReason: Option[String] = None,
      imageArn: Option[String] = None,
      imageName: Option[String] = None,
      imageStatus: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): Image =
      Image
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageStatus)(_.imageStatus(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def imageConfig(
      repositoryAccessMode: Option[String] = None,
      repositoryAuthConfig: Option[RepositoryAuthConfig] = None
    ): ImageConfig =
      ImageConfig
        .builder
        .ifSome(repositoryAccessMode)(_.repositoryAccessMode(_))
        .ifSome(repositoryAuthConfig)(_.repositoryAuthConfig(_))
        .build

    def imageVersion(
      creationTime: Option[Timestamp] = None,
      failureReason: Option[String] = None,
      imageArn: Option[String] = None,
      imageVersionArn: Option[String] = None,
      imageVersionStatus: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None,
      version: Option[Int] = None
    ): ImageVersion =
      ImageVersion
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(imageVersionArn)(_.imageVersionArn(_))
        .ifSome(imageVersionStatus)(_.imageVersionStatus(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(version)(_.version(_))
        .build

    def inferenceExecutionConfig(
      mode: Option[String] = None
    ): InferenceExecutionConfig =
      InferenceExecutionConfig
        .builder
        .ifSome(mode)(_.mode(_))
        .build

    def inferenceSpecification(
      containers: Option[List[ModelPackageContainerDefinition]] = None,
      supportedTransformInstanceTypes: Option[List[TransformInstanceType]] = None,
      supportedRealtimeInferenceInstanceTypes: Option[List[ProductionVariantInstanceType]] = None,
      supportedContentTypes: Option[List[ContentType]] = None,
      supportedResponseMIMETypes: Option[List[ResponseMIMEType]] = None
    ): InferenceSpecification =
      InferenceSpecification
        .builder
        .ifSome(containers)(_.containers(_))
        .ifSome(supportedTransformInstanceTypes)(_.supportedTransformInstanceTypes(_))
        .ifSome(supportedRealtimeInferenceInstanceTypes)(_.supportedRealtimeInferenceInstanceTypes(_))
        .ifSome(supportedContentTypes)(_.supportedContentTypes(_))
        .ifSome(supportedResponseMIMETypes)(_.supportedResponseMIMETypes(_))
        .build

    def inputConfig(
      s3Uri: Option[String] = None,
      dataInputConfig: Option[String] = None,
      framework: Option[String] = None,
      frameworkVersion: Option[String] = None
    ): InputConfig =
      InputConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(dataInputConfig)(_.dataInputConfig(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(frameworkVersion)(_.frameworkVersion(_))
        .build

    def integerParameterRange(
      name: Option[String] = None,
      minValue: Option[String] = None,
      maxValue: Option[String] = None,
      scalingType: Option[String] = None
    ): IntegerParameterRange =
      IntegerParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(scalingType)(_.scalingType(_))
        .build

    def integerParameterRangeSpecification(
      minValue: Option[String] = None,
      maxValue: Option[String] = None
    ): IntegerParameterRangeSpecification =
      IntegerParameterRangeSpecification
        .builder
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .build

    def jupyterServerAppSettings(
      defaultResourceSpec: Option[ResourceSpec] = None
    ): JupyterServerAppSettings =
      JupyterServerAppSettings
        .builder
        .ifSome(defaultResourceSpec)(_.defaultResourceSpec(_))
        .build

    def kernelGatewayAppSettings(
      defaultResourceSpec: Option[ResourceSpec] = None,
      customImages: Option[List[CustomImage]] = None
    ): KernelGatewayAppSettings =
      KernelGatewayAppSettings
        .builder
        .ifSome(defaultResourceSpec)(_.defaultResourceSpec(_))
        .ifSome(customImages)(_.customImages(_))
        .build

    def kernelGatewayImageConfig(
      kernelSpecs: Option[List[KernelSpec]] = None,
      fileSystemConfig: Option[FileSystemConfig] = None
    ): KernelGatewayImageConfig =
      KernelGatewayImageConfig
        .builder
        .ifSome(kernelSpecs)(_.kernelSpecs(_))
        .ifSome(fileSystemConfig)(_.fileSystemConfig(_))
        .build

    def kernelSpec(
      name: Option[String] = None,
      displayName: Option[String] = None
    ): KernelSpec =
      KernelSpec
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def labelCounters(
      totalLabeled: Option[Int] = None,
      humanLabeled: Option[Int] = None,
      machineLabeled: Option[Int] = None,
      failedNonRetryableError: Option[Int] = None,
      unlabeled: Option[Int] = None
    ): LabelCounters =
      LabelCounters
        .builder
        .ifSome(totalLabeled)(_.totalLabeled(_))
        .ifSome(humanLabeled)(_.humanLabeled(_))
        .ifSome(machineLabeled)(_.machineLabeled(_))
        .ifSome(failedNonRetryableError)(_.failedNonRetryableError(_))
        .ifSome(unlabeled)(_.unlabeled(_))
        .build

    def labelCountersForWorkteam(
      humanLabeled: Option[Int] = None,
      pendingHuman: Option[Int] = None,
      total: Option[Int] = None
    ): LabelCountersForWorkteam =
      LabelCountersForWorkteam
        .builder
        .ifSome(humanLabeled)(_.humanLabeled(_))
        .ifSome(pendingHuman)(_.pendingHuman(_))
        .ifSome(total)(_.total(_))
        .build

    def labelingJobAlgorithmsConfig(
      labelingJobAlgorithmSpecificationArn: Option[String] = None,
      initialActiveLearningModelArn: Option[String] = None,
      labelingJobResourceConfig: Option[LabelingJobResourceConfig] = None
    ): LabelingJobAlgorithmsConfig =
      LabelingJobAlgorithmsConfig
        .builder
        .ifSome(labelingJobAlgorithmSpecificationArn)(_.labelingJobAlgorithmSpecificationArn(_))
        .ifSome(initialActiveLearningModelArn)(_.initialActiveLearningModelArn(_))
        .ifSome(labelingJobResourceConfig)(_.labelingJobResourceConfig(_))
        .build

    def labelingJobDataAttributes(
      contentClassifiers: Option[List[ContentClassifier]] = None
    ): LabelingJobDataAttributes =
      LabelingJobDataAttributes
        .builder
        .ifSome(contentClassifiers)(_.contentClassifiers(_))
        .build

    def labelingJobDataSource(
      s3DataSource: Option[LabelingJobS3DataSource] = None,
      snsDataSource: Option[LabelingJobSnsDataSource] = None
    ): LabelingJobDataSource =
      LabelingJobDataSource
        .builder
        .ifSome(s3DataSource)(_.s3DataSource(_))
        .ifSome(snsDataSource)(_.snsDataSource(_))
        .build

    def labelingJobForWorkteamSummary(
      labelingJobName: Option[String] = None,
      jobReferenceCode: Option[String] = None,
      workRequesterAccountId: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      labelCounters: Option[LabelCountersForWorkteam] = None,
      numberOfHumanWorkersPerDataObject: Option[Int] = None
    ): LabelingJobForWorkteamSummary =
      LabelingJobForWorkteamSummary
        .builder
        .ifSome(labelingJobName)(_.labelingJobName(_))
        .ifSome(jobReferenceCode)(_.jobReferenceCode(_))
        .ifSome(workRequesterAccountId)(_.workRequesterAccountId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(labelCounters)(_.labelCounters(_))
        .ifSome(numberOfHumanWorkersPerDataObject)(_.numberOfHumanWorkersPerDataObject(_))
        .build

    def labelingJobInputConfig(
      dataSource: Option[LabelingJobDataSource] = None,
      dataAttributes: Option[LabelingJobDataAttributes] = None
    ): LabelingJobInputConfig =
      LabelingJobInputConfig
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(dataAttributes)(_.dataAttributes(_))
        .build

    def labelingJobOutput(
      outputDatasetS3Uri: Option[String] = None,
      finalActiveLearningModelArn: Option[String] = None
    ): LabelingJobOutput =
      LabelingJobOutput
        .builder
        .ifSome(outputDatasetS3Uri)(_.outputDatasetS3Uri(_))
        .ifSome(finalActiveLearningModelArn)(_.finalActiveLearningModelArn(_))
        .build

    def labelingJobOutputConfig(
      s3OutputPath: Option[String] = None,
      kmsKeyId: Option[String] = None,
      snsTopicArn: Option[String] = None
    ): LabelingJobOutputConfig =
      LabelingJobOutputConfig
        .builder
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .build

    def labelingJobResourceConfig(
      volumeKmsKeyId: Option[String] = None
    ): LabelingJobResourceConfig =
      LabelingJobResourceConfig
        .builder
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .build

    def labelingJobS3DataSource(
      manifestS3Uri: Option[String] = None
    ): LabelingJobS3DataSource =
      LabelingJobS3DataSource
        .builder
        .ifSome(manifestS3Uri)(_.manifestS3Uri(_))
        .build

    def labelingJobSnsDataSource(
      snsTopicArn: Option[String] = None
    ): LabelingJobSnsDataSource =
      LabelingJobSnsDataSource
        .builder
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .build

    def labelingJobStoppingConditions(
      maxHumanLabeledObjectCount: Option[Int] = None,
      maxPercentageOfInputDatasetLabeled: Option[Int] = None
    ): LabelingJobStoppingConditions =
      LabelingJobStoppingConditions
        .builder
        .ifSome(maxHumanLabeledObjectCount)(_.maxHumanLabeledObjectCount(_))
        .ifSome(maxPercentageOfInputDatasetLabeled)(_.maxPercentageOfInputDatasetLabeled(_))
        .build

    def labelingJobSummary(
      labelingJobName: Option[String] = None,
      labelingJobArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      labelingJobStatus: Option[String] = None,
      labelCounters: Option[LabelCounters] = None,
      workteamArn: Option[String] = None,
      preHumanTaskLambdaArn: Option[String] = None,
      annotationConsolidationLambdaArn: Option[String] = None,
      failureReason: Option[String] = None,
      labelingJobOutput: Option[LabelingJobOutput] = None,
      inputConfig: Option[LabelingJobInputConfig] = None
    ): LabelingJobSummary =
      LabelingJobSummary
        .builder
        .ifSome(labelingJobName)(_.labelingJobName(_))
        .ifSome(labelingJobArn)(_.labelingJobArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(labelingJobStatus)(_.labelingJobStatus(_))
        .ifSome(labelCounters)(_.labelCounters(_))
        .ifSome(workteamArn)(_.workteamArn(_))
        .ifSome(preHumanTaskLambdaArn)(_.preHumanTaskLambdaArn(_))
        .ifSome(annotationConsolidationLambdaArn)(_.annotationConsolidationLambdaArn(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(labelingJobOutput)(_.labelingJobOutput(_))
        .ifSome(inputConfig)(_.inputConfig(_))
        .build

    def listActionsRequest(
      sourceUri: Option[String] = None,
      actionType: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListActionsRequest =
      ListActionsRequest
        .builder
        .ifSome(sourceUri)(_.sourceUri(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listActionsResponse(
      actionSummaries: Option[List[ActionSummary]] = None,
      nextToken: Option[String] = None
    ): ListActionsResponse =
      ListActionsResponse
        .builder
        .ifSome(actionSummaries)(_.actionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAlgorithmsInput(
      creationTimeAfter: Option[CreationTime] = None,
      creationTimeBefore: Option[CreationTime] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListAlgorithmsInput =
      ListAlgorithmsInput
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listAlgorithmsOutput(
      algorithmSummaryList: Option[List[AlgorithmSummary]] = None,
      nextToken: Option[String] = None
    ): ListAlgorithmsOutput =
      ListAlgorithmsOutput
        .builder
        .ifSome(algorithmSummaryList)(_.algorithmSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAppImageConfigsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None,
      modifiedTimeBefore: Option[Timestamp] = None,
      modifiedTimeAfter: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListAppImageConfigsRequest =
      ListAppImageConfigsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(modifiedTimeBefore)(_.modifiedTimeBefore(_))
        .ifSome(modifiedTimeAfter)(_.modifiedTimeAfter(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listAppImageConfigsResponse(
      nextToken: Option[String] = None,
      appImageConfigs: Option[List[AppImageConfigDetails]] = None
    ): ListAppImageConfigsResponse =
      ListAppImageConfigsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(appImageConfigs)(_.appImageConfigs(_))
        .build

    def listAppsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      domainIdEquals: Option[String] = None,
      userProfileNameEquals: Option[String] = None
    ): ListAppsRequest =
      ListAppsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(domainIdEquals)(_.domainIdEquals(_))
        .ifSome(userProfileNameEquals)(_.userProfileNameEquals(_))
        .build

    def listAppsResponse(
      apps: Option[List[AppDetails]] = None,
      nextToken: Option[String] = None
    ): ListAppsResponse =
      ListAppsResponse
        .builder
        .ifSome(apps)(_.apps(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listArtifactsRequest(
      sourceUri: Option[String] = None,
      artifactType: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListArtifactsRequest =
      ListArtifactsRequest
        .builder
        .ifSome(sourceUri)(_.sourceUri(_))
        .ifSome(artifactType)(_.artifactType(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listArtifactsResponse(
      artifactSummaries: Option[List[ArtifactSummary]] = None,
      nextToken: Option[String] = None
    ): ListArtifactsResponse =
      ListArtifactsResponse
        .builder
        .ifSome(artifactSummaries)(_.artifactSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociationsRequest(
      sourceArn: Option[String] = None,
      destinationArn: Option[String] = None,
      sourceType: Option[String] = None,
      destinationType: Option[String] = None,
      associationType: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssociationsRequest =
      ListAssociationsRequest
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(associationType)(_.associationType(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssociationsResponse(
      associationSummaries: Option[List[AssociationSummary]] = None,
      nextToken: Option[String] = None
    ): ListAssociationsResponse =
      ListAssociationsResponse
        .builder
        .ifSome(associationSummaries)(_.associationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAutoMLJobsRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      nameContains: Option[String] = None,
      statusEquals: Option[String] = None,
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAutoMLJobsRequest =
      ListAutoMLJobsRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAutoMLJobsResponse(
      autoMLJobSummaries: Option[List[AutoMLJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListAutoMLJobsResponse =
      ListAutoMLJobsResponse
        .builder
        .ifSome(autoMLJobSummaries)(_.autoMLJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCandidatesForAutoMLJobRequest(
      autoMLJobName: Option[String] = None,
      statusEquals: Option[String] = None,
      candidateNameEquals: Option[String] = None,
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCandidatesForAutoMLJobRequest =
      ListCandidatesForAutoMLJobRequest
        .builder
        .ifSome(autoMLJobName)(_.autoMLJobName(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(candidateNameEquals)(_.candidateNameEquals(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCandidatesForAutoMLJobResponse(
      candidates: Option[List[AutoMLCandidate]] = None,
      nextToken: Option[String] = None
    ): ListCandidatesForAutoMLJobResponse =
      ListCandidatesForAutoMLJobResponse
        .builder
        .ifSome(candidates)(_.candidates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCodeRepositoriesInput(
      creationTimeAfter: Option[CreationTime] = None,
      creationTimeBefore: Option[CreationTime] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListCodeRepositoriesInput =
      ListCodeRepositoriesInput
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listCodeRepositoriesOutput(
      codeRepositorySummaryList: Option[List[CodeRepositorySummary]] = None,
      nextToken: Option[String] = None
    ): ListCodeRepositoriesOutput =
      ListCodeRepositoriesOutput
        .builder
        .ifSome(codeRepositorySummaryList)(_.codeRepositorySummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCompilationJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      creationTimeAfter: Option[CreationTime] = None,
      creationTimeBefore: Option[CreationTime] = None,
      lastModifiedTimeAfter: Option[LastModifiedTime] = None,
      lastModifiedTimeBefore: Option[LastModifiedTime] = None,
      nameContains: Option[String] = None,
      statusEquals: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListCompilationJobsRequest =
      ListCompilationJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listCompilationJobsResponse(
      compilationJobSummaries: Option[List[CompilationJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListCompilationJobsResponse =
      ListCompilationJobsResponse
        .builder
        .ifSome(compilationJobSummaries)(_.compilationJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContextsRequest(
      sourceUri: Option[String] = None,
      contextType: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListContextsRequest =
      ListContextsRequest
        .builder
        .ifSome(sourceUri)(_.sourceUri(_))
        .ifSome(contextType)(_.contextType(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listContextsResponse(
      contextSummaries: Option[List[ContextSummary]] = None,
      nextToken: Option[String] = None
    ): ListContextsResponse =
      ListContextsResponse
        .builder
        .ifSome(contextSummaries)(_.contextSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDataQualityJobDefinitionsRequest(
      endpointName: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None
    ): ListDataQualityJobDefinitionsRequest =
      ListDataQualityJobDefinitionsRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .build

    def listDataQualityJobDefinitionsResponse(
      jobDefinitionSummaries: Option[List[MonitoringJobDefinitionSummary]] = None,
      nextToken: Option[String] = None
    ): ListDataQualityJobDefinitionsResponse =
      ListDataQualityJobDefinitionsResponse
        .builder
        .ifSome(jobDefinitionSummaries)(_.jobDefinitionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeviceFleetsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      nameContains: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListDeviceFleetsRequest =
      ListDeviceFleetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listDeviceFleetsResponse(
      deviceFleetSummaries: Option[List[DeviceFleetSummary]] = None,
      nextToken: Option[String] = None
    ): ListDeviceFleetsResponse =
      ListDeviceFleetsResponse
        .builder
        .ifSome(deviceFleetSummaries)(_.deviceFleetSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevicesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      latestHeartbeatAfter: Option[Timestamp] = None,
      modelName: Option[String] = None,
      deviceFleetName: Option[String] = None
    ): ListDevicesRequest =
      ListDevicesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(latestHeartbeatAfter)(_.latestHeartbeatAfter(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .build

    def listDevicesResponse(
      deviceSummaries: Option[List[DeviceSummary]] = None,
      nextToken: Option[String] = None
    ): ListDevicesResponse =
      ListDevicesResponse
        .builder
        .ifSome(deviceSummaries)(_.deviceSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDomainsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDomainsRequest =
      ListDomainsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDomainsResponse(
      domains: Option[List[DomainDetails]] = None,
      nextToken: Option[String] = None
    ): ListDomainsResponse =
      ListDomainsResponse
        .builder
        .ifSome(domains)(_.domains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEdgePackagingJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      nameContains: Option[String] = None,
      modelNameContains: Option[String] = None,
      statusEquals: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListEdgePackagingJobsRequest =
      ListEdgePackagingJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(modelNameContains)(_.modelNameContains(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listEdgePackagingJobsResponse(
      edgePackagingJobSummaries: Option[List[EdgePackagingJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListEdgePackagingJobsResponse =
      ListEdgePackagingJobsResponse
        .builder
        .ifSome(edgePackagingJobSummaries)(_.edgePackagingJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEndpointConfigsInput(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None
    ): ListEndpointConfigsInput =
      ListEndpointConfigsInput
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .build

    def listEndpointConfigsOutput(
      endpointConfigs: Option[List[EndpointConfigSummary]] = None,
      nextToken: Option[String] = None
    ): ListEndpointConfigsOutput =
      ListEndpointConfigsOutput
        .builder
        .ifSome(endpointConfigs)(_.endpointConfigs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEndpointsInput(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      statusEquals: Option[String] = None
    ): ListEndpointsInput =
      ListEndpointsInput
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .build

    def listEndpointsOutput(
      endpoints: Option[List[EndpointSummary]] = None,
      nextToken: Option[String] = None
    ): ListEndpointsOutput =
      ListEndpointsOutput
        .builder
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExperimentsRequest(
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListExperimentsRequest =
      ListExperimentsRequest
        .builder
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listExperimentsResponse(
      experimentSummaries: Option[List[ExperimentSummary]] = None,
      nextToken: Option[String] = None
    ): ListExperimentsResponse =
      ListExperimentsResponse
        .builder
        .ifSome(experimentSummaries)(_.experimentSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFeatureGroupsRequest(
      nameContains: Option[String] = None,
      featureGroupStatusEquals: Option[String] = None,
      offlineStoreStatusEquals: Option[String] = None,
      creationTimeAfter: Option[CreationTime] = None,
      creationTimeBefore: Option[CreationTime] = None,
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFeatureGroupsRequest =
      ListFeatureGroupsRequest
        .builder
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(featureGroupStatusEquals)(_.featureGroupStatusEquals(_))
        .ifSome(offlineStoreStatusEquals)(_.offlineStoreStatusEquals(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFeatureGroupsResponse(
      featureGroupSummaries: Option[List[FeatureGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListFeatureGroupsResponse =
      ListFeatureGroupsResponse
        .builder
        .ifSome(featureGroupSummaries)(_.featureGroupSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFlowDefinitionsRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFlowDefinitionsRequest =
      ListFlowDefinitionsRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFlowDefinitionsResponse(
      flowDefinitionSummaries: Option[List[FlowDefinitionSummary]] = None,
      nextToken: Option[String] = None
    ): ListFlowDefinitionsResponse =
      ListFlowDefinitionsResponse
        .builder
        .ifSome(flowDefinitionSummaries)(_.flowDefinitionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHumanTaskUisRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListHumanTaskUisRequest =
      ListHumanTaskUisRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listHumanTaskUisResponse(
      humanTaskUiSummaries: Option[List[HumanTaskUiSummary]] = None,
      nextToken: Option[String] = None
    ): ListHumanTaskUisResponse =
      ListHumanTaskUisResponse
        .builder
        .ifSome(humanTaskUiSummaries)(_.humanTaskUiSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHyperParameterTuningJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nameContains: Option[String] = None,
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      statusEquals: Option[String] = None
    ): ListHyperParameterTuningJobsRequest =
      ListHyperParameterTuningJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .build

    def listHyperParameterTuningJobsResponse(
      hyperParameterTuningJobSummaries: Option[List[HyperParameterTuningJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListHyperParameterTuningJobsResponse =
      ListHyperParameterTuningJobsResponse
        .builder
        .ifSome(hyperParameterTuningJobSummaries)(_.hyperParameterTuningJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImageVersionsRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      imageName: Option[String] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListImageVersionsRequest =
      ListImageVersionsRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listImageVersionsResponse(
      imageVersions: Option[List[ImageVersion]] = None,
      nextToken: Option[String] = None
    ): ListImageVersionsResponse =
      ListImageVersionsResponse
        .builder
        .ifSome(imageVersions)(_.imageVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagesRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListImagesRequest =
      ListImagesRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listImagesResponse(
      images: Option[List[Image]] = None,
      nextToken: Option[String] = None
    ): ListImagesResponse =
      ListImagesResponse
        .builder
        .ifSome(images)(_.images(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLabelingJobsForWorkteamRequest(
      workteamArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      jobReferenceCodeContains: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListLabelingJobsForWorkteamRequest =
      ListLabelingJobsForWorkteamRequest
        .builder
        .ifSome(workteamArn)(_.workteamArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(jobReferenceCodeContains)(_.jobReferenceCodeContains(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listLabelingJobsForWorkteamResponse(
      labelingJobSummaryList: Option[List[LabelingJobForWorkteamSummary]] = None,
      nextToken: Option[String] = None
    ): ListLabelingJobsForWorkteamResponse =
      ListLabelingJobsForWorkteamResponse
        .builder
        .ifSome(labelingJobSummaryList)(_.labelingJobSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLabelingJobsRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      nameContains: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      statusEquals: Option[String] = None
    ): ListLabelingJobsRequest =
      ListLabelingJobsRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .build

    def listLabelingJobsResponse(
      labelingJobSummaryList: Option[List[LabelingJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListLabelingJobsResponse =
      ListLabelingJobsResponse
        .builder
        .ifSome(labelingJobSummaryList)(_.labelingJobSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listModelBiasJobDefinitionsRequest(
      endpointName: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None
    ): ListModelBiasJobDefinitionsRequest =
      ListModelBiasJobDefinitionsRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .build

    def listModelBiasJobDefinitionsResponse(
      jobDefinitionSummaries: Option[List[MonitoringJobDefinitionSummary]] = None,
      nextToken: Option[String] = None
    ): ListModelBiasJobDefinitionsResponse =
      ListModelBiasJobDefinitionsResponse
        .builder
        .ifSome(jobDefinitionSummaries)(_.jobDefinitionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listModelExplainabilityJobDefinitionsRequest(
      endpointName: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None
    ): ListModelExplainabilityJobDefinitionsRequest =
      ListModelExplainabilityJobDefinitionsRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .build

    def listModelExplainabilityJobDefinitionsResponse(
      jobDefinitionSummaries: Option[List[MonitoringJobDefinitionSummary]] = None,
      nextToken: Option[String] = None
    ): ListModelExplainabilityJobDefinitionsResponse =
      ListModelExplainabilityJobDefinitionsResponse
        .builder
        .ifSome(jobDefinitionSummaries)(_.jobDefinitionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listModelPackageGroupsInput(
      creationTimeAfter: Option[CreationTime] = None,
      creationTimeBefore: Option[CreationTime] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListModelPackageGroupsInput =
      ListModelPackageGroupsInput
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listModelPackageGroupsOutput(
      modelPackageGroupSummaryList: Option[List[ModelPackageGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListModelPackageGroupsOutput =
      ListModelPackageGroupsOutput
        .builder
        .ifSome(modelPackageGroupSummaryList)(_.modelPackageGroupSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listModelPackagesInput(
      creationTimeAfter: Option[CreationTime] = None,
      creationTimeBefore: Option[CreationTime] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      modelApprovalStatus: Option[String] = None,
      modelPackageGroupName: Option[String] = None,
      modelPackageType: Option[String] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListModelPackagesInput =
      ListModelPackagesInput
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(modelApprovalStatus)(_.modelApprovalStatus(_))
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageType)(_.modelPackageType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listModelPackagesOutput(
      modelPackageSummaryList: Option[List[ModelPackageSummary]] = None,
      nextToken: Option[String] = None
    ): ListModelPackagesOutput =
      ListModelPackagesOutput
        .builder
        .ifSome(modelPackageSummaryList)(_.modelPackageSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listModelQualityJobDefinitionsRequest(
      endpointName: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None
    ): ListModelQualityJobDefinitionsRequest =
      ListModelQualityJobDefinitionsRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .build

    def listModelQualityJobDefinitionsResponse(
      jobDefinitionSummaries: Option[List[MonitoringJobDefinitionSummary]] = None,
      nextToken: Option[String] = None
    ): ListModelQualityJobDefinitionsResponse =
      ListModelQualityJobDefinitionsResponse
        .builder
        .ifSome(jobDefinitionSummaries)(_.jobDefinitionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listModelsInput(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None
    ): ListModelsInput =
      ListModelsInput
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .build

    def listModelsOutput(
      models: Option[List[ModelSummary]] = None,
      nextToken: Option[String] = None
    ): ListModelsOutput =
      ListModelsOutput
        .builder
        .ifSome(models)(_.models(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMonitoringExecutionsRequest(
      monitoringScheduleName: Option[String] = None,
      endpointName: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      scheduledTimeBefore: Option[Timestamp] = None,
      scheduledTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      statusEquals: Option[String] = None,
      monitoringJobDefinitionName: Option[String] = None,
      monitoringTypeEquals: Option[String] = None
    ): ListMonitoringExecutionsRequest =
      ListMonitoringExecutionsRequest
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(scheduledTimeBefore)(_.scheduledTimeBefore(_))
        .ifSome(scheduledTimeAfter)(_.scheduledTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(monitoringJobDefinitionName)(_.monitoringJobDefinitionName(_))
        .ifSome(monitoringTypeEquals)(_.monitoringTypeEquals(_))
        .build

    def listMonitoringExecutionsResponse(
      monitoringExecutionSummaries: Option[List[MonitoringExecutionSummary]] = None,
      nextToken: Option[String] = None
    ): ListMonitoringExecutionsResponse =
      ListMonitoringExecutionsResponse
        .builder
        .ifSome(monitoringExecutionSummaries)(_.monitoringExecutionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMonitoringSchedulesRequest(
      endpointName: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      statusEquals: Option[String] = None,
      monitoringJobDefinitionName: Option[String] = None,
      monitoringTypeEquals: Option[String] = None
    ): ListMonitoringSchedulesRequest =
      ListMonitoringSchedulesRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(monitoringJobDefinitionName)(_.monitoringJobDefinitionName(_))
        .ifSome(monitoringTypeEquals)(_.monitoringTypeEquals(_))
        .build

    def listMonitoringSchedulesResponse(
      monitoringScheduleSummaries: Option[List[MonitoringScheduleSummary]] = None,
      nextToken: Option[String] = None
    ): ListMonitoringSchedulesResponse =
      ListMonitoringSchedulesResponse
        .builder
        .ifSome(monitoringScheduleSummaries)(_.monitoringScheduleSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNotebookInstanceLifecycleConfigsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[CreationTime] = None,
      creationTimeAfter: Option[CreationTime] = None,
      lastModifiedTimeBefore: Option[LastModifiedTime] = None,
      lastModifiedTimeAfter: Option[LastModifiedTime] = None
    ): ListNotebookInstanceLifecycleConfigsInput =
      ListNotebookInstanceLifecycleConfigsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .build

    def listNotebookInstanceLifecycleConfigsOutput(
      nextToken: Option[String] = None,
      notebookInstanceLifecycleConfigs: Option[List[NotebookInstanceLifecycleConfigSummary]] = None
    ): ListNotebookInstanceLifecycleConfigsOutput =
      ListNotebookInstanceLifecycleConfigsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(notebookInstanceLifecycleConfigs)(_.notebookInstanceLifecycleConfigs(_))
        .build

    def listNotebookInstancesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nameContains: Option[String] = None,
      creationTimeBefore: Option[CreationTime] = None,
      creationTimeAfter: Option[CreationTime] = None,
      lastModifiedTimeBefore: Option[LastModifiedTime] = None,
      lastModifiedTimeAfter: Option[LastModifiedTime] = None,
      statusEquals: Option[String] = None,
      notebookInstanceLifecycleConfigNameContains: Option[String] = None,
      defaultCodeRepositoryContains: Option[String] = None,
      additionalCodeRepositoryEquals: Option[String] = None
    ): ListNotebookInstancesInput =
      ListNotebookInstancesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(notebookInstanceLifecycleConfigNameContains)(_.notebookInstanceLifecycleConfigNameContains(_))
        .ifSome(defaultCodeRepositoryContains)(_.defaultCodeRepositoryContains(_))
        .ifSome(additionalCodeRepositoryEquals)(_.additionalCodeRepositoryEquals(_))
        .build

    def listNotebookInstancesOutput(
      nextToken: Option[String] = None,
      notebookInstances: Option[List[NotebookInstanceSummary]] = None
    ): ListNotebookInstancesOutput =
      ListNotebookInstancesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(notebookInstances)(_.notebookInstances(_))
        .build

    def listPipelineExecutionStepsRequest(
      pipelineExecutionArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortOrder: Option[String] = None
    ): ListPipelineExecutionStepsRequest =
      ListPipelineExecutionStepsRequest
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listPipelineExecutionStepsResponse(
      pipelineExecutionSteps: Option[List[PipelineExecutionStep]] = None,
      nextToken: Option[String] = None
    ): ListPipelineExecutionStepsResponse =
      ListPipelineExecutionStepsResponse
        .builder
        .ifSome(pipelineExecutionSteps)(_.pipelineExecutionSteps(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPipelineExecutionsRequest(
      pipelineName: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPipelineExecutionsRequest =
      ListPipelineExecutionsRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPipelineExecutionsResponse(
      pipelineExecutionSummaries: Option[List[PipelineExecutionSummary]] = None,
      nextToken: Option[String] = None
    ): ListPipelineExecutionsResponse =
      ListPipelineExecutionsResponse
        .builder
        .ifSome(pipelineExecutionSummaries)(_.pipelineExecutionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPipelineParametersForExecutionRequest(
      pipelineExecutionArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPipelineParametersForExecutionRequest =
      ListPipelineParametersForExecutionRequest
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPipelineParametersForExecutionResponse(
      pipelineParameters: Option[List[Parameter]] = None,
      nextToken: Option[String] = None
    ): ListPipelineParametersForExecutionResponse =
      ListPipelineParametersForExecutionResponse
        .builder
        .ifSome(pipelineParameters)(_.pipelineParameters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPipelinesRequest(
      pipelineNamePrefix: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPipelinesRequest =
      ListPipelinesRequest
        .builder
        .ifSome(pipelineNamePrefix)(_.pipelineNamePrefix(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPipelinesResponse(
      pipelineSummaries: Option[List[PipelineSummary]] = None,
      nextToken: Option[String] = None
    ): ListPipelinesResponse =
      ListPipelinesResponse
        .builder
        .ifSome(pipelineSummaries)(_.pipelineSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProcessingJobsRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      nameContains: Option[String] = None,
      statusEquals: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProcessingJobsRequest =
      ListProcessingJobsRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProcessingJobsResponse(
      processingJobSummaries: Option[List[ProcessingJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListProcessingJobsResponse =
      ListProcessingJobsResponse
        .builder
        .ifSome(processingJobSummaries)(_.processingJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsInput(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListProjectsInput =
      ListProjectsInput
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listProjectsOutput(
      projectSummaryList: Option[List[ProjectSummary]] = None,
      nextToken: Option[String] = None
    ): ListProjectsOutput =
      ListProjectsOutput
        .builder
        .ifSome(projectSummaryList)(_.projectSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSubscribedWorkteamsRequest(
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSubscribedWorkteamsRequest =
      ListSubscribedWorkteamsRequest
        .builder
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSubscribedWorkteamsResponse(
      subscribedWorkteams: Option[List[SubscribedWorkteam]] = None,
      nextToken: Option[String] = None
    ): ListSubscribedWorkteamsResponse =
      ListSubscribedWorkteamsResponse
        .builder
        .ifSome(subscribedWorkteams)(_.subscribedWorkteams(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsInput(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsInput =
      ListTagsInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsOutput(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsOutput =
      ListTagsOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrainingJobsForHyperParameterTuningJobRequest(
      hyperParameterTuningJobName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      statusEquals: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListTrainingJobsForHyperParameterTuningJobRequest =
      ListTrainingJobsForHyperParameterTuningJobRequest
        .builder
        .ifSome(hyperParameterTuningJobName)(_.hyperParameterTuningJobName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listTrainingJobsForHyperParameterTuningJobResponse(
      trainingJobSummaries: Option[List[HyperParameterTrainingJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListTrainingJobsForHyperParameterTuningJobResponse =
      ListTrainingJobsForHyperParameterTuningJobResponse
        .builder
        .ifSome(trainingJobSummaries)(_.trainingJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrainingJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      nameContains: Option[String] = None,
      statusEquals: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListTrainingJobsRequest =
      ListTrainingJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listTrainingJobsResponse(
      trainingJobSummaries: Option[List[TrainingJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListTrainingJobsResponse =
      ListTrainingJobsResponse
        .builder
        .ifSome(trainingJobSummaries)(_.trainingJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTransformJobsRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      lastModifiedTimeAfter: Option[Timestamp] = None,
      lastModifiedTimeBefore: Option[Timestamp] = None,
      nameContains: Option[String] = None,
      statusEquals: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTransformJobsRequest =
      ListTransformJobsRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(lastModifiedTimeAfter)(_.lastModifiedTimeAfter(_))
        .ifSome(lastModifiedTimeBefore)(_.lastModifiedTimeBefore(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(statusEquals)(_.statusEquals(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTransformJobsResponse(
      transformJobSummaries: Option[List[TransformJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListTransformJobsResponse =
      ListTransformJobsResponse
        .builder
        .ifSome(transformJobSummaries)(_.transformJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrialComponentsRequest(
      experimentName: Option[String] = None,
      trialName: Option[String] = None,
      sourceArn: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTrialComponentsRequest =
      ListTrialComponentsRequest
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(trialName)(_.trialName(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrialComponentsResponse(
      trialComponentSummaries: Option[List[TrialComponentSummary]] = None,
      nextToken: Option[String] = None
    ): ListTrialComponentsResponse =
      ListTrialComponentsResponse
        .builder
        .ifSome(trialComponentSummaries)(_.trialComponentSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrialsRequest(
      experimentName: Option[String] = None,
      trialComponentName: Option[String] = None,
      createdAfter: Option[Timestamp] = None,
      createdBefore: Option[Timestamp] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTrialsRequest =
      ListTrialsRequest
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrialsResponse(
      trialSummaries: Option[List[TrialSummary]] = None,
      nextToken: Option[String] = None
    ): ListTrialsResponse =
      ListTrialsResponse
        .builder
        .ifSome(trialSummaries)(_.trialSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUserProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      domainIdEquals: Option[String] = None,
      userProfileNameContains: Option[String] = None
    ): ListUserProfilesRequest =
      ListUserProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(domainIdEquals)(_.domainIdEquals(_))
        .ifSome(userProfileNameContains)(_.userProfileNameContains(_))
        .build

    def listUserProfilesResponse(
      userProfiles: Option[List[UserProfileDetails]] = None,
      nextToken: Option[String] = None
    ): ListUserProfilesResponse =
      ListUserProfilesResponse
        .builder
        .ifSome(userProfiles)(_.userProfiles(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorkforcesRequest(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkforcesRequest =
      ListWorkforcesRequest
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkforcesResponse(
      workforces: Option[List[Workforce]] = None,
      nextToken: Option[String] = None
    ): ListWorkforcesResponse =
      ListWorkforcesResponse
        .builder
        .ifSome(workforces)(_.workforces(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorkteamsRequest(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nameContains: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkteamsRequest =
      ListWorkteamsRequest
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nameContains)(_.nameContains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkteamsResponse(
      workteams: Option[List[Workteam]] = None,
      nextToken: Option[String] = None
    ): ListWorkteamsResponse =
      ListWorkteamsResponse
        .builder
        .ifSome(workteams)(_.workteams(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def memberDefinition(
      cognitoMemberDefinition: Option[CognitoMemberDefinition] = None,
      oidcMemberDefinition: Option[OidcMemberDefinition] = None
    ): MemberDefinition =
      MemberDefinition
        .builder
        .ifSome(cognitoMemberDefinition)(_.cognitoMemberDefinition(_))
        .ifSome(oidcMemberDefinition)(_.oidcMemberDefinition(_))
        .build

    def metadataProperties(
      commitId: Option[String] = None,
      repository: Option[String] = None,
      generatedBy: Option[String] = None,
      projectId: Option[String] = None
    ): MetadataProperties =
      MetadataProperties
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(generatedBy)(_.generatedBy(_))
        .ifSome(projectId)(_.projectId(_))
        .build

    def metricData(
      metricName: Option[String] = None,
      value: Option[Float] = None,
      timestamp: Option[Timestamp] = None
    ): MetricData =
      MetricData
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(value)(_.value(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def metricDefinition(
      name: Option[String] = None,
      regex: Option[String] = None
    ): MetricDefinition =
      MetricDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(regex)(_.regex(_))
        .build

    def metricsSource(
      contentType: Option[String] = None,
      contentDigest: Option[String] = None,
      s3Uri: Option[String] = None
    ): MetricsSource =
      MetricsSource
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(contentDigest)(_.contentDigest(_))
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def modelArtifacts(
      s3ModelArtifacts: Option[String] = None
    ): ModelArtifacts =
      ModelArtifacts
        .builder
        .ifSome(s3ModelArtifacts)(_.s3ModelArtifacts(_))
        .build

    def modelBiasAppSpecification(
      imageUri: Option[String] = None,
      configUri: Option[String] = None,
      environment: Option[MonitoringEnvironmentMap] = None
    ): ModelBiasAppSpecification =
      ModelBiasAppSpecification
        .builder
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(configUri)(_.configUri(_))
        .ifSome(environment)(_.environment(_))
        .build

    def modelBiasBaselineConfig(
      baseliningJobName: Option[String] = None,
      constraintsResource: Option[MonitoringConstraintsResource] = None
    ): ModelBiasBaselineConfig =
      ModelBiasBaselineConfig
        .builder
        .ifSome(baseliningJobName)(_.baseliningJobName(_))
        .ifSome(constraintsResource)(_.constraintsResource(_))
        .build

    def modelBiasJobInput(
      endpointInput: Option[EndpointInput] = None,
      groundTruthS3Input: Option[MonitoringGroundTruthS3Input] = None
    ): ModelBiasJobInput =
      ModelBiasJobInput
        .builder
        .ifSome(endpointInput)(_.endpointInput(_))
        .ifSome(groundTruthS3Input)(_.groundTruthS3Input(_))
        .build

    def modelClientConfig(
      invocationsTimeoutInSeconds: Option[Int] = None,
      invocationsMaxRetries: Option[Int] = None
    ): ModelClientConfig =
      ModelClientConfig
        .builder
        .ifSome(invocationsTimeoutInSeconds)(_.invocationsTimeoutInSeconds(_))
        .ifSome(invocationsMaxRetries)(_.invocationsMaxRetries(_))
        .build

    def modelDataQuality(
      statistics: Option[MetricsSource] = None,
      constraints: Option[MetricsSource] = None
    ): ModelDataQuality =
      ModelDataQuality
        .builder
        .ifSome(statistics)(_.statistics(_))
        .ifSome(constraints)(_.constraints(_))
        .build

    def modelDeployConfig(
      autoGenerateEndpointName: Option[Boolean] = None,
      endpointName: Option[String] = None
    ): ModelDeployConfig =
      ModelDeployConfig
        .builder
        .ifSome(autoGenerateEndpointName)(_.autoGenerateEndpointName(_))
        .ifSome(endpointName)(_.endpointName(_))
        .build

    def modelDigests(
      artifactDigest: Option[String] = None
    ): ModelDigests =
      ModelDigests
        .builder
        .ifSome(artifactDigest)(_.artifactDigest(_))
        .build

    def modelExplainabilityAppSpecification(
      imageUri: Option[String] = None,
      configUri: Option[String] = None,
      environment: Option[MonitoringEnvironmentMap] = None
    ): ModelExplainabilityAppSpecification =
      ModelExplainabilityAppSpecification
        .builder
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(configUri)(_.configUri(_))
        .ifSome(environment)(_.environment(_))
        .build

    def modelExplainabilityBaselineConfig(
      baseliningJobName: Option[String] = None,
      constraintsResource: Option[MonitoringConstraintsResource] = None
    ): ModelExplainabilityBaselineConfig =
      ModelExplainabilityBaselineConfig
        .builder
        .ifSome(baseliningJobName)(_.baseliningJobName(_))
        .ifSome(constraintsResource)(_.constraintsResource(_))
        .build

    def modelExplainabilityJobInput(
      endpointInput: Option[EndpointInput] = None
    ): ModelExplainabilityJobInput =
      ModelExplainabilityJobInput
        .builder
        .ifSome(endpointInput)(_.endpointInput(_))
        .build

    def modelMetrics(
      modelQuality: Option[ModelQuality] = None,
      modelDataQuality: Option[ModelDataQuality] = None,
      bias: Option[Bias] = None,
      explainability: Option[Explainability] = None
    ): ModelMetrics =
      ModelMetrics
        .builder
        .ifSome(modelQuality)(_.modelQuality(_))
        .ifSome(modelDataQuality)(_.modelDataQuality(_))
        .ifSome(bias)(_.bias(_))
        .ifSome(explainability)(_.explainability(_))
        .build

    def modelPackage(
      modelPackageName: Option[String] = None,
      modelPackageGroupName: Option[String] = None,
      modelPackageVersion: Option[Int] = None,
      modelPackageArn: Option[String] = None,
      modelPackageDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      inferenceSpecification: Option[InferenceSpecification] = None,
      sourceAlgorithmSpecification: Option[SourceAlgorithmSpecification] = None,
      validationSpecification: Option[ModelPackageValidationSpecification] = None,
      modelPackageStatus: Option[String] = None,
      modelPackageStatusDetails: Option[ModelPackageStatusDetails] = None,
      certifyForMarketplace: Option[Boolean] = None,
      modelApprovalStatus: Option[String] = None,
      createdBy: Option[UserContext] = None,
      metadataProperties: Option[MetadataProperties] = None,
      modelMetrics: Option[ModelMetrics] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      approvalDescription: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ModelPackage =
      ModelPackage
        .builder
        .ifSome(modelPackageName)(_.modelPackageName(_))
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageVersion)(_.modelPackageVersion(_))
        .ifSome(modelPackageArn)(_.modelPackageArn(_))
        .ifSome(modelPackageDescription)(_.modelPackageDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(inferenceSpecification)(_.inferenceSpecification(_))
        .ifSome(sourceAlgorithmSpecification)(_.sourceAlgorithmSpecification(_))
        .ifSome(validationSpecification)(_.validationSpecification(_))
        .ifSome(modelPackageStatus)(_.modelPackageStatus(_))
        .ifSome(modelPackageStatusDetails)(_.modelPackageStatusDetails(_))
        .ifSome(certifyForMarketplace)(_.certifyForMarketplace(_))
        .ifSome(modelApprovalStatus)(_.modelApprovalStatus(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(modelMetrics)(_.modelMetrics(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(approvalDescription)(_.approvalDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def modelPackageContainerDefinition(
      containerHostname: Option[String] = None,
      image: Option[String] = None,
      imageDigest: Option[String] = None,
      modelDataUrl: Option[String] = None,
      productId: Option[String] = None
    ): ModelPackageContainerDefinition =
      ModelPackageContainerDefinition
        .builder
        .ifSome(containerHostname)(_.containerHostname(_))
        .ifSome(image)(_.image(_))
        .ifSome(imageDigest)(_.imageDigest(_))
        .ifSome(modelDataUrl)(_.modelDataUrl(_))
        .ifSome(productId)(_.productId(_))
        .build

    def modelPackageGroup(
      modelPackageGroupName: Option[String] = None,
      modelPackageGroupArn: Option[String] = None,
      modelPackageGroupDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      createdBy: Option[UserContext] = None,
      modelPackageGroupStatus: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ModelPackageGroup =
      ModelPackageGroup
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageGroupArn)(_.modelPackageGroupArn(_))
        .ifSome(modelPackageGroupDescription)(_.modelPackageGroupDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(modelPackageGroupStatus)(_.modelPackageGroupStatus(_))
        .ifSome(tags)(_.tags(_))
        .build

    def modelPackageGroupSummary(
      modelPackageGroupName: Option[String] = None,
      modelPackageGroupArn: Option[String] = None,
      modelPackageGroupDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      modelPackageGroupStatus: Option[String] = None
    ): ModelPackageGroupSummary =
      ModelPackageGroupSummary
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageGroupArn)(_.modelPackageGroupArn(_))
        .ifSome(modelPackageGroupDescription)(_.modelPackageGroupDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modelPackageGroupStatus)(_.modelPackageGroupStatus(_))
        .build

    def modelPackageStatusDetails(
      validationStatuses: Option[List[ModelPackageStatusItem]] = None,
      imageScanStatuses: Option[List[ModelPackageStatusItem]] = None
    ): ModelPackageStatusDetails =
      ModelPackageStatusDetails
        .builder
        .ifSome(validationStatuses)(_.validationStatuses(_))
        .ifSome(imageScanStatuses)(_.imageScanStatuses(_))
        .build

    def modelPackageStatusItem(
      name: Option[String] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None
    ): ModelPackageStatusItem =
      ModelPackageStatusItem
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def modelPackageSummary(
      modelPackageName: Option[String] = None,
      modelPackageGroupName: Option[String] = None,
      modelPackageVersion: Option[Int] = None,
      modelPackageArn: Option[String] = None,
      modelPackageDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      modelPackageStatus: Option[String] = None,
      modelApprovalStatus: Option[String] = None
    ): ModelPackageSummary =
      ModelPackageSummary
        .builder
        .ifSome(modelPackageName)(_.modelPackageName(_))
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(modelPackageVersion)(_.modelPackageVersion(_))
        .ifSome(modelPackageArn)(_.modelPackageArn(_))
        .ifSome(modelPackageDescription)(_.modelPackageDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(modelPackageStatus)(_.modelPackageStatus(_))
        .ifSome(modelApprovalStatus)(_.modelApprovalStatus(_))
        .build

    def modelPackageValidationProfile(
      profileName: Option[String] = None,
      transformJobDefinition: Option[TransformJobDefinition] = None
    ): ModelPackageValidationProfile =
      ModelPackageValidationProfile
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(transformJobDefinition)(_.transformJobDefinition(_))
        .build

    def modelPackageValidationSpecification(
      validationRole: Option[String] = None,
      validationProfiles: Option[List[ModelPackageValidationProfile]] = None
    ): ModelPackageValidationSpecification =
      ModelPackageValidationSpecification
        .builder
        .ifSome(validationRole)(_.validationRole(_))
        .ifSome(validationProfiles)(_.validationProfiles(_))
        .build

    def modelQuality(
      statistics: Option[MetricsSource] = None,
      constraints: Option[MetricsSource] = None
    ): ModelQuality =
      ModelQuality
        .builder
        .ifSome(statistics)(_.statistics(_))
        .ifSome(constraints)(_.constraints(_))
        .build

    def modelQualityAppSpecification(
      imageUri: Option[String] = None,
      containerEntrypoint: Option[List[ContainerEntrypointString]] = None,
      containerArguments: Option[List[ContainerArgument]] = None,
      recordPreprocessorSourceUri: Option[String] = None,
      postAnalyticsProcessorSourceUri: Option[String] = None,
      problemType: Option[String] = None,
      environment: Option[MonitoringEnvironmentMap] = None
    ): ModelQualityAppSpecification =
      ModelQualityAppSpecification
        .builder
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(containerEntrypoint)(_.containerEntrypoint(_))
        .ifSome(containerArguments)(_.containerArguments(_))
        .ifSome(recordPreprocessorSourceUri)(_.recordPreprocessorSourceUri(_))
        .ifSome(postAnalyticsProcessorSourceUri)(_.postAnalyticsProcessorSourceUri(_))
        .ifSome(problemType)(_.problemType(_))
        .ifSome(environment)(_.environment(_))
        .build

    def modelQualityBaselineConfig(
      baseliningJobName: Option[String] = None,
      constraintsResource: Option[MonitoringConstraintsResource] = None
    ): ModelQualityBaselineConfig =
      ModelQualityBaselineConfig
        .builder
        .ifSome(baseliningJobName)(_.baseliningJobName(_))
        .ifSome(constraintsResource)(_.constraintsResource(_))
        .build

    def modelQualityJobInput(
      endpointInput: Option[EndpointInput] = None,
      groundTruthS3Input: Option[MonitoringGroundTruthS3Input] = None
    ): ModelQualityJobInput =
      ModelQualityJobInput
        .builder
        .ifSome(endpointInput)(_.endpointInput(_))
        .ifSome(groundTruthS3Input)(_.groundTruthS3Input(_))
        .build

    def modelStepMetadata(
      arn: Option[String] = None
    ): ModelStepMetadata =
      ModelStepMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def modelSummary(
      modelName: Option[String] = None,
      modelArn: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): ModelSummary =
      ModelSummary
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def monitoringAppSpecification(
      imageUri: Option[String] = None,
      containerEntrypoint: Option[List[ContainerEntrypointString]] = None,
      containerArguments: Option[List[ContainerArgument]] = None,
      recordPreprocessorSourceUri: Option[String] = None,
      postAnalyticsProcessorSourceUri: Option[String] = None
    ): MonitoringAppSpecification =
      MonitoringAppSpecification
        .builder
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(containerEntrypoint)(_.containerEntrypoint(_))
        .ifSome(containerArguments)(_.containerArguments(_))
        .ifSome(recordPreprocessorSourceUri)(_.recordPreprocessorSourceUri(_))
        .ifSome(postAnalyticsProcessorSourceUri)(_.postAnalyticsProcessorSourceUri(_))
        .build

    def monitoringBaselineConfig(
      baseliningJobName: Option[String] = None,
      constraintsResource: Option[MonitoringConstraintsResource] = None,
      statisticsResource: Option[MonitoringStatisticsResource] = None
    ): MonitoringBaselineConfig =
      MonitoringBaselineConfig
        .builder
        .ifSome(baseliningJobName)(_.baseliningJobName(_))
        .ifSome(constraintsResource)(_.constraintsResource(_))
        .ifSome(statisticsResource)(_.statisticsResource(_))
        .build

    def monitoringClusterConfig(
      instanceCount: Option[Int] = None,
      instanceType: Option[String] = None,
      volumeSizeInGB: Option[Int] = None,
      volumeKmsKeyId: Option[String] = None
    ): MonitoringClusterConfig =
      MonitoringClusterConfig
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .build

    def monitoringConstraintsResource(
      s3Uri: Option[String] = None
    ): MonitoringConstraintsResource =
      MonitoringConstraintsResource
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def monitoringExecutionSummary(
      monitoringScheduleName: Option[String] = None,
      scheduledTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      monitoringExecutionStatus: Option[String] = None,
      processingJobArn: Option[String] = None,
      endpointName: Option[String] = None,
      failureReason: Option[String] = None,
      monitoringJobDefinitionName: Option[String] = None,
      monitoringType: Option[String] = None
    ): MonitoringExecutionSummary =
      MonitoringExecutionSummary
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .ifSome(scheduledTime)(_.scheduledTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(monitoringExecutionStatus)(_.monitoringExecutionStatus(_))
        .ifSome(processingJobArn)(_.processingJobArn(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(monitoringJobDefinitionName)(_.monitoringJobDefinitionName(_))
        .ifSome(monitoringType)(_.monitoringType(_))
        .build

    def monitoringGroundTruthS3Input(
      s3Uri: Option[String] = None
    ): MonitoringGroundTruthS3Input =
      MonitoringGroundTruthS3Input
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def monitoringInput(
      endpointInput: Option[EndpointInput] = None
    ): MonitoringInput =
      MonitoringInput
        .builder
        .ifSome(endpointInput)(_.endpointInput(_))
        .build

    def monitoringJobDefinition(
      baselineConfig: Option[MonitoringBaselineConfig] = None,
      monitoringInputs: Option[List[MonitoringInput]] = None,
      monitoringOutputConfig: Option[MonitoringOutputConfig] = None,
      monitoringResources: Option[MonitoringResources] = None,
      monitoringAppSpecification: Option[MonitoringAppSpecification] = None,
      stoppingCondition: Option[MonitoringStoppingCondition] = None,
      environment: Option[MonitoringEnvironmentMap] = None,
      networkConfig: Option[NetworkConfig] = None,
      roleArn: Option[String] = None
    ): MonitoringJobDefinition =
      MonitoringJobDefinition
        .builder
        .ifSome(baselineConfig)(_.baselineConfig(_))
        .ifSome(monitoringInputs)(_.monitoringInputs(_))
        .ifSome(monitoringOutputConfig)(_.monitoringOutputConfig(_))
        .ifSome(monitoringResources)(_.monitoringResources(_))
        .ifSome(monitoringAppSpecification)(_.monitoringAppSpecification(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def monitoringJobDefinitionSummary(
      monitoringJobDefinitionName: Option[String] = None,
      monitoringJobDefinitionArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      endpointName: Option[String] = None
    ): MonitoringJobDefinitionSummary =
      MonitoringJobDefinitionSummary
        .builder
        .ifSome(monitoringJobDefinitionName)(_.monitoringJobDefinitionName(_))
        .ifSome(monitoringJobDefinitionArn)(_.monitoringJobDefinitionArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(endpointName)(_.endpointName(_))
        .build

    def monitoringNetworkConfig(
      enableInterContainerTrafficEncryption: Option[Boolean] = None,
      enableNetworkIsolation: Option[Boolean] = None,
      vpcConfig: Option[VpcConfig] = None
    ): MonitoringNetworkConfig =
      MonitoringNetworkConfig
        .builder
        .ifSome(enableInterContainerTrafficEncryption)(_.enableInterContainerTrafficEncryption(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def monitoringOutput(
      s3Output: Option[MonitoringS3Output] = None
    ): MonitoringOutput =
      MonitoringOutput
        .builder
        .ifSome(s3Output)(_.s3Output(_))
        .build

    def monitoringOutputConfig(
      monitoringOutputs: Option[List[MonitoringOutput]] = None,
      kmsKeyId: Option[String] = None
    ): MonitoringOutputConfig =
      MonitoringOutputConfig
        .builder
        .ifSome(monitoringOutputs)(_.monitoringOutputs(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def monitoringResources(
      clusterConfig: Option[MonitoringClusterConfig] = None
    ): MonitoringResources =
      MonitoringResources
        .builder
        .ifSome(clusterConfig)(_.clusterConfig(_))
        .build

    def monitoringS3Output(
      s3Uri: Option[String] = None,
      localPath: Option[String] = None,
      s3UploadMode: Option[String] = None
    ): MonitoringS3Output =
      MonitoringS3Output
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3UploadMode)(_.s3UploadMode(_))
        .build

    def monitoringSchedule(
      monitoringScheduleArn: Option[String] = None,
      monitoringScheduleName: Option[String] = None,
      monitoringScheduleStatus: Option[String] = None,
      monitoringType: Option[String] = None,
      failureReason: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      monitoringScheduleConfig: Option[MonitoringScheduleConfig] = None,
      endpointName: Option[String] = None,
      lastMonitoringExecutionSummary: Option[MonitoringExecutionSummary] = None,
      tags: Option[List[Tag]] = None
    ): MonitoringSchedule =
      MonitoringSchedule
        .builder
        .ifSome(monitoringScheduleArn)(_.monitoringScheduleArn(_))
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .ifSome(monitoringScheduleStatus)(_.monitoringScheduleStatus(_))
        .ifSome(monitoringType)(_.monitoringType(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(monitoringScheduleConfig)(_.monitoringScheduleConfig(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(lastMonitoringExecutionSummary)(_.lastMonitoringExecutionSummary(_))
        .ifSome(tags)(_.tags(_))
        .build

    def monitoringScheduleConfig(
      scheduleConfig: Option[ScheduleConfig] = None,
      monitoringJobDefinition: Option[MonitoringJobDefinition] = None,
      monitoringJobDefinitionName: Option[String] = None,
      monitoringType: Option[String] = None
    ): MonitoringScheduleConfig =
      MonitoringScheduleConfig
        .builder
        .ifSome(scheduleConfig)(_.scheduleConfig(_))
        .ifSome(monitoringJobDefinition)(_.monitoringJobDefinition(_))
        .ifSome(monitoringJobDefinitionName)(_.monitoringJobDefinitionName(_))
        .ifSome(monitoringType)(_.monitoringType(_))
        .build

    def monitoringScheduleSummary(
      monitoringScheduleName: Option[String] = None,
      monitoringScheduleArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      monitoringScheduleStatus: Option[String] = None,
      endpointName: Option[String] = None,
      monitoringJobDefinitionName: Option[String] = None,
      monitoringType: Option[String] = None
    ): MonitoringScheduleSummary =
      MonitoringScheduleSummary
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .ifSome(monitoringScheduleArn)(_.monitoringScheduleArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(monitoringScheduleStatus)(_.monitoringScheduleStatus(_))
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(monitoringJobDefinitionName)(_.monitoringJobDefinitionName(_))
        .ifSome(monitoringType)(_.monitoringType(_))
        .build

    def monitoringStatisticsResource(
      s3Uri: Option[String] = None
    ): MonitoringStatisticsResource =
      MonitoringStatisticsResource
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def monitoringStoppingCondition(
      maxRuntimeInSeconds: Option[Int] = None
    ): MonitoringStoppingCondition =
      MonitoringStoppingCondition
        .builder
        .ifSome(maxRuntimeInSeconds)(_.maxRuntimeInSeconds(_))
        .build

    def multiModelConfig(
      modelCacheSetting: Option[String] = None
    ): MultiModelConfig =
      MultiModelConfig
        .builder
        .ifSome(modelCacheSetting)(_.modelCacheSetting(_))
        .build

    def nestedFilters(
      nestedPropertyName: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): NestedFilters =
      NestedFilters
        .builder
        .ifSome(nestedPropertyName)(_.nestedPropertyName(_))
        .ifSome(filters)(_.filters(_))
        .build

    def networkConfig(
      enableInterContainerTrafficEncryption: Option[Boolean] = None,
      enableNetworkIsolation: Option[Boolean] = None,
      vpcConfig: Option[VpcConfig] = None
    ): NetworkConfig =
      NetworkConfig
        .builder
        .ifSome(enableInterContainerTrafficEncryption)(_.enableInterContainerTrafficEncryption(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def notebookInstanceLifecycleConfigSummary(
      notebookInstanceLifecycleConfigName: Option[String] = None,
      notebookInstanceLifecycleConfigArn: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None
    ): NotebookInstanceLifecycleConfigSummary =
      NotebookInstanceLifecycleConfigSummary
        .builder
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .ifSome(notebookInstanceLifecycleConfigArn)(_.notebookInstanceLifecycleConfigArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def notebookInstanceLifecycleHook(
      content: Option[String] = None
    ): NotebookInstanceLifecycleHook =
      NotebookInstanceLifecycleHook
        .builder
        .ifSome(content)(_.content(_))
        .build

    def notebookInstanceSummary(
      notebookInstanceName: Option[String] = None,
      notebookInstanceArn: Option[String] = None,
      notebookInstanceStatus: Option[String] = None,
      url: Option[String] = None,
      instanceType: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None,
      notebookInstanceLifecycleConfigName: Option[String] = None,
      defaultCodeRepository: Option[String] = None,
      additionalCodeRepositories: Option[List[CodeRepositoryNameOrUrl]] = None
    ): NotebookInstanceSummary =
      NotebookInstanceSummary
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .ifSome(notebookInstanceArn)(_.notebookInstanceArn(_))
        .ifSome(notebookInstanceStatus)(_.notebookInstanceStatus(_))
        .ifSome(url)(_.url(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .ifSome(defaultCodeRepository)(_.defaultCodeRepository(_))
        .ifSome(additionalCodeRepositories)(_.additionalCodeRepositories(_))
        .build

    def notificationConfiguration(
      notificationTopicArn: Option[String] = None
    ): NotificationConfiguration =
      NotificationConfiguration
        .builder
        .ifSome(notificationTopicArn)(_.notificationTopicArn(_))
        .build

    def objectiveStatusCounters(
      succeeded: Option[Int] = None,
      pending: Option[Int] = None,
      failed: Option[Int] = None
    ): ObjectiveStatusCounters =
      ObjectiveStatusCounters
        .builder
        .ifSome(succeeded)(_.succeeded(_))
        .ifSome(pending)(_.pending(_))
        .ifSome(failed)(_.failed(_))
        .build

    def offlineStoreConfig(
      s3StorageConfig: Option[S3StorageConfig] = None,
      disableGlueTableCreation: Option[Boolean] = None,
      dataCatalogConfig: Option[DataCatalogConfig] = None
    ): OfflineStoreConfig =
      OfflineStoreConfig
        .builder
        .ifSome(s3StorageConfig)(_.s3StorageConfig(_))
        .ifSome(disableGlueTableCreation)(_.disableGlueTableCreation(_))
        .ifSome(dataCatalogConfig)(_.dataCatalogConfig(_))
        .build

    def offlineStoreStatus(
      status: Option[String] = None,
      blockedReason: Option[String] = None
    ): OfflineStoreStatus =
      OfflineStoreStatus
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(blockedReason)(_.blockedReason(_))
        .build

    def oidcConfig(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      issuer: Option[String] = None,
      authorizationEndpoint: Option[String] = None,
      tokenEndpoint: Option[String] = None,
      userInfoEndpoint: Option[String] = None,
      logoutEndpoint: Option[String] = None,
      jwksUri: Option[String] = None
    ): OidcConfig =
      OidcConfig
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(authorizationEndpoint)(_.authorizationEndpoint(_))
        .ifSome(tokenEndpoint)(_.tokenEndpoint(_))
        .ifSome(userInfoEndpoint)(_.userInfoEndpoint(_))
        .ifSome(logoutEndpoint)(_.logoutEndpoint(_))
        .ifSome(jwksUri)(_.jwksUri(_))
        .build

    def oidcConfigForResponse(
      clientId: Option[String] = None,
      issuer: Option[String] = None,
      authorizationEndpoint: Option[String] = None,
      tokenEndpoint: Option[String] = None,
      userInfoEndpoint: Option[String] = None,
      logoutEndpoint: Option[String] = None,
      jwksUri: Option[String] = None
    ): OidcConfigForResponse =
      OidcConfigForResponse
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(authorizationEndpoint)(_.authorizationEndpoint(_))
        .ifSome(tokenEndpoint)(_.tokenEndpoint(_))
        .ifSome(userInfoEndpoint)(_.userInfoEndpoint(_))
        .ifSome(logoutEndpoint)(_.logoutEndpoint(_))
        .ifSome(jwksUri)(_.jwksUri(_))
        .build

    def oidcMemberDefinition(
      groups: Option[List[Group]] = None
    ): OidcMemberDefinition =
      OidcMemberDefinition
        .builder
        .ifSome(groups)(_.groups(_))
        .build

    def onlineStoreConfig(
      securityConfig: Option[OnlineStoreSecurityConfig] = None,
      enableOnlineStore: Option[Boolean] = None
    ): OnlineStoreConfig =
      OnlineStoreConfig
        .builder
        .ifSome(securityConfig)(_.securityConfig(_))
        .ifSome(enableOnlineStore)(_.enableOnlineStore(_))
        .build

    def onlineStoreSecurityConfig(
      kmsKeyId: Option[String] = None
    ): OnlineStoreSecurityConfig =
      OnlineStoreSecurityConfig
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def outputConfig(
      s3OutputLocation: Option[String] = None,
      targetDevice: Option[String] = None,
      targetPlatform: Option[TargetPlatform] = None,
      compilerOptions: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): OutputConfig =
      OutputConfig
        .builder
        .ifSome(s3OutputLocation)(_.s3OutputLocation(_))
        .ifSome(targetDevice)(_.targetDevice(_))
        .ifSome(targetPlatform)(_.targetPlatform(_))
        .ifSome(compilerOptions)(_.compilerOptions(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def outputDataConfig(
      kmsKeyId: Option[String] = None,
      s3OutputPath: Option[String] = None
    ): OutputDataConfig =
      OutputDataConfig
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .build

    def outputParameter(
      name: Option[String] = None,
      value: Option[String] = None
    ): OutputParameter =
      OutputParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def parameter(
      name: Option[String] = None,
      value: Option[String] = None
    ): Parameter =
      Parameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def parameterRange(
      integerParameterRangeSpecification: Option[IntegerParameterRangeSpecification] = None,
      continuousParameterRangeSpecification: Option[ContinuousParameterRangeSpecification] = None,
      categoricalParameterRangeSpecification: Option[CategoricalParameterRangeSpecification] = None
    ): ParameterRange =
      ParameterRange
        .builder
        .ifSome(integerParameterRangeSpecification)(_.integerParameterRangeSpecification(_))
        .ifSome(continuousParameterRangeSpecification)(_.continuousParameterRangeSpecification(_))
        .ifSome(categoricalParameterRangeSpecification)(_.categoricalParameterRangeSpecification(_))
        .build

    def parameterRanges(
      integerParameterRanges: Option[List[IntegerParameterRange]] = None,
      continuousParameterRanges: Option[List[ContinuousParameterRange]] = None,
      categoricalParameterRanges: Option[List[CategoricalParameterRange]] = None
    ): ParameterRanges =
      ParameterRanges
        .builder
        .ifSome(integerParameterRanges)(_.integerParameterRanges(_))
        .ifSome(continuousParameterRanges)(_.continuousParameterRanges(_))
        .ifSome(categoricalParameterRanges)(_.categoricalParameterRanges(_))
        .build

    def parent(
      trialName: Option[String] = None,
      experimentName: Option[String] = None
    ): Parent =
      Parent
        .builder
        .ifSome(trialName)(_.trialName(_))
        .ifSome(experimentName)(_.experimentName(_))
        .build

    def parentHyperParameterTuningJob(
      hyperParameterTuningJobName: Option[String] = None
    ): ParentHyperParameterTuningJob =
      ParentHyperParameterTuningJob
        .builder
        .ifSome(hyperParameterTuningJobName)(_.hyperParameterTuningJobName(_))
        .build

    def pipeline(
      pipelineArn: Option[String] = None,
      pipelineName: Option[String] = None,
      pipelineDisplayName: Option[String] = None,
      pipelineDescription: Option[String] = None,
      roleArn: Option[String] = None,
      pipelineStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastRunTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedBy: Option[UserContext] = None,
      tags: Option[List[Tag]] = None
    ): Pipeline =
      Pipeline
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineDisplayName)(_.pipelineDisplayName(_))
        .ifSome(pipelineDescription)(_.pipelineDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(pipelineStatus)(_.pipelineStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastRunTime)(_.lastRunTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def pipelineExecution(
      pipelineArn: Option[String] = None,
      pipelineExecutionArn: Option[String] = None,
      pipelineExecutionDisplayName: Option[String] = None,
      pipelineExecutionStatus: Option[String] = None,
      pipelineExecutionDescription: Option[String] = None,
      pipelineExperimentConfig: Option[PipelineExperimentConfig] = None,
      failureReason: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedBy: Option[UserContext] = None,
      pipelineParameters: Option[List[Parameter]] = None
    ): PipelineExecution =
      PipelineExecution
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .ifSome(pipelineExecutionDisplayName)(_.pipelineExecutionDisplayName(_))
        .ifSome(pipelineExecutionStatus)(_.pipelineExecutionStatus(_))
        .ifSome(pipelineExecutionDescription)(_.pipelineExecutionDescription(_))
        .ifSome(pipelineExperimentConfig)(_.pipelineExperimentConfig(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(pipelineParameters)(_.pipelineParameters(_))
        .build

    def pipelineExecutionStep(
      stepName: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      stepStatus: Option[String] = None,
      cacheHitResult: Option[CacheHitResult] = None,
      failureReason: Option[String] = None,
      metadata: Option[PipelineExecutionStepMetadata] = None
    ): PipelineExecutionStep =
      PipelineExecutionStep
        .builder
        .ifSome(stepName)(_.stepName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(stepStatus)(_.stepStatus(_))
        .ifSome(cacheHitResult)(_.cacheHitResult(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def pipelineExecutionStepMetadata(
      trainingJob: Option[TrainingJobStepMetadata] = None,
      processingJob: Option[ProcessingJobStepMetadata] = None,
      transformJob: Option[TransformJobStepMetadata] = None,
      model: Option[ModelStepMetadata] = None,
      registerModel: Option[RegisterModelStepMetadata] = None,
      condition: Option[ConditionStepMetadata] = None,
      callback: Option[CallbackStepMetadata] = None
    ): PipelineExecutionStepMetadata =
      PipelineExecutionStepMetadata
        .builder
        .ifSome(trainingJob)(_.trainingJob(_))
        .ifSome(processingJob)(_.processingJob(_))
        .ifSome(transformJob)(_.transformJob(_))
        .ifSome(model)(_.model(_))
        .ifSome(registerModel)(_.registerModel(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(callback)(_.callback(_))
        .build

    def pipelineExecutionSummary(
      pipelineExecutionArn: Option[String] = None,
      startTime: Option[Timestamp] = None,
      pipelineExecutionStatus: Option[String] = None,
      pipelineExecutionDescription: Option[String] = None,
      pipelineExecutionDisplayName: Option[String] = None
    ): PipelineExecutionSummary =
      PipelineExecutionSummary
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(pipelineExecutionStatus)(_.pipelineExecutionStatus(_))
        .ifSome(pipelineExecutionDescription)(_.pipelineExecutionDescription(_))
        .ifSome(pipelineExecutionDisplayName)(_.pipelineExecutionDisplayName(_))
        .build

    def pipelineExperimentConfig(
      experimentName: Option[String] = None,
      trialName: Option[String] = None
    ): PipelineExperimentConfig =
      PipelineExperimentConfig
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(trialName)(_.trialName(_))
        .build

    def pipelineSummary(
      pipelineArn: Option[String] = None,
      pipelineName: Option[String] = None,
      pipelineDisplayName: Option[String] = None,
      pipelineDescription: Option[String] = None,
      roleArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastExecutionTime: Option[Timestamp] = None
    ): PipelineSummary =
      PipelineSummary
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineDisplayName)(_.pipelineDisplayName(_))
        .ifSome(pipelineDescription)(_.pipelineDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastExecutionTime)(_.lastExecutionTime(_))
        .build

    def processingClusterConfig(
      instanceCount: Option[Int] = None,
      instanceType: Option[String] = None,
      volumeSizeInGB: Option[Int] = None,
      volumeKmsKeyId: Option[String] = None
    ): ProcessingClusterConfig =
      ProcessingClusterConfig
        .builder
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .build

    def processingFeatureStoreOutput(
      featureGroupName: Option[String] = None
    ): ProcessingFeatureStoreOutput =
      ProcessingFeatureStoreOutput
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .build

    def processingInput(
      inputName: Option[String] = None,
      appManaged: Option[Boolean] = None,
      s3Input: Option[ProcessingS3Input] = None,
      datasetDefinition: Option[DatasetDefinition] = None
    ): ProcessingInput =
      ProcessingInput
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(appManaged)(_.appManaged(_))
        .ifSome(s3Input)(_.s3Input(_))
        .ifSome(datasetDefinition)(_.datasetDefinition(_))
        .build

    def processingJob(
      processingInputs: Option[List[ProcessingInput]] = None,
      processingOutputConfig: Option[ProcessingOutputConfig] = None,
      processingJobName: Option[String] = None,
      processingResources: Option[ProcessingResources] = None,
      stoppingCondition: Option[ProcessingStoppingCondition] = None,
      appSpecification: Option[AppSpecification] = None,
      environment: Option[ProcessingEnvironmentMap] = None,
      networkConfig: Option[NetworkConfig] = None,
      roleArn: Option[String] = None,
      experimentConfig: Option[ExperimentConfig] = None,
      processingJobArn: Option[String] = None,
      processingJobStatus: Option[String] = None,
      exitMessage: Option[String] = None,
      failureReason: Option[String] = None,
      processingEndTime: Option[Timestamp] = None,
      processingStartTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None,
      monitoringScheduleArn: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      trainingJobArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ProcessingJob =
      ProcessingJob
        .builder
        .ifSome(processingInputs)(_.processingInputs(_))
        .ifSome(processingOutputConfig)(_.processingOutputConfig(_))
        .ifSome(processingJobName)(_.processingJobName(_))
        .ifSome(processingResources)(_.processingResources(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(appSpecification)(_.appSpecification(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(networkConfig)(_.networkConfig(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .ifSome(processingJobArn)(_.processingJobArn(_))
        .ifSome(processingJobStatus)(_.processingJobStatus(_))
        .ifSome(exitMessage)(_.exitMessage(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(processingEndTime)(_.processingEndTime(_))
        .ifSome(processingStartTime)(_.processingStartTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(monitoringScheduleArn)(_.monitoringScheduleArn(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def processingJobStepMetadata(
      arn: Option[String] = None
    ): ProcessingJobStepMetadata =
      ProcessingJobStepMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def processingJobSummary(
      processingJobName: Option[String] = None,
      processingJobArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      processingEndTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      processingJobStatus: Option[String] = None,
      failureReason: Option[String] = None,
      exitMessage: Option[String] = None
    ): ProcessingJobSummary =
      ProcessingJobSummary
        .builder
        .ifSome(processingJobName)(_.processingJobName(_))
        .ifSome(processingJobArn)(_.processingJobArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(processingEndTime)(_.processingEndTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(processingJobStatus)(_.processingJobStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(exitMessage)(_.exitMessage(_))
        .build

    def processingOutput(
      outputName: Option[String] = None,
      s3Output: Option[ProcessingS3Output] = None,
      featureStoreOutput: Option[ProcessingFeatureStoreOutput] = None,
      appManaged: Option[Boolean] = None
    ): ProcessingOutput =
      ProcessingOutput
        .builder
        .ifSome(outputName)(_.outputName(_))
        .ifSome(s3Output)(_.s3Output(_))
        .ifSome(featureStoreOutput)(_.featureStoreOutput(_))
        .ifSome(appManaged)(_.appManaged(_))
        .build

    def processingOutputConfig(
      outputs: Option[List[ProcessingOutput]] = None,
      kmsKeyId: Option[String] = None
    ): ProcessingOutputConfig =
      ProcessingOutputConfig
        .builder
        .ifSome(outputs)(_.outputs(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def processingResources(
      clusterConfig: Option[ProcessingClusterConfig] = None
    ): ProcessingResources =
      ProcessingResources
        .builder
        .ifSome(clusterConfig)(_.clusterConfig(_))
        .build

    def processingS3Input(
      s3Uri: Option[String] = None,
      localPath: Option[String] = None,
      s3DataType: Option[String] = None,
      s3InputMode: Option[String] = None,
      s3DataDistributionType: Option[String] = None,
      s3CompressionType: Option[String] = None
    ): ProcessingS3Input =
      ProcessingS3Input
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3DataType)(_.s3DataType(_))
        .ifSome(s3InputMode)(_.s3InputMode(_))
        .ifSome(s3DataDistributionType)(_.s3DataDistributionType(_))
        .ifSome(s3CompressionType)(_.s3CompressionType(_))
        .build

    def processingS3Output(
      s3Uri: Option[String] = None,
      localPath: Option[String] = None,
      s3UploadMode: Option[String] = None
    ): ProcessingS3Output =
      ProcessingS3Output
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3UploadMode)(_.s3UploadMode(_))
        .build

    def processingStoppingCondition(
      maxRuntimeInSeconds: Option[Int] = None
    ): ProcessingStoppingCondition =
      ProcessingStoppingCondition
        .builder
        .ifSome(maxRuntimeInSeconds)(_.maxRuntimeInSeconds(_))
        .build

    def productionVariant(
      variantName: Option[String] = None,
      modelName: Option[String] = None,
      initialInstanceCount: Option[Int] = None,
      instanceType: Option[String] = None,
      initialVariantWeight: Option[VariantWeight] = None,
      acceleratorType: Option[String] = None,
      coreDumpConfig: Option[ProductionVariantCoreDumpConfig] = None
    ): ProductionVariant =
      ProductionVariant
        .builder
        .ifSome(variantName)(_.variantName(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(initialInstanceCount)(_.initialInstanceCount(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(initialVariantWeight)(_.initialVariantWeight(_))
        .ifSome(acceleratorType)(_.acceleratorType(_))
        .ifSome(coreDumpConfig)(_.coreDumpConfig(_))
        .build

    def productionVariantCoreDumpConfig(
      destinationS3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): ProductionVariantCoreDumpConfig =
      ProductionVariantCoreDumpConfig
        .builder
        .ifSome(destinationS3Uri)(_.destinationS3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def productionVariantSummary(
      variantName: Option[String] = None,
      deployedImages: Option[List[DeployedImage]] = None,
      currentWeight: Option[VariantWeight] = None,
      desiredWeight: Option[VariantWeight] = None,
      currentInstanceCount: Option[Int] = None,
      desiredInstanceCount: Option[Int] = None
    ): ProductionVariantSummary =
      ProductionVariantSummary
        .builder
        .ifSome(variantName)(_.variantName(_))
        .ifSome(deployedImages)(_.deployedImages(_))
        .ifSome(currentWeight)(_.currentWeight(_))
        .ifSome(desiredWeight)(_.desiredWeight(_))
        .ifSome(currentInstanceCount)(_.currentInstanceCount(_))
        .ifSome(desiredInstanceCount)(_.desiredInstanceCount(_))
        .build

    def profilerConfig(
      s3OutputPath: Option[String] = None,
      profilingIntervalInMilliseconds: Option[ProfilingIntervalInMilliseconds] = None,
      profilingParameters: Option[ProfilingParameters] = None
    ): ProfilerConfig =
      ProfilerConfig
        .builder
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(profilingIntervalInMilliseconds)(_.profilingIntervalInMilliseconds(_))
        .ifSome(profilingParameters)(_.profilingParameters(_))
        .build

    def profilerConfigForUpdate(
      s3OutputPath: Option[String] = None,
      profilingIntervalInMilliseconds: Option[ProfilingIntervalInMilliseconds] = None,
      profilingParameters: Option[ProfilingParameters] = None,
      disableProfiler: Option[Boolean] = None
    ): ProfilerConfigForUpdate =
      ProfilerConfigForUpdate
        .builder
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(profilingIntervalInMilliseconds)(_.profilingIntervalInMilliseconds(_))
        .ifSome(profilingParameters)(_.profilingParameters(_))
        .ifSome(disableProfiler)(_.disableProfiler(_))
        .build

    def profilerRuleConfiguration(
      ruleConfigurationName: Option[String] = None,
      localPath: Option[String] = None,
      s3OutputPath: Option[String] = None,
      ruleEvaluatorImage: Option[String] = None,
      instanceType: Option[String] = None,
      volumeSizeInGB: Option[Int] = None,
      ruleParameters: Option[RuleParameters] = None
    ): ProfilerRuleConfiguration =
      ProfilerRuleConfiguration
        .builder
        .ifSome(ruleConfigurationName)(_.ruleConfigurationName(_))
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(ruleEvaluatorImage)(_.ruleEvaluatorImage(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(ruleParameters)(_.ruleParameters(_))
        .build

    def profilerRuleEvaluationStatus(
      ruleConfigurationName: Option[String] = None,
      ruleEvaluationJobArn: Option[String] = None,
      ruleEvaluationStatus: Option[String] = None,
      statusDetails: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): ProfilerRuleEvaluationStatus =
      ProfilerRuleEvaluationStatus
        .builder
        .ifSome(ruleConfigurationName)(_.ruleConfigurationName(_))
        .ifSome(ruleEvaluationJobArn)(_.ruleEvaluationJobArn(_))
        .ifSome(ruleEvaluationStatus)(_.ruleEvaluationStatus(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def projectSummary(
      projectName: Option[String] = None,
      projectDescription: Option[String] = None,
      projectArn: Option[String] = None,
      projectId: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      projectStatus: Option[String] = None
    ): ProjectSummary =
      ProjectSummary
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(projectDescription)(_.projectDescription(_))
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(projectId)(_.projectId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(projectStatus)(_.projectStatus(_))
        .build

    def propertyNameQuery(
      propertyNameHint: Option[String] = None
    ): PropertyNameQuery =
      PropertyNameQuery
        .builder
        .ifSome(propertyNameHint)(_.propertyNameHint(_))
        .build

    def propertyNameSuggestion(
      propertyName: Option[String] = None
    ): PropertyNameSuggestion =
      PropertyNameSuggestion
        .builder
        .ifSome(propertyName)(_.propertyName(_))
        .build

    def provisioningParameter(
      key: Option[String] = None,
      value: Option[String] = None
    ): ProvisioningParameter =
      ProvisioningParameter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def publicWorkforceTaskPrice(
      amountInUsd: Option[USD] = None
    ): PublicWorkforceTaskPrice =
      PublicWorkforceTaskPrice
        .builder
        .ifSome(amountInUsd)(_.amountInUsd(_))
        .build

    def putModelPackageGroupPolicyInput(
      modelPackageGroupName: Option[String] = None,
      resourcePolicy: Option[String] = None
    ): PutModelPackageGroupPolicyInput =
      PutModelPackageGroupPolicyInput
        .builder
        .ifSome(modelPackageGroupName)(_.modelPackageGroupName(_))
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .build

    def putModelPackageGroupPolicyOutput(
      modelPackageGroupArn: Option[String] = None
    ): PutModelPackageGroupPolicyOutput =
      PutModelPackageGroupPolicyOutput
        .builder
        .ifSome(modelPackageGroupArn)(_.modelPackageGroupArn(_))
        .build

    def redshiftDatasetDefinition(
      clusterId: Option[String] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      queryString: Option[String] = None,
      clusterRoleArn: Option[String] = None,
      outputS3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None,
      outputFormat: Option[String] = None,
      outputCompression: Option[String] = None
    ): RedshiftDatasetDefinition =
      RedshiftDatasetDefinition
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(clusterRoleArn)(_.clusterRoleArn(_))
        .ifSome(outputS3Uri)(_.outputS3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .ifSome(outputCompression)(_.outputCompression(_))
        .build

    def registerDevicesRequest(
      deviceFleetName: Option[String] = None,
      devices: Option[List[Device]] = None,
      tags: Option[List[Tag]] = None
    ): RegisterDevicesRequest =
      RegisterDevicesRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(devices)(_.devices(_))
        .ifSome(tags)(_.tags(_))
        .build

    def registerModelStepMetadata(
      arn: Option[String] = None
    ): RegisterModelStepMetadata =
      RegisterModelStepMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def renderUiTemplateRequest(
      uiTemplate: Option[UiTemplate] = None,
      task: Option[RenderableTask] = None,
      roleArn: Option[String] = None,
      humanTaskUiArn: Option[String] = None
    ): RenderUiTemplateRequest =
      RenderUiTemplateRequest
        .builder
        .ifSome(uiTemplate)(_.uiTemplate(_))
        .ifSome(task)(_.task(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(humanTaskUiArn)(_.humanTaskUiArn(_))
        .build

    def renderUiTemplateResponse(
      renderedContent: Option[String] = None,
      errors: Option[List[RenderingError]] = None
    ): RenderUiTemplateResponse =
      RenderUiTemplateResponse
        .builder
        .ifSome(renderedContent)(_.renderedContent(_))
        .ifSome(errors)(_.errors(_))
        .build

    def renderableTask(
      input: Option[String] = None
    ): RenderableTask =
      RenderableTask
        .builder
        .ifSome(input)(_.input(_))
        .build

    def renderingError(
      code: Option[String] = None,
      message: Option[String] = None
    ): RenderingError =
      RenderingError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def repositoryAuthConfig(
      repositoryCredentialsProviderArn: Option[String] = None
    ): RepositoryAuthConfig =
      RepositoryAuthConfig
        .builder
        .ifSome(repositoryCredentialsProviderArn)(_.repositoryCredentialsProviderArn(_))
        .build

    def resolvedAttributes(
      autoMLJobObjective: Option[AutoMLJobObjective] = None,
      problemType: Option[String] = None,
      completionCriteria: Option[AutoMLJobCompletionCriteria] = None
    ): ResolvedAttributes =
      ResolvedAttributes
        .builder
        .ifSome(autoMLJobObjective)(_.autoMLJobObjective(_))
        .ifSome(problemType)(_.problemType(_))
        .ifSome(completionCriteria)(_.completionCriteria(_))
        .build

    def resourceConfig(
      instanceType: Option[String] = None,
      instanceCount: Option[Int] = None,
      volumeSizeInGB: Option[Int] = None,
      volumeKmsKeyId: Option[String] = None
    ): ResourceConfig =
      ResourceConfig
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .build

    def resourceInUse(
      message: Option[String] = None
    ): ResourceInUse =
      ResourceInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceLimitExceeded(
      message: Option[String] = None
    ): ResourceLimitExceeded =
      ResourceLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceLimits(
      maxNumberOfTrainingJobs: Option[Int] = None,
      maxParallelTrainingJobs: Option[Int] = None
    ): ResourceLimits =
      ResourceLimits
        .builder
        .ifSome(maxNumberOfTrainingJobs)(_.maxNumberOfTrainingJobs(_))
        .ifSome(maxParallelTrainingJobs)(_.maxParallelTrainingJobs(_))
        .build

    def resourceNotFound(
      message: Option[String] = None
    ): ResourceNotFound =
      ResourceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceSpec(
      sageMakerImageArn: Option[String] = None,
      sageMakerImageVersionArn: Option[String] = None,
      instanceType: Option[String] = None
    ): ResourceSpec =
      ResourceSpec
        .builder
        .ifSome(sageMakerImageArn)(_.sageMakerImageArn(_))
        .ifSome(sageMakerImageVersionArn)(_.sageMakerImageVersionArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .build

    def retentionPolicy(
      homeEfsFileSystem: Option[String] = None
    ): RetentionPolicy =
      RetentionPolicy
        .builder
        .ifSome(homeEfsFileSystem)(_.homeEfsFileSystem(_))
        .build

    def retryStrategy(
      maximumRetryAttempts: Option[Int] = None
    ): RetryStrategy =
      RetryStrategy
        .builder
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .build

    def s3DataSource(
      s3DataType: Option[String] = None,
      s3Uri: Option[String] = None,
      s3DataDistributionType: Option[String] = None,
      attributeNames: Option[List[AttributeName]] = None
    ): S3DataSource =
      S3DataSource
        .builder
        .ifSome(s3DataType)(_.s3DataType(_))
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(s3DataDistributionType)(_.s3DataDistributionType(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def s3StorageConfig(
      s3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None,
      resolvedOutputS3Uri: Option[String] = None
    ): S3StorageConfig =
      S3StorageConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(resolvedOutputS3Uri)(_.resolvedOutputS3Uri(_))
        .build

    def scheduleConfig(
      scheduleExpression: Option[String] = None
    ): ScheduleConfig =
      ScheduleConfig
        .builder
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .build

    def searchExpression(
      filters: Option[List[Filter]] = None,
      nestedFilters: Option[List[NestedFilters]] = None,
      subExpressions: Option[List[SearchExpression]] = None,
      operator: Option[String] = None
    ): SearchExpression =
      SearchExpression
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nestedFilters)(_.nestedFilters(_))
        .ifSome(subExpressions)(_.subExpressions(_))
        .ifSome(operator)(_.operator(_))
        .build

    def searchRecord(
      trainingJob: Option[TrainingJob] = None,
      experiment: Option[Experiment] = None,
      trial: Option[Trial] = None,
      trialComponent: Option[TrialComponent] = None,
      endpoint: Option[Endpoint] = None,
      modelPackage: Option[ModelPackage] = None,
      modelPackageGroup: Option[ModelPackageGroup] = None,
      pipeline: Option[Pipeline] = None,
      pipelineExecution: Option[PipelineExecution] = None,
      featureGroup: Option[FeatureGroup] = None
    ): SearchRecord =
      SearchRecord
        .builder
        .ifSome(trainingJob)(_.trainingJob(_))
        .ifSome(experiment)(_.experiment(_))
        .ifSome(trial)(_.trial(_))
        .ifSome(trialComponent)(_.trialComponent(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(modelPackage)(_.modelPackage(_))
        .ifSome(modelPackageGroup)(_.modelPackageGroup(_))
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(pipelineExecution)(_.pipelineExecution(_))
        .ifSome(featureGroup)(_.featureGroup(_))
        .build

    def searchRequest(
      resource: Option[String] = None,
      searchExpression: Option[SearchExpression] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchRequest =
      SearchRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(searchExpression)(_.searchExpression(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchResponse(
      results: Option[List[SearchRecord]] = None,
      nextToken: Option[String] = None
    ): SearchResponse =
      SearchResponse
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def secondaryStatusTransition(
      status: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      statusMessage: Option[String] = None
    ): SecondaryStatusTransition =
      SecondaryStatusTransition
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def sendPipelineExecutionStepFailureRequest(
      callbackToken: Option[String] = None,
      failureReason: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): SendPipelineExecutionStepFailureRequest =
      SendPipelineExecutionStepFailureRequest
        .builder
        .ifSome(callbackToken)(_.callbackToken(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def sendPipelineExecutionStepFailureResponse(
      pipelineExecutionArn: Option[String] = None
    ): SendPipelineExecutionStepFailureResponse =
      SendPipelineExecutionStepFailureResponse
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .build

    def sendPipelineExecutionStepSuccessRequest(
      callbackToken: Option[String] = None,
      outputParameters: Option[List[OutputParameter]] = None,
      clientRequestToken: Option[String] = None
    ): SendPipelineExecutionStepSuccessRequest =
      SendPipelineExecutionStepSuccessRequest
        .builder
        .ifSome(callbackToken)(_.callbackToken(_))
        .ifSome(outputParameters)(_.outputParameters(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def sendPipelineExecutionStepSuccessResponse(
      pipelineExecutionArn: Option[String] = None
    ): SendPipelineExecutionStepSuccessResponse =
      SendPipelineExecutionStepSuccessResponse
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .build

    def serviceCatalogProvisionedProductDetails(
      provisionedProductId: Option[String] = None,
      provisionedProductStatusMessage: Option[String] = None
    ): ServiceCatalogProvisionedProductDetails =
      ServiceCatalogProvisionedProductDetails
        .builder
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(provisionedProductStatusMessage)(_.provisionedProductStatusMessage(_))
        .build

    def serviceCatalogProvisioningDetails(
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      pathId: Option[String] = None,
      provisioningParameters: Option[List[ProvisioningParameter]] = None
    ): ServiceCatalogProvisioningDetails =
      ServiceCatalogProvisioningDetails
        .builder
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(pathId)(_.pathId(_))
        .ifSome(provisioningParameters)(_.provisioningParameters(_))
        .build

    def sharingSettings(
      notebookOutputOption: Option[String] = None,
      s3OutputPath: Option[String] = None,
      s3KmsKeyId: Option[String] = None
    ): SharingSettings =
      SharingSettings
        .builder
        .ifSome(notebookOutputOption)(_.notebookOutputOption(_))
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(s3KmsKeyId)(_.s3KmsKeyId(_))
        .build

    def shuffleConfig(
      seed: Option[Seed] = None
    ): ShuffleConfig =
      ShuffleConfig
        .builder
        .ifSome(seed)(_.seed(_))
        .build

    def sourceAlgorithm(
      modelDataUrl: Option[String] = None,
      algorithmName: Option[String] = None
    ): SourceAlgorithm =
      SourceAlgorithm
        .builder
        .ifSome(modelDataUrl)(_.modelDataUrl(_))
        .ifSome(algorithmName)(_.algorithmName(_))
        .build

    def sourceAlgorithmSpecification(
      sourceAlgorithms: Option[List[SourceAlgorithm]] = None
    ): SourceAlgorithmSpecification =
      SourceAlgorithmSpecification
        .builder
        .ifSome(sourceAlgorithms)(_.sourceAlgorithms(_))
        .build

    def sourceIpConfig(
      cidrs: Option[List[Cidr]] = None
    ): SourceIpConfig =
      SourceIpConfig
        .builder
        .ifSome(cidrs)(_.cidrs(_))
        .build

    def startMonitoringScheduleRequest(
      monitoringScheduleName: Option[String] = None
    ): StartMonitoringScheduleRequest =
      StartMonitoringScheduleRequest
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .build

    def startNotebookInstanceInput(
      notebookInstanceName: Option[String] = None
    ): StartNotebookInstanceInput =
      StartNotebookInstanceInput
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .build

    def startPipelineExecutionRequest(
      pipelineName: Option[String] = None,
      pipelineExecutionDisplayName: Option[String] = None,
      pipelineParameters: Option[List[Parameter]] = None,
      pipelineExecutionDescription: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): StartPipelineExecutionRequest =
      StartPipelineExecutionRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineExecutionDisplayName)(_.pipelineExecutionDisplayName(_))
        .ifSome(pipelineParameters)(_.pipelineParameters(_))
        .ifSome(pipelineExecutionDescription)(_.pipelineExecutionDescription(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def startPipelineExecutionResponse(
      pipelineExecutionArn: Option[String] = None
    ): StartPipelineExecutionResponse =
      StartPipelineExecutionResponse
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .build

    def stopAutoMLJobRequest(
      autoMLJobName: Option[String] = None
    ): StopAutoMLJobRequest =
      StopAutoMLJobRequest
        .builder
        .ifSome(autoMLJobName)(_.autoMLJobName(_))
        .build

    def stopCompilationJobRequest(
      compilationJobName: Option[String] = None
    ): StopCompilationJobRequest =
      StopCompilationJobRequest
        .builder
        .ifSome(compilationJobName)(_.compilationJobName(_))
        .build

    def stopEdgePackagingJobRequest(
      edgePackagingJobName: Option[String] = None
    ): StopEdgePackagingJobRequest =
      StopEdgePackagingJobRequest
        .builder
        .ifSome(edgePackagingJobName)(_.edgePackagingJobName(_))
        .build

    def stopHyperParameterTuningJobRequest(
      hyperParameterTuningJobName: Option[String] = None
    ): StopHyperParameterTuningJobRequest =
      StopHyperParameterTuningJobRequest
        .builder
        .ifSome(hyperParameterTuningJobName)(_.hyperParameterTuningJobName(_))
        .build

    def stopLabelingJobRequest(
      labelingJobName: Option[String] = None
    ): StopLabelingJobRequest =
      StopLabelingJobRequest
        .builder
        .ifSome(labelingJobName)(_.labelingJobName(_))
        .build

    def stopMonitoringScheduleRequest(
      monitoringScheduleName: Option[String] = None
    ): StopMonitoringScheduleRequest =
      StopMonitoringScheduleRequest
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .build

    def stopNotebookInstanceInput(
      notebookInstanceName: Option[String] = None
    ): StopNotebookInstanceInput =
      StopNotebookInstanceInput
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .build

    def stopPipelineExecutionRequest(
      pipelineExecutionArn: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): StopPipelineExecutionRequest =
      StopPipelineExecutionRequest
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def stopPipelineExecutionResponse(
      pipelineExecutionArn: Option[String] = None
    ): StopPipelineExecutionResponse =
      StopPipelineExecutionResponse
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .build

    def stopProcessingJobRequest(
      processingJobName: Option[String] = None
    ): StopProcessingJobRequest =
      StopProcessingJobRequest
        .builder
        .ifSome(processingJobName)(_.processingJobName(_))
        .build

    def stopTrainingJobRequest(
      trainingJobName: Option[String] = None
    ): StopTrainingJobRequest =
      StopTrainingJobRequest
        .builder
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .build

    def stopTransformJobRequest(
      transformJobName: Option[String] = None
    ): StopTransformJobRequest =
      StopTransformJobRequest
        .builder
        .ifSome(transformJobName)(_.transformJobName(_))
        .build

    def stoppingCondition(
      maxRuntimeInSeconds: Option[Int] = None,
      maxWaitTimeInSeconds: Option[Int] = None
    ): StoppingCondition =
      StoppingCondition
        .builder
        .ifSome(maxRuntimeInSeconds)(_.maxRuntimeInSeconds(_))
        .ifSome(maxWaitTimeInSeconds)(_.maxWaitTimeInSeconds(_))
        .build

    def subscribedWorkteam(
      workteamArn: Option[String] = None,
      marketplaceTitle: Option[String] = None,
      sellerName: Option[String] = None,
      marketplaceDescription: Option[String] = None,
      listingId: Option[String] = None
    ): SubscribedWorkteam =
      SubscribedWorkteam
        .builder
        .ifSome(workteamArn)(_.workteamArn(_))
        .ifSome(marketplaceTitle)(_.marketplaceTitle(_))
        .ifSome(sellerName)(_.sellerName(_))
        .ifSome(marketplaceDescription)(_.marketplaceDescription(_))
        .ifSome(listingId)(_.listingId(_))
        .build

    def suggestionQuery(
      propertyNameQuery: Option[PropertyNameQuery] = None
    ): SuggestionQuery =
      SuggestionQuery
        .builder
        .ifSome(propertyNameQuery)(_.propertyNameQuery(_))
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

    def targetPlatform(
      os: Option[String] = None,
      arch: Option[String] = None,
      accelerator: Option[String] = None
    ): TargetPlatform =
      TargetPlatform
        .builder
        .ifSome(os)(_.os(_))
        .ifSome(arch)(_.arch(_))
        .ifSome(accelerator)(_.accelerator(_))
        .build

    def tensorBoardAppSettings(
      defaultResourceSpec: Option[ResourceSpec] = None
    ): TensorBoardAppSettings =
      TensorBoardAppSettings
        .builder
        .ifSome(defaultResourceSpec)(_.defaultResourceSpec(_))
        .build

    def tensorBoardOutputConfig(
      localPath: Option[String] = None,
      s3OutputPath: Option[String] = None
    ): TensorBoardOutputConfig =
      TensorBoardOutputConfig
        .builder
        .ifSome(localPath)(_.localPath(_))
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .build

    def trafficRoutingConfig(
      `type`: Option[String] = None,
      waitIntervalInSeconds: Option[Int] = None,
      canarySize: Option[CapacitySize] = None
    ): TrafficRoutingConfig =
      TrafficRoutingConfig
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(waitIntervalInSeconds)(_.waitIntervalInSeconds(_))
        .ifSome(canarySize)(_.canarySize(_))
        .build

    def trainingJob(
      trainingJobName: Option[String] = None,
      trainingJobArn: Option[String] = None,
      tuningJobArn: Option[String] = None,
      labelingJobArn: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      modelArtifacts: Option[ModelArtifacts] = None,
      trainingJobStatus: Option[String] = None,
      secondaryStatus: Option[String] = None,
      failureReason: Option[String] = None,
      hyperParameters: Option[HyperParameters] = None,
      algorithmSpecification: Option[AlgorithmSpecification] = None,
      roleArn: Option[String] = None,
      inputDataConfig: Option[List[Channel]] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      resourceConfig: Option[ResourceConfig] = None,
      vpcConfig: Option[VpcConfig] = None,
      stoppingCondition: Option[StoppingCondition] = None,
      creationTime: Option[Timestamp] = None,
      trainingStartTime: Option[Timestamp] = None,
      trainingEndTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      secondaryStatusTransitions: Option[List[SecondaryStatusTransition]] = None,
      finalMetricDataList: Option[List[MetricData]] = None,
      enableNetworkIsolation: Option[Boolean] = None,
      enableInterContainerTrafficEncryption: Option[Boolean] = None,
      enableManagedSpotTraining: Option[Boolean] = None,
      checkpointConfig: Option[CheckpointConfig] = None,
      trainingTimeInSeconds: Option[Int] = None,
      billableTimeInSeconds: Option[Int] = None,
      debugHookConfig: Option[DebugHookConfig] = None,
      experimentConfig: Option[ExperimentConfig] = None,
      debugRuleConfigurations: Option[List[DebugRuleConfiguration]] = None,
      tensorBoardOutputConfig: Option[TensorBoardOutputConfig] = None,
      debugRuleEvaluationStatuses: Option[List[DebugRuleEvaluationStatus]] = None,
      environment: Option[TrainingEnvironmentMap] = None,
      retryStrategy: Option[RetryStrategy] = None,
      tags: Option[List[Tag]] = None
    ): TrainingJob =
      TrainingJob
        .builder
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .ifSome(tuningJobArn)(_.tuningJobArn(_))
        .ifSome(labelingJobArn)(_.labelingJobArn(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(modelArtifacts)(_.modelArtifacts(_))
        .ifSome(trainingJobStatus)(_.trainingJobStatus(_))
        .ifSome(secondaryStatus)(_.secondaryStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(hyperParameters)(_.hyperParameters(_))
        .ifSome(algorithmSpecification)(_.algorithmSpecification(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(trainingStartTime)(_.trainingStartTime(_))
        .ifSome(trainingEndTime)(_.trainingEndTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(secondaryStatusTransitions)(_.secondaryStatusTransitions(_))
        .ifSome(finalMetricDataList)(_.finalMetricDataList(_))
        .ifSome(enableNetworkIsolation)(_.enableNetworkIsolation(_))
        .ifSome(enableInterContainerTrafficEncryption)(_.enableInterContainerTrafficEncryption(_))
        .ifSome(enableManagedSpotTraining)(_.enableManagedSpotTraining(_))
        .ifSome(checkpointConfig)(_.checkpointConfig(_))
        .ifSome(trainingTimeInSeconds)(_.trainingTimeInSeconds(_))
        .ifSome(billableTimeInSeconds)(_.billableTimeInSeconds(_))
        .ifSome(debugHookConfig)(_.debugHookConfig(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .ifSome(debugRuleConfigurations)(_.debugRuleConfigurations(_))
        .ifSome(tensorBoardOutputConfig)(_.tensorBoardOutputConfig(_))
        .ifSome(debugRuleEvaluationStatuses)(_.debugRuleEvaluationStatuses(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def trainingJobDefinition(
      trainingInputMode: Option[String] = None,
      hyperParameters: Option[HyperParameters] = None,
      inputDataConfig: Option[List[Channel]] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      resourceConfig: Option[ResourceConfig] = None,
      stoppingCondition: Option[StoppingCondition] = None
    ): TrainingJobDefinition =
      TrainingJobDefinition
        .builder
        .ifSome(trainingInputMode)(_.trainingInputMode(_))
        .ifSome(hyperParameters)(_.hyperParameters(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(stoppingCondition)(_.stoppingCondition(_))
        .build

    def trainingJobStatusCounters(
      completed: Option[Int] = None,
      inProgress: Option[Int] = None,
      retryableError: Option[Int] = None,
      nonRetryableError: Option[Int] = None,
      stopped: Option[Int] = None
    ): TrainingJobStatusCounters =
      TrainingJobStatusCounters
        .builder
        .ifSome(completed)(_.completed(_))
        .ifSome(inProgress)(_.inProgress(_))
        .ifSome(retryableError)(_.retryableError(_))
        .ifSome(nonRetryableError)(_.nonRetryableError(_))
        .ifSome(stopped)(_.stopped(_))
        .build

    def trainingJobStepMetadata(
      arn: Option[String] = None
    ): TrainingJobStepMetadata =
      TrainingJobStepMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def trainingJobSummary(
      trainingJobName: Option[String] = None,
      trainingJobArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      trainingEndTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      trainingJobStatus: Option[String] = None
    ): TrainingJobSummary =
      TrainingJobSummary
        .builder
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(trainingEndTime)(_.trainingEndTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(trainingJobStatus)(_.trainingJobStatus(_))
        .build

    def trainingSpecification(
      trainingImage: Option[String] = None,
      trainingImageDigest: Option[String] = None,
      supportedHyperParameters: Option[List[HyperParameterSpecification]] = None,
      supportedTrainingInstanceTypes: Option[List[TrainingInstanceType]] = None,
      supportsDistributedTraining: Option[Boolean] = None,
      metricDefinitions: Option[List[MetricDefinition]] = None,
      trainingChannels: Option[List[ChannelSpecification]] = None,
      supportedTuningJobObjectiveMetrics: Option[List[HyperParameterTuningJobObjective]] = None
    ): TrainingSpecification =
      TrainingSpecification
        .builder
        .ifSome(trainingImage)(_.trainingImage(_))
        .ifSome(trainingImageDigest)(_.trainingImageDigest(_))
        .ifSome(supportedHyperParameters)(_.supportedHyperParameters(_))
        .ifSome(supportedTrainingInstanceTypes)(_.supportedTrainingInstanceTypes(_))
        .ifSome(supportsDistributedTraining)(_.supportsDistributedTraining(_))
        .ifSome(metricDefinitions)(_.metricDefinitions(_))
        .ifSome(trainingChannels)(_.trainingChannels(_))
        .ifSome(supportedTuningJobObjectiveMetrics)(_.supportedTuningJobObjectiveMetrics(_))
        .build

    def transformDataSource(
      s3DataSource: Option[TransformS3DataSource] = None
    ): TransformDataSource =
      TransformDataSource
        .builder
        .ifSome(s3DataSource)(_.s3DataSource(_))
        .build

    def transformInput(
      dataSource: Option[TransformDataSource] = None,
      contentType: Option[String] = None,
      compressionType: Option[String] = None,
      splitType: Option[String] = None
    ): TransformInput =
      TransformInput
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(compressionType)(_.compressionType(_))
        .ifSome(splitType)(_.splitType(_))
        .build

    def transformJob(
      transformJobName: Option[String] = None,
      transformJobArn: Option[String] = None,
      transformJobStatus: Option[String] = None,
      failureReason: Option[String] = None,
      modelName: Option[String] = None,
      maxConcurrentTransforms: Option[Int] = None,
      modelClientConfig: Option[ModelClientConfig] = None,
      maxPayloadInMB: Option[Int] = None,
      batchStrategy: Option[String] = None,
      environment: Option[TransformEnvironmentMap] = None,
      transformInput: Option[TransformInput] = None,
      transformOutput: Option[TransformOutput] = None,
      transformResources: Option[TransformResources] = None,
      creationTime: Option[Timestamp] = None,
      transformStartTime: Option[Timestamp] = None,
      transformEndTime: Option[Timestamp] = None,
      labelingJobArn: Option[String] = None,
      autoMLJobArn: Option[String] = None,
      dataProcessing: Option[DataProcessing] = None,
      experimentConfig: Option[ExperimentConfig] = None,
      tags: Option[List[Tag]] = None
    ): TransformJob =
      TransformJob
        .builder
        .ifSome(transformJobName)(_.transformJobName(_))
        .ifSome(transformJobArn)(_.transformJobArn(_))
        .ifSome(transformJobStatus)(_.transformJobStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(maxConcurrentTransforms)(_.maxConcurrentTransforms(_))
        .ifSome(modelClientConfig)(_.modelClientConfig(_))
        .ifSome(maxPayloadInMB)(_.maxPayloadInMB(_))
        .ifSome(batchStrategy)(_.batchStrategy(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(transformInput)(_.transformInput(_))
        .ifSome(transformOutput)(_.transformOutput(_))
        .ifSome(transformResources)(_.transformResources(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(transformStartTime)(_.transformStartTime(_))
        .ifSome(transformEndTime)(_.transformEndTime(_))
        .ifSome(labelingJobArn)(_.labelingJobArn(_))
        .ifSome(autoMLJobArn)(_.autoMLJobArn(_))
        .ifSome(dataProcessing)(_.dataProcessing(_))
        .ifSome(experimentConfig)(_.experimentConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transformJobDefinition(
      maxConcurrentTransforms: Option[Int] = None,
      maxPayloadInMB: Option[Int] = None,
      batchStrategy: Option[String] = None,
      environment: Option[TransformEnvironmentMap] = None,
      transformInput: Option[TransformInput] = None,
      transformOutput: Option[TransformOutput] = None,
      transformResources: Option[TransformResources] = None
    ): TransformJobDefinition =
      TransformJobDefinition
        .builder
        .ifSome(maxConcurrentTransforms)(_.maxConcurrentTransforms(_))
        .ifSome(maxPayloadInMB)(_.maxPayloadInMB(_))
        .ifSome(batchStrategy)(_.batchStrategy(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(transformInput)(_.transformInput(_))
        .ifSome(transformOutput)(_.transformOutput(_))
        .ifSome(transformResources)(_.transformResources(_))
        .build

    def transformJobStepMetadata(
      arn: Option[String] = None
    ): TransformJobStepMetadata =
      TransformJobStepMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def transformJobSummary(
      transformJobName: Option[String] = None,
      transformJobArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      transformEndTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      transformJobStatus: Option[String] = None,
      failureReason: Option[String] = None
    ): TransformJobSummary =
      TransformJobSummary
        .builder
        .ifSome(transformJobName)(_.transformJobName(_))
        .ifSome(transformJobArn)(_.transformJobArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(transformEndTime)(_.transformEndTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(transformJobStatus)(_.transformJobStatus(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def transformOutput(
      s3OutputPath: Option[String] = None,
      accept: Option[String] = None,
      assembleWith: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): TransformOutput =
      TransformOutput
        .builder
        .ifSome(s3OutputPath)(_.s3OutputPath(_))
        .ifSome(accept)(_.accept(_))
        .ifSome(assembleWith)(_.assembleWith(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def transformResources(
      instanceType: Option[String] = None,
      instanceCount: Option[Int] = None,
      volumeKmsKeyId: Option[String] = None
    ): TransformResources =
      TransformResources
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .build

    def transformS3DataSource(
      s3DataType: Option[String] = None,
      s3Uri: Option[String] = None
    ): TransformS3DataSource =
      TransformS3DataSource
        .builder
        .ifSome(s3DataType)(_.s3DataType(_))
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def trial(
      trialName: Option[String] = None,
      trialArn: Option[String] = None,
      displayName: Option[String] = None,
      experimentName: Option[String] = None,
      source: Option[TrialSource] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      metadataProperties: Option[MetadataProperties] = None,
      tags: Option[List[Tag]] = None,
      trialComponentSummaries: Option[List[TrialComponentSimpleSummary]] = None
    ): Trial =
      Trial
        .builder
        .ifSome(trialName)(_.trialName(_))
        .ifSome(trialArn)(_.trialArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(source)(_.source(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(trialComponentSummaries)(_.trialComponentSummaries(_))
        .build

    def trialComponent(
      trialComponentName: Option[String] = None,
      displayName: Option[String] = None,
      trialComponentArn: Option[String] = None,
      source: Option[TrialComponentSource] = None,
      status: Option[TrialComponentStatus] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None,
      parameters: Option[TrialComponentParameters] = None,
      inputArtifacts: Option[TrialComponentArtifacts] = None,
      outputArtifacts: Option[TrialComponentArtifacts] = None,
      metrics: Option[List[TrialComponentMetricSummary]] = None,
      metadataProperties: Option[MetadataProperties] = None,
      sourceDetail: Option[TrialComponentSourceDetail] = None,
      tags: Option[List[Tag]] = None,
      parents: Option[List[Parent]] = None
    ): TrialComponent =
      TrialComponent
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .ifSome(source)(_.source(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(metadataProperties)(_.metadataProperties(_))
        .ifSome(sourceDetail)(_.sourceDetail(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(parents)(_.parents(_))
        .build

    def trialComponentArtifact(
      mediaType: Option[String] = None,
      value: Option[String] = None
    ): TrialComponentArtifact =
      TrialComponentArtifact
        .builder
        .ifSome(mediaType)(_.mediaType(_))
        .ifSome(value)(_.value(_))
        .build

    def trialComponentMetricSummary(
      metricName: Option[String] = None,
      sourceArn: Option[String] = None,
      timeStamp: Option[Timestamp] = None,
      max: Option[OptionalDouble] = None,
      min: Option[OptionalDouble] = None,
      last: Option[OptionalDouble] = None,
      count: Option[Int] = None,
      avg: Option[OptionalDouble] = None,
      stdDev: Option[OptionalDouble] = None
    ): TrialComponentMetricSummary =
      TrialComponentMetricSummary
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(timeStamp)(_.timeStamp(_))
        .ifSome(max)(_.max(_))
        .ifSome(min)(_.min(_))
        .ifSome(last)(_.last(_))
        .ifSome(count)(_.count(_))
        .ifSome(avg)(_.avg(_))
        .ifSome(stdDev)(_.stdDev(_))
        .build

    def trialComponentParameterValue(
      stringValue: Option[String] = None,
      numberValue: Option[DoubleParameterValue] = None
    ): TrialComponentParameterValue =
      TrialComponentParameterValue
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(numberValue)(_.numberValue(_))
        .build

    def trialComponentSimpleSummary(
      trialComponentName: Option[String] = None,
      trialComponentArn: Option[String] = None,
      trialComponentSource: Option[TrialComponentSource] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None
    ): TrialComponentSimpleSummary =
      TrialComponentSimpleSummary
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .ifSome(trialComponentSource)(_.trialComponentSource(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def trialComponentSource(
      sourceArn: Option[String] = None,
      sourceType: Option[String] = None
    ): TrialComponentSource =
      TrialComponentSource
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .build

    def trialComponentSourceDetail(
      sourceArn: Option[String] = None,
      trainingJob: Option[TrainingJob] = None,
      processingJob: Option[ProcessingJob] = None,
      transformJob: Option[TransformJob] = None
    ): TrialComponentSourceDetail =
      TrialComponentSourceDetail
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(trainingJob)(_.trainingJob(_))
        .ifSome(processingJob)(_.processingJob(_))
        .ifSome(transformJob)(_.transformJob(_))
        .build

    def trialComponentStatus(
      primaryStatus: Option[String] = None,
      message: Option[String] = None
    ): TrialComponentStatus =
      TrialComponentStatus
        .builder
        .ifSome(primaryStatus)(_.primaryStatus(_))
        .ifSome(message)(_.message(_))
        .build

    def trialComponentSummary(
      trialComponentName: Option[String] = None,
      trialComponentArn: Option[String] = None,
      displayName: Option[String] = None,
      trialComponentSource: Option[TrialComponentSource] = None,
      status: Option[TrialComponentStatus] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      creationTime: Option[Timestamp] = None,
      createdBy: Option[UserContext] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastModifiedBy: Option[UserContext] = None
    ): TrialComponentSummary =
      TrialComponentSummary
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(trialComponentSource)(_.trialComponentSource(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .build

    def trialSource(
      sourceArn: Option[String] = None,
      sourceType: Option[String] = None
    ): TrialSource =
      TrialSource
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .build

    def trialSummary(
      trialArn: Option[String] = None,
      trialName: Option[String] = None,
      displayName: Option[String] = None,
      trialSource: Option[TrialSource] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): TrialSummary =
      TrialSummary
        .builder
        .ifSome(trialArn)(_.trialArn(_))
        .ifSome(trialName)(_.trialName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(trialSource)(_.trialSource(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def tuningJobCompletionCriteria(
      targetObjectiveMetricValue: Option[TargetObjectiveMetricValue] = None
    ): TuningJobCompletionCriteria =
      TuningJobCompletionCriteria
        .builder
        .ifSome(targetObjectiveMetricValue)(_.targetObjectiveMetricValue(_))
        .build

    def uSD(
      dollars: Option[Int] = None,
      cents: Option[Int] = None,
      tenthFractionsOfACent: Option[Int] = None
    ): USD =
      USD
        .builder
        .ifSome(dollars)(_.dollars(_))
        .ifSome(cents)(_.cents(_))
        .ifSome(tenthFractionsOfACent)(_.tenthFractionsOfACent(_))
        .build

    def uiConfig(
      uiTemplateS3Uri: Option[String] = None,
      humanTaskUiArn: Option[String] = None
    ): UiConfig =
      UiConfig
        .builder
        .ifSome(uiTemplateS3Uri)(_.uiTemplateS3Uri(_))
        .ifSome(humanTaskUiArn)(_.humanTaskUiArn(_))
        .build

    def uiTemplate(
      content: Option[String] = None
    ): UiTemplate =
      UiTemplate
        .builder
        .ifSome(content)(_.content(_))
        .build

    def uiTemplateInfo(
      url: Option[String] = None,
      contentSha256: Option[String] = None
    ): UiTemplateInfo =
      UiTemplateInfo
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(contentSha256)(_.contentSha256(_))
        .build

    def updateActionRequest(
      actionName: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      propertiesToRemove: Option[List[StringParameterValue]] = None
    ): UpdateActionRequest =
      UpdateActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(propertiesToRemove)(_.propertiesToRemove(_))
        .build

    def updateActionResponse(
      actionArn: Option[String] = None
    ): UpdateActionResponse =
      UpdateActionResponse
        .builder
        .ifSome(actionArn)(_.actionArn(_))
        .build

    def updateAppImageConfigRequest(
      appImageConfigName: Option[String] = None,
      kernelGatewayImageConfig: Option[KernelGatewayImageConfig] = None
    ): UpdateAppImageConfigRequest =
      UpdateAppImageConfigRequest
        .builder
        .ifSome(appImageConfigName)(_.appImageConfigName(_))
        .ifSome(kernelGatewayImageConfig)(_.kernelGatewayImageConfig(_))
        .build

    def updateAppImageConfigResponse(
      appImageConfigArn: Option[String] = None
    ): UpdateAppImageConfigResponse =
      UpdateAppImageConfigResponse
        .builder
        .ifSome(appImageConfigArn)(_.appImageConfigArn(_))
        .build

    def updateArtifactRequest(
      artifactArn: Option[String] = None,
      artifactName: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      propertiesToRemove: Option[List[StringParameterValue]] = None
    ): UpdateArtifactRequest =
      UpdateArtifactRequest
        .builder
        .ifSome(artifactArn)(_.artifactArn(_))
        .ifSome(artifactName)(_.artifactName(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(propertiesToRemove)(_.propertiesToRemove(_))
        .build

    def updateArtifactResponse(
      artifactArn: Option[String] = None
    ): UpdateArtifactResponse =
      UpdateArtifactResponse
        .builder
        .ifSome(artifactArn)(_.artifactArn(_))
        .build

    def updateCodeRepositoryInput(
      codeRepositoryName: Option[String] = None,
      gitConfig: Option[GitConfigForUpdate] = None
    ): UpdateCodeRepositoryInput =
      UpdateCodeRepositoryInput
        .builder
        .ifSome(codeRepositoryName)(_.codeRepositoryName(_))
        .ifSome(gitConfig)(_.gitConfig(_))
        .build

    def updateCodeRepositoryOutput(
      codeRepositoryArn: Option[String] = None
    ): UpdateCodeRepositoryOutput =
      UpdateCodeRepositoryOutput
        .builder
        .ifSome(codeRepositoryArn)(_.codeRepositoryArn(_))
        .build

    def updateContextRequest(
      contextName: Option[String] = None,
      description: Option[String] = None,
      properties: Option[LineageEntityParameters] = None,
      propertiesToRemove: Option[List[StringParameterValue]] = None
    ): UpdateContextRequest =
      UpdateContextRequest
        .builder
        .ifSome(contextName)(_.contextName(_))
        .ifSome(description)(_.description(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(propertiesToRemove)(_.propertiesToRemove(_))
        .build

    def updateContextResponse(
      contextArn: Option[String] = None
    ): UpdateContextResponse =
      UpdateContextResponse
        .builder
        .ifSome(contextArn)(_.contextArn(_))
        .build

    def updateDeviceFleetRequest(
      deviceFleetName: Option[String] = None,
      roleArn: Option[String] = None,
      description: Option[String] = None,
      outputConfig: Option[EdgeOutputConfig] = None,
      enableIotRoleAlias: Option[Boolean] = None
    ): UpdateDeviceFleetRequest =
      UpdateDeviceFleetRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(enableIotRoleAlias)(_.enableIotRoleAlias(_))
        .build

    def updateDevicesRequest(
      deviceFleetName: Option[String] = None,
      devices: Option[List[Device]] = None
    ): UpdateDevicesRequest =
      UpdateDevicesRequest
        .builder
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .ifSome(devices)(_.devices(_))
        .build

    def updateDomainRequest(
      domainId: Option[String] = None,
      defaultUserSettings: Option[UserSettings] = None
    ): UpdateDomainRequest =
      UpdateDomainRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(defaultUserSettings)(_.defaultUserSettings(_))
        .build

    def updateDomainResponse(
      domainArn: Option[String] = None
    ): UpdateDomainResponse =
      UpdateDomainResponse
        .builder
        .ifSome(domainArn)(_.domainArn(_))
        .build

    def updateEndpointInput(
      endpointName: Option[String] = None,
      endpointConfigName: Option[String] = None,
      retainAllVariantProperties: Option[Boolean] = None,
      excludeRetainedVariantProperties: Option[List[VariantProperty]] = None,
      deploymentConfig: Option[DeploymentConfig] = None
    ): UpdateEndpointInput =
      UpdateEndpointInput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(endpointConfigName)(_.endpointConfigName(_))
        .ifSome(retainAllVariantProperties)(_.retainAllVariantProperties(_))
        .ifSome(excludeRetainedVariantProperties)(_.excludeRetainedVariantProperties(_))
        .ifSome(deploymentConfig)(_.deploymentConfig(_))
        .build

    def updateEndpointOutput(
      endpointArn: Option[String] = None
    ): UpdateEndpointOutput =
      UpdateEndpointOutput
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def updateEndpointWeightsAndCapacitiesInput(
      endpointName: Option[String] = None,
      desiredWeightsAndCapacities: Option[List[DesiredWeightAndCapacity]] = None
    ): UpdateEndpointWeightsAndCapacitiesInput =
      UpdateEndpointWeightsAndCapacitiesInput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(desiredWeightsAndCapacities)(_.desiredWeightsAndCapacities(_))
        .build

    def updateEndpointWeightsAndCapacitiesOutput(
      endpointArn: Option[String] = None
    ): UpdateEndpointWeightsAndCapacitiesOutput =
      UpdateEndpointWeightsAndCapacitiesOutput
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def updateExperimentRequest(
      experimentName: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None
    ): UpdateExperimentRequest =
      UpdateExperimentRequest
        .builder
        .ifSome(experimentName)(_.experimentName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .build

    def updateExperimentResponse(
      experimentArn: Option[String] = None
    ): UpdateExperimentResponse =
      UpdateExperimentResponse
        .builder
        .ifSome(experimentArn)(_.experimentArn(_))
        .build

    def updateImageRequest(
      deleteProperties: Option[List[ImageDeleteProperty]] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      imageName: Option[String] = None,
      roleArn: Option[String] = None
    ): UpdateImageRequest =
      UpdateImageRequest
        .builder
        .ifSome(deleteProperties)(_.deleteProperties(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateImageResponse(
      imageArn: Option[String] = None
    ): UpdateImageResponse =
      UpdateImageResponse
        .builder
        .ifSome(imageArn)(_.imageArn(_))
        .build

    def updateModelPackageInput(
      modelPackageArn: Option[String] = None,
      modelApprovalStatus: Option[String] = None,
      approvalDescription: Option[String] = None
    ): UpdateModelPackageInput =
      UpdateModelPackageInput
        .builder
        .ifSome(modelPackageArn)(_.modelPackageArn(_))
        .ifSome(modelApprovalStatus)(_.modelApprovalStatus(_))
        .ifSome(approvalDescription)(_.approvalDescription(_))
        .build

    def updateModelPackageOutput(
      modelPackageArn: Option[String] = None
    ): UpdateModelPackageOutput =
      UpdateModelPackageOutput
        .builder
        .ifSome(modelPackageArn)(_.modelPackageArn(_))
        .build

    def updateMonitoringScheduleRequest(
      monitoringScheduleName: Option[String] = None,
      monitoringScheduleConfig: Option[MonitoringScheduleConfig] = None
    ): UpdateMonitoringScheduleRequest =
      UpdateMonitoringScheduleRequest
        .builder
        .ifSome(monitoringScheduleName)(_.monitoringScheduleName(_))
        .ifSome(monitoringScheduleConfig)(_.monitoringScheduleConfig(_))
        .build

    def updateMonitoringScheduleResponse(
      monitoringScheduleArn: Option[String] = None
    ): UpdateMonitoringScheduleResponse =
      UpdateMonitoringScheduleResponse
        .builder
        .ifSome(monitoringScheduleArn)(_.monitoringScheduleArn(_))
        .build

    def updateNotebookInstanceInput(
      notebookInstanceName: Option[String] = None,
      instanceType: Option[String] = None,
      roleArn: Option[String] = None,
      lifecycleConfigName: Option[String] = None,
      disassociateLifecycleConfig: Option[Boolean] = None,
      volumeSizeInGB: Option[Int] = None,
      defaultCodeRepository: Option[String] = None,
      additionalCodeRepositories: Option[List[CodeRepositoryNameOrUrl]] = None,
      acceleratorTypes: Option[List[NotebookInstanceAcceleratorType]] = None,
      disassociateAcceleratorTypes: Option[Boolean] = None,
      disassociateDefaultCodeRepository: Option[Boolean] = None,
      disassociateAdditionalCodeRepositories: Option[Boolean] = None,
      rootAccess: Option[String] = None
    ): UpdateNotebookInstanceInput =
      UpdateNotebookInstanceInput
        .builder
        .ifSome(notebookInstanceName)(_.notebookInstanceName(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(lifecycleConfigName)(_.lifecycleConfigName(_))
        .ifSome(disassociateLifecycleConfig)(_.disassociateLifecycleConfig(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .ifSome(defaultCodeRepository)(_.defaultCodeRepository(_))
        .ifSome(additionalCodeRepositories)(_.additionalCodeRepositories(_))
        .ifSome(acceleratorTypes)(_.acceleratorTypes(_))
        .ifSome(disassociateAcceleratorTypes)(_.disassociateAcceleratorTypes(_))
        .ifSome(disassociateDefaultCodeRepository)(_.disassociateDefaultCodeRepository(_))
        .ifSome(disassociateAdditionalCodeRepositories)(_.disassociateAdditionalCodeRepositories(_))
        .ifSome(rootAccess)(_.rootAccess(_))
        .build

    def updateNotebookInstanceLifecycleConfigInput(
      notebookInstanceLifecycleConfigName: Option[String] = None,
      onCreate: Option[List[NotebookInstanceLifecycleHook]] = None,
      onStart: Option[List[NotebookInstanceLifecycleHook]] = None
    ): UpdateNotebookInstanceLifecycleConfigInput =
      UpdateNotebookInstanceLifecycleConfigInput
        .builder
        .ifSome(notebookInstanceLifecycleConfigName)(_.notebookInstanceLifecycleConfigName(_))
        .ifSome(onCreate)(_.onCreate(_))
        .ifSome(onStart)(_.onStart(_))
        .build

    def updateNotebookInstanceLifecycleConfigOutput(

    ): UpdateNotebookInstanceLifecycleConfigOutput =
      UpdateNotebookInstanceLifecycleConfigOutput
        .builder

        .build

    def updateNotebookInstanceOutput(

    ): UpdateNotebookInstanceOutput =
      UpdateNotebookInstanceOutput
        .builder

        .build

    def updatePipelineExecutionRequest(
      pipelineExecutionArn: Option[String] = None,
      pipelineExecutionDescription: Option[String] = None,
      pipelineExecutionDisplayName: Option[String] = None
    ): UpdatePipelineExecutionRequest =
      UpdatePipelineExecutionRequest
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .ifSome(pipelineExecutionDescription)(_.pipelineExecutionDescription(_))
        .ifSome(pipelineExecutionDisplayName)(_.pipelineExecutionDisplayName(_))
        .build

    def updatePipelineExecutionResponse(
      pipelineExecutionArn: Option[String] = None
    ): UpdatePipelineExecutionResponse =
      UpdatePipelineExecutionResponse
        .builder
        .ifSome(pipelineExecutionArn)(_.pipelineExecutionArn(_))
        .build

    def updatePipelineRequest(
      pipelineName: Option[String] = None,
      pipelineDisplayName: Option[String] = None,
      pipelineDefinition: Option[String] = None,
      pipelineDescription: Option[String] = None,
      roleArn: Option[String] = None
    ): UpdatePipelineRequest =
      UpdatePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineDisplayName)(_.pipelineDisplayName(_))
        .ifSome(pipelineDefinition)(_.pipelineDefinition(_))
        .ifSome(pipelineDescription)(_.pipelineDescription(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updatePipelineResponse(
      pipelineArn: Option[String] = None
    ): UpdatePipelineResponse =
      UpdatePipelineResponse
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .build

    def updateTrainingJobRequest(
      trainingJobName: Option[String] = None,
      profilerConfig: Option[ProfilerConfigForUpdate] = None,
      profilerRuleConfigurations: Option[List[ProfilerRuleConfiguration]] = None
    ): UpdateTrainingJobRequest =
      UpdateTrainingJobRequest
        .builder
        .ifSome(trainingJobName)(_.trainingJobName(_))
        .ifSome(profilerConfig)(_.profilerConfig(_))
        .ifSome(profilerRuleConfigurations)(_.profilerRuleConfigurations(_))
        .build

    def updateTrainingJobResponse(
      trainingJobArn: Option[String] = None
    ): UpdateTrainingJobResponse =
      UpdateTrainingJobResponse
        .builder
        .ifSome(trainingJobArn)(_.trainingJobArn(_))
        .build

    def updateTrialComponentRequest(
      trialComponentName: Option[String] = None,
      displayName: Option[String] = None,
      status: Option[TrialComponentStatus] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      parameters: Option[TrialComponentParameters] = None,
      parametersToRemove: Option[List[TrialComponentKey256]] = None,
      inputArtifacts: Option[TrialComponentArtifacts] = None,
      inputArtifactsToRemove: Option[List[TrialComponentKey256]] = None,
      outputArtifacts: Option[TrialComponentArtifacts] = None,
      outputArtifactsToRemove: Option[List[TrialComponentKey256]] = None
    ): UpdateTrialComponentRequest =
      UpdateTrialComponentRequest
        .builder
        .ifSome(trialComponentName)(_.trialComponentName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(parametersToRemove)(_.parametersToRemove(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(inputArtifactsToRemove)(_.inputArtifactsToRemove(_))
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(outputArtifactsToRemove)(_.outputArtifactsToRemove(_))
        .build

    def updateTrialComponentResponse(
      trialComponentArn: Option[String] = None
    ): UpdateTrialComponentResponse =
      UpdateTrialComponentResponse
        .builder
        .ifSome(trialComponentArn)(_.trialComponentArn(_))
        .build

    def updateTrialRequest(
      trialName: Option[String] = None,
      displayName: Option[String] = None
    ): UpdateTrialRequest =
      UpdateTrialRequest
        .builder
        .ifSome(trialName)(_.trialName(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def updateTrialResponse(
      trialArn: Option[String] = None
    ): UpdateTrialResponse =
      UpdateTrialResponse
        .builder
        .ifSome(trialArn)(_.trialArn(_))
        .build

    def updateUserProfileRequest(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      userSettings: Option[UserSettings] = None
    ): UpdateUserProfileRequest =
      UpdateUserProfileRequest
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(userSettings)(_.userSettings(_))
        .build

    def updateUserProfileResponse(
      userProfileArn: Option[String] = None
    ): UpdateUserProfileResponse =
      UpdateUserProfileResponse
        .builder
        .ifSome(userProfileArn)(_.userProfileArn(_))
        .build

    def updateWorkforceRequest(
      workforceName: Option[String] = None,
      sourceIpConfig: Option[SourceIpConfig] = None,
      oidcConfig: Option[OidcConfig] = None
    ): UpdateWorkforceRequest =
      UpdateWorkforceRequest
        .builder
        .ifSome(workforceName)(_.workforceName(_))
        .ifSome(sourceIpConfig)(_.sourceIpConfig(_))
        .ifSome(oidcConfig)(_.oidcConfig(_))
        .build

    def updateWorkforceResponse(
      workforce: Option[Workforce] = None
    ): UpdateWorkforceResponse =
      UpdateWorkforceResponse
        .builder
        .ifSome(workforce)(_.workforce(_))
        .build

    def updateWorkteamRequest(
      workteamName: Option[String] = None,
      memberDefinitions: Option[List[MemberDefinition]] = None,
      description: Option[String] = None,
      notificationConfiguration: Option[NotificationConfiguration] = None
    ): UpdateWorkteamRequest =
      UpdateWorkteamRequest
        .builder
        .ifSome(workteamName)(_.workteamName(_))
        .ifSome(memberDefinitions)(_.memberDefinitions(_))
        .ifSome(description)(_.description(_))
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .build

    def updateWorkteamResponse(
      workteam: Option[Workteam] = None
    ): UpdateWorkteamResponse =
      UpdateWorkteamResponse
        .builder
        .ifSome(workteam)(_.workteam(_))
        .build

    def userContext(
      userProfileArn: Option[String] = None,
      userProfileName: Option[String] = None,
      domainId: Option[String] = None
    ): UserContext =
      UserContext
        .builder
        .ifSome(userProfileArn)(_.userProfileArn(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(domainId)(_.domainId(_))
        .build

    def userProfileDetails(
      domainId: Option[String] = None,
      userProfileName: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastModifiedTime: Option[LastModifiedTime] = None
    ): UserProfileDetails =
      UserProfileDetails
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(userProfileName)(_.userProfileName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def userSettings(
      executionRole: Option[String] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      sharingSettings: Option[SharingSettings] = None,
      jupyterServerAppSettings: Option[JupyterServerAppSettings] = None,
      kernelGatewayAppSettings: Option[KernelGatewayAppSettings] = None,
      tensorBoardAppSettings: Option[TensorBoardAppSettings] = None
    ): UserSettings =
      UserSettings
        .builder
        .ifSome(executionRole)(_.executionRole(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(sharingSettings)(_.sharingSettings(_))
        .ifSome(jupyterServerAppSettings)(_.jupyterServerAppSettings(_))
        .ifSome(kernelGatewayAppSettings)(_.kernelGatewayAppSettings(_))
        .ifSome(tensorBoardAppSettings)(_.tensorBoardAppSettings(_))
        .build

    def variantProperty(
      variantPropertyType: Option[String] = None
    ): VariantProperty =
      VariantProperty
        .builder
        .ifSome(variantPropertyType)(_.variantPropertyType(_))
        .build

    def vpcConfig(
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      subnets: Option[List[SubnetId]] = None
    ): VpcConfig =
      VpcConfig
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnets)(_.subnets(_))
        .build

    def workforce(
      workforceName: Option[String] = None,
      workforceArn: Option[String] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      sourceIpConfig: Option[SourceIpConfig] = None,
      subDomain: Option[String] = None,
      cognitoConfig: Option[CognitoConfig] = None,
      oidcConfig: Option[OidcConfigForResponse] = None,
      createDate: Option[Timestamp] = None
    ): Workforce =
      Workforce
        .builder
        .ifSome(workforceName)(_.workforceName(_))
        .ifSome(workforceArn)(_.workforceArn(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(sourceIpConfig)(_.sourceIpConfig(_))
        .ifSome(subDomain)(_.subDomain(_))
        .ifSome(cognitoConfig)(_.cognitoConfig(_))
        .ifSome(oidcConfig)(_.oidcConfig(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def workteam(
      workteamName: Option[String] = None,
      memberDefinitions: Option[List[MemberDefinition]] = None,
      workteamArn: Option[String] = None,
      workforceArn: Option[String] = None,
      productListingIds: Option[List[String]] = None,
      description: Option[String] = None,
      subDomain: Option[String] = None,
      createDate: Option[Timestamp] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      notificationConfiguration: Option[NotificationConfiguration] = None
    ): Workteam =
      Workteam
        .builder
        .ifSome(workteamName)(_.workteamName(_))
        .ifSome(memberDefinitions)(_.memberDefinitions(_))
        .ifSome(workteamArn)(_.workteamArn(_))
        .ifSome(workforceArn)(_.workforceArn(_))
        .ifSome(productListingIds)(_.productListingIds(_))
        .ifSome(description)(_.description(_))
        .ifSome(subDomain)(_.subDomain(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
