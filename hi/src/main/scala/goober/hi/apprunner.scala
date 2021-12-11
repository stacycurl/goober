package goober.hi

import goober.free.apprunner.AppRunnerIO
import software.amazon.awssdk.services.apprunner.model._


object apprunner {
  import goober.free.{apprunner ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateCustomDomainRequest(
      serviceArn: Option[String] = None,
      domainName: Option[String] = None,
      enableWWWSubdomain: Option[Boolean] = None
    ): AssociateCustomDomainRequest =
      AssociateCustomDomainRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(enableWWWSubdomain)(_.enableWWWSubdomain(_))
        .build

    def associateCustomDomainResponse(
      dNSTarget: Option[String] = None,
      serviceArn: Option[String] = None,
      customDomain: Option[CustomDomain] = None
    ): AssociateCustomDomainResponse =
      AssociateCustomDomainResponse
        .builder
        .ifSome(dNSTarget)(_.dNSTarget(_))
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(customDomain)(_.customDomain(_))
        .build

    def authenticationConfiguration(
      connectionArn: Option[String] = None,
      accessRoleArn: Option[String] = None
    ): AuthenticationConfiguration =
      AuthenticationConfiguration
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(accessRoleArn)(_.accessRoleArn(_))
        .build

    def autoScalingConfiguration(
      autoScalingConfigurationArn: Option[String] = None,
      autoScalingConfigurationName: Option[String] = None,
      autoScalingConfigurationRevision: Option[Int] = None,
      latest: Option[Boolean] = None,
      status: Option[String] = None,
      maxConcurrency: Option[Int] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      createdAt: Option[Timestamp] = None,
      deletedAt: Option[Timestamp] = None
    ): AutoScalingConfiguration =
      AutoScalingConfiguration
        .builder
        .ifSome(autoScalingConfigurationArn)(_.autoScalingConfigurationArn(_))
        .ifSome(autoScalingConfigurationName)(_.autoScalingConfigurationName(_))
        .ifSome(autoScalingConfigurationRevision)(_.autoScalingConfigurationRevision(_))
        .ifSome(latest)(_.latest(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deletedAt)(_.deletedAt(_))
        .build

    def autoScalingConfigurationSummary(
      autoScalingConfigurationArn: Option[String] = None,
      autoScalingConfigurationName: Option[String] = None,
      autoScalingConfigurationRevision: Option[Int] = None
    ): AutoScalingConfigurationSummary =
      AutoScalingConfigurationSummary
        .builder
        .ifSome(autoScalingConfigurationArn)(_.autoScalingConfigurationArn(_))
        .ifSome(autoScalingConfigurationName)(_.autoScalingConfigurationName(_))
        .ifSome(autoScalingConfigurationRevision)(_.autoScalingConfigurationRevision(_))
        .build

    def certificateValidationRecord(
      name: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None,
      status: Option[String] = None
    ): CertificateValidationRecord =
      CertificateValidationRecord
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .ifSome(status)(_.status(_))
        .build

    def codeConfiguration(
      configurationSource: Option[String] = None,
      codeConfigurationValues: Option[CodeConfigurationValues] = None
    ): CodeConfiguration =
      CodeConfiguration
        .builder
        .ifSome(configurationSource)(_.configurationSource(_))
        .ifSome(codeConfigurationValues)(_.codeConfigurationValues(_))
        .build

    def codeConfigurationValues(
      runtime: Option[String] = None,
      buildCommand: Option[String] = None,
      startCommand: Option[String] = None,
      port: Option[String] = None,
      runtimeEnvironmentVariables: Option[RuntimeEnvironmentVariables] = None
    ): CodeConfigurationValues =
      CodeConfigurationValues
        .builder
        .ifSome(runtime)(_.runtime(_))
        .ifSome(buildCommand)(_.buildCommand(_))
        .ifSome(startCommand)(_.startCommand(_))
        .ifSome(port)(_.port(_))
        .ifSome(runtimeEnvironmentVariables)(_.runtimeEnvironmentVariables(_))
        .build

    def codeRepository(
      repositoryUrl: Option[String] = None,
      sourceCodeVersion: Option[SourceCodeVersion] = None,
      codeConfiguration: Option[CodeConfiguration] = None
    ): CodeRepository =
      CodeRepository
        .builder
        .ifSome(repositoryUrl)(_.repositoryUrl(_))
        .ifSome(sourceCodeVersion)(_.sourceCodeVersion(_))
        .ifSome(codeConfiguration)(_.codeConfiguration(_))
        .build

    def connection(
      connectionName: Option[String] = None,
      connectionArn: Option[String] = None,
      providerType: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[Timestamp] = None
    ): Connection =
      Connection
        .builder
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def connectionSummary(
      connectionName: Option[String] = None,
      connectionArn: Option[String] = None,
      providerType: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[Timestamp] = None
    ): ConnectionSummary =
      ConnectionSummary
        .builder
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def createAutoScalingConfigurationRequest(
      autoScalingConfigurationName: Option[String] = None,
      maxConcurrency: Option[Int] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): CreateAutoScalingConfigurationRequest =
      CreateAutoScalingConfigurationRequest
        .builder
        .ifSome(autoScalingConfigurationName)(_.autoScalingConfigurationName(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAutoScalingConfigurationResponse(
      autoScalingConfiguration: Option[AutoScalingConfiguration] = None
    ): CreateAutoScalingConfigurationResponse =
      CreateAutoScalingConfigurationResponse
        .builder
        .ifSome(autoScalingConfiguration)(_.autoScalingConfiguration(_))
        .build

    def createConnectionRequest(
      connectionName: Option[String] = None,
      providerType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateConnectionRequest =
      CreateConnectionRequest
        .builder
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConnectionResponse(
      connection: Option[Connection] = None
    ): CreateConnectionResponse =
      CreateConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def createServiceRequest(
      serviceName: Option[String] = None,
      sourceConfiguration: Option[SourceConfiguration] = None,
      instanceConfiguration: Option[InstanceConfiguration] = None,
      tags: Option[List[Tag]] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      healthCheckConfiguration: Option[HealthCheckConfiguration] = None,
      autoScalingConfigurationArn: Option[String] = None
    ): CreateServiceRequest =
      CreateServiceRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(sourceConfiguration)(_.sourceConfiguration(_))
        .ifSome(instanceConfiguration)(_.instanceConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(healthCheckConfiguration)(_.healthCheckConfiguration(_))
        .ifSome(autoScalingConfigurationArn)(_.autoScalingConfigurationArn(_))
        .build

    def createServiceResponse(
      service: Option[Service] = None,
      operationId: Option[String] = None
    ): CreateServiceResponse =
      CreateServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(operationId)(_.operationId(_))
        .build

    def customDomain(
      domainName: Option[String] = None,
      enableWWWSubdomain: Option[Boolean] = None,
      certificateValidationRecords: Option[List[CertificateValidationRecord]] = None,
      status: Option[String] = None
    ): CustomDomain =
      CustomDomain
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(enableWWWSubdomain)(_.enableWWWSubdomain(_))
        .ifSome(certificateValidationRecords)(_.certificateValidationRecords(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteAutoScalingConfigurationRequest(
      autoScalingConfigurationArn: Option[String] = None
    ): DeleteAutoScalingConfigurationRequest =
      DeleteAutoScalingConfigurationRequest
        .builder
        .ifSome(autoScalingConfigurationArn)(_.autoScalingConfigurationArn(_))
        .build

    def deleteAutoScalingConfigurationResponse(
      autoScalingConfiguration: Option[AutoScalingConfiguration] = None
    ): DeleteAutoScalingConfigurationResponse =
      DeleteAutoScalingConfigurationResponse
        .builder
        .ifSome(autoScalingConfiguration)(_.autoScalingConfiguration(_))
        .build

    def deleteConnectionRequest(
      connectionArn: Option[String] = None
    ): DeleteConnectionRequest =
      DeleteConnectionRequest
        .builder
        .ifSome(connectionArn)(_.connectionArn(_))
        .build

    def deleteConnectionResponse(
      connection: Option[Connection] = None
    ): DeleteConnectionResponse =
      DeleteConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def deleteServiceRequest(
      serviceArn: Option[String] = None
    ): DeleteServiceRequest =
      DeleteServiceRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .build

    def deleteServiceResponse(
      service: Option[Service] = None,
      operationId: Option[String] = None
    ): DeleteServiceResponse =
      DeleteServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(operationId)(_.operationId(_))
        .build

    def describeAutoScalingConfigurationRequest(
      autoScalingConfigurationArn: Option[String] = None
    ): DescribeAutoScalingConfigurationRequest =
      DescribeAutoScalingConfigurationRequest
        .builder
        .ifSome(autoScalingConfigurationArn)(_.autoScalingConfigurationArn(_))
        .build

    def describeAutoScalingConfigurationResponse(
      autoScalingConfiguration: Option[AutoScalingConfiguration] = None
    ): DescribeAutoScalingConfigurationResponse =
      DescribeAutoScalingConfigurationResponse
        .builder
        .ifSome(autoScalingConfiguration)(_.autoScalingConfiguration(_))
        .build

    def describeCustomDomainsRequest(
      serviceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeCustomDomainsRequest =
      DescribeCustomDomainsRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeCustomDomainsResponse(
      dNSTarget: Option[String] = None,
      serviceArn: Option[String] = None,
      customDomains: Option[List[CustomDomain]] = None,
      nextToken: Option[String] = None
    ): DescribeCustomDomainsResponse =
      DescribeCustomDomainsResponse
        .builder
        .ifSome(dNSTarget)(_.dNSTarget(_))
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(customDomains)(_.customDomains(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeServiceRequest(
      serviceArn: Option[String] = None
    ): DescribeServiceRequest =
      DescribeServiceRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .build

    def describeServiceResponse(
      service: Option[Service] = None
    ): DescribeServiceResponse =
      DescribeServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .build

    def disassociateCustomDomainRequest(
      serviceArn: Option[String] = None,
      domainName: Option[String] = None
    ): DisassociateCustomDomainRequest =
      DisassociateCustomDomainRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def disassociateCustomDomainResponse(
      dNSTarget: Option[String] = None,
      serviceArn: Option[String] = None,
      customDomain: Option[CustomDomain] = None
    ): DisassociateCustomDomainResponse =
      DisassociateCustomDomainResponse
        .builder
        .ifSome(dNSTarget)(_.dNSTarget(_))
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(customDomain)(_.customDomain(_))
        .build

    def encryptionConfiguration(
      kmsKey: Option[String] = None
    ): EncryptionConfiguration =
      EncryptionConfiguration
        .builder
        .ifSome(kmsKey)(_.kmsKey(_))
        .build

    def healthCheckConfiguration(
      protocol: Option[String] = None,
      path: Option[String] = None,
      interval: Option[Int] = None,
      timeout: Option[Int] = None,
      healthyThreshold: Option[Int] = None,
      unhealthyThreshold: Option[Int] = None
    ): HealthCheckConfiguration =
      HealthCheckConfiguration
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(path)(_.path(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(healthyThreshold)(_.healthyThreshold(_))
        .ifSome(unhealthyThreshold)(_.unhealthyThreshold(_))
        .build

    def imageConfiguration(
      runtimeEnvironmentVariables: Option[RuntimeEnvironmentVariables] = None,
      startCommand: Option[String] = None,
      port: Option[String] = None
    ): ImageConfiguration =
      ImageConfiguration
        .builder
        .ifSome(runtimeEnvironmentVariables)(_.runtimeEnvironmentVariables(_))
        .ifSome(startCommand)(_.startCommand(_))
        .ifSome(port)(_.port(_))
        .build

    def imageRepository(
      imageIdentifier: Option[String] = None,
      imageConfiguration: Option[ImageConfiguration] = None,
      imageRepositoryType: Option[String] = None
    ): ImageRepository =
      ImageRepository
        .builder
        .ifSome(imageIdentifier)(_.imageIdentifier(_))
        .ifSome(imageConfiguration)(_.imageConfiguration(_))
        .ifSome(imageRepositoryType)(_.imageRepositoryType(_))
        .build

    def instanceConfiguration(
      cpu: Option[String] = None,
      memory: Option[String] = None,
      instanceRoleArn: Option[String] = None
    ): InstanceConfiguration =
      InstanceConfiguration
        .builder
        .ifSome(cpu)(_.cpu(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(instanceRoleArn)(_.instanceRoleArn(_))
        .build

    def internalServiceErrorException(
      message: Option[String] = None
    ): InternalServiceErrorException =
      InternalServiceErrorException
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

    def invalidStateException(
      message: Option[String] = None
    ): InvalidStateException =
      InvalidStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAutoScalingConfigurationsRequest(
      autoScalingConfigurationName: Option[String] = None,
      latestOnly: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAutoScalingConfigurationsRequest =
      ListAutoScalingConfigurationsRequest
        .builder
        .ifSome(autoScalingConfigurationName)(_.autoScalingConfigurationName(_))
        .ifSome(latestOnly)(_.latestOnly(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAutoScalingConfigurationsResponse(
      autoScalingConfigurationSummaryList: Option[List[AutoScalingConfigurationSummary]] = None,
      nextToken: Option[String] = None
    ): ListAutoScalingConfigurationsResponse =
      ListAutoScalingConfigurationsResponse
        .builder
        .ifSome(autoScalingConfigurationSummaryList)(_.autoScalingConfigurationSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConnectionsRequest(
      connectionName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConnectionsRequest =
      ListConnectionsRequest
        .builder
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConnectionsResponse(
      connectionSummaryList: Option[List[ConnectionSummary]] = None,
      nextToken: Option[String] = None
    ): ListConnectionsResponse =
      ListConnectionsResponse
        .builder
        .ifSome(connectionSummaryList)(_.connectionSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOperationsRequest(
      serviceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListOperationsRequest =
      ListOperationsRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listOperationsResponse(
      operationSummaryList: Option[List[OperationSummary]] = None,
      nextToken: Option[String] = None
    ): ListOperationsResponse =
      ListOperationsResponse
        .builder
        .ifSome(operationSummaryList)(_.operationSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServicesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListServicesRequest =
      ListServicesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listServicesResponse(
      serviceSummaryList: Option[List[ServiceSummary]] = None,
      nextToken: Option[String] = None
    ): ListServicesResponse =
      ListServicesResponse
        .builder
        .ifSome(serviceSummaryList)(_.serviceSummaryList(_))
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
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def operationSummary(
      id: Option[String] = None,
      `type`: Option[String] = None,
      status: Option[String] = None,
      targetArn: Option[String] = None,
      startedAt: Option[Timestamp] = None,
      endedAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None
    ): OperationSummary =
      OperationSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(endedAt)(_.endedAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def pauseServiceRequest(
      serviceArn: Option[String] = None
    ): PauseServiceRequest =
      PauseServiceRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .build

    def pauseServiceResponse(
      service: Option[Service] = None,
      operationId: Option[String] = None
    ): PauseServiceResponse =
      PauseServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(operationId)(_.operationId(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resumeServiceRequest(
      serviceArn: Option[String] = None
    ): ResumeServiceRequest =
      ResumeServiceRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .build

    def resumeServiceResponse(
      service: Option[Service] = None,
      operationId: Option[String] = None
    ): ResumeServiceResponse =
      ResumeServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(operationId)(_.operationId(_))
        .build

    def service(
      serviceName: Option[String] = None,
      serviceId: Option[String] = None,
      serviceArn: Option[String] = None,
      serviceUrl: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      deletedAt: Option[Timestamp] = None,
      status: Option[String] = None,
      sourceConfiguration: Option[SourceConfiguration] = None,
      instanceConfiguration: Option[InstanceConfiguration] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      healthCheckConfiguration: Option[HealthCheckConfiguration] = None,
      autoScalingConfigurationSummary: Option[AutoScalingConfigurationSummary] = None
    ): Service =
      Service
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(serviceUrl)(_.serviceUrl(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(deletedAt)(_.deletedAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(sourceConfiguration)(_.sourceConfiguration(_))
        .ifSome(instanceConfiguration)(_.instanceConfiguration(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(healthCheckConfiguration)(_.healthCheckConfiguration(_))
        .ifSome(autoScalingConfigurationSummary)(_.autoScalingConfigurationSummary(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceSummary(
      serviceName: Option[String] = None,
      serviceId: Option[String] = None,
      serviceArn: Option[String] = None,
      serviceUrl: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      status: Option[String] = None
    ): ServiceSummary =
      ServiceSummary
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(serviceUrl)(_.serviceUrl(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(status)(_.status(_))
        .build

    def sourceCodeVersion(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): SourceCodeVersion =
      SourceCodeVersion
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def sourceConfiguration(
      codeRepository: Option[CodeRepository] = None,
      imageRepository: Option[ImageRepository] = None,
      autoDeploymentsEnabled: Option[Boolean] = None,
      authenticationConfiguration: Option[AuthenticationConfiguration] = None
    ): SourceConfiguration =
      SourceConfiguration
        .builder
        .ifSome(codeRepository)(_.codeRepository(_))
        .ifSome(imageRepository)(_.imageRepository(_))
        .ifSome(autoDeploymentsEnabled)(_.autoDeploymentsEnabled(_))
        .ifSome(authenticationConfiguration)(_.authenticationConfiguration(_))
        .build

    def startDeploymentRequest(
      serviceArn: Option[String] = None
    ): StartDeploymentRequest =
      StartDeploymentRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .build

    def startDeploymentResponse(
      operationId: Option[String] = None
    ): StartDeploymentResponse =
      StartDeploymentResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
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

    def updateServiceRequest(
      serviceArn: Option[String] = None,
      sourceConfiguration: Option[SourceConfiguration] = None,
      instanceConfiguration: Option[InstanceConfiguration] = None,
      autoScalingConfigurationArn: Option[String] = None,
      healthCheckConfiguration: Option[HealthCheckConfiguration] = None
    ): UpdateServiceRequest =
      UpdateServiceRequest
        .builder
        .ifSome(serviceArn)(_.serviceArn(_))
        .ifSome(sourceConfiguration)(_.sourceConfiguration(_))
        .ifSome(instanceConfiguration)(_.instanceConfiguration(_))
        .ifSome(autoScalingConfigurationArn)(_.autoScalingConfigurationArn(_))
        .ifSome(healthCheckConfiguration)(_.healthCheckConfiguration(_))
        .build

    def updateServiceResponse(
      service: Option[Service] = None,
      operationId: Option[String] = None
    ): UpdateServiceResponse =
      UpdateServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(operationId)(_.operationId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
