package goober.hi

import goober.free.appconfig.AppConfigIO
import software.amazon.awssdk.services.appconfig.model._


object appconfig {
  import goober.free.{appconfig ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def application(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): Application =
      Application
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def applications(
      items: Option[List[Application]] = None,
      nextToken: Option[String] = None
    ): Applications =
      Applications
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def configuration(
      content: Option[Blob] = None,
      configurationVersion: Option[String] = None,
      contentType: Option[String] = None
    ): Configuration =
      Configuration
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(configurationVersion)(_.configurationVersion(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def configurationProfile(
      applicationId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      locationUri: Option[String] = None,
      retrievalRoleArn: Option[String] = None,
      validators: Option[List[Validator]] = None
    ): ConfigurationProfile =
      ConfigurationProfile
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(retrievalRoleArn)(_.retrievalRoleArn(_))
        .ifSome(validators)(_.validators(_))
        .build

    def configurationProfileSummary(
      applicationId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      locationUri: Option[String] = None,
      validatorTypes: Option[List[ValidatorType]] = None
    ): ConfigurationProfileSummary =
      ConfigurationProfileSummary
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(validatorTypes)(_.validatorTypes(_))
        .build

    def configurationProfiles(
      items: Option[List[ConfigurationProfileSummary]] = None,
      nextToken: Option[String] = None
    ): ConfigurationProfiles =
      ConfigurationProfiles
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createApplicationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConfigurationProfileRequest(
      applicationId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      locationUri: Option[String] = None,
      retrievalRoleArn: Option[String] = None,
      validators: Option[List[Validator]] = None,
      tags: Option[TagMap] = None
    ): CreateConfigurationProfileRequest =
      CreateConfigurationProfileRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(retrievalRoleArn)(_.retrievalRoleArn(_))
        .ifSome(validators)(_.validators(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeploymentStrategyRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      deploymentDurationInMinutes: Option[Int] = None,
      finalBakeTimeInMinutes: Option[Int] = None,
      growthFactor: Option[GrowthFactor] = None,
      growthType: Option[String] = None,
      replicateTo: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateDeploymentStrategyRequest =
      CreateDeploymentStrategyRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(deploymentDurationInMinutes)(_.deploymentDurationInMinutes(_))
        .ifSome(finalBakeTimeInMinutes)(_.finalBakeTimeInMinutes(_))
        .ifSome(growthFactor)(_.growthFactor(_))
        .ifSome(growthType)(_.growthType(_))
        .ifSome(replicateTo)(_.replicateTo(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEnvironmentRequest(
      applicationId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      monitors: Option[List[Monitor]] = None,
      tags: Option[TagMap] = None
    ): CreateEnvironmentRequest =
      CreateEnvironmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(monitors)(_.monitors(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHostedConfigurationVersionRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      description: Option[String] = None,
      content: Option[Blob] = None,
      contentType: Option[String] = None,
      latestVersionNumber: Option[Int] = None
    ): CreateHostedConfigurationVersionRequest =
      CreateHostedConfigurationVersionRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(description)(_.description(_))
        .ifSome(content)(_.content(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(latestVersionNumber)(_.latestVersionNumber(_))
        .build

    def deleteApplicationRequest(
      applicationId: Option[String] = None
    ): DeleteApplicationRequest =
      DeleteApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteConfigurationProfileRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None
    ): DeleteConfigurationProfileRequest =
      DeleteConfigurationProfileRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .build

    def deleteDeploymentStrategyRequest(
      deploymentStrategyId: Option[String] = None
    ): DeleteDeploymentStrategyRequest =
      DeleteDeploymentStrategyRequest
        .builder
        .ifSome(deploymentStrategyId)(_.deploymentStrategyId(_))
        .build

    def deleteEnvironmentRequest(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None
    ): DeleteEnvironmentRequest =
      DeleteEnvironmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .build

    def deleteHostedConfigurationVersionRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      versionNumber: Option[Int] = None
    ): DeleteHostedConfigurationVersionRequest =
      DeleteHostedConfigurationVersionRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def deployment(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None,
      deploymentStrategyId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      deploymentNumber: Option[Int] = None,
      configurationName: Option[String] = None,
      configurationLocationUri: Option[String] = None,
      configurationVersion: Option[String] = None,
      description: Option[String] = None,
      deploymentDurationInMinutes: Option[Int] = None,
      growthType: Option[String] = None,
      growthFactor: Option[Percentage] = None,
      finalBakeTimeInMinutes: Option[Int] = None,
      state: Option[String] = None,
      eventLog: Option[List[DeploymentEvent]] = None,
      percentageComplete: Option[Percentage] = None,
      startedAt: Option[Iso8601DateTime] = None,
      completedAt: Option[Iso8601DateTime] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(deploymentStrategyId)(_.deploymentStrategyId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(deploymentNumber)(_.deploymentNumber(_))
        .ifSome(configurationName)(_.configurationName(_))
        .ifSome(configurationLocationUri)(_.configurationLocationUri(_))
        .ifSome(configurationVersion)(_.configurationVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(deploymentDurationInMinutes)(_.deploymentDurationInMinutes(_))
        .ifSome(growthType)(_.growthType(_))
        .ifSome(growthFactor)(_.growthFactor(_))
        .ifSome(finalBakeTimeInMinutes)(_.finalBakeTimeInMinutes(_))
        .ifSome(state)(_.state(_))
        .ifSome(eventLog)(_.eventLog(_))
        .ifSome(percentageComplete)(_.percentageComplete(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .build

    def deploymentEvent(
      eventType: Option[String] = None,
      triggeredBy: Option[String] = None,
      description: Option[String] = None,
      occurredAt: Option[Iso8601DateTime] = None
    ): DeploymentEvent =
      DeploymentEvent
        .builder
        .ifSome(eventType)(_.eventType(_))
        .ifSome(triggeredBy)(_.triggeredBy(_))
        .ifSome(description)(_.description(_))
        .ifSome(occurredAt)(_.occurredAt(_))
        .build

    def deploymentStrategies(
      items: Option[List[DeploymentStrategy]] = None,
      nextToken: Option[String] = None
    ): DeploymentStrategies =
      DeploymentStrategies
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def deploymentStrategy(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      deploymentDurationInMinutes: Option[Int] = None,
      growthType: Option[String] = None,
      growthFactor: Option[Percentage] = None,
      finalBakeTimeInMinutes: Option[Int] = None,
      replicateTo: Option[String] = None
    ): DeploymentStrategy =
      DeploymentStrategy
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(deploymentDurationInMinutes)(_.deploymentDurationInMinutes(_))
        .ifSome(growthType)(_.growthType(_))
        .ifSome(growthFactor)(_.growthFactor(_))
        .ifSome(finalBakeTimeInMinutes)(_.finalBakeTimeInMinutes(_))
        .ifSome(replicateTo)(_.replicateTo(_))
        .build

    def deploymentSummary(
      deploymentNumber: Option[Int] = None,
      configurationName: Option[String] = None,
      configurationVersion: Option[String] = None,
      deploymentDurationInMinutes: Option[Int] = None,
      growthType: Option[String] = None,
      growthFactor: Option[Percentage] = None,
      finalBakeTimeInMinutes: Option[Int] = None,
      state: Option[String] = None,
      percentageComplete: Option[Percentage] = None,
      startedAt: Option[Iso8601DateTime] = None,
      completedAt: Option[Iso8601DateTime] = None
    ): DeploymentSummary =
      DeploymentSummary
        .builder
        .ifSome(deploymentNumber)(_.deploymentNumber(_))
        .ifSome(configurationName)(_.configurationName(_))
        .ifSome(configurationVersion)(_.configurationVersion(_))
        .ifSome(deploymentDurationInMinutes)(_.deploymentDurationInMinutes(_))
        .ifSome(growthType)(_.growthType(_))
        .ifSome(growthFactor)(_.growthFactor(_))
        .ifSome(finalBakeTimeInMinutes)(_.finalBakeTimeInMinutes(_))
        .ifSome(state)(_.state(_))
        .ifSome(percentageComplete)(_.percentageComplete(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .build

    def deployments(
      items: Option[List[DeploymentSummary]] = None,
      nextToken: Option[String] = None
    ): Deployments =
      Deployments
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def environment(
      applicationId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      state: Option[String] = None,
      monitors: Option[List[Monitor]] = None
    ): Environment =
      Environment
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(state)(_.state(_))
        .ifSome(monitors)(_.monitors(_))
        .build

    def environments(
      items: Option[List[Environment]] = None,
      nextToken: Option[String] = None
    ): Environments =
      Environments
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getApplicationRequest(
      applicationId: Option[String] = None
    ): GetApplicationRequest =
      GetApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getConfigurationProfileRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None
    ): GetConfigurationProfileRequest =
      GetConfigurationProfileRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .build

    def getConfigurationRequest(
      application: Option[String] = None,
      environment: Option[String] = None,
      configuration: Option[String] = None,
      clientId: Option[String] = None,
      clientConfigurationVersion: Option[String] = None
    ): GetConfigurationRequest =
      GetConfigurationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientConfigurationVersion)(_.clientConfigurationVersion(_))
        .build

    def getDeploymentRequest(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None,
      deploymentNumber: Option[Int] = None
    ): GetDeploymentRequest =
      GetDeploymentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(deploymentNumber)(_.deploymentNumber(_))
        .build

    def getDeploymentStrategyRequest(
      deploymentStrategyId: Option[String] = None
    ): GetDeploymentStrategyRequest =
      GetDeploymentStrategyRequest
        .builder
        .ifSome(deploymentStrategyId)(_.deploymentStrategyId(_))
        .build

    def getEnvironmentRequest(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None
    ): GetEnvironmentRequest =
      GetEnvironmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .build

    def getHostedConfigurationVersionRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      versionNumber: Option[Int] = None
    ): GetHostedConfigurationVersionRequest =
      GetHostedConfigurationVersionRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def hostedConfigurationVersion(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      versionNumber: Option[Int] = None,
      description: Option[String] = None,
      content: Option[Blob] = None,
      contentType: Option[String] = None
    ): HostedConfigurationVersion =
      HostedConfigurationVersion
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(description)(_.description(_))
        .ifSome(content)(_.content(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def hostedConfigurationVersionSummary(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      versionNumber: Option[Int] = None,
      description: Option[String] = None,
      contentType: Option[String] = None
    ): HostedConfigurationVersionSummary =
      HostedConfigurationVersionSummary
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(description)(_.description(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def hostedConfigurationVersions(
      items: Option[List[HostedConfigurationVersionSummary]] = None,
      nextToken: Option[String] = None
    ): HostedConfigurationVersions =
      HostedConfigurationVersions
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApplicationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListApplicationsRequest =
      ListApplicationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationProfilesRequest(
      applicationId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationProfilesRequest =
      ListConfigurationProfilesRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentStrategiesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDeploymentStrategiesRequest =
      ListDeploymentStrategiesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentsRequest(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDeploymentsRequest =
      ListDeploymentsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEnvironmentsRequest(
      applicationId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentsRequest =
      ListEnvironmentsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHostedConfigurationVersionsRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListHostedConfigurationVersionsRequest =
      ListHostedConfigurationVersionsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def monitor(
      alarmArn: Option[String] = None,
      alarmRoleArn: Option[String] = None
    ): Monitor =
      Monitor
        .builder
        .ifSome(alarmArn)(_.alarmArn(_))
        .ifSome(alarmRoleArn)(_.alarmRoleArn(_))
        .build

    def payloadTooLargeException(
      message: Option[String] = None,
      measure: Option[String] = None,
      limit: Option[Float] = None,
      size: Option[Float] = None
    ): PayloadTooLargeException =
      PayloadTooLargeException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(measure)(_.measure(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(size)(_.size(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def resourceTags(
      tags: Option[TagMap] = None
    ): ResourceTags =
      ResourceTags
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startDeploymentRequest(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None,
      deploymentStrategyId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      configurationVersion: Option[String] = None,
      description: Option[String] = None,
      tags: Option[TagMap] = None
    ): StartDeploymentRequest =
      StartDeploymentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(deploymentStrategyId)(_.deploymentStrategyId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(configurationVersion)(_.configurationVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def stopDeploymentRequest(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None,
      deploymentNumber: Option[Int] = None
    ): StopDeploymentRequest =
      StopDeploymentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(deploymentNumber)(_.deploymentNumber(_))
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

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateApplicationRequest(
      applicationId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateConfigurationProfileRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      retrievalRoleArn: Option[String] = None,
      validators: Option[List[Validator]] = None
    ): UpdateConfigurationProfileRequest =
      UpdateConfigurationProfileRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(retrievalRoleArn)(_.retrievalRoleArn(_))
        .ifSome(validators)(_.validators(_))
        .build

    def updateDeploymentStrategyRequest(
      deploymentStrategyId: Option[String] = None,
      description: Option[String] = None,
      deploymentDurationInMinutes: Option[Int] = None,
      finalBakeTimeInMinutes: Option[Int] = None,
      growthFactor: Option[GrowthFactor] = None,
      growthType: Option[String] = None
    ): UpdateDeploymentStrategyRequest =
      UpdateDeploymentStrategyRequest
        .builder
        .ifSome(deploymentStrategyId)(_.deploymentStrategyId(_))
        .ifSome(description)(_.description(_))
        .ifSome(deploymentDurationInMinutes)(_.deploymentDurationInMinutes(_))
        .ifSome(finalBakeTimeInMinutes)(_.finalBakeTimeInMinutes(_))
        .ifSome(growthFactor)(_.growthFactor(_))
        .ifSome(growthType)(_.growthType(_))
        .build

    def updateEnvironmentRequest(
      applicationId: Option[String] = None,
      environmentId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      monitors: Option[List[Monitor]] = None
    ): UpdateEnvironmentRequest =
      UpdateEnvironmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(monitors)(_.monitors(_))
        .build

    def validateConfigurationRequest(
      applicationId: Option[String] = None,
      configurationProfileId: Option[String] = None,
      configurationVersion: Option[String] = None
    ): ValidateConfigurationRequest =
      ValidateConfigurationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationProfileId)(_.configurationProfileId(_))
        .ifSome(configurationVersion)(_.configurationVersion(_))
        .build

    def validator(
      `type`: Option[String] = None,
      content: Option[String] = None
    ): Validator =
      Validator
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(content)(_.content(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
