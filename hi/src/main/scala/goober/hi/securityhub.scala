package goober.hi

import goober.free.securityhub.SecurityHubIO
import software.amazon.awssdk.services.securityhub.model._


object securityhub {
  import goober.free.{securityhub ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptAdministratorInvitationRequest(
      administratorId: Option[String] = None,
      invitationId: Option[String] = None
    ): AcceptAdministratorInvitationRequest =
      AcceptAdministratorInvitationRequest
        .builder
        .ifSome(administratorId)(_.administratorId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .build

    def acceptAdministratorInvitationResponse(

    ): AcceptAdministratorInvitationResponse =
      AcceptAdministratorInvitationResponse
        .builder

        .build

    def acceptInvitationRequest(
      masterId: Option[String] = None,
      invitationId: Option[String] = None
    ): AcceptInvitationRequest =
      AcceptInvitationRequest
        .builder
        .ifSome(masterId)(_.masterId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .build

    def acceptInvitationResponse(

    ): AcceptInvitationResponse =
      AcceptInvitationResponse
        .builder

        .build

    def accessDeniedException(
      message: Option[String] = None,
      code: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def accountDetails(
      accountId: Option[String] = None,
      email: Option[String] = None
    ): AccountDetails =
      AccountDetails
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(email)(_.email(_))
        .build

    def action(
      actionType: Option[String] = None,
      networkConnectionAction: Option[NetworkConnectionAction] = None,
      awsApiCallAction: Option[AwsApiCallAction] = None,
      dnsRequestAction: Option[DnsRequestAction] = None,
      portProbeAction: Option[PortProbeAction] = None
    ): Action =
      Action
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(networkConnectionAction)(_.networkConnectionAction(_))
        .ifSome(awsApiCallAction)(_.awsApiCallAction(_))
        .ifSome(dnsRequestAction)(_.dnsRequestAction(_))
        .ifSome(portProbeAction)(_.portProbeAction(_))
        .build

    def actionLocalIpDetails(
      ipAddressV4: Option[String] = None
    ): ActionLocalIpDetails =
      ActionLocalIpDetails
        .builder
        .ifSome(ipAddressV4)(_.ipAddressV4(_))
        .build

    def actionLocalPortDetails(
      port: Option[Int] = None,
      portName: Option[String] = None
    ): ActionLocalPortDetails =
      ActionLocalPortDetails
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(portName)(_.portName(_))
        .build

    def actionRemoteIpDetails(
      ipAddressV4: Option[String] = None,
      organization: Option[IpOrganizationDetails] = None,
      country: Option[Country] = None,
      city: Option[City] = None,
      geoLocation: Option[GeoLocation] = None
    ): ActionRemoteIpDetails =
      ActionRemoteIpDetails
        .builder
        .ifSome(ipAddressV4)(_.ipAddressV4(_))
        .ifSome(organization)(_.organization(_))
        .ifSome(country)(_.country(_))
        .ifSome(city)(_.city(_))
        .ifSome(geoLocation)(_.geoLocation(_))
        .build

    def actionRemotePortDetails(
      port: Option[Int] = None,
      portName: Option[String] = None
    ): ActionRemotePortDetails =
      ActionRemotePortDetails
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(portName)(_.portName(_))
        .build

    def actionTarget(
      actionTargetArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): ActionTarget =
      ActionTarget
        .builder
        .ifSome(actionTargetArn)(_.actionTargetArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def adminAccount(
      accountId: Option[String] = None,
      status: Option[String] = None
    ): AdminAccount =
      AdminAccount
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(status)(_.status(_))
        .build

    def availabilityZone(
      zoneName: Option[String] = None,
      subnetId: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(zoneName)(_.zoneName(_))
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def awsApiCallAction(
      api: Option[String] = None,
      serviceName: Option[String] = None,
      callerType: Option[String] = None,
      remoteIpDetails: Option[ActionRemoteIpDetails] = None,
      domainDetails: Option[AwsApiCallActionDomainDetails] = None,
      affectedResources: Option[FieldMap] = None,
      firstSeen: Option[String] = None,
      lastSeen: Option[String] = None
    ): AwsApiCallAction =
      AwsApiCallAction
        .builder
        .ifSome(api)(_.api(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(callerType)(_.callerType(_))
        .ifSome(remoteIpDetails)(_.remoteIpDetails(_))
        .ifSome(domainDetails)(_.domainDetails(_))
        .ifSome(affectedResources)(_.affectedResources(_))
        .ifSome(firstSeen)(_.firstSeen(_))
        .ifSome(lastSeen)(_.lastSeen(_))
        .build

    def awsApiCallActionDomainDetails(
      domain: Option[String] = None
    ): AwsApiCallActionDomainDetails =
      AwsApiCallActionDomainDetails
        .builder
        .ifSome(domain)(_.domain(_))
        .build

    def awsApiGatewayAccessLogSettings(
      format: Option[String] = None,
      destinationArn: Option[String] = None
    ): AwsApiGatewayAccessLogSettings =
      AwsApiGatewayAccessLogSettings
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .build

    def awsApiGatewayCanarySettings(
      percentTraffic: Option[Double] = None,
      deploymentId: Option[String] = None,
      stageVariableOverrides: Option[FieldMap] = None,
      useStageCache: Option[Boolean] = None
    ): AwsApiGatewayCanarySettings =
      AwsApiGatewayCanarySettings
        .builder
        .ifSome(percentTraffic)(_.percentTraffic(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(stageVariableOverrides)(_.stageVariableOverrides(_))
        .ifSome(useStageCache)(_.useStageCache(_))
        .build

    def awsApiGatewayEndpointConfiguration(
      types: Option[List[NonEmptyString]] = None
    ): AwsApiGatewayEndpointConfiguration =
      AwsApiGatewayEndpointConfiguration
        .builder
        .ifSome(types)(_.types(_))
        .build

    def awsApiGatewayMethodSettings(
      metricsEnabled: Option[Boolean] = None,
      loggingLevel: Option[String] = None,
      dataTraceEnabled: Option[Boolean] = None,
      throttlingBurstLimit: Option[Int] = None,
      throttlingRateLimit: Option[Double] = None,
      cachingEnabled: Option[Boolean] = None,
      cacheTtlInSeconds: Option[Int] = None,
      cacheDataEncrypted: Option[Boolean] = None,
      requireAuthorizationForCacheControl: Option[Boolean] = None,
      unauthorizedCacheControlHeaderStrategy: Option[String] = None,
      httpMethod: Option[String] = None,
      resourcePath: Option[String] = None
    ): AwsApiGatewayMethodSettings =
      AwsApiGatewayMethodSettings
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
        .ifSome(httpMethod)(_.httpMethod(_))
        .ifSome(resourcePath)(_.resourcePath(_))
        .build

    def awsApiGatewayRestApiDetails(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      createdDate: Option[String] = None,
      version: Option[String] = None,
      binaryMediaTypes: Option[List[NonEmptyString]] = None,
      minimumCompressionSize: Option[Int] = None,
      apiKeySource: Option[String] = None,
      endpointConfiguration: Option[AwsApiGatewayEndpointConfiguration] = None
    ): AwsApiGatewayRestApiDetails =
      AwsApiGatewayRestApiDetails
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(version)(_.version(_))
        .ifSome(binaryMediaTypes)(_.binaryMediaTypes(_))
        .ifSome(minimumCompressionSize)(_.minimumCompressionSize(_))
        .ifSome(apiKeySource)(_.apiKeySource(_))
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .build

    def awsApiGatewayStageDetails(
      deploymentId: Option[String] = None,
      clientCertificateId: Option[String] = None,
      stageName: Option[String] = None,
      description: Option[String] = None,
      cacheClusterEnabled: Option[Boolean] = None,
      cacheClusterSize: Option[String] = None,
      cacheClusterStatus: Option[String] = None,
      methodSettings: Option[List[AwsApiGatewayMethodSettings]] = None,
      variables: Option[FieldMap] = None,
      documentationVersion: Option[String] = None,
      accessLogSettings: Option[AwsApiGatewayAccessLogSettings] = None,
      canarySettings: Option[AwsApiGatewayCanarySettings] = None,
      tracingEnabled: Option[Boolean] = None,
      createdDate: Option[String] = None,
      lastUpdatedDate: Option[String] = None,
      webAclArn: Option[String] = None
    ): AwsApiGatewayStageDetails =
      AwsApiGatewayStageDetails
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
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(webAclArn)(_.webAclArn(_))
        .build

    def awsApiGatewayV2ApiDetails(
      apiEndpoint: Option[String] = None,
      apiId: Option[String] = None,
      apiKeySelectionExpression: Option[String] = None,
      createdDate: Option[String] = None,
      description: Option[String] = None,
      version: Option[String] = None,
      name: Option[String] = None,
      protocolType: Option[String] = None,
      routeSelectionExpression: Option[String] = None,
      corsConfiguration: Option[AwsCorsConfiguration] = None
    ): AwsApiGatewayV2ApiDetails =
      AwsApiGatewayV2ApiDetails
        .builder
        .ifSome(apiEndpoint)(_.apiEndpoint(_))
        .ifSome(apiId)(_.apiId(_))
        .ifSome(apiKeySelectionExpression)(_.apiKeySelectionExpression(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(version)(_.version(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocolType)(_.protocolType(_))
        .ifSome(routeSelectionExpression)(_.routeSelectionExpression(_))
        .ifSome(corsConfiguration)(_.corsConfiguration(_))
        .build

    def awsApiGatewayV2RouteSettings(
      detailedMetricsEnabled: Option[Boolean] = None,
      loggingLevel: Option[String] = None,
      dataTraceEnabled: Option[Boolean] = None,
      throttlingBurstLimit: Option[Int] = None,
      throttlingRateLimit: Option[Double] = None
    ): AwsApiGatewayV2RouteSettings =
      AwsApiGatewayV2RouteSettings
        .builder
        .ifSome(detailedMetricsEnabled)(_.detailedMetricsEnabled(_))
        .ifSome(loggingLevel)(_.loggingLevel(_))
        .ifSome(dataTraceEnabled)(_.dataTraceEnabled(_))
        .ifSome(throttlingBurstLimit)(_.throttlingBurstLimit(_))
        .ifSome(throttlingRateLimit)(_.throttlingRateLimit(_))
        .build

    def awsApiGatewayV2StageDetails(
      createdDate: Option[String] = None,
      description: Option[String] = None,
      defaultRouteSettings: Option[AwsApiGatewayV2RouteSettings] = None,
      deploymentId: Option[String] = None,
      lastUpdatedDate: Option[String] = None,
      routeSettings: Option[AwsApiGatewayV2RouteSettings] = None,
      stageName: Option[String] = None,
      stageVariables: Option[FieldMap] = None,
      accessLogSettings: Option[AwsApiGatewayAccessLogSettings] = None,
      autoDeploy: Option[Boolean] = None,
      lastDeploymentStatusMessage: Option[String] = None,
      apiGatewayManaged: Option[Boolean] = None
    ): AwsApiGatewayV2StageDetails =
      AwsApiGatewayV2StageDetails
        .builder
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultRouteSettings)(_.defaultRouteSettings(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(routeSettings)(_.routeSettings(_))
        .ifSome(stageName)(_.stageName(_))
        .ifSome(stageVariables)(_.stageVariables(_))
        .ifSome(accessLogSettings)(_.accessLogSettings(_))
        .ifSome(autoDeploy)(_.autoDeploy(_))
        .ifSome(lastDeploymentStatusMessage)(_.lastDeploymentStatusMessage(_))
        .ifSome(apiGatewayManaged)(_.apiGatewayManaged(_))
        .build

    def awsAutoScalingAutoScalingGroupDetails(
      launchConfigurationName: Option[String] = None,
      loadBalancerNames: Option[List[NonEmptyString]] = None,
      healthCheckType: Option[String] = None,
      healthCheckGracePeriod: Option[Int] = None,
      createdTime: Option[String] = None
    ): AwsAutoScalingAutoScalingGroupDetails =
      AwsAutoScalingAutoScalingGroupDetails
        .builder
        .ifSome(launchConfigurationName)(_.launchConfigurationName(_))
        .ifSome(loadBalancerNames)(_.loadBalancerNames(_))
        .ifSome(healthCheckType)(_.healthCheckType(_))
        .ifSome(healthCheckGracePeriod)(_.healthCheckGracePeriod(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def awsCertificateManagerCertificateDetails(
      certificateAuthorityArn: Option[String] = None,
      createdAt: Option[String] = None,
      domainName: Option[String] = None,
      domainValidationOptions: Option[List[AwsCertificateManagerCertificateDomainValidationOption]] = None,
      extendedKeyUsages: Option[List[AwsCertificateManagerCertificateExtendedKeyUsage]] = None,
      failureReason: Option[String] = None,
      importedAt: Option[String] = None,
      inUseBy: Option[List[NonEmptyString]] = None,
      issuedAt: Option[String] = None,
      issuer: Option[String] = None,
      keyAlgorithm: Option[String] = None,
      keyUsages: Option[List[AwsCertificateManagerCertificateKeyUsage]] = None,
      notAfter: Option[String] = None,
      notBefore: Option[String] = None,
      options: Option[AwsCertificateManagerCertificateOptions] = None,
      renewalEligibility: Option[String] = None,
      renewalSummary: Option[AwsCertificateManagerCertificateRenewalSummary] = None,
      serial: Option[String] = None,
      signatureAlgorithm: Option[String] = None,
      status: Option[String] = None,
      subject: Option[String] = None,
      subjectAlternativeNames: Option[List[NonEmptyString]] = None,
      `type`: Option[String] = None
    ): AwsCertificateManagerCertificateDetails =
      AwsCertificateManagerCertificateDetails
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainValidationOptions)(_.domainValidationOptions(_))
        .ifSome(extendedKeyUsages)(_.extendedKeyUsages(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(importedAt)(_.importedAt(_))
        .ifSome(inUseBy)(_.inUseBy(_))
        .ifSome(issuedAt)(_.issuedAt(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(keyAlgorithm)(_.keyAlgorithm(_))
        .ifSome(keyUsages)(_.keyUsages(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(options)(_.options(_))
        .ifSome(renewalEligibility)(_.renewalEligibility(_))
        .ifSome(renewalSummary)(_.renewalSummary(_))
        .ifSome(serial)(_.serial(_))
        .ifSome(signatureAlgorithm)(_.signatureAlgorithm(_))
        .ifSome(status)(_.status(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def awsCertificateManagerCertificateDomainValidationOption(
      domainName: Option[String] = None,
      resourceRecord: Option[AwsCertificateManagerCertificateResourceRecord] = None,
      validationDomain: Option[String] = None,
      validationEmails: Option[List[NonEmptyString]] = None,
      validationMethod: Option[String] = None,
      validationStatus: Option[String] = None
    ): AwsCertificateManagerCertificateDomainValidationOption =
      AwsCertificateManagerCertificateDomainValidationOption
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(resourceRecord)(_.resourceRecord(_))
        .ifSome(validationDomain)(_.validationDomain(_))
        .ifSome(validationEmails)(_.validationEmails(_))
        .ifSome(validationMethod)(_.validationMethod(_))
        .ifSome(validationStatus)(_.validationStatus(_))
        .build

    def awsCertificateManagerCertificateExtendedKeyUsage(
      name: Option[String] = None,
      oId: Option[String] = None
    ): AwsCertificateManagerCertificateExtendedKeyUsage =
      AwsCertificateManagerCertificateExtendedKeyUsage
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(oId)(_.oId(_))
        .build

    def awsCertificateManagerCertificateKeyUsage(
      name: Option[String] = None
    ): AwsCertificateManagerCertificateKeyUsage =
      AwsCertificateManagerCertificateKeyUsage
        .builder
        .ifSome(name)(_.name(_))
        .build

    def awsCertificateManagerCertificateOptions(
      certificateTransparencyLoggingPreference: Option[String] = None
    ): AwsCertificateManagerCertificateOptions =
      AwsCertificateManagerCertificateOptions
        .builder
        .ifSome(certificateTransparencyLoggingPreference)(_.certificateTransparencyLoggingPreference(_))
        .build

    def awsCertificateManagerCertificateRenewalSummary(
      domainValidationOptions: Option[List[AwsCertificateManagerCertificateDomainValidationOption]] = None,
      renewalStatus: Option[String] = None,
      renewalStatusReason: Option[String] = None,
      updatedAt: Option[String] = None
    ): AwsCertificateManagerCertificateRenewalSummary =
      AwsCertificateManagerCertificateRenewalSummary
        .builder
        .ifSome(domainValidationOptions)(_.domainValidationOptions(_))
        .ifSome(renewalStatus)(_.renewalStatus(_))
        .ifSome(renewalStatusReason)(_.renewalStatusReason(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def awsCertificateManagerCertificateResourceRecord(
      name: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None
    ): AwsCertificateManagerCertificateResourceRecord =
      AwsCertificateManagerCertificateResourceRecord
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def awsCloudFrontDistributionCacheBehavior(
      viewerProtocolPolicy: Option[String] = None
    ): AwsCloudFrontDistributionCacheBehavior =
      AwsCloudFrontDistributionCacheBehavior
        .builder
        .ifSome(viewerProtocolPolicy)(_.viewerProtocolPolicy(_))
        .build

    def awsCloudFrontDistributionCacheBehaviors(
      items: Option[List[AwsCloudFrontDistributionCacheBehavior]] = None
    ): AwsCloudFrontDistributionCacheBehaviors =
      AwsCloudFrontDistributionCacheBehaviors
        .builder
        .ifSome(items)(_.items(_))
        .build

    def awsCloudFrontDistributionDefaultCacheBehavior(
      viewerProtocolPolicy: Option[String] = None
    ): AwsCloudFrontDistributionDefaultCacheBehavior =
      AwsCloudFrontDistributionDefaultCacheBehavior
        .builder
        .ifSome(viewerProtocolPolicy)(_.viewerProtocolPolicy(_))
        .build

    def awsCloudFrontDistributionDetails(
      cacheBehaviors: Option[AwsCloudFrontDistributionCacheBehaviors] = None,
      defaultCacheBehavior: Option[AwsCloudFrontDistributionDefaultCacheBehavior] = None,
      defaultRootObject: Option[String] = None,
      domainName: Option[String] = None,
      eTag: Option[String] = None,
      lastModifiedTime: Option[String] = None,
      logging: Option[AwsCloudFrontDistributionLogging] = None,
      origins: Option[AwsCloudFrontDistributionOrigins] = None,
      originGroups: Option[AwsCloudFrontDistributionOriginGroups] = None,
      status: Option[String] = None,
      webAclId: Option[String] = None
    ): AwsCloudFrontDistributionDetails =
      AwsCloudFrontDistributionDetails
        .builder
        .ifSome(cacheBehaviors)(_.cacheBehaviors(_))
        .ifSome(defaultCacheBehavior)(_.defaultCacheBehavior(_))
        .ifSome(defaultRootObject)(_.defaultRootObject(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(origins)(_.origins(_))
        .ifSome(originGroups)(_.originGroups(_))
        .ifSome(status)(_.status(_))
        .ifSome(webAclId)(_.webAclId(_))
        .build

    def awsCloudFrontDistributionLogging(
      bucket: Option[String] = None,
      enabled: Option[Boolean] = None,
      includeCookies: Option[Boolean] = None,
      prefix: Option[String] = None
    ): AwsCloudFrontDistributionLogging =
      AwsCloudFrontDistributionLogging
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(includeCookies)(_.includeCookies(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def awsCloudFrontDistributionOriginGroup(
      failoverCriteria: Option[AwsCloudFrontDistributionOriginGroupFailover] = None
    ): AwsCloudFrontDistributionOriginGroup =
      AwsCloudFrontDistributionOriginGroup
        .builder
        .ifSome(failoverCriteria)(_.failoverCriteria(_))
        .build

    def awsCloudFrontDistributionOriginGroupFailover(
      statusCodes: Option[AwsCloudFrontDistributionOriginGroupFailoverStatusCodes] = None
    ): AwsCloudFrontDistributionOriginGroupFailover =
      AwsCloudFrontDistributionOriginGroupFailover
        .builder
        .ifSome(statusCodes)(_.statusCodes(_))
        .build

    def awsCloudFrontDistributionOriginGroupFailoverStatusCodes(
      items: Option[List[Integer]] = None,
      quantity: Option[Int] = None
    ): AwsCloudFrontDistributionOriginGroupFailoverStatusCodes =
      AwsCloudFrontDistributionOriginGroupFailoverStatusCodes
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(quantity)(_.quantity(_))
        .build

    def awsCloudFrontDistributionOriginGroups(
      items: Option[List[AwsCloudFrontDistributionOriginGroup]] = None
    ): AwsCloudFrontDistributionOriginGroups =
      AwsCloudFrontDistributionOriginGroups
        .builder
        .ifSome(items)(_.items(_))
        .build

    def awsCloudFrontDistributionOriginItem(
      domainName: Option[String] = None,
      id: Option[String] = None,
      originPath: Option[String] = None,
      s3OriginConfig: Option[AwsCloudFrontDistributionOriginS3OriginConfig] = None
    ): AwsCloudFrontDistributionOriginItem =
      AwsCloudFrontDistributionOriginItem
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(id)(_.id(_))
        .ifSome(originPath)(_.originPath(_))
        .ifSome(s3OriginConfig)(_.s3OriginConfig(_))
        .build

    def awsCloudFrontDistributionOriginS3OriginConfig(
      originAccessIdentity: Option[String] = None
    ): AwsCloudFrontDistributionOriginS3OriginConfig =
      AwsCloudFrontDistributionOriginS3OriginConfig
        .builder
        .ifSome(originAccessIdentity)(_.originAccessIdentity(_))
        .build

    def awsCloudFrontDistributionOrigins(
      items: Option[List[AwsCloudFrontDistributionOriginItem]] = None
    ): AwsCloudFrontDistributionOrigins =
      AwsCloudFrontDistributionOrigins
        .builder
        .ifSome(items)(_.items(_))
        .build

    def awsCloudTrailTrailDetails(
      cloudWatchLogsLogGroupArn: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      hasCustomEventSelectors: Option[Boolean] = None,
      homeRegion: Option[String] = None,
      includeGlobalServiceEvents: Option[Boolean] = None,
      isMultiRegionTrail: Option[Boolean] = None,
      isOrganizationTrail: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      logFileValidationEnabled: Option[Boolean] = None,
      name: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      snsTopicArn: Option[String] = None,
      snsTopicName: Option[String] = None,
      trailArn: Option[String] = None
    ): AwsCloudTrailTrailDetails =
      AwsCloudTrailTrailDetails
        .builder
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(hasCustomEventSelectors)(_.hasCustomEventSelectors(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(includeGlobalServiceEvents)(_.includeGlobalServiceEvents(_))
        .ifSome(isMultiRegionTrail)(_.isMultiRegionTrail(_))
        .ifSome(isOrganizationTrail)(_.isOrganizationTrail(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(logFileValidationEnabled)(_.logFileValidationEnabled(_))
        .ifSome(name)(_.name(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(snsTopicName)(_.snsTopicName(_))
        .ifSome(trailArn)(_.trailArn(_))
        .build

    def awsCodeBuildProjectDetails(
      encryptionKey: Option[String] = None,
      environment: Option[AwsCodeBuildProjectEnvironment] = None,
      name: Option[String] = None,
      source: Option[AwsCodeBuildProjectSource] = None,
      serviceRole: Option[String] = None,
      vpcConfig: Option[AwsCodeBuildProjectVpcConfig] = None
    ): AwsCodeBuildProjectDetails =
      AwsCodeBuildProjectDetails
        .builder
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(name)(_.name(_))
        .ifSome(source)(_.source(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def awsCodeBuildProjectEnvironment(
      certificate: Option[String] = None,
      imagePullCredentialsType: Option[String] = None,
      registryCredential: Option[AwsCodeBuildProjectEnvironmentRegistryCredential] = None,
      `type`: Option[String] = None
    ): AwsCodeBuildProjectEnvironment =
      AwsCodeBuildProjectEnvironment
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(imagePullCredentialsType)(_.imagePullCredentialsType(_))
        .ifSome(registryCredential)(_.registryCredential(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def awsCodeBuildProjectEnvironmentRegistryCredential(
      credential: Option[String] = None,
      credentialProvider: Option[String] = None
    ): AwsCodeBuildProjectEnvironmentRegistryCredential =
      AwsCodeBuildProjectEnvironmentRegistryCredential
        .builder
        .ifSome(credential)(_.credential(_))
        .ifSome(credentialProvider)(_.credentialProvider(_))
        .build

    def awsCodeBuildProjectSource(
      `type`: Option[String] = None,
      location: Option[String] = None,
      gitCloneDepth: Option[Int] = None,
      insecureSsl: Option[Boolean] = None
    ): AwsCodeBuildProjectSource =
      AwsCodeBuildProjectSource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(location)(_.location(_))
        .ifSome(gitCloneDepth)(_.gitCloneDepth(_))
        .ifSome(insecureSsl)(_.insecureSsl(_))
        .build

    def awsCodeBuildProjectVpcConfig(
      vpcId: Option[String] = None,
      subnets: Option[List[NonEmptyString]] = None,
      securityGroupIds: Option[List[NonEmptyString]] = None
    ): AwsCodeBuildProjectVpcConfig =
      AwsCodeBuildProjectVpcConfig
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def awsCorsConfiguration(
      allowOrigins: Option[List[NonEmptyString]] = None,
      allowCredentials: Option[Boolean] = None,
      exposeHeaders: Option[List[NonEmptyString]] = None,
      maxAge: Option[Int] = None,
      allowMethods: Option[List[NonEmptyString]] = None,
      allowHeaders: Option[List[NonEmptyString]] = None
    ): AwsCorsConfiguration =
      AwsCorsConfiguration
        .builder
        .ifSome(allowOrigins)(_.allowOrigins(_))
        .ifSome(allowCredentials)(_.allowCredentials(_))
        .ifSome(exposeHeaders)(_.exposeHeaders(_))
        .ifSome(maxAge)(_.maxAge(_))
        .ifSome(allowMethods)(_.allowMethods(_))
        .ifSome(allowHeaders)(_.allowHeaders(_))
        .build

    def awsDynamoDbTableAttributeDefinition(
      attributeName: Option[String] = None,
      attributeType: Option[String] = None
    ): AwsDynamoDbTableAttributeDefinition =
      AwsDynamoDbTableAttributeDefinition
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeType)(_.attributeType(_))
        .build

    def awsDynamoDbTableBillingModeSummary(
      billingMode: Option[String] = None,
      lastUpdateToPayPerRequestDateTime: Option[String] = None
    ): AwsDynamoDbTableBillingModeSummary =
      AwsDynamoDbTableBillingModeSummary
        .builder
        .ifSome(billingMode)(_.billingMode(_))
        .ifSome(lastUpdateToPayPerRequestDateTime)(_.lastUpdateToPayPerRequestDateTime(_))
        .build

    def awsDynamoDbTableDetails(
      attributeDefinitions: Option[List[AwsDynamoDbTableAttributeDefinition]] = None,
      billingModeSummary: Option[AwsDynamoDbTableBillingModeSummary] = None,
      creationDateTime: Option[String] = None,
      globalSecondaryIndexes: Option[List[AwsDynamoDbTableGlobalSecondaryIndex]] = None,
      globalTableVersion: Option[String] = None,
      itemCount: Option[Int] = None,
      keySchema: Option[List[AwsDynamoDbTableKeySchema]] = None,
      latestStreamArn: Option[String] = None,
      latestStreamLabel: Option[String] = None,
      localSecondaryIndexes: Option[List[AwsDynamoDbTableLocalSecondaryIndex]] = None,
      provisionedThroughput: Option[AwsDynamoDbTableProvisionedThroughput] = None,
      replicas: Option[List[AwsDynamoDbTableReplica]] = None,
      restoreSummary: Option[AwsDynamoDbTableRestoreSummary] = None,
      sseDescription: Option[AwsDynamoDbTableSseDescription] = None,
      streamSpecification: Option[AwsDynamoDbTableStreamSpecification] = None,
      tableId: Option[String] = None,
      tableName: Option[String] = None,
      tableSizeBytes: Option[SizeBytes] = None,
      tableStatus: Option[String] = None
    ): AwsDynamoDbTableDetails =
      AwsDynamoDbTableDetails
        .builder
        .ifSome(attributeDefinitions)(_.attributeDefinitions(_))
        .ifSome(billingModeSummary)(_.billingModeSummary(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .ifSome(globalTableVersion)(_.globalTableVersion(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(latestStreamArn)(_.latestStreamArn(_))
        .ifSome(latestStreamLabel)(_.latestStreamLabel(_))
        .ifSome(localSecondaryIndexes)(_.localSecondaryIndexes(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .ifSome(replicas)(_.replicas(_))
        .ifSome(restoreSummary)(_.restoreSummary(_))
        .ifSome(sseDescription)(_.sseDescription(_))
        .ifSome(streamSpecification)(_.streamSpecification(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(tableSizeBytes)(_.tableSizeBytes(_))
        .ifSome(tableStatus)(_.tableStatus(_))
        .build

    def awsDynamoDbTableGlobalSecondaryIndex(
      backfilling: Option[Boolean] = None,
      indexArn: Option[String] = None,
      indexName: Option[String] = None,
      indexSizeBytes: Option[SizeBytes] = None,
      indexStatus: Option[String] = None,
      itemCount: Option[Int] = None,
      keySchema: Option[List[AwsDynamoDbTableKeySchema]] = None,
      projection: Option[AwsDynamoDbTableProjection] = None,
      provisionedThroughput: Option[AwsDynamoDbTableProvisionedThroughput] = None
    ): AwsDynamoDbTableGlobalSecondaryIndex =
      AwsDynamoDbTableGlobalSecondaryIndex
        .builder
        .ifSome(backfilling)(_.backfilling(_))
        .ifSome(indexArn)(_.indexArn(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(indexSizeBytes)(_.indexSizeBytes(_))
        .ifSome(indexStatus)(_.indexStatus(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .build

    def awsDynamoDbTableKeySchema(
      attributeName: Option[String] = None,
      keyType: Option[String] = None
    ): AwsDynamoDbTableKeySchema =
      AwsDynamoDbTableKeySchema
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(keyType)(_.keyType(_))
        .build

    def awsDynamoDbTableLocalSecondaryIndex(
      indexArn: Option[String] = None,
      indexName: Option[String] = None,
      keySchema: Option[List[AwsDynamoDbTableKeySchema]] = None,
      projection: Option[AwsDynamoDbTableProjection] = None
    ): AwsDynamoDbTableLocalSecondaryIndex =
      AwsDynamoDbTableLocalSecondaryIndex
        .builder
        .ifSome(indexArn)(_.indexArn(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .build

    def awsDynamoDbTableProjection(
      nonKeyAttributes: Option[List[NonEmptyString]] = None,
      projectionType: Option[String] = None
    ): AwsDynamoDbTableProjection =
      AwsDynamoDbTableProjection
        .builder
        .ifSome(nonKeyAttributes)(_.nonKeyAttributes(_))
        .ifSome(projectionType)(_.projectionType(_))
        .build

    def awsDynamoDbTableProvisionedThroughput(
      lastDecreaseDateTime: Option[String] = None,
      lastIncreaseDateTime: Option[String] = None,
      numberOfDecreasesToday: Option[Int] = None,
      readCapacityUnits: Option[Int] = None,
      writeCapacityUnits: Option[Int] = None
    ): AwsDynamoDbTableProvisionedThroughput =
      AwsDynamoDbTableProvisionedThroughput
        .builder
        .ifSome(lastDecreaseDateTime)(_.lastDecreaseDateTime(_))
        .ifSome(lastIncreaseDateTime)(_.lastIncreaseDateTime(_))
        .ifSome(numberOfDecreasesToday)(_.numberOfDecreasesToday(_))
        .ifSome(readCapacityUnits)(_.readCapacityUnits(_))
        .ifSome(writeCapacityUnits)(_.writeCapacityUnits(_))
        .build

    def awsDynamoDbTableProvisionedThroughputOverride(
      readCapacityUnits: Option[Int] = None
    ): AwsDynamoDbTableProvisionedThroughputOverride =
      AwsDynamoDbTableProvisionedThroughputOverride
        .builder
        .ifSome(readCapacityUnits)(_.readCapacityUnits(_))
        .build

    def awsDynamoDbTableReplica(
      globalSecondaryIndexes: Option[List[AwsDynamoDbTableReplicaGlobalSecondaryIndex]] = None,
      kmsMasterKeyId: Option[String] = None,
      provisionedThroughputOverride: Option[AwsDynamoDbTableProvisionedThroughputOverride] = None,
      regionName: Option[String] = None,
      replicaStatus: Option[String] = None,
      replicaStatusDescription: Option[String] = None
    ): AwsDynamoDbTableReplica =
      AwsDynamoDbTableReplica
        .builder
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .ifSome(kmsMasterKeyId)(_.kmsMasterKeyId(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(replicaStatus)(_.replicaStatus(_))
        .ifSome(replicaStatusDescription)(_.replicaStatusDescription(_))
        .build

    def awsDynamoDbTableReplicaGlobalSecondaryIndex(
      indexName: Option[String] = None,
      provisionedThroughputOverride: Option[AwsDynamoDbTableProvisionedThroughputOverride] = None
    ): AwsDynamoDbTableReplicaGlobalSecondaryIndex =
      AwsDynamoDbTableReplicaGlobalSecondaryIndex
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .build

    def awsDynamoDbTableRestoreSummary(
      sourceBackupArn: Option[String] = None,
      sourceTableArn: Option[String] = None,
      restoreDateTime: Option[String] = None,
      restoreInProgress: Option[Boolean] = None
    ): AwsDynamoDbTableRestoreSummary =
      AwsDynamoDbTableRestoreSummary
        .builder
        .ifSome(sourceBackupArn)(_.sourceBackupArn(_))
        .ifSome(sourceTableArn)(_.sourceTableArn(_))
        .ifSome(restoreDateTime)(_.restoreDateTime(_))
        .ifSome(restoreInProgress)(_.restoreInProgress(_))
        .build

    def awsDynamoDbTableSseDescription(
      inaccessibleEncryptionDateTime: Option[String] = None,
      status: Option[String] = None,
      sseType: Option[String] = None,
      kmsMasterKeyArn: Option[String] = None
    ): AwsDynamoDbTableSseDescription =
      AwsDynamoDbTableSseDescription
        .builder
        .ifSome(inaccessibleEncryptionDateTime)(_.inaccessibleEncryptionDateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(sseType)(_.sseType(_))
        .ifSome(kmsMasterKeyArn)(_.kmsMasterKeyArn(_))
        .build

    def awsDynamoDbTableStreamSpecification(
      streamEnabled: Option[Boolean] = None,
      streamViewType: Option[String] = None
    ): AwsDynamoDbTableStreamSpecification =
      AwsDynamoDbTableStreamSpecification
        .builder
        .ifSome(streamEnabled)(_.streamEnabled(_))
        .ifSome(streamViewType)(_.streamViewType(_))
        .build

    def awsEc2EipDetails(
      instanceId: Option[String] = None,
      publicIp: Option[String] = None,
      allocationId: Option[String] = None,
      associationId: Option[String] = None,
      domain: Option[String] = None,
      publicIpv4Pool: Option[String] = None,
      networkBorderGroup: Option[String] = None,
      networkInterfaceId: Option[String] = None,
      networkInterfaceOwnerId: Option[String] = None,
      privateIpAddress: Option[String] = None
    ): AwsEc2EipDetails =
      AwsEc2EipDetails
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(allocationId)(_.allocationId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(publicIpv4Pool)(_.publicIpv4Pool(_))
        .ifSome(networkBorderGroup)(_.networkBorderGroup(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(networkInterfaceOwnerId)(_.networkInterfaceOwnerId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def awsEc2InstanceDetails(
      `type`: Option[String] = None,
      imageId: Option[String] = None,
      ipV4Addresses: Option[List[NonEmptyString]] = None,
      ipV6Addresses: Option[List[NonEmptyString]] = None,
      keyName: Option[String] = None,
      iamInstanceProfileArn: Option[String] = None,
      vpcId: Option[String] = None,
      subnetId: Option[String] = None,
      launchedAt: Option[String] = None
    ): AwsEc2InstanceDetails =
      AwsEc2InstanceDetails
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(ipV4Addresses)(_.ipV4Addresses(_))
        .ifSome(ipV6Addresses)(_.ipV6Addresses(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(iamInstanceProfileArn)(_.iamInstanceProfileArn(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(launchedAt)(_.launchedAt(_))
        .build

    def awsEc2NetworkAclAssociation(
      networkAclAssociationId: Option[String] = None,
      networkAclId: Option[String] = None,
      subnetId: Option[String] = None
    ): AwsEc2NetworkAclAssociation =
      AwsEc2NetworkAclAssociation
        .builder
        .ifSome(networkAclAssociationId)(_.networkAclAssociationId(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def awsEc2NetworkAclDetails(
      isDefault: Option[Boolean] = None,
      networkAclId: Option[String] = None,
      ownerId: Option[String] = None,
      vpcId: Option[String] = None,
      associations: Option[List[AwsEc2NetworkAclAssociation]] = None,
      entries: Option[List[AwsEc2NetworkAclEntry]] = None
    ): AwsEc2NetworkAclDetails =
      AwsEc2NetworkAclDetails
        .builder
        .ifSome(isDefault)(_.isDefault(_))
        .ifSome(networkAclId)(_.networkAclId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(associations)(_.associations(_))
        .ifSome(entries)(_.entries(_))
        .build

    def awsEc2NetworkAclEntry(
      cidrBlock: Option[String] = None,
      egress: Option[Boolean] = None,
      icmpTypeCode: Option[IcmpTypeCode] = None,
      ipv6CidrBlock: Option[String] = None,
      portRange: Option[PortRangeFromTo] = None,
      protocol: Option[String] = None,
      ruleAction: Option[String] = None,
      ruleNumber: Option[Int] = None
    ): AwsEc2NetworkAclEntry =
      AwsEc2NetworkAclEntry
        .builder
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(egress)(_.egress(_))
        .ifSome(icmpTypeCode)(_.icmpTypeCode(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(portRange)(_.portRange(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(ruleAction)(_.ruleAction(_))
        .ifSome(ruleNumber)(_.ruleNumber(_))
        .build

    def awsEc2NetworkInterfaceAttachment(
      attachTime: Option[String] = None,
      attachmentId: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None,
      deviceIndex: Option[Int] = None,
      instanceId: Option[String] = None,
      instanceOwnerId: Option[String] = None,
      status: Option[String] = None
    ): AwsEc2NetworkInterfaceAttachment =
      AwsEc2NetworkInterfaceAttachment
        .builder
        .ifSome(attachTime)(_.attachTime(_))
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(deviceIndex)(_.deviceIndex(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceOwnerId)(_.instanceOwnerId(_))
        .ifSome(status)(_.status(_))
        .build

    def awsEc2NetworkInterfaceDetails(
      attachment: Option[AwsEc2NetworkInterfaceAttachment] = None,
      networkInterfaceId: Option[String] = None,
      securityGroups: Option[List[AwsEc2NetworkInterfaceSecurityGroup]] = None,
      sourceDestCheck: Option[Boolean] = None,
      ipV6Addresses: Option[List[AwsEc2NetworkInterfaceIpV6AddressDetail]] = None,
      privateIpAddresses: Option[List[AwsEc2NetworkInterfacePrivateIpAddressDetail]] = None,
      publicDnsName: Option[String] = None,
      publicIp: Option[String] = None
    ): AwsEc2NetworkInterfaceDetails =
      AwsEc2NetworkInterfaceDetails
        .builder
        .ifSome(attachment)(_.attachment(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(sourceDestCheck)(_.sourceDestCheck(_))
        .ifSome(ipV6Addresses)(_.ipV6Addresses(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(publicDnsName)(_.publicDnsName(_))
        .ifSome(publicIp)(_.publicIp(_))
        .build

    def awsEc2NetworkInterfaceIpV6AddressDetail(
      ipV6Address: Option[String] = None
    ): AwsEc2NetworkInterfaceIpV6AddressDetail =
      AwsEc2NetworkInterfaceIpV6AddressDetail
        .builder
        .ifSome(ipV6Address)(_.ipV6Address(_))
        .build

    def awsEc2NetworkInterfacePrivateIpAddressDetail(
      privateIpAddress: Option[String] = None,
      privateDnsName: Option[String] = None
    ): AwsEc2NetworkInterfacePrivateIpAddressDetail =
      AwsEc2NetworkInterfacePrivateIpAddressDetail
        .builder
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .build

    def awsEc2NetworkInterfaceSecurityGroup(
      groupName: Option[String] = None,
      groupId: Option[String] = None
    ): AwsEc2NetworkInterfaceSecurityGroup =
      AwsEc2NetworkInterfaceSecurityGroup
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def awsEc2SecurityGroupDetails(
      groupName: Option[String] = None,
      groupId: Option[String] = None,
      ownerId: Option[String] = None,
      vpcId: Option[String] = None,
      ipPermissions: Option[List[AwsEc2SecurityGroupIpPermission]] = None,
      ipPermissionsEgress: Option[List[AwsEc2SecurityGroupIpPermission]] = None
    ): AwsEc2SecurityGroupDetails =
      AwsEc2SecurityGroupDetails
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ipPermissions)(_.ipPermissions(_))
        .ifSome(ipPermissionsEgress)(_.ipPermissionsEgress(_))
        .build

    def awsEc2SecurityGroupIpPermission(
      ipProtocol: Option[String] = None,
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None,
      userIdGroupPairs: Option[List[AwsEc2SecurityGroupUserIdGroupPair]] = None,
      ipRanges: Option[List[AwsEc2SecurityGroupIpRange]] = None,
      ipv6Ranges: Option[List[AwsEc2SecurityGroupIpv6Range]] = None,
      prefixListIds: Option[List[AwsEc2SecurityGroupPrefixListId]] = None
    ): AwsEc2SecurityGroupIpPermission =
      AwsEc2SecurityGroupIpPermission
        .builder
        .ifSome(ipProtocol)(_.ipProtocol(_))
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(userIdGroupPairs)(_.userIdGroupPairs(_))
        .ifSome(ipRanges)(_.ipRanges(_))
        .ifSome(ipv6Ranges)(_.ipv6Ranges(_))
        .ifSome(prefixListIds)(_.prefixListIds(_))
        .build

    def awsEc2SecurityGroupIpRange(
      cidrIp: Option[String] = None
    ): AwsEc2SecurityGroupIpRange =
      AwsEc2SecurityGroupIpRange
        .builder
        .ifSome(cidrIp)(_.cidrIp(_))
        .build

    def awsEc2SecurityGroupIpv6Range(
      cidrIpv6: Option[String] = None
    ): AwsEc2SecurityGroupIpv6Range =
      AwsEc2SecurityGroupIpv6Range
        .builder
        .ifSome(cidrIpv6)(_.cidrIpv6(_))
        .build

    def awsEc2SecurityGroupPrefixListId(
      prefixListId: Option[String] = None
    ): AwsEc2SecurityGroupPrefixListId =
      AwsEc2SecurityGroupPrefixListId
        .builder
        .ifSome(prefixListId)(_.prefixListId(_))
        .build

    def awsEc2SecurityGroupUserIdGroupPair(
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      peeringStatus: Option[String] = None,
      userId: Option[String] = None,
      vpcId: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): AwsEc2SecurityGroupUserIdGroupPair =
      AwsEc2SecurityGroupUserIdGroupPair
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(peeringStatus)(_.peeringStatus(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def awsEc2SubnetDetails(
      assignIpv6AddressOnCreation: Option[Boolean] = None,
      availabilityZone: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      availableIpAddressCount: Option[Int] = None,
      cidrBlock: Option[String] = None,
      defaultForAz: Option[Boolean] = None,
      mapPublicIpOnLaunch: Option[Boolean] = None,
      ownerId: Option[String] = None,
      state: Option[String] = None,
      subnetArn: Option[String] = None,
      subnetId: Option[String] = None,
      vpcId: Option[String] = None,
      ipv6CidrBlockAssociationSet: Option[List[Ipv6CidrBlockAssociation]] = None
    ): AwsEc2SubnetDetails =
      AwsEc2SubnetDetails
        .builder
        .ifSome(assignIpv6AddressOnCreation)(_.assignIpv6AddressOnCreation(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(availableIpAddressCount)(_.availableIpAddressCount(_))
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(defaultForAz)(_.defaultForAz(_))
        .ifSome(mapPublicIpOnLaunch)(_.mapPublicIpOnLaunch(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(subnetArn)(_.subnetArn(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(ipv6CidrBlockAssociationSet)(_.ipv6CidrBlockAssociationSet(_))
        .build

    def awsEc2VolumeAttachment(
      attachTime: Option[String] = None,
      deleteOnTermination: Option[Boolean] = None,
      instanceId: Option[String] = None,
      status: Option[String] = None
    ): AwsEc2VolumeAttachment =
      AwsEc2VolumeAttachment
        .builder
        .ifSome(attachTime)(_.attachTime(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(status)(_.status(_))
        .build

    def awsEc2VolumeDetails(
      createTime: Option[String] = None,
      encrypted: Option[Boolean] = None,
      size: Option[Int] = None,
      snapshotId: Option[String] = None,
      status: Option[String] = None,
      kmsKeyId: Option[String] = None,
      attachments: Option[List[AwsEc2VolumeAttachment]] = None
    ): AwsEc2VolumeDetails =
      AwsEc2VolumeDetails
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(size)(_.size(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(status)(_.status(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(attachments)(_.attachments(_))
        .build

    def awsEc2VpcDetails(
      cidrBlockAssociationSet: Option[List[CidrBlockAssociation]] = None,
      ipv6CidrBlockAssociationSet: Option[List[Ipv6CidrBlockAssociation]] = None,
      dhcpOptionsId: Option[String] = None,
      state: Option[String] = None
    ): AwsEc2VpcDetails =
      AwsEc2VpcDetails
        .builder
        .ifSome(cidrBlockAssociationSet)(_.cidrBlockAssociationSet(_))
        .ifSome(ipv6CidrBlockAssociationSet)(_.ipv6CidrBlockAssociationSet(_))
        .ifSome(dhcpOptionsId)(_.dhcpOptionsId(_))
        .ifSome(state)(_.state(_))
        .build

    def awsElasticBeanstalkEnvironmentDetails(
      applicationName: Option[String] = None,
      cname: Option[String] = None,
      dateCreated: Option[String] = None,
      dateUpdated: Option[String] = None,
      description: Option[String] = None,
      endpointUrl: Option[String] = None,
      environmentArn: Option[String] = None,
      environmentId: Option[String] = None,
      environmentLinks: Option[List[AwsElasticBeanstalkEnvironmentEnvironmentLink]] = None,
      environmentName: Option[String] = None,
      optionSettings: Option[List[AwsElasticBeanstalkEnvironmentOptionSetting]] = None,
      platformArn: Option[String] = None,
      solutionStackName: Option[String] = None,
      status: Option[String] = None,
      tier: Option[AwsElasticBeanstalkEnvironmentTier] = None,
      versionLabel: Option[String] = None
    ): AwsElasticBeanstalkEnvironmentDetails =
      AwsElasticBeanstalkEnvironmentDetails
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(cname)(_.cname(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(description)(_.description(_))
        .ifSome(endpointUrl)(_.endpointUrl(_))
        .ifSome(environmentArn)(_.environmentArn(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentLinks)(_.environmentLinks(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(status)(_.status(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .build

    def awsElasticBeanstalkEnvironmentEnvironmentLink(
      environmentName: Option[String] = None,
      linkName: Option[String] = None
    ): AwsElasticBeanstalkEnvironmentEnvironmentLink =
      AwsElasticBeanstalkEnvironmentEnvironmentLink
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(linkName)(_.linkName(_))
        .build

    def awsElasticBeanstalkEnvironmentOptionSetting(
      namespace: Option[String] = None,
      optionName: Option[String] = None,
      resourceName: Option[String] = None,
      value: Option[String] = None
    ): AwsElasticBeanstalkEnvironmentOptionSetting =
      AwsElasticBeanstalkEnvironmentOptionSetting
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(optionName)(_.optionName(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(value)(_.value(_))
        .build

    def awsElasticBeanstalkEnvironmentTier(
      name: Option[String] = None,
      `type`: Option[String] = None,
      version: Option[String] = None
    ): AwsElasticBeanstalkEnvironmentTier =
      AwsElasticBeanstalkEnvironmentTier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(version)(_.version(_))
        .build

    def awsElasticsearchDomainDetails(
      accessPolicies: Option[String] = None,
      domainEndpointOptions: Option[AwsElasticsearchDomainDomainEndpointOptions] = None,
      domainId: Option[String] = None,
      domainName: Option[String] = None,
      endpoint: Option[String] = None,
      endpoints: Option[FieldMap] = None,
      elasticsearchVersion: Option[String] = None,
      encryptionAtRestOptions: Option[AwsElasticsearchDomainEncryptionAtRestOptions] = None,
      nodeToNodeEncryptionOptions: Option[AwsElasticsearchDomainNodeToNodeEncryptionOptions] = None,
      vPCOptions: Option[AwsElasticsearchDomainVPCOptions] = None
    ): AwsElasticsearchDomainDetails =
      AwsElasticsearchDomainDetails
        .builder
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .ifSome(domainId)(_.domainId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(elasticsearchVersion)(_.elasticsearchVersion(_))
        .ifSome(encryptionAtRestOptions)(_.encryptionAtRestOptions(_))
        .ifSome(nodeToNodeEncryptionOptions)(_.nodeToNodeEncryptionOptions(_))
        .ifSome(vPCOptions)(_.vPCOptions(_))
        .build

    def awsElasticsearchDomainDomainEndpointOptions(
      enforceHTTPS: Option[Boolean] = None,
      tLSSecurityPolicy: Option[String] = None
    ): AwsElasticsearchDomainDomainEndpointOptions =
      AwsElasticsearchDomainDomainEndpointOptions
        .builder
        .ifSome(enforceHTTPS)(_.enforceHTTPS(_))
        .ifSome(tLSSecurityPolicy)(_.tLSSecurityPolicy(_))
        .build

    def awsElasticsearchDomainEncryptionAtRestOptions(
      enabled: Option[Boolean] = None,
      kmsKeyId: Option[String] = None
    ): AwsElasticsearchDomainEncryptionAtRestOptions =
      AwsElasticsearchDomainEncryptionAtRestOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def awsElasticsearchDomainNodeToNodeEncryptionOptions(
      enabled: Option[Boolean] = None
    ): AwsElasticsearchDomainNodeToNodeEncryptionOptions =
      AwsElasticsearchDomainNodeToNodeEncryptionOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def awsElasticsearchDomainVPCOptions(
      availabilityZones: Option[List[NonEmptyString]] = None,
      securityGroupIds: Option[List[NonEmptyString]] = None,
      subnetIds: Option[List[NonEmptyString]] = None,
      vPCId: Option[String] = None
    ): AwsElasticsearchDomainVPCOptions =
      AwsElasticsearchDomainVPCOptions
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(vPCId)(_.vPCId(_))
        .build

    def awsElbAppCookieStickinessPolicy(
      cookieName: Option[String] = None,
      policyName: Option[String] = None
    ): AwsElbAppCookieStickinessPolicy =
      AwsElbAppCookieStickinessPolicy
        .builder
        .ifSome(cookieName)(_.cookieName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def awsElbLbCookieStickinessPolicy(
      cookieExpirationPeriod: Option[Long] = None,
      policyName: Option[String] = None
    ): AwsElbLbCookieStickinessPolicy =
      AwsElbLbCookieStickinessPolicy
        .builder
        .ifSome(cookieExpirationPeriod)(_.cookieExpirationPeriod(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def awsElbLoadBalancerAccessLog(
      emitInterval: Option[Int] = None,
      enabled: Option[Boolean] = None,
      s3BucketName: Option[String] = None,
      s3BucketPrefix: Option[String] = None
    ): AwsElbLoadBalancerAccessLog =
      AwsElbLoadBalancerAccessLog
        .builder
        .ifSome(emitInterval)(_.emitInterval(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3BucketPrefix)(_.s3BucketPrefix(_))
        .build

    def awsElbLoadBalancerAttributes(
      accessLog: Option[AwsElbLoadBalancerAccessLog] = None,
      connectionDraining: Option[AwsElbLoadBalancerConnectionDraining] = None,
      connectionSettings: Option[AwsElbLoadBalancerConnectionSettings] = None,
      crossZoneLoadBalancing: Option[AwsElbLoadBalancerCrossZoneLoadBalancing] = None
    ): AwsElbLoadBalancerAttributes =
      AwsElbLoadBalancerAttributes
        .builder
        .ifSome(accessLog)(_.accessLog(_))
        .ifSome(connectionDraining)(_.connectionDraining(_))
        .ifSome(connectionSettings)(_.connectionSettings(_))
        .ifSome(crossZoneLoadBalancing)(_.crossZoneLoadBalancing(_))
        .build

    def awsElbLoadBalancerBackendServerDescription(
      instancePort: Option[Int] = None,
      policyNames: Option[List[NonEmptyString]] = None
    ): AwsElbLoadBalancerBackendServerDescription =
      AwsElbLoadBalancerBackendServerDescription
        .builder
        .ifSome(instancePort)(_.instancePort(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def awsElbLoadBalancerConnectionDraining(
      enabled: Option[Boolean] = None,
      timeout: Option[Int] = None
    ): AwsElbLoadBalancerConnectionDraining =
      AwsElbLoadBalancerConnectionDraining
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def awsElbLoadBalancerConnectionSettings(
      idleTimeout: Option[Int] = None
    ): AwsElbLoadBalancerConnectionSettings =
      AwsElbLoadBalancerConnectionSettings
        .builder
        .ifSome(idleTimeout)(_.idleTimeout(_))
        .build

    def awsElbLoadBalancerCrossZoneLoadBalancing(
      enabled: Option[Boolean] = None
    ): AwsElbLoadBalancerCrossZoneLoadBalancing =
      AwsElbLoadBalancerCrossZoneLoadBalancing
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def awsElbLoadBalancerDetails(
      availabilityZones: Option[List[NonEmptyString]] = None,
      backendServerDescriptions: Option[List[AwsElbLoadBalancerBackendServerDescription]] = None,
      canonicalHostedZoneName: Option[String] = None,
      canonicalHostedZoneNameID: Option[String] = None,
      createdTime: Option[String] = None,
      dnsName: Option[String] = None,
      healthCheck: Option[AwsElbLoadBalancerHealthCheck] = None,
      instances: Option[List[AwsElbLoadBalancerInstance]] = None,
      listenerDescriptions: Option[List[AwsElbLoadBalancerListenerDescription]] = None,
      loadBalancerAttributes: Option[AwsElbLoadBalancerAttributes] = None,
      loadBalancerName: Option[String] = None,
      policies: Option[AwsElbLoadBalancerPolicies] = None,
      scheme: Option[String] = None,
      securityGroups: Option[List[NonEmptyString]] = None,
      sourceSecurityGroup: Option[AwsElbLoadBalancerSourceSecurityGroup] = None,
      subnets: Option[List[NonEmptyString]] = None,
      vpcId: Option[String] = None
    ): AwsElbLoadBalancerDetails =
      AwsElbLoadBalancerDetails
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(backendServerDescriptions)(_.backendServerDescriptions(_))
        .ifSome(canonicalHostedZoneName)(_.canonicalHostedZoneName(_))
        .ifSome(canonicalHostedZoneNameID)(_.canonicalHostedZoneNameID(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(listenerDescriptions)(_.listenerDescriptions(_))
        .ifSome(loadBalancerAttributes)(_.loadBalancerAttributes(_))
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(scheme)(_.scheme(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(sourceSecurityGroup)(_.sourceSecurityGroup(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def awsElbLoadBalancerHealthCheck(
      healthyThreshold: Option[Int] = None,
      interval: Option[Int] = None,
      target: Option[String] = None,
      timeout: Option[Int] = None,
      unhealthyThreshold: Option[Int] = None
    ): AwsElbLoadBalancerHealthCheck =
      AwsElbLoadBalancerHealthCheck
        .builder
        .ifSome(healthyThreshold)(_.healthyThreshold(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(target)(_.target(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(unhealthyThreshold)(_.unhealthyThreshold(_))
        .build

    def awsElbLoadBalancerInstance(
      instanceId: Option[String] = None
    ): AwsElbLoadBalancerInstance =
      AwsElbLoadBalancerInstance
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def awsElbLoadBalancerListener(
      instancePort: Option[Int] = None,
      instanceProtocol: Option[String] = None,
      loadBalancerPort: Option[Int] = None,
      protocol: Option[String] = None,
      sslCertificateId: Option[String] = None
    ): AwsElbLoadBalancerListener =
      AwsElbLoadBalancerListener
        .builder
        .ifSome(instancePort)(_.instancePort(_))
        .ifSome(instanceProtocol)(_.instanceProtocol(_))
        .ifSome(loadBalancerPort)(_.loadBalancerPort(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(sslCertificateId)(_.sslCertificateId(_))
        .build

    def awsElbLoadBalancerListenerDescription(
      listener: Option[AwsElbLoadBalancerListener] = None,
      policyNames: Option[List[NonEmptyString]] = None
    ): AwsElbLoadBalancerListenerDescription =
      AwsElbLoadBalancerListenerDescription
        .builder
        .ifSome(listener)(_.listener(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def awsElbLoadBalancerPolicies(
      appCookieStickinessPolicies: Option[List[AwsElbAppCookieStickinessPolicy]] = None,
      lbCookieStickinessPolicies: Option[List[AwsElbLbCookieStickinessPolicy]] = None,
      otherPolicies: Option[List[NonEmptyString]] = None
    ): AwsElbLoadBalancerPolicies =
      AwsElbLoadBalancerPolicies
        .builder
        .ifSome(appCookieStickinessPolicies)(_.appCookieStickinessPolicies(_))
        .ifSome(lbCookieStickinessPolicies)(_.lbCookieStickinessPolicies(_))
        .ifSome(otherPolicies)(_.otherPolicies(_))
        .build

    def awsElbLoadBalancerSourceSecurityGroup(
      groupName: Option[String] = None,
      ownerAlias: Option[String] = None
    ): AwsElbLoadBalancerSourceSecurityGroup =
      AwsElbLoadBalancerSourceSecurityGroup
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(ownerAlias)(_.ownerAlias(_))
        .build

    def awsElbv2LoadBalancerDetails(
      availabilityZones: Option[List[AvailabilityZone]] = None,
      canonicalHostedZoneId: Option[String] = None,
      createdTime: Option[String] = None,
      dNSName: Option[String] = None,
      ipAddressType: Option[String] = None,
      scheme: Option[String] = None,
      securityGroups: Option[List[NonEmptyString]] = None,
      state: Option[LoadBalancerState] = None,
      `type`: Option[String] = None,
      vpcId: Option[String] = None
    ): AwsElbv2LoadBalancerDetails =
      AwsElbv2LoadBalancerDetails
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(canonicalHostedZoneId)(_.canonicalHostedZoneId(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(dNSName)(_.dNSName(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(scheme)(_.scheme(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(state)(_.state(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def awsIamAccessKeyDetails(
      userName: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[String] = None,
      principalId: Option[String] = None,
      principalType: Option[String] = None,
      principalName: Option[String] = None,
      accountId: Option[String] = None,
      accessKeyId: Option[String] = None,
      sessionContext: Option[AwsIamAccessKeySessionContext] = None
    ): AwsIamAccessKeyDetails =
      AwsIamAccessKeyDetails
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(principalType)(_.principalType(_))
        .ifSome(principalName)(_.principalName(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(sessionContext)(_.sessionContext(_))
        .build

    def awsIamAccessKeySessionContext(
      attributes: Option[AwsIamAccessKeySessionContextAttributes] = None,
      sessionIssuer: Option[AwsIamAccessKeySessionContextSessionIssuer] = None
    ): AwsIamAccessKeySessionContext =
      AwsIamAccessKeySessionContext
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(sessionIssuer)(_.sessionIssuer(_))
        .build

    def awsIamAccessKeySessionContextAttributes(
      mfaAuthenticated: Option[Boolean] = None,
      creationDate: Option[String] = None
    ): AwsIamAccessKeySessionContextAttributes =
      AwsIamAccessKeySessionContextAttributes
        .builder
        .ifSome(mfaAuthenticated)(_.mfaAuthenticated(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def awsIamAccessKeySessionContextSessionIssuer(
      `type`: Option[String] = None,
      principalId: Option[String] = None,
      arn: Option[String] = None,
      accountId: Option[String] = None,
      userName: Option[String] = None
    ): AwsIamAccessKeySessionContextSessionIssuer =
      AwsIamAccessKeySessionContextSessionIssuer
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def awsIamAttachedManagedPolicy(
      policyName: Option[String] = None,
      policyArn: Option[String] = None
    ): AwsIamAttachedManagedPolicy =
      AwsIamAttachedManagedPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def awsIamGroupDetails(
      attachedManagedPolicies: Option[List[AwsIamAttachedManagedPolicy]] = None,
      createDate: Option[String] = None,
      groupId: Option[String] = None,
      groupName: Option[String] = None,
      groupPolicyList: Option[List[AwsIamGroupPolicy]] = None,
      path: Option[String] = None
    ): AwsIamGroupDetails =
      AwsIamGroupDetails
        .builder
        .ifSome(attachedManagedPolicies)(_.attachedManagedPolicies(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupPolicyList)(_.groupPolicyList(_))
        .ifSome(path)(_.path(_))
        .build

    def awsIamGroupPolicy(
      policyName: Option[String] = None
    ): AwsIamGroupPolicy =
      AwsIamGroupPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .build

    def awsIamInstanceProfile(
      arn: Option[String] = None,
      createDate: Option[String] = None,
      instanceProfileId: Option[String] = None,
      instanceProfileName: Option[String] = None,
      path: Option[String] = None,
      roles: Option[List[AwsIamInstanceProfileRole]] = None
    ): AwsIamInstanceProfile =
      AwsIamInstanceProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(instanceProfileId)(_.instanceProfileId(_))
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(path)(_.path(_))
        .ifSome(roles)(_.roles(_))
        .build

    def awsIamInstanceProfileRole(
      arn: Option[String] = None,
      assumeRolePolicyDocument: Option[String] = None,
      createDate: Option[String] = None,
      path: Option[String] = None,
      roleId: Option[String] = None,
      roleName: Option[String] = None
    ): AwsIamInstanceProfileRole =
      AwsIamInstanceProfileRole
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(assumeRolePolicyDocument)(_.assumeRolePolicyDocument(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(path)(_.path(_))
        .ifSome(roleId)(_.roleId(_))
        .ifSome(roleName)(_.roleName(_))
        .build

    def awsIamPermissionsBoundary(
      permissionsBoundaryArn: Option[String] = None,
      permissionsBoundaryType: Option[String] = None
    ): AwsIamPermissionsBoundary =
      AwsIamPermissionsBoundary
        .builder
        .ifSome(permissionsBoundaryArn)(_.permissionsBoundaryArn(_))
        .ifSome(permissionsBoundaryType)(_.permissionsBoundaryType(_))
        .build

    def awsIamPolicyDetails(
      attachmentCount: Option[Int] = None,
      createDate: Option[String] = None,
      defaultVersionId: Option[String] = None,
      description: Option[String] = None,
      isAttachable: Option[Boolean] = None,
      path: Option[String] = None,
      permissionsBoundaryUsageCount: Option[Int] = None,
      policyId: Option[String] = None,
      policyName: Option[String] = None,
      policyVersionList: Option[List[AwsIamPolicyVersion]] = None,
      updateDate: Option[String] = None
    ): AwsIamPolicyDetails =
      AwsIamPolicyDetails
        .builder
        .ifSome(attachmentCount)(_.attachmentCount(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(description)(_.description(_))
        .ifSome(isAttachable)(_.isAttachable(_))
        .ifSome(path)(_.path(_))
        .ifSome(permissionsBoundaryUsageCount)(_.permissionsBoundaryUsageCount(_))
        .ifSome(policyId)(_.policyId(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyVersionList)(_.policyVersionList(_))
        .ifSome(updateDate)(_.updateDate(_))
        .build

    def awsIamPolicyVersion(
      versionId: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None,
      createDate: Option[String] = None
    ): AwsIamPolicyVersion =
      AwsIamPolicyVersion
        .builder
        .ifSome(versionId)(_.versionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def awsIamRoleDetails(
      assumeRolePolicyDocument: Option[String] = None,
      attachedManagedPolicies: Option[List[AwsIamAttachedManagedPolicy]] = None,
      createDate: Option[String] = None,
      instanceProfileList: Option[List[AwsIamInstanceProfile]] = None,
      permissionsBoundary: Option[AwsIamPermissionsBoundary] = None,
      roleId: Option[String] = None,
      roleName: Option[String] = None,
      rolePolicyList: Option[List[AwsIamRolePolicy]] = None,
      maxSessionDuration: Option[Int] = None,
      path: Option[String] = None
    ): AwsIamRoleDetails =
      AwsIamRoleDetails
        .builder
        .ifSome(assumeRolePolicyDocument)(_.assumeRolePolicyDocument(_))
        .ifSome(attachedManagedPolicies)(_.attachedManagedPolicies(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(instanceProfileList)(_.instanceProfileList(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(roleId)(_.roleId(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(rolePolicyList)(_.rolePolicyList(_))
        .ifSome(maxSessionDuration)(_.maxSessionDuration(_))
        .ifSome(path)(_.path(_))
        .build

    def awsIamRolePolicy(
      policyName: Option[String] = None
    ): AwsIamRolePolicy =
      AwsIamRolePolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .build

    def awsIamUserDetails(
      attachedManagedPolicies: Option[List[AwsIamAttachedManagedPolicy]] = None,
      createDate: Option[String] = None,
      groupList: Option[List[NonEmptyString]] = None,
      path: Option[String] = None,
      permissionsBoundary: Option[AwsIamPermissionsBoundary] = None,
      userId: Option[String] = None,
      userName: Option[String] = None,
      userPolicyList: Option[List[AwsIamUserPolicy]] = None
    ): AwsIamUserDetails =
      AwsIamUserDetails
        .builder
        .ifSome(attachedManagedPolicies)(_.attachedManagedPolicies(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(groupList)(_.groupList(_))
        .ifSome(path)(_.path(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(userPolicyList)(_.userPolicyList(_))
        .build

    def awsIamUserPolicy(
      policyName: Option[String] = None
    ): AwsIamUserPolicy =
      AwsIamUserPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .build

    def awsKmsKeyDetails(
      aWSAccountId: Option[String] = None,
      creationDate: Option[Double] = None,
      keyId: Option[String] = None,
      keyManager: Option[String] = None,
      keyState: Option[String] = None,
      origin: Option[String] = None,
      description: Option[String] = None
    ): AwsKmsKeyDetails =
      AwsKmsKeyDetails
        .builder
        .ifSome(aWSAccountId)(_.aWSAccountId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(keyManager)(_.keyManager(_))
        .ifSome(keyState)(_.keyState(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(description)(_.description(_))
        .build

    def awsLambdaFunctionCode(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None,
      s3ObjectVersion: Option[String] = None,
      zipFile: Option[String] = None
    ): AwsLambdaFunctionCode =
      AwsLambdaFunctionCode
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(s3ObjectVersion)(_.s3ObjectVersion(_))
        .ifSome(zipFile)(_.zipFile(_))
        .build

    def awsLambdaFunctionDeadLetterConfig(
      targetArn: Option[String] = None
    ): AwsLambdaFunctionDeadLetterConfig =
      AwsLambdaFunctionDeadLetterConfig
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .build

    def awsLambdaFunctionDetails(
      code: Option[AwsLambdaFunctionCode] = None,
      codeSha256: Option[String] = None,
      deadLetterConfig: Option[AwsLambdaFunctionDeadLetterConfig] = None,
      environment: Option[AwsLambdaFunctionEnvironment] = None,
      functionName: Option[String] = None,
      handler: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      lastModified: Option[String] = None,
      layers: Option[List[AwsLambdaFunctionLayer]] = None,
      masterArn: Option[String] = None,
      memorySize: Option[Int] = None,
      revisionId: Option[String] = None,
      role: Option[String] = None,
      runtime: Option[String] = None,
      timeout: Option[Int] = None,
      tracingConfig: Option[AwsLambdaFunctionTracingConfig] = None,
      vpcConfig: Option[AwsLambdaFunctionVpcConfig] = None,
      version: Option[String] = None
    ): AwsLambdaFunctionDetails =
      AwsLambdaFunctionDetails
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(codeSha256)(_.codeSha256(_))
        .ifSome(deadLetterConfig)(_.deadLetterConfig(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(functionName)(_.functionName(_))
        .ifSome(handler)(_.handler(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(layers)(_.layers(_))
        .ifSome(masterArn)(_.masterArn(_))
        .ifSome(memorySize)(_.memorySize(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(role)(_.role(_))
        .ifSome(runtime)(_.runtime(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(tracingConfig)(_.tracingConfig(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(version)(_.version(_))
        .build

    def awsLambdaFunctionEnvironment(
      variables: Option[FieldMap] = None,
      error: Option[AwsLambdaFunctionEnvironmentError] = None
    ): AwsLambdaFunctionEnvironment =
      AwsLambdaFunctionEnvironment
        .builder
        .ifSome(variables)(_.variables(_))
        .ifSome(error)(_.error(_))
        .build

    def awsLambdaFunctionEnvironmentError(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): AwsLambdaFunctionEnvironmentError =
      AwsLambdaFunctionEnvironmentError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def awsLambdaFunctionLayer(
      arn: Option[String] = None,
      codeSize: Option[Int] = None
    ): AwsLambdaFunctionLayer =
      AwsLambdaFunctionLayer
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(codeSize)(_.codeSize(_))
        .build

    def awsLambdaFunctionTracingConfig(
      mode: Option[String] = None
    ): AwsLambdaFunctionTracingConfig =
      AwsLambdaFunctionTracingConfig
        .builder
        .ifSome(mode)(_.mode(_))
        .build

    def awsLambdaFunctionVpcConfig(
      securityGroupIds: Option[List[NonEmptyString]] = None,
      subnetIds: Option[List[NonEmptyString]] = None,
      vpcId: Option[String] = None
    ): AwsLambdaFunctionVpcConfig =
      AwsLambdaFunctionVpcConfig
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def awsLambdaLayerVersionDetails(
      version: Option[AwsLambdaLayerVersionNumber] = None,
      compatibleRuntimes: Option[List[NonEmptyString]] = None,
      createdDate: Option[String] = None
    ): AwsLambdaLayerVersionDetails =
      AwsLambdaLayerVersionDetails
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(compatibleRuntimes)(_.compatibleRuntimes(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def awsRdsDbClusterAssociatedRole(
      roleArn: Option[String] = None,
      status: Option[String] = None
    ): AwsRdsDbClusterAssociatedRole =
      AwsRdsDbClusterAssociatedRole
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRdsDbClusterDetails(
      allocatedStorage: Option[Int] = None,
      availabilityZones: Option[List[NonEmptyString]] = None,
      backupRetentionPeriod: Option[Int] = None,
      databaseName: Option[String] = None,
      status: Option[String] = None,
      endpoint: Option[String] = None,
      readerEndpoint: Option[String] = None,
      customEndpoints: Option[List[NonEmptyString]] = None,
      multiAz: Option[Boolean] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      port: Option[Int] = None,
      masterUsername: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      readReplicaIdentifiers: Option[List[NonEmptyString]] = None,
      vpcSecurityGroups: Option[List[AwsRdsDbInstanceVpcSecurityGroup]] = None,
      hostedZoneId: Option[String] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      dbClusterResourceId: Option[String] = None,
      associatedRoles: Option[List[AwsRdsDbClusterAssociatedRole]] = None,
      clusterCreateTime: Option[String] = None,
      enabledCloudWatchLogsExports: Option[List[NonEmptyString]] = None,
      engineMode: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      httpEndpointEnabled: Option[Boolean] = None,
      activityStreamStatus: Option[String] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      crossAccountClone: Option[Boolean] = None,
      domainMemberships: Option[List[AwsRdsDbDomainMembership]] = None,
      dbClusterParameterGroup: Option[String] = None,
      dbSubnetGroup: Option[String] = None,
      dbClusterOptionGroupMemberships: Option[List[AwsRdsDbClusterOptionGroupMembership]] = None,
      dbClusterIdentifier: Option[String] = None,
      dbClusterMembers: Option[List[AwsRdsDbClusterMember]] = None,
      iamDatabaseAuthenticationEnabled: Option[Boolean] = None
    ): AwsRdsDbClusterDetails =
      AwsRdsDbClusterDetails
        .builder
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(status)(_.status(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(readerEndpoint)(_.readerEndpoint(_))
        .ifSome(customEndpoints)(_.customEndpoints(_))
        .ifSome(multiAz)(_.multiAz(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(port)(_.port(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(readReplicaIdentifiers)(_.readReplicaIdentifiers(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dbClusterResourceId)(_.dbClusterResourceId(_))
        .ifSome(associatedRoles)(_.associatedRoles(_))
        .ifSome(clusterCreateTime)(_.clusterCreateTime(_))
        .ifSome(enabledCloudWatchLogsExports)(_.enabledCloudWatchLogsExports(_))
        .ifSome(engineMode)(_.engineMode(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(httpEndpointEnabled)(_.httpEndpointEnabled(_))
        .ifSome(activityStreamStatus)(_.activityStreamStatus(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(crossAccountClone)(_.crossAccountClone(_))
        .ifSome(domainMemberships)(_.domainMemberships(_))
        .ifSome(dbClusterParameterGroup)(_.dbClusterParameterGroup(_))
        .ifSome(dbSubnetGroup)(_.dbSubnetGroup(_))
        .ifSome(dbClusterOptionGroupMemberships)(_.dbClusterOptionGroupMemberships(_))
        .ifSome(dbClusterIdentifier)(_.dbClusterIdentifier(_))
        .ifSome(dbClusterMembers)(_.dbClusterMembers(_))
        .ifSome(iamDatabaseAuthenticationEnabled)(_.iamDatabaseAuthenticationEnabled(_))
        .build

    def awsRdsDbClusterMember(
      isClusterWriter: Option[Boolean] = None,
      promotionTier: Option[Int] = None,
      dbInstanceIdentifier: Option[String] = None,
      dbClusterParameterGroupStatus: Option[String] = None
    ): AwsRdsDbClusterMember =
      AwsRdsDbClusterMember
        .builder
        .ifSome(isClusterWriter)(_.isClusterWriter(_))
        .ifSome(promotionTier)(_.promotionTier(_))
        .ifSome(dbInstanceIdentifier)(_.dbInstanceIdentifier(_))
        .ifSome(dbClusterParameterGroupStatus)(_.dbClusterParameterGroupStatus(_))
        .build

    def awsRdsDbClusterOptionGroupMembership(
      dbClusterOptionGroupName: Option[String] = None,
      status: Option[String] = None
    ): AwsRdsDbClusterOptionGroupMembership =
      AwsRdsDbClusterOptionGroupMembership
        .builder
        .ifSome(dbClusterOptionGroupName)(_.dbClusterOptionGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRdsDbClusterSnapshotDetails(
      availabilityZones: Option[List[NonEmptyString]] = None,
      snapshotCreateTime: Option[String] = None,
      engine: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      status: Option[String] = None,
      port: Option[Int] = None,
      vpcId: Option[String] = None,
      clusterCreateTime: Option[String] = None,
      masterUsername: Option[String] = None,
      engineVersion: Option[String] = None,
      licenseModel: Option[String] = None,
      snapshotType: Option[String] = None,
      percentProgress: Option[Int] = None,
      storageEncrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      dbClusterIdentifier: Option[String] = None,
      dbClusterSnapshotIdentifier: Option[String] = None,
      iamDatabaseAuthenticationEnabled: Option[Boolean] = None
    ): AwsRdsDbClusterSnapshotDetails =
      AwsRdsDbClusterSnapshotDetails
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(snapshotCreateTime)(_.snapshotCreateTime(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(status)(_.status(_))
        .ifSome(port)(_.port(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(clusterCreateTime)(_.clusterCreateTime(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(percentProgress)(_.percentProgress(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dbClusterIdentifier)(_.dbClusterIdentifier(_))
        .ifSome(dbClusterSnapshotIdentifier)(_.dbClusterSnapshotIdentifier(_))
        .ifSome(iamDatabaseAuthenticationEnabled)(_.iamDatabaseAuthenticationEnabled(_))
        .build

    def awsRdsDbDomainMembership(
      domain: Option[String] = None,
      status: Option[String] = None,
      fqdn: Option[String] = None,
      iamRoleName: Option[String] = None
    ): AwsRdsDbDomainMembership =
      AwsRdsDbDomainMembership
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(status)(_.status(_))
        .ifSome(fqdn)(_.fqdn(_))
        .ifSome(iamRoleName)(_.iamRoleName(_))
        .build

    def awsRdsDbInstanceAssociatedRole(
      roleArn: Option[String] = None,
      featureName: Option[String] = None,
      status: Option[String] = None
    ): AwsRdsDbInstanceAssociatedRole =
      AwsRdsDbInstanceAssociatedRole
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(featureName)(_.featureName(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRdsDbInstanceDetails(
      associatedRoles: Option[List[AwsRdsDbInstanceAssociatedRole]] = None,
      cACertificateIdentifier: Option[String] = None,
      dBClusterIdentifier: Option[String] = None,
      dBInstanceIdentifier: Option[String] = None,
      dBInstanceClass: Option[String] = None,
      dbInstancePort: Option[Int] = None,
      dbiResourceId: Option[String] = None,
      dBName: Option[String] = None,
      deletionProtection: Option[Boolean] = None,
      endpoint: Option[AwsRdsDbInstanceEndpoint] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      iAMDatabaseAuthenticationEnabled: Option[Boolean] = None,
      instanceCreateTime: Option[String] = None,
      kmsKeyId: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      storageEncrypted: Option[Boolean] = None,
      tdeCredentialArn: Option[String] = None,
      vpcSecurityGroups: Option[List[AwsRdsDbInstanceVpcSecurityGroup]] = None,
      multiAz: Option[Boolean] = None,
      enhancedMonitoringResourceArn: Option[String] = None,
      dbInstanceStatus: Option[String] = None,
      masterUsername: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      preferredBackupWindow: Option[String] = None,
      backupRetentionPeriod: Option[Int] = None,
      dbSecurityGroups: Option[List[NonEmptyString]] = None,
      dbParameterGroups: Option[List[AwsRdsDbParameterGroup]] = None,
      availabilityZone: Option[String] = None,
      dbSubnetGroup: Option[AwsRdsDbSubnetGroup] = None,
      preferredMaintenanceWindow: Option[String] = None,
      pendingModifiedValues: Option[AwsRdsDbPendingModifiedValues] = None,
      latestRestorableTime: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      readReplicaSourceDBInstanceIdentifier: Option[String] = None,
      readReplicaDBInstanceIdentifiers: Option[List[NonEmptyString]] = None,
      readReplicaDBClusterIdentifiers: Option[List[NonEmptyString]] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupMemberships: Option[List[AwsRdsDbOptionGroupMembership]] = None,
      characterSetName: Option[String] = None,
      secondaryAvailabilityZone: Option[String] = None,
      statusInfos: Option[List[AwsRdsDbStatusInfo]] = None,
      storageType: Option[String] = None,
      domainMemberships: Option[List[AwsRdsDbDomainMembership]] = None,
      copyTagsToSnapshot: Option[Boolean] = None,
      monitoringInterval: Option[Int] = None,
      monitoringRoleArn: Option[String] = None,
      promotionTier: Option[Int] = None,
      timezone: Option[String] = None,
      performanceInsightsEnabled: Option[Boolean] = None,
      performanceInsightsKmsKeyId: Option[String] = None,
      performanceInsightsRetentionPeriod: Option[Int] = None,
      enabledCloudWatchLogsExports: Option[List[NonEmptyString]] = None,
      processorFeatures: Option[List[AwsRdsDbProcessorFeature]] = None,
      listenerEndpoint: Option[AwsRdsDbInstanceEndpoint] = None,
      maxAllocatedStorage: Option[Int] = None
    ): AwsRdsDbInstanceDetails =
      AwsRdsDbInstanceDetails
        .builder
        .ifSome(associatedRoles)(_.associatedRoles(_))
        .ifSome(cACertificateIdentifier)(_.cACertificateIdentifier(_))
        .ifSome(dBClusterIdentifier)(_.dBClusterIdentifier(_))
        .ifSome(dBInstanceIdentifier)(_.dBInstanceIdentifier(_))
        .ifSome(dBInstanceClass)(_.dBInstanceClass(_))
        .ifSome(dbInstancePort)(_.dbInstancePort(_))
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
        .ifSome(dBName)(_.dBName(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(iAMDatabaseAuthenticationEnabled)(_.iAMDatabaseAuthenticationEnabled(_))
        .ifSome(instanceCreateTime)(_.instanceCreateTime(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(storageEncrypted)(_.storageEncrypted(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .ifSome(multiAz)(_.multiAz(_))
        .ifSome(enhancedMonitoringResourceArn)(_.enhancedMonitoringResourceArn(_))
        .ifSome(dbInstanceStatus)(_.dbInstanceStatus(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(dbSecurityGroups)(_.dbSecurityGroups(_))
        .ifSome(dbParameterGroups)(_.dbParameterGroups(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(dbSubnetGroup)(_.dbSubnetGroup(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(latestRestorableTime)(_.latestRestorableTime(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(readReplicaSourceDBInstanceIdentifier)(_.readReplicaSourceDBInstanceIdentifier(_))
        .ifSome(readReplicaDBInstanceIdentifiers)(_.readReplicaDBInstanceIdentifiers(_))
        .ifSome(readReplicaDBClusterIdentifiers)(_.readReplicaDBClusterIdentifiers(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupMemberships)(_.optionGroupMemberships(_))
        .ifSome(characterSetName)(_.characterSetName(_))
        .ifSome(secondaryAvailabilityZone)(_.secondaryAvailabilityZone(_))
        .ifSome(statusInfos)(_.statusInfos(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(domainMemberships)(_.domainMemberships(_))
        .ifSome(copyTagsToSnapshot)(_.copyTagsToSnapshot(_))
        .ifSome(monitoringInterval)(_.monitoringInterval(_))
        .ifSome(monitoringRoleArn)(_.monitoringRoleArn(_))
        .ifSome(promotionTier)(_.promotionTier(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(performanceInsightsEnabled)(_.performanceInsightsEnabled(_))
        .ifSome(performanceInsightsKmsKeyId)(_.performanceInsightsKmsKeyId(_))
        .ifSome(performanceInsightsRetentionPeriod)(_.performanceInsightsRetentionPeriod(_))
        .ifSome(enabledCloudWatchLogsExports)(_.enabledCloudWatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(listenerEndpoint)(_.listenerEndpoint(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
        .build

    def awsRdsDbInstanceEndpoint(
      address: Option[String] = None,
      port: Option[Int] = None,
      hostedZoneId: Option[String] = None
    ): AwsRdsDbInstanceEndpoint =
      AwsRdsDbInstanceEndpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(port)(_.port(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def awsRdsDbInstanceVpcSecurityGroup(
      vpcSecurityGroupId: Option[String] = None,
      status: Option[String] = None
    ): AwsRdsDbInstanceVpcSecurityGroup =
      AwsRdsDbInstanceVpcSecurityGroup
        .builder
        .ifSome(vpcSecurityGroupId)(_.vpcSecurityGroupId(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRdsDbOptionGroupMembership(
      optionGroupName: Option[String] = None,
      status: Option[String] = None
    ): AwsRdsDbOptionGroupMembership =
      AwsRdsDbOptionGroupMembership
        .builder
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRdsDbParameterGroup(
      dbParameterGroupName: Option[String] = None,
      parameterApplyStatus: Option[String] = None
    ): AwsRdsDbParameterGroup =
      AwsRdsDbParameterGroup
        .builder
        .ifSome(dbParameterGroupName)(_.dbParameterGroupName(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .build

    def awsRdsDbPendingModifiedValues(
      dbInstanceClass: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      masterUserPassword: Option[String] = None,
      port: Option[Int] = None,
      backupRetentionPeriod: Option[Int] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      licenseModel: Option[String] = None,
      iops: Option[Int] = None,
      dbInstanceIdentifier: Option[String] = None,
      storageType: Option[String] = None,
      caCertificateIdentifier: Option[String] = None,
      dbSubnetGroupName: Option[String] = None,
      pendingCloudWatchLogsExports: Option[AwsRdsPendingCloudWatchLogsExports] = None,
      processorFeatures: Option[List[AwsRdsDbProcessorFeature]] = None
    ): AwsRdsDbPendingModifiedValues =
      AwsRdsDbPendingModifiedValues
        .builder
        .ifSome(dbInstanceClass)(_.dbInstanceClass(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(port)(_.port(_))
        .ifSome(backupRetentionPeriod)(_.backupRetentionPeriod(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(dbInstanceIdentifier)(_.dbInstanceIdentifier(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(caCertificateIdentifier)(_.caCertificateIdentifier(_))
        .ifSome(dbSubnetGroupName)(_.dbSubnetGroupName(_))
        .ifSome(pendingCloudWatchLogsExports)(_.pendingCloudWatchLogsExports(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .build

    def awsRdsDbProcessorFeature(
      name: Option[String] = None,
      value: Option[String] = None
    ): AwsRdsDbProcessorFeature =
      AwsRdsDbProcessorFeature
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def awsRdsDbSnapshotDetails(
      dbSnapshotIdentifier: Option[String] = None,
      dbInstanceIdentifier: Option[String] = None,
      snapshotCreateTime: Option[String] = None,
      engine: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      status: Option[String] = None,
      port: Option[Int] = None,
      availabilityZone: Option[String] = None,
      vpcId: Option[String] = None,
      instanceCreateTime: Option[String] = None,
      masterUsername: Option[String] = None,
      engineVersion: Option[String] = None,
      licenseModel: Option[String] = None,
      snapshotType: Option[String] = None,
      iops: Option[Int] = None,
      optionGroupName: Option[String] = None,
      percentProgress: Option[Int] = None,
      sourceRegion: Option[String] = None,
      sourceDbSnapshotIdentifier: Option[String] = None,
      storageType: Option[String] = None,
      tdeCredentialArn: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      timezone: Option[String] = None,
      iamDatabaseAuthenticationEnabled: Option[Boolean] = None,
      processorFeatures: Option[List[AwsRdsDbProcessorFeature]] = None,
      dbiResourceId: Option[String] = None
    ): AwsRdsDbSnapshotDetails =
      AwsRdsDbSnapshotDetails
        .builder
        .ifSome(dbSnapshotIdentifier)(_.dbSnapshotIdentifier(_))
        .ifSome(dbInstanceIdentifier)(_.dbInstanceIdentifier(_))
        .ifSome(snapshotCreateTime)(_.snapshotCreateTime(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(status)(_.status(_))
        .ifSome(port)(_.port(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(instanceCreateTime)(_.instanceCreateTime(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(snapshotType)(_.snapshotType(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(optionGroupName)(_.optionGroupName(_))
        .ifSome(percentProgress)(_.percentProgress(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(sourceDbSnapshotIdentifier)(_.sourceDbSnapshotIdentifier(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(tdeCredentialArn)(_.tdeCredentialArn(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(iamDatabaseAuthenticationEnabled)(_.iamDatabaseAuthenticationEnabled(_))
        .ifSome(processorFeatures)(_.processorFeatures(_))
        .ifSome(dbiResourceId)(_.dbiResourceId(_))
        .build

    def awsRdsDbStatusInfo(
      statusType: Option[String] = None,
      normal: Option[Boolean] = None,
      status: Option[String] = None,
      message: Option[String] = None
    ): AwsRdsDbStatusInfo =
      AwsRdsDbStatusInfo
        .builder
        .ifSome(statusType)(_.statusType(_))
        .ifSome(normal)(_.normal(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .build

    def awsRdsDbSubnetGroup(
      dbSubnetGroupName: Option[String] = None,
      dbSubnetGroupDescription: Option[String] = None,
      vpcId: Option[String] = None,
      subnetGroupStatus: Option[String] = None,
      subnets: Option[List[AwsRdsDbSubnetGroupSubnet]] = None,
      dbSubnetGroupArn: Option[String] = None
    ): AwsRdsDbSubnetGroup =
      AwsRdsDbSubnetGroup
        .builder
        .ifSome(dbSubnetGroupName)(_.dbSubnetGroupName(_))
        .ifSome(dbSubnetGroupDescription)(_.dbSubnetGroupDescription(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetGroupStatus)(_.subnetGroupStatus(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(dbSubnetGroupArn)(_.dbSubnetGroupArn(_))
        .build

    def awsRdsDbSubnetGroupSubnet(
      subnetIdentifier: Option[String] = None,
      subnetAvailabilityZone: Option[AwsRdsDbSubnetGroupSubnetAvailabilityZone] = None,
      subnetStatus: Option[String] = None
    ): AwsRdsDbSubnetGroupSubnet =
      AwsRdsDbSubnetGroupSubnet
        .builder
        .ifSome(subnetIdentifier)(_.subnetIdentifier(_))
        .ifSome(subnetAvailabilityZone)(_.subnetAvailabilityZone(_))
        .ifSome(subnetStatus)(_.subnetStatus(_))
        .build

    def awsRdsDbSubnetGroupSubnetAvailabilityZone(
      name: Option[String] = None
    ): AwsRdsDbSubnetGroupSubnetAvailabilityZone =
      AwsRdsDbSubnetGroupSubnetAvailabilityZone
        .builder
        .ifSome(name)(_.name(_))
        .build

    def awsRdsPendingCloudWatchLogsExports(
      logTypesToEnable: Option[List[NonEmptyString]] = None,
      logTypesToDisable: Option[List[NonEmptyString]] = None
    ): AwsRdsPendingCloudWatchLogsExports =
      AwsRdsPendingCloudWatchLogsExports
        .builder
        .ifSome(logTypesToEnable)(_.logTypesToEnable(_))
        .ifSome(logTypesToDisable)(_.logTypesToDisable(_))
        .build

    def awsRedshiftClusterClusterNode(
      nodeRole: Option[String] = None,
      privateIpAddress: Option[String] = None,
      publicIpAddress: Option[String] = None
    ): AwsRedshiftClusterClusterNode =
      AwsRedshiftClusterClusterNode
        .builder
        .ifSome(nodeRole)(_.nodeRole(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(publicIpAddress)(_.publicIpAddress(_))
        .build

    def awsRedshiftClusterClusterParameterGroup(
      clusterParameterStatusList: Option[List[AwsRedshiftClusterClusterParameterStatus]] = None,
      parameterApplyStatus: Option[String] = None,
      parameterGroupName: Option[String] = None
    ): AwsRedshiftClusterClusterParameterGroup =
      AwsRedshiftClusterClusterParameterGroup
        .builder
        .ifSome(clusterParameterStatusList)(_.clusterParameterStatusList(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .build

    def awsRedshiftClusterClusterParameterStatus(
      parameterName: Option[String] = None,
      parameterApplyStatus: Option[String] = None,
      parameterApplyErrorDescription: Option[String] = None
    ): AwsRedshiftClusterClusterParameterStatus =
      AwsRedshiftClusterClusterParameterStatus
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .ifSome(parameterApplyErrorDescription)(_.parameterApplyErrorDescription(_))
        .build

    def awsRedshiftClusterClusterSecurityGroup(
      clusterSecurityGroupName: Option[String] = None,
      status: Option[String] = None
    ): AwsRedshiftClusterClusterSecurityGroup =
      AwsRedshiftClusterClusterSecurityGroup
        .builder
        .ifSome(clusterSecurityGroupName)(_.clusterSecurityGroupName(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRedshiftClusterClusterSnapshotCopyStatus(
      destinationRegion: Option[String] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      retentionPeriod: Option[Int] = None,
      snapshotCopyGrantName: Option[String] = None
    ): AwsRedshiftClusterClusterSnapshotCopyStatus =
      AwsRedshiftClusterClusterSnapshotCopyStatus
        .builder
        .ifSome(destinationRegion)(_.destinationRegion(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(snapshotCopyGrantName)(_.snapshotCopyGrantName(_))
        .build

    def awsRedshiftClusterDeferredMaintenanceWindow(
      deferMaintenanceEndTime: Option[String] = None,
      deferMaintenanceIdentifier: Option[String] = None,
      deferMaintenanceStartTime: Option[String] = None
    ): AwsRedshiftClusterDeferredMaintenanceWindow =
      AwsRedshiftClusterDeferredMaintenanceWindow
        .builder
        .ifSome(deferMaintenanceEndTime)(_.deferMaintenanceEndTime(_))
        .ifSome(deferMaintenanceIdentifier)(_.deferMaintenanceIdentifier(_))
        .ifSome(deferMaintenanceStartTime)(_.deferMaintenanceStartTime(_))
        .build

    def awsRedshiftClusterDetails(
      allowVersionUpgrade: Option[Boolean] = None,
      automatedSnapshotRetentionPeriod: Option[Int] = None,
      availabilityZone: Option[String] = None,
      clusterAvailabilityStatus: Option[String] = None,
      clusterCreateTime: Option[String] = None,
      clusterIdentifier: Option[String] = None,
      clusterNodes: Option[List[AwsRedshiftClusterClusterNode]] = None,
      clusterParameterGroups: Option[List[AwsRedshiftClusterClusterParameterGroup]] = None,
      clusterPublicKey: Option[String] = None,
      clusterRevisionNumber: Option[String] = None,
      clusterSecurityGroups: Option[List[AwsRedshiftClusterClusterSecurityGroup]] = None,
      clusterSnapshotCopyStatus: Option[AwsRedshiftClusterClusterSnapshotCopyStatus] = None,
      clusterStatus: Option[String] = None,
      clusterSubnetGroupName: Option[String] = None,
      clusterVersion: Option[String] = None,
      dBName: Option[String] = None,
      deferredMaintenanceWindows: Option[List[AwsRedshiftClusterDeferredMaintenanceWindow]] = None,
      elasticIpStatus: Option[AwsRedshiftClusterElasticIpStatus] = None,
      elasticResizeNumberOfNodeOptions: Option[String] = None,
      encrypted: Option[Boolean] = None,
      endpoint: Option[AwsRedshiftClusterEndpoint] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      expectedNextSnapshotScheduleTime: Option[String] = None,
      expectedNextSnapshotScheduleTimeStatus: Option[String] = None,
      hsmStatus: Option[AwsRedshiftClusterHsmStatus] = None,
      iamRoles: Option[List[AwsRedshiftClusterIamRole]] = None,
      kmsKeyId: Option[String] = None,
      maintenanceTrackName: Option[String] = None,
      manualSnapshotRetentionPeriod: Option[Int] = None,
      masterUsername: Option[String] = None,
      nextMaintenanceWindowStartTime: Option[String] = None,
      nodeType: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      pendingActions: Option[List[NonEmptyString]] = None,
      pendingModifiedValues: Option[AwsRedshiftClusterPendingModifiedValues] = None,
      preferredMaintenanceWindow: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      resizeInfo: Option[AwsRedshiftClusterResizeInfo] = None,
      restoreStatus: Option[AwsRedshiftClusterRestoreStatus] = None,
      snapshotScheduleIdentifier: Option[String] = None,
      snapshotScheduleState: Option[String] = None,
      vpcId: Option[String] = None,
      vpcSecurityGroups: Option[List[AwsRedshiftClusterVpcSecurityGroup]] = None
    ): AwsRedshiftClusterDetails =
      AwsRedshiftClusterDetails
        .builder
        .ifSome(allowVersionUpgrade)(_.allowVersionUpgrade(_))
        .ifSome(automatedSnapshotRetentionPeriod)(_.automatedSnapshotRetentionPeriod(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(clusterAvailabilityStatus)(_.clusterAvailabilityStatus(_))
        .ifSome(clusterCreateTime)(_.clusterCreateTime(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(clusterNodes)(_.clusterNodes(_))
        .ifSome(clusterParameterGroups)(_.clusterParameterGroups(_))
        .ifSome(clusterPublicKey)(_.clusterPublicKey(_))
        .ifSome(clusterRevisionNumber)(_.clusterRevisionNumber(_))
        .ifSome(clusterSecurityGroups)(_.clusterSecurityGroups(_))
        .ifSome(clusterSnapshotCopyStatus)(_.clusterSnapshotCopyStatus(_))
        .ifSome(clusterStatus)(_.clusterStatus(_))
        .ifSome(clusterSubnetGroupName)(_.clusterSubnetGroupName(_))
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(dBName)(_.dBName(_))
        .ifSome(deferredMaintenanceWindows)(_.deferredMaintenanceWindows(_))
        .ifSome(elasticIpStatus)(_.elasticIpStatus(_))
        .ifSome(elasticResizeNumberOfNodeOptions)(_.elasticResizeNumberOfNodeOptions(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(expectedNextSnapshotScheduleTime)(_.expectedNextSnapshotScheduleTime(_))
        .ifSome(expectedNextSnapshotScheduleTimeStatus)(_.expectedNextSnapshotScheduleTimeStatus(_))
        .ifSome(hsmStatus)(_.hsmStatus(_))
        .ifSome(iamRoles)(_.iamRoles(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(manualSnapshotRetentionPeriod)(_.manualSnapshotRetentionPeriod(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(nextMaintenanceWindowStartTime)(_.nextMaintenanceWindowStartTime(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(pendingActions)(_.pendingActions(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(resizeInfo)(_.resizeInfo(_))
        .ifSome(restoreStatus)(_.restoreStatus(_))
        .ifSome(snapshotScheduleIdentifier)(_.snapshotScheduleIdentifier(_))
        .ifSome(snapshotScheduleState)(_.snapshotScheduleState(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .build

    def awsRedshiftClusterElasticIpStatus(
      elasticIp: Option[String] = None,
      status: Option[String] = None
    ): AwsRedshiftClusterElasticIpStatus =
      AwsRedshiftClusterElasticIpStatus
        .builder
        .ifSome(elasticIp)(_.elasticIp(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRedshiftClusterEndpoint(
      address: Option[String] = None,
      port: Option[Int] = None
    ): AwsRedshiftClusterEndpoint =
      AwsRedshiftClusterEndpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(port)(_.port(_))
        .build

    def awsRedshiftClusterHsmStatus(
      hsmClientCertificateIdentifier: Option[String] = None,
      hsmConfigurationIdentifier: Option[String] = None,
      status: Option[String] = None
    ): AwsRedshiftClusterHsmStatus =
      AwsRedshiftClusterHsmStatus
        .builder
        .ifSome(hsmClientCertificateIdentifier)(_.hsmClientCertificateIdentifier(_))
        .ifSome(hsmConfigurationIdentifier)(_.hsmConfigurationIdentifier(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRedshiftClusterIamRole(
      applyStatus: Option[String] = None,
      iamRoleArn: Option[String] = None
    ): AwsRedshiftClusterIamRole =
      AwsRedshiftClusterIamRole
        .builder
        .ifSome(applyStatus)(_.applyStatus(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .build

    def awsRedshiftClusterPendingModifiedValues(
      automatedSnapshotRetentionPeriod: Option[Int] = None,
      clusterIdentifier: Option[String] = None,
      clusterType: Option[String] = None,
      clusterVersion: Option[String] = None,
      encryptionType: Option[String] = None,
      enhancedVpcRouting: Option[Boolean] = None,
      maintenanceTrackName: Option[String] = None,
      masterUserPassword: Option[String] = None,
      nodeType: Option[String] = None,
      numberOfNodes: Option[Int] = None,
      publiclyAccessible: Option[Boolean] = None
    ): AwsRedshiftClusterPendingModifiedValues =
      AwsRedshiftClusterPendingModifiedValues
        .builder
        .ifSome(automatedSnapshotRetentionPeriod)(_.automatedSnapshotRetentionPeriod(_))
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(clusterType)(_.clusterType(_))
        .ifSome(clusterVersion)(_.clusterVersion(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(enhancedVpcRouting)(_.enhancedVpcRouting(_))
        .ifSome(maintenanceTrackName)(_.maintenanceTrackName(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .build

    def awsRedshiftClusterResizeInfo(
      allowCancelResize: Option[Boolean] = None,
      resizeType: Option[String] = None
    ): AwsRedshiftClusterResizeInfo =
      AwsRedshiftClusterResizeInfo
        .builder
        .ifSome(allowCancelResize)(_.allowCancelResize(_))
        .ifSome(resizeType)(_.resizeType(_))
        .build

    def awsRedshiftClusterRestoreStatus(
      currentRestoreRateInMegaBytesPerSecond: Option[Double] = None,
      elapsedTimeInSeconds: Option[Long] = None,
      estimatedTimeToCompletionInSeconds: Option[Long] = None,
      progressInMegaBytes: Option[Long] = None,
      snapshotSizeInMegaBytes: Option[Long] = None,
      status: Option[String] = None
    ): AwsRedshiftClusterRestoreStatus =
      AwsRedshiftClusterRestoreStatus
        .builder
        .ifSome(currentRestoreRateInMegaBytesPerSecond)(_.currentRestoreRateInMegaBytesPerSecond(_))
        .ifSome(elapsedTimeInSeconds)(_.elapsedTimeInSeconds(_))
        .ifSome(estimatedTimeToCompletionInSeconds)(_.estimatedTimeToCompletionInSeconds(_))
        .ifSome(progressInMegaBytes)(_.progressInMegaBytes(_))
        .ifSome(snapshotSizeInMegaBytes)(_.snapshotSizeInMegaBytes(_))
        .ifSome(status)(_.status(_))
        .build

    def awsRedshiftClusterVpcSecurityGroup(
      status: Option[String] = None,
      vpcSecurityGroupId: Option[String] = None
    ): AwsRedshiftClusterVpcSecurityGroup =
      AwsRedshiftClusterVpcSecurityGroup
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(vpcSecurityGroupId)(_.vpcSecurityGroupId(_))
        .build

    def awsS3AccountPublicAccessBlockDetails(
      blockPublicAcls: Option[Boolean] = None,
      blockPublicPolicy: Option[Boolean] = None,
      ignorePublicAcls: Option[Boolean] = None,
      restrictPublicBuckets: Option[Boolean] = None
    ): AwsS3AccountPublicAccessBlockDetails =
      AwsS3AccountPublicAccessBlockDetails
        .builder
        .ifSome(blockPublicAcls)(_.blockPublicAcls(_))
        .ifSome(blockPublicPolicy)(_.blockPublicPolicy(_))
        .ifSome(ignorePublicAcls)(_.ignorePublicAcls(_))
        .ifSome(restrictPublicBuckets)(_.restrictPublicBuckets(_))
        .build

    def awsS3BucketDetails(
      ownerId: Option[String] = None,
      ownerName: Option[String] = None,
      createdAt: Option[String] = None,
      serverSideEncryptionConfiguration: Option[AwsS3BucketServerSideEncryptionConfiguration] = None,
      publicAccessBlockConfiguration: Option[AwsS3AccountPublicAccessBlockDetails] = None
    ): AwsS3BucketDetails =
      AwsS3BucketDetails
        .builder
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(ownerName)(_.ownerName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(serverSideEncryptionConfiguration)(_.serverSideEncryptionConfiguration(_))
        .ifSome(publicAccessBlockConfiguration)(_.publicAccessBlockConfiguration(_))
        .build

    def awsS3BucketServerSideEncryptionByDefault(
      sSEAlgorithm: Option[String] = None,
      kMSMasterKeyID: Option[String] = None
    ): AwsS3BucketServerSideEncryptionByDefault =
      AwsS3BucketServerSideEncryptionByDefault
        .builder
        .ifSome(sSEAlgorithm)(_.sSEAlgorithm(_))
        .ifSome(kMSMasterKeyID)(_.kMSMasterKeyID(_))
        .build

    def awsS3BucketServerSideEncryptionConfiguration(
      rules: Option[List[AwsS3BucketServerSideEncryptionRule]] = None
    ): AwsS3BucketServerSideEncryptionConfiguration =
      AwsS3BucketServerSideEncryptionConfiguration
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def awsS3BucketServerSideEncryptionRule(
      applyServerSideEncryptionByDefault: Option[AwsS3BucketServerSideEncryptionByDefault] = None
    ): AwsS3BucketServerSideEncryptionRule =
      AwsS3BucketServerSideEncryptionRule
        .builder
        .ifSome(applyServerSideEncryptionByDefault)(_.applyServerSideEncryptionByDefault(_))
        .build

    def awsS3ObjectDetails(
      lastModified: Option[String] = None,
      eTag: Option[String] = None,
      versionId: Option[String] = None,
      contentType: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      sSEKMSKeyId: Option[String] = None
    ): AwsS3ObjectDetails =
      AwsS3ObjectDetails
        .builder
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .build

    def awsSecretsManagerSecretDetails(
      rotationRules: Option[AwsSecretsManagerSecretRotationRules] = None,
      rotationOccurredWithinFrequency: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      rotationEnabled: Option[Boolean] = None,
      rotationLambdaArn: Option[String] = None,
      deleted: Option[Boolean] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): AwsSecretsManagerSecretDetails =
      AwsSecretsManagerSecretDetails
        .builder
        .ifSome(rotationRules)(_.rotationRules(_))
        .ifSome(rotationOccurredWithinFrequency)(_.rotationOccurredWithinFrequency(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(rotationEnabled)(_.rotationEnabled(_))
        .ifSome(rotationLambdaArn)(_.rotationLambdaArn(_))
        .ifSome(deleted)(_.deleted(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def awsSecretsManagerSecretRotationRules(
      automaticallyAfterDays: Option[Int] = None
    ): AwsSecretsManagerSecretRotationRules =
      AwsSecretsManagerSecretRotationRules
        .builder
        .ifSome(automaticallyAfterDays)(_.automaticallyAfterDays(_))
        .build

    def awsSecurityFinding(
      schemaVersion: Option[String] = None,
      id: Option[String] = None,
      productArn: Option[String] = None,
      generatorId: Option[String] = None,
      awsAccountId: Option[String] = None,
      types: Option[List[NonEmptyString]] = None,
      firstObservedAt: Option[String] = None,
      lastObservedAt: Option[String] = None,
      createdAt: Option[String] = None,
      updatedAt: Option[String] = None,
      severity: Option[Severity] = None,
      confidence: Option[Int] = None,
      criticality: Option[Int] = None,
      title: Option[String] = None,
      description: Option[String] = None,
      remediation: Option[Remediation] = None,
      sourceUrl: Option[String] = None,
      productFields: Option[FieldMap] = None,
      userDefinedFields: Option[FieldMap] = None,
      malware: Option[List[Malware]] = None,
      network: Option[Network] = None,
      networkPath: Option[List[NetworkPathComponent]] = None,
      process: Option[ProcessDetails] = None,
      threatIntelIndicators: Option[List[ThreatIntelIndicator]] = None,
      resources: Option[List[Resource]] = None,
      compliance: Option[Compliance] = None,
      verificationState: Option[String] = None,
      workflowState: Option[String] = None,
      workflow: Option[Workflow] = None,
      recordState: Option[String] = None,
      relatedFindings: Option[List[RelatedFinding]] = None,
      note: Option[Note] = None,
      vulnerabilities: Option[List[Vulnerability]] = None,
      patchSummary: Option[PatchSummary] = None,
      action: Option[Action] = None,
      findingProviderFields: Option[FindingProviderFields] = None
    ): AwsSecurityFinding =
      AwsSecurityFinding
        .builder
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(id)(_.id(_))
        .ifSome(productArn)(_.productArn(_))
        .ifSome(generatorId)(_.generatorId(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(types)(_.types(_))
        .ifSome(firstObservedAt)(_.firstObservedAt(_))
        .ifSome(lastObservedAt)(_.lastObservedAt(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(criticality)(_.criticality(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(remediation)(_.remediation(_))
        .ifSome(sourceUrl)(_.sourceUrl(_))
        .ifSome(productFields)(_.productFields(_))
        .ifSome(userDefinedFields)(_.userDefinedFields(_))
        .ifSome(malware)(_.malware(_))
        .ifSome(network)(_.network(_))
        .ifSome(networkPath)(_.networkPath(_))
        .ifSome(process)(_.process(_))
        .ifSome(threatIntelIndicators)(_.threatIntelIndicators(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(compliance)(_.compliance(_))
        .ifSome(verificationState)(_.verificationState(_))
        .ifSome(workflowState)(_.workflowState(_))
        .ifSome(workflow)(_.workflow(_))
        .ifSome(recordState)(_.recordState(_))
        .ifSome(relatedFindings)(_.relatedFindings(_))
        .ifSome(note)(_.note(_))
        .ifSome(vulnerabilities)(_.vulnerabilities(_))
        .ifSome(patchSummary)(_.patchSummary(_))
        .ifSome(action)(_.action(_))
        .ifSome(findingProviderFields)(_.findingProviderFields(_))
        .build

    def awsSecurityFindingFilters(
      productArn: Option[List[StringFilter]] = None,
      awsAccountId: Option[List[StringFilter]] = None,
      id: Option[List[StringFilter]] = None,
      generatorId: Option[List[StringFilter]] = None,
      `type`: Option[List[StringFilter]] = None,
      firstObservedAt: Option[List[DateFilter]] = None,
      lastObservedAt: Option[List[DateFilter]] = None,
      createdAt: Option[List[DateFilter]] = None,
      updatedAt: Option[List[DateFilter]] = None,
      severityProduct: Option[List[NumberFilter]] = None,
      severityNormalized: Option[List[NumberFilter]] = None,
      severityLabel: Option[List[StringFilter]] = None,
      confidence: Option[List[NumberFilter]] = None,
      criticality: Option[List[NumberFilter]] = None,
      title: Option[List[StringFilter]] = None,
      description: Option[List[StringFilter]] = None,
      recommendationText: Option[List[StringFilter]] = None,
      sourceUrl: Option[List[StringFilter]] = None,
      productFields: Option[List[MapFilter]] = None,
      productName: Option[List[StringFilter]] = None,
      companyName: Option[List[StringFilter]] = None,
      userDefinedFields: Option[List[MapFilter]] = None,
      malwareName: Option[List[StringFilter]] = None,
      malwareType: Option[List[StringFilter]] = None,
      malwarePath: Option[List[StringFilter]] = None,
      malwareState: Option[List[StringFilter]] = None,
      networkDirection: Option[List[StringFilter]] = None,
      networkProtocol: Option[List[StringFilter]] = None,
      networkSourceIpV4: Option[List[IpFilter]] = None,
      networkSourceIpV6: Option[List[IpFilter]] = None,
      networkSourcePort: Option[List[NumberFilter]] = None,
      networkSourceDomain: Option[List[StringFilter]] = None,
      networkSourceMac: Option[List[StringFilter]] = None,
      networkDestinationIpV4: Option[List[IpFilter]] = None,
      networkDestinationIpV6: Option[List[IpFilter]] = None,
      networkDestinationPort: Option[List[NumberFilter]] = None,
      networkDestinationDomain: Option[List[StringFilter]] = None,
      processName: Option[List[StringFilter]] = None,
      processPath: Option[List[StringFilter]] = None,
      processPid: Option[List[NumberFilter]] = None,
      processParentPid: Option[List[NumberFilter]] = None,
      processLaunchedAt: Option[List[DateFilter]] = None,
      processTerminatedAt: Option[List[DateFilter]] = None,
      threatIntelIndicatorType: Option[List[StringFilter]] = None,
      threatIntelIndicatorValue: Option[List[StringFilter]] = None,
      threatIntelIndicatorCategory: Option[List[StringFilter]] = None,
      threatIntelIndicatorLastObservedAt: Option[List[DateFilter]] = None,
      threatIntelIndicatorSource: Option[List[StringFilter]] = None,
      threatIntelIndicatorSourceUrl: Option[List[StringFilter]] = None,
      resourceType: Option[List[StringFilter]] = None,
      resourceId: Option[List[StringFilter]] = None,
      resourcePartition: Option[List[StringFilter]] = None,
      resourceRegion: Option[List[StringFilter]] = None,
      resourceTags: Option[List[MapFilter]] = None,
      resourceAwsEc2InstanceType: Option[List[StringFilter]] = None,
      resourceAwsEc2InstanceImageId: Option[List[StringFilter]] = None,
      resourceAwsEc2InstanceIpV4Addresses: Option[List[IpFilter]] = None,
      resourceAwsEc2InstanceIpV6Addresses: Option[List[IpFilter]] = None,
      resourceAwsEc2InstanceKeyName: Option[List[StringFilter]] = None,
      resourceAwsEc2InstanceIamInstanceProfileArn: Option[List[StringFilter]] = None,
      resourceAwsEc2InstanceVpcId: Option[List[StringFilter]] = None,
      resourceAwsEc2InstanceSubnetId: Option[List[StringFilter]] = None,
      resourceAwsEc2InstanceLaunchedAt: Option[List[DateFilter]] = None,
      resourceAwsS3BucketOwnerId: Option[List[StringFilter]] = None,
      resourceAwsS3BucketOwnerName: Option[List[StringFilter]] = None,
      resourceAwsIamAccessKeyUserName: Option[List[StringFilter]] = None,
      resourceAwsIamAccessKeyStatus: Option[List[StringFilter]] = None,
      resourceAwsIamAccessKeyCreatedAt: Option[List[DateFilter]] = None,
      resourceContainerName: Option[List[StringFilter]] = None,
      resourceContainerImageId: Option[List[StringFilter]] = None,
      resourceContainerImageName: Option[List[StringFilter]] = None,
      resourceContainerLaunchedAt: Option[List[DateFilter]] = None,
      resourceDetailsOther: Option[List[MapFilter]] = None,
      complianceStatus: Option[List[StringFilter]] = None,
      verificationState: Option[List[StringFilter]] = None,
      workflowState: Option[List[StringFilter]] = None,
      workflowStatus: Option[List[StringFilter]] = None,
      recordState: Option[List[StringFilter]] = None,
      relatedFindingsProductArn: Option[List[StringFilter]] = None,
      relatedFindingsId: Option[List[StringFilter]] = None,
      noteText: Option[List[StringFilter]] = None,
      noteUpdatedAt: Option[List[DateFilter]] = None,
      noteUpdatedBy: Option[List[StringFilter]] = None,
      keyword: Option[List[KeywordFilter]] = None,
      findingProviderFieldsConfidence: Option[List[NumberFilter]] = None,
      findingProviderFieldsCriticality: Option[List[NumberFilter]] = None,
      findingProviderFieldsRelatedFindingsId: Option[List[StringFilter]] = None,
      findingProviderFieldsRelatedFindingsProductArn: Option[List[StringFilter]] = None,
      findingProviderFieldsSeverityLabel: Option[List[StringFilter]] = None,
      findingProviderFieldsSeverityOriginal: Option[List[StringFilter]] = None,
      findingProviderFieldsTypes: Option[List[StringFilter]] = None
    ): AwsSecurityFindingFilters =
      AwsSecurityFindingFilters
        .builder
        .ifSome(productArn)(_.productArn(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(id)(_.id(_))
        .ifSome(generatorId)(_.generatorId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(firstObservedAt)(_.firstObservedAt(_))
        .ifSome(lastObservedAt)(_.lastObservedAt(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(severityProduct)(_.severityProduct(_))
        .ifSome(severityNormalized)(_.severityNormalized(_))
        .ifSome(severityLabel)(_.severityLabel(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(criticality)(_.criticality(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(recommendationText)(_.recommendationText(_))
        .ifSome(sourceUrl)(_.sourceUrl(_))
        .ifSome(productFields)(_.productFields(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(companyName)(_.companyName(_))
        .ifSome(userDefinedFields)(_.userDefinedFields(_))
        .ifSome(malwareName)(_.malwareName(_))
        .ifSome(malwareType)(_.malwareType(_))
        .ifSome(malwarePath)(_.malwarePath(_))
        .ifSome(malwareState)(_.malwareState(_))
        .ifSome(networkDirection)(_.networkDirection(_))
        .ifSome(networkProtocol)(_.networkProtocol(_))
        .ifSome(networkSourceIpV4)(_.networkSourceIpV4(_))
        .ifSome(networkSourceIpV6)(_.networkSourceIpV6(_))
        .ifSome(networkSourcePort)(_.networkSourcePort(_))
        .ifSome(networkSourceDomain)(_.networkSourceDomain(_))
        .ifSome(networkSourceMac)(_.networkSourceMac(_))
        .ifSome(networkDestinationIpV4)(_.networkDestinationIpV4(_))
        .ifSome(networkDestinationIpV6)(_.networkDestinationIpV6(_))
        .ifSome(networkDestinationPort)(_.networkDestinationPort(_))
        .ifSome(networkDestinationDomain)(_.networkDestinationDomain(_))
        .ifSome(processName)(_.processName(_))
        .ifSome(processPath)(_.processPath(_))
        .ifSome(processPid)(_.processPid(_))
        .ifSome(processParentPid)(_.processParentPid(_))
        .ifSome(processLaunchedAt)(_.processLaunchedAt(_))
        .ifSome(processTerminatedAt)(_.processTerminatedAt(_))
        .ifSome(threatIntelIndicatorType)(_.threatIntelIndicatorType(_))
        .ifSome(threatIntelIndicatorValue)(_.threatIntelIndicatorValue(_))
        .ifSome(threatIntelIndicatorCategory)(_.threatIntelIndicatorCategory(_))
        .ifSome(threatIntelIndicatorLastObservedAt)(_.threatIntelIndicatorLastObservedAt(_))
        .ifSome(threatIntelIndicatorSource)(_.threatIntelIndicatorSource(_))
        .ifSome(threatIntelIndicatorSourceUrl)(_.threatIntelIndicatorSourceUrl(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourcePartition)(_.resourcePartition(_))
        .ifSome(resourceRegion)(_.resourceRegion(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(resourceAwsEc2InstanceType)(_.resourceAwsEc2InstanceType(_))
        .ifSome(resourceAwsEc2InstanceImageId)(_.resourceAwsEc2InstanceImageId(_))
        .ifSome(resourceAwsEc2InstanceIpV4Addresses)(_.resourceAwsEc2InstanceIpV4Addresses(_))
        .ifSome(resourceAwsEc2InstanceIpV6Addresses)(_.resourceAwsEc2InstanceIpV6Addresses(_))
        .ifSome(resourceAwsEc2InstanceKeyName)(_.resourceAwsEc2InstanceKeyName(_))
        .ifSome(resourceAwsEc2InstanceIamInstanceProfileArn)(_.resourceAwsEc2InstanceIamInstanceProfileArn(_))
        .ifSome(resourceAwsEc2InstanceVpcId)(_.resourceAwsEc2InstanceVpcId(_))
        .ifSome(resourceAwsEc2InstanceSubnetId)(_.resourceAwsEc2InstanceSubnetId(_))
        .ifSome(resourceAwsEc2InstanceLaunchedAt)(_.resourceAwsEc2InstanceLaunchedAt(_))
        .ifSome(resourceAwsS3BucketOwnerId)(_.resourceAwsS3BucketOwnerId(_))
        .ifSome(resourceAwsS3BucketOwnerName)(_.resourceAwsS3BucketOwnerName(_))
        .ifSome(resourceAwsIamAccessKeyUserName)(_.resourceAwsIamAccessKeyUserName(_))
        .ifSome(resourceAwsIamAccessKeyStatus)(_.resourceAwsIamAccessKeyStatus(_))
        .ifSome(resourceAwsIamAccessKeyCreatedAt)(_.resourceAwsIamAccessKeyCreatedAt(_))
        .ifSome(resourceContainerName)(_.resourceContainerName(_))
        .ifSome(resourceContainerImageId)(_.resourceContainerImageId(_))
        .ifSome(resourceContainerImageName)(_.resourceContainerImageName(_))
        .ifSome(resourceContainerLaunchedAt)(_.resourceContainerLaunchedAt(_))
        .ifSome(resourceDetailsOther)(_.resourceDetailsOther(_))
        .ifSome(complianceStatus)(_.complianceStatus(_))
        .ifSome(verificationState)(_.verificationState(_))
        .ifSome(workflowState)(_.workflowState(_))
        .ifSome(workflowStatus)(_.workflowStatus(_))
        .ifSome(recordState)(_.recordState(_))
        .ifSome(relatedFindingsProductArn)(_.relatedFindingsProductArn(_))
        .ifSome(relatedFindingsId)(_.relatedFindingsId(_))
        .ifSome(noteText)(_.noteText(_))
        .ifSome(noteUpdatedAt)(_.noteUpdatedAt(_))
        .ifSome(noteUpdatedBy)(_.noteUpdatedBy(_))
        .ifSome(keyword)(_.keyword(_))
        .ifSome(findingProviderFieldsConfidence)(_.findingProviderFieldsConfidence(_))
        .ifSome(findingProviderFieldsCriticality)(_.findingProviderFieldsCriticality(_))
        .ifSome(findingProviderFieldsRelatedFindingsId)(_.findingProviderFieldsRelatedFindingsId(_))
        .ifSome(findingProviderFieldsRelatedFindingsProductArn)(_.findingProviderFieldsRelatedFindingsProductArn(_))
        .ifSome(findingProviderFieldsSeverityLabel)(_.findingProviderFieldsSeverityLabel(_))
        .ifSome(findingProviderFieldsSeverityOriginal)(_.findingProviderFieldsSeverityOriginal(_))
        .ifSome(findingProviderFieldsTypes)(_.findingProviderFieldsTypes(_))
        .build

    def awsSecurityFindingIdentifier(
      id: Option[String] = None,
      productArn: Option[String] = None
    ): AwsSecurityFindingIdentifier =
      AwsSecurityFindingIdentifier
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(productArn)(_.productArn(_))
        .build

    def awsSnsTopicDetails(
      kmsMasterKeyId: Option[String] = None,
      subscription: Option[List[AwsSnsTopicSubscription]] = None,
      topicName: Option[String] = None,
      owner: Option[String] = None
    ): AwsSnsTopicDetails =
      AwsSnsTopicDetails
        .builder
        .ifSome(kmsMasterKeyId)(_.kmsMasterKeyId(_))
        .ifSome(subscription)(_.subscription(_))
        .ifSome(topicName)(_.topicName(_))
        .ifSome(owner)(_.owner(_))
        .build

    def awsSnsTopicSubscription(
      endpoint: Option[String] = None,
      protocol: Option[String] = None
    ): AwsSnsTopicSubscription =
      AwsSnsTopicSubscription
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def awsSqsQueueDetails(
      kmsDataKeyReusePeriodSeconds: Option[Int] = None,
      kmsMasterKeyId: Option[String] = None,
      queueName: Option[String] = None,
      deadLetterTargetArn: Option[String] = None
    ): AwsSqsQueueDetails =
      AwsSqsQueueDetails
        .builder
        .ifSome(kmsDataKeyReusePeriodSeconds)(_.kmsDataKeyReusePeriodSeconds(_))
        .ifSome(kmsMasterKeyId)(_.kmsMasterKeyId(_))
        .ifSome(queueName)(_.queueName(_))
        .ifSome(deadLetterTargetArn)(_.deadLetterTargetArn(_))
        .build

    def awsSsmComplianceSummary(
      status: Option[String] = None,
      compliantCriticalCount: Option[Int] = None,
      compliantHighCount: Option[Int] = None,
      compliantMediumCount: Option[Int] = None,
      executionType: Option[String] = None,
      nonCompliantCriticalCount: Option[Int] = None,
      compliantInformationalCount: Option[Int] = None,
      nonCompliantInformationalCount: Option[Int] = None,
      compliantUnspecifiedCount: Option[Int] = None,
      nonCompliantLowCount: Option[Int] = None,
      nonCompliantHighCount: Option[Int] = None,
      compliantLowCount: Option[Int] = None,
      complianceType: Option[String] = None,
      patchBaselineId: Option[String] = None,
      overallSeverity: Option[String] = None,
      nonCompliantMediumCount: Option[Int] = None,
      nonCompliantUnspecifiedCount: Option[Int] = None,
      patchGroup: Option[String] = None
    ): AwsSsmComplianceSummary =
      AwsSsmComplianceSummary
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(compliantCriticalCount)(_.compliantCriticalCount(_))
        .ifSome(compliantHighCount)(_.compliantHighCount(_))
        .ifSome(compliantMediumCount)(_.compliantMediumCount(_))
        .ifSome(executionType)(_.executionType(_))
        .ifSome(nonCompliantCriticalCount)(_.nonCompliantCriticalCount(_))
        .ifSome(compliantInformationalCount)(_.compliantInformationalCount(_))
        .ifSome(nonCompliantInformationalCount)(_.nonCompliantInformationalCount(_))
        .ifSome(compliantUnspecifiedCount)(_.compliantUnspecifiedCount(_))
        .ifSome(nonCompliantLowCount)(_.nonCompliantLowCount(_))
        .ifSome(nonCompliantHighCount)(_.nonCompliantHighCount(_))
        .ifSome(compliantLowCount)(_.compliantLowCount(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(patchBaselineId)(_.patchBaselineId(_))
        .ifSome(overallSeverity)(_.overallSeverity(_))
        .ifSome(nonCompliantMediumCount)(_.nonCompliantMediumCount(_))
        .ifSome(nonCompliantUnspecifiedCount)(_.nonCompliantUnspecifiedCount(_))
        .ifSome(patchGroup)(_.patchGroup(_))
        .build

    def awsSsmPatch(
      complianceSummary: Option[AwsSsmComplianceSummary] = None
    ): AwsSsmPatch =
      AwsSsmPatch
        .builder
        .ifSome(complianceSummary)(_.complianceSummary(_))
        .build

    def awsSsmPatchComplianceDetails(
      patch: Option[AwsSsmPatch] = None
    ): AwsSsmPatchComplianceDetails =
      AwsSsmPatchComplianceDetails
        .builder
        .ifSome(patch)(_.patch(_))
        .build

    def awsWafWebAclDetails(
      name: Option[String] = None,
      defaultAction: Option[String] = None,
      rules: Option[List[AwsWafWebAclRule]] = None,
      webAclId: Option[String] = None
    ): AwsWafWebAclDetails =
      AwsWafWebAclDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(defaultAction)(_.defaultAction(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(webAclId)(_.webAclId(_))
        .build

    def awsWafWebAclRule(
      action: Option[WafAction] = None,
      excludedRules: Option[List[WafExcludedRule]] = None,
      overrideAction: Option[WafOverrideAction] = None,
      priority: Option[Int] = None,
      ruleId: Option[String] = None,
      `type`: Option[String] = None
    ): AwsWafWebAclRule =
      AwsWafWebAclRule
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(excludedRules)(_.excludedRules(_))
        .ifSome(overrideAction)(_.overrideAction(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def batchDisableStandardsRequest(
      standardsSubscriptionArns: Option[List[NonEmptyString]] = None
    ): BatchDisableStandardsRequest =
      BatchDisableStandardsRequest
        .builder
        .ifSome(standardsSubscriptionArns)(_.standardsSubscriptionArns(_))
        .build

    def batchDisableStandardsResponse(
      standardsSubscriptions: Option[List[StandardsSubscription]] = None
    ): BatchDisableStandardsResponse =
      BatchDisableStandardsResponse
        .builder
        .ifSome(standardsSubscriptions)(_.standardsSubscriptions(_))
        .build

    def batchEnableStandardsRequest(
      standardsSubscriptionRequests: Option[List[StandardsSubscriptionRequest]] = None
    ): BatchEnableStandardsRequest =
      BatchEnableStandardsRequest
        .builder
        .ifSome(standardsSubscriptionRequests)(_.standardsSubscriptionRequests(_))
        .build

    def batchEnableStandardsResponse(
      standardsSubscriptions: Option[List[StandardsSubscription]] = None
    ): BatchEnableStandardsResponse =
      BatchEnableStandardsResponse
        .builder
        .ifSome(standardsSubscriptions)(_.standardsSubscriptions(_))
        .build

    def batchImportFindingsRequest(
      findings: Option[List[AwsSecurityFinding]] = None
    ): BatchImportFindingsRequest =
      BatchImportFindingsRequest
        .builder
        .ifSome(findings)(_.findings(_))
        .build

    def batchImportFindingsResponse(
      failedCount: Option[Int] = None,
      successCount: Option[Int] = None,
      failedFindings: Option[List[ImportFindingsError]] = None
    ): BatchImportFindingsResponse =
      BatchImportFindingsResponse
        .builder
        .ifSome(failedCount)(_.failedCount(_))
        .ifSome(successCount)(_.successCount(_))
        .ifSome(failedFindings)(_.failedFindings(_))
        .build

    def batchUpdateFindingsRequest(
      findingIdentifiers: Option[List[AwsSecurityFindingIdentifier]] = None,
      note: Option[NoteUpdate] = None,
      severity: Option[SeverityUpdate] = None,
      verificationState: Option[String] = None,
      confidence: Option[Int] = None,
      criticality: Option[Int] = None,
      types: Option[List[NonEmptyString]] = None,
      userDefinedFields: Option[FieldMap] = None,
      workflow: Option[WorkflowUpdate] = None,
      relatedFindings: Option[List[RelatedFinding]] = None
    ): BatchUpdateFindingsRequest =
      BatchUpdateFindingsRequest
        .builder
        .ifSome(findingIdentifiers)(_.findingIdentifiers(_))
        .ifSome(note)(_.note(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(verificationState)(_.verificationState(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(criticality)(_.criticality(_))
        .ifSome(types)(_.types(_))
        .ifSome(userDefinedFields)(_.userDefinedFields(_))
        .ifSome(workflow)(_.workflow(_))
        .ifSome(relatedFindings)(_.relatedFindings(_))
        .build

    def batchUpdateFindingsResponse(
      processedFindings: Option[List[AwsSecurityFindingIdentifier]] = None,
      unprocessedFindings: Option[List[BatchUpdateFindingsUnprocessedFinding]] = None
    ): BatchUpdateFindingsResponse =
      BatchUpdateFindingsResponse
        .builder
        .ifSome(processedFindings)(_.processedFindings(_))
        .ifSome(unprocessedFindings)(_.unprocessedFindings(_))
        .build

    def batchUpdateFindingsUnprocessedFinding(
      findingIdentifier: Option[AwsSecurityFindingIdentifier] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchUpdateFindingsUnprocessedFinding =
      BatchUpdateFindingsUnprocessedFinding
        .builder
        .ifSome(findingIdentifier)(_.findingIdentifier(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def cell(
      column: Option[Long] = None,
      row: Option[Long] = None,
      columnName: Option[String] = None,
      cellReference: Option[String] = None
    ): Cell =
      Cell
        .builder
        .ifSome(column)(_.column(_))
        .ifSome(row)(_.row(_))
        .ifSome(columnName)(_.columnName(_))
        .ifSome(cellReference)(_.cellReference(_))
        .build

    def cidrBlockAssociation(
      associationId: Option[String] = None,
      cidrBlock: Option[String] = None,
      cidrBlockState: Option[String] = None
    ): CidrBlockAssociation =
      CidrBlockAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(cidrBlockState)(_.cidrBlockState(_))
        .build

    def city(
      cityName: Option[String] = None
    ): City =
      City
        .builder
        .ifSome(cityName)(_.cityName(_))
        .build

    def classificationStatus(
      code: Option[String] = None,
      reason: Option[String] = None
    ): ClassificationStatus =
      ClassificationStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(reason)(_.reason(_))
        .build

    def compliance(
      status: Option[String] = None,
      relatedRequirements: Option[List[NonEmptyString]] = None,
      statusReasons: Option[List[StatusReason]] = None
    ): Compliance =
      Compliance
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(relatedRequirements)(_.relatedRequirements(_))
        .ifSome(statusReasons)(_.statusReasons(_))
        .build

    def containerDetails(
      name: Option[String] = None,
      imageId: Option[String] = None,
      imageName: Option[String] = None,
      launchedAt: Option[String] = None
    ): ContainerDetails =
      ContainerDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(launchedAt)(_.launchedAt(_))
        .build

    def country(
      countryCode: Option[String] = None,
      countryName: Option[String] = None
    ): Country =
      Country
        .builder
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(countryName)(_.countryName(_))
        .build

    def createActionTargetRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      id: Option[String] = None
    ): CreateActionTargetRequest =
      CreateActionTargetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .build

    def createActionTargetResponse(
      actionTargetArn: Option[String] = None
    ): CreateActionTargetResponse =
      CreateActionTargetResponse
        .builder
        .ifSome(actionTargetArn)(_.actionTargetArn(_))
        .build

    def createInsightRequest(
      name: Option[String] = None,
      filters: Option[AwsSecurityFindingFilters] = None,
      groupByAttribute: Option[String] = None
    ): CreateInsightRequest =
      CreateInsightRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupByAttribute)(_.groupByAttribute(_))
        .build

    def createInsightResponse(
      insightArn: Option[String] = None
    ): CreateInsightResponse =
      CreateInsightResponse
        .builder
        .ifSome(insightArn)(_.insightArn(_))
        .build

    def createMembersRequest(
      accountDetails: Option[List[AccountDetails]] = None
    ): CreateMembersRequest =
      CreateMembersRequest
        .builder
        .ifSome(accountDetails)(_.accountDetails(_))
        .build

    def createMembersResponse(
      unprocessedAccounts: Option[List[Result]] = None
    ): CreateMembersResponse =
      CreateMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def customDataIdentifiersDetections(
      count: Option[Long] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      occurrences: Option[Occurrences] = None
    ): CustomDataIdentifiersDetections =
      CustomDataIdentifiersDetections
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(occurrences)(_.occurrences(_))
        .build

    def cvss(
      version: Option[String] = None,
      baseScore: Option[Double] = None,
      baseVector: Option[String] = None
    ): Cvss =
      Cvss
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(baseScore)(_.baseScore(_))
        .ifSome(baseVector)(_.baseVector(_))
        .build

    def dataClassificationDetails(
      detailedResultsLocation: Option[String] = None,
      result: Option[ClassificationResult] = None
    ): DataClassificationDetails =
      DataClassificationDetails
        .builder
        .ifSome(detailedResultsLocation)(_.detailedResultsLocation(_))
        .ifSome(result)(_.result(_))
        .build

    def dateFilter(
      start: Option[String] = None,
      end: Option[String] = None,
      dateRange: Option[DateRange] = None
    ): DateFilter =
      DateFilter
        .builder
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .ifSome(dateRange)(_.dateRange(_))
        .build

    def dateRange(
      value: Option[Int] = None,
      unit: Option[String] = None
    ): DateRange =
      DateRange
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(unit)(_.unit(_))
        .build

    def declineInvitationsRequest(
      accountIds: Option[List[NonEmptyString]] = None
    ): DeclineInvitationsRequest =
      DeclineInvitationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def declineInvitationsResponse(
      unprocessedAccounts: Option[List[Result]] = None
    ): DeclineInvitationsResponse =
      DeclineInvitationsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def deleteActionTargetRequest(
      actionTargetArn: Option[String] = None
    ): DeleteActionTargetRequest =
      DeleteActionTargetRequest
        .builder
        .ifSome(actionTargetArn)(_.actionTargetArn(_))
        .build

    def deleteActionTargetResponse(
      actionTargetArn: Option[String] = None
    ): DeleteActionTargetResponse =
      DeleteActionTargetResponse
        .builder
        .ifSome(actionTargetArn)(_.actionTargetArn(_))
        .build

    def deleteInsightRequest(
      insightArn: Option[String] = None
    ): DeleteInsightRequest =
      DeleteInsightRequest
        .builder
        .ifSome(insightArn)(_.insightArn(_))
        .build

    def deleteInsightResponse(
      insightArn: Option[String] = None
    ): DeleteInsightResponse =
      DeleteInsightResponse
        .builder
        .ifSome(insightArn)(_.insightArn(_))
        .build

    def deleteInvitationsRequest(
      accountIds: Option[List[NonEmptyString]] = None
    ): DeleteInvitationsRequest =
      DeleteInvitationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def deleteInvitationsResponse(
      unprocessedAccounts: Option[List[Result]] = None
    ): DeleteInvitationsResponse =
      DeleteInvitationsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def deleteMembersRequest(
      accountIds: Option[List[NonEmptyString]] = None
    ): DeleteMembersRequest =
      DeleteMembersRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def deleteMembersResponse(
      unprocessedAccounts: Option[List[Result]] = None
    ): DeleteMembersResponse =
      DeleteMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def describeActionTargetsRequest(
      actionTargetArns: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeActionTargetsRequest =
      DescribeActionTargetsRequest
        .builder
        .ifSome(actionTargetArns)(_.actionTargetArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeActionTargetsResponse(
      actionTargets: Option[List[ActionTarget]] = None,
      nextToken: Option[String] = None
    ): DescribeActionTargetsResponse =
      DescribeActionTargetsResponse
        .builder
        .ifSome(actionTargets)(_.actionTargets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeHubRequest(
      hubArn: Option[String] = None
    ): DescribeHubRequest =
      DescribeHubRequest
        .builder
        .ifSome(hubArn)(_.hubArn(_))
        .build

    def describeHubResponse(
      hubArn: Option[String] = None,
      subscribedAt: Option[String] = None,
      autoEnableControls: Option[Boolean] = None
    ): DescribeHubResponse =
      DescribeHubResponse
        .builder
        .ifSome(hubArn)(_.hubArn(_))
        .ifSome(subscribedAt)(_.subscribedAt(_))
        .ifSome(autoEnableControls)(_.autoEnableControls(_))
        .build

    def describeOrganizationConfigurationRequest(

    ): DescribeOrganizationConfigurationRequest =
      DescribeOrganizationConfigurationRequest
        .builder

        .build

    def describeOrganizationConfigurationResponse(
      autoEnable: Option[Boolean] = None,
      memberAccountLimitReached: Option[Boolean] = None
    ): DescribeOrganizationConfigurationResponse =
      DescribeOrganizationConfigurationResponse
        .builder
        .ifSome(autoEnable)(_.autoEnable(_))
        .ifSome(memberAccountLimitReached)(_.memberAccountLimitReached(_))
        .build

    def describeProductsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      productArn: Option[String] = None
    ): DescribeProductsRequest =
      DescribeProductsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(productArn)(_.productArn(_))
        .build

    def describeProductsResponse(
      products: Option[List[Product]] = None,
      nextToken: Option[String] = None
    ): DescribeProductsResponse =
      DescribeProductsResponse
        .builder
        .ifSome(products)(_.products(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeStandardsControlsRequest(
      standardsSubscriptionArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeStandardsControlsRequest =
      DescribeStandardsControlsRequest
        .builder
        .ifSome(standardsSubscriptionArn)(_.standardsSubscriptionArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeStandardsControlsResponse(
      controls: Option[List[StandardsControl]] = None,
      nextToken: Option[String] = None
    ): DescribeStandardsControlsResponse =
      DescribeStandardsControlsResponse
        .builder
        .ifSome(controls)(_.controls(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeStandardsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeStandardsRequest =
      DescribeStandardsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeStandardsResponse(
      standards: Option[List[Standard]] = None,
      nextToken: Option[String] = None
    ): DescribeStandardsResponse =
      DescribeStandardsResponse
        .builder
        .ifSome(standards)(_.standards(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def disableImportFindingsForProductRequest(
      productSubscriptionArn: Option[String] = None
    ): DisableImportFindingsForProductRequest =
      DisableImportFindingsForProductRequest
        .builder
        .ifSome(productSubscriptionArn)(_.productSubscriptionArn(_))
        .build

    def disableImportFindingsForProductResponse(

    ): DisableImportFindingsForProductResponse =
      DisableImportFindingsForProductResponse
        .builder

        .build

    def disableOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None
    ): DisableOrganizationAdminAccountRequest =
      DisableOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .build

    def disableOrganizationAdminAccountResponse(

    ): DisableOrganizationAdminAccountResponse =
      DisableOrganizationAdminAccountResponse
        .builder

        .build

    def disableSecurityHubRequest(

    ): DisableSecurityHubRequest =
      DisableSecurityHubRequest
        .builder

        .build

    def disableSecurityHubResponse(

    ): DisableSecurityHubResponse =
      DisableSecurityHubResponse
        .builder

        .build

    def disassociateFromAdministratorAccountRequest(

    ): DisassociateFromAdministratorAccountRequest =
      DisassociateFromAdministratorAccountRequest
        .builder

        .build

    def disassociateFromAdministratorAccountResponse(

    ): DisassociateFromAdministratorAccountResponse =
      DisassociateFromAdministratorAccountResponse
        .builder

        .build

    def disassociateFromMasterAccountRequest(

    ): DisassociateFromMasterAccountRequest =
      DisassociateFromMasterAccountRequest
        .builder

        .build

    def disassociateFromMasterAccountResponse(

    ): DisassociateFromMasterAccountResponse =
      DisassociateFromMasterAccountResponse
        .builder

        .build

    def disassociateMembersRequest(
      accountIds: Option[List[NonEmptyString]] = None
    ): DisassociateMembersRequest =
      DisassociateMembersRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def disassociateMembersResponse(

    ): DisassociateMembersResponse =
      DisassociateMembersResponse
        .builder

        .build

    def dnsRequestAction(
      domain: Option[String] = None,
      protocol: Option[String] = None,
      blocked: Option[Boolean] = None
    ): DnsRequestAction =
      DnsRequestAction
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(blocked)(_.blocked(_))
        .build

    def enableImportFindingsForProductRequest(
      productArn: Option[String] = None
    ): EnableImportFindingsForProductRequest =
      EnableImportFindingsForProductRequest
        .builder
        .ifSome(productArn)(_.productArn(_))
        .build

    def enableImportFindingsForProductResponse(
      productSubscriptionArn: Option[String] = None
    ): EnableImportFindingsForProductResponse =
      EnableImportFindingsForProductResponse
        .builder
        .ifSome(productSubscriptionArn)(_.productSubscriptionArn(_))
        .build

    def enableOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None
    ): EnableOrganizationAdminAccountRequest =
      EnableOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .build

    def enableOrganizationAdminAccountResponse(

    ): EnableOrganizationAdminAccountResponse =
      EnableOrganizationAdminAccountResponse
        .builder

        .build

    def enableSecurityHubRequest(
      tags: Option[TagMap] = None,
      enableDefaultStandards: Option[Boolean] = None
    ): EnableSecurityHubRequest =
      EnableSecurityHubRequest
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(enableDefaultStandards)(_.enableDefaultStandards(_))
        .build

    def enableSecurityHubResponse(

    ): EnableSecurityHubResponse =
      EnableSecurityHubResponse
        .builder

        .build

    def findingProviderFields(
      confidence: Option[Int] = None,
      criticality: Option[Int] = None,
      relatedFindings: Option[List[RelatedFinding]] = None,
      severity: Option[FindingProviderSeverity] = None,
      types: Option[List[NonEmptyString]] = None
    ): FindingProviderFields =
      FindingProviderFields
        .builder
        .ifSome(confidence)(_.confidence(_))
        .ifSome(criticality)(_.criticality(_))
        .ifSome(relatedFindings)(_.relatedFindings(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(types)(_.types(_))
        .build

    def findingProviderSeverity(
      label: Option[String] = None,
      original: Option[String] = None
    ): FindingProviderSeverity =
      FindingProviderSeverity
        .builder
        .ifSome(label)(_.label(_))
        .ifSome(original)(_.original(_))
        .build

    def geoLocation(
      lon: Option[Double] = None,
      lat: Option[Double] = None
    ): GeoLocation =
      GeoLocation
        .builder
        .ifSome(lon)(_.lon(_))
        .ifSome(lat)(_.lat(_))
        .build

    def getAdministratorAccountRequest(

    ): GetAdministratorAccountRequest =
      GetAdministratorAccountRequest
        .builder

        .build

    def getAdministratorAccountResponse(
      administrator: Option[Invitation] = None
    ): GetAdministratorAccountResponse =
      GetAdministratorAccountResponse
        .builder
        .ifSome(administrator)(_.administrator(_))
        .build

    def getEnabledStandardsRequest(
      standardsSubscriptionArns: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEnabledStandardsRequest =
      GetEnabledStandardsRequest
        .builder
        .ifSome(standardsSubscriptionArns)(_.standardsSubscriptionArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getEnabledStandardsResponse(
      standardsSubscriptions: Option[List[StandardsSubscription]] = None,
      nextToken: Option[String] = None
    ): GetEnabledStandardsResponse =
      GetEnabledStandardsResponse
        .builder
        .ifSome(standardsSubscriptions)(_.standardsSubscriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getFindingsRequest(
      filters: Option[AwsSecurityFindingFilters] = None,
      sortCriteria: Option[List[SortCriterion]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetFindingsRequest =
      GetFindingsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getFindingsResponse(
      findings: Option[List[AwsSecurityFinding]] = None,
      nextToken: Option[String] = None
    ): GetFindingsResponse =
      GetFindingsResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getInsightResultsRequest(
      insightArn: Option[String] = None
    ): GetInsightResultsRequest =
      GetInsightResultsRequest
        .builder
        .ifSome(insightArn)(_.insightArn(_))
        .build

    def getInsightResultsResponse(
      insightResults: Option[InsightResults] = None
    ): GetInsightResultsResponse =
      GetInsightResultsResponse
        .builder
        .ifSome(insightResults)(_.insightResults(_))
        .build

    def getInsightsRequest(
      insightArns: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetInsightsRequest =
      GetInsightsRequest
        .builder
        .ifSome(insightArns)(_.insightArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getInsightsResponse(
      insights: Option[List[Insight]] = None,
      nextToken: Option[String] = None
    ): GetInsightsResponse =
      GetInsightsResponse
        .builder
        .ifSome(insights)(_.insights(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getInvitationsCountRequest(

    ): GetInvitationsCountRequest =
      GetInvitationsCountRequest
        .builder

        .build

    def getInvitationsCountResponse(
      invitationsCount: Option[Int] = None
    ): GetInvitationsCountResponse =
      GetInvitationsCountResponse
        .builder
        .ifSome(invitationsCount)(_.invitationsCount(_))
        .build

    def getMasterAccountRequest(

    ): GetMasterAccountRequest =
      GetMasterAccountRequest
        .builder

        .build

    def getMasterAccountResponse(
      master: Option[Invitation] = None
    ): GetMasterAccountResponse =
      GetMasterAccountResponse
        .builder
        .ifSome(master)(_.master(_))
        .build

    def getMembersRequest(
      accountIds: Option[List[NonEmptyString]] = None
    ): GetMembersRequest =
      GetMembersRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def getMembersResponse(
      members: Option[List[Member]] = None,
      unprocessedAccounts: Option[List[Result]] = None
    ): GetMembersResponse =
      GetMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def icmpTypeCode(
      code: Option[Int] = None,
      `type`: Option[Int] = None
    ): IcmpTypeCode =
      IcmpTypeCode
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def importFindingsError(
      id: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): ImportFindingsError =
      ImportFindingsError
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def insight(
      insightArn: Option[String] = None,
      name: Option[String] = None,
      filters: Option[AwsSecurityFindingFilters] = None,
      groupByAttribute: Option[String] = None
    ): Insight =
      Insight
        .builder
        .ifSome(insightArn)(_.insightArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupByAttribute)(_.groupByAttribute(_))
        .build

    def insightResultValue(
      groupByAttributeValue: Option[String] = None,
      count: Option[Int] = None
    ): InsightResultValue =
      InsightResultValue
        .builder
        .ifSome(groupByAttributeValue)(_.groupByAttributeValue(_))
        .ifSome(count)(_.count(_))
        .build

    def insightResults(
      insightArn: Option[String] = None,
      groupByAttribute: Option[String] = None,
      resultValues: Option[List[InsightResultValue]] = None
    ): InsightResults =
      InsightResults
        .builder
        .ifSome(insightArn)(_.insightArn(_))
        .ifSome(groupByAttribute)(_.groupByAttribute(_))
        .ifSome(resultValues)(_.resultValues(_))
        .build

    def internalException(
      message: Option[String] = None,
      code: Option[String] = None
    ): InternalException =
      InternalException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def invalidAccessException(
      message: Option[String] = None,
      code: Option[String] = None
    ): InvalidAccessException =
      InvalidAccessException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def invalidInputException(
      message: Option[String] = None,
      code: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def invitation(
      accountId: Option[String] = None,
      invitationId: Option[String] = None,
      invitedAt: Option[Timestamp] = None,
      memberStatus: Option[String] = None
    ): Invitation =
      Invitation
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .ifSome(memberStatus)(_.memberStatus(_))
        .build

    def inviteMembersRequest(
      accountIds: Option[List[NonEmptyString]] = None
    ): InviteMembersRequest =
      InviteMembersRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def inviteMembersResponse(
      unprocessedAccounts: Option[List[Result]] = None
    ): InviteMembersResponse =
      InviteMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def ipFilter(
      cidr: Option[String] = None
    ): IpFilter =
      IpFilter
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def ipOrganizationDetails(
      asn: Option[Int] = None,
      asnOrg: Option[String] = None,
      isp: Option[String] = None,
      org: Option[String] = None
    ): IpOrganizationDetails =
      IpOrganizationDetails
        .builder
        .ifSome(asn)(_.asn(_))
        .ifSome(asnOrg)(_.asnOrg(_))
        .ifSome(isp)(_.isp(_))
        .ifSome(org)(_.org(_))
        .build

    def ipv6CidrBlockAssociation(
      associationId: Option[String] = None,
      ipv6CidrBlock: Option[String] = None,
      cidrBlockState: Option[String] = None
    ): Ipv6CidrBlockAssociation =
      Ipv6CidrBlockAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(ipv6CidrBlock)(_.ipv6CidrBlock(_))
        .ifSome(cidrBlockState)(_.cidrBlockState(_))
        .build

    def keywordFilter(
      value: Option[String] = None
    ): KeywordFilter =
      KeywordFilter
        .builder
        .ifSome(value)(_.value(_))
        .build

    def limitExceededException(
      message: Option[String] = None,
      code: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def listEnabledProductsForImportRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEnabledProductsForImportRequest =
      ListEnabledProductsForImportRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEnabledProductsForImportResponse(
      productSubscriptions: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None
    ): ListEnabledProductsForImportResponse =
      ListEnabledProductsForImportResponse
        .builder
        .ifSome(productSubscriptions)(_.productSubscriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInvitationsRequest =
      ListInvitationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsResponse(
      invitations: Option[List[Invitation]] = None,
      nextToken: Option[String] = None
    ): ListInvitationsResponse =
      ListInvitationsResponse
        .builder
        .ifSome(invitations)(_.invitations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMembersRequest(
      onlyAssociated: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMembersRequest =
      ListMembersRequest
        .builder
        .ifSome(onlyAssociated)(_.onlyAssociated(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMembersResponse(
      members: Option[List[Member]] = None,
      nextToken: Option[String] = None
    ): ListMembersResponse =
      ListMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOrganizationAdminAccountsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOrganizationAdminAccountsRequest =
      ListOrganizationAdminAccountsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOrganizationAdminAccountsResponse(
      adminAccounts: Option[List[AdminAccount]] = None,
      nextToken: Option[String] = None
    ): ListOrganizationAdminAccountsResponse =
      ListOrganizationAdminAccountsResponse
        .builder
        .ifSome(adminAccounts)(_.adminAccounts(_))
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

    def loadBalancerState(
      code: Option[String] = None,
      reason: Option[String] = None
    ): LoadBalancerState =
      LoadBalancerState
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(reason)(_.reason(_))
        .build

    def malware(
      name: Option[String] = None,
      `type`: Option[String] = None,
      path: Option[String] = None,
      state: Option[String] = None
    ): Malware =
      Malware
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(path)(_.path(_))
        .ifSome(state)(_.state(_))
        .build

    def mapFilter(
      key: Option[String] = None,
      value: Option[String] = None,
      comparison: Option[String] = None
    ): MapFilter =
      MapFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(comparison)(_.comparison(_))
        .build

    def member(
      accountId: Option[String] = None,
      email: Option[String] = None,
      masterId: Option[String] = None,
      administratorId: Option[String] = None,
      memberStatus: Option[String] = None,
      invitedAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None
    ): Member =
      Member
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(email)(_.email(_))
        .ifSome(masterId)(_.masterId(_))
        .ifSome(administratorId)(_.administratorId(_))
        .ifSome(memberStatus)(_.memberStatus(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def network(
      direction: Option[String] = None,
      protocol: Option[String] = None,
      openPortRange: Option[PortRange] = None,
      sourceIpV4: Option[String] = None,
      sourceIpV6: Option[String] = None,
      sourcePort: Option[Int] = None,
      sourceDomain: Option[String] = None,
      sourceMac: Option[String] = None,
      destinationIpV4: Option[String] = None,
      destinationIpV6: Option[String] = None,
      destinationPort: Option[Int] = None,
      destinationDomain: Option[String] = None
    ): Network =
      Network
        .builder
        .ifSome(direction)(_.direction(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(openPortRange)(_.openPortRange(_))
        .ifSome(sourceIpV4)(_.sourceIpV4(_))
        .ifSome(sourceIpV6)(_.sourceIpV6(_))
        .ifSome(sourcePort)(_.sourcePort(_))
        .ifSome(sourceDomain)(_.sourceDomain(_))
        .ifSome(sourceMac)(_.sourceMac(_))
        .ifSome(destinationIpV4)(_.destinationIpV4(_))
        .ifSome(destinationIpV6)(_.destinationIpV6(_))
        .ifSome(destinationPort)(_.destinationPort(_))
        .ifSome(destinationDomain)(_.destinationDomain(_))
        .build

    def networkConnectionAction(
      connectionDirection: Option[String] = None,
      remoteIpDetails: Option[ActionRemoteIpDetails] = None,
      remotePortDetails: Option[ActionRemotePortDetails] = None,
      localPortDetails: Option[ActionLocalPortDetails] = None,
      protocol: Option[String] = None,
      blocked: Option[Boolean] = None
    ): NetworkConnectionAction =
      NetworkConnectionAction
        .builder
        .ifSome(connectionDirection)(_.connectionDirection(_))
        .ifSome(remoteIpDetails)(_.remoteIpDetails(_))
        .ifSome(remotePortDetails)(_.remotePortDetails(_))
        .ifSome(localPortDetails)(_.localPortDetails(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(blocked)(_.blocked(_))
        .build

    def networkHeader(
      protocol: Option[String] = None,
      destination: Option[NetworkPathComponentDetails] = None,
      source: Option[NetworkPathComponentDetails] = None
    ): NetworkHeader =
      NetworkHeader
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(source)(_.source(_))
        .build

    def networkPathComponent(
      componentId: Option[String] = None,
      componentType: Option[String] = None,
      egress: Option[NetworkHeader] = None,
      ingress: Option[NetworkHeader] = None
    ): NetworkPathComponent =
      NetworkPathComponent
        .builder
        .ifSome(componentId)(_.componentId(_))
        .ifSome(componentType)(_.componentType(_))
        .ifSome(egress)(_.egress(_))
        .ifSome(ingress)(_.ingress(_))
        .build

    def networkPathComponentDetails(
      address: Option[List[NonEmptyString]] = None,
      portRanges: Option[List[PortRange]] = None
    ): NetworkPathComponentDetails =
      NetworkPathComponentDetails
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(portRanges)(_.portRanges(_))
        .build

    def note(
      text: Option[String] = None,
      updatedBy: Option[String] = None,
      updatedAt: Option[String] = None
    ): Note =
      Note
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(updatedBy)(_.updatedBy(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def noteUpdate(
      text: Option[String] = None,
      updatedBy: Option[String] = None
    ): NoteUpdate =
      NoteUpdate
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(updatedBy)(_.updatedBy(_))
        .build

    def numberFilter(
      gte: Option[Double] = None,
      lte: Option[Double] = None,
      eq: Option[Double] = None
    ): NumberFilter =
      NumberFilter
        .builder
        .ifSome(gte)(_.gte(_))
        .ifSome(lte)(_.lte(_))
        .ifSome(eq)(_.eq(_))
        .build

    def occurrences(
      lineRanges: Option[List[Range]] = None,
      offsetRanges: Option[List[Range]] = None,
      pages: Option[List[Page]] = None,
      records: Option[List[Record]] = None,
      cells: Option[List[Cell]] = None
    ): Occurrences =
      Occurrences
        .builder
        .ifSome(lineRanges)(_.lineRanges(_))
        .ifSome(offsetRanges)(_.offsetRanges(_))
        .ifSome(pages)(_.pages(_))
        .ifSome(records)(_.records(_))
        .ifSome(cells)(_.cells(_))
        .build

    def page(
      pageNumber: Option[Long] = None,
      lineRange: Option[Range] = None,
      offsetRange: Option[Range] = None
    ): Page =
      Page
        .builder
        .ifSome(pageNumber)(_.pageNumber(_))
        .ifSome(lineRange)(_.lineRange(_))
        .ifSome(offsetRange)(_.offsetRange(_))
        .build

    def patchSummary(
      id: Option[String] = None,
      installedCount: Option[Int] = None,
      missingCount: Option[Int] = None,
      failedCount: Option[Int] = None,
      installedOtherCount: Option[Int] = None,
      installedRejectedCount: Option[Int] = None,
      installedPendingReboot: Option[Int] = None,
      operationStartTime: Option[String] = None,
      operationEndTime: Option[String] = None,
      rebootOption: Option[String] = None,
      operation: Option[String] = None
    ): PatchSummary =
      PatchSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(installedCount)(_.installedCount(_))
        .ifSome(missingCount)(_.missingCount(_))
        .ifSome(failedCount)(_.failedCount(_))
        .ifSome(installedOtherCount)(_.installedOtherCount(_))
        .ifSome(installedRejectedCount)(_.installedRejectedCount(_))
        .ifSome(installedPendingReboot)(_.installedPendingReboot(_))
        .ifSome(operationStartTime)(_.operationStartTime(_))
        .ifSome(operationEndTime)(_.operationEndTime(_))
        .ifSome(rebootOption)(_.rebootOption(_))
        .ifSome(operation)(_.operation(_))
        .build

    def portProbeAction(
      portProbeDetails: Option[List[PortProbeDetail]] = None,
      blocked: Option[Boolean] = None
    ): PortProbeAction =
      PortProbeAction
        .builder
        .ifSome(portProbeDetails)(_.portProbeDetails(_))
        .ifSome(blocked)(_.blocked(_))
        .build

    def portProbeDetail(
      localPortDetails: Option[ActionLocalPortDetails] = None,
      localIpDetails: Option[ActionLocalIpDetails] = None,
      remoteIpDetails: Option[ActionRemoteIpDetails] = None
    ): PortProbeDetail =
      PortProbeDetail
        .builder
        .ifSome(localPortDetails)(_.localPortDetails(_))
        .ifSome(localIpDetails)(_.localIpDetails(_))
        .ifSome(remoteIpDetails)(_.remoteIpDetails(_))
        .build

    def portRange(
      begin: Option[Int] = None,
      end: Option[Int] = None
    ): PortRange =
      PortRange
        .builder
        .ifSome(begin)(_.begin(_))
        .ifSome(end)(_.end(_))
        .build

    def portRangeFromTo(
      from: Option[Int] = None,
      to: Option[Int] = None
    ): PortRangeFromTo =
      PortRangeFromTo
        .builder
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .build

    def processDetails(
      name: Option[String] = None,
      path: Option[String] = None,
      pid: Option[Int] = None,
      parentPid: Option[Int] = None,
      launchedAt: Option[String] = None,
      terminatedAt: Option[String] = None
    ): ProcessDetails =
      ProcessDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(path)(_.path(_))
        .ifSome(pid)(_.pid(_))
        .ifSome(parentPid)(_.parentPid(_))
        .ifSome(launchedAt)(_.launchedAt(_))
        .ifSome(terminatedAt)(_.terminatedAt(_))
        .build

    def product(
      productArn: Option[String] = None,
      productName: Option[String] = None,
      companyName: Option[String] = None,
      description: Option[String] = None,
      categories: Option[List[NonEmptyString]] = None,
      integrationTypes: Option[List[IntegrationType]] = None,
      marketplaceUrl: Option[String] = None,
      activationUrl: Option[String] = None,
      productSubscriptionResourcePolicy: Option[String] = None
    ): Product =
      Product
        .builder
        .ifSome(productArn)(_.productArn(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(companyName)(_.companyName(_))
        .ifSome(description)(_.description(_))
        .ifSome(categories)(_.categories(_))
        .ifSome(integrationTypes)(_.integrationTypes(_))
        .ifSome(marketplaceUrl)(_.marketplaceUrl(_))
        .ifSome(activationUrl)(_.activationUrl(_))
        .ifSome(productSubscriptionResourcePolicy)(_.productSubscriptionResourcePolicy(_))
        .build

    def range(
      start: Option[Long] = None,
      end: Option[Long] = None,
      startColumn: Option[Long] = None
    ): Range =
      Range
        .builder
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .ifSome(startColumn)(_.startColumn(_))
        .build

    def recommendation(
      text: Option[String] = None,
      url: Option[String] = None
    ): Recommendation =
      Recommendation
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(url)(_.url(_))
        .build

    def record(
      jsonPath: Option[String] = None,
      recordIndex: Option[Long] = None
    ): Record =
      Record
        .builder
        .ifSome(jsonPath)(_.jsonPath(_))
        .ifSome(recordIndex)(_.recordIndex(_))
        .build

    def relatedFinding(
      productArn: Option[String] = None,
      id: Option[String] = None
    ): RelatedFinding =
      RelatedFinding
        .builder
        .ifSome(productArn)(_.productArn(_))
        .ifSome(id)(_.id(_))
        .build

    def remediation(
      recommendation: Option[Recommendation] = None
    ): Remediation =
      Remediation
        .builder
        .ifSome(recommendation)(_.recommendation(_))
        .build

    def resource(
      `type`: Option[String] = None,
      id: Option[String] = None,
      partition: Option[String] = None,
      region: Option[String] = None,
      resourceRole: Option[String] = None,
      tags: Option[FieldMap] = None,
      dataClassification: Option[DataClassificationDetails] = None,
      details: Option[ResourceDetails] = None
    ): Resource =
      Resource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(partition)(_.partition(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourceRole)(_.resourceRole(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(dataClassification)(_.dataClassification(_))
        .ifSome(details)(_.details(_))
        .build

    def resourceConflictException(
      message: Option[String] = None,
      code: Option[String] = None
    ): ResourceConflictException =
      ResourceConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def resourceDetails(
      awsAutoScalingAutoScalingGroup: Option[AwsAutoScalingAutoScalingGroupDetails] = None,
      awsCodeBuildProject: Option[AwsCodeBuildProjectDetails] = None,
      awsCloudFrontDistribution: Option[AwsCloudFrontDistributionDetails] = None,
      awsEc2Instance: Option[AwsEc2InstanceDetails] = None,
      awsEc2NetworkInterface: Option[AwsEc2NetworkInterfaceDetails] = None,
      awsEc2SecurityGroup: Option[AwsEc2SecurityGroupDetails] = None,
      awsEc2Volume: Option[AwsEc2VolumeDetails] = None,
      awsEc2Vpc: Option[AwsEc2VpcDetails] = None,
      awsEc2Eip: Option[AwsEc2EipDetails] = None,
      awsEc2Subnet: Option[AwsEc2SubnetDetails] = None,
      awsEc2NetworkAcl: Option[AwsEc2NetworkAclDetails] = None,
      awsElbv2LoadBalancer: Option[AwsElbv2LoadBalancerDetails] = None,
      awsElasticBeanstalkEnvironment: Option[AwsElasticBeanstalkEnvironmentDetails] = None,
      awsElasticsearchDomain: Option[AwsElasticsearchDomainDetails] = None,
      awsS3Bucket: Option[AwsS3BucketDetails] = None,
      awsS3AccountPublicAccessBlock: Option[AwsS3AccountPublicAccessBlockDetails] = None,
      awsS3Object: Option[AwsS3ObjectDetails] = None,
      awsSecretsManagerSecret: Option[AwsSecretsManagerSecretDetails] = None,
      awsIamAccessKey: Option[AwsIamAccessKeyDetails] = None,
      awsIamUser: Option[AwsIamUserDetails] = None,
      awsIamPolicy: Option[AwsIamPolicyDetails] = None,
      awsApiGatewayV2Stage: Option[AwsApiGatewayV2StageDetails] = None,
      awsApiGatewayV2Api: Option[AwsApiGatewayV2ApiDetails] = None,
      awsDynamoDbTable: Option[AwsDynamoDbTableDetails] = None,
      awsApiGatewayStage: Option[AwsApiGatewayStageDetails] = None,
      awsApiGatewayRestApi: Option[AwsApiGatewayRestApiDetails] = None,
      awsCloudTrailTrail: Option[AwsCloudTrailTrailDetails] = None,
      awsSsmPatchCompliance: Option[AwsSsmPatchComplianceDetails] = None,
      awsCertificateManagerCertificate: Option[AwsCertificateManagerCertificateDetails] = None,
      awsRedshiftCluster: Option[AwsRedshiftClusterDetails] = None,
      awsElbLoadBalancer: Option[AwsElbLoadBalancerDetails] = None,
      awsIamGroup: Option[AwsIamGroupDetails] = None,
      awsIamRole: Option[AwsIamRoleDetails] = None,
      awsKmsKey: Option[AwsKmsKeyDetails] = None,
      awsLambdaFunction: Option[AwsLambdaFunctionDetails] = None,
      awsLambdaLayerVersion: Option[AwsLambdaLayerVersionDetails] = None,
      awsRdsDbInstance: Option[AwsRdsDbInstanceDetails] = None,
      awsSnsTopic: Option[AwsSnsTopicDetails] = None,
      awsSqsQueue: Option[AwsSqsQueueDetails] = None,
      awsWafWebAcl: Option[AwsWafWebAclDetails] = None,
      awsRdsDbSnapshot: Option[AwsRdsDbSnapshotDetails] = None,
      awsRdsDbClusterSnapshot: Option[AwsRdsDbClusterSnapshotDetails] = None,
      awsRdsDbCluster: Option[AwsRdsDbClusterDetails] = None,
      container: Option[ContainerDetails] = None,
      other: Option[FieldMap] = None
    ): ResourceDetails =
      ResourceDetails
        .builder
        .ifSome(awsAutoScalingAutoScalingGroup)(_.awsAutoScalingAutoScalingGroup(_))
        .ifSome(awsCodeBuildProject)(_.awsCodeBuildProject(_))
        .ifSome(awsCloudFrontDistribution)(_.awsCloudFrontDistribution(_))
        .ifSome(awsEc2Instance)(_.awsEc2Instance(_))
        .ifSome(awsEc2NetworkInterface)(_.awsEc2NetworkInterface(_))
        .ifSome(awsEc2SecurityGroup)(_.awsEc2SecurityGroup(_))
        .ifSome(awsEc2Volume)(_.awsEc2Volume(_))
        .ifSome(awsEc2Vpc)(_.awsEc2Vpc(_))
        .ifSome(awsEc2Eip)(_.awsEc2Eip(_))
        .ifSome(awsEc2Subnet)(_.awsEc2Subnet(_))
        .ifSome(awsEc2NetworkAcl)(_.awsEc2NetworkAcl(_))
        .ifSome(awsElbv2LoadBalancer)(_.awsElbv2LoadBalancer(_))
        .ifSome(awsElasticBeanstalkEnvironment)(_.awsElasticBeanstalkEnvironment(_))
        .ifSome(awsElasticsearchDomain)(_.awsElasticsearchDomain(_))
        .ifSome(awsS3Bucket)(_.awsS3Bucket(_))
        .ifSome(awsS3AccountPublicAccessBlock)(_.awsS3AccountPublicAccessBlock(_))
        .ifSome(awsS3Object)(_.awsS3Object(_))
        .ifSome(awsSecretsManagerSecret)(_.awsSecretsManagerSecret(_))
        .ifSome(awsIamAccessKey)(_.awsIamAccessKey(_))
        .ifSome(awsIamUser)(_.awsIamUser(_))
        .ifSome(awsIamPolicy)(_.awsIamPolicy(_))
        .ifSome(awsApiGatewayV2Stage)(_.awsApiGatewayV2Stage(_))
        .ifSome(awsApiGatewayV2Api)(_.awsApiGatewayV2Api(_))
        .ifSome(awsDynamoDbTable)(_.awsDynamoDbTable(_))
        .ifSome(awsApiGatewayStage)(_.awsApiGatewayStage(_))
        .ifSome(awsApiGatewayRestApi)(_.awsApiGatewayRestApi(_))
        .ifSome(awsCloudTrailTrail)(_.awsCloudTrailTrail(_))
        .ifSome(awsSsmPatchCompliance)(_.awsSsmPatchCompliance(_))
        .ifSome(awsCertificateManagerCertificate)(_.awsCertificateManagerCertificate(_))
        .ifSome(awsRedshiftCluster)(_.awsRedshiftCluster(_))
        .ifSome(awsElbLoadBalancer)(_.awsElbLoadBalancer(_))
        .ifSome(awsIamGroup)(_.awsIamGroup(_))
        .ifSome(awsIamRole)(_.awsIamRole(_))
        .ifSome(awsKmsKey)(_.awsKmsKey(_))
        .ifSome(awsLambdaFunction)(_.awsLambdaFunction(_))
        .ifSome(awsLambdaLayerVersion)(_.awsLambdaLayerVersion(_))
        .ifSome(awsRdsDbInstance)(_.awsRdsDbInstance(_))
        .ifSome(awsSnsTopic)(_.awsSnsTopic(_))
        .ifSome(awsSqsQueue)(_.awsSqsQueue(_))
        .ifSome(awsWafWebAcl)(_.awsWafWebAcl(_))
        .ifSome(awsRdsDbSnapshot)(_.awsRdsDbSnapshot(_))
        .ifSome(awsRdsDbClusterSnapshot)(_.awsRdsDbClusterSnapshot(_))
        .ifSome(awsRdsDbCluster)(_.awsRdsDbCluster(_))
        .ifSome(container)(_.container(_))
        .ifSome(other)(_.other(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      code: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def sensitiveDataDetections(
      count: Option[Long] = None,
      `type`: Option[String] = None,
      occurrences: Option[Occurrences] = None
    ): SensitiveDataDetections =
      SensitiveDataDetections
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(occurrences)(_.occurrences(_))
        .build

    def severity(
      product: Option[Double] = None,
      label: Option[String] = None,
      normalized: Option[Int] = None,
      original: Option[String] = None
    ): Severity =
      Severity
        .builder
        .ifSome(product)(_.product(_))
        .ifSome(label)(_.label(_))
        .ifSome(normalized)(_.normalized(_))
        .ifSome(original)(_.original(_))
        .build

    def severityUpdate(
      normalized: Option[Int] = None,
      product: Option[Double] = None,
      label: Option[String] = None
    ): SeverityUpdate =
      SeverityUpdate
        .builder
        .ifSome(normalized)(_.normalized(_))
        .ifSome(product)(_.product(_))
        .ifSome(label)(_.label(_))
        .build

    def softwarePackage(
      name: Option[String] = None,
      version: Option[String] = None,
      epoch: Option[String] = None,
      release: Option[String] = None,
      architecture: Option[String] = None
    ): SoftwarePackage =
      SoftwarePackage
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(epoch)(_.epoch(_))
        .ifSome(release)(_.release(_))
        .ifSome(architecture)(_.architecture(_))
        .build

    def sortCriterion(
      field: Option[String] = None,
      sortOrder: Option[String] = None
    ): SortCriterion =
      SortCriterion
        .builder
        .ifSome(field)(_.field(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def standard(
      standardsArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      enabledByDefault: Option[Boolean] = None
    ): Standard =
      Standard
        .builder
        .ifSome(standardsArn)(_.standardsArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(enabledByDefault)(_.enabledByDefault(_))
        .build

    def standardsControl(
      standardsControlArn: Option[String] = None,
      controlStatus: Option[String] = None,
      disabledReason: Option[String] = None,
      controlStatusUpdatedAt: Option[Timestamp] = None,
      controlId: Option[String] = None,
      title: Option[String] = None,
      description: Option[String] = None,
      remediationUrl: Option[String] = None,
      severityRating: Option[String] = None,
      relatedRequirements: Option[List[NonEmptyString]] = None
    ): StandardsControl =
      StandardsControl
        .builder
        .ifSome(standardsControlArn)(_.standardsControlArn(_))
        .ifSome(controlStatus)(_.controlStatus(_))
        .ifSome(disabledReason)(_.disabledReason(_))
        .ifSome(controlStatusUpdatedAt)(_.controlStatusUpdatedAt(_))
        .ifSome(controlId)(_.controlId(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(remediationUrl)(_.remediationUrl(_))
        .ifSome(severityRating)(_.severityRating(_))
        .ifSome(relatedRequirements)(_.relatedRequirements(_))
        .build

    def standardsSubscription(
      standardsSubscriptionArn: Option[String] = None,
      standardsArn: Option[String] = None,
      standardsInput: Option[StandardsInputParameterMap] = None,
      standardsStatus: Option[String] = None
    ): StandardsSubscription =
      StandardsSubscription
        .builder
        .ifSome(standardsSubscriptionArn)(_.standardsSubscriptionArn(_))
        .ifSome(standardsArn)(_.standardsArn(_))
        .ifSome(standardsInput)(_.standardsInput(_))
        .ifSome(standardsStatus)(_.standardsStatus(_))
        .build

    def standardsSubscriptionRequest(
      standardsArn: Option[String] = None,
      standardsInput: Option[StandardsInputParameterMap] = None
    ): StandardsSubscriptionRequest =
      StandardsSubscriptionRequest
        .builder
        .ifSome(standardsArn)(_.standardsArn(_))
        .ifSome(standardsInput)(_.standardsInput(_))
        .build

    def statusReason(
      reasonCode: Option[String] = None,
      description: Option[String] = None
    ): StatusReason =
      StatusReason
        .builder
        .ifSome(reasonCode)(_.reasonCode(_))
        .ifSome(description)(_.description(_))
        .build

    def stringFilter(
      value: Option[String] = None,
      comparison: Option[String] = None
    ): StringFilter =
      StringFilter
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(comparison)(_.comparison(_))
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

    def threatIntelIndicator(
      `type`: Option[String] = None,
      value: Option[String] = None,
      category: Option[String] = None,
      lastObservedAt: Option[String] = None,
      source: Option[String] = None,
      sourceUrl: Option[String] = None
    ): ThreatIntelIndicator =
      ThreatIntelIndicator
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .ifSome(category)(_.category(_))
        .ifSome(lastObservedAt)(_.lastObservedAt(_))
        .ifSome(source)(_.source(_))
        .ifSome(sourceUrl)(_.sourceUrl(_))
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

    def updateActionTargetRequest(
      actionTargetArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateActionTargetRequest =
      UpdateActionTargetRequest
        .builder
        .ifSome(actionTargetArn)(_.actionTargetArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateActionTargetResponse(

    ): UpdateActionTargetResponse =
      UpdateActionTargetResponse
        .builder

        .build

    def updateFindingsRequest(
      filters: Option[AwsSecurityFindingFilters] = None,
      note: Option[NoteUpdate] = None,
      recordState: Option[String] = None
    ): UpdateFindingsRequest =
      UpdateFindingsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(note)(_.note(_))
        .ifSome(recordState)(_.recordState(_))
        .build

    def updateFindingsResponse(

    ): UpdateFindingsResponse =
      UpdateFindingsResponse
        .builder

        .build

    def updateInsightRequest(
      insightArn: Option[String] = None,
      name: Option[String] = None,
      filters: Option[AwsSecurityFindingFilters] = None,
      groupByAttribute: Option[String] = None
    ): UpdateInsightRequest =
      UpdateInsightRequest
        .builder
        .ifSome(insightArn)(_.insightArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupByAttribute)(_.groupByAttribute(_))
        .build

    def updateInsightResponse(

    ): UpdateInsightResponse =
      UpdateInsightResponse
        .builder

        .build

    def updateOrganizationConfigurationRequest(
      autoEnable: Option[Boolean] = None
    ): UpdateOrganizationConfigurationRequest =
      UpdateOrganizationConfigurationRequest
        .builder
        .ifSome(autoEnable)(_.autoEnable(_))
        .build

    def updateOrganizationConfigurationResponse(

    ): UpdateOrganizationConfigurationResponse =
      UpdateOrganizationConfigurationResponse
        .builder

        .build

    def updateSecurityHubConfigurationRequest(
      autoEnableControls: Option[Boolean] = None
    ): UpdateSecurityHubConfigurationRequest =
      UpdateSecurityHubConfigurationRequest
        .builder
        .ifSome(autoEnableControls)(_.autoEnableControls(_))
        .build

    def updateSecurityHubConfigurationResponse(

    ): UpdateSecurityHubConfigurationResponse =
      UpdateSecurityHubConfigurationResponse
        .builder

        .build

    def updateStandardsControlRequest(
      standardsControlArn: Option[String] = None,
      controlStatus: Option[String] = None,
      disabledReason: Option[String] = None
    ): UpdateStandardsControlRequest =
      UpdateStandardsControlRequest
        .builder
        .ifSome(standardsControlArn)(_.standardsControlArn(_))
        .ifSome(controlStatus)(_.controlStatus(_))
        .ifSome(disabledReason)(_.disabledReason(_))
        .build

    def updateStandardsControlResponse(

    ): UpdateStandardsControlResponse =
      UpdateStandardsControlResponse
        .builder

        .build

    def vulnerability(
      id: Option[String] = None,
      vulnerablePackages: Option[List[SoftwarePackage]] = None,
      cvss: Option[List[Cvss]] = None,
      relatedVulnerabilities: Option[List[NonEmptyString]] = None,
      vendor: Option[VulnerabilityVendor] = None,
      referenceUrls: Option[List[NonEmptyString]] = None
    ): Vulnerability =
      Vulnerability
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(vulnerablePackages)(_.vulnerablePackages(_))
        .ifSome(cvss)(_.cvss(_))
        .ifSome(relatedVulnerabilities)(_.relatedVulnerabilities(_))
        .ifSome(vendor)(_.vendor(_))
        .ifSome(referenceUrls)(_.referenceUrls(_))
        .build

    def vulnerabilityVendor(
      name: Option[String] = None,
      url: Option[String] = None,
      vendorSeverity: Option[String] = None,
      vendorCreatedAt: Option[String] = None,
      vendorUpdatedAt: Option[String] = None
    ): VulnerabilityVendor =
      VulnerabilityVendor
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(url)(_.url(_))
        .ifSome(vendorSeverity)(_.vendorSeverity(_))
        .ifSome(vendorCreatedAt)(_.vendorCreatedAt(_))
        .ifSome(vendorUpdatedAt)(_.vendorUpdatedAt(_))
        .build

    def wafAction(
      `type`: Option[String] = None
    ): WafAction =
      WafAction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def wafExcludedRule(
      ruleId: Option[String] = None
    ): WafExcludedRule =
      WafExcludedRule
        .builder
        .ifSome(ruleId)(_.ruleId(_))
        .build

    def wafOverrideAction(
      `type`: Option[String] = None
    ): WafOverrideAction =
      WafOverrideAction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def workflow(
      status: Option[String] = None
    ): Workflow =
      Workflow
        .builder
        .ifSome(status)(_.status(_))
        .build

    def workflowUpdate(
      status: Option[String] = None
    ): WorkflowUpdate =
      WorkflowUpdate
        .builder
        .ifSome(status)(_.status(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
