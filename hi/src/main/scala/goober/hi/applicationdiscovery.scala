package goober.hi

import goober.free.applicationdiscovery.ApplicationDiscoveryIO
import software.amazon.awssdk.services.applicationdiscovery.model._


object applicationdiscovery {
  import goober.free.{applicationdiscovery ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def agentConfigurationStatus(
      agentId: Option[String] = None,
      operationSucceeded: Option[Boolean] = None,
      description: Option[String] = None
    ): AgentConfigurationStatus =
      AgentConfigurationStatus
        .builder
        .ifSome(agentId)(_.agentId(_))
        .ifSome(operationSucceeded)(_.operationSucceeded(_))
        .ifSome(description)(_.description(_))
        .build

    def agentInfo(
      agentId: Option[String] = None,
      hostName: Option[String] = None,
      agentNetworkInfoList: Option[List[AgentNetworkInfo]] = None,
      connectorId: Option[String] = None,
      version: Option[String] = None,
      health: Option[String] = None,
      lastHealthPingTime: Option[String] = None,
      collectionStatus: Option[String] = None,
      agentType: Option[String] = None,
      registeredTime: Option[String] = None
    ): AgentInfo =
      AgentInfo
        .builder
        .ifSome(agentId)(_.agentId(_))
        .ifSome(hostName)(_.hostName(_))
        .ifSome(agentNetworkInfoList)(_.agentNetworkInfoList(_))
        .ifSome(connectorId)(_.connectorId(_))
        .ifSome(version)(_.version(_))
        .ifSome(health)(_.health(_))
        .ifSome(lastHealthPingTime)(_.lastHealthPingTime(_))
        .ifSome(collectionStatus)(_.collectionStatus(_))
        .ifSome(agentType)(_.agentType(_))
        .ifSome(registeredTime)(_.registeredTime(_))
        .build

    def agentNetworkInfo(
      ipAddress: Option[String] = None,
      macAddress: Option[String] = None
    ): AgentNetworkInfo =
      AgentNetworkInfo
        .builder
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(macAddress)(_.macAddress(_))
        .build

    def associateConfigurationItemsToApplicationRequest(
      applicationConfigurationId: Option[String] = None,
      configurationIds: Option[List[ConfigurationId]] = None
    ): AssociateConfigurationItemsToApplicationRequest =
      AssociateConfigurationItemsToApplicationRequest
        .builder
        .ifSome(applicationConfigurationId)(_.applicationConfigurationId(_))
        .ifSome(configurationIds)(_.configurationIds(_))
        .build

    def associateConfigurationItemsToApplicationResponse(

    ): AssociateConfigurationItemsToApplicationResponse =
      AssociateConfigurationItemsToApplicationResponse
        .builder

        .build

    def authorizationErrorException(
      message: Option[String] = None
    ): AuthorizationErrorException =
      AuthorizationErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def batchDeleteImportDataError(
      importTaskId: Option[String] = None,
      errorCode: Option[String] = None,
      errorDescription: Option[String] = None
    ): BatchDeleteImportDataError =
      BatchDeleteImportDataError
        .builder
        .ifSome(importTaskId)(_.importTaskId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorDescription)(_.errorDescription(_))
        .build

    def batchDeleteImportDataRequest(
      importTaskIds: Option[List[ImportTaskIdentifier]] = None
    ): BatchDeleteImportDataRequest =
      BatchDeleteImportDataRequest
        .builder
        .ifSome(importTaskIds)(_.importTaskIds(_))
        .build

    def batchDeleteImportDataResponse(
      errors: Option[List[BatchDeleteImportDataError]] = None
    ): BatchDeleteImportDataResponse =
      BatchDeleteImportDataResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def configurationTag(
      configurationType: Option[String] = None,
      configurationId: Option[String] = None,
      key: Option[String] = None,
      value: Option[String] = None,
      timeOfCreation: Option[TimeStamp] = None
    ): ConfigurationTag =
      ConfigurationTag
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(timeOfCreation)(_.timeOfCreation(_))
        .build

    def conflictErrorException(
      message: Option[String] = None
    ): ConflictErrorException =
      ConflictErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def continuousExportDescription(
      exportId: Option[String] = None,
      status: Option[String] = None,
      statusDetail: Option[String] = None,
      s3Bucket: Option[String] = None,
      startTime: Option[TimeStamp] = None,
      stopTime: Option[TimeStamp] = None,
      dataSource: Option[String] = None,
      schemaStorageConfig: Option[SchemaStorageConfig] = None
    ): ContinuousExportDescription =
      ContinuousExportDescription
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetail)(_.statusDetail(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(stopTime)(_.stopTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(schemaStorageConfig)(_.schemaStorageConfig(_))
        .build

    def createApplicationRequest(
      name: Option[String] = None,
      description: Option[String] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def createApplicationResponse(
      configurationId: Option[String] = None
    ): CreateApplicationResponse =
      CreateApplicationResponse
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .build

    def createTagsRequest(
      configurationIds: Option[List[ConfigurationId]] = None,
      tags: Option[List[Tag]] = None
    ): CreateTagsRequest =
      CreateTagsRequest
        .builder
        .ifSome(configurationIds)(_.configurationIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTagsResponse(

    ): CreateTagsResponse =
      CreateTagsResponse
        .builder

        .build

    def customerAgentInfo(
      activeAgents: Option[Int] = None,
      healthyAgents: Option[Int] = None,
      blackListedAgents: Option[Int] = None,
      shutdownAgents: Option[Int] = None,
      unhealthyAgents: Option[Int] = None,
      totalAgents: Option[Int] = None,
      unknownAgents: Option[Int] = None
    ): CustomerAgentInfo =
      CustomerAgentInfo
        .builder
        .ifSome(activeAgents)(_.activeAgents(_))
        .ifSome(healthyAgents)(_.healthyAgents(_))
        .ifSome(blackListedAgents)(_.blackListedAgents(_))
        .ifSome(shutdownAgents)(_.shutdownAgents(_))
        .ifSome(unhealthyAgents)(_.unhealthyAgents(_))
        .ifSome(totalAgents)(_.totalAgents(_))
        .ifSome(unknownAgents)(_.unknownAgents(_))
        .build

    def customerConnectorInfo(
      activeConnectors: Option[Int] = None,
      healthyConnectors: Option[Int] = None,
      blackListedConnectors: Option[Int] = None,
      shutdownConnectors: Option[Int] = None,
      unhealthyConnectors: Option[Int] = None,
      totalConnectors: Option[Int] = None,
      unknownConnectors: Option[Int] = None
    ): CustomerConnectorInfo =
      CustomerConnectorInfo
        .builder
        .ifSome(activeConnectors)(_.activeConnectors(_))
        .ifSome(healthyConnectors)(_.healthyConnectors(_))
        .ifSome(blackListedConnectors)(_.blackListedConnectors(_))
        .ifSome(shutdownConnectors)(_.shutdownConnectors(_))
        .ifSome(unhealthyConnectors)(_.unhealthyConnectors(_))
        .ifSome(totalConnectors)(_.totalConnectors(_))
        .ifSome(unknownConnectors)(_.unknownConnectors(_))
        .build

    def deleteApplicationsRequest(
      configurationIds: Option[List[ApplicationId]] = None
    ): DeleteApplicationsRequest =
      DeleteApplicationsRequest
        .builder
        .ifSome(configurationIds)(_.configurationIds(_))
        .build

    def deleteApplicationsResponse(

    ): DeleteApplicationsResponse =
      DeleteApplicationsResponse
        .builder

        .build

    def deleteTagsRequest(
      configurationIds: Option[List[ConfigurationId]] = None,
      tags: Option[List[Tag]] = None
    ): DeleteTagsRequest =
      DeleteTagsRequest
        .builder
        .ifSome(configurationIds)(_.configurationIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteTagsResponse(

    ): DeleteTagsResponse =
      DeleteTagsResponse
        .builder

        .build

    def describeAgentsRequest(
      agentIds: Option[List[AgentId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAgentsRequest =
      DescribeAgentsRequest
        .builder
        .ifSome(agentIds)(_.agentIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAgentsResponse(
      agentsInfo: Option[List[AgentInfo]] = None,
      nextToken: Option[String] = None
    ): DescribeAgentsResponse =
      DescribeAgentsResponse
        .builder
        .ifSome(agentsInfo)(_.agentsInfo(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConfigurationsRequest(
      configurationIds: Option[List[ConfigurationId]] = None
    ): DescribeConfigurationsRequest =
      DescribeConfigurationsRequest
        .builder
        .ifSome(configurationIds)(_.configurationIds(_))
        .build

    def describeConfigurationsResponse(
      configurations: Option[List[DescribeConfigurationsAttribute]] = None
    ): DescribeConfigurationsResponse =
      DescribeConfigurationsResponse
        .builder
        .ifSome(configurations)(_.configurations(_))
        .build

    def describeContinuousExportsRequest(
      exportIds: Option[List[ConfigurationsExportId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeContinuousExportsRequest =
      DescribeContinuousExportsRequest
        .builder
        .ifSome(exportIds)(_.exportIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeContinuousExportsResponse(
      descriptions: Option[List[ContinuousExportDescription]] = None,
      nextToken: Option[String] = None
    ): DescribeContinuousExportsResponse =
      DescribeContinuousExportsResponse
        .builder
        .ifSome(descriptions)(_.descriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeExportConfigurationsRequest(
      exportIds: Option[List[ConfigurationsExportId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeExportConfigurationsRequest =
      DescribeExportConfigurationsRequest
        .builder
        .ifSome(exportIds)(_.exportIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeExportConfigurationsResponse(
      exportsInfo: Option[List[ExportInfo]] = None,
      nextToken: Option[String] = None
    ): DescribeExportConfigurationsResponse =
      DescribeExportConfigurationsResponse
        .builder
        .ifSome(exportsInfo)(_.exportsInfo(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeExportTasksRequest(
      exportIds: Option[List[ConfigurationsExportId]] = None,
      filters: Option[List[ExportFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeExportTasksRequest =
      DescribeExportTasksRequest
        .builder
        .ifSome(exportIds)(_.exportIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeExportTasksResponse(
      exportsInfo: Option[List[ExportInfo]] = None,
      nextToken: Option[String] = None
    ): DescribeExportTasksResponse =
      DescribeExportTasksResponse
        .builder
        .ifSome(exportsInfo)(_.exportsInfo(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImportTasksRequest(
      filters: Option[List[ImportTaskFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeImportTasksRequest =
      DescribeImportTasksRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImportTasksResponse(
      nextToken: Option[String] = None,
      tasks: Option[List[ImportTask]] = None
    ): DescribeImportTasksResponse =
      DescribeImportTasksResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tasks)(_.tasks(_))
        .build

    def describeTagsRequest(
      filters: Option[List[TagFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeTagsRequest =
      DescribeTagsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTagsResponse(
      tags: Option[List[ConfigurationTag]] = None,
      nextToken: Option[String] = None
    ): DescribeTagsResponse =
      DescribeTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def disassociateConfigurationItemsFromApplicationRequest(
      applicationConfigurationId: Option[String] = None,
      configurationIds: Option[List[ConfigurationId]] = None
    ): DisassociateConfigurationItemsFromApplicationRequest =
      DisassociateConfigurationItemsFromApplicationRequest
        .builder
        .ifSome(applicationConfigurationId)(_.applicationConfigurationId(_))
        .ifSome(configurationIds)(_.configurationIds(_))
        .build

    def disassociateConfigurationItemsFromApplicationResponse(

    ): DisassociateConfigurationItemsFromApplicationResponse =
      DisassociateConfigurationItemsFromApplicationResponse
        .builder

        .build

    def exportConfigurationsResponse(
      exportId: Option[String] = None
    ): ExportConfigurationsResponse =
      ExportConfigurationsResponse
        .builder
        .ifSome(exportId)(_.exportId(_))
        .build

    def exportFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      condition: Option[String] = None
    ): ExportFilter =
      ExportFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(condition)(_.condition(_))
        .build

    def exportInfo(
      exportId: Option[String] = None,
      exportStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      configurationsDownloadUrl: Option[String] = None,
      exportRequestTime: Option[ExportRequestTime] = None,
      isTruncated: Option[Boolean] = None,
      requestedStartTime: Option[TimeStamp] = None,
      requestedEndTime: Option[TimeStamp] = None
    ): ExportInfo =
      ExportInfo
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(configurationsDownloadUrl)(_.configurationsDownloadUrl(_))
        .ifSome(exportRequestTime)(_.exportRequestTime(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(requestedStartTime)(_.requestedStartTime(_))
        .ifSome(requestedEndTime)(_.requestedEndTime(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      condition: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(condition)(_.condition(_))
        .build

    def getDiscoverySummaryRequest(

    ): GetDiscoverySummaryRequest =
      GetDiscoverySummaryRequest
        .builder

        .build

    def getDiscoverySummaryResponse(
      servers: Option[Long] = None,
      applications: Option[Long] = None,
      serversMappedToApplications: Option[Long] = None,
      serversMappedtoTags: Option[Long] = None,
      agentSummary: Option[CustomerAgentInfo] = None,
      connectorSummary: Option[CustomerConnectorInfo] = None
    ): GetDiscoverySummaryResponse =
      GetDiscoverySummaryResponse
        .builder
        .ifSome(servers)(_.servers(_))
        .ifSome(applications)(_.applications(_))
        .ifSome(serversMappedToApplications)(_.serversMappedToApplications(_))
        .ifSome(serversMappedtoTags)(_.serversMappedtoTags(_))
        .ifSome(agentSummary)(_.agentSummary(_))
        .ifSome(connectorSummary)(_.connectorSummary(_))
        .build

    def homeRegionNotSetException(
      message: Option[String] = None
    ): HomeRegionNotSetException =
      HomeRegionNotSetException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def importTask(
      importTaskId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      name: Option[String] = None,
      importUrl: Option[String] = None,
      status: Option[String] = None,
      importRequestTime: Option[TimeStamp] = None,
      importCompletionTime: Option[TimeStamp] = None,
      importDeletedTime: Option[TimeStamp] = None,
      serverImportSuccess: Option[Int] = None,
      serverImportFailure: Option[Int] = None,
      applicationImportSuccess: Option[Int] = None,
      applicationImportFailure: Option[Int] = None,
      errorsAndFailedEntriesZip: Option[String] = None
    ): ImportTask =
      ImportTask
        .builder
        .ifSome(importTaskId)(_.importTaskId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(importUrl)(_.importUrl(_))
        .ifSome(status)(_.status(_))
        .ifSome(importRequestTime)(_.importRequestTime(_))
        .ifSome(importCompletionTime)(_.importCompletionTime(_))
        .ifSome(importDeletedTime)(_.importDeletedTime(_))
        .ifSome(serverImportSuccess)(_.serverImportSuccess(_))
        .ifSome(serverImportFailure)(_.serverImportFailure(_))
        .ifSome(applicationImportSuccess)(_.applicationImportSuccess(_))
        .ifSome(applicationImportFailure)(_.applicationImportFailure(_))
        .ifSome(errorsAndFailedEntriesZip)(_.errorsAndFailedEntriesZip(_))
        .build

    def importTaskFilter(
      name: Option[String] = None,
      values: Option[List[ImportTaskFilterValue]] = None
    ): ImportTaskFilter =
      ImportTaskFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
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

    def listConfigurationsRequest(
      configurationType: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      orderBy: Option[List[OrderByElement]] = None
    ): ListConfigurationsRequest =
      ListConfigurationsRequest
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def listConfigurationsResponse(
      configurations: Option[List[Configuration]] = None,
      nextToken: Option[String] = None
    ): ListConfigurationsResponse =
      ListConfigurationsResponse
        .builder
        .ifSome(configurations)(_.configurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServerNeighborsRequest(
      configurationId: Option[String] = None,
      portInformationNeeded: Option[Boolean] = None,
      neighborConfigurationIds: Option[List[ConfigurationId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListServerNeighborsRequest =
      ListServerNeighborsRequest
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(portInformationNeeded)(_.portInformationNeeded(_))
        .ifSome(neighborConfigurationIds)(_.neighborConfigurationIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServerNeighborsResponse(
      neighbors: Option[List[NeighborConnectionDetail]] = None,
      nextToken: Option[String] = None,
      knownDependencyCount: Option[Long] = None
    ): ListServerNeighborsResponse =
      ListServerNeighborsResponse
        .builder
        .ifSome(neighbors)(_.neighbors(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(knownDependencyCount)(_.knownDependencyCount(_))
        .build

    def neighborConnectionDetail(
      sourceServerId: Option[String] = None,
      destinationServerId: Option[String] = None,
      destinationPort: Option[Int] = None,
      transportProtocol: Option[String] = None,
      connectionsCount: Option[Long] = None
    ): NeighborConnectionDetail =
      NeighborConnectionDetail
        .builder
        .ifSome(sourceServerId)(_.sourceServerId(_))
        .ifSome(destinationServerId)(_.destinationServerId(_))
        .ifSome(destinationPort)(_.destinationPort(_))
        .ifSome(transportProtocol)(_.transportProtocol(_))
        .ifSome(connectionsCount)(_.connectionsCount(_))
        .build

    def operationNotPermittedException(
      message: Option[String] = None
    ): OperationNotPermittedException =
      OperationNotPermittedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def orderByElement(
      fieldName: Option[String] = None,
      sortOrder: Option[String] = None
    ): OrderByElement =
      OrderByElement
        .builder
        .ifSome(fieldName)(_.fieldName(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serverInternalErrorException(
      message: Option[String] = None
    ): ServerInternalErrorException =
      ServerInternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startContinuousExportRequest(

    ): StartContinuousExportRequest =
      StartContinuousExportRequest
        .builder

        .build

    def startContinuousExportResponse(
      exportId: Option[String] = None,
      s3Bucket: Option[String] = None,
      startTime: Option[TimeStamp] = None,
      dataSource: Option[String] = None,
      schemaStorageConfig: Option[SchemaStorageConfig] = None
    ): StartContinuousExportResponse =
      StartContinuousExportResponse
        .builder
        .ifSome(exportId)(_.exportId(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(schemaStorageConfig)(_.schemaStorageConfig(_))
        .build

    def startDataCollectionByAgentIdsRequest(
      agentIds: Option[List[AgentId]] = None
    ): StartDataCollectionByAgentIdsRequest =
      StartDataCollectionByAgentIdsRequest
        .builder
        .ifSome(agentIds)(_.agentIds(_))
        .build

    def startDataCollectionByAgentIdsResponse(
      agentsConfigurationStatus: Option[List[AgentConfigurationStatus]] = None
    ): StartDataCollectionByAgentIdsResponse =
      StartDataCollectionByAgentIdsResponse
        .builder
        .ifSome(agentsConfigurationStatus)(_.agentsConfigurationStatus(_))
        .build

    def startExportTaskRequest(
      exportDataFormat: Option[List[ExportDataFormat]] = None,
      filters: Option[List[ExportFilter]] = None,
      startTime: Option[TimeStamp] = None,
      endTime: Option[TimeStamp] = None
    ): StartExportTaskRequest =
      StartExportTaskRequest
        .builder
        .ifSome(exportDataFormat)(_.exportDataFormat(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def startExportTaskResponse(
      exportId: Option[String] = None
    ): StartExportTaskResponse =
      StartExportTaskResponse
        .builder
        .ifSome(exportId)(_.exportId(_))
        .build

    def startImportTaskRequest(
      clientRequestToken: Option[String] = None,
      name: Option[String] = None,
      importUrl: Option[String] = None
    ): StartImportTaskRequest =
      StartImportTaskRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(importUrl)(_.importUrl(_))
        .build

    def startImportTaskResponse(
      task: Option[ImportTask] = None
    ): StartImportTaskResponse =
      StartImportTaskResponse
        .builder
        .ifSome(task)(_.task(_))
        .build

    def stopContinuousExportRequest(
      exportId: Option[String] = None
    ): StopContinuousExportRequest =
      StopContinuousExportRequest
        .builder
        .ifSome(exportId)(_.exportId(_))
        .build

    def stopContinuousExportResponse(
      startTime: Option[TimeStamp] = None,
      stopTime: Option[TimeStamp] = None
    ): StopContinuousExportResponse =
      StopContinuousExportResponse
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(stopTime)(_.stopTime(_))
        .build

    def stopDataCollectionByAgentIdsRequest(
      agentIds: Option[List[AgentId]] = None
    ): StopDataCollectionByAgentIdsRequest =
      StopDataCollectionByAgentIdsRequest
        .builder
        .ifSome(agentIds)(_.agentIds(_))
        .build

    def stopDataCollectionByAgentIdsResponse(
      agentsConfigurationStatus: Option[List[AgentConfigurationStatus]] = None
    ): StopDataCollectionByAgentIdsResponse =
      StopDataCollectionByAgentIdsResponse
        .builder
        .ifSome(agentsConfigurationStatus)(_.agentsConfigurationStatus(_))
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

    def tagFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): TagFilter =
      TagFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def updateApplicationRequest(
      configurationId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateApplicationResponse(

    ): UpdateApplicationResponse =
      UpdateApplicationResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
