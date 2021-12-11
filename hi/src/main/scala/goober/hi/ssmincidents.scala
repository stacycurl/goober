package goober.hi

import goober.free.ssmincidents.SsmIncidentsIO
import software.amazon.awssdk.services.ssmincidents.model._


object ssmincidents {
  import goober.free.{ssmincidents ⇒ free}

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

    def action(
      ssmAutomation: Option[SsmAutomation] = None
    ): Action =
      Action
        .builder
        .ifSome(ssmAutomation)(_.ssmAutomation(_))
        .build

    def addRegionAction(
      regionName: Option[String] = None,
      sseKmsKeyId: Option[String] = None
    ): AddRegionAction =
      AddRegionAction
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(sseKmsKeyId)(_.sseKmsKeyId(_))
        .build

    def attributeValueList(
      integerValues: Option[List[Integer]] = None,
      stringValues: Option[List[StringListMemberString]] = None
    ): AttributeValueList =
      AttributeValueList
        .builder
        .ifSome(integerValues)(_.integerValues(_))
        .ifSome(stringValues)(_.stringValues(_))
        .build

    def automationExecution(
      ssmExecutionArn: Option[String] = None
    ): AutomationExecution =
      AutomationExecution
        .builder
        .ifSome(ssmExecutionArn)(_.ssmExecutionArn(_))
        .build

    def chatChannel(
      chatbotSns: Option[List[SnsArn]] = None,
      empty: Option[EmptyChatChannel] = None
    ): ChatChannel =
      ChatChannel
        .builder
        .ifSome(chatbotSns)(_.chatbotSns(_))
        .ifSome(empty)(_.empty(_))
        .build

    def condition(
      after: Option[Timestamp] = None,
      before: Option[Timestamp] = None,
      equals: Option[AttributeValueList] = None
    ): Condition =
      Condition
        .builder
        .ifSome(after)(_.after(_))
        .ifSome(before)(_.before(_))
        .ifSome(equals)(_.equals(_))
        .build

