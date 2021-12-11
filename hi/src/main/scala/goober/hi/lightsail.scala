package goober.hi

import goober.free.lightsail.LightsailIO
import software.amazon.awssdk.services.lightsail.model._


object lightsail {
  import goober.free.{lightsail ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      code: Option[String] = None,
      docs: Option[String] = None,
      message: Option[String] = None,
      tip: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(docs)(_.docs(_))
        .ifSome(message)(_.message(_))
        .ifSome(tip)(_.tip(_))
        .build

    def accountSetupInProgressException(
      code: Option[String] = None,
      docs: Option[String] = None,
      message: Option[String] = None,
      tip: Option[String] = None
    ): AccountSetupInProgressException =
      AccountSetupInProgressException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(docs)(_.docs(_))
        .ifSome(message)(_.message(_))
        .ifSome(tip)(_.tip(_))
        .build

    def addOn(
      name: Option[String] = None,
      status: Option[String] = None,
      snapshotTimeOfDay: Option[String] = None,
      nextSnapshotTimeOfDay: Option[String] = None
    ): AddOn =
      AddOn
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(snapshotTimeOfDay)(_.snapshotTimeOfDay(_))
        .ifSome(nextSnapshotTimeOfDay)(_.nextSnapshotTimeOfDay(_))
        .build

    def addOnRequest(
      addOnType: Option[String] = None,
      autoSnapshotAddOnRequest: Option[AutoSnapshotAddOnRequest] = None
    ): AddOnRequest =
      AddOnRequest
        .builder
        .ifSome(addOnType)(_.addOnType(_))
        .ifSome(autoSnapshotAddOnRequest)(_.autoSnapshotAddOnRequest(_))
        .build

    def alarm(
      name: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      supportCode: Option[String] = None,
      monitoredResourceInfo: Option[MonitoredResourceInfo] = None,
      comparisonOperator: Option[String] = None,
      evaluationPeriods: Option[Int] = None,
      period: Option[Int] = None,
      threshold: Option[double] = None,
      datapointsToAlarm: Option[Int] = None,
      treatMissingData: Option[String] = None,
      statistic: Option[String] = None,
      metricName: Option[String] = None,
      state: Option[String] = None,
      unit: Option[String] = None,
      contactProtocols: Option[List[ContactProtocol]] = None,
      notificationTriggers: Option[List[AlarmState]] = None,
      notificationEnabled: Option[Boolean] = None
    ): Alarm =
      Alarm
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(monitoredResourceInfo)(_.monitoredResourceInfo(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(period)(_.period(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(datapointsToAlarm)(_.datapointsToAlarm(_))
        .ifSome(treatMissingData)(_.treatMissingData(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(state)(_.state(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(contactProtocols)(_.contactProtocols(_))
        .ifSome(notificationTriggers)(_.notificationTriggers(_))
        .ifSome(notificationEnabled)(_.notificationEnabled(_))
        .build

    def allocateStaticIpRequest(
      staticIpName: Option[String] = None
    ): AllocateStaticIpRequest =
      AllocateStaticIpRequest
        .builder
        .ifSome(staticIpName)(_.staticIpName(_))
        .build

    def attachCertificateToDistributionRequest(
      distributionName: Option[String] = None,
      certificateName: Option[String] = None
    ): AttachCertificateToDistributionRequest =
      AttachCertificateToDistributionRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .ifSome(certificateName)(_.certificateName(_))
        .build

    def attachDiskRequest(
      diskName: Option[String] = None,
      instanceName: Option[String] = None,
      diskPath: Option[String] = None
    ): AttachDiskRequest =
      AttachDiskRequest
        .builder
        .ifSome(diskName)(_.diskName(_))
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(diskPath)(_.diskPath(_))
        .build

    def attachInstancesToLoadBalancerRequest(
      loadBalancerName: Option[String] = None,
      instanceNames: Option[List[ResourceName]] = None
    ): AttachInstancesToLoadBalancerRequest =
      AttachInstancesToLoadBalancerRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(instanceNames)(_.instanceNames(_))
        .build

    def attachLoadBalancerTlsCertificateRequest(
      loadBalancerName: Option[String] = None,
      certificateName: Option[String] = None
    ): AttachLoadBalancerTlsCertificateRequest =
      AttachLoadBalancerTlsCertificateRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(certificateName)(_.certificateName(_))
        .build

    def attachStaticIpRequest(
      staticIpName: Option[String] = None,
      instanceName: Option[String] = None
    ): AttachStaticIpRequest =
      AttachStaticIpRequest
        .builder
        .ifSome(staticIpName)(_.staticIpName(_))
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def attachedDisk(
      path: Option[String] = None,
      sizeInGb: Option[Int] = None
    ): AttachedDisk =
      AttachedDisk
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .build

    def autoSnapshotAddOnRequest(
      snapshotTimeOfDay: Option[String] = None
    ): AutoSnapshotAddOnRequest =
      AutoSnapshotAddOnRequest
        .builder
        .ifSome(snapshotTimeOfDay)(_.snapshotTimeOfDay(_))
        .build

    def autoSnapshotDetails(
      date: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      status: Option[String] = None,
      fromAttachedDisks: Option[List[AttachedDisk]] = None
    ): AutoSnapshotDetails =
      AutoSnapshotDetails
        .builder
        .ifSome(date)(_.date(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(fromAttachedDisks)(_.fromAttachedDisks(_))
        .build

    def availabilityZone(
      zoneName: Option[String] = None,
      state: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(zoneName)(_.zoneName(_))
        .ifSome(state)(_.state(_))
        .build

    def blueprint(
      blueprintId: Option[String] = None,
      name: Option[String] = None,
      group: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      isActive: Option[Boolean] = None,
      minPower: Option[Int] = None,
      version: Option[String] = None,
      versionCode: Option[String] = None,
      productUrl: Option[String] = None,
      licenseUrl: Option[String] = None,
      platform: Option[String] = None
    ): Blueprint =
      Blueprint
        .builder
        .ifSome(blueprintId)(_.blueprintId(_))
        .ifSome(name)(_.name(_))
        .ifSome(group)(_.group(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(isActive)(_.isActive(_))
        .ifSome(minPower)(_.minPower(_))
        .ifSome(version)(_.version(_))
        .ifSome(versionCode)(_.versionCode(_))
        .ifSome(productUrl)(_.productUrl(_))
        .ifSome(licenseUrl)(_.licenseUrl(_))
        .ifSome(platform)(_.platform(_))
        .build

    def bundle(
      price: Option[float] = None,
      cpuCount: Option[Int] = None,
      diskSizeInGb: Option[Int] = None,
      bundleId: Option[String] = None,
      instanceType: Option[String] = None,
      isActive: Option[Boolean] = None,
      name: Option[String] = None,
      power: Option[Int] = None,
      ramSizeInGb: Option[float] = None,
      transferPerMonthInGb: Option[Int] = None,
      supportedPlatforms: Option[List[InstancePlatform]] = None
    ): Bundle =
      Bundle
        .builder
        .ifSome(price)(_.price(_))
        .ifSome(cpuCount)(_.cpuCount(_))
        .ifSome(diskSizeInGb)(_.diskSizeInGb(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(isActive)(_.isActive(_))
        .ifSome(name)(_.name(_))
        .ifSome(power)(_.power(_))
        .ifSome(ramSizeInGb)(_.ramSizeInGb(_))
        .ifSome(transferPerMonthInGb)(_.transferPerMonthInGb(_))
        .ifSome(supportedPlatforms)(_.supportedPlatforms(_))
        .build

    def cacheBehavior(
      behavior: Option[String] = None
    ): CacheBehavior =
      CacheBehavior
        .builder
        .ifSome(behavior)(_.behavior(_))
        .build

    def cacheBehaviorPerPath(
      path: Option[String] = None,
      behavior: Option[String] = None
    ): CacheBehaviorPerPath =
      CacheBehaviorPerPath
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(behavior)(_.behavior(_))
        .build

    def cacheSettings(
      defaultTTL: Option[long] = None,
      minimumTTL: Option[long] = None,
      maximumTTL: Option[long] = None,
      allowedHTTPMethods: Option[String] = None,
      cachedHTTPMethods: Option[String] = None,
      forwardedCookies: Option[CookieObject] = None,
      forwardedHeaders: Option[HeaderObject] = None,
      forwardedQueryStrings: Option[QueryStringObject] = None
    ): CacheSettings =
      CacheSettings
        .builder
        .ifSome(defaultTTL)(_.defaultTTL(_))
        .ifSome(minimumTTL)(_.minimumTTL(_))
        .ifSome(maximumTTL)(_.maximumTTL(_))
        .ifSome(allowedHTTPMethods)(_.allowedHTTPMethods(_))
        .ifSome(cachedHTTPMethods)(_.cachedHTTPMethods(_))
        .ifSome(forwardedCookies)(_.forwardedCookies(_))
        .ifSome(forwardedHeaders)(_.forwardedHeaders(_))
        .ifSome(forwardedQueryStrings)(_.forwardedQueryStrings(_))
        .build

    def certificate(
      arn: Option[String] = None,
      name: Option[String] = None,
      domainName: Option[String] = None,
      status: Option[String] = None,
      serialNumber: Option[String] = None,
      subjectAlternativeNames: Option[List[DomainName]] = None,
      domainValidationRecords: Option[List[DomainValidationRecord]] = None,
      requestFailureReason: Option[String] = None,
      inUseResourceCount: Option[Int] = None,
      keyAlgorithm: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      issuedAt: Option[IsoDate] = None,
      issuerCA: Option[String] = None,
      notBefore: Option[IsoDate] = None,
      notAfter: Option[IsoDate] = None,
      eligibleToRenew: Option[String] = None,
      renewalSummary: Option[RenewalSummary] = None,
      revokedAt: Option[IsoDate] = None,
      revocationReason: Option[String] = None,
      tags: Option[List[Tag]] = None,
      supportCode: Option[String] = None
    ): Certificate =
      Certificate
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(status)(_.status(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(domainValidationRecords)(_.domainValidationRecords(_))
        .ifSome(requestFailureReason)(_.requestFailureReason(_))
        .ifSome(inUseResourceCount)(_.inUseResourceCount(_))
        .ifSome(keyAlgorithm)(_.keyAlgorithm(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(issuedAt)(_.issuedAt(_))
        .ifSome(issuerCA)(_.issuerCA(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(eligibleToRenew)(_.eligibleToRenew(_))
        .ifSome(renewalSummary)(_.renewalSummary(_))
        .ifSome(revokedAt)(_.revokedAt(_))
        .ifSome(revocationReason)(_.revocationReason(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(supportCode)(_.supportCode(_))
        .build

    def certificateSummary(
      certificateArn: Option[String] = None,
      certificateName: Option[String] = None,
      domainName: Option[String] = None,
      certificateDetail: Option[Certificate] = None,
      tags: Option[List[Tag]] = None
    ): CertificateSummary =
      CertificateSummary
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(certificateDetail)(_.certificateDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def closeInstancePublicPortsRequest(
      portInfo: Option[PortInfo] = None,
      instanceName: Option[String] = None
    ): CloseInstancePublicPortsRequest =
      CloseInstancePublicPortsRequest
        .builder
        .ifSome(portInfo)(_.portInfo(_))
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def cloudFormationStackRecord(
      name: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      state: Option[String] = None,
      sourceInfo: Option[List[CloudFormationStackRecordSourceInfo]] = None,
      destinationInfo: Option[DestinationInfo] = None
    ): CloudFormationStackRecord =
      CloudFormationStackRecord
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(state)(_.state(_))
        .ifSome(sourceInfo)(_.sourceInfo(_))
        .ifSome(destinationInfo)(_.destinationInfo(_))
        .build

    def cloudFormationStackRecordSourceInfo(
      resourceType: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None
    ): CloudFormationStackRecordSourceInfo =
      CloudFormationStackRecordSourceInfo
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def contactMethod(
      contactEndpoint: Option[String] = None,
      status: Option[String] = None,
      protocol: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      supportCode: Option[String] = None
    ): ContactMethod =
      ContactMethod
        .builder
        .ifSome(contactEndpoint)(_.contactEndpoint(_))
        .ifSome(status)(_.status(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(supportCode)(_.supportCode(_))
        .build

    def container(
      image: Option[String] = None,
      command: Option[List[string]] = None,
      environment: Option[Environment] = None,
      ports: Option[PortMap] = None
    ): Container =
      Container
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(command)(_.command(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(ports)(_.ports(_))
        .build

    def containerImage(
      image: Option[String] = None,
      digest: Option[String] = None,
      createdAt: Option[IsoDate] = None
    ): ContainerImage =
      ContainerImage
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(digest)(_.digest(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def containerService(
      containerServiceName: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      power: Option[String] = None,
      powerId: Option[String] = None,
      state: Option[String] = None,
      stateDetail: Option[ContainerServiceStateDetail] = None,
      scale: Option[Int] = None,
      currentDeployment: Option[ContainerServiceDeployment] = None,
      nextDeployment: Option[ContainerServiceDeployment] = None,
      isDisabled: Option[Boolean] = None,
      principalArn: Option[String] = None,
      privateDomainName: Option[String] = None,
      publicDomainNames: Option[ContainerServicePublicDomains] = None,
      url: Option[String] = None
    ): ContainerService =
      ContainerService
        .builder
        .ifSome(containerServiceName)(_.containerServiceName(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(power)(_.power(_))
        .ifSome(powerId)(_.powerId(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateDetail)(_.stateDetail(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(currentDeployment)(_.currentDeployment(_))
        .ifSome(nextDeployment)(_.nextDeployment(_))
        .ifSome(isDisabled)(_.isDisabled(_))
        .ifSome(principalArn)(_.principalArn(_))
        .ifSome(privateDomainName)(_.privateDomainName(_))
        .ifSome(publicDomainNames)(_.publicDomainNames(_))
        .ifSome(url)(_.url(_))
        .build

    def containerServiceDeployment(
      version: Option[Int] = None,
      state: Option[String] = None,
      containers: Option[ContainerMap] = None,
      publicEndpoint: Option[ContainerServiceEndpoint] = None,
      createdAt: Option[IsoDate] = None
    ): ContainerServiceDeployment =
      ContainerServiceDeployment
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(state)(_.state(_))
        .ifSome(containers)(_.containers(_))
        .ifSome(publicEndpoint)(_.publicEndpoint(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def containerServiceDeploymentRequest(
      containers: Option[ContainerMap] = None,
      publicEndpoint: Option[EndpointRequest] = None
    ): ContainerServiceDeploymentRequest =
      ContainerServiceDeploymentRequest
        .builder
        .ifSome(containers)(_.containers(_))
        .ifSome(publicEndpoint)(_.publicEndpoint(_))
        .build

    def containerServiceEndpoint(
      containerName: Option[String] = None,
      containerPort: Option[Int] = None,
      healthCheck: Option[ContainerServiceHealthCheckConfig] = None
    ): ContainerServiceEndpoint =
      ContainerServiceEndpoint
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(containerPort)(_.containerPort(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .build

    def containerServiceHealthCheckConfig(
      healthyThreshold: Option[Int] = None,
      unhealthyThreshold: Option[Int] = None,
      timeoutSeconds: Option[Int] = None,
      intervalSeconds: Option[Int] = None,
      path: Option[String] = None,
      successCodes: Option[String] = None
    ): ContainerServiceHealthCheckConfig =
      ContainerServiceHealthCheckConfig
        .builder
        .ifSome(healthyThreshold)(_.healthyThreshold(_))
        .ifSome(unhealthyThreshold)(_.unhealthyThreshold(_))
        .ifSome(timeoutSeconds)(_.timeoutSeconds(_))
        .ifSome(intervalSeconds)(_.intervalSeconds(_))
        .ifSome(path)(_.path(_))
        .ifSome(successCodes)(_.successCodes(_))
        .build

    def containerServiceLogEvent(
      createdAt: Option[IsoDate] = None,
      message: Option[String] = None
    ): ContainerServiceLogEvent =
      ContainerServiceLogEvent
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(message)(_.message(_))
        .build

    def containerServicePower(
      powerId: Option[String] = None,
      price: Option[float] = None,
      cpuCount: Option[float] = None,
      ramSizeInGb: Option[float] = None,
      name: Option[String] = None,
      isActive: Option[Boolean] = None
    ): ContainerServicePower =
      ContainerServicePower
        .builder
        .ifSome(powerId)(_.powerId(_))
        .ifSome(price)(_.price(_))
        .ifSome(cpuCount)(_.cpuCount(_))
        .ifSome(ramSizeInGb)(_.ramSizeInGb(_))
        .ifSome(name)(_.name(_))
        .ifSome(isActive)(_.isActive(_))
        .build

    def containerServiceRegistryLogin(
      username: Option[String] = None,
      password: Option[String] = None,
      expiresAt: Option[IsoDate] = None,
      registry: Option[String] = None
    ): ContainerServiceRegistryLogin =
      ContainerServiceRegistryLogin
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(expiresAt)(_.expiresAt(_))
        .ifSome(registry)(_.registry(_))
        .build

    def containerServiceStateDetail(
      code: Option[String] = None,
      message: Option[String] = None
    ): ContainerServiceStateDetail =
      ContainerServiceStateDetail
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def cookieObject(
      option: Option[String] = None,
      cookiesAllowList: Option[List[string]] = None
    ): CookieObject =
      CookieObject
        .builder
        .ifSome(option)(_.option(_))
        .ifSome(cookiesAllowList)(_.cookiesAllowList(_))
        .build

    def copySnapshotRequest(
      sourceSnapshotName: Option[String] = None,
      sourceResourceName: Option[String] = None,
      restoreDate: Option[String] = None,
      useLatestRestorableAutoSnapshot: Option[Boolean] = None,
      targetSnapshotName: Option[String] = None,
      sourceRegion: Option[String] = None
    ): CopySnapshotRequest =
      CopySnapshotRequest
        .builder
        .ifSome(sourceSnapshotName)(_.sourceSnapshotName(_))
        .ifSome(sourceResourceName)(_.sourceResourceName(_))
        .ifSome(restoreDate)(_.restoreDate(_))
        .ifSome(useLatestRestorableAutoSnapshot)(_.useLatestRestorableAutoSnapshot(_))
        .ifSome(targetSnapshotName)(_.targetSnapshotName(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .build

    def createCertificateRequest(
      certificateName: Option[String] = None,
      domainName: Option[String] = None,
      subjectAlternativeNames: Option[List[DomainName]] = None,
      tags: Option[List[Tag]] = None
    ): CreateCertificateRequest =
      CreateCertificateRequest
        .builder
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCloudFormationStackRequest(
      instances: Option[List[InstanceEntry]] = None
    ): CreateCloudFormationStackRequest =
      CreateCloudFormationStackRequest
        .builder
        .ifSome(instances)(_.instances(_))
        .build

    def createContactMethodRequest(
      protocol: Option[String] = None,
      contactEndpoint: Option[String] = None
    ): CreateContactMethodRequest =
      CreateContactMethodRequest
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(contactEndpoint)(_.contactEndpoint(_))
        .build

    def createContainerServiceDeploymentRequest(
      serviceName: Option[String] = None,
      containers: Option[ContainerMap] = None,
      publicEndpoint: Option[EndpointRequest] = None
    ): CreateContainerServiceDeploymentRequest =
      CreateContainerServiceDeploymentRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(containers)(_.containers(_))
        .ifSome(publicEndpoint)(_.publicEndpoint(_))
        .build

    def createContainerServiceRegistryLoginRequest(

    ): CreateContainerServiceRegistryLoginRequest =
      CreateContainerServiceRegistryLoginRequest
        .builder

        .build

    def createContainerServiceRequest(
      serviceName: Option[String] = None,
      power: Option[String] = None,
      scale: Option[Int] = None,
      tags: Option[List[Tag]] = None,
      publicDomainNames: Option[ContainerServicePublicDomains] = None,
      deployment: Option[ContainerServiceDeploymentRequest] = None
    ): CreateContainerServiceRequest =
      CreateContainerServiceRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(power)(_.power(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(publicDomainNames)(_.publicDomainNames(_))
        .ifSome(deployment)(_.deployment(_))
        .build

    def createDiskFromSnapshotRequest(
      diskName: Option[String] = None,
      diskSnapshotName: Option[String] = None,
      availabilityZone: Option[String] = None,
      sizeInGb: Option[Int] = None,
      tags: Option[List[Tag]] = None,
      addOns: Option[List[AddOnRequest]] = None,
      sourceDiskName: Option[String] = None,
      restoreDate: Option[String] = None,
      useLatestRestorableAutoSnapshot: Option[Boolean] = None
    ): CreateDiskFromSnapshotRequest =
      CreateDiskFromSnapshotRequest
        .builder
        .ifSome(diskName)(_.diskName(_))
        .ifSome(diskSnapshotName)(_.diskSnapshotName(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(addOns)(_.addOns(_))
        .ifSome(sourceDiskName)(_.sourceDiskName(_))
        .ifSome(restoreDate)(_.restoreDate(_))
        .ifSome(useLatestRestorableAutoSnapshot)(_.useLatestRestorableAutoSnapshot(_))
        .build

    def createDiskRequest(
      diskName: Option[String] = None,
      availabilityZone: Option[String] = None,
      sizeInGb: Option[Int] = None,
      tags: Option[List[Tag]] = None,
      addOns: Option[List[AddOnRequest]] = None
    ): CreateDiskRequest =
      CreateDiskRequest
        .builder
        .ifSome(diskName)(_.diskName(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(addOns)(_.addOns(_))
        .build

    def createDiskSnapshotRequest(
      diskName: Option[String] = None,
      diskSnapshotName: Option[String] = None,
      instanceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDiskSnapshotRequest =
      CreateDiskSnapshotRequest
        .builder
        .ifSome(diskName)(_.diskName(_))
        .ifSome(diskSnapshotName)(_.diskSnapshotName(_))
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDistributionRequest(
      distributionName: Option[String] = None,
      origin: Option[InputOrigin] = None,
      defaultCacheBehavior: Option[CacheBehavior] = None,
      cacheBehaviorSettings: Option[CacheSettings] = None,
      cacheBehaviors: Option[List[CacheBehaviorPerPath]] = None,
      bundleId: Option[String] = None,
      ipAddressType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDistributionRequest =
      CreateDistributionRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(defaultCacheBehavior)(_.defaultCacheBehavior(_))
        .ifSome(cacheBehaviorSettings)(_.cacheBehaviorSettings(_))
        .ifSome(cacheBehaviors)(_.cacheBehaviors(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDomainEntryRequest(
      domainName: Option[String] = None,
      domainEntry: Option[DomainEntry] = None
    ): CreateDomainEntryRequest =
      CreateDomainEntryRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainEntry)(_.domainEntry(_))
        .build

    def createDomainRequest(
      domainName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDomainRequest =
      CreateDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createInstanceSnapshotRequest(
      instanceSnapshotName: Option[String] = None,
      instanceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateInstanceSnapshotRequest =
      CreateInstanceSnapshotRequest
        .builder
        .ifSome(instanceSnapshotName)(_.instanceSnapshotName(_))
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createInstancesFromSnapshotRequest(
      instanceNames: Option[List[string]] = None,
      attachedDiskMapping: Option[AttachedDiskMap] = None,
      availabilityZone: Option[String] = None,
      instanceSnapshotName: Option[String] = None,
      bundleId: Option[String] = None,
      userData: Option[String] = None,
      keyPairName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      addOns: Option[List[AddOnRequest]] = None,
      ipAddressType: Option[String] = None,
      sourceInstanceName: Option[String] = None,
      restoreDate: Option[String] = None,
      useLatestRestorableAutoSnapshot: Option[Boolean] = None
    ): CreateInstancesFromSnapshotRequest =
      CreateInstancesFromSnapshotRequest
        .builder
        .ifSome(instanceNames)(_.instanceNames(_))
        .ifSome(attachedDiskMapping)(_.attachedDiskMapping(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(instanceSnapshotName)(_.instanceSnapshotName(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(keyPairName)(_.keyPairName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(addOns)(_.addOns(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(sourceInstanceName)(_.sourceInstanceName(_))
        .ifSome(restoreDate)(_.restoreDate(_))
        .ifSome(useLatestRestorableAutoSnapshot)(_.useLatestRestorableAutoSnapshot(_))
        .build

    def createInstancesRequest(
      instanceNames: Option[List[string]] = None,
      availabilityZone: Option[String] = None,
      customImageName: Option[String] = None,
      blueprintId: Option[String] = None,
      bundleId: Option[String] = None,
      userData: Option[String] = None,
      keyPairName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      addOns: Option[List[AddOnRequest]] = None,
      ipAddressType: Option[String] = None
    ): CreateInstancesRequest =
      CreateInstancesRequest
        .builder
        .ifSome(instanceNames)(_.instanceNames(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(customImageName)(_.customImageName(_))
        .ifSome(blueprintId)(_.blueprintId(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(keyPairName)(_.keyPairName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(addOns)(_.addOns(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def createKeyPairRequest(
      keyPairName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateKeyPairRequest =
      CreateKeyPairRequest
        .builder
        .ifSome(keyPairName)(_.keyPairName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLoadBalancerRequest(
      loadBalancerName: Option[String] = None,
      instancePort: Option[Int] = None,
      healthCheckPath: Option[String] = None,
      certificateName: Option[String] = None,
      certificateDomainName: Option[String] = None,
      certificateAlternativeNames: Option[List[DomainName]] = None,
      tags: Option[List[Tag]] = None,
      ipAddressType: Option[String] = None
    ): CreateLoadBalancerRequest =
      CreateLoadBalancerRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(instancePort)(_.instancePort(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(certificateDomainName)(_.certificateDomainName(_))
        .ifSome(certificateAlternativeNames)(_.certificateAlternativeNames(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def createLoadBalancerTlsCertificateRequest(
      loadBalancerName: Option[String] = None,
      certificateName: Option[String] = None,
      certificateDomainName: Option[String] = None,
      certificateAlternativeNames: Option[List[DomainName]] = None,
      tags: Option[List[Tag]] = None
    ): CreateLoadBalancerTlsCertificateRequest =
      CreateLoadBalancerTlsCertificateRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(certificateDomainName)(_.certificateDomainName(_))
        .ifSome(certificateAlternativeNames)(_.certificateAlternativeNames(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRelationalDatabaseFromSnapshotRequest(
      relationalDatabaseName: Option[String] = None,
      availabilityZone: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      relationalDatabaseSnapshotName: Option[String] = None,
      relationalDatabaseBundleId: Option[String] = None,
      sourceRelationalDatabaseName: Option[String] = None,
      restoreTime: Option[IsoDate] = None,
      useLatestRestorableTime: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateRelationalDatabaseFromSnapshotRequest =
      CreateRelationalDatabaseFromSnapshotRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(relationalDatabaseSnapshotName)(_.relationalDatabaseSnapshotName(_))
        .ifSome(relationalDatabaseBundleId)(_.relationalDatabaseBundleId(_))
        .ifSome(sourceRelationalDatabaseName)(_.sourceRelationalDatabaseName(_))
        .ifSome(restoreTime)(_.restoreTime(_))
        .ifSome(useLatestRestorableTime)(_.useLatestRestorableTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRelationalDatabaseRequest(
      relationalDatabaseName: Option[String] = None,
      availabilityZone: Option[String] = None,
      relationalDatabaseBlueprintId: Option[String] = None,
      relationalDatabaseBundleId: Option[String] = None,
      masterDatabaseName: Option[String] = None,
      masterUsername: Option[String] = None,
      masterUserPassword: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateRelationalDatabaseRequest =
      CreateRelationalDatabaseRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(relationalDatabaseBlueprintId)(_.relationalDatabaseBlueprintId(_))
        .ifSome(relationalDatabaseBundleId)(_.relationalDatabaseBundleId(_))
        .ifSome(masterDatabaseName)(_.masterDatabaseName(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRelationalDatabaseSnapshotRequest(
      relationalDatabaseName: Option[String] = None,
      relationalDatabaseSnapshotName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateRelationalDatabaseSnapshotRequest =
      CreateRelationalDatabaseSnapshotRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(relationalDatabaseSnapshotName)(_.relationalDatabaseSnapshotName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteAlarmRequest(
      alarmName: Option[String] = None
    ): DeleteAlarmRequest =
      DeleteAlarmRequest
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .build

    def deleteAutoSnapshotRequest(
      resourceName: Option[String] = None,
      date: Option[String] = None
    ): DeleteAutoSnapshotRequest =
      DeleteAutoSnapshotRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(date)(_.date(_))
        .build

    def deleteCertificateRequest(
      certificateName: Option[String] = None
    ): DeleteCertificateRequest =
      DeleteCertificateRequest
        .builder
        .ifSome(certificateName)(_.certificateName(_))
        .build

    def deleteContactMethodRequest(
      protocol: Option[String] = None
    ): DeleteContactMethodRequest =
      DeleteContactMethodRequest
        .builder
        .ifSome(protocol)(_.protocol(_))
        .build

    def deleteContainerImageRequest(
      serviceName: Option[String] = None,
      image: Option[String] = None
    ): DeleteContainerImageRequest =
      DeleteContainerImageRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(image)(_.image(_))
        .build

    def deleteContainerServiceRequest(
      serviceName: Option[String] = None
    ): DeleteContainerServiceRequest =
      DeleteContainerServiceRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def deleteDiskRequest(
      diskName: Option[String] = None,
      forceDeleteAddOns: Option[Boolean] = None
    ): DeleteDiskRequest =
      DeleteDiskRequest
        .builder
        .ifSome(diskName)(_.diskName(_))
        .ifSome(forceDeleteAddOns)(_.forceDeleteAddOns(_))
        .build

    def deleteDiskSnapshotRequest(
      diskSnapshotName: Option[String] = None
    ): DeleteDiskSnapshotRequest =
      DeleteDiskSnapshotRequest
        .builder
        .ifSome(diskSnapshotName)(_.diskSnapshotName(_))
        .build

    def deleteDistributionRequest(
      distributionName: Option[String] = None
    ): DeleteDistributionRequest =
      DeleteDistributionRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .build

    def deleteDomainEntryRequest(
      domainName: Option[String] = None,
      domainEntry: Option[DomainEntry] = None
    ): DeleteDomainEntryRequest =
      DeleteDomainEntryRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainEntry)(_.domainEntry(_))
        .build

    def deleteDomainRequest(
      domainName: Option[String] = None
    ): DeleteDomainRequest =
      DeleteDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteInstanceRequest(
      instanceName: Option[String] = None,
      forceDeleteAddOns: Option[Boolean] = None
    ): DeleteInstanceRequest =
      DeleteInstanceRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(forceDeleteAddOns)(_.forceDeleteAddOns(_))
        .build

    def deleteInstanceSnapshotRequest(
      instanceSnapshotName: Option[String] = None
    ): DeleteInstanceSnapshotRequest =
      DeleteInstanceSnapshotRequest
        .builder
        .ifSome(instanceSnapshotName)(_.instanceSnapshotName(_))
        .build

    def deleteKeyPairRequest(
      keyPairName: Option[String] = None
    ): DeleteKeyPairRequest =
      DeleteKeyPairRequest
        .builder
        .ifSome(keyPairName)(_.keyPairName(_))
        .build

    def deleteKnownHostKeysRequest(
      instanceName: Option[String] = None
    ): DeleteKnownHostKeysRequest =
      DeleteKnownHostKeysRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def deleteLoadBalancerRequest(
      loadBalancerName: Option[String] = None
    ): DeleteLoadBalancerRequest =
      DeleteLoadBalancerRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .build

    def deleteLoadBalancerTlsCertificateRequest(
      loadBalancerName: Option[String] = None,
      certificateName: Option[String] = None,
      force: Option[Boolean] = None
    ): DeleteLoadBalancerTlsCertificateRequest =
      DeleteLoadBalancerTlsCertificateRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(force)(_.force(_))
        .build

    def deleteRelationalDatabaseRequest(
      relationalDatabaseName: Option[String] = None,
      skipFinalSnapshot: Option[Boolean] = None,
      finalRelationalDatabaseSnapshotName: Option[String] = None
    ): DeleteRelationalDatabaseRequest =
      DeleteRelationalDatabaseRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(skipFinalSnapshot)(_.skipFinalSnapshot(_))
        .ifSome(finalRelationalDatabaseSnapshotName)(_.finalRelationalDatabaseSnapshotName(_))
        .build

    def deleteRelationalDatabaseSnapshotRequest(
      relationalDatabaseSnapshotName: Option[String] = None
    ): DeleteRelationalDatabaseSnapshotRequest =
      DeleteRelationalDatabaseSnapshotRequest
        .builder
        .ifSome(relationalDatabaseSnapshotName)(_.relationalDatabaseSnapshotName(_))
        .build

    def destinationInfo(
      id: Option[String] = None,
      service: Option[String] = None
    ): DestinationInfo =
      DestinationInfo
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(service)(_.service(_))
        .build

    def detachCertificateFromDistributionRequest(
      distributionName: Option[String] = None
    ): DetachCertificateFromDistributionRequest =
      DetachCertificateFromDistributionRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .build

    def detachDiskRequest(
      diskName: Option[String] = None
    ): DetachDiskRequest =
      DetachDiskRequest
        .builder
        .ifSome(diskName)(_.diskName(_))
        .build

    def detachInstancesFromLoadBalancerRequest(
      loadBalancerName: Option[String] = None,
      instanceNames: Option[List[ResourceName]] = None
    ): DetachInstancesFromLoadBalancerRequest =
      DetachInstancesFromLoadBalancerRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(instanceNames)(_.instanceNames(_))
        .build

    def detachStaticIpRequest(
      staticIpName: Option[String] = None
    ): DetachStaticIpRequest =
      DetachStaticIpRequest
        .builder
        .ifSome(staticIpName)(_.staticIpName(_))
        .build

    def disableAddOnRequest(
      addOnType: Option[String] = None,
      resourceName: Option[String] = None
    ): DisableAddOnRequest =
      DisableAddOnRequest
        .builder
        .ifSome(addOnType)(_.addOnType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def disk(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      addOns: Option[List[AddOn]] = None,
      sizeInGb: Option[Int] = None,
      isSystemDisk: Option[Boolean] = None,
      iops: Option[Int] = None,
      path: Option[String] = None,
      state: Option[String] = None,
      attachedTo: Option[String] = None,
      isAttached: Option[Boolean] = None,
      attachmentState: Option[String] = None,
      gbInUse: Option[Int] = None
    ): Disk =
      Disk
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(addOns)(_.addOns(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .ifSome(isSystemDisk)(_.isSystemDisk(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(path)(_.path(_))
        .ifSome(state)(_.state(_))
        .ifSome(attachedTo)(_.attachedTo(_))
        .ifSome(isAttached)(_.isAttached(_))
        .ifSome(attachmentState)(_.attachmentState(_))
        .ifSome(gbInUse)(_.gbInUse(_))
        .build

    def diskInfo(
      name: Option[String] = None,
      path: Option[String] = None,
      sizeInGb: Option[Int] = None,
      isSystemDisk: Option[Boolean] = None
    ): DiskInfo =
      DiskInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(path)(_.path(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .ifSome(isSystemDisk)(_.isSystemDisk(_))
        .build

    def diskMap(
      originalDiskPath: Option[String] = None,
      newDiskName: Option[String] = None
    ): DiskMap =
      DiskMap
        .builder
        .ifSome(originalDiskPath)(_.originalDiskPath(_))
        .ifSome(newDiskName)(_.newDiskName(_))
        .build

    def diskSnapshot(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      sizeInGb: Option[Int] = None,
      state: Option[String] = None,
      progress: Option[String] = None,
      fromDiskName: Option[String] = None,
      fromDiskArn: Option[String] = None,
      fromInstanceName: Option[String] = None,
      fromInstanceArn: Option[String] = None,
      isFromAutoSnapshot: Option[Boolean] = None
    ): DiskSnapshot =
      DiskSnapshot
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .ifSome(state)(_.state(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(fromDiskName)(_.fromDiskName(_))
        .ifSome(fromDiskArn)(_.fromDiskArn(_))
        .ifSome(fromInstanceName)(_.fromInstanceName(_))
        .ifSome(fromInstanceArn)(_.fromInstanceArn(_))
        .ifSome(isFromAutoSnapshot)(_.isFromAutoSnapshot(_))
        .build

    def diskSnapshotInfo(
      sizeInGb: Option[Int] = None
    ): DiskSnapshotInfo =
      DiskSnapshotInfo
        .builder
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .build

    def distributionBundle(
      bundleId: Option[String] = None,
      name: Option[String] = None,
      price: Option[float] = None,
      transferPerMonthInGb: Option[Int] = None,
      isActive: Option[Boolean] = None
    ): DistributionBundle =
      DistributionBundle
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(price)(_.price(_))
        .ifSome(transferPerMonthInGb)(_.transferPerMonthInGb(_))
        .ifSome(isActive)(_.isActive(_))
        .build

    def domain(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      domainEntries: Option[List[DomainEntry]] = None
    ): Domain =
      Domain
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(domainEntries)(_.domainEntries(_))
        .build

    def domainEntry(
      id: Option[String] = None,
      name: Option[String] = None,
      target: Option[String] = None,
      isAlias: Option[Boolean] = None,
      `type`: Option[String] = None,
      options: Option[DomainEntryOptions] = None
    ): DomainEntry =
      DomainEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(target)(_.target(_))
        .ifSome(isAlias)(_.isAlias(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(options)(_.options(_))
        .build

    def domainValidationRecord(
      domainName: Option[String] = None,
      resourceRecord: Option[ResourceRecord] = None
    ): DomainValidationRecord =
      DomainValidationRecord
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(resourceRecord)(_.resourceRecord(_))
        .build

    def downloadDefaultKeyPairRequest(

    ): DownloadDefaultKeyPairRequest =
      DownloadDefaultKeyPairRequest
        .builder

        .build

    def enableAddOnRequest(
      resourceName: Option[String] = None,
      addOnRequest: Option[AddOnRequest] = None
    ): EnableAddOnRequest =
      EnableAddOnRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(addOnRequest)(_.addOnRequest(_))
        .build

    def endpointRequest(
      containerName: Option[String] = None,
      containerPort: Option[Int] = None,
      healthCheck: Option[ContainerServiceHealthCheckConfig] = None
    ): EndpointRequest =
      EndpointRequest
        .builder
        .ifSome(containerName)(_.containerName(_))
        .ifSome(containerPort)(_.containerPort(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .build

    def exportSnapshotRecord(
      name: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      state: Option[String] = None,
      sourceInfo: Option[ExportSnapshotRecordSourceInfo] = None,
      destinationInfo: Option[DestinationInfo] = None
    ): ExportSnapshotRecord =
      ExportSnapshotRecord
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(state)(_.state(_))
        .ifSome(sourceInfo)(_.sourceInfo(_))
        .ifSome(destinationInfo)(_.destinationInfo(_))
        .build

    def exportSnapshotRecordSourceInfo(
      resourceType: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      fromResourceName: Option[String] = None,
      fromResourceArn: Option[String] = None,
      instanceSnapshotInfo: Option[InstanceSnapshotInfo] = None,
      diskSnapshotInfo: Option[DiskSnapshotInfo] = None
    ): ExportSnapshotRecordSourceInfo =
      ExportSnapshotRecordSourceInfo
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(fromResourceName)(_.fromResourceName(_))
        .ifSome(fromResourceArn)(_.fromResourceArn(_))
        .ifSome(instanceSnapshotInfo)(_.instanceSnapshotInfo(_))
        .ifSome(diskSnapshotInfo)(_.diskSnapshotInfo(_))
        .build

    def exportSnapshotRequest(
      sourceSnapshotName: Option[String] = None
    ): ExportSnapshotRequest =
      ExportSnapshotRequest
        .builder
        .ifSome(sourceSnapshotName)(_.sourceSnapshotName(_))
        .build

    def getActiveNamesRequest(
      pageToken: Option[String] = None
    ): GetActiveNamesRequest =
      GetActiveNamesRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getAlarmsRequest(
      alarmName: Option[String] = None,
      pageToken: Option[String] = None,
      monitoredResourceName: Option[String] = None
    ): GetAlarmsRequest =
      GetAlarmsRequest
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(monitoredResourceName)(_.monitoredResourceName(_))
        .build

    def getAutoSnapshotsRequest(
      resourceName: Option[String] = None
    ): GetAutoSnapshotsRequest =
      GetAutoSnapshotsRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBlueprintsRequest(
      includeInactive: Option[Boolean] = None,
      pageToken: Option[String] = None
    ): GetBlueprintsRequest =
      GetBlueprintsRequest
        .builder
        .ifSome(includeInactive)(_.includeInactive(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getBundlesRequest(
      includeInactive: Option[Boolean] = None,
      pageToken: Option[String] = None
    ): GetBundlesRequest =
      GetBundlesRequest
        .builder
        .ifSome(includeInactive)(_.includeInactive(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getCertificatesRequest(
      certificateStatuses: Option[List[CertificateStatus]] = None,
      includeCertificateDetails: Option[Boolean] = None,
      certificateName: Option[String] = None
    ): GetCertificatesRequest =
      GetCertificatesRequest
        .builder
        .ifSome(certificateStatuses)(_.certificateStatuses(_))
        .ifSome(includeCertificateDetails)(_.includeCertificateDetails(_))
        .ifSome(certificateName)(_.certificateName(_))
        .build

    def getCloudFormationStackRecordsRequest(
      pageToken: Option[String] = None
    ): GetCloudFormationStackRecordsRequest =
      GetCloudFormationStackRecordsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getContactMethodsRequest(
      protocols: Option[List[ContactProtocol]] = None
    ): GetContactMethodsRequest =
      GetContactMethodsRequest
        .builder
        .ifSome(protocols)(_.protocols(_))
        .build

    def getContainerAPIMetadataRequest(

    ): GetContainerAPIMetadataRequest =
      GetContainerAPIMetadataRequest
        .builder

        .build

    def getContainerImagesRequest(
      serviceName: Option[String] = None
    ): GetContainerImagesRequest =
      GetContainerImagesRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def getContainerLogRequest(
      serviceName: Option[String] = None,
      containerName: Option[String] = None,
      startTime: Option[IsoDate] = None,
      endTime: Option[IsoDate] = None,
      filterPattern: Option[String] = None,
      pageToken: Option[String] = None
    ): GetContainerLogRequest =
      GetContainerLogRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(containerName)(_.containerName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(filterPattern)(_.filterPattern(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getContainerServiceDeploymentsRequest(
      serviceName: Option[String] = None
    ): GetContainerServiceDeploymentsRequest =
      GetContainerServiceDeploymentsRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def getContainerServiceMetricDataRequest(
      serviceName: Option[String] = None,
      metricName: Option[String] = None,
      startTime: Option[IsoDate] = None,
      endTime: Option[IsoDate] = None,
      period: Option[Int] = None,
      statistics: Option[List[MetricStatistic]] = None
    ): GetContainerServiceMetricDataRequest =
      GetContainerServiceMetricDataRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(period)(_.period(_))
        .ifSome(statistics)(_.statistics(_))
        .build

    def getContainerServicePowersRequest(

    ): GetContainerServicePowersRequest =
      GetContainerServicePowersRequest
        .builder

        .build

    def getContainerServicesRequest(
      serviceName: Option[String] = None
    ): GetContainerServicesRequest =
      GetContainerServicesRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def getDiskRequest(
      diskName: Option[String] = None
    ): GetDiskRequest =
      GetDiskRequest
        .builder
        .ifSome(diskName)(_.diskName(_))
        .build

    def getDiskSnapshotRequest(
      diskSnapshotName: Option[String] = None
    ): GetDiskSnapshotRequest =
      GetDiskSnapshotRequest
        .builder
        .ifSome(diskSnapshotName)(_.diskSnapshotName(_))
        .build

    def getDiskSnapshotsRequest(
      pageToken: Option[String] = None
    ): GetDiskSnapshotsRequest =
      GetDiskSnapshotsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getDisksRequest(
      pageToken: Option[String] = None
    ): GetDisksRequest =
      GetDisksRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getDistributionBundlesRequest(

    ): GetDistributionBundlesRequest =
      GetDistributionBundlesRequest
        .builder

        .build

    def getDistributionLatestCacheResetRequest(
      distributionName: Option[String] = None
    ): GetDistributionLatestCacheResetRequest =
      GetDistributionLatestCacheResetRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .build

    def getDistributionMetricDataRequest(
      distributionName: Option[String] = None,
      metricName: Option[String] = None,
      startTime: Option[timestamp] = None,
      endTime: Option[timestamp] = None,
      period: Option[Int] = None,
      unit: Option[String] = None,
      statistics: Option[List[MetricStatistic]] = None
    ): GetDistributionMetricDataRequest =
      GetDistributionMetricDataRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(period)(_.period(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(statistics)(_.statistics(_))
        .build

    def getDistributionsRequest(
      distributionName: Option[String] = None,
      pageToken: Option[String] = None
    ): GetDistributionsRequest =
      GetDistributionsRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getDomainRequest(
      domainName: Option[String] = None
    ): GetDomainRequest =
      GetDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getDomainsRequest(
      pageToken: Option[String] = None
    ): GetDomainsRequest =
      GetDomainsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getExportSnapshotRecordsRequest(
      pageToken: Option[String] = None
    ): GetExportSnapshotRecordsRequest =
      GetExportSnapshotRecordsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getInstanceAccessDetailsRequest(
      instanceName: Option[String] = None,
      protocol: Option[String] = None
    ): GetInstanceAccessDetailsRequest =
      GetInstanceAccessDetailsRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def getInstanceMetricDataRequest(
      instanceName: Option[String] = None,
      metricName: Option[String] = None,
      period: Option[Int] = None,
      startTime: Option[timestamp] = None,
      endTime: Option[timestamp] = None,
      unit: Option[String] = None,
      statistics: Option[List[MetricStatistic]] = None
    ): GetInstanceMetricDataRequest =
      GetInstanceMetricDataRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(period)(_.period(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(statistics)(_.statistics(_))
        .build

    def getInstancePortStatesRequest(
      instanceName: Option[String] = None
    ): GetInstancePortStatesRequest =
      GetInstancePortStatesRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def getInstanceRequest(
      instanceName: Option[String] = None
    ): GetInstanceRequest =
      GetInstanceRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def getInstanceSnapshotRequest(
      instanceSnapshotName: Option[String] = None
    ): GetInstanceSnapshotRequest =
      GetInstanceSnapshotRequest
        .builder
        .ifSome(instanceSnapshotName)(_.instanceSnapshotName(_))
        .build

    def getInstanceSnapshotsRequest(
      pageToken: Option[String] = None
    ): GetInstanceSnapshotsRequest =
      GetInstanceSnapshotsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getInstanceStateRequest(
      instanceName: Option[String] = None
    ): GetInstanceStateRequest =
      GetInstanceStateRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def getInstancesRequest(
      pageToken: Option[String] = None
    ): GetInstancesRequest =
      GetInstancesRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getKeyPairRequest(
      keyPairName: Option[String] = None
    ): GetKeyPairRequest =
      GetKeyPairRequest
        .builder
        .ifSome(keyPairName)(_.keyPairName(_))
        .build

    def getKeyPairsRequest(
      pageToken: Option[String] = None
    ): GetKeyPairsRequest =
      GetKeyPairsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getLoadBalancerMetricDataRequest(
      loadBalancerName: Option[String] = None,
      metricName: Option[String] = None,
      period: Option[Int] = None,
      startTime: Option[timestamp] = None,
      endTime: Option[timestamp] = None,
      unit: Option[String] = None,
      statistics: Option[List[MetricStatistic]] = None
    ): GetLoadBalancerMetricDataRequest =
      GetLoadBalancerMetricDataRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(period)(_.period(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(statistics)(_.statistics(_))
        .build

    def getLoadBalancerRequest(
      loadBalancerName: Option[String] = None
    ): GetLoadBalancerRequest =
      GetLoadBalancerRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .build

    def getLoadBalancerTlsCertificatesRequest(
      loadBalancerName: Option[String] = None
    ): GetLoadBalancerTlsCertificatesRequest =
      GetLoadBalancerTlsCertificatesRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .build

    def getLoadBalancersRequest(
      pageToken: Option[String] = None
    ): GetLoadBalancersRequest =
      GetLoadBalancersRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getOperationRequest(
      operationId: Option[String] = None
    ): GetOperationRequest =
      GetOperationRequest
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def getOperationsForResourceRequest(
      resourceName: Option[String] = None,
      pageToken: Option[String] = None
    ): GetOperationsForResourceRequest =
      GetOperationsForResourceRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getOperationsRequest(
      pageToken: Option[String] = None
    ): GetOperationsRequest =
      GetOperationsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getRegionsRequest(
      includeAvailabilityZones: Option[Boolean] = None,
      includeRelationalDatabaseAvailabilityZones: Option[Boolean] = None
    ): GetRegionsRequest =
      GetRegionsRequest
        .builder
        .ifSome(includeAvailabilityZones)(_.includeAvailabilityZones(_))
        .ifSome(includeRelationalDatabaseAvailabilityZones)(_.includeRelationalDatabaseAvailabilityZones(_))
        .build

    def getRelationalDatabaseBlueprintsRequest(
      pageToken: Option[String] = None
    ): GetRelationalDatabaseBlueprintsRequest =
      GetRelationalDatabaseBlueprintsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getRelationalDatabaseBundlesRequest(
      pageToken: Option[String] = None
    ): GetRelationalDatabaseBundlesRequest =
      GetRelationalDatabaseBundlesRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getRelationalDatabaseEventsRequest(
      relationalDatabaseName: Option[String] = None,
      durationInMinutes: Option[Int] = None,
      pageToken: Option[String] = None
    ): GetRelationalDatabaseEventsRequest =
      GetRelationalDatabaseEventsRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(durationInMinutes)(_.durationInMinutes(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getRelationalDatabaseLogEventsRequest(
      relationalDatabaseName: Option[String] = None,
      logStreamName: Option[String] = None,
      startTime: Option[IsoDate] = None,
      endTime: Option[IsoDate] = None,
      startFromHead: Option[Boolean] = None,
      pageToken: Option[String] = None
    ): GetRelationalDatabaseLogEventsRequest =
      GetRelationalDatabaseLogEventsRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(startFromHead)(_.startFromHead(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getRelationalDatabaseLogStreamsRequest(
      relationalDatabaseName: Option[String] = None
    ): GetRelationalDatabaseLogStreamsRequest =
      GetRelationalDatabaseLogStreamsRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .build

    def getRelationalDatabaseMasterUserPasswordRequest(
      relationalDatabaseName: Option[String] = None,
      passwordVersion: Option[String] = None
    ): GetRelationalDatabaseMasterUserPasswordRequest =
      GetRelationalDatabaseMasterUserPasswordRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(passwordVersion)(_.passwordVersion(_))
        .build

    def getRelationalDatabaseMetricDataRequest(
      relationalDatabaseName: Option[String] = None,
      metricName: Option[String] = None,
      period: Option[Int] = None,
      startTime: Option[IsoDate] = None,
      endTime: Option[IsoDate] = None,
      unit: Option[String] = None,
      statistics: Option[List[MetricStatistic]] = None
    ): GetRelationalDatabaseMetricDataRequest =
      GetRelationalDatabaseMetricDataRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(period)(_.period(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(statistics)(_.statistics(_))
        .build

    def getRelationalDatabaseParametersRequest(
      relationalDatabaseName: Option[String] = None,
      pageToken: Option[String] = None
    ): GetRelationalDatabaseParametersRequest =
      GetRelationalDatabaseParametersRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getRelationalDatabaseRequest(
      relationalDatabaseName: Option[String] = None
    ): GetRelationalDatabaseRequest =
      GetRelationalDatabaseRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .build

    def getRelationalDatabaseSnapshotRequest(
      relationalDatabaseSnapshotName: Option[String] = None
    ): GetRelationalDatabaseSnapshotRequest =
      GetRelationalDatabaseSnapshotRequest
        .builder
        .ifSome(relationalDatabaseSnapshotName)(_.relationalDatabaseSnapshotName(_))
        .build

    def getRelationalDatabaseSnapshotsRequest(
      pageToken: Option[String] = None
    ): GetRelationalDatabaseSnapshotsRequest =
      GetRelationalDatabaseSnapshotsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getRelationalDatabasesRequest(
      pageToken: Option[String] = None
    ): GetRelationalDatabasesRequest =
      GetRelationalDatabasesRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getStaticIpRequest(
      staticIpName: Option[String] = None
    ): GetStaticIpRequest =
      GetStaticIpRequest
        .builder
        .ifSome(staticIpName)(_.staticIpName(_))
        .build

    def getStaticIpsRequest(
      pageToken: Option[String] = None
    ): GetStaticIpsRequest =
      GetStaticIpsRequest
        .builder
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def headerObject(
      option: Option[String] = None,
      headersAllowList: Option[List[HeaderEnum]] = None
    ): HeaderObject =
      HeaderObject
        .builder
        .ifSome(option)(_.option(_))
        .ifSome(headersAllowList)(_.headersAllowList(_))
        .build

    def hostKeyAttributes(
      algorithm: Option[String] = None,
      publicKey: Option[String] = None,
      witnessedAt: Option[IsoDate] = None,
      fingerprintSHA1: Option[String] = None,
      fingerprintSHA256: Option[String] = None,
      notValidBefore: Option[IsoDate] = None,
      notValidAfter: Option[IsoDate] = None
    ): HostKeyAttributes =
      HostKeyAttributes
        .builder
        .ifSome(algorithm)(_.algorithm(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(witnessedAt)(_.witnessedAt(_))
        .ifSome(fingerprintSHA1)(_.fingerprintSHA1(_))
        .ifSome(fingerprintSHA256)(_.fingerprintSHA256(_))
        .ifSome(notValidBefore)(_.notValidBefore(_))
        .ifSome(notValidAfter)(_.notValidAfter(_))
        .build

    def importKeyPairRequest(
      keyPairName: Option[String] = None,
      publicKeyBase64: Option[String] = None
    ): ImportKeyPairRequest =
      ImportKeyPairRequest
        .builder
        .ifSome(keyPairName)(_.keyPairName(_))
        .ifSome(publicKeyBase64)(_.publicKeyBase64(_))
        .build

    def inputOrigin(
      name: Option[String] = None,
      regionName: Option[String] = None,
      protocolPolicy: Option[String] = None
    ): InputOrigin =
      InputOrigin
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(protocolPolicy)(_.protocolPolicy(_))
        .build

    def instance(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      blueprintId: Option[String] = None,
      blueprintName: Option[String] = None,
      bundleId: Option[String] = None,
      addOns: Option[List[AddOn]] = None,
      isStaticIp: Option[Boolean] = None,
      privateIpAddress: Option[String] = None,
      publicIpAddress: Option[String] = None,
      ipv6Addresses: Option[List[Ipv6Address]] = None,
      ipAddressType: Option[String] = None,
      hardware: Option[InstanceHardware] = None,
      networking: Option[InstanceNetworking] = None,
      state: Option[InstanceState] = None,
      username: Option[String] = None,
      sshKeyName: Option[String] = None
    ): Instance =
      Instance
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(blueprintId)(_.blueprintId(_))
        .ifSome(blueprintName)(_.blueprintName(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(addOns)(_.addOns(_))
        .ifSome(isStaticIp)(_.isStaticIp(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(publicIpAddress)(_.publicIpAddress(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(hardware)(_.hardware(_))
        .ifSome(networking)(_.networking(_))
        .ifSome(state)(_.state(_))
        .ifSome(username)(_.username(_))
        .ifSome(sshKeyName)(_.sshKeyName(_))
        .build

    def instanceAccessDetails(
      certKey: Option[String] = None,
      expiresAt: Option[IsoDate] = None,
      ipAddress: Option[String] = None,
      password: Option[String] = None,
      passwordData: Option[PasswordData] = None,
      privateKey: Option[String] = None,
      protocol: Option[String] = None,
      instanceName: Option[String] = None,
      username: Option[String] = None,
      hostKeys: Option[List[HostKeyAttributes]] = None
    ): InstanceAccessDetails =
      InstanceAccessDetails
        .builder
        .ifSome(certKey)(_.certKey(_))
        .ifSome(expiresAt)(_.expiresAt(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(password)(_.password(_))
        .ifSome(passwordData)(_.passwordData(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(username)(_.username(_))
        .ifSome(hostKeys)(_.hostKeys(_))
        .build

    def instanceEntry(
      sourceName: Option[String] = None,
      instanceType: Option[String] = None,
      portInfoSource: Option[String] = None,
      userData: Option[String] = None,
      availabilityZone: Option[String] = None
    ): InstanceEntry =
      InstanceEntry
        .builder
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(portInfoSource)(_.portInfoSource(_))
        .ifSome(userData)(_.userData(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .build

    def instanceHardware(
      cpuCount: Option[Int] = None,
      disks: Option[List[Disk]] = None,
      ramSizeInGb: Option[float] = None
    ): InstanceHardware =
      InstanceHardware
        .builder
        .ifSome(cpuCount)(_.cpuCount(_))
        .ifSome(disks)(_.disks(_))
        .ifSome(ramSizeInGb)(_.ramSizeInGb(_))
        .build

    def instanceHealthSummary(
      instanceName: Option[String] = None,
      instanceHealth: Option[String] = None,
      instanceHealthReason: Option[String] = None
    ): InstanceHealthSummary =
      InstanceHealthSummary
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(instanceHealth)(_.instanceHealth(_))
        .ifSome(instanceHealthReason)(_.instanceHealthReason(_))
        .build

    def instanceNetworking(
      monthlyTransfer: Option[MonthlyTransfer] = None,
      ports: Option[List[InstancePortInfo]] = None
    ): InstanceNetworking =
      InstanceNetworking
        .builder
        .ifSome(monthlyTransfer)(_.monthlyTransfer(_))
        .ifSome(ports)(_.ports(_))
        .build

    def instancePortInfo(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None,
      protocol: Option[String] = None,
      accessFrom: Option[String] = None,
      accessType: Option[String] = None,
      commonName: Option[String] = None,
      accessDirection: Option[String] = None,
      cidrs: Option[List[string]] = None,
      ipv6Cidrs: Option[List[string]] = None,
      cidrListAliases: Option[List[string]] = None
    ): InstancePortInfo =
      InstancePortInfo
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(accessFrom)(_.accessFrom(_))
        .ifSome(accessType)(_.accessType(_))
        .ifSome(commonName)(_.commonName(_))
        .ifSome(accessDirection)(_.accessDirection(_))
        .ifSome(cidrs)(_.cidrs(_))
        .ifSome(ipv6Cidrs)(_.ipv6Cidrs(_))
        .ifSome(cidrListAliases)(_.cidrListAliases(_))
        .build

    def instancePortState(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None,
      protocol: Option[String] = None,
      state: Option[String] = None,
      cidrs: Option[List[string]] = None,
      ipv6Cidrs: Option[List[string]] = None,
      cidrListAliases: Option[List[string]] = None
    ): InstancePortState =
      InstancePortState
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(state)(_.state(_))
        .ifSome(cidrs)(_.cidrs(_))
        .ifSome(ipv6Cidrs)(_.ipv6Cidrs(_))
        .ifSome(cidrListAliases)(_.cidrListAliases(_))
        .build

    def instanceSnapshot(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      state: Option[String] = None,
      progress: Option[String] = None,
      fromAttachedDisks: Option[List[Disk]] = None,
      fromInstanceName: Option[String] = None,
      fromInstanceArn: Option[String] = None,
      fromBlueprintId: Option[String] = None,
      fromBundleId: Option[String] = None,
      isFromAutoSnapshot: Option[Boolean] = None,
      sizeInGb: Option[Int] = None
    ): InstanceSnapshot =
      InstanceSnapshot
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(state)(_.state(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(fromAttachedDisks)(_.fromAttachedDisks(_))
        .ifSome(fromInstanceName)(_.fromInstanceName(_))
        .ifSome(fromInstanceArn)(_.fromInstanceArn(_))
        .ifSome(fromBlueprintId)(_.fromBlueprintId(_))
        .ifSome(fromBundleId)(_.fromBundleId(_))
        .ifSome(isFromAutoSnapshot)(_.isFromAutoSnapshot(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .build

    def instanceSnapshotInfo(
      fromBundleId: Option[String] = None,
      fromBlueprintId: Option[String] = None,
      fromDiskInfo: Option[List[DiskInfo]] = None
    ): InstanceSnapshotInfo =
      InstanceSnapshotInfo
        .builder
        .ifSome(fromBundleId)(_.fromBundleId(_))
        .ifSome(fromBlueprintId)(_.fromBlueprintId(_))
        .ifSome(fromDiskInfo)(_.fromDiskInfo(_))
        .build

    def instanceState(
      code: Option[Int] = None,
      name: Option[String] = None
    ): InstanceState =
      InstanceState
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(name)(_.name(_))
        .build

    def invalidInputException(
      code: Option[String] = None,
      docs: Option[String] = None,
      message: Option[String] = None,
      tip: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(docs)(_.docs(_))
        .ifSome(message)(_.message(_))
        .ifSome(tip)(_.tip(_))
        .build

    def isVpcPeeredRequest(

    ): IsVpcPeeredRequest =
      IsVpcPeeredRequest
        .builder

        .build

    def keyPair(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      fingerprint: Option[String] = None
    ): KeyPair =
      KeyPair
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fingerprint)(_.fingerprint(_))
        .build

    def lightsailDistribution(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      alternativeDomainNames: Option[List[string]] = None,
      status: Option[String] = None,
      isEnabled: Option[Boolean] = None,
      domainName: Option[String] = None,
      bundleId: Option[String] = None,
      certificateName: Option[String] = None,
      origin: Option[Origin] = None,
      originPublicDNS: Option[String] = None,
      defaultCacheBehavior: Option[CacheBehavior] = None,
      cacheBehaviorSettings: Option[CacheSettings] = None,
      cacheBehaviors: Option[List[CacheBehaviorPerPath]] = None,
      ableToUpdateBundle: Option[Boolean] = None,
      ipAddressType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LightsailDistribution =
      LightsailDistribution
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(alternativeDomainNames)(_.alternativeDomainNames(_))
        .ifSome(status)(_.status(_))
        .ifSome(isEnabled)(_.isEnabled(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(originPublicDNS)(_.originPublicDNS(_))
        .ifSome(defaultCacheBehavior)(_.defaultCacheBehavior(_))
        .ifSome(cacheBehaviorSettings)(_.cacheBehaviorSettings(_))
        .ifSome(cacheBehaviors)(_.cacheBehaviors(_))
        .ifSome(ableToUpdateBundle)(_.ableToUpdateBundle(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def loadBalancer(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      dnsName: Option[String] = None,
      state: Option[String] = None,
      protocol: Option[String] = None,
      publicPorts: Option[List[Port]] = None,
      healthCheckPath: Option[String] = None,
      instancePort: Option[Int] = None,
      instanceHealthSummary: Option[List[InstanceHealthSummary]] = None,
      tlsCertificateSummaries: Option[List[LoadBalancerTlsCertificateSummary]] = None,
      configurationOptions: Option[LoadBalancerConfigurationOptions] = None,
      ipAddressType: Option[String] = None
    ): LoadBalancer =
      LoadBalancer
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(state)(_.state(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(publicPorts)(_.publicPorts(_))
        .ifSome(healthCheckPath)(_.healthCheckPath(_))
        .ifSome(instancePort)(_.instancePort(_))
        .ifSome(instanceHealthSummary)(_.instanceHealthSummary(_))
        .ifSome(tlsCertificateSummaries)(_.tlsCertificateSummaries(_))
        .ifSome(configurationOptions)(_.configurationOptions(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def loadBalancerTlsCertificate(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      loadBalancerName: Option[String] = None,
      isAttached: Option[Boolean] = None,
      status: Option[String] = None,
      domainName: Option[String] = None,
      domainValidationRecords: Option[List[LoadBalancerTlsCertificateDomainValidationRecord]] = None,
      failureReason: Option[String] = None,
      issuedAt: Option[IsoDate] = None,
      issuer: Option[String] = None,
      keyAlgorithm: Option[String] = None,
      notAfter: Option[IsoDate] = None,
      notBefore: Option[IsoDate] = None,
      renewalSummary: Option[LoadBalancerTlsCertificateRenewalSummary] = None,
      revocationReason: Option[String] = None,
      revokedAt: Option[IsoDate] = None,
      serial: Option[String] = None,
      signatureAlgorithm: Option[String] = None,
      subject: Option[String] = None,
      subjectAlternativeNames: Option[List[string]] = None
    ): LoadBalancerTlsCertificate =
      LoadBalancerTlsCertificate
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(isAttached)(_.isAttached(_))
        .ifSome(status)(_.status(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainValidationRecords)(_.domainValidationRecords(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(issuedAt)(_.issuedAt(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(keyAlgorithm)(_.keyAlgorithm(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(renewalSummary)(_.renewalSummary(_))
        .ifSome(revocationReason)(_.revocationReason(_))
        .ifSome(revokedAt)(_.revokedAt(_))
        .ifSome(serial)(_.serial(_))
        .ifSome(signatureAlgorithm)(_.signatureAlgorithm(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .build

    def loadBalancerTlsCertificateDomainValidationOption(
      domainName: Option[String] = None,
      validationStatus: Option[String] = None
    ): LoadBalancerTlsCertificateDomainValidationOption =
      LoadBalancerTlsCertificateDomainValidationOption
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(validationStatus)(_.validationStatus(_))
        .build

    def loadBalancerTlsCertificateDomainValidationRecord(
      name: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None,
      validationStatus: Option[String] = None,
      domainName: Option[String] = None
    ): LoadBalancerTlsCertificateDomainValidationRecord =
      LoadBalancerTlsCertificateDomainValidationRecord
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .ifSome(validationStatus)(_.validationStatus(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def loadBalancerTlsCertificateRenewalSummary(
      renewalStatus: Option[String] = None,
      domainValidationOptions: Option[List[LoadBalancerTlsCertificateDomainValidationOption]] = None
    ): LoadBalancerTlsCertificateRenewalSummary =
      LoadBalancerTlsCertificateRenewalSummary
        .builder
        .ifSome(renewalStatus)(_.renewalStatus(_))
        .ifSome(domainValidationOptions)(_.domainValidationOptions(_))
        .build

    def loadBalancerTlsCertificateSummary(
      name: Option[String] = None,
      isAttached: Option[Boolean] = None
    ): LoadBalancerTlsCertificateSummary =
      LoadBalancerTlsCertificateSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(isAttached)(_.isAttached(_))
        .build

    def logEvent(
      createdAt: Option[IsoDate] = None,
      message: Option[String] = None
    ): LogEvent =
      LogEvent
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(message)(_.message(_))
        .build

    def metricDatapoint(
      average: Option[double] = None,
      maximum: Option[double] = None,
      minimum: Option[double] = None,
      sampleCount: Option[double] = None,
      sum: Option[double] = None,
      timestamp: Option[timestamp] = None,
      unit: Option[String] = None
    ): MetricDatapoint =
      MetricDatapoint
        .builder
        .ifSome(average)(_.average(_))
        .ifSome(maximum)(_.maximum(_))
        .ifSome(minimum)(_.minimum(_))
        .ifSome(sampleCount)(_.sampleCount(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(unit)(_.unit(_))
        .build

    def monitoredResourceInfo(
      arn: Option[String] = None,
      name: Option[String] = None,
      resourceType: Option[String] = None
    ): MonitoredResourceInfo =
      MonitoredResourceInfo
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def monthlyTransfer(
      gbPerMonthAllocated: Option[Int] = None
    ): MonthlyTransfer =
      MonthlyTransfer
        .builder
        .ifSome(gbPerMonthAllocated)(_.gbPerMonthAllocated(_))
        .build

    def notFoundException(
      code: Option[String] = None,
      docs: Option[String] = None,
      message: Option[String] = None,
      tip: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(docs)(_.docs(_))
        .ifSome(message)(_.message(_))
        .ifSome(tip)(_.tip(_))
        .build

    def openInstancePublicPortsRequest(
      portInfo: Option[PortInfo] = None,
      instanceName: Option[String] = None
    ): OpenInstancePublicPortsRequest =
      OpenInstancePublicPortsRequest
        .builder
        .ifSome(portInfo)(_.portInfo(_))
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def operation(
      id: Option[String] = None,
      resourceName: Option[String] = None,
      resourceType: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      isTerminal: Option[Boolean] = None,
      operationDetails: Option[String] = None,
      operationType: Option[String] = None,
      status: Option[String] = None,
      statusChangedAt: Option[IsoDate] = None,
      errorCode: Option[String] = None,
      errorDetails: Option[String] = None
    ): Operation =
      Operation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(isTerminal)(_.isTerminal(_))
        .ifSome(operationDetails)(_.operationDetails(_))
        .ifSome(operationType)(_.operationType(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusChangedAt)(_.statusChangedAt(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .build

    def operationFailureException(
      code: Option[String] = None,
      docs: Option[String] = None,
      message: Option[String] = None,
      tip: Option[String] = None
    ): OperationFailureException =
      OperationFailureException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(docs)(_.docs(_))
        .ifSome(message)(_.message(_))
        .ifSome(tip)(_.tip(_))
        .build

    def origin(
      name: Option[String] = None,
      resourceType: Option[String] = None,
      regionName: Option[String] = None,
      protocolPolicy: Option[String] = None
    ): Origin =
      Origin
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(regionName)(_.regionName(_))
        .ifSome(protocolPolicy)(_.protocolPolicy(_))
        .build

    def passwordData(
      ciphertext: Option[String] = None,
      keyPairName: Option[String] = None
    ): PasswordData =
      PasswordData
        .builder
        .ifSome(ciphertext)(_.ciphertext(_))
        .ifSome(keyPairName)(_.keyPairName(_))
        .build

    def peerVpcRequest(

    ): PeerVpcRequest =
      PeerVpcRequest
        .builder

        .build

    def pendingMaintenanceAction(
      action: Option[String] = None,
      description: Option[String] = None,
      currentApplyDate: Option[IsoDate] = None
    ): PendingMaintenanceAction =
      PendingMaintenanceAction
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(description)(_.description(_))
        .ifSome(currentApplyDate)(_.currentApplyDate(_))
        .build

    def pendingModifiedRelationalDatabaseValues(
      masterUserPassword: Option[String] = None,
      engineVersion: Option[String] = None,
      backupRetentionEnabled: Option[Boolean] = None
    ): PendingModifiedRelationalDatabaseValues =
      PendingModifiedRelationalDatabaseValues
        .builder
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(backupRetentionEnabled)(_.backupRetentionEnabled(_))
        .build

    def portInfo(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None,
      protocol: Option[String] = None,
      cidrs: Option[List[string]] = None,
      ipv6Cidrs: Option[List[string]] = None,
      cidrListAliases: Option[List[string]] = None
    ): PortInfo =
      PortInfo
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(cidrs)(_.cidrs(_))
        .ifSome(ipv6Cidrs)(_.ipv6Cidrs(_))
        .ifSome(cidrListAliases)(_.cidrListAliases(_))
        .build

    def putAlarmRequest(
      alarmName: Option[String] = None,
      metricName: Option[String] = None,
      monitoredResourceName: Option[String] = None,
      comparisonOperator: Option[String] = None,
      threshold: Option[double] = None,
      evaluationPeriods: Option[Int] = None,
      datapointsToAlarm: Option[Int] = None,
      treatMissingData: Option[String] = None,
      contactProtocols: Option[List[ContactProtocol]] = None,
      notificationTriggers: Option[List[AlarmState]] = None,
      notificationEnabled: Option[Boolean] = None
    ): PutAlarmRequest =
      PutAlarmRequest
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(monitoredResourceName)(_.monitoredResourceName(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(datapointsToAlarm)(_.datapointsToAlarm(_))
        .ifSome(treatMissingData)(_.treatMissingData(_))
        .ifSome(contactProtocols)(_.contactProtocols(_))
        .ifSome(notificationTriggers)(_.notificationTriggers(_))
        .ifSome(notificationEnabled)(_.notificationEnabled(_))
        .build

    def putInstancePublicPortsRequest(
      portInfos: Option[List[PortInfo]] = None,
      instanceName: Option[String] = None
    ): PutInstancePublicPortsRequest =
      PutInstancePublicPortsRequest
        .builder
        .ifSome(portInfos)(_.portInfos(_))
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def queryStringObject(
      option: Option[Boolean] = None,
      queryStringsAllowList: Option[List[string]] = None
    ): QueryStringObject =
      QueryStringObject
        .builder
        .ifSome(option)(_.option(_))
        .ifSome(queryStringsAllowList)(_.queryStringsAllowList(_))
        .build

    def rebootInstanceRequest(
      instanceName: Option[String] = None
    ): RebootInstanceRequest =
      RebootInstanceRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def rebootRelationalDatabaseRequest(
      relationalDatabaseName: Option[String] = None
    ): RebootRelationalDatabaseRequest =
      RebootRelationalDatabaseRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .build

    def region(
      continentCode: Option[String] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      name: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None,
      relationalDatabaseAvailabilityZones: Option[List[AvailabilityZone]] = None
    ): Region =
      Region
        .builder
        .ifSome(continentCode)(_.continentCode(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(name)(_.name(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(relationalDatabaseAvailabilityZones)(_.relationalDatabaseAvailabilityZones(_))
        .build

    def registerContainerImageRequest(
      serviceName: Option[String] = None,
      label: Option[String] = None,
      digest: Option[String] = None
    ): RegisterContainerImageRequest =
      RegisterContainerImageRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(label)(_.label(_))
        .ifSome(digest)(_.digest(_))
        .build

    def relationalDatabase(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      relationalDatabaseBlueprintId: Option[String] = None,
      relationalDatabaseBundleId: Option[String] = None,
      masterDatabaseName: Option[String] = None,
      hardware: Option[RelationalDatabaseHardware] = None,
      state: Option[String] = None,
      secondaryAvailabilityZone: Option[String] = None,
      backupRetentionEnabled: Option[Boolean] = None,
      pendingModifiedValues: Option[PendingModifiedRelationalDatabaseValues] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      latestRestorableTime: Option[IsoDate] = None,
      masterUsername: Option[String] = None,
      parameterApplyStatus: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      masterEndpoint: Option[RelationalDatabaseEndpoint] = None,
      pendingMaintenanceActions: Option[List[PendingMaintenanceAction]] = None,
      caCertificateIdentifier: Option[String] = None
    ): RelationalDatabase =
      RelationalDatabase
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(relationalDatabaseBlueprintId)(_.relationalDatabaseBlueprintId(_))
        .ifSome(relationalDatabaseBundleId)(_.relationalDatabaseBundleId(_))
        .ifSome(masterDatabaseName)(_.masterDatabaseName(_))
        .ifSome(hardware)(_.hardware(_))
        .ifSome(state)(_.state(_))
        .ifSome(secondaryAvailabilityZone)(_.secondaryAvailabilityZone(_))
        .ifSome(backupRetentionEnabled)(_.backupRetentionEnabled(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(latestRestorableTime)(_.latestRestorableTime(_))
        .ifSome(masterUsername)(_.masterUsername(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(masterEndpoint)(_.masterEndpoint(_))
        .ifSome(pendingMaintenanceActions)(_.pendingMaintenanceActions(_))
        .ifSome(caCertificateIdentifier)(_.caCertificateIdentifier(_))
        .build

    def relationalDatabaseBlueprint(
      blueprintId: Option[String] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      engineDescription: Option[String] = None,
      engineVersionDescription: Option[String] = None,
      isEngineDefault: Option[Boolean] = None
    ): RelationalDatabaseBlueprint =
      RelationalDatabaseBlueprint
        .builder
        .ifSome(blueprintId)(_.blueprintId(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(engineDescription)(_.engineDescription(_))
        .ifSome(engineVersionDescription)(_.engineVersionDescription(_))
        .ifSome(isEngineDefault)(_.isEngineDefault(_))
        .build

    def relationalDatabaseBundle(
      bundleId: Option[String] = None,
      name: Option[String] = None,
      price: Option[float] = None,
      ramSizeInGb: Option[float] = None,
      diskSizeInGb: Option[Int] = None,
      transferPerMonthInGb: Option[Int] = None,
      cpuCount: Option[Int] = None,
      isEncrypted: Option[Boolean] = None,
      isActive: Option[Boolean] = None
    ): RelationalDatabaseBundle =
      RelationalDatabaseBundle
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(price)(_.price(_))
        .ifSome(ramSizeInGb)(_.ramSizeInGb(_))
        .ifSome(diskSizeInGb)(_.diskSizeInGb(_))
        .ifSome(transferPerMonthInGb)(_.transferPerMonthInGb(_))
        .ifSome(cpuCount)(_.cpuCount(_))
        .ifSome(isEncrypted)(_.isEncrypted(_))
        .ifSome(isActive)(_.isActive(_))
        .build

    def relationalDatabaseEndpoint(
      port: Option[Int] = None,
      address: Option[String] = None
    ): RelationalDatabaseEndpoint =
      RelationalDatabaseEndpoint
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(address)(_.address(_))
        .build

    def relationalDatabaseEvent(
      resource: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      message: Option[String] = None,
      eventCategories: Option[List[string]] = None
    ): RelationalDatabaseEvent =
      RelationalDatabaseEvent
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(message)(_.message(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .build

    def relationalDatabaseHardware(
      cpuCount: Option[Int] = None,
      diskSizeInGb: Option[Int] = None,
      ramSizeInGb: Option[float] = None
    ): RelationalDatabaseHardware =
      RelationalDatabaseHardware
        .builder
        .ifSome(cpuCount)(_.cpuCount(_))
        .ifSome(diskSizeInGb)(_.diskSizeInGb(_))
        .ifSome(ramSizeInGb)(_.ramSizeInGb(_))
        .build

    def relationalDatabaseParameter(
      allowedValues: Option[String] = None,
      applyMethod: Option[String] = None,
      applyType: Option[String] = None,
      dataType: Option[String] = None,
      description: Option[String] = None,
      isModifiable: Option[Boolean] = None,
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None
    ): RelationalDatabaseParameter =
      RelationalDatabaseParameter
        .builder
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(applyMethod)(_.applyMethod(_))
        .ifSome(applyType)(_.applyType(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(description)(_.description(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .build

    def relationalDatabaseSnapshot(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      engine: Option[String] = None,
      engineVersion: Option[String] = None,
      sizeInGb: Option[Int] = None,
      state: Option[String] = None,
      fromRelationalDatabaseName: Option[String] = None,
      fromRelationalDatabaseArn: Option[String] = None,
      fromRelationalDatabaseBundleId: Option[String] = None,
      fromRelationalDatabaseBlueprintId: Option[String] = None
    ): RelationalDatabaseSnapshot =
      RelationalDatabaseSnapshot
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(sizeInGb)(_.sizeInGb(_))
        .ifSome(state)(_.state(_))
        .ifSome(fromRelationalDatabaseName)(_.fromRelationalDatabaseName(_))
        .ifSome(fromRelationalDatabaseArn)(_.fromRelationalDatabaseArn(_))
        .ifSome(fromRelationalDatabaseBundleId)(_.fromRelationalDatabaseBundleId(_))
        .ifSome(fromRelationalDatabaseBlueprintId)(_.fromRelationalDatabaseBlueprintId(_))
        .build

    def releaseStaticIpRequest(
      staticIpName: Option[String] = None
    ): ReleaseStaticIpRequest =
      ReleaseStaticIpRequest
        .builder
        .ifSome(staticIpName)(_.staticIpName(_))
        .build

    def renewalSummary(
      domainValidationRecords: Option[List[DomainValidationRecord]] = None,
      renewalStatus: Option[String] = None,
      renewalStatusReason: Option[String] = None,
      updatedAt: Option[IsoDate] = None
    ): RenewalSummary =
      RenewalSummary
        .builder
        .ifSome(domainValidationRecords)(_.domainValidationRecords(_))
        .ifSome(renewalStatus)(_.renewalStatus(_))
        .ifSome(renewalStatusReason)(_.renewalStatusReason(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def resetDistributionCacheRequest(
      distributionName: Option[String] = None
    ): ResetDistributionCacheRequest =
      ResetDistributionCacheRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .build

    def resourceLocation(
      availabilityZone: Option[String] = None,
      regionName: Option[String] = None
    ): ResourceLocation =
      ResourceLocation
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(regionName)(_.regionName(_))
        .build

    def resourceRecord(
      name: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None
    ): ResourceRecord =
      ResourceRecord
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def sendContactMethodVerificationRequest(
      protocol: Option[String] = None
    ): SendContactMethodVerificationRequest =
      SendContactMethodVerificationRequest
        .builder
        .ifSome(protocol)(_.protocol(_))
        .build

    def serviceException(
      code: Option[String] = None,
      docs: Option[String] = None,
      message: Option[String] = None,
      tip: Option[String] = None
    ): ServiceException =
      ServiceException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(docs)(_.docs(_))
        .ifSome(message)(_.message(_))
        .ifSome(tip)(_.tip(_))
        .build

    def setIpAddressTypeRequest(
      resourceType: Option[String] = None,
      resourceName: Option[String] = None,
      ipAddressType: Option[String] = None
    ): SetIpAddressTypeRequest =
      SetIpAddressTypeRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(ipAddressType)(_.ipAddressType(_))
        .build

    def startInstanceRequest(
      instanceName: Option[String] = None
    ): StartInstanceRequest =
      StartInstanceRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .build

    def startRelationalDatabaseRequest(
      relationalDatabaseName: Option[String] = None
    ): StartRelationalDatabaseRequest =
      StartRelationalDatabaseRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .build

    def staticIp(
      name: Option[String] = None,
      arn: Option[String] = None,
      supportCode: Option[String] = None,
      createdAt: Option[IsoDate] = None,
      location: Option[ResourceLocation] = None,
      resourceType: Option[String] = None,
      ipAddress: Option[String] = None,
      attachedTo: Option[String] = None,
      isAttached: Option[Boolean] = None
    ): StaticIp =
      StaticIp
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(supportCode)(_.supportCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(location)(_.location(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(attachedTo)(_.attachedTo(_))
        .ifSome(isAttached)(_.isAttached(_))
        .build

    def stopInstanceRequest(
      instanceName: Option[String] = None,
      force: Option[Boolean] = None
    ): StopInstanceRequest =
      StopInstanceRequest
        .builder
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(force)(_.force(_))
        .build

    def stopRelationalDatabaseRequest(
      relationalDatabaseName: Option[String] = None,
      relationalDatabaseSnapshotName: Option[String] = None
    ): StopRelationalDatabaseRequest =
      StopRelationalDatabaseRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(relationalDatabaseSnapshotName)(_.relationalDatabaseSnapshotName(_))
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
      resourceName: Option[String] = None,
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def testAlarmRequest(
      alarmName: Option[String] = None,
      state: Option[String] = None
    ): TestAlarmRequest =
      TestAlarmRequest
        .builder
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(state)(_.state(_))
        .build

    def unauthenticatedException(
      code: Option[String] = None,
      docs: Option[String] = None,
      message: Option[String] = None,
      tip: Option[String] = None
    ): UnauthenticatedException =
      UnauthenticatedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(docs)(_.docs(_))
        .ifSome(message)(_.message(_))
        .ifSome(tip)(_.tip(_))
        .build

    def unpeerVpcRequest(

    ): UnpeerVpcRequest =
      UnpeerVpcRequest
        .builder

        .build

    def untagResourceRequest(
      resourceName: Option[String] = None,
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateContainerServiceRequest(
      serviceName: Option[String] = None,
      power: Option[String] = None,
      scale: Option[Int] = None,
      isDisabled: Option[Boolean] = None,
      publicDomainNames: Option[ContainerServicePublicDomains] = None
    ): UpdateContainerServiceRequest =
      UpdateContainerServiceRequest
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(power)(_.power(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(isDisabled)(_.isDisabled(_))
        .ifSome(publicDomainNames)(_.publicDomainNames(_))
        .build

    def updateDistributionBundleRequest(
      distributionName: Option[String] = None,
      bundleId: Option[String] = None
    ): UpdateDistributionBundleRequest =
      UpdateDistributionBundleRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .ifSome(bundleId)(_.bundleId(_))
        .build

    def updateDistributionRequest(
      distributionName: Option[String] = None,
      origin: Option[InputOrigin] = None,
      defaultCacheBehavior: Option[CacheBehavior] = None,
      cacheBehaviorSettings: Option[CacheSettings] = None,
      cacheBehaviors: Option[List[CacheBehaviorPerPath]] = None,
      isEnabled: Option[Boolean] = None
    ): UpdateDistributionRequest =
      UpdateDistributionRequest
        .builder
        .ifSome(distributionName)(_.distributionName(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(defaultCacheBehavior)(_.defaultCacheBehavior(_))
        .ifSome(cacheBehaviorSettings)(_.cacheBehaviorSettings(_))
        .ifSome(cacheBehaviors)(_.cacheBehaviors(_))
        .ifSome(isEnabled)(_.isEnabled(_))
        .build

    def updateDomainEntryRequest(
      domainName: Option[String] = None,
      domainEntry: Option[DomainEntry] = None
    ): UpdateDomainEntryRequest =
      UpdateDomainEntryRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainEntry)(_.domainEntry(_))
        .build

    def updateLoadBalancerAttributeRequest(
      loadBalancerName: Option[String] = None,
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None
    ): UpdateLoadBalancerAttributeRequest =
      UpdateLoadBalancerAttributeRequest
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def updateRelationalDatabaseParametersRequest(
      relationalDatabaseName: Option[String] = None,
      parameters: Option[List[RelationalDatabaseParameter]] = None
    ): UpdateRelationalDatabaseParametersRequest =
      UpdateRelationalDatabaseParametersRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def updateRelationalDatabaseRequest(
      relationalDatabaseName: Option[String] = None,
      masterUserPassword: Option[String] = None,
      rotateMasterUserPassword: Option[Boolean] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      enableBackupRetention: Option[Boolean] = None,
      disableBackupRetention: Option[Boolean] = None,
      publiclyAccessible: Option[Boolean] = None,
      applyImmediately: Option[Boolean] = None,
      caCertificateIdentifier: Option[String] = None
    ): UpdateRelationalDatabaseRequest =
      UpdateRelationalDatabaseRequest
        .builder
        .ifSome(relationalDatabaseName)(_.relationalDatabaseName(_))
        .ifSome(masterUserPassword)(_.masterUserPassword(_))
        .ifSome(rotateMasterUserPassword)(_.rotateMasterUserPassword(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(enableBackupRetention)(_.enableBackupRetention(_))
        .ifSome(disableBackupRetention)(_.disableBackupRetention(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(caCertificateIdentifier)(_.caCertificateIdentifier(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
