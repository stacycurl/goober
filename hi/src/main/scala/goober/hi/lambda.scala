package goober.hi

import goober.free.lambda.LambdaIO
import software.amazon.awssdk.services.lambda.model._


object lambda {
  import goober.free.{lambda ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountLimit(
      totalCodeSize: Option[Long] = None,
      codeSizeUnzipped: Option[Long] = None,
      codeSizeZipped: Option[Long] = None,
      concurrentExecutions: Option[Int] = None,
      unreservedConcurrentExecutions: Option[Int] = None
    ): AccountLimit =
      AccountLimit
        .builder
        .ifSome(totalCodeSize)(_.totalCodeSize(_))
        .ifSome(codeSizeUnzipped)(_.codeSizeUnzipped(_))
        .ifSome(codeSizeZipped)(_.codeSizeZipped(_))
        .ifSome(concurrentExecutions)(_.concurrentExecutions(_))
        .ifSome(unreservedConcurrentExecutions)(_.unreservedConcurrentExecutions(_))
        .build

    def accountUsage(
      totalCodeSize: Option[Long] = None,
      functionCount: Option[Long] = None
    ): AccountUsage =
      AccountUsage
        .builder
        .ifSome(totalCodeSize)(_.totalCodeSize(_))
        .ifSome(functionCount)(_.functionCount(_))
        .build

    def addLayerVersionPermissionRequest(
      layerName: Option[String] = None,
      versionNumber: Option[LayerVersionNumber] = None,
      statementId: Option[String] = None,
      action: Option[String] = None,
      principal: Option[String] = None,
      organizationId: Option[String] = None,
      revisionId: Option[String] = None
    ): AddLayerVersionPermissionRequest =
      AddLayerVersionPermissionRequest
        .builder
        .ifSome(layerName)(_.layerName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(action)(_.action(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def addLayerVersionPermissionResponse(
      statement: Option[String] = None,
      revisionId: Option[String] = None
    ): AddLayerVersionPermissionResponse =
      AddLayerVersionPermissionResponse
        .builder
        .ifSome(statement)(_.statement(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def addPermissionRequest(
      functionName: Option[String] = None,
      statementId: Option[String] = None,
      action: Option[String] = None,
      principal: Option[String] = None,
      sourceArn: Option[String] = None,
      sourceAccount: Option[String] = None,
      eventSourceToken: Option[String] = None,
      qualifier: Option[String] = None,
      revisionId: Option[String] = None
    ): AddPermissionRequest =
      AddPermissionRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(action)(_.action(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceAccount)(_.sourceAccount(_))
        .ifSome(eventSourceToken)(_.eventSourceToken(_))
        .ifSome(qualifier)(_.qualifier(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def addPermissionResponse(
      statement: Option[String] = None
    ): AddPermissionResponse =
      AddPermissionResponse
        .builder
        .ifSome(statement)(_.statement(_))
        .build

    def aliasConfiguration(
      aliasArn: Option[String] = None,
      name: Option[String] = None,
      functionVersion: Option[String] = None,
      description: Option[String] = None,
      routingConfig: Option[AliasRoutingConfiguration] = None,
      revisionId: Option[String] = None
    ): AliasConfiguration =
      AliasConfiguration
        .builder
        .ifSome(aliasArn)(_.aliasArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(routingConfig)(_.routingConfig(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def aliasRoutingConfiguration(
      additionalVersionWeights: Option[AdditionalVersionWeights] = None
    ): AliasRoutingConfiguration =
      AliasRoutingConfiguration
        .builder
        .ifSome(additionalVersionWeights)(_.additionalVersionWeights(_))
        .build

    def allowedPublishers(
      signingProfileVersionArns: Option[List[Arn]] = None
    ): AllowedPublishers =
      AllowedPublishers
        .builder
        .ifSome(signingProfileVersionArns)(_.signingProfileVersionArns(_))
        .build

    def codeSigningConfig(
      codeSigningConfigId: Option[String] = None,
      codeSigningConfigArn: Option[String] = None,
      description: Option[String] = None,
      allowedPublishers: Option[AllowedPublishers] = None,
      codeSigningPolicies: Option[CodeSigningPolicies] = None,
      lastModified: Option[String] = None
    ): CodeSigningConfig =
      CodeSigningConfig
        .builder
        .ifSome(codeSigningConfigId)(_.codeSigningConfigId(_))
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(allowedPublishers)(_.allowedPublishers(_))
        .ifSome(codeSigningPolicies)(_.codeSigningPolicies(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def codeSigningConfigNotFoundException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): CodeSigningConfigNotFoundException =
      CodeSigningConfigNotFoundException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def codeSigningPolicies(
      untrustedArtifactOnDeployment: Option[String] = None
    ): CodeSigningPolicies =
      CodeSigningPolicies
        .builder
        .ifSome(untrustedArtifactOnDeployment)(_.untrustedArtifactOnDeployment(_))
        .build

    def codeStorageExceededException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): CodeStorageExceededException =
      CodeStorageExceededException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def codeVerificationFailedException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): CodeVerificationFailedException =
      CodeVerificationFailedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def concurrency(
      reservedConcurrentExecutions: Option[Int] = None
    ): Concurrency =
      Concurrency
        .builder
        .ifSome(reservedConcurrentExecutions)(_.reservedConcurrentExecutions(_))
        .build

    def createAliasRequest(
      functionName: Option[String] = None,
      name: Option[String] = None,
      functionVersion: Option[String] = None,
      description: Option[String] = None,
      routingConfig: Option[AliasRoutingConfiguration] = None
    ): CreateAliasRequest =
      CreateAliasRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(name)(_.name(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(routingConfig)(_.routingConfig(_))
        .build

    def createCodeSigningConfigRequest(
      description: Option[String] = None,
      allowedPublishers: Option[AllowedPublishers] = None,
      codeSigningPolicies: Option[CodeSigningPolicies] = None
    ): CreateCodeSigningConfigRequest =
      CreateCodeSigningConfigRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(allowedPublishers)(_.allowedPublishers(_))
        .ifSome(codeSigningPolicies)(_.codeSigningPolicies(_))
        .build

    def createCodeSigningConfigResponse(
      codeSigningConfig: Option[CodeSigningConfig] = None
    ): CreateCodeSigningConfigResponse =
      CreateCodeSigningConfigResponse
        .builder
        .ifSome(codeSigningConfig)(_.codeSigningConfig(_))
        .build

    def createEventSourceMappingRequest(
      eventSourceArn: Option[String] = None,
      functionName: Option[String] = None,
      enabled: Option[Boolean] = None,
      batchSize: Option[Int] = None,
      maximumBatchingWindowInSeconds: Option[Int] = None,
      parallelizationFactor: Option[Int] = None,
      startingPosition: Option[String] = None,
      startingPositionTimestamp: Option[Date] = None,
      destinationConfig: Option[DestinationConfig] = None,
      maximumRecordAgeInSeconds: Option[Int] = None,
      bisectBatchOnFunctionError: Option[Boolean] = None,
      maximumRetryAttempts: Option[Int] = None,
      tumblingWindowInSeconds: Option[Int] = None,
      topics: Option[List[Topic]] = None,
      queues: Option[List[Queue]] = None,
      sourceAccessConfigurations: Option[List[SourceAccessConfiguration]] = None,
      selfManagedEventSource: Option[SelfManagedEventSource] = None,
      functionResponseTypes: Option[List[FunctionResponseType]] = None
    ): CreateEventSourceMappingRequest =
      CreateEventSourceMappingRequest
        .builder
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(functionName)(_.functionName(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(batchSize)(_.batchSize(_))
        .ifSome(maximumBatchingWindowInSeconds)(_.maximumBatchingWindowInSeconds(_))
        .ifSome(parallelizationFactor)(_.parallelizationFactor(_))
        .ifSome(startingPosition)(_.startingPosition(_))
        .ifSome(startingPositionTimestamp)(_.startingPositionTimestamp(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .ifSome(maximumRecordAgeInSeconds)(_.maximumRecordAgeInSeconds(_))
        .ifSome(bisectBatchOnFunctionError)(_.bisectBatchOnFunctionError(_))
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .ifSome(tumblingWindowInSeconds)(_.tumblingWindowInSeconds(_))
        .ifSome(topics)(_.topics(_))
        .ifSome(queues)(_.queues(_))
        .ifSome(sourceAccessConfigurations)(_.sourceAccessConfigurations(_))
        .ifSome(selfManagedEventSource)(_.selfManagedEventSource(_))
        .ifSome(functionResponseTypes)(_.functionResponseTypes(_))
        .build

    def createFunctionRequest(
      functionName: Option[String] = None,
      runtime: Option[String] = None,
      role: Option[String] = None,
      handler: Option[String] = None,
      code: Option[FunctionCode] = None,
      description: Option[String] = None,
      timeout: Option[Int] = None,
      memorySize: Option[Int] = None,
      publish: Option[Boolean] = None,
      vpcConfig: Option[VpcConfig] = None,
      packageType: Option[String] = None,
      deadLetterConfig: Option[DeadLetterConfig] = None,
      environment: Option[Environment] = None,
      kMSKeyArn: Option[String] = None,
      tracingConfig: Option[TracingConfig] = None,
      tags: Option[Tags] = None,
      layers: Option[List[LayerVersionArn]] = None,
      fileSystemConfigs: Option[List[FileSystemConfig]] = None,
      imageConfig: Option[ImageConfig] = None,
      codeSigningConfigArn: Option[String] = None
    ): CreateFunctionRequest =
      CreateFunctionRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(runtime)(_.runtime(_))
        .ifSome(role)(_.role(_))
        .ifSome(handler)(_.handler(_))
        .ifSome(code)(_.code(_))
        .ifSome(description)(_.description(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(memorySize)(_.memorySize(_))
        .ifSome(publish)(_.publish(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(packageType)(_.packageType(_))
        .ifSome(deadLetterConfig)(_.deadLetterConfig(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(kMSKeyArn)(_.kMSKeyArn(_))
        .ifSome(tracingConfig)(_.tracingConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(layers)(_.layers(_))
        .ifSome(fileSystemConfigs)(_.fileSystemConfigs(_))
        .ifSome(imageConfig)(_.imageConfig(_))
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .build

    def deadLetterConfig(
      targetArn: Option[String] = None
    ): DeadLetterConfig =
      DeadLetterConfig
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .build

    def deleteAliasRequest(
      functionName: Option[String] = None,
      name: Option[String] = None
    ): DeleteAliasRequest =
      DeleteAliasRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteCodeSigningConfigRequest(
      codeSigningConfigArn: Option[String] = None
    ): DeleteCodeSigningConfigRequest =
      DeleteCodeSigningConfigRequest
        .builder
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .build

    def deleteCodeSigningConfigResponse(

    ): DeleteCodeSigningConfigResponse =
      DeleteCodeSigningConfigResponse
        .builder

        .build

    def deleteEventSourceMappingRequest(
      uUID: Option[String] = None
    ): DeleteEventSourceMappingRequest =
      DeleteEventSourceMappingRequest
        .builder
        .ifSome(uUID)(_.uUID(_))
        .build

    def deleteFunctionCodeSigningConfigRequest(
      functionName: Option[String] = None
    ): DeleteFunctionCodeSigningConfigRequest =
      DeleteFunctionCodeSigningConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .build

    def deleteFunctionConcurrencyRequest(
      functionName: Option[String] = None
    ): DeleteFunctionConcurrencyRequest =
      DeleteFunctionConcurrencyRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .build

    def deleteFunctionEventInvokeConfigRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): DeleteFunctionEventInvokeConfigRequest =
      DeleteFunctionEventInvokeConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def deleteFunctionRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): DeleteFunctionRequest =
      DeleteFunctionRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def deleteLayerVersionRequest(
      layerName: Option[String] = None,
      versionNumber: Option[LayerVersionNumber] = None
    ): DeleteLayerVersionRequest =
      DeleteLayerVersionRequest
        .builder
        .ifSome(layerName)(_.layerName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def deleteProvisionedConcurrencyConfigRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): DeleteProvisionedConcurrencyConfigRequest =
      DeleteProvisionedConcurrencyConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def destinationConfig(
      onSuccess: Option[OnSuccess] = None,
      onFailure: Option[OnFailure] = None
    ): DestinationConfig =
      DestinationConfig
        .builder
        .ifSome(onSuccess)(_.onSuccess(_))
        .ifSome(onFailure)(_.onFailure(_))
        .build

    def eC2AccessDeniedException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): EC2AccessDeniedException =
      EC2AccessDeniedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def eC2ThrottledException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): EC2ThrottledException =
      EC2ThrottledException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def eC2UnexpectedException(
      `type`: Option[String] = None,
      message: Option[String] = None,
      eC2ErrorCode: Option[String] = None
    ): EC2UnexpectedException =
      EC2UnexpectedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .ifSome(eC2ErrorCode)(_.eC2ErrorCode(_))
        .build

    def eFSIOException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): EFSIOException =
      EFSIOException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def eFSMountConnectivityException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): EFSMountConnectivityException =
      EFSMountConnectivityException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def eFSMountFailureException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): EFSMountFailureException =
      EFSMountFailureException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def eFSMountTimeoutException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): EFSMountTimeoutException =
      EFSMountTimeoutException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def eNILimitReachedException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ENILimitReachedException =
      ENILimitReachedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def environment(
      variables: Option[EnvironmentVariables] = None
    ): Environment =
      Environment
        .builder
        .ifSome(variables)(_.variables(_))
        .build

    def environmentError(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): EnvironmentError =
      EnvironmentError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def environmentResponse(
      variables: Option[EnvironmentVariables] = None,
      error: Option[EnvironmentError] = None
    ): EnvironmentResponse =
      EnvironmentResponse
        .builder
        .ifSome(variables)(_.variables(_))
        .ifSome(error)(_.error(_))
        .build

    def eventSourceMappingConfiguration(
      uUID: Option[String] = None,
      startingPosition: Option[String] = None,
      startingPositionTimestamp: Option[Date] = None,
      batchSize: Option[Int] = None,
      maximumBatchingWindowInSeconds: Option[Int] = None,
      parallelizationFactor: Option[Int] = None,
      eventSourceArn: Option[String] = None,
      functionArn: Option[String] = None,
      lastModified: Option[Date] = None,
      lastProcessingResult: Option[String] = None,
      state: Option[String] = None,
      stateTransitionReason: Option[String] = None,
      destinationConfig: Option[DestinationConfig] = None,
      topics: Option[List[Topic]] = None,
      queues: Option[List[Queue]] = None,
      sourceAccessConfigurations: Option[List[SourceAccessConfiguration]] = None,
      selfManagedEventSource: Option[SelfManagedEventSource] = None,
      maximumRecordAgeInSeconds: Option[Int] = None,
      bisectBatchOnFunctionError: Option[Boolean] = None,
      maximumRetryAttempts: Option[Int] = None,
      tumblingWindowInSeconds: Option[Int] = None,
      functionResponseTypes: Option[List[FunctionResponseType]] = None
    ): EventSourceMappingConfiguration =
      EventSourceMappingConfiguration
        .builder
        .ifSome(uUID)(_.uUID(_))
        .ifSome(startingPosition)(_.startingPosition(_))
        .ifSome(startingPositionTimestamp)(_.startingPositionTimestamp(_))
        .ifSome(batchSize)(_.batchSize(_))
        .ifSome(maximumBatchingWindowInSeconds)(_.maximumBatchingWindowInSeconds(_))
        .ifSome(parallelizationFactor)(_.parallelizationFactor(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(lastProcessingResult)(_.lastProcessingResult(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateTransitionReason)(_.stateTransitionReason(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .ifSome(topics)(_.topics(_))
        .ifSome(queues)(_.queues(_))
        .ifSome(sourceAccessConfigurations)(_.sourceAccessConfigurations(_))
        .ifSome(selfManagedEventSource)(_.selfManagedEventSource(_))
        .ifSome(maximumRecordAgeInSeconds)(_.maximumRecordAgeInSeconds(_))
        .ifSome(bisectBatchOnFunctionError)(_.bisectBatchOnFunctionError(_))
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .ifSome(tumblingWindowInSeconds)(_.tumblingWindowInSeconds(_))
        .ifSome(functionResponseTypes)(_.functionResponseTypes(_))
        .build

    def fileSystemConfig(
      arn: Option[String] = None,
      localMountPath: Option[String] = None
    ): FileSystemConfig =
      FileSystemConfig
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(localMountPath)(_.localMountPath(_))
        .build

    def functionCode(
      zipFile: Option[Blob] = None,
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None,
      s3ObjectVersion: Option[String] = None,
      imageUri: Option[String] = None
    ): FunctionCode =
      FunctionCode
        .builder
        .ifSome(zipFile)(_.zipFile(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(s3ObjectVersion)(_.s3ObjectVersion(_))
        .ifSome(imageUri)(_.imageUri(_))
        .build

    def functionCodeLocation(
      repositoryType: Option[String] = None,
      location: Option[String] = None,
      imageUri: Option[String] = None,
      resolvedImageUri: Option[String] = None
    ): FunctionCodeLocation =
      FunctionCodeLocation
        .builder
        .ifSome(repositoryType)(_.repositoryType(_))
        .ifSome(location)(_.location(_))
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(resolvedImageUri)(_.resolvedImageUri(_))
        .build

    def functionConfiguration(
      functionName: Option[String] = None,
      functionArn: Option[String] = None,
      runtime: Option[String] = None,
      role: Option[String] = None,
      handler: Option[String] = None,
      codeSize: Option[Long] = None,
      description: Option[String] = None,
      timeout: Option[Int] = None,
      memorySize: Option[Int] = None,
      lastModified: Option[String] = None,
      codeSha256: Option[String] = None,
      version: Option[String] = None,
      vpcConfig: Option[VpcConfigResponse] = None,
      deadLetterConfig: Option[DeadLetterConfig] = None,
      environment: Option[EnvironmentResponse] = None,
      kMSKeyArn: Option[String] = None,
      tracingConfig: Option[TracingConfigResponse] = None,
      masterArn: Option[String] = None,
      revisionId: Option[String] = None,
      layers: Option[List[Layer]] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      stateReasonCode: Option[String] = None,
      lastUpdateStatus: Option[String] = None,
      lastUpdateStatusReason: Option[String] = None,
      lastUpdateStatusReasonCode: Option[String] = None,
      fileSystemConfigs: Option[List[FileSystemConfig]] = None,
      packageType: Option[String] = None,
      imageConfigResponse: Option[ImageConfigResponse] = None,
      signingProfileVersionArn: Option[String] = None,
      signingJobArn: Option[String] = None
    ): FunctionConfiguration =
      FunctionConfiguration
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(runtime)(_.runtime(_))
        .ifSome(role)(_.role(_))
        .ifSome(handler)(_.handler(_))
        .ifSome(codeSize)(_.codeSize(_))
        .ifSome(description)(_.description(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(memorySize)(_.memorySize(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(codeSha256)(_.codeSha256(_))
        .ifSome(version)(_.version(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(deadLetterConfig)(_.deadLetterConfig(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(kMSKeyArn)(_.kMSKeyArn(_))
        .ifSome(tracingConfig)(_.tracingConfig(_))
        .ifSome(masterArn)(_.masterArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(layers)(_.layers(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(stateReasonCode)(_.stateReasonCode(_))
        .ifSome(lastUpdateStatus)(_.lastUpdateStatus(_))
        .ifSome(lastUpdateStatusReason)(_.lastUpdateStatusReason(_))
        .ifSome(lastUpdateStatusReasonCode)(_.lastUpdateStatusReasonCode(_))
        .ifSome(fileSystemConfigs)(_.fileSystemConfigs(_))
        .ifSome(packageType)(_.packageType(_))
        .ifSome(imageConfigResponse)(_.imageConfigResponse(_))
        .ifSome(signingProfileVersionArn)(_.signingProfileVersionArn(_))
        .ifSome(signingJobArn)(_.signingJobArn(_))
        .build

    def functionEventInvokeConfig(
      lastModified: Option[Date] = None,
      functionArn: Option[String] = None,
      maximumRetryAttempts: Option[Int] = None,
      maximumEventAgeInSeconds: Option[Int] = None,
      destinationConfig: Option[DestinationConfig] = None
    ): FunctionEventInvokeConfig =
      FunctionEventInvokeConfig
        .builder
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .ifSome(maximumEventAgeInSeconds)(_.maximumEventAgeInSeconds(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .build

    def getAccountSettingsRequest(

    ): GetAccountSettingsRequest =
      GetAccountSettingsRequest
        .builder

        .build

    def getAccountSettingsResponse(
      accountLimit: Option[AccountLimit] = None,
      accountUsage: Option[AccountUsage] = None
    ): GetAccountSettingsResponse =
      GetAccountSettingsResponse
        .builder
        .ifSome(accountLimit)(_.accountLimit(_))
        .ifSome(accountUsage)(_.accountUsage(_))
        .build

    def getAliasRequest(
      functionName: Option[String] = None,
      name: Option[String] = None
    ): GetAliasRequest =
      GetAliasRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(name)(_.name(_))
        .build

    def getCodeSigningConfigRequest(
      codeSigningConfigArn: Option[String] = None
    ): GetCodeSigningConfigRequest =
      GetCodeSigningConfigRequest
        .builder
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .build

    def getCodeSigningConfigResponse(
      codeSigningConfig: Option[CodeSigningConfig] = None
    ): GetCodeSigningConfigResponse =
      GetCodeSigningConfigResponse
        .builder
        .ifSome(codeSigningConfig)(_.codeSigningConfig(_))
        .build

    def getEventSourceMappingRequest(
      uUID: Option[String] = None
    ): GetEventSourceMappingRequest =
      GetEventSourceMappingRequest
        .builder
        .ifSome(uUID)(_.uUID(_))
        .build

    def getFunctionCodeSigningConfigRequest(
      functionName: Option[String] = None
    ): GetFunctionCodeSigningConfigRequest =
      GetFunctionCodeSigningConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .build

    def getFunctionCodeSigningConfigResponse(
      codeSigningConfigArn: Option[String] = None,
      functionName: Option[String] = None
    ): GetFunctionCodeSigningConfigResponse =
      GetFunctionCodeSigningConfigResponse
        .builder
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .ifSome(functionName)(_.functionName(_))
        .build

    def getFunctionConcurrencyRequest(
      functionName: Option[String] = None
    ): GetFunctionConcurrencyRequest =
      GetFunctionConcurrencyRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .build

    def getFunctionConcurrencyResponse(
      reservedConcurrentExecutions: Option[Int] = None
    ): GetFunctionConcurrencyResponse =
      GetFunctionConcurrencyResponse
        .builder
        .ifSome(reservedConcurrentExecutions)(_.reservedConcurrentExecutions(_))
        .build

    def getFunctionConfigurationRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): GetFunctionConfigurationRequest =
      GetFunctionConfigurationRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def getFunctionEventInvokeConfigRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): GetFunctionEventInvokeConfigRequest =
      GetFunctionEventInvokeConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def getFunctionRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): GetFunctionRequest =
      GetFunctionRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def getFunctionResponse(
      configuration: Option[FunctionConfiguration] = None,
      code: Option[FunctionCodeLocation] = None,
      tags: Option[Tags] = None,
      concurrency: Option[Concurrency] = None
    ): GetFunctionResponse =
      GetFunctionResponse
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(code)(_.code(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(concurrency)(_.concurrency(_))
        .build

    def getLayerVersionByArnRequest(
      arn: Option[String] = None
    ): GetLayerVersionByArnRequest =
      GetLayerVersionByArnRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getLayerVersionPolicyRequest(
      layerName: Option[String] = None,
      versionNumber: Option[LayerVersionNumber] = None
    ): GetLayerVersionPolicyRequest =
      GetLayerVersionPolicyRequest
        .builder
        .ifSome(layerName)(_.layerName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def getLayerVersionPolicyResponse(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): GetLayerVersionPolicyResponse =
      GetLayerVersionPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getLayerVersionRequest(
      layerName: Option[String] = None,
      versionNumber: Option[LayerVersionNumber] = None
    ): GetLayerVersionRequest =
      GetLayerVersionRequest
        .builder
        .ifSome(layerName)(_.layerName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def getLayerVersionResponse(
      content: Option[LayerVersionContentOutput] = None,
      layerArn: Option[String] = None,
      layerVersionArn: Option[String] = None,
      description: Option[String] = None,
      createdDate: Option[String] = None,
      version: Option[LayerVersionNumber] = None,
      compatibleRuntimes: Option[List[Runtime]] = None,
      licenseInfo: Option[String] = None
    ): GetLayerVersionResponse =
      GetLayerVersionResponse
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(layerArn)(_.layerArn(_))
        .ifSome(layerVersionArn)(_.layerVersionArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(compatibleRuntimes)(_.compatibleRuntimes(_))
        .ifSome(licenseInfo)(_.licenseInfo(_))
        .build

    def getPolicyRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): GetPolicyRequest =
      GetPolicyRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def getPolicyResponse(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): GetPolicyResponse =
      GetPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getProvisionedConcurrencyConfigRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None
    ): GetProvisionedConcurrencyConfigRequest =
      GetProvisionedConcurrencyConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def getProvisionedConcurrencyConfigResponse(
      requestedProvisionedConcurrentExecutions: Option[Int] = None,
      availableProvisionedConcurrentExecutions: Option[Int] = None,
      allocatedProvisionedConcurrentExecutions: Option[Int] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      lastModified: Option[String] = None
    ): GetProvisionedConcurrencyConfigResponse =
      GetProvisionedConcurrencyConfigResponse
        .builder
        .ifSome(requestedProvisionedConcurrentExecutions)(_.requestedProvisionedConcurrentExecutions(_))
        .ifSome(availableProvisionedConcurrentExecutions)(_.availableProvisionedConcurrentExecutions(_))
        .ifSome(allocatedProvisionedConcurrentExecutions)(_.allocatedProvisionedConcurrentExecutions(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def imageConfig(
      entryPoint: Option[List[String]] = None,
      command: Option[List[String]] = None,
      workingDirectory: Option[String] = None
    ): ImageConfig =
      ImageConfig
        .builder
        .ifSome(entryPoint)(_.entryPoint(_))
        .ifSome(command)(_.command(_))
        .ifSome(workingDirectory)(_.workingDirectory(_))
        .build

    def imageConfigError(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): ImageConfigError =
      ImageConfigError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def imageConfigResponse(
      imageConfig: Option[ImageConfig] = None,
      error: Option[ImageConfigError] = None
    ): ImageConfigResponse =
      ImageConfigResponse
        .builder
        .ifSome(imageConfig)(_.imageConfig(_))
        .ifSome(error)(_.error(_))
        .build

    def invalidCodeSignatureException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): InvalidCodeSignatureException =
      InvalidCodeSignatureException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterValueException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestContentException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): InvalidRequestContentException =
      InvalidRequestContentException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidRuntimeException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): InvalidRuntimeException =
      InvalidRuntimeException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidSecurityGroupIDException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): InvalidSecurityGroupIDException =
      InvalidSecurityGroupIDException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidSubnetIDException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): InvalidSubnetIDException =
      InvalidSubnetIDException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidZipFileException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): InvalidZipFileException =
      InvalidZipFileException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def invocationRequest(
      functionName: Option[String] = None,
      invocationType: Option[String] = None,
      logType: Option[String] = None,
      clientContext: Option[String] = None,
      payload: Option[Blob] = None,
      qualifier: Option[String] = None
    ): InvocationRequest =
      InvocationRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(invocationType)(_.invocationType(_))
        .ifSome(logType)(_.logType(_))
        .ifSome(clientContext)(_.clientContext(_))
        .ifSome(payload)(_.payload(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def invocationResponse(
      statusCode: Option[Int] = None,
      functionError: Option[String] = None,
      logResult: Option[String] = None,
      payload: Option[Blob] = None,
      executedVersion: Option[String] = None
    ): InvocationResponse =
      InvocationResponse
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(functionError)(_.functionError(_))
        .ifSome(logResult)(_.logResult(_))
        .ifSome(payload)(_.payload(_))
        .ifSome(executedVersion)(_.executedVersion(_))
        .build

    def invokeAsyncRequest(
      functionName: Option[String] = None,
      invokeArgs: Option[BlobStream] = None
    ): InvokeAsyncRequest =
      InvokeAsyncRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(invokeArgs)(_.invokeArgs(_))
        .build

    def invokeAsyncResponse(
      status: Option[Int] = None
    ): InvokeAsyncResponse =
      InvokeAsyncResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def kMSAccessDeniedException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): KMSAccessDeniedException =
      KMSAccessDeniedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def kMSDisabledException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): KMSDisabledException =
      KMSDisabledException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def kMSInvalidStateException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): KMSInvalidStateException =
      KMSInvalidStateException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def kMSNotFoundException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): KMSNotFoundException =
      KMSNotFoundException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def layer(
      arn: Option[String] = None,
      codeSize: Option[Long] = None,
      signingProfileVersionArn: Option[String] = None,
      signingJobArn: Option[String] = None
    ): Layer =
      Layer
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(codeSize)(_.codeSize(_))
        .ifSome(signingProfileVersionArn)(_.signingProfileVersionArn(_))
        .ifSome(signingJobArn)(_.signingJobArn(_))
        .build

    def layerVersionContentInput(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None,
      s3ObjectVersion: Option[String] = None,
      zipFile: Option[Blob] = None
    ): LayerVersionContentInput =
      LayerVersionContentInput
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(s3ObjectVersion)(_.s3ObjectVersion(_))
        .ifSome(zipFile)(_.zipFile(_))
        .build

    def layerVersionContentOutput(
      location: Option[String] = None,
      codeSha256: Option[String] = None,
      codeSize: Option[Long] = None,
      signingProfileVersionArn: Option[String] = None,
      signingJobArn: Option[String] = None
    ): LayerVersionContentOutput =
      LayerVersionContentOutput
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(codeSha256)(_.codeSha256(_))
        .ifSome(codeSize)(_.codeSize(_))
        .ifSome(signingProfileVersionArn)(_.signingProfileVersionArn(_))
        .ifSome(signingJobArn)(_.signingJobArn(_))
        .build

    def layerVersionsListItem(
      layerVersionArn: Option[String] = None,
      version: Option[LayerVersionNumber] = None,
      description: Option[String] = None,
      createdDate: Option[String] = None,
      compatibleRuntimes: Option[List[Runtime]] = None,
      licenseInfo: Option[String] = None
    ): LayerVersionsListItem =
      LayerVersionsListItem
        .builder
        .ifSome(layerVersionArn)(_.layerVersionArn(_))
        .ifSome(version)(_.version(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(compatibleRuntimes)(_.compatibleRuntimes(_))
        .ifSome(licenseInfo)(_.licenseInfo(_))
        .build

    def layersListItem(
      layerName: Option[String] = None,
      layerArn: Option[String] = None,
      latestMatchingVersion: Option[LayerVersionsListItem] = None
    ): LayersListItem =
      LayersListItem
        .builder
        .ifSome(layerName)(_.layerName(_))
        .ifSome(layerArn)(_.layerArn(_))
        .ifSome(latestMatchingVersion)(_.latestMatchingVersion(_))
        .build

    def listAliasesRequest(
      functionName: Option[String] = None,
      functionVersion: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListAliasesRequest =
      ListAliasesRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listAliasesResponse(
      nextMarker: Option[String] = None,
      aliases: Option[List[AliasConfiguration]] = None
    ): ListAliasesResponse =
      ListAliasesResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(aliases)(_.aliases(_))
        .build

    def listCodeSigningConfigsRequest(
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListCodeSigningConfigsRequest =
      ListCodeSigningConfigsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listCodeSigningConfigsResponse(
      nextMarker: Option[String] = None,
      codeSigningConfigs: Option[List[CodeSigningConfig]] = None
    ): ListCodeSigningConfigsResponse =
      ListCodeSigningConfigsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(codeSigningConfigs)(_.codeSigningConfigs(_))
        .build

    def listEventSourceMappingsRequest(
      eventSourceArn: Option[String] = None,
      functionName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListEventSourceMappingsRequest =
      ListEventSourceMappingsRequest
        .builder
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(functionName)(_.functionName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listEventSourceMappingsResponse(
      nextMarker: Option[String] = None,
      eventSourceMappings: Option[List[EventSourceMappingConfiguration]] = None
    ): ListEventSourceMappingsResponse =
      ListEventSourceMappingsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(eventSourceMappings)(_.eventSourceMappings(_))
        .build

    def listFunctionEventInvokeConfigsRequest(
      functionName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListFunctionEventInvokeConfigsRequest =
      ListFunctionEventInvokeConfigsRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listFunctionEventInvokeConfigsResponse(
      functionEventInvokeConfigs: Option[List[FunctionEventInvokeConfig]] = None,
      nextMarker: Option[String] = None
    ): ListFunctionEventInvokeConfigsResponse =
      ListFunctionEventInvokeConfigsResponse
        .builder
        .ifSome(functionEventInvokeConfigs)(_.functionEventInvokeConfigs(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listFunctionsByCodeSigningConfigRequest(
      codeSigningConfigArn: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListFunctionsByCodeSigningConfigRequest =
      ListFunctionsByCodeSigningConfigRequest
        .builder
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listFunctionsByCodeSigningConfigResponse(
      nextMarker: Option[String] = None,
      functionArns: Option[List[FunctionArn]] = None
    ): ListFunctionsByCodeSigningConfigResponse =
      ListFunctionsByCodeSigningConfigResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(functionArns)(_.functionArns(_))
        .build

    def listFunctionsRequest(
      masterRegion: Option[String] = None,
      functionVersion: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListFunctionsRequest =
      ListFunctionsRequest
        .builder
        .ifSome(masterRegion)(_.masterRegion(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listFunctionsResponse(
      nextMarker: Option[String] = None,
      functions: Option[List[FunctionConfiguration]] = None
    ): ListFunctionsResponse =
      ListFunctionsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(functions)(_.functions(_))
        .build

    def listLayerVersionsRequest(
      compatibleRuntime: Option[String] = None,
      layerName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListLayerVersionsRequest =
      ListLayerVersionsRequest
        .builder
        .ifSome(compatibleRuntime)(_.compatibleRuntime(_))
        .ifSome(layerName)(_.layerName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listLayerVersionsResponse(
      nextMarker: Option[String] = None,
      layerVersions: Option[List[LayerVersionsListItem]] = None
    ): ListLayerVersionsResponse =
      ListLayerVersionsResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(layerVersions)(_.layerVersions(_))
        .build

    def listLayersRequest(
      compatibleRuntime: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListLayersRequest =
      ListLayersRequest
        .builder
        .ifSome(compatibleRuntime)(_.compatibleRuntime(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listLayersResponse(
      nextMarker: Option[String] = None,
      layers: Option[List[LayersListItem]] = None
    ): ListLayersResponse =
      ListLayersResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(layers)(_.layers(_))
        .build

    def listProvisionedConcurrencyConfigsRequest(
      functionName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListProvisionedConcurrencyConfigsRequest =
      ListProvisionedConcurrencyConfigsRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listProvisionedConcurrencyConfigsResponse(
      provisionedConcurrencyConfigs: Option[List[ProvisionedConcurrencyConfigListItem]] = None,
      nextMarker: Option[String] = None
    ): ListProvisionedConcurrencyConfigsResponse =
      ListProvisionedConcurrencyConfigsResponse
        .builder
        .ifSome(provisionedConcurrencyConfigs)(_.provisionedConcurrencyConfigs(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listTagsRequest(
      resource: Option[String] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .build

    def listTagsResponse(
      tags: Option[Tags] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listVersionsByFunctionRequest(
      functionName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListVersionsByFunctionRequest =
      ListVersionsByFunctionRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listVersionsByFunctionResponse(
      nextMarker: Option[String] = None,
      versions: Option[List[FunctionConfiguration]] = None
    ): ListVersionsByFunctionResponse =
      ListVersionsByFunctionResponse
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(versions)(_.versions(_))
        .build

    def onFailure(
      destination: Option[String] = None
    ): OnFailure =
      OnFailure
        .builder
        .ifSome(destination)(_.destination(_))
        .build

    def onSuccess(
      destination: Option[String] = None
    ): OnSuccess =
      OnSuccess
        .builder
        .ifSome(destination)(_.destination(_))
        .build

    def policyLengthExceededException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): PolicyLengthExceededException =
      PolicyLengthExceededException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def preconditionFailedException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): PreconditionFailedException =
      PreconditionFailedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def provisionedConcurrencyConfigListItem(
      functionArn: Option[String] = None,
      requestedProvisionedConcurrentExecutions: Option[Int] = None,
      availableProvisionedConcurrentExecutions: Option[Int] = None,
      allocatedProvisionedConcurrentExecutions: Option[Int] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      lastModified: Option[String] = None
    ): ProvisionedConcurrencyConfigListItem =
      ProvisionedConcurrencyConfigListItem
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(requestedProvisionedConcurrentExecutions)(_.requestedProvisionedConcurrentExecutions(_))
        .ifSome(availableProvisionedConcurrentExecutions)(_.availableProvisionedConcurrentExecutions(_))
        .ifSome(allocatedProvisionedConcurrentExecutions)(_.allocatedProvisionedConcurrentExecutions(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def provisionedConcurrencyConfigNotFoundException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ProvisionedConcurrencyConfigNotFoundException =
      ProvisionedConcurrencyConfigNotFoundException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def publishLayerVersionRequest(
      layerName: Option[String] = None,
      description: Option[String] = None,
      content: Option[LayerVersionContentInput] = None,
      compatibleRuntimes: Option[List[Runtime]] = None,
      licenseInfo: Option[String] = None
    ): PublishLayerVersionRequest =
      PublishLayerVersionRequest
        .builder
        .ifSome(layerName)(_.layerName(_))
        .ifSome(description)(_.description(_))
        .ifSome(content)(_.content(_))
        .ifSome(compatibleRuntimes)(_.compatibleRuntimes(_))
        .ifSome(licenseInfo)(_.licenseInfo(_))
        .build

    def publishLayerVersionResponse(
      content: Option[LayerVersionContentOutput] = None,
      layerArn: Option[String] = None,
      layerVersionArn: Option[String] = None,
      description: Option[String] = None,
      createdDate: Option[String] = None,
      version: Option[LayerVersionNumber] = None,
      compatibleRuntimes: Option[List[Runtime]] = None,
      licenseInfo: Option[String] = None
    ): PublishLayerVersionResponse =
      PublishLayerVersionResponse
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(layerArn)(_.layerArn(_))
        .ifSome(layerVersionArn)(_.layerVersionArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(compatibleRuntimes)(_.compatibleRuntimes(_))
        .ifSome(licenseInfo)(_.licenseInfo(_))
        .build

    def publishVersionRequest(
      functionName: Option[String] = None,
      codeSha256: Option[String] = None,
      description: Option[String] = None,
      revisionId: Option[String] = None
    ): PublishVersionRequest =
      PublishVersionRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(codeSha256)(_.codeSha256(_))
        .ifSome(description)(_.description(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def putFunctionCodeSigningConfigRequest(
      codeSigningConfigArn: Option[String] = None,
      functionName: Option[String] = None
    ): PutFunctionCodeSigningConfigRequest =
      PutFunctionCodeSigningConfigRequest
        .builder
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .ifSome(functionName)(_.functionName(_))
        .build

    def putFunctionCodeSigningConfigResponse(
      codeSigningConfigArn: Option[String] = None,
      functionName: Option[String] = None
    ): PutFunctionCodeSigningConfigResponse =
      PutFunctionCodeSigningConfigResponse
        .builder
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .ifSome(functionName)(_.functionName(_))
        .build

    def putFunctionConcurrencyRequest(
      functionName: Option[String] = None,
      reservedConcurrentExecutions: Option[Int] = None
    ): PutFunctionConcurrencyRequest =
      PutFunctionConcurrencyRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(reservedConcurrentExecutions)(_.reservedConcurrentExecutions(_))
        .build

    def putFunctionEventInvokeConfigRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None,
      maximumRetryAttempts: Option[Int] = None,
      maximumEventAgeInSeconds: Option[Int] = None,
      destinationConfig: Option[DestinationConfig] = None
    ): PutFunctionEventInvokeConfigRequest =
      PutFunctionEventInvokeConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .ifSome(maximumEventAgeInSeconds)(_.maximumEventAgeInSeconds(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .build

    def putProvisionedConcurrencyConfigRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None,
      provisionedConcurrentExecutions: Option[Int] = None
    ): PutProvisionedConcurrencyConfigRequest =
      PutProvisionedConcurrencyConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .ifSome(provisionedConcurrentExecutions)(_.provisionedConcurrentExecutions(_))
        .build

    def putProvisionedConcurrencyConfigResponse(
      requestedProvisionedConcurrentExecutions: Option[Int] = None,
      availableProvisionedConcurrentExecutions: Option[Int] = None,
      allocatedProvisionedConcurrentExecutions: Option[Int] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      lastModified: Option[String] = None
    ): PutProvisionedConcurrencyConfigResponse =
      PutProvisionedConcurrencyConfigResponse
        .builder
        .ifSome(requestedProvisionedConcurrentExecutions)(_.requestedProvisionedConcurrentExecutions(_))
        .ifSome(availableProvisionedConcurrentExecutions)(_.availableProvisionedConcurrentExecutions(_))
        .ifSome(allocatedProvisionedConcurrentExecutions)(_.allocatedProvisionedConcurrentExecutions(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def removeLayerVersionPermissionRequest(
      layerName: Option[String] = None,
      versionNumber: Option[LayerVersionNumber] = None,
      statementId: Option[String] = None,
      revisionId: Option[String] = None
    ): RemoveLayerVersionPermissionRequest =
      RemoveLayerVersionPermissionRequest
        .builder
        .ifSome(layerName)(_.layerName(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def removePermissionRequest(
      functionName: Option[String] = None,
      statementId: Option[String] = None,
      qualifier: Option[String] = None,
      revisionId: Option[String] = None
    ): RemovePermissionRequest =
      RemovePermissionRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(qualifier)(_.qualifier(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def requestTooLargeException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): RequestTooLargeException =
      RequestTooLargeException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceConflictException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ResourceConflictException =
      ResourceConflictException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceInUseException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceNotReadyException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ResourceNotReadyException =
      ResourceNotReadyException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def selfManagedEventSource(
      endpoints: Option[Endpoints] = None
    ): SelfManagedEventSource =
      SelfManagedEventSource
        .builder
        .ifSome(endpoints)(_.endpoints(_))
        .build

    def serviceException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ServiceException =
      ServiceException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def sourceAccessConfiguration(
      `type`: Option[String] = None,
      uRI: Option[String] = None
    ): SourceAccessConfiguration =
      SourceAccessConfiguration
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uRI)(_.uRI(_))
        .build

    def subnetIPAddressLimitReachedException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): SubnetIPAddressLimitReachedException =
      SubnetIPAddressLimitReachedException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      resource: Option[String] = None,
      tags: Option[Tags] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tooManyRequestsException(
      retryAfterSeconds: Option[String] = None,
      `type`: Option[String] = None,
      message: Option[String] = None,
      reason: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def tracingConfig(
      mode: Option[String] = None
    ): TracingConfig =
      TracingConfig
        .builder
        .ifSome(mode)(_.mode(_))
        .build

    def tracingConfigResponse(
      mode: Option[String] = None
    ): TracingConfigResponse =
      TracingConfigResponse
        .builder
        .ifSome(mode)(_.mode(_))
        .build

    def unsupportedMediaTypeException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): UnsupportedMediaTypeException =
      UnsupportedMediaTypeException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resource: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAliasRequest(
      functionName: Option[String] = None,
      name: Option[String] = None,
      functionVersion: Option[String] = None,
      description: Option[String] = None,
      routingConfig: Option[AliasRoutingConfiguration] = None,
      revisionId: Option[String] = None
    ): UpdateAliasRequest =
      UpdateAliasRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(name)(_.name(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(routingConfig)(_.routingConfig(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def updateCodeSigningConfigRequest(
      codeSigningConfigArn: Option[String] = None,
      description: Option[String] = None,
      allowedPublishers: Option[AllowedPublishers] = None,
      codeSigningPolicies: Option[CodeSigningPolicies] = None
    ): UpdateCodeSigningConfigRequest =
      UpdateCodeSigningConfigRequest
        .builder
        .ifSome(codeSigningConfigArn)(_.codeSigningConfigArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(allowedPublishers)(_.allowedPublishers(_))
        .ifSome(codeSigningPolicies)(_.codeSigningPolicies(_))
        .build

    def updateCodeSigningConfigResponse(
      codeSigningConfig: Option[CodeSigningConfig] = None
    ): UpdateCodeSigningConfigResponse =
      UpdateCodeSigningConfigResponse
        .builder
        .ifSome(codeSigningConfig)(_.codeSigningConfig(_))
        .build

    def updateEventSourceMappingRequest(
      uUID: Option[String] = None,
      functionName: Option[String] = None,
      enabled: Option[Boolean] = None,
      batchSize: Option[Int] = None,
      maximumBatchingWindowInSeconds: Option[Int] = None,
      destinationConfig: Option[DestinationConfig] = None,
      maximumRecordAgeInSeconds: Option[Int] = None,
      bisectBatchOnFunctionError: Option[Boolean] = None,
      maximumRetryAttempts: Option[Int] = None,
      parallelizationFactor: Option[Int] = None,
      sourceAccessConfigurations: Option[List[SourceAccessConfiguration]] = None,
      tumblingWindowInSeconds: Option[Int] = None,
      functionResponseTypes: Option[List[FunctionResponseType]] = None
    ): UpdateEventSourceMappingRequest =
      UpdateEventSourceMappingRequest
        .builder
        .ifSome(uUID)(_.uUID(_))
        .ifSome(functionName)(_.functionName(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(batchSize)(_.batchSize(_))
        .ifSome(maximumBatchingWindowInSeconds)(_.maximumBatchingWindowInSeconds(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .ifSome(maximumRecordAgeInSeconds)(_.maximumRecordAgeInSeconds(_))
        .ifSome(bisectBatchOnFunctionError)(_.bisectBatchOnFunctionError(_))
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .ifSome(parallelizationFactor)(_.parallelizationFactor(_))
        .ifSome(sourceAccessConfigurations)(_.sourceAccessConfigurations(_))
        .ifSome(tumblingWindowInSeconds)(_.tumblingWindowInSeconds(_))
        .ifSome(functionResponseTypes)(_.functionResponseTypes(_))
        .build

    def updateFunctionCodeRequest(
      functionName: Option[String] = None,
      zipFile: Option[Blob] = None,
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None,
      s3ObjectVersion: Option[String] = None,
      imageUri: Option[String] = None,
      publish: Option[Boolean] = None,
      revisionId: Option[String] = None
    ): UpdateFunctionCodeRequest =
      UpdateFunctionCodeRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(zipFile)(_.zipFile(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(s3ObjectVersion)(_.s3ObjectVersion(_))
        .ifSome(imageUri)(_.imageUri(_))
        .ifSome(publish)(_.publish(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def updateFunctionConfigurationRequest(
      functionName: Option[String] = None,
      role: Option[String] = None,
      handler: Option[String] = None,
      description: Option[String] = None,
      timeout: Option[Int] = None,
      memorySize: Option[Int] = None,
      vpcConfig: Option[VpcConfig] = None,
      environment: Option[Environment] = None,
      runtime: Option[String] = None,
      deadLetterConfig: Option[DeadLetterConfig] = None,
      kMSKeyArn: Option[String] = None,
      tracingConfig: Option[TracingConfig] = None,
      revisionId: Option[String] = None,
      layers: Option[List[LayerVersionArn]] = None,
      fileSystemConfigs: Option[List[FileSystemConfig]] = None,
      imageConfig: Option[ImageConfig] = None
    ): UpdateFunctionConfigurationRequest =
      UpdateFunctionConfigurationRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(role)(_.role(_))
        .ifSome(handler)(_.handler(_))
        .ifSome(description)(_.description(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(memorySize)(_.memorySize(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(runtime)(_.runtime(_))
        .ifSome(deadLetterConfig)(_.deadLetterConfig(_))
        .ifSome(kMSKeyArn)(_.kMSKeyArn(_))
        .ifSome(tracingConfig)(_.tracingConfig(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(layers)(_.layers(_))
        .ifSome(fileSystemConfigs)(_.fileSystemConfigs(_))
        .ifSome(imageConfig)(_.imageConfig(_))
        .build

    def updateFunctionEventInvokeConfigRequest(
      functionName: Option[String] = None,
      qualifier: Option[String] = None,
      maximumRetryAttempts: Option[Int] = None,
      maximumEventAgeInSeconds: Option[Int] = None,
      destinationConfig: Option[DestinationConfig] = None
    ): UpdateFunctionEventInvokeConfigRequest =
      UpdateFunctionEventInvokeConfigRequest
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(qualifier)(_.qualifier(_))
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .ifSome(maximumEventAgeInSeconds)(_.maximumEventAgeInSeconds(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .build

    def vpcConfig(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): VpcConfig =
      VpcConfig
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def vpcConfigResponse(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      vpcId: Option[String] = None
    ): VpcConfigResponse =
      VpcConfigResponse
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
