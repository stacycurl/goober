package goober.hi

import goober.free.greengrassv2.GreengrassV2IO
import software.amazon.awssdk.services.greengrassv2.model._


object greengrassv2 {
  import goober.free.{greengrassv2 ⇒ free}

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

    def associateClientDeviceWithCoreDeviceEntry(
      thingName: Option[String] = None
    ): AssociateClientDeviceWithCoreDeviceEntry =
      AssociateClientDeviceWithCoreDeviceEntry
        .builder
        .ifSome(thingName)(_.thingName(_))
        .build

    def associateClientDeviceWithCoreDeviceErrorEntry(
      thingName: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): AssociateClientDeviceWithCoreDeviceErrorEntry =
      AssociateClientDeviceWithCoreDeviceErrorEntry
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def associatedClientDevice(
      thingName: Option[String] = None,
      associationTimestamp: Option[Timestamp] = None
    ): AssociatedClientDevice =
      AssociatedClientDevice
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(associationTimestamp)(_.associationTimestamp(_))
        .build

    def batchAssociateClientDeviceWithCoreDeviceRequest(
      entries: Option[List[AssociateClientDeviceWithCoreDeviceEntry]] = None,
      coreDeviceThingName: Option[String] = None
    ): BatchAssociateClientDeviceWithCoreDeviceRequest =
      BatchAssociateClientDeviceWithCoreDeviceRequest
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .build

    def batchAssociateClientDeviceWithCoreDeviceResponse(
      errorEntries: Option[List[AssociateClientDeviceWithCoreDeviceErrorEntry]] = None
    ): BatchAssociateClientDeviceWithCoreDeviceResponse =
      BatchAssociateClientDeviceWithCoreDeviceResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def batchDisassociateClientDeviceFromCoreDeviceRequest(
      entries: Option[List[DisassociateClientDeviceFromCoreDeviceEntry]] = None,
      coreDeviceThingName: Option[String] = None
    ): BatchDisassociateClientDeviceFromCoreDeviceRequest =
      BatchDisassociateClientDeviceFromCoreDeviceRequest
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .build

    def batchDisassociateClientDeviceFromCoreDeviceResponse(
      errorEntries: Option[List[DisassociateClientDeviceFromCoreDeviceErrorEntry]] = None
    ): BatchDisassociateClientDeviceFromCoreDeviceResponse =
      BatchDisassociateClientDeviceFromCoreDeviceResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def cancelDeploymentRequest(
      deploymentId: Option[String] = None
    ): CancelDeploymentRequest =
      CancelDeploymentRequest
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def cancelDeploymentResponse(
      message: Option[String] = None
    ): CancelDeploymentResponse =
      CancelDeploymentResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudComponentStatus(
      componentState: Option[String] = None,
      message: Option[String] = None,
      errors: Option[StringMap] = None
    ): CloudComponentStatus =
      CloudComponentStatus
        .builder
        .ifSome(componentState)(_.componentState(_))
        .ifSome(message)(_.message(_))
        .ifSome(errors)(_.errors(_))
        .build

    def component(
      arn: Option[String] = None,
      componentName: Option[String] = None,
      latestVersion: Option[ComponentLatestVersion] = None
    ): Component =
      Component
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .build

    def componentCandidate(
      componentName: Option[String] = None,
      componentVersion: Option[String] = None,
      versionRequirements: Option[ComponentVersionRequirementMap] = None
    ): ComponentCandidate =
      ComponentCandidate
        .builder
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(versionRequirements)(_.versionRequirements(_))
        .build

    def componentConfigurationUpdate(
      merge: Option[String] = None,
      reset: Option[List[ComponentConfigurationPath]] = None
    ): ComponentConfigurationUpdate =
      ComponentConfigurationUpdate
        .builder
        .ifSome(merge)(_.merge(_))
        .ifSome(reset)(_.reset(_))
        .build

