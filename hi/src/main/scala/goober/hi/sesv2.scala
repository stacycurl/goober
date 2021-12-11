package goober.hi

import goober.free.sesv2.SesV2IO
import software.amazon.awssdk.services.sesv2.model._


object sesv2 {
  import goober.free.{sesv2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountDetails(
      mailType: Option[String] = None,
      websiteURL: Option[String] = None,
      contactLanguage: Option[String] = None,
      useCaseDescription: Option[String] = None,
      additionalContactEmailAddresses: Option[List[AdditionalContactEmailAddress]] = None,
      reviewDetails: Option[ReviewDetails] = None
    ): AccountDetails =
      AccountDetails
        .builder
        .ifSome(mailType)(_.mailType(_))
        .ifSome(websiteURL)(_.websiteURL(_))
        .ifSome(contactLanguage)(_.contactLanguage(_))
        .ifSome(useCaseDescription)(_.useCaseDescription(_))
        .ifSome(additionalContactEmailAddresses)(_.additionalContactEmailAddresses(_))
        .ifSome(reviewDetails)(_.reviewDetails(_))
        .build

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

    def bulkEmailContent(
      template: Option[Template] = None
    ): BulkEmailContent =
      BulkEmailContent
        .builder
        .ifSome(template)(_.template(_))
        .build

    def bulkEmailEntry(
      destination: Option[Destination] = None,
      replacementTags: Option[List[MessageTag]] = None,
      replacementEmailContent: Option[ReplacementEmailContent] = None
    ): BulkEmailEntry =
      BulkEmailEntry
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(replacementTags)(_.replacementTags(_))
        .ifSome(replacementEmailContent)(_.replacementEmailContent(_))
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

    def conflictException(

    ): ConflictException =
      ConflictException
        .builder

        .build

    def contact(
      emailAddress: Option[String] = None,
      topicPreferences: Option[List[TopicPreference]] = None,
      topicDefaultPreferences: Option[List[TopicPreference]] = None,
      unsubscribeAll: Option[Boolean] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None
    ): Contact =
      Contact
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(topicPreferences)(_.topicPreferences(_))
        .ifSome(topicDefaultPreferences)(_.topicDefaultPreferences(_))
        .ifSome(unsubscribeAll)(_.unsubscribeAll(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .build

    def contactList(
      contactListName: Option[String] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None
    ): ContactList =
      ContactList
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .build

    def contactListDestination(
      contactListName: Option[String] = None,
      contactListImportAction: Option[String] = None
    ): ContactListDestination =
      ContactListDestination
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(contactListImportAction)(_.contactListImportAction(_))
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
      tags: Option[List[Tag]] = None,
      suppressionOptions: Option[SuppressionOptions] = None
    ): CreateConfigurationSetRequest =
      CreateConfigurationSetRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(trackingOptions)(_.trackingOptions(_))
        .ifSome(deliveryOptions)(_.deliveryOptions(_))
        .ifSome(reputationOptions)(_.reputationOptions(_))
        .ifSome(sendingOptions)(_.sendingOptions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(suppressionOptions)(_.suppressionOptions(_))
        .build

    def createConfigurationSetResponse(

    ): CreateConfigurationSetResponse =
      CreateConfigurationSetResponse
        .builder

        .build

    def createContactListRequest(
      contactListName: Option[String] = None,
      topics: Option[List[Topic]] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateContactListRequest =
      CreateContactListRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(topics)(_.topics(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createContactListResponse(

    ): CreateContactListResponse =
      CreateContactListResponse
        .builder

        .build

    def createContactRequest(
      contactListName: Option[String] = None,
      emailAddress: Option[String] = None,
      topicPreferences: Option[List[TopicPreference]] = None,
      unsubscribeAll: Option[Boolean] = None,
      attributesData: Option[String] = None
    ): CreateContactRequest =
      CreateContactRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(topicPreferences)(_.topicPreferences(_))
        .ifSome(unsubscribeAll)(_.unsubscribeAll(_))
        .ifSome(attributesData)(_.attributesData(_))
        .build

    def createContactResponse(

    ): CreateContactResponse =
      CreateContactResponse
        .builder

        .build

    def createCustomVerificationEmailTemplateRequest(
      templateName: Option[String] = None,
      fromEmailAddress: Option[String] = None,
      templateSubject: Option[String] = None,
      templateContent: Option[String] = None,
      successRedirectionURL: Option[String] = None,
      failureRedirectionURL: Option[String] = None
    ): CreateCustomVerificationEmailTemplateRequest =
      CreateCustomVerificationEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(templateSubject)(_.templateSubject(_))
        .ifSome(templateContent)(_.templateContent(_))
        .ifSome(successRedirectionURL)(_.successRedirectionURL(_))
        .ifSome(failureRedirectionURL)(_.failureRedirectionURL(_))
        .build

    def createCustomVerificationEmailTemplateResponse(

    ): CreateCustomVerificationEmailTemplateResponse =
      CreateCustomVerificationEmailTemplateResponse
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

    def createEmailIdentityPolicyRequest(
      emailIdentity: Option[String] = None,
      policyName: Option[String] = None,
      policy: Option[String] = None
    ): CreateEmailIdentityPolicyRequest =
      CreateEmailIdentityPolicyRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def createEmailIdentityPolicyResponse(

    ): CreateEmailIdentityPolicyResponse =
      CreateEmailIdentityPolicyResponse
        .builder

        .build

    def createEmailIdentityRequest(
      emailIdentity: Option[String] = None,
      tags: Option[List[Tag]] = None,
      dkimSigningAttributes: Option[DkimSigningAttributes] = None,
      configurationSetName: Option[String] = None
    ): CreateEmailIdentityRequest =
      CreateEmailIdentityRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(dkimSigningAttributes)(_.dkimSigningAttributes(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
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

    def createEmailTemplateRequest(
      templateName: Option[String] = None,
      templateContent: Option[EmailTemplateContent] = None
    ): CreateEmailTemplateRequest =
      CreateEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateContent)(_.templateContent(_))
        .build

    def createEmailTemplateResponse(

    ): CreateEmailTemplateResponse =
      CreateEmailTemplateResponse
        .builder

        .build

    def createImportJobRequest(
      importDestination: Option[ImportDestination] = None,
      importDataSource: Option[ImportDataSource] = None
    ): CreateImportJobRequest =
      CreateImportJobRequest
        .builder
        .ifSome(importDestination)(_.importDestination(_))
        .ifSome(importDataSource)(_.importDataSource(_))
        .build

    def createImportJobResponse(
      jobId: Option[String] = None
    ): CreateImportJobResponse =
      CreateImportJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def customVerificationEmailTemplateMetadata(
      templateName: Option[String] = None,
      fromEmailAddress: Option[String] = None,
      templateSubject: Option[String] = None,
      successRedirectionURL: Option[String] = None,
      failureRedirectionURL: Option[String] = None
    ): CustomVerificationEmailTemplateMetadata =
      CustomVerificationEmailTemplateMetadata
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(templateSubject)(_.templateSubject(_))
        .ifSome(successRedirectionURL)(_.successRedirectionURL(_))
        .ifSome(failureRedirectionURL)(_.failureRedirectionURL(_))
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

    def deleteContactListRequest(
      contactListName: Option[String] = None
    ): DeleteContactListRequest =
      DeleteContactListRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .build

    def deleteContactListResponse(

    ): DeleteContactListResponse =
      DeleteContactListResponse
        .builder

        .build

    def deleteContactRequest(
      contactListName: Option[String] = None,
      emailAddress: Option[String] = None
    ): DeleteContactRequest =
      DeleteContactRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def deleteContactResponse(

    ): DeleteContactResponse =
      DeleteContactResponse
        .builder

        .build

    def deleteCustomVerificationEmailTemplateRequest(
      templateName: Option[String] = None
    ): DeleteCustomVerificationEmailTemplateRequest =
      DeleteCustomVerificationEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteCustomVerificationEmailTemplateResponse(

    ): DeleteCustomVerificationEmailTemplateResponse =
      DeleteCustomVerificationEmailTemplateResponse
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

    def deleteEmailIdentityPolicyRequest(
      emailIdentity: Option[String] = None,
      policyName: Option[String] = None
    ): DeleteEmailIdentityPolicyRequest =
      DeleteEmailIdentityPolicyRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteEmailIdentityPolicyResponse(

    ): DeleteEmailIdentityPolicyResponse =
      DeleteEmailIdentityPolicyResponse
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

    def deleteEmailTemplateRequest(
      templateName: Option[String] = None
    ): DeleteEmailTemplateRequest =
      DeleteEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteEmailTemplateResponse(

    ): DeleteEmailTemplateResponse =
      DeleteEmailTemplateResponse
        .builder

        .build

    def deleteSuppressedDestinationRequest(
      emailAddress: Option[String] = None
    ): DeleteSuppressedDestinationRequest =
      DeleteSuppressedDestinationRequest
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def deleteSuppressedDestinationResponse(

    ): DeleteSuppressedDestinationResponse =
      DeleteSuppressedDestinationResponse
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
      tokens: Option[List[DnsToken]] = None,
      signingAttributesOrigin: Option[String] = None
    ): DkimAttributes =
      DkimAttributes
        .builder
        .ifSome(signingEnabled)(_.signingEnabled(_))
        .ifSome(status)(_.status(_))
        .ifSome(tokens)(_.tokens(_))
        .ifSome(signingAttributesOrigin)(_.signingAttributesOrigin(_))
        .build

    def dkimSigningAttributes(
      domainSigningSelector: Option[String] = None,
      domainSigningPrivateKey: Option[String] = None
    ): DkimSigningAttributes =
      DkimSigningAttributes
        .builder
        .ifSome(domainSigningSelector)(_.domainSigningSelector(_))
        .ifSome(domainSigningPrivateKey)(_.domainSigningPrivateKey(_))
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

    def emailTemplateContent(
      subject: Option[String] = None,
      text: Option[String] = None,
      html: Option[String] = None
    ): EmailTemplateContent =
      EmailTemplateContent
        .builder
        .ifSome(subject)(_.subject(_))
        .ifSome(text)(_.text(_))
        .ifSome(html)(_.html(_))
        .build

    def emailTemplateMetadata(
      templateName: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None
    ): EmailTemplateMetadata =
      EmailTemplateMetadata
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
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

    def failureInfo(
      failedRecordsS3Url: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailureInfo =
      FailureInfo
        .builder
        .ifSome(failedRecordsS3Url)(_.failedRecordsS3Url(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def getAccountRequest(

    ): GetAccountRequest =
      GetAccountRequest
        .builder

        .build

    def getAccountResponse(
      dedicatedIpAutoWarmupEnabled: Option[Boolean] = None,
      enforcementStatus: Option[String] = None,
      productionAccessEnabled: Option[Boolean] = None,
      sendQuota: Option[SendQuota] = None,
      sendingEnabled: Option[Boolean] = None,
      suppressionAttributes: Option[SuppressionAttributes] = None,
      details: Option[AccountDetails] = None
    ): GetAccountResponse =
      GetAccountResponse
        .builder
        .ifSome(dedicatedIpAutoWarmupEnabled)(_.dedicatedIpAutoWarmupEnabled(_))
        .ifSome(enforcementStatus)(_.enforcementStatus(_))
        .ifSome(productionAccessEnabled)(_.productionAccessEnabled(_))
        .ifSome(sendQuota)(_.sendQuota(_))
        .ifSome(sendingEnabled)(_.sendingEnabled(_))
        .ifSome(suppressionAttributes)(_.suppressionAttributes(_))
        .ifSome(details)(_.details(_))
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
      tags: Option[List[Tag]] = None,
      suppressionOptions: Option[SuppressionOptions] = None
    ): GetConfigurationSetResponse =
      GetConfigurationSetResponse
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(trackingOptions)(_.trackingOptions(_))
        .ifSome(deliveryOptions)(_.deliveryOptions(_))
        .ifSome(reputationOptions)(_.reputationOptions(_))
        .ifSome(sendingOptions)(_.sendingOptions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(suppressionOptions)(_.suppressionOptions(_))
        .build

    def getContactListRequest(
      contactListName: Option[String] = None
    ): GetContactListRequest =
      GetContactListRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .build

    def getContactListResponse(
      contactListName: Option[String] = None,
      topics: Option[List[Topic]] = None,
      description: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None,
      tags: Option[List[Tag]] = None
    ): GetContactListResponse =
      GetContactListResponse
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(topics)(_.topics(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getContactRequest(
      contactListName: Option[String] = None,
      emailAddress: Option[String] = None
    ): GetContactRequest =
      GetContactRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def getContactResponse(
      contactListName: Option[String] = None,
      emailAddress: Option[String] = None,
      topicPreferences: Option[List[TopicPreference]] = None,
      topicDefaultPreferences: Option[List[TopicPreference]] = None,
      unsubscribeAll: Option[Boolean] = None,
      attributesData: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None
    ): GetContactResponse =
      GetContactResponse
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(topicPreferences)(_.topicPreferences(_))
        .ifSome(topicDefaultPreferences)(_.topicDefaultPreferences(_))
        .ifSome(unsubscribeAll)(_.unsubscribeAll(_))
        .ifSome(attributesData)(_.attributesData(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .build

    def getCustomVerificationEmailTemplateRequest(
      templateName: Option[String] = None
    ): GetCustomVerificationEmailTemplateRequest =
      GetCustomVerificationEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def getCustomVerificationEmailTemplateResponse(
      templateName: Option[String] = None,
      fromEmailAddress: Option[String] = None,
      templateSubject: Option[String] = None,
      templateContent: Option[String] = None,
      successRedirectionURL: Option[String] = None,
      failureRedirectionURL: Option[String] = None
    ): GetCustomVerificationEmailTemplateResponse =
      GetCustomVerificationEmailTemplateResponse
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(templateSubject)(_.templateSubject(_))
        .ifSome(templateContent)(_.templateContent(_))
        .ifSome(successRedirectionURL)(_.successRedirectionURL(_))
        .ifSome(failureRedirectionURL)(_.failureRedirectionURL(_))
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

    def getEmailIdentityPoliciesRequest(
      emailIdentity: Option[String] = None
    ): GetEmailIdentityPoliciesRequest =
      GetEmailIdentityPoliciesRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .build

    def getEmailIdentityPoliciesResponse(
      policies: Option[PolicyMap] = None
    ): GetEmailIdentityPoliciesResponse =
      GetEmailIdentityPoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
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
      policies: Option[PolicyMap] = None,
      tags: Option[List[Tag]] = None,
      configurationSetName: Option[String] = None
    ): GetEmailIdentityResponse =
      GetEmailIdentityResponse
        .builder
        .ifSome(identityType)(_.identityType(_))
        .ifSome(feedbackForwardingStatus)(_.feedbackForwardingStatus(_))
        .ifSome(verifiedForSendingStatus)(_.verifiedForSendingStatus(_))
        .ifSome(dkimAttributes)(_.dkimAttributes(_))
        .ifSome(mailFromAttributes)(_.mailFromAttributes(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def getEmailTemplateRequest(
      templateName: Option[String] = None
    ): GetEmailTemplateRequest =
      GetEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def getEmailTemplateResponse(
      templateName: Option[String] = None,
      templateContent: Option[EmailTemplateContent] = None
    ): GetEmailTemplateResponse =
      GetEmailTemplateResponse
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateContent)(_.templateContent(_))
        .build

    def getImportJobRequest(
      jobId: Option[String] = None
    ): GetImportJobRequest =
      GetImportJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def getImportJobResponse(
      jobId: Option[String] = None,
      importDestination: Option[ImportDestination] = None,
      importDataSource: Option[ImportDataSource] = None,
      failureInfo: Option[FailureInfo] = None,
      jobStatus: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      completedTimestamp: Option[Timestamp] = None,
      processedRecordsCount: Option[Int] = None,
      failedRecordsCount: Option[Int] = None
    ): GetImportJobResponse =
      GetImportJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(importDestination)(_.importDestination(_))
        .ifSome(importDataSource)(_.importDataSource(_))
        .ifSome(failureInfo)(_.failureInfo(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(completedTimestamp)(_.completedTimestamp(_))
        .ifSome(processedRecordsCount)(_.processedRecordsCount(_))
        .ifSome(failedRecordsCount)(_.failedRecordsCount(_))
        .build

    def getSuppressedDestinationRequest(
      emailAddress: Option[String] = None
    ): GetSuppressedDestinationRequest =
      GetSuppressedDestinationRequest
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def getSuppressedDestinationResponse(
      suppressedDestination: Option[SuppressedDestination] = None
    ): GetSuppressedDestinationResponse =
      GetSuppressedDestinationResponse
        .builder
        .ifSome(suppressedDestination)(_.suppressedDestination(_))
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

    def importDataSource(
      s3Url: Option[String] = None,
      dataFormat: Option[String] = None
    ): ImportDataSource =
      ImportDataSource
        .builder
        .ifSome(s3Url)(_.s3Url(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .build

    def importDestination(
      suppressionListDestination: Option[SuppressionListDestination] = None,
      contactListDestination: Option[ContactListDestination] = None
    ): ImportDestination =
      ImportDestination
        .builder
        .ifSome(suppressionListDestination)(_.suppressionListDestination(_))
        .ifSome(contactListDestination)(_.contactListDestination(_))
        .build

    def importJobSummary(
      jobId: Option[String] = None,
      importDestination: Option[ImportDestination] = None,
      jobStatus: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None
    ): ImportJobSummary =
      ImportJobSummary
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(importDestination)(_.importDestination(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
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

    def invalidNextTokenException(

    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder

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

    def listContactListsRequest(
      pageSize: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListContactListsRequest =
      ListContactListsRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContactListsResponse(
      contactLists: Option[List[ContactList]] = None,
      nextToken: Option[String] = None
    ): ListContactListsResponse =
      ListContactListsResponse
        .builder
        .ifSome(contactLists)(_.contactLists(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContactsFilter(
      filteredStatus: Option[String] = None,
      topicFilter: Option[TopicFilter] = None
    ): ListContactsFilter =
      ListContactsFilter
        .builder
        .ifSome(filteredStatus)(_.filteredStatus(_))
        .ifSome(topicFilter)(_.topicFilter(_))
        .build

    def listContactsRequest(
      contactListName: Option[String] = None,
      filter: Option[ListContactsFilter] = None,
      pageSize: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListContactsRequest =
      ListContactsRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContactsResponse(
      contacts: Option[List[Contact]] = None,
      nextToken: Option[String] = None
    ): ListContactsResponse =
      ListContactsResponse
        .builder
        .ifSome(contacts)(_.contacts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomVerificationEmailTemplatesRequest(
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListCustomVerificationEmailTemplatesRequest =
      ListCustomVerificationEmailTemplatesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listCustomVerificationEmailTemplatesResponse(
      customVerificationEmailTemplates: Option[List[CustomVerificationEmailTemplateMetadata]] = None,
      nextToken: Option[String] = None
    ): ListCustomVerificationEmailTemplatesResponse =
      ListCustomVerificationEmailTemplatesResponse
        .builder
        .ifSome(customVerificationEmailTemplates)(_.customVerificationEmailTemplates(_))
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

    def listEmailTemplatesRequest(
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListEmailTemplatesRequest =
      ListEmailTemplatesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listEmailTemplatesResponse(
      templatesMetadata: Option[List[EmailTemplateMetadata]] = None,
      nextToken: Option[String] = None
    ): ListEmailTemplatesResponse =
      ListEmailTemplatesResponse
        .builder
        .ifSome(templatesMetadata)(_.templatesMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImportJobsRequest(
      importDestinationType: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListImportJobsRequest =
      ListImportJobsRequest
        .builder
        .ifSome(importDestinationType)(_.importDestinationType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listImportJobsResponse(
      importJobs: Option[List[ImportJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListImportJobsResponse =
      ListImportJobsResponse
        .builder
        .ifSome(importJobs)(_.importJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listManagementOptions(
      contactListName: Option[String] = None,
      topicName: Option[String] = None
    ): ListManagementOptions =
      ListManagementOptions
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(topicName)(_.topicName(_))
        .build

    def listSuppressedDestinationsRequest(
      reasons: Option[List[SuppressionListReason]] = None,
      startDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None,
      nextToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListSuppressedDestinationsRequest =
      ListSuppressedDestinationsRequest
        .builder
        .ifSome(reasons)(_.reasons(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listSuppressedDestinationsResponse(
      suppressedDestinationSummaries: Option[List[SuppressedDestinationSummary]] = None,
      nextToken: Option[String] = None
    ): ListSuppressedDestinationsResponse =
      ListSuppressedDestinationsResponse
        .builder
        .ifSome(suppressedDestinationSummaries)(_.suppressedDestinationSummaries(_))
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

    def putAccountDetailsRequest(
      mailType: Option[String] = None,
      websiteURL: Option[String] = None,
      contactLanguage: Option[String] = None,
      useCaseDescription: Option[String] = None,
      additionalContactEmailAddresses: Option[List[AdditionalContactEmailAddress]] = None,
      productionAccessEnabled: Option[Boolean] = None
    ): PutAccountDetailsRequest =
      PutAccountDetailsRequest
        .builder
        .ifSome(mailType)(_.mailType(_))
        .ifSome(websiteURL)(_.websiteURL(_))
        .ifSome(contactLanguage)(_.contactLanguage(_))
        .ifSome(useCaseDescription)(_.useCaseDescription(_))
        .ifSome(additionalContactEmailAddresses)(_.additionalContactEmailAddresses(_))
        .ifSome(productionAccessEnabled)(_.productionAccessEnabled(_))
        .build

    def putAccountDetailsResponse(

    ): PutAccountDetailsResponse =
      PutAccountDetailsResponse
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

    def putAccountSuppressionAttributesRequest(
      suppressedReasons: Option[List[SuppressionListReason]] = None
    ): PutAccountSuppressionAttributesRequest =
      PutAccountSuppressionAttributesRequest
        .builder
        .ifSome(suppressedReasons)(_.suppressedReasons(_))
        .build

    def putAccountSuppressionAttributesResponse(

    ): PutAccountSuppressionAttributesResponse =
      PutAccountSuppressionAttributesResponse
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

    def putConfigurationSetSuppressionOptionsRequest(
      configurationSetName: Option[String] = None,
      suppressedReasons: Option[List[SuppressionListReason]] = None
    ): PutConfigurationSetSuppressionOptionsRequest =
      PutConfigurationSetSuppressionOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(suppressedReasons)(_.suppressedReasons(_))
        .build

    def putConfigurationSetSuppressionOptionsResponse(

    ): PutConfigurationSetSuppressionOptionsResponse =
      PutConfigurationSetSuppressionOptionsResponse
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

    def putEmailIdentityConfigurationSetAttributesRequest(
      emailIdentity: Option[String] = None,
      configurationSetName: Option[String] = None
    ): PutEmailIdentityConfigurationSetAttributesRequest =
      PutEmailIdentityConfigurationSetAttributesRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def putEmailIdentityConfigurationSetAttributesResponse(

    ): PutEmailIdentityConfigurationSetAttributesResponse =
      PutEmailIdentityConfigurationSetAttributesResponse
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

    def putEmailIdentityDkimSigningAttributesRequest(
      emailIdentity: Option[String] = None,
      signingAttributesOrigin: Option[String] = None,
      signingAttributes: Option[DkimSigningAttributes] = None
    ): PutEmailIdentityDkimSigningAttributesRequest =
      PutEmailIdentityDkimSigningAttributesRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(signingAttributesOrigin)(_.signingAttributesOrigin(_))
        .ifSome(signingAttributes)(_.signingAttributes(_))
        .build

    def putEmailIdentityDkimSigningAttributesResponse(
      dkimStatus: Option[String] = None,
      dkimTokens: Option[List[DnsToken]] = None
    ): PutEmailIdentityDkimSigningAttributesResponse =
      PutEmailIdentityDkimSigningAttributesResponse
        .builder
        .ifSome(dkimStatus)(_.dkimStatus(_))
        .ifSome(dkimTokens)(_.dkimTokens(_))
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

    def putSuppressedDestinationRequest(
      emailAddress: Option[String] = None,
      reason: Option[String] = None
    ): PutSuppressedDestinationRequest =
      PutSuppressedDestinationRequest
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(reason)(_.reason(_))
        .build

    def putSuppressedDestinationResponse(

    ): PutSuppressedDestinationResponse =
      PutSuppressedDestinationResponse
        .builder

        .build

    def rawMessage(
      data: Option[RawMessageData] = None
    ): RawMessage =
      RawMessage
        .builder
        .ifSome(data)(_.data(_))
        .build

    def replacementEmailContent(
      replacementTemplate: Option[ReplacementTemplate] = None
    ): ReplacementEmailContent =
      ReplacementEmailContent
        .builder
        .ifSome(replacementTemplate)(_.replacementTemplate(_))
        .build

    def replacementTemplate(
      replacementTemplateData: Option[String] = None
    ): ReplacementTemplate =
      ReplacementTemplate
        .builder
        .ifSome(replacementTemplateData)(_.replacementTemplateData(_))
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

    def reviewDetails(
      status: Option[String] = None,
      caseId: Option[String] = None
    ): ReviewDetails =
      ReviewDetails
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(caseId)(_.caseId(_))
        .build

    def sendBulkEmailRequest(
      fromEmailAddress: Option[String] = None,
      fromEmailAddressIdentityArn: Option[String] = None,
      replyToAddresses: Option[List[EmailAddress]] = None,
      feedbackForwardingEmailAddress: Option[String] = None,
      feedbackForwardingEmailAddressIdentityArn: Option[String] = None,
      defaultEmailTags: Option[List[MessageTag]] = None,
      defaultContent: Option[BulkEmailContent] = None,
      bulkEmailEntries: Option[List[BulkEmailEntry]] = None,
      configurationSetName: Option[String] = None
    ): SendBulkEmailRequest =
      SendBulkEmailRequest
        .builder
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(fromEmailAddressIdentityArn)(_.fromEmailAddressIdentityArn(_))
        .ifSome(replyToAddresses)(_.replyToAddresses(_))
        .ifSome(feedbackForwardingEmailAddress)(_.feedbackForwardingEmailAddress(_))
        .ifSome(feedbackForwardingEmailAddressIdentityArn)(_.feedbackForwardingEmailAddressIdentityArn(_))
        .ifSome(defaultEmailTags)(_.defaultEmailTags(_))
        .ifSome(defaultContent)(_.defaultContent(_))
        .ifSome(bulkEmailEntries)(_.bulkEmailEntries(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def sendBulkEmailResponse(
      bulkEmailEntryResults: Option[List[BulkEmailEntryResult]] = None
    ): SendBulkEmailResponse =
      SendBulkEmailResponse
        .builder
        .ifSome(bulkEmailEntryResults)(_.bulkEmailEntryResults(_))
        .build

    def sendCustomVerificationEmailRequest(
      emailAddress: Option[String] = None,
      templateName: Option[String] = None,
      configurationSetName: Option[String] = None
    ): SendCustomVerificationEmailRequest =
      SendCustomVerificationEmailRequest
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def sendCustomVerificationEmailResponse(
      messageId: Option[String] = None
    ): SendCustomVerificationEmailResponse =
      SendCustomVerificationEmailResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def sendEmailRequest(
      fromEmailAddress: Option[String] = None,
      fromEmailAddressIdentityArn: Option[String] = None,
      destination: Option[Destination] = None,
      replyToAddresses: Option[List[EmailAddress]] = None,
      feedbackForwardingEmailAddress: Option[String] = None,
      feedbackForwardingEmailAddressIdentityArn: Option[String] = None,
      content: Option[EmailContent] = None,
      emailTags: Option[List[MessageTag]] = None,
      configurationSetName: Option[String] = None,
      listManagementOptions: Option[ListManagementOptions] = None
    ): SendEmailRequest =
      SendEmailRequest
        .builder
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(fromEmailAddressIdentityArn)(_.fromEmailAddressIdentityArn(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(replyToAddresses)(_.replyToAddresses(_))
        .ifSome(feedbackForwardingEmailAddress)(_.feedbackForwardingEmailAddress(_))
        .ifSome(feedbackForwardingEmailAddressIdentityArn)(_.feedbackForwardingEmailAddressIdentityArn(_))
        .ifSome(content)(_.content(_))
        .ifSome(emailTags)(_.emailTags(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(listManagementOptions)(_.listManagementOptions(_))
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

    def suppressedDestination(
      emailAddress: Option[String] = None,
      reason: Option[String] = None,
      lastUpdateTime: Option[Timestamp] = None,
      attributes: Option[SuppressedDestinationAttributes] = None
    ): SuppressedDestination =
      SuppressedDestination
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def suppressedDestinationAttributes(
      messageId: Option[String] = None,
      feedbackId: Option[String] = None
    ): SuppressedDestinationAttributes =
      SuppressedDestinationAttributes
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(feedbackId)(_.feedbackId(_))
        .build

    def suppressedDestinationSummary(
      emailAddress: Option[String] = None,
      reason: Option[String] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): SuppressedDestinationSummary =
      SuppressedDestinationSummary
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def suppressionAttributes(
      suppressedReasons: Option[List[SuppressionListReason]] = None
    ): SuppressionAttributes =
      SuppressionAttributes
        .builder
        .ifSome(suppressedReasons)(_.suppressedReasons(_))
        .build

    def suppressionListDestination(
      suppressionListImportAction: Option[String] = None
    ): SuppressionListDestination =
      SuppressionListDestination
        .builder
        .ifSome(suppressionListImportAction)(_.suppressionListImportAction(_))
        .build

    def suppressionOptions(
      suppressedReasons: Option[List[SuppressionListReason]] = None
    ): SuppressionOptions =
      SuppressionOptions
        .builder
        .ifSome(suppressedReasons)(_.suppressedReasons(_))
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
      templateName: Option[String] = None,
      templateArn: Option[String] = None,
      templateData: Option[String] = None
    ): Template =
      Template
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(templateData)(_.templateData(_))
        .build

    def testRenderEmailTemplateRequest(
      templateName: Option[String] = None,
      templateData: Option[String] = None
    ): TestRenderEmailTemplateRequest =
      TestRenderEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateData)(_.templateData(_))
        .build

    def testRenderEmailTemplateResponse(
      renderedTemplate: Option[String] = None
    ): TestRenderEmailTemplateResponse =
      TestRenderEmailTemplateResponse
        .builder
        .ifSome(renderedTemplate)(_.renderedTemplate(_))
        .build

    def tooManyRequestsException(

    ): TooManyRequestsException =
      TooManyRequestsException
        .builder

        .build

    def topic(
      topicName: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None,
      defaultSubscriptionStatus: Option[String] = None
    ): Topic =
      Topic
        .builder
        .ifSome(topicName)(_.topicName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultSubscriptionStatus)(_.defaultSubscriptionStatus(_))
        .build

    def topicFilter(
      topicName: Option[String] = None,
      useDefaultIfPreferenceUnavailable: Option[Boolean] = None
    ): TopicFilter =
      TopicFilter
        .builder
        .ifSome(topicName)(_.topicName(_))
        .ifSome(useDefaultIfPreferenceUnavailable)(_.useDefaultIfPreferenceUnavailable(_))
        .build

    def topicPreference(
      topicName: Option[String] = None,
      subscriptionStatus: Option[String] = None
    ): TopicPreference =
      TopicPreference
        .builder
        .ifSome(topicName)(_.topicName(_))
        .ifSome(subscriptionStatus)(_.subscriptionStatus(_))
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

    def updateContactListRequest(
      contactListName: Option[String] = None,
      topics: Option[List[Topic]] = None,
      description: Option[String] = None
    ): UpdateContactListRequest =
      UpdateContactListRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(topics)(_.topics(_))
        .ifSome(description)(_.description(_))
        .build

    def updateContactListResponse(

    ): UpdateContactListResponse =
      UpdateContactListResponse
        .builder

        .build

    def updateContactRequest(
      contactListName: Option[String] = None,
      emailAddress: Option[String] = None,
      topicPreferences: Option[List[TopicPreference]] = None,
      unsubscribeAll: Option[Boolean] = None,
      attributesData: Option[String] = None
    ): UpdateContactRequest =
      UpdateContactRequest
        .builder
        .ifSome(contactListName)(_.contactListName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(topicPreferences)(_.topicPreferences(_))
        .ifSome(unsubscribeAll)(_.unsubscribeAll(_))
        .ifSome(attributesData)(_.attributesData(_))
        .build

    def updateContactResponse(

    ): UpdateContactResponse =
      UpdateContactResponse
        .builder

        .build

    def updateCustomVerificationEmailTemplateRequest(
      templateName: Option[String] = None,
      fromEmailAddress: Option[String] = None,
      templateSubject: Option[String] = None,
      templateContent: Option[String] = None,
      successRedirectionURL: Option[String] = None,
      failureRedirectionURL: Option[String] = None
    ): UpdateCustomVerificationEmailTemplateRequest =
      UpdateCustomVerificationEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(templateSubject)(_.templateSubject(_))
        .ifSome(templateContent)(_.templateContent(_))
        .ifSome(successRedirectionURL)(_.successRedirectionURL(_))
        .ifSome(failureRedirectionURL)(_.failureRedirectionURL(_))
        .build

    def updateCustomVerificationEmailTemplateResponse(

    ): UpdateCustomVerificationEmailTemplateResponse =
      UpdateCustomVerificationEmailTemplateResponse
        .builder

        .build

    def updateEmailIdentityPolicyRequest(
      emailIdentity: Option[String] = None,
      policyName: Option[String] = None,
      policy: Option[String] = None
    ): UpdateEmailIdentityPolicyRequest =
      UpdateEmailIdentityPolicyRequest
        .builder
        .ifSome(emailIdentity)(_.emailIdentity(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def updateEmailIdentityPolicyResponse(

    ): UpdateEmailIdentityPolicyResponse =
      UpdateEmailIdentityPolicyResponse
        .builder

        .build

    def updateEmailTemplateRequest(
      templateName: Option[String] = None,
      templateContent: Option[EmailTemplateContent] = None
    ): UpdateEmailTemplateRequest =
      UpdateEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateContent)(_.templateContent(_))
        .build

    def updateEmailTemplateResponse(

    ): UpdateEmailTemplateResponse =
      UpdateEmailTemplateResponse
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
