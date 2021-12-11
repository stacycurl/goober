package goober.hi

import goober.free.connect.ConnectIO
import software.amazon.awssdk.services.connect.model._


object connect {
  import goober.free.{connect ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateApprovedOriginRequest(
      instanceId: Option[String] = None,
      origin: Option[String] = None
    ): AssociateApprovedOriginRequest =
      AssociateApprovedOriginRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(origin)(_.origin(_))
        .build

    def associateBotRequest(
      instanceId: Option[String] = None,
      lexBot: Option[LexBot] = None,
      lexV2Bot: Option[LexV2Bot] = None
    ): AssociateBotRequest =
      AssociateBotRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(lexBot)(_.lexBot(_))
        .ifSome(lexV2Bot)(_.lexV2Bot(_))
        .build

    def associateInstanceStorageConfigRequest(
      instanceId: Option[String] = None,
      resourceType: Option[String] = None,
      storageConfig: Option[InstanceStorageConfig] = None
    ): AssociateInstanceStorageConfigRequest =
      AssociateInstanceStorageConfigRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(storageConfig)(_.storageConfig(_))
        .build

    def associateInstanceStorageConfigResponse(
      associationId: Option[String] = None
    ): AssociateInstanceStorageConfigResponse =
      AssociateInstanceStorageConfigResponse
        .builder
        .ifSome(associationId)(_.associationId(_))
        .build

    def associateLambdaFunctionRequest(
      instanceId: Option[String] = None,
      functionArn: Option[String] = None
    ): AssociateLambdaFunctionRequest =
      AssociateLambdaFunctionRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(functionArn)(_.functionArn(_))
        .build

    def associateLexBotRequest(
      instanceId: Option[String] = None,
      lexBot: Option[LexBot] = None
    ): AssociateLexBotRequest =
      AssociateLexBotRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(lexBot)(_.lexBot(_))
        .build

    def associateQueueQuickConnectsRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      quickConnectIds: Option[List[QuickConnectId]] = None
    ): AssociateQueueQuickConnectsRequest =
      AssociateQueueQuickConnectsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(quickConnectIds)(_.quickConnectIds(_))
        .build

    def associateRoutingProfileQueuesRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None,
      queueConfigs: Option[List[RoutingProfileQueueConfig]] = None
    ): AssociateRoutingProfileQueuesRequest =
      AssociateRoutingProfileQueuesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(queueConfigs)(_.queueConfigs(_))
        .build

    def associateSecurityKeyRequest(
      instanceId: Option[String] = None,
      key: Option[String] = None
    ): AssociateSecurityKeyRequest =
      AssociateSecurityKeyRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(key)(_.key(_))
        .build

    def associateSecurityKeyResponse(
      associationId: Option[String] = None
    ): AssociateSecurityKeyResponse =
      AssociateSecurityKeyResponse
        .builder
        .ifSome(associationId)(_.associationId(_))
        .build

    def attribute(
      attributeType: Option[String] = None,
      value: Option[String] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(attributeType)(_.attributeType(_))
        .ifSome(value)(_.value(_))
        .build

    def chatMessage(
      contentType: Option[String] = None,
      content: Option[String] = None
    ): ChatMessage =
      ChatMessage
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(content)(_.content(_))
        .build

    def contactFlow(
      arn: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      content: Option[String] = None,
      tags: Option[TagMap] = None
    ): ContactFlow =
      ContactFlow
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(content)(_.content(_))
        .ifSome(tags)(_.tags(_))
        .build

    def contactFlowNotPublishedException(
      message: Option[String] = None
    ): ContactFlowNotPublishedException =
      ContactFlowNotPublishedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def contactFlowSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      contactFlowType: Option[String] = None
    ): ContactFlowSummary =
      ContactFlowSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(contactFlowType)(_.contactFlowType(_))
        .build

    def contactNotFoundException(
      message: Option[String] = None
    ): ContactNotFoundException =
      ContactNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createContactFlowRequest(
      instanceId: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      content: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateContactFlowRequest =
      CreateContactFlowRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(content)(_.content(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createContactFlowResponse(
      contactFlowId: Option[String] = None,
      contactFlowArn: Option[String] = None
    ): CreateContactFlowResponse =
      CreateContactFlowResponse
        .builder
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .ifSome(contactFlowArn)(_.contactFlowArn(_))
        .build

    def createInstanceRequest(
      clientToken: Option[String] = None,
      identityManagementType: Option[String] = None,
      instanceAlias: Option[String] = None,
      directoryId: Option[String] = None,
      inboundCallsEnabled: Option[Boolean] = None,
      outboundCallsEnabled: Option[Boolean] = None
    ): CreateInstanceRequest =
      CreateInstanceRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(identityManagementType)(_.identityManagementType(_))
        .ifSome(instanceAlias)(_.instanceAlias(_))
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(inboundCallsEnabled)(_.inboundCallsEnabled(_))
        .ifSome(outboundCallsEnabled)(_.outboundCallsEnabled(_))
        .build

    def createInstanceResponse(
      id: Option[String] = None,
      arn: Option[String] = None
    ): CreateInstanceResponse =
      CreateInstanceResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .build

    def createIntegrationAssociationRequest(
      instanceId: Option[String] = None,
      integrationType: Option[String] = None,
      integrationArn: Option[String] = None,
      sourceApplicationUrl: Option[String] = None,
      sourceApplicationName: Option[String] = None,
      sourceType: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateIntegrationAssociationRequest =
      CreateIntegrationAssociationRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(integrationType)(_.integrationType(_))
        .ifSome(integrationArn)(_.integrationArn(_))
        .ifSome(sourceApplicationUrl)(_.sourceApplicationUrl(_))
        .ifSome(sourceApplicationName)(_.sourceApplicationName(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createIntegrationAssociationResponse(
      integrationAssociationId: Option[String] = None,
      integrationAssociationArn: Option[String] = None
    ): CreateIntegrationAssociationResponse =
      CreateIntegrationAssociationResponse
        .builder
        .ifSome(integrationAssociationId)(_.integrationAssociationId(_))
        .ifSome(integrationAssociationArn)(_.integrationAssociationArn(_))
        .build

    def createQueueRequest(
      instanceId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      outboundCallerConfig: Option[OutboundCallerConfig] = None,
      hoursOfOperationId: Option[String] = None,
      maxContacts: Option[Int] = None,
      quickConnectIds: Option[List[QuickConnectId]] = None,
      tags: Option[TagMap] = None
    ): CreateQueueRequest =
      CreateQueueRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(outboundCallerConfig)(_.outboundCallerConfig(_))
        .ifSome(hoursOfOperationId)(_.hoursOfOperationId(_))
        .ifSome(maxContacts)(_.maxContacts(_))
        .ifSome(quickConnectIds)(_.quickConnectIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createQueueResponse(
      queueArn: Option[String] = None,
      queueId: Option[String] = None
    ): CreateQueueResponse =
      CreateQueueResponse
        .builder
        .ifSome(queueArn)(_.queueArn(_))
        .ifSome(queueId)(_.queueId(_))
        .build

    def createQuickConnectRequest(
      instanceId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      quickConnectConfig: Option[QuickConnectConfig] = None,
      tags: Option[TagMap] = None
    ): CreateQuickConnectRequest =
      CreateQuickConnectRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(quickConnectConfig)(_.quickConnectConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createQuickConnectResponse(
      quickConnectARN: Option[String] = None,
      quickConnectId: Option[String] = None
    ): CreateQuickConnectResponse =
      CreateQuickConnectResponse
        .builder
        .ifSome(quickConnectARN)(_.quickConnectARN(_))
        .ifSome(quickConnectId)(_.quickConnectId(_))
        .build

    def createRoutingProfileRequest(
      instanceId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      defaultOutboundQueueId: Option[String] = None,
      queueConfigs: Option[List[RoutingProfileQueueConfig]] = None,
      mediaConcurrencies: Option[List[MediaConcurrency]] = None,
      tags: Option[TagMap] = None
    ): CreateRoutingProfileRequest =
      CreateRoutingProfileRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultOutboundQueueId)(_.defaultOutboundQueueId(_))
        .ifSome(queueConfigs)(_.queueConfigs(_))
        .ifSome(mediaConcurrencies)(_.mediaConcurrencies(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRoutingProfileResponse(
      routingProfileArn: Option[String] = None,
      routingProfileId: Option[String] = None
    ): CreateRoutingProfileResponse =
      CreateRoutingProfileResponse
        .builder
        .ifSome(routingProfileArn)(_.routingProfileArn(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .build

    def createUseCaseRequest(
      instanceId: Option[String] = None,
      integrationAssociationId: Option[String] = None,
      useCaseType: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateUseCaseRequest =
      CreateUseCaseRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(integrationAssociationId)(_.integrationAssociationId(_))
        .ifSome(useCaseType)(_.useCaseType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUseCaseResponse(
      useCaseId: Option[String] = None,
      useCaseArn: Option[String] = None
    ): CreateUseCaseResponse =
      CreateUseCaseResponse
        .builder
        .ifSome(useCaseId)(_.useCaseId(_))
        .ifSome(useCaseArn)(_.useCaseArn(_))
        .build

    def createUserHierarchyGroupRequest(
      name: Option[String] = None,
      parentGroupId: Option[String] = None,
      instanceId: Option[String] = None
    ): CreateUserHierarchyGroupRequest =
      CreateUserHierarchyGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(parentGroupId)(_.parentGroupId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def createUserHierarchyGroupResponse(
      hierarchyGroupId: Option[String] = None,
      hierarchyGroupArn: Option[String] = None
    ): CreateUserHierarchyGroupResponse =
      CreateUserHierarchyGroupResponse
        .builder
        .ifSome(hierarchyGroupId)(_.hierarchyGroupId(_))
        .ifSome(hierarchyGroupArn)(_.hierarchyGroupArn(_))
        .build

    def createUserRequest(
      username: Option[String] = None,
      password: Option[String] = None,
      identityInfo: Option[UserIdentityInfo] = None,
      phoneConfig: Option[UserPhoneConfig] = None,
      directoryUserId: Option[String] = None,
      securityProfileIds: Option[List[SecurityProfileId]] = None,
      routingProfileId: Option[String] = None,
      hierarchyGroupId: Option[String] = None,
      instanceId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(identityInfo)(_.identityInfo(_))
        .ifSome(phoneConfig)(_.phoneConfig(_))
        .ifSome(directoryUserId)(_.directoryUserId(_))
        .ifSome(securityProfileIds)(_.securityProfileIds(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(hierarchyGroupId)(_.hierarchyGroupId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUserResponse(
      userId: Option[String] = None,
      userArn: Option[String] = None
    ): CreateUserResponse =
      CreateUserResponse
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(userArn)(_.userArn(_))
        .build

    def credentials(
      accessToken: Option[String] = None,
      accessTokenExpiration: Option[timestamp] = None,
      refreshToken: Option[String] = None,
      refreshTokenExpiration: Option[timestamp] = None
    ): Credentials =
      Credentials
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(accessTokenExpiration)(_.accessTokenExpiration(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .ifSome(refreshTokenExpiration)(_.refreshTokenExpiration(_))
        .build

    def currentMetric(
      name: Option[String] = None,
      unit: Option[String] = None
    ): CurrentMetric =
      CurrentMetric
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(unit)(_.unit(_))
        .build

    def currentMetricData(
      metric: Option[CurrentMetric] = None,
      value: Option[Value] = None
    ): CurrentMetricData =
      CurrentMetricData
        .builder
        .ifSome(metric)(_.metric(_))
        .ifSome(value)(_.value(_))
        .build

    def deleteInstanceRequest(
      instanceId: Option[String] = None
    ): DeleteInstanceRequest =
      DeleteInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def deleteIntegrationAssociationRequest(
      instanceId: Option[String] = None,
      integrationAssociationId: Option[String] = None
    ): DeleteIntegrationAssociationRequest =
      DeleteIntegrationAssociationRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(integrationAssociationId)(_.integrationAssociationId(_))
        .build

    def deleteQuickConnectRequest(
      instanceId: Option[String] = None,
      quickConnectId: Option[String] = None
    ): DeleteQuickConnectRequest =
      DeleteQuickConnectRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(quickConnectId)(_.quickConnectId(_))
        .build

    def deleteUseCaseRequest(
      instanceId: Option[String] = None,
      integrationAssociationId: Option[String] = None,
      useCaseId: Option[String] = None
    ): DeleteUseCaseRequest =
      DeleteUseCaseRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(integrationAssociationId)(_.integrationAssociationId(_))
        .ifSome(useCaseId)(_.useCaseId(_))
        .build

    def deleteUserHierarchyGroupRequest(
      hierarchyGroupId: Option[String] = None,
      instanceId: Option[String] = None
    ): DeleteUserHierarchyGroupRequest =
      DeleteUserHierarchyGroupRequest
        .builder
        .ifSome(hierarchyGroupId)(_.hierarchyGroupId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def deleteUserRequest(
      instanceId: Option[String] = None,
      userId: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def describeContactFlowRequest(
      instanceId: Option[String] = None,
      contactFlowId: Option[String] = None
    ): DescribeContactFlowRequest =
      DescribeContactFlowRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .build

    def describeContactFlowResponse(
      contactFlow: Option[ContactFlow] = None
    ): DescribeContactFlowResponse =
      DescribeContactFlowResponse
        .builder
        .ifSome(contactFlow)(_.contactFlow(_))
        .build

    def describeHoursOfOperationRequest(
      instanceId: Option[String] = None,
      hoursOfOperationId: Option[String] = None
    ): DescribeHoursOfOperationRequest =
      DescribeHoursOfOperationRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(hoursOfOperationId)(_.hoursOfOperationId(_))
        .build

    def describeHoursOfOperationResponse(
      hoursOfOperation: Option[HoursOfOperation] = None
    ): DescribeHoursOfOperationResponse =
      DescribeHoursOfOperationResponse
        .builder
        .ifSome(hoursOfOperation)(_.hoursOfOperation(_))
        .build

    def describeInstanceAttributeRequest(
      instanceId: Option[String] = None,
      attributeType: Option[String] = None
    ): DescribeInstanceAttributeRequest =
      DescribeInstanceAttributeRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(attributeType)(_.attributeType(_))
        .build

    def describeInstanceAttributeResponse(
      attribute: Option[Attribute] = None
    ): DescribeInstanceAttributeResponse =
      DescribeInstanceAttributeResponse
        .builder
        .ifSome(attribute)(_.attribute(_))
        .build

    def describeInstanceRequest(
      instanceId: Option[String] = None
    ): DescribeInstanceRequest =
      DescribeInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def describeInstanceResponse(
      instance: Option[Instance] = None
    ): DescribeInstanceResponse =
      DescribeInstanceResponse
        .builder
        .ifSome(instance)(_.instance(_))
        .build

    def describeInstanceStorageConfigRequest(
      instanceId: Option[String] = None,
      associationId: Option[String] = None,
      resourceType: Option[String] = None
    ): DescribeInstanceStorageConfigRequest =
      DescribeInstanceStorageConfigRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def describeInstanceStorageConfigResponse(
      storageConfig: Option[InstanceStorageConfig] = None
    ): DescribeInstanceStorageConfigResponse =
      DescribeInstanceStorageConfigResponse
        .builder
        .ifSome(storageConfig)(_.storageConfig(_))
        .build

    def describeQueueRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None
    ): DescribeQueueRequest =
      DescribeQueueRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .build

    def describeQueueResponse(
      queue: Option[Queue] = None
    ): DescribeQueueResponse =
      DescribeQueueResponse
        .builder
        .ifSome(queue)(_.queue(_))
        .build

    def describeQuickConnectRequest(
      instanceId: Option[String] = None,
      quickConnectId: Option[String] = None
    ): DescribeQuickConnectRequest =
      DescribeQuickConnectRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(quickConnectId)(_.quickConnectId(_))
        .build

    def describeQuickConnectResponse(
      quickConnect: Option[QuickConnect] = None
    ): DescribeQuickConnectResponse =
      DescribeQuickConnectResponse
        .builder
        .ifSome(quickConnect)(_.quickConnect(_))
        .build

    def describeRoutingProfileRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None
    ): DescribeRoutingProfileRequest =
      DescribeRoutingProfileRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .build

    def describeRoutingProfileResponse(
      routingProfile: Option[RoutingProfile] = None
    ): DescribeRoutingProfileResponse =
      DescribeRoutingProfileResponse
        .builder
        .ifSome(routingProfile)(_.routingProfile(_))
        .build

    def describeUserHierarchyGroupRequest(
      hierarchyGroupId: Option[String] = None,
      instanceId: Option[String] = None
    ): DescribeUserHierarchyGroupRequest =
      DescribeUserHierarchyGroupRequest
        .builder
        .ifSome(hierarchyGroupId)(_.hierarchyGroupId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def describeUserHierarchyGroupResponse(
      hierarchyGroup: Option[HierarchyGroup] = None
    ): DescribeUserHierarchyGroupResponse =
      DescribeUserHierarchyGroupResponse
        .builder
        .ifSome(hierarchyGroup)(_.hierarchyGroup(_))
        .build

    def describeUserHierarchyStructureRequest(
      instanceId: Option[String] = None
    ): DescribeUserHierarchyStructureRequest =
      DescribeUserHierarchyStructureRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def describeUserHierarchyStructureResponse(
      hierarchyStructure: Option[HierarchyStructure] = None
    ): DescribeUserHierarchyStructureResponse =
      DescribeUserHierarchyStructureResponse
        .builder
        .ifSome(hierarchyStructure)(_.hierarchyStructure(_))
        .build

    def describeUserRequest(
      userId: Option[String] = None,
      instanceId: Option[String] = None
    ): DescribeUserRequest =
      DescribeUserRequest
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def describeUserResponse(
      user: Option[User] = None
    ): DescribeUserResponse =
      DescribeUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def destinationNotAllowedException(
      message: Option[String] = None
    ): DestinationNotAllowedException =
      DestinationNotAllowedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dimensions(
      queue: Option[QueueReference] = None,
      channel: Option[String] = None
    ): Dimensions =
      Dimensions
        .builder
        .ifSome(queue)(_.queue(_))
        .ifSome(channel)(_.channel(_))
        .build

    def disassociateApprovedOriginRequest(
      instanceId: Option[String] = None,
      origin: Option[String] = None
    ): DisassociateApprovedOriginRequest =
      DisassociateApprovedOriginRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(origin)(_.origin(_))
        .build

    def disassociateBotRequest(
      instanceId: Option[String] = None,
      lexBot: Option[LexBot] = None,
      lexV2Bot: Option[LexV2Bot] = None
    ): DisassociateBotRequest =
      DisassociateBotRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(lexBot)(_.lexBot(_))
        .ifSome(lexV2Bot)(_.lexV2Bot(_))
        .build

    def disassociateInstanceStorageConfigRequest(
      instanceId: Option[String] = None,
      associationId: Option[String] = None,
      resourceType: Option[String] = None
    ): DisassociateInstanceStorageConfigRequest =
      DisassociateInstanceStorageConfigRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def disassociateLambdaFunctionRequest(
      instanceId: Option[String] = None,
      functionArn: Option[String] = None
    ): DisassociateLambdaFunctionRequest =
      DisassociateLambdaFunctionRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(functionArn)(_.functionArn(_))
        .build

    def disassociateLexBotRequest(
      instanceId: Option[String] = None,
      botName: Option[String] = None,
      lexRegion: Option[String] = None
    ): DisassociateLexBotRequest =
      DisassociateLexBotRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(botName)(_.botName(_))
        .ifSome(lexRegion)(_.lexRegion(_))
        .build

    def disassociateQueueQuickConnectsRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      quickConnectIds: Option[List[QuickConnectId]] = None
    ): DisassociateQueueQuickConnectsRequest =
      DisassociateQueueQuickConnectsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(quickConnectIds)(_.quickConnectIds(_))
        .build

    def disassociateRoutingProfileQueuesRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None,
      queueReferences: Option[List[RoutingProfileQueueReference]] = None
    ): DisassociateRoutingProfileQueuesRequest =
      DisassociateRoutingProfileQueuesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(queueReferences)(_.queueReferences(_))
        .build

    def disassociateSecurityKeyRequest(
      instanceId: Option[String] = None,
      associationId: Option[String] = None
    ): DisassociateSecurityKeyRequest =
      DisassociateSecurityKeyRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationId)(_.associationId(_))
        .build

    def duplicateResourceException(
      message: Option[String] = None
    ): DuplicateResourceException =
      DuplicateResourceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def encryptionConfig(
      encryptionType: Option[String] = None,
      keyId: Option[String] = None
    ): EncryptionConfig =
      EncryptionConfig
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def filters(
      queues: Option[List[QueueId]] = None,
      channels: Option[List[Channel]] = None
    ): Filters =
      Filters
        .builder
        .ifSome(queues)(_.queues(_))
        .ifSome(channels)(_.channels(_))
        .build

    def getContactAttributesRequest(
      instanceId: Option[String] = None,
      initialContactId: Option[String] = None
    ): GetContactAttributesRequest =
      GetContactAttributesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(initialContactId)(_.initialContactId(_))
        .build

    def getContactAttributesResponse(
      attributes: Option[Attributes] = None
    ): GetContactAttributesResponse =
      GetContactAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getCurrentMetricDataRequest(
      instanceId: Option[String] = None,
      filters: Option[Filters] = None,
      groupings: Option[List[Grouping]] = None,
      currentMetrics: Option[List[CurrentMetric]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetCurrentMetricDataRequest =
      GetCurrentMetricDataRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupings)(_.groupings(_))
        .ifSome(currentMetrics)(_.currentMetrics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getCurrentMetricDataResponse(
      nextToken: Option[String] = None,
      metricResults: Option[List[CurrentMetricResult]] = None,
      dataSnapshotTime: Option[timestamp] = None
    ): GetCurrentMetricDataResponse =
      GetCurrentMetricDataResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(metricResults)(_.metricResults(_))
        .ifSome(dataSnapshotTime)(_.dataSnapshotTime(_))
        .build

    def getFederationTokenRequest(
      instanceId: Option[String] = None
    ): GetFederationTokenRequest =
      GetFederationTokenRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def getFederationTokenResponse(
      credentials: Option[Credentials] = None
    ): GetFederationTokenResponse =
      GetFederationTokenResponse
        .builder
        .ifSome(credentials)(_.credentials(_))
        .build

    def getMetricDataRequest(
      instanceId: Option[String] = None,
      startTime: Option[timestamp] = None,
      endTime: Option[timestamp] = None,
      filters: Option[Filters] = None,
      groupings: Option[List[Grouping]] = None,
      historicalMetrics: Option[List[HistoricalMetric]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetMetricDataRequest =
      GetMetricDataRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupings)(_.groupings(_))
        .ifSome(historicalMetrics)(_.historicalMetrics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getMetricDataResponse(
      nextToken: Option[String] = None,
      metricResults: Option[List[HistoricalMetricResult]] = None
    ): GetMetricDataResponse =
      GetMetricDataResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(metricResults)(_.metricResults(_))
        .build

    def hierarchyGroup(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      levelId: Option[String] = None,
      hierarchyPath: Option[HierarchyPath] = None
    ): HierarchyGroup =
      HierarchyGroup
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(levelId)(_.levelId(_))
        .ifSome(hierarchyPath)(_.hierarchyPath(_))
        .build

    def hierarchyGroupSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None
    ): HierarchyGroupSummary =
      HierarchyGroupSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def hierarchyLevel(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None
    ): HierarchyLevel =
      HierarchyLevel
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def hierarchyLevelUpdate(
      name: Option[String] = None
    ): HierarchyLevelUpdate =
      HierarchyLevelUpdate
        .builder
        .ifSome(name)(_.name(_))
        .build

    def hierarchyPath(
      levelOne: Option[HierarchyGroupSummary] = None,
      levelTwo: Option[HierarchyGroupSummary] = None,
      levelThree: Option[HierarchyGroupSummary] = None,
      levelFour: Option[HierarchyGroupSummary] = None,
      levelFive: Option[HierarchyGroupSummary] = None
    ): HierarchyPath =
      HierarchyPath
        .builder
        .ifSome(levelOne)(_.levelOne(_))
        .ifSome(levelTwo)(_.levelTwo(_))
        .ifSome(levelThree)(_.levelThree(_))
        .ifSome(levelFour)(_.levelFour(_))
        .ifSome(levelFive)(_.levelFive(_))
        .build

    def hierarchyStructure(
      levelOne: Option[HierarchyLevel] = None,
      levelTwo: Option[HierarchyLevel] = None,
      levelThree: Option[HierarchyLevel] = None,
      levelFour: Option[HierarchyLevel] = None,
      levelFive: Option[HierarchyLevel] = None
    ): HierarchyStructure =
      HierarchyStructure
        .builder
        .ifSome(levelOne)(_.levelOne(_))
        .ifSome(levelTwo)(_.levelTwo(_))
        .ifSome(levelThree)(_.levelThree(_))
        .ifSome(levelFour)(_.levelFour(_))
        .ifSome(levelFive)(_.levelFive(_))
        .build

    def hierarchyStructureUpdate(
      levelOne: Option[HierarchyLevelUpdate] = None,
      levelTwo: Option[HierarchyLevelUpdate] = None,
      levelThree: Option[HierarchyLevelUpdate] = None,
      levelFour: Option[HierarchyLevelUpdate] = None,
      levelFive: Option[HierarchyLevelUpdate] = None
    ): HierarchyStructureUpdate =
      HierarchyStructureUpdate
        .builder
        .ifSome(levelOne)(_.levelOne(_))
        .ifSome(levelTwo)(_.levelTwo(_))
        .ifSome(levelThree)(_.levelThree(_))
        .ifSome(levelFour)(_.levelFour(_))
        .ifSome(levelFive)(_.levelFive(_))
        .build

    def historicalMetric(
      name: Option[String] = None,
      threshold: Option[Threshold] = None,
      statistic: Option[String] = None,
      unit: Option[String] = None
    ): HistoricalMetric =
      HistoricalMetric
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(unit)(_.unit(_))
        .build

    def historicalMetricData(
      metric: Option[HistoricalMetric] = None,
      value: Option[Value] = None
    ): HistoricalMetricData =
      HistoricalMetricData
        .builder
        .ifSome(metric)(_.metric(_))
        .ifSome(value)(_.value(_))
        .build

    def hoursOfOperation(
      hoursOfOperationId: Option[String] = None,
      hoursOfOperationArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      timeZone: Option[String] = None,
      config: Option[List[HoursOfOperationConfig]] = None,
      tags: Option[TagMap] = None
    ): HoursOfOperation =
      HoursOfOperation
        .builder
        .ifSome(hoursOfOperationId)(_.hoursOfOperationId(_))
        .ifSome(hoursOfOperationArn)(_.hoursOfOperationArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(timeZone)(_.timeZone(_))
        .ifSome(config)(_.config(_))
        .ifSome(tags)(_.tags(_))
        .build

    def hoursOfOperationConfig(
      day: Option[String] = None,
      startTime: Option[HoursOfOperationTimeSlice] = None,
      endTime: Option[HoursOfOperationTimeSlice] = None
    ): HoursOfOperationConfig =
      HoursOfOperationConfig
        .builder
        .ifSome(day)(_.day(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def hoursOfOperationSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None
    ): HoursOfOperationSummary =
      HoursOfOperationSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def hoursOfOperationTimeSlice(
      hours: Option[Int] = None,
      minutes: Option[Int] = None
    ): HoursOfOperationTimeSlice =
      HoursOfOperationTimeSlice
        .builder
        .ifSome(hours)(_.hours(_))
        .ifSome(minutes)(_.minutes(_))
        .build

    def instance(
      id: Option[String] = None,
      arn: Option[String] = None,
      identityManagementType: Option[String] = None,
      instanceAlias: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      serviceRole: Option[String] = None,
      instanceStatus: Option[String] = None,
      statusReason: Option[InstanceStatusReason] = None,
      inboundCallsEnabled: Option[Boolean] = None,
      outboundCallsEnabled: Option[Boolean] = None
    ): Instance =
      Instance
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(identityManagementType)(_.identityManagementType(_))
        .ifSome(instanceAlias)(_.instanceAlias(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(instanceStatus)(_.instanceStatus(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(inboundCallsEnabled)(_.inboundCallsEnabled(_))
        .ifSome(outboundCallsEnabled)(_.outboundCallsEnabled(_))
        .build

    def instanceStatusReason(
      message: Option[String] = None
    ): InstanceStatusReason =
      InstanceStatusReason
        .builder
        .ifSome(message)(_.message(_))
        .build

    def instanceStorageConfig(
      associationId: Option[String] = None,
      storageType: Option[String] = None,
      s3Config: Option[S3Config] = None,
      kinesisVideoStreamConfig: Option[KinesisVideoStreamConfig] = None,
      kinesisStreamConfig: Option[KinesisStreamConfig] = None,
      kinesisFirehoseConfig: Option[KinesisFirehoseConfig] = None
    ): InstanceStorageConfig =
      InstanceStorageConfig
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(s3Config)(_.s3Config(_))
        .ifSome(kinesisVideoStreamConfig)(_.kinesisVideoStreamConfig(_))
        .ifSome(kinesisStreamConfig)(_.kinesisStreamConfig(_))
        .ifSome(kinesisFirehoseConfig)(_.kinesisFirehoseConfig(_))
        .build

    def instanceSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      identityManagementType: Option[String] = None,
      instanceAlias: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      serviceRole: Option[String] = None,
      instanceStatus: Option[String] = None,
      inboundCallsEnabled: Option[Boolean] = None,
      outboundCallsEnabled: Option[Boolean] = None
    ): InstanceSummary =
      InstanceSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(identityManagementType)(_.identityManagementType(_))
        .ifSome(instanceAlias)(_.instanceAlias(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(instanceStatus)(_.instanceStatus(_))
        .ifSome(inboundCallsEnabled)(_.inboundCallsEnabled(_))
        .ifSome(outboundCallsEnabled)(_.outboundCallsEnabled(_))
        .build

    def integrationAssociationSummary(
      integrationAssociationId: Option[String] = None,
      integrationAssociationArn: Option[String] = None,
      instanceId: Option[String] = None,
      integrationType: Option[String] = None,
      integrationArn: Option[String] = None,
      sourceApplicationUrl: Option[String] = None,
      sourceApplicationName: Option[String] = None,
      sourceType: Option[String] = None
    ): IntegrationAssociationSummary =
      IntegrationAssociationSummary
        .builder
        .ifSome(integrationAssociationId)(_.integrationAssociationId(_))
        .ifSome(integrationAssociationArn)(_.integrationAssociationArn(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(integrationType)(_.integrationType(_))
        .ifSome(integrationArn)(_.integrationArn(_))
        .ifSome(sourceApplicationUrl)(_.sourceApplicationUrl(_))
        .ifSome(sourceApplicationName)(_.sourceApplicationName(_))
        .ifSome(sourceType)(_.sourceType(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidContactFlowException(
      problems: Option[List[ProblemDetail]] = None
    ): InvalidContactFlowException =
      InvalidContactFlowException
        .builder
        .ifSome(problems)(_.problems(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
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

    def kinesisFirehoseConfig(
      firehoseArn: Option[String] = None
    ): KinesisFirehoseConfig =
      KinesisFirehoseConfig
        .builder
        .ifSome(firehoseArn)(_.firehoseArn(_))
        .build

    def kinesisStreamConfig(
      streamArn: Option[String] = None
    ): KinesisStreamConfig =
      KinesisStreamConfig
        .builder
        .ifSome(streamArn)(_.streamArn(_))
        .build

    def kinesisVideoStreamConfig(
      prefix: Option[String] = None,
      retentionPeriodHours: Option[Int] = None,
      encryptionConfig: Option[EncryptionConfig] = None
    ): KinesisVideoStreamConfig =
      KinesisVideoStreamConfig
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(retentionPeriodHours)(_.retentionPeriodHours(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .build

    def lexBot(
      name: Option[String] = None,
      lexRegion: Option[String] = None
    ): LexBot =
      LexBot
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(lexRegion)(_.lexRegion(_))
        .build

    def lexBotConfig(
      lexBot: Option[LexBot] = None,
      lexV2Bot: Option[LexV2Bot] = None
    ): LexBotConfig =
      LexBotConfig
        .builder
        .ifSome(lexBot)(_.lexBot(_))
        .ifSome(lexV2Bot)(_.lexV2Bot(_))
        .build

    def lexV2Bot(
      aliasArn: Option[String] = None
    ): LexV2Bot =
      LexV2Bot
        .builder
        .ifSome(aliasArn)(_.aliasArn(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApprovedOriginsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListApprovedOriginsRequest =
      ListApprovedOriginsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listApprovedOriginsResponse(
      origins: Option[List[Origin]] = None,
      nextToken: Option[String] = None
    ): ListApprovedOriginsResponse =
      ListApprovedOriginsResponse
        .builder
        .ifSome(origins)(_.origins(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      lexVersion: Option[String] = None
    ): ListBotsRequest =
      ListBotsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(lexVersion)(_.lexVersion(_))
        .build

    def listBotsResponse(
      lexBots: Option[List[LexBotConfig]] = None,
      nextToken: Option[String] = None
    ): ListBotsResponse =
      ListBotsResponse
        .builder
        .ifSome(lexBots)(_.lexBots(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContactFlowsRequest(
      instanceId: Option[String] = None,
      contactFlowTypes: Option[List[ContactFlowType]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListContactFlowsRequest =
      ListContactFlowsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactFlowTypes)(_.contactFlowTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listContactFlowsResponse(
      contactFlowSummaryList: Option[List[ContactFlowSummary]] = None,
      nextToken: Option[String] = None
    ): ListContactFlowsResponse =
      ListContactFlowsResponse
        .builder
        .ifSome(contactFlowSummaryList)(_.contactFlowSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHoursOfOperationsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListHoursOfOperationsRequest =
      ListHoursOfOperationsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listHoursOfOperationsResponse(
      hoursOfOperationSummaryList: Option[List[HoursOfOperationSummary]] = None,
      nextToken: Option[String] = None
    ): ListHoursOfOperationsResponse =
      ListHoursOfOperationsResponse
        .builder
        .ifSome(hoursOfOperationSummaryList)(_.hoursOfOperationSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInstanceAttributesRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListInstanceAttributesRequest =
      ListInstanceAttributesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listInstanceAttributesResponse(
      attributes: Option[List[Attribute]] = None,
      nextToken: Option[String] = None
    ): ListInstanceAttributesResponse =
      ListInstanceAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInstanceStorageConfigsRequest(
      instanceId: Option[String] = None,
      resourceType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListInstanceStorageConfigsRequest =
      ListInstanceStorageConfigsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listInstanceStorageConfigsResponse(
      storageConfigs: Option[List[InstanceStorageConfig]] = None,
      nextToken: Option[String] = None
    ): ListInstanceStorageConfigsResponse =
      ListInstanceStorageConfigsResponse
        .builder
        .ifSome(storageConfigs)(_.storageConfigs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInstancesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListInstancesRequest =
      ListInstancesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listInstancesResponse(
      instanceSummaryList: Option[List[InstanceSummary]] = None,
      nextToken: Option[String] = None
    ): ListInstancesResponse =
      ListInstancesResponse
        .builder
        .ifSome(instanceSummaryList)(_.instanceSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIntegrationAssociationsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListIntegrationAssociationsRequest =
      ListIntegrationAssociationsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listIntegrationAssociationsResponse(
      integrationAssociationSummaryList: Option[List[IntegrationAssociationSummary]] = None,
      nextToken: Option[String] = None
    ): ListIntegrationAssociationsResponse =
      ListIntegrationAssociationsResponse
        .builder
        .ifSome(integrationAssociationSummaryList)(_.integrationAssociationSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLambdaFunctionsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLambdaFunctionsRequest =
      ListLambdaFunctionsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLambdaFunctionsResponse(
      lambdaFunctions: Option[List[FunctionArn]] = None,
      nextToken: Option[String] = None
    ): ListLambdaFunctionsResponse =
      ListLambdaFunctionsResponse
        .builder
        .ifSome(lambdaFunctions)(_.lambdaFunctions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLexBotsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLexBotsRequest =
      ListLexBotsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLexBotsResponse(
      lexBots: Option[List[LexBot]] = None,
      nextToken: Option[String] = None
    ): ListLexBotsResponse =
      ListLexBotsResponse
        .builder
        .ifSome(lexBots)(_.lexBots(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPhoneNumbersRequest(
      instanceId: Option[String] = None,
      phoneNumberTypes: Option[List[PhoneNumberType]] = None,
      phoneNumberCountryCodes: Option[List[PhoneNumberCountryCode]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPhoneNumbersRequest =
      ListPhoneNumbersRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(phoneNumberTypes)(_.phoneNumberTypes(_))
        .ifSome(phoneNumberCountryCodes)(_.phoneNumberCountryCodes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPhoneNumbersResponse(
      phoneNumberSummaryList: Option[List[PhoneNumberSummary]] = None,
      nextToken: Option[String] = None
    ): ListPhoneNumbersResponse =
      ListPhoneNumbersResponse
        .builder
        .ifSome(phoneNumberSummaryList)(_.phoneNumberSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPromptsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPromptsRequest =
      ListPromptsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPromptsResponse(
      promptSummaryList: Option[List[PromptSummary]] = None,
      nextToken: Option[String] = None
    ): ListPromptsResponse =
      ListPromptsResponse
        .builder
        .ifSome(promptSummaryList)(_.promptSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listQueueQuickConnectsRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListQueueQuickConnectsRequest =
      ListQueueQuickConnectsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listQueueQuickConnectsResponse(
      nextToken: Option[String] = None,
      quickConnectSummaryList: Option[List[QuickConnectSummary]] = None
    ): ListQueueQuickConnectsResponse =
      ListQueueQuickConnectsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(quickConnectSummaryList)(_.quickConnectSummaryList(_))
        .build

    def listQueuesRequest(
      instanceId: Option[String] = None,
      queueTypes: Option[List[QueueType]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListQueuesRequest =
      ListQueuesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueTypes)(_.queueTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listQueuesResponse(
      queueSummaryList: Option[List[QueueSummary]] = None,
      nextToken: Option[String] = None
    ): ListQueuesResponse =
      ListQueuesResponse
        .builder
        .ifSome(queueSummaryList)(_.queueSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listQuickConnectsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      quickConnectTypes: Option[List[QuickConnectType]] = None
    ): ListQuickConnectsRequest =
      ListQuickConnectsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(quickConnectTypes)(_.quickConnectTypes(_))
        .build

    def listQuickConnectsResponse(
      quickConnectSummaryList: Option[List[QuickConnectSummary]] = None,
      nextToken: Option[String] = None
    ): ListQuickConnectsResponse =
      ListQuickConnectsResponse
        .builder
        .ifSome(quickConnectSummaryList)(_.quickConnectSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRoutingProfileQueuesRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRoutingProfileQueuesRequest =
      ListRoutingProfileQueuesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRoutingProfileQueuesResponse(
      nextToken: Option[String] = None,
      routingProfileQueueConfigSummaryList: Option[List[RoutingProfileQueueConfigSummary]] = None
    ): ListRoutingProfileQueuesResponse =
      ListRoutingProfileQueuesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(routingProfileQueueConfigSummaryList)(_.routingProfileQueueConfigSummaryList(_))
        .build

    def listRoutingProfilesRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRoutingProfilesRequest =
      ListRoutingProfilesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRoutingProfilesResponse(
      routingProfileSummaryList: Option[List[RoutingProfileSummary]] = None,
      nextToken: Option[String] = None
    ): ListRoutingProfilesResponse =
      ListRoutingProfilesResponse
        .builder
        .ifSome(routingProfileSummaryList)(_.routingProfileSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSecurityKeysRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSecurityKeysRequest =
      ListSecurityKeysRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSecurityKeysResponse(
      securityKeys: Option[List[SecurityKey]] = None,
      nextToken: Option[String] = None
    ): ListSecurityKeysResponse =
      ListSecurityKeysResponse
        .builder
        .ifSome(securityKeys)(_.securityKeys(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSecurityProfilesRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSecurityProfilesRequest =
      ListSecurityProfilesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSecurityProfilesResponse(
      securityProfileSummaryList: Option[List[SecurityProfileSummary]] = None,
      nextToken: Option[String] = None
    ): ListSecurityProfilesResponse =
      ListSecurityProfilesResponse
        .builder
        .ifSome(securityProfileSummaryList)(_.securityProfileSummaryList(_))
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

    def listUseCasesRequest(
      instanceId: Option[String] = None,
      integrationAssociationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUseCasesRequest =
      ListUseCasesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(integrationAssociationId)(_.integrationAssociationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listUseCasesResponse(
      useCaseSummaryList: Option[List[UseCase]] = None,
      nextToken: Option[String] = None
    ): ListUseCasesResponse =
      ListUseCasesResponse
        .builder
        .ifSome(useCaseSummaryList)(_.useCaseSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUserHierarchyGroupsRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUserHierarchyGroupsRequest =
      ListUserHierarchyGroupsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listUserHierarchyGroupsResponse(
      userHierarchyGroupSummaryList: Option[List[HierarchyGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListUserHierarchyGroupsResponse =
      ListUserHierarchyGroupsResponse
        .builder
        .ifSome(userHierarchyGroupSummaryList)(_.userHierarchyGroupSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsersRequest(
      instanceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listUsersResponse(
      userSummaryList: Option[List[UserSummary]] = None,
      nextToken: Option[String] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(userSummaryList)(_.userSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def mediaConcurrency(
      channel: Option[String] = None,
      concurrency: Option[Int] = None
    ): MediaConcurrency =
      MediaConcurrency
        .builder
        .ifSome(channel)(_.channel(_))
        .ifSome(concurrency)(_.concurrency(_))
        .build

    def outboundCallerConfig(
      outboundCallerIdName: Option[String] = None,
      outboundCallerIdNumberId: Option[String] = None,
      outboundFlowId: Option[String] = None
    ): OutboundCallerConfig =
      OutboundCallerConfig
        .builder
        .ifSome(outboundCallerIdName)(_.outboundCallerIdName(_))
        .ifSome(outboundCallerIdNumberId)(_.outboundCallerIdNumberId(_))
        .ifSome(outboundFlowId)(_.outboundFlowId(_))
        .build

    def outboundContactNotPermittedException(
      message: Option[String] = None
    ): OutboundContactNotPermittedException =
      OutboundContactNotPermittedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def participantDetails(
      displayName: Option[String] = None
    ): ParticipantDetails =
      ParticipantDetails
        .builder
        .ifSome(displayName)(_.displayName(_))
        .build

    def phoneNumberQuickConnectConfig(
      phoneNumber: Option[String] = None
    ): PhoneNumberQuickConnectConfig =
      PhoneNumberQuickConnectConfig
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def phoneNumberSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      phoneNumber: Option[String] = None,
      phoneNumberType: Option[String] = None,
      phoneNumberCountryCode: Option[String] = None
    ): PhoneNumberSummary =
      PhoneNumberSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(phoneNumberType)(_.phoneNumberType(_))
        .ifSome(phoneNumberCountryCode)(_.phoneNumberCountryCode(_))
        .build

    def problemDetail(
      message: Option[String] = None
    ): ProblemDetail =
      ProblemDetail
        .builder
        .ifSome(message)(_.message(_))
        .build

    def promptSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None
    ): PromptSummary =
      PromptSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def queue(
      name: Option[String] = None,
      queueArn: Option[String] = None,
      queueId: Option[String] = None,
      description: Option[String] = None,
      outboundCallerConfig: Option[OutboundCallerConfig] = None,
      hoursOfOperationId: Option[String] = None,
      maxContacts: Option[Int] = None,
      status: Option[String] = None,
      tags: Option[TagMap] = None
    ): Queue =
      Queue
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(queueArn)(_.queueArn(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(description)(_.description(_))
        .ifSome(outboundCallerConfig)(_.outboundCallerConfig(_))
        .ifSome(hoursOfOperationId)(_.hoursOfOperationId(_))
        .ifSome(maxContacts)(_.maxContacts(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def queueQuickConnectConfig(
      queueId: Option[String] = None,
      contactFlowId: Option[String] = None
    ): QueueQuickConnectConfig =
      QueueQuickConnectConfig
        .builder
        .ifSome(queueId)(_.queueId(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .build

    def queueReference(
      id: Option[String] = None,
      arn: Option[String] = None
    ): QueueReference =
      QueueReference
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .build

    def queueSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      queueType: Option[String] = None
    ): QueueSummary =
      QueueSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(queueType)(_.queueType(_))
        .build

    def quickConnect(
      quickConnectARN: Option[String] = None,
      quickConnectId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      quickConnectConfig: Option[QuickConnectConfig] = None,
      tags: Option[TagMap] = None
    ): QuickConnect =
      QuickConnect
        .builder
        .ifSome(quickConnectARN)(_.quickConnectARN(_))
        .ifSome(quickConnectId)(_.quickConnectId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(quickConnectConfig)(_.quickConnectConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def quickConnectConfig(
      quickConnectType: Option[String] = None,
      userConfig: Option[UserQuickConnectConfig] = None,
      queueConfig: Option[QueueQuickConnectConfig] = None,
      phoneConfig: Option[PhoneNumberQuickConnectConfig] = None
    ): QuickConnectConfig =
      QuickConnectConfig
        .builder
        .ifSome(quickConnectType)(_.quickConnectType(_))
        .ifSome(userConfig)(_.userConfig(_))
        .ifSome(queueConfig)(_.queueConfig(_))
        .ifSome(phoneConfig)(_.phoneConfig(_))
        .build

    def quickConnectSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      quickConnectType: Option[String] = None
    ): QuickConnectSummary =
      QuickConnectSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(quickConnectType)(_.quickConnectType(_))
        .build

    def reference(
      value: Option[String] = None,
      `type`: Option[String] = None
    ): Reference =
      Reference
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def resourceConflictException(
      message: Option[String] = None
    ): ResourceConflictException =
      ResourceConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceInUseException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resumeContactRecordingRequest(
      instanceId: Option[String] = None,
      contactId: Option[String] = None,
      initialContactId: Option[String] = None
    ): ResumeContactRecordingRequest =
      ResumeContactRecordingRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactId)(_.contactId(_))
        .ifSome(initialContactId)(_.initialContactId(_))
        .build

    def resumeContactRecordingResponse(

    ): ResumeContactRecordingResponse =
      ResumeContactRecordingResponse
        .builder

        .build

    def routingProfile(
      instanceId: Option[String] = None,
      name: Option[String] = None,
      routingProfileArn: Option[String] = None,
      routingProfileId: Option[String] = None,
      description: Option[String] = None,
      mediaConcurrencies: Option[List[MediaConcurrency]] = None,
      defaultOutboundQueueId: Option[String] = None,
      tags: Option[TagMap] = None
    ): RoutingProfile =
      RoutingProfile
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(routingProfileArn)(_.routingProfileArn(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(description)(_.description(_))
        .ifSome(mediaConcurrencies)(_.mediaConcurrencies(_))
        .ifSome(defaultOutboundQueueId)(_.defaultOutboundQueueId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def routingProfileQueueConfig(
      queueReference: Option[RoutingProfileQueueReference] = None,
      priority: Option[Int] = None,
      delay: Option[Int] = None
    ): RoutingProfileQueueConfig =
      RoutingProfileQueueConfig
        .builder
        .ifSome(queueReference)(_.queueReference(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(delay)(_.delay(_))
        .build

    def routingProfileQueueConfigSummary(
      queueId: Option[String] = None,
      queueArn: Option[String] = None,
      queueName: Option[String] = None,
      priority: Option[Int] = None,
      delay: Option[Int] = None,
      channel: Option[String] = None
    ): RoutingProfileQueueConfigSummary =
      RoutingProfileQueueConfigSummary
        .builder
        .ifSome(queueId)(_.queueId(_))
        .ifSome(queueArn)(_.queueArn(_))
        .ifSome(queueName)(_.queueName(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(delay)(_.delay(_))
        .ifSome(channel)(_.channel(_))
        .build

    def routingProfileQueueReference(
      queueId: Option[String] = None,
      channel: Option[String] = None
    ): RoutingProfileQueueReference =
      RoutingProfileQueueReference
        .builder
        .ifSome(queueId)(_.queueId(_))
        .ifSome(channel)(_.channel(_))
        .build

    def routingProfileSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None
    ): RoutingProfileSummary =
      RoutingProfileSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def s3Config(
      bucketName: Option[String] = None,
      bucketPrefix: Option[String] = None,
      encryptionConfig: Option[EncryptionConfig] = None
    ): S3Config =
      S3Config
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .build

    def securityKey(
      associationId: Option[String] = None,
      key: Option[String] = None,
      creationTime: Option[timestamp] = None
    ): SecurityKey =
      SecurityKey
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(key)(_.key(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def securityProfileSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None
    ): SecurityProfileSummary =
      SecurityProfileSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startChatContactRequest(
      instanceId: Option[String] = None,
      contactFlowId: Option[String] = None,
      attributes: Option[Attributes] = None,
      participantDetails: Option[ParticipantDetails] = None,
      initialMessage: Option[ChatMessage] = None,
      clientToken: Option[String] = None
    ): StartChatContactRequest =
      StartChatContactRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(participantDetails)(_.participantDetails(_))
        .ifSome(initialMessage)(_.initialMessage(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startChatContactResponse(
      contactId: Option[String] = None,
      participantId: Option[String] = None,
      participantToken: Option[String] = None
    ): StartChatContactResponse =
      StartChatContactResponse
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(participantId)(_.participantId(_))
        .ifSome(participantToken)(_.participantToken(_))
        .build

    def startContactRecordingRequest(
      instanceId: Option[String] = None,
      contactId: Option[String] = None,
      initialContactId: Option[String] = None,
      voiceRecordingConfiguration: Option[VoiceRecordingConfiguration] = None
    ): StartContactRecordingRequest =
      StartContactRecordingRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactId)(_.contactId(_))
        .ifSome(initialContactId)(_.initialContactId(_))
        .ifSome(voiceRecordingConfiguration)(_.voiceRecordingConfiguration(_))
        .build

    def startContactRecordingResponse(

    ): StartContactRecordingResponse =
      StartContactRecordingResponse
        .builder

        .build

    def startOutboundVoiceContactRequest(
      destinationPhoneNumber: Option[String] = None,
      contactFlowId: Option[String] = None,
      instanceId: Option[String] = None,
      clientToken: Option[String] = None,
      sourcePhoneNumber: Option[String] = None,
      queueId: Option[String] = None,
      attributes: Option[Attributes] = None
    ): StartOutboundVoiceContactRequest =
      StartOutboundVoiceContactRequest
        .builder
        .ifSome(destinationPhoneNumber)(_.destinationPhoneNumber(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(sourcePhoneNumber)(_.sourcePhoneNumber(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def startOutboundVoiceContactResponse(
      contactId: Option[String] = None
    ): StartOutboundVoiceContactResponse =
      StartOutboundVoiceContactResponse
        .builder
        .ifSome(contactId)(_.contactId(_))
        .build

    def startTaskContactRequest(
      instanceId: Option[String] = None,
      previousContactId: Option[String] = None,
      contactFlowId: Option[String] = None,
      attributes: Option[Attributes] = None,
      name: Option[String] = None,
      references: Option[ContactReferences] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None
    ): StartTaskContactRequest =
      StartTaskContactRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(previousContactId)(_.previousContactId(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(name)(_.name(_))
        .ifSome(references)(_.references(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startTaskContactResponse(
      contactId: Option[String] = None
    ): StartTaskContactResponse =
      StartTaskContactResponse
        .builder
        .ifSome(contactId)(_.contactId(_))
        .build

    def stopContactRecordingRequest(
      instanceId: Option[String] = None,
      contactId: Option[String] = None,
      initialContactId: Option[String] = None
    ): StopContactRecordingRequest =
      StopContactRecordingRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactId)(_.contactId(_))
        .ifSome(initialContactId)(_.initialContactId(_))
        .build

    def stopContactRecordingResponse(

    ): StopContactRecordingResponse =
      StopContactRecordingResponse
        .builder

        .build

    def stopContactRequest(
      contactId: Option[String] = None,
      instanceId: Option[String] = None
    ): StopContactRequest =
      StopContactRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def stopContactResponse(

    ): StopContactResponse =
      StopContactResponse
        .builder

        .build

    def suspendContactRecordingRequest(
      instanceId: Option[String] = None,
      contactId: Option[String] = None,
      initialContactId: Option[String] = None
    ): SuspendContactRecordingRequest =
      SuspendContactRecordingRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactId)(_.contactId(_))
        .ifSome(initialContactId)(_.initialContactId(_))
        .build

    def suspendContactRecordingResponse(

    ): SuspendContactRecordingResponse =
      SuspendContactRecordingResponse
        .builder

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

    def threshold(
      comparison: Option[String] = None,
      thresholdValue: Option[ThresholdValue] = None
    ): Threshold =
      Threshold
        .builder
        .ifSome(comparison)(_.comparison(_))
        .ifSome(thresholdValue)(_.thresholdValue(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateContactAttributesRequest(
      initialContactId: Option[String] = None,
      instanceId: Option[String] = None,
      attributes: Option[Attributes] = None
    ): UpdateContactAttributesRequest =
      UpdateContactAttributesRequest
        .builder
        .ifSome(initialContactId)(_.initialContactId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def updateContactAttributesResponse(

    ): UpdateContactAttributesResponse =
      UpdateContactAttributesResponse
        .builder

        .build

    def updateContactFlowContentRequest(
      instanceId: Option[String] = None,
      contactFlowId: Option[String] = None,
      content: Option[String] = None
    ): UpdateContactFlowContentRequest =
      UpdateContactFlowContentRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .ifSome(content)(_.content(_))
        .build

    def updateContactFlowNameRequest(
      instanceId: Option[String] = None,
      contactFlowId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateContactFlowNameRequest =
      UpdateContactFlowNameRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateInstanceAttributeRequest(
      instanceId: Option[String] = None,
      attributeType: Option[String] = None,
      value: Option[String] = None
    ): UpdateInstanceAttributeRequest =
      UpdateInstanceAttributeRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(attributeType)(_.attributeType(_))
        .ifSome(value)(_.value(_))
        .build

    def updateInstanceStorageConfigRequest(
      instanceId: Option[String] = None,
      associationId: Option[String] = None,
      resourceType: Option[String] = None,
      storageConfig: Option[InstanceStorageConfig] = None
    ): UpdateInstanceStorageConfigRequest =
      UpdateInstanceStorageConfigRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(storageConfig)(_.storageConfig(_))
        .build

    def updateQueueHoursOfOperationRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      hoursOfOperationId: Option[String] = None
    ): UpdateQueueHoursOfOperationRequest =
      UpdateQueueHoursOfOperationRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(hoursOfOperationId)(_.hoursOfOperationId(_))
        .build

    def updateQueueMaxContactsRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      maxContacts: Option[Int] = None
    ): UpdateQueueMaxContactsRequest =
      UpdateQueueMaxContactsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(maxContacts)(_.maxContacts(_))
        .build

    def updateQueueNameRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateQueueNameRequest =
      UpdateQueueNameRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateQueueOutboundCallerConfigRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      outboundCallerConfig: Option[OutboundCallerConfig] = None
    ): UpdateQueueOutboundCallerConfigRequest =
      UpdateQueueOutboundCallerConfigRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(outboundCallerConfig)(_.outboundCallerConfig(_))
        .build

    def updateQueueStatusRequest(
      instanceId: Option[String] = None,
      queueId: Option[String] = None,
      status: Option[String] = None
    ): UpdateQueueStatusRequest =
      UpdateQueueStatusRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(queueId)(_.queueId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateQuickConnectConfigRequest(
      instanceId: Option[String] = None,
      quickConnectId: Option[String] = None,
      quickConnectConfig: Option[QuickConnectConfig] = None
    ): UpdateQuickConnectConfigRequest =
      UpdateQuickConnectConfigRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(quickConnectId)(_.quickConnectId(_))
        .ifSome(quickConnectConfig)(_.quickConnectConfig(_))
        .build

    def updateQuickConnectNameRequest(
      instanceId: Option[String] = None,
      quickConnectId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateQuickConnectNameRequest =
      UpdateQuickConnectNameRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(quickConnectId)(_.quickConnectId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateRoutingProfileConcurrencyRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None,
      mediaConcurrencies: Option[List[MediaConcurrency]] = None
    ): UpdateRoutingProfileConcurrencyRequest =
      UpdateRoutingProfileConcurrencyRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(mediaConcurrencies)(_.mediaConcurrencies(_))
        .build

    def updateRoutingProfileDefaultOutboundQueueRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None,
      defaultOutboundQueueId: Option[String] = None
    ): UpdateRoutingProfileDefaultOutboundQueueRequest =
      UpdateRoutingProfileDefaultOutboundQueueRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(defaultOutboundQueueId)(_.defaultOutboundQueueId(_))
        .build

    def updateRoutingProfileNameRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateRoutingProfileNameRequest =
      UpdateRoutingProfileNameRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateRoutingProfileQueuesRequest(
      instanceId: Option[String] = None,
      routingProfileId: Option[String] = None,
      queueConfigs: Option[List[RoutingProfileQueueConfig]] = None
    ): UpdateRoutingProfileQueuesRequest =
      UpdateRoutingProfileQueuesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(queueConfigs)(_.queueConfigs(_))
        .build

    def updateUserHierarchyGroupNameRequest(
      name: Option[String] = None,
      hierarchyGroupId: Option[String] = None,
      instanceId: Option[String] = None
    ): UpdateUserHierarchyGroupNameRequest =
      UpdateUserHierarchyGroupNameRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(hierarchyGroupId)(_.hierarchyGroupId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def updateUserHierarchyRequest(
      hierarchyGroupId: Option[String] = None,
      userId: Option[String] = None,
      instanceId: Option[String] = None
    ): UpdateUserHierarchyRequest =
      UpdateUserHierarchyRequest
        .builder
        .ifSome(hierarchyGroupId)(_.hierarchyGroupId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def updateUserHierarchyStructureRequest(
      hierarchyStructure: Option[HierarchyStructureUpdate] = None,
      instanceId: Option[String] = None
    ): UpdateUserHierarchyStructureRequest =
      UpdateUserHierarchyStructureRequest
        .builder
        .ifSome(hierarchyStructure)(_.hierarchyStructure(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def updateUserIdentityInfoRequest(
      identityInfo: Option[UserIdentityInfo] = None,
      userId: Option[String] = None,
      instanceId: Option[String] = None
    ): UpdateUserIdentityInfoRequest =
      UpdateUserIdentityInfoRequest
        .builder
        .ifSome(identityInfo)(_.identityInfo(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def updateUserPhoneConfigRequest(
      phoneConfig: Option[UserPhoneConfig] = None,
      userId: Option[String] = None,
      instanceId: Option[String] = None
    ): UpdateUserPhoneConfigRequest =
      UpdateUserPhoneConfigRequest
        .builder
        .ifSome(phoneConfig)(_.phoneConfig(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def updateUserRoutingProfileRequest(
      routingProfileId: Option[String] = None,
      userId: Option[String] = None,
      instanceId: Option[String] = None
    ): UpdateUserRoutingProfileRequest =
      UpdateUserRoutingProfileRequest
        .builder
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def updateUserSecurityProfilesRequest(
      securityProfileIds: Option[List[SecurityProfileId]] = None,
      userId: Option[String] = None,
      instanceId: Option[String] = None
    ): UpdateUserSecurityProfilesRequest =
      UpdateUserSecurityProfilesRequest
        .builder
        .ifSome(securityProfileIds)(_.securityProfileIds(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def useCase(
      useCaseId: Option[String] = None,
      useCaseArn: Option[String] = None,
      useCaseType: Option[String] = None
    ): UseCase =
      UseCase
        .builder
        .ifSome(useCaseId)(_.useCaseId(_))
        .ifSome(useCaseArn)(_.useCaseArn(_))
        .ifSome(useCaseType)(_.useCaseType(_))
        .build

    def user(
      id: Option[String] = None,
      arn: Option[String] = None,
      username: Option[String] = None,
      identityInfo: Option[UserIdentityInfo] = None,
      phoneConfig: Option[UserPhoneConfig] = None,
      directoryUserId: Option[String] = None,
      securityProfileIds: Option[List[SecurityProfileId]] = None,
      routingProfileId: Option[String] = None,
      hierarchyGroupId: Option[String] = None,
      tags: Option[TagMap] = None
    ): User =
      User
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(username)(_.username(_))
        .ifSome(identityInfo)(_.identityInfo(_))
        .ifSome(phoneConfig)(_.phoneConfig(_))
        .ifSome(directoryUserId)(_.directoryUserId(_))
        .ifSome(securityProfileIds)(_.securityProfileIds(_))
        .ifSome(routingProfileId)(_.routingProfileId(_))
        .ifSome(hierarchyGroupId)(_.hierarchyGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def userIdentityInfo(
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      email: Option[String] = None
    ): UserIdentityInfo =
      UserIdentityInfo
        .builder
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(email)(_.email(_))
        .build

    def userNotFoundException(
      message: Option[String] = None
    ): UserNotFoundException =
      UserNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def userPhoneConfig(
      phoneType: Option[String] = None,
      autoAccept: Option[Boolean] = None,
      afterContactWorkTimeLimit: Option[Int] = None,
      deskPhoneNumber: Option[String] = None
    ): UserPhoneConfig =
      UserPhoneConfig
        .builder
        .ifSome(phoneType)(_.phoneType(_))
        .ifSome(autoAccept)(_.autoAccept(_))
        .ifSome(afterContactWorkTimeLimit)(_.afterContactWorkTimeLimit(_))
        .ifSome(deskPhoneNumber)(_.deskPhoneNumber(_))
        .build

    def userQuickConnectConfig(
      userId: Option[String] = None,
      contactFlowId: Option[String] = None
    ): UserQuickConnectConfig =
      UserQuickConnectConfig
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(contactFlowId)(_.contactFlowId(_))
        .build

    def userSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      username: Option[String] = None
    ): UserSummary =
      UserSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(username)(_.username(_))
        .build

    def voiceRecordingConfiguration(
      voiceRecordingTrack: Option[String] = None
    ): VoiceRecordingConfiguration =
      VoiceRecordingConfiguration
        .builder
        .ifSome(voiceRecordingTrack)(_.voiceRecordingTrack(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
