package goober.hi

import goober.free.appflow.AppflowIO
import software.amazon.awssdk.services.appflow.model._


object appflow {
  import goober.free.{appflow ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aggregationConfig(
      aggregationType: Option[String] = None
    ): AggregationConfig =
      AggregationConfig
        .builder
        .ifSome(aggregationType)(_.aggregationType(_))
        .build

    def amplitudeConnectorProfileCredentials(
      apiKey: Option[String] = None,
      secretKey: Option[String] = None
    ): AmplitudeConnectorProfileCredentials =
      AmplitudeConnectorProfileCredentials
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .ifSome(secretKey)(_.secretKey(_))
        .build

    def amplitudeConnectorProfileProperties(

    ): AmplitudeConnectorProfileProperties =
      AmplitudeConnectorProfileProperties
        .builder

        .build

    def amplitudeMetadata(

    ): AmplitudeMetadata =
      AmplitudeMetadata
        .builder

        .build

    def amplitudeSourceProperties(
      object: Option[String] = None
    ): AmplitudeSourceProperties =
      AmplitudeSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def connectorAuthenticationException(
      message: Option[String] = None
    ): ConnectorAuthenticationException =
      ConnectorAuthenticationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def connectorConfiguration(
      canUseAsSource: Option[Boolean] = None,
      canUseAsDestination: Option[Boolean] = None,
      supportedDestinationConnectors: Option[List[ConnectorType]] = None,
      supportedSchedulingFrequencies: Option[List[ScheduleFrequencyType]] = None,
      isPrivateLinkEnabled: Option[Boolean] = None,
      isPrivateLinkEndpointUrlRequired: Option[Boolean] = None,
      supportedTriggerTypes: Option[List[TriggerType]] = None,
      connectorMetadata: Option[ConnectorMetadata] = None
    ): ConnectorConfiguration =
      ConnectorConfiguration
        .builder
        .ifSome(canUseAsSource)(_.canUseAsSource(_))
        .ifSome(canUseAsDestination)(_.canUseAsDestination(_))
        .ifSome(supportedDestinationConnectors)(_.supportedDestinationConnectors(_))
        .ifSome(supportedSchedulingFrequencies)(_.supportedSchedulingFrequencies(_))
        .ifSome(isPrivateLinkEnabled)(_.isPrivateLinkEnabled(_))
        .ifSome(isPrivateLinkEndpointUrlRequired)(_.isPrivateLinkEndpointUrlRequired(_))
        .ifSome(supportedTriggerTypes)(_.supportedTriggerTypes(_))
        .ifSome(connectorMetadata)(_.connectorMetadata(_))
        .build

    def connectorEntity(
      name: Option[String] = None,
      label: Option[String] = None,
      hasNestedEntities: Option[Boolean] = None
    ): ConnectorEntity =
      ConnectorEntity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(label)(_.label(_))
        .ifSome(hasNestedEntities)(_.hasNestedEntities(_))
        .build

    def connectorEntityField(
      identifier: Option[String] = None,
      label: Option[String] = None,
      supportedFieldTypeDetails: Option[SupportedFieldTypeDetails] = None,
      description: Option[String] = None,
      sourceProperties: Option[SourceFieldProperties] = None,
      destinationProperties: Option[DestinationFieldProperties] = None
    ): ConnectorEntityField =
      ConnectorEntityField
        .builder
        .ifSome(identifier)(_.identifier(_))
        .ifSome(label)(_.label(_))
        .ifSome(supportedFieldTypeDetails)(_.supportedFieldTypeDetails(_))
        .ifSome(description)(_.description(_))
        .ifSome(sourceProperties)(_.sourceProperties(_))
        .ifSome(destinationProperties)(_.destinationProperties(_))
        .build

    def connectorMetadata(
      amplitude: Option[AmplitudeMetadata] = None,
      datadog: Option[DatadogMetadata] = None,
      dynatrace: Option[DynatraceMetadata] = None,
      googleAnalytics: Option[GoogleAnalyticsMetadata] = None,
      inforNexus: Option[InforNexusMetadata] = None,
      marketo: Option[MarketoMetadata] = None,
      redshift: Option[RedshiftMetadata] = None,
      s3: Option[S3Metadata] = None,
      salesforce: Option[SalesforceMetadata] = None,
      serviceNow: Option[ServiceNowMetadata] = None,
      singular: Option[SingularMetadata] = None,
      slack: Option[SlackMetadata] = None,
      snowflake: Option[SnowflakeMetadata] = None,
      trendmicro: Option[TrendmicroMetadata] = None,
      veeva: Option[VeevaMetadata] = None,
      zendesk: Option[ZendeskMetadata] = None,
      eventBridge: Option[EventBridgeMetadata] = None,
      upsolver: Option[UpsolverMetadata] = None,
      customerProfiles: Option[CustomerProfilesMetadata] = None,
      honeycode: Option[HoneycodeMetadata] = None
    ): ConnectorMetadata =
      ConnectorMetadata
        .builder
        .ifSome(amplitude)(_.amplitude(_))
        .ifSome(datadog)(_.datadog(_))
        .ifSome(dynatrace)(_.dynatrace(_))
        .ifSome(googleAnalytics)(_.googleAnalytics(_))
        .ifSome(inforNexus)(_.inforNexus(_))
        .ifSome(marketo)(_.marketo(_))
        .ifSome(redshift)(_.redshift(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(serviceNow)(_.serviceNow(_))
        .ifSome(singular)(_.singular(_))
        .ifSome(slack)(_.slack(_))
        .ifSome(snowflake)(_.snowflake(_))
        .ifSome(trendmicro)(_.trendmicro(_))
        .ifSome(veeva)(_.veeva(_))
        .ifSome(zendesk)(_.zendesk(_))
        .ifSome(eventBridge)(_.eventBridge(_))
        .ifSome(upsolver)(_.upsolver(_))
        .ifSome(customerProfiles)(_.customerProfiles(_))
        .ifSome(honeycode)(_.honeycode(_))
        .build

    def connectorOAuthRequest(
      authCode: Option[String] = None,
      redirectUri: Option[String] = None
    ): ConnectorOAuthRequest =
      ConnectorOAuthRequest
        .builder
        .ifSome(authCode)(_.authCode(_))
        .ifSome(redirectUri)(_.redirectUri(_))
        .build

    def connectorOperator(
      amplitude: Option[String] = None,
      datadog: Option[String] = None,
      dynatrace: Option[String] = None,
      googleAnalytics: Option[String] = None,
      inforNexus: Option[String] = None,
      marketo: Option[String] = None,
      s3: Option[String] = None,
      salesforce: Option[String] = None,
      serviceNow: Option[String] = None,
      singular: Option[String] = None,
      slack: Option[String] = None,
      trendmicro: Option[String] = None,
      veeva: Option[String] = None,
      zendesk: Option[String] = None
    ): ConnectorOperator =
      ConnectorOperator
        .builder
        .ifSome(amplitude)(_.amplitude(_))
        .ifSome(datadog)(_.datadog(_))
        .ifSome(dynatrace)(_.dynatrace(_))
        .ifSome(googleAnalytics)(_.googleAnalytics(_))
        .ifSome(inforNexus)(_.inforNexus(_))
        .ifSome(marketo)(_.marketo(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(serviceNow)(_.serviceNow(_))
        .ifSome(singular)(_.singular(_))
        .ifSome(slack)(_.slack(_))
        .ifSome(trendmicro)(_.trendmicro(_))
        .ifSome(veeva)(_.veeva(_))
        .ifSome(zendesk)(_.zendesk(_))
        .build

    def connectorProfile(
      connectorProfileArn: Option[String] = None,
      connectorProfileName: Option[String] = None,
      connectorType: Option[String] = None,
      connectionMode: Option[String] = None,
      credentialsArn: Option[String] = None,
      connectorProfileProperties: Option[ConnectorProfileProperties] = None,
      createdAt: Option[Date] = None,
      lastUpdatedAt: Option[Date] = None
    ): ConnectorProfile =
      ConnectorProfile
        .builder
        .ifSome(connectorProfileArn)(_.connectorProfileArn(_))
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(connectionMode)(_.connectionMode(_))
        .ifSome(credentialsArn)(_.credentialsArn(_))
        .ifSome(connectorProfileProperties)(_.connectorProfileProperties(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def connectorProfileConfig(
      connectorProfileProperties: Option[ConnectorProfileProperties] = None,
      connectorProfileCredentials: Option[ConnectorProfileCredentials] = None
    ): ConnectorProfileConfig =
      ConnectorProfileConfig
        .builder
        .ifSome(connectorProfileProperties)(_.connectorProfileProperties(_))
        .ifSome(connectorProfileCredentials)(_.connectorProfileCredentials(_))
        .build

    def connectorProfileCredentials(
      amplitude: Option[AmplitudeConnectorProfileCredentials] = None,
      datadog: Option[DatadogConnectorProfileCredentials] = None,
      dynatrace: Option[DynatraceConnectorProfileCredentials] = None,
      googleAnalytics: Option[GoogleAnalyticsConnectorProfileCredentials] = None,
      honeycode: Option[HoneycodeConnectorProfileCredentials] = None,
      inforNexus: Option[InforNexusConnectorProfileCredentials] = None,
      marketo: Option[MarketoConnectorProfileCredentials] = None,
      redshift: Option[RedshiftConnectorProfileCredentials] = None,
      salesforce: Option[SalesforceConnectorProfileCredentials] = None,
      serviceNow: Option[ServiceNowConnectorProfileCredentials] = None,
      singular: Option[SingularConnectorProfileCredentials] = None,
      slack: Option[SlackConnectorProfileCredentials] = None,
      snowflake: Option[SnowflakeConnectorProfileCredentials] = None,
      trendmicro: Option[TrendmicroConnectorProfileCredentials] = None,
      veeva: Option[VeevaConnectorProfileCredentials] = None,
      zendesk: Option[ZendeskConnectorProfileCredentials] = None
    ): ConnectorProfileCredentials =
      ConnectorProfileCredentials
        .builder
        .ifSome(amplitude)(_.amplitude(_))
        .ifSome(datadog)(_.datadog(_))
        .ifSome(dynatrace)(_.dynatrace(_))
        .ifSome(googleAnalytics)(_.googleAnalytics(_))
        .ifSome(honeycode)(_.honeycode(_))
        .ifSome(inforNexus)(_.inforNexus(_))
        .ifSome(marketo)(_.marketo(_))
        .ifSome(redshift)(_.redshift(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(serviceNow)(_.serviceNow(_))
        .ifSome(singular)(_.singular(_))
        .ifSome(slack)(_.slack(_))
        .ifSome(snowflake)(_.snowflake(_))
        .ifSome(trendmicro)(_.trendmicro(_))
        .ifSome(veeva)(_.veeva(_))
        .ifSome(zendesk)(_.zendesk(_))
        .build

    def connectorProfileProperties(
      amplitude: Option[AmplitudeConnectorProfileProperties] = None,
      datadog: Option[DatadogConnectorProfileProperties] = None,
      dynatrace: Option[DynatraceConnectorProfileProperties] = None,
      googleAnalytics: Option[GoogleAnalyticsConnectorProfileProperties] = None,
      honeycode: Option[HoneycodeConnectorProfileProperties] = None,
      inforNexus: Option[InforNexusConnectorProfileProperties] = None,
      marketo: Option[MarketoConnectorProfileProperties] = None,
      redshift: Option[RedshiftConnectorProfileProperties] = None,
      salesforce: Option[SalesforceConnectorProfileProperties] = None,
      serviceNow: Option[ServiceNowConnectorProfileProperties] = None,
      singular: Option[SingularConnectorProfileProperties] = None,
      slack: Option[SlackConnectorProfileProperties] = None,
      snowflake: Option[SnowflakeConnectorProfileProperties] = None,
      trendmicro: Option[TrendmicroConnectorProfileProperties] = None,
      veeva: Option[VeevaConnectorProfileProperties] = None,
      zendesk: Option[ZendeskConnectorProfileProperties] = None
    ): ConnectorProfileProperties =
      ConnectorProfileProperties
        .builder
        .ifSome(amplitude)(_.amplitude(_))
        .ifSome(datadog)(_.datadog(_))
        .ifSome(dynatrace)(_.dynatrace(_))
        .ifSome(googleAnalytics)(_.googleAnalytics(_))
        .ifSome(honeycode)(_.honeycode(_))
        .ifSome(inforNexus)(_.inforNexus(_))
        .ifSome(marketo)(_.marketo(_))
        .ifSome(redshift)(_.redshift(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(serviceNow)(_.serviceNow(_))
        .ifSome(singular)(_.singular(_))
        .ifSome(slack)(_.slack(_))
        .ifSome(snowflake)(_.snowflake(_))
        .ifSome(trendmicro)(_.trendmicro(_))
        .ifSome(veeva)(_.veeva(_))
        .ifSome(zendesk)(_.zendesk(_))
        .build

    def connectorServerException(
      message: Option[String] = None
    ): ConnectorServerException =
      ConnectorServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createConnectorProfileRequest(
      connectorProfileName: Option[String] = None,
      kmsArn: Option[String] = None,
      connectorType: Option[String] = None,
      connectionMode: Option[String] = None,
      connectorProfileConfig: Option[ConnectorProfileConfig] = None
    ): CreateConnectorProfileRequest =
      CreateConnectorProfileRequest
        .builder
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(kmsArn)(_.kmsArn(_))
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(connectionMode)(_.connectionMode(_))
        .ifSome(connectorProfileConfig)(_.connectorProfileConfig(_))
        .build

    def createConnectorProfileResponse(
      connectorProfileArn: Option[String] = None
    ): CreateConnectorProfileResponse =
      CreateConnectorProfileResponse
        .builder
        .ifSome(connectorProfileArn)(_.connectorProfileArn(_))
        .build

    def createFlowRequest(
      flowName: Option[String] = None,
      description: Option[String] = None,
      kmsArn: Option[String] = None,
      triggerConfig: Option[TriggerConfig] = None,
      sourceFlowConfig: Option[SourceFlowConfig] = None,
      destinationFlowConfigList: Option[List[DestinationFlowConfig]] = None,
      tasks: Option[List[Task]] = None,
      tags: Option[TagMap] = None
    ): CreateFlowRequest =
      CreateFlowRequest
        .builder
        .ifSome(flowName)(_.flowName(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsArn)(_.kmsArn(_))
        .ifSome(triggerConfig)(_.triggerConfig(_))
        .ifSome(sourceFlowConfig)(_.sourceFlowConfig(_))
        .ifSome(destinationFlowConfigList)(_.destinationFlowConfigList(_))
        .ifSome(tasks)(_.tasks(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFlowResponse(
      flowArn: Option[String] = None,
      flowStatus: Option[String] = None
    ): CreateFlowResponse =
      CreateFlowResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(flowStatus)(_.flowStatus(_))
        .build

    def customerProfilesDestinationProperties(
      domainName: Option[String] = None,
      objectTypeName: Option[String] = None
    ): CustomerProfilesDestinationProperties =
      CustomerProfilesDestinationProperties
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .build

    def customerProfilesMetadata(

    ): CustomerProfilesMetadata =
      CustomerProfilesMetadata
        .builder

        .build

    def datadogConnectorProfileCredentials(
      apiKey: Option[String] = None,
      applicationKey: Option[String] = None
    ): DatadogConnectorProfileCredentials =
      DatadogConnectorProfileCredentials
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .ifSome(applicationKey)(_.applicationKey(_))
        .build

    def datadogConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): DatadogConnectorProfileProperties =
      DatadogConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def datadogMetadata(

    ): DatadogMetadata =
      DatadogMetadata
        .builder

        .build

    def datadogSourceProperties(
      object: Option[String] = None
    ): DatadogSourceProperties =
      DatadogSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def deleteConnectorProfileRequest(
      connectorProfileName: Option[String] = None,
      forceDelete: Option[Boolean] = None
    ): DeleteConnectorProfileRequest =
      DeleteConnectorProfileRequest
        .builder
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(forceDelete)(_.forceDelete(_))
        .build

    def deleteConnectorProfileResponse(

    ): DeleteConnectorProfileResponse =
      DeleteConnectorProfileResponse
        .builder

        .build

    def deleteFlowRequest(
      flowName: Option[String] = None,
      forceDelete: Option[Boolean] = None
    ): DeleteFlowRequest =
      DeleteFlowRequest
        .builder
        .ifSome(flowName)(_.flowName(_))
        .ifSome(forceDelete)(_.forceDelete(_))
        .build

    def deleteFlowResponse(

    ): DeleteFlowResponse =
      DeleteFlowResponse
        .builder

        .build

    def describeConnectorEntityRequest(
      connectorEntityName: Option[String] = None,
      connectorType: Option[String] = None,
      connectorProfileName: Option[String] = None
    ): DescribeConnectorEntityRequest =
      DescribeConnectorEntityRequest
        .builder
        .ifSome(connectorEntityName)(_.connectorEntityName(_))
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .build

    def describeConnectorEntityResponse(
      connectorEntityFields: Option[List[ConnectorEntityField]] = None
    ): DescribeConnectorEntityResponse =
      DescribeConnectorEntityResponse
        .builder
        .ifSome(connectorEntityFields)(_.connectorEntityFields(_))
        .build

    def describeConnectorProfilesRequest(
      connectorProfileNames: Option[List[ConnectorProfileName]] = None,
      connectorType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeConnectorProfilesRequest =
      DescribeConnectorProfilesRequest
        .builder
        .ifSome(connectorProfileNames)(_.connectorProfileNames(_))
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConnectorProfilesResponse(
      connectorProfileDetails: Option[List[ConnectorProfile]] = None,
      nextToken: Option[String] = None
    ): DescribeConnectorProfilesResponse =
      DescribeConnectorProfilesResponse
        .builder
        .ifSome(connectorProfileDetails)(_.connectorProfileDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConnectorsRequest(
      connectorTypes: Option[List[ConnectorType]] = None,
      nextToken: Option[String] = None
    ): DescribeConnectorsRequest =
      DescribeConnectorsRequest
        .builder
        .ifSome(connectorTypes)(_.connectorTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConnectorsResponse(
      connectorConfigurations: Option[ConnectorConfigurationsMap] = None,
      nextToken: Option[String] = None
    ): DescribeConnectorsResponse =
      DescribeConnectorsResponse
        .builder
        .ifSome(connectorConfigurations)(_.connectorConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFlowExecutionRecordsRequest(
      flowName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFlowExecutionRecordsRequest =
      DescribeFlowExecutionRecordsRequest
        .builder
        .ifSome(flowName)(_.flowName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFlowExecutionRecordsResponse(
      flowExecutions: Option[List[ExecutionRecord]] = None,
      nextToken: Option[String] = None
    ): DescribeFlowExecutionRecordsResponse =
      DescribeFlowExecutionRecordsResponse
        .builder
        .ifSome(flowExecutions)(_.flowExecutions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFlowRequest(
      flowName: Option[String] = None
    ): DescribeFlowRequest =
      DescribeFlowRequest
        .builder
        .ifSome(flowName)(_.flowName(_))
        .build

    def describeFlowResponse(
      flowArn: Option[String] = None,
      description: Option[String] = None,
      flowName: Option[String] = None,
      kmsArn: Option[String] = None,
      flowStatus: Option[String] = None,
      flowStatusMessage: Option[String] = None,
      sourceFlowConfig: Option[SourceFlowConfig] = None,
      destinationFlowConfigList: Option[List[DestinationFlowConfig]] = None,
      lastRunExecutionDetails: Option[ExecutionDetails] = None,
      triggerConfig: Option[TriggerConfig] = None,
      tasks: Option[List[Task]] = None,
      createdAt: Option[Date] = None,
      lastUpdatedAt: Option[Date] = None,
      createdBy: Option[String] = None,
      lastUpdatedBy: Option[String] = None,
      tags: Option[TagMap] = None
    ): DescribeFlowResponse =
      DescribeFlowResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(flowName)(_.flowName(_))
        .ifSome(kmsArn)(_.kmsArn(_))
        .ifSome(flowStatus)(_.flowStatus(_))
        .ifSome(flowStatusMessage)(_.flowStatusMessage(_))
        .ifSome(sourceFlowConfig)(_.sourceFlowConfig(_))
        .ifSome(destinationFlowConfigList)(_.destinationFlowConfigList(_))
        .ifSome(lastRunExecutionDetails)(_.lastRunExecutionDetails(_))
        .ifSome(triggerConfig)(_.triggerConfig(_))
        .ifSome(tasks)(_.tasks(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastUpdatedBy)(_.lastUpdatedBy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def destinationConnectorProperties(
      redshift: Option[RedshiftDestinationProperties] = None,
      s3: Option[S3DestinationProperties] = None,
      salesforce: Option[SalesforceDestinationProperties] = None,
      snowflake: Option[SnowflakeDestinationProperties] = None,
      eventBridge: Option[EventBridgeDestinationProperties] = None,
      lookoutMetrics: Option[LookoutMetricsDestinationProperties] = None,
      upsolver: Option[UpsolverDestinationProperties] = None,
      honeycode: Option[HoneycodeDestinationProperties] = None,
      customerProfiles: Option[CustomerProfilesDestinationProperties] = None,
      zendesk: Option[ZendeskDestinationProperties] = None
    ): DestinationConnectorProperties =
      DestinationConnectorProperties
        .builder
        .ifSome(redshift)(_.redshift(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(snowflake)(_.snowflake(_))
        .ifSome(eventBridge)(_.eventBridge(_))
        .ifSome(lookoutMetrics)(_.lookoutMetrics(_))
        .ifSome(upsolver)(_.upsolver(_))
        .ifSome(honeycode)(_.honeycode(_))
        .ifSome(customerProfiles)(_.customerProfiles(_))
        .ifSome(zendesk)(_.zendesk(_))
        .build

    def destinationFieldProperties(
      isCreatable: Option[Boolean] = None,
      isNullable: Option[Boolean] = None,
      isUpsertable: Option[Boolean] = None,
      isUpdatable: Option[Boolean] = None,
      supportedWriteOperations: Option[List[WriteOperationType]] = None
    ): DestinationFieldProperties =
      DestinationFieldProperties
        .builder
        .ifSome(isCreatable)(_.isCreatable(_))
        .ifSome(isNullable)(_.isNullable(_))
        .ifSome(isUpsertable)(_.isUpsertable(_))
        .ifSome(isUpdatable)(_.isUpdatable(_))
        .ifSome(supportedWriteOperations)(_.supportedWriteOperations(_))
        .build

    def destinationFlowConfig(
      connectorType: Option[String] = None,
      connectorProfileName: Option[String] = None,
      destinationConnectorProperties: Option[DestinationConnectorProperties] = None
    ): DestinationFlowConfig =
      DestinationFlowConfig
        .builder
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(destinationConnectorProperties)(_.destinationConnectorProperties(_))
        .build

    def dynatraceConnectorProfileCredentials(
      apiToken: Option[String] = None
    ): DynatraceConnectorProfileCredentials =
      DynatraceConnectorProfileCredentials
        .builder
        .ifSome(apiToken)(_.apiToken(_))
        .build

    def dynatraceConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): DynatraceConnectorProfileProperties =
      DynatraceConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def dynatraceMetadata(

    ): DynatraceMetadata =
      DynatraceMetadata
        .builder

        .build

    def dynatraceSourceProperties(
      object: Option[String] = None
    ): DynatraceSourceProperties =
      DynatraceSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def errorHandlingConfig(
      failOnFirstDestinationError: Option[Boolean] = None,
      bucketPrefix: Option[String] = None,
      bucketName: Option[String] = None
    ): ErrorHandlingConfig =
      ErrorHandlingConfig
        .builder
        .ifSome(failOnFirstDestinationError)(_.failOnFirstDestinationError(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(bucketName)(_.bucketName(_))
        .build

    def errorInfo(
      putFailuresCount: Option[Long] = None,
      executionMessage: Option[String] = None
    ): ErrorInfo =
      ErrorInfo
        .builder
        .ifSome(putFailuresCount)(_.putFailuresCount(_))
        .ifSome(executionMessage)(_.executionMessage(_))
        .build

    def eventBridgeDestinationProperties(
      object: Option[String] = None,
      errorHandlingConfig: Option[ErrorHandlingConfig] = None
    ): EventBridgeDestinationProperties =
      EventBridgeDestinationProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(errorHandlingConfig)(_.errorHandlingConfig(_))
        .build

    def eventBridgeMetadata(

    ): EventBridgeMetadata =
      EventBridgeMetadata
        .builder

        .build

    def executionDetails(
      mostRecentExecutionMessage: Option[String] = None,
      mostRecentExecutionTime: Option[Date] = None,
      mostRecentExecutionStatus: Option[String] = None
    ): ExecutionDetails =
      ExecutionDetails
        .builder
        .ifSome(mostRecentExecutionMessage)(_.mostRecentExecutionMessage(_))
        .ifSome(mostRecentExecutionTime)(_.mostRecentExecutionTime(_))
        .ifSome(mostRecentExecutionStatus)(_.mostRecentExecutionStatus(_))
        .build

    def executionRecord(
      executionId: Option[String] = None,
      executionStatus: Option[String] = None,
      executionResult: Option[ExecutionResult] = None,
      startedAt: Option[Date] = None,
      lastUpdatedAt: Option[Date] = None,
      dataPullStartTime: Option[Date] = None,
      dataPullEndTime: Option[Date] = None
    ): ExecutionRecord =
      ExecutionRecord
        .builder
        .ifSome(executionId)(_.executionId(_))
        .ifSome(executionStatus)(_.executionStatus(_))
        .ifSome(executionResult)(_.executionResult(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(dataPullStartTime)(_.dataPullStartTime(_))
        .ifSome(dataPullEndTime)(_.dataPullEndTime(_))
        .build

    def fieldTypeDetails(
      fieldType: Option[String] = None,
      filterOperators: Option[List[Operator]] = None,
      supportedValues: Option[List[Value]] = None
    ): FieldTypeDetails =
      FieldTypeDetails
        .builder
        .ifSome(fieldType)(_.fieldType(_))
        .ifSome(filterOperators)(_.filterOperators(_))
        .ifSome(supportedValues)(_.supportedValues(_))
        .build

    def flowDefinition(
      flowArn: Option[String] = None,
      description: Option[String] = None,
      flowName: Option[String] = None,
      flowStatus: Option[String] = None,
      sourceConnectorType: Option[String] = None,
      destinationConnectorType: Option[String] = None,
      triggerType: Option[String] = None,
      createdAt: Option[Date] = None,
      lastUpdatedAt: Option[Date] = None,
      createdBy: Option[String] = None,
      lastUpdatedBy: Option[String] = None,
      tags: Option[TagMap] = None,
      lastRunExecutionDetails: Option[ExecutionDetails] = None
    ): FlowDefinition =
      FlowDefinition
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(flowName)(_.flowName(_))
        .ifSome(flowStatus)(_.flowStatus(_))
        .ifSome(sourceConnectorType)(_.sourceConnectorType(_))
        .ifSome(destinationConnectorType)(_.destinationConnectorType(_))
        .ifSome(triggerType)(_.triggerType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastUpdatedBy)(_.lastUpdatedBy(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(lastRunExecutionDetails)(_.lastRunExecutionDetails(_))
        .build

    def googleAnalyticsConnectorProfileCredentials(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      accessToken: Option[String] = None,
      refreshToken: Option[String] = None,
      oAuthRequest: Option[ConnectorOAuthRequest] = None
    ): GoogleAnalyticsConnectorProfileCredentials =
      GoogleAnalyticsConnectorProfileCredentials
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .ifSome(oAuthRequest)(_.oAuthRequest(_))
        .build

    def googleAnalyticsConnectorProfileProperties(

    ): GoogleAnalyticsConnectorProfileProperties =
      GoogleAnalyticsConnectorProfileProperties
        .builder

        .build

    def googleAnalyticsMetadata(
      oAuthScopes: Option[List[OAuthScope]] = None
    ): GoogleAnalyticsMetadata =
      GoogleAnalyticsMetadata
        .builder
        .ifSome(oAuthScopes)(_.oAuthScopes(_))
        .build

    def googleAnalyticsSourceProperties(
      object: Option[String] = None
    ): GoogleAnalyticsSourceProperties =
      GoogleAnalyticsSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def honeycodeConnectorProfileCredentials(
      accessToken: Option[String] = None,
      refreshToken: Option[String] = None,
      oAuthRequest: Option[ConnectorOAuthRequest] = None
    ): HoneycodeConnectorProfileCredentials =
      HoneycodeConnectorProfileCredentials
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .ifSome(oAuthRequest)(_.oAuthRequest(_))
        .build

    def honeycodeConnectorProfileProperties(

    ): HoneycodeConnectorProfileProperties =
      HoneycodeConnectorProfileProperties
        .builder

        .build

    def honeycodeDestinationProperties(
      object: Option[String] = None,
      errorHandlingConfig: Option[ErrorHandlingConfig] = None
    ): HoneycodeDestinationProperties =
      HoneycodeDestinationProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(errorHandlingConfig)(_.errorHandlingConfig(_))
        .build

    def honeycodeMetadata(
      oAuthScopes: Option[List[OAuthScope]] = None
    ): HoneycodeMetadata =
      HoneycodeMetadata
        .builder
        .ifSome(oAuthScopes)(_.oAuthScopes(_))
        .build

    def incrementalPullConfig(
      datetimeTypeFieldName: Option[String] = None
    ): IncrementalPullConfig =
      IncrementalPullConfig
        .builder
        .ifSome(datetimeTypeFieldName)(_.datetimeTypeFieldName(_))
        .build

    def inforNexusConnectorProfileCredentials(
      accessKeyId: Option[String] = None,
      userId: Option[String] = None,
      secretAccessKey: Option[String] = None,
      datakey: Option[String] = None
    ): InforNexusConnectorProfileCredentials =
      InforNexusConnectorProfileCredentials
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(secretAccessKey)(_.secretAccessKey(_))
        .ifSome(datakey)(_.datakey(_))
        .build

    def inforNexusConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): InforNexusConnectorProfileProperties =
      InforNexusConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def inforNexusMetadata(

    ): InforNexusMetadata =
      InforNexusMetadata
        .builder

        .build

    def inforNexusSourceProperties(
      object: Option[String] = None
    ): InforNexusSourceProperties =
      InforNexusSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listConnectorEntitiesRequest(
      connectorProfileName: Option[String] = None,
      connectorType: Option[String] = None,
      entitiesPath: Option[String] = None
    ): ListConnectorEntitiesRequest =
      ListConnectorEntitiesRequest
        .builder
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(entitiesPath)(_.entitiesPath(_))
        .build

    def listConnectorEntitiesResponse(
      connectorEntityMap: Option[ConnectorEntityMap] = None
    ): ListConnectorEntitiesResponse =
      ListConnectorEntitiesResponse
        .builder
        .ifSome(connectorEntityMap)(_.connectorEntityMap(_))
        .build

    def listFlowsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFlowsRequest =
      ListFlowsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFlowsResponse(
      flows: Option[List[FlowDefinition]] = None,
      nextToken: Option[String] = None
    ): ListFlowsResponse =
      ListFlowsResponse
        .builder
        .ifSome(flows)(_.flows(_))
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

    def lookoutMetricsDestinationProperties(

    ): LookoutMetricsDestinationProperties =
      LookoutMetricsDestinationProperties
        .builder

        .build

    def marketoConnectorProfileCredentials(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      accessToken: Option[String] = None,
      oAuthRequest: Option[ConnectorOAuthRequest] = None
    ): MarketoConnectorProfileCredentials =
      MarketoConnectorProfileCredentials
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(oAuthRequest)(_.oAuthRequest(_))
        .build

    def marketoConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): MarketoConnectorProfileProperties =
      MarketoConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def marketoMetadata(

    ): MarketoMetadata =
      MarketoMetadata
        .builder

        .build

    def marketoSourceProperties(
      object: Option[String] = None
    ): MarketoSourceProperties =
      MarketoSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def prefixConfig(
      prefixType: Option[String] = None,
      prefixFormat: Option[String] = None
    ): PrefixConfig =
      PrefixConfig
        .builder
        .ifSome(prefixType)(_.prefixType(_))
        .ifSome(prefixFormat)(_.prefixFormat(_))
        .build

    def redshiftConnectorProfileCredentials(
      username: Option[String] = None,
      password: Option[String] = None
    ): RedshiftConnectorProfileCredentials =
      RedshiftConnectorProfileCredentials
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def redshiftConnectorProfileProperties(
      databaseUrl: Option[String] = None,
      bucketName: Option[String] = None,
      bucketPrefix: Option[String] = None,
      roleArn: Option[String] = None
    ): RedshiftConnectorProfileProperties =
      RedshiftConnectorProfileProperties
        .builder
        .ifSome(databaseUrl)(_.databaseUrl(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def redshiftDestinationProperties(
      object: Option[String] = None,
      intermediateBucketName: Option[String] = None,
      bucketPrefix: Option[String] = None,
      errorHandlingConfig: Option[ErrorHandlingConfig] = None
    ): RedshiftDestinationProperties =
      RedshiftDestinationProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(intermediateBucketName)(_.intermediateBucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(errorHandlingConfig)(_.errorHandlingConfig(_))
        .build

    def redshiftMetadata(

    ): RedshiftMetadata =
      RedshiftMetadata
        .builder

        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3DestinationProperties(
      bucketName: Option[String] = None,
      bucketPrefix: Option[String] = None,
      s3OutputFormatConfig: Option[S3OutputFormatConfig] = None
    ): S3DestinationProperties =
      S3DestinationProperties
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(s3OutputFormatConfig)(_.s3OutputFormatConfig(_))
        .build

    def s3Metadata(

    ): S3Metadata =
      S3Metadata
        .builder

        .build

    def s3OutputFormatConfig(
      fileType: Option[String] = None,
      prefixConfig: Option[PrefixConfig] = None,
      aggregationConfig: Option[AggregationConfig] = None
    ): S3OutputFormatConfig =
      S3OutputFormatConfig
        .builder
        .ifSome(fileType)(_.fileType(_))
        .ifSome(prefixConfig)(_.prefixConfig(_))
        .ifSome(aggregationConfig)(_.aggregationConfig(_))
        .build

    def s3SourceProperties(
      bucketName: Option[String] = None,
      bucketPrefix: Option[String] = None
    ): S3SourceProperties =
      S3SourceProperties
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .build

    def salesforceConnectorProfileCredentials(
      accessToken: Option[String] = None,
      refreshToken: Option[String] = None,
      oAuthRequest: Option[ConnectorOAuthRequest] = None,
      clientCredentialsArn: Option[String] = None
    ): SalesforceConnectorProfileCredentials =
      SalesforceConnectorProfileCredentials
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .ifSome(oAuthRequest)(_.oAuthRequest(_))
        .ifSome(clientCredentialsArn)(_.clientCredentialsArn(_))
        .build

    def salesforceConnectorProfileProperties(
      instanceUrl: Option[String] = None,
      isSandboxEnvironment: Option[Boolean] = None
    ): SalesforceConnectorProfileProperties =
      SalesforceConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .ifSome(isSandboxEnvironment)(_.isSandboxEnvironment(_))
        .build

    def salesforceDestinationProperties(
      object: Option[String] = None,
      idFieldNames: Option[List[Name]] = None,
      errorHandlingConfig: Option[ErrorHandlingConfig] = None,
      writeOperationType: Option[String] = None
    ): SalesforceDestinationProperties =
      SalesforceDestinationProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(idFieldNames)(_.idFieldNames(_))
        .ifSome(errorHandlingConfig)(_.errorHandlingConfig(_))
        .ifSome(writeOperationType)(_.writeOperationType(_))
        .build

    def salesforceMetadata(
      oAuthScopes: Option[List[OAuthScope]] = None
    ): SalesforceMetadata =
      SalesforceMetadata
        .builder
        .ifSome(oAuthScopes)(_.oAuthScopes(_))
        .build

    def salesforceSourceProperties(
      object: Option[String] = None,
      enableDynamicFieldUpdate: Option[Boolean] = None,
      includeDeletedRecords: Option[Boolean] = None
    ): SalesforceSourceProperties =
      SalesforceSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(enableDynamicFieldUpdate)(_.enableDynamicFieldUpdate(_))
        .ifSome(includeDeletedRecords)(_.includeDeletedRecords(_))
        .build

    def scheduledTriggerProperties(
      scheduleExpression: Option[String] = None,
      dataPullMode: Option[String] = None,
      scheduleStartTime: Option[Date] = None,
      scheduleEndTime: Option[Date] = None,
      timezone: Option[String] = None,
      scheduleOffset: Option[ScheduleOffset] = None,
      firstExecutionFrom: Option[Date] = None
    ): ScheduledTriggerProperties =
      ScheduledTriggerProperties
        .builder
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(dataPullMode)(_.dataPullMode(_))
        .ifSome(scheduleStartTime)(_.scheduleStartTime(_))
        .ifSome(scheduleEndTime)(_.scheduleEndTime(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(scheduleOffset)(_.scheduleOffset(_))
        .ifSome(firstExecutionFrom)(_.firstExecutionFrom(_))
        .build

    def serviceNowConnectorProfileCredentials(
      username: Option[String] = None,
      password: Option[String] = None
    ): ServiceNowConnectorProfileCredentials =
      ServiceNowConnectorProfileCredentials
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def serviceNowConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): ServiceNowConnectorProfileProperties =
      ServiceNowConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def serviceNowMetadata(

    ): ServiceNowMetadata =
      ServiceNowMetadata
        .builder

        .build

    def serviceNowSourceProperties(
      object: Option[String] = None
    ): ServiceNowSourceProperties =
      ServiceNowSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def singularConnectorProfileCredentials(
      apiKey: Option[String] = None
    ): SingularConnectorProfileCredentials =
      SingularConnectorProfileCredentials
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .build

    def singularConnectorProfileProperties(

    ): SingularConnectorProfileProperties =
      SingularConnectorProfileProperties
        .builder

        .build

    def singularMetadata(

    ): SingularMetadata =
      SingularMetadata
        .builder

        .build

    def singularSourceProperties(
      object: Option[String] = None
    ): SingularSourceProperties =
      SingularSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def slackConnectorProfileCredentials(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      accessToken: Option[String] = None,
      oAuthRequest: Option[ConnectorOAuthRequest] = None
    ): SlackConnectorProfileCredentials =
      SlackConnectorProfileCredentials
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(oAuthRequest)(_.oAuthRequest(_))
        .build

    def slackConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): SlackConnectorProfileProperties =
      SlackConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def slackMetadata(
      oAuthScopes: Option[List[OAuthScope]] = None
    ): SlackMetadata =
      SlackMetadata
        .builder
        .ifSome(oAuthScopes)(_.oAuthScopes(_))
        .build

    def slackSourceProperties(
      object: Option[String] = None
    ): SlackSourceProperties =
      SlackSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def snowflakeConnectorProfileCredentials(
      username: Option[String] = None,
      password: Option[String] = None
    ): SnowflakeConnectorProfileCredentials =
      SnowflakeConnectorProfileCredentials
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def snowflakeConnectorProfileProperties(
      warehouse: Option[String] = None,
      stage: Option[String] = None,
      bucketName: Option[String] = None,
      bucketPrefix: Option[String] = None,
      privateLinkServiceName: Option[String] = None,
      accountName: Option[String] = None,
      region: Option[String] = None
    ): SnowflakeConnectorProfileProperties =
      SnowflakeConnectorProfileProperties
        .builder
        .ifSome(warehouse)(_.warehouse(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(privateLinkServiceName)(_.privateLinkServiceName(_))
        .ifSome(accountName)(_.accountName(_))
        .ifSome(region)(_.region(_))
        .build

    def snowflakeDestinationProperties(
      object: Option[String] = None,
      intermediateBucketName: Option[String] = None,
      bucketPrefix: Option[String] = None,
      errorHandlingConfig: Option[ErrorHandlingConfig] = None
    ): SnowflakeDestinationProperties =
      SnowflakeDestinationProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(intermediateBucketName)(_.intermediateBucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(errorHandlingConfig)(_.errorHandlingConfig(_))
        .build

    def snowflakeMetadata(
      supportedRegions: Option[List[Region]] = None
    ): SnowflakeMetadata =
      SnowflakeMetadata
        .builder
        .ifSome(supportedRegions)(_.supportedRegions(_))
        .build

    def sourceConnectorProperties(
      amplitude: Option[AmplitudeSourceProperties] = None,
      datadog: Option[DatadogSourceProperties] = None,
      dynatrace: Option[DynatraceSourceProperties] = None,
      googleAnalytics: Option[GoogleAnalyticsSourceProperties] = None,
      inforNexus: Option[InforNexusSourceProperties] = None,
      marketo: Option[MarketoSourceProperties] = None,
      s3: Option[S3SourceProperties] = None,
      salesforce: Option[SalesforceSourceProperties] = None,
      serviceNow: Option[ServiceNowSourceProperties] = None,
      singular: Option[SingularSourceProperties] = None,
      slack: Option[SlackSourceProperties] = None,
      trendmicro: Option[TrendmicroSourceProperties] = None,
      veeva: Option[VeevaSourceProperties] = None,
      zendesk: Option[ZendeskSourceProperties] = None
    ): SourceConnectorProperties =
      SourceConnectorProperties
        .builder
        .ifSome(amplitude)(_.amplitude(_))
        .ifSome(datadog)(_.datadog(_))
        .ifSome(dynatrace)(_.dynatrace(_))
        .ifSome(googleAnalytics)(_.googleAnalytics(_))
        .ifSome(inforNexus)(_.inforNexus(_))
        .ifSome(marketo)(_.marketo(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(serviceNow)(_.serviceNow(_))
        .ifSome(singular)(_.singular(_))
        .ifSome(slack)(_.slack(_))
        .ifSome(trendmicro)(_.trendmicro(_))
        .ifSome(veeva)(_.veeva(_))
        .ifSome(zendesk)(_.zendesk(_))
        .build

    def sourceFieldProperties(
      isRetrievable: Option[Boolean] = None,
      isQueryable: Option[Boolean] = None
    ): SourceFieldProperties =
      SourceFieldProperties
        .builder
        .ifSome(isRetrievable)(_.isRetrievable(_))
        .ifSome(isQueryable)(_.isQueryable(_))
        .build

    def sourceFlowConfig(
      connectorType: Option[String] = None,
      connectorProfileName: Option[String] = None,
      sourceConnectorProperties: Option[SourceConnectorProperties] = None,
      incrementalPullConfig: Option[IncrementalPullConfig] = None
    ): SourceFlowConfig =
      SourceFlowConfig
        .builder
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(sourceConnectorProperties)(_.sourceConnectorProperties(_))
        .ifSome(incrementalPullConfig)(_.incrementalPullConfig(_))
        .build

    def startFlowRequest(
      flowName: Option[String] = None
    ): StartFlowRequest =
      StartFlowRequest
        .builder
        .ifSome(flowName)(_.flowName(_))
        .build

    def startFlowResponse(
      flowArn: Option[String] = None,
      flowStatus: Option[String] = None,
      executionId: Option[String] = None
    ): StartFlowResponse =
      StartFlowResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(flowStatus)(_.flowStatus(_))
        .ifSome(executionId)(_.executionId(_))
        .build

    def stopFlowRequest(
      flowName: Option[String] = None
    ): StopFlowRequest =
      StopFlowRequest
        .builder
        .ifSome(flowName)(_.flowName(_))
        .build

    def stopFlowResponse(
      flowArn: Option[String] = None,
      flowStatus: Option[String] = None
    ): StopFlowResponse =
      StopFlowResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(flowStatus)(_.flowStatus(_))
        .build

    def supportedFieldTypeDetails(
      v1: Option[FieldTypeDetails] = None
    ): SupportedFieldTypeDetails =
      SupportedFieldTypeDetails
        .builder
        .ifSome(v1)(_.v1(_))
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

    def task(
      sourceFields: Option[List[String]] = None,
      connectorOperator: Option[ConnectorOperator] = None,
      destinationField: Option[String] = None,
      taskType: Option[String] = None,
      taskProperties: Option[TaskPropertiesMap] = None
    ): Task =
      Task
        .builder
        .ifSome(sourceFields)(_.sourceFields(_))
        .ifSome(connectorOperator)(_.connectorOperator(_))
        .ifSome(destinationField)(_.destinationField(_))
        .ifSome(taskType)(_.taskType(_))
        .ifSome(taskProperties)(_.taskProperties(_))
        .build

    def trendmicroConnectorProfileCredentials(
      apiSecretKey: Option[String] = None
    ): TrendmicroConnectorProfileCredentials =
      TrendmicroConnectorProfileCredentials
        .builder
        .ifSome(apiSecretKey)(_.apiSecretKey(_))
        .build

    def trendmicroConnectorProfileProperties(

    ): TrendmicroConnectorProfileProperties =
      TrendmicroConnectorProfileProperties
        .builder

        .build

    def trendmicroMetadata(

    ): TrendmicroMetadata =
      TrendmicroMetadata
        .builder

        .build

    def trendmicroSourceProperties(
      object: Option[String] = None
    ): TrendmicroSourceProperties =
      TrendmicroSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def triggerConfig(
      triggerType: Option[String] = None,
      triggerProperties: Option[TriggerProperties] = None
    ): TriggerConfig =
      TriggerConfig
        .builder
        .ifSome(triggerType)(_.triggerType(_))
        .ifSome(triggerProperties)(_.triggerProperties(_))
        .build

    def triggerProperties(
      scheduled: Option[ScheduledTriggerProperties] = None
    ): TriggerProperties =
      TriggerProperties
        .builder
        .ifSome(scheduled)(_.scheduled(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
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

    def updateConnectorProfileRequest(
      connectorProfileName: Option[String] = None,
      connectionMode: Option[String] = None,
      connectorProfileConfig: Option[ConnectorProfileConfig] = None
    ): UpdateConnectorProfileRequest =
      UpdateConnectorProfileRequest
        .builder
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(connectionMode)(_.connectionMode(_))
        .ifSome(connectorProfileConfig)(_.connectorProfileConfig(_))
        .build

    def updateConnectorProfileResponse(
      connectorProfileArn: Option[String] = None
    ): UpdateConnectorProfileResponse =
      UpdateConnectorProfileResponse
        .builder
        .ifSome(connectorProfileArn)(_.connectorProfileArn(_))
        .build

    def updateFlowRequest(
      flowName: Option[String] = None,
      description: Option[String] = None,
      triggerConfig: Option[TriggerConfig] = None,
      sourceFlowConfig: Option[SourceFlowConfig] = None,
      destinationFlowConfigList: Option[List[DestinationFlowConfig]] = None,
      tasks: Option[List[Task]] = None
    ): UpdateFlowRequest =
      UpdateFlowRequest
        .builder
        .ifSome(flowName)(_.flowName(_))
        .ifSome(description)(_.description(_))
        .ifSome(triggerConfig)(_.triggerConfig(_))
        .ifSome(sourceFlowConfig)(_.sourceFlowConfig(_))
        .ifSome(destinationFlowConfigList)(_.destinationFlowConfigList(_))
        .ifSome(tasks)(_.tasks(_))
        .build

    def updateFlowResponse(
      flowStatus: Option[String] = None
    ): UpdateFlowResponse =
      UpdateFlowResponse
        .builder
        .ifSome(flowStatus)(_.flowStatus(_))
        .build

    def upsolverDestinationProperties(
      bucketName: Option[String] = None,
      bucketPrefix: Option[String] = None,
      s3OutputFormatConfig: Option[UpsolverS3OutputFormatConfig] = None
    ): UpsolverDestinationProperties =
      UpsolverDestinationProperties
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .ifSome(s3OutputFormatConfig)(_.s3OutputFormatConfig(_))
        .build

    def upsolverMetadata(

    ): UpsolverMetadata =
      UpsolverMetadata
        .builder

        .build

    def upsolverS3OutputFormatConfig(
      fileType: Option[String] = None,
      prefixConfig: Option[PrefixConfig] = None,
      aggregationConfig: Option[AggregationConfig] = None
    ): UpsolverS3OutputFormatConfig =
      UpsolverS3OutputFormatConfig
        .builder
        .ifSome(fileType)(_.fileType(_))
        .ifSome(prefixConfig)(_.prefixConfig(_))
        .ifSome(aggregationConfig)(_.aggregationConfig(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def veevaConnectorProfileCredentials(
      username: Option[String] = None,
      password: Option[String] = None
    ): VeevaConnectorProfileCredentials =
      VeevaConnectorProfileCredentials
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def veevaConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): VeevaConnectorProfileProperties =
      VeevaConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def veevaMetadata(

    ): VeevaMetadata =
      VeevaMetadata
        .builder

        .build

    def veevaSourceProperties(
      object: Option[String] = None
    ): VeevaSourceProperties =
      VeevaSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def zendeskConnectorProfileCredentials(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      accessToken: Option[String] = None,
      oAuthRequest: Option[ConnectorOAuthRequest] = None
    ): ZendeskConnectorProfileCredentials =
      ZendeskConnectorProfileCredentials
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(oAuthRequest)(_.oAuthRequest(_))
        .build

    def zendeskConnectorProfileProperties(
      instanceUrl: Option[String] = None
    ): ZendeskConnectorProfileProperties =
      ZendeskConnectorProfileProperties
        .builder
        .ifSome(instanceUrl)(_.instanceUrl(_))
        .build

    def zendeskDestinationProperties(
      object: Option[String] = None,
      idFieldNames: Option[List[Name]] = None,
      errorHandlingConfig: Option[ErrorHandlingConfig] = None,
      writeOperationType: Option[String] = None
    ): ZendeskDestinationProperties =
      ZendeskDestinationProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(idFieldNames)(_.idFieldNames(_))
        .ifSome(errorHandlingConfig)(_.errorHandlingConfig(_))
        .ifSome(writeOperationType)(_.writeOperationType(_))
        .build

    def zendeskMetadata(
      oAuthScopes: Option[List[OAuthScope]] = None
    ): ZendeskMetadata =
      ZendeskMetadata
        .builder
        .ifSome(oAuthScopes)(_.oAuthScopes(_))
        .build

    def zendeskSourceProperties(
      object: Option[String] = None
    ): ZendeskSourceProperties =
      ZendeskSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
