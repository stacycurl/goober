package goober.hi

import goober.free.apigateway.ApiGatewayIO
import software.amazon.awssdk.services.apigateway.model._


object apigateway {
  import goober.free.{apigateway ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessLogSettings(
      format: Option[String] = None,
      destinationArn: Option[String] = None
    ): AccessLogSettings =
      AccessLogSettings
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .build

    def account(
      cloudwatchRoleArn: Option[String] = None,
      throttleSettings: Option[ThrottleSettings] = None,
      features: Option[List[String]] = None,
      apiKeyVersion: Option[String] = None
    ): Account =
      Account
        .builder
        .ifSome(cloudwatchRoleArn)(_.cloudwatchRoleArn(_))
        .ifSome(throttleSettings)(_.throttleSettings(_))
        .ifSome(features)(_.features(_))
        .ifSome(apiKeyVersion)(_.apiKeyVersion(_))
        .build

    def apiKey(
      id: Option[String] = None,
      value: Option[String] = None,
      name: Option[String] = None,
      customerId: Option[String] = None,
      description: Option[String] = None,
      enabled: Option[Boolean] = None,
      createdDate: Option[Timestamp] = None,
      lastUpdatedDate: Option[Timestamp] = None,
      stageKeys: Option[List[String]] = None,
      tags: Option[MapOfStringToString] = None
    ): ApiKey =
      ApiKey
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(value)(_.value(_))
        .ifSome(name)(_.name(_))
        .ifSome(customerId)(_.customerId(_))
        .ifSome(description)(_.description(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(stageKeys)(_.stageKeys(_))
        .ifSome(tags)(_.tags(_))
        .build

    def apiKeyIds(
      ids: Option[List[String]] = None,
      warnings: Option[List[String]] = None
    ): ApiKeyIds =
      ApiKeyIds
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def apiKeys(
      warnings: Option[List[String]] = None,
      position: Option[String] = None,
      items: Option[List[ApiKey]] = None
    ): ApiKeys =
      ApiKeys
        .builder
        .ifSome(warnings)(_.warnings(_))
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def apiStage(
      apiId: Option[String] = None,
      stage: Option[String] = None,
      throttle: Option[MapOfApiStageThrottleSettings] = None
    ): ApiStage =
      ApiStage
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(throttle)(_.throttle(_))
        .build

    def authorizer(
      id: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      providerARNs: Option[List[ProviderARN]] = None,
      authType: Option[String] = None,
      authorizerUri: Option[String] = None,
      authorizerCredentials: Option[String] = None,
      identitySource: Option[String] = None,
      identityValidationExpression: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None
    ): Authorizer =
      Authorizer
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(providerARNs)(_.providerARNs(_))
        .ifSome(authType)(_.authType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(authorizerCredentials)(_.authorizerCredentials(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .build

    def authorizers(
      position: Option[String] = None,
      items: Option[List[Authorizer]] = None
    ): Authorizers =
      Authorizers
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def basePathMapping(
      basePath: Option[String] = None,
      restApiId: Option[String] = None,
      stage: Option[String] = None
    ): BasePathMapping =
      BasePathMapping
        .builder
        .ifSome(basePath)(_.basePath(_))
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stage)(_.stage(_))
        .build

    def basePathMappings(
      position: Option[String] = None,
      items: Option[List[BasePathMapping]] = None
    ): BasePathMappings =
      BasePathMappings
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def canarySettings(
      percentTraffic: Option[Double] = None,
      deploymentId: Option[String] = None,
      stageVariableOverrides: Option[MapOfStringToString] = None,
      useStageCache: Option[Boolean] = None
    ): CanarySettings =
      CanarySettings
        .builder
        .ifSome(percentTraffic)(_.percentTraffic(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(stageVariableOverrides)(_.stageVariableOverrides(_))
        .ifSome(useStageCache)(_.useStageCache(_))
        .build

    def clientCertificate(
      clientCertificateId: Option[String] = None,
      description: Option[String] = None,
      pemEncodedCertificate: Option[String] = None,
      createdDate: Option[Timestamp] = None,
      expirationDate: Option[Timestamp] = None,
      tags: Option[MapOfStringToString] = None
    ): ClientCertificate =
      ClientCertificate
        .builder
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(description)(_.description(_))
        .ifSome(pemEncodedCertificate)(_.pemEncodedCertificate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def clientCertificates(
      position: Option[String] = None,
      items: Option[List[ClientCertificate]] = None
    ): ClientCertificates =
      ClientCertificates
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createApiKeyRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      enabled: Option[Boolean] = None,
      generateDistinctId: Option[Boolean] = None,
      value: Option[String] = None,
      stageKeys: Option[List[StageKey]] = None,
      customerId: Option[String] = None,
      tags: Option[MapOfStringToString] = None
    ): CreateApiKeyRequest =
      CreateApiKeyRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(generateDistinctId)(_.generateDistinctId(_))
        .ifSome(value)(_.value(_))
        .ifSome(stageKeys)(_.stageKeys(_))
        .ifSome(customerId)(_.customerId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAuthorizerRequest(
      restApiId: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      providerARNs: Option[List[ProviderARN]] = None,
      authType: Option[String] = None,
      authorizerUri: Option[String] = None,
      authorizerCredentials: Option[String] = None,
      identitySource: Option[String] = None,
      identityValidationExpression: Option[String] = None,
      authorizerResultTtlInSeconds: Option[Int] = None
    ): CreateAuthorizerRequest =
      CreateAuthorizerRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(providerARNs)(_.providerARNs(_))
        .ifSome(authType)(_.authType(_))
        .ifSome(authorizerUri)(_.authorizerUri(_))
        .ifSome(authorizerCredentials)(_.authorizerCredentials(_))
        .ifSome(identitySource)(_.identitySource(_))
        .ifSome(identityValidationExpression)(_.identityValidationExpression(_))
        .ifSome(authorizerResultTtlInSeconds)(_.authorizerResultTtlInSeconds(_))
        .build

    def createBasePathMappingRequest(
      domainName: Option[String] = None,
      basePath: Option[String] = None,
      restApiId: Option[String] = None,
      stage: Option[String] = None
    ): CreateBasePathMappingRequest =
      CreateBasePathMappingRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(basePath)(_.basePath(_))
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stage)(_.stage(_))
        .build

    def createDeploymentRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None,
      stageDescription: Option[String] = None,
      description: Option[String] = None,
      cacheClusterEnabled: Option[Boolean] = None,
      cacheClusterSize: Option[String] = None,
      variables: Option[MapOfStringToString] = None,
      canarySettings: Option[DeploymentCanarySettings] = None,
      tracingEnabled: Option[Boolean] = None
    ): CreateDeploymentRequest =
      CreateDeploymentRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageDescription)(_.stageDescription(_))
        .ifSome(description)(_.description(_))
        .ifSome(cacheClusterEnabled)(_.cacheClusterEnabled(_))
        .ifSome(cacheClusterSize)(_.cacheClusterSize(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(canarySettings)(_.canarySettings(_))
        .ifSome(tracingEnabled)(_.tracingEnabled(_))
        .build

    def createDocumentationPartRequest(
      restApiId: Option[String] = None,
      location: Option[DocumentationPartLocation] = None,
      properties: Option[String] = None
    ): CreateDocumentationPartRequest =
      CreateDocumentationPartRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(location)(_.location(_))
        .ifSome(properties)(_.properties(_))
        .build

    def createDocumentationVersionRequest(
      restApiId: Option[String] = None,
      documentationVersion: Option[String] = None,
      stageName: Option[String] = None,
      description: Option[String] = None
    ): CreateDocumentationVersionRequest =
      CreateDocumentationVersionRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(documentationVersion)(_.documentationVersion(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(description)(_.description(_))
        .build

    def createDomainNameRequest(
      domainName: Option[String] = None,
      certificateName: Option[String] = None,
      certificateBody: Option[String] = None,
      certificatePrivateKey: Option[String] = None,
      certificateChain: Option[String] = None,
      certificateArn: Option[String] = None,
      regionalCertificateName: Option[String] = None,
      regionalCertificateArn: Option[String] = None,
      endpointConfiguration: Option[EndpointConfiguration] = None,
      tags: Option[MapOfStringToString] = None,
      securityPolicy: Option[String] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthenticationInput] = None
    ): CreateDomainNameRequest =
      CreateDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(certificateBody)(_.certificateBody(_))
        .ifSome(certificatePrivateKey)(_.certificatePrivateKey(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(regionalCertificateName)(_.regionalCertificateName(_))
        .ifSome(regionalCertificateArn)(_.regionalCertificateArn(_))
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(securityPolicy)(_.securityPolicy(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .build

    def createModelRequest(
      restApiId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      schema: Option[String] = None,
      contentType: Option[String] = None
    ): CreateModelRequest =
      CreateModelRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def createRequestValidatorRequest(
      restApiId: Option[String] = None,
      name: Option[String] = None,
      validateRequestBody: Option[Boolean] = None,
      validateRequestParameters: Option[Boolean] = None
    ): CreateRequestValidatorRequest =
      CreateRequestValidatorRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(validateRequestBody)(_.validateRequestBody(_))
        .ifSome(validateRequestParameters)(_.validateRequestParameters(_))
        .build

    def createResourceRequest(
      restApiId: Option[String] = None,
      parentId: Option[String] = None,
      pathPart: Option[String] = None
    ): CreateResourceRequest =
      CreateResourceRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(parentId)(_.parentId(_))
        .ifSome(pathPart)(_.pathPart(_))
        .build

    def createRestApiRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      version: Option[String] = None,
      cloneFrom: Option[String] = None,
      binaryMediaTypes: Option[List[String]] = None,
      minimumCompressionSize: Option[Int] = None,
      apiKeySource: Option[String] = None,
      endpointConfiguration: Option[EndpointConfiguration] = None,
      policy: Option[String] = None,
      tags: Option[MapOfStringToString] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None
    ): CreateRestApiRequest =
      CreateRestApiRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(version)(_.version(_))
        .ifSome(cloneFrom)(_.cloneFrom(_))
        .ifSome(binaryMediaTypes)(_.binaryMediaTypes(_))
        .ifSome(minimumCompressionSize)(_.minimumCompressionSize(_))
        .ifSome(apiKeySource)(_.apiKeySource(_))
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .build

    def createStageRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None,
      deploymentId: Option[String] = None,
      description: Option[String] = None,
      cacheClusterEnabled: Option[Boolean] = None,
      cacheClusterSize: Option[String] = None,
      variables: Option[MapOfStringToString] = None,
      documentationVersion: Option[String] = None,
      canarySettings: Option[CanarySettings] = None,
      tracingEnabled: Option[Boolean] = None,
      tags: Option[MapOfStringToString] = None
    ): CreateStageRequest =
      CreateStageRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(cacheClusterEnabled)(_.cacheClusterEnabled(_))
        .ifSome(cacheClusterSize)(_.cacheClusterSize(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(documentationVersion)(_.documentationVersion(_))
        .ifSome(canarySettings)(_.canarySettings(_))
        .ifSome(tracingEnabled)(_.tracingEnabled(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUsagePlanKeyRequest(
      usagePlanId: Option[String] = None,
      keyId: Option[String] = None,
      keyType: Option[String] = None
    ): CreateUsagePlanKeyRequest =
      CreateUsagePlanKeyRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(keyType)(_.keyType(_))
        .build

    def createUsagePlanRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      apiStages: Option[List[ApiStage]] = None,
      throttle: Option[ThrottleSettings] = None,
      quota: Option[QuotaSettings] = None,
      tags: Option[MapOfStringToString] = None
    ): CreateUsagePlanRequest =
      CreateUsagePlanRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(apiStages)(_.apiStages(_))
        .ifSome(throttle)(_.throttle(_))
        .ifSome(quota)(_.quota(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVpcLinkRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      targetArns: Option[List[String]] = None,
      tags: Option[MapOfStringToString] = None
    ): CreateVpcLinkRequest =
      CreateVpcLinkRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(targetArns)(_.targetArns(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteApiKeyRequest(
      apiKey: Option[String] = None
    ): DeleteApiKeyRequest =
      DeleteApiKeyRequest
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .build

    def deleteAuthorizerRequest(
      restApiId: Option[String] = None,
      authorizerId: Option[String] = None
    ): DeleteAuthorizerRequest =
      DeleteAuthorizerRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .build

    def deleteBasePathMappingRequest(
      domainName: Option[String] = None,
      basePath: Option[String] = None
    ): DeleteBasePathMappingRequest =
      DeleteBasePathMappingRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(basePath)(_.basePath(_))
        .build

    def deleteClientCertificateRequest(
      clientCertificateId: Option[String] = None
    ): DeleteClientCertificateRequest =
      DeleteClientCertificateRequest
        .builder
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .build

    def deleteDeploymentRequest(
      restApiId: Option[String] = None,
      deploymentId: Option[String] = None
    ): DeleteDeploymentRequest =
      DeleteDeploymentRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def deleteDocumentationPartRequest(
      restApiId: Option[String] = None,
      documentationPartId: Option[String] = None
    ): DeleteDocumentationPartRequest =
      DeleteDocumentationPartRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(documentationPartId)(_.documentationPartId(_))
        .build

    def deleteDocumentationVersionRequest(
      restApiId: Option[String] = None,
      documentationVersion: Option[String] = None
    ): DeleteDocumentationVersionRequest =
      DeleteDocumentationVersionRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(documentationVersion)(_.documentationVersion(_))
        .build

    def deleteDomainNameRequest(
      domainName: Option[String] = None
    ): DeleteDomainNameRequest =
      DeleteDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteGatewayResponseRequest(
      restApiId: Option[String] = None,
      responseType: Option[String] = None
    ): DeleteGatewayResponseRequest =
      DeleteGatewayResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(responseType)(_.responseType(_))
        .build

    def deleteIntegrationRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None
    ): DeleteIntegrationRequest =
      DeleteIntegrationRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .build

    def deleteIntegrationResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None
    ): DeleteIntegrationResponseRequest =
      DeleteIntegrationResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def deleteMethodRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None
    ): DeleteMethodRequest =
      DeleteMethodRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .build

    def deleteMethodResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None
    ): DeleteMethodResponseRequest =
      DeleteMethodResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def deleteModelRequest(
      restApiId: Option[String] = None,
      modelName: Option[String] = None
    ): DeleteModelRequest =
      DeleteModelRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(modelName)(_.modelName(_))
        .build

    def deleteRequestValidatorRequest(
      restApiId: Option[String] = None,
      requestValidatorId: Option[String] = None
    ): DeleteRequestValidatorRequest =
      DeleteRequestValidatorRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(requestValidatorId)(_.requestValidatorId(_))
        .build

    def deleteResourceRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None
    ): DeleteResourceRequest =
      DeleteResourceRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def deleteRestApiRequest(
      restApiId: Option[String] = None
    ): DeleteRestApiRequest =
      DeleteRestApiRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .build

    def deleteStageRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None
    ): DeleteStageRequest =
      DeleteStageRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def deleteUsagePlanKeyRequest(
      usagePlanId: Option[String] = None,
      keyId: Option[String] = None
    ): DeleteUsagePlanKeyRequest =
      DeleteUsagePlanKeyRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def deleteUsagePlanRequest(
      usagePlanId: Option[String] = None
    ): DeleteUsagePlanRequest =
      DeleteUsagePlanRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .build

    def deleteVpcLinkRequest(
      vpcLinkId: Option[String] = None
    ): DeleteVpcLinkRequest =
      DeleteVpcLinkRequest
        .builder
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .build

    def deployment(
      id: Option[String] = None,
      description: Option[String] = None,
      createdDate: Option[Timestamp] = None,
      apiSummary: Option[PathToMapOfMethodSnapshot] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(apiSummary)(_.apiSummary(_))
        .build

    def deploymentCanarySettings(
      percentTraffic: Option[Double] = None,
      stageVariableOverrides: Option[MapOfStringToString] = None,
      useStageCache: Option[Boolean] = None
    ): DeploymentCanarySettings =
      DeploymentCanarySettings
        .builder
        .ifSome(percentTraffic)(_.percentTraffic(_))
        .ifSome(stageVariableOverrides)(_.stageVariableOverrides(_))
        .ifSome(useStageCache)(_.useStageCache(_))
        .build

    def deployments(
      position: Option[String] = None,
      items: Option[List[Deployment]] = None
    ): Deployments =
      Deployments
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def documentationPart(
      id: Option[String] = None,
      location: Option[DocumentationPartLocation] = None,
      properties: Option[String] = None
    ): DocumentationPart =
      DocumentationPart
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(location)(_.location(_))
        .ifSome(properties)(_.properties(_))
        .build

    def documentationPartIds(
      ids: Option[List[String]] = None,
      warnings: Option[List[String]] = None
    ): DocumentationPartIds =
      DocumentationPartIds
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def documentationPartLocation(
      `type`: Option[String] = None,
      path: Option[String] = None,
      method: Option[String] = None,
      statusCode: Option[String] = None,
      name: Option[String] = None
    ): DocumentationPartLocation =
      DocumentationPartLocation
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(path)(_.path(_))
        .ifSome(method)(_.method(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(name)(_.name(_))
        .build

    def documentationParts(
      position: Option[String] = None,
      items: Option[List[DocumentationPart]] = None
    ): DocumentationParts =
      DocumentationParts
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def documentationVersion(
      version: Option[String] = None,
      createdDate: Option[Timestamp] = None,
      description: Option[String] = None
    ): DocumentationVersion =
      DocumentationVersion
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .build

    def documentationVersions(
      position: Option[String] = None,
      items: Option[List[DocumentationVersion]] = None
    ): DocumentationVersions =
      DocumentationVersions
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def domainName(
      domainName: Option[String] = None,
      certificateName: Option[String] = None,
      certificateArn: Option[String] = None,
      certificateUploadDate: Option[Timestamp] = None,
      regionalDomainName: Option[String] = None,
      regionalHostedZoneId: Option[String] = None,
      regionalCertificateName: Option[String] = None,
      regionalCertificateArn: Option[String] = None,
      distributionDomainName: Option[String] = None,
      distributionHostedZoneId: Option[String] = None,
      endpointConfiguration: Option[EndpointConfiguration] = None,
      domainNameStatus: Option[String] = None,
      domainNameStatusMessage: Option[String] = None,
      securityPolicy: Option[String] = None,
      tags: Option[MapOfStringToString] = None,
      mutualTlsAuthentication: Option[MutualTlsAuthentication] = None
    ): DomainName =
      DomainName
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateUploadDate)(_.certificateUploadDate(_))
        .ifSome(regionalDomainName)(_.regionalDomainName(_))
        .ifSome(regionalHostedZoneId)(_.regionalHostedZoneId(_))
        .ifSome(regionalCertificateName)(_.regionalCertificateName(_))
        .ifSome(regionalCertificateArn)(_.regionalCertificateArn(_))
        .ifSome(distributionDomainName)(_.distributionDomainName(_))
        .ifSome(distributionHostedZoneId)(_.distributionHostedZoneId(_))
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .ifSome(domainNameStatus)(_.domainNameStatus(_))
        .ifSome(domainNameStatusMessage)(_.domainNameStatusMessage(_))
        .ifSome(securityPolicy)(_.securityPolicy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(mutualTlsAuthentication)(_.mutualTlsAuthentication(_))
        .build

    def domainNames(
      position: Option[String] = None,
      items: Option[List[DomainName]] = None
    ): DomainNames =
      DomainNames
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def endpointConfiguration(
      types: Option[List[EndpointType]] = None,
      vpcEndpointIds: Option[List[String]] = None
    ): EndpointConfiguration =
      EndpointConfiguration
        .builder
        .ifSome(types)(_.types(_))
        .ifSome(vpcEndpointIds)(_.vpcEndpointIds(_))
        .build

    def exportResponse(
      contentType: Option[String] = None,
      contentDisposition: Option[String] = None,
      body: Option[Blob] = None
    ): ExportResponse =
      ExportResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(body)(_.body(_))
        .build

    def flushStageAuthorizersCacheRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None
    ): FlushStageAuthorizersCacheRequest =
      FlushStageAuthorizersCacheRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def flushStageCacheRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None
    ): FlushStageCacheRequest =
      FlushStageCacheRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def gatewayResponse(
      responseType: Option[String] = None,
      statusCode: Option[String] = None,
      responseParameters: Option[MapOfStringToString] = None,
      responseTemplates: Option[MapOfStringToString] = None,
      defaultResponse: Option[Boolean] = None
    ): GatewayResponse =
      GatewayResponse
        .builder
        .ifSome(responseType)(_.responseType(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(defaultResponse)(_.defaultResponse(_))
        .build

    def gatewayResponses(
      position: Option[String] = None,
      items: Option[List[GatewayResponse]] = None
    ): GatewayResponses =
      GatewayResponses
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def generateClientCertificateRequest(
      description: Option[String] = None,
      tags: Option[MapOfStringToString] = None
    ): GenerateClientCertificateRequest =
      GenerateClientCertificateRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getAccountRequest(

    ): GetAccountRequest =
      GetAccountRequest
        .builder

        .build

    def getApiKeyRequest(
      apiKey: Option[String] = None,
      includeValue: Option[Boolean] = None
    ): GetApiKeyRequest =
      GetApiKeyRequest
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .ifSome(includeValue)(_.includeValue(_))
        .build

    def getApiKeysRequest(
      position: Option[String] = None,
      limit: Option[Int] = None,
      nameQuery: Option[String] = None,
      customerId: Option[String] = None,
      includeValues: Option[Boolean] = None
    ): GetApiKeysRequest =
      GetApiKeysRequest
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nameQuery)(_.nameQuery(_))
        .ifSome(customerId)(_.customerId(_))
        .ifSome(includeValues)(_.includeValues(_))
        .build

    def getAuthorizerRequest(
      restApiId: Option[String] = None,
      authorizerId: Option[String] = None
    ): GetAuthorizerRequest =
      GetAuthorizerRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .build

    def getAuthorizersRequest(
      restApiId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetAuthorizersRequest =
      GetAuthorizersRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getBasePathMappingRequest(
      domainName: Option[String] = None,
      basePath: Option[String] = None
    ): GetBasePathMappingRequest =
      GetBasePathMappingRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(basePath)(_.basePath(_))
        .build

    def getBasePathMappingsRequest(
      domainName: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetBasePathMappingsRequest =
      GetBasePathMappingsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getClientCertificateRequest(
      clientCertificateId: Option[String] = None
    ): GetClientCertificateRequest =
      GetClientCertificateRequest
        .builder
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .build

    def getClientCertificatesRequest(
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetClientCertificatesRequest =
      GetClientCertificatesRequest
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getDeploymentRequest(
      restApiId: Option[String] = None,
      deploymentId: Option[String] = None,
      embed: Option[List[String]] = None
    ): GetDeploymentRequest =
      GetDeploymentRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(embed)(_.embed(_))
        .build

    def getDeploymentsRequest(
      restApiId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetDeploymentsRequest =
      GetDeploymentsRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getDocumentationPartRequest(
      restApiId: Option[String] = None,
      documentationPartId: Option[String] = None
    ): GetDocumentationPartRequest =
      GetDocumentationPartRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(documentationPartId)(_.documentationPartId(_))
        .build

    def getDocumentationPartsRequest(
      restApiId: Option[String] = None,
      `type`: Option[String] = None,
      nameQuery: Option[String] = None,
      path: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None,
      locationStatus: Option[String] = None
    ): GetDocumentationPartsRequest =
      GetDocumentationPartsRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(nameQuery)(_.nameQuery(_))
        .ifSome(path)(_.path(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(locationStatus)(_.locationStatus(_))
        .build

    def getDocumentationVersionRequest(
      restApiId: Option[String] = None,
      documentationVersion: Option[String] = None
    ): GetDocumentationVersionRequest =
      GetDocumentationVersionRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(documentationVersion)(_.documentationVersion(_))
        .build

    def getDocumentationVersionsRequest(
      restApiId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetDocumentationVersionsRequest =
      GetDocumentationVersionsRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getDomainNameRequest(
      domainName: Option[String] = None
    ): GetDomainNameRequest =
      GetDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getDomainNamesRequest(
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetDomainNamesRequest =
      GetDomainNamesRequest
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getExportRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None,
      exportType: Option[String] = None,
      parameters: Option[MapOfStringToString] = None,
      accepts: Option[String] = None
    ): GetExportRequest =
      GetExportRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(exportType)(_.exportType(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(accepts)(_.accepts(_))
        .build

    def getGatewayResponseRequest(
      restApiId: Option[String] = None,
      responseType: Option[String] = None
    ): GetGatewayResponseRequest =
      GetGatewayResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(responseType)(_.responseType(_))
        .build

    def getGatewayResponsesRequest(
      restApiId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetGatewayResponsesRequest =
      GetGatewayResponsesRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getIntegrationRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None
    ): GetIntegrationRequest =
      GetIntegrationRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .build

    def getIntegrationResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None
    ): GetIntegrationResponseRequest =
      GetIntegrationResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def getMethodRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None
    ): GetMethodRequest =
      GetMethodRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .build

    def getMethodResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None
    ): GetMethodResponseRequest =
      GetMethodResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def getModelRequest(
      restApiId: Option[String] = None,
      modelName: Option[String] = None,
      flatten: Option[Boolean] = None
    ): GetModelRequest =
      GetModelRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(flatten)(_.flatten(_))
        .build

    def getModelTemplateRequest(
      restApiId: Option[String] = None,
      modelName: Option[String] = None
    ): GetModelTemplateRequest =
      GetModelTemplateRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(modelName)(_.modelName(_))
        .build

    def getModelsRequest(
      restApiId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetModelsRequest =
      GetModelsRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getRequestValidatorRequest(
      restApiId: Option[String] = None,
      requestValidatorId: Option[String] = None
    ): GetRequestValidatorRequest =
      GetRequestValidatorRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(requestValidatorId)(_.requestValidatorId(_))
        .build

    def getRequestValidatorsRequest(
      restApiId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetRequestValidatorsRequest =
      GetRequestValidatorsRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getResourceRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      embed: Option[List[String]] = None
    ): GetResourceRequest =
      GetResourceRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(embed)(_.embed(_))
        .build

    def getResourcesRequest(
      restApiId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None,
      embed: Option[List[String]] = None
    ): GetResourcesRequest =
      GetResourcesRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(embed)(_.embed(_))
        .build

    def getRestApiRequest(
      restApiId: Option[String] = None
    ): GetRestApiRequest =
      GetRestApiRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .build

    def getRestApisRequest(
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetRestApisRequest =
      GetRestApisRequest
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getSdkRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None,
      sdkType: Option[String] = None,
      parameters: Option[MapOfStringToString] = None
    ): GetSdkRequest =
      GetSdkRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(sdkType)(_.sdkType(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def getSdkTypeRequest(
      id: Option[String] = None
    ): GetSdkTypeRequest =
      GetSdkTypeRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getSdkTypesRequest(
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetSdkTypesRequest =
      GetSdkTypesRequest
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getStageRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None
    ): GetStageRequest =
      GetStageRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def getStagesRequest(
      restApiId: Option[String] = None,
      deploymentId: Option[String] = None
    ): GetStagesRequest =
      GetStagesRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def getTagsRequest(
      resourceArn: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetTagsRequest =
      GetTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getUsagePlanKeyRequest(
      usagePlanId: Option[String] = None,
      keyId: Option[String] = None
    ): GetUsagePlanKeyRequest =
      GetUsagePlanKeyRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def getUsagePlanKeysRequest(
      usagePlanId: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None,
      nameQuery: Option[String] = None
    ): GetUsagePlanKeysRequest =
      GetUsagePlanKeysRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nameQuery)(_.nameQuery(_))
        .build

    def getUsagePlanRequest(
      usagePlanId: Option[String] = None
    ): GetUsagePlanRequest =
      GetUsagePlanRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .build

    def getUsagePlansRequest(
      position: Option[String] = None,
      keyId: Option[String] = None,
      limit: Option[Int] = None
    ): GetUsagePlansRequest =
      GetUsagePlansRequest
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getUsageRequest(
      usagePlanId: Option[String] = None,
      keyId: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetUsageRequest =
      GetUsageRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getVpcLinkRequest(
      vpcLinkId: Option[String] = None
    ): GetVpcLinkRequest =
      GetVpcLinkRequest
        .builder
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .build

    def getVpcLinksRequest(
      position: Option[String] = None,
      limit: Option[Int] = None
    ): GetVpcLinksRequest =
      GetVpcLinksRequest
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(limit)(_.limit(_))
        .build

    def importApiKeysRequest(
      body: Option[Blob] = None,
      format: Option[String] = None,
      failOnWarnings: Option[Boolean] = None
    ): ImportApiKeysRequest =
      ImportApiKeysRequest
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(format)(_.format(_))
        .ifSome(failOnWarnings)(_.failOnWarnings(_))
        .build

    def importDocumentationPartsRequest(
      restApiId: Option[String] = None,
      mode: Option[String] = None,
      failOnWarnings: Option[Boolean] = None,
      body: Option[Blob] = None
    ): ImportDocumentationPartsRequest =
      ImportDocumentationPartsRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(failOnWarnings)(_.failOnWarnings(_))
        .ifSome(body)(_.body(_))
        .build

    def importRestApiRequest(
      failOnWarnings: Option[Boolean] = None,
      parameters: Option[MapOfStringToString] = None,
      body: Option[Blob] = None
    ): ImportRestApiRequest =
      ImportRestApiRequest
        .builder
        .ifSome(failOnWarnings)(_.failOnWarnings(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(body)(_.body(_))
        .build

    def integration(
      `type`: Option[String] = None,
      httpMethod: Option[String] = None,
      uri: Option[String] = None,
      connectionType: Option[String] = None,
      connectionId: Option[String] = None,
      credentials: Option[String] = None,
      requestParameters: Option[MapOfStringToString] = None,
      requestTemplates: Option[MapOfStringToString] = None,
      passthroughBehavior: Option[String] = None,
      contentHandling: Option[String] = None,
      timeoutInMillis: Option[Int] = None,
      cacheNamespace: Option[String] = None,
      cacheKeyParameters: Option[List[String]] = None,
      integrationResponses: Option[MapOfIntegrationResponse] = None,
      tlsConfig: Option[TlsConfig] = None
    ): Integration =
      Integration
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(credentials)(_.credentials(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestTemplates)(_.requestTemplates(_))
        .ifSome(passthroughBehavior)(_.passthroughBehavior(_))
        .ifSome(contentHandling)(_.contentHandling(_))
        .ifSome(timeoutInMillis)(_.timeoutInMillis(_))
        .ifSome(cacheNamespace)(_.cacheNamespace(_))
        .ifSome(cacheKeyParameters)(_.cacheKeyParameters(_))
        .ifSome(integrationResponses)(_.integrationResponses(_))
        .ifSome(tlsConfig)(_.tlsConfig(_))
        .build

    def integrationResponse(
      statusCode: Option[String] = None,
      selectionPattern: Option[String] = None,
      responseParameters: Option[MapOfStringToString] = None,
      responseTemplates: Option[MapOfStringToString] = None,
      contentHandling: Option[String] = None
    ): IntegrationResponse =
      IntegrationResponse
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(selectionPattern)(_.selectionPattern(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(contentHandling)(_.contentHandling(_))
        .build

    def limitExceededException(
      retryAfterSeconds: Option[String] = None,
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def method(
      httpMethod: Option[String] = None,
      authorizationType: Option[String] = None,
      authorizerId: Option[String] = None,
      apiKeyRequired: Option[Boolean] = None,
      requestValidatorId: Option[String] = None,
      operationName: Option[String] = None,
      requestParameters: Option[MapOfStringToBoolean] = None,
      requestModels: Option[MapOfStringToString] = None,
      methodResponses: Option[MapOfMethodResponse] = None,
      methodIntegration: Option[Integration] = None,
      authorizationScopes: Option[List[String]] = None
    ): Method =
      Method
        .builder
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .ifSome(requestValidatorId)(_.requestValidatorId(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestModels)(_.requestModels(_))
        .ifSome(methodResponses)(_.methodResponses(_))
        .ifSome(methodIntegration)(_.methodIntegration(_))
        .ifSome(authorizationScopes)(_.authorizationScopes(_))
        .build

    def methodResponse(
      statusCode: Option[String] = None,
      responseParameters: Option[MapOfStringToBoolean] = None,
      responseModels: Option[MapOfStringToString] = None
    ): MethodResponse =
      MethodResponse
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseModels)(_.responseModels(_))
        .build

    def methodSetting(
      metricsEnabled: Option[Boolean] = None,
      loggingLevel: Option[String] = None,
      dataTraceEnabled: Option[Boolean] = None,
      throttlingBurstLimit: Option[Int] = None,
      throttlingRateLimit: Option[Double] = None,
      cachingEnabled: Option[Boolean] = None,
      cacheTtlInSeconds: Option[Int] = None,
      cacheDataEncrypted: Option[Boolean] = None,
      requireAuthorizationForCacheControl: Option[Boolean] = None,
      unauthorizedCacheControlHeaderStrategy: Option[String] = None
    ): MethodSetting =
      MethodSetting
        .builder
        .ifSome(metricsEnabled)(_.metricsEnabled(_))
        .ifSome(loggingLevel)(_.loggingLevel(_))
        .ifSome(dataTraceEnabled)(_.dataTraceEnabled(_))
        .ifSome(throttlingBurstLimit)(_.throttlingBurstLimit(_))
        .ifSome(throttlingRateLimit)(_.throttlingRateLimit(_))
        .ifSome(cachingEnabled)(_.cachingEnabled(_))
        .ifSome(cacheTtlInSeconds)(_.cacheTtlInSeconds(_))
        .ifSome(cacheDataEncrypted)(_.cacheDataEncrypted(_))
        .ifSome(requireAuthorizationForCacheControl)(_.requireAuthorizationForCacheControl(_))
        .ifSome(unauthorizedCacheControlHeaderStrategy)(_.unauthorizedCacheControlHeaderStrategy(_))
        .build

    def methodSnapshot(
      authorizationType: Option[String] = None,
      apiKeyRequired: Option[Boolean] = None
    ): MethodSnapshot =
      MethodSnapshot
        .builder
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .build

    def model(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      schema: Option[String] = None,
      contentType: Option[String] = None
    ): Model =
      Model
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def models(
      position: Option[String] = None,
      items: Option[List[Model]] = None
    ): Models =
      Models
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def mutualTlsAuthentication(
      truststoreUri: Option[String] = None,
      truststoreVersion: Option[String] = None,
      truststoreWarnings: Option[List[String]] = None
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
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def patchOperation(
      op: Option[String] = None,
      path: Option[String] = None,
      value: Option[String] = None,
      from: Option[String] = None
    ): PatchOperation =
      PatchOperation
        .builder
        .ifSome(op)(_.op(_))
        .ifSome(path)(_.path(_))
        .ifSome(value)(_.value(_))
        .ifSome(from)(_.from(_))
        .build

    def putGatewayResponseRequest(
      restApiId: Option[String] = None,
      responseType: Option[String] = None,
      statusCode: Option[String] = None,
      responseParameters: Option[MapOfStringToString] = None,
      responseTemplates: Option[MapOfStringToString] = None
    ): PutGatewayResponseRequest =
      PutGatewayResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(responseType)(_.responseType(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .build

    def putIntegrationRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      `type`: Option[String] = None,
      integrationHttpMethod: Option[String] = None,
      uri: Option[String] = None,
      connectionType: Option[String] = None,
      connectionId: Option[String] = None,
      credentials: Option[String] = None,
      requestParameters: Option[MapOfStringToString] = None,
      requestTemplates: Option[MapOfStringToString] = None,
      passthroughBehavior: Option[String] = None,
      cacheNamespace: Option[String] = None,
      cacheKeyParameters: Option[List[String]] = None,
      contentHandling: Option[String] = None,
      timeoutInMillis: Option[Int] = None,
      tlsConfig: Option[TlsConfig] = None
    ): PutIntegrationRequest =
      PutIntegrationRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(integrationHttpMethod)(_.integrationHttpMethod(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(connectionId)(_.connectionId(_))
        .ifSome(credentials)(_.credentials(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestTemplates)(_.requestTemplates(_))
        .ifSome(passthroughBehavior)(_.passthroughBehavior(_))
        .ifSome(cacheNamespace)(_.cacheNamespace(_))
        .ifSome(cacheKeyParameters)(_.cacheKeyParameters(_))
        .ifSome(contentHandling)(_.contentHandling(_))
        .ifSome(timeoutInMillis)(_.timeoutInMillis(_))
        .ifSome(tlsConfig)(_.tlsConfig(_))
        .build

    def putIntegrationResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None,
      selectionPattern: Option[String] = None,
      responseParameters: Option[MapOfStringToString] = None,
      responseTemplates: Option[MapOfStringToString] = None,
      contentHandling: Option[String] = None
    ): PutIntegrationResponseRequest =
      PutIntegrationResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(selectionPattern)(_.selectionPattern(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseTemplates)(_.responseTemplates(_))
        .ifSome(contentHandling)(_.contentHandling(_))
        .build

    def putMethodRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      authorizationType: Option[String] = None,
      authorizerId: Option[String] = None,
      apiKeyRequired: Option[Boolean] = None,
      operationName: Option[String] = None,
      requestParameters: Option[MapOfStringToBoolean] = None,
      requestModels: Option[MapOfStringToString] = None,
      requestValidatorId: Option[String] = None,
      authorizationScopes: Option[List[String]] = None
    ): PutMethodRequest =
      PutMethodRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(apiKeyRequired)(_.apiKeyRequired(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(requestParameters)(_.requestParameters(_))
        .ifSome(requestModels)(_.requestModels(_))
        .ifSome(requestValidatorId)(_.requestValidatorId(_))
        .ifSome(authorizationScopes)(_.authorizationScopes(_))
        .build

    def putMethodResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None,
      responseParameters: Option[MapOfStringToBoolean] = None,
      responseModels: Option[MapOfStringToString] = None
    ): PutMethodResponseRequest =
      PutMethodResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(responseParameters)(_.responseParameters(_))
        .ifSome(responseModels)(_.responseModels(_))
        .build

    def putRestApiRequest(
      restApiId: Option[String] = None,
      mode: Option[String] = None,
      failOnWarnings: Option[Boolean] = None,
      parameters: Option[MapOfStringToString] = None,
      body: Option[Blob] = None
    ): PutRestApiRequest =
      PutRestApiRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(failOnWarnings)(_.failOnWarnings(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(body)(_.body(_))
        .build

    def quotaSettings(
      limit: Option[Int] = None,
      offset: Option[Int] = None,
      period: Option[String] = None
    ): QuotaSettings =
      QuotaSettings
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(offset)(_.offset(_))
        .ifSome(period)(_.period(_))
        .build

    def requestValidator(
      id: Option[String] = None,
      name: Option[String] = None,
      validateRequestBody: Option[Boolean] = None,
      validateRequestParameters: Option[Boolean] = None
    ): RequestValidator =
      RequestValidator
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(validateRequestBody)(_.validateRequestBody(_))
        .ifSome(validateRequestParameters)(_.validateRequestParameters(_))
        .build

    def requestValidators(
      position: Option[String] = None,
      items: Option[List[RequestValidator]] = None
    ): RequestValidators =
      RequestValidators
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def resource(
      id: Option[String] = None,
      parentId: Option[String] = None,
      pathPart: Option[String] = None,
      path: Option[String] = None,
      resourceMethods: Option[MapOfMethod] = None
    ): Resource =
      Resource
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(parentId)(_.parentId(_))
        .ifSome(pathPart)(_.pathPart(_))
        .ifSome(path)(_.path(_))
        .ifSome(resourceMethods)(_.resourceMethods(_))
        .build

    def resources(
      position: Option[String] = None,
      items: Option[List[Resource]] = None
    ): Resources =
      Resources
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def restApi(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      createdDate: Option[Timestamp] = None,
      version: Option[String] = None,
      warnings: Option[List[String]] = None,
      binaryMediaTypes: Option[List[String]] = None,
      minimumCompressionSize: Option[Int] = None,
      apiKeySource: Option[String] = None,
      endpointConfiguration: Option[EndpointConfiguration] = None,
      policy: Option[String] = None,
      tags: Option[MapOfStringToString] = None,
      disableExecuteApiEndpoint: Option[Boolean] = None
    ): RestApi =
      RestApi
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(warnings)(_.warnings(_))
        .ifSome(binaryMediaTypes)(_.binaryMediaTypes(_))
        .ifSome(minimumCompressionSize)(_.minimumCompressionSize(_))
        .ifSome(apiKeySource)(_.apiKeySource(_))
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(disableExecuteApiEndpoint)(_.disableExecuteApiEndpoint(_))
        .build

    def restApis(
      position: Option[String] = None,
      items: Option[List[RestApi]] = None
    ): RestApis =
      RestApis
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def sdkConfigurationProperty(
      name: Option[String] = None,
      friendlyName: Option[String] = None,
      description: Option[String] = None,
      required: Option[Boolean] = None,
      defaultValue: Option[String] = None
    ): SdkConfigurationProperty =
      SdkConfigurationProperty
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(friendlyName)(_.friendlyName(_))
        .ifSome(description)(_.description(_))
        .ifSome(required)(_.required(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def sdkResponse(
      contentType: Option[String] = None,
      contentDisposition: Option[String] = None,
      body: Option[Blob] = None
    ): SdkResponse =
      SdkResponse
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(body)(_.body(_))
        .build

    def sdkType(
      id: Option[String] = None,
      friendlyName: Option[String] = None,
      description: Option[String] = None,
      configurationProperties: Option[List[SdkConfigurationProperty]] = None
    ): SdkType =
      SdkType
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(friendlyName)(_.friendlyName(_))
        .ifSome(description)(_.description(_))
        .ifSome(configurationProperties)(_.configurationProperties(_))
        .build

    def sdkTypes(
      position: Option[String] = None,
      items: Option[List[SdkType]] = None
    ): SdkTypes =
      SdkTypes
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def serviceUnavailableException(
      retryAfterSeconds: Option[String] = None,
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def stage(
      deploymentId: Option[String] = None,
      clientCertificateId: Option[String] = None,
      stageName: Option[String] = None,
      description: Option[String] = None,
      cacheClusterEnabled: Option[Boolean] = None,
      cacheClusterSize: Option[String] = None,
      cacheClusterStatus: Option[String] = None,
      methodSettings: Option[MapOfMethodSettings] = None,
      variables: Option[MapOfStringToString] = None,
      documentationVersion: Option[String] = None,
      accessLogSettings: Option[AccessLogSettings] = None,
      canarySettings: Option[CanarySettings] = None,
      tracingEnabled: Option[Boolean] = None,
      webAclArn: Option[String] = None,
      tags: Option[MapOfStringToString] = None,
      createdDate: Option[Timestamp] = None,
      lastUpdatedDate: Option[Timestamp] = None
    ): Stage =
      Stage
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(description)(_.description(_))
        .ifSome(cacheClusterEnabled)(_.cacheClusterEnabled(_))
        .ifSome(cacheClusterSize)(_.cacheClusterSize(_))
        .ifSome(cacheClusterStatus)(_.cacheClusterStatus(_))
        .ifSome(methodSettings)(_.methodSettings(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(documentationVersion)(_.documentationVersion(_))
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(canarySettings)(_.canarySettings(_))
        .ifSome(tracingEnabled)(_.tracingEnabled(_))
        .ifSome(webAclArn)(_.webAclArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .build

    def stageKey(
      restApiId: Option[String] = None,
      stageName: Option[String] = None
    ): StageKey =
      StageKey
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .build

    def stages(
      item: Option[List[Stage]] = None
    ): Stages =
      Stages
        .builder
        .ifSome(item)(_.item(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[MapOfStringToString] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tags(
      tags: Option[MapOfStringToString] = None
    ): Tags =
      Tags
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def template(
      value: Option[String] = None
    ): Template =
      Template
        .builder
        .ifSome(value)(_.value(_))
        .build

    def testInvokeAuthorizerRequest(
      restApiId: Option[String] = None,
      authorizerId: Option[String] = None,
      headers: Option[MapOfStringToString] = None,
      multiValueHeaders: Option[MapOfStringToList] = None,
      pathWithQueryString: Option[String] = None,
      body: Option[String] = None,
      stageVariables: Option[MapOfStringToString] = None,
      additionalContext: Option[MapOfStringToString] = None
    ): TestInvokeAuthorizerRequest =
      TestInvokeAuthorizerRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(headers)(_.headers(_))
        .ifSome(multiValueHeaders)(_.multiValueHeaders(_))
        .ifSome(pathWithQueryString)(_.pathWithQueryString(_))
        .ifSome(body)(_.body(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(additionalContext)(_.additionalContext(_))
        .build

    def testInvokeAuthorizerResponse(
      clientStatus: Option[Int] = None,
      log: Option[String] = None,
      latency: Option[Long] = None,
      principalId: Option[String] = None,
      policy: Option[String] = None,
      authorization: Option[MapOfStringToList] = None,
      claims: Option[MapOfStringToString] = None
    ): TestInvokeAuthorizerResponse =
      TestInvokeAuthorizerResponse
        .builder
        .ifSome(clientStatus)(_.clientStatus(_))
        .ifSome(log)(_.log(_))
        .ifSome(latency)(_.latency(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(claims)(_.claims(_))
        .build

    def testInvokeMethodRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      pathWithQueryString: Option[String] = None,
      body: Option[String] = None,
      headers: Option[MapOfStringToString] = None,
      multiValueHeaders: Option[MapOfStringToList] = None,
      clientCertificateId: Option[String] = None,
      stageVariables: Option[MapOfStringToString] = None
    ): TestInvokeMethodRequest =
      TestInvokeMethodRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(pathWithQueryString)(_.pathWithQueryString(_))
        .ifSome(body)(_.body(_))
        .ifSome(headers)(_.headers(_))
        .ifSome(multiValueHeaders)(_.multiValueHeaders(_))
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .build

    def testInvokeMethodResponse(
      status: Option[Int] = None,
      body: Option[String] = None,
      headers: Option[MapOfStringToString] = None,
      multiValueHeaders: Option[MapOfStringToList] = None,
      log: Option[String] = None,
      latency: Option[Long] = None
    ): TestInvokeMethodResponse =
      TestInvokeMethodResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(body)(_.body(_))
        .ifSome(headers)(_.headers(_))
        .ifSome(multiValueHeaders)(_.multiValueHeaders(_))
        .ifSome(log)(_.log(_))
        .ifSome(latency)(_.latency(_))
        .build

    def throttleSettings(
      burstLimit: Option[Int] = None,
      rateLimit: Option[Double] = None
    ): ThrottleSettings =
      ThrottleSettings
        .builder
        .ifSome(burstLimit)(_.burstLimit(_))
        .ifSome(rateLimit)(_.rateLimit(_))
        .build

    def tlsConfig(
      insecureSkipVerification: Option[Boolean] = None
    ): TlsConfig =
      TlsConfig
        .builder
        .ifSome(insecureSkipVerification)(_.insecureSkipVerification(_))
        .build

    def tooManyRequestsException(
      retryAfterSeconds: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAccountRequest(
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateAccountRequest =
      UpdateAccountRequest
        .builder
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateApiKeyRequest(
      apiKey: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateApiKeyRequest =
      UpdateApiKeyRequest
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateAuthorizerRequest(
      restApiId: Option[String] = None,
      authorizerId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateAuthorizerRequest =
      UpdateAuthorizerRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(authorizerId)(_.authorizerId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateBasePathMappingRequest(
      domainName: Option[String] = None,
      basePath: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateBasePathMappingRequest =
      UpdateBasePathMappingRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(basePath)(_.basePath(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateClientCertificateRequest(
      clientCertificateId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateClientCertificateRequest =
      UpdateClientCertificateRequest
        .builder
        .ifSome(clientCertificateId)(_.clientCertificateId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateDeploymentRequest(
      restApiId: Option[String] = None,
      deploymentId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateDeploymentRequest =
      UpdateDeploymentRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateDocumentationPartRequest(
      restApiId: Option[String] = None,
      documentationPartId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateDocumentationPartRequest =
      UpdateDocumentationPartRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(documentationPartId)(_.documentationPartId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateDocumentationVersionRequest(
      restApiId: Option[String] = None,
      documentationVersion: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateDocumentationVersionRequest =
      UpdateDocumentationVersionRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(documentationVersion)(_.documentationVersion(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateDomainNameRequest(
      domainName: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateDomainNameRequest =
      UpdateDomainNameRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateGatewayResponseRequest(
      restApiId: Option[String] = None,
      responseType: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateGatewayResponseRequest =
      UpdateGatewayResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(responseType)(_.responseType(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateIntegrationRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateIntegrationRequest =
      UpdateIntegrationRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateIntegrationResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateIntegrationResponseRequest =
      UpdateIntegrationResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateMethodRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateMethodRequest =
      UpdateMethodRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateMethodResponseRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      httpMethod: Option[String] = None,
      statusCode: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateMethodResponseRequest =
      UpdateMethodResponseRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateModelRequest(
      restApiId: Option[String] = None,
      modelName: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateModelRequest =
      UpdateModelRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(modelName)(_.modelName(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateRequestValidatorRequest(
      restApiId: Option[String] = None,
      requestValidatorId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateRequestValidatorRequest =
      UpdateRequestValidatorRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(requestValidatorId)(_.requestValidatorId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateResourceRequest(
      restApiId: Option[String] = None,
      resourceId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateResourceRequest =
      UpdateResourceRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateRestApiRequest(
      restApiId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateRestApiRequest =
      UpdateRestApiRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateStageRequest(
      restApiId: Option[String] = None,
      stageName: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateStageRequest =
      UpdateStageRequest
        .builder
        .ifSome(restApiId)(_.restApiId(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateUsagePlanRequest(
      usagePlanId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateUsagePlanRequest =
      UpdateUsagePlanRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateUsageRequest(
      usagePlanId: Option[String] = None,
      keyId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateUsageRequest =
      UpdateUsageRequest
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def updateVpcLinkRequest(
      vpcLinkId: Option[String] = None,
      patchOperations: Option[List[PatchOperation]] = None
    ): UpdateVpcLinkRequest =
      UpdateVpcLinkRequest
        .builder
        .ifSome(vpcLinkId)(_.vpcLinkId(_))
        .ifSome(patchOperations)(_.patchOperations(_))
        .build

    def usage(
      usagePlanId: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      position: Option[String] = None,
      items: Option[MapOfKeyUsages] = None
    ): Usage =
      Usage
        .builder
        .ifSome(usagePlanId)(_.usagePlanId(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def usagePlan(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      apiStages: Option[List[ApiStage]] = None,
      throttle: Option[ThrottleSettings] = None,
      quota: Option[QuotaSettings] = None,
      productCode: Option[String] = None,
      tags: Option[MapOfStringToString] = None
    ): UsagePlan =
      UsagePlan
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(apiStages)(_.apiStages(_))
        .ifSome(throttle)(_.throttle(_))
        .ifSome(quota)(_.quota(_))
        .ifSome(productCode)(_.productCode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def usagePlanKey(
      id: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None,
      name: Option[String] = None
    ): UsagePlanKey =
      UsagePlanKey
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .ifSome(name)(_.name(_))
        .build

    def usagePlanKeys(
      position: Option[String] = None,
      items: Option[List[UsagePlanKey]] = None
    ): UsagePlanKeys =
      UsagePlanKeys
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def usagePlans(
      position: Option[String] = None,
      items: Option[List[UsagePlan]] = None
    ): UsagePlans =
      UsagePlans
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

    def vpcLink(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      targetArns: Option[List[String]] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      tags: Option[MapOfStringToString] = None
    ): VpcLink =
      VpcLink
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(targetArns)(_.targetArns(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(tags)(_.tags(_))
        .build

    def vpcLinks(
      position: Option[String] = None,
      items: Option[List[VpcLink]] = None
    ): VpcLinks =
      VpcLinks
        .builder
        .ifSome(position)(_.position(_))
        .ifSome(items)(_.items(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