    def componentDependencyRequirement(
      versionRequirement: Option[String] = None,
      dependencyType: Option[String] = None
    ): ComponentDependencyRequirement =
      ComponentDependencyRequirement
        .builder
        .ifSome(versionRequirement)(_.versionRequirement(_))
        .ifSome(dependencyType)(_.dependencyType(_))
        .build

    def componentDeploymentSpecification(
      componentVersion: Option[String] = None,
      configurationUpdate: Option[ComponentConfigurationUpdate] = None,
      runWith: Option[ComponentRunWith] = None
    ): ComponentDeploymentSpecification =
      ComponentDeploymentSpecification
        .builder
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(configurationUpdate)(_.configurationUpdate(_))
        .ifSome(runWith)(_.runWith(_))
        .build

    def componentLatestVersion(
      arn: Option[String] = None,
      componentVersion: Option[String] = None,
      creationTimestamp: Option[Timestamp] = None,
      description: Option[String] = None,
      publisher: Option[String] = None,
      platforms: Option[List[ComponentPlatform]] = None
    ): ComponentLatestVersion =
      ComponentLatestVersion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(description)(_.description(_))
        .ifSome(publisher)(_.publisher(_))
        .ifSome(platforms)(_.platforms(_))
        .build

    def componentPlatform(
      name: Option[String] = None,
      attributes: Option[PlatformAttributesMap] = None
    ): ComponentPlatform =
      ComponentPlatform
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def componentRunWith(
      posixUser: Option[String] = None
    ): ComponentRunWith =
      ComponentRunWith
        .builder
        .ifSome(posixUser)(_.posixUser(_))
        .build

    def componentVersionListItem(
      componentName: Option[String] = None,
      componentVersion: Option[String] = None,
      arn: Option[String] = None
    ): ComponentVersionListItem =
      ComponentVersionListItem
        .builder
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(arn)(_.arn(_))
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

