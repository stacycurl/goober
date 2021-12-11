package goober.hi

import goober.free.appsync.AppSyncIO
import software.amazon.awssdk.services.appsync.model._


object appsync {
  import goober.free.{appsync ⇒ free}

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

    def additionalAuthenticationProvider(
      authenticationType: Option[String] = None,
      openIDConnectConfig: Option[OpenIDConnectConfig] = None,
      userPoolConfig: Option[CognitoUserPoolConfig] = None
    ): AdditionalAuthenticationProvider =
      AdditionalAuthenticationProvider
        .builder
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(openIDConnectConfig)(_.openIDConnectConfig(_))
        .ifSome(userPoolConfig)(_.userPoolConfig(_))
        .build

    def apiCache(
      ttl: Option[Long] = None,
      apiCachingBehavior: Option[String] = None,
      transitEncryptionEnabled: Option[Boolean] = None,
      atRestEncryptionEnabled: Option[Boolean] = None,
      `type`: Option[String] = None,
      status: Option[String] = None
    ): ApiCache =
      ApiCache
        .builder
        .ifSome(ttl)(_.ttl(_))
        .ifSome(apiCachingBehavior)(_.apiCachingBehavior(_))
        .ifSome(transitEncryptionEnabled)(_.transitEncryptionEnabled(_))
        .ifSome(atRestEncryptionEnabled)(_.atRestEncryptionEnabled(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .build

    def apiKey(
      id: Option[String] = None,
      description: Option[String] = None,
      expires: Option[Long] = None,
      deletes: Option[Long] = None
    ): ApiKey =
      ApiKey
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(deletes)(_.deletes(_))
        .build

    def apiKeyLimitExceededException(
      message: Option[String] = None
    ): ApiKeyLimitExceededException =
      ApiKeyLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def apiKeyValidityOutOfBoundsException(
      message: Option[String] = None
    ): ApiKeyValidityOutOfBoundsException =
      ApiKeyValidityOutOfBoundsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def apiLimitExceededException(
      message: Option[String] = None
    ): ApiLimitExceededException =
      ApiLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def authorizationConfig(
      authorizationType: Option[String] = None,
      awsIamConfig: Option[AwsIamConfig] = None
    ): AuthorizationConfig =
      AuthorizationConfig
        .builder
        .ifSome(authorizationType)(_.authorizationType(_))
        .ifSome(awsIamConfig)(_.awsIamConfig(_))
        .build

    def awsIamConfig(
      signingRegion: Option[String] = None,
      signingServiceName: Option[String] = None
    ): AwsIamConfig =
      AwsIamConfig
        .builder
        .ifSome(signingRegion)(_.signingRegion(_))
        .ifSome(signingServiceName)(_.signingServiceName(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cachingConfig(
      ttl: Option[Long] = None,
      cachingKeys: Option[List[String]] = None
    ): CachingConfig =
      CachingConfig
        .builder
        .ifSome(ttl)(_.ttl(_))
        .ifSome(cachingKeys)(_.cachingKeys(_))
        .build

    def cognitoUserPoolConfig(
      userPoolId: Option[String] = None,
      awsRegion: Option[String] = None,
      appIdClientRegex: Option[String] = None
    ): CognitoUserPoolConfig =
      CognitoUserPoolConfig
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(appIdClientRegex)(_.appIdClientRegex(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createApiCacheRequest(
      apiId: Option[String] = None,
      ttl: Option[Long] = None,
      transitEncryptionEnabled: Option[Boolean] = None,
      atRestEncryptionEnabled: Option[Boolean] = None,
      apiCachingBehavior: Option[String] = None,
      `type`: Option[String] = None
    ): CreateApiCacheRequest =
      CreateApiCacheRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(ttl)(_.ttl(_))
        .ifSome(transitEncryptionEnabled)(_.transitEncryptionEnabled(_))
        .ifSome(atRestEncryptionEnabled)(_.atRestEncryptionEnabled(_))
        .ifSome(apiCachingBehavior)(_.apiCachingBehavior(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createApiCacheResponse(
      apiCache: Option[ApiCache] = None
    ): CreateApiCacheResponse =
      CreateApiCacheResponse
        .builder
        .ifSome(apiCache)(_.apiCache(_))
        .build

    def createApiKeyRequest(
      apiId: Option[String] = None,
      description: Option[String] = None,
      expires: Option[Long] = None
    ): CreateApiKeyRequest =
      CreateApiKeyRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(description)(_.description(_))
        .ifSome(expires)(_.expires(_))
        .build

    def createApiKeyResponse(
      apiKey: Option[ApiKey] = None
    ): CreateApiKeyResponse =
      CreateApiKeyResponse
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .build

    def createDataSourceRequest(
      apiId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      serviceRoleArn: Option[String] = None,
      dynamodbConfig: Option[DynamodbDataSourceConfig] = None,
      lambdaConfig: Option[LambdaDataSourceConfig] = None,
      elasticsearchConfig: Option[ElasticsearchDataSourceConfig] = None,
      httpConfig: Option[HttpDataSourceConfig] = None,
      relationalDatabaseConfig: Option[RelationalDatabaseDataSourceConfig] = None
    ): CreateDataSourceRequest =
      CreateDataSourceRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(dynamodbConfig)(_.dynamodbConfig(_))
        .ifSome(lambdaConfig)(_.lambdaConfig(_))
        .ifSome(elasticsearchConfig)(_.elasticsearchConfig(_))
        .ifSome(httpConfig)(_.httpConfig(_))
        .ifSome(relationalDatabaseConfig)(_.relationalDatabaseConfig(_))
        .build

    def createDataSourceResponse(
      dataSource: Option[DataSource] = None
    ): CreateDataSourceResponse =
      CreateDataSourceResponse
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .build

    def createFunctionRequest(
      apiId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      dataSourceName: Option[String] = None,
      requestMappingTemplate: Option[String] = None,
      responseMappingTemplate: Option[String] = None,
      functionVersion: Option[String] = None,
      syncConfig: Option[SyncConfig] = None
    ): CreateFunctionRequest =
      CreateFunctionRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(requestMappingTemplate)(_.requestMappingTemplate(_))
        .ifSome(responseMappingTemplate)(_.responseMappingTemplate(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(syncConfig)(_.syncConfig(_))
        .build

    def createFunctionResponse(
      functionConfiguration: Option[FunctionConfiguration] = None
    ): CreateFunctionResponse =
      CreateFunctionResponse
        .builder
        .ifSome(functionConfiguration)(_.functionConfiguration(_))
        .build

    def createGraphqlApiRequest(
      name: Option[String] = None,
      logConfig: Option[LogConfig] = None,
      authenticationType: Option[String] = None,
      userPoolConfig: Option[UserPoolConfig] = None,
      openIDConnectConfig: Option[OpenIDConnectConfig] = None,
      tags: Option[TagMap] = None,
      additionalAuthenticationProviders: Option[List[AdditionalAuthenticationProvider]] = None,
      xrayEnabled: Option[Boolean] = None
    ): CreateGraphqlApiRequest =
      CreateGraphqlApiRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(logConfig)(_.logConfig(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(userPoolConfig)(_.userPoolConfig(_))
        .ifSome(openIDConnectConfig)(_.openIDConnectConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(additionalAuthenticationProviders)(_.additionalAuthenticationProviders(_))
        .ifSome(xrayEnabled)(_.xrayEnabled(_))
        .build

    def createGraphqlApiResponse(
      graphqlApi: Option[GraphqlApi] = None
    ): CreateGraphqlApiResponse =
      CreateGraphqlApiResponse
        .builder
        .ifSome(graphqlApi)(_.graphqlApi(_))
        .build

    def createResolverRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None,
      fieldName: Option[String] = None,
      dataSourceName: Option[String] = None,
      requestMappingTemplate: Option[String] = None,
      responseMappingTemplate: Option[String] = None,
      kind: Option[String] = None,
      pipelineConfig: Option[PipelineConfig] = None,
      syncConfig: Option[SyncConfig] = None,
      cachingConfig: Option[CachingConfig] = None
    ): CreateResolverRequest =
      CreateResolverRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(fieldName)(_.fieldName(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(requestMappingTemplate)(_.requestMappingTemplate(_))
        .ifSome(responseMappingTemplate)(_.responseMappingTemplate(_))
        .ifSome(kind)(_.kind(_))
        .ifSome(pipelineConfig)(_.pipelineConfig(_))
        .ifSome(syncConfig)(_.syncConfig(_))
        .ifSome(cachingConfig)(_.cachingConfig(_))
        .build

    def createResolverResponse(
      resolver: Option[Resolver] = None
    ): CreateResolverResponse =
      CreateResolverResponse
        .builder
        .ifSome(resolver)(_.resolver(_))
        .build

    def createTypeRequest(
      apiId: Option[String] = None,
      definition: Option[String] = None,
      format: Option[String] = None
    ): CreateTypeRequest =
      CreateTypeRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(format)(_.format(_))
        .build

    def createTypeResponse(
      `type`: Option[Type] = None
    ): CreateTypeResponse =
      CreateTypeResponse
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def dataSource(
      dataSourceArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      serviceRoleArn: Option[String] = None,
      dynamodbConfig: Option[DynamodbDataSourceConfig] = None,
      lambdaConfig: Option[LambdaDataSourceConfig] = None,
      elasticsearchConfig: Option[ElasticsearchDataSourceConfig] = None,
      httpConfig: Option[HttpDataSourceConfig] = None,
      relationalDatabaseConfig: Option[RelationalDatabaseDataSourceConfig] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(dataSourceArn)(_.dataSourceArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(dynamodbConfig)(_.dynamodbConfig(_))
        .ifSome(lambdaConfig)(_.lambdaConfig(_))
        .ifSome(elasticsearchConfig)(_.elasticsearchConfig(_))
        .ifSome(httpConfig)(_.httpConfig(_))
        .ifSome(relationalDatabaseConfig)(_.relationalDatabaseConfig(_))
        .build

    def deleteApiCacheRequest(
      apiId: Option[String] = None
    ): DeleteApiCacheRequest =
      DeleteApiCacheRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def deleteApiCacheResponse(

    ): DeleteApiCacheResponse =
      DeleteApiCacheResponse
        .builder

        .build

    def deleteApiKeyRequest(
      apiId: Option[String] = None,
      id: Option[String] = None
    ): DeleteApiKeyRequest =
      DeleteApiKeyRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(id)(_.id(_))
        .build

    def deleteApiKeyResponse(

    ): DeleteApiKeyResponse =
      DeleteApiKeyResponse
        .builder

        .build

    def deleteDataSourceRequest(
      apiId: Option[String] = None,
      name: Option[String] = None
    ): DeleteDataSourceRequest =
      DeleteDataSourceRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteDataSourceResponse(

    ): DeleteDataSourceResponse =
      DeleteDataSourceResponse
        .builder

        .build

    def deleteFunctionRequest(
      apiId: Option[String] = None,
      functionId: Option[String] = None
    ): DeleteFunctionRequest =
      DeleteFunctionRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(functionId)(_.functionId(_))
        .build

    def deleteFunctionResponse(

    ): DeleteFunctionResponse =
      DeleteFunctionResponse
        .builder

        .build

    def deleteGraphqlApiRequest(
      apiId: Option[String] = None
    ): DeleteGraphqlApiRequest =
      DeleteGraphqlApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def deleteGraphqlApiResponse(

    ): DeleteGraphqlApiResponse =
      DeleteGraphqlApiResponse
        .builder

        .build

    def deleteResolverRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None,
      fieldName: Option[String] = None
    ): DeleteResolverRequest =
      DeleteResolverRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(fieldName)(_.fieldName(_))
        .build

    def deleteResolverResponse(

    ): DeleteResolverResponse =
      DeleteResolverResponse
        .builder

        .build

    def deleteTypeRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None
    ): DeleteTypeRequest =
      DeleteTypeRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .build

    def deleteTypeResponse(

    ): DeleteTypeResponse =
      DeleteTypeResponse
        .builder

        .build

    def deltaSyncConfig(
      baseTableTTL: Option[Long] = None,
      deltaSyncTableName: Option[String] = None,
      deltaSyncTableTTL: Option[Long] = None
    ): DeltaSyncConfig =
      DeltaSyncConfig
        .builder
        .ifSome(baseTableTTL)(_.baseTableTTL(_))
        .ifSome(deltaSyncTableName)(_.deltaSyncTableName(_))
        .ifSome(deltaSyncTableTTL)(_.deltaSyncTableTTL(_))
        .build

    def dynamodbDataSourceConfig(
      tableName: Option[String] = None,
      awsRegion: Option[String] = None,
      useCallerCredentials: Option[Boolean] = None,
      deltaSyncConfig: Option[DeltaSyncConfig] = None,
      versioned: Option[Boolean] = None
    ): DynamodbDataSourceConfig =
      DynamodbDataSourceConfig
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(useCallerCredentials)(_.useCallerCredentials(_))
        .ifSome(deltaSyncConfig)(_.deltaSyncConfig(_))
        .ifSome(versioned)(_.versioned(_))
        .build

    def elasticsearchDataSourceConfig(
      endpoint: Option[String] = None,
      awsRegion: Option[String] = None
    ): ElasticsearchDataSourceConfig =
      ElasticsearchDataSourceConfig
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def flushApiCacheRequest(
      apiId: Option[String] = None
    ): FlushApiCacheRequest =
      FlushApiCacheRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def flushApiCacheResponse(

    ): FlushApiCacheResponse =
      FlushApiCacheResponse
        .builder

        .build

    def functionConfiguration(
      functionId: Option[String] = None,
      functionArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      dataSourceName: Option[String] = None,
      requestMappingTemplate: Option[String] = None,
      responseMappingTemplate: Option[String] = None,
      functionVersion: Option[String] = None,
      syncConfig: Option[SyncConfig] = None
    ): FunctionConfiguration =
      FunctionConfiguration
        .builder
        .ifSome(functionId)(_.functionId(_))
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(requestMappingTemplate)(_.requestMappingTemplate(_))
        .ifSome(responseMappingTemplate)(_.responseMappingTemplate(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(syncConfig)(_.syncConfig(_))
        .build

    def getApiCacheRequest(
      apiId: Option[String] = None
    ): GetApiCacheRequest =
      GetApiCacheRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def getApiCacheResponse(
      apiCache: Option[ApiCache] = None
    ): GetApiCacheResponse =
      GetApiCacheResponse
        .builder
        .ifSome(apiCache)(_.apiCache(_))
        .build

    def getDataSourceRequest(
      apiId: Option[String] = None,
      name: Option[String] = None
    ): GetDataSourceRequest =
      GetDataSourceRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(name)(_.name(_))
        .build

    def getDataSourceResponse(
      dataSource: Option[DataSource] = None
    ): GetDataSourceResponse =
      GetDataSourceResponse
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .build

    def getFunctionRequest(
      apiId: Option[String] = None,
      functionId: Option[String] = None
    ): GetFunctionRequest =
      GetFunctionRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(functionId)(_.functionId(_))
        .build

    def getFunctionResponse(
      functionConfiguration: Option[FunctionConfiguration] = None
    ): GetFunctionResponse =
      GetFunctionResponse
        .builder
        .ifSome(functionConfiguration)(_.functionConfiguration(_))
        .build

    def getGraphqlApiRequest(
      apiId: Option[String] = None
    ): GetGraphqlApiRequest =
      GetGraphqlApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def getGraphqlApiResponse(
      graphqlApi: Option[GraphqlApi] = None
    ): GetGraphqlApiResponse =
      GetGraphqlApiResponse
        .builder
        .ifSome(graphqlApi)(_.graphqlApi(_))
        .build

    def getIntrospectionSchemaRequest(
      apiId: Option[String] = None,
      format: Option[String] = None,
      includeDirectives: Option[Boolean] = None
    ): GetIntrospectionSchemaRequest =
      GetIntrospectionSchemaRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(format)(_.format(_))
        .ifSome(includeDirectives)(_.includeDirectives(_))
        .build

    def getIntrospectionSchemaResponse(
      schema: Option[Blob] = None
    ): GetIntrospectionSchemaResponse =
      GetIntrospectionSchemaResponse
        .builder
        .ifSome(schema)(_.schema(_))
        .build

    def getResolverRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None,
      fieldName: Option[String] = None
    ): GetResolverRequest =
      GetResolverRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(fieldName)(_.fieldName(_))
        .build

    def getResolverResponse(
      resolver: Option[Resolver] = None
    ): GetResolverResponse =
      GetResolverResponse
        .builder
        .ifSome(resolver)(_.resolver(_))
        .build

    def getSchemaCreationStatusRequest(
      apiId: Option[String] = None
    ): GetSchemaCreationStatusRequest =
      GetSchemaCreationStatusRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .build

    def getSchemaCreationStatusResponse(
      status: Option[String] = None,
      details: Option[String] = None
    ): GetSchemaCreationStatusResponse =
      GetSchemaCreationStatusResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(details)(_.details(_))
        .build

    def getTypeRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None,
      format: Option[String] = None
    ): GetTypeRequest =
      GetTypeRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(format)(_.format(_))
        .build

    def getTypeResponse(
      `type`: Option[Type] = None
    ): GetTypeResponse =
      GetTypeResponse
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def graphQLSchemaException(
      message: Option[String] = None
    ): GraphQLSchemaException =
      GraphQLSchemaException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def graphqlApi(
      name: Option[String] = None,
      apiId: Option[String] = None,
      authenticationType: Option[String] = None,
      logConfig: Option[LogConfig] = None,
      userPoolConfig: Option[UserPoolConfig] = None,
      openIDConnectConfig: Option[OpenIDConnectConfig] = None,
      arn: Option[String] = None,
      uris: Option[MapOfStringToString] = None,
      tags: Option[TagMap] = None,
      additionalAuthenticationProviders: Option[List[AdditionalAuthenticationProvider]] = None,
      xrayEnabled: Option[Boolean] = None,
      wafWebAclArn: Option[String] = None
    ): GraphqlApi =
      GraphqlApi
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(logConfig)(_.logConfig(_))
        .ifSome(userPoolConfig)(_.userPoolConfig(_))
        .ifSome(openIDConnectConfig)(_.openIDConnectConfig(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(uris)(_.uris(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(additionalAuthenticationProviders)(_.additionalAuthenticationProviders(_))
        .ifSome(xrayEnabled)(_.xrayEnabled(_))
        .ifSome(wafWebAclArn)(_.wafWebAclArn(_))
        .build

    def httpDataSourceConfig(
      endpoint: Option[String] = None,
      authorizationConfig: Option[AuthorizationConfig] = None
    ): HttpDataSourceConfig =
      HttpDataSourceConfig
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(authorizationConfig)(_.authorizationConfig(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lambdaConflictHandlerConfig(
      lambdaConflictHandlerArn: Option[String] = None
    ): LambdaConflictHandlerConfig =
      LambdaConflictHandlerConfig
        .builder
        .ifSome(lambdaConflictHandlerArn)(_.lambdaConflictHandlerArn(_))
        .build

    def lambdaDataSourceConfig(
      lambdaFunctionArn: Option[String] = None
    ): LambdaDataSourceConfig =
      LambdaDataSourceConfig
        .builder
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApiKeysRequest(
      apiId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListApiKeysRequest =
      ListApiKeysRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listApiKeysResponse(
      apiKeys: Option[List[ApiKey]] = None,
      nextToken: Option[String] = None
    ): ListApiKeysResponse =
      ListApiKeysResponse
        .builder
        .ifSome(apiKeys)(_.apiKeys(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDataSourcesRequest(
      apiId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDataSourcesRequest =
      ListDataSourcesRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDataSourcesResponse(
      dataSources: Option[List[DataSource]] = None,
      nextToken: Option[String] = None
    ): ListDataSourcesResponse =
      ListDataSourcesResponse
        .builder
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFunctionsRequest(
      apiId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFunctionsRequest =
      ListFunctionsRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFunctionsResponse(
      functions: Option[List[FunctionConfiguration]] = None,
      nextToken: Option[String] = None
    ): ListFunctionsResponse =
      ListFunctionsResponse
        .builder
        .ifSome(functions)(_.functions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGraphqlApisRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListGraphqlApisRequest =
      ListGraphqlApisRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listGraphqlApisResponse(
      graphqlApis: Option[List[GraphqlApi]] = None,
      nextToken: Option[String] = None
    ): ListGraphqlApisResponse =
      ListGraphqlApisResponse
        .builder
        .ifSome(graphqlApis)(_.graphqlApis(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResolversByFunctionRequest(
      apiId: Option[String] = None,
      functionId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResolversByFunctionRequest =
      ListResolversByFunctionRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(functionId)(_.functionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResolversByFunctionResponse(
      resolvers: Option[List[Resolver]] = None,
      nextToken: Option[String] = None
    ): ListResolversByFunctionResponse =
      ListResolversByFunctionResponse
        .builder
        .ifSome(resolvers)(_.resolvers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResolversRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResolversRequest =
      ListResolversRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResolversResponse(
      resolvers: Option[List[Resolver]] = None,
      nextToken: Option[String] = None
    ): ListResolversResponse =
      ListResolversResponse
        .builder
        .ifSome(resolvers)(_.resolvers(_))
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

    def listTypesRequest(
      apiId: Option[String] = None,
      format: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTypesRequest =
      ListTypesRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(format)(_.format(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTypesResponse(
      types: Option[List[Type]] = None,
      nextToken: Option[String] = None
    ): ListTypesResponse =
      ListTypesResponse
        .builder
        .ifSome(types)(_.types(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def logConfig(
      fieldLogLevel: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      excludeVerboseContent: Option[Boolean] = None
    ): LogConfig =
      LogConfig
        .builder
        .ifSome(fieldLogLevel)(_.fieldLogLevel(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(excludeVerboseContent)(_.excludeVerboseContent(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def openIDConnectConfig(
      issuer: Option[String] = None,
      clientId: Option[String] = None,
      iatTTL: Option[Long] = None,
      authTTL: Option[Long] = None
    ): OpenIDConnectConfig =
      OpenIDConnectConfig
        .builder
        .ifSome(issuer)(_.issuer(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(iatTTL)(_.iatTTL(_))
        .ifSome(authTTL)(_.authTTL(_))
        .build

    def pipelineConfig(
      functions: Option[List[String]] = None
    ): PipelineConfig =
      PipelineConfig
        .builder
        .ifSome(functions)(_.functions(_))
        .build

    def rdsHttpEndpointConfig(
      awsRegion: Option[String] = None,
      dbClusterIdentifier: Option[String] = None,
      databaseName: Option[String] = None,
      schema: Option[String] = None,
      awsSecretStoreArn: Option[String] = None
    ): RdsHttpEndpointConfig =
      RdsHttpEndpointConfig
        .builder
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(dbClusterIdentifier)(_.dbClusterIdentifier(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(awsSecretStoreArn)(_.awsSecretStoreArn(_))
        .build

    def relationalDatabaseDataSourceConfig(
      relationalDatabaseSourceType: Option[String] = None,
      rdsHttpEndpointConfig: Option[RdsHttpEndpointConfig] = None
    ): RelationalDatabaseDataSourceConfig =
      RelationalDatabaseDataSourceConfig
        .builder
        .ifSome(relationalDatabaseSourceType)(_.relationalDatabaseSourceType(_))
        .ifSome(rdsHttpEndpointConfig)(_.rdsHttpEndpointConfig(_))
        .build

    def resolver(
      typeName: Option[String] = None,
      fieldName: Option[String] = None,
      dataSourceName: Option[String] = None,
      resolverArn: Option[String] = None,
      requestMappingTemplate: Option[String] = None,
      responseMappingTemplate: Option[String] = None,
      kind: Option[String] = None,
      pipelineConfig: Option[PipelineConfig] = None,
      syncConfig: Option[SyncConfig] = None,
      cachingConfig: Option[CachingConfig] = None
    ): Resolver =
      Resolver
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(fieldName)(_.fieldName(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(resolverArn)(_.resolverArn(_))
        .ifSome(requestMappingTemplate)(_.requestMappingTemplate(_))
        .ifSome(responseMappingTemplate)(_.responseMappingTemplate(_))
        .ifSome(kind)(_.kind(_))
        .ifSome(pipelineConfig)(_.pipelineConfig(_))
        .ifSome(syncConfig)(_.syncConfig(_))
        .ifSome(cachingConfig)(_.cachingConfig(_))
        .build

    def startSchemaCreationRequest(
      apiId: Option[String] = None,
      definition: Option[Blob] = None
    ): StartSchemaCreationRequest =
      StartSchemaCreationRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(definition)(_.definition(_))
        .build

    def startSchemaCreationResponse(
      status: Option[String] = None
    ): StartSchemaCreationResponse =
      StartSchemaCreationResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def syncConfig(
      conflictHandler: Option[String] = None,
      conflictDetection: Option[String] = None,
      lambdaConflictHandlerConfig: Option[LambdaConflictHandlerConfig] = None
    ): SyncConfig =
      SyncConfig
        .builder
        .ifSome(conflictHandler)(_.conflictHandler(_))
        .ifSome(conflictDetection)(_.conflictDetection(_))
        .ifSome(lambdaConflictHandlerConfig)(_.lambdaConflictHandlerConfig(_))
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

    def type(
      name: Option[String] = None,
      description: Option[String] = None,
      arn: Option[String] = None,
      definition: Option[String] = None,
      format: Option[String] = None
    ): Type =
      Type
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(format)(_.format(_))
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

    def updateApiCacheRequest(
      apiId: Option[String] = None,
      ttl: Option[Long] = None,
      apiCachingBehavior: Option[String] = None,
      `type`: Option[String] = None
    ): UpdateApiCacheRequest =
      UpdateApiCacheRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(ttl)(_.ttl(_))
        .ifSome(apiCachingBehavior)(_.apiCachingBehavior(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def updateApiCacheResponse(
      apiCache: Option[ApiCache] = None
    ): UpdateApiCacheResponse =
      UpdateApiCacheResponse
        .builder
        .ifSome(apiCache)(_.apiCache(_))
        .build

    def updateApiKeyRequest(
      apiId: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      expires: Option[Long] = None
    ): UpdateApiKeyRequest =
      UpdateApiKeyRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(expires)(_.expires(_))
        .build

    def updateApiKeyResponse(
      apiKey: Option[ApiKey] = None
    ): UpdateApiKeyResponse =
      UpdateApiKeyResponse
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .build

    def updateDataSourceRequest(
      apiId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      serviceRoleArn: Option[String] = None,
      dynamodbConfig: Option[DynamodbDataSourceConfig] = None,
      lambdaConfig: Option[LambdaDataSourceConfig] = None,
      elasticsearchConfig: Option[ElasticsearchDataSourceConfig] = None,
      httpConfig: Option[HttpDataSourceConfig] = None,
      relationalDatabaseConfig: Option[RelationalDatabaseDataSourceConfig] = None
    ): UpdateDataSourceRequest =
      UpdateDataSourceRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(dynamodbConfig)(_.dynamodbConfig(_))
        .ifSome(lambdaConfig)(_.lambdaConfig(_))
        .ifSome(elasticsearchConfig)(_.elasticsearchConfig(_))
        .ifSome(httpConfig)(_.httpConfig(_))
        .ifSome(relationalDatabaseConfig)(_.relationalDatabaseConfig(_))
        .build

    def updateDataSourceResponse(
      dataSource: Option[DataSource] = None
    ): UpdateDataSourceResponse =
      UpdateDataSourceResponse
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .build

    def updateFunctionRequest(
      apiId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      functionId: Option[String] = None,
      dataSourceName: Option[String] = None,
      requestMappingTemplate: Option[String] = None,
      responseMappingTemplate: Option[String] = None,
      functionVersion: Option[String] = None,
      syncConfig: Option[SyncConfig] = None
    ): UpdateFunctionRequest =
      UpdateFunctionRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(functionId)(_.functionId(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(requestMappingTemplate)(_.requestMappingTemplate(_))
        .ifSome(responseMappingTemplate)(_.responseMappingTemplate(_))
        .ifSome(functionVersion)(_.functionVersion(_))
        .ifSome(syncConfig)(_.syncConfig(_))
        .build

    def updateFunctionResponse(
      functionConfiguration: Option[FunctionConfiguration] = None
    ): UpdateFunctionResponse =
      UpdateFunctionResponse
        .builder
        .ifSome(functionConfiguration)(_.functionConfiguration(_))
        .build

    def updateGraphqlApiRequest(
      apiId: Option[String] = None,
      name: Option[String] = None,
      logConfig: Option[LogConfig] = None,
      authenticationType: Option[String] = None,
      userPoolConfig: Option[UserPoolConfig] = None,
      openIDConnectConfig: Option[OpenIDConnectConfig] = None,
      additionalAuthenticationProviders: Option[List[AdditionalAuthenticationProvider]] = None,
      xrayEnabled: Option[Boolean] = None
    ): UpdateGraphqlApiRequest =
      UpdateGraphqlApiRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(name)(_.name(_))
        .ifSome(logConfig)(_.logConfig(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(userPoolConfig)(_.userPoolConfig(_))
        .ifSome(openIDConnectConfig)(_.openIDConnectConfig(_))
        .ifSome(additionalAuthenticationProviders)(_.additionalAuthenticationProviders(_))
        .ifSome(xrayEnabled)(_.xrayEnabled(_))
        .build

    def updateGraphqlApiResponse(
      graphqlApi: Option[GraphqlApi] = None
    ): UpdateGraphqlApiResponse =
      UpdateGraphqlApiResponse
        .builder
        .ifSome(graphqlApi)(_.graphqlApi(_))
        .build

    def updateResolverRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None,
      fieldName: Option[String] = None,
      dataSourceName: Option[String] = None,
      requestMappingTemplate: Option[String] = None,
      responseMappingTemplate: Option[String] = None,
      kind: Option[String] = None,
      pipelineConfig: Option[PipelineConfig] = None,
      syncConfig: Option[SyncConfig] = None,
      cachingConfig: Option[CachingConfig] = None
    ): UpdateResolverRequest =
      UpdateResolverRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(fieldName)(_.fieldName(_))
        .ifSome(dataSourceName)(_.dataSourceName(_))
        .ifSome(requestMappingTemplate)(_.requestMappingTemplate(_))
        .ifSome(responseMappingTemplate)(_.responseMappingTemplate(_))
        .ifSome(kind)(_.kind(_))
        .ifSome(pipelineConfig)(_.pipelineConfig(_))
        .ifSome(syncConfig)(_.syncConfig(_))
        .ifSome(cachingConfig)(_.cachingConfig(_))
        .build

    def updateResolverResponse(
      resolver: Option[Resolver] = None
    ): UpdateResolverResponse =
      UpdateResolverResponse
        .builder
        .ifSome(resolver)(_.resolver(_))
        .build

    def updateTypeRequest(
      apiId: Option[String] = None,
      typeName: Option[String] = None,
      definition: Option[String] = None,
      format: Option[String] = None
    ): UpdateTypeRequest =
      UpdateTypeRequest
        .builder
        .ifSome(apiId)(_.apiId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(format)(_.format(_))
        .build

    def updateTypeResponse(
      `type`: Option[Type] = None
    ): UpdateTypeResponse =
      UpdateTypeResponse
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def userPoolConfig(
      userPoolId: Option[String] = None,
      awsRegion: Option[String] = None,
      defaultAction: Option[String] = None,
      appIdClientRegex: Option[String] = None
    ): UserPoolConfig =
      UserPoolConfig
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .ifSome(appIdClientRegex)(_.appIdClientRegex(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
