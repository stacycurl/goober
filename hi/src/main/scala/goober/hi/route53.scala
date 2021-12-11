package goober.hi

import goober.free.route53.Route53IO
import software.amazon.awssdk.services.route53.model._


object route53 {
  import goober.free.{route53 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountLimit(
      `type`: Option[String] = None,
      value: Option[LimitValue] = None
    ): AccountLimit =
      AccountLimit
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def activateKeySigningKeyRequest(
      hostedZoneId: Option[String] = None,
      name: Option[String] = None
    ): ActivateKeySigningKeyRequest =
      ActivateKeySigningKeyRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(name)(_.name(_))
        .build

    def activateKeySigningKeyResponse(
      changeInfo: Option[ChangeInfo] = None
    ): ActivateKeySigningKeyResponse =
      ActivateKeySigningKeyResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def alarmIdentifier(
      region: Option[String] = None,
      name: Option[String] = None
    ): AlarmIdentifier =
      AlarmIdentifier
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(name)(_.name(_))
        .build

    def aliasTarget(
      hostedZoneId: Option[String] = None,
      dNSName: Option[String] = None,
      evaluateTargetHealth: Option[Boolean] = None
    ): AliasTarget =
      AliasTarget
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(dNSName)(_.dNSName(_))
        .ifSome(evaluateTargetHealth)(_.evaluateTargetHealth(_))
        .build

    def associateVPCWithHostedZoneRequest(
      hostedZoneId: Option[String] = None,
      vPC: Option[VPC] = None,
      comment: Option[String] = None
    ): AssociateVPCWithHostedZoneRequest =
      AssociateVPCWithHostedZoneRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(vPC)(_.vPC(_))
        .ifSome(comment)(_.comment(_))
        .build

    def associateVPCWithHostedZoneResponse(
      changeInfo: Option[ChangeInfo] = None
    ): AssociateVPCWithHostedZoneResponse =
      AssociateVPCWithHostedZoneResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def change(
      action: Option[String] = None,
      resourceRecordSet: Option[ResourceRecordSet] = None
    ): Change =
      Change
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(resourceRecordSet)(_.resourceRecordSet(_))
        .build

    def changeBatch(
      comment: Option[String] = None,
      changes: Option[List[Change]] = None
    ): ChangeBatch =
      ChangeBatch
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(changes)(_.changes(_))
        .build

    def changeInfo(
      id: Option[String] = None,
      status: Option[String] = None,
      submittedAt: Option[TimeStamp] = None,
      comment: Option[String] = None
    ): ChangeInfo =
      ChangeInfo
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(submittedAt)(_.submittedAt(_))
        .ifSome(comment)(_.comment(_))
        .build

    def changeResourceRecordSetsRequest(
      hostedZoneId: Option[String] = None,
      changeBatch: Option[ChangeBatch] = None
    ): ChangeResourceRecordSetsRequest =
      ChangeResourceRecordSetsRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(changeBatch)(_.changeBatch(_))
        .build

    def changeResourceRecordSetsResponse(
      changeInfo: Option[ChangeInfo] = None
    ): ChangeResourceRecordSetsResponse =
      ChangeResourceRecordSetsResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def changeTagsForResourceRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      addTags: Option[List[Tag]] = None,
      removeTagKeys: Option[List[TagKey]] = None
    ): ChangeTagsForResourceRequest =
      ChangeTagsForResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(addTags)(_.addTags(_))
        .ifSome(removeTagKeys)(_.removeTagKeys(_))
        .build

    def changeTagsForResourceResponse(

    ): ChangeTagsForResourceResponse =
      ChangeTagsForResourceResponse
        .builder

        .build