    def coreDevice(
      coreDeviceThingName: Option[String] = None,
      status: Option[String] = None,
      lastStatusUpdateTimestamp: Option[Timestamp] = None
    ): CoreDevice =
      CoreDevice
        .builder
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastStatusUpdateTimestamp)(_.lastStatusUpdateTimestamp(_))
        .build

    def createComponentVersionRequest(
      inlineRecipe: Option[RecipeBlob] = None,
      lambdaFunction: Option[LambdaFunctionRecipeSource] = None,
      tags: Option[TagMap] = None
    ): CreateComponentVersionRequest =
      CreateComponentVersionRequest
        .builder
        .ifSome(inlineRecipe)(_.inlineRecipe(_))
        .ifSome(lambdaFunction)(_.lambdaFunction(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createComponentVersionResponse(
      arn: Option[String] = None,
      componentName: Option[String] = None,
      componentVersion: Option[String] = None,
      creationTimestamp: Option[Timestamp] = None,
      status: Option[CloudComponentStatus] = None
    ): CreateComponentVersionResponse =
      CreateComponentVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(status)(_.status(_))
        .build

    def createDeploymentRequest(
      targetArn: Option[String] = None,
      deploymentName: Option[String] = None,
      components: Option[ComponentDeploymentSpecifications] = None,
      iotJobConfiguration: Option[DeploymentIoTJobConfiguration] = None,
      deploymentPolicies: Option[DeploymentPolicies] = None,
      tags: Option[TagMap] = None
    ): CreateDeploymentRequest =
      CreateDeploymentRequest
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(deploymentName)(_.deploymentName(_))
        .ifSome(components)(_.components(_))
        .ifSome(iotJobConfiguration)(_.iotJobConfiguration(_))
        .ifSome(deploymentPolicies)(_.deploymentPolicies(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeploymentResponse(
      deploymentId: Option[String] = None,
      iotJobId: Option[String] = None,
      iotJobArn: Option[String] = None
    ): CreateDeploymentResponse =
      CreateDeploymentResponse
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(iotJobId)(_.iotJobId(_))
        .ifSome(iotJobArn)(_.iotJobArn(_))
        .build

    def deleteComponentRequest(
      arn: Option[String] = None
    ): DeleteComponentRequest =
      DeleteComponentRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteCoreDeviceRequest(
      coreDeviceThingName: Option[String] = None
    ): DeleteCoreDeviceRequest =
      DeleteCoreDeviceRequest
        .builder
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .build

    def deployment(
      targetArn: Option[String] = None,
      revisionId: Option[String] = None,
      deploymentId: Option[String] = None,
      deploymentName: Option[String] = None,
      creationTimestamp: Option[Timestamp] = None,
      deploymentStatus: Option[String] = None,
      isLatestForTarget: Option[Boolean] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentName)(_.deploymentName(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(isLatestForTarget)(_.isLatestForTarget(_))
        .build

    def deploymentComponentUpdatePolicy(
      timeoutInSeconds: Option[Int] = None,
      action: Option[String] = None
    ): DeploymentComponentUpdatePolicy =
      DeploymentComponentUpdatePolicy
        .builder
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(action)(_.action(_))
        .build

    def deploymentConfigurationValidationPolicy(
      timeoutInSeconds: Option[Int] = None
    ): DeploymentConfigurationValidationPolicy =
      DeploymentConfigurationValidationPolicy
        .builder
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .build

    def deploymentIoTJobConfiguration(
      jobExecutionsRolloutConfig: Option[IoTJobExecutionsRolloutConfig] = None,
      abortConfig: Option[IoTJobAbortConfig] = None,
      timeoutConfig: Option[IoTJobTimeoutConfig] = None
    ): DeploymentIoTJobConfiguration =
      DeploymentIoTJobConfiguration
        .builder
        .ifSome(jobExecutionsRolloutConfig)(_.jobExecutionsRolloutConfig(_))
        .ifSome(abortConfig)(_.abortConfig(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .build

    def deploymentPolicies(
      failureHandlingPolicy: Option[String] = None,
      componentUpdatePolicy: Option[DeploymentComponentUpdatePolicy] = None,
      configurationValidationPolicy: Option[DeploymentConfigurationValidationPolicy] = None
    ): DeploymentPolicies =
      DeploymentPolicies
        .builder
        .ifSome(failureHandlingPolicy)(_.failureHandlingPolicy(_))
        .ifSome(componentUpdatePolicy)(_.componentUpdatePolicy(_))
        .ifSome(configurationValidationPolicy)(_.configurationValidationPolicy(_))
        .build

    def describeComponentRequest(
      arn: Option[String] = None
    ): DescribeComponentRequest =
      DescribeComponentRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def describeComponentResponse(
      arn: Option[String] = None,
      componentName: Option[String] = None,
      componentVersion: Option[String] = None,
      creationTimestamp: Option[Timestamp] = None,
      publisher: Option[String] = None,
      description: Option[String] = None,
      status: Option[CloudComponentStatus] = None,
      platforms: Option[List[ComponentPlatform]] = None,
      tags: Option[TagMap] = None
    ): DescribeComponentResponse =
      DescribeComponentResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(publisher)(_.publisher(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(platforms)(_.platforms(_))
        .ifSome(tags)(_.tags(_))
        .build

    def disassociateClientDeviceFromCoreDeviceEntry(
      thingName: Option[String] = None
    ): DisassociateClientDeviceFromCoreDeviceEntry =
      DisassociateClientDeviceFromCoreDeviceEntry
        .builder
        .ifSome(thingName)(_.thingName(_))
        .build

    def disassociateClientDeviceFromCoreDeviceErrorEntry(
      thingName: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): DisassociateClientDeviceFromCoreDeviceErrorEntry =
      DisassociateClientDeviceFromCoreDeviceErrorEntry
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def effectiveDeployment(
      deploymentId: Option[String] = None,
      deploymentName: Option[String] = None,
      iotJobId: Option[String] = None,
      iotJobArn: Option[String] = None,
      description: Option[String] = None,
      targetArn: Option[String] = None,
      coreDeviceExecutionStatus: Option[String] = None,
      reason: Option[String] = None,
      creationTimestamp: Option[Timestamp] = None,
      modifiedTimestamp: Option[Timestamp] = None
    ): EffectiveDeployment =
      EffectiveDeployment
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentName)(_.deploymentName(_))
        .ifSome(iotJobId)(_.iotJobId(_))
        .ifSome(iotJobArn)(_.iotJobArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(coreDeviceExecutionStatus)(_.coreDeviceExecutionStatus(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(modifiedTimestamp)(_.modifiedTimestamp(_))
        .build

    def getComponentRequest(
      recipeOutputFormat: Option[String] = None,
      arn: Option[String] = None
    ): GetComponentRequest =
      GetComponentRequest
        .builder
        .ifSome(recipeOutputFormat)(_.recipeOutputFormat(_))
        .ifSome(arn)(_.arn(_))
        .build

    def getComponentResponse(
      recipeOutputFormat: Option[String] = None,
      recipe: Option[RecipeBlob] = None,
      tags: Option[TagMap] = None
    ): GetComponentResponse =
      GetComponentResponse
        .builder
        .ifSome(recipeOutputFormat)(_.recipeOutputFormat(_))
        .ifSome(recipe)(_.recipe(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getComponentVersionArtifactRequest(
      arn: Option[String] = None,
      artifactName: Option[String] = None
    ): GetComponentVersionArtifactRequest =
      GetComponentVersionArtifactRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(artifactName)(_.artifactName(_))
        .build

    def getComponentVersionArtifactResponse(
      preSignedUrl: Option[String] = None
    ): GetComponentVersionArtifactResponse =
      GetComponentVersionArtifactResponse
        .builder
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .build

    def getCoreDeviceRequest(
      coreDeviceThingName: Option[String] = None
    ): GetCoreDeviceRequest =
      GetCoreDeviceRequest
        .builder
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .build

    def getCoreDeviceResponse(
      coreDeviceThingName: Option[String] = None,
      coreVersion: Option[String] = None,
      platform: Option[String] = None,
      architecture: Option[String] = None,
      status: Option[String] = None,
      lastStatusUpdateTimestamp: Option[Timestamp] = None,
      tags: Option[TagMap] = None
    ): GetCoreDeviceResponse =
      GetCoreDeviceResponse
        .builder
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .ifSome(coreVersion)(_.coreVersion(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastStatusUpdateTimestamp)(_.lastStatusUpdateTimestamp(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getDeploymentRequest(
      deploymentId: Option[String] = None
    ): GetDeploymentRequest =
      GetDeploymentRequest
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def getDeploymentResponse(
      targetArn: Option[String] = None,
      revisionId: Option[String] = None,
      deploymentId: Option[String] = None,
      deploymentName: Option[String] = None,
      deploymentStatus: Option[String] = None,
      iotJobId: Option[String] = None,
      iotJobArn: Option[String] = None,
      components: Option[ComponentDeploymentSpecifications] = None,
      deploymentPolicies: Option[DeploymentPolicies] = None,
      iotJobConfiguration: Option[DeploymentIoTJobConfiguration] = None,
      creationTimestamp: Option[Timestamp] = None,
      isLatestForTarget: Option[Boolean] = None,
      tags: Option[TagMap] = None
    ): GetDeploymentResponse =
      GetDeploymentResponse
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentName)(_.deploymentName(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(iotJobId)(_.iotJobId(_))
        .ifSome(iotJobArn)(_.iotJobArn(_))
        .ifSome(components)(_.components(_))
        .ifSome(deploymentPolicies)(_.deploymentPolicies(_))
        .ifSome(iotJobConfiguration)(_.iotJobConfiguration(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(isLatestForTarget)(_.isLatestForTarget(_))
        .ifSome(tags)(_.tags(_))
        .build

    def installedComponent(
      componentName: Option[String] = None,
      componentVersion: Option[String] = None,
      lifecycleState: Option[String] = None,
      lifecycleStateDetails: Option[String] = None,
      isRoot: Option[Boolean] = None
    ): InstalledComponent =
      InstalledComponent
        .builder
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(lifecycleState)(_.lifecycleState(_))
        .ifSome(lifecycleStateDetails)(_.lifecycleStateDetails(_))
        .ifSome(isRoot)(_.isRoot(_))
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

    def ioTJobAbortConfig(
      criteriaList: Option[List[IoTJobAbortCriteria]] = None
    ): IoTJobAbortConfig =
      IoTJobAbortConfig
        .builder
        .ifSome(criteriaList)(_.criteriaList(_))
        .build

    def ioTJobAbortCriteria(
      failureType: Option[String] = None,
      action: Option[String] = None,
      thresholdPercentage: Option[IoTJobAbortThresholdPercentage] = None,
      minNumberOfExecutedThings: Option[Int] = None
    ): IoTJobAbortCriteria =
      IoTJobAbortCriteria
        .builder
        .ifSome(failureType)(_.failureType(_))
        .ifSome(action)(_.action(_))
        .ifSome(thresholdPercentage)(_.thresholdPercentage(_))
        .ifSome(minNumberOfExecutedThings)(_.minNumberOfExecutedThings(_))
        .build

    def ioTJobExecutionsRolloutConfig(
      exponentialRate: Option[IoTJobExponentialRolloutRate] = None,
      maximumPerMinute: Option[Int] = None
    ): IoTJobExecutionsRolloutConfig =
      IoTJobExecutionsRolloutConfig
        .builder
        .ifSome(exponentialRate)(_.exponentialRate(_))
        .ifSome(maximumPerMinute)(_.maximumPerMinute(_))
        .build

    def ioTJobExponentialRolloutRate(
      baseRatePerMinute: Option[Int] = None,
      incrementFactor: Option[IoTJobRolloutIncrementFactor] = None,
      rateIncreaseCriteria: Option[IoTJobRateIncreaseCriteria] = None
    ): IoTJobExponentialRolloutRate =
      IoTJobExponentialRolloutRate
        .builder
        .ifSome(baseRatePerMinute)(_.baseRatePerMinute(_))
        .ifSome(incrementFactor)(_.incrementFactor(_))
        .ifSome(rateIncreaseCriteria)(_.rateIncreaseCriteria(_))
        .build

    def ioTJobRateIncreaseCriteria(
      numberOfNotifiedThings: Option[Int] = None,
      numberOfSucceededThings: Option[Int] = None
    ): IoTJobRateIncreaseCriteria =
      IoTJobRateIncreaseCriteria
        .builder
        .ifSome(numberOfNotifiedThings)(_.numberOfNotifiedThings(_))
        .ifSome(numberOfSucceededThings)(_.numberOfSucceededThings(_))
        .build

    def ioTJobTimeoutConfig(
      inProgressTimeoutInMinutes: Option[IoTJobInProgressTimeoutInMinutes] = None
    ): IoTJobTimeoutConfig =
      IoTJobTimeoutConfig
        .builder
        .ifSome(inProgressTimeoutInMinutes)(_.inProgressTimeoutInMinutes(_))
        .build

    def lambdaContainerParams(
      memorySizeInKB: Option[Int] = None,
      mountROSysfs: Option[Boolean] = None,
      volumes: Option[List[LambdaVolumeMount]] = None,
      devices: Option[List[LambdaDeviceMount]] = None
    ): LambdaContainerParams =
      LambdaContainerParams
        .builder
        .ifSome(memorySizeInKB)(_.memorySizeInKB(_))
        .ifSome(mountROSysfs)(_.mountROSysfs(_))
        .ifSome(volumes)(_.volumes(_))
        .ifSome(devices)(_.devices(_))
        .build

    def lambdaDeviceMount(
      path: Option[String] = None,
      permission: Option[String] = None,
      addGroupOwner: Option[Boolean] = None
    ): LambdaDeviceMount =
      LambdaDeviceMount
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(permission)(_.permission(_))
        .ifSome(addGroupOwner)(_.addGroupOwner(_))
        .build

    def lambdaEventSource(
      topic: Option[String] = None,
      `type`: Option[String] = None
    ): LambdaEventSource =
      LambdaEventSource
        .builder
        .ifSome(topic)(_.topic(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def lambdaExecutionParameters(
      eventSources: Option[List[LambdaEventSource]] = None,
      maxQueueSize: Option[Int] = None,
      maxInstancesCount: Option[Int] = None,
      maxIdleTimeInSeconds: Option[Int] = None,
      timeoutInSeconds: Option[Int] = None,
      statusTimeoutInSeconds: Option[Int] = None,
      pinned: Option[Boolean] = None,
      inputPayloadEncodingType: Option[String] = None,
      execArgs: Option[List[LambdaExecArg]] = None,
      environmentVariables: Option[LambdaEnvironmentVariables] = None,
      linuxProcessParams: Option[LambdaLinuxProcessParams] = None
    ): LambdaExecutionParameters =
      LambdaExecutionParameters
        .builder
        .ifSome(eventSources)(_.eventSources(_))
        .ifSome(maxQueueSize)(_.maxQueueSize(_))
        .ifSome(maxInstancesCount)(_.maxInstancesCount(_))
        .ifSome(maxIdleTimeInSeconds)(_.maxIdleTimeInSeconds(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(statusTimeoutInSeconds)(_.statusTimeoutInSeconds(_))
        .ifSome(pinned)(_.pinned(_))
        .ifSome(inputPayloadEncodingType)(_.inputPayloadEncodingType(_))
        .ifSome(execArgs)(_.execArgs(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(linuxProcessParams)(_.linuxProcessParams(_))
        .build

    def lambdaFunctionRecipeSource(
      lambdaArn: Option[String] = None,
      componentName: Option[String] = None,
      componentVersion: Option[String] = None,
      componentPlatforms: Option[List[ComponentPlatform]] = None,
      componentDependencies: Option[ComponentDependencyMap] = None,
      componentLambdaParameters: Option[LambdaExecutionParameters] = None
    ): LambdaFunctionRecipeSource =
      LambdaFunctionRecipeSource
        .builder
        .ifSome(lambdaArn)(_.lambdaArn(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(componentPlatforms)(_.componentPlatforms(_))
        .ifSome(componentDependencies)(_.componentDependencies(_))
        .ifSome(componentLambdaParameters)(_.componentLambdaParameters(_))
        .build

    def lambdaLinuxProcessParams(
      isolationMode: Option[String] = None,
      containerParams: Option[LambdaContainerParams] = None
    ): LambdaLinuxProcessParams =
      LambdaLinuxProcessParams
        .builder
        .ifSome(isolationMode)(_.isolationMode(_))
        .ifSome(containerParams)(_.containerParams(_))
        .build

    def lambdaVolumeMount(
      sourcePath: Option[String] = None,
      destinationPath: Option[String] = None,
      permission: Option[String] = None,
      addGroupOwner: Option[Boolean] = None
    ): LambdaVolumeMount =
      LambdaVolumeMount
        .builder
        .ifSome(sourcePath)(_.sourcePath(_))
        .ifSome(destinationPath)(_.destinationPath(_))
        .ifSome(permission)(_.permission(_))
        .ifSome(addGroupOwner)(_.addGroupOwner(_))
        .build

    def listClientDevicesAssociatedWithCoreDeviceRequest(
      coreDeviceThingName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListClientDevicesAssociatedWithCoreDeviceRequest =
      ListClientDevicesAssociatedWithCoreDeviceRequest
        .builder
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClientDevicesAssociatedWithCoreDeviceResponse(
      associatedClientDevices: Option[List[AssociatedClientDevice]] = None,
      nextToken: Option[String] = None
    ): ListClientDevicesAssociatedWithCoreDeviceResponse =
      ListClientDevicesAssociatedWithCoreDeviceResponse
        .builder
        .ifSome(associatedClientDevices)(_.associatedClientDevices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentVersionsRequest(
      arn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListComponentVersionsRequest =
      ListComponentVersionsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentVersionsResponse(
      componentVersions: Option[List[ComponentVersionListItem]] = None,
      nextToken: Option[String] = None
    ): ListComponentVersionsResponse =
      ListComponentVersionsResponse
        .builder
        .ifSome(componentVersions)(_.componentVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentsRequest(
      scope: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListComponentsRequest =
      ListComponentsRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentsResponse(
      components: Option[List[Component]] = None,
      nextToken: Option[String] = None
    ): ListComponentsResponse =
      ListComponentsResponse
        .builder
        .ifSome(components)(_.components(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCoreDevicesRequest(
      thingGroupArn: Option[String] = None,
      status: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCoreDevicesRequest =
      ListCoreDevicesRequest
        .builder
        .ifSome(thingGroupArn)(_.thingGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCoreDevicesResponse(
      coreDevices: Option[List[CoreDevice]] = None,
      nextToken: Option[String] = None
    ): ListCoreDevicesResponse =
      ListCoreDevicesResponse
        .builder
        .ifSome(coreDevices)(_.coreDevices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentsRequest(
      targetArn: Option[String] = None,
      historyFilter: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDeploymentsRequest =
      ListDeploymentsRequest
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(historyFilter)(_.historyFilter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentsResponse(
      deployments: Option[List[Deployment]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentsResponse =
      ListDeploymentsResponse
        .builder
        .ifSome(deployments)(_.deployments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEffectiveDeploymentsRequest(
      coreDeviceThingName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEffectiveDeploymentsRequest =
      ListEffectiveDeploymentsRequest
        .builder
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEffectiveDeploymentsResponse(
      effectiveDeployments: Option[List[EffectiveDeployment]] = None,
      nextToken: Option[String] = None
    ): ListEffectiveDeploymentsResponse =
      ListEffectiveDeploymentsResponse
        .builder
        .ifSome(effectiveDeployments)(_.effectiveDeployments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInstalledComponentsRequest(
      coreDeviceThingName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInstalledComponentsRequest =
      ListInstalledComponentsRequest
        .builder
        .ifSome(coreDeviceThingName)(_.coreDeviceThingName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInstalledComponentsResponse(
      installedComponents: Option[List[InstalledComponent]] = None,
      nextToken: Option[String] = None
    ): ListInstalledComponentsResponse =
      ListInstalledComponentsResponse
        .builder
        .ifSome(installedComponents)(_.installedComponents(_))
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
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def resolveComponentCandidatesRequest(
      platform: Option[ComponentPlatform] = None,
      componentCandidates: Option[List[ComponentCandidate]] = None
    ): ResolveComponentCandidatesRequest =
      ResolveComponentCandidatesRequest
        .builder
        .ifSome(platform)(_.platform(_))
        .ifSome(componentCandidates)(_.componentCandidates(_))
        .build

    def resolveComponentCandidatesResponse(
      resolvedComponentVersions: Option[List[ResolvedComponentVersion]] = None
    ): ResolveComponentCandidatesResponse =
      ResolveComponentCandidatesResponse
        .builder
        .ifSome(resolvedComponentVersions)(_.resolvedComponentVersions(_))
        .build

    def resolvedComponentVersion(
      arn: Option[String] = None,
      componentName: Option[String] = None,
      componentVersion: Option[String] = None,
      recipe: Option[RecipeBlob] = None
    ): ResolvedComponentVersion =
      ResolvedComponentVersion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(componentName)(_.componentName(_))
        .ifSome(componentVersion)(_.componentVersion(_))
        .ifSome(recipe)(_.recipe(_))
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

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
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

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None,
      fields: Option[List[ValidationExceptionField]] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(fields)(_.fields(_))
        .build

    def validationExceptionField(
      name: Option[String] = None,
      message: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
