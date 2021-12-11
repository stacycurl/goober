package goober.hi

import goober.free.eventbridge.EventBridgeIO
import software.amazon.awssdk.services.eventbridge.model._


object eventbridge {
  import goober.free.{eventbridge ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activateEventSourceRequest(
      name: Option[String] = None
    ): ActivateEventSourceRequest =
      ActivateEventSourceRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def apiDestination(
      apiDestinationArn: Option[String] = None,
      name: Option[String] = None,
      apiDestinationState: Option[String] = None,
      connectionArn: Option[String] = None,
      invocationEndpoint: Option[String] = None,
      httpMethod: Option[String] = None,
      invocationRateLimitPerSecond: Option[Int] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): ApiDestination =
      ApiDestination
        .builder
        .ifSome(apiDestinationArn)(_.apiDestinationArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(apiDestinationState)(_.apiDestinationState(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(invocationEndpoint)(_.invocationEndpoint(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(invocationRateLimitPerSecond)(_.invocationRateLimitPerSecond(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def archive(
      archiveName: Option[String] = None,
      eventSourceArn: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      retentionDays: Option[Int] = None,
      sizeBytes: Option[Long] = None,
      eventCount: Option[Long] = None,
      creationTime: Option[Timestamp] = None
    ): Archive =
      Archive
        .builder
        .ifSome(archiveName)(_.archiveName(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(retentionDays)(_.retentionDays(_))
        .ifSome(sizeBytes)(_.sizeBytes(_))
        .ifSome(eventCount)(_.eventCount(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def awsVpcConfiguration(
      subnets: Option[List[String]] = None,
      securityGroups: Option[List[String]] = None,
      assignPublicIp: Option[String] = None
    ): AwsVpcConfiguration =
      AwsVpcConfiguration
        .builder
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(assignPublicIp)(_.assignPublicIp(_))
        .build

    def batchArrayProperties(
      size: Option[Int] = None
    ): BatchArrayProperties =
      BatchArrayProperties
        .builder
        .ifSome(size)(_.size(_))
        .build

    def batchParameters(
      jobDefinition: Option[String] = None,
      jobName: Option[String] = None,
      arrayProperties: Option[BatchArrayProperties] = None,
      retryStrategy: Option[BatchRetryStrategy] = None
    ): BatchParameters =
      BatchParameters
        .builder
        .ifSome(jobDefinition)(_.jobDefinition(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(arrayProperties)(_.arrayProperties(_))
        .ifSome(retryStrategy)(_.retryStrategy(_))
        .build

    def batchRetryStrategy(
      attempts: Option[Int] = None
    ): BatchRetryStrategy =
      BatchRetryStrategy
        .builder
        .ifSome(attempts)(_.attempts(_))
        .build

    def cancelReplayRequest(
      replayName: Option[String] = None
    ): CancelReplayRequest =
      CancelReplayRequest
        .builder
        .ifSome(replayName)(_.replayName(_))
        .build

    def cancelReplayResponse(
      replayArn: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None
    ): CancelReplayResponse =
      CancelReplayResponse
        .builder
        .ifSome(replayArn)(_.replayArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .build

    def concurrentModificationException(

    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder

        .build

    def condition(
      `type`: Option[String] = None,
      key: Option[String] = None,
      value: Option[String] = None
    ): Condition =
      Condition
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def connection(
      connectionArn: Option[String] = None,
      name: Option[String] = None,
      connectionState: Option[String] = None,
      stateReason: Option[String] = None,
      authorizationType: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastAuthorizedTime: Option[Timestamp] = None
    ): Connection =
      Connection
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastAuthorizedTime)(_.lastAuthorizedTime(_))
        .build

    def connectionApiKeyAuthResponseParameters(
      apiKeyName: Option[String] = None
    ): ConnectionApiKeyAuthResponseParameters =
      ConnectionApiKeyAuthResponseParameters
        .builder
        .ifSome(apiKeyName)(_.apiKeyName(_))
        .build

    def connectionAuthResponseParameters(
      basicAuthParameters: Option[ConnectionBasicAuthResponseParameters] = None,
      oAuthParameters: Option[ConnectionOAuthResponseParameters] = None,
      apiKeyAuthParameters: Option[ConnectionApiKeyAuthResponseParameters] = None,
      invocationHttpParameters: Option[ConnectionHttpParameters] = None
    ): ConnectionAuthResponseParameters =
      ConnectionAuthResponseParameters
        .builder
        .ifSome(basicAuthParameters)(_.basicAuthParameters(_))
        .ifSome(oAuthParameters)(_.oAuthParameters(_))
        .ifSome(apiKeyAuthParameters)(_.apiKeyAuthParameters(_))
        .ifSome(invocationHttpParameters)(_.invocationHttpParameters(_))
        .build

    def connectionBasicAuthResponseParameters(
      username: Option[String] = None
    ): ConnectionBasicAuthResponseParameters =
      ConnectionBasicAuthResponseParameters
        .builder
        .ifSome(username)(_.username(_))
        .build

    def connectionBodyParameter(
      key: Option[String] = None,
      value: Option[String] = None,
      isValueSecret: Option[Boolean] = None
    ): ConnectionBodyParameter =
      ConnectionBodyParameter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(isValueSecret)(_.isValueSecret(_))
        .build

    def connectionHeaderParameter(
      key: Option[String] = None,
      value: Option[String] = None,
      isValueSecret: Option[Boolean] = None
    ): ConnectionHeaderParameter =
      ConnectionHeaderParameter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(isValueSecret)(_.isValueSecret(_))
        .build

    def connectionHttpParameters(
      headerParameters: Option[List[ConnectionHeaderParameter]] = None,
      queryStringParameters: Option[List[ConnectionQueryStringParameter]] = None,
      bodyParameters: Option[List[ConnectionBodyParameter]] = None
    ): ConnectionHttpParameters =
      ConnectionHttpParameters
        .builder
        .ifSome(headerParameters)(_.headerParameters(_))
        .ifSome(queryStringParameters)(_.queryStringParameters(_))
        .ifSome(bodyParameters)(_.bodyParameters(_))
        .build

    def connectionOAuthClientResponseParameters(
      clientID: Option[String] = None
    ): ConnectionOAuthClientResponseParameters =
      ConnectionOAuthClientResponseParameters
        .builder
        .ifSome(clientID)(_.clientID(_))
        .build

    def connectionOAuthResponseParameters(
      clientParameters: Option[ConnectionOAuthClientResponseParameters] = None,
      authorizationEndpoint: Option[String] = None,
      httpMethod: Option[String] = None,
      oAuthHttpParameters: Option[ConnectionHttpParameters] = None
    ): ConnectionOAuthResponseParameters =
      ConnectionOAuthResponseParameters
        .builder
        .ifSome(clientParameters)(_.clientParameters(_))
        .ifSome(authorizationEndpoint)(_.authorizationEndpoint(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(oAuthHttpParameters)(_.oAuthHttpParameters(_))
        .build

    def connectionQueryStringParameter(
      key: Option[String] = None,
      value: Option[String] = None,
      isValueSecret: Option[Boolean] = None
    ): ConnectionQueryStringParameter =
      ConnectionQueryStringParameter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(isValueSecret)(_.isValueSecret(_))
        .build

    def createApiDestinationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      connectionArn: Option[String] = None,
      invocationEndpoint: Option[String] = None,
      httpMethod: Option[String] = None,
      invocationRateLimitPerSecond: Option[Int] = None
    ): CreateApiDestinationRequest =
      CreateApiDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(invocationEndpoint)(_.invocationEndpoint(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(invocationRateLimitPerSecond)(_.invocationRateLimitPerSecond(_))
        .build

    def createApiDestinationResponse(
      apiDestinationArn: Option[String] = None,
      apiDestinationState: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): CreateApiDestinationResponse =
      CreateApiDestinationResponse
        .builder
        .ifSome(apiDestinationArn)(_.apiDestinationArn(_))
        .ifSome(apiDestinationState)(_.apiDestinationState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def createArchiveRequest(
      archiveName: Option[String] = None,
      eventSourceArn: Option[String] = None,
      description: Option[String] = None,
      eventPattern: Option[String] = None,
      retentionDays: Option[Int] = None
    ): CreateArchiveRequest =
      CreateArchiveRequest
        .builder
        .ifSome(archiveName)(_.archiveName(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventPattern)(_.eventPattern(_))
        .ifSome(retentionDays)(_.retentionDays(_))
        .build

    def createArchiveResponse(
      archiveArn: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): CreateArchiveResponse =
      CreateArchiveResponse
        .builder
        .ifSome(archiveArn)(_.archiveArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def createConnectionApiKeyAuthRequestParameters(
      apiKeyName: Option[String] = None,
      apiKeyValue: Option[String] = None
    ): CreateConnectionApiKeyAuthRequestParameters =
      CreateConnectionApiKeyAuthRequestParameters
        .builder
        .ifSome(apiKeyName)(_.apiKeyName(_))
        .ifSome(apiKeyValue)(_.apiKeyValue(_))
        .build

    def createConnectionAuthRequestParameters(
      basicAuthParameters: Option[CreateConnectionBasicAuthRequestParameters] = None,
      oAuthParameters: Option[CreateConnectionOAuthRequestParameters] = None,
      apiKeyAuthParameters: Option[CreateConnectionApiKeyAuthRequestParameters] = None,
      invocationHttpParameters: Option[ConnectionHttpParameters] = None
    ): CreateConnectionAuthRequestParameters =
      CreateConnectionAuthRequestParameters
        .builder
        .ifSome(basicAuthParameters)(_.basicAuthParameters(_))
        .ifSome(oAuthParameters)(_.oAuthParameters(_))
        .ifSome(apiKeyAuthParameters)(_.apiKeyAuthParameters(_))
        .ifSome(invocationHttpParameters)(_.invocationHttpParameters(_))
        .build

    def createConnectionBasicAuthRequestParameters(
      username: Option[String] = None,
      password: Option[String] = None
    ): CreateConnectionBasicAuthRequestParameters =
      CreateConnectionBasicAuthRequestParameters
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def createConnectionOAuthClientRequestParameters(
      clientID: Option[String] = None,
      clientSecret: Option[String] = None
    ): CreateConnectionOAuthClientRequestParameters =
      CreateConnectionOAuthClientRequestParameters
        .builder
        .ifSome(clientID)(_.clientID(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .build

    def createConnectionOAuthRequestParameters(
      clientParameters: Option[CreateConnectionOAuthClientRequestParameters] = None,
      authorizationEndpoint: Option[String] = None,
      httpMethod: Option[String] = None,
      oAuthHttpParameters: Option[ConnectionHttpParameters] = None
    ): CreateConnectionOAuthRequestParameters =
      CreateConnectionOAuthRequestParameters
        .builder
        .ifSome(clientParameters)(_.clientParameters(_))
        .ifSome(authorizationEndpoint)(_.authorizationEndpoint(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(oAuthHttpParameters)(_.oAuthHttpParameters(_))
        .build

    def createConnectionRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      authorizationType: Option[String] = None,
      authParameters: Option[CreateConnectionAuthRequestParameters] = None
    ): CreateConnectionRequest =
      CreateConnectionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authParameters)(_.authParameters(_))
        .build

    def createConnectionResponse(
      connectionArn: Option[String] = None,
      connectionState: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): CreateConnectionResponse =
      CreateConnectionResponse
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def createEventBusRequest(
      name: Option[String] = None,
      eventSourceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateEventBusRequest =
      CreateEventBusRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventSourceName)(_.eventSourceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEventBusResponse(
      eventBusArn: Option[String] = None
    ): CreateEventBusResponse =
      CreateEventBusResponse
        .builder
        .ifSome(eventBusArn)(_.eventBusArn(_))
        .build

    def createPartnerEventSourceRequest(
      name: Option[String] = None,
      account: Option[String] = None
    ): CreatePartnerEventSourceRequest =
      CreatePartnerEventSourceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(account)(_.account(_))
        .build

    def createPartnerEventSourceResponse(
      eventSourceArn: Option[String] = None
    ): CreatePartnerEventSourceResponse =
      CreatePartnerEventSourceResponse
        .builder
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .build

    def deactivateEventSourceRequest(
      name: Option[String] = None
    ): DeactivateEventSourceRequest =
      DeactivateEventSourceRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deadLetterConfig(
      arn: Option[String] = None
    ): DeadLetterConfig =
      DeadLetterConfig
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deauthorizeConnectionRequest(
      name: Option[String] = None
    ): DeauthorizeConnectionRequest =
      DeauthorizeConnectionRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deauthorizeConnectionResponse(
      connectionArn: Option[String] = None,
      connectionState: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastAuthorizedTime: Option[Timestamp] = None
    ): DeauthorizeConnectionResponse =
      DeauthorizeConnectionResponse
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastAuthorizedTime)(_.lastAuthorizedTime(_))
        .build

    def deleteApiDestinationRequest(
      name: Option[String] = None
    ): DeleteApiDestinationRequest =
      DeleteApiDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteApiDestinationResponse(

    ): DeleteApiDestinationResponse =
      DeleteApiDestinationResponse
        .builder

        .build

    def deleteArchiveRequest(
      archiveName: Option[String] = None
    ): DeleteArchiveRequest =
      DeleteArchiveRequest
        .builder
        .ifSome(archiveName)(_.archiveName(_))
        .build

    def deleteArchiveResponse(

    ): DeleteArchiveResponse =
      DeleteArchiveResponse
        .builder

        .build

    def deleteConnectionRequest(
      name: Option[String] = None
    ): DeleteConnectionRequest =
      DeleteConnectionRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteConnectionResponse(
      connectionArn: Option[String] = None,
      connectionState: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastAuthorizedTime: Option[Timestamp] = None
    ): DeleteConnectionResponse =
      DeleteConnectionResponse
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastAuthorizedTime)(_.lastAuthorizedTime(_))
        .build

    def deleteEventBusRequest(
      name: Option[String] = None
    ): DeleteEventBusRequest =
      DeleteEventBusRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deletePartnerEventSourceRequest(
      name: Option[String] = None,
      account: Option[String] = None
    ): DeletePartnerEventSourceRequest =
      DeletePartnerEventSourceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(account)(_.account(_))
        .build

    def deleteRuleRequest(
      name: Option[String] = None,
      eventBusName: Option[String] = None,
      force: Option[Boolean] = None
    ): DeleteRuleRequest =
      DeleteRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(force)(_.force(_))
        .build

    def describeApiDestinationRequest(
      name: Option[String] = None
    ): DescribeApiDestinationRequest =
      DescribeApiDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeApiDestinationResponse(
      apiDestinationArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      apiDestinationState: Option[String] = None,
      connectionArn: Option[String] = None,
      invocationEndpoint: Option[String] = None,
      httpMethod: Option[String] = None,
      invocationRateLimitPerSecond: Option[Int] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): DescribeApiDestinationResponse =
      DescribeApiDestinationResponse
        .builder
        .ifSome(apiDestinationArn)(_.apiDestinationArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(apiDestinationState)(_.apiDestinationState(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(invocationEndpoint)(_.invocationEndpoint(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(invocationRateLimitPerSecond)(_.invocationRateLimitPerSecond(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def describeArchiveRequest(
      archiveName: Option[String] = None
    ): DescribeArchiveRequest =
      DescribeArchiveRequest
        .builder
        .ifSome(archiveName)(_.archiveName(_))
        .build

    def describeArchiveResponse(
      archiveArn: Option[String] = None,
      archiveName: Option[String] = None,
      eventSourceArn: Option[String] = None,
      description: Option[String] = None,
      eventPattern: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      retentionDays: Option[Int] = None,
      sizeBytes: Option[Long] = None,
      eventCount: Option[Long] = None,
      creationTime: Option[Timestamp] = None
    ): DescribeArchiveResponse =
      DescribeArchiveResponse
        .builder
        .ifSome(archiveArn)(_.archiveArn(_))
        .ifSome(archiveName)(_.archiveName(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventPattern)(_.eventPattern(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(retentionDays)(_.retentionDays(_))
        .ifSome(sizeBytes)(_.sizeBytes(_))
        .ifSome(eventCount)(_.eventCount(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def describeConnectionRequest(
      name: Option[String] = None
    ): DescribeConnectionRequest =
      DescribeConnectionRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeConnectionResponse(
      connectionArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      connectionState: Option[String] = None,
      stateReason: Option[String] = None,
      authorizationType: Option[String] = None,
      secretArn: Option[String] = None,
      authParameters: Option[ConnectionAuthResponseParameters] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastAuthorizedTime: Option[Timestamp] = None
    ): DescribeConnectionResponse =
      DescribeConnectionResponse
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(authParameters)(_.authParameters(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastAuthorizedTime)(_.lastAuthorizedTime(_))
        .build

    def describeEventBusRequest(
      name: Option[String] = None
    ): DescribeEventBusRequest =
      DescribeEventBusRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeEventBusResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      policy: Option[String] = None
    ): DescribeEventBusResponse =
      DescribeEventBusResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def describeEventSourceRequest(
      name: Option[String] = None
    ): DescribeEventSourceRequest =
      DescribeEventSourceRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeEventSourceResponse(
      arn: Option[String] = None,
      createdBy: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      expirationTime: Option[Timestamp] = None,
      name: Option[String] = None,
      state: Option[String] = None
    ): DescribeEventSourceResponse =
      DescribeEventSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .build

    def describePartnerEventSourceRequest(
      name: Option[String] = None
    ): DescribePartnerEventSourceRequest =
      DescribePartnerEventSourceRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describePartnerEventSourceResponse(
      arn: Option[String] = None,
      name: Option[String] = None
    ): DescribePartnerEventSourceResponse =
      DescribePartnerEventSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def describeReplayRequest(
      replayName: Option[String] = None
    ): DescribeReplayRequest =
      DescribeReplayRequest
        .builder
        .ifSome(replayName)(_.replayName(_))
        .build

    def describeReplayResponse(
      replayName: Option[String] = None,
      replayArn: Option[String] = None,
      description: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      eventSourceArn: Option[String] = None,
      destination: Option[ReplayDestination] = None,
      eventStartTime: Option[Timestamp] = None,
      eventEndTime: Option[Timestamp] = None,
      eventLastReplayedTime: Option[Timestamp] = None,
      replayStartTime: Option[Timestamp] = None,
      replayEndTime: Option[Timestamp] = None
    ): DescribeReplayResponse =
      DescribeReplayResponse
        .builder
        .ifSome(replayName)(_.replayName(_))
        .ifSome(replayArn)(_.replayArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(eventStartTime)(_.eventStartTime(_))
        .ifSome(eventEndTime)(_.eventEndTime(_))
        .ifSome(eventLastReplayedTime)(_.eventLastReplayedTime(_))
        .ifSome(replayStartTime)(_.replayStartTime(_))
        .ifSome(replayEndTime)(_.replayEndTime(_))
        .build

    def describeRuleRequest(
      name: Option[String] = None,
      eventBusName: Option[String] = None
    ): DescribeRuleRequest =
      DescribeRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .build

    def describeRuleResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      eventPattern: Option[String] = None,
      scheduleExpression: Option[String] = None,
      state: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      managedBy: Option[String] = None,
      eventBusName: Option[String] = None,
      createdBy: Option[String] = None
    ): DescribeRuleResponse =
      DescribeRuleResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(eventPattern)(_.eventPattern(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(state)(_.state(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(managedBy)(_.managedBy(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def disableRuleRequest(
      name: Option[String] = None,
      eventBusName: Option[String] = None
    ): DisableRuleRequest =
      DisableRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .build

    def ecsParameters(
      taskDefinitionArn: Option[String] = None,
      taskCount: Option[Int] = None,
      launchType: Option[String] = None,
      networkConfiguration: Option[NetworkConfiguration] = None,
      platformVersion: Option[String] = None,
      group: Option[String] = None
    ): EcsParameters =
      EcsParameters
        .builder
        .ifSome(taskDefinitionArn)(_.taskDefinitionArn(_))
        .ifSome(taskCount)(_.taskCount(_))
        .ifSome(launchType)(_.launchType(_))
        .ifSome(networkConfiguration)(_.networkConfiguration(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(group)(_.group(_))
        .build

    def enableRuleRequest(
      name: Option[String] = None,
      eventBusName: Option[String] = None
    ): EnableRuleRequest =
      EnableRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .build

    def eventBus(
      name: Option[String] = None,
      arn: Option[String] = None,
      policy: Option[String] = None
    ): EventBus =
      EventBus
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def eventSource(
      arn: Option[String] = None,
      createdBy: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      expirationTime: Option[Timestamp] = None,
      name: Option[String] = None,
      state: Option[String] = None
    ): EventSource =
      EventSource
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .build

    def httpParameters(
      pathParameterValues: Option[List[PathParameter]] = None,
      headerParameters: Option[HeaderParametersMap] = None,
      queryStringParameters: Option[QueryStringParametersMap] = None
    ): HttpParameters =
      HttpParameters
        .builder
        .ifSome(pathParameterValues)(_.pathParameterValues(_))
        .ifSome(headerParameters)(_.headerParameters(_))
        .ifSome(queryStringParameters)(_.queryStringParameters(_))
        .build

    def illegalStatusException(

    ): IllegalStatusException =
      IllegalStatusException
        .builder

        .build

    def inputTransformer(
      inputPathsMap: Option[TransformerPaths] = None,
      inputTemplate: Option[String] = None
    ): InputTransformer =
      InputTransformer
        .builder
        .ifSome(inputPathsMap)(_.inputPathsMap(_))
        .ifSome(inputTemplate)(_.inputTemplate(_))
        .build

    def internalException(

    ): InternalException =
      InternalException
        .builder

        .build

    def invalidEventPatternException(

    ): InvalidEventPatternException =
      InvalidEventPatternException
        .builder

        .build

    def invalidStateException(

    ): InvalidStateException =
      InvalidStateException
        .builder

        .build

    def kinesisParameters(
      partitionKeyPath: Option[String] = None
    ): KinesisParameters =
      KinesisParameters
        .builder
        .ifSome(partitionKeyPath)(_.partitionKeyPath(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listApiDestinationsRequest(
      namePrefix: Option[String] = None,
      connectionArn: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListApiDestinationsRequest =
      ListApiDestinationsRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listApiDestinationsResponse(
      apiDestinations: Option[List[ApiDestination]] = None,
      nextToken: Option[String] = None
    ): ListApiDestinationsResponse =
      ListApiDestinationsResponse
        .builder
        .ifSome(apiDestinations)(_.apiDestinations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listArchivesRequest(
      namePrefix: Option[String] = None,
      eventSourceArn: Option[String] = None,
      state: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListArchivesRequest =
      ListArchivesRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listArchivesResponse(
      archives: Option[List[Archive]] = None,
      nextToken: Option[String] = None
    ): ListArchivesResponse =
      ListArchivesResponse
        .builder
        .ifSome(archives)(_.archives(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConnectionsRequest(
      namePrefix: Option[String] = None,
      connectionState: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListConnectionsRequest =
      ListConnectionsRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listConnectionsResponse(
      connections: Option[List[Connection]] = None,
      nextToken: Option[String] = None
    ): ListConnectionsResponse =
      ListConnectionsResponse
        .builder
        .ifSome(connections)(_.connections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventBusesRequest(
      namePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListEventBusesRequest =
      ListEventBusesRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listEventBusesResponse(
      eventBuses: Option[List[EventBus]] = None,
      nextToken: Option[String] = None
    ): ListEventBusesResponse =
      ListEventBusesResponse
        .builder
        .ifSome(eventBuses)(_.eventBuses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventSourcesRequest(
      namePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListEventSourcesRequest =
      ListEventSourcesRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listEventSourcesResponse(
      eventSources: Option[List[EventSource]] = None,
      nextToken: Option[String] = None
    ): ListEventSourcesResponse =
      ListEventSourcesResponse
        .builder
        .ifSome(eventSources)(_.eventSources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPartnerEventSourceAccountsRequest(
      eventSourceName: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListPartnerEventSourceAccountsRequest =
      ListPartnerEventSourceAccountsRequest
        .builder
        .ifSome(eventSourceName)(_.eventSourceName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listPartnerEventSourceAccountsResponse(
      partnerEventSourceAccounts: Option[List[PartnerEventSourceAccount]] = None,
      nextToken: Option[String] = None
    ): ListPartnerEventSourceAccountsResponse =
      ListPartnerEventSourceAccountsResponse
        .builder
        .ifSome(partnerEventSourceAccounts)(_.partnerEventSourceAccounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPartnerEventSourcesRequest(
      namePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListPartnerEventSourcesRequest =
      ListPartnerEventSourcesRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listPartnerEventSourcesResponse(
      partnerEventSources: Option[List[PartnerEventSource]] = None,
      nextToken: Option[String] = None
    ): ListPartnerEventSourcesResponse =
      ListPartnerEventSourcesResponse
        .builder
        .ifSome(partnerEventSources)(_.partnerEventSources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listReplaysRequest(
      namePrefix: Option[String] = None,
      state: Option[String] = None,
      eventSourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListReplaysRequest =
      ListReplaysRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(state)(_.state(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listReplaysResponse(
      replays: Option[List[Replay]] = None,
      nextToken: Option[String] = None
    ): ListReplaysResponse =
      ListReplaysResponse
        .builder
        .ifSome(replays)(_.replays(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRuleNamesByTargetRequest(
      targetArn: Option[String] = None,
      eventBusName: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListRuleNamesByTargetRequest =
      ListRuleNamesByTargetRequest
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listRuleNamesByTargetResponse(
      ruleNames: Option[List[RuleName]] = None,
      nextToken: Option[String] = None
    ): ListRuleNamesByTargetResponse =
      ListRuleNamesByTargetResponse
        .builder
        .ifSome(ruleNames)(_.ruleNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRulesRequest(
      namePrefix: Option[String] = None,
      eventBusName: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListRulesRequest =
      ListRulesRequest
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listRulesResponse(
      rules: Option[List[Rule]] = None,
      nextToken: Option[String] = None
    ): ListRulesResponse =
      ListRulesResponse
        .builder
        .ifSome(rules)(_.rules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listTargetsByRuleRequest(
      rule: Option[String] = None,
      eventBusName: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): ListTargetsByRuleRequest =
      ListTargetsByRuleRequest
        .builder
        .ifSome(rule)(_.rule(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTargetsByRuleResponse(
      targets: Option[List[Target]] = None,
      nextToken: Option[String] = None
    ): ListTargetsByRuleResponse =
      ListTargetsByRuleResponse
        .builder
        .ifSome(targets)(_.targets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def managedRuleException(

    ): ManagedRuleException =
      ManagedRuleException
        .builder

        .build

    def networkConfiguration(
      awsvpcConfiguration: Option[AwsVpcConfiguration] = None
    ): NetworkConfiguration =
      NetworkConfiguration
        .builder
        .ifSome(awsvpcConfiguration)(_.awsvpcConfiguration(_))
        .build

    def operationDisabledException(

    ): OperationDisabledException =
      OperationDisabledException
        .builder

        .build

    def partnerEventSource(
      arn: Option[String] = None,
      name: Option[String] = None
    ): PartnerEventSource =
      PartnerEventSource
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def partnerEventSourceAccount(
      account: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      expirationTime: Option[Timestamp] = None,
      state: Option[String] = None
    ): PartnerEventSourceAccount =
      PartnerEventSourceAccount
        .builder
        .ifSome(account)(_.account(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(state)(_.state(_))
        .build

    def policyLengthExceededException(

    ): PolicyLengthExceededException =
      PolicyLengthExceededException
        .builder

        .build

    def putEventsRequest(
      entries: Option[List[PutEventsRequestEntry]] = None
    ): PutEventsRequest =
      PutEventsRequest
        .builder
        .ifSome(entries)(_.entries(_))
        .build

    def putEventsRequestEntry(
      time: Option[EventTime] = None,
      source: Option[String] = None,
      resources: Option[List[EventResource]] = None,
      detailType: Option[String] = None,
      detail: Option[String] = None,
      eventBusName: Option[String] = None,
      traceHeader: Option[String] = None
    ): PutEventsRequestEntry =
      PutEventsRequestEntry
        .builder
        .ifSome(time)(_.time(_))
        .ifSome(source)(_.source(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(detailType)(_.detailType(_))
        .ifSome(detail)(_.detail(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(traceHeader)(_.traceHeader(_))
        .build

    def putEventsResponse(
      failedEntryCount: Option[Int] = None,
      entries: Option[List[PutEventsResultEntry]] = None
    ): PutEventsResponse =
      PutEventsResponse
        .builder
        .ifSome(failedEntryCount)(_.failedEntryCount(_))
        .ifSome(entries)(_.entries(_))
        .build

    def putEventsResultEntry(
      eventId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): PutEventsResultEntry =
      PutEventsResultEntry
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def putPartnerEventsRequest(
      entries: Option[List[PutPartnerEventsRequestEntry]] = None
    ): PutPartnerEventsRequest =
      PutPartnerEventsRequest
        .builder
        .ifSome(entries)(_.entries(_))
        .build

    def putPartnerEventsRequestEntry(
      time: Option[EventTime] = None,
      source: Option[String] = None,
      resources: Option[List[EventResource]] = None,
      detailType: Option[String] = None,
      detail: Option[String] = None
    ): PutPartnerEventsRequestEntry =
      PutPartnerEventsRequestEntry
        .builder
        .ifSome(time)(_.time(_))
        .ifSome(source)(_.source(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(detailType)(_.detailType(_))
        .ifSome(detail)(_.detail(_))
        .build

    def putPartnerEventsResponse(
      failedEntryCount: Option[Int] = None,
      entries: Option[List[PutPartnerEventsResultEntry]] = None
    ): PutPartnerEventsResponse =
      PutPartnerEventsResponse
        .builder
        .ifSome(failedEntryCount)(_.failedEntryCount(_))
        .ifSome(entries)(_.entries(_))
        .build

    def putPartnerEventsResultEntry(
      eventId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): PutPartnerEventsResultEntry =
      PutPartnerEventsResultEntry
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def putPermissionRequest(
      eventBusName: Option[String] = None,
      action: Option[String] = None,
      principal: Option[String] = None,
      statementId: Option[String] = None,
      condition: Option[Condition] = None,
      policy: Option[String] = None
    ): PutPermissionRequest =
      PutPermissionRequest
        .builder
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(action)(_.action(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putRuleRequest(
      name: Option[String] = None,
      scheduleExpression: Option[String] = None,
      eventPattern: Option[String] = None,
      state: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      eventBusName: Option[String] = None
    ): PutRuleRequest =
      PutRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(eventPattern)(_.eventPattern(_))
        .ifSome(state)(_.state(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .build

    def putRuleResponse(
      ruleArn: Option[String] = None
    ): PutRuleResponse =
      PutRuleResponse
        .builder
        .ifSome(ruleArn)(_.ruleArn(_))
        .build

    def putTargetsRequest(
      rule: Option[String] = None,
      eventBusName: Option[String] = None,
      targets: Option[List[Target]] = None
    ): PutTargetsRequest =
      PutTargetsRequest
        .builder
        .ifSome(rule)(_.rule(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(targets)(_.targets(_))
        .build

    def putTargetsResponse(
      failedEntryCount: Option[Int] = None,
      failedEntries: Option[List[PutTargetsResultEntry]] = None
    ): PutTargetsResponse =
      PutTargetsResponse
        .builder
        .ifSome(failedEntryCount)(_.failedEntryCount(_))
        .ifSome(failedEntries)(_.failedEntries(_))
        .build

    def putTargetsResultEntry(
      targetId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): PutTargetsResultEntry =
      PutTargetsResultEntry
        .builder
        .ifSome(targetId)(_.targetId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def redshiftDataParameters(
      secretManagerArn: Option[String] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      sql: Option[String] = None,
      statementName: Option[String] = None,
      withEvent: Option[Boolean] = None
    ): RedshiftDataParameters =
      RedshiftDataParameters
        .builder
        .ifSome(secretManagerArn)(_.secretManagerArn(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(sql)(_.sql(_))
        .ifSome(statementName)(_.statementName(_))
        .ifSome(withEvent)(_.withEvent(_))
        .build

    def removePermissionRequest(
      statementId: Option[String] = None,
      removeAllPermissions: Option[Boolean] = None,
      eventBusName: Option[String] = None
    ): RemovePermissionRequest =
      RemovePermissionRequest
        .builder
        .ifSome(statementId)(_.statementId(_))
        .ifSome(removeAllPermissions)(_.removeAllPermissions(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .build

    def removeTargetsRequest(
      rule: Option[String] = None,
      eventBusName: Option[String] = None,
      ids: Option[List[TargetId]] = None,
      force: Option[Boolean] = None
    ): RemoveTargetsRequest =
      RemoveTargetsRequest
        .builder
        .ifSome(rule)(_.rule(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .ifSome(ids)(_.ids(_))
        .ifSome(force)(_.force(_))
        .build

    def removeTargetsResponse(
      failedEntryCount: Option[Int] = None,
      failedEntries: Option[List[RemoveTargetsResultEntry]] = None
    ): RemoveTargetsResponse =
      RemoveTargetsResponse
        .builder
        .ifSome(failedEntryCount)(_.failedEntryCount(_))
        .ifSome(failedEntries)(_.failedEntries(_))
        .build

    def removeTargetsResultEntry(
      targetId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): RemoveTargetsResultEntry =
      RemoveTargetsResultEntry
        .builder
        .ifSome(targetId)(_.targetId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def replay(
      replayName: Option[String] = None,
      eventSourceArn: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      eventStartTime: Option[Timestamp] = None,
      eventEndTime: Option[Timestamp] = None,
      eventLastReplayedTime: Option[Timestamp] = None,
      replayStartTime: Option[Timestamp] = None,
      replayEndTime: Option[Timestamp] = None
    ): Replay =
      Replay
        .builder
        .ifSome(replayName)(_.replayName(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(eventStartTime)(_.eventStartTime(_))
        .ifSome(eventEndTime)(_.eventEndTime(_))
        .ifSome(eventLastReplayedTime)(_.eventLastReplayedTime(_))
        .ifSome(replayStartTime)(_.replayStartTime(_))
        .ifSome(replayEndTime)(_.replayEndTime(_))
        .build

    def replayDestination(
      arn: Option[String] = None,
      filterArns: Option[List[Arn]] = None
    ): ReplayDestination =
      ReplayDestination
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(filterArns)(_.filterArns(_))
        .build

    def resourceAlreadyExistsException(

    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def retryPolicy(
      maximumRetryAttempts: Option[Int] = None,
      maximumEventAgeInSeconds: Option[Int] = None
    ): RetryPolicy =
      RetryPolicy
        .builder
        .ifSome(maximumRetryAttempts)(_.maximumRetryAttempts(_))
        .ifSome(maximumEventAgeInSeconds)(_.maximumEventAgeInSeconds(_))
        .build

    def rule(
      name: Option[String] = None,
      arn: Option[String] = None,
      eventPattern: Option[String] = None,
      state: Option[String] = None,
      description: Option[String] = None,
      scheduleExpression: Option[String] = None,
      roleArn: Option[String] = None,
      managedBy: Option[String] = None,
      eventBusName: Option[String] = None
    ): Rule =
      Rule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(eventPattern)(_.eventPattern(_))
        .ifSome(state)(_.state(_))
        .ifSome(description)(_.description(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(managedBy)(_.managedBy(_))
        .ifSome(eventBusName)(_.eventBusName(_))
        .build

    def runCommandParameters(
      runCommandTargets: Option[List[RunCommandTarget]] = None
    ): RunCommandParameters =
      RunCommandParameters
        .builder
        .ifSome(runCommandTargets)(_.runCommandTargets(_))
        .build

    def runCommandTarget(
      key: Option[String] = None,
      values: Option[List[RunCommandTargetValue]] = None
    ): RunCommandTarget =
      RunCommandTarget
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def sageMakerPipelineParameter(
      name: Option[String] = None,
      value: Option[String] = None
    ): SageMakerPipelineParameter =
      SageMakerPipelineParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def sageMakerPipelineParameters(
      pipelineParameterList: Option[List[SageMakerPipelineParameter]] = None
    ): SageMakerPipelineParameters =
      SageMakerPipelineParameters
        .builder
        .ifSome(pipelineParameterList)(_.pipelineParameterList(_))
        .build

    def sqsParameters(
      messageGroupId: Option[String] = None
    ): SqsParameters =
      SqsParameters
        .builder
        .ifSome(messageGroupId)(_.messageGroupId(_))
        .build

    def startReplayRequest(
      replayName: Option[String] = None,
      description: Option[String] = None,
      eventSourceArn: Option[String] = None,
      eventStartTime: Option[Timestamp] = None,
      eventEndTime: Option[Timestamp] = None,
      destination: Option[ReplayDestination] = None
    ): StartReplayRequest =
      StartReplayRequest
        .builder
        .ifSome(replayName)(_.replayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventSourceArn)(_.eventSourceArn(_))
        .ifSome(eventStartTime)(_.eventStartTime(_))
        .ifSome(eventEndTime)(_.eventEndTime(_))
        .ifSome(destination)(_.destination(_))
        .build

    def startReplayResponse(
      replayArn: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      replayStartTime: Option[Timestamp] = None
    ): StartReplayResponse =
      StartReplayResponse
        .builder
        .ifSome(replayArn)(_.replayArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(replayStartTime)(_.replayStartTime(_))
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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def target(
      id: Option[String] = None,
      arn: Option[String] = None,
      roleArn: Option[String] = None,
      input: Option[String] = None,
      inputPath: Option[String] = None,
      inputTransformer: Option[InputTransformer] = None,
      kinesisParameters: Option[KinesisParameters] = None,
      runCommandParameters: Option[RunCommandParameters] = None,
      ecsParameters: Option[EcsParameters] = None,
      batchParameters: Option[BatchParameters] = None,
      sqsParameters: Option[SqsParameters] = None,
      httpParameters: Option[HttpParameters] = None,
      redshiftDataParameters: Option[RedshiftDataParameters] = None,
      sageMakerPipelineParameters: Option[SageMakerPipelineParameters] = None,
      deadLetterConfig: Option[DeadLetterConfig] = None,
      retryPolicy: Option[RetryPolicy] = None
    ): Target =
      Target
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputPath)(_.inputPath(_))
        .ifSome(inputTransformer)(_.inputTransformer(_))
        .ifSome(kinesisParameters)(_.kinesisParameters(_))
        .ifSome(runCommandParameters)(_.runCommandParameters(_))
        .ifSome(ecsParameters)(_.ecsParameters(_))
        .ifSome(batchParameters)(_.batchParameters(_))
        .ifSome(sqsParameters)(_.sqsParameters(_))
        .ifSome(httpParameters)(_.httpParameters(_))
        .ifSome(redshiftDataParameters)(_.redshiftDataParameters(_))
        .ifSome(sageMakerPipelineParameters)(_.sageMakerPipelineParameters(_))
        .ifSome(deadLetterConfig)(_.deadLetterConfig(_))
        .ifSome(retryPolicy)(_.retryPolicy(_))
        .build

    def testEventPatternRequest(
      eventPattern: Option[String] = None,
      event: Option[String] = None
    ): TestEventPatternRequest =
      TestEventPatternRequest
        .builder
        .ifSome(eventPattern)(_.eventPattern(_))
        .ifSome(event)(_.event(_))
        .build

    def testEventPatternResponse(
      result: Option[Boolean] = None
    ): TestEventPatternResponse =
      TestEventPatternResponse
        .builder
        .ifSome(result)(_.result(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateApiDestinationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      connectionArn: Option[String] = None,
      invocationEndpoint: Option[String] = None,
      httpMethod: Option[String] = None,
      invocationRateLimitPerSecond: Option[Int] = None
    ): UpdateApiDestinationRequest =
      UpdateApiDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(invocationEndpoint)(_.invocationEndpoint(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(invocationRateLimitPerSecond)(_.invocationRateLimitPerSecond(_))
        .build

    def updateApiDestinationResponse(
      apiDestinationArn: Option[String] = None,
      apiDestinationState: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None
    ): UpdateApiDestinationResponse =
      UpdateApiDestinationResponse
        .builder
        .ifSome(apiDestinationArn)(_.apiDestinationArn(_))
        .ifSome(apiDestinationState)(_.apiDestinationState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def updateArchiveRequest(
      archiveName: Option[String] = None,
      description: Option[String] = None,
      eventPattern: Option[String] = None,
      retentionDays: Option[Int] = None
    ): UpdateArchiveRequest =
      UpdateArchiveRequest
        .builder
        .ifSome(archiveName)(_.archiveName(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventPattern)(_.eventPattern(_))
        .ifSome(retentionDays)(_.retentionDays(_))
        .build

    def updateArchiveResponse(
      archiveArn: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): UpdateArchiveResponse =
      UpdateArchiveResponse
        .builder
        .ifSome(archiveArn)(_.archiveArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def updateConnectionApiKeyAuthRequestParameters(
      apiKeyName: Option[String] = None,
      apiKeyValue: Option[String] = None
    ): UpdateConnectionApiKeyAuthRequestParameters =
      UpdateConnectionApiKeyAuthRequestParameters
        .builder
        .ifSome(apiKeyName)(_.apiKeyName(_))
        .ifSome(apiKeyValue)(_.apiKeyValue(_))
        .build

    def updateConnectionAuthRequestParameters(
      basicAuthParameters: Option[UpdateConnectionBasicAuthRequestParameters] = None,
      oAuthParameters: Option[UpdateConnectionOAuthRequestParameters] = None,
      apiKeyAuthParameters: Option[UpdateConnectionApiKeyAuthRequestParameters] = None,
      invocationHttpParameters: Option[ConnectionHttpParameters] = None
    ): UpdateConnectionAuthRequestParameters =
      UpdateConnectionAuthRequestParameters
        .builder
        .ifSome(basicAuthParameters)(_.basicAuthParameters(_))
        .ifSome(oAuthParameters)(_.oAuthParameters(_))
        .ifSome(apiKeyAuthParameters)(_.apiKeyAuthParameters(_))
        .ifSome(invocationHttpParameters)(_.invocationHttpParameters(_))
        .build

    def updateConnectionBasicAuthRequestParameters(
      username: Option[String] = None,
      password: Option[String] = None
    ): UpdateConnectionBasicAuthRequestParameters =
      UpdateConnectionBasicAuthRequestParameters
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def updateConnectionOAuthClientRequestParameters(
      clientID: Option[String] = None,
      clientSecret: Option[String] = None
    ): UpdateConnectionOAuthClientRequestParameters =
      UpdateConnectionOAuthClientRequestParameters
        .builder
        .ifSome(clientID)(_.clientID(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .build

    def updateConnectionOAuthRequestParameters(
      clientParameters: Option[UpdateConnectionOAuthClientRequestParameters] = None,
      authorizationEndpoint: Option[String] = None,
      httpMethod: Option[String] = None,
      oAuthHttpParameters: Option[ConnectionHttpParameters] = None
    ): UpdateConnectionOAuthRequestParameters =
      UpdateConnectionOAuthRequestParameters
        .builder
        .ifSome(clientParameters)(_.clientParameters(_))
        .ifSome(authorizationEndpoint)(_.authorizationEndpoint(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(oAuthHttpParameters)(_.oAuthHttpParameters(_))
        .build

    def updateConnectionRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      authorizationType: Option[String] = None,
      authParameters: Option[UpdateConnectionAuthRequestParameters] = None
    ): UpdateConnectionRequest =
      UpdateConnectionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authParameters)(_.authParameters(_))
        .build

    def updateConnectionResponse(
      connectionArn: Option[String] = None,
      connectionState: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      lastAuthorizedTime: Option[Timestamp] = None
    ): UpdateConnectionResponse =
      UpdateConnectionResponse
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(lastAuthorizedTime)(_.lastAuthorizedTime(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
