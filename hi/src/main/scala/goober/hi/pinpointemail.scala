package goober.hi

import goober.free.pinpointemail.PinpointEmailIO
import software.amazon.awssdk.services.pinpointemail.model._


object pinpointemail {
  import goober.free.{pinpointemail ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountSuspendedException(

    ): AccountSuspendedException =
      AccountSuspendedException
        .builder

        .build

    def alreadyExistsException(

    ): AlreadyExistsException =
      AlreadyExistsException
        .builder

        .build

    def badRequestException(

    ): BadRequestException =
      BadRequestException
        .builder

        .build

    def blacklistEntry(
      rblName: Option[String] = None,
      listingTime: Option[Timestamp] = None,
      description: Option[String] = None
    ): BlacklistEntry =
      BlacklistEntry
        .builder
        .ifSome(rblName)(_.rblName(_))
        .ifSome(listingTime)(_.listingTime(_))
        .ifSome(description)(_.description(_))
        .build

    def body(
      text: Option[Content] = None,
      html: Option[Content] = None
    ): Body =
      Body
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(html)(_.html(_))
        .build

    def cloudWatchDestination(
      dimensionConfigurations: Option[List[CloudWatchDimensionConfiguration]] = None
    ): CloudWatchDestination =
      CloudWatchDestination
        .builder
        .ifSome(dimensionConfigurations)(_.dimensionConfigurations(_))
        .build

    def cloudWatchDimensionConfiguration(
      dimensionName: Option[String] = None,
      dimensionValueSource: Option[String] = None,
      defaultDimensionValue: Option[String] = None
    ): CloudWatchDimensionConfiguration =
      CloudWatchDimensionConfiguration
        .builder
        .ifSome(dimensionName)(_.dimensionName(_))
        .ifSome(dimensionValueSource)(_.dimensionValueSource(_))
        .ifSome(defaultDimensionValue)(_.defaultDimensionValue(_))
        .build

    def concurrentModificationException(

    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder

        .build

    def content(
      data: Option[String] = None,
      charset: Option[String] = None
    ): Content =
      Content
        .builder
        .ifSome(data)(_.data(_))
        .ifSome(charset)(_.charset(_))
        .build

    def createConfigurationSetEventDestinationRequest(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None,
      eventDestination: Option[EventDestinationDefinition] = None
    ): CreateConfigurationSetEventDestinationRequest =
      CreateConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .ifSome(eventDestination)(_.eventDestination(_))
        .build

    def createConfigurationSetEventDestinationResponse(

    ): CreateConfigurationSetEventDestinationResponse =
      CreateConfigurationSetEventDestinationResponse
        .builder

        .build

    def createConfigurationSetRequest(
      configurationSetName: Option[String] = None,
      trackingOptions: Option[TrackingOptions] = None,
      deliveryOptions: Option[DeliveryOptions] = None,
      reputationOptions: Option[ReputationOptions] = None,
      sendingOptions: Option[SendingOptions] = None,
      tags: Option[List[Tag]] = None
    ): CreateConfigurationSetRequest =
      CreateConfigurationSetRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(trackingOptions)(_.trackingOptions(_))
        .ifSome(deliveryOptions)(_.deliveryOptions(_))
        .ifSome(reputationOptions)(_.reputationOptions(_))
        .ifSome(sendingOptions)(_.sendingOptions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConfigurationSetResponse(

    ): CreateConfigurationSetResponse =
      CreateConfigurationSetResponse
        .builder

        .build

    def createDedicatedIpPoolRequest(
      poolName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDedicatedIpPoolRequest =
      CreateDedicatedIpPoolRequest
        .builder
        .ifSome(poolName)(_.poolName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDedicatedIpPoolResponse(

    ): CreateDedicatedIpPoolResponse =
      CreateDedicatedIpPoolResponse
        .builder

        .build

    def createDeliverabilityTestReportRequest(
      reportName: Option[String] = None,
      fromEmailAddress: Option[String] = None,
      content: Option[EmailContent] = None,
      tags: Option[List[Tag]] = None
    ): CreateDeliverabilityTestReportRequest =
      CreateDeliverabilityTestReportRequest
        .builder
        .ifSome(reportName)(_.reportName(_))
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(content)(_.content(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeliverabilityTestReportResponse(
      reportId: Option[String] = None,
      deliverabilityTestStatus: Option[String] = None
    ): CreateDeliverabilityTestReportResponse =
      CreateDeliverabilityTestReportResponse
        .builder
        .ifSome(reportId)(_.reportId(_))
        .ifSome(deliverabilityTestStatus)(_.deliverabilityTestStatus(_))
        .build

    def createEmailIdentityRequest(
      emailIdentity: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateEmailIdentityRequest =
      CreateEmailIdentityRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEmailIdentityResponse(
      identityType: Option[String] = None,
      verifiedForSendingStatus: Option[Boolean] = None,
      dkimAttributes: Option[DkimAttributes] = None
    ): CreateEmailIdentityResponse =
      CreateEmailIdentityResponse
        .builder
        .ifSome(identityType)(_.identityType(_))
        .ifSome(verifiedForSendingStatus)(_.verifiedForSendingStatus(_))
        .ifSome(dkimAttributes)(_.dkimAttributes(_))
        .build

    def dailyVolume(
      startDate: Option[Timestamp] = None,
      volumeStatistics: Option[VolumeStatistics] = None,
      domainIspPlacements: Option[List[DomainIspPlacement]] = None
    ): DailyVolume =
      DailyVolume
        .builder
        .ifSome(startDate)(_.startDate(_))
        .ifSome(volumeStatistics)(_.volumeStatistics(_))
        .ifSome(domainIspPlacements)(_.domainIspPlacements(_))
        .build

    def dedicatedIp(
      ip: Option[String] = None,
      warmupStatus: Option[String] = None,
      warmupPercentage: Option[Int] = None,
      poolName: Option[String] = None
    ): DedicatedIp =
      DedicatedIp
        .builder
        .ifSome(ip)(_.ip(_))
        .ifSome(warmupStatus)(_.warmupStatus(_))
        .ifSome(warmupPercentage)(_.warmupPercentage(_))
        .ifSome(poolName)(_.poolName(_))
        .build

    def deleteConfigurationSetEventDestinationRequest(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None
    ): DeleteConfigurationSetEventDestinationRequest =
      DeleteConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def deleteConfigurationSetEventDestinationResponse(

    ): DeleteConfigurationSetEventDestinationResponse =
      DeleteConfigurationSetEventDestinationResponse
        .builder

        .build

    def deleteConfigurationSetRequest(
      configurationSetName: Option[String] = None
    ): DeleteConfigurationSetRequest =
      DeleteConfigurationSetRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def deleteConfigurationSetResponse(

    ): DeleteConfigurationSetResponse =
      DeleteConfigurationSetResponse
        .builder

        .build

    def deleteDedicatedIpPoolRequest(
      poolName: Option[String] = None
    ): DeleteDedicatedIpPoolRequest =
      DeleteDedicatedIpPoolRequest
        .builder
        .ifSome(poolName)(_.poolName(_))
        .build

    def deleteDedicatedIpPoolResponse(

    ): DeleteDedicatedIpPoolResponse =
      DeleteDedicatedIpPoolResponse
        .builder

        .build

    def deleteEmailIdentityRequest(
      emailIdentity: Option[String] = None
    ): DeleteEmailIdentityRequest =
      DeleteEmailIdentityRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .build

    def deleteEmailIdentityResponse(

    ): DeleteEmailIdentityResponse =
      DeleteEmailIdentityResponse
        .builder

        .build

    def deliverabilityTestReport(
      reportId: Option[String] = None,
      reportName: Option[String] = None,
      subject: Option[String] = None,
      fromEmailAddress: Option[String] = None,
      createDate: Option[Timestamp] = None,
      deliverabilityTestStatus: Option[String] = None
    ): DeliverabilityTestReport =
      DeliverabilityTestReport
        .builder
        .ifSome(reportId)(_.reportId(_))
        .ifSome(reportName)(_.reportName(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(deliverabilityTestStatus)(_.deliverabilityTestStatus(_))
        .build

    def deliveryOptions(
      tlsPolicy: Option[String] = None,
      sendingPoolName: Option[String] = None
    ): DeliveryOptions =
      DeliveryOptions
        .builder
        .ifSome(tlsPolicy)(_.tlsPolicy(_))
        .ifSome(sendingPoolName)(_.sendingPoolName(_))
        .build

    def destination(
      toAddresses: Option[List[EmailAddress]] = None,
      ccAddresses: Option[List[EmailAddress]] = None,
      bccAddresses: Option[List[EmailAddress]] = None
    ): Destination =
      Destination
        .builder
        .ifSome(toAddresses)(_.toAddresses(_))
        .ifSome(ccAddresses)(_.ccAddresses(_))
        .ifSome(bccAddresses)(_.bccAddresses(_))
        .build

    def dkimAttributes(
      signingEnabled: Option[Boolean] = None,
      status: Option[String] = None,
      tokens: Option[List[DnsToken]] = None
    ): DkimAttributes =
      DkimAttributes
        .builder
        .ifSome(signingEnabled)(_.signingEnabled(_))
        .ifSome(status)(_.status(_))
        .ifSome(tokens)(_.tokens(_))
        .build

    def domainDeliverabilityCampaign(
      campaignId: Option[String] = None,
      imageUrl: Option[String] = None,
      subject: Option[String] = None,
      fromAddress: Option[String] = None,
      sendingIps: Option[List[Ip]] = None,
      firstSeenDateTime: Option[Timestamp] = None,
      lastSeenDateTime: Option[Timestamp] = None,
      inboxCount: Option[Volume] = None,
      spamCount: Option[Volume] = None,
      readRate: Option[Percentage] = None,
      deleteRate: Option[Percentage] = None,
      readDeleteRate: Option[Percentage] = None,
      projectedVolume: Option[Volume] = None,
      esps: Option[List[Esp]] = None
    ): DomainDeliverabilityCampaign =
      DomainDeliverabilityCampaign
        .builder
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(fromAddress)(_.fromAddress(_))
        .ifSome(sendingIps)(_.sendingIps(_))
        .ifSome(firstSeenDateTime)(_.firstSeenDateTime(_))
        .ifSome(lastSeenDateTime)(_.lastSeenDateTime(_))
        .ifSome(inboxCount)(_.inboxCount(_))
        .ifSome(spamCount)(_.spamCount(_))
        .ifSome(readRate)(_.readRate(_))
        .ifSome(deleteRate)(_.deleteRate(_))
        .ifSome(readDeleteRate)(_.readDeleteRate(_))
        .ifSome(projectedVolume)(_.projectedVolume(_))
        .ifSome(esps)(_.esps(_))
        .build

    def domainDeliverabilityTrackingOption(
      domain: Option[String] = None,
      subscriptionStartDate: Option[Timestamp] = None,
      inboxPlacementTrackingOption: Option[InboxPlacementTrackingOption] = None
    ): DomainDeliverabilityTrackingOption =
      DomainDeliverabilityTrackingOption
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(subscriptionStartDate)(_.subscriptionStartDate(_))
        .ifSome(inboxPlacementTrackingOption)(_.inboxPlacementTrackingOption(_))
        .build

    def domainIspPlacement(
      ispName: Option[String] = None,
      inboxRawCount: Option[Volume] = None,
      spamRawCount: Option[Volume] = None,
      inboxPercentage: Option[Percentage] = None,
      spamPercentage: Option[Percentage] = None
    ): DomainIspPlacement =
      DomainIspPlacement
        .builder
        .ifSome(ispName)(_.ispName(_))
        .ifSome(inboxRawCount)(_.inboxRawCount(_))
        .ifSome(spamRawCount)(_.spamRawCount(_))
        .ifSome(inboxPercentage)(_.inboxPercentage(_))
        .ifSome(spamPercentage)(_.spamPercentage(_))
        .build

    def emailContent(
      simple: Option[Message] = None,
      raw: Option[RawMessage] = None,
      template: Option[Template] = None
    ): EmailContent =
      EmailContent
        .builder
        .ifSome(simple)(_.simple(_))
        .ifSome(raw)(_.raw(_))
        .ifSome(template)(_.template(_))
        .build

    def eventDestination(
      name: Option[String] = None,
      enabled: Option[Boolean] = None,
      matchingEventTypes: Option[List[EventType]] = None,
      kinesisFirehoseDestination: Option[KinesisFirehoseDestination] = None,
      cloudWatchDestination: Option[CloudWatchDestination] = None,
      snsDestination: Option[SnsDestination] = None,
      pinpointDestination: Option[PinpointDestination] = None
    ): EventDestination =
      EventDestination
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(matchingEventTypes)(_.matchingEventTypes(_))
        .ifSome(kinesisFirehoseDestination)(_.kinesisFirehoseDestination(_))
        .ifSome(cloudWatchDestination)(_.cloudWatchDestination(_))
        .ifSome(snsDestination)(_.snsDestination(_))
        .ifSome(pinpointDestination)(_.pinpointDestination(_))
        .build

    def eventDestinationDefinition(
      enabled: Option[Boolean] = None,
      matchingEventTypes: Option[List[EventType]] = None,
      kinesisFirehoseDestination: Option[KinesisFirehoseDestination] = None,
      cloudWatchDestination: Option[CloudWatchDestination] = None,
      snsDestination: Option[SnsDestination] = None,
      pinpointDestination: Option[PinpointDestination] = None
    ): EventDestinationDefinition =
      EventDestinationDefinition
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(matchingEventTypes)(_.matchingEventTypes(_))
        .ifSome(kinesisFirehoseDestination)(_.kinesisFirehoseDestination(_))
        .ifSome(cloudWatchDestination)(_.cloudWatchDestination(_))
        .ifSome(snsDestination)(_.snsDestination(_))
        .ifSome(pinpointDestination)(_.pinpointDestination(_))
        .build

    def getAccountRequest(

    ): GetAccountRequest =
      GetAccountRequest
        .builder

        .build

    def getAccountResponse(
      sendQuota: Option[SendQuota] = None,
      sendingEnabled: Option[Boolean] = None,
      dedicatedIpAutoWarmupEnabled: Option[Boolean] = None,
      enforcementStatus: Option[String] = None,
      productionAccessEnabled: Option[Boolean] = None
    ): GetAccountResponse =
      GetAccountResponse
        .builder
        .ifSome(sendQuota)(_.sendQuota(_))
        .ifSome(sendingEnabled)(_.sendingEnabled(_))
        .ifSome(dedicatedIpAutoWarmupEnabled)(_.dedicatedIpAutoWarmupEnabled(_))
        .ifSome(enforcementStatus)(_.enforcementStatus(_))
        .ifSome(productionAccessEnabled)(_.productionAccessEnabled(_))
        .build

    def getBlacklistReportsRequest(
      blacklistItemNames: Option[List[BlacklistItemName]] = None
    ): GetBlacklistReportsRequest =
      GetBlacklistReportsRequest
        .builder
        .ifSome(blacklistItemNames)(_.blacklistItemNames(_))
        .build

    def getBlacklistReportsResponse(
      blacklistReport: Option[BlacklistReport] = None
    ): GetBlacklistReportsResponse =
      GetBlacklistReportsResponse
        .builder
        .ifSome(blacklistReport)(_.blacklistReport(_))
        .build

    def getConfigurationSetEventDestinationsRequest(
      configurationSetName: Option[String] = None
    ): GetConfigurationSetEventDestinationsRequest =
      GetConfigurationSetEventDestinationsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def getConfigurationSetEventDestinationsResponse(
      eventDestinations: Option[List[EventDestination]] = None
    ): GetConfigurationSetEventDestinationsResponse =
      GetConfigurationSetEventDestinationsResponse
        .builder
        .ifSome(eventDestinations)(_.eventDestinations(_))
        .build

    def getConfigurationSetRequest(
      configurationSetName: Option[String] = None
    ): GetConfigurationSetRequest =
      GetConfigurationSetRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def getConfigurationSetResponse(
      configurationSetName: Option[String] = None,
      trackingOptions: Option[TrackingOptions] = None,
      deliveryOptions: Option[DeliveryOptions] = None,
      reputationOptions: Option[ReputationOptions] = None,
      sendingOptions: Option[SendingOptions] = None,
      tags: Option[List[Tag]] = None
    ): GetConfigurationSetResponse =
      GetConfigurationSetResponse
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(trackingOptions)(_.trackingOptions(_))
        .ifSome(deliveryOptions)(_.deliveryOptions(_))
        .ifSome(reputationOptions)(_.reputationOptions(_))
        .ifSome(sendingOptions)(_.sendingOptions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getDedicatedIpRequest(
      ip: Option[String] = None
    ): GetDedicatedIpRequest =
      GetDedicatedIpRequest
        .builder
        .ifSome(ip)(_.ip(_))
        .build

    def getDedicatedIpResponse(
      dedicatedIp: Option[DedicatedIp] = None
    ): GetDedicatedIpResponse =
      GetDedicatedIpResponse
        .builder
        .ifSome(dedicatedIp)(_.dedicatedIp(_))
        .build

    def getDedicatedIpsRequest(
      poolName: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): GetDedicatedIpsRequest =
      GetDedicatedIpsRequest
        .builder
        .ifSome(poolName)(_.poolName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def getDedicatedIpsResponse(
      dedicatedIps: Option[List[DedicatedIp]] = None,
      nextToken: Option[String] = None
    ): GetDedicatedIpsResponse =
      GetDedicatedIpsResponse
        .builder
        .ifSome(dedicatedIps)(_.dedicatedIps(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDeliverabilityDashboardOptionsRequest(

    ): GetDeliverabilityDashboardOptionsRequest =
      GetDeliverabilityDashboardOptionsRequest
        .builder

        .build

    def getDeliverabilityDashboardOptionsResponse(
      dashboardEnabled: Option[Boolean] = None,
      subscriptionExpiryDate: Option[Timestamp] = None,
      accountStatus: Option[String] = None,
      activeSubscribedDomains: Option[List[DomainDeliverabilityTrackingOption]] = None,
      pendingExpirationSubscribedDomains: Option[List[DomainDeliverabilityTrackingOption]] = None
    ): GetDeliverabilityDashboardOptionsResponse =
      GetDeliverabilityDashboardOptionsResponse
        .builder
        .ifSome(dashboardEnabled)(_.dashboardEnabled(_))
        .ifSome(subscriptionExpiryDate)(_.subscriptionExpiryDate(_))
        .ifSome(accountStatus)(_.accountStatus(_))
        .ifSome(activeSubscribedDomains)(_.activeSubscribedDomains(_))
        .ifSome(pendingExpirationSubscribedDomains)(_.pendingExpirationSubscribedDomains(_))
        .build

    def getDeliverabilityTestReportRequest(
      reportId: Option[String] = None
    ): GetDeliverabilityTestReportRequest =
      GetDeliverabilityTestReportRequest
        .builder
        .ifSome(reportId)(_.reportId(_))
        .build

    def getDeliverabilityTestReportResponse(
      deliverabilityTestReport: Option[DeliverabilityTestReport] = None,
      overallPlacement: Option[PlacementStatistics] = None,
      ispPlacements: Option[List[IspPlacement]] = None,
      message: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): GetDeliverabilityTestReportResponse =
      GetDeliverabilityTestReportResponse
        .builder
        .ifSome(deliverabilityTestReport)(_.deliverabilityTestReport(_))
        .ifSome(overallPlacement)(_.overallPlacement(_))
        .ifSome(ispPlacements)(_.ispPlacements(_))
        .ifSome(message)(_.message(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getDomainDeliverabilityCampaignRequest(
      campaignId: Option[String] = None
    ): GetDomainDeliverabilityCampaignRequest =
      GetDomainDeliverabilityCampaignRequest
        .builder
        .ifSome(campaignId)(_.campaignId(_))
        .build

    def getDomainDeliverabilityCampaignResponse(
      domainDeliverabilityCampaign: Option[DomainDeliverabilityCampaign] = None
    ): GetDomainDeliverabilityCampaignResponse =
      GetDomainDeliverabilityCampaignResponse
        .builder
        .ifSome(domainDeliverabilityCampaign)(_.domainDeliverabilityCampaign(_))
        .build

    def getDomainStatisticsReportRequest(
      domain: Option[String] = None,
      startDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None
    ): GetDomainStatisticsReportRequest =
      GetDomainStatisticsReportRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .build

    def getDomainStatisticsReportResponse(
      overallVolume: Option[OverallVolume] = None,
      dailyVolumes: Option[List[DailyVolume]] = None
    ): GetDomainStatisticsReportResponse =
      GetDomainStatisticsReportResponse
        .builder
        .ifSome(overallVolume)(_.overallVolume(_))
        .ifSome(dailyVolumes)(_.dailyVolumes(_))
        .build

    def getEmailIdentityRequest(
      emailIdentity: Option[String] = None
    ): GetEmailIdentityRequest =
      GetEmailIdentityRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .build

    def getEmailIdentityResponse(
      identityType: Option[String] = None,
      feedbackForwardingStatus: Option[Boolean] = None,
      verifiedForSendingStatus: Option[Boolean] = None,
      dkimAttributes: Option[DkimAttributes] = None,
      mailFromAttributes: Option[MailFromAttributes] = None,
      tags: Option[List[Tag]] = None
    ): GetEmailIdentityResponse =
      GetEmailIdentityResponse
        .builder
        .ifSome(identityType)(_.identityType(_))
        .ifSome(feedbackForwardingStatus)(_.feedbackForwardingStatus(_))
        .ifSome(verifiedForSendingStatus)(_.verifiedForSendingStatus(_))
        .ifSome(dkimAttributes)(_.dkimAttributes(_))
        .ifSome(mailFromAttributes)(_.mailFromAttributes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def identityInfo(
      identityType: Option[String] = None,
      identityName: Option[String] = None,
      sendingEnabled: Option[Boolean] = None
    ): IdentityInfo =
      IdentityInfo
        .builder
        .ifSome(identityType)(_.identityType(_))
        .ifSome(identityName)(_.identityName(_))
        .ifSome(sendingEnabled)(_.sendingEnabled(_))
        .build

    def inboxPlacementTrackingOption(
      global: Option[Boolean] = None,
      trackedIsps: Option[List[IspName]] = None
    ): InboxPlacementTrackingOption =
      InboxPlacementTrackingOption
        .builder
        .ifSome(global)(_.global(_))
        .ifSome(trackedIsps)(_.trackedIsps(_))
        .build

    def ispPlacement(
      ispName: Option[String] = None,
      placementStatistics: Option[PlacementStatistics] = None
    ): IspPlacement =
      IspPlacement
        .builder
        .ifSome(ispName)(_.ispName(_))
        .ifSome(placementStatistics)(_.placementStatistics(_))
        .build

    def kinesisFirehoseDestination(
      iamRoleArn: Option[String] = None,
      deliveryStreamArn: Option[String] = None
    ): KinesisFirehoseDestination =
      KinesisFirehoseDestination
        .builder
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(deliveryStreamArn)(_.deliveryStreamArn(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listConfigurationSetsRequest(
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListConfigurationSetsRequest =
      ListConfigurationSetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listConfigurationSetsResponse(
      configurationSets: Option[List[ConfigurationSetName]] = None,
      nextToken: Option[String] = None
    ): ListConfigurationSetsResponse =
      ListConfigurationSetsResponse
        .builder
        .ifSome(configurationSets)(_.configurationSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDedicatedIpPoolsRequest(
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListDedicatedIpPoolsRequest =
      ListDedicatedIpPoolsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listDedicatedIpPoolsResponse(
      dedicatedIpPools: Option[List[PoolName]] = None,
      nextToken: Option[String] = None
    ): ListDedicatedIpPoolsResponse =
      ListDedicatedIpPoolsResponse
        .builder
        .ifSome(dedicatedIpPools)(_.dedicatedIpPools(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeliverabilityTestReportsRequest(
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListDeliverabilityTestReportsRequest =
      ListDeliverabilityTestReportsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listDeliverabilityTestReportsResponse(
      deliverabilityTestReports: Option[List[DeliverabilityTestReport]] = None,
      nextToken: Option[String] = None
    ): ListDeliverabilityTestReportsResponse =
      ListDeliverabilityTestReportsResponse
        .builder
        .ifSome(deliverabilityTestReports)(_.deliverabilityTestReports(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDomainDeliverabilityCampaignsRequest(
      startDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None,
      subscribedDomain: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListDomainDeliverabilityCampaignsRequest =
      ListDomainDeliverabilityCampaignsRequest
        .builder
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(subscribedDomain)(_.subscribedDomain(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listDomainDeliverabilityCampaignsResponse(
      domainDeliverabilityCampaigns: Option[List[DomainDeliverabilityCampaign]] = None,
      nextToken: Option[String] = None
    ): ListDomainDeliverabilityCampaignsResponse =
      ListDomainDeliverabilityCampaignsResponse
        .builder
        .ifSome(domainDeliverabilityCampaigns)(_.domainDeliverabilityCampaigns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEmailIdentitiesRequest(
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListEmailIdentitiesRequest =
      ListEmailIdentitiesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listEmailIdentitiesResponse(
      emailIdentities: Option[List[IdentityInfo]] = None,
      nextToken: Option[String] = None
    ): ListEmailIdentitiesResponse =
      ListEmailIdentitiesResponse
        .builder
        .ifSome(emailIdentities)(_.emailIdentities(_))
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

    def mailFromAttributes(
      mailFromDomain: Option[String] = None,
      mailFromDomainStatus: Option[String] = None,
      behaviorOnMxFailure: Option[String] = None
    ): MailFromAttributes =
      MailFromAttributes
        .builder
        .ifSome(mailFromDomain)(_.mailFromDomain(_))
        .ifSome(mailFromDomainStatus)(_.mailFromDomainStatus(_))
        .ifSome(behaviorOnMxFailure)(_.behaviorOnMxFailure(_))
        .build

    def mailFromDomainNotVerifiedException(

    ): MailFromDomainNotVerifiedException =
      MailFromDomainNotVerifiedException
        .builder

        .build

    def message(
      subject: Option[Content] = None,
      body: Option[Body] = None
    ): Message =
      Message
        .builder
        .ifSome(subject)(_.subject(_))
        .ifSome(body)(_.body(_))
        .build

    def messageRejected(

    ): MessageRejected =
      MessageRejected
        .builder

        .build

    def messageTag(
      name: Option[String] = None,
      value: Option[String] = None
    ): MessageTag =
      MessageTag
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def notFoundException(

    ): NotFoundException =
      NotFoundException
        .builder

        .build

    def overallVolume(
      volumeStatistics: Option[VolumeStatistics] = None,
      readRatePercent: Option[Percentage] = None,
      domainIspPlacements: Option[List[DomainIspPlacement]] = None
    ): OverallVolume =
      OverallVolume
        .builder
        .ifSome(volumeStatistics)(_.volumeStatistics(_))
        .ifSome(readRatePercent)(_.readRatePercent(_))
        .ifSome(domainIspPlacements)(_.domainIspPlacements(_))
        .build

    def pinpointDestination(
      applicationArn: Option[String] = None
    ): PinpointDestination =
      PinpointDestination
        .builder
        .ifSome(applicationArn)(_.applicationArn(_))
        .build

    def placementStatistics(
      inboxPercentage: Option[Percentage] = None,
      spamPercentage: Option[Percentage] = None,
      missingPercentage: Option[Percentage] = None,
      spfPercentage: Option[Percentage] = None,
      dkimPercentage: Option[Percentage] = None
    ): PlacementStatistics =
      PlacementStatistics
        .builder
        .ifSome(inboxPercentage)(_.inboxPercentage(_))
        .ifSome(spamPercentage)(_.spamPercentage(_))
        .ifSome(missingPercentage)(_.missingPercentage(_))
        .ifSome(spfPercentage)(_.spfPercentage(_))
        .ifSome(dkimPercentage)(_.dkimPercentage(_))
        .build

    def putAccountDedicatedIpWarmupAttributesRequest(
      autoWarmupEnabled: Option[Boolean] = None
    ): PutAccountDedicatedIpWarmupAttributesRequest =
      PutAccountDedicatedIpWarmupAttributesRequest
        .builder
        .ifSome(autoWarmupEnabled)(_.autoWarmupEnabled(_))
        .build

    def putAccountDedicatedIpWarmupAttributesResponse(

    ): PutAccountDedicatedIpWarmupAttributesResponse =
      PutAccountDedicatedIpWarmupAttributesResponse
        .builder

        .build

    def putAccountSendingAttributesRequest(
      sendingEnabled: Option[Boolean] = None
    ): PutAccountSendingAttributesRequest =
      PutAccountSendingAttributesRequest
        .builder
        .ifSome(sendingEnabled)(_.sendingEnabled(_))
        .build

    def putAccountSendingAttributesResponse(

    ): PutAccountSendingAttributesResponse =
      PutAccountSendingAttributesResponse
        .builder

        .build

    def putConfigurationSetDeliveryOptionsRequest(
      configurationSetName: Option[String] = None,
      tlsPolicy: Option[String] = None,
      sendingPoolName: Option[String] = None
    ): PutConfigurationSetDeliveryOptionsRequest =
      PutConfigurationSetDeliveryOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(tlsPolicy)(_.tlsPolicy(_))
        .ifSome(sendingPoolName)(_.sendingPoolName(_))
        .build

    def putConfigurationSetDeliveryOptionsResponse(

    ): PutConfigurationSetDeliveryOptionsResponse =
      PutConfigurationSetDeliveryOptionsResponse
        .builder

        .build

    def putConfigurationSetReputationOptionsRequest(
      configurationSetName: Option[String] = None,
      reputationMetricsEnabled: Option[Boolean] = None
    ): PutConfigurationSetReputationOptionsRequest =
      PutConfigurationSetReputationOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(reputationMetricsEnabled)(_.reputationMetricsEnabled(_))
        .build

    def putConfigurationSetReputationOptionsResponse(

    ): PutConfigurationSetReputationOptionsResponse =
      PutConfigurationSetReputationOptionsResponse
        .builder

        .build

    def putConfigurationSetSendingOptionsRequest(
      configurationSetName: Option[String] = None,
      sendingEnabled: Option[Boolean] = None
    ): PutConfigurationSetSendingOptionsRequest =
      PutConfigurationSetSendingOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(sendingEnabled)(_.sendingEnabled(_))
        .build

    def putConfigurationSetSendingOptionsResponse(

    ): PutConfigurationSetSendingOptionsResponse =
      PutConfigurationSetSendingOptionsResponse
        .builder

        .build

    def putConfigurationSetTrackingOptionsRequest(
      configurationSetName: Option[String] = None,
      customRedirectDomain: Option[String] = None
    ): PutConfigurationSetTrackingOptionsRequest =
      PutConfigurationSetTrackingOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(customRedirectDomain)(_.customRedirectDomain(_))
        .build

    def putConfigurationSetTrackingOptionsResponse(

    ): PutConfigurationSetTrackingOptionsResponse =
      PutConfigurationSetTrackingOptionsResponse
        .builder

        .build

    def putDedicatedIpInPoolRequest(
      ip: Option[String] = None,
      destinationPoolName: Option[String] = None
    ): PutDedicatedIpInPoolRequest =
      PutDedicatedIpInPoolRequest
        .builder
        .ifSome(ip)(_.ip(_))
        .ifSome(destinationPoolName)(_.destinationPoolName(_))
        .build

    def putDedicatedIpInPoolResponse(

    ): PutDedicatedIpInPoolResponse =
      PutDedicatedIpInPoolResponse
        .builder

        .build

    def putDedicatedIpWarmupAttributesRequest(
      ip: Option[String] = None,
      warmupPercentage: Option[Int] = None
    ): PutDedicatedIpWarmupAttributesRequest =
      PutDedicatedIpWarmupAttributesRequest
        .builder
        .ifSome(ip)(_.ip(_))
        .ifSome(warmupPercentage)(_.warmupPercentage(_))
        .build

    def putDedicatedIpWarmupAttributesResponse(

    ): PutDedicatedIpWarmupAttributesResponse =
      PutDedicatedIpWarmupAttributesResponse
        .builder

        .build

    def putDeliverabilityDashboardOptionRequest(
      dashboardEnabled: Option[Boolean] = None,
      subscribedDomains: Option[List[DomainDeliverabilityTrackingOption]] = None
    ): PutDeliverabilityDashboardOptionRequest =
      PutDeliverabilityDashboardOptionRequest
        .builder
        .ifSome(dashboardEnabled)(_.dashboardEnabled(_))
        .ifSome(subscribedDomains)(_.subscribedDomains(_))
        .build

    def putDeliverabilityDashboardOptionResponse(

    ): PutDeliverabilityDashboardOptionResponse =
      PutDeliverabilityDashboardOptionResponse
        .builder

        .build

    def putEmailIdentityDkimAttributesRequest(
      emailIdentity: Option[String] = None,
      signingEnabled: Option[Boolean] = None
    ): PutEmailIdentityDkimAttributesRequest =
      PutEmailIdentityDkimAttributesRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(signingEnabled)(_.signingEnabled(_))
        .build

    def putEmailIdentityDkimAttributesResponse(

    ): PutEmailIdentityDkimAttributesResponse =
      PutEmailIdentityDkimAttributesResponse
        .builder

        .build

    def putEmailIdentityFeedbackAttributesRequest(
      emailIdentity: Option[String] = None,
      emailForwardingEnabled: Option[Boolean] = None
    ): PutEmailIdentityFeedbackAttributesRequest =
      PutEmailIdentityFeedbackAttributesRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(emailForwardingEnabled)(_.emailForwardingEnabled(_))
        .build

    def putEmailIdentityFeedbackAttributesResponse(

    ): PutEmailIdentityFeedbackAttributesResponse =
      PutEmailIdentityFeedbackAttributesResponse
        .builder

        .build

    def putEmailIdentityMailFromAttributesRequest(
      emailIdentity: Option[String] = None,
      mailFromDomain: Option[String] = None,
      behaviorOnMxFailure: Option[String] = None
    ): PutEmailIdentityMailFromAttributesRequest =
      PutEmailIdentityMailFromAttributesRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(mailFromDomain)(_.mailFromDomain(_))
        .ifSome(behaviorOnMxFailure)(_.behaviorOnMxFailure(_))
        .build

    def putEmailIdentityMailFromAttributesResponse(

    ): PutEmailIdentityMailFromAttributesResponse =
      PutEmailIdentityMailFromAttributesResponse
        .builder

        .build

    def rawMessage(
      data: Option[RawMessageData] = None
    ): RawMessage =
      RawMessage
        .builder
        .ifSome(data)(_.data(_))
        .build

    def reputationOptions(
      reputationMetricsEnabled: Option[Boolean] = None,
      lastFreshStart: Option[LastFreshStart] = None
    ): ReputationOptions =
      ReputationOptions
        .builder
        .ifSome(reputationMetricsEnabled)(_.reputationMetricsEnabled(_))
        .ifSome(lastFreshStart)(_.lastFreshStart(_))
        .build

    def sendEmailRequest(
      fromEmailAddress: Option[String] = None,
      destination: Option[Destination] = None,
      replyToAddresses: Option[List[EmailAddress]] = None,
      feedbackForwardingEmailAddress: Option[String] = None,
      content: Option[EmailContent] = None,
      emailTags: Option[List[MessageTag]] = None,
      configurationSetName: Option[String] = None
    ): SendEmailRequest =
      SendEmailRequest
        .builder
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(replyToAddresses)(_.replyToAddresses(_))
        .ifSome(feedbackForwardingEmailAddress)(_.feedbackForwardingEmailAddress(_))
        .ifSome(content)(_.content(_))
        .ifSome(emailTags)(_.emailTags(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def sendEmailResponse(
      messageId: Option[String] = None
    ): SendEmailResponse =
      SendEmailResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def sendQuota(
      max24HourSend: Option[Max24HourSend] = None,
      maxSendRate: Option[MaxSendRate] = None,
      sentLast24Hours: Option[SentLast24Hours] = None
    ): SendQuota =
      SendQuota
        .builder
        .ifSome(max24HourSend)(_.max24HourSend(_))
        .ifSome(maxSendRate)(_.maxSendRate(_))
        .ifSome(sentLast24Hours)(_.sentLast24Hours(_))
        .build

    def sendingOptions(
      sendingEnabled: Option[Boolean] = None
    ): SendingOptions =
      SendingOptions
        .builder
        .ifSome(sendingEnabled)(_.sendingEnabled(_))
        .build

    def sendingPausedException(

    ): SendingPausedException =
      SendingPausedException
        .builder

        .build

    def snsDestination(
      topicArn: Option[String] = None
    ): SnsDestination =
      SnsDestination
        .builder
        .ifSome(topicArn)(_.topicArn(_))
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

    def template(
      templateArn: Option[String] = None,
      templateData: Option[String] = None
    ): Template =
      Template
        .builder
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(templateData)(_.templateData(_))
        .build

    def tooManyRequestsException(

    ): TooManyRequestsException =
      TooManyRequestsException
        .builder

        .build

    def trackingOptions(
      customRedirectDomain: Option[String] = None
    ): TrackingOptions =
      TrackingOptions
        .builder
        .ifSome(customRedirectDomain)(_.customRedirectDomain(_))
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

    def updateConfigurationSetEventDestinationRequest(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None,
      eventDestination: Option[EventDestinationDefinition] = None
    ): UpdateConfigurationSetEventDestinationRequest =
      UpdateConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .ifSome(eventDestination)(_.eventDestination(_))
        .build

    def updateConfigurationSetEventDestinationResponse(

    ): UpdateConfigurationSetEventDestinationResponse =
      UpdateConfigurationSetEventDestinationResponse
        .builder

        .build

    def volumeStatistics(
      inboxRawCount: Option[Volume] = None,
      spamRawCount: Option[Volume] = None,
      projectedInbox: Option[Volume] = None,
      projectedSpam: Option[Volume] = None
    ): VolumeStatistics =
      VolumeStatistics
        .builder
        .ifSome(inboxRawCount)(_.inboxRawCount(_))
        .ifSome(spamRawCount)(_.spamRawCount(_))
        .ifSome(projectedInbox)(_.projectedInbox(_))
        .ifSome(projectedSpam)(_.projectedSpam(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
