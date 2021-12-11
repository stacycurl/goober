package goober.hi

import goober.free.mwaa.MwaaIO
import software.amazon.awssdk.services.mwaa.model._


object mwaa {
  import goober.free.{mwaa ⇒ free}

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

    def createCliTokenRequest(
      name: Option[String] = None
    ): CreateCliTokenRequest =
      CreateCliTokenRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createCliTokenResponse(
      cliToken: Option[String] = None,
      webServerHostname: Option[String] = None
    ): CreateCliTokenResponse =
      CreateCliTokenResponse
        .builder
        .ifSome(cliToken)(_.cliToken(_))
        .ifSome(webServerHostname)(_.webServerHostname(_))
        .build

    def createEnvironmentInput(
      airflowConfigurationOptions: Option[SyntheticCreateEnvironmentInputAirflowConfigurationOptions] = None,
      airflowVersion: Option[String] = None,
      dagS3Path: Option[String] = None,
      environmentClass: Option[String] = None,
      executionRoleArn: Option[String] = None,
      kmsKey: Option[String] = None,
      loggingConfiguration: Option[LoggingConfigurationInput] = None,
      maxWorkers: Option[Int] = None,
      minWorkers: Option[Int] = None,
      name: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      pluginsS3ObjectVersion: Option[String] = None,
      pluginsS3Path: Option[String] = None,
      requirementsS3ObjectVersion: Option[String] = None,
      requirementsS3Path: Option[String] = None,
      schedulers: Option[Int] = None,
      sourceBucketArn: Option[String] = None,
      tags: Option[TagMap] = None,
      webserverAccessMode: Option[String] = None,
      weeklyMaintenanceWindowStart: Option[String] = None
    ): CreateEnvironmentInput =
      CreateEnvironmentInput
        .builder
        .ifSome(airflowConfigurationOptions)(_.airflowConfigurationOptions(_))
        .ifSome(airflowVersion)(_.airflowVersion(_))
        .ifSome(dagS3Path)(_.dagS3Path(_))
        .ifSome(environmentClass)(_.environmentClass(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(kmsKey)(_.kmsKey(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .ifSome(maxWorkers)(_.maxWorkers(_))
        .ifSome(minWorkers)(_.minWorkers(_))
        .ifSome(name)(_.name(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(pluginsS3ObjectVersion)(_.pluginsS3ObjectVersion(_))
        .ifSome(pluginsS3Path)(_.pluginsS3Path(_))
        .ifSome(requirementsS3ObjectVersion)(_.requirementsS3ObjectVersion(_))
        .ifSome(requirementsS3Path)(_.requirementsS3Path(_))
        .ifSome(schedulers)(_.schedulers(_))
        .ifSome(sourceBucketArn)(_.sourceBucketArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(webserverAccessMode)(_.webserverAccessMode(_))
        .ifSome(weeklyMaintenanceWindowStart)(_.weeklyMaintenanceWindowStart(_))
        .build

    def createEnvironmentOutput(
      arn: Option[String] = None
    ): CreateEnvironmentOutput =
      CreateEnvironmentOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def createWebLoginTokenRequest(
      name: Option[String] = None
    ): CreateWebLoginTokenRequest =
      CreateWebLoginTokenRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createWebLoginTokenResponse(
      webServerHostname: Option[String] = None,
      webToken: Option[String] = None
    ): CreateWebLoginTokenResponse =
      CreateWebLoginTokenResponse
        .builder
        .ifSome(webServerHostname)(_.webServerHostname(_))
        .ifSome(webToken)(_.webToken(_))
        .build

    def deleteEnvironmentInput(
      name: Option[String] = None
    ): DeleteEnvironmentInput =
      DeleteEnvironmentInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteEnvironmentOutput(

    ): DeleteEnvironmentOutput =
      DeleteEnvironmentOutput
        .builder

        .build

    def dimension(
      name: Option[String] = None,
      value: Option[String] = None
    ): Dimension =
      Dimension
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def environment(
      airflowConfigurationOptions: Option[AirflowConfigurationOptions] = None,
      airflowVersion: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      dagS3Path: Option[String] = None,
      environmentClass: Option[String] = None,
      executionRoleArn: Option[String] = None,
      kmsKey: Option[String] = None,
      lastUpdate: Option[LastUpdate] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None,
      maxWorkers: Option[Int] = None,
      minWorkers: Option[Int] = None,
      name: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      pluginsS3ObjectVersion: Option[String] = None,
      pluginsS3Path: Option[String] = None,
      requirementsS3ObjectVersion: Option[String] = None,
      requirementsS3Path: Option[String] = None,
      schedulers: Option[Int] = None,
      serviceRoleArn: Option[String] = None,
      sourceBucketArn: Option[String] = None,
      status: Option[String] = None,
      tags: Option[TagMap] = None,
      webserverAccessMode: Option[String] = None,
      webserverUrl: Option[String] = None,
      weeklyMaintenanceWindowStart: Option[String] = None
    ): Environment =
      Environment
        .builder
        .ifSome(airflowConfigurationOptions)(_.airflowConfigurationOptions(_))
        .ifSome(airflowVersion)(_.airflowVersion(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(dagS3Path)(_.dagS3Path(_))
        .ifSome(environmentClass)(_.environmentClass(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(kmsKey)(_.kmsKey(_))
        .ifSome(lastUpdate)(_.lastUpdate(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .ifSome(maxWorkers)(_.maxWorkers(_))
        .ifSome(minWorkers)(_.minWorkers(_))
        .ifSome(name)(_.name(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(pluginsS3ObjectVersion)(_.pluginsS3ObjectVersion(_))
        .ifSome(pluginsS3Path)(_.pluginsS3Path(_))
        .ifSome(requirementsS3ObjectVersion)(_.requirementsS3ObjectVersion(_))
        .ifSome(requirementsS3Path)(_.requirementsS3Path(_))
        .ifSome(schedulers)(_.schedulers(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(sourceBucketArn)(_.sourceBucketArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(webserverAccessMode)(_.webserverAccessMode(_))
        .ifSome(webserverUrl)(_.webserverUrl(_))
        .ifSome(weeklyMaintenanceWindowStart)(_.weeklyMaintenanceWindowStart(_))
        .build

    def getEnvironmentInput(
      name: Option[String] = None
    ): GetEnvironmentInput =
      GetEnvironmentInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getEnvironmentOutput(
      environment: Option[Environment] = None
    ): GetEnvironmentOutput =
      GetEnvironmentOutput
        .builder
        .ifSome(environment)(_.environment(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lastUpdate(
      createdAt: Option[UpdateCreatedAt] = None,
      error: Option[UpdateError] = None,
      status: Option[String] = None
    ): LastUpdate =
      LastUpdate
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(error)(_.error(_))
        .ifSome(status)(_.status(_))
        .build

    def listEnvironmentsInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentsInput =
      ListEnvironmentsInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEnvironmentsOutput(
      environments: Option[List[EnvironmentName]] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentsOutput =
      ListEnvironmentsOutput
        .builder
        .ifSome(environments)(_.environments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[TagMap] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def loggingConfiguration(
      dagProcessingLogs: Option[ModuleLoggingConfiguration] = None,
      schedulerLogs: Option[ModuleLoggingConfiguration] = None,
      taskLogs: Option[ModuleLoggingConfiguration] = None,
      webserverLogs: Option[ModuleLoggingConfiguration] = None,
      workerLogs: Option[ModuleLoggingConfiguration] = None
    ): LoggingConfiguration =
      LoggingConfiguration
        .builder
        .ifSome(dagProcessingLogs)(_.dagProcessingLogs(_))
        .ifSome(schedulerLogs)(_.schedulerLogs(_))
        .ifSome(taskLogs)(_.taskLogs(_))
        .ifSome(webserverLogs)(_.webserverLogs(_))
        .ifSome(workerLogs)(_.workerLogs(_))
        .build

    def loggingConfigurationInput(
      dagProcessingLogs: Option[ModuleLoggingConfigurationInput] = None,
      schedulerLogs: Option[ModuleLoggingConfigurationInput] = None,
      taskLogs: Option[ModuleLoggingConfigurationInput] = None,
      webserverLogs: Option[ModuleLoggingConfigurationInput] = None,
      workerLogs: Option[ModuleLoggingConfigurationInput] = None
    ): LoggingConfigurationInput =
      LoggingConfigurationInput
        .builder
        .ifSome(dagProcessingLogs)(_.dagProcessingLogs(_))
        .ifSome(schedulerLogs)(_.schedulerLogs(_))
        .ifSome(taskLogs)(_.taskLogs(_))
        .ifSome(webserverLogs)(_.webserverLogs(_))
        .ifSome(workerLogs)(_.workerLogs(_))
        .build

    def metricDatum(
      dimensions: Option[List[Dimension]] = None,
      metricName: Option[String] = None,
      statisticValues: Option[StatisticSet] = None,
      timestamp: Option[Timestamp] = None,
      unit: Option[String] = None,
      value: Option[Double] = None
    ): MetricDatum =
      MetricDatum
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(statisticValues)(_.statisticValues(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(value)(_.value(_))
        .build

    def moduleLoggingConfiguration(
      cloudWatchLogGroupArn: Option[String] = None,
      enabled: Option[Boolean] = None,
      logLevel: Option[String] = None
    ): ModuleLoggingConfiguration =
      ModuleLoggingConfiguration
        .builder
        .ifSome(cloudWatchLogGroupArn)(_.cloudWatchLogGroupArn(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def moduleLoggingConfigurationInput(
      enabled: Option[Boolean] = None,
      logLevel: Option[String] = None
    ): ModuleLoggingConfigurationInput =
      ModuleLoggingConfigurationInput
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def networkConfiguration(
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      subnetIds: Option[List[SubnetId]] = None
    ): NetworkConfiguration =
      NetworkConfiguration
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def publishMetricsInput(
      environmentName: Option[String] = None,
      metricData: Option[List[MetricDatum]] = None
    ): PublishMetricsInput =
      PublishMetricsInput
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(metricData)(_.metricData(_))
        .build

    def publishMetricsOutput(

    ): PublishMetricsOutput =
      PublishMetricsOutput
        .builder

        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def statisticSet(
      maximum: Option[Double] = None,
      minimum: Option[Double] = None,
      sampleCount: Option[Int] = None,
      sum: Option[Double] = None
    ): StatisticSet =
      StatisticSet
        .builder
        .ifSome(maximum)(_.maximum(_))
        .ifSome(minimum)(_.minimum(_))
        .ifSome(sampleCount)(_.sampleCount(_))
        .ifSome(sum)(_.sum(_))
        .build

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
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

    def updateEnvironmentInput(
      airflowConfigurationOptions: Option[SyntheticUpdateEnvironmentInputAirflowConfigurationOptions] = None,
      airflowVersion: Option[String] = None,
      dagS3Path: Option[String] = None,
      environmentClass: Option[String] = None,
      executionRoleArn: Option[String] = None,
      loggingConfiguration: Option[LoggingConfigurationInput] = None,
      maxWorkers: Option[Int] = None,
      minWorkers: Option[Int] = None,
      name: Option[String] = None,
      networkConfiguration: Option[UpdateNetworkConfigurationInput] = None,
      pluginsS3ObjectVersion: Option[String] = None,
      pluginsS3Path: Option[String] = None,
      requirementsS3ObjectVersion: Option[String] = None,
      requirementsS3Path: Option[String] = None,
      schedulers: Option[Int] = None,
      sourceBucketArn: Option[String] = None,
      webserverAccessMode: Option[String] = None,
      weeklyMaintenanceWindowStart: Option[String] = None
    ): UpdateEnvironmentInput =
      UpdateEnvironmentInput
        .builder
        .ifSome(airflowConfigurationOptions)(_.airflowConfigurationOptions(_))
        .ifSome(airflowVersion)(_.airflowVersion(_))
        .ifSome(dagS3Path)(_.dagS3Path(_))
        .ifSome(environmentClass)(_.environmentClass(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .ifSome(maxWorkers)(_.maxWorkers(_))
        .ifSome(minWorkers)(_.minWorkers(_))
        .ifSome(name)(_.name(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(pluginsS3ObjectVersion)(_.pluginsS3ObjectVersion(_))
        .ifSome(pluginsS3Path)(_.pluginsS3Path(_))
        .ifSome(requirementsS3ObjectVersion)(_.requirementsS3ObjectVersion(_))
        .ifSome(requirementsS3Path)(_.requirementsS3Path(_))
        .ifSome(schedulers)(_.schedulers(_))
        .ifSome(sourceBucketArn)(_.sourceBucketArn(_))
        .ifSome(webserverAccessMode)(_.webserverAccessMode(_))
        .ifSome(weeklyMaintenanceWindowStart)(_.weeklyMaintenanceWindowStart(_))
        .build

    def updateEnvironmentOutput(
      arn: Option[String] = None
    ): UpdateEnvironmentOutput =
      UpdateEnvironmentOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def updateError(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): UpdateError =
      UpdateError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def updateNetworkConfigurationInput(
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): UpdateNetworkConfigurationInput =
      UpdateNetworkConfigurationInput
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
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