    def cloudWatchAlarmConfiguration(
      evaluationPeriods: Option[Int] = None,
      threshold: Option[Threshold] = None,
      comparisonOperator: Option[String] = None,
      period: Option[Int] = None,
      metricName: Option[String] = None,
      namespace: Option[String] = None,
      statistic: Option[String] = None,
      dimensions: Option[List[Dimension]] = None
    ): CloudWatchAlarmConfiguration =
      CloudWatchAlarmConfiguration
        .builder
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(period)(_.period(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(statistic)(_.statistic(_))
        .ifSome(dimensions)(_.dimensions(_))
        .build

    def concurrentModification(
      message: Option[String] = None
    ): ConcurrentModification =
      ConcurrentModification
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictingDomainExists(
      message: Option[String] = None
    ): ConflictingDomainExists =
      ConflictingDomainExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictingTypes(
      message: Option[String] = None
    ): ConflictingTypes =
      ConflictingTypes
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createHealthCheckRequest(
      callerReference: Option[String] = None,
      healthCheckConfig: Option[HealthCheckConfig] = None
    ): CreateHealthCheckRequest =
      CreateHealthCheckRequest
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(healthCheckConfig)(_.healthCheckConfig(_))
        .build

    def createHealthCheckResponse(
      healthCheck: Option[HealthCheck] = None,
      location: Option[String] = None
    ): CreateHealthCheckResponse =
      CreateHealthCheckResponse
        .builder
        .ifSome(healthCheck)(_.healthCheck(_))
        .ifSome(location)(_.location(_))
        .build

    def createHostedZoneRequest(
      name: Option[String] = None,
      vPC: Option[VPC] = None,
      callerReference: Option[String] = None,
      hostedZoneConfig: Option[HostedZoneConfig] = None,
      delegationSetId: Option[String] = None
    ): CreateHostedZoneRequest =
      CreateHostedZoneRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(vPC)(_.vPC(_))
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(hostedZoneConfig)(_.hostedZoneConfig(_))
        .ifSome(delegationSetId)(_.delegationSetId(_))
        .build

    def createHostedZoneResponse(
      hostedZone: Option[HostedZone] = None,
      changeInfo: Option[ChangeInfo] = None,
      delegationSet: Option[DelegationSet] = None,
      vPC: Option[VPC] = None,
      location: Option[String] = None
    ): CreateHostedZoneResponse =
      CreateHostedZoneResponse
        .builder
        .ifSome(hostedZone)(_.hostedZone(_))
        .ifSome(changeInfo)(_.changeInfo(_))
        .ifSome(delegationSet)(_.delegationSet(_))
        .ifSome(vPC)(_.vPC(_))
        .ifSome(location)(_.location(_))
        .build

    def createKeySigningKeyRequest(
      callerReference: Option[String] = None,
      hostedZoneId: Option[String] = None,
      keyManagementServiceArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None
    ): CreateKeySigningKeyRequest =
      CreateKeySigningKeyRequest
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(keyManagementServiceArn)(_.keyManagementServiceArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def createKeySigningKeyResponse(
      changeInfo: Option[ChangeInfo] = None,
      keySigningKey: Option[KeySigningKey] = None,
      location: Option[String] = None
    ): CreateKeySigningKeyResponse =
      CreateKeySigningKeyResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .ifSome(keySigningKey)(_.keySigningKey(_))
        .ifSome(location)(_.location(_))
        .build

    def createQueryLoggingConfigRequest(
      hostedZoneId: Option[String] = None,
      cloudWatchLogsLogGroupArn: Option[String] = None
    ): CreateQueryLoggingConfigRequest =
      CreateQueryLoggingConfigRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .build

    def createQueryLoggingConfigResponse(
      queryLoggingConfig: Option[QueryLoggingConfig] = None,
      location: Option[String] = None
    ): CreateQueryLoggingConfigResponse =
      CreateQueryLoggingConfigResponse
        .builder
        .ifSome(queryLoggingConfig)(_.queryLoggingConfig(_))
        .ifSome(location)(_.location(_))
        .build

    def createReusableDelegationSetRequest(
      callerReference: Option[String] = None,
      hostedZoneId: Option[String] = None
    ): CreateReusableDelegationSetRequest =
      CreateReusableDelegationSetRequest
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def createReusableDelegationSetResponse(
      delegationSet: Option[DelegationSet] = None,
      location: Option[String] = None
    ): CreateReusableDelegationSetResponse =
      CreateReusableDelegationSetResponse
        .builder
        .ifSome(delegationSet)(_.delegationSet(_))
        .ifSome(location)(_.location(_))
        .build

    def createTrafficPolicyInstanceRequest(
      hostedZoneId: Option[String] = None,
      name: Option[String] = None,
      tTL: Option[TTL] = None,
      trafficPolicyId: Option[String] = None,
      trafficPolicyVersion: Option[Int] = None
    ): CreateTrafficPolicyInstanceRequest =
      CreateTrafficPolicyInstanceRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(name)(_.name(_))
        .ifSome(tTL)(_.tTL(_))
        .ifSome(trafficPolicyId)(_.trafficPolicyId(_))
        .ifSome(trafficPolicyVersion)(_.trafficPolicyVersion(_))
        .build

    def createTrafficPolicyInstanceResponse(
      trafficPolicyInstance: Option[TrafficPolicyInstance] = None,
      location: Option[String] = None
    ): CreateTrafficPolicyInstanceResponse =
      CreateTrafficPolicyInstanceResponse
        .builder
        .ifSome(trafficPolicyInstance)(_.trafficPolicyInstance(_))
        .ifSome(location)(_.location(_))
        .build

    def createTrafficPolicyRequest(
      name: Option[String] = None,
      document: Option[String] = None,
      comment: Option[String] = None
    ): CreateTrafficPolicyRequest =
      CreateTrafficPolicyRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(document)(_.document(_))
        .ifSome(comment)(_.comment(_))
        .build

    def createTrafficPolicyResponse(
      trafficPolicy: Option[TrafficPolicy] = None,
      location: Option[String] = None
    ): CreateTrafficPolicyResponse =
      CreateTrafficPolicyResponse
        .builder
        .ifSome(trafficPolicy)(_.trafficPolicy(_))
        .ifSome(location)(_.location(_))
        .build

    def createTrafficPolicyVersionRequest(
      id: Option[String] = None,
      document: Option[String] = None,
      comment: Option[String] = None
    ): CreateTrafficPolicyVersionRequest =
      CreateTrafficPolicyVersionRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(document)(_.document(_))
        .ifSome(comment)(_.comment(_))
        .build

    def createTrafficPolicyVersionResponse(
      trafficPolicy: Option[TrafficPolicy] = None,
      location: Option[String] = None
    ): CreateTrafficPolicyVersionResponse =
      CreateTrafficPolicyVersionResponse
        .builder
        .ifSome(trafficPolicy)(_.trafficPolicy(_))
        .ifSome(location)(_.location(_))
        .build

    def createVPCAssociationAuthorizationRequest(
      hostedZoneId: Option[String] = None,
      vPC: Option[VPC] = None
    ): CreateVPCAssociationAuthorizationRequest =
      CreateVPCAssociationAuthorizationRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(vPC)(_.vPC(_))
        .build

    def createVPCAssociationAuthorizationResponse(
      hostedZoneId: Option[String] = None,
      vPC: Option[VPC] = None
    ): CreateVPCAssociationAuthorizationResponse =
      CreateVPCAssociationAuthorizationResponse
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(vPC)(_.vPC(_))
        .build

    def dNSSECNotFound(
      message: Option[String] = None
    ): DNSSECNotFound =
      DNSSECNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dNSSECStatus(
      serveSignature: Option[String] = None,
      statusMessage: Option[String] = None
    ): DNSSECStatus =
      DNSSECStatus
        .builder
        .ifSome(serveSignature)(_.serveSignature(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def deactivateKeySigningKeyRequest(
      hostedZoneId: Option[String] = None,
      name: Option[String] = None
    ): DeactivateKeySigningKeyRequest =
      DeactivateKeySigningKeyRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(name)(_.name(_))
        .build

    def deactivateKeySigningKeyResponse(
      changeInfo: Option[ChangeInfo] = None
    ): DeactivateKeySigningKeyResponse =
      DeactivateKeySigningKeyResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def delegationSet(
      id: Option[String] = None,
      callerReference: Option[String] = None,
      nameServers: Option[List[DNSName]] = None
    ): DelegationSet =
      DelegationSet
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(nameServers)(_.nameServers(_))
        .build

    def delegationSetAlreadyCreated(
      message: Option[String] = None
    ): DelegationSetAlreadyCreated =
      DelegationSetAlreadyCreated
        .builder
        .ifSome(message)(_.message(_))
        .build

    def delegationSetAlreadyReusable(
      message: Option[String] = None
    ): DelegationSetAlreadyReusable =
      DelegationSetAlreadyReusable
        .builder
        .ifSome(message)(_.message(_))
        .build

    def delegationSetInUse(
      message: Option[String] = None
    ): DelegationSetInUse =
      DelegationSetInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def delegationSetNotAvailable(
      message: Option[String] = None
    ): DelegationSetNotAvailable =
      DelegationSetNotAvailable
        .builder
        .ifSome(message)(_.message(_))
        .build

    def delegationSetNotReusable(
      message: Option[String] = None
    ): DelegationSetNotReusable =
      DelegationSetNotReusable
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteHealthCheckRequest(
      healthCheckId: Option[String] = None
    ): DeleteHealthCheckRequest =
      DeleteHealthCheckRequest
        .builder
        .ifSome(healthCheckId)(_.healthCheckId(_))
        .build

    def deleteHealthCheckResponse(

    ): DeleteHealthCheckResponse =
      DeleteHealthCheckResponse
        .builder

        .build

    def deleteHostedZoneRequest(
      id: Option[String] = None
    ): DeleteHostedZoneRequest =
      DeleteHostedZoneRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteHostedZoneResponse(
      changeInfo: Option[ChangeInfo] = None
    ): DeleteHostedZoneResponse =
      DeleteHostedZoneResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def deleteKeySigningKeyRequest(
      hostedZoneId: Option[String] = None,
      name: Option[String] = None
    ): DeleteKeySigningKeyRequest =
      DeleteKeySigningKeyRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteKeySigningKeyResponse(
      changeInfo: Option[ChangeInfo] = None
    ): DeleteKeySigningKeyResponse =
      DeleteKeySigningKeyResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def deleteQueryLoggingConfigRequest(
      id: Option[String] = None
    ): DeleteQueryLoggingConfigRequest =
      DeleteQueryLoggingConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteQueryLoggingConfigResponse(

    ): DeleteQueryLoggingConfigResponse =
      DeleteQueryLoggingConfigResponse
        .builder

        .build

    def deleteReusableDelegationSetRequest(
      id: Option[String] = None
    ): DeleteReusableDelegationSetRequest =
      DeleteReusableDelegationSetRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteReusableDelegationSetResponse(

    ): DeleteReusableDelegationSetResponse =
      DeleteReusableDelegationSetResponse
        .builder

        .build

    def deleteTrafficPolicyInstanceRequest(
      id: Option[String] = None
    ): DeleteTrafficPolicyInstanceRequest =
      DeleteTrafficPolicyInstanceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteTrafficPolicyInstanceResponse(

    ): DeleteTrafficPolicyInstanceResponse =
      DeleteTrafficPolicyInstanceResponse
        .builder

        .build

    def deleteTrafficPolicyRequest(
      id: Option[String] = None,
      version: Option[Int] = None
    ): DeleteTrafficPolicyRequest =
      DeleteTrafficPolicyRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteTrafficPolicyResponse(

    ): DeleteTrafficPolicyResponse =
      DeleteTrafficPolicyResponse
        .builder

        .build

    def deleteVPCAssociationAuthorizationRequest(
      hostedZoneId: Option[String] = None,
      vPC: Option[VPC] = None
    ): DeleteVPCAssociationAuthorizationRequest =
      DeleteVPCAssociationAuthorizationRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(vPC)(_.vPC(_))
        .build

    def deleteVPCAssociationAuthorizationResponse(

    ): DeleteVPCAssociationAuthorizationResponse =
      DeleteVPCAssociationAuthorizationResponse
        .builder

        .build

    def dimension(
      name: Option[String] = None,
      value: Option[String] = None
    ): Dimension =
      Dimension
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def disableHostedZoneDNSSECRequest(
      hostedZoneId: Option[String] = None
    ): DisableHostedZoneDNSSECRequest =
      DisableHostedZoneDNSSECRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def disableHostedZoneDNSSECResponse(
      changeInfo: Option[ChangeInfo] = None
    ): DisableHostedZoneDNSSECResponse =
      DisableHostedZoneDNSSECResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def disassociateVPCFromHostedZoneRequest(
      hostedZoneId: Option[String] = None,
      vPC: Option[VPC] = None,
      comment: Option[String] = None
    ): DisassociateVPCFromHostedZoneRequest =
      DisassociateVPCFromHostedZoneRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(vPC)(_.vPC(_))
        .ifSome(comment)(_.comment(_))
        .build

    def disassociateVPCFromHostedZoneResponse(
      changeInfo: Option[ChangeInfo] = None
    ): DisassociateVPCFromHostedZoneResponse =
      DisassociateVPCFromHostedZoneResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def enableHostedZoneDNSSECRequest(
      hostedZoneId: Option[String] = None
    ): EnableHostedZoneDNSSECRequest =
      EnableHostedZoneDNSSECRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def enableHostedZoneDNSSECResponse(
      changeInfo: Option[ChangeInfo] = None
    ): EnableHostedZoneDNSSECResponse =
      EnableHostedZoneDNSSECResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def geoLocation(
      continentCode: Option[String] = None,
      countryCode: Option[String] = None,
      subdivisionCode: Option[String] = None
    ): GeoLocation =
      GeoLocation
        .builder
        .ifSome(continentCode)(_.continentCode(_))
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(subdivisionCode)(_.subdivisionCode(_))
        .build

    def geoLocationDetails(
      continentCode: Option[String] = None,
      continentName: Option[String] = None,
      countryCode: Option[String] = None,
      countryName: Option[String] = None,
      subdivisionCode: Option[String] = None,
      subdivisionName: Option[String] = None
    ): GeoLocationDetails =
      GeoLocationDetails
        .builder
        .ifSome(continentCode)(_.continentCode(_))
        .ifSome(continentName)(_.continentName(_))
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(countryName)(_.countryName(_))
        .ifSome(subdivisionCode)(_.subdivisionCode(_))
        .ifSome(subdivisionName)(_.subdivisionName(_))
        .build

    def getAccountLimitRequest(
      `type`: Option[String] = None
    ): GetAccountLimitRequest =
      GetAccountLimitRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def getAccountLimitResponse(
      limit: Option[AccountLimit] = None,
      count: Option[UsageCount] = None
    ): GetAccountLimitResponse =
      GetAccountLimitResponse
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(count)(_.count(_))
        .build

    def getChangeRequest(
      id: Option[String] = None
    ): GetChangeRequest =
      GetChangeRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getChangeResponse(
      changeInfo: Option[ChangeInfo] = None
    ): GetChangeResponse =
      GetChangeResponse
        .builder
        .ifSome(changeInfo)(_.changeInfo(_))
        .build

    def getCheckerIpRangesRequest(

    ): GetCheckerIpRangesRequest =
      GetCheckerIpRangesRequest
        .builder

        .build

    def getCheckerIpRangesResponse(
      checkerIpRanges: Option[List[IPAddressCidr]] = None
    ): GetCheckerIpRangesResponse =
      GetCheckerIpRangesResponse
        .builder
        .ifSome(checkerIpRanges)(_.checkerIpRanges(_))
        .build

    def getDNSSECRequest(
      hostedZoneId: Option[String] = None
    ): GetDNSSECRequest =
      GetDNSSECRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def getDNSSECResponse(
      status: Option[DNSSECStatus] = None,
      keySigningKeys: Option[List[KeySigningKey]] = None
    ): GetDNSSECResponse =
      GetDNSSECResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(keySigningKeys)(_.keySigningKeys(_))
        .build

    def getGeoLocationRequest(
      continentCode: Option[String] = None,
      countryCode: Option[String] = None,
      subdivisionCode: Option[String] = None
    ): GetGeoLocationRequest =
      GetGeoLocationRequest
        .builder
        .ifSome(continentCode)(_.continentCode(_))
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(subdivisionCode)(_.subdivisionCode(_))
        .build

    def getGeoLocationResponse(
      geoLocationDetails: Option[GeoLocationDetails] = None
    ): GetGeoLocationResponse =
      GetGeoLocationResponse
        .builder
        .ifSome(geoLocationDetails)(_.geoLocationDetails(_))
        .build

    def getHealthCheckCountRequest(

    ): GetHealthCheckCountRequest =
      GetHealthCheckCountRequest
        .builder

        .build

    def getHealthCheckCountResponse(
      healthCheckCount: Option[HealthCheckCount] = None
    ): GetHealthCheckCountResponse =
      GetHealthCheckCountResponse
        .builder
        .ifSome(healthCheckCount)(_.healthCheckCount(_))
        .build

    def getHealthCheckLastFailureReasonRequest(
      healthCheckId: Option[String] = None
    ): GetHealthCheckLastFailureReasonRequest =
      GetHealthCheckLastFailureReasonRequest
        .builder
        .ifSome(healthCheckId)(_.healthCheckId(_))
        .build

    def getHealthCheckLastFailureReasonResponse(
      healthCheckObservations: Option[List[HealthCheckObservation]] = None
    ): GetHealthCheckLastFailureReasonResponse =
      GetHealthCheckLastFailureReasonResponse
        .builder
        .ifSome(healthCheckObservations)(_.healthCheckObservations(_))
        .build

    def getHealthCheckRequest(
      healthCheckId: Option[String] = None
    ): GetHealthCheckRequest =
      GetHealthCheckRequest
        .builder
        .ifSome(healthCheckId)(_.healthCheckId(_))
        .build

    def getHealthCheckResponse(
      healthCheck: Option[HealthCheck] = None
    ): GetHealthCheckResponse =
      GetHealthCheckResponse
        .builder
        .ifSome(healthCheck)(_.healthCheck(_))
        .build

    def getHealthCheckStatusRequest(
      healthCheckId: Option[String] = None
    ): GetHealthCheckStatusRequest =
      GetHealthCheckStatusRequest
        .builder
        .ifSome(healthCheckId)(_.healthCheckId(_))
        .build

    def getHealthCheckStatusResponse(
      healthCheckObservations: Option[List[HealthCheckObservation]] = None
    ): GetHealthCheckStatusResponse =
      GetHealthCheckStatusResponse
        .builder
        .ifSome(healthCheckObservations)(_.healthCheckObservations(_))
        .build

    def getHostedZoneCountRequest(

    ): GetHostedZoneCountRequest =
      GetHostedZoneCountRequest
        .builder

        .build

    def getHostedZoneCountResponse(
      hostedZoneCount: Option[HostedZoneCount] = None
    ): GetHostedZoneCountResponse =
      GetHostedZoneCountResponse
        .builder
        .ifSome(hostedZoneCount)(_.hostedZoneCount(_))
        .build

    def getHostedZoneLimitRequest(
      `type`: Option[String] = None,
      hostedZoneId: Option[String] = None
    ): GetHostedZoneLimitRequest =
      GetHostedZoneLimitRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def getHostedZoneLimitResponse(
      limit: Option[HostedZoneLimit] = None,
      count: Option[UsageCount] = None
    ): GetHostedZoneLimitResponse =
      GetHostedZoneLimitResponse
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(count)(_.count(_))
        .build

    def getHostedZoneRequest(
      id: Option[String] = None
    ): GetHostedZoneRequest =
      GetHostedZoneRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getHostedZoneResponse(
      hostedZone: Option[HostedZone] = None,
      delegationSet: Option[DelegationSet] = None,
      vPCs: Option[List[VPC]] = None
    ): GetHostedZoneResponse =
      GetHostedZoneResponse
        .builder
        .ifSome(hostedZone)(_.hostedZone(_))
        .ifSome(delegationSet)(_.delegationSet(_))
        .ifSome(vPCs)(_.vPCs(_))
        .build

    def getQueryLoggingConfigRequest(
      id: Option[String] = None
    ): GetQueryLoggingConfigRequest =
      GetQueryLoggingConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getQueryLoggingConfigResponse(
      queryLoggingConfig: Option[QueryLoggingConfig] = None
    ): GetQueryLoggingConfigResponse =
      GetQueryLoggingConfigResponse
        .builder
        .ifSome(queryLoggingConfig)(_.queryLoggingConfig(_))
        .build

    def getReusableDelegationSetLimitRequest(
      `type`: Option[String] = None,
      delegationSetId: Option[String] = None
    ): GetReusableDelegationSetLimitRequest =
      GetReusableDelegationSetLimitRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(delegationSetId)(_.delegationSetId(_))
        .build

    def getReusableDelegationSetLimitResponse(
      limit: Option[ReusableDelegationSetLimit] = None,
      count: Option[UsageCount] = None
    ): GetReusableDelegationSetLimitResponse =
      GetReusableDelegationSetLimitResponse
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(count)(_.count(_))
        .build

    def getReusableDelegationSetRequest(
      id: Option[String] = None
    ): GetReusableDelegationSetRequest =
      GetReusableDelegationSetRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getReusableDelegationSetResponse(
      delegationSet: Option[DelegationSet] = None
    ): GetReusableDelegationSetResponse =
      GetReusableDelegationSetResponse
        .builder
        .ifSome(delegationSet)(_.delegationSet(_))
        .build

    def getTrafficPolicyInstanceCountRequest(

    ): GetTrafficPolicyInstanceCountRequest =
      GetTrafficPolicyInstanceCountRequest
        .builder

        .build

    def getTrafficPolicyInstanceCountResponse(
      trafficPolicyInstanceCount: Option[Int] = None
    ): GetTrafficPolicyInstanceCountResponse =
      GetTrafficPolicyInstanceCountResponse
        .builder
        .ifSome(trafficPolicyInstanceCount)(_.trafficPolicyInstanceCount(_))
        .build

    def getTrafficPolicyInstanceRequest(
      id: Option[String] = None
    ): GetTrafficPolicyInstanceRequest =
      GetTrafficPolicyInstanceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getTrafficPolicyInstanceResponse(
      trafficPolicyInstance: Option[TrafficPolicyInstance] = None
    ): GetTrafficPolicyInstanceResponse =
      GetTrafficPolicyInstanceResponse
        .builder
        .ifSome(trafficPolicyInstance)(_.trafficPolicyInstance(_))
        .build

    def getTrafficPolicyRequest(
      id: Option[String] = None,
      version: Option[Int] = None
    ): GetTrafficPolicyRequest =
      GetTrafficPolicyRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def getTrafficPolicyResponse(
      trafficPolicy: Option[TrafficPolicy] = None
    ): GetTrafficPolicyResponse =
      GetTrafficPolicyResponse
        .builder
        .ifSome(trafficPolicy)(_.trafficPolicy(_))
        .build

    def healthCheck(
      id: Option[String] = None,
      callerReference: Option[String] = None,
      linkedService: Option[LinkedService] = None,
      healthCheckConfig: Option[HealthCheckConfig] = None,
      healthCheckVersion: Option[HealthCheckVersion] = None,
      cloudWatchAlarmConfiguration: Option[CloudWatchAlarmConfiguration] = None
    ): HealthCheck =
      HealthCheck
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(linkedService)(_.linkedService(_))
        .ifSome(healthCheckConfig)(_.healthCheckConfig(_))
        .ifSome(healthCheckVersion)(_.healthCheckVersion(_))
        .ifSome(cloudWatchAlarmConfiguration)(_.cloudWatchAlarmConfiguration(_))
        .build

    def healthCheckAlreadyExists(
      message: Option[String] = None
    ): HealthCheckAlreadyExists =
      HealthCheckAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def healthCheckConfig(
      iPAddress: Option[String] = None,
      port: Option[Int] = None,
      `type`: Option[String] = None,
      resourcePath: Option[String] = None,
      fullyQualifiedDomainName: Option[String] = None,
      searchString: Option[String] = None,
      requestInterval: Option[Int] = None,
      failureThreshold: Option[Int] = None,
      measureLatency: Option[Boolean] = None,
      inverted: Option[Boolean] = None,
      disabled: Option[Boolean] = None,
      healthThreshold: Option[Int] = None,
      childHealthChecks: Option[List[HealthCheckId]] = None,
      enableSNI: Option[Boolean] = None,
      regions: Option[List[HealthCheckRegion]] = None,
      alarmIdentifier: Option[AlarmIdentifier] = None,
      insufficientDataHealthStatus: Option[String] = None
    ): HealthCheckConfig =
      HealthCheckConfig
        .builder
        .ifSome(iPAddress)(_.iPAddress(_))
        .ifSome(port)(_.port(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(resourcePath)(_.resourcePath(_))
        .ifSome(fullyQualifiedDomainName)(_.fullyQualifiedDomainName(_))
        .ifSome(searchString)(_.searchString(_))
        .ifSome(requestInterval)(_.requestInterval(_))
        .ifSome(failureThreshold)(_.failureThreshold(_))
        .ifSome(measureLatency)(_.measureLatency(_))
        .ifSome(inverted)(_.inverted(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(healthThreshold)(_.healthThreshold(_))
        .ifSome(childHealthChecks)(_.childHealthChecks(_))
        .ifSome(enableSNI)(_.enableSNI(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(alarmIdentifier)(_.alarmIdentifier(_))
        .ifSome(insufficientDataHealthStatus)(_.insufficientDataHealthStatus(_))
        .build

    def healthCheckInUse(
      message: Option[String] = None
    ): HealthCheckInUse =
      HealthCheckInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def healthCheckObservation(
      region: Option[String] = None,
      iPAddress: Option[String] = None,
      statusReport: Option[StatusReport] = None
    ): HealthCheckObservation =
      HealthCheckObservation
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(iPAddress)(_.iPAddress(_))
        .ifSome(statusReport)(_.statusReport(_))
        .build

    def healthCheckVersionMismatch(
      message: Option[String] = None
    ): HealthCheckVersionMismatch =
      HealthCheckVersionMismatch
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hostedZone(
      id: Option[String] = None,
      name: Option[String] = None,
      callerReference: Option[String] = None,
      config: Option[HostedZoneConfig] = None,
      resourceRecordSetCount: Option[HostedZoneRRSetCount] = None,
      linkedService: Option[LinkedService] = None
    ): HostedZone =
      HostedZone
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(config)(_.config(_))
        .ifSome(resourceRecordSetCount)(_.resourceRecordSetCount(_))
        .ifSome(linkedService)(_.linkedService(_))
        .build

    def hostedZoneAlreadyExists(
      message: Option[String] = None
    ): HostedZoneAlreadyExists =
      HostedZoneAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hostedZoneConfig(
      comment: Option[String] = None,
      privateZone: Option[Boolean] = None
    ): HostedZoneConfig =
      HostedZoneConfig
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(privateZone)(_.privateZone(_))
        .build

    def hostedZoneLimit(
      `type`: Option[String] = None,
      value: Option[LimitValue] = None
    ): HostedZoneLimit =
      HostedZoneLimit
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def hostedZoneNotEmpty(
      message: Option[String] = None
    ): HostedZoneNotEmpty =
      HostedZoneNotEmpty
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hostedZoneNotFound(
      message: Option[String] = None
    ): HostedZoneNotFound =
      HostedZoneNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hostedZoneNotPrivate(
      message: Option[String] = None
    ): HostedZoneNotPrivate =
      HostedZoneNotPrivate
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hostedZoneOwner(
      owningAccount: Option[String] = None,
      owningService: Option[String] = None
    ): HostedZoneOwner =
      HostedZoneOwner
        .builder
        .ifSome(owningAccount)(_.owningAccount(_))
        .ifSome(owningService)(_.owningService(_))
        .build

    def hostedZonePartiallyDelegated(
      message: Option[String] = None
    ): HostedZonePartiallyDelegated =
      HostedZonePartiallyDelegated
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hostedZoneSummary(
      hostedZoneId: Option[String] = None,
      name: Option[String] = None,
      owner: Option[HostedZoneOwner] = None
    ): HostedZoneSummary =
      HostedZoneSummary
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .build

    def incompatibleVersion(
      message: Option[String] = None
    ): IncompatibleVersion =
      IncompatibleVersion
        .builder
        .ifSome(message)(_.message(_))
        .build

    def insufficientCloudWatchLogsResourcePolicy(
      message: Option[String] = None
    ): InsufficientCloudWatchLogsResourcePolicy =
      InsufficientCloudWatchLogsResourcePolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArgument(
      message: Option[String] = None
    ): InvalidArgument =
      InvalidArgument
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidChangeBatch(
      messages: Option[List[ErrorMessage]] = None,
      message: Option[String] = None
    ): InvalidChangeBatch =
      InvalidChangeBatch
        .builder
        .ifSome(messages)(_.messages(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidDomainName(
      message: Option[String] = None
    ): InvalidDomainName =
      InvalidDomainName
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInput(
      message: Option[String] = None
    ): InvalidInput =
      InvalidInput
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidKMSArn(
      message: Option[String] = None
    ): InvalidKMSArn =
      InvalidKMSArn
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidKeySigningKeyName(
      message: Option[String] = None
    ): InvalidKeySigningKeyName =
      InvalidKeySigningKeyName
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidKeySigningKeyStatus(
      message: Option[String] = None
    ): InvalidKeySigningKeyStatus =
      InvalidKeySigningKeyStatus
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPaginationToken(
      message: Option[String] = None
    ): InvalidPaginationToken =
      InvalidPaginationToken
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSigningStatus(
      message: Option[String] = None
    ): InvalidSigningStatus =
      InvalidSigningStatus
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTrafficPolicyDocument(
      message: Option[String] = None
    ): InvalidTrafficPolicyDocument =
      InvalidTrafficPolicyDocument
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidVPCId(
      message: Option[String] = None
    ): InvalidVPCId =
      InvalidVPCId
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keySigningKey(
      name: Option[String] = None,
      kmsArn: Option[String] = None,
      flag: Option[Int] = None,
      signingAlgorithmMnemonic: Option[String] = None,
      signingAlgorithmType: Option[Int] = None,
      digestAlgorithmMnemonic: Option[String] = None,
      digestAlgorithmType: Option[Int] = None,
      keyTag: Option[Int] = None,
      digestValue: Option[String] = None,
      publicKey: Option[String] = None,
      dSRecord: Option[String] = None,
      dNSKEYRecord: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      createdDate: Option[TimeStamp] = None,
      lastModifiedDate: Option[TimeStamp] = None
    ): KeySigningKey =
      KeySigningKey
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(kmsArn)(_.kmsArn(_))
        .ifSome(flag)(_.flag(_))
        .ifSome(signingAlgorithmMnemonic)(_.signingAlgorithmMnemonic(_))
        .ifSome(signingAlgorithmType)(_.signingAlgorithmType(_))
        .ifSome(digestAlgorithmMnemonic)(_.digestAlgorithmMnemonic(_))
        .ifSome(digestAlgorithmType)(_.digestAlgorithmType(_))
        .ifSome(keyTag)(_.keyTag(_))
        .ifSome(digestValue)(_.digestValue(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(dSRecord)(_.dSRecord(_))
        .ifSome(dNSKEYRecord)(_.dNSKEYRecord(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def keySigningKeyAlreadyExists(
      message: Option[String] = None
    ): KeySigningKeyAlreadyExists =
      KeySigningKeyAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keySigningKeyInParentDSRecord(
      message: Option[String] = None
    ): KeySigningKeyInParentDSRecord =
      KeySigningKeyInParentDSRecord
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keySigningKeyInUse(
      message: Option[String] = None
    ): KeySigningKeyInUse =
      KeySigningKeyInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keySigningKeyWithActiveStatusNotFound(
      message: Option[String] = None
    ): KeySigningKeyWithActiveStatusNotFound =
      KeySigningKeyWithActiveStatusNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lastVPCAssociation(
      message: Option[String] = None
    ): LastVPCAssociation =
      LastVPCAssociation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitsExceeded(
      message: Option[String] = None
    ): LimitsExceeded =
      LimitsExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def linkedService(
      servicePrincipal: Option[String] = None,
      description: Option[String] = None
    ): LinkedService =
      LinkedService
        .builder
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .ifSome(description)(_.description(_))
        .build

    def listGeoLocationsRequest(
      startContinentCode: Option[String] = None,
      startCountryCode: Option[String] = None,
      startSubdivisionCode: Option[String] = None,
      maxItems: Option[String] = None
    ): ListGeoLocationsRequest =
      ListGeoLocationsRequest
        .builder
        .ifSome(startContinentCode)(_.startContinentCode(_))
        .ifSome(startCountryCode)(_.startCountryCode(_))
        .ifSome(startSubdivisionCode)(_.startSubdivisionCode(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listGeoLocationsResponse(
      geoLocationDetailsList: Option[List[GeoLocationDetails]] = None,
      isTruncated: Option[Boolean] = None,
      nextContinentCode: Option[String] = None,
      nextCountryCode: Option[String] = None,
      nextSubdivisionCode: Option[String] = None,
      maxItems: Option[String] = None
    ): ListGeoLocationsResponse =
      ListGeoLocationsResponse
        .builder
        .ifSome(geoLocationDetailsList)(_.geoLocationDetailsList(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(nextContinentCode)(_.nextContinentCode(_))
        .ifSome(nextCountryCode)(_.nextCountryCode(_))
        .ifSome(nextSubdivisionCode)(_.nextSubdivisionCode(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listHealthChecksRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListHealthChecksRequest =
      ListHealthChecksRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listHealthChecksResponse(
      healthChecks: Option[List[HealthCheck]] = None,
      marker: Option[String] = None,
      isTruncated: Option[Boolean] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListHealthChecksResponse =
      ListHealthChecksResponse
        .builder
        .ifSome(healthChecks)(_.healthChecks(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listHostedZonesByNameRequest(
      dNSName: Option[String] = None,
      hostedZoneId: Option[String] = None,
      maxItems: Option[String] = None
    ): ListHostedZonesByNameRequest =
      ListHostedZonesByNameRequest
        .builder
        .ifSome(dNSName)(_.dNSName(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listHostedZonesByNameResponse(
      hostedZones: Option[List[HostedZone]] = None,
      dNSName: Option[String] = None,
      hostedZoneId: Option[String] = None,
      isTruncated: Option[Boolean] = None,
      nextDNSName: Option[String] = None,
      nextHostedZoneId: Option[String] = None,
      maxItems: Option[String] = None
    ): ListHostedZonesByNameResponse =
      ListHostedZonesByNameResponse
        .builder
        .ifSome(hostedZones)(_.hostedZones(_))
        .ifSome(dNSName)(_.dNSName(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(nextDNSName)(_.nextDNSName(_))
        .ifSome(nextHostedZoneId)(_.nextHostedZoneId(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listHostedZonesByVPCRequest(
      vPCId: Option[String] = None,
      vPCRegion: Option[String] = None,
      maxItems: Option[String] = None,
      nextToken: Option[String] = None
    ): ListHostedZonesByVPCRequest =
      ListHostedZonesByVPCRequest
        .builder
        .ifSome(vPCId)(_.vPCId(_))
        .ifSome(vPCRegion)(_.vPCRegion(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHostedZonesByVPCResponse(
      hostedZoneSummaries: Option[List[HostedZoneSummary]] = None,
      maxItems: Option[String] = None,
      nextToken: Option[String] = None
    ): ListHostedZonesByVPCResponse =
      ListHostedZonesByVPCResponse
        .builder
        .ifSome(hostedZoneSummaries)(_.hostedZoneSummaries(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHostedZonesRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None,
      delegationSetId: Option[String] = None
    ): ListHostedZonesRequest =
      ListHostedZonesRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(delegationSetId)(_.delegationSetId(_))
        .build

    def listHostedZonesResponse(
      hostedZones: Option[List[HostedZone]] = None,
      marker: Option[String] = None,
      isTruncated: Option[Boolean] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListHostedZonesResponse =
      ListHostedZonesResponse
        .builder
        .ifSome(hostedZones)(_.hostedZones(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listQueryLoggingConfigsRequest(
      hostedZoneId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[String] = None
    ): ListQueryLoggingConfigsRequest =
      ListQueryLoggingConfigsRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listQueryLoggingConfigsResponse(
      queryLoggingConfigs: Option[List[QueryLoggingConfig]] = None,
      nextToken: Option[String] = None
    ): ListQueryLoggingConfigsResponse =
      ListQueryLoggingConfigsResponse
        .builder
        .ifSome(queryLoggingConfigs)(_.queryLoggingConfigs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceRecordSetsRequest(
      hostedZoneId: Option[String] = None,
      startRecordName: Option[String] = None,
      startRecordType: Option[String] = None,
      startRecordIdentifier: Option[String] = None,
      maxItems: Option[String] = None
    ): ListResourceRecordSetsRequest =
      ListResourceRecordSetsRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(startRecordName)(_.startRecordName(_))
        .ifSome(startRecordType)(_.startRecordType(_))
        .ifSome(startRecordIdentifier)(_.startRecordIdentifier(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listResourceRecordSetsResponse(
      resourceRecordSets: Option[List[ResourceRecordSet]] = None,
      isTruncated: Option[Boolean] = None,
      nextRecordName: Option[String] = None,
      nextRecordType: Option[String] = None,
      nextRecordIdentifier: Option[String] = None,
      maxItems: Option[String] = None
    ): ListResourceRecordSetsResponse =
      ListResourceRecordSetsResponse
        .builder
        .ifSome(resourceRecordSets)(_.resourceRecordSets(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(nextRecordName)(_.nextRecordName(_))
        .ifSome(nextRecordType)(_.nextRecordType(_))
        .ifSome(nextRecordIdentifier)(_.nextRecordIdentifier(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listReusableDelegationSetsRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListReusableDelegationSetsRequest =
      ListReusableDelegationSetsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listReusableDelegationSetsResponse(
      delegationSets: Option[List[DelegationSet]] = None,
      marker: Option[String] = None,
      isTruncated: Option[Boolean] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListReusableDelegationSetsResponse =
      ListReusableDelegationSetsResponse
        .builder
        .ifSome(delegationSets)(_.delegationSets(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTagsForResourceRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def listTagsForResourceResponse(
      resourceTagSet: Option[ResourceTagSet] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(resourceTagSet)(_.resourceTagSet(_))
        .build

    def listTagsForResourcesRequest(
      resourceType: Option[String] = None,
      resourceIds: Option[List[TagResourceId]] = None
    ): ListTagsForResourcesRequest =
      ListTagsForResourcesRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .build

    def listTagsForResourcesResponse(
      resourceTagSets: Option[List[ResourceTagSet]] = None
    ): ListTagsForResourcesResponse =
      ListTagsForResourcesResponse
        .builder
        .ifSome(resourceTagSets)(_.resourceTagSets(_))
        .build

    def listTrafficPoliciesRequest(
      trafficPolicyIdMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListTrafficPoliciesRequest =
      ListTrafficPoliciesRequest
        .builder
        .ifSome(trafficPolicyIdMarker)(_.trafficPolicyIdMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPoliciesResponse(
      trafficPolicySummaries: Option[List[TrafficPolicySummary]] = None,
      isTruncated: Option[Boolean] = None,
      trafficPolicyIdMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListTrafficPoliciesResponse =
      ListTrafficPoliciesResponse
        .builder
        .ifSome(trafficPolicySummaries)(_.trafficPolicySummaries(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(trafficPolicyIdMarker)(_.trafficPolicyIdMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyInstancesByHostedZoneRequest(
      hostedZoneId: Option[String] = None,
      trafficPolicyInstanceNameMarker: Option[String] = None,
      trafficPolicyInstanceTypeMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyInstancesByHostedZoneRequest =
      ListTrafficPolicyInstancesByHostedZoneRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(trafficPolicyInstanceNameMarker)(_.trafficPolicyInstanceNameMarker(_))
        .ifSome(trafficPolicyInstanceTypeMarker)(_.trafficPolicyInstanceTypeMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyInstancesByHostedZoneResponse(
      trafficPolicyInstances: Option[List[TrafficPolicyInstance]] = None,
      trafficPolicyInstanceNameMarker: Option[String] = None,
      trafficPolicyInstanceTypeMarker: Option[String] = None,
      isTruncated: Option[Boolean] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyInstancesByHostedZoneResponse =
      ListTrafficPolicyInstancesByHostedZoneResponse
        .builder
        .ifSome(trafficPolicyInstances)(_.trafficPolicyInstances(_))
        .ifSome(trafficPolicyInstanceNameMarker)(_.trafficPolicyInstanceNameMarker(_))
        .ifSome(trafficPolicyInstanceTypeMarker)(_.trafficPolicyInstanceTypeMarker(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyInstancesByPolicyRequest(
      trafficPolicyId: Option[String] = None,
      trafficPolicyVersion: Option[Int] = None,
      hostedZoneIdMarker: Option[String] = None,
      trafficPolicyInstanceNameMarker: Option[String] = None,
      trafficPolicyInstanceTypeMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyInstancesByPolicyRequest =
      ListTrafficPolicyInstancesByPolicyRequest
        .builder
        .ifSome(trafficPolicyId)(_.trafficPolicyId(_))
        .ifSome(trafficPolicyVersion)(_.trafficPolicyVersion(_))
        .ifSome(hostedZoneIdMarker)(_.hostedZoneIdMarker(_))
        .ifSome(trafficPolicyInstanceNameMarker)(_.trafficPolicyInstanceNameMarker(_))
        .ifSome(trafficPolicyInstanceTypeMarker)(_.trafficPolicyInstanceTypeMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyInstancesByPolicyResponse(
      trafficPolicyInstances: Option[List[TrafficPolicyInstance]] = None,
      hostedZoneIdMarker: Option[String] = None,
      trafficPolicyInstanceNameMarker: Option[String] = None,
      trafficPolicyInstanceTypeMarker: Option[String] = None,
      isTruncated: Option[Boolean] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyInstancesByPolicyResponse =
      ListTrafficPolicyInstancesByPolicyResponse
        .builder
        .ifSome(trafficPolicyInstances)(_.trafficPolicyInstances(_))
        .ifSome(hostedZoneIdMarker)(_.hostedZoneIdMarker(_))
        .ifSome(trafficPolicyInstanceNameMarker)(_.trafficPolicyInstanceNameMarker(_))
        .ifSome(trafficPolicyInstanceTypeMarker)(_.trafficPolicyInstanceTypeMarker(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyInstancesRequest(
      hostedZoneIdMarker: Option[String] = None,
      trafficPolicyInstanceNameMarker: Option[String] = None,
      trafficPolicyInstanceTypeMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyInstancesRequest =
      ListTrafficPolicyInstancesRequest
        .builder
        .ifSome(hostedZoneIdMarker)(_.hostedZoneIdMarker(_))
        .ifSome(trafficPolicyInstanceNameMarker)(_.trafficPolicyInstanceNameMarker(_))
        .ifSome(trafficPolicyInstanceTypeMarker)(_.trafficPolicyInstanceTypeMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyInstancesResponse(
      trafficPolicyInstances: Option[List[TrafficPolicyInstance]] = None,
      hostedZoneIdMarker: Option[String] = None,
      trafficPolicyInstanceNameMarker: Option[String] = None,
      trafficPolicyInstanceTypeMarker: Option[String] = None,
      isTruncated: Option[Boolean] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyInstancesResponse =
      ListTrafficPolicyInstancesResponse
        .builder
        .ifSome(trafficPolicyInstances)(_.trafficPolicyInstances(_))
        .ifSome(hostedZoneIdMarker)(_.hostedZoneIdMarker(_))
        .ifSome(trafficPolicyInstanceNameMarker)(_.trafficPolicyInstanceNameMarker(_))
        .ifSome(trafficPolicyInstanceTypeMarker)(_.trafficPolicyInstanceTypeMarker(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyVersionsRequest(
      id: Option[String] = None,
      trafficPolicyVersionMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyVersionsRequest =
      ListTrafficPolicyVersionsRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(trafficPolicyVersionMarker)(_.trafficPolicyVersionMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTrafficPolicyVersionsResponse(
      trafficPolicies: Option[List[TrafficPolicy]] = None,
      isTruncated: Option[Boolean] = None,
      trafficPolicyVersionMarker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListTrafficPolicyVersionsResponse =
      ListTrafficPolicyVersionsResponse
        .builder
        .ifSome(trafficPolicies)(_.trafficPolicies(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(trafficPolicyVersionMarker)(_.trafficPolicyVersionMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listVPCAssociationAuthorizationsRequest(
      hostedZoneId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[String] = None
    ): ListVPCAssociationAuthorizationsRequest =
      ListVPCAssociationAuthorizationsRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listVPCAssociationAuthorizationsResponse(
      hostedZoneId: Option[String] = None,
      nextToken: Option[String] = None,
      vPCs: Option[List[VPC]] = None
    ): ListVPCAssociationAuthorizationsResponse =
      ListVPCAssociationAuthorizationsResponse
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(vPCs)(_.vPCs(_))
        .build

    def noSuchChange(
      message: Option[String] = None
    ): NoSuchChange =
      NoSuchChange
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchCloudWatchLogsLogGroup(
      message: Option[String] = None
    ): NoSuchCloudWatchLogsLogGroup =
      NoSuchCloudWatchLogsLogGroup
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchDelegationSet(
      message: Option[String] = None
    ): NoSuchDelegationSet =
      NoSuchDelegationSet
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchGeoLocation(
      message: Option[String] = None
    ): NoSuchGeoLocation =
      NoSuchGeoLocation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchHealthCheck(
      message: Option[String] = None
    ): NoSuchHealthCheck =
      NoSuchHealthCheck
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchHostedZone(
      message: Option[String] = None
    ): NoSuchHostedZone =
      NoSuchHostedZone
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchKeySigningKey(
      message: Option[String] = None
    ): NoSuchKeySigningKey =
      NoSuchKeySigningKey
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchQueryLoggingConfig(
      message: Option[String] = None
    ): NoSuchQueryLoggingConfig =
      NoSuchQueryLoggingConfig
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchTrafficPolicy(
      message: Option[String] = None
    ): NoSuchTrafficPolicy =
      NoSuchTrafficPolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchTrafficPolicyInstance(
      message: Option[String] = None
    ): NoSuchTrafficPolicyInstance =
      NoSuchTrafficPolicyInstance
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def priorRequestNotComplete(
      message: Option[String] = None
    ): PriorRequestNotComplete =
      PriorRequestNotComplete
        .builder
        .ifSome(message)(_.message(_))
        .build

    def publicZoneVPCAssociation(
      message: Option[String] = None
    ): PublicZoneVPCAssociation =
      PublicZoneVPCAssociation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def queryLoggingConfig(
      id: Option[String] = None,
      hostedZoneId: Option[String] = None,
      cloudWatchLogsLogGroupArn: Option[String] = None
    ): QueryLoggingConfig =
      QueryLoggingConfig
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .build

    def queryLoggingConfigAlreadyExists(
      message: Option[String] = None
    ): QueryLoggingConfigAlreadyExists =
      QueryLoggingConfigAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceRecord(
      value: Option[String] = None
    ): ResourceRecord =
      ResourceRecord
        .builder
        .ifSome(value)(_.value(_))
        .build

    def resourceRecordSet(
      name: Option[String] = None,
      `type`: Option[String] = None,
      setIdentifier: Option[String] = None,
      weight: Option[ResourceRecordSetWeight] = None,
      region: Option[String] = None,
      geoLocation: Option[GeoLocation] = None,
      failover: Option[String] = None,
      multiValueAnswer: Option[Boolean] = None,
      tTL: Option[TTL] = None,
      resourceRecords: Option[List[ResourceRecord]] = None,
      aliasTarget: Option[AliasTarget] = None,
      healthCheckId: Option[String] = None,
      trafficPolicyInstanceId: Option[String] = None
    ): ResourceRecordSet =
      ResourceRecordSet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(setIdentifier)(_.setIdentifier(_))
        .ifSome(weight)(_.weight(_))
        .ifSome(region)(_.region(_))
        .ifSome(geoLocation)(_.geoLocation(_))
        .ifSome(failover)(_.failover(_))
        .ifSome(multiValueAnswer)(_.multiValueAnswer(_))
        .ifSome(tTL)(_.tTL(_))
        .ifSome(resourceRecords)(_.resourceRecords(_))
        .ifSome(aliasTarget)(_.aliasTarget(_))
        .ifSome(healthCheckId)(_.healthCheckId(_))
        .ifSome(trafficPolicyInstanceId)(_.trafficPolicyInstanceId(_))
        .build

    def resourceTagSet(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ResourceTagSet =
      ResourceTagSet
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def reusableDelegationSetLimit(
      `type`: Option[String] = None,
      value: Option[LimitValue] = None
    ): ReusableDelegationSetLimit =
      ReusableDelegationSetLimit
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def statusReport(
      status: Option[String] = None,
      checkedTime: Option[TimeStamp] = None
    ): StatusReport =
      StatusReport
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(checkedTime)(_.checkedTime(_))
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

    def testDNSAnswerRequest(
      hostedZoneId: Option[String] = None,
      recordName: Option[String] = None,
      recordType: Option[String] = None,
      resolverIP: Option[String] = None,
      eDNS0ClientSubnetIP: Option[String] = None,
      eDNS0ClientSubnetMask: Option[String] = None
    ): TestDNSAnswerRequest =
      TestDNSAnswerRequest
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(recordName)(_.recordName(_))
        .ifSome(recordType)(_.recordType(_))
        .ifSome(resolverIP)(_.resolverIP(_))
        .ifSome(eDNS0ClientSubnetIP)(_.eDNS0ClientSubnetIP(_))
        .ifSome(eDNS0ClientSubnetMask)(_.eDNS0ClientSubnetMask(_))
        .build

    def testDNSAnswerResponse(
      nameserver: Option[String] = None,
      recordName: Option[String] = None,
      recordType: Option[String] = None,
      recordData: Option[List[RecordDataEntry]] = None,
      responseCode: Option[String] = None,
      protocol: Option[String] = None
    ): TestDNSAnswerResponse =
      TestDNSAnswerResponse
        .builder
        .ifSome(nameserver)(_.nameserver(_))
        .ifSome(recordName)(_.recordName(_))
        .ifSome(recordType)(_.recordType(_))
        .ifSome(recordData)(_.recordData(_))
        .ifSome(responseCode)(_.responseCode(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyHealthChecks(
      message: Option[String] = None
    ): TooManyHealthChecks =
      TooManyHealthChecks
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyHostedZones(
      message: Option[String] = None
    ): TooManyHostedZones =
      TooManyHostedZones
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyKeySigningKeys(
      message: Option[String] = None
    ): TooManyKeySigningKeys =
      TooManyKeySigningKeys
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTrafficPolicies(
      message: Option[String] = None
    ): TooManyTrafficPolicies =
      TooManyTrafficPolicies
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTrafficPolicyInstances(
      message: Option[String] = None
    ): TooManyTrafficPolicyInstances =
      TooManyTrafficPolicyInstances
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTrafficPolicyVersionsForCurrentPolicy(
      message: Option[String] = None
    ): TooManyTrafficPolicyVersionsForCurrentPolicy =
      TooManyTrafficPolicyVersionsForCurrentPolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyVPCAssociationAuthorizations(
      message: Option[String] = None
    ): TooManyVPCAssociationAuthorizations =
      TooManyVPCAssociationAuthorizations
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trafficPolicy(
      id: Option[String] = None,
      version: Option[Int] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      document: Option[String] = None,
      comment: Option[String] = None
    ): TrafficPolicy =
      TrafficPolicy
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(document)(_.document(_))
        .ifSome(comment)(_.comment(_))
        .build

    def trafficPolicyAlreadyExists(
      message: Option[String] = None
    ): TrafficPolicyAlreadyExists =
      TrafficPolicyAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trafficPolicyInUse(
      message: Option[String] = None
    ): TrafficPolicyInUse =
      TrafficPolicyInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trafficPolicyInstance(
      id: Option[String] = None,
      hostedZoneId: Option[String] = None,
      name: Option[String] = None,
      tTL: Option[TTL] = None,
      state: Option[String] = None,
      message: Option[String] = None,
      trafficPolicyId: Option[String] = None,
      trafficPolicyVersion: Option[Int] = None,
      trafficPolicyType: Option[String] = None
    ): TrafficPolicyInstance =
      TrafficPolicyInstance
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .ifSome(name)(_.name(_))
        .ifSome(tTL)(_.tTL(_))
        .ifSome(state)(_.state(_))
        .ifSome(message)(_.message(_))
        .ifSome(trafficPolicyId)(_.trafficPolicyId(_))
        .ifSome(trafficPolicyVersion)(_.trafficPolicyVersion(_))
        .ifSome(trafficPolicyType)(_.trafficPolicyType(_))
        .build

    def trafficPolicyInstanceAlreadyExists(
      message: Option[String] = None
    ): TrafficPolicyInstanceAlreadyExists =
      TrafficPolicyInstanceAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trafficPolicySummary(
      id: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      latestVersion: Option[Int] = None,
      trafficPolicyCount: Option[Int] = None
    ): TrafficPolicySummary =
      TrafficPolicySummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(trafficPolicyCount)(_.trafficPolicyCount(_))
        .build

    def updateHealthCheckRequest(
      healthCheckId: Option[String] = None,
      healthCheckVersion: Option[HealthCheckVersion] = None,
      iPAddress: Option[String] = None,
      port: Option[Int] = None,
      resourcePath: Option[String] = None,
      fullyQualifiedDomainName: Option[String] = None,
      searchString: Option[String] = None,
      failureThreshold: Option[Int] = None,
      inverted: Option[Boolean] = None,
      disabled: Option[Boolean] = None,
      healthThreshold: Option[Int] = None,
      childHealthChecks: Option[List[HealthCheckId]] = None,
      enableSNI: Option[Boolean] = None,
      regions: Option[List[HealthCheckRegion]] = None,
      alarmIdentifier: Option[AlarmIdentifier] = None,
      insufficientDataHealthStatus: Option[String] = None,
      resetElements: Option[List[ResettableElementName]] = None
    ): UpdateHealthCheckRequest =
      UpdateHealthCheckRequest
        .builder
        .ifSome(healthCheckId)(_.healthCheckId(_))
        .ifSome(healthCheckVersion)(_.healthCheckVersion(_))
        .ifSome(iPAddress)(_.iPAddress(_))
        .ifSome(port)(_.port(_))
        .ifSome(resourcePath)(_.resourcePath(_))
        .ifSome(fullyQualifiedDomainName)(_.fullyQualifiedDomainName(_))
        .ifSome(searchString)(_.searchString(_))
        .ifSome(failureThreshold)(_.failureThreshold(_))
        .ifSome(inverted)(_.inverted(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(healthThreshold)(_.healthThreshold(_))
        .ifSome(childHealthChecks)(_.childHealthChecks(_))
        .ifSome(enableSNI)(_.enableSNI(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(alarmIdentifier)(_.alarmIdentifier(_))
        .ifSome(insufficientDataHealthStatus)(_.insufficientDataHealthStatus(_))
        .ifSome(resetElements)(_.resetElements(_))
        .build

    def updateHealthCheckResponse(
      healthCheck: Option[HealthCheck] = None
    ): UpdateHealthCheckResponse =
      UpdateHealthCheckResponse
        .builder
        .ifSome(healthCheck)(_.healthCheck(_))
        .build

    def updateHostedZoneCommentRequest(
      id: Option[String] = None,
      comment: Option[String] = None
    ): UpdateHostedZoneCommentRequest =
      UpdateHostedZoneCommentRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(comment)(_.comment(_))
        .build

    def updateHostedZoneCommentResponse(
      hostedZone: Option[HostedZone] = None
    ): UpdateHostedZoneCommentResponse =
      UpdateHostedZoneCommentResponse
        .builder
        .ifSome(hostedZone)(_.hostedZone(_))
        .build

    def updateTrafficPolicyCommentRequest(
      id: Option[String] = None,
      version: Option[Int] = None,
      comment: Option[String] = None
    ): UpdateTrafficPolicyCommentRequest =
      UpdateTrafficPolicyCommentRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .ifSome(comment)(_.comment(_))
        .build

    def updateTrafficPolicyCommentResponse(
      trafficPolicy: Option[TrafficPolicy] = None
    ): UpdateTrafficPolicyCommentResponse =
      UpdateTrafficPolicyCommentResponse
        .builder
        .ifSome(trafficPolicy)(_.trafficPolicy(_))
        .build

    def updateTrafficPolicyInstanceRequest(
      id: Option[String] = None,
      tTL: Option[TTL] = None,
      trafficPolicyId: Option[String] = None,
      trafficPolicyVersion: Option[Int] = None
    ): UpdateTrafficPolicyInstanceRequest =
      UpdateTrafficPolicyInstanceRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(tTL)(_.tTL(_))
        .ifSome(trafficPolicyId)(_.trafficPolicyId(_))
        .ifSome(trafficPolicyVersion)(_.trafficPolicyVersion(_))
        .build

    def updateTrafficPolicyInstanceResponse(
      trafficPolicyInstance: Option[TrafficPolicyInstance] = None
    ): UpdateTrafficPolicyInstanceResponse =
      UpdateTrafficPolicyInstanceResponse
        .builder
        .ifSome(trafficPolicyInstance)(_.trafficPolicyInstance(_))
        .build

    def vPC(
      vPCRegion: Option[String] = None,
      vPCId: Option[String] = None
    ): VPC =
      VPC
        .builder
        .ifSome(vPCRegion)(_.vPCRegion(_))
        .ifSome(vPCId)(_.vPCId(_))
        .build

    def vPCAssociationAuthorizationNotFound(
      message: Option[String] = None
    ): VPCAssociationAuthorizationNotFound =
      VPCAssociationAuthorizationNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def vPCAssociationNotFound(
      message: Option[String] = None
    ): VPCAssociationNotFound =
      VPCAssociationNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
