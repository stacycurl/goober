package goober.hi

import goober.free.apigatewayv2.ApiGatewayV2IO
import software.amazon.awssdk.services.apigatewayv2.model._


object apigatewayv2 {
  import goober.free.{apigatewayv2 ⇒ free}

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

    def accessLogSettings(
      destinationArn: Option[String] = None,
      format: Option[String] = None
    ): AccessLogSettings =
      AccessLogSettings
        .builder
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(format)(_.format(_))
        .build

    def api(
      apiEndpoint: Option[String] = None,
      apiGatewayManaged: Option[Boolean] = None,
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      createdDate: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      importInfo: Option[List[__string]] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      version: Option[String] = None,
      warnings: Option[List[__string]] = None
    ): Api =
      Api
        .builder
        .ifSome(apiEndpoint)(_.apiEndpoint(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(importInfo)(_.importInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(version)(_.version(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def apiMapping(
      apiId: Option[String] = None,
      apiMappingId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      stage: Option[String] = None
    ): ApiMapping =
      ApiMapping
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingId)(_.apiMappingId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(stage)(_.stage(_))
        .build

    def apiMappings(
      items: Option[List[ApiMapping]] = None,
      nextToken: Option[String] = None
    ): ApiMappings =
      ApiMappings
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def apis(
      items: Option[List[Api]] = None,
      nextToken: Option[String] = None
    ): Apis =
      Apis
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def authorizer(
      authorizerCredentialsArn: Option[String] = None,
      authorizerId: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): Authorizer =
      Authorizer
        .builder
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def authorizers(
      items: Option[List[Authorizer]] = None,
      nextToken: Option[String] = None
    ): Authorizers =
      Authorizers
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

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cors(
      allowCredentials: Option[Boolean] = None,
      allowHeaders: Option[List[__string]] = None,
      allowMethods: Option[List[StringWithLengthBetween1And64]] = None,
      allowOrigins: Option[List[__string]] = None,
      exposeHeaders: Option[List[__string]] = None,
      maxAge: Option[Int] = None
    ): Cors =
      Cors
        .builder
        .ifSome(allowCredentials)(_.allowCredentials(_))
        .ifSome(allowHeaders)(_.allowHeaders(_))
        .ifSome(allowMethods)(_.allowMethods(_))
        .ifSome(allowOrigins)(_.allowOrigins(_))
        .ifSome(exposeHeaders)(_.exposeHeaders(_))
        .ifSome(maxAge)(_.maxAge(_))
        .build

    def createApiInput(
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeKey: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      target: Option[String] = None,
      version: Option[String] = None
    ): CreateApiInput =
      CreateApiInput
        .builder
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(target)(_.target(_))
        .ifSome(version)(_.version(_))
        .build

    def createApiMappingInput(
      apiId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      stage: Option[String] = None
    ): CreateApiMappingInput =
      CreateApiMappingInput
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(stage)(_.stage(_))
        .build

    def createApiMappingRequest(
      apiId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      domainName: Option[String] = None,
      stage: Option[String] = None
    ): CreateApiMappingRequest =
      CreateApiMappingRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(stage)(_.stage(_))
        .build

    def createApiMappingResponse(
      apiId: Option[String] = None,
      apiMappingId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      stage: Option[String] = None
    ): CreateApiMappingResponse =
      CreateApiMappingResponse
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingId)(_.apiMappingId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(stage)(_.stage(_))
        .build

    def createApiRequest(
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeKey: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      target: Option[String] = None,
      version: Option[String] = None
    ): CreateApiRequest =
      CreateApiRequest
        .builder
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(target)(_.target(_))
        .ifSome(version)(_.version(_))
        .build

    def createApiResponse(
      apiEndpoint: Option[String] = None,
      apiGatewayManaged: Option[Boolean] = None,
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      createdDate: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      importInfo: Option[List[__string]] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      version: Option[String] = None,
      warnings: Option[List[__string]] = None
    ): CreateApiResponse =
      CreateApiResponse
        .builder
        .ifSome(apiEndpoint)(_.apiEndpoint(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(importInfo)(_.importInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(version)(_.version(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def createAuthorizerInput(
      authorizerCredentialsArn: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): CreateAuthorizerInput =
      CreateAuthorizerInput
        .builder
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def createAuthorizerRequest(
      apiId: Option[String] = None,
      authorizerCredentialsArn: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): CreateAuthorizerRequest =
      CreateAuthorizerRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def createAuthorizerResponse(
      authorizerCredentialsArn: Option[String] = None,
      authorizerId: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): CreateAuthorizerResponse =
      CreateAuthorizerResponse
        .builder
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def createDeploymentInput(
      description: Option[String] = None,
      stageName: Option[String] = None
    ): CreateDeploymentInput =
      CreateDeploymentInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def createDeploymentRequest(
      apiId: Option[String] = None,
      description: Option[String] = None,
      stageName: Option[String] = None
    ): CreateDeploymentRequest =
      CreateDeploymentRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(description)(_.description(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def createDeploymentResponse(
      autoDeployed: Option[Boolean] = None,
      createdDate: Option[__timestampIso8601] = None,
      deploymentId: Option[String] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      description: Option[String] = None
    ): CreateDeploymentResponse =
      CreateDeploymentResponse
        .builder
        .ifSome(autoDeployed)(_.autoDeployed(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(description)(_.description(_))
        .build

    def createDomainNameInput(
      domainName: Option[String] = None,
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthenticationInput] = None,
      tags: Option[Tags] = None
    ): CreateDomainNameInput =
      CreateDomainNameInput
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDomainNameRequest(
      domainName: Option[String] = None,
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthenticationInput] = None,
      tags: Option[Tags] = None
    ): CreateDomainNameRequest =
      CreateDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDomainNameResponse(
      apiMappingSelectionExpression: Option[String] = None,
      domainName: Option[String] = None,
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthentication] = None,
      tags: Option[Tags] = None
    ): CreateDomainNameResponse =
      CreateDomainNameResponse
        .builder
        .ifSome(apiMappingSelectionExpression)(_.apiMappingSelectionExpression(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createIntegrationInput(
      connectionId: Option[String] = None,
      connectionType: Option[String] = None,
      contentHandlingStrategy: Option[String] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      integrationMethod: Option[String] = None,
      integrationSubtype: Option[String] = None,
      integrationType: Option[String] = None,
      integrationUri: Option[String] = None,
      passthroughBehavior: Option[String] = None,
      payloadFormatVersion: Option[String] = None,
      requestParameters: Option[IntegrationParameters] = None,
      requestTemplates: Option[TemplateMap] = None,
      responseParameters: Option[ResponseParameters] = None,
      templateSelectionExpression: Option[String] = None,
      timeoutInMillis: Option[Int] = None,
      tlsConfig: Option[TlsConfigInput] = None
    ): CreateIntegrationInput =
      CreateIntegrationInput
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(integrationMethod)(_.integrationMethod(_))
        .ifSome(integrationSubtype)(_.integrationSubtype(_))
        .ifSome(integrationType)(_.integrationType(_))
        .ifSome(integrationUri)(_.integrationUri(_))
        .ifSome(passthroughBehavior)(_.passthroughBehavior(_))
        .ifSome(payloadFormatVersion)(_.payloadFormatVersion(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestTemplates)(_.requestTemplates(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .ifSome(timeoutInMillis)(_.timeoutInMillis(_))
        .ifSome(tlsConfig)(_.tlsConfig(_))
        .build

    def createIntegrationRequest(
      apiId: Option[String] = None,
      connectionId: Option[String] = None,
      connectionType: Option[String] = None,
      contentHandlingStrategy: Option[String] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      integrationMethod: Option[String] = None,
      integrationSubtype: Option[String] = None,
      integrationType: Option[String] = None,
      integrationUri: Option[String] = None,
      passthroughBehavior: Option[String] = None,
      payloadFormatVersion: Option[String] = None,
      requestParameters: Option[IntegrationParameters] = None,
      requestTemplates: Option[TemplateMap] = None,
      responseParameters: Option[ResponseParameters] = None,
      templateSelectionExpression: Option[String] = None,
      timeoutInMillis: Option[Int] = None,
      tlsConfig: Option[TlsConfigInput] = None
    ): CreateIntegrationRequest =
      CreateIntegrationRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(integrationMethod)(_.integrationMethod(_))
        .ifSome(integrationSubtype)(_.integrationSubtype(_))
        .ifSome(integrationType)(_.integrationType(_))
        .ifSome(integrationUri)(_.integrationUri(_))
        .ifSome(passthroughBehavior)(_.passthroughBehavior(_))
        .ifSome(payloadFormatVersion)(_.payloadFormatVersion(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestTemplates)(_.requestTemplates(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .ifSome(timeoutInMillis)(_.timeoutInMillis(_))
        .ifSome(tlsConfig)(_.tlsConfig(_))
        .build

    def createIntegrationResponseInput(
      contentHandlingStrategy: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): CreateIntegrationResponseInput =
      CreateIntegrationResponseInput
        .builder
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def createIntegrationResponseRequest(
      apiId: Option[String] = None,
      contentHandlingStrategy: Option[String] = None,
      integrationId: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): CreateIntegrationResponseRequest =
      CreateIntegrationResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationId)(_.integrationId(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def createIntegrationResponseResponse(
      contentHandlingStrategy: Option[String] = None,
      integrationResponseId: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): CreateIntegrationResponseResponse =
      CreateIntegrationResponseResponse
        .builder
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationResponseId)(_.integrationResponseId(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def createModelInput(
      contentType: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): CreateModelInput =
      CreateModelInput
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def createModelRequest(
      apiId: Option[String] = None,
      contentType: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): CreateModelRequest =
      CreateModelRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def createModelResponse(
      contentType: Option[String] = None,
      description: Option[String] = None,
      modelId: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): CreateModelResponse =
      CreateModelResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(modelId)(_.modelId(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def createRouteInput(
      apiKeyRequired: Option[Boolean] = None,
      authorizationScopes: Option[List[StringWithLengthBetween1And64]] = None,
      authorizationType: Option[String] = None,
      authorizerId: Option[String] = None,
      modelSelectionExpression: Option[String] = None,
      operationName: Option[String] = None,
      requestModels: Option[RouteModels] = None,
      requestParameters: Option[RouteParameters] = None,
      routeKey: Option[String] = None,
      routeResponseSelectionExpression: Option[String] = None,
      target: Option[String] = None
    ): CreateRouteInput =
      CreateRouteInput
        .builder
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .ifSome(authorizationScopes)(_.authorizationScopes(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(requestModels)(_.requestModels(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeResponseSelectionExpression)(_.routeResponseSelectionExpression(_))
        .ifSome(target)(_.target(_))
        .build

    def createRouteRequest(
      apiId: Option[String] = None,
      apiKeyRequired: Option[Boolean] = None,
      authorizationScopes: Option[List[StringWithLengthBetween1And64]] = None,
      authorizationType: Option[String] = None,
      authorizerId: Option[String] = None,
      modelSelectionExpression: Option[String] = None,
      operationName: Option[String] = None,
      requestModels: Option[RouteModels] = None,
      requestParameters: Option[RouteParameters] = None,
      routeKey: Option[String] = None,
      routeResponseSelectionExpression: Option[String] = None,
      target: Option[String] = None
    ): CreateRouteRequest =
      CreateRouteRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .ifSome(authorizationScopes)(_.authorizationScopes(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(requestModels)(_.requestModels(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeResponseSelectionExpression)(_.routeResponseSelectionExpression(_))
        .ifSome(target)(_.target(_))
        .build

    def createRouteResponseInput(
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeResponseKey: Option[String] = None
    ): CreateRouteResponseInput =
      CreateRouteResponseInput
        .builder
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def createRouteResponseRequest(
      apiId: Option[String] = None,
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeId: Option[String] = None,
      routeResponseKey: Option[String] = None
    ): CreateRouteResponseRequest =
      CreateRouteResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeId)(_.routeId(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def createRouteResponseResponse(
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeResponseId: Option[String] = None,
      routeResponseKey: Option[String] = None
    ): CreateRouteResponseResponse =
      CreateRouteResponseResponse
        .builder
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeResponseId)(_.routeResponseId(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def createStageInput(
      accessLogSettings: Option[AccessLogSettings] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageName: Option[String] = None,
      stageVariables: Option[StageVariablesMap] = None,
      tags: Option[Tags] = None
    ): CreateStageInput =
      CreateStageInput
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStageRequest(
      accessLogSettings: Option[AccessLogSettings] = None,
      apiId: Option[String] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageName: Option[String] = None,
      stageVariables: Option[StageVariablesMap] = None,
      tags: Option[Tags] = None
    ): CreateStageRequest =
      CreateStageRequest
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStageResponse(
      accessLogSettings: Option[AccessLogSettings] = None,
      apiGatewayManaged: Option[Boolean] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      createdDate: Option[__timestampIso8601] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      lastDeploymentStatusMessage: Option[String] = None,
      lastUpdatedDate: Option[__timestampIso8601] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageName: Option[String] = None,
      stageVariables: Option[StageVariablesMap] = None,
      tags: Option[Tags] = None
    ): CreateStageResponse =
      CreateStageResponse
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastDeploymentStatusMessage)(_.lastDeploymentStatusMessage(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVpcLinkInput(
      name: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[Tags] = None
    ): CreateVpcLinkInput =
      CreateVpcLinkInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVpcLinkRequest(
      name: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[Tags] = None
    ): CreateVpcLinkRequest =
      CreateVpcLinkRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVpcLinkResponse(
      createdDate: Option[__timestampIso8601] = None,
      name: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[Tags] = None,
      vpcLinkId: Option[String] = None,
      vpcLinkStatus: Option[String] = None,
      vpcLinkStatusMessage: Option[String] = None,
      vpcLinkVersion: Option[String] = None
    ): CreateVpcLinkResponse =
      CreateVpcLinkResponse
        .builder
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .ifSome(vpcLinkStatus)(_.vpcLinkStatus(_))
        .ifSome(vpcLinkStatusMessage)(_.vpcLinkStatusMessage(_))
        .ifSome(vpcLinkVersion)(_.vpcLinkVersion(_))
        .build

    def deleteAccessLogSettingsRequest(
      apiId: Option[String] = None,
      stageName: Option[String] = None
    ): DeleteAccessLogSettingsRequest =
      DeleteAccessLogSettingsRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def deleteApiMappingRequest(
      apiMappingId: Option[String] = None,
      domainName: Option[String] = None
    ): DeleteApiMappingRequest =
      DeleteApiMappingRequest
        .builder
        .ifSome(apiMappingId)(_.apiMappingId(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteApiRequest(
      apiId: Option[String] = None
    ): DeleteApiRequest =
      DeleteApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def deleteAuthorizerRequest(
      apiId: Option[String] = None,
      authorizerId: Option[String] = None
    ): DeleteAuthorizerRequest =
      DeleteAuthorizerRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .build

    def deleteCorsConfigurationRequest(
      apiId: Option[String] = None
    ): DeleteCorsConfigurationRequest =
      DeleteCorsConfigurationRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def deleteDeploymentRequest(
      apiId: Option[String] = None,
      deploymentId: Option[String] = None
    ): DeleteDeploymentRequest =
      DeleteDeploymentRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def deleteDomainNameRequest(
      domainName: Option[String] = None
    ): DeleteDomainNameRequest =
      DeleteDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteIntegrationRequest(
      apiId: Option[String] = None,
      integrationId: Option[String] = None
    ): DeleteIntegrationRequest =
      DeleteIntegrationRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(integrationId)(_.integrationId(_))
        .build

    def deleteIntegrationResponseRequest(
      apiId: Option[String] = None,
      integrationId: Option[String] = None,
      integrationResponseId: Option[String] = None
    ): DeleteIntegrationResponseRequest =
      DeleteIntegrationResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(integrationId)(_.integrationId(_))
        .ifSome(integrationResponseId)(_.integrationResponseId(_))
        .build

    def deleteModelRequest(
      apiId: Option[String] = None,
      modelId: Option[String] = None
    ): DeleteModelRequest =
      DeleteModelRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(modelId)(_.modelId(_))
        .build

    def deleteRouteRequest(
      apiId: Option[String] = None,
      routeId: Option[String] = None
    ): DeleteRouteRequest =
      DeleteRouteRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(routeId)(_.routeId(_))
        .build

    def deleteRouteRequestParameterRequest(
      apiId: Option[String] = None,
      requestParameterKey: Option[String] = None,
      routeId: Option[String] = None
    ): DeleteRouteRequestParameterRequest =
      DeleteRouteRequestParameterRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(requestParameterKey)(_.requestParameterKey(_))
        .ifSome(routeId)(_.routeId(_))
        .build

    def deleteRouteResponseRequest(
      apiId: Option[String] = None,
      routeId: Option[String] = None,
      routeResponseId: Option[String] = None
    ): DeleteRouteResponseRequest =
      DeleteRouteResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(routeId)(_.routeId(_))
        .ifSome(routeResponseId)(_.routeResponseId(_))
        .build

    def deleteRouteSettingsRequest(
      apiId: Option[String] = None,
      routeKey: Option[String] = None,
      stageName: Option[String] = None
    ): DeleteRouteSettingsRequest =
      DeleteRouteSettingsRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def deleteStageRequest(
      apiId: Option[String] = None,
      stageName: Option[String] = None
    ): DeleteStageRequest =
      DeleteStageRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def deleteVpcLinkRequest(
      vpcLinkId: Option[String] = None
    ): DeleteVpcLinkRequest =
      DeleteVpcLinkRequest
        .builder
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .build

    def deleteVpcLinkResponse(

    ): DeleteVpcLinkResponse =
      DeleteVpcLinkResponse
        .builder

        .build

    def deployment(
      autoDeployed: Option[Boolean] = None,
      createdDate: Option[__timestampIso8601] = None,
      deploymentId: Option[String] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      description: Option[String] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(autoDeployed)(_.autoDeployed(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(description)(_.description(_))
        .build

    def deployments(
      items: Option[List[Deployment]] = None,
      nextToken: Option[String] = None
    ): Deployments =
      Deployments
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def domainName(
      apiMappingSelectionExpression: Option[String] = None,
      domainName: Option[String] = None,
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthentication] = None,
      tags: Option[Tags] = None
    ): DomainName =
      DomainName
        .builder
        .ifSome(apiMappingSelectionExpression)(_.apiMappingSelectionExpression(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .ifSome(tags)(_.tags(_))
        .build

    def domainNameConfiguration(
      apiGatewayDomainName: Option[String] = None,
      certificateArn: Option[String] = None,
      certificateName: Option[String] = None,
      certificateUploadDate: Option[__timestampIso8601] = None,
      domainNameStatus: Option[String] = None,
      domainNameStatusMessage: Option[String] = None,
      endpointType: Option[String] = None,
      hostedZoneId: Option[String] = None,
      securityPolicy: Option[String] = None
    ): DomainNameConfiguration =
      DomainNameConfiguration
        .builder
        .ifSome(apiGatewayDomainName)(_.apiGatewayDomainName(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(certificateUploadDate)(_.certificateUploadDate(_))
        .ifSome(domainNameStatus)(_.domainNameStatus(_))
        .ifSome(domainNameStatusMessage)(_.domainNameStatusMessage(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(securityPolicy)(_.securityPolicy(_))
        .build

    def domainNames(
      items: Option[List[DomainName]] = None,
      nextToken: Option[String] = None
    ): DomainNames =
      DomainNames
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def exportApiRequest(
      apiId: Option[String] = None,
      exportVersion: Option[String] = None,
      includeExtensions: Option[Boolean] = None,
      outputType: Option[String] = None,
      specification: Option[String] = None,
      stageName: Option[String] = None
    ): ExportApiRequest =
      ExportApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(exportVersion)(_.exportVersion(_))
        .ifSome(includeExtensions)(_.includeExtensions(_))
        .ifSome(outputType)(_.outputType(_))
        .ifSome(specification)(_.specification(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def exportApiResponse(
      body: Option[ExportedApi] = None
    ): ExportApiResponse =
      ExportApiResponse
        .builder
        .ifSome(body)(_.body(_))
        .build

    def getApiMappingRequest(
      apiMappingId: Option[String] = None,
      domainName: Option[String] = None
    ): GetApiMappingRequest =
      GetApiMappingRequest
        .builder
        .ifSome(apiMappingId)(_.apiMappingId(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def getApiMappingResponse(
      apiId: Option[String] = None,
      apiMappingId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      stage: Option[String] = None
    ): GetApiMappingResponse =
      GetApiMappingResponse
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingId)(_.apiMappingId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(stage)(_.stage(_))
        .build

    def getApiMappingsRequest(
      domainName: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetApiMappingsRequest =
      GetApiMappingsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getApiMappingsResponse(
      items: Option[List[ApiMapping]] = None,
      nextToken: Option[String] = None
    ): GetApiMappingsResponse =
      GetApiMappingsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getApiRequest(
      apiId: Option[String] = None
    ): GetApiRequest =
      GetApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def getApiResponse(
      apiEndpoint: Option[String] = None,
      apiGatewayManaged: Option[Boolean] = None,
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      createdDate: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      importInfo: Option[List[__string]] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      version: Option[String] = None,
      warnings: Option[List[__string]] = None
    ): GetApiResponse =
      GetApiResponse
        .builder
        .ifSome(apiEndpoint)(_.apiEndpoint(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(importInfo)(_.importInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(version)(_.version(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def getApisRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetApisRequest =
      GetApisRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getApisResponse(
      items: Option[List[Api]] = None,
      nextToken: Option[String] = None
    ): GetApisResponse =
      GetApisResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAuthorizerRequest(
      apiId: Option[String] = None,
      authorizerId: Option[String] = None
    ): GetAuthorizerRequest =
      GetAuthorizerRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .build

    def getAuthorizerResponse(
      authorizerCredentialsArn: Option[String] = None,
      authorizerId: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): GetAuthorizerResponse =
      GetAuthorizerResponse
        .builder
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def getAuthorizersRequest(
      apiId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetAuthorizersRequest =
      GetAuthorizersRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAuthorizersResponse(
      items: Option[List[Authorizer]] = None,
      nextToken: Option[String] = None
    ): GetAuthorizersResponse =
      GetAuthorizersResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDeploymentRequest(
      apiId: Option[String] = None,
      deploymentId: Option[String] = None
    ): GetDeploymentRequest =
      GetDeploymentRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def getDeploymentResponse(
      autoDeployed: Option[Boolean] = None,
      createdDate: Option[__timestampIso8601] = None,
      deploymentId: Option[String] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      description: Option[String] = None
    ): GetDeploymentResponse =
      GetDeploymentResponse
        .builder
        .ifSome(autoDeployed)(_.autoDeployed(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(description)(_.description(_))
        .build

    def getDeploymentsRequest(
      apiId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetDeploymentsRequest =
      GetDeploymentsRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDeploymentsResponse(
      items: Option[List[Deployment]] = None,
      nextToken: Option[String] = None
    ): GetDeploymentsResponse =
      GetDeploymentsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDomainNameRequest(
      domainName: Option[String] = None
    ): GetDomainNameRequest =
      GetDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getDomainNameResponse(
      apiMappingSelectionExpression: Option[String] = None,
      domainName: Option[String] = None,
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthentication] = None,
      tags: Option[Tags] = None
    ): GetDomainNameResponse =
      GetDomainNameResponse
        .builder
        .ifSome(apiMappingSelectionExpression)(_.apiMappingSelectionExpression(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getDomainNamesRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetDomainNamesRequest =
      GetDomainNamesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDomainNamesResponse(
      items: Option[List[DomainName]] = None,
      nextToken: Option[String] = None
    ): GetDomainNamesResponse =
      GetDomainNamesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getIntegrationRequest(
      apiId: Option[String] = None,
      integrationId: Option[String] = None
    ): GetIntegrationRequest =
      GetIntegrationRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(integrationId)(_.integrationId(_))
        .build

    def getIntegrationResponseRequest(
      apiId: Option[String] = None,
      integrationId: Option[String] = None,
      integrationResponseId: Option[String] = None
    ): GetIntegrationResponseRequest =
      GetIntegrationResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(integrationId)(_.integrationId(_))
        .ifSome(integrationResponseId)(_.integrationResponseId(_))
        .build

    def getIntegrationResponseResponse(
      contentHandlingStrategy: Option[String] = None,
      integrationResponseId: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): GetIntegrationResponseResponse =
      GetIntegrationResponseResponse
        .builder
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationResponseId)(_.integrationResponseId(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def getIntegrationResponsesRequest(
      apiId: Option[String] = None,
      integrationId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetIntegrationResponsesRequest =
      GetIntegrationResponsesRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(integrationId)(_.integrationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getIntegrationResponsesResponse(
      items: Option[List[IntegrationResponse]] = None,
      nextToken: Option[String] = None
    ): GetIntegrationResponsesResponse =
      GetIntegrationResponsesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getIntegrationsRequest(
      apiId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetIntegrationsRequest =
      GetIntegrationsRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getIntegrationsResponse(
      items: Option[List[Integration]] = None,
      nextToken: Option[String] = None
    ): GetIntegrationsResponse =
      GetIntegrationsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getModelRequest(
      apiId: Option[String] = None,
      modelId: Option[String] = None
    ): GetModelRequest =
      GetModelRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(modelId)(_.modelId(_))
        .build

    def getModelResponse(
      contentType: Option[String] = None,
      description: Option[String] = None,
      modelId: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): GetModelResponse =
      GetModelResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(modelId)(_.modelId(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def getModelTemplateRequest(
      apiId: Option[String] = None,
      modelId: Option[String] = None
    ): GetModelTemplateRequest =
      GetModelTemplateRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(modelId)(_.modelId(_))
        .build

    def getModelTemplateResponse(
      value: Option[String] = None
    ): GetModelTemplateResponse =
      GetModelTemplateResponse
        .builder
        .ifSome(value)(_.value(_))
        .build

    def getModelsRequest(
      apiId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetModelsRequest =
      GetModelsRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getModelsResponse(
      items: Option[List[Model]] = None,
      nextToken: Option[String] = None
    ): GetModelsResponse =
      GetModelsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getRouteRequest(
      apiId: Option[String] = None,
      routeId: Option[String] = None
    ): GetRouteRequest =
      GetRouteRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(routeId)(_.routeId(_))
        .build

    def getRouteResponseRequest(
      apiId: Option[String] = None,
      routeId: Option[String] = None,
      routeResponseId: Option[String] = None
    ): GetRouteResponseRequest =
      GetRouteResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(routeId)(_.routeId(_))
        .ifSome(routeResponseId)(_.routeResponseId(_))
        .build

    def getRouteResponseResponse(
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeResponseId: Option[String] = None,
      routeResponseKey: Option[String] = None
    ): GetRouteResponseResponse =
      GetRouteResponseResponse
        .builder
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeResponseId)(_.routeResponseId(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def getRouteResponsesRequest(
      apiId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None,
      routeId: Option[String] = None
    ): GetRouteResponsesRequest =
      GetRouteResponsesRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(routeId)(_.routeId(_))
        .build

    def getRouteResponsesResponse(
      items: Option[List[RouteResponse]] = None,
      nextToken: Option[String] = None
    ): GetRouteResponsesResponse =
      GetRouteResponsesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getRoutesRequest(
      apiId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetRoutesRequest =
      GetRoutesRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getRoutesResponse(
      items: Option[List[Route]] = None,
      nextToken: Option[String] = None
    ): GetRoutesResponse =
      GetRoutesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getStageRequest(
      apiId: Option[String] = None,
      stageName: Option[String] = None
    ): GetStageRequest =
      GetStageRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def getStageResponse(
      accessLogSettings: Option[AccessLogSettings] = None,
      apiGatewayManaged: Option[Boolean] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      createdDate: Option[__timestampIso8601] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      lastDeploymentStatusMessage: Option[String] = None,
      lastUpdatedDate: Option[__timestampIso8601] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageName: Option[String] = None,
      stageVariables: Option[StageVariablesMap] = None,
      tags: Option[Tags] = None
    ): GetStageResponse =
      GetStageResponse
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastDeploymentStatusMessage)(_.lastDeploymentStatusMessage(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getStagesRequest(
      apiId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetStagesRequest =
      GetStagesRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getStagesResponse(
      items: Option[List[Stage]] = None,
      nextToken: Option[String] = None
    ): GetStagesResponse =
      GetStagesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTagsRequest(
      resourceArn: Option[String] = None
    ): GetTagsRequest =
      GetTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getTagsResponse(
      tags: Option[Tags] = None
    ): GetTagsResponse =
      GetTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def getVpcLinkRequest(
      vpcLinkId: Option[String] = None
    ): GetVpcLinkRequest =
      GetVpcLinkRequest
        .builder
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .build

    def getVpcLinkResponse(
      createdDate: Option[__timestampIso8601] = None,
      name: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[Tags] = None,
      vpcLinkId: Option[String] = None,
      vpcLinkStatus: Option[String] = None,
      vpcLinkStatusMessage: Option[String] = None,
      vpcLinkVersion: Option[String] = None
    ): GetVpcLinkResponse =
      GetVpcLinkResponse
        .builder
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .ifSome(vpcLinkStatus)(_.vpcLinkStatus(_))
        .ifSome(vpcLinkStatusMessage)(_.vpcLinkStatusMessage(_))
        .ifSome(vpcLinkVersion)(_.vpcLinkVersion(_))
        .build

    def getVpcLinksRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): GetVpcLinksRequest =
      GetVpcLinksRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getVpcLinksResponse(
      items: Option[List[VpcLink]] = None,
      nextToken: Option[String] = None
    ): GetVpcLinksResponse =
      GetVpcLinksResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def importApiInput(
      body: Option[String] = None
    ): ImportApiInput =
      ImportApiInput
        .builder
        .ifSome(body)(_.body(_))
        .build

    def importApiRequest(
      basepath: Option[String] = None,
      body: Option[String] = None,
      failOnWarnings: Option[Boolean] = None
    ): ImportApiRequest =
      ImportApiRequest
        .builder
        .ifSome(basepath)(_.basepath(_))
        .ifSome(body)(_.body(_))
        .ifSome(failOnWarnings)(_.failOnWarnings(_))
        .build

    def importApiResponse(
      apiEndpoint: Option[String] = None,
      apiGatewayManaged: Option[Boolean] = None,
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      createdDate: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      importInfo: Option[List[__string]] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      version: Option[String] = None,
      warnings: Option[List[__string]] = None
    ): ImportApiResponse =
      ImportApiResponse
        .builder
        .ifSome(apiEndpoint)(_.apiEndpoint(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(importInfo)(_.importInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(version)(_.version(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def integration(
      apiGatewayManaged: Option[Boolean] = None,
      connectionId: Option[String] = None,
      connectionType: Option[String] = None,
      contentHandlingStrategy: Option[String] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      integrationId: Option[String] = None,
      integrationMethod: Option[String] = None,
      integrationResponseSelectionExpression: Option[String] = None,
      integrationSubtype: Option[String] = None,
      integrationType: Option[String] = None,
      integrationUri: Option[String] = None,
      passthroughBehavior: Option[String] = None,
      payloadFormatVersion: Option[String] = None,
      requestParameters: Option[IntegrationParameters] = None,
      requestTemplates: Option[TemplateMap] = None,
      responseParameters: Option[ResponseParameters] = None,
      templateSelectionExpression: Option[String] = None,
      timeoutInMillis: Option[Int] = None,
      tlsConfig: Option[TlsConfig] = None
    ): Integration =
      Integration
        .builder
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(integrationId)(_.integrationId(_))
        .ifSome(integrationMethod)(_.integrationMethod(_))
        .ifSome(integrationResponseSelectionExpression)(_.integrationResponseSelectionExpression(_))
        .ifSome(integrationSubtype)(_.integrationSubtype(_))
        .ifSome(integrationType)(_.integrationType(_))
        .ifSome(integrationUri)(_.integrationUri(_))
        .ifSome(passthroughBehavior)(_.passthroughBehavior(_))
        .ifSome(payloadFormatVersion)(_.payloadFormatVersion(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestTemplates)(_.requestTemplates(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .ifSome(timeoutInMillis)(_.timeoutInMillis(_))
        .ifSome(tlsConfig)(_.tlsConfig(_))
        .build

    def integrationResponse(
      contentHandlingStrategy: Option[String] = None,
      integrationResponseId: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): IntegrationResponse =
      IntegrationResponse
        .builder
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationResponseId)(_.integrationResponseId(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def integrationResponses(
      items: Option[List[IntegrationResponse]] = None,
      nextToken: Option[String] = None
    ): IntegrationResponses =
      IntegrationResponses
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def integrations(
      items: Option[List[Integration]] = None,
      nextToken: Option[String] = None
    ): Integrations =
      Integrations
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def jWTConfiguration(
      audience: Option[List[__string]] = None,
      issuer: Option[String] = None
    ): JWTConfiguration =
      JWTConfiguration
        .builder
        .ifSome(audience)(_.audience(_))
        .ifSome(issuer)(_.issuer(_))
        .build

    def limitExceededException(
      limitType: Option[String] = None,
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(limitType)(_.limitType(_))
        .ifSome(message)(_.message(_))
        .build

    def model(
      contentType: Option[String] = None,
      description: Option[String] = None,
      modelId: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): Model =
      Model
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(modelId)(_.modelId(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def models(
      items: Option[List[Model]] = None,
      nextToken: Option[String] = None
    ): Models =
      Models
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def mutualTlsAuthentication(
      truststoreUri: Option[String] = None,
      truststoreVersion: Option[String] = None,
      truststoreWarnings: Option[List[__string]] = None
    ): MutualTlsAuthentication =
      MutualTlsAuthentication
        .builder
        .ifSome(truststoreUri)(_.truststoreUri(_))
        .ifSome(truststoreVersion)(_.truststoreVersion(_))
        .ifSome(truststoreWarnings)(_.truststoreWarnings(_))
        .build

    def mutualTlsAuthenticationInput(
      truststoreUri: Option[String] = None,
      truststoreVersion: Option[String] = None
    ): MutualTlsAuthenticationInput =
      MutualTlsAuthenticationInput
        .builder
        .ifSome(truststoreUri)(_.truststoreUri(_))
        .ifSome(truststoreVersion)(_.truststoreVersion(_))
        .build

    def notFoundException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def parameterConstraints(
      required: Option[Boolean] = None
    ): ParameterConstraints =
      ParameterConstraints
        .builder
        .ifSome(required)(_.required(_))
        .build

    def reimportApiInput(
      body: Option[String] = None
    ): ReimportApiInput =
      ReimportApiInput
        .builder
        .ifSome(body)(_.body(_))
        .build

    def reimportApiRequest(
      apiId: Option[String] = None,
      basepath: Option[String] = None,
      body: Option[String] = None,
      failOnWarnings: Option[Boolean] = None
    ): ReimportApiRequest =
      ReimportApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(basepath)(_.basepath(_))
        .ifSome(body)(_.body(_))
        .ifSome(failOnWarnings)(_.failOnWarnings(_))
        .build

    def reimportApiResponse(
      apiEndpoint: Option[String] = None,
      apiGatewayManaged: Option[Boolean] = None,
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      createdDate: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      importInfo: Option[List[__string]] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      version: Option[String] = None,
      warnings: Option[List[__string]] = None
    ): ReimportApiResponse =
      ReimportApiResponse
        .builder
        .ifSome(apiEndpoint)(_.apiEndpoint(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(importInfo)(_.importInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(version)(_.version(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def resetAuthorizersCacheRequest(
      apiId: Option[String] = None,
      stageName: Option[String] = None
    ): ResetAuthorizersCacheRequest =
      ResetAuthorizersCacheRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def route(
      apiGatewayManaged: Option[Boolean] = None,
      apiKeyRequired: Option[Boolean] = None,
      authorizationScopes: Option[List[StringWithLengthBetween1And64]] = None,
      authorizationType: Option[String] = None,
      authorizerId: Option[String] = None,
      modelSelectionExpression: Option[String] = None,
      operationName: Option[String] = None,
      requestModels: Option[RouteModels] = None,
      requestParameters: Option[RouteParameters] = None,
      routeId: Option[String] = None,
      routeKey: Option[String] = None,
      routeResponseSelectionExpression: Option[String] = None,
      target: Option[String] = None
    ): Route =
      Route
        .builder
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .ifSome(authorizationScopes)(_.authorizationScopes(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(requestModels)(_.requestModels(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(routeId)(_.routeId(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeResponseSelectionExpression)(_.routeResponseSelectionExpression(_))
        .ifSome(target)(_.target(_))
        .build

    def routeResponse(
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeResponseId: Option[String] = None,
      routeResponseKey: Option[String] = None
    ): RouteResponse =
      RouteResponse
        .builder
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeResponseId)(_.routeResponseId(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def routeResponses(
      items: Option[List[RouteResponse]] = None,
      nextToken: Option[String] = None
    ): RouteResponses =
      RouteResponses
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def routeSettings(
      dataTraceEnabled: Option[Boolean] = None,
      detailedMetricsEnabled: Option[Boolean] = None,
      loggingLevel: Option[String] = None,
      throttlingBurstLimit: Option[Int] = None,
      throttlingRateLimit: Option[__double] = None
    ): RouteSettings =
      RouteSettings
        .builder
        .ifSome(dataTraceEnabled)(_.dataTraceEnabled(_))
        .ifSome(detailedMetricsEnabled)(_.detailedMetricsEnabled(_))
        .ifSome(loggingLevel)(_.loggingLevel(_))
        .ifSome(throttlingBurstLimit)(_.throttlingBurstLimit(_))
        .ifSome(throttlingRateLimit)(_.throttlingRateLimit(_))
        .build

    def routes(
      items: Option[List[Route]] = None,
      nextToken: Option[String] = None
    ): Routes =
      Routes
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def stage(
      accessLogSettings: Option[AccessLogSettings] = None,
      apiGatewayManaged: Option[Boolean] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      createdDate: Option[__timestampIso8601] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      lastDeploymentStatusMessage: Option[String] = None,
      lastUpdatedDate: Option[__timestampIso8601] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageName: Option[String] = None,
      stageVariables: Option[StageVariablesMap] = None,
      tags: Option[Tags] = None
    ): Stage =
      Stage
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastDeploymentStatusMessage)(_.lastDeploymentStatusMessage(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(tags)(_.tags(_))
        .build

    def stages(
      items: Option[List[Stage]] = None,
      nextToken: Option[String] = None
    ): Stages =
      Stages
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def tagResourceInput(
      tags: Option[Tags] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
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

    def template(
      value: Option[String] = None
    ): Template =
      Template
        .builder
        .ifSome(value)(_.value(_))
        .build

    def tlsConfig(
      serverNameToVerify: Option[String] = None
    ): TlsConfig =
      TlsConfig
        .builder
        .ifSome(serverNameToVerify)(_.serverNameToVerify(_))
        .build

    def tlsConfigInput(
      serverNameToVerify: Option[String] = None
    ): TlsConfigInput =
      TlsConfigInput
        .builder
        .ifSome(serverNameToVerify)(_.serverNameToVerify(_))
        .build

    def tooManyRequestsException(
      limitType: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(limitType)(_.limitType(_))
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateApiInput(
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      disableSchemaValidation: Option[Boolean] = None,
      name: Option[String] = None,
      routeKey: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      target: Option[String] = None,
      version: Option[String] = None
    ): UpdateApiInput =
      UpdateApiInput
        .builder
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(name)(_.name(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(target)(_.target(_))
        .ifSome(version)(_.version(_))
        .build

    def updateApiMappingInput(
      apiId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      stage: Option[String] = None
    ): UpdateApiMappingInput =
      UpdateApiMappingInput
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(stage)(_.stage(_))
        .build

    def updateApiMappingRequest(
      apiId: Option[String] = None,
      apiMappingId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      domainName: Option[String] = None,
      stage: Option[String] = None
    ): UpdateApiMappingRequest =
      UpdateApiMappingRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingId)(_.apiMappingId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(stage)(_.stage(_))
        .build

    def updateApiMappingResponse(
      apiId: Option[String] = None,
      apiMappingId: Option[String] = None,
      apiMappingKey: Option[String] = None,
      stage: Option[String] = None
    ): UpdateApiMappingResponse =
      UpdateApiMappingResponse
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiMappingId)(_.apiMappingId(_))
        .ifSome(apiMappingKey)(_.apiMappingKey(_))
        .ifSome(stage)(_.stage(_))
        .build

    def updateApiRequest(
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      name: Option[String] = None,
      routeKey: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      target: Option[String] = None,
      version: Option[String] = None
    ): UpdateApiRequest =
      UpdateApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(name)(_.name(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(target)(_.target(_))
        .ifSome(version)(_.version(_))
        .build

    def updateApiResponse(
      apiEndpoint: Option[String] = None,
      apiGatewayManaged: Option[Boolean] = None,
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      corsConfiguration: Option[Cors] = None,
      createdDate: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      disableSchemaValidation: Option[Boolean] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None,
      importInfo: Option[List[__string]] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      tags: Option[Tags] = None,
      version: Option[String] = None,
      warnings: Option[List[__string]] = None
    ): UpdateApiResponse =
      UpdateApiResponse
        .builder
        .ifSome(apiEndpoint)(_.apiEndpoint(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(disableSchemaValidation)(_.disableSchemaValidation(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .ifSome(importInfo)(_.importInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(version)(_.version(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def updateAuthorizerInput(
      authorizerCredentialsArn: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): UpdateAuthorizerInput =
      UpdateAuthorizerInput
        .builder
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def updateAuthorizerRequest(
      apiId: Option[String] = None,
      authorizerCredentialsArn: Option[String] = None,
      authorizerId: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): UpdateAuthorizerRequest =
      UpdateAuthorizerRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def updateAuthorizerResponse(
      authorizerCredentialsArn: Option[String] = None,
      authorizerId: Option[String] = None,
      authorizerPayloadFormatVersion: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None,
      authorizerType: Option[String] = None,
      authorizerUri: Option[String] = None,
      enableSimpleResponses: Option[Boolean] = None,
      identitySource: Option[List[__string]] = None,
      identityValidationExpression: Option[String] = None,
      jwtConfiguration: Option[JWTConfiguration] = None,
      name: Option[String] = None
    ): UpdateAuthorizerResponse =
      UpdateAuthorizerResponse
        .builder
        .ifSome(authorizerCredentialsArn)(_.authorizerCredentialsArn(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(authorizerPayloadFormatVersion)(_.authorizerPayloadFormatVersion(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .ifSome(authorizerType)(_.authorizerType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(enableSimpleResponses)(_.enableSimpleResponses(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(jwtConfiguration)(_.jwtConfiguration(_))
        .ifSome(name)(_.name(_))
        .build

    def updateDeploymentInput(
      description: Option[String] = None
    ): UpdateDeploymentInput =
      UpdateDeploymentInput
        .builder
        .ifSome(description)(_.description(_))
        .build

    def updateDeploymentRequest(
      apiId: Option[String] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None
    ): UpdateDeploymentRequest =
      UpdateDeploymentRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .build

    def updateDeploymentResponse(
      autoDeployed: Option[Boolean] = None,
      createdDate: Option[__timestampIso8601] = None,
      deploymentId: Option[String] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      description: Option[String] = None
    ): UpdateDeploymentResponse =
      UpdateDeploymentResponse
        .builder
        .ifSome(autoDeployed)(_.autoDeployed(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(description)(_.description(_))
        .build

    def updateDomainNameInput(
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthenticationInput] = None
    ): UpdateDomainNameInput =
      UpdateDomainNameInput
        .builder
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .build

    def updateDomainNameRequest(
      domainName: Option[String] = None,
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthenticationInput] = None
    ): UpdateDomainNameRequest =
      UpdateDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .build

    def updateDomainNameResponse(
      apiMappingSelectionExpression: Option[String] = None,
      domainName: Option[String] = None,
      domainNameConfigurations: Option[List[DomainNameConfiguration]] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthentication] = None,
      tags: Option[Tags] = None
    ): UpdateDomainNameResponse =
      UpdateDomainNameResponse
        .builder
        .ifSome(apiMappingSelectionExpression)(_.apiMappingSelectionExpression(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainNameConfigurations)(_.domainNameConfigurations(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateIntegrationInput(
      connectionId: Option[String] = None,
      connectionType: Option[String] = None,
      contentHandlingStrategy: Option[String] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      integrationMethod: Option[String] = None,
      integrationSubtype: Option[String] = None,
      integrationType: Option[String] = None,
      integrationUri: Option[String] = None,
      passthroughBehavior: Option[String] = None,
      payloadFormatVersion: Option[String] = None,
      requestParameters: Option[IntegrationParameters] = None,
      requestTemplates: Option[TemplateMap] = None,
      responseParameters: Option[ResponseParameters] = None,
      templateSelectionExpression: Option[String] = None,
      timeoutInMillis: Option[Int] = None,
      tlsConfig: Option[TlsConfigInput] = None
    ): UpdateIntegrationInput =
      UpdateIntegrationInput
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(integrationMethod)(_.integrationMethod(_))
        .ifSome(integrationSubtype)(_.integrationSubtype(_))
        .ifSome(integrationType)(_.integrationType(_))
        .ifSome(integrationUri)(_.integrationUri(_))
        .ifSome(passthroughBehavior)(_.passthroughBehavior(_))
        .ifSome(payloadFormatVersion)(_.payloadFormatVersion(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestTemplates)(_.requestTemplates(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .ifSome(timeoutInMillis)(_.timeoutInMillis(_))
        .ifSome(tlsConfig)(_.tlsConfig(_))
        .build

    def updateIntegrationRequest(
      apiId: Option[String] = None,
      connectionId: Option[String] = None,
      connectionType: Option[String] = None,
      contentHandlingStrategy: Option[String] = None,
      credentialsArn: Option[String] = None,
      description: Option[String] = None,
      integrationId: Option[String] = None,
      integrationMethod: Option[String] = None,
      integrationSubtype: Option[String] = None,
      integrationType: Option[String] = None,
      integrationUri: Option[String] = None,
      passthroughBehavior: Option[String] = None,
      payloadFormatVersion: Option[String] = None,
      requestParameters: Option[IntegrationParameters] = None,
      requestTemplates: Option[TemplateMap] = None,
      responseParameters: Option[ResponseParameters] = None,
      templateSelectionExpression: Option[String] = None,
      timeoutInMillis: Option[Int] = None,
      tlsConfig: Option[TlsConfigInput] = None
    ): UpdateIntegrationRequest =
      UpdateIntegrationRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(integrationId)(_.integrationId(_))
        .ifSome(integrationMethod)(_.integrationMethod(_))
        .ifSome(integrationSubtype)(_.integrationSubtype(_))
        .ifSome(integrationType)(_.integrationType(_))
        .ifSome(integrationUri)(_.integrationUri(_))
        .ifSome(passthroughBehavior)(_.passthroughBehavior(_))
        .ifSome(payloadFormatVersion)(_.payloadFormatVersion(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestTemplates)(_.requestTemplates(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .ifSome(timeoutInMillis)(_.timeoutInMillis(_))
        .ifSome(tlsConfig)(_.tlsConfig(_))
        .build

    def updateIntegrationResponseInput(
      contentHandlingStrategy: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): UpdateIntegrationResponseInput =
      UpdateIntegrationResponseInput
        .builder
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def updateIntegrationResponseRequest(
      apiId: Option[String] = None,
      contentHandlingStrategy: Option[String] = None,
      integrationId: Option[String] = None,
      integrationResponseId: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): UpdateIntegrationResponseRequest =
      UpdateIntegrationResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationId)(_.integrationId(_))
        .ifSome(integrationResponseId)(_.integrationResponseId(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def updateIntegrationResponseResponse(
      contentHandlingStrategy: Option[String] = None,
      integrationResponseId: Option[String] = None,
      integrationResponseKey: Option[String] = None,
      responseParameters: Option[IntegrationParameters] = None,
      responseTemplates: Option[TemplateMap] = None,
      templateSelectionExpression: Option[String] = None
    ): UpdateIntegrationResponseResponse =
      UpdateIntegrationResponseResponse
        .builder
        .ifSome(contentHandlingStrategy)(_.contentHandlingStrategy(_))
        .ifSome(integrationResponseId)(_.integrationResponseId(_))
        .ifSome(integrationResponseKey)(_.integrationResponseKey(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(templateSelectionExpression)(_.templateSelectionExpression(_))
        .build

    def updateModelInput(
      contentType: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): UpdateModelInput =
      UpdateModelInput
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def updateModelRequest(
      apiId: Option[String] = None,
      contentType: Option[String] = None,
      description: Option[String] = None,
      modelId: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): UpdateModelRequest =
      UpdateModelRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(modelId)(_.modelId(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def updateModelResponse(
      contentType: Option[String] = None,
      description: Option[String] = None,
      modelId: Option[String] = None,
      name: Option[String] = None,
      schema: Option[String] = None
    ): UpdateModelResponse =
      UpdateModelResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(modelId)(_.modelId(_))
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .build

    def updateRouteInput(
      apiKeyRequired: Option[Boolean] = None,
      authorizationScopes: Option[List[StringWithLengthBetween1And64]] = None,
      authorizationType: Option[String] = None,
      authorizerId: Option[String] = None,
      modelSelectionExpression: Option[String] = None,
      operationName: Option[String] = None,
      requestModels: Option[RouteModels] = None,
      requestParameters: Option[RouteParameters] = None,
      routeKey: Option[String] = None,
      routeResponseSelectionExpression: Option[String] = None,
      target: Option[String] = None
    ): UpdateRouteInput =
      UpdateRouteInput
        .builder
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .ifSome(authorizationScopes)(_.authorizationScopes(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(requestModels)(_.requestModels(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeResponseSelectionExpression)(_.routeResponseSelectionExpression(_))
        .ifSome(target)(_.target(_))
        .build

    def updateRouteRequest(
      apiId: Option[String] = None,
      apiKeyRequired: Option[Boolean] = None,
      authorizationScopes: Option[List[StringWithLengthBetween1And64]] = None,
      authorizationType: Option[String] = None,
      authorizerId: Option[String] = None,
      modelSelectionExpression: Option[String] = None,
      operationName: Option[String] = None,
      requestModels: Option[RouteModels] = None,
      requestParameters: Option[RouteParameters] = None,
      routeId: Option[String] = None,
      routeKey: Option[String] = None,
      routeResponseSelectionExpression: Option[String] = None,
      target: Option[String] = None
    ): UpdateRouteRequest =
      UpdateRouteRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .ifSome(authorizationScopes)(_.authorizationScopes(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(requestModels)(_.requestModels(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(routeId)(_.routeId(_))
        .ifSome(routeKey)(_.routeKey(_))
        .ifSome(routeResponseSelectionExpression)(_.routeResponseSelectionExpression(_))
        .ifSome(target)(_.target(_))
        .build

    def updateRouteResponseInput(
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeResponseKey: Option[String] = None
    ): UpdateRouteResponseInput =
      UpdateRouteResponseInput
        .builder
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def updateRouteResponseRequest(
      apiId: Option[String] = None,
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeId: Option[String] = None,
      routeResponseId: Option[String] = None,
      routeResponseKey: Option[String] = None
    ): UpdateRouteResponseRequest =
      UpdateRouteResponseRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeId)(_.routeId(_))
        .ifSome(routeResponseId)(_.routeResponseId(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def updateRouteResponseResponse(
      modelSelectionExpression: Option[String] = None,
      responseModels: Option[RouteModels] = None,
      responseParameters: Option[RouteParameters] = None,
      routeResponseId: Option[String] = None,
      routeResponseKey: Option[String] = None
    ): UpdateRouteResponseResponse =
      UpdateRouteResponseResponse
        .builder
        .ifSome(modelSelectionExpression)(_.modelSelectionExpression(_))
        .ifSome(responseModels)(_.responseModels(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(routeResponseId)(_.routeResponseId(_))
        .ifSome(routeResponseKey)(_.routeResponseKey(_))
        .build

    def updateStageInput(
      accessLogSettings: Option[AccessLogSettings] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageVariables: Option[StageVariablesMap] = None
    ): UpdateStageInput =
      UpdateStageInput
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .build

    def updateStageRequest(
      accessLogSettings: Option[AccessLogSettings] = None,
      apiId: Option[String] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageName: Option[String] = None,
      stageVariables: Option[StageVariablesMap] = None
    ): UpdateStageRequest =
      UpdateStageRequest
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .build

    def updateStageResponse(
      accessLogSettings: Option[AccessLogSettings] = None,
      apiGatewayManaged: Option[Boolean] = None,
      autoDeploy: Option[Boolean] = None,
      clientCertificateId: Option[String] = None,
      createdDate: Option[__timestampIso8601] = None,
      defaultRouteSettings: Option[RouteSettings] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      lastDeploymentStatusMessage: Option[String] = None,
      lastUpdatedDate: Option[__timestampIso8601] = None,
      routeSettings: Option[RouteSettingsMap] = None,
      stageName: Option[String] = None,
      stageVariables: Option[StageVariablesMap] = None,
      tags: Option[Tags] = None
    ): UpdateStageResponse =
      UpdateStageResponse
        .builder
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastDeploymentStatusMessage)(_.lastDeploymentStatusMessage(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateVpcLinkInput(
      name: Option[String] = None
    ): UpdateVpcLinkInput =
      UpdateVpcLinkInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateVpcLinkRequest(
      name: Option[String] = None,
      vpcLinkId: Option[String] = None
    ): UpdateVpcLinkRequest =
      UpdateVpcLinkRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .build

    def updateVpcLinkResponse(
      createdDate: Option[__timestampIso8601] = None,
      name: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[Tags] = None,
      vpcLinkId: Option[String] = None,
      vpcLinkStatus: Option[String] = None,
      vpcLinkStatusMessage: Option[String] = None,
      vpcLinkVersion: Option[String] = None
    ): UpdateVpcLinkResponse =
      UpdateVpcLinkResponse
        .builder
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .ifSome(vpcLinkStatus)(_.vpcLinkStatus(_))
        .ifSome(vpcLinkStatusMessage)(_.vpcLinkStatusMessage(_))
        .ifSome(vpcLinkVersion)(_.vpcLinkVersion(_))
        .build

    def vpcLink(
      createdDate: Option[__timestampIso8601] = None,
      name: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[Tags] = None,
      vpcLinkId: Option[String] = None,
      vpcLinkStatus: Option[String] = None,
      vpcLinkStatusMessage: Option[String] = None,
      vpcLinkVersion: Option[String] = None
    ): VpcLink =
      VpcLink
        .builder
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .ifSome(vpcLinkStatus)(_.vpcLinkStatus(_))
        .ifSome(vpcLinkStatusMessage)(_.vpcLinkStatusMessage(_))
        .ifSome(vpcLinkVersion)(_.vpcLinkVersion(_))
        .build

    def vpcLinks(
      items: Option[List[VpcLink]] = None,
      nextToken: Option[String] = None
    ): VpcLinks =
      VpcLinks
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
