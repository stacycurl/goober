package goober.hi

import goober.free.iotthingsgraph.IoTThingsGraphIO
import software.amazon.awssdk.services.iotthingsgraph.model._


object iotthingsgraph {
  import goober.free.{iotthingsgraph ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateEntityToThingRequest(
      thingName: Option[String] = None,
      entityId: Option[String] = None,
      namespaceVersion: Option[Version] = None
    ): AssociateEntityToThingRequest =
      AssociateEntityToThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(namespaceVersion)(_.namespaceVersion(_))
        .build

    def associateEntityToThingResponse(

    ): AssociateEntityToThingResponse =
      AssociateEntityToThingResponse
        .builder

        .build

    def createFlowTemplateRequest(
      definition: Option[DefinitionDocument] = None,
      compatibleNamespaceVersion: Option[Version] = None
    ): CreateFlowTemplateRequest =
      CreateFlowTemplateRequest
        .builder
        .ifSome(definition)(_.definition(_))
        .ifSome(compatibleNamespaceVersion)(_.compatibleNamespaceVersion(_))
        .build

    def createFlowTemplateResponse(
      summary: Option[FlowTemplateSummary] = None
    ): CreateFlowTemplateResponse =
      CreateFlowTemplateResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def createSystemInstanceRequest(
      tags: Option[List[Tag]] = None,
      definition: Option[DefinitionDocument] = None,
      target: Option[String] = None,
      greengrassGroupName: Option[String] = None,
      s3BucketName: Option[String] = None,
      metricsConfiguration: Option[MetricsConfiguration] = None,
      flowActionsRoleArn: Option[String] = None
    ): CreateSystemInstanceRequest =
      CreateSystemInstanceRequest
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(target)(_.target(_))
        .ifSome(greengrassGroupName)(_.greengrassGroupName(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(metricsConfiguration)(_.metricsConfiguration(_))
        .ifSome(flowActionsRoleArn)(_.flowActionsRoleArn(_))
        .build

    def createSystemInstanceResponse(
      summary: Option[SystemInstanceSummary] = None
    ): CreateSystemInstanceResponse =
      CreateSystemInstanceResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def createSystemTemplateRequest(
      definition: Option[DefinitionDocument] = None,
      compatibleNamespaceVersion: Option[Version] = None
    ): CreateSystemTemplateRequest =
      CreateSystemTemplateRequest
        .builder
        .ifSome(definition)(_.definition(_))
        .ifSome(compatibleNamespaceVersion)(_.compatibleNamespaceVersion(_))
        .build

    def createSystemTemplateResponse(
      summary: Option[SystemTemplateSummary] = None
    ): CreateSystemTemplateResponse =
      CreateSystemTemplateResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def definitionDocument(
      language: Option[String] = None,
      text: Option[String] = None
    ): DefinitionDocument =
      DefinitionDocument
        .builder
        .ifSome(language)(_.language(_))
        .ifSome(text)(_.text(_))
        .build

    def deleteFlowTemplateRequest(
      id: Option[String] = None
    ): DeleteFlowTemplateRequest =
      DeleteFlowTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteFlowTemplateResponse(

    ): DeleteFlowTemplateResponse =
      DeleteFlowTemplateResponse
        .builder

        .build

    def deleteNamespaceRequest(

    ): DeleteNamespaceRequest =
      DeleteNamespaceRequest
        .builder

        .build

    def deleteNamespaceResponse(
      namespaceArn: Option[String] = None,
      namespaceName: Option[String] = None
    ): DeleteNamespaceResponse =
      DeleteNamespaceResponse
        .builder
        .ifSome(namespaceArn)(_.namespaceArn(_))
        .ifSome(namespaceName)(_.namespaceName(_))
        .build

    def deleteSystemInstanceRequest(
      id: Option[String] = None
    ): DeleteSystemInstanceRequest =
      DeleteSystemInstanceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteSystemInstanceResponse(

    ): DeleteSystemInstanceResponse =
      DeleteSystemInstanceResponse
        .builder

        .build

    def deleteSystemTemplateRequest(
      id: Option[String] = None
    ): DeleteSystemTemplateRequest =
      DeleteSystemTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteSystemTemplateResponse(

    ): DeleteSystemTemplateResponse =
      DeleteSystemTemplateResponse
        .builder

        .build

    def dependencyRevision(
      id: Option[String] = None,
      revisionNumber: Option[Version] = None
    ): DependencyRevision =
      DependencyRevision
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(revisionNumber)(_.revisionNumber(_))
        .build

    def deploySystemInstanceRequest(
      id: Option[String] = None
    ): DeploySystemInstanceRequest =
      DeploySystemInstanceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deploySystemInstanceResponse(
      summary: Option[SystemInstanceSummary] = None,
      greengrassDeploymentId: Option[String] = None
    ): DeploySystemInstanceResponse =
      DeploySystemInstanceResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .ifSome(greengrassDeploymentId)(_.greengrassDeploymentId(_))
        .build

    def deprecateFlowTemplateRequest(
      id: Option[String] = None
    ): DeprecateFlowTemplateRequest =
      DeprecateFlowTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deprecateFlowTemplateResponse(

    ): DeprecateFlowTemplateResponse =
      DeprecateFlowTemplateResponse
        .builder

        .build

    def deprecateSystemTemplateRequest(
      id: Option[String] = None
    ): DeprecateSystemTemplateRequest =
      DeprecateSystemTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deprecateSystemTemplateResponse(

    ): DeprecateSystemTemplateResponse =
      DeprecateSystemTemplateResponse
        .builder

        .build

    def describeNamespaceRequest(
      namespaceName: Option[String] = None
    ): DescribeNamespaceRequest =
      DescribeNamespaceRequest
        .builder
        .ifSome(namespaceName)(_.namespaceName(_))
        .build

    def describeNamespaceResponse(
      namespaceArn: Option[String] = None,
      namespaceName: Option[String] = None,
      trackingNamespaceName: Option[String] = None,
      trackingNamespaceVersion: Option[Version] = None,
      namespaceVersion: Option[Version] = None
    ): DescribeNamespaceResponse =
      DescribeNamespaceResponse
        .builder
        .ifSome(namespaceArn)(_.namespaceArn(_))
        .ifSome(namespaceName)(_.namespaceName(_))
        .ifSome(trackingNamespaceName)(_.trackingNamespaceName(_))
        .ifSome(trackingNamespaceVersion)(_.trackingNamespaceVersion(_))
        .ifSome(namespaceVersion)(_.namespaceVersion(_))
        .build

    def dissociateEntityFromThingRequest(
      thingName: Option[String] = None,
      entityType: Option[String] = None
    ): DissociateEntityFromThingRequest =
      DissociateEntityFromThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(entityType)(_.entityType(_))
        .build

    def dissociateEntityFromThingResponse(

    ): DissociateEntityFromThingResponse =
      DissociateEntityFromThingResponse
        .builder

        .build

    def entityDescription(
      id: Option[String] = None,
      arn: Option[String] = None,
      `type`: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      definition: Option[DefinitionDocument] = None
    ): EntityDescription =
      EntityDescription
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(definition)(_.definition(_))
        .build

    def entityFilter(
      name: Option[String] = None,
      value: Option[List[EntityFilterValue]] = None
    ): EntityFilter =
      EntityFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def flowExecutionMessage(
      messageId: Option[String] = None,
      eventType: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      payload: Option[String] = None
    ): FlowExecutionMessage =
      FlowExecutionMessage
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(payload)(_.payload(_))
        .build

    def flowExecutionSummary(
      flowExecutionId: Option[String] = None,
      status: Option[String] = None,
      systemInstanceId: Option[String] = None,
      flowTemplateId: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None
    ): FlowExecutionSummary =
      FlowExecutionSummary
        .builder
        .ifSome(flowExecutionId)(_.flowExecutionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(systemInstanceId)(_.systemInstanceId(_))
        .ifSome(flowTemplateId)(_.flowTemplateId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def flowTemplateDescription(
      summary: Option[FlowTemplateSummary] = None,
      definition: Option[DefinitionDocument] = None,
      validatedNamespaceVersion: Option[Version] = None
    ): FlowTemplateDescription =
      FlowTemplateDescription
        .builder
        .ifSome(summary)(_.summary(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(validatedNamespaceVersion)(_.validatedNamespaceVersion(_))
        .build

    def flowTemplateFilter(
      name: Option[String] = None,
      value: Option[List[FlowTemplateFilterValue]] = None
    ): FlowTemplateFilter =
      FlowTemplateFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def flowTemplateSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      revisionNumber: Option[Version] = None,
      createdAt: Option[Timestamp] = None
    ): FlowTemplateSummary =
      FlowTemplateSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(revisionNumber)(_.revisionNumber(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def getEntitiesRequest(
      ids: Option[List[Urn]] = None,
      namespaceVersion: Option[Version] = None
    ): GetEntitiesRequest =
      GetEntitiesRequest
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(namespaceVersion)(_.namespaceVersion(_))
        .build

    def getEntitiesResponse(
      descriptions: Option[List[EntityDescription]] = None
    ): GetEntitiesResponse =
      GetEntitiesResponse
        .builder
        .ifSome(descriptions)(_.descriptions(_))
        .build

    def getFlowTemplateRequest(
      id: Option[String] = None,
      revisionNumber: Option[Version] = None
    ): GetFlowTemplateRequest =
      GetFlowTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(revisionNumber)(_.revisionNumber(_))
        .build

    def getFlowTemplateResponse(
      description: Option[FlowTemplateDescription] = None
    ): GetFlowTemplateResponse =
      GetFlowTemplateResponse
        .builder
        .ifSome(description)(_.description(_))
        .build

    def getFlowTemplateRevisionsRequest(
      id: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetFlowTemplateRevisionsRequest =
      GetFlowTemplateRevisionsRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getFlowTemplateRevisionsResponse(
      summaries: Option[List[FlowTemplateSummary]] = None,
      nextToken: Option[String] = None
    ): GetFlowTemplateRevisionsResponse =
      GetFlowTemplateRevisionsResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getNamespaceDeletionStatusRequest(

    ): GetNamespaceDeletionStatusRequest =
      GetNamespaceDeletionStatusRequest
        .builder

        .build

    def getNamespaceDeletionStatusResponse(
      namespaceArn: Option[String] = None,
      namespaceName: Option[String] = None,
      status: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): GetNamespaceDeletionStatusResponse =
      GetNamespaceDeletionStatusResponse
        .builder
        .ifSome(namespaceArn)(_.namespaceArn(_))
        .ifSome(namespaceName)(_.namespaceName(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def getSystemInstanceRequest(
      id: Option[String] = None
    ): GetSystemInstanceRequest =
      GetSystemInstanceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getSystemInstanceResponse(
      description: Option[SystemInstanceDescription] = None
    ): GetSystemInstanceResponse =
      GetSystemInstanceResponse
        .builder
        .ifSome(description)(_.description(_))
        .build

    def getSystemTemplateRequest(
      id: Option[String] = None,
      revisionNumber: Option[Version] = None
    ): GetSystemTemplateRequest =
      GetSystemTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(revisionNumber)(_.revisionNumber(_))
        .build

    def getSystemTemplateResponse(
      description: Option[SystemTemplateDescription] = None
    ): GetSystemTemplateResponse =
      GetSystemTemplateResponse
        .builder
        .ifSome(description)(_.description(_))
        .build

    def getSystemTemplateRevisionsRequest(
      id: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetSystemTemplateRevisionsRequest =
      GetSystemTemplateRevisionsRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getSystemTemplateRevisionsResponse(
      summaries: Option[List[SystemTemplateSummary]] = None,
      nextToken: Option[String] = None
    ): GetSystemTemplateRevisionsResponse =
      GetSystemTemplateRevisionsResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getUploadStatusRequest(
      uploadId: Option[String] = None
    ): GetUploadStatusRequest =
      GetUploadStatusRequest
        .builder
        .ifSome(uploadId)(_.uploadId(_))
        .build

    def getUploadStatusResponse(
      uploadId: Option[String] = None,
      uploadStatus: Option[String] = None,
      namespaceArn: Option[String] = None,
      namespaceName: Option[String] = None,
      namespaceVersion: Option[Version] = None,
      failureReason: Option[List[String]] = None,
      createdDate: Option[Timestamp] = None
    ): GetUploadStatusResponse =
      GetUploadStatusResponse
        .builder
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(uploadStatus)(_.uploadStatus(_))
        .ifSome(namespaceArn)(_.namespaceArn(_))
        .ifSome(namespaceName)(_.namespaceName(_))
        .ifSome(namespaceVersion)(_.namespaceVersion(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
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

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listFlowExecutionMessagesRequest(
      flowExecutionId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFlowExecutionMessagesRequest =
      ListFlowExecutionMessagesRequest
        .builder
        .ifSome(flowExecutionId)(_.flowExecutionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFlowExecutionMessagesResponse(
      messages: Option[List[FlowExecutionMessage]] = None,
      nextToken: Option[String] = None
    ): ListFlowExecutionMessagesResponse =
      ListFlowExecutionMessagesResponse
        .builder
        .ifSome(messages)(_.messages(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      maxResults: Option[Int] = None,
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def metricsConfiguration(
      cloudMetricEnabled: Option[Boolean] = None,
      metricRuleRoleArn: Option[String] = None
    ): MetricsConfiguration =
      MetricsConfiguration
        .builder
        .ifSome(cloudMetricEnabled)(_.cloudMetricEnabled(_))
        .ifSome(metricRuleRoleArn)(_.metricRuleRoleArn(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
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

    def searchEntitiesRequest(
      entityTypes: Option[List[EntityType]] = None,
      filters: Option[List[EntityFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      namespaceVersion: Option[Version] = None
    ): SearchEntitiesRequest =
      SearchEntitiesRequest
        .builder
        .ifSome(entityTypes)(_.entityTypes(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(namespaceVersion)(_.namespaceVersion(_))
        .build

    def searchEntitiesResponse(
      descriptions: Option[List[EntityDescription]] = None,
      nextToken: Option[String] = None
    ): SearchEntitiesResponse =
      SearchEntitiesResponse
        .builder
        .ifSome(descriptions)(_.descriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchFlowExecutionsRequest(
      systemInstanceId: Option[String] = None,
      flowExecutionId: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchFlowExecutionsRequest =
      SearchFlowExecutionsRequest
        .builder
        .ifSome(systemInstanceId)(_.systemInstanceId(_))
        .ifSome(flowExecutionId)(_.flowExecutionId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchFlowExecutionsResponse(
      summaries: Option[List[FlowExecutionSummary]] = None,
      nextToken: Option[String] = None
    ): SearchFlowExecutionsResponse =
      SearchFlowExecutionsResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchFlowTemplatesRequest(
      filters: Option[List[FlowTemplateFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchFlowTemplatesRequest =
      SearchFlowTemplatesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchFlowTemplatesResponse(
      summaries: Option[List[FlowTemplateSummary]] = None,
      nextToken: Option[String] = None
    ): SearchFlowTemplatesResponse =
      SearchFlowTemplatesResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchSystemInstancesRequest(
      filters: Option[List[SystemInstanceFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchSystemInstancesRequest =
      SearchSystemInstancesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchSystemInstancesResponse(
      summaries: Option[List[SystemInstanceSummary]] = None,
      nextToken: Option[String] = None
    ): SearchSystemInstancesResponse =
      SearchSystemInstancesResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchSystemTemplatesRequest(
      filters: Option[List[SystemTemplateFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchSystemTemplatesRequest =
      SearchSystemTemplatesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchSystemTemplatesResponse(
      summaries: Option[List[SystemTemplateSummary]] = None,
      nextToken: Option[String] = None
    ): SearchSystemTemplatesResponse =
      SearchSystemTemplatesResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchThingsRequest(
      entityId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      namespaceVersion: Option[Version] = None
    ): SearchThingsRequest =
      SearchThingsRequest
        .builder
        .ifSome(entityId)(_.entityId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(namespaceVersion)(_.namespaceVersion(_))
        .build

    def searchThingsResponse(
      things: Option[List[Thing]] = None,
      nextToken: Option[String] = None
    ): SearchThingsResponse =
      SearchThingsResponse
        .builder
        .ifSome(things)(_.things(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def systemInstanceDescription(
      summary: Option[SystemInstanceSummary] = None,
      definition: Option[DefinitionDocument] = None,
      s3BucketName: Option[String] = None,
      metricsConfiguration: Option[MetricsConfiguration] = None,
      validatedNamespaceVersion: Option[Version] = None,
      validatedDependencyRevisions: Option[List[DependencyRevision]] = None,
      flowActionsRoleArn: Option[String] = None
    ): SystemInstanceDescription =
      SystemInstanceDescription
        .builder
        .ifSome(summary)(_.summary(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(metricsConfiguration)(_.metricsConfiguration(_))
        .ifSome(validatedNamespaceVersion)(_.validatedNamespaceVersion(_))
        .ifSome(validatedDependencyRevisions)(_.validatedDependencyRevisions(_))
        .ifSome(flowActionsRoleArn)(_.flowActionsRoleArn(_))
        .build

    def systemInstanceFilter(
      name: Option[String] = None,
      value: Option[List[SystemInstanceFilterValue]] = None
    ): SystemInstanceFilter =
      SystemInstanceFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def systemInstanceSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      status: Option[String] = None,
      target: Option[String] = None,
      greengrassGroupName: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      greengrassGroupId: Option[String] = None,
      greengrassGroupVersionId: Option[String] = None
    ): SystemInstanceSummary =
      SystemInstanceSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(target)(_.target(_))
        .ifSome(greengrassGroupName)(_.greengrassGroupName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(greengrassGroupId)(_.greengrassGroupId(_))
        .ifSome(greengrassGroupVersionId)(_.greengrassGroupVersionId(_))
        .build

    def systemTemplateDescription(
      summary: Option[SystemTemplateSummary] = None,
      definition: Option[DefinitionDocument] = None,
      validatedNamespaceVersion: Option[Version] = None
    ): SystemTemplateDescription =
      SystemTemplateDescription
        .builder
        .ifSome(summary)(_.summary(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(validatedNamespaceVersion)(_.validatedNamespaceVersion(_))
        .build

    def systemTemplateFilter(
      name: Option[String] = None,
      value: Option[List[SystemTemplateFilterValue]] = None
    ): SystemTemplateFilter =
      SystemTemplateFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def systemTemplateSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      revisionNumber: Option[Version] = None,
      createdAt: Option[Timestamp] = None
    ): SystemTemplateSummary =
      SystemTemplateSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(revisionNumber)(_.revisionNumber(_))
        .ifSome(createdAt)(_.createdAt(_))
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

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def thing(
      thingArn: Option[String] = None,
      thingName: Option[String] = None
    ): Thing =
      Thing
        .builder
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(thingName)(_.thingName(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def undeploySystemInstanceRequest(
      id: Option[String] = None
    ): UndeploySystemInstanceRequest =
      UndeploySystemInstanceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def undeploySystemInstanceResponse(
      summary: Option[SystemInstanceSummary] = None
    ): UndeploySystemInstanceResponse =
      UndeploySystemInstanceResponse
        .builder
        .ifSome(summary)(_.summary(_))
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

    def updateFlowTemplateRequest(
      id: Option[String] = None,
      definition: Option[DefinitionDocument] = None,
      compatibleNamespaceVersion: Option[Version] = None
    ): UpdateFlowTemplateRequest =
      UpdateFlowTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(compatibleNamespaceVersion)(_.compatibleNamespaceVersion(_))
        .build

    def updateFlowTemplateResponse(
      summary: Option[FlowTemplateSummary] = None
    ): UpdateFlowTemplateResponse =
      UpdateFlowTemplateResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def updateSystemTemplateRequest(
      id: Option[String] = None,
      definition: Option[DefinitionDocument] = None,
      compatibleNamespaceVersion: Option[Version] = None
    ): UpdateSystemTemplateRequest =
      UpdateSystemTemplateRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(compatibleNamespaceVersion)(_.compatibleNamespaceVersion(_))
        .build

    def updateSystemTemplateResponse(
      summary: Option[SystemTemplateSummary] = None
    ): UpdateSystemTemplateResponse =
      UpdateSystemTemplateResponse
        .builder
        .ifSome(summary)(_.summary(_))
        .build

    def uploadEntityDefinitionsRequest(
      document: Option[DefinitionDocument] = None,
      syncWithPublicNamespace: Option[Boolean] = None,
      deprecateExistingEntities: Option[Boolean] = None
    ): UploadEntityDefinitionsRequest =
      UploadEntityDefinitionsRequest
        .builder
        .ifSome(document)(_.document(_))
        .ifSome(syncWithPublicNamespace)(_.syncWithPublicNamespace(_))
        .ifSome(deprecateExistingEntities)(_.deprecateExistingEntities(_))
        .build

    def uploadEntityDefinitionsResponse(
      uploadId: Option[String] = None
    ): UploadEntityDefinitionsResponse =
      UploadEntityDefinitionsResponse
        .builder
        .ifSome(uploadId)(_.uploadId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
