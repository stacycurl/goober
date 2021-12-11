package goober.hi

import goober.free.sms.SmsIO
import software.amazon.awssdk.services.sms.model._


object sms {
  import goober.free.{sms ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def appSummary(
      appId: Option[String] = None,
      importedAppId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      replicationConfigurationStatus: Option[String] = None,
      replicationStatus: Option[String] = None,
      replicationStatusMessage: Option[String] = None,
      latestReplicationTime: Option[Timestamp] = None,
      launchConfigurationStatus: Option[String] = None,
      launchStatus: Option[String] = None,
      launchStatusMessage: Option[String] = None,
      launchDetails: Option[LaunchDetails] = None,
      creationTime: Option[Timestamp] = None,
      lastModified: Option[Timestamp] = None,
      roleName: Option[String] = None,
      totalServerGroups: Option[Int] = None,
      totalServers: Option[Int] = None
    ): AppSummary =
      AppSummary
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(importedAppId)(_.importedAppId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(replicationConfigurationStatus)(_.replicationConfigurationStatus(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .ifSome(replicationStatusMessage)(_.replicationStatusMessage(_))
        .ifSome(latestReplicationTime)(_.latestReplicationTime(_))
        .ifSome(launchConfigurationStatus)(_.launchConfigurationStatus(_))
        .ifSome(launchStatus)(_.launchStatus(_))
        .ifSome(launchStatusMessage)(_.launchStatusMessage(_))
        .ifSome(launchDetails)(_.launchDetails(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(totalServerGroups)(_.totalServerGroups(_))
        .ifSome(totalServers)(_.totalServers(_))
        .build

    def appValidationConfiguration(
      validationId: Option[String] = None,
      name: Option[String] = None,
      appValidationStrategy: Option[String] = None,
      ssmValidationParameters: Option[SSMValidationParameters] = None
    ): AppValidationConfiguration =
      AppValidationConfiguration
        .builder
        .ifSome(validationId)(_.validationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(appValidationStrategy)(_.appValidationStrategy(_))
        .ifSome(ssmValidationParameters)(_.ssmValidationParameters(_))
        .build

    def appValidationOutput(
      ssmOutput: Option[SSMOutput] = None
    ): AppValidationOutput =
      AppValidationOutput
        .builder
        .ifSome(ssmOutput)(_.ssmOutput(_))
        .build

    def connector(
      connectorId: Option[String] = None,
      version: Option[String] = None,
      status: Option[String] = None,
      capabilityList: Option[List[ConnectorCapability]] = None,
      vmManagerName: Option[String] = None,
      vmManagerType: Option[String] = None,
      vmManagerId: Option[String] = None,
      ipAddress: Option[String] = None,
      macAddress: Option[String] = None,
      associatedOn: Option[Timestamp] = None
    ): Connector =
      Connector
        .builder
        .ifSome(connectorId)(_.connectorId(_))
        .ifSome(version)(_.version(_))
        .ifSome(status)(_.status(_))
        .ifSome(capabilityList)(_.capabilityList(_))
        .ifSome(vmManagerName)(_.vmManagerName(_))
        .ifSome(vmManagerType)(_.vmManagerType(_))
        .ifSome(vmManagerId)(_.vmManagerId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(associatedOn)(_.associatedOn(_))
        .build

    def createAppRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      roleName: Option[String] = None,
      clientToken: Option[String] = None,
      serverGroups: Option[List[ServerGroup]] = None,
      tags: Option[List[Tag]] = None
    ): CreateAppRequest =
      CreateAppRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(serverGroups)(_.serverGroups(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAppResponse(
      appSummary: Option[AppSummary] = None,
      serverGroups: Option[List[ServerGroup]] = None,
      tags: Option[List[Tag]] = None
    ): CreateAppResponse =
      CreateAppResponse
        .builder
        .ifSome(appSummary)(_.appSummary(_))
        .ifSome(serverGroups)(_.serverGroups(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createReplicationJobRequest(
      serverId: Option[String] = None,
      seedReplicationTime: Option[Timestamp] = None,
      frequency: Option[Int] = None,
      runOnce: Option[Boolean] = None,
      licenseType: Option[String] = None,
      roleName: Option[String] = None,
      description: Option[String] = None,
      numberOfRecentAmisToKeep: Option[Int] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None
    ): CreateReplicationJobRequest =
      CreateReplicationJobRequest
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(seedReplicationTime)(_.seedReplicationTime(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(runOnce)(_.runOnce(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(description)(_.description(_))
        .ifSome(numberOfRecentAmisToKeep)(_.numberOfRecentAmisToKeep(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def createReplicationJobResponse(
      replicationJobId: Option[String] = None
    ): CreateReplicationJobResponse =
      CreateReplicationJobResponse
        .builder
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .build

    def deleteAppLaunchConfigurationRequest(
      appId: Option[String] = None
    ): DeleteAppLaunchConfigurationRequest =
      DeleteAppLaunchConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def deleteAppLaunchConfigurationResponse(

    ): DeleteAppLaunchConfigurationResponse =
      DeleteAppLaunchConfigurationResponse
        .builder

        .build

    def deleteAppReplicationConfigurationRequest(
      appId: Option[String] = None
    ): DeleteAppReplicationConfigurationRequest =
      DeleteAppReplicationConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def deleteAppReplicationConfigurationResponse(

    ): DeleteAppReplicationConfigurationResponse =
      DeleteAppReplicationConfigurationResponse
        .builder

        .build

    def deleteAppRequest(
      appId: Option[String] = None,
      forceStopAppReplication: Option[Boolean] = None,
      forceTerminateApp: Option[Boolean] = None
    ): DeleteAppRequest =
      DeleteAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(forceStopAppReplication)(_.forceStopAppReplication(_))
        .ifSome(forceTerminateApp)(_.forceTerminateApp(_))
        .build

    def deleteAppResponse(

    ): DeleteAppResponse =
      DeleteAppResponse
        .builder

        .build

    def deleteAppValidationConfigurationRequest(
      appId: Option[String] = None
    ): DeleteAppValidationConfigurationRequest =
      DeleteAppValidationConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def deleteAppValidationConfigurationResponse(

    ): DeleteAppValidationConfigurationResponse =
      DeleteAppValidationConfigurationResponse
        .builder

        .build

    def deleteReplicationJobRequest(
      replicationJobId: Option[String] = None
    ): DeleteReplicationJobRequest =
      DeleteReplicationJobRequest
        .builder
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .build

    def deleteReplicationJobResponse(

    ): DeleteReplicationJobResponse =
      DeleteReplicationJobResponse
        .builder

        .build

    def deleteServerCatalogRequest(

    ): DeleteServerCatalogRequest =
      DeleteServerCatalogRequest
        .builder

        .build

    def deleteServerCatalogResponse(

    ): DeleteServerCatalogResponse =
      DeleteServerCatalogResponse
        .builder

        .build

    def disassociateConnectorRequest(
      connectorId: Option[String] = None
    ): DisassociateConnectorRequest =
      DisassociateConnectorRequest
        .builder
        .ifSome(connectorId)(_.connectorId(_))
        .build

    def disassociateConnectorResponse(

    ): DisassociateConnectorResponse =
      DisassociateConnectorResponse
        .builder

        .build

    def dryRunOperationException(
      message: Option[String] = None
    ): DryRunOperationException =
      DryRunOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def generateChangeSetRequest(
      appId: Option[String] = None,
      changesetFormat: Option[String] = None
    ): GenerateChangeSetRequest =
      GenerateChangeSetRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(changesetFormat)(_.changesetFormat(_))
        .build

    def generateChangeSetResponse(
      s3Location: Option[S3Location] = None
    ): GenerateChangeSetResponse =
      GenerateChangeSetResponse
        .builder
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def generateTemplateRequest(
      appId: Option[String] = None,
      templateFormat: Option[String] = None
    ): GenerateTemplateRequest =
      GenerateTemplateRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(templateFormat)(_.templateFormat(_))
        .build

    def generateTemplateResponse(
      s3Location: Option[S3Location] = None
    ): GenerateTemplateResponse =
      GenerateTemplateResponse
        .builder
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def getAppLaunchConfigurationRequest(
      appId: Option[String] = None
    ): GetAppLaunchConfigurationRequest =
      GetAppLaunchConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def getAppLaunchConfigurationResponse(
      appId: Option[String] = None,
      roleName: Option[String] = None,
      autoLaunch: Option[Boolean] = None,
      serverGroupLaunchConfigurations: Option[List[ServerGroupLaunchConfiguration]] = None
    ): GetAppLaunchConfigurationResponse =
      GetAppLaunchConfigurationResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(autoLaunch)(_.autoLaunch(_))
        .ifSome(serverGroupLaunchConfigurations)(_.serverGroupLaunchConfigurations(_))
        .build

    def getAppReplicationConfigurationRequest(
      appId: Option[String] = None
    ): GetAppReplicationConfigurationRequest =
      GetAppReplicationConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def getAppReplicationConfigurationResponse(
      serverGroupReplicationConfigurations: Option[List[ServerGroupReplicationConfiguration]] = None
    ): GetAppReplicationConfigurationResponse =
      GetAppReplicationConfigurationResponse
        .builder
        .ifSome(serverGroupReplicationConfigurations)(_.serverGroupReplicationConfigurations(_))
        .build

    def getAppRequest(
      appId: Option[String] = None
    ): GetAppRequest =
      GetAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def getAppResponse(
      appSummary: Option[AppSummary] = None,
      serverGroups: Option[List[ServerGroup]] = None,
      tags: Option[List[Tag]] = None
    ): GetAppResponse =
      GetAppResponse
        .builder
        .ifSome(appSummary)(_.appSummary(_))
        .ifSome(serverGroups)(_.serverGroups(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getAppValidationConfigurationRequest(
      appId: Option[String] = None
    ): GetAppValidationConfigurationRequest =
      GetAppValidationConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def getAppValidationConfigurationResponse(
      appValidationConfigurations: Option[List[AppValidationConfiguration]] = None,
      serverGroupValidationConfigurations: Option[List[ServerGroupValidationConfiguration]] = None
    ): GetAppValidationConfigurationResponse =
      GetAppValidationConfigurationResponse
        .builder
        .ifSome(appValidationConfigurations)(_.appValidationConfigurations(_))
        .ifSome(serverGroupValidationConfigurations)(_.serverGroupValidationConfigurations(_))
        .build

    def getAppValidationOutputRequest(
      appId: Option[String] = None
    ): GetAppValidationOutputRequest =
      GetAppValidationOutputRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def getAppValidationOutputResponse(
      validationOutputList: Option[List[ValidationOutput]] = None
    ): GetAppValidationOutputResponse =
      GetAppValidationOutputResponse
        .builder
        .ifSome(validationOutputList)(_.validationOutputList(_))
        .build

    def getConnectorsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetConnectorsRequest =
      GetConnectorsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getConnectorsResponse(
      connectorList: Option[List[Connector]] = None,
      nextToken: Option[String] = None
    ): GetConnectorsResponse =
      GetConnectorsResponse
        .builder
        .ifSome(connectorList)(_.connectorList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getReplicationJobsRequest(
      replicationJobId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetReplicationJobsRequest =
      GetReplicationJobsRequest
        .builder
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getReplicationJobsResponse(
      replicationJobList: Option[List[ReplicationJob]] = None,
      nextToken: Option[String] = None
    ): GetReplicationJobsResponse =
      GetReplicationJobsResponse
        .builder
        .ifSome(replicationJobList)(_.replicationJobList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getReplicationRunsRequest(
      replicationJobId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetReplicationRunsRequest =
      GetReplicationRunsRequest
        .builder
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getReplicationRunsResponse(
      replicationJob: Option[ReplicationJob] = None,
      replicationRunList: Option[List[ReplicationRun]] = None,
      nextToken: Option[String] = None
    ): GetReplicationRunsResponse =
      GetReplicationRunsResponse
        .builder
        .ifSome(replicationJob)(_.replicationJob(_))
        .ifSome(replicationRunList)(_.replicationRunList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getServersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      vmServerAddressList: Option[List[VmServerAddress]] = None
    ): GetServersRequest =
      GetServersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(vmServerAddressList)(_.vmServerAddressList(_))
        .build

    def getServersResponse(
      lastModifiedOn: Option[Timestamp] = None,
      serverCatalogStatus: Option[String] = None,
      serverList: Option[List[Server]] = None,
      nextToken: Option[String] = None
    ): GetServersResponse =
      GetServersResponse
        .builder
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(serverCatalogStatus)(_.serverCatalogStatus(_))
        .ifSome(serverList)(_.serverList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def importAppCatalogRequest(
      roleName: Option[String] = None
    ): ImportAppCatalogRequest =
      ImportAppCatalogRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .build

    def importAppCatalogResponse(

    ): ImportAppCatalogResponse =
      ImportAppCatalogResponse
        .builder

        .build

    def importServerCatalogRequest(

    ): ImportServerCatalogRequest =
      ImportServerCatalogRequest
        .builder

        .build

    def importServerCatalogResponse(

    ): ImportServerCatalogResponse =
      ImportServerCatalogResponse
        .builder

        .build

    def internalError(
      message: Option[String] = None
    ): InternalError =
      InternalError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def launchAppRequest(
      appId: Option[String] = None
    ): LaunchAppRequest =
      LaunchAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def launchAppResponse(

    ): LaunchAppResponse =
      LaunchAppResponse
        .builder

        .build

    def launchDetails(
      latestLaunchTime: Option[Timestamp] = None,
      stackName: Option[String] = None,
      stackId: Option[String] = None
    ): LaunchDetails =
      LaunchDetails
        .builder
        .ifSome(latestLaunchTime)(_.latestLaunchTime(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def listAppsRequest(
      appIds: Option[List[AppId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAppsRequest =
      ListAppsRequest
        .builder
        .ifSome(appIds)(_.appIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAppsResponse(
      apps: Option[List[AppSummary]] = None,
      nextToken: Option[String] = None
    ): ListAppsResponse =
      ListAppsResponse
        .builder
        .ifSome(apps)(_.apps(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def missingRequiredParameterException(
      message: Option[String] = None
    ): MissingRequiredParameterException =
      MissingRequiredParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noConnectorsAvailableException(
      message: Option[String] = None
    ): NoConnectorsAvailableException =
      NoConnectorsAvailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notificationContext(
      validationId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None
    ): NotificationContext =
      NotificationContext
        .builder
        .ifSome(validationId)(_.validationId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def notifyAppValidationOutputRequest(
      appId: Option[String] = None,
      notificationContext: Option[NotificationContext] = None
    ): NotifyAppValidationOutputRequest =
      NotifyAppValidationOutputRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(notificationContext)(_.notificationContext(_))
        .build

    def notifyAppValidationOutputResponse(

    ): NotifyAppValidationOutputResponse =
      NotifyAppValidationOutputResponse
        .builder

        .build

    def operationNotPermittedException(
      message: Option[String] = None
    ): OperationNotPermittedException =
      OperationNotPermittedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putAppLaunchConfigurationRequest(
      appId: Option[String] = None,
      roleName: Option[String] = None,
      autoLaunch: Option[Boolean] = None,
      serverGroupLaunchConfigurations: Option[List[ServerGroupLaunchConfiguration]] = None
    ): PutAppLaunchConfigurationRequest =
      PutAppLaunchConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(autoLaunch)(_.autoLaunch(_))
        .ifSome(serverGroupLaunchConfigurations)(_.serverGroupLaunchConfigurations(_))
        .build

    def putAppLaunchConfigurationResponse(

    ): PutAppLaunchConfigurationResponse =
      PutAppLaunchConfigurationResponse
        .builder

        .build

    def putAppReplicationConfigurationRequest(
      appId: Option[String] = None,
      serverGroupReplicationConfigurations: Option[List[ServerGroupReplicationConfiguration]] = None
    ): PutAppReplicationConfigurationRequest =
      PutAppReplicationConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(serverGroupReplicationConfigurations)(_.serverGroupReplicationConfigurations(_))
        .build

    def putAppReplicationConfigurationResponse(

    ): PutAppReplicationConfigurationResponse =
      PutAppReplicationConfigurationResponse
        .builder

        .build

    def putAppValidationConfigurationRequest(
      appId: Option[String] = None,
      appValidationConfigurations: Option[List[AppValidationConfiguration]] = None,
      serverGroupValidationConfigurations: Option[List[ServerGroupValidationConfiguration]] = None
    ): PutAppValidationConfigurationRequest =
      PutAppValidationConfigurationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(appValidationConfigurations)(_.appValidationConfigurations(_))
        .ifSome(serverGroupValidationConfigurations)(_.serverGroupValidationConfigurations(_))
        .build

    def putAppValidationConfigurationResponse(

    ): PutAppValidationConfigurationResponse =
      PutAppValidationConfigurationResponse
        .builder

        .build

    def replicationJob(
      replicationJobId: Option[String] = None,
      serverId: Option[String] = None,
      serverType: Option[String] = None,
      vmServer: Option[VmServer] = None,
      seedReplicationTime: Option[Timestamp] = None,
      frequency: Option[Int] = None,
      runOnce: Option[Boolean] = None,
      nextReplicationRunStartTime: Option[Timestamp] = None,
      licenseType: Option[String] = None,
      roleName: Option[String] = None,
      latestAmiId: Option[String] = None,
      state: Option[String] = None,
      statusMessage: Option[String] = None,
      description: Option[String] = None,
      numberOfRecentAmisToKeep: Option[Int] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      replicationRunList: Option[List[ReplicationRun]] = None
    ): ReplicationJob =
      ReplicationJob
        .builder
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .ifSome(serverId)(_.serverId(_))
        .ifSome(serverType)(_.serverType(_))
        .ifSome(vmServer)(_.vmServer(_))
        .ifSome(seedReplicationTime)(_.seedReplicationTime(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(runOnce)(_.runOnce(_))
        .ifSome(nextReplicationRunStartTime)(_.nextReplicationRunStartTime(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(latestAmiId)(_.latestAmiId(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(description)(_.description(_))
        .ifSome(numberOfRecentAmisToKeep)(_.numberOfRecentAmisToKeep(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(replicationRunList)(_.replicationRunList(_))
        .build

    def replicationJobAlreadyExistsException(
      message: Option[String] = None
    ): ReplicationJobAlreadyExistsException =
      ReplicationJobAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def replicationJobNotFoundException(
      message: Option[String] = None
    ): ReplicationJobNotFoundException =
      ReplicationJobNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def replicationRun(
      replicationRunId: Option[String] = None,
      state: Option[String] = None,
      `type`: Option[String] = None,
      stageDetails: Option[ReplicationRunStageDetails] = None,
      statusMessage: Option[String] = None,
      amiId: Option[String] = None,
      scheduledStartTime: Option[Timestamp] = None,
      completedTime: Option[Timestamp] = None,
      description: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None
    ): ReplicationRun =
      ReplicationRun
        .builder
        .ifSome(replicationRunId)(_.replicationRunId(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(stageDetails)(_.stageDetails(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(amiId)(_.amiId(_))
        .ifSome(scheduledStartTime)(_.scheduledStartTime(_))
        .ifSome(completedTime)(_.completedTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def replicationRunLimitExceededException(
      message: Option[String] = None
    ): ReplicationRunLimitExceededException =
      ReplicationRunLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def replicationRunStageDetails(
      stage: Option[String] = None,
      stageProgress: Option[String] = None
    ): ReplicationRunStageDetails =
      ReplicationRunStageDetails
        .builder
        .ifSome(stage)(_.stage(_))
        .ifSome(stageProgress)(_.stageProgress(_))
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

    def sSMOutput(
      s3Location: Option[S3Location] = None
    ): SSMOutput =
      SSMOutput
        .builder
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def sSMValidationParameters(
      source: Option[Source] = None,
      instanceId: Option[String] = None,
      scriptType: Option[String] = None,
      command: Option[String] = None,
      executionTimeoutSeconds: Option[Int] = None,
      outputS3BucketName: Option[String] = None
    ): SSMValidationParameters =
      SSMValidationParameters
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(scriptType)(_.scriptType(_))
        .ifSome(command)(_.command(_))
        .ifSome(executionTimeoutSeconds)(_.executionTimeoutSeconds(_))
        .ifSome(outputS3BucketName)(_.outputS3BucketName(_))
        .build

    def server(
      serverId: Option[String] = None,
      serverType: Option[String] = None,
      vmServer: Option[VmServer] = None,
      replicationJobId: Option[String] = None,
      replicationJobTerminated: Option[Boolean] = None
    ): Server =
      Server
        .builder
        .ifSome(serverId)(_.serverId(_))
        .ifSome(serverType)(_.serverType(_))
        .ifSome(vmServer)(_.vmServer(_))
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .ifSome(replicationJobTerminated)(_.replicationJobTerminated(_))
        .build

    def serverCannotBeReplicatedException(
      message: Option[String] = None
    ): ServerCannotBeReplicatedException =
      ServerCannotBeReplicatedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serverGroup(
      serverGroupId: Option[String] = None,
      name: Option[String] = None,
      serverList: Option[List[Server]] = None
    ): ServerGroup =
      ServerGroup
        .builder
        .ifSome(serverGroupId)(_.serverGroupId(_))
        .ifSome(name)(_.name(_))
        .ifSome(serverList)(_.serverList(_))
        .build

    def serverGroupLaunchConfiguration(
      serverGroupId: Option[String] = None,
      launchOrder: Option[Int] = None,
      serverLaunchConfigurations: Option[List[ServerLaunchConfiguration]] = None
    ): ServerGroupLaunchConfiguration =
      ServerGroupLaunchConfiguration
        .builder
        .ifSome(serverGroupId)(_.serverGroupId(_))
        .ifSome(launchOrder)(_.launchOrder(_))
        .ifSome(serverLaunchConfigurations)(_.serverLaunchConfigurations(_))
        .build

    def serverGroupReplicationConfiguration(
      serverGroupId: Option[String] = None,
      serverReplicationConfigurations: Option[List[ServerReplicationConfiguration]] = None
    ): ServerGroupReplicationConfiguration =
      ServerGroupReplicationConfiguration
        .builder
        .ifSome(serverGroupId)(_.serverGroupId(_))
        .ifSome(serverReplicationConfigurations)(_.serverReplicationConfigurations(_))
        .build

    def serverGroupValidationConfiguration(
      serverGroupId: Option[String] = None,
      serverValidationConfigurations: Option[List[ServerValidationConfiguration]] = None
    ): ServerGroupValidationConfiguration =
      ServerGroupValidationConfiguration
        .builder
        .ifSome(serverGroupId)(_.serverGroupId(_))
        .ifSome(serverValidationConfigurations)(_.serverValidationConfigurations(_))
        .build

    def serverLaunchConfiguration(
      server: Option[Server] = None,
      logicalId: Option[String] = None,
      vpc: Option[String] = None,
      subnet: Option[String] = None,
      securityGroup: Option[String] = None,
      ec2KeyName: Option[String] = None,
      userData: Option[UserData] = None,
      instanceType: Option[String] = None,
      associatePublicIpAddress: Option[Boolean] = None,
      iamInstanceProfileName: Option[String] = None,
      configureScript: Option[S3Location] = None,
      configureScriptType: Option[String] = None
    ): ServerLaunchConfiguration =
      ServerLaunchConfiguration
        .builder
        .ifSome(server)(_.server(_))
        .ifSome(logicalId)(_.logicalId(_))
        .ifSome(vpc)(_.vpc(_))
        .ifSome(subnet)(_.subnet(_))
        .ifSome(securityGroup)(_.securityGroup(_))
        .ifSome(ec2KeyName)(_.ec2KeyName(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(iamInstanceProfileName)(_.iamInstanceProfileName(_))
        .ifSome(configureScript)(_.configureScript(_))
        .ifSome(configureScriptType)(_.configureScriptType(_))
        .build

    def serverReplicationConfiguration(
      server: Option[Server] = None,
      serverReplicationParameters: Option[ServerReplicationParameters] = None
    ): ServerReplicationConfiguration =
      ServerReplicationConfiguration
        .builder
        .ifSome(server)(_.server(_))
        .ifSome(serverReplicationParameters)(_.serverReplicationParameters(_))
        .build

    def serverReplicationParameters(
      seedTime: Option[Timestamp] = None,
      frequency: Option[Int] = None,
      runOnce: Option[Boolean] = None,
      licenseType: Option[String] = None,
      numberOfRecentAmisToKeep: Option[Int] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None
    ): ServerReplicationParameters =
      ServerReplicationParameters
        .builder
        .ifSome(seedTime)(_.seedTime(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(runOnce)(_.runOnce(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(numberOfRecentAmisToKeep)(_.numberOfRecentAmisToKeep(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def serverValidationConfiguration(
      server: Option[Server] = None,
      validationId: Option[String] = None,
      name: Option[String] = None,
      serverValidationStrategy: Option[String] = None,
      userDataValidationParameters: Option[UserDataValidationParameters] = None
    ): ServerValidationConfiguration =
      ServerValidationConfiguration
        .builder
        .ifSome(server)(_.server(_))
        .ifSome(validationId)(_.validationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(serverValidationStrategy)(_.serverValidationStrategy(_))
        .ifSome(userDataValidationParameters)(_.userDataValidationParameters(_))
        .build

    def serverValidationOutput(
      server: Option[Server] = None
    ): ServerValidationOutput =
      ServerValidationOutput
        .builder
        .ifSome(server)(_.server(_))
        .build

    def source(
      s3Location: Option[S3Location] = None
    ): Source =
      Source
        .builder
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def startAppReplicationRequest(
      appId: Option[String] = None
    ): StartAppReplicationRequest =
      StartAppReplicationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def startAppReplicationResponse(

    ): StartAppReplicationResponse =
      StartAppReplicationResponse
        .builder

        .build

    def startOnDemandAppReplicationRequest(
      appId: Option[String] = None,
      description: Option[String] = None
    ): StartOnDemandAppReplicationRequest =
      StartOnDemandAppReplicationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(description)(_.description(_))
        .build

    def startOnDemandAppReplicationResponse(

    ): StartOnDemandAppReplicationResponse =
      StartOnDemandAppReplicationResponse
        .builder

        .build

    def startOnDemandReplicationRunRequest(
      replicationJobId: Option[String] = None,
      description: Option[String] = None
    ): StartOnDemandReplicationRunRequest =
      StartOnDemandReplicationRunRequest
        .builder
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .ifSome(description)(_.description(_))
        .build

    def startOnDemandReplicationRunResponse(
      replicationRunId: Option[String] = None
    ): StartOnDemandReplicationRunResponse =
      StartOnDemandReplicationRunResponse
        .builder
        .ifSome(replicationRunId)(_.replicationRunId(_))
        .build

    def stopAppReplicationRequest(
      appId: Option[String] = None
    ): StopAppReplicationRequest =
      StopAppReplicationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def stopAppReplicationResponse(

    ): StopAppReplicationResponse =
      StopAppReplicationResponse
        .builder

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

    def temporarilyUnavailableException(

    ): TemporarilyUnavailableException =
      TemporarilyUnavailableException
        .builder

        .build

    def terminateAppRequest(
      appId: Option[String] = None
    ): TerminateAppRequest =
      TerminateAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def terminateAppResponse(

    ): TerminateAppResponse =
      TerminateAppResponse
        .builder

        .build

    def unauthorizedOperationException(
      message: Option[String] = None
    ): UnauthorizedOperationException =
      UnauthorizedOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateAppRequest(
      appId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      roleName: Option[String] = None,
      serverGroups: Option[List[ServerGroup]] = None,
      tags: Option[List[Tag]] = None
    ): UpdateAppRequest =
      UpdateAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(serverGroups)(_.serverGroups(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateAppResponse(
      appSummary: Option[AppSummary] = None,
      serverGroups: Option[List[ServerGroup]] = None,
      tags: Option[List[Tag]] = None
    ): UpdateAppResponse =
      UpdateAppResponse
        .builder
        .ifSome(appSummary)(_.appSummary(_))
        .ifSome(serverGroups)(_.serverGroups(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateReplicationJobRequest(
      replicationJobId: Option[String] = None,
      frequency: Option[Int] = None,
      nextReplicationRunStartTime: Option[Timestamp] = None,
      licenseType: Option[String] = None,
      roleName: Option[String] = None,
      description: Option[String] = None,
      numberOfRecentAmisToKeep: Option[Int] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None
    ): UpdateReplicationJobRequest =
      UpdateReplicationJobRequest
        .builder
        .ifSome(replicationJobId)(_.replicationJobId(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(nextReplicationRunStartTime)(_.nextReplicationRunStartTime(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(description)(_.description(_))
        .ifSome(numberOfRecentAmisToKeep)(_.numberOfRecentAmisToKeep(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def updateReplicationJobResponse(

    ): UpdateReplicationJobResponse =
      UpdateReplicationJobResponse
        .builder

        .build

    def userData(
      s3Location: Option[S3Location] = None
    ): UserData =
      UserData
        .builder
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def userDataValidationParameters(
      source: Option[Source] = None,
      scriptType: Option[String] = None
    ): UserDataValidationParameters =
      UserDataValidationParameters
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(scriptType)(_.scriptType(_))
        .build

    def validationOutput(
      validationId: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      latestValidationTime: Option[Timestamp] = None,
      appValidationOutput: Option[AppValidationOutput] = None,
      serverValidationOutput: Option[ServerValidationOutput] = None
    ): ValidationOutput =
      ValidationOutput
        .builder
        .ifSome(validationId)(_.validationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(latestValidationTime)(_.latestValidationTime(_))
        .ifSome(appValidationOutput)(_.appValidationOutput(_))
        .ifSome(serverValidationOutput)(_.serverValidationOutput(_))
        .build

    def vmServer(
      vmServerAddress: Option[VmServerAddress] = None,
      vmName: Option[String] = None,
      vmManagerName: Option[String] = None,
      vmManagerType: Option[String] = None,
      vmPath: Option[String] = None
    ): VmServer =
      VmServer
        .builder
        .ifSome(vmServerAddress)(_.vmServerAddress(_))
        .ifSome(vmName)(_.vmName(_))
        .ifSome(vmManagerName)(_.vmManagerName(_))
        .ifSome(vmManagerType)(_.vmManagerType(_))
        .ifSome(vmPath)(_.vmPath(_))
        .build

    def vmServerAddress(
      vmManagerId: Option[String] = None,
      vmId: Option[String] = None
    ): VmServerAddress =
      VmServerAddress
        .builder
        .ifSome(vmManagerId)(_.vmManagerId(_))
        .ifSome(vmId)(_.vmId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