    def conflictException(
      message: Option[String] = None,
      resourceIdentifier: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def createReplicationSetInput(
      clientToken: Option[String] = None,
      regions: Option[RegionMapInput] = None
    ): CreateReplicationSetInput =
      CreateReplicationSetInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(regions)(_.regions(_))
        .build

    def createReplicationSetOutput(
      arn: Option[String] = None
    ): CreateReplicationSetOutput =
      CreateReplicationSetOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def createResponsePlanInput(
      actions: Option[List[Action]] = None,
      chatChannel: Option[ChatChannel] = None,
      clientToken: Option[String] = None,
      displayName: Option[String] = None,
      engagements: Option[List[SsmContactsArn]] = None,
      incidentTemplate: Option[IncidentTemplate] = None,
      name: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateResponsePlanInput =
      CreateResponsePlanInput
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(chatChannel)(_.chatChannel(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(engagements)(_.engagements(_))
        .ifSome(incidentTemplate)(_.incidentTemplate(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createResponsePlanOutput(
      arn: Option[String] = None
    ): CreateResponsePlanOutput =
      CreateResponsePlanOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def createTimelineEventInput(
      clientToken: Option[String] = None,
      eventData: Option[String] = None,
      eventTime: Option[Timestamp] = None,
      eventType: Option[String] = None,
      incidentRecordArn: Option[String] = None
    ): CreateTimelineEventInput =
      CreateTimelineEventInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(eventData)(_.eventData(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .build

    def createTimelineEventOutput(
      eventId: Option[String] = None,
      incidentRecordArn: Option[String] = None
    ): CreateTimelineEventOutput =
      CreateTimelineEventOutput
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .build

    def deleteIncidentRecordInput(
      arn: Option[String] = None
    ): DeleteIncidentRecordInput =
      DeleteIncidentRecordInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteIncidentRecordOutput(

    ): DeleteIncidentRecordOutput =
      DeleteIncidentRecordOutput
        .builder

        .build

    def deleteRegionAction(
      regionName: Option[String] = None
    ): DeleteRegionAction =
      DeleteRegionAction
        .builder
        .ifSome(regionName)(_.regionName(_))
        .build

    def deleteReplicationSetInput(
      arn: Option[String] = None
    ): DeleteReplicationSetInput =
      DeleteReplicationSetInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteReplicationSetOutput(

    ): DeleteReplicationSetOutput =
      DeleteReplicationSetOutput
        .builder

        .build

    def deleteResourcePolicyInput(
      policyId: Option[String] = None,
      resourceArn: Option[String] = None
    ): DeleteResourcePolicyInput =
      DeleteResourcePolicyInput
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def deleteResourcePolicyOutput(

    ): DeleteResourcePolicyOutput =
      DeleteResourcePolicyOutput
        .builder

        .build

    def deleteResponsePlanInput(
      arn: Option[String] = None
    ): DeleteResponsePlanInput =
      DeleteResponsePlanInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteResponsePlanOutput(

    ): DeleteResponsePlanOutput =
      DeleteResponsePlanOutput
        .builder

        .build

    def deleteTimelineEventInput(
      eventId: Option[String] = None,
      incidentRecordArn: Option[String] = None
    ): DeleteTimelineEventInput =
      DeleteTimelineEventInput
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .build

    def deleteTimelineEventOutput(

    ): DeleteTimelineEventOutput =
      DeleteTimelineEventOutput
        .builder

        .build

    def emptyChatChannel(

    ): EmptyChatChannel =
      EmptyChatChannel
        .builder

        .build

    def eventSummary(
      eventId: Option[String] = None,
      eventTime: Option[Timestamp] = None,
      eventType: Option[String] = None,
      eventUpdatedTime: Option[Timestamp] = None,
      incidentRecordArn: Option[String] = None
    ): EventSummary =
      EventSummary
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(eventUpdatedTime)(_.eventUpdatedTime(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .build

    def filter(
      condition: Option[Condition] = None,
      key: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(condition)(_.condition(_))
        .ifSome(key)(_.key(_))
        .build

    def getIncidentRecordInput(
      arn: Option[String] = None
    ): GetIncidentRecordInput =
      GetIncidentRecordInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getIncidentRecordOutput(
      incidentRecord: Option[IncidentRecord] = None
    ): GetIncidentRecordOutput =
      GetIncidentRecordOutput
        .builder
        .ifSome(incidentRecord)(_.incidentRecord(_))
        .build

    def getReplicationSetInput(
      arn: Option[String] = None
    ): GetReplicationSetInput =
      GetReplicationSetInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getReplicationSetOutput(
      replicationSet: Option[ReplicationSet] = None
    ): GetReplicationSetOutput =
      GetReplicationSetOutput
        .builder
        .ifSome(replicationSet)(_.replicationSet(_))
        .build

    def getResourcePoliciesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      resourceArn: Option[String] = None
    ): GetResourcePoliciesInput =
      GetResourcePoliciesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getResourcePoliciesOutput(
      nextToken: Option[String] = None,
      resourcePolicies: Option[List[ResourcePolicy]] = None
    ): GetResourcePoliciesOutput =
      GetResourcePoliciesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resourcePolicies)(_.resourcePolicies(_))
        .build

    def getResponsePlanInput(
      arn: Option[String] = None
    ): GetResponsePlanInput =
      GetResponsePlanInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getResponsePlanOutput(
      actions: Option[List[Action]] = None,
      arn: Option[String] = None,
      chatChannel: Option[ChatChannel] = None,
      displayName: Option[String] = None,
      engagements: Option[List[SsmContactsArn]] = None,
      incidentTemplate: Option[IncidentTemplate] = None,
      name: Option[String] = None
    ): GetResponsePlanOutput =
      GetResponsePlanOutput
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(chatChannel)(_.chatChannel(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(engagements)(_.engagements(_))
        .ifSome(incidentTemplate)(_.incidentTemplate(_))
        .ifSome(name)(_.name(_))
        .build

    def getTimelineEventInput(
      eventId: Option[String] = None,
      incidentRecordArn: Option[String] = None
    ): GetTimelineEventInput =
      GetTimelineEventInput
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .build

    def getTimelineEventOutput(
      event: Option[TimelineEvent] = None
    ): GetTimelineEventOutput =
      GetTimelineEventOutput
        .builder
        .ifSome(event)(_.event(_))
        .build

    def incidentRecord(
      arn: Option[String] = None,
      automationExecutions: Option[List[AutomationExecution]] = None,
      chatChannel: Option[ChatChannel] = None,
      creationTime: Option[Timestamp] = None,
      dedupeString: Option[String] = None,
      impact: Option[Int] = None,
      incidentRecordSource: Option[IncidentRecordSource] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None,
      notificationTargets: Option[List[NotificationTargetItem]] = None,
      resolvedTime: Option[Timestamp] = None,
      status: Option[String] = None,
      summary: Option[String] = None,
      title: Option[String] = None
    ): IncidentRecord =
      IncidentRecord
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(automationExecutions)(_.automationExecutions(_))
        .ifSome(chatChannel)(_.chatChannel(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(dedupeString)(_.dedupeString(_))
        .ifSome(impact)(_.impact(_))
        .ifSome(incidentRecordSource)(_.incidentRecordSource(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(notificationTargets)(_.notificationTargets(_))
        .ifSome(resolvedTime)(_.resolvedTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(title)(_.title(_))
        .build

    def incidentRecordSource(
      createdBy: Option[String] = None,
      invokedBy: Option[String] = None,
      resourceArn: Option[String] = None,
      source: Option[String] = None
    ): IncidentRecordSource =
      IncidentRecordSource
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(invokedBy)(_.invokedBy(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(source)(_.source(_))
        .build

    def incidentRecordSummary(
      arn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      impact: Option[Int] = None,
      incidentRecordSource: Option[IncidentRecordSource] = None,
      resolvedTime: Option[Timestamp] = None,
      status: Option[String] = None,
      title: Option[String] = None
    ): IncidentRecordSummary =
      IncidentRecordSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(impact)(_.impact(_))
        .ifSome(incidentRecordSource)(_.incidentRecordSource(_))
        .ifSome(resolvedTime)(_.resolvedTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(title)(_.title(_))
        .build

    def incidentTemplate(
      dedupeString: Option[String] = None,
      impact: Option[Int] = None,
      notificationTargets: Option[List[NotificationTargetItem]] = None,
      summary: Option[String] = None,
      title: Option[String] = None
    ): IncidentTemplate =
      IncidentTemplate
        .builder
        .ifSome(dedupeString)(_.dedupeString(_))
        .ifSome(impact)(_.impact(_))
        .ifSome(notificationTargets)(_.notificationTargets(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(title)(_.title(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def itemIdentifier(
      `type`: Option[String] = None,
      value: Option[ItemValue] = None
    ): ItemIdentifier =
      ItemIdentifier
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def itemValue(
      arn: Option[String] = None,
      metricDefinition: Option[String] = None,
      url: Option[String] = None
    ): ItemValue =
      ItemValue
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(metricDefinition)(_.metricDefinition(_))
        .ifSome(url)(_.url(_))
        .build

    def listIncidentRecordsInput(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListIncidentRecordsInput =
      ListIncidentRecordsInput
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIncidentRecordsOutput(
      incidentRecordSummaries: Option[List[IncidentRecordSummary]] = None,
      nextToken: Option[String] = None
    ): ListIncidentRecordsOutput =
      ListIncidentRecordsOutput
        .builder
        .ifSome(incidentRecordSummaries)(_.incidentRecordSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRelatedItemsInput(
      incidentRecordArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRelatedItemsInput =
      ListRelatedItemsInput
        .builder
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRelatedItemsOutput(
      nextToken: Option[String] = None,
      relatedItems: Option[List[RelatedItem]] = None
    ): ListRelatedItemsOutput =
      ListRelatedItemsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(relatedItems)(_.relatedItems(_))
        .build

    def listReplicationSetsInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListReplicationSetsInput =
      ListReplicationSetsInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listReplicationSetsOutput(
      nextToken: Option[String] = None,
      replicationSetArns: Option[List[Arn]] = None
    ): ListReplicationSetsOutput =
      ListReplicationSetsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(replicationSetArns)(_.replicationSetArns(_))
        .build

    def listResponsePlansInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListResponsePlansInput =
      ListResponsePlansInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResponsePlansOutput(
      nextToken: Option[String] = None,
      responsePlanSummaries: Option[List[ResponsePlanSummary]] = None
    ): ListResponsePlansOutput =
      ListResponsePlansOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(responsePlanSummaries)(_.responsePlanSummaries(_))
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

    def listTimelineEventsInput(
      filters: Option[List[Filter]] = None,
      incidentRecordArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): ListTimelineEventsInput =
      ListTimelineEventsInput
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listTimelineEventsOutput(
      eventSummaries: Option[List[EventSummary]] = None,
      nextToken: Option[String] = None
    ): ListTimelineEventsOutput =
      ListTimelineEventsOutput
        .builder
        .ifSome(eventSummaries)(_.eventSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def notificationTargetItem(
      snsTopicArn: Option[String] = None
    ): NotificationTargetItem =
      NotificationTargetItem
        .builder
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .build

    def putResourcePolicyInput(
      policy: Option[String] = None,
      resourceArn: Option[String] = None
    ): PutResourcePolicyInput =
      PutResourcePolicyInput
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def putResourcePolicyOutput(
      policyId: Option[String] = None
    ): PutResourcePolicyOutput =
      PutResourcePolicyOutput
        .builder
        .ifSome(policyId)(_.policyId(_))
        .build

    def regionInfo(
      sseKmsKeyId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      statusUpdateDateTime: Option[Timestamp] = None
    ): RegionInfo =
      RegionInfo
        .builder
        .ifSome(sseKmsKeyId)(_.sseKmsKeyId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(statusUpdateDateTime)(_.statusUpdateDateTime(_))
        .build

    def regionMapInputValue(
      sseKmsKeyId: Option[String] = None
    ): RegionMapInputValue =
      RegionMapInputValue
        .builder
        .ifSome(sseKmsKeyId)(_.sseKmsKeyId(_))
        .build

    def relatedItem(
      identifier: Option[ItemIdentifier] = None,
      title: Option[String] = None
    ): RelatedItem =
      RelatedItem
        .builder
        .ifSome(identifier)(_.identifier(_))
        .ifSome(title)(_.title(_))
        .build

    def relatedItemsUpdate(
      itemToAdd: Option[RelatedItem] = None,
      itemToRemove: Option[ItemIdentifier] = None
    ): RelatedItemsUpdate =
      RelatedItemsUpdate
        .builder
        .ifSome(itemToAdd)(_.itemToAdd(_))
        .ifSome(itemToRemove)(_.itemToRemove(_))
        .build

    def replicationSet(
      createdBy: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      deletionProtected: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedTime: Option[Timestamp] = None,
      regionMap: Option[RegionInfoMap] = None,
      status: Option[String] = None
    ): ReplicationSet =
      ReplicationSet
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(deletionProtected)(_.deletionProtected(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(regionMap)(_.regionMap(_))
        .ifSome(status)(_.status(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceIdentifier: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourcePolicy(
      policyDocument: Option[String] = None,
      policyId: Option[String] = None,
      ramResourceShareRegion: Option[String] = None
    ): ResourcePolicy =
      ResourcePolicy
        .builder
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(policyId)(_.policyId(_))
        .ifSome(ramResourceShareRegion)(_.ramResourceShareRegion(_))
        .build

    def responsePlanSummary(
      arn: Option[String] = None,
      displayName: Option[String] = None,
      name: Option[String] = None
    ): ResponsePlanSummary =
      ResponsePlanSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(name)(_.name(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      resourceIdentifier: Option[String] = None,
      resourceType: Option[String] = None,
      serviceCode: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def ssmAutomation(
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      parameters: Option[SsmParameters] = None,
      roleArn: Option[String] = None,
      targetAccount: Option[String] = None
    ): SsmAutomation =
      SsmAutomation
        .builder
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(targetAccount)(_.targetAccount(_))
        .build

    def startIncidentInput(
      clientToken: Option[String] = None,
      impact: Option[Int] = None,
      relatedItems: Option[List[RelatedItem]] = None,
      responsePlanArn: Option[String] = None,
      title: Option[String] = None,
      triggerDetails: Option[TriggerDetails] = None
    ): StartIncidentInput =
      StartIncidentInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(impact)(_.impact(_))
        .ifSome(relatedItems)(_.relatedItems(_))
        .ifSome(responsePlanArn)(_.responsePlanArn(_))
        .ifSome(title)(_.title(_))
        .ifSome(triggerDetails)(_.triggerDetails(_))
        .build

    def startIncidentOutput(
      incidentRecordArn: Option[String] = None
    ): StartIncidentOutput =
      StartIncidentOutput
        .builder
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
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
      serviceCode: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def timelineEvent(
      eventData: Option[String] = None,
      eventId: Option[String] = None,
      eventTime: Option[Timestamp] = None,
      eventType: Option[String] = None,
      eventUpdatedTime: Option[Timestamp] = None,
      incidentRecordArn: Option[String] = None
    ): TimelineEvent =
      TimelineEvent
        .builder
        .ifSome(eventData)(_.eventData(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(eventUpdatedTime)(_.eventUpdatedTime(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .build

    def triggerDetails(
      rawData: Option[String] = None,
      source: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      triggerArn: Option[String] = None
    ): TriggerDetails =
      TriggerDetails
        .builder
        .ifSome(rawData)(_.rawData(_))
        .ifSome(source)(_.source(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(triggerArn)(_.triggerArn(_))
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

    def updateDeletionProtectionInput(
      arn: Option[String] = None,
      clientToken: Option[String] = None,
      deletionProtected: Option[Boolean] = None
    ): UpdateDeletionProtectionInput =
      UpdateDeletionProtectionInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(deletionProtected)(_.deletionProtected(_))
        .build

    def updateDeletionProtectionOutput(

    ): UpdateDeletionProtectionOutput =
      UpdateDeletionProtectionOutput
        .builder

        .build

    def updateIncidentRecordInput(
      arn: Option[String] = None,
      chatChannel: Option[ChatChannel] = None,
      clientToken: Option[String] = None,
      impact: Option[Int] = None,
      notificationTargets: Option[List[NotificationTargetItem]] = None,
      status: Option[String] = None,
      summary: Option[String] = None,
      title: Option[String] = None
    ): UpdateIncidentRecordInput =
      UpdateIncidentRecordInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(chatChannel)(_.chatChannel(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(impact)(_.impact(_))
        .ifSome(notificationTargets)(_.notificationTargets(_))
        .ifSome(status)(_.status(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(title)(_.title(_))
        .build

    def updateIncidentRecordOutput(

    ): UpdateIncidentRecordOutput =
      UpdateIncidentRecordOutput
        .builder

        .build

    def updateRelatedItemsInput(
      clientToken: Option[String] = None,
      incidentRecordArn: Option[String] = None,
      relatedItemsUpdate: Option[RelatedItemsUpdate] = None
    ): UpdateRelatedItemsInput =
      UpdateRelatedItemsInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .ifSome(relatedItemsUpdate)(_.relatedItemsUpdate(_))
        .build

    def updateRelatedItemsOutput(

    ): UpdateRelatedItemsOutput =
      UpdateRelatedItemsOutput
        .builder

        .build

    def updateReplicationSetAction(
      addRegionAction: Option[AddRegionAction] = None,
      deleteRegionAction: Option[DeleteRegionAction] = None
    ): UpdateReplicationSetAction =
      UpdateReplicationSetAction
        .builder
        .ifSome(addRegionAction)(_.addRegionAction(_))
        .ifSome(deleteRegionAction)(_.deleteRegionAction(_))
        .build

    def updateReplicationSetInput(
      actions: Option[List[UpdateReplicationSetAction]] = None,
      arn: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateReplicationSetInput =
      UpdateReplicationSetInput
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateReplicationSetOutput(

    ): UpdateReplicationSetOutput =
      UpdateReplicationSetOutput
        .builder

        .build

    def updateResponsePlanInput(
      actions: Option[List[Action]] = None,
      arn: Option[String] = None,
      chatChannel: Option[ChatChannel] = None,
      clientToken: Option[String] = None,
      displayName: Option[String] = None,
      engagements: Option[List[SsmContactsArn]] = None,
      incidentTemplateDedupeString: Option[String] = None,
      incidentTemplateImpact: Option[Int] = None,
      incidentTemplateNotificationTargets: Option[List[NotificationTargetItem]] = None,
      incidentTemplateSummary: Option[String] = None,
      incidentTemplateTitle: Option[String] = None
    ): UpdateResponsePlanInput =
      UpdateResponsePlanInput
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(chatChannel)(_.chatChannel(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(engagements)(_.engagements(_))
        .ifSome(incidentTemplateDedupeString)(_.incidentTemplateDedupeString(_))
        .ifSome(incidentTemplateImpact)(_.incidentTemplateImpact(_))
        .ifSome(incidentTemplateNotificationTargets)(_.incidentTemplateNotificationTargets(_))
        .ifSome(incidentTemplateSummary)(_.incidentTemplateSummary(_))
        .ifSome(incidentTemplateTitle)(_.incidentTemplateTitle(_))
        .build

    def updateResponsePlanOutput(

    ): UpdateResponsePlanOutput =
      UpdateResponsePlanOutput
        .builder

        .build

    def updateTimelineEventInput(
      clientToken: Option[String] = None,
      eventData: Option[String] = None,
      eventId: Option[String] = None,
      eventTime: Option[Timestamp] = None,
      eventType: Option[String] = None,
      incidentRecordArn: Option[String] = None
    ): UpdateTimelineEventInput =
      UpdateTimelineEventInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(eventData)(_.eventData(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(incidentRecordArn)(_.incidentRecordArn(_))
        .build

    def updateTimelineEventOutput(

    ): UpdateTimelineEventOutput =
      UpdateTimelineEventOutput
        .builder

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
