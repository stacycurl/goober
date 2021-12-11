package goober.hi

import goober.free.codepipeline.CodePipelineIO
import software.amazon.awssdk.services.codepipeline.model._


object codepipeline {
  import goober.free.{codepipeline ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aWSSessionCredentials(
      accessKeyId: Option[String] = None,
      secretAccessKey: Option[String] = None,
      sessionToken: Option[String] = None
    ): AWSSessionCredentials =
      AWSSessionCredentials
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(secretAccessKey)(_.secretAccessKey(_))
        .ifSome(sessionToken)(_.sessionToken(_))
        .build

    def acknowledgeJobInput(
      jobId: Option[String] = None,
      nonce: Option[String] = None
    ): AcknowledgeJobInput =
      AcknowledgeJobInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(nonce)(_.nonce(_))
        .build

    def acknowledgeJobOutput(
      status: Option[String] = None
    ): AcknowledgeJobOutput =
      AcknowledgeJobOutput
        .builder
        .ifSome(status)(_.status(_))
        .build

    def acknowledgeThirdPartyJobInput(
      jobId: Option[String] = None,
      nonce: Option[String] = None,
      clientToken: Option[String] = None
    ): AcknowledgeThirdPartyJobInput =
      AcknowledgeThirdPartyJobInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(nonce)(_.nonce(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def acknowledgeThirdPartyJobOutput(
      status: Option[String] = None
    ): AcknowledgeThirdPartyJobOutput =
      AcknowledgeThirdPartyJobOutput
        .builder
        .ifSome(status)(_.status(_))
        .build

    def actionConfiguration(
      configuration: Option[ActionConfigurationMap] = None
    ): ActionConfiguration =
      ActionConfiguration
        .builder
        .ifSome(configuration)(_.configuration(_))
        .build

    def actionConfigurationProperty(
      name: Option[String] = None,
      required: Option[Boolean] = None,
      key: Option[Boolean] = None,
      secret: Option[Boolean] = None,
      queryable: Option[Boolean] = None,
      description: Option[String] = None,
      `type`: Option[String] = None
    ): ActionConfigurationProperty =
      ActionConfigurationProperty
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(required)(_.required(_))
        .ifSome(key)(_.key(_))
        .ifSome(secret)(_.secret(_))
        .ifSome(queryable)(_.queryable(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def actionContext(
      name: Option[String] = None,
      actionExecutionId: Option[String] = None
    ): ActionContext =
      ActionContext
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(actionExecutionId)(_.actionExecutionId(_))
        .build

    def actionDeclaration(
      name: Option[String] = None,
      actionTypeId: Option[ActionTypeId] = None,
      runOrder: Option[Int] = None,
      configuration: Option[ActionConfigurationMap] = None,
      outputArtifacts: Option[List[OutputArtifact]] = None,
      inputArtifacts: Option[List[InputArtifact]] = None,
      roleArn: Option[String] = None,
      region: Option[String] = None,
      namespace: Option[String] = None
    ): ActionDeclaration =
      ActionDeclaration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(actionTypeId)(_.actionTypeId(_))
        .ifSome(runOrder)(_.runOrder(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(region)(_.region(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def actionExecution(
      actionExecutionId: Option[String] = None,
      status: Option[String] = None,
      summary: Option[String] = None,
      lastStatusChange: Option[Timestamp] = None,
      token: Option[String] = None,
      lastUpdatedBy: Option[String] = None,
      externalExecutionId: Option[String] = None,
      externalExecutionUrl: Option[String] = None,
      percentComplete: Option[Int] = None,
      errorDetails: Option[ErrorDetails] = None
    ): ActionExecution =
      ActionExecution
        .builder
        .ifSome(actionExecutionId)(_.actionExecutionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(lastStatusChange)(_.lastStatusChange(_))
        .ifSome(token)(_.token(_))
        .ifSome(lastUpdatedBy)(_.lastUpdatedBy(_))
        .ifSome(externalExecutionId)(_.externalExecutionId(_))
        .ifSome(externalExecutionUrl)(_.externalExecutionUrl(_))
        .ifSome(percentComplete)(_.percentComplete(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .build

    def actionExecutionDetail(
      pipelineExecutionId: Option[String] = None,
      actionExecutionId: Option[String] = None,
      pipelineVersion: Option[Int] = None,
      stageName: Option[String] = None,
      actionName: Option[String] = None,
      startTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      status: Option[String] = None,
      input: Option[ActionExecutionInput] = None,
      output: Option[ActionExecutionOutput] = None
    ): ActionExecutionDetail =
      ActionExecutionDetail
        .builder
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .ifSome(actionExecutionId)(_.actionExecutionId(_))
        .ifSome(pipelineVersion)(_.pipelineVersion(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(actionName)(_.actionName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(input)(_.input(_))
        .ifSome(output)(_.output(_))
        .build

    def actionExecutionFilter(
      pipelineExecutionId: Option[String] = None
    ): ActionExecutionFilter =
      ActionExecutionFilter
        .builder
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .build

    def actionExecutionInput(
      actionTypeId: Option[ActionTypeId] = None,
      configuration: Option[ActionConfigurationMap] = None,
      resolvedConfiguration: Option[ResolvedActionConfigurationMap] = None,
      roleArn: Option[String] = None,
      region: Option[String] = None,
      inputArtifacts: Option[List[ArtifactDetail]] = None,
      namespace: Option[String] = None
    ): ActionExecutionInput =
      ActionExecutionInput
        .builder
        .ifSome(actionTypeId)(_.actionTypeId(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(resolvedConfiguration)(_.resolvedConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(region)(_.region(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def actionExecutionOutput(
      outputArtifacts: Option[List[ArtifactDetail]] = None,
      executionResult: Option[ActionExecutionResult] = None,
      outputVariables: Option[OutputVariablesMap] = None
    ): ActionExecutionOutput =
      ActionExecutionOutput
        .builder
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(executionResult)(_.executionResult(_))
        .ifSome(outputVariables)(_.outputVariables(_))
        .build

    def actionNotFoundException(

    ): ActionNotFoundException =
      ActionNotFoundException
        .builder

        .build

    def actionRevision(
      revisionId: Option[String] = None,
      revisionChangeId: Option[String] = None,
      created: Option[Timestamp] = None
    ): ActionRevision =
      ActionRevision
        .builder
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(revisionChangeId)(_.revisionChangeId(_))
        .ifSome(created)(_.created(_))
        .build

    def actionState(
      actionName: Option[String] = None,
      currentRevision: Option[ActionRevision] = None,
      latestExecution: Option[ActionExecution] = None,
      entityUrl: Option[String] = None,
      revisionUrl: Option[String] = None
    ): ActionState =
      ActionState
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(currentRevision)(_.currentRevision(_))
        .ifSome(latestExecution)(_.latestExecution(_))
        .ifSome(entityUrl)(_.entityUrl(_))
        .ifSome(revisionUrl)(_.revisionUrl(_))
        .build

    def actionType(
      id: Option[ActionTypeId] = None,
      settings: Option[ActionTypeSettings] = None,
      actionConfigurationProperties: Option[List[ActionConfigurationProperty]] = None,
      inputArtifactDetails: Option[ArtifactDetails] = None,
      outputArtifactDetails: Option[ArtifactDetails] = None
    ): ActionType =
      ActionType
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(actionConfigurationProperties)(_.actionConfigurationProperties(_))
        .ifSome(inputArtifactDetails)(_.inputArtifactDetails(_))
        .ifSome(outputArtifactDetails)(_.outputArtifactDetails(_))
        .build

    def actionTypeAlreadyExistsException(

    ): ActionTypeAlreadyExistsException =
      ActionTypeAlreadyExistsException
        .builder

        .build

    def actionTypeArtifactDetails(
      minimumCount: Option[Int] = None,
      maximumCount: Option[Int] = None
    ): ActionTypeArtifactDetails =
      ActionTypeArtifactDetails
        .builder
        .ifSome(minimumCount)(_.minimumCount(_))
        .ifSome(maximumCount)(_.maximumCount(_))
        .build

    def actionTypeDeclaration(
      description: Option[String] = None,
      executor: Option[ActionTypeExecutor] = None,
      id: Option[ActionTypeIdentifier] = None,
      inputArtifactDetails: Option[ActionTypeArtifactDetails] = None,
      outputArtifactDetails: Option[ActionTypeArtifactDetails] = None,
      permissions: Option[ActionTypePermissions] = None,
      properties: Option[List[ActionTypeProperty]] = None,
      urls: Option[ActionTypeUrls] = None
    ): ActionTypeDeclaration =
      ActionTypeDeclaration
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(executor)(_.executor(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputArtifactDetails)(_.inputArtifactDetails(_))
        .ifSome(outputArtifactDetails)(_.outputArtifactDetails(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(urls)(_.urls(_))
        .build

    def actionTypeExecutor(
      configuration: Option[ExecutorConfiguration] = None,
      `type`: Option[String] = None,
      policyStatementsTemplate: Option[String] = None,
      jobTimeout: Option[Int] = None
    ): ActionTypeExecutor =
      ActionTypeExecutor
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(policyStatementsTemplate)(_.policyStatementsTemplate(_))
        .ifSome(jobTimeout)(_.jobTimeout(_))
        .build

    def actionTypeId(
      category: Option[String] = None,
      owner: Option[String] = None,
      provider: Option[String] = None,
      version: Option[String] = None
    ): ActionTypeId =
      ActionTypeId
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(version)(_.version(_))
        .build

    def actionTypeIdentifier(
      category: Option[String] = None,
      owner: Option[String] = None,
      provider: Option[String] = None,
      version: Option[String] = None
    ): ActionTypeIdentifier =
      ActionTypeIdentifier
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(version)(_.version(_))
        .build

    def actionTypeNotFoundException(

    ): ActionTypeNotFoundException =
      ActionTypeNotFoundException
        .builder

        .build

    def actionTypePermissions(
      allowedAccounts: Option[List[AllowedAccount]] = None
    ): ActionTypePermissions =
      ActionTypePermissions
        .builder
        .ifSome(allowedAccounts)(_.allowedAccounts(_))
        .build

    def actionTypeProperty(
      name: Option[String] = None,
      optional: Option[Boolean] = None,
      key: Option[Boolean] = None,
      noEcho: Option[Boolean] = None,
      queryable: Option[Boolean] = None,
      description: Option[String] = None
    ): ActionTypeProperty =
      ActionTypeProperty
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(optional)(_.optional(_))
        .ifSome(key)(_.key(_))
        .ifSome(noEcho)(_.noEcho(_))
        .ifSome(queryable)(_.queryable(_))
        .ifSome(description)(_.description(_))
        .build

    def actionTypeSettings(
      thirdPartyConfigurationUrl: Option[String] = None,
      entityUrlTemplate: Option[String] = None,
      executionUrlTemplate: Option[String] = None,
      revisionUrlTemplate: Option[String] = None
    ): ActionTypeSettings =
      ActionTypeSettings
        .builder
        .ifSome(thirdPartyConfigurationUrl)(_.thirdPartyConfigurationUrl(_))
        .ifSome(entityUrlTemplate)(_.entityUrlTemplate(_))
        .ifSome(executionUrlTemplate)(_.executionUrlTemplate(_))
        .ifSome(revisionUrlTemplate)(_.revisionUrlTemplate(_))
        .build

    def actionTypeUrls(
      configurationUrl: Option[String] = None,
      entityUrlTemplate: Option[String] = None,
      executionUrlTemplate: Option[String] = None,
      revisionUrlTemplate: Option[String] = None
    ): ActionTypeUrls =
      ActionTypeUrls
        .builder
        .ifSome(configurationUrl)(_.configurationUrl(_))
        .ifSome(entityUrlTemplate)(_.entityUrlTemplate(_))
        .ifSome(executionUrlTemplate)(_.executionUrlTemplate(_))
        .ifSome(revisionUrlTemplate)(_.revisionUrlTemplate(_))
        .build

    def approvalAlreadyCompletedException(

    ): ApprovalAlreadyCompletedException =
      ApprovalAlreadyCompletedException
        .builder

        .build

    def artifact(
      name: Option[String] = None,
      revision: Option[String] = None,
      location: Option[ArtifactLocation] = None
    ): Artifact =
      Artifact
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(location)(_.location(_))
        .build

    def artifactDetail(
      name: Option[String] = None,
      s3location: Option[S3Location] = None
    ): ArtifactDetail =
      ArtifactDetail
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3location)(_.s3location(_))
        .build

    def artifactDetails(
      minimumCount: Option[Int] = None,
      maximumCount: Option[Int] = None
    ): ArtifactDetails =
      ArtifactDetails
        .builder
        .ifSome(minimumCount)(_.minimumCount(_))
        .ifSome(maximumCount)(_.maximumCount(_))
        .build

    def artifactLocation(
      `type`: Option[String] = None,
      s3Location: Option[S3ArtifactLocation] = None
    ): ArtifactLocation =
      ArtifactLocation
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def artifactRevision(
      name: Option[String] = None,
      revisionId: Option[String] = None,
      revisionChangeIdentifier: Option[String] = None,
      revisionSummary: Option[String] = None,
      created: Option[Timestamp] = None,
      revisionUrl: Option[String] = None
    ): ArtifactRevision =
      ArtifactRevision
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(revisionChangeIdentifier)(_.revisionChangeIdentifier(_))
        .ifSome(revisionSummary)(_.revisionSummary(_))
        .ifSome(created)(_.created(_))
        .ifSome(revisionUrl)(_.revisionUrl(_))
        .build

    def artifactStore(
      `type`: Option[String] = None,
      location: Option[String] = None,
      encryptionKey: Option[EncryptionKey] = None
    ): ArtifactStore =
      ArtifactStore
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(location)(_.location(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .build

    def blockerDeclaration(
      name: Option[String] = None,
      `type`: Option[String] = None
    ): BlockerDeclaration =
      BlockerDeclaration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
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

    def createCustomActionTypeInput(
      category: Option[String] = None,
      provider: Option[String] = None,
      version: Option[String] = None,
      settings: Option[ActionTypeSettings] = None,
      configurationProperties: Option[List[ActionConfigurationProperty]] = None,
      inputArtifactDetails: Option[ArtifactDetails] = None,
      outputArtifactDetails: Option[ArtifactDetails] = None,
      tags: Option[List[Tag]] = None
    ): CreateCustomActionTypeInput =
      CreateCustomActionTypeInput
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(version)(_.version(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(configurationProperties)(_.configurationProperties(_))
        .ifSome(inputArtifactDetails)(_.inputArtifactDetails(_))
        .ifSome(outputArtifactDetails)(_.outputArtifactDetails(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCustomActionTypeOutput(
      actionType: Option[ActionType] = None,
      tags: Option[List[Tag]] = None
    ): CreateCustomActionTypeOutput =
      CreateCustomActionTypeOutput
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPipelineInput(
      pipeline: Option[PipelineDeclaration] = None,
      tags: Option[List[Tag]] = None
    ): CreatePipelineInput =
      CreatePipelineInput
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPipelineOutput(
      pipeline: Option[PipelineDeclaration] = None,
      tags: Option[List[Tag]] = None
    ): CreatePipelineOutput =
      CreatePipelineOutput
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(tags)(_.tags(_))
        .build

    def currentRevision(
      revision: Option[String] = None,
      changeIdentifier: Option[String] = None,
      created: Option[Time] = None,
      revisionSummary: Option[String] = None
    ): CurrentRevision =
      CurrentRevision
        .builder
        .ifSome(revision)(_.revision(_))
        .ifSome(changeIdentifier)(_.changeIdentifier(_))
        .ifSome(created)(_.created(_))
        .ifSome(revisionSummary)(_.revisionSummary(_))
        .build

    def deleteCustomActionTypeInput(
      category: Option[String] = None,
      provider: Option[String] = None,
      version: Option[String] = None
    ): DeleteCustomActionTypeInput =
      DeleteCustomActionTypeInput
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(version)(_.version(_))
        .build

    def deletePipelineInput(
      name: Option[String] = None
    ): DeletePipelineInput =
      DeletePipelineInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteWebhookInput(
      name: Option[String] = None
    ): DeleteWebhookInput =
      DeleteWebhookInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteWebhookOutput(

    ): DeleteWebhookOutput =
      DeleteWebhookOutput
        .builder

        .build

    def deregisterWebhookWithThirdPartyInput(
      webhookName: Option[String] = None
    ): DeregisterWebhookWithThirdPartyInput =
      DeregisterWebhookWithThirdPartyInput
        .builder
        .ifSome(webhookName)(_.webhookName(_))
        .build

    def deregisterWebhookWithThirdPartyOutput(

    ): DeregisterWebhookWithThirdPartyOutput =
      DeregisterWebhookWithThirdPartyOutput
        .builder

        .build

    def disableStageTransitionInput(
      pipelineName: Option[String] = None,
      stageName: Option[String] = None,
      transitionType: Option[String] = None,
      reason: Option[String] = None
    ): DisableStageTransitionInput =
      DisableStageTransitionInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(transitionType)(_.transitionType(_))
        .ifSome(reason)(_.reason(_))
        .build

    def duplicatedStopRequestException(
      message: Option[String] = None
    ): DuplicatedStopRequestException =
      DuplicatedStopRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def enableStageTransitionInput(
      pipelineName: Option[String] = None,
      stageName: Option[String] = None,
      transitionType: Option[String] = None
    ): EnableStageTransitionInput =
      EnableStageTransitionInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(transitionType)(_.transitionType(_))
        .build

    def encryptionKey(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): EncryptionKey =
      EncryptionKey
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def errorDetails(
      code: Option[String] = None,
      message: Option[String] = None
    ): ErrorDetails =
      ErrorDetails
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def executionDetails(
      summary: Option[String] = None,
      externalExecutionId: Option[String] = None,
      percentComplete: Option[Int] = None
    ): ExecutionDetails =
      ExecutionDetails
        .builder
        .ifSome(summary)(_.summary(_))
        .ifSome(externalExecutionId)(_.externalExecutionId(_))
        .ifSome(percentComplete)(_.percentComplete(_))
        .build

    def executionTrigger(
      triggerType: Option[String] = None,
      triggerDetail: Option[String] = None
    ): ExecutionTrigger =
      ExecutionTrigger
        .builder
        .ifSome(triggerType)(_.triggerType(_))
        .ifSome(triggerDetail)(_.triggerDetail(_))
        .build

    def executorConfiguration(
      lambdaExecutorConfiguration: Option[LambdaExecutorConfiguration] = None,
      jobWorkerExecutorConfiguration: Option[JobWorkerExecutorConfiguration] = None
    ): ExecutorConfiguration =
      ExecutorConfiguration
        .builder
        .ifSome(lambdaExecutorConfiguration)(_.lambdaExecutorConfiguration(_))
        .ifSome(jobWorkerExecutorConfiguration)(_.jobWorkerExecutorConfiguration(_))
        .build

    def failureDetails(
      `type`: Option[String] = None,
      message: Option[String] = None,
      externalExecutionId: Option[String] = None
    ): FailureDetails =
      FailureDetails
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .ifSome(externalExecutionId)(_.externalExecutionId(_))
        .build

    def getActionTypeInput(
      category: Option[String] = None,
      owner: Option[String] = None,
      provider: Option[String] = None,
      version: Option[String] = None
    ): GetActionTypeInput =
      GetActionTypeInput
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(version)(_.version(_))
        .build

    def getActionTypeOutput(
      actionType: Option[ActionTypeDeclaration] = None
    ): GetActionTypeOutput =
      GetActionTypeOutput
        .builder
        .ifSome(actionType)(_.actionType(_))
        .build

    def getJobDetailsInput(
      jobId: Option[String] = None
    ): GetJobDetailsInput =
      GetJobDetailsInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def getJobDetailsOutput(
      jobDetails: Option[JobDetails] = None
    ): GetJobDetailsOutput =
      GetJobDetailsOutput
        .builder
        .ifSome(jobDetails)(_.jobDetails(_))
        .build

    def getPipelineExecutionInput(
      pipelineName: Option[String] = None,
      pipelineExecutionId: Option[String] = None
    ): GetPipelineExecutionInput =
      GetPipelineExecutionInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .build

    def getPipelineExecutionOutput(
      pipelineExecution: Option[PipelineExecution] = None
    ): GetPipelineExecutionOutput =
      GetPipelineExecutionOutput
        .builder
        .ifSome(pipelineExecution)(_.pipelineExecution(_))
        .build

    def getPipelineInput(
      name: Option[String] = None,
      version: Option[Int] = None
    ): GetPipelineInput =
      GetPipelineInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def getPipelineOutput(
      pipeline: Option[PipelineDeclaration] = None,
      metadata: Option[PipelineMetadata] = None
    ): GetPipelineOutput =
      GetPipelineOutput
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def getPipelineStateInput(
      name: Option[String] = None
    ): GetPipelineStateInput =
      GetPipelineStateInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getPipelineStateOutput(
      pipelineName: Option[String] = None,
      pipelineVersion: Option[Int] = None,
      stageStates: Option[List[StageState]] = None,
      created: Option[Timestamp] = None,
      updated: Option[Timestamp] = None
    ): GetPipelineStateOutput =
      GetPipelineStateOutput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineVersion)(_.pipelineVersion(_))
        .ifSome(stageStates)(_.stageStates(_))
        .ifSome(created)(_.created(_))
        .ifSome(updated)(_.updated(_))
        .build

    def getThirdPartyJobDetailsInput(
      jobId: Option[String] = None,
      clientToken: Option[String] = None
    ): GetThirdPartyJobDetailsInput =
      GetThirdPartyJobDetailsInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def getThirdPartyJobDetailsOutput(
      jobDetails: Option[ThirdPartyJobDetails] = None
    ): GetThirdPartyJobDetailsOutput =
      GetThirdPartyJobDetailsOutput
        .builder
        .ifSome(jobDetails)(_.jobDetails(_))
        .build

    def inputArtifact(
      name: Option[String] = None
    ): InputArtifact =
      InputArtifact
        .builder
        .ifSome(name)(_.name(_))
        .build

    def invalidActionDeclarationException(

    ): InvalidActionDeclarationException =
      InvalidActionDeclarationException
        .builder

        .build

    def invalidApprovalTokenException(

    ): InvalidApprovalTokenException =
      InvalidApprovalTokenException
        .builder

        .build

    def invalidArnException(
      message: Option[String] = None
    ): InvalidArnException =
      InvalidArnException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidBlockerDeclarationException(

    ): InvalidBlockerDeclarationException =
      InvalidBlockerDeclarationException
        .builder

        .build

    def invalidClientTokenException(

    ): InvalidClientTokenException =
      InvalidClientTokenException
        .builder

        .build

    def invalidJobException(

    ): InvalidJobException =
      InvalidJobException
        .builder

        .build

    def invalidJobStateException(

    ): InvalidJobStateException =
      InvalidJobStateException
        .builder

        .build

    def invalidNextTokenException(

    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder

        .build

    def invalidNonceException(

    ): InvalidNonceException =
      InvalidNonceException
        .builder

        .build

    def invalidStageDeclarationException(

    ): InvalidStageDeclarationException =
      InvalidStageDeclarationException
        .builder

        .build

    def invalidStructureException(

    ): InvalidStructureException =
      InvalidStructureException
        .builder

        .build

    def invalidTagsException(
      message: Option[String] = None
    ): InvalidTagsException =
      InvalidTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidWebhookAuthenticationParametersException(

    ): InvalidWebhookAuthenticationParametersException =
      InvalidWebhookAuthenticationParametersException
        .builder

        .build

    def invalidWebhookFilterPatternException(

    ): InvalidWebhookFilterPatternException =
      InvalidWebhookFilterPatternException
        .builder

        .build

    def job(
      id: Option[String] = None,
      data: Option[JobData] = None,
      nonce: Option[String] = None,
      accountId: Option[String] = None
    ): Job =
      Job
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(data)(_.data(_))
        .ifSome(nonce)(_.nonce(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def jobData(
      actionTypeId: Option[ActionTypeId] = None,
      actionConfiguration: Option[ActionConfiguration] = None,
      pipelineContext: Option[PipelineContext] = None,
      inputArtifacts: Option[List[Artifact]] = None,
      outputArtifacts: Option[List[Artifact]] = None,
      artifactCredentials: Option[AWSSessionCredentials] = None,
      continuationToken: Option[String] = None,
      encryptionKey: Option[EncryptionKey] = None
    ): JobData =
      JobData
        .builder
        .ifSome(actionTypeId)(_.actionTypeId(_))
        .ifSome(actionConfiguration)(_.actionConfiguration(_))
        .ifSome(pipelineContext)(_.pipelineContext(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(artifactCredentials)(_.artifactCredentials(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .build

    def jobDetails(
      id: Option[String] = None,
      data: Option[JobData] = None,
      accountId: Option[String] = None
    ): JobDetails =
      JobDetails
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(data)(_.data(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def jobNotFoundException(

    ): JobNotFoundException =
      JobNotFoundException
        .builder

        .build

    def jobWorkerExecutorConfiguration(
      pollingAccounts: Option[List[AccountId]] = None,
      pollingServicePrincipals: Option[List[ServicePrincipal]] = None
    ): JobWorkerExecutorConfiguration =
      JobWorkerExecutorConfiguration
        .builder
        .ifSome(pollingAccounts)(_.pollingAccounts(_))
        .ifSome(pollingServicePrincipals)(_.pollingServicePrincipals(_))
        .build

    def lambdaExecutorConfiguration(
      lambdaFunctionArn: Option[String] = None
    ): LambdaExecutorConfiguration =
      LambdaExecutorConfiguration
        .builder
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listActionExecutionsInput(
      pipelineName: Option[String] = None,
      filter: Option[ActionExecutionFilter] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListActionExecutionsInput =
      ListActionExecutionsInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listActionExecutionsOutput(
      actionExecutionDetails: Option[List[ActionExecutionDetail]] = None,
      nextToken: Option[String] = None
    ): ListActionExecutionsOutput =
      ListActionExecutionsOutput
        .builder
        .ifSome(actionExecutionDetails)(_.actionExecutionDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listActionTypesInput(
      actionOwnerFilter: Option[String] = None,
      nextToken: Option[String] = None,
      regionFilter: Option[String] = None
    ): ListActionTypesInput =
      ListActionTypesInput
        .builder
        .ifSome(actionOwnerFilter)(_.actionOwnerFilter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(regionFilter)(_.regionFilter(_))
        .build

    def listActionTypesOutput(
      actionTypes: Option[List[ActionType]] = None,
      nextToken: Option[String] = None
    ): ListActionTypesOutput =
      ListActionTypesOutput
        .builder
        .ifSome(actionTypes)(_.actionTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPipelineExecutionsInput(
      pipelineName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPipelineExecutionsInput =
      ListPipelineExecutionsInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPipelineExecutionsOutput(
      pipelineExecutionSummaries: Option[List[PipelineExecutionSummary]] = None,
      nextToken: Option[String] = None
    ): ListPipelineExecutionsOutput =
      ListPipelineExecutionsOutput
        .builder
        .ifSome(pipelineExecutionSummaries)(_.pipelineExecutionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPipelinesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPipelinesInput =
      ListPipelinesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPipelinesOutput(
      pipelines: Option[List[PipelineSummary]] = None,
      nextToken: Option[String] = None
    ): ListPipelinesOutput =
      ListPipelinesOutput
        .builder
        .ifSome(pipelines)(_.pipelines(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWebhookItem(
      definition: Option[WebhookDefinition] = None,
      url: Option[String] = None,
      errorMessage: Option[String] = None,
      errorCode: Option[String] = None,
      lastTriggered: Option[WebhookLastTriggered] = None,
      arn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ListWebhookItem =
      ListWebhookItem
        .builder
        .ifSome(definition)(_.definition(_))
        .ifSome(url)(_.url(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(lastTriggered)(_.lastTriggered(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listWebhooksInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWebhooksInput =
      ListWebhooksInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWebhooksOutput(
      webhooks: Option[List[ListWebhookItem]] = None,
      nextToken: Option[String] = None
    ): ListWebhooksOutput =
      ListWebhooksOutput
        .builder
        .ifSome(webhooks)(_.webhooks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def notLatestPipelineExecutionException(

    ): NotLatestPipelineExecutionException =
      NotLatestPipelineExecutionException
        .builder

        .build

    def outputArtifact(
      name: Option[String] = None
    ): OutputArtifact =
      OutputArtifact
        .builder
        .ifSome(name)(_.name(_))
        .build

    def outputVariablesSizeExceededException(
      message: Option[String] = None
    ): OutputVariablesSizeExceededException =
      OutputVariablesSizeExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pipelineContext(
      pipelineName: Option[String] = None,
      stage: Option[StageContext] = None,
      action: Option[ActionContext] = None,
      pipelineArn: Option[String] = None,
      pipelineExecutionId: Option[String] = None
    ): PipelineContext =
      PipelineContext
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(action)(_.action(_))
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .build

    def pipelineDeclaration(
      name: Option[String] = None,
      roleArn: Option[String] = None,
      artifactStore: Option[ArtifactStore] = None,
      artifactStores: Option[ArtifactStoreMap] = None,
      stages: Option[List[StageDeclaration]] = None,
      version: Option[Int] = None
    ): PipelineDeclaration =
      PipelineDeclaration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(artifactStore)(_.artifactStore(_))
        .ifSome(artifactStores)(_.artifactStores(_))
        .ifSome(stages)(_.stages(_))
        .ifSome(version)(_.version(_))
        .build

    def pipelineExecution(
      pipelineName: Option[String] = None,
      pipelineVersion: Option[Int] = None,
      pipelineExecutionId: Option[String] = None,
      status: Option[String] = None,
      statusSummary: Option[String] = None,
      artifactRevisions: Option[List[ArtifactRevision]] = None
    ): PipelineExecution =
      PipelineExecution
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineVersion)(_.pipelineVersion(_))
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusSummary)(_.statusSummary(_))
        .ifSome(artifactRevisions)(_.artifactRevisions(_))
        .build

    def pipelineExecutionNotFoundException(

    ): PipelineExecutionNotFoundException =
      PipelineExecutionNotFoundException
        .builder

        .build

    def pipelineExecutionNotStoppableException(
      message: Option[String] = None
    ): PipelineExecutionNotStoppableException =
      PipelineExecutionNotStoppableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pipelineExecutionSummary(
      pipelineExecutionId: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      sourceRevisions: Option[List[SourceRevision]] = None,
      trigger: Option[ExecutionTrigger] = None,
      stopTrigger: Option[StopExecutionTrigger] = None
    ): PipelineExecutionSummary =
      PipelineExecutionSummary
        .builder
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(sourceRevisions)(_.sourceRevisions(_))
        .ifSome(trigger)(_.trigger(_))
        .ifSome(stopTrigger)(_.stopTrigger(_))
        .build

    def pipelineMetadata(
      pipelineArn: Option[String] = None,
      created: Option[Timestamp] = None,
      updated: Option[Timestamp] = None
    ): PipelineMetadata =
      PipelineMetadata
        .builder
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .ifSome(created)(_.created(_))
        .ifSome(updated)(_.updated(_))
        .build

    def pipelineNameInUseException(

    ): PipelineNameInUseException =
      PipelineNameInUseException
        .builder

        .build

    def pipelineNotFoundException(

    ): PipelineNotFoundException =
      PipelineNotFoundException
        .builder

        .build

    def pipelineSummary(
      name: Option[String] = None,
      version: Option[Int] = None,
      created: Option[Timestamp] = None,
      updated: Option[Timestamp] = None
    ): PipelineSummary =
      PipelineSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(created)(_.created(_))
        .ifSome(updated)(_.updated(_))
        .build

    def pipelineVersionNotFoundException(

    ): PipelineVersionNotFoundException =
      PipelineVersionNotFoundException
        .builder

        .build

    def pollForJobsInput(
      actionTypeId: Option[ActionTypeId] = None,
      maxBatchSize: Option[Int] = None,
      queryParam: Option[QueryParamMap] = None
    ): PollForJobsInput =
      PollForJobsInput
        .builder
        .ifSome(actionTypeId)(_.actionTypeId(_))
        .ifSome(maxBatchSize)(_.maxBatchSize(_))
        .ifSome(queryParam)(_.queryParam(_))
        .build

    def pollForJobsOutput(
      jobs: Option[List[Job]] = None
    ): PollForJobsOutput =
      PollForJobsOutput
        .builder
        .ifSome(jobs)(_.jobs(_))
        .build

    def pollForThirdPartyJobsInput(
      actionTypeId: Option[ActionTypeId] = None,
      maxBatchSize: Option[Int] = None
    ): PollForThirdPartyJobsInput =
      PollForThirdPartyJobsInput
        .builder
        .ifSome(actionTypeId)(_.actionTypeId(_))
        .ifSome(maxBatchSize)(_.maxBatchSize(_))
        .build

    def pollForThirdPartyJobsOutput(
      jobs: Option[List[ThirdPartyJob]] = None
    ): PollForThirdPartyJobsOutput =
      PollForThirdPartyJobsOutput
        .builder
        .ifSome(jobs)(_.jobs(_))
        .build

    def putActionRevisionInput(
      pipelineName: Option[String] = None,
      stageName: Option[String] = None,
      actionName: Option[String] = None,
      actionRevision: Option[ActionRevision] = None
    ): PutActionRevisionInput =
      PutActionRevisionInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(actionName)(_.actionName(_))
        .ifSome(actionRevision)(_.actionRevision(_))
        .build

    def putActionRevisionOutput(
      newRevision: Option[Boolean] = None,
      pipelineExecutionId: Option[String] = None
    ): PutActionRevisionOutput =
      PutActionRevisionOutput
        .builder
        .ifSome(newRevision)(_.newRevision(_))
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .build

    def putApprovalResultInput(
      pipelineName: Option[String] = None,
      stageName: Option[String] = None,
      actionName: Option[String] = None,
      result: Option[ApprovalResult] = None,
      token: Option[String] = None
    ): PutApprovalResultInput =
      PutApprovalResultInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(actionName)(_.actionName(_))
        .ifSome(result)(_.result(_))
        .ifSome(token)(_.token(_))
        .build

    def putApprovalResultOutput(
      approvedAt: Option[Timestamp] = None
    ): PutApprovalResultOutput =
      PutApprovalResultOutput
        .builder
        .ifSome(approvedAt)(_.approvedAt(_))
        .build

    def putJobFailureResultInput(
      jobId: Option[String] = None,
      failureDetails: Option[FailureDetails] = None
    ): PutJobFailureResultInput =
      PutJobFailureResultInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .build

    def putJobSuccessResultInput(
      jobId: Option[String] = None,
      currentRevision: Option[CurrentRevision] = None,
      continuationToken: Option[String] = None,
      executionDetails: Option[ExecutionDetails] = None,
      outputVariables: Option[OutputVariablesMap] = None
    ): PutJobSuccessResultInput =
      PutJobSuccessResultInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(currentRevision)(_.currentRevision(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(executionDetails)(_.executionDetails(_))
        .ifSome(outputVariables)(_.outputVariables(_))
        .build

    def putThirdPartyJobFailureResultInput(
      jobId: Option[String] = None,
      clientToken: Option[String] = None,
      failureDetails: Option[FailureDetails] = None
    ): PutThirdPartyJobFailureResultInput =
      PutThirdPartyJobFailureResultInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .build

    def putThirdPartyJobSuccessResultInput(
      jobId: Option[String] = None,
      clientToken: Option[String] = None,
      currentRevision: Option[CurrentRevision] = None,
      continuationToken: Option[String] = None,
      executionDetails: Option[ExecutionDetails] = None
    ): PutThirdPartyJobSuccessResultInput =
      PutThirdPartyJobSuccessResultInput
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(currentRevision)(_.currentRevision(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(executionDetails)(_.executionDetails(_))
        .build

    def putWebhookInput(
      webhook: Option[WebhookDefinition] = None,
      tags: Option[List[Tag]] = None
    ): PutWebhookInput =
      PutWebhookInput
        .builder
        .ifSome(webhook)(_.webhook(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putWebhookOutput(
      webhook: Option[ListWebhookItem] = None
    ): PutWebhookOutput =
      PutWebhookOutput
        .builder
        .ifSome(webhook)(_.webhook(_))
        .build

    def registerWebhookWithThirdPartyInput(
      webhookName: Option[String] = None
    ): RegisterWebhookWithThirdPartyInput =
      RegisterWebhookWithThirdPartyInput
        .builder
        .ifSome(webhookName)(_.webhookName(_))
        .build

    def registerWebhookWithThirdPartyOutput(

    ): RegisterWebhookWithThirdPartyOutput =
      RegisterWebhookWithThirdPartyOutput
        .builder

        .build

    def requestFailedException(
      message: Option[String] = None
    ): RequestFailedException =
      RequestFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def retryStageExecutionInput(
      pipelineName: Option[String] = None,
      stageName: Option[String] = None,
      pipelineExecutionId: Option[String] = None,
      retryMode: Option[String] = None
    ): RetryStageExecutionInput =
      RetryStageExecutionInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .ifSome(retryMode)(_.retryMode(_))
        .build

    def retryStageExecutionOutput(
      pipelineExecutionId: Option[String] = None
    ): RetryStageExecutionOutput =
      RetryStageExecutionOutput
        .builder
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .build

    def s3ArtifactLocation(
      bucketName: Option[String] = None,
      objectKey: Option[String] = None
    ): S3ArtifactLocation =
      S3ArtifactLocation
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(objectKey)(_.objectKey(_))
        .build

    def s3Location(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def sourceRevision(
      actionName: Option[String] = None,
      revisionId: Option[String] = None,
      revisionSummary: Option[String] = None,
      revisionUrl: Option[String] = None
    ): SourceRevision =
      SourceRevision
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(revisionSummary)(_.revisionSummary(_))
        .ifSome(revisionUrl)(_.revisionUrl(_))
        .build

    def stageContext(
      name: Option[String] = None
    ): StageContext =
      StageContext
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stageDeclaration(
      name: Option[String] = None,
      blockers: Option[List[BlockerDeclaration]] = None,
      actions: Option[List[ActionDeclaration]] = None
    ): StageDeclaration =
      StageDeclaration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(blockers)(_.blockers(_))
        .ifSome(actions)(_.actions(_))
        .build

    def stageExecution(
      pipelineExecutionId: Option[String] = None,
      status: Option[String] = None
    ): StageExecution =
      StageExecution
        .builder
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .ifSome(status)(_.status(_))
        .build

    def stageNotFoundException(

    ): StageNotFoundException =
      StageNotFoundException
        .builder

        .build

    def stageNotRetryableException(

    ): StageNotRetryableException =
      StageNotRetryableException
        .builder

        .build

    def stageState(
      stageName: Option[String] = None,
      inboundExecution: Option[StageExecution] = None,
      inboundTransitionState: Option[TransitionState] = None,
      actionStates: Option[List[ActionState]] = None,
      latestExecution: Option[StageExecution] = None
    ): StageState =
      StageState
        .builder
        .ifSome(stageName)(_.stageName(_))
        .ifSome(inboundExecution)(_.inboundExecution(_))
        .ifSome(inboundTransitionState)(_.inboundTransitionState(_))
        .ifSome(actionStates)(_.actionStates(_))
        .ifSome(latestExecution)(_.latestExecution(_))
        .build

    def startPipelineExecutionInput(
      name: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): StartPipelineExecutionInput =
      StartPipelineExecutionInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def startPipelineExecutionOutput(
      pipelineExecutionId: Option[String] = None
    ): StartPipelineExecutionOutput =
      StartPipelineExecutionOutput
        .builder
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .build

    def stopExecutionTrigger(
      reason: Option[String] = None
    ): StopExecutionTrigger =
      StopExecutionTrigger
        .builder
        .ifSome(reason)(_.reason(_))
        .build

    def stopPipelineExecutionInput(
      pipelineName: Option[String] = None,
      pipelineExecutionId: Option[String] = None,
      abandon: Option[Boolean] = None,
      reason: Option[String] = None
    ): StopPipelineExecutionInput =
      StopPipelineExecutionInput
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
        .ifSome(abandon)(_.abandon(_))
        .ifSome(reason)(_.reason(_))
        .build

    def stopPipelineExecutionOutput(
      pipelineExecutionId: Option[String] = None
    ): StopPipelineExecutionOutput =
      StopPipelineExecutionOutput
        .builder
        .ifSome(pipelineExecutionId)(_.pipelineExecutionId(_))
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

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def thirdPartyJob(
      clientId: Option[String] = None,
      jobId: Option[String] = None
    ): ThirdPartyJob =
      ThirdPartyJob
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def thirdPartyJobData(
      actionTypeId: Option[ActionTypeId] = None,
      actionConfiguration: Option[ActionConfiguration] = None,
      pipelineContext: Option[PipelineContext] = None,
      inputArtifacts: Option[List[Artifact]] = None,
      outputArtifacts: Option[List[Artifact]] = None,
      artifactCredentials: Option[AWSSessionCredentials] = None,
      continuationToken: Option[String] = None,
      encryptionKey: Option[EncryptionKey] = None
    ): ThirdPartyJobData =
      ThirdPartyJobData
        .builder
        .ifSome(actionTypeId)(_.actionTypeId(_))
        .ifSome(actionConfiguration)(_.actionConfiguration(_))
        .ifSome(pipelineContext)(_.pipelineContext(_))
        .ifSome(inputArtifacts)(_.inputArtifacts(_))
        .ifSome(outputArtifacts)(_.outputArtifacts(_))
        .ifSome(artifactCredentials)(_.artifactCredentials(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .build

    def thirdPartyJobDetails(
      id: Option[String] = None,
      data: Option[ThirdPartyJobData] = None,
      nonce: Option[String] = None
    ): ThirdPartyJobDetails =
      ThirdPartyJobDetails
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(data)(_.data(_))
        .ifSome(nonce)(_.nonce(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transitionState(
      enabled: Option[Boolean] = None,
      lastChangedBy: Option[String] = None,
      lastChangedAt: Option[LastChangedAt] = None,
      disabledReason: Option[String] = None
    ): TransitionState =
      TransitionState
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(lastChangedBy)(_.lastChangedBy(_))
        .ifSome(lastChangedAt)(_.lastChangedAt(_))
        .ifSome(disabledReason)(_.disabledReason(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateActionTypeInput(
      actionType: Option[ActionTypeDeclaration] = None
    ): UpdateActionTypeInput =
      UpdateActionTypeInput
        .builder
        .ifSome(actionType)(_.actionType(_))
        .build

    def updatePipelineInput(
      pipeline: Option[PipelineDeclaration] = None
    ): UpdatePipelineInput =
      UpdatePipelineInput
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .build

    def updatePipelineOutput(
      pipeline: Option[PipelineDeclaration] = None
    ): UpdatePipelineOutput =
      UpdatePipelineOutput
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .build

    def validationException(

    ): ValidationException =
      ValidationException
        .builder

        .build

    def webhookAuthConfiguration(
      allowedIPRange: Option[String] = None,
      secretToken: Option[String] = None
    ): WebhookAuthConfiguration =
      WebhookAuthConfiguration
        .builder
        .ifSome(allowedIPRange)(_.allowedIPRange(_))
        .ifSome(secretToken)(_.secretToken(_))
        .build

    def webhookDefinition(
      name: Option[String] = None,
      targetPipeline: Option[String] = None,
      targetAction: Option[String] = None,
      filters: Option[List[WebhookFilterRule]] = None,
      authentication: Option[String] = None,
      authenticationConfiguration: Option[WebhookAuthConfiguration] = None
    ): WebhookDefinition =
      WebhookDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(targetPipeline)(_.targetPipeline(_))
        .ifSome(targetAction)(_.targetAction(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(authentication)(_.authentication(_))
        .ifSome(authenticationConfiguration)(_.authenticationConfiguration(_))
        .build

    def webhookFilterRule(
      jsonPath: Option[String] = None,
      matchEquals: Option[String] = None
    ): WebhookFilterRule =
      WebhookFilterRule
        .builder
        .ifSome(jsonPath)(_.jsonPath(_))
        .ifSome(matchEquals)(_.matchEquals(_))
        .build

    def webhookNotFoundException(

    ): WebhookNotFoundException =
      WebhookNotFoundException
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
